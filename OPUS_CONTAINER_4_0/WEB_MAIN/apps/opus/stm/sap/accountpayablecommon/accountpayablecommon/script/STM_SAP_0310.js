/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0310.js
*@FileTitle  : Create Credit Cards 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================
*/
/**
 * @extends 
 * @class stm_sap_0310 : business script for stm_sap_0310
 */
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();        
	var comboCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
		// Event handler processing by button name */
	    function processButtonClick() {
			/***** setting sheet object *****/
			var sheetObject1=sheetObjects[0];
			var formObj=document.form;
			try {
				var srcName=ComGetEvent("name");
				if(ComGetBtnDisable(srcName)) return false;
				switch (srcName) {
					// button	
					case "btn_retrieve":
						doActionIBSheet(sheetObject1, formObj, IBSEARCH);
						break;
					case "btn_new" : 
						form.reset();
		    	    	ComSetObjValue(crd_pgm_cd, "");  	    
		    	    	ComSetObjValue(crd_tp_lu_cd, ""); 
		    	    	ComSetObjValue(crd_pgm_curr_cd, ""); 	
		    	    	ComSetObjValue(crd_brnd_lu_cd, ""); 
		    	    	break;
					case "btn_save":  
						doActionIBSheet(sheetObject1, formObj, IBSAVE);
						break;		
					//calendar
					case "btns_calDtrbDt":
						var cal=new ComCalendar();
						cal.select(formObj.crd_dtrb_dt, 'yyyy-MM-dd');
						break;
					case "btns_calInactDt":
						var cal=new ComCalendar();
						cal.select(formObj.crd_inact_dt, 'yyyy-MM-dd');
						break;
					case "btns_calExpDt":
						var cal=new ComCalendar();
						cal.select(formObj.crd_exp_dt, 'yyyy-MM-dd');
						break;
					case "btns_search_crdNo":
						var crdNo=ComTrimAll(formObj.crd_no.value, '-');
						var param="?crd_no=" + crdNo;
						ComOpenPopup("STM_SAP_0311.do"+param, 1000, 560, "setCardNo", "0,0", true, false);
						SAPChkCardNoValid(formObj.crd_no, '-');
						
						break;	
					case "btns_search_ofc":
						ComOpenPopupWithTarget('STM_SAP_0001.do?ofc_cd='+document.form.crd_dtrb_ofc_cd.value, 400, 430,"ap_ofc_cd:crd_dtrb_ofc_cd", "0,0", true);
						break;	
					case "btns_search_supplier":
						var param="?vndr_seq=" + formObj.vndr_no.value; 
						ComOpenPopup("STM_SAP_0002.do"+param, 900, 420, "setSupplier", "0,0", true, false);
						break;	
					case "btns_search_coa":
						//var param="?lineType=OTHER";   
						var company=formObj.coa_co_cd.value; 	
	            		var region=formObj.coa_rgn_cd.value;
	            		var center=formObj.coa_ctr_cd.value;
	            		var account=formObj.coa_acct_cd.value;
	            		var intercom=formObj.coa_inter_co_cd.value;
	            		var vvd=formObj.coa_vvd_cd.value;                 				
	            		var param="?lineType=OTHER&company=" + company +"&region=" + region +"&center=" + center  +"&account=" + account  +"&intercom=" + intercom  +"&vvd=" + vvd;         
		    	    	ComOpenPopup("STM_SAP_0021.do"+param, 450, 300, "setCardCOA", "0,0", true, false);
	            		break;
				} // end switch
			} catch (e) {
				if (e == "[object Error]") {
					ComShowCodeMessage(OBJECT_ERROR);
				} else {
					ComShowMessage(e.message);
				}
			}
		}
	    /**
	     * Card No - return data from popup(STM_SAP_0311)
	     */
	    function setCardNo(aryPopupData) {
	    	document.form.crd_no.value=aryPopupData[0][2];
	    	var formObj=document.form;
	  		if(document.form.crd_no.value!=""){
	    	doActionIBSheet(sheet1, formObj, IBSEARCH);
	  		}
	    } 
	    /**
	     * Supplier - return data from popup(STM_SAP_0002)
	     */
	    function setSupplier(aryPopupData) {
	    	document.form.vndr_no.value=aryPopupData[0][1];
	    	document.form.vndr_nm.value=aryPopupData[0][2];
	    } 
	    /**
	     * Card COA - return date from popup(STM_SAP_0021)
	     */    
	    function setCardCOA(aryPopupData) {
	    	var formObj=document.form;
	    	var colArray=aryPopupData[0];	
	    	var sheetObj=sheetObjects[0];
			var crdCdCmbseq=SapGetCOAInfo(sheetObj, colArray[1], colArray[2], colArray[3], colArray[4], colArray[5], colArray[6]);
	    	if(crdCdCmbseq == "ERROR") {     		
	    		ComShowCodeMessage("COM132101"); // Unexpected system error took place during data processing. Please try again later.
	    	}
	    	else if(crdCdCmbseq == "NO_DATA") {
	    		ComShowCodeMessage("COM130401"); // There is no data to search.
	    	}
	    	else {
	    		formObj.coa_co_cd.value=colArray[1]; 	
	        	formObj.coa_rgn_cd.value=colArray[2];
	        	formObj.coa_ctr_cd.value=colArray[3];
	        	formObj.coa_acct_cd.value=colArray[4];
	        	formObj.coa_inter_co_cd.value=colArray[5];
	        	formObj.coa_vvd_cd.value=colArray[6];    		
	    		formObj.crd_cd_cmb_seq.value=crdCdCmbseq;
	    	}
	    } 
	    /**
		 * registering IBSheet Object as list
		 * adding process for list in case of needing batch processing with other items
		 * defining list on the top of source
		 */
		function setSheetObject(sheet_obj) {
			sheetObjects[sheetCnt++]=sheet_obj;
		}
		/** 
		 * registering IBCombo Object as list
		 * param : combo_obj
		 * adding process for list in case of needing batch processing with other items
		 * defining list on the top of source
		 */ 
		function setComboObject(combo_obj) {  
		    comboObjects[comboCnt++]=combo_obj;  
		}
		/**
		 * initializing sheet
		 * implementing onLoad event handler in body tag
		 * adding first-served functions after loading screen.
		 */
		function loadPage() {
			for (i=0; i < sheetObjects.length; i++) {
				ComConfigSheet(sheetObjects[i]);
				initSheet(sheetObjects[i], i + 1);
				ComEndConfigSheet(sheetObjects[i]);
			}
			for(var k=0; k<comboObjects.length; k++){
				initCombo(comboObjects[k],k+1);
			}
			
		    doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
		    initControl();
		}
		function initControl() {
			var formObj=document.form;
			axon_event.addListenerFormat('focus'   , 'obj_activate', form);
		    axon_event.addListenerForm('blur', 'obj_deactivate', form);  //beforedeactivate   deactivate
		    axon_event.addListener('change', 'vndr_no_onchange', 'vndr_no', '');	
		}
		
		function vndr_no_onchange(comboObj) {
			document.form.vndr_nm.value="";
		}
		// handling sheet process
		function doActionIBSheet(sheetObj, formObj, sAction) {
			var sheetID=sheetObj.id;
			var prefix=sheetID + "_";
			if (!validateForm(sheetObj, formObj, sAction)){
				return;
			}
			switch (sAction) {
			    case COMMAND01: // when form open
			    	// Card Program Code
			    	var crdPgmCdComboItems=SapGetComboItems(sheetObjects[0], "CARD COMPANY CODE", "");
			 		SapAddComboItem(comboObjects[0], crdPgmCdComboItems, "2", " ", " "); 
			    	// Card Program Type
			 		var crdPgmTpComboItems=SapGetComboItems(sheetObjects[0], "CARD TYPE", "");
			 		SapAddComboItem(comboObjects[1], crdPgmTpComboItems, "2", " ", " "); 
			 		// Card Program Type
			 		var crdBrndComboItems=SapGetComboItems(sheetObjects[0], "CARD BRAND", "");
			 		SapAddComboItem(comboObjects[3], crdBrndComboItems, "2", " ", " "); 
			 		// Currency Combo
			 		var currComboItems=SapGetCurrComboItems(sheetObjects[0], "");
			 		SapAddComboItem(comboObjects[2], currComboItems, "1", " ", " ");
			    	break;
			    case IBSEARCH: //RETRIEVE
			    	//search start 
					formObj.f_cmd.value=SEARCH;
					var sXml=sheetObj.GetSearchData("STM_SAP_0310GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
	    	    	if (sXml.length > 0) {	
	    				var list=SapXmlToListMap(arrXml[0]);
	    				if (list.length > 0) {        					
	    					formObj.crd_no.value=list[0]["crd_no"];
	    					formObj.crd_pgm_nm.value=list[0]["crd_pgm_nm"];
	    					formObj.vndr_no.value=list[0]["vndr_no"];
	    					formObj.vndr_nm.value=list[0]["vndr_nm"];
	    					formObj.crd_cd_cmb_seq.value=list[0]["crd_cd_cmb_seq"];
	    					formObj.coa_co_cd.value=list[0]["coa_co_cd"];
	    					formObj.coa_rgn_cd.value=list[0]["coa_rgn_cd"];
	    					formObj.coa_ctr_cd.value=list[0]["coa_ctr_cd"];
	    					formObj.coa_acct_cd.value=list[0]["coa_acct_cd"];
	    					formObj.coa_inter_co_cd.value=list[0]["coa_inter_co_cd"];
	    					formObj.coa_vvd_cd.value=list[0]["coa_vvd_cd"];
	    					formObj.crd_mbr_nm.value=list[0]["crd_mbr_nm"];
	    					formObj.crd_dept_nm.value=list[0]["crd_dept_nm"];
	    					formObj.crd_dtrb_dt.value=list[0]["crd_dtrb_dt"];
	    					formObj.crd_dtrb_ofc_cd.value=list[0]["crd_dtrb_ofc_cd"];
	    					formObj.crd_inact_dt.value=list[0]["crd_inact_dt"];
	    					formObj.crd_exp_dt.value=list[0]["crd_exp_dt"];
	    					formObj.crd_desc.value=list[0]["crd_desc"];
	    					ComSetObjValue(crd_pgm_cd,   list[0]["crd_pgm_cd"]);  
	    					ComSetObjValue(crd_tp_lu_cd, list[0]["crd_tp_lu_cd"]); 
	    					ComSetObjValue(crd_brnd_lu_cd,     list[0]["crd_brnd_lu_cd"]);
	    					ComSetObjValue(crd_pgm_curr_cd,  list[0]["crd_pgm_curr_cd"]); 
	    					ComAddSeparator(formObj.crd_dtrb_dt, "ymd");
	    					ComAddSeparator(formObj.crd_inact_dt, "ymd");
	    					ComAddSeparator(formObj.crd_exp_dt, "ymd");
	    					SAPChkCardNoValid(formObj.crd_no, '-');
	    				}
	    				else {
	    					ComShowCodeMessage("COM130401");
	    				}
	    			}
					break;
			    case IBSAVE:
			    	if(ComShowCodeConfirm("SAP00017", "save?")){
				    	formObj.f_cmd.value=MULTI;
				    	ComOpenWait(true);
				    	setTimeout( function () {
				    		var sXml=sheetObj.GetSaveData("STM_SAP_0310GS.do",  FormQueryString(formObj));
				    		SapOpenWait(false,true);  
							if (SAPDecideErrXml(sheetObj, sXml)){
								return;
							}else {
								var crdNo=ComGetEtcData(sXml, "crd_no");
								formObj.crd_no.value=crdNo;
								ComShowCodeMessage("SAP00018");
								doActionIBSheet(sheetObj, formObj, IBSEARCH);
							}				    	     
				    	} , 100);

				    	
				    	
			    	}
	                break;
			}
		}
		/**
		 * Combo Setting default
		 * @param	{IBMultiCombo}	combo_obj.
		 * @param	{Number}	comboNo		Sequence number from combo object tag id
		 */
		function initCombo (comboObj, comboNo) {
		    var formObject=document.form
		    switch(comboObj.options.id) {
			   case "crd_pgm_cd" :
				   with (comboObj) {
					   SetDropHeight(200);
		 			   SetMultiSelect(0);
		 			   SetUseAutoComplete(1);
		 			   SetMaxSelect(1);
		        	   SetTitle("Code|Desc");
						SetColAlign(0, "left");
						SetColAlign(1, "left");
						SetColWidth(0, "50");
						SetColWidth(1, "120");
			       }
	               break;
			   case "crd_tp_lu_cd" :
				   with (comboObj) {
					   SetDropHeight(200);
		 			   SetMultiSelect(0);
		 			   SetUseAutoComplete(1);
		 			   SetMaxSelect(1);
						SetColAlign(0, "left");
						SetColWidth(0, "120");
			       }
				   break;
			   case "crd_brnd_lu_cd" :
				   with (comboObj) {
					   SetDropHeight(200);
		 			   SetMultiSelect(0);
		 			   SetUseAutoComplete(1);
		 			   SetMaxSelect(1);
						SetColAlign(0, "left");
						SetColWidth(0, "120");
			       }
				   break;
			   case "crd_pgm_curr_cd" :
				   with (comboObj) {
				   	ValidChar(2);
			       }
				   /*with (comboObj) {
			        	SetDropHeight(200);
			 			SetMultiSelect(0);
			 			SetUseAutoComplete(1);
			 			SetMaxSelect(1);
						SetColAlign(0, "left");
						SetColWidth(0, "70");
				   }*/
				   break;
			   default :
		           with (comboObj) {
			       }
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
			    	if(formObj.crd_no.value == ""){
						ComShowCodeMessage("COM12113", "Card No.");
						ComSetFocus(document.all.item("crd_no"));
						return false;
					}
			    	break;
			    case IBSAVE: // save
					if(formObj.crd_no.value == ""){
						ComShowCodeMessage("COM12113", "Card No.");
						ComSetFocus(document.all.item("crd_no"));
						return false;
					}else if(formObj.crd_pgm_nm.value == ""){
						ComShowCodeMessage("COM12113", "Card Program Name");
						ComSetFocus(document.all.item("crd_pgm_nm"));
						return false;
					}else if(ComTrim(ComGetObjValue(crd_pgm_cd)) == ""){
						ComShowCodeMessage("COM12113", "Card Program Code");
						ComSetFocus(document.all.item("crd_pgm_cd"));
						return false;
					}else if(ComTrim(ComGetObjValue(crd_pgm_curr_cd)) == ""){
						ComShowCodeMessage("COM12113", "Card Currency");
						ComSetFocus(document.all.item("crd_pgm_curr_cd"));
						return false;
					}else if(ComTrim(ComGetObjValue(crd_brnd_lu_cd)) == ""){
						ComShowCodeMessage("COM12113", "Card Brand");
						ComSetFocus(document.all.item("crd_brnd_lu_cd"));
						return false;
					}else if(formObj.crd_mbr_nm.value == ""){
						ComShowCodeMessage("COM12113", "Card Member Name");
						ComSetFocus(document.all.item("crd_mbr_nm"));
						return false;
					}else if(formObj.crd_dtrb_ofc_cd.value == ""){
						ComShowCodeMessage("COM12113", "Card Receipt Office");
						ComSetFocus(document.all.item("crd_dtrb_ofc_cd"));
						return false;
					}else if(formObj.crd_dtrb_dt.value == ""){
						ComShowCodeMessage("COM12113", "Distribution Date");
						ComSetFocus(document.all.item("crd_dtrb_dt"));
						return false;
					}
					var frDt=ComReplaceStr(formObj.crd_dtrb_dt,"-","");
					if(formObj.crd_exp_dt.value !=""){
						var toDt=ComReplaceStr(formObj.crd_exp_dt,"-","");
						if (ComGetDaysBetween(frDt, toDt) < 0){
							ComShowCodeMessage("COM132002");
							return false;
						}
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
		function initSheet(sheetObj, sheetNo) {
			var cnt=0;
			var sheetID=sheetObj.id;
			var prefix=sheetID + "_";
			switch(sheetNo) {
				case 1:   
				   with(sheetObj){
				      var HeadTitle1="";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [];
				      SetEditable(0);
				      SetWaitImageVisible(0);
				      resizeSheet();
				break;
				}
			}
		
		}
		/**
		 * loading HTML Control event <br>
		 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
		 * @param {ibsheet} sheetObj    IBSheet Object
		 * @param {int}     sheetNo     sequence number in sheetObjects array
		 **/
		/**
		 * control keyboard input  onkeypress event of HTML Control
		 **/
//		function obj_keypress() {
//			switch(ComGetEvent("dataformat"){
//				case "engup":
//					ComKeyOnlyAlphabet('uppernum');
//					break;
//				case "ymd":
//					ComKeyOnlyNumber(ComGetEvent());
//					break;
//				case "engnum":
//					ComKeyOnlyAlphabet("num");
//					break;
//			}
//		}   
		/** 
		 * handling Keypress event of Object  <br>
		 * checking validation of input value by dataformat of object  <br>
		 */ 
//		function obj_keyup(){
//		}  
		/** 
		 * handling work javascript OnFocus event  <br>
		 */    
		
		/** 
		 * handling work javascript OnBlur event  <br>
		 */    
		function obj_blur(){
			 ComChkObjValid(ComGetEvent());
			 
		}   
		function obj_activate(){
			
	  		switch(ComGetEvent("name")){ 	    	
		   		case "crd_no":
		   			SAPCardNoClearSeparator(ComGetEvent(), '-');
		   			
		   			break;
		   		default:
		   		 ComClearSeparator(ComGetEvent());  
		   		    break;
			}
		}
	  	function obj_deactivate(){
	  		var obj = ComGetEvent();
	  		var formObj=document.form;
				switch(ComGetEvent("name")){ 	    	
			   		case "crd_dtrb_dt":
			   			ComAddSeparator(obj, "ymd");
			   			break;
			   		case "crd_inact_dt":
			   			ComAddSeparator(obj, "ymd");	
			   			break;
			   		case "crd_exp_dt":
			   			ComAddSeparator(obj, "ymd");
			   			break;
			   		case "crd_no":
			   			SAPChkCardNoValid(ComGetEvent(), '-');
			   			if(crd_no.value!=""){
			   				doActionIBSheet(sheet1, formObj, IBSEARCH);
			   			}
			   			break;
				}
			}
		/**
		 * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
		 **/
	    /**
		 *  Supplier Number / Name - OnChange
		 */
	  	function resizeSheet(){
	  	    ComResizeSheet(sheetObjects[0]);
	  	}
