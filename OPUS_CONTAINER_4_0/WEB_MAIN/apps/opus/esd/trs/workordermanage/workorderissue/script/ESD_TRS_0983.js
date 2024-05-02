/*
 *=========================================================
 *Copyright(c) 2015 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0983.js
 *@FileTitle  : Transport Status Update History
 *@author     : CLT
 *@version    : 1.0
 *@since      :
=========================================================
 */

var sheetObjects = new Array();
var sheetCnt = 0;
var selectParams;
document.onclick = processButtonClick;
var popOpenObj = opener;
if (!popOpenObj) {
	popOpenObj = parent;
}
/**
 * 
 */
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_close": {
				ComClosePopup();
				break;
			}
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
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
	selectParams = opener.funcCheckedParam();
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * 
 * @param sheetObj
 * @param sheetNo
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetObj.id) {
		case 'sheet1': {
			with (sheetObj) {
				var HeadTitle1 = "||S/O No|Seq|Seq|Status|Status|Status|Status|User ID|User Name|Office|Date|Date";
				var HeadTitle2 = "||S/O No|Seq|Seq|Current|Current|Previous|Previous|User ID|User Name|Office|Local|GMT";
				SetConfig({ HeaderCheckMode : 1, SearchMode : 2, MergeSheet : 7, Page : 20, DataRowMerge : 0, PrevColumnMergeMode : 0 });
				var info = { Sort : 0, ColMove : 0, HeaderCheck : 1, ColResize : 1 };
				var headers = [{ Text : HeadTitle1, Align : "Center" }, { Text : HeadTitle2, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "Text", Hidden : 1, Width : 0, Align : "Center", ColMerge : 1, SaveName : "trsp_so_ofc_cty_cd", UpdateEdit:0,   InsertEdit:0 }, 
						{ Type : "Text", Hidden : 1, Width : 0, Align : "Center", ColMerge : 1, SaveName : "trsp_so_seq", UpdateEdit:0,   InsertEdit:0 }, 						
						{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "trsp_so_ofc_cty_cd_seq", UpdateEdit:0,   InsertEdit:0 }, 
						{ Type : "Text", Hidden : 1, Width : 0, Align : "Center", ColMerge : 1, SaveName : "his_seq", UpdateEdit:0,   InsertEdit:0 }, 
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "srch_seq", UpdateEdit:0,   InsertEdit:0 }, 
						{ Type : "Text", Hidden : 1, Width : 100, Align : "Center", ColMerge : 1, SaveName : "crnt_trsp_sub_sts_cd", UpdateEdit:0,   InsertEdit:0 }, 
						{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "crnt_trsp_sub_sts_cd_nm", UpdateEdit:0,   InsertEdit:0 }, 
						{ Type : "Text", Hidden : 1, Width : 100, Align : "Center", ColMerge : 1, SaveName : "pre_trsp_sub_sts_cd", UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "pre_trsp_sub_sts_cd_nm", UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "cre_usr_id", UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text", Hidden : 0, Width : 150, Align : "Center", ColMerge : 1, SaveName : "cre_usr_nm", UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "cre_ofc_cd", UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text", Hidden : 0, Width : 150, Align : "Center", ColMerge : 1, SaveName : "loc_cre_dt", UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text", Hidden : 0, Width : 150, Align : "Center", ColMerge : 1, SaveName : "gmt_cre_dt", UpdateEdit:0,   InsertEdit:0 }
				];
				InitColumns(cols);
				resizeSheet(sheetObj)
			}
			break;
		}
	}
}
/**
 * Action Event
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH: {
			formObj.f_cmd.value = SEARCH;
			var param = TrsFrmQryString(formObj) + "&" + selectParams;
			sheetObj.DoSearch("ESD_TRS_0983GS.do", param, { Sync : 0 });
			break;
		}
	}
}