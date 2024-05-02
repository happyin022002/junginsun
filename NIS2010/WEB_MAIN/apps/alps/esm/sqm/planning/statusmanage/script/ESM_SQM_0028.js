/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0028.js
*@FileTitle      : QTA Establishing Status
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.08
*@LastModifier   : JEONGMIN CHO
*@LastVersion    : 1.0
* 2013.05.08 JEONGMIN CHO
* 1.0 Creation
* 2015.05.15 이혜민 [CHM-201535608] Freezing전 RHQ별 Portion 존재하고, Office portion이 없는 List 조회.
* 2015.08.26 김용습 [CHM-201537722] [CSR 전환건] QTA Establishing Status Management 화면 내 신규칼럼 추가
* 2015.09.01 김용습 [CHM-201537766] [CSR 전환건] QTA Establishing Status Management 화면 버튼 Validation 설정
* 2016.03.21 최성민 [CHM-201640188] 연간 QTA 수립 시 1Q Transfer 관련 로직 수정
* 2017.05.25 김동호 [CSR #920] Creation 관련 버튼 제약 제거(Freezing 전까지는 계속 재생성 가능하게 변경) 
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends 
 * @class ESM_SQM_0028 : ESM_SQM_0028 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0028() {
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

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
	var sheetObj = sheetObjects[0];
	var formObj  = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
			case "f_bse_tp_cd":
				f_bse_tp_cd_OnChange();
				break;
				
			case "btn_Retrieve":
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;
				
			case "btn_GrpbCreation":
				doActionIBSheet(sheetObj, formObj, "GrpbCreation");
				break;
				
			case "btn_HoCreation":
				doActionIBSheet(sheetObj, formObj, "HoCreation");
				break;
				
			case "btn_RhqCreation":
				doActionIBSheet(sheetObj, formObj, "RhqCreation");
				break;
				
			case "btn_QtaFreezing":
				doActionIBSheet(sheetObj, formObj, "QtaFreezing");
				break;
				
			case "btn_CancelConfirm":
				doActionIBSheet(sheetObj, formObj, "CancelConfirm");
				break;
				
			case "btn_DownExcel":
				doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
				break;
				
			case "btn_Transfer":
				doActionIBSheet(sheetObj, formObj, "Transfer");
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
	
	toggleButtons();
	setTradeCombo();
	loadingMode = false;
}

function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	
	switch(sheetNo) {
		case 1:		//sheet1 init
			with (sheetObj) {
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly + msPrevColumnMerge;  //msNone; //msHeaderOnly //msPrevColumnMerge;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);
				
				var HeadTitle1 = "SEQ|Step|Office View|Status|HO Teams|Trade|Trade Bound|Org.|Updated|Confirm Cancel|STS|Ver|PIC";
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1) + 1, 0, 0, true);
				
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(false, false, true, true, false, false);
				
				//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				
				// 전체 높이 설정
				style.height = GetSheetHeight(19);
				
				//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtData,			30,		daCenter,	true,	"qta_step_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			210,	daCenter,	true,	"qta_step_desc",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCombo,		80,		daCenter,	true,	"ofc_vw_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			70,		daCenter,	true,	"sqm_ver_sts_desc",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,		daCenter,	true,	"team_cd",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	true,	"trd_cd",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			90,		daCenter,	true,	"conv_dir_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,		daCenter,	true,	"cre_ofc_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			150,	daCenter,	true,	"upd_dt",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCheckBox,		120,	daCenter,	true,	"confirm_flg",		false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,		daCenter,	true,	"ibflag",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		110,	daCenter,	true,	"qta_ver_no",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			150,	daCenter,	true,	"usr_nm",			false,	"",	dfNone,	0,	false,	false);
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
		case IBCLEAR:          //조회
			sheetObj.WaitImageVisible = false;
			
			ComOpenWait(true);
			
			formObj.f_cmd.value = INIT;
			
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0028GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");

			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 2)
				ComSetYearQta(arrXml[2]);
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], formObj.f_qta_step_cd, "code", "name");
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], formObj.f_dir_cd, "code", "name");
			if (arrXml.length > 5)
				ComXml2ComboItem(arrXml[5], formObj.f_ho_team_cd, "code", "name");
			if (arrXml.length > 6)
				ComXml2ComboItem(arrXml[6], formObj.f_org_cd, "code", "name");
			if (arrXml.length > 7)
				ComSqmSetIBCombo(sheetObj, arrXml[7], "ofc_vw_cd", true);
			
			ComOpenWait(false);
			break;
			
		case IBSEARCH:          // 화면 조회
			ComOpenWait(true);
			
			toggleButtons();
			
			formObj.f_cmd.value = SEARCH;
			
			searchParams = FormQueryString(formObj);
			
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0028GS.do", searchParams);
			
			sheetObj.LoadSearchXml(rtnXml);
			
			var etcData = getEtcData(rtnXml);
			
			var td_trans  = document.getElementById("td_trans");
			var bse_tp_cd = ComGetObjValue(document.form.f_bse_tp_cd[0]);
			
			if ( bse_tp_cd == "Y" ) {
				td_trans.style.display = "inline";
	            
	            // Setp 01 이 없거나 Data 가 존재 하지 않을 때
	            if ( etcData["step01Cnt"] == 0 || etcData["NODATA"] == "Y" )    toggleButtons("GRPB");
	            // Step 02 이 없을 때
	            if ( etcData["step02Cnt"] == 0 )    toggleButtons("HO");
	            // Step 03 이 없을 때
	            if ( etcData["step03Cnt"] == 0 )    toggleButtons("RHQ");
			} else {
				td_trans.style.display = "none";
				
	            if ( etcData["rlseFlg"] == "N" || etcData["NODATA"] == "Y") {
	                toggleButtons("GRPB");
	                if ( etcData["step01Cnt"] > 0 ) toggleButtons("HO");
	                if ( etcData["step02Cnt"] > 0 ) toggleButtons("RHQ");
	            }  
			}			
			
            // 연간 Data 조회하면서 Rlse 정보가 존재할 때(Freeze 되었을때), 전환 할 1Q의 Data 가 존재 하지 않을 때
            if ( etcData["rlseFlg"] == "Y" && bse_tp_cd == "Y" && etcData["transFlg"] == "N")   toggleButtons("TRANS");
            
			// Rlse 가 존재 하지 않으면서 Freeze 가능 할때(모든 Step 이 Confirm 일 경우) 
			if ( etcData["freezeFlg"] == "Y" && etcData["rlseFlg"] == "N")	toggleButtons("FREEZE");
			
			// Rlse 가 존재 하지 않으면서 Data 가 존재할 경우
			if ( sheetObj.SearchRows != 0 && etcData["rlseFlg"] == "N")	toggleButtons("CANCEL");
			
			if ( sheetObj.SearchRows != 0 )		toggleButtons("SEARCH");

			ComOpenWait(false);
			break;
			
		case "CancelConfirm":
			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006");
		        return false;
		    } else if (ComShowConfirm (ComGetMsg("SQM00012", "Cancel Confirm")) != 1) {
				return false;
		    }
			
			ComOpenWait(true);
			
			ComSetSearchParams("f_cmd", MULTI);
            
			sheetObj.DoSave("ESM_SQM_0028GS.do", searchParams, -1, false);
			
			ComOpenWait(false);
			
			var State = sheetObj.EtcData("TRANS_RESULT_KEY");
			
			if (State == "S") {
				ComShowCodeMessage("SQM00001", "Data");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
			break;
			
		case "GrpbCreation":
			if (ComShowConfirm (ComGetMsg("SQM00070", "L/F & G.RPB Creation", "The previously created(modified) L/F & G.RPB, HO, RHQ data will be deleted.")) != 1) {
				return false;
		    }
			
			ComOpenWait(true);
			
			ComSetSearchParams("f_cmd", MULTI01);
			
			var sXml = sheetObj.GetSaveXml("ESM_SQM_0028GS.do", searchParams);
			
			ComOpenWait(false);
			
			var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			
			if ( State == "S" ) {
				ComShowCodeMessage("SQM00010", "Data");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			} else if ( State != "S" ) {
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}
			break;
			
		case "HoCreation":
			if (ComShowConfirm (ComGetMsg("SQM00070", "HO Creation", "The previously created(modified) L/F & G.RPB, HO data will be deleted.")) != 1) {
				return false;
		    }
			
			ComOpenWait(true);
			
			ComSetSearchParams("f_cmd", MULTI02);
			
			var sXml = sheetObj.GetSaveXml("ESM_SQM_0028GS.do", searchParams);
			
			ComOpenWait(false);
			
			var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			
			if ( State == "S" ) {
				ComShowCodeMessage("SQM00010", "Data");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			} else if ( State != "S" ) {
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}
			break;
			
		case "RhqCreation":
			if (ComShowConfirm (ComGetMsg("SQM00070", "RHQ Creation", "The previously created(modified) RHQ data will be deleted.")) != 1) {
				return false;
		    }
			
			ComOpenWait(true);
			
			ComSetSearchParams("f_cmd", MULTI03);
			
			var sXml = sheetObj.GetSaveXml("ESM_SQM_0028GS.do", searchParams);
			
			ComOpenWait(false);
			
			var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			
			if ( State == "S" ) {
				ComShowCodeMessage("SQM00010", "Data");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			} else if ( State != "S" ) {
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}
			break;
			
		case "QtaFreezing":
			if (!validateForm(sheetObj, formObj, sAction)) return;
			
			if (ComShowConfirm (ComGetMsg("SQM00012", "QTA Freezing")) != 1) {
				return false;
		    }
			
			ComOpenWait(true);
			
			ComSetSearchParams("f_cmd", MULTI04);
			
			var sXml = sheetObj.GetSaveXml("ESM_SQM_0028GS.do", searchParams);
			
			var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
			
			if (backendJobKey != null && backendJobKey.length > 0) {
				ComSetObjValue(formObj.backendjob_key, backendJobKey);
				sheetObj.RequestTimeOut = 3600; //초 - 1시간
				backEndJobTimer = setInterval(getBackEndJobStatus, 5000);	//밀리초  - 10초
			}
			break;
			
		case "Transfer":
			if (ComShowConfirm (ComGetMsg("SQM00012", "1Q Transfer")) != 1) {
				return false;
		    }
			
			ComOpenWait(true);
			
			ComSetSearchParams("f_cmd", MULTI05);
			
			var sXml = sheetObj.GetSaveXml("ESM_SQM_0028GS.do", searchParams);
			
			var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			
			var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
			
			if (backendJobKey != null && backendJobKey.length > 0) {
				ComSetObjValue(formObj.backendjob_key, backendJobKey);
				sheetObj.RequestTimeOut = 3600; //초 - 1시간
				backEndJobTimer = setInterval(getBackEndJobStatus, 5000);	//밀리초  - 10초
			}
			break;
		
		case IBSEARCH_ASYNC01:
			ComSetSearchParams("f_cmd", SEARCH02);
			
			var sXml = sheetObj.GetSearchXml("ESM_SQM_0028GS.do",searchParams);
			return sXml;
			break;	
			
		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.Down2Excel(-1, false, false, true);
			ComOpenWait(false);
			break;
    }
}

