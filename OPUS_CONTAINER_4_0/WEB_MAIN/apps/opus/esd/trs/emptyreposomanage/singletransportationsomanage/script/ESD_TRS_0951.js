/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0951.js
 *@FileTitle  : Container File Import
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/08/15
=========================================================*/
// General global variable
var sheetObjects = new Array();
var sheetCnt = 0;
var cntrck = false;
var sheetObjSingle;
var winOpenObj = opener;
if(!winOpenObj) winOpenObj = parent;

document.onclick = processButtonClick;

/**
 * Register IBSheet Object with array
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * Setting sheets and initialization Implementing the onLoad event handler of body tag Adding the preceding function after loading page
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	sheetObjSingle = winOpenObj.getSheetObj();
}
/* Branch processing event handler with the name of button */
function processButtonClick() {
	/** *** Adding additional sheet variables to use more than one sheet per a tab **** */
	var sheetObject = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btng_fileselect": {
				doActionIBSheet(sheetObject, formObject, IBLOADEXCEL);
				break;
			}
			case "btng_delete": {
				doActionIBSheet(sheetObject, formObject, IBDELETE);
				break;
			}
			case "btng_verify": {
				if (gainEqNo(sheetObject, formObject)) {
					doActionIBSheet(sheetObject2, formObject, IBSEARCH);
				}
				break;
			}
			case "btng_apply": {
				doCNTRapply(sheetObject, sheetObjSingle);
				break;
			}
			case "btn_close": {
				ComClosePopup();
				break;
			}
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(ComGetMsg("TRS90106"));
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * initSheet 
 * @param sheetObj
 * @param sheetNo
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1: {
			with (sheetObj) {
	            var HeadTitle="SEQ|||EQ No|Verify Result|EQ TP/SZ" ;
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	            var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            InitHeaders(headers, info);
	            var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"eq_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"verfy_result",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lessor",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ownr_co_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_used",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"movement_sts",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"creation_yard",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"event_date",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"offh_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } 
	                ];
	            InitColumns(cols);
	            SetEditable(1);
	            SetEditableColorDiff(0);
	            ComResizeSheet(sheetObj);
			}
			break;
		}
		case 2:	{
			with (sheetObj) {
	            var HeadTitle="CNTR No";
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	            var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
	            var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"eq_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lessor",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ownr_co_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_used",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"movement_sts",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"creation_yard",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"event_date",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"offh_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	            InitColumns(cols);
	            SetEditable(1);
	            SetVisible(false);
			}
			break;
		}
	}
}

/**
 * doActionIBSheet
 * @param sheetObj
 * @param formObj
 * @param sAction
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH: {
			formObj.f_cmd.value = SEARCH02;
			sheetObj.DoSearch("ESD_TRS_0951GS.do", TrsFrmQryString(formObj), { Sync : 2 });
			doCNTRcheck(sheetObjects[0], sheetObj, sheetObjSingle);
			break;
		}
		case IBDELETE: {
			var checkList = sheetObj.FindCheckedRow('chk1');
			var checkArray = checkList.split('|');

			for ( var k = checkArray.length - 1; k >= 0; k--) {
				sheetObj.RowDelete(checkArray[k], false);
			}
			cntrck = false;
			break;
		}
		case IBLOADEXCEL: {
			sheetObj.RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObj.LoadExcel({ Mode : "HeaderMatch", WorkSheetNo : "1", WorkSheetName : "", Append : false });
			cntrck = false;
			break;
		}
	}
}

/**
 * OnChange event of Sheet1
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet1_OnChange(sheetObj, row, col, value) {
	if (sheetObj.ColSaveName(col) == "chk1") {
		if (sheetObj.GetCellValue(row, "verfy_result").length > 4) {
			sheetObj.SetCellValue(row, "chk1", "0", 0);
			sheetObj.SetRowStatus(row, "R");
		} else {
			if (value == "1") {
				sheetObj.SetRowStatus(row, "U");
			} else {
				sheetObj.SetRowStatus(row, "R");
			}
		}
	}
}

/**
 * Loading Container No
 * @param sheetObj
 * @param formObj
 * @returns {Boolean}
 */
