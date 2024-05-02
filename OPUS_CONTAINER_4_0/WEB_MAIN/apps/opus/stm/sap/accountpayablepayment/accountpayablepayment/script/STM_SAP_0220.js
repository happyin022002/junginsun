/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :STM_SAP_0220.js
*@FileTitle  : Create Accounting Entries
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================*/
/****************************************************************************************
     Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                  MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;				
 ***************************************************************************************/
    /**
     * @extends 
     * @class Invoices : business script for STM_SAP_0220
     */

	var focusObj=null;
	// public variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		/*******************************************************/
		var formObj=document.form;
		var sheetObject1=sheetObjects[0];
     	try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
 				case "btn_capture":
 					doActionIBSheet(sheetObject1, formObj, IBSAVE);
 					break;
	    	    case "btn_new" :
	    	    	formObj.reset();
	    	    	sheetObjects[0].RemoveAll();
					comboObjects[0].RemoveAll();
	    	    	doActionIBSheet(sheetObject1, formObj, COMMAND01);
	    	    	break;
 				case "btn_delete":
 					doActionIBSheet(sheetObject1, formObj, IBDELETE);
 					break;
 				 case "btn_downexcel":
 	    	    	if(sheetObjects[0].RowCount() < 1){//no data 
 	    	    		 ComShowCodeMessage("COM132501");
 		    		}else{ 
 		    			sheetObjects[0].Down2Excel({ HiddenColumn:1, Merge:1});
 		    		}
 	    	    	break;
 				case "btns_calFr":
					var cal=new ComCalendar();
					cal.select(formObj.acctg_fr_dt, 'yyyy-MM-dd');
					break;					
				case "btns_calTo":
					var cal=new ComCalendar();
					cal.select(formObj.acctg_to_dt, 'yyyy-MM-dd');
					break;	
				case "btns_calMm":
					var cal=new ComCalendar();
					cal.setDisplayType('month');
					cal.select(formObj.capture_period_mm, 'yyyy-MM');
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
	 * registering IBCombo Object as list
	 * @param combo_obj
	 * @return
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
	function loadPage() {
		var formObj=document.form;
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		initControl();
		doActionIBSheet(sheetObjects[0], document.form, COMMAND01);  
		acctg_evnt_tp_cd.SetSelectIndex(0);
	}
	/**
	 * Combo Setting default
	 * @param	{IBMultiCombo}	combo_obj.
	 * @param	{Number}	comboNo		Sequence number from combo object tag id
	 */
	function initCombo (comboObj, comboNo) {
	    //var cnt  = 0 ;
	    var formObject=document.form
	    switch(comboNo) {
			   case 1:
		           with (comboObj) {
			       }
	           break;
			   default :
		           with (comboObj) {
			       }
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
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		switch(sheetNo) {
			case 1:      // sheet1 init
			    with(sheetObj){
				      var HeadTitle1="|Accounting Source|Accounting Event|Accounting Date|Event Line Number|Currency|COA Company Code|COA Region Code|COA Center Code|COA Account Code|COA VVD Code|COA Inter Company Code|Entered DR|Entered CR|Accounted DR|Accounted CR|Exchange Rate|Reference Key|Accounting Description";
				      HeadTitle1=HeadTitle1 + "|ATTR_CTNT1|Accounting Error|ATTR_CTNT2|ATTR_CTNT3|ATTR_CTNT4|ATTR_CTNT6|ATTR_CTNT7|ATTR_CTNT8|ATTR_CTNT9|ATTR_CTNT10|ACCTG_EVNT_SEQ|ACCTG_HDR_SEQ";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:1,   SaveName:"acctg_evnt_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"acctg_evnt_cate_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"acctg_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"acctg_evnt_line_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"coa_co_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"coa_rgn_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"coa_ctr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"coa_acct_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"coa_vvd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"coa_inter_co_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"c_inp_dr_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"c_inp_cr_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"c_acct_dr_amt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"c_acct_cr_amt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"conv_xch_rt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt5",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"acctg_desc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"attr_ctnt1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"acctg_err_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt3",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt4",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt6",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt7",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt8",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt9",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt10",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"acctg_evnt_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"acctg_hdr_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				      InitColumns(cols);
				      SetEditable(1);
				      //SetSheetHeight(440);
				      resizeSheet();
		            }
			   break;
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		if(!validateForm(sheetObj,formObj,sAction)){
			return false;
		}
		switch (sAction) {
			case COMMAND01: // NEW
				//Condition - Accounting Date
				var localTime=SapGetLocDate(sheetObjects[0]);
				var localStartTime=localTime.substr(0,6) + "01";
				formObj.acctg_fr_dt.value=ComGetMaskedValue(localStartTime, "ymd");				
				formObj.acctg_to_dt.value=ComGetMaskedValue(localTime, "ymd");
		 		//Condition - Accounting Source
		 		var comboItems=SapGetComboItems(sheetObjects[0], "ACCOUNTING EVENT");
		 		SapAddComboItem(comboObjects[0], comboItems, "2", "ALL", "ALL"); 
		 		//FunctionalCurrency
		 		var tmpArray=SapGetFunctionalCurrencyCode(sheetObjects[0]);
				formObj.functional_currency.value=tmpArray[0];
				formObj.f_curr_prcs.value=tmpArray[1];
				//Default Setting
				 ComSetObjValue(acctg_evnt_tp_cd, "ALL");
				break;
			case IBSEARCH: // RETRIEVE 
				sheetObj.RemoveAll();
				formObj.f_cmd.value=SEARCH;
				ComOpenWait(true);
 				var sXml=sheetObj.GetSearchData("STM_SAP_0220GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				ComOpenWait(false);
				break;
			case IBSAVE: // CAPTURE
				
				if (formObj.capture_period_mm.value != "") {
					formObj.f_cmd.value=MULTI01;
					var sParam=FormQueryString(formObj);
					ComOpenWait(true);
	 				var sXml=sheetObj.GetSaveData("STM_SAP_0220GS.do", sParam);
					var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
					//alert(backendJobKey);
					if (backendJobKey != undefined && backendJobKey != '') {
						ComSetObjValue(formObj.backendjob_key, backendJobKey);
						sheetObj.SetWaitImageVisible(0);
						sheetObj.SetWaitTimeOut(10000);
						timer=setInterval(getBackEndJobStatus, 3000); // calling getBackEndJobStatus function after three seconds - recall
					}
				} else if (formObj.csr_no.value != "") {
					formObj.f_cmd.value=MULTI02;
					var sParam=FormQueryString(formObj);
					ComOpenWait(true);
					setTimeout( function () {
						var sXml=sheetObj.GetSaveData("STM_SAP_0220GS.do", sParam);
						
						SapOpenWait(false,true);  
						if (SAPDecideErrXml(sheetObj, sXml)) { 
							return;
						} else {
							ComShowCodeMessage("COM130102", "Capture"); 
						}						
					} , 100);
					setTimeout( function () {
						doActionIBSheet(sheetObj, document.form, IBSEARCH);
					} , 100); 
					break;
				}
				
	         	break;
			case IBDELETE: // DELETE
				formObj.f_cmd.value=REMOVE01;
				var sParam1=sheetObj.RowSaveStr(sheetObj.GetSelectRow());
				var sParam=sParam1 + "&" + FormQueryString(formObj);
				ComOpenWait(true);
				setTimeout( function () {     
					var sXml=sheetObj.GetSaveData("STM_SAP_0220GS.do", sParam);
	 				sheetObj.LoadSaveData(sXml);
	 				SapOpenWait(false,true); 
	                if (SAPDecideErrXml(sheetObj, sXml)) return;
	                ComShowCodeMessage("COM130303", "Data");
					doActionIBSheet(sheetObj, document.form, IBSEARCH);
				} , 100); 				
				break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH: //retrieve
				if(formObj.acctg_fr_dt.value == ""){
					ComShowCodeMessage("COM12113", "From Accounting Date");
					ComSetFocus(document.all.item("acctg_fr_dt"));
					return false;
				}
				if(formObj.acctg_to_dt.value == ""){
					ComShowCodeMessage("COM12113", "To Accounting Date");
					ComSetFocus(document.all.item("acctg_to_dt"));
					return false;
				}
				var frDt1=ComReplaceStr(formObj.acctg_fr_dt,"-","");
				var toDt1=ComReplaceStr(formObj.acctg_to_dt,"-","");
				if (ComGetDaysBetween(frDt1, toDt1) < 0){
					ComShowCodeMessage("COM132002");
					formObj.acctg_to_dt.focus();
					return false;
				}
				break;
			case IBSAVE: //CAPTURE
				if(formObj.capture_period_mm.value == "" && formObj.csr_no.value == ""){
					ComShowCodeMessage("COM12113", "Capture Period or CSR No");
					ComSetFocus(document.all.item("capture_period_mm"));
					return false;
				}
				
				if(formObj.capture_period_mm.value != "") {
					var capture_mm=ComReplaceStr(formObj.capture_period_mm.value, "-", "");
					var yyyy=capture_mm.substr(0,4);
					var mm=ComParseInt(capture_mm.substr(4,5));
					var capture_period=capture_mm + "" +  ComGetLastDay(yyyy, mm) + "";
					formObj.capture_period.value=capture_period;
	 				var xmlStr=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + COMMAND02 + "&value0=" + capture_period);
					if (SAPDecideErrXml(sheetObj, xmlStr)) {
		                return false;
		            } else {
		                var chk_period=ComGetEtcData(xmlStr, "chk_period");
		                if ( chk_period != "O") {
		                	ComShowCodeMessage("SAP00020", formObj.capture_period_mm.value);  
		                	return false;
		                } 
		            }
					break;
				}
				
				if(formObj.csr_no.value != "") {
					var csr_no=ComReplaceStr(formObj.csr_no.value, "-", "");
					var xmlStr=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + COMMAND11 + "&value1=" + csr_no);
					if (SAPDecideErrXml(sheetObj, xmlStr)) {
		                return false;
		            } else {
		                var chk_period=ComGetEtcData(xmlStr, "chk_period");
		                if ( chk_period != "O") {
		                	ComShowCodeMessage("SAP00020", csr_no+"'s GL Date");  
		                	return false;
		                } 
		            }
					break;
				}
				
				break;
			case IBDELETE: //DELETE
				if(sheetObj.GetSelectRow()< 0) {
					return false;
				}
				var selRow=sheetObj.GetSelectRow();
				if ("" == sheetObj.GetCellValue(selRow, "acctg_err_cd") ) {
					ComShowCodeMessage("SAP00045");  
					return false;
				}
				break;	
		}
		return true;
	}
	/**
	 * loading HTML Control event <br>
	 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sequence number in sheetObjects array
	 **/
	function initControl() {
		var form=document.form; 		
// 		axon_event.addListenerForm('keypress', 'obj_keypress',  form);    	  
 		//axon_event.addListenerForm('keyup',    'obj_keyup',   	form);
 		axon_event.addListenerForm  ('blur', 'obj_deactivate',  form);   //blur  beforedeactivate  
 		axon_event.addListenerFormat('focus', 'obj_activate', form);
// 		axon_event.addListenerForm ('change', 'obj_onchange', form);
	}
    /**
     * Form Element의 keypress 이벤트
     */  
	/*function obj_keypress() {
		switch(ComGetEvent().dataformat){
			case "engup":
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "engnum":
				ComKeyOnlyAlphabet('uppernum');
				break;	
			case "int":
				//숫자 만입력하기
				ComKeyOnlyNumber(ComGetEvent());
				break;
			case "ymd":
				ComKeyOnlyNumber(ComGetEvent());
				break;
			case "ym":
				ComKeyOnlyNumber(ComGetEvent());
				break;	
			case "float":
				ComKeyOnlyNumber(ComGetEvent(), "-.");
				break;
			default:
				//common standard: recognization only number, english
				ComKeyOnlyAlphabet("num");
				break;     
		}
		//if(event.KeyCode == 13){
		//	ComSetNextFocus(ComGetEvent());
		//}
	}    */
    /** 
     * handling keyup event of Object  <br>
     * checking validation of input value by dataformat of object  <br>
     */ 
	function obj_keyup(){
	}  
    /** 
     * handling work javascript OnFocus event  <br>
     */    
	function obj_activate() {
		
		var formObj=document.form;
		
        switch(ComGetEvent("name")){ 	    	
	   		case "acctg_fr_dt":
	   			ComClearSeparator(ComGetEvent());    
	   			break;
	   		case "acctg_to_dt":
	   			ComClearSeparator(ComGetEvent());    
	   			break;
	   		case "capture_period_mm":
	   			ComClearSeparator(ComGetEvent());  
	   			break;
	   		
        }
    }
    /** 
     * handling work javascript OnBlur event  <br>
     */    
    function obj_blur(){
    }    
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
     **/
	function obj_deactivate(){
		var formObj=document.form;
		//ComChkObjValid(ComGetEvent());
		ComAddSeparator(form.acctg_fr_dt, "ymd");
		ComAddSeparator(form.acctg_to_dt, "ymd");
		ComAddSeparator(form.capture_period_mm, "Ym");
		switch(ComGetEvent("name")){ 	    	
	   		case "acctg_fr_dt":
	   			ComChkObjValid(ComGetEvent());	
	   			break;
	   		case "acctg_to_dt":
	   			ComChkObjValid(ComGetEvent());	
	   			break;
	   		case "capture_period_mm":
	   			if(formObj.capture_period_mm.value != "" && formObj.csr_no.value != "") {
	   				ComShowCodeMessage("SAP00076");
	   				formObj.capture_period_mm.value = "";	   				
	   			} else {
	   				ComChkObjValid(ComGetEvent());
	   			}
	   			break;
	   		case "csr_no":
	   			if(formObj.capture_period_mm.value != "" && formObj.csr_no.value != "") {
	   				ComShowCodeMessage("SAP00076");
	   				formObj.csr_no.value = "";	   				
	   			} else {
	   				ComChkObjValid(ComGetEvent());
	   			}
	   			break;	
		}
	}
    /**
     * handling work javascript onchange event
     **/	
	function obj_onchange(){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		switch(ComGetEvent("name")){
			case "source_cd":
				if (formObj.source_cd.value != '' ) {
					formObj.source_nm.value="";
				} else {
					formObj.source_nm.value="";
				}
				break;
		}
	}	
    /**
     * Setting supplier by popup
     */
    function setSource(aryPopupData) {
    	document.form.source_cd.value=aryPopupData[0][1];
    	document.form.source_nm.value=aryPopupData[0][2];
    }
	/**
	 * BackEndJob Status='3' check.<br>
	 *
	 * @return none
	 * @see #doActionIBSheet
	 */
	function getBackEndJobStatus() {
		form.f_cmd.value=COMMAND01;
 		var sXml=sheetObjects[0].GetSearchData("STM_SAP_0220GS.do", FormQueryString(form));
		var arrXml=sXml.split("|$$|");
		var jobState=ComGetEtcData(arrXml[0], "jb_sts_flg");
		//alert("getBackEndJobStatus:::" + jobState);
		if(jobState == "3") {
			clearInterval(timer);
			getBackEndJobLoadFile();
			ComOpenWait(false);
		} else if(jobState == "4") {
			clearInterval(timer);
	 		// BackEndJob was failed
	 		var jbUsrErrMsg=getBackEndJobErrMsg( ComGetEtcData(sXml, "jb_usr_err_msg") ) ;
	 		if (jbUsrErrMsg != undefined && jbUsrErrMsg != '')
	 			ComShowMessage(jbUsrErrMsg);
	 		else
	 			ComShowCodeMessage("SAP00046");
	 		ComOpenWait(false);
		} else if(jobState == "5") {
			clearInterval(timer);
			ComShowCodeMessage("SAP00046");
			ComOpenWait(false);
		} else {
			ComOpenWait(false);
		}
	}    
	// reflect result data in case of BackEndJob successful end
	function getBackEndJobLoadFile() {
	 	var formObj=document.form;
	 	var sheetObj=sheetObjects[0];
	 	SapOpenWait(false,true);  
	 	//backendjob 완료후 작업할것 있으면 수행.
	 	ComShowCodeMessage("COM130102", "Capture"); 
	 	
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
	}
	//get jb_usr_err_msg
	function getBackEndJobErrMsg(params) {
		var ary=params.split('<||>');
		return ary[ary.length-1];
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0],70);
	}	
