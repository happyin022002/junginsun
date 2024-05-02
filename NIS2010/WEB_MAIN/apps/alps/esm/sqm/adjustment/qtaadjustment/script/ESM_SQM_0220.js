/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0220.js
*@FileTitle      : QTA Edit for IAS Sector
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.23
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.23 SQM USER
* 1.0 Creation
* History
* 2014.06.20 IAS Sector Sales - Main, Sector 구분자 추가를 위한 화면 변경
* 2014.07.04 Load Excel 시 오류 수정
* 2014.08.25 팝업 오픈시 부모창 조회조건을 자동세팅하도록 수정
* 2015.01.22 Rev Month 기준으로 관련 화면의 period를 변경
* 2015.07.09 [CSR 전환건] Final QTA Adjustment > Post QTA Adjustment > QTA Edit for IAS Sector 화면 내 Week 조회 로직 수정
* 2016.02.05 SQM Planning 도중 & Planning 완료 후 노선, P/F Group, Sector 추가 로직 Process 변경
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/


/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_SQM_0220 : ESM_SQM_0220 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0220() {
    this.processButtonClick     = tprocessButtonClick;
    this.setSheetObject         = setSheetObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;
    this.initControl            = initControl;
    this.doActionIBSheet        = doActionIBSheet;
    this.setTabObject           = setTabObject;
    this.validateForm           = validateForm;
}

/* 개발자 작업  */

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
    var sheetObject = sheetObjects[0];
    var formObj     = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {
            case "btn_Retrieve":
                doActionIBSheet(sheetObject, formObj, IBSEARCH);
                break;
            case "btn_Save":
                doActionIBSheet(sheetObject, formObj, IBSAVE);
                break;
            case "btn_CmcbCreation":
                doActionIBSheet(sheetObject, formObj, MULTI01);
                break;
            case "btn_Downexcel":
                doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
                break;
            case "btn_Loadexcel":
                doActionIBSheet(sheetObject,formObj,IBLOADEXCEL);
                break;
            case "btn_laneOfc":
				var sUrl = "ESM_SQM_0008.do?";
                sUrl += "pop_mode=Y&"+searchParams;
                ComOpenWindowCenter(sUrl, "", 1020, 682, false);
            	break;
            case "btn_sctrOfc":
            	var sUrl = "ESM_SQM_0204.do?";
                sUrl += "pop_mode=Y&"+searchParams;
				ComOpenWindowCenter(sUrl, "", 1020, 682, false);
            	break;
            case "btn_pairAdd":
            	var sUrl = "ESM_SQM_0221.do?"+searchParams;
            	var rtn = ComOpenWindowCenter(sUrl, "ESM_SQM_0221", 890, 400, true);
				//팝업 닫힌 후 재조회
				if(rtn == "OK") doActionIBSheet(sheetObject, formObj, IBSEARCH);
            	break;	
            case "btn_ofcAdd":
            	var sUrl = "ESM_SQM_0222.do?"+searchParams;
				var rtn = ComOpenWindowCenter(sUrl, "ESM_SQM_0222", 890, 400, true);
				//팝업 닫힌 후 재조회
				if(rtn == "OK") doActionIBSheet(sheetObject, formObj, IBSEARCH);
            	break;

        }
    } catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(ComGetMsg("COM12111", "", ""));
        } else {
            ComShowMessage(e);
        }
    }
}

