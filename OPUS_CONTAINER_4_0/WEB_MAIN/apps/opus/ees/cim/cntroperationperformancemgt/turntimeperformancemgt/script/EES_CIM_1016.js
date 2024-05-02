/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1016.js
*@FileTitle  : Turn Time by Location
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11 
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* developer job	*/
// common global variables
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var tot_cntr_tpsz_cd="";
var sPeriod=""
var tabIndex=0;
var isOpen=true;
var sSaveName="";
var enterSwitch=false;
var crntTab = -1;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var shtCnt=0;
//	var t1sheet1=sheetObjects[shtCnt++];
//	var t2sheet1=sheetObjects[shtCnt++];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Retrieve":
			if (tabIndex == 0) {
				t2sheet1.RemoveAll();
				doActionIBSheet(t1sheet1, formObject, IBSEARCH);
			} else {
				t1sheet1.RemoveAll();
				doActionIBSheet2(t2sheet1, formObject, IBSEARCH);
			}
			break;
		case "btn_downExcel":
			if (crntTab == 0)
				{
					if(t1sheet1.RowCount() < 1){
		                ComShowCodeMessage("COM132501");
		            } else{
//		        	   t1sheet1.Down2Excel({ HiddenColumn:true});
		               t1sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(t1sheet1), DownRows:"Visible", SheetDesign:1,Merge:1 });
		            }
				}
			else
				{
					if(t2sheet1.RowCount() < 1){
		                ComShowCodeMessage("COM132501");
					}else{
//		        	   t2sheet1.Down2Excel({ HiddenColumn:true});
					   t2sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(t2sheet1), SheetDesign:1,Merge:1 });
					}
				}
			break;
		case "btn_new":
			t1sheet1.RemoveAll();
			t2sheet1.RemoveAll();
			formObject.reset();
			document.getElementById("location").disabled=true;
			document.getElementById("location").className="input2";
			document.getElementById("enRoute").disabled=true;
			document.getElementById("enRoute").value="";
			document.getElementById("tscntr").disabled=false;
			document.getElementById("tscntr").value="E";
			ComSetFocus(formObject.froms);
			
			tabObjects[0].SetSelectedIndex(0);
			
			t1sheet1.RenderSheet(0);
			sheetObjects[0] = t1sheet1.Reset();
			initSheet(sheetObjects[0], 1, "");
			sheetObjects[0].RenderSheet(1);
			
			t1sheet1.RenderSheet(0);
			sheetObjects[1] = t2sheet1.Reset();
			initSheet(sheetObjects[1], 1, "");
			sheetObjects[1].RenderSheet(1);
			
			comboObjects[0].SetSelectCode("");
				
			break;
		case "btn_loc_cd":
			var cnt_cd="";
			var loc_cd="";
			cnt_cd=formObject.inquiryLevel.value;
			loc_cd=formObject.location.value;
			if (formObject.inquiryLevel.value != 'AR' && formObject.inquiryLevel.value != 'AC') {
				if (formObject.inquiryLevel.value == 'CC') { //Country
					var param="?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
					ComOpenPopup("/opuscntr/COM_ENS_0M1.do", 565, 650, "popupFinish", "1,0,1,1,1,1,1,1", true);
				} else {
					var loc_code="";
					if (formObject.inquiryLevel.value == "RC") {
						loc_code="rcc_cd";
					} else if (formObject.inquiryLevel.value == "RL" || formObject.inquiryLevel.value == "RE") {
						loc_code="rcc_cd";
					} else if (formObject.inquiryLevel.value == "LE") {
						loc_code="lcc_cd";
					} else if (formObject.inquiryLevel.value == "LS") {
						loc_code="lcc_cd";
					} else if (formObject.inquiryLevel.value == "ES") {
						loc_code="ecc_cd";
					} else if (formObject.inquiryLevel.value == "SS") {
						loc_code="scc_cd";
					}
					var param="?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
					ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 460, loc_code + ":location", "1,0,1,1,1,1,1,1", true);
				}
			}
			break;
		case "btn_Close":
			ComClosePopup(); 
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
function loadPage(gubun) {
	var formObject=document.form;
	if("Y"==formObject.pop_yn.value){
		//showing popup button part
		//document.all.popLayer.style.display="";
	}
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	resizeSheet();
	initControl();
	for ( var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
	for (k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		 tabObjects[k].SetSelectedIndex(0);
	}
	if (gubun != "") {
		tabObjects[0].SetSelectedIndex(1);
		enterSwitch=true;
	} else {
		isOpen=true;
	}
	
	t1sheet1_OnLoadFinish();
}
	 function t1sheet1_OnLoadFinish(sheetObj) {
	//	sheetObj.WaitImageVisible = false;
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	//	sheetObj.WaitImageVisible = true;
	if (document.form.tpszs.value != "") {
		comboObjects[0].SetSelectCode(document.form.tpszs.value);
	}
}
/**
 * 
 * @return
 */
function initControl() {
	document.getElementById("location").className="input2";
	// axon_event.addListener('click', 'reverse_cntr_tpsz_cd_check', 'chk_cntr_tpsz_cd', ''); 
	//axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 
//	axon_event.addListenerFormat('keyup', 'form_keyup', form);
	//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
	axon_event.addListenerForm('blur', 'obj_deactivate', form);
	axon_event.addListener('blur', 'obj_blur', 'location');
}
function tpsz_OnCheckClick(comboObj, index, code) {
	if (index == 0) {
		var bChk=comboObj.GetItemCheck(index);
		if (bChk) {
			for ( var i=1; i < comboObj.GetItemCount(); i++) {
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
//function form_keyup() {
//	var obj=null;
//	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//	if (keyValue != 13) {
//		ComKeyEnter('lengthnextfocus');
//	} else {
//		obj_deactivate();
//	}
//}
/**
 * settiong selected value from Location by loc_cd popup
 */
function popupFinish(aryPopupData, row, col, sheetIdx) {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	formObject.location.value=aryPopupData[0][3]
}
function obj_blur() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
}
/**
 * controlling tpsz_cd check box
 * @return
 */
function reverse_cntr_tpsz_cd_check() {
	var formObject=document.form;
	if (formObject.chk_cntr_tpsz_cd.checked) {
		comboObjects[0].SetSelectCode(tot_cntr_tpsz_cd.replaceStr("|", ","));
	} else {
		comboObjects[0].SetSelectCode("");
	}
}
/**
 * validating period
 * @return
 */
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
//handling Axon event
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
		if (ComChkObjValid(event.srcElement, false)) {
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
 * getting last date
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
/**
 * FOCUS IN
 */
function obj_activate() {
	ComClearSeparator(event.srcElement);
	ComSetFocus(event.srcElement);
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
/**
 * handling key input event
 * @return
 */
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
/**
 * handling CHANGE event
 * @return
 */
function obj_change() {
	obj=event.srcElement;
	if (obj.name == "inquiryLevel") {
		if (obj.value == "AR" || obj.value == "AC") {
			document.getElementById("location").disabled=true;
			document.getElementById("location").className="input2";
			document.getElementById("location").value="";
		} else {
		//	document.getElementById("location").value = "";
			document.getElementById("location").disabled=false;
			document.getElementById("location").className="input1";
			document.form.location.focus();
		}
		if (obj.value == "CC") {
			document.getElementById("location").setAttribute("maxLength", 2);
		} else {
			document.getElementById("location").setAttribute("maxLength", 5);
		}
		if (obj.value == "RL") {
			document.getElementById("enRoute").disabled=false;
			document.getElementById("enRoute").value="E";
		} else {
			document.getElementById("enRoute").value="";
			document.getElementById("enRoute").disabled=true;
		}
		if (obj.value == "AR") {
			document.getElementById("tscntr").disabled=false;
			document.getElementById("tscntr").value="E";
		} else {
			document.getElementById("tscntr").value="";
			document.getElementById("tscntr").disabled=true;
		}
	} else if (obj.name == "period") {
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
	//sSaveName = "";
	switch (sheetID) {
	case "t1sheet1": //t1sheet1 init
		with(sheetObj){
			if (HeadTitle == null || HeadTitle == "") {
				HeadTitle="RCC|TP/SZ|Total";
			}
			var headCnt=HeadTitle.split("|").length;
			if (SheetWidth > 975) {
			}
			SetConfig( { SearchMode:2, FrozenCol:1, MergeSheet:2, Page:20, DataRowMerge:0 ,PrevColumnMergeMode:0 } );
			var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers=[ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols=[ {Type:"Text",    Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"loccode",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			           {Type:"Text",    Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"tpsz",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			           {Type:"Float",   Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"total",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 } ];
			for ( var i=1; i <= headCnt - 3; i++) {
				if (i < 10) {
					cols.push({Type:"Float",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"count0"+(i), KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,     UpdateEdit:0,   InsertEdit:0 });
				} else {
					cols.push({Type:"Float",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"count"+(i),  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,      UpdateEdit:0,   InsertEdit:0 });
				}
			}
			cols.push({Type:"AutoSum",   Hidden:1, Width:100,  Align:"Left",    ColMerge:1});
			InitColumns(cols);
			//SetSheetHeight(425);
			ComResizeSheet(sheetObj);
			SetExtendLastCol(0);
		}
		break;
	case "t2sheet1": //t2sheet1 init
		with(sheetObj){
		if (HeadTitle == null || HeadTitle == "") {
			HeadTitle="RCC|TP/SZ|Division|Total";
		}
		var headCnt=HeadTitle.split("|").length;
		if (SheetWidth > 975) {
		}
		var rowCnt=0;
		var RCC=70;
		var TPSZ=80;
		var Division=70;
		var Total=80;
		SetConfig( { SearchMode:2, FrozenCol:1, MergeSheet:2, Page:20, DataRowMerge:0 ,PrevColumnMergeMode:0 } );
		var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		var headers=[ { Text:HeadTitle, Align:"Center"} ];
		InitHeaders(headers, info);
		var cols=[ {Type:"Text",      Hidden:0,  Width:RCC,  Align:"Center",  ColMerge:1,   SaveName:"loccode",    KeyField:0,   CalcLogic:"",   Format:"",   UpdateEdit:0,   InsertEdit:0 },
		           {Type:"Text",      Hidden:0,  Width:TPSZ, Align:"Center",  ColMerge:1,   SaveName:"tpsz",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 ,   UpdateEdit:0,   InsertEdit:0},
		           {Type:"Text",      Hidden:0,  Width:Division,Align:"Center",  ColMerge:1,   SaveName:"division",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 ,   UpdateEdit:0,   InsertEdit:0},
		           {Type:"Float",   Hidden:0, Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:1,   UpdateEdit:0,   InsertEdit:0 } ];
		for ( var i=1; i <= headCnt - 4; i++) {
			if (i < 10) {
				cols.push({Type:"Float",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"count0"+(i), KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:1,     UpdateEdit:0,   InsertEdit:0 });
			} else {
				cols.push({Type:"Float",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"count"+(i),  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:1,     UpdateEdit:0,   InsertEdit:0});
			}
			
			
//			cols.push({Type:"Text",      Hidden:0,  Width:RCC,  Align:"Center",  ColMerge:1,   SaveName:"d2RCC",      KeyField:0,   CalcLogic:"",   Format:"" });
//			cols.push({Type:"Text",      Hidden:0,  Width:TPSZ, Align:"Center",  ColMerge:1,   SaveName:"tpsz2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
//			cols.push({Type:"Text",      Hidden:0,  Width:Division,Align:"Center",  ColMerge:0,   SaveName:"division2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
//			cols.push({Type:"AutoSum",   Hidden:0, Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 });
//			for ( var i=1; i <= headCnt - 4; i++) {
//				if (i < 10) {
//					cols.push({Type:"Text",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"count0"+(i), KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
//				} else {
//					cols.push({Type:"Text",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"count"+(i),  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
//				}cols.push({Type:"AutoSum",   Hidden:1, Width:100,  Align:"Left",    ColMerge:1});
//				
////				cols.push({Type:"Text",      Hidden:0,  Width:RCC,  Align:"Center",  ColMerge:1,   SaveName:"d3RCC",      KeyField:0,   CalcLogic:"",   Format:"" });
////				cols.push({Type:"Text",      Hidden:0,  Width:TPSZ, Align:"Center",  ColMerge:1,   SaveName:"tpsz3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
////				cols.push({Type:"Text",      Hidden:0,  Width:Division,Align:"Center",  ColMerge:0,   SaveName:"division3",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
////				cols.push({Type:"AutoSum",   Hidden:0, Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 });
//				for ( var i=1; i <= headCnt - 4; i++) {
//					if (i < 10) {
//						cols.push({Type:"Text",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"count0"+(i), KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
//					} else {
//						cols.push({Type:"Text",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"count"+(i),  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
//					}
//				}
//				cols.push({Type:"AutoSum",   Hidden:1, Width:100,  Align:"Left",    ColMerge:1});
////				rowCnt++;
////				cnt=0;
//			}
//			rowCnt++;
//			cnt=0;
			}
		cols.push({Type:"AutoSum",   Hidden:1, Width:100,  Align:"Left",    ColMerge:1});
			InitColumns(cols);
			//SetSheetHeight(425);
			SetExtendLastCol(0);
		}
		break;
	}
}

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
			var sXml=sheetObj.GetSearchData("EES_CIM_1016GS.do", FormQueryString(formObj));
			sPeriod=ComGetEtcData(sXml, "head");
			//getting changing column information from server
			var str_loc_nm="";
			var f=document.form.inquiryLevel;
			if (f.value == "AR") {
				str_loc_nm="RCC";
			} else if (f.value == "RL") {
				str_loc_nm="LCC";
			} else if (f.value == "LE" || f.value == "RE") {
				str_loc_nm="ECC";
			} else if (f.value == "LS" || f.value == "ES" || f.value == "SS") {
				str_loc_nm="SCC";
			} else if (f.value == "RC" || f.value == "AC" || f.value == "CC") {
				str_loc_nm="Country";
			}
			var HeadTitle=str_loc_nm + "|TP/SZ|Total|" + sPeriod;
			t1sheet1.RenderSheet(0);
//			t1sheet1.RemoveAll();
			sheetObjects[0] = t1sheet1.Reset();
			initSheet(sheetObjects[0], 1, HeadTitle);
			sheetObjects[0].RenderSheet(1);
			sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
			sheetObjects[0].SetWaitImageVisible(1);
			ComOpenWait(false);
		} else {
			return;
		}
		break;
	case IBSEARCH_ASYNC01:
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH03;
			//	var sXml = sheetObj.GetSearchXml("EES_CIM_1016GS.do",FormQueryString(formObj));
			//	sheetObj.LoadSearchXml(sXml);
			var sXml=formObj.sXml.value;
			var sTpsz=ComGetEtcData(sXml, "cntr_tpsz_cd");
			tot_cntr_tpsz_cd=sTpsz;
			if (sTpsz != undefined) {
				var arrTpsz=sTpsz.split("|");
				MakeComboObject(tpsz, arrTpsz);
			}
			ComSetFocus(formObj.froms);
		}
		break;
	case IBSEARCH_ASYNC02: //location focusOut
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH04;
			if (formObj.location.value == "") {
				return false;
			}
			sheetObj.SetWaitImageVisible(0);
			var sXml=sheetObj.GetSearchData("EES_CIM_1016GS.do", FormQueryString(formObj));
			var sCheck=ComGetEtcData(sXml, "check");
			if (sCheck != "OK") {
				if (document.form.location.value != "") {
					ComShowCodeMessage("CIM29013");
					document.form.location.value="";
					ComSetFocus(document.form.location);
					return false;
				} else {
					return true;
				}
			}
			sheetObj.SetWaitImageVisible(1);
			ComSetFocus(document.form.flowpattern);
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
			var sXml=sheetObj.GetSearchData("EES_CIM_10162GS.do", FormQueryString(formObj));
			sPeriod=ComGetEtcData(sXml, "head");
			//getting changing column information from server
			var str_loc_nm="";
			var f=document.form.inquiryLevel;
			if (f.value == "AR") {
				str_loc_nm="RCC";
			} else if (f.value == "RL") {
				str_loc_nm="LCC";
			} else if (f.value == "LE" || f.value == "RE") {
				str_loc_nm="ECC";
			} else if (f.value == "LS" || f.value == "ES" || f.value == "SS") {
				str_loc_nm="SCC";
			} else if (f.value == "RC" || f.value == "AC" || f.value == "CC") {
				str_loc_nm="Country";
			}
			var HeadTitle=str_loc_nm + "|TP/SZ|Division|Total|" + sPeriod;
			//		t2sheet1.Redraw = false;
			//		t2sheet1.RemoveAll();
			sheetObjects[1] = t2sheet1.Reset();
			initSheet(sheetObjects[1], 1, HeadTitle);
			//		t2sheet1.Redraw = true;
//			t2sheet1.LoadSearchData(sXml,{Sync:1} );
			sheetObjects[1].LoadSearchData(sXml,{Sync:0} );
			sheetObjects[1].SetWaitImageVisible(1);
			ComOpenWait(false);
		} else {
			return;
		}
		break;
	}
}
/**
 * initializing Combo box 
 * @param comboObj
 * @param comboNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	switch (comboObj.options.id) {
		case "tpsz":
			var i=0;
			with (comboObj) {
				SetDropHeight(320);
				SetMultiSelect(1);
				SetMultiSeparator(",");
				Style=1;
			}
		break;
	}
}
/**
 * method for making Combo box
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
			InsertItem( "   Detail   ", "");
		}
		break;
	}
}
/**
 * event when clicking Tab
 * activating selected tab items
 */
function tab1_OnChange(tabObj, nItem) {
	crntTab = nItem;
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab].style.display="none";
	//--------------- important --------------------------//
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
	//------------------------------------------------------//
	beforetab=nItem;
	tabIndex=nItem;
	resizeSheet();
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
			doActionIBSheet(t1sheet1, document.form, IBSEARCH);
		} else if (nItem == 1) {
			doActionIBSheet2(t2sheet1, document.form, IBSEARCH);
		}
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (sAction != IBSEARCH_ASYNC01 && sAction != IBSEARCH_ASYNC02) {
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
			if (inquiryLevel.value != "AR" && inquiryLevel.value != "AC") {
				if (location.value == "") {
					ComShowCodeMessage("CIM21001", "Location By");
					ComSetFocus(location);
					return false;
				}
			}
		}
	}
	return true;
}
/**
 * event after retrieving Sheet1 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
	/*
		for ( var x=0; x < sheetObj.LastRow(); x++) {
if (GetCellValue(x, 1) == "Average") {
				SetRowBackColor(x,"#C9D5EB");
			}
		}
*/
		SetSumText(0, 0,"");
		SetSumText(0, 1,"TTL.Average");
		SetCellAlign(LastRow(), "tpsz","Center");
		var arrTime=sPeriod.split("|");
		for ( var i=2; i < arrTime.length + 3; i++) {
			if (GetCellValue(RowCount(), i) > 0.0) {
				SetSumText(0, i,(Math.round(GetCellValue(RowCount(), i)*100)) / 100);
				//SetSumText(0, i,GetCellValue(RowCount(), i));
			}else {
				SetSumText(0, i,"0.0");
			}
		}
		if (RowCount()> 0) {
			SetRowHidden(RowCount(),1);
		}
	}
}
/**
 * handling Sheet2 changeSum event
 * @param sheetObj
 * @param Row
 * @return
 */
