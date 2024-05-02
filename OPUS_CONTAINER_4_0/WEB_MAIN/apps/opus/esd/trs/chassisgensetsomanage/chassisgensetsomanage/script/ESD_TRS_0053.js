/*=========================================================
* CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TRS_0053.js
*@FileTitle  : Chassis & Genset ( ESD_TRS_0053 ) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/05
=========================================================*/
/**
 * @extends 
 * @class ESD_TRS_0053 : business script for ESD_TRS_0053
 */
function ESD_TRS_0053() {
    this.processButtonClick=processButtonClick;
    this.setSheetObject=setSheetObject;
    this.setComboObject=setComboObject;
    this.setTabObject=setTabObject;
    this.loadPage=loadPage;
    this.initSheet=initSheet;        
    this.initControl=initControl;
    this.initTab=initTab;
    this.doActionIBSheet=doActionIBSheet;
    this.validateForm=validateForm;
}
var sheetObjects=new Array();
var sheetCnt=0;
var seqNo=0;
var checkedChassis='chassis';
document.onclick=processButtonClick;
function processButtonClick(){
	 var sheetObject=sheetObjects[0];
	 var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn_retrieve": {
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			}
			case "btn_reset":
				resetForm(formObject);
				break;
			case "btn_minimize":
				if(document.all.MiniLayer.style.display != "none"){
					document.all.MiniLayer.style.display="none";
					sheet.SetSheetHeight(ComGetSheetHeight(sheet, 17));
				}
				else {
					document.all.MiniLayer.style.display="";
					sheet.SetSheetHeight(ComGetSheetHeight(sheet, 12));
					resizeSheet();
				}
				break;
			case "btns_calendar1":
				 var cal=new ComCalendar();
				 cal.select(formObject.sdate, 'sdate', 'yyyy-MM-dd');
				break;
			case "btns_calendar2":
				 var cal=new ComCalendar();
				 cal.select(formObject.edate, 'edate', 'yyyy-MM-dd');
				break;
			case "btng_downexcel":
				if(sheetObject.RowCount() < 1){
					ComShowCodeMessage("COM132501");
				}else{
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				}
				
				break;
			case "btng_sodelete":
				doActionIBSheet(sheetObject,formObject,IBDELETE);
         	    break;
			case "btng_unbundling":
				unBundle(sheetObject);
				break;
			case "btng_bundling":
				itemBundling(sheetObject);
				break;
			case "btng_fillineq":
				popEqFileImport(sheetObject, formObject);
				break;
			case "btn_fm_node":
				openHireYardPopup('fm_node');
				break;
			case "btn_to_node":
				openHireYardPopup('to_node');
				break;
			case "btng_rateapply":
				popMultiApply(sheetObject);
				break;
			case "btng_socreation":
				doActionIBSheet(sheetObject,formObject, IBSAVE, 'C');
				break;
			case "btng_woissue":
				doActionIBSheet(sheetObject,formObject, IBSAVE, 'I');
				break;
			case "btn_eq_no":
				rep_Multiful_inquiry(srcName);
				break;
			case 'btns_calendar':
				var cal2=new ComCalendarFromTo();
				cal2.displayType="date";
				cal2.select(document.form.fmdate, document.form.todate, 'yyyyMMdd');
	            break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
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
	for(var i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
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
		    with(sheetObj){
		      var HeadTitle="|STS|Bundle\nSEQ||Bundle\nKind|Kind|EQ No|EQ\nTP/SZ|From\nNode|From\nNode|To\nNode"
		      + "|To\nNode|Trans.\nMode|Lessor|EQ\nLease Term|EQ Owner|EQ Used|Movement\nStatus"
		      + "|Creation Yard|Event Date|Internal Remark"
		      + "|Reference\nCNTR No|Reference\nTP\SZ|Reference\nBKG No"
		      + "|Reference\nB/L No|Outgate Date|Outgate Date|Ingate Date|Ingate Date"
		      + "|Remark\n(Special Instruction)|Verify\nresult|row no";
		      
		      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck" },
		             {Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"trsp_so_cmb_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
		             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"trsp_so_cmb_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trsp_so_cmb_tp_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"chss_mgst_trsp_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eq_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"fm_loc_value",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"fm_yard_value",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"to_loc_value",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"to_yard_value",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		             {Type:"Combo",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"trsp_crr_mod_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"vndr_abbr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		             {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ownr_co_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		             {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"usr_co_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lst_sts_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"inter_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:255 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ref_bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"ref_bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"org_gate_out_date",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"org_gate_out_time",     KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dest_gate_in_date",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dest_gate_in_time",     KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"spcl_instr_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"verify_result",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
		             {Type:"Seq",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sheet_row" },
		             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vndr_seq" },
		             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_nm" },
		             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"isimport" },
		             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"eq_knd_cd" },
		             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsp_so_ofc_cty_cd" },
		             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsp_so_seq" },
		             {Type:"CheckBox",  Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bun_check" },
		             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsp_so_cmb_seq2" },
		             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"org_gate_out_dt" },
		             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"dest_gate_in_dt" },
		             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"wo_issue" } ];
		       
		      InitColumns(cols);
		      SetEditable(1);
		      SetColProperty('trsp_crr_mod_cd', {ComboText:"|"+trsp_crr_mod_cdText, ComboCode:"|"+trsp_crr_mod_cdCode} );
		      SetColProperty('chss_mgst_trsp_tp_cd', {ComboText:"|"+chss_mgst_trsp_tp_cdText, ComboCode:"|"+chss_mgst_trsp_tp_cdCode} );
		      SetColProperty('eq_tpsz_cd', {ComboText:"|" + chss_eq_tpsz_cdCode, ComboCode:"|" + chss_eq_tpsz_cdCode} );
		      SetDataRowMerge(false);
		      resizeSheet();
	      }
			break;
		 case 2:      //sheet1 init
			    with(sheetObj){
				      var HeadTitle="|STS|Bundle\nSEQ||Bundle\nKind|Kind|EQ No|EQ\nTP/SZ|From\nNode|From\nNode|To\nNode|To\nNode|Trans.\nMode|Lessor|EQ\nLease Term|EQ Owner|EQ Used|Movement\nStatus|Creation Yard|Event Date|Internal Remark|Remark\n(Special Instruction)|Verify\nResult|row no";
				      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck" },
				             {Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"trsp_so_cmb_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
				             {Type:"Combo",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"trsp_so_cmb_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
				             {Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"chss_mgst_trsp_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eq_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"fm_loc_value",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"fm_yard_value",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"to_loc_value",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"to_yard_value",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
				             {Type:"Combo",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"trsp_crr_mod_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vndr_abbr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ownr_co_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"usr_co_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lst_sts_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"inter_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:255 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"spcl_instr_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"verify_result",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				             {Type:"Seq",       Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sheet_row" },
				             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vndr_seq" },
				             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_nm" },
				             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"isimport" },
				             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"eq_knd_cd" },
				             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsp_so_ofc_cty_cd" },
				             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsp_so_seq" },
				             {Type:"CheckBox",  Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bun_check" },
				             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsp_so_cmb_seq2" },
				             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"wo_issue" } ];
				       
				      InitColumns(cols);
				      SetEditable(1);
				      SetVisible(false);
				      SetColProperty('trsp_crr_mod_cd', {ComboText:"|"+trsp_crr_mod_cdText, ComboCode:"|"+trsp_crr_mod_cdCode} );
				      SetColProperty('chss_mgst_trsp_tp_cd', {ComboText:"|"+chss_mgst_trsp_tp_cdText, ComboCode:"|"+chss_mgst_trsp_tp_cdCode} );
		      }
		      break;

			case 3:      //sheet1 init
			    with(sheetObj){
				      var HeadTitle="|STS|Bundle\nSEQ|Kind|EQ No|EQ\nTP/SQ|From\nNode|From\nNode|To\nNode|To\nNode|Trans.\nMode|Lessor|EQ\nLease Term|EQ Owner|EQ Used|Movement\nStatus|Creation Yard|Event Date|Internal Remark|Remark\n(Special Instruction)|Verify\nResult|row no";
				      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck" },
				             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_cmb_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
				             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"chss_mgst_trsp_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eq_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"fm_loc_value",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"fm_yard_value",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"to_loc_value",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"to_yard_value",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
				             {Type:"Combo",     Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"trsp_crr_mod_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"vndr_abbr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ownr_co_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"usr_co_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lst_sts_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"inter_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:255 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"spcl_instr_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"verify_result",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sheet_row" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vndr_seq" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"mvmt_sts_nm" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"isimport" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"eq_knd_cd" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsp_so_ofc_cty_cd" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsp_so_seq" },
				             {Type:"CheckBox",  Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bun_check" },
				             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsp_so_cmb_seq2" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"wo_issue" } ];
				       
				      InitColumns(cols);
				      SetEditable(1);
				      SetVisible(false);
				      SetColProperty('trsp_crr_mod_cd', {ComboText:"|"+trsp_crr_mod_cdText, ComboCode:"|"+trsp_crr_mod_cdCode} );
				      SetColProperty('chss_mgst_trsp_tp_cd', {ComboText:"|"+chss_mgst_trsp_tp_cdText, ComboCode:"|"+chss_mgst_trsp_tp_cdCode} );
				      SetColHidden('bun_check',1);
				      SetColHidden('trsp_so_cmb_seq2',1);
		      }						 
			    break;
			case 4:      //sheet1 init
			      with(sheetObj){
			         var cnt=0;
			         var HeadTitle="sts|svc_ord|seq";
			         SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
			         var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			         var headers = [ { Text:HeadTitle, Align:"Center"} ];
			         InitHeaders(headers, info);
			         var cols = [ {Type:"Status",    Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"trsp_so_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"trsp_so_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 } ];
			         InitColumns(cols);
			         SetEditable(1);
			         SetVisible(false);
	          }
               break;
	}
}
/* 
* Sheet processing-related processes
*/
function doActionIBSheet(sheetObj,formObj,sAction, trspSoStsCD) {
	switch(sAction) {
	   case IBSEARCH:     
			if(!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}
			if(formObj.kind_chassis[0].checked ||formObj.kind_chassis[1].checked){
				formObj.f_cmd.value=SEARCH08;
			} else {
				formObj.f_cmd.value=SEARCH09;
			}
			if(search_fm_yard.GetSelectCode()!= '' && formObj.search_fm_loc.value != '')
			{
				formObj.TRSP_SO_FM_NODE.value=formObj.search_fm_loc.value+search_fm_yard.GetSelectCode();
			}else{
				formObj.TRSP_SO_FM_NODE.value='';
			}
			if(search_to_yard.GetSelectCode()!= '' && formObj.search_to_loc.value != '')
			{
				formObj.TRSP_SO_TO_NODE.value=formObj.search_to_loc.value+search_to_yard.GetSelectCode();
			}else{
				formObj.TRSP_SO_TO_NODE.value='';
			}
			sheetObj.DoSearch("ESD_TRS_0014GS.do", TrsFrmQryString(formObj) );
			break;
		case IBSAVE: {
				var checkList=sheetObj.FindCheckedRow('ibcheck');
				if(checkList == ''){
					ComShowCodeMessage('COM12176');
					return false;
				}
				var checkArray=checkList.split('|');
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				if(trspSoStsCD == 'C'){
					setGateOutDate(sheetObj, checkArray);
					sheetObj.RemoveEtcData();
					var queryStr=sheetObj.GetSaveString(false, false, "ibcheck");
					if(queryStr=='') return false;
					formObj.f_cmd.value=SEARCH03;
					var searchXml=sheetObj.GetSaveData("ESD_TRS_0014GS.do", queryStr+'&'+TrsFrmQryString(formObj));
					if (getVerifyColumn(sheetObj))
					{
						formObj.f_cmd.value=MODIFY;
						formObj.TRSP_SO_TP_CD.value='H';
						formObj.TRSP_SO_STS_CD.value='R'; // SO - C, WO - I, CORRECTION - R
						sheetObj.DoSave("ESD_TRS_0014GS.do", TrsFrmQryString(formObj), 'ibcheck',false);
					}
				}else {
					if(checkList == ''){
						ComShowCodeMessage('COM12176');
						return false;
					}
					var cty_cd='';
					var seq_no='';
					for(var i=0; i<checkArray.length; i++)
					{
						if(i!=0){
							cty_cd += ',';
							seq_no += ',';
						}
						cty_cd += sheetObj.GetCellValue(checkArray[i], 'trsp_so_ofc_cty_cd');
						seq_no += sheetObj.GetCellValue(checkArray[i], 'trsp_so_seq');
					}
					document.woForm.trsp_so_ofc_cty_cd.value=cty_cd;
					document.woForm.trsp_so_seq.value=seq_no;
					document.woForm.eq_mode.value=document.form.kind_chassis.value;
					document.woForm.submit();
					return;
				}
			break;	
		}
		case IBDOWNEXCEL:       
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObj), SheetDesign:1, Merge:1 });
			break;
		case IBINSERT:      
			sheetObj.DataInsert();
			break;
		case IBDELETE:
			var checkList=sheetObj.FindCheckedRow('ibcheck');
			var checkArray=checkList.split('|');
			if(checkList == '' || !confirm(ComGetMsg('COM12165', 'S/O')) )
			{
				ComShowCodeMessage('COM12176');
				return false;
			}		
			for(var i=0; i<checkArray.length; i++){
				if(sheetObj.GetCellValue(checkArray[i],'wo_issue')=='Y')
					{ComShowMessage('W/O needs to be canceled first.');
					return false;
				}
			}
			formObj.f_cmd.value=REMOVELIST;
			sheetObj.DoSave("ESD_TRS_0014GS.do", {Param: TrsFrmQryString(formObj), Col: 'ibcheck', Quest:"false",UrlEncode:"true", Sync:1} );
			break;	
	}
}

