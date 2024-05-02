/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0201.js
*@FileTitle      : P_F Skd Group Management for IAS Sector
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.06
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.06 SQM USER
* 1.0 Creation
* 2016.05.11 Sector Office Relation Setting for IAS Sector 화면 및 P/F Skd Group 화면 로직 수정 요청
-P/F Skd Group Management for IAS Sector : Target VVD Fix 에서 대상항차 Fix 할 때부터 P/F Group 도 Planning에서 Freezing 될 때까지는 Add Creation 불가하도록 로직 수정 (Target VVD Fix ~ Planning의 Freezing동안)

=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends 
 * @class ESM_SQM_0201 : ESM_SQM_0201 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0201() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var max = 0;
var params = "";

var qtaWeekArr0201 = new Array();
qtaWeekArr0201["1Q"] = new Array("00","13");
qtaWeekArr0201["2Q"] = new Array("14","26");
qtaWeekArr0201["3Q"] = new Array("27","39");
qtaWeekArr0201["4Q"] = new Array("40","53");

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
	var sheetObject = sheetObjects[0];
	var formObj     = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
			case "f_bse_tp_cd":
				f_bse_tp_cd_OnChange();
				break;	
			case "btn_Retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
			case "btn_Creation":
				doActionIBSheet(sheetObject, formObj, MULTI01);
				break;
			case "btn_AddCreation":
				doActionIBSheet(sheetObject, formObj, MULTI02);
				break;
			case "btn_Downexcel":
				doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
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
	toggleButtons("INIT");
	loadingMode = false;
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
				MergeSheet = msPrevColumnMerge; //msNone; //msHeaderOnly //msPrevColumnMerge;
				
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);
				
				var HeadTitle1 =  "STS|Trade|Sub Trade|IAS Region|R.Lane|P/F SKD Group|P/F SKD Ver.|Route|";

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);
				
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, false, true, false, false);
				
				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
														
				// 전체 높이 설정
				style.height = GetSheetHeight(18);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,	  daCenter,	 true,	"ibflag",		false,	"",	dfNone,	0,	false,	false);
				//InitDataProperty(0,	cnt++,	dtSeq,		50,	  daCenter,  true,	"seq",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		40,	  daCenter,	 true,	"trd_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		70,	  daCenter,	 true,	"sub_trd_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		90,  daCenter,	 true,	"ias_rgn_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		80,	  daCenter,	 true,	"rlane_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,  daCenter,	 true,	"pf_grp_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		95,	  daCenter,	 false,	"pf_svc_tp_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		600,  daLeft,	 false,	"pf_rout_desc",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		20,	  daCenter,	 true,	"na",		false,	"",	dfNone,	0,	false,	false);

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

		default:
			with (comboObj) {
				DropHeight = 300;
				Index      = 0;
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
			
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0201GS.do", FormQueryString(formObj));
			var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
			var arrXml = sXml.split("|$$|");
			
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 2)
				ComSetYearQta(arrXml[2]);
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], formObj.f_sub_trd_cd, "code", "name");
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], formObj.f_ias_rgn_cd, "code", "name");
			ComOpenWait(false);
			break;
		
			
		case IBSEARCH:          // 화면 조회 시
			formObj.f_cmd.value = SEARCH;
			var bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
			var qta  = ComGetObjValue(formObj.f_bse_qtr_cd);
			if(bse_tp_cd == "Y"){
				formObj.f_fm_wk.value = "00";
				formObj.f_to_wk.value = "";
			}else{
				formObj.f_fm_wk.value = qtaWeekArr0201[qta][0];
				formObj.f_to_wk.value = qtaWeekArr0201[qta][1];
			}
			searchParams = FormQueryString(formObj);
			ComOpenWait(true);
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0201GS.do",searchParams);	
			sheetObj.LoadSearchXml(rtnXml);
			var etcData = getEtcData(rtnXml);
			if (etcData["dataCnt"] == 0) {
				toggleButtons("SEARCH01");
			} else {
				toggleButtons("SEARCH02");
			}
			ComOpenWait(false);
			
			break;
			
		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.Down2Excel(-1, false, false, true);
			ComOpenWait(false);
			break;
			
		case MULTI01:		// Creation
			if (ComShowConfirm (ComGetMsg("SQM00009")) != 1) {
				return false;
		    }
			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI01);
			var sXml = sheetObj.GetSaveXml("ESM_SQM_0201GS.do", searchParams);
			
			var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
			if (backendJobKey != null && backendJobKey.length > 0) {
				ComSetObjValue(formObj.backendjob_key, backendJobKey);
				sheetObj.RequestTimeOut = 3600; //초 - 1시간
				backEndJobTimer = setInterval(getBackEndJobStatus, 5000);	//밀리초  - 10초
			}
			break;
			
		case MULTI02:		// Add-Creation
			if (!validateForm(sheetObj, formObj, sAction)) return;
			
			ComSetSearchParams("f_cmd", MULTI03); // Target VVD Fix ~ Freezing까지는 작동 못하게 함
			ComSetSearchParams("f_bse_yr", formObj.f_bse_yr.Code);
			ComSetSearchParams("f_bse_tp_cd", ComGetObjValue(formObj.f_bse_tp_cd[0]));
			ComSetSearchParams("f_bse_qtr_cd", formObj.f_bse_qtr_cd.Code);
			
			var sXml = sheetObj.GetSaveXml("ESM_SQM_0201GS.do", searchParams);
			
			var status = ComGetEtcData(sXml, "dataCnt");
			
			if(status == '1'){ // 1은 target vvd fix만 진행되고, sector쪽 freezing은 진행되지 않은 상태. 둘다 진행되지 않았을 때는 0, 둘다 진행되었을 때는 2가 나옴
				ComShowCodeMessage("SQM00068");
			}else{
				if (ComShowConfirm (ComGetMsg("SQM00009")) != 1) {
					return false;
			    }
				ComOpenWait(true);
				ComSetSearchParams("f_cmd", MULTI02);
				ComSetSearchParams("f_rlane_cd", formObj.f_rlane_cd.Code);
				var sXml = sheetObj.GetSaveXml("ESM_SQM_0201GS.do", searchParams);
				var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				ComOpenWait(false);
				
				if (State == "S") {
					ComShowCodeMessage("SQM00010", "Data");
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				} else if (State != "S") {
					ComShowMessage(ComResultMessage(sXml));
					return false;
				}
			}
			break;
  }
}


