/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_cim_1014.js
 *@FileTitle : Turn Around Time
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.19
 *@LastModifier :
 *@LastVersion :
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/



/**
 * @extends 
 * @class ees_cim_1014 : business script for ees_cim_1014 
 */
function ees_cim_1014() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* developer job	*/

// common global variables
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var isOpen = false;
var tabIndex = 0;

var comboObjects = new Array();
var comboCnt = 0;

var tot_cntr_tpsz_cd = "";
var sheadTitle = "";
var flag = false;
var enterSwitch = false;

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick() {
	
	var shtCnt = 0;
	var t1sheet1 = sheetObjects[shtCnt++];
	var t2sheet1 = sheetObjects[shtCnt++];
	var t3sheet1 = sheetObjects[shtCnt++];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			if (tabIndex == 0) {
				t2sheet1.RemoveAll();
				t3sheet1.RemoveAll();
				doActionIBSheet(t1sheet1, formObject, IBSEARCH);
				sheetObjects[0].SelectRow = 0;
			} else if (tabIndex == 1) {
				t1sheet1.RemoveAll();
				t3sheet1.RemoveAll();
				doActionIBSheet2(t2sheet1, formObject, IBSEARCH);
				sheetObjects[1].SelectRow = 0;
			} else {

				t1sheet1.RemoveAll();
				t2sheet1.RemoveAll();
				doActionIBSheet3(t3sheet1, formObject, IBSEARCH);
				sheetObjects[2].SelectRow = 0;
			}
			break;

		case "btn_new":
			t1sheet1.RemoveAll();
			t2sheet1.RemoveAll();
			t3sheet1.RemoveAll();
			formObject.reset();
			comboObjects[0].Code = "";
			comboObjects[1].Code = "";
			comboObjects[2].Code = "";
			comboObjects[1].Enable = false;
			initControl();
			ComSetFocus(formObject.froms);
			break;

		case "btns_calendarfm":
			var cal = new ComCalendar();
			cal.setDisplayType('month');
			cal.select(formObject.froms, 'yyyy-MM');
			break;
		case "btns_calendarto":
			var cal = new ComCalendar();
			cal.setDisplayType('month');
			cal.select(formObject.tos, 'yyyy-MM');
			break;
		case "btn_downexcel":
			if (t1sheet1.RowCount > 0 && tabIndex == 0) {
				t1sheet1.Down2Excel(-1);
			}
			if (t2sheet1.RowCount > 0 && tabIndex == 1) {
				t2sheet1.Down2Excel(-1);
			}
			if (t3sheet1.RowCount > 0 && tabIndex == 2) {
				t3sheet1.Down2Excel(-1);
			}
			break;
		case "btn_loc_cd1": 
			var loc_cd = "";
			var param = "?loc_cd=" + document.form.oploc.value;
			ComOpenPopup("/opuscntr/COM_ENS_051.do" + param, 755, 630, "popupFinish1", "1,0,1,1,1,1,1,1", true);
			break;
		case "btn_loc_cd2": 
			var loc_cd = "";
			var param = "?loc_cd=" + document.form.idloc.value;
			ComOpenPopup("/opuscntr/COM_ENS_051.do", 755, 630, "popupFinish2", "1,0,1,1,1,1,1,1", true);
			break;
		case "btn_loc_cd3": //retrieving pol popup
			var loc_cd = "";
			var param = "?loc_cd=" + document.form.pol.value;
			ComOpenPopup("/opuscntr/COM_ENS_051.do", 755, 630, "popupFinish3", "1,0,1,1,1,1,1,1", true);
			break;
		case "btn_loc_cd4": //retrieving pod popup
			var loc_cd = "";
			var param = "?loc_cd=" + document.form.pod.value;
			ComOpenPopup("/opuscntr/COM_ENS_051.do", 755, 630, "popupFinish4", "1,0,1,1,1,1,1,1", true);
			break;
		} // end switch

	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("CIM30032");
		} else {
			alert(e);
		}
	}

}

/**
 * setting selected value from Location by loc_cd popup
 */
function popupFinish1(aryPopupData, row, col, sheetIdx) {
	var sheetObject = sheetObjects[2];
	var formObject = document.form;
	formObject.oploc.value = aryPopupData[0][3];
}

/**
 * setting selected value from Location by loc_cd popup
 */
function popupFinish2(aryPopupData, row, col, sheetIdx) {
	var sheetObject = sheetObjects[2];
	var formObject = document.form;
	formObject.idloc.value = aryPopupData[0][3];
}

/**
 * setting selected value from Location by loc_cd popup
 */
function popupFinish3(aryPopupData, row, col, sheetIdx) {
	var sheetObject = sheetObjects[2];
	var formObject = document.form;
	formObject.pol.value = aryPopupData[0][3];
}

/**
 * setting selected value from Location by loc_cd popup
 */
function popupFinish4(aryPopupData, row, col, sheetIdx) {
	var sheetObject = sheetObjects[2];
	var formObject = document.form;
	formObject.pod.value = aryPopupData[0][3];
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * registering IBMultiCombo Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setComboObject(combo_obj) {

	comboObjects[comboCnt++] = combo_obj;

}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	// setDate();
	for (i = 0; i < sheetObjects.length; i++) {

		
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		
		ComEndConfigSheet(sheetObjects[i]);
	}

	//initializing IBMultiCombo
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	isOpen = true;
	initControl();

}

