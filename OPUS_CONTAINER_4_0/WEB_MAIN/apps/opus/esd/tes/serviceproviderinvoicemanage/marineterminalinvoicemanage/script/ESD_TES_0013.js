/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_0013.js
*@FileTitle : Marine Terminal Invoice
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================*/
/**
 * @extends Tes
 * @class ESD_TES_0013 : business script for  Invoice Summary
 */
// global variable
var sheetObjects = new Array();
var parmObj = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/**
 * Event handler processing by button name
 * @return
 */
function processButtonClick() {
    /***** using extra sheet valuable if there are more 2 sheets *****/
    var sheetObject = sheetObjects[0];
    /*******************************************************/
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        switch (srcName) {
            case "btn_retrieve":
                retrieve();
                break;
                
            case "btn_new":
//                try {
//                    tes_removeTESCommonALLIframes();                    
//                } catch (e) {}
                pre_ret_cond_val = '';
                formObject.reset();
                sheetObject.RemoveAll();
                
                var rtnVal = getDBDate();    // tes_getInputValue('DB_DATE', SEARCH06, '', 'setPeriodFromTo');
	            if(rtnVal.length > 0){
	            	setPeriodFromTo(rtnVal);
	            }
                break;
                
            case "btns_calendar1":
                var cal = new ComCalendar();
                cal.select(formObject.fm_prd_dt, 'yyyy-MM-dd');
                break;
                
            case "btns_calendar2":
                var cal = new ComCalendar();
                cal.select(formObject.to_prd_dt, 'yyyy-MM-dd');
                break;
                
            case "btn_yard":
                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                var classId = "COM_ENS_061";
                var param = '?classId=' + classId;
                var chkStr = dispaly.substring(0, 3)
                    // radio PopUp
                if (chkStr == "1,0") {
                    ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 770, 520, 'getYard', dispaly);
                } else {
                    ComShowCodeMessage('TES21906');
                    return;
                }
                break;
                
            case "btn_vndr":
                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                var classId = "COM_ENS_0C1";
                var param = '?classId=' + classId;
                var chkStr = dispaly.substring(0, 3)
                    // radio PopUp
                if (chkStr == "1,0") {
                    ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 770, 520, 'getVender', dispaly);
                } else {
                    ComShowCodeMessage('TES21906');
                    return;
                }
                break;
                
            case "btn_cost_ofc_cd":
                var formObject = document.form;
                var cmdt_cd_val = "";
                var rep_cmdt_cd_val = "";
                var cmdt_desc_val = "";
                var classId = "getCOM_ENS_ofc";
                var xx1 = ""; //CONTI
                var xx2 = ""; //SUB CONTI
                var xx3 = ""; //COUNTRY
                var xx4 = ""; //STATE
                var xx5 = ""; //CONTROL OFFIC
                var xx6 = ""; //LOC CODE
                var xx7 = ""; //LOC NAME
                var xx8 = "";
                var xx9 = "";
                var param = "?conti_cd=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
                ComOpenPopup('/opuscntr/COM_ENS_071.do' + param, 770, 500, 'getCostOfc', '1,0,1,1,1,1,1,1,1,1,1,1', true);
                break;
                
            case "btn_inv_ofc_cd":
                var formObject = document.form;
                var cmdt_cd_val = "";
                var rep_cmdt_cd_val = "";
                var cmdt_desc_val = "";
                var classId = "getCOM_ENS_ofc";
                var xx1 = ""; //CONTI
                var xx2 = ""; //SUB CONTI
                var xx3 = ""; //COUNTRY
                var xx4 = ""; //STATE
                var xx5 = ""; //CONTROL OFFIC
                var xx6 = ""; //LOC CODE
                var xx7 = ""; //LOC NAME
                var xx8 = "";
                var xx9 = "";
                var param = "?conti_cd=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
                ComOpenPopup('/opuscntr/COM_ENS_071.do' + param, 770, 500, 'getInvOfc', '1,0,1,1,1,1,1,1,1,1,1,1', true);
                break;
                
            case "btng_print":
                if (sheetObject.RowCount() < 1) {
                    ComShowCodeMessage('TES21905');
                    return false
                } else {
                    printInvoiceSummary();
                }
                break;
                
            case "btng_toinvcorrection":
                var inv_no = sheetObject.GetCellValue(sheetObject.GetSelectRow(), 'inv_no');
                var vndr_seq = sheetObject.GetCellValue(sheetObject.GetSelectRow(), 'vndr_seq');
                var tml_inv_tp_cd = sheetObject.GetCellValue(sheetObject.GetSelectRow(), 'tml_inv_tp_cd');
                var tml_inv_sts_cd = sheetObject.GetCellValue(sheetObject.GetSelectRow(), 'tml_inv_sts_cd');
                var tml_inv_rjct_sts_cd = sheetObject.GetCellValue(sheetObject.GetSelectRow(), 'tml_inv_rjct_sts_cd');
                var formObj = document.form;

                if (inv_no == null || vndr_seq == null) {
                    ComShowCodeMessage('TES21907'); //showErrMessage("NO Row Selected");
                }
                if (checkValidOFC(sheetObject.GetCellValue(sheetObject.GetSelectRow(), 'inv_ofc_cd')) == false) {
                    return false;
                }
                if (tml_inv_sts_cd == 'AR') {
                    ComShowCodeMessage('TES21507', 'Approval Requested Invoice!');
                    return false;
                } else if (tml_inv_sts_cd == 'AP') {
                    ComShowCodeMessage('TES21507', 'AP Interfaced Invoice!');
                    return false;
                } else if (tml_inv_sts_cd == 'PD') {
                    ComShowCodeMessage('TES21507', 'Paid Invoice !');
                    return false;
                }
                if (sheetObject.GetCellValue(sheetObject.GetSelectRow(), 'inv_ofc_del_flg') == 'Y') {
                    ComShowMessage('The Invoice Office Code was deleted by MDM. Please contact with MDM.');
                    return false;
                } else if (sheetObject.GetCellValue(sheetObject.GetSelectRow(), 'cost_ofc_del_flg') == 'Y') {
                    ComShowMessage('The Cost Office Code was deleted by MDM. Please contact with MDM.');
                    return false;
                } else if (sheetObject.GetCellValue(sheetObject.GetSelectRow(), 'yc_del_flg') == 'Y') {
                    ComShowMessage('The Yard Code was deleted by MDM. Please contact with MDM.');
                    return false;
                } else if (sheetObject.GetCellValue(sheetObject.GetSelectRow(), 'vndr_del_flg') == 'Y') {
                    ComShowMessage('The S/P Code was deleted by MDM. Please contact with MDM.');
                    return false;
                }

                if (tml_inv_rjct_sts_cd == 'RJ') {
                    ComShowCodeMessage('TES21507', 'Rejected Invoice!');
                    return false;
                }

                if (tml_inv_tp_cd == 'TM' || tml_inv_tp_cd.substring(0, 1) == 'M') {
                    location.href = "ESD_TES_0001.do?pgmNo=ESD_TES_0001&parentPgmNo=ESD_TES_M001&inv_no=" + encodeURIComponent(inv_no) + "&vndr_seq=" + vndr_seq + ((pre_ret_cond_val != null & pre_ret_cond_val.trim() != '' ? '&' : '') + pre_ret_cond_val) + '&sysCommUiTitle=Marine Terminal Invoice Creaion %26 Correction&sysCommUiNavigation=Service Delivery > TML S/O > Invoice > Invoice Creation';
                } else if (tml_inv_tp_cd == 'ON') {
                    location.href = "ESD_TES_0064.do?pgmNo=ESD_TES_0064&parentPgmNo=ESD_TES_M001&inv_no=" + encodeURIComponent(inv_no) + "&vndr_seq=" + vndr_seq + ((pre_ret_cond_val != null & pre_ret_cond_val.trim() != '' ? '&' : '') + pre_ret_cond_val) + '&sysCommUiTitle=On-Dock Rail Charge Invoice Creation %26 Correction&sysCommUiNavigation=Service Delivery > TML S/O > Invoice > Invoice Creation';
                } else if (tml_inv_tp_cd == 'OF') {
                    location.href = "ESD_TES_0004.do?pgmNo=ESD_TES_0004&parentPgmNo=ESD_TES_M001&inv_no=" + encodeURIComponent(inv_no) + "&vndr_seq=" + vndr_seq + ((pre_ret_cond_val != null & pre_ret_cond_val.trim() != '' ? '&' : '') + pre_ret_cond_val) + '&sysCommUiTitle=Off Dock CY Invoice Creation %26 Correction&sysCommUiNavigation=TML S/O > Invoice > Invoice Creation';
                } else if (tml_inv_tp_cd == 'ST' || tml_inv_tp_cd.substring(0, 1) == 'S') {
                    location.href = "ESD_TES_0009.do?pgmNo=ESD_TES_0009&parentPgmNo=ESD_TES_M001&inv_no=" + encodeURIComponent(inv_no) + "&vndr_seq=" + vndr_seq + ((pre_ret_cond_val != null & pre_ret_cond_val.trim() != '' ? '&' : '') + pre_ret_cond_val) + '&sysCommUiTitle=Marine Terminal Storage Invoice Creation %26 Correction&sysCommUiNavigation=Service Delivery > TML S/O > Invoice > Invoice Creation';
                }
                break;
                
            case "btng_cntrlist":
                var inv_no = sheetObject.GetCellValue(sheetObject.GetSelectRow(), 'inv_no');
                var vndr_seq = sheetObject.GetCellValue(sheetObject.GetSelectRow(), 'vndr_seq');
                var tml_inv_tp_cd = sheetObject.GetCellValue(sheetObject.GetSelectRow(), 'tml_inv_tp_cd');
                
                if (inv_no == null || vndr_seq == null) {
                    ComShowMessage("NO Row Selected");
                }
                
                var strYdCd = sheetObjects[0].GetCellValue(sheetObject.GetSelectRow(), "yd_cd");
                document.form.no_ofc_cd.value = sheetObjects[0].GetCellValue(sheetObject.GetSelectRow(), "inv_ofc_cd");
                document.form.no_yd_cd.value = strYdCd;
                
                //로그인 유저가 US, CA 인 경우 오피스 체크를 하지 않는다. 2016-03-03 by 김용진
                var strCntCd = document.form.cntCd.value ;
                
                if((strCntCd == "US" && strYdCd.substring(0,2) == "US") || (strCntCd == "CA" && strYdCd.substring(0,2) == "CA" )){
                	if (tml_inv_tp_cd == 'TM') {
			            location.href = "ESD_TES_0017.do?pgmNo=ESD_TES_0017&parentPgmNo=ESD_TES_M001&inv_no=" + encodeURIComponent(inv_no) + "&vndr_seq=" + vndr_seq + '&sysCommUiTitle=Marine Terminal Container List&sysCommUiNavigation=TML S/O > Invoice > Container List Inquiry';
			        } else if (tml_inv_tp_cd == 'ON') {
			            location.href = "ESD_TES_0068.do?pgmNo=ESD_TES_0068&parentPgmNo=ESD_TES_M001&inv_no=" + encodeURIComponent(inv_no) + "&vndr_seq=" + vndr_seq + '&sysCommUiTitle=On-Dock Rail Charge Container List&sysCommUiNavigation=TML S/O > Invoice > Container List Inquiry';
			        } else if (tml_inv_tp_cd == 'OF') {
			            location.href = "ESD_TES_0018.do?pgmNo=ESD_TES_0018&parentPgmNo=ESD_TES_M001&inv_no=" + encodeURIComponent(inv_no) + "&vndr_seq=" + vndr_seq + '&sysCommUiTitle=Off-Dock CY Container List&sysCommUiNavigation=TML S/O > Invoice > Container List Inquiry';
			        } else if (tml_inv_tp_cd == 'ST') {
			            location.href = "ESD_TES_0019.do?pgmNo=ESD_TES_0019&parentPgmNo=ESD_TES_M001&inv_no=" + encodeURIComponent(inv_no) + "&vndr_seq=" + vndr_seq + '&sysCommUiTitle=Marine Terminal Storage Container List&sysCommUiNavigation=TML S/O > Invoice > Container List Inquiry';
			        }
                } else {
                	var rtnValue = getAuthOfcCd();      // tes_getInputValue('auth_ofc_cd', SEARCHLIST07, 'no_ofc_cd|cre_ofc_cd|act_tp|no_yd_cd', 'goCntrList');
	                if(rtnValue.length > 0){
	                	goCntrList(rtnValue);
	                }     
                }
                break;
                
            case "btng_rejectlift":
                if (checkValidOFC(sheetObject.GetCellValue(sheetObject.GetSelectRow(), 'inv_ofc_cd')) == false) {
                    return false;
                }
                if (sheetObject.GetCellValue(sheetObject.GetSelectRow(), "tml_inv_rjct_sts_cd") != 'RJ') {
                    ComShowMessage(ComGetMsg('TES40020'));
                    return false;
                }
                if (sheetObject.GetCellValue(sheetObject.GetSelectRow(), "tml_inv_sts_cd") == 'AP') {
                    ComShowMessage('AP Interfaced!');
                    return false;
                } else if (sheetObject.GetCellValue(sheetObject.GetSelectRow(), "tml_inv_sts_cd") == 'PD') {
                    ComShowMessage('Payed Invoice!');
                    return false;
                } else if (sheetObject.GetCellValue(sheetObject.GetSelectRow(), "tml_inv_sts_cd") == 'AR') {
                    ComShowMessage('Approval Requested!');
                    return false;
                }
                sheetObject.SetCellValue(sheetObject.GetSelectRow(), "tml_inv_rjct_sts_cd", 'RL');
                doActionIBSheet(sheetObject, formObject, IBSAVE);
                break;
                
            case "btng_delete":
                if (checkValidOFC(sheetObject.GetCellValue(sheetObject.GetSelectRow(), 'inv_ofc_cd')) == false) {
                    return false;
                }
                if (sheetObject.GetCellValue(sheetObject.GetSelectRow(), "tml_inv_sts_cd") == 'AR') {
                    ComShowCodeMessage('TES40034', 'Approval Requested.');
                    return false;
                } else if (sheetObject.GetCellValue(sheetObject.GetSelectRow(), "tml_inv_sts_cd") == 'AP') {
                    ComShowCodeMessage('TES40034', 'AP Interfaced.');
                    return false;
                } else if (sheetObject.GetCellValue(sheetObject.GetSelectRow(), "tml_inv_sts_cd") == 'PD') {
                    ComShowCodeMessage('TES40034', 'Payed Status.');
                    return false;
                }
                if (sheetObject.GetCellValue(sheetObject.GetSelectRow(), "tml_inv_rjct_sts_cd") == 'RJ') {
                    ComShowCodeMessage('TES40034', 'Rejected invoice.');
                    return false;
                }

                if (ComShowConfirm("Are you Sure?")) {
                    sheetObject.SetRowStatus(sheetObject.GetSelectRow(), 'U');
                    doActionIBSheet(sheetObject, formObject, IBDELETE);
                    sheetObject.RowDelete(sheetObject.GetSelectRow(), false);
                }
                break;
                
            case "btng_downexcel":
                doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
                break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowCodeMessage('TES21506');
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * get Previous Retreive Condition
 * @return 
 */
