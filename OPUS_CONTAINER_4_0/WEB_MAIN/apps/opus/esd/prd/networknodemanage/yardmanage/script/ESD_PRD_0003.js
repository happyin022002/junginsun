/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESD_PRD_0003
 *@FileTitle : ESD_PRD_0003
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
 * @class ESD_PRD_0003 : business script for ESD_PRD_0003
 */
// Common global variable
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var docObjects = new Array();
var nodeCd = "";
var retValidate = 0;
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject1 = sheetObjects[0];
	var formObject = document.form;
	var param;
	try {
		var srcName = ComGetEvent("name");
		var srcObj = ComGetEvent("nodeName");
		var keyObj = ComGetEvent("keyCode");
		switch (srcName) {
		case "btn_new":
			sheetObject1.RemoveAll();
			formObject.reset();
			break;
		case "btn_retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;
		case "loc_btn":
			param = '?classId=' + "COM_ENS_0051" + '&loc_cd=' + formObject.location_code.value;
			ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 550, 'getLoc', "1,0,1,1,1,1,1,1,1,1,1,1", true);
			break;
		case "node_btn":
			param = '?classId=' + "COM_ENS_0061" + '&node_cd=' + formObject.node_code.value;
			ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 800, 550, 'getNode', "1,0,1,1,1,1,1,1,1,1,1,1", true);
			break;
		case "btn_cnt":
			selectCountry('cnt');
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			alert(ComGetMsg('COM12111'));
		} else {
			ComShowMessage(e);
		}
	}
}
function getLoc(rowArray) {
	var colArray = rowArray[0];
	document.all.location_code.value = colArray[3];
}
function getNode(rowArray) {
	var colArray = rowArray[0];
	document.all.node_code.value = colArray[3];
}
function prdComKeyEnter() {
	var keyObj = window.event.keyCode;
	if (keyObj == 13) {
		ComKeyEnter('search');
	}
}
function prdComKeyDown() {
	var keyObj = window.event.keyCode;
	if (keyObj == 9) {
		inputChkUpper(document.form.location_code, keyObj, 'SEARCH02');
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
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListener('keypress', 'prdComKeyEnter', 'country_code', 'location_code', 'node_code');
	axon_event.addListener('keydown', 'prdComKeyDown', 'location_code');
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
	if (srcName == "location_code") {
		inputChkUpper(document.form.location_code, 0, 'SEARCH02');
	}
}

/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	case "sheet1":
		with (sheetObj) {
			var HeadTitle1 = "No.|Yard Code|Yard Name";
			var prefix = "sheet1_";

			SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 1 });

			var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
			var headers = [
				{ Text : HeadTitle1, Align : "Center" }
			];
			InitHeaders(headers, info);

			var cols = [
					{ Type : "Seq", Hidden : 0, Width : 60, Align : "Center", ColMerge : 1, SaveName : "" },
					{ Type : "Text", Hidden : 0, Width : 200, Align : "Center", ColMerge : 1, SaveName : prefix + "yard_code", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
					{ Type : "Text", Hidden : 0, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "yard_name", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "address", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "pic", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "tel", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "fax", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "email", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "com_code1", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "com_name1", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "com_code2", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "com_name2", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "com_code3", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "com_name3", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "com_code4", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "com_name4", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "com_code5", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "com_name5", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "com_code6", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "com_name6", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "com_code7", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "com_name7", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "com_code8", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "com_name8", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "com_code9", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "com_name9", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "com_code10", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", Hidden : 1, Width : 300, Align : "Left", ColMerge : 1, SaveName : prefix + "com_name10", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 }
			];
			InitColumns(cols);

			SetEditable(1);
			SetSheetHeight(140);
		}

		break;
	}
}
// handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH:
		if (validateForm(sheetObj, formObj, sAction))
			clear_form();
		if (sheetObj.id == "sheet1")
			formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("ESD_PRD_0003GS.do", PrdFQString(formObj) + "&" + ComGetPrefixParam("sheet1_"), { Sync : 2 });
		break;
	case SEARCH02:
		formObj.f_cmd.value = SEARCH02;
		uid = "ESD_PRD_0003";
		sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
		retValidate = ComGetEtcData(sXml, "rowCount");
		break;
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
function sheet1_OnDblClick(sheetObj, row, col, value) {
	var prefix = "sheet1_";
	document.form.yard_code.value = sheetObj.GetCellValue(row, prefix + "yard_code");
	document.form.yard_name.value = sheetObj.GetCellValue(row, prefix + "yard_name");
	document.form.address.value = sheetObj.GetCellValue(row, prefix + "address");
	document.form.pic.value = sheetObj.GetCellValue(row, prefix + "pic");
	document.form.tel.value = sheetObj.GetCellValue(row, prefix + "tel");
	document.form.fax.value = sheetObj.GetCellValue(row, prefix + "fax");
	document.form.e_mail.value = sheetObj.GetCellValue(row, prefix + "email");
	document.form.com_code1.value = sheetObj.GetCellValue(row, prefix + "com_code1");
	document.form.com_name1.value = sheetObj.GetCellValue(row, prefix + "com_name1");
	document.form.com_code2.value = sheetObj.GetCellValue(row, prefix + "com_code2");
	document.form.com_name2.value = sheetObj.GetCellValue(row, prefix + "com_name2");
	document.form.com_code3.value = sheetObj.GetCellValue(row, prefix + "com_code3");
	document.form.com_name3.value = sheetObj.GetCellValue(row, prefix + "com_name3");
	document.form.com_code4.value = sheetObj.GetCellValue(row, prefix + "com_code4");
	document.form.com_name4.value = sheetObj.GetCellValue(row, prefix + "com_name4");
	document.form.com_code5.value = sheetObj.GetCellValue(row, prefix + "com_code5");
	document.form.com_name5.value = sheetObj.GetCellValue(row, prefix + "com_name5");
	document.form.com_code6.value = sheetObj.GetCellValue(row, prefix + "com_code6");
	document.form.com_name6.value = sheetObj.GetCellValue(row, prefix + "com_name6");
	document.form.com_code7.value = sheetObj.GetCellValue(row, prefix + "com_code7");
	document.form.com_name7.value = sheetObj.GetCellValue(row, prefix + "com_name7");
	document.form.com_code8.value = sheetObj.GetCellValue(row, prefix + "com_code8");
	document.form.com_name8.value = sheetObj.GetCellValue(row, prefix + "com_name8");
	document.form.com_code9.value = sheetObj.GetCellValue(row, prefix + "com_code9");
	document.form.com_name9.value = sheetObj.GetCellValue(row, prefix + "com_name9");
	document.form.com_code10.value = sheetObj.GetCellValue(row, prefix + "com_code10");
	document.form.com_name10.value = sheetObj.GetCellValue(row, prefix + "com_name10");
}
function selectCountry(cnt) {
	cntGb = cnt;
	var frm = document.form;
	var param = '?classId=' + "COM_ENS_0051"
	if (cntGb == 'cnt') {
		param = param + '&cnt_cd=' + frm.country_code.value;
	}
	ComOpenPopup('/opuscntr/COM_ENS_0M1.do' + param, 800, 520, 'getCountry', "1,0,1,1,1,1,1,1,1,1,1,1", true);
}
function getCountry(rowArray) {
	var colArray = rowArray[0];
	var frm = document.form;
	if (cntGb == 'cnt') {
		frm.country_code.value = colArray[3];
	}
}
function clear_form() {
	document.form.yard_code.value = '';
	document.form.yard_name.value = '';
	document.form.address.value = '';
	document.form.pic.value = '';
	document.form.tel.value = '';
	document.form.fax.value = '';
	document.form.e_mail.value = '';
	document.form.com_code1.value = '';
	document.form.com_name1.value = '';
	document.form.com_code2.value = '';
	document.form.com_name2.value = '';
	document.form.com_code3.value = '';
	document.form.com_name3.value = '';
	document.form.com_code4.value = '';
	document.form.com_name4.value = '';
	document.form.com_code5.value = '';
	document.form.com_name5.value = '';
	document.form.com_code6.value = '';
	document.form.com_name6.value = '';
	document.form.com_code7.value = '';
	document.form.com_name7.value = '';
	document.form.com_code8.value = '';
	document.form.com_name8.value = '';
	document.form.com_code9.value = '';
	document.form.com_name9.value = '';
	document.form.com_code10.value = '';
	document.form.com_name10.value = '';
}
