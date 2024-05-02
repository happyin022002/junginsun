/* =========================================================
 *Copyright(c) 2016 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_PRD_0039.js
 *@FileTitle  : VGM CCT History
 *@author     : CLT
 *@version    : 1.0
 *@since      :
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;

document.onclick = processButtonClick;
function processButtonClick() {
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName)) {
			return false;
		}
		switch (srcName) {
			case "btn_retrieve":
				break;
			case "btn_new": 
				break;
			case "btn_Close":
				ComClosePopup();
				break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111'));
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
	var formObj = document.form;
	for (var i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH)
}


/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var hiddenType = pctl_use_flg + vgm_flg;
	var cnt = 0;
	switch (sheetNo) {
		case 1: {
			with (sheetObj) {
				var HeadTitle = "SEQ|pctl_use_flg|Yard Code|Lane Code|Bound|Cargo Type|VVD|CCT Type|CCT HOUR|Trunc|MDA Based|CCT DAY|CCT TIME(hh:mm)|Fri|Sat|Sun|Holi|General|DG|Reefer|Awkward|Break Bulk|Cargo Closing Time|Delete\nFlag|Update User Id|Update Date";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
				var headers = [ { Text : HeadTitle, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [
							{ Type : "Seq",  	Hidden : 0,  Width : 30, 	Align : "Center", 	ColMerge : 0, SaveName : "", 				KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 1,  Width : 0, 	Align : "Center", 	ColMerge : 0, SaveName : "pctl_use_flg",    KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 1,  Width : 0, 	Align : "Center", 	ColMerge : 0, SaveName : "yd_cd",    		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 1,  Width : 0, 	Align : "Center", 	ColMerge : 0, SaveName : "vsl_slan_cd",   	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 1,  Width : 0, 	Align : "Center", 	ColMerge : 0, SaveName : "vsl_slan_dir_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 1,  Width : 0, 	Align : "Center", 	ColMerge : 0, SaveName : "cgo_tp_cd",    	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 1,  Width : 0, 	Align : "Center", 	ColMerge : 0, SaveName : "vvd_cd",    		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 1,  Width : 0, 	Align : "Center", 	ColMerge : 0, SaveName : "cct_tp_cd",    	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 1,  Width : 0, 	Align : "Center", 	ColMerge : 0, SaveName : "cct_hr",    		KeyField : 0, CalcLogic : "", Format : "-##H", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "CheckBox",Hidden : 1,  Width : 0, 	Align : "Center", 	ColMerge : 0, SaveName : "cct_file_flg",    KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "CheckBox",Hidden : 1,  Width : 0, 	Align : "Center", 	ColMerge : 0, SaveName : "yd_bse_calc_flg", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 1,  Width : 0, 	Align : "Center", 	ColMerge : 0, SaveName : "cct_dy_cd",    	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 1,  Width : 0, 	Align : "Center", 	ColMerge : 0, SaveName : "cct_hrmnt",    	KeyField : 0, CalcLogic : "", Format : "Hm", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "CheckBox",Hidden : 1,  Width : 30, 	Align : "Left", 	ColMerge : 0, SaveName : "xcld_hol_fri_flg",KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "CheckBox",Hidden : 1,  Width : 30, 	Align : "Left", 	ColMerge : 0, SaveName : "xcld_hol_sat_flg",KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "CheckBox",Hidden : 1,  Width : 30, 	Align : "Left", 	ColMerge : 0, SaveName : "xcld_hol_sun_flg",KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "CheckBox",Hidden : 1,  Width : 30, 	Align : "Left", 	ColMerge : 0, SaveName : "xcld_hol_hol_flg",KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Date", 	Hidden : 1,  Width : 120, 	Align : "Center", 	ColMerge : 0, SaveName : "cgo_clz_dt",    	KeyField : 0, CalcLogic : "", Format : "YmdHm", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Date", 	Hidden : 1,  Width : 120, 	Align : "Center", 	ColMerge : 0, SaveName : "dcgo_clz_dt",    	KeyField : 0, CalcLogic : "", Format : "YmdHm", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Date", 	Hidden : 1,  Width : 120, 	Align : "Center", 	ColMerge : 0, SaveName : "rc_clz_dt",    	KeyField : 0, CalcLogic : "", Format : "YmdHm", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Date", 	Hidden : 1,  Width : 120, 	Align : "Center", 	ColMerge : 0, SaveName : "awk_cgo_clz_dt",  KeyField : 0, CalcLogic : "", Format : "YmdHm", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Date", 	Hidden : 1,  Width : 120, 	Align : "Center", 	ColMerge : 0, SaveName : "bb_cgo_clz_dt",   KeyField : 0, CalcLogic : "", Format : "YmdHm", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Date", 	Hidden : 1,  Width : 120, 	Align : "Center", 	ColMerge : 0, SaveName : "vgm_clz_dt",    	KeyField : 0, CalcLogic : "", Format : "YmdHm", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0,  Width : 60, 	Align : "Center", 	ColMerge : 0, SaveName : "delt_flg",    	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0,  Width : 100, 	Align : "Center", 	ColMerge : 0, SaveName : "upd_usr_id",    	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Date", 	Hidden : 0,  Width : 120, 	Align : "Center", 	ColMerge : 0, SaveName : "upd_dt",    		KeyField : 0, CalcLogic : "", Format : "YmdHms", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }
					];
				InitColumns(cols);
				switch(hiddenType) {
					case "YY" : 
					case "YN" :  {
						SetColHidden('cct_tp_cd', 0);
						SetColHidden('cct_hr', 0);
						SetColHidden('cct_file_flg', 0);
						SetColHidden('yd_bse_calc_flg', 0);
						SetColHidden('cct_dy_cd', 0);
						SetColHidden('cct_hrmnt', 0);
						SetColHidden('xcld_hol_fri_flg', 0);
						SetColHidden('xcld_hol_sat_flg', 0);
						SetColHidden('xcld_hol_sun_flg', 0);
						SetColHidden('xcld_hol_hol_flg', 0);
						break;
					}
					case "NY" :  {
						SetColHidden('vgm_clz_dt', 0);
						break;
					}
					case "NN" :  {
						SetColHidden('cgo_clz_dt', 0);
						SetColHidden('dcgo_clz_dt', 0);
						SetColHidden('rc_clz_dt', 0);
						SetColHidden('awk_cgo_clz_dt', 0);
						SetColHidden('bb_cgo_clz_dt', 0);
						break;
					}
				}
				SetVisible(true);
				ComResizeSheet(sheetObj);
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
		case IBSEARCH: {
			formObj.f_cmd.value = SEARCHLIST;
			sheetObj.DoSearch("ESD_PRD_0039GS.do", PrdFQString(formObj));
			break;
		}
	}
}