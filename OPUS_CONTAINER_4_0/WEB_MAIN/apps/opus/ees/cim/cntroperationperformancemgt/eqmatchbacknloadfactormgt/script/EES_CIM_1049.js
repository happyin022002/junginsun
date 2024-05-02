/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_cim_1049.js
 *@FileTitle : Load Factor by Trade
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
 * @class ees_cim_1049 : business script for ees_cim_1049 
 */
function ees_cim_1049() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* developer job */

// common global job
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var IBSEARCH02 = 30;
var enterSwitch = false;

//Event handler processing by button click event */
document.onclick = processButtonClick;

//Event handler processing by button name */
function processButtonClick() {
	

	var sheetObject1 = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			sheetObjects[0].SelectRow = 0;
			break;

		case "btn_New":
			sheetObject1.RemoveAll();
			formObject.reset();

			ComSetFocus(formObject.fromdate);
			break;

		case "btns_calendarfm":

			var cal = new ComCalendarFromTo();
			cal.select(formObject.fromdate, formObject.todate, 'yyyy-MM-dd');

			break;
		case "btns_calendarto":

			var cal = new ComCalendarFromTo();
			cal.setEndFunction("nextFocusOut");
			cal.select(formObject.fromdate, formObject.todate, 'yyyy-MM-dd');

			break;
		case "btn_lane": //retrieving lane popup
			var param = "?lane_cd=" + formObject.lane.value;
			ComOpenPopup("/opuscntr/COM_ENS_081.do", 755, 450, "popupFinish", "1,0,1,1,1,1,1,1", true);
			break;
		case "btn_vvd": //retrieving vvd popup
			var param = "?vvd_cd=" + formObject.vvd.value;
			ComOpenPopup("/opuscntr/COM_ENS_0B2.do", 755, 450, "popupFinish", "1,0,1,1,1,1,1,1", true);
			break;
		case "btn_Rdr":
			// in case of activated button
			if (ComIsBtnEnable(srcName)) {
				var sUrl = "/opuscntr/VOP_OPF_0045.do?" + "vsl_cd=" + sheetObject1.Cellvalue(sheetObject1.SelectRow, "vvd").substring(0, 4) + "&voy_no="
						+ sheetObject1.Cellvalue(sheetObject1.SelectRow, "vvd").substring(4, 8) + "&dir_cd="
						+ sheetObject1.Cellvalue(sheetObject1.SelectRow, "vvd").substring(8, 9) + "&region="
						+ sheetObject1.Cellvalue(sheetObject1.SelectRow, "fromregion");
				//ComOpenPopup(sUrl, 1024, 670, "", "0,0", false);
				
				ComOpenPopupWithTarget(sUrl, 1024, 670, "", "0,0", true, "yes");

			}
			break;

		case "btn_LRange":
			// in case of activated button
			if (ComIsBtnEnable(srcName)) {
				var sUrl = "/opuscntr/VOP_VSK_0012.do";
				ComOpenPopupWithTarget(sUrl, 1020, 710, "", "0,0", true, "yes");

			}
			break;
		case "btn_DownExcel":
			sheetObject1.Down2Excel(-1);
			break;

		case "btn_Print":
			if (sheetObject1.rowcount == 0) {
				errMsg = 'No data found.';
				ComShowMessage(msgs["CIM29030"]);
				return;
			}
			formObject.f_cmd.value = IBSEARCH02;
			ComOpenPopupWithTarget('/opuscntr/EES_CIM_1949.do', 775, 700, "", "0,1,1,1,1,1,1", true);
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

function nextFocusOut() {
	document.form.trade.focus();
}

/**
 * setting selected value form lane code popup
 */
function popupFinish(aryPopupData, row, col, sheetIdx) {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	formObject.lane.value = aryPopupData[0][3]
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
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
	initControl();

}

function initControl() {

	document.form.fromdate.focus();
	axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
	axon_event.addListenerFormat('focus', 'obj_activate', document.form); 
	axon_event.addListenerForm('blur', 'obj_deactivate', document.form); 
	axon_event.addListenerFormat('keyup', 'form_keyup', document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	// making btn_Rdr Disable
	ComBtnDisable("btn_Rdr");
	// making btn_LRange Disable
	ComBtnDisable("btn_LRange");
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

	case "sheet1":
		with (sheetObj) {
			//setting height
			style.height = 400;
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

			var HeadTitle1 = "Seq|Com|Region|Trade|Lane|VVD|Last\nPort|ATD|Week|Full (Box)|Full (Box)|Full (Box)|Full (Box)|Full (Box)|MTY (Box)|MTY (Box)|MTY (Box)|MTY (Box)|MTY (Box)|Box\nTotal|TEU\nTotal|Dead\nSlot(T)|Weight\nTotal|Released|Released|BSA|BSA|Unused|Unused|Load Factor|Load Factor|Load Factor|Data\nSource";
			var HeadTitle2 = "Seq|Com|Region|Trade|Lane|VVD|Last\nPort|ATD|Week|20'|40'|H/C|45'|Total|20'|40'|H/C|45'|Total|Box\nTotal|TEU\nTotal|Dead\nSlot(T)|Weight\nTotal|TEU|Weight|Space|Weight|Space|Weight|Full(%)|EQ(%)|WGT(%)|Data\nSource";

			var headCount = ComCountHeadTitle(HeadTitle1);

			setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// setting function handling header
			InitHeadMode(true, true, false, true, false, false);

			//setting header Row information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//			var fullLf = "IF(|bsaspace| == 0,0,( |full20qty| +  2 * ( |full40qty| + |fullhcqty| + |full45qty| ) + |deadslot|  ) / ( |bsaspace| + |releasedteu| ))";
			//			var EQLf = "IF(|bsaspace| == 0,0,  (|Teu_Total| + |deadslot| ) / ( |bsaspace| + |releasedteu| ))";
			//			var WGTLf = "IF(|bsaweight| = 0, 0, |weighttotal| / ( |bsaweight| + |releasedweight| ))";
			/*
			 var unusedSpace = "|bsaspace| - ( |Teu_Total| + |deadslot| ) + |releasedteu|";
			 var unusedWeight = "( |bsaweight| - |weighttotal| ) + |releasedweight|";
			 var fullTotal = "|full20qty| + |full40qty|+ |fullhcqty|+ |full45qty|";
			 var mtyTotal = "|mty20qty| + |mty40qty|+ |mtyhcqty|+ |mty45qty|";
			 var cBoxTotal = "|fulltotal| + |mtytotal|";
			 var cTEUTotal = "( |full20qty| + ( 2 * ( |full40qty| + |fullhcqty| + |full45qty| ) ) ) + ( |mty20qty| + ( 2 * ( |mty40qty| + |mtyhcqty| + |mty45qty| ) ) )";
			 */
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			//    				InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,		true,		"hdnStatus");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "colsorts", false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "company", false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "fromregion", false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "trade", false, "", dfNone, 0);

			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "lane", false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "vvd", false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "port", false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "atd", false, "", dfDateYmd, 0);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "atd_week", false, "", dfNone, 0);

			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "full20qty", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "full40qty", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "fullhcqty", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "full45qty", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "fulltotal", false, "", dfNullInteger, 0);

			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "mty20qty", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "mty40qty", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "mtyhcqty", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "mty45qty", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "mtytotal", false, "", dfNullInteger, 0);

			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "boxtotal", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "teutotal", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "deadslot", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "weighttotal", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "releasedteu", false, "", dfNullInteger, 0);

			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "releasedweight", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "bsaspace", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "bsaweight", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "unusedspace", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "unusedweight", false, "", dfNullInteger, 0);

			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "lffull", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "lfeq", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "lfwgt", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "datasource", false, "", dfNone, 0);
			//			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "colsorts",
			//					false, "", dfNone, 0);

			CountPosition = 0;
			FrozenCols = 9;

		}
		break;

	}
}

// handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: 
		if (validateForm(sheetObj, formObj, sAction)) {

			if (sheetObj.id == "sheet1") {
				formObj.f_cmd.value = COMMAND01;
				sheetObj.WaitImageVisible = false;
				sheetObj.Redraw = false;
				ComOpenWait(true);

				var sXml = sheetObj.GetSearchXml("EES_CIM_1049GS.do", FormQueryString(formObj));
				var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");

				if (backendJobKey.length > 0) {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.RequestTimeOut = 10000;
					timer1 = setInterval(getBackEndJobStatus, 1000);
				}
			}

		} else {
			return;
		}
		break;
	case IBSEARCH_ASYNC01: //lane focusOut
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH01;

			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_1049GS.do", FormQueryString(formObj));
			var sCheck = ComGetEtcData(sXml, "check");
			if (sCheck != "OK") {
				ComShowCodeMessage("CIM29012");
				document.form.lane.value = "";
				sheetObj.WaitImageVisible = true;
				ComSetFocus(document.form.lane);
				return false;
			}
			sheetObj.WaitImageVisible = true;
			ComSetFocus(document.form.vvd);
		} else {
			return;
		}

		break;
	case IBSEARCH_ASYNC02: //vvd focusOut
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH03;

			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_1033GS.do", FormQueryString(formObj));
			var sCheck = ComGetEtcData(sXml, "check");
			if (sCheck != "OK") {
				ComShowCodeMessage("CIM29023");
				document.form.vvd.value = "";
				sheetObj.WaitImageVisible = true;
				ComSetFocus(document.form.vvd);
				return false;
			}
			sheetObj.WaitImageVisible = true;
		} else {
			return;
		}

		break;
	case IBSEARCH_ASYNC03: //company
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH01;
			var intgCdId ='CD20064';
			var intgCdVal ='';
			var param ="&intgCdId="+intgCdId+"&intgCdVal="+intgCdVal;
	 		
			var divStr = "";
	 		var codeArr = null;
	 		var nameArr = null;
	 		var checked = "";
	
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_COMGS.do", FormQueryString(formObj)+param);
			// Company Radio Setting
			var rtnArr=ComXmlString(sXml,"code")
			codeArr ='TTL|'+rtnArr;
			nameArr='Total|'+rtnArr;
				codeArr = codeArr.split("|");
				nameArr = nameArr.split("|");
				
				for(var i=0; i<codeArr.length; i++){
					if (i == 1)
						checked = "checked";
					else
						checked = "";
					divStr += "\n";
					divStr += "<input type=\"radio\" name=\"company\" value=\""+codeArr[i]+"\" class=\"trans\""+checked+">"+nameArr[i]+"</input>";
					if(i < codeArr.length)
						divStr += "&nbsp;&nbsp;&nbsp;&nbsp;";
				}
				
				document.getElementById("div_company").innerHTML = "<div id=\"div_company\">"+ divStr +"</div>";
			sheetObj.WaitImageVisible = true;
		} else {
			return;
		}
	
		break;

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

