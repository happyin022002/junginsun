/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1011.js
*@FileTitle  : Turn Time by Movement
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
 * @class EES_CIM_1011 : business script for EES_CIM_1011 
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
var enterSwitch=false;
var arrCntrTypeSize="";
var tabIndex=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var shtCnt=0;
	//var sheet1=sheetObjects[shtCnt++];
	//var sheet2=sheetObjects[shtCnt++];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Retrieve":
			if (tabIndex == 0) {
				doActionIBSheet(sheet1, formObject, IBSEARCH);
				sheetObjects[0].SetSelectRow(0);
			} else {
				doActionIBSheet2(sheet2, formObject, IBSEARCH);
				sheetObjects[1].SetSelectRow(0);
			}
			break;
		case "btn_downexce":
			if (tabIndex == 0) {
				if(sheet1.RowCount() < 1){//no data
	                ComShowCodeMessage("COM132501");
	           }else{
//	        	   sheet1.Down2Excel({ HiddenColumn:true});
	        	   sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(sheet1), SheetDesign:1,Merge:1 });
	           }
			} else {
				if(sheet2.RowCount() < 1){//no data
	                ComShowCodeMessage("COM132501");
	           }else{
//	        	   sheet2.Down2Excel({ HiddenColumn:true});
	        	   sheet2.Down2Excel( {DownCols: makeHiddenSkipCol(sheet2), SheetDesign:1,Merge:1 });
	           }
			}

			break;
		case "btn_new":
			sheet1.RemoveAll();
			sheet2.RemoveAll();
			formObject.reset();
//			document.getElementById("location").disabled=true;
//			document.getElementById("location").className="input2";
/*			document.getElementById("mvmtPair1").disabled=false;
			document.getElementById("mvmtPair1").value="AL";*/
			document.getElementById("mvmtPair2").disabled=true;
			document.getElementById("mvmtPair2").value="Z";
			ComSetFocus(formObject.froms);
			
			tabObjects[0].SetSelectedIndex(0);
			
			sheetObjects[0].SetCellText(0, "pol", "RCC");
			sheetObjects[1].SetCellText(0, "pol", "RCC");
			
			break;
		case "btn_loc_cd": // retrieving Location popup
			var cnt_cd="";
			var loc_cd="";
			cnt_cd=formObject.inquiryLevel.value;
			loc_cd=formObject.location.value;
			if (formObject.inquiryLevel.value != 'AR' && formObject.inquiryLevel.value != 'AC') {
				// if (formObject.inquiryLevel.value == 'CC') { // Country
				// var param = "?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
				// ComOpenPopup("/opuscntr/COM_ENS_0M1.do", 565, 630,
				// "popupFinish", "1,0,1,1,1,1,1,1", true);
				// } else {
				var loc_code="";
				if (formObject.inquiryLevel.value == "RL" || formObject.inquiryLevel.value == "RE") {
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
				// }
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
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
		
	}
	resizeSheet();
	initControl();
	for (k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		 tabObjects[k].SetSelectedIndex(0);
	}
	sheet1_OnLoadFinish();
}
function sheet1_OnLoadFinish(sheetObj) {
	// sheetObj.WaitImageVisible = false;
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	// sheetObj.WaitImageVisible = true;
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
	objs[beforetab].style.display="none";
	// --------------- important --------------------------//
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
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
	// if (isOpen) {
	if (nItem == 0) {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		sheetObjects[0].SetSelectRow(0);
	} else if (nItem == 1) {
		doActionIBSheet2(sheetObjects[1], document.form, IBSEARCH);
		sheetObjects[1].SetSelectRow(0);
	}
	// }
}
		
/**
 * 
 * 
 * @return
 */
function initControl() {
	ComSetFocus(document.form.froms);
//	document.getElementById("location").disabled=true;
//	document.getElementById("location").className="input2";
/*	document.getElementById("mvmtPair1").disabled=false;
	document.getElementById("mvmtPair1").value="AL";*/
	document.getElementById("mvmtPair2").disabled=true;
	document.getElementById("mvmtPair2").value="Z";
	//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	//axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerForm('click', 'obj_click', form);
	//axon_event.addListenerFormat('focus', 'obj_activate', form);
	axon_event.addListenerForm('blur', 'obj_deactivate', form);
	axon_event.addListener('blur', 'obj_blur', 'location');
	//axon_event.addListenerFormat('keyup', 'form_keyup', form);
}
/**
 * 
 * @return
 */
