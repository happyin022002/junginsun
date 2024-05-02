/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1018.js
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
/* developer job  */
// common global variables
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var oldCntrTypeSize="";
var oldCntrTypeSize2="";
var sCntrTypeSize="";
var isOpen=true;
var tabIndex=0;
var head_cntr_tpsz_cd="";
var tabFlag=0;
var comboObjects=new Array();
var comboCnt=0;
var isSearch=0;
var sPeriod=""
var str_loc_nm="";
var IBSEARCH02=30;
// controlling XTC date event
var enterSwitch=false;
var sheet3_header_title="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var shtCnt=0;
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Retrieve":
			isSearch=1;
			if (tabIndex == 0) {
				doActionIBSheet(t1sheet1, formObject, IBSEARCH);
				sheetObjects[0].SetSelectRow(0);
			} else if (tabIndex == 1) {
				doActionIBSheet2(t2sheet1, formObject, IBSEARCH);
				sheetObjects[1].SetSelectRow(0);
			} else if (tabIndex == 2) {
				doActionIBSheet3(t3sheet1, formObject, IBSEARCH);
				sheetObjects[2].SetSelectRow(0);
			}
			break;
		case "btn_new":
			t1sheet1.RemoveAll();
			t2sheet1.RemoveAll();
			t3sheet1.RemoveAll();
			formObject.reset();
			isSearch=0;
			document.getElementById("location").disabled=true;
			document.getElementById("location").className="input2";
			document.getElementById("froms").focus();
			
			tabObjects[0].SetSelectedIndex(0);
			
			sheetObjects[0].SetCellText(0, "loc_cd", "RCC");
			sheetObjects[1].SetCellText(0, "loc_cd", "RCC");
			sheetObjects[2].SetCellText(0, "loc_cd", "RCC");
			break;
		case "btn_loc_cd": //retrieving Location popup
			var cnt_cd="";
			var loc_cd="";
			cnt_cd=formObject.locationBy.value;
			loc_cd=formObject.location.value;
			if (formObject.locationBy.value != 'AR' && formObject.locationBy.value != 'AC') {
				if (formObject.locationBy.value == 'CC') { //Country
					var param="?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
					ComOpenPopup("/opuscntr/COM_ENS_0M1.do", 565, 650, "popupFinish", "1,0,1,1,1,1,1,1", true);
				} else {
					var loc_code="";
					if (formObject.locationBy.value == "RL" || formObject.locationBy.value == "RE") {
						loc_code="rcc_cd";
					} else if (formObject.locationBy.value == "LE") {
						loc_code="lcc_cd";
					} else if (formObject.locationBy.value == "LS") {
						loc_code="lcc_cd";
					} else if (formObject.locationBy.value == "ES") {
						loc_code="ecc_cd";
					} else if (formObject.locationBy.value == "SS") {
						loc_code="scc_cd";
					}
					var param="?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
					ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 460, loc_code + ":location", "1,0,1,1,1,1,1,1", true);
				}
			}
			break;
		case "btn_downExcel":
			if (tabIndex == 0) {
//				doActionIBSheet(t1sheet1, formObject, IBDOWNEXCEL);
				t1sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(t1sheet1), DownRows : "Visible", SheetDesign:1,Merge:1 });
			} else if (tabIndex == 1) {
				t2sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(t2sheet1), DownRows : "Visible", SheetDesign:1,Merge:1 });
//				t2sheet1.Down2Excel({ HiddenColumn:-1,Merge:true});
//						"/apps/opus/ees/cim/cntroperationperformancemgt/eqmatchbacknloadfactormgt/script/EES_CIM_1025_XLS.xml");
			} else if (tabIndex == 2) {
				t3sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(t3sheet1), DownRows : "Visible", SheetDesign:1,Merge:1 });
//				t3sheet1.Down2Excel({ HiddenColumn:-1,Merge:true});
			}
			break;
		case "btn_Print":
			if (sheetObjects[1].rowcount == 0) {
				errMsg='No data found.';
				ComShowMessage(msgs["CIM29030"]);
				return;
			}
			formObject.f_cmd.value=IBSEARCH02;
			ComOpenPopupWithTarget('/opuscntr/EES_CIM_1918_POP.do', 775, 770, "", "0,1,1,1,1,1,1", true);
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
		} // end if
	} // end try
}
/**
 * setting value from Location by loc_cd popup
 */