function getPreviousRetreiveCondition() {
    var retval = '';
    if (document.form.inv_no.value != null && document.form.inv_no.value.trim() != '') {
        retval += (retval != null && retval.trim() != '' ? '&' : '') + "pre_cond_inv_no=" + encodeURIComponent(document.form.inv_no.value);
    }
    if (document.form.inv_date_type != undefined && document.form.inv_date_type.value != null && document.form.inv_date_type.value.trim() != '') {
        retval += (retval != null && retval.trim() != '' ? '&' : '') + "pre_cond_inv_date_type=" + document.form.inv_date_type.value;
    }
    if (document.form.fm_prd_dt != undefined && document.form.fm_prd_dt.value != null && document.form.fm_prd_dt.value.trim() != '') {
        retval += (retval != null && retval.trim() != '' ? '&' : '') + "pre_cond_fm_prd_dt=" + document.form.fm_prd_dt.value;
    }
    if (document.form.to_prd_dt != undefined && document.form.to_prd_dt.value != null && document.form.to_prd_dt.value.trim() != '') {
        retval += (retval != null && retval.trim() != '' ? '&' : '') + "pre_cond_to_prd_dt=" + document.form.to_prd_dt.value;
    }
    if (document.form.yd_cd != undefined && document.form.yd_cd.value != null && document.form.yd_cd.value.trim() != '') {
        retval += (retval != null && retval.trim() != '' ? '&' : '') + "pre_cond_yd_cd=" + document.form.yd_cd.value;
    }
    if (document.form.vndr_seq != undefined && document.form.vndr_seq.value != null && document.form.vndr_seq.value.trim() != '') {
        retval += (retval != null && retval.trim() != '' ? '&' : '') + "pre_cond_vndr_seq=" + document.form.vndr_seq.value;
    }
    if (document.form.cost_ofc_cd != undefined && document.form.cost_ofc_cd.value != null && document.form.cost_ofc_cd.value.trim() != '') {
        retval += (retval != null && retval.trim() != '' ? '&' : '') + "pre_cond_cost_ofc_cd=" + document.form.cost_ofc_cd.value;
    }
    if (document.form.inv_ofc_cd != undefined && document.form.inv_ofc_cd.value != null && document.form.inv_ofc_cd.value.trim() != '') {
        retval += (retval != null && retval.trim() != '' ? '&' : '') + "pre_cond_inv_ofc_cd=" + document.form.inv_ofc_cd.value;
    }
    if (document.form.tml_inv_sts_cd != undefined && document.form.tml_inv_sts_cd.value != null && document.form.tml_inv_sts_cd.value.trim() != '') {
        retval += (retval != null && retval.trim() != '' ? '&' : '') + "pre_cond_tml_inv_sts_cd=" + document.form.tml_inv_sts_cd.value;
    }
    if (document.form.csr_no != undefined && document.form.csr_no.value != null && document.form.csr_no.value.trim() != '') {
        retval += (retval != null && retval.trim() != '' ? '&' : '') + "pre_cond_csr_no=" + document.form.csr_no.value;
    }
    if (document.form.csr_status != undefined && document.form.csr_status.value != null && document.form.csr_status.value.trim() != '') {
        retval += (retval != null && retval.trim() != '' ? '&' : '') + "pre_cond_csr_status=" + document.form.csr_status.value;
    }
    if (document.form.tml_inv_rjct_sts_cd != undefined && document.form.tml_inv_rjct_sts_cd.value != null && document.form.tml_inv_rjct_sts_cd.value.trim() != '') {
        retval += (retval != null && retval.trim() != '' ? '&' : '') + "pre_cond_tml_inv_rjct_sts_cd=" + document.form.tml_inv_rjct_sts_cd.value;
    }
    return retval;
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param(ibsheet) sheet IBSheet Object
 * @return
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 * @return
 */
function loadPage() {
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    if (!(document.form.pre_cond_fm_prd_dt.value != null && document.form.pre_cond_fm_prd_dt.value.trim() != '' && document.form.pre_cond_to_prd_dt.value != null && document.form.pre_cond_to_prd_dt.value.trim() != '')) {
        var rtnVal = getDBDate();    // tes_getInputValue('DB_DATE', SEARCH06, '', 'setPeriodFromTo');
        if(rtnVal.length > 0){
        	setPeriodFromTo(rtnVal);
        }
    }
  
    try {
        pre_ret_cond_val = '';
        var retrieve_tf = false;
        var formObj = document.form;
        for (var i = 0; i < formObj.elements.length; i++) {
            if (formObj.elements[i].name != null && formObj.elements[i].name.trim() != '' &&
                formObj.elements[i].name.substring(0, 9) == 'pre_cond_') {
                with(formObj) {
                    if (eval((elements[i].name)).value != null && eval((elements[i].name)).value != '') {
                        eval(elements[i].name.substring('pre_cond_'.length, elements[i].name.length)).value = eval(elements[i].name).value;
                        if (!retrieve_tf) {
                            retrieve_tf = true;
                        }
                    }
                }
            }
        }
        
        validateYardCode();
        validateVNDRCode();
        
        getCostCodeCombo(comboObjects[0]); // Cost Code Combo 생성
        
        if (retrieve_tf) {
            retrieve();
        }
    } catch (e) {}
}

/**
 * setting sheet initial values and header
 * param : sheetObj ==> , sheetNo ==>  
 * adding case as numbers of counting sheets
 * @param (ibsheet) sheet 		IBSheet Object
 * @param {int}     sheetNo     sheetObjects
 * @return
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with(sheetObj){                
			
				// var HeadTitle=" |SO OFC|SO SEQ|CSR\nNo.|CSR\nST|INV\nType|Tml INV TP Cd|Inv. No.|VVD|Inv\nST|REJ.|CRED\nDT|CRED\nUser ID|Inv. OFC||Cost OFC||Yard CD||CURR|Issue DT|RCV DT|EFF DT|P.\nD/Date|P.ST|Hold|Vendor||VAT AMT|WHT AMT|INV. AMT|RJCT RMK|Retroactive";
				
				var HeadTitle0 = "CSR No.|CSR STS|INV\nType|Inv. No.|Cost CD|Inv\nST|REJ.|CRED\nDT|CRED\nUser ID|Inv. OFC|Cost OFC|Yard CD|CURR|Issue DT|RCV DT|EFF DT|P.\nD/Date|P.Date|P.ST|Hold|Vendor|VAT AMT|WHT AMT|INV. AMT|Calculation Method(AMT)|Calculation Method(AMT)|RJCT RMK|Retroactive";
				var HeadTitle1 = "CSR No.|CSR STS|INV\nType|Inv. No.|Cost CD|Inv\nST|REJ.|CRED\nDT|CRED\nUser ID|Inv. OFC|Cost OFC|Yard CD|CURR|Issue DT|RCV DT|EFF DT|P.\nD/Date|P.Date|P.ST|Hold|Vendor|VAT AMT|WHT AMT|INV. AMT|Auto Calculated|Manual Input|RJCT RMK|Retroactive";
				
				SetConfig( { SearchMode:2, MergeSheet:5, FrozenCol:4, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				// var headers = [ { Text:HeadTitle, Align:"Center"} ];
				
				var headers = [ { Text:HeadTitle0, Align:"Center"},
									{ Text:HeadTitle1, Align:"Center"} ];
				
				InitHeaders(headers, info);
				
				var cols = [
							{Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"csr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },      
							{Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"csr_status",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },      
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"inv_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cost_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tml_inv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tml_inv_rjct_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inv_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },                      
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cost_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"yd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"iss_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rcv_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Date",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pay_due_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pay_dt",         		KeyField:0,   CalcLogic:"",   Format:"Ymd",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pay_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"hld_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"vat_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"whld_tax_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ttl_inv_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },                      
							{Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"auto_calc_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },  
							{Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"manual_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },  
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"inv_rjct_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rtro_tml_inv_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },                       
							
							{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tml_so_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tml_so_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tml_inv_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"vvd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inv_ofc_del_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cost_ofc_del_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"yd_del_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vndr_del_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
							];
				
				InitColumns(cols);
				
				SetEditable(1);
				//SetSheetHeight(240);
				resizeSheet();
			}
		
		break;
	}
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
}

/**
 * handling sheet process
 * param : sheetObj ==> , formObj ==> form, sAction ==> action value  
 * @param(ibsheet) 	sheetObj 		IBSheet Object
 * @param(formObj) 	form			form object
 * @param(string) 	sAction			action value
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (validateForm(sheetObj, formObj, sAction)) {
                formObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch("ESD_TES_0013GS.do", tesFrmQryStr(formObj));
            }
            
            for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
                if (sheetObj.GetCellValue(i, "tml_inv_rjct_sts_cd") == "RJ") {
                    sheetObj.SetCellEditable(i, "chk", 1);
                } else {
                    sheetObj.SetCellEditable(i, "chk", 0);
                }
            }
            
            break;
            
        case IBSAVE: //Save
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            formObj.f_cmd.value = MODIFY;
            var param = sheetObj.GetSaveString();
            var savexml = sheetObj.GetSaveData("ESD_TES_0013GS.do", param + '&' + tesFrmQryStr(formObj));
            sheetObj.LoadSaveData(savexml, true);
            break;
            
        case IBDELETE: //Save
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            formObj.f_cmd.value = REMOVE;
            var param = sheetObj.GetSaveString();
            var savexml = sheetObj.GetSaveData("ESD_TES_0013GS.do", param + '&' + tesFrmQryStr(formObj));
            sheetObj.LoadSaveData(savexml, true);
            break;
            
        case IBDOWNEXCEL:
            if (sheetObj.RowCount() < 1) {
                ComShowCodeMessage("COM132501");
            } else {
                sheetObj.Down2Excel({
                    DownCols: makeHiddenSkipCol(sheetObj),
                    SheetDesign: 1,
                    Merge: 1
                });
            }
            break;

        case IBSEARCH_ASYNC05:
            formObj.f_cmd.value = SEARCH17;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0013GS.do", tesFrmQryStr(formObj));
            var vndrNm = ComGetEtcData(searchXml, "vndr_nm");
            formObj.vndr_seq_name.value = vndrNm;
            searchXml = null;

            break;
    }
}

/**
 * Sheet select
 * param : sheetObj ==> 
 * @param(ibsheet) 	sheetObj 		IBSheet Object
 * @return
 */
function sheet1_OnSearchEnd(sheetObj) {

    if (sheetObj.RowCount() > 0) {
        document.form.tml_inv_tp_cd.value = sheetObj.GetCellValue(1, 'tml_inv_tp_cd');
        pre_ret_cond_val = getPreviousRetreiveCondition();
    }

    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        if (sheetObj.GetCellValue(i, 'inv_tp_cd') == 'MR') {
            sheetObj.SetToolTipText(i, 'inv_tp_cd', 'Marine Terminal');
        } else if (sheetObj.GetCellValue(i, 'inv_tp_cd') == 'ON' || sheetObj.GetCellValue(i, 'inv_tp_cd') == 'RC') {
            sheetObj.SetToolTipText(i, 'inv_tp_cd', 'On-dock Rail Charge');
        } else if (sheetObj.GetCellValue(i, 'inv_tp_cd') == 'OC') {
            sheetObj.SetToolTipText(i, 'inv_tp_cd', 'Off dock CY');
        } else if (sheetObj.GetCellValue(i, 'inv_tp_cd') == 'MS') {
            sheetObj.SetToolTipText(i, 'inv_tp_cd', 'Marine Terminal Storage');
        }
        if (sheetObj.GetCellValue(i, 'tml_inv_sts_cd') == 'RC') {
            sheetObj.SetToolTipText(i, 'tml_inv_sts_cd', 'Received');
        } else if (sheetObj.GetCellValue(i, 'tml_inv_sts_cd') == 'CF') {
            sheetObj.SetToolTipText(i, 'tml_inv_sts_cd', 'Confirmed');
        } else if (sheetObj.GetCellValue(i, 'tml_inv_sts_cd') == 'AR') {
            sheetObj.SetToolTipText(i, 'tml_inv_sts_cd', 'Approval Requested');
        } else if (sheetObj.GetCellValue(i, 'tml_inv_sts_cd') == 'AP') {
            sheetObj.SetToolTipText(i, 'tml_inv_sts_cd', 'AP Interfaced');
        } else if (sheetObj.GetCellValue(i, 'tml_inv_sts_cd') == 'PD') {
            sheetObj.SetToolTipText(i, 'tml_inv_sts_cd', 'Paid');
        }
        if (sheetObj.GetCellValue(i, 'tml_inv_rjct_sts_cd') == 'NL') {
            sheetObj.SetToolTipText(i, 'tml_inv_rjct_sts_cd', 'Normal');
        } else if (sheetObj.GetCellValue(i, 'tml_inv_rjct_sts_cd') == 'RJ') {
            sheetObj.SetToolTipText(i, 'tml_inv_rjct_sts_cd', 'Rejected');
        } else if (sheetObj.GetCellValue(i, 'tml_inv_rjct_sts_cd') == 'RL') {
            sheetObj.SetToolTipText(i, 'tml_inv_rjct_sts_cd', 'Reject Lifted');
        } else if (sheetObj.GetCellValue(i, 'tml_inv_rjct_sts_cd') == 'AJ') {
            sheetObj.SetToolTipText(i, 'tml_inv_rjct_sts_cd', 'Auto Rejected');
        }
    }
    /** eBilling ---- B **/
    setTooltip(sheetObj, 'vvd|inv_rjct_rmk');
    /** eBilling ---- E **/
}

