/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : stm_sap_0510.js
*@FileTitle  : Internal Bank Account Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
              MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
              OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class STM_SAP_0510 : business script for STM_SAP_0510
 */
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
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				break;
			case "btn_ok":
				if(sheetObject1.RowCount()== 0){
					ComClosePopup(); 
				}else{
					comPopupOK();
				}
				break;
			case "btn_close":
				ComClosePopup(); 
	            break;	
			case "btns_search_ofc":
				var  office_type="";
				if(formObj.ofc_type[0].checked) {
					office_type=formObj.ofc_type[0].value;
				} else if(formObj.ofc_type[1].checked) {
					office_type=formObj.ofc_type[1].value;
				} else {
					office_type=formObj.ofc_type[2].value;
				}
				var param="?ofc_type=" + office_type + "&ofc_code="+formObj.ofc_cd.value;
				ComOpenPopup("STM_SAP_0500.do"+param, 700, 400, "setFiOffice", "0,0", true, false);
				break;	    
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('SAP00500');
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
    initControl();
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
 * loading HTML Control event <br>
 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence number in sheetObjects array
 **/
function initControl() {
	//** Date Separator **/
	DATE_SEPARATOR="-";
	var formObj=document.form;
    //handling Axon event. event catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    , formObj); 	//- handling code when OnBeforeDeactivate(blur) event
	axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   , formObj);            //- handling code when OnBeforeActivate event in case of existing dataformat property
    axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj); 	//- handling code when onkeypress event in case of existing dataformat property
    axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);
}
//handling Axon event 2
function obj_blur(){
    ComChkObjValid(event.srcElement);
	var src=ComGetEvent("name")
}
function obj_focus(){
    ComClearSeparator(event.srcElement);
}
function obj_keypress(){
	var src=ComGetEvent("name")
	switch(event.srcElement.dataformat){
		case "engup":
			ComKeyOnlyAlphabet('upper');
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
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;	
	switch (sheetNo) {
	case 1: //t1sheet1 init
	    with(sheetObj){
		      var HeadTitle1="|Bank Acct No|Bank Acct Name|Bank Name|Bank Branch Name|Bank Account Type(L)|Bank Account Type(M)|Curr";
		      HeadTitle1 += "|BANK_ACCT_SEQ|BANK_BRANCH_SEQ|BANK_NAME_ALT|BANK_BRANCH_NAME_ALT|AP_OFFICE_CODE|AP_CONTROL_OFFICE_CODE|AR_OFFICE_CODE|AR_CONTROL_OFFICE_CODE|BANK_ACCT_MAJOR_TYPE|BANK_ACCT_MINOR_TYPE|ASSET_CODE_COMBINATION_ID|COUNTRY_CODE";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      (headCount, 0, 0, true);
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"bank_acct_number",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"bank_acct_name",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"bank_name",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"bank_branch_name",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"bank_acct_major",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"bank_acct_minor",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"currency_code",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bank_acct_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bank_branch_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bank_name_alt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bank_branch_name_alt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ap_office_code",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ap_control_office_code",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ar_office_code",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ar_control_office_code",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bank_acct_major_type",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bank_acct_minor_type",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"asset_code_combination_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"country_code",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		      SetEditable(1);
		      //SetSheetHeight(320);
		      resizeSheet();
            }
   break;
	}
}
// handling sheet process, 서버 호출 펑션
function doActionIBSheet(sheetObj, formObj, sAction) {
	if (!validateForm(sheetObj, formObj, sAction))
		return;
	switch (sAction) {		
		case IBSEARCH: //retrieve
			formObj.f_cmd.value=SEARCH;			
 			var sXml=sheetObj.GetSearchData("STM_SAP_0510GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(sXml,{Sync:1} );
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
			break;
	}
	return true;
}
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	//if combined data
	for (var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++){
		}
}
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var sName=sheetObj.ColSaveName(Col);
	var formObj=document.form;
}
//PARAMETER
function sheet1_OnDblClick(sheetObj, Row, Col) {
	 comPopupOK();
}
/**
 * Finance Office Code - return data from popup
 */
function setFiOffice(aryPopupData) {
	var formObj=document.form;
	if(aryPopupData[0][1] == "AP"){
		formObj.ofc_type[0].checked=true;
		formObj.ofc_cd.value=aryPopupData[0][2];
	}else if(aryPopupData[0][1] == "AR"){
		formObj.ofc_type[1].checked=true;
		formObj.ofc_cd.value=aryPopupData[0][2];
	}
}
function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}