function t2sheet1_OnChangeSum(sheetObj, Row) {
//	with (sheetObj) {
//	SetSumText(0, "loccode","TTL.Average");
//	SetSumText(1, "loccode","TTL.Average");
//	SetSumText(2, "loccode","TTL.Average");
//	SetSumText(0, "tpsz","TTL.Average");
//	SetSumText(1, "tpsz","TTL.Average");
//	SetSumText(2, "tpsz","TTL.Average");
//	SetSumText(0, "division","CNTR");
//	SetSumText(1, "division","Days");
//	SetSumText(2, "division","T/Time");
//	SetCellAlign(LastRow()- 2, "loccode","CenterTop");
//	SetCellAlign(LastRow()- 1, "loccode","CenterTop");
//	SetCellAlign(LastRow(), "loccode","CenterTop");
//	SetCellAlign(LastRow()- 2, "tpsz","CenterTop");
//	SetCellAlign(LastRow()- 1, "tpsz","CenterTop");
//	SetCellAlign(LastRow(), "tpsz","CenterTop");
//	SetCellAlign(LastRow()- 2, "division","Center");
//	SetCellAlign(LastRow()- 1, "division","Center");
//	SetCellAlign(LastRow(), "division","Center");
//	SetMergeCell((LastRow()- 2), 0, 3, 2);
//	}
}
/**
 * event after retrieving Sheet2 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
//	with (sheetObj) {
//		var arrTime=sPeriod.split("|");
//		for ( var i=3; i < arrTime.length + 4; i++) {
//	SetSumText(0, i,GetCellText(RowCount()- 2, i));
//	SetSumText(1, i,GetCellText(RowCount()- 1, i));
//		}
//		if (RowCount()> 0) {
//			SetRowHidden(RowCount()- 2,1);
//			SetRowHidden(RowCount()- 1,1);
//			SetRowHidden(RowCount(),1);
//		}
//		SetSumText(2, 3,Math.round(GetSumValue(1, 3) / GetSumValue(0, 3) * 10) / 10);
//		var arrTime=sPeriod.split("|");
//		for ( var i=4; i < arrTime.length + 4; i++) {
//			if (GetSumValue(0, i) > 0) {
//				SetSumText(2, i,Math.round(GetSumValue(1, i) / GetSumValue(0, i) * 10) / 10);
//			}
//		}
//		/*
//		for ( var x=0; x < sheetObj.LastRow(); x++) {
//			if (sheetObj.GetCellText(x, 1) == "Average") {
//				SetRowBackColor(x,"#C9D5EB");
//			}
//		}
//*/
//	}
	sheetObj.SetRowHidden(sheetObj.LastRow(),1);
}
/* end of developer job */
function tpsz_OnChange(comboObj, OldIndex,  OldText,  OldCode,  NewIndex,  NewText, NewCode) {
	var formObj=document.form;
	
	//form.tpsz_text.value = comboObj.GetText(parseInt(NewIndex), 0);
}
