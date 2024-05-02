/*=========================================================
*
**Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0030.js
*@FileTitle  : SService Provider from the W / O after running a batch Confirm Invoice for payment or, Confirmed or Interfaced Invoice screen to cancel the
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/05
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
* @extends 
* @class ESD_TRS_0030 : business script for ESD_TRS_0030
*/
function ESD_TRS_0030() {
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
var Mincount=0;
document.onclick=processButtonClick;
function processButtonClick(){
	 var sheetObject=sheetObjects[0];
	 var sheetObject1=sheetObjects[1];
	 /*******************************************************/
	 var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case 'btng_invoicedelete':				
				var checkList=sheetObject.FindCheckedRow('ibcheck');
				var checkArray=checkList.split('|');
				if(!confirm( ComGetMsg('COM12171', 'Invoice') )) {
					return;
				}
				doActionIBSheet(sheetObject,formObject,'invoiceDelete');
				break;
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				sheetObject.SetColFontColor('inv_whld_tax_amt',"#FF0000");
				break;
			case "btn_reset":
				resetSearchCondition(formObject);
				break;
			case "btn_minimize": {
                if(document.all.MiniLayer.style.display != "none") {
                    document.all.MiniLayer.style.display="none";                
                } else {
                    document.all.MiniLayer.style.display="";                
                }
                ComResizeSheet(sheetObject);
				break;
			}
			case "btns_calendar":
				var cal2=new ComCalendarFromTo();
				cal2.displayType="date";
				cal2.select(document.form.fmdate, document.form.todate, 'yyyyMMdd');
				break;
			case 'btns_no_cd':
				rep_Multiful_inquiry(srcName);
				break;
			case 'btns_ofc_cd':
				rep_Multiful_inquiry('Office Code');
				break;
			case 'btng_provider':
				rep_OnPopupClick();
				break;
			case "btng_downexcel1": {
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
			}
			case "btng_downexcel2": {
				if(checkRefund()){
					ComShowCodeMessage('COM12113', 'not Refund Invoice');
					return;
				}
				doActionIBSheet(sheetObject1,formObject,'IBDOWNEXCEL2');
				break;
			}
			case "btng_MasterInvoiceCreation":
				var sheetObj=sheetObjects[0];
				var checkList=sheetObj.FindCheckedRow('ibcheck');
				var checkArray=checkList.split('|');
				if(checkInvVndrSeq()){
					ComShowCodeMessage('TRS90365');
					return;
				}
				if(checkRefund()){
					ComShowCodeMessage('COM12113', 'not Refund Invoice');
					return;
				}
				if(checkList != ""){
					print_excel(sheetObject);
				}else{
					ComShowCodeMessage('COM12176');
					return;
				}
				break;
			case "btng_holdsave": {
				var checkRows=sheetObject.CheckedRows('ibcheck');
				if (checkRows == 0) {
					ComShowCodeMessage('TRS90036');
					return false;
				}
				
				var trspInvAudStsCd = "";
				var invHldFlg = "";
				var checkArray=sheetObject.FindCheckedRow('ibcheck').split('|');
				for(var i=0; i< checkArray.length; i++ ){
					trspInvAudStsCd = sheetObject.GetCellValue(checkArray[i], 'trsp_inv_aud_sts_cd');
					invHldFlg = sheetObject.GetCellValue(checkArray[i], 'inv_hld_flg');
					if(!(trspInvAudStsCd == 'RC' || trspInvAudStsCd == 'SV' || trspInvAudStsCd == 'CF') && invHldFlg == 1){			
						ComShowCodeMessage('TRS90473');
						return false;
					}
				}
				if(checkReject()) {
					ComShowCodeMessage('COM12113', 'not Rejected Invoice');
					return false;
				}
				if(checkRefund()){
					ComShowCodeMessage('COM12113', 'not Refund Invoice');
					return false;
				}
				doActionIBSheet(sheetObject,formObject,'HOLD_SAVE');
				break;
			}
			case "btng_invaudit": {
				var checkRows=sheetObject.CheckedRows('ibcheck');
				if (checkRows == 0) {
					ComShowCodeMessage('TRS90036');
					return false;
				}
				if(checkReject()){
					ComShowCodeMessage('COM12113', 'not Rejected Invoice');
					return false;
				}
				if(checkRefund()){
					ComShowCodeMessage('COM12113', 'not Refund Invoice');
					return false;
				}
				detailInquiry(sheetObject,formObject, 'modify');
				break;
			}
			case "btng_invconfrimcancel": {
				var checkRows=sheetObject.CheckedRows('ibcheck');
				if (checkRows == 0) {
					ComShowCodeMessage('TRS90036');
					return false;
				}
				
                var arrRow=sheetObject.FindCheckedRow("ibcheck").split("|");
                for (idx=0; idx<arrRow.length; idx++){
                    if(sheetObject.GetCellValue(arrRow[idx] , "trsp_inv_aud_sts_cd") != "CF"){
                         ComShowCodeMessage("TRS90144");
                        return false;
                    }
                }				
				
				if(checkReject()){
					ComShowCodeMessage('COM12113', 'not Rejected Invoice');
					return;
				}
				if(checkRefund()){
					ComShowCodeMessage('COM12113', 'not Refund Invoice');
					return;
				}
				doActionIBSheet(sheetObject,formObject,'CONFIRM_CANCEL');
				break;
			}
			case "btng_detailinquiry":
				// allow to link Refund/DC popup
//				if(checkRefund()){
//					ComShowCodeMessage('COM12113', 'not Refund Invoice');
//					return;
//				}
				detailInquiry(sheetObject,formObject, 'search');
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
	for(i=0;i<sheetObjects.length;i++){
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
			      var HeadTitle="|Status|Hold|Invoice Type|Invoice No|Reference No|S/P|S/P|W/O Amount|W/O Amount|Exchange\nRate|Exch Rate Adj."
			      +"|Calculation\nLogic|Invoice Amount|Invoice Amount|Invoice Amount|Invoice Amount"
			      +"|Invoice Amount|Invoice Amount|Invoice Amount|Date|Date|Date|Date|Date|Date|CSR No"
			      +"|Payment\nMethod|Check/\nT.T No|Invoice Remark|Invoice Creation|Invoice Creation" ;
			      var HeadTitle1="|Status|Hold|Invoice Type|Invoice No|Reference No|Code|Name|Currency|Total|Exchange\nRate|Exch Rate Adj."
			      +"|Calculation\nLogic|Currency|Basic|Surcharge|Total|VAT|WHT|G.Total|Issue|Received"
			      +"|Paid|G/L|Status\nUpdated|Invoice Confirm|CSR No|Payment\nMethod|Check/\nT.T No"
			      +"|Invoice Remark|Office|User ID" ;
			      SetHeaderRowHeight(12);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ 
			             {Type:"DummyCheck",Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibcheck",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:140,  Align:"left",    ColMerge:1,   SaveName:"trsp_inv_aud_sts_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"CheckBox",  Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_hld_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"inv_tp_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"inv_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"ref_inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"inv_vndr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"inv_vndr_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"wo_tot_amt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"inv_xch_rt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_adj_bzc_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"trsp_inv_calc_lgc_tp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"so_inv_bzc_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"scg_amt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_bzc_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_vat_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_whld_tax_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"inv_ttl_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"inv_iss_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"inv_rcv_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pay_dt",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"gl_dt",                    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_cfm_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:160,  Align:"Center",  ColMerge:1,   SaveName:"csr_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_pay_mzd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_chk_trns_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"inv_remark",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Status",    Hidden:0, Width:0,     Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:1, Width:0,     Align:"Center",  ColMerge:1,   SaveName:"if_sys_knd_cd" },
			             {Type:"Text",      Hidden:1, Width:0,     Align:"Center",  ColMerge:1,   SaveName:"trsp_inv_aud_sts_cd" },
			             {Type:"Text",      Hidden:1, Width:0,     Align:"Center",  ColMerge:1,   SaveName:"trsp_inv_calc_lgc_tp_cd" },
			             {Type:"Text",      Hidden:1, Width:0,     Align:"Center",  ColMerge:1,   SaveName:"cnt_spp" },
			             {Type:"Text",      Hidden:1, Width:0,     Align:"Center",  ColMerge:1,   SaveName:"rfnd_flg" },
			             {Type:"Text",      Hidden:1, Width:0,     Align:"Center",  ColMerge:1,   SaveName:"abs_scg_amt" },
			             {Type:"CheckBox",  Hidden:0, Width:0,     Align:"Center",  ColMerge:1,   SaveName:"sppCheck" },
			             {Type:"Text",      Hidden:1, Width:0,     Align:"Center",  ColMerge:1,   SaveName:"rgst_no" } ];
			      InitColumns(cols);
			      SetEditable(1);
                  SetColProperty('inv_tp_cd', {ComboText:"Common|Refund/DC|Pool CHZ Repo.", ComboCode:"C|R|P"} );
			      SetRangeBackColor(1, 12, 1, 24,"#555555");
			      SetColHidden('ibflag',1);
			      SetColHidden('sppCheck',1);
			      ComResizeSheet(sheetObj);
	      }
			break;
			 case 2: 
			      with(sheetObj){
				         var HeadTitle="Received\nType|Status|Hold|Invoice No|Reference No|Payment S/P|Payment S/P"
				         +"|W/O|W/O S/P|W/O S/P|S/O No|Equipment No|TP / SZ"
				         +"|W/O Amount|W/O Amount|W/O Amount|W/O Amount|W/O Amount|W/O Amount|Exchange\nRate|Exch Rate Adj."
				         +"|Calculation\nLogic|Invoice Amount|Invoice Amount|Invoice Amount|Invoice Amount"
				         +"|Invoice Amount|Invoice Amount|Invoice Amount"
				         +"|Date|Date|Date|Date|Date|CSR No"
				         +"|Payment\nMethod|Check/\nT.T No"
				         +"|Invoice Remark|Invoice Creation|Invoice Creation" ;
				         var HeadTitle1="Received\nType|Status|Hold|Invoice No|Reference No|Code|Name"
				         +"|W/O|Code|Name|S/O No|Equipment No|TP / SZ"
				         +"|Currency|Basic|Negotiated|Fuel|Additional|Total|Exchange\nRate|Exch Rate Adj."
				         +"|Calculation\nLogic|Currency|Basic|Surcharge|Total"
				         +"|VAT|WHT|G.Total"
				         +"|Issue|Received|Paid|G/L|Status\nUpdated|CSR No"
				         +"|Payment\nMethod|Check/\nT.T No"
				         +"|Invoice Remark|Office|User ID" ;
				         SetHeaderRowHeight(12);
				         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				         var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				         var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
				         InitHeaders(headers, info);
				         var cols = [ 
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"if_sys_knd_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trsp_inv_aud_sts_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"CheckBox",  Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_hld_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"ref_inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_vndr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_vndr_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trsp_wo_ofc_cty_cd_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vndr_nm",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"bzc_amt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"nego_amt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"fuel_scg_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"etc_add_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"wo_tot_amt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_xch_rt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_adj_bzc_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_inv_calc_lgc_tp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_bzc_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_etc_add_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"inv_tot_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"inv_vat_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"inv_whld_tax_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"inv_gttl_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"inv_iss_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"inv_rcv_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pay_dt",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"gl_dt",                    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csr_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_pay_mzd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_chk_trns_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_rmk",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				         InitColumns(cols);
				         SetEditable(1);
				         SetRangeBackColor(1, 11, 1, 23,"#555555");
				         SetHeaderRowHeight(20 );
				         SetVisible(false);
		         }
               break;
	}
}
/*
* handling of Sheet 
*/
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:
			replaceDateField(formObj);
			if(ComIsNull(formObj.no_cd)){
	   			if(ComIsNull(formObj.fmdate) || ComIsNull(formObj.todate) || ComIsNull(formObj.inv_cre_ofc)){
	   				ComShowCodeMessage("TRS90124");
					return false;
	   			}	   			
	   		}
	   		var days_between = ComGetDaysBetween(formObj.fmdate , formObj.todate) ;  
	   		if( days_between < 0) {
				ComShowCodeMessage("TRS90118");
				formObj.fmdate.focus();
				return false;
			} 
	   		var afterToDate  = ComGetDateAdd(formObj.fmdate , "M", 2, "");
	   		days_between=ComGetDaysBetween(afterToDate, formObj.todate);  
			if ( days_between >= 0 ) {
				ComShowCodeMessage("TRS90474");
				return false;
			}
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("ESD_TRS_0030GS.do", TrsFrmQryString(formObj) );
			break;
		case 'invoiceDelete':
			if(!validateForm(sheetObj,formObj,'invoiceDelete')) return;
			formObj.f_cmd.value=REMOVE;
			sheetObj.DoSave("ESD_TRS_0030GS.do", TrsFrmQryString(formObj), 'ibcheck',false);
			break;
		case 'CONFIRM_CANCEL':
			if(!validateForm(sheetObj,formObj, sAction)) return;
			formObj.f_cmd.value=MULTI02;
			sheetObj.DoSave("ESD_TRS_0030GS.do", TrsFrmQryString(formObj), 'ibcheck',false);
			break;
		case 'HOLD_SAVE':
			formObj.f_cmd.value=MULTI03;
			if(!CheckCreOfcCdForSPP(sheetObj)) return false;
			sheetObj.DoSave("ESD_TRS_0030GS.do", TrsFrmQryString(formObj), 'ibcheck', false);
			break;
		case IBDOWNEXCEL: 
			if(sheetObj.RowCount() < 1){//no data	
				ComShowCodeMessage("COM132501");
			}else{	
				 sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObj), SheetDesign:1, Merge:1 });
			}	
			
			break;
		case 'IBDOWNEXCEL2':  { 
			ComOpenWait(true);
			if(!validateForm(sheetObjects[0],formObj, sAction)){
				ComOpenWait(false);
				return;
			}
			formObj.f_cmd.value=SEARCH02;
			var query=sheetObjects[0].GetSaveString(false, true, 'ibcheck');
			sheetObj.DoSearch("ESD_TRS_0030GS.do", query+"&"+ TrsFrmQryString(formObj),{Append:false} );
			break;
		}
	}
}
/**
 * sheet1_OnSaveEnd
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {
	var formObj=document.form;

	if( errMsg != null && errMsg != -1 && errMsg != 0 ) {
		ComShowMessage(errMsg);
	} else {
		if(formObj.f_cmd.value == MULTI04){
			var checkList=sheetObj.FindCheckedRow('sppCheck');
			var checkArray=checkList.split('|');
			for(var i=0; i< checkArray.length-1; i++){
				sheetObj.SetCellValue(checkArray[i], 'cre_ofc_cd',formObj.FORM_USR_OFC_CD.value,0);
			}
		}else if(formObj.f_cmd.value == MULTI03){
			ComShowCodeMessage('TRS90057');
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
		}else if(formObj.f_cmd.value == MULTI02){
			if(errMsg == 0){
				ComShowCodeMessage('TRS90330');
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
			}
		}else if(formObj.f_cmd.value == MULTI01){
			ComShowCodeMessage('TRS90056');
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
		}else if(formObj.f_cmd.value == REMOVE){
			var checkList=sheetObj.FindCheckedRow('ibcheck');
			var checkArray=checkList.split('|');
			for(var k=checkArray.length-2; k>=0; k--)
			{
				sheetObj.RowDelete(checkArray[k], false);
			}
			ComShowCodeMessage('TRS90331');
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
		}
	}
}
/**
 * Screen form validation process for processing the input values
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction){
		case 'detailInquiry_modify':
			var checkList=sheetObj.FindCheckedRow('ibcheck');
			var checkArray=checkList.split('|');
			if(checkList == ''){
				ComShowCodeMessage('COM12176');
				return false;
			}else if(checkArray.length > 1){
				ComShowCodeMessage("COM12113", 'only one row');
				return false;
			}
			var stu_cd='';
			for(var k=0; k<checkArray.length; k++) {
				stu_cd=sheetObj.GetCellValue(checkArray[k], 'trsp_inv_aud_sts_cd');
				if(stu_cd != 'RC' && stu_cd != 'SV'){
					ComShowCodeMessage('TRS90059');
					return false;
				}
			}
			if(!CheckCreOfcCdForSPP(sheetObj)) return false;
			break;
		case 'detailInquiry_search':
			var checkList=sheetObj.FindCheckedRow('ibcheck');
			var checkArray=checkList.split('|');
			if(checkList == ''){
				ComShowCodeMessage('COM12176');
				return false;
			}else if(checkArray.length > 1){
				ComShowCodeMessage("COM12113", 'only one row');
				return false;
			}
			break;
		case 'invoiceDelete':
			if(sheetObj.CheckedRows('ibcheck') == 0) {
				ComShowCodeMessage('COM12176');
				return false;
			}
			if(!CheckCreOfcCdForSPP(sheetObj)) return false;
			
			var checkList=sheetObj.FindCheckedRow('ibcheck');
			var checkArray=checkList.split('|');
			for(var k=0; k < checkArray.length; k++) {
				if(sheetObj.GetCellValue(checkArray[k], 'cre_ofc_cd') != formObj.FORM_USR_OFC_CD.value){
					ComShowCodeMessage('TRS90323');
					return false;
				}
				var stu_cd=sheetObj.GetCellValue(checkArray[k], 'trsp_inv_aud_sts_cd');
				if(!(stu_cd == 'RC' || stu_cd == 'SV' || stu_cd == 'CF')) {
					ComShowCodeMessage('TRS90058');
					return false;
				}
			}
			break;
		case 'CONFIRM_CANCEL':
			if(sheetObj.CheckedRows('ibcheck') == 0) {
				ComShowCodeMessage('COM12176');
				return false;
			}
			if(!CheckCreOfcCdForSPP(sheetObj)) return false;
			var checkList=sheetObj.FindCheckedRow('ibcheck');
			var checkArray=checkList.split('|');			
			for(var k=0; k<checkArray.length-1; k++) {
				var stu_cd=sheetObj.GetCellValue(checkArray[k], 'trsp_inv_aud_sts_cd');
				if(sheetObj.GetCellValue(checkArray[k], 'cre_ofc_cd') != formObj.FORM_USR_OFC_CD.value){
					ComShowCodeMessage('TRS90323');
					return false;
				}
				if(stu_cd != 'CF'){
					ComShowCodeMessage('TRS90041');
					return false;
				}
			}
			break;
		case 'IBDOWNEXCEL2':     
			var checkList=sheetObj.FindCheckedRow('ibcheck');
			var checkArray=checkList.split('|');
			if(checkList == ''){
				ComShowCodeMessage('COM12176');
				return false;
			}
			break;
	}
	return true;
}
/**
 * sheet2_OnSearchEnd
 */
