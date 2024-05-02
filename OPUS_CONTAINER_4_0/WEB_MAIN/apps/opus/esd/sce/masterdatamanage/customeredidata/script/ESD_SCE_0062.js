﻿﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0062.js
*@FileTitle  : Customer Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08 
=========================================================*/

var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var selRow=0;
var isFirst1=0;
var isFirst2=0;
var rowCnt=0;
// Event handler processing by button click event
document.onclick=processButtonClick;

// Event handler processing by button name
    function processButtonClick(){
    	var formObject=document.form;
    	var sheetObject0=sheetObjects[0];
    	var srcName=ComGetEvent("name");
    	var opener = window.dialogArguments;
		if (!opener) opener=window.opener;  //이 코드 추가할것
		if (!opener) opener=parent; //이 코드 추가할것
		
    	switch(srcName) {
    	    case "btn_retrieve":
    	    	doActionIBSheet0(sheetObject0,formObject,IBSEARCH);
    	    	break;
    	    case "btn_new":
                sheetObject0.RemoveAll();
                formObject.reset();
    	    	break;
    	    case "btn_ok": 
    	    	returnObject();
    	    	break;
    	    case "btn_save":
	            //var Row=sheetObject0.FindCheckedRow(0).split('|')[0];
    	    	var Row=sheetObject0.GetSelectRow();
                if(Row > 0){
                	doActionIBSheet0(sheetObject0,formObject,IBSAVE);
                } else {
                    ComShowMessage("Select check item");
                }
    	        break;
    	    case 'btn_close':
    	        if(formObject.mycust.value == "1"){
    	            opener.openfunction();   // page reloading
    	        }
    	        ComClosePopup(); 
    	    	break;
    	}
    }
    
    function returnObject() {

    	var Row=sheetObjects[0].GetSelectRow();
    	if(Row < 1){
    		ComShowMessage('Select check item');
    		return false;
    	}
		var formObj=document.form;
		var rtnArray=new Array();
	  	var rtnObject=new Object();

	  	rtnObject.edi_grp=sheetObjects[0].GetCellValue(Row, "edi_grp_cd");
	  	rtnObject.tp_id=sheetObjects[0].GetCellValue(Row, "cust_trd_prnr_id");
	  	rtnObject.grp_nm=sheetObjects[0].GetCellValue(Row, "edi_grp_desc");
	  	rtnObject.cust_cnt_cd=sheetObjects[0].GetCellValue(Row, "cust_cnt_cd");
	  	rtnObject.cust_seq=sheetObjects[0].GetCellValue(Row, "cust_seq");
	  	
//	  	var edi_grp_cd =sheetObjects[0].GetCellValue(Row, "edi_grp_cd");
//	  	var edi_grp_desc =sheetObjects[0].GetCellValue(Row, "edi_grp_desc");
//  	var cust_trd_prnr_id = sheetObjects[0].GetCellValue(Row, "cust_trd_prnr_id");
  		
    	ComPopUpReturnValue(rtnObject);
//  		parent.openESD009Screen(edi_grp_cd, cust_trd_prnr_id, edi_grp_desc);
//    	ComClosePopup();
    }
    
    function toUpperCase(str_){
        str="";
        for(i=0;i<str_.length;i++){
            str+=str_.charAt(i).toUpperCase(); 
        }  
        return str;      
    }
    
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
        for(i=0;i<sheetObjects.length;i++){
         ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
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
            case 1:     //sheet2 init
                with(sheetObj){
            		var HeadTitle="|GroupId|EDI ID|Country|Customer Seq.|Customer Name";

            		SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, DataRowMerge:0 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"edi_grp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 },
            		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cust_trd_prnr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 },
            		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, AcceptKeys:"E|N", InputCaseSensitive:1 },
     							 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
            		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"edi_grp_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 } ];
               
            		InitColumns(cols);
            		SetWaitImageVisible(0);
            		SetEditable(1);
//            		SetSheetHeight(200);
  			        resizeSheet(); 
            	}
                break;
        }
    }
    
    // handling sheet process
    function doActionIBSheet0(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        var opener=window.dialogArguments;
        if (!opener) opener=parent;
        switch(sAction) {
           case IBSEARCH:             
		        formObj.f_cmd.value=SEARCH01;
		        ComOpenWait(true);
		        sheetObj.DoSearch("ESD_SCE_0062GS.do", FormQueryString(formObj) );
                break;
           case IBSAVE:
                var chkrow=sheetObj.FindCheckedRow(0).split('|')[0];
                formObj.temp_edi_grp.value=sheetObj.GetCellValue(chkrow, "edi_grp_cd");
                formObj.temp_edi_id.value=sheetObj.GetCellValue(chkrow, "cust_trd_prnr_id");
                formObj.temp_edi_nm.value=sheetObj.GetCellValue(chkrow, "edi_grp_desc");
                formObj.f_cmd.value=SEARCH02;
                var sXml=sheetObj.GetSearchData("ESD_SCE_0062GS.do", FormQueryString(formObj));
				var cust_cnt=ComGetEtcData(sXml, "cust_cnt");
				if(cust_cnt == '0'){
                    ComShowMessage("SAVED SUCCESSFULLY");
                    //formObj.sendClose.value="reload"; 
                    if(formObj.mycust.value != "1"){
        	            opener.openfunction();      // page reloading
        	            ComClosePopup(); 
    	            } 
                } else {
                    ComShowMessage("Already Exisiting in my Cust");
                }
        }
    }
    
    function t1sheet_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	ComOpenWait(false);
    }
    
    function resizeSheet(){ // auto-sizing
        ComResizeSheet(sheetObjects[0]);
    } 