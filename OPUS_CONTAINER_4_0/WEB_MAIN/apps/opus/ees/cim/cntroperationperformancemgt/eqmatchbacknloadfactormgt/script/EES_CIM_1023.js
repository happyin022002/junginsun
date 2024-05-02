/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1023.js
*@FileTitle  : Location M/B by Logistics-Wise
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
 * @class ees_cim_1023 : business script for ees_cim_1023 
 */

/* developer job */
// common global variables
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var oldCntrTypeSize="";
var sCntrTypeSize="";
var isOpen=true;
var tabIndex=0;
var str_loc_nm="";
var IBSEARCH02=30;
var head_cntr_tpsz_cd="";
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick() {
	var shtCnt=0;
	var t1sheet1=sheetObjects[shtCnt++];
	var t2sheet1=sheetObjects[shtCnt++];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Retrieve":
			if (tabIndex == 0) {
				t2sheet1.RemoveAll();
				doActionIBSheet(t1sheet1, formObject, IBSEARCH);
				sheetObjects[0].SetSelectRow(0);
			} else {
				t1sheet1.RemoveAll();
				doActionIBSheet2(t2sheet1, formObject, IBSEARCH);
				sheetObjects[1].SetSelectRow(0);
			}
			break;
		case "btn_New":
			t1sheet1.RemoveAll();
			t2sheet1.RemoveAll();
			formObject.rdtype.disabled=true;
			formObject.rdtype.value="I";
			document.getElementById("location").disabled=true;
			document.getElementById("location").value="";
			document.getElementById("inquiryLevel2").value="";
			document.getElementById("location").className="input2";
			formObject.reset();
			//document.form.froms.focus();
			tabObjects[0].SetSelectedIndex(0);
			break;
		case "btn_loc_cd": //retrieving Location popup
			var cnt_cd="";
			var loc_cd="";
			cnt_cd=formObject.inquiryLevel.value;
			loc_cd=formObject.location.value;
			if (formObject.inquiryLevel.value != 'A') {
				if (formObject.inquiryLevel.value == 'Y') { //Country
					var param="?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
					ComOpenPopup("/opuscntr/COM_ENS_061.do", 755, 630, "popupFinish", "1,0,1,1,1,1,1,1", true);
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
					} else if (formObject.inquiryLevel.value == "P") {
						loc_code="port_cd";
					}
					var param="?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
					ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 460, loc_code + ":location", "1,0,1,1,1,1,1,1", true);
				}
			}
			break;
		case "btn_DownExcel":
			if (tabIndex == 0) {
				if(t1sheet1.RowCount() < 1){//no data	
					ComShowCodeMessage("COM132501");
				}else{	
//					doActionIBSheet(t1sheet1, formObject, IBDOWNEXCEL);
					t1sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(t1sheet1), DownRows : "Visible", SheetDesign:1,Merge:0 });
				}	
			} else {
				if(t2sheet1.RowCount() < 1){//no data	
					ComShowCodeMessage("COM132501");
				}else{	
//					doActionIBSheet2(t2sheet1, formObject, IBDOWNEXCEL);
					t2sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(t2sheet1), DownRows : "Visible", SheetDesign:1,Merge:0 });
				}
				
			}
			break;
		case "btn_Print":
			if (sheetObjects[1].rowcount == 0) {
				errMsg='No data found.';
				ComShowMessage(msgs["CIM29030"]);
				return;
			}
			formObject.f_cmd.value=IBSEARCH02; 
			ComOpenPopupWithTarget('/opuscntr/EES_CIM_1923_POP.do', 950, 750, "", "0,1,1,1,1,1,1", true);
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
 * setting value from Location by loc_cd popup
 */