function popupFinish(aryPopupData, row, col, sheetIdx) {
	var sheetObject=t1sheet1;
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
function loadPage(gubun) {
	var formObject=document.form;
	document.getElementById("location").className="input2";
	/////////////////////////////////////////////////////////
	if("Y"==formObject.pop_yn.value){
		//showing popup button part
		//document.all.popLayer.style.display="";
	}
	
	/////////////////////////////////////////////////////////
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	resizeSheet();
	axon_event.addListenerForm('click', 'obj_tpsz_click', form);
	//axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 
	//axon_event.addListenerFormat('keyup', 'form_keyup', form);
	//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('blur', 'obj_deactivate', form);
	axon_event.addListener('blur', 'obj_blur', 'location');
	for (k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		 tabObjects[k].SetSelectedIndex(0);
	}
	if (gubun != "") {
		tabObjects[0].SetSelectedIndex(2);
		enterSwitch=true;
	}
	ComBtnDisable("btn_Print");
	t1sheet1_OnLoadFinish(t1sheet1);
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
	if (obj.name == "tpsz") { // by TP/SZ
		if (obj.value != "R") {
			document.form.rdtype.disabled=true;
		} else {
			document.form.rdtype.disabled=false;
		}
	}
}
//function obj_keypress() {
//	switch (ComGetEvent().name) {
//	case "location":
//		if (document.form.locationBy.value == "Y") {
//			ComKeyOnlyAlphabet('uppernum');// upper case, numbers only
//		} else {
//			ComKeyOnlyAlphabet('upper');// upper case, numbers only
//		}
//		break;
//	case "froms":
//		// permitting to input "-" in case of numbers
//		ComKeyOnlyNumber(event.srcElement);
//		break;
//	case "tos":
//		// permitting to input "-" in case of numbers
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
function obj_blur() {
	doActionIBSheet(t1sheet1, document.form, IBSEARCH_ASYNC02);
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
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
*/
function initSheet(sheetObj, sheetNo, HeadTitle) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "t1sheet1": //t1sheet1 init
	    with(sheetObj){
		//var oldCntrTypeSize="";
			oldCntrTypeSize=sCntrTypeSize;
			var arrTpSz=oldCntrTypeSize.split("|");
			if (HeadTitle == null || HeadTitle == "") {
				HeadTitle="RCC|Total";
				for ( var i=0; i < arrTpSz.length; i++) {
					HeadTitle += "|" + arrTpSz[i];
				}
				//var headCount=ComCountHeadTitle(HeadTitle);
				//(headCount, 0, 0, true);
			}
			//alert(HeadTitle);
			var headCnt=HeadTitle.split("|").length;
			if (SheetWidth > 975) {
			}
			// sheetObj.FrozenCols=2;

			SetConfig( { SearchMode:2, FrozenCol:2, MergeSheet:7, Page:20, DataRowMerge:0 ,PrevColumnMergeMode:0} );
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ 
			            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
			            {Type:"Text",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 } ];
            			for ( var i=0; i < arrTpSz.length-1; i++) {
            				arEtcData="_" + i;
            				cols.push({Type:"Text",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"qty"+arEtcData, KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
            			}
            			cols.push({Type:"AutoSum",   Hidden:1, Width:100,  Align:"Left",    ColMerge:1});
 
            			InitColumns(cols);
            			SetSheetHeight(425);
            			//resizeSheet();
            			ComResizeSheet(sheetObj);
            			SetEditable(0);
            } // end with


		break;
	case "t2sheet1": //t2sheet1 init
	    with(sheetObj){
	       var cols=[];
	       var colsList = [];
	       
	      oldCntrTypeSize2=sCntrTypeSize;
	      if(oldCntrTypeSize2.length > 1){
	    	  oldCntrTypeSize2 = oldCntrTypeSize2.substring(1);
	      }
	      var arrTpSz=oldCntrTypeSize2.split("|");
	      if (HeadTitle == null || HeadTitle == "") {
	    	  HeadTitle="RCC|Division|Total";
	      for ( var i=0; i < arrTpSz.length; i++) {
	    	  HeadTitle += "|" + arrTpSz[i];
	      }
	      var headCount=ComCountHeadTitle(HeadTitle);
	//      (headCount, 0, 0, true);
	      }
	      var headCnt=HeadTitle.split("|").length;
//	      if (SheetWidth > 975) {
//	      }
	//      (headCnt, 0, 0, true);
//	      sheetObj.FrozenCols=3;
//	      var RowCnt=0;
		  SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:1, Page:20, DataRowMerge:0,PrevColumnMergeMode:0 } );
		  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		  var headers = [ { Text:HeadTitle, Align:"Center"} ];
		  InitHeaders(headers, info);
	
	      for ( var RowCnt=0; RowCnt < 4; RowCnt++) {
//		      cnt=0;
		      cols = [];
		      if (RowCnt == 3) {
		    	  cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"division",      KeyField:0,   CalcLogic:"",   Format:"" },
			             {Type:"Text",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",         KeyField:0,   CalcLogic:"",   Format:"" } ];
		    	  
			            for ( var i=0; i < arrTpSz.length; i++) {
			            	arEtcData="_" + i;
			            	cols.push({Type:"Text",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"qty"+arEtcData, KeyField:0,   CalcLogic:"",   Format:"" });
		            	}
		//            cols.push({Type:"AutoSum",   Hidden:1, Width:100,  Align:"Left",    ColMerge:1});
		      } else {
		    	  cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" });
		    	  cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"division",      KeyField:0,   CalcLogic:"",   Format:"" });
		    	  cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",         KeyField:0,   CalcLogic:"",   Format:"" });
			      for ( var i=0; i < arrTpSz.length; i++) {
				      arEtcData="_" + i;
				      cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"qty"+arEtcData, KeyField:0,   CalcLogic:"",   Format:"" });
			      }
		//      cols.push({Type:"AutoSum",   Hidden:1, Width:100,  Align:"Left",    ColMerge:1});
		      }
		      colsList.push(cols);
	      }
	//      SetWaitTimeOut(300);
	//      SetExtendLastCol(0);
	      InitColumns(colsList,4);	 
