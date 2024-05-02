/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName 	 : ESD_PRD_0024.js
 *@FileTitle  : Constraint Management  
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/02
=========================================================*/
/***********************************************<br>
 * Event code : <br>
 * INIT=0; <br>
 * ADD=1; <br>
 * SEARCH=2; <br>
 * SEARCHLIST=3; <br>
 * MODIFY=4; <br>
 * REMOVE=5; <br>
 * REMOVELIST=6 <br>
 * MULTI=7 <br>
 * OTHER CASE : <br>
 * COMMAND01=11; ~ <br>
 * COMMAND20=30; <br>
 ************************************************/
var sheetObjects = new Array();
var sheetCnt = 0;
var validateData = "";
var retValidate = 0;
var beforetab = 2;
var nodeCd = "";
var link_flag = "";
var hub_flg = "";
var mode = "";
var popOpenObj;
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[beforetab];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName))
			return false;
		var srcObj = ComGetEvent("nodeName");
		var keyObj = window.event.keyCode;
		if ((srcObj == 'INPUT' || srcObj == 'SELECT') && keyObj == 13) {
			srcName = 'btn_retrieve';
		}
		/** ************************* */
		switch (srcName) {
			case "btn_retrieve": {
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;
			}
			case "btn_new":
				sheetObject.RemoveAll();
				formObject.reset();
				changeSelection(2);
				break;
			case "btn_save": {
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
			}
			case "btn_downexcel":
				if (sheetObject.RowCount() < 1) {// no data
					ComShowCodeMessage("COM132501");
				} else {
					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
				}

				break;
			case "btn_loadexcel":
				doActionIBSheet(sheetObject, formObject, IBLOADEXCEL);
				break;
			case "btng_rowadd": {
				var Row = sheetObject.DataInsert();
				sheetObject.SetCellValue(Row, "s_node_code", "ALL", 0);
				sheetObject.SetCellValue(Row, "s_trunk_lane", "ALL", 0);
				break;
			}
			case "btng_rowcopy": {
				var Row = sheetObject.DataCopy();
				break;
			}
			case "btng_hrowadd": {
				var Row = sheetObject.DataInsert();
				break;
			}
			case "btng_hrowcopy": {
				var Row = sheetObject.DataCopy();
				break;
			}
			case "btn_node_cd":
				selectLocation('LOC');
				break;
			case "btn_from_cd":
				selectLocation('FROM');
				break;
			case "btn_to_cd":
				selectLocation('TO');
				break;
			case "btn_por_port_cd":
				selectPort(formObject, 'POR');
				break;
			case "btn_pol_port_cd":
				selectPort(formObject, 'POL');
				break;
			case "btn_pod_port_cd":
				selectPort(formObject, 'POD');
				break;
			case "btn_ts_port_cd":
				selectPort(formObject, 'TS');
				break;
			case "btn_del_port_cd":
				selectPort(formObject, 'DEL');
				break;
			case "btn_tnk_lane_cd": {
				selectLane();
				break;
			}
			case "btn_hport_cd": {
				fnPopupHubLocation(formObject.hport_cd);
				break;
			}
			case "btn_hhub_loc_cd_cd": {
				fnPopupHubLocation(formObject.hhub_loc_cd);
				break;
			}
			case "btn_hnod_cd": {
				fnPopupLocation(formObject.hnod_cd);
				break;
			}
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(ComGetMsg('PRD90007'));
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * Hub Port / Hub Location
 * 
 * @param obj
 */
function fnPopupHubLocation(obj) {
	popOpenObj = obj;
	ComOpenPopup('/opuscntr/COM_ENS_051.do?loc_cd=' + obj.value, 800, 500, 'setFnPopupHubLocation', '1,0,1,1,1,1,1,1,1,1,1,1', true, false)
}

/**
 * 
 * @param obj
 */
function fnPopupLocation(obj) {
	popOpenObj = obj;
	var param = '?loc_port_ind=1';
	if (!ComIsEmpty(obj.value) && obj.value.length > 5) {
		param += "&node_cd=" + obj.value;
		param += "&loc_cd=" + obj.value.substring(0, 5);
	} else {
		param += "&loc_cd=" + obj.value;
	}
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 810, 550, 'setFnPopupHubLocation', '1,0,1,1,1,1,1,1,1,1,1,1', true, false)
}

/**
 * 
 * @param rowArray
 */
function setFnPopupHubLocation(rowArray) {
	var colArray = rowArray[0];
	popOpenObj.value = colArray[3];
}

