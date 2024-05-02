/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1020.js
*@FileTitle  : Lane M/B by Logistics-Wise
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23 
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* developer job   */
// common global variables
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var oldCntrTypeSize="";
var sCntrTypeSize="";
var tabIndex=0;
var isOpen=false;
var comboObjects=new Array();
var comboCnt=0;
// controlling XTC data event  
var enterSwitch=false;
var oldComboVal01="";
var oldComboVal02="";
var oldComboVal03="";
var oldComboFlg01="N";
var oldComboFlg02="N";
var oldComboFlg03="N";
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick() {
	var shtCnt=0;
	var t1sheet1=sheetObjects[shtCnt++];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(t1sheet1, formObject, IBSEARCH);
			sheetObjects[0].SetSelectRow(0);
			break;
		case "btn_downexcel":
			if(sheet1.RowCount() < 1){//no data
    			ComShowCodeMessage("COM132501");
    		}else{
//    			t1sheet1.Down2Excel({ HiddenColumn:-1,Merge:true});
    			//sheet1.Down2Excel({ HiddenColumn:-1,Merge:true});
    			sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(sheet1), SheetDesign:1,Merge:1 });
    		}
			break;
		case "btn_new":
			sheet1.RemoveAll();
			comboObjects[0].SetSelectCode("");
			comboObjects[1].SetSelectCode("");
			comboObjects[2].SetSelectCode("");
			comboObjects[1].RemoveAll();
			comboObjects[2].RemoveAll();
			comboObjects[1].SetEnable(0);
			comboObjects[2].SetEnable(0);
			formObject.reset();
			formObject.rdtype.disabled=true;
			ComSetFocus(formObject.froms);
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("CIM30032");
		} else {
			alert("Error : [" + e + "]");
		}
	}
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
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	axon_event.addListenerForm('click', 'obj_tpsz_click', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 
	axon_event.addListenerForm('blur', 'obj_deactivate', form); 
	for ( var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
	sheet1_OnLoadFinish(sheet1);
//	doActionIBSheet(sheet1, document.form, IBSEARCH);
}
function sheet1_OnLoadFinish(sheetObj) {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	comboObjects[1].DisabledBackColor="#FFFFFF";
	comboObjects[1].SetEnable(0);
	comboObjects[2].DisabledBackColor="#FFFFFF";
	comboObjects[2].SetEnable(0);
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
function obj_tpsz_click() {
	obj=ComGetEvent();
	if (obj.name == "tpsz") { // by TP/SZ kind
		if (obj.value != "R") {
			document.form.rdtype.disabled=true;
			document.form.rdtype.value="I";
		} else {
			document.form.rdtype.disabled=false;
		}
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
		if (retMonth >= 12) {
			if (ComGetEvent("name") == "tos") {
				ComShowCodeMessage("CIM21031");
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
		if (week > 26) {
			if (ComGetEvent("name") == "tos") {
				ComShowCodeMessage("CIM21031");
				ComSetFocus(document.getElementById("tos"));
			}
			return false;
		}
	} else if (period == "D") {
		if (retDate >= 31) {
			if (ComGetEvent("name") == "tos") {
				ComShowCodeMessage("CIM29029");
				ComSetFocus(document.getElementById("tos"));
			}
			return false;
		}
	}
}
//function for handling event
function obj_deactivate() {
	var f=document.getElementById("froms");
	var t=document.getElementById("tos");
	sVal1=f.value.replace(/\/|\-|\./g, "");
	sVal2=t.value.replace(/\/|\-|\./g, "");
	switch (ComGetEvent("name")) {
	case "froms":
		if (ComChkObjValid(ComGetEvent(), false)) {
			if (f.getAttribute("dataformat") == "ym") {
				if (sVal1 != "" && sVal2 != "") {
					var day=lastDay(sVal2.substring(0, 4), sVal2.substring(4, 6));
					var flag=ComChkPeriod(sVal1 + "01", sVal2 + day);
					if (flag < 1) {
						enterSwitch=false;
						t.value="";
//						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							t.value="";
//							t.focus();
							t.select();
							return false;
						}
					}
					document.getElementById("from").value=sVal1 + "01";
					document.getElementById("to").value=sVal2 + day;
				}
			} else { // retrieving by week
				if (sVal1 != "" && sVal2 != "") {
					if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
						ComShowCodeMessage("CIM29003");
						enterSwitch=false;
						t.value="";
//						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							t.value="";
//							t.focus();
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
					ComGetEvent().value="";
					ComShowCodeMessage("CIM21004", "YYYYMM");
					enterSwitch=false;
//					ComGetEvent().focus();
					ComGetEvent().select();
					return false;
				}
			} else { // retrieving by week
				if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6)) && ComGetEvent("name") == 'froms') {
					ComGetEvent().value="";
					ComShowCodeMessage("CIM21004", "YYYYWW");
//					ComGetEvent().focus();
					ComGetEvent().select();
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
						ComGetEvent().value="";
//						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							ComGetEvent().value="";
//							t.focus();
							t.select();
							return false;
						}
					}
				}
				document.getElementById("from").value=sVal1 + "01";
				document.getElementById("to").value=sVal2 + day;
			} else { // retrieving by week
				if (sVal1 != "" && sVal2 != "") {
					if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
						if (ComGetEvent("name") == "tos") {
							ComShowCodeMessage("CIM29003");
						}
						enterSwitch=false;
						ComGetEvent().value="";
//						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							ComGetEvent().value="";
							t.focus();
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
					ComGetEvent().value="";
					ComShowCodeMessage("CIM21004", "YYYYMM");
//					t.focus();
					t.select();
					return false;
				}
			} else { // retrieving by week
				if (sVal2.length > 0 && !ComIsWeek(sVal2.substring(4, 6))) {
					enterSwitch=false;
					ComGetEvent().value="";
					ComShowCodeMessage("CIM21004", "YYYYWW");
//					t.focus();
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
	document.form.to.value=y + m + day;
}
function obj_change() {
	obj=ComGetEvent();
	if (obj.name == "period") {
		if (obj.value == "M") {
			document.getElementById("froms").setAttribute("dataformat", "ym");
			document.getElementById("tos").setAttribute("dataformat", "ym");
			document.form.froms.value="";
			document.form.tos.value="";
			document.form.from.value="";
			document.form.to.value="";
		} else {
			document.getElementById("froms").setAttribute("dataformat", "yw");
			document.getElementById("tos").setAttribute("dataformat", "yw");
			document.form.froms.value="";
			document.form.tos.value="";
			document.form.from.value="";
			document.form.to.value="";
		}
		comboObjects[2].RemoveAll(); // VVD삭제
//		document.getElementById("froms").focus();
	} else if (obj.name == "pol") {
		//          alert("change pol");
	}
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": //t1sheet1 init
		with (sheetObj) {
	    if (location.hostname != "")
	    var HeadTitle1="Lane|VVD|Division|Total";
	    oldCntrTypeSize=sCntrTypeSize;
	    var arrCntrTypeSize=oldCntrTypeSize.split(",");
	    if (sCntrTypeSize != "") {
	    for ( var i=0; i < arrCntrTypeSize.length; i++) {
	    HeadTitle1 += "|" + arrCntrTypeSize[i];
	    }
	    }
	    sheetObj.FrozenCols=4;
	    SetWaitTimeOut(300);
	    var RowCnt=0;
	    cnt=0;

//	    SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:7, Page:20, DataRowMerge:1 } );
	    SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:5, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );

	    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	    InitHeaders(headers, info);
	    var i=0;
	    var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lane_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"" },
	              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"division",      KeyField:0,   CalcLogic:"",   Format:"" },
	              {Type:"Text",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",         KeyField:0,   CalcLogic:"",   Format:"" } ];
	    for (; i < arrCntrTypeSize.length -13; i++) {
	    arEtcData="_" + i;
	    cols.push({Type:"Text",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"qty"+arEtcData, KeyField:0,   CalcLogic:"",   Format:"" });
	    }
	    cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lane_cd",       KeyField:0,   CalcLogic:"",   Format:"" });
	    cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"" });
	    cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"division",      KeyField:0,   CalcLogic:"",   Format:"" });
	    cols.push({Type:"Text",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",         KeyField:0,   CalcLogic:"",   Format:"" });
	    for (; i < arrCntrTypeSize.length -13; i++) {
	    arEtcData="_" + i;
	    cols.push({Type:"Text",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"qty"+arEtcData, KeyField:0,   CalcLogic:"",   Format:"" });
	    }
	    cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lane_cd",       KeyField:0,   CalcLogic:"",   Format:"" });
	    cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"" });
	    cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"division",      KeyField:0,   CalcLogic:"",   Format:"" });
	    cols.push({Type:"Text",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",         KeyField:0,   CalcLogic:"",   Format:"" });
	    for (; i < arrCntrTypeSize.length -13; i++) {
	    arEtcData="_" + i;
	    cols.push({Type:"Text",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"qty"+arEtcData, KeyField:0,   CalcLogic:"",   Format:"" });
	    }
	    cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lane_cd",       KeyField:0,   CalcLogic:"",   Format:"" });
	    cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"" });
	    cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"division",      KeyField:0,   CalcLogic:"",   Format:"" });
	    cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",         KeyField:0,   CalcLogic:"",   Format:"" });
	    for (; i < arrCntrTypeSize.length -13; i++) {
	    arEtcData="_" + i;
	    cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"qty"+arEtcData, KeyField:0,   CalcLogic:"",   Format:"" });
	    }
	    cols.push({Type:"AutoSum",   Hidden:1, Width:100,  Align:"Left",    ColMerge:1});
	    
	    InitColumns(cols);
	    SetSheetHeight(455);
	    resizeSheet();
	    SetEditable(0);

		}
		break;
	}
}
//Sheet의 높이 자동으로 변경
function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}
//handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH:
		isOpen=true;
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
 			var sXml=sheetObj.GetSearchData("EES_CIM_1020GS.do", FormQueryString(formObj));
			sheet1.LoadSearchData(sXml,{Sync:0});
			sheet1.SetWaitImageVisible(1);
			ComOpenWait(false);
		} else {
			return;
		}
		break;
	case IBSEARCH_ASYNC01:
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH03;
			var sXml=formObj.sXml.value;
			sCntrTypeSize=ComGetEtcData(sXml, "cntrTypeSize");
			// getting changing column information from server
			if ((oldCntrTypeSize != sCntrTypeSize)) {
				oldCntrTypeSize=sCntrTypeSize;
				sheetObjects[0] = sheet1.Reset();
//				sheet1.RenderSheet(0);
				initSheet(sheetObjects[0], 1);
//				sheet1.RenderSheet(1);
			}
			var sPol=ComGetEtcData(sXml, "sPort");
			if (sPol != undefined) {
				var arrPol=sPol.split("|");
				MakeComboObject(pol, arrPol);
			}
			var sLane=ComGetEtcData(sXml, "sLane");
			if (sLane != undefined) {
				var arrLane=sLane.split(",");
				MakeComboObject2(lane, arrLane);
			}
		}
		//sheetObj.LoadSearchXml(sXml);
		break;
	case IBSEARCH_ASYNC02: //retrieving VVD COMBO
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH01;
			sheetObj.SetWaitImageVisible(0);
