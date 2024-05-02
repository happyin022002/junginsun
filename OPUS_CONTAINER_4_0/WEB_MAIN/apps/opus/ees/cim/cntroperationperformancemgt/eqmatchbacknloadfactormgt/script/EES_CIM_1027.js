/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1027.js
*@FileTitle  : Location M/B by BKG-Wise
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
 * @class ees_cim_1027 : business script for ees_cim_1027
 */

/* developer job */
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
var tabFlag=0;
var comboObjects=new Array();
var comboCnt=0;
var isSearch=0;
var sPeriod=""
var IBSEARCH02=30;
var head_cntr_tpsz_cd="";
var doneLoadPageYN="N";
// controlling XTC date event
var enterSwitch=false;
var sheet3_header_title="";
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick() {
	var shtCnt=0;
/*	var t1sheet1=sheetObjects[shtCnt++];
	var t2sheet1=sheetObjects[shtCnt++];
	var t3sheet1=sheetObjects[shtCnt++];
*/	/*******************************************************/
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
			document.getElementById("location").className="input2";
			document.form.location.disabled=true;
			document.form.rdtype.disabled=true;
			document.getElementById("froms").focus();
			
			tabObjects[0].SetSelectedIndex(0);
			
			sheetObjects[0].SetCellText(0, "loc_cd", "RCC");
			sheetObjects[1].SetCellText(0, "loc_cd", "RCC");
			sheetObjects[2].SetCellText(0, "loc_cd", "RCC");
			break;
		case "btn_loc_cd": //retrieving Location 
			var cnt_cd="";
			var loc_cd="";
			cnt_cd=formObject.locationBy.value;
			loc_cd=formObject.location.value;
			if (formObject.locationBy.value != 'AR' && formObject.locationBy.value != 'AC' && formObject.locationBy.value != 'AP') {
				//	if (formObject.locationBy.value == 'CC') { //Country
				//		var param = "?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
				//		ComOpenPopup("/opuscntr/COM_ENS_0M1.do", 565, 630,
				//				"popupFinish", "1,0,1,1,1,1,1,1", true);
				//	} else {
				var loc_code="";
				if (formObject.locationBy.value == "RC") {
					loc_code="rcc_cd";
				} else if (formObject.locationBy.value == "RL") {
					loc_code="rcc_cd";
				} else if (formObject.locationBy.value == "RE") {
					loc_code="rcc_cd";
				} else if (formObject.locationBy.value == "RP") {
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
				//	}
			}
			break;
		case "btn_downExcel":
			if (tabIndex == 0) {
//				doActionIBSheet(t1sheet1, formObject, IBDOWNEXCEL);
				t1sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(t1sheet1), DownRows : "Visible", SheetDesign:1,Merge:1 });
			} else if (tabIndex == 1) {
//				t2sheet1.Down2Excel({ HiddenColumn:-1,Merge:true});
				t2sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(t2sheet1), DownRows : "Visible", SheetDesign:1,Merge:1 });
			} else if (tabIndex == 2) {
//				t3sheet1.Down2Excel({ HiddenColumn:-1,Merge:true});
				t3sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(t3sheet1), DownRows : "Visible", SheetDesign:1,Merge:1 });
			}
			break;
		case "btn_Print":
			if (sheetObjects[1].RowCount() == 0) {
				errMsg='No data found.';
				ComShowMessage(msgs["CIM29030"]);
				return;
			}
			
			formObject.f_cmd.value=IBSEARCH02;
			ComOpenPopupWithTarget('/opuscntr/EES_CIM_1927_POP.do', 775, 500, "", "0,1,1,1,1,1,1", true);
			/*var rdUrl="apps/opus/ees/cim/cntroperationperformancemgt/eqmatchbacknloadfactormgt/report/";
			var rdFile="EES_CIM_1927.mrd";
			
			var rdParam="/rv " + "rpt_tpsz[111]" +
			" rpt_fromdate[22]" +
			" rpt_todate[333]";
			
			
			formObject.com_mrdPath.value=rdUrl+rdFile;
			formObject.com_mrdArguments.value=rdParam + " /rwait";
			formObject.com_mrdBodyTitle.value="Location M/B by BKG-Wise";
			
			ComOpenRDPopup("dialogWidth:900px;dialogHeight:800px");*/
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
	//document.getElementById("location").className="input2";
	t1sheet1_OnLoadFinish(t1sheet1);
	for ( var i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	resizeSheet();
	axon_event.addListenerForm('click', 'obj_tpsz_click', document.form);
	//axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
	axon_event.addListenerForm('change', 'obj_change', document.form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', document.form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form); //- form OnBeforeDeactivate이벤트에 코드 처리
	//axon_event.addListenerFormat('keyup', 'form_keyup', document.form);
	//axon_event.addListener('keydown', 'ComKeyEnter2', 'form');
	axon_event.addListener('blur', 'obj_blur', 'location');
	axon_event.addListenerForm('blur', 'obj_deactivate', form);
	for (k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		tabObjects[k].SetSelectedIndex(0);
	}
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
	ComClearSeparator(event.srcElement);
	ComSetFocus(event.srcElement);
}
function obj_tpsz_click() {
	obj=event.srcElement;
	if (obj.name == "tpsz") { //by TP/SZ kind
		if (obj.value != "R") {
			document.form.rdtype.disabled=true;
		} else {
			document.form.rdtype.disabled=false;
		}
	}
}
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
function obj_blur() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
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
			sCntrTypeSize=document.form.temp_tpsz_val.value;
			oldCntrTypeSize=document.form.temp_tpsz_val.value;
			var arrTpSz=oldCntrTypeSize.split(",");
			if (HeadTitle == null || HeadTitle == "") {
					HeadTitle="RCC|Total";
					for ( var i=0; i < arrTpSz.length; i++) {
						HeadTitle += "|" + arrTpSz[i];
					}
			}

	      SetConfig( { SearchMode:2, FrozenCol:2, MergeSheet:7, Page:20, DataRowMerge:0,PrevColumnMergeMode:0 } );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
	                   {Type:"Text",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 } ];
	            	for ( var i=0; i < arrTpSz.length; i++) {
	            		arEtcData="_" + i;
	            		cols.push({Type:"Text",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"qty"+arEtcData, KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
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
       
	      var cols = [];
	      var colsList = [];
	      sCntrTypeSize=document.form.temp_tpsz_val.value;
	      oldCntrTypeSize2=sCntrTypeSize;
	      var arrTpSz=oldCntrTypeSize2.split(",");
	      if (HeadTitle == null || HeadTitle == "") {
	    	  HeadTitle="RCC|Division|Total";
	    	  for ( var i=0; i < arrTpSz.length; i++) {
	    		  HeadTitle += "|" + arrTpSz[i];
	    	  }
	    	  var headCount=ComCountHeadTitle(HeadTitle);
	      }
	      
	      var headCnt=HeadTitle.split("|").length;
	      SetConfig( { SearchMode:0, FrozenCol:3, MergeSheet:1, Page:20, DataRowMerge:0,PrevColumnMergeMode:0 } );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);
	      for ( var RowCnt=0; RowCnt < 4; RowCnt++) {
	    	  cols = [];
	    	  if (RowCnt == 3) {
			      cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
			               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"division",      KeyField:0,   CalcLogic:"",   Format:"" },
			               {Type:"Text",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",         KeyField:0,   CalcLogic:"",   Format:"" } ];
		            	for ( var i=0; i < arrTpSz.length; i++) {
		            		arEtcData="_" + i;
		            		cols.push({Type:"Text",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"qty"+arEtcData, KeyField:0,   CalcLogic:"",   Format:"" });
		            	}
	    	  } else {
	    		  cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" });
	    		  cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"division",      KeyField:0,   CalcLogic:"",   Format:"" });
	    		  cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",         KeyField:0,   CalcLogic:"",   Format:"" });
	    		  for ( var i=0; i < arrTpSz.length; i++) {
	    			  arEtcData="_" + i;
	    			  cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"qty"+arEtcData, KeyField:0,   CalcLogic:"",   Format:"" });
	    		  }
	    	  }
	    	  colsList.push(cols);
	      }
	      InitColumns(colsList,4);
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
function resizeSheet(){
    for (i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i]);
    }
}
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH:
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			var sXml=sheetObj.GetSearchData("EES_CIM_1027GS.do", FormQueryString(formObj));
//			sheetObj.LoadSearchData(sXml,{Sync:1} );
			sheetObj.LoadSearchData(sXml,{Sync:0} );
			sheetObj.SetWaitImageVisible(1);
			ComOpenWait(false);
		}
		break;
	case IBSEARCH_ASYNC01:
		formObj.f_cmd.value=SEARCH01;
		var sXml="";
		if (sheetObj.id == "t1sheet1") {
			sXml=formObj.sXml.value;
		}
		sCntrTypeSize=ComGetEtcData(sXml, "cntrTypeSize");
		document.form.temp_tpsz_val.value=sCntrTypeSize;
		//getting changing column information from server
		oldCntrTypeSize=sCntrTypeSize;
		sheetObjects[0] = sheetObjects[0].Reset();
		initSheet(sheetObjects[0], 0, "");
		sheetObjects[1] = sheetObjects[1].Reset();
		initSheet(sheetObjects[1], 1, "");
		break;
	case IBSEARCH_ASYNC03: 
		formObj.f_cmd.value=SEARCH01;
		var sXml="";
		sXml=sheetObjects[3].GetSearchData("EES_CIM_1001GS.do", FormQueryString(formObj));
		sCntrTypeSize=ComGetEtcData(sXml, "cntrTypeSize");
		oldCntrTypeSize=sCntrTypeSize;
		oldCntrTypeSize2=sCntrTypeSize;
		formObj.temp_tpsz_val.value=sCntrTypeSize;
		break;
	case IBSEARCH_ASYNC02: //location focusOut
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
					ComShowCodeMessage("CIM29036");
					document.form.location.value="";
					sheetObj.SetWaitImageVisible(1);
					ComSetFocus(document.form.location);
					return false;
				} else if (xLocationBy == "P") {
					ComShowCodeMessage("CIM29035");
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
		document.form.tpsz[0].focus();
		break;
	case IBDOWNEXCEL: 
	sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
		break;
	} // end switch
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
			var sXml=sheetObj.GetSearchData("EES_CIM_10272GS.do", FormQueryString(formObj));
			//sXml = sXml.replace(/%/gi,"");
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
			if (sheetObj.id == "t2sheet1") {
				sXml=formObj.sXml.value;
			}
			sCntrTypeSize=ComGetEtcData(sXml, "cntrTypeSize");
			document.form.temp_tpsz_val.value=sCntrTypeSize;
			if ((oldCntrTypeSize2 != sCntrTypeSize) && (sheetObj.id == "t2sheet1")) {
				oldCntrTypeSize2=sCntrTypeSize;
				//sheetObj = sheetObj.Reset();
				//initSheet(sheetObj);
				sheetObjects[1] = sheetObj.Reset();
				initSheet(sheetObjects[1]);
			}
			if (sheetObj.id == "t2sheet1")
