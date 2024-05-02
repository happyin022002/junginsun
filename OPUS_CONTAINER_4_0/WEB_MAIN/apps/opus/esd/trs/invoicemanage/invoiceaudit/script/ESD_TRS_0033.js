/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0033.jsp
*@FileTitle  : Invoice Audit & Confirm
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/ 
/*------------------ Defining general java script function   ------------------*/
// General global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var beforetab2=1;
var prefix='surcharge_';
var selectedIdx=0;
var apply_flag=false;
var confirm_flag=false;
var sheetObjects=new Array();
var sheetCnt=0;
var ofc_cd_arr=new Array();
var Mincount=0 ;


// 2015.01.28    Hyungwook Choi
var _saveFlag = true;
document.onclick=processButtonClick;
function processButtonClick(){
     /***** Adding additional sheet variables to use more than one sheet per a tab *****/
     var sheetObject=sheetObjects[0];
     var sheetObject_confirm=sheetObjects[1];
     /*******************************************************/
     var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case 'btng_save':
            case 'btng_save2':
                if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
                doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;
            case 'btng_confirm':
                if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
                doActionIBSheet(sheetObject,formObject,'CONFIRM');
                break;
            case 'btng_reset': {
            	 if(document.form.mode_param.value == 'search') return;
                 resetHeader(sheetObject, sheetObject_confirm, formObject);
                 break;            	
            }
            case 'btng_reset2': {
            	resetCondition(sheetObject, sheetObject_confirm, formObject);
                break;
            }
            case 'btng_apply':
                if(document.form.mode_param.value == 'search' || confirm_flag) return;
                checkInvoice();
                break;
            case 'btns_recieve':
                if(document.form.mode_param.value == 'search' || confirm_flag) return;
                var cal=new ComCalendar();
                cal.select(formObject.recieve_dt, 'yyyyMMdd');
                break;
            case 'btns_issue':
                if(document.form.mode_param.value == 'search' || confirm_flag) return;
                var cal=new ComCalendar();
                cal.select(formObject.issue_dt, 'yyyyMMdd');
                break;
            case "btng_retrieve":
                ComOpenWait(true);
    			setTimeout( 
    				function () {
    	                if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) {
    	                    ComOpenWait(false);
    	                	return;
    	                }
    	                doActionIBSheet(sheetObject,formObject,IBSEARCH);
    				}, 300);
                break;
            case 'btns_wo_no':
            case 'btns_booking_no':
            case 'btns_bl_no':
            case 'btns_eq_no':
            case 'btns_so_no':
                if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
                rep_Multiful_inquiry(srcName);
                break;
            case "btng_provider":
                if(document.form.mode_param.value == 'search' || confirm_flag) return;
                if(!apply_flag) rep_OnPopupClick();
                break;
            case "btn_minimize":
                Mincount=(Mincount+1)%2 ;
                Minimize(Mincount);
                break;
            case 'btng_sendtoconfirmtab':
                if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
                if( !checkEmptyEqNo(sheetObjects[0]) ) return;
                if( !checkDupEqNoANDWoNo()) return;
                sendToConfirmTab();
                break;
            case 'btng_sendbackto':
                if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
                sendToAuditTab();
                break;
            case "btng_reject":
                if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
                rejectInvoice(sheetObjects[2], formObject);
                break;
            case "btng_cntrselect":
                if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
                popContainerSelect(sheetObject,formObject);
                break;
            case "btng_cntrnoimport":
                if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
                popCntrFileImport(sheetObject, formObject);
                break;
            case "btng_currencychange":
                if(formObject.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
                if(formObject.btng_currencychange.disabled) return;
                popCurrencyChange(sheetObject,formObject);
                break;
            case 'btng_invoicefileimport':
                if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
                popInvoiceFileImport(sheetObject,formObject);
                break;
            case "btng_downexcel0":
                if(sheetObjects[0].RowCount() < 1){//no data
                    ComShowCodeMessage("COM132501");
                }else{
                    sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObjects[0]), SheetDesign:1, Merge:1 });
                }                
                
                break;
            case "btng_verify":
                verifyEqNo(sheetObject, formObject);
                break;
            case "btng_surchargeapply":
                popSurchargeInputInquiry(sheetObject, '', '', 'multiple', 'IV');
                break;
            case "btng_mtyselect":    
                if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
                popMtySelect(sheetObject,formObject);            
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
 * Register IBSheet Object with array
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* Setting sheets and initialization
* Implementing the onLoad event handler of body tag
* Adding the preceding function after loading page
 */
function loadPage() {
	var formObject = document.form;
	formObject.issue_dt.value = today;
	formObject.recieve_dt.value = today;
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
        tabObjects[k].SetSelectedIndex(0);
    }
    
    if(mode_tab == 'C'){
        tabObjects[0].SetSelectedIndex(1);
    }
    initControl();
    if(document.form.mode_param.value != ''){
        initMode();
    } else {
        initCurrency();
    }
    calAmt();
}
/**
 * Loading the event of HTML Control <br>
 * {@link #loadPage} Initializing IBSheet Object <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     The order number of sheetObjects array
 **/
function initControl() {
}
/**
    * Using English character and number when onkeypress event occurs <br>
 **/
function engnum_keypress() {
   ComKeyOnlyAlphabet('uppernum');
}
/**
 * Validating the data when onblur event occurred <br>
 **/
function obj_blur(){
   return ComChkObjValid(event.srcElement);
}
/**
 * Removing the separator when onfocus event occurred <br>
 **/
function obj_focus(){
   ComClearSeparator(event.srcElement);
}
/**
 * Processing to be input only number when onkeypress event occurred <br>
 **/
function obj_keypress(){
   ComKeyOnlyNumber(event.srcElement);
}
function initMode() {
    var sheetObj=sheetObjects[2];
    var formObj=document.form;
    formObj.f_cmd.value=SEARCH03;
    sheetObj.DoSearch("ESD_TRS_0033GS.do", TrsFrmQryString(formObj),{Sync:2} );
    if(sheetObj.RowCount() == 0){
        ComShowCodeMessage('TRS90132');
        return false;
    } else {
        bindInvoiceHeader(sheetObj, formObj);
    }
    formObj.f_cmd.value=SEARCH06;
    formObj.trsp_inv_act_sts_cd_param.value='O';
    sheetObjects[0].DoSearch("ESD_TRS_0033GS.do", TrsFrmQryString(formObj),{Sync:2,Append:true} );
    formObj.trsp_inv_act_sts_cd_param.value='C';
    sheetObjects[1].DoSearch("ESD_TRS_0033GS.do", TrsFrmQryString(formObj),{Sync:2,Append:true} );
    setCurrChange();
    if(document.form.mode_param.value == 'search'){
        setDisabled('SEARCH_MODE');
    } else if(document.form.mode_param.value == 'modify'){
        setDisabled('APPLY');
        getOfcCd();
    }
}
/**
 * OFC CD Default Currency
 */
function initCurrency(){
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    formObj.f_cmd.value=SEARCH12;
    sheetObj.DoSearch("ESD_TRS_0033GS.do", TrsFrmQryString(formObj), {Sync:2} );
}
/**
 * Setting Invoice Header information to form object.
 */
function bindInvoiceHeader(sheetObj, formObj){
    formObj.invoice_no.value=sheetObj.GetCellValue(1, 'inv_no');
    formObj.recieve_dt.value=sheetObj.GetCellValue(1, 'inv_rcv_dt');
    formObj.issue_dt.value=sheetObj.GetCellValue(1, 'inv_iss_dt');
    formObj.combo_svc_provider.value=sheetObj.GetCellValue(1, 'wo_vndr_seq');
    formObj.svc_provider.value=sheetObj.GetCellValue(1, 'wo_vndr_nm');
    formObj.paymt_sp_cd.value=sheetObj.GetCellValue(1, 'inv_vndr_seq');
    formObj.paymt_sp_nm.value=sheetObj.GetCellValue(1, 'inv_vndr_nm');
    var comboObj=paymt_sp_combo;
    comboObj.InsertItem(-1, sheetObj.GetCellValue(1, 'inv_vndr_seq'), sheetObj.GetCellValue(1, 'inv_vndr_nm'));
    comboObj.SetSelectIndex(comboObj.GetItemCount()-1,false);
    formObj.apply_currency.value=sheetObj.GetCellValue(1, 'inv_curr_cd');
    formObj.inv_amt.value=sheetObj.GetCellValue(1, 'inv_bzc_amt');
    formObj.vat_amt.value=sheetObj.GetCellValue(1, 'inv_vat_amt');
    formObj.tot_amt.value=sheetObj.GetCellValue(1, 'inv_ttl_amt');
    formObj.wht_amt.value=sheetObj.GetCellValue(1, 'inv_whld_tax_amt');
}
function getVendorSeq(sheetObj, formObj, vndr_seq){
    formObj.f_cmd.value=SEARCH11;
    var temp = get_only_num(vndr_seq);
    if(temp != vndr_seq) {
    	formObj.combo_svc_provider.value = "";
    	return;
    }
    formObj.TRSP_SO_VNDR_NO.value = temp;
    sheetObj.RemoveEtcData();
    var sXml = sheetObj.GetSearchData("ESD_TRS_0014GS.do", TrsFrmQryString(formObj) );
     var vendorNoList=ComGetEtcData(sXml, "vndr_no");
     var vendorNmList=ComGetEtcData(sXml, "vndr_nm_eng");
     
    var comboObj=paymt_sp_combo;
    if (vendorNoList == undefined || vendorNoList == ''){
        formObj.combo_svc_provider.value='';
        formObj.svc_provider.value='';
        formObj.paymt_sp_cd.value='';
        formObj.paymt_sp_nm.value='';
        comboObj.RemoveAll();
        return false;
    }
    formObj.combo_svc_provider.value=lpad(vendorNoList, 6, '0') ;
    formObj.svc_provider.value=vendorNmList;
    searchPaymentSP(sheetObjects[1], formObj, vendorNoList);
    return true;
}
/**
 * Define the initial values and headers of sheets
 * 
 * 
 */

