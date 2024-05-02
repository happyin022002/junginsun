/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0070.js
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
 * @class stm_sap_0070 : business script for stm_sap_0070
 */
var sheetObjects=new Array();
var sheetCnt=0;
var sheetObject1;
var sheetObject2;
var prefix1; 
var prefix2;
var sheet1ChnFlag="N";		//sheet1 change Flag
var gCurRow=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		/*******************************************************/
		var formObj=document.form;
		/***** setting sheet object *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
	    	    case "btn_new" :
	    	    	formObj.reset();
	    	    	sheetObjects[0].RemoveAll();
	    	    	sheetObjects[1].RemoveAll();
	    	    	doActionIBSheet(sheetObject1, formObj, COMMAND01);
	    	    	break;					
				case "btn_print":
					doActionIBSheet(sheetObject1,formObj,RDPRINT);
					break;
				case "btns_calPayFr":
					var cal=new ComCalendar();
					cal.select(form.pay_dt_fr, 'yyyy-MM-dd');
					break;				
				case "btns_calPayTo":
					var cal=new ComCalendar();
					cal.select(form.pay_dt_to, 'yyyy-MM-dd');
					break;		
				// Open Office
				case "btns_search_ofc":
					ComOpenPopupWithTarget('STM_SAP_0001.do?ofc_cd='+document.form.ofc_cd.value, 400, 430,"ap_ofc_cd:ofc_cd", "0,0", true);
					break;	
				// Pay Group
				case "btns_search_paygroup":
					ComOpenPopupWithTarget('STM_SAP_0004.do?lu_cd='+document.form.vndr_pay_grp_cd.value, 400, 420,"lu_cd:vndr_pay_grp_cd", "0,0", true);
					break;	
				// Batch Name
				case "btns_search_batchnm":
					ComOpenPopupWithTarget('STM_SAP_0211.do?pay_bat_nm='+document.form.pay_bat_nm.value, 700, 420,"pay_bat_nm:pay_bat_nm", "0,0", true);
					break;	
				//Doc Name
				case "btns_search_docnm":
					ComOpenPopupWithTarget('STM_SAP_0007.do?lu_cd='+document.form.pay_mzd_lu_cd.value, 500, 420,"lu_cd:pay_mzd_lu_cd", "0,0", true);
					break;
                // Supplier
				case "btns_search_supplier":
					var param="?vndr_seq=" + formObj.vndr_no.value; 
					ComOpenPopup("STM_SAP_0002.do"+param, 900, 420, "setSupplier", "0,0", true, false);
					break;
				//Bank Account
				case "btns_search_bankacctnm":
					ComOpenPopupWithTarget('STM_SAP_0063.do?bank_acct_nm='+encodeURIComponent(document.form.bank_acct_nm.value) + "&bank_acct_tp_nm=INTERNAL", 720, 410,"bank_acct_nm:bank_acct_nm", "0,0", true);	
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
		this.sheetObject1=sheetObjects[0];
		this.sheetObject2=sheetObjects[1];
	    this.prefix1=sheetObject1.id + "_"; 
	    this.prefix2=sheetObject2.id + "_";
	    // insert initial value in Sheet
	    doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
	    initControl();
	    
	   // resizeSheet();
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
			case 1:  // sheet1 init 
			    with(sheetObj){
					var HeadTitle1="|||Type|Supplier Name|Supplier Code|Bank Account Name|Voucher No|Payment Date|Curr|Amount|Method|Void Date|Status|Batch|User||";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

					var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		             {Type:"Radio",     Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"chk_flg" },
		             {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"checkbox",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pay_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:0,   SaveName:prefix+"vndr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vndr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bank_acct_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"doc_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pay_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:prefix+"pay_amt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pay_mzd_lu_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pay_void_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pay_ste_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pay_bat_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"usr_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pay_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
					InitColumns(cols);
					SetSheetHeight(180);
					SetEditable(1);
		            SetColProperty(prefix+"pay_dt", {Format:"####-##-##"} );
		            SetColProperty(prefix+"pay_void_dt", {Format:"####-##-##"} );
		            SetColHidden(prefix + "chk_flg",1);
		      }
			   break;
			case 2:   //sheet2 init
			    with(sheetObj){
					var HeadTitle1="||GL Date|Post|Pay Amount|CSR No|Invoice Type|Invoice Date|Curr|Invoice Amount|";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

					var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pay_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"gl_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"post",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:prefix+"pay_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_tp_lu_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:prefix+"inv_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"inv_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
					InitColumns(cols);
					//SetSheetHeight(150);
					SetEditable(1);
		            SetColProperty(prefix+"gl_dt", {Format:"####-##-##"} );
		            SetColProperty(prefix+"inv_dt", {Format:"####-##-##"} );
		            resizeSheet();
				}
			    break;
	    }
	}
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		if (!validateForm(sheetObj, formObj, sAction)){
			return false;
		}
		switch (sAction) {
		    case COMMAND01: // when first form open,
		    	// Login-user's AP office Information
		    	formObj.ofc_cd.value=SapGetLoginAPOfc(sheetObj);
		    	// Local time
		    	var localTime=SapGetLocDate(sheetObj);
				var localStartTime=localTime.substr(0,6) + "01";
				formObj.pay_dt_fr.value=ComGetMaskedValue(localStartTime, "ymd");				
				formObj.pay_dt_to.value=ComGetMaskedValue(localTime, "ymd");
		    	break;
			case IBSEARCH: //RETRIEVE
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
				//search start 
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;		
				var sXml=sheetObj.GetSearchData("STM_SAP_0070GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				ComOpenWait(false);
				break;
			case SEARCHLIST01: // RETRIEVE LINE
				formObj.f_cmd.value=SEARCH02;
				var sXml=sheetObj.GetSearchData("STM_SAP_0070GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				break;	
			case RDPRINT:	//Print
				formObj.f_cmd.value=PRINT;
				var sParam1="";
				for(k=1; k <= sheetObj.RowCount(); k++){
					if ("1" == sheetObj.GetCellValue(k, prefix + "checkbox")) {
						sParam1 += sheetObj.RowSaveStr(k) + "&" ;
					}
				}	
				if (sParam1 == "" ) {
					ComShowCodeMessage("SAP00010" , " data to print");
					break;
				} 
                var sParam=sParam1 + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
				ComOpenWait(true);
				var sXml=sheetObj.GetSearchData("STM_SAP_0070GS.do", sParam);
				ComOpenWait(false);
				if (SAPDecideErrXml(sheetObj, sXml)) return;
				var print_seq=ComGetEtcData(sXml, "INV_RQST_SEQ");
				rdOpen(formObj, print_seq);
		        break;	
		}
	}
	/******************************************************
	 * Sheet Event - Start
	 *****************************************************/
	/**
     * Header Sheet를 click 하거나 최초 조회시 발생
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @return 없음.
     */  
    function searchDetailList(sheetObj, row, col) {
    	var sheetID=sheetObjects[0].id;
		var prefix=sheetID + "_";
		var formObj=document.form
		var sheetObject2=sheetObjects[1];
		var prefix2=sheetObject2.id + "_";
		sheetObject2.RemoveAll();
		with(sheetObj){
	        //For mapping Payment & Payment Detail Data
			var pay_seq=sheetObj.GetCellValue(row, prefix + "pay_seq");
	        formObj.hid_pay_seq.value=pay_seq;
	        doActionIBSheet(sheetObject2,formObj,SEARCHLIST01);
	        //For write Invoice Description textBox 
	        var inv_desc=sheetObject2.GetCellValue(1, prefix2 + "inv_desc");
	        formObj.sub_invDesc.value=inv_desc;
	        return;
		}
    }
    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */	
	function sheet1_OnClick(sheetObj, Row, Col){
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		var formObj=document.form;
		var sheetObject2=sheetObjects[1];
	    var prefix2=sheetObject2.id + "_";
		sheetObj.SetCellValue(Row, prefix+"chk_flg","1",0);
		if ( sheetObj.GetCellValue(Row, prefix+"ibflag")!="I" && ( sheetObj.GetCellValue(Row, prefix+"pay_seq") != sheetObject2.GetCellValue(1, prefix2+"pay_seq") ) ) {
			searchDetailList(sheetObj, Row, Col);
		}
	}	
	/**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {sheetObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {		
		sheet1ChnFlag="N";
		var prefix=sheetObj.id + "_";
		if ( sheetObj.RowCount()> 0 ) {
			sheetObj.SetCellValue(1, prefix+"chk_flg","1",0);
			searchDetailList(sheetObj, 1, 0);
		}	
	}
	 /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */	
	function sheet2_OnClick(sheetObj, Row, Col){
		var formObj=document.form;
		var prefix=sheetObj.id + "_";
		var inv_desc=sheetObj.GetCellValue(Row, prefix + "inv_desc");
        formObj.sub_invDesc.value=inv_desc;
	}
    /******************************************************
	 * Sheet Event - End
	 *****************************************************/
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
				if(formObj.pay_dt_fr.value == ""){
					ComShowCodeMessage("COM12113", "From Pay Date");
					ComSetFocus(document.all.item("due_dt_fr"));
					return false;
				}
				if(formObj.pay_dt_to.value == ""){
					ComShowCodeMessage("COM12113", "To Pay Date");
					ComSetFocus(document.all.item("due_dt_to"));
					return false;
				}
				var frDt1=ComReplaceStr(formObj.pay_dt_fr,"-","");
				var toDt1=ComReplaceStr(formObj.pay_dt_to,"-","");
				if (ComGetDaysBetween(frDt1, toDt1) < 0){
					ComShowCodeMessage("COM132002");
					formObj.pay_dt_to.focus();
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
		//axon_event.addListenerFormat('keypress', 'obj_keypress', formObj); 	//- handling code when onkeypress event in case of existing dataformat property
	    //axon_event.addListenerFormat('keyup'   , 'obj_keyup'  , formObj);
	    axon_event.addListenerFormat('focus'   , 'obj_activate', formObj);
	    axon_event.addListenerFormat ('blur', 'obj_deactivate', formObj);  //beforedeactivate   deactivate
	    //axon_event.addListener('change', 'vndr_no_onchange', 'vndr_no', '');	
	    axon_event.addListenerForm ('change', 'obj_onchange', formObj);
	}
	/**
	 *  Supplier Number / Name - OnChange
	 */
	/*function vndr_no_onchange(comboObj) {
		//document.form.vndr_nm.value = "";
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var vndr_no=formObj.vndr_no.value;
		document.form.vndr_nm.value=SapGetSupplierName(sheetObj,vndr_no,"","" );
	}*/
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
	 * control keyboard input  onkeypress event of HTML Control
	 **/
	function obj_keypress() {
		switch(ComGetEvent("dataformat")){
			case "engup":
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "engnum":
				//English to enter uppercase letters, uppercase letters+number
	            ComKeyOnlyAlphabet('uppernum');
				break;	
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
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
		// ComChkObjValid(event.srcElement);
	}    
	/**
	 * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
	 **/
	function obj_deactivate(){
		var obj = ComGetEvent();
		switch(ComGetEvent("name")){ 	    	
   			case "pay_dt_fr":
   				ComAddSeparator(obj, "ymd");
   				break;
   			case "pay_dt_to":
   				ComAddSeparator(obj, "ymd");
   				break;		
		}
	}
	function rdOpen( formObj, print_seq){
        var rdParam='/rp '+setRDParamStr(print_seq);
        var strPath="apps/opus/stm/sap/accountpayablepayment/accountpayablepayment/report/STM_SAP_1002.mrd";
        formObj.com_mrdPath.value=strPath;
        formObj.com_mrdArguments.value=rdParam;
        ComOpenRDPopupModal();
    }   
    function setRDParamStr(print_seq){
    	var rdParamStr="";
        var formObj=document.form;   
        rdParamStr += " ["+formObj.ofc_cd.value+"]";
        rdParamStr += " ["+formObj.pay_dt_fr.value+"]";
        rdParamStr += " ["+formObj.pay_dt_to.value+"]";
        rdParamStr += " ["+formObj.vndr_pay_grp_cd.value+"]";
        rdParamStr += " ["+formObj.pay_mzd_lu_cd.value+"]";        
        rdParamStr += " ["+print_seq+"]";
        return rdParamStr;
    }  
    
    function resizeSheet(){
    	ComResizeSheet(sheetObjects[1], 60);
    }
   
    
    function tab_OnChange(tabObj , nItem)
    {
        var objs=document.all.item("tabLayer");
        objs[beforetab].style.display="none";
        objs[nItem].style.display="Inline";
        beforetab=nItem;
        resizeSheet();
    }    