/**
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	var sXml = sheetObjects[4].GetSearchData("ESD_PRD_0024GS.do", "f_cmd=" + SEARCH12);
	var arrCombo = ComXml2ComboString(sXml, "cntr_tp_cd", "cntr_tp_cd");
	sheetObjects[0].SetColProperty("cntr_tp_cd", { ComboText : "|" + arrCombo[1], ComboCode : "|" + arrCombo[0] });
	sheetObjects[1].SetColProperty("cntr_tp_cd", { ComboText : "|" + arrCombo[1], ComboCode : "|" + arrCombo[0] });
	sheetObjects[2].SetColProperty("cntr_tp_cd", { ComboText : "|" + arrCombo[1], ComboCode : "|" + arrCombo[0] });
	sheetObjects[3].SetColProperty("cntr_tp_cd", { ComboText : "|" + arrCombo[1], ComboCode : "|" + arrCombo[0] });

	var sXml1 = sheetObjects[4].GetSearchData("ESD_PRD_0024GS.do", "f_cmd=" + SEARCH13);
	var arrCombo1 = ComXml2ComboString(sXml1, "cntr_sz_cd", "cntr_sz_cd");
	sheetObjects[0].SetColProperty("cntr_sz_cd", { ComboText : "|" + arrCombo1[1], ComboCode : "|" + arrCombo1[0] });
	sheetObjects[1].SetColProperty("cntr_sz_cd", { ComboText : "|" + arrCombo1[1], ComboCode : "|" + arrCombo1[0] });
	sheetObjects[2].SetColProperty("cntr_sz_cd", { ComboText : "|" + arrCombo1[1], ComboCode : "|" + arrCombo1[0] });
	sheetObjects[3].SetColProperty("cntr_sz_cd", { ComboText : "|" + arrCombo1[1], ComboCode : "|" + arrCombo1[0] });

	var form = document.form;
	var sheetObject = sheetObjects[beforetab];
	if (mode != 'pop' && link_flag == 'Y') {
		changeSelection(1);
		sheetObject = sheetObjects[beforetab];
		doActionIBSheet(sheetObject, form, IBSEARCH);
	} else if (mode == 'pop' && link_flag != 'Y') {
		beforetab = 0;
		changeSelection(0);
		sheetObject = sheetObjects[beforetab];
		doActionIBSheet(sheetObject, form, IBSEARCH);
	} else {
		changeSelection(2);
	}
	axon_event.addListenerForm('change', 'form_onChange', form);
	axon_event.addListenerForm('keypress', 'PrdComKeyEnter', document.form);
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
	if (srcName == "tlane") {
		inputChkUpper(window.event.srcElement, keyObj, 'SEARCH07');
	} else if (srcName == "por") {
		inputChkUpper(window.event.srcElement, keyObj, 'SEARCH02');
	} else if (srcName == "pol") {
		if (srcValue != 'ALL')
			inputChkUpper(window.event.srcElement, keyObj, 'SEARCH01');
	} else if (srcName == "pod") {
		if (srcValue != 'ALL')
			inputChkUpper(window.event.srcElement, keyObj, 'SEARCH01');
	} else if (srcName == "del") {
		inputChkUpper(window.event.srcElement, keyObj, 'SEARCH02');
	}
}

/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
		case 1: {
			with (sheetObj) {
				var HeadTitle1 = "SEQ|Del.|STS|Location/\nNode|Point \nof Port|Item Name|LANE|Cargo Nature|Container|Container|Commodity|Commodity|SVC|Remark|Effective Date|Effective Date|Creation\nDate|Creation\nOFC|Creation\nID|ORG ITEM CD|ITEM NAME";
				var HeadTitle2 = "SEQ|Del.|STS|Location/\nNode|Point \nof Port|Item Name|LANE|Cargo Nature|Type|Size|Code|Name|SVC|Remark|From|To|Creation\nDate|Creation\nOFC|Creation\nID|ORG ITEM CD|ITEM NAME";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [
						{ Text : HeadTitle1, Align : "Center" }, { Text : HeadTitle2, Align : "Center" }
				];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "Seq", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "" },
						{ Type : "DelCheck", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : -1 },
						{ Type : "Status", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "ibflag" },
						{ Type : "PopupEdit", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_node_code", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 7 },
						{ Type : "Combo", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_point_code", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Combo", Hidden : 0, Width : 150, Align : "Center", ColMerge : 1, SaveName : "s_item_code", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "PopupEdit", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "vsl_slan_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Combo", Hidden : 0, Width : 150, Align : "Center", ColMerge : 1, SaveName : "spcl_cgo_cntr_tp_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Combo", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "cntr_tp_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 1 },
						{ Type : "Combo", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "cntr_sz_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 1 },
						{ Type : "PopupEdit", Hidden : 0, Width : 60, Align : "Center", ColMerge : 1, SaveName : "s_commodity_code", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 6 },
						{ Type : "Text", Hidden : 0, Width : 120, Align : "Left", ColMerge : 1, SaveName : "s_commodity_name", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Combo", Hidden : 0, Width : 60, Align : "Center", ColMerge : 1, SaveName : "s_svc_flg", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 400, Align : "Left", ColMerge : 1, SaveName : "s_remark", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, MultiLineText : 1 },
						{ Type : "PopupEdit", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_eff_fm", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "PopupEdit", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_eff_to", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Date", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_cre_dt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_cre_ofc", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_cre_user", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_org_item_code", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_item_name", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_date_diff", KeyField : 0, CalcLogic : "DateDiff(d, |s_eff_fm|, |s_eff_to|)", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_nod_cnst_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 }
				];

				InitColumns(cols);
				SetEditable(1);

				SetColProperty(0, "s_svc_flg", { ComboText : "|Y|N", ComboCode : "|Y|N" });
				SetColProperty(0, "vsl_slan_cd", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "s_item_code", { ComboText : cnst_cdText, ComboCode : cnst_cdCode });
				SetColProperty(0, "s_point_code", { ComboText : point_cdText, ComboCode : point_cdCode });
				SetColProperty(0, "s_node_code", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "s_commodity_code", { AcceptKeys : "N", InputCaseSensitive : 1 });
				SetColProperty(0, "spcl_cgo_cntr_tp_cd", { ComboText : "ALL|" + spcl_cgo_cntr_tp_cdText, ComboCode : "AL|" + spcl_cgo_cntr_tp_cdCode });
				SetImageList(0, "/opuscntr/img/opus/button/btns_calendar.gif");
				SetHeaderRowHeight(20);
				SetSheetHeight(300);
			}
			break;
		}
		case 2: {
			with (sheetObj) {
				var HeadTitle1 = "SEQ|Del.|STS|Link|Link|Mode|Item Name|Cargo Nature|Container|Container|Commodity|Commodity|SVC|Remark|Effective Date|Effective Date|Creation\nDate|Creation\nOFC|Creation\nID";
				var HeadTitle2 = "SEQ|Del.|STS|From|To|Mode|Item Name|Cargo Nature|Type|Size|Code|Name|SVC|Remark|From|To|Creation\nDate|Creation\nOFC|Creation\nID";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [
						{ Text : HeadTitle1, Align : "Center" }, { Text : HeadTitle2, Align : "Center" }
				];
				InitHeaders(headers, info);

				var cols = [
						{ Type : "Seq", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "" },
						{ Type : "DelCheck", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : -1 },
						{ Type : "Status", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "ibflag" },
						{ Type : "PopupEdit", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_node_fm", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 7 },
						{ Type : "PopupEdit", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_node_to", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 7 },
						{ Type : "Combo", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_ts_mode", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Combo", Hidden : 0, Width : 150, Align : "Center", ColMerge : 1, SaveName : "s_item_code", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Combo", Hidden : 0, Width : 150, Align : "Center", ColMerge : 1, SaveName : "spcl_cgo_cntr_tp_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Combo", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "cntr_tp_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 1 },
						{ Type : "Combo", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "cntr_sz_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 1 },
						{ Type : "PopupEdit", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_commodity_code", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 6 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Left", ColMerge : 1, SaveName : "s_commodity_name", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Combo", Hidden : 0, Width : 60, Align : "Center", ColMerge : 1, SaveName : "s_svc_flg", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 400, Align : "Left", ColMerge : 1, SaveName : "s_remark", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, MultiLineText : 1 },
						{ Type : "PopupEdit", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_eff_fm", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "PopupEdit", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_eff_to", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Date", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_cre_dt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_cre_ofc", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_cre_user", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_org_item_code", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_item_name", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_date_diff", KeyField : 0, CalcLogic : "DateDiff(d, |s_eff_fm|, |s_eff_to|)", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_lnk_cnst_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 }
				];

				InitColumns(cols);
				SetEditable(1);
				SetSheetHeight(300);
				SetImageList(0, "/opuscntr/img/opus/button/btns_calendar.gif");
				SetCellBackColor(1, 3, "#555555");
				SetCellBackColor(1, 4, GetCellBackColor(1, 3));
				SetCellBackColor(1, 10, GetCellBackColor(1, 3));
				SetCellBackColor(1, 11, GetCellBackColor(1, 3));
				SetColProperty("s_svc_flg", { ComboText : "|Y|N", ComboCode : "|Y|N" });
				SetColProperty("s_ts_mode", { ComboText : '|' + trsp_mod_cdText, ComboCode : 'AL|' + trsp_mod_cdCode });
				SetColProperty("s_item_code", { ComboText : cnst_cdText, ComboCode : cnst_cdCode });
				SetColProperty(0, "s_node_fm", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "s_node_to", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "s_commodity_code", { AcceptKeys : "N", InputCaseSensitive : 1 });
				SetColProperty(0, "spcl_cgo_cntr_tp_cd", { ComboText : "ALL|" + spcl_cgo_cntr_tp_cdText, ComboCode : "AL|" + spcl_cgo_cntr_tp_cdCode });
				SetHeaderRowHeight(20);
			}
			break;
		}
		case 3: {
			with (sheetObj) {
				var HeadTitle1 = "SEQ|Del.|STS|T.LANE|BD|POR/NODE|POR/NODE|POL/NODE|POL/NODE|LANE|1st T/S|1st T/S|2nd T/S|2nd T/S|POD/NODE|POD/NODE|DEL/NODE|DEL/NODE|Cargo Nature|Container|Container|SVC|REMARKS|Creation\nDate|Creation\nOFC|Creation\nID|Deletion\nDate|Deletion\nOFC|Deletion\nID";
				var HeadTitle2 = "SEQ|Del.|STS|T.LANE|BD|Loc.|Node|Loc.|Node|LANE|Port|Lane|Port|Lane|Loc.|Node|Loc.|Node|Cargo Nature|Type|Size|SVC|REMARKS|Creation\nDate|Creation\nOFC|Creation\nID|Deletion\nDate|Deletion\nOFC|Deletion\nID";

				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [
						{ Text : HeadTitle1, Align : "Center" }, { Text : HeadTitle2, Align : "Center" }
				];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "Seq", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "" },
						{ Type : "DelCheck", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "delchk", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : -1 },
						{ Type : "Status", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "ibflag" },
						{ Type : "PopupEdit", Hidden : 0, Width : 60, Align : "Center", ColMerge : 1, SaveName : "s_trunk_lane", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 3 },
						{ Type : "Combo", Hidden : 0, Width : 60, Align : "Center", ColMerge : 1, SaveName : "s_dir_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 3 },
						{ Type : "PopupEdit", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_por", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 5 },
						{ Type : "Text", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "s_por_node", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 2 },
						{ Type : "PopupEdit", Hidden : 0, Width : 60, Align : "Center", ColMerge : 1, SaveName : "s_pol", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 5 },
						{ Type : "Text", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "s_pol_node", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 2 },
						{ Type : "PopupEdit", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_lane", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 3 },
						{ Type : "PopupEdit", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_ts1_port", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 5 },
						{ Type : "PopupEdit", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_ts1_lane", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 3 },
						{ Type : "PopupEdit", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_ts2_port", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 5 },
						{ Type : "PopupEdit", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_ts2_lane", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 3 },
						{ Type : "PopupEdit", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_pod", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 5 },
						{ Type : "Text", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "s_pod_node", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 2 },
						{ Type : "PopupEdit", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_del", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 5 },
						{ Type : "Text", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "s_del_node", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 2 },
						{ Type : "Combo", Hidden : 0, Width : 150, Align : "Center", ColMerge : 1, SaveName : "spcl_cgo_cntr_tp_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Combo", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "cntr_tp_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 1 },
						{ Type : "Combo", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "cntr_sz_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 1 },
						{ Type : "Combo", Hidden : 0, Width : 45, Align : "Center", ColMerge : 1, SaveName : "s_svc_flg", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 400, Align : "Left", ColMerge : 1, SaveName : "s_remark", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, MultiLineText : 1 },
						{ Type : "Date", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_cre_dt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_cre_ofc", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_cre_user", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Date", Hidden : 1, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_delDt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_delOfc", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 1, SaveName : "s_delUser", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 30, Align : "Center", ColMerge : 1, SaveName : "s_rout_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 30, Align : "Center", ColMerge : 1, SaveName : "s_del_chk", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 }
				];

				InitColumns(cols);
				SetEditable(1);
				SetSheetHeight(300);
				SetRangeBackColor(1, 8, 1, 11, "#555555");
				SetHeaderRowHeight(20);
				SetColProperty(0, "s_svc_flg", { ComboText : "|Y|N", ComboCode : "|Y|N" });
				SetColProperty(0, "s_dir_cd", { ComboText : "|" + dir_cdText, ComboCode : "|" + dir_cdCode });
				SetColProperty(0, "s_trunk_lane", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "s_por", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "s_por_node", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "s_pol", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "s_pol_node", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "s_lane", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "s_ts1_port", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "s_ts1_lane", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "s_ts2_port", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "s_ts2_lane", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "s_pod", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "s_pod_node", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "s_del", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "s_del_node", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "spcl_cgo_cntr_tp_cd", { ComboText : "ALL|" + spcl_cgo_cntr_tp_cdText, ComboCode : "AL|" + spcl_cgo_cntr_tp_cdCode });
			}
			break;
		}
		case 4: {
			with (sheetObj) {
				var HeadTitle1 = "SEQ|Del.|STS|Port|Hub Location|Location/Node|Bound|DIR|Lane|Cargo Nature|Container|Container|SVC|Remark|Creation\nDate|Creation\nOFC|Creation\nID|";
				var HeadTitle2 = "SEQ|Del.|STS|Port|Hub Location|Location/Node|Bound|DIR|Lane|Cargo Nature|Type|Size|SVC|Remark|Creation\nDate|Creation\nOFC|Creation\nID|";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [
						{ Text : HeadTitle1, Align : "Center" }, { Text : HeadTitle2, Align : "Center" }
				];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "Seq", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "" }, { Type : "DelCheck", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Status", Hidden : 0, Width : 60, Align : "Center", ColMerge : 1, SaveName : "ibflag" },
						{ Type : "PopupEdit", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "port_cd", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 5 },
						{ Type : "PopupEdit", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "hub_loc_cd", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 5 },
						{ Type : "PopupEdit", Hidden : 0, Width : 150, Align : "Center", ColMerge : 1, SaveName : "nod_cd", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 7 },
						{ Type : "Combo", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "io_bnd_cd", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Combo", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "dir_cd", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "PopupEdit", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "cnst_lane_cd", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Combo", Hidden : 0, Width : 150, Align : "Center", ColMerge : 1, SaveName : "spcl_cgo_cntr_tp_cd", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Combo", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "cntr_tp_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 1 },
						{ Type : "Combo", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "cntr_sz_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 1 },
						{ Type : "Combo", Hidden : 0, Width : 60, Align : "Center", ColMerge : 1, SaveName : "svc_use_flg", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 200, Align : "left", ColMerge : 1, SaveName : "hub_loc_cnst_rmk", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, MultiLineText : 1 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "cre_dt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "cre_ofc", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "cre_usr_id", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }					
				];
				InitColumns(cols);
				SetEditable(1);
				SetColProperty(0, "svc_use_flg", { ComboText : "N|Y", ComboCode : "N|Y" });
				SetColProperty(0, "io_bnd_cd", { ComboText : "ALL|Inbound|Outbond", ComboCode : "B|I|O" });
				SetColProperty(0, "port_cd", { AcceptKeys : "E", InputCaseSensitive : 1 });
				SetColProperty(0, "hub_loc_cd", { AcceptKeys : "E", InputCaseSensitive : 1 });
				SetColProperty(0, "nod_cd", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "cnst_lane_cd", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "spcl_cgo_cntr_tp_cd", { ComboText : "ALL|" + spcl_cgo_cntr_tp_cdText, ComboCode : "AL|" + spcl_cgo_cntr_tp_cdCode });
				SetColProperty(0, "dir_cd", { ComboText : "ALL|" + dir_cdText, ComboCode : "A|" + dir_cdCode });
				SetHeaderRowHeight(20);
				SetSheetHeight(300);
			}
			break;
		}
		case 5: {
			with (sheetObj) {
				var HeadTitle1 = "Code|Value";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [
					{ Text : HeadTitle1, Align : "Center" }
				];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "Text", Hidden : 0, Width : 200, Align : "left", ColMerge : 1, SaveName : "Code", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, MultiLineText : 1 },
						{ Type : "Text", Hidden : 0, Width : 200, Align : "left", ColMerge : 1, SaveName : "Value", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, MultiLineText : 1 },
				];
				InitColumns(cols);
				SetVisible(false);
			}
			break;
		}
	}
}

function resizeSheet(sheetObj) {
	ComResizeSheet(sheetObj);
}
// handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	var uid;
	var sXml;
	switch (sAction) {
		case IBSEARCH:
			if (validateForm(sheetObj, formObj, sAction)) {
				if (beforetab == 0) {
					formObj.f_cmd.value = SEARCH01;
				} else if (beforetab == 1) {
					formObj.f_cmd.value = SEARCH02;
				} else if (beforetab == 2) {
					formObj.f_cmd.value = SEARCH03;
				} else if (beforetab == 3) {
					formObj.f_cmd.value = SEARCH10;
				}
				sheetObj.DoSearch("ESD_PRD_0024GS.do", PrdFQString(formObj), { Sync : 2 });
				break;
			}
		case IBSAVE: {
			if (validateForm(sheetObj, formObj, sAction) && !keyFieldCheck(sheetObj)) {
				return;
			}
			if (beforetab == 0) {
				formObj.f_cmd.value = MULTI01;
			} else if (beforetab == 1) {
				formObj.f_cmd.value = MULTI02;
			} else if (beforetab == 2) {
				formObj.f_cmd.value = MULTI03;
			} else if (beforetab == 3) {
				formObj.f_cmd.value = MULTI04;
			}
			sheetObj.DoSave("ESD_PRD_0024GS.do", PrdFQString(formObj));
			break;
		}
		case IBDOWNEXCEL:
			sheetObj.Down2Excel({ DownCols : makeHiddenSkipCol(sheetObj), DownCombo:"CODE", SheetDesign : 1, Merge : 1 });
			break;
		case IBLOADEXCEL:
			sheetObj.LoadExcel();
			break;
		case SEARCH01: // Port Check
			formObj.f_cmd.value = SEARCH01;
			uid = "ESD_PRD_024";
			sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetStrEtcData(sXml, "rowCount");
			break;
		case SEARCH02: // Location Check
			formObj.f_cmd.value = SEARCH02;
			uid = "ESD_PRD_024";
			sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetStrEtcData(sXml, "rowCount");
			break;
		case SEARCH07: // Lane Check
			formObj.f_cmd.value = SEARCH07;
			uid = "ESD_PRD_024";
			sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetStrEtcData(sXml, "rowCount");
			break;
		case SEARCH04: // Node Check
			formObj.f_cmd.value = SEARCH04;
			uid = "ESD_PRD_0024";
			sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetStrEtcData(sXml, "rowCount");
			break;
		case SEARCH06: // Country Check
			formObj.f_cmd.value = SEARCH06;
			uid = "ESD_PRD_0024";
			sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetStrEtcData(sXml, "rowCount");
			break;
	}
}

/**
 * 
 */