function initSheet(sheetObj,sheetNo) {
    var formObj=document.form;
    var cnt=0;
    switch(sheetNo) {
        case 1:      // Auditing Object Sheet
            with(sheetObj){        
                   
                  var HeadTitle1="|Equipment\nNumber|TP / SZ|Original\nTP / SZ|Reference No|From Node|From Node|Via Node|Via Node|To Node|To Node|Door|Door|"
                  +"Actual\nCustomer|Door Delivery\nAddress|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount"
                  +"|Work Order Amount|Work Order Amount|Work Order Amount|Exchange\nRate|Exch Rate Adj.|Calculation\nLogic|Invoice Amount|Invoice Amount|Invoice Amount|Invoice Amount|S/O No|W/O No|"
                  +"W/O Issue Time|W/O Issue Time|COP\nExecuted Time|BKG No|BL No|BKG\nCargo Type|BKG\nSPE|Bound|Door\nService Type|3rd Party"
                  +"|Internal Remark|Internal Remark|Special Instruction|Reference|Reference|Outgate Date|Ingate Date"
                  +"|Verify Result|Invoice Remark|S/O Type|STS";
                  var HeadTitle2="|Equipment\nNumber|TP / SZ|Original\nTP / SZ|Reference No| || || || ||"
                  +"Actual\nCustomer|Door Delivery\nAddress|Currency|Basic|Negotiated|Fuel"
                  +"|Additional|Multi Curr.|Total|Exchange\nRate|Exch Rate Adj.|Calculation\nLogic|Currency|Basic|Surcharge|Total|S/O No|W/O No|"
                  +"| |COP\nExecuted Time|BKG No|BL No|BKG\nCargo Type|BKG\nSPE|Bound|Door\nService Type|3rd Party"
                  +"|Internal Remark|Internal Remark|Special Instruction|CNTR No|TP/SZ|Outgate Date|Ingate Date"
                  +"|Verify Result|Invoice Remark|S/O Type|STS";
                  SetHeaderRowHeight(12);
                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:3, DataRowMerge:1 } );
                  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                  var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                  InitHeaders(headers, info);
                  var cols = [ 
                         {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk1",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"org_eq_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ref_inv_no",           	 	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"fm_loc_value",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"fm_yard_value",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"via_loc_value",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"via_yard_value",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"to_loc_value",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"to_yard_value",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"dor_loc_value",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dor_yard_value",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dor_de_addr",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                        if(formObj.apply_currency.value == 'JPY' || formObj.apply_currency.value == 'KRW' || formObj.apply_currency.value == 'TWD'){
                          cols.push({Type:"Int",       Hidden:0,  Width:90,   Align:"right",  ColMerge:1,   SaveName:"bzc_amt",                   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Int",       Hidden:0,  Width:90,   Align:"right",  ColMerge:1,   SaveName:"nego_amt",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Int",       Hidden:0,  Width:90,   Align:"right",  ColMerge:1,   SaveName:"fuel_scg_amt",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Int",       Hidden:0,  Width:90,   Align:"right",  ColMerge:1,   SaveName:"etc_add_amt",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Center", ColMerge:1,   SaveName:"multi_curr_yn",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Int",       Hidden:0,  Width:100,  Align:"right",  ColMerge:1,   SaveName:"wo_tot_amt",                KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                        }else{
                          cols.push({Type:"Float",     Hidden:0,  Width:90,   Align:"right",  ColMerge:1,   SaveName:"bzc_amt",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Float",     Hidden:0,  Width:90,   Align:"right",  ColMerge:1,   SaveName:"nego_amt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Float",     Hidden:0,  Width:90,   Align:"right",  ColMerge:1,   SaveName:"fuel_scg_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Float",     Hidden:0,  Width:90,   Align:"right",  ColMerge:1,   SaveName:"etc_add_amt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
						  cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Center", ColMerge:1,   SaveName:"multi_curr_yn",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Float",     Hidden:0,  Width:100,  Align:"right",  ColMerge:1,   SaveName:"wo_tot_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                        }
                          cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"right",  ColMerge:1,   SaveName:"inv_xch_rt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Float",     Hidden:0,  Width:100,  Align:"right",  ColMerge:1,   SaveName:"inv_adj_bzc_amt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
                          cols.push({Type:"Combo",     Hidden:0,  Width:170,  Align:"Center", ColMerge:1,   SaveName:"trsp_inv_calc_lgc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center", ColMerge:1,   SaveName:"inv_curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                       if(formObj.apply_currency.value == 'JPY' || formObj.apply_currency.value == 'KRW' || formObj.apply_currency.value == 'TWD'){
                          cols.push({Type:"Int",       Hidden:0,  Width:100,  Align:"right",  ColMerge:1,   SaveName:"inv_bzc_amt",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Popup",     Hidden:0,  Width:100,  Align:"right",  ColMerge:1,   SaveName:"inv_etc_add_amt",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Int",       Hidden:0,  Width:100,  Align:"right",  ColMerge:1,   SaveName:"inv_tot_amt",               KeyField:0,   CalcLogic:"|inv_bzc_amt|+|inv_etc_add_amt|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                       }else{
                          cols.push({Type:"Float",     Hidden:0,  Width:100,  Align:"right",  ColMerge:1,   SaveName:"inv_bzc_amt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Popup",     Hidden:0,  Width:100,  Align:"right",  ColMerge:1,   SaveName:"inv_etc_add_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Float",     Hidden:0,  Width:100,  Align:"right",  ColMerge:1,   SaveName:"inv_tot_amt",               KeyField:0,   CalcLogic:"|inv_bzc_amt|+|inv_etc_add_amt|",Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                       }
                          cols.push({Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"trsp_wo_ofc_cty_cd_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Date",      Hidden:0,  Width:80,    Align:"Center",  ColMerge:1,   SaveName:"cre_dt",                    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:50,    Align:"Center",  ColMerge:1,   SaveName:"cre_tm",                    KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:90,    Align:"Center",  ColMerge:1,   SaveName:"cop_exe_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:80,    Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:80,    Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_cntr_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:80,    Align:"Center",  ColMerge:1,   SaveName:"trsp_bnd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:80,    Align:"Center",  ColMerge:1,   SaveName:"dor_svc_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Popup",     Hidden:0, Width:110,    Align:"Center",  ColMerge:1,   SaveName:"n3pty_bil_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 , TrueValue:'Y', FalseValue :'F'});
                          cols.push({Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"inter_rmk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Image",     Hidden:0,  Width:20,    Align:"Center",  ColMerge:1,   SaveName:"inter_rmk_img",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:120,   Align:"Left",    ColMerge:1,   SaveName:"spcl_instr_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2000,UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:60,    Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:"org_gate_out_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:"dest_gate_in_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:200,   Align:"Left",    ColMerge:1,   SaveName:"verify_result",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2000,UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:200,   Align:"Left",    ColMerge:1,   SaveName:"inv_rmk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2000,UpdateEdit:1,   InsertEdit:1 });
                          cols.push({Type:"Text",      Hidden:1,  Width:60,    Align:"Center",  ColMerge:1,   SaveName:"trsp_so_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Status",    Hidden:1, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" });
                          cols.push({Type:"Text",      Hidden:1, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"cust_seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"trsp_wo_ofc_cty_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"trsp_wo_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"trsp_so_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"trsp_cost_dtl_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"trsp_inv_act_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"trsp_mty_cost_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"surcharge_key" });
                          cols.push({Type:"Text",      Hidden:1, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"cntr_sub_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"sub_eq_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"org_eq_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"empty_eq_no_verify_check",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"cost_act_grp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"trsp_frst_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"n3pty_curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"org_inv_bzc_amt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"ref_id",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
             
                          InitColumns(cols);
                          SetEditable(1);
                          AllowEvent4CheckAll(false);
                          SetColProperty('trsp_inv_calc_lgc_tp_cd', {ComboText:calc_logic_cdText, ComboCode:calc_logic_cdCode} );
                          SetImageList(1,"img/btns_search_g.gif");
                          ComResizeSheet(sheetObj, 60);
            }
            break;
        case 2:      // Comfirm Sheet
            with(sheetObj){                  
                  var HeadTitle1="|Equipment\nNumber|TP / SZ|Original\nTP / SZ|Reference No|From Node|From Node|Via Node|Via Node|To Node|To Node|Door|Door|"
                  +"Actual\nCustomer|Door Delivery\nAddress|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount"
                  +"|Work Order Amount|Work Order Amount|Work Order Amount|Exchange\nRate|Exch Rate Adj.|Calculation\nLogic|Invoice Amount|Invoice Amount|Invoice Amount|Invoice Amount|S/O No|W/O No|"
                  +"W/O Issue Time|W/O Issue Time|COP\nExecuted Time|BKG No|BL No|BKG\nCargo Type|BKG\nSPE|Bound|Door\nService Type|3rd Party"
                  +"|Internal Remark|Internal Remark|Special Instruction|Reference|Reference|Outgate Date|Ingate Date"
                  +"|Verify Result|Invoice Remark";
                  var HeadTitle2="|Equipment\nNumber|TP / SZ|Original\nTP / SZ|Reference No| || || || ||"
                  +"Actual\nCustomer|Door Delivery\nAddress|Currency|Basic|Negotiated|Fuel"
                  +"|Additional|Multi Curr.|Total|Exchange\nRate|Exch Rate Adj.|Calculation\nLogic|Currency|Basic|Surcharge|Total|S/O No|W/O No|"
                  +"| |COP\nExecuted Time|BKG No|BL No|BKG\nCargo Type|BKG\nSPE|Bound|Door\nService Type|3rd Party"
                  +"|Internal Remark|Internal Remark|Special Instruction|CNTR No|TP/SZ|Outgate Date|Ingate Date"
                  +"|Verify Result|Invoice Remark";
                  SetHeaderRowHeight(12);
                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );
                  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                  var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                  InitHeaders(headers, info);
                  var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk1",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"org_eq_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ref_inv_no",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"fm_loc_value",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"fm_yard_value",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"via_loc_value",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"via_yard_value",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"to_loc_value",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"to_yard_value",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"dor_loc_value",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dor_yard_value",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dor_de_addr",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                        if(formObj.apply_currency.value == 'JPY' || formObj.apply_currency.value == 'KRW' || formObj.apply_currency.value == 'TWD'){
                          cols.push({Type:"Int",       Hidden:0,  Width:90,   Align:"right",  ColMerge:1,   SaveName:"bzc_amt",                   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Int",       Hidden:0,  Width:90,   Align:"right",  ColMerge:1,   SaveName:"nego_amt",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Int",       Hidden:0,  Width:90,   Align:"right",  ColMerge:1,   SaveName:"fuel_scg_amt",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Int",       Hidden:0,  Width:90,   Align:"right",  ColMerge:1,   SaveName:"etc_add_amt",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1,  Width:90,   Align:"Center", ColMerge:1,   SaveName:"multi_curr_yn",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Int",       Hidden:0,  Width:100,  Align:"right",  ColMerge:1,  SaveName:"wo_tot_amt",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          }else{
                          cols.push({Type:"Float",     Hidden:0,  Width:90,   Align:"right",  ColMerge:1,   SaveName:"bzc_amt",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Float",     Hidden:0,  Width:90,   Align:"right",  ColMerge:1,   SaveName:"nego_amt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Float",     Hidden:0,  Width:90,   Align:"right",  ColMerge:1,   SaveName:"fuel_scg_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Float",     Hidden:0,  Width:90,   Align:"right",  ColMerge:1,   SaveName:"etc_add_amt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1,  Width:90,   Align:"Center", ColMerge:1,   SaveName:"multi_curr_yn",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Float",     Hidden:0,  Width:100,  Align:"right",  ColMerge:1,   SaveName:"wo_tot_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                          }
                          cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"right",   ColMerge:1,   SaveName:"inv_xch_rt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Float",     Hidden:0,  Width:100,  Align:"right",   ColMerge:1,   SaveName:"inv_adj_bzc_amt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Combo",     Hidden:0,  Width:170,  Align:"Center",  ColMerge:1,   SaveName:"trsp_inv_calc_lgc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          if(formObj.apply_currency.value == 'JPY' || formObj.apply_currency.value == 'KRW' || formObj.apply_currency.value == 'TWD'){
                          cols.push({Type:"Int",       Hidden:0,  Width:100,   Align:"right",  ColMerge:1,   SaveName:"inv_bzc_amt",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Popup",     Hidden:0,  Width:100,   Align:"right",  ColMerge:1,   SaveName:"inv_etc_add_amt",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Int",       Hidden:0,  Width:100,   Align:"right",  ColMerge:1,   SaveName:"inv_tot_amt",               KeyField:0,   CalcLogic:"|inv_bzc_amt|+|inv_etc_add_amt|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          }else{
                          cols.push({Type:"Float",     Hidden:0,  Width:100,   Align:"right",  ColMerge:1,   SaveName:"inv_bzc_amt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Popup",     Hidden:0,  Width:100,   Align:"right",  ColMerge:1,   SaveName:"inv_etc_add_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Float",     Hidden:0,  Width:100,   Align:"right",  ColMerge:1,   SaveName:"inv_tot_amt",               KeyField:0,   CalcLogic:"|inv_bzc_amt|+|inv_etc_add_amt|",Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                          }
                          cols.push({Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"trsp_wo_ofc_cty_cd_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Date",      Hidden:0,  Width:80,    Align:"Center",  ColMerge:1,   SaveName:"cre_dt",                    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:50,    Align:"Center",  ColMerge:1,   SaveName:"cre_tm",                    KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:90,    Align:"Center",  ColMerge:1,   SaveName:"cop_exe_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_cntr_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trsp_bnd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dor_svc_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Popup",     Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_bil_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 , TrueValue:'Y', FalseValue :'F'});
                          cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inter_rmk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Image",     Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"inter_rmk_img",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"spcl_instr_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2000,UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"org_gate_out_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"dest_gate_in_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"verify_result",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2000,UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"inv_rmk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2000,UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Status",    Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" });
                          cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cust_seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"trsp_wo_of_cty_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"trsp_wo_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"trsp_so_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"trsp_so_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"trsp_cost_dtl_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"trsp_inv_act_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"surcharge_key" });
                          cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_sub_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                          cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"sub_eq_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                          cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"org_eq_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                          cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"empty_eq_no_verify_check",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
                          cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cost_act_grp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                          cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"org_inv_bzc_amt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
             
                          InitColumns(cols);
                          SetEditable(1);
                          SetColHidden('ibflag',1);
                          AllowEvent4CheckAll(false);
                          SetColProperty(0, 'trsp_inv_calc_lgc_tp_cd', {ComboText:calc_logic_cdText, ComboCode:calc_logic_cdCode} );
                          SetImageList(1,"img/btns_search_g.gif");
                          SetSheetHeight(350);
                  }
            break;
        case 3:  //Invoice 
            with(sheetObj){        
                  var HeadTitle="";
                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );
                  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
                  InitHeaders(headers, info);
            
                  var cols = [ {Type:"Status",    Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_vndr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsp_inv_aud_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"gen_pay_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_cfm_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"wo_vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"wo_vndr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_bzc_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_vat_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_ttl_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rgst_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_pay_mzd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_chk_trns_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_rcv_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pay_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_rjct_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_eff_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_rjct_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_iss_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vat_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cur_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"if_sys_knd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"inv_whld_tax_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 } ];
       
		              InitColumns(cols);        
		              SetEditable(1);
		              SetVisible(false);
             }
            break;
            case 4: //
                with(sheetObj){
                  var HeadTitle="ibflag|chk1|unique_cd|trsp_so_ofc_cty_cd|trsp_so_seq|lgs_cost_cd|lgs_cost_full_nm|scg_dtl_seq|trsp_step_tp_cd" ;
                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:2, DataRowMerge:0 } );
                  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
                  InitHeaders(headers, info);
                  var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                     {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"chk1" },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'unique_cd',                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_so_ofc_cty_cd',          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_so_seq',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lgs_cost_cd',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'lgs_cost_full_nm',            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+'scg_dtl_seq',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_step_tp_cd',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'scg_amt',                     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'chss_no',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'incur_dt',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'dry_run_rlbl_pty_tp_cd',      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'fne_cuz_desc',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'fumg_cost_tp_cd',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'mgst_tpsz_cd',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'insp_rf_pti_cstms_tp_cd',     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lftg_knt',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lftg_cuz_desc',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'stop_loc_nod_cd',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'grs_wgt',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'incrt_dt',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'scl_stop_plc_nod_cd',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'sto_dys',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'ob_bkg_no',                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'wt_hrs',                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'otr_rmk',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_scg_amt',                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_chss_no',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_incur_dt',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_dry_run_rlbl_pty_tp_cd',  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_fne_cuz_desc',            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_fumg_cost_tp_cd',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_mgst_tpsz_cd',            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_insp_rf_pti_cstms_tp_cd', KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_lftg_knt',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_lftg_cuz_desc',           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_stop_loc_nod_cd',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_grs_wgt',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_incrt_dt',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_scl_stop_plc_nod_cd',     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_sto_dys',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_ob_bkg_no',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_wt_hrs',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_otr_rmk',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_bil_flg',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cust_cnt_cd',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cust_seq',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_vndr_seq',              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_ofc_cd',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_amt',                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_desc',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_curr_cd',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cre_ofc_cd',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cre_usr_id',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+'curr_cd',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'wo_scg_xch_rt',               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:6,   UpdateEdit:1,   InsertEdit:1 } ];
                      InitColumns(cols);            
                      SetEditable(1);
                      SetSheetHeight(245);
                      SetVisible(false);
                }
            break;
    }
}

var globalRowCnt = 0;
var globalAfterRowCnt = 0;
var globalScgRowCnt = 0;
var globalAfterScgRowCnt = 0;

function doActionIBSheet(sheetObj,formObj,sAction) {
    switch(sAction) {
        case IBSEARCH:      //Retrieve
            formObj.wo_no.value = formObj.wo_no.value.toUpperCase();
            formObj.so_no.value = formObj.so_no.value.toUpperCase();
            if(!validateForm(sheetObj,formObj, 'SEARCH01')) {
                ComOpenWait(false);
            	return;
            }
            formObj.f_cmd.value = SEARCH01;
            var sheetObj_surcharge = sheetObjects[3];
            
            globalRowCnt = sheetObj.RowCount();
            globalScgRowCnt = sheetObj_surcharge.RowCount();
            
            sheetObj.DoSearch("ESD_TRS_0033GS.do", TrsFrmQryString(formObj), {Sync:2, Append:true} );
            break;
        case IBSAVE:
        	if(!apply_flag){
                ComShowCodeMessage('TRS90080');
                return;
            }
            if(sheetObjects[0].RowCount() < 1 && sheetObjects[1].RowCount()< 1){
                ComShowCodeMessage('TRS90132');
                return;
            }
            for(var row = sheetObj.HeaderRows(); row < sheetObj.HeaderRows() + sheetObj.RowCount(); row++){
            	if (sheetObj.GetCellValue(row, 'empty_eq_no_verify_check') != 'Y') {
            		ComShowCodeMessage('TRS90007');
            		return;
                }
            }
            formObj.inv_amt.value=deleteComma(formObj.inv_amt.value);
            formObj.vat_amt.value=deleteComma(formObj.vat_amt.value);
            formObj.wht_amt.value=deleteComma(formObj.wht_amt.value);
            formObj.tot_amt.value=deleteComma(formObj.tot_amt.value);
            formObj.sum_inv_tot_amt.value=deleteComma(formObj.sum_inv_tot_amt.value);
            
            if(!validateForm(sheetObj,formObj, IBSAVE)) return;
            
            formObj.f_cmd.value=MULTI01;
            var sheetObj_confirm=sheetObjects[1];
            var sheetObj_surcharge=sheetObjects[3];
            for(var i=2; i<sheetObj.RowCount()+2; i++){
                sheetObj.SetCellValue(i, 'trsp_inv_act_sts_cd','O',0);
            }
            for(var i=2; i<sheetObj_confirm.RowCount()+2; i++){
                sheetObj_confirm.SetCellValue(i, 'trsp_inv_act_sts_cd','C',0);
            }
            var confirmQuery='';
            var surchargeQuery=sheetObj_surcharge.GetSaveString(true, false);
            if(sheetObj.RowCount() > 0){
                confirmQuery=sheetObj_confirm.GetSaveString(true, false);
                sheetObj.DoAllSave('ESD_TRS_0033GS.do', confirmQuery+'&'+surchargeQuery+'&'+TrsFrmQryString(formObj), false);
            } else {
                confirmQuery=sheetObj.GetSaveString(true, false);
                sheetObj_confirm.DoAllSave('ESD_TRS_0033GS.do', confirmQuery+'&'+surchargeQuery+'&'+TrsFrmQryString(formObj), false);
            }
            calAmt();
            formObj.sum_inv_tot_amt.value=ComAddComma(formObj.sum_inv_tot_amt.value);
            break;
        case 'CONFIRM':
            if(!apply_flag){
                ComShowCodeMessage('TRS90080');
                return;
            }
            if(sheetObjects[0].RowCount()< 1 && sheetObjects[1].RowCount()< 1){
                ComShowCodeMessage('TRS90132');
                return;
            }
            if(!validateForm(sheetObj,formObj, 'CONFIRM')) return;
            formObj.f_cmd.value=MULTI02;
            var sheetObj_audit=sheetObjects[0];
            var sheetObj_confirm=sheetObjects[1];
            var sheetObj_surcharge=sheetObjects[3];
            var checkList=sheetObj_confirm.FindCheckedRow('chk1');
            var checkArray=checkList.split('|');
            if(checkList == ''){
                ComShowCodeMessage('TRS90215');
                return false;
            }
            
            if(Number(deleteComma(formObj.sum_inv_tot_amt.value)) != Number(deleteComma(formObj.inv_amt.value))){
                ComShowCodeMessage('TRS90035');
                return;
            }
            formObj.inv_amt.value=deleteComma(formObj.inv_amt.value);
            formObj.vat_amt.value=deleteComma(formObj.vat_amt.value);
            formObj.wht_amt.value=deleteComma(formObj.wht_amt.value);
            formObj.tot_amt.value=deleteComma(formObj.tot_amt.value);
            formObj.sum_inv_tot_amt.value=deleteComma(formObj.sum_inv_tot_amt.value);
            
            for(var i=2; i<sheetObj.RowCount()+2; i++){
                sheetObj.SetCellValue(i, 'trsp_inv_act_sts_cd','',0);
                for(var k=sheetObj_surcharge.RowCount(); k>0; k--){
                    if(sheetObj_surcharge.GetCellValue(k, 'unique_cd') == sheetObj.GetCellValue(i, 'trsp_so_seq')){
                        sheetObj_surcharge.RowDelete(k, false);
                    }
                }
            }
            for(var i=2; i<sheetObj_confirm.RowCount()+2; i++){
                sheetObj_confirm.SetCellValue(i, 'trsp_inv_act_sts_cd','',0);
                if( sheetObj_confirm.GetCellValue(i, 'chk1') == 0){
                    for(var k=sheetObj_surcharge.RowCount(); k>0; k--){
                        if(sheetObj_surcharge.GetCellValue(k, 'unique_cd') == sheetObj.GetCellValue(i, 'trsp_so_seq')){
                            sheetObj_surcharge.RowDelete(k, false);
                        }
                    }
                }
            }
            for(var i=0; i<checkArray.length; i++){
                sheetObj_confirm.SetCellValue(checkArray[i], 'trsp_inv_act_sts_cd','C',0);
            }
            var auditQuery=sheetObj.GetSaveString(true, true);
            var surchargeQuery=sheetObj_surcharge.GetSaveString(true, true);
            sheetObj_confirm.DoAllSave('ESD_TRS_0033GS.do',auditQuery+'&'+surchargeQuery+'&'+TrsFrmQryString(formObj), false); 
        	calAmt();
        	formObj.sum_inv_tot_amt.value=ComAddComma(formObj.sum_inv_tot_amt.value);            	
            break;
    }
}
function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y){
    var colName=sheetObj.ColSaveName(sheetObj.MouseCol());
    var formObj=document.form;
    if(colName == 'chk1' && ( sheetObj.MouseRow()== 0 ||  sheetObj.MouseRow()== 1 )){
        if(sheetObj.GetCellText(sheetObj.MouseRow(),'chk1') == 0){
            setSumOfInvoiceTotalAmountForAllCheck2(sheetObj, document.form);
            setNumOfEQForAllCheck2(sheetObj, document.form);
        }else if(sheetObj.GetCellText(sheetObj.MouseRow(),'chk1') == 1){
            formObj.cur_sum_inv_audit.value=formObj.apply_currency.options[formObj.apply_currency.selectedIndex].value;
            formObj.sum_inv_tot_amt_audit.value=setPosition(0);
            formObj.num_eq_20_audit.value='0';
            formObj.num_eq_40_audit.value='0';
            formObj.num_eq_tot_audit.value='0';
        }
    }
}
function sheet2_OnMouseDown(sheetObj, Button, Shift, X, Y){
    var colName=sheetObj.ColSaveName(sheetObj.MouseCol());
    var formObj=document.form;
    if(colName == 'chk1' && ( sheetObj.MouseRow()== 0 ||  sheetObj.MouseRow()== 1 )){
        if(sheetObj.GetCellText(sheetObj.MouseRow(),'chk1') == 0){
            setSumOfInvoiceTotalAmountForAllCheck(sheetObj, document.form);
            setNumOfEQForAllCheck(sheetObj, document.form);
        }else if(sheetObj.GetCellText(sheetObj.MouseRow(),'chk1') == 1){
            formObj.cur_sum_inv.value=formObj.apply_currency.options[formObj.apply_currency.selectedIndex].value;
            formObj.sum_inv_tot_amt.value=setPosition(0);
            formObj.num_eq_20.value='0';
            formObj.num_eq_40.value='0';
            formObj.num_eq_tot.value='0';
        }
    }
}
/**
 * Sum of Invoice Total Amount
 **/
function setSumOfInvoiceTotalAmountForAllCheck(sheetObj, formObj){
    var resultValue=0;
    for(var i=2; i<sheetObj.RowCount()+2; i++){
        resultValue += isNaN(Number(deleteComma(sheetObj.GetCellValue(i, 'inv_tot_amt'))))?0:Number(deleteComma(sheetObj.GetCellValue(i, 'inv_tot_amt')));
    }
    formObj.cur_sum_inv.value=formObj.apply_currency.options[formObj.apply_currency.selectedIndex].value;
    formObj.sum_inv_tot_amt.value=setPosition(resultValue);
    formObj.sum_inv_tot_amt.value=ComAddComma(formObj.sum_inv_tot_amt.value);
}
/**
 * Sum of Invoice Total Amount
 **/
function setSumOfInvoiceTotalAmountForAllCheck2(sheetObj, formObj){
    var resultValue=0;
    for(var i=2; i<sheetObj.RowCount()+2; i++){
        resultValue += isNaN(Number(deleteComma(sheetObj.GetCellValue(i, 'inv_tot_amt'))))?0:Number(deleteComma(sheetObj.GetCellValue(i, 'inv_tot_amt')));
    }
    formObj.cur_sum_inv_audit.value=formObj.apply_currency.options[formObj.apply_currency.selectedIndex].value;
    formObj.sum_inv_tot_amt_audit.value=setPosition(resultValue);
    formObj.sum_inv_tot_amt_audit.value=ComAddComma(formObj.sum_inv_tot_amt_audit.value);
}
/**
 * Number of EQ
 **/
function setNumOfEQForAllCheck(sheetObj, formObj){
    var cnt_20=0;
    var cnt_40=0;
    var tp_cd='';
    var tp_size='';
    var resultValue=0;
    for(var i=2; i<sheetObj.RowCount()+2; i++){
        if(sheetObj.GetCellValue(i, 'eq_knd_cd')=='U'){
            tp_cd=sheetObj.GetCellValue(i, 'eq_tpsz_cd');
            if(tp_cd.length == 2) tp_size=tp_cd.substr(1,2);
            else continue;
            if(tp_size == '2') cnt_20++;
            else cnt_40++;
        }
    }
    formObj.num_eq_20.value=cnt_20;
    formObj.num_eq_40.value=cnt_40;
    formObj.num_eq_tot.value=sheetObj.RowCount();
}
/**
 * Number of EQ
 **/
function setNumOfEQForAllCheck2(sheetObj, formObj){
    var cnt_20=0;
    var cnt_40=0;
    var tp_cd='';
    var tp_size='';
    var resultValue=0;
    for(var i=2; i<sheetObj.RowCount()+2; i++){
        if(sheetObj.GetCellValue(i, 'eq_knd_cd')=='U'){
            tp_cd=sheetObj.GetCellValue(i, 'eq_tpsz_cd');
            if(tp_cd.length == 2) tp_size=tp_cd.substr(1,2);
            else continue;
            if(tp_size == '2') cnt_20++;
            else cnt_40++;
        }
    }
    formObj.num_eq_20_audit.value=cnt_20;
    formObj.num_eq_40_audit.value=cnt_40;
    formObj.num_eq_tot_audit.value=sheetObj.RowCount();
}

/**
 * sheet1_OnRowSearchEnd
 * @param sheetObj
 * @param row
 */
function sheet1_OnRowSearchEnd(SheetObj, Row) {
	var formObj = document.form;
	var invCurrVal = formObj.apply_currency.value;
	if(formObj.f_cmd.value == SEARCH01) {
		if(invCurrVal == SheetObj.GetCellValue(Row, 'curr_cd') && SheetObj.GetCellValue(Row, 'multi_curr_yn') == 'N') {
			SheetObj.SetCellEditable(Row, 'inv_adj_bzc_amt', 0);
		} else {
			SheetObj.SetCellEditable(Row, 'inv_adj_bzc_amt', 1);
		}
	}
}

function sheet4_OnSearchEnd(sheetObj, errCode,  errMsg) {
	var formObj=document.form;
    if(errCode >= 0 ) {
        globalAfterRowCnt = sheetObjects[0].RowCount();
        globalAfterScgRowCnt = sheetObj.RowCount();
        
        if(globalRowCnt > 0 && (globalAfterRowCnt-globalRowCnt) == 0) {
        	ComOpenWait(false);
            ComShowCodeMessage('TRS90220');
        } else {
            removeDupSoNo(sheetObjects[0], globalRowCnt, globalAfterRowCnt, globalScgRowCnt, globalAfterScgRowCnt);
            setCurrChange();
        }
        setSumOfInvoiceTotalAmountForAllCheck2(sheetObjects[0], formObj);
        setNumOfEQForAllCheck2(sheetObjects[0], formObj);
    }
}

/**
 * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
 */
function sheet1_OnSearchEnd(sheetObj, errCode,  errMsg) {
	var formObj=document.form;
    if(errCode >= 0 ) {
        if(formObj.f_cmd.value == SEARCH12){
            var bil_curr_cd=sheetObj.GetEtcData('bil_curr_cd');
            var selectObj=formObj.apply_currency;
            for(var i=0; i<selectObj.length; i++){
                if( selectObj.options[i].value == bil_curr_cd){
                    selectObj.options[i].selected=true;
                    selectedIdx=i;
                    break;
                }
            }
            formObj.f_cmd.value='';
        } else if (formObj.f_cmd.value == SEARCH15){
            setSumOfInvoiceTotalAmount2(sheetObj, formObj);
            setNumOfEQ2(sheetObj, formObj);
            formObj.f_cmd.value='';
        } else if (formObj.f_cmd.value == SEARCH16){
            formObj.f_cmd.value='';
        } else if( formObj.f_cmd.value == SEARCH01 || formObj.f_cmd.value == SEARCH06) {
            var scgXml=sheetObj.GetEtcData("scgXml");
            if( scgXml == undefined || ComTrim(scgXml) == ''){
                ComOpenWait(false);
                return;
            }
            scgXml=scgXml.replace(new RegExp("<TD>","gi"),'<TD><![CDATA[');
            scgXml=scgXml.replace(new RegExp("</TD>","gi"),']]></TD>');
            sheetObjects[3].LoadSearchData(scgXml,{Append:1} );
            sheetObj.RemoveEtcData();
            
            // 2015.04.07 CHAN WOO PARK
            // Check every row and if there is EQ_NO, compare it with ORG_EQ_NO
            // and if those two are same set 'EQ_NO' cell as non-editable
            for(var row = sheetObj.HeaderRows(); row < sheetObj.HeaderRows() + sheetObj.RowCount(); row++) {
            	// Curr. Change button disable
            	if(row == 2) {
            		if(formObj.apply_currency.value == sheetObj.GetCellValue(row, 'curr_cd')) {
            			formObj.btng_currencychange.disabled = true;
            		}
            	}
            	
            	var eq_no_tmp = sheetObj.GetCellValue(row, 'eq_no');
                var org_eq_no_tmp = sheetObj.GetCellValue(row, 'org_eq_no');
                /*
                 * compare EQ_NO and ORG_EQ_NO(Except for the null case)
                 * 1. if EQ_NO == ORG_EQ_NO
                 * 	1) set 'EQ_NO' cell as non-editable
                 *	2) set row as it is verified
                 * 2. if there is no EQ_NO(else)
                 *	1) set 'EQ_NO' cell as editable
                */
            	if ((eq_no_tmp == org_eq_no_tmp) && eq_no_tmp != null && org_eq_no_tmp != null && eq_no_tmp != '' && org_eq_no_tmp != '') {
                	sheetObj.SetCellValue(row,'empty_eq_no_verify_check','Y',0);	// make it as verify is already processed
                } // end if
            	else {
            		sheetObj.SetCellEditable(row, 'eq_no', 1);
                	sheetObj.SetCellValue(row,'empty_eq_no_verify_check','N',0);
            	} // end else
            	
//            	setCurrencyChange(formObj.apply_currency.value, sheetObj.GetCellValue(row, 'inv_xch_rt'), sheetObj.GetCellValue(row, 'trsp_inv_calc_lgc_tp_cd'));
                sheetObj.SetCellValue(row, 'inv_curr_cd', formObj.apply_currency.value, 0);
                sheetObj.SetCellValue(row, 'org_inv_bzc_amt', sheetObj.GetCellValue(row, 'inv_bzc_amt'), 0);
                calCurrencyChange(row, sheetObj);
                if(sheetObj.GetCellValue(row, 'inv_curr_cd') == 'JPY' || sheetObj.GetCellValue(row, 'inv_curr_cd') == 'KRW' || sheetObj.GetCellValue(row, 'inv_curr_cd') == 'TWD'){
                    setDecimalType_Audit(sheetObj, row);
                } else {
                    setFloatingType_Audit(sheetObj, row);
                }
            } // end for 


        }
    }
}
/**
 * 
 * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
 */
function sheet2_OnSearchEnd(sheetObj, errMsg) {
    var formObj=document.form;
    if( errMsg != null && errMsg != 0 && errMsg != -1) {
        ComShowMessage(errMsg);
        formObj.f_cmd.value='';
    }else{
        if( formObj.f_cmd.value == SEARCH01||formObj.f_cmd.value == SEARCH06){
            var scgXml=sheetObj.GetEtcData("scgXml");
            if( scgXml == undefined || ComTrim(scgXml) == ''){
                return;
            }
            scgXml='<?xml version="1.0"  ?>'+scgXml;            
            scgXml=scgXml.replace(new RegExp("<TD>","gi"),'<TD><![CDATA[');
            scgXml=scgXml.replace(new RegExp("</TD>","gi"),']]></TD>');
            sheetObjects[3].LoadSearchData(scgXml,{Append:1 , Sync:1} );
            sheetObj.RemoveEtcData();
        }    
    }
}
/**
 * 
    * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {
    var formObj=document.form;
    if( errMsg != null && errMsg != 0 && errMsg != -1 ) {
        ComShowMessage(errMsg);
    } else {
        if(formObj.f_cmd.value == MULTI01){
            ComShowCodeMessage('TRS90057');
        }
    }
}
/**
 * 
    * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
 */
function sheet2_OnSaveEnd(sheetObj, errMsg) {
    var formObj=document.form;
    if( errMsg != null && errMsg < 0 ) {
        //ComShowMessage(errMsg);
    } else {
        if(formObj.f_cmd.value == MULTI02){
            ComShowCodeMessage('TRS90056');
            setDisabled('CONFIRM');
        } else if(formObj.f_cmd.value == MULTI01){
            ComShowCodeMessage('TRS90057');
        }
    }
}

/**
  * Registering IBTab Object as array
 */
function setTabObject(tab_obj){
    tabObjects[tabCnt++]=tab_obj;
}
/**
 * Setting Tab 
 * Setting the Items of Tab 
 */
function initTab(tabObj , tabNo) {
     switch(tabNo) {
         case 1:
            with (tabObj) {
                var cnt=0 ;
                InsertItem( "Auditing Object" , "");
                InsertItem( "      Confirm      " , "");
                //InsertTab( cnt++ , "      For NIS      " , -1 );
            }
         break;
     }
}
/**
  * Event clicking a tab
  * Activating the selected tab 
 */
function tab1_OnChange(tabObj , nItem) {
    var objs=document.all.item("tabLayer");
    objs[nItem].style.display="Inline";
    for(var i = 0; i<objs.length; i++){
          if(i != nItem){
        	  objs[i].style.display="none";
        	  objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
          }
     }
    beforetab=nItem;
    if(beforetab == 1) {
    	ComResizeSheet(sheetObjects[1], 60);
    } else {
    	ComResizeSheet(sheetObjects[0], 60);
    }
}
/**
  * Event clicking a tab
  * Activating the selected tab 
 */
function Minimize(nItem) {
    if(document.all.MiniLayer.style.display != "none") {
        document.all.MiniLayer.style.display="none";                
    } else {
        document.all.MiniLayer.style.display="";                
    }
    if(beforetab == 1) {
    	ComResizeSheet(sheetObjects[1], 60);
    } else {
    	ComResizeSheet(sheetObjects[0], 60);
    }
}
/**
    * Validating inputted values of form
 */    
function validateForm(sheetObj,formObj,sAction){
    switch(sAction){
        case 'APPLY':
            var inv_no=formObj.invoice_no.value;
            var rv_dt=formObj.recieve_dt.value;
            var is_dt=formObj.issue_dt.value;
            var ps_cd=formObj.paymt_sp_cd.value;
            var ap_cur=formObj.apply_currency.options[formObj.apply_currency.selectedIndex].value;
            if(inv_no == null || inv_no == ''){
                ComShowCodeMessage('COM12114','Invoice No');
                formObj.invoice_no.focus();
                return false;
            }else if(rv_dt == null || rv_dt == ''){
                ComShowCodeMessage('COM12114','Receive DT');
                formObj.recieve_dt.focus();
                return false;
            }else if(is_dt == null || is_dt == ''){
                ComShowCodeMessage('COM12114','Issue DT');
                formObj.issue_dt.focus();
                return false;
            }else if(formObj.combo_svc_provider.value == ''){
                ComShowCodeMessage('COM12114','W/O S/P');
                formObj.combo_svc_provider.focus();
                return false;
            }else if(ps_cd == null || ps_cd == ''){
                ComShowCodeMessage('COM12114','Payment S/P');
                formObj.combo_svc_provider.focus();
                return false;
            }else if(ap_cur == null || ap_cur == '' || ap_cur == 'ALL'){
                ComShowCodeMessage('COM12114','Currency');
                return false;
            }
            break;
        case 'SEARCH01':
            if( !apply_flag ){
                ComShowCodeMessage('TRS90080');
                return false;
            }else if(formObj.combo_svc_provider.value == ''){
                ComShowCodeMessage('COM12114','W/O S/P');
                formObj.combo_svc_provider.focus();
                return false;
            }else if(formObj.wo_no.value        == '' &&
                     formObj.booking_no.value    == '' &&
                     formObj.bl_no.value        == '' &&
                     formObj.eq_no_text.value    == '' &&
                     formObj.so_no.value        == ''){
                ComShowCodeMessage('TRS90124');
                formObj.wo_no.focus();
                return false;
            }
            if(!TrsComValidFormat("WO", formObj.wo_no.value, true)) { return false; }        
        	if(!TrsComValidFormat("SO", formObj.so_no.value, true)) { return false; }
        	break;
        case IBSAVE:
            var sheetObj=sheetObjects[0];
            var sheetObj1=sheetObjects[0];
            var sheetObj2=sheetObjects[1];
            var surcharge_sheetObj=sheetObjects[3];
            for(var i=sheetObj1.HeaderRows(); i<sheetObj1.RowCount()+sheetObj1.HeaderRows(); i++){
                if( !checkValidInvoiceOfficeCd(sheetObj1.GetCellValue(i, 'cre_ofc_cd'))) {
                    return false;
                } else if(sheetObj.GetCellValue(i, 'inv_etc_add_amt') != '' ||  Number(sheetObj.GetCellValue(i, 'inv_etc_add_amt')) != 0 ) {
                    var unique_cd=sheetObj.GetCellValue(i, 'surcharge_key');
                    var sum=0;
                    for(var a=surcharge_sheetObj.RowCount(); a > 0 ;a--)  {
                        if( surcharge_sheetObj.GetCellValue(a, prefix+'unique_cd') == unique_cd)
                            sum += Number(surcharge_sheetObj.GetCellValue(a, prefix+'inv_scg_amt'));
                    }
                    if(sum != Number(deleteComma(sheetObj.GetCellValue(i, 'inv_etc_add_amt')))){
                        ComShowCodeMessage('COM12114', 'Invoice Additional Etc Amount (S/O No:'+sheetObj.GetCellValue(i, 'trsp_so_ofc_cty_cd') +sheetObj.GetCellValue(i, 'trsp_so_seq') +')' );
                        sheetObj.SetCellValue(i, 'inv_etc_add_amt',0);
                        var scg_amt='';
                        var cnt=0;
                        for(var a=surcharge_sheetObj.RowCount(); a > 0 ;a--) {
                            if( surcharge_sheetObj.GetCellValue(a, prefix+'unique_cd') == unique_cd){
                                scg_amt=Number(surcharge_sheetObj.GetCellValue(a, prefix+'inv_scg_amt'));
                                if(scg_amt == 0) {
                                    surcharge_sheetObj.RowDelete(a, false);
                                }else{
                                    cnt++;
                                    surcharge_sheetObj.SetCellValue(a, prefix+'inv_scg_amt','',0);
                                }
                            }
                        }
                        if (cnt == 0) sheetObj.SetCellValue(i, 'n3pty_bil_flg','');
                        setSumOfInvoiceTotalAmount2(sheetObj, formObj);
                        setNumOfEQ2(sheetObj, formObj);
                        return false;
                    }
                }
            }
            for(var i=sheetObj2.HeaderRows(); i < sheetObj2.RowCount()+sheetObj2.HeaderRows(); i++){
                if( !checkValidInvoiceOfficeCd(sheetObj2.GetCellValue(i, 'cre_ofc_cd'))) {
                    return false;
                }
            }
        break;
        case 'CONFIRM':
            var sheetObj=sheetObjects[0];
            var sheetObj1=sheetObjects[0];
            var sheetObj2=sheetObjects[1];
            var surcharge_sheetObj=sheetObjects[3];
            for(var i=sheetObj1.HeaderRows(); i<    sheetObj1.RowCount()+sheetObj1.HeaderRows(); i++){
                if( !checkValidInvoiceOfficeCd(sheetObj1.GetCellValue(i, 'cre_ofc_cd'))) {
                    return false;
                }else if(sheetObj.GetCellValue(i, 'inv_etc_add_amt') != '' ||
                        Number(sheetObj.GetCellValue(i, 'inv_etc_add_amt')) != 0 ) {
                    var unique_cd=sheetObj.GetCellValue(i, 'surcharge_key');
                    var sum=0;
                    for(var a=surcharge_sheetObj.RowCount(); a>0 ;a--)
                    {
                        if( surcharge_sheetObj.GetCellValue(a, prefix+'unique_cd') == unique_cd)
                        	sum += Number(surcharge_sheetObj.GetCellValue(a, prefix+'inv_scg_amt'));
                    }
                    if(sum != Number(deleteComma(sheetObj.GetCellValue(i, 'inv_etc_add_amt')))){
                        ComShowCodeMessage('COM12114', 'Invoice Additional Etc Amount'
                                +' (S/O No:'+sheetObj.GetCellValue(i, 'trsp_so_ofc_cty_cd')
                                +sheetObj.GetCellValue(i, 'trsp_so_seq')
                        +')'    
                        );
                        sheetObj.SetCellValue(i, 'inv_etc_add_amt',0);
                        var scg_amt='';
                        var cnt=0;
                        for(var a=surcharge_sheetObj.RowCount(); a>0 ;a--)
                        {
                            if( surcharge_sheetObj.GetCellValue(a, prefix+'unique_cd') == unique_cd){
                                scg_amt=Number(surcharge_sheetObj.GetCellValue(a, prefix+'inv_scg_amt'));
                                if(scg_amt == 0) {
                                    surcharge_sheetObj.RowDelete(a, false);
                                }else{
                                    cnt++;
                                    surcharge_sheetObj.SetCellValue(a, prefix+'inv_scg_amt','',0);
                                }
                            }
                        }
                        if (cnt == 0) sheetObj.SetCellValue(i, 'n3pty_bil_flg','');
                        setSumOfInvoiceTotalAmount2(sheetObj, formObj);
                        setNumOfEQ2(sheetObj, formObj);
                        return false;
                    }
                }
            }
            for(var i=sheetObj2.HeaderRows(); i<    sheetObj2.RowCount()+sheetObj2.HeaderRows(); i++){
                if( !checkValidInvoiceOfficeCd(sheetObj2.GetCellValue(i, 'cre_ofc_cd'))) {
                    return false;
                }
            }
        break;
    }
    return true;
}
/**
 * Calling rep_commodity pop-up
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
        var param="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+ "&pgmNo=ESD_TRS_0033";
        ComOpenPopup('ESD_TRS_0906.do' + param, 400, 380, 'getTRS_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * Location : The case selecting one item at pop-up page
 */
function getTRS_ENS_906(rowArray, x1) {
    if(x1 == 'btns_eq_no'){
        var obj=eval('document.form.'+x1.substring(x1.indexOf('btns_')+5)+'_text');
    }else{
        var obj=eval('document.form.'+x1.substring(x1.indexOf('btns_')+5));
    }    
    obj.value=rowArray;
    if(obj.name == 'eq_no_text') {
        checkDigit(obj);
    }
}
/**** PAYMENT SP ****/
function searchPaymentSP(sheetObj, formObj, wo_sp_value) {
    formObj.f_cmd.value=SEARCH02;
    var query=TrsFrmQryString(formObj);
    sheetObj.RemoveEtcData();
     var sXml = sheetObj.GetSearchData("ESD_TRS_0033GS.do", query );
     var prnt_vndr_seq=ComGetEtcData(sXml, "prnt_vndr_seq");
     var prnt_vndr_nm=ComGetEtcData(sXml, "prnt_vndr_nm");
     
     
    var comboObj=paymt_sp_combo;
    comboObj.RemoveAll();
    comboObj.InsertItem(-1, formObj.combo_svc_provider.value, formObj.svc_provider.value);
    if(prnt_vndr_seq == null || prnt_vndr_seq == ''){
        ComShowCodeMessage('TRS90065');
        formObj.combo_svc_provider.focus();
    }else if(lpad(prnt_vndr_seq, 6,'0') !=  lpad(wo_sp_value,6,'0')) {
        comboObj.InsertItem(-1, lpad(prnt_vndr_seq, 6, '0'), prnt_vndr_nm);
    }
    comboObj.SetSelectIndex(0,false);
    formObj.paymt_sp_cd.value=comboObj.GetSelectText();
    formObj.paymt_sp_nm.value=comboObj.GetSelectCode();
    formObj.inv_amt.focus();
}
function paymt_sp_combo_OnChange(comboObj, index_code, text){
    var formObj=document.form;
    formObj.paymt_sp_cd.value=comboObj.GetSelectText();
    formObj.paymt_sp_nm.value=comboObj.GetSelectCode();
}
/**
 * Calling rep_commodity pop-up
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
    var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
    ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 670, 495, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * Calling rep_commodity pop-up : The case selecting one item at pop-up page
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
    searchPaymentSP(sheetObjects[1],formObj,formObj.combo_svc_provider.value);
}
/**** AMOUNT ****/
function calAmt(){
	var formObj=document.form;
	var inv_amt=deleteComma(formObj.inv_amt.value);
	var vat_amt=deleteComma(formObj.vat_amt.value);
	var wht_amt=deleteComma(formObj.wht_amt.value);
	var tot_amt=Number(inv_amt) + Number(vat_amt) - Number(wht_amt);
	formObj.inv_amt.value=setPosition(inv_amt);
	formObj.vat_amt.value=setPosition(vat_amt);
	formObj.wht_amt.value=setPosition(wht_amt);
	formObj.tot_amt.value=setPosition(tot_amt);
	formObj.inv_amt.value=ComAddComma(formObj.inv_amt.value);
	formObj.vat_amt.value=ComAddComma(formObj.vat_amt.value);
	formObj.wht_amt.value=ComAddComma(formObj.wht_amt.value);
	formObj.tot_amt.value=ComAddComma(formObj.tot_amt.value);        
}
function initAmt(obj) {    
    if(obj.value == '0.00' || obj.value == '0'){
        obj.value='';
        obj.focus();
        return false;
    }
}
/*** disable/enable  ***/
function setDisabled(mode){
    var formObj=document.form;
    var comboObj=paymt_sp_combo;
    switch(mode){
        case 'APPLY':
            formObj.invoice_no.disabled=true;
            formObj.combo_svc_provider.disabled=true;
            formObj.apply_currency.disabled=true;
            apply_flag=true;
            comboObj.SetEnable(0);
            break;
        case 'RESET':
            formObj.invoice_no.disabled=false;
            formObj.combo_svc_provider.disabled=false;
            formObj.apply_currency.disabled=false;
            formObj.recieve_dt.disabled=false;
            formObj.issue_dt.disabled=false;
            formObj.inv_amt.disabled=false;
            formObj.vat_amt.disabled=false;
            formObj.wo_no.disabled=false;
            formObj.booking_no.disabled=false;
            formObj.bl_no.disabled=false;
            formObj.eq_no_text.disabled=false;
            formObj.eq_no_rdo[0].disabled=false;
            formObj.eq_no_rdo[1].disabled=false;
            formObj.eq_no_rdo[2].disabled=false;
            sheetObjects[0].SetEditable(1);
            sheetObjects[1].SetEditable(1);
            comboObj.SetEnable(1);
            apply_flag=false;
            break;
        case 'SEARCH_MODE':
            formObj.invoice_no.disabled=true;
            formObj.recieve_dt.disabled=true;
            formObj.issue_dt.disabled=true;
            formObj.combo_svc_provider.disabled=true;
            formObj.apply_currency.disabled=true;
            formObj.inv_amt.disabled=true;
            formObj.vat_amt.disabled=true;
            formObj.wo_no.disabled=true;
            formObj.booking_no.disabled=true;
            formObj.bl_no.disabled=true;
            formObj.eq_no_text.disabled=true;
            formObj.eq_no_rdo[0].disabled=true;
            formObj.eq_no_rdo[1].disabled=true;
            formObj.eq_no_rdo[2].disabled=true;
            sheetObjects[0].SetEditable(0);
//            sheetObjects[1].Editable = false;
            comboObj.SetEnable(0);
            break;
        case 'CONFIRM':
            formObj.invoice_no.disabled=true;
            formObj.recieve_dt.disabled=true;
            formObj.issue_dt.disabled=true;
            formObj.combo_svc_provider.disabled=true;
            formObj.apply_currency.disabled=true;
            formObj.inv_amt.disabled=true;
            formObj.vat_amt.disabled=true;
            formObj.wo_no.disabled=true;
            formObj.booking_no.disabled=true;
            formObj.bl_no.disabled=true;
            formObj.eq_no_text.disabled=true;
            formObj.eq_no_rdo[0].disabled=true;
            formObj.eq_no_rdo[1].disabled=true;
            formObj.eq_no_rdo[2].disabled=true;
            sheetObjects[0].SetEditable(0);
            sheetObjects[1].SetEditable(0);
            sheetObjects[0].RemoveAll();
            sheetObjects[1].RemoveAll();
            confirm_flag=true;
            break;
    }
}
/**** Validating invoice no ****/
function checkInvoice(){
    var sheetObj=sheetObjects[2];
    var formObj=document.form;
    if (!validateForm(sheetObj,formObj,'APPLY')) return;
    if (!getOfcCd()) return;
    formObj.f_cmd.value=SEARCH03;
    sheetObj.DoSearch("ESD_TRS_0033GS.do", TrsFrmQryString(formObj),{Sync:2} );
    if(sheetObj.RowCount()> 0){
        ComShowCodeMessage('TRS90126');
        return false;
    } else {
        setDisabled('APPLY');
        return true;
    }
}
/**** Getting Ofc cd ****/
function getOfcCd(){
    var sheetObj=sheetObjects[2];
    var formObj=document.form;
    sheetObj.RemoveEtcData();
    formObj.f_cmd.value=SEARCH10;
    var sXml=sheetObj.GetSearchData("ESD_TRS_0033GS.do", TrsFrmQryString(formObj));
    var ofc_cd=ComGetEtcData(sXml,'ofc_cd');   
    if(ofc_cd == undefined || ofc_cd == ''){
        ComShowCodeMessage('TRS90229');
        return false;
    }else{
        ofc_cd_arr=ofc_cd.split('|');
        return true;
    }
}
/**** validating office_cd ****/
function checkValidInvoiceOfficeCd(ofc_cd){
    var checkFlg=false;
    for(var i=0; i < ofc_cd_arr.length; i++){
        if(ofc_cd == ofc_cd_arr[i]) {
            checkFlg=true;
            break;
        }
    }
    if(!checkFlg) {
        ComShowCodeMessage('TRS90011');
    }
    return checkFlg;
}
/**** Resetting header ****/
function resetHeader(sheetObj,sheetObject_confirm, formObj){
    if(sheetObjects[0].RowCount() > 0 && !ComShowCodeConfirm("TRS90470")) {
        return false;
    }else if(sheetObjects[1].RowCount() > 0 && !ComShowCodeConfirm("TRS90471")) {
        return false;
    }
    setDisabled('RESET');
    var comboObj=paymt_sp_combo;
    formObj.invoice_no.value='';
    formObj.recieve_dt.value=today;
    formObj.issue_dt.value=today;
    formObj.combo_svc_provider.value='';
    formObj.svc_provider.value='';
    formObj.paymt_sp_cd.value='';
    formObj.paymt_sp_nm.value='';
    comboObj.RemoveAll();
    formObj.apply_currency.selectedIndex=selectedIdx;
    formObj.inv_amt.value='0.00';
    formObj.vat_amt.value='0.00';
    formObj.wht_amt.value='0.00';
    formObj.tot_amt.value='0.00';
    resetCondition(sheetObj,sheetObject_confirm, formObj);
    sheetObjects[0].RemoveAll();
    sheetObjects[1].RemoveAll();
    sheetObjects[2].RemoveAll();
    sheetObjects[3].RemoveAll();
    formObj.cur_sum_inv_audit.value='';
    formObj.sum_inv_tot_amt_audit.value='';
    formObj.num_eq_20_audit.value='';
    formObj.num_eq_40_audit.value='';
    formObj.num_eq_tot_audit.value='';
    formObj.cur_sum_inv.value='';
    formObj.sum_inv_tot_amt.value='';
    formObj.num_eq_20.value='';
    formObj.num_eq_40.value='';
    formObj.num_eq_tot.value='';
    tabObjects[0].SetSelectedIndex(0);
    confirm_flag=false;
	formObj.btng_currencychange.disabled = false;
}
/**** Resetting Condition ****/
function resetCondition(sheetObj,sheetObject_confirm, formObj){
    formObj.wo_no.value='';
    formObj.booking_no.value='';
    formObj.bl_no.value='';
    formObj.eq_no_text.value='';
    formObj.eq_no_rdo[0].checked=true;
    formObj.so_no.value='';
}
/**** auditing Object sheet data ****/
function sendToConfirmTab(){
    var sheetObj_auditing=sheetObjects[0];
    var sheetObj_confirm=sheetObjects[1];
    var formObj=document.form;
    var xchFlag=false;
    var checkList=sheetObj_auditing.FindCheckedRow('chk1');
    var checkArray=checkList.split('|');
    if(checkList == ''){
        ComShowCodeMessage('COM12176');
        return false;
    }
    var queryStr='';
    var colName='';
    var row=1;
    var cur=formObj.apply_currency.options[formObj.apply_currency.selectedIndex].value;
    for(var k=checkArray.length-1; k>=0; k--){
        row=checkArray[k];
        if(sheetObj_auditing.GetCellValue(row,'eq_no') == ''){
            ComShowCodeMessage('TRS90312');
            return;
        }
        if(sheetObj_auditing.GetCellValue(checkArray[0],'curr_cd') != sheetObj_auditing.GetCellValue(row,'curr_cd')){
            ComShowCodeMessage('TRS90079');
            sheetObj_auditing.SelectCell(row,'curr_cd');
            return;
        }
        if(document.form.apply_currency.value != sheetObj_auditing.GetCellValue(row,'curr_cd') &&
                sheetObj_auditing.GetCellValue(row,'inv_xch_rt') == '1' ){
            if(!xchFlag && !confirm(ComGetMsg('TRS90303'))) {
                return;
            }else{
                xchFlag=true;
            }
        }
        sheetObj_auditing.SetCellValue(row,'spcl_instr_rmk',toHtml(sheetObj_auditing.GetCellValue(row,'spcl_instr_rmk')),0);
        sheetObj_auditing.SetCellValue(row,'inter_rmk',toHtml(sheetObj_auditing.GetCellValue(row,'inter_rmk')),0);
        sheetObj_auditing.SetCellValue(row,'inv_rmk',toHtml(sheetObj_auditing.GetCellValue(row,'inv_rmk')),0);
    }
    queryStr=sheetObj_auditing.GetSaveString(false, true, "chk1");
    sheetObj_confirm.DoSearch("ESD_TRS_0969.screen", queryStr, {Sync:2,Append:true} );
    for(var k=checkArray.length-1; k >= 0; k--){
        sheetObj_auditing.RowDelete(checkArray[k], false);
    }
    setSumOfInvoiceTotalAmount(sheetObj_confirm, formObj);
    setNumOfEQ(sheetObj_confirm, formObj);
    setSumOfInvoiceTotalAmount2(sheetObj_auditing, formObj);
    setNumOfEQ2(sheetObj_auditing, formObj);
}
/**** auditing Object sheet data ****/
function sendToAuditTab(){
    var sheetObj_auditing=sheetObjects[0];
    var sheetObj_confirm=sheetObjects[1];
    var formObj=document.form;
    var checkList=sheetObj_confirm.FindCheckedRow('chk1');
    var checkArray=checkList.split('|');
    var invCurrVal = formObj.apply_currency.value;
    if(checkList == ''){
        ComShowCodeMessage('COM12176');
        return false;
    }
    var queryStr='';
    var colName='';
    queryStr=sheetObj_confirm.GetSaveString(false, true, "chk1");
    sheetObj_auditing.DoSearch("ESD_TRS_0969.screen", queryStr, {Sync:2,Append:true} );
    for(var k=checkArray.length-1; k>=0; k--){
        sheetObj_confirm.RowDelete(checkArray[k], false);
    }
    // Invoice currency, W/O currency에 따라 Exch Rate Adj. 칼럼 및 Cur. Change 버튼 활성화/비활성화
    for(var row = sheetObj_auditing.HeaderRows() + sheetObj_auditing.RowCount(); row >= sheetObj_auditing.HeaderRows(); row--){
    	if(row == 2) {
    		if(formObj.apply_currency.value == sheetObj_auditing.GetCellValue(row, 'curr_cd')) {
    			formObj.btng_currencychange.disabled = true;
    		}
    	}
        if(invCurrVal == sheetObj_auditing.GetCellValue(row, 'curr_cd') && sheetObj_auditing.GetCellValue(row, 'multi_curr_yn') == 'N') {
			sheetObj_auditing.SetCellEditable(row, 'inv_adj_bzc_amt', 0);
		} else {
			sheetObj_auditing.SetCellEditable(row, 'inv_adj_bzc_amt', 1);
		}
    }
    setSumOfInvoiceTotalAmount(sheetObj_confirm, formObj);
    setNumOfEQ(sheetObj_confirm, formObj);
    setSumOfInvoiceTotalAmount2(sheetObj_auditing, formObj);
    setNumOfEQ2(sheetObj_auditing, formObj);
    setCurrChange();
}
/**
 * Surcharge Input Inquiry popup
 **/
function popSurchargeInputInquiry_CalLogic(sheetObj, row, col, mode, step_cd)
{
    var myOption="width=950,height=805,menubar=0,status=0,scrollbars=1,resizable=0";
    var url='ESD_TRS_0918.screen';
    url += '?unique_cd='+sheetObj.GetCellValue(row, 'trsp_so_seq');
    url += '&open_mode='+mode;
    url += '&step_cd='+step_cd;
    url += '&main_row='+row;
    url += '&sheet_arr_no=3';
    url += '&ofc_cty_cd='+sheetObj.GetCellValue(row, 'trsp_so_ofc_cty_cd');
    url += '&so_seq='+sheetObj.GetCellValue(row, 'trsp_so_seq');
    url += '&rate'+sheetObj.GetCellValue(row, 'inv_xch_rt');
    url += '&cal_logic'+sheetObj.GetCellValue(row, 'trsp_inv_calc_lgc_tp_cd');
    url += '&curr_cd='+sheetObj.GetCellValue(row, 'curr_cd');
    url += '&cgo_tp_cd='+ sheetObj.GetCellValue(row, 'cgo_tp_cd');
    url += '&po_fuel_scg_rt=' + sheetObj.GetCellValue(row, 'fuel_scg_amt');
    myWin=window.open(url, "popSurchargeInputInquiry", myOption);
    myWin.focus();
}
/**
 * Surcharge Input Inquiry popup
 **/
function popSurchargeInputInquiry(sheetObj, row, col, mode, step_cd)
{
    var checkList=null;
    var checkArray=null;
    if(mode == 'multiple'){
        checkList=sheetObj.FindCheckedRow('chk1');
        checkArray=checkList.split('|');
        if( checkArray == '') {
            ComShowCodeMessage('TRS90036');
            return;
        }else{
            row=checkArray[0];
        }
    }
    var formObj=document.scgForm;
    var myOption="width=950,height=805,menubar=0,status=0,scrollbars=1,resizable=0";
    var myWin=window.open('', "popSurchargeInputInquiry", myOption);
    myWin.focus();
    formObj.unique_cd.value=sheetObj.GetCellValue(row, 'trsp_so_seq');
    formObj.open_mode.value=mode;
    formObj.step_cd.value=step_cd;
    formObj.main_row.value=row;
    formObj.sheet_arr_no.value='3';
    formObj.ofc_cty_cd.value=sheetObj.GetCellValue(row, 'trsp_so_ofc_cty_cd');
    formObj.so_seq.value=sheetObj.GetCellValue(row, 'trsp_so_seq');
    formObj.curr_cd.value=document.form.apply_currency.value;
    formObj.cgo_tp_cd.value=sheetObj.GetCellValue(row, 'cgo_tp_cd');
    formObj.action='ESD_TRS_0918.screen';
    formObj.target='popSurchargeInputInquiry';
    if(mode == 'multiple'){
        formObj.multi_ofc_cty_cd.value=getSoOfcCdArray(sheetObj, checkArray);
        formObj.multi_so_seq.value=getSoSeqArray(sheetObj, checkArray);
        formObj.multi_cgo_tp_cd.value=getCgoTpCdArray(sheetObj, checkArray);
        formObj.check_row.value=getRowArray(sheetObj, checkArray);
    }
    formObj.submit();
}
function getSoOfcCdArray(sheetObj, checkArray){
    var returnStr='';
    for(var i=0; i<checkArray.length; i++){
        if(i != 0){
            returnStr += '|';
        }
        returnStr += sheetObj.GetCellValue(checkArray[i], 'trsp_so_ofc_cty_cd');
    }
    return returnStr;
}
function getSoSeqArray(sheetObj, checkArray){
    var returnStr='';
    for(var i=0; i<checkArray.length; i++){
        if(i != 0){
            returnStr += '|';
        }
        returnStr += sheetObj.GetCellValue(checkArray[i], 'trsp_so_seq');
    }
    return returnStr;
}
function getCgoTpCdArray(sheetObj, checkArray){
    var returnStr='';
    var cgo_tp_cd='';
    for(var i=0; i<checkArray.length; i++){
        if(i != 0){
            returnStr += '|';
        }
        cgo_tp_cd=sheetObj.GetCellValue(checkArray[i], 'cgo_tp_cd');
        if (cgo_tp_cd == 'F') cgo_tp_cd='C';
        else cgo_tp_cd='M';
        returnStr += cgo_tp_cd
    }
    return returnStr;
}
function getRowArray(sheetObj, checkArray){
    var returnStr='';
    for(var i=0; i<checkArray.length; i++){
        if(i != 0){
            returnStr += '|';
        }
        returnStr += checkArray[i];
    }
    return returnStr;
}
/**
 * Container File Imort Popup 
 **/
function popCntrFileImport(sheetObj, formObj) {
    var checkList=sheetObj.FindCheckedRow('chk1');
    var checkArray=checkList.split('|');
    if( checkArray == '' || checkArray == null) {
        ComShowCodeMessage('TRS90036');
        return;
    }
    for(var i=0; i<checkArray.length; i++){
        if(sheetObj.GetCellValue(checkArray[i], 'eq_no') != ''){
            ComShowCodeMessage('TRS90469');
            return;
        }
    }
    var myOption="width=830; height=430; help:no; status:no; resizable:no; scroll=no; ";
    var url='ESD_TRS_0957.do';
    url += '?wo_vndr_cd='+formObj.combo_svc_provider.value;
    url += '&wo_vndr_nm='+formObj.svc_provider.value;
    url += '&payment_vndr_cd='+formObj.paymt_sp_cd.value;
    url += '&payment_vndr_nm='+formObj.paymt_sp_nm.value;
    url += '&invoice_no='+formObj.invoice_no.value;
    url += '&apply_currency='+formObj.apply_currency.value;
     ComOpenWindow(url,  'ESD_TRS_0957',  myOption , false);
}
/**
 * Container File Imported EQ_NO.
 **/
function importEqNo(popSheetObj, obj)
{
    var sheetObj=sheetObjects[0];
    var checkList=popSheetObj.FindCheckedRow('ibcheck');
    var checkArray=checkList.split('|');
    var main_checkList=sheetObj.FindCheckedRow('chk1');
    var main_checkArray=main_checkList.split('|');
    // Making array with the rows which doesn't have eq_no
    var emptyEqArray=new Array();
    var cnt=0;
    for(var k=0; k<main_checkArray.length; k++){
        if(sheetObj.GetCellValue(main_checkArray[k], 'eq_no')==''){
            emptyEqArray[cnt++]=main_checkArray[k];
        }
    }
    for(var k=0; k<emptyEqArray.length; k++){
        for(var m=0; m<checkArray.length; m++) {
            if(checkArray[m] != -1 &&
            sheetObj.GetCellValue(emptyEqArray[k], 'eq_tpsz_cd') ==
            popSheetObj.GetCellValue(checkArray[m], 'eq_tpsz_cd') &&
            sheetObj.GetCellValue(emptyEqArray[k], 'trsp_wo_ofc_cty_cd_seq') ==
            popSheetObj.GetCellValue(checkArray[m], 'trsp_wo_ofc_cty_cd')) {
            sheetObj.SetCellValue(emptyEqArray[k], 'eq_no',popSheetObj.GetCellValue(checkArray[m], 'eq_no'),0);
                sheetObj.SetCellValue(emptyEqArray[k], 'chk1','1',0);
                checkArray[m]=-1;
                break;
            }
        }
    }
    //obj.close();
}
/**
 * Container Select Popup
 **/
function popContainerSelect(sheetObj, formObj) {
	var checkList = sheetObj.FindCheckedRow('chk1');
	var checkArray = checkList.split('|');
	if (checkArray == '' || checkArray == null) {
		ComShowCodeMessage('TRS90036');
		return false;
	}
	for ( var i = 0; i < checkArray.length; i++) {
		if (sheetObj.GetCellValue(checkArray[i], 'trsp_bnd_cd') != 'O' || sheetObj.GetCellValue(checkArray[i], 'trsp_cost_dtl_mod_cd') != 'DR') {
			ComShowMessage('1,' + ComGetMsg('TRS90045'));
			sheetObj.SelectCell(checkArray[i], 'trsp_bnd_cd');
			return false;
		} else if (sheetObj.GetCellValue(checkArray[i], 'eq_no').length > 0) {
			ComShowMessage('2,' + ComGetMsg('TRS90045'));
			sheetObj.SelectCell(checkArray[i], 'eq_no');
			return false;
		} else if (sheetObj.GetCellValue(checkArray[i], 'bkg_no') == null || sheetObj.GetCellValue(checkArray[i], 'bkg_no') == '') {
			ComShowMessage('3,' + ComGetMsg('TRS90045'));
			sheetObj.SelectCell(checkArray[i], 'bkg_no');
			return false;
		} else if (sheetObj.GetCellValue(checkArray[i], 'trsp_frst_flg') == 'Y') {
			ComShowMessage('4,' + ComGetMsg('TRS90366'));
			sheetObj.SelectCell(checkArray[i], 'eq_no');
			return false;
		}
	}
	ComOpenWindow("ESD_TRS_0908.do?mainSheetArrayNo=0", 'ESD_TRS_0908', "width=750; height=500; help:no; status:no; resizable:no; scroll=no;", false);
}
/**
 * Empty repo Select Popup
 **/
function popMtySelect(sheetObj,formObj){
    var checkList=sheetObj.FindCheckedRow('chk1');
    var checkArray=checkList.split('|');
    var row=0;
    if( checkArray == '' || checkArray == null ) {
        ComShowCodeMessage('TRS90036');
        return;
    }
    for(var i=0; i<checkArray.length; i++){
        row=checkArray[i];
        if(sheetObj.GetCellValue(row, 'trsp_so_tp_cd') != 'M'){
            ComShowMessage('Not Empty Repo!!');
            sheetObj.SelectCell(row, 'chk1');
            return;
        } 
    }
    var kgValue='';
    var row=0;
    var myOption="width=830,height=500,menubar=0,status=0,scrollbars=0,resizable=0";
    var url='ESD_TRS_0909.do';
    url += '?mainSheetArrayNo=0';
     ComOpenWindow(url,  'ESD_TRS_0909',  myOption , false);
}
/**
 * Invoice File Import Popup 
 **/
function popInvoiceFileImport(sheetObj,formObj){
    var myOption="width=900,height=520,menubar=0,status=0,scrollbars=0,resizable=0";
    var url='ESD_TRS_0922.screen';
    url += '?wo_vndr_cd='+formObj.combo_svc_provider.value;
    url += '&wo_vndr_nm='+formObj.svc_provider.value;
    url += '&payment_vndr_cd='+formObj.paymt_sp_cd.value;
    url += '&payment_vndr_nm='+formObj.paymt_sp_nm.value;
    url += '&invoice_no='+formObj.invoice_no.value;
    url += '&apply_currency='+formObj.apply_currency.value;
    ComOpenWindow(url, 'ESD_TRS_0922', myOption, false);
}
/**
 * Removing duplicated S/O
 **/
function removeDupSoNo(auditSheetObj, beforeRow, afterRow, beforeScgRow, afterScgRow) {
	auditSheetObj.RenderSheet(0);
    var confirmSheetObj = sheetObjects[1];
    var surchargeSheetObj = sheetObjects[3];
    var findIndex = 0;
    var srcData = null;
    var tgtData = null;
    var findFlag = false;
    for(var i = auditSheetObj.RowCount() + 2; i > 1; i--) {
        srcData = auditSheetObj.GetCellValue(i, 'trsp_so_ofc_cty_cd_seq');
        for(var t = i - 1; t > 1; t--){
            tgtData = auditSheetObj.GetCellValue(t, 'trsp_so_ofc_cty_cd_seq');
            if(srcData == tgtData) {
                auditSheetObj.SetRowStatus(i, 'D');
                findFlag = true;
                break;
            }
        }
        for(var t = 2; t < confirmSheetObj.RowCount() + 2; t++) {
            tgtData = confirmSheetObj.GetCellValue(t, 'trsp_so_ofc_cty_cd_seq');
            if(srcData == tgtData) {
                auditSheetObj.SetRowStatus(i, 'D');
                findFlag = true;
                break;
            }
        }

    }

	if(findFlag) {
	    for(var i = surchargeSheetObj.RowCount() + 1; i > 0; i--) {
	    	srcData = ComTrim(surchargeSheetObj.GetCellValue(i, 'surcharge_trsp_so_ofc_cty_cd')
	    			        + surchargeSheetObj.GetCellValue(i, 'surcharge_trsp_so_seq')
	    			        + surchargeSheetObj.GetCellValue(i, 'surcharge_lgs_cost_cd')
	    			        + surchargeSheetObj.GetCellValue(i, 'surcharge_scg_dtl_seq'));
	        for(var t = i - 1; t > 0; t--) {
	            tgtData = ComTrim(surchargeSheetObj.GetCellValue(t, 'surcharge_trsp_so_ofc_cty_cd')
	            		        + surchargeSheetObj.GetCellValue(t, 'surcharge_trsp_so_seq')
	            		        + surchargeSheetObj.GetCellValue(t, 'surcharge_lgs_cost_cd')
	            		        + surchargeSheetObj.GetCellValue(t, 'surcharge_scg_dtl_seq'));
	            if(srcData == tgtData) {
	                surchargeSheetObj.SetRowStatus(i, 'D');
	            }
	        }
	    }
	}

    for(var k = Number(auditSheetObj.RowCount()) + 2; k > 1; k--) {
        if(auditSheetObj.GetRowStatus(k) == 'D') auditSheetObj.RowDelete(k, false);
    }
    for(var k = Number(confirmSheetObj.RowCount()) + 2; k > 1; k--) {
        if(confirmSheetObj.GetRowStatus(k) == 'D') confirmSheetObj.RowDelete(k, false);
    }
    for(var k = Number(surchargeSheetObj.RowCount()) + 1; k > 0; k--) {
        if(surchargeSheetObj.GetRowStatus(k) == 'D') surchargeSheetObj.RowDelete(k, false);
    }

	auditSheetObj.RenderSheet(1);
	ComOpenWait(false);
}
/**
 * Currency Change Popup 
 **/
function popCurrencyChange(sheetObj,formObj){
    var checkList=sheetObj.FindCheckedRow('chk1');
    var checkArray=checkList.split('|');
    var wo_cur=formObj.apply_currency.value;
    var wo_totamount=0;
    if( checkArray == '' || checkArray == null) {
        ComShowCodeMessage('TRS90036');
        return;
    }
    for(var i=0; i<checkArray.length; i++){
        if(sheetObj.GetCellValue(checkArray[0], 'curr_cd') != sheetObj.GetCellValue(checkArray[i], 'curr_cd')){
            ComShowCodeMessage('TRS90048');
            sheetObj.SelectCell(checkArray[i], 'curr_cd');
            return;
        }
        wo_totamount += Number(sheetObj.GetCellValue(checkArray[i], 'wo_tot_amt'));
    }
    var myOption="width=700,height=250,menubar=0,status=0,scrollbars=0,resizable=0";
    var url='ESD_TRS_0910.screen';
    url += '?wo_currency='+sheetObj.GetCellValue(checkArray[0], 'curr_cd');
    url += '&wo_totamount='+wo_totamount;
    url += '&invoice_currency='+wo_cur;
    ComOpenWindow(url, "ESD_TRS_0910", myOption,false);
}
/**
 * Currency Change Popup
 **/
function setCurrencyChange(iv_curr_value, rate_value, cal_logic_value){
    var formObj=document.form;    
    var sheetObj=sheetObjects[0];    
    var checkList=sheetObj.FindCheckedRow('chk1');
    var checkArray=checkList.split('|');
    if(rate_value > 0){ 
        for(var i=0; i < checkArray.length; i++){            
            sheetObj.SetCellValue(checkArray[i], 'inv_curr_cd', iv_curr_value, 0);
            sheetObj.SetCellValue(checkArray[i], 'inv_xch_rt', rate_value,0);
            sheetObj.SetCellValue(checkArray[i], 'trsp_inv_calc_lgc_tp_cd', cal_logic_value,0);
            calCurrencyChange(checkArray[i], sheetObj);
            if(sheetObj.GetCellValue(checkArray[i], 'inv_curr_cd') == 'JPY' || sheetObj.GetCellValue(checkArray[i], 'inv_curr_cd') == 'KRW' || sheetObj.GetCellValue(checkArray[i], 'inv_curr_cd') == 'TWD'){
                setDecimalType_Audit(sheetObj, checkArray[i]);
            } else {
                setFloatingType_Audit(sheetObj, checkArray[i]);
            }
        }
        setSumOfInvoiceTotalAmount2(sheetObj, formObj);
        setNumOfEQ2(sheetObj, formObj);
    }
}
/**
 * Currency Change Popup
 **/
function calCurrencyChange(row, sheetObj){
    var formObj=document.form;
    var url='trsp_inv_calc_lgc_tp_cd=' + sheetObj.GetCellValue(row, 'trsp_inv_calc_lgc_tp_cd');
    url +='&inv_xch_rt=' +  sheetObj.GetCellValue(row, 'inv_xch_rt');
    url +='&trsp_so_ofc_cty_cd=' +  sheetObj.GetCellValue(row, 'trsp_so_ofc_cty_cd');
    url +='&trsp_so_seq=' +  sheetObj.GetCellValue(row, 'trsp_so_seq');
    formObj.f_cmd.value=SEARCH13;
    sheetObj.RemoveEtcData();
    sheetObj.DoSearch("ESD_TRS_0033GS.do", TrsFrmQryString(formObj)+"&"+ url, {Sync:2,Append:true} );
    var inv_bzc_amt=sheetObj.GetEtcData('inv_bzc_amt');
    if(!isNaN(inv_bzc_amt)){
        sheetObj.SetCellValue(row, 'inv_bzc_amt', inv_bzc_amt, 0);
        sheetObj.SetCellValue(row, 'org_inv_bzc_amt', inv_bzc_amt, 0);
        sheetObj.SetCellValue(row, 'inv_adj_bzc_amt', 0, 0);
    }
}
/**
 * sheet cell value
 **/
function sheet1_OnChange(sheetObj, row, col, value){
    var formObject=document.form;
    var colName=sheetObj.ColSaveName(col);
    switch(colName){
        case 'fm_loc_value':
        case 'to_loc_value':
        case 'via_loc_value':
            if( sheetObj.cellValue(row, colName) != '' )
            {
                sheetObj.cellValue2(row, colName)=sheetObj.cellValue(row, colName).toUpperCase();
                getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col+1), sheetObj.cellValue(row, colName));
            }
            break;
        case 'dor_loc_value':
            if( sheetObj.cellValue(row, colName) != '' )
            {
                sheetObj.cellValue2(row, colName)=sheetObj.cellValue(row, colName).toUpperCase();
                getZoneSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col+1), sheetObj.cellValue(row, colName));
            }
            break;
            
        case 'inv_etc_add_amt' :
            if(value== '' || Number(value)==0){
                var surcharge_sheetObj=sheetObjects[3];
                var unique_cd=sheetObj.GetCellValue(row, 'surcharge_key');
                var scg_amt='';
                var cnt=0;
                 // Removing the values previously set 
                for(var a=surcharge_sheetObj.RowCount(); a>0 ;a--)
                {
                    if( surcharge_sheetObj.GetCellValue(a, prefix+'unique_cd') == unique_cd){
                    scg_amt=Number(surcharge_sheetObj.GetCellValue(a, prefix+'scg_amt'));
                        if(scg_amt == 0) {
                            surcharge_sheetObj.RowDelete(a, false);
                        }else{
                            cnt++;
                            surcharge_sheetObj.SetCellValue(a, prefix+'inv_scg_amt','',0);
                        }
                    }
                }
                if (cnt == 0) sheetObj.SetCellValue(row, 'n3pty_bil_flg','');
            }else{
                var surcharge_sheetObj=sheetObjects[3];
                var unique_cd=sheetObj.GetCellValue(row, 'surcharge_key');
                var sum=0;
                for(var a=surcharge_sheetObj.RowCount(); a>0 ;a--)
                {
                    if( surcharge_sheetObj.GetCellValue(a, prefix+'unique_cd') == unique_cd)
                        sum += Number(surcharge_sheetObj.GetCellValue(a, prefix+'inv_scg_amt'));
                }
                if(sum != Number(deleteComma(value))){
                    ComShowCodeMessage('COM12114', 'Invoice Additional Etc Amount');
                    sheetObj.SetCellValue(row, 'inv_etc_add_amt',0,0);
                    var scg_amt='';
                    for(var a=surcharge_sheetObj.RowCount(); a>0 ;a--)
                    {
                        if( surcharge_sheetObj.GetCellValue(a, prefix+'unique_cd') == unique_cd){
                            scg_amt=Number(surcharge_sheetObj.GetCellValue(a, prefix+'inv_scg_amt'));
                            if(scg_amt == 0) {
                                surcharge_sheetObj.RowDelete(a, false);
                            }else{
                                cnt++;
                                surcharge_sheetObj.SetCellValue(a, prefix+'inv_scg_amt','',0);
                            }
                        }
                    }
                    if (cnt == 0) sheetObj.SetCellValue(row, 'n3pty_bil_flg','');
                }
            }
            setSumOfInvoiceTotalAmount2(sheetObj, formObject);
            setNumOfEQ2(sheetObj, formObject);
            break;
        case('n3pty_bil_flg'):
            if(value== '' || value=='N'){
                var surcharge_sheetObj=sheetObjects[3];
                var unique_cd=sheetObj.GetCellValue(row, 'surcharge_key');
                 // Removing the values previously set 
                for(var a=1; a<surcharge_sheetObj.RowCount();a++){
                    if( surcharge_sheetObj.GetCellValue(a, prefix+'unique_cd') == unique_cd){
                        surcharge_sheetObj.SetCellValue(a, prefix+'cust_cnt_cd','',0);
                        surcharge_sheetObj.SetCellValue(a, prefix+'cust_seq','',0);
                        surcharge_sheetObj.SetCellValue(a, prefix+'n3pty_amt','',0);
                        surcharge_sheetObj.SetCellValue(a, prefix+'n3pty_vndr_seq','',0);
                        surcharge_sheetObj.SetCellValue(a, prefix+'n3pty_ofc_cd','',0);
                        surcharge_sheetObj.SetCellValue(a, prefix+'n3pty_desc','',0);
                        surcharge_sheetObj.SetCellValue(a, prefix+'n3pty_bil_flg','',0);
                        surcharge_sheetObj.SetCellValue(a, prefix+'n3pty_curr_cd','',0);
                    }
                }
            }
            break;
        case 'eq_no':
            sheetObj.SetCellValue(row,'eq_no',value.toUpperCase(),0);
            
            // 2015.04.07 CHAN WOO PARK
            // Check every row and if there is EQ_NO, compare it with ORG_EQ_NO
            // and if those two are same set 'EQ_NO' cell as non-editable
            for(var row = sheetObj.HeaderRows(); row < sheetObj.HeaderRows() + sheetObj.RowCount(); row++)
            {
            	var eq_no_tmp = sheetObj.GetCellValue(row, 'eq_no');
                var org_eq_no_tmp = sheetObj.GetCellValue(row, 'org_eq_no');
                /*
                 * compare EQ_NO and ORG_EQ_NO(Except for the null case)
                 * 1. if EQ_NO == ORG_EQ_NO
                 * 	1) set 'EQ_NO' cell as non-editable
                 *	2) set row as it is verified
                 * 2. if there is no EQ_NO(else)
                 *	1) set 'EQ_NO' cell as editable
                */
            	if ( (eq_no_tmp == org_eq_no_tmp) && eq_no_tmp != null && org_eq_no_tmp != null && eq_no_tmp != '' && org_eq_no_tmp != '') {
                	sheetObj.SetCellValue(row,'empty_eq_no_verify_check','Y',0);	// make it as verify is already processed
                } else {
            		sheetObj.SetCellEditable(row, 'eq_no', 1);
                	sheetObj.SetCellValue(row,'empty_eq_no_verify_check','N',0);
            	}
            }
            sheetObj.SetCellValue(row,'verify_result','',0);
            break;
        case 'chk1':
        case 'inv_tot_amt':
            setSumOfInvoiceTotalAmount2(sheetObj, formObject);
            setNumOfEQ2(sheetObj, formObject);
            break;
        case "inv_adj_bzc_amt" : {
        	if(value == '') {
        		sheetObj.SetCellValue(row, "inv_bzc_amt", sheetObj.GetCellValue(row, "org_inv_bzc_amt"), 0);
            	setSumOfInvoiceTotalAmount2(sheetObj, formObject);
                setNumOfEQ2(sheetObj, formObject);
        	} else {
	        	if(sheetObj.GetCellValue(row, "org_inv_bzc_amt") != '') {
	        		var invBzcAmt = parseFloat(sheetObj.GetCellValue(row, "org_inv_bzc_amt"));
	            	sheetObj.SetCellValue(row, "inv_bzc_amt", invBzcAmt +  value, 0);
	            	setSumOfInvoiceTotalAmount2(sheetObj, formObject);
	                setNumOfEQ2(sheetObj, formObject);
	        	}
        	}
        	break;
        }
    }
}
/**
 * sheet2 cell value
 **/
function sheet2_OnChange(sheetObj, row, col, value){
    var formObject=document.form;
    var colName=sheetObj.ColSaveName(col);
    switch(colName){
        case 'fm_loc_value':
        case 'to_loc_value':
        case 'via_loc_value':
        case 'dor_loc_value':
            if( sheetObj.cellValue(row, colName) != '' )
            {
                sheetObj.cellValue2(row, colName)=sheetObj.cellValue(row, colName).toUpperCase();
                getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col+1), sheetObj.cellValue(row, colName));
            }
            break;
        case 'chk1':
        case 'inv_tot_amt':
            setSumOfInvoiceTotalAmount(sheetObj, formObject);
            setNumOfEQ(sheetObj, formObject);
            break;
    }
}
/**
 * sheet click event
 **/
function sheet1_OnClick(sheetObj, row, col, value) {
    var colName=sheetObj.ColSaveName(col);
    switch(colName){
        case 'fm_yard_value':
            if( sheetObj.cellValue(row, 'fm_loc_value') != '' ){
                getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'fm_loc_value'));
            }
            break;
        case 'to_yard_value':
            if( sheetObj.cellValue(row, 'to_loc_value') != '' ){
                getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'to_loc_value'));
            }
            break;
        case 'via_yard_value':
            if( sheetObj.cellValue(row, 'via_loc_value') != '' ){
                getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'via_loc_value'));
            }
            break;
        case 'dor_yard_value':
            if( sheetObj.cellValue(row, 'dor_loc_value') != '' ){
                getZoneSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'dor_loc_value'));
            }
            break;
        case 'inter_rmk_img':
        	if( sheetObj.GetCellValue(row, "trsp_so_tp_cd") != 'M' 
           	 && sheetObj.GetCellValue(row, "trsp_so_tp_cd") != 'H'
           	 && sheetObj.GetCellValue(row, "trsp_so_tp_cd") != 'O') {
           		var lvbkg=sheetObj.GetCellValue(row, "bkg_no");
           		var lveqno=sheetObj.GetCellValue(row, "eq_no");
           		var lvsono=sheetObj.GetCellValue(row, "trsp_so_ofc_cty_cd") + sheetObj.GetCellValue(row, "trsp_so_seq");
           		var lvwono=sheetObj.GetCellValue(row, "trsp_wo_ofc_cty_cd") + sheetObj.GetCellValue(row, "trsp_wo_seq");
           		var url="ESD_TRS_0982Pop.do?bkg_no=" + lvbkg + "&eq_no=" + lveqno + "&so_no=" + lvsono + "&wo_no=" + lvwono + "&inter_rmk_cd=I";
           		ComOpenWindowCenter(url, "compopup", 1000, 570, true);
           	}
        	break;
    }
}
/**
 * sheet click event
 **/
function sheet2_OnClick(sheetObj, row, col, value)
{
    var colName=sheetObj.ColSaveName(col);
    switch(colName){
        case 'fm_yard_value':
            if( sheetObj.cellValue(row, 'fm_loc_value') != '' ){
                getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'fm_loc_value'));
            }
            break;
        case 'to_yard_value':
            if( sheetObj.cellValue(row, 'to_loc_value') != '' ){
                getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'to_loc_value'));
            }
            break;
        case 'via_yard_value':
            if( sheetObj.cellValue(row, 'via_loc_value') != '' ){
                getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'via_loc_value'));
            }
            break;
        case 'dor_yard_value':
            if( sheetObj.cellValue(row, 'dor_loc_value') != '' ){
                getZoneSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'dor_loc_value'));
            }
            break;
        case 'inter_rmk_img':
        	if( sheetObj.GetCellValue(row, "trsp_so_tp_cd") != 'M' 
           	 && sheetObj.GetCellValue(row, "trsp_so_tp_cd") != 'H'
           	 && sheetObj.GetCellValue(row, "trsp_so_tp_cd") != 'O') {
           		var lvbkg=sheetObj.GetCellValue(row, "bkg_no");
           		var lveqno=sheetObj.GetCellValue(row, "eq_no");
           		var lvsono=sheetObj.GetCellValue(row, "trsp_so_ofc_cty_cd") + sheetObj.GetCellValue(row, "trsp_so_seq");
           		var lvwono=sheetObj.GetCellValue(row, "trsp_wo_ofc_cty_cd") + sheetObj.GetCellValue(row, "trsp_wo_seq");
           		var url="ESD_TRS_0982Pop.do?bkg_no=" + lvbkg + "&eq_no=" + lveqno + "&so_no=" + lvsono + "&wo_no=" + lvwono + "&inter_rmk_cd=I";
           		ComOpenWindowCenter(url, "compopup", 1000, 570, true);
           	}
        	break;
    }
}
/**
 * Opening popup page when Additional Amount is clicked
 **/
