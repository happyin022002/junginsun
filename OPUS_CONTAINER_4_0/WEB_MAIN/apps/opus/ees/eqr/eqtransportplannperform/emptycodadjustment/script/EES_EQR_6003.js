/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_6003.jsp
*@FileTitle  : MTY Discharge Plan by VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
// common static variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_downExcel":
			if(sheetObj.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				sheetObject.Down2Excel({ HiddenColumn:-1});
				}
				
			break;
		case "btn_close":
				ComClosePopup(); 
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("EQR90004");
		} else {
			alert(e);
		}
	}
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items  
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag 
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for (k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
 * setting sheet initial values and header param : sheetObj ==> sheet object, sheetNo ==> sheet number
 *  adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: // t1sheet1 init
	    with(sheetObj){		      
		      //if (location.hostname != "")		     
		      var HeadTitle="Yard|Lane|VVD|ETB|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5|";
		
		      SetConfig( { SearchMode:2,  Page:20 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"yardcode",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lane",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"etb",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:true,UpdateEdit:1 },
		             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"d2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"d4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"d5",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"d7",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"r2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"r5",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"o2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"s2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"o4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"s4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"f2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"a2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"f4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"a4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"f5",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
		             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"weekdivision",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
		             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"pod",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 } ];
		       
		      InitColumns(cols);
		
		      SetEditable(0);
		      //SetGetColHidden(19,1);
		      //SetGetColHidden(20,1);
		      SetSheetHeight(460);
      		}
		break;
	}
}
// handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // retrieve
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
//		var sXml=ComMakeSearchXml(window.opener.portTotal, false, "hiddencheck",
		var sXml=ComMakeSearchXml(window.parent.portTotal, false, "hiddencheck",
				"yardcode|lane|vvd|etb|d2|d4|d5|d7|r2|r5|o2|o4|s4|f2|a2|f4|a4|f5|weekdivision|pod");
		for ( var i=1; i < window.parent.portTotal.RowCount()+ 1; i++) {
			if (window.parent.portTotal.GetCellValue(i, 29) == "1") {
				window.parent.portTotal.SetCellValue(i, 29,"0",0);
			}
		}
		sheetObj.LoadSearchData(sXml,{Append:1 , Sync:1} );
		sheetObj.SetWaitImageVisible(1);
		ComOpenWait(false);
		break;
	}
}
/**
 * handling double click event on sheet<br>
 * 
 * @param {sheetObj}
 *            String : sheet object
 * @param {Row}
 *            Long : Row Index
 * @param {Col}
 *            Long : Column Index
 * @param {Value}
 *            String : modified value
 * @param {CellX}
 *            Long : X
 * @param {CellY}
 *            Long : Y
 * @param {CellW}
 *            Long : cell width
 * @param {CellH}
 *            Long : cell height
 */
function sheet1_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		  	var opener=window.dialogArguments;
	        if (!opener) opener=parent;
			if (GetCellValue(Row, 19) == "1") {
						top.opener.scroll(0, 0);
			} else if (GetCellValue(Row, 19) == "2") {
						top.opener.scroll(0, 0);
			} else if (GetCellValue(Row, 19) == "3") {
						top.opener.scroll(324, 0);
			} else if (GetCellValue(Row, 19) == "4") {
						top.opener.scroll(900, 0);
			} else if (GetCellValue(Row, 19) == "5") {
						top.opener.scroll(900, 0);
		}
	}
var sheet=eval("top.opener.form.sheet" + sheetObj.GetCellValue(Row, 19));
if(sheet.GetCellValue(podRow,4) == ""){
		podRow=sheet.FindText(3, sheetObj.GetCellValue(Row, 20), podRow+1);
	}
	top.opener.hideCursorBar();
	sheet.focus();
	sheet.SelectCell(podRow, 1, false);
  ComClosePopup(); 
}
/**
 * registering IBTab Object as list adding process for list in case of needing batch processing with other items  
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++]=tab_obj;
}
/**
 * sheet1_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColumnSort("etb");
		SetMergeCell(sheetObj.RowCount()+ 1, 0, 1, 3);
		// CellAlign(0,0) = daCenter;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
	}
	return true;
}