function gainEqNo(sheetObj, formObj) {
	if (sheetObj.RowCount("U") < 1) {
		ComShowMessage(ComGetMsg("TRS90036"));
		return false;
	}
	var lvEqno = "";
	var fromRow = 0;
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	for ( var i = 0; i < arrRow.length; i++) {
		fromRow = arrRow[i];
		sheetObj.SetCellValue(fromRow, "eq_no", cntrCheckDigit(sheetObj.GetCellValue(fromRow, "eq_no")), 0);
		if (i == (arrRow.length - 1)) {
			lvEqno = lvEqno + sheetObj.GetCellValue(fromRow, "eq_no");
		} else {
			lvEqno = lvEqno + sheetObj.GetCellValue(fromRow, "eq_no") + ",";
		}
	}
	document.form.hid_eq_no.value = lvEqno;
	return true;
}

/**
 * doCNTRcheck
 * @param frmSheet
 * @param toSheet
 * @param bodySheet
 * @returns {Boolean}
 */
function doCNTRcheck(frmSheet, toSheet, bodySheet) {
	cntrck = true;
	var lvcheck = false;
	if (frmSheet.RowCount("U") < 1) {
		ComShowMessage(ComGetMsg("TRS90036"));
		return false;
	}
	var sRow = frmSheet.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	for ( var i = 0; i < arrRow.length; i++) {
		lvcheck = false;
		var lvcntr = frmSheet.GetCellValue(arrRow[i], "eq_no");
		for ( var j = 1; j < toSheet.RowCount() + 2; j++) {
			if (lvcntr == toSheet.GetCellValue(j, "eq_no")) {
				frmSheet.SetCellValue(arrRow[i], "eq_tpsz_cd", toSheet.GetCellValue(j, "eq_tpsz_cd"), 0);
				frmSheet.SetCellValue(arrRow[i], "lessor", toSheet.GetCellValue(j, "lessor"), 0);
				frmSheet.SetCellValue(arrRow[i], "lstm_cd", toSheet.GetCellValue(j, "lstm_cd"), 0);
				frmSheet.SetCellValue(arrRow[i], "ownr_co_cd", toSheet.GetCellValue(j, "ownr_co_cd"), 0);
				frmSheet.SetCellValue(arrRow[i], "eq_used", toSheet.GetCellValue(j, "eq_used"), 0);
				frmSheet.SetCellValue(arrRow[i], "movement_sts", toSheet.GetCellValue(j, "movement_sts"), 0);
				frmSheet.SetCellValue(arrRow[i], "creation_yard", toSheet.GetCellValue(j, "creation_yard"), 0);
				frmSheet.SetCellValue(arrRow[i], "event_date", toSheet.GetCellValue(j, "event_date"), 0);
				frmSheet.SetCellValue(arrRow[i], "offh_yd_cd", toSheet.GetCellValue(j, "offh_yd_cd"), 0);
				frmSheet.SetCellValue(arrRow[i], "verfy_result", "OK", 0);
				lvcheck = true;
				break;
			}
		}
		if (!lvcheck) {
			frmSheet.SetCellValue(arrRow[i], "chk1", "0", 0);
			frmSheet.SetRowStatus(arrRow[i], "R");
			frmSheet.SetCellValue(arrRow[i], "verfy_result", "No Data", 0);
			frmSheet.SetRowBackColor(arrRow[i], "#NANNANNAN");
		}
	}
	for ( var i = 0; i < arrRow.length; i++) {
		var lvcntr = frmSheet.GetCellValue(arrRow[i], "eq_no");
		for ( var j = (i + 1); j < arrRow.length; j++) {
			if (lvcntr == frmSheet.GetCellValue(arrRow[j], "eq_no")) {
				frmSheet.SetCellValue(arrRow[j], "chk1", "0", 0);
				frmSheet.SetRowStatus(arrRow[j], "R");
				frmSheet.SetCellValue(arrRow[j], "verfy_result", "Same Data", 0);
				frmSheet.SetRowBackColor(arrRow[j], "#NANNANNAN");
			}
		}
	}
	var sRow2 = frmSheet.FindCheckedRow("chk1");
	var arrRow2 = sRow.split("|");
	for ( var i = 0; i < arrRow2.length; i++) {
		var doceqno = frmSheet.GetCellValue(arrRow2[i], "eq_no");
		for ( var j = 1; j < bodySheet.RowCount(); j++) {
			if (doceqno == bodySheet.GetCellValue(j, "eq_no")) {
				frmSheet.SetCellValue(arrRow2[i], "chk1", "0", 0);
				frmSheet.SetRowStatus(arrRow2[i], "R");
				frmSheet.SetCellValue(arrRow2[i], "verfy_result", "Body Same Data", 0);
				frmSheet.SetRowBackColor(arrRow2[i], "#NANNANNAN");
				break;
			}
		}
	}
}

