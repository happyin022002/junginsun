/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0930.jsp
 *@FileTitle  : Office Transfer Popup
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/08/04
=========================================================*/
var winOpenObj = opener;
if (!winOpenObj)
	winOpenObj = parent;

var opensheetObject = winOpenObj.openObjSheet();
var openWindownm = winOpenObj.openWindownm;
var sheetObjects = new Array();
var sheetCnt = 0;
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
	initControl();
}
/**
 * 
 */
function initControl() {
}

document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		with (formObject) {
			switch (srcName) {
				case "btn_transfer":
					doActionIBSheet(sheetObject, formObject, IBSAVE);
					break;
				case "btn_close":
					ComClosePopup();
					break;
				case "btns_search":
					openTransOffice();
					break;
			}
		}
	} catch (e) {
		if (e = "[object Error]") {
			errMsg = ComGetMsg("TRS90106");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * Define the initial values and headers of sheets
 * 
 * 
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
		case 1:
			with (sheetObj) {
				var HeadTitle = "STS";
				SetConfig({ SearchMode : 2, MergeSheet : 1, Page : 20, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [
					{ Text : HeadTitle, Align : "Center" }
				];
				InitHeaders(headers, info);
				var cols = [
					{ Type : "Status", Hidden : 0, Width : 0, Align : "Center", ColMerge : 0, SaveName : "ibflag" }
				];
				InitColumns(cols);
				SetEditable(0);
				SetVisible(false);
			}
			break;
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
		case IBSAVE:
			if (doSepRemove(formObj.new_trns_rqst_ofc_cd.value, " ") == "") {
				ComShowCodeMessage("TRS90091");
				formObj.new_trns_rqst_ofc_cd.focus();
			} else if (doSepRemove(formObj.new_trns_rqst_rsn.value, " ") == "") {
				ComShowCodeMessage("TRS90093");
				formObj.new_trns_rqst_rsn.focus();
			} else {
				if (openWindownm == "MT") {
					formObj.f_cmd.value = MODIFY01;
				} else {
					formObj.f_cmd.value = MODIFY;
				}
				var queryStr = opensheetObject.GetSaveString(false, true, "chk1");
				sheetObj.DoSearch("ESD_TRS_0930GS.do", TrsFrmQryString(formObj) + "&" + queryStr + "&" + "chk1", { Sync : 2, Append : false });
			}
			break;
		case IBSEARCH:
			formObj.f_cmd.value = SEARCH10;
			sheetObj.DoSearch("ESD_TRS_0930GS.do", TrsFrmQryString(formObj) + "&" + "chk1", { Sync : 2, Append : false });
			
			break;
	}
}

/*
 * Office check
 */
function officeCheck(obj) {
	obj.value = obj.value.toUpperCase();
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/*
 * Removing data on screen
 */
function doTransOffice(sheetObj) {
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");

	for (ir = arrRow.length - 1; ir >= 0; ir--) {
		sheetObj.RowDelete(arrRow[ir], false);
	}
	if (openWindownm == 'MT') {
		winOpenObj.doOfficeTrans_end(this.window);
	}

	ComClosePopup();
}
/**
 * General processing method working when there is an error of inquiring result DataSheetObject.prototype.event_OnSaveEnd of IBSheetConfig.js
 */
function sheet_OnSearchEnd(sheetObj, errMsg) {
	if (document.form.f_cmd.value == MODIFY || document.form.f_cmd.value == MODIFY01) {
		if (errMsg.length > 0) {
			ComShowMessage(errMsg);
		} else {
			doTransOffice(opensheetObject);
		}
	} else if(document.form.f_cmd.value == SEARCH10) {
		if(sheetObj.SearchRows() == 0) {
			document.form.new_trns_rqst_ofc_cd.value = "";
		}
	} else {
		if (errMsg.length > 0) {
			document.form.new_trns_rqst_ofc_cd.value = "";
		}
	}
}
/**
 * General Transfer Office
 */
function openTransOffice() {
	var formObject = document.form;
	var cmdt_cd_val = "";
	var rep_cmdt_cd_val = "";
	var cmdt_desc_val = "";
	var xx1 = ""; // CONTI
	var xx2 = ""; // SUB CONTI
	var xx3 = ""; // COUNTRY
	var xx4 = ""; // STATE
	var xx5 = ""; // CONTROL OFFIC
	var xx6 = ""; // LOC CODE
	var xx7 = ""; // LOC NAME
	var xx8 = "";
	var xx9 = "";
	var classId = "getCOM_ENS_071_1";
	var param = "?ofc_pts_cd=" + xx1 + "&ofc_cd=" + xx2 + "&ofc_nm=" + xx3 + "&ofc_dispaly=" + xx4 + "&classId=" + classId;
	ComOpenPopup('/opuscntr/COM_ENS_071.do' + param, 800, 550, 'getCOM_ENS_071_1', '1,0,1,1,1,1,1,1');
}
/**
 * Commodity
 */
function getCOM_ENS_071_1(rowArray) {
	var colArray = rowArray[0];
	document.form.new_trns_rqst_ofc_cd.value = colArray[3];
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