//			document.getElementById("cursors").style.cursor="wait";
//			document.getElementById("btn_Retrieve").style.cursor="wait";
 			var sXml=sheetObj.GetSearchData("EES_CIM_1020GS.do", FormQueryString(formObj));
			//              sheetObj.LoadSearchXml(sXml);
			var sVvd=ComGetEtcData(sXml, "sVvd");
			if (sVvd != undefined) {
				var arrVvd=sVvd.split("|");
				MakeComboObject(vvd, arrVvd);
				comboObjects[2].SetEnable(1);
				var tid=setTimeout('lanenextfocus()', 500);
//				document.form.lanenext.focus();
			}
			document.getElementById("cursors").style.cursor="";
			document.getElementById("btn_Retrieve").style.cursor="";
			sheetObj.SetWaitImageVisible(1);
		} else {
			return;
		}
		break;
	case IBSEARCH_ASYNC03: //retrieving Lane COMBO 
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH05;
			sheetObj.SetWaitImageVisible(0);
			document.getElementById("cursors").style.cursor="wait";
			document.getElementById("btn_Retrieve").style.cursor="wait";
 			var sXml=sheetObj.GetSearchData("EES_CIM_1007GS.do", FormQueryString(formObj));
			//sheetObj.LoadSearchXml(sXml);
			var sVvd=ComGetEtcData(sXml, "sLane");
			if (sVvd != undefined) {
				var arrVvd=sVvd.split(",");
				MakeComboObject2(lane, arrVvd);
				comboObjects[1].SetEnable(1);
				var tid=setTimeout('polnextfocus()', 500);
//				document.form.polnext.focus();
			}
			document.getElementById("cursors").style.cursor="";
			document.getElementById("btn_Retrieve").style.cursor="";
			sheetObj.SetWaitImageVisible(1);
		} else {
			return;
		}
		break;
	}
}
function initCombo(comboObj, comboNo) {
	switch (comboObj.options.id) {
	case "pol":
		var i=0;
		with (comboObj) {
			ValidChar(2,1);    // Uppercase			
			SetBackColor("#CCFFFF");
			SetDropHeight(200);
			SetMultiSelect(0);
			SetMaxSelect(1);
			SetMaxLength(5);
			comboObj.SetUseAutoComplete(1);
		}
		break;
	case "lane":
		with (comboObj) {
		ValidChar(2,1);    // Uppercase		
		SetColAlign(0, "center");
		SetColAlign(1, "left");
		SetColWidth(0, "50");
		SetColWidth(1, "200");
		SetTitle("lane|Description");
			SetMultiSelect(0);
			SetMaxSelect(1);
			SetDropHeight(200);
			SetMaxLength(3);
			comboObj.SetUseAutoComplete(1);
		}
		break;
	case "vvd":
		var i=0;
		with (comboObj) {
			ValidChar(2,1);    // Uppercase			
			SetDropHeight(200);
			SetMultiSelect(0);
			SetMaxSelect(1);
			SetMaxLength(9);
			comboObj.SetUseAutoComplete(1);
		}
		break;
	}
}
function MakeComboObject(cmbObj, arrStr) {
	for ( var i=0; i < arrStr.length; i++) {
		cmbObj.InsertItem(i, arrStr[i], arrStr[i]);
	}
}
function MakeComboObject2(cmbObj, arrStr) {
	for ( var i=0; i < arrStr.length; i++) {
		cmbObj.InsertItem(i, arrStr[i], arrStr[i].substring(0, 3).trim());
	}
}
/**
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++]=tab_obj;
}
/**
 * Event when clicking Tab
 * activating selected tab items
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt=0;
			InsertItem( "Summary", "");
			InsertItem( "Detail", "");
		}
		break;
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
	//--------------- inportant  --------------------------//
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
	//------------------------------------------------------//
	beforetab=nItem;
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
			if (comboObjects[0].GetSelectCode()== "") {
				ComShowCodeMessage("CIM21001", "PORT CODE");
				ComSetFocus(pol);
				return false;
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
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		sheetObj.SetRowHidden(sheetObj.LastRow(),1);
		
		
		
		var preValue = '';
		var preValue1 = '';
		var nowValue = '';
		var nowValue1 = '';
		var begPos = 1;
		var begPos1 = 1;
		var colIndex = 0;
		var colIndex1 = 1;
		for ( var i=1; i <= sheetObj.RowCount()+1 ; i++) {
			 nowValue = sheetObj.GetCellValue(i,colIndex);
			 if (i!=1 && preValue != nowValue) {
				 sheetObj.SetMergeCell(begPos,colIndex,i-begPos,1);
				 begPos = i;
			 }
			 preValue = nowValue;
			 
			 
		 }
		
		
		for ( var i=1; i <= sheetObj.RowCount() ; i++) {
			nowValue1 = sheetObj.GetCellValue(i,colIndex1);
			 if (i!=1 && preValue1 != nowValue1) {
				 sheetObj.SetMergeCell(begPos1,colIndex1,i-begPos1,1);
				 begPos1 = i;
			 }
			 preValue1 = nowValue1;
		 }	
		
		sheetObj.SetMergeCell(sheetObj.RowCount()-7 , 1, 4, 1);
		sheetObj.SetMergeCell(sheetObj.RowCount()-3 , 1, 4, 1);
		
//		var arrTime=sCntrTypeSize.split(",");
//		for ( var i=3; i < arrTime.length + 4; i++) {
//			if (GetCellValue(LastRow()- 4, i) == "") {
// 				SetSumText(0, i,"");
// 				SetSumText(1, i,"");
// 				SetSumText(2, i,"");
// 				SetSumText(3, i,"");
//			}
//		}
//		for ( var i=3; i < arrTime.length + 4; i++) {
//			SetSumText(0, i,ComAddComma(GetCellValue(RowCount()- 3, i)));
//			SetSumText(1, i,ComAddComma(GetCellValue(RowCount()- 2, i)));
//			SetSumText(2, i,ComAddComma(GetCellValue(RowCount()- 1, i)));
//			SetSumText(3, i,GetCellValue(RowCount(), i));
// 			SetCellFontColor(LastRow()- 1, i,"#000000");
// 			SetCellFontColor(LastRow(), i,"#000000");
// 			if (GetSumValue(0, i) >= GetSumValue(1, i)) {
// 				if (GetSumValue(0, i) > 0) {
// 					var tVal01=Math.round(GetSumValue(1, i) / GetSumValue(0, i) * 100);
// 					SetSumText(3, i,tVal01 + "%");
//					if (tVal01 < 0) {
// 						SetCellFontColor(LastRow()- 1, i,"#DC0000");
// 						SetCellFontColor(LastRow(), i,"#DC0000");
//					}
//				} else {
//					if (GetSumValue(2, i) < 0) {
// 						SetCellFontColor(LastRow()- 1, i,"#DC0000");
//					}
// 					SetSumText(3, i,'0%');
//				}
// 			} else if (GetSumValue(1, i) > 0) {
// 				var tVal02=Math.round((GetSumValue(0, i) / GetSumValue(1, i) * (-1)) * 100);
// 				if (GetSumValue(2, i) < 0) {
// 					SetCellFontColor(LastRow()- 1, i,"#DC0000");
//				}
// 				SetSumText(3, i,tVal02 + "%");
//				if (tVal02 < 0) {
// 					SetCellFontColor(LastRow()- 1, i,"#DC0000");
// 					SetCellFontColor(LastRow(), i,"#DC0000");
//				}
//			} else {
// 				SetSumText(3, i,'0%');
//			}
//		}
//		if (RowCount()> 0) {
//			SetRowHidden(RowCount()- 3,1);
//			SetRowHidden(RowCount()- 2,1);
//			SetRowHidden(RowCount()- 1,1);
//			SetRowHidden(RowCount(),1);
//		}
// 		SetSumText(0, "lane_cd","");
// 		SetSumText(0, "vvd","G.Total");
///*
// 		SetSumText(1, "lane_cd","G.Total");
// 		SetSumText(2, "lane_cd","G.Total");
// 		SetSumText(3, "lane_cd","G.Total");
// 		SetSumText(0, "vvd","G.Total");
// 		SetSumText(1, "vvd","G.Total");
// 		SetSumText(2, "vvd","G.Total");
// 		SetSumText(3, "vvd","G.Total");
//*/		SumText(0, "division") = "I/B";
// 		SetSumText(1, "division","O/B");
// 		SetSumText(2, "division","Balance");
// 		SetSumText(3, "division","M/B(%)");
//		SetCellAlign(LastRow()- 3, "lane_cd","Center");
//		SetCellAlign(LastRow()- 2, "lane_cd","CenterTop");
//		SetCellAlign(LastRow()- 1, "lane_cd","CenterTop");
//		SetCellAlign(LastRow(), "lane_cd","CenterTop");
//		SetCellAlign(LastRow()- 3, "vvd","Center");
//		SetCellAlign(LastRow()- 2, "vvd","CenterTop");
//		SetCellAlign(LastRow()- 1, "vvd","CenterTop");
//		SetCellAlign(LastRow(), "vvd","CenterTop");
//		SetCellAlign(LastRow()- 3, "division","Center");
//		SetCellAlign(LastRow()- 2, "division","Center");
//		SetCellAlign(LastRow()- 1, "division","Center");
//		SetCellAlign(LastRow(), "division","Center");
////		SetMergeCell(LastRow-3 , 0, 1, 2);
	}
}
/**
 * 
 * @return
 */