//function form_keyup() {
//	var obj=null;
//	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//	if (keyValue != 13) {
//		ComKeyEnter('lengthnextfocus');
//	} else {
//		obj_deactivate();
//	}
//}
function obj_blur() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
}
/**
 * settiong selected value from Location by loc_cd popup
 */
function popupFinish(aryPopupData, row, col, sheetIdx) {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	formObject.location.value=aryPopupData[0][3]
}
/**
 * 
 * @return
 */
//function obj_keypress() {
//	switch (event.srcElement.name) {
//	case "location":
//		ComKeyOnlyAlphabet('uppernum');// upper case only
//		break;
//	case "froms":
//		// permitting to input "-" in case of numbers only
//		ComKeyOnlyNumber(event.srcElement);
//		break;
//	case "tos":
//		// permitting to input "-" in case of numbers only
//		ComKeyOnlyNumber(event.srcElement);
//		break;
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
		if (retMonth >= 3) {
			if (ComGetEvent("name") == "tos") {
				ComShowCodeMessage("CIM29044");
				ComSetFocus(document.getElementById("tos"));
			}
			return false;
		}
	} else if (period == "W") {
		if (frYearDate == toYearDate) {
			week=eval(toMonthDate) - eval(frMonthDate) + 1;
		} else {
			betwMonth=fromTo - eval(frMonthDate) + eval(toMonthDate) + 1;
			if ((eval(toYearDate) - eval(frYearDate)) == 1) { // 1년 차이일때
				week=betwMonth;
			} else {
				week=(eval(toYearDate) - eval(frYearDate) - 1) * fromTo + betwMonth;
			}
		}
		if (week > 13) {
			if (ComGetEvent("name") == "tos") {
				ComShowCodeMessage("CIM29044");
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
// handling Axon event
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
			} else { // retrieving by week
				if (sVal1 != "" && sVal2 != "") {
					if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
						ComShowCodeMessage("CIM29003");
						enterSwitch=false;
						t.value="";
					//	t.focus();
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
					var evt = ComGetEvent("value");
					evt.value="";
					ComShowCodeMessage("CIM21004", "YYYYMM");
					enterSwitch=false;
					//evt.focus();
					evt.select();
					return false;
				}
			} else { // retrieving by week
				if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6)) && ComGetEvent("name") == 'froms') {
					var evt = ComGetEvent("value");
					//event.srcElement.value="";
					evt.value="";
					ComShowCodeMessage("CIM21004", "YYYYWW");
					//evt.focus();
					evt.select();
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
/**
 * focus in
 * @return
 */
function obj_activate() {
	ComClearSeparator(ComGetEvent());
	ComSetFocus(ComGetEvent());
}
/**
 * SELECT BOX change event
 * 
 * @return
 */
function obj_change() {
	obj=ComGetEvent();
	if (obj.name == "inquiryLevel") {
		if (obj.value == "AR" || obj.value == "AC") {
			document.getElementById("location").disabled=true;
			document.getElementById("location").className="input2";
			document.getElementById("location").value="";
		} else {
			document.getElementById("location").value = "";
			document.getElementById("location").disabled=false;
			document.getElementById("location").className="input1";
			document.getElementById("location").focus();
		}
		if (obj.value == "CC") {
			document.getElementById("location").setAttribute("maxLength", 2);
		} else {
			document.getElementById("location").setAttribute("maxLength", 5);
		}
	} else if (obj.name == "period") {
		if (obj.value == "M") {
			document.getElementById("froms").setAttribute("dataformat", "ym");
			document.getElementById("tos").setAttribute("dataformat", "ym");
			document.form.froms.value="";
			document.form.tos.value="";
			document.form.from.value="";
			document.form.to.value="";
			ComSetFocus(document.form.froms);
		} else {
			document.getElementById("froms").setAttribute("dataformat", "yw");
			document.getElementById("tos").setAttribute("dataformat", "yw");
			document.form.froms.value="";
			document.form.tos.value="";
			document.form.from.value="";
			document.form.to.value="";
			ComSetFocus(document.form.froms);
		}
	}
}
/**
 * clicking event
 * 
 * @return
 */
function obj_click() {
	obj=ComGetEvent();
	if (obj.name == "mvmtPairDivision") {
		if (obj.value == "1") {
/*			document.getElementById("mvmtPair1").disabled=false;
			document.getElementById("mvmtPair1").value="AL";*/
			document.getElementById("mvmtPair2").disabled=true;
			document.getElementById("mvmtPair2").value="Z";
		} else {
//			document.getElementById("mvmtPair1").disabled = true;
//			document.getElementById("mvmtPair1").value = "AL";
			document.getElementById("mvmtPair2").disabled=false;
			document.getElementById("mvmtPair2").value="Z";
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
		switch (sheetID) {
		case "sheet1": // t1sheet1 init
		    with(sheetObj){
			//var HeadTitle="RCC|MVMT Pair|Total";
			if (HeadTitle == null || HeadTitle == "") {
				HeadTitle="RCC|MVMT Pair|Total";
			}
			oldCntrTypeSize=sCntrTypeSize;
        	var arrCntrTypeSize=oldCntrTypeSize.split("|");
//        	for ( var i=0; i < arrCntrTypeSize.length; i++) {
//        		if (sCntrTypeSize != "") {
//        			HeadTitle += "|" + arrCntrTypeSize[i];
//        		}
//        	}
			var headCnt=HeadTitle.split("|").length;

//			SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:7, Page:20, DataRowMerge:1 } );
			SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:7, Page:20, DataRowMerge:0,PrevColumnMergeMode:0  } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

	      var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pol",     KeyField:0,   CalcLogic:"",   Format:"" },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"etc",     KeyField:0,   CalcLogic:"",   Format:"" },
	             {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"total",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 } ];
	      var sCount="";
          var x=1;
	      for ( var i=0; i < arrCntrTypeSize.length-1; i++) {
	    	  if (arrCntrTypeSize.length > 1) {
	    		  if (x < 10) {
	    			  sCount="count0" + x;
	    		  } else {
	    			  sCount="count" + x;
	    		  }
	    		  cols.push({Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:sCount,    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 });
	            x++;
	    	  }
	      	}
	      //FrozenCols=3;
	      SetEditable(0);
	      InitColumns(cols);
	      //SetSheetHeight(435);
	      ComResizeSheet(sheetObj);
	      //resizeSheet();
	      }
      break;


	case "sheet2": // t1sheet1 init
		with(sheetObj){
			var arrCntrTypeSize=oldCntrTypeSize.split("|");
	      if (HeadTitle == null || HeadTitle == "") {
	    	  HeadTitle="RCC|MVMT Pair|Division|Total";
	      }
	      var headCnt=HeadTitle.split("|").length;
	    //  (headCnt, 0, 0, true);
	      var rowCnt=0;
	      var POL=80;
	      var Division=60;
	      var Total=70;
	      cnt=0;
	      
//	      SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:7, Page:20, DataRowMerge:1 } );
	      SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:7, Page:20, DataRowMerge:0,PrevColumnMergeMode:0 } );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Text",      Hidden:0,  Width:POL,  Align:"Center",  ColMerge:1,   SaveName:"pol",         KeyField:0,   CalcLogic:"",   Format:"" },
	                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"etc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:false },
	                   {Type:"Text",      Hidden:0,  Width:Division,Align:"Center",  ColMerge:1,   SaveName:"division",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:false },
	                   {Type:"Float",       Hidden:0,  Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total",       KeyField:0,   CalcLogic:"",   Format:"NullFloat", PointCount:1 } ];
//	      var sCount = "";
//	      var sDays = "";
//	      var x = 1;
	      
//	      for ( var i=0; i < arrCntrTypeSize.length-1; i++) {
//			  if (arrCntrTypeSize.length > 1) {
//				  if (x < 10) {
//					  sCount="count0" + x;
//				  } else {
//					  sCount="count" + x;
//				  }
//				  cols.push({Type:"Float",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sCount,        KeyField:0,   CalcLogic:"",   Format:"NullFloat", PointCount:1 });
//				  x++;
//			  }
//		  }
	      
	      cols.push({Type:"Text",      Hidden:0,  Width:POL,  Align:"Center",  ColMerge:1,   SaveName:"d2VVD",       KeyField:0,   CalcLogic:"",   Format:"" });
		  cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"d2Division",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
		  cols.push({Type:"Text",      Hidden:0,  Width:Division,Align:"Center",  ColMerge:1,   SaveName:"division",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:false });
		  cols.push({Type:"Float",     Hidden:0,  Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 });
		  
//		  x = 1;
//		  for ( var i=0; i < arrCntrTypeSize.length-1; i++) {
//			  if (arrCntrTypeSize.length > 1) {
//				  if (x < 10) {
//					  sCount="count0" + x;
//				  } else {
//					  sCount="count" + x;
//				  }
//				  cols.push({Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sCount,        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 });
//				  x++;
//			  }
//		  }
//		  
		  cols.push({Type:"Text",      Hidden:0,  Width:POL,  Align:"Center",  ColMerge:1,   SaveName:"d3VVD",       KeyField:0,   CalcLogic:"",   Format:"" });
		  cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"d3Division",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
		  cols.push({Type:"Text",      Hidden:0,  Width:Division,Align:"Center",  ColMerge:1,   SaveName:"division",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:false });
		  cols.push({Type:"Float",     Hidden:0,  Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 });
		  
		  x = 1;
	      for ( var i=0; i < arrCntrTypeSize.length-1; i++) {
	    	  if (arrCntrTypeSize.length > 1) {
	    		  if (x < 10) {
	    			  sCount="count0" + x;
	    		  } else {
	    			  sCount="count" + x;
	    		  }
	    		  cols.push({Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sCount,        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 });
	    		  x++;
	    	  }
	      }
	      InitColumns(cols);
	      //SetSheetHeight(435);
	      //resizeSheet();
	      SetEditable(0);
	  }
      break;
	}
}
function resizeSheet(){
    for (i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i]);
    }
}
//Sheet의 높이 자동으로 변경
/*function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}*/
//handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: 
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			var sXml=sheetObj.GetSearchData("EES_CIM_1011GS.do", FormQueryString(formObj));
			var str_loc_nm="";
			var f=document.form.inquiryLevel;
			var gubun="";
			for ( var i=0; i < document.form.mvmtPairDivision.length; i++) {
				if (document.form.mvmtPairDivision[i].checked) {
					gubun=document.form.mvmtPairDivision[i].value;
				}
			}
			if (f.value == "AR") {
				str_loc_nm="RCC";
			} else if (f.value == "RL") {
				str_loc_nm="LCC";
			} else if (f.value == "LE" || f.value == "RE") {
				str_loc_nm="ECC";
			} else if (f.value == "LS" || f.value == "ES") {
				str_loc_nm="SCC";
			} else if (f.value == "SS" && gubun == "1") {
				str_loc_nm="SCC";
			} else if (f.value == "SS" && gubun == "2") {
				str_loc_nm="Yard";
			} else if (f.value == "RC" || f.value == "AC" || f.value == "CC") {
				str_loc_nm="Country";
			}
			var HeadTitle=str_loc_nm + "|MVMT Pair|Total" + sCntrTypeSize;
			sheet1.RenderSheet(0);
