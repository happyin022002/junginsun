/* =========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_PRD_0037.js
 *@FileTitle  : Vessel Connect Time Management
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/22 
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName)) {
			return false;
		}
		var srcObj = ComGetEvent("nodeName");
		var keyObj = window.event.keyCode;
		switch (srcName) {
			case "btn_retrieve": {
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;
			}
			case "btn_new": {
				formObject.reset();
				sheetObject.RemoveAll();
				break;
			}
			case "btn_save": {
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
			}
			case "btng_rowadd": {
				doActionIBSheet(sheetObject, formObject, IBINSERT);
				break;
			}
			case "btng_rowcopy": {
				doActionIBSheet(sheetObject, formObject, IBCOPYROW);
				break;
			}
			case "btng_rowdel": {
				doActionIBSheet(sheetObject, formObject, IBDELETE);
				break;
			}
			case "btn_cnt": {
				funcComPopup("F", '', '', '', "dchg_cnt_cd");
				break;
			}
			case "btn_tml": {
				funcComPopup("F", '', '', '', "dchg_tml_cd");
				break;
			}
			case "btn_slan": {
				funcComPopup("F", '', '', '', "dchg_slan_cd");
				break;
			}
			case "btng_rowdel": {
				doActionIBSheet(sheetObject, formObject, IBDELETE);
				break;
			}
			case "btn_loadexcel": {
				doActionIBSheet(sheetObject, formObject, IBLOADEXCEL);
				break;
			}
			case "btn_downexcel": {
				doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
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
	for ( var i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	axon_event.addListenerForm('keypress', 'PrdComKeyEnter', document.form);
}

/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
		case 1: {
			with (sheetObj) {
				var HeadTitle = "|S|Case|T/S Discharge\nCountry|T/S Discharge\nPort|Discharge\nService|Discharge Bound|Load\nLane|Load Port|T/S Load\nCountry|Buffer (hr)|C.User|C.Date|U.User|U.Date|Remark";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [{ Text : HeadTitle, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [
							{ Type : "CheckBox",  	Hidden : 0, Width : 30,  Align : "Center", 	ColMerge : 0, SaveName : "ibcheck" },
							{ Type : "Status",   	Hidden : 0, Width : 30,  Align : "Center", 	ColMerge : 0, SaveName : "ibflag", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
							{ Type : "Combo",     	Hidden : 1, Width : 120, Align : "Center", 	ColMerge : 0, SaveName : "vsl_cnn_tp_cd",	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
							{ Type : "PopupEdit", 	Hidden : 0, Width : 100, Align : "Center", 	ColMerge : 0, SaveName : "dchg_cnt_cd", 	KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 2 },
							{ Type : "PopupEdit", 	Hidden : 0, Width : 100, Align : "Center", 	ColMerge : 0, SaveName : "dchg_tml_cd", 	KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 5 },
							{ Type : "PopupEdit", 	Hidden : 0, Width : 100, Align : "Center", 	ColMerge : 0, SaveName : "dchg_slan_cd", 	KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 3 },
							{ Type : "Combo",     	Hidden : 0, Width : 120, Align : "Center", 	ColMerge : 0, SaveName : "io_bnd_cd", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
							{ Type : "PopupEdit", 	Hidden : 0, Width : 80,  Align : "Center", 	ColMerge : 0, SaveName : "lod_slan_cd", 	KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 3 },
							{ Type : "PopupEdit", 	Hidden : 0, Width : 80,  Align : "Center", 	ColMerge : 0, SaveName : "lod_tml_cd", 		KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 5 },
							{ Type : "PopupEdit", 	Hidden : 0, Width : 80,  Align : "Center", 	ColMerge : 0, SaveName : "lod_cnt_cd", 		KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 2 },
							{ Type : "Int", 		Hidden : 0, Width : 80,  Align : "Right",  	ColMerge : 0, SaveName : "cnn_buf_hrs", 	KeyField : 0, CalcLogic : "", Format : "NullInteger",  PointCount : 1, UpdateEdit : 1, InsertEdit : 1, EditLen : 4 },
							{ Type : "Text", 		Hidden : 0, Width : 100, Align : "Center",  ColMerge : 0, SaveName : "cre_usr_id", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Date", 		Hidden : 0, Width : 120, Align : "Center",  ColMerge : 0, SaveName : "cre_dt", 			KeyField : 0, CalcLogic : "", Format : "YmdHms", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 		Hidden : 0, Width : 100, Align : "Center",  ColMerge : 0, SaveName : "upd_usr_id", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Date", 		Hidden : 0, Width : 120, Align : "Center",  ColMerge : 0, SaveName : "upd_dt", 			KeyField : 0, CalcLogic : "", Format : "YmdHms", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 		Hidden : 0, Width : 250, Align : "Left",	ColMerge : 0, SaveName : "vsl_cnn_rmk", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 }
					];
				InitColumns(cols);
				ComResizeSheet(sheetObj);
				SetColProperty(0, 'vsl_cnn_tp_cd',	{ ComboText : 'ETD to ETB|ETB to ETB', ComboCode : 'DB|BB'});
				SetColProperty(0, 'io_bnd_cd', 		{ ComboText : '|Inbound|Outbound', ComboCode : '|I|O' });
				SetColProperty(0, "dchg_cnt_cd", 	{ AcceptKeys : "E", InputCaseSensitive : 1 });
				SetColProperty(0, "dchg_tml_cd", 	{ AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "dchg_slan_cd", 	{ AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "lod_slan_cd", 	{ AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "lod_tml_cd", 	{ AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "lod_cnt_cd", 	{ AcceptKeys : "E", InputCaseSensitive : 1 });
				SetEditable(1);
			}
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
function sheet1_OnPopupClick(sheetObj, Row, Col) {
	funcComPopup("S", sheetObj, Row, Col, '')
}

/**
 * 
 * @param sheetObj
 * @param Code
 * @param Msg
 * @param StCode
 * @param StMsg
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {
	var formObj = document.form;
	if (errMsg != null && errMsg != '') {
		ComShowMessage(errMsg);
	} else {
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
		ComShowCodeMessage('COM132601');
	}
}

/**
 * 
 * @param SheetObj
 * @param Row
 * @param Col
 * @param Value
 */