function popupFinish(aryPopupData, row, col, sheetIdx) {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	formObject.location.value=aryPopupData[0][3]
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
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	resizeSheet();
	axon_event.addListenerForm('click', 'obj_tpsz_click', document.form);
	//axon_event.addListenerFormat('keypress', 'obj_keypress', document.form); 
	axon_event.addListenerForm('change', 'obj_change', document.form);
	//axon_event.addListenerFormat('focus', 'obj_activate', document.form); 
	axon_event.addListenerForm('blur', 'obj_deactivate', document.form); 
	//axon_event.addListenerFormat('keyup', 'form_keyup', document.form);
	//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListener('blur', 'obj_blur', 'location');
	for (k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		tabObjects[k].SetSelectedIndex(0);
	}
	isOpen=true;
	ComBtnDisable("btn_Print");
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
function rdTypeSel(type) {
	if (type == "R") {
		document.form.rdtype.disabled=false;
		//ComEnableObject(document.form.rd_type, true)
	} else {
		//ComEnableObject(document.form.rdtype, false)
		document.form.rdtype.disabled=true;
		document.form.rdtype.value="I";
	}
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
//function obj_keypress() {
//	switch (ComGetEvent().name) {
//	case "location":
//		if (document.form.inquiryLevel.value == "Y") {
//			ComKeyOnlyAlphabet('uppernum');// upper case, numbers only
//		} else {
//			ComKeyOnlyAlphabet('uppernum');// upper case, numbers only
//		}
//		break;
//	case "froms":
//		// permitting to input "-" in case of numbers 
//		ComKeyOnlyNumber(ComGetEvent());
//		break;
//	case "tos":
//		// permitting to input "-" in case of numbers 
//		ComKeyOnlyNumber(ComGetEvent());
//		break;
//	}
//}
//function form_keyup() {
//	var obj=null;
//	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//	if (keyValue != 13) {
//		ComKeyEnter('lengthnextfocus');
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
			if ((eval(toYearDate) - eval(frYearDate)) == 1) { //in case or 1 year gap
				week=betwMonth;
			} else {
				week=(eval(toYearDate) - eval(frYearDate) - 1) * fromTo + betwMonth;
			}
		}
		if (week > 26) {
			if (ComGetEvent("name")== "tos") {
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
function obj_blur() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
}
//function for handling Axon event
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
				if (sVal1.length > 0 && !ComIsMonth(sVal1.substring(4, 6)) && ComGetEvent("name") == 'froms') {
					ComGetEvent().value="";
					ComShowCodeMessage("CIM21004", "YYYYMM");
					enterSwitch=false;
					ComGetEvent().focus();
					ComGetEvent().select();
					return false;
				}
			} else { // retrieving by week
				if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6)) && ComGetEvent("name")== 'froms') {
					ComGetEvent().value="";
					ComShowCodeMessage("CIM21004", "YYYYWW");
					ComGetEvent().focus();
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
						//t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							ComGetEvent().value="";
							//t.focus();
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
						//t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							ComGetEvent().value="";
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
					ComGetEvent().value="";
					ComShowCodeMessage("CIM21004", "YYYYMM");
					//t.focus();
					t.select();
					return false;
				}
			} else { // retrieving by week
				if (sVal2.length > 0 && !ComIsWeek(sVal2.substring(4, 6))) {
					enterSwitch=false;
					ComGetEvent().value="";
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
			//document.form.froms.focus();
		} else {
			document.getElementById("froms").setAttribute("dataformat", "yw");
			document.getElementById("tos").setAttribute("dataformat", "yw");
			document.form.froms.value="";
			document.form.tos.value="";
			document.form.from.value="";
			document.form.to.value="";
			//document.form.froms.focus();
		}
	} else if (obj.name == "inquiryLevel") {
		if (obj.value == "A") {
			document.getElementById("location").disabled=true;
			document.getElementById("location").value="";
			document.getElementById("inquiryLevel2").value="";
			document.getElementById("location").className="input2";
		} else {
			document.getElementById("location").disabled=false;
			document.getElementById("inquiryLevel2").value=obj.value;
			document.getElementById("location").className="input1";
			//document.getElementById("location").focus();
		}
		if (obj.value != "Y") {
			document.getElementById("location").setAttribute("maxLength", 5);
		//	document.getElementById("location").value = "";
		} else {
			document.getElementById("location").setAttribute("maxLength", 7);
		//	document.getElementById("location").value = "";
		}
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
			      oldCntrTypeSize=sCntrTypeSize;
			      head_cntr_tpsz_cd=sCntrTypeSize;
			      var arrTpSz=oldCntrTypeSize.split(",");
			      var HeadTitle1="Port|Yard|Total";
			      for ( var i=0; i < arrTpSz.length; i++) {
			    	  HeadTitle1 += "|" + arrTpSz[i];
			      }
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      sheetObj.FrozenCols=3;
			      SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:7, Page:20, DataRowMerge:0 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"yard_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
			             {Type:"Text",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",     KeyField:0,   CalcLogic:"",   Format:"", PointCount:1 } ];
			      for ( var i=0; i < arrTpSz.length; i++) {
				      arEtcData="_" + i;
				      cols.push({Type:"Text",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"qty"+arEtcData, KeyField:0,   CalcLogic:"",   Format:"", PointCount:1 });
			      }
			      cols.push({Type:"AutoSum",   Hidden:1, Width:100,  Align:"Left",    ColMerge:1});
			      InitColumns(cols);
			      SetSheetHeight(425);
			      ComResizeSheet(sheetObj);
			      SetEditable(0);
            }


		break;
	case "t2sheet1": //t2sheet1 init
	    with(sheetObj){
      
		      var cols =[];
		      var colsList = [];
		      oldCntrTypeSize2=sCntrTypeSize;
		      head_cntr_tpsz_cd=sCntrTypeSize;
		      var arrTpSz=oldCntrTypeSize2.split(",");
		      var HeadTitle1="Port|Yard|Division|Total";
		      for ( var i=0; i < arrTpSz.length; i++) {
		    	  HeadTitle1 += "|" + arrTpSz[i];
		      }
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      (headCount, 0, 0, true);
		      sheetObj.FrozenCols=4;
		      var RowCnt=0;
//		      SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:1, Page:20, DataRowMerge:1 } );
//		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:1, Page:20, DataRowMerge:0 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      
//              SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:2, Page:20, DataRowMerge:0 } );	
//              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		      
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      for ( var RowCnt=0; RowCnt < 4; RowCnt++) {
		    	  cnt=0;
		    	  cols = [];
			      if (RowCnt == 3) {
				      cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"yard_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"division",      KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 } ];
				            for ( var i=0; i < arrTpSz.length; i++) {
				            	arEtcData="_" + i;
				            	cols.push({Type:"Text",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"qty"+arEtcData, KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
				            }
//				            cols.push({Type:"AutoSum",   Hidden:1, Width:100,  Align:"Left",    ColMerge:1});
			      } else {
				      cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" });
				      cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"yard_cd",       KeyField:0,   CalcLogic:"",   Format:"" });
				      cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"division",      KeyField:0,   CalcLogic:"",   Format:"" });
				      cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
				      for ( var i=0; i < arrTpSz.length; i++) {
				    	  arEtcData="_" + i;
				    	  cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"qty"+arEtcData, KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
				      }
//				      cols.push({Type:"AutoSum",   Hidden:1, Width:100,  Align:"Left",    ColMerge:1});
		            }
			      colsList.push(cols);
	      }