function keyFieldCheck(sheetObj) {
	var sRow = sheetObj.FindStatusRow("I|U");
	var arrow = sRow.split(";");
	for ( var i = 0; i < arrow.length; i++) {
		var selectRow = arrow[i];
		if (ComIsNull(selectRow)) {
			continue;
		}
		var inValue = $.trim(sheetObj.GetCellValue(selectRow, "cntr_tp_cd") + '' + sheetObj.GetCellValue(selectRow, "cntr_sz_cd"));
		if (sheetObj.GetCellValue(selectRow, "s_item_code") == "R" || sheetObj.GetCellValue(selectRow, "s_item_code") == "F" || sheetObj.GetCellValue(selectRow, "s_item_code") == "S") {
			if (inValue.length != 1) {
				ComShowMessage(ComGetMsg('PRD90056', sheetObj.GetCellValue(selectRow, 0)));
				sheetObj.SelectCell(selectRow, "cntr_tp_cd");
				return false;
			}
		} else if (sheetObj.GetCellValue(selectRow, "s_item_code") == "5" || sheetObj.GetCellValue(selectRow, "s_item_code") == "7") {
			if (inValue.length != 2) {
				ComShowMessage(ComGetMsg('PRD90056', sheetObj.GetCellValue(selectRow, 0)));
				sheetObj.SelectCell(selectRow, "cntr_tp_cd");
				return false;
			}
		}
		var matchedFlag = false;
		if (sheetObj.GetCellValue(selectRow, "s_item_code") == "A" && inValue != "R2") {
			matchedFlag = true;
		} else if (sheetObj.GetCellValue(selectRow, "s_item_code") == "B" && inValue != "R5") {
			matchedFlag = true;
		} else if (sheetObj.GetCellValue(selectRow, "s_item_code") == "2" && inValue != "D2") {
			matchedFlag = true;
		} else if (sheetObj.GetCellValue(selectRow, "s_item_code") == "4" && inValue != "D4") {
			matchedFlag = true;
		} else if (sheetObj.GetCellValue(selectRow, "s_item_code") == "5" && inValue != "D5") {
			matchedFlag = true;
		} else if (sheetObj.GetCellValue(selectRow, "s_item_code") == "7" && inValue != "D7") {
			matchedFlag = true;
		} else if (sheetObj.GetCellValue(selectRow, "s_item_code") == "S" && inValue != "S") {
			matchedFlag = true;
		}
		if (matchedFlag) {
			ComShowMessage(ComGetMsg('PRD90058'));
			sheetObj.SelectCell(selectRow, "s_item_code");
			return false;
		}
	}
	return true;
}