function sheet2_OnSearchEnd(sheetObj, errMsg) {
	var formObj=document.form;
	if( errMsg != '' ) {
		if(formObj.f_cmd.value == SEARCH02){
			ComOpenWait(false);
		}
		ComShowMessage(errMsg);
	} else {
		if(formObj.f_cmd.value == SEARCH02){
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObj), SheetDesign:1, Merge:1 });	
			ComOpenWait(false);
		}
	}
}
/**
 * Pop-up call rep_commodity
 */
function rep_Multiful_inquiry(val)
{
		var formObject=document.form;
		var cmdt_cd_val="";   
		var rep_cmdt_cd_val="";
		var cmdt_desc_val="";  
		var classId="getTRS_ENS_906";
		var xx1=val;  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";
		var title=val;
		if (val == "btns_no_cd" ) {
			if(formObject.no_tp[0].checked)  {
				title="Invoice No.";
			} else if(formObject.no_tp[1].checked) {
				title="CSR No.";
			} else {
				title="Reference No.";
			}
		}
		var param="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&returntitle="+title+ "&pgmNo=ESD_TRS_0030";
		ComOpenPopup('ESD_TRS_0906.do' + param, 400, 380, 'getTRS_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
}
function print_excel(sheetObj){
	var checkList=sheetObj.FindCheckedRow('ibcheck');
	var checkArray=checkList.split('|');
	var inv_no=new Array();
	var inv_vndr_seq=new Array();
    var queryStr='AND A.INV_VNDR_SEQ=';
	for(var k=0; k<checkArray.length; k++){
		if(k==0){
			queryStr += sheetObjects[0].GetCellValue(checkArray[k],'inv_vndr_seq')+" AND A.INV_NO IN (";
		}else{
			queryStr += ", ";
		}
		queryStr += "'"+sheetObjects[0].GetCellValue(checkArray[k],'inv_no')+"'";
		if(k==checkArray.length-1){
			queryStr += ") ";
		}
	}
	var form=document.esd_030rd_form;
	form.queryStr.value=queryStr;

	ComPostOpenWindow("ESD_TRS_0208.do", "ReportDesignerCommonPopup", "width=775,height=720,menubar=0,status=0,scrollbars=0,resizable=0");
	form.target='ReportDesignerCommonPopup';
	form.submit();
}
/**
 * Location: If a pop-up from a single selection.
 */
function getTRS_ENS_906(rowArray,returnval) {
	var formObject=document.form;
	if(returnval=="btns_no_cd") {
		var x1=formObject.no_cd.value;
		if(x1==""){
			formObject.no_cd.value=rowArray;
			formObject.no_cd.focus();
		}else{
			formObject.no_cd.value=rowArray;
			formObject.no_cd.focus();
		}
	} else if(returnval=="Office Code") {
		var x2=formObject.inv_cre_ofc.value;
		if(x2==""){
			formObject.inv_cre_ofc.value=rowArray;
			formObject.inv_cre_ofc.focus();
		}else{
			formObject.inv_cre_ofc.value=rowArray;
			formObject.inv_cre_ofc.focus();
		}
	}
}
/**
 * Pop-up call rep_commodity
 */
function rep_OnPopupClick()
{
		var formObject=document.form;
		var cmdt_cd_val="";   
		var rep_cmdt_cd_val=""; 
		var cmdt_desc_val="";   
		var classId="getCOM_ENS_rep";
		var xx1="";  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";
		var param="?conti_cd="+xx1
					+"&sconti_cd="+xx2
					+"&cnt_cd="+xx3
					+"&loc_state="+xx4
					+"&loc_eq_ofc="+xx5
					+"&loc_cd="+xx6
					+"&loc_desc="+xx7
					+"&loc_port_ind="+xx8
					+"&iPage="+xx9;
		ComOpenPopup('/opuscntr/COM_ENS_0C1.do'+param, 612, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * rep_commodity pop-up call: If a single selection from a pop-up.
 */
function getCOM_ENS_rep(rowArray) {
	var formObj=document.form;
	for(var i=0; i<rowArray.length; i++)
	{
		var colArray=rowArray[0];
		var colArray2=colArray[2];
		var colArray3=colArray[4];
		formObj.combo_svc_provider.value=colArray2;
		formObj.svc_provider.value=colArray3;
	}
}

/**
 * Invoice Audit or Collection can be viewed from.
 */
function detailInquiry(sheetObj, formObj, mode){
	if(!validateForm(sheetObj,formObj,'detailInquiry_'+mode)) return false;
	if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'cre_ofc_cd') != formObj.FORM_USR_OFC_CD.value){
		ComShowCodeMessage('TRS90323');
		return false;
	}
	var checkList=sheetObj.FindCheckedRow('ibcheck');
	var checkArray=checkList.split('|');
	ComOpenWindowCenter('', 'DetailPopup', 1280, 768, 0, 1);
	var invForm=document.inv_form;
	var inv_tp_cd = sheetObj.GetCellValue(checkArray[0], 'inv_tp_cd');
	if(inv_tp_cd == 'C') { 						// Common
		invForm.action = 'ESD_TRS_0033_POP.do';
		invForm.pgmNo.value = 'ESD_TRS_0033';
	}else if(inv_tp_cd == 'R') { 				// Refund/DC
		invForm.action = 'ESD_TRS_0040_POP.do';
		invForm.pgmNo.value = 'ESD_TRS_0040';
	}else { 									// Pool CHZ Repo.
		invForm.action = 'ESD_TRS_0041_POP.do';
		invForm.pgmNo.value = 'ESD_TRS_0041';
	}
	invForm.inv_no.value=sheetObj.GetCellValue(checkArray[0], 'inv_no');
	invForm.inv_vndr_seq.value=sheetObj.GetCellValue(checkArray[0], 'inv_vndr_seq');
	invForm.inv_vndr_nm.value=sheetObj.GetCellValue(checkArray[0], 'inv_vndr_nm');
	invForm.if_sys_knd_cd_param.value=sheetObj.GetCellValue(checkArray[0], 'if_sys_knd_cd');
	invForm.mode.value=mode;
	invForm.target = 'DetailPopup';
	invForm.submit();
}

// 
function getTRS_0033(rowArray, returnval)
{

}

/**
 * Initialize the query conditions.
 */
function resetSearchCondition(formObj){
	formObj.reset();
}
/**
 * enter check
 **/
function enterCheck(obj)
{
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	if(event.keyCode == 13)
	{
		switch(ComGetEvent("name")){
			case 'combo_svc_provider':
				getTextVendorSeq(sheetObj, formObj, obj.value);
				break;
			case 'inv_cre_ofc':
			case 'ivc_cre_usr_id':
				value_upper(obj);
			case 'no_cd':
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
		}
	}
}
/**
 * Include Office for processing Logic
 */
var request=null;
function createHttpRequest() {
	try{
		request=new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request=new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request=new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request=null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}
/**
 * When the Click Include Check Bok
 */
function fun_chkOffice() {
	var doc_office=document.form.chk_office;
	var prm_office=doSepRemove(document.form.inv_cre_ofc.value.toUpperCase(), " "); //input text
	if( prm_office == "" ) {
		doc_office.checked=false;
		document.form.inv_cre_ofc.value="";
		ComShowMessage("Please input the 'Invoice Creation Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {
		var url="ESD_TRS_0002GS.do?f_cmd="+SEARCH11+"&ctrl_so_office="+prm_office;
		document.form.old_ofc_cd.value=prm_office;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange=subCntorlOffice;
		request.send(null);
	} else {
		document.form.inv_cre_ofc.value=document.form.old_ofc_cd.value;
		document.form.inv_cre_ofc.disabled=false;
	}
}
/**
 *Brings the value of Office.
 */
function subCntorlOffice() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml=request.responseXML;
			var rowXml=docXml.getElementsByTagName("row-count")[0];
			var subXml=null;
			var text_ofc="";
			for( var n=0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml=docXml.getElementsByTagName("sub-office")[n];
				text_ofc=text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}
			document.form.inv_cre_ofc.value=text_ofc.substring(0, text_ofc.length-1);
		}
	}
}
/**
 * Only if CRE_OFC_CD = OFC_CD AUDIT, CONFIRM, DETAIL INQUIRY possible.
 * WIS & RCV state about the whole thing with the exception of the AUDIT, CONFIRM, and you have to do INV_OFC
 * , CRE_OFC_CD the work being done by the user after the change of the above OFC_CD apply RULE
 */
