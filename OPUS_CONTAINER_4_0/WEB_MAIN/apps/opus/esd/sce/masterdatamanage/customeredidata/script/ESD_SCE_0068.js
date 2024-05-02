﻿// Common global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var selectVal;
var sheetObjects=new Array();
var sheetCnt=0;
var selRow=0;
var isFirst1=0;
var isFirst2=0;
var rowCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
    function processButtonClick(){
        var formObject=document.form;
        var sheetObject0=sheetObjects[0];
        var srcName=ComGetEvent("name");
        var opener=window.dialogArguments;
        if (!opener) opener=parent;
        switch(srcName) {
            case "btn_ok":
                var chkcnt=sheetObject0.CheckedRows(0);
                if(chkcnt < 1){
                    ComShowMessage('Select check item');
    	    		return false;
                }
                var chkrow=sheetObject0.FindCheckedRow(0).split('|')[0];
                var cs_grp_id=sheetObject0.GetCellValue(chkrow, "edi_grp_cd");
                var tp_id=sheetObject0.GetCellValue(chkrow, "cust_trd_prnr_id");
                var grp_nm=sheetObject0.GetCellValue(chkrow, "edi_grp_desc");
    	    	opener.openESD068Screen(cs_grp_id, tp_id, grp_nm);
    	    	ComClosePopup(); 
                break;
            case "btn_close":
            	ComClosePopup(); 
                break;
        }
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    function loadPage(){
       for(i=0;i<sheetObjects.length;i++){
           ComConfigSheet (sheetObjects[i] );
           initSheet(sheetObjects[i]);
            ComEndConfigSheet(sheetObjects[i]);
       }
       var formObject=document.form;
       var sheetObject0=sheetObjects[0];
       doActionIBSheet0(sheetObject0,formObject,IBSEARCH);
    }
/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj) {
        var cnt=0;
        with(sheetObj){
//            (4, 0, 0, false);
		          var HeadTitle="|GroupId|EDI ID|Customer Name";
		
		          SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
		
		          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"edi_grp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cust_trd_prnr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"edi_grp_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 } ];
		           
		          InitColumns(cols);
		          SetEditable(1);
//		          SetSheetHeight(300);
		          resizeSheet();
                }
      // setTempInit(); 
    }
    function doActionIBSheet0(sheetObj,formObj,sAction){
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
             case IBSEARCH:
                    formObj.f_cmd.value=SEARCH01;  
                    selectVal=SceFrmQryString(formObj);
                     sheetObj.DoSearch("ESD_SCE_0068GS.do", selectVal );
             break;          
        }
    }
    function resizeSheet(){ // auto-sizing
        ComResizeSheet(sheetObjects[0]);
    } 