// getting Node Constraint Item Name
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var arrText = cnst_cdText.split("|");
	var arrCode = cnst_cdCode.split("|");
	if (sheetObj.GetCellValue(Row, "s_item_name") == "")
		sheetObj.SetCellValue(Row, "s_item_name", arrText[0], 0);
	if (sheetObj.ColSaveName(Col) == "s_item_code") {
		var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
		sheetObj.SetCellValue(Row, "s_item_name", arrText[idx], 0);
		if (Value == "A") { // R2 :A selection ( R5:B)
			sheetObj.SetCellValue(Row, "cntr_tp_cd", "R", 0);
			sheetObj.SetCellValue(Row, "cntr_sz_cd", "2", 0);
		} else if (Value == "B") {
			sheetObj.SetCellValue(Row, "cntr_tp_cd", "R", 0);
			sheetObj.SetCellValue(Row, "cntr_sz_cd", "5", 0);
		} else if (Value == "2") {
			sheetObj.SetCellValue(Row, "cntr_tp_cd", "D", 0);
			sheetObj.SetCellValue(Row, "cntr_sz_cd", "2", 0);
		} else if (Value == "4") {
			sheetObj.SetCellValue(Row, "cntr_tp_cd", "D", 0);
			sheetObj.SetCellValue(Row, "cntr_sz_cd", "4", 0);
		} else if (Value == "5") {
			sheetObj.SetCellValue(Row, "cntr_tp_cd", "D", 0);
			sheetObj.SetCellValue(Row, "cntr_sz_cd", "5", 0);
		} else if (Value == "7") {
			sheetObj.SetCellValue(Row, "cntr_tp_cd", "D", 0);
			sheetObj.SetCellValue(Row, "cntr_sz_cd", "7", 0);
		} else if (Value == "S") { // F/R, O/T Constraint -> S selection
			sheetObj.SetCellValue(Row, "cntr_tp_cd", "S", 0);
			sheetObj.SetCellValue(Row, "cntr_tp_cd", "", 0);
		} else if (Value == "N") { // No Service -> Service Flag - Default : 'N'
			sheetObj.SetCellValue(Row, "s_svc_flg", "N", 0);
			sheetObj.SetCellValue(Row, "cntr_tp_cd", "", 0);
		}
	} else if (sheetObj.ColSaveName(Col) == "s_node_code") {
		validateData = Value.toUpperCase();
		if (Value.length != 2 && sheetObj.GetCellValue(Row, "s_node_code") != "ALL" && Value.length != 5 && Value.length != 7) {
			ComShowMessage(ComGetMsg('PRD90059'));
			sheetObj.SetCellValue(Row, Col, "", 0);
			sheetObj.SelectCell(Row, "s_node_code");
			return false;
		} else if (Value.length == 2)
			doActionIBSheet(sheetObj, document.form, SEARCH06);
		else if (Value.length == 5)
			doActionIBSheet(sheetObj, document.form, SEARCH02);
		else if (Value.length == 7)
			doActionIBSheet(sheetObj, document.form, SEARCH04);
		if (retValidate == "" || retValidate < 1) {
			sheetObj.SetCellValue(Row, "s_node_code", "", 0);
			sheetObj.SelectCell(Row, "s_node_code");
		}
	} else if (sheetObj.ColSaveName(Col) == "cntr_tp_cd" || sheetObj.ColSaveName(Col) == "cntr_sz_cd") {
		var inValue = $.trim(sheetObj.GetCellValue(Row, "cntr_tp_cd") + '' + sheetObj.GetCellValue(Row, "cntr_sz_cd"));
		var matchedFlag = false;
		if (inValue != "S") {
			if (!checkCntrTypeSize(sheetObj, Row)) {
				sheetObj.SetCellValue(Row, Col, "", 0);
				return false;
			}
		}
		if (inValue == 'S' || inValue.length == 2) {
			if (sheetObj.GetCellValue(Row, "s_item_code") == "A" && inValue != "R2") {
				matchedFlag = true;
			} else if (sheetObj.GetCellValue(Row, "s_item_code") == "B" && inValue != "R5") {
				matchedFlag = true;
			} else if (sheetObj.GetCellValue(Row, "s_item_code") == "2" && inValue != "D2") {
				matchedFlag = true;
			} else if (sheetObj.GetCellValue(Row, "s_item_code") == "4" && inValue != "D4") {
				matchedFlag = true;
			} else if (sheetObj.GetCellValue(Row, "s_item_code") == "5" && inValue != "D5") {
				matchedFlag = true;
			} else if (sheetObj.GetCellValue(Row, "s_item_code") == "7" && inValue != "D7") {
				matchedFlag = true;
			} else if (sheetObj.GetCellValue(Row, "s_item_code") == "S" && inValue != "S") {
				matchedFlag = true;
			}
			if (matchedFlag) {
				ComShowMessage(ComGetMsg('PRD90058'));
				sheetObj.SelectCell(Row, "cntr_tp_cd");
				return false;
			}
		}
	} else if (sheetObj.ColSaveName(Col) == "s_commodity_code") {
		sheetObj.ShowDebugMsg(false);
		sheetObj.DoRowSearch(Row, "ESD_PRD_0024GS.do", "f_cmd=" + SEARCH11 + "&cmdt_cd=" + Value + "&row=" + Row + "&col=" + Col, { Sync : 2 })
		if (sheetObj.GetEtcData("rowCount") == 0) {
			ComShowMessage(ComGetMsg('PRD90055'));
		}
	}
}
function sheet1_OnSaveEnd(sheetObj) {
	var formObject = document.form;
	doActionIBSheet(sheetObj, formObject, IBSEARCH);
}