/**
 * 화면의 모든 버튼들의 Enable/Disable 을 처리
 */
function toggleButtons(step) {
	switch (step) {
		case "GRPB":
			if ( login_ofc_cd == "SELCSG" ){
				ComBtnEnable("btn_GrpbCreation");
			}
			break;
			
		case "HO":
			if ( login_ofc_cd == "SELCSG" ){
				ComBtnEnable("btn_HoCreation");
			}
			break;
			
		case "RHQ":
			if ( login_ofc_cd == "SELCSG" ){
				ComBtnEnable("btn_RhqCreation");
			}
			break;
			
		case "FREEZE":
			if ( login_ofc_cd == "SELCSG" ){
				ComBtnEnable("btn_QtaFreezing");
			}
			break;
			
		case "TRANS":
			if ( login_ofc_cd == "SELCSG" ){
				ComBtnEnable("btn_Transfer");
			}
			break;
			
		case "CANCEL":
			if ( login_ofc_cd == "SELCSG" ){
				ComBtnEnable("btn_CancelConfirm");
			}
			break;
			
		case "SEARCH":
			ComBtnEnable("btn_DownExcel");
			break;
			
		default:
			ComBtnDisable("btn_GrpbCreation");
			ComBtnDisable("btn_HoCreation");
			ComBtnDisable("btn_RhqCreation");
			ComBtnDisable("btn_QtaFreezing");
			ComBtnDisable("btn_CancelConfirm");
			ComBtnDisable("btn_DownExcel");
			ComBtnDisable("btn_Transfer");
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
	
	var sXml     = sheetObj.GetSearchXml("ESM_SQM_0028GS.do", "f_cmd=" + SEARCH01 + "&backendjob_key=" + formObj.backendjob_key.value);
	
	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
	var errMsg   = ComGetEtcData(sXml, "jb_usr_err_msg");
	
	if (jobState == "3") {
		ComShowCodeMessage("SQM00010", "Data");
		clearInterval(backEndJobTimer);
		ComOpenWait(false);
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
	} else if (jobState == "4") {
		//ComShowCodeMessage("SQM00038", errMsg);
		ComShowMessage(errMsg);
		ComOpenWait(false);
		clearInterval(backEndJobTimer);
	} else if (jobState == "5") {
		ComShowCodeMessage("SQM00039");
		ComOpenWait(false);
		clearInterval(backEndJobTimer);
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction){
	switch(sAction) {
		case "QtaFreezing":  // Freezing
			//Freezing 전 RHQ에는 Portion을 부여했으나 
			//해당 RHQ 산하의 Office에게 Portion을 부여하지 않은 RHQ List를 조회후 List가 없을경우 Freezing.
			var arrXml = doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
			var OfcZeroPortion = ComGetEtcData(arrXml, "OfcZeroPortion");
			if(OfcZeroPortion != null && OfcZeroPortion != ""){
				ComShowCodeMessage("SQM00052", OfcZeroPortion.substr(1));
				return false;
			}
			break;
	}
	return true;
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
}

/**
 * f_bse_yr가 바뀌었을때 period 의 year 변경
 */
function f_bse_yr_OnChange(obj, value, text) {
	period_change();
}

/**
 * f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
 */
function f_bse_qtr_cd_OnChange(obj, value, text) {
	period_change();
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
     + "&all_flag=All";	// Trade

	var sXml = sheetObj.GetSearchXml("CommonGS.do",param);
	ComXml2ComboItem(sXml, formObj.f_trd_cd, "code", "name");
	// 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
	var index = SearchIndex(formObj.f_trd_cd, trd_cd);
	formObj.f_trd_cd.Index = index;
}

/* 개발자 작업  끝 */