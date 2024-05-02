/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0257.js
*@FileTitle  :  Europe Customs EDI 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
=========================================================*/
/**
 * [CPS_CNI_0028] Miscellaneous Code Creation
 * @extends
 * @class business script for Miscellaneous Code Creation
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
	 combo1=comboObjects[0];
	 comboCnt=comboObjects.length;
	 for(var k=0;k<comboObjects.length;k++){
	 	initCombo(comboObjects[k]);
	 }
    //registering initial event 
    initControl();
    initPage();
}
function initPage() {
	sheet1.SetWaitImageVisible(0);
	doActionIBSheet(INIT); 	
	combo1.SetSelectCode("09");
	sheet1.SetWaitImageVisible(1);
}
/**
* registering initial event 
*/
function initControl() {
   //keypress
//   axon_event.addListenerForm('keypress', 'obj_keypress', frm);
   // focus in
   axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
   // focus out
   axon_event.addListenerFormat('beforeactivate',   'obj_activate',    frm);
}
/**
* Combobox Initialize, Header Definition
* @param {IBMultiCombo} comboObj  comboObj
*/
function initCombo(comboObj) {
	//comboObj.MultiSelect = false;
//no support[check again]CLT 	comboObj.UseCode=true;
//no support[check again]CLT 	comboObj.LineColor="#ffffff";
	comboObj.SetColAlign(0, "left");
	comboObj.SetColAlign(1, "left");
	comboObj.SetMultiSeparator(",");
	comboObj.SetDropHeight(240);
}
//Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
function combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){  	
	doActionIBSheet(SEARCHLIST01);
	// setting input limit in case of Type of Cargo - max 3 digit
	var classCd=newCode ;
	if (classCd == "15") {
//		sheetObjects[0].InitColumns(0, 2 , dtData,			80,		daCenter,	true,		"clm_misc_cd",	true,       "",			dfNone,		0, 		false, 		true, 		3, 		false, true, "", true);
		sheetObjects[0].SetColProperty(0, "clm_misc_cd", {EditLen:3});
	}else{
		sheetObjects[0].SetColProperty(0, "clm_misc_cd", {EditLen:4});
//		sheetObjects[0].InitColumns(0, 2 , dtData,			80,		daCenter,	true,		"clm_misc_cd",	true,       "",			dfNone,		0, 		false, 		true, 		4, 		false, true, "", true);		
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
		        var HeadTitle1="|Seq.|Code|Order|Name|Register|RGOFC|Update|Remark|ClassCd";
		        var headCount=ComCountHeadTitle(HeadTitle1);
	
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		        InitHeaders(headers, info);
	
		        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		               {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"clm_misc_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4, AcceptKeys:"E|N", InputCaseSensitive:1},
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dp_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, AcceptKeys:"N" },
		               {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"clm_misc_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"clm_misc_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:400 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"clss_clm_misc_cd" } ];
		         
		        InitColumns(cols);
	
		        SetEditable(1);
		        SetShowButtonImage(1);
		        SetSheetHeight(420);
			break;		
		}
	}
}
// ===================================================================================
// Private function
// ===================================================================================
/**
 * setting Location
 */
 function setLocation(rowArray) { 
    frm.loc_cd.value=rowArray[0][3];
 }
 function setClassCodeList() {
		combo1.RemoveAll();
		var j=0;
		for(var i=0 ; i < classCodeList.length ; i++ ) {			
			var clist=classCodeList[i];
			if (clist != undefined && clist != null) {
				combo1.InsertItem(j++,clist["clss_clm_misc_nm"],clist["clss_clm_misc_cd"]);
			}		
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
	    	if (ComShowCodeConfirm("CNI00015")) {
	    		initPage();
	    	}
	        break;	
		case "btn1_Save":
			frm.f_cmd.value=MULTI;		
			if(ComChkValid(frm)) {
				//CNI00012(Do you want to save changes?)
				if (ComShowCodeConfirm("CNI00012")) {
					doActionIBSheet(MULTI);
				}
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
    //
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
		var sXml=sheet1.GetSearchData("CPS_CNI_0028GS.do", FormQueryString(frm));
		var arrXml=sXml.split("|$$|");
		// ------------------------------------------------------------
		// setting sheet
		// ------------------------------------------------------------
		if (arrXml.length > 0) {
			sheet1.LoadSearchData(arrXml[0],{Sync:0} );
		}else{
			ComShowCodeMessage("CNI00013");
		}
	} else if (sAction == MULTI) {		
		if (validateForm(sAction)) {
			frm.f_cmd.value=MULTI;
			setSheetClassCd();
			var sXml=sheet1.DoSave("CPS_CNI_0028GS.do", FormQueryString(frm),-1,false);
//			if(sXml) {
//				
//				doActionIBSheet(SEARCHLIST01);
//			}
//			
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
	}  
}

function sheet1_OnSaveEnd(ErrMsg){
	doActionIBSheet(SEARCHLIST01);
}
function sheet1_OnClick(sheetObj, row, col, value) {
    if (sheetObj.ColSaveName(col) == "clm_misc_rmk") {
    	ComShowMemoPad(sheetObj, null, null, null, null, null, 1300);
	}
}
//===================================================================================
//Private function
//===================================================================================
function setSheetClassCd() {
	for(var row=0; row<=sheet1.LastRow(); row++) {
		if (sheet1.GetRowStatus(row) == "I")  {
			var clss_cd=combo1.GetSelectCode();
			sheet1.SetCellValue(row , "clss_clm_misc_cd",clss_cd,0);
		}
	}
}
/**
* handling process for input validation
*/
function validateForm(sAction){
	for(var row=0; row<=sheet1.LastRow(); row++) {
		if (sheet1.GetRowStatus(row) == "I")  {
			var misc_cd=sheet1.GetCellValue(row , "clm_misc_cd");
			for(var row2=0; row2<=sheet1.LastRow(); row2++) {
				var misc_cd2=sheet1.GetCellValue(row2 , "clm_misc_cd");
				if( (misc_cd==misc_cd2)&&(row!=row2) ){
					ComShowCodeMessage("CNI00002" , "Code"); //CNI00002
					return false;
				}
			}			
		}
	}
	return true;
}