/**
* onChange event
* f_sub_trd_cd 바뀌었을때  f_lane_cd 콤보조회
*/	
function f_sub_trd_cd_OnChange(obj, value, text) {
 	var formObj = document.form;
 	if(formObj.f_sub_trd_cd.Text == "All" && formObj.f_ias_rgn_cd.Code == "All"){
 		formObj.f_rlane_cd.RemoveAll();
 	}else{
	 	var param = "f_cmd=" + SEARCH01
	     + "&code_name=rLane"
	     + "&code_param=IAS|"+formObj.f_sub_trd_cd.Code+"|"+formObj.f_ias_rgn_cd.Code
	     + "&all_flag=";
	
	 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, formObj.f_rlane_cd, "code", "name");		
	//	var ttlRows = ComGetTotalRows(xmlStr);
	// 	if(ttlRows > 0){
	// 		formObj.f_rlane_cd.InsertItem(0, "All", "");
	// 	}
	 	formObj.f_rlane_cd.MultiSelect = true;
 	}	
 }

/**
* onChange event
* f_ias_rgn_cd 바뀌었을때  f_lane_cd 콤보조회
*/	
function f_ias_rgn_cd_OnChange(obj, value, text) {
 	var formObj = document.form;
 	if(formObj.f_sub_trd_cd.Text == "All" && formObj.f_ias_rgn_cd.Code == "All"){
 		formObj.f_rlane_cd.RemoveAll();
 	}else{
	 	var param = "f_cmd=" + SEARCH01
	     + "&code_name=rLane"
	     + "&code_param=IAS|"+formObj.f_sub_trd_cd.Code+"|"+formObj.f_ias_rgn_cd.Code
	     + "&all_flag=";
	
	 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, formObj.f_rlane_cd, "code", "name");		
	// 	var ttlRows = ComGetTotalRows(xmlStr);
	// 	if(ttlRows > 0){
	// 		formObj.f_rlane_cd.InsertItem(0, "All", "");
	// 	}
		formObj.f_rlane_cd.MultiSelect = true;
 	}
}