function sheet1_OnPopupClick(sheetObj, row, col) {
	var cal;
	var param;
	if (sheetObj.ColSaveName(col) == "s_eff_fm") {
		cal = new ComCalendarGrid();
		cal.select(sheetObj, row, col, "yyyyMMdd");
	} else if (sheetObj.ColSaveName(col) == "s_eff_to") {
		cal = new ComCalendarGrid();
		cal.select(sheetObj, row, col, "yyyyMMdd");
	} else if (sheetObj.ColSaveName(col) == "s_node_code") {
		var loc_cd_val = sheetObj.GetCellValue(row, col);
		if (sheetObj.ColSaveName(col) == "s_node_code" && sheetObj.GetRowStatus(row) == "I" && sheetObj.GetCellValue(row, "s_node_code") == 'ALL') {
			loc_cd_val = "";
		}
		param = '?node_cd=' + loc_cd_val;
		ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 810, 550, 'getNode', "1,0,1,1,1,1,1,1,1,1,1,1", true, false, row, col, 0);
	} else if (sheetObj.ColSaveName(col) == "s_commodity_code") {
		var cmdt_cd = sheetObj.GetCellValue(row, col);
		param = '?cmdt_cd=' + cmdt_cd;
		ComOpenPopup('/opuscntr/COM_ENS_011.do' + param, 800, 450, 'getCommodity', "1,0,1,1,1,1,1,1,1,1,1,1", true, false, row, col, 0);
	} else if (sheetObj.ColSaveName(col) == "vsl_slan_cd") {
		var slan_cd_val = sheetObj.GetCellValue(row, col);
		param = '?&lane_cd=' + slan_cd_val;
		ComOpenPopup('/opuscntr/COM_ENS_081.do' + param, 800, 400, 'getLane', "1,0,1,1,1,1,1,1,1,1,1,1", true, false, row, col, 0);
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
	if (isExceedMaxRow(msg))
		return;

	var totalRow = sheetObj.RowCount();
	for (i = totalRow + 1; i > 1; i--) {
		if (sheetObj.GetCellValue(i, "s_node_code") == "") {
			sheetObj.RowDelete(i, false);
		}
	}
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
	var arrText = cnst_cdText.split("|");
	var arrCode = cnst_cdCode.split("|");
	if (sheetObj.GetCellValue(Row, "s_item_name") == "")
		sheetObj.SetCellValue(Row, "s_item_name", arrText[0], 0);
	if (sheetObj.ColSaveName(Col) == "s_item_code") {
		var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
		sheetObj.SetCellValue(Row, "s_item_name", arrText[idx], 0);
		if (Value == "A") {
			// R2 :A selection ( R5:B)
			sheetObj.SetCellValue(Row, "cntr_tp_cd", "R", 0);
			sheetObj.SetCellValue(Row, "cntr_sz_cd", "2", 0);
		} else if (Value == "B") {
			sheetObj.SetCellValue(Row, "cntr_tp_cd", "R", 0);
			sheetObj.SetCellValue(Row, "cntr_sz_cd", "5", 0);
		} else if (Value == "2") {
			sheetObj.SetCellValue(Row, "cntr_tp_cd", "D", 0);
			sheetObj.SetCellValue(Row, "cntr_sz_cd", "2", 0);
		} else if (Value == "4") {
			sheetObj.SetCellValue(Row, "cntr_tp_cd", "D", 0);
			sheetObj.SetCellValue(Row, "cntr_sz_cd", "4", 0);
		} else if (Value == "5") {
			sheetObj.SetCellValue(Row, "cntr_tp_cd", "D", 0);
			sheetObj.SetCellValue(Row, "cntr_sz_cd", "5", 0);
		} else if (Value == "7") {
			sheetObj.SetCellValue(Row, "cntr_tp_cd", "D", 0);
			sheetObj.SetCellValue(Row, "cntr_sz_cd", "7", 0);
		} else if (Value == "S") {
			// F/R, O/T Constraint -> S selection
			sheetObj.SetCellValue(Row, "cntr_tp_cd", "S", 0);
			sheetObj.SetCellValue(Row, "cntr_tp_cd", "", 0);
		} else if (Value == "N") {
			sheetObj.SetCellValue(Row, "s_svc_flg", "N", 0);
			sheetObj.SetCellValue(Row, "cntr_tp_cd", "", 0);
		}
	} else if (sheetObj.ColSaveName(Col) == "s_node_fm" || sheetObj.ColSaveName(Col) == "s_node_to") {
		validateData = Value.toUpperCase();
		if (Value.length != 2 && sheetObj.GetCellValue(Row, Col) != "ALL" && Value.length != 5 && Value.length != 7) {
			ComShowMessage(ComGetMsg('PRD90059'));
			sheetObj.SetCellValue(Row, Col, "", 0);
			sheetObj.SelectCell(Row, Col);
			return false;
		} else if (Value.length == 2) {
			doActionIBSheet(sheetObj, document.form, SEARCH06);
		} else if (Value.length == 5) {
			doActionIBSheet(sheetObj, document.form, SEARCH02);
		} else if (Value.length == 7) {
			doActionIBSheet(sheetObj, document.form, SEARCH04);
		}
		if (retValidate == "" || retValidate < 1) {
			sheetObj.SetCellValue(Row, Col, "", 0);
			sheetObj.SelectCell(Row, Col);
		}
	} else if (sheetObj.ColSaveName(Col) == "cntr_tp_cd" || sheetObj.ColSaveName(Col) == "cntr_sz_cd") {
		var inValue = $.trim(sheetObj.GetCellValue(Row, "cntr_tp_cd") + '' + sheetObj.GetCellValue(Row, "cntr_sz_cd"));
		if (inValue != "S") {
			if (!checkCntrTypeSize(sheetObj, Row)) {
				sheetObj.SetCellValue(Row, Col, "", 0);
				return false;
			}
		}
		if (inValue == 'S' || inValue.length == 2) {
			var matchedFlag = false;
			if (sheetObj.GetCellValue(Row, "s_item_code") == "A" && inValue != "R2") {
				matchedFlag = true;
			} else if (sheetObj.GetCellValue(Row, "s_item_code") == "B" && inValue != "R5") {
				matchedFlag = true;
			} else if (sheetObj.GetCellValue(Row, "s_item_code") == "2" && inValue != "D2") {
				matchedFlag = true;
			} else if (sheetObj.GetCellValue(Row, "s_item_code") == "4" && inValue != "D4") {
				matchedFlag = true;
			} else if (sheetObj.GetCellValue(Row, "s_item_code") == "5" && inValue != "D5") {
				matchedFlag = true;
			} else if (sheetObj.GetCellValue(Row, "s_item_code") == "7" && inValue != "D7") {
				matchedFlag = true;
			} else if (sheetObj.GetCellValue(Row, "s_item_code") == "S" && inValue != "S") {
				matchedFlag = true;
			}
			if (matchedFlag) {
				ComShowMessage(ComGetMsg('PRD90058'));
				sheetObj.SelectCell(Row, "cntr_tp_cd");
				return false;
			}
		}
	} else if (sheetObj.ColSaveName(Col) == "s_commodity_code") {
		sheetObj.ShowDebugMsg(false);
		sheetObj.DoRowSearch(Row, "ESD_PRD_0024GS.do", "f_cmd=" + SEARCH11 + "&cmdt_cd=" + Value + "&row=" + Row + "&col=" + Col, { Sync : 2 })
		if (sheetObj.GetEtcData("rowCount") == 0) {
			ComShowMessage(ComGetMsg('PRD90055'));
		}
	}
	return false;
}

