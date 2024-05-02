/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0056.js
*@FileTitle  : S/C No. Assignement
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================*/
 // common global variables
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
 var returnData=new Array();
 returnData[0]="N"; 
 returnData[1]="";// Variables pass Created S/C No. to main
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 /**
  * Event handler processing by button name  <br>
  * <br><b>Example :</b>
  * <pre>
  *     processButtonClick();
  * </pre>
  * @return void
  * @author 
  * @version 2009.04.17
  */
     function processButtonClick(){     
          /*******************************************************/
          var formObj=document.form;
          var sheetObj=sheetObjects[0];
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
 				case "btn_Ok":
 					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
 					if (returnData[0] == "Y"){
 	 					ComPopUpReturnValue(returnData);
 					}
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
      * registering IBSheet Object as list <br>
      * adding process for list in case of needing batch processing with other items<br>
      * defining list on the top of source <br>
      * <br><b>Example :</b>
      * <pre>
      *     setSheetObject(sheetObj);
      * </pre>
      * @param {ibsheet} sheet_obj mandatory IBSheet Object
      * @return void
      * @author 
      * @version 2009.04.17
      */
     function setSheetObject(sheet_obj){
         sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * initializing sheet <br>
      * implementing onLoad event handler in body tag <br>
      * adding first-served functions after loading screen. <br>
      * <br><b>Example :</b>
      * <pre>
      *     loadPage();
      * </pre>
      * @return void
      * @author 
      * @version 2009.04.17
      */
     function loadPage() {
    	 var formObj=document.form;
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
  			 initSheet(sheetObjects[i],i+1);  	
  			 ComEndConfigSheet(sheetObjects[i]);
         }
         initControl();
         formObj.prop_no.readOnly=true;
         formObj.ctrt_eff_dt.readOnly=true;
         formObj.ctrt_exp_dt.readOnly=true;
         formObj.gpre_fix.readOnly=true;
         if (formObj.svcCnt.value == "1"){
        	 formObj.opt_sc[1].disabled=true;
        	 formObj.gpre_fix.disabled=true;
        	 formObj.gsc_no.disabled=true;        	 
         }
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }     
      /**
       * Catching events for Axon event.<br>
       * <br><b>Example :</b>
       * <pre>
       *     initControl()
       * </pre>
       * @param  void
       * @return void
       * @author 
       * @version 2009.04.17
       */       
 	 function initControl() {
		    // Process Axon Event No.1, Event Catch 		    
		axon_event.addListenerForm('blur', 'obj_blur', document.form);
		axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);     		    
	 }      
     /**
     * Handling OnKeyPress<br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_keypress()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.04.17
     */  	 
 	function obj_keypress() {
		switch (event.srcElement.dataformat) {
		case "engup":
            if (event.srcElement.name == "spre_fix") {
            	ComKeyOnlyAlphabet('uppernum');   
			} else {
				ComKeyOnlyAlphabet('upper');   
			}
			break;
		case "int":
			ComKeyOnlyNumber(event.srcElement);
			break;
		case "num":
			ComKeyOnlyNumber("int");
			break;
		case "float":
			ComKeyOnlyNumber(event.srcElement, ".");
			break;
		default:
			ComKeyOnlyNumber(event.srcElement);
		}
	}
    /**
    * Handling Onbeforedeactivate event<br>
    * <br><b>Example :</b>
    * <pre>
    *     obj_deactivate()
    * </pre>
    * @param  void
    * @return void
    * @author 
    * @version 2009.04.17
    */   	
	function obj_blur() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];	
		var eleName=event.srcElement.name;
		switch(eleName){
			case "spre_fix":
				var preFixChk=checkPreFix();
				if (preFixChk != "Y"){
					formObj.spre_fix.value="";
				}				
				ComChkObjValid(event.srcElement);
				break;
			case "gpre_fix":
				ComChkObjValid(event.srcElement);
				break;		
			case "ssc_no":
				break;		
			case "gsc_no":
				break;						
			default:
				ComChkObjValid(event.srcElement);		
		}
	}  	 

	/**
       * setting sheet initial values and header <br>
       * adding case as numbers of counting sheets  <br>
       * <br><b>Example :</b>
       * <pre>
       *     initSheet(sheetObj,1);
       * </pre>
       * @param {ibsheet} sheetObj mandatory IBSheet Object
       * @param {int} sheetNo mandatory IBSheet Object Serial No
       * @return void
       * @author 
       * @version 2009.04.17
       */
      function initSheet (sheetObj, sheetNo) {
          var cnt=0;
          var sheetID=sheetObj.id;
          switch (sheetID) {
              case "sheet1":
                  with (sheetObj) {
                  var HeadTitle="|||";
                  var headCount=ComCountHeadTitle(HeadTitle);
                  (headCount, 0, 0, true);

                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                  var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
                  InitHeaders(headers, info);

                  var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                   {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
                   {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"sc_no" } ];
                   
                  InitColumns(cols);

                  SetEditable(1);
                  SetWaitImageVisible(0);
                  SetVisible(false);

                  }
                  break;
          }
      }      
       /**
        * Handling sheet's processes <br>
        * <br><b>Example :</b>
        * <pre>
        *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
        * </pre>
        * @param {ibsheet} sheetObj mandatory IBSheet Object
        * @param {form} formObj mandatory html form object
        * @param {int} sAction mandatory,Constant Variable
        * @return void
        * @author 
        * @version 2009.04.17
        */
       function doActionIBSheet (sheetObj, formObj, sAction) {
           sheetObj.ShowDebugMsg(false);
           try{
               switch (sAction) {
	               case IBSEARCH: // retrieving
	               	   ComOpenWait(true); 
	                   formObj.f_cmd.value=SEARCH;               	   
	                   var sXml=sheetObj.GetSearchData("ESM_PRI_0056GS.do" , FormQueryString(formObj));
	                   var arrData=ComPriXml2Array(sXml, "sc_no");
		       			var preFix="";
		    			var seq="";	
		    			// When scope is several, general s/c and global s/c could be use both
		           		if (arrData !=null && arrData.length > 0){
		           			if (arrData[0][0].length == 9){
			           			preFix=arrData[0][0].substr(0, 3);			           			
			        			seq=arrData[0][0].substr(3, 6); 
		           			}else if(arrData[0][0].length==5){
		           				preFix=arrData[0][0].substr(0, 3);
		           				seq=arrData[0][0].substr(3, 2)+"0001";
		           			}
		        			formObj.spre_fix.value=preFix;
		        			formObj.ssc_no.value=seq;
		        			formObj.gsc_no.value=seq;	 
		           		}		    			
		           		formObj.ssc_no.focus();		               	 
		                if (formObj.svcCnt.value == "1"){
		               	 	formObj.gpre_fix.value="";
		               	 	formObj.gsc_no.value="";	               	 
		                }		           		
	                   break;	       
	               case IBSAVE: // Saving	   
	               		ComOpenWait(true); 
	                   if (!validateForm (sheetObjects[0], formObj, sAction)) {                     
	                	   return;
	                   }	               		
						var sc_no="";
						if (formObj.opt_sc[0].checked){
							sc_no=formObj.spre_fix.value +formObj.ssc_no.value;
						}else{
							sc_no=formObj.gpre_fix.value +formObj.gsc_no.value;
						}	
	                   formObj.f_cmd.value=MULTI;
	                   var sParam=FormQueryString(formObj)+"&sc_no="+sc_no ;
	                   var sXml=sheetObj.GetSaveData("ESM_PRI_0056GS.do", sParam);
	                   sheetObjects[0].LoadSaveData(sXml);
	                   break;
	           }        	   
           } catch (e) {
            	if (e == "[object Error]") {
                    ComShowMessage(OBJECT_ERROR);
                } else {
                    ComShowMessage(e.message);
                }
            }finally{
            	ComOpenWait(false); //->waiting->End
            }
       }     
   /**
    * Check the User inputted S/C No. exists in Database. <br>
    * <br><b>Example :</b>
    * <pre>
    *		checkScNo();
    * </pre>
    * @param  void
    * @return {string} <br>
    *                   Y : Duplicate Value Exists
    *                   N : No duplicate value
    * @author 
    * @version 2009.05.07
    */          
    function checkScNo(){
   		var formObj=document.form;
		var sheetObj=sheetObjects[0]
		var rValue="N";// 
		formObj.f_cmd.value=SEARCH01;
		var sc_no="";
		if (formObj.opt_sc[0].checked){
			sc_no=formObj.spre_fix.value + formObj.ssc_no.value;
		}else{
			sc_no=formObj.gpre_fix.value + formObj.gsc_no.value;
		}      		
		var sParam=FormQueryString(formObj)+"&sc_no="+sc_no ;
		var sXml=sheetObj.GetSearchData("ESM_PRI_0056GS.do" , sParam);
		var arrData=ComPriXml2Array(sXml, "sc_no");
		if (arrData !=null && arrData.length > 0){
			rValue="Y";
		}
		return rValue;    	   
    }
    /**
     * Check whether inputted Prefix is valid. <br>
     * When save the date, if it is invalid, you cannot save it.
     * <br><b>Example :</b>
     * <pre>
     *		checkPreFix();
     * </pre>
     * @param  void
     * @return {string} <br>
     *                   Y : Valid
     *                   N : Not Valid
     * @author 
     * @version 2009.05.07
     */        
    function checkPreFix(){
   		var formObj=document.form;
		var sheetObj=sheetObjects[0]
		var rValue="N";// 
		formObj.f_cmd.value=SEARCH02;
		var preFix="";
		if (formObj.opt_sc[0].checked){
			preFix=formObj.spre_fix.value;
		}else{
			preFix=formObj.gpre_fix.value;
		}      		
		var sParam=FormQueryString(formObj)+"&pre_fix="+preFix ;
		var sXml=sheetObj.GetSearchData("ESM_PRI_0056GS.do" , sParam);
		var arrData=ComPriXml2Array(sXml, "svc_scp_cd");		
		if (arrData !=null && arrData.length > 0){
			rValue="Y";
		}
		return rValue;  
    }
   /**
    * handling process for input validation <br>
    * <br><b>Example :</b>
    * <pre>
    *     if (validateForm(sheetObj,document.form,IBSAVE)) {
    *        handling logic
    *     }
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {form} formObj mandatory html form object
    * @param {int} sAction mandatory,Constant Variable
    * @returns bool <br>
    *          true  : valid<br>
    *          false : inValid
    * @author 
    * @version 2009.04.17
    */
   function validateForm (sheetObj, formObj, sAction) {
       with (sheetObj) {
           switch (sAction) {
               case IBSAVE:
            	   if (formObj.prop_no.value =="" ){
            		   return false;
            	   }
            	   if (formObj.svc_scp_cd.value =="" || formObj.ofc_cd.value ==""){            		   
            		   return false;
            	   }     
            	   if (!ComShowCodeConfirm("PRI01056")){            		   
            		   return false;
            	   }
					if (formObj.opt_sc[0].checked){
						if (formObj.spre_fix.value =="" ){
							ComShowCodeMessage("PRI01061");
							formObj.spre_fix.focus();
							return false;
						}					
						if (formObj.ssc_no.value == "" || formObj.ssc_no.value.length != 6){
							ComShowCodeMessage("PRI01061");
							formObj.ssc_no.focus();
							return false;
						}						
					}else{
						if (formObj.gpre_fix.value =="" || formObj.gsc_no.value == "" || formObj.gsc_no.value.length != 6){
							ComShowCodeMessage("PRI01061");
							formObj.gsc_no.focus();
							return false;
						}	
					}  
					var preFixChk=checkPreFix();
					if (preFixChk != "Y"){
						formObj.spre_fix.value="";
						formObj.spre_fix.focus();
						ComShowCodeMessage("PRI01061");						
						return false;
					}						
            	   var dup=checkScNo();            	   
            	   if (dup =="Y"){
            		   ComShowCodeMessage("PRI01062")
            			return false;            		               		   
            	   }
                   break;
           }
       }
       return true;
   }       
    /**
    * calling function when occurring OnSaveEnd event <br>
    * After save completed, Declare Editable columns. <br>
    * <br><b>Example :</b>
    * <pre>
    * 
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {string} ErrMsg mandatory from server
    * @return void
    * @author 
    * @version 2009.04.17
    */ 	
	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
			var formObj=document.form;
			returnData[0]="Y";			
			var sc_no="";
			if (formObj.opt_sc[0].checked){
				sc_no=formObj.spre_fix.value +formObj.ssc_no.value;
			}else{
				sc_no=formObj.gpre_fix.value +formObj.gsc_no.value;
			}  
			returnData[1]=sc_no;
		}
   	}     	        
