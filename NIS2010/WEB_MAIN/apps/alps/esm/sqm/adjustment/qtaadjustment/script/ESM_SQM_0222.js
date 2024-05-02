﻿/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0222.js
*@FileTitle      : QTA Edit_Office Add for IAS Sector
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.23
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.23 SQM USER
* 1.0 Creation
* History
* 2014.07.04 이혜민 sheet 내 ALL-Select 기능 추가
* 2014.08.25 이혜민 [CHM-201431601] 팝업 오픈시 부모창 조회조건을 자동세팅하도록 수정
* 2016.01.28 Basic Data Creation for IAS Secotr 화면의 Creation 로직 변경
* 2016.02.05 SQM Planning 도중 & Planning 완료 후 노선, P/F Group, Sector 추가 로직 Process 변경
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
function ESM_SQM_0222() {
    this.processButtonClick     = tprocessButtonClick;
    this.setSheetObject         = setSheetObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;
    this.initControl            = initControl;
    this.doActionIBSheet        = doActionIBSheet;
    this.setTabObject           = setTabObject;
    this.validateForm           = validateForm;
}

/* 개발자 작업   */

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;
var qtaWeekArr = new Array();
qtaWeekArr["1Q"] = new Array(".wk00",".wk13");
qtaWeekArr["2Q"] = new Array(".wk14",".wk26");
qtaWeekArr["3Q"] = new Array(".wk27",".wk39");
qtaWeekArr["4Q"] = new Array(".wk40",".wk53");
/**
 * 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
 */
document.onclick = processButtonClick;

function processButtonClick(){
    var sheetObject = sheetObjects[0];
    var formObj  = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");
        switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
			case "btn_Creation":
				doActionIBSheet(sheetObject, formObj, MULTI);
				break;
			case "btn_Close":
				self.close();
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
	
	if(formObj.ui_id.value == "ESM_SQM_0213") {
		document.getElementById("title_nm").innerHTML = "QTA Set up by Head Office for IAS Sector_Sector Add";
	} else {
		document.getElementById("title_nm").innerHTML = "QTA Edit for IAS Sector_Office Add";
	}
	

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
	
	//부모창에서 넘어온 값 세팅
	ComSetObjValue(formObj.f_sub_trd_cd, formObj.p_sub_trd_cd.value);
	ComSetObjValue(formObj.f_ias_rgn_cd, formObj.p_ias_rgn_cd.value);
	ComSetObjValue(formObj.f_dir_cd, formObj.p_dir_cd.value);
	ComSetObjValue(formObj.f_rlane_cd, formObj.p_rlane_cd.value);
	var year = formObj.f_bse_yr.value;
	var qta = formObj.f_bse_qtr_cd.value;
	document.getElementById("div_period").innerHTML = "(" + year + qtaWeekArr[qta][0] + " ~ " + year + qtaWeekArr[qta][1] + ")";
	if(formObj.p_ofc_vw_cd.value == "L"){
		formObj.f_ofc_vw_cd.value = "Loading";
	}else{
		formObj.f_ofc_vw_cd.value = "Contract";
	}
	
	
	loadingMode = false;
}