/**
 * doCNTRapply
 * @param frmSheet
 * @param toSheet
 * @returns {Boolean}
 */
function doCNTRapply(frmSheet, toSheet) { // child Sheet, Body Sheet
	if (!cntrck) {
		ComShowMessage(ComGetMsg("TRS90055"));
		return false;
	}
	cntrck = false;
	var lvcheck = false;
	if (frmSheet.RowCount("U") < 1) {
		ComShowMessage(ComGetMsg("TRS90036"));
		return false;
	}
	var fromRow = 0;
	var toRow = 0;
	var sFromRow = frmSheet.FindCheckedRow("chk1");
	var sToRow = toSheet.FindCheckedRow("chk1");
	var arrFRow = sFromRow.split("|");
	var arrTRow = sToRow.split("|");
	for ( var i = 0; i < arrFRow.length; i++) {
		var docEqtpszcd = frmSheet.GetCellValue(arrFRow[i], "eq_tpsz_cd");
		for ( var j = 0; j < arrTRow.length; j++) {
			var doceqno2 = toSheet.GetCellValue(arrTRow[j], "eq_no");
			var doceqtpszcd2 = toSheet.GetCellValue(arrTRow[j], "eq_tpsz_cd");
			if (docEqtpszcd == doceqtpszcd2 && doceqno2 == "") {
				toSheet.SetCellValue(arrTRow[j], "eq_no", frmSheet.GetCellValue(arrFRow[i], "eq_no"), 0);
				toSheet.SetCellValue(arrTRow[j], "eq_tpsz_cd", doceqtpszcd2, 0);
				toSheet.SetCellValue(arrTRow[j], "lessor", frmSheet.GetCellValue(arrFRow[i], "lessor"), 0);
				toSheet.SetCellValue(arrTRow[j], "lstm_cd", frmSheet.GetCellValue(arrFRow[i], "lstm_cd"), 0);
				toSheet.SetCellValue(arrTRow[j], "ownr_co_cd", frmSheet.GetCellValue(arrFRow[i], "ownr_co_cd"), 0);
				toSheet.SetCellValue(arrTRow[j], "eq_used", frmSheet.GetCellValue(arrFRow[i], "eq_used"), 0);
				toSheet.SetCellValue(arrTRow[j], "movement_sts", frmSheet.GetCellValue(arrFRow[i], "movement_sts"), 0);
				toSheet.SetCellValue(arrTRow[j], "creation_yard", frmSheet.GetCellValue(arrFRow[i], "creation_yard"), 0);
				toSheet.SetCellValue(arrTRow[j], "event_date", frmSheet.GetCellValue(arrFRow[i], "event_date"), 0);
				if (winOpenObj.form.page_type.value == 'C' && toSheet.GetCellValue(arrTRow[j], "trsp_cost_dtl_mod_name") == 'Off-Hire' && toSheet.GetCellValue(arrTRow[j], "org_eq_no") == '' && frmSheet.GetCellValue(arrFRow[i], "offh_yd_cd") != '') {
					toSheet.SetCellValue(arrTRow[j], "to_nod_cd", frmSheet.GetCellValue(arrFRow[i], "offh_yd_cd"), 0);
					toSheet.SetCellValue(arrTRow[j], "lse_cntr_flg", 'Y', 0);
				}
				break;
			}
		}
	}
	ComClosePopup();
}

/**
 * sheet1_OnLoadExcel 
 * @param sheetObj
 * @param result
 * @param code
 * @param msg
 */
function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
	if (isExceedMaxRow(msg))
		return;
}