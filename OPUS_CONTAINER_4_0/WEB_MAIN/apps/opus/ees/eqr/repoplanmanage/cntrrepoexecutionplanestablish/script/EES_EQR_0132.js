/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_0132.js
*@FileTitle  : Search Send History email / fax
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
    /* common static variable */
    var sheetObjects=new Array();
    var sheetCnt=0;
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    /* Event handler processing by button name */    
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;
                case "btn_close":
                	ComClosePopup(); 
        	        break;
        	    case "btn_ok":
                    var opener=window.dialogArguments; // creating parent object
                    if (!opener) opener = parent;
                    var sender_list="";
                    var target=document.form.target.value;
                    //throwing checked e-mail / fax to opener
                    for(var i=1; i<sheetObjects[0].RowCount()+1; i++) {
                    	if(sheetObjects[0].GetCellValue(i, "check")=="1"){
                    		sender_list += sheetObjects[0].GetCellValue(i, "value")  + ((i == sheetObjects[0].RowCount() ) ? "" : ";");
                        }
    	            }
    	            if (sender_list.substring(sender_list.length-1,sender_list.length) == ";") {
    	              sender_list=sender_list.substring(0,sender_list.length-1);    	             
    	            }
    	            opener.settingValue(sender_list, target ); 
    	            ComClosePopup(); 
        	        break;
            } // end switch
        }catch(e) {            
            if( e == "[object Error]") {
                ComShowCodeMessage("EQR90004");
            } else {
                ComShowMessage(e.message);
            }
        }
    }  
    /**
     * registering IBSheet Object as list
     * comSheetObject(id)
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
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        var sheetObject=sheetObjects[0];
        var formObject=document.form;
        doActionIBSheet(sheetObject,formObject,IBSEARCH);  //  automatically retrieve
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
                var HeadTitle="Sel.|e-Mail/Fax" ;
                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"check",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"status" },
                    {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:"value",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                InitColumns(cols);
                SetEditable(1);
                SetSheetHeight(320);
               }
                break;
        }
    }
    /* handling process for Sheet */
    function doActionIBSheet(sheetObj,formObj,sAction, a, PageNo) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
          case IBSEARCH:        //retrieve
                if(!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }
                formObj.f_cmd.value=SEARCHLIST;                
                sheetObj.DoSearch("EES_EQR_0132GS.do", eqrFormQryStr(formObj) );
           break;
        }
    }
   /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }
        return true;
    }