function sheet1_OnEditValidation(SheetObj, Row, Col, Value) {
	if (SheetObj.ColSaveName(Col) == "cnn_buf_hrs") {
		Value = Value.replace("-", "");
		if (Value.length > 3) {
			SheetObj.ValidateFail(1);
		} else {
			SheetObj.ValidateFail(0);
		}
	}
}

/**
 * 
 * @param Type
 * @param sheetObj
 * @param Row
 * @param Col
 * @param AttrId
 */
function funcComPopup(Type, sheetObj, Row, Col, AttrId) {
	if (Type == 'S') {
		var ColNm = sheetObj.ColSaveName(Col);
		if (ColNm == "dchg_cnt_cd" || ColNm == "lod_cnt_cd") {
			ComOpenPopup('/opuscntr/COM_ENS_0M1.do', 770, 520, 'setGridFromPopup', "1,0,1,1,1,1,1", true, false, Row, Col);
		} else if (ColNm == "dchg_tml_cd" || ColNm == 'lod_tml_cd') {
			ComOpenPopup('/opuscntr/COM_ENS_051.do', 780, 530, 'setGridFromPopup', "1,0,1,1,1", true, false, Row, Col);
		} else if (ColNm == "dchg_slan_cd" || ColNm == 'lod_slan_cd') {
			ComOpenPopup('/opuscntr/COM_ENS_081.do', 1000, 400, 'setGridFromPopup', '1,0,1,1,1,1,1,1,1,1,1,1', true, false, Row, Col);
		}
	} else {
		if (AttrId == "dchg_cnt_cd") {
			ComOpenPopupWithTarget('/opuscntr/COM_ENS_0M1.do', 770, 520, 'cnt_cd:dchg_cnt_cd', "1,0,1,1,1,1,1", true, false);
		} else if (AttrId == "dchg_tml_cd") {
			ComOpenPopup('/opuscntr/COM_ENS_051.do', 780, 530, 'setFormFacility', "1,0,1,1,1", true, false);
		} else if (AttrId == "dchg_slan_cd") {
			ComOpenPopupWithTarget('/opuscntr/COM_ENS_081.do', 1000, 400, 'col1:dchg_slan_cd', '1,0,1,1,1,1,1,1,1,1,1,1', true, false);
		}
	}
}