/**
 * handling process for input validation
 * @param(ibsheet) 	sheetObj 		IBSheet Object
 * @param(formObj) 	form			form object
 * @param(string) 	sAction			action value 
 */
function validateForm(sheetObj, formObj, sAction) {
    with(formObj) {
        //            if (!isNumber(iPage)) {
        //
        //                return false;
        //            }
    }
    return true;
}

/**
 * set Period From To
 * @return
 */
function setPeriodFromTo(argVal) {
    var formObj = document.form;
    var to_dt = new String(argVal).substring(0, 8);
    var fr_dt;
    if (to_dt != undefined && to_dt != null && to_dt.trim() != '' && to_dt.length == 8) {
        //fr_dt = tes_getDiffDate(to_dt, -30, 'D');
        fr_dt = tes_getDiffDate(to_dt, -1, 'M') + to_dt.substring(6, 8);
        if (fr_dt != undefined && fr_dt != null && fr_dt.trim() != '' && fr_dt.length == 8) {
            if (fr_dt.substring(6, 8) > ComGetLastDay(parseInt(fr_dt.substring(0, 4), 10), parseInt(fr_dt.substring(4, 6), 10))) {
                fr_dt = fr_dt.substring(0, 6) + ComGetLastDay(parseInt(fr_dt.substring(0, 4), 10), parseInt(fr_dt.substring(4, 6), 10));
            }
            formObj.fm_prd_dt.value = fr_dt.substring(0, 4) + '-' + fr_dt.substring(4, 6) + '-' + fr_dt.substring(6, 8);
            formObj.to_prd_dt.value = to_dt.substring(0, 4) + '-' + to_dt.substring(4, 6) + '-' + to_dt.substring(6, 8);
        }
    }
}