function sheet1_OnDblClick(sheetObj, row, col){
    var colName=sheetObj.ColSaveName(col);
    switch(colName) {
        case 'etc_add_amt':
            popSurchargeInputInquiry_CalLogic(sheetObj, row, col, 'search', 'WO');
            break;
        case 'inv_etc_add_amt':
            popSurchargeInputInquiry(sheetObj, row, col, 'modify', 'IV');
            break;
    }
}
/**
 * Opening popup page when Additional Amount is clicked
 **/
function sheet2_OnDblClick(sheetObj, row, col){
    var colName=sheetObj.ColSaveName(col);
    switch(colName) {
        case 'etc_add_amt':
            popSurchargeInputInquiry_CalLogic(sheetObj, row, col, 'search', 'WO');
            break;
        case 'inv_etc_add_amt':
            popSurchargeInputInquiry(sheetObj, row, col, 'search', 'IV');
            break;
    }
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
            case 'wo_no':
            case 'booking_no':
            case 'bl_no':
            case 'so_no':
                obj.value=obj.value.toUpperCase();
                doActionIBSheet(sheetObj,formObj,IBSEARCH);
                break;
            case 'eq_no':
                checkDigit(obj);
                obj.value=obj.value.toUpperCase();
                doActionIBSheet(sheetObj,formObj,IBSEARCH);
                break;
            case 'combo_svc_provider':
                getVendorSeq(sheetObj, formObj, obj.value);
                break;
        }
    }
}
/**
 * Sum of Invoice Total Amount
 **/