/**
 * IBSheet Object 를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * IBSheet Object 를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj){
    comboObjects[comboCnt++] = combo_obj;
}

function loadPage(){
    var formObj = document.form;
    loadingMode = true;
    for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }
    doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);

    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
    initControl();

    toggleButtons("INIT");
    loadingMode = false;
}

 /**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 **/
 function obj_keypress(){
    switch(event.srcElement.dataformat){
        case "int":
            //숫자만입력하기
            ComKeyOnlyNumber(event.srcElement);
            break;
        case "engup":
            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
            ComKeyOnlyAlphabet('upper');
            break;
        default:
            //숫자만입력하기(정수,날짜,시간)
            ComKeyOnlyNumber(event.srcElement);
    }
}


 /**
  * 조회조건 입력할 때 처리
  */
 function obj_KeyUp() {
      var formObject = document.form;
      var srcName = window.event.srcElement.getAttribute("name");
      var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
      var srcValue = window.event.srcElement.getAttribute("value");
      if (ComChkLen(srcValue, srcMaxLength) == "2") {
        ComSetNextFocus();
      }
 }

 function initControl(){
        axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
        axon_event.addListenerFormat('keypress', 'obj_keypress', document.form); //- 키보드 입력할때
        axon_event.addListenerForm  ('click', 'obj_click',   document.form);
 }

 var initSheetFn = function initSheet(sheetObj,sheetNo) {
    var cnt = 0;

    switch(sheetNo) {
        case 1:     //sheet1 init
            with (sheetObj) {
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;  //msNone; //msHeaderOnly //msPrevColumnMerge;

                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 9, 100);

                var HeadTitle1 =  "STS|SEQ|Year|Quarter|Office View|Trade|Sub Trade|IAS Region|R.Lane|Lane Bound|Trade Direction|Month|Week|VVD|P/F SKD Group|vsl_cd|skd_voy_no|skd_dir_cd|Supply" +
                		"|RHQ|Office|POL|POD|Main/Sector|Load|G.RPB|G.REV|CM Cost(PA)|CM Cost(RA)|CMCB(PA)|CMCB(RA)|CM(PA)|CM(RA)|CMPB(PA)|CMPB(RA)|sqm_cng_tp_cd";


                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(ComCountHeadTitle(HeadTitle1), 2, 0, true);

                // 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
                InitHeadMode(true, false, false, true, false, false);

                // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                // 전체 높이 설정
                style.height = GetSheetHeight(18);
                
                // 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
                InitDataProperty(0, cnt++,  dtStatus,       30, daCenter,   true,   "ibflag",       false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtSeq,          30, daCenter,   true,   "seq",          false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         50, daCenter,   true,   "bse_yr",       false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         60, daCenter,   true,   "bse_qtr_cd",   false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         80, daCenter,   true,   "ofc_vw_cd",    false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         50, daCenter,   true,   "trd_cd",       false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         70, daCenter,   true,   "sub_trd_cd",   false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         70, daCenter,   true,   "ias_rgn_cd",   false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         60, daCenter,   true,   "rlane_cd",     false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         80, daCenter,   true,   "dir_cd",       false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         100,daCenter,   true,   "hul_bnd_cd",   false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         50, daCenter,   true,   "bse_mon",      false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         50, daCenter,   true,   "bse_wk",       false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         80, daCenter,   true,   "vvd",          false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         90, daCenter,   true,   "pf_grp_cd",    false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtHidden,       40, daCenter,   true,   "vsl_cd",       false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtHidden,       40, daCenter,   true,   "skd_voy_no",   false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtHidden,       40, daCenter,   true,   "skd_dir_cd",   false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         55, daCenter,   true,   "fnl_bsa_capa", false,  "",     dfInteger,  0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         60, daCenter,   true,   "rhq_cd",       false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         60, daCenter,   true,   "rgn_ofc_cd",   false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         60, daCenter,   true,   "pol_cd",   	false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         60, daCenter,   true,   "pod_cd",   	false,  "",     dfNone,     0,  false,  false);
    			InitDataProperty(0,	cnt++,	dtData,			90, daCenter,	true,	"sqm_mn_sctr_flg",		false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0, cnt++,  dtAutoSum,      80, daRight,    true,   "lod_qty",      false,  "",     dfInteger,  0,  true,   true);
                InitDataProperty(0, cnt++,  dtData,       	110,daRight,    true,   "grs_rpb_rev", 	false,  "",     dfInteger,  13, true,   true);
                InitDataProperty(0, cnt++,  dtAutoSum,      110,daRight,    true,   "grs_rev",      false,  "|grs_rpb_rev|*|lod_qty|",   dfInteger,  0,  false,  false);
                InitDataProperty(0,	cnt++,	dtAutoSum,		100,daRight,	true,	"pa_cm_cost",	false,	"|pa_cm_uc_amt|*|lod_qty|",		dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		100,daRight,	true,	"ra_cm_cost",	false,	"|ra_cm_uc_amt|*|lod_qty|",		dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			100,daRight,	true,	"pa_cm_uc_amt",	false,	"",		dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			100,daRight,	true,	"ra_cm_uc_amt",	false,	"",		dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		100,daRight,	true,	"pa_cm",		false,	"|grs_rev|-|pa_cm_cost|",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		100,daRight,	true,	"ra_cm",		false,	"|grs_rev|-|ra_cm_cost|",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			100,daRight,	true,	"pa_cmpb",		false,	"(|grs_rev|-|pa_cm_cost|)/|lod_qty|",		dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			100,daRight,	true,	"ra_cmpb",		false,	"(|grs_rev|-|ra_cm_cost|)/|lod_qty|",		dfInteger,	0,	false,	false);
				InitDataProperty(0, cnt++,  dtHidden,     	90, daCenter,   true,   "sqm_cng_tp_cd",false,  "",     dfNone,     0,  false,  false);

				RangeBackColor(0, 24, 0, 26) = RgbColor(203,210,248);
				RangeBackColor(0, 31, 0, 34) = RgbColor(203,210,248);
            }
            break;
    }
}