//				sheetObj.LoadSearchData(sXml,{Sync:1} );
				sheetObj.LoadSearchData(sXml,{Sync:0} );
		}
		break;
		case IBDOWNEXCEL:
			sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
		break;
	} // end switch
} // end function
// handling process for Sheet
function doActionIBSheet3(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: 
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH02;
			var sXml=sheetObj.GetSearchData("EES_CIM_10273GS.do", FormQueryString(formObj));
			sXml = sXml.replace(/%/gi,"");
			sPeriod=ComGetEtcData(sXml, "head");
			//getting changing column information from server
			var str_loc_nm="";
			var f=document.form.locationBy;
			if (f.value == "AR") {
				str_loc_nm="RCC";
			} else if (f.value == "AC") {
				str_loc_nm="Country";
			} else if (f.value == "AP") {
				str_loc_nm="Port";
			} else if (f.value == "RL") {
				str_loc_nm="LCC";
			} else if (f.value == "RC") {
				str_loc_nm="Country";
			} else if (f.value == "RP") {
				str_loc_nm="Port";
			} else if (f.value == "LE" || f.value == "RE") {
				str_loc_nm="ECC";
			} else if (f.value == "LS" || f.value == "ES" || f.value == "SS") {
				str_loc_nm="SCC";
			}
			var HeadTitle="|TP/SZ|Division|Total";
			if (sPeriod == '' || sPeriod == undefined) {
			//if (ComIsNull(sPeriod)) {
				HeadTitle=str_loc_nm + HeadTitle;
			} else {
				HeadTitle=str_loc_nm + HeadTitle + "|" + sPeriod;
			}
			sheet3_header_title = HeadTitle;
			//t3sheet1.Reset();
			//initSheet(t3sheet1, 2, HeadTitle);
			sheetObjects[2] = t3sheet1.Reset();
			initSheet(sheetObjects[2] , 2, HeadTitle);
//			t3sheet1.LoadSearchData(sXml,{Sync:1} );
			t3sheet1.LoadSearchData(sXml,{Sync:0} );
			t3sheet1.SetWaitImageVisible(1);
			ComOpenWait(false);
		}
		break;
	} // end switch
} // end function
function obj_blur() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
}
function form_keyup() {
	var obj=null;
	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	if (keyValue != 13) {
		ComKeyEnter2('lengthnextfocus');
	} else {
		obj_deactivate();
	}
}
function ComKeyEnter2(sFlag) {
	try {
		var keyValue=null;
		if (event == undefined || event == null) {
			keyValue=13;
		} else
			keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		if (sFlag == undefined || sFlag == null || sFlag.constructor != String || sFlag.trim() == "")
			sFlag="search";
		switch (sFlag.toLowerCase()) {
		case "search":
			//retrieving in case of Enter key
			if (keyValue != 13)
				return;
			var obj=document.getElementById("btn_Retrieve");
			if (obj == null)
				obj=document.getElementById("btn_retrieve");
			if (obj)
				obj.fireEvent("onclick");
			break;
		case "nextfocus":
			//handling like Tab key in case of Enter key
			if (keyValue == 13)
				event.keyCode=9;
			break;
		case "lengthnextfocus":
			// moving cursor to next after inputing max length
			// handling like Tab key in case of Enter key
			var iMaxLen=event.srcElement.getAttribute("maxLength");
			var sValue=event.srcElement.getAttribute("value");
			var bFocusProcess=false;
			//in case of inputting Enter key
			if (keyValue == 13) {
				if (event.srcElement.classid != CLSID_IBSHEET) {
					bFocusProcess=true;
				}
				//no handling in case of no existing iMaxLen property or value
				} else if (iMaxLen != null && sValue != null) {
				//ComDebug(iMaxLen+"=="+sValue.lengthByte());
				if (iMaxLen == sValue.lengthByte()) {
					//if(!((keyValue==37)||(keyValue==39)||(keyValue==46)||(keyValue==8)||(keyValue==9))){
					//reference :http://cdmanii.tistory.com/153
					if (!((keyValue >= 8 && keyValue <= 40) || //BackSpace~아래방향키키
							(keyValue >= 45 && keyValue <= 46) || //Insert,Delete키
							(keyValue >= 91 && keyValue <= 93) || //기능키
							(keyValue >= 112 && keyValue <= 123) || //F1~F12키
					(keyValue >= 144 && keyValue <= 145))) {//NumLock,ScrollLock
						bFocusProcess=true;
					}
				}
			}
			if (bFocusProcess)
				ComSetNextFocus();
		default:
			//calling java script function named sFlg when inputting Enter key
			if (keyValue == 13 && ComFuncCheck(sFlag))
				ComFunc();
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}
//function for handling Axon event
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
function obj_change() {
	obj=event.srcElement;
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
		document.getElementById("froms").focus();
	} else if (obj.name == "locationBy") {
		if (obj.value == "AR" || obj.value == "AC" || obj.value == "AP") {
			document.getElementById("location").disabled=true;
			document.getElementById("location").value="";
			document.getElementById("location").className="input2";
		} else {
			document.getElementById("location").disabled=false;
		//	document.getElementById("location").value = "";
			document.getElementById("location").className="input";
			document.getElementById("location").focus();
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
			InsertItem( "M/Back(%) ", "");
			InsertItem( "M/B Detail", "");
			InsertItem( "M/B Trend ", "");
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
					ComShowCodeMessage("CIM21001", "Period ");
					ComSetFocus(froms);
					return false;
				} else if (tos.value == "") {
					ComShowCodeMessage("CIM21001", "Period ");
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
				if (locationBy.value == 'LE' || locationBy.value == 'LS' || locationBy.value == 'ES' || locationBy.value == 'SS' || locationBy.value == 'RL'
						|| locationBy.value == 'RC' || locationBy.value == 'RP' || locationBy.value == 'RE') {
					ComShowCodeMessage("CIM21001", "Location by");
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
function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		var str_loc_nm="";
		var f=document.form.locationBy;
		if (f.value == "AR") {
			str_loc_nm="RCC";
		} else if (f.value == "AC") {
			str_loc_nm="Country";
		} else if (f.value == "AP") {
			str_loc_nm="Port";
		} else if (f.value == "RL") {
			str_loc_nm="LCC";
		} else if (f.value == "RC") {
			str_loc_nm="Country";
		} else if (f.value == "RP") {
			str_loc_nm="Port";
		} else if (f.value == "LE" || f.value == "RE") {
			str_loc_nm="ECC";
		} else if (f.value == "LS" || f.value == "ES" || f.value == "SS") {
			str_loc_nm="SCC";
		}
		SetCellValue(0, 0,str_loc_nm,0);
		SetRowBackColor(LastRow(), "#F7E1EC");
		var arrTime=sCntrTypeSize.split(",");
		SetCellFontColor(LastRow(), 0,"#000000");
		for ( var i=1; i < arrTime.length + 2; i++) {
			SetCellFontColor(LastRow(), i,"#000000");
			if (ComIsNull(GetCellValue(RowCount(), i))) {
				SetSumText(0, i,"");
			} else if (GetCellValue(RowCount(), i) == 0.0) {
				SetSumText(0, i,0);
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
		SetCellAlign(0, 1,"Center");
	}
	ComBtnDisable("btn_Print");
}
function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {

	//sheetObj.SetRowHidden(sheetObj.LastRow(),1);
	with (sheetObj) {
		var str_loc_nm="";
		var f=document.form.locationBy;
		if (f.value == "AR") {
			str_loc_nm="RCC";
		} else if (f.value == "AC") {
			str_loc_nm="Country";
		} else if (f.value == "AP") {
			str_loc_nm="Port";
		} else if (f.value == "RL") {
			str_loc_nm="LCC";
		} else if (f.value == "RC") {
			str_loc_nm="Country";
		} else if (f.value == "RP") {
			str_loc_nm="Port";
		} else if (f.value == "LE" || f.value == "RE") {
			str_loc_nm="ECC";
		} else if (f.value == "LS" || f.value == "ES" || f.value == "SS") {
			str_loc_nm="SCC";
		}
		
		SetCellValue(0, 0,str_loc_nm,0);
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
/*
		for ( var x=0; x < sheetObj.LastRow(); x++) {
if (sheetObj.GetCellValue(x, 1) == "M/B(%)") {
				SetRowBackColor(x,"#C9D5EB");
			}
		}
*/
		var arrTime=sCntrTypeSize.split(",");
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
		}
		for ( var i=3; i < arrTime.length + 4; i++) {
			if (GetCellValue(LastRow()- 4, i) == "") {
//		SetSumText(0, i,"");
//		SetSumText(1, i,"");
//		SetSumText(2, i,"");
//		SetSumText(3, i,"");
			}
		}
		document.form.rpt_period.value=document.form.period.value;
		document.form.rpt_fromdate.value=document.form.froms.value;
		document.form.rpt_todate.value=document.form.tos.value;
		document.form.rpt_locationby.value=document.getElementById('locationBy').options[document.getElementById('locationBy').options.selectedIndex].text;
		document.form.rpt_location.value=document.form.location.value;
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
		document.form.rpt_soc.value=document.getElementById('soc').options[document.getElementById('soc').options.selectedIndex].text;
		SetCellAlign(LastRow()- 3, "loc_cd","CenterTop");
		SetCellAlign(LastRow()- 2, "loc_cd","CenterTop");
		SetCellAlign(LastRow()- 1, "loc_cd","CenterTop");
		SetCellAlign(LastRow(), "loc_cd","CenterTop");
		SetCellAlign(LastRow()- 3, "division","Center");
		SetCellAlign(LastRow()- 2, "division","Center");
		SetCellAlign(LastRow()- 1, "division","Center");
		SetCellAlign(LastRow(), "division","Center");
		SetMergeCell((LastRow()- 3), 0, 4, 1);
		
		for ( var x=0; x < sheetObj.LastRow(); x++) {
			if (sheetObj.GetCellValue(x, 1) == "M/B()") {
				sheetObj.SetCellText(x, 1, "M/B(%)");
			}
		}
		
	}
	ComBtnEnable("btn_Print");
}
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
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			sheetObjects[0].SetSelectRow(0);
		} else if (nItem == 1) {
			isOpen=true;
			doActionIBSheet2(sheetObjects[1], document.form, IBSEARCH);
			sheetObjects[1].SetSelectRow(0);
		} else if (nItem == 2) {
			isOpen=true;
			doActionIBSheet3(t3sheet1, document.form, IBSEARCH);
			t3sheet1.SetSelectRow(0);
		}
	}
}
	 function t1sheet1_OnLoadFinish(sheetObj) {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	document.getElementById("froms").focus();
}