//		      InitColumns(cols);
		      InitColumns(colsList,4);
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
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		formObj.f_cmd.value=SEARCH;
		var sXml=sheetObj.GetSearchData("EES_CIM_1023GS.do", FormQueryString(formObj));
		sheetObj.LoadSearchData(sXml,{Sync:0} );
		sheetObj.SetWaitImageVisible(1);
		ComOpenWait(false);
		break;
	case IBSEARCH_ASYNC01:
		//            if (validateForm(sheetObj, formObj, sAction)) {
		var sXml=formObj.sXml.value;
		sCntrTypeSize=ComGetEtcData(sXml, "cntrTypeSize");
		//getting changing column information from server
		oldCntrTypeSize=sCntrTypeSize;
//		sheetObj.Reset();
//		initSheet(sheetObj);
//		sheetObjects[1].Reset();
//		initSheet(sheetObjects[1]);
		break;
	case IBSEARCH_ASYNC02: //location focusOut
		formObj.f_cmd.value=SEARCH02;
		if (formObj.location.value == "") {
			return true;
		}
		sheetObj.SetWaitImageVisible(0);
		var sXml=sheetObj.GetSearchData("EES_CIM_1001GS.do", FormQueryString(formObj));
		var sCheck=ComGetEtcData(sXml, "check");
		if (sCheck != "OK") {
			var inquiryLevel=document.getElementById("inquiryLevel").value;
			if (document.form.location.value != "") {
				if (inquiryLevel == "R") {
					ComShowCodeMessage("CIM29031");
					document.form.location.value="";
					ComSetFocus(document.form.location);
					return false;
				} else if (inquiryLevel == "L") {
					ComShowCodeMessage("CIM29032");
					document.form.location.value="";
					ComSetFocus(document.form.location);
					return false;
				} else if (inquiryLevel == "E") {
					ComShowCodeMessage("CIM29033");
					document.form.location.value="";
					ComSetFocus(document.form.location);
					return false;
				} else if (inquiryLevel == "Y") {
					ComShowCodeMessage("CIM29036");
					document.form.location.value="";
					ComSetFocus(document.form.location);
					return false;
				} else if (inquiryLevel == "P") {
					ComShowCodeMessage("CIM29035");
					document.form.location.value="";
					ComSetFocus(document.form.location);
					return false;
				}
			} else {
				return true;
			}
		}
		ComSetFocus(document.form.cargotype);
		sheetObj.SetWaitImageVisible(1);
		break;
	case IBDOWNEXCEL: 
		sheetObj.SetWaitImageVisible(1);
		sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
		break;
	}
}
// handling process for Sheet
function doActionIBSheet2(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH:
		isOpen=true;
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		formObj.f_cmd.value=SEARCH01;
		var sXml=sheetObj.GetSearchData("EES_CIM_10232GS.do", FormQueryString(formObj));
		sXml = sXml.replace(/%/gi,"");
		sheetObj.LoadSearchData(sXml,{Sync:0} );
		sheetObj.SetWaitImageVisible(1);
		ComOpenWait(false);
		break;
	case IBDOWNEXCEL:
		sheetObj.SetWaitImageVisible(1);
		sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
		break;
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
			InsertItem( "M/Back (%)", "");
			InsertItem( "M/B Detail", "");
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
			if (inquiryLevel.value != "A") {
				if (location.value == "") {
					ComShowCodeMessage("CIM21001", "Inquiry Level");
					ComSetFocus(location);
					return false;
				}
			}
		}
	}
	return true;
}
function t1sheet1_OnChangeSum(sheetObj) {
	sheetObj.SetColHidden("division",1);
}
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		var arrTime=sCntrTypeSize.split(",");
		for ( var i=2; i < arrTime.length + 3; i++) {
	SetCellFontColor(LastRow(), i,"#000000");
	if (ComIsNull(GetCellValue(RowCount(), i))) {
		SetSumText(0, i,"");
	} else if (GetCellValue(RowCount(), i) == 0.0) {
		SetSumText(0, i,0 + '%');
			} else {
				if ((GetCellValue(RowCount(), i)).indexOf("-") != -1) {
			SetCellFontColor(LastRow(), i,"#DC0000");
				}
	SetSumText(0, i,GetCellValue(RowCount(), i));
			}
		}
		if (RowCount()> 0) {
			SetRowHidden(RowCount(),1);
		}
		SetSumText(0, 0,"G.Total");
		if (RowCount()> 0) {
			SetMergeCell(LastRow(), 0, 1, 2);
		}
		SetCellAlign(0, 1,"Center");
		SetSelectRow(0);
	}
	ComBtnDisable("btn_Print");
	}
	function t1sheet1_OnLoadFinish(sheetObj) {
		//sheetObj.WaitImageVisible = false;
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
		//document.form.froms.focus();
		//sheetObj.WaitImageVisible = true;
	}
