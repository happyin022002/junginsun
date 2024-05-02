/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_CIM_1007.js
*@FileTitle  : Turn Time by Lane  VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// common global variables
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var oldCntrTypeSize="";
var sCntrTypeSize="";
var oldCntrTypeSize2="";
var tabIndex=0;
var isOpen=true;
var enterSwitch=false;
var comboObjects=new Array();
var comboCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var shtCnt=0;
	var t1sheet1=sheetObjects[shtCnt++];
	var t2sheet1=sheetObjects[shtCnt++];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_Retrieve":
			if (tabIndex == 0) {
				doActionIBSheet(t1sheet1, formObject, IBSEARCH);
				sheetObjects[0].SetSelectRow(0);
			} else {
				doActionIBSheet2(t2sheet1, formObject, IBSEARCH);
				sheetObjects[1].SetSelectRow(0);
			}
			break;
		case "btn_downExcel":
			if (tabIndex == 0) {
				if(t1sheet1.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
//					t1sheet1.Down2Excel({ HiddenColumn:-1});
					t1sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(t1sheet1), SheetDesign:1,Merge:1 });
				}				
			} else {
				if(t2sheet1.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
//					t2sheet1.Down2Excel({ HiddenColumn:-1});
					t2sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(t2sheet1), SheetDesign:1,Merge:1 });
				}
				
			}
			break;
		case "btn_new":
			if(t1sheet1.RowCount() > 0){
				t1sheet1.RemoveAll();
			}
			if(t2sheet1.RowCount() > 0){
				t2sheet1.RemoveAll();
			}
			comboObjects[1].RemoveAll();
			comboObjects[2].RemoveAll();
			formObject.reset();
			comboObjects[0].SetSelectCode("");
			comboObjects[1].SetSelectCode("");
			comboObjects[2].SetSelectCode("");
			comboObjects[1].SetEnable(0);
			comboObjects[2].SetEnable(0);
			formObject.rdtype.disabled=true;
			formObject.rdtype.value="I";
			ComSetFocus(formObject.froms);
			break;
		case "btn_print":
			alert("btn_print");
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
	
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);

	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	resizeSheet();
	
	axon_event.addListenerForm('click', 'obj_tpsz_click', form);
//	//axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerFormat('focus', 'obj_activate', document.form); 
	axon_event.addListenerForm('blur', 'obj_deactivate', document.form); 