function sheet2_OnSaveEnd(sheetObj) {
	var formObject = document.form;
	doActionIBSheet(sheetObj, formObject, IBSEARCH);
}
/**
 * Sheet OnLoadExcel Event
 * 
 * @param sheetObj
 * @param result
 * @param code
 * @param msg
 */
function sheet2_OnLoadExcel(sheetObj, result, code, msg) {
	if (isExceedMaxRow(msg))
		return;
}

function sheet2_OnPopupClick(sheetObj, row, col) {
	var cal;
	var param;
	if (sheetObj.ColSaveName(col) == "s_eff_fm") {
		cal = new ComCalendarGrid();
		cal.select(sheetObj, row, col, "yyyyMMdd");
	} else if (sheetObj.ColSaveName(col) == "s_eff_to") {
		cal = new ComCalendarGrid();
		cal.select(sheetObj, row, col, "yyyyMMdd");
	} else if (sheetObj.ColSaveName(col) == "s_node_fm" || sheetObj.ColSaveName(col) == "s_node_to") {
		var loc_cd_val = sheetObj.GetCellValue(row, col);
		param = '?node_cd=' + loc_cd_val;
		ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 810, 550, 'getNode', "1,0,1,1,1,1,1,1,1,1,1,1", true, false, row, col, 0);
	} else if (sheetObj.ColSaveName(col) == "s_commodity_code") {
		var cmdt_cd = sheetObj.GetCellValue(row, col);
		param = '?cmdt_cd=' + cmdt_cd;
		ComOpenPopup('/opuscntr/COM_ENS_011.do' + param, 800, 450, 'getCommodity', "1,0,1,1,1,1,1,1,1,1,1,1", true, false, row, col, 0);
	}
}

function sheet3_OnPopupClick(sheetObj, row, col) {
	var param = '';
	var slan_cd_val = '';
	var port_cd = '';
	if (sheetObj.ColSaveName(col) == "s_trunk_lane" || sheetObj.ColSaveName(col) == "s_lane" || sheetObj.ColSaveName(col) == "s_ts1_lane" || sheetObj.ColSaveName(col) == "s_ts2_lane") {
		slan_cd_val = sheetObj.GetCellValue(row, col);
		param = '?&lane_cd=' + slan_cd_val;
		ComOpenPopup('/opuscntr/COM_ENS_081.do' + param, 800, 400, 'getLane', "1,0,1,1,1,1,1,1,1,1,1,1", true, false, row, col, 0);
	} else if (sheetObj.ColSaveName(col) == "s_por" || sheetObj.ColSaveName(col) == "s_pol" || sheetObj.ColSaveName(col) == "s_pod" || sheetObj.ColSaveName(col) == "s_del") {
		port_cd = sheetObj.GetCellValue(row, col);
		param = '?loc_cd=' + port_cd;
		// node info
		ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 810, 550, 'getNode2', "1,0,1,1,1,1,1,1,1,1,1,1", true, false, row, col, 0);
	} else if (sheetObj.ColSaveName(col) == "s_ts1_port" || sheetObj.ColSaveName(col) == "s_ts2_port") {
		port_cd = sheetObj.GetCellValue(row, col);
		param = '?loc_cd=' + port_cd;
		// loc info
		ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 500, 'getLoc', '1,0,1,1,1,1,1,1,1,1,1,1', true, false, row, col, 0);
	}
}

function sheet3_OnSaveEnd(sheetObj) {
	var formObject = document.form;
	doActionIBSheet(sheetObj, formObject, IBSEARCH);
}

/**
 * Sheet OnLoadExcel Event
 * 
 * @param sheetObj
 * @param result
 * @param code
 * @param msg
 */
function sheet3_OnLoadExcel(sheetObj, result, code, msg) {
	if (isExceedMaxRow(msg))
		return;
}

/**
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @returns {Boolean}
 */
