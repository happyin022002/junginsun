/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0100.js
*@FileTitle  : Bank Account Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
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
 * @class stm_sap_0100 : business script for stm_sap_0100
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
	    	    	doActionIBSheet(sheetObject1, formObj, COMMAND01);
	    	    	break;					
	    	    case "btn_downexcel":
	    	    	if(sheetObj.RowCount() < 1){//no data
	    	    		ComShowCodeMessage("COM132501");
	    	    		}else{
	    	    			sheetObjects[0].Down2Excel({ HiddenColumn:1});
	    	    		}

 					
	    	    	break;
				case "btns_search_ofc":
					ComOpenPopupWithTarget('STM_SAP_0001.do?ofc_cd='+document.form.ofc_cd.value, 400, 430,"ap_ofc_cd:ofc_cd", "0,0", true);
					break;	
				case "btns_search_ctrl_ofc":
					ComOpenPopupWithTarget('STM_SAP_0001.do?ofc_cd='+document.form.ctrl_ofc_cd.value, 400, 430,"ap_ofc_cd:ctrl_ofc_cd", "0,0", true);
					break;
				case "btns_search_bank":
					ComOpenPopupWithTarget('STM_SAP_0230.do?bank_nm='+encodeURIComponent(document.form.bank_nm.value), 700, 450,"bank_nm:bank_nm", "0,0", true);
					break;	
                case "btn_close":
                	window.close();
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
	    initControl();
	    // insert initial value in Sheet
	    doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
	}
	/**
	 * Combo Setting default
	 * @param	{IBMultiCombo}	combo_obj.
	 * @param	{Number}	comboNo		Sequence number from combo object tag id
	 */
	function initCombo (comboObj, comboNo) {
	    var formObject=document.form
	    switch(comboObj.id) {
			   case "bank_acct_tp":
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
			   default :
		           with (comboObj) {
				       //SetColAlign("left");
					   //DropHeight = 160;
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
		        
		      var HeadTitle1="|Open Office|Deposit Division|Acct Type(L)|Acct Type(M)|Bank Acct Name|Account Holder|Bank Name|Branch name|Bank Acct No|Currency|Open Date|Close Date|Control Office|Limit Amount";
		      var headCount=ComCountHeadTitle(HeadTitle1);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opn_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"deposit_div",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_acct_tp_mn_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_acct_tp_sub_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"bank_acct_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"account_holder",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"bank_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"bank_brnc_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_acct_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_acct_st_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inact_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ap_ctrl_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"limit_amount",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		      //SetSheetHeight(430);
		      SetEditable(1);
		      SetColProperty(prefix+"bank_acct_st_dt", {Format:"####-##-##"} );
		      SetColProperty(prefix+"inact_dt", {Format:"####-##-##"} );
		      SetColProperty(0 ,"opn_ofc_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		      SetColProperty(0 ,"bank_acct_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		      SetColProperty(0 ,"ap_ctrl_ofc_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		      SetColProperty(0 ,"deposit_div" , {AcceptKeys:"E"});
		      SetColProperty(0 ,"bank_acct_tp_mn_nm" , {AcceptKeys:"E"});
		      SetColProperty(0 ,"bank_acct_tp_sub_nm" , {AcceptKeys:"E"});
		      SetColProperty(0 ,"bank_acct_nm" , {AcceptKeys:"E"});
		      SetColProperty(0 ,"account_holder" , {AcceptKeys:"E"});
		      SetColProperty(0 ,"bank_nm" , {AcceptKeys:"E"});
		      SetColProperty(0 ,"bank_brnc_nm" , {AcceptKeys:"E"});
		      SetColProperty(0 ,"curr_cd" , {AcceptKeys:"E"});
		      SetColProperty(0 ,"limit_amount", {AcceptKeys:"E|N|[-]"});
		      
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
		    case COMMAND01: // when form open
		    	// pop office Information
		    	if (formObj.popOfcCd.value != "") {
		    		formObj.ofc_cd.value=formObj.popOfcCd.value;
		    	} else { 
			    	// Login-user's AP office Information
			    	formObj.ofc_cd.value=SapGetLoginAPOfc(sheetObj);
		    	}
		    	// Bank Account Type Combo
		 		var bankTpComboItems=SapGetComboItems(sheetObjects[0], "BANK ACCOUNT TYPE(L)", "");
		 		SapAddComboItem(comboObjects[0], bankTpComboItems, "2", " ", " "); 
		    	break;
			case IBSEARCH: //RETRIEVE
				//search start 
				formObj.f_cmd.value=SEARCH;		
				ComOpenWait(true);
 				var sXml=sheetObj.GetSearchData("STM_SAP_0100GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
 				//format: ####-##-## is incorrect so I have to replace to fix some bugs. If the format is fixed, please remove these lines below (Line: 234):
 				sXml = sXml.replace(/ [0-9]+\:[0-9]+\:[0-9]+\.[0-9]+/g, "");
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
		axon_event.addListenerFormat('keypress', 'obj_keypress', formObj); 	//- handling code when onkeypress event in case of existing dataformat property
	    axon_event.addListenerFormat('keyup'   , 'obj_keyup'  , formObj);
	    axon_event.addListenerFormat('focus'   , 'obj_activate', formObj);
	    axon_event.addListenerFormat ('blur', 'obj_deactivate', formObj);  //beforedeactivate   deactivate
	}
	/**
	 * control keyboard input  onkeypress event of HTML Control
	 **/
	function obj_keypress() {
		switch(ComGetEvent().dataformat){
			case "engup":
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "engnum":
				//English to enter uppercase letters, uppercase letters+number
	            ComKeyOnlyAlphabet('uppernum');
				break;	
		}
	}   
	/** 
	 * handling Keypress event of Object  <br>
	 * checking validation of input value by dataformat of object  <br>
	 */ 
	function obj_keyup(){
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
		// ComChkObjValid(ComGetEvent());
	}    
	/**
	 * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
	 **/
	function obj_deactivate(){
		ComChkObjValid(ComGetEvent());
	}
	/**
	 *  bank account type - OnChange
	 */
	function bank_acct_tp_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj=document.form;
 		var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
		if (code != null && code != "") {
			bank_acct_tp.value=comboObj.GetText(code, 0);
			formObj.bank_acct_tp_desc.value=comboObj.GetText(code, 1);
		}
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}	
