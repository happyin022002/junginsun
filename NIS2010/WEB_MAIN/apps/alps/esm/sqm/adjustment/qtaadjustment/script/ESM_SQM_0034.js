/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0034.js
*@FileTitle      : QTA Edit
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.08
*@LastModifier   : JEONGMIN CHO
*@LastVersion    : 1.0
* 2013.05.08 JEONGMIN CHO
* 1.0 Creation
* 2013.11.11 박은주 [CHM-201327449] SQM 몇몇 화면 내 틀 고정 기능 추가
* 2013.12.10 PEJ [CHM-201328059] QTA Edit_Office Add 팝업 추가
* 2014.01.16 박은주 [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2015.01.22 김용습 [CHM-201533807] Rev Month 기준으로 관련 화면의 period를 변경
* 2015.04.17 이혜민 [CHM-201535052] 조회시 G.Decimal 데이터 정상적으로 조회되도록 수정  
* 2015.07.09 김용습 [CHM-201536817] [CSR 전환건] Final QTA Adjustment > Post QTA Adjustment > QTA Edit for IAS Sector 화면 내 Week 조회 로직 수정
* 2015.08.10 김용습 [CHM-201537166] [CSR 전환건] QTA Edit 화면 내 Portion Linked 중 "A"일때 G.RPB 칼럼 활성화되도록 화면 변경
* 2016.04.22 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
* 2016.06.17 SELCMI로 접속시 IAS Trade에 대해서 Creation 가능하도록 로직 수정 
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/


/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_SQM_0034 : ESM_SQM_0034 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0034() {
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

loadExcelVal = "N";

//CalcuLogic
var gRev;
var paCm;
var raCm ;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
    var sheetObject = sheetObjects[0];
    var formObj     = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {
            case "btn_Retrieve":
            	
            	if(ComGetObjValue(formObj.f_trd_cd) == "IAS"){
            		if(ComGetObjValue(formObj.f_bse_yr) < 2016){
            			ComShowCodeMessage('SQM00067');
            		}else if(ComGetObjValue(formObj.f_bse_yr) == 2016){
            			if(ComGetObjValue(formObj.f_bse_qtr_cd) == "1Q"){ 
            				ComShowCodeMessage('SQM00067');
            			}else if(ComGetObjValue(formObj.f_bse_qtr_cd) == "2Q"){
            				ComShowCodeMessage('SQM00067');
            			}else{
            				doActionIBSheet(sheetObject, formObj, IBSEARCH);
            			}
            		}else{
            			doActionIBSheet(sheetObject, formObj, IBSEARCH);
            		}
            	}else{
            		doActionIBSheet(sheetObject, formObj, IBSEARCH);
            	}
            	
                break;
            case "btn_Save":
                doActionIBSheet(sheetObject, formObj, IBSAVE);
                break;
            case "btn_Creation":
                doActionIBSheet(sheetObject, formObj, MULTI01);
                break;
            case "btn_Downexcel":
                doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
                break;
            case "btn_Loadexcel":
                doActionIBSheet(sheetObject,formObj,IBLOADEXCEL);
                break;
            case "btn_ofcAdd":
            	doActionIBSheet(sheetObject,formObj,"OfficeAdd");
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
        axon_event.addListenerForm('click', 'f_decimal_flg_click', document.form); //- 클릭시
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

                var HeadTitle1 =  "STS|SEQ|Year|Quarter|Office View|Portion Linked|Trade||Lane Bound|Trade Direction|Sub Trade|R.Lane|VVD||||Month|Week|Supply|RHQ|Office|Load|G.RPB|G.REV|CM(PA)|CMCB(PA)|CM(RA)|CMCB(RA)";


                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(ComCountHeadTitle(HeadTitle1), 2, 0, true);

                // 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
                InitHeadMode(true, false, false, true, false, false);

                // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                // 전체 높이 설정
                style.height = GetSheetHeight(19);

                gRev = "|grs_rpb_rev|*|lod_qty|";
                paCm = "(|grs_rpb_rev|*|lod_qty|)-(|pa_cm_uc_amt|*|lod_qty|)";
                raCm = "(|grs_rpb_rev|*|lod_qty|)-(|ra_cm_uc_amt|*|lod_qty|)";

                // 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
                InitDataProperty(0, cnt++,  dtStatus,       30, daCenter,   true,   "ibflag",       false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtSeq,          30, daCenter,   true,   "seq",          false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         50, daCenter,   true,   "bse_yr",       false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         60, daCenter,   true,   "bse_qtr_cd",   false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         80, daCenter,   true,   "ofc_vw_cd",    false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         90, daCenter,   true,   "sqm_cng_tp_cd",false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         50, daCenter,   true,   "trd_cd",       false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtHidden,       60, daCenter,   true,   "conv_dir_cd",  false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         80, daCenter,   true,   "dir_cd",       false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         100,daCenter,   true,   "hul_bnd_cd",   false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         70, daCenter,   true,   "sub_trd_cd",   false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         60, daCenter,   true,   "rlane_cd",     false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         80, daCenter,   true,   "vvd",          false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtHidden,       40, daCenter,   true,   "vsl_cd",       false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtHidden,       40, daCenter,   true,   "skd_voy_no",   false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtHidden,       40, daCenter,   true,   "skd_dir_cd",   false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         50, daCenter,   true,   "bse_mon",      false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         50, daCenter,   true,   "bse_wk",       false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         55, daCenter,   true,   "fnl_bsa_capa", false,  "",     dfInteger,  0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         60, daCenter,   true,   "rhq_cd",       false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         60, daCenter,   true,   "rgn_ofc_cd",   false,  "",     dfNone,     0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         80, daRight,    true,   "lod_qty",      false,  "",     dfInteger,  0,  true,   true);
                if(loadExcelVal == "Y"){ // Decimal
                	InitDataProperty(0, cnt++,  dtData,         150,daRight,    true,   "grs_rpb_rev",  false,  "",     dfFloat,     13, true,   true);
                }else{
                	InitDataProperty(0, cnt++,  dtData,       100,daRight,    true,   "grs_rpb_rev",  false,  "",     dfInteger,     0, true,   true);
                }
                InitDataProperty(0, cnt++,  dtData,         110,daRight,    true,   "g_rev",        false,  gRev,   dfInteger,  0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         110,daRight,    true,   "pa_cm",        false,  paCm,   dfInteger,  0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         80, daRight,    true,   "pa_cm_uc_amt", false,  "",     dfInteger,  0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         110,daRight,    true,   "ra_cm",        false,  raCm,   dfInteger,  0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,         80, daRight,    true,   "ra_cm_uc_amt", false,  "",     dfInteger,  0,  false,  false);
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
    period_change_based_on_rev_month();
    setTradeCombo();
    
    if(comboObjects[11].Code() != ""){ // 화면 첫 로딩 시에는 해당 로직 타지 않게 하기 위해
    	setLaneCombo();
    }
}

/**
 * f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
 */
function f_bse_qtr_cd_OnChange(obj, value, text) {
    var formObj = document.form;
    period_change_based_on_rev_month();
    setTradeCombo();
    
    if(comboObjects[11].Code() != ""){ // 화면 첫 로딩 시에는 해당 로직 타지 않게 하기 위해
    	setLaneCombo();
    }
    
    doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
}


/**
* onChange event
* f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
*/
function f_trd_cd_OnChange(obj, value, text) {
	if(comboObjects[2].Code() != ""){ // 화면 첫 로딩 시에는 이 로직이 여러번 타서, 한번만 타도록 조건을 넣음
    	setLaneCombo();
    }
}


/**
 * onChange event
 * f_rhq_cd 바뀌었을때  f_rgn_ofc_cd 콤보조회
 */
function f_rhq_cd_OnChange(obj, value, text) {
    var formObj = document.form;
    if(value!="All"){
        var param = "f_cmd=" + SEARCH01
        + "&code_name=office"
        + "&code_param=" + value
        + "&all_flag=All";  // Trade

        var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
        ComXml2ComboItem(xmlStr, formObj.f_rgn_ofc_cd, "code", "name");

    }else{
        formObj.f_rgn_ofc_cd.RemoveAll();
        formObj.f_rgn_ofc_cd.InsertItem(0, "All", "All");

    }
    comboObjects[6].Index = 0;
}

function f_rlane_cd_OnChange(){
	if(comboObjects[10].Code() != ""){ // 화면 첫 로딩 시에는 해당 로직 타지 않게 하기 위해
		doActionIBSheet(sheetObjects[0], document.form, SEARCH03); //Week 콤보 세팅
    }
}

function f_dir_cd_OnChange(){
	if(comboObjects[11].Code() != ""){ // 화면 첫 로딩 시에는 해당 로직 타지 않게 하기 위해
		doActionIBSheet(sheetObjects[0], document.form, SEARCH03); //Week 콤보 세팅
    }
}

function f_trd_dir_OnChange(){
	 doActionIBSheet(sheetObjects[0], document.form, SEARCH03); //Week 콤보 세팅
}

/**
 * f_bse_yr, f_bse_qtr_cd, f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
 */
function setLaneCombo() {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	var param    = "";

    var bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
    var bse_yr     = ComGetObjValue(formObj.f_bse_yr);
    var trd_cd     = ComGetObjValue(formObj.f_trd_cd);
    var rlane_cd     = ComGetObjValue(formObj.f_rlane_cd);
	
	if ( trd_cd != "All" && trd_cd != "" ) {
	 	param = "f_cmd=" + SEARCH01
	     + "&code_name=adjLane"
	     + "&code_param= Q" + "|" + bse_yr + "|" + bse_qtr_cd + "|" + trd_cd
	     + "&all_flag=All";	// Trade

		var sXml = sheetObj.GetSearchXml("CommonGS.do",param);
		ComXml2ComboItem(sXml, formObj.f_rlane_cd, "code", "name");
		// 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
		var rlane_index = SearchIndex(formObj.f_rlane_cd, rlane_cd);
		formObj.f_rlane_cd.Index = rlane_index;
	} else {
		formObj.f_rlane_cd.RemoveAll();
		formObj.f_rlane_cd.InsertItem(0, "All", "All");
		formObj.f_rlane_cd.Index = 0;
	}
	
	if(comboObjects[10].Code() != ""){ // 화면 첫 로딩 시에는 해당 로직 타지 않게 하기 위해
		doActionIBSheet(sheetObjects[0], document.form, SEARCH03); //Week 콤보 세팅
    }
}

/**
 * f_bse_yr, f_bse_qtr_cd  바뀌었을때 f_trd_cd 콤보조회
 */
function setTradeCombo() {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	var param    = "";

    var bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
    var bse_yr     = ComGetObjValue(formObj.f_bse_yr);
    var trd_cd     = ComGetObjValue(formObj.f_trd_cd);
	

 	param = "f_cmd=" + SEARCH01
     + "&code_name=trade"
     + "&code_param= " + bse_yr + "" + bse_qtr_cd
     + "&all_flag=";	// Trade

	var sXml = sheetObj.GetSearchXml("CommonGS.do",param);
	var arrXml = sXml.split("|$$|");
	if (arrXml.length > 0) {
		ComXml2ComboItem(sXml, formObj.f_trd_cd, "code", "name");
		// 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
		var trd_index = SearchIndex(formObj.f_trd_cd, trd_cd);
		formObj.f_trd_cd.Index = trd_index;
		
		if(login_ofc_cd == "SELCMI"){ // 로그인 오피스가 SELCMI일때는 Trade콤보에 IAS만 보여줌
			var splitXml = sXml.split("☜☞☜☞");
			var tradeCodes = new Array();
			for(i=1,j=0; i<splitXml.length; i++,j++){
				tradeCodes[j] = splitXml[i].substring(0,3);
				if(tradeCodes[j] != 'IAS'){
					formObj.f_trd_cd.DeleteItem(tradeCodes[j]);
				}
			}
		}
		
	} else {
		formObj.f_trd_cd.RemoveAll();
	}
}

 /**
  * f_gubun가 체크될때 direction콤보 change
  */
 function obj_click() {
    var formObj = document.form;

    if(formObj.f_gubun.checked){
            trd_dir.style.display = "inline";
            dir_cd.style.display = "none";
            document.all("div_dir").innerHTML = "Trade Dir.";
    }else{
            trd_dir.style.display = "none";
            dir_cd.style.display = "inline";
            document.all("div_dir").innerHTML = "Lane Bound";
    }
    
    if(window.event.srcElement.getAttribute("name") != "f_vsl_cd" &&
       window.event.srcElement.getAttribute("name") != "f_skd_voy_no" &&
       window.event.srcElement.getAttribute("name") != "f_skd_dir_cd"){
    	doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
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

            var sXml   = sheetObj.GetSearchXml("ESM_SQM_0034GS.do", FormQueryString(formObj));
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
                ComXml2ComboItem(arrXml[4], formObj.f_trd_cd, "code", "name");
            if (arrXml.length > 5)
                ComXml2ComboItem(arrXml[5], formObj.f_rhq_cd, "code", "name");
            if (arrXml.length > 6)
                ComXml2ComboItem(arrXml[6], formObj.f_dir_cd, "code", "name");
            if (arrXml.length > 7){
                ComXml2ComboItem(arrXml[7], formObj.f_sqm_cng_tp_cd, "code", "name");
            }
            if (arrXml.length > 8)
                ComXml2ComboItem(arrXml[8], formObj.f_trd_dir, "code", "name");
            
            if(login_ofc_cd == "SELCMI"){ // 로그인 오피스가 SELCMI일때는 Trade콤보에 IAS만 보여줌
    			var splitXml = arrXml[4].split("☜☞☜☞");
    			var tradeCodes = new Array();
    			for(i=1,j=0; i<splitXml.length; i++,j++){
    				tradeCodes[j] = splitXml[i].substring(0,3);
    				if(tradeCodes[j] != 'IAS'){
    					formObj.f_trd_cd.DeleteItem(tradeCodes[j]);
    				}
    			}
    		}

            ComOpenWait(false);
            break;

        case SEARCH01:          // Month 콤보세팅
            formObj.f_cmd.value = SEARCH01;
            var sXml   = sheetObj.GetSearchXml("ESM_SQM_0034GS.do", FormQueryString(formObj));
            var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
            var arrXml = sXml.split("|$$|");

            if (arrXml.length > 0)
                ComXml2ComboItem(arrXml[0], formObj.f_to_mon, "code", "name");
//            if (arrXml.length > 1)
//                ComXml2ComboItem(arrXml[1], formObj.f_to_wk, "code", "name"); // week 콤보 세팅은 SEARCH03으로 옮김
            
            if(comboObjects[3].Code() == ""){
            	formObj.f_to_wk.InsertItem(0, "All", "All");
            }
            
            comboObjects[3].Index = 0;
            comboObjects[2].Index = 0;
            break;
            
        case SEARCH03:          // Week 콤보세팅
            formObj.f_cmd.value = SEARCH03;
            var sXml   = sheetObj.GetSearchXml("ESM_SQM_0034GS.do", FormQueryString(formObj));
            
            var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
            var arrXml = sXml.split("|$$|");

            if (arrXml.length > 0){
            	comboObjects[3].RemoveAll();
            	ComXml2ComboItem(arrXml[0], formObj.f_to_wk, "code", "name");
            }

            comboObjects[3].Index = 0;
            break;

        case MULTI01:          //CMCB Adjust Creationt시에
            if (ComShowConfirm (ComGetMsg("SQM00009")) != 1) {
                return false;
            }
            sheetObj.WaitImageVisible = false;
            ComOpenWait(true);
            ComSetSearchParams("f_cmd", MULTI01);
            var sXml = sheetObjects[0].GetSaveXml("ESM_SQM_0034GS.do", searchParams);
            var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
            ComOpenWait(false);
            if(State != "S"){
                ComShowMessage(ComResultMessage(sXml));
                return false;
            }else {
                ComShowCodeMessage('SQM00010','Data');
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            }
            break;

        case IBSEARCH:          //화면 조회시
            sheetObj.WaitImageVisible = false;
            ComOpenWait(true);

            formObj.f_cmd.value = SEARCH;
            loadExcelVal = (formObj.f_decimal_flg.checked == 1)?"Y":"N"; //자식창 inisheet시에 decimal히든 여부 설정
            searchParams = FormQueryString(formObj);
            searchParams= searchParams+ "&f_decimal_flg=" +loadExcelVal;
            var sXml = sheetObj.GetSearchXml("ESM_SQM_0034GS.do", searchParams);

            // Sheet를 초기화한다.
            sheetObj.Redraw = false;
            sheetObj.RemoveAll();
            sheetObj.Reset();
            initSheet(sheetObj, 1);
            sheetObj.Redraw = true;
            // data를 로딩한다.
            //-------------------------
            sheetObj.LoadSearchXml(sXml);
            sheetObj.RemoveEtcData();                          // ETC 데이타 삭제
            //-------------------------

            if (sheetObj.SearchRows == 0) {
                toggleButtons("INIT");
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
            var sXml = sheetObjects[0].GetSaveXml("ESM_SQM_0034GS.do", searchParams + "&" +sParam);
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
            loadExcelTotFlg    = false;     // 화면에 Total Row 존재 여부

            loadExcelExField   = "|conv_dir_cd|hul_bnd_cd|vsl_cd|skd_voy_no|skd_dir_cd|bse_mon|bse_wk|lod_qty|grs_rpb_rev|g_rev|pa_cm|ra_cm|";     // 비교 제외 필드
            loadExcelAplyField = "|lod_qty|grs_rpb_rev|";               // 반영 필드

            var rtn = window.showModalDialog("ESM_SQM_1001.do?" + searchParams, window, "dialogHeight:630px;dialogWidth:1000px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");

            break;
            
        case "OfficeAdd":
			// sheet에 변경사항이 있는지 확인
			if (sheetObj.isDataModified == true) {
				ComShowCodeMessage("SQM00017");
		        return false;
		    }
			ComSetSearchParams("f_cmd", "");
			var rtn = window.showModalDialog("ESM_SQM_0045.do?" + searchParams + "&div_period=" + document.getElementById("div_period").innerHTML, window, "dialogHeight:550px;dialogWidth:800px;center:yes;resizable:no;scroll:no;status:no;unadorned:yes;");
			
			// IAS Office Add 후 그리드를 다시 조회한다.
			if(rtn == "S")
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
        	
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
//        sheetObj.RowEditable(row) = false;
    	sheetObj.CellEditable(row,"lod_qty") = false;
    }
 }

  /**
  * 화면의 모든 버튼들의 Enable/Disable 을 처리
  */
 function toggleButtons(step) {
    switch (step) {
        case "INIT":
            ComBtnDisable("btn_Save");
            ComBtnDisable("btn_Creation");
            ComBtnDisable("btn_Downexcel");
            ComBtnDisable("btn_Loadexcel");
            ComBtnDisable("btn_ofcAdd");
            break;

        case "SEARCH":
            ComBtnEnable("btn_Save");
            ComBtnEnable("btn_Downexcel");
            ComBtnEnable("btn_Loadexcel");
            ComBtnEnable("btn_Creation");
            if (ComGetSearchParams("f_trd_cd") == "IAS") {
            	ComBtnEnable("btn_ofcAdd");
            } else {
            	ComBtnDisable("btn_ofcAdd");
            }
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

        case IBSAVE:  // save시
            var upRow = sheetObj.FindStatusRow("U");
            var uRow = upRow.split(";");
            var sMsg = "";
            for(var i=0;i<uRow.length-1;i++){
            	// RPB 값을 제대로 인식하지 못하는 경우가 존재 eval로 실수로 변환하고 이것을 parseInt로 정수로 변환하여 비교하도록 변경
                if(sheetObj.CellValue(uRow[i],"lod_qty")!=0 && sheetObj.CellValue(uRow[i],"grs_rpb_rev")==0){
                    sMsg = sMsg + "\n" + sheetObj.CellValue(uRow[i],"trd_cd")
                        + "-" + sheetObj.CellValue(uRow[i],"rlane_cd")
                        +"-" + sheetObj.CellValue(uRow[i],"dir_cd")
                        +"-" + sheetObj.CellValue(uRow[i],"bse_wk")
                        +"-" + sheetObj.CellValue(uRow[i],"rhq_cd")
                        +"-" + sheetObj.CellValue(uRow[i],"rgn_ofc_cd");
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