function CheckCreOfcCdForSPP(sheetObj){
	var formObj=document.form;
	var checkList=sheetObj.FindCheckedRow('ibcheck');
	var checkArray=checkList.split('|');
	var isUpdate=false;
	if(checkList == ''){
		return false;
	}
	var value=null;
	var rcv_tp_cd=null;
	var row=0;
	sheetObj.CheckAll('sppCheck',0,1);
	for(var i=0; i<checkArray.length; i++){
		row=checkArray[i];
		value=isNaN(Number(sheetObj.GetCellValue(row, 'cnt_spp')))?0:Number(sheetObj.GetCellValue(row, 'cnt_spp'));
		rcv_tp_cd=sheetObj.GetCellValue(row, 'if_sys_knd_cd');
		if( rcv_tp_cd == 'W' && value == 0 ){
			ComShowCodeMessage('TRS90323');
			return false;
		}
		if(rcv_tp_cd == 'W' && value > 0 
				&& sheetObj.GetCellValue(row, 'cre_ofc_cd') != formObj.FORM_USR_OFC_CD.value) {
			sheetObj.SetCellValue(row, 'sppCheck',1,0);
			isUpdate=true;
		}
	}
	if(isUpdate){
		formObj.f_cmd.value=MULTI04;
		sheetObj.DoSave("ESD_TRS_0030GS.do", TrsFrmQryString(formObj), 'sppCheck',false);
	}
	return true;
}
function checkRefund(){
	var sheetObj=sheetObjects[0];
	var checkList=sheetObj.FindCheckedRow('ibcheck');
	var checkArray=checkList.split('|');
	var value=null;
	var returnFlag=false;
	for(var i=0; i<checkArray.length; i++){
		value=sheetObj.GetCellValue(checkArray[i], 'rfnd_flg');
		if(value == 'Y'){
			returnFlag=true;
			break;
		}
	}
	return returnFlag;
}
function checkInvVndrSeq(){
	var sheetObj=sheetObjects[0];
	var checkList=sheetObj.FindCheckedRow('ibcheck');
	var checkArray=checkList.split('|');
	var value=null;
	var preValue=null;
	var returnFlag=false;
	for(var i=0; i<checkArray.length; i++){
		if(i>0){
			preValue=sheetObj.GetCellValue(checkArray[i-1], 'inv_vndr_seq');
			value=sheetObj.GetCellValue(checkArray[i], 'inv_vndr_seq');
		}
		if(preValue != value){
			returnFlag=true;
			break;
		}
	}
	return returnFlag;
}

