/*
=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_PRD_0014.js
 *@FileTitle  : Ocean Route management 
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/
=========================================================
 */
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @fileoverview 
 * @author OPUS
 */
/**
 * @extends
 * @class ESD_PRD_0014 : business script for ESD_PRD_0014
 */

var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var sheetObjects = new Array();
var comboObjects = new Array();
var sheetCnt = 0;
var comboCnt = 0;
var retValidate = 0;
var popWin = '';
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName)) {
			return false;
		}
		var srcObj = ComGetEvent().nodeName;
		var keyObj = window.event.keyCode;
		switch (srcName) {
			case "btn_retrieve":
				if (!checkInput()) {
					return false;
				}
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;
			case "btn_new":
				sheetObject.RemoveAll();
				formObject.reset();
				break;
			case "btn_save":
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
			case "btn_downexcel":
				if (sheetObject.RowCount() < 1) {
					ComShowCodeMessage("COM132501");
				} else {
					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
				}
				break;
			case "btn_multi":
				doOpenPopup(sheetObject, formObject, 'multi');
				break;
			case "btn_auto":
				doOpenPopup(sheetObject, formObject, 'auto');
				break;
			case "btn_manu":
				doOpenPopup(sheetObject, formObject, 'manual');
				break;
			case "btng_pcgeneral":
				document.location.href = "ESD_PRD_0020.do?pid=ESD_PRD_M007&MENU=Y&pgmNo=ESD_PRD_0020&parentPgmNo=ESD_PRD_M001&main_page=true&mainMenuLinkFlag=true&menuflag=true&mainPage=true";
				break;
			case "btn_pol_port_cd":
				selectPort(formObject, 'POL');
				break;
			case "btn_pod_port_cd":
				selectPort(formObject, 'POD');
				break;
			case "btn_tnk_lane_cd":
				selectLane();
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111'));
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
 */
function loadPage() {
	for ( var i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for ( var c = 0; c < comboObjects.length; c++) {
		initCombo(comboObjects[c], c + 1);
	}
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
	axon_event.addListener('keypress', 'PrdComKeyEnter', 'pol_port_cd', 'pod_port_cd', 'ts_port_cd', 'tnk_lane_cd');
	axon_event.addListenerForm('change', 'form_onChange', form);
}

function initCombo(comboObj, comboNo) {
	var i = 0;
	switch (comboObj.options.id) {
		case "s_route_flg":
			with (comboObj) {
				InsertItem(i++, "ALL", "");
				var comboVal = 'Guide^G|Standard^S|Temporary^T|AddCall^A|Validation^V|Doubt^O|NotUsed^N|Deleted^D';
				var s = comboVal.split('|');
				for ( var j = 0; j < s.length; j++) {
					var g = s[j].split('^');
					InsertItem(i++, g[0], g[1]);
				}
				comboObj.SetSelectIndex(0);
			}
			break;
	}
}

function form_onChange(evt, el) {
	var formObj = document.form;
	var xml = "";
	var srcName;
	var srcValue;
	if (el) {
		srcName = el.getAttribute("name");
		srcValue = el.getAttribute("value");
	} else {
		srcName = ComGetEvent("name");
		srcValue = ComGetEvent("value");
	}
	var keyObj = ComGetEvent("keycode");
	if (keyObj == undefined)
		keyObj = 0;

	var pol_port_cd = formObj.pol_port_cd.value;
	var pod_port_cd = formObj.pod_port_cd.value;
	var tnk_lane_cd = formObj.tnk_lane_cd.value;
	funcRequired(srcName, srcValue);
	if (srcName == "pol_port_cd" && pol_port_cd.length == 5) {
		bInputChk = inputChkUpper(ComGetEvent(), keyObj, 'SEARCH01');
	} else if (srcName == "pod_port_cd" && pod_port_cd.length == 5) {
		bInputChk = inputChkUpper(ComGetEvent(), keyObj, 'SEARCH01');
	} else if (srcName == "tnk_lane_cd") {
		bInputChk = inputChkUpper(ComGetEvent(), keyObj, 'SEARCH07');
	}
}

/**
 * 
 * @param srcName
 * @param srcValue
 */
function funcRequired(srcName, srcValue) {

	if (srcName == 'pol_port_cd' || srcName == 'pod_port_cd' || srcName == 'tnk_lane_cd') {
		$('.input1').each(function() {
			$(this).removeClass('input1').addClass("input");
		});
		if (!ComIsEmpty(srcValue)) {
			$('#form #' + srcName).removeClass('input').addClass("input1");
		}
		var b = false;
		if (!($('#form #pol_port_cd').hasClass("input1")) && !($('#form #pod_port_cd').hasClass("input1")) && !($('#form #tnk_lane_cd').hasClass("input1"))) {
			$.each(['pol_port_cd', 'pod_port_cd', 'tnk_lane_cd'], function(index, value) {
				if (!ComIsEmpty($('#form #' + value).val())) {
					$('#form #' + value).removeClass('input').addClass("input1");
					b = true;
					return false;
				}
			});
			if (!b) {
				$('#form #pol_port_cd').removeClass('input').addClass("input1");
			}
		}
	}
}

/**
 * handling tab event
 * 
 * @return
 */
function prdComKeyDown() {
	var keyObj = window.event.keyCode;
	if (keyObj == 9) {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName))
			return false;
		var formObject = document.form;
		var pol_port_cd = formObject.pol_port_cd.value;
		var pod_port_cd = formObject.pod_port_cd.value;
		var bInputChk = false;
		if (srcName == "pol_port_cd" && pol_port_cd.length == 5) {
			bInputChk = inputChkUpper(ComGetEvent(), keyObj, 'SEARCH01');
		} else if (srcName == "pod_port_cd" && pod_port_cd.length == 5) {
			bInputChk = inputChkUpper(ComGetEvent(), keyObj, 'SEARCH01');
		} else if (srcName == "tnk_lane_cd") {
			bInputChk = inputChkUpper(ComGetEvent(), keyObj, 'SEARCH07');
		}
	}
}
/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
		case 1: // IBSheet1 init
			with (sheetObj) {
				var HeadTitle  = "SEQ|Del.|STS|POL|Lane|Dir|SVC\nType|1st T/S|1st T/S|1st T/S|1st T/S|2nd T/S|2nd T/S|2nd T/S|2nd T/S|3rd T/S|3rd T/S|3rd T/S|3rd T/S|POD|T/Time\n(Day/Hr)|S/Time\n(Day)|Priority|Ocean\nFlag|Remark|Remark|F/Used|C.Date|C.User|U.Date|U.User||||||||||||||||||||||||||||||||||||";
				var HeadTitle1 = "SEQ|Del.|STS|POL|Lane|Dir|SVC\nType|Port|Lane|Dir|SVC\nType|Port|Lane|Dir|SVC\nType|Port|Lane|Dir|SVC\nType|POD|T/Time\n(Day/Hr)|S/Time\n(Day)|Priority|Ocean\nFlag|Type|Note|F/Used|C.Date|C.User|U.Date|U.User||||||||||||||||||||||||||||||||||||";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
				var headers = [{ Text : HeadTitle, Align : "Center" }, { Text : HeadTitle1, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "Seq",  Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "s_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "DelCheck", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "s_del", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Status", Hidden : 1, Width : 30, Align : "Center", ColMerge : 1, SaveName : "ibflag", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_pol", 		KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 60, Align : "Center", ColMerge : 1, SaveName : "s_lane", 		KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 60, Align : "Center", ColMerge : 1, SaveName : "s_dir", 		KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_svc_type", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_ts1_port", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "s_ts1_lane", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "s_ts1_dir", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_ts1_type", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_ts2_port", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "s_ts2_lane", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 60, Align : "Center", ColMerge : 1, SaveName : "s_ts2_dir", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "s_ts2_type", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_ts3_port", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "s_ts3_lane", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 60, Align : "Center", ColMerge : 1, SaveName : "s_ts3_dir", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_ts3_type", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_pod", 		KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Center", ColMerge : 1, SaveName : "s_fmt_t_time", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 75, Align : "Center", ColMerge : 1, SaveName : "s_fmt_s_time", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Combo",Hidden : 0, Width : 60, Align : "Center", ColMerge : 1, SaveName : "s_prior", 		KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Combo",Hidden : 0, Width : 60, Align : "Center", ColMerge : 1, SaveName : "s_route_flg", 	KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Combo",Hidden : 0, Width : 60, Align : "Left",   ColMerge : 1, SaveName : "s_route_rmk", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 100,Align : "Left",   ColMerge : 1, SaveName : "s_route_note", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 60, Align : "Center", ColMerge : 1, SaveName : "s_f_u", 		KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Date", Hidden : 0, Width : 70, Align : "Center", ColMerge : 1, SaveName : "s_c_date", 	KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Center", ColMerge : 1, SaveName : "s_c_user", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Date", Hidden : 0, Width : 70, Align : "Center", ColMerge : 1, SaveName : "s_u_date", 	KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Center", ColMerge : 1, SaveName : "s_u_user", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_rout_seq", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 70, Align : "Center", ColMerge : 1, SaveName : "s_t_time", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 75, Align : "Center", ColMerge : 1, SaveName : "s_s_time", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_pol1", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_pod1", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 60, Align : "Center", ColMerge : 1, SaveName : "s_dir1", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_fdr_flg1", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_pol2", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_pod2", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 60, Align : "Center", ColMerge : 1, SaveName : "s_dir2", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_fdr_flg2", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_pol3", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_pod3", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 60, Align : "Center", ColMerge : 1, SaveName : "s_dir3", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_fdr_flg3", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_pol4", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_pod4", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_dir4", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_fdr_flg4", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_n1st_tztm_hrs", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_n2nd_tztm_hrs", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_n3rd_tztm_hrs", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_n4th_tztm_hrs", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_n1st_stay_tm_hrs", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_n2nd_stay_tm_hrs", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_n3rd_stay_tm_hrs", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_ts_ind_cd", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_pod1_etb", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_pol2_etb", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_pod2_etb", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_pol3_etb", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_pod3_etb", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_pol4_etb", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_lnk_cnt", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_upd_ind_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 50, Align : "Center", ColMerge : 0, SaveName : "s_dup_allow", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }
				];
				InitColumns(cols);
				SetEditable(1);
				SetWaitImageVisible(0);
				InitComboNoMatchText(true);
				SetColProperty(0, "s_fmt_t_time", { AcceptKeys : "N", Format : "##D-##H" });
				SetColProperty(0, "s_fmt_s_time", { AcceptKeys : "N", Format : "##D-##H" });
				SetHeaderRowHeight(20);
				SetColProperty(0, "s_prior", { ComboText : "|1|2|3|4|5|6|7|8|9", ComboCode : "|1|2|3|4|5|6|7|8|9" });
				SetColProperty(0, "s_f_u", { ComboText : "|Y|N", ComboCode : "|Y|N" });
				SetColProperty(0, "s_route_flg", { ComboText : "|Guide|Standard|Temporary|AddCall|Validation|Doubt|NotUsed|Deleted", ComboCode : "|G|S|T|A|V|O|N|D" });
				SetColProperty(0, "s_route_rmk", { ComboText : "|SpaceShortage|CustomerRequest|PortSkip|VSLPhaseOut|CustomsProblem|ClericalError|The Others", ComboCode : "|SpaceShortage|CustomerRequest|PortSkip|VSLPhaseOut|CustomsProblem|ClericalError|The Others" });
				ComResizeSheet(sheetObj);
			}
			break;
	}
}