function t1sheet1_OnLoadFinish(sheetObj) {
	sheetObj.WaitImageVisible = false;
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	comboObjects[1].DisabledBackColor = "#FFFFFF";
	comboObjects[1].Enable = false;
	document.form.froms.focus();
	sheetObj.WaitImageVisible = true;
}

/**
 *
 * @return
 */
function initControl() {
	axon_event.addListener('click', 'radio_click', 'locdivision', '');
	axon_event.addListener('click', 'reverse_cntr_tpsz_cd_check', 'chk_cntr_tpsz_cd', ''); 
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerFormat('keyup', 'form_keyup', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerFormat('focus', 'obj_activate', form); 
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('blur', 'obj_locLevelBlur', form);

	document.form.oploc.disabled = false;
	document.form.idloc.disabled = false;
	document.form.pol.disabled = true;
	document.form.pod.disabled = true;
	document.getElementById("oploc").className = "input";
	document.getElementById("idloc").className = "input";
	document.getElementById("pol").className = "input2";
	document.getElementById("pod").className = "input2";
	tabObjects[0].TabText(2) = "OP LOC - ID LOC";
	sheetObjects[2].CellValue2(0, 0) = "OP LOC";
	sheetObjects[2].CellValue2(0, 1) = "ID LOC";
	sheetObjects[2].CellValue2(1, 0) = "OP LOC";
	sheetObjects[2].CellValue2(1, 1) = "ID LOC";

}

function tpsz_OnCheckClick(comboObj, index, code) {
	if (index == 0) {
		var bChk = comboObj.CheckIndex(index);
		if (bChk) {
			for ( var i = 1; i < comboObj.GetCount(); i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
}

/**
 * head텍스트 변경
 * @return
 */
function radio_click() {
	var formObject = document.form;
	var val = "";
	for ( var i = 0; i < formObject.locdivision.length; i++) {
		if (formObject.locdivision[i].checked) {
			val = formObject.locdivision[i].value;
		}
	}
	if (val == "O") {

		if (sheetObjects[2].RowCount == 0) {

			tabObjects[0].TabText(2) = "OP LOC - ID LOC";
			sheetObjects[2].CellValue2(0, 0) = "OP LOC";
			sheetObjects[2].CellValue2(0, 1) = "ID LOC";
			sheetObjects[2].CellValue2(1, 0) = "OP LOC";
			sheetObjects[2].CellValue2(1, 1) = "ID LOC";
		}
		document.form.oploc.disabled = false;
		document.form.idloc.disabled = false;
		document.form.pol.disabled = true;
		document.form.pod.disabled = true;
		document.form.pol.value = "";
		document.form.pod.value = "";
		document.getElementById("oploc").className = "input";
		document.getElementById("idloc").className = "input";
		document.getElementById("pol").className = "input2";
		document.getElementById("pod").className = "input2";
		document.getElementById("oploc").focus();

	} else {
		if (sheetObjects[2].RowCount == 0) {
			tabObjects[0].TabText(2) = "POL - POD";
			sheetObjects[2].CellValue2(0, 0) = "POL";
			sheetObjects[2].CellValue2(0, 1) = "POD";
			sheetObjects[2].CellValue2(1, 0) = "POL";
			sheetObjects[2].CellValue2(1, 1) = "POD";
		}
		document.form.oploc.disabled = true;
		document.form.idloc.disabled = true;
		document.form.pol.disabled = false;
		document.form.pod.disabled = false;
		document.form.oploc.value = "";
		document.form.idloc.value = "";
		document.getElementById("oploc").className = "input2";
		document.getElementById("idloc").className = "input2";
		document.getElementById("pol").className = "input";
		document.getElementById("pod").className = "input";
		document.getElementById("pol").focus();
	}
}

function form_keyup() {
	var obj = null;
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	if (keyValue != 13) {
		ComKeyEnter('lengthnextfocus');
	} else {
		obj_deactivate();
	}
}

function reverse_cntr_tpsz_cd_check() {
	var formObject = document.form;
	if (formObject.chk_cntr_tpsz_cd.checked) {
		comboObjects[2].Code = tot_cntr_tpsz_cd.replaceStr("|", ",");
	} else {
		comboObjects[2].Code = "";
	}
}

/**
 * 
 * @return
 */
function obj_locLevelBlur() {
	switch (event.srcElement.name) {
	case "oploc":
		if (event.srcElement.value != "") {
			document.getElementById("inquiryLevel").value = "O";
			document.getElementById("location").value = document.getElementById("oploc").value;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC03, "oploc");
		}

		break;
	case "idloc":
		if (event.srcElement.value != "") {
			document.getElementById("inquiryLevel").value = "O";
			document.getElementById("location").value = document.getElementById("idloc").value;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC03, "idloc");
		}
		break;
	case "pol":
		if (event.srcElement.value != "") {
			document.getElementById("inquiryLevel").value = "P";
			document.getElementById("location").value = document.getElementById("pol").value;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC03, "pol");
		}
		break;
	case "pod":
		if (event.srcElement.value != "") {
			document.getElementById("inquiryLevel").value = "P";
			document.getElementById("location").value = document.getElementById("pod").value;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC03, "pod");
		}
		break;
	}
}

