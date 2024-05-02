/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0140.js
*@FileTitle  : Bank Balance Adjustment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/

/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
              MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
              OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * @extends 
 * @class STM_SAP_0140 : business script for STM_SAP_0140
 */

// common global variable
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();        
var comboCnt = 0;

var gCurRow = 0;

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick() {
	/***** setting sheet object *****/
	var sheetObject = sheetObjects[0];

	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
				
    	    case "btn_new" :
    	    	ComResetAll();    //기본 object 초기화
				doActionIBSheet(sheetObject, formObj, COMMAND01);
    	    	break;	
    	    	
    	    case "btn_downexcel":
    	    	
    	    	if(sheetObjects[0].RowCount() < 1){//no data
    	    		ComShowCodeMessage("COM132501");
    	    	}
    	    	if(sheetObjects[1].RowCount() < 1){//no data
    	    		ComShowCodeMessage("COM132501");
    	    	}
    	    	
    	    	if (sheetObjects[0].RowCount() > 0 && sheetObjects[1].RowCount() > 0) {
    	    		sheetObjects[0].Down2ExcelBuffer(true);
    				sheetObjects[0].Down2Excel({FileName:'Excel',SheetName:'Sheet1', HiddenColumn:1, SheetDesign:1});
    			   	sheetObjects[1].Down2Excel({FileName:'Excel',SheetName:'Sheet2', HiddenColumn:1, SheetDesign:1});
    			   	sheetObjects[0].Down2ExcelBuffer(false);
    	    	} else {
    	    		// If any grid has no data, we could not download excel by using Buffer, we should download one by one.
    	    		if (sheetObjects[0].RowCount() > 0) {
    	    			sheetObjects[0].Down2Excel({FileName:'Excel',SheetName:'Sheet1', HiddenColumn:1, SheetDesign:1});
    	    		}
    	    	}
    	    	

    	    	break;		
				
			case "btns_search_ofc":
				var  office_type ="";
				
				if(formObj.ofc_type[0].checked) {
					office_type =formObj.ofc_type[0].value;
				} else if(formObj.ofc_type[1].checked) {
					office_type =formObj.ofc_type[1].value;
				} else {
					office_type =formObj.ofc_type[2].value;
				}
				
				var param = "?ofc_type=" + office_type + "&ofc_code="+formObj.ofc_cd.value;
				ComOpenPopup("STM_SAP_0500.do"+param, 700, 420, "setFiOffice", "0,0", true, false);
				break;	
			case "btns_search_bankAcct":
				
				if (!validateForm(sheetObject, formObj, "COMMAND02")) return;
				
				var  office_type ="";
				
				if(formObj.ofc_type[0].checked) {
					office_type =formObj.ofc_type[0].value;
				} else if(formObj.ofc_type[1].checked) {
					office_type =formObj.ofc_type[1].value;
				} else {
					office_type =formObj.ofc_type[2].value;
				}
				
				var inactive_type = "";
				if(formObj.inactive_type[0].checked) {
					inactive_type =formObj.inactive_type[0].value;
				} else if(formObj.inactive_type[1].checked) {
					inactive_type =formObj.inactive_type[1].value;
				} else {
					inactive_type =formObj.inactive_type[2].value;
				}
				
				var bank_acct_no = formObj.bank_acct_no.value;
				
				var param = "?ofc_type=" + office_type + "&ofc_code="+formObj.ofc_cd.value + "&inactive_type="+inactive_type + "&bank_acct_no="+bank_acct_no;
				ComOpenPopup("STM_SAP_0510.do"+param, 920, 520, "setBankAcct", "0,0", true, false);
				break;		
			
			case "btns_calFrDt":
				var cal = new ComCalendar();
				cal.select(form.fr_dt, 'yyyy-MM-dd');
				break;	
			case "btns_calToDt":
				var cal = new ComCalendar();
				cal.select(form.to_dt, 'yyyy-MM-dd');
				break;		
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage(OBJECT_ERROR);
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
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/** 
 * registering IBCombo Object as list
 * param : combo_obj
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */ 
function setComboObject(combo_obj) {  
    comboObjects[comboCnt++] = combo_obj;  
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	
	var formObj = document.form;
	var tmpArray = SapGetFunctionalCurrencyCode(sheetObjects[0]);
	formObj.hid_func_curr_cd.value = tmpArray[0];
	formObj.hid_func_curr_prcs.value = tmpArray[1];
	
	
	
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	for (var k=0; k<comboObjects.length; k++) {
		initCombo(comboObjects[k],k+1);
	}
    
    initControl();
    
    doActionIBSheet(sheetObjects[0], document.form, COMMAND01); // OFC, DATE, COMBO Setting
    
    resizeSheet();
}

/**
 * loading HTML Control event <br>
 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence number in sheetObjects array
 **/
function initControl() {
	//** Date Separator **/
	DATE_SEPARATOR = "-";
	var formObj = document.form;
	
    //handling Axon event. event catch
//	axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    ,   formObj); 	//- handling code when OnBeforeDeactivate(blur) event
//	axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   ,   formObj);  //- handling code when OnBeforeActivate event in case of existing dataformat property
//    axon_event.addListenerFormat('keypress'        , 'obj_keypress',   formObj); 	//- handling code when onkeypress event in case of existing dataformat property
//    axon_event.addListenerFormat('keyup'           , 'obj_keyup'   ,   formObj);
    axon_event.addListenerFormat('focus'           , 'obj_activate',   formObj);	
    axon_event.addListenerFormat('blur'            , 'obj_deactivate', formObj);
    axon_event.addListenerForm ( 'change'          , 'obj_onchange',   formObj);
    
}

//handling Axon event 2
function obj_blur(){

}


function obj_keypress(){
	switch(event.srcElement.dataformat){
	case "engup":
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "engnum":
		ComKeyOnlyAlphabet('uppernum');
		break;	
	case "int":
		//숫자 만입력하기
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "ymd":
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "float":
		ComKeyOnlyNumber(event.srcElement, "-.");
		break;

	default:
		//common standard: recognization only number, english
		ComKeyOnlyAlphabet("num");
		break;     
	}	
}

function obj_keyup(){
	var formObj = document.form;
	
	switch (event.srcElement.name) {
	case "ofc_cd":
		ComKeyOnlyAlphabet('uppernum');
		break;
	}//end of switch

}

/** 
 * handling work javascript OnFocus event  <br>
 */    
function obj_activate() {
   	//delete mask separator
    ComClearSeparator(event.srcElement);        
} 

/**
 * HTML Control onfocus validate event <br>
 **/
function obj_deactivate(){
	switch(ComGetEvent("name")){ 	    	
		case "fr_dt":
			ComAddSeparator(form.fr_dt, "ymd");
			ComChkObjValid(ComGetEvent());	
			break;
		case "to_dt":
			ComAddSeparator(form.to_dt, "ymd");
			ComChkObjValid(ComGetEvent());	
			break;
	}
}


    /**
     * handling work javascript onchange event
     **/	
	function obj_onchange(){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		switch(ComGetEvent("name")){
			case "bank_acct_no":
				if (formObj.bank_acct_no.value != '' ) {
					
					
					if (!validateForm(sheetObj, formObj, "COMMAND02")) return;
					
					var  office_type ="";
					
					if(formObj.ofc_type[0].checked) {
						office_type =formObj.ofc_type[0].value;
					} else if(formObj.ofc_type[1].checked) {
						office_type =formObj.ofc_type[1].value;
					} else {
						office_type =formObj.ofc_type[2].value;
					}
					
					var inactive_type = "";
					if(formObj.inactive_type[0].checked) {
						inactive_type =formObj.inactive_type[0].value;
					} else if(formObj.inactive_type[1].checked) {
						inactive_type =formObj.inactive_type[1].value;
					} else {
						inactive_type =formObj.inactive_type[2].value;
					}
					
					var bank_acct_no = formObj.bank_acct_no.value;
					
					var param = "&ofc_type=" + office_type + "&ofc_cd="+formObj.ofc_cd.value + "&inactive_type="+inactive_type + "&bank_acct_no="+bank_acct_no;
					
					var sXml = sheetObj.GetSearchData("STM_SAP_0510GS.do", "f_cmd=" + SEARCH + param);
					
					if (SAPDecideErrXml(sheetObj, sXml)) {
						return "";
			        } else {
			        	if ( bank_acct_no == ComGetEtcData(sXml, "bank_acct_number") ) {
			        		formObj.bank_acct_no.value = ComGetEtcData(sXml, "bank_acct_number");
			        		formObj.bank_acct_name.value = ComGetEtcData(sXml, "bank_acct_name");
			        		formObj.bank_name.value = ComGetEtcData(sXml, "bank_name");
			        		formObj.bank_branch_name.value = ComGetEtcData(sXml, "bank_branch_name");
			        		formObj.bank_acct_major_type.value = ComGetEtcData(sXml, "bank_acct_major");
			        		formObj.bank_acct_minor_type.value = ComGetEtcData(sXml, "bank_acct_minor");
			        		formObj.currency_code.value = ComGetEtcData(sXml, "currency_code");
			        		
			        		formObj.bank_acct_seq.value = ComGetEtcData(sXml, "bank_acct_seq");			        		
			        	} else {
			        		formObj.bank_acct_name.value = "";
			        		formObj.bank_name.value = "";
			        		formObj.bank_branch_name.value = "";
			        		formObj.bank_acct_major_type.value = "";
			        		formObj.bank_acct_minor_type.value = "";
			        		formObj.currency_code.value = "";
			        		
			        		formObj.bank_acct_seq.value = "";			       
			        		
			        	}       	        	
			        }

				} else {
					
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

    switch(comboObj.options.id) {
		   case "inv_curr_cd":
				with (comboObj) {
		        	DropHeight = 200;
		 			MultiSelect = false;
		 			UseAutoComplete = true;
		 			MaxSelect = 1;
		 			//SetTitle("Code");
		 			SetColAlign("left");
				    SetColWidth("70");
				   }
	            break;
		   case "bank_acct_tp_mn_cd":
			   with (comboObj) {
	        	   DropHeight = 200;
	 			   MultiSelect = false;
	 			   UseAutoComplete = true;
	 			   MaxSelect = 1;
	        	   SetTitle("Code|Desc");
			       SetColAlign("left|left");
			       SetColWidth("50|120");
			   }
               break;
           
		   case "bank_acct_tp_sub_cd":
			   with (comboObj) {
	        	   DropHeight = 200;
	 			   MultiSelect = false;
	 			   UseAutoComplete = true;
	 			   MaxSelect = 1;
	        	   SetTitle("Code|Desc");
			       SetColAlign("left|left");
			       SetColWidth("50|120");
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
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;	
	var sheetID = sheetObj.id;
	var prefix = sheetID + "_";
	
	var formObj = document.form;

	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {
	        var local_curr=formObj.hid_func_curr_cd.value;
	        var HeadTitle1="|Type|Trx Number|Curr|Amount|Trx Date|Supplier Name|Batch Name|Source|Reference Type|Exchange Rate|"+local_curr+" Amount|Description";
	        HeadTitle1 += "|bank_account_seq|cal_amount|payment_amount|receipt_amount|transaction_id|cal_lcl_amount|payment_lcl_amount|receipt_lcl_amount|slip_status|curr_point";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	        var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:1,   SaveName:"type_meaning",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:135,  Align:"Left",    ColMerge:1,   SaveName:"trx_number",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"currency_code",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"amount",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cleared_date",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"agent_name",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"batch_name",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"source",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"reference_type",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"exchange_rate",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"lcl_amount",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"description",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bank_account_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cal_amount",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"payment_amount",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"receipt_amount",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"transaction_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cal_lcl_amount",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"payment_lcl_amount",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"receipt_lcl_amount",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"slip_status",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"curr_point",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	         
	        InitColumns(cols);
	        SetEditable(1);
	        SetSheetHeight(350);
		}
		break;
	case 2: // sheet2 init
		with (sheetObj) {
	        var HeadTitle1="|Begining|Receipt|Payment|Balance";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	        var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	               {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"begining",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"receipt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"payment",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"balance",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	         
	        InitColumns(cols);
	        SetEditable(1);
	        SetSheetHeight(100);
	        SetExtendLastCol(0);
		}
		break;
	}
}

// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	
	var sheetID = sheetObj.id;
	var prefix = sheetID + "_";
	
	if (!validateForm(sheetObj, formObj, sAction)) return;

	switch (sAction) {		

	
		case COMMAND01: // RETRIEVE AP OFFICE, AP OFFICE LOCAL CURRENTY
			
			formObj.ofc_cd.value = SapGetLoginAPOfc(sheetObj);
			formObj.lgin_usr_ap_ofc.value = SapGetLoginAPOfc(sheetObj);
				
			var localTime =  SapGetLocDate(sheetObj);
			formObj.fr_dt.value = ComGetMaskedValue(localTime, "ymd");				
			formObj.to_dt.value = ComGetMaskedValue(localTime, "ymd");				

	 		break;
	 
		case IBSEARCH: //retrieve
			
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchData("STM_SAP_0140GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(sXml,false);
			
			//SHEET2 SETTING
			var sheet2Row = 1;
			var sheet2 = sheetObjects[1];
			
			sheet2.RemoveAll();
			sheet2.DataInsert(-1);
			
			var begining = ComNullToZero(ComGetEtcData(sXml, "BEGINING_AMOUNT"));
			var receipt = ComNullToZero(ComGetEtcData(sXml, "RECEIPT_AMOUNT"));
			var payment = ComNullToZero(ComGetEtcData(sXml, "PAYMENT_AMOUNT"));
			
			if (begining == "null") {
				begining = "0";				
			}
			

			if (receipt == "null") {
				receipt = "0";				
			}
			
			if (payment == "null") {
				payment = "0";				
			}
			
			
			if ( receipt != "null" && payment != "null" ) {
			
				var balance = parseFloat(eval(ComReplaceStr( begining, ",", "") )) + parseFloat(eval(ComReplaceStr( receipt, ",", "") )) - parseFloat(eval(ComReplaceStr( payment, ",", "") ));
				
				var point =ComGetEtcData(sXml, "CURR_POINT");
				
				sheet2.SetCellValue(sheet2Row, "begining", SAPComAddComma2( ComRound(begining, point) + '', point));
				sheet2.SetCellValue(sheet2Row, "receipt", receipt);
				sheet2.SetCellValue(sheet2Row, "payment", payment);
				sheet2.SetCellValue(sheet2Row, "balance", SAPComAddComma2( ComRound(balance, point) + '', point));
			}
			break;
		
	}
}


/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	
	sheetObj.ShowDebugMsg = false;
	
	switch (sAction) {
	
		case IBSEARCH: //retrieve
			if(formObj.ofc_cd.value == ""){
				ComShowCodeMessage("COM12113", "Office");
				ComSetFocus(document.all.item("ofc_cd"));
				return false;
			}
			
			if(formObj.bank_acct_no.value == ""){
				ComShowCodeMessage("COM12113", "Acct No");
				ComSetFocus(document.all.item("bank_acct_no"));
				return false;
			}

			break;
			
		case COMMAND02: //check popup account no.
			if(formObj.ofc_cd.value == ""){
				ComShowCodeMessage("COM12113", "Office");
				ComSetFocus(document.all.item("ofc_cd"));
				return false;
			}
			
			if(formObj.fr_dt.value == ""){
				ComShowCodeMessage("COM12113", "Inquiry From Date");
				ComSetFocus(document.all.item("fr_dt"));
				return false;
			}
			
			if(formObj.to_dt.value == ""){
				ComShowCodeMessage("COM12113", "Inquiry To Date");
				ComSetFocus(document.all.item("to_dt"));
				return false;
			}

			break;	
		
	}
	return true;
}



/**
 * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 * @param {sheetObj} String : 해당 IBSheet Object
 * @param {ErrMsg} String : 조회 후 메시지
 */	
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {

    
    if (sheetObj.RowCount() > 0 ) {
	
		for (var i=sheetObj.HeaderRows() ; i<= sheetObj.RowCount() ; i++) {
			if (sheetObj.GetCellValue(i,"slip_status") == "1" ) {
				sheetObj.SetCellFontColor(i, "trx_number","#FF0000");
			} 
		}
    }

}


/**
 * Finance Office Code - return data from popup
 */
function setFiOffice(aryPopupData) {
	var formObj = document.form;

	if(aryPopupData[0][1] == "AP"){
		formObj.ofc_type[0].checked= true;
		formObj.ofc_cd.value = aryPopupData[0][2];
		
	}else if(aryPopupData[0][1] == "AR"){
		formObj.ofc_type[1].checked= true;
		formObj.ofc_cd.value = aryPopupData[0][2];
	}
	
}

/**
 * Bank Acct No - return data from popup
 */
function setBankAcct(aryPopupData) {
	var formObj = document.form;
	formObj.bank_acct_no.value = aryPopupData[0][1];
	formObj.bank_acct_name.value = aryPopupData[0][2];
	formObj.bank_name.value = aryPopupData[0][3];
	formObj.bank_branch_name.value = aryPopupData[0][4];
	formObj.bank_acct_major_type.value = aryPopupData[0][5];
	formObj.bank_acct_minor_type.value = aryPopupData[0][6];
	formObj.currency_code.value = aryPopupData[0][7];
	formObj.bank_acct_seq.value = aryPopupData[0][8];
}


function resizeSheet(){
    for (i=1; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i]);
    }
}