function setSumOfInvoiceTotalAmount(sheetObj, formObj){
    var checkList=sheetObj.FindCheckedRow('chk1');
    var checkArray=checkList.split('|');
    var resultValue=0;
    for(var i=0; i<checkArray.length; i++){
        var invTotAmt = Number(deleteComma(sheetObj.GetCellValue(checkArray[i], 'inv_tot_amt')));
        resultValue += isNaN(Number(deleteComma(sheetObj.GetCellValue(checkArray[i], 'inv_tot_amt'))))?0:Number(deleteComma(sheetObj.GetCellValue(checkArray[i], 'inv_tot_amt')));
    }
    if(checkList==''){
        formObj.cur_sum_inv.value= "";
        formObj.sum_inv_tot_amt.value="0";
    }else{
        formObj.cur_sum_inv.value=formObj.apply_currency.options[formObj.apply_currency.selectedIndex].value;
        formObj.sum_inv_tot_amt.value=setPosition(resultValue);
        formObj.sum_inv_tot_amt.value=ComAddComma(formObj.sum_inv_tot_amt.value); // 2009-02-17 변경
    }
}
/**
 * Sum of Invoice Total Amount
 **/
function setSumOfInvoiceTotalAmount2(sheetObj, formObj){
    var checkList=sheetObj.FindCheckedRow('chk1');
    var checkArray=checkList.split('|');
    var resultValue=0;
    for(var i=0; i<checkArray.length; i++){
        resultValue += isNaN(Number(deleteComma(sheetObj.GetCellValue(checkArray[i], 'inv_tot_amt'))))?0:Number(deleteComma(sheetObj.GetCellValue(checkArray[i], 'inv_tot_amt')));
    }
    if(checkList==''){
        formObj.cur_sum_inv_audit.value= ""
        formObj.sum_inv_tot_amt_audit.value = "0";
    }else{
        formObj.cur_sum_inv_audit.value=formObj.apply_currency.options[formObj.apply_currency.selectedIndex].value;
        formObj.sum_inv_tot_amt_audit.value=setPosition(resultValue);
        formObj.sum_inv_tot_amt_audit.value=ComAddComma(formObj.sum_inv_tot_amt_audit.value); // 2009-02-17 변경
    }
}
/**
 * Number of EQ
 **/
