/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : esm_bkg_0013.js
 *@FileTitle : Customer Code Entry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/09/22
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1178() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.sheet1_OnClick = sheet1_OnClick;
	this.sheet1_OnKeyUp = sheet1_OnKeyUp;
}
/* developer's work */
/**
 * registering IBSheet Object as list adding process for list in case of needing
 * batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
// global variable
var sheetObjects = new Array();
var sheetCnt = 0;
var prefix = "";// IBSheet divider
/** ********************* EDTITABLE MULIT COMBO START ******************* */
var comboCnt = 0;
var comboObjects = new Array();
/** ********************* EDTITABLE MULIT COMBO END ******************* */
/**
 * initializing sheet implementing onLoad event handler in body tag adding
 * first-served functions after loading screen.
 */
function loadPage() {
	var formObject = document.form;
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
}
function initControl() {
	var formObject = document.form;
	axon_event.addListenerFormat('keypress', 'bkg_keypress', formObject);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('change', 'bkg_change', formObject);
}
/** ********************* KEY EVENT END ******************* */
// Event handler processing by button click event */
document.onclick = processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/** *** using extra sheet valuable if there are more 2 sheets **** */
	var sheetObject1 = sheetObjects[0];
	var comboObject1 = comboObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	// try {
	var srcName = ComGetEvent("name");
    if (!ComIsBtnEnable(srcName)) return;
	switch (srcName) {
	case "btn_Retrieve":
		doActionIBSheet(sheetObject1, formObject, IBSEARCH);
		break;
	case "btn_Delete":
		doActionIBSheet(sheetObject1, formObject, IBDELETE);
		break;
	case "btn_Close":
		if (opener != undefined) {
		}
		ComClosePopup();
		break;
	}
}
// handling of Sheet
function doActionIBSheet(sheetObj, formObj, sAction, row) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH:
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		formObj.f_cmd.value = SEARCH;
		var sXml = sheetObj.DoSearch("ESM_BKG_1178GS.do", FormQueryString(formObj));
		break;
	case IBDELETE:
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		if (!ComShowConfirm(ComGetMsg("COM12194")))
			return false;
		formObj.f_cmd.value = MULTI;
		var sParam = sheetObj.GetSaveString();
		sParam += "&" + FormQueryString(formObj);
		var sXml = sheetObj.GetSaveData("ESM_BKG_1178GS.do", sParam);
		sheetObj.LoadSaveData(sXml);
	}
}
/**
 * 저장 후 재 조회
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	var formObj=document.form;
	var state=sheetObj.GetEtcData("TRANS_RESULT_KEY");  
	if (state == "S") {
 		doActionIBSheet(sheetObj,formObj,IBSEARCH);
	}
}
/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case
 * as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetObj.id) {
	case "sheet1":
		with (sheetObj) {

	        var HeadTitle1="|Seq|VVD|CRN|Download Flag";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	            {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	            {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"cvy_ref_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"download_flag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	         
	        InitColumns(cols);

	        SetEditable(1);
	        SetCountPosition(0);//[1/3]
	        SetSheetHeight(320);
        }
	break;
    }
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 화면 로우 추가시
		// 기본포멧체크
		if (!ComChkValid(formObj))
			return false;
		break;
	}
	return true;
}

/**
 * 조회 후 이벤트
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if (sheetObj.RowCount() > 0) {
		ComBtnEnable("btn_Delete");
	} else {
		ComBtnDisable("btn_Delete");
	}

	for ( var i = 1; i <= sheetObj.RowCount(); i++) {
		if (sheetObj.GetCellValue(i, "download_flag") == "Y") { // 조회조건 BDR="NO"
			ComBtnDisable("btn_Delete");
			break;
		}
	}
}