/**
* 멀티콤보 항목을 설정한다.
*/
function initCombo(comboObj, comboId) {
    switch(comboObj.id) {
        case "f_bse_yr":
        case "f_bse_qtr_cd":
            with (comboObj) {
                DropHeight = 300;
            }
            break;
        case "f_ofc_vw_cd":
            with (comboObj) {
                DropHeight = 300;
                Index      = 1;
            }
            break;
        case "f_rlane_cd":
			with (comboObj) {
				DropHeight = 300;
				InsertItem(0, '', '');
				Index = 0;
			}
			break;
        case "f_pf_grp_cd":
            with (comboObj) {
                SetTitle("R/Lane|Group");
                SetColAlign("center|center");
                SetColWidth("60|50");
            }
            break;

        default:
            with (comboObj) {
                DropHeight = 300;
                Index      = 0;
            }
            break;
    }
}

/**
 * f_bse_yr가 바뀌었을때 period 의 year 변경
 */
function f_bse_yr_OnChange(obj, value, text) {
    var formObj = document.form;
    period_change_based_on_rev_month();

    if (value < "2017" && ComGetObjValue(document.form.f_bse_qtr_cd) < "3Q" && sheetObjects[0].TotalRows > 0) {
    	ComBtnEnable("btn_CmcbCreation");
    } else {
    	ComBtnDisable("btn_CmcbCreation");
    }
   

  //Week 콤보 세팅
	if(comboObjects[11].Code != ""){ // R/Lane 콤보 값이 null 이 아닐 때(화면 첫 로딩 시에는 안타게 함)
		doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
	}
}

/**
 * f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
 */
function f_bse_qtr_cd_OnChange(obj, value, text) {
    var formObj = document.form;
    period_change_based_on_rev_month();

    if (ComGetObjValue(document.form.f_bse_yr) < "2017" && value < "3Q" && sheetObjects[0].TotalRows > 0) {
    	ComBtnEnable("btn_CmcbCreation");
    } else {
    	ComBtnDisable("btn_CmcbCreation");
    }

    doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
    
  //Week 콤보 세팅
	if(comboObjects[11].Code != ""){ // R/Lane 콤보 값이 null 이 아닐 때(화면 첫 로딩 시에는 안타게 함)
		doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
	}
}


/**
 * onChange event
 * f_rhq_cd 바뀌었을때  f_rgn_ofc_cd 콤보조회
 */
