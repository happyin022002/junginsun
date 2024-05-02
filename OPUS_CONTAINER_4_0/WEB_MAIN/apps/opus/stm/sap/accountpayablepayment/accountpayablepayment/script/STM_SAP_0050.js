/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0050.js
*@FileTitle  : Payment Schedule Inquiry
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
 * @class stm_sap_0050 : business script for stm_sap_0050
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
			if(ComGetBtnDisable(srcName)) return false;
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
	    	    	if(sheetObjects[0].RowCount() < 1){//no data
               		 	ComShowCodeMessage("COM132501");
	    	    	}else{
						sheetObjects[0].Down2Excel({ HiddenColumn:1});
	    	    	}
	    	    	break;
				case "btn_print":
					break;
				case "btns_calDueFr":
					var cal=new ComCalendar();
					cal.select(form.due_dt_fr, 'yyyy-MM-dd');
					break;				
				case "btns_calDueTo":
					var cal=new ComCalendar();
					cal.select(form.due_dt_to, 'yyyy-MM-dd');
					break;		
				case "btns_search_ofc":
					ComOpenPopupWithTarget('STM_SAP_0001.do?ofc_cd='+document.form.ofc_cd.value, 400, 430,"ap_ofc_cd:ofc_cd", "0,0", true);
					break;	
				case "btns_search_paygroup":
					ComOpenPopupWithTarget('STM_SAP_0004.do?lu_cd='+document.form.ap_pay_grp_lu_cd.value, 400, 420,"lu_cd:ap_pay_grp_lu_cd", "0,0", true);
					break;
				case "btns_search_supplier":
					var param="?vndr_seq=" + formObj.vndr_no.value; 
					ComOpenPopup("STM_SAP_0002.do"+param, 900, 420, "setSupplier", "0,0", true, false);
					break;
				case "btns_search_paymethod":
					ComOpenPopupWithTarget('STM_SAP_0007.do?lu_cd='+document.form.pay_mzd_lu_cd.value, 500, 420,"lu_cd:pay_mzd_lu_cd", "0,0", true);
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
     * Supplier - return data from popup
     */
    function setSupplier(aryPopupData) {
    	document.form.vndr_no.value=aryPopupData[0][1];
    	document.form.vndr_nm.value=aryPopupData[0][2];
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
	    
	    // office cd
//	    var strUsr_ofc_var = document.form.strUsr_ofc.value;
//	    document.form.ofc_cd.value = strUsr_ofc_var;
	}
	/**
	 * Combo Setting default
	 * @param	{IBMultiCombo}	combo_obj.
	 * @param	{Number}	comboNo		Sequence number from combo object tag id
	 */
	function initCombo (comboObj, comboNo) {
	    var formObject=document.form
	    	switch (comboObj.options.id) {
	    	case "inv_curr_cd":
		           with (comboObj) {
				   	ValidChar(2);
			       }
	           break;
			   default :
		           with (comboObj) {
				   //ValidChar(2,0);
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
				with (sheetObj) {
		       
			        var HeadTitle1="|Due Date|Office|Pay Group|Supplier|CSR No|GL Date|Curr|Amount|Description|Supplier Bank Acct|Pay Method";
			        var headCount=ComCountHeadTitle(HeadTitle1);
	//		        (headCount, 0, 0, true);
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
			        var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"due_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ap_pay_grp_lu_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:0,   SaveName:prefix+"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"gl_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:prefix+"pay_rmn_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:prefix+"inv_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bank_acct_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pay_mzd_lu_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			         
			        InitColumns(cols);
			        SetEditable(1);
			        //SetSheetHeight(440);
			        SetColProperty(prefix+"due_dt", {Format:"Ymd"} );
			        SetColProperty(prefix+"gl_dt", {Format:"Ymd"} );
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
		    case COMMAND01: // when the form open
		    	// Login-user's AP office Information
		    	formObj.ofc_cd.value=SapGetLoginAPOfc(sheetObj);
		    	// Local time
		    	var localTime=SapGetLocDate(sheetObj);
		    	var localStartTime=localTime.substr(0,6) + "01";
				formObj.due_dt_fr.value=ComGetMaskedValue(localStartTime, "ymd");				
				formObj.due_dt_to.value=ComGetMaskedValue(localTime, "ymd");
				// Currency Combo
		 		var currComboItems=SapGetCurrComboItems(sheetObjects[0], "");
		 		SapAddComboItem(comboObjects[0], currComboItems, "1", " ", " "); 
		    	break;
			case IBSEARCH: //RETRIEVE
				//search start 
				formObj.f_cmd.value=SEARCH;		
				ComOpenWait(true);
 				var sXml=sheetObj.GetSearchData("STM_SAP_0050GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
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
					ComShowCodeMessage("COM12113", "Office Code");
					ComSetFocus(document.all.item("ofc_cd"));
					return false;
				}
				if(formObj.due_dt_fr.value == ""){
					ComShowCodeMessage("COM12113", "From Due Date");
					ComSetFocus(document.all.item("due_dt_fr"));
					return false;
				}
				if(formObj.due_dt_to.value == ""){
					ComShowCodeMessage("COM12113", "To Due Date");
					ComSetFocus(document.all.item("due_dt_to"));
					return false;
				}
				var frDt1=ComReplaceStr(formObj.due_dt_fr,"-","");
				var toDt1=ComReplaceStr(formObj.due_dt_to,"-","");
				if (ComGetDaysBetween(frDt1, toDt1) < 0){
					ComShowCodeMessage("COM132002");
					formObj.due_dt_to.focus();
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
	    //axon_event.addListenerForm('keyup'   , 'obj_keyup'  , formObj);
	    axon_event.addListenerFormat('focus'   , 'obj_activate', formObj);
	    axon_event.addListenerFormat ('blur', 'obj_deactivate', formObj);  //beforedeactivate   deactivate
	    //axon_event.addListener('change', 'vndr_no_onchange', 'vndr_no', '');	
	    axon_event.addListenerForm ('change', 'obj_onchange', formObj);
	}
	/**
     * initialize or check selected header information
     */ 
    function obj_onchange(){
		var formObj=document.form;
		var sheetObject=sheetObjects[0];
		switch(ComGetEvent("name")){
			case "vndr_no":
				var vndr_no=formObj.vndr_no.value;
				formObj.vndr_nm.value=SapGetSupplierName(sheetObject,vndr_no,"","" );
		    	break;
				
			case "ofc_cd":
				var office_code=formObj.ofc_cd.value;
				formObj.ofc_cd.value = SapGetDataSecurityOffice(sheetObject, office_code, "" );
				break;
		}
	}
	/**
	 *  Supplier Number / Name - OnChange
	 */
	/*function vndr_no_onchange(comboObj) {
		//document.form.vndr_nm.value = "";
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var vndr_no=formObj.vndr_no.value;
		if(vndr_no=="")
			{
			document.form.vndr_nm.value="";
			}
		else
			{
			document.form.vndr_nm.value=SapGetSupplierName(sheetObj,vndr_no,"","" );
			}
		
	}*/
	/**
	 * control keyboard input  onkeypress event of HTML Control
	 **/
	function obj_keypress() {
		switch(event.srcElement.dataformat){
			case "engup":
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "engnum":
				//English to enter uppercase letters, uppercase letters+number
	            ComKeyOnlyAlphabet('uppernum');
				break;	
			case "ymd":
				ComKeyOnlyNumber(ComGetEvent());
				break;
			default:
				//common standard: recognization only number, english
				ComKeyOnlyAlphabet("num");
				break;     
		}
	}   
	/** 
	 * handling Keypress event of Object  <br>
	 * checking validation of input value by dataformat of object  <br>
	 */ 
	/*function obj_keyup(){
		switch(event.srcElement.name){ 	    	
   		case "inv_curr_cd_text":
			$("#inv_curr_cd_text").val($("#inv_curr_cd_text").val().toUpperCase());
   			break;
		}
	}  */
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
		ComChkObjValid(ComGetEvent());
	}    
	function inv_curr_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj,value,text){ 
		document.form.inv_curr_cd_text.value= comboObj.GetSelectText(); 
	}
	function inv_curr_cd_OnBlur(){
		document.form.inv_curr_cd_text.value= inv_curr_cd.GetSelectText();
	} 
	/**
	 * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
	 **/
	function obj_deactivate(){
		var formObj = document.form;
		switch(ComGetEvent("name")){
	   		case "due_dt_fr":
	   			ComChkObjValid(ComGetEvent());
	   			ComAddSeparator(formObj.due_dt_fr, "ymd");
	   			break;
	   		case "due_dt_to":
	   			ComChkObjValid(ComGetEvent());
	   			ComAddSeparator(formObj.due_dt_to, "ymd");
	   			break;
		}
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}
	