/**
 * Screen form validation process for processing the input values
 */
function validateForm(sheetObj,formObj,sAction) {
	switch(sAction) {
	   case IBSEARCH:     
			if(	formObj.form_eq_no.value == '') {
					if (formObj.fmdate == '')  {
						ComShowCodeMessage('COM12114', 'from date');
						formObj.fmdate.focus();
						return false;
					}else if (formObj.todate == '') {
						ComShowCodeMessage('COM12114', 'to date');
						formObj.todate.focus();
						return false;
					}
					var lvfrmDate=doSepRemove(doSepRemove(formObj.fmdate.value, " "), "-");
					var lvtoDate=doSepRemove(doSepRemove(formObj.todate.value, " "), "-");
					if( ComGetDaysBetween(lvfrmDate, lvtoDate) > 30 ) {
						ComShowCodeMessage("TRS90424");
						return false;
					} else if( ComGetDaysBetween(lvfrmDate, lvtoDate) < 0 ) {
						ComShowCodeMessage("TRS90118");
						return false;
					}
				}
			break;
		case IBSAVE:
				var checkList=sheetObj.FindCheckedRow('ibcheck');
				var checkArray=checkList.split('|');
				var fmNode='';
				var toNode='';
				for(var k=0; k<checkArray.length; k++)
				{
					var row=checkArray[k];
					fmNode=sheetObj.GetCellValue(row, 'fm_loc_value')+sheetObj.GetCellValue(row, 'fm_yard_value');
					toNode=sheetObj.GetCellValue(row, 'to_loc_value')+sheetObj.GetCellValue(row, 'to_yard_value');
					if(fmNode == toNode)
					{
						ComShowCodeMessage('COM12115', 'From Node and To Node');
						sheetObj.SelectCell(row, 'fm_loc_value');
						return false;
					}
				}
				var sheetObj3=sheetObjects[2];
				sheetObj3.RemoveAll();
				var queryStr=sheetObj.GetSaveString(false, false, "ibcheck");
				if(queryStr == '') return false;
				sheetObj3.DoSearch("ESD_TRS_0969.screen", queryStr,{Append:false} );
				var dupRow=sheetObj3.ColValueDup('eq_no|fm_loc_value|fm_yard_value');
				if(dupRow != -1)
				{
					ComShowCodeMessage('COM12115', 'EQ No AND From Node');
					sheetObj.SelectCell(row, 'eq_no');
					return false;
				}
				break;
	}
	return true;
}

