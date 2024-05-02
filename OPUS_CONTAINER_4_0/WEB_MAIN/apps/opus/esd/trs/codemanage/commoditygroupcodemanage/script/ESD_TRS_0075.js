/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0075
 *@FileTitle  : Commodity Group Code Management
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/07/08
=========================================================*/

/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc Code ------------------*/
/**
 * @fileoverview For example) Booking service for creating scripts to use on the screen is defined.
 * @author OPUS
 */
/**
 * @extends
 * @class ESD_TRS_0075 : business script for ESD_TRS_0075
 */
/*------------------From here the common JavaScript function is defined.     ------------------*/
// Common global variable
var sheetObjects = new Array();
var sheetCnt = 0;
// Click the button to define an event handler that receives and processes events */
document.onclick = processButtonClick;
// Button to process certain filename, separated on a quarterly event handler to handle */
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	var sheetObject3 = sheetObjects[3];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_retrieve1":
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;
			case "btn_delete1":
				doActionIBSheet(sheetObject, formObject, IBDELETE);
				break;
			case "btn_retrieve2":
				doActionIBSheet3(sheetObject2, formObject, IBSEARCH);
				break;
			case "btng_rowadd":
				doActionIBSheet(sheetObject, formObject, IBINSERT);
				break;
			case "btng_save1":
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
			// The total storage
			case "btng_save2":
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				doActionIBSheet3(sheetObject3, formObject, IBSAVE);
				break;
			case "btng_apply":
				doActionIBSheet3(sheetObject2, formObject, IBINSERT);
				break;
			case "btng_update":
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
			case "btng_update2":
				doActionIBSheet1(sheetObject1, formObject, IBSAVE);
				break;
			case "btn_reset":
				fn_reset();
				break;
			case "btn_reset1":
				fn_reset_01();
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			errMsg = ComGetMsg("TRS90392");
			ComShowMessage(errMsg);
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
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
}
/**
 * initControl
 */
function initControl() {
	axon_event.addListenerFormat('blur', 'obj_blur', form);
}
/**
 * Validation of HTML Control will check in the onblur event. <br>
 */
function obj_blur() {
	return ComChkObjValid(ComGetEvent());
}
/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
		case 1: {
			with (sheetObj) {
				var HeadTitle = "STS||Service Provider|Service Provider|Commodity Group|Commodity Group|Status|Save";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 0 };
				var headers = [{ Text : HeadTitle, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "Status", Hidden : 1, Width : 30, Align : "Center", ColMerge : 0, SaveName : "ibflag", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 0 },
						{ Type : "Radio", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "radio", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 0 },
						{ Type : "Text", Hidden : 0, Width : 60, Align : "Center", ColMerge : 0, SaveName : "vndr_seq", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 6 },
						{ Type : "Popup", Hidden : 0, Width : 145, Align : "Left", ColMerge : 0, SaveName : "vndr_nm", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 100 },
						{ Type : "Text", Hidden : 0, Width : 40, Align : "Center", ColMerge : 0, SaveName : "trsp_grp_cmdt_cd", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 4 },
						{ Type : "Text", Hidden : 0, Width : 130, Align : "Left", ColMerge : 0, SaveName : "trsp_cmdt_grp_nm", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 100 },
						{ Type : "Combo", Hidden : 0, Width : 20, Align : "Center", ColMerge : 0, SaveName : "delt_flg", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 2 },
						{ Type : "Text", Hidden : 1, Width : 10, Align : "Left", ColMerge : 0, SaveName : "save", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 100 },
						{ Type : "Text", Hidden : 1, Width : 10, Align : "Left", ColMerge : 0, SaveName : "update", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 100 },
						{ Type : "Text", Hidden : 1, Width : 10, Align : "Left", ColMerge : 0, SaveName : "dupl", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 100 }
				];
				InitColumns(cols);
				SetEditable(1);
				SetSheetHeight(180);
				var delFlag_cdText = "LIVE|DEL";
				var delFlag_cdCode = "N|Y";
				SetColProperty('delt_flg', { ComboText : "|" + delFlag_cdText, ComboCode : "|" + delFlag_cdCode });
				SetColProperty("trsp_grp_cmdt_cd", { AcceptKeys : "E", InputCaseSensitive : 1 });
			}
			break;
		}
		case 2:{
			with (sheetObj) {
				var HeadTitle = "Del.|STS|Commodity|Commodity|Created Date|User ID|VNDR SEQ|Trsp Grp CMDT Cd";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
				var headers = [{ Text : HeadTitle, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "CheckBox", Hidden : 0, Width : 30, Align : "Center", ColMerge : 0, SaveName : "part" }, { Type : "Status", Hidden : 1, Width : 30, Align : "Center", ColMerge : 0, SaveName : "ibflag" },
						{ Type : "Text", Hidden : 0, Width : 50, Align : "Center", ColMerge : 0, SaveName : "cmdt_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Left", ColMerge : 0, SaveName : "cmdt_nm", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Date", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "cre_dt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 60, Align : "Center", ColMerge : 0, SaveName : "cre_usr_id", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 60, Align : "Center", ColMerge : 0, SaveName : "vndr_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 60, Align : "Center", ColMerge : 0, SaveName : "trsp_grp_cmdt_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 60, Align : "Left", ColMerge : 0, SaveName : "deleteval", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 100 }
				];
				InitColumns(cols);
				SetEditable(1);
				resizeSheet(sheetObj);
			}
			break;
		}
		case 3:{
			with (sheetObj) {
				var HeadTitle = " |Rep. Commodity|Rep. Commodity|Commodity|Commodity";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [ { Text : HeadTitle, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "CheckBox", Hidden : 0, Width : 30, Align : "Center", ColMerge : 0, SaveName : "check" },
						{ Type : "Text", Hidden : 0, Width : 50, Align : "Center", ColMerge : 0, SaveName : "rep_cmdt_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 4, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Left", ColMerge : 0, SaveName : "rep_cmdt_nm", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 50, Align : "Center", ColMerge : 0, SaveName : "cmdt_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 6, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 60, Align : "Left", ColMerge : 0, SaveName : "cmdt_nm", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }
				];
				InitColumns(cols);
				SetEditable(1);
				resizeSheet(sheetObj);
			}
			break;
		}
		case 4: {
			with (sheetObj) {
				var HeadTitle = "Del.|STS|Commodity|Commodity|Created Date|User ID|VNDR SEQ|Trsp Grp CMDT Dd";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
				var headers = [{ Text : HeadTitle, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "CheckBox", Hidden : 0, Width : 30, Align : "Center", ColMerge : 0, SaveName : "" }, { Type : "Status", Hidden : 0, Width : 30, Align : "Center", ColMerge : 0, SaveName : "ibflag" },
						{ Type : "Text", Hidden : 0, Width : 50, Align : "Center", ColMerge : 0, SaveName : "cmdt_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Left", ColMerge : 0, SaveName : "cmdt_nm", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Date", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "cre_dt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 60, Align : "Center", ColMerge : 0, SaveName : "cre_usr_id", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 60, Align : "Center", ColMerge : 0, SaveName : "vndr_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 60, Align : "Center", ColMerge : 0, SaveName : "trsp_grp_cmdt_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 }
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
 * Sheet processing-related processes
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	var formObject = document.form;
	switch (sAction) {
		case IBSEARCH:
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESD_TRS_0075GS.do", TrsFrmQryString(formObj), { Sync : 2 });
				sheet2.RemoveAll();
			}
			break;
		case IBSAVE: {
			var sheet1_count = sheet1.RowCount();
			if (sheet1_count > 0) {
				formObj.f_cmd.value = MULTI;
				var savexml = sheetObj.DoSave("ESD_TRS_0075GS.do", { Param : TrsFrmQryString(formObj), Col : 'radio', Quest : "false", UrlEncode : "true", Sync : 1 });
			}
			break;
		}
		case IBINSERT:
			var Row = sheetObj.DataInsert();
			sheet1.SetCellValue(Row, "save", "N", 0);
			sheet1.SelectCell(Row, "vndr_seq");
			sheet1.SetCellValue(Row, "radio", "1", 0);
			document.form.cre_usr_id.value = document.form.cre_usr_id.value.toUpperCase();
			document.form.upd_usr_id.value = document.form.upd_usr_id.value.toUpperCase();
			break;
		case IBDELETE:
			sheet1_delete(sheetObj, formObj);
			break;
	}
}
/**
 * Sheet processing-related processes
 */
function doActionIBSheet1(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSAVE: {
			part_save();
			break;
		}
		case IBINSERT: {
			var Row = sheetObj.DataInsert();
			break;
		}
	}
}
/**
 * Sheet processing-related processes
 */
function doActionIBSheet2(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH:
			break;
		case IBSAVE:
			break;
		case IBINSERT:
			var Row = sheetObj.DataInsert();
			break;
	}
}
/**
 * Sheet processing-related processes
 */
