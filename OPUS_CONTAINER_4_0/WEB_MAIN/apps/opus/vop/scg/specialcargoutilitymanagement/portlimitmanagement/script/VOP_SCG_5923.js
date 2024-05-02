/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : esm_bkg_0744.js
 *@FileTitle  : Direct NVO AMS File No
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/04/08
=========================================================*/
/*******************************************************************************
 * Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3; MODIFY=4; REMOVE=5;
 * REMOVELIST=6 MULTI=7 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ******************************************************************************/

// Common global variable
var sheetObjects = new Array();
var sheetCnt = 0;
var prefix="sheet1_";

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick() {
	/* */
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName))
			return false;
		switch (srcName) {
		case "btn_RowAdd":
			sheetObject1.DataInsert(-1);
			break;
		case "btn_copy":
			doActionIBSheet(sheetObject1, document.form, IBCOPYROW);
			break;
		case "btn_Delete":
			if (ComIsBtnEnable("btn_Delete")) {
				var iRow = sheetObject1.GetSelectRow();
				sheetObject1.SetRowHidden(iRow, 1);
				sheetObject1.SetRowStatus(iRow, "D");
			}
			break;
		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;
		case "btn_Save":
			if (ComIsBtnEnable("btn_Save")) {
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
			}
			break;
		case "btn_Close":
			ComClosePopup();
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("COM12111");
		} else {
			ComShowMessage(e);
		}
	}
}
/**
 * registering IBSheet Object as list adding process for list in case of needing
 * batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag adding
 * first-served functions after loading screen.
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	var formObj = document.form;

	initControl();

	var sheetObj = sheetObjects[0];

	doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC01);
	doActionIBSheet(sheetObj, formObj, IBSEARCH);

	openSheetSetting();
}

function openSheetSetting() {
	var openerObj = window.dialogArguments;
	if (!openerObj)
		var openerObj = parent;

	var oSheetObj = openerObj.sheetObjects[0];
	var sheetObj = sheetObjects[2];

	sheetObj.DataInsert(-1);
	var row = sheetObj.GetSelectRow();

	// 마스터값 셋팅
	for ( var i = 0; i < 23; i++) {
		sheetObj.SetCellValue(row, i, oSheetObj.GetCellValue(oSheetObj
				.GetSelectRow(), i));
	}
}

/**
 * setting event
 */
function initControl() {
	var formObject = document.form;
}
/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case
 * as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	case "sheet1":
		with(sheetObj){
			var HeadTitle1="|Sub. Risk(s)";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0, FrozenCol:0, ComboMaxHeight:160 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",     Hidden:1, Width:30,   Align:"Center",  ColMerge:0,  SaveName:prefix+"ibflag" },
			             {Type:"Combo",      Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"imdg_subs_rsk_lbl_cd",	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1}
		               ];
			
			InitColumns(cols);

			SetCountPosition(0);
			SetWaitImageVisible(0);
			SetSheetHeight(230);
		}
		break;
	}
}

// handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // Retrieve - Class
		if (validateForm(sheetObj, formObj, sAction))
			ComOpenWait(true);
		var aryPrefix = new Array("sheet1_");
		formObj.f_cmd.value = SEARCH;
		var xml = sheetObj.GetSearchData("VOP_SCG_5923GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		sheetObjects[0].LoadSearchData(xml, {Sync : 1});

		ComOpenWait(false);
		break;

	case IBSEARCH_ASYNC01: // Serching Subs Rsk Combo
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
		var class_cd = ComXml2ComboString(sXml, "imdg_clss_cd", "imdg_clss_cd_desc");
		// var tStr=ComScgClossAppend(class_cd[0], class_cd[1] );
		// var tStr1 = tStr.substr(0, tStr.length-1);
		// Class
		// sheetObjects[0].SetColProperty("imdg_clss_cd", {ComboText:"|"+tStr1,
		// ComboCode:"|"+class_cd[0]} );
		// Subsidiary Risk(s)
		sheetObjects[0].SetColProperty("sheet1_imdg_subs_rsk_lbl_cd", {
			ComboText : "|" + class_cd[0],
			ComboCode : "|" + class_cd[0]
		});
		break;

	case IBSAVE: //

		if (dupChk()) {
			var aryPrefix = new Array("sheet1_");
			formObj.f_cmd.value = MULTI;
			if (!validateForm(sheetObj, formObj, sAction))
				return;
			var sParam = ComGetSaveString(sheetObjects, true, true); // Transmitting
																		// all
																		// rows
			if (sParam == "")
				return;
			// ComDebug("[Debug] \n" + sParam + "\n"); //alert
			ComOpenWait(true);
			sheetObjects[0].SetWaitImageVisible(0);
			sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
			var sXml = sheetObjects[0].GetSaveData("VOP_SCG_5923GS.do", sParam);
			sheetObjects[0].LoadSaveData(sXml);
			sheetObjects[0].RenderSheet(1);

//			var portLmtSeqStr = ComGetEtcData(sXml, "portLmtSeq");
//			// console.log("portLmtSeqStr>>>>>>>>>>>>>>>"+portLmtSeqStr);
//			if (portLmtSeqStr != "") {
//				document.getElementById("port_lmt_seq").value = portLmtSeqStr;
//			}
			var portLmtSeqVal = document.getElementById("port_lmt_seq").value;
			// console.log("portLmtSeqVal>>>>>>>>>>>>>>>"+portLmtSeqVal);
			if (portLmtSeqVal != "0" && portLmtSeqVal != "") {
				doActionIBSheet(sheetObj, document.form, IBSEARCH);
			}
		}

		ComOpenWait(false);
		break;

	case IBCOPYROW:
		var row = sheetObj.DataCopy();
		sheetObj.SetRowStatus(row, "I");

		break;
	}
}

/**
 * 화면단에서 컬럼별로 소팅하거나 중복컨테이너로우가 변경될때마다 해당 로우의 배열을 전역변수(배열)인 colorAry 로 담아온다
 */
function dupChk() {
	var boolChk = true;
	var sheetObj1 = sheetObjects[0];
	var arrRowAry01 = new Array();
	sheetObj1.SpaceDupCheck = false; // 기본적으로는 공백을 포함해서 중복체크를 하는데 공백을 제외하고
										// 중복체크
	// /////////sheetObj1 중복체크//////////

	var dupRow1 = sheetObj1.ColValueDupRows(prefix + "imdg_subs_rsk_lbl_cd", false, true);
	var arrRowsAry1 = dupRow1.split("|");

	if (dupRow1 != "") {
		arrRowAry01 = arrRowsAry1[0].split(",");
		boolChk = false;
	}

	if (!boolChk) {
		ComShowCodeMessage("SCG50042");
		sheetObj1.SelectCell(arrRowAry01[0], prefix + "imdg_subs_rsk_lbl_cd");
	}

	return boolChk;
}

/**
 * Validating inputted values of form
 * 
 * @param
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		switch (sAction) {
		case IBSAVE:
			break;
		}
	}
	return true;
}

/**
 * sheet1_OnChange
 * 
 * @param sheetObj,
 *            row, col, value
 */
function sheet1_OnChange(sheetObj, row, col, value) {
//	switch (sheetObj.ColSaveName(col)) {
//
//	case 'imdg_subs_rsk_lbl_cd': // Setting IMDG Definition
//		break;
//
//	}
}

/**
 * event after saving
 */
function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
	ComShowCodeMessage("SCG50043");

	var oSObj = "";
	var oFObj = "";
	var opener = window.dialogArguments;
	if (!opener)
		opener = window.opener;
	if (!opener)
		opener = parent;
	oSObj = opener.sheet1;
	oFObj = opener.document.form;

	opener.doActionIBSheet(oSObj, oFObj, IBSEARCH);
}

/**
 * event after retrieving
 */
var oSheetObj = "";
function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
	var opener = window.dialogArguments;
	if (!opener)
		opener = window.opener;
	if (!opener)
		opener = parent;
	oSheetObj = opener.sheet1;

	document.form.portLmtRepDesc.value = oSheetObj.GetCellText(oSheetObj.GetSelectRow(), "port_lmt_rep_desc");

}