/**
 * print Invoice Summary
 * @return
 */
function printInvoiceSummary() {
    var fromObj = new Array();
    var rdObj = new Array();

    fromObj[0] = document.form;
    rdObj[0] = sheetObjects[0];

    parmObj[0] = "1";
    parmObj[1] = "";
    parmObj[2] = "N";
    parmObj[3] = RD_path + "apps/opus/esd/tes/serviceproviderinvoicemanage/marineterminalinvoicemanage/report/ESD_TES_0801.mrd";
    parmObj[4] = rdObj;
    parmObj[5] = fromObj;
    rdObjModaless(RdReport, parmObj, 1100, 700);
}

/**
 * check Period
 * @return
 */
function chkPeriod() {
    var formObj = document.form;
    var is_valid = 0;
    var fromVal = formObj.fm_prd_dt.value;
    var toVal = formObj.to_prd_dt.value;
    if (fromVal != null && fromVal != "" && toVal != null && toVal != "") {
        is_valid = ComGetDaysBetween(fromVal, toVal);
        if (is_valid < 0) {
            formObj.to_prd_dt.value = '';
            ComAlertFocus(formObj.fm_prd_dt, "From Date is Later than To Date");
        }
    }
}

/**
 * get Vender Name
 * @param(object) obj	input object
 * @return
 */
