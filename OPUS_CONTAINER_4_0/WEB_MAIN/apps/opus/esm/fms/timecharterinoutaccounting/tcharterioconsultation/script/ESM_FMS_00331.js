/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_00331.js
*@FileTitle  : RCS / Invoice No Inquiry - Window
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
    // common global variables 
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event*/
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		var sheetObject=sheetObjects[0];
		var sheetObject1=sheetObjects[1];
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_Confirm":
					comPopupOK();
					break;
				case "btn_New":
					ComResetAll();
					break;
				case "btn_vslCd":
     				ComOpenPopup("ESM_FMS_0022.do", 520, 470, "setVslCd", "1,0,1,1,1", true, false, null, null, null, "esm_fms_0022");
     				break;
     			case "btn_fletCtrtNo":
     				if(formObject.vsl_cd.value == "") {
     					ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01231'));
     					return;
     				}
     				var param="typeFlag=" + "TO" + "&vsl_cd=" + formObject.vsl_cd.value;
     				ComOpenPopup("ESM_FMS_0023.do?" + param, 520, 415, "setContractNo", "1,0,1,1,1", true, false, null, null, null, "esm_fms_0023");
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
     * * adding first-served functions after loading screen. 
     */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
	}
   /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	switch(sheetNo) {
        	case 1:      //t1sheet1 init
        		with (sheetObj) {
                
                var HeadTitle="||Seq|Invoice No.|CSR Number";
                var headCount=ComCountHeadTitle(HeadTitle);
                SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Radio",     Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"radio",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"CheckBox",  Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"check",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
                       {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"to_inv_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"csr_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                InitColumns(cols);
                SetEditable(1);
                SetSheetHeight(240);
        	}
        	break;
    	}
    }
    /**
     * Handling IBSheet's process<br>
     */
    function doActionIBSheet(sheetObj,formObj,sAction,objNm) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      
    			if(objNm == "vsl_cd") {
        			formObj.f_cmd.value=SEARCH01;
        			var param=FormQueryString(formObj);
        			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do", param);
    	   			var vslEngNm=ComGetEtcData(sXml, "vslEngNm");        	   			
    	   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
    	   				formObj.vsl_eng_nm.value=vslEngNm;
    	   				form.flet_ctrt_no.value="";
    	   				
    	   				initDefaultContractNo(); //NYK Modify 2014.10.21
    				} else {
    					//form.btn_vslCdClr.checked = false;
    					formObj.vsl_cd.value="";
    					form.flet_ctrt_no.value="";
    					ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS00006", "Vessel Code"));
    					return;
    				}
    			} else {
    				if(validateForm(sheetObj,formObj,sAction)) {
	        			formObj.f_cmd.value=SEARCH;
	        			sheetObj.DoSearch("ESM_FMS_00331GS.do", FormQueryString(formObj) );
    				}
    			}
                break;
        	case IBSAVE:        
              	if(validateForm(sheetObj,formObj,sAction))
              		alert (" Save .. ");
                break;
			case IBINSERT:      
                break;

            	
			case IBSEARCH_ASYNC02: //NYK Modify 2014.10.21				
				if(formObj.vsl_cd.value == "") return;				
				var f_query = "";					
				f_query += "f_cmd=" + SEARCH01; 
				f_query += "&vsl_cd="+formObj.vsl_cd.value;	 			
				f_query += "&type_flag="+gFletCtrtTpCdAll;  			
				f_query += "&order_priority="+gOrderPriorityTO; 
				
				var sXml = sheetObj.GetSearchData("FMS_COMGS.do",f_query);

	   			var varFletCtrtNo = ComGetEtcData(sXml, "flet_ctrt_no");
	   			
	   			if(typeof varFletCtrtNo != "undefined" && varFletCtrtNo != "" ) {
					formObj.flet_ctrt_no.value = varFletCtrtNo;
				}else{
					ComShowCodeMessage("FMS20001","Agreement");
					clearAll();
					return;
				}
				if(formObj.flet_ctrt_no.value != ""){
					//contract_no_change();
				}
				break;
        }
    }
    /**
     * Handling process for input validation<br>
     */
    function validateForm(sheetObj,formObj,sAction){
    	/*if(formObj.vsl_cd.value != "") {
    		exptElems="csr_no";
    		if (!ComFmsChkValid(formObj, exptElems)) {
    	    	return false;
    	    }
    	}*/
        return true;
    }
    /**
  	 * Loading Event of HTML_Control existing on page dynamically <br>
  	 * Calling the function from {@link #loadPage} to initialize IBSheet Object <br>
  	 * @param {ibsheet} sheetObj    IBSheet Object
  	 * @param {int}     sheetNo     sequence of sheetObjects array
  	 **/
  	function initControl() {
  		//Axon Event Handling1. Event catch
  		//axon_event.addListenerForm  ('blur'		, 'obj_blur', form); 				//- form Code Handling to OnBeforeDeactivate(blur) Event of All Controls
  		//axon_event.addListenerFormat('keypress'	, 'obj_keypress', form); 			//- form Code Handling to onkeypress Event of All Controls having dataformat attribute
  		//axon_event.addListenerForm  ('keypress'	, 'eng_keypress', form); 			//- form Code Handling to onkeypress Event of All Controls
  		axon_event.addListenerForm  ('change'	, 'obj_change', form); 				//- form Code Handling to OnChange Event of All Controls
  	}