function chkToDateWeekBlur() {
	var period = document.form.period.value;
	var toDate = document.form.tos.value;
	var frDate = document.form.froms.value;

	var toYearDate = toDate.substring(0, 4);
	var frYearDate = frDate.substring(0, 4);
	var toMonthDate = toDate.substring(5, 7);
	var frMonthDate = frDate.substring(5, 7);
	var frDayDate = "";
	var toDayDate = "";

	if (frDate.length > 7) {
		frDayDate = frDate.substring(8, 10);
		toDayDate = toDate.substring(8, 10);

	} else {
		frDayDate = "01";
		toDayDate = lastDay(toYearDate, toMonthDate);
	}

	var frDateFull = new Date(frYearDate, frMonthDate - 1, frDayDate);
	var toDateFull = new Date(toYearDate, toMonthDate - 1, toDayDate);
	var getDiffTime = toDateFull.getTime() - frDateFull.getTime();
	var retDate = Math.floor(getDiffTime / (1000 * 60 * 60 * 24));
	var retMonth = ((parseInt(toYearDate) - parseInt(frYearDate)) * 12 + parseInt(toMonthDate, 10) - parseInt(frMonthDate, 10));
	var retWeek = Math.floor((toDateFull - frDateFull) / (1000 * 60 * 60 * 24 * 7));
	var week = "";
	var fromTo = 52;
	if (period == "M") {
		if (retMonth >= 12) {

			if (event.srcElement.name == "tos") {
				ComShowCodeMessage("CIM21031");
				ComSetFocus(document.getElementById("tos"));
			}
			return false;
		}
	} else if (period == "W") {
		if (frYearDate == toYearDate) {
			week = eval(toMonthDate) - eval(frMonthDate) + 1;
		} else {
			betwMonth = fromTo - eval(frMonthDate) + eval(toMonthDate) + 1;
			if ((eval(toYearDate) - eval(frYearDate)) == 1) { //in case of 1 year gap
				week = betwMonth;
			} else {
				week = (eval(toYearDate) - eval(frYearDate) - 1) * fromTo + betwMonth;
			}
		}

		if (week > 26) {

			if (event.srcElement.name == "tos") {
				ComShowCodeMessage("CIM21031");
				ComSetFocus(document.getElementById("tos"));
			}
			return false;
		}
	} else if (period == "D") {
		if (retDate >= 31) {

			if (event.srcElement.name == "tos") {

				ComShowCodeMessage("CIM29029");
				ComSetFocus(document.getElementById("tos"));
			}
			return false;
		}
	}
}

//handling Axon event
function obj_deactivate() {

	var f = document.getElementById("froms");
	var t = document.getElementById("tos");
	sVal1 = f.value.replace(/\/|\-|\./g, "");
	sVal2 = t.value.replace(/\/|\-|\./g, "");

	switch (event.srcElement.name) {
	case "froms":
		if (ComChkObjValid(event.srcElement, false)) {

			if (f.getAttribute("dataformat") == "ym") {
				if (sVal1 != "" && sVal2 != "") {
					var day = lastDay(sVal2.substring(0, 4), sVal2.substring(4, 6));
					var flag = ComChkPeriod(sVal1 + "01", sVal2 + day);

					if (flag < 1) {
						//ComShowCodeMessage("CIM29004");
						enterSwitch = false;
						t.value = "";
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch = false;
							t.value = "";
							t.focus();
							t.select();
							return false;
						}
					}
					document.getElementById("from").value = sVal1 + "01";
					document.getElementById("to").value = sVal2 + day;
				}

			} else { // retrieving by week
				if (sVal1 != "" && sVal2 != "") {
					if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
						ComShowCodeMessage("CIM29003");
						enterSwitch = false;
						t.value = "";
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch = false;
							t.value = "";
							t.focus();
							t.select();
							return false;
						}
					}
					document.getElementById("from").value = sVal1;
					document.getElementById("to").value = sVal2;
				}
			}

		} else {
			if (f.getAttribute("dataformat") == "ym") {
				if (sVal1.length > 0 && !ComIsMonth(sVal1.substring(4, 6)) && event.srcElement.name == 'froms') {

					event.srcElement.value = "";
					ComShowCodeMessage("CIM21004", "YYYYMM");
					enterSwitch = false;
					event.srcElement.focus();
					event.srcElement.select();
					return false;
				}
			} else { // retrieving by week

				if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6)) && event.srcElement.name == 'froms') {
					event.srcElement.value = "";
					ComShowCodeMessage("CIM21004", "YYYYWW");
					event.srcElement.focus();
					event.srcElement.select();
					enterSwitch = false;

					return false;
				}
			}
		}

		break;
	case "tos":
		if (ComChkObjValid(event.srcElement, false)) {

			if (t.getAttribute("dataformat") == "ym") {

				var day = lastDay(sVal2.substring(0, 4), sVal2.substring(4, 6));

				if (sVal1 != "" && sVal2 != "") {
					var flag = ComChkPeriod(sVal1 + "01", sVal2 + day);
					if (flag < 1) {
						if (event.srcElement.name == "tos") {
							ComShowCodeMessage("CIM29004");
						}
						enterSwitch = false;
						event.srcElement.value = "";
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch = false;
							event.srcElement.value = "";
							t.focus();
							t.select();
							return false;
						}
					}
				}

				document.getElementById("from").value = sVal1 + "01";
				document.getElementById("to").value = sVal2 + day;
			} else { // retrieving by week
				if (sVal1 != "" && sVal2 != "") {
					if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
						if (event.srcElement.name == "tos") {
							ComShowCodeMessage("CIM29003");
						}
						enterSwitch = false;
						event.srcElement.value = "";
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch = false;
							event.srcElement.value = "";
							t.focus();
							t.select();
							return false;
						}
					}
				}
				document.getElementById("from").value = sVal1;
				document.getElementById("to").value = sVal2;
			}
			enterSwitch = true;
		} else {
			if (t.getAttribute("dataformat") == "ym") {
				if (sVal2.length > 0 && !ComIsMonth(sVal2.substring(4, 6))) {
					enterSwitch = false;
					event.srcElement.value = "";
					ComShowCodeMessage("CIM21004", "YYYYMM");
					t.focus();
					t.select();
					return false;
				}
			} else { // retrieving by week

				if (sVal2.length > 0 && !ComIsWeek(sVal2.substring(4, 6))) {
					enterSwitch = false;
					event.srcElement.value = "";
					ComShowCodeMessage("CIM21004", "YYYYWW");
					t.focus();
					t.select();
					return false;
				}
			}
		}

		break;
	}
	return true;
}