function getVndrName(obj) {
    var formObj = document.form;
    if (tes_getStrLen(obj.value) == 6) {
        if (formObj.vndr_seq.value == null || formObj.vndr_seq.value.trim() == '') {
            formObj.vndr_seq_hidden.value = '';
            formObj.is_valid_vndr_seq.value = '';
            return false;
        }
        
        if ((formObj.vndr_seq_hidden.value == null || formObj.vndr_seq_hidden.value.trim() == '') || formObj.vndr_seq.value.trim() != formObj.vndr_seq_hidden.value.trim()) {
            formObj.vndr_seq_hidden.value = '';
            formObj.is_valid_vndr_seq.value = '';
            
            var sRtnVal = getVndrSeqNm(); //tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVndrCode');
	        if(sRtnVal == "Y"){
	        	formObj.is_valid_vndr_seq.value = sRtnVal;
	        	formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
	        }           
        }
    }
}

/**
 *  validation check vndr code 
 *	@return
 */
function checkValidVndrCode() {
    var formObj = document.form;
    var tmp = '';
    //		showErrMessage('is_valid_vndr_seq:'+formObj.is_valid_vndr_seq.value);
    if (formObj.is_valid_vndr_seq.value != undefined && formObj.is_valid_vndr_seq.value != null && formObj.is_valid_vndr_seq.value.trim() != '') {
        tmp = formObj.is_valid_vndr_seq.value.split('|');
        if (tmp.length > 0) {
            formObj.is_valid_vndr_seq.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_vndr_seq.value != null && formObj.is_valid_vndr_seq.value == 'Y') {
                formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
                //					formObj.vndr_seq_name.value=(tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
            } else {
                formObj.is_valid_vndr_seq.value = '';
                formObj.vndr_seq_hidden.value = '';
                ComShowCodeMessage('TES21511');
                formObj.vndr_seq.value = '';
                formObj.vndr_seq_name.value = '';
                formObj.vndr_seq.focus();
            }
        } else {
            formObj.is_valid_vndr_seq.value = '';
            formObj.vndr_seq_hidden.value = '';
            ComShowCodeMessage('TES21511');
            formObj.vndr_seq.value = '';
            formObj.vndr_seq_name.value = '';
            formObj.vndr_seq.focus();
        }
    } else {
        formObj.is_valid_vndr_seq.value = '';
        formObj.vndr_seq_hidden.value = '';
        ComShowCodeMessage('TES21511');
        formObj.vndr_seq.value = '';
        formObj.vndr_seq_name.value = '';
        formObj.vndr_seq.focus();
    }
}