//	      InitColumns(cols);
	      SetSheetHeight(425);
	      //resizeSheet();
	      SetEditable(0);
	     
      } // end with


		break;
	case "t3sheet1": //t3sheet1 init
	    with(sheetObj){
			if (HeadTitle == null || HeadTitle == "") {
				HeadTitle="RCC|TP/SZ|Division|Total";
			}
			var headCnt=HeadTitle.split("|").length;


			SetConfig( { SearchMode:0, FrozenCol:3, MergeSheet:1, Page:1000, DataRowMerge:0,PrevColumnMergeMode:0 } );
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };

			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
      
			var colsList = [];
			var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"division",      KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",         KeyField:0,   CalcLogic:"",   Format:"" } ];
      
            for ( var i=0; i < headCnt - 4; i++) {
            	arEtcData="_" + i;
            	cols.push({Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"qty"+arEtcData, KeyField:0,   CalcLogic:"",   Format:"" });
            }
            colsList.push(cols); 
      
	      cols=[];
	      cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" });
	      cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"" });
	      cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"division",      KeyField:0,   CalcLogic:"",   Format:"" });
	      cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",         KeyField:0,   CalcLogic:"",   Format:"" });
	      for ( var i=0; i < headCnt - 4; i++) {
	    	  arEtcData="_" + i;
	    	  cols.push({Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"qty"+arEtcData, KeyField:0,   CalcLogic:"",   Format:"" });
	      }
	      colsList.push(cols); 
      
	      cols=[]; 
	      cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" });
	      cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"" });
	      cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"division",      KeyField:0,   CalcLogic:"",   Format:"" });
	      cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",         KeyField:0,   CalcLogic:"",   Format:"" });
	      for ( var i=0; i < headCnt - 4; i++) {
	    	  arEtcData="_" + i;
	      	cols.push({Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"qty"+arEtcData, KeyField:0,   CalcLogic:"",   Format:"" });
	      }
	      colsList.push(cols); 
      
	      cols=[];
	      cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" });
	      cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"" });
	      cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"division",      KeyField:0,   CalcLogic:"",   Format:"" });
	      cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",         KeyField:0,   CalcLogic:"",   Format:"" });
	      for ( var i=0; i < headCnt - 4; i++) {
	    	  arEtcData="_" + i;
	    	  cols.push({Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"qty"+arEtcData, KeyField:0,   CalcLogic:"",   Format:"" });
	      }
	 
	      colsList.push(cols); 
	      
	      InitColumns(colsList , 4);
	      SetSheetHeight(425);
	      //resizeSheet();
	      SetEditable(0);
	      //SetExtendLastCol(0);
      } // end with


		break;
	case "sheet": //t3sheet1 init
	  
      sheetObj.SetVisible(false);
      

		break;
	} // end switch
} // end function
//Sheet의 높이 자동으로 변경
/*function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}*/
function resizeSheet(){
    for (i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i]);
    }
}