function lastDay(y, m) {
	var d, d2, s = "";
	d = new Date();
	d2 = new Date(y, m, "");
	s = d2.getDate();
	return (s);
}

/**
 * form focus event
 * @return
 */
function obj_activate() {
	ComClearSeparator(event.srcElement);
	ComSetFocus(event.srcElement);
}

/**
 * trade change event
 * @return
 */
function trade_OnChange() {
	comboObjects[1].RemoveAll();
}

/**
 * 
 * @return
 */
function trade_OnFocus() {
	comboObjects[1].Enable = true;
	if (comboObjects[1].GetCount() <= 0) {

		//	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	}
}

/**
 * trade focus out event
 * @param KeyCode
 * @param Shift
 * @return
 */
function trade_OnBlur(KeyCode, Shift) {
	flag = false;
	if (comboObjects[0].Text.length > 0) {
		comboObjects[0].UseCode = false;
		comboObjects[0].Text2 = comboObjects[0].Text.toUpperCase();
		for ( var i = 0; i < comboObjects[0].GetCount(); i++) {

			if (comboObjects[0].Text == comboObjects[0].GetText(i, 0)) {
				var code = comboObjects[0].getText(i, 0);

				flag = true;
				comboObjects[0].UseCode = true;
				//	comboObjects[1].RemoveAll();
				//	trades_OnChange();

				break;
			}
		}
		if (flag == false) {
			ComShowCodeMessage("CIM29028");
			comboObjects[1].RemoveAll();
			comboObjects[0].Text = "";
			comboObjects[0].focus();

			return true;
		} else {
			comboObjects[1].Enable = true;
		}

	} else {
		//trades_OnChange();
	}

}

function lane_OnBlur(KeyCode, Shift) {
	if (comboObjects[1].Text.length > 0) {
		comboObjects[1].UseCode = false;
		comboObjects[1].Text = comboObjects[1].Text.toUpperCase();

		for ( var i = 0; i < comboObjects[1].GetCount(); i++) {

			if (comboObjects[1].Text == comboObjects[1].GetText(i, 0)) {

				flag = true;
				comboObjects[1].UseCode = true;
				break;
			}
		}
		if (flag == false) {
			ComShowCodeMessage("CIM29012");
			comboObjects[1].Text = "";
			comboObjects[1].focus();

			return true;
		}
		flag = false;
		//comboObjects[2].focus();
	}
}

/**
 * 
 * @return
 */
function lane_OnFocus(comboObj) {
	var f = document.form;
	flag = false;

	if (comboObjects[1].GetCount() <= 0) {
		comboObj.Enable = false;
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
		if (comboObjects[1].GetCount() > 0) {
			comboObj.Enable = true;
			comboObjects[1].focus();
		}

	}

}

function setDate() {
	var today = new Date();
	var y = today.getFullYear().toString();
	var m = (today.getMonth() + 1).toString();
	if (m.length == 1) {
		m = 0 + m;
	}
	var ym = y + '-' + m;
	document.form.froms.value = ym;
	document.form.tos.value = ym;
	var day = lastDay(y, m);
	document.form.from.value = y + m + "01";
	document.form.to.value = y + m + day;
}

function obj_keypress() {
	switch (event.srcElement.name) {
	case "oploc":
		ComKeyOnlyAlphabet('upper');// upper case only
		break;
	case "idloc":
		ComKeyOnlyAlphabet('upper');// upper case only
		break;
	case "pol":
		ComKeyOnlyAlphabet('upper');// upper case only
		break;
	case "pod":
		ComKeyOnlyAlphabet('upper');// upper case only
		break;
	case "froms":
		// permitting to input "-" in case of numbers only
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "tos":
		// permitting to input "-" in case of numbers only
		ComKeyOnlyNumber(event.srcElement);
		break;
	}

}

function obj_change() {

	obj = event.srcElement;
	if (obj.name == "period") {
		if (obj.value == "M") {
			document.getElementById("froms").setAttribute("dataformat", "ym");
			document.getElementById("tos").setAttribute("dataformat", "ym");

			document.form.froms.value = "";
			document.form.tos.value = "";
			document.form.from.value = "";
			document.form.to.value = "";
			ComSetFocus(document.form.froms);
		} else {
			document.getElementById("froms").setAttribute("dataformat", "yw");
			document.getElementById("tos").setAttribute("dataformat", "yw");

			document.form.froms.value = "";
			document.form.tos.value = "";
			document.form.from.value = "";
			document.form.to.value = "";
			ComSetFocus(document.form.froms);
		}
	}
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {

	case "t1sheet1": //sheet1 init
		with (sheetObj) {

			//setting height
			style.height = 380;
			//setting width
			SheetWidth = mainTable.clientWidth;

			//setting Host information [mandatory][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//Merge kind [optional, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			//Edit kind [optional, Default false]
			Editable = false;
			CountPosition = 0;
			//setting Row information [mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 12, 100);

			var HeadTitle1 = "Trade|Lane|Turn Around Time per Shipment (fm OP to Next OP)|Turn Around Time per Shipment (fm OP to Next OP)|Turn Around Time per Shipment (fm OP to Next OP)";
			HeadTitle1 += "|Turn Around Time per Shipment (fm OP to Next OP)|Turn Around Time per Shipment (fm OP to Next OP)|Turn Around Time per Shipment (fm OP to Next OP)|Turn Around Time per Shipment (fm OP to Next OP)|Turn Around Time per Shipment (fm OP to Next OP)|EQ Utilization|Volume";

			var HeadTitle2 = "Trade|Lane|Total|O/B Full Land|Full Trunk Sea|Full T/S Land|Full T/S Sea|I/B Full Land|MTY Land|MTY Sea|EQ Utilization|Volume";

			var headCount = ComCountHeadTitle(HeadTitle2);
			//alert(headCount);             

			//setting Column information [mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			//setting function handling header
			InitHeadMode(true, true, false, true, false, false)

			//setting header Row information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//data property [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

			InitDataProperty(0, cnt++, dtData, 60, daCenterTop, true, "loccode1", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "loccode2", false, "", dfNone);

			InitDataProperty(0, cnt++, dtAutoSum, 70, daRight, true, "total", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 80, daRight, true, "obfulllandtime", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 90, daRight, true, "fullseatime", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 80, daRight, true, "tslandtime", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 80, daRight, true, "tsseatime", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 80, daRight, true, "ibfulllandtime", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 80, daRight, true, "mtylandtime", false, "", dfNullFloat, 0);

			InitDataProperty(0, cnt++, dtAutoSum, 80, daRight, true, "mtyseatime", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 90, daRight, true, "eq", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daRight, true, "cntrvolume", false, "", dfNullInteger, 0);
		}
		break;

	case "t2sheet1": //sheet1 init
		with (sheetObj) {

			//setting height
			style.height = 380;
			//setting width
			SheetWidth = mainTable.clientWidth;

			//setting Host information [mandatory][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//Merge kind [optional, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			//Edit kind [optional, Default false]
			Editable = false;
			CountPosition = 0;
			//setting Row information [mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 12, 100);

			var HeadTitle1 = "TP/SZ|Trade|Turn Around Time per Shipment (fm OP to Next OP)|Turn Around Time per Shipment (fm OP to Next OP)|Turn Around Time per Shipment (fm OP to Next OP)";
			HeadTitle1 += "|Turn Around Time per Shipment (fm OP to Next OP)|Turn Around Time per Shipment (fm OP to Next OP)|Turn Around Time per Shipment (fm OP to Next OP)|Turn Around Time per Shipment (fm OP to Next OP)|Turn Around Time per Shipment (fm OP to Next OP)|EQ Utilization|Volume";

			var HeadTitle2 = "TP/SZ|Trade|Total|O/B Full Land|Full Trunk Sea|Full T/S Land|Full T/S Sea|I/B Full Land|MTY Land|MTY Sea|EQ Utilization|Volume";

			var headCount = ComCountHeadTitle(HeadTitle2);
			//alert(headCount);             

			//setting Column information [mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			//setting function handling header
			InitHeadMode(true, true, false, true, false, false)

			//setting header Row information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//data property [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 70, daCenterTop, true, "loccode1", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "loccode2", false, "", dfNone);

			InitDataProperty(0, cnt++, dtAutoSum, 70, daRight, true, "total", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 80, daRight, true, "obfulllandtime", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 90, daRight, true, "fullseatime", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 80, daRight, true, "tslandtime", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 80, daRight, true, "tsseatime", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 80, daRight, true, "ibfulllandtime", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 80, daRight, true, "mtylandtime", false, "", dfNullFloat, 0);

			InitDataProperty(0, cnt++, dtAutoSum, 80, daRight, true, "mtyseatime", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 90, daRight, true, "eq", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daRight, true, "cntrvolume", false, "", dfNullInteger, 0);

		}
		break;

	case "t3sheet1": //sheet1 init
		with (sheetObj) {

			//setting height
			style.height = 380;
			//setting width
			SheetWidth = mainTable.clientWidth;

			//setting Host information [mandatory][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//Merge kind [optional, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			//Edit kind [optional, Default false]
			Editable = false;
			CountPosition = 0;
			//setting Row information [mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 12, 100);

			var HeadTitle1 = "OP LOC|ID LOC|Turn Around Time per Shipment (fm OP to Next OP)|Turn Around Time per Shipment (fm OP to Next OP)|Turn Around Time per Shipment (fm OP to Next OP)";
			HeadTitle1 += "|Turn Around Time per Shipment (fm OP to Next OP)|Turn Around Time per Shipment (fm OP to Next OP)|Turn Around Time per Shipment (fm OP to Next OP)|Turn Around Time per Shipment (fm OP to Next OP)|Turn Around Time per Shipment (fm OP to Next OP)|EQ Utilization|Volume";

			var HeadTitle2 = "OP LOC|ID LOC|Total|O/B Full Land|Full Trunk Sea|Full T/S Land|Full T/S Sea|I/B Full Land|MTY Land|MTY Sea|EQ Utilization|Volume";

			var headCount = ComCountHeadTitle(HeadTitle1);
			//alert(headCount);             

			//setting Column information [mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			//setting function handling header
			InitHeadMode(true, true, false, true, false, false)

			//setting header Row information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//data property [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 60, daCenterTop, true, "loccode1", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 90, daCenterTop, true, "loccode2", false, "", dfNone);

			InitDataProperty(0, cnt++, dtAutoSum, 70, daRight, true, "total", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 80, daRight, true, "obfulllandtime", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 90, daRight, true, "fullseatime", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 80, daRight, true, "tslandtime", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 80, daRight, true, "tsseatime", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 80, daRight, true, "ibfulllandtime", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 80, daRight, true, "mtylandtime", false, "", dfNullFloat, 0);

			InitDataProperty(0, cnt++, dtAutoSum, 80, daRight, true, "mtyseatime", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 90, daRight, true, "eq", false, "", dfNullFloat, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daRight, true, "cntrvolume", false, "", dfNullInteger, 0);
		}
		break;

	}
}

//handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction, gubun) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH:
		isOpen = true;
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;

			sheetObj.doSearch4Post("EES_CIM_1014GS.do", FormQueryString(formObj));

			sheetObj.WaitImageVisible = true;
			ComOpenWait(false);

		} else {
			return;
		}
		break;
	case IBSEARCH_ASYNC01: 
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH04;
			//	var sXml = sheetObj.GetSearchXml("EES_CIM_1014GS.do",FormQueryString(formObj));
			var sXml = formObj.sXml.value;
			var sTpsz = ComGetEtcData(sXml, "sTpsz");
			tot_cntr_tpsz_cd = sTpsz;
			if (sTpsz != undefined) {
				var arrTpsz = sTpsz.split("|");

				MakeComboObject(formObj.tpsz, arrTpsz);
			}
			var sTrade = ComGetEtcData(sXml, "sTrade");
			if (sTrade != undefined) {
				var arrTrade = sTrade.split(",");

				MakeComboObject2(formObj.trade, arrTrade);
			}
		}
		break;

	case IBSEARCH_ASYNC02: //retrieving by trade
		if (validateForm(sheetObj, formObj, sAction)) {

			formObj.f_cmd.value = SEARCH05;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_1014GS.do", FormQueryString(formObj));

			var sLane = ComGetEtcData(sXml, "sLane");
			if (sLane != undefined) {
				var arrLane = sLane.split(",");

				MakeComboObject2(formObj.lane, arrLane);
			}
			//sheetObj.LoadSearchXml(sXml);
			sheetObj.WaitImageVisible = true;
		}
		break;
	case IBSEARCH_ASYNC03: //location focusOut
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH02;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_1001GS.do", FormQueryString(formObj));
			var sCheck = ComGetEtcData(sXml, "check");
			var locdivision = "";
			for ( var i = 0; i < formObj.locdivision.length; i++) {
				if (formObj.locdivision[i].checked) {
					locdivision = formObj.locdivision[i].value;
				}
			}
			if (sCheck != "OK") {
				if (locdivision == "O") {
					ComShowCodeMessage("CIM29024");
					if (gubun == "oploc") {
						formObj.oploc.value = "";
						ComSetFocus(formObj.oploc);
					} else if (gubun == "idloc") {
						formObj.idloc.value = "";
						ComSetFocus(formObj.idloc);
					}
				} else if (locdivision == "P") {
					ComShowCodeMessage("CIM29010");
					if (gubun == "pol") {
						formObj.pol.value = "";
						ComSetFocus(formObj.pol);
					} else if (gubun == "pod") {
						formObj.pod.value = "";
						ComSetFocus(formObj.pod);
					}
				}
				return false;
			} else {
				if (locdivision == "O") {
					if (gubun == "oploc") {
						ComSetFocus(formObj.idloc);
					} else if (gubun == "idloc") {
						ComSetFocus(formObj.tscntr);
					}
				} else if (locdivision == "P") {
					if (gubun == "pol") {
						ComSetFocus(formObj.pod);
					} else if (gubun == "pod") {
						ComSetFocus(formObj.tscntr);
					}
				}

			}
		} else {
			return;
		}
		sheetObj.WaitImageVisible = true;
		break;
	}
}