function doActionIBSheet3(sheetObj, formObj, sAction) {
	var formObject = document.form;
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH: {
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch("ESD_TRS_0075_01GS.do", TrsFrmQryString(formObj), { Sync : 2 });
			}
			break;
		}
		case IBSAVE: {
			var sheet4_count = sheet4.RowCount();
			if (sheet4_count > 0) {
				formObj.f_cmd.value = MULTI01;
				var savexml = sheetObj.DoSave("ESD_TRS_0075GS.do", { Param : TrsFrmQryString(formObj), Col : 'ibflag', Quest : "false", UrlEncode : "true", Sync : 1 });
			}
			break;
		}
		case IBINSERT: {
			apply_send(sheetObj, formObj);
			break;
		}
	}
}
/**
 * Screen form validation process for processing the input values
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
	}
	return true;
}
/**
 * VNDR_check.
 */
function vndr_check(obj) {
	var formObject = document.form;
	var inputStr = obj.value;
	var value = obj.value;
	var charval = "Y";
	for ( var i = 0; i < inputStr.length; i++) {
		var oneChar = inputStr.charAt(i)
		if (oneChar != "") {
			if ((oneChar >= "0" && oneChar <= "9")) {
			} else {
				charval = "N";
				break;
			}
		} else {
			charval = "N";
			break;
		}
	}
	if (charval == "Y") {
		if (value != "") {
			formObject.f_cmd.value = SEARCH04;
			var queryString = "vndr_cd=" + value + "&" + TrsFrmQryString(formObject);
			var sXml = sheet1.GetSearchData("ESD_TRS_0075GS.do", queryString);
			var vendor = ComGetEtcData(sXml, 'CNT_CD');
			if (!check_vndr(vendor, obj)) {
				formObject.vndr_cd.value = "";
				formObject.vndr_nm.value = "";
				formObject.vndr_cd.focus();
			}
		} else {
			formObject.vndr_nm.value = "";
		}
	} else {
		formObject.vndr_cd.value = "";
		formObject.vndr_nm.value = "";
		formObject.vndr_cd.focus();
		var errMessage = ComGetMsg('COM12130', 'Number type', '', '');
		ComShowMessage(errMessage);
	}
}
/**
 * The presence of input Check VNDR
 * 
 */
function check_vndr(value, obj) {
	var formObject = document.form;
	if (value == 0) {
		var errMessage = ComGetMsg('COM12114', 'VNDR', '', '');
		ComShowMessage(errMessage);
		return false;
	} else {
		formObject.vndr_nm.value = value;
		return true;
	}
}
/**
 * VNDR Commoodity Group_check.
 */
function vndr_nm_check(obj) {
	var formObject = document.form;
	var value = obj.value;
	if (value != "") {
		formObject.f_cmd.value = SEARCH05;
		var queryString = "vndr_nm=" + value + "&" + TrsFrmQryString(formObject);

		var sXml = sheet1.GetSearchData("ESD_TRS_0075GS.do", queryString);
		var vendorNoList = ComGetEtcData(sXml, 'CNT_CD');
		var vendorNmList = ComGetEtcData(sXml, 'VNDR_NM');
		if (!check_vndr_commodity(vendorNoList, vendorNmList, obj)) {
			formObject.vndr_nm.value = "";
			formObject.vndr_cd.value = "";
			formObject.vndr_nm.focus();
		}
	}
}
/**
 * VNDR Commoodity Group existence check when entering
 */