function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	document.getElementById("flag0001").value="No";
	switch (sAction) {
	case IBSEARCH: 
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			var sXml=sheetObj.GetSearchData("EES_CIM_1018GS.do", FormQueryString(formObj));
//			sheetObj.LoadSearchData(sXml,{Sync:1} );
			sheetObj.LoadSearchData(sXml,{Sync:0} );
			sheetObj.SetWaitImageVisible(1);
			ComOpenWait(false);
		}
		break;
	case IBSEARCH_ASYNC01: 
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH01;
			var sXml="";
			if (sheetObj.id == "t1sheet1") {
				//	sXml = sheetObj.GetSearchXml("EES_CIM_1001GS.do",FormQueryString(formObj));
				var sXml=formObj.sXml.value;
			}
			sCntrTypeSize=ComGetEtcData(sXml, "cntrTypeSize");
			//getting changing column information from server
			
			head_cntr_tpsz_cd=sCntrTypeSize;
			oldCntrTypeSize=sCntrTypeSize;
			
			var arrCntrTypeSize=oldCntrTypeSize.split(",");
			sCntrTypeSize="";
			// handling header title by changing column
			for ( var i=0; i < arrCntrTypeSize.length; i++) {
				sCntrTypeSize += "|" + arrCntrTypeSize[i];
			}
			
			var HeadTitle="RCC|Total" + sCntrTypeSize;
			//alert('[ 111111111111] : '+HeadTitle);
			var headtittle1="RCC|Division|Total" +sCntrTypeSize;
			sheetObjects[0] = sheetObjects[0].Reset();
			initSheet(sheetObjects[0],1,HeadTitle);
			sheetObjects[1] = sheetObjects[1].Reset();
			initSheet(sheetObjects[1],2,headtittle1);
		} // end if
		break;
	case IBSEARCH_ASYNC02: //location focusOut
		//if (validateForm(sheetObj, formObj, sAction)) {
		formObj.f_cmd.value=SEARCH02;
		document.form.inquiryLevel.value=document.getElementById("locationBy").value.substring(0, 1);
		if (formObj.location.value == "") {
			return true;
		}
		if (formObj.inquiryLevel.value == "") {
			return false;
		}
		sheetObj.SetWaitImageVisible(0);
		var sXml=sheetObj.GetSearchData("EES_CIM_1001GS.do", FormQueryString(formObj));
		var sCheck=ComGetEtcData(sXml, "check");
		if (sCheck != "OK") {
			var xLocationBy=document.getElementById("locationBy").value.substring(0, 1);
			if (document.form.location.value != "") {
				if (xLocationBy == "R") {
					ComShowCodeMessage("CIM29031");
					document.form.location.value="";
					sheetObj.SetWaitImageVisible(1);
					ComSetFocus(document.form.location);
					return false;
				} else if (xLocationBy == "L") {
					ComShowCodeMessage("CIM29032");
					document.form.location.value="";
					sheetObj.SetWaitImageVisible(1);
					ComSetFocus(document.form.location);
					return false;
				} else if (xLocationBy == "E") {
					ComShowCodeMessage("CIM29033");
					document.form.location.value="";
					sheetObj.SetWaitImageVisible(1);
					ComSetFocus(document.form.location);
					return false;
				} else if (xLocationBy == "Y") {
					ComShowCodeMessage("CIM29021");
					document.form.location.value="";
					sheetObj.SetWaitImageVisible(1);
					ComSetFocus(document.form.location);
					return false;
				} else if (xLocationBy == "P") {
					ComShowCodeMessage("CIM29010");
					document.form.location.value="";
					sheetObj.SetWaitImageVisible(1);
					ComSetFocus(document.form.location);
					return false;
				} else if (xLocationBy == "C") {
					ComShowCodeMessage("CIM29037");
					document.form.location.value="";
					sheetObj.SetWaitImageVisible(1);
					ComSetFocus(document.form.location);
					return false;
				} else if (xLocationBy == "S") {
					ComShowCodeMessage("CIM29034");
					document.form.location.value="";
					sheetObj.SetWaitImageVisible(1);
					ComSetFocus(document.form.location);
					return false;
				}
			} else {
				return true;
			} // end if (document.form.location.value != "") {
		} // end if (sCheck != "OK") {
		sheetObj.SetWaitImageVisible(1);
		ComSetFocus(document.form.cargoType);
		break;
	case IBDOWNEXCEL: 
		sheetObj.SetWaitImageVisible(1);
		sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
		break;
	} // end switch
}
// handling process for Sheet
function doActionIBSheet2(sheetObj, formObj, sAction) {
	t2sheet1.ShowDebugMsg(false);
	document.getElementById("flag0001").value="No";
	switch (sAction) {
	case IBSEARCH: 
		if (validateForm(sheetObj, formObj, sAction)) {
			t2sheet1.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH01;
			var sXml=t2sheet1.GetSearchData("EES_CIM_10182GS.do", FormQueryString(formObj));
			//sXml = sXml.replace(/%/gi,"");
			t2sheet1.LoadSearchData(sXml,{Sync:1} );
			t2sheet1.SetWaitImageVisible(1);
			ComOpenWait(false);
		}
		break;
	} // end switch
} // end function
//handling process for Sheet
function doActionIBSheet3(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	document.getElementById("flag0001").value="No";
	switch (sAction) {
	case IBSEARCH: 
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH02;
			var sXml=sheetObj.GetSearchData("EES_CIM_10183GS.do", FormQueryString(formObj));
			sXml = sXml.replace(/%/gi,"");
			sPeriod=ComGetEtcData(sXml, "head");
			//getting changing column information from server
			//var str_loc_nm = "";
			var f=document.form.locationBy;
			if (f.value == "AR") {
				str_loc_nm="RCC";
			} else if (f.value == "AC" || f.value == "CC") {
				str_loc_nm="Country";
			} else if (f.value == "AP") {
				str_loc_nm="Port";
			} else if (f.value == "RL") {
				str_loc_nm="LCC";
			} else if (f.value == "LE" || f.value == "RE") {
				str_loc_nm="ECC";
			} else if (f.value == "LS" || f.value == "ES" || f.value == "SS") {
				str_loc_nm="SCC";
			}
			var HeadTitle=str_loc_nm + "|TP/SZ|Division|Total|" + sPeriod;
			sheet3_header_title = HeadTitle;
//			sheetObj.Reset();
			sheetObjects[2] = t3sheet1.Reset();
			initSheet(sheetObjects[2], 2, HeadTitle);
			sheetObjects[2].LoadSearchData(sXml,{Sync:0} );
			sheetObjects[2].SetWaitImageVisible(1);
			ComOpenWait(false);
		}
		break;
	} // end switch
} // end function
function form_keyup() {
	var obj=null;
	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	if (keyValue != 13) {
		ComKeyEnter('lengthnextfocus');
	} else {
		obj_deactivate()
	}
}
//function to handle event
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
						//ComShowCodeMessage("CIM29004");
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
					ComGetEvent().value="";
					ComShowCodeMessage("CIM21004", "YYYYMM");
					enterSwitch=false;
					//ComGetEvent().focus();
					ComGetEvent().select();
					return false;
				}
			} else { // retrieving by week
				if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6)) && ComGetEvent("name") == 'froms') {
					ComGetEvent().value="";
					ComShowCodeMessage("CIM21004", "YYYYWW");
					//ComGetEvent().focus();
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
		//document.getElementById("froms").focus();
	} else if (obj.name == "locationBy") {
		if (obj.value == "AR" || obj.value == "AC" || obj.value == "AP") {
			document.getElementById("location").disabled=true;
			document.getElementById("location").value="";
			document.getElementById("location").className="input2";
		} else {
			document.getElementById("location").disabled=false;
		//	document.getElementById("location").value = "";
			document.getElementById("location").className="input1";
			//document.getElementById("location").focus();
		}
		if (obj.value == "CC") {
			document.getElementById("location").setAttribute("maxLength", 2);
		} else {
			document.getElementById("location").setAttribute("maxLength", 5);
		}
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
			InsertItem( "M/Back(%)", "");
			InsertItem( "M/B Detail", "");
			InsertItem( "M/B Trend", "");
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
	var sheetObject=sheetObjects[beforetab];
	resizeSheet();
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
					ComShowCodeMessage("CIM21001", "Period ");
					ComSetFocus(froms);
					return false;
				} else if (tos.value == "") {
					ComShowCodeMessage("CIM21001", "Period ");
					ComSetFocus(tos);
					return false;
				}
			}
			if (location.value == "" && sAction == IBSEARCH) {
				if (locationBy.value == 'RL' || locationBy.value == 'LE' || locationBy.value == 'LS' || locationBy.value == 'ES' || locationBy.value == 'SS'
						|| locationBy.value == "CC" || locationBy.value == "RE") {
					ComShowCodeMessage("CIM21001", "Location By");
					ComSetFocus(location);
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
		}
	} // end of with
	return true;
}
function t1sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
	//with (sheetObj) {
		var str_loc_nm="";
		var f=document.form.locationBy;
		if (f.value == "AR") {
			str_loc_nm="RCC";
		} else if (f.value == "AC" || f.value == "CC") {
			str_loc_nm="Country";
		} else if (f.value == "AP") {
			str_loc_nm="Port";
		} else if (f.value == "RL") {
			str_loc_nm="LCC";
		} else if (f.value == "LE" || f.value == "RE") {
			str_loc_nm="ECC";
		} else if (f.value == "LS" || f.value == "ES" || f.value == "SS") {
			str_loc_nm="SCC";
		}
		sheetObj.SetCellValue(0, 0,str_loc_nm,0);
		sheetObj.SetRowBackColor(sheetObj.LastRow(), "#F7E1EC");
		var arrTime=sCntrTypeSize.split(",");