/**
 * sheet click events that occur during
 **/
function sheet_OnClick(sheetObj, row, col, value)
{
	if(sheetObj.GetCellProperty(row, col, 0)==6)
	{	
		return;
	}
	var colName=sheetObj.ColSaveName(col);
	var formObj=document.form;
	var k_h_value=sheetObj.GetCellValue(row, 'chss_mgst_trsp_tp_cd');
	if(colName == 'fm_loc_value' && k_h_value == 'D'){
		document.form.TRSP_SO_EQ_KIND.value='A';
	}else if(colName == 'fm_loc_value' && (k_h_value == 'N' || k_h_value == 'F')){
//		document.form.TRSP_SO_EQ_KIND.value=k_h_value;
		document.form.TRSP_SO_EQ_KIND.value='A';
	}else if(colName == 'to_loc_value' && (k_h_value == 'N')) {
		document.form.TRSP_SO_EQ_KIND.value='Y';
	}else if(colName == 'to_loc_value' && (k_h_value == 'D')) {
		document.form.TRSP_SO_EQ_KIND.value='A';
	}else if(colName == 'to_loc_value' && k_h_value == 'F') {
		document.form.TRSP_SO_EQ_KIND.value='N';
	}
	switch(colName){
		case 'fm_yard_value':
			if( sheetObj.GetCellValue(row, 'fm_loc_value') != '' )
			{
				getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.GetCellValue(row, 'fm_loc_value'));
			}
			break;
		case 'to_yard_value':
			if( sheetObj.GetCellValue(row, 'to_loc_value') != '' )
			{
				getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.GetCellValue(row, 'to_loc_value'));
			}
			break;
		case 'eq_no':
			if(sheetObj.GetCellValue(row,'isimport') == '' ) {
				sheetObj.SetCellEditable(row,'eq_no',0);
			} else {
				sheetObj.SetCellEditable(row,'eq_no',1);
			}
			break;
	}
}
function sheet_OnKeyDown(sheetObj, row, col, keycode, Shift) 
{
	var colName=sheetObj.ColSaveName(col);
	if(colName == 'chss_mgst_trsp_tp_cd' && (keycode == 9 || keycode == 13) && sheetObj.SetCellValue(row,'isImport') == '' ) sheetObj.GetCellEditable(row,'eq_no',0);
	else if(colName == 'chss_mgst_trsp_tp_cd' && (keycode == 9 || keycode == 13) && sheetObj.SetCellValue(row,'isImport') != '' )sheetObj.GetCellEditable(row,'eq_no',1);
	if(colName == 'eq_no' && (keycode == 9 || keycode == 13) && sheetObj.SetCellValue(row,'eq_no') == '' ) sheetObj.GetCellEditable(row,'eq_tpsz_cd',1);
	else if(colName == 'eq_no' && (keycode == 9 || keycode == 13) && sheetObj.SetCellValue(row,'eq_no') != '')sheetObj.GetCellEditable(row,'eq_tpsz_cd',0);
}
/**
 * sheet cell value change events that occur
 **/