//	//axon_event.addListenerFormat('keyup', 'form_keyup', form);
//	//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	//axon_event.addListener('focus', 'polnextfocus', 'polnext');
	//axon_event.addListener('focus', 'lanenextfocus', 'lane');
	//axon_event.addListener('focus', 'prepolnextfocus', 'prepolnext');
	//initializing IBMultiCombo
	for ( var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
	for (k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		tabObjects[k].SetSelectedIndex(0);
	}
	t1sheet1_OnLoadFinish(sheetObjects[0]);
	isOpen=true;
}
 function t1sheet1_OnLoadFinish(sheetObj) {
	//	sheetObj.WaitImageVisible = false;
//	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	comboObjects[1].DisabledBackColor="#FFFFFF";
	comboObjects[1].SetEnable(0);
	comboObjects[2].DisabledBackColor="#FFFFFF";
	comboObjects[2].SetEnable(0);
	//	sheetObj.WaitImageVisible = true;
}
//function form_keyup() {
//	var obj=null;
//	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//	if (keyValue != 13) {
//		ComKeyEnter('lengthnextfocus');
//	} else {
//		obj_deactivate();
//	}
//}
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
			if (event.srcElement.name == "tos") {
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
// handling Axon event
function obj_deactivate() {
	var f=document.getElementById("froms");
	var t=document.getElementById("tos");
	sVal1=f.value.replace(/\/|\-|\./g, "");
	sVal2=t.value.replace(/\/|\-|\./g, "");
	switch (event.srcElement.name) {
	case "froms":
		if (ComChkObjValid(event.srcElement, false)) {
			if (f.getAttribute("dataformat") == "ym") {
				if (sVal1 != "" && sVal2 != "") {
					var day=lastDay(sVal2.substring(0, 4), sVal2.substring(4, 6));
					var flag=ComChkPeriod(sVal1 + "01", sVal2 + day);
					if (flag < 1) {
						//ComShowCodeMessage("CIM29004");
						enterSwitch=false;
						t.value="";
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							t.value="";
							t.focus();
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
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							t.value="";
							t.focus();
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
				if (sVal1.length > 0 && !ComIsMonth(sVal1.substring(4, 6)) && event.srcElement.name == 'froms') {
					event.srcElement.value="";
					ComShowCodeMessage("CIM21004", "YYYYMM");
					enterSwitch=false;
					event.srcElement.focus();
					event.srcElement.select();
					return false;
				}
			} else { // retrieving by week
				if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6)) && event.srcElement.name == 'froms') {
					event.srcElement.value="";
					ComShowCodeMessage("CIM21004", "YYYYWW");
					event.srcElement.focus();
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
						if (event.srcElement.name == "tos") {
							ComShowCodeMessage("CIM29004");
						}
						enterSwitch=false;
						event.srcElement.value="";
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							event.srcElement.value="";
							t.focus();
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
						if (event.srcElement.name == "tos") {
							ComShowCodeMessage("CIM29003");
						}
						enterSwitch=false;
						event.srcElement.value="";
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							event.srcElement.value="";
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
					event.srcElement.value="";
					ComShowCodeMessage("CIM21004", "YYYYMM");
					t.focus();
					t.select();
					return false;
				}
			} else { // retrieving by week
				if (sVal2.length > 0 && !ComIsWeek(sVal2.substring(4, 6))) {
					enterSwitch=false;
					event.srcElement.value="";
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
/**
 * getting last day of the month
 * @param y
 * @param m
 * @return
 */
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
var flag=false;
/**
 * 
 * @return
 */
function pol_OnFocus() {
	comboObjects[1].SetEnable(1);
	comboObjects[2].SetEnable(1);
}
function polnextfocus() {
//	comboObjects[1].focus();
}
function lanenextfocus() {
//	comboObjects[2].focus();
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
//no support[check again]CLT 		comboObjects[0].UseCode=false;
		comboObjects[0].SetSelectText(comboObjects[0].GetSelectText().toUpperCase());
		for ( var i=0; i < comboObjects[0].GetItemCount(); i++) {
			if (comboObjects[0].GetSelectText()== comboObjects[0].GetText(i, 0)) {
				flag=true;
//no support[check again]CLT 				comboObjects[0].UseCode=true;
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
//no support[check again]CLT 		comboObjects[1].UseCode=false;
		comboObjects[1].SetSelectText(comboObjects[1].GetSelectText().toUpperCase());
		for ( var i=0; i < comboObjects[1].GetItemCount(); i++) {
			if (comboObjects[1].GetSelectText()== comboObjects[1].GetText(i, 0)) {
				flag=true;
//no support[check again]CLT 				comboObjects[1].UseCode=true;
				break;
			}
		}
		if (flag == false) {
			ComShowCodeMessage("CIM29012");
			comboObjects[1].SetSelectText("");
			comboObjects[2].RemoveAll();
			comboObjects[1].focus();
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
	if (f.froms.value == "") {
		if (f.period.value == "M") {
			ComShowCodeMessage("CIM21001", "Period");
		} else {
			ComShowCodeMessage("CIM21001", "Period");
		}
		ComSetFocus(f.froms);
		return false;
	} else if (f.tos.value == "") {
		if (f.period.value == "M") {
			ComShowCodeMessage("CIM21001", "Period");
		} else {
			ComShowCodeMessage("CIM21001", "Period");
		}
		ComSetFocus(f.tos);
		return false;
	} else if (comboObjects[0].GetSelectText()== "") {
		ComShowCodeMessage("CIM29027");
		document.form.prepolnext.focus();
		return false;
	}
	/*
	else if (comboObjects[1].GetSelectText()== "") {
		ComShowCodeMessage("CIM21001", "LANE CODE는");
		return false;
	}
	 */
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
//no support[check again]CLT 		comboObjects[2].UseCode=false;
		comboObjects[2].SetSelectText(comboObjects[2].GetSelectText().toUpperCase());
		for ( var i=0; i < comboObjects[2].GetItemCount(); i++) {
			if (comboObjects[2].GetSelectText()== comboObjects[2].GetText(i, 0)) {
				flag=true;
//no support[check again]CLT 				comboObjects[2].UseCode=true;
				break;
			}
		}
		if (flag == false) {
			ComShowCodeMessage("CIM29023");
			comboObjects[2].SetSelectText("");
			comboObjects[2].focus();
			return true;
		}
		//document.form.flowpattern.focus();
	}
}
function obj_change() {
	var obj=ComGetEvent("name");
	if (obj == "period") {
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
		document.form.froms.focus();
		comboObjects[2].RemoveAll(); // deleting VVD
	}
}
function obj_keypress() {
	switch (ComGetEvent("name")) {
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
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "t1sheet1": //t1sheet1 init
	    with(sheetObj){
			var HeadTitle1="VVD|Total";
			oldCntrTypeSize=sCntrTypeSize;
			var arrCntrTypeSize=oldCntrTypeSize.split(",");
			var arrHead=new Array();
			for ( var i=0; i < arrCntrTypeSize.length; i++)
				{
					if (sCntrTypeSize != "") {
						HeadTitle1 += "|" + arrCntrTypeSize[i];
						}
				}
			sheetObj.FrozenCols=2;
			sheetObj.RenderSheet(0);
			for ( var i=arrCntrTypeSize.length + 2; i < 42; i++) {
				sheetObj.SetColHidden(i,1);
			}
			sheetObj.RenderSheet(1);
			SetConfig( { SearchMode:2, FrozenCol:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",     KeyField:0,   CalcLogic:"",   Format:"" },
			             {Type:"Text",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"total",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 } ];
			var sCount="";
		    var x=1;
			for ( var i=0; i < arrCntrTypeSize.length; i++) {
            	if (arrCntrTypeSize.length > 1) {
            		if (x < 10) {
            			sCount="count0" + x;
            		} else {
            			sCount="count" + x;
            		}
            		cols.push({Type:"Text",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:sCount,    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 });
            		 x++;
            	}
            }
			cols.push({Type:"AutoSum",   Hidden:1, Width:100,  Align:"Left",    ColMerge:1});
      InitColumns(cols);
      SetEditable(0);
      SetSheetHeight(425);
      ComResizeSheet(sheetObj);
      }


		break;
	case "t2sheet1": //t1sheet1 init
	    with(sheetObj){
		      var colCount=43;
		      var HeadTitle1="VVD|Division|Total";
		      oldCntrTypeSize2=sCntrTypeSize;
		      var arrCntrTypeSize=oldCntrTypeSize2.split(",");
		      var arrHead=new Array(5);
		      for ( var i=0; i < arrCntrTypeSize.length; i++) {
		    	  if (sCntrTypeSize != "") {
		    		  HeadTitle1 += "|" + arrCntrTypeSize[i];
		    	  }
		      }
//		      sheetObj.FrozenCols=3;
		      sheetObj.RenderSheet(0);
		      for ( var i=arrCntrTypeSize.length + 3; i < 43; i++) {
		    	  sheetObj.SetColHidden(i,1);
		      }
		      sheetObj.RenderSheet(1);
		      var rowCnt=0;
		      var POL=80;
		      var Division=60;
		      var Total=70;
		      cnt=0;
		      SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:7, Page:20, DataRowMerge:0 } );	
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);	
		      
		      var colsList = [];
		      var cols = [ {Type:"Text",      Hidden:0,  Width:POL,  Align:"Center",  ColMerge:1,   SaveName:"vvd",         KeyField:0,   CalcLogic:"",   Format:"" },
		                   {Type:"Text",      Hidden:0,  Width:Division,Align:"Center",  ColMerge:1,   SaveName:"etc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:false },
		                   {Type:"AutoSum",   Hidden:0, Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:1 } ];
		      CountPosition = 0;
		      var sCount="";
		      var sDays="";
		      var x=1;
		      for ( var i=0; i < arrCntrTypeSize.length; i++) {
			      if (arrCntrTypeSize.length > 1) {
			    	  if (x < 10) {
			    		  sCount="count0" + x;
			    	  } else {
			    		  sCount="count" + x;
			    	  }
			     	 cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:sCount,        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:1 });
			     	 x++;
			      }		      
		      }
		      
		      colsList.push(cols); 
		      cols=[];
		      
		      rowCnt++;
		      cnt=0;
		      cols.push({Type:"Text",      Hidden:0,  Width:POL,  Align:"Center",  ColMerge:1,   SaveName:"d2VVD",       KeyField:0,   CalcLogic:"",   Format:"" });
		      cols.push({Type:"Text",      Hidden:0,  Width:Division,Align:"Center",  ColMerge:1,   SaveName:"d2Division",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
		      cols.push({Type:"AutoSum",   Hidden:0, Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 });
		      
		      x = 1;
		      for ( var i=0; i < arrCntrTypeSize.length; i++) 
		      {
				      if (arrCntrTypeSize.length > 1) {
				    	  if (x < 10) {
				    		  sCount="count0" + x;
				    	  } else {
				    		  sCount="count" + x;
				    	  }
				      cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:sCount,        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 });
				      x++;
				      }
			  }
		      
		      colsList.push(cols); 
		      cols=[];
		      
		      rowCnt++;
		      cnt=0;
		      
		      cols.push({Type:"Text",      Hidden:0,  Width:POL,  Align:"Center",  ColMerge:1,   SaveName:"d3VVD",       KeyField:0,   CalcLogic:"",   Format:"" });
		      cols.push({Type:"Text",      Hidden:0,  Width:Division,Align:"Center",  ColMerge:1,   SaveName:"d3Division",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
		      cols.push({Type:"Text",   Hidden:0, Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 });
		      
		      x=1;
//		      rowCnt++;
//		      cnt=0;
		      for ( var i=0; i < arrCntrTypeSize.length; i++)
		      {
			      if (arrCntrTypeSize.length > 1)
			      {
				      if (x < 10) {
				    	  sCount="count0" + x;
				      } else {
				    	  sCount="count" + x;
				      }
				      cols.push({Type:"Text",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:sCount,        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 });
				      x++;
			      }
			    }
//		      cols.push({Type:"AutoSum",   Hidden:1, Width:100,  Align:"Left",    ColMerge:1});

//		      InitColumns(cols);
		      
		      colsList.push(cols); 
		      InitColumns(colsList , 3);
//		      InitColumns(3);
		      
		      SetEditable(0);
		      SetSheetHeight(425);
		      //resizeSheet();
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
//handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH:
		isOpen=true;
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH01;
//			sheetObj.RenderSheet(0);
 			sheetObj.DoSearch("EES_CIM_1007GS.do", FormQueryString(formObj) );
			sheetObj.SetWaitImageVisible(1);
			ComOpenWait(false);
		} else {
			return;
		}
		break;
	case IBSEARCH_ASYNC01:
		if (validateForm(sheetObj, formObj, sAction)) {
			if (sheetObj.id == "t1sheet1") {
				formObj.f_cmd.value=SEARCH03;
				//	var sXml = sheetObj.GetSearchXml("EES_CIM_1007GS.do",FormQueryString(formObj));
				//			sheetObj.LoadSearchXml(sXml);
				var sXml=formObj.sXml.value;
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
				sCntrTypeSize=ComGetEtcData(sXml, "cntrTypeSize");
			}
			//getting changing column information from server
//			oldCntrTypeSize=sCntrTypeSize;
//			t1sheet1.Reset();
//			initSheet(t1sheet1);
//			oldCntrTypeSize2=sCntrTypeSize;
//			t2sheet1.Reset();
//			initSheet(t2sheet1);
			
			oldCntrTypeSize=sCntrTypeSize;
			sheetObjects[0] = sheetObjects[0].Reset();
			initSheet(sheetObjects[0], 0, "");
			oldCntrTypeSize2=sCntrTypeSize;
			sheetObjects[1] = sheetObjects[1].Reset();
			initSheet(sheetObjects[1], 1, "");
			
			ComSetFocus(formObj.froms);
		}
		break;
	case IBSEARCH_ASYNC02: //retrieving VVD COMBO 
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH04;
			sheetObj.SetWaitImageVisible(0);
 			var sXml=sheetObj.GetSearchData("EES_CIM_1007GS.do", FormQueryString(formObj));
			//sheetObj.LoadSearchXml(sXml);
			var sVvd=ComGetEtcData(sXml, "sVvd");
			if (sVvd != undefined) {
				var arrVvd=sVvd.split("|");
				//MakeComboObject(formObj.vvd, arrVvd);
				MakeComboObject(vvd, arrVvd);
				comboObjects[2].SetEnable(1);
				var tid=setTimeout('lanenextfocus()', 500);
				document.form.lanenext.focus();
			}
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
//				MakeComboObject2(formObj.lane, arrVvd);
				MakeComboObject2(lane, arrVvd);
				comboObjects[1].SetEnable(1);
				var tid=setTimeout('polnextfocus()', 500);
				document.form.polnext.focus();
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
function doActionIBSheet2(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	isOpen=true;
	switch (sAction) {
	case IBSEARCH:
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH02;
 			sheetObj.DoSearch("EES_CIM_10072GS.do", FormQueryString(formObj) );
			sheetObj.SetWaitImageVisible(1);
			ComOpenWait(false);
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
			SetBackColor("#CCFFFF");
			SetDropHeight(200);
			SetMultiSelect(0);
			SetUseAutoComplete(1);
			SetMaxLength(5);
			ValidChar(2, 1);
		}
		break;
	case "lane":
		with (comboObj) {
			SetColAlign(0, "center");
			SetColAlign(1, "left");
			SetColWidth(0, "50");
			SetColWidth(1, "200");
			SetTitle("lane|Description");
			SetMultiSelect(0);
			//UseCode=false;
			SetUseAutoComplete(1);
			SetDropHeight(200);
			SetMaxLength(3);
			ValidChar(2, 0);
		}
		break;
	case "vvd":
		var i=0;
		with (comboObj) {
			//BackColor = "#CCFFFF";
			SetDropHeight(200);
			SetMultiSelect(0);
			SetUseAutoComplete(1);
			SetMaxLength(9);
			ValidChar(2, 1);
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
 * initializing Tab
 * setting Tab items
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt=0;
			InsertItem( "Summary", "");
			InsertItem( "  Detail  ", "");
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
	for(var i = 0; i<objs.length; i++){
	       if(i != nItem){
	        objs[i].style.display="none";
	        objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
	       }
	      }
	resizeSheet();
	beforetab=nItem;
	tabIndex=nItem;
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
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			sheetObjects[0].SetSelectRow(0);
		} else if (nItem == 1) {
			doActionIBSheet2(sheetObjects[1], document.form, IBSEARCH);
			sheetObjects[1].SetSelectRow(0);
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
//			if (!enterSwitch) {
//				return false;
//			}
			if (comboObjects[0].GetSelectText()== "") {
				ComShowCodeMessage("CIM29027");
				return false;
			}
		}
	}
	return true;
}
function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		SetSumText(0, 0,"Average");
		var arrTime=sCntrTypeSize.split(",");
		for ( var i=1; i < arrTime.length + 2; i++) {
			if (ComIsNull(GetCellValue(RowCount(), i))) {
 				SetSumText(0, i,"");
			} else {
 				SetSumText(0, i,GetCellText(RowCount(), i));
			}
		}
		if (RowCount()> 0) {
			SetRowHidden(RowCount(),1);
		}
	}
}
function t2sheet1_OnChangeSum(sheetObj, Row) {
	with (sheetObj) {
 		SetSumText(0, 0,"Total");
 		SetSumText(1, 0,"Total");
 		SetSumText(2, 0,"Total");
 		SetSumText(0, "etc","CNTR");
 		SetSumText(1, "etc","Days");
 		SetSumText(2, "etc","T/Time");
		SetCellAlign(LastRow()- 2, "vvd","CenterTop");
		SetCellAlign(LastRow()- 1, "vvd","CenterTop");
		SetCellAlign(LastRow(), "vvd","CenterTop");
		SetCellAlign(LastRow()- 2, "etc","Center");
		SetCellAlign(LastRow()- 1, "etc","Center");
		SetCellAlign(LastRow(), "etc","Center");
		SetMergeCell((LastRow()- 2), 0, 3, 1);
	}
}
function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
 		SetSumText(0, 0,"Total");
 		SetSumText(1, 0,"Total");
 		SetSumText(2, 0,"Total");
 		SetSumText(0, "etc","CNTR");
 		SetSumText(1, "etc","Days");
 		SetSumText(2, "etc","T/Time");
		SetCellAlign(LastRow()- 2, "vvd","CenterTop");
		SetCellAlign(LastRow()- 1, "vvd","CenterTop");
		SetCellAlign(LastRow(), "vvd","CenterTop");
		SetCellAlign(LastRow()- 2, "etc","Center");
		SetCellAlign(LastRow()- 1, "etc","Center");
		SetCellAlign(LastRow(), "etc","Center");
		SetMergeCell((LastRow()- 2), 0, 3, 1);

		SetSumText(2, 2,Math.round(GetSumValue(1, 2) / GetSumValue(0, 2) * 10) / 10);
		var arrTime=sCntrTypeSize.split(",");
		for ( var i=3; i < arrTime.length + 3; i++) {
			if (GetSumValue(0, i) > 0) {
   				SetSumValue(2, i,Math.round(GetSumValue(1, i) / GetSumValue(0, i) * 10) / 10);
			}
			if (GetSumValue(0, i) == 0) {
   				SetSumValue(2, i,"0.0");
			}
		}
		var arrTime=sCntrTypeSize.split(",");
		for ( var i=2; i < arrTime.length + 3; i++) {
//			if (ComIsNull(GetCellValue(RowCount(), i))) {
// 				SetSumText(0, i,"");
// 				SetSumText(1, i,"");
// 				SetSumText(2, i,"");
//			}
		}
	}
}
/* end of developer job */