function check_vndr_commodity(value, value1, obj) {
	var formObject = document.form;
	if (value == 0) {
		var errMessage = ComGetMsg('COM12114', 'VNDR Commoodity Group', '', '');
		ComShowMessage(errMessage);
		return false;
	} else {
		if (value != undefined)
			formObject.vndr_nm.value = value;
		return true;
	}
}
/**
 * rep_commodity_check.
 */
function rep_commodity_check(obj) {
	var formObject = document.form;
	var value = obj.value;
	if (value != "") {
		formObject.f_cmd.value = SEARCH02;
		var queryString = "rep_cmdt_cd=" + value + "&" + TrsFrmQryString(formObject);
		var sXml = sheet1.GetSearchData("ESD_TRS_0075_01GS.do", queryString);
		var vendor = ComGetEtcData(sXml, 'CNT_CD');
		if (!check_rep(vendor, obj)) {
			formObject.rep_cmdt_cd.value = "";
			formObject.rep_cmdt_cd.focus();
		}
	} else {
		formObject.rep_cmdt_nm.value = "";
	}
}
/**
 * Rep. Commodity check when entering the presence of
 */
function check_rep(value, obj) {
	var formObject = document.form;
	if (value == 0) {
		var errMessage = ComGetMsg('COM12114', 'Rep. Commodity', '', '');
		ComShowMessage(errMessage);
		return false;
	} else {
		formObject.rep_cmdt_nm.value = value;
		return true;
	}
}
/**
 * commodity_check.
 */
function commodity_check(obj) {
	var formObject = document.form;
	var value = obj.value;
	if (value != "") {
		formObject.f_cmd.value = SEARCH03;
		var queryString = "cmdt_cd=" + value + "&" + TrsFrmQryString(formObject);

		var sXml = sheet1.GetSearchData("ESD_TRS_0075_01GS.do", queryString);
		var vendor = ComGetEtcData(sXml, 'CNT_CD');
		if (!check_commodity(vendor, obj)) {
			formObject.cmdt_cd.value = "";
			formObject.cmdt_cd.focus();
		}
	} else {
		formObject.cmdt_nm.value = "";
	}
}
/**
 * Commodity check when entering the presence of
 */
function check_commodity(value, obj) {
	var formObject = document.form;
	if (value == 0) {
		var errMessage = ComGetMsg('COM12114', 'Commodity', '', '');
		ComShowMessage(errMessage);
		return false;
	} else {
		formObject.cmdt_nm.value = value;
		return true;
	}
}
/**
 * Select All to focus
 */
function fun_Focus(obj) {
	obj.select();
}
/**
 * Pop-up call rep_commodity
 */