function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
//		sheetObj.SetRowHidden(sheetObj.LastRow(),1);
		var row=LastRow();
		SetSumText(0, "loc_cd","G.Total");
		SetSumText(1, "loc_cd","G.Total");
		SetSumText(2, "loc_cd","G.Total");
		SetSumText(3, "loc_cd","G.Total");
		SetSumText(0, "yard_cd","G.Total");
		SetSumText(1, "yard_cd","G.Total");
		SetSumText(2, "yard_cd","G.Total");
		SetSumText(3, "yard_cd","G.Total");
		SetSumText(0, "division","I/B");
		SetSumText(1, "division","O/B");
		SetSumText(2, "division","Balance");
		SetSumText(3, "division","M/B(%)");
		var arrTime=sCntrTypeSize.split(",");
		for ( var i=3; i < arrTime.length + 4; i++) {
//			if (ComIsNull(GetCellValue(RowCount(), i))) {
//				SetSumText(0, i,"");
//				SetSumText(1, i,"");
//				SetSumText(2, i,"");
//				SetSumText(3, i,"");
//			} else {
				SetCellFontColor(LastRow()- 1, i,"#000000");
				SetCellFontColor(LastRow(), i,"#000000");
				if (GetSumValue(0, i) >= GetSumValue(1, i)) {
					if (GetSumValue(0, i) > 0) {
						var tVal01=Math.round(GetSumValue(1, i) / GetSumValue(0, i) * 100);
						SetSumText(3, i,tVal01 + "%");
						if (tVal01 < 0) {
							SetCellFontColor(LastRow()- 1, i,"#DC0000");
							SetCellFontColor(LastRow(), i,"#DC0000");
						}
					} else {
						if (GetSumValue(2, i) < 0) {
							SetCellFontColor(LastRow()- 1, i,"#DC0000");
						}
						SetSumText(3, i,'0%');
					}
				} else if (GetSumValue(1, i) > 0) {
					var tVal02=Math.round((GetSumValue(0, i) / GetSumValue(1, i) * (-1)) * 100);
					if (GetSumValue(2, i) < 0) {
						SetCellFontColor(LastRow()- 1, i,"#DC0000");
					}
					SetSumText(3, i,tVal02 + "%");
					if (tVal02 < 0) {
						SetCellFontColor(LastRow()- 1, i,"#DC0000");
						SetCellFontColor(LastRow(), i,"#DC0000");
					}
				} else {
					SetSumText(3, i,'0%');
				}
//			}
		}
