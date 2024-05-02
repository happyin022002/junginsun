/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_PRD_0080.js
 *@FileTitle  : Product Catalog
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/15
=========================================================*/
var tabObjects = new Array();

var sheetCnt = 0;
var sheetObjects = new Array();
document.onclick = processButtonClick;
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
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
function processButtonClick() {
	var shtCnt = 0;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName))
			return false;
		switch (srcName) {
			case "btn_close": {
				ComClosePopup();
				break;
			}
			case "btng_fullroute": {
				var selRownum = '';
				for ( var i = sheetObjects[0].HeaderRows(); i < sheetObjects[0].LastRow() + 1; i++) {
					if (sheetObjects[0].GetCellValue(i, "chk") == true) {
						selRownum = i;
					}
				}
				var url = "ESD_PRD_0081.do?pctl_no=" + sheetObjects[0].GetCellValue(selRownum, "pctl_no");
				ComOpenPopup(url, 800, 460, "", "1,0,1,1,1", true);
				break;
			}
			case "btng_constraints": {
				var selRownum = '';
				for ( var i = sheetObjects[0].HeaderRows(); i < sheetObjects[0].LastRow() + 1; i++) {
					if (sheetObjects[0].GetCellValue(i, "chk") == true) {
						selRownum = i;
					}
				}
				var url = "ESD_PRD_0082.do?f_cmd=" + SEARCHLIST + "&pctl_no=" + sheetObjects[0].GetCellValue(selRownum, "pctl_no");
				ComOpenPopup(url, 760, 460, "", "0,0", true);
				break;
			}
		}
	} catch (e) {

		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var formObj = document.form;
	var cnt = 0;
	var shtID = sheetObj.id;
	switch (shtID) {
		case "sheet1":
			with (sheetObj) {

				var HeadTitle1 = "no|CHK|Flag|Priority|Full Cargo Cut Off|Cost(USD)|Transit Time|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|1st Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|2nd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|3rd Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|4th Vessel|||||||||||||||||||||||||||||||||||";
				var HeadTitle2 = "no|CHK|Flag|Priority|Full Cargo Cut Off|Cost(USD)|Transit Time|Lane / VVD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|Lane|SPACE|Lane / VVD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|SPACE|Lane / VVD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|SPACE|Lane / VVD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POL / ETD|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|POD / ETA|SPACE||||||||||||||||||||||||||||||||||||";

				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 0, HeaderCheck : 0, ColResize : 1 };
				var headers = [
						{ Text : HeadTitle1, Align : "Center" }, { Text : HeadTitle2, Align : "Center" }
				];
				InitHeaders(headers, info);

				var cols = [
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "pctl_no", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Radio", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "chk", UpdateEdit : 1, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "upd_ind_cd", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 60, Align : "Center", ColMerge : 1, SaveName : "ocn_rout_prio_cd", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 120, Align : "Center", ColMerge : 1, SaveName : "cut_off", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "ttl_expn_amt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "tztm_hrs", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n1st_vsl_slan_cd", KeyField : 0, CalcLogic : "", Format : "", MultiLineText : 1, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "pre_n1st_pol_dc_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "pre_n1st_pol_dc", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "n1st_pol_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n1st_pol", KeyField : 0, CalcLogic : "", Format : "", MultiLineText : 1, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "post_n1st_pol_dc_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "post_n1st_pol_dc", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "pre_n1st_pod_dc_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "pre_n1st_pod_dc", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "n1st_pod_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n1st_pod", KeyField : 0, CalcLogic : "", Format : "", MultiLineText : 1, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "post_n1st_pod_dc_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "post_n1st_pod_dc", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 1, SaveName : "n1st_slan_cd", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "n1st_space", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n2nd_vsl_slan_cd", KeyField : 0, CalcLogic : "", Format : "", MultiLineText : 1, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "pre_n2nd_pol_dc_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "pre_n2nd_pol_dc", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "n2nd_pol_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n2nd_pol", KeyField : 0, CalcLogic : "", Format : "", MultiLineText : 1, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "post_n2nd_pol_dc_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "post_n2nd_pol_dc", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "pre_n2nd_pod_dc_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "pre_n2nd_pod_dc", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "n2nd_pod_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n2nd_pod", KeyField : 0, CalcLogic : "", Format : "", MultiLineText : 1, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "post_n2nd_pod_dc_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "post_n2nd_pod_dc", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n2nd_space", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n3rd_vsl_slan_cd", KeyField : 0, CalcLogic : "", Format : "", MultiLineText : 1, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "pre_n3rd_pol_dc_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "pre_n3rd_pol_dc", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "n3rd_pol_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n3rd_pol", KeyField : 0, CalcLogic : "", Format : "", MultiLineText : 1, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "post_n3rd_pol_dc_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "post_n3rd_pol_dc", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "pre_n3rd_pod_dc_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "pre_n3rd_pod_dc", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "n3rd_pod_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n3rd_pod", KeyField : 0, CalcLogic : "", Format : "", MultiLineText : 1, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "post_n3rd_pod_dc_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "post_n3rd_pod_dc", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n3rd_space", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n4th_vsl_slan_cd", KeyField : 0, CalcLogic : "", Format : "", MultiLineText : 1, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "pre_n4th_pol_dc_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "pre_n4th_pol_dc", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "n4th_pol_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n4th_pol", KeyField : 0, CalcLogic : "", Format : "", MultiLineText : 1, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "post_n4th_pol_dc_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "post_n4th_pol_dc", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "pre_n4th_pod_dc_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "pre_n4th_pod_dc", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "n4th_pod_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n4th_pod", KeyField : 0, CalcLogic : "", Format : "", MultiLineText : 1, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "post_n4th_pod_dc_chk", KeyField : 0, CalcLogic : "", Format : "", TrueValue : "Y", FalseValue : "N", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "post_n4th_pod_dc", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n4th_space", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "org_loc_cd", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "dest_loc_cd", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "rout_seq", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "vvd_lnk_no", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "ord", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "lnk_knt", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n1st_pol_dc_clpt_seq", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n1st_pod_dc_clpt_seq", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n1st_vvd", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n2nd_vvd", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n3rd_vvd", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n4th_vvd", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n2nd_pol_dc_clpt_seq", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n2nd_pod_dc_clpt_seq", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n3rd_pol_dc_clpt_seq", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n3rd_pod_dc_clpt_seq", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n4th_pol_dc_clpt_seq", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n4th_pod_dc_clpt_seq", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n1st_pol_clpt_ind_seq", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n1st_pod_clpt_ind_seq", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n2nd_pol_clpt_ind_seq", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n2nd_pod_clpt_ind_seq", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n3rd_pol_clpt_ind_seq", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n3rd_pod_clpt_ind_seq", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n4th_pol_clpt_ind_seq", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n4th_pod_clpt_ind_seq", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n1st_pol_n", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n1st_pod_n", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n2nd_pol_n", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n2nd_pod_n", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n3rd_pol_n", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n3rd_pod_n", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n4th_pol_n", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "n4th_pod_n", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 }
				];

				InitColumns(cols);
				SetEditable(1);

				SetColProperty("tztm_hrs", { AcceptKeys : "N", Format : "##.##" });
				SetWaitImageVisible(0);
				SetColHidden(0, 1);
				SetSheetHeight(215);
			}
			break;
		case "sheet2": // sheet2 init
			with (sheetObj) {
				var HeadTitle1 = " CHK|Empty Pick Up Yard|Empty Pick Up Yard|EQ Inventory|EQ Inventory|EQ Inventory|EQ Inventory|EQ Inventory|EQ Inventory";
				var HeadTitle2 = " CHK|||D2|D4|D5|R2|R4|R5";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
				var headers = [
						{ Text : HeadTitle1, Align : "Center" }, { Text : HeadTitle2, Align : "Center" }
				];
				InitHeaders(headers, info);

				var cols = [
						{ Type : "Radio", Hidden : 1, Width : 30, Align : "Center", ColMerge : 1, SaveName : "mt_chk", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "yd_cd", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 140, Align : "Left", ColMerge : 1, SaveName : "nod_nm", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 35, Align : "Center", ColMerge : 1, SaveName : "d2", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 35, Align : "Center", ColMerge : 1, SaveName : "d4", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 35, Align : "Center", ColMerge : 1, SaveName : "d5", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 35, Align : "Center", ColMerge : 1, SaveName : "r2", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 35, Align : "Center", ColMerge : 1, SaveName : "r4", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 35, Align : "Center", ColMerge : 1, SaveName : "r5", KeyField : 0, CalcLogic : "", Format : "", UpdateEdit : 0, InsertEdit : 0 }
				];

				InitColumns(cols);
				SetColProperty(0, "yd_cd", { AcceptKeys : "E|[0123456789]", InputCaseSensitive : 1 });
				SetEditable(0);
				SetWaitImageVisible(0);
				SetSheetHeight(145, 1);
			}
			break;
		case "sheet3": // sheet3 init
			with (sheetObj) {
				var HeadTitle1 = " |CHK |Full Return Yard|Cargo Cut Off Time|Cargo Cut Off Time|Cargo Cut Off Time";
				var HeadTitle2 = " |CHK |Full Return Yard|General|RF|DG";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 0 });
				var info = { Sort : 0, ColMove : 0, HeaderCheck : 0, ColResize : 1 };
				var headers = [{ Text : HeadTitle1, Align : "Center" }, { Text : HeadTitle2, Align : "Center" }];
				InitHeaders(headers, info);
                var cols = [ 
 	                      {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"yd_cd1",    KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1,  UpdateEdit : 0 },
 	                      {Type:"Radio",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"frt_chk",   Wrap:1 },
 	                      {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1,  UpdateEdit : 0  },
 	                      {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"gen",       KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1,  UpdateEdit : 0  },
 	                      {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"rf",        KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1,  UpdateEdit : 0  },
 	                      {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"dg",        KeyField:0,   CalcLogic:"",   Format:"",            Wrap:1,  UpdateEdit : 0  } 
 	               ];

				InitColumns(cols);
				SetColProperty(0, "yd_cd", { AcceptKeys : "E|[0123456789]", InputCaseSensitive : 1 });
				SetEditable(0);
				SetSheetHeight(145, 1);
			}
			break;
	}
}