//			sheet1.RemoveAll();
			sheetObjects[0] = sheet1.Reset();
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
			formObj.f_cmd.value=SEARCH01;
			// var sXml = sheetObj.GetSearchXml("EES_CIM_1001GS.do",
			// FormQueryString(formObj));
			var sXml=formObj.sXml.value;
			sCntrTypeSize=ComGetEtcData(sXml, "cntrTypeSize");
			//getting changing column information from servergetting changing column information from serverif (oldCntrTypeSize != sCntrTypeSize) {
				oldCntrTypeSize=sCntrTypeSize;
				arrCntrTypeSize=oldCntrTypeSize.split(",");
				sCntrTypeSize="";
				// handling header title by changing column
				for ( var i=0; i < arrCntrTypeSize.length; i++) {
					sCntrTypeSize += "|" + arrCntrTypeSize[i];
				}
				var HeadTitle="RCC|MVMT Pair|Total" + sCntrTypeSize;
				var HeadTitle1="RCC|MVMT Pair|Division|Total" + sCntrTypeSize;
				sheetObjects[0] = sheet1.Reset();
				initSheet(sheetObjects[0], 1, HeadTitle);
				initSheet(sheet2, 2, HeadTitle1);
			}
			// sheetObj.LoadSearchXml(sXml);
			ComSetFocus(document.form.froms);
		//}
		break;
	case IBSEARCH_ASYNC02: // location focusOut
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
		} else {
			return;
		}
		break;
	}
}
//handling process for Sheet
function doActionIBSheet2(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH:
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH01;
			var sXml=sheetObj.GetSearchData("EES_CIM_10112GS.do", FormQueryString(formObj));
			var str_loc_nm="";
			var f=document.form.inquiryLevel;
			var gubun="";
			for ( var i=0; i < document.form.mvmtPairDivision.length; i++) {
				if (document.form.mvmtPairDivision[i].checked) {
					gubun=document.form.mvmtPairDivision[i].value;
				}
			}
			if (f.value == "AR") {
				str_loc_nm="RCC";
			} else if (f.value == "RL") {
				str_loc_nm="LCC";
			} else if (f.value == "LE" || f.value == "RE") {
				str_loc_nm="ECC";
			} else if (f.value == "LS" || f.value == "ES") {
				str_loc_nm="SCC";
			} else if (f.value == "SS" && gubun == "1") {
				str_loc_nm="SCC";
			} else if (f.value == "SS" && gubun == "2") {
				str_loc_nm="Yard";
			} else if (f.value == "RC" || f.value == "AC" || f.value == "CC") {
				str_loc_nm="Country";
			}
			var HeadTitle=str_loc_nm + "|MVMT Pair|Division|Total" + sCntrTypeSize;
			sheet2.RenderSheet(0);
//			sheet2.RemoveAll();
			sheetObjects[1] = sheet2.Reset();
			initSheet(sheetObjects[1], 2, HeadTitle);
			sheetObjects[1].RenderSheet(1);
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
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++]=tab_obj;
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
			if (location.value == "") {
				if (inquiryLevel.value != "AR" && inquiryLevel.value != "AC") {
					ComShowCodeMessage("CIM21001", "Location by");
					ComSetFocus(location);
					return false;
				}
/*
				if (inquiryLevel.value == "RL") {
					ComShowCodeMessage("CIM29014");
					ComSetFocus(location);
					return false;
				} else if (inquiryLevel.value == "LE") {
					ComShowCodeMessage("CIM29015");
					ComSetFocus(location);
					return false;
				} else if (inquiryLevel.value == "LS" || inquiryLevel.value == "ES" || inquiryLevel.value == "SS") {
					ComShowCodeMessage("CIM29016");
					ComSetFocus(location);
					return false;
				}
*/				
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
/**
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
/*
	 with (sheetObj) {
		for ( var x=0; x <= LastRow(); x++) {
if (GetCellValue(x, 0) == "") {
				SetCellValue(x, 0,"Average");
		SetCellFont("FontBold", x, 0,1);
			}
		}
	}
*/
}
/**
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
/*
	 with (sheetObj) {
		for ( var x=0; x <= LastRow(); x++) {
if (GetCellValue(x, 0) == "") {
				SetCellValue(x, 0,"Average");
				SetCellAlign(x, 0,"CenterTop");
//parameter changed[check again]CLT 				SetCellFont("FontBold", x, 0,1);
			}
		}
		SetWaitImageVisible(1);
	}
*/
}
/* 개발자 작업 끝 */
