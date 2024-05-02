/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0038.js
*@FileTitle  : Sub trade management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================
* History
*/
/*------------------Code for JSDoc creation below ------------------*/
/**
 * @extends 
 * @class ESM_COA_0038 : ESM_COA_0038 Business script for the UI
 */
function ESM_COA_0038() {
    this.processButtonClick=processButtonClick ;
    this.loadPage=loadPage           ;
    this.initSheet=initSheet          ;
    this.setSheetObject=setSheetObject     ;
    this.sheet1_OnSearchEnd=sheet1_OnSearchEnd ;
    this.doActionIBSheet=doActionIBSheet    ;
    this.validateForm=validateForm       ;
}
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var formObject=document.form;
		
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		
            switch(srcName) {
        	    case "btn_Retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;
        	    case "btn_Close":
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
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        //Sheet configuration setting function(start)
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
        //Sheet configuration setting function(end)
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
   /**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
			                var HeadTitle="Sub Trade|Description";
			
			             //   SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
			
			                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			                var headers = [ { Text:HeadTitle, Align:"Center"} ];
			                InitHeaders(headers, info);
			
			                var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
											{Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"sub_trd_name",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
											{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
			                 
			                InitColumns(cols);
			
			                SetEditable(0);//Editkind[optional,Defaultfalse]
			                SetCountPosition(0);
//			                SetSheetHeight(250);
							resizeSheet();
				}
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
    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    {
         sheetObj.SetSumText(0,1,"");
         sheetObj.SetSumText(0,2,"Total");
    }
	// Handling process about the sheet object
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //Inquiry
				if(validateForm(sheetObj,formObj,sAction))
				// Prohibit button click when a business transaction is processing 
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCHLIST01;
				sheetObj.DoSearch("ESM_COA_0038GS.do", coaFormQueryString(formObj) );
				ComOpenWait(false);
				break;
		}
	}
   /**
     * Handling process for form object input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
        }
        return true;
    }

    function resizeSheet(){
   	 ComResizeSheet(sheetObjects[0]);
    }
