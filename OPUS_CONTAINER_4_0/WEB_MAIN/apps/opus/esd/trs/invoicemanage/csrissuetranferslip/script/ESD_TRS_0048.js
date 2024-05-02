/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0048.jsp
 *@FileTitle  : 
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/08/08
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;
var openObject = opener;
if (!openObject) {
	openObject = parent;
}
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName))
			return false;
		switch (srcName) {
			case "btng_save":
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
			case "btn_close":
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
 * 
 * @param sheet_obj
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * 
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	ComEnableObject(document.form.csr_no, false);
	ComEnableObject(document.form.vndr_no, false);
	ComEnableObject(document.form.vndr_nm, false);
	ComEnableObject(document.form.inv_cnt, false);
	ComEnableObject(document.form.csr_curr_cd, false);
	ComEnableObject(document.form.csr_amt, false);
	ComEnableObject(document.form.asa_no, false);
	ComEnableObject(document.form.cost_ofc, false);
	ComEnableObject(document.form.max_iss_dt, false);
	ComEnableObject(document.form.max_rcv_dt, false);
	ComEnableObject(document.form.vndr_term_nm, false);
	ComEnableObject(document.form.payment_due_dt, false);
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * 
 * @param sheetObj
 * @param sheetNo
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
		case 1: {
			with (sheetObj) {
				var HeadTitle = "SEQ|Incorrect\nOnes|Invoice No.|Net\nAmount|Tax\nAmount|W.H.T\nAmount|Total\nAmount|Issue\nDate|Receive\nDate|Confirm\nDate";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
				var headers = [ { Text : HeadTitle, Align : "Center" } ];
				InitHeaders(headers, info);
	            var cols = [ 
	                         {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"chk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"inv_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:0,   SaveName:"inv_bzc_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:0,   SaveName:"inv_vat_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:0,   SaveName:"inv_whld_tax_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:0,   SaveName:"inv_ttl_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"inv_iss_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"inv_rcv_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"inv_cfm_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:1,    Align:"Right",   ColMerge:0,   SaveName:"inv_vndr_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:1,    Align:"Right",   ColMerge:0,   SaveName:"flag",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Status",    Hidden:1, Width:1,    Align:"Right",   ColMerge:0,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } 
				           ];
				InitColumns(cols);
				SetEditable(1);
				SetSheetHeight(200);
			}
			break;
		}
	}
}

/**
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH:
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESD_TRS_0048GS.do", TrsFrmQryString(formObj));
			break;
		case IBSAVE:
			formObj.f_cmd.value = MULTI01;
			sheetObj.DoAllSave("ESD_TRS_0048GS.do", TrsFrmQryString(formObj));
			break;
	}
}

/**
 * 
 * @param sheetObj
 * @param code
 * @param errmsg
 */
function sheet1_OnSearchEnd(sheetObj, code, errmsg) {
	ComEtcDataToForm(document.form, sheetObj);
	ComChkObjValid(document.form.max_iss_dt);
	ComChkObjValid(document.form.max_rcv_dt);
	if (!ComIsNumber(document.form.vndr_term_nm)) {
		document.form.vndr_term_nm.value = "KR H/O Payment_60";
	}
}

/**
 * 
 * @param sheetObj
 * @param code
 * @param errmsg
 * @returns {Boolean}
 */
function sheet1_OnSaveEnd(sheetObj, code, errmsg) {
	if (code  < 0 ) {
		ComShowMessage(errmsg);
		return false;
	}
	if (document.form.selrow.value != "") {
		openObject.sheetObjects[0].RowDelete(document.form.selrow.value, false);
	}
	document.form.selrow.value = "";
	ComClosePopup();
}
