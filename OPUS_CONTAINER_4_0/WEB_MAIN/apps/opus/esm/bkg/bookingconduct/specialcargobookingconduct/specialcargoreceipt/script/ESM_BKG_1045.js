/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1045.js
*@FileTitle  : Special Cargo Remark 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
   /**
     * @fileoverview JavaScript is commonly used in business as a calendar-related functions have been defined.
     */
    /**
     * @extends 
     * @class esm_bkg_1045 : esm_bkg_1045 business script.
     */
   	/* Developer Work	*/
 // global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var opener=window.dialogArguments;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
        function processButtonClick(){
             /***** using extra sheet valuable if there are more 2 sheets *****/
             var sheetObject1=sheetObjects[0];
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
                switch(srcName) {
    				case "btn_retrieve":
    					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    					break;    				
    				case "btn_select":
    					var row1=sheetObjects[0].FindText("selChk", "1", 0, 2);
    					//var row2 = row1.replace("|","");  
    					if(row1 < 1){   						
    						return;
    					}
    					if(document.getElementById("pck_tp_seq").value == "1"){
    						opener.document.getElementById("out_imdg_pck_cd1").value=sheetObjects[0].GetCellValue(row1, "imdg_pck_cd");
    						opener.document.getElementById("out_imdg_pck_desc1").value=sheetObjects[0].GetCellValue(row1, "imdg_pck_desc");
    					}else if(document.getElementById("pck_tp_seq").value == "2"){
    						opener.document.getElementById("out_imdg_pck_cd2").value=sheetObjects[0].GetCellValue(row1, "imdg_pck_cd");
    						opener.document.getElementById("out_imdg_pck_desc2").value=sheetObjects[0].GetCellValue(row1, "imdg_pck_desc");
    					}else if(document.getElementById("pck_tp_seq").value == "3"){
    						opener.document.getElementById("intmd_imdg_pck_cd1").value=sheetObjects[0].GetCellValue(row1, "imdg_pck_cd");
    						opener.document.getElementById("intmd_imdg_pck_desc1").value=sheetObjects[0].GetCellValue(row1, "imdg_pck_desc");
    					}else if(document.getElementById("pck_tp_seq").value == "4"){
    						opener.document.getElementById("intmd_imdg_pck_cd2").value=sheetObjects[0].GetCellValue(row1, "imdg_pck_cd");
    						opener.document.getElementById("intmd_imdg_pck_desc2").value=sheetObjects[0].GetCellValue(row1, "imdg_pck_desc");
    					}else if(document.getElementById("pck_tp_seq").value == "5"){
    						opener.document.getElementById("in_imdg_pck_cd1").value=sheetObjects[0].GetCellValue(row1, "imdg_pck_cd");
    						opener.document.getElementById("in_imdg_pck_desc1").value=sheetObjects[0].GetCellValue(row1, "imdg_pck_desc");
    					}else{
    						opener.document.getElementById("in_imdg_pck_cd2").value=sheetObjects[0].GetCellValue(row1, "imdg_pck_cd");
    						opener.document.getElementById("in_imdg_pck_desc2").value=sheetObjects[0].GetCellValue(row1, "imdg_pck_desc");
    					}    					
    					ComClosePopup(); 
    					break;
    				case "btn_close":
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
            checkRetrieve();
        }
         function initControl() {    	  
     	    axon_event.addListenerForm('keydown','obj_keydown', 	form);   
     	    axon_event.addListenerForm('change','obj_change', form);
         }   
         function checkRetrieve(){  
        	opener=window.dialogArguments;
            if(!opener) opener=parent;
            document.getElementById("imdg_pck_tp_cd").value=opener.document.getElementById("imdg_pck_tp_cd").value;
            document.getElementById("imdg_pck_cd").value=opener.document.getElementById("temp_pck_tp_cd").value;           
            document.getElementById("pck_tp_seq").value=opener.document.getElementById("pck_tp_seq").value;
            if(document.getElementById("imdg_pck_tp_cd").value == "O"){
	        	 document.getElementById("imdg_pck_cd_text").innerHTML="( Outer )";
	        }else if(document.getElementById("imdg_pck_tp_cd").value == "M"){
	        	 document.getElementById("imdg_pck_cd_text").innerHTML="( Intemediate )";
	        }else{
	        	 document.getElementById("imdg_pck_cd_text").innerHTML="( Inner )";
	        }
            if(document.getElementById("imdg_pck_cd").value != ""){
             doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            }
         }
       function obj_keydown(){
   		if (event.keyCode == 13){ // Enter Key
   			switch (ComGetEvent("name")) {	
   				case "imdg_pck_cd":
   					document.getElementById("imdg_pck_cd").value=(document.getElementById("imdg_pck_cd").value).toUpperCase();
   					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 	
   				break;
   				case "imdg_pck_desc":    					
   					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 	
   				break;
   			}
   		}
   	}   
       function obj_change(){
      		switch (ComGetEvent("name")) {	
      			case "imdg_pck_cd":
      				document.getElementById("imdg_pck_cd").value=(document.getElementById("imdg_pck_cd").value).toUpperCase();
      			break;     		      				
      		}
      	}   
      /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) {
    		var cnt=0;
    		switch(sheetObj.id) {
    			case "sheet1":      //sheet1 init
    				with (sheetObj) {
	    		        var HeadTitle1="|Sel.|Code|Description";
	    		        var headCount=ComCountHeadTitle(HeadTitle1);
	
	    		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	    		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    		        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	    		        InitHeaders(headers, info);
	
	    		        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	    		               {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"selChk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"imdg_pck_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"imdg_pck_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	    		         
	    		        InitColumns(cols);
	
	    		        SetEditable(1);
	    		        SetSheetHeight(300);
    				}
    			break;
        }
    }
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
    				case IBSEARCH:      //Retrieve
    				if(validateForm(sheetObj,formObj,sAction)) {
    					formObj.f_cmd.value=SEARCH;
    					sheetObj.DoSearch("ESM_BKG_1045GS.do", FormQueryString(formObj) );
    					if(document.getElementById("imdg_pck_desc").value == "" && sheetObj.RowCount()== "1"){
    						document.getElementById("imdg_pck_desc").value=sheetObjects[0].GetCellValue(1, "imdg_pck_desc")
    					}
    				}
    				break;   				
            }
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
            }
            return true;
        }
/* Developer Work End */