function sheet3_OnChange(sheetObj, Row, Col, Value) {
	if (sheetObj.ColSaveName(Col) == "delchk") {
		if (Value == "1")
			sheetObj.SetCellValue(Row, "s_del_chk", "1", 0);
		else
			sheetObj.SetCellValue(Row, "s_del_chk", "0", 0);
	} else {
		validateData = Value.toUpperCase();
		var colName = sheetObj.ColSaveName(Col);
		if (colName == "s_pol" || colName == "s_ts1_port" || colName == "s_ts2_port" || colName == "s_pod") {
			if (Value.length != 5) {
				if (Value != 'ALL') {
					ComShowMessage(ComGetMsg('PRD90060'));
					sheetObj.SetCellValue(Row, Col, "", 0);
					sheetObj.SelectCell(Row, Col);
				}
				if (colName == "s_pol") {
					sheetObj.SetCellValue(Row, "s_pol_node", "", 0);
				} else if (colName == "s_pod") {
					sheetObj.SetCellValue(Row, "s_pod_node", "", 0);
				}
			} else {
				doActionIBSheet(sheetObj, document.form, SEARCH01);
				if (retValidate < 1) {
					sheetObj.SetCellValue(Row, Col, "", 0);
					sheetObj.SelectCell(Row, Col);
				}
				if (colName == "s_pol") {
					sheetObj.SetCellValue(Row, "s_pol_node", "", 0);
				} else if (colName == "s_pod") {
					sheetObj.SetCellValue(Row, "s_pod_node", "", 0);
				}
			}
			return false;
		} else if (colName == "s_pol_node") {
			validateData = sheetObj.GetCellValue(Row, "s_pol") + validateData;
			if (Value.length != 2) {
				ComShowMessage(ComGetMsg('PRD90061'));
				sheetObj.SetCellValue(Row, Col, "", 0);
				sheetObj.SelectCell(Row, Col);
			} else {
				doActionIBSheet(sheetObj, document.form, SEARCH04);
				if (retValidate < 1) {
					sheetObj.SetCellValue(Row, Col, "", 0);
					sheetObj.SelectCell(Row, Col);
				}
			}
			return false;
		} else if (colName == "s_pod_node") {
			validateData = sheetObj.GetCellValue(Row, "s_pod") + validateData;
			if (Value.length != 2) {
				ComShowMessage(ComGetMsg('PRD90061'));
				sheetObj.SetCellValue(Row, Col, "", 0);
				sheetObj.SelectCell(Row, Col);
			} else {
				doActionIBSheet(sheetObj, document.form, SEARCH04);
				if (retValidate < 1) {
					sheetObj.SetCellValue(Row, Col, "", 0);
					sheetObj.SelectCell(Row, Col);
				}
			}
			return false;
		} else if (colName == "s_del") {
			if (Value.length != 5) {
				sheetObj.SetCellValue(Row, Col, "", 0);
				sheetObj.SelectCell(Row, Col);
				sheetObj.SetCellValue(Row, "s_del_node", "", 0);
			} else {
				doActionIBSheet(sheetObj, document.form, SEARCH02);
				if (retValidate < 1) {
					sheetObj.SetCellValue(Row, Col, "", 0);
					sheetObj.SelectCell(Row, Col);
				}
				sheetObj.SetCellValue(Row, "s_del_node", "", 0);
			}
			return false;
		} else if (colName == "s_del_node") {
			validateData = sheetObj.GetCellValue(Row, "s_del") + validateData;
			if (Value.length != 2) {
				ComShowMessage(ComGetMsg('PRD90061'));
				sheetObj.SelectCell(Row, sheetObj.ColSaveName(Col));
			} else {
				doActionIBSheet(sheetObj, document.form, SEARCH04);
				if (retValidate < 1) {
					sheetObj.SetCellValue(Row, Col, "", 0);
					sheetObj.SelectCell(Row, Col);
				}
			}
			return false;
		} else if (colName == "s_por") {
			if (Value.length != 5) {
				ComShowMessage(ComGetMsg('PRD90060'));
				sheetObj.SetCellValue(Row, Col, "", 0);
				sheetObj.SelectCell(Row, Col);
				sheetObj.SetCellValue(Row, "s_por_node", "", 0);
			} else {
				doActionIBSheet(sheetObj, document.form, SEARCH02);
				if (retValidate < 1) {
					sheetObj.SetCellValue(Row, Col, "", 0);
					sheetObj.SelectCell(Row, Col);
				}
				sheetObj.SetCellValue(Row, "s_por_node", "", 0);
			}
			return false;
		} else if (colName == "s_por_node") {
			validateData = sheetObj.GetCellValue(Row, "s_por") + validateData;
			if (Value.length != 2) {
				ComShowMessage(ComGetMsg('PRD90061'));
				sheetObj.SetCellValue(Row, Col, "", 0);
				sheetObj.SelectCell(Row, Col);
			} else {
				doActionIBSheet(sheetObj, document.form, SEARCH04);
				if (retValidate < 1) {
					sheetObj.SetCellValue(Row, Col, "", 0);
					sheetObj.SelectCell(Row, Col);
				}
			}
			return false;
		} else if (colName == "s_trunk_lane" || colName == "s_lane" || colName == "s_ts1_lane" || colName == "s_ts2_lane") {
			if (colName == "s_trunk_lane") {
				if (sheetObj.GetCellValue(Row, "s_trunk_lane") != "ALL") {
					doActionIBSheet(sheetObj, document.form, SEARCH07);
				}
			} else {
				doActionIBSheet(sheetObj, document.form, SEARCH07);
				if (retValidate < 1) {
					sheetObj.SetCellValue(Row, Col, "", 0);
					sheetObj.SelectCell(Row, Col);
				}
			}
			return false;
		} else if (colName == "cntr_tp_cd" || colName == "cntr_sz_cd") {
			if (!checkCntrTypeSize(sheetObj, Row)) {
				sheetObj.SetCellValue(Row, Col, "", 0);
			}
			return false;
		}
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	return true;
}

/**
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 */
function sheet4_OnValidation(sheetObj, Row, Col, Value) {
	switch(sheetObj.ColSaveName(Col)) {
		case "spcl_cgo_cntr_tp_cd" : {
			if(ComIsNull(Value)) {
				sheetObj.SelectCell(Row, "spcl_cgo_cntr_tp_cd");
				ComShowCodeMessage("COM130403", "Cargo Nature");
				sheetObj.ValidateFail(1);
			}
			break;
		}
		case "dir_cd" : {
			if(ComIsNull(Value)) {
				sheetObj.SelectCell(Row, "dir_cd");
				ComShowCodeMessage("COM130403", "DIR");
				sheetObj.ValidateFail(1);
			}
			break;
		}
	}
}
// Port
var portInd = '';
function selectPort(frm, pt) {
	portInd = pt;
	var param = '';
	if (pt == 'POR')
		param = '?loc_cd=' + frm.por.value;
	if (pt == 'POL')
		param = '?loc_cd=' + frm.pol.value;
	if (pt == 'POD')
		param = '?loc_cd=' + frm.pod.value;
	if (pt == 'DEL')
		param = '?loc_cd=' + frm.del.value;
	if (pt == 'TS')
		param = '?loc_cd=' + frm.tsport.value;
	ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 470, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1', true);
}
// Node
function selectLocation(pt) {
	portInd = pt;
	var param = '?loc_port_ind=1' + '&node_cd=' + document.form.loc.value;
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 810, 550, 'getCOM_ENS_061', '1,0,1,1,1,1,1,1,1,1,1,1', true);
}
// Trunk Lane
function selectLane() {
	var frm = document.form;
	var slan_cd_val = frm.tlane.value;
	var param = '?&lane_cd=' + slan_cd_val;
	ComOpenPopup('/opuscntr/COM_ENS_081.do' + param, 800, 400, 'getLane_1', "1,0,1,1,1,1,1,1,1,1,1,1", true);
}
function getCOM_ENS_061(rArray) {
	var cArray = rArray[0];
	if (portInd == 'LOC') {
		document.form.loc.value = cArray[3];
	}
	if (portInd == 'FROM') {
		document.form.from_nd.value = cArray[3];
	}
	if (portInd == 'TO') {
		document.form.to_nd.value = cArray[3];
	}
}
function getLane(rowArray, row, col) {
	var colArray = rowArray[0];
	var sheetObj = sheetObjects[beforetab];
	sheetObj.SetCellValue(row, col, colArray[3], 0);
}
function getLane_1(rowArray) {
	var colArray = rowArray[0];
	var frm = document.form;
	frm.tlane.value = colArray[3];
}
function changeSelection(r_index) {
	var formObj = document.form;
	var objs = document.all.item("tabLayer");
	objs[0].style.display = "none";
	objs[1].style.display = "none";
	objs[2].style.display = "none";
	objs[3].style.display = "none";
	objs[r_index].style.display = "inline";
	var area1 = false;
	var area2 = false;
	var area3 = false;
	var area4 = false;
	if (r_index == 0) { // Location/Node
		area1 = true;
		area2 = false;
		area3 = false;
		area4 = false;
		resizeSheet(sheetObjects[0], 80);
	} else if (r_index == 1) { // Link
		area1 = false;
		area2 = true;
		area3 = false;
		area4 = false;
		resizeSheet(sheetObjects[1], 80);
	} else if (r_index == 2) { // Route
		area1 = false;
		area2 = false;
		area3 = true;
		area4 = false;
		resizeSheet(sheetObjects[2], 80);
	} else if (r_index == 3) { // Hub
		area1 = false;
		area2 = false;
		area3 = false;
		area4 = true;
		resizeSheet(sheetObjects[3], 80);
	}
	if (r_index != beforetab) {
		formObj.loc.value = '';
		formObj.from_nd.value = '';
		formObj.to_nd.value = '';
		formObj.tlane.value = '';
		formObj.pol.value = '';
		formObj.tsport.value = '';
		formObj.pod.value = '';
		formObj.del.value = '';
		formObj.point_code[0].checked = true;
		formObj.s_dir_cd.value = '0';
		formObj.svc.value = 'A';
	}
	ComEnableObjectPrd(formObj.loc, area1);
	ComEnableObjectPrd(formObj.btn_node_cd, area1);
	ComEnableObjectPrd(formObj.point_code[0], area1);
	ComEnableObjectPrd(formObj.point_code[1], area1);
	ComEnableObjectPrd(formObj.point_code[2], area1);
	ComEnableObjectPrd(formObj.point_code[3], area1);
	ComEnableObjectPrd(formObj.point_code[4], area1);
	ComEnableObjectPrd(formObj.point_code[5], area1);
	ComEnableObjectPrd(formObj.from_nd, area2);
	ComEnableObjectPrd(formObj.btn_from_cd, area2);
	ComEnableObjectPrd(formObj.to_nd, area2);
	ComEnableObjectPrd(formObj.btn_to_cd, area2);
	ComEnableObjectPrd(formObj.tlane, area3);
	ComEnableObjectPrd(formObj.btn_tnk_lane_cd, area3);
	ComEnableObjectPrd(formObj.pol, area3);
	ComEnableObjectPrd(formObj.btn_pol_port_cd, area3);
	ComEnableObjectPrd(formObj.tsport, area3);
	ComEnableObjectPrd(formObj.btn_ts_port_cd, area3);
	ComEnableObjectPrd(formObj.pod, area3);
	ComEnableObjectPrd(formObj.btn_pod_port_cd, area3);
	ComEnableObjectPrd(formObj.del, area3);
	ComEnableObjectPrd(formObj.btn_del_port_cd, area3);
	ComEnableObjectPrd(formObj.svc, area3);
	ComEnableObjectPrd(document.getElementById("s_dir_cd"), area3);
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();
	beforetab = r_index;
}
function ComEnableObjectPrd(obj, flag) {
	if (flag) {
		switch (obj.type) {
			case "select-one":
			case "text":
				obj.readOnly = !flag;
				obj.className = "input";
				break;
			case "textarea":
				obj.readOnly = !flag;
				obj.className = "textarea";
				break;
			default:
				obj.disabled = !flag;
				if (obj.tagName == "IMG") {
					obj.style.cursor = "hand";
					obj.style.filter = "";
				}
		}
	} else {
		switch (obj.type) {
			case "select-one":
			case "text":
				obj.readOnly = !flag;
				obj.className = "input2";
				break;
			case "textarea":
				obj.readOnly = !flag;
				obj.className = "textarea2";
				break;
			default:
				obj.disabled = !flag;
				if (obj.tagName == "IMG") {
					obj.style.cursor = "default";
					obj.style.filter = "progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
				}
		}
	}
}
function getNode(rowArray, row, col) {
	var sheetObj = sheetObjects[beforetab];
	var colArray = rowArray[0];
	sheetObj.SetCellValue(row, col, colArray[3], 0);
}
function getNode2(rowArray, row, col) {
	var sheetObj = sheetObjects[beforetab];
	var colArray = rowArray[0];
	if (sheetObj.ColSaveName(col) == "s_por") {
		sheetObj.SetCellValue(row, 's_por', colArray[3].substring(0, 5), 0);
		sheetObj.SetCellValue(row, 's_por_node', colArray[3].substring(5), 0);
	}
	if (sheetObj.ColSaveName(col) == "s_pol") {
		sheetObj.SetCellValue(row, 's_pol', colArray[3].substring(0, 5), 0);
		sheetObj.SetCellValue(row, 's_pol_node', colArray[3].substring(5), 0);
	}
	if (sheetObj.ColSaveName(col) == "s_pod") {
		sheetObj.SetCellValue(row, 's_pod', colArray[3].substring(0, 5), 0);
		sheetObj.SetCellValue(row, 's_pod_node', colArray[3].substring(5), 0);
	}
	if (sheetObj.ColSaveName(col) == "s_del") {
		sheetObj.SetCellValue(row, 's_del', colArray[3].substring(0, 5), 0);
		sheetObj.SetCellValue(row, 's_del_node', colArray[3].substring(5), 0);
	}
}