//    /**
//     * Only insert Numeric by onkeypress Event of HTML Control<br>
//     **/
//    function obj_keypress() {
//    	switch(event.srcElement.dataformat){
// 			case "int":
// 		        ComKeyOnlyNumber(event.srcElement);
// 				break;
// 			case "float":
// 		        ComKeyOnlyNumber(event.srcElement, ".");
// 				break;
//     	}
//    }
//    /**
//     * Only insert English and Numefic by onkeypress Event of HTML Control<br>
//     **/
//    function eng_keypress() {
//    	if((event.srcElement.name == "vsl_cd")) { 
//     		ComKeyOnlyAlphabet('upper');
//     	} else if((event.srcElement.name == "csr_no")) { 
//     		ComKeyOnlyAlphabet('upper', '48|49|50|51|52|53|54|55|56|57');
//     	}
//    }
    /**
     * Getting Vessel Name from onchange Event of HTML Control<br>
     */
 	function obj_change() {
 		if((event.srcElement.name == "vsl_cd")) {
 			if(form.vsl_cd.value.length == 4) {
	 	    	form.vsl_eng_nm.value="";
	 	    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"vsl_cd");
 			}
 		}
 	}
    /**
  	 * Setting Vessel Code and Name selected in Vessel Code PopUp into Form item<br>
  	 */
  	function setVslCd(aryPopupData) {
  		form.vsl_cd.value=aryPopupData[0][2];
  		form.vsl_eng_nm.value=aryPopupData[0][3];
  		
  		//NYK Modify 2014.10.21
		if(form.vsl_cd.value != ""){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"vsl_cd");
		}
  	}
  	/**
 	 * Setting Contract No. selected in Contract Code PopUp into Form item<br>
 	 */
 	function setContractNo(aryPopupData){
 		form.flet_ctrt_no.value=aryPopupData[0][3];
 	}
// 	/**
//     * Checking Validation of CSR No. in onblur Event of HTML Control<br>
//     **/
//    function obj_blur() {
//    	if(event.srcElement.name == "csr_no") {
//    		ComChkObjValid(event.srcElement);
//       	} else {
//       		ComChkObjValid(event.srcElement);
//       	}
//    }
    
    //NYK Modify 2014.10.21
    function initDefaultContractNo(){
  	  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);   
    }
    
    function clearAll(flag){
 		//NYK Modify 2014.10.21
		switch(flag){
			case "CTRT" :
				var tmpVslCd = form.vsl_cd.value;
				var tmpVslEngNm = form.vsl_eng_nm.value;
				ComResetAll();
				form.vsl_cd.value = tmpVslCd;
				form.vsl_eng_nm.value = tmpVslEngNm;
				break;
			default :
				ComResetAll();
				break;
		}
 	}
