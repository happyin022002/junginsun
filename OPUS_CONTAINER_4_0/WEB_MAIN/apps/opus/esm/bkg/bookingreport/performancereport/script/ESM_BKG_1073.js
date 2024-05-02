/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_1073.js
*@FileTitle  : Customer EDI ID Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/10
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class esm_bkg_1073 : business script for esm_bkg_1073
     */
     /**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
 // Common global variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 var prefix="";//IBSheet 
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
		    initControl();
     }
    function initControl() {
    	var formObject=document.form;
//        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //
        axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //
//        axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //
//        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }        
 /*********************** KEY EVENT START ********************/ 	 
	function bkg_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "engup":
	        //capital English
    			ComKeyOnlyAlphabet('upper');
	        break;
	      case "engupnum":
	        //number+capital English
	      	ComKeyOnlyAlphabet('uppernum');
	        break;
	      case "num":
	        //number
	        ComKeyOnlyNumber(event.srcElement);
	        break;           
	      case "custname":
	        //English,number,space,etc
	        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');	              
	      default:
	    }
	}  
	  /**
     * onBlur event
     **/
    function bkg_blur() {
    	var formObj=document.form;    	
	    switch (ComGetEvent("name")) {
				default:
					break;
	    }
    }        
	/**
	 * onFocus event - checking Validation
	 **/
	function bkg_focus(){
			var formObj=document.form;    	
	    switch (ComGetEvent("name")) {
				default:
					break;
	    }
	}  
/*********************** KEY EVENT END ********************/
// Event handler processing by button click event */
 		document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /* */
          var sheetObject1=sheetObjects[0];
					/*******************************************************/
          var formObject=document.form;
	     	try {
	     		var srcName=ComGetEvent("name");
		 			switch(srcName) {
		 				case "btn_Retrieve":
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
			 		 case "btn_Select":
		 					comPopupOK();
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
     var ValidateFail = false;// sheet ValidateFail 
   // handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo,param) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			 			case IBSEARCH:      //retrieve
				 				if(!validateForm(sheetObj,formObj,sAction)) return;
				 				formObj.f_cmd.value=SEARCH;
 								var sXml = sheetObj.DoSearch("ESM_BKG_1073GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix) );
								break;
			    }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:
	    		if ( (ComIsNull(formObj.cnt_cd) || ComIsNull(formObj.cust_seq)) && ComIsNull(formObj.grp_id) && ComIsNull(formObj.edi_id) && ComIsNull(formObj.grp_nm)) {
	     					ComShowCodeMessage('BKG00626','Customer Code, Group ID, TP/EDI ID or Group Name');
	     					return false;
			  	}
	  			break;
    	 }
         return true;
     }
 /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetObj.id) {
            case "sheet1":
              with (sheetObj) {
                
	                var HeadTitle1="||Sel.|Group ID|TP/EDI ID|Group Name|BKG Confirmation|Draft B/L|Cargo Tracking";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	//                (headCount, 0, 0, true);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
			                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"dummy" },
			                    {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"radio" },
			                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"grp_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"edi_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:prefix+"grp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cfm_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"drf_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cgo_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetSheetHeight(187);
				}
			break;
         }
     }
