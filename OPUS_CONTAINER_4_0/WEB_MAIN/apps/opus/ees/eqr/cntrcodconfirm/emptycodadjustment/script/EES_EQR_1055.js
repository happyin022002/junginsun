/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_EQR_1055.js
 *@FileTitle : MTY Discharge Plan by VVD
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.14
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/

var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_downExcel":
			sheetObject.Down2Excel({ HiddenColumn:-1});
			break;
		case "btn_close":
  ComClosePopup(); 
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			alert(e);
		} else {
			alert(e);
		}
	}
}
/**
 * IBSheet Object
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Sheet body onLoad 
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
 * Setting sheet default value 
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: // t1sheet1 init
	    with(sheetObj){
        
      var HeadTitle="Yard|Lane|VVD|ETB|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|";

      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:1 } );

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
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"r9",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"o2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"s2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"o4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"s4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"o5",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"f2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"a2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"f4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"a4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"f5",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"weekdivision",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"pod",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 } ];
       
      InitColumns(cols);

      SetEditable(0);
            SetColHidden(21,1);
      SetColHidden(22,1);
      SetSheetHeight(460);
      }


		break;
	}
}
// Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: 
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		var sXml=ComMakeSearchXml(top.opener.form.portTotal, false, "hiddencheck",
				"yardcode|lane|vvd|etb|d2|d4|d5|d7|r2|r5|r9|o2|s3|o4|s4|o5|f2|a2|f4|a4|f5|weekdivision|pod");
		for ( var i=1; i < top.opener.form.portTotal.RowCount()+ 1; i++) {
			if (top.opener.form.portTotal.GetCellValue(i, 31) == "1") {
				top.opener.form.portTotal.SetCellValue(i, 31,"0",0);
			}
		}
		sheetObj.LoadSearchData(sXml,{Append:1 , Sync:1} );
		sheetObj.SetWaitImageVisible(1);
		
		break;
	}
}


function sheet1_OnSearchEnd(sheetObj,code,msg) {
	ComOpenWait(false);
}
/**
 * IBSeet Event - cell double click <br>
 * 
 * @param {sheetObj} String 
 * @param {Row} Long : Row Index
 * @param {Col} Long : Column Index
 * @param {Value} String : changed value
 * @param {CellX} Long : X
 * @param {CellY} Long : Y
 * @param {CellW} Long : wide
 * @param {CellH} Long : height
 */
function sheet1_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
if (GetCellValue(Row, 21) == "1") {
			top.opener.scroll(0, 0);
} else if (GetCellValue(Row, 21) == "2") {
			top.opener.scroll(0, 0);
} else if (GetCellValue(Row, 21) == "3") {
			top.opener.scroll(324, 0);
} else if (GetCellValue(Row, 21) == "4") {
			top.opener.scroll(900, 0);
} else if (GetCellValue(Row, 21) == "5") {
			top.opener.scroll(900, 0);
		}
	}
var sheet=eval("top.opener.form.sheet" + sheetObj.GetCellValue(Row, 21));
	var Rows=sheet.FindText(2, sheetObj.CellValue(Row, 2));
	var podRow=sheet.FindText(3, sheetObj.CellValue(Row, 22), Rows);
if(sheet.GetCellValue(podRow,4) == ""){
podRow=sheet.FindText(3, sheetObj.GetCellValue(Row, 22), podRow+1);
	}
	top.opener.hideCursorBar();
	sheet.focus();
	sheet.SelectCell(podRow, 1, false);
}
/**
 * IBTab Object
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
 * validate form
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
	}
	return true;
}
