/* 
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2040.jsp
*@FileTitle  : RFA Proposal Creation[Amend]
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================
*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @
     * @author 
     */
    /**
     * @extends 
     * @class ESM_PRI_2040 : Business Script for ESM_PRI_2040
     */
 // common global variables
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1; 
 var sheetObjects=new Array();
 var sheetCnt=0;
 var rData="N";
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
          var sheetObject1=sheetObjects[0];
          var sheetObject2=sheetObjects[1];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
	             case "btns_calendar1": //calendar button
		             var cal=new ComCalendar();                
		             cal.select(formObject.exp_dt, 'yyyy-MM-dd');
		             break; 
	             case "btns_calendar2": //calendar button
		             var cal=new ComCalendar();                
		             cal.select(formObject.eff_dt, 'yyyy-MM-dd');
		             break; 		
				case "btn_OK":
	                var rValue=doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
	                if (!rValue){
	                	return;
	                }
	                rData="Y";
	                if(!opener) opener = parent;
	                parent.after_amend(rData);
	                ComClosePopup(); 
					break;
				case "btn_Close":
//					window.returnValue=rData;
//					ComClosePopup(); 
					ComPopUpReturnValue(rData); 
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
         for(i=0;i<sheetObjects.length;i++){
         //Modify Environment Setting Function's name
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
         //Add Environment Setting Function
             ComEndConfigSheet(sheetObjects[i]);
         }
         initControl();
         setInitData();         
         var formObj=document.form;  
    	 formObj.exp_dt.readOnly=false;
    	 //btnImgEnable(formObj.btns_calendar1, true);
    	 ComBtnEnable("btns_calendar1");
    	 formObj.eff_dt.focus();
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
       function initSheet(sheetObj,sheetNo) {
           var cnt=0;
           var amdt_seq=document.form.amdt_seq.value;
           var sheetID=sheetObj.id;
           switch(sheetID) {
               case "sheet1":      //t1sheet1 init
                   with (sheetObj) {
            	   var HeadTitle="|propno|amdtseq|new duration|new duration|amdeffdt";
            	   var headCount=ComCountHeadTitle(HeadTitle);
            	   (headCount, 0, 0, true);

            	   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            	   var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
            	   var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	   InitHeaders(headers, info);

            	   var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            	                {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"Date",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ctrt_eff_dt",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"Date",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"exp_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"Date",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"eff_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
            	    
            	   InitColumns(cols);
            	   SetSheetHeight(120);
                   SetEditable(1);
//                   SetWaitImageVisible()(0);
                   SetVisible(0);
                  }
                   break;
           }
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
//          axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
          axon_event.addListenerForm('blur', 'obj_deactivate', document.form);
//          axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);               
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
      function obj_deactivate() {
          var formObj=document.form;
          var sheetObj=sheetObjects[0]; 
          var eleName=event.srcElement.name;
          switch(eleName){
              case "ctrt_eff_dt":
                  ComChkObjValid(event.srcElement);   
                  break;
              case "exp_dt":
            	  if (formObj.exp_dt.value !=""){
            		  formObj.pos_exp_dt.value=ComGetMaskedValue(formObj.exp_dt.value, "ymd") ;
            	  }
            	  sheetObj.SetCellValue(1, "exp_dt",formObj.exp_dt.value,0);
                  ComChkObjValid(event.srcElement);              	
                  if (checkNewDurValidation() == false){
                	  formObj.exp_dt.focus();
                	  formObj.exp_dt.select(); 
                	  return false;
                  }
                  break;   
              case "eff_dt":
	          	  sheetObj.SetCellValue(1, "eff_dt",formObj.eff_dt.value,0);
	              ComChkObjValid(event.srcElement);
                  if (checkAmdEffValidation() == false){
                	  formObj.eff_dt.focus();
                	  ComSetFocus(formObj.eff_dt);
                	  return false;
                  }
	              break;   
              default:
                  ComChkObjValid(event.srcElement);       
          }
      }    
      /**
       * handling OnBeforeActivate event<br>
       * <br><b>Example :</b>
       * <pre>
       *     obj_activate()
       * </pre>
       * @param  void
       * @return void
       * @author 
       * @version 2009.04.17
       */         
      function obj_activate() {
          var formObj=document.form;
          var srcName=ComGetEvent("name");
          ComClearSeparator (event.srcElement);
      }      
      /**
       * Handling OnKeyPress<br>
       * <br><b>Example :</b>
       * <pre>
       *     obj_keypress();
       * </pre>
       * @param  void
       * @return void
       * @author 
       * @version 2009.04.17
       */        
      function obj_keypress() {
          switch (event.srcElement.dataformat) {
              case "ymd":
              	ComKeyOnlyNumber(event.srcElement, "-");
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
       function doActionIBSheet(sheetObj,formObj,sAction) {
           try{
        	   switch(sAction) {
     			 case IBSAVE:         	 		
	     			 ComOpenWait(true); //->waiting->start
	  	             if (!validateForm(sheetObj,document.form,sAction)) {
	  	                 return false;
	  	             }     			 
  	             	formObj.f_cmd.value=MULTI01;
	  				var newDurFlg="Y";
	  				if (ComGetUnMaskedValue(formObj.eDurDt.value,"ymd") == ComGetUnMaskedValue(formObj.exp_dt.value,"ymd")){
	  					newDurFlg="N";				
	  				}
	  				var sParam=FormQueryString(formObj);
	  				    sParam +="&new_dur_flg="+ newDurFlg + "&" + sheetObjects[0].GetSaveString();
 	  				var sXml=sheetObj.GetSaveData("ESM_PRI_2040GS.do", sParam);
 	  				sheetObjects[0].LoadSaveData(sXml);
	  				ComOpenWait(false); //->waiting->End	  				
	                break;
               }        	   
        	   return true;
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
        * @return bool <br>
        *          true  : valid<br>
        *          false : inValid
        * @author 
        * @version 2009.04.17
        */
       function validateForm(sheetObj, formObj, sAction) {
           var rfa_no=formObj.rfa_no.value;
           var prop_no=formObj.prop_no.value;
           var amdt_seq=formObj.amdt_seq.value;
           switch (sAction) {               
	           case IBSAVE: // Save
		   	        var formObj=document.form;
	           		if (formObj.pos_exp_dt.value =="" && formObj.exp_dt.value !=""){
	           			ComShowCodeMessage("COM130201","New Duration Exp Date");
//	           			formObj.exp_dt.focus();
	           			return false;
	           		}
	           		if (formObj.eff_dt.value ==""){
	           			ComShowCodeMessage("COM130201","Amend Eff Date");
//	           			formObj.eff_dt.focus();
	           			return false;
	           		}
	  			 	if ( !ComPriConfirmSave()) {
	 	                 return false;
	 	            }
		   	        break;           
           }
           return true;
       }           
   /**
    * After loading windows, Received data from main update to Sheet. <br>
    * <br><b>Example :</b>
    * <pre>
    * 
    * </pre>
    * @param  void
    * @return void
    * @author 
    * @version 2009.04.17
    */ 	   
   function setInitData(){
 	  var sheetObj=sheetObjects[0];
 	  var formObj=document.form;
// 	  formObj.pos_eff_dt.focus();
// 	  formObj.pos_exp_dt.focus();
// 	  formObj.ctrt_eff_dt.focus();
// 	  formObj.sdur_dt.focus();
// 	  formObj.edur_dt.focus(); 	   	  
 	  sheetObj.DataInsert();
 	  sheetObj.SetCellValue(1, "rfa_no",formObj.rfa_no.value,0);
 	  sheetObj.SetCellValue(1, "prop_no",formObj.prop_no.value,0);
 	  sheetObj.SetCellValue(1, "amdt_seq",formObj.amdt_seq.value,0);
 	  sheetObj.SetCellValue(1, "ctrt_eff_dt",formObj.ctrt_eff_dt.value,0);
   }       
   /**
    * calling function when occurring OnSaveEnd event <br>
    * After save completed, Set "Y" to Modification Flag. <br>
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
    		rData="Y";
    	}
}          
/**
 * Image Button Enable/Disable. <br>
 * <br><b>Example :</b>
 * <pre>
 * 		btnImgEnable(formObj.btns_calendar1, false);
 * </pre>
 * @param {object} obj Mandatory button image name
 * @param {boolean}  Mandatory
 * @return void
 * @author 
 * @version 2009.04.17
 */ 	        
   function btnImgEnable(obj, gb) {
	    if(obj.constructor == String){
	        obj=document.getElementsByName(obj)[0];    	        
	    }
	    var btnStyle=obj.style;
	    if (gb){    	       
	    	obj.SetEnable(1);
	        btnStyle.cursor="hand";
	        btnStyle.filter="";
	        obj.disabled=false;
	    } else {    	     
	    	obj.SetEnable(0);
	        btnStyle.cursor="auto";
	        btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
	        obj.disabled=true;   
	    }
	}       
 /**
  * Validation check on User Inputted Duration. <br>
  * <br><b>Example :</b>
  * <pre>
  * 		checkNewDurValidation();
  * </pre>
  * @param  void
  * @return bool  <br>
  *           true  : Can be saved
  *           false : Can not be saved
  * @author 
  * @version 2009.04.17
  */ 	  
 function checkNewDurValidation(){
     var sheetObj=sheetObjects[0];
     var formObj=document.form; 
     var expDay=ComGetUnMaskedValue(sheetObj.GetCellValue(1,"exp_dt"),"ymd");

     var posEffDay=ComGetUnMaskedValue(formObj.pos_eff_dt.value,"ymd");
     var posExpDay=ComGetUnMaskedValue(formObj.pos_exp_dt.value,"ymd");	                
     // new duration cannot exceed Possible Effective Date duration	                
     if (posEffDay > expDay && expDay !=""){
     	ComShowCodeMessage("PRI01089");
     	return false; 
     }                     
     return true;
 }
 /**
 * Validation check on User Inputted Amendment Effective Date. <br>
 * <br><b>Example :</b>
 * <pre>
 * 		checkAmdEffValidation();
 * </pre>
 * @param  void
 * @return bool  <br>
 *           true  : Can be saved
 *           false : Can not be saved
 * @author 
 * @version 2009.04.17
 */ 	 
 function checkAmdEffValidation(){
     var sheetObj=sheetObjects[0];
     var formObj=document.form; 
	 var amdtDay=sheetObj.GetCellValue(1,"eff_dt");
     var posEffDay=ComGetUnMaskedValue(formObj.pos_eff_dt.value,"ymd");
     var posExpDay=ComGetUnMaskedValue(formObj.pos_exp_dt.value,"ymd");	                
     var msg=" ["+formObj.pos_eff_dt.value + " ~ " + formObj.pos_exp_dt.value +"]"
      // Amend Date < Possible Effective Date or Amend Date <  Possible Expire Date 
     if (amdtDay !="" && ( posEffDay > amdtDay || posExpDay < amdtDay) ){
     	ComShowCodeMessage("PRI01088",msg);
     	formObj.eff_dt.focus();
     	return false;
     }
     return true;
 }