/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0933.js
 *@FileTitle  : Multi-stop Location Inquiry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/08/05
=========================================================*/

/**
 * @fileoverview Defining scripts
 * @author author_name
 */
/**
 * @extends 
 * @class ESD_TRS_0933 :
 */
var sheetObjects = new Array();
var sheetCnt = 0;
document.onclick = processButtonClick;
function processButtonClick() {
	/** *** Adding additional sheet variables to use more than one sheet per a tab **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName))
			return false;
		switch (srcName) {
			case "btn_close":
				formObject.reset();
				ComClosePopup();
				break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			errMsg = ComGetMsg("TRS90392");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e.message);
		}
	}
}
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
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	doActionIBSheet(sheetObject, formObject, IBSEARCH);
	initControl();
}
/**
 * initControl
 */
function initControl() {
}
/**
 * Define the initial values and headers of sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
		case 1:
			with (sheetObj) {
				var HeadTitle = "hidden|Door\nSEQ|Door \nArrival  Time|Door\nLOC|Zip Code|Actual Address";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
				var headers = [ { Text : HeadTitle, Align : "Center" } ];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "Status", Hidden : 1, Width : 30, Align : "Center", ColMerge : 1, SaveName : "ibflag" },
						{ Type : "Text", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "trsp_rqst_ord_sub_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 130, Align : "Center", ColMerge : 1, SaveName : "dor_arr_dt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "dor_loc_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "dor_pst_cd", KeyField : 0, CalcLogic : "", Format : "PostNo", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 200, Align : "left", ColMerge : 1, SaveName : "dor_addr", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }
				];
				InitColumns(cols);
				SetEditable(1);
				ComResizeSheet(sheetObj);
			}
			break;
	}
}
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH:
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESD_TRS_0933GS.do", TrsFrmQryString(formObj));
			break;
	}
}
/**
 * Validating inputted values of form
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
	}
	return true;
}