/**
 *  get Yard
 *  @param(array}	rowArray	array object
 *	@return
 */
function getYard(rowArray) {
    //showErrMessage("getYard");
    var colArray = rowArray[0];
    document.all.yd_cd.value = colArray[3];
    //document.all.yd_cd_name.value = colArray[4];
}

/**
 *  get Vender code
 *  @param(array}	rowArray	array object
 *	@return
 */
function getVender(rowArray) {
    // showErrMessage("getVender");
    var colArray = rowArray[0];
    //document.all.vndr_seq.value = colArray[2].substr(2,6);
    //document.all.vndr_seq.value=colArray[6];
    document.all.vndr_seq.value = colArray[2];
    document.all.vndr_seq_name.value = colArray[4];
}

/**
 *  get office code
 *  @param(array}	rowArray	array object
 *	@return
 */
function getOffice(rowArray) {
    //showErrMessage("getOffice");
    var colArray = rowArray[0];
    document.all.cost_ofc_cd = colArray[3];
}

/**
 *  get cost code
 *  @param(array}	rowArray	array object
 *	@return
 */
function getCostOfc(rowArray) {
    var formObject = document.form;
    for (var i = 0; i < rowArray.length; i++) {
        var colArray = rowArray[0];
        document.form.cost_ofc_cd.value = colArray[3];
    }
}

/**
 *  get invoice code
 *  @param(array}	rowArray	array object
 *	@return
 */
function getInvOfc(rowArray) {
    var formObject = document.form;
    for (var i = 0; i < rowArray.length; i++) {
        var colArray = rowArray[0];
        document.form.inv_ofc_cd.value = colArray[3];
    }
}

/**
 *  validate check yard code
 *	@return	 
 */
function validateYardCode() {
    var formObj = document.form;
    if (formObj.yd_cd.value == null || formObj.yd_cd.value.trim() == '') {
        formObj.yd_cd_hidden.value = '';
        formObj.is_valid_yd_cd.value = '';
        return false;
    }
    if ((formObj.yd_cd_hidden.value == null || formObj.yd_cd_hidden.value.trim() == '') || formObj.yd_cd.value.trim() != formObj.yd_cd_hidden.value.trim()) {
        formObj.yd_cd_hidden.value = '';
        formObj.is_valid_yd_cd.value = '';
        
        var rtnVal = getYdCdValid();    //  tes_getInputValue('is_valid_yd_cd', SEARCH20, 'yd_cd', 'checkValidYardCode');
        if(rtnVal.length > 0){
        	checkValidYardCode(rtnVal);
        }        
    }
}

/**
 *  validation check yard code
 *	@return
 */
function checkValidYardCode(argVal) {
    var formObj = document.form;
    var tmp = '';
    if (argVal != undefined && argVal != null && argVal.trim() != '') {
        tmp = argVal.split('|');
        if (tmp.length > 0) {
            formObj.is_valid_yd_cd.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_yd_cd.value != null && formObj.is_valid_yd_cd.value == 'Y') {
                formObj.yd_cd_hidden.value = formObj.yd_cd.value;
                formObj.yd_cd_deltflg.value = (tmp[9] != undefined && tmp[9] != null ? tmp[9] : '');
                if (formObj.yd_cd_deltflg.value == "Y") {
                    ComShowMessage('Deleted Yard Code!');
                }
            } else {
                formObj.is_valid_yd_cd.value = '';
                formObj.yd_cd_hidden.value = '';
                formObj.yd_cd.value = '';
                ComShowMessage(ComGetMsg('TES10066'));
            }
        } else {
            formObj.is_valid_yd_cd.value = '';
            formObj.yd_cd_hidden.value = '';
            formObj.yd_cd.value = '';
            ComShowMessage(ComGetMsg('TES10066'));
        }
    } else {
        formObj.is_valid_yd_cd.value = '';
        formObj.yd_cd_hidden.value = '';
        formObj.yd_cd.value = '';
        ComShowMessage(ComGetMsg('TES10066'));
    }
}

/**
 *  validation check vender code
 *	@return
 */
function validateVNDRCode() {
    var formObj = document.form;
    if (formObj.vndr_seq.value == null || formObj.vndr_seq.value.trim() == '') {
        formObj.vndr_seq_hidden.value = '';
        formObj.is_valid_vndr_seq.value = '';
        return false;
    }
    if (formObj.vndr_seq.value.length < 6) {
        formObj.vndr_seq.value = ComLpad(formObj.vndr_seq.value, 6, 0);
    }
    if ((formObj.vndr_seq_hidden.value == null || formObj.vndr_seq_hidden.value.trim() == '') || formObj.vndr_seq.value.trim() != formObj.vndr_seq_hidden.value.trim()) {
        formObj.vndr_seq_hidden.value = '';
        formObj.is_valid_vndr_seq.value = '';
		
		var rtnVal = getVndrSeqValid("vndr_seq_name");
        
        if(rtnVal.length > 0){
        	checkValidVendorCode(rtnVal);
        }
       
        //doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC05);
        //tes_getInputValue('is_valid_vndr_seq', SEARCHLIST01, 'vndr_seq', 'checkValidVendorCode');
    }
}

/**
 *  Validation check vender code
 *	@return
 */