function pol_OnFocus() {
	comboObjects[1].SetEnable(1);
	comboObjects[2].SetEnable(1);
}
function polnextfocus() {
	comboObjects[1].focus();
}
function lanenextfocus() {
	comboObjects[2].focus();
}
function prepolnextfocus() {
	comboObjects[0].focus();
}
/**
 * 
 * @param KeyCode
 * @param Shift
 * @return
 */
function pol_OnBlur(KeyCode, Shift) {
	flag=false;
	if (comboObjects[0].GetSelectText().length > 0) {
		comboObjects[0].SetSelectText(comboObjects[0].GetSelectText().toUpperCase());
		for ( var i=0; i < comboObjects[0].GetItemCount(); i++) {
			if (comboObjects[0].GetSelectText()== comboObjects[0].GetText(i, 0)) {
				flag=true;
				//pols_OnChange();
				break;
			}
		}
		if (flag == false) {
			ComShowCodeMessage("CIM29011");
			comboObjects[0].SetSelectText("");
			comboObjects[2].RemoveAll();
//			comboObjects[0].focus();
			return false;
		} else {
			comboObjects[1].RemoveAll();
			comboObjects[2].RemoveAll();
			comboObjects[2].SetEnable(1);
		}
	} else {
		comboObjects[1].RemoveAll();
		comboObjects[2].RemoveAll();
	}
}
/**
 * validating lane code input value
 * @param KeyCode
 * @param Shift
 * @return
 */