function setFormFacility(rowArray) {
	var formObj = document.form;
	var colArray = rowArray[0];
	if (colArray != undefined) {
		formObj.dchg_tml_cd.value = colArray[3];
	}
}

function sheet1_OnChange(sheetObj, Row, Col, Value, OldValue, RaiseFlag) {
	var ColNm = sheetObj.ColSaveName(Col);
	if (ColNm == "dchg_cnt_cd" || ColNm == "lod_cnt_cd") {
		if (Value != '') {
			checkCountry(sheetObj, Row, Col, Value);
		}
	} else if (ColNm == "dchg_tml_cd" || ColNm == 'lod_tml_cd') {
		if (Value != '' && Value != "ALL") {
			checkTerminalCode(sheetObj, Row, Col, Value);
		}
	} else if (ColNm == "dchg_slan_cd" || ColNm == 'lod_slan_cd') {
		if (Value != '' && Value != "ALL") {
			checkLane(sheetObj, Row, Col, Value);
		}
	}
}

function SheetColumnControl(sheetObj, Row, ColNm, Value) {
	if (ColNm == "dchg_slan_cd") {
		if (Value != '' && Value != "ALL") {
			sheetObj.SetCellValue(Row, "dchg_tml_cd", 'ALL', 0);
		} else {
			sheetObj.SetCellValue(Row, "dchg_tml_cd", '', 0);
		}
	} else if (ColNm == "dchg_tml_cd") {
		if (Value != '' && Value != 'ALL') {
			sheetObj.SetCellValue(Row, "dchg_slan_cd", 'ALL', 0);
		} else {
			sheetObj.SetCellValue(Row, "dchg_slan_cd", '', 0);
		}
	}
}

/**
 * 
 * @param rowArray
 * @param row
 * @param col
 */
function setGridFromPopup(rowArray, Row, Col) {
	var ColNm = sheetObjects[0].ColSaveName(Col);
	var colArray = rowArray[0];
	sheetObjects[0].SetCellValue(Row, Col, colArray[3], 0);
	SheetColumnControl(sheetObjects[0], Row, ColNm, colArray[3]);
}

/**
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @returns {Boolean}
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH: {
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESD_PRD_0037GS.do", PrdFQString(formObj));
			break;
		}
		case IBSAVE: {
			if (!validate(sheetObj)) {
				return false;
			}
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESD_PRD_0037GS.do", { Param : PrdFQString(formObj), Quest : 0, Col : "ibflag" });
			break;
		}
		case IBDOWNEXCEL: {
			if (sheetObj.RowCount() < 1) {// no data
				ComShowCodeMessage("COM132501");
			} else {
				sheetObj.Down2Excel({ DownCols : makeHiddenSkipCol(sheetObj), SheetDesign : 1, Merge : 1 });
			}
			break;
		}
		case IBLOADEXCEL: {
			sheetObj.LoadExcel();
			break;
		}
		case IBINSERT: {
			sheetObj.DataInsert();
			break;
		}
		case IBDELETE: {
			var checkList = sheetObj.FindCheckedRow('ibcheck');
			var checkArray = checkList.split('|');
			for ( var i = checkArray.length; i >= 0; i--) {
				sheetObj.SetRowStatus(checkArray[i], "D");
				sheetObj.SetRowHidden(checkArray[i])
			}
			break;
		}
		case IBCOPYROW: {
			sheetObj.DataCopy();
			break;
		}
	}
}

/**
 * 
 * @param sheetObj
 * @returns {Boolean}
 */