function doActionIBSheet2(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	isOpen = true;
	switch (sAction) {

	case IBSEARCH:

		isOpen = true;
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH02;

			sheetObj.doSearch4Post("EES_CIM_1014GS.do", FormQueryString(formObj));
			sheetObj.WaitImageVisible = true;
			ComOpenWait(false);
		} else {
			return;
		}
		break;
	}
}

function doActionIBSheet3(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	isOpen = true;
	switch (sAction) {

	case IBSEARCH:

		isOpen = true;
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH03;

			//	sheetObj.Reset();
			//	initSheet(sheetObj, 3);
			sheetObj.doSearch4Post("EES_CIM_1014GS.do", FormQueryString(formObj));

			var val = "";
			for ( var i = 0; i < document.form.locdivision.length; i++) {
				if (document.form.locdivision[i].checked) {
					val = document.form.locdivision[i].value;
				}
			}
			if (val == "O") {
				if (document.form.oploc.value == "" && document.form.idloc.value != "") {
					tabObjects[0].TabText(2) = "ID LOC - OP LOC";
					sheetObjects[2].CellValue2(0, 0) = "ID LOC";
					sheetObjects[2].CellValue2(0, 1) = "OP LOC";
					sheetObjects[2].CellValue2(1, 0) = "ID LOC";
					sheetObjects[2].CellValue2(1, 1) = "OP LOC";
				} else {
					tabObjects[0].TabText(2) = "OP LOC - ID LOC";
					sheetObjects[2].CellValue2(0, 0) = "OP LOC";
					sheetObjects[2].CellValue2(0, 1) = "ID LOC";
					sheetObjects[2].CellValue2(1, 0) = "OP LOC";
					sheetObjects[2].CellValue2(1, 1) = "ID LOC";
				}
				document.form.oploc.disabled = false;
				document.form.idloc.disabled = false;
				document.form.pol.disabled = true;
				document.form.pod.disabled = true;
				document.form.pol.value = "";
				document.form.pod.value = "";
				document.getElementById("oploc").className = "input";
				document.getElementById("idloc").className = "input";
				document.getElementById("pol").className = "input2";
				document.getElementById("pod").className = "input2";

			} else {
				if (document.form.pol.value == "" && document.form.pod.value != "") {
					tabObjects[0].TabText(2) = "POD - POL";
					sheetObjects[2].CellValue2(0, 0) = "POD";
					sheetObjects[2].CellValue2(0, 1) = "POL";
					sheetObjects[2].CellValue2(1, 0) = "POD";
					sheetObjects[2].CellValue2(1, 1) = "POL";
				} else {
					tabObjects[0].TabText(2) = "POL - POD";
					sheetObjects[2].CellValue2(0, 0) = "POL";
					sheetObjects[2].CellValue2(0, 1) = "POD";
					sheetObjects[2].CellValue2(1, 0) = "POL";
					sheetObjects[2].CellValue2(1, 1) = "POD";
				}
				document.form.oploc.disabled = true;
				document.form.idloc.disabled = true;
				document.form.pol.disabled = false;
				document.form.pod.disabled = false;
				document.form.oploc.value = "";
				document.form.idloc.value = "";
				document.getElementById("oploc").className = "input2";
				document.getElementById("idloc").className = "input2";
				document.getElementById("pol").className = "input";
				document.getElementById("pod").className = "input";
			}
			sheetObj.WaitImageVisible = true;
			ComOpenWait(false);

		} else {
			return;
		}
		break;
	}
}