/**
 * 
 * @param sheetObj
 * @param sAction
 */
function doActionIBSheet(sheetObj, formObject, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH: {
			formObject.f_cmd.value = SEARCHLIST03;
			var sXml = sheetObj.GetSearchData("ESD_PRD_0080GS.do", PrdFQString(formObject));
			var arrXml = sXml.split("|$$|");
			for ( var i = 0; i < arrXml.length; i++) {
				sheetObjects[i].LoadSearchData(arrXml[i], { Sync : 1 });
			}
			formObject.d_del_cd.value = sheetObjects[0].GetCellValue(2, "dest_loc_cd");
			sheet1_OnClick(sheetObjects[0], 2, 1);
			break;
		}
	}
}

function sheet1_OnClick(sheetObj, row, col) {
	var formObj = document.form;
	if (sheetObj.ColSaveName(col) == "chk") {
		formObj.pctl_no.value = sheetObj.GetCellValue(row, "pctl_no");
		ComOpenWait(true);
		setTimeout(function() {
			formObj.f_cmd.value = SEARCH01;
			formObj.sXml.value = '';
			var sXml = sheetObj.GetSearchData("ESD_PRD_0080GS.do", PrdFQString(formObj));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length = 2) {
				sheetObjects[1].LoadSearchData(arrXml[0], { Sync : 1 });
				sheetObjects[2].LoadSearchData(arrXml[1], { Sync : 1 });
			}
			var arr_dt = ComGetEtcData(arrXml[0], "arr_dt");
			var transit_dt = ComGetEtcData(arrXml[0], "transit_dt");
			var return_str = ComGetEtcData(arrXml[0], "returnStr");
			var pod_cd = ComGetEtcData(arrXml[0], "pod_cd");
			var pc_ldd = ComGetEtcData(arrXml[0], "pc_ldd");
			var ldd = ComGetEtcData(arrXml[0], "ldd");
			var cnst_flg = ComGetEtcData(arrXml[0], "cnst_flg");
			var ttl_expn_amt = ComGetEtcData(arrXml[0], "ttl_expn_amt");
			var mt_pu_dt = ComGetEtcData(arrXml[0], "mt_pu_dt");
			var cml_tztm_day = ComGetEtcData(arrXml[0], "cml_tztm_day");
			formObj.fm_empty_dt.value = mt_pu_dt;
			formObj.return_str.value = return_str;
			formObj.arr_dt.value = arr_dt;
			formObj.transit_dt.value = transit_dt;
			formObj.d_pod_cd.value = pod_cd;
			formObj.ttl_expn_amt.value = ttl_expn_amt;
			formObj.cml_tztm_day.value = cml_tztm_day;
			formObj.cnst_flg.value = cnst_flg;
			document.getElementById("sheet3Title").innerHTML = ComGetEtcData(arrXml[0], 'port_cct_msg');
			ComOpenWait(false);
		}, 100);
	}
}

