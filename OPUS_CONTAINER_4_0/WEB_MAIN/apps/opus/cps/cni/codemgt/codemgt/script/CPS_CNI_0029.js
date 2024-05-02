/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0029.js
*@FileTitle  : Miscellaneous Code Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================*/
/**
 * [CPS_CNI_0029] Class Code Inquiry
 * @extends
 * @class business script for Class Code Inquiry
 */

// ===================================================================================
// common global variables
// ===================================================================================
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
//IBMultiCombo
var comboObjects=new Array();
var combo1=null;
var comboCnt=0;
var classCodeList=null;
var comboText=null;
// html form
var frm=null;
/**
 * registering IBSheet Object as list
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* registering IBCombo Object as list 
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source 
* @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
**/
function setComboObject(combo_obj){
comboObjects[comboCnt++]=combo_obj;
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
	 //IBMultiComboinitializing
	 combo1=comboObjects[0]
	 comboCnt=comboObjects.length;
	 for(var k=0;k<comboObjects.length;k++){
	 	initCombo(comboObjects[k]);
	 }
    //registering initial event 
    initControl();
    initPage();
}
function initPage(){
	sheet1.SetWaitImageVisible(0);
	// Combo Init
	doActionIBSheet(INIT); 
	if (frm.popupYn.value == "Y") {
		combo1.SetSelectCode(frm.clss_clm_misc_cd.value);
		combo1.SetEnable(0);
	} else {
		combo1.SetSelectCode("09");
	}
	sheet1.SetWaitImageVisible(1);
	ComSetFocus(frm.clm_misc_cd); 
}
/**
* registering initial event 
*/
function initControl() {
 //  axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
 //  axon_event.addListenerFormat('beforeactivate',   'obj_activate',    frm);
}
/**
* Combobox Initialize, Header Definition
* @param {IBMultiCombo} comboObj  comboObj
*/
function initCombo(comboObj) {
	comboObj.SetColAlign(0, "left");
	comboObj.SetColAlign(1, "left");
	comboObj.SetMultiSeparator(",");
	comboObj.SetDropHeight(240);
}
function combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj,Index_Code, Text){   
	comboText=newText;
	frm.clm_misc_cd.value='';
	frm.clm_misc_nm.value='';
	doActionIBSheet(SEARCHLIST01);
}
function sheet1_OnDblClick(sheet, row, col) {
	if (frm.popupYn.value == "Y") {
		var miscCdVo={
				clm_misc_cd:sheet.GetCellValue(row , "clm_misc_cd"),
				clm_misc_nm:sheet.GetCellValue(row , "clm_misc_nm"),
				cre_usr_id:sheet.GetCellValue(row , "cre_usr_id"),
				cre_ofc_cd:sheet.GetCellValue(row , "cre_ofc_cd"),
				upd_dt:sheet.GetCellValue(row , "upd_dt"),
				clm_misc_rmk:sheet.GetCellValue(row , "clm_misc_rmk"),
				clss_clm_misc_cd:sheet.GetCellValue(row , "clss_clm_misc_cd")
		};
		opener.setMiscCode(miscCdVo);
		ComClosePopup(); 
	}
}
function sheet1_OnClick(sheetObj, row, col, value) {
   if (sheetObj.ColSaveName(col) == "clm_misc_rmk") {
       	ComShowMemoPad(sheetObj, null, null, true, null, null, 1300);
	} 		
}
/**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo sheetNo
  */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;	
	with (sheetObj) {
		switch (sheetObj.id) {
		case "sheet1": 
	            var HeadTitle1="|Seq.|Code|Name|Register|RGOFC|Update|Remark|ClassCd";
	            var headCount=ComCountHeadTitle(HeadTitle1);
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            InitHeaders(headers, info);
	            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                   {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"clm_misc_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"clm_misc_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0,  Width:0,    Align:"Left",    ColMerge:1,   SaveName:"clm_misc_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:400 },
	                   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"clss_clm_misc_cd" } ];
	            InitColumns(cols);
	            if (frm.popupYn.value == "Y") {
		            SetSheetHeight(200);
		            } else {
		            SetSheetHeight(420);
		            }
	            SetEditable(1);
	            SetShowButtonImage(1);
			break;		
		}
	}
}
// ===================================================================================
// Private function
// ===================================================================================
 function setClassCodeList() {
		combo1.RemoveAll();
		for(var i=0 ; i < classCodeList.length ; i++ ) {			
			var clist=classCodeList[i];			
			if(clist!= undefined)
				combo1.InsertItem(i,clist["clss_clm_misc_nm"],clist["clss_clm_misc_cd"]);
		}		
	}
// Event handler processing by button click event
document.onclick=processButtonClick;
/**
 * Event handler processing by button name
 */
