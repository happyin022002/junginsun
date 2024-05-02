/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1055.js
*@FileTitle  : Unmatch Description
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
//Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1;
/** 
  * registering IBSheet Object as list
  * adding process for list in case of needing batch processing with other items
  * defining list on the top of source
*/ 
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/** 
  * initializing sheet
  * implementing onLoad event handler in body tag
  * adding first-served functions after loading screen.
*/ 
function loadPage() {
    sheet1=sheetObjects[0];
    sheetCnt=sheetObjects.length;
    //initializing IBSheet 
    for(i=0;i<sheetCnt;i++){
        ComConfigSheet(sheetObjects[i]); //
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]); //
    }
    sheet1.SetWaitImageVisible(0);
    doActionIBSheet(sheet1, form, IBSEARCH);
}
/** 
*/
/*
//no support[check again]CLT function sheet1_OnLoadFinish(sheetObj) {
	var form=document.form;	
}
*/
/** 
  * setting sheet initial values and header
  * param : sheetObj, sheetNo
  * adding case as numbers of counting sheets
*/ 
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
		case "sheet1":
	      	with (sheet1) {
				var HeadTitle1="Error Kind|Description|Type";
				(ComCountHeadTitle(HeadTitle1), 0, 0, false);
	
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
	
				var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"umch_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:0,   SaveName:"umch_tp_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   Wrap:1 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rev_umch_clss_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   Wrap:1 } ];
				 
				InitColumns(cols);
				SetSheetHeight(210);
				SetWaitImageVisible(0);
				SetEditable(0);
				SetCountPosition(0);
	        }
	      	break;
	}
}
//Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
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
//handling process for Sheet 
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch(sAction) {
		case IBSEARCH: //retrieve
			ComOpenWait(true);
    		formObj.f_cmd.value=SEARCH;
 			sheet1.DoSearch("ESM_BKG_1055GS.do", FormQueryString(formObj) );
			break;
	}
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
	ComOpenWait(false);
}