/**
 * 
 * @param sheetObj
 * @param code
 * @param ErrMsg
 */
function sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
	var formObj = document.form;
	sheetObj.RenderSheet(0);
	sheetObj.SetColHidden("pre_n1st_pol_dc_chk", 0);
	sheetObj.SetColHidden("pre_n1st_pol_dc", 0);
	sheetObj.SetColHidden("post_n1st_pol_dc_chk", 0);
	sheetObj.SetColHidden("post_n1st_pol_dc", 0);
	sheetObj.SetColHidden("n1st_pol_chk", 0);
	sheetObj.SetColHidden("pre_n1st_pod_dc_chk", 0);
	sheetObj.SetColHidden("pre_n1st_pod_dc", 0);
	sheetObj.SetColHidden("post_n1st_pod_dc_chk", 0);
	sheetObj.SetColHidden("post_n1st_pod_dc", 0);
	sheetObj.SetColHidden("n1st_pod_chk", 0);
	sheetObj.SetColHidden("pre_n2nd_pol_dc_chk", 0);
	sheetObj.SetColHidden("pre_n2nd_pol_dc", 0);
	sheetObj.SetColHidden("post_n2nd_pol_dc_chk", 0);
	sheetObj.SetColHidden("post_n2nd_pol_dc", 0);
	sheetObj.SetColHidden("n2nd_pol_chk", 0);
	sheetObj.SetColHidden("pre_n3rd_pol_dc_chk", 0);
	sheetObj.SetColHidden("pre_n3rd_pol_dc", 0);
	sheetObj.SetColHidden("post_n3rd_pol_dc_chk", 0);
	sheetObj.SetColHidden("post_n3rd_pol_dc", 0);
	sheetObj.SetColHidden("n3rd_pol_chk", 0);
	sheetObj.SetColHidden("pre_n3rd_pod_dc_chk", 0);
	sheetObj.SetColHidden("pre_n3rd_pod_dc", 0);
	sheetObj.SetColHidden("post_n3rd_pod_dc_chk", 0);
	sheetObj.SetColHidden("post_n3rd_pod_dc", 0);
	sheetObj.SetColHidden("n3rd_pod_chk", 0);
	sheetObj.SetColHidden("pre_n4th_pol_dc_chk", 0);
	sheetObj.SetColHidden("pre_n4th_pol_dc", 0);
	sheetObj.SetColHidden("post_n4th_pol_dc_chk", 0);
	sheetObj.SetColHidden("post_n4th_pol_dc", 0);
	sheetObj.SetColHidden("n4th_pol_chk", 0);
	sheetObj.SetColHidden("pre_n4th_pod_dc_chk", 0);
	sheetObj.SetColHidden("pre_n4th_pod_dc", 0);
	sheetObj.SetColHidden("post_n4th_pod_dc_chk", 0);
	sheetObj.SetColHidden("post_n4th_pod_dc", 0);
	sheetObj.SetColHidden("n4th_pod_chk", 0);
	if (sheetObj.RowCount() > 0) {
		sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "chk", 1, 0);
		if (formObj.pre_n1st_pol_dc.value != "Y") {
			sheetObj.SetColHidden("pre_n1st_pol_dc_chk", 1);
			sheetObj.SetColHidden("pre_n1st_pol_dc", 1);
		}
		if (formObj.post_n1st_pol_dc.value != "Y") {
			sheetObj.SetColHidden("post_n1st_pol_dc_chk", 1);
			sheetObj.SetColHidden("post_n1st_pol_dc", 1);
		}
		if (formObj.pre_n1st_pol_dc.value != "Y" && formObj.post_n1st_pol_dc.value != "Y") {
			sheetObj.SetColHidden("n1st_pol_chk", 1);
		}
		if (formObj.pre_n1st_pod_dc.value != "Y") {
			sheetObj.SetColHidden("pre_n1st_pod_dc_chk", 1);
			sheetObj.SetColHidden("pre_n1st_pod_dc", 1);
		}
		if (formObj.post_n1st_pod_dc.value != "Y") {
			sheetObj.SetColHidden("post_n1st_pod_dc_chk", 1);
			sheetObj.SetColHidden("post_n1st_pod_dc", 1);
		}
		if (formObj.pre_n1st_pod_dc.value != "Y" && formObj.post_n1st_pod_dc.value != "Y") {
			sheetObj.SetColHidden("n1st_pod_chk", 1);
		}
		if (formObj.pre_n2nd_pol_dc.value != "Y") {
			sheetObj.SetColHidden("pre_n2nd_pol_dc_chk", 1);
			sheetObj.SetColHidden("pre_n2nd_pol_dc", 1);
		}
		if (formObj.post_n2nd_pol_dc.value != "Y") {
			sheetObj.SetColHidden("post_n2nd_pol_dc_chk", 1);
			sheetObj.SetColHidden("post_n2nd_pol_dc", 1);
		}
		if (formObj.pre_n2nd_pol_dc.value != "Y" && formObj.post_n2nd_pol_dc.value != "Y") {
			sheetObj.SetColHidden("n2nd_pol_chk", 1);
		}
		if (formObj.pre_n2nd_pod_dc.value != "Y") {
			sheetObj.SetColHidden("pre_n2nd_pod_dc_chk", 1);
			sheetObj.SetColHidden("pre_n2nd_pod_dc", 1);
		}
		if (formObj.post_n2nd_pod_dc.value != "Y") {
			sheetObj.SetColHidden("post_n2nd_pod_dc_chk", 1);
			sheetObj.SetColHidden("post_n2nd_pod_dc", 1);
		}
		if (formObj.pre_n2nd_pod_dc.value != "Y" && formObj.post_n2nd_pod_dc.value != "Y") {
			sheetObj.SetColHidden("n2nd_pod_chk", 1);
		}
		if (formObj.pre_n3rd_pol_dc.value != "Y") {
			sheetObj.SetColHidden("pre_n3rd_pol_dc_chk", 1);
			sheetObj.SetColHidden("pre_n3rd_pol_dc", 1);
		}
		if (formObj.post_n3rd_pol_dc.value != "Y") {
			sheetObj.SetColHidden("post_n3rd_pol_dc_chk", 1);
			sheetObj.SetColHidden("post_n3rd_pol_dc", 1);
		}
		if (formObj.pre_n3rd_pol_dc.value != "Y" && formObj.post_n3rd_pol_dc.value != "Y") {
			sheetObj.SetColHidden("n3rd_pol_chk", 1);
		}
		if (formObj.pre_n3rd_pod_dc.value != "Y") {
			sheetObj.SetColHidden("pre_n3rd_pod_dc_chk", 1);
			sheetObj.SetColHidden("pre_n3rd_pod_dc", 1);
		}
		if (formObj.post_n3rd_pod_dc.value != "Y") {
			sheetObj.SetColHidden("post_n3rd_pod_dc_chk", 1);
			sheetObj.SetColHidden("post_n3rd_pod_dc", 1);
		}
		if (formObj.pre_n3rd_pod_dc.value != "Y" && formObj.post_n3rd_pod_dc.value != "Y") {
			sheetObj.SetColHidden("n3rd_pod_chk", 1);
		}
		if (formObj.pre_n4th_pol_dc.value != "Y") {
			sheetObj.SetColHidden("pre_n4th_pol_dc_chk", 1);
			sheetObj.SetColHidden("pre_n4th_pol_dc", 1);
		}
		if (formObj.post_n4th_pol_dc.value != "Y") {
			sheetObj.SetColHidden("post_n4th_pol_dc_chk", 1);
			sheetObj.SetColHidden("post_n4th_pol_dc", 1);
		}
		if (formObj.pre_n4th_pol_dc.value != "Y" && formObj.post_n4th_pol_dc.value != "Y") {
			sheetObj.SetColHidden("n4th_pol_chk", 1);
		}
		if (formObj.pre_n4th_pod_dc.value != "Y") {
			sheetObj.SetColHidden("pre_n4th_pod_dc_chk", 1);
			sheetObj.SetColHidden("pre_n4th_pod_dc", 1);
		}
		if (formObj.post_n4th_pod_dc.value != "Y") {
			sheetObj.SetColHidden("post_n4th_pod_dc_chk", 1);
			sheetObj.SetColHidden("post_n4th_pod_dc", 1);
		}
		if (formObj.pre_n4th_pod_dc.value != "Y" && formObj.post_n4th_pod_dc.value != "Y") {
			sheetObj.SetColHidden("n4th_pod_chk", 1);
		}
		for ( var row = 2; row <= sheetObj.RowCount() + 1; row++) {
			sheetObj.SetCellEditable(row, "pctl_no", 0);
			sheetObj.SetCellEditable(row, "upd_ind_cd", 0);
			sheetObj.SetCellEditable(row, "ocn_rout_prio_cd", 0);
			sheetObj.SetCellEditable(row, "cut_off", 0);
			sheetObj.SetCellEditable(row, "ttl_expn_amt", 0);
			sheetObj.SetCellEditable(row, "tztm_hrs", 0);
			sheetObj.SetCellEditable(row, "n1st_vsl_slan_cd", 0);
			sheetObj.SetCellEditable(row, "n1st_pol", 0);
			sheetObj.SetCellEditable(row, "n1st_pod", 0);
			sheetObj.SetCellEditable(row, "n1st_slan_cd", 0);
			sheetObj.SetCellEditable(row, "n1st_space", 0);
			sheetObj.SetCellEditable(row, "n2nd_vsl_slan_cd", 0);
			sheetObj.SetCellEditable(row, "n2nd_pol", 0);
			sheetObj.SetCellEditable(row, "n2nd_pod", 0);
			sheetObj.SetCellEditable(row, "n2nd_space", 0);
			sheetObj.SetCellEditable(row, "n3rd_vsl_slan_cd", 0);
			sheetObj.SetCellEditable(row, "n3rd_pol", 0);
			sheetObj.SetCellEditable(row, "n3rd_pod", 0);
			sheetObj.SetCellEditable(row, "n3rd_space", 0);
			sheetObj.SetCellEditable(row, "n4th_vsl_slan_cd", 0);
			sheetObj.SetCellEditable(row, "n4th_pol", 0);
			sheetObj.SetCellEditable(row, "n4th_pod", 0);
			sheetObj.SetCellEditable(row, "n4th_space", 0);
			sheetObj.SetCellEditable(row, "post_n1st_pol_dc", 0);
			sheetObj.SetCellEditable(row, "post_n1st_pod_dc", 0);
			sheetObj.SetCellEditable(row, "post_n2nd_pol_dc", 0);
			sheetObj.SetCellEditable(row, "post_n2nd_pod_dc", 0);
			sheetObj.SetCellEditable(row, "post_n3rd_pol_dc", 0);
			sheetObj.SetCellEditable(row, "post_n3rd_pod_dc", 0);
			sheetObj.SetCellEditable(row, "post_n4th_pol_dc", 0);
			sheetObj.SetCellEditable(row, "post_n4th_pod_dc", 0);
			sheetObj.SetCellEditable(row, "pre_n1st_pol_dc", 0);
			sheetObj.SetCellEditable(row, "pre_n1st_pod_dc", 0);
			sheetObj.SetCellEditable(row, "pre_n2nd_pol_dc", 0);
			sheetObj.SetCellEditable(row, "pre_n2nd_pod_dc", 0);
			sheetObj.SetCellEditable(row, "pre_n3rd_pol_dc", 0);
			sheetObj.SetCellEditable(row, "pre_n3rd_pod_dc", 0);
			sheetObj.SetCellEditable(row, "pre_n4th_pol_dc", 0);
			sheetObj.SetCellEditable(row, "pre_n4th_pod_dc", 0);
			sheetObj.SetCellValue(row, "n1st_pol_chk", "Y", 0);
			sheetObj.SetCellValue(row, "n1st_pod_chk", "Y", 0);
			sheetObj.SetCellValue(row, "n2nd_pol_chk", "Y", 0);
			sheetObj.SetCellValue(row, "n2nd_pod_chk", "Y", 0);
			sheetObj.SetCellValue(row, "n3rd_pol_chk", "Y", 0);
			sheetObj.SetCellValue(row, "n3rd_pod_chk", "Y", 0);
			sheetObj.SetCellValue(row, "n4th_pol_chk", "Y", 0);
			sheetObj.SetCellValue(row, "n4th_pod_chk", "Y", 0);
			sheetObj.SetCellEditable(row, "n1st_pol_chk", 0);
			sheetObj.SetCellEditable(row, "n1st_pod_chk", 0);
			sheetObj.SetCellEditable(row, "n2nd_pol_chk", 0);
			sheetObj.SetCellEditable(row, "n2nd_pod_chk", 0);
			sheetObj.SetCellEditable(row, "n3rd_pol_chk", 0);
			sheetObj.SetCellEditable(row, "n3rd_pod_chk", 0);
			sheetObj.SetCellEditable(row, "n4th_pol_chk", 0);
			sheetObj.SetCellEditable(row, "n4th_pod_chk", 0);
			if (sheetObj.GetCellValue(row, "n1st_pol_dc_clpt_seq") == "") {
				sheetObj.SetCellEditable(row, "pre_n1st_pol_dc_chk", 0);
				sheetObj.SetCellEditable(row, "post_n1st_pol_dc_chk", 0);
			}
			if (sheetObj.GetCellValue(row, "n1st_pod_dc_clpt_seq") == "") {
				sheetObj.SetCellEditable(row, "pre_n1st_pod_dc_chk", 0);
				sheetObj.SetCellEditable(row, "post_n1st_pod_dc_chk", 0);
			}
			if (sheetObj.GetCellValue(row, "n2nd_pol_dc_clpt_seq") == "") {
				sheetObj.SetCellEditable(row, "pre_n2nd_pol_dc_chk", 0);
				sheetObj.SetCellEditable(row, "post_n2nd_pol_dc_chk", 0);
			}
			if (sheetObj.GetCellValue(row, "n2nd_pod_dc_clpt_seq") == "") {
				sheetObj.SetCellEditable(row, "pre_n2nd_pod_dc_chk", 0);
				sheetObj.SetCellEditable(row, "post_n2nd_pod_dc_chk", 0);
			}
			if (sheetObj.GetCellValue(row, "n3rd_pol_dc_clpt_seq") == "") {
				sheetObj.SetCellEditable(row, "pre_n3rd_pol_dc_chk", 0);
				sheetObj.SetCellEditable(row, "post_n3rd_pol_dc_chk", 0);
			}
			if (sheetObj.GetCellValue(row, "n3rd_pod_dc_clpt_seq") == "") {
				sheetObj.SetCellEditable(row, "pre_n3rd_pod_dc_chk", 0);
				sheetObj.SetCellEditable(row, "post_n3rd_pod_dc_chk", 0);
			}
			if (sheetObj.GetCellValue(row, "n4th_pol_dc_clpt_seq") == "") {
				sheetObj.SetCellEditable(row, "pre_n4th_pol_dc_chk", 0);
				sheetObj.SetCellEditable(row, "post_n4th_pol_dc_chk", 0);
			}
			if (sheetObj.GetCellValue(row, "n4th_pod_dc_clpt_seq") == "") {
				sheetObj.SetCellEditable(row, "pre_n4th_pod_dc_chk", 0);
				sheetObj.SetCellEditable(row, "post_n4th_pod_dc_chk", 0);
			}
		}
		sheetObj.RenderSheet(1);
	}
	var fCol = 0;
	var tCol = 0;
	for ( var i = parseInt(sheetObj.HeaderRows()); i <= parseInt(sheetObj.HeaderRows()) + sheetObj.RowCount(); i++) {
		fCol = 0;
		tCol = 0;
		if (sheetObj.GetCellValue(i, 'vvd_lnk_no') == '1') {
			fCol = sheetObj.SaveNameCol("n1st_vsl_slan_cd");
			tCol = sheetObj.SaveNameCol("n1st_space");
			sheetObj.SetRangeBackColor(i, fCol, i, tCol, "#FFFF00");
		} else if (sheetObj.GetCellValue(i, 'vvd_lnk_no') == '2') {
			fCol = sheetObj.SaveNameCol("n2nd_vsl_slan_cd");
			tCol = sheetObj.SaveNameCol("n2nd_space");
			sheetObj.SetRangeBackColor(i, fCol, i, tCol, "#FFFF00");
		} else if (sheetObj.GetCellValue(i, 'vvd_lnk_no') == '3') {
			fCol = sheetObj.SaveNameCol("n3rd_vsl_slan_cd");
			tCol = sheetObj.SaveNameCol("n3rd_space");
			sheetObj.SetRangeBackColor(i, fCol, i, tCol, "#FFFF00");
		} else if (sheetObj.GetCellValue(i, 'vvd_lnk_no') == '4') {
			fCol = sheetObj.SaveNameCol("n4th_vsl_slan_cd");
			tCol = sheetObj.SaveNameCol("n4th_space");
			sheetObj.SetRangeBackColor(i, fCol, i, tCol, "#FFFF00");
		}
	}
}