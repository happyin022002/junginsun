/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_PRD_0004.js
 *@FileTitle  : HubLocation Information Management
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/09
=========================================================*/
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
 * @class ESD_PRD_0004 : business script for ESD_PRD_0004
 */
/* Common global variable */
var sheetObjects = new Array();
var sheetCnt = 0;
var validateData = "";
var retValidate = 0;
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	var srcName = ComGetEvent("name");
	var param;
	var dispaly;
	var classId;
	var chkStr;
	var loc_cd_val;
	try {
		var srcObj = ComGetEvent().nodeName;
		var keyObj = ComGetEvent().keyCode;
		switch (srcName) {
		case "btn_retrieve":
			if (!checkInput())
				return false;
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
			if (sheetObject.RowCount() < 1) {// no data
				ComShowCodeMessage("COM132501");
			} else {
				doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
			}
			break;
		case "btn_loadexcel":
			doActionIBSheet(sheetObject, formObject, IBLOADEXCEL);
			break;
		case "btng_rowcopy":
			doActionIBSheet(sheetObject, formObject, IBCOPYROW);
			break;
		case "btng_rowadd":
			doActionIBSheet(sheetObject, formObject, IBINSERT);
			break;
		case "port_btn":
			var loc_port_ind_val = "";
			loc_cd_val = "";
			dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // com_ens_051_dispaly.value;
			classId = "COM_ENS_051";
			loc_port_ind_val = "1";
			loc_cd_val = formObject.in_port_cd.value;
			param = '?classId=' + classId + '&loc_port_ind=' + loc_port_ind_val + '&loc_cd=' + loc_cd_val;
			chkStr = dispaly.substring(0, 3)
			ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 550, 'getPort', dispaly, true);
			break;
		case "hub_btn":
			dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // com_ens_051_dispaly.value;
			classId = "COM_ENS_051";
			loc_cd_val = formObject.in_hub_loc_cd.value;
			param = '?classId=' + classId + '&loc_cd=' + loc_cd_val;
			chkStr = dispaly.substring(0, 3)
			ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 550, 'getHub', dispaly, true);
			break;
		case "loc_btn":
			dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // com_ens_051_dispaly.value;
			classId = "COM_ENS_051";
			loc_cd_val = formObject.in_loc_cd.value;
			param = '?classId=' + classId + '&loc_cd=' + loc_cd_val;
			chkStr = dispaly.substring(0, 3)
			ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 550, 'getLoc', dispaly, true);
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(ComGetMsg('PRD90054'));
		} else {
			ComShowMessage(e);
		}
	}
}
/*
 * check input condition for retrieve
 */
function checkInput() {
	var formObject = document.form;
	var portCd = formObject.in_port_cd.value;
	var hubCd = formObject.in_hub_loc_cd.value;
	var locCd = formObject.in_loc_cd.value;
	if (portCd.length == 0 && hubCd.length == 0 && locCd.length == 0) {
		ComShowMessage(ComGetMsg('PRD90119', 'one', '5'));
		return false;
	}
	if (portCd.length > 0) {
		if (portCd.length != 5) {
			ComShowMessage(ComGetMsg('PRD90119', 'one', '5'));
			formObject.in_port_cd.focus();
			return false;
		}
	}
	if (hubCd.length > 0) {
		if (hubCd.length != 5) {
			ComShowMessage(ComGetMsg('PRD90119', 'one', '5'));
			formObject.in_hub_loc_cd.focus();
			return false;
		}
	}
	if (locCd.length > 0) {
		if (locCd.length != 5) {
			ComShowMessage(ComGetMsg('PRD90119', 'one', '5'));
			formObject.in_loc_cd.focus();
			return false;
		}
	}
	return true;
}
/*
 * check whether add button is disable
 */
function checkAdd(sheetObject) {
	if (sheetObject.RowCount() > 0) {
		ComShowMessage(ComGetMsg('PRD90062'));
		return false;
	}
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
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	var form = document.form;
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListener('keypress', 'PrdComKeyEnter', 'in_port_cd', 'in_hub_loc_cd', 'in_loc_cd');
	axon_event.addListenerForm('change', 'form_onChange', form);
}
/**
 * handling tab event
 * 
 * @return
 */
