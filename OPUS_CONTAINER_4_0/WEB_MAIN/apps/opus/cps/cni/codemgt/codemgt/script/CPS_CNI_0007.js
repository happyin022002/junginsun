/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0007.js
 *@FileTitle : [CPS_CNI_0007] Office Code Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
/**
 * [cps_cni_0007] Main Code Creation
 * @extends
 * @class business script for Main Code Creation 
 */
// ===================================================================================
// common global variables
// ===================================================================================
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
// html form
var frm=null;
/**
 * registering IBSheet Object as list
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
// ===================================================================================
// initializing 
// ===================================================================================
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 * @param {string} current year
 **/
function loadPage() {
    //setting Variables
    frm=document.form;
    sheet1=sheetObjects[0];    
    sheetCnt=sheetObjects.length ;
    //sheet initial 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    //registering initial event 
    initControl();
	doActionIBSheet(SEARCHLIST01);
    frm.ofc_cd.focus();
}
/**
* registering initial event 
*/
function initControl() {
//   axon_event.addListenerForm('keypress', 'obj_keypress', frm);
//   axon_event.addListenerForm ('keydown', 'obj_keydown', frm);
   axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
   axon_event.addListenerFormat('beforeactivate',   'obj_activate',    frm);
}
/**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 
  */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetObj.id) {
		case "sheet1":      //sheet1 init
			with (sheetObj) {
	       
	        var HeadTitle1="|Code|Type|Office Name";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	//	        (headCount, 0, 0, true);
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		        InitHeaders(headers, info);
	
		        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				               {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"intg_cd_val_dp_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:0,    Align:"Left",    ColMerge:1,   SaveName:"ofc_eng_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		         
		        InitColumns(cols);
		        SetEditable(1);
		        SetSheetHeight(282);
		        SetCountFormat("[SELECTDATAROW / TOTALROWS]");
		   }
			break;
	}
}
// ===================================================================================
// Private function
// ===================================================================================
/**
 * Opener Call
 */
 function setOfficeCode(ofcCd) { 
	opener.setOfficeCode(ofcCd);
  ComClosePopup(); 
 }
// Event handler processing by button click event
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn2_Select":
				 var row=sheet1.GetSelectRow();
				 if (sheet1.RowCount()== 0 || row  < 1) {
				   return;
				 }
				 var ofcCd=sheet1.GetCellValue(sheet1.GetSelectRow(), "ofc_cd");
				 setOfficeCode(ofcCd);
				break;
			case "btn1_Retrieve":
				doActionIBSheet(SEARCHLIST01);
				break; 
			case "btn1_New":
				//CNI00015 Do you want to initialize?
			    /*
				if (ComShowCodeConfirm("CNI00015") ) {
					ComResetAll();
				}
				*/
				ComResetAll();
				ComSetFocus(frm.ofc_cd);
				break;
			case "btn1_Close":
				ComClosePopup(); 
				break; 
		} // end switch
}
/**
 * HTML Control KeyDowm event
 */
function obj_keydown() {
    switch (event.srcElement.name) {    
    case "ofc_cd":
		if (event.keyCode == 13) {
			doActionIBSheet(SEARCHLIST01);
		}
	break;
	}
}
/**
 * The function called when OnDblClick event triggered
 * Calling function in case of OnDblClick event
 * @param {IBSheet} sheet
 * @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
 * @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
 */
function sheet1_OnDblClick(sheet, row, col) {
var ofcCd=sheet1.GetCellValue(row , "ofc_cd");
	setOfficeCode(ofcCd);
}
/**
 * The function called when OnSearchEnd event triggered
 * Calling Function in case of OnSearchEnd event
 * @param {IBSheet} sheet
 * @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
 * @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
*/
function sheet1_OnSearchEnd(sheet, row, col) {
	//ComSetFocus(frm.ofc_cd);
}
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	if (sAction == SEARCHLIST01) {
		frm.f_cmd.value=SEARCHLIST01;		
 		var sXml=sheet1.GetSearchData("CPS_CNI_0007GS.do", FormQueryString(frm));
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0) {
			sheet1.LoadSearchData(arrXml[0],{Sync:1} );
		}
	} else if (sAction == MULTI) {
		//frm.f_cmd.value = MULTI;		
	} else if (sAction == REMOVE) {		
		//frm.f_cmd.value = REMOVE;		
	}  
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
	}
	return true;
}
