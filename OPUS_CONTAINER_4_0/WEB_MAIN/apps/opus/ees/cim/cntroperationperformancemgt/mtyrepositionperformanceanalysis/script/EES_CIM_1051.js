/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1051.js
*@FileTitle  : MTY CNTR PFMC by Movement
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class ees_cim_1051 : business script for ees_cim_1051 
 */

/* developer job	*/
//common global variables
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var oldCntrTypeSize="";
var sCntrTypeSize="";
var tabIndex=0;
var sPeriod="";
var prePeriod="";
var isOpen=true;
var enterSwitch=false;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick() {
	var shtCnt=0;
//	var t1sheet1=sheetObjects[shtCnt++];
//	var t2sheet1=sheetObjects[shtCnt++];
//	var t3sheet1=sheetObjects[shtCnt++];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Retrieve":
			if (tabIndex == 0) {
				t2sheet1.RemoveAll();
				t3sheet1.RemoveAll();
				doActionIBSheet(t1sheet1, formObject, IBSEARCH);
				sheetObjects[0].SetSelectRow(0);
			} else if (tabIndex == 1) {
				t1sheet1.RemoveAll();
				t3sheet1.RemoveAll();
				// making btn_t2EachCNTR button Disable
				ComBtnDisable("btn_t2EachCNTR");
				// making btn_t2EachBKG button Disable
				ComBtnDisable("btn_t2EachBKG");
				doActionIBSheet2(t2sheet1, formObject, IBSEARCH);
			} else {
				t1sheet1.RemoveAll();
				t2sheet1.RemoveAll();
				doActionIBSheet3(t3sheet1, formObject, IBSEARCH);
				sheetObjects[2].SetSelectRow(0);
			}
			break;
		case "btn_New":
			t1sheet1.RemoveAll();
			t2sheet1.RemoveAll();
			t3sheet1.RemoveAll();
			formObject.reset();
			tab1.SetTabDisable(1,false);
			tab1.SetTabDisable(2,true);
			tab1.SetTabDisable(0,false);
			document.getElementById("froms").setAttribute("dataformat", "ymd");
			document.getElementById("tos").setAttribute("dataformat", "ymd");
			document.getElementById("froms").setAttribute("maxLength", 8);
			document.getElementById("tos").setAttribute("maxLength", 8);
			document.getElementById("btns_calendarto").style.display="";
			document.getElementById("bound").value="";
			document.getElementById("bound").disabled=true;
			document.getElementById("bound").className="input2";
			comboObjects[0].SetSelectCode("");
			document.form.inquiryLevel.value="R";
			ComSetFocus(formObject.froms);
			prePeriod = "D";
			break;
		case "btn_downExcel":
			if (tabIndex == 0) {
				 if(t1sheet1.RowCount() < 1){//no data
            		 ComShowCodeMessage("COM132501");
    	       		}else{        	       			  
//    	       			t1sheet1.Down2Excel({ HiddenColumn:-1});
//    	       			t1sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(t1sheet1), SheetDesign:1,Merge:1 });
    	       			t1sheet1.Down2Excel({ DownCols: makeHiddenSkipCol(t1sheet1), SheetDesign:1, HiddenColumn:1, Merge:1 });
    	       		}
			} else if (tabIndex == 1) {
				if(t2sheet1.RowCount() < 1){//no data
           		 ComShowCodeMessage("COM132501");
   	       		}else{
//   	       			t2sheet1.Down2Excel({ HiddenColumn:-1});
//   	       			t2sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(t2sheet1), SheetDesign:1,Merge:1 });
   	       			t2sheet1.Down2Excel({ DownCols: makeHiddenSkipCol(t2sheet1), SheetDesign:1, HiddenColumn:1, Merge:1 });
   	       		}
			} else {
				if(t3sheet1.RowCount() < 1){//no data
	           		 ComShowCodeMessage("COM132501");
	   	       		}else{
//	   	       			t3sheet1.Down2Excel({ HiddenColumn:-1});
//	   	       			t3sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(t3sheet1), SheetDesign:1,Merge:1 });
	   	       			t3sheet1.Down2Excel({ DownCols: makeHiddenSkipCol(t3sheet1), SheetDesign:1, HiddenColumn:1, Merge:1 });
	   	       		}
			}
			break;
		case "btns_calendarfm":
			var cal=new ComCalendar();
			cal.setDisplayType('date');
			cal.select(formObject.froms, 'yyyy-MM-dd');
			break;
		case "btns_calendarto":
			var cal=new ComCalendarFromTo();
			cal.setEndFunction("nextFocusOut");
			cal.select(formObject.froms, formObject.tos, 'yyyy-MM-dd');
			break;
		case "btn_loc_cd": // retrieving Location popup
			var cnt_cd="";
			var loc_cd="";
			cnt_cd=formObject.inquiryLevel.value;
			loc_cd=formObject.location.value;
			if (formObject.inquiryLevel.value != 'A') {
				if (formObject.inquiryLevel.value == 'C') { //Country
					var param="?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
					ComOpenPopup("/opuscntr/COM_ENS_0M1.do", 565, 650, "popupFinish", "1,0,1,1,1,1,1,1", true);
				} else if (formObject.inquiryLevel.value == 'Y') { //YARD
					var param="?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
					ComOpenPopup("/opuscntr/COM_ENS_061.do", 755, 650, "popupFinish2", "1,0,1,1,1,1,1,1", true);
				} else {
					var loc_code="";
					if (formObject.inquiryLevel.value == "R") {
						loc_code="rcc_cd";
					} else if (formObject.inquiryLevel.value == "L") {
						loc_code="lcc_cd";
					} else if (formObject.inquiryLevel.value == "E") {
						loc_code="ecc_cd";
					} else if (formObject.inquiryLevel.value == "S") {
						loc_code="scc_cd";
					}
					var param="?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
					ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 460, loc_code + ":location", "1,0,1,1,1,1,1,1", true);
				}
			}
			break;
		case "btn_t2EachCNTR":
			// in case of activated button
			if (ComIsBtnEnable(srcName)) {
				var sUrl = "/opuscntr/EES_CTM_0408_POP.do"; 
				var param = "?p_cntrno=" + t2sheet1.GetCellValue(t2sheet1.GetSelectRow(), "cntrno").substring(0, 10)
							+ "&check_digit=" + t2sheet1.GetCellValue(t2sheet1.GetSelectRow(), "cntrno").substring(10, 11) 
							+ "&ctnr_tpsz_cd=" + t2sheet1.GetCellValue(t2sheet1.GetSelectRow(), "tpsz") 
							+ "&cnmv_evnt_dt=" + t2sheet1.GetCellValue(t2sheet1.GetSelectRow(), "pre_eventdate").substring(0, 8);
				ComOpenPopupWithTarget(sUrl+param, 1020, 682, "", "0,1", true);
			}
			break;
		case "btn_t2EachBKG":
			// in case of activated button
			if (ComIsBtnEnable(srcName)) {
/*
				var sUrl="/opuscntr/EES_CTM_0409.do?" + "bkg_no=" + t2sheet1.Cellvalue(t2sheet1.GetSelectRow(), "bkgno").substring(0, 11)
				+ "&bkg_no_split=" + t2sheet1.Cellvalue(t2sheet1.GetSelectRow(), "bkgno").substring(11, 13);
*/				
				var sUrl="/opuscntr/EES_CTM_0409_POP.do?" + "bkg_no=" + t2sheet1.GetCellValue(t2sheet1.GetSelectRow(), "bkgno");
				ComOpenPopupWithTarget(sUrl, 1020, 682, "", "0,1", true);
			}
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
	document.form.inquiryLevel.focus();
}