/**
 * checking before save - show message when the combo is not selected in the row that route flag is temp
 */
function ocnFlagChk(sheetObj) {
	for ( var i = parseInt(sheetObj.HeaderRows()); i < sheetObj.RowCount() + parseInt(sheetObj.HeaderRows()); i++) {
		var idx = sheetObj.GetComboInfo(i, "s_route_rmk", "SelectedIndex");
		var rowStatus = sheetObj.GetRowStatus(i);
		if ((rowStatus == 'U' || rowStatus == 'I') && (sheetObj.GetCellValue(i, "s_route_flg") == "T") && idx == 0) {
			sheetObj.SelectCell(i, "s_route_rmk");
			sheetObj.SetCellValue(i, "s_route_rmk", '', 0);
			return false;
		}
	}
	return true;
}
/**
 * checking before save - show message when the value of Note is null selected in the row that Type is "The Other"
 * 
 * @return
 */
function otherFlagChk(sheetObj) {
	for ( var i = parseInt(sheetObj.HeaderRows()); i < sheetObj.RowCount() + parseInt(sheetObj.HeaderRows()); i++) {
		var rowStatus = sheetObj.GetRowStatus(i);
		if ((rowStatus == 'U' || rowStatus == 'I') && (sheetObj.GetCellValue(i, "s_route_rmk") == "The Others") && (ComTrim(sheetObj.GetCellValue(i, "s_route_note")) == "")) {
			return false;
		}
	}
	return true;
}
/**
 * handling of Sheet process
 * 
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	var uid;
	var sXml;
	switch (sAction) {
		case IBSEARCH: // retrieve
			formObj.f_cmd.value = SEARCH;
			ComOpenWait(true);
			setTimeout(function() {
				sheetObj.DoSearch("ESD_PRD_0014GS.do", PrdFQString(formObj), { Sync : 2 });
			}, 100);
			ComOpenWait(false);
			break;
		case IBSAVE:
			if (!ocnFlagChk(sheetObj)) {
				ComShowMessage(ComGetMsg('PRD90102'));
				return;
			}
			if (!otherFlagChk(sheetObj)) {
				ComShowMessage(ComGetMsg('PRD90124'));
				return;
			}
			formObj.f_cmd.value = MULTI;
			ComOpenWait(true);
			sheetObj.DoSave("ESD_PRD_0014GS.do", PrdFQString(formObj));
			ComOpenWait(false);
			break;
		case IBDOWNEXCEL:
			ComOpenWait(true);
			sheetObj.Down2Excel({ DownCols : makeHiddenSkipCol(sheetObj), SheetDesign : 1, Merge : 1 });
			ComOpenWait(false);
			break;
		case SEARCH01:
			formObj.f_cmd.value = SEARCH01;
			uid = "ESD_PRD_0004";
			sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetEtcData(sXml, "rowCount");
			break;
		case SEARCH07:
			formObj.f_cmd.value = SEARCH07;
			uid = "ESD_PRD_0033";
			sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetEtcData(sXml, "rowCount");
			break;
	}
}
/**
 * checking mandatory condition
 * 
 * @return
 */