function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
	case "trade":
		with (comboObj) {
			SetColAlign("center|left");
			SetColWidth("50|170");
			SetTitle("Trade|Description");
			MultiSelect = false;
			UseAutoComplete = true;
			DropHeight = 200;
			ValidChar(2, 0);
			MaxLength = 3;
		}
		break;

	case "lane":
		with (comboObj) {
			SetColAlign("center|left");
			SetColWidth("50|200");
			SetTitle("lane|Description");
			MultiSelect = false;
			UseAutoComplete = true;
			DropHeight = 200;
			ValidChar(2, 0);
			MaxLength = 3;
		}
		break;

	case "tpsz":
		with (comboObj) {
			//BackColor = "#CCFFFF";
			DropHeight = 320;
			MultiSelect = true;
			MultiSeparator = ",";
		}
		break;
	}
}

function MakeComboObject(cmbObj, arrStr) {
	cmbObj.InsertItem(0, 'ALL', '');
	for ( var i = 1; i <= arrStr.length; i++) {
		cmbObj.InsertItem(i, arrStr[i - 1], arrStr[i - 1]);
	}
}

function MakeComboObject2(cmbObj, arrStr) {
	for ( var i = 0; i < arrStr.length; i++) {
		cmbObj.InsertItem(i, arrStr[i], arrStr[i].substring(0, 3).trim());
	}
}