function setNumOfEQ(sheetObj, formObj){
    var cnt_20=0;
    var cnt_40=0;
    var tp_cd='';
    var tp_size='';
    var checkList=sheetObj.FindCheckedRow('chk1');
    var checkArray=checkList.split('|');
    var resultValue=0;
    for(var i=0; i<checkArray.length; i++){
        if(sheetObj.GetCellValue(checkArray[i], 'eq_knd_cd')=='U'){
            tp_cd=sheetObj.GetCellValue(checkArray[i], 'eq_tpsz_cd');
            if(tp_cd.length == 2) tp_size=tp_cd.substr(1,2);
            else continue;
            if(tp_size == '2') cnt_20++;
            else cnt_40++;
        }
    }
    if(checkList==''){
        formObj.num_eq_20.value = "0";
        formObj.num_eq_40.value = "0";
        formObj.num_eq_tot.value= "0";
    }else{
        formObj.num_eq_20.value=cnt_20;
        formObj.num_eq_40.value=cnt_40;
        formObj.num_eq_tot.value=checkArray.length;        
    }

}
/**
 * Number of EQ
 **/
function setNumOfEQ2(sheetObj, formObj){
    var cnt_20=0;
    var cnt_40=0;
    var tp_cd='';
    var tp_size='';
    var checkList=sheetObj.FindCheckedRow('chk1');
    var checkArray=checkList.split('|');
    var resultValue=0;
    for(var i=0; i<checkArray.length; i++){
    if(sheetObj.GetCellValue(checkArray[i], 'eq_knd_cd')=='U'){
        tp_cd=sheetObj.GetCellValue(checkArray[i], 'eq_tpsz_cd');
            if(tp_cd.length == 2) tp_size=tp_cd.substr(1,2);
            else continue;
            if(tp_size == '2') cnt_20++;
            else cnt_40++;
        }
    }
    
    if(checkList==''){
        formObj.num_eq_20_audit.value = "0";
        formObj.num_eq_40_audit.value = "0";
        formObj.num_eq_tot_audit.value= "0";
    }else{
        formObj.num_eq_20_audit.value=cnt_20;
        formObj.num_eq_40_audit.value=cnt_40;
        formObj.num_eq_tot_audit.value=checkArray.length;
    }

}
function sheet1_OnPopupClick (sheetObj , row , col )
{
    var colName=sheetObj.ColSaveName(col);
    var value=sheetObj.GetCellValue(row, colName);
    switch(colName)
    {
        case('n3pty_bil_flg'):        	
            pop3rdPartyBilling(sheetObj, row, col, 'modify', 'AD');
        break;
    }
}
/**
 * Surcharge Input Inquiry popup
 **/
