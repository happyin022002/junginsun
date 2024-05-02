/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0206.js
*@FileTitle  :  DG Package Q'ty & Type
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Added code to make a good JSDoc ------------------*/
   /**
     * @fileoverview JavaScript File is commonly using. calendar functions have is defined.
     * @author 
     */
    /**
     * @extends 
     * @class esm_bkg_0206 : business script for esm_bkg_0206 
     */
 // Common global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var valCnt="";
    var waitFlg="";
    var opener=window.dialogArguments;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
        function processButtonClick(){
             /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
    		         var sheetObject1=sheetObjects[0];
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
        		if(ComGetBtnDisable(srcName)) return false;
        		switch(srcName) {
	                case "btn_ok":	
	                	//comPopupOK(); 
	                	var opener = window.dialogArguments;
	   	    		  	if (!opener) opener = parent;
	   	    		  	if (opener.getCOM_PKG_QTY_POPUP == undefined) {
	   	    		  		return ComShowMessage('Cannot find opener.getCOM_PKG_QTY_POPUP() or parent.getCOM_PKG_QTY_POPUP() js function');
	   	    		  	}
	   	    		  	var item = document.getElementsByTagName("input");
	   	    		  	var rArray =  new Array(1); //데이터를 담고 있는 배열
	   	    			rArray[0] = new Array(item.length);
	   	    			for (var i=0; i < item.length; i++) {
	   	    				if ( item[i].type == "text" || item[i].type == "hidden" ) {
	   	    					rArray[0][i] = item[i].value;
	   	    				}
	   	    			}
	   	    		  	opener.getCOM_PKG_QTY_POPUP(rArray);
	   	    		  	ComClosePopup();
					break;
	                case "out_btn1":    					                					    	     		
	                	document.getElementById("imdg_pck_tp_cd").value="O";
	                	document.getElementById("pck_tp_seq").value="1";
	                	document.getElementById("temp_pck_tp_cd").value=document.getElementById("out_imdg_pck_cd1").value;
	                	document.getElementById("temp_imdg_pck_desc").value=document.getElementById("out_imdg_pck_desc1").value;				                	
	                	var url="ESM_BKG_1045.do";					                	
	                	ComOpenWindowCenter(url, "ESM_BKG_1045", 600, 480, true);
					break;
	                case "out_btn2":
	                	document.getElementById("imdg_pck_tp_cd").value="O";
	                	document.getElementById("pck_tp_seq").value="2";
	                	document.getElementById("temp_pck_tp_cd").value=document.getElementById("out_imdg_pck_cd2").value;
	                	document.getElementById("temp_imdg_pck_desc").value=document.getElementById("out_imdg_pck_desc2").value;
	                	var url="ESM_BKG_1045.do";
						ComOpenWindowCenter(url, "ESM_BKG_1045", 600, 480, true);								
					break;
	                case "intmd_btn1":	
	                	document.getElementById("imdg_pck_tp_cd").value="M";
	                	document.getElementById("pck_tp_seq").value="3";
	                	document.getElementById("temp_pck_tp_cd").value=document.getElementById("intmd_imdg_pck_cd1").value;
	                	document.getElementById("temp_imdg_pck_desc").value=document.getElementById("intmd_imdg_pck_desc1").value;
	                	var url="ESM_BKG_1045.do";
						ComOpenWindowCenter(url, "ESM_BKG_1045", 600, 480, true);								
					break;
	                case "intmd_btn2":		
	                	document.getElementById("imdg_pck_tp_cd").value="M";
	                	document.getElementById("pck_tp_seq").value="4";
	                	document.getElementById("temp_pck_tp_cd").value=document.getElementById("intmd_imdg_pck_cd2").value;
	                	document.getElementById("temp_imdg_pck_desc").value=document.getElementById("intmd_imdg_pck_desc2").value;
	                	var url="ESM_BKG_1045.do";
						ComOpenWindowCenter(url, "ESM_BKG_1045", 600, 480, true);								
					break;	
	                case "in_btn1":	
	                	document.getElementById("imdg_pck_tp_cd").value="I";
	                	document.getElementById("pck_tp_seq").value="5";
	                	document.getElementById("temp_pck_tp_cd").value=document.getElementById("in_imdg_pck_cd1").value;
	                	document.getElementById("temp_imdg_pck_desc").value=document.getElementById("in_imdg_pck_desc1").value;
	                	var url="ESM_BKG_1045.do";
						ComOpenWindowCenter(url, "ESM_BKG_1045", 600, 480, true);								
					break;
	                case "in_btn2":		
	                	document.getElementById("imdg_pck_tp_cd").value="I";
	                	document.getElementById("pck_tp_seq").value="6";
	                	document.getElementById("temp_pck_tp_cd").value=document.getElementById("in_imdg_pck_cd2").value;
	                	document.getElementById("temp_imdg_pck_desc").value=document.getElementById("in_imdg_pck_desc2").value;
	                	var url="ESM_BKG_1045.do";
						ComOpenWindowCenter(url, "ESM_BKG_1045", 600, 480, true);								
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
        function initControl() {    	  
      	    //Axon Event Processing 1. Events catch (developers change)
            axon_event.addListenerForm('blur', 'obj_blur', document.form);
      	    //axon_event.addListenerForm('change','obj_change', form);
      	    //axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  form); 
      	}  
        function obj_blur(){        	
         	var objName=event.srcElement.name;
         	switch (objName) {
    	     	case "out_imdg_pck_cd1":	     	     		
    	     		valCnt="1";	    
    	     		document.getElementById("imdg_pck_tp_cd").value="O";
    	     		document.getElementById("out_imdg_pck_cd1").value=(document.getElementById("out_imdg_pck_cd1").value).toUpperCase();
    	     		document.getElementById("imdg_pck_cd").value=document.getElementById("out_imdg_pck_cd1").value;
    	     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    			break;	
    	     	case "out_imdg_pck_cd2":     	     		    	     		
    	     		valCnt="2";    	     		
    	     		document.getElementById("imdg_pck_tp_cd").value="O";    	     		
    	     		document.getElementById("out_imdg_pck_cd2").value=(document.getElementById("out_imdg_pck_cd2").value).toUpperCase();    	     		
    	     		document.getElementById("imdg_pck_cd").value=document.getElementById("out_imdg_pck_cd2").value;    	     		
    	     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    			break;	
    	     	case "intmd_imdg_pck_cd1":	     		
    	     		valCnt="3";	    
    	     		document.getElementById("imdg_pck_tp_cd").value="M";
    	     		document.getElementById("intmd_imdg_pck_cd1").value=(document.getElementById("intmd_imdg_pck_cd1").value).toUpperCase();
    	     		document.getElementById("imdg_pck_cd").value=document.getElementById("intmd_imdg_pck_cd1").value;
    	     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    			break;	
    	     	case "intmd_imdg_pck_cd2":	     		
    	     		valCnt="4";	    
    	     		document.getElementById("imdg_pck_tp_cd").value="M";
    	     		document.getElementById("intmd_imdg_pck_cd2").value=(document.getElementById("intmd_imdg_pck_cd2").value).toUpperCase();
    	     		document.getElementById("imdg_pck_cd").value=document.getElementById("intmd_imdg_pck_cd2").value;
    	     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    			break;	
    	     	case "in_imdg_pck_cd1":	     		
    	     		valCnt="5";	     	
    	     		document.getElementById("imdg_pck_tp_cd").value="I";
    	     		document.getElementById("in_imdg_pck_cd1").value=(document.getElementById("in_imdg_pck_cd1").value).toUpperCase();
    	     		document.getElementById("imdg_pck_cd").value=document.getElementById("in_imdg_pck_cd1").value;
    	     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    			break;	
    	     	case "in_imdg_pck_cd2":	     		
    	     		valCnt="6";	     	
    	     		document.getElementById("imdg_pck_tp_cd").value="I";
    	     		document.getElementById("in_imdg_pck_cd2").value=(document.getElementById("in_imdg_pck_cd2").value).toUpperCase();
    	     		document.getElementById("imdg_pck_cd").value=document.getElementById("in_imdg_pck_cd2").value;
    	     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    			break;	
         	}
         }
        function obj_keypress(){
    		switch (event.srcElement.name) {		
    		    case "out_imdg_pck_qty1":		    	
    		    	ComKeyOnlyNumber(event.srcElement);   	
    			break;
    		    case "out_imdg_pck_qty2":		    	
    		    	ComKeyOnlyNumber(event.srcElement);   	
    			break;
    		    case "in_imdg_pck_qty1":		    	
    		    	ComKeyOnlyNumber(event.srcElement);		    	
    			break;
    		    case "in_imdg_pck_qty2":		    	
    		    	ComKeyOnlyNumber(event.srcElement); 		    	
    			break; 
    		    case "intmd_imdg_pck_qty1":		    	
    		    	ComKeyOnlyNumber(event.srcElement);		    	
    			break;
    		    case "intmd_imdg_pck_qty2":		    	
    		    	ComKeyOnlyNumber(event.srcElement); 		    	
    			break; 
    		    case "max_in_pck_qty":		    	
    		    	ComKeyOnlyNumber(event.srcElement, "-."); 		    	
    			break;     			
    		}	
    	}
        /**
         * initializing sheet
         * implementing onLoad event handler in body tag
         * adding first-served functions after loading screen.
         */
        function loadPage() {
        	initControl();
    	}
         function setSheetObject(sheet_obj){
             sheetObjects[sheetCnt++]=sheet_obj; 			
          }
         function doActionIBSheet(sheetObj,formObj,sAction) {
             //sheetObj.ShowDebugMsg = false;
             switch(sAction) {
             case IBSEARCH:      
			 		 if(validateForm(sheetObj,formObj,sAction)) {							
			 			//sheetObj.WaitImageVisible = false;
						formObj.f_cmd.value=SEARCH;						
 						var rXml=sheetObj.GetSearchData("ESM_BKG_0206GS.do", FormQueryString(formObj));
						var imdg_pck_desc=ComGetEtcData(rXml, "imdg_pck_desc");
						if(valCnt == "1"){
							document.getElementById("out_imdg_pck_desc1").value=imdg_pck_desc;
							if(imdg_pck_desc == "" && document.getElementById("imdg_pck_cd").value != ""){
								//ComShowCodeMessage("BKG00044", "1st Outer Package");
								ComAlertFocus(document.getElementById("out_imdg_pck_cd1"),  ComGetMsg("BKG00044", "1st Outer Package"));
							}
						}
						if(valCnt == "2"){							
							document.getElementById("out_imdg_pck_desc2").value=imdg_pck_desc;
							if(imdg_pck_desc == "" && document.getElementById("imdg_pck_cd").value != ""){
								//ComShowCodeMessage("BKG00044", "2st Outer Package");
								ComAlertFocus(document.getElementById("out_imdg_pck_cd2"),  ComGetMsg("BKG00044", "2nd Outer Package"));
							}
						}
						if(valCnt == "3"){
							document.getElementById("intmd_imdg_pck_desc1").value=imdg_pck_desc;
							if(imdg_pck_desc == "" && document.getElementById("imdg_pck_cd").value != ""){
								//ComShowCodeMessage("BKG00044", "1st Intermediate Package");
								ComAlertFocus(document.getElementById("intmd_imdg_pck_cd1"),  ComGetMsg("BKG00044", "1st Intermediate Package"));
							}
						}
						if(valCnt == "4"){
							document.getElementById("intmd_imdg_pck_desc2").value=imdg_pck_desc;
							if(imdg_pck_desc == "" && document.getElementById("imdg_pck_cd").value != ""){
								//ComShowCodeMessage("BKG00044", "2st Intermediate Package");
								ComAlertFocus(document.getElementById("intmd_imdg_pck_cd2"),  ComGetMsg("BKG00044", "2nd Intermediate Package"));
							}
						}
						if(valCnt == "5"){
							document.getElementById("in_imdg_pck_desc1").value=imdg_pck_desc;
							if(imdg_pck_desc == "" && document.getElementById("imdg_pck_cd").value != ""){
								//ComShowCodeMessage("BKG00044", "1st Inner Package");
								ComAlertFocus(document.getElementById("in_imdg_pck_cd1"),  ComGetMsg("BKG00044", "1st Inner Package"));
							}
						}
						if(valCnt == "6"){
							document.getElementById("in_imdg_pck_desc2").value=imdg_pck_desc;
							if(imdg_pck_desc == "" && document.getElementById("imdg_pck_cd").value != ""){
								//ComShowCodeMessage("BKG00044", "2st Inner Package");
								ComAlertFocus(document.getElementById("in_imdg_pck_cd2"),  ComGetMsg("BKG00044", "2nd Inner Package"));
							}
						}
						//sheetObj.WaitImageVisible = true;
					}else{
						return false;
					}		 		 	
	 		 break;
             }
         }        
         /**
          * handling process for input validation
          */
         function validateForm(sheetObj,formObj,sAction){
             with(formObj){
//                 if (!isNumber(formObj.iPage)) {
//                     return false;
//                 }
             }
             return true;
         }