function mandatoryChk(formObj) {
	if (formObj.pol_port_cd.value.length != 5 && formObj.pod_port_cd.value.length != 5) {
		ComShowMessage(ComGetMsg('PRD90100'));
		return false;
	}
	return true;
}
/**
 * handling popup open
 * 
 * @return
 */
function sheet1_OnPopupClick(sheetObj, row, col) {
	if (sheetObj.ColSaveName(col) == "a1") {
		ComShowMessage("Lane Code Search Popup Open!! row=" + row);
	}
	if (sheetObj.ColSaveName(col) == "a2") {
		ComShowMessage("Carrier Search Popup Open!! row=" + row);
	}
	if (sheetObj.ColSaveName(col) == "a3") {
		ComShowMessage("TMNL Code Search Popup Open!! row=" + row);
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
	}
	return true;
}
/** *************************************************************************** */
/**
 * 
 * @return
 */
function changeSelect(gubun) {
	var frm = document.form;
	var val = ''
	if (gubun == 'T') {
		val = frm.select1[frm.select1.selectedIndex].value;
		frm.ts_type.value = (val == 0) ? "" : val;
	}
	if (gubun == 'S') {
		val = frm.select2[frm.select2.selectedIndex].value;
		frm.stay_time.value = (val == 0) ? "0" : val;
	}
}
/**
 * 
 * @return
 */