//		alert(HeadTitle.length);
		for ( var i=1; i < arrTime.length + 21; i++) {
			if (sheetObj.GetCellValue(sheetObj.RowCount(), i) == 0.0) {
				sheetObj.SetSumText(0, i,0);
			} else {
				sheetObj.SetCellFontColor(sheetObj.LastRow(), 0,"#000000");
				if ((sheetObj.GetCellValue(sheetObj.RowCount(), i)) != -1) {
					sheetObj.SetCellFontColor(sheetObj.LastRow(), i,"#DC0000");
				} else {
					sheetObj.SetCellFontColor(sheetObj.LastRow(), i,"#000000");
				}
				sheetObj.SetSumText(0, i,sheetObj.GetCellValue(sheetObj.RowCount(), i));
			}
		}
		if (sheetObj.RowCount()> 0) {
			sheetObj.SetRowHidden(sheetObj.RowCount(),1);
		}
		for ( var i=2; i < arrTime.length + 4; i++) {
			if (sheetObj.GetCellValue(sheetObj.LastRow()- 1, i) == "") {
				sheetObj.SetSumText(0, i,"");
				sheetObj.SetSumText(1, i,"");
				sheetObj.SetSumText(2, i,"");
				sheetObj.SetSumText(3, i,"");
			}
		}
		
		sheetObj.SetSumText(0, 0,"G.Total");
		sheetObj.SetCellAlign(0, 1,"Center");
		//SelectHighLight=false;
	//}
	ComBtnDisable("btn_Print");
}


 function t1sheet1_OnLoadFinish(sheetObj) {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	document.getElementById("froms").focus();
}
function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		var f=document.form.locationBy;
		if (f.value == "AR") {
			str_loc_nm="RCC";
		} else if (f.value == "AC" || f.value == "CC") {
			str_loc_nm="Country";
		} else if (f.value == "AP") {
			str_loc_nm="Port";
		} else if (f.value == "RL") {
			str_loc_nm="LCC";
		} else if (f.value == "LE" || f.value == "RE") {
			str_loc_nm="ECC";
		} else if (f.value == "LS" || f.value == "ES" || f.value == "SS") {
			str_loc_nm="SCC";
		}
		document.form.rpt_loc_cd.value=str_loc_nm;
		SetCellValue(0, 0,str_loc_nm,0);
