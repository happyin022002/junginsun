/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0024.js
 *@FileTitle  : W/O Issue Preview
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/09
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;
document.onclick = processButtonClick;

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
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e.message);
		}
	}
}
$(window).unload(function() {
	return "Bye now!";
});

/**
 * Register IBSheet Object with array call from comSheetObject(id)
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * Setting sheets and initialization Implementing the onLoad event handler of body tag Adding the preceding function after loading page
 */
function loadPage() {
	var formObj = document.form;
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	formObj.f_cmd.value = SEARCH08;
	sheetObjects[0].DoSearch("ESD_TRS_0024GS.do", TrsFrmQryString(formObj), { Sync : 2 });
	var comboObj = wo_group_no;
	comboObj.SetDropHeight(200);
	comboObj.SetColAlign(0, "left");
	comboObj.RemoveAll();
	for ( var i = 0; i < sheetObjects[0].RowCount(); i++) {
		comboObj.InsertItem(i, sheetObjects[0].GetCellValue(i + 1, 'wo_iss_no'), sheetObjects[0].GetCellValue(i + 1, 'wo_iss_no'));
	}
	rdInit();
	wo_group_no.SetSelectIndex(0, true);
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
				var HeadTitle = "||";
				SetConfig({ SearchMode : 2, MergeSheet : 2, Page : 20, FrozenCol : 0, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [
					{ Text : HeadTitle, Align : "Center" }
				];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "CheckBox", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "ibcheck" },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "wo_prv_grp_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "wo_iss_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "wo_fmt_tp_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "wo_iss_sts_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "vndr_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "trsp_crr_mod_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "trsp_wo_ofc_cty_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "trsp_wo_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "vndr_lgl_eng_nm", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 200 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "cnt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "conti_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "trsp_bnd_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "trsp_cost_dtl_mod_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "pre_dispatch", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "wo_instr_rmk", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 2000 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "wo_edi_use_flg", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "inter_use_flg", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "fax1", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 100 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "fax2", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 100 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "fax3", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 100 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "eml1", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 200 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "eml2", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 200 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "eml3", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 200 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "to_nod_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "fm_nod_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "dor_nod_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "via_nod_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Status", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "ibflag" }, { Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "wo_dtl_use_flg" },
						{ Type : "Text", Hidden : 0, Width : 10, Align : "Center", ColMerge : 1, SaveName : "edi_rcvr_nm_use_flg" }
				];

				InitColumns(cols);
				SetEditable(1);
				SetVisible(0);
			}
			break;
		}
	}
}
/**
 * Opening the corresponding mrd file when selecting an invoice grouped
 */
function rdOpen(formObj) {
	var comboObj = wo_group_no;
	if (comboObj.GetSelectCode() == '') {
		return;
	}
	var comboSelectSheetRow = getSelectSheetRow(sheetObjects[0], comboObj.GetSelectText());
	var wo_format = sheetObjects[0].GetCellValue(comboSelectSheetRow, 'wo_fmt_tp_cd');
	var RT_DP_USE_FLG_VALUE = (formObj.RT_DP_USE_FLG[0].checked ? 'Y' : 'N');
	var wo_page = '';
	var suffix = '_S';
	var prefix = 'USA_';
	var prefix_a = 'ASIA_';
	var prefix_e = 'EUR_';
	if (wo_format == 'NC') {
		wo_page = 'WO_NORMAL';
	} else if (wo_format == 'MM') {
		wo_page = 'WO_EMPTY';
		suffix = '';
	}
	if (!formObj.WO_DTL_USE_FLG.checked) {
		wo_page += suffix;
	}
	var contiCd = sheetObjects[0].GetCellValue(comboSelectSheetRow, 'conti_cd');
	if (contiCd == "M") {
		if (wo_format == 'NC' || wo_format == 'MM') {
			wo_page = prefix + wo_page;
		}
	} else if (contiCd == "A") {
		wo_page = prefix_a + wo_page;
	} else if (contiCd == "E") {
		wo_page = prefix_e + wo_page;
	}

	var rdParam = '/rp [' + RT_DP_USE_FLG_VALUE + ']';
	rdParam += '[' + sheetObjects[0].GetCellValue(comboSelectSheetRow, 'wo_prv_grp_seq') + ']';
	rdParam += '[' + sheetObjects[0].GetCellValue(comboSelectSheetRow, 'wo_iss_no') + ']';
	rdParam += '[' + formObj.FORM_USR_OFC_CD.value + ']';
	rdParam += '[' + formObj.FORM_CRE_USR_ID.value + ']';
	rdParam += '[N]';
	rdParam += '[' + wo_page + ']';
	rdParam += '[' + sheetObjects[0].GetCellValue(comboSelectSheetRow, 'conti_cd') + ']';
	rdParam += '[]';
	console.log(rdParam);
	viewer.openFile(RD_path + 'apps/opus/esd/trs/workordermanage/workorderpreview/report/' + wo_page + '.mrd', RDServer + rdParam + "/rfonttype60", {timeout:1800});
	viewer.setDownloadFileName(wo_page);
}

/**
 * Initailizing RD environment
 */
function rdInit() {
	viewer.zoom = 150;
	viewer.hideToolbarItem(["xls", "hwp", "ppt", "doc"]);
}

/**
 * Event occurred when selecting an invoice group
 */
function wo_group_no_OnChange(obj, code, oldindex, oldtext, oldcode, newindex, newtext, newcode) {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	var comboObj = wo_group_no;
	var comboSelectSheetRow = getSelectSheetRow(sheetObj, comboObj.GetSelectText());
	if (sheetObj.GetCellValue(comboSelectSheetRow, 'ibcheck') == 1) {
		ComShowCodeMessage('TRS90136');
	}
	formObj.p_wo_prv_grp_seq.value = sheetObjects[0].GetCellValue(comboSelectSheetRow, 'wo_prv_grp_seq');
	rdOpen(document.form);
}

/**
 * Number Of W/O To Issue 와 일치하는 Sheet 조회
 * 
 * @param sheetObjects
 * @param selectComboValue
 * @returns {Number}
 */
function getSelectSheetRow(sheetObjects, selectComboValue) {
	var sheetRow = 1;
	for ( var i = 1; i < sheetObjects.RowCount() + 1; i++) {
		if (sheetObjects.GetCellValue(i, 'wo_iss_no') == selectComboValue) {
			sheetRow = i;
			break;
		}
	}
	return sheetRow;
}