function sheet_OnChange(sheetObj, row, col, value){
	var formObject=document.form;
	var colName=sheetObj.ColSaveName(col);
	var k_h_value=sheetObj.GetCellValue(row, 'chss_mgst_trsp_tp_cd');
	if(colName == 'fm_loc_value' && k_h_value == 'D'){
		document.form.TRSP_SO_EQ_KIND.value='A';
	}else if(colName == 'fm_loc_value' && (k_h_value == 'N' || k_h_value == 'F')){
//		document.form.TRSP_SO_EQ_KIND.value=k_h_value;
		document.form.TRSP_SO_EQ_KIND.value='A';
	}else if(colName == 'to_loc_value' && (k_h_value == 'N')) {
		document.form.TRSP_SO_EQ_KIND.value='Y';
	}else if(colName == 'to_loc_value' && (k_h_value == 'D')) {
		document.form.TRSP_SO_EQ_KIND.value='A';
	}else if(colName == 'to_loc_value' && k_h_value == 'F') {
		document.form.TRSP_SO_EQ_KIND.value='N';
	}
	switch(colName){
		case 'delflag':
		case 'ibcheck':
			toggleCheckBundle(sheetObj, row, col);
			break;
		case 'fm_loc_value':
			if (sheetObj.GetCellValue(row, colName) != "") {
        		getYardSheetCombo(sheetObj, document.form, row, 'fm_yard_value', sheetObj.GetCellValue(row, colName));
                sheetObj.SetCellValue(row, 'ibcheck','1',0);
        	} else {
        		sheetObj.SetCellValue(row, 'fm_yard_value', '', 0); // Yard 초기화
        	}
        	break;
		case 'to_loc_value':
			if (sheetObj.GetCellValue(row, colName) != "") {
        		getYardSheetCombo(sheetObj, document.form, row, 'to_yard_value', sheetObj.GetCellValue(row, colName));
                sheetObj.SetCellValue(row, 'ibcheck','1',0);
        	} else {
        		sheetObj.SetCellValue(row, 'to_yard_value', '', 0); // Yard 초기화
        	}
        	break;
			break;
		case 'chss_mgst_trsp_tp_cd':
		case 'eq_no':
			var sheetObj2=sheetObjects[1];			
			if(value == '') {
                sheetObj.SetCellValue(row, 'vndr_abbr_nm','');
                sheetObj.SetCellValue(row, 'lstm_cd','');
                sheetObj.SetCellValue(row, 'ownr_co_cd','');
                sheetObj.SetCellValue(row, 'usr_co_cd','');
                sheetObj.SetCellValue(row, 'mvmt_sts_cd','');
                sheetObj.SetCellValue(row, 'lst_sts_yd_cd','');
                sheetObj.SetCellValue(row, 'mvmt_dt','');
				return;
			}
			sheetObj.InitCellProperty(row, 'fm_yard_value',{ Type:"Data"} );
			sheetObj.InitCellProperty(row, 'to_yard_value',{ Type:"Data"} );
			if(formObject.kind_chassis[0].checked){
                formObject.f_cmd.value=SEARCH01;
            }else{
                formObject.f_cmd.value=SEARCH02;
            }
			var queryString="eq_no="+sheetObj.GetCellValue(row, col)+"&"+TrsFrmQryString(formObject);
			sheetObj2.RemoveAll();
			
			sheetObj2.DoSearch("ESD_TRS_0014GS.do", queryString, {Sync:2, Append:true});
			if(sheetObj.GetCellValue(row, 'eq_tpsz_cd') != sheetObj2.GetCellValue(1, 'eq_tpsz_cd')) {
				ComShowCodeMessage('COM12114', 'EQ TYPE CODE');
				sheetObj.SetCellValue(row, 'eq_no','',0);
				sheetObj.SetCellValue(row, 'fm_loc_value','',0);
                sheetObj.SetCellValue(row, 'fm_yard_value','',0);
				return;
			} else {
				sheetObj.SetCellValue(row, 'vndr_seq',sheetObj2.GetCellValue(1, 'vndr_seq'));
				sheetObj.SetCellValue(row, 'vndr_abbr_nm',sheetObj2.GetCellValue(1, 'vndr_abbr_nm'));
				sheetObj.SetCellValue(row, 'lstm_cd',sheetObj2.GetCellValue(1, 'lstm_cd'));
				sheetObj.SetCellValue(row, 'ownr_co_cd',sheetObj2.GetCellValue(1, 'ownr_co_cd'));
				sheetObj.SetCellValue(row, 'usr_co_cd',sheetObj2.GetCellValue(1, 'usr_co_cd'));
				sheetObj.SetCellValue(row, 'mvmt_sts_cd',sheetObj2.GetCellValue(1, 'mvmt_sts_cd'));
				sheetObj.SetCellValue(row, 'lst_sts_yd_cd',sheetObj2.GetCellValue(1, 'lst_sts_yd_cd'));
				sheetObj.SetCellValue(row, 'mvmt_dt',sheetObj2.GetCellValue(1, 'mvmt_dt'));
			}
			break;
//		case 'eq_tpsz_cd':
//			sheetObj.RemoveEtcData();
//			value=value.toUpperCase();
//			if(formObject.kind_chassis[0].checked||document.form.kind_chassis[2].checked){
//				formObject.f_cmd.value=SEARCH12;
//			}else if(formObject.kind_chassis[1].checked||document.form.kind_chassis[3].checked){
//				formObject.f_cmd.value=SEARCH13;
//			}
//			formObject.EQ_TPSZ_CD.value=value;
//			//conversion of function[check again]CLT 			sheetObj.DoRowSearch( ROW,TrsFrmQryString(formObject)"&false" );
//			if(formObject.kind_chassis[0].checked){
//				if (sheetObj.GetEtcData("eq_tpsz_cd") == undefined || sheetObj.GetEtcData("eq_tpsz_cd") == ''){
//					ComShowCodeMessage('COM12114', 'Type size Code');
//					sheetObj.SetCellValue( row, col,'',0);
//					return;
//				}
//			}else if(formObject.kind_chassis[1].checked){
//				if (sheetObj.GetEtcData("eq_tpsz_cd") == undefined || sheetObj.GetEtcData("eq_tpsz_cd") == ''){
//					ComShowCodeMessage('COM12114', 'Type size Code');
//					sheetObj.SetCellValue( row, col,'',0);
//					return;
//				}
//			}
//			sheetObj.SetCellValue(row, 'eq_tpsz_cd', value);
//			if(!checkEqTypeSizeByBundle(sheetObj)){
//				sheetObj.SetCellValue(row, 'eq_tpsz_cd', '');
//			}
//			break;
		case 'org_gate_out_date':
			if(value != '' && sheetObj.GetCellValue(row, 'org_gate_out_time')==''){
				sheetObj.SetCellValue(row, 'org_gate_out_time','000000',0);
			}else if(value == ''){
				sheetObj.SetCellValue(row, 'org_gate_out_time','',0);
			}
			break;
		case 'dest_gate_in_date':
			if(value != '' && sheetObj.GetCellValue(row, 'dest_gate_in_time')==''){
				sheetObj.SetCellValue(row, 'dest_gate_in_time','000000',0);
			}else if(value == ''){
				sheetObj.SetCellValue(row, 'dest_gate_in_time','',0);
			}
			break;
	}
}
/**
 * Get a list of external combo box
 **/
