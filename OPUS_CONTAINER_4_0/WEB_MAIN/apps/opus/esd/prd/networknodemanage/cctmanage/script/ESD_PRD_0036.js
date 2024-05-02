/* =========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName 	 : ESD_PRD_0036.js
 *@FileTitle  : CCT Management by Yard for Export Booking 
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/22 
=========================================================*/
// Common global variable
var sheetObjects = new Array();
var sheetCnt = 0;
var validateData = "";
var retValidate = 0;
var locCd = "";
var mode = "";
var beforPopupBtnName = "";
var prefix = "sheet2_";

document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject;
	var formObject = document.form;
	var con_cd_val;
	var param;
	if (formObject.chk_t[0].checked) {
		sheetObject = sheetObjects[0];
	} else {
		sheetObject = sheetObjects[1];
	}
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName)) {
			return false;
		}
		switch (srcName) {
			case "btn_retrieve":
				if (!checkInput()) {
					return;
				}
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;
			case "btn_new": {
				formObject.reset();
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				formObject.chk_t[0].checked = true;
				fncRadioCheck(formObject.chk_t[0]);
				break;
			}
			case "btn_save": {
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
			}
			case "btng_rowadd": {
				doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
				break;
			}
			case "btng_rowcopy": {
				doActionIBSheet(sheetObjects[0], formObject, IBCOPYROW);
				break;
			}
			case "btn_cnt": {
				selectCountry('cnt');
				break;
			}
			case "btn_downexcel": {
				if (sheetObject.RowCount() < 1) {
					ComShowCodeMessage("COM132501");
				} else {
					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
				}
				break;
			}
			case "btn_loadexcel": {
				doActionIBSheet(sheetObjects[0], formObject, IBLOADEXCEL);
				break;
			}
			case "loc_btn": {
				if (formObject.chk_t[0].checked) {
					var loc_cd_val = formObject.location_code.value;
					param = '?loc_cd=' + loc_cd_val;
					ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 550, 'getLocation', "1,0,1,1,1,1,1,1,1,1,1,1", true);
				}
				break;
			}
			case "node_btn": {
				if (formObject.chk_t[0].checked) {
					param = '?classId=' + "COM_ENS_061" + '&node_cd=' + formObject.yard_code.value;
					ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 810, 550, 'getNode', "1,0,1,1,1,1,1,1,1,1,1,1", true);
				}
				break;
			}
			case "btn_slan": {
				if (formObject.chk_t[0].checked) {
					beforPopupBtnName = srcName;
					param = '?lane_cd=' + formObject.lane_code.value;
					ComOpenPopup('/opuscntr/COM_ENS_081.do' + param, 800, 420, 'getLane', "1,0,1,1,1,1,1,1,1,1,1,1", true);
				}
				break;
			}
			case "btn_lane_cd": {
				if (formObject.chk_t[1].checked) {
					beforPopupBtnName = srcName;
					param = '?lane_cd=' + formObject.lane_code.value;
					ComOpenPopup('/opuscntr/COM_ENS_081.do' + param, 800, 420, 'getLane', "1,0,1,1,1,1,1,1,1,1,1,1", true);
				}
				break;
			}
			case "btn_period": {
				if (formObject.chk_t[1].checked) {
					var cal = new ComCalendarFromTo();
					cal.select(formObject.fm_dt, formObject.to_dt, 'yyyyMMdd');
				}
				break;
			}
			case "btn_port": {
				if (formObject.chk_t[1].checked) {
					ComOpenPopup("/opuscntr/VOP_VSK_0043.do", 422, 520, "returnPortHelp", "0,0", true);
				}
				break;
			}
			case "btn_vsl_cd": {
				if (formObject.chk_t[1].checked) {
					ComOpenPopup("/opuscntr/VOP_VSK_0219.do", 460, 500, "returnVslCdHelp", "0,0", true);
				}
				break;
			}

			case "btn_carrier_cd": {
				if (formObject.chk_t[1].checked) {
					param = "?code_type=CD0XXXX&code_value=" + formObject.carrier_cd.value;
					ComOpenPopup("/opuscntr/VOP_VSK_0252.do" + param, 500, 420, "returnCrrCdHelp", "0,0", true);
				}
				break;
			}
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111'));
		} else {
			ComShowMessage(e.message);
		}
	}
}
var cntGb = '';
function selectCountry(cnt) {
	cntGb = cnt;
	var frm = document.form;
	var param = '?classId=' + "COM_ENS_051"
	if (cntGb == 'cnt') {
		param = param + '&cnt_cd=' + frm.country_code.value;
	}
	ComOpenPopup('/opuscntr/COM_ENS_0M1.do' + param, 800, 510, 'getCountry', "1,0,1,1,1,1,1,1,1,1,1,1", true);
}
function getCountry(rowArray) {
	var colArray = rowArray[0];
	var frm = document.form;
	if (cntGb == 'cnt') {
		frm.country_code.value = colArray[3];
	}
}
function getCon(rowArray) {
	var colArray = rowArray[0];
	document.all.textc.value = colArray[3];
}
function getLocation(rowArray) {
	var colArray = rowArray[0];
	document.all.location_code.value = colArray[3];
}
function getNode(rowArray) {
	var colArray = rowArray[0];
	document.all.yard_code.value = colArray[3];
}
function getLane(rowArray) {
	var colArray = rowArray[0];
	if (beforPopupBtnName == 'btn_slan') {
		document.all.lane_code.value = colArray[3];
	} else {
		document.all.vsl_slan_cd.value = colArray[3];
	}

}
/**
 * 
 * @param rtnObjs
 */
function returnPortHelp(rtnObjs) {
	var formObj = document.form;
	formObj.vps_port_cd.value = rtnObjs;
}
/**
 * 
 * @param rtnObjs
 */
function returnVslCdHelp(rtnObjs) {
	var formObj = document.form;
	if (rtnObjs != undefined) {
		var rtnDatas = rtnObjs[0];
		if (rtnDatas.length > 1) {
			formObj.vsl_cd.value = rtnDatas[1];
		}
	}
}
/**
 * 
 * @param sCrrCd
 */
function returnCrrCdHelp(sCrrCd) {
	var formObj = document.form;
	if (sCrrCd != null && sCrrCd != undefined && sCrrCd != "") {
		formObj.carrier_cd.value = sCrrCd.substring(0, 3);
	} else {
		formObj.carrier_cd.value = "";
	}
}
/*
 * checking input condition for retrieve
 */