/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}


/**
 * registering IBMultiCombo Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj;
}


/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		tabObjects[k].SetSelectedIndex(0);
	}
	//IBMultiCombo초기화
	for ( var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
		
	}
	t1sheet1_OnLoadFinish(t1sheet1);
	initControl();
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	resizeSheet();
	init_inquiryLevel();
	document.form.inquiryLevel.value="R";
	
}


function t1sheet1_OnLoadFinish(sheetObj) {
	//	sheetObj.WaitImageVisible = false;
	doActionIBSheet(t1sheet1, document.form, IBSEARCH_ASYNC01);
	//	sheetObj.WaitImageVisible = true;
}


function initControl() {
	document.getElementById("bound").value="";
	document.getElementById("bound").disabled=true;
	document.getElementById("bound").className="input2";
	//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListener('click', 'reverse_cntr_tpsz_cd_check', 'tpsz', ''); 
	//axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
	axon_event.addListenerForm('change', 'obj_change', document.form);
	//axon_event.addListenerForm('focus', 'obj_activate', document.form); 
	axon_event.addListenerForm('blur', 'obj_deactivate', document.form); 
	//axon_event.addListenerFormat('keyup', 'form_keyup', document.form);
//	tabObjects[0].SetTabDisable(2);
	tab1.SetTabDisable(2, true);
	prePeriod="D";
	// making btn_t2EachCNTR button Disable
	ComBtnDisable("btn_t2EachCNTR");
	// making btn_t2EachBKG button Disable
	ComBtnDisable("btn_t2EachBKG");
}


function tpsz_OnCheckClick(comboObj, index, code) {
	if(index==0) { 	    	
		var bChk=comboObj.GetItemCheck(index);
		if(bChk){
			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
				comboObj.SetItemCheck(i,0);
			}
		}
	} else {
		var bChk=comboObj.GetItemCheck(index);
		if (bChk) {
			comboObj.SetItemCheck(0,0);
		}
	}
}


/**
 * setting selected value from Location by loc_cd popup
 */
function popupFinish(aryPopupData, row, col, sheetIdx) {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	formObject.location.value=aryPopupData[0][3]
}


/**
 * setting selected value from Location by yard_cd popup
 */
function popupFinish2(aryPopupData, row, col, sheetIdx) {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	formObject.location.value=aryPopupData[0][3]
}


function form_keyup() {
	var obj=null;
	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	if (keyValue != 13) {
		ComKeyEnter('lengthnextfocus');
	} else {
		obj_deactivate();
	}
}


function chkToDateWeekBlur() {
	var period=document.form.period.value;
	var toDate=document.form.tos.value;
	var frDate=document.form.froms.value;
	var toYearDate=toDate.substring(0, 4);
	var frYearDate=frDate.substring(0, 4);
	var toMonthDate=toDate.substring(5, 7);
	var frMonthDate=frDate.substring(5, 7);
	var frDayDate="";
	var toDayDate="";
	if (frDate.length > 7) {
		frDayDate=frDate.substring(8, 10);
		toDayDate=toDate.substring(8, 10);
	} else {
		frDayDate="01";
		toDayDate=lastDay(toYearDate, toMonthDate);
	}
	var frDateFull=new Date(frYearDate, frMonthDate - 1, frDayDate);
	var toDateFull=new Date(toYearDate, toMonthDate - 1, toDayDate);
	var getDiffTime=toDateFull.getTime() - frDateFull.getTime();
	var retDate=Math.floor(getDiffTime / (1000 * 60 * 60 * 24));
	var retMonth=((parseInt(toYearDate) - parseInt(frYearDate)) * 12 + parseInt(toMonthDate, 10) - parseInt(frMonthDate, 10));
	var retWeek=Math.floor((toDateFull - frDateFull) / (1000 * 60 * 60 * 24 * 7));
	var week="";
	var fromTo=52;
	if (period == "M") {
		if (retMonth >= 3) {
			if (ComGetEvent("name") == "tos") {
				ComShowCodeMessage("CIM29025");
				ComSetFocus(document.getElementById("tos"));
			}
			return false;
		}
	} else if (period == "W") {
		if (frYearDate == toYearDate) {
			week=eval(toMonthDate) - eval(frMonthDate) + 1;
		} else {
			betwMonth=fromTo - eval(frMonthDate) + eval(toMonthDate) + 1;
			if ((eval(toYearDate) - eval(frYearDate)) == 1) { //in case of 1 year gap
				week=betwMonth;
			} else {
				week=(eval(toYearDate) - eval(frYearDate) - 1) * fromTo + betwMonth;
			}
		}
		if (week > 12) {
			if (ComGetEvent("name") == "tos") {
				ComShowCodeMessage("CIM29025");
				ComSetFocus(document.getElementById("tos"));
			}
			return false;
		}
	} else if (period == "D") {
		if (retDate >= 31) {
			if (ComGetEvent("name")== "tos") {
				ComShowCodeMessage("CIM29029");
				ComSetFocus(document.getElementById("tos"));
			}
			return false;
		}
	}
}