/**
 * Sheet
 * 
 * @param rowArray
 * @param row
 * @param col
 */
function sheet4SetLoc(rowArray, row, col) {
	var sheetObj = sheetObjects[beforetab];
	var colArray = rowArray[0];
	sheetObj.SetCellValue(row, col, colArray[3], 0);
}

function getLoc(rArray, row, col) {
	var sheetObj = sheetObjects[beforetab];
	var cArray = rArray[0];
	if (sheetObj.ColSaveName(col) == "s_por") {
		sheetObj.SetCellValue(row, 's_por', cArray[3], 0);
	}
	if (sheetObj.ColSaveName(col) == "s_ts1_port") {
		sheetObj.SetCellValue(row, 's_ts1_port', cArray[3], 0);
	}
	if (sheetObj.ColSaveName(col) == "s_ts2_port") {
		sheetObj.SetCellValue(row, 's_ts2_port', cArray[3], 0);
	}
	if (sheetObj.ColSaveName(col) == "s_del") {
		sheetObj.SetCellValue(row, 's_del', cArray[3], 0);
	}
}
function getCommodity(rowArray, row, col) {
	var sheetObj = sheetObjects[beforetab];
	var colArray = rowArray[0];
	sheetObj.SetCellValue(row, 's_commodity_code', colArray[2], 0);
	sheetObj.SetCellValue(row, 's_commodity_name', colArray[3], 0);
}
function getCOM_ENS_051(rArray) {
	var cArray = rArray[0];
	var frm = document.form;
	if (portInd == 'POR') {
		frm.por.value = cArray[3];
	}
	if (portInd == 'POL') {
		frm.pol.value = cArray[3];
	}
	if (portInd == 'POD') {
		frm.pod.value = cArray[3];
	}
	if (portInd == 'DEL') {
		frm.del.value = cArray[3];
	}
	if (portInd == 'TS') {
		frm.tsport.value = cArray[3];
	}
}
function changeDirection() {
	var frm = document.form;
	var val = frm.s_dir_cd[frm.s_dir_cd.selectedIndex].value;
	frm.dir_cd.value = (val == 0) ? "" : val;
}

function sheet3_OnClick(sheetObj, Row, Col, Value) {
	if (sheetObj.ColSaveName(Col) == "s_trunk_lane" && sheetObj.GetRowStatus(Row) == "I" && sheetObj.GetCellValue(Row, "s_node_code") == 'ALL') {
		sheetObj.SetCellValue(Row, "s_trunk_lane", "", 0);
	}
}

/**
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 */
function sheet4_OnChange(sheetObj, Row, Col, Value) {
	var colName = sheetObj.ColSaveName(Col);
	if (colName == "cnst_lane_cd") {
		if (Value != 'ALL') {
			validateData = Value;
			doActionIBSheet(sheetObj, document.form, SEARCH07);
			if (retValidate < 1) {
				sheetObj.SetCellValue(Row, Col, "", 0);
				sheetObj.SelectCell(Row, Col);
			}
		}
		return false;
	} else if (colName == "cntr_tp_cd" || colName == "cntr_sz_cd") {
		if (!checkCntrTypeSize(sheetObj, Row)) {
			sheetObj.SetCellValue(Row, Col, "", 0);
		}
		return false;
	} else if (colName == "nod_cd") {
		if (Value != 'ALL') {
			if (Value.length == 5) {
				validateData = Value;
				doActionIBSheet(sheetObj, document.form, SEARCH02);
				if (retValidate < 1) {
					sheetObj.SetCellValue(Row, Col, "", 0);
				}
			} else if (Value.length == 7) {
				validateData = Value;
				doActionIBSheet(sheetObj, document.form, SEARCH04);
				if (retValidate < 1) {
					sheetObj.SetCellValue(Row, Col, "", 0);
				}
			} else {
				sheetObj.SetCellValue(Row, Col, "", 0);
			}
		}
		return false;
	}
}

/**
 * 
 * @param sheetObj
 * @param row
 * @param col
 */
function sheet4_OnPopupClick(sheetObj, row, col) {
	var colName = sheetObj.ColSaveName(col);
	var colVal = sheetObj.GetCellValue(row, col);
	var param = "";
	switch (colName) {
		case "port_cd": {
			ComOpenPopup('/opuscntr/COM_ENS_051.do?loc_cd=' + colVal, 800, 500, 'sheet4SetLoc', '1,0,1,1,1,1,1,1,1,1,1,1', true, false, row, col, 0);
			break;
		}
		case "hub_loc_cd": {
			ComOpenPopup('/opuscntr/COM_ENS_051.do?loc_cd=' + colVal, 810, 550, 'sheet4SetLoc', "1,0,1,1,1,1,1,1,1,1,1,1", true, false, row, col, 0);
			break;
		}
		case "nod_cd": {
			param = "?loc_port_ind=1";
			if (!ComIsEmpty(colVal) && colVal.length > 5) {
				param += "&node_cd=" + colVal;
				param += "&loc_cd=" + colVal.substring(0, 5);
			} else {
				param += "&loc_cd=" + colVal;
			}
			ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 810, 550, 'sheet4SetLoc', '1,0,1,1,1,1,1,1,1,1,1,1', true, false, row, col, 0);
			break;
		}
		case "cnst_lane_cd": {
			ComOpenPopup('/opuscntr/COM_ENS_081.do?lane_cd=' + colVal, 800, 400, 'getLane', "1,0,1,1,1,1,1,1,1,1,1,1", true, false, row, col, 0);
			break;
		}
	}
}

/**
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 */
function sheet4_OnSaveEnd(sheetObj, Code, Msg) {
	if (Code == 0) {
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
	}
}

/**
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 */
function checkCntrTypeSize(sheetObj, Row) {
	var iCntrTpCd = sheetObj.GetCellValue(Row, 'cntr_tp_cd');
	var iCntrSzCd = sheetObj.GetCellValue(Row, 'cntr_sz_cd');
	if (!ComIsNull(iCntrTpCd) && !ComIsNull(iCntrSzCd)) {
		var sXml = sheetObjects[4].GetSearchData("ESD_PRD_0024GS.do", "f_cmd=" + SEARCH14 + "&cntr_tp_cd=" + iCntrTpCd + "&cntr_sz_cd=" + iCntrSzCd);
		sheetObjects[4].LoadSearchData(sXml, { Sync : 1 });
		if (sheetObjects[4].RowCount() == 0) {
			ComShowMessage(ComGetMsg('PRD00087'));
			return false;
		}
	}
	return true;
}