function checkValidVendorCode(argVal) {
    var formObj = document.form;
    var tmp = '';
    if (argVal != undefined && argVal != null && argVal.trim() != '') {
        tmp = argVal.split('|');
        if (tmp.length > 0) {
            formObj.is_valid_vndr_seq.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_vndr_seq.value != null && formObj.is_valid_vndr_seq.value == 'Y') {
                //					formObj.vndr_seq_name.value=(tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
                formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
                formObj.vndr_seq_deltflg.value = (tmp[2] != undefined && tmp[2] != null ? tmp[2] : '');
                if (formObj.vndr_seq_deltflg.value == "Y") {
                    ComShowMessage('Deleted S/P Code!');
                }
            } else {
                formObj.is_valid_vndr_seq.value = '';
                formObj.vndr_seq_hidden.value = '';
                formObj.vndr_seq.value = '';
                formObj.vndr_seq_name.value = '';
                ComShowMessage(ComGetMsg('TES10067'));
            }
        } else {
            formObj.is_valid_vndr_seq.value = '';
            formObj.vndr_seq_hidden.value = '';
            formObj.vndr_seq.value = '';
            formObj.vndr_seq_name.value = '';
            ComShowMessage(ComGetMsg('TES10067'));
        }
    } else {
        formObj.is_valid_vndr_seq.value = '';
        formObj.vndr_seq_hidden.value = '';
        formObj.vndr_seq.value = '';
        formObj.vndr_seq_name.value = '';
        ComShowMessage(ComGetMsg('TES10067'));
    }
}

/**
 *  Validation check cost code 
 *	@return
 */
function validateCostOFCCode() {
    var formObj = document.form;
    if (formObj.cost_ofc_cd.value == null || formObj.cost_ofc_cd.value.trim() == '') {
        formObj.cost_ofc_cd_hidden.value = '';
        formObj.is_valid_cost_ofc_cd.value = '';
        return false;
    }
    if ((formObj.cost_ofc_cd_hidden.value == null || formObj.cost_ofc_cd_hidden.value.trim() == '') || formObj.cost_ofc_cd.value.trim() != formObj.cost_ofc_cd_hidden.value.trim()) {
        formObj.cost_ofc_cd_hidden.value = '';
        formObj.is_valid_cost_ofc_cd.value = '';
        
        var rtnVal = getCostOfcValidDelYN();    // tes_getInputValue('is_valid_cost_ofc_cd', SEARCHLIST02, 'cost_ofc_cd', 'checkValidCostOFCCode');
        if(rtnVal.length > 0){
        	checkValidCostOFCCode(rtnVal);
        }        
    }
}

/**
 *  validation check cost code 
 *	@return
 */
function checkValidCostOFCCode(argVal) {
    var formObj = document.form;
    var tmp = '';
    if (argVal != undefined && argVal != null && argVal.trim() != '') {
        tmp = argVal.split('|');
        if (tmp.length > 0) {
            formObj.is_valid_cost_ofc_cd.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_cost_ofc_cd.value != null && formObj.is_valid_cost_ofc_cd.value == 'Y') {
                formObj.cost_ofc_cd_hidden.value = formObj.cost_ofc_cd.value;
                formObj.cost_ofc_cd_deltflg.value = (tmp[2] != undefined && tmp[2] != null ? tmp[2] : '');
                if (formObj.cost_ofc_cd_deltflg.value == "Y") {
                    ComShowMessage('Deleted Office Code!');
                }
            } else {
                formObj.is_valid_cost_ofc_cd.value = '';
                formObj.cost_ofc_cd_hidden.value = '';
                formObj.cost_ofc_cd.value = '';
                ComShowCodeMessage('TES40052', 'Cost Office Code');
            }
        } else {
            formObj.is_valid_cost_ofc_cd.value = '';
            formObj.cost_ofc_cd_hidden.value = '';
            formObj.cost_ofc_cd.value = '';
            ComShowCodeMessage('TES40052', 'Cost Office Code');
        }
    } else {
        formObj.is_valid_cost_ofc_cd.value = '';
        formObj.cost_ofc_cd_hidden.value = '';
        formObj.cost_ofc_cd.value = '';
        ComShowCodeMessage('TES40052', 'Cost Office Code');
    }
}

/**
 *  Validation check invoice office code 
 *	@return
 */
function validateInvOFCCode() {
    var formObj = document.form;
    if (formObj.inv_ofc_cd.value == null || formObj.inv_ofc_cd.value.trim() == '') {
        formObj.inv_ofc_cd_hidden.value = '';
        formObj.is_valid_inv_ofc_cd.value = '';
        return false;
    }
    if ((formObj.inv_ofc_cd_hidden.value == null || formObj.inv_ofc_cd_hidden.value.trim() == '') || formObj.inv_ofc_cd.value.trim() != formObj.inv_ofc_cd_hidden.value.trim()) {
        formObj.inv_ofc_cd_hidden.value = '';
        formObj.is_valid_inv_ofc_cd.value = '';
        
        var rtnVal = getInvOfcValidDelYN();     // tes_getInputValue('is_valid_inv_ofc_cd', SEARCHLIST03, 'inv_ofc_cd', 'checkValidInvOFCCode');
        if(rtnVal.length > 0){
        	checkValidInvOFCCode(rtnVal);
        }
    }
}

/**
 *  Validation check invoice office 
 *	@return
 */
function checkValidInvOFCCode(argVal) {
    var formObj = document.form;
    var tmp = '';
    if (argVal != undefined && argVal != null && argVal.trim() != '') {
        tmp = argVal.split('|');
        if (tmp.length > 0) {
            formObj.is_valid_inv_ofc_cd.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_inv_ofc_cd.value != null && formObj.is_valid_inv_ofc_cd.value == 'Y') {
                formObj.inv_ofc_cd_hidden.value = formObj.inv_ofc_cd.value;
                formObj.inv_ofc_cd_deltflg.value = (tmp[1] != undefined && tmp[1] != null ? tmp[1] : '');
                if (formObj.inv_ofc_cd_deltflg.value == "Y") {
                    ComShowMessage('Deleted Office Code!');
                }
            } else {
                formObj.is_valid_inv_ofc_cd.value = '';
                formObj.inv_ofc_cd_hidden.value = '';
                formObj.inv_ofc_cd.value = '';
                ComShowCodeMessage('TES40052', 'Invoice Office Code');
            }
        } else {
            formObj.is_valid_inv_ofc_cd.value = '';
            formObj.inv_ofc_cd_hidden.value = '';
            formObj.inv_ofc_cd.value = '';
            ComShowCodeMessage('TES40052', 'Invoice Office Code');
        }
    } else {
        formObj.is_valid_inv_ofc_cd.value = '';
        formObj.inv_ofc_cd_hidden.value = '';
        formObj.inv_ofc_cd.value = '';
        ComShowCodeMessage('TES40052', 'Invoice Office Code');
    }
}

/**
 *  Validation check office code, invoice office code
 *  @param(inv_ofc_cd) invice office code 
 *	@return
 */
function checkValidOFC(inv_ofc_cd) {
    if (ofc_cd == '') {
        ComShowMessage('No Inv OFC data is found in the session');
        return false;
    }
    //if(inv_ofc_cd == undefined || inv_ofc_cd == null || inv_ofc_cd.trim() == '' ){
    if (inv_ofc_cd == undefined || inv_ofc_cd == null || ComTrim(inv_ofc_cd) == '') {
        ComShowMessage("Inv OFC data does not exist at the selected invoice!");
        return false;
    }
    if (ofc_cd != inv_ofc_cd) {
        ComShowMessage(ComGetMsg('TES21050'));
        return false;
    }
    return true;
}