function chkToDateWeekBlur() {
	var period = document.form.period.value;
	var toDate = document.form.todate.value;
	var frDate = document.form.fromdate.value;

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
		if (retMonth >= 6) {
			if (event.srcElement.name == "todate") {
				return false;
			}
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

		if (week > 12) {
			ComShowCodeMessage("CIM29025");
			document.getElementById("fromdate").value = "";
			document.getElementById("todate").value = "";
			ComSetFocus(document.getElementById("fromdate"));
			return;
		}
	}
	return true;
}

function obj_deactivate() {
	var f = document.getElementById("fromdate");
	var t = document.getElementById("todate");
	sVal1 = f.value.replace(/\/|\-|\./g, "");
	sVal2 = t.value.replace(/\/|\-|\./g, "");

	switch (event.srcElement.name) {
	case "vvd":
		if (event.srcElement.value != "") {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
		}

		break;
	case "lane":
		if (event.srcElement.value != "") {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
		}

		break;
	case "fromdate":
		if (ComChkObjValid(event.srcElement, false)) {

			if (f.getAttribute("dataformat") == "ymd") {

				if (sVal1 != "" && sVal2 != "") {
					var flag = ComChkPeriod(sVal1, sVal2);
					if (flag < 1) {
						if (event.srcElement.name == "todate") {
							event.srcElement.value = "";
							ComShowCodeMessage("CIM29004");
							enterSwitch = false;
							t.focus();
							t.select();
							return false;
						} else {
							t.value = "";
							enterSwitch = false;
							t.focus();
							t.select();
							return false;
						}
					} else {
						if (chkToDateWeekBlur() == false) {
							event.srcElement.value = "";
							enterSwitch = false;
							t.focus();
							t.select();
							return false;
						}
					}
					enterSwitch = true;
				}

			}

		} else {
			if (f.getAttribute("dataformat") == "ymd") {

				if (sVal1.length > 0 && !ComIsDate(sVal1) && event.srcElement.name == 'fromdate') {

					enterSwitch = false;
					event.srcElement.value = "";
					ComShowCodeMessage("CIM21004", "YYYYMMDD");
					event.srcElement.focus();
					event.srcElement.select();
					return false;
				}
			}
		}

		break;
	case "todate":
		if (ComChkObjValid(event.srcElement, false)) {

			if (t.getAttribute("dataformat") == "ymd") {

				if (sVal1 != "" && sVal2 != "") {
					var flag = ComChkPeriod(sVal1, sVal2);
					if (flag < 1) {
						if (event.srcElement.name == "todate") {
							event.srcElement.value = "";
							ComShowCodeMessage("CIM29004");
							enterSwitch = false;
							t.focus();
							t.select();
							return false;
						} else {
							t.value = "";
							enterSwitch = false;
							t.focus();
							t.select();
							return false;
						}
					} else {
						if (chkToDateWeekBlur() == false) {
							event.srcElement.value = "";
							ComShowCodeMessage("CIM29026");
							enterSwitch = false;
							t.focus();
							t.select();
							return false;
						}
					}
					enterSwitch = true;
				}

			}

		} else {
			if (t.getAttribute("dataformat") == "ymd") {

				if (sVal2.length > 0 && !ComIsDate(sVal2) && event.srcElement.name == 'todate') {
					enterSwitch = false;

					document.getElementById("todate").value = "";
					ComShowCodeMessage("CIM21004", "YYYYMMDD");

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

function obj_activate() {
	ComClearSeparator(event.srcElement);
	ComSetFocus(event.srcElement);
}

function obj_keypress() {
	switch (event.srcElement.name) {
	case "lane":
		ComKeyOnlyAlphabet('upper');// upper case only
		break;
	case "vvd":
		ComKeyOnlyAlphabet('uppernum');// upper case, numbers only
		break;
	case "fromdate":
		// permitting to input "-" in case of numbers only
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "todate":
		// permitting to input "-" in case of numbers only
		ComKeyOnlyNumber(event.srcElement);
		break;
	}

}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (sAction == IBSEARCH) {
			if (fromdate.value == "") {
				ComShowCodeMessage("CIM21001", "Period");
				ComSetFocus(fromdate);
				return false;
			} else if (todate.value == "") {
				ComShowCodeMessage("CIM21001", "Period");
				ComSetFocus(todate);
				return false;
			} else if (fromdate.value.length < 8) {
				return false;
			} else if (todate.value.length < 8) {

				return false;
			}
			if (!enterSwitch) {
				return false;
			}
		}
	}

	return true;
}

/**
 * Event when clicking data cell in IBSheet
 * @param {sheetObj} String : IBSheet cell name 
 * @param {Row} Long : Row Index
 * @param {Col} Long : Column Index
 * @param {Value} String : changed value, using value when saving and not being applied Format
 * @param {CellX} Long : x-coordinate
 * @param {CellY} Long : y-coordinate
 * @param {CellW} Long : cell width
 * @param {CellH} Long : cell height
 */
function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// in case of existing lane value in clicked row
		if (ComGetLenByByte(Cellvalue(Row, "lane")) > 0) {
			// making btn_Rdr button Enable
			ComBtnEnable("btn_Rdr");
		} else {
			// making btn_Rdr button Disable
			ComBtnDisable("btn_Rdr");
		}
		// n case of existing vvd value in clicked row
		if (ComGetLenByByte(Cellvalue(Row, "vvd")) > 0) {
			// making btn_Rdr button Enable
			ComBtnEnable("btn_LRange");
		} else {
			// making btn_Rdr button Disable
			ComBtnDisable("btn_LRange");
		}

	}
}

/**
 * Event when double clicking data cell in IBSheet
 * @param {sheetObj} String : IBSheet cell name 
 * @param {Row} Long : Row Index
 * @param {Col} Long : Column Index
 * @param {Value} String : changed value, using value when saving and not being applied Format
 * @param {CellX} Long : x-coordinate
 * @param {CellY} Long : y-coordinate
 * @param {CellW} Long : cell width
 * @param {CellH} Long : cell height
 */
function sheet1_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// in case of existing vvd value in double clicked row
		if (ComGetLenByByte(Cellvalue(Row, "vvd")) > 0) {
			if (SelectCol == 5) {
				var sUrl = "/opuscntr/VOP_OPF_0045.do?" + "vsl_cd=" + Cellvalue(Row, "vvd").substring(0, 4) + "&voy_no=" + Cellvalue(Row, "vvd").substring(4, 8)
						+ "&dir_cd=" + Cellvalue(Row, "vvd").substring(8, 9) + "&region=" + Cellvalue(Row, "fromregion");
				//ComOpenPopup(sUrl, 1024, 650, "", "0,0", false);
				ComOpenPopupWithTarget(sUrl, 1024, 670, "", "0,0", true, "yes");

			}
		}

		// in case of existing lane value in double clicked row
		if (ComGetLenByByte(Cellvalue(Row, "lane")) > 0) {
			if (SelectCol == 4) {
				var sUrl = "/opuscntr/VOP_VSK_0012.do";
				ComOpenPopupWithTarget(sUrl, 1020, 710, "", "0,0", true, "yes");
			}
		}
	}
}