function lane_OnBlur(KeyCode, Shift) {
	flag=false;
	if (comboObjects[1].GetSelectText().length > 0) {
		comboObjects[1].SetSelectText(comboObjects[1].GetSelectText().toUpperCase());
		for ( var i=0; i < comboObjects[1].GetItemCount(); i++) {
			if (comboObjects[1].GetSelectText()== comboObjects[1].GetText(i, 0)) {
				flag=true;
				break;
			}
		}
		if (flag == false) {
			ComShowCodeMessage("CIM29012");
			comboObjects[1].SetSelectText("");
			comboObjects[2].RemoveAll();
//			comboObjects[1].focus();
			return true;
		} else {
			comboObjects[2].RemoveAll();
			comboObjects[2].SetEnable(1);
		}
	} else {
		comboObjects[2].RemoveAll();
	}
}
function lane_OnFocus(comboObj) {
	comboObjects[2].SetEnable(1);
	if (comboObjects[1].GetItemCount() <= 0) {
		comboObj.SetEnable(0);
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
		if (comboObjects[1].GetItemCount() > 0) {
			comboObj.SetEnable(1);
//			comboObjects[1].focus();
		}
	}
}
function vvd_OnFocus(comboObj) {
	var f=document.form;
	flag=false;
	if (comboObjects[0].GetSelectText()== "") {
		ComShowCodeMessage("CIM29027");
//		document.form.prepolnext.focus();
		return false;
	}
	if (comboObjects[2].GetItemCount() <= 0) {
		comboObj.SetEnable(0);
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
		if (comboObjects[2].GetItemCount() > 0) {
			comboObj.SetEnable(1);
//			comboObjects[2].focus();
		}
	}
}
/**
 * validating vvd code input value
 * @param KeyCode
 * @param Shift
 * @return HNDT0087E
 */
function vvd_OnBlur(KeyCode, Shift) {
	flag=false;
	if (comboObjects[2].GetSelectText().length > 0) {
		comboObjects[2].SetSelectText(comboObjects[2].GetSelectText().toUpperCase());
		for ( var i=0; i < comboObjects[2].GetItemCount(); i++) {
			if (comboObjects[2].GetSelectText()== comboObjects[2].GetText(i, 0)) {
				flag=true;
				break;
			}
		}
		if (flag == false) {
			ComShowCodeMessage("CIM29023");
			comboObjects[2].SetSelectText("");
//			comboObjects[2].focus();
			return;
		}
		//document.form.flowpattern.focus();
	}
}
/* end of developer job */
