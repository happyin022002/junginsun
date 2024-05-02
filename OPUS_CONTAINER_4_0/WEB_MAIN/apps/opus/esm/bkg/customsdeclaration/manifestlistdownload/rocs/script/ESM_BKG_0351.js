/*=========================================================* 
* *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : esm_bkg_0351.js
*@FileTitle : ESM_BKG-0351
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
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
     * @class Customer Code Entry : Customer Code Entry business script.
     */

   	/* Developer Work	*/
 // global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** using extra sheet valuable if there are more 2 sheets *****/
    	var sheetObject=sheetObjects[0];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
            case "btn_Retrieve":  
            	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            	break;
            case "btn_Save":
            	doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
            	break;
            case "btn_Print":    		
            	doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
            	break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
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
        var formObject=document.form;
        if(formObject.cn_no.value != "" || formObject.vvd_no.value != "")
        {
        	if(formObject.vvd_no.value.length > 0)
        	{
        		formObject.vsl_cd.value=formObject.vvd_no.value.substring(0,4);
        		formObject.skd_voy_no.value=formObject.vvd_no.value.substring(4,8);
        		formObject.skd_dir_cd.value=formObject.vvd_no.value.substring(8);
        		formObject.vvd_number.value=formObject.vvd_no.value;            		 
        	}
        	formObject.frm_crn_number.value=formObject.cn_no.value;
        	formObject.f_cmd.value=SEARCH;    					 
			sheetObjects[0].RemoveAll();
			sXml=sheetObjects[0].GetSearchData("ESM_BKG_0351GS.do", FormQueryString(formObject));
			var arrXml=sXml.split("|$$|");
	   	  	if (arrXml.length > 0) {			   	  		 
	   	  	    sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
	   	  	}
        }
			axon_event.addListenerFormat("keypress","obj_KeyPress", document.form);        	 
        	axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
        	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
                
              var HeadTitle1=" |Chk.|Seq.|B/L No.|CRN|Container No.|Type|QTY|POL|POD|Consignee|TTL WGT|Unit|";
              var headCount=ComCountHeadTitle(HeadTitle1);

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"CHK",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ib_file_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"frm_crn_number",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"pck_qty",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:500,  Align:"Left",    ColMerge:1,   SaveName:"ntfy_addr",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"bkg_ttl_qty",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ttl_qty_ut_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetCountPosition(0);
              SetSheetHeight(525);
              }


                break;
        }
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        			case COMMAND01:        
        				 vIsCheck=0;
        				 for(i=1; i<=sheetObjects[0].RowCount(); i++) {
        					 if(sheetObj.GetCellValue(i, "CHK") == 1)
     				    			vIsCheck++;         				    		          				    	 		    		   
     				    }
      					if (vIsCheck == 0) {
      						ComShowCodeMessage('BKG00249');	
      						return;
      					}
        				var bl_no=loadBlNo(sheetObj,formObj);
        				var sParam="bl_no="+bl_no;      
        				//var sParam="bl_no="+ComReplaceStr(bl_no,"|",""); 
        				ComOpenWindowCenter("/opuscntr/ESM_BKG_0352.do?pgmNo=ESM_BKG_0352&"+sParam, "ESM_BKG_0352", 900, 680, false);
        				break;
					case IBSEARCH:      //Retrieve
					if(!validateForm(sheetObj,formObj,sAction)) {
 						return false;
 					}
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH;    					 
					sheetObjects[0].RemoveAll();
					formObj.vsl_cd.value=formObj.vvd_number.value.substring(0,4);
 					formObj.skd_voy_no.value=formObj.vvd_number.value.substring(4,8);
 					formObj.skd_dir_cd.value=formObj.vvd_number.value.substring(8);	
 					sXml=sheetObj.GetSearchData("ESM_BKG_0351GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
			   	  	if (arrXml.length > 0) {			   	  		 
			   	  	    sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
			   	  	}
			   	  	ComOpenWait(false);
					break;
					case IBSAVE:        //save
					if(!validateForm(sheetObj,formObj,sAction)) {
 						return false;
 					}
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					formObj.f_cmd.value=MULTI;
					var sParam="";					 
					var sParamSheet=sheetObjects[0].GetSaveString();
					if (sParamSheet != "") {
						sParam += "&" + ComSetPrifix(sParamSheet, "sheet1_");
					}					 
					sParam += "&" + FormQueryString(formObj);    					
					var sXml=sheetObjects[0].GetSaveData("ESM_BKG_0351GS.do", sParam);
					sheetObjects[0].LoadSaveData(sXml);
					sXml=ComDeleteMsg(sXml);  
					formObj.f_cmd.value=SEARCH;    					 
					sheetObjects[0].RemoveAll();
					sXml=sheetObj.GetSearchData("ESM_BKG_0351GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
			   	  	if (arrXml.length > 0) {			   	  		 
			   	  	    sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
			   	  	}
			   	  	ComOpenWait(false);
					break;
        }
    }
    /**
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function loadBlNo(sheetObj,formObj)
    {	
    	var chkBlNo="";     
    	var cnt=0;
    	var bl_no="";
    	for (var i=1; i <= sheetObj.RowCount(); i++) {
    		if(sheetObj.GetCellValue(i, "CHK") == 1)
	    		{	
	    			cnt++;
	    			bl_no="";
	    			bl_no=sheetObj.GetCellValue(i, "bl_no");
	    			if(bl_no.length == 13){
	    				chkBlNo=chkBlNo + bl_no.substring(0,12); // Toyota B/L
	    			}else if(bl_no.length == 11){
	    				chkBlNo=chkBlNo + bl_no.substring(0,10); // Toyota B/L
	    			}else{
	    				chkBlNo=chkBlNo + bl_no; // Toyota B/L
	    			}
//	    			chkBlNo=chkBlNo + bl_no.substring(0,12); // Toyota B/L
	    			chkBlNo=chkBlNo + "|";		    			 
	    		} 							 
			} 	
    	return chkBlNo;
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	 switch (sAction) {
 			case IBSEARCH: // Retrieve
 			if (formObj.frm_crn_number.value == "" && formObj.vvd_number.value == "" ) 
 			{
 				ComShowCodeMessage('BKG00591');
 				formObj.vvd_number.focus();
 				return false;
 			}  
 			if (formObj.vvd_number.value.length > 0 && formObj.vvd_number.value.length < 9) {
 				ComShowCodeMessage('BKG00710');
 				formObj.vvd_number.focus();
 				return false;
 			}
 			if (formObj.pol_cd.value.length > 0 && formObj.pol_cd.value.length < 5) {
 				ComShowCodeMessage('BKG00711');
 				formObj.pol_cd.focus();
 				return false;
 			}
 			return true;  
 			break;
 			case IBSAVE: // save
 			var vIsCheck=false;
 			for(var i=1; i <= sheetObj.RowCount(); i++) {
 				if (sheetObj.GetCellValue(i, "ibflag") == "U") {
 					vIsCheck=true;
 					break;
 				}
 			}
 			if (!vIsCheck) {
 				ComShowCodeMessage('BKG00737');
 				return false;
 			}
 		    return true;
 			 break;
    	 }
    } 
     /**
     * onkeyUp Event Handling
     **/
     function obj_KeyUp() {
     	    var formObject=document.form;        
     	    var srcName=ComGetEvent("name");
     	    var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
     	    var srcValue=window.event.srcElement.getAttribute("value");
     	    if (ComChkLen(srcValue, srcMaxLength) == "2") {
     	    	ComSetNextFocus();        	    		
     	    }
     }
   /**
    * Enter Event Handling 
    * @return
    */  
     function obj_ComKeyEnter() {
         var formObject=document.form;
         var srcName=ComGetEvent("name");
         if(srcName != "") {         		 
           	ComKeyEnter();
          }         	         
  }