/**
 * checkin until Status='3' 
 */
function getBackEndJobStatus() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];

	formObj.f_cmd.value = COMMAND02;
	var sXml = sheetObj.GetSearchXml("EES_CIM_1049GS.do", FormQueryString(formObj));
	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
	if (jobState == "3") {
		getBackEndJobLoadFile();
		clearInterval(timer1);
	} else if (jobState == "4") {
		ComShowCodeMessage("CIM29042");
		ComOpenWait(false);
		sheetObj.WaitImageVisible = true;
		clearInterval(timer1);
	} else if (jobState == "5") {
		ComShowCodeMessage("CIM29043");
		clearInterval(timer1);
	}
}

/**
 * downloading data as excel after BackEndJob
 */
function getBackEndJobLoadFile() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];

	formObj.f_cmd.value = COMMAND03;
	var sXml = sheetObj.GetSearchXml("EES_CIM_1049GS.do", FormQueryString(form));

	sheetObj.LoadSearchXml(sXml);
	sheetObj.WaitImageVisible = true;
	ComOpenWait(false);
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		Redraw = true;

		if (RowCount > 0) {
			for ( var i = 9; i < 29; i++) {
				SumValue(0, i) = CellValue(RowCount + 1, i);
			}
	
			for ( var i = 29; i < 32; i++) {
				SumText(0, i) = CellValue(RowCount + 1, i);
			}

			RowHidden(RowCount + 1) = true;
		}

		//	ColumnSort("colsorts");
		//	ColumnSort("2");
		//	ColumnSort("1");
		/*
		 if (document.form.vvd.value == "") {
		 SubSumBackColor = RgbColor(201, 213, 235);
		 ShowSubSum(
		 "colsorts",
		 "9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31",
		 true,
		 false,
		 false,
		 -1,
		 "0=;1=Total;2=%s;3=%s;29=IF(|25|== 0,0,(|9|+2*(|10|+|11|+|12|)+|21|)/(|25|+|23|))"
		 + ";30=IF(|bsaspace| == 0,0,  (|Teu_Total| + |deadslot| ) / ( |bsaspace| + |releasedteu| ))"
		 + ";31=IF(|bsaweight| = 0, 0, |weighttotal| / ( |bsaweight| + |releasedweight| ))");
		 }

		
		 for ( var x = 2; x < sheetObj.LastRow; x++) {
		 if (sheetObj.CellValue(x, 1) == "Total") {

		 var slffull = parseFloat(CellValue(x, "lffull") * 100)
		 var slfeq = parseFloat(CellValue(x, "lfeq") * 100)
		 var slfwgt = parseFloat(CellValue(x, "lfwgt") * 100)

		 CellValue(x, "lffull") = Math.round(slffull * 100) / 100 + "%";
		 CellValue(x, "lfeq") = Math.round(slfeq * 100) / 100 + "%";
		 CellValue(x, "lfwgt") = Math.round(slfwgt * 100) / 100 + "%";
		 }
		 }

		 // TOTAL fullLf calculation logic
		 if (SumValue(0, "bsaspace") == 0) {

		 SumText(0, "lffull") = "0.0%";
		 } else {

		 SumText(0, "lffull") = Math
		 .round((((parseFloat(SumValue(0, "full20qty"))
		 + 2
		 * (parseFloat(SumValue(0, "full40qty"))
		 + parseFloat(SumValue(0, "fullhcqty")) + parseFloat(SumValue(
		 0, "full45qty"))) + parseFloat(SumValue(0,
		 "deadslot"))) / (parseFloat(SumValue(0, "bsaspace")) + parseFloat(SumValue(
		 0, "releasedteu")))) * 100) * 10)
		 / 10 + "%";
		 }

		 // TOTAL LF_EQ calculation logic
		 if (SumValue(0, "bsaspace") == 0) {
		 SumText(0, "lfeq") = "0.0%";
		 } else {
		 SumText(0, "lfeq") = Math
		 .round((((parseFloat(SumValue(0, "Teu_Total")) + parseFloat(SumValue(
		 0, "deadslot"))) / (parseFloat(SumValue(0,
		 "bsaspace")) + parseFloat(SumValue(0, "releasedteu")))) * 100) * 10)
		 / 10 + "%";
		 }

		 // TOTAL LF_WGT
		 if (SumValue(0, "bsaweight") == 0) {
		 SumText(0, "lfwgt") = "0.0%";
		 } else {
		 SumText(0, "lfwgt") = Math
		 .round(((parseFloat(SumValue(0, "weighttotal")) / (parseFloat(SumValue(
		 0, "bsaweight")) + parseFloat(SumValue(0,
		 "releasedweight")))) * 100) * 10)
		 / 10 + "%";
		 }

		 MessageText("Sum") = "";
		 */
		SumText(0, 0) = "G.Total";

		SumText(0, 1) = "G.Total";

		CellAlign(LastRow, 0) = daCenter;
		SetMergeCell(LastRow, 0, 1, 9);
	}

	document.form.prt_period.value = document.form.period.value;
	document.form.prt_fromdate.value = document.form.fromdate.value;
	document.form.prt_todate.value = document.form.todate.value;
	document.form.prt_trade.value = document.form.trade.value;
	document.form.prt_lane.value = document.form.lane.value;
	document.form.prt_vvd.value = document.form.vvd.value;
	var check = "";
	for ( var i = 0; i < document.form.company.length; i++) {
		if (document.form.company[i].checked) {
			check = document.form.company[i].value;
		}
	}
	document.form.prt_company.value = check;

}

/* end of developer job */