function checkInput() {
	var formObject = document.form;
	return true;
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
 */
function loadPage() {
	var formObj = document.form;
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	if (locCd != "") {
		formObj.f_cmd.value = SEARCH;
		sheetObjects[0].DoSearch("ESD_PRD_0036GS.do", PrdFQString(formObj), { Sync : 2 });
	}
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
	axon_event.addListener('keypress', 'PrdComKeyEnter', 'country_code', 'location_code', 'yard_code', 'lane_code', 'vps_port_cd', 'vsl_cd', 'vsl_slan_cd', 'carrier_cd');
	fncRadioCheck(formObj.chk_t[0]);
}

/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
		case 1: {
			with (sheetObj) {
				var HeadTitle = "SEQ|STS|Del|Act|LOC Code|Yard Code|Lane Code|Bound|Cargo Type|Cargo Closing Time|Cargo Closing Time|Cargo Closing Time|Cargo Closing Time|Cargo Closing Time|Cargo Closing Time|Cargo Closing Time|Excl Day|Excl Day|Excl Day|Excl Day|Cargo Closing Time For VGM|Cargo Closing Time For VGM|Cargo Closing Time For VGM|Cargo Closing Time For VGM|Cargo Closing Time For VGM|Cargo Closing Time For VGM|Cargo Closing Time For VGM|Excl Day For VGM|Excl Day For VGM|Excl Day For VGM|Excl Day For VGM|cct_type";
				var HeadTitle1 = "SEQ|STS|Del|Act|LOC Code|Yard Code|Lane Code|Bound|Cargo Type|CCT TYPE|CCT HOUR|Trunc|MDA Based|CCT DAY|CCT TIME(hh:mm)||Fri|Sat|Sun|Holi|CCT TYPE|CCT HOUR|Trunc|MDA Based|CCT DAY|CCT TIME(hh:mm)||Fri|Sat|Sun|Holi|cct_type";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
				var headers = [ { Text : HeadTitle, Align : "Center" }, { Text : HeadTitle1, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [
							{ Type : "Seq", 		Hidden : 0, Width : 30, 	Align : "Center", 	ColMerge : 0, SaveName : "", 				KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
							{ Type : "Status", 		Hidden : 0, Width : 30, 	Align : "Center", 	ColMerge : 0, SaveName : "ibflag", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
							{ Type : "DelCheck", 	Hidden : 0, Width : 30, 	Align : "Center", 	ColMerge : 0, SaveName : "del_flag", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
							{ Type : "CheckBox", 	Hidden : 0, Width : 30, 	Align : "Center", 	ColMerge : 0, SaveName : "delete_flag", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
							{ Type : "Text", 		Hidden : 0, Width : 80, 	Align : "Center", 	ColMerge : 0, SaveName : "location_code", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "PopupEdit", 	Hidden : 0, Width : 100, 	Align : "Center", 	ColMerge : 0, SaveName : "yard_code", 		KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 7 },
							{ Type : "PopupEdit", 	Hidden : 0, Width : 80, 	Align : "Center", 	ColMerge : 0, SaveName : "lane_code", 		KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 3 },
							{ Type : "Combo", 		Hidden : 0, Width : 80, 	Align : "Left", 	ColMerge : 0, SaveName : "lane_dir_code", 	KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
							{ Type : "Combo", 		Hidden : 0, Width : 85, 	Align : "Left", 	ColMerge : 0, SaveName : "cargo_type", 		KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
							
							{ Type : "Combo", 		Hidden : 0, Width : 80, 	Align : "Left", 	ColMerge : 0, SaveName : "cct_type", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
							{ Type : "Text", 		Hidden : 0, Width : 80, 	Align : "Center", 	ColMerge : 0, SaveName : "cct_hour", 		KeyField : 0, CalcLogic : "", Format : "-##H", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
							{ Type : "CheckBox", 	Hidden : 0, Width : 80, 	Align : "Center",	ColMerge : 0, SaveName : "cct_file_flg", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
							{ Type : "CheckBox", 	Hidden : 0, Width : 80, 	Align : "Center", 	ColMerge : 0, SaveName : "yd_bse_calc_flg", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
							{ Type : "Combo", 		Hidden : 0, Width : 80, 	Align : "Center", 	ColMerge : 0, SaveName : "cct_day", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 0 },
							{ Type : "Text", 		Hidden : 0, Width : 110, 	Align : "Center", 	ColMerge : 0, SaveName : "cct_time", 		KeyField : 0, CalcLogic : "", Format : "Hm", PointCount : 0, UpdateEdit : 1, InsertEdit : 0},
							{ Type : "Image", 		Hidden : 0, Width : 20, 	Align : "Center", 	ColMerge : 0, SaveName : "cct_his_pop", 	KeyField : 0, CalcLogic : "", Format : "" },
							
							{ Type : "CheckBox", 	Hidden : 0, Width : 50, 	Align : "Left", 	ColMerge : 0, SaveName : "fri_flag", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
							{ Type : "CheckBox", 	Hidden : 0, Width : 50, 	Align : "Left", 	ColMerge : 0, SaveName : "sat_flag", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
							{ Type : "CheckBox", 	Hidden : 0, Width : 50, 	Align : "Left", 	ColMerge : 0, SaveName : "sun_flag", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
							{ Type : "CheckBox", 	Hidden : 0, Width : 50, 	Align : "Left", 	ColMerge : 0, SaveName : "holi_flag", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
							
							{ Type : "Combo", 		Hidden : 0, Width : 80, 	Align : "Left", 	ColMerge : 0, SaveName : "vgm_clz_tp_cd", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
							{ Type : "Text", 		Hidden : 0, Width : 80, 	Align : "Center", 	ColMerge : 0, SaveName : "vgm_clz_hr", 		KeyField : 0, CalcLogic : "", Format : "-##H", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
							{ Type : "CheckBox", 	Hidden : 0, Width : 80, 	Align : "Center",	ColMerge : 0, SaveName : "vgm_clz_file_flg",KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
							{ Type : "CheckBox", 	Hidden : 0, Width : 80, 	Align : "Center", 	ColMerge : 0, SaveName : "vgm_yd_bse_calc_flg", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
							{ Type : "Combo", 		Hidden : 0, Width : 80, 	Align : "Center", 	ColMerge : 0, SaveName : "vgm_clz_dy_cd", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 0 },
							{ Type : "Text", 		Hidden : 0, Width : 110, 	Align : "Center", 	ColMerge : 0, SaveName : "vgm_clz_hrmnt", 	KeyField : 0, CalcLogic : "", Format : "Hm", PointCount : 0, UpdateEdit : 1, InsertEdit : 0},
							{ Type : "Image", 		Hidden : 0, Width : 20, 	Align : "Center", 	ColMerge : 0, SaveName : "vgm_his_pop", 	KeyField : 0, CalcLogic : "", Format : "" },
							
							{ Type : "CheckBox", 	Hidden : 0, Width : 50, 	Align : "Left", 	ColMerge : 0, SaveName : "vgm_xcld_hol_fri_flg", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
							{ Type : "CheckBox", 	Hidden : 0, Width : 50, 	Align : "Left", 	ColMerge : 0, SaveName : "vgm_xcld_hol_sat_flg", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
							{ Type : "CheckBox", 	Hidden : 0, Width : 50, 	Align : "Left", 	ColMerge : 0, SaveName : "vgm_xcld_hol_sun_flg", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
							{ Type : "CheckBox", 	Hidden : 0, Width : 50, 	Align : "Left", 	ColMerge : 0, SaveName : "vgm_xcld_hol_hol_flg", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
							
							{ Type : "Text", 		Hidden : 1, Width : 50, 	Align : "Left", 	ColMerge : 0, SaveName : "cct_old_type", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 		Hidden : 1, Width : 50, 	Align : "Left", 	ColMerge : 0, SaveName : "org_delete_flag", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 }
					];
				InitColumns(cols);
				SetEditable(1);
				
				SetColProperty(0, "cct_type", 	{ ComboText : "ETB|ETD|Day|CMN", ComboCode : "ETB|ETD|Day|CMN" });
				SetColProperty(0, "lane_dir_code", { ComboText : "ALL|E|W|N|S", ComboCode : "A|E|W|N|S" });
				SetColProperty(0, "cargo_type", { ComboText : "ALL|Dry|Reefer|DG|Awkward|Break Bulk", ComboCode : "AL|DR|RF|DG|AK|BB" });
				SetColProperty(0, "cct_day", 	{ ComboText : cct_dayText, ComboCode : cct_dayCode });
				SetColProperty(0, "yard_code", 	{ AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "lane_code", 	{ AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "cct_hour", 	{ AcceptKeys : "N|" });
				
				SetColProperty(0, "vgm_clz_tp_cd", 	{ ComboText : "ETB|ETD|Day|CMN", ComboCode : "ETB|ETD|Day|CMN" });
				SetColProperty(0, "vgm_clz_dy_cd", 	{ ComboText : cct_dayText, ComboCode : cct_dayCode });
				SetColProperty(0, "vgm_clz_hr", 	{ AcceptKeys : "N|" });
				
				SetImageList(0,"img/btns_search.gif");				
				SetVisible(true);
				resizeSheet(sheetObj);
			}
			break;
		}
		
		case 2: {
			with (sheetObj) {
				var HeadTitle = "|VVD|Vessel Name|Lane\nCode|TMNL\nCode|Cargo Closing Time|Cargo Closing Time|Cargo Closing Time|Cargo Closing Time|Cargo Closing Time|Cargo Closing Time|Cargo Closing Time|Cargo Closing Time|Cargo Closing Time|Cargo Closing Time|Cargo Closing Time|Cargo Closing Time\nFor VGM|Cargo Closing Time\nFor VGM|Cargo Closing Time\nFor VGM|Coastal SKD|Coastal SKD|Coastal SKD|P/F SKD|P/F SKD|Delay|Delay|Carrier\nCode|TMNL\nName|vsl_cd|skd_voy_no|skd_dir_cd|vps_port_cd|clpt_ind_seq";
				var HeadTitle2 = "|VVD|Vessel Name|Lane\nCode|TMNL\nCode|General|General|DG|DG|Reefer|Reefer|Awkward|Awkward|Break Bulk|Break Bulk||Cargo Closing Time\nFor VGM|Cargo Closing Time\nFor VGM|Cargo Closing Time\nFor VGM|ETA|ETB|ETD|ETB|ETD|Berth|Dep|Carrier\nCode|TMNL\nName|vsl_cd|skd_voy_no|skd_dir_cd|vps_port_cd|clpt_ind_seq";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [
						{ Text : HeadTitle, Align : "Center" }, { Text : HeadTitle2, Align : "Center" }
				];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "Status", 		Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : prefix + "ibflag", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", 		Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : prefix + "vvd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", 		Hidden : 0, Width : 180, Align : "Left", ColMerge : 1, SaveName : prefix + "vsl_eng_nm", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", 		Hidden : 0, Width : 45, Align : "Center", ColMerge : 1, SaveName : prefix + "vsl_slan_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", 		Hidden : 0, Width : 70, Align : "Center", ColMerge : 1, SaveName : prefix + "pol_yard", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "PopupEdit", 	Hidden : 0, Width : 90, Align : "Center", ColMerge : 0, SaveName : prefix + "cgo_clz_dt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", 		Hidden : 0, Width : 40, Align : "Center", ColMerge : 0, SaveName : prefix + "cgo_clz_dt_hhmi", KeyField : 0, CalcLogic : "", Format : "Hm", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "PopupEdit", 	Hidden : 0, Width : 90, Align : "Center", ColMerge : 0, SaveName : prefix + "dcgo_clz_dt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", 		Hidden : 0, Width : 40, Align : "Center", ColMerge : 0, SaveName : prefix + "dcgo_clz_dt_hhmi", KeyField : 0, CalcLogic : "", Format : "Hm", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "PopupEdit", 	Hidden : 0, Width : 90, Align : "Center", ColMerge : 0, SaveName : prefix + "rc_clz_dt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", 		Hidden : 0, Width : 40, Align : "Center", ColMerge : 0, SaveName : prefix + "rc_clz_dt_hhmi", KeyField : 0, CalcLogic : "", Format : "Hm", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						
						{ Type : "PopupEdit", 	Hidden : 0, Width : 90, Align : "Center", ColMerge : 0, SaveName : prefix + "awk_cgo_clz_dt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", 		Hidden : 0, Width : 40, Align : "Center", ColMerge : 0, SaveName : prefix + "awk_cgo_clz_dt_hhmi", KeyField : 0, CalcLogic : "", Format : "Hm", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "PopupEdit", 	Hidden : 0, Width : 90, Align : "Center", ColMerge : 0, SaveName : prefix + "bb_cgo_clz_dt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", 		Hidden : 0, Width : 40, Align : "Center", ColMerge : 0, SaveName : prefix + "bb_cgo_clz_dt_hhmi", KeyField : 0, CalcLogic : "", Format : "Hm", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Image", 		Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : prefix + "cct_his_pop", KeyField : 0, Image:"/opuscntr/img/opus/ico_b.gif"},
						
						{ Type : "PopupEdit", 	Hidden : 0, Width : 90, Align : "Center", ColMerge : 0, SaveName : prefix + "vgm_clz_dt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", 		Hidden : 0, Width : 40, Align : "Center", ColMerge : 0, SaveName : prefix + "vgm_clz_dt_hhmi", KeyField : 0, CalcLogic : "", Format : "Hm", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Image", 		Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : prefix + "vgm_his_pop", KeyField : 0},
						
						{ Type : "Text", 		Hidden : 0, Width : 110, Align : "Center", ColMerge : 0, SaveName : prefix + "pol_eta", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", 		Hidden : 0, Width : 110, Align : "Center", ColMerge : 0, SaveName : prefix + "pol_etb", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", 		Hidden : 0, Width : 110, Align : "Center", ColMerge : 0, SaveName : prefix + "pol_etd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", 		Hidden : 0, Width : 110, Align : "Center", ColMerge : 0, SaveName : prefix + "pf_etb", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", 		Hidden : 0, Width : 110, Align : "Center", ColMerge : 0, SaveName : prefix + "pf_etd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", 		Hidden : 1, Width : 45,  Align : "Center", ColMerge : 0, SaveName : prefix + "dely_etb_tm", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", 		Hidden : 1, Width : 45,  Align : "Center", ColMerge : 0, SaveName : prefix + "dely_etd_tm", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", 		Hidden : 0, Width : 60,  Align : "Center", ColMerge : 1, SaveName : prefix + "carrier_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", 		Hidden : 1, Width : 30,  Align : "Center", ColMerge : 1, SaveName : prefix + "pol_yard_nm", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", 		Hidden : 1, Width : 30,  Align : "Center", ColMerge : 1, SaveName : prefix + "vsl_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", 		Hidden : 1, Width : 30,  Align : "Center", ColMerge : 1, SaveName : prefix + "skd_voy_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", 		Hidden : 1, Width : 30,  Align : "Center", ColMerge : 1, SaveName : prefix + "skd_dir_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", 		Hidden : 1, Width : 75,  Align : "Center", ColMerge : 1, SaveName : prefix + "vps_port_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", 		Hidden : 1, Width : 30,  Align : "Center", ColMerge : 1, SaveName : prefix + "clpt_ind_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }
				];

				InitColumns(cols);
				SetEditable(1);
				resizeSheet(sheetObj);
				SetColProperty(prefix + "pol_eta", 	{ Format : "####-##-## ##:##" });
				SetColProperty(prefix + "pol_etb", 	{ Format : "####-##-## ##:##" });
				SetColProperty(prefix + "pol_etd", 	{ Format : "####-##-## ##:##" });
				SetColProperty(prefix + "next_eta", { Format : "####-##-## ##:##" });
				SetColProperty(prefix + "pf_etb", 	{ Format : "####-##-## ##:##" });
				SetColProperty(prefix + "pf_etd", 	{ Format : "####-##-## ##:##" });
				SetImageList(0,"img/btns_search.gif");
				SetShowButtonImage(0);
				SetVisible(false);
			}
			break;
		}
	}
}

// handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction, Gubun) {
	var uid;
	var sXml;
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH: {
			if (validateForm(sheetObj, formObj, sAction)) {
				var aryPrefix = "";
				if (sheetObj.id == 'sheet1') {
					formObj.f_cmd.value = SEARCH;
				} else {
					formObj.f_cmd.value = SEARCH01;
					aryPrefix = new Array("sheet2_");
				}
				sheetObj.DoSearch("ESD_PRD_0036GS.do", PrdFQString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			}
			break;
		}
		
		case IBSAVE: {
			if (!keyFieldCheck(sheetObj)) {
				break;
			}
			if (validateForm(sheetObj, formObj, sAction)) {
				if (sheetObj.id == 'sheet1') {
					formObj.f_cmd.value = MULTI;
				} else {
					formObj.f_cmd.value = MULTI01;
				}
				sheetObj.DoSave("ESD_PRD_0036GS.do", { Param : PrdFQString(formObj), Quest : 1 });
			}
			break;
		}
		
		case IBDOWNEXCEL: {
			sheetObj.Down2Excel({ DownCols : makeHiddenSkipCol(sheetObj), SheetDesign : 1, Merge : 1 });
			break;
		}
		
		case IBLOADEXCEL: {
			sheetObj.LoadExcel();
			break;
		}
		
		case IBINSERT:
			if (validateForm(sheetObj, formObj, sAction)) {
				sheetObj.DataInsert();
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "lane_dir_code", 'A', 0);
				if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cct_type") == "ETB" || sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cct_type") == "ETD") {
					sheetObj.SetCellEditable(sheetObj.GetSelectRow(), "cct_time", 1);
				}
			}
			break;
			
		case IBCOPYROW: {
			sheetObj.DataCopy();
			break;
		}
		
		case SEARCH04: {
			formObj.f_cmd.value = SEARCH04;
			uid = "ESD_PRD_0036";
			sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetEtcData(sXml, "rowCount");
			if (retValidate > 0) {
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "location_code", ComGetEtcData(sXml, "comData2"), 0);
			} else {
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "location_code", "", 0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "yard_code", "", 0);
				sheetObj.SelectCell(sheetObj.GetSelectRow(), "yard_code");
			}
			break;
		}
		
		case SEARCH07: {
			formObj.f_cmd.value = SEARCH07;
			uid = "ESD_PRD_0036";
			sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetEtcData(sXml, "rowCount");
			if (retValidate == "0" || retValidate == "") {
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "lane_code", "", 0);
				sheetObj.SelectCell(sheetObj.GetSelectRow(), "lane_code");
			}
			break;
		}
	}
}

/**
 * Sheet OnLoadExcel Event
 * 
 * @param sheetObj
 * @param result
 * @param code
 * @param msg
 */
function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
	if (isExceedMaxRow(msg)) {
		return;
	}
}

function sheet1_OnPopupClick(sheetObj, row, col) {
	var param;
	if (sheetObj.ColSaveName(col) == "yard_code") {
		param = '?yd_cd=' + sheetObj.GetCellValue(row, col);
		ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 800, 400, 'getYardGrid', '1,0,1,1,1,1,1,1,1,1,1,1', true, false, row, col);
	}
	
	if (sheetObj.ColSaveName(col) == "lane_code") {
		param = '?vsl_slan_cd=' + sheetObj.GetCellValue(row, col);
		ComOpenPopup('/opuscntr/COM_ENS_081.do' + param, 800, 400, 'getLaneGrid', '1,0,1,1,1,1,1,1,1,1,1,1', true, false, row, col);
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if (sheetObj.RowCount() > 0) {
		ComBtnEnable("btn_save");
	}
}

function sheet1_OnRowSearchEnd(sheetObj, Row) {
	if (sheetObj.GetCellValue(Row, 'cct_type') == 'CMN') {
		sheetObj.CellComboItem(Row, "cct_day", { ComboText : "OneDayBeforeETB", ComboCode : "" });
	}
	
	if (sheetObj.GetCellValue(Row, 'vgm_clz_tp_cd') == 'CMN') {
		sheetObj.CellComboItem(Row, "vgm_clz_dy_cd", { ComboText : "OneDayBeforeETB", ComboCode : "" });
	}
}

/**
 * 
 * @param sheetObj
 * @param errCode
 * @param errMsg
 */
function sheet1_OnSaveEnd(sheetObj, errCode, errMsg) {
	if(errCode >= 0) {
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
		ComShowCodeMessage('COM132601');
	}
}

/**
 * 
 * @param sheetObj
 * @param errCode
 * @param errMsg
 */
function sheet2_OnSaveEnd(sheetObj, errCode,  errMsg) {
	
	
	if(errCode >= 0) {
		
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
		ComShowCodeMessage('COM132601');
	}
}

/**
 * 
 * @param sheetObj
 * @param row
 * @param col
 * @returns {Boolean}
 */
function sheet2_OnPopupClick(sheetObj, row, col) {
	var selColNm = sheetObj.ColSaveName(col);
	if (selColNm == prefix + "cgo_clz_dt") {
		var cal = new ComCalendarGrid("myCal");
		cal.select(sheetObj, row, col, 'yyyyMMdd');
	} else if (selColNm == prefix + "dcgo_clz_dt") {
		var cal = new ComCalendarGrid("myCal");
		cal.select(sheetObj, row, col, 'yyyyMMdd');
	} else if (selColNm == prefix + "rc_clz_dt") {
		var cal = new ComCalendarGrid("myCal");
		cal.select(sheetObj, row, col, 'yyyyMMdd');
	} else if (selColNm == prefix + "vgm_clz_dt") {
		var cal = new ComCalendarGrid("myCal");
		cal.select(sheetObj, row, col, 'yyyyMMdd');
	} else if (selColNm == prefix + "awk_cgo_clz_dt") {
		var cal = new ComCalendarGrid("myCal");
		cal.select(sheetObj, row, col, 'yyyyMMdd');
	} else if (selColNm == prefix + "bb_cgo_clz_dt") {
		var cal = new ComCalendarGrid("myCal");
		cal.select(sheetObj, row, col, 'yyyyMMdd');		
	}
	return false;
}

/**
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @returns {Boolean}
 */
function sheet2_OnChange(sheetObj, Row, Col, Value) {
	var ColNm = sheetObj.ColSaveName(Col);
	if (ColNm == prefix + "cgo_clz_dt") {
		if (ComIsNull(Value)) {
			sheetObj.SetCellValue(Row, prefix + "cgo_clz_dt_hhmi", '', 0);
		}
	} else if (ColNm == prefix + "cgo_clz_dt_hhmi") {
		if (ComIsNull(sheetObj.GetCellValue(Row, prefix + 'cgo_clz_dt'))) {
			sheetObj.SetCellValue(Row, Col, '', 0);
		}
	} else if (ColNm == prefix + "dcgo_clz_dt") {
		if (ComIsNull(Value)) {
			sheetObj.SetCellValue(Row, prefix + "dcgo_clz_dt_hhmi", '', 0);
		}
	} else if (ColNm == prefix + "dcgo_clz_dt_hhmi") {
		if (ComIsNull(sheetObj.GetCellValue(Row, prefix + 'dcgo_clz_dt'))) {
			sheetObj.SetCellValue(Row, Col, '', 0);
		}
	} else if (ColNm == prefix + "rc_clz_dt") {
		if (ComIsNull(Value)) {
			sheetObj.SetCellValue(Row, prefix + "rc_clz_dt_hhmi", '', 0);
		}
	} else if (ColNm == prefix + "rc_clz_dt_hhmi") {
		if (ComIsNull(sheetObj.GetCellValue(Row, prefix + 'rc_clz_dt'))) {
			sheetObj.SetCellValue(Row, Col, '', 0);
		}
	} else if (ColNm == prefix + "awk_cgo_clz_dt") {
		if (ComIsNull(Value)) {
			sheetObj.SetCellValue(Row, prefix + "awk_cgo_clz_dt_hhmi", '', 0);
		}		
	} else if (ColNm == prefix + "awk_cgo_clz_dt_hhmi") {
		if (ComIsNull(sheetObj.GetCellValue(Row, prefix + 'awk_cgo_clz_dt'))) {
			sheetObj.SetCellValue(Row, Col, '', 0);
		}
	} else if (ColNm == prefix + "bb_cgo_clz_dt") {
		if (ComIsNull(Value)) {
			sheetObj.SetCellValue(Row, prefix + "bb_cgo_clz_dt_hhmi", '', 0);
		}		
	} else if (ColNm == prefix + "bb_cgo_clz_dt_hhmi") {
		if (ComIsNull(sheetObj.GetCellValue(Row, prefix + 'bb_cgo_clz_dt'))) {
			sheetObj.SetCellValue(Row, Col, '', 0);
		}		
	}
	return false;
}

function getLocGrid(rowArray, row, col) {
	var sheetObj = sheetObjects[0];
	var colArray = rowArray[0];
	if (sheetObj.ColSaveName(col) == "port_cd") {
		sheetObj.SetCellValue(row, "port_cd", colArray[3], 0);
	} else if (sheetObj.ColSaveName(col) == "hub_loc_cd") {
		sheetObj.SetCellValue(row, "hub_loc_cd", colArray[3], 0);
	} else if (sheetObj.ColSaveName(col) == "loc_cd") {
		sheetObj.SetCellValue(row, "loc_cd", colArray[3], 0);
	}
}

/**
 * 
 * @param rowArray
 * @param row
 * @param col
 */
function getYardGrid(rowArray, row, col) {
	var sheetObj = sheetObjects[0];
	var colArray = rowArray[0];
	if (sheetObj.ColSaveName(col) == "yard_code") {
		sheetObj.SetCellValue(row, "location_code", colArray[3].substring(0, colArray[3].length - 2), 0);
		sheetObj.SetCellValue(row, "yard_code", colArray[3], 0);
	}
}

/**
 * 
 * @param rowArray
 * @param row
 * @param col
 */
function getLaneGrid(rowArray, row, col) {
	var sheetObj = sheetObjects[0];
	var colArray = rowArray[0];
	if (sheetObj.ColSaveName(col) == "lane_code") {
		sheetObj.SetCellValue(row, "lane_code", colArray[3], 0);
	}
}

function sheet1_OnRowSearchEnd(sheetObj, i) {
	if (sheetObj.GetCellValue(i, "cct_type") == "ETB" || sheetObj.GetCellValue(i, "cct_type") == "ETD") {
		sheetObj.SetCellEditable(i, "cct_hour", 1);
		sheetObj.SetCellEditable(i, "cct_day", 0);
		sheetObj.SetCellEditable(i, "cct_time", 1);
	} else if (sheetObj.GetCellValue(i, "cct_type") == "CMN") {
		sheetObj.CellComboItem(i, "cct_day", { ComboText : "OneDayBeforeETB", ComboCode : "" });
		sheetObj.SetCellEditable(i, "cct_hour", 0);
		sheetObj.SetCellEditable(i, "cct_day", 0);
		sheetObj.SetCellEditable(i, "cct_time", 1);
	} else {
		sheetObj.SetCellEditable(i, "cct_hour", 0);
		sheetObj.SetCellEditable(i, "cct_day", 1);
		sheetObj.SetCellEditable(i, "cct_time", 1);
	}
	
	// CCT Management by Yard for Export Booking.
	if (sheetObj.GetCellValue(i, "cct_type") == "Day" || sheetObj.GetCellValue(i, "yd_bse_calc_flg") == 1) {
		sheetObj.SetCellEditable(i, "fri_flag", 0);
		sheetObj.SetCellEditable(i, "sat_flag", 0);
		sheetObj.SetCellEditable(i, "sun_flag", 0);
		sheetObj.SetCellEditable(i, "holi_flag", 0);
	}
	
	if (sheetObj.GetCellValue(i, "vgm_clz_tp_cd") == "ETB" || sheetObj.GetCellValue(i, "vgm_clz_tp_cd") == "ETD") {
		sheetObj.SetCellEditable(i, "vgm_clz_hr", 1);
		sheetObj.SetCellEditable(i, "vgm_clz_dy_cd", 0);
		sheetObj.SetCellEditable(i, "vgm_clz_hrmnt", 1);
	} else if (sheetObj.GetCellValue(i, "vgm_clz_tp_cd") == "CMN") {
		sheetObj.CellComboItem(i, "vgm_clz_dy_cd", { ComboText : "OneDayBeforeETB", ComboCode : "" });
		sheetObj.SetCellEditable(i, "vgm_clz_hr", 0);
		sheetObj.SetCellEditable(i, "vgm_clz_dy_cd", 0);
		sheetObj.SetCellEditable(i, "vgm_clz_hrmnt", 1);
	} else {
		sheetObj.SetCellEditable(i, "vgm_clz_hr", 0);
		sheetObj.SetCellEditable(i, "vgm_clz_dy_cd", 1);
		sheetObj.SetCellEditable(i, "vgm_clz_hrmnt", 1);
	}
	
	if (sheetObj.GetCellValue(i, "vgm_clz_tp_cd") == "Day" || sheetObj.GetCellValue(i, "vgm_yd_bse_calc_flg") == 1) {
		sheetObj.SetCellEditable(i, "vgm_xcld_hol_fri_flg", 0);
		sheetObj.SetCellEditable(i, "vgm_xcld_hol_sat_flg", 0);
		sheetObj.SetCellEditable(i, "vgm_xcld_hol_sun_flg", 0);
		sheetObj.SetCellEditable(i, "vgm_xcld_hol_hol_flg", 0);
	}
	
	if (sheetObj.GetCellValue(i, "org_delete_flag") == 1) {
		sheetObj.SetCellEditable(i, "delete_flag", 1);
		sheetObj.SetCellValue(i, "del_flag", 1, 0);
	}
	//:2016-10-07://fnSetVGMInfoDisabled(sheetObj, i);
}

function sheet1_OnChange(sheetObj, Row, Col, Value) {
	validateData = Value;
	var ColNm = sheetObj.ColSaveName(Col);
	
	//:2016-10-07://fnSetVGMInfoDisabled(sheetObj, Row);
	
	if (ColNm == "cct_type") {
		if (sheetObj.GetCellValue(Row, "cct_type") == "Day") {
			sheetObj.CellComboItem(Row, "cct_day", { ComboText : "", ComboCode : "" });
			sheetObj.SetCellValue(Row, "cct_hour", '', 0);
			sheetObj.SetCellEditable(Row, "cct_hour", 0);
			sheetObj.SetCellEditable(Row, "cct_day", 1);
			sheetObj.SetCellEditable(Row, "cct_time", 1);
			sheetObj.SetCellEditable(Row, "fri_flag", 0);
			sheetObj.SetCellEditable(Row, "sat_flag", 0);
			sheetObj.SetCellEditable(Row, "sun_flag", 0);
			sheetObj.SetCellEditable(Row, "holi_flag", 0);
		}
		
		if (sheetObj.GetCellValue(Row, "cct_type") == "CMN") {
			sheetObj.CellComboItem(Row, "cct_day", { ComboText : "OneDayBeforeETB", ComboCode : "" });
			sheetObj.SetCellValue(Row, "cct_day", 'OneDayBeforeETB', 0);
			sheetObj.SetCellValue(Row, "cct_hour", '', 0);
			sheetObj.SetCellEditable(Row, "cct_hour", 0);
			sheetObj.SetCellEditable(Row, "cct_day", 0);
			sheetObj.SetCellEditable(Row, "cct_time", 1);
			sheetObj.SetCellEditable(Row, "fri_flag", 1);
			sheetObj.SetCellEditable(Row, "sat_flag", 1);
			sheetObj.SetCellEditable(Row, "sun_flag", 1);
			sheetObj.SetCellEditable(Row, "holi_flag", 1);
		}
		
		if (sheetObj.GetCellValue(Row, "cct_type") == "ETB" || sheetObj.GetCellValue(Row, "cct_type") == "ETD") {
			sheetObj.CellComboItem(Row, "cct_day", { ComboText : "", ComboCode : "" });
			sheetObj.SetCellValue(Row, "cct_day", '', 0);
			sheetObj.SetCellValue(Row, "cct_time", '', 0);
			sheetObj.SetCellEditable(Row, "cct_hour", 1);
			sheetObj.SetCellEditable(Row, "cct_day", 0);
			sheetObj.SetCellEditable(Row, "cct_time", 1);
			sheetObj.SetCellEditable(Row, "fri_flag", 1);
			sheetObj.SetCellEditable(Row, "sat_flag", 1);
			sheetObj.SetCellEditable(Row, "sun_flag", 1);
			sheetObj.SetCellEditable(Row, "holi_flag", 1);
		}
	} else  if (ColNm == "vgm_clz_tp_cd") {
		if (sheetObj.GetCellValue(Row, "vgm_clz_tp_cd") == "Day") {
			sheetObj.CellComboItem(Row, "vgm_clz_dy_cd", { ComboText : "", ComboCode : "" });
			sheetObj.SetCellValue(Row, "vgm_clz_hr", '', 0);
			sheetObj.SetCellEditable(Row, "vgm_clz_hr", 0);
			sheetObj.SetCellEditable(Row, "vgm_clz_dy_cd", 1);
			sheetObj.SetCellEditable(Row, "vgm_clz_hrmnt", 1);
			sheetObj.SetCellEditable(Row, "vgm_xcld_hol_fri_flg", 0);
			sheetObj.SetCellEditable(Row, "vgm_xcld_hol_sat_flg", 0);
			sheetObj.SetCellEditable(Row, "vgm_xcld_hol_sun_flg", 0);
			sheetObj.SetCellEditable(Row, "vgm_xcld_hol_hol_flg", 0);
		}
		if (sheetObj.GetCellValue(Row, "vgm_clz_tp_cd") == "CMN") {
			sheetObj.CellComboItem(Row, "vgm_clz_dy_cd", { ComboText : "OneDayBeforeETB", ComboCode : "" });
			sheetObj.SetCellValue(Row, "vgm_clz_dy_cd", 'OneDayBeforeETB', 0);
			sheetObj.SetCellValue(Row, "vgm_clz_hr", '', 0);
			sheetObj.SetCellEditable(Row, "vgm_clz_hr", 0);
			sheetObj.SetCellEditable(Row, "vgm_clz_dy_cd", 0);
			sheetObj.SetCellEditable(Row, "vgm_clz_hrmnt", 1);
			sheetObj.SetCellEditable(Row, "vgm_xcld_hol_fri_flg", 1);
			sheetObj.SetCellEditable(Row, "vgm_xcld_hol_sat_flg", 1);
			sheetObj.SetCellEditable(Row, "vgm_xcld_hol_sun_flg", 1);
			sheetObj.SetCellEditable(Row, "vgm_xcld_hol_hol_flg", 1);
		}
		
		if (sheetObj.GetCellValue(Row, "vgm_clz_tp_cd") == "ETB" || sheetObj.GetCellValue(Row, "vgm_clz_tp_cd") == "ETD") {
			sheetObj.CellComboItem(Row, "vgm_clz_dy_cd", { ComboText : "", ComboCode : "" });
			sheetObj.SetCellValue(Row, "vgm_clz_dy_cd", '', 0);
			sheetObj.SetCellValue(Row, "vgm_clz_hrmnt", '', 0);
			sheetObj.SetCellEditable(Row, "vgm_clz_hr", 1);
			sheetObj.SetCellEditable(Row, "vgm_clz_dy_cd", 0);
			sheetObj.SetCellEditable(Row, "vgm_clz_hrmnt", 1);
			sheetObj.SetCellEditable(Row, "vgm_xcld_hol_fri_flg", 1);
			sheetObj.SetCellEditable(Row, "vgm_xcld_hol_sat_flg", 1);
			sheetObj.SetCellEditable(Row, "vgm_xcld_hol_sun_flg", 1);
			sheetObj.SetCellEditable(Row, "vgm_xcld_hol_hol_flg", 1);
		}
	} else  if ((ColNm == "yard_code") && (sheetObj.GetCellProperty(Row, Col, "EditLen") == 7)) {
		doActionIBSheet(sheetObj, document.form, SEARCH04);
	} else if ((ColNm == "lane_code") && (sheetObj.GetCellProperty(Row, Col, "EditLen") == 3)) {
		if (Value != 'ALL') {
			doActionIBSheet(sheetObj, document.form, SEARCH07);
		}
	} else if (ColNm == "cct_time") {
		if (!ComIsEmpty(Value) && !ComIsTime(Value, "hm")) {
			ComShowMessage(ComGetMsg("PRD90130"));
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cct_time", "", 0);
			sheetObj.SelectCell(sheetObj.GetSelectRow(), "cct_time");
		}
	} else if (ColNm == "yd_bse_calc_flg") {
		if (Value == '1') {
			sheetObj.SetCellValue(Row, "fri_flag", '', 0);
			sheetObj.SetCellValue(Row, "sat_flag", '', 0);
			sheetObj.SetCellValue(Row, "sun_flag", '', 0);
			sheetObj.SetCellValue(Row, "holi_flag", '', 0);
			sheetObj.SetCellEditable(Row, "fri_flag", 0);
			sheetObj.SetCellEditable(Row, "sat_flag", 0);
			sheetObj.SetCellEditable(Row, "sun_flag", 0);
			sheetObj.SetCellEditable(Row, "holi_flag", 0);
		} else {
			sheetObj.SetCellEditable(Row, "fri_flag", 1);
			sheetObj.SetCellEditable(Row, "sat_flag", 1);
			sheetObj.SetCellEditable(Row, "sun_flag", 1);
			sheetObj.SetCellEditable(Row, "holi_flag", 1);
		}
	} else if (ColNm == "vgm_clz_hrmnt") {
		if (!ComIsEmpty(Value) && !ComIsTime(Value, "hm")) {
			ComShowMessage(ComGetMsg("PRD90130"));
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "vgm_clz_hrmnt", "", 0);
			sheetObj.SelectCell(sheetObj.GetSelectRow(), "vgm_clz_hrmnt");
		}
	} else if (ColNm == "vgm_yd_bse_calc_flg") {
		if (Value == '1') {
			sheetObj.SetCellValue(Row, "vgm_xcld_hol_fri_flg", '', 0);
			sheetObj.SetCellValue(Row, "vgm_xcld_hol_sat_flg", '', 0);
			sheetObj.SetCellValue(Row, "vgm_xcld_hol_sun_flg", '', 0);
			sheetObj.SetCellValue(Row, "vgm_xcld_hol_hol_flg", '', 0);
			sheetObj.SetCellEditable(Row, "vgm_xcld_hol_fri_flg", 0);
			sheetObj.SetCellEditable(Row, "vgm_xcld_hol_sat_flg", 0);
			sheetObj.SetCellEditable(Row, "vgm_xcld_hol_sun_flg", 0);
			sheetObj.SetCellEditable(Row, "vgm_xcld_hol_hol_flg", 0);
		} else {
			sheetObj.SetCellEditable(Row, "vgm_xcld_hol_fri_flg", 1);
			sheetObj.SetCellEditable(Row, "vgm_xcld_hol_sat_flg", 1);
			sheetObj.SetCellEditable(Row, "vgm_xcld_hol_sun_flg", 1);
			sheetObj.SetCellEditable(Row, "vgm_xcld_hol_hol_flg", 1);
		}
	}
}

function fnSetVGMInfoDisabled(sheetObj, Row){
	var cargo_type = sheetObj.GetCellValue(Row,"cargo_type");
	var vgm_yd_bse_calc_flg = sheetObj.GetCellValue(Row,"vgm_yd_bse_calc_flg");
	 
	if(cargo_type != 'AL'){
		sheetObj.SetCellEditable(Row, "vgm_clz_tp_cd"		, 0);
		sheetObj.SetCellEditable(Row, "vgm_clz_hr"			, 0);
		sheetObj.SetCellEditable(Row, "vgm_clz_file_flg"	, 0);
		sheetObj.SetCellEditable(Row, "vgm_yd_bse_calc_flg"	, 0);
		sheetObj.SetCellEditable(Row, "vgm_clz_hrmnt"		, 0);
		sheetObj.SetCellEditable(Row, "vgm_xcld_hol_fri_flg", 0);
		sheetObj.SetCellEditable(Row, "vgm_xcld_hol_sat_flg", 0);
		sheetObj.SetCellEditable(Row, "vgm_xcld_hol_sun_flg", 0);
		sheetObj.SetCellEditable(Row, "vgm_xcld_hol_hol_flg", 0);
	} else {
			sheetObj.SetCellEditable(Row, "vgm_clz_tp_cd"		, 1);
			sheetObj.SetCellEditable(Row, "vgm_clz_hr"			, 1);
			sheetObj.SetCellEditable(Row, "vgm_clz_file_flg"	, 1);
			sheetObj.SetCellEditable(Row, "vgm_yd_bse_calc_flg"	, 1);
			sheetObj.SetCellEditable(Row, "vgm_clz_hrmnt"		, 1);
			if(vgm_yd_bse_calc_flg == '0' ) {
				sheetObj.SetCellEditable(Row, "vgm_xcld_hol_fri_flg", 1);
				sheetObj.SetCellEditable(Row, "vgm_xcld_hol_sat_flg", 1);
				sheetObj.SetCellEditable(Row, "vgm_xcld_hol_sun_flg", 1);
				sheetObj.SetCellEditable(Row, "vgm_xcld_hol_hol_flg", 1);
			} else {
				sheetObj.SetCellEditable(Row, "vgm_xcld_hol_fri_flg", 0);
				sheetObj.SetCellEditable(Row, "vgm_xcld_hol_sat_flg", 0);
				sheetObj.SetCellEditable(Row, "vgm_xcld_hol_sun_flg", 0);
				sheetObj.SetCellEditable(Row, "vgm_xcld_hol_hol_flg", 0);
			}
	}
}

/**
 * unchecking when Act column where del_flag is 1 is clicked
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnClick(sheetObj, Row, Col) {
	var selColNm = sheetObj.ColSaveName(Col);
	if (Col == 3) {
		if (sheetObj.GetCellValue(Row, "org_delete_flag") == 1) {
			if ((sheetObj.GetCellValue(Row, "del_flag") == 1) && (sheetObj.GetCellValue(Row, "delete_flag") == 0)) {
				sheetObj.SetCellValue(Row, "delete_flag", 1, 0);
				sheetObj.SetCellValue(Row, "del_flag", 0, 0);
			} else if ((sheetObj.GetCellValue(Row, "del_flag") == 1) && (sheetObj.GetCellValue(Row, "delete_flag") == 1)) {
				sheetObj.SetCellValue(Row, "delete_flag", 0, 0);
			}
		}
	} else if (Col == 2) {
		if (sheetObj.GetCellValue(Row, "org_delete_flag") == 1) {
			if (sheetObj.GetCellValue(Row, "del_flag") == 0 && sheetObj.Cellvalue(Row, "delete_flag") == 1) {
				sheetObj.SetCellValue(Row, "delete_flag", 0, 0);
			}
		}
	} else if(selColNm == 'cct_his_pop' || selColNm == 'vgm_his_pop')  {
		var param = "?yd_cd=" + sheetObj.GetCellValue(Row, "yard_code");
			param += "&vsl_slan_cd=" + sheetObj.GetCellValue(Row, "lane_code");
			param += "&vsl_slan_dir_cd=" + sheetObj.GetCellValue(Row, "lane_dir_code");
			param += "&cgo_tp_cd="  + sheetObj.GetCellValue(Row, "cargo_type");
			param += "&pctl_use_flg=Y";
			if(selColNm == 'vgm_his_pop') {
				param += "&vgm_flg=Y";
			} else {
				param += "&vgm_flg=N";
			}
		ComOpenPopup('/opuscntr/ESD_PRD_0039_POP.do' + param, 800, 550, 'ESD_PRD_0039_POP', "1,0,1,1,1,1,1,1,1,1,1,1", true);
	}
}


/**
 * unchecking when Act column where del_flag is 1 is clicked
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet2_OnClick(sheetObj, Row, Col) {
	var selColNm = sheetObj.ColSaveName(Col);
	if(selColNm == prefix + 'cct_his_pop' || selColNm == prefix + 'vgm_his_pop')  {
		var param = "?vvd_cd=" + sheetObj.GetCellValue(Row, prefix + "vvd");
			param += "&vsl_slan_cd=" + sheetObj.GetCellValue(Row, prefix + "vsl_slan_cd");
			param += "&yd_cd=" + sheetObj.GetCellValue(Row, prefix + "vps_port_cd");
			param += "&vps_port_cd=" + sheetObj.GetCellValue(Row, prefix + "vps_port_cd");
			param += "&clpt_ind_seq=" + sheetObj.GetCellValue(Row, prefix + "clpt_ind_seq");
			param += "&pctl_use_flg=N";
			if(selColNm == prefix + 'vgm_his_pop') {
				param += "&vgm_flg=Y";
			} else {
				param += "&vgm_flg=N";
			}
		ComOpenPopup('/opuscntr/ESD_PRD_0039_POP.do' + param, 800, 550, 'ESD_PRD_0039_POP', "1,0,1,1,1,1,1,1,1,1,1,1", true);
	}
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction, Gubun) {
	switch (sAction) {
		case IBSEARCH: {
			if (formObj.chk_t[0].checked) {

			} else {
				if (ComIsNull(formObj.fm_dt.value)) {
					ComShowCodeMessage('PRD00083', "Period(From)");
					formObj.fm_dt.focus();
					return false;
				}
				if (ComIsNull(formObj.to_dt.value)) {
					ComShowCodeMessage('PRD00083', "Period(To)");
					formObj.to_dt.focus();
					return false;
				}
				if (!PrdCheckPeriod(formObj.fm_dt, formObj.to_dt, "Y")) {
					ComShowCodeMessage("PRD00083", "1 year");
					return false;
				}
				if (!checkPeriod(formObj.fm_dt, formObj.to_dt)) {
					ComShowCodeMessage("PRD00084", "End date", "start date");
					return false;
				}
			}
			break;
		}
	}

	return true;
}

/**
 * 
 * @param fmDtObj
 * @param toDtObj
 * @param periodType
 * @returns {Boolean}
 */
function PrdCheckPeriod(fmDtObj, toDtObj, periodType) {
	var fmDt = ComReplaceStr(fmDtObj.value, "-", "");
	var toDt = ComReplaceStr(toDtObj.value, "-", "");
	var tmpDt = ComGetDateAdd(fmDt, periodType, 1);
	if (ComChkPeriod(toDt, tmpDt) == 1) {
		return true;
	} else {
		return false;
	}
}

/**
 * 
 * @param fromDate
 * @param toDate
 * @returns {Boolean}
 */
function checkPeriod(fromDate, toDate) {
	var fmDt = ComReplaceStr(fromDate.value, "-", "");
	var toDt = ComReplaceStr(toDate.value, "-", "");
	if (ComChkPeriod(fmDt, toDt) < 1) {
		return false;
	} else {
		return true;
	}
}

/**
 * checking mandatory value of CCT TYPE of Cargo Closing Time <br>
 * CCT TYPE : ETB, EDT -> CCT HOUR is mandatory when CCT TYPE : Day, CMN -> CCT DAY, CCT TIME are mandatory
 * 
 * @param sheetObj
 * @return
 */
function keyFieldCheck(sheetObj) {
	for ( var i = sheetObj.HeaderRows(); i < (sheetObj.HeaderRows() + sheetObj.RowCount()); i++) {
		if (sheetObj.GetRowStatus(i) == 'I' || sheetObj.GetRowStatus(i) == 'U') {
			if ((sheetObj.GetCellValue(i, "cct_type") == "ETB" || sheetObj.GetCellValue(i, "cct_type") == "ETD") && sheetObj.GetCellValue(i, "cct_hour") == "") {
				ComShowMessage(ComGetMsg("PRD90112", (i - 1), 'CCT HOUR'));
				sheetObj.SelectCell(i, "cct_hour");
				return false;
			} else if (sheetObj.GetCellValue(i, "cct_type") == "Day" && (sheetObj.GetCellValue(i, "cct_day") == "" || sheetObj.GetCellValue(i, "cct_time") == "")) {
				if (sheetObj.GetCellValue(i, "cct_day") == "") {
					ComShowMessage(ComGetMsg("PRD90112", (i - 1), 'CCT DAY'));
					sheetObj.SelectCell(i, "cct_day");
				} else {
					ComShowMessage(ComGetMsg("PRD90112", (i - 1), 'CCT TIME'));
					sheetObj.SelectCell(i, "cct_time");
				}
				return false;
			} else if (sheetObj.GetCellValue(i, "cct_type") == "CMN" && sheetObj.GetCellValue(i, "cct_time") == "") {
				ComShowMessage(ComGetMsg("PRD90112", (i - 1), 'CCT TIME'));
				sheetObj.SelectCell(i, "cct_time");
				return false;
			}
			if (sheetObj.GetCellValue(i, "org_delete_flag") == 1 && sheetObj.GetCellValue(i, "del_flag") == 1) {
				sheetObj.SetRowStatus(i, 'R');
			}
		}
	}
	return true;
}

/**
 * if cancel button is clicked at save confirm pop up, check box will be checked where del_flag is 1
 * 
 * @param sheetObj
 * @return
 */
function delCheck(sheetObj) {
	for ( var i = sheetObj.HeaderRows(); i < (sheetObj.HeaderRows() + sheetObj.RowCount()); i++) {
		if ((sheetObj.GetCellValue(i, "org_delete_flag") == 1) && sheetObj.GetCellValue(i, "delete_flag") == 0) {
			sheetObj.SetRowStatus(i, 'R');
			sheetObj.SetCellValue(i, "del_flag", 1, 0);
			sheetObj.SetCellValue(i, "delete_flag", 0, 0);
		}
	}
}

function fncRadioCheck(obj) {
	if (obj.value == 'T') {
		sheetObjects[0].RemoveAll();
		sheetObjects[0].SetVisible(true);
		sheetObjects[1].SetVisible(false);
		$('#div_grid1').show();
		$('#div_grid2').hide();
		$('#btn_loadexcel').show();
		funcCntrInputField(obj.value);
		resizeSheet(sheetObjects[0]);
	} else {
		sheetObjects[1].RemoveAll();
		sheetObjects[0].SetVisible(false);
		sheetObjects[1].SetVisible(true);
		$('#div_grid1').hide();
		$('#div_grid2').show();
		$('#btn_loadexcel').hide();
		funcCntrInputField(obj.value);
		resizeSheet(sheetObjects[1]);
	}
}

function funcCntrInputField(Val) {
	if (Val == 'T') {
		$('#search_1').find("input:text,select").each(function(idx, item) {
			if (this.id == 'status_code') {
				$(this).prop('disabled', false);
			} else {
				$(this).val("").attr('readonly', false);
			}
		});
		$('#search_2').find("input:text").each(function(idx, item) {
			$(this).val('').attr('readonly', true);
		});

	} else if (Val == 'V') {
		$('#search_1').find("input:text,select").each(function(idx, item) {
			if (this.id == 'status_code') {
				$(this).prop('disabled', true);
			} else {
				$(this).val("").attr('readonly', true);
			}
		});
		$('#search_2').find("input:text").each(function(idx, item) {
			if (this.id == 'fm_dt') {
				$(this).val(today).attr('readonly', false);
			} else if (this.id == 'to_dt') {
				$(this).val(afterOneMonth).attr('readonly', false);
			} else {
				$(this).val('').attr('readonly', false);
			}
		});
	}
}