///**
// * R/Lane - ALL 선택시 전체 체크
// */
//function f_rlane_cd_OnCheckClick(comboObj, index, code) {
//	if (code == "" || code == "All") {
//		var bChk = comboObj.CheckIndex(index);
//		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
//			comboObj.CheckIndex(i) = bChk;
//    	}
//   }else{
//	   comboObj.CheckIndex(0) = false;
//   }
//}

/**
* f_bse_yr가 바뀌었을때 period 의 year 변경
*/
function f_bse_yr_OnChange(obj, value, text) {
	var formObj    = document.form;
	period_change();
	formObj.f_sub_trd_cd.Index = 0;
	formObj.f_ias_rgn_cd.Index = 0;
	formObj.f_rlane_cd.RemoveAll();
}

/**
* f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
*/
function f_bse_qtr_cd_OnChange(obj, value, text) {
	var formObj    = document.form;
	period_change();
	formObj.f_sub_trd_cd.Index = 0;
	formObj.f_ias_rgn_cd.Index = 0;
	formObj.f_rlane_cd.RemoveAll();
}

/**
 * f_bse_tp_cd 바뀌었을때 qtr_cd, week 변경
 */
function f_bse_tp_cd_OnChange() {
	var formObj    = document.form;
	var bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
	var div_qtr    = document.getElementById("div_qtr");
	var div_period = document.getElementById("div_period");
	
	if (bse_tp_cd == "Y") {
		div_qtr.style.display = "none";
		div_period.style.display = "none";
		formObj.f_bse_qtr_cd.style.display = "none";
	} else {
		div_qtr.style.display = "inline";
		div_period.style.display = "inline";
		formObj.f_bse_qtr_cd.style.display = "inline";
	}
	period_change();
	formObj.f_sub_trd_cd.Index = 0;
	formObj.f_ias_rgn_cd.Index = 0;
	formObj.f_rlane_cd.RemoveAll();
	
}

 
 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj, formObj, sAction){
 	switch(sAction) {
 		case MULTI02:  // Add-Creation
 			var rlaneCd = formObj.f_rlane_cd.Code;
 			rlaneCd = rlaneCd.replace(/,/gi,"");
 			//한개의 lane만 선택했는지 체크
 			if(rlaneCd.length != 5){
 				ComShowCodeMessage('SQM00045');
 				return false;
 			}
     	break;	
 	}
 	return true;
 }

/**
 * 화면의 모든 버튼들의 Enable/Disable을 처리
 */
function toggleButtons(step) {
   switch (step) {
	   case "INIT":
	       ComBtnEnable("btn_Retrieve");
	       ComBtnDisable("btn_Creation");
	       ComBtnDisable("btn_AddCreation");
	       ComBtnDisable("btn_Downexcel");
	       break;
	   case "SEARCH01": //조회 후 Cnt가 0 일때 
	       ComBtnEnable("btn_Retrieve");
	       ComBtnEnable("btn_Creation");
	       ComBtnDisable("btn_AddCreation");
	       ComBtnDisable("btn_Downexcel");
	       break;
	   case "SEARCH02": //조회 후 Cnt가 0이 아닐때 
	       ComBtnEnable("btn_Retrieve");
	       ComBtnDisable("btn_Creation");
	       ComBtnEnable("btn_AddCreation");
	       ComBtnEnable("btn_Downexcel");
	       break;
   }
}

/**
* BackEndJob 관련 Status='3' 이 될때까지 확인한다.<br>
*/     
function getBackEndJobStatus() {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	ComOpenWait(true);
	
	var sXml     = sheetObj.GetSearchXml("ESM_SQM_0201GS.do", "f_cmd=" + SEARCH01 + "&backendjob_key=" + formObj.backendjob_key.value);
	
	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
	var errMsg   = ComGetEtcData(sXml, "jb_usr_err_msg");
	if (jobState == "3") {
		ComShowCodeMessage("SQM00010", "Data");
		clearInterval(backEndJobTimer);
		ComOpenWait(false);
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
	} else if (jobState == "4") {
		ComShowCodeMessage("SQM00038", errMsg);
		ComOpenWait(false);
		clearInterval(backEndJobTimer);
	} else if (jobState == "5") {
		ComShowCodeMessage("SQM00039");
		ComOpenWait(false);
		clearInterval(backEndJobTimer);
	}
}
/* 개발자 작업  끝 */