function prdComKeyDown() {
	var keyObj = window.event.keyCode;
	if (keyObj == 9 || keyObj == 0) {
		var srcName = ComGetEvent("name");
		if (srcName == "in_port_cd") {
			inputChkUpper(document.form.in_port_cd, keyObj, 'SEARCH01');
		} else if (srcName == "in_hub_loc_cd") {
			inputChkUpper(document.form.in_hub_loc_cd, keyObj, 'SEARCH02');
		} else if (srcName == "in_loc_cd") {
			inputChkUpper(document.form.in_loc_cd, keyObj, 'SEARCH02');
		}
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
	if (srcName == "in_port_cd") {
		inputChkUpper(document.form.in_port_cd, 0, 'SEARCH01');
	} else if (srcName == "in_hub_loc_cd") {
		inputChkUpper(document.form.in_hub_loc_cd, 0, 'SEARCH02');
	} else if (srcName == "in_loc_cd") {
		inputChkUpper(document.form.in_loc_cd, 0, 'SEARCH02');
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
			var HeadTitle1 = "Del.|STS|SEQ|Port|Hub Location|Location|Mode|Office|Creation DT|Update DT|User ID|Remarks";
			var prefix = "sheet1_";

			SetConfig({ SearchMode : 2, MergeSheet : 0, Page : 20, FrozenCol : 0, DataRowMerge : 1 });

			var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
			var headers = [
				{ Text : HeadTitle1, Align : "Center" }
			];
			InitHeaders(headers, info);

			var cols = [
					{ Type : "DelCheck", 	Hidden : 0, Width : 30, Align : "Center", ColMerge : 0, SaveName : "", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Status", 		Hidden : 0, Width : 30, Align : "Center", ColMerge : 0, SaveName : "ibflag", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
					{ Type : "Seq", 		Hidden : 0, Width : 40, Align : "Center", ColMerge : 0, SaveName : "", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "PopupEdit", 	Hidden : 0, Width : 60, Align : "Center", ColMerge : 0, SaveName : "port_cd", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 5 },
					{ Type : "PopupEdit", 	Hidden : 0, Width : 90, Align : "Center", ColMerge : 0, SaveName : "hub_loc_cd", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 5 },
					{ Type : "PopupEdit", 	Hidden : 0, Width : 70, Align : "Center", ColMerge : 0, SaveName : "loc_cd", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 5 },
					{ Type : "Text", 		Hidden : 1, Width : 70, Align : "Center", ColMerge : 0, SaveName : "trsp_mod_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", 		Hidden : 0, Width : 100, Align : "Center", ColMerge : 0, SaveName : "cre_ofc_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Date", 		Hidden : 0, Width : 100, Align : "Center", ColMerge : 0, SaveName : "cre_dt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Date", 		Hidden : 0, Width : 100, Align : "Center", ColMerge : 0, SaveName : "upd_dt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", 		Hidden : 0, Width : 100, Align : "Center", ColMerge : 0, SaveName : "cre_usr_id", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", 		Hidden : 0, Width : 100, Align : "Center", ColMerge : 0, SaveName : "hub_loc_mtch_rmk", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 }
			];

			InitColumns(cols);
			SetEditable(1);
			SetColProperty(0, "port_cd", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
			SetColProperty(0, "hub_loc_cd", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
			SetColProperty(0, "loc_cd", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
			resizeSheet();
		}
		break;
	}
}

function resizeSheet() {
	ComResizeSheet(sheetObjects[0]);
}

// handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	var uid;
	var sXml;
	switch (sAction) {
	case IBSEARCH:
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("ESD_PRD_0004GS.do", PrdFQString(formObj), { Sync : 2 });
		break;
	case IBSAVE:
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESD_PRD_0004GS.do", PrdFQString(formObj));	
		}
		break;
	case IBINSERT:
		if (validateForm(sheetObj, formObj, sAction)) {
			var Row = sheetObj.DataInsert();
		}
		break;
	case IBCOPYROW:
		sheetObj.DataCopy();
		break;
	case IBDOWNEXCEL:
		sheetObj.Down2Excel({ DownCols : makeHiddenSkipCol(sheetObj), SheetDesign : 1, Merge : 1 });
		break;
	case IBLOADEXCEL:
		sheetObj.LoadExcel();
		break;
	case SEARCH01:
		formObj.f_cmd.value = SEARCH01;
		uid = "ESD_PRD_0004";
		sXml = sheetObj.GetSearchData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
		retValidate = ComGetEtcData(sXml, "rowCount");
		ComShowMessage(ComResultMessage(sXml));
		break;
	case SEARCH02:
		formObj.f_cmd.value = SEARCH02;
		uid = "ESD_PRD_0004";
		sXml = sheetObj.GetSearchData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
		retValidate = ComGetEtcData(sXml, "rowCount");
		ComShowMessage(ComResultMessage(sXml));
		break;
	}
}

/**
 * Sheet OnLoadExcel Event
 * @param sheetObj
 * @param result
 * @param code
 * @param msg
 */
function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
	if(isExceedMaxRow(msg)) return;
}

// handling popup open
function sheet1_OnPopupClick(sheetObj, row, col) {
	var param = '?loc_cd=' + sheetObj.GetCellValue(row, col);
	ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 500, 'getLocGrid', '1,0,1,1,1,1,1,1,1,1,1,1', true, false, row, col);
}
function getLocGrid(rowArray, row, col) {
	var sheetObj = sheetObjects[0];
	var colArray = rowArray[0];
	if (sheetObj.ColSaveName(col) == "port_cd") {
		sheetObj.SetCellValue(row, "port_cd", colArray[3]);
	} else if (sheetObj.ColSaveName(col) == "hub_loc_cd") {
		sheetObj.SetCellValue(row, "hub_loc_cd", colArray[3], 0);
	} else if (sheetObj.ColSaveName(col) == "loc_cd") {
		sheetObj.SetCellValue(row, "loc_cd", colArray[3], 0);
	}
}
function getCOM_ENS_051_1(rowArray) {
	var colArray = rowArray[0];
	document.all.in_port_cd.value = colArray[3];
}
function getPort(rowArray) {
	var colArray = rowArray[0];
	document.all.in_port_cd.value = colArray[3];
}
function getHub(rowArray) {
	var colArray = rowArray[0];
	document.all.in_hub_loc_cd.value = colArray[3];
}
function getLoc(rowArray) {
	var colArray = rowArray[0];
	document.all.in_loc_cd.value = colArray[3];
}
// checking validation of port code
function validatePort(port) {
	if (port.length < 1)
		return false;
	validateData = port.toUpperCase();
	ComShowMessage("port:" + port + " up:" + validateData);
	doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
	if (retValidate < 1 || retValidate == "") {
		document.form.in_port_cd.focus();
	} else {
		document.form.in_hub_loc_cd.focus();
	}
	return false;
}
function validatePort2(port) {
	if (port.length < 1)
		return false;
	validateData = port.toUpperCase();
	doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
	if (retValidate < 1) {
		document.form.in_port_cd.focus();
	} else {
		document.form.in_hub_loc_cd.focus();
	}
	return false;
}
// checking validation of port code
function validateLocation(loc, num) {
	if (loc.length < 1 && num == 1) {
		document.form.in_loc_cd.focus();
		return;
	} else if (loc.length < 1 && num == 2)
		return;
	validateData = loc.toUpperCase();
	if (num == 1) {
		document.form.in_hub_loc_cd.value = loc.toUpperCase();
	}
	if (num == 2) {
		document.form.in_loc_cd.value = loc.toUpperCase();
	}
	doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
	if (retValidate < 1) {
		if (num == 1) {
			document.form.in_hub_loc_cd.focus();
		} else if (num == 2) {
			document.form.in_loc_cd.focus();
		}
	} else {
		if (num == 1) {
			document.form.in_loc_cd.focus();
		}
	}
}
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	validateData = Value;
	if (sheetObj.ColSaveName(Col) == "port_cd") {
		doActionIBSheet(sheetObj, document.form, SEARCH01);
	} else if (sheetObj.ColSaveName(Col) == "hub_loc_cd") {
		doActionIBSheet(sheetObj, document.form, SEARCH02);
	} else if (sheetObj.ColSaveName(Col) == "loc_cd") {
		doActionIBSheet(sheetObj, document.form, SEARCH02);
	}
	if (retValidate < 1 && (sheetObj.ColSaveName(Col) == "port_cd" || sheetObj.ColSaveName(Col) == "hub_loc_cd" || sheetObj.ColSaveName(Col) == "loc_cd")) {
		sheetObj.SetCellValue(Row, sheetObj.ColSaveName(Col), "", 0);
		sheetObj.SelectCell(Row, Col);
		return false;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	return true;
}