function processButtonClick() {
	var srcName=ComGetEvent("name");
	if(ComGetBtnDisable(srcName)) return false;
	switch (srcName) {	
		case "btn2_Row_Add":
			var row=sheet1.DataInsert(-1);
			sheet1.SelectCell(row,"clm_misc_cd",true);
			break;
	    case "btn2_Row_Copy":	    	
	    	var row=sheet1.DataCopy();
	    	sheet1.SetRowStatus(row,"I");
			break;
		case "btn2_Row_Delete":			
			SheetRowDelete(sheet1,sheet1.GetSelectRow());
	        break; 	     
		case "btn1_Retrieve":			
			doActionIBSheet(SEARCHLIST01);			
			break;	
	    case "btn1_New":
	    	initPage();	    	
	        break;	
		case "btn1_Print":	
			doActionIBSheet(PRINT);
	        break; 
		case "btn1_Select":			
			sheet1_OnDblClick(sheet1,sheet1.GetSelectRow(),sheet1.GetSelectCol());
			break;
		case "btn1_Close":
  ComClosePopup(); 
			break;    	
	}
}
/**
 * HTML Control KeyPress event
 */
function obj_keypress() {
    switch (ComGetEvent("name")) {    
    case "clm_misc_cd":
    	ComKeyOnlyAlphabet('uppernum');
		break;
	}
}
 /**
  * HTML Control KeyUp event
  */
 function obj_keyup() {	  
     switch (ComGetEvent("name")) {    
 		case "clm_misc_cd":  			
 			if(frm.clm_misc_cd.value.length > 0 && event.keyCode == 13){
 				doActionIBSheet(SEARCHLIST01);
 			}
 			break;
 		case "clm_misc_nm":  			
 			if(frm.clm_misc_nm.value.length > 0 && event.keyCode == 13){
 				doActionIBSheet(SEARCHLIST01);
 			}
 			break;	
 	}
 }  
/**
 * HTML Control Focus out
 **/
function obj_deactivate() {	 
	var frm=document.form;
	switch (ComGetEvent("name")) {
	case "acct_xch_rt_yrmon":
		break;
	case "usd_cny_xch_rt":		
		break;
	default:
		ComChkObjValid(ComGetEvent());
	}
}
/**
 * HTML Control Foucs in
 */
function obj_activate(){
    ComClearSeparator(ComGetEvent());
}
/**
 * Calling function in case of OnPopupClick event
 * calling popup window <br>
 * @param {IBSheet} sheet
 * @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
 * @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
 */
function sheet1_OnPopupClick(sheet, row, col) {
    if (sheet.ColSaveName(col) == "clm_misc_rmk") {
		ComShowMemoPad(sheet);
	}
}
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	if (sAction == SEARCHLIST01) {
		frm.clss_clm_misc_cd.value=combo1.GetSelectCode();
		frm.f_cmd.value=SEARCHLIST01;		
 		var sXml=sheet1.GetSearchData("CPS_CNI_0029GS.do", FormQueryString(frm));
		var arrXml=sXml.split("|$$|");
		// ------------------------------------------------------------
		// setting sheet
		// ------------------------------------------------------------
		if (arrXml.length > 0) {
			sheet1.LoadSearchData(arrXml[0],{Sync:1} );
		}else{
			ComShowCodeMessage("CNI00013");
		}
	} else if (sAction == INIT) {
		frm.f_cmd.value=INIT;
 		var sXml=sheet1.GetSearchData("CPS_CNI_0028GS.do", FormQueryString(frm));
		var arrXml=sXml.split("|$$|");
		// ------------------------------------------------------------
		// setting combo 
		// ------------------------------------------------------------
		if (arrXml.length > 0) {
			classCodeList=SheetXml2ListMap(arrXml[0]);		
			setClassCodeList();	
		}
	} else if (sAction == PRINT) {
		frm.f_cmd.value=PRINT;
		var rf="/rf ["+RDServerIP + "/CPS_CNI_0085.do]";
		var rpost="/rpost ["+FormQueryString(frm)+"]";
		var rv="/rv NgmSsoName [JSESSIONID] NgmSsoData ["+document.form.jsession.value+"] clss_clm_misc_nm["+comboText+"]";
		var rpaper="/rpaper [A4]";
		if (frm.usr_area.value == "A") {
			rpaper="/rpaper [LETTER]";
		}
		frm.com_mrdArguments.value=rf +" "+ rv +" "+ rpost +" "+ rpaper;
		frm.com_mrdTitle.value="Miscellaneous Code-Inquiry";
		frm.com_mrdBodyTitle.value="Miscellaneous Code-Inquiry";
		frm.com_mrdPath.value="apps/opus/cps/cni/codemgt/codemgt/report/CPS_CNI_0085.mrd";
		//var feature = "resizable=yes,width=1000,height=600"
		popupRd(1000,600);
	}   
}