function f_rhq_cd_OnChange(obj, value, value) {

    var formObj = document.form;
    var rhqCd  = value; // rhq code
    if(value!="All"){
        var param = "f_cmd=" + SEARCH01
        + "&code_name=office"
        + "&code_param=" + rhqCd
        + "&all_flag=All";  // Trade

        var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
        ComXml2ComboItem(xmlStr, formObj.f_rgn_ofc_cd, "code", "name");
        formObj.f_rgn_ofc_cd.Index = 0;
    }else{
        formObj.f_rgn_ofc_cd.RemoveAll();
        formObj.f_rgn_ofc_cd.InsertItem(0, "All", "All");
        formObj.f_rgn_ofc_cd.Index = 0;
    }
    comboObjects[6].Index = 0;
}


/**
* onChange event
* f_sub_trd_cd 바뀌었을때  f_lane_cd 콤보조회
*/	
function f_sub_trd_cd_OnChange(obj, value, text) {
	setLaneCombo();
 }


/**
* onChange event
* f_dir_cd 바뀌었을때  week 콤보 새로 세팅
*/	
function f_dir_cd_OnChange(obj, value, text) {
	//Week 콤보 세팅
	if(comboObjects[11].Code != ""){ // R/Lane 콤보 값이 null 이 아닐 때(화면 첫 로딩 시에는 안타게 함)
		doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
	}
 }


/**
* onChange event
* f_hul_bnd_cd 바뀌었을때  week 콤보 새로 세팅
*/	
function f_hul_bnd_cd_OnChange(obj, value, text) {
	//Week 콤보 세팅
	if(comboObjects[11].Code != ""){ // R/Lane 콤보 값이 null 이 아닐 때(화면 첫 로딩 시에는 안타게 함)
		doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
	}
 }


/**
* onChange event
* f_ias_rgn_cd 바뀌었을때  f_lane_cd 콤보조회
*/	
function f_ias_rgn_cd_OnChange(obj, value, text) {
	setLaneCombo();
}

/**
 *  f_sub_trd_cd, f_ias_rgn_cd 변경시 f_rlane_cd를 변경한다.
 */
function setLaneCombo(){
 	var formObj = document.form;
 	var sub_trd_cd = ComGetObjValue(formObj.f_sub_trd_cd);
 	var ias_rgn_cd = ComGetObjValue(formObj.f_ias_rgn_cd);
 	
 	if ( (sub_trd_cd != ""  && sub_trd_cd != "All" ) || (ias_rgn_cd != "" && ias_rgn_cd != "All")  ) {
	 	var param = "f_cmd=" + SEARCH01
	    + "&code_name=rLane"
	    + "&code_param=IAS|"+formObj.f_sub_trd_cd.Code+"|"+formObj.f_ias_rgn_cd.Code
	    + "&all_flag=";
	
	 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, formObj.f_rlane_cd, "code", "name");
 	} else {
		formObj.f_rlane_cd.RemoveAll();
 	}
}

/**
 * f_rlane_cd 바뀌었을때 POL, POD 변경
 */
function f_rlane_cd_OnChange(obj, value, text) {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	
	if(value != "" && value != "All") {
		var code_name  = new Array("polCdSector", "podCdSector");
		var code_param = new Array(value, value);
		var all_flag   = new Array("All", "All");
	
		var param = "f_cmd="		+ SEARCH02
		          + "&code_name="	+ code_name
		          + "&code_param="	+ code_param
		          + "&all_flag="	+ all_flag
		          + "&" + FormQueryString(formObj);	
		var sXml   = sheetObj.GetSearchXml("CommonGS.do", param);
		var arrXml = sXml.split("|$$|");
	
		if (arrXml.length > 0) {
			ComXml2ComboItem(arrXml[0], formObj.f_pol_cd, "code", "name");
			formObj.f_pol_cd.Index = 0;
		}
		if (arrXml.length > 1) {
			ComXml2ComboItem(arrXml[1], formObj.f_pod_cd, "code", "name");
			formObj.f_pod_cd.Index = 0;
		}
	
        var param2 = "f_cmd="   + SEARCH01
        + "&code_name=pfGroup"
        + "&code_param="    + value
        + "&all_flag="
        + "&" + FormQueryString(formObj);

        var sXml2   = sheetObj.GetSearchXml("CommonGS.do", param2);
        var arrXml2 = sXml2.split("|$$|");

        if (sXml2.length > 0) {
            ComXml2ComboItem(arrXml2[0], formObj.f_pf_grp_cd, "code", "name");
            formObj.f_pf_grp_cd.InsertItem(0, "All|All", "All");
            formObj.f_pf_grp_cd.Index2 = 0;
        }
        
        
	}
	
	//Week 콤보 세팅
	if(value != ""){
		doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
	}
}

 /**
  * f_trd_dir가 체크될때 direction콤보 change
  */
 function obj_click() {
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	with(formObj) {
		switch(srcName) {
			case "f_trd_dir":
				if ( f_trd_dir.checked ) {
					div_dir.innerHTML         = "Trade Dir.";
					div_trd_dir.style.display = "inline";
		      		div_dir_cd.style.display  = "none";
				} else {
					div_dir.innerHTML         = "Lane Bound";
					div_trd_dir.style.display = "none";
					div_dir_cd.style.display  = "inline";
				}
				
				//Week 콤보 세팅
				if(comboObjects[11].Code != ""){ // R/Lane 콤보 값이 null 이 아닐 때(화면 첫 로딩 시에는 안타게 함)
					doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
				}
				break;
		}
	}	
 }