function selectLane() {
	var frm = document.form;
	var slan_cd_val = frm.tnk_lane_cd.value;
	var param = '?&lane_cd=' + slan_cd_val;
	ComOpenPopup('/opuscntr/COM_ENS_081.do' + param, 800, 400, 'getLane', "1,0,1,1,1,1,1,1,1,1,1,1", true);
}
/**
 * 
 * @return
 */
function getLane(rowArray) {
	var colArray = rowArray[0];
	document.form.tnk_lane_cd.value = colArray[3];
	funcRequired('tnk_lane_cd', colArray[3]);
}
var portInd = '';
/**
 * handling popup open
 */
function selectPort(frm, pt) {
	portInd = pt;
	var param = '';
	if (pt == 'POL')
		param = '?loc_cd=' + frm.pol_port_cd.value;
	if (pt == 'POD')
		param = '?loc_cd=' + frm.pod_port_cd.value;
	ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 480, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1', true);
}
/**
 * handling after popup open
 */
function getCOM_ENS_051(rArray) {
	var cArray = rArray[0];
	var frm = document.form;
	if (portInd == 'POL') {
		frm.pol_port_cd.value = cArray[3];
		funcRequired('pol_port_cd', cArray[3]);
	}
	if (portInd == 'POD') {
		frm.pod_port_cd.value = cArray[3];
	}
}
/**
 * handling popup open
 */
