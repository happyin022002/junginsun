/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : stm_sap_0340.js
*@FileTitle  : Unsettled Report by Account
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
 * @class stm_sap_0340 : business script for stm_sap_0340
 */

var focusObj=null;
// common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();        
var comboCnt=0;
var gCurRow=0;
var prefix="sheet1_";
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
			case "btn_ofc_cd":
				ComOpenPopupWithTarget('STM_SAP_0001.do?ofc_cd='+formObj.ofc_cd.value, 400, 430,"ap_ofc_cd:ofc_cd", "0,0", true);	
				break;
			case "btn_vndr_no":				
				ComOpenPopup("STM_SAP_0002.do?vndr_seq=" + formObj.vndr_no.value, 900, 420, "setSupplier", "0,0", true, false);				
				break;
			case "btn_gl_dt":
				var cal=new ComCalendar();
				cal.select(formObj.gl_dt, 'yyyy-MM-dd');				
				break;
			case "btn_acct_cd":				
				ComOpenPopup("STM_SAP_0341.do?lu_cd=" + formObj.coa_acct_cd.value, 700, 550, "setUnsettledAccount", "0,0", true, false);				
				break;				
			case "btns_calMm":
				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObj.unstl_yrmon, 'yyyy-MM');
				break;					
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
			case "btn_capture":
				doActionIBSheet(sheetObject1, formObj, IBSAVE);
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('SAP00001');
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
	var formObj=document.form;
	for (i=0; i < sheetObjects.length; i++) {		
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);		
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
    initControl();
    // insert initial value in Sheet
    doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
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
//	axon_event.addListenerForm('keypress', 'obj_keypress',  form);    	  
//	axon_event.addListenerForm('keyup',    'obj_keyup',   	form);
	axon_event.addListenerForm('blur', 'obj_deactivate', formObj);   //beforedeactivate   deactivate
	axon_event.addListenerFormat('focus', 'obj_activate', formObj);
	axon_event.addListenerForm ('change', 'obj_onchange', formObj);
	//axon_event.addListener('change', 'vndr_no_onchange', 'vndr_no', '');	
	//axon_event.addListener('change', 'coa_acct_cd_onchange', 'coa_acct_cd', '');	
}
/** 
 * handling work javascript OnFocus event  <br>
 */    
function obj_activate() {
   	//delete mask separator
    ComClearSeparator(ComGetEvent());     
}
/**
	 * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
	 **/
function obj_deactivate(){
	var formObj = document.form;
	switch(ComGetEvent("name")){
   		case "gl_dt":
   			ComChkObjValid(ComGetEvent());
   			ComAddSeparator(formObj.gl_dt, "ymd");
   			break;
   		case "unstl_yrmon":
   			ComChkObjValid(ComGetEvent());
   			ComAddSeparator(formObj.unstl_yrmon, "ym");
   			break;
	}
}
/**
 *  Supplier Number / Name - OnChange
 */
/*function vndr_no_onchange(comboObj) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var vndr_no=formObj.vndr_no.value;
	document.form.vndr_lgl_eng_nm.value=SapGetSupplierName(sheetObj,vndr_no,"","" );
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
			formObj.vndr_lgl_eng_nm.value=SapGetSupplierName(sheetObject,vndr_no,"","" );
	    	break;
			
		case "ofc_cd":
			var office_code=formObj.ofc_cd.value;
			formObj.ofc_cd.value = SapGetDataSecurityOffice(sheetObject, office_code, "" );
			break;
			
		case "coa_acct_cd":	
			var unsettle_acct_no = formObj.coa_acct_cd.value;
			var param="&lu_tp_cd=UNSETTLED ACCOUNT&lu_cd="+document.form.coa_acct_cd.value;
		 	var sXml=sheetObject.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + param);

		 	if (unsettle_acct_no=="") {
		 		formObj.coa_acct_nm.value="";
		 	} else {
				if (SAPDecideErrXml(sheetObject, sXml)) {
					return "";
			    } else {
			    	if ( ComGetEtcData(sXml, "one_lu_cd") == "NO_DATA" ) {
			    		formObj.coa_acct_nm.value="";
			    	} else {
			    		formObj.coa_acct_nm.value=ComGetEtcData(sXml, "one_lu_desc");
			    	}        	
			    } 
		 	}
		 	break;
	}
}
//handling Axon event 2
/*function obj_blur(){
    ComChkObjValid(event.srcElement);
	var src=ComGetEvent("name")
}
function obj_focus(){
    ComClearSeparator(event.srcElement);
}*/
function obj_keypress(){
	switch(event.srcElement.dataformat){
		case "engup":
			ComKeyOnlyAlphabet('uppernum');
			break;
		default:		
			break;   
	}	
}
function form_keyup(){
	ComKeyEnter('lengthnextfocus');
}
function obj_onclick(){
	var src=ComGetEvent("name")
}
/**
 * Combo Setting default
 * @param	{IBMultiCombo}	combo_obj.
 * @param	{Number}	comboNo		Sequence number from combo object tag id
 */
