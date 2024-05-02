/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0271.js
*@FileTitle  : 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
/* Global Variables */
var sheetObjects=new Array();
var sheetCnt=0;
/* Event handler defined process to button click event */
document.onclick=processButtonClick;
/* Event handler is branch processing by name of button */


    function processButtonClick(){
    	 /***** Assignment sheet in case of over 2 by tab****/
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn1_Close":
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
     * Register as an IBSheet Object array
     * This is called from comSheetObject(id)
     * Process can add in case of future necessity to process other items
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Initializing sheet
     * To implement onLoad event of body tag
     * Add functionality to after loading screen.
     */
    function loadPage(date, id) {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //데이터 조회 부분 넣을 것
        var formObj=document.form;
        
        doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);        
    }
    /**
  	 * Initializing sheet. Defining header
  	 * param : sheetObj ==> sheet object, sheetNo ==> sheet No.
  	 * Composition a initial module in case of multi sheet
  	 */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
            case "sheet1":
                with (sheetObj) {

                var HeadTitle1="|Seq.|Pin No|Updated Date|Updated Staff|EDI Send";

                SetConfig( { SearchMode:2, MergeSheet:0, Page:20 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [ {Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                             {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pin_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"snd_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
                InitColumns(cols);
                SetEditable(1);
                SetEllipsis(1);
                SetSheetHeight(220,1);
                }
                break;
        }
    }
    /* Processing Sheet */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
            case IBSEARCH:      //retrieve
            	formObj.f_cmd.value=SEARCH;
         		sheetObj.DoSearch("ESM_BKG_0271GS.do", FormQueryString(formObj) );
         		
            	break;
        
        }
    }
