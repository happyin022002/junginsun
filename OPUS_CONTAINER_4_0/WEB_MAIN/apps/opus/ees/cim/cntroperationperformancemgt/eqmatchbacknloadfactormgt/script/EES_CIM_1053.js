/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_cim_1053.js
 *@FileTitle : CIM Batch Job Status
 *Open Issues :
 *Change history :
 *@LastModifyDate :
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
 * @class ees_cim_1053 :  business script for ees_cim_1053 
 */
function ees_cim_1053() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* developer job   */
// common global variables
var sheetObjects = new Array();
var sheetCnt = 0;

var oldCntrTypeSize = "";
var sCntrTypeSize = "";
var isOpen = false;

//Event handler processing by button click event */
document.onclick = processButtonClick;

//Event handler processing by button name */
function processButtonClick() {
	

	var shtCnt = 0;
	var t1sheet1 = sheetObjects[shtCnt++];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			doActionIBSheet(t1sheet1, formObject, IBSEARCH);
			sheetObjects[0].SelectRow = 0;
			break;

		case "btn_new":
			t1sheet1.RemoveAll();
			formObject.reset();
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
			document.getElementById("froms").focus();
			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
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
* registering IBCombo Object as list
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
	for (i = 0; i < sheetObjects.length; i++) {
		
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		
		ComEndConfigSheet(sheetObjects[i]);
	}
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerFormat('keyup', 'form_keyup', form);
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); //- form OnBeforeDeactivate이벤트에 코드 처리
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	document.getElementById("froms").focus();
}

function obj_activate() {
	ComClearSeparator(event.srcElement);
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
					document.getElementById("fromz").value = sVal1 + "01";
					document.getElementById("toz").value = sVal2 + day;
				}
			} else { // retrieving by week
				if (sVal1 != "" && sVal2 != "") {
					if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
						//ComShowCodeMessage("CIM29003");
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
					document.getElementById("fromz").value = sVal1;
					document.getElementById("toz").value = sVal2;
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
				document.getElementById("fromz").value = sVal1 + "01";
				document.getElementById("toz").value = sVal2 + day;
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
				document.getElementById("fromz").value = sVal1;
				document.getElementById("toz").value = sVal2;
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
	var day = "31";
	document.form.from.value = y + m + "01";
	document.form.to.value = y + m + day;
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

	case "t1sheet1":
		with (sheetObj) {
			//setting height
			style.height = 435;
			//setting width
			SheetWidth = mainTable.clientWidth;

			//setting Host information [mandatory][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//Merge kind [optional, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			//Edit kind [optional, Default false]
			Editable = false;

			//setting Row information [mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "||Turn Time|Turn Time|Turn Time|Turn Time|Match-Back|Match-Back|Match-Back|Reposition|Reposition";
			var HeadTitle2 = "Week|Date|Port T/T|Location T/T|Shipment T/T|Movement T/T|Port M/B|Location M/B|BKG M/B|Port Repo|Location Repo";

			var headCount = ComCountHeadTitle(HeadTitle1);

			//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// setting function handling header
			InitHeadMode(true, true, false, true, false, false);

			//setting header Row information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			sheetObj.FrozenCols = 2;

			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "wk", false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "dt", false, "", dfDateYmd, 0);

			InitDataProperty(0, cnt++, dtImage, 80, daCenter, true, "tp", false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtImage, 90, daCenter, true, "tl", false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtImage, 100, daCenter, true, "ts", false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtImage, 100, daCenter, true, "tm", false, "", dfNone, 0);

			InitDataProperty(0, cnt++, dtImage, 80, daCenter, true, "mp", false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtImage, 90, daCenter, true, "ml", false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtImage, 80, daCenter, true, "mb", false, "", dfNone, 0);
//			InitDataProperty(0, cnt++, dtImage, 95, daCenter, true, "md", false, "", dfNone, 0);

			InitDataProperty(0, cnt++, dtImage, 80, daCenter, true, "rp", false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtImage, 80, daCenter, true, "rl", false, "", dfNone, 0);
//			InitDataProperty(0, cnt++, dtImage, 90, daCenter, true, "rd", false, "", dfNone, 0);

			ImageList(0) = "/opuscntr/img/btng_icon_b.gif";
			ImageList(1) = "/opuscntr/img/btng_icon_green.gif";
			ImageList(2) = "/opuscntr/img/btng_icon_g.gif";

			CountPosition = 0;

		}
		break;
	}
}

//handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case IBSEARCH: 
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("EES_CIM_1053GS.do", FormQueryString(formObj));
			sheetObj.RemoveAll()
			initSheet(sheetObj);
			sheetObj.LoadSearchXml(sXml);
			
			sheetObj.WaitImageVisible = true;
			ComOpenWait(false);
		} else {
			return;
		}
		break;

	case IBSEARCH_ASYNC01: 
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("EES_CIM_1053GS.do", FormQueryString(formObj));
			var Param1 = ComGetEtcData(sXml, "wf");
			var Param2 = ComGetEtcData(sXml, "wt");
			document.form.froms.value = Param1.substring(0, 4) + "-" + Param1.substring(4, 6);
			document.form.tos.value = Param2.substring(0, 4) + "-" + Param2.substring(4, 6);
			sheetObj.RemoveAll()
			initSheet(sheetObj);
			//sheetObj.LoadSearchXml(sXml);
		} else {
			return;
		}
		break;
	}
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (sAction != IBSEARCH_ASYNC01) {
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
		}
	}
	return true;
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

function obj_keypress() {
	switch (event.srcElement.name) {
	case "location":
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

function sheet1_OnChangeSum(sheetObj, Row) {
	with (sheetObj) {

	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		SelectRow = 0;
	}
}

function lastDay(y, m) {
	var d, d2, s = "";
	d = new Date();
	d2 = new Date(y, m, "");
	s = d2.getDate();
	return (s);
}

function setDateToday() {
	var today = new Date();
	var y = today.getFullYear().toString();
	var m = (today.getMonth() + 1).toString();
	if (m.length == 1) {
		m = 0 + m;
	}
	var ym = y + '-' + m;
	var day = lastDay(y, m);
	document.form.fromz.value = y + m + "01";
	document.form.toz.value = y + m + day;
}

/* end of developer job */