function rep_OnPopupClick() {
	var formObject = document.form;
	var cmdt_cd_val = "";
	var rep_cmdt_cd_val = "";
	var cmdt_desc_val = "";
	var classId = "getCOM_ENS_rep";
	var xx1 = ""; // CONTI
	var xx2 = ""; // SUB CONTI
	var xx3 = ""; // COUNTRY
	var xx4 = ""; // STATE
	var xx5 = ""; // CONTROL OFFIC
	var xx6 = ""; // LOC CODE
	var xx7 = ""; // LOC NAME
	var xx8 = "";
	var xx9 = "";
	var param = "?conti_cd=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
	ComOpenPopup('/opuscntr/COM_ENS_011.do' + param, 772, 413, 'getCOM_ENS_rep', '0,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * rep_commodity pop-up call: If a single selection from a pop-up.
 */
function getCOM_ENS_rep(rowArray) {
	var formObject = document.form;
	for ( var i = 0; i < rowArray.length; i++) {
		var colArray = rowArray[0];
		var colArray2 = colArray[4];
		var colArray3 = colArray[3];
		document.form.rep_cmdt_cd.value = colArray2;
		document.form.rep_cmdt_nm.value = colArray3;
	}
}
/**
 * Pop-up call to commodity
 */
function commodity_OnPopupClick() {
	var formObject = document.form;
	var cmdt_cd_val = "";
	var rep_cmdt_cd_val = "";
	var cmdt_desc_val = "";
	var classId = "getCOM_ENS_commodity";
	var xx1 = ""; // CONTI
	var xx2 = ""; // SUB CONTI
	var xx3 = ""; // COUNTRY
	var xx4 = ""; // STATE
	var xx5 = ""; // CONTROL OFFIC
	var xx6 = ""; // LOC CODE
	var xx7 = ""; // LOC NAME
	var xx8 = "";
	var xx9 = "";
	var param = "?conti_cd=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
	ComOpenPopup('/opuscntr/COM_ENS_011.do' + param, 772, 413, 'getCOM_ENS_commodity', '0,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * commodity pop-up call: if you make a single choice from a pop-up.
 */
function getCOM_ENS_commodity(rowArray) {
	var formObject = document.form;
	for ( var i = 0; i < rowArray.length; i++) {
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[3];
		document.form.cmdt_cd.value = colArray2;
		document.form.cmdt_nm.value = colArray3;
	}
}
/**
 * Pop-up call to commodity
 */
function vndr_OnPopupClick() {
	var formObject = document.form;
	var cmdt_cd_val = "";
	var rep_cmdt_cd_val = "";
	var cmdt_desc_val = "";
	var classId = "getCOM_ENS_vndr";
	var xx1 = ""; // CONTI
	var xx2 = ""; // SUB CONTI
	var xx3 = ""; // COUNTRY
	var xx4 = ""; // STATE
	var xx5 = ""; // CONTROL OFFIC
	var xx6 = ""; // LOC CODE
	var xx7 = ""; // LOC NAME
	var xx8 = "";
	var xx9 = "";
	var param = "?conti_cd=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
	ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 700, 515, 'getCOM_ENS_vndr', '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * commodity pop-up call: if you make a single choice from a pop-up.
 */
function getCOM_ENS_vndr(rowArray) {
	var formObject = document.form;
	for ( var i = 0; i < rowArray.length; i++) {
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[3];
		document.form.vndr_cd.value = colArray2;
		document.form.vndr_nm.value = colArray3;
	}
}
/**
 * Location and event handling when entering Contry Code
 */
function sheet1_OnChange(sheetObj, row, col, value) {
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(col);
	var loop_val = "N";
	var charval = "Y";
	var inputStr = delSpace(value);
	switch (colName) {
		case 'vndr_seq':
			var sheet1_vndr_seq = sheet1.GetCellValue(row, "vndr_seq");
			var inputStr = sheet1_vndr_seq;
			for ( var i = 0; i < inputStr.length; i++) {
				var oneChar = inputStr.charAt(i)
				if (oneChar != "") {
					if ((oneChar >= "0" && oneChar <= "9")) {
					} else {
						charval = "N";
						break;
					}
				} else {
					charval = "N";
					break;
				}
			}
			var b_vndr_seq = sheet1.GetCellValue(row, "vndr_seq");
			var b_trsp_grp_cmdt_cd = sheet1.GetCellValue(row, "trsp_grp_cmdt_cd");
			var bigyo_1 = b_vndr_seq + b_trsp_grp_cmdt_cd;
			sheet1.SetCellValue(row, "dupl", bigyo_1, 0);
			var b_dupl = sheet1.ColValueDup("dupl");
			if (b_dupl > 0) {
				var errMessage = ComGetMsg('COM12115', 'Vender and Commodity', '', '');
				ComShowMessage(errMessage);
				sheet1.SetCellValue(row, col, "", 0);
				sheet1.SelectCell(row, col);
				return false;
			}
			if (charval != "N") {
				if (sheet1_vndr_seq != "") {
					formObject.f_cmd.value = SEARCH04;
					var queryString = "vndr_cd=" + value + "&" + TrsFrmQryString(formObject);

					var sXml = sheetObj.GetSearchData("ESD_TRS_0075GS.do", queryString);
					var vendor = ComGetEtcData(sXml, 'CNT_CD');
					if (!check_sheet_vndr(vendor, row, col)) {
						sheet1.SetCellValue(row, col, "", 0);
						sheet1.SelectCell(row, col);
						return false;
					}
				}
			}
			break;
		case 'trsp_grp_cmdt_cd':
			var b_vndr_seq = sheet1.GetCellValue(row, "vndr_seq");
			var b_trsp_grp_cmdt_cd = sheet1.GetCellValue(row, "trsp_grp_cmdt_cd");
			var bigyo_1 = b_vndr_seq + b_trsp_grp_cmdt_cd;
			sheet1.SetCellValue(row, "dupl", bigyo_1, 0);
			var b_dupl = sheet1.ColValueDup("dupl");
			if (b_dupl > 0) {
				var errMessage = ComGetMsg('COM12115', 'Vender and Commodity', '', '');
				ComShowMessage(errMessage);
				sheet1.SetCellValue(row, col, "", 0);
				sheet1.SelectCell(row, col);
				return false;
			}
			break;
		case 'trsp_cmdt_grp_nm':
			row_status = sheet1.GetRowStatus(row);
			if (row_status == "I") {
			} else {
				sheet1.SetRowStatus(row, "U");
				sheet1.SetCellValue(row, "update", "U", 0);
			}
			break;
		case 'radio':
			var sheet1_vndr_seq = sheet1.GetCellValue(row, "vndr_seq");
			var sheet1_trsp_grp_cmdt_cd = sheet1.GetCellValue(row, "trsp_grp_cmdt_cd");
			var update = sheet1.GetCellValue(row, "update");
			row_status = sheet1.GetRowStatus(row);
			var sheet4_count = sheet4.RowCount();
			var p = sheet4_count + 1;
			var s = 1;
			var cmdt_cd = "";
			var cmdt_nm = "";
			var cre_dt = "";
			var cre_usr_id = "";
			var vndr_seq = "";
			var trsp_grp_cmdt_cd = "";
			var bigyo_t1 = "";
			var bigyo_t2 = "";
			bigyo_t1 = sheet1_vndr_seq + sheet1_trsp_grp_cmdt_cd;
			sheet2.RemoveAll();
			formObject.f_cmd.value = SEARCH06;
			var vndr_seq_val = sheet1.GetCellValue(row, "vndr_seq");
			var trsp_grp_cmdt_cd_val = sheet1.GetCellValue(row, "trsp_grp_cmdt_cd");
			var queryString = "trsp_grp_cmdt_cd=" + trsp_grp_cmdt_cd_val + "&" + "vndr_seq=" + vndr_seq_val + "&" + TrsFrmQryString(formObject);
			sheet2.DoSearch("ESD_TRS_0075GS.do", queryString, { Sync : 2 });
			var sheet2_count = sheet2.RowCount();
			var k = sheet2_count + 1;
			if (sheet4_count > 0) {
				for ( var t = 1; t < p; t++) {
					sheet4_vndr_seq = sheet4.GetCellValue(t, "vndr_seq");
					sheet4_trsp_grp_cmdt_cd = sheet4.GetCellValue(t, "trsp_grp_cmdt_cd");
					bigyo_t2 = sheet4_vndr_seq + sheet4_trsp_grp_cmdt_cd;
					if (bigyo_t1 == bigyo_t2 && sheet4.GetCellValue(t, "cmdt_cd") != '') {
						var cmdt_cd = sheet4.GetCellValue(t, "cmdt_cd");
						var cmdt_nm = sheet4.GetCellValue(t, "cmdt_nm");
						var cre_dt = sheet4.GetCellValue(t, "cre_dt");
						var cre_usr_id = sheet4.GetCellValue(t, "cre_usr_id");
						var vndr_seq = sheet4.GetCellValue(t, "vndr_seq");
						var trsp_grp_cmdt_cd = sheet4.GetCellValue(t, "trsp_grp_cmdt_cd");
						sheet2.DataInsert(k);
						sheet2.SetCellValue(k, "cmdt_cd", cmdt_cd, 0);
						sheet2.SetCellValue(k, "cmdt_nm", cmdt_nm, 0);
						sheet2.SetCellValue(k, "cre_dt", cre_dt, 0);
						sheet2.SetCellValue(k, "cre_usr_id", cre_usr_id, 0);
						sheet2.SetCellValue(k, "vndr_seq", vndr_seq, 0);
						sheet2.SetCellValue(k, "trsp_grp_cmdt_cd", trsp_grp_cmdt_cd, 0);
						sheet2.SetRowStatus(k, "R");
						sheet2.SetRowBackColor(k, "#EEFFE2");
						k = k + 1;
					} else {
						sheet4.RowDelete(t, false);
					}
				}
			}
			break;
	}
}
/**
 * The presence of input Check VNDR
 */
function check_sheet_vndr(value, row, col) {
	var formObject = document.form;
	if (value == 0) {
		var errMessage = ComGetMsg('COM12114', 'VNDR', '', '');
		ComShowMessage(errMessage);
		return false;
	} else {
		formObject.vndr_nm.value = value;
		sheet1.SetCellValue(row, col + 1, value, 0);
		return true;
	}
}
/**
 * Remove spaces from a string
 */
function delSpace(str) {
	var trimstr = str;
	for ( var i = 0; i < str.length; i++) {
		trimstr = trimstr.replace(' ', '');
	}
	return trimstr;
}
/**
 * pop-up handle on sheet1
 */
function sheet1_OnPopupClick(sheetObj, row, col) {
	var formObject = document.form;
	var cmdt_cd_val = "";
	var rep_cmdt_cd_val = "";
	var cmdt_desc_val = "";
	var classId = "getCOM_ENS_0C1";
	var xx1 = ""; // CONTI
	var xx2 = ""; // SUB CONTI
	var xx3 = ""; // COUNTRY
	var xx4 = ""; // STATE
	var xx5 = ""; // CONTROL OFFIC
	var xx6 = ""; // LOC CODE
	var xx7 = ""; // LOC NAME
	var xx8 = "";
	var xx9 = "";
	formObject.hid_row.value = row; // putting a value to the value hidden row
	formObject.hid_col.value = col; // putting the value of col value hidden
	if (sheetObj.ColSaveName(col) == "vndr_nm") {
		var param = "?conti_cd=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
		ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 700, 515, 'getCOM_ENS_0C1', '1,0,1,1,1,1,1,1,1,1,1,1');
	} else {
	}
}
/**
 * Location: If a pop-up from a single selection.
 */
function getCOM_ENS_0C1(rowArray) {
	var formObject = document.form;
	// Multi-select in the pop-up and made ready to take over in the set-ateum!!!
	for ( var i = 0; i < rowArray.length; i++) {
		var colArray = rowArray[0];
		var row_val = formObject.hid_row.value; // putting a value to the value hidden row
		var col_val = formObject.hid_col.value; // putting the value of col value hidden
		var in_val_1 = colArray[2];
		var in_val_2 = colArray[4];
		sheet1.SetCellValue(row_val, col_val - 1, in_val_1, 0);
		sheet1.SetCellValue(row_val, col_val, in_val_2, 0);
	}
}
/**
 * Check Hangul
 */
function han_check(inputStr, val) {
	var formObject = document.form;
	var onecharval = inputStr.value;
	var gubun = val;
	for ( var i = 0; i < onecharval.length; i++) {
		var oneChar = onecharval.charAt(i)
		if (oneChar != "") {
			if (hanCheck(oneChar)) {
				if (gubun == "A") {
					formObject.vndr_commoodity_cd.value = "";
				} else if (gubun == "B") {
					formObject.vndr_commoodity_nm.value = "";
				} else {
				}
			}
		} else {
			break;
		}
	}
}
/**
 * Hangul check whether Hangul input string is true, Hangul input string, false if not
 */
function hanCheck(str) {
	var str1 = getByteLenval(str);
	if (str.length * 2 == str1) // If Hangul
		return true;
	else
		return false;
}
/**
 * Byte Size of String obtain the input received
 */
function getByteLenval(str) {
	var len = 0;
	if (str == null)
		return 0;
	for ( var i = 0; i < str.length; i++) {
		var c = escape(str.charAt(i));
		if (c.length == 1)
			len++;
		else if (c.indexOf("%u") != -1)
			len += 2;
		else if (c.indexOf("%") != -1)
			len += c.length / 3;
	}
	return len;
}
/**
 * Click the Apply button to apply the logic at
 */
function apply_send(sheetObj, formObj) {
	var formObject = document.form;
	var checkRows;
	var colsCnt = sheetObj.LastCol() + 1;
	var rows = sheetObj.RowCount();
	var vndr_seq = "";
	var trsp_grp_cmdt_cd = "";
	var cre_dt = formObject.cre_dt.value;
	var cre_usr_id = formObject.cre_usr_id.value;
	var sheet2_count = sheet2.RowCount();
	var sheet4_count = sheet4.RowCount();
	var bigyo_row_1 = "";
	var bigyo_row_2 = "";
	var loop_val = "Y";
	var row_status = "";
	var xxx = sheet1.FindCheckedRow("radio"); // Come to know the number of the row is checked.
	var x = xxx;
	if (xxx == "") {
		var errMessage = ComGetMsg('COM12114', 'VNDR sheet-[Check]');
		ComShowMessage(errMessage);
	} else {
		x = delbar(x);
		vndr_seq = sheet1.GetCellValue(x, "vndr_seq");
		formObject.hid_vndr_seq.value = vndr_seq;
		trsp_grp_cmdt_cd = sheet1.GetCellValue(x, "trsp_grp_cmdt_cd");
		if (vndr_seq == "" || trsp_grp_cmdt_cd == "") {
			var errMessage = ComGetMsg('COM12114', 'VNDR /VNDR Commoodity');
			ComShowMessage(errMessage);
		} else {
			checkRows = sheetObj.CheckedRows("check");
			if (checkRows == 0) {
				var errMessage = ComGetMsg('COM12114', 'Rep. Commodity-[Check]');
				ComShowMessage(errMessage);
				return;
			} else {
				var idx = 0;
				var cmdt_cd = "";
				var cmdt_nm = "";
				var k = sheet2_count + 1;
				var s1 = sheet2_count + 1;
				var s2 = sheet4_count + 1;
				var p = sheet4_count + 1;
				rArray = new Array(checkRows);
				for ( var i = 1; i < rows + 1; i++) {
					if (sheetObj.GetCellValue(i, "check") == 1) {
						cmdt_cd = sheetObj.GetCellValue(i, "cmdt_cd");
						cmdt_nm = sheetObj.GetCellValue(i, "cmdt_nm");
						bigyo_row_1 = cmdt_cd + vndr_seq + trsp_grp_cmdt_cd;
						for ( var t = 1; t < p; t++) {
							bigyo_row_2 = sheet4.GetCellValue(t, "cmdt_cd") + sheet4.GetCellValue(t, "vndr_seq") + sheet4.GetCellValue(t, "trsp_grp_cmdt_cd");
							if (bigyo_row_1 == bigyo_row_2) {
								loop_val = "N";
							}
						}
						for ( var t = 1; t < s1; t++) {
							bigyo_row_2 = sheet2.GetCellValue(t, "cmdt_cd") + sheet2.GetCellValue(t, "vndr_seq") + sheet2.GetCellValue(t, "trsp_grp_cmdt_cd");
							if (bigyo_row_1 == bigyo_row_2) {
								loop_val = "N";
							} 
						}
						if (loop_val == "Y") {
							sheet2.DataInsert(k);
							sheet2.SetCellValue(k, "cmdt_cd", cmdt_cd, 0);
							sheet2.SetCellValue(k, "cmdt_nm", cmdt_nm, 0);
							sheet2.SetCellValue(k, "cre_dt", cre_dt, 0);
							sheet2.SetCellValue(k, "cre_usr_id", cre_usr_id, 0);
							sheet2.SetCellValue(k, "vndr_seq", vndr_seq, 0);
							sheet2.SetCellValue(k, "trsp_grp_cmdt_cd", trsp_grp_cmdt_cd, 0);
							sheet2.SetCellValue(k, "deleteval", "Y", 0);
							sheet4.DataInsert(s2);
							sheet4.SetCellValue(s2, "cmdt_cd", cmdt_cd, 0);
							sheet4.SetCellValue(s2, "cmdt_nm", cmdt_nm, 0);
							sheet4.SetCellValue(s2, "cre_dt", cre_dt, 0);
							sheet4.SetCellValue(s2, "cre_usr_id", cre_usr_id, 0);
							sheet4.SetCellValue(s2, "vndr_seq", vndr_seq, 0);
							sheet4.SetCellValue(s2, "trsp_grp_cmdt_cd", trsp_grp_cmdt_cd, 0);
							sheet2.SetRowStatus(k, "R");
							sheet2.SetRowBackColor(k, "#EEFFE2");
							k = k + 1;
							s2 = s2 + 1;
						}
					}
					loop_val = "Y";
				}
			}
		}
	}
}
function apply_loop() {
	sheet2.DataInsert(k);
	sheet2.SetCellValue(k, "cmdt_cd", cmdt_cd, 0);
	sheet2.SetCellValue(k, "cmdt_nm", cmdt_nm, 0);
	sheet2.SetCellValue(k, "cre_dt", cre_dt, 0);
	sheet2.SetCellValue(k, "cre_usr_id", cre_usr_id, 0);
	sheet2.SetCellValue(k, "vndr_seq", vndr_seq, 0);
	sheet2.SetCellValue(k, "trsp_grp_cmdt_cd", trsp_grp_cmdt_cd, 0);
	sheet2.SetCellValue(k, "deleteval", "Y", 0);
	sheet4.DataInsert(s2);
	sheet4.SetCellValue(s2, "cmdt_cd", cmdt_cd, 0);
	sheet4.SetCellValue(s2, "cmdt_nm", cmdt_nm, 0);
	sheet4.SetCellValue(s2, "cre_dt", cre_dt, 0);
	sheet4.SetCellValue(s2, "cre_usr_id", cre_usr_id, 0);
	sheet4.SetCellValue(s2, "vndr_seq", vndr_seq, 0);
	sheet4.SetCellValue(s2, "trsp_grp_cmdt_cd", trsp_grp_cmdt_cd, 0);
	sheet2.SetRowStatus(k, "R");
	sheet2.SetRowBackColor(k, "#EEFFE2");
	k = k + 1;
	s2 = s2 + 1;
}
/**
 * Remove spaces from a string
 */
function delbar(str) {
	var trimstr = str;
	for ( var i = 0; i < str.length; i++) {
		trimstr = trimstr.replace('|', '');
	}
	return trimstr;
}
/**
 * Delete button handling of sheet1
 */
function sheet1_delete(sheetObj, formObj) {
	var formObject = document.form;
	var bigyo_row_1 = "";
	var bigyo_row_2 = "";
	var vndr_seq = "";
	var trsp_grp_cmdt_cd = "";
	var sheet2_count = sheet2.RowCount();
	var sheet4_count = sheet4.RowCount();
	// Sheet sheet2-sheet4 existing value that is stored in the logic is that if it is there.
	// Logic is only on the screen to delete.
	var xxx = sheet1.FindCheckedRow("radio"); // Come to know the number of the row is checked.
	var x = xxx;
	if (xxx == "") {
		// var errMessage = ComGetMsg('COM12139','VNDR sheet-[Check]','','');
		// ComShowMessage(errMessage);
	} else {
		x = delbar(x);
		vndr_seq = sheet1.GetCellValue(x, "vndr_seq");
		trsp_grp_cmdt_cd = sheet1.GetCellValue(x, "trsp_grp_cmdt_cd");
		var idx = 0;
		var cmdt_cd = "";
		var cmdt_nm = "";
		var k = sheet2_count + 1;
		var s = sheet4_count + 1;
		var p = sheet4_count + 1;
		bigyo_row_1 = vndr_seq + trsp_grp_cmdt_cd;
		for ( var t = 1; t < p; t++) {
			bigyo_row_2 = sheet4.GetCellValue(t, "vndr_seq") + sheet4.GetCellValue(t, "trsp_grp_cmdt_cd");
			if (bigyo_row_1 == bigyo_row_2) {
				sheet4.RowDelete(t, false);
				t = t - 1;
			}
		}
		for ( var t = 1; t < k; t++) {
			bigyo_row_2 = sheet2.GetCellValue(t, "vndr_seq") + sheet2.GetCellValue(t, "trsp_grp_cmdt_cd");
			if (bigyo_row_1 == bigyo_row_2) {
				sheet2.SetRowStatus(t, "D");
			}
		}
		// Sheet sheet1 old value that is stored in the logic is that if it is there.
		// Is the branching logic to delete.
		var vndr_seq = sheet1.GetCellValue(x, "vndr_seq");
		var trsp_grp_cmdt_cd = sheet1.GetCellValue(x, "trsp_grp_cmdt_cd");
		var save_check = sheet1.GetCellValue(x, "save");
		if (save_check == "N") {
			sheet1.RowDelete(x, false); // Only on the portion of the screen to handle
		} else {
			// Actually that is part of the business logic burn.
			formObj.f_cmd.value = MULTI01;
			sheet1.SetRowStatus(x, "D");
			var queryString = "vndr_seq=" + vndr_seq + "&trsp_grp_cmdt_cd=" + trsp_grp_cmdt_cd + "&" + TrsFrmQryString(formObject);
			var SaveStr = sheet2.GetSaveString(false, false);
			var sXml = sheet2.GetSaveData("ESD_TRS_0075_01GS.do", queryString + "&" + SaveStr);
			sheet2.LoadSaveData(sXml, { Sync : 2 });
			formObj.f_cmd.value = MULTI;
			sheet1.SetRowStatus(x, "D");
			var queryString = "vndr_seq=" + vndr_seq + "&trsp_grp_cmdt_cd=" + trsp_grp_cmdt_cd + "&" + TrsFrmQryString(formObject);
			var SaveStr = sheet1.GetSaveString(false, false);
			var sXml = sheet1.GetSaveData("ESD_TRS_0075GS.do", queryString + "&" + SaveStr);
			sheet1.LoadSaveData(sXml, { Sync : 2 });
		}
		for ( var t = 1; t < k; t++) {
			bigyo_row_2 = sheet2.GetCellValue(t, "vndr_seq") + sheet2.GetCellValue(t, "trsp_grp_cmdt_cd");
			if (bigyo_row_1 == bigyo_row_2) {
				sheet2.RowDelete(t, false);
				t = t - 1;
			}
		}
	}
}
/**
 * Save button nureulsi whole.
 */
function tot_save() {
	var formObject = document.form;
	var val = "";
	var xxx = sheet1.FindCheckedRow("radio"); // Come to know the number of the row is checked.
	var x = xxx;
	x = delbar(x);
	var vndr_seq = "";
	var trsp_grp_cmdt_cd = "";
	var cmdt_cd = "";
	vndr_seq = sheet1.GetCellValue(x, "vndr_seq");
	trsp_grp_cmdt_cd = sheet1.GetCellValue(x, "trsp_grp_cmdt_cd");
	cmdt_cd = sheet1.GetCellValue(x, "cmdt_cd");
	sheet1.RemoveAll();
	sheet2.RemoveAll();
	sheet4.RemoveAll();
	formObject.f_cmd.value = SEARCH;
	var value = "";
	var value1 = "";
	var queryString = "value=" + value + "&" + "value1=" + value1 + "&" + TrsFrmQryString(formObject);
	sheet1.DoSearch("ESD_TRS_0075GS.do", queryString, { Sync : 2 });
	sheet1.SetCellValue(x, "radio", "1", 0);
	formObject.f_cmd.value = SEARCH06;
	var queryString = "trsp_grp_cmdt_cd=" + trsp_grp_cmdt_cd + "&" + "vndr_seq=" + vndr_seq + "&" + TrsFrmQryString(formObject);
	sheet2.DoSearch("ESD_TRS_0075GS.do", queryString, { Sync : 2 });
	sheet1.SelectCell(x, 1, false);
}

/**
 * Save button nureulsi part .. (Delete button at the bottom sheet)
 */
function part_save() {
	var formObject = document.form;
	var val = "";
	var bigyo_row_1 = "";
	var bigyo_row_2 = "";
	var vndr_seq = "";
	var trsp_grp_cmdt_cd = "";
	var cmdt_cd = "";
	var sheet2_count = sheet2.RowCount();
	var sheet4_count = sheet4.RowCount();
	var idx = 0;
	var cmdt_cd = "";
	var cmdt_nm = "";
	var k = sheet2_count + 1;
	var p = sheet4_count + 1;
	var p2 = sheet4_count + 1;
	var yyy = sheet1.FindCheckedRow("radio"); // Come to know the number of the row is checked.
	var y = delbar(yyy);
	var sheet1_cmdt_cd = sheet1.GetCellValue(y, "cmdt_cd");

	for ( var p = 1; p < k; p++) {
		if (sheet2.GetCellValue(p, "part") == 1) {
			// Comparison of sheet2 and # syntax for reading the value of the sheet4 [1]
			vndr_seq = sheet2.GetCellValue(p, "vndr_seq");
			trsp_grp_cmdt_cd = sheet2.GetCellValue(p, "trsp_grp_cmdt_cd");
			cmdt_cd = sheet2.GetCellValue(p, "cmdt_cd");
			bigyo_row_1 = vndr_seq + trsp_grp_cmdt_cd + cmdt_cd;
			for ( var t = 1; t < p2; t++) {
				bigyo_row_2 = sheet4.GetCellValue(t, "vndr_seq") + sheet4.GetCellValue(t, "trsp_grp_cmdt_cd") + sheet4.GetCellValue(t, "cmdt_cd");
				if (bigyo_row_1 == bigyo_row_2) {
					sheet4.RowDelete(t, false);
					t = t - 1;
				}
			}
		}
	}

	formObject.f_cmd.value = MULTI02;
	var queryString = "val=" + val + "&" + TrsFrmQryString(formObject);
	var SaveStr = sheet2.GetSaveString(false, false);
	sheet2.DoSave("ESD_TRS_0075_01GS.do", { Param : queryString, Col : "ibflag", Quest : "false", UrlEncode : "true", Sync : 1 });
	ComOpenWait(false);
}
/**
 * After pressing the Save button part ... (the Delete button at the bottom sheet)
 */
function part_save_after(sheetObj, row) {
	var formObject = document.form;
	var xxx = sheet1.FindCheckedRow("radio"); // Come to know the number of the row is checked.
	var x = xxx;
	x = delbar(x);
	var sheet1_vndr_seq = sheet1.GetCellValue(x, "vndr_seq");
	var sheet1_trsp_grp_cmdt_cd = sheet1.GetCellValue(x, "trsp_grp_cmdt_cd");
	var bigyo_1 = "";
	var bigyo_2 = "";
	bigyo_1 = sheet1_vndr_seq + sheet1_trsp_grp_cmdt_cd;
	var sheet4_count = sheet4.RowCount();
	var p = sheet4_count + 1;
	var s = 1;
	var cmdt_cd = "";
	var cmdt_nm = "";
	var cre_dt = "";
	var cre_usr_id = "";
	var vndr_seq = "";
	var trsp_grp_cmdt_cd = "";
	var sheet2_count = sheet2.RowCount();
	var k = sheet2_count + 1;
	var sheet4_vndr_seq = "";
	var sheet4_trsp_grp_cmdt_cd = "";
	checkRows = sheetObj.CheckedRows("part");
	rArray = new Array(checkRows);
	if (sheet4_count > 0) {
		for ( var t = 1; t < p; t++) {
			sheet4_vndr_seq = sheet4.GetCellValue(t, "vndr_seq");
			sheet4_trsp_grp_cmdt_cd = sheet4.GetCellValue(t, "trsp_grp_cmdt_cd");
			bigyo_2 = sheet4_vndr_seq + sheet4_trsp_grp_cmdt_cd;
			if (bigyo_1 == bigyo_2 && sheet4.GetCellValue(t, "cmdt_cd") != '') {
				var cmdt_cd = sheet4.GetCellValue(t, "cmdt_cd");
				var cmdt_nm = sheet4.GetCellValue(t, "cmdt_nm");
				var cre_dt = sheet4.GetCellValue(t, "cre_dt");
				var cre_usr_id = sheet4.GetCellValue(t, "cre_usr_id");
				var vndr_seq = sheet4.GetCellValue(t, "vndr_seq");
				var trsp_grp_cmdt_cd = sheet4.GetCellValue(t, "trsp_grp_cmdt_cd");
				sheet2.DataInsert(k);
				sheet2.SetCellValue(k, "cmdt_cd", cmdt_cd, 0);
				sheet2.SetCellValue(k, "cmdt_nm", cmdt_nm, 0);
				sheet2.SetCellValue(k, "cre_dt", cre_dt, 0);
				sheet2.SetCellValue(k, "cre_usr_id", cre_usr_id, 0);
				sheet2.SetCellValue(k, "vndr_seq", vndr_seq, 0);
				sheet2.SetCellValue(k, "trsp_grp_cmdt_cd", trsp_grp_cmdt_cd, 0);
				sheet2.SetRowStatus(k, "R");
				sheet2.SetRowBackColor(k, "#EEFFE2");
				k = k + 1;
			}
		}
	}
}
/**
 * onchange event handling on sheet2
 * 
 */
function sheet2_OnChange(sheetObj, row, col, value) {
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(col);
	var loop_val = "N";
	var inputStr = delSpace(value);
	switch (colName) {
		case 'part':
			sheet2.SetRowStatus(row, "D");
			break;
	}
}
/**
 * When an error occurs, save the results to a common processing function
 */
function sheet1_OnSaveEnd(sheetObj, code, errMsg) {
	if (code < 0) {
		ComShowMessage(errMsg);
	} else {
		var formObject = document.form;
		var xxx = sheet1.FindCheckedRow("radio"); // Come to know the number of the row is checked.
		var x = delbar(xxx);

		if (x != '') {
			var vndr_seq = sheet1.GetCellValue(x, "vndr_seq");
			var trsp_grp_cmdt_cd = sheet1.GetCellValue(x, "trsp_grp_cmdt_cd");
			sheet1.RemoveAll();
			sheet2.RemoveAll();
			sheet4.RemoveAll();

			formObject.f_cmd.value = SEARCH;
			sheet1.DoSearch("ESD_TRS_0075GS.do", TrsFrmQryString(formObject), { Sync : 2 });
			sheet1.SetCellValue(x, "radio", "1", 0);
			sheet1.SelectCell(x, 1, false);

			formObject.f_cmd.value = SEARCH06;
			var queryString = "trsp_grp_cmdt_cd=" + trsp_grp_cmdt_cd + "&" + "vndr_seq=" + vndr_seq + "&" + TrsFrmQryString(formObject);
			sheet2.DoSearch("ESD_TRS_0075GS.do", queryString, { Sync : 2 });

		} else {
			doActionIBSheet(sheet1, document.form, IBSEARCH);
		}
	}
}
/**
 * When an error occurs, save the results to a common processing function
 */
function sheet2_OnSaveEnd(sheetObj, code, errMsg) {
	if (code < 0) {
		ComShowMessage(errMsg);
	} else {
		var formObject = document.form;
		var yyy = sheet1.FindCheckedRow("radio");
		var y = delbar(yyy);

		var sheet1_trsp_grp_cmdt_cd = sheet1.GetCellValue(y, "trsp_grp_cmdt_cd");
		var sheet1_vndr_seq = sheet1.GetCellValue(y, "vndr_seq");

		sheetObj.RemoveAll();
		formObject.f_cmd.value = SEARCH06;

		var queryString = "trsp_grp_cmdt_cd=" + sheet1_trsp_grp_cmdt_cd + "&" + "vndr_seq=" + sheet1_vndr_seq + "&" + TrsFrmQryString(formObject);
		sheet2.DoSearch("ESD_TRS_0075GS.do", queryString, { Sync : 2 });

		var xxx = sheet2.FindCheckedRow("part"); 
		var x = delbar(xxx);

		part_save_after(sheetObj, x);
	}
}
/**
 * When an error occurs, save the results to a common processing function
 */
function sheet3_OnSaveEnd(sheetObj, code, errMsg) {
	if (code < 0) {
		ComShowMessage(errMsg);
	}
}
/**
 * When an error occurs, save the results to a common processing function
 */
function sheet4_OnSaveEnd(sheetObj, code, errMsg) {
	if (code < 0) {
		ComShowMessage(errMsg);
	}
}

/**
 * Reset Function
 */
function fn_reset() {
	var formObject = document.form;
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();
	formObject.vndr_cd.value = "";
	formObject.vndr_nm.value = "";
	formObject.vndr_commoodity_cd.value = "";
	formObject.vndr_commoodity_nm.value = "";
	formObject.rep_cmdt_cd.value = "";
	formObject.rep_cmdt_nm.value = "";
	formObject.cmdt_cd.value = "";
	formObject.cmdt_nm.value = "";
}
function fn_reset_01() {
	var formObject = document.form;
	alert(ComTrimAll(formObject.amt.value, ","));
}
function zeroInsert(str) {
	var zero = "";
	for ( var i = 0; i < 6 - str.length; i++) {
		zero += "0";
	}
	return zero + str;
}