var imsi=0;
//function for handling Axon event
function obj_deactivate() {
	var f=document.getElementById("froms");
	var t=document.getElementById("tos");
	sVal1=f.value.replace(/\/|\-|\./g, "");
	sVal2=t.value.replace(/\/|\-|\./g, "");
	switch (ComGetEvent("name")) {
	case "location":
		if (document.form.location.value != "") {
			if (imsi == 0) {
				var status=doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
				if (!status) {
					imsi=0;
				}
			}
		}
		break;
	case "froms":
		if (ComChkObjValid(ComGetEvent(), false)) {
			if (f.getAttribute("dataformat") == "ym") {
				if (sVal1 != "" && sVal2 != "") {
					var day=lastDay(sVal2.substring(0, 4), sVal2.substring(4, 6));
					var flag=ComChkPeriod(sVal1 + "01", sVal2 + day);
					if (flag < 1) {
						//	ComShowCodeMessage("CIM29004");
						enterSwitch=false;
						t.value="";
						//t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							t.value="";
							//t.focus();
							t.select();
							return false;
						}
					}
					document.getElementById("from").value=sVal1 + "01";
					document.getElementById("to").value=sVal2 + day;
				}
			} else if (f.getAttribute("dataformat") == "ymd") {
				if (sVal1 != "" && sVal2 != "") {
					var flag=ComChkPeriod(sVal1, sVal2);
					if (flag < 1) {
						ComShowCodeMessage("CIM29004");
						enterSwitch=false;
						t.value="";
						//t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							t.value="";
							//t.focus();
							t.select();
							return false;
						}
					}
					document.getElementById("from").value=sVal1;
					document.getElementById("to").value=sVal2;
				}
				switch (ComGetEvent("name")) {
				case "froms":
					if (f.value != "" && t.value == "") {
						
						t.value=ComGetDateAdd(f.value, "D", 6, "").substring(0, 4)+"-"+ComGetDateAdd(f.value, "D", 6, "").substring(4, 6)+"-"+ComGetDateAdd(f.value, "D", 6, "").substring(6, 8);
						document.form.inquiryLevel.focus();
					}
					break;
				}
			} else { // retrieving by week
				if (sVal1 != "" && sVal2 != "") {
					if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
						ComShowCodeMessage("CIM29003");
						enterSwitch=false;
						t.value="";
						//t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							t.value="";
							//t.focus();
							t.select();
							return false;
						}
					}
					document.getElementById("from").value=sVal1;
					document.getElementById("to").value=sVal2;
				}
			}
		} else {
			if (f.getAttribute("dataformat") == "ym") {
				if (sVal1.length > 0 && !ComIsMonth(sVal1.substring(4, 6)) && ComGetEvent("name") == 'froms') {
					event.srcElement.value="";
					ComShowCodeMessage("CIM21004", "YYYYMM");
					enterSwitch=false;
					//ComGetEvent().focus();
					event.srcElement.select();
					return false;
				}
			} else if (f.getAttribute("dataformat") == "ymd") {
				if (sVal1.length > 0 && !ComIsDate(sVal1) && ComGetEvent("name") == 'froms') {
					event.srcElement.value="";
					ComShowCodeMessage("CIM21004", "YYYYMMDD");
					//ComGetEvent().focus();
					event.srcElement.select();
					enterSwitch=false;
					return false;
				}
			} else { // retrieving by week
				if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6)) && ComGetEvent("name") == 'froms') {
					event.srcElement.value="";
					ComShowCodeMessage("CIM21004", "YYYYWW");
					//ComGetEvent().focus();
					event.srcElement.select();
					enterSwitch=false;
					return false;
				}
			}
		}
		break;
	case "tos":
		if (ComChkObjValid(ComGetEvent(), false)) {
			if (t.getAttribute("dataformat") == "ym") {
				var day=lastDay(sVal2.substring(0, 4), sVal2.substring(4, 6));
				if (sVal1 != "" && sVal2 != "") {
					var flag=ComChkPeriod(sVal1 + "01", sVal2 + day);
					if (flag < 1) {
						if (ComGetEvent("name") == "tos") {
							ComShowCodeMessage("CIM29004");
						}
						enterSwitch=false;
						event.srcElement.value="";
						//t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							event.srcElement.value="";
							//t.focus();
							t.select();
							return false;
						}
					}
				}
				document.getElementById("from").value=sVal1 + "01";
				document.getElementById("to").value=sVal2 + day;
			} else if (t.getAttribute("dataformat") == "ymd") {
				if (sVal1 != "" && sVal2 != "") {
					var flag=ComChkPeriod(sVal1, sVal2);
					if (flag < 1) {
						if (ComGetEvent("name") == "tos") {
							ComShowCodeMessage("CIM29004");
							enterSwitch=false;
							event.srcElement.value="";
							//t.focus();
							t.select();
							return false;
						}
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							event.srcElement.value="";
							//t.focus();
							t.select();
							return false;
						}
					}
				}
				document.getElementById("from").value=sVal1;
				document.getElementById("to").value=sVal2;
				switch (ComGetEvent("name")) {
				case "froms":
					if (f.value != "" && t.value == "") {
						t.value=ComGetDateAdd(f.value, "D", 6, "");
					}
					break;
				}
			} else { // retrieving by week
				if (sVal1 != "" && sVal2 != "") {
					if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
						if (ComGetEvent("name") == "tos") {
							ComShowCodeMessage("CIM29003");
						}
						enterSwitch=false;
						event.srcElement.value="";
						//t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							event.srcElement.value="";
							//t.focus();
							t.select();
							return false;
						}
					}
				}
				document.getElementById("from").value=sVal1;
				document.getElementById("to").value=sVal2;
			}
			enterSwitch=true;
		} else {
			if (t.getAttribute("dataformat") == "ym") {
				if (sVal2.length > 0 && !ComIsMonth(sVal2.substring(4, 6))) {
					enterSwitch=false;
					event.srcElement.value="";
					ComShowCodeMessage("CIM21004", "YYYYMM");
					//t.focus();
					t.select();
					return false;
				}
			} else if (t.getAttribute("dataformat") == "ymd") {
				if (sVal2.length > 0 && !ComIsDate(sVal2)) {
					enterSwitch=false;
					event.srcElement.value="";
					ComShowCodeMessage("CIM21004", "YYYYMMDD");
					//t.focus();
					t.select();
					return false;
				}
			} else { // retrieving by week
				if (sVal2.length > 0 && !ComIsWeek(sVal2.substring(4, 6))) {
					enterSwitch=false;
					event.srcElement.value="";
					ComShowCodeMessage("CIM21004", "YYYYWW");
					//t.focus();
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
	var d, d2, s="";
	d=new Date();
	d2=new Date(y, m, "");
	s=d2.getDate();
	return (s);
}


function obj_activate() {
	ComClearSeparator(ComGetEvent());
	ComSetFocus(ComGetEvent());
}


function reverse_cntr_tpsz_cd_check() {
	var formObject=document.form;
	if (formObject.tpsz.checked) {
		comboObjects[0].SetSelectCode(tpsz.replaceStr("|", ","));
	} else {
		comboObjects[0].SetSelectCode("");
	}
}


function setDate() {
	var today=new Date();
	var y=today.getFullYear().toString();
	var m=(today.getMonth() + 1).toString();
	if (m.length == 1) {
		m=0 + m;
	}
	var ym=y + '-' + m;
	document.form.froms.value=ym;
	document.form.tos.value=ym;
	var day=lastDay(y, m);
	document.form.from.value=y + m + "01";
	document.form.froms.value=y + m + "01";
	document.form.to.value=ComGetDateAdd(document.form.froms.value, "D", 6, "");
	document.form.tos.value=ComGetDateAdd(document.form.froms.value, "D", 6, "");
}


function obj_keypress() {
	switch (ComGetEvent("name")) {
	case "location":
		if (document.form.inquiryLevel.value == "Y") {
			ComKeyOnlyAlphabet('uppernum');// upper case, numbers only
		} else {
			ComKeyOnlyAlphabet('uppernum');// upper case only
		}
		break;
	case "froms":
		// permitting to input "-" in case of numbers only
		ComKeyOnlyNumber(ComGetEvent());
		break;
	case "tos":
		// permitting to input "-" in case of numbers only
		ComKeyOnlyNumber(ComGetEvent());
		break;
	}
}


/** handling Combo change event
 * 
 * @return
 */
function obj_change() {
	obj=ComGetEvent();
	if (obj.name == "inquiryLevel") {
		if (obj.value == "Y") {
			document.getElementById("location").setAttribute("maxLength", 7);
			//document.getElementById("location").focus();
		} else {
			document.getElementById("location").setAttribute("maxLength", 5);
			//document.getElementById("location").focus();
		}
	} else if (obj.name == "period") {
		if (obj.value == "M") {
			//if (prePeriod == "D"){
//			tabObjects[0].TabEnable(0) = true; 
//			tabObjects[0].TabEnable(1)=false;
//			tabObjects[0].TabEnable(2)=true;
			tab1.SetTabDisable(2,false);
			tab1.SetTabDisable(1,false);
			tab1.SetTabDisable(0,false);			
			//}
			document.getElementById("froms").setAttribute("dataformat", "ym");
			document.getElementById("tos").setAttribute("dataformat", "ym");
			document.getElementById("froms").setAttribute("maxLength", 6);
			document.getElementById("tos").setAttribute("maxLength", 6);
			document.getElementById("btns_calendarto").style.display="none";
			document.form.froms.value="";
			document.form.tos.value="";
			document.form.from.value="";
			document.form.to.value="";
//			document.form.gubun.value = "S";
			var preinquiryLevel=document.form.inquiryLevel.value;
			init_inquiryLevel();
			document.form.inquiryLevel.value=preinquiryLevel;
			isOpen=false;
		} else if (obj.value == "W") {
			//if (prePeriod == "D"){
////			tabObjects[0].TabEnable(0) = true;  
//			tabObjects[0].TabEnable(1)=false;
//			tabObjects[0].TabEnable(2)=true;
			tab1.SetTabDisable(1,false);
			tab1.SetTabDisable(2,false);
			tab1.SetTabDisable(0,false);
			//}
			document.getElementById("froms").setAttribute("dataformat", "yw");
			document.getElementById("tos").setAttribute("dataformat", "yw");
			document.getElementById("froms").setAttribute("maxLength", 6);
			document.getElementById("tos").setAttribute("maxLength", 6);
			document.getElementById("btns_calendarto").style.display="none";
			document.form.froms.value="";
			document.form.tos.value="";
			document.form.from.value="";
			document.form.to.value="";
//			document.form.gubun.value = "S";
			var preinquiryLevel=document.form.inquiryLevel.value;
			init_inquiryLevel();
			document.form.inquiryLevel.value=preinquiryLevel;
			isOpen=false;
		} else {
//			tabObjects[0].TabEnable(0) = true;  
//			tabObjects[0].TabEnable(1)=true;
//			tabObjects[0].TabEnable(2)=false;		
			tab1.SetTabDisable(1,false);
			tab1.SetTabDisable(2,true);
			tab1.SetTabDisable(0,false);
			document.getElementById("froms").setAttribute("dataformat", "ymd");
			document.getElementById("tos").setAttribute("dataformat", "ymd");
			document.getElementById("froms").setAttribute("maxLength", 8);
			document.getElementById("tos").setAttribute("maxLength", 8);
			document.getElementById("btns_calendarto").style.display="";
			document.form.froms.value="";
			document.form.tos.value="";
			document.form.from.value="";
			document.form.to.value="";
//			document.form.gubun.value = "S";
			var preinquiryLevel=document.form.inquiryLevel.value;
			init_inquiryLevel();
			document.form.inquiryLevel.value=preinquiryLevel;
		}
		prePeriod=obj.value;
		//document.form.froms.focus();
	} else if (obj.name == "mtymvmt") {
		if (obj.value == "VD" || obj.value == "VL" || obj.value == "TS" || obj.value == "ENF" || obj.value == "TNF") {
			document.getElementById("bound").disabled=false;
			document.getElementById("bound").value="";
			document.getElementById("bound").className="input";
		} else {
			document.getElementById("bound").value="";
			document.getElementById("bound").disabled=true;
			document.getElementById("bound").className="input2";
		}
	}
}


function initCombo(comboObj, comboNo) {
	switch (comboObj.options.id) {
	case "tpsz":
		var i=0;
		with (comboObj) {
			SetDropHeight(320);
			SetMultiSelect(1);
			SetMultiSeparator(",");
//			Style=1;
		}
		break;
	}
}


/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo, HeadTitle) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "t1sheet1":
	    with(sheetObj){
    	  var HeadTitle1="MVMT|Total";
      	  oldCntrTypeSize=sCntrTypeSize;
      	  var arrCntrTypeSize=oldCntrTypeSize.split(",");
      	for ( var i=0; i < arrCntrTypeSize.length; i++) {
      		if (sCntrTypeSize != "") {
      			HeadTitle1 += "|" + arrCntrTypeSize[i];
      		}
      	}
      	var headCount=ComCountHeadTitle(HeadTitle1);
      	var rowCnt=0;
      var MTYIO=80;
      var MTYMVMT=80;
      var Division=60;
      var Total=60;
      var sCount="";
      var x=1;
      for ( var j=0; j < 1; j++) {
	      cnt=0;
	      x=1;
	
	      SetConfig( { SearchMode:2, FrozenCol:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Text",      Hidden:0,  Width:MTYMVMT,Align:"Center",  ColMerge:1,   SaveName:"division",  KeyField:0,   CalcLogic:"",   Format:"" } ];
            if (document.form.mtymvmt.value == "VL" || document.form.mtymvmt.value == "VD" || document.form.mtymvmt.value == 'MT') {
            	cols.push({Type:"AutoSum",   Hidden:0, Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
            } else {
            	cols.push({Type:"Int",       Hidden:0,  Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
            }
            for ( var i=0; i < arrCntrTypeSize.length; i++) {
            	if (arrCntrTypeSize.length > 1) {
    		  if (x < 10) {
    			  sCount="count0" + x;
    		  } else {
    			  sCount="count" + x;
    		  }
    		  if (document.form.mtymvmt.value == "VL" || document.form.mtymvmt.value == "VD" || document.form.mtymvmt.value == 'MT') {
    			  cols.push({Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:sCount,      KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
    		  } else {
    			  cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:sCount,      KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
    		  }
            x++;
      		}
      	  }
      	}
      InitColumns(cols);
      SetSheetHeight(435);
      ComResizeSheet(sheetObj);
      SetEditable(0);
      }
		break;
	case "t2sheet1":
	    with(sheetObj){
      
      var HeadTitle1="|Seq.|C|CNTR No.|TP/SZ|MVMT|Yard|Former MVMT\nEvent DT|Latter MVMT\nEvent DT|A|Lane|T.VVD|BKG No.|SC/RFA/TAA No.|SHPR|CNEE|POR|POL|POD|DEL|DM|DMG Flg DT|DMG Unflg DT|DP|IM|HR";
      var headCount=ComCountHeadTitle(HeadTitle1);

      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );

      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
             {Type:"Seq",       Hidden:0, Width:30,    Align:"Center",  ColMerge:1,   SaveName:"Seq" },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"company",         KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntrno",          KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"tpsz",            KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mvmt",            KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"yard",            KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pre_eventdate",   KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"post_eventdate",  KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"autoflag",        KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lane",            KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"tvvd",            KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkgno",           KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"sc_rfa_no_taa",   KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:"shpr",            KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:"cnee",            KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"por",             KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol",             KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod",             KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del",             KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"CheckBox",  Hidden:0, Width:25,    Align:"Center",  ColMerge:1,   SaveName:"damage",          KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0, Width:110,   Align:"Center",  ColMerge:1,   SaveName:"dmg_flg_dt",      KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0, Width:110,   Align:"Center",  ColMerge:1,   SaveName:"dmg_unflg_dt",    KeyField:0,   CalcLogic:"",   Format:"" },             
             {Type:"CheckBox",  Hidden:0, Width:25,    Align:"Center",  ColMerge:1,   SaveName:"disposal",        KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"CheckBox",  Hidden:0, Width:25,    Align:"Center",  ColMerge:1,   SaveName:"imdtexit",        KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"CheckBox",  Hidden:0, Width:25,    Align:"Center",  ColMerge:1,   SaveName:"hngrrack",        KeyField:0,   CalcLogic:"",   Format:"" } ];
       
      InitColumns(cols);
      SetSheetHeight(405);
      //resizeSheet();
      SetEditable(0);
            }


		break;
	case "t3sheet1":
	    with(sheetObj){
			var cols =[];
			var colsList = [];
		      if (document.form.mtymvmt.value != 'MT' && document.form.mtymvmt.value != 'VL' && document.form.mtymvmt.value != 'VD') {
		    	  if (HeadTitle == null || HeadTitle == "") {
		    		  HeadTitle="TP/SZ|MVMT|Total";
		    	  }
		    	  var headCnt=HeadTitle.split("|").length;
		    	  if (SheetWidth > 975) {
		    	  }
		    	  var rowCnt=0;
		    	  var MTYIO=80;
		    	  var MTYMVMT=80;
		    	  var Division=80;
		    	  var Total=80;
		    	  var cnt=0;
		
		//    	  SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:1, Page:20, Page:20, Page:20, DataRowMerge:1 } );
		//    	  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1, Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		    	  SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:7, Page:20, DataRowMerge:0 } );
		    	  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		    	  var headers = [ { Text:HeadTitle, Align:"Center"}];
		    	  InitHeaders(headers, info);
		
		    	   cols = [ 
		             {Type:"Text",      Hidden:0,  Width:MTYIO,Align:"Center",  ColMerge:1,   SaveName:"inout",     KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:MTYMVMT,Align:"Center",  ColMerge:1,   SaveName:"division",  KeyField:0,   CalcLogic:"",   Format:"" } ];
		    	  if (document.form.mtymvmt.value == 'MT' || document.form.mtymvmt.value == 'VL' || document.form.mtymvmt.value == 'VD') {
		    		  cols.push({Type:"AutoSum",   Hidden:0, Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
		    	  } else {
		    		  cols.push({Type:"AutoSum",   Hidden:0, Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
		    	  }
		    	  
		    	  var x = 1;
		    	  for ( var i=1; i <= headCnt - 3; i++) {
		    		  if (x < 10) {
		    			  sCount="count0" + x;
		    		  } 
		    		  else{sCount="count" + x;}
		    		  if (document.form.mtymvmt.value == 'MT' || document.form.mtymvmt.value == 'VL' || document.form.mtymvmt.value == 'VD') 
		    		  {
		    			  cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:sCount,      KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
		    		  }
		    		  else 
		    		  {
		    			  cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:sCount,      KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
		    		  }
		    		  x++;      	
		    	  }
		      }else {
		//    	  if (document.form.mtymvmt.value == 'MT') {
		//    		//  InitRowInfo(1, 5, 20, 100);
		//    	  }
		//    	  else{
		//  			//InitRowInfo(1, 3, 20, 100);
		//    	  }
		//    	  if (HeadTitle == null || HeadTitle == "") {
		//    		  HeadTitle="TP/SZ|MVMT|Total";
		//    	  }
		    	  
		    	  if (HeadTitle == null || HeadTitle == "") {
		    		  HeadTitle="TP/SZ|MVMT|Total";
		    	  }
		    	  var headCnt=HeadTitle.split("|").length;
		    	  if (SheetWidth > 975) {
		    	  }
		    	  var rowCnt=0;
		    	  var MTYIO=80;
		    	  var MTYMVMT=80;
		    	  var Division=80;
		    	  var Total=80;
		    	  var cnt=0;
		
		//    	  SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:1, Page:20, Page:20, Page:20, DataRowMerge:0 } );
		//    	  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1, Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		    	  SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:7, Page:20, DataRowMerge:0 } );
		    	  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		    	  var headers = [ { Text:HeadTitle, Align:"Center"}];
		//    	  alert(HeadTitle);
		    	  InitHeaders(headers, info);
		
		    	   cols = [ 
				             {Type:"Text",      Hidden:0,  Width:MTYIO,Align:"Center",  ColMerge:1,   SaveName:"inout",     KeyField:0,   CalcLogic:"",   Format:"" }];    	  
						      cols.push({Type:"Text",      Hidden:0,  Width:MTYMVMT,Align:"Center",  ColMerge:1,   SaveName:"division",  KeyField:0,   CalcLogic:"",   Format:"" });
						      cols.push({Type:"AutoSum",   Hidden:0, Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
						      
				  var x = 1;	      
			      for ( var i=1; i <= headCnt - 3; i++) {
			    	  if (x < 10) {
			    		  sCount="count0" + x;
			    	  } else {
			    		  sCount="count" + x;
			    	  }

			    	  cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:sCount,      KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
			    	  x++;
			      }
			      
			      colsList.push(cols); 
			      cols=[];
			      
				  rowCnt = 1;
				  cnt = 0;
			      cols.push({Type:"Text",      Hidden:0,  Width:MTYIO,Align:"Center",  ColMerge:1,   SaveName:"inout",     KeyField:0,   CalcLogic:"",   Format:"" });
			      cols.push({Type:"Text",      Hidden:0,  Width:MTYMVMT,Align:"Center",  ColMerge:1,   SaveName:"division",  KeyField:0,   CalcLogic:"",   Format:"" });
			      cols.push({Type:"AutoSum",   Hidden:0, Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
			      
			      var x = 1;
			      for ( var i=1; i <= headCnt - 3; i++) {
			    	  if (x < 10) {
			    		  sCount="count0" + x;
			    	  } else {
			    		  sCount="count" + x;
			    	  }
			    	  
			    	  cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:sCount,      KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
			    	  x++;
			      }
			      
			      colsList.push(cols); 
			      cols=[];
			      
				  rowCnt = 2;
				  cnt = 0;
			      
		    	  cols.push({Type:"Text",      Hidden:0,  Width:MTYIO,Align:"Center",  ColMerge:1,   SaveName:"inout",     KeyField:0,   CalcLogic:"",   Format:"" });
		    	  cols.push({Type:"Text",      Hidden:0,  Width:MTYMVMT,Align:"Center",  ColMerge:1,   SaveName:"division",  KeyField:0,   CalcLogic:"",   Format:"" });
		    	  cols.push({Type:"AutoSum",   Hidden:0, Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
		    	  
		    	  var x = 1;
		    	  for ( var i=1; i <= headCnt - 3; i++) {
		    		  if (x < 10) {
		    			  sCount="count0" + x;
		    		  } else {
		    			  sCount="count" + x;
		    		  }

			    	  cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:sCount,      KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
			    	  x++;		    	  
		    	  }
		    	  
			      colsList.push(cols); 
			      cols=[];
		    	  
		    	  if (document.form.mtymvmt.value == 'MT') {
		    		  rowCnt=3;
		    		  cnt=0;
		    		  cols.push({Type:"Text",      Hidden:0,  Width:MTYIO,Align:"Center",  ColMerge:1,   SaveName:"inout",     KeyField:0,   CalcLogic:"",   Format:"" });
		    		  cols.push({Type:"Text",      Hidden:0,  Width:MTYMVMT,Align:"Center",  ColMerge:1,   SaveName:"division",  KeyField:0,   CalcLogic:"",   Format:"" });
		    		  cols.push({Type:"AutoSum",   Hidden:0, Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
		    		  
		    		  var x=1;
		    		  for ( var i=1; i <= headCnt - 3; i++) {
		    			  if (x < 10) {
		    				  sCount="count0" + x;
		    			  } else {
		    				  sCount="count" + x;
		    			  }
		    			  
			    		  cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:sCount,      KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
				    	  x++;			    			  
		    		  }
		    		  
				      colsList.push(cols); 
				      cols=[];
		    		  
					  rowCnt = 4;
					  cnt = 0;
		    		  cols.push({Type:"Text",      Hidden:0,  Width:MTYIO,Align:"Center",  ColMerge:1,   SaveName:"inout",     KeyField:0,   CalcLogic:"",   Format:"" });
		    		  cols.push({Type:"Text",      Hidden:0,  Width:MTYMVMT,Align:"Center",  ColMerge:1,   SaveName:"division",  KeyField:0,   CalcLogic:"",   Format:"" });
		    		  cols.push({Type:"AutoSum",   Hidden:0, Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
			    		  
		    		  var x = 1;
		    		  for ( var i=1; i <= headCnt - 3; i++) {
		    			  if (x < 10) {
		    				  sCount="count0" + x;
		    			  } else {
		    				  sCount="count" + x;
		    			  }
		    			  cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:sCount,      KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
//			    			  var x=1;
		    			  x++;
		    		  }
		    		  
				      colsList.push(cols); 
//				      cols=[];
//				    		  var headCnt=HeadTitle.split("|").length;
//				    		  FrozenCols=3;
//				    		  var rowCnt=0;
//				    		  var MTYIO=80;
//				    		  var MTYMVMT=80;
//				    		  var Division=80;
//				    		  var Total=80;
//				    		  var cnt=0;
//				    		  rowCnt=0;
//				    		  cnt=0;
//				    		  var x=1;
//				    		  x++;
//			    		  }
//				    	  rowCnt=1;
//				    	  cnt=0;
//				    	  var x=1;
//				    	  x++;
		    	  }
//				      rowCnt=2;
//				      cnt=0;
//				      var x=1;
//				      x++;
//			      }
//			      x++;
//			      }
//		      rowCnt=4;
//		      cnt=0;
//		      var x=1;
//		      x++;
	      }

      InitColumns(cols);
//      colsList.push(cols); 
      InitColumns(colsList , 4);
		      
      SetSheetHeight(435);
      //resizeSheet();
      SetEditable(1);
      SetExtendLastCol(0);
      }


		break;
	}
}
//Sheet의 높이 자동으로 변경
function resizeSheet(){
    for (i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i]);
    }
}
// handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	t1sheet1.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: 
		isOpen=true;
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObjects[0] = t1sheet1.Reset();
			initSheet(sheetObjects[0],0);
			formObj.f_cmd.value=COMMAND01;
			t1sheet1.SetWaitImageVisible(0);
			ComOpenWait(true);
			var sXml=t1sheet1.GetSearchData("EES_CIM_1051GS.do", FormQueryString(formObj));
			var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
			if (backendJobKey.length > 0) {
				ComSetObjValue(formObj.backendjob_key, backendJobKey);
				t1sheet1.SetWaitTimeOut(10000);
				timer1=setInterval(getBackEndJobStatus, 1000);
			}
		} else {
			return;
		}
		break;
	case IBSEARCH_ASYNC01:
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH03;
			var sXml=formObj.sXml.value;
			//	sheetObj.LoadSearchXml(sXml);
			var sTpsz=ComGetEtcData(sXml, "cntr_tpsz_cd");
			tot_cntr_tpsz_cd=sTpsz;
			if (sTpsz != undefined) {
				var arrTpsz=sTpsz.split("|");
				MakeComboObject(tpsz, arrTpsz);
			}
			sCntrTypeSize=ComGetEtcData(sXml, "cntrTypeSize");
			//getting changing column information from server
			if ((oldCntrTypeSize != sCntrTypeSize) && (sheetObj.id == "t1sheet1")) {
				oldCntrTypeSize=sCntrTypeSize;
				sheetObj = sheetObj.Reset();
				sheetObjects[0] = sheetObj;
				initSheet(sheetObjects[0]);
				//document.form.froms.focus();
			}
		}
		break;
	case IBSEARCH_ASYNC03: //location focusOut
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH02;
			imsi++;
			if (formObj.location.value == "") {
				return true;
			}
			sheetObj.SetWaitImageVisible(0);
			var queryString = FormQueryString(formObj);
			var sXml=sheetObj.GetSearchData("EES_CIM_1001GS.do", queryString);
			var sCheck=ComGetEtcData(sXml, "check");
			if (sCheck != "OK") {
				var inquiryLevel=document.getElementById("inquiryLevel").value;
				if (document.form.location.value != "") {
					if (inquiryLevel == "L") {
						formObj.location.value="";
						ComShowCodeMessage("CIM29018");
						ComSetFocus(document.form.location);
						sheetObj.SetWaitImageVisible(1);
						return false;
					} else if (inquiryLevel == "E") {
						formObj.location.value="";
						ComShowCodeMessage("CIM29019");
						ComSetFocus(document.form.location);
						sheetObj.SetWaitImageVisible(1);
						return false;
					} else if (inquiryLevel == "S") {
						formObj.location.value="";
						ComShowCodeMessage("CIM29020");
						sheetObj.SetWaitImageVisible(1);
						ComSetFocus(document.form.location);
						return false;
					} else if (inquiryLevel == "Y") {
						formObj.location.value="";
						ComShowCodeMessage("CIM29021");
						sheetObj.SetWaitImageVisible(1);
						ComSetFocus(document.form.location);
						return false;
					} else if (inquiryLevel == "R") {
						formObj.location.value="";
						ComShowCodeMessage("CIM29008");
						sheetObj.SetWaitImageVisible(1);
						ComSetFocus(document.form.location);
						return false;
					}
				} else {
					return true;
				}
			}
			ComSetFocus(document.form.soc);
		} else {
			return;
		}
		sheetObj.SetWaitImageVisible(1);
		break;
	}
}
//handling process for Sheet
function doActionIBSheet2(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH:
		isOpen=true;
		if (validateForm(sheetObj, formObj, sAction)) {
//			formObj.f_cmd.value=COMMAND04;
//			sheetObj.SetWaitImageVisible(0);
//			sheetObj.RenderSheet(0);
//			ComOpenWait(true);
//			var sXml=sheetObj.GetSearchData("EES_CIM_1051GS.do", FormQueryString(formObj));
//			var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
//			if (backendJobKey.length > 0) {
//				ComSetObjValue(formObj.backendjob_key, backendJobKey);
//				sheetObj.SetWaitTimeOut(10000);
//				timer1=setInterval(getBackEndJobStatus, 1000);
//			}

			sheetObjects[1] = t2sheet1.Reset();
			initSheet(sheetObjects[1] ,2);
			formObj.f_cmd.value=COMMAND04;
			t2sheet1.SetWaitImageVisible(0);
			ComOpenWait(true);
			var sXml=t2sheet1.GetSearchData("EES_CIM_1051GS.do", FormQueryString(formObj));
			var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
			if (backendJobKey.length > 0) {
				ComSetObjValue(formObj.backendjob_key, backendJobKey);
				t2sheet1.SetWaitTimeOut(10000);
				timer1=setInterval(getBackEndJobStatus, 1000);
			}
		
		
		} else {
			return;
		}
		break;
	}
}
function doActionIBSheet3(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH:
		isOpen=true;
		if (validateForm(sheetObj, formObj, sAction)) {
//			formObj.f_cmd.value=COMMAND05;
//			sheetObj.SetWaitImageVisible(0);
//			sheetObj.Reset();
//			initSheet(t3sheet1,2);
//			//			sheetObj.Redraw = false;
//			ComOpenWait(true);
//			formObj.gubun.value="T";
//			var sXml=sheetObj.GetSearchData("EES_CIM_1051GS.do", FormQueryString(formObj));
//			var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
//			if (backendJobKey.length > 0) {
//				ComSetObjValue(formObj.backendjob_key, backendJobKey);
//				ComSetObjValue(formObj.gubun, "T");
//				sheetObj.SetWaitTimeOut(10000);
//				timer1=setInterval(getBackEndJobStatus, 3000);
//			}
			
			
			//t3sheet1.Reset();
			sheetObjects[2] = t3sheet1.Reset();
			initSheet(sheetObjects[2],2);
			formObj.f_cmd.value=COMMAND05;
			t3sheet1.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.gubun.value="T";
			var sXml=t3sheet1.GetSearchData("EES_CIM_1051GS.do", FormQueryString(formObj));
			var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
			if (backendJobKey.length > 0) {
				ComSetObjValue(formObj.backendjob_key, backendJobKey);
				ComSetObjValue(formObj.gubun, "T");
				t3sheet1.SetWaitTimeOut(10000);
				timer1=setInterval(getBackEndJobStatus, 1000);
			}
			
		} else {
			return;
		}
		break;
	}
}
/**
 * checking until Status='3' for BackEndJob 
 */
function getBackEndJobStatus() {
	var formObj=document.form;
	var sheetObj="";
	var obj=document.form.gubun;
	if (obj.value == "S") {
		sheetObj=sheetObjects[0];
	} else if (obj.value == "D") {
		sheetObj=sheetObjects[1];
	} else if (obj.value == "T") {
		sheetObj=sheetObjects[2];
	}
	formObj.f_cmd.value=COMMAND02;
	var sXml=sheetObj.GetSearchData("EES_CIM_1051GS.do", FormQueryString(formObj));
	var jobState=ComGetEtcData(sXml, "jb_sts_flg");
	if (jobState == "3") {
		getBackEndJobLoadFile();
		clearInterval(timer1);
	} else if (jobState == "4") {
		ComShowCodeMessage("CIM29042");
		ComOpenWait(false);
		sheetObj.SetWaitImageVisible(1);
		clearInterval(timer1);
	} else if (jobState == "5") {
		ComShowCodeMessage("CIM29043");
		clearInterval(timer1);
	}
}
/**
 * downloading excel after ending BackEndJob
 */
function getBackEndJobLoadFile() {
	var formObj=document.form;
	var sheetObj="";
	var obj=document.form.gubun;
	if (obj.value == "S") {
		sheetObj = t1sheet1;
	} else if (obj.value == "D") {
		sheetObj = t2sheet1;
	} else if (obj.value == "T") {
		sheetObj = t3sheet1;
	}
	
	formObj.f_cmd.value=COMMAND03;
	var sXml="";
	if (obj.value == "T") {
		sXml=t3sheet1.GetSearchData("EES_CIM_10512GS.do", FormQueryString(form));
		var sPeriod=ComGetEtcData(sXml, "head");
		var HeadTitle="TP/SZ|MVMT|Total|" + sPeriod;
		//t3sheet1.RenderSheet(0);
		t3sheet1.RemoveAll();
		//t3sheet1.Reset();
		t3sheet1 = t3sheet1.Reset();
		sheetObjects[2] = t3sheet1;
		initSheet(sheetObjects[2], 1, HeadTitle);
		//t3sheet1.RenderSheet(1);
		t3sheet1.LoadSearchData(sXml,{Sync:0} );
		t3sheet1.SetSelectRow(0);
		t3sheet1.SetWaitImageVisible(1);
		ComOpenWait(false);
	} else {
	sXml=sheetObj.GetSearchData("EES_CIM_1051GS.do", FormQueryString(form));
	sheetObj.LoadSearchData(sXml,{Sync:0} );
	sheetObj.SetSelectRow(0);
	sheetObj.SetWaitImageVisible(1);
	ComOpenWait(false);
	}
}
/**
 * inputting values in ibMultiCombo 
 * @param cmbObj
 * @param arrStr
 * @return
 */
function MakeComboObject(cmbObj, arrStr) {
	cmbObj.InsertItem(0, 'ALL', '');
	for ( var i=1; i <= arrStr.length; i++) {
		cmbObj.InsertItem(i, arrStr[i - 1], arrStr[i - 1]);
	}
}
/**
 * event when clicking data part cell in IBSeet
 * @param {sheetObj} String : IBSheet cell name
 * @param {Row} Long : Row Index
 * @param {Col} Long : Column Index
 * @param {Value} String : changed value
 * @param {CellX} Long : x-coordinate
 * @param {CellY} Long : y-coordinate
 * @param {CellW} Long : cell width
 * @param {CellH} Long : cell height
 */
function t2sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// in case of existing cntr no in clicked row
		if (ComGetLenByByte(sheetObj.GetCellValue(Row, "cntrno")) > 0) {
			// making btn_t2EachCNTR Enable
			ComBtnEnable("btn_t2EachCNTR");
		} else {
			// making btn_t2EachCNTR Disable
			ComBtnDisable("btn_t2EachCNTR");
		}
		// in case of existing bkg no in clicked row
		if (ComGetLenByByte(sheetObj.GetCellValue(Row, "bkgno")) > 0) {
			// making btn_t2EachCNTR Enable
			ComBtnEnable("btn_t2EachBKG");
		} else {
			// making bbtn_t2EachCNTR Disable
			ComBtnDisable("btn_t2EachBKG");
		}
	}
}
/**
 * event when clicking data part cell in IBSeet
 * @param {sheetObj} String : IBSheet cell name
 * @param {Row} Long : Row Index
 * @param {Col} Long : Column Index
 * @param {Value} String : changed value
 * @param {CellX} Long : x-coordinate
 * @param {CellY} Long : y-coordinate
 * @param {CellW} Long : cell width
 * @param {CellH} Long : cell height
 */
function t2sheet1_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// in case of existing cntr no in double clicked row
		if (ComGetLenByByte(sheetObj.GetCellValue(Row, "cntrno")) > 0) {
			if (GetSelectCol()== 3) {
				var sUrl="/opuscntr/EES_CTM_0408_POP.do?" + "p_cntrno=" + sheetObj.GetCellValue(Row, "cntrno").substring(0, 10) + "&check_digit="
						+ sheetObj.GetCellValue(Row, "cntrno").substring(10, 11) + "&ctnr_tpsz_cd=" + sheetObj.GetCellValue(Row, "tpsz") + "&cnmv_evnt_dt="
						+ sheetObj.GetCellValue(Row, "pre_eventdate").substring(0, 8);
				ComOpenPopupWithTarget(sUrl, 1020, 682, "", "0,0", true, "yes");
			}
		}
		// in case of existing bkg no in double clicked row
		if (ComGetLenByByte(sheetObj.GetCellValue(Row, "bkgno")) > 0) {
			if (GetSelectCol()== 12) {
				var sUrl="/opuscntr/EES_CTM_0409_POP.do?" + "bkg_no=" + sheetObj.GetCellValue(Row, "bkgno");
				ComOpenPopupWithTarget(sUrl, 1020, 682, "", "0,1", true, "yes");
			}
		}
	}
}
/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++]=tab_obj;
}
/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt=0;
			InsertItem( "Summary", "");
			InsertItem( "   Detail   ", "");
			InsertItem( "   Trend    ", "");
			//TabLayout = 2;
		}
		break;
	}
}
/**
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (t1sheet1) {
		RenderSheet(1);
		SetAutoSumPosition(0);
		SetSumText(0, 0,"");
		SetCellAlign(1, "division","Center");
		if (document.form.mtymvmt.value == "MT") {
			SetSumText(0, 0,"MT");
		}
		else if(document.form.mtymvmt.value == "VL") {
			SetSumText(0, 0,"VL(Full)");
		}
		else if(document.form.mtymvmt.value == "VD") {
			SetSumText(0, 0,"VD(Full)");
		}
		SetSumBackColor("#FFFFFF");
		SetSumFontBold(0);
		if (document.form.mtymvmt.value == "MT" || document.form.mtymvmt.value == "VL" || document.form.mtymvmt.value == "VD") {
			var arrTime=sCntrTypeSize.split(",");
			for ( var i=2; i < arrTime.length + 2; i++) {
				if (comboObjects[0].GetSelectCode().indexOf(arrTime[i - 2]) == -1 && comboObjects[0].GetSelectCode()!= "") {
					SetSumText(0, i,"");
				}
			}
		}
	}
}
/**
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	t2sheet1.RenderSheet(1);
	if (ComGetLenByByte(sheetObj.GetCellValue(1, "cntrno")) > 0) {
		// making btn_t2EachCNTR Enable
		ComBtnEnable("btn_t2EachCNTR");
	} else {
		// making btn_t2EachCNTR Disable
		ComBtnDisable("btn_t2EachCNTR");
	}
	// in case of existing bkg no in clicked row
	if (ComGetLenByByte(sheetObj.GetCellValue(1, "bkgno")) > 0) {
		// making btn_t2EachCNTR Enable
		ComBtnEnable("btn_t2EachBKG");
	} else {
		// making bbtn_t2EachCNTR Disable
		ComBtnDisable("btn_t2EachBKG");
	}
}
/**
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (t3sheet1) {
//		RenderSheet(1);
		//		AutoSumBottom = false;
		SetSumText(0, 0,"Total");
		//SumText(0, 1) = CellValue(RowCount, "division");
		if (document.form.mtymvmt.value == "MT") {
			SetCellAlign(LastRow(), "division","Center");
			SetCellAlign(LastRow()- 1, "division","Center");
			SetCellAlign(LastRow()- 2, "division","Center");
			SetCellAlign(LastRow()- 3, "division","Center");
			SetCellAlign(LastRow()- 4, "division","Center");
			SetSumText(0, 1,"MT");
			SetSumText(1, 1,"MG");
			SetSumText(2, 1,"MP");
			SetSumText(3, 1,"MR");
			SetSumText(4, 1,"VD-MT");
		}
		else if(document.form.mtymvmt.value == "VL"){
			SetCellAlign(LastRow(), "division","Center");
			SetCellAlign(LastRow()- 1, "division","Center");
			SetCellAlign(LastRow()- 2, "division","Center");
			SetSumText(0, 1,"VL(Full)");
			SetSumText(1, 1,"OC-VL");
			SetSumText(2, 1,"TS-VL");
		}
		else if(document.form.mtymvmt.value == "VD"){
			SetCellAlign(LastRow(), "division","Center");
			SetCellAlign(LastRow()- 1, "division","Center");
			SetCellAlign(LastRow()- 2, "division","Center");
			SetSumText(0, 1,"VD(Full)");
			SetSumText(1, 1,"VD-IC");
			SetSumText(2, 1,"VD-TS");
		}
		else {
			SetColHidden(1,1);
		}
		//CellAlign(1, "division") = daCenter;
		//		SumBackColor = "#FFFFFF";
		//		SumFontBold = false;
		/*
		 if (document.form.mtymvmt.value == "") {
		 var arrTime=sPeriod.split("|");
		 for ( var i=2; i < arrTime.length + 3; i++) {
	if (GetCellValue(RowCount(), 0) == "MTY Out") {
	SetSumValue(0, i,parseInt(GetSumValue(0, i))
- (parseInt(GetCellValue(RowCount(), i)) + parseInt(GetCellValue(
		 RowCount()+ 1, i)));
		 }
		 }
		 }
		 */
	}
}
/**
 * event when clicking Tab
 * activating selected tab items
 */