function getComboList(obj)
{
	var yard_obj=null;
	var formObj=document.form;
	obj.value=obj.value.toUpperCase();
	if(obj.name == 'search_fm_loc'){
		yard_obj=search_fm_yard;
		if(formObj.trs_tp_cd.value == 'ALL' || formObj.trs_tp_cd.value == 'D'){
			formObj.TRSP_SO_EQ_KIND.value='A';
		}else{
			formObj.TRSP_SO_EQ_KIND.value=formObj.trs_tp_cd.value;
		}
	}else if(obj.name == 'search_to_loc'){
		yard_obj=search_to_yard;
		if(formObj.trs_tp_cd.value == 'ALL' || formObj.trs_tp_cd.value == 'D'){
			formObj.TRSP_SO_EQ_KIND.value='A';
		}else if(formObj.trs_tp_cd.value == 'N'){
			formObj.TRSP_SO_EQ_KIND.value='Y'
		}else if(formObj.trs_tp_cd.value == 'F'){
			formObj.TRSP_SO_EQ_KIND.value='N'
		}
	}
	var locValue=obj.value;
	if(ComTrim(locValue) == ''){
		yard_obj.RemoveAll();
		return;
	}
	getYardCombo(yard_obj, sheetObjects[0], formObj, locValue);
}
/**
 * enter check
 **/
