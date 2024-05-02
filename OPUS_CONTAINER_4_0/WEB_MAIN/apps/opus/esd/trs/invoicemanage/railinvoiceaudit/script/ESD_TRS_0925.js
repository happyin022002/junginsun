/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0925.js
*@FileTitle  : Re-Audit
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
/**------------------From here the common JavaScript function is defined.     ------------------*/
/** Common global variable */
var sheetObjects=new Array();
var sheetCnt=0;
var before_click_row=1;
//var opener=window.dialogArguments;
var sheet_height1 = 7;
/** Event handler processing by button click event */
document.onclick=processButtonClick;
/**Event handler processing by button name */
function processButtonClick(){
	/*****Case more than two additional sheets tab sheet is used to specify a variable *****/
	 var sheetObject=sheetObjects[0];
	 var sheetObject1=sheetObjects[1];
	 var sheetObject2=sheetObjects[2];
	 var sheetObject3=sheetObjects[3];
	 /*******************************************************/
	 var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_apply":
				if(formObject.mode.value == 'search') return;
//				if(opener.document.tab1.SelectedIndex == 0 )
//				{
//					return;
//				}
				if(sheetObject3.CheckedRows('sel') != "1")
				{
					ComShowCodeMessage("COM12177" );
					return;
				}
				if (chkCntr(sheetObject3))
				{
					ComShowCodeMessage("TRS90003" );
					return;
				}
//				if (chkEnis(sheetObject3))
//				{
//					ComShowCodeMessage("COM12113", 'APLS or DOM');
//					return;
//				}
				if(!chkCUR(sheetObject, sheetObject3)){
					ComShowCodeMessage("TRS90407" );
					return;
				}
				setCoincidence();
				break;
			case "btn_close":
				ComClosePopup(); 
				break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
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
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	fillFormData();
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
			    var HeadTitle="Seq.|CNTR\nNo.|Waybill\nDate|Invoice\nOrigion|Invoice\nDest.|Invoice\nCUR|Invoice\nAmount";
	
			    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
			    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			    var headers = [ { Text:HeadTitle, Align:"Center"} ];
			    InitHeaders(headers, info);
	
			    var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eq_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"wbl_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"inv_org_nod_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"inv_dest_nod_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"inv_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"inv_bzc_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"inv_bil_amt" },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"wbl_no" },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd" },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"sub_inv_seq" },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"eq_seq" } ];
			     
			    InitColumns(cols);
	
			    SetEditable(0);
			    SetColProperty('inv_curr_cd', {ComboText:"|"+inv_curr_cdText, ComboCode:"|"+inv_curr_cdCode} );
//			    SetSheetHeigth(ComGetSheetHeigth(sheetObj,7));
			    SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height1));
		   }
			break;
		case 2:      //sheet2 init
			with (sheetObj) {
			    var HeadTitle="Rail\nRoad|Sight ABBR|Arrival\nDate|Arrival\nLocation|Arrival\nLocation|Dest.\nLocation|Dest.\nLocation";
	
			    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
			    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			    var headers = [ { Text:HeadTitle, Align:"Center"} ];
			    InitHeaders(headers, info);
	
			    var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"clm_crr_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"clm_sght_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"arr_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"arr_loc_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"arr_ste_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"dep_loc_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"dep_ste_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			     
			    InitColumns(cols);
	
			    SetEditable(0);
			    SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height1));
		   }
			break;
		case 3: //sheet3 init
			with (sheetObj) {
			    var HeadTitle="Vendor|Vendor|Invoice\nOrigin|Invoice\nDestination|Invoice\nCUR|Invoice\nAmount|Invoice No.|Invoice\nStatus|Non\nBill|Waybill\nDate|Paid\nDate";
	
			    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
			    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			    var headers = [ { Text:HeadTitle, Align:"Center"} ];
			    InitHeaders(headers, info);
	
			    var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inv_vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vndr_abbr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"inv_org_nod_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"inv_dest_nod_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"inv_curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"non_bil_inv_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trsp_inv_aud_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"non_bill",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"wbl_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pay_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			     
			    InitColumns(cols);
	
			    SetEditable(0);
			    SetColProperty('inv_curr_cd', {ComboText:"|"+inv_curr_cdText, ComboCode:"|"+inv_curr_cdCode} );
			    SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height1));
		   }
			break;
		case 4:  //sheet4 init
			with (sheetObj) {
			    var HeadTitle=" |Vendor|Vendor|From Node|From Node|To Node|To Node|OPUS\nCUR|OPUS\nAmount|Invoice\nNo.|Invoice\nStatus|Cargo|Rail Billing\nDate|Remark";
	
			    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
			    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			    var headers = [ { Text:HeadTitle, Align:"Center"} ];
			    InitHeaders(headers, info);
	
			    var cols = [ {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sel" },
			              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vndr_abbr_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"fm_nod_cd1",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"fm_nod_cd2",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"to_nod_cd1",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"to_nod_cd2",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			              {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			              {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"bzc_amt",                    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inv_no",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trsp_inv_aud_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			              {Type:"Combo",     Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"cgo_tp_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			              {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"rail_bil_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"spcl_instr_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsp_so_ofc_cty_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsp_so_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"fm_nod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"to_nod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pay_flg",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"org_trsp_rail_inv_aud_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"crnt_trsp_rail_inv_aud_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"eq_no" },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd" },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"fuel_scg_amt" },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ovr_wgt_scg_amt" },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_org_nod_nm" },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_dest_nod_nm" },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_curr_cd" },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_bil_amt" },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_bzc_amt" },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"wbl_dt" },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"wbl_no" },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_rmk" },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"wbl_no" },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"sub_inv_seq" },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"sub_rail_seq" },
			              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsp_inv_tp_cd" } ];
			     
			    InitColumns(cols);
	
			    SetEditable(1);
			    SetColProperty('cgo_tp_cd', {ComboText:"|"+cgo_tp_cdText, ComboCode:"|"+cgo_tp_cdCode} );
			    SetColProperty('curr_cd', {ComboText:"|"+inv_curr_cdText, ComboCode:"|"+inv_curr_cdCode} );
			    SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height1));
		   }
			break;
	}
}
//handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	   case IBSEARCH:      //retrieve
			formObj.f_cmd.value=SEARCH;