/*
		for ( var x=0; x < sheetObj.LastRow(); x++) {
if (sheetObj.GetCellValue(x, 1) == "M/B(%)") {
				SetRowBackColor(x,"#C9D5EB");
			}
		}
*/
		var row=LastRow();
		SetSumText(0, "loc_cd","G.Total");
		SetSumText(1, "loc_cd","G.Total");
		SetSumText(2, "loc_cd","G.Total");
		SetSumText(3, "loc_cd","G.Total");
		SetSumText(0, "division","I/B");
		SetSumText(1, "division","O/B");
		SetSumText(2, "division","Balance");
		SetSumText(3, "division","M/B(%)");
		
		SetCellFontColor(LastRow()-3, 0, "#000000");
		SetCellFontColor(LastRow()-3, 1, "#000000");
		SetCellFontColor(LastRow()-2, 1, "#000000");
		SetCellFontColor(LastRow()-1, 1, "#000000");
		SetCellFontColor(LastRow(), 1, "#000000");
		SetRowBackColor(LastRow()-3, "#F7E1EC");
		SetRowBackColor(LastRow()-2, "#F7E1EC");
		SetRowBackColor(LastRow()-1, "#F7E1EC");
		SetRowBackColor(LastRow(), "#F7E1EC");
		
		var oldCntrTypeSize2 = sCntrTypeSize
		 if(oldCntrTypeSize2.length > 1){
			 oldCntrTypeSize2 = oldCntrTypeSize2.substring(1);
	      }
		var arrTime=oldCntrTypeSize2.split("|");
		for ( var i=2; i < arrTime.length + 4; i++) {
			SetCellFontColor(LastRow()- 1, i,"#000000");
			SetCellFontColor(LastRow(), i,"#000000");
			SetCellFontColor(LastRow()-3, i, "#000000");
			SetCellFontColor(LastRow()-2, i, "#000000");
			if (GetSumValue(0, i) >= GetSumValue(1, i)) {
				if (GetSumValue(0, i) > 0) {
				var tVal01=Math.round(GetSumValue(1, i) / GetSumValue(0, i) * 100);
				SetSumText(3, i,tVal01 + "%");
					if (tVal01 < 0) {
						SetCellFontColor(LastRow()- 1, i,"#DC0000");
						SetCellFontColor(LastRow(), i,"#DC0000");
					} else {
						SetCellFontColor(LastRow()- 1, i,"#000000");
						SetCellFontColor(LastRow(), i,"#000000");
					}
				} else {
					if (GetSumValue(2, i) < 0) {
						SetCellFontColor(LastRow()- 1, i,"#DC0000");
					} else {
						SetCellFontColor(LastRow()- 1, i,"#000000");
					}
					SetSumText(3, i,'0%');
				}
			} else if (GetSumValue(1, i) > 0) {
				var tVal02=Math.round((GetSumValue(0, i) / GetSumValue(1, i) * (-1)) * 100);
				if (GetSumValue(2, i) < 0) {
					SetCellFontColor(LastRow()- 1, i,"#DC0000");
				} else {
					SetCellFontColor(LastRow()- 1, i,"#000000");
				}
		SetSumText(3, i,tVal02 + "%");
				if (tVal02 < 0) {
					SetCellFontColor(LastRow()- 1, i,"#DC0000");
					SetCellFontColor(LastRow(), i,"#DC0000");
				} else {
					SetCellFontColor(LastRow()- 1, i,"#000000");
					SetCellFontColor(LastRow(), i,"#000000");
				}
			} else {
		SetSumText(3, i,'0%');
			}
		}
		for ( var i=3; i < arrTime.length + 4; i++) {
			if (GetCellValue(LastRow()- 4, i) == "") {
		SetSumText(0, i,"");
		SetSumText(1, i,"");
		SetSumText(2, i,"");
		SetSumText(3, i,"");
			}
		}
		document.form.rpt_period.value=document.form.period.value;
		document.form.rpt_fromdate.value=document.form.froms.value;
		document.form.rpt_todate.value=document.form.tos.value;
		document.form.rpt_locationby.value=document.getElementById('locationBy').options[document.getElementById('locationBy').options.selectedIndex].text;
		document.form.rpt_location.value=document.form.location.value;
		document.form.rpt_cargotype.value=document.getElementById('cargoType').options[document.getElementById('cargoType').options.selectedIndex].text;
		var check="";
		for ( var i=0; i < document.form.tpsz.length; i++) {
			if (document.form.tpsz[i].checked) {
				check=document.form.tpsz[i].value;
			}
		}
		document.form.rpt_tpsz.value=check;
		if (check == "R") {
			document.form.rpt_rdtype.value=document.getElementById('rdtype').options[document.getElementById('rdtype').options.selectedIndex].text;
		} else {
			document.form.rpt_rdtype.value="";
		}
		document.form.rpt_enroute.value=document.getElementById('enRoute').options[document.getElementById('enRoute').options.selectedIndex].text;
		document.form.rpt_soc.value=document.getElementById('soc').options[document.getElementById('soc').options.selectedIndex].text;
		SetCellAlign(LastRow()- 3, "loc_cd","CenterTop");
		SetCellAlign(LastRow()- 2, "loc_cd","CenterTop");
		SetCellAlign(LastRow()- 1, "loc_cd","CenterTop");
		SetCellAlign(LastRow(), "loc_cd","CenterTop");
		SetCellAlign(LastRow()- 3, "division","Center");
		SetCellAlign(LastRow()- 2, "division","Center");
		SetCellAlign(LastRow()- 1, "division","Center");
		SetCellAlign(LastRow(), "division","Center");
		if (LastRow()> 1)		SetMergeCell((sheetObj.LastRow()- 3), 0, 4, 1);