function enterCheck(obj)
{
	if(event.keyCode == 13)
	{
		switch(ComGetEvent("name")){
			case 'search_fm_loc':
			case 'search_to_loc':
				getComboList(obj);
				break;
		}
	}
}
/**
* Common Node popup
*/
function openHireYardPopup( btn_obj )
{
	var formObject=document.form;
	var cmdt_cd_val="";   
	var rep_cmdt_cd_val=""; 
	var cmdt_desc_val="";   
	var classId="getCOM_ENS_061_1";
	var xx1="";  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	var returnFunction='setFmNode';
	if(btn_obj == 'to_node') returnFunction='setToNode';
	var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 772, 430, returnFunction, '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * popSearchPiCommCodeGrid process handling
 */
function popSearchPiCommCodeGrid(classID,midCD,cdName,sheetName,sRow,colCode,colName){
	var myUrl=getPopupURL(POPUP_PI_COMM);
	var myOption=getPopupOption(POPUP_PI_COMM);
	var url;
if(myWin!=null)  ComClosePopup(); 
	url=myUrl+"?class_id="+classID + "&mid_cd="+midCD + "&cdName="+cdName+ "&sheetName="+sheetName+ "&sRow="+sRow+ "&colCode="+colCode+ "&colName="+colName;
	myWin=window.open(url, "piCommCodePop", myOption);
	myWin.focus();
}
/**
* fmNode through a pop-up settings
*/
function setFmNode(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	var node=colArray[3];
	var loc=node.substring(0,5);
	var yard=node.substring(5,7);
	with (formObject) {
		search_fm_loc.value=loc;
		getComboList(search_fm_loc);
	}
	search_fm_yard.SetSelectCode(yard, true);
}
/**
* fmNode through a pop-up settings
*/
function setToNode(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	var node=colArray[3];
	var loc=node.substring(0,5);
	var yard=node.substring(5,7);
	with (formObject) {
		search_to_loc.value=loc;
		getComboList(search_to_loc);
	}
	search_to_yard.SetSelectCode(yard, true);
}
/**
 * Tied bundles period between when you click the check box
 **/
function toggleCheckBundle(sheetObj, row, col)
{
	var value=sheetObj.GetCellValue(row, col);
	var bundle_seq=sheetObj.GetCellValue(row, 'trsp_so_cmb_seq');
	if(bundle_seq == '') return;
	for(var i=row-1; i>=1; i--)
	{
		if(bundle_seq == sheetObj.GetCellValue(i, 'trsp_so_cmb_seq'))
		{
			sheetObj.SetCellValue(i, col, value);
		}else{
			break;
		}
	}
	for(var i=row+1; i<=sheetObj.RowCount(); i++)
	{
		if(bundle_seq == sheetObj.GetCellValue(i, 'trsp_so_cmb_seq'))
		{
			sheetObj.SetCellValue(i, col, value);
		}else{
			break;
		}
	}
}
/**
 * When an error occurs, save the results to a common processing function
 */
function sheet_OnSaveEnd(sheetObj, errCode, errMsg) {
	if (errCode >= 0) {
		var formObj = document.form;
		if (formObj.f_cmd.value == REMOVELIST) {
			var checkList = sheetObj.FindCheckedRow('ibcheck');
			var checkArray = checkList.split('|');
			for ( var k = checkArray.length - 1; k >= 0; k--) {
				sheetObj.RowDelete(checkArray[k], false);
			}
			ComShowCodeMessage('COM12167', 'S/O');
		} else if (formObj.f_cmd.value == MODIFY) {
			ComShowCodeMessage('COM12116', 'S/O Correction');
		}
	}
}
/**
 * Unpacking bundle
 **/
function unBundle(sheetObj)
{
	var checkList=sheetObj.FindCheckedRow('ibcheck');
	var checkArray=checkList.split('|');
	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}
	for(var k=0; k<checkArray.length; k++)
	{
		var row=checkArray[k];
		var bundle_seq=sheetObj.GetCellValue(row, 'trsp_so_cmb_seq');
		if(bundle_seq != ''){ 
			sheetObj.SetCellValue(row, 'trsp_so_cmb_seq','',0);
			sheetObj.SetCellValue(row, 'trsp_so_cmb_tp_cd','',0);
			sheetObj.SetCellValue(row, 'trsp_so_cmb_tp_nm','',0);
			sheetObj.SetCellBackColor(row, 'trsp_so_cmb_seq',15723503);
		}
	}
}
/**
 * sheet in the item to the bundling
 **/
function itemBundling(sheetObj)
{
	var formObj=document.form;
	if(!checkEqTypeSize(sheetObj)) return;
	var checkList=sheetObj.FindCheckedRow('ibcheck');
	var checkArray=checkList.split('|');
	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}
	var unit=formObj.bundle_unit.value;
	var checkLength=checkArray.length;
	if(checkLength<unit)
	{
		ComShowCodeMessage('TRS90125');
		return;
	}
	unBundle(sheetObj);
	var share=Math.floor(Number(checkLength) / Number(unit));
	cnt=0;
	for(var i=0; i<share; i++)
	{
		var seq=getSeqNo();
		for(var j=0; j<unit; j++)
		{
			sheetObj.SetCellBackColor(checkArray[cnt], 'trsp_so_cmb_seq',15723503);
			sheetObj.SetCellValue(checkArray[cnt], 'trsp_so_cmb_tp_cd', formObj.bundle_kind.value);
			var listn=formObj.bundle_kind.selectedIndex;
			sheetObj.SetCellValue(checkArray[cnt], 'trsp_so_cmb_tp_nm', formObj.bundle_kind.options[listn].text);
			sheetObj.SetCellValue(checkArray[cnt++], 'trsp_so_cmb_seq', seq);
		}
	}
	for(var i=cnt; i<checkLength; i++){
		sheetObj.SetCellBackColor(checkArray[i], 'trsp_so_cmb_seq',"#EEFFE2");
	}
	cnt=1;
	for(var i=0; i< share*unit; i++)
	{
		if(cnt != checkArray[i]){
			sheetObj.DataMove(cnt++, checkArray[i]);
		}else{
			cnt++;
		}
	}
}
/**
 * check out the list that eq type size to see if there is a duplicate.
 **/
function checkEqTypeSize(sheetObj)
{
	var checkList=sheetObj.FindCheckedRow('ibcheck');
	var checkArray=checkList.split('|');
	var src_type_size='';
	for(var k=1; k<checkArray.length; k++)
	{
		var row=checkArray[k];
		if(sheetObj.GetCellValue(checkArray[0], 'eq_tpsz_cd') != sheetObj.GetCellValue(row, 'eq_tpsz_cd'))
		{
			ComShowCodeMessage('COM12114', 'EQ Type Size');
			return false;
		}
	}
	return true;
}
/**
 * Bundle seq no return
 **/