/**
* 멀티콤보 항목을 설정한다.
*/
function initCombo(comboObj, comboId) {
	switch(comboObj.id) {
		case "f_rlane_cd":
			with (comboObj) {
				DropHeight = 300;
				InsertItem(0, '', '');
				Index = 0;
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

function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	
	switch(sheetNo) {
		case 1:		//sheet1 init
			with (sheetObj) {
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge;  //msNone; //msHeaderOnly //msPrevColumnMerge;
				
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);
				
				var HeadTitle1 =  "Trade|Sub Trade|IAS Region|R.Lane|Lane Bound|P/F SKD Group|RHQ|Office|POL|POD|Select|STS";

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);
				
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, true, true, false, false);
				
				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
														
				// 전체 높이 설정
				style.height = GetSheetHeight(8);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				//InitDataProperty(0,	cnt++,	dtSeq,			40,	  daCenter,  true,	"seq",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		80,  daCenter,	 true,	"trd_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,  daCenter,	 true,	"sub_trd_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			100,  daCenter,	 true,	"ias_rgn_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			90,  daCenter,	 true,	"rlane_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,  daCenter,	 true,	"dir_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			90,  daCenter,	 false,	"pf_grp_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,  daCenter,	 false,	"rhq_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,  daCenter,	 false,	"rgn_ofc_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,  daCenter,	 false,	"pol_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,  daCenter,	 false,	"pod_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCheckBox,		40,   daCenter,	 false,	"sel_flg",		false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,	  daCenter,	 true,	"ibflag",		false,	"",	dfNone,	0,	false,	false);
				

			}
			break;
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
			
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0222GS.do", FormQueryString(formObj));
			var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
			var arrXml = sXml.split("|$$|");
			
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_sub_trd_cd, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_ias_rgn_cd, "code", "name");
			if (arrXml.length > 2)
				ComXml2ComboItem(arrXml[2], formObj.f_dir_cd, "code", "name");
			if (arrXml.length > 3)
            	ComXml2ComboItem(arrXml[3], formObj.f_rhq_cd, "code", "name");
			ComOpenWait(false);
			break;
		
			
		case IBSEARCH:          // 화면 조회 시
			if (!validateForm(sheetObj, formObj, sAction)) return;
			
			setWeek();
			if(formObj.ui_id.value == "ESM_SQM_0213") {
				formObj.f_cmd.value = SEARCH01;
			} else {
				formObj.f_cmd.value = SEARCH;
			}			
			
			searchParams = FormQueryString(formObj);
			ComOpenWait(true);
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0222GS.do",searchParams);	
			sheetObj.LoadSearchXml(rtnXml);
			ComOpenWait(false);
			
			break;
		case MULTI:		// Creation시에
			if (!validateForm(sheetObj, formObj, sAction)) return;
			
			if (ComShowConfirm (ComGetMsg("SQM00009")) != 1) {
				return false;
		    }
			ComOpenWait(true);

			
			if(formObj.ui_id.value == "ESM_SQM_0213") {
				ComSetSearchParams("f_cmd", MULTI01);
			} else {
				ComSetSearchParams("f_cmd", MULTI);
			}
			
			sheetObj.DoSave("ESM_SQM_0222GS.do", searchParams, "sel_flg", false);
			ComOpenWait(false);
			
			var State = sheetObj.EtcData("TRANS_RESULT_KEY");
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('SQM00001','Data');
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
			window.returnValue = "OK";
			break;
	}
}


/**
* onChange event
* f_sub_trd_cd 바뀌었을때  f_lane_cd 콤보조회
*/	
function f_sub_trd_cd_OnChange(obj, value, text) {
 	var formObj = document.form;
 	var param = "f_cmd=" + SEARCH01
    + "&code_name=rLane"
    + "&code_param=IAS|"+formObj.f_sub_trd_cd.Code+"|"+formObj.f_ias_rgn_cd.Code
    + "&all_flag=";

 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
 	ComXml2ComboItem(xmlStr, formObj.f_rlane_cd, "code", "name");
 	formObj.f_rlane_cd.Index = 0;
 }

/**
* onChange event
* f_ias_rgn_cd 바뀌었을때  f_lane_cd 콤보조회
*/	
function f_ias_rgn_cd_OnChange(obj, value, text) {
 	var formObj = document.form;
 	var param = "f_cmd=" + SEARCH01
    + "&code_name=rLane"
    + "&code_param=IAS|"+formObj.f_sub_trd_cd.Code+"|"+formObj.f_ias_rgn_cd.Code
    + "&all_flag=";

 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
 	ComXml2ComboItem(xmlStr, formObj.f_rlane_cd, "code", "name");
 	formObj.f_rlane_cd.Index = 0;
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
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction){
	switch(sAction) {
		case MULTI:  // Add-Creation
			if(formObj.f_rlane_cd.Code == ""){
				ComShowCodeMessage('SQM00013','R/Lane');
				return false;
			}
			if(sheetObj.CheckedRows("sel_flg") < 1){
				ComShowCodeMessage("SQM00046");
				return false;
			}
			
			break;	
		case IBSEARCH: 
			if(formObj.f_rlane_cd.Code == ""){
				ComShowCodeMessage('SQM00013','R/Lane');
				return false;
			}
			break;
	}
	return true;
}

/**
 *  주차정보를 세팅한다.
 */
function setWeek(){
	var formObj  = document.form;
	var qta  = ComGetObjValue(formObj.f_bse_qtr_cd);
	var bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd);
	
	if (bse_tp_cd == "Q" ) {
		formObj.f_fm_wk.value = qtaWeekArr[qta][0].substring(3);
		formObj.f_to_wk.value = qtaWeekArr[qta][1].substring(3);
	} else {
		formObj.f_fm_wk.value = "00";
		formObj.f_to_wk.value = "53";
		
	}
}
/* 개발자 작업  끝 */