function doOpenPopup(sheetObject, formObject, gubun) {
	var w = 1024;
	var h = 650;
	if (gubun == 'auto') {
		w = 1000;
		h = 400;
	} else if (gubun == 'manual') {
		w = 1024;
		h = 400;
	} else if (gubun == 'multi') {
		w = 1050;
		h = 500;
	}
	var screenW = screen.width;
	var screenH = screen.height;
	var posX = (screenW - w) / 2;
	var posY = (screenH - h) / 2;
	var url = "";
	var param = "";
	formObject.f_cmd.value = '2';
	if (gubun == 'auto') {
		if (formObject.pol_port_cd.value == '' || formObject.pol_port_cd.value.length != 5) {
			ComShowMessage(ComGetMsg('PRD90122'));
			return;
		}
		if (formObject.pod_port_cd.value == '' || formObject.pod_port_cd.value.length != 5) {
			ComShowMessage(ComGetMsg('PRD90122'));
			return;
		}
		url = 'ESD_PRD_0032.do';
		param = 'pol_port_cd=' + formObject.pol_port_cd.value + '&pod_port_cd=' + formObject.pod_port_cd.value + '&tnk_lane_cd=' + formObject.tnk_lane_cd.value;
	} else if (gubun == 'manual') {
		if (formObject.pol_port_cd.value == '' || formObject.pol_port_cd.value.length != 5) {
			ComShowMessage(ComGetMsg('PRD90122'));
			return;
		}
		if (formObject.pod_port_cd.value == '' || formObject.pod_port_cd.value.length != 5) {
			ComShowMessage(ComGetMsg('PRD90122'));
			return;
		}
		url = 'ESD_PRD_0035.do';
	} else if (gubun == 'multi') {
		url = 'ESD_PRD_0060.do';
	}
	if (param.length > 0) {
		url = url + "?" + param;
	}
	popWin = window.open(url, "OCEANROUTE", "status=1,width=" + w + ",height=" + h + ",resizable=0,scrollbars=1,left=" + posX + ",top=" + posY);
}
/**
 * method calling from ESD_PRD_0032, ESD_PRD_0035(popup)
 * 
 * @return
 */
function ocnRoutSave() {
	var formObj = document.form;
	formObj.f_cmd.value = MULTI;
	sheetObjects[0].DoSave("ESD_PRD_0014GS.do", PrdFQString(formObj));
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	popWin.close();
}
/**
 * Sheet1 Change event
 * 
 * @return
 */