function getSeqNo()
{
	if(seqNo == 0)
	{
		var sheetObj=sheetObjects[0];
		var max=0;
		for(var k=1; k<sheetObj.RowCount()+1; k++)
		{
max=Math.max(Number(sheetObj.GetCellValue(k, 'trsp_so_cmb_seq')), Number(max))
		}
		seqNo=max+1;
	}
	return seqNo++;
}
/**
* MULTIAPPLY pop-up window
*/
function popMultiApply(sheetObj)
{
	var checkList=sheetObj.FindCheckedRow('ibcheck');
	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}
	var myOption="width=500,height=220,menubar=0,status=0,scrollbars=0,resizable=0";
	var url='ESD_TRS_0015.screen';
	myWin=window.open(url, "popMultiApply", myOption);
	
	//ComOpenPopup('ESD_TRS_0015.do', 500, 220, '', "1,0,1,1,1,1,1,1,1,1,1,1", true);
}
/**
* Press APPLY to apply MULTIAPPLY pop-up window
*/
function setPopupValue(fm_loc, fm_yd, to_loc, to_yd, trans_md, remark, popObj)
{
	var sheetObj=sheetObjects[0];
	var checkList=sheetObj.FindCheckedRow('ibcheck');
	var checkArray=checkList.split('|');
	for(var k=0; k<checkArray.length; k++)
	{
		var row=checkArray[k];
		if(ComTrim(fm_loc) != '') sheetObj.SetCellValue(row, 'fm_loc_value', fm_loc);
		if(ComTrim(fm_yd) != '') {
			sheetObj.InitCellProperty(row, 'fm_yard_value',{ Type:"Data"} );
			sheetObj.SetCellValue(row, 'fm_yard_value', fm_yd);
		}
		if(ComTrim(to_loc) != '') sheetObj.SetCellValue(row, 'to_loc_value', to_loc);
		if(ComTrim(to_yd) != '') {
			sheetObj.InitCellProperty(row, 'to_yard_value',{ Type:"Data"} );
			sheetObj.SetCellValue(row, 'to_yard_value', to_yd);
		}
		if(ComTrim(trans_md) != '') sheetObj.SetCellValue(row, 'trsp_crr_mod_cd', trans_md);
		if(ComTrim(remark) != '') sheetObj.SetCellValue(row, 'inter_rmk', remark);
	}
}
/**
* call file import window
*/
function popEqFileImport(sheetObj, formObj)
{
	var checkList = sheetObj.FindCheckedRow('ibcheck');
    var checkArray = checkList.split('|');
    if( checkArray == '' || checkArray == null) {
        ComShowCodeMessage('TRS90036');
        return;
    }
    for(var i=0; i<checkArray.length; i++){
        if(sheetObj.GetCellValue(checkArray[i], 'eq_no') != ''){
            ComShowCodeMessage('TRS90506');
            return;
        }
    }
	var myOption="dialogWidth:500px;dialogHeight:380px;help:no;status:no;resizable:no;scroll=no;";
	ComOpenWindow("ESD_TRS_0911.screen",  window,  myOption , true);
}
/**
* Called by the import popup as compared to the data sheet to fill.
*/
function importEqNo(popSheetObj, obj)
{
	var sheetObj=sheetObjects[0];
	var sheetObj2=sheetObjects[1];
	var checkList=popSheetObj.FindCheckedRow('ibcheck');
	var checkArray=checkList.split('|');
	var row=0;
	var value='';
	if(document.form.kind_chassis[0].checked||document.form.kind_chassis[2].checked)
	{
		document.form.f_cmd.value=SEARCH06;
	}else{
		document.form.f_cmd.value=SEARCH07;
	}
	var queryStr=popSheetObj.GetSaveString(false, false, "ibcheck");
	if(queryStr==''){
		ComClosePopup(); 
		return false;
	}
	sheetObj2.DoSearch("ESD_TRS_0014GS.do", queryStr+'&'+TrsFrmQryString(document.form),{Append:false} );
	var emptyEqArray=new Array();
	var cnt=0;
	for(var k=1; k<sheetObj.RowCount()+1; k++)
	{
		if(sheetObj.GetCellValue(k, 'eq_no')=='') emptyEqArray[cnt++]=k;
	}
	cnt=0; // insert the number of data counts.
	var tempEqNo='';
	for(var i=1; i<sheetObj2.RowCount()+1; i++)
	{
		for(var k=0; k<emptyEqArray.length;k++)
		{
			if(emptyEqArray[k] != -1)	// The inspection does not already populated row.
			{
				if(sheetObj.GetCellValue(emptyEqArray[k], 'eq_tpsz_cd') == sheetObj2.GetCellValue(i, 'eq_tpsz_cd'))
				{
					sheetObj.SetCellValue(emptyEqArray[k], 'eq_no',sheetObj2.GetCellValue(i, 'eq_no'),0);
					sheetObj.SetCellValue(emptyEqArray[k], 'vndr_seq',sheetObj2.GetCellValue(i, 'vndr_seq'),0);
					sheetObj.SetCellValue(emptyEqArray[k], 'vndr_abbr_nm',sheetObj2.GetCellValue(i, 'vndr_abbr_nm'),0);
					sheetObj.SetCellValue(emptyEqArray[k], 'lstm_cd',sheetObj2.GetCellValue(i, 'lstm_cd'),0);
					sheetObj.SetCellValue(emptyEqArray[k], 'ownr_co_cd',sheetObj2.GetCellValue(i, 'ownr_co_cd'),0);
					sheetObj.SetCellValue(emptyEqArray[k], 'usr_co_cd',sheetObj2.GetCellValue(i, 'usr_co_cd'),0);
					sheetObj.SetCellValue(emptyEqArray[k], 'mvmt_sts_cd',sheetObj2.GetCellValue(i, 'mvmt_sts_cd'),0);
					sheetObj.SetCellValue(emptyEqArray[k], 'lst_sts_yd_cd',sheetObj2.GetCellValue(i, 'lst_sts_yd_cd'),0);
					sheetObj.SetCellValue(emptyEqArray[k], 'mvmt_dt',sheetObj2.GetCellValue(i, 'mvmt_dt'),0);
					emptyEqArray[k]=-1;	// Populated row set to -1
					cnt++;	// row count of the number of populated
					break;
				}
			}
		}
		if(cnt == emptyEqArray.length) break; // to import more busy, you'll get an empty exit data
	}
	ComClosePopup(); 
}
/**
* Viewed reset condition
*/
function resetForm(formObj)
{
	formObj.kind_chassis[0].checked=true;
	formObj.trs_tp_cd.options[0].selected=true;
	formObj.fmdate.value=today;
	formObj.todate.value=beforeOneMonth;
	formObj.trs_md_cd.options[0].selected=true;
	formObj.search_fm_loc.value='';
	search_fm_yard.RemoveAll();
	formObj.search_to_loc.value='';
	search_to_yard.RemoveAll();
	formObj.form_eq_no.value='';
}
/**
 * S / O Creation create whether it within two weeks upon confirmation
 */
