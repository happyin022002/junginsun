/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_2010.js
*@FileTitle  : Time Clock Stop Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================**/
/****************************************************************************************
   Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;	
 ***************************************************************************************/
    // Common Global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var COMMON_TARIFF_CD="common_tariff_cd"; 
    var ROWMARK="|";
    var FIELDMARK="=";
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
     // Event handler processing by button name */
     function processButtonClick(){
        /***** case in Sheet count are more two by Tab, defining adding sheet *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		var srcObj=window.event.srcElement;
 				switch(srcName) {
						case "btns_calendar": //Calendar button
							
				            //if(srcObj.style.cursor == "hand") {
					            var cal=new ComCalendarFromTo();
					            cal.select(formObject.clk_stop_fm_dt,  formObject.clk_stop_to_dt,  'yyyy-MM-dd');
				         	//}
							break;	
 						case "btn_Retrieve":
 							doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    						break;
 						case "btn_New":
 							doActionIBSheet(sheetObject1,formObject,IBCLEAR);
 							break;
 						case "btn_Save":
 							doActionIBSheet(sheetObject1,formObject,IBSAVE);
    						break;
 						case "btn_Cancel":
 							doActionIBSheet(sheetObject1,formObject,IBDELETE);
    						break;
 						case "btn_Print":
 							window.print();
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
			initSheet(sheetObjects[i],i+1);
		}
		// IBMultiCombo initializing 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
		//initializing html control event
		initControl();
		var formObj=document.form;
 		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC01,	comboObjects[0]);
 		doActionIBCombo(sheetObjects[0], formObj, IBROWSEARCH,		comboObjects[1]);
 		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC02,	comboObjects[2]);
		ComSetObjValue(formObj.upd_dt, 	DmtComOfficeCurrDate(sheetObjects[0], formObj)); 
 		//BUTTON MODE
 		DmtComEnableManyBtns(true,  "btn_Retrieve", "btn_New", "btn_Save");  					
 		DmtComEnableManyBtns(false, "btn_Cancel");  
 	}
	function initControl() {
		axon_event.addListenerForm  ('beforedeactivate','obj_deactivate',  form, 'cond_type'); //- out of focus
		axon_event.addListenerFormat('beforeactivate',	'obj_activate',    form); // Get focus
		axon_event.addListenerFormat('keypress',		'obj_keypress',    document.form); //- on press keyboard
		axon_event.addListener('click', 'obj_click', 'cond_type'); 
		axon_event.addListener      ("focusout", "obj_focusout","clk_stop_fm_dt", "clk_stop_to_dt");
	}
	function obj_focusout() {
		var sheetObject=sheetObjects[0];
		var formObj=document.form;
		var obj=event.srcElement;
		var days=getDaysBetween();
		formObj.stop_days.value=days;
	}
	/**
	 * date duration check
	 */
	function getDaysBetween(){
		var formObj=document.form;
		var days="";
		if((formObj.clk_stop_fm_dt.value == "") || (formObj.clk_stop_to_dt.value == "")){
			return days;
		} else {
				days=ComGetDaysBetween(formObj.clk_stop_fm_dt.value, formObj.clk_stop_to_dt.value);
			if(days >= 0) {
				return days+1;
			} else {
				return "";
			}
		}
	}		
    function obj_click() {
    	 doEnableCondObj(event.srcElement.value);
    } 
   // out of focus
    function obj_deactivate(){
        //check inputing Validation + Inserting separator 
        ComChkObjValid(event.srcElement);
    }
    /**
     * HTML Control Foucs in
     */
    function obj_activate(){
        ComClearSeparator(event.srcElement);
    }
	//business javascript OnKeyPress event handling
	function obj_keypress() {
	   	 switch(event.srcElement.dataformat){
	        	case "engup":
					// upper case + numbers 
					ComKeyOnlyAlphabet('uppernum', ',');
					break;
	          	case "engup2":
	 		    	//  upper case + numbers + exceptional letters
	          		DmtComKeyOnlyAlphabet('uppernum', ',');
	 		        break;
	          	case "engup3":
	          		//change upper case
	          		DmtComKeyOnlyAlphabet('upperall')
	          		break; 		        
	          	case "int":
	     	        //only numbers
	     	        ComKeyOnlyNumber(event.srcElement);
	     	        break;
	          	default:
	 	         	// only numbers(integer, date, time)
	 	            ComKeyOnlyNumber(event.srcElement);
	   	 }
    }	
	function getTodate() {
		var today=new Date();
		var year=today.getYear();
		var month=today.getMonth() + 1;
		var day=today.getDate();
		if (month < 10) {
			month="0" + month;
		}
		if (day < 10) {
			day="0" + day;
		}
		var currDate=year + "-" + month + "-" + day;
		return currDate;
	}
    /** 
  	 * IBCombo Object set to an array
  	 * param : combo_obj 
  	 * adding process for list in case of needing batch processing with other items
  	 * defining list on the top of source
  	 */ 
  	function setComboObject(combo_obj) {  
  	    comboObjects[comboCnt++]=combo_obj;  
  	} 
  	/**
  	 * Initializing Combo 
  	 * param : comboObj , comboNo
  	 *  adding case as numbers of counting Combos
  	 */ 
  	function initCombo(comboObj, comboNo) {
  	    var formObject=document.form
  	    switch(comboNo) {  
  	          case 1: 
  	        	with (comboObj) { 
					SetMultiSelect(0);
					SetUseAutoComplete(0);
					SetColBackColor(0, "#CCFFFD");
  					SetColBackColor(1, "#CCFFFD");					
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "50");
					SetColWidth(1, "300");
					//SetFontName("Tahoma");
					SetDropHeight(160);
					ValidChar(2, 2);	// use upper case
  		    	}
  	        	//doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC01,comboObj);
  	        	break;
  	          case 2: 
  	           with (comboObj) { 
					SetMultiSelect(0);
					SetUseAutoComplete(0);
					SetColBackColor(0, "#CCFFFD");
  					SetColBackColor(1, "#CCFFFD");					
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "60");
					SetColWidth(1, "300");
					//SetFontName("Tahoma");
					SetDropHeight(160);
					ValidChar(2, 2);	// use upper case
  		    	}
  				//doActionIBCombo(sheetObjects[0],formObject,IBROWSEARCH,comboObj);
  				break; 
  	          case 3: 
  	  	           with (comboObj) { 
  						SetMultiSelect(1);
  						SetUseAutoComplete(0);
  						SetColBackColor(0, "#CCFFFD");
  	  					SetColBackColor(1, "#CCFFFD");  						
						SetColAlign(0, "left");
						SetColAlign(1, "left");
						SetColWidth(0, "75");
						SetColWidth(1, "295");
  						//SetFontName("Tahoma");
  						SetDropHeight(160);
  						SetMultiSeparator(",");
  						ValidChar(2, 1);	// use upper case
 	  		    	}
  	  				break; 
  	     } 
  	}
  	
  	
  	
  	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj) {
        sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
		        case IBSEARCH_ASYNC01:     
			 		//1. Tariff type comboList
					formObj.f_cmd.value=SEARCHLIST;
					var xmlStr=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
					var data=ComGetEtcData(xmlStr, COMMON_TARIFF_CD);
					if (data != undefined && data != '') {
						var comboItems=data.split(ROWMARK);
						addComboItem(sComboObj,comboItems);
						comboItem=comboItems[0].split(FIELDMARK);
					}	
				break;	
		        case IBROWSEARCH:    
					//2. Office comboList
					formObj.f_cmd.value=SEARCHLIST02;
					var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
		    	    if (sXml != undefined && sXml != '') {
			    	    var ofc_cds=ComGetEtcData(sXml, "OFC_CD");
			    	    var ofc_nms=ComGetEtcData(sXml, "OFC_NM");
			    	    var comboCodeArr=ofc_cds.split("|");			    	    
			    	    var comboTextArr=ofc_nms.split("|");
			    	    var comboObj=comboObjects[1];
			    	    for (var i=0 ; i < comboTextArr.length ; i++) {
			    	    	comboObj.InsertItem(i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
			         	}
		    	    }
				break;
		        case IBSEARCH_ASYNC02:
		        	//3. Office 별 yard comboList
					formObj.f_cmd.value=SEARCH03;
					formObj.clk_stop_ofc_cd.value=comboObjects[1].GetSelectText();
					var sXml=sheetObj.GetSearchData("EES_DMT_2010GS.do", FormQueryString(formObj));
					
					if (sXml != undefined && sXml != '') {
			    	    var yard_cds=ComGetEtcData(sXml, "YARD_CD");
			    	    var yard_nms=ComGetEtcData(sXml, "YARD_NM");
			    	    if(yard_cds != undefined && yard_cds != '') {
			    	    	comboObjects[2].SetSelectCode("-1");
                            comboObjects[2].RemoveAll();
				    	    var comboCodeArr=yard_cds.split("|");			    	    
				    	    var comboTextArr=yard_nms.split("|");
				    	    var comboObj=comboObjects[2];
				    	    for (var i=0 ; i < comboTextArr.length ; i++) {
				    	    	comboObj.InsertItem(i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
				         	}
			    	    }
					}
        }
		sheetObj.SetWaitImageVisible(1);
    }
    /**
    * Data in the field adds a combo.
    */	
	function addComboItem(comboObj,comboItems) {
	   	for (var i=0 ; i < comboItems.length ; i++) {
	   		var comboItem=comboItems[i].split(FIELDMARK);
				comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
	   	}   		
	}
	/**
	 * onchange : tariff detail <br>
	 * @param None
	 * @return None
	 * @see #
	 * @author
	 */
	//comboObj, Index_Code, Text
	//OldIndex, OldText, OldCode, NewIndex, NewText, NewCode
	function combo1_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) {
		var formObj=document.form;
		var textValue=NewCode;
		document.form.dmdt_trf_nm.value=textValue;
	} 
	/**
	 * onchange : office detail <br>
	 * @param None
	 * @return None
	 * @see #
	 * @author
	 */
	function combo2_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) {
		var formObj=document.form;
		var textValue=comboObj.GetText(Number(NewIndex), 1);
		document.form.clk_stop_ofc_nm.value=textValue;
		//combo3 initializing
		document.form.clk_stop_yd_nm.value="";
		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC02,	comboObjects[2]);
	}	 
	
	var selComboIndex, selComboCode;
	function combo3_OnSelect(comboObj ,index, code) {
		selComboIndex = index;
		selComboCode = code;
	}
	function combo3_OnChange(comboObj) {
	    setMultiCombo(combo3, selComboIndex, selComboCode);
	    
//	    if(selComboIndex==0) {
	    if ( comboObj.GetItemCheck(0) ){
	    	document.form.all_yd_flg.value="Y";
	    }else{
	    	document.form.all_yd_flg.value="N";
	    }
	    
		document.form.clk_stop_yd_nm.value=comboObj.GetSelectCode();
	}
	
	
	
    /*function combo3_OnCheckClick(comboObj, index, code) {
    	
	    setMultiCombo(comboObj, index, code) ;
	    if(index==0) {
	    	document.form.all_yd_flg.value="Y";
	    }else{
	    	document.form.all_yd_flg.value="N";
	    }
	    
		document.form.clk_stop_yd_nm.value=comboObj.GetSelectCode();
		
    }*/
   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
		 var sheetID=sheetObj.id;
         switch(sheetID) {
             case "sheet1":
            	    with(sheetObj){
               }

              
                 break;
         }
     }
     // Process of Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg(false);
    	 switch(sAction) {
    	 	case IBSEARCH:     
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
    	 		var sRhqOfcCd=formObj.rhq_ofc_cd.value;
				formObj.f_cmd.value=SEARCH01;
				var xmlStr=sheetObj.GetSearchData("EES_DMT_2010GS.do", FormQueryString(formObj));
				if(undefined != ComGetEtcData(xmlStr, "clk_stop_no")){
					initSearchControls("SEARCH");
					searchSetting(xmlStr);
					buttonMode("IBSEARCH"); 
					var cxl_flg=formObj.cxl_flg.value;
					if(cxl_flg == 'Live'){
						DmtComEnableManyBtns(true,  "btn_Retrieve", "btn_New", "btn_Cancel");  								
						DmtComEnableManyBtns(false, "btn_Save");  
					} else if(cxl_flg == 'Cancelled'){
						DmtComEnableManyBtns(true,  "btn_Retrieve", "btn_New");  								
						DmtComEnableManyBtns(false, "btn_Save", "btn_Cancel");  
					} 
				} else {
					initSearchControls("SEARCH");
					ComShowCodeMessage("DMT06001");
				}
			break;
			case IBCLEAR:       //initializing 
				initSearchControls("CLEAR");
				buttonMode("IBCLEAR");
				DmtComEnableManyBtns(true,  "btn_Retrieve", "btn_New", "btn_Save");  								
				DmtComEnableManyBtns(false, "btn_Cancel");  
				ComSetObjValue(formObj.upd_dt, 	DmtComOfficeCurrDate(sheetObjects[0], formObj)); 
			break;
			case IBSAVE:   
				if(formObj.button_mode.value == 'IBCLEAR' || formObj.button_mode.value == ''){
					formObj.dmdt_trf_cd.value=comboObjects[0].GetSelectText();
					formObj.clk_stop_ofc_cd.value=comboObjects[1].GetSelectText();
					formObj.clk_stop_yd_cd.value=comboObjects[2].GetSelectText();
					if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
					}
					if(!validateDate(formObj)){
						return false;
					}
					if(!validateLength(formObj)){
						return false;
					}
					if(!ComShowCodeConfirm('DMT00135', 'save')){
						return false;
					}
					ComOpenWait(true);
					sheetObj.SetWaitImageVisible(0);
					formObj.f_cmd.value=COMMAND01;
					var sXml=sheetObj.GetSearchData("EES_DMT_2010GS.do", FormQueryString(formObj));
					var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey")
					if (backendJobKey.length > 0) {
						formObj.backendjob_key.value=backendJobKey;
						sheetObj.SetWaitImageVisible(0);
						sheetObj.SetWaitTimeOut(10000);
						timer=setInterval(getBackEndJobStatus, 3000); // After three seconds, running getBackEndJobStatus function - a recursive call
					}
				}
				//button mode - 2010.04.09
				DmtComEnableManyBtns(true,  "btn_New", "btn_Retrieve", "btn_Cancel" );  								
				DmtComEnableManyBtns(false,  "btn_Save"); 
				ComEnableManyObjects(false, formObj.clk_stop_no);
				formObj.clk_stop_no.className='input1'; 
			break;
			case IBDELETE:      
				if(formObj.auth_yn.value == 'Y'){ 
					if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
					}
					//formObj.f_cmd.value = MULTI02;	
					var cxl_flg=formObj.cxl_flg.value;
					if(cxl_flg == 'Live'){
						if(!ComShowCodeConfirm('DMT00135', 'cancel')){
							return false;
						}
						//sheetObj.GetSearchXml("EES_DMT_2010GS.do", FormQueryString(formObj));
						ComOpenWait(true);
						sheetObj.SetWaitImageVisible(0);
						formObj.f_cmd.value=COMMAND11;
						var sXml=sheetObj.GetSearchData("EES_DMT_2010GS.do", FormQueryString(formObj));
						var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey")
						if (backendJobKey.length > 0) {
							formObj.backendjob_key.value=backendJobKey;
							sheetObj.SetWaitImageVisible(0);
							sheetObj.SetWaitTimeOut(10000);
							timer=setInterval(getCancelBackEndJobStatus, 3000); // After three seconds, running getBackEndJobStatus function - a recursive call
						}
						//doActionIBSheet(sheetObj,formObj,IBSEARCH);		
						//buttonMode("IBSEARCH");
					} else {
						ComShowCodeMessage('DMT00106');
					}
				} else {
					ComShowCodeMessage('DMT00112');
				}
				//button mode - 2010.04.09
				DmtComEnableManyBtns(true,  "btn_New" , "btn_Retrieve");  								
				DmtComEnableManyBtns(false, "btn_Save", "btn_Cancel"); 
				ComEnableManyObjects(false, formObj.clk_stop_no);
				formObj.clk_stop_no.className='input1'; 
			break;
		}
     }
     /// BACK END JOB Create Start ////////////////////////////////////////////
     /**
     * Status of BackEndJob a '3 'to make sure when.
     */
    function getBackEndJobStatus() {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
       	formObj.f_cmd.value=COMMAND02; //It gets a status of backendjob. 2
       	sheetObjects[0].SetWaitImageVisible(0);
       	var sXml=sheetObj.GetSearchData("EES_DMT_2010GS.do", FormQueryString(formObj));
       	var jobState=ComGetEtcData(sXml, "jb_sts_flg")
       	// alert("sheet1 :::>> jobState : "+jobState);
       	if (jobState == "3") {
       		clearInterval(timer);
       		getBackEndJobLoadFile();
       	} else if (jobState == "4") {
       		// Failure BackEndJob.
       		clearInterval(timer);
       		ComShowCodeMessage('DMT01125');
			ComOpenWait(false);
			doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
			DmtComEnableManyBtns(true,  "btn_Retrieve", "btn_New", "btn_Save");  								
			DmtComEnableManyBtns(false, "btn_Cancel");
       	} else if (jobState == "5") {
       		// BackEndJob already have read the resulting file.
       		clearInterval(timer);
       		ComShowCodeMessage('DMT01125');
			ComOpenWait(false);
			doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
			DmtComEnableManyBtns(true,  "btn_Retrieve", "btn_New", "btn_Save");  								
			DmtComEnableManyBtns(false, "btn_Cancel");
       	}
     }
     function getBackEndJobLoadFile() {
    	 formObj=document.form;
    	 formObj.f_cmd.value=MULTI01; //It returns a result. 3 
    	 ComOpenWait(false);
    	 var sheetObj=sheetObjects[0];
    	 //ComOpenWait Start
		 sheetObj.SetWaitImageVisible(0);
	     ComOpenWait(true);
	     var sXml=sheetObj.GetSearchData("EES_DMT_2010GS.do", FormQueryString(formObj));
    	 //ComOpenWait End
		 ComOpenWait(false);
    	 if("Y" != ComGetEtcData(sXml, "dup_yn")){
    		 searchSetting(sXml);
    	 } else {
    		 ComShowCodeMessage("DMT00105");
    		 DmtComEnableManyBtns(true,  "btn_Retrieve", "btn_New", "btn_Save");  								
 			 DmtComEnableManyBtns(false, "btn_Cancel");
    	 }   	
     } 
     /// BACK END JOB Create End ////////////////////////////////////////////  
     /// BACK END JOB Cancel Start ////////////////////////////////////////////
      /**
      * Status of BackEndJob a '3 'to make sure when.
      */
     function getCancelBackEndJobStatus() {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
       	formObj.f_cmd.value=COMMAND22; //It gets a status of backendjob. 2
       	sheetObjects[0].SetWaitImageVisible(0);
       	var sXml=sheetObj.GetSearchData("EES_DMT_2010GS.do", FormQueryString(formObj));
       	var jobState=ComGetEtcData(sXml, "jb_sts_flg")
       	// alert("sheet1 :::>> jobState : "+jobState);
       	if (jobState == "3") {
       		clearInterval(timer);
       		getCancelBackEndJobLoadFile();
       	} else if (jobState == "4") {
       		// Failure BackEndJob.
       		clearInterval(timer);
       		ComShowCodeMessage('DMT01125');
			ComOpenWait(false);
			doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
			DmtComEnableManyBtns(true,  "btn_Retrieve", "btn_New");  								
			DmtComEnableManyBtns(false, "btn_Cancel", "btn_Save");
       	} else if (jobState == "5") {
       		// BackEndJob already have read the resulting file.
       		clearInterval(timer);
       		ComShowCodeMessage('DMT01125');
			ComOpenWait(false);
			doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
			DmtComEnableManyBtns(true,  "btn_Retrieve", "btn_New");  								
			DmtComEnableManyBtns(false, "btn_Cancel", "btn_Save");
       	}
      }
      function getCancelBackEndJobLoadFile() {
    	  formObj=document.form;
    	  formObj.f_cmd.value=MULTI02; //It returns a result. 3 
    	  ComOpenWait(false);
    	  var sheetObj=sheetObjects[0];
    	  //ComOpenWait Start
 		  sheetObj.SetWaitImageVisible(0);
 	      ComOpenWait(true);
 	      var sXml=sheetObj.GetSearchData("EES_DMT_2010GS.do", FormQueryString(formObj));
    	  //ComOpenWait End
 		  ComOpenWait(false);
    	  if("Y" == ComGetEtcData(sXml, "cxl_flg")){
    		  doActionIBSheet(sheetObj,formObj,IBSEARCH);		
    		  buttonMode("IBSEARCH");
    	  }
      }   
      /// BACK END JOB Cancel End ////////////////////////////////////////////  
	/**
	  * handling process for input validation
	  */
	function validateForm(sheetObj,formObj,sAction){
		if(IBSEARCH == sAction || IBDELETE == sAction){
		    if(formObj.clk_stop_no.value.trimAll().lengthByte() <= 0){
			    ComShowCodeMessage('DMT02002', "Clock Stop No");
				ComSetFocus(formObj.clk_stop_no);
				return false;
			}
		} else if(IBSAVE == sAction ){
			if(formObj.dmdt_trf_cd.value.trimAll().lengthByte() <= 0){
			    ComShowCodeMessage('DMT02002', "Tariff Type");
				ComSetFocus(formObj.dmdt_trf_cd);
				return false;
			} else if(formObj.clk_stop_ofc_cd.value.trimAll().lengthByte() <= 0){
			    ComShowCodeMessage('DMT02002', "Office");
				ComSetFocus(formObj.clk_stop_ofc_cd);
				return false;
			} else if(formObj.clk_stop_yd_cd.value.trimAll().lengthByte() <= 0){
			    ComShowCodeMessage('DMT02002', "Yard");
				ComSetFocus(formObj.clk_stop_yd_cd);
				return false;
			} else if(formObj.clk_stop_fm_dt.value.trimAll().lengthByte() <= 0){
			    ComShowCodeMessage('DMT02002', "Stop Period");
				ComSetFocus(formObj.clk_stop_fm_dt);
				return false;
			} else if(formObj.clk_stop_to_dt.value.trimAll().lengthByte() <= 0){
			    ComShowCodeMessage('DMT02002', "Stop Period");
				ComSetFocus(formObj.clk_stop_to_dt);
				return false;
			} else if(formObj.clk_stop_rmk.value.trimAll().lengthByte() <= 0){
				ComShowCodeMessage('DMT02002', "Remark");
				ComSetFocus(formObj.clk_stop_rmk);
				return false;
			}
		}
		return true;
	}
	/**
	  * check validation date type 
	  */
	function validateDate(formObj){
		if(ComChkPeriod(formObj.clk_stop_fm_dt.value, formObj.clk_stop_to_dt.value) > 0){
			if(ComGetDaysBetween(formObj.clk_stop_fm_dt.value, formObj.clk_stop_to_dt.value) > 21){
				ComShowCodeMessage('DMT00103');
				return false;
			}
		} else if (ComChkPeriod(formObj.clk_stop_fm_dt.value, formObj.clk_stop_to_dt.value) <= 0){
			ComShowCodeMessage('DMT01020');
			return false;
		} 
		return true;
	}
	/**
	  * check validation text length
	  */
	function validateLength(formObj){
		if(formObj.clk_stop_rmk.value.trimAll().lengthByte() > 501){
			ComShowCodeMessage('DMT00104');
			ComSetFocus(formObj.clk_stop_rmk);
			return false
		}
		return true;
	} 
	/**
	  * INIT SETTING
	  */
	function initSearchControls(flag) {
		var formObj=document.form;
		if(flag == 'CLEAR'){  
			ComClearObject(formObj.clk_stop_no);
	    	comboObjects[2].SetSelectCode("-1");
            comboObjects[2].RemoveAll();
		}
		ComClearObject(formObj.cxl_flg);
		ComClearObject(formObj.dmdt_trf_cd);
		comboObjects[0].SetSelectText("");
		ComClearObject(formObj.dmdt_trf_nm);
		ComClearObject(formObj.clk_stop_ofc_cd);
		comboObjects[1].SetSelectText("");
		ComClearObject(formObj.clk_stop_ofc_nm);
		ComClearObject(formObj.clk_stop_yd_cd);
		comboObjects[2].SetSelectText("");
		ComClearObject(formObj.clk_stop_yd_nm);
		ComClearObject(formObj.all_yd_flg);
		ComClearObject(formObj.clk_stop_fm_dt);
		ComClearObject(formObj.clk_stop_to_dt);
		ComClearObject(formObj.stop_days);
		formObj.upd_usr_id.value=formObj.s_usr_nm.value;
		formObj.upd_ofc_cd.value=formObj.s_ofc_cd.value;
		formObj.upd_dt.value=formObj.s_cre_dt.value;
		formObj.clk_stop_rmk.value="";
	}
	/**
	  * SEARCH SETTING
	  */
	function searchSetting(xmlStr) {
		var formObj=document.form;
		formObj.clk_stop_no.value=undefinedToNull(ComGetEtcData(xmlStr, "clk_stop_no"));		
		formObj.cxl_flg.value=undefinedToNull(ComGetEtcData(xmlStr, "cxl_flg"));
		comboObjects[0].SetSelectText(undefinedToNull(ComGetEtcData(xmlStr, "dmdt_trf_cd")));
		formObj.dmdt_trf_cd.value=undefinedToNull(ComGetEtcData(xmlStr, "dmdt_trf_cd"));
		formObj.dmdt_trf_nm.value=undefinedToNull(ComGetEtcData(xmlStr, "dmdt_trf_nm"));
		formObj.clk_stop_ofc_cd.value=undefinedToNull(ComGetEtcData(xmlStr, "clk_stop_ofc_cd"));
		comboObjects[1].SetSelectText(undefinedToNull(ComGetEtcData(xmlStr, "clk_stop_ofc_cd")));
		formObj.clk_stop_ofc_nm.value=undefinedToNull(ComGetEtcData(xmlStr, "clk_stop_ofc_nm"));
		formObj.clk_stop_yd_cd.value=undefinedToNull(ComGetEtcData(xmlStr, "clk_stop_yd_cd"));
		comboObjects[2].SetSelectText(undefinedToNull(ComGetEtcData(xmlStr, "clk_stop_yd_cd")));
		formObj.clk_stop_yd_nm.value=undefinedToNull(ComGetEtcData(xmlStr, "clk_stop_yd_nm"));
		formObj.clk_stop_fm_dt.value=undefinedToNull(ComGetEtcData(xmlStr, "clk_stop_fm_dt"));
		formObj.clk_stop_to_dt.value=undefinedToNull(ComGetEtcData(xmlStr, "clk_stop_to_dt"));
		formObj.stop_days.value=undefinedToNull(ComGetEtcData(xmlStr, "stop_days"));
		formObj.clk_stop_rmk.value=undefinedToNull(ComGetEtcData(xmlStr, "clk_stop_rmk"));
		formObj.upd_dt.value=undefinedToNull(ComGetEtcData(xmlStr, "upd_dt"));
		formObj.upd_ofc_cd.value=undefinedToNull(ComGetEtcData(xmlStr, "upd_ofc_cd"));
		formObj.upd_usr_id.value=undefinedToNull(ComGetEtcData(xmlStr, "upd_usr_id"));
		formObj.auth_yn.value=undefinedToNull(ComGetEtcData(xmlStr, "auth_yn"));
//		alert("[formObj.auth_yn.value]"+formObj.auth_yn.value);
		buttonMode("IBSEARCH");
	}
	/**
	 * Replace from undefined TO ''
	 */
	function undefinedToNull(str){
		var returnVal="";
		if(undefined == str){
			returnVal="";
		} else {
			returnVal=str;
		}
		return returnVal;
	}
	/**
	  * Button Event setting
	  */
	function buttonMode(mode) {
		if(mode == "IBSEARCH"){
			var formObj=document.form;
			with (formObj) {
				ComEnableManyObjects(false, clk_stop_fm_dt, clk_stop_to_dt, btns_calendar);
				ComEnableManyObjects(false, clk_stop_no);
				comboObjects[0].SetEnable(0);
				comboObjects[1].SetEnable(0);
				comboObjects[2].SetEnable(0);
				formObj.clk_stop_no.className='input2'; 
				formObj.clk_stop_fm_dt.className='input2';
				formObj.clk_stop_to_dt.className='input2';
				formObj.clk_stop_rmk.className='noinput2'; //textarea2
				formObj.clk_stop_rmk.readOnly=true;
			}
			formObj.button_mode.value="IBSEARCH";
		} else if(mode == "IBCLEAR"){
			var formObj=document.form;
			with (formObj) {
				ComEnableManyObjects(true, clk_stop_fm_dt, clk_stop_to_dt, btns_calendar);
				ComEnableManyObjects(true, clk_stop_no);
				comboObjects[0].SetEnable(1);
				comboObjects[1].SetEnable(1);
				comboObjects[2].SetEnable(1);
				formObj.clk_stop_no.className='input'; 
				formObj.clk_stop_fm_dt.className='input1';
				formObj.clk_stop_to_dt.className='input1';
				formObj.clk_stop_rmk.className='noinput1';  //textarea1
				formObj.clk_stop_rmk.readOnly=false
			}
			formObj.button_mode.value="IBCLEAR";
		} 
	} 
