/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0009.js
*@FileTitle  : invoice type pOPUP
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
 * @class stm_sap_0009 : business script for stm_sap_0009
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
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				break;
			case "btn_OK":
				if(sheetObject1.RowCount()== 0){
					ComClosePopup(); 
				}else{
					comPopupOK();
				}
				break;
			case "btn_Close":
				ComClosePopup(); 
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
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
    initControl();
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
	axon_event.addListenerFormat('blur', 'obj_blur'    , formObj); 	//- handling code when OnBeforeDeactivate(blur) event
	axon_event.addListenerFormat('blur'  , 'obj_focus'   , formObj);            //- handling code when OnBeforeActivate event in case of existing dataformat property
//    axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj); 	//- handling code when onkeypress event in case of existing dataformat property
//    axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);
}
//handling Axon event 2
function obj_blur(){
    ComChkObjValid(ComGetEvent());
	var src=ComGetEvent("name");
}
function obj_focus(){
    ComClearSeparator(ComGetEvent());
}
function obj_keypress(){
	var src=ComGetEvent("name");
    switch(event.srcElement.dataformat){
		case "engup":
			if(event.srcElement.name=="inv_tp_cd"){
				if(event.keyCode!=32){ // null
					ComKeyOnlyAlphabet('uppernum');
				}
			}else{
				ComKeyOnlyAlphabet('uppernum');
			}
	    break;
    }
}
function form_keyup(){
	ComKeyEnter('lengthnextfocus');
}
function obj_onclick(){
	var src=ComGetEvent("name");
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
	        var HeadTitle1="|Invoice Type|Description";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	        var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"lu_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:220,  Align:"Left",    ColMerge:1,   SaveName:"lu_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	         
	        InitColumns(cols);
	
	        SetEditable(1);
	        //SetSheetHeight(360);
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
		case IBSEARCH: //retrieve
			formObj.f_cmd.value=SEARCH;			
			var sXml=sheetObj.GetSearchData("STM_SAP_0009GS.do", FormQueryString(formObj));
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
/**
 * Returning to Parent Screen
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {
	 comPopupOK();
}
function sheet1_OnClick(sheetObj, Row, Col){
	window.returnValue=sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'lu_cd');
}
function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}
