/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0105.js
*@FileTitle  : Notified Subscriber - Search Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 var sheetObjects=new Array();
var sheetCnt=0;
var selRow=0;
var selCol=0;
var selOfc="";
var sheet_height = 10;
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
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
}
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
function processButtonClick(){
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
        switch(srcName) {
    	    case "btn_retrieve":
    	    	if( formObject.cust_cnt_seq.value == "" ) {
					ComShowMessage("Check Customer Code") ;
	    	    	return false ;
    	    	}
	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	        break;
    	    case "btn_new":
	            sheetObject.RemoveAll();
	            formObject.reset();
    	        break;
            case "btn_close":
            	ComClosePopup(); 
    	        break;
			case "btn_ok":
				var chkCnt=sheetObj.CheckedRows(0) ;
				if( chkCnt==0 ) {
					return false ;
				}
				var chkRows=sheetObj.FindCheckedRow(0) ;
				var arrChkRows=chkRows.split("|") ;
				var opener=window.dialogArguments;
				opener.getSCNO( sheetObj.GetCellValue(arrChkRows[0], "scno"));
				ComClosePopup(); 
			    break;
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //IBSheet1 init
            with (sheetObj) {
	            var HeadTitle="|Customer Code|Customer Name|S/C No.|S.Office" ;
	
	            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
	
	            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	            var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"check",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:116,  Align:"Center",  ColMerge:0,   SaveName:"customercode",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:116,  Align:"Center",  ColMerge:0,   SaveName:"customername",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                   {Type:"Date",      Hidden:0,  Width:116,  Align:"Center",  ColMerge:0,   SaveName:"scno",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                   {Type:"Date",      Hidden:0,  Width:116,  Align:"Center",  ColMerge:0,   SaveName:"soffice",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	             
	            InitColumns(cols);
	
	            SetEditable(1);
//	            SetSheetHeight(ComGetSheetHeight(sheetObj,sheet_height));
	            resizeSheet();
           }
            break;
    }
}
//sheetObj.CellValue(sheetObj.SelectRow, "usr_nm")
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
       case IBSEARCH:      
//                if(!validateForm(sheetObj,formObj,sAction)) {
//                    return false;
//                }
            formObj.f_cmd.value=SEARCH05;
            selectVal=SceFrmQryString(formObj);
            sheetObj.DoSearch("ESD_SCE_0105GS.do", selectVal );
       break;
    }
} 
function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
	var formObj=document.form ;
	//if (sheetObj.RowCount >= OnePageRow && sheetObj.TotalRows > sheetObj.RowCount){    
	if (sheetObj.GetTotalRows()> sheetObj.RowCount()){
		formObj.f_cmd.value=SEARCH05 ;
		PageNo=Math.ceil(sheetObj.SearchRows()/1000)+1;
		formObj.cur_page.value=PageNo;
		//alert("pageNo:"+PageNo);
		selectVal=SceFrmQryString(formObj);
		sheetObj.DoSearch("ESD_SCE_0105GS.do", selectVal+"&"+ "cur_page=" + PageNo,{Append:true} );
    }	    
}
function resizeSheet(){ // auto-sizing
    ComResizeSheet(sheetObjects[0]);
} 