function tab1_OnChange(tabObj, nItem) {
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab].style.display="none";
	//--------------- important --------------------------//
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
	//------------------------------------------------------//
	beforetab=nItem;
	tabIndex=nItem;
	resizeSheet();
	if (nItem == 0) {
		ComSetObjValue(document.form.gubun, "S");
		var preinquiryLevel=document.form.inquiryLevel.value;
		init_inquiryLevel();
		document.form.inquiryLevel.value=preinquiryLevel;
	} else if (nItem == 1) {
		ComSetObjValue(document.form.gubun, "D");
		var preinquiryLevel=document.form.inquiryLevel.value;
		init_inquiryLevel();
		document.form.inquiryLevel.value=preinquiryLevel;
	} else if (nItem == 2) {
		ComSetObjValue(document.form.gubun, "T");
		var preinquiryLevel=document.form.inquiryLevel.value;
		init_inquiryLevel();
		document.form.inquiryLevel.value=preinquiryLevel;
	}
}
/**
 * event when clicking Tab
 * activating selected tab items
 */
function tab1_OnClick(tabObj, nItem) {
	beforetab=nItem;
	tabIndex=nItem;
	if (isOpen) {
		if (nItem == 0) {
			ComSetObjValue(document.form.gubun, "S");
			if(document.form.inquiryLevel.value !="") {
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}			
			//			sheetObjects[1].RemoveAll();
			//			sheetObjects[2].RemoveAll();
			var preinquiryLevel=document.form.inquiryLevel.value;
			init_inquiryLevel();
			sheetObjects[0].SetSelectRow(0);
			document.form.inquiryLevel.value=preinquiryLevel;
		} else if (nItem == 1) {
			ComSetObjValue(document.form.gubun, "D");
			if(document.form.inquiryLevel.value != "R" && document.form.inquiryLevel.value !="") {
				doActionIBSheet2(sheetObjects[1], document.form, IBSEARCH);
			} else {
				sheetObjects[2] = sheetObjects[2].Reset();
			}
			var preinquiryLevel=document.form.inquiryLevel.value;
			init_inquiryLevel();
			document.form.inquiryLevel.value=preinquiryLevel;
			sheetObjects[1].SetSelectRow(0);
		} else if (nItem == 2) {
			ComSetObjValue(document.form.gubun, "T");
			doActionIBSheet3(sheetObjects[2], document.form, IBSEARCH);
			var preinquiryLevel=document.form.inquiryLevel.value;
			init_inquiryLevel();
			document.form.inquiryLevel.value=preinquiryLevel;
		}
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		switch (sAction) {
		case IBSEARCH: 
			if (period.value == "M") {
				if (froms.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(froms);
					return false;
				}
				if (tos.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(tos);
					return false;
				}
				if (froms.value.length < 6) {
					return false;
				} else if (tos.value.length < 6) {
					return false;
				}
			} else if (period.value == "W") {
				if (froms.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(froms);
					return false;
				}
				if (tos.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(tos);
					return false;
				}
				if (froms.value.length < 6) {
					return false;
				} else if (tos.value.length < 6) {
					return false;
				}
			} else if (period.value == "D") {
				if (froms.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(froms);
					return false;
				}
				if (tos.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(tos);
					return false;
				}
				if (froms.value.length < 8) {
					return false;
				} else if (tos.value.length < 8) {
					return false;
				}
			}
//			if (!enterSwitch) {
//				return false;
//			}
			if (location.value == "") {
				ComShowCodeMessage("CIM21001", "Location ");
				ComSetFocus(location);
				return false;
				/*
				if (inquiryLevel.value == "L") {
					ComShowCodeMessage("CIM29014");
					ComSetFocus(location);
					return false; 
				} else if (inquiryLevel.value == "E") {
					ComShowCodeMessage("CIM29015");
					ComSetFocus(location);
					return false;
				} else if (inquiryLevel.value == "S") {
					ComShowCodeMessage("CIM29016");
					ComSetFocus(location);
					return false;
				} else if (inquiryLevel.value == "Y") {
					ComShowCodeMessage("CIM29017");
					ComSetFocus(location);
					return false;
				}
				*/
			}
			break;
		}
	}
	return true;
}
function init_inquiryLevel(){
	if(document.form.gubun.value == "S"){
		ComClearCombo(document.form.inquiryLevel);
		ComAddComboItem(document.form.inquiryLevel,"RCC","R");
		ComAddComboItem(document.form.inquiryLevel,"LCC","L");
		ComAddComboItem(document.form.inquiryLevel,"ECC","E");
		ComAddComboItem(document.form.inquiryLevel,"SCC","S");
		ComAddComboItem(document.form.inquiryLevel,"Yard","Y");
	}else{
		if(document.form.inquiryLevel.value == "R"){
			document.form.location.value="";
		}
		ComClearCombo(document.form.inquiryLevel);
		ComAddComboItem(document.form.inquiryLevel,"LCC","L");
		ComAddComboItem(document.form.inquiryLevel,"ECC","E");
		ComAddComboItem(document.form.inquiryLevel,"SCC","S");
		ComAddComboItem(document.form.inquiryLevel,"Yard","Y");
	}
}
/* end of developer job */