function pop3rdPartyBilling(sheetObj, row, col, mode, step_cd)
{
	if(sheetObj.GetCellValue(row, 'sp_kind')=='PRESET') row=row + 1;
	var myOption="width=830; height=510; help:no; status:no; resizable:no; scroll=no;";
    var url='ESD_TRS_0954.screen';
    url += '?unique_cd='+sheetObj.GetCellValue(row, 'trsp_so_seq');
    url += '&open_mode='+mode;
    url += '&step_cd='+step_cd;
    url += '&main_row='+row;
    url += '&trsp_so_ofc_cty_cd='+sheetObj.GetCellValue(row, 'trsp_so_ofc_cty_cd');
    url += '&trsp_so_seq='+sheetObj.GetCellValue(row, 'trsp_so_seq');
    url += '&sheet_arr_no=3';
    url += '&bkg_no='+sheetObj.GetCellValue(row, 'bkg_no');
    url += '&eq_no='+sheetObj.GetCellValue(row, 'eq_no');
    url += '&wo_no='+sheetObj.GetCellValue(row, 'trsp_wo_ofc_cty_cd')+sheetObj.GetCellValue(row, 'trsp_wo_seq');
    url += '&curr_cd='+document.form.apply_currency.value;
    ComOpenPopup(url, 1000, 540, "pop3rdPartyBilling", "none", true);
}
/**
 * Invoice reject
 **/