function getVerifyColumn(sheetObj)
{
	var checkList=sheetObj.FindCheckedRow('ibcheck');
	var checkArray=checkList.split('|');
	var returnFlag=true;
	if(checkList == '')
	{
		ComShowCodeMessage('COM12176');
		return false;
	}
	for(var k=0; k<checkArray.length; k++)
	{
		var row=checkArray[k];
		var eq_no=sheetObj.GetCellValue(row, 'eq_no');
		if(sheetObj.GetCellValue(row,'isimport')=='T' && sheetObj.GetEtcData(eq_no) != '' &&  sheetObj.GetEtcData(eq_no) != undefined)
		{
			sheetObj.SetCellValue(row, 'ibcheck',0,0);
			sheetObj.SetCellValue(row, 'verify_result',sheetObj.GetEtcData(eq_no),0);
			sheetObj.SetRowBackColor(row,"#EEFFE2");
			returnFlag=false;
		}
	}
	return returnFlag;
}
/**
 * Pop-up call rep_commodity
 */
function rep_Multiful_inquiry(btn_obj)
{
		var formObject=document.form;
		var cmdt_cd_val="";   
		var rep_cmdt_cd_val="";   
		var cmdt_desc_val="";   	
		var classId="getTRS_ENS_906";
		var xx1=btn_obj;  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";
		var param="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('ESD_TRS_0906.do' + param, 400, 330, classId, '0,1',true);
}
/**
 * Location: In the single-selection pop-up hangyeongwoo.
 */
function getTRS_ENS_906(rowArray, x1) {
	var formObject=document.form;
	if(x1 == 'btn_eq_no')
		formObject.form_eq_no.value=rowArray;
}
	function getCalendar(){
	 var cal2=new ComCalendarFromTo();
	 cal2.displayType="date";
	 cal2.select(document.form.fmdate, 'fmdate',document.form.todate, 'todate', 'yyyyMMdd');
	}
//Focus Cycle
function fun_Focus(obj){
	var val=removeBar(obj.value);
	obj.value=val;
	obj.select();
}
function removeBar(str) {
    var value="";
    for ( var i=0; i < str.length; i++ ) {
    var ch=str.charAt(i);
    if ( ch != '-' ) value=value + ch;
    }
    return value;
 }
function setGateOutDate(sheetObj, checkArray){
	var row=0;
	for(var i=0; i<checkArray.length; i++){
		row=checkArray[i];
		if(sheetObj.GetCellValue(row, 'org_gate_out_date') == '') {
			sheetObj.SetCellValue(row, 'org_gate_out_dt','',0);
		}else{
			if(sheetObj.GetCellValue(row, 'org_gate_out_time') == '') {
				sheetObj.SetCellValue(row, 'org_gate_out_time','000000',0);
			}
			sheetObj.SetCellValue(row, 'org_gate_out_dt')=sheetObj.GetCellValue(row, 'org_gate_out_date')+sheetObj.GetCellValue(row, 'org_gate_out_time');
		}
		if(sheetObj.GetCellValue(row, 'dest_gate_in_date') == '') {
			sheetObj.SetCellValue(row, 'dest_gate_in_dt','',0);
		}else{
			if(sheetObj.GetCellValue(row, 'dest_gate_in_time') == '') {
				sheetObj.SetCellValue(row, 'dest_gate_in_time','000000',0);
			}
			sheetObj.SetCellValue(row, 'dest_gate_in_dt')=sheetObj.GetCellValue(row, 'dest_gate_in_date')+sheetObj.GetCellValue(row, 'dest_gate_in_time');
		}
	}
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}

function getDateBetween(obj) {
	if(obj.value.length >= 8) {
	    document.form.todate.value=ComGetDateAdd(obj.value,"D", 30, "-");
	}else{
		document.form.todate.value="";
	}
}

function sheet_OnSearchEnd(sheetObj, errMsg) {
    var formObj = document.form;
    if( errMsg != null && errMsg != '' ) {
        ComShowMessage(errMsg);
    } else if (formObj.f_cmd.value == SEARCH08 || formObj.f_cmd.value == SEARCH09) {
    	for (var row = sheetObj.HeaderRows() + sheetObj.RowCount(); row > 0; row--) {
    		if (sheetObj.GetCellValue(row, 'eq_no') != '') {
    			sheetObj.SetCellEditable(row, 'eq_no', 0);
    		}
    	}
    }
}

/**
 * kind query processing conditions
 */
function setKindEnabled(){
        var sheetObj = sheetObjects[0];
        var formObj = document.form; 
        
        if (formObj.kind_chassis[0].checked) {
        	sheetObj.SetColProperty(0, 'eq_tpsz_cd', {ComboText:"|" + chss_eq_tpsz_cdCode, ComboCode:"|" + chss_eq_tpsz_cdCode} );
        } else if (formObj.kind_chassis[1].checked) {
        	sheetObj.SetColProperty(0, 'eq_tpsz_cd', {ComboText:"|" + gen_eq_tpsz_cdCode, ComboCode:"|" + gen_eq_tpsz_cdCode} );
        }
        
        if(sheetObj.RowCount() > 0 && checkedChassis == 'chassis' && formObj.kind_chassis[1].checked) {
            if(confirm('It will be delete all data in sheet \n\nDo you really want to select it?')) {
                sheetObj.RemoveAll();
                checkedChassis = 'genset';
            } else {
            	formObj.kind_chassis[0].checked = true;
                checkedChassis = 'chassis';
                return;
            }
        } else if(sheetObj.RowCount() > 0 &&checkedChassis == 'genset' && formObj.kind_chassis[0].checked) {
            if(confirm('It will be delete all data in sheet \n\nDo you really want to select it?')) {
                sheetObj.RemoveAll();
                checkedChassis = 'chassis';
            } else{
            	formObj.kind_chassis[1].checked = true;
                checkedChassis = 'genset';
                return;
            }
        } else if(sheetObj.RowCount() == 0) {
            if (formObj.kind_chassis[0].checked) checkedChassis='chassis';
            else if (formObj.kind_chassis[1].checked) checkedChassis='genset';
        }
 }