//no support[implemented common]CLT 		SelectHighLight=false;
//		sheetObj.SetRowHidden(sheetObj.LastRow(),1);
		
		for ( var x=0; x < sheetObj.LastRow(); x++) {
			if (sheetObj.GetCellValue(x, 1) == "M/B()") {
				sheetObj.SetCellText(x, 1, "M/B(%)");
			}
		}		
	}
	ComBtnEnable("btn_Print");
}
/*
function t3sheet1_OnChangeSum(sheetObj, Row) {
	with (sheetObj) {
		SetSumText(0, "loc_cd","G.Total");
		SetSumText(1, "loc_cd","G.Total");
		SetSumText(2, "loc_cd","G.Total");
		SetSumText(3, "loc_cd","G.Total");
		SetSumText(0, "vvd","G.Total");
		SetSumText(1, "vvd","G.Total");
		SetSumText(2, "vvd","G.Total");
		SetSumText(3, "vvd","G.Total");
		SetSumText(0, "division","I/B");
		SetSumText(1, "division","O/B");
		SetSumText(2, "division","Balance");
		SetSumText(3, "division","M/B(%)");
		SetCellAlign(0, "division","Center");
		SetCellAlign(1, "division","Center");
		SetCellAlign(2, "division","Center");
		SetCellAlign(2, "division","Center");
	}
}
*/
function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	//sheetObj.SetRowHidden(sheetObj.LastRow(),1);
	with (sheetObj) {
		if (RowCount()> 0) {
			SetSumText(0, "loc_cd","G.Total");
			SetSumText(1, "loc_cd","G.Total");
			SetSumText(2, "loc_cd","G.Total");
			SetSumText(3, "loc_cd","G.Total");
			SetSumText(0, "vvd","G.Total");
			SetSumText(1, "vvd","G.Total");
			SetSumText(2, "vvd","G.Total");
			SetSumText(3, "vvd","G.Total");
			SetSumText(0, "division","I/B");
			SetSumText(1, "division","O/B");
			SetSumText(2, "division","Balance");
			SetSumText(3, "division","M/B(%)");
			SetRowBackColor(LastRow()-3, "#F7E1EC");
			SetRowBackColor(LastRow()-2, "#F7E1EC");
			SetRowBackColor(LastRow()-1, "#F7E1EC");
			SetRowBackColor(LastRow(), "#F7E1EC");

	
			var headCnt=sheet3_header_title.split("|").length;
			for (i = 0; i < headCnt; i++) {
				if (i > 2) {
					SetSumValue(0, i, GetCellValue(LastRow()-7, i));
					SetSumValue(1, i, GetCellValue(LastRow()-6, i));
					SetSumValue(2, i, GetCellValue(LastRow()-5, i));
					SetSumValue(3, i, GetCellValue(LastRow()-4, i));
				}

				SetCellFontColor(LastRow()- 3, i,"#000000");
				SetCellFontColor(LastRow()- 2, i,"#000000");
				SetCellFontColor(LastRow()- 1, i,"#000000");
				SetCellFontColor(LastRow(), i,"#000000");
			}
	
			if (RowCount()> 0) {
				SetRowHidden(LastRow()-7, 1);
				SetRowHidden(LastRow()-6, 1);
				SetRowHidden(LastRow()-5, 1);
				SetRowHidden(LastRow()-4, 1);
			}
			//SetCellAlign(LastRow()- 3, "loc_cd","CenterTop");
			//SetCellAlign(LastRow()- 2, "loc_cd","CenterTop");
			//SetCellAlign(LastRow()- 1, "loc_cd","CenterTop");
			//SetCellAlign(LastRow(), "loc_cd","CenterTop");
			//SetCellAlign(LastRow()- 3, "vvd","CenterTop");
			//SetCellAlign(LastRow()- 2, "vvd","CenterTop");
			//SetCellAlign(LastRow()- 1, "vvd","CenterTop");
			//SetCellAlign(LastRow(), "vvd","CenterTop");
			//SetCellAlign(LastRow()- 3, "division","Center");
			//SetCellAlign(LastRow()- 2, "division","Center");
			//SetCellAlign(LastRow()- 1, "division","Center");
			//SetCellAlign(LastRow(), "division","Center");
			SetMergeCell((sheetObj.LastRow()- 3), 0, 4, 2);
			
			var prvText = "";
			var nowText = "";
			var prvIndex = "";
			var arrIndex = "";
			/*SetMergeCell(1, 0, 8, 1);
			SetMergeCell(9, 0, 12, 1);
			SetMergeCell(21, 0, 28, 1);
			SetMergeCell(49, 0, 12, 1);*/
			
			for (var i=1; i < sheetObj.LastRow()-4; i++) {
				prvIndex = i - 1;
				prvText = sheetObj.GetCellValue(prvIndex,0);
				nowText = sheetObj.GetCellValue(i,0);
				
				if(prvText == nowText) {
				}else{
					if(nowText != "") {
						arrIndex = arrIndex+i+",";
					}
				}
			}
			arrIndex = arrIndex+"0";
			
			var splitIndex = arrIndex.split(",");
			var RowCnt = 0;
			for(var k=0; k<splitIndex.length-1; k++){
				
				if(k != splitIndex.length) {
					RowCnt = splitIndex[k+1] - splitIndex[k];
					if(k == splitIndex.length-2) {
						RowCnt = sheetObj.LastRow() -4 - splitIndex[k];
					}
					
					SetMergeCell(parseInt(splitIndex[k]), 0, parseInt(RowCnt), 1);
				}
			}
			
			
			for ( var x=0; x < sheetObj.LastRow(); x++) {
				if (sheetObj.GetCellValue(x, 2) == "M/B()") {
					sheetObj.SetCellText(x, 2, "M/B(%)");
				}
			}
			
			
		}
	}
	ComBtnDisable("btn_Print");
}

function t1sheet1_OnClick(sheetObj, Row, Col, Value) {
//no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
}
function t2sheet1_OnClick(sheetObj, Row, Col, Value) {
//no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
}
function t3sheet1_OnClick(sheetObj, Row, Col, Value) {
//no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
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
/**
 * event when clicking Tab
 * activating selected tab items
 */
function tab1_OnClick(tabObj, nItem) {
	beforetab=nItem;
	tabIndex=nItem;
	if (isOpen) {
		if (nItem == 0) {
			isOpen=true;
			doActionIBSheet(t1sheet1, document.form, IBSEARCH);
		} else if (nItem == 1) {
			isOpen=true;
			doActionIBSheet2(t2sheet1, document.form, IBSEARCH);
		} else if (nItem == 2) {
			isOpen=true;
			doActionIBSheet3(t3sheet1, document.form, IBSEARCH);
		}
	}
}
