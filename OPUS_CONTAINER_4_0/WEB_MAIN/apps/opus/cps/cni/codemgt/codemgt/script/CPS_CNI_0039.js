/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0039.js
*@FileTitle  : [CPS_CNI_0039] Class Code Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
/**
 * [CPS_CNI_0039] Class Code Creation
 * @extends
 * @class business script for Class Code Creation
 */
//function cps_cni_0039() {
//    this.processButtonClick=processButtonClick;
//    this.setSheetObject=setSheetObject;
//    this.loadPage=loadPage;
//    this.initSheet=initSheet;
//    this.initControl=initControl;
//    this.doActionIBSheet=doActionIBSheet;
//    this.setTabObject=setTabObject;
//    this.validateForm=validateForm;
//    this.sheet1_OnClick=sheet1_OnClick;
//}
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
    initPage();
}
function initPage() {
	sheet1.SetWaitImageVisible(0);
    doActionIBSheet(SEARCHLIST01);        
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
//   axon_event.addListenerFormat('beforeactivate',   'obj_activate',    frm);
}
/**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo sheetNo
  */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;	
	switch (sheetObj.id) {
		case "sheet1":
		    with(sheetObj){
			      var HeadTitle1="|Seq.|Code|Name|Register|RGOFC|Update|Remark";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      (headCount, 0, 0, true);
		
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
		
			      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"clss_clm_misc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:260,  Align:"Left",    ColMerge:1,   SaveName:"clss_clm_misc_nm",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"clss_clm_misc_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:400 } ];
			       
			      InitColumns(cols);
			      SetEditable(1);
			      SetSheetHeight(440);
            }
		break;		
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
			sheet1.SelectCell(row,"clss_clm_misc_nm",true);
			break;
		case "btn2_Row_Insert":
			var crow=sheet1.GetSelectRow();
			var row=sheet1.DataInsert(crow-1);
			sheet1.SelectCell(row,"clss_clm_misc_nm",true);
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
			//CNI00012(Do you want to save changes?)
			if (ComShowCodeConfirm("CNI00012")) {
				doActionIBSheet(MULTI);
			}					
	        break;
		case "btn1_Print":	
			doActionIBSheet(PRINT);
	        break; 	    
		case "btn1_Delete":
			//CNI00023	There is no contents to delete.
			if (ComShowCodeConfirm("CNI00023")) {
				doActionIBSheet(REMOVE);
			}
	        break;
	}
}
/**
 * HTML Control KeyPress event
 */
//function obj_keypress() {
//    switch (event.srcElement.name) {    
//    case "acct_xch_rt_yrmon":    	
//    case "usd_cny_xch_rt":
//		break;
//	}
//}
/**
 * HTML Control Focus out
 **/
function obj_deactivate() {	 
	var frm=document.form;
	switch (event.srcElement.name) {
	case "acct_xch_rt_yrmon":
		break;
	case "usd_cny_xch_rt":		
		break;
	default:
		ComChkObjValid(event.srcElement);
	}
}
/**
 * HTML Control Foucs in
 */
function obj_activate(){
    ComClearSeparator(event.srcElement);
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
    if (sheet.ColSaveName(col) == "cntc_pnt_rmk") {
		ComShowMemoPad(sheet);
	}
}
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	if (sAction == SEARCHLIST01) {
		frm.f_cmd.value=SEARCHLIST01;		
 		var sXml=sheet1.GetSearchData("CPS_CNI_0039GS.do", FormQueryString(frm));
		var arrXml=sXml.split("|$$|");
		// ------------------------------------------------------------
		// setting class code
		// ------------------------------------------------------------
		if (arrXml.length > 0) {
			sheet1.LoadSearchData(arrXml[0],{Sync:1} );
		}else{
			ComShowCodeMessage("CNI00013");
		}
	} else if (sAction == MULTI) {		
		frm.f_cmd.value=MULTI;
		if(sheet1.IsDataModified){
			var Row = sheet1.ColValueDup("clss_clm_misc_nm");
			if(Row > 0){
				ComShowCodeMessage("CNI00002", "Name Sheet of " + Row + " row ");
				sheet1.SelectCell(Row, "clss_clm_misc_nm", true);
				return false;
			}
		}
		var sXml=sheet1.DoSave("CPS_CNI_0039GS.do", FormQueryString(frm),-1,false);
//		if(sXml) {
//			doActionIBSheet(SEARCHLIST01);
//		}	
	} else if (sAction == PRINT) {
		frm.f_cmd.value=PRINT;
		var rf="/rf ["+RDServerIP + "/CPS_CNI_0091.do]";
		var rpost="/rpost ["+FormQueryString(frm)+"]";
		var rpaper="/rpaper [A4]";
		if (frm.usr_area.value == "A") {
			rpaper="/rpaper [LETTER]";
		}
		var rv="/rv NgmSsoName [JSESSIONID] NgmSsoData ["+frm.jsession.value+"]";
		frm.com_mrdArguments.value=rv +" "+ rf +" "+ rpost +" "+ rpaper;
		frm.com_mrdTitle.value="Class Code-Creation";
		frm.com_mrdBodyTitle.value="Class Code-Creation";
		frm.com_mrdPath.value="apps/opus/cps/cni/codemgt/codemgt/report/CPS_CNI_0091.mrd";
		//var feature = "resizable=yes,width=1000,height=600";		
		popupRd(1000,600);
	} else if (sAction == REMOVE) {		
		frm.f_cmd.value=REMOVE;		
	}  
}

function sheet1_OnSaveEnd( ErrMsg ){
	doActionIBSheet(SEARCHLIST01);	
}

function sheet1_OnClick(sheetObj, row, col, value) {
        if (sheetObj.ColSaveName(col) == "clss_clm_misc_rmk") {
        	ComShowMemoPad(sheetObj, null, null, null, null, null, 1300);
		}
}