//			CJO CHANGE 20090902
			var sXml=sheetObj.GetSearchData("ESD_TRS_0925GS.do" , TrsFrmQryString(formObj));
			var arrXml=sXml.split("|$$|");
			sheetObj.RemoveEtcData();
			if (arrXml.length > 0) sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
			if (arrXml.length > 1) sheetObjects[2].LoadSearchData(arrXml[1],{Sync:1} );
			if (arrXml.length > 2) sheetObjects[3].LoadSearchData(arrXml[2],{Sync:1} );
			sheetObj.ShowDebugMsg(false);
			break;
	   case IBLOADEXCEL:        //excel upload
		   sheetObj.LoadExcel();
		  break;
	}
}
function sheet1_OnClick(sheetObj , row , col)
{
	//if(before_click_row == row) return;
	document.form.eq_no.value=sheetObj.GetCellValue(row,"eq_no");
	document.form.wbl_dt.value=sheetObj.GetCellValue(row,"wbl_dt");
	doActionIBSheet(sheetObjects[1], document.form , IBSEARCH);
	setSheetData(row);
	before_click_row=row;
	sheetObj.SelectCell(row, col);
}
function sheet1_OnKeyUp(sheetObj, row, col, keycode, shift)
{
	if(before_click_row != row){
		document.form.eq_no.value=sheetObj.GetCellValue(row,"eq_no");
		document.form.wbl_dt.value=sheetObj.GetCellValue(row,"wbl_dt");
		doActionIBSheet(sheetObjects[1], document.form , IBSEARCH);
		setSheetData(row);
		before_click_row=row;
	}
	sheetObj.SelectCell(row, col);
}
function setSheetData(row)
{
	 for(var i=1 ; i < sheetObjects[3].RowCount()+1 ; i++)
	 {
		 sheetObjects[3].SetCellValue(i, "seq",sheetObjects[0].GetCellValue(row, "seq"),0);
	 }
}
/**
 * Enter Data into the form when the initial loading
 */
function fillFormData()
{	 
	var formObj=document.form;//INV_NO='20090612HCD'
//	if (!opener) opener=window.dialogArguments;
//    if(!opener) opener=parent;
	moveSheetData(opener.sheetObjects[formObj.sel_sheet_idx.value] , sheetObjects[0] , 'sel');
	document.form.eq_no.value=sheetObjects[0].GetCellValue(1,"eq_no");
	document.form.wbl_dt.value=sheetObjects[0].GetCellValue(1,"wbl_dt");
	document.form.rail_road_code.value=opener.rail_road_code.GetSelectCode();
	doActionIBSheet(sheetObjects[1], document.form , IBSEARCH);
	setSheetData(1);
}
function chkCntr(sheetObj)
{
	var row ;
	var sts;
	row=sheetObj.FindCheckedRow('sel');
	sts=sheetObj.GetCellValue(row.substring(0, row.length-1),'trsp_inv_aud_sts_cd');
	if (sts == "CF")
	{
		return true;
	}
	return false;
}
/*
 * Re-Audit List of Billing and Invoice CUR comparison of the OPUS CUR
 */
