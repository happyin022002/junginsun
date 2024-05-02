/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0043.js
*@FileTitle  : Impending TB Claim
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
=========================================================*/
// ===================================================================================
// common global variables
// ===================================================================================
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
var sheet2=null;
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
function loadPage(year) {
    //setting Variables
    frm=document.form;
    sheet1=sheetObjects[0];    
    sheet2=sheetObjects[1];  
    sheetCnt=sheetObjects.length ;
    //sheet initial 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    doActionIBSheet(SEARCHLIST01);
}
/**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;	
	with (sheetObj) {
		switch (sheetObj.id) {
		case "sheet1": 
			var HeadTitle1="Seq.|DOTB|CL|Claim NO.|A|HOFC|Handler|STS|Claimant";
			var headCount=ComCountHeadTitle(HeadTitle1);
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"data_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"tm_bar_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:22,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_div_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:15,   Align:"Center",  ColMerge:1,   SaveName:"clm_area_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"hdlr_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"hdlr_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"clmt_clm_pty_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			   
			InitColumns(cols);
			SetSheetHeight(160);
			SetEditable(1);
//			InitViewFormat(0, "tm_bar_dt", "yyyy-mm-dd");
			break;	
		case "sheet2": 
			var HeadTitle1="Seq.|LP DOTB|CL|Claim NO.|A|HOFC|Handler|STS|Liable Party";
			var headCount=ComCountHeadTitle(HeadTitle1);
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"data_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			   {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"tm_bar_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			   {Type:"Text",      Hidden:0,  Width:22,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_div_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			   {Type:"Text",      Hidden:0,  Width:15,   Align:"Center",  ColMerge:1,   SaveName:"clm_area_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			   {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"hdlr_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"hdlr_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			   {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			   {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"labl_clm_pty_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			 
			InitColumns(cols);
			SetSheetHeight(160);
			SetEditable(1);
//			InitViewFormat(0, "tm_bar_dt", "yyyy-mm-dd");
			break;
		}
	}
}
// ===================================================================================
// Private function
// ===================================================================================
// ===================================================================================
// Form 이벤트 처리
// ===================================================================================
// Event handler processing by button click event
document.onclick=processButtonClick;
/**
 * Event handler processing by button name
 */
function processButtonClick() {
	var srcName=ComGetEvent("name");
	if(ComGetBtnDisable(srcName)) return false;
	switch (srcName) {	
    case "btn1_Detail":
    	if (sheet1.RowCount()> 0 && sheet1.GetSelectRow()> 0) {
    		opener.location.href="CPS_CNI_0003.do?parentPgmNo=CPS_CNI_M001&pgmNo=CPS_CNI_0003&cgo_clm_no=" + sheet1.GetCellValue( sheet1.GetSelectRow(), "cgo_clm_no");
    	}
    	if (sheet2.RowCount()> 0 && sheet2.GetSelectRow()> 0) {
    		opener.location.href="CPS_CNI_0015.do?parentPgmNo=CPS_CNI_M001&pgmNo=CPS_CNI_0015&cgo_clm_no=" + sheet2.GetCellValue( sheet2.GetSelectRow(), "cgo_clm_no");
    	}
		break;
    case "btn1_Retrieve":
    	doActionIBSheet(SEARCHLIST01);
        break;
    case "btn1_New":
    	ComResetAll();
        break;
    case "btn1_Close":
    	ComClosePopup(); 
        break;       
	}
}
// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
/**
* The function called when OnDbClick event on Sheet1 triggered 
* @param {ibsheet} sheetObj Mandatory HTML Tag Object   
* @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
* @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
*/
function sheet1_OnDblClick(sheet, row, col) {	
	if (row < 1) {
		return;
	}
	opener.location.href="CPS_CNI_0003.do?parentPgmNo=CPS_CNI_M001&pgmNo=CPS_CNI_0003&cgo_clm_no=" + sheet1.GetCellValue( sheet1.GetSelectRow(), "cgo_clm_no");
	ComClosePopup(); 
}
/**
* Calling Function in case of OnChange event
* @param {ibsheet} sheetObj Mandatory HTML Tag Object   
* @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
* @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
* @param {string} value Changed value, the value when saving, to which format is not applied
*/
function sheet1_OnClick(sheet , row, col, value) {	
	sheet2.SetSelectRow(0);
}
/**
* The function called when OnDbClick event on Sheet1 triggered 
* @param {ibsheet} sheetObj Mandatory HTML Tag Object   
* @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
* @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
*/
function sheet2_OnDblClick(sheet, row, col) {	
	if (row < 1) {
		return;
	}
	opener.location.href="CPS_CNI_0015.do?parentPgmNo=CPS_CNI_M001&pgmNo=CPS_CNI_0015&cgo_clm_no=" + sheet2.GetCellValue( sheet2.GetSelectRow(), "cgo_clm_no");
	ComClosePopup(); 
}
/**
* sheet2 OnClick후 이벤트
* @param {ibsheet} sheetObj Mandatory HTML Tag Object   
* @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
* @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
* @param {string} value Changed value, the value when saving, to which format is not applied
*/
function sheet2_OnClick(sheet , row, col, value) {	
	sheet1.SetSelectRow(0);
}
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {	
	if (sAction == SEARCHLIST01) {
		frm.f_cmd.value=SEARCHLIST01;		
		var sXml=sheet1.GetSearchData("CPS_CNI_0043GS.do", FormQueryString(frm));
		var arrXml=sXml.split("|$$|");
		// ------------------------------------------------------------
		// 조회 
		// ------------------------------------------------------------
		if (arrXml.length > 0) {
			sheet1.LoadSearchData(arrXml[0],{Sync:1} );
		} 
		if (arrXml.length > 1) {
			sheet2.LoadSearchData(arrXml[1],{Sync:1} );
		}
		if (sheet1.RowCount()> 0 || sheet2.RowCount()> 0) {
			ComBtnEnable("btn1_Detail");
		} else {
			ComBtnDisable("btn1_Detail");
		}
	} 
}
