/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESD_PRD_0010.js
 *@FileTitle : Embargo Management
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0 
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESD_PRD_0010 : business script for ESD_PRD_0014
 */
// Common global variable
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var validateData = "";
var retValidate = 0;
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (srcName != null && !ComIsEmpty(srcName)) {
			var btnDis = eval("document.getElementById('" + srcName + "').disabled");
			if (btnDis)
				return;
		}
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
		case "btn_new":
			sheetObject.RemoveAll();
			formObject.reset();
			break;
		case "btn_save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;
		case "btng_rowadd":
			doActionIBSheet(sheetObject, formObject, IBINSERT);
			break;
		case "btng_rowcopy":
			doActionIBSheet(sheetObject, formObject, IBCOPYROW);
			break;
		case "btn_fromCnt":
			selectCountry('From');
			break;
		case "btn_toCnt":
			selectCountry('To');
			break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111'));
		} else {
			ComShowMessage(e);
		}
	}
}
var cntGb = '';
function selectCountry(cnt) {
	cntGb = cnt;
	var frm = document.form;
	var param = '?classId=' + "COM_ENS_051"
	var sheetObj = sheetObjects[0];
	if (cntGb == 'From') {
		param = param + '&cnt_cd=' + frm.i_from.value;
	} else if (cntGb == 'To') {
		param = param + '&cnt_cd=' + frm.i_to.value;
	} else if (cntGb == 'gFrom') {
		param = param + '&cnt_cd=' + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "fm_cnt_cd");
	} else if (cntGb == 'gTo') {
		param = param + '&cnt_cd=' + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "to_cnt_cd");
	}
	ComOpenPopup('/opuscntr/COM_ENS_0M1.do' + param, 770, 480, 'getCountry', "1,0,1,1,1,1,1,1,1,1,1,1", true);
}
function getCountry(rowArray) {
	var colArray = rowArray[0];
	var sheetObj = sheetObjects[0];
	if (cntGb == 'From') {
		document.all.i_from.value = colArray[3];
	} else if (cntGb == 'To') {
		document.all.i_to.value = colArray[3];
	} else if (cntGb == 'gFrom') {
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "fm_cnt_cd", colArray[3], 0);
	} else if (cntGb == 'gTo') {
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "to_cnt_cd", colArray[3], 0);
	}
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
	axon_event.addListener('keypress', 'PrdComKeyEnter', 'i_from', 'i_to');
	axon_event.addListenerForm('change', 'form_onChange', form);
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
	if (srcName == "i_from") {
		validateCountry(srcValue, 1)
	} else if (srcName == "i_to") {
		validateCountry(srcValue, 2)
	}
}

function prdComKeyDown() {
	var keyObj = window.event.keyCode;
	if (keyObj == 9) {
		inputChkUpper(window.event.srcElement, keyObj, 'SEARCH06');
	}
}

/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
	case 1:
		with (sheetObj) {
			var HeadTitle = "Del.|STS|No.|From|To|Creation DT|Update DT|User ID|Remark";
			SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 1 });
			var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
			var headers = [
				{ Text : HeadTitle, Align : "Center" }
			];
			InitHeaders(headers, info);
			var cols = [
					{ Type : "DelCheck", Hidden : 0, Width : 30, Align : "Center", ColMerge : 0, SaveName : "", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Status", Hidden : 0, Width : 30, Align : "Center", ColMerge : 0, SaveName : "ibflag", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Seq", Hidden : 0, Width : 30, Align : "Center", ColMerge : 0, SaveName : "", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "PopupEdit", Hidden : 0, Width : 120, Align : "Center", ColMerge : 0, SaveName : "fm_cnt_cd", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 2, AcceptKey : "E" },
					{ Type : "PopupEdit", Hidden : 0, Width : 120, Align : "Center", ColMerge : 0, SaveName : "to_cnt_cd", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 2, AcceptKey : "E" },
					{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "cre_dt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "upd_dt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "upd_usr_id", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 0, Width : 70, Align : "Left", ColMerge : 0, SaveName : "mbgo_rmk", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 }
			];

			InitColumns(cols);
			SetEditable(1);
			resizeSheet();
			SetColProperty(0, "fm_cnt_cd", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
			SetColProperty(0, "to_cnt_cd", { AcceptKeys : "E|N", InputCaseSensitive : 1 });
		}
		break;
	}
}

function resizeSheet() {
	ComResizeSheet(sheetObjects[0]);
}

/**
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	var uid;
	var sXml;
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH:
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCHLIST;
			sheetObj.DoSearch("ESD_PRD_0010GS.do", PrdFQString(formObj), { Sync : 2 });
		}
		break;
	case IBSAVE:
		ComOpenWait(true);
		if (sheetObj.RowCount() == 0) {
			ComShowCodeMessage("COM130503");
			ComOpenWait(false);
			return;
		}
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = MULTI;
			sheetObj.DoAllSave("ESD_PRD_0010GS.do", PrdFQString(formObj));
		}
		break;
	case IBINSERT:
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.DataInsert();
		}
		break;
	case IBCOPYROW:
		sheetObj.DataCopy();
		break;
	case IBDOWNEXCEL:
		sheetObj.Down2Excel({ DownCols : makeHiddenSkipCol(sheetObj), SheetDesign : 1, Merge : 1 });
		break;
	case SEARCH06:
		formObj.f_cmd.value = SEARCH06;
		uid = "ESD_PRD_0010";
		sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
		retValidate = ComGetEtcData(sXml, "rowCount");
		break;
	}
}

// handling popup open
function sheet1_OnPopupClick(sheetObj, row, col) {
	if (sheetObj.ColSaveName(col) == "fm_cnt_cd") {
		selectCountry('gFrom');
	}
	if (sheetObj.ColSaveName(col) == "to_cnt_cd") {
		selectCountry('gTo');
	}
}

function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var colName = sheetObj.ColSaveName(Col);
	var formObject = document.form;
	if (colName == "fm_cnt_cd" || colName == "to_cnt_cd") {
		validateData = Value;
		doActionIBSheet(sheetObj, formObject, SEARCH06);
		if (retValidate < 1) {
			sheetObj.SetCellValue(Row, Col, "", 0);
		}
	}
}

// validation for Location code
function validateCountry(loc, num) {
	if (num == 1) {
		document.form.i_from.value = loc.toUpperCase();
	}
	if (num == 2) {
		document.form.i_to.value = loc.toUpperCase();
	}
	validateData = loc.toUpperCase();
	doActionIBSheet(sheetObjects[0], document.form, SEARCH06);
	if (retValidate < 1) {
		if (num == 1) {
			document.form.i_from.value = "";
			document.form.i_from.focus();
		} else if (num == 2) {
			document.form.i_to.value = "";
			document.form.i_to.focus();
		}
	}
	return false;
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
	}
	return true;
}

function sheet1_OnSaveEnd(sheetObj, Code, ErrMsg) {
	ComOpenWait(false);
}