function rejectInvoice(sheetObj, formObj){
    if(sheetObj.RowCount()< 1) return;
    if(sheetObj.GetCellValue(1, 'if_sys_knd_cd') != 'W') {
        ComShowCodeMessage('TRS90241');
        return;
    }
    formObj.f_cmd.value=SEARCH11;
     sheetObj.DoSearch("ESD_TRS_0033GS.do", TrsFrmQryString(formObj),{Sync:2,Append:true} );
}
/**
 * 
    * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
 */
function sheet3_OnSearchEnd(sheetObj, errMsg) {
    var formObj=document.form;
    if( errMsg != null && errMsg != 0 && errMsg != -1) {
        ComShowMessage(errMsg);
    }else{
        if(formObj.f_cmd.value == SEARCH11){
            ComShowCodeMessage('TRS90240');
            sheetObjects[0].RemoveAll();
            sheetObjects[1].RemoveAll();
            resetHeader(sheetObjects[0], sheetObjects[1], formObj);
        }
    }
}

// 
function setPosition(amt){
    if (document.form.apply_currency.value == 'JPY' || document.form.apply_currency.value == 'KRW' || document.form.apply_currency.value == 'TWD'){
        amt=chkAmtPos_JPY(amt);
    }else{
        amt=chkAmtPos(amt);
    }
    return amt;
}