/**
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;

}

/**
 * initializing Tab
 * setting Tab items
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertTab(cnt++, "Trade-Lane", -1);
			InsertTab(cnt++, "TP/SZ-Trade", -1);
			InsertTab(cnt++, "OP LOC - ID LOC", -1);
		}
		break;

	}
}

/**
 * event when clicking Tab
 * activating selected tab items
 */
function tab1_OnChange(tabObj, nItem) {

	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	//--------------- important --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	//------------------------------------------------------//
	beforetab = nItem;
	tabIndex = nItem;

	if (nItem == 2) {
		document.getElementById("se").style.display = "";
		document.getElementById("se2").style.display = "none";
	} else {
		document.getElementById("se").style.display = "none";
		document.getElementById("se2").style.display = "";
	}
}

/**
 * event when clicking Tab
 * activating selected tab items
 */
function tab1_OnClick(tabObj, nItem) {
	beforetab = nItem;
	tabIndex = nItem;
	if (isOpen) {
		if (nItem == 0) {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			sheetObjects[0].SelectRow = 0;
		} else if (nItem == 1) {
			doActionIBSheet2(sheetObjects[1], document.form, IBSEARCH);
			sheetObjects[1].SelectRow = 0;
		} else {
			ComSetFocus(document.form.froms);
		}
	}

}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (sAction == IBSEARCH) {
			if (period.value == "M") {
				if (froms.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(froms);
					return false;
				} else if (tos.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(tos);
					return false;
				}

			} else if (period.value == "W") {
				if (froms.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(froms);
					return false;
				} else if (tos.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(tos);
					return false;
				}

			}
			if (froms.value.length < 6) {
				return false;
			} else if (tos.value.length < 6) {
				return false;
			}
			if (!enterSwitch) {
				return false;
			}

		}

	}

	return true;
}

