/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0050.js
*@FileTitle  : Inquiry of Bank Balance
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
/* =============================================================
// #Form Command          #IBSheet Action                
// INIT        = 0;       IBSEARCH       = 0;  // 조회         
// ADD         = 1;       IBSEARCHAPPEND = 1;  // 페이징 조회  
// SEARCH      = 2;       IBSAVE         = 2;  // 저장         
// SEARCHLIST  = 3;       IBINSERT       = 3;  // 삽입         
// MODIFY      = 4;       IBCLEAR        = 4;  // 초기화       
// REMOVE      = 5;       IBDOWNEXCEL    = 5;  // 엑셀 다운로드
// REMOVELIST  = 6;       IBLOADEXCEL    = 6;  // 엑셀 업로드  
// MULTI       = 7;       IBCOPYROW      = 7;  // 행복사       
// PRINT       = 8;       IBDELETE       = 8;  // 삭제         
// REPLY       = 9;       RDPRINT        = 9;  // RD 연결  
//                        IBROWSEARCH    = 10; // Row 조회     
//                        IBCREATE       = 11; // Create       
//                        IBRESET        = 12; // Reset        
//                        IBBATCH        = 13; // Batch        
   =============================================================*/
/**
 * @extends 
 * @class stm_sap_0130 : business script for stm_sap_0130
 */