/*
		for ( var x=0; x < LastRow(); x++) {
if (GetCellValue(x, 2) == "M/B(%)") {
				SetRowBackColor(x,"#C9D5EB");
			}
		}
*/
		var check="";
		for ( var i=0; i < document.form.tpsz.length; i++) {
			if (document.form.tpsz[i].checked) {
				check=document.form.tpsz[i].value;
			}
		}
		if (check == "R") {
			document.form.rpt_rdtype.value=document.getElementById('rdtype').options[document.getElementById('rdtype').options.selectedIndex].text;
		} else {
			document.form.rpt_rdtype.value="";
		}
		document.form.rpt_period.value=document.form.period.value;
		document.form.rpt_fromdate.value=document.form.froms.value;
		document.form.rpt_todate.value=document.form.tos.value;
		document.form.rpt_locationby.value=document.getElementById('inquiryLevel').options[document.getElementById('inquiryLevel').options.selectedIndex].text;
		document.form.rpt_location.value=document.form.location.value;
		document.form.rpt_cargotype.value=document.form.cargotype.value;
		document.form.rpt_tpsz.value=check;
		document.form.rpt_enroute.value=document.getElementById('tscntr').options[document.getElementById('tscntr').options.selectedIndex].text;
		document.form.rpt_soc.value=document.getElementById('soc').options[document.getElementById('soc').options.selectedIndex].text;
		document.form.rpt_company.value="";
		SetCellAlign(LastRow()- 3, "loc_cd","CenterTop");
		SetCellAlign(LastRow()- 2, "loc_cd","CenterTop");
		SetCellAlign(LastRow()- 1, "loc_cd","CenterTop");
		SetCellAlign(LastRow(), "loc_cd","CenterTop");
		SetCellAlign(LastRow()- 3, "yard_cd","CenterTop");
		SetCellAlign(LastRow()- 2, "yard_cd","CenterTop");
		SetCellAlign(LastRow()- 1, "yard_cd","CenterTop");
		SetCellAlign(LastRow(), "yard_cd","CenterTop");
		SetCellAlign(LastRow()- 3, "division","Center");
		SetCellAlign(LastRow()- 2, "division","Center");
		SetCellAlign(LastRow()- 1, "division","Center");
		SetCellAlign(LastRow(), "division","Center");
		if (RowCount()> 0) {
			SetMergeCell((sheetObj.LastRow()- 3), 0, 4, 2);
		}
		
		for ( var x=0; x < sheetObj.LastRow(); x++) {
			if (sheetObj.GetCellValue(x, 2) == "M/B()") {
				sheetObj.SetCellText(x, 2, "M/B(%)");
			}
		}
		
		SetSelectRow(0);
	}
	ComBtnEnable("btn_Print");
}
/* end of developer job */