/**
 *  check enter key
 *  @param(funcNm) function name
 *	@return
 */
function enterCheck(funcNm) {
    if (event.keyCode == 13) {
        retrieve();
    }
}

/** 
 * 
 * @return
 */
function goCntrList(argVal) {
    var sheetObject = sheetObjects[0];
    var inv_no = sheetObject.GetCellValue(sheetObject.GetSelectRow(), 'inv_no');
    var vndr_seq = sheetObject.GetCellValue(sheetObject.GetSelectRow(), 'vndr_seq');
    var tml_inv_tp_cd = sheetObject.GetCellValue(sheetObject.GetSelectRow(), 'tml_inv_tp_cd');
    
    if (argVal.trim() == "Y") {
        if (tml_inv_tp_cd == 'TM') {
            location.href = "ESD_TES_0017.do?pgmNo=ESD_TES_0017&parentPgmNo=ESD_TES_M001&inv_no=" + encodeURIComponent(inv_no) + "&vndr_seq=" + vndr_seq + '&sysCommUiTitle=Marine Terminal Container List&sysCommUiNavigation=TML S/O > Invoice > Container List Inquiry';
        } else if (tml_inv_tp_cd == 'ON') {
            location.href = "ESD_TES_0068.do?pgmNo=ESD_TES_0068&parentPgmNo=ESD_TES_M001&inv_no=" + encodeURIComponent(inv_no) + "&vndr_seq=" + vndr_seq + '&sysCommUiTitle=On-Dock Rail Charge Container List&sysCommUiNavigation=TML S/O > Invoice > Container List Inquiry';
        } else if (tml_inv_tp_cd == 'OF') {
            location.href = "ESD_TES_0018.do?pgmNo=ESD_TES_0018&parentPgmNo=ESD_TES_M001&inv_no=" + encodeURIComponent(inv_no) + "&vndr_seq=" + vndr_seq + '&sysCommUiTitle=Off-Dock CY Container List&sysCommUiNavigation=TML S/O > Invoice > Container List Inquiry';
        } else if (tml_inv_tp_cd == 'ST') {
            location.href = "ESD_TES_0019.do?pgmNo=ESD_TES_0019&parentPgmNo=ESD_TES_M001&inv_no=" + encodeURIComponent(inv_no) + "&vndr_seq=" + vndr_seq + '&sysCommUiTitle=Marine Terminal Storage Container List&sysCommUiNavigation=TML S/O > Invoice > Container List Inquiry';
        }
    } else {
        ComShowMessage(ComGetMsg('TES21051'));
    }
}

/**
 * retrieve
 * @return
 */
function retrieve() {
    if ((document.form.inv_no.value != undefined && document.form.inv_no.value != null && document.form.inv_no.value.trim() != '') ||
        (document.form.csr_no.value != undefined && document.form.csr_no.value != null && document.form.csr_no.value.trim() != '')) {} else {
        if (document.form.inv_date_type.value == undefined || document.form.inv_date_type.value == null || document.form.inv_date_type.value.trim() == '') {
            ComShowMessage('Please select one of \'Inv.No.\', \'CSR No.\' or \'Inv. Date\' type');
            return false;
        }
        if (!ComIsNull(document.form.inv_date_type.value)) {
            if (ComIsNull(document.form.fm_prd_dt.value)) {
                ComShowMessage(ComGetMsg('TES21903'));
                document.form.fm_prd_dt.focus();
                return false;
            }
            if (ComIsNull(document.form.to_prd_dt.value)) {
                ComShowMessage(ComGetMsg('TES21904'));
                document.form.to_prd_dt.focus();
                return false;
            }
            chkPeriod();
        }
        if (!((document.form.yd_cd.value != undefined && document.form.yd_cd.value != null && document.form.yd_cd.value.trim() != '') ||
                (document.form.vndr_seq.value != undefined && document.form.vndr_seq.value != null && document.form.vndr_seq.value.trim() != '') ||
                (document.form.cost_ofc_cd.value != undefined && document.form.cost_ofc_cd.value != null && document.form.cost_ofc_cd.value.trim() != '') ||
                (document.form.inv_ofc_cd.value != undefined && document.form.inv_ofc_cd.value != null && document.form.inv_ofc_cd.value.trim() != ''))) {
            ComShowMessage('Please enter one of \'Yard Code\', \'S/P Code\', \'Cost OFC\' or \'INV OFC\'.');
            return false;
        }
    }
    //			if (ComIsNull(formObject.yd_cd.value)){
    //			  	ComShowMessage(ComGetMsg(('TES21901'));
    //			  	return false;
    //			}
    //			if (!ComChkLen(formObject.yd_cd, 7)){
    //			  	showErrMessage(getMsg('TES21902'));
    //			  	return false;
    //			}
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * check Input value
 * @param {object}	obj		input object
 * @return
 */
function chkInput(obj) {
    //	showErrMessage('strleng: '+getStrLen(obj.value));
    if (obj.maxLength < ComGetLenByByte(obj.value)) {
        obj.value = '';
        obj.focus();
        return false;
    }
}

/** 
 * @param {object}	obj		input object
 * @return
 */
function isNum(obj) {
    if (!ComIsNumber(obj)) {
        obj.value = '';
    }
}

/**
 * @param {object}	obj		input object
 * @return
 */
function isNum1(obj) {
    if (!ComIsNumber(obj, "-")) {
        obj.value = '';
    }
}

/**
 * @param {object}	obj		input object
 * @return
 */
function isApNum(obj) {
    if (!ComIsAlphabet(obj, "n")) {
        obj.value = '';
    }
}

/**
 * @param {object}	obj		input object
 * @return
 */
function isAlpha(obj) {
    if (!ComIsAlphabet(obj)) {
        obj.value = "";
    }
}

/**
 * @param {string}	scr		
 * @return
 */
function getStrLen(src) {
    src = new String(src);
    var byteLength = 0;
    for (var inx = 0; inx < src.length; inx++) {
        var oneChar = escape(src.charAt(inx));
        if (oneChar.length == 1) {
            byteLength++;
        } else if (oneChar.indexOf("%u") != -1) {
            byteLength += 2;
        } else if (oneChar.indexOf("%") != -1) {
            byteLength += oneChar.length / 3;
        }
    }
    return byteLength;
}

/**
 * IBCombo Object
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param (object)	combo_obj	combo object
 */
function setComboObject(combo_obj) {
    comboObjects[comboCnt++] = combo_obj;
}