// 
function setCurrChange(){
    var sheetObj_Audit=sheetObjects[0];
    var sheetObj_Confirm=sheetObjects[1];
    var formObj=document.form;
    if(formObj.apply_currency.value == 'JPY' || formObj.apply_currency.value == 'KRW' || formObj.apply_currency.value == 'TWD'){
        for(var i=2; i<sheetObj_Audit.RowCount()+2; i++){
            setDecimalType_Audit(sheetObj_Audit, i);
        }
        for(var i=2; i<sheetObj_Confirm.RowCount()+2; i++){
            setDecimalType_Confirm(sheetObj_Confirm, i);
        }
    }else{
        for(var i=2; i<sheetObj_Audit.RowCount()+2; i++){
            setFloatingType_Audit(sheetObj_Audit, i);
        }
        for(var i=2; i<sheetObj_Confirm.RowCount()+2; i++){
            setFloatingType_Confirm(sheetObj_Confirm, i);
        }
    }
    calAmt();
    setSumOfInvoiceTotalAmount(sheetObj_Confirm, formObj);
}

// 
function setDecimalType_Audit(sheetObj, row){
    sheetObj.InitCellProperty(row, 'bzc_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.InitCellProperty(row, 'nego_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.InitCellProperty(row, 'fuel_scg_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.InitCellProperty(row, 'etc_add_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.InitCellProperty(row, 'wo_tot_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.InitCellProperty(row, 'inv_bzc_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.InitCellProperty(row, 'inv_etc_add_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.InitCellProperty(row, 'inv_tot_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.SetCellValue(row, 'bzc_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'bzc_amt')),0);
    sheetObj.SetCellValue(row, 'nego_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'nego_amt')),0);
    sheetObj.SetCellValue(row, 'fuel_scg_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'fuel_scg_amt')),0);
    sheetObj.SetCellValue(row, 'etc_add_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'etc_add_amt')),0);
    sheetObj.SetCellValue(row, 'wo_tot_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'wo_tot_amt')),0);
    sheetObj.SetCellValue(row, 'inv_bzc_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'inv_bzc_amt')),0);
    sheetObj.SetCellValue(row, 'inv_etc_add_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'inv_etc_add_amt')),0);
    sheetObj.SetCellValue(row, 'inv_tot_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'inv_tot_amt')),0);
}

function setFloatingType_Audit(sheetObj, row){
    sheetObj.InitCellProperty(row, 'bzc_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.InitCellProperty(row, 'nego_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.InitCellProperty(row, 'fuel_scg_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.InitCellProperty(row, 'etc_add_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.InitCellProperty(row, 'wo_tot_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.InitCellProperty(row, 'inv_bzc_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.InitCellProperty(row, 'inv_etc_add_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.InitCellProperty(row, 'inv_tot_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.SetCellValue(row, 'bzc_amt',chkAmtPos(sheetObj.GetCellValue(row, 'bzc_amt')),0);
    sheetObj.SetCellValue(row, 'nego_amt',chkAmtPos(sheetObj.GetCellValue(row, 'nego_amt')),0);
    sheetObj.SetCellValue(row, 'fuel_scg_amt',chkAmtPos(sheetObj.GetCellValue(row, 'fuel_scg_amt')),0);
    sheetObj.SetCellValue(row, 'etc_add_amt',chkAmtPos(sheetObj.GetCellValue(row, 'etc_add_amt')),0);
    sheetObj.SetCellValue(row, 'wo_tot_amt',chkAmtPos(sheetObj.GetCellValue(row, 'wo_tot_amt')),0);
    sheetObj.SetCellValue(row, 'inv_bzc_amt',chkAmtPos(sheetObj.GetCellValue(row, 'inv_bzc_amt')),0);
    sheetObj.SetCellValue(row, 'inv_etc_add_amt',chkAmtPos(sheetObj.GetCellValue(row, 'inv_etc_add_amt')),0);
    sheetObj.SetCellValue(row, 'inv_tot_amt',chkAmtPos(sheetObj.GetCellValue(row, 'inv_tot_amt')),0);
}

// 
function setDecimalType_Confirm(sheetObj, row){
    sheetObj.InitCellProperty(row, 'bzc_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.InitCellProperty(row, 'nego_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.InitCellProperty(row, 'fuel_scg_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.InitCellProperty(row, 'etc_add_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.InitCellProperty(row, 'wo_tot_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.InitCellProperty(row, 'inv_bzc_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.InitCellProperty(row, 'inv_etc_add_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.InitCellProperty(row, 'inv_tot_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.SetCellValue(row, 'bzc_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'bzc_amt')),0);
    sheetObj.SetCellValue(row, 'nego_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'nego_amt')),0);
    sheetObj.SetCellValue(row, 'fuel_scg_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'fuel_scg_amt')),0);
    sheetObj.SetCellValue(row, 'etc_add_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'etc_add_amt')),0);
    sheetObj.SetCellValue(row, 'wo_tot_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'wo_tot_amt')),0);
    sheetObj.SetCellValue(row, 'inv_bzc_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'inv_bzc_amt')),0);
    sheetObj.SetCellValue(row, 'inv_etc_add_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'inv_etc_add_amt')),0);
    sheetObj.SetCellValue(row, 'inv_tot_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'inv_tot_amt')),0);
}

// 
function setFloatingType_Confirm(sheetObj, row){
    sheetObj.InitCellProperty(row, 'bzc_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.InitCellProperty(row, 'nego_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.InitCellProperty(row, 'fuel_scg_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.InitCellProperty(row, 'etc_add_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.InitCellProperty(row, 'wo_tot_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.InitCellProperty(row, 'inv_bzc_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.InitCellProperty(row, 'inv_etc_add_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.InitCellProperty(row, 'inv_tot_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.SetCellValue(row, 'bzc_amt',chkAmtPos(sheetObj.GetCellValue(row, 'bzc_amt')),0);
    sheetObj.SetCellValue(row, 'nego_amt',chkAmtPos(sheetObj.GetCellValue(row, 'nego_amt')),0);
    sheetObj.SetCellValue(row, 'fuel_scg_amt',chkAmtPos(sheetObj.GetCellValue(row, 'fuel_scg_amt')),0);
    sheetObj.SetCellValue(row, 'etc_add_amt',chkAmtPos(sheetObj.GetCellValue(row, 'etc_add_amt')),0);
    sheetObj.SetCellValue(row, 'wo_tot_amt',chkAmtPos(sheetObj.GetCellValue(row, 'wo_tot_amt')),0);
    sheetObj.SetCellValue(row, 'inv_bzc_amt',chkAmtPos(sheetObj.GetCellValue(row, 'inv_bzc_amt')),0);
    sheetObj.SetCellValue(row, 'inv_etc_add_amt',chkAmtPos(sheetObj.GetCellValue(row, 'inv_etc_add_amt')),0);
    sheetObj.SetCellValue(row, 'inv_tot_amt',chkAmtPos(sheetObj.GetCellValue(row, 'inv_tot_amt')),0);
}

// 
function checkDigit(obj)
{
    var formObj=document.form;
    if (obj == undefined)
    {
        obj=formObj.eq_no_text;
    }
    obj.value=obj.value.toUpperCase();
    if(formObj.eq_no_rdo[0].checked)
    {
        obj.value=multiCntrChkDgt(obj.value);
    }
}

// Verify
function verifyEqNo(sheetObj, formObj) {
    var checkList=sheetObj.FindCheckedRow('chk1');
    var checkArray=checkList.split('|');
    var returnFlag=false;
    var query='';
    var row=0;
    var verifyArray=new Array();
    var cnt=0;
    var vCnt=0;
    for(var i=0; i<checkArray.length; i++) {
    	query = '';
        row=checkArray[i];
        if(sheetObj.GetCellValue(row, 'eq_no') == '') {
            ComShowCodeMessage('TRS90415');
            return false;
        } else if(sheetObj.GetCellValue(row, 'eq_no') == sheetObj.GetCellValue(row, 'org_eq_no')) {
            continue;
        } else if(sheetObj.GetCellValue(row,'empty_eq_no_verify_check') == 'Y') {
            continue;
        } else {
            query    += '&ibflag=S';
            query    += '&eq_no='+sheetObj.GetCellValue(row, 'eq_no');
            query    += '&cre_dt='+sheetObj.GetCellValue(row, 'cre_dt')+sheetObj.GetCellValue(row, 'cre_tm');
            query    += '&fm_nod_cd='+sheetObj.GetCellValue(row, 'fm_loc_value')+sheetObj.GetCellValue(row, 'fm_yard_value');
            query    += '&to_nod_cd='+sheetObj.GetCellValue(row, 'to_loc_value')+sheetObj.GetCellValue(row, 'to_yard_value');
            query    += '&ref_id='+sheetObj.GetCellValue(row, 'ref_id');
            query    += '&ref_seq='+ row;
            query    += '&trsp_cost_dtl_mod_cd=' +sheetObj.GetCellValue(row, 'trsp_cost_dtl_mod_cd');
            formObj.f_cmd.value=SEARCH16;
            sheetObj.DoRowSearch(row, "ESD_TRS_0033_01GS.do", TrsFrmQryString(formObj) + query, {Sync:2});
            if( sheetObj.GetCellValue(row, 'verify_result') != '' ) {
                sheetObj.SelectCell(row, 'verify_result');
                sheetObj.SetCellValue(row, 'empty_eq_no_verify_check', 'N');
            } else {
            	sheetObj.SetCellValue(row, 'verify_result', 'OK', 0);
            	sheetObj.SetCellValue(row, 'empty_eq_no_verify_check', 'Y');
            }
        }
    }
}

function checkEmptyEqNo(sheetObj) {
    var checkList=sheetObj.FindCheckedRow('chk1');
    var checkArray=checkList.split('|');
    var row=0;
    for(var i=0; i<checkArray.length; i++){
        row=checkArray[i];
        if(sheetObj.GetCellValue(row, 'eq_no') == ''){
            return false;
        }else if(sheetObj.GetCellValue(row, 'eq_no') == sheetObj.GetCellValue(row, 'org_eq_no')){
            continue;
        }else if(sheetObj.GetCellValue(row, 'empty_eq_no_verify_check') == 'Y'){
            continue;
        }else{
            ComShowMessage('Please verify first!!');
            sheetObj.SelectCell(row, 'eq_no');
            return false;
        }
    }
    return true;
}

// 
function checkDupEqNoANDWoNo()
{
    var audit_sheetObj=sheetObjects[0];
    var confirm_sheetObj=sheetObjects[1];
    var checkList=audit_sheetObj.FindCheckedRow('chk1');
    var checkArray=checkList.split('|');
    var src_wono='';
    var src_eqno='';
    var src_row=0;
    var tgt_row=0;
    for(var i=0; i<checkArray.length; i++){
        src_row=checkArray[i];
        src_wono=audit_sheetObj.GetCellValue(src_row, 'trsp_wo_ofc_cty_cd_seq');
        src_eqno=audit_sheetObj.GetCellValue(src_row, 'eq_no');
        for(var k=i+1; k<checkArray.length; k++){
            tgt_row=checkArray[k];
            if(src_wono == audit_sheetObj.GetCellValue(tgt_row, 'trsp_wo_ofc_cty_cd_seq')
                    && src_eqno == audit_sheetObj.GetCellValue(tgt_row, 'eq_no') ){
                ComShowMessage('Duplicated  CNTR w/ Auditing Sheet');
                audit_sheetObj.SelectCell(tgt_row, 'eq_no');
                return false;
            }
        }
    }
    for(var i=0; i<checkArray.length; i++){
        src_row=checkArray[i];
        src_wono=audit_sheetObj.GetCellValue(src_row, 'trsp_wo_ofc_cty_cd_seq');
        src_eqno=audit_sheetObj.GetCellValue(src_row, 'eq_no');
        for(var k=2; k<confirm_sheetObj.RowCount()+2; k++){
            tgt_row=k;
            if(src_wono == confirm_sheetObj.GetCellValue(tgt_row, 'trsp_wo_ofc_cty_cd_seq')
                    && src_eqno == confirm_sheetObj.GetCellValue(tgt_row, 'eq_no') ){
                ComShowMessage('Duplicated  CNTR w/ Confirm Sheet');
                audit_sheetObj.SelectCell(src_row, 'eq_no');
                return false;
            }
        }
    }
    return true;
}

/*
 * check format of Issue Date/Receive Date
 * format : yyyymmdd 
 */
function checkDate(obj) {
	if(obj.value !="" && !ComIsDate(obj.value)) {
		ComShowCodeMessage("COM12187", "yyyymmdd");
		obj.focus();
	}
}