/**
 * Sheet 관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {
        case IBCLEAR:          // 화면 접속 시
            sheetObj.WaitImageVisible = false;

            ComOpenWait(true);

            formObj.f_cmd.value = INIT;

            var sXml   = sheetObj.GetSearchXml("ESM_SQM_0220GS.do", FormQueryString(formObj));
            var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
            var arrXml = sXml.split("|$$|");

            if (arrXml.length > 0)
                ComXml2ComboItem(arrXml[0], formObj.f_bse_yr, "code", "name");
            if (arrXml.length > 1)
                ComXml2ComboItem(arrXml[1], formObj.f_bse_qtr_cd, "code", "name");
            if (arrXml.length > 2)
                ComSetYearQta(arrXml[2]);
            if (arrXml.length > 3)
                ComXml2ComboItem(arrXml[3], formObj.f_ofc_vw_cd, "code", "name");
            if (arrXml.length > 4)
            	ComXml2ComboItem(arrXml[4], formObj.f_rhq_cd, "code", "name");
            if (arrXml.length > 5)
                ComXml2ComboItem(arrXml[5], formObj.f_sub_trd_cd, "code", "name");
            if (arrXml.length > 6)
                ComXml2ComboItem(arrXml[6], formObj.f_ias_rgn_cd, "code", "name");
            if (arrXml.length > 7)
            	ComXml2ComboItem(arrXml[7], formObj.f_dir_cd, "code", "name");
            if (arrXml.length > 8)
                ComXml2ComboItem(arrXml[8], formObj.f_hul_bnd_cd, "code", "name");
            
            ComOpenWait(false);
            break;

        case SEARCH01:          // Month 콤보셋팅
            formObj.f_cmd.value = SEARCH01;
            var sXml   = sheetObj.GetSearchXml("ESM_SQM_0220GS.do", FormQueryString(formObj));
            
            var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
            var arrXml = sXml.split("|$$|");

            if (arrXml.length > 0)
                ComXml2ComboItem(arrXml[0], formObj.f_to_mon, "code", "name");
//            if (arrXml.length > 1)
//                ComXml2ComboItem(arrXml[1], formObj.f_to_wk, "code", "name"); // week 콤보 세팅은 SEARCH03으로 옮김
            
            if(comboObjects[6].Code() == ""){
            	formObj.f_to_wk.InsertItem(0, "All", "All");
            }

            comboObjects[5].Index = 0;
            break;
            
        case SEARCH03:          // Week 콤보셋팅   	
            formObj.f_cmd.value = SEARCH03;            
            var sXml   = sheetObj.GetSearchXml("ESM_SQM_0220GS.do", FormQueryString(formObj));            
            var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
            var arrXml = sXml.split("|$$|");

            if (arrXml.length > 0){
            	comboObjects[6].RemoveAll();
            	ComXml2ComboItem(arrXml[0], formObj.f_to_wk, "code", "name");
            }

            comboObjects[6].Index = 0;
            break;

        case MULTI01:          //CMCB Adjust Creationt시에
            if (ComShowConfirm (ComGetMsg("SQM00009")) != 1) {
                return false;
            }
            sheetObj.WaitImageVisible = false;
            ComOpenWait(true);
            ComSetSearchParams("f_cmd", MULTI01);
            var sXml = sheetObjects[0].GetSaveXml("ESM_SQM_0220GS.do", searchParams);
            var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
            ComOpenWait(false);
            if(State != "S"){
                ComShowMessage(ComResultMessage(sXml));
                return false;
            }else {
                ComShowCodeMessage('SQM00011','Data');
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            }
            break;

        case IBSEARCH:          //화면 조회시
			if (!validateForm(sheetObj, formObj, sAction)) return;

            sheetObj.WaitImageVisible = false;
            ComOpenWait(true);

            formObj.f_cmd.value = SEARCH;
            searchParams = FormQueryString(formObj);
            var sXml = sheetObj.GetSearchXml("ESM_SQM_0220GS.do", searchParams);
            sheetObj.LoadSearchXml(sXml);

            if (sheetObj.SearchRows == 0) {
                toggleButtons("INIT");
                ComBtnEnable("btn_ofcAdd");
            }else{
                toggleButtons("SEARCH");
            }
           
            ComOpenWait(false);
            break;

        case IBSAVE:          // 화면 저장시
            if (!validateForm(sheetObj, formObj, sAction)) return false;
            if (sheetObj.isDataModified == false) {
                ComShowCodeMessage("SQM00006");
                return false;
            } else if (ComShowConfirm (ComGetMsg("SQM00004")) != 1) {
                return false;
            }
            ComSetSearchParams("f_cmd", MULTI);
            var sParam  = sheetObj.GetSaveString(false, true, "ibflag");
            var sXml = sheetObjects[0].GetSaveXml("ESM_SQM_0220GS.do", searchParams + "&" +sParam);
            var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
            if(State != "S"){
                ComShowMessage(ComResultMessage(sXml));
                return false;
            }else if(State == "S"){
                ComShowCodeMessage('SQM00001','Data');
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            }

            break;

        case IBDOWNEXCEL:       // 엑셀 다운로드
            ComOpenWait(true);
            sheetObj.Down2Excel(-1, false, false, true);
            ComOpenWait(false);
            break;

        case IBLOADEXCEL:       // 엑셀 업로드
            loadExcelRowCnt    = sheetObj.HeaderRows + sheetObj.TotalRows;
            loadExcelTotFlg    = true;     // 화면에 Total Row 존재 여부

            loadExcelExField   = "|vsl_cd|skd_voy_no|skd_dir_cd|fnl_bsa_capa|sqm_cng_tp_cd|lod_qty|grs_rpb_rev|grs_rev|pa_cm_cost|ra_cm_cost|pa_cm|ra_cm|pa_cmpb|ra_cmpb|";     // 비교 제외 필드
            loadExcelAplyField = "|lod_qty|grs_rpb_rev|";               // 반영 필드

            var rtn = window.showModalDialog("ESM_SQM_1001.do?" + searchParams, window, "dialogHeight:630px;dialogWidth:1000px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");
            if(rtn == "S")
				ComShowCodeMessage("SQM00036");
            break;
        	
    }
}

 /**
  *조회 함수를 이용하여 조회가 완료되고 발생하는 Event
  * @param sheetObj
  */
  function sheet1_OnSearchEnd(sheetObj){
    var row = 0;
    // Allocation = QTA Setting 된 경우 해당 Row를 Disable 시킨다.
    while((row = sheetObj.FindText("sqm_cng_tp_cd", "A", row + 1)) > 0){
        sheetObj.RowEditable(row) = false;
    }
    sheetObj.SumText(0, "grs_rpb_rev")      = ComAddComma((sheetObj.SumValue(0, "grs_rev")   / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "pa_cm_uc_amt")      = ComAddComma((sheetObj.SumValue(0, "pa_cm_cost") / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "ra_cm_uc_amt")      = ComAddComma((sheetObj.SumValue(0, "ra_cm_cost") / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "pa_cmpb")      = ComAddComma((sheetObj.SumValue(0, "pa_cm")   / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "ra_cmpb")      = ComAddComma((sheetObj.SumValue(0, "ra_cm")   / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
    sheetObj.SumText(0, "ibflag") = "";
 	sheetObj.SumText(0, "ofc_vw_cd") = "TOTAL";
 }

  /**
  * 화면의 모든 버튼들의 Enable/Disable 을 처리
  */
 function toggleButtons(step) {
    switch (step) {
        case "INIT":
            ComBtnDisable("btn_Save");
            ComBtnDisable("btn_CmcbCreation");
            ComBtnDisable("btn_Downexcel");
            ComBtnDisable("btn_Loadexcel");
            ComBtnDisable("btn_laneOfc");
            ComBtnDisable("btn_sctrOfc");
            ComBtnDisable("btn_pairAdd");
            ComBtnDisable("btn_ofcAdd");
            break;

        case "SEARCH":
            ComBtnEnable("btn_Save");
         //   ComBtnEnable("btn_CmcbCreation");
            if (ComGetObjValue(document.form.f_bse_yr) < "2017" && ComGetObjValue(document.form.f_bse_qtr_cd) < "3Q") {
            	ComBtnEnable("btn_CmcbCreation");
            } else {
            	ComBtnDisable("btn_CmcbCreation");
            }          
            ComBtnEnable("btn_Downexcel");
            ComBtnEnable("btn_Loadexcel");
            ComBtnEnable("btn_laneOfc");
            ComBtnEnable("btn_sctrOfc");
            ComBtnEnable("btn_pairAdd");
            ComBtnEnable("btn_ofcAdd");
            break;
    }
 }

  /**
  * ESM_SQM_1001에서 호출 : cell editable 제어
  */
  function setEditableCellFn(sheetObj,formObj) {
      sheet1_OnSearchEnd(sheetObj);
  }

  /**
  * ESM_SQM_1001에서 호출 : row의 sqm_cng_tp_cd가 'A'일때 load,G.RPB 반영제외
  */
  function rowExceptionFn(sheetObj,row) {
      if(sheetObj.CellValue(row,"sqm_cng_tp_cd") == "A"){
          return false;
      }else{

          return true;
      }
  }

 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj, formObj, sAction){
    switch(sAction) {
    	case IBSEARCH: 
			if(formObj.f_rlane_cd.Code == ""){
				ComShowCodeMessage('SQM00013','R/Lane');
				return false;
			}
			break;
        case IBSAVE:  // save시
            var upRow = sheetObj.FindStatusRow("U");
            var uRow = upRow.split(";");
            var sMsg = "";
            for(var i=0;i<uRow.length-1;i++){
            	// RPB 값을 제대로 인식하지 못하는 경우가 존재 eval로 실수로 변환하고 이것을 parseInt로 정수로 변환하여 비교하도록 변경
                if(sheetObj.CellValue(uRow[i],"lod_qty")!=0 && sheetObj.CellValue(uRow[i],"grs_rpb_rev")==0){
                    sMsg = sMsg + "\n" + sheetObj.CellValue(uRow[i],"trd_cd")
                        + "-" + sheetObj.CellValue(uRow[i],"rlane_cd")
                        + "-" + sheetObj.CellValue(uRow[i],"dir_cd")
                        + "-" + sheetObj.CellValue(uRow[i],"bse_wk")
                        + "-" + sheetObj.CellValue(uRow[i],"rhq_cd")
                        + "-" + sheetObj.CellValue(uRow[i],"rgn_ofc_cd");
                }
            }
            if(sMsg!=""){
                ComShowCodeMessage("SQM00037","Trade-Rlane-Bound-Week-RHQ-Office",sMsg);
                return false;
            }
            break;
    }
    return true;
 }
/* 개발자 작업  끝 */