// global variable
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
		/*******************************************************/
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
	    	    case "btn_new" :
	    	    	formObj.reset();
	    	    	sheetObjects[0].RemoveAll();
					comboObjects[0].RemoveAll();
					comboObjects[1].RemoveAll();
					comboObjects[2].RemoveAll();
	    	    	doActionIBSheet(sheetObject1, formObj, COMMAND01);
	    	    	break;
	    	    case "btn_downexcel":
	    	    	if(sheetObjects[0].RowCount() < 1){//no data	
	    	    		ComShowCodeMessage("COM132501");
	    	    	}else{	
	    	    		sheetObjects[0].Down2Excel({ HiddenColumn:1, Merge:1});
	    	    	}	
	    	    	break;	
				case "btns_search_ofc":
					var  office_type="";
					if(formObj.ctrl_ofc[0].checked){
						office_type=formObj.ctrl_ofc[0].value;
					}else if(formObj.ctrl_ofc[1].checked){
						office_type=formObj.ctrl_ofc[1].value;
					}else{
						office_type=formObj.ctrl_ofc[2].value;
					}
					var param="?ofc_type=" + office_type + "&ofc_code="+formObj.ofc_cd.value;
					ComOpenPopup("STM_SAP_0500.do"+param, 700, 420, "setFiOffice", "0,0", true, false);
					break;	
				case "btns_calStmtDt":
					var cal=new ComCalendar();
					cal.select(form.bank_stmt_dt, 'yyyy-MM-dd');
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
     * Finance Office Code - return data from popup
     */
    function setFiOffice(aryPopupData) {
    	var formObj=document.form;
    	if(aryPopupData[0][1] == "AP"){
    		formObj.ctrl_ofc[0].checked=true;
    		formObj.ofc_cd.value=aryPopupData[0][2];
    	}else if(aryPopupData[0][1] == "AR"){
    		formObj.ctrl_ofc[1].checked=true;
    		formObj.ofc_cd.value=aryPopupData[0][2];
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
		this.sheetObject1=sheetObjects[0];
		this.prefix1=sheetObject1.id + "_"; 
		// insert initial value in Sheet
	    doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
	    initControl();
	}
	/**
	 * Combo Setting default
	 * @param	{IBMultiCombo}	combo_obj.
	 * @param	{Number}	comboNo		Sequence number from combo object tag id
	 */
	function initCombo (comboObj, comboNo) {
	    var formObject=document.form
	    switch(comboObj.options.id) {
			   case "inv_curr_cd":
					with (comboObj) {
			        	SetDropHeight(200);
			 			SetMultiSelect(0);
			 			SetUseAutoComplete(1);
			 			SetMaxSelect(1);
			 			//SetTitle("Code");
			 			SetColAlign(0, "left");
			 			SetColWidth(0, "70");
			 			//ValidChar(2,0);
					}
		            break;
			   case "bank_acct_tp_mn_cd":
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
		        	   //ValidChar(2,0);
				   }
	               break;
			   case "bank_acct_tp_sub_cd":
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
		        	   //ValidChar(2,0);
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
		var cnt=0;
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		switch(sheetNo) {
			case 1:   
			    with(sheetObj){
				      var HeadTitle1="|Bank Name|Bank Branch Name|Bank Account No|Bank Account Name|Currency|Reference Day|Reference Day|Reference Day|Reference Day|1 Day Before|1 Day Before|1 Day Before|1 Day Before|Difference|Description|Account Type(L)|Account Type(M)";
				      var HeadTitle2="|Bank Name|Bank Branch Name|Bank Account No|Bank Account Name|Currency|Beginning Balance|Deposit|Withdrawal|Ending Balance|Beginning Balance|Deposit|Withdrawal|Ending Balance|Difference|Description|Account Type(L)|Account Type(M)";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"},
				                      { Text:HeadTitle2, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_brnc_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_acct_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"bank_acct_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"bgn_bal_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"ttl_rct_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"ttl_pay_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"endg_bal_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"ctrl_bgn_bal_amt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"ctrl_ttl_rct_amt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"ctrl_ttl_pay_amt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"ctrl_endg_bal_amt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"difference",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"bank_stmt_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_acct_tp_mn_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_acct_tp_sub_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				      InitColumns(cols);
				      SetEditable(1);
				      SetRangeBackColor(1, 5, 1, 23,"#555555");
				      //SetSheetHeight(430);
				      resizeSheet();
		            }
			   break;
	    }
	}
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		switch (sAction) {
		    case COMMAND01: // when first form open
				formObj.ofc_cd.value=SapGetLoginAPOfc(sheetObj);
				var localTime=SapGetLocDate(sheetObj);
				formObj.bank_stmt_dt.value=ComGetMaskedValue(localTime, "ymd");
		    	// Currency Combo
		 		var currComboItems=SapGetCurrComboItems(sheetObjects[0], "");
		 		SapAddComboItem(comboObjects[0], currComboItems, "1", " ", " "); 
		    	// Bank Account Type(L) Combo
		 		var bankTpLComboItems=SapGetComboItems(sheetObjects[0], "BANK ACCOUNT TYPE(L)", "");
		 		SapAddComboItem(comboObjects[1], bankTpLComboItems, "2", " ", " "); 
		    	// Bank Account Type(M) Combo
		 		var bankTpMComboItems=SapGetComboItems(sheetObjects[0], "BANK ACCOUNT TYPE(M)", "");
		 		SapAddComboItem(comboObjects[2], bankTpMComboItems, "2", " ", " "); 
		    	break;
			case IBSEARCH: //RETRIEVE
				//search start 
				formObj.f_cmd.value=SEARCH;			
				ComOpenWait(true);
 				var sXml=sheetObj.GetSearchData("STM_SAP_0130GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				ComOpenWait(false);
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
				if(formObj.ofc_cd.value == ""){
					ComShowCodeMessage("COM12113", "Opne Office Code");
					ComSetFocus(document.all.item("ofc_cd"));
					return false;
				}
				if(formObj.bank_stmt_dt.value == ""){
					ComShowCodeMessage("COM12113", "Inquiry Date");
					ComSetFocus(document.all.item("bank_stmt_dt"));
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
		var formObj=document.form;
	    //handling Axon event. event catch
//		axon_event.addListenerFormat('keypress', 'obj_keypress', formObj); 	//- handling code when onkeypress event in case of existing dataformat property
	    axon_event.addListenerForm('keyup'   , 'obj_keyup'  , formObj);
	    axon_event.addListenerFormat('focus'   , 'obj_activate', formObj);
	    axon_event.addListenerFormat ('blur', 'obj_deactivate', formObj);  //beforedeactivate   deactivate
	}
	/**
	 * control keyboard input  onkeypress event of HTML Control
	 **/
//	function obj_keypress() {
//		switch(event.srcElement.dataformat){
//			case "engup":
//				ComKeyOnlyAlphabet('uppernum');
//				break;
//			case "ymd":
//				ComKeyOnlyNumber(event.srcElement);
//				break;
//		}
//	}   
	/** 
	 * handling Keypress event of Object  <br>
	 * checking validation of input value by dataformat of object  <br>
	 */ 
	function obj_keyup(){
		switch(event.srcElement.name){ 	    	
   		case "inv_curr_cd_text":
			$("#inv_curr_cd_text").val($("#inv_curr_cd_text").val().toUpperCase());
   			break;
		}
	}  
	/** 
	 * handling work javascript OnFocus event  <br>
	 */    
	function obj_activate() {
	   	//delete mask separator
        ComClearSeparator(ComGetEvent());     
	}
	/** 
	 * handling work javascript OnBlur event  <br>
	 */    
	function obj_blur(){
//		 ComChkObjValid(ComGetEvent());
	}    
	/**
	 * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
	 **/
	function obj_deactivate(){
		var formObj=document.form;
		ComChkObjValid(ComGetEvent());
		var obj=ComGetEvent();
		switch(ComGetEvent("name")){ 	    	
	   		case "bank_stmt_dt":
	   			ComChkObjValid(ComGetEvent());	
	   			ComAddSeparator(obj, "ymd");
	   			break;
		}
	}
	/**
	 *  bank account type(L) - OnChange
	 */
	function bank_acct_tp_mn_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj=document.form;
 		var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
		if (code != null && code != "") {
			formObj.bank_acct_tp_mn_cd.value=comboObj.GetText(code, 0);
			formObj.bank_acct_tp_mn_desc.value=comboObj.GetText(code, 1);
		}
		if(code == 0){
			formObj.bank_acct_tp_mn_desc.value="";
		}
	}
	/**
	 *  bank account type(M) - OnChange
	 */
	function bank_acct_tp_sub_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj=document.form;
 		var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
		if (code != null && code != "") {
			formObj.bank_acct_tp_sub_cd.value=comboObj.GetText(code, 0);
			formObj.bank_acct_tp_sub_desc.value=comboObj.GetText(code, 1);
		}
		if(code == 0){
			formObj.bank_acct_tp_sub_desc.value="";
		}
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}
	