function checkReject(){
	var sheetObj=sheetObjects[0];
	var checkList=sheetObj.FindCheckedRow('ibcheck');
	var checkArray=checkList.split('|');
	var value=null;
	var returnFlag=false;
	for(var i=0; i<checkArray.length; i++){
		value=sheetObj.GetCellValue(checkArray[i], 'trsp_inv_aud_sts_cd');
		if(value == 'RJ'){
			returnFlag=true;
			break;
		}
	}
	return returnFlag;
}

function resizeSheet(sheetObj){
    ComResizeSheet(sheetObj);
}

function funcRadioOnChange(obj) {
	document.getElementById("no_cd").value = '';
	if(obj.value == 'csr') {
		document.getElementById("no_cd").setAttribute("dataformat", "engup");
	} else {
		document.getElementById("no_cd").setAttribute("dataformat", "engupetc");
	}
}

/**
 * Sheet1 Onchange Event
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 * @returns {Boolean}
 */
function sheet1_OnChange(sheetObj, row, col, value) {
	if (sheetObj.ColSaveName(col) == 'inv_hld_flg') {
		var trspInvAudStsCd = sheetObj.GetCellValue(row , "trsp_inv_aud_sts_cd");
		if (!(trspInvAudStsCd == 'RC' || trspInvAudStsCd == 'SV' || trspInvAudStsCd == 'CF')){
			sheetObj.SetCellValue(row , "inv_hld_flg",0, 0);
			ComShowCodeMessage("TRS90144");
			return false;
		}
	}
}

/**
 * Inquiry 전 Date의 '-'를 제거하는 function
 * @param formObj
 */
function replaceDateField(formObj) {
	formObj.fmdate.value = formObj.fmdate.value.split('-').join('');
    formObj.todate.value = formObj.todate.value.split('-').join('');
}