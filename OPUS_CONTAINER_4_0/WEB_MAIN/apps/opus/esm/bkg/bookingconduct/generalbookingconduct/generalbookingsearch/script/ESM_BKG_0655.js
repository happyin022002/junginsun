/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0655.js
*@FileTitle  : SC Search
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * callback function - Customer Inquiry(common Popup)
     */    	
    function callBackShpr(rArray){
   		var formObject=document.form;
   		if(rArray != null){
   			formObject.s_cust_cnt_cd.value=rArray[0][3].substring(0,2);
   			formObject.s_cust_seq.value=rArray[0][3].substring(2);
   			formObject.s_cust_nm.value=rArray[0][4];
   		}  		    	 
     }	    
    /**
     * callback function - Customer Inquiry(common Popup)
     */    	
    function callBackCnee(rArray){
   		var formObject=document.form;
   		if(rArray != null){
   			formObject.c_cust_cnt_cd.value=rArray[0][3].substring(0,2);
   			formObject.c_cust_seq.value=rArray[0][3].substring(2);
   			formObject.c_cust_nm.value=rArray[0][4];
   		}  		    	 
     }	
    
    /**
     * function calling after Customer Inquiry(common Popup) ,Return <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBackCtrlPty(arrBal);
     * </pre>
     * @param {string} 
     * @return void
     */    	
    function callBackCnrlPty(rArray){
   		var formObject=document.form;
   		if(rArray != null){
   			formObject.bkg_ctrl_pty_cust_cnt_cd.value=rArray[0][3].substring(0,2);
   			formObject.bkg_ctrl_pty_cust_seq.value=rArray[0][3].substring(2);
   			formObject.bkg_ctrl_pty_cust_nm.value=rArray[0][4];
   		}  		    	 
     }
 // Common global variable
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /* */
 		  var sheetObject=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
 							case "btn_Retrieve":
								if(validateForm(formObject)){
									doActionIBSheet(sheetObject,formObject,IBSEARCH);	
								}    							
 							break; 
							case "btn_Shpr":
				        		var custCd=formObject.s_cust_cnt_cd.value+formObject.s_cust_seq.value;
				        		ComOpenPopup('COM_ENS_041.do?pgmNo=COM_ENS_041&cust_cd='+custCd, 700, 430, "callBackShpr", '0,1,1,1,1,1,1', true);									
							break; 
							case "btn_Cnee":
								var custCd=formObject.c_cust_cnt_cd.value+formObject.c_cust_seq.value;
				        		ComOpenPopup('COM_ENS_041.do?pgmNo=COM_ENS_041&cust_cd='+custCd, 700, 430, "callBackCnee", '0,1,1,1,1,1,1', true);															
							break;    	
							case "btn_Ctrl_Pty":
								var custCd=formObject.bkg_ctrl_pty_cust_cnt_cd.value+formObject.bkg_ctrl_pty_cust_seq.value;
								ComOpenPopup('COM_ENS_041.do?pgmNo=COM_ENS_041&cust_cd='+custCd, 700, 430, "callBackCnrlPty", '0,1,1,1,1,1,1', true);														
							break; 
 							case "btn_Select":
 								comPopupSend(sheetObject, formObject);	
 							break;
 							case "btn_Close":
 								ComClosePopup(); 
 							break;
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111");     
     		} else {
     			ComShowMessage(e.message);
     		}
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
	 	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
     
	function initControl() {
       axon_event.addListenerForm('keydown', 'ComKeyEnter', document.form);
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
            	 with(sheetObj){
	            	 var HeadTitle1="|TP|Customer Code|Customer Code|Customer Name|S/C Number|Sales OFC|Scope";
	
	            	 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	            	 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            	 var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            	 InitHeaders(headers, info);
	
	            	 var cols = [ {Type:"CheckBox",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	              {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cust_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"Text",      Hidden:0,  Width:260,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"sc_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"sales_ofc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	            	  
	            	 InitColumns(cols);
	
	            	 SetEditable(1);
	            	 SetWaitImageVisible(0);
	            	 SetSheetHeight(260);
            	 }


                 break;
         }
     }
   // handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			case IBSEARCH:      //retrieve
				formObj.f_cmd.value=SEARCH;
				ComOpenWait(true);
				sheetObj.DoSearch("ESM_BKG_0655GS.do", FormQueryString(formObj) );
			break;
         }
     }
 	// handling event after retrieving
 	function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
 		ComOpenWait(false);
 		if(Msg == ""){
 			if(sheetObj.RowCount()< 1){
 				var idx=sheetObj.DataInsert(-1);
 				sheetObj.SetCellValue(idx, "cust_lgl_eng_nm","DUMMY CUSTOMER", 0);
 				sheetObj.SetCellValue(idx, "sc_no","DUM000001", 0);
 			}
 		}
 	}     
	//double click -> select
    function sheet1_OnDblClick(sheetObj , row, col) {  
   	 	var formObj=document.form;
   	 	sheetObj.SetCellValue(row,"chk","1",0);
   	 	comPopupSend(sheetObj, formObj);
    }     
     /**
      * handling process for input validation
      */
     function validateForm(formObj){
     	 if(ComIsNull(formObj.s_cust_cnt_cd.value) && ComIsNull(formObj.c_cust_cnt_cd.value)&& ComIsNull(formObj.bkg_ctrl_pty_cust_cnt_cd.value)){
    		 ComShowCodeMessage("BKG00625");
    		 return false;
    	 }
         return true;
     }
      /**
       * sending data to Main
       */     
		function comPopupSend(sheetObj, formObj){
			var calllFunc=formObj.calllFunc.value;
			var rArray=getCheckedRowByName(sheetObj, "chk");
			if(rArray == null) {
				ComShowCodeMessage("COM12114", "row");
				return;
			}else{
				if (ComFuncCheck("opener." + calllFunc)) ComFunc(rArray);
				else if (ComFuncCheck("parent." + calllFunc)) ComFunc(rArray);
	 			ComClosePopup(); 
			}
		}     	