function sheet1_OnChange(sheetObj, Row, Col, Val) {
	if (sheetObj.GetCellValue(Row, "s_route_flg") == "T" && sheetObj.GetCellValue(Row, "s_route_rmk") == "The Others") {
		sheetObj.SetCellEditable(Row, "s_route_note", 1);
	} else {
		sheetObj.SetCellEditable(Row, "s_route_note", 0);
	}

	var colName = sheetObj.ColSaveName(Col);
	if (colName == 's_route_flg') {
		if (Val == 'T') {
			ComShowMessage(ComGetMsg('PRD90102'));
			sheetObj.SelectCell(Row, "s_route_rmk");
			sheetObj.SetCellValue(Row, "s_route_rmk", '', 0);
			sheetObj.SetCellValue(Row, "s_route_note", '', 0);
		} else {
			sheetObj.SetCellValue(Row, "s_route_rmk", ' ', 0);
			sheetObj.SetCellValue(Row, "s_route_note", ' ', 0);
		}
	}

	// preventing to select on DROP BOX in case of 'S'
	var idx = sheetObj.GetComboInfo(Row, "s_route_rmk", "SelectedIndex");
	var rowStatus = sheetObj.GetRowStatus(Row);
	if ((rowStatus == 'U' || rowStatus == 'I') && (colName == "s_route_rmk") && (sheetObj.GetCellValue(Row, "s_route_flg") != "T") && idx > 0) {
		sheetObj.SetCellValue(Row, "s_route_rmk", ' ', 0);
		sheetObj.SetCellValue(Row, "s_route_note", ' ', 0);
		ComShowMessage(ComGetMsg('PRD90103'));
		sheetObj.SelectCell(Row, "s_route_rmk");
	}
	if ((rowStatus == 'U' || rowStatus == 'I') && (colName == "s_route_rmk") && (sheetObj.GetCellValue(Row, "s_route_flg") == "T") && sheetObj.GetCellValue(Row, "s_route_rmk").trim() == "") {
		sheetObj.SetCellValue(Row, "s_route_rmk", '', 0);
		sheetObj.SetCellValue(Row, "s_route_note", '', 0);

		ComShowMessage(ComGetMsg('PRD90102'));
		sheetObj.SelectCell(Row, "s_route_rmk");
	}
	if (colName == "s_route_flg") {
		if (Val == "V") {
			ComShowMessage(ComGetMsg('PRD90104', 'Validation'));
			sheetObj.SetCellValue(Row, "s_route_flg", sheetObj.GetCellValue(Row, "s_upd_ind_cd"), 0);
			return;
		}
		if (Val == "G") {
			if (OCN_FLG != 'S') {
				ComShowMessage(ComGetMsg('PRD90104', 'Guide'));
				sheetObj.SetCellValue(Row, "s_route_flg", sheetObj.GetCellValue(Row, "s_upd_ind_cd"), 0);
			} else {
				sheetObj.SetCellValue(Row, "s_prior", 1, 0);
			}
			return;
		}
		if (Val == "N" && OCN_FLG != 'S') {
			ComShowMessage(ComGetMsg('PRD90104', 'Not Used'));
			sheetObj.SetCellValue(Row, "s_route_flg", sheetObj.GetCellValue(Row, "s_upd_ind_cd"), 0);
			return;
		}
	}
}

/*
 * checking input condition for retrieve
 */
function checkInput() {
	var formObject = document.form;
	var pol_port_cd = formObject.pol_port_cd.value;
	var pod_port_cd = formObject.pod_port_cd.value;
	var tnk_lane_cd = formObject.tnk_lane_cd.value;
	if ($('#form #pol_port_cd').hasClass("input1")) {
		if (ComIsNull(pol_port_cd)) {
			ComShowCodeMessage("COM130403", 'POL');
			return false;
		}
	}
	if ($('#form #pod_port_cd').hasClass("input1")) {
		if (ComIsNull(pod_port_cd)) {
			ComShowCodeMessage("COM130403", 'POD');
			return false;
		}
	}
	if ($('#form #tnk_lane_cd').hasClass("input1")) {
		if (ComIsNull(tnk_lane_cd)) {
			ComShowCodeMessage("COM130403", 'Lane');
			return false;
		}
	}

	if (pol_port_cd.length > 0) {
		if (!(pol_port_cd.length == 2 || pol_port_cd.length == 5)) {
			ComShowMessage(ComGetMsg('PRD90121'));
			formObject.pol_port_cd.select();
			return false;
		}
	}
	if (pod_port_cd.length > 0) {
		if (!(pod_port_cd.length == 2 || pod_port_cd.length == 5)) {
			ComShowMessage(ComGetMsg('PRD90121'));
			formObject.pod_port_cd.select();
			return false;
		}
	}
	return true;
}