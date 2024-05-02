/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1049.js
*@FileTitle  : Error Details
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
//Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1;
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/** 
* implementing onLoad event handler in body tag <br>
* adding first-served functions after loading screen.. <br> 
*/ 
function loadPage() {
    sheet1=sheetObjects[0];
    sheetCnt=sheetObjects.length;
    for(i=0;i<sheetCnt;i++){
        ComConfigSheet(sheetObjects[i]); 
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]); 
    }
    sheet1.SetWaitImageVisible(0);
    doActionIBSheet(sheet1, form, IBSEARCH);
}
/** 
* initializing sheet <br>
* adding first-served functions after loading screen.. <br>
* adding case as numbers of counting sheets <br> 
*/ 
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
		case "sheet1":
	      	with (sheet1) {
	        var HeadTitle1="Error\nKind|Description|Booking|Contract|mtch_umch_tp_cd|mtch_umch_tp_desc";
	        (ComCountHeadTitle(HeadTitle1), 0, 0, false);
	        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	        var cols = [ {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"umch_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   Wrap:1 },
	               {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"umch_tp_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   Wrap:1 },
	               {Type:"Text",      Hidden:0,  Width:385,  Align:"Left",    ColMerge:0,   SaveName:"bkg_itm_log",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   Wrap:1, MultiLineText:1 },
	               {Type:"Text",      Hidden:0,  Width:385,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_itm_log",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   Wrap:1, MultiLineText:1 },
	               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mtch_umch_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   Wrap:1 },
	               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mtch_umch_tp_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   Wrap:1 } ];
	        InitColumns(cols);
	        SetEditable(0);
	        SetEllipsis(1);
	        SetSheetHeight(530);
	        }
	      	break;
	}
}
document.onclick=processButtonClick;
/** 
* Event handler processing by button name <br>
*/ 
function processButtonClick(){
	var form=document.form;
    try {
	    var srcName=ComGetEvent("name");
	    switch(srcName) {
	    	case "btn_retrieve":
	    		doActionIBSheet(sheet1, form, IBSEARCH);
	    		break;
	    	case "btn_close":
	    		ComClosePopup(); 
	    		break;
	    } //end switch
    }catch(e) {
    	if( e == "[object Error]") {
    		ComShowMessage(OBJECT_ERROR);
 		} else {
 			ComShowMessage(e.message);
 		}
 	}
}
//Axson Event Handler
//UI Object Event Handler
/** 
* OnSearchEnd Event <br>
*/ 
function sheet1_OnSearchEnd(sheetObj, code, errMsg) {
	ComOpenWait(false);
	var form=document.form;
	//sheet1.FitSize(true, false);
	sheet1.SetSheetFontName("Arial");
	sheet1.SetColFontColor("bkg_itm_log","#FF0000");
	if (errMsg == "") {
    	if(sheet1.RowCount()> 0) {
    		var cellFont="Courier New";
    		var cellFontSize=12;
    	    var startRow=sheet1.HeaderRows();
    		var endRow=sheet1.HeaderRows()+ sheet1.RowCount();
    		var tmpStr="";
    		for(var i=startRow; i < endRow; i++) {
    			sheet1.SetRowHeight(i,0);
    			tmpStr="";
    			tmpStr=sheet1.GetCellValue(i, "bkg_itm_log") + "\n";
    			sheet1.SetCellValue(i, "bkg_itm_log",tmpStr);
    			tmpStr="";
    			tmpStr=sheet1.GetCellValue(i, "ctrt_itm_log") + "\n";
    			sheet1.SetCellValue(i, "ctrt_itm_log",tmpStr);
				sheet1.SetCellFont("FontName", i, "bkg_itm_log", i, "bkg_itm_log", cellFont);
				sheet1.SetCellFont("FontName", i, "ctrt_itm_log", i, "ctrt_itm_log", cellFont);
				sheet1.SetCellFont("FontSize", i, "bkg_itm_log", i, "bkg_itm_log", cellFontSize);
				sheet1.SetCellFont("FontSize", i, "ctrt_itm_log", i, "ctrt_itm_log", cellFontSize);
    		}
    	}
    }
}   
/** 
* Mouse Click Event <br>
*/ 
function sheet1_OnClick(sheetObj, Row, Col, Value) {
	//Showing the MemoPad if click the desc cell
	var colName=sheet1.ColSaveName(Col);
	switch (colName) {
	case "bkg_itm_log":
	case "ctrt_itm_log":
		//ComShowMemoPad(sheet1,null,null,null,200,180,500);
		break;
	}
}
/**
* Setting the ToolTip for desccription, Booking, Contract<br>
*/
function setToolTip (sheetObj) {
	var startRow=sheet1.HeaderRows();
	var endRow=sheet1.HeaderRows()+ sheet1.RowCount();
	for (var i=startRow; i < endRow; i++) {
		sheet1.SetToolTipText(i,"umch_tp_nm",sheet1.GetCellValue(i,"umch_tp_nm"));
		sheet1.SetToolTipText(i,"bkg_itm_log",sheet1.GetCellValue(i,"bkg_itm_log"));
		sheet1.SetToolTipText(i,"ctrt_itm_log",sheet1.GetCellValue(i,"ctrt_itm_log"));
	}
}
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch(sAction) {
		case IBSEARCH: //retrieve
			ComOpenWait(true);
			sheet1.SetWaitImageVisible(0);
    		formObj.f_cmd.value=SEARCH;
    		var sXml=sheet1.GetSearchData("ESM_BKG_1049GS.do", FormQueryString(formObj));
			if(ComGetEtcData(sXml, "auditResultNm") != undefined){
				formObj.audit_result.value=ComGetEtcData(sXml, "auditResultNm");
			}
			sheet1.LoadSearchData(sXml,{Sync:1} );
 			//setToolTip(sheetObj, formObj, sAction);
			break;
	}
}