function validate(sheetObj) {
	var sRow = sheetObj.FindStatusRow("I|U")
	var arrow = sRow.split(",")
	var len = arrow.length;
	for ( var i = 0; i < len; i++) {
		if (ComIsNull(sheetObj.GetCellValue(arrow[i], 'dchg_cnt_cd'))) {
			ComShowCodeMessage('PRD00083', 'T/S Discharge Country');
			return false;
		}
		if (ComIsNull(sheetObj.GetCellValue(arrow[i], 'dchg_tml_cd')) && ComIsNull(sheetObj.GetCellValue(arrow[i], 'dchg_slan_cd'))) {
			ComShowCodeMessage('COM12138', 'T/S Discharge Port', "Discharge Service");
			return false;
		}
		if (ComIsNull(sheetObj.GetCellValue(arrow[i], 'dchg_tml_cd'))) {
			sheetObj.SetCellValue(arrow[i], 'dchg_tml_cd', 'ALL', 0)
		}
		if (ComIsNull(sheetObj.GetCellValue(arrow[i], 'dchg_slan_cd'))) {
			sheetObj.SetCellValue(arrow[i], 'dchg_slan_cd', 'ALL', 0)
		}

		if (ComIsNull(sheetObj.GetCellValue(arrow[i], 'lod_slan_cd'))) {
			sheetObj.SetCellValue(arrow[i], 'lod_slan_cd', 'ALL', 0)
		}
		if (ComIsNull(sheetObj.GetCellValue(arrow[i], 'lod_tml_cd'))) {
			sheetObj.SetCellValue(arrow[i], 'lod_tml_cd', 'ALL', 0)
		}
		if (ComIsNull(sheetObj.GetCellValue(arrow[i], 'lod_cnt_cd'))) {
			sheetObj.SetCellValue(arrow[i], 'lod_cnt_cd', 'AL', 0)
		}
	}
	return true;
}

/**
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 */
function checkTerminalCode(sheetObj, Row, Col, Value) {
	if (ComIsNull(Value)) {
		return;
	}
	var formObj = document.form;
	if (Value.length == 5) {
		formObj.f_cmd.value = SEARCH;
		var queryString = FormQueryString(formObj) + "&node_cd=" + Value;
		var sXml = sheetObj.GetSearchData("COM_ENS_061GS.do", queryString);
		if (ComGetTotalRows(sXml) < 1) {
			sheetObj.SetCellValue(Row, Col, '', 0);
		}
	} else {
		sheetObj.SetCellValue(Row, Col, '', 0);
	}
}

/**
 * ESD_PRD_0024 참조
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 */
function checkCountry(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	formObj.f_cmd.value = SEARCH06;
	var sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "check_data=" + Value + "&" + PrdFQString(formObj));
	var retValidate = ComGetStrEtcData(sXml, "rowCount");
	if (retValidate == "" || retValidate < 1) {
		sheetObj.SetCellValue(Row, Col, '', 0);
	}
}

/**
 * ESD_PRD_0024 참조
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 */
function checkLane(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	formObj.f_cmd.value = SEARCH07;
	var sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "check_data=" + Value + "&" + PrdFQString(formObj));
	var retValidate = ComGetStrEtcData(sXml, "rowCount");
	if (retValidate == "" || retValidate < 1) {
		sheetObj.SetCellValue(Row, Col, '', 0);
	}
}

/**
 * 
 * @param cnt
 */
function selectCountry(cnt) {
	cntGb = cnt;
	var frm = document.form;
	var param = '?classId=' + "COM_ENS_051"
	if (cntGb == 'cnt') {
		param = param + '&cnt_cd=' + frm.country_code.value;
	}
	ComOpenPopup('/opuscntr/COM_ENS_0M1.do' + param, 800, 510, 'getCountry', "1,0,1,1,1,1,1,1,1,1,1,1", true);
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
		return false;
	}
}