function chkCUR(sheetObj1, sheetObj2){
	 var inv_curr_cd=sheetObj1.GetCellValue(1,'inv_curr_cd');
	 var row=sheetObj2.FindCheckedRow('sel');
	 var curr_cd=sheetObj2.GetCellValue(row.substring(0, row.length-1),'curr_cd');
	 if(inv_curr_cd == curr_cd){
		 return true;
	 }else{
		 return false;
	 }	
}
function setCoincidence(){
	var formObj=document.form;
	var reAuditList_sheetObj=sheetObjects[0];
	var billing_SheetObj=sheetObjects[3];
	var coincidence_sheetObj=opener.sheetObjects[0];
	var invoiceOnly_sheetObj=opener.sheetObjects[formObj.sel_sheet_idx.value];
	var row=billing_SheetObj.FindCheckedRow('sel');
	row=row.substring(0, row.length-1);
	var so_seq=billing_SheetObj.GetCellValue(row , 'trsp_so_seq');
	var coincidence_row=coincidence_sheetObj.FindText('trsp_so_seq' , so_seq );
	var orgTrspRailInvAudCd='I';
	if(coincidence_row != -1 ){
		if(confirm(ComGetMsg("COM12115",'S/O')+'\nAre you sure you want to proceed?')) {
			coincidence_sheetObj.RowDelete(coincidence_row , false);
		}else{
			return;
		}
	}
	if (formObj.sel_sheet_idx.value == '1') orgTrspRailInvAudCd='D'
	billing_SheetObj.SetCellValue(row, 'pay_flg','1',0);
	billing_SheetObj.SetCellValue(row, 'org_trsp_rail_inv_aud_cd',orgTrspRailInvAudCd,0);
	billing_SheetObj.SetCellValue(row, 'crnt_trsp_rail_inv_aud_cd','C',0);
	var queryStr=billing_SheetObj.GetSaveString(false, false, 'sel');
	coincidence_sheetObj.DoSearch("ESD_TRS_0969.screen", queryStr,{Append:true} );
	var coincidence_lastRow=coincidence_sheetObj.LastRow();
	var colName=null;
	for ( var k=0 ; k < reAuditList_sheetObj.LastCol(); k++){
		colName=reAuditList_sheetObj.ColSaveName(k);
		coincidence_sheetObj.SetCellValue(coincidence_lastRow, colName, reAuditList_sheetObj.GetCellValue(before_click_row, colName));
	}
	var eq_seq_row=invoiceOnly_sheetObj.FindText('eq_seq', reAuditList_sheetObj.GetCellValue(before_click_row, 'eq_seq'));
	var trsp_inv_tp_cd=invoiceOnly_sheetObj.GetCellValue(eq_seq_row, 'trsp_inv_tp_cd');
	if(trsp_inv_tp_cd == 'M')
		coincidence_sheetObj.SetCellValue(coincidence_lastRow, 'trsp_inv_tp_cd',trsp_inv_tp_cd,0);
	else 
		coincidence_sheetObj.SetCellValue(coincidence_lastRow, 'trsp_inv_tp_cd','F',0);
	invoiceOnly_sheetObj.SetCellValue(eq_seq_row, "pay_flg",0);
	invoiceOnly_sheetObj.RowDelete(eq_seq_row , false);
	reAuditList_sheetObj.RowDelete(before_click_row , false);
	ComShowCodeMessage("COM12116",'Apply');
	if(reAuditList_sheetObj.RowCount()> 0){
		var new_row=reAuditList_sheetObj.GetSelectRow();
		var col=1;
		document.form.eq_no.value=reAuditList_sheetObj.GetCellValue(new_row,"eq_no");
		document.form.wbl_dt.value=reAuditList_sheetObj.GetCellValue(new_row,"wbl_dt");
		doActionIBSheet(sheetObjects[1], document.form , IBSEARCH);
		setSheetData(new_row);
		before_click_row=new_row;
		reAuditList_sheetObj.SelectCell(new_row, col);
	}
}
/*
* To move the data from Sheet 2 -Checked to move data
* @param : fromSheet - Object id of the original Moving Sheet
* @param : toSheet   - Sheet of Moving Target Object id
* @param : chkCol    - The index of the checkbox column
* @return : none
* @sample
*  moveSheetData(mySheet1, mySheet2, 2);
*/
function moveSheetData(fromSheet, toSheet, chkCol)  {
	var queryStr=fromSheet.GetSaveString(false, false, chkCol);
	toSheet.DoSearch("ESD_TRS_0969.screen", queryStr,{Append:true} );
}
