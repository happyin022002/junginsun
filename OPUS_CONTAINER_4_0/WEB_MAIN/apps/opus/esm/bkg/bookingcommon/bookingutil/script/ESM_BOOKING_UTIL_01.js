/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BOOKING_UTIL_01.js
*@FileTitle : Query Execution
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
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
     * @extends 
     * @class ESM_BOOKING_UTIL_01:  business script for ESM_BOOKING_UTIL_01
     */
    function ESM_BOOKING_UTIL_01() {
    	alert(0);
    	this.processButtonClick	= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				  = loadPage;
    	this.initSheet 				  = initSheet;
    	this.initControl        = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;

    }
    
   
     /**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }
     
     
 // Common global variable
 var sheetObjects = new Array();
 var sheetCnt = 0;
 var rowsPerPage = 50;
 
 var prefix = "sheet1_";//IBSheet Delimiter
 
 
 var grp_cd ="";//Current Queue the global variable for retrieve  
 var queueMap = new Array();
 
  /*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt = 0;
 	var comboObjects = new Array();
	
     
	//registering IBCombo Object as list
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj;
 	} 	
	


  	
	
 /*********************** EDTITABLE MULIT COMBO END********************/ 
 
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
    	var formObject = document.form;

        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- Keyboard input
        axon_event.addListenerFormat  ('beforedeactivate', 'bkg_deactivate',  formObject); //- Focus Out
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- Focus In
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }        
    
    

 /*********************** KEY EVENT START ********************/ 	 
	function bkg_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "engup":
	        //English uppercase characters
    			ComKeyOnlyAlphabet('upper');
	        break;
	      case "engupnum":
	        //the number + English capital letter
	      	ComKeyOnlyAlphabet('uppernum');
	        break;
	      case "num":
	        //Numeric input
	        ComKeyOnlyNumber(event.srcElement);
	        break;	            
	      case "custname":
	        //Numeric input
	        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
	        break;	            
	      default:
	    }
	}  
	
	  /**
     * HTML Control  onBlur Event
     **/
    function bkg_deactivate() {
    	
    	var formObj = document.form;    	
	    switch (event.srcElement.getAttribute("name")) {
	    	case "dura_from_dt":
	    		ComAddSeparator(event.srcElement);
					break;
	    	case "dura_to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
    		
				default:
					break;
	    }
    }        

	/**
	 * The onFocus event in HTML Control Validation Check. <br>
	 **/
	function bkg_activate(){
		//Input Validation to check
		switch(event.srcElement.name){	
	    	case "dura_from_dt":
	    		ComClearSeparator(event.srcElement);
				break;
	    	case "dura_to_dt":
	    		ComClearSeparator(event.srcElement);
				break;
			default:
				break;
		}
	}  

/*********************** KEY EVENT END ********************/

  
// Event handler processing by button click event */
 		document.onclick  = processButtonClick;

 // Event handler processing by button name */
     function processButtonClick(){
          /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
          var sheetObject1 = sheetObjects[0];
					
          /*******************************************************/
          var formObject = document.form;

	     	try {
	     		
	     		var srcName = window.event.srcElement.getAttribute("name");
	     		
		 			switch(srcName) {
		 				case "btn_execute":
		 					doActionIBSheet(sheetObject1,formObject,MODIFY);
		 					break;	
		 				case "btn_Close":
		 					self.close();
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
 
 
 	

   // Sheet handling process
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
    				case IBSEARCH:      
							break;
							
						case MODIFY:        //Save
				 				formObj.f_cmd.value = MODIFY;
								result.innerHTML ="";
				 				if(!validateForm(sheetObj,formObj,sAction)) return;
				 				var sParam = "&"+ FormQueryString(formObj);
								var sXml = sheetObj.GetSaveData("ESM_BKG_0000GS.do" , sParam);
								if(sXml == '' || sXml.length < 7) return;
								if(sXml.substring(1, 6) == "ERROR"){
									alert(ComResultMessage(sXml).split('<||>').join('\n'));
									return;
								}
								result.innerHTML = "<pre>"+ComReplaceStr(ComGetEtcData(sXml, "result"),"ERROR","<font color='red'>[ERROR]</font>") +"</pre>";
			 				break;									
									
			    }
     }
     
     
     

     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		
    		case MODIFY:
	    		if ( ComIsNull(formObj.sql)) {
	    			return false;
	    			break;
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
         switch(sheetNo) {
             case 1:      //sheet1 init
            	    with(sheetObj){
                 
	               //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	               var HeadTitle1="SEQ";
	               var headCount=ComCountHeadTitle(HeadTitle1);
	               (headCount, 0, 0, true);
	
	               SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	               var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	               InitHeaders(headers, info);
	
	               var cols = [ {Type:"Text",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix + "Seq" } ];
                
	               InitColumns(cols);
	               SetEditable(1);	               
	               SetSheetHeight(330);
	               SetColProperty(0 , 3, {AcceptKeys:"E|N|[_]" , InputCaseSensitive:1});
               }
               break;
         }
     }  
    

	    