function initCombo (comboObj, comboNo) {
	var formObject=document.form
    switch (comboObj.options.id) {
	    	case "unstl_curr_cd":
	    		with (comboObj) {
			   	ValidChar(2);
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
	switch (sheetNo) {
	case 1: //t1sheet1 init
		with (sheetObj) {
			// setting height
		
		var HeadTitle1="|Seq|Account\nCode|Account Eng Name|Account Kor Name|Supplier Name|Center\nCode|Center\nOffice|AR\nOffice|CSR No|Line\nNumber|G/L date|Curr|Debit\nAmount|Credit\nAmount|Description|vndr_no";
		var headCount=ComCountHeadTitle(HeadTitle1);
		(headCount, 0, 0, true);

		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		InitHeaders(headers, info);

		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"coa_acct_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"acct_eng_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"acct_locl_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"vndr_lgl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"coa_ctr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ar_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"inv_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"unstl_dl_line_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"gl_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"unstl_curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"c_inp_dr_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"c_inp_cr_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"unstl_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vndr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		 
		InitColumns(cols);
		//SetSheetHeight(420);
		SetEditable(1);
		
		resizeSheet();
		
	    }
		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	if (!validateForm(sheetObj, formObj, sAction))
		return;
	switch (sAction) {		
	    case COMMAND01: // OPEN or NEW
	        //office 코드 설정
	    	var ofcCd=SapGetLoginAPOfc(sheetObjects[0]);
	    	formObj.ofc_cd.value=ofcCd;	
	        //office local date 설정
	    	var localTime=SapGetLocDate(sheetObjects[0]); 		 					
	    	formObj.gl_dt.value=ComGetMaskedValue(localTime, "ymd");   			
	    	formObj.unstl_yrmon.value=ComGetMaskedValue(ComReplaceStr(ComGetDateAdd(localTime,"M",-1),"-","").substring(0,6),"ym");    
	        SapAddComboItem(comboObjects[0], SapGetCurrComboItems(sheetObjects[0], ""), "1", " ", " "); //currency
	    	break;
		case IBSEARCH: 
			formObj.f_cmd.value=SEARCH;
            ComOpenWait(true);
            sheetObj.DoSearch("STM_SAP_0340GS.do", FormQueryString(formObj) );
            ComOpenWait(false);
			break;
		case IBSAVE: 	
			if (ComShowCodeConfirm("SAP00017", "capture")) {    // Do you want to {?msg1}?
				formObj.f_cmd.value=MULTI;
				ComOpenWait(true);
 				var sXml=sheetObj.GetSaveData("STM_SAP_0340GS.do", FormQueryString(formObj));
 				sheetObj.LoadSaveData(sXml);
				ComOpenWait(false);
				if (SAPDecideErrXml(sheetObj, sXml)) return;	
				ComShowCodeMessage("COM130102", "Data");
				doActionIBSheet(sheetObj, formObj, IBSEARCH); 
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
		case IBSEARCH: 
			//Unsettled Summary에  전월 미결 자료 내역이 존재 여부 체크
 	        var sXml=sheetObj.GetSearchData("STM_SAP_0340GS.do", "f_cmd=" + COMMAND01 + "&value0=" + formObj.gl_dt.value);
			if (SAPDecideErrXml(sheetObj, sXml)) {							
				return false;
	        } else {	        
	        	if(ComGetEtcData(sXml, "value0") == "NO_DATA") { 
	        		ComShowCodeMessage("SAP00015", "for unsettled account. \r\n you must capture data." ); 		        		
	        		return false;
	        	}		
	        }
			break;
		case IBSAVE: 
		    //if (!ComChkValid(formObj)){
		    //    return false;        
		    //}
			
			if(formObj.unstl_yrmon.value == ""){
				ComShowCodeMessage("COM12113", "Capture Period");
				ComSetFocus(document.all.item("unstl_yrmon"));
				return false;
			}
			//미결 내역 정리시 해당 월의 AP Period가 닫혀 있는지 체크
 	        var sXml=sheetObj.GetSearchData("STM_SAP_0340GS.do", "f_cmd=" + COMMAND02 + "&value0=" + formObj.unstl_yrmon.value);
			if (SAPDecideErrXml(sheetObj, sXml)) {
				ComShowCodeMessage("COM132101"); 					
				return false;
	        } else {		        
	        	if(ComGetEtcData(sXml, "value0") == "NO_DATA") { 
	        		ComShowCodeMessage("SAP00015", "for period checking." ); 		        		
	        		return false;
	        	}	
	        	else if(ComGetEtcData(sXml, "value0") != "C") {
	        		ComShowCodeMessage("SAP00040"); 
	        		return false;
	        	}
	        }
			break;
	}
	return true;
}
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
}
/**
 * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
 * @param {sheetObj} String : 해당 IBSheet Object
 * @param {ErrMsg} String : 저장 후 메시지
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	//doActionIBSheet(sheetObj, formObj, IBSEARCH); 
}
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	//var sName=sheetObj.ColSaveName(Col);
	//var formObj=document.form;
}
/**
 * Setting supplier by popup
 */
function setSupplier(aryPopupData) {
	document.form.vndr_no.value=aryPopupData[0][1];
	document.form.vndr_lgl_eng_nm.value=aryPopupData[0][2];
}  
/**
 * Setting Unsettled Account by popup
 */
function setUnsettledAccount(aryPopupData) {
	document.form.coa_acct_cd.value=aryPopupData[0][1];
	document.form.coa_acct_nm.value=aryPopupData[0][2];
}
//chkLookupOneData
/*function coa_acct_cd_onchange() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var param="&lu_tp_cd=UNSETTLED ACCOUNT&lu_cd="+document.form.coa_acct_cd.value;
 	var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + param);
 	var unsettle_acct_no=formObj.coa_acct_cd.value;
 	
 	if (unsettle_acct_no=="") {
 		document.form.coa_acct_nm.value="";
 	} else {
		if (SAPDecideErrXml(sheetObj, sXml)) {
			return "";
	    } else {
	    	if ( ComGetEtcData(sXml, "one_lu_cd") == "NO_DATA" ) {
	    		document.form.coa_acct_nm.value="";
	    	} else {
	    		document.form.coa_acct_nm.value=ComGetEtcData(sXml, "one_lu_desc");
	    	}        	
	    } 
 	}
} 
*/
function resizeSheet(){
    ComResizeSheet(sheetObjects[0],70);
}	