function t1sheet1_OnChangeSum(sheetObj, Row) {
	with (sheetObj) {
		SumText(0, 0) = "Total Average";
		CellAlign(LastRow, 0) = daCenter;
	}

}

function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {

		SumText(0, "total") = CellValue(RowCount + 1, "total");

		SumText(0, "obfulllandtime") = CellValue(RowCount + 1, "obfulllandtime");
		SumText(0, "fullseatime") = CellValue(RowCount + 1, "fullseatime");
		SumText(0, "tslandtime") = CellValue(RowCount + 1, "tslandtime");
		SumText(0, "tsseatime") = CellValue(RowCount + 1, "tsseatime");
		SumText(0, "ibfulllandtime") = CellValue(RowCount + 1, "ibfulllandtime");
		SumText(0, "mtylandtime") = CellValue(RowCount + 1, "mtylandtime");
		SumText(0, "mtyseatime") = CellValue(RowCount + 1, "mtyseatime");
		SumText(0, "eq") = CellValue(RowCount + 1, "eq");
		SumText(0, "cntrvolume") = ComAddComma2(CellValue(RowCount + 1, "cntrvolume"), "#,###");
		MessageText("SubSum") = "";

		if (RowCount > 0) {
			RowHidden(RowCount + 1) = true;

			SetMergeCell(LastRow, 0, 1, 2);
		}

	}
}

function t2sheet1_OnChangeSum(sheetObj, Row) {
	with (sheetObj) {
		SumText(0, 0) = "Total Average";
		CellAlign(LastRow, 0) = daCenter;
	}

}

function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		SumText(0, "total") = CellValue(RowCount + 1, "total");

		SumText(0, "obfulllandtime") = CellValue(RowCount + 1, "obfulllandtime");
		SumText(0, "fullseatime") = CellValue(RowCount + 1, "fullseatime");
		SumText(0, "tslandtime") = CellValue(RowCount + 1, "tslandtime");
		SumText(0, "tsseatime") = CellValue(RowCount + 1, "tsseatime");
		SumText(0, "ibfulllandtime") = CellValue(RowCount + 1, "ibfulllandtime");
		SumText(0, "mtylandtime") = CellValue(RowCount + 1, "mtylandtime");
		SumText(0, "mtyseatime") = CellValue(RowCount + 1, "mtyseatime");
		SumText(0, "eq") = CellValue(RowCount + 1, "eq");
		SumText(0, "cntrvolume") = ComAddComma2(CellValue(RowCount + 1, "cntrvolume"), "#,###");
		MessageText("SubSum") = "";

		if (RowCount > 0) {
			RowHidden(RowCount + 1) = true;

			SetMergeCell(LastRow, 0, 1, 2);
		}

	}
}

function t3sheet1_OnChangeSum(sheetObj, Row) {
	with (sheetObj) {
		SumText(0, 0) = "Total Average";
		CellAlign(LastRow, 0) = daCenter;
	}

}

function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		SumText(0, "total") = CellValue(RowCount + 1, "total");

		SumText(0, "obfulllandtime") = CellValue(RowCount + 1, "obfulllandtime");
		SumText(0, "fullseatime") = CellValue(RowCount + 1, "fullseatime");
		SumText(0, "tslandtime") = CellValue(RowCount + 1, "tslandtime");
		SumText(0, "tsseatime") = CellValue(RowCount + 1, "tsseatime");
		SumText(0, "ibfulllandtime") = CellValue(RowCount + 1, "ibfulllandtime");
		SumText(0, "mtylandtime") = CellValue(RowCount + 1, "mtylandtime");
		SumText(0, "mtyseatime") = CellValue(RowCount + 1, "mtyseatime");
		SumText(0, "eq") = CellValue(RowCount + 1, "eq");
		SumText(0, "cntrvolume") = ComAddComma2(CellValue(RowCount + 1, "cntrvolume"), "#,###");
		MessageText("SubSum") = "";

		if (RowCount > 0) {
			RowHidden(RowCount + 1) = true;
			SetMergeCell(LastRow, 0, 1, 2);
		}

	}
}

/* end of developer job */