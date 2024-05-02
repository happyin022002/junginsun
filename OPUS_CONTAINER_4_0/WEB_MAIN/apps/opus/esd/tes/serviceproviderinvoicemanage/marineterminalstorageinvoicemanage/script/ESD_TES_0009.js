/*=========================================================
* 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_0009.js
*@FileTitle  :  Marine Terminal Storage Invoice Creation & Correction
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/04
=========================================================*/
/**
 * @extends Tes
 * @class ESD_TES_0009 : business script for Marine Terminal Storage Invoice Creation & Correction
 */
function ESD_TES_0009() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.setComboObject = setComboObject;
    this.setTabObject = setTabObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.initTab = initTab;
    this.doActionIBSheet = doActionIBSheet;
    this.validateForm = validateForm;
}

/*  global variable ------------------------------------------------------------- */
var save_conf_01 = false;
var confirm_done = false;
var enable_sheet_01 = 1;
var enable_sheet_02 = 1;
var enable_sheet_03 = 1;
var enable_sheet_04 = 1;
var enable_sheet_05 = 1;
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var sheetObjects = new Array();
var sheetObjectsMap = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
var cntr_list_onchange_cnt = 1;
var def_curr_cd = '';
var parmObj = new Array();
var tmp_row = 0;
var searchEQFlag = false;

// Event handler processing by button click event */
document.onclick = processButtonClick;

/**
 * Event handler processing by button name
 * @return
 */
function processButtonClick() {
    /***** using extra sheet valuable if there are more 2 sheets *****/
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];
    var sheetObject3 = sheetObjects[3];
    var sheetObject4 = sheetObjects[4]; //main_hidden
    var sheetObject5 = sheetObjects[5]; //rjct_hidden
    var sheetObject6 = sheetObjects[6]; //conf_hidden
    var sheetObject7 = sheetObjects[7]; //dupchk_hidden
    var sheetObject8 = sheetObjects[8];
    /*******************************************************/
    var formObj = document.form;
    try {
        var srcName = ComGetEvent("name");
        switch (srcName) {
            // eBilling - B
            case "btn_pre_inquiry_cond":
                var url_str = 'ESD_TES_0013.do';
                url_str += '?pre_cond_inv_no=' + document.form.pre_cond_inv_no.value;
                url_str += '&pre_cond_inv_date_type=' + document.form.pre_cond_inv_date_type.value;
                url_str += '&pre_cond_fm_prd_dt=' + document.form.pre_cond_fm_prd_dt.value;
                url_str += '&pre_cond_to_prd_dt=' + document.form.pre_cond_to_prd_dt.value;
                url_str += '&pre_cond_yd_cd=' + document.form.pre_cond_yd_cd.value;
                url_str += '&pre_cond_vndr_seq=' + document.form.pre_cond_vndr_seq.value;
                url_str += '&pre_cond_cost_ofc_cd=' + document.form.pre_cond_cost_ofc_cd.value;
                url_str += '&pre_cond_inv_ofc_cd=' + document.form.pre_cond_inv_ofc_cd.value;
                url_str += '&pre_cond_tml_inv_sts_cd=' + document.form.pre_cond_tml_inv_sts_cd.value;
                url_str += '&pre_cond_csr_no=' + document.form.pre_cond_csr_no.value;
                url_str += '&pre_cond_csr_status=' + document.form.pre_cond_csr_status.value;
                url_str += '&pre_cond_tml_inv_rjct_sts_cd=' + document.form.pre_cond_tml_inv_rjct_sts_cd.value;
                location.href = url_str;
                break;
                
            case "btn_EDIinvoiceview":
                var url_str = 'ESD_TES_1001Popup.screen';
                url_str += '?tml_so_ofc_cty_cd=' + document.form.tml_so_ofc_cty_cd.value;
                url_str += '&tml_so_seq=' + document.form.tml_so_seq.value;
                url_str += '&fm_cre_mode=Y';
                ComOpenWindow(url_str, window, "dialogWidth:1100px; dialogHeight:1100px; help:no; status:no; resizable:yes;", true);
                break;
                
                // eBilling - E
            case "btn_retrieve":
                // eBilling - B
                // document.all.EDILayer01.style.display = "none";
                // eBilling - E
                retrieve('Y');
                break;
                
            case "btn_vndr":
                if (formObj.vndr_seq.readOnly == true) {
                    return false;
                }
                //if (!chk_rjct('Y')){ return false; }
                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                var classId = "COM_ENS_0C1";
                var param = '?classId=' + classId;
                var chkStr = dispaly.substring(0, 3)
                    // radio PopUp
                if (chkStr == "1,0") {
                    ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 650, 540, 'getVender', dispaly, true);
                } else {
                    ComShowMessage(ComGetMsg('TES21906'));
                    return;
                }
                break;
                
            case "btn_yard":
                if (formObj.yd_cd.readOnly == true) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                var classId = "COM_ENS_061";
                var param = '?classId=' + classId;
                var chkStr = dispaly.substring(0, 3)
                    // radio PopUp
                if (chkStr == "1,0") {
                    ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 820, 530, 'getYard', dispaly, true);
                } else {
                    ComShowMessage(ComGetMsg('TES21906'));
                    return;
                }
                break;
                
            case "btn_cost_ofc_cd":
                if (formObj.cost_ofc_cd.readOnly == true) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                var dispaly = '1,0,1,1,1,1,1,1,1,1,1,1';
                var classId = "COM_ENS_071";
                var param = '?classId=' + classId;
                var chkStr = dispaly.substring(0, 3)
                    // radio PopUp
                if (chkStr == "1,0") {
                    ComOpenPopup('/opuscntr/COM_ENS_071.do' + param, 775, 475, 'getOfcCd', dispaly, true);
                } else {
                    ComShowMessage(ComGetMsg('TES21906'));
                    return;
                }
                break;
                
            case "btn_new":
//                try {
//                    tes_removeTESCommonALLIframes();
//                    tes_removeTESInvoiceCommonALLIframes();
//                } catch (e) {}
                cntr_list_onchange_cnt = 1;
                confirm_done = false;
                save_conf_01 = false;
                disablePage();
                document.form.yd_cd_hidden.value = '';
                document.form.agmt_ftr_inv_tp_cd.value = "ST";

                document.form.vndr_seq.focus();
                agmt_lgs_cost_cd.RemoveAll();
                // eBilling - B
                //					document.all.EDILayer01.style.display="none";
                // eBilling - E
                break;
                
            case "btn_new2":
                cntr_list_onchange_cnt = 1;
                confirm_done = false;
                save_conf_01 = false;
                disablePage2();
                if (document.form.vndr_seq.value != null && document.form.vndr_seq.value != '') {
                    document.form.inv_no.focus();
                } else {
                    document.form.vndr_seq.focus();
                }
                agmt_lgs_cost_cd.RemoveAll();
                document.form.agmt_ftr_inv_tp_cd.value = "ST";
                // eBilling - B
                //					document.all.EDILayer01.style.display="none";
                // eBilling - E
                break;
                
            case "btn_save":
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                if (fnChkForm()) {
                    try {
                        setCalcCostCond();
                    } catch (e) {
                        ComShowMessage(e.message);
                        return false;
                    }

                    formObj.cost_cd_ftr_rmk.value = replaceAll(agmt_lgs_cost_cd.GetSelectCode(), ',', '|');

                    doActionMainHiddenSheet(sheetObject4, formObj, IBSAVE);
                    cntr_list_onchange_cnt = 1;
                }
                break;
                
            case "btns_calendar1":
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                var cal = new ComCalendar();
                cal.select(formObj.fm_prd_dt, 'yyyy-MM-dd');
                break;
                if (!chk_conf('Y')) return false;
                if (formObj.fm_prd_dt.readOnly == true) return false;
                if (!chk_rjct('Y')) return false;
                var cal = new ComCalendar();
                cal.select(formObj.fm_prd_dt, 'yyyy-MM-dd');
                
            case "btns_calendar2":
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                var cal = new ComCalendar();
                cal.select(formObj.to_prd_dt, 'yyyy-MM-dd');
                break;
                
            case "btns_calendar3":
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                var cal = new ComCalendar();
                cal.select(formObj.iss_dt, 'yyyy-MM-dd');
                break;
                
            case "btns_calendar4":
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                var cal = new ComCalendar();
                cal.select(formObj.rcv_dt, 'yyyy-MM-dd');
                break;
                
            case "btns_calendar5":
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                var cal = new ComCalendar();
                cal.select(formObj.cal5, 'yyyy-MM-dd');
                break;
                
            case "btns_remarks":
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                if (sheetObject4.RowCount() != 1) {
                    return false;
                }
                var display = "1,0,1,1,1,1,1,1,1,1,1,1";
                if (formObj.hld_flg.checked == true) {
                    //ComOpenWindowCenter('ESD_TES_9210RemarksPopup.screen?hld_rmk_inp_nm=hld_rmk&isZZ=Y', 'popup_remarks', 300,150, true);
                    ComOpenPopup('ESD_TES_9210RemarksPopup.screen?hld_rmk_inp_nm=' + $('#hld_rmk').val(), 450, 150, '', display, true);
                }
                break;
                
            case "t1btng_listclear":
                //ComShowMessage('t1btng_listclear'); return false;
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!chk_hdr_saved('Y')) {
                    return false;
                }
                if (sheetObject.RowCount() > 0 || sheetObject1.RowCount() > 0 || sheetObject2.RowCount() > 0) {
                    if (confirm(ComGetMsg('TES24067'))) {
                        removeStorageInvoice01();
                    }
                } else {
                    ComShowMessage(ComGetMsg('TES23015'));
                }
                break;
                
            case "t1btng_fileimport":
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!chk_hdr_saved('Y')) {
                    return false;
                }
                if (formObj.vndr_seq.value == undefined || formObj.vndr_seq.value == null || doSepRemove(formObj.vndr_seq.value, ' ') == '' ||
                    formObj.yd_cd.value == undefined || formObj.yd_cd.value == null || doSepRemove(formObj.yd_cd.value, ' ') == '') {
                    ComShowMessage(ComGetMsg('TES40025', 'VNDR Code/YD_CD'));
                    return false;
                }
                if (formObj.fm_prd_dt.value == undefined || formObj.fm_prd_dt.value == null || doSepRemove(formObj.fm_prd_dt.value, ' ') == '' ||
                    formObj.to_prd_dt.value == undefined || formObj.to_prd_dt.value == null || doSepRemove(formObj.to_prd_dt.value, ' ') == '') {
                    ComShowMessage(ComGetMsg('TES24016'));
                    if (formObj.fm_prd_dt.value == undefined || formObj.fm_prd_dt.value == null || doSepRemove(formObj.fm_prd_dt.value, ' ') == '') {
                        formObj.fm_prd_dt.focus();
                    } else if (formObj.to_prd_dt.value == undefined || formObj.to_prd_dt.value == null || doSepRemove(formObj.to_prd_dt.value, ' ') == '') {
                        formObj.to_prd_dt.focus();
                    }
                    return false;
                }
                if (!checkPeriodFormat(formObj.fm_prd_dt.value) || !tes_isValidDateObject(formObj.fm_prd_dt.value, '-')) {
                    ComShowMessage(ComGetMsg('TES24011'));
                    formObj.fm_prd_dt.focus();
                    return false;
                }
                if (!checkPeriodFormat(formObj.to_prd_dt.value) || !tes_isValidDateObject(formObj.to_prd_dt.value, '-')) {
                    ComShowMessage(ComGetMsg('TES23011'));
                    formObj.to_prd_dt.focus();
                    return false;
                }
                if (!checkPeriodModified()) {
                    return false;
                }
                var sto_dys_ind_cd;
                if (sheetObjects[4].RowCount() == 1) {
                    sto_dys_ind_cd = sheetObjects[4].GetCellValue(1, 'sto_dys_ind_cd');
                } else {
                    ComShowMessage(ComGetMsg('TES23017'));
                    return false;
                }
                var url = 'ESD_TES_9142FileImportPopup.screen';
                url = url + '?tml_so_ofc_cty_cd=' + sheetObjects[4].GetCellValue(1, 'tml_so_ofc_cty_cd') + '&tml_so_seq=' + sheetObjects[4].GetCellValue(1, 'tml_so_seq');
                url = url + '&vndr_seq=' + formObj.vndr_seq.value + '&yd_cd=' + formObj.yd_cd.value;
                url = url + '&fm_prd_dt=' + formObj.fm_prd_dt.value + '&to_prd_dt=' + formObj.to_prd_dt.value + '&rcv_dt=' + formObj.rcv_dt.value;
                url = url + '&sto_dys_ind_cd=' + sto_dys_ind_cd;
                url = url + '&cntr_tpsz_cd=' + CNTR_TPSZ_CD + '&inv_no=' + formObj.inv_no.value + "&agmt_ftr_inv_tp_cd=" + formObj.agmt_ftr_inv_tp_cd.value;
                //2016.09.09 AGMT COST CD Add
                url = url + '&cost_cd_ftr_rmk=' + replaceAll(agmt_lgs_cost_cd.GetSelectCode(), ',', '|');
                ComOpenWindow(url, window, "dialogWidth:610px;dialogHeight:400px; help:no; status:no; resizable:yes;", true);
                break;
                
            case "t1btng_save":
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!chk_hdr_saved('Y')) {
                    return false;
                }
                if (sheetObject.RowCount() > 0) {
                    doActionIBSheet(sheetObject, formObj, IBSAVE);
                }
                break;
                
            case "t1btng_downexcel":
                doActionIBSheet(sheetObject, formObj, IBDOWNEXCEL);
                break;
                
            case "t1btng_todiscrepancy":
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!chk_hdr_saved('Y')) {
                    return false;
                }
                var iCheckRow = '';
                if (sheetObject.RowCount() > 0) {
                    iCheckRow = sheetObject.FindCheckedRow('chk') + "|";
                    if (iCheckRow != undefined && iCheckRow != null && iCheckRow != '' && iCheckRow != '|') {
                        var arrRow = iCheckRow.split("|");
                        if (iCheckRow != null && arrRow.length > 0) {
                            //if (!confirm(ComGetMsg('TES24069'))) {
                            //	return false;
                            //} else {
                            for (var idx = 0; idx < arrRow.length; idx++) {
                                sheetObject.SetCellValue(arrRow[idx], 'vrfy_rslt_ind_cd', 'DC', 0);
                                sheetObject.SetCellValue(arrRow[idx], 'modi_flg', '', 0);
                            }
                            //}
                            var queryStr = sheetObject.GetSaveString(false, false, 'chk');
                            tes_copy_rows_to2(sheetObject1, queryStr, true);
                            //								tes_copy_rows_to(sheetObject, sheetObject1, 'chk', queryStr, true);
                            sheetObject1.ColumnSort("dscr_ind_cd", "ASC");
                            for (var i = (arrRow.length - 2); arrRow != null && i >= 0; i--) {
                                sheetObject.RowDelete(arrRow[i], false);
                            }
                            setCoinShtStat();
                        }
                    } else {
                        ComShowMessage(ComGetMsg('TES23019'));
                    }
                }
                break;
                
            case "t1btng_costcalc":
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!chk_hdr_saved('Y')) {
                    return false;
                }
                if (sheetObject.RowCount() > 0) {
                    if (sheetObjects[4].RowCount() == 1) {
                        if (sheetObjects[4].GetCellValue(1, 'curr_cd') != curr_cd.GetSelectCode()) {
                            ComShowMessage(ComGetMsg('TES40002', 'Currency'));
                            return false;
                        }
                    } else {
                        return false;
                    }
                    for (var i = sheetObject.HeaderRows(); i < (sheetObject.HeaderRows() + sheetObject.RowCount()); i++) {
                        /*
                        	if (sheetObject.GetCellValue(i,'cntr_tpsz_cd')==null || sheetObject.GetCellValue(i,'cntr_tpsz_cd')==''){
                        	ComShowMessage(ComGetMsg('TES40016','Type/Size'));
                        	return false;
                        }
                        */
                        if (sheetObject.GetCellValue(i, 'cntr_sty_cd') == null || doSepRemove(sheetObject.GetCellValue(i, 'cntr_sty_cd'), ' ') == '') {
                            ComShowMessage(ComGetMsg('TES40016', 'F/M'));
                            return false;
                        }
                        if (sheetObject.GetCellValue(i, 'io_bnd_cd') == null || doSepRemove(sheetObject.GetCellValue(i, 'io_bnd_cd'), ' ') == '') {
                            ComShowMessage(ComGetMsg('TES40016', 'I/O'));
                            return false;
                        }
                        if (sheetObject.GetCellValue(i, 'dcgo_clss_cd') == null || doSepRemove(sheetObject.GetCellValue(i, 'dcgo_clss_cd'), ' ') == '') {
                            ComShowMessage(ComGetMsg('TES40016', 'DG'));
                            return false;
                        }
                    }
                    var sheets = new Array();
                    sheets[0] = sheetObjects[0];
                    sheets[1] = sheetObjects[1];
                    if (!tes_isAllDataSaved(sheets)) {
                        ComShowMessage(ComGetMsg('TES23060'));
                        return false;
                    }
                    var params = new Array();
                    params[0] = sheetObjects[0].GetSaveString(false, false);
                    params[1] = sheetObjects[1].GetSaveString(false, false);
                    if (tes_isModified(sheets, params)) {
                        ComShowMessage(ComGetMsg('TES23021'));
                        return false;
                    }
                    if (formObj.fm_prd_dt.value == undefined || formObj.fm_prd_dt.value == null || doSepRemove(formObj.fm_prd_dt.value, ' ') == '') {
                        ComShowMessage(ComGetMsg('TES23022'));
                        return false;
                    } else {
                        if (!checkPeriodFormat(formObj.fm_prd_dt.value) || !tes_isValidDateObject(formObj.fm_prd_dt.value, '-')) {
                            ComShowMessage(ComGetMsg('TES23011'));
                            formObj.fm_prd_dt.focus();
                            return false;
                        }
                    }
                    if (!checkPeriodModified()) {
                        return false;
                    }
                    //ComShowMessage(formObj.sto_dys_ind_cd.value);
                    if (formObj.sto_dys_ind_cd.value == null || formObj.sto_dys_ind_cd.value == '' ||
                        (formObj.sto_dys_ind_cd.value != 'IO' && formObj.sto_dys_ind_cd.value != 'DT')) {
                        ComShowMessage(ComGetMsg('TES23023'));
                        return false;
                    }
                    if (isAutoCalcDataExisting()) {
                        if (confirm(ComGetMsg('TES24070'))) {
                            removeAutoCalcData();
                        } else {
                            return false;
                        }
                    }
                    if (!isValidAgmtSts()) {
                        return false;
                    }
                    setSheetsEnable(2, true);

                    doActionIBSheet3(sheetObjects[2], formObj, IBSEARCH_ASYNC02);

                } else {
                    ComShowMessage(ComGetMsg('TES23024'));
                }
                break;
                
            case "t2btng_rowadd":
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!chk_hdr_saved('Y')) {
                    return false;
                }
                doActionIBSheet2(sheetObject1, formObj, IBINSERT);
                break;
                
            case "t2btng_listclear":
                //ComShowMessage('t1btng_listclear'); return false;
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!chk_hdr_saved('Y')) {
                    return false;
                }
                if (sheetObject.RowCount() > 0 || sheetObject1.RowCount() > 0 || sheetObject2.RowCount() > 0) {
                    if (confirm(ComGetMsg('TES24067'))) {
                        removeStorageInvoice01();
                    }
                } else {
                    ComShowMessage(ComGetMsg('TES23015'));
                }
                break;
                
            case "t2btng_verification":
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!chk_hdr_saved('Y')) {
                    return false;
                }
                var iCheckRow = '';
                if (sheetObject1.RowCount() > 0) {
                    iCheckRow = sheetObject1.FindCheckedRow('chk') + "|";
                    if (iCheckRow != undefined && iCheckRow != null && iCheckRow != '' && iCheckRow != '|') {
                        var arrRow = iCheckRow.split("|");
                        if (iCheckRow != null && arrRow.length > 0) {
                            //if (!confirm(ComGetMsg('TES23068'))) {
                            //	return false;
                            //} else {
                            for (var idx = 0; idx < arrRow.length; idx++) {
                                sheetObject1.SetCellValue(arrRow[idx], 'vrfy_rslt_ind_cd', 'CO', 0);
                                sheetObject1.SetCellValue(arrRow[idx], 'modi_flg', 'Y', 0);
                            }
                            //}
                            var queryStr = sheetObject1.GetSaveString(false, false, 'chk');
                            tes_copy_rows_to2(sheetObject, queryStr, true);
                            //								tes_copy_rows_to(sheetObject1, sheetObject, 'chk', queryStr, true);
                            setCoinShtStat();
                            for (var i = (arrRow.length - 2); arrRow != null && i >= 0; i--) {
                                sheetObject1.RowDelete(arrRow[i], false);
                            }
                        }
                    } else {
                        ComShowMessage(ComGetMsg('TES23019'));
                    }
                }
                break;
                
            case "t2btng_reject":
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                if (sheetObject4.RowCount() != 1) {
                    return false;
                }
                if (!chk_hdr_saved('Y')) {
                    return false;
                }
                ComOpenWindowCenter('ESD_TES_9020RejectPopup.screen?rjct_sts_inp_nm=inv_rjct_rmk&rjct_fn_nm=rjctInv', 'popup_reject', 400, 150, true);
                break;
                
            case "t2btng_print":
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                if (sheetObject1.RowCount() > 0) {
                    printDiscrepancyContainerList();
                } else {
                    ComShowMessage(ComGetMsg('TES23026'));
                    return false;
                }
                break;
                
            case "t2btng_downexcel":
                doActionIBSheet2(sheetObject1, formObj, IBDOWNEXCEL);
                break;

            case "t3btng_costCal":
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }

                var param = "?yd_cd=" + formObj.yd_cd.value + "&vndr_seq=" + formObj.vndr_seq.value + "&vndr_seq_nm=" + formObj.vndr_seq_nm.value + "&fm_prd_dt=" + formObj.fm_prd_dt.value + "&curr_cd=" + formObj.curr_cd.value + "&to_prd_dt=" + formObj.to_prd_dt.value + "&prgm_id=ESD_TES_0009&cost_cd_inv_tp_cd=ST";

                //ComOpenPopup(sUrl,                     iWidth, iHeight, sFunc,            sDisplay,        bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                ComOpenPopup("ESD_TES_9001.do" + param, 840, 670, "setCostCode2", "1,0,1,1,1,1,1", true, false, null, null, null, 'Cost Calculation', 'no');
                break;

            case "t3btng_listclear":
                //ComShowMessage('t1btng_listclear'); return false;
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!chk_hdr_saved('Y')) {
                    return false;
                }
                if (sheetObject.RowCount() > 0 || sheetObject1.RowCount() > 0 || sheetObject2.RowCount() > 0) {
                    if (confirm(ComGetMsg('TES24067'))) {
                        removeStorageInvoice01();
                    }
                } else {
                    ComShowMessage(ComGetMsg('TES23015'));
                }
                break;
                
            case "t3btng_rowadd":
                if (!chk_conf('Y')) {
                    return false;
                }
                doActionIBSheet3(sheetObject2, formObj, IBINSERT);
                break;
                
            case "t3btng_rowdel":
                if (!chk_conf('Y')) {
                    return false;
                }
                doActionIBSheet3(sheetObject2, formObj, IBDELETE);
                break;
                
            case "t3btng_save":
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!chk_hdr_saved('Y')) {
                    return false;
                }
                doActionIBSheet3(sheetObject2, formObj, IBSAVE);
                break;
                
            case "t3btng_totalamount":
                if (sheetObject4.RowCount() != 1) {
                    return false;
                }
                var url_str = 'ESD_TES_9050Popup.screen';
                url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
                url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
                ComOpenWindow(url_str, window, "help:no;status:no;resizable:yes;dialogWidth:" + 610 + "px;dialogHeight:" + 420 + "px", true);
                //ComOpenWindow(url_str,  window,  "dialogWidth:610px; dialogHeight:420px; help:no; status:no; resizable:yes;" , true);
                break;
                
            case "t3btng_confirm":
                if (confirm_done) {
                    ComShowMessage(ComGetMsg('TES23027'));
                    return false;
                }
                if (sheetObject4.RowCount() != 1) {
                    return false;
                }
                doActionConfirmHiddenSheet(sheetObject6, formObj, IBSAVE);
                break;
                
            case "t4btng_listclear":
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!chk_hdr_saved('Y')) {
                    return false;
                }
                if (sheetObject3.RowCount() > 0) {
                    if (confirm(ComGetMsg('TES40012'))) {
                        removeStorageInvoice02();
                    }
                } else {
                    ComShowMessage(ComGetMsg('TES23015'));
                }
                break;
                
            case "t4btng_rowadd":
                if (!chk_conf('Y')) {
                    return false;
                }
                doActionIBSheet4(sheetObject3, formObj, IBINSERT);
                break;
                
            case "t4btng_rowdel":
                if (!chk_conf('Y')) {
                    return false;
                }
                doActionIBSheet4(sheetObject3, formObj, IBDELETE);
                break;
                
            case "t4btng_save":
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!chk_hdr_saved('Y')) {
                    return false;
                }
                doActionIBSheet4(sheetObject3, formObj, IBSAVE);
                break;
                
            case "t4btng_totalamount":
                if (sheetObject4.RowCount() != 1) {
                    return false;
                }
                var url_str = 'ESD_TES_9050Popup.screen';
                url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
                url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
                //ComOpenWindow(url_str,  window,  "dialogWidth:610px; dialogHeight:420px; help:no; status:no; resizable:yes;" , true);
                ComOpenWindow(url_str, window, "help:no;status:no;resizable:yes;dialogWidth:" + 610 + "px;dialogHeight:" + 420 + "px", true);
                break;
                
            case "t4btng_reject":
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                if (sheetObject4.RowCount() != 1) {
                    return false;
                }
                if (!chk_hdr_saved('Y')) {
                    return false;
                }
                ComOpenWindowCenter('ESD_TES_9020RejectPopup.screen?rjct_sts_inp_nm=inv_rjct_rmk&rjct_fn_nm=rjctInv', 'popup_reject', 400, 150, true);
                break;
                
            case "t4btng_confirm":
                //ComShowMessage("t4btng_confirm");
                if (confirm_done) {
                    ComShowMessage(ComGetMsg('TES23027'));
                    return false;
                }
                if (sheetObject4.RowCount() != 1) {
                    return false;
                }
                doActionConfirmHiddenSheet(sheetObject6, formObj, IBSAVE);
                break;
                
            case "t5btng_costCal":
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }

                var param = "?yd_cd=" + formObj.yd_cd.value + "&vndr_seq=" + formObj.vndr_seq.value + "&vndr_seq_nm=" + formObj.vndr_seq_nm.value + "&fm_prd_dt=" + formObj.fm_prd_dt.value + "&curr_cd=" + formObj.curr_cd.value + "&to_prd_dt=" + formObj.to_prd_dt.value + "&prgm_id=ESD_TES_0009&cost_cd_inv_tp_cd=SE";

                //ComOpenPopup(sUrl,                     iWidth, iHeight, sFunc,            sDisplay,        bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                ComOpenPopup("ESD_TES_9001.do" + param, 840, 670, "setCostCode3", "1,0,1,1,1,1,1", true, false, null, null, null, 'Cost Calculation', 'no');
                break;

            case "t5btng_listclear":
                //ComShowMessage('t1btng_listclear'); return false;
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!chk_hdr_saved('Y')) {
                    return false;
                }
                if (sheetObject8.RowCount() > 0) {
                    if (confirm(ComGetMsg('TES24067'))) {
                        removeStorageInvoice03();
                    }
                } else {
                    ComShowMessage(ComGetMsg('TES23015'));
                }
                break;
                
            case "t5btng_rowadd":
                if (!chk_conf('Y')) {
                    return false;
                }
                doActionIBSheet5(sheetObject8, formObj, IBINSERT);
                break;
                
            case "t5btng_rowdel":
                if (!chk_conf('Y')) {
                    return false;
                }
                doActionIBSheet5(sheetObject8, formObj, IBDELETE);
                break;
                
            case "t5btng_save":
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!chk_hdr_saved('Y')) {
                    return false;
                }
                doActionIBSheet5(sheetObject8, formObj, IBSAVE);
                break;
                
            case "t5btng_totalamount":
                if (sheetObject4.RowCount() != 1) {
                    return false;
                }
                var url_str = 'ESD_TES_9050Popup.screen';
                url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
                url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
                ComOpenWindow(url_str, window, "help:no;status:no;resizable:yes;dialogWidth:" + 610 + "px;dialogHeight:" + 420 + "px", true);
                //ComOpenWindow(url_str,  window,  "dialogWidth:610px; dialogHeight:420px; help:no; status:no; resizable:yes;" , true);
                break;
                
            case "t5btng_confirm":
                if (confirm_done) {
                    ComShowMessage(ComGetMsg('TES23027'));
                    return false;
                }
                if (sheetObject4.RowCount() != 1) {
                    return false;
                }
                doActionConfirmHiddenSheet(sheetObject6, formObj, IBSAVE);
                break;
                
        }
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(ComGetMsg('TES23028'));
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * set vender name
 * @param rowArray
 * @return
 */

function getVender(rowArray) {
    var colArray = rowArray[0];
    document.all.vndr_seq.value = (colArray[2] != undefined && colArray[2] != null ? colArray[2] : '');
    document.all.vndr_seq_nm.value = (colArray[4] != undefined && colArray[4] != null ? colArray[4] : '');
    validateVndrSeq();
}

/**
 * set yard name
 * @param rowArray
 * @return
 */
function getYard(rowArray) {
    var colArray = rowArray[0];
    document.all.yd_cd.value = colArray[3];
    if (colArray[3] != undefined && colArray[3] != null && colArray[3] != '') {
        var rtnVal = getYdCdCostCdList(); // tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');           
        if(rtnVal.length > 0){
        	checkValidYardCode(rtnVal);
        }
    }
}

/**
 * getYardName
 * @return
 */
function getYardName() {
    var formObj = document.form;
    if (formObj.yd_cd.value == null || formObj.yd_cd.value.trim() == '') {
        return false;
    }
    doActionMainHiddenSheet(sheetObjects[4], formObj, IBSEARCH_ASYNC04);
}

/**
 * set Cost OFC
 * @param rowArray
 * @return
 */
function getOfcCd(rowArray) {
    var colArray = rowArray[0];
    document.all.cost_ofc_cd.value = (colArray[3] != undefined && colArray[3] != null ? colArray[3] : '');
}

/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param {sheet}	sheet_obj	ibsheet
 * @return
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
    sheetObjectsMap[sheet_obj.id] = sheet_obj;
}

/**
 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
 * @return
 */
function loadPage() {
    disableForm();
    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
    
    if(getComCdList()){     // CNTR_TPSZ_CD, MT_A_LGS_COST_CD, CARR_CD     //tes_getInputValue('tmp_common_code', SEARCH17, '', 'setCommonCode');
        sheetObjects[1].SetColProperty("cntr_tpsz_cd", { ComboText: CNTR_TPSZ_CD, ComboCode: CNTR_TPSZ_CD });
	    sheetObjects[2].SetColProperty("cntr_tpsz_cd", { ComboText: CNTR_TPSZ_CD, ComboCode: CNTR_TPSZ_CD });
	    sheetObjects[2].SetColProperty("lgs_cost_cd", { ComboText: ST_A_LGS_COST_CD, ComboCode: ST_A_LGS_COST_CD });
	    sheetObjects[3].SetColProperty("lgs_cost_cd", { ComboText: ST_A_LGS_COST_CD, ComboCode: ST_A_LGS_COST_CD });
	    sheetObjects[8].SetColProperty("lgs_cost_cd", { ComboText: "SRNDCH|SRNDGS", ComboCode: "SRNDCH|SRNDGS" });
	    sheetObjects[8].SetColProperty("eq_tpsz_cd", { ComboText: EQ_TPSZ_CD, ComboCode: EQ_TPSZ_CD });    
    }  
    
    getWhldTaxAmtMode();  // WHLD_TAX_READONLY_MODE      //tes_getInputValueInvoice('whld_tax_amt_mode', SEARCH05, 'inv_ofc_cd', 'setWhldTaxAmtMode');
    
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    for (k = 0; k < tabObjects.length; k++) {
        initTab(tabObjects[k], k + 1);
        tabObjects[k].SetSelectedIndex(0);

    }
    
    if(getCurrencyList(0, 70, 100)){    //tes_getComboItem('curr_cd', 1, SEARCH03, '', 'inv_ofc_cd', 'setCalcColFormat');
    	resetSheetDataProperty(comboObjects[0].GetSelectCode());
    }
    
    document.form.vndr_seq.focus();
    document.form.tml_inv_rjct_sts_cd.value = document.form.tml_inv_rjct_sts_cd.value != null ? document.form.tml_inv_rjct_sts_cd.value : '';
    document.form.tml_inv_rjct_sts_cd.title = document.form.tml_inv_rjct_sts_cd.value != null ? tes_getInvRejectStsFullNm(document.form.tml_inv_rjct_sts_cd.value) : '';    
    
    var formObj = document.form;
    if (!ComIsNull(formObj.inv_no_tmp.value)) {
        formObj.inv_no.value = formObj.inv_no_tmp.value;
        formObj.vndr_seq.value = vndr_seq;
        retrieve('Y');
    }
}

/**
 * [W.H.T] set readonly
 * @return
 */
function setWhldTaxAmtMode() {
    var formObj = document.form;
    var tmp = '';
    tmp = formObj.whld_tax_amt_mode.value;
    if (tmp != undefined && tmp != null && tmp == 'Y') {
        WHLD_TAX_READONLY_MODE = false;
    } else {
        WHLD_TAX_READONLY_MODE = true;
    }
}

/**
 * [W.H.T] set readonly
 * @param {string}	YN_SET_BACKCOLOR	back color
 * @return
 */
function checkWhldTaxAmtMode(YN_SET_BACKCOLOR) {
    var formObj = document.form;
    formObj.whld_tax_amt.readOnly = WHLD_TAX_READONLY_MODE;
    if (YN_SET_BACKCOLOR != undefined && YN_SET_BACKCOLOR == 'Y') {
        tes_setBackColorAllTextTypeReadonly(setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
    }
}

/**
 * [Currency] set sheet data attribute
 * @return
 */
function setCalcColFormat() {
    resetSheetDataProperty(comboObjects[0].GetSelectCode());
}

/**
 * IBCombo Object adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param {combo}	combo_obj	combo object
 * @return
 */
function setComboObject(combo_obj) {
    comboObjects[comboCnt++] = combo_obj;
}

/**
 * set combo list
 * @param {combo}	comboObj	combo object
 * @param {int}		comboNo		combo index
 * @param {string}	combo_val	combo value
 * @param {string}	def_val		default value
 * @return
 */
function initCombo(comboObj, comboNo, combo_val, def_val) {
    var cnt = 0;
    switch (comboNo) {
        case 1:
            with(comboObj) {
                SetColAlign(0, "center");
                SetColWidth(0, "90");
                SetDropHeight(150);
                var tmp = '';
                if (combo_val != null) {
                    tmp = combo_val.split('|');
                }
                
                for (var i = 0; tmp != null && i < tmp.length; i++) {
                    InsertItem(cnt++, new String(tmp[i]), new String(tmp[i]));
                }
                
                if (ComIsNull(inv_no)) {
                    if (def_val != undefined && def_val != null && def_val != '') {
                        Code = def_val;
                        def_curr_cd = def_val != undefined && def_val != '' ? def_val : '';
                    } else {
                        Code = '';
                    }
                } else {
                    if (sheetObjects[4].RowCount() > 0 && (curr_cd.GetSelectCode() == null || curr_cd.GetSelectCode() == '')) {
                        curr_cd.SetSelectText(sheetObjects[4].GetCellValue(1, 'curr_cd'));
                        curr_cd.SetSelectCode(sheetObjects[4].GetCellValue(1, 'curr_cd'));
                        def_curr_cd = sheetObjects[4].GetCellValue(1, 'curr_cd') != null && sheetObjects[4].GetCellValue(1, 'curr_cd') != '' ? sheetObjects[4].GetCellValue(1, 'curr_cd') : '';
                    }
                }
            }
            break;

        case 2: //currency
            with(comboObj) {
                SetColAlign(0, "center");
                SetColWidth(0, 100);
                SetDropHeight(200);
                SetMultiSelect(true);

                var key = '';
                var val = '';
                for (var i = 0; combo_val != undefined && combo_val != null && i < combo_val.length; i++) {
                    if (combo_val[i] != undefined && combo_val[i] != null) key = combo_val[i];
                    else key = '';
                    if (def_val[i] != undefined && def_val[i] != null) val = def_val[i];
                    else val = '';
                    InsertItem(cnt++, key, key);
                }
            }
            break;
    }
}

/**
 * setting sheet initial values and header
 * adding case as numbers of counting sheets
 * @param {sheet}	sheetObj	
 * @param {int}		sheetNo		 
 * @return
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:   //t1sheet1 init
			with(sheetObj){
				//(31, 0, 0, true);
				var HeadTitle="||Seq.|CNTR No.|Type/Size|Gate In|Gate Out|F/M|I/O|TS|DG|B/B|Verify\nResult|Remarks|STS";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                KeyField:0,   CalcLogic:"" },
							{Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
							{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"inv_gate_in_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"inv_gate_out_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"locl_ts_ind_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_clss_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dscr_ind_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cntr_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"tml_so_cntr_list_seq",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no_split",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"vrfy_rslt_ind_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"modi_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"gate_in_td_dys",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"gate_out_td_dys",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"inv_stay_dys",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_gate_in_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_gate_out_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_stay_dys",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bl_no_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bl_no_tp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				
				SetEditable(1);
				SetColProperty("inv_gate_in_dt", {Format:"YmdHm"} );
				SetColProperty("inv_gate_out_dt", {Format:"YmdHm"} );
				SetColProperty("mvmt_gate_in_dt", {Format:"YmdHm"} );
				SetColProperty("mvmt_gate_out_dt", {Format:"YmdHm"} );
				SetColProperty("cntr_sty_cd", {ComboText:cntr_sty_cdCode, ComboCode:cntr_sty_cdCode} );
				SetColProperty("io_bnd_cd", {ComboText:io_bnd_cdCode, ComboCode:io_bnd_cdCode} );
				SetColProperty("locl_ts_ind_cd", {ComboText:'T|L', ComboCode:'T|L'} );
				SetColProperty("dcgo_clss_cd", {ComboText:dcgo_clss_cdCode, ComboCode:dcgo_clss_cdCode} );
				SetColProperty("bb_cgo_flg", {ComboText:'Y|N', ComboCode:'Y|N'} );
				SetSheetHeight(300);
			}
		break;
		
		case 2:   //t2sheet1 init
			with(sheetObj){
				// (31, 3, 0, true);
				var HeadTitle0="|Discrepancy Type| |Seq.|CNTR No.|Type/|F/M|Gate In|Gate In|G/I|Gate Out|Gate Out|G/O|Remarks";
				var HeadTitle1="|Discrepancy Type||Seq.||Size||MVMT|Invoice|Diff.|MVMT|Invoice|Diff.|";
				
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle0, Align:"Center"},
				{ Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							{Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"dscr_ind_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_gate_in_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"inv_gate_in_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"gate_in_td_dys",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_gate_out_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"inv_gate_out_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"gate_out_td_dys",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntr_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"tml_so_cntr_list_seq",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no_split",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"vrfy_rslt_ind_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"modi_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_clss_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"locl_ts_ind_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bl_no_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bl_no_tp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"inv_stay_dys",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_stay_dys",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 } ];
				
				InitColumns(cols);
				
				SetEditable(1);
				SetColProperty("inv_gate_in_dt", {Format:"YmdHm"} );
				SetColProperty("inv_gate_out_dt", {Format:"YmdHm"} );
				SetColProperty("mvmt_gate_in_dt", {Format:"YmdHm"} );
				SetColProperty("mvmt_gate_out_dt", {Format:"YmdHm"} );
				SetColProperty("dscr_ind_cd", {ComboText:dscr_ind_cdText, ComboCode:dscr_ind_cdCode} );
				SetColProperty("cntr_sty_cd", {ComboText:cntr_sty_cdCode, ComboCode:cntr_sty_cdCode} );
				SetColProperty("cntr_tpsz_cd", {ComboText:CNTR_TPSZ_CD, ComboCode:CNTR_TPSZ_CD} );
				SetHeaderRowHeight(10);
				SetCellBackColor(1,2,"#555555");
				SetRangeBackColor(1,4,1,13,"#555555");
				//SetRangeBackColor(1,10,1,11,"#555555");
				SetSheetHeight(300);
			}
		break;
		
		case 3:   //t3sheet1 init
			with(sheetObj){
				//(31, 5, 0, true);
				var HeadTitle="|Calculated Type|Cost Code|CNTR No.|Type/\nSize|I/O|DG.|Year\nMonth|Stay\nDays|F/Days|Paid\nDays|Exclude\nDays|Over\nDays|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remarks|3rd Party||";
				
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							{Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"calc_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_ind_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rev_yrmon",            KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"stay_dys",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"free_dys",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"paid_day",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"free_dy_xcld_dys",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"ovr_dys",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"vol_tr_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ctrt_rt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_xch_rt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"calc_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Popup",     Hidden:0, Width:15,   Align:"Left",    ColMerge:0,   SaveName:"n3pty_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"calc_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"lgs_cost_cd2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"calc_cost_grp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"fp_calc_prd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:1,   SaveName:"tml_so_dtl_seq",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"acct_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"curr_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"ovr_dys2",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"semi_auto_calc_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
				
				InitColumns(cols);
				
				SetEditable(1);
				SetColProperty("calc_tp_cd", {ComboText:"AutoCalculatedCost|ManualInputCost|SemiAutoInputCost", ComboCode:"A|M|S"} );
				SetColProperty("lgs_cost_cd", {ComboText:ST_A_LGS_COST_CD, ComboCode:ST_A_LGS_COST_CD} );
				SetColProperty("cntr_tpsz_cd", {ComboText:CNTR_TPSZ_CD, ComboCode:CNTR_TPSZ_CD} );
				SetColProperty("io_bnd_cd", {ComboText:io_bnd_cdCode, ComboCode:io_bnd_cdCode} );
				SetColProperty("vol_tr_ut_cd", {ComboText:vol_tr_ut_cdCode, ComboCode:vol_tr_ut_cdCode} );
				SetColProperty("dcgo_ind_cd", {ComboText:dcgo_clss_cdCode, ComboCode:dcgo_clss_cdCode} );
				SetSheetHeight(300);
			}
		break;
		
		case 4:   //t4sheet1 init
			with(sheetObj){
				//(27, 3, 0, true);
				var HeadTitle="|Calculated Type|Cost Code|Date|Stacking\nVol.|Vol. by\nInvoice|Differ|Free\nPool|Over\nVol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remarks|Year\nMonth ";
				
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							{Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"calc_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"wrk_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"stk_vol_qty",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_vol_qty",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"diff_vol_qty",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"fp_teu_qty",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:0,   SaveName:"ovr_vol_qty",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vol_tr_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ctrt_rt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_xch_rt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"calc_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"n3pty_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"calc_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"lgs_cost_cd2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"calc_cost_grp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_dtl_seq",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"fp_calc_prd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"acct_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"curr_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rev_yrmon",            KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				
				InitColumns(cols);
				
				SetEditable(1);
				SetColProperty("calc_tp_cd", {ComboText:"AutoCalculatedCost|ManualInputCost", ComboCode:"A|M"} );
				SetColProperty("lgs_cost_cd", {ComboText:ST_A_LGS_COST_CD, ComboCode:ST_A_LGS_COST_CD} );
				SetColProperty("vol_tr_ut_cd", {ComboText:vol_tr_ut_cdCode, ComboCode:vol_tr_ut_cdCode} );
				SetSheetHeight(300);
				
				//ShowSubSum("calc_tp_cd", "4|5|6|7|8|10|11", -1, false, false, -1, "calc_tp_cd=%s;lgs_cost_cd=TTL");
				
				//ShowSubSum([{StdCol:"calc_tp_cd", SumCols:"4|5|6|7|8|10|11", Sort:false, ShowCumulate:false, CaptionCol:1, OtherColText:"calc_tp_cd=%s;lgs_cost_cd=TTL"}]);
				//2016.10.11 SubSum Modify
				ShowSubSum([{StdCol:"calc_tp_cd", SumCols:"stk_vol_qty|inv_vol_qty|diff_vol_qty|fp_teu_qty|ovr_vol_qty|ctrt_rt|inv_xch_rt|inv_amt", Sort:false, ShowCumulate:false, CaptionCol:1, OtherColText:"calc_tp_cd=%s;lgs_cost_cd=TTL"}]);
			}
		break;
		
		case 5:   //main_hidden
			with(sheetObj){
				// (37, 1, 0, true);
				var HeadTitle="tml_so_ofc_cty_cd|tml_so_seq|inv_ofc_cd|cost_ofc_cd|inv_no|vndr_seq|yd_cd|yd_nm|curr_cd|ttl_inv_amt|vat_amt|ttl_calc_amt|fm_prd_dt|hld_flg|hld_rmk|to_prd_dt|tml_inv_tp_cd|tml_cost_grp_cd||sto_dys_ind_cd|iss_dt|rcv_dt|eff_dt|pay_due_dt|pay_flg|tml_inv_sts_cd|tml_inv_rjct_sts_cd|inv_cfm_dt|inv_rjct_dt|inv_rjct_rmk|cre_usr_id|cre_dt|upd_usr_id|upd_dt|dup_tp_cd|err_inv_no|whld_tax_amt|cost_cd_ftr_rmk";
				
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"inv_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cost_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"vndr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"yd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"yd_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"ttl_inv_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"vat_amt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"ttl_calc_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"fm_prd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"hld_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"hld_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"to_prd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_cost_grp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_calc_ind_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"sto_dys_ind_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"iss_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rcv_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"pay_due_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"pay_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_rjct_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"inv_cfm_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"inv_rjct_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"inv_rjct_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cre_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cre_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"upd_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"upd_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"dup_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"err_inv_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"whld_tax_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cost_cd_ftr_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
				
				InitColumns(cols);
				
				SetEditable(0);
			}
		break;
		
		case 6:   //rjct_hidden
			with(sheetObj){
				// (6, 1, 0, true);
				var HeadTitle="tml_so_ofc_cty_cd|tml_so_seq|inv_no|vndr_seq|tml_inv_rjct_sts_cd|inv_rjct_rmk";
				
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"vndr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_rjct_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"inv_rjct_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				
				InitColumns(cols);
				
				SetEditable(0);
				SetVisible(0);
			}
		break;
		
		case 7:   //conf_hidden
			with(sheetObj){
				// (6, 1, 0, true);
				var HeadTitle="tml_so_ofc_cty_cd|tml_so_seq|inv_no|vndr_seq|tml_inv_sts_cd|inv_cfm_dt";
				
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"inv_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"vndr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"inv_cfm_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				
				InitColumns(cols);
				
				SetEditable(0);
			}
		break;
		
		case 8:   //dupchk_hidden
			with(sheetObj){
				// (35, 1, 0, true);
				var HeadTitle="tml_so_ofc_cty_cd|tml_so_seq|inv_ofc_cd|cost_ofc_cd|inv_no|vndr_seq|yd_cd|yd_nm|curr_cd|ttl_inv_amt|vat_amt|ttl_calc_amt|fm_prd_dt|hld_flg|hld_rmk|to_prd_dt|tml_inv_tp_cd|tml_cost_grp_cd|tml_calc_ind_cd|sto_dys_ind_cd|iss_dt|rcv_dt|eff_dt|pay_due_dt|pay_flg|tml_inv_sts_cd|tml_inv_rjct_sts_cd|inv_cfm_dt|inv_rjct_dt|tml_agmt_ofc_cty_cd|tml_agmt_seq|tml_agmt_ver_no|inv_rjct_rmk|cre_usr_id|cre_dt|upd_usr_id|upd_dt";
				
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"inv_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cost_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"vndr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"yd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"yd_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"ttl_inv_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"vat_amt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"ttl_calc_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"fm_prd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"hld_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"hld_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"to_prd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_cost_grp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_calc_ind_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"sto_dys_ind_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"iss_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rcv_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"pay_due_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"pay_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_rjct_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"inv_cfm_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"inv_rjct_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"inv_rjct_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cre_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cre_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"upd_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"upd_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"dup_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				
				InitColumns(cols);		
				SetEditable(0);
			}
		break;
		
		case 9:   //t5sheet1 init
			with(sheetObj){
				// (31, 5, 0, true);
				var HeadTitle="|Calculated Type|Cost Code|EQ No.|Type/\nSize|I/O|Year\nMonth|Stay\nDays|F/Days|Paid\nDays|Exclude\nDays|Over\nDays|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remarks|3rd Party||";
				
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							{Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"calc_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"eq_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rev_yrmon",            KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"stay_dys",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"free_dys",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"paid_day",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"free_dy_xcld_dys",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"ovr_dys",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"vol_tr_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ctrt_rt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_xch_rt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"calc_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Popup",     Hidden:0, Width:15,   Align:"Left",    ColMerge:0,   SaveName:"n3pty_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"calc_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"lgs_cost_cd2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"calc_cost_grp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"fp_calc_prd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:1,   SaveName:"tml_so_dtl_seq",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"acct_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"curr_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"ovr_dys2",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"semi_auto_calc_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"eq_knd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
				
				InitColumns(cols);
				
				SetEditable(1);
				SetColProperty("calc_tp_cd", {ComboText:"AutoCalculatedCost|ManualInputCost|SemiAutoInputCost", ComboCode:"A|M|S"} );
				SetColProperty("eq_tpsz_cd", {ComboText:EQ_TPSZ_CD, ComboCode:EQ_TPSZ_CD} );
				SetColProperty("io_bnd_cd", {ComboText:io_bnd_cdCode, ComboCode:io_bnd_cdCode} );
				SetColProperty("vol_tr_ut_cd", {ComboText:vol_tr_ut_cdCode, ComboCode:vol_tr_ut_cdCode} );               
				SetSheetHeight(300);
			}
		break;         
	}    
}

/**
 * manual cost_cd retireve
 * @return
 */
function getCalcStorageManualCostCode() {
    // Storage Invoice get manual cost_cd
   	// document.form.yd_chr_inv_tp_cd.value = 'ST';
	// tes_getInputValue('calcStorageComboItems', SEARCH08, 'yd_chr_inv_tp_cd|yd_fcty_tp_cfs_flg|yd_fcty_tp_rail_rmp_flg|yd_oshp_cd', '');
}

/**
 * manual cost_cd retireve
 * @return
 */
function getCalcStorageEqManualCostCode() {
    // Storage Invoice get manual cost_cd
   	// document.form.yd_chr_inv_tp_cd.value = 'SE';
	// tes_getInputValue('calcStorageEqComboItems', SEARCH08, 'yd_chr_inv_tp_cd|yd_fcty_tp_cfs_flg|yd_fcty_tp_rail_rmp_flg|yd_oshp_cd', '');
}

/**
 * set Free Pool & Day Cost Code
 * @param {sheet}	sheet	ibsheet
 * @return
 */
function setCalcStorageManualCostCode(sheet) {
    var formObj = document.form;
    for (var i = 1; i <= sheet.RowCount(); i++) {
        if (sheet.GetCellValue(i, 'calc_tp_cd') == 'M' || sheet.GetCellValue(i, 'calc_tp_cd') == 'S') {
            org_val = sheet.GetCellValue(i, 'lgs_cost_cd');
            org_sts = sheet.GetRowStatus(i);
            sheet.CellComboItem(i, 'lgs_cost_cd', { ComboText: formObj.calcStorageComboItems.value, ComboCode: formObj.calcStorageComboItems.value });
            sheet.SetCellValue(i, 'lgs_cost_cd', sheet.GetCellValue(i, 'lgs_cost_cd2'));
            if (sheet.GetCellValue(i, 'lgs_cost_cd') == null || sheet.GetCellValue(i, 'lgs_cost_cd').trim() == '') {
                sheet.SetCellValue(i, 'lgs_cost_cd', org_val);
            }
            sheet.SetRowStatus(i, org_sts);
        }
    }
}

/**
 * set Eq Cost Code
 * @param {sheet}	sheet	ibsheet
 * @return
 */
function setCalcStorageEqManualCostCode(sheet) {
    var formObj = document.form;
    for (var i = 1; i <= sheet.RowCount(); i++) {
        if (sheet.GetCellValue(i, 'calc_tp_cd') == 'M' || sheet.GetCellValue(i, 'calc_tp_cd') == 'S') {
            org_val = sheet.GetCellValue(i, 'lgs_cost_cd');
            org_sts = sheet.GetRowStatus(i);
            sheet.CellComboItem(i, 'lgs_cost_cd', { ComboText: formObj.calcStorageEqComboItems.value, ComboCode: formObj.calcStorageEqComboItems.value });
            sheet.SetCellValue(i, 'lgs_cost_cd', sheet.GetCellValue(i, 'lgs_cost_cd2'));
            if (sheet.GetCellValue(i, 'lgs_cost_cd') == null || sheet.GetCellValue(i, 'lgs_cost_cd').trim() == '') {
                sheet.SetCellValue(i, 'lgs_cost_cd', org_val);
            }
            sheet.SetRowStatus(i, org_sts);
        }
    }
}

/**
 * COIN, DSCP, CALC.ByDay sheet data delete
 * @return
 */
function removeStorageInvoice01() {
    var formObj = document.form;
    var sheetObj = sheetObjects[0];
    sheetObj.ShowDebugMsg(false);
    formObj.f_cmd.value = REMOVE01;
    var param = sheetObj.GetSaveString();
    var sXml = sheetObj.GetSaveData("ESD_TES_0009GS.do", param + '&' + tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
    sheetObj.LoadSaveData(sXml, true);
    /*
    var sxml0=sheetObj.GetEtcData("sxml0");
    var sxml1=sheetObj.GetEtcData("sxml1");
    var sxml2=sheetObj.GetEtcData("sxml2");
    sheetObjects[0].RemoveEtcData();
    sheetObjects[0].LoadSearchData(sxml0,{Sync:1} );
    sheetObjects[1].LoadSearchData(sxml1,{Sync:1} );
    sheetObjects[2].LoadSearchData(sxml2,{Sync:1} );
    */
    sXml = null; //sxml0=null; sxml1=null; sxml2=null;
    sheetObjects[0].RemoveAll();
    sheetObjects[1].RemoveAll();
    sheetObjects[2].RemoveAll();
}

/**
 * CALC.ByPool sheet data delete
 * @return
 */
function removeStorageInvoice02() {
    var formObj = document.form;
    var sheetObj = sheetObjects[3];
    sheetObj.ShowDebugMsg(false);
    formObj.f_cmd.value = REMOVE02;
    var param = sheetObj.GetSaveString();
    var sXml = sheetObj.GetSaveData("ESD_TES_0009GS.do", param + '&' + tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
    sheetObj.LoadSaveData(sXml, true);
    /*
    var sxml0=sheetObj.GetEtcData("sxml0");
    sheetObjects[0].RemoveEtcData();
    sheetObjects[0].LoadSearchData(sxml0,{Sync:1} );
    */
    sXml = null; //sxml0=null;
    sheetObjects[3].RemoveAll();
    sheetObjects[8].RemoveAll();
}

/**
 * CALC.By EQ sheet data delete
 * @return
 */
function removeStorageInvoice03() {
    var formObj = document.form;
    var sheetObj = sheetObjects[8];
    sheetObj.ShowDebugMsg(false);
    formObj.f_cmd.value = REMOVE07;
    var param = sheetObj.GetSaveString();
    var sXml = sheetObj.GetSaveData("ESD_TES_0009GS.do", param + '&' + tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
    sheetObj.LoadSaveData(sXml, true);

    sXml = null; //sxml0=null;
    sheetObjects[8].RemoveAll();
}

/**
 * Modification check data
 * @return
 */
function t1sheet1_ChkMod() {
    if (sheetObjects[0].RowCount() > 0 && hasAutoCalcData(sheetObjects[2])) {
        for (var i = sheetObjects[0].HeaderRows(); i < (sheetObjects[0].HeaderRows() + sheetObjects[0].RowCount()); i++) {
            if (sheetObjects[0].GetCellValue(i, 'ibflag') == 'U' &&
                (sheetObjects[0].GetCellValue(i, 'cntr_sty_cd') != sheetObjects[0].CellSearchValue(i, 'cntr_sty_cd') ||
                    sheetObjects[0].GetCellValue(i, 'io_bnd_cd') != sheetObjects[0].CellSearchValue(i, 'io_bnd_cd') ||
                    sheetObjects[0].GetCellValue(i, 'dcgo_clss_cd') != sheetObjects[0].CellSearchValue(i, 'dcgo_clss_cd') ||
                    sheetObjects[0].GetCellValue(i, 'bb_cgo_flg') != sheetObjects[0].CellSearchValue(i, 'bb_cgo_flg'))) {
                return true;
            }
        }
    }
    return false;
}

/**
 * Exist check CalcTMNL, CalcByDay, CalcByPool sheet data 
 * @return
 */
function hasAllCalcData() {
    var sheet_obj;
    for (var i = 3; i <= 4; i++) {
        sheet_obj = eval('document.t' + i + 'sheet1');
        if (sheet_obj != null && sheet_obj.RowCount() > 0) {
            return true;
        }
    }
    return false;
}

/**
 * check Calculated Type
 * @param {sheet}	sheetObj	ibsheet
 * @return
 */
function hasAutoCalcData(sheetObj) {
    if (sheetObj.RowCount() > 0) {
        for (var i = sheetObj.HeaderRows(); i < (sheetObj.HeaderRows() + sheetObj.RowCount()); i++) {
            if (sheetObj.GetCellValue(i, 'calc_tp_cd') == 'A') {
                return true;
            }
        }
    }
    return false;
}

/**
 * check Calculated Type 
 * @param {sheet}	sheetObj	ibsheet
 * @return
 */
function hasManualCalcData(sheetObj) {
    if (sheetObj.RowCount() > 0) {
        for (var i = sheetObj.HeaderRows(); i < (sheetObj.HeaderRows() + sheetObj.RowCount()); i++) {
            if (sheetObj.GetCellValue(i, 'calc_tp_cd') == 'M') {
                return true;
            }
        }
    }
    return false;
}

/**
 * remove auto calc data
 * @return
 */
function removeAutoCalcData() {
    if (sheetObjects[2].RowCount() > 0) {
        for (var i = (sheetObjects[2].HeaderRows() + sheetObjects[2].RowCount() - 1); i >= sheetObjects[2].HeaderRows(); i--) {
            if (sheetObjects[2].GetCellValue(i, 'calc_tp_cd') != undefined && sheetObjects[2].GetCellValue(i, 'calc_tp_cd') == 'A') {
                sheetObjects[2].RowDelete(i, false);
            }
        }
    }
    var formObj = document.form;
    var sheetObj = sheetObjects[2];
    sheetObjects[2].ShowDebugMsg(false);
    formObj.f_cmd.value = REMOVE03;
    var sXml = sheetObjects[2].GetSaveData("ESD_TES_0009GS.do", tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
    //		sheetObjects[2].LoadSaveXml(sXml,true);
    var arrXml = sXml.split("|$$|");
    sheetObjects[2].LoadSaveData(arrXml[0], true);
    sXml = null;
}

/**
 * Calc.ByPool sheet auto calc ROW delete
 * @return
 */
function removeAutoCalcData2() {
    if (sheetObjects[3].RowCount() > 0) {
        for (var i = (sheetObjects[3].HeaderRows() + sheetObjects[3].RowCount() - 1); i >= sheetObjects[3].HeaderRows(); i--) {
            if (sheetObjects[3].GetCellValue(i, 'calc_tp_cd') != undefined && sheetObjects[3].GetCellValue(i, 'calc_tp_cd') == 'A') {
                sheetObjects[3].RowDelete(i, false);
            }
        }
    }
    var formObj = document.form;
    var sheetObj = sheetObjects[3];
    sheetObjects[3].ShowDebugMsg(false);
    formObj.f_cmd.value = REMOVE05;
    var sXml = sheetObjects[3].GetSaveData("ESD_TES_0009GS.do", tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
    sheetObjects[3].LoadSaveData(sXml, true);
    sXml = null;
}

/**
 * Calc.ByDay, Calc.ByPool sheet auto calc ROW delete
 * @return
 */
function removeAutoCalcDataAll() {
    if (sheetObjects[2].RowCount() > 0) {
        for (var i = (sheetObjects[2].HeaderRows() + sheetObjects[2].RowCount() - 1); i >= sheetObjects[2].HeaderRows(); i--) {
            if (sheetObjects[2].GetCellValue(i, 'calc_tp_cd') != undefined && sheetObjects[2].GetCellValue(i, 'calc_tp_cd') == 'A') {
                sheetObjects[2].RowDelete(i, false);
            }
        }
    }
    
    if (sheetObjects[3].RowCount() > 0) {
        for (var i = (sheetObjects[3].HeaderRows() + sheetObjects[3].RowCount() - 1); i >= sheetObjects[3].HeaderRows(); i--) {
            if (sheetObjects[3].GetCellValue(i, 'calc_tp_cd') != undefined && sheetObjects[3].GetCellValue(i, 'calc_tp_cd') == 'A') {
                sheetObjects[3].RowDelete(i, false);
            }
        }
    }
    var formObj = document.form;
    var sheetObj = sheetObjects[2];
    sheetObjects[2].ShowDebugMsg(false);
    formObj.f_cmd.value = REMOVE04;
    var sXml = sheetObjects[2].GetSaveData("ESD_TES_0009GS.do", tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
    //		sheetObjects[2].LoadSaveXml(sXml,true);	
    sXml = null;
}

/**
 * Calc.ByDay, Calc.ByPool sheet clac ROW delete
 * @return
 */
function removeCalcDataAll() {
    if (sheetObjects[2].RowCount() > 0) {
        for (var i = (sheetObjects[2].HeaderRows() + sheetObjects[2].RowCount() - 1); i >= sheetObjects[2].HeaderRows(); i--) {
            sheetObjects[2].RowDelete(i, false);
        }
    }
    
    if (sheetObjects[3].RowCount() > 0) {
        for (var i = (sheetObjects[3].HeaderRows() + sheetObjects[3].RowCount() - 1); i >= sheetObjects[3].HeaderRows(); i--) {
            sheetObjects[3].RowDelete(i, false);
        }
    }
    
    var formObj = document.form;
    var sheetObj = sheetObjects[2];
    sheetObjects[2].ShowDebugMsg(false);
    formObj.f_cmd.value = REMOVE06;
    sheetObjects[2].GetSaveData("ESD_TES_0009GS.do", tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
}


/**
 * Container List(CO, DC), COst Calc. List(FD, FP) handling sheet process
 * @param {sheet}	sheetObj	ibsheet
 * @param {form}	formObj		form object
 * @param {int}	sAction		
 * @return
 */
function doActionIBSheetAllSheets(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            
            formObj.f_cmd.value = SEARCHLIST03;
            var sXml = sheetObj.GetSearchData("ESD_TES_0009GS.do", tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
            var arrXml = sXml.split("|$$|");
            
            for (var i = 0; arrXml != null && i < arrXml.length; i++) {
                if (arrXml.length - 1 == i) {
                    sheetObjects[8].LoadSearchData(arrXml[i], { Sync: 1 });
                } else {
                    sheetObjects[i].LoadSearchData(arrXml[i], { Sync: 1 });
                }
            }
            //				sheetObj.LoadSearchXml(sXml);
            //				var sxml0 = sheetObj.EtcData("sxml0");
            //				var sxml1 = sheetObj.EtcData("sxml1");
            //				var sxml2 = sheetObj.EtcData("sxml2");
            //				var sxml3 = sheetObj.EtcData("sxml3");
            //				
            //				sheetObj.RemoveEtcData();
            //				
            //				sheetObjects[0].LoadSearchXml(sxml0);
            //				sheetObjects[1].LoadSearchXml(sxml1);
            //				sheetObjects[2].LoadSearchXml(sxml2);
            //				sheetObjects[3].LoadSearchXml(sxml3);
            //				sXml=null; sxml0=null; sxml1=null; sxml2=null; sxml3=null;
            break;
            
        case IBSAVE: //Save
            break;
    }
}

/**
 * Verification Sheet, Discrepancy handling sheet process
 * @param {sheet}	sheetObj	ibsheet
 * @param {form}	formObj		form object
 * @param {int}		sAction		
 * @param {string}	SKIP_CHK
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            
            formObj.f_cmd.value = SEARCHLIST;
            var sXml = sheetObj.GetSearchData("ESD_TES_0009GS.do", tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
            var arrXml = sXml.split("|$$|");
            
            for (var i = 0; arrXml != null && i < arrXml.length; i++) {
                sheetObjects[i].LoadSearchData(arrXml[i], { Sync: 1 });
            }
            //				sheetObj.LoadSearchXml(sXml);
            //				var sxml0 = sheetObj.EtcData("sxml0");
            //				var sxml1 = sheetObj.EtcData("sxml1");
            //				sheetObj.RemoveEtcData();
            //				sheetObjects[0].LoadSearchXml(sxml0);
            //				sheetObjects[1].LoadSearchXml(sxml1);
            //				sXml=null; sxml0=null; sxml1=null;
            break;
            
        case IBSAVE: //Save
            if (!checkPeriodModified()) {
                return false;
            }
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            var params = new Array();
            params[0] = sheetObjects[0].GetSaveString(false, true);
            params[1] = sheetObjects[1].GetSaveString(false, true);
            var sheets = new Array();
            sheets[0] = sheetObjects[0];
            sheets[1] = sheetObjects[1];
            if (!tes_isModified(sheets, params)) {
                ComShowMessage(ComGetMsg('TES23018'));
                break;
            }
            if (t1sheet1_ChkMod()) {
                if (confirm(ComGetMsg('TES24070'))) {
                    removeAutoCalcData();
                } else {
                    return false;
                }
            }
            formObj.f_cmd.value = MULTI;
            var sXml = sheetObjects[0].GetSaveData("ESD_TES_0009GS.do", getSaveString(params) + '&' + tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
            var arrXml = sXml.split("|$$|");
            for (var i = 0; arrXml != null && i < arrXml.length; i++) {
                sheetObjects[i].LoadSearchData(arrXml[i], { Sync: 1 });
            }
            //				sheetObj.LoadSaveXml(sXml,true);
            //				//ComShowMessage('sXml:\n'+sXml); //return false;
            //				var sxml0 = sheetObjects[0].EtcData("sxml0");
            //				var sxml1 = sheetObjects[0].EtcData("sxml1");
            //				sheetObjects[0].RemoveEtcData();
            //				sheetObjects[0].LoadSearchXml(sxml0);
            //				sheetObjects[1].LoadSearchXml(sxml1);
            //				sXml=null; sxml0=null; sxml1=null;
            break;
            
        case IBINSERT:
            var Row = sheetObj.DataInsert();
            break;
            
        case IBDOWNEXCEL:
            if (sheetObj.RowCount() < 1) { //no data	
                ComShowCodeMessage("COM132501");
            } else {
                //        			 sheetObj.Down2Excel({ HiddenColumn:{HiddenColumn:-1}});
                sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1 });
            }
            break;
    }
}

/**
 * handling sheet process
 * @param {sheet}	sheetObj	ibsheet
 * @param {form}	formObj		form object
 * @param {int}		sAction		
 * @return
 */
function doActionIBSheet2(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            formObj.f_cmd.value = SEARCHLIST;
            var sXml = sheetObj.GetSearchData("ESD_TES_0009GS.do", tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
            sheetObj.LoadSearchData(sXml, { Sync: 1 });
            var sxml0 = sheetObj.GetEtcData("sxml0");
            var sxml1 = sheetObj.GetEtcData("sxml1");
            sheetObj.RemoveEtcData();
            sheetObjects[0].LoadSearchData(sxml0, { Sync: 1 });
            sheetObjects[1].LoadSearchData(sxml1, { Sync: 1 });
            sXml = null;
            sxml0 = null;
            sxml1 = null;
            break;

        case IBSEARCH_ASYNC02:
            formObj.f_cmd.value = MULTI05;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0009GS.do", tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
            var arrXml = searchXml.split("|$$|");
            sheetObjects[0].LoadSearchData(arrXml[0], { Sync: 0 });
            sheetObjects[1].LoadSearchData(arrXml[1], { Sync: 0 });
            searchXml = null;
            arrXml[0] = null;
            arrXml[1] = null;
            break;

        case IBSAVE: //Save
            if (!checkPeriodModified()) {
                return false;
            }
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            formObj.f_cmd.value = MULTI;
            var param = sheetObj.GetSaveString(false, false);
            //				ComShowMessage(decodeURI(param));
            var sXml = sheetObj.GetSaveData("ESD_TES_0009GS.do", param + '&' + tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
            //				ComShowMessage(savexml);
            sheetObj.LoadSaveData(sXml, true);
            var sxml0 = sheetObj.GetEtcData("sxml0");
            var sxml1 = sheetObj.GetEtcData("sxml1");
            sheetObj.RemoveEtcData();
            sheetObjects[0].LoadSearchData(sxml0, { Sync: 1 });
            sheetObjects[1].LoadSearchData(sxml1, { Sync: 1 });
            sXml = null;
            sxml0 = null;
            sxml1 = null;
            break;
            
        case IBINSERT:
            var Row = sheetObj.DataInsert();
            
            break;
            
        case IBDOWNEXCEL:
            if (sheetObj.RowCount() < 1) { //no data	
                ComShowCodeMessage("COM132501");
            } else {
                //        			 sheetObj.Down2Excel({ HiddenColumn:{HiddenColumn:-1}});
                sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1 });
            }
            break;
    }
}

/**
 * handling sheet process
 * @param {sheet}	sheetObj	ibsheet
 * @param {form}	formObj		form object
 * @param {int}	sAction		
 * @param {string}	SKIP_CHK	or not
 * @return
 */
function doActionIBSheet3(sheetObj, formObj, sAction, SKIP_CHK) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            /*
                            if (!validateForm(sheetObj,formObj,sAction)){
            			        return false;
            			    }
            */
            if (formObj.cost_calc_mode.value == 'COST_CALC_MODE') {
                formObj.f_cmd.value = SEARCHLIST01;
                var sXml = sheetObj.GetSearchData("ESD_TES_0009GS.do", tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
                sheetObj.LoadSearchData(sXml, { Sync: 1 });

            } else {
                formObj.f_cmd.value = SEARCHLIST02;
                var sXml = sheetObj.GetSearchData("ESD_TES_0009GS.do", tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
                sheetObj.LoadSearchData(sXml, { Sync: 1 });

            }
            break;

        case IBSEARCH_ASYNC02:
            formObj.f_cmd.value = SEARCH18;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0009GS.do", tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
            var dbCount = ComGetEtcData(searchXml, "db_cnt");
            var dbInv = ComGetEtcData(searchXml, "inv_no");

            if (dbCount > 0) { //db이 존재한다면
                if (ComShowConfirm("Double Billing Inv [ " + dbInv + " ] exists. Do you want to continue?")) {
                    formObj.cost_calc_mode.value = 'COST_CALC_MODE';
                    doActionIBSheet3(sheetObjects[2], formObj, IBSEARCH);
                    formObj.cost_calc_mode.value = ''; //반드시 다시 초기화 해야합니다.

                } else {
                    tabObjects[0].SetSelectedIndex(1);
                    doActionIBSheet2(sheetObjects[1], formObj, IBSEARCH_ASYNC02);
                }

            } else {
                formObj.cost_calc_mode.value = 'COST_CALC_MODE';
                doActionIBSheet3(sheetObjects[2], formObj, IBSEARCH);
                formObj.cost_calc_mode.value = ''; //반드시 다시 초기화 해야합니다.
            }
            break;

        case IBSAVE: //Save
            if (!checkPeriodModified()) {
                return false;
            }
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            if (checkCurrCDchange()) {
                ComShowMessage(ComGetMsg('TES24035', 'Currency'));
                return false;
            }
            var colnms = 'lgs_cost_cd';
            var arr_colnms = colnms.split('|');
            var pass = true;
            for (var i = 1; i <= sheetObj.RowCount(); i++) {
                if ((sheetObj.GetCellValue(i, 'calc_tp_cd') == 'M' || sheetObj.GetCellValue(i, 'calc_tp_cd') == 'S') && (sheetObj.GetRowStatus(i) == 'I' || sheetObj.GetRowStatus(i) == 'U')) {
                    if (sheetObj.GetCellValue(i, 'rev_yrmon') == null || sheetObj.GetCellValue(i, 'rev_yrmon') == "") {
                        ComShowMessage("Please input Year-Month(YYYYMM).");
                        return false;
                    }
                    if (sheetObj.GetCellValue(i, 'inv_amt') == null || parseFloat(sheetObj.GetCellValue(i, 'inv_amt')) == 0) {
                        ComShowMessage("Please input Amount.");
                        return false;
                    }

                    if (sheetObj.GetCellValue(i, 'calc_rmk') == null || sheetObj.GetCellValue(i, 'calc_rmk').trim() == "") {
                        ComShowMessage("Please,  must input remarks.");
                        return false;
                    }

                    for (var j = 0; j < arr_colnms.length; j++) {
                        if (sheetObj.GetCellValue(i, arr_colnms[j]) == null || sheetObj.GetCellValue(i, arr_colnms[j]) == '') {
                            pass = false;
                            sheetObj.SetRowFontColor(i, "#FF0000");
                        } else {
                            if (pass) {
                                sheetObj.SetRowFontColor(i, sheetObj.GetDataFontColor());
                            }
                        }
                    }
                }
            }
            if (!pass) {
                ComShowMessage(ComGetMsg('TES23029'));
                return false;
            }
            try {
                formObj.f_cmd.value = MULTI01;
                formObj.dtl_by_day_only_mode.value = 'Y';
                var params = new Array();
                params[0] = sheetObjects[2].GetSaveString(false, true);
                var sheets = new Array();
                sheets[0] = sheetObjects[2];
                //sheets[sheets.length] = sheetObjects[8]; //n3rd_hidden
                //params[params.length] = sheetObjects[8].GetSaveString(false ,false);
                if (SKIP_CHK == undefined || SKIP_CHK == null || SKIP_CHK == '' || SKIP_CHK != 'Y') {
                    if (!tes_isModified(sheets, params)) {
                        ComShowMessage(ComGetMsg('TES23018'));
                        break;
                    }
                }
                var sXml = sheetObj.GetSaveData("ESD_TES_0009GS.do", getSaveString(params) + '&' + tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
                formObj.dtl_by_day_only_mode.value = '';
                sheetObj.LoadSaveData(sXml, true);
                //					var arrXml = sXml.split("|$$|"); 
                //					
                //					for (var i=0; arrXml!=null && i<arrXml.length; i++) {
                //						sheetObjects[i].LoadSearchXml(arrXml[i]); 
                //					}
                //					var sxml0; var sxml1;
                //					sxml0 = sheetObj.EtcData('sxml0');
                //					sheetObj.RemoveEtcData();
                //					sheetObjects[2].LoadSearchXml(sxml0);
                //					sXml=null; sxml0=null;
            } catch (e) {
                formObj.dtl_by_day_only_mode.value = '';
            }
            break;
            
        case IBINSERT:
            var Row = sheetObj.DataInsert(-1);
            sheetObj.SetCellValue(Row, "calc_cost_grp_cd", "SD", 0);
            sheetObj.SetCellValue(Row, "calc_tp_cd", "M", 0);
            sheetObj.SetCellValue(Row, "cntr_tpsz_cd", "", 0);
            sheetObj.SetCellValue(Row, "io_bnd_cd", "", 0);
            sheetObj.SetCellValue(Row, "dcgo_ind_cd", "", 0);
            sheetObj.SetCellValue(Row, "vol_tr_ut_cd", "", 0);
            sheetObj.SetCellValue(Row, "inv_xch_rt", 1, 0);
            setShtCellsEditable(sheetObj, Row, 'lgs_cost_cd|rev_yrmon|stay_dys|ctrt_rt|inv_amt|inv_xch_rt', 'Y');
            setShtCellsEditable(sheetObj, Row, 'free_dys|paid_day|free_dy_xcld_dys', 'N');
            sheetObj.CellComboItem(Row, 'lgs_cost_cd', { ComboText: formObj.calcStorageComboItems.value, ComboCode: formObj.calcStorageComboItems.value });
            sheetObj.SetCellValue(Row, "lgs_cost_cd", "", 0);
            
            setDefaultCurrencyFormToSheet(sheetObj, Row, "curr_cd");//2016.10.11 Currency FormToSheet Add
            break;
            
        case IBDELETE:
            if (sheetObj.RowCount() > 0) {
                var Row = sheetObj.GetSelectRow();
                var calc_tp_cd = sheetObj.GetCellValue(Row, "calc_tp_cd");
                if (calc_tp_cd != null && (calc_tp_cd == 'M' || calc_tp_cd == 'S')) {
                    if (sheetObj.GetCellValue(Row, "tml_so_dtl_seq") == null || sheetObj.GetCellValue(Row, "tml_so_dtl_seq") == '' || parseInt(sheetObj.GetCellValue(Row, "tml_so_dtl_seq"), 10) == 0) {
                        sheetObj.RowDelete(Row, false);
                    } else {
                        sheetObj.SetRowStatus(Row, 'D');
                        sheetObj.SetRowHidden(Row, 1);
                        sheetObj.SetCellValue(Row, "inv_amt", 0, 0);
                    }
                    document.form.t3sht_tot_inv_amt.value = getShtTotCalcAmt(sheetObj, 'inv_amt');
                } else if (calc_tp_cd != null && (calc_tp_cd == 'A')) {
                    ComShowMessage(ComGetMsg('TES21046'));
                }
            }
            //t1sheet1_SetColmnEditable();
            break;
            
        case IBDOWNEXCEL:
            if (sheetObj.RowCount() < 1) { //no data	
                ComShowCodeMessage("COM132501");
            } else {
                //        			 sheetObj.Down2Excel({ HiddenColumn:{HiddenColumn:-1}});
                sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1 });
            }
            break;
    }
}

/**
 * handling sheet process
 * @param {sheet}	sheetObj	ibsheet
 * @param {form}	formObj		form object
 * @param {int}		sAction		
 * @param {string}	SKIP_CHK	
 * @return
 */
function doActionIBSheet4(sheetObj, formObj, sAction, SKIP_CHK) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            formObj.f_cmd.value = SEARCHLIST02;
            formObj.dtl_by_pool_only_mode.value = 'Y';
            var sXml = sheetObj.GetSearchData("ESD_TES_0009GS.do", tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
            sheetObj.LoadSearchData(sXml, { Append: 1, Sync: 1 });
            //			sheetObj.LoadSearchXml(sXml); 
            //			var sxml0 = sheetObj.EtcData('sxml0');
            //			sheetObj.RemoveEtcData();
            //			sheetObjects[3].LoadSearchXml(sxml0);
            //			sXml=null; 
            //			sxml0=null;
            formObj.dtl_by_pool_only_mode.value = '';
            break;

        case IBSAVE: //Save
            if (!checkPeriodModified()) {
                return false;
            }
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            if (checkCurrCDchange()) {
                ComShowMessage(ComGetMsg('TES24035', 'Currency'));
                return false;
            }
            var colnms = 'lgs_cost_cd';
            var arr_colnms = colnms.split('|');
            var pass = true;
            for (var i = 1; i <= sheetObj.RowCount(); i++) {
                if (sheetObj.GetCellValue(i, 'calc_tp_cd') == 'M' && (sheetObj.GetRowStatus(i) == 'I' || sheetObj.GetRowStatus(i) == 'U')) {
                    if (sheetObj.GetCellValue(i, 'wrk_dt') == null || sheetObj.GetCellValue(i, 'wrk_dt') == "") {
                        ComShowMessage("Please input Date.");
                        return false;
                    }
                    if (sheetObj.GetCellValue(i, 'inv_amt') == null || parseFloat(sheetObj.GetCellValue(i, 'inv_amt')) == 0) {
                        ComShowMessage("Please input Amount.");
                        return false;
                    }

                    if (sheetObj.GetCellValue(i, 'calc_rmk') == null || sheetObj.GetCellValue(i, 'calc_rmk').trim() == "") {
                        ComShowMessage("Please,  must input remarks in manual calculation type.");
                        return false;
                    }
                    for (var j = 0; j < arr_colnms.length; j++) {
                        if (sheetObj.GetCellValue(i, arr_colnms[j]) == null || sheetObj.GetCellValue(i, arr_colnms[j]) == '') {
                            pass = false;
                            sheetObj.SetRowFontColor(i, "#FF0000");
                        } else {
                            if (pass) {
                                sheetObj.SetRowFontColor(i, sheetObj.GetDataFontColor());
                            }
                        }
                    }
                }
            }
            if (!pass) {
                ComShowMessage(ComGetMsg('TES23029'));
                return false;
            }
            try {
                /* CostCalc.ByPool만 저장 */
                formObj.f_cmd.value = MULTI01;
                formObj.dtl_by_pool_only_mode.value = 'Y';
                var params = new Array();
                params[0] = sheetObjects[3].GetSaveString(false, true);
                var sheets = new Array();
                sheets[0] = sheetObjects[3];
                //sheets[sheets.length] = sheetObjects[9]; //n3rd_hidden
                //params[params.length] = sheetObjects[9].GetSaveString(false ,false);
                if (SKIP_CHK == undefined || SKIP_CHK == null || SKIP_CHK == '' || SKIP_CHK != 'Y') {
                    if (!tes_isModified(sheets, params)) {
                        ComShowMessage(ComGetMsg('TES23018'));
                        break;
                    }
                }
                var sXml = sheetObj.GetSaveData("ESD_TES_0009GS.do", getSaveString(params) + '&' + tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
                formObj.dtl_by_pool_only_mode.value = '';
                sheetObj.LoadSaveData(sXml, true);
                //				var sxml0;
                //				sxml0=sheetObj.GetEtcData('sxml0');
                //				sheetObj.RemoveEtcData();
                //				sheetObjects[3].LoadSearchData(sxml0,{Sync:1} );
                sXml = null;
                sxml0 = null;
            } catch (e) {
                formObj.dtl_by_pool_only_mode.value = '';
            }
            break;

        case IBINSERT:
            var Row = sheetObj.DataInsert(-1);
            sheetObj.SetCellValue(Row, "calc_cost_grp_cd", "SP", 0);
            sheetObj.SetCellValue(Row, "calc_tp_cd", "M", 0);
            sheetObj.SetCellValue(Row, "cntr_tpsz_cd", "", 0);
            sheetObj.SetCellValue(Row, "io_bnd_cd", "", 0);
            sheetObj.SetCellValue(Row, "fp_calc_prd_cd", "D", 0);
            sheetObj.SetCellValue(Row, "vol_tr_ut_cd", "", 0);
            sheetObj.SetCellValue(Row, "inv_xch_rt", 1, 0);

            sheetObj.CellComboItem(Row, 'lgs_cost_cd', { ComboText: formObj.calcStorageComboItems.value, ComboCode: formObj.calcStorageComboItems.value });
            sheetObj.SetCellValue(Row, "lgs_cost_cd", "", 0);
            
            setDefaultCurrencyFormToSheet(sheetObj, Row, "curr_cd");//2016.10.11 Currency FormToSheet Add

            var SaveJson = sheetObj.GetSaveJson(1);
            sheetObj.LoadSearchData(SaveJson, { Sync: 1 })

            setShtCellsEditable(sheetObj, Row, 'lgs_cost_cd|wrk_dt|stk_vol_qty|inv_vol_qty|diff_vol_qty|fp_teu_qty|ovr_vol_qty|vol_tr_ut_cd|ctrt_rt|inv_amt|inv_xch_rt', 'Y');

            //			t4sheet1_ShowSubSum(sheetObj);
            t4sheet1_TotCalcAmt(sheetObj);
            break;

        case IBDELETE:
            if (sheetObj.RowCount() > 0) {
                var Row = sheetObj.GetSelectRow();
                var calc_tp_cd = sheetObj.GetCellValue(Row, "calc_tp_cd");
                if (calc_tp_cd != null && calc_tp_cd == 'M') {
                    if (sheetObj.GetCellValue(Row, "tml_so_dtl_seq") == null || sheetObj.GetCellValue(Row, "tml_so_dtl_seq") == '' || parseInt(sheetObj.GetCellValue(Row, "tml_so_dtl_seq"), 10) == 0) {
                        sheetObj.RowDelete(Row, false);
                    } else {
                        sheetObj.SetRowStatus(Row, 'D');
                        sheetObj.SetRowHidden(Row, 1);
                        sheetObj.SetCellValue(Row, "inv_amt", 0, 0);
                    }
                    //					t4sheet1_ShowSubSum(sheetObj);
                    t4sheet1_TotCalcAmt(sheetObj);
                } else if (calc_tp_cd != null && (calc_tp_cd == 'A')) {
                    ComShowMessage(ComGetMsg('TES21046'));
                }
            }
            break;
            
        case IBDOWNEXCEL:
            if (sheetObj.RowCount() < 1) { //no data	
                ComShowCodeMessage("COM132501");
            } else {
                //    			 sheetObj.Down2Excel({ HiddenColumn:{HiddenColumn:-1}});
                sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1 });
            }
            break;
    }
}

/**
 * Main Hidden handling sheet process
 * @param {sheet}	sheetObj	ibsheet
 * @param {form}	formObj		form
 * @param {int}		sAction		action code
 * @return
 */
function doActionMainHiddenSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch("ESD_TES_0009GS.do", tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'), { Sync: 1 });
            break;

        case IBSEARCH_ASYNC04:
            formObj.f_cmd.value = SEARCH16;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0009GS.do", tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
            var ydNm = ComGetEtcData(searchXml, "yd_nm");
            formObj.yd_nm.value = ydNm;
            validateYardCode();
            searchXml = null;
            break;

        case IBSEARCH_ASYNC05:
            formObj.f_cmd.value = SEARCH17;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0001GS.do", tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            var vndrNm = ComGetEtcData(searchXml, "vndr_nm");
            formObj.vndr_seq_nm.value = vndrNm;
            searchXml = null;
            break;

        case IBSAVE: //Save
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            if (sheetObj.RowCount() == 0) {
                if (fnChkSearchForm()) {
                    formObj.f_cmd.value = SEARCH;
                    sheetObjects[7].RemoveAll();
                    sheetObjects[7].DoSearch("ESD_TES_0009GS.do", tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
                    if (sheetObjects[7].RowCount() == 0) {
                        //							ComShowMessage("ADD... rowcnt: "+sheetObj.RowCount);
                        formObj.f_cmd.value = ADD;
                    } else if (sheetObjects[7].RowCount() == 1) {
                        //ComShowMessage("DUP!!!" + sheetObjects[7].RowCount);
                        if (sheetObjects[7].GetCellValue(1, 'tml_inv_tp_cd') == 'TM') {
                            ComShowMessage(ComGetMsg('TES23030', 'Terminal invoice'));
                            sheetObjects[4].RemoveAll();
                            return false;
                        } else if (sheetObjects[7].GetCellValue(1, 'tml_inv_tp_cd') == 'ON') {
                            ComShowMessage(ComGetMsg('TES23030', 'On-dock invoice'));
                            sheetObjects[4].RemoveAll();
                            return false;
                        } else if (sheetObjects[7].GetCellValue(1, 'tml_inv_tp_cd') == 'OF') {
                            ComShowMessage(ComGetMsg('TES23030', 'Off-dock invoice'));
                            sheetObjects[4].RemoveAll();
                            return false;
                        }
                        if (!confirm(ComGetMsg('TES24071'))) {
                            sheetObjects[0].RemoveAll();
                            sheetObjects[1].RemoveAll();
                            sheetObjects[2].RemoveAll();
                            sheetObjects[3].RemoveAll();
                            sheetObjects[4].RemoveAll(); //main_hidden
                            sheetObjects[5].RemoveAll(); //rjct_hidden
                            sheetObjects[6].RemoveAll(); //conf_hidden
                            sheetObjects[7].RemoveAll(); //dupchk_hidden
                            sheetObjects[8].RemoveAll();
                            setSheetsEnable(-1, false);
                            return false;
                        } else {
                            try {
                                formObj.f_cmd.value = SEARCH;
                                sheetObjects[4].DoSearch("ESD_TES_0009GS.do", tesFrmQryStr(formObj + "&" + 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
                                if (sheetObjects[4].RowCount() > 0) {
                                    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
                                    doActionIBSheet3(sheetObjects[2], formObj, IBSEARCH);
                                }
                                break;
                            } catch (e) {
                                ComShowMessage(e.message);
                                sheetObjects[0].RemoveAll();
                                sheetObjects[1].RemoveAll();
                                sheetObjects[2].RemoveAll();
                                sheetObjects[3].RemoveAll();
                                sheetObjects[4].RemoveAll(); //main_hidden
                                sheetObjects[5].RemoveAll(); //rjct_hidden
                                sheetObjects[6].RemoveAll(); //conf_hidden
                                sheetObjects[7].RemoveAll(); //dupchk_hidden
                                sheetObjects[8].RemoveAll();
                                setSheetsEnable(-1, false);
                                return false;
                            }
                        }
                    } else {
                        ComShowMessage(ComGetMsg('TES23031'));
                        sheetObjects[0].RemoveAll();
                        sheetObjects[1].RemoveAll();
                        sheetObjects[2].RemoveAll();
                        sheetObjects[3].RemoveAll();
                        sheetObjects[4].RemoveAll(); //main_hidden
                        sheetObjects[5].RemoveAll(); //rjct_hidden
                        sheetObjects[6].RemoveAll(); //conf_hidden
                        sheetObjects[7].RemoveAll(); //dupchk_hidden
                        sheetObjects[8].RemoveAll();
                        setSheetsEnable(-1, false);
                        return false;
                    }
                } else {
                    ComShowMessage(ComGetMsg('TES23032', 'VNDR Code', 'Inv.No'));
                    return false;
                }
            } else if (sheetObj.RowCount() == 1) {
                if (formObj.vndr_seq.value == tes_lpad(sheetObj.GetCellValue(1, 'vndr_seq'), 6, 0) && formObj.inv_no.value == sheetObj.GetCellValue(1, 'inv_no')) {
                    formObj.f_cmd.value = MODIFY;
                } else {
                    ComShowMessage(ComGetMsg('TES21035')); //ComShowMessage('[err]');
                    return false;
                    //formObj.f_cmd.value = ADD;
                }
            } else {
                ComShowMessage(ComGetMsg('TES23031'));
                sheetObjects[0].RemoveAll();
                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();
                sheetObjects[3].RemoveAll();
                sheetObjects[4].RemoveAll(); //main_hidden
                sheetObjects[5].RemoveAll(); //rjct_hidden
                sheetObjects[6].RemoveAll(); //conf_hidden
                sheetObjects[7].RemoveAll(); //dupchk_hidden
                sheetObjects[8].RemoveAll();
                setSheetsEnable(-1, false);
                return false;
            }
            
            formObj.ttl_inv_amt.value = tes_deleteComma(formObj.ttl_inv_amt.value);
            formObj.vat_amt.value = tes_deleteComma(formObj.vat_amt.value);
            formObj.whld_tax_amt.value = tes_deleteComma(formObj.whld_tax_amt.value);
            var param = sheetObj.GetSaveString();
            var savexml = sheetObj.GetSaveData("ESD_TES_0009GS.do", param + '&' + tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
            if (savexml != "") {
                sheetObj.RemoveAll();
                sheetObj.LoadSaveData(savexml, { Sync: 1 });
            }
            break;
            
        case IBINSERT:
            var Row = sheetObj.DataInsert();
            break;
            
        case IBDOWNEXCEL:
            if (sheetObj.RowCount() < 1) { //no data	
                ComShowCodeMessage("COM132501");
            } else {
                //        			 sheetObj.Down2Excel({ HiddenColumn:{HiddenColumn:-1}});
                sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1 });
            }
            break;
    }
}

/**
 * Reject Hidden handling sheet process
 * @param {sheet}	sheetObj	ibsheet
 * @param {form}	formObj		form
 * @param {int}	sAction		action code
 * @return
 */
function doActionRejectHiddenSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH:
            break;
            
        case IBSAVE:
            formObj.f_cmd.value = MODIFY01;
            var savexml = sheetObj.GetSaveData("ESD_TES_0009GS.do", tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
            sheetObj.LoadSaveData(savexml, true);
            break;
    }
}

/**
 * validation check [Each. Rate]
 * @param {sheet}	sheets	Cost Calc. sheets
 * @return
 */
function checkInvXchRt(sheets) {
    var returnValue = true;
    var curr_cd_hdr = curr_cd.GetSelectCode();
    for (var i = 0; i < sheets.length; i++) {
        for (var j = sheets[i].HeaderRows(); sheets[i] != null && sheets[i].RowCount() > 0 && j < (sheets[i].HeaderRows() + sheets[i].RowCount()); j++) {
            if (sheets[i].GetCellValue(j, 'calc_tp_cd') == 'A') {
                if (curr_cd_hdr != undefined && curr_cd_hdr != null && curr_cd_hdr != '' &&
                    sheets[i].GetCellValue(j, 'curr_cd') != undefined && sheets[i].GetCellValue(j, 'curr_cd') != null && sheets[i].GetCellValue(j, 'curr_cd') != '' &&
                    sheets[i].GetCellValue(j, 'curr_cd') != curr_cd_hdr && parseFloat(sheets[i].GetCellValue(j, 'inv_xch_rt')) <= 0) {
                    sheets[i].SetCellBackColor(j, 'inv_xch_rt', "#FF9999");
                    returnValue = false;
                }
            }
        }
    }
    return returnValue;
}

/**
 * Confirm  Hidden handling sheet process
 * @param {sheet}	sheetObj	ibsheet
 * @param {form}	formObj		form
 * @param {int}	sAction		action code
 * @return
 */
function doActionConfirmHiddenSheet(sheetObj, formObj, sAction) {
    //confirm
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSAVE: //Save
            if (sheetObjects[2].RowCount() <= 0 && sheetObjects[3].RowCount() <= 0 && sheetObjects[8].RowCount() <= 0) {
                ComShowMessage(ComGetMsg('TES23033'));
                return false;
            }
            var sheets = new Array();
            sheets[0] = sheetObjects[0];
            sheets[1] = sheetObjects[1];
            var params = new Array();
            params[0] = sheetObjects[0].GetSaveString(false, false);
            params[1] = sheetObjects[1].GetSaveString(false, false);
            if (tes_isModified(sheets, params)) {
                if (!confirm(ComGetMsg('TES23034'))) {
                    return false;
                }
            }
            var sheets2 = new Array();
            sheets2[0] = sheetObjects[2];
            sheets2[1] = sheetObjects[3];
            if (!checkInvXchRt(sheets2)) {
                ComShowMessage(ComGetMsg('TES21026', 'Exch.Rate'));
                return false;
            }
            //INV AMT의 일치여부
            if (formObj.ttl_inv_amt.value == null || formObj.ttl_inv_amt.value == '') {
                formObj.ttl_inv_amt.value = 0;
            }
            //var ttl_inv_amt = parseFloat(sheetObjects[4].GetCellValue(1,'ttl_inv_amt'));
            var ttl_inv_amt = tes_deleteComma(formObj.ttl_inv_amt.value);
            if (isNaN(parseFloat(tes_deleteComma(formObj.ttl_inv_amt.value)))) {
                ComShowMessage(ComGetMsg('TES24008', 'INV AMT'));
                return false;
            }
            var total_inv_amt = 0;
            if (formObj.t3sht_tot_inv_amt.value != undefined && formObj.t3sht_tot_inv_amt.value != null &&
                formObj.t3sht_tot_inv_amt.value != '' && !isNaN(tes_deleteComma(formObj.t3sht_tot_inv_amt.value))) {
                total_inv_amt = total_inv_amt + parseFloat(tes_deleteComma(formObj.t3sht_tot_inv_amt.value)) * 1000000;;
            }
            if (formObj.t4sht_tot_inv_amt.value != undefined && formObj.t4sht_tot_inv_amt.value != null &&
                formObj.t4sht_tot_inv_amt.value != '' && !isNaN(tes_deleteComma(formObj.t4sht_tot_inv_amt.value))) {
                total_inv_amt = total_inv_amt + parseFloat(tes_deleteComma(formObj.t4sht_tot_inv_amt.value)) * 1000000;;
            }
            if (formObj.t5sht_tot_inv_amt.value != undefined && formObj.t5sht_tot_inv_amt.value != null &&
                formObj.t5sht_tot_inv_amt.value != '' && !isNaN(tes_deleteComma(formObj.t5sht_tot_inv_amt.value))) {
                total_inv_amt = total_inv_amt + parseFloat(tes_deleteComma(formObj.t5sht_tot_inv_amt.value)) * 1000000;;
            }
            total_inv_amt /= 1000000;
            //ComShowMessage('ttl_inv_amt:'+ttl_inv_amt+' / total_inv_amt:'+total_inv_amt+' -- '+formObj.t3sht_tot_inv_amt.value+' / '+formObj.t4sht_tot_inv_amt.value);
            if (ttl_inv_amt != total_inv_amt) {
                ComShowMessage(ComGetMsg('TES24037', 'INV AMT', 'AMT'));
                return false;
            }
            doActionMainHiddenSheet(sheetObjects[4], formObj, IBSAVE);
            doActionIBSheet3(sheetObjects[2], formObj, IBSAVE, 'Y');
            doActionIBSheet4(sheetObjects[3], formObj, IBSAVE, 'Y');
            doActionIBSheet5(sheetObjects[8], formObj, IBSAVE, 'Y');
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            formObj.confirm_mode.value = 'CONFIRM';
            formObj.f_cmd.value = SEARCH01;
            var param = sheetObj.GetSaveString();
            var savexml = sheetObj.GetSaveData("ESD_TES_0009GS.do", param + '&' + tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
            if (savexml != "") {
                sheetObj.RemoveAll();
                sheetObj.LoadSaveData(savexml, true);
            }

            break;
    }
}

/**
 * handling sheet process
 * @param {sheet}	sheetObj	ibsheet
 * @param {form}	formObj		form object
 * @param {int}	sAction		
 * @param {string}	SKIP_CHK	or not
 * @return
 */
function doActionIBSheet5(sheetObj, formObj, sAction, SKIP_CHK) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (formObj.cost_calc_mode.value == 'COST_CALC_MODE') {
                formObj.f_cmd.value = SEARCHLIST01;
                var sXml = sheetObj.GetSearchData("ESD_TES_0009GS.do", tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
                sheetObj.LoadSearchData(sXml, { Sync: 1 });
            } else {
                formObj.f_cmd.value = SEARCHLIST02;
                var sXml = sheetObj.GetSearchData("ESD_TES_0009GS.do", tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
                sheetObj.LoadSearchData(sXml, { Sync: 1 });
            }
            break;
            
        case IBSAVE: //Save
            if (!checkPeriodModified()) {
                return false;
            }
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            if (checkCurrCDchange()) {
                ComShowMessage(ComGetMsg('TES24035', 'Currency'));
                return false;
            }
            var colnms = 'lgs_cost_cd';
            var arr_colnms = colnms.split('|');
            var pass = true;
            for (var i = 1; i <= sheetObj.RowCount(); i++) {
                if ((sheetObj.GetCellValue(i, 'calc_tp_cd') == 'M' || sheetObj.GetCellValue(i, 'calc_tp_cd') == 'S') && (sheetObj.GetRowStatus(i) == 'I' || sheetObj.GetRowStatus(i) == 'U')) {
                    if (sheetObj.GetCellValue(i, 'rev_yrmon') == null || sheetObj.GetCellValue(i, 'rev_yrmon') == "") {
                        ComShowMessage("Please input Year-Month(YYYYMM).");
                        return false;
                    }
                    if (sheetObj.GetCellValue(i, 'inv_amt') == null || parseFloat(sheetObj.GetCellValue(i, 'inv_amt')) == 0) {
                        ComShowMessage("Please input Amount.");
                        return false;
                    }

                    if (sheetObj.GetCellValue(i, 'calc_rmk') == null || sheetObj.GetCellValue(i, 'calc_rmk').trim() == "") {
                        ComShowMessage("Please,  must input remarks.");
                        return false;
                    }

                    for (var j = 0; j < arr_colnms.length; j++) {
                        if (sheetObj.GetCellValue(i, arr_colnms[j]) == null || sheetObj.GetCellValue(i, arr_colnms[j]) == '') {
                            pass = false;
                            sheetObj.SetRowFontColor(i, "#FF0000");
                        } else {
                            if (pass) {
                                sheetObj.SetRowFontColor(i, sheetObj.GetDataFontColor());
                            }
                        }
                    }
                }
            }
            if (!pass) {
                ComShowMessage(ComGetMsg('TES23029'));
                return false;
            }
            try {
                formObj.f_cmd.value = MULTI01;
                formObj.dtl_by_eq_only_mode.value = 'Y';
                var params = new Array();
                params[0] = sheetObjects[8].GetSaveString(false, true);
                var sheets = new Array();
                sheets[0] = sheetObjects[8];
                if (SKIP_CHK == undefined || SKIP_CHK == null || SKIP_CHK == '' || SKIP_CHK != 'Y') {
                    if (!tes_isModified(sheets, params)) {
                        ComShowMessage(ComGetMsg('TES23018'));
                        break;
                    }
                }
                var sXml = sheetObj.GetSaveData("ESD_TES_0009GS.do", getSaveString(params) + '&' + tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
                formObj.dtl_by_eq_only_mode.value = '';
                sheetObj.LoadSaveData(sXml, true);
            } catch (e) {
                formObj.dtl_by_eq_only_mode.value = '';
            }
            break;
            
        case IBINSERT:
            var Row = sheetObj.DataInsert(-1);
            sheetObj.SetCellValue(Row, "calc_cost_grp_cd", "EQ", 0);
            sheetObj.SetCellValue(Row, "calc_tp_cd", "M", 0);
            sheetObj.SetCellValue(Row, "eq_tpsz_cd", "", 0);
            sheetObj.SetCellValue(Row, "io_bnd_cd", "", 0);
            sheetObj.SetCellValue(Row, "dcgo_ind_cd", "", 0);
            sheetObj.SetCellValue(Row, "vol_tr_ut_cd", "", 0);
            sheetObj.SetCellValue(Row, "inv_xch_rt", 1, 0);
            setShtCellsEditable(sheetObj, Row, 'lgs_cost_cd|rev_yrmon|stay_dys|ctrt_rt|inv_amt|inv_xch_rt', 'Y');
            setShtCellsEditable(sheetObj, Row, 'free_dys|paid_day|free_dy_xcld_dys', 'N');
            sheetObj.CellComboItem(Row, 'lgs_cost_cd', { ComboText: formObj.calcStorageEqComboItems.value, ComboCode: formObj.calcStorageEqComboItems.value });
            sheetObj.SetCellValue(Row, "lgs_cost_cd", "", 0);

            setDefaultCurrencyFormToSheet(sheetObj, Row, "curr_cd");//2016.10.11 Currency FormToSheet Add
            break;
            
        case IBDELETE:
            if (sheetObj.RowCount() > 0) {
                var Row = sheetObj.GetSelectRow();
                var calc_tp_cd = sheetObj.GetCellValue(Row, "calc_tp_cd");
                if (calc_tp_cd != null && (calc_tp_cd == 'M' || calc_tp_cd == 'S')) {
                    if (sheetObj.GetCellValue(Row, "tml_so_dtl_seq") == null || sheetObj.GetCellValue(Row, "tml_so_dtl_seq") == '' || parseInt(sheetObj.GetCellValue(Row, "tml_so_dtl_seq"), 10) == 0) {
                        sheetObj.RowDelete(Row, false);
                    } else {
                        sheetObj.SetRowStatus(Row, 'D');
                        sheetObj.SetRowHidden(Row, 1);
                        sheetObj.SetCellValue(Row, "inv_amt", 0, 0);
                    }
                    document.form.t5sht_tot_inv_amt.value = getShtTotCalcAmt(sheetObj, 'inv_amt');
                } else if (calc_tp_cd != null && (calc_tp_cd == 'A')) {
                    ComShowMessage(ComGetMsg('TES21046'));
                }
            }
            break;
            
        case IBDOWNEXCEL:
            if (sheetObj.RowCount() < 1) { //no data	
                ComShowCodeMessage("COM132501");
            } else {
                sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1 });
            }
            break;
    }
}

/**
 * registering IBTab Object as list adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 * @param tab_obj
 * @return
 */
function setTabObject(tab_obj) {
    tabObjects[tabCnt++] = tab_obj;
}

/**
 * set common tab
 * @param {tab}		tabObj		tab object
 * @param {int}		tabNo		tab index
 * @return
 */
function initTab(tabObj, tabNo) {
    switch (tabNo) {
        case 1:
            with(tabObj) {
                var cnt = 0;
                InsertItem("  Verification  ", "");
                InsertItem("  Discrepancy  ", "");
                InsertItem("Cost Calc.(SR by FD)", "");
                InsertItem("Cost Calc.(SR by FP)", "");
                InsertItem("Cost Calc.(SR by EQ)", "");
            }
            break;
    }
    if (!save_conf_01) {
        //			 tabObj.SetEnable(0);
        tabObj.enable = false;

    } else {
        //			 tabObj.enable=true;
        tabObj.enable = true;

    }
}

/**
 * tab change event
 * @param {tab}		tabObj		tab object
 * @param {int}		nItem		tab index
 * @return
 */
function tab1_OnChange(tabObj, nItem) {
    var objs = document.all.item("tabLayer");
    objs[nItem].style.display = "Inline";
    objs[beforetab].style.display = "none";
    objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
    beforetab = nItem;
}

/**
 * tab click event
 * @param {tab}		tabObj		tab object
 * @param {int}		tabNo		tab index
 * @return
 */
function tab1_OnClick(tabObj, tabNo) {
    if (save_conf_01) {
        //ComShowMessage("tab1_OnClick nItem:"+tabNo);
        switch (tabNo) {
            case 2:
                setCalcStorageManualCostCode(sheetObjects[2]);
                break;
                
            case 3:
                setCalcStorageManualCostCode(sheetObjects[3]);
                break;
                
            case 5:
                setCalcStorageEqManualCostCode(sheetObjects[8]);
                break;
        }
    }
}

/**
 * handling process for input validation
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {form} 	formObj		Form Object
 * @param {int}		sAction		
 * @return
 */
function validateForm(sheetObj, formObj, sAction) {
    with(formObj) {
        //            if (!isNumber(formObj.iPage)) {
        //                return false;
        //            }
    }
    return true;
}

/**
 * set enable sheet cell
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @return
 */
function setToDscpChkbxEnable(sheetObj) {
    if (sheetObj.RowCount() > 0) {
        //no support[check again]CLT 			for (i=1; i<sheetObj.Rows; i++)
        {
            if (sheetObj.GetCellValue(rownum, 'modi_flg') == 'Y') {
                sheetObj.SetCellEditable(rownum, arr_colnms[i], (to_sts != null && to_sts == 'Y' ? 1 : 0));
            }
        }
    }
}

/**
 * check sheet period modified
 * @return
 */
function checkPeriodModified() {
    var formObj = document.form;
    if (doSepRemove(formObj.fm_prd_dt.value, ' ') != doSepRemove(sheetObjects[4].GetCellValue(1, "fm_prd_dt"), ' ') ||
        doSepRemove(formObj.to_prd_dt.value, ' ') != doSepRemove(sheetObjects[4].GetCellValue(1, "to_prd_dt"), ' ')) {
        ComShowMessage(ComGetMsg('TES24038'));
        return false;
    }
    return true;
}

/**
 * main hidden sheet search end event
 * @param {ibsheet}	main_hidden main hidden sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function main_hidden_OnSearchEnd(main_hidden, ErrMsg) {
    var formObj = document.form;
    if (main_hidden.RowCount() == 1) {
        if (formObj.inv_ofc_cd == undefined || formObj.inv_ofc_cd.value == null || doSepRemove(formObj.inv_ofc_cd.value, ' ') == '') {
            ComShowMessage('No Inv OFC data is found in the session');
            return false;
        }
        if (main_hidden.GetCellValue(1, 'inv_ofc_cd') == undefined || main_hidden.GetCellValue(1, 'inv_ofc_cd') == null || doSepRemove(main_hidden.GetCellValue(1, 'inv_ofc_cd'), ' ') == '') {
            ComShowMessage('No Inv OFC data is retrieved');
            return false;
        }
        if (main_hidden.GetCellValue(1, 'inv_ofc_cd') != formObj.inv_ofc_cd.value) {
            //ComShowMessage("Inv OFC data retrieved don't match Inv OFC data in the session");
            //ComShowMessage("login Inv OFC is not authorized");
            ComShowMessage("No authority to correct/delete the invoice - Invoice office mismatch!");
            return false;
        }

        if (main_hidden.GetCellValue(1, 'tml_inv_rjct_sts_cd') == "RJ") {
            ComShowMessage('This is Rejected Invoice.');
            return false;
        }


        if (main_hidden.GetCellValue(1, 'tml_inv_tp_cd') != 'ST') {
            setHeaderKeyValueReadonly('N');
            setSheetsEnable(-1, false);
            formObj.reset();
            //tes_getInputValue('DB_DATE', COMMAND05, '', 'setPeriodFromTo');
            if (main_hidden.GetCellValue(1, 'tml_inv_tp_cd') == 'TM') {
                ComShowMessage(ComGetMsg('TES23030', 'Terminal invoice'));
            } else if (main_hidden.GetCellValue(1, 'tml_inv_tp_cd') == 'ON') {
                ComShowMessage(ComGetMsg('TES23030', 'On-dock invoice'));
            } else if (main_hidden.GetCellValue(1, 'tml_inv_tp_cd') == 'OF') {
                ComShowMessage(ComGetMsg('TES23030', 'Off-dock invoice'));
            } else {
                ComShowMessage(ComGetMsg('TES21034'));
            }
            return;
        }
        if (main_hidden.GetCellValue(1, 'tml_inv_sts_cd') != undefined && main_hidden.GetCellValue(1, 'tml_inv_sts_cd') == 'C') {
            if (confirm(ComGetMsg('TES23039'))) {
                formObj.f_cmd.value = SEARCH02;
                var param = main_hidden.GetSaveString();
                var savexml = sheetObjects[6].GetSaveData("ESD_TES_0009GS.do", param + '&' + tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
                sheetObjects[6].LoadSaveData(savexml, true);
                return false;
            } else {
                disablePage();
                return false;
            }
        } else if (main_hidden.GetCellValue(1, 'tml_inv_sts_cd') != undefined && main_hidden.GetCellValue(1, 'tml_inv_sts_cd') == 'A') {
            disablePage();
            ComShowMessage(ComGetMsg('TES24040'));
            return false;
        } else if (main_hidden.GetCellValue(1, 'tml_inv_sts_cd') != undefined && main_hidden.GetCellValue(1, 'tml_inv_sts_cd') == 'P') {
            disablePage();
            ComShowMessage(ComGetMsg('TES24041'));
            return false;
        } else if (main_hidden.GetCellValue(1, 'tml_inv_sts_cd') != undefined && main_hidden.GetCellValue(1, 'tml_inv_sts_cd') == 'R') {
        
        } else {
            disablePage();
            ComShowMessage(ComGetMsg('TES40051'));
            return false;
        }
        if (main_hidden.GetCellValue(1, 'tml_inv_rjct_sts_cd') != undefined && main_hidden.GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'RJ') {
            if (confirm(ComGetMsg('TES23042'))) {
                formObj.f_cmd.value = MODIFY03;
                var param = main_hidden.GetSaveString();
                var savexml = sheetObjects[5].GetSaveData("ESD_TES_0009GS.do", param + '&' + tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
                //ComShowMessage(savexml);
                sheetObjects[5].LoadSaveData(savexml, true);
                return false;
            } else {
                disablePage();
                return false;
            }
        }
        confirm_done = false;
        enableForm();
        setHeaderKeyValueReadonly('Y');
        save_conf_01 = true;
        setHdSheet2Form();

        validateVndrSeq();

        if (formObj.yd_cd.value != null && doSepRemove(formObj.yd_cd.value, ' ') != '') {
	        var rtnVal = getYdCdCostCdList(); // tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');	        
	        if(rtnVal.length > 0){
	        	checkValidYardCode(rtnVal);
	        }	            
	    }
	    
        //validateAgmtCurrCD();
        // agreement get status
        validateAgmtSts();
        var curr_tab_idx = 0;
        setSheetsEnable(-1, true);
        tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
        doActionIBSheetAllSheets(sheetObjects[0], formObj, IBSEARCH);
        // eBilling - E
        try {
            for (var i = 0; i < formObj.elements.length; i++) {
                if (formObj.elements[i].name != null && doSepRemove(formObj.elements[i].name, ' ') != '' &&
                    formObj.elements[i].name.substring(0, 9) == 'pre_cond_') {
                    with(formObj) {
                        if (eval((elements[i].name)).value != null && eval((elements[i].name)).value != '') {
                            document.all.PreInquiryCondLayer01.style.display = "inline";
                            break;
                        }
                    }
                }
            }
        } catch (e) {}
    } else if (main_hidden.RowCount() > 1) {
        ComShowMessage(ComGetMsg('TES24043'));
        return;
    } else if (main_hidden.RowCount() == 0) {
        if (!confirm(ComGetMsg('TES40031'))) {
            disablePage('Y');
            setSheetsEnable(-1, false);
            if (document.form.vndr_seq.value != null && document.form.vndr_seq.value != '') {
                document.form.inv_no.focus();
            } else {
                document.form.vndr_seq.focus();
            }
            return false;
        } else {
            enablePage('Y');
            if (document.form.vndr_seq.value != null && document.form.vndr_seq.value != '') {
                document.form.inv_no.focus();
            } else {
                document.form.vndr_seq.focus();
            }
        }
    } else {}
}

/**
 * main hidden sheet save end event
 * @param {ibsheet}	main_hidden main hidden sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function main_hidden_OnSaveEnd(main_hidden, ErrMsg) {
    if (ErrMsg != null && ErrMsg != "") {
        return false;
    }
    var formObj = document.form;
    if (main_hidden.RowCount() == 1) {
        if (main_hidden.GetCellValue(1, 'tml_inv_tp_cd') != 'ST') {
            setHeaderKeyValueReadonly('N');
            setSheetsEnable(-1, false);
            formObj.reset();
            //tes_getInputValue('DB_DATE', COMMAND05, '', 'setPeriodFromTo');
            if (main_hidden.GetCellValue(1, 'tml_inv_tp_cd') == 'TM') {
                ComShowMessage(ComGetMsg('TES23030', 'Terminal invoice'));
            } else if (main_hidden.GetCellValue(1, 'tml_inv_tp_cd') == 'ON') {
                ComShowMessage(ComGetMsg('TES23030', 'On-dock invoice'));
            } else if (main_hidden.GetCellValue(1, 'tml_inv_tp_cd') == 'OF') {
                ComShowMessage(ComGetMsg('TES23030', 'Off-dock invoice'));
            } else {
                ComShowMessage(ComGetMsg('TES21034'));
            }
            return;
        }
        if (main_hidden.GetCellValue(1, 'tml_inv_sts_cd') != undefined && main_hidden.GetCellValue(1, 'tml_inv_sts_cd') == 'C') {
            if (confirm(ComGetMsg('TES23039'))) {
                formObj.f_cmd.value = SEARCH02;
                var savexml = sheetObjects[7].GetSaveData("ESD_TES_0009GS.do", tesFrmQryStr(formObj, 'calcStorageComboItems|tmp_common_code|manual_lgs_cost_cd'));
                sheetObjects[7].LoadSaveData(savexml, true);
                return; // false;
            } else {
                disablePage();
                return; // false;
            }
        } else {
            confirm_done = false;
            enableForm();
            setHeaderKeyValueReadonly('Y');
        }
        save_conf_01 = true;
        if (formObj.confirm_mode.value != undefined && formObj.confirm_mode.value == 'CONFIRM') {
            setHdSheet2Form('CONFIRM');
        } else {
            setHdSheet2Form('SAVE');
        }
        if (formObj.yd_cd.value != null && doSepRemove(formObj.yd_cd.value, ' ') != '') {
           	var rtnVal = getYdCdCostCdList(); // tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');	        
	        if(rtnVal.length > 0){
	        	checkValidYardCode(rtnVal);
	        }	
        }
        validateAgmtSts();
        var curr_tab_idx = 0;
        setSheetsEnable(-1, true);
        tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
    } else if (main_hidden.RowCount() > 1) {
        ComShowMessage(ComGetMsg('TES24043'));
        return;
    } else {
        setHeaderKeyValueReadonly('N');
        setSheetsEnable(-1, false);
        formObj.reset();
        //tes_getInputValue('DB_DATE', COMMAND05, '', 'setPeriodFromTo');
        ComShowMessage(ComGetMsg('TES21034'));
        return;
    }
}

/**
 * reject hidden sheet search end event
 * @param {ibsheet}	rjct_hidden reject hidden sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function rjct_hidden_OnSaveEnd(rjct_hidden, ErrMsg) {
    var formObj = document.form;
    if (rjct_hidden.RowCount() == 1) {
        formObj.f_cmd_rjct.value = '';
        main_hidden.SetCellValue(1, 'tml_inv_rjct_sts_cd', rjct_hidden.GetCellValue(1, 'tml_inv_rjct_sts_cd'), 0);
        main_hidden.SetCellValue(1, 'inv_rjct_dt', rjct_hidden.GetCellValue(1, 'inv_rjct_dt'), 0);
        main_hidden.SetCellValue(1, 'inv_rjct_rmk', rjct_hidden.GetCellValue(1, 'inv_rjct_rmk'), 0);
        if (rjct_hidden.GetCellValue(1, 'tml_inv_rjct_sts_cd') != undefined && rjct_hidden.GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'RJ') {
            document.form.tml_inv_rjct_sts_cd.value = rjct_hidden.GetCellValue(1, 'tml_inv_rjct_sts_cd');
            document.form.tml_inv_rjct_sts_cd.title = tes_getInvRejectStsFullNm(rjct_hidden.GetCellValue(1, 'tml_inv_rjct_sts_cd'));
            disableAftRjct();
            ComShowMessage(ComGetMsg('TES23063'));
        } else {
            enableForm();
            retrieve();
        }
    } else if (rjct_hidden.RowCount() > 1) {
        ComShowMessage(ComGetMsg('TES40047'));
        disablePage();
        return false;
    } else {
        return false;
    }
}

/**
 * conf hidden sheet search end event
 * @param {ibsheet}	rjct_hidden reject hidden sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function conf_hidden_OnSaveEnd(conf_hidden, ErrMsg) {
    var formObj = document.form;
    if (conf_hidden.RowCount() == 1) {
        main_hidden.SetCellValue(1, 'tml_inv_sts_cd', conf_hidden.GetCellValue(1, 'tml_inv_sts_cd'), 0);
        main_hidden.SetCellValue(1, 'inv_cfm_dt', conf_hidden.GetCellValue(1, 'inv_cfm_dt'), 0);
        formObj.tml_inv_sts_cd.value = conf_hidden.GetCellValue(1, 'tml_inv_sts_cd');
        var inv_sts_cd = conf_hidden.GetCellValue(1, 'tml_inv_sts_cd');
        if (inv_sts_cd != undefined && inv_sts_cd == 'R') {
            inv_sts_cd = 'RC'
        } else if (inv_sts_cd != undefined && inv_sts_cd == 'C') {
            inv_sts_cd = 'CF'
        } else if (inv_sts_cd != undefined && inv_sts_cd == 'P') {
            inv_sts_cd = 'AP'
        } else if (inv_sts_cd != undefined && inv_sts_cd == 'A') {
            inv_sts_cd = 'AR'
        }
        formObj.tml_inv_sts_cd2.value = inv_sts_cd;
        formObj.tml_inv_sts_cd2.title = tes_getInvStsFullNm(inv_sts_cd);
        if (conf_hidden.GetCellValue(1, 'tml_inv_sts_cd') != undefined && conf_hidden.GetCellValue(1, 'tml_inv_sts_cd') == 'C') {
            confirm_done = true;
            disableAftConf();
            ComShowMessage(ComGetMsg('TES24044'));
        } else {
            confirm_done = false;
            enableForm();
            retrieve();
        }
        //setHeaderKeyValueReadonly('N');
        //tes_setBackColorAllTextTypeReadonly(document.form);
    } else if (conf_hidden.RowCount() > 1) {
        ComShowMessage(ComGetMsg('TES40046'));
        disablePage();
        return false;
    } else {
        return false;
    }
}

/**
 * (Verification) sheet mouse move event
 * @param {sheet}	t1sheet1	Verification sheet
 * @param {int}		Button		
 * @param {int}		Shift		
 * @param {long}	X			
 * @param {long}	Y			
 * @return
 */
function t1sheet1_OnMouseMove(t1sheet1, Button, Shift, X, Y) {    
    var row = t1sheet1.MouseRow();
    var col = t1sheet1.MouseCol();    
    var sDscrIndCd = t1sheet1.GetCellValue(row, "dscr_ind_cd");
    
    if (t1sheet1.ColSaveName(col) == "dscr_ind_cd" && row >= 1 && !ComIsNull(sDscrIndCd)) {         
        t1sheet1.SetToolTipText(row, col, getCodeName(sDscrIndCd, dscr_ind_cdCode, dscr_ind_cdText));
    }
}

/**
 * (Verification) sheet search end event
 * @param {sheet}	t1sheet1	Verification sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t1sheet1_OnSearchEnd(t1sheet1, ErrMsg) {
    setCoinShtStat();
    if (!chk_conf()) {
        disableSheetEditable(t1sheet1);
    }
    t1sheet1_SetChkBoxDisabled();
}

/**
 * (Verification) sheet save end event
 * @param {sheet}	t1sheet1	Verification sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t1sheet1_OnSaveEnd(t1sheet1, ErrMsg) {
    setCoinShtStat();
    if (!chk_conf()) {
        disableSheetEditable(t1sheet1);
    }
    t1sheet1_SetChkBoxDisabled();
}

//	function t1sheet1_SetColmnEditable(){
//		var EDITABLE_YN = '';
//		if (isAutoCalcDataExisting()){EDITABLE_YN = 'N';
//		} else {EDITABLE_YN = 'Y';
//		}
//		if (sheetObjects[0].RowCount > 0){
//			for (var i=1; i<=sheetObjects[0].RowCount; i++){
//				setShtCellsEditable(sheetObjects[0],i,'cntr_sty_cd|io_bnd_cd|dcgo_clss_cd|bb_cgo_flg',EDITABLE_YN,'EXCEPTION');
//			}
//		}
//	}

/**
 * (Verification) sheet check box disable
 * @return
 */
function t1sheet1_SetChkBoxDisabled() {
    var DISABLE_YN;
    if (isAutoCalcDataExisting()) {
        DISABLE_YN = 'Y';
    } else {
        DISABLE_YN = 'N';
    }
    if (sheetObjects[0].RowCount() > 0) {
        for (var i = 1; i <= sheetObjects[0].RowCount(); i++) {
            //				sheetObjects[0].SetCellValue(i, "cntr_rmk",ComToString( sheetObjects[0].GetCellValue(i, "cntr_rmk") ),0);
            //sheetObjects[0].CellEditable(i,'chk') = false;
            if (DISABLE_YN != null && DISABLE_YN == 'Y') {
                sheetObjects[0].SetCellEditable(i, 'chk', 0);
            } else {
                sheetObjects[0].SetCellEditable(i, 'chk', (sheetObjects[0].GetCellValue(i, 'modi_flg') == 'Y' ? 1 : 0));
            }
        }
    }
}

/**
 * (Discrepancy) sheet check box disable
 * @return
 */
function t2sheet1_SetChkBoxDisabled() {
    var DISABLE_YN;
    if (isAutoCalcDataExisting()) {
        DISABLE_YN = 'Y';
    } else {
        DISABLE_YN = 'N';
    }
    if (sheetObjects[1].RowCount() > 0) {
        for (var i = sheetObjects[1].HeaderRows(); i < (sheetObjects[1].HeaderRows() + sheetObjects[1].RowCount()); i++) {
            //				sheetObjects[1].SetCellValue(i, "cntr_rmk",ComToString( sheetObjects[1].GetCellValue(i, "cntr_rmk") ),0);
            //sheetObjects[1].CellEditable(i,'chk') = (DISABLE_YN!=null&&DISABLE_YN=='Y'?false:true);
            if (DISABLE_YN != null && DISABLE_YN == 'Y') {
                sheetObjects[1].SetCellEditable(i, 'chk', 0);
            } else {
                if (document.form.yd_cd.value != null && document.form.yd_cd.value != undefined && document.form.yd_cd.value.substring(0, 2) == 'US') {
                    sheetObjects[1].SetCellEditable(i, 'chk', (sheetObjects[1].GetCellValue(i, 'dscr_ind_cd') == 'DB' ? 0 : 1));
                }
            }
        }
    }
}

/**
 * exit check auto clac data
 * @return
 */
function isAutoCalcDataExisting() {
    if (sheetObjects[2].RowCount() > 0) {
        for (var i = sheetObjects[2].HeaderRows(); i < (sheetObjects[2].HeaderRows() + sheetObjects[2].RowCount()); i++) {
            if (sheetObjects[2].GetCellValue(i, 'calc_tp_cd') == 'A' && sheetObjects[2].GetCellValue(i, 'ibflag') != 'D') {
                //CALC tab에서 자동계산row가 발견되었다는 말... (단, (저장용 임시)삭제는 제외)
                return true;
            }
        }
    }
    return false;
}

/**
 * exite check auto calc data
 * @return
 */
function isModAutoCalcDataExisting() {
    if (sheetObjects[2].RowCount() > 0) {
        for (var i = sheetObjects[2].HeaderRows(); i < (sheetObjects[2].HeaderRows() + sheetObjects[2].RowCount()); i++) {
            if (sheetObjects[2].GetCellValue(i, 'calc_tp_cd') == 'A' && sheetObjects[2].GetCellValue(i, 'ibflag') != 'R') {
                return true;
            }
        }
    }
    return false;
}

/**
 * check auto calc
 * @param {sheet}	sheetObj	ibsheet
 * @return
 */
function isAutoCalcDataMod(sheetObj) {
    if (sheetObjects[2].RowCount() > 0) {
        for (var i = sheetObjects[2].HeaderRows(); i < (sheetObjects[2].HeaderRows() + sheetObjects[2].RowCount()); i++) {
            if ( //sheetObj.GetCellValue(i,'ibflag')!='I' ||
                (sheetObjects[2].GetCellValue(i, "tml_so_dtl_seq") != null && sheetObjects[2].GetCellValue(i, "tml_so_dtl_seq") != '' && parseInt(sheetObjects[2].GetCellValue(i, "tml_so_dtl_seq"), 10) > 0))
                return true;
        }
    }
    return false;
}

/**
 * sheet change event
 * @param {sheet}	t1sheet1	Verification sheet
 * @param {int}		row			row
 * @param {int}		col			col
 * @return
 */
function t1sheet1_OnChange(t1sheet1, row, col) {
    if (cntr_list_onchange_cnt == 1) {
        if (t1sheet1_ChkMod()) {
            cntr_list_onchange_cnt++;
            if (confirm(ComGetMsg('TES24070'))) {
                removeAutoCalcData();
            } else {
                return false;
            }
        }
    }
}

/**
 * tab Discrepancy sheet search end event
 * @param {sheet}	t2sheet1	Discrepancy sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t2sheet1_OnSearchEnd(t2sheet1, ErrMsg) {
    if (!chk_conf()) {
        disableSheetEditable(t2sheet1);
        return true;
    }
    t2sheet1_SetChkBoxDisabled();
    t2sheet1_ChkSrc();
}

/**
 * tab Discrepancy sheet save end event
 * @param {sheet}	t2sheet1	Discrepancy sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t2sheet1_OnSaveEnd(t2sheet1, ErrMsg) {
    if (!chk_conf()) {
        disableSheetEditable(t2sheet1);
    }
    //t2sheet1.ColumnSort("dscr_ind_cd|cntr_tpsz_cd|cntr_sty_cd","ASC");
    t2sheet1_SetChkBoxDisabled();
    t2sheet1_ChkSrc();
}

/**
 * DSCR_IND_CD - Discrepancy
 * @return
 */
function t2sheet1_ChkSrc() {
    for (var i = sheetObjects[1].HeaderRows(); i < (sheetObjects[1].HeaderRows() + sheetObjects[1].RowCount()); i++) {
        var sDscrIndCd = sheetObjects[1].GetCellValue(i, 'dscr_ind_cd');        
        if (sDscrIndCd == 'DT') {
            sheetObjects[1].SetCellBackColor(i, 'mvmt_gate_in_dt', "#FF9999");
            sheetObjects[1].SetCellBackColor(i, 'inv_gate_in_dt', "#FF9999");  
            sheetObjects[1].SetCellBackColor(i, 'mvmt_gate_out_dt', "#FF9999");
            sheetObjects[1].SetCellBackColor(i, 'inv_gate_out_dt', "#FF9999");   
                   
        } else if (sDscrIndCd == 'DE') { 
            sheetObjects[1].SetCellBackColor(i, 'mvmt_gate_in_dt', "#FF9999");
            sheetObjects[1].SetCellBackColor(i, 'inv_gate_in_dt', "#FF9999");
            
        } else if (sDscrIndCd == 'DS') { 
            sheetObjects[1].SetCellBackColor(i, 'mvmt_gate_out_dt', "#FF9999");
            sheetObjects[1].SetCellBackColor(i, 'inv_gate_out_dt', "#FF9999");
        
        } else if (sDscrIndCd == 'PD') {
            sheetObjects[1].SetCellBackColor(i, 'mvmt_gate_in_dt', "#FF9999");
            sheetObjects[1].SetCellBackColor(i, 'mvmt_gate_out_dt', "#FF9999");
            
        } else if (sDscrIndCd == 'NH') {
            sheetObjects[1].SetCellBackColor(i, 'cntr_no', "#FF9999");
            sheetObjects[1].SetCellBackColor(i, 'cntr_tpsz_cd', "#FF9999");
            
        } else if (sDscrIndCd == 'DB') {
            sheetObjects[1].SetCellBackColor(i, 'cntr_no', "#FF9999");
            
        } else if (sDscrIndCd == 'AM') {
            sheetObjects[1].SetCellBackColor(i, 'cntr_no', "#FF9999");
            sheetObjects[1].SetCellBackColor(i, 'mvmt_gate_in_dt', "#FF9999");
            sheetObjects[1].SetCellBackColor(i, 'mvmt_gate_out_dt', "#FF9999");
        }
    }
}

/**
 * tab - Discrepancy sheet click event
 * @param {sheet}	t2sheet1	Discrepancy sheet
 * @param {int}		Row			row
 * @param {int}		Col			col
 * @param {string}	Value		
 * @return
 */
function t2sheet1_OnClick(t2sheet1, Row, Col, Value) {
    //ComShowMessage('RowCount:' + t2sheet1.RowCount +  ' / HeaderRows:'+t2sheet1.HeaderRows + ' / Row:'+Row);
}

/**
 * tab - Discrepancy sheet double click event
 * @param {sheet}	sheetObj	Discrepancy sheet
 * @param {int}		row			row
 * @param {int}		col			col
 * @return
 */
function t2sheet1_OnDblClick(sheetObj, row, col) {
    if (sheetObj.ColSaveName(col) == "dscr_ind_cd") {
        var count = 0;
        var chkrow = "";
        while (true) {
            checkrow = sheetObj.FindText("dscr_ind_cd", sheetObj.GetCellText(row, col), count, -1);
            if (checkrow == "-1") break;
            if (chkrow != "") {
                chkrow = checkrow + "|" + chkrow;
            } else {
                chkrow = checkrow;
            }
            count = checkrow + 1;
        }
        chkrow = new String(chkrow);
        var arr = chkrow.split('|');
        var doit = false;
        for (var i = 0; i < arr.length; i++) {
            if (sheetObj.GetCellValue(arr[i], "chk") == 0) {
                doit = true;
                break;
            }
        }
        for (var i = 0; i < arr.length; i++) {
            if (doit) {
                sheetObj.SetCellValue(arr[i], "chk", 1, 0);
            } else {
                sheetObj.SetCellValue(arr[i], "chk", 0, 0);
            }
        }
    }
}

/**
 * DB (MAIN_HIDDEN) check CURR_CD
 * @return
 */
function checkCurrCDchange() {
    var main_sheet_obj = sheetObjects[4];
    if (main_sheet_obj.GetCellValue(1, 'curr_cd') == comboObjects[0].GetSelectCode()) {
        return false;
    } else {
        return true;
    }
}

/**
 * curr_cd change event
 * @param Index_Code
 * @param Text
 * @return
 */
function curr_cd_OnChange(Index_Code, Text) {
    //ComShowMessage('curr_cd_OnChange:'+comboObjects[0].Code);
    var formObj = document.form;
    var main_sheet_obj = sheetObjects[4];
    if (main_sheet_obj.RowCount() == 1) {
        if ((main_sheet_obj.GetCellValue(1, 'curr_cd') != comboObjects[0].GetSelectCode()) ||
            (formObj.curr_cd_tmp.value != undefined && formObj.curr_cd_tmp.value != null && formObj.curr_cd_tmp.value != '' && formObj.curr_cd_tmp.value != comboObjects[0].GetSelectCode())) {
            resetInputValue();
        }
        if (hasAllCalcData()) {
            if (formObj.curr_cd_tmp.value != comboObjects[0].GetSelectCode()) {
                if (!confirm('Currency가 변경되었습니다. \n\n Cost Calc.(SR by FD)와 Cost Calc.(SR by FP) Tab의 모든 Data를 삭제할까요?')) {
                    comboObjects[0].SetSelectText(formObj.curr_cd_tmp.value);
                    comboObjects[0].SetSelectCode(formObj.curr_cd_tmp.value);
                } else {
                    removeCalcDataAll();
                    resetSheetDataProperty(comboObjects[0].GetSelectCode());
                }
            }
        }
        formObj.curr_cd_tmp.value = comboObjects[0].GetSelectCode();
    }
}

/**
 * Initialization [Inv Amt], [TAX]
 * @return
 */
function resetInputValue() {
    var formObj = document.form;
    formObj.ttl_inv_amt.value = '';
    formObj.vat_amt.value = '';
}

/**
 * set [Currency] sheet data attribute
 * @param {string}		CURR_CD		Currency code
 * @return
 */
function resetSheetDataProperty(CURR_CD) {
    if (CURR_CD != undefined && tes_isNoDecimalPointCurrCD(CURR_CD)) {
        var cols = [{ Type: "Int",  Hidden: 0, Width: 70,  Align: "Right",  ColMerge: 0,   SaveName: "ctrt_rt",  KeyField: 0, CalcLogic: "",    Format: "Integer",  PointCount: 0,   UpdateEdit: 0, InsertEdit: 0 }, 
        			{ Type: "Int", Hidden: 0,  Width: 70,  Align: "Right", ColMerge: 0,  SaveName: "inv_amt", KeyField: 0, CalcLogic: "", Format: "Integer",  PointCount: 0,  UpdateEdit: 0,   InsertEdit: 0 }];
        sheetObjects[2].InitColumns(cols);
        sheetObjects[3].InitColumns(cols);

    } else {
        var cols = [{ Type: "Float", Hidden: 0,  Width: 70,	Align: "Right", ColMerge: 0, SaveName: "ctrt_rt",  KeyField: 0,  CalcLogic: "",    Format: "Float",   PointCount: 2,  UpdateEdit: 0,  InsertEdit: 0 }, 
        			{ Type: "Float",  Hidden: 0,  Width: 70,  Align: "Right", ColMerge: 0,  SaveName: "inv_amt", KeyField: 0,   CalcLogic: "",  Format: "Float",   PointCount: 2,  UpdateEdit: 0,  InsertEdit: 0 }];
        sheetObjects[2].InitColumns(cols);
        sheetObjects[3].InitColumns(cols);
    }

}

/**
 * Cost Calc.(FD) sheet change event
 * @param {sheet}	t3sheet1	Cost Calc.(FD) sheet
 * @param {int}		Row			Row Index
 * @param {int}		Col			Column Index
 * @param {string}	Value		
 * @return
 */
function t3sheet1_OnChange(t3sheet1, Row, Col, Value) {
	var sCurrCd = document.form.curr_cd.value;
	
    if (t3sheet1.GetCellValue(Row, 'calc_tp_cd') == 'M' && t3sheet1.GetCellValue(Row, 'lgs_cost_cd') == '') {
        ComShowMessage(ComGetMsg('TES23061'));
        return false;
    }
    var sName = t3sheet1.ColSaveName(Col);
    if (sName == "lgs_cost_cd" || sName == "stay_dys" || sName == "free_dys" || sName == "paid_day" || sName == "free_dy_xcld_dys" || sName == "ovr_dys" || sName == "ctrt_rt" || sName == "vol_tr_ut_cd") {
        if (isNaN(t3sheet1.GetCellValue(Row, 'free_dys')) || parseInt(t3sheet1.GetCellValue(Row, 'free_dys'), 10) < 0) {
            t3sheet1.SetCellValue(Row, 'free_dys', 0, 0);
        }
        if (isNaN(t3sheet1.GetCellValue(Row, 'paid_day')) || parseInt(t3sheet1.GetCellValue(Row, 'paid_day'), 10) < 0) {
            t3sheet1.SetCellValue(Row, 'paid_day', 0, 0);
        }
        if (isNaN(t3sheet1.GetCellValue(Row, 'free_dy_xcld_dys')) || parseInt(t3sheet1.GetCellValue(Row, 'free_dy_xcld_dys'), 10) < 0) {
            t3sheet1.SetCellValue(Row, 'free_dy_xcld_dys', 0, 0);
        }
        t3sheet1_RecalcCalcAmt(t3sheet1, Row);
    }
    if (sName == "inv_xch_rt") {
        t3sheet1.SetCellValue(Row, 'inv_xch_rt', Math.abs(t3sheet1.GetCellValue(Row, 'inv_xch_rt')));
        if (t3sheet1.GetCellValue(Row, 'inv_xch_rt') > 0) {
            //				t3sheet1.SetCellBackColor(Row,'inv_xch_rt',"#000000");
        }
        if (t3sheet1.GetCellValue(Row, 'calc_tp_cd') == 'A') {
            if (t3sheet1.GetCellValue(Row, 'curr_cd') != undefined && t3sheet1.GetCellValue(Row, 'curr_cd') != null && t3sheet1.GetCellValue(Row, 'curr_cd') != '' &&
                curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' &&
                curr_cd.GetSelectCode() != t3sheet1.GetCellValue(Row, 'curr_cd') &&
                !isNaN(t3sheet1.GetCellValue(Row, 'inv_xch_rt')) && parseFloat(t3sheet1.GetCellValue(Row, 'inv_xch_rt')) > 0) {
                
                var nInvAmt = Number(t3sheet1.GetCellValue(Row, 'ovr_dys')) * Number(t3sheet1.GetCellValue(Row, 'ctrt_rt')) * Number(t3sheet1.GetCellValue(Row, 'inv_xch_rt'));
        
		        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
		        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
		        }
		        nInvAmt = Math.round(nInvAmt*100)/100; //exchange rate 계산후 소수점 2자리로 화면과 똑같이 DB에도 저장하기 위해서 수정함.
                t3sheet1.SetCellValue(Row, 'inv_amt', nInvAmt);
            }
        } else if (t3sheet1.GetCellValue(Row, 'calc_tp_cd') == 'M') {
            if (curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' &&
                !isNaN(t3sheet1.GetCellValue(Row, 'ovr_dys')) && parseFloat(t3sheet1.GetCellValue(Row, 'ovr_dys')) > 0 &&
                !isNaN(t3sheet1.GetCellValue(Row, 'ctrt_rt')) && parseFloat(t3sheet1.GetCellValue(Row, 'ctrt_rt')) > 0 &&
                !isNaN(t3sheet1.GetCellValue(Row, 'inv_xch_rt')) && parseFloat(t3sheet1.GetCellValue(Row, 'inv_xch_rt')) > 0) {
                
                var nInvAmt = Number(t3sheet1.GetCellValue(Row, 'ovr_dys')) * Number(t3sheet1.GetCellValue(Row, 'ctrt_rt')) * Number(t3sheet1.GetCellValue(Row, 'inv_xch_rt'));
        
		        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
		        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
		        }
		        nInvAmt = Math.round(nInvAmt*100)/100; //exchange rate 계산후 소수점 2자리로 화면과 똑같이 DB에도 저장하기 위해서 수정함.
                t3sheet1.SetCellValue(Row, 'inv_amt', nInvAmt);
            }
        }
    }
    if (sName == "inv_amt") {
        document.form.t3sht_tot_inv_amt.value = getShtTotCalcAmt(t3sheet1, 'inv_amt');
    }
}

/**
 * Cost Calc.(FD) sheet row Amount Calculate
 * @param {sheet}	t3sheet1	Cost Calc.(FD) sheet
 * @param {int}		Row			Row Index	
 * @return
 */
function t3sheet1_RecalcCalcAmt(t3sheet1, Row) {
    var sCurrCd = document.form.curr_cd.value;
    
    if (t3sheet1.RowCount() > 0) {
        if (t3sheet1.GetCellValue(Row, 'stay_dys') == -1) {
            t3sheet1.SetRowFontColor(Row, "#FF0000");
        } else {
            t3sheet1.SetRowFontColor(Row, t3sheet1.GetDataFontColor());
        }
        if (t3sheet1.GetCellValue(Row, "calc_tp_cd") == "A") {
            t3sheet1.SetCellValue(Row, 'ovr_dys', Number(t3sheet1.GetCellValue(Row, 'ovr_dys2')) - Number(t3sheet1.GetCellValue(Row, 'paid_day')) - Number(t3sheet1.GetCellValue(Row, 'free_dy_xcld_dys')), 0);
        } else if (t3sheet1.GetCellValue(Row, "calc_tp_cd") == "M") { // S는 하지 않는다
            t3sheet1.SetCellValue(Row, 'ovr_dys', Number(t3sheet1.GetCellValue(Row, 'stay_dys')) - Number(t3sheet1.GetCellValue(Row, 'free_dys')) - Number(t3sheet1.GetCellValue(Row, 'paid_day')) - Number(t3sheet1.GetCellValue(Row, 'free_dy_xcld_dys')), 0);
        }
        var ovr_dys = Number(t3sheet1.GetCellValue(Row, 'ovr_dys'));
        if (isNaN(ovr_dys) || parseInt(ovr_dys, 10) < 0) {
            ovr_dys = 0;
            t3sheet1.SetCellValue(Row, 'ovr_dys', 0, 0);
        }
        
        var nInvAmt = Number(ovr_dys) * Number(t3sheet1.GetCellValue(Row, 'ctrt_rt')) * (Number(t3sheet1.GetCellValue(Row, 'inv_xch_rt')) > 0 ? Number(t3sheet1.GetCellValue(Row, 'inv_xch_rt')) : 1);

        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
        }
		        
        t3sheet1.SetCellValue(Row, 'inv_amt', nInvAmt);
        /*
        if (t3sheet1.GetCellValue(Row,'calc_tp_cd')=='A') {
        if (t3sheet1.GetCellValue(Row,'curr_cd')!=undefined && t3sheet1.GetCellValue(Row,'curr_cd')!=null && t3sheet1.GetCellValue(Row,'curr_cd')!='' &&
        					curr_cd.GetSelectCode()!=undefined && curr_cd.GetSelectCode()!=null && curr_cd.GetSelectCode()!='' &&
        curr_cd.GetSelectCode()!=t3sheet1.GetCellValue(Row,'curr_cd') &&
        !isNaN(t3sheet1.GetCellValue(Row,'inv_xch_rt')) && parseFloat(t3sheet1.GetCellValue(Row,'inv_xch_rt'))>0)
        				{
        t3sheet1.SetCellValue(Row,'inv_amt',Number(ovr_dys) * Number(t3sheet1.GetCellValue(Row,'ctrt_rt')) * (Number(t3sheet1.GetCellValue(Row,'inv_xch_rt'))>0?Number(t3sheet1.GetCellValue(Row,'inv_xch_rt')):1));
        				}
        } else if (t3sheet1.GetCellValue(Row,'calc_tp_cd')=='M'){
        				if (curr_cd.GetSelectCode()!=undefined && curr_cd.GetSelectCode()!=null && curr_cd.GetSelectCode()!='' &&
        !isNaN(t3sheet1.GetCellValue(Row,'inv_xch_rt')) && parseFloat(t3sheet1.GetCellValue(Row,'inv_xch_rt'))>0)
        				{
        t3sheet1.SetCellValue(Row,'inv_amt',Number(ovr_dys) * Number(t3sheet1.GetCellValue(Row,'ctrt_rt')) * (Number(t3sheet1.GetCellValue(Row,'inv_xch_rt'))>0?Number(t3sheet1.GetCellValue(Row,'inv_xch_rt')):1));
        				}
        			}
        */
        if ((t3sheet1.GetCellValue(Row, 'cntr_tpsz_cd') != undefined && t3sheet1.GetCellValue(Row, 'cntr_tpsz_cd') != null && t3sheet1.GetCellValue(Row, 'cntr_tpsz_cd') != '') &&
            (t3sheet1.GetCellValue(Row, 'vol_tr_ut_cd') != undefined && t3sheet1.GetCellValue(Row, 'vol_tr_ut_cd') != null && t3sheet1.GetCellValue(Row, 'vol_tr_ut_cd') != '')) {
            
        	var nInvAmt = t3sheet1.GetCellValue(Row, 'inv_amt') * tes_getTEUconv(t3sheet1.GetCellValue(Row, 'vol_tr_ut_cd'), t3sheet1.GetCellValue(Row, 'cntr_tpsz_cd'));

	        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
	        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
	        }
            
            t3sheet1.SetCellValue(Row, 'inv_amt', nInvAmt);
        }
    }
}

/**
 * Cost Calc.(FD) sheet save end event
 * @param {sheet}	t3sheet1	Cost Calc.(FD) sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t3sheet1_OnSaveEnd(t3sheet1, ErrMsg) {
    if (confirm_done) {
        disableSheetEditable(t3sheet1);
    }
    var formObj = document.form;
    if (t3sheet1.RowCount() > 0) {
        setElementDiabled('radio', 'StorageFD', 'Y');
        t1sheet1_SetChkBoxDisabled();
        t2sheet1_SetChkBoxDisabled();
        document.form.t3sht_tot_inv_amt.value = getShtTotCalcAmt(t3sheet1, 'inv_amt');
        
        for (var i = 1; i <= t3sheet1.RowCount(); i++) {
            if (t3sheet1.GetCellValue(i, "calc_tp_cd") == "A") {
                if (t3sheet1.GetCellValue(i, "curr_cd") != undefined && t3sheet1.GetCellValue(i, "curr_cd") != null && t3sheet1.GetCellValue(i, "curr_cd") != '' &&
                    formObj.curr_cd.GetSelectCode() != undefined && formObj.curr_cd.GetSelectCode() != null && formObj.curr_cd.GetSelectCode() != '' &&
                    t3sheet1.GetCellValue(i, "curr_cd") != formObj.curr_cd.GetSelectCode()) {
                    setShtCellsEditable(t3sheet1, i, 'inv_xch_rt', 'Y', 'EXCEPTION');
                }
                t3sheet1.SetCellValue(i, "calc_rmk", ComToString(t3sheet1.GetCellValue(i, "calc_rmk")), 0);
            } else if (t3sheet1.GetCellValue(i, "calc_tp_cd") == "M") { //S는 t3sheet1_OnSearchEnd와 동일상태 변경없음 
                //setShtCellsEditable(t3sheet1,i,'lgs_cost_cd|cntr_no|cntr_tpsz_cd|io_bnd_cd|dcgo_ind_cd|stay_dys|free_dys|paid_day|ovr_dys|vol_tr_ut_cd|ctrt_rt|inv_amt|inv_amt2','Y');
                setShtCellsEditable(t3sheet1, i, 'lgs_cost_cd|rev_yrmon|stay_dys|ctrt_rt|inv_amt|inv_xch_rt', 'Y');
                setShtCellsEditable(t3sheet1, i, 'free_dys|paid_day|free_dy_xcld_dys', 'N');
                t3sheet1.SetCellValue(i, "calc_rmk", ComToString(t3sheet1.GetCellValue(i, "calc_rmk")), 0);
            }
        }
        setCalcStorageManualCostCode(t3sheet1);
        checkTPBdataEditable('3', t3sheet1);
    } else {
        document.form.t3sht_tot_inv_amt.value = 0;
    }
}

/**
 * check Currency Code
 * @param {sheet}	sheetObj	ibsheet
 * @return
 */
function currChk(sheetObj) {
    var retval = false;
    for (var i = sheetObj.HeaderRows(); sheetObj.RowCount() > 0 && i < (sheetObj.HeaderRows() + sheetObj.RowCount()); i++) {
        if (sheetObj.GetCellValue(i, 'curr_chk') == 'N') {
            sheetObj.SetRowBackColor(i, "#FF9999");
            retval = true;
        }
    }
    return retval;
}

/**
 * Cost Calc.(FD) sheet search end event
 * @param {sheet}	t3sheet1	Cost Calc.(FD) sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t3sheet1_OnSearchEnd(t3sheet1, ErrMsg) {
    if (confirm_done) {
        disableSheetEditable(t3sheet1);
    }
    var formObj = document.form;
    if (t3sheet1.RowCount() > 0) {
        /*
        if (currChk(t3sheet1)){
        	ComShowMessage('입력하신 Currency Code는 Agreement의 currency 와 일치하지 않아Calculation Data를 삭제합니다. 확인 후 다시 계산해주십시오.');
        	removeAutoCalcData();
        	return false;
        }
        */
        setElementDiabled('radio', 'StorageFD', 'Y');
        t1sheet1_SetChkBoxDisabled();
        t2sheet1_SetChkBoxDisabled();
        document.form.t3sht_tot_inv_amt.value = getShtTotCalcAmt(t3sheet1, 'inv_amt');
        
        for (var i = 1; i <= t3sheet1.RowCount(); i++) {
            if (t3sheet1.GetCellValue(i, "calc_tp_cd") == "A") {
                t3sheet1.SetCellValue(i, "calc_rmk", ComToString(t3sheet1.GetCellValue(i, "calc_rmk")), 0);

                if (t3sheet1.GetCellValue(i, "curr_cd") != undefined && t3sheet1.GetCellValue(i, "curr_cd") != null && t3sheet1.GetCellValue(i, "curr_cd") != '' &&
                    curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' &&
                    t3sheet1.GetCellValue(i, "curr_cd") != curr_cd.GetSelectCode()) {
                    setShtCellsEditable(t3sheet1, i, 'inv_xch_rt', 'Y', 'EXCEPTION');
                }
            } else if (t3sheet1.GetCellValue(i, "calc_tp_cd") == "M") {
                t3sheet1.SetCellValue(i, "calc_rmk", ComToString(t3sheet1.GetCellValue(i, "calc_rmk")), 0);

                setShtCellsEditable(t3sheet1, i, 'lgs_cost_cd|rev_yrmon|stay_dys|ctrt_rt|inv_amt|inv_xch_rt', 'Y');
                setShtCellsEditable(t3sheet1, i, 'free_dys|paid_day|free_dy_xcld_dys', 'N');

            } else if (t3sheet1.GetCellValue(i, "calc_tp_cd") == "S") {
                t3sheet1.SetCellValue(i, "calc_rmk", ComToString(t3sheet1.GetCellValue(i, "calc_rmk")), 0);

                setShtCellsEditable(t3sheet1, i, 'rev_yrmon|inv_amt', 'Y', 'EXCEPTION');
                setShtCellsEditable(t3sheet1, i, 'stay_dys|free_dys|paid_day|free_dy_xcld_dys|ovr_dys|calc_vol_qty|ctrt_rt|inv_xch_rt|', 'N', 'EXCEPTION');
            }
        }
        setCalcStorageManualCostCode(t3sheet1);
        checkTPBdataEditable('3', t3sheet1);
    } else {
        document.form.t3sht_tot_inv_amt.value = 0;
    }
    //t1sheet1_SetColmnEditable();
}

/**
 * Cost Calc.(FD) sheet click event
 * @param {sheet}	sheetObj	Cost Calc.(FD) sheet
 * @param {int}		row			selected row
 * @param {int}		col			selected col
 * @return
 */
function t3sheet1_OnPopupClick(sheetObj, row, col) {
    var formObj = document.form;
    if (sheetObj.ColSaveName(col) == "n3pty_flg") {
        if (sheetObj.GetCellValue(row, 'tml_so_dtl_seq') == '' || sheetObj.GetCellValue(row, 'tml_so_dtl_seq') == null || sheetObj.GetCellValue(row, 'tml_so_dtl_seq') == 0) {
            ComShowMessage('You have to 3rd party Input after save calculated result.');
            return false;
        }
        if (sheetObj.GetCellValue(row, 'calc_cost_grp_cd') == null || doSepRemove(sheetObj.GetCellValue(row, 'calc_cost_grp_cd'), ' ') == '') {
            ComShowMessage(ComGetMsg('TES24046'));
            return false;
        }
        if (formObj.curr_cd.value == null || doSepRemove(formObj.curr_cd.value, ' ') == '') {
            ComShowMessage(ComGetMsg('TES40041', 'Currency code'));
            return false;
        }
        if (sheetObj.GetCellValue(row, 'lgs_cost_cd') == undefined ||
            sheetObj.GetCellValue(row, 'lgs_cost_cd') == null ||
            sheetObj.GetCellValue(row, 'lgs_cost_cd') == '') {
            ComShowMessage(ComGetMsg('TES23045'));
            return false;
        }
        if (sheetObj.GetCellValue(row, 'inv_amt') != undefined &&
            sheetObj.GetCellValue(row, 'inv_amt') != null &&
            sheetObj.GetCellValue(row, 'inv_amt') < 0) {
            return false;
        }
        var url_str = 'ESD_TES_9234Popup.screen';
        url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
        url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
        url_str = url_str + '&tml_so_dtl_seq=' + sheetObj.GetCellValue(row, 'tml_so_dtl_seq');
        url_str = url_str + '&calc_cost_grp_cd=' + sheetObj.GetCellValue(row, 'calc_cost_grp_cd');
        url_str = url_str + '&calc_tp_cd=' + sheetObj.GetCellValue(row, 'calc_tp_cd');
        url_str = url_str + '&vndr_seq=' + formObj.vndr_seq.value;
        url_str = url_str + '&inv_no=' + formObj.inv_no.value;
        url_str = url_str + '&param_lgs_cost_cd=' + sheetObj.GetCellValue(row, 'lgs_cost_cd');
        url_str = url_str + '&param_cntr_tpsz_cd=' + sheetObj.GetCellValue(row, 'cntr_tpsz_cd');
        url_str = url_str + '&curr_cd=' + formObj.curr_cd.value;
        url_str = url_str + '&sheet_curr_row=' + row;
        url_str = url_str + '&sheet_idx=3';
        url_str = url_str + '&param_cntr_no=' + sheetObj.GetCellValue(row, 'cntr_no');
        url_str = url_str + '&inv_amt=' + sheetObj.GetCellValue(row, 'inv_amt');
        url_str = url_str + '&yd_cd=' + formObj.yd_cd.value;
        url_str = url_str + '&ctrt_rt=' + sheetObj.GetCellValue(row, 'ctrt_rt');
        url_str = url_str + '&inv_xch_rt=' + sheetObj.GetCellValue(row, 'inv_xch_rt');
        url_str = url_str + '&ovr_dys=' + sheetObj.GetCellValue(row, 'ovr_dys');
        //ComOpenWindow(url_str,  window,  "dialogWidth:710px; dialogHeight:440px; help:no; status:no; resizable:yes;" , true);
        ComOpenWindow(url_str, window, "help:no;status:no;resizable:yes;dialogWidth:" + 820 + "px;dialogHeight:" + 450 + "px", true);
    }
}

/**
 * Cost Calc.(FD) sheet click event
 * @param {sheet}	t3sheet1	Cost Calc.(FD) sheet
 * @param {int}		Row			Row Index
 * @param {int}		Col			Column Index
 * @param {string}	Value		
 * @return
 */
function t3sheet1_OnClick(t3sheet1, Row, Col, Value) {
    if (t3sheet1.ColSaveName(Col) == 'inv_amt') {}
}

/**
 * Cost Calc.(SR by FD) sheet save end event
 * @param {ibsheet}	t4sheet1	Cost Calc.(SR by FP)sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t4sheet1_OnSaveEnd(t4sheet1, ErrMsg) {
    if (confirm_done) {
        //			t4sheet1_ShowSubSum(t4sheet1);
        disableSheetEditable(t4sheet1);
    }
    var formObj = document.form;
    if (t4sheet1.RowCount() > 0) {
        for (var i = 1; i <= t4sheet1.RowCount(); i++) {

            if (t4sheet1.GetCellValue(i, "calc_tp_cd") == "A") {
                if (t4sheet1.GetCellValue(i, "curr_cd") != undefined && t4sheet1.GetCellValue(i, "curr_cd") != null && t4sheet1.GetCellValue(i, "curr_cd") != '' &&
                    curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' &&
                    t4sheet1.GetCellValue(i, "curr_cd") != curr_cd.GetSelectCode()) {
                    setShtCellsEditable(t4sheet1, i, 'inv_xch_rt', 'Y', 'EXCEPTION');
                }
                t4sheet1.SetCellValue(i, "calc_rmk", ComToString(t4sheet1.GetCellValue(i, "calc_rmk")), 0);

            } else if (t4sheet1.GetCellValue(i, "calc_tp_cd") == "M") {
                setShtCellsEditable(t4sheet1, i, 'lgs_cost_cd|wrk_dt|stk_vol_qty|inv_vol_qty|diff_vol_qty|fp_teu_qty|ovr_vol_qty|vol_tr_ut_cd|ctrt_rt|inv_amt|inv_xch_rt', 'Y');
                t4sheet1.SetCellValue(i, "calc_rmk", ComToString(t4sheet1.GetCellValue(i, "calc_rmk")), 0);
            }
        }
        t4sheet1_MonthlyRowManage(t4sheet1);
        //			t4sheet1_ShowSubSum(t4sheet1);
        setCalcStorageManualCostCode(t4sheet1);
        t4sheet1_TotCalcAmt(t4sheet1);
        checkTPBdataEditable('4', t4sheet1);
    } else {
        document.form.t4sht_tot_inv_amt.value = 0;
    }
}

/**
 * Cost Calc.(SR by FD) sheet search end event
 * @param {ibsheet}	t4sheet1	Cost Calc.(SR by FP)sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t4sheet1_OnSearchEnd(t4sheet1, ErrMsg) {
    if (confirm_done) {
        disableSheetEditable(t4sheet1);
    }
    var formObj = document.form;
    if (t4sheet1.RowCount() > 0) {
        /*
        			if (currChk(t4sheet1)){
        				ComShowMessage('입력하신 Currency Code는 Agreement의 currency 와 일치하지 않아Calculation Data를 삭제합니다. 확인 후 다시 계산해주십시오.');
        				removeAutoCalcData2();
        				return false;
        			}
        */
        for (var i = 1; i <= t4sheet1.RowCount(); i++) {
            if (t4sheet1.GetCellValue(i, "calc_tp_cd") == "A") {
                if (t4sheet1.GetCellValue(i, "curr_cd") != undefined && t4sheet1.GetCellValue(i, "curr_cd") != null && t4sheet1.GetCellValue(i, "curr_cd") != '' &&
                    curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' &&
                    t4sheet1.GetCellValue(i, "curr_cd") != curr_cd.GetSelectCode()) {
                    setShtCellsEditable(t4sheet1, i, 'inv_xch_rt', 'Y', 'EXCEPTION');
                    t4sheet1.SetCellValue(i, "calc_rmk", ComToString(t4sheet1.GetCellValue(i, "calc_rmk")), 0);
                }
            } else if (t4sheet1.GetCellValue(i, "calc_tp_cd") == "M") {
                setShtCellsEditable(t4sheet1, i, 'lgs_cost_cd|wrk_dt|stk_vol_qty|inv_vol_qty|diff_vol_qty|fp_teu_qty|ovr_vol_qty|vol_tr_ut_cd|ctrt_rt|inv_amt|inv_xch_rt', 'Y');
                t4sheet1.SetCellValue(i, "calc_rmk", ComToString(t4sheet1.GetCellValue(i, "calc_rmk")), 0);
            }
        }
        t4sheet1_MonthlyRowManage(t4sheet1);
        //			t4sheet1_ShowSubSum(t4sheet1);
        setCalcStorageManualCostCode(t4sheet1);
        t4sheet1_TotCalcAmt(t4sheet1);
        checkTPBdataEditable('4', t4sheet1);
    } else {
        document.form.t4sht_tot_inv_amt.value = 0;
    }
}

/**
 * Cost Calc.(SR by FP) sheet change event
 * @param {sheet}		t4sheet1	Cost Calc.(SR by FP) sheet
 * @param {int}		Row			Row Index
 * @param {int}		Col			Column Index
 * @param {string}	Value		
 * @return
 */
function t4sheet1_OnChange(t4sheet1, Row, Col, Value) {
    if (t4sheet1.GetCellValue(Row, 'calc_tp_cd') == 'M' && t4sheet1.ColSaveName(Col) == 'wrk_dt') {
        if (t4sheet1.GetCellValue(Row, 'wrk_dt') != null || t4sheet1.GetCellValue(Row, 'wrk_dt') == '') {
            t4sheet1.SetCellValue(Row, 'rev_yrmon', t4sheet1.GetCellValue(Row, 'wrk_dt').substring(0, 6));
        }
    }
    if (t4sheet1.GetCellValue(Row, 'calc_tp_cd') == 'M' && t4sheet1.GetCellValue(Row, 'lgs_cost_cd') == '') {
        ComShowMessage(ComGetMsg('TES23061'));
        return false;
    }
    var sName = t4sheet1.ColSaveName(Col);
    if (sName == "lgs_cost_cd" || sName == "inv_vol_qty" || sName == "fp_teu_qty" || sName == "ctrt_rt" || sName == "inv_xch_rt" || sName == "vol_tr_ut_cd") {
        t4sheet1.SetCellValue(Row, 'inv_xch_rt', Math.abs(t4sheet1.GetCellValue(Row, 'inv_xch_rt')), 0);
        if (t4sheet1.GetCellValue(Row, 'inv_xch_rt') > 0) {
            t4sheet1.SetCellBackColor(Row, 'inv_xch_rt', "#000000");
        }
        t4sheet1_RecalcCalcAmt(t4sheet1, Row);
    }
    if (sName == "inv_amt") {
        t4sheet1_TotCalcAmt(t4sheet1);
    }
    //		t4sheet1_ShowSubSum(t4sheet1);
}

/**
 * Cost Calc.(SR by FP) sheet click event
 * @param {sheet}	t4sheet1	Cost Calc.(SR by FP) sheet
 * @param {int}		row			Row Index
 * @param {int}		col			Column Index
 * @return
 */
function t4sheet1_OnPopupClick(t4sheet1, row, col) {
    var formObj = document.form;
    if (sheetObj.ColSaveName(col) == "n3pty_flg") {
        if (sheetObj.GetCellValue(row, 'calc_cost_grp_cd') == null || sheetObj.GetCellValue(row, 'calc_cost_grp_cd') == '') {
            ComShowMessage(ComGetMsg('TES24046'));
            return false;
        }
        if (curr_cd.GetSelectCode() == null || doSepRemove(curr_cd.GetSelectCode(), ' ') == '') {
            ComShowMessage(ComGetMsg('TES40041', 'Currency code'));
            return false;
        }
        if (sheetObj.GetCellValue(row, 'lgs_cost_cd') == undefined ||
            sheetObj.GetCellValue(row, 'lgs_cost_cd') == null ||
            sheetObj.GetCellValue(row, 'lgs_cost_cd') == '') {
            ComShowMessage(ComGetMsg('TES23045'));
            return false;
        }
        if (sheetObj.GetCellValue(row, 'inv_amt') != undefined &&
            sheetObj.GetCellValue(row, 'inv_amt') != null &&
            sheetObj.GetCellValue(row, 'inv_amt') < 0) {
            return false;
        }
        var url_str = 'ESD_TES_9234Popup.screen';
        url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
        url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
        url_str = url_str + '&tml_so_dtl_seq=' + sheetObj.GetCellValue(row, 'tml_so_dtl_seq');
        url_str = url_str + '&calc_cost_grp_cd=' + sheetObj.GetCellValue(row, 'calc_cost_grp_cd');
        url_str = url_str + '&calc_tp_cd=' + sheetObj.GetCellValue(row, 'calc_tp_cd');
        url_str = url_str + '&vndr_seq=' + formObj.vndr_seq.value;
        url_str = url_str + '&inv_no=' + formObj.inv_no.value;
        url_str = url_str + '&param_lgs_cost_cd=' + sheetObj.GetCellValue(row, 'lgs_cost_cd');
        url_str = url_str + '&param_cntr_tpsz_cd=' + sheetObj.GetCellValue(row, 'cntr_tpsz_cd');
        url_str = url_str + '&curr_cd=' + curr_cd.GetSelectCode();
        url_str = url_str + '&sheet_curr_row=' + row;
        url_str = url_str + '&sheet_idx=4';
        ComOpenWindow(url_str, window, "dialogWidth:820px;dialogHeight:700px;help:no;status:no;resizable:yes;", true);
    }
}

/**
 * [Inv Amt] calculate
 * @param {sheet}	t4sheet1	Cost Calc.(SR by FP) sheet
 * @param {int}		Row			Row Index
 * @return
 */
function t4sheet1_RecalcCalcAmt(t4sheet1, Row) {
    var sCurrCd = document.form.curr_cd.value;
    
    if (t4sheet1.RowCount() > 0) {
        t4sheet1.SetCellValue(Row, 'ovr_vol_qty', t4sheet1.GetCellValue(Row, 'inv_vol_qty') - t4sheet1.GetCellValue(Row, 'fp_teu_qty'), 0);
        t4sheet1.SetCellValue(Row, 'diff_vol_qty', t4sheet1.GetCellValue(Row, 'stk_vol_qty') - t4sheet1.GetCellValue(Row, 'inv_vol_qty'));

        var ovr_vol_qty = t4sheet1.GetCellValue(Row, 'ovr_vol_qty');
        if (isNaN(ovr_vol_qty) || parseInt(ovr_vol_qty, 10) < 0) {
            ovr_vol_qty = 0;
            t4sheet1.SetCellValue(Row, 'ovr_vol_qty', 0, 0);
        }
        
        var nInvAmt = t4sheet1.GetCellValue(Row, 'ovr_vol_qty') * t4sheet1.GetCellValue(Row, 'ctrt_rt');
        
		if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
			nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
		}
		        
        t4sheet1.SetCellValue(Row, 'inv_amt', nInvAmt);
        
        if (t4sheet1.GetCellValue(Row, 'calc_tp_cd') == 'A') {
            if (t4sheet1.GetCellValue(Row, 'curr_cd') != undefined && t4sheet1.GetCellValue(Row, 'curr_cd') != null && t4sheet1.GetCellValue(Row, 'curr_cd') != '' &&
                curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' &&
                curr_cd.GetSelectCode() != t4sheet1.GetCellValue(Row, 'curr_cd') &&
                !isNaN(t4sheet1.GetCellValue(Row, 'inv_xch_rt')) && parseFloat(t4sheet1.GetCellValue(Row, 'inv_xch_rt')) > 0) {
                
                var nInvAmt = parseFloat(t4sheet1.GetCellValue(Row, 'inv_amt')) * parseFloat(t4sheet1.GetCellValue(Row, 'inv_xch_rt'));
        
				if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
					nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
				}
		
                t4sheet1.SetCellValue(Row, 'inv_amt', nInvAmt);
            }
        } else if (t4sheet1.GetCellValue(Row, 'calc_tp_cd') == 'M') {
            if (curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' &&
                !isNaN(t4sheet1.GetCellValue(Row, 'inv_xch_rt')) && parseFloat(t4sheet1.GetCellValue(Row, 'inv_xch_rt')) > 0) {
                
                var nInvAmt = parseFloat(t4sheet1.GetCellValue(Row, 'inv_amt')) * parseFloat(t4sheet1.GetCellValue(Row, 'inv_xch_rt'));
        
				if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
					nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
				}
				
                t4sheet1.SetCellValue(Row, 'inv_amt', nInvAmt);
            }
        }

        t4sheet1_ChkDifferVol(t4sheet1, Row);
    }
}

/**
 * Comparing with invoice vol. and diff vol.
 * @param {sheet}	t4sheet1	ibsheet
 * @param {int}		Row			The cell's Row Index
 * @return
 */
function t4sheet1_ChkDifferVol(t4sheet1, Row) {
    var diff_vol_qty = parseFloat(t4sheet1.GetCellValue(Row, 'diff_vol_qty'));
    var inv_vol_qty = parseFloat(t4sheet1.GetCellValue(Row, 'inv_vol_qty'));
    var result = (diff_vol_qty / inv_vol_qty);
    if (result > 0.01) {
        t4sheet1.SetRowFontColor(Row, "#FF0000");
    } else {
        t4sheet1.SetRowFontColor(Row, t4sheet1.GetDataFontColor());
    }
}

/**
 * @param {sheet}	t4sheet1	Cost Calc.(SR by FP) sheet
 * @return
 */
//	function t4sheet1_ShowSubSum(t4sheet1){
//		t4sheet1.HideSubSum();
//		t4sheet1.ShowSubSum("calc_tp_cd", "4|5|6|7|8|10|11", -1, false, false, -1, "calc_tp_cd=%s;lgs_cost_cd=TTL");
//	}

/**
 * set Calculated AMT
 * @param {sheet}	t4sheet1	Cost Calc.(SR by FP) sheet
 * @return
 */
function t4sheet1_TotCalcAmt(t4sheet1) {
    document.form.t4sht_tot_inv_amt.value = getShtTotCalcAmt(t4sheet1, 'inv_amt');
}

/**
 * Cost Calc.(SR by FP) sheet 
 * @param {sheet}	t4sheet1	Cost Calc.(SR by FP) sheet
 * @return
 */
function t4sheet1_MonthlyRowManage(t4sheet1) {
    //		for (var i=0; i<t4sheet1.RowCount; i++){
    //			if (t4sheet1.GetCellValue(i,"calc_tp_cd")=="A" && t4sheet1.GetCellValue(i,"lgs_cost_cd")!="SRXXDC") {
    //				if (t4sheet1.GetCellValue(i,"fp_calc_prd_cd")=="M") {
    //					t4sheet1.InitCellProperty(i,'wrk_dt',dtData,daLeft,'wrk_dt','',dfDateYm);
    //				}
    //			}
    //		}
}

/**
 * tab click event
 * @param {sheet}	t4sheet1	Discrepancy sheet
 * @param {int}		row			선택된 row
 * @param {int}		col			선택된 col
 * @return
 */
function t4sheet1_OnClick(t4sheet1, Row, Col, Value) {
    //ComShowMessage(t4sheet1.GetCellValue(Row,'ibflag') + ' -- ' + t4sheet1.GetCellValue(Row,'lgs_cost_cd') );
    /*
    //no support[check again]CLT 		if (t4sheet1.RowSumable(Row)){ComShowMessage(Row + '=T');
    		} else {ComShowMessage(Row + '=F');
    		}
    */
}

/**
 * tab print button click event
 * @return
 */
function printDiscrepancyContainerList() {
    var fromObj = new Array();
    var rdObj = new Array();

    fromObj[0] = document.form;
    //	    rdObj[0] = sheetObjects[0];
    //RD_path = "http://yoo:9001/opuscntr/";
    parmObj[0] = "1";
    parmObj[1] = "";
    parmObj[2] = "N";
    parmObj[3] = RD_path + "apps/opus/esd/tes/serviceproviderinvoicemanage/marineterminalstorageinvoicemanage/report/ESD_TES_0808.mrd";
    //	    parmObj[3] = "http://localhost:9001/opuscntr/apps/opus/esd/tes/serviceproviderinvoicemanage/marineterminalstorageinvoicemanage/report/ESD_TES_808.mrd";
    parmObj[4] = rdObj;
    parmObj[5] = fromObj;
    rdObjModaless(RdReport, parmObj, 1000, 700);
}

/**
 * @param {string}	strEleNums	
 * @return
 */
function setEleNums(strEleNums) {
    var eleNums = new Array();
    eleNums = strEleNums.split("|");
    return eleNums;
}

/**
 * sep에 해당하는 char를 제거하는 스크립트
 */
function doSepRemove(obj, sep) {
    var ch = "";
    var lvobj = "";
    for (var i = 0; i < obj.length; i++) {
        if (obj.charAt(i) == sep) {
            ch = "";
        } else {
            ch = obj.charAt(i);
        }
        lvobj = lvobj + ch;
    }
    return lvobj;
}

function setRemarkVal(rtnVal) {
    var formObj = document.form;
    formObj.hld_rmk.value = rtnVal;
}


function setCostCode2(sheetObj) {
    if (sheetObj.CheckedRows("sel") < 1) {
        return;
    }
    var vvd_hidden = sheetObjects[4];
    //	    var vvd_row = sheetObjects[4].FindText('vvd', document.form.vvd.value+io_hidden);
    var targetSheetObj = sheetObjectsMap['t3sheet1'];
    var idx;
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        if (!sheetObj.GetCellValue(i, "sel")) continue;
        idx = targetSheetObj.DataInsert(-1);

        targetSheetObj.CellComboItem(idx, 'lgs_cost_cd', { ComboText: document.form.calcStorageComboItems.value, ComboCode: document.form.calcStorageComboItems.value });

        targetSheetObj.SetCellValue(idx, "calc_tp_cd", sheetObj.GetCellValue(i, "calc_tp_cd"));
        targetSheetObj.SetCellValue(idx, "lgs_cost_cd", sheetObj.GetCellValue(i, "lgs_cost_cd"));
        targetSheetObj.SetCellValue(idx, "cntr_tpsz_cd", sheetObj.GetCellValue(i, "cntr_tpsz_cd"));
        //		    targetSheetObj.SetCellValue(idx,"io_bnd_cd")       =  io_hidden;      
        targetSheetObj.SetCellValue(idx, "io_bnd_cd", sheetObj.GetCellValue(i, "io_bnd_cd")); //2016-06-15 수정 Semi Auto 팝업의 값으로 셋팅

        if (sheetObj.GetCellValue(i, "dcgo_ind_cd") == 'ALL' || sheetObj.GetCellValue(i, "dcgo_ind_cd") == 'AN' || sheetObj.GetCellValue(i, "dcgo_ind_cd") == 'AS' || sheetObj.GetCellValue(i, "dcgo_ind_cd") == 'SN') {
            sheetObj.SetCellValue(i, "dcgo_ind_cd", '');
            targetSheetObj.SetCellValue(idx, "dcgo_ind_cd", sheetObj.GetCellValue(i, "dcgo_ind_cd"));
        }

        if (sheetObj.GetCellValue(i, "lane_cd") == 'Sam') {
            sheetObj.SetCellValue(i, "lane_cd", '');
        }

        targetSheetObj.SetCellValue(idx, "rc_flg", sheetObj.GetCellValue(i, "rc_flg"));
        targetSheetObj.SetCellValue(idx, "tml_wrk_dy_cd", sheetObj.GetCellValue(i, "tml_wrk_dy_cd"));
        targetSheetObj.SetCellValue(idx, "ioc_cd", sheetObj.GetCellValue(i, "ioc_cd"));
        targetSheetObj.SetCellValue(idx, "tml_trns_mod_cd", sheetObj.GetCellValue(i, "tml_trns_mod_cd"));
        targetSheetObj.SetCellValue(idx, "lane_cd", sheetObj.GetCellValue(i, "lane_cd"));
        targetSheetObj.SetCellValue(idx, "tier", sheetObj.GetCellValue(i, "tier"));
        targetSheetObj.SetCellValue(idx, "calc_vol_qty", sheetObj.GetCellValue(i, "calc_vol_qty"));
        targetSheetObj.SetCellValue(idx, "rvis_vol_qty", sheetObj.GetCellValue(i, "rvis_vol_qty"));
        targetSheetObj.SetCellValue(idx, "stay_dys", sheetObj.GetCellValue(i, "stay_days"));
        targetSheetObj.SetCellValue(idx, "ovr_dys", sheetObj.GetCellValue(i, "stay_days"));
        targetSheetObj.SetCellValue(idx, "vol_tr_ut_cd", sheetObj.GetCellValue(i, "vol_tr_ut_cd"));
        targetSheetObj.SetCellValue(idx, "ctrt_rt", sheetObj.GetCellValue(i, "ctrt_rt"));
        targetSheetObj.SetCellValue(idx, "inv_amt", sheetObj.GetCellValue(i, "inv_amt"));
        targetSheetObj.SetCellValue(idx, "curr_cd", sheetObj.GetCellValue(i, "curr_cd"));
        targetSheetObj.SetCellValue(idx, "tml_crr_cd", '');
        targetSheetObj.SetCellValue(idx, 'calc_cost_grp_cd', 'SD');
        targetSheetObj.SetCellValue(idx, 'inv_xch_rt', sheetObj.GetCellValue(i, "inv_xch_rt"));
        targetSheetObj.SetCellValue(idx, 'semi_auto_calc_flg', 'Y');

        targetSheetObj.SetCellValue(idx, "calc_rmk", sheetObj.GetCellValue(i, "agmt_dtl_rmk"));
        //	        targetSheetObj.SetCellValue(idx,'vsl_cd')           = vvd_hidden.GetCellValue(vvd_row, 'vvd_vsl_cd');
        //	        targetSheetObj.SetCellValue(idx,'skd_voy_no')       = vvd_hidden.GetCellValue(vvd_row, 'vvd_skd_voy_no');
        //	        targetSheetObj.SetCellValue(idx,'skd_dir_cd')       = vvd_hidden.GetCellValue(vvd_row, 'vvd_skd_dir_cd');
        //	        targetSheetObj.SetCellValue(idx,'atb_dt')           = vvd_hidden.GetCellValue(vvd_row, 'vvd_atb_dt');

        setShtCellsEditable(targetSheetObj, idx, 'rev_yrmon|cntr_tpsz_cd|dcgo_ind_cd|tml_wrk_dy_cd|ioc_cd|tml_trns_mod_cd|lane_cd|vol_tr_ut_cd|inv_amt|rc_flg', 'Y', 'EXCEPTION');
        setShtCellsEditable(targetSheetObj, idx, 'stay_dys|free_dys|paid_day|free_dy_xcld_dys|ovr_dys|calc_vol_qty|ctrt_rt|inv_xch_rt|', 'N', 'EXCEPTION');

    }
    document.form.t3sht_tot_inv_amt.value = getShtTotCalcAmt(targetSheetObj, 'inv_amt');
}

/** setCostCode3
 * 
 * @param sheetObj
 */
function setCostCode3(sheetObj) {
    if (sheetObj.CheckedRows("sel") < 1) {
        return;
    }
    var vvd_hidden = sheetObjects[4];
    //	    var vvd_row = sheetObjects[4].FindText('vvd', document.form.vvd.value+io_hidden);
    var targetSheetObj = sheetObjectsMap['t5sheet1'];
    var idx;
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        if (!sheetObj.GetCellValue(i, "sel")) continue;
        idx = targetSheetObj.DataInsert(-1);

        targetSheetObj.CellComboItem(idx, 'lgs_cost_cd', { ComboText: document.form.calcStorageEqComboItems.value, ComboCode: document.form.calcStorageEqComboItems.value });

        targetSheetObj.SetCellValue(idx, "calc_tp_cd", sheetObj.GetCellValue(i, "calc_tp_cd"));
        targetSheetObj.SetCellValue(idx, "lgs_cost_cd", sheetObj.GetCellValue(i, "lgs_cost_cd"));
        targetSheetObj.SetCellValue(idx, "cntr_tpsz_cd", sheetObj.GetCellValue(i, "cntr_tpsz_cd"));
        //		    targetSheetObj.SetCellValue(idx,"io_bnd_cd")       =  io_hidden;      
        targetSheetObj.SetCellValue(idx, "io_bnd_cd", sheetObj.GetCellValue(i, "io_bnd_cd")); //2016-06-15 수정 Semi Auto 팝업의 값으로 셋팅

        if (sheetObj.GetCellValue(i, "dcgo_ind_cd") == 'ALL' || sheetObj.GetCellValue(i, "dcgo_ind_cd") == 'AN' || sheetObj.GetCellValue(i, "dcgo_ind_cd") == 'AS' || sheetObj.GetCellValue(i, "dcgo_ind_cd") == 'SN') {
            sheetObj.SetCellValue(i, "dcgo_ind_cd", '');
            targetSheetObj.SetCellValue(idx, "dcgo_ind_cd", sheetObj.GetCellValue(i, "dcgo_ind_cd"));
        }

        if (sheetObj.GetCellValue(i, "lane_cd") == 'Sam') {
            sheetObj.SetCellValue(i, "lane_cd", '');
        }

        targetSheetObj.SetCellValue(idx, "rc_flg", sheetObj.GetCellValue(i, "rc_flg"));
        targetSheetObj.SetCellValue(idx, "tml_wrk_dy_cd", sheetObj.GetCellValue(i, "tml_wrk_dy_cd"));
        targetSheetObj.SetCellValue(idx, "ioc_cd", sheetObj.GetCellValue(i, "ioc_cd"));
        targetSheetObj.SetCellValue(idx, "tml_trns_mod_cd", sheetObj.GetCellValue(i, "tml_trns_mod_cd"));
        targetSheetObj.SetCellValue(idx, "lane_cd", sheetObj.GetCellValue(i, "lane_cd"));
        targetSheetObj.SetCellValue(idx, "tier", sheetObj.GetCellValue(i, "tier"));
        targetSheetObj.SetCellValue(idx, "calc_vol_qty", sheetObj.GetCellValue(i, "calc_vol_qty"));
        targetSheetObj.SetCellValue(idx, "rvis_vol_qty", sheetObj.GetCellValue(i, "rvis_vol_qty"));
        targetSheetObj.SetCellValue(idx, "stay_dys", sheetObj.GetCellValue(i, "stay_days"));
        targetSheetObj.SetCellValue(idx, "ovr_dys", sheetObj.GetCellValue(i, "stay_days"));
        targetSheetObj.SetCellValue(idx, "vol_tr_ut_cd", sheetObj.GetCellValue(i, "vol_tr_ut_cd"));
        targetSheetObj.SetCellValue(idx, "ctrt_rt", sheetObj.GetCellValue(i, "ctrt_rt"));
        targetSheetObj.SetCellValue(idx, "inv_amt", sheetObj.GetCellValue(i, "inv_amt"));
        targetSheetObj.SetCellValue(idx, "curr_cd", sheetObj.GetCellValue(i, "curr_cd"));
        targetSheetObj.SetCellValue(idx, "tml_crr_cd", '');
        targetSheetObj.SetCellValue(idx, 'calc_cost_grp_cd', 'EQ');
        targetSheetObj.SetCellValue(idx, 'inv_xch_rt', sheetObj.GetCellValue(i, "inv_xch_rt"));
        targetSheetObj.SetCellValue(idx, 'semi_auto_calc_flg', 'Y');

        targetSheetObj.SetCellValue(idx, "calc_rmk", sheetObj.GetCellValue(i, "agmt_dtl_rmk"));
        //	        targetSheetObj.SetCellValue(idx,'vsl_cd')           = vvd_hidden.GetCellValue(vvd_row, 'vvd_vsl_cd');
        //	        targetSheetObj.SetCellValue(idx,'skd_voy_no')       = vvd_hidden.GetCellValue(vvd_row, 'vvd_skd_voy_no');
        //	        targetSheetObj.SetCellValue(idx,'skd_dir_cd')       = vvd_hidden.GetCellValue(vvd_row, 'vvd_skd_dir_cd');
        //	        targetSheetObj.SetCellValue(idx,'atb_dt')           = vvd_hidden.GetCellValue(vvd_row, 'vvd_atb_dt');

        setShtCellsEditable(targetSheetObj, idx, 'rev_yrmon|cntr_tpsz_cd|dcgo_ind_cd|tml_wrk_dy_cd|ioc_cd|tml_trns_mod_cd|lane_cd|vol_tr_ut_cd|inv_amt|rc_flg', 'Y', 'EXCEPTION');
        setShtCellsEditable(targetSheetObj, idx, 'stay_dys|free_dys|paid_day|free_dy_xcld_dys|ovr_dys|calc_vol_qty|ctrt_rt|inv_xch_rt|', 'N', 'EXCEPTION');

    }
    document.form.t5sht_tot_inv_amt.value = getShtTotCalcAmt(targetSheetObj, 'inv_amt');
}

//================================= Invoice No 관련 함수 시작 =============================================
/**
 * 입력된 Invoice No가 기 존재하는 중복된 것이 아닌지 확인하는 함수
 */
function validateInvDupChk() {
    var formObj = document.form;
    if (formObj.inv_no.value == null || formObj.inv_no.value.trim() == '') {
        formObj.is_dup_inv_no.value = '';
        formObj.inv_no_hidden.value = '';
        return false;
    }

    if ((formObj.inv_no_hidden.value == null || formObj.inv_no_hidden.value.trim() == '') || formObj.inv_no.value.trim() != formObj.inv_no_hidden.value.trim()) {
        formObj.is_dup_inv_no.value = '';
        formObj.inv_no_hidden.value = '';
        
        if(!getInvDupYN()){ // Invoice Duplicate YN   //tes_getInputValue('is_dup_inv_no', SEARCH21, 'inv_no|vndr_seq', 'checkInvDup');
        	formObj.inv_no.value = "";
        }        
    }
}

/**
 *  Inv_no Dup Validation 함수
 */
function checkInvDup() {
    var formObj = document.form;
    var tmp = '';
    if (formObj.is_dup_inv_no.value != undefined && formObj.is_dup_inv_no.value != null && formObj.is_dup_inv_no.value.trim() != '') {
        tmp = formObj.is_dup_inv_no.value;
        if (tmp.length > 0) {
            formObj.is_dup_inv_no.value = (tmp != undefined && tmp != null ? tmp : '');
            if (formObj.is_dup_inv_no.value != null && formObj.is_dup_inv_no.value == 'Y') {
                //formObj.is_dup_inv_no.value = '';
                //formObj.inv_no_hidden.value = '';
                ComShowMessage(ComGetMsg('TES21052')); //ComShowMessage('This Invoice No. is duplicated. Plz, change to another Invoice No.');
            }
        }
    }
}
//================================= Invoice No 관련 함수 끝 =================================================

/**
 * @param {obj}    Text Value
 **/
function isApNum2(obj) {
    /*	if (!ComIsAlphabet(obj,'n')){
    		obj.value = '';
    	}
    */
    obj.value = obj.value.toUpperCase();
}

/**
 * Cost Calc.(FD) sheet change event
 * @param {sheet}	t5sheet1	Cost Calc.(FD) sheet
 * @param {int}		Row			Row Index
 * @param {int}		Col			Column Index
 * @param {string}	Value		
 * @return
 */
function t5sheet1_OnChange(t5sheet1, Row, Col, Value) {
    var sCurrCd = document.form.curr_cd.value;
    
    if (t5sheet1.GetCellValue(Row, 'calc_tp_cd') == 'M' && t5sheet1.GetCellValue(Row, 'lgs_cost_cd') == '') {
        ComShowMessage(ComGetMsg('TES23061'));
        return false;
    }
    var sName = t5sheet1.ColSaveName(Col);
    if (sName == "lgs_cost_cd" || sName == "stay_dys" || sName == "free_dys" || sName == "paid_day" || sName == "free_dy_xcld_dys" || sName == "ovr_dys" || sName == "ctrt_rt" || sName == "vol_tr_ut_cd") {
        if (isNaN(t5sheet1.GetCellValue(Row, 'free_dys')) || parseInt(t5sheet1.GetCellValue(Row, 'free_dys'), 10) < 0) {
            t5sheet1.SetCellValue(Row, 'free_dys', 0, 0);
        }
        if (isNaN(t5sheet1.GetCellValue(Row, 'paid_day')) || parseInt(t5sheet1.GetCellValue(Row, 'paid_day'), 10) < 0) {
            t5sheet1.SetCellValue(Row, 'paid_day', 0, 0);
        }
        if (isNaN(t5sheet1.GetCellValue(Row, 'free_dy_xcld_dys')) || parseInt(t5sheet1.GetCellValue(Row, 'free_dy_xcld_dys'), 10) < 0) {
            t5sheet1.SetCellValue(Row, 'free_dy_xcld_dys', 0, 0);
        }
        t5sheet1_RecalcCalcAmt(t5sheet1, Row);
    }
    if (sName == "inv_xch_rt") {
        t5sheet1.SetCellValue(Row, 'inv_xch_rt', Math.abs(t5sheet1.GetCellValue(Row, 'inv_xch_rt')));
        if (t5sheet1.GetCellValue(Row, 'inv_xch_rt') > 0) {}
        if (t5sheet1.GetCellValue(Row, 'calc_tp_cd') == 'A') {
            if (t5sheet1.GetCellValue(Row, 'curr_cd') != undefined && t5sheet1.GetCellValue(Row, 'curr_cd') != null && t5sheet1.GetCellValue(Row, 'curr_cd') != '' &&
                curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' &&
                curr_cd.GetSelectCode() != t5sheet1.GetCellValue(Row, 'curr_cd') &&
                !isNaN(t5sheet1.GetCellValue(Row, 'inv_xch_rt')) && parseFloat(t5sheet1.GetCellValue(Row, 'inv_xch_rt')) > 0) {
                
                var nInvAmt = Number(t5sheet1.GetCellValue(Row, 'ovr_dys')) * Number(t5sheet1.GetCellValue(Row, 'ctrt_rt')) * Number(t5sheet1.GetCellValue(Row, 'inv_xch_rt'));
        
		        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
		        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
		        }
                
                t5sheet1.SetCellValue(Row, 'inv_amt', nInvAmt);
            }
        } else if (t5sheet1.GetCellValue(Row, 'calc_tp_cd') == 'M') {
            if (curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' &&
                !isNaN(t5sheet1.GetCellValue(Row, 'ovr_dys')) && parseFloat(t5sheet1.GetCellValue(Row, 'ovr_dys')) > 0 &&
                !isNaN(t5sheet1.GetCellValue(Row, 'ctrt_rt')) && parseFloat(t5sheet1.GetCellValue(Row, 'ctrt_rt')) > 0 &&
                !isNaN(t5sheet1.GetCellValue(Row, 'inv_xch_rt')) && parseFloat(t5sheet1.GetCellValue(Row, 'inv_xch_rt')) > 0) {
                
                var nInvAmt = Number(t5sheet1.GetCellValue(Row, 'ovr_dys')) * Number(t5sheet1.GetCellValue(Row, 'ctrt_rt')) * Number(t5sheet1.GetCellValue(Row, 'inv_xch_rt'));
        
		        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
		        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
		        }                
                
                t5sheet1.SetCellValue(Row, 'inv_amt', nInvAmt);
            }
        }
    }

    if (sName == "eq_no" && t5sheet1.GetCellValue(Row, 'eq_no') != "" && (t5sheet1.GetCellValue(Row, 'calc_tp_cd') == 'M' || t5sheet1.GetCellValue(Row, 'calc_tp_cd') == 'S') && searchEQFlag == false) {
        searchEQFlag = true;
        document.form.eq_no.value = t5sheet1.GetCellValue(Row, 'eq_no');
        tmp_row = Row;
        
        var rtnVal = getEquipTypeCd();     // tes_getInputValue('tmp_eq_tpsz_cd', SEARCHLIST09, 'eq_no', 'chkEqNo');
        if(rtnVal.length > 0){
        	chkEqNo(rtnVal);
        }

    } else if (sName == "eq_no" && t5sheet1.GetCellValue(Row, 'eq_no') != "" && (t5sheet1.GetCellValue(Row, 'calc_tp_cd') == 'M' || t5sheet1.GetCellValue(Row, 'calc_tp_cd') == 'S') && searchEQFlag == true) {
        alert("Different row is searching for Type/Size");
        t5sheet1.SetCellValue(Row, 'eq_no', "");
        t5sheet1.SelectCell(Row, "eq_no", 1);
    }



    if (sName == "lgs_cost_cd" && (t5sheet1.GetCellValue(Row, 'calc_tp_cd') == 'M' || t5sheet1.GetCellValue(Row, 'calc_tp_cd') == 'S')) {
        if (t5sheet1.GetCellValue(Row, 'lgs_cost_cd') == "SRNDGS") {
            t5sheet1.SetCellValue(Row, 'eq_knd_cd', "G");
            t5sheet1.SetCellValue(Row, 'eq_tpsz_cd', "CLG");
            t5sheet1.SetCellValue(Row, 'eq_no', "");
        } else {
            t5sheet1.SetCellValue(Row, 'eq_knd_cd', "Z");
            t5sheet1.SetCellValue(Row, 'eq_tpsz_cd', "CH2");
            t5sheet1.SetCellValue(Row, 'eq_no', "");
        }
    }

    if (sName == "inv_amt") {
        document.form.t5sht_tot_inv_amt.value = getShtTotCalcAmt(t5sheet1, 'inv_amt');
    }
}

//	/**
//	 *  chkEqNo
//	 */
//	function chkEqNo() {
//		var formObj=document.form;
//		
//		if (formObj.tmp_eq_tpsz_cd.value != undefined && formObj.tmp_eq_tpsz_cd.value != "undefined"  && formObj.tmp_eq_tpsz_cd.value != null && doSepRemove(formObj.tmp_eq_tpsz_cd.value, ' ') != '') {
//			sheetObjects[8].SetCellValue(tmp_row, "eq_tpsz_cd", formObj.tmp_eq_tpsz_cd.value);
//			formObj.tmp_eq_tpsz_cd.value="";
//			searchEQFlag=false;
//		} else {
////			ComShowMessage(ComGetMsg('TES24006','EQ No'));
//			alert("This EQ No. is invalid.");
//			sheetObjects[8].SelectCell(tmp_row, "eq_no", 1);
//			searchEQFlag=false;
//			document.form.eq_no.value="";
//		}
//	}


function chkEqNo(rtnVal) {
    var formObj = document.form;

    if (rtnVal != undefined && rtnVal != "undefined" && rtnVal != null && doSepRemove(rtnVal, ' ') != '') {

        var arrEqTpszCd = rtnVal.split("\\");
        if (arrEqTpszCd[1] == sheetObjects[8].GetCellValue(tmp_row, "eq_knd_cd")) {
            sheetObjects[8].SetCellValue(tmp_row, "eq_tpsz_cd", arrEqTpszCd[0]);

        } else {
            if (arrEqTpszCd[1] == 'G') { //
                alert("Please input the number of Chassis EQ.");
                t5sheet1.SetCellValue(tmp_row, 'eq_no', "");
                sheetObjects[8].SelectCell(tmp_row, "eq_no", 1);
                t5sheet1.SetCellValue(tmp_row, 'eq_tpsz_cd', "CH2");

            } else { //
                alert("Please input the number of Genset EQ.");
                t5sheet1.SetCellValue(tmp_row, 'eq_no', "");
                sheetObjects[8].SelectCell(tmp_row, "eq_no", 1);
                t5sheet1.SetCellValue(tmp_row, 'eq_tpsz_cd', "CLG");

            }
        }

        arrEqTpszCd[0] = "";
        arrEqTpszCd[1] = "";

    } else {
        //			ComShowMessage(ComGetMsg('TES24006','EQ No'));
        alert("This EQ No. is invalid.");
        t5sheet1.SetCellValue(tmp_row, 'eq_no', "");
        sheetObjects[8].SelectCell(tmp_row, "eq_no", 1);
    }

    formObj.tmp_eq_tpsz_cd.value = "";
    searchEQFlag = false;
    document.form.eq_no.value = "";
}

/**
 * Cost Calc.(FD) sheet row Amount Calculate
 * @param {sheet}	t5sheet1	Cost Calc.(FD) sheet
 * @param {int}		Row			Row Index	
 * @return
 */
function t5sheet1_RecalcCalcAmt(t5sheet1, Row) {
    var sCurrCd = document.form.curr_cd.value;
        
    if (t5sheet1.RowCount() > 0) {
        if (t5sheet1.GetCellValue(Row, 'stay_dys') == -1) {
            t5sheet1.SetRowFontColor(Row, "#FF0000");
        } else {
            t5sheet1.SetRowFontColor(Row, t5sheet1.GetDataFontColor());
        }
        if (t5sheet1.GetCellValue(Row, "calc_tp_cd") == "A") {
            t5sheet1.SetCellValue(Row, 'ovr_dys', Number(t5sheet1.GetCellValue(Row, 'ovr_dys2')) - Number(t5sheet1.GetCellValue(Row, 'paid_day')) - Number(t5sheet1.GetCellValue(Row, 'free_dy_xcld_dys')), 0);
        } else if (t5sheet1.GetCellValue(Row, "calc_tp_cd") == "M") { // S는 하지 않는다
            t5sheet1.SetCellValue(Row, 'ovr_dys', Number(t5sheet1.GetCellValue(Row, 'stay_dys')) - Number(t5sheet1.GetCellValue(Row, 'free_dys')) - Number(t5sheet1.GetCellValue(Row, 'paid_day')) - Number(t5sheet1.GetCellValue(Row, 'free_dy_xcld_dys')), 0);
        }
        var ovr_dys = Number(t5sheet1.GetCellValue(Row, 'ovr_dys'));
        if (isNaN(ovr_dys) || parseInt(ovr_dys, 10) < 0) {
            ovr_dys = 0;
            t5sheet1.SetCellValue(Row, 'ovr_dys', 0, 0);
        }
        
        var nInvAmt = Number(ovr_dys) * Number(t5sheet1.GetCellValue(Row, 'ctrt_rt')) * (Number(t5sheet1.GetCellValue(Row, 'inv_xch_rt')) > 0 ? Number(t5sheet1.GetCellValue(Row, 'inv_xch_rt')) : 1);
        
        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
        }
        
        t5sheet1.SetCellValue(Row, 'inv_amt', nInvAmt);

        if ((t5sheet1.GetCellValue(Row, 'cntr_tpsz_cd') != undefined && t5sheet1.GetCellValue(Row, 'cntr_tpsz_cd') != null && t5sheet1.GetCellValue(Row, 'cntr_tpsz_cd') != '') &&
            (t5sheet1.GetCellValue(Row, 'vol_tr_ut_cd') != undefined && t5sheet1.GetCellValue(Row, 'vol_tr_ut_cd') != null && t5sheet1.GetCellValue(Row, 'vol_tr_ut_cd') != '')) {
            
            var nInvAmt = t5sheet1.GetCellValue(Row, 'inv_amt') * tes_getTEUconv(t5sheet1.GetCellValue(Row, 'vol_tr_ut_cd'), t5sheet1.GetCellValue(Row, 'cntr_tpsz_cd'));
        
	        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
	        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
	        }
            
            t5sheet1.SetCellValue(Row, 'inv_amt', nInvAmt);
        }
    }
}

/**
 * Cost Calc.(FD) sheet save end event
 * @param {sheet}	t5sheet1	Cost Calc.(FD) sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t5sheet1_OnSaveEnd(t5sheet1, ErrMsg) {
    if (confirm_done) {
        disableSheetEditable(t5sheet1);
    }
    var formObj = document.form;
    if (t5sheet1.RowCount() > 0) {
        setElementDiabled('radio', 'StorageFD', 'Y');
        t1sheet1_SetChkBoxDisabled();
        t2sheet1_SetChkBoxDisabled();
        document.form.t5sht_tot_inv_amt.value = getShtTotCalcAmt(t5sheet1, 'inv_amt');
        
        for (var i = 1; i <= t5sheet1.RowCount(); i++) {
            if (t5sheet1.GetCellValue(i, "calc_tp_cd") == "A") {
                if (t5sheet1.GetCellValue(i, "curr_cd") != undefined && t5sheet1.GetCellValue(i, "curr_cd") != null && t5sheet1.GetCellValue(i, "curr_cd") != '' &&
                    curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' &&
                    t5sheet1.GetCellValue(i, "curr_cd") != curr_cd.GetSelectCode()) {
                    setShtCellsEditable(t5sheet1, i, 'inv_xch_rt', 'Y', 'EXCEPTION');
                }
                t5sheet1.SetCellValue(i, "calc_rmk", ComToString(t5sheet1.GetCellValue(i, "calc_rmk")), 0);
            } else if (t5sheet1.GetCellValue(i, "calc_tp_cd") == "M" || t5sheet1.GetCellValue(i, "calc_tp_cd") == "S") { //S는 t5sheet1_OnSearchEnd와 동일상태 변경없음 
                setShtCellsEditable(t5sheet1, i, 'lgs_cost_cd|rev_yrmon|stay_dys|ctrt_rt|inv_amt|inv_xch_rt', 'Y');
                setShtCellsEditable(t5sheet1, i, 'free_dys|paid_day|free_dy_xcld_dys', 'N');
                t5sheet1.SetCellValue(i, "calc_rmk", ComToString(t5sheet1.GetCellValue(i, "calc_rmk")), 0);
            }
        }
        setCalcStorageEqManualCostCode(t5sheet1);
        checkTPBdataEditable('8', t5sheet1);
    } else {
        document.form.t5sht_tot_inv_amt.value = 0;
    }
}

/**
 * Cost Calc.(FD) sheet search end event
 * @param {sheet}	t5sheet1	Cost Calc.(FD) sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t5sheet1_OnSearchEnd(t5sheet1, ErrMsg) {
    if (confirm_done) {
        disableSheetEditable(t5sheet1);
    }
    var formObj = document.form;
    if (t5sheet1.RowCount() > 0) {
        setElementDiabled('radio', 'StorageFD', 'Y');
        t1sheet1_SetChkBoxDisabled();
        t2sheet1_SetChkBoxDisabled();
        document.form.t5sht_tot_inv_amt.value = getShtTotCalcAmt(t5sheet1, 'inv_amt');
        
        for (var i = 1; i <= t5sheet1.RowCount(); i++) {
            if (t5sheet1.GetCellValue(i, "calc_tp_cd") == "A") {
                t5sheet1.SetCellValue(i, "calc_rmk", ComToString(t5sheet1.GetCellValue(i, "calc_rmk")), 0);

                if (t5sheet1.GetCellValue(i, "curr_cd") != undefined && t5sheet1.GetCellValue(i, "curr_cd") != null && t5sheet1.GetCellValue(i, "curr_cd") != '' &&
                    curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' &&
                    t5sheet1.GetCellValue(i, "curr_cd") != curr_cd.GetSelectCode()) {
                    setShtCellsEditable(t5sheet1, i, 'inv_xch_rt', 'Y', 'EXCEPTION');
                }
            } else if (t5sheet1.GetCellValue(i, "calc_tp_cd") == "M") {
                t5sheet1.SetCellValue(i, "calc_rmk", ComToString(t5sheet1.GetCellValue(i, "calc_rmk")), 0);

                setShtCellsEditable(t5sheet1, i, 'lgs_cost_cd|eq_no|rev_yrmon|stay_dys|ctrt_rt|inv_amt|inv_xch_rt', 'Y');
                setShtCellsEditable(t5sheet1, i, 'free_dys|paid_day|free_dy_xcld_dys', 'N');

            } else if (t5sheet1.GetCellValue(i, "calc_tp_cd") == "S") {
                t5sheet1.SetCellValue(i, "calc_rmk", ComToString(t5sheet1.GetCellValue(i, "calc_rmk")), 0);

                setShtCellsEditable(t5sheet1, i, 'rev_yrmon|inv_amt', 'Y', 'EXCEPTION');
                setShtCellsEditable(t5sheet1, i, 'stay_dys|free_dys|paid_day|free_dy_xcld_dys|ovr_dys|calc_vol_qty|ctrt_rt|inv_xch_rt|', 'N', 'EXCEPTION');
            }
        }
        setCalcStorageEqManualCostCode(t5sheet1);
        checkTPBdataEditable('8', t5sheet1);
    } else {
        document.form.t5sht_tot_inv_amt.value = 0;
    }
    //t1sheet1_SetColmnEditable();
}

/**
 * Cost Calc.(FD) sheet click event
 * @param {sheet}	sheetObj	Cost Calc.(FD) sheet
 * @param {int}		row			selected row
 * @param {int}		col			selected col
 * @return
 */
function t5sheet1_OnPopupClick(sheetObj, row, col) {
    var formObj = document.form;
    if (sheetObj.ColSaveName(col) == "n3pty_flg") {
        if (sheetObj.GetCellValue(row, 'tml_so_dtl_seq') == '' || sheetObj.GetCellValue(row, 'tml_so_dtl_seq') == null || sheetObj.GetCellValue(row, 'tml_so_dtl_seq') == 0) {
            ComShowMessage('You have to 3rd party Input after save calculated result.');
            return false;
        }
        if (sheetObj.GetCellValue(row, 'calc_cost_grp_cd') == null || doSepRemove(sheetObj.GetCellValue(row, 'calc_cost_grp_cd'), ' ') == '') {
            ComShowMessage(ComGetMsg('TES24046'));
            return false;
        }
        if (formObj.curr_cd.value == null || doSepRemove(formObj.curr_cd.value, ' ') == '') {
            ComShowMessage(ComGetMsg('TES40041', 'Currency code'));
            return false;
        }
        if (sheetObj.GetCellValue(row, 'lgs_cost_cd') == undefined ||
            sheetObj.GetCellValue(row, 'lgs_cost_cd') == null ||
            sheetObj.GetCellValue(row, 'lgs_cost_cd') == '') {
            ComShowMessage(ComGetMsg('TES23045'));
            return false;
        }
        if (sheetObj.GetCellValue(row, 'inv_amt') != undefined &&
            sheetObj.GetCellValue(row, 'inv_amt') != null &&
            sheetObj.GetCellValue(row, 'inv_amt') < 0) {
            return false;
        }
        var url_str = 'ESD_TES_9234Popup.screen';
        url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
        url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
        url_str = url_str + '&tml_so_dtl_seq=' + sheetObj.GetCellValue(row, 'tml_so_dtl_seq');
        url_str = url_str + '&calc_cost_grp_cd=' + sheetObj.GetCellValue(row, 'calc_cost_grp_cd');
        url_str = url_str + '&calc_tp_cd=' + sheetObj.GetCellValue(row, 'calc_tp_cd');
        url_str = url_str + '&vndr_seq=' + formObj.vndr_seq.value;
        url_str = url_str + '&inv_no=' + formObj.inv_no.value;
        url_str = url_str + '&param_lgs_cost_cd=' + sheetObj.GetCellValue(row, 'lgs_cost_cd');
        url_str = url_str + '&param_cntr_tpsz_cd=' + sheetObj.GetCellValue(row, 'cntr_tpsz_cd');
        url_str = url_str + '&curr_cd=' + formObj.curr_cd.value;
        url_str = url_str + '&sheet_curr_row=' + row;
        url_str = url_str + '&sheet_idx=5';
        url_str = url_str + '&param_cntr_no=' + sheetObj.GetCellValue(row, 'cntr_no');
        url_str = url_str + '&inv_amt=' + sheetObj.GetCellValue(row, 'inv_amt');
        url_str = url_str + '&yd_cd=' + formObj.yd_cd.value;
        url_str = url_str + '&ctrt_rt=' + sheetObj.GetCellValue(row, 'ctrt_rt');
        url_str = url_str + '&inv_xch_rt=' + sheetObj.GetCellValue(row, 'inv_xch_rt');
        url_str = url_str + '&ovr_dys=' + sheetObj.GetCellValue(row, 'ovr_dys');
        //ComOpenWindow(url_str,  window,  "dialogWidth:710px; dialogHeight:440px; help:no; status:no; resizable:yes;" , true);
        ComOpenWindow(url_str, window, "help:no;status:no;resizable:yes;dialogWidth:" + 820 + "px;dialogHeight:" + 450 + "px", true);
    }
}

/**
 * Cost Calc.(FD) sheet click event
 * @param {sheet}	t5sheet1	Cost Calc.(FD) sheet
 * @param {int}		Row			Row Index
 * @param {int}		Col			Column Index
 * @param {string}	Value		
 * @return
 */
function t5sheet1_OnClick(t5sheet1, Row, Col, Value) {
    if (t5sheet1.ColSaveName(Col) == 'inv_amt') {}
}


/**
 * Verification tab summary display
 * @return
 */

function reSize() {
    var div01 = document.all.SearchLayer01.style.display;
    var div02 = document.all.SearchLayer02.style.display;
    var obj = ComGetEvent();
    if (obj = "btn_resize") {
        if (div01 == "inline") {
            //obj.src="/opuscntr/img/bu_prev01.gif";
            document.getElementById("btn_resize").className = "btn_down";
            document.all.SearchLayer01.style.display = "none";
            document.all.SearchLayer02.style.display = "none";
        } else {
            //obj.src="/opuscntr/img/bu_next01.gif";
            document.getElementById("btn_resize").className = "btn_up";
            document.all.SearchLayer01.style.display = "inline";
            document.all.SearchLayer02.style.display = "inline";
        }
    }
}

/**
 * set [hld_rmk]
 * @return
 */
function setHldRmk() {
    var formObj = document.form;
    if (formObj.hld_flg.checked == false) {
        formObj.hld_rmk.value = '';
    }
}

/**
 * agreement currency code, so header check currency code
 * @return
 */
function validateAgmtCurrCD() {
    document.form.agmtCurrCd.value =  getAgmtCurrCd();      // tes_getInputValueInvoice('agmtCurrCd', SEARCH01, 'tml_inv_tp_cd|yd_cd|vndr_seq|to_prd_dt', '');
}

/**
 * currency agreement check currency code
 * @return
 */
function isValidAgmtCurrCD() {
    var formObj = document.form;
    //ComShowMessage(formObj.agmtCurrCd.value + ' / ' + formObj.curr_cd.Code);
    if (formObj.curr_cd.GetSelectCode() == null || doSepRemove(formObj.curr_cd.GetSelectCode(), ' ') == '') {
        ComShowMessage(ComGetMsg('TES40039'));
        return false;
    }
    
    if (formObj.curr_cd.GetSelectCode() != main_hidden.GetCellValue(1, 'curr_cd')) {
        ComShowMessage(ComGetMsg('TES40040'));
        return false;
    }
    
    if (formObj.fm_prd_dt.value == null || doSepRemove(formObj.fm_prd_dt.value, ' ') == '') {
        ComShowMessage(ComGetMsg('TES40038'));
        return false;
    }
    
    if (formObj.fm_prd_dt.value != main_hidden.GetCellValue(1, 'fm_prd_dt')) {
        ComShowMessage(ComGetMsg('TES40037'));
        return false;
    }
    
    if (formObj.agmtCurrCd.value == null || doSepRemove(formObj.agmtCurrCd.value, ' ') == '') {
        ComShowMessage(ComGetMsg('TES40030'));
        document.form.agmtCurrCd.value =  getAgmtCurrCd();      // tes_getInputValueInvoice('agmtCurrCd', SEARCH01, 'tml_inv_tp_cd|yd_cd|vndr_seq|to_prd_dt', '');        
        return false;
    } else {
        if (doSepRemove(formObj.agmtCurrCd.value, ' ') != doSepRemove(formObj.curr_cd.GetSelectCode(), ' ')) {
            return false;
        }
    }
    return true;
}

/**
 * agreement get status
 * @return
 */
function validateAgmtSts() {
    if (document.form.fm_prd_dt.value != undefined && document.form.fm_prd_dt.value != null && doSepRemove(document.form.fm_prd_dt.value, ' ') != '') {
        document.form.agmtSts.value = getAgmtStatusCd(); // tes_getInputValueInvoice('agmtSts', SEARCH04, 'tml_inv_tp_cd|yd_cd|vndr_seq|to_prd_dt', '');
    }
}


/**
 * agreement validation check status
 * @return {boolean} 
 */
function isValidAgmtSts() {
    var formObj = document.form;
    var tmp = '';
    tmp = formObj.agmtSts.value;
    if (tmp != undefined && tmp != null && tmp != '') {
        tmp = tmp.split('|');
        if (tmp.length > 0) {
            if (tmp[0] != null && !isNaN(tmp[0])) {
                if (parseInt(tmp[0]) > 0) {
                    if (tmp[1] != undefined && tmp[1] != null) {
                        if (tmp[1] == 'C') {
                            return true;
                        } else if (tmp[1] == 'P') {
                            ComShowMessage(ComGetMsg('TES40004'));
                            return false;
                        } else {
                            ComShowMessage(ComGetMsg('TES40003'));
                            return false;
                        }
                    }
                } else if (parseInt(tmp[0]) == 0) {
                    ComShowMessage(ComGetMsg('TES40005'));
                    return false;
                } else {
                    ComShowMessage(ComGetMsg('TES22030')); //ComShowMessage('[ERR-Agreement_01]');
                    return false;
                }
            } else {
                ComShowMessage(ComGetMsg('TES22030')); //ComShowMessage('[ERR-Agreement_02]');
                return false;
            }
        } else {
            ComShowMessage(ComGetMsg('TES22030')); //ComShowMessage('[ERR-Agreement_03]');
            return false;
        }
    } else {
        ComShowMessage(ComGetMsg('TES22030')); //ComShowMessage('[ERR-Agreement_04]');
        return false;
    }
    return true;
}

/**
 * validation check [Error Inv. No.]
 * @return
 */
function validateErrInvNo() {
    var formObj = document.form;
    formObj.err_inv_no.value = doSepRemove(formObj.err_inv_no.value, ' ');
    if (formObj.err_inv_no.value != null && doSepRemove(formObj.err_inv_no.value, ' ') != '') {
		if(!getErrInvValidYN()){     // tes_getInputValueInvoice('is_valid_err_inv_no', SEARCH03, 'tml_inv_tp_cd|yd_cd|vndr_seq|err_inv_no', 'checkValidErrInvNo');
    		formObj.is_valid_err_inv_no.value = '';
    	}      
    }
}

/**
 * validation check [Cost OFC] get Cost OFC Code
 * @return
 */
function validateCostOFC() {
    var formObj = document.form;
    if (formObj.cost_ofc_cd.value == null || doSepRemove(formObj.cost_ofc_cd.value, ' ') == '') {
        formObj.cost_ofc_cd_hidden.value = '';
        formObj.is_valid_cost_ofc_cd.value = '';
        return false;
    }
    if (formObj.cost_ofc_cd.readOnly == false) {
        if ((formObj.cost_ofc_cd_hidden.value == null || doSepRemove(formObj.cost_ofc_cd_hidden.value, ' ') == '') || doSepRemove(formObj.cost_ofc_cd.value, ' ') != doSepRemove(formObj.cost_ofc_cd_hidden.value, ' ')) {
            formObj.cost_ofc_cd_hidden.value = '';
            formObj.is_valid_cost_ofc_cd.value = '';           
            
            if(getCostOfcValidYN()){  // tes_getInputValue('is_valid_cost_ofc_cd', SEARCH04, 'cost_ofc_cd|yd_cd', 'checkValidCostOfc');
            	formObj.is_valid_cost_ofc_cd.value = "Y";
            } 
        }
    }
}

/**
 * validation check [Yard Code] get Yard Code
 * @return
 */
function validateYardCode() {
    var formObj = document.form;
    if (formObj.yd_cd.value == null || doSepRemove(formObj.yd_cd.value, ' ') == '') {
        formObj.yd_cd_hidden.value = '';
        formObj.is_valid_yd_cd.value = '';
        return false;
    }
    if ((formObj.yd_cd_hidden.value == null || doSepRemove(formObj.yd_cd_hidden.value, ' ') == '') || doSepRemove(formObj.yd_cd.value, ' ') != doSepRemove(formObj.yd_cd_hidden.value, ' ')) {
        formObj.is_valid_yd_cd.value = '';
       	var rtnVal = getYdCdCostCdList(); // tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');	        
	    if(rtnVal.length > 0){
	    	checkValidYardCode(rtnVal);
	    }	
    }
}

/**
 * validation check [S/P Code] get S/P Name
 * @return
 */
function validateVndrSeq() {
    var formObj = document.form;
    if (formObj.vndr_seq.value == null || doSepRemove(formObj.vndr_seq.value, ' ') == '') {
        formObj.vndr_seq_hidden.value = '';
        formObj.is_valid_vndr_seq.value = '';
        return false;
    }
    if ((formObj.vndr_seq_hidden.value == null || doSepRemove(formObj.vndr_seq_hidden.value, ' ') == '') || doSepRemove(formObj.vndr_seq.value, ' ') != doSepRemove(formObj.vndr_seq_hidden.value, ' ')) {
        formObj.vndr_seq_hidden.value = '';
        formObj.is_valid_vndr_seq.value = '';
        
        var sRtnVal = getVndrSeqNm();
        if(sRtnVal == "Y"){
        	formObj.is_valid_vndr_seq.value = sRtnVal;
        	formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
        }
        
        //doActionMainHiddenSheet(sheetObjects[4], formObj, IBSEARCH_ASYNC05);
        //tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVndrCode');
    }
}

/**
 * set [Cost OFC] 
 * @return
 */
function setCostOfcReadOnlyFalse(argOfcCd) {
    var formObj = document.form;   
    if (confirm_done == false) {
        formObj.cost_ofc_cd.readOnly = false;
    }
    
    if(!tesIsEmpty(argOfcCd)){
    	formObj.cost_ofc_cd.value = argOfcCd;
    	formObj.is_valid_cost_ofc_cd.value = 'Y';
    }
}

/**
 * validation check [Error Inv. No.]
 * @return
 */
function checkValidErrInvNo() {
    var formObj = document.form;
    //ComShowMessage('checkValidErrInvNo - is_valid_err_inv_no:'+formObj.is_valid_err_inv_no.value);
    if (formObj.is_valid_err_inv_no.value != undefined && formObj.is_valid_err_inv_no.value != null && doSepRemove(formObj.is_valid_err_inv_no.value, ' ') == 'Y') {} else {
        formObj.is_valid_err_inv_no.value = '';
        ComShowMessage(ComGetMsg('TES40058', 'ERR INV.NO'));
    }
}

/**
 * validation check [Cost OFC]
 * @return
 */
function checkValidCostOfc() {
    var formObj = document.form;
    var tmp = '';
    if (formObj.is_valid_cost_ofc_cd.value != undefined && formObj.is_valid_cost_ofc_cd.value != null && doSepRemove(formObj.is_valid_cost_ofc_cd.value, ' ') != '') {
        tmp = formObj.is_valid_cost_ofc_cd.value.split('|');
        if (tmp.length > 0) {
            formObj.is_valid_cost_ofc_cd.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_cost_ofc_cd.value != null && formObj.is_valid_cost_ofc_cd.value == 'Y') {
                if (tmp[1] != undefined && tmp[1] != null && tmp[1] != '') {
                    if (tmp[1] != 'Y') {
                        ComShowMessage(ComGetMsg('TES21036'));
                        //formObj.yd_cd.focus();
                    }
                } else {
                    ComShowMessage(ComGetMsg('TES21037'));
                }
            } else {
                formObj.is_valid_cost_ofc_cd.value = '';
                ComShowMessage(ComGetMsg('TES21038'));
            }
        } else {
            formObj.is_valid_cost_ofc_cd.value = '';
            ComShowMessage(ComGetMsg('TES21038'));
        }
    } else {
        formObj.is_valid_cost_ofc_cd.value = '';
        ComShowMessage(ComGetMsg('TES21038'));
    }
}

/**
 * validation check [Yard Code]
 * @return
 */
function checkValidYardCode(rtnVal) {
    var formObj = document.form;
    var tmp = '';
    var tmp_yd_cd_hidden = '';
    //ComShowMessage(formObj.is_valid_yd_cd.value);
    if (rtnVal != undefined && rtnVal != null && doSepRemove(rtnVal, ' ') != '') {
        tmp = rtnVal.split('--');
        if (tmp.length > 0) {
            formObj.is_valid_yd_cd.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_yd_cd.value != null && formObj.is_valid_yd_cd.value == 'Y') {
                //ComShowMessage('yd_cd_hidden:' + formObj.yd_cd_hidden.value + '\nyd_cd:' + formObj.yd_cd.value);
                if (formObj.yd_cd.value != null && doSepRemove(formObj.yd_cd.value, ' ') != '' && formObj.yd_cd_hidden.value != formObj.yd_cd.value) {
                    if (sheetObjects[4].RowCount() > 0 && doSepRemove(formObj.yd_cd.value, ' ') != doSepRemove(sheetObjects[4].GetCellValue(1, 'yd_cd'), ' ') &&
                        (sheetObjects[0].RowCount() > 0 || sheetObjects[1].RowCount() > 0 || sheetObjects[2].RowCount() > 0 || sheetObjects[3].RowCount() > 0 || sheetObjects[8].RowCount() > 0)) {
                        if (!confirm(ComGetMsg('TES23062'))) {
                            formObj.yd_cd.value = formObj.yd_cd_hidden.value;
                            return false;
                        } else {
                            ComShowMessage(ComGetMsg('TES23004'));
                            removeStorageInvoice01();
                            removeStorageInvoice02();
                        }
                    }
                }
                tmp_yd_cd_hidden = formObj.yd_cd_hidden.value;
                formObj.yd_cd_hidden.value = formObj.yd_cd.value;
                //					formObj.yd_nm.value=(tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');
                formObj.yd_chr_cd.value = (tmp[3] != undefined && tmp[3] != null ? tmp[3] : '');
                formObj.yd_fcty_tp_mrn_tml_flg.value = (tmp[4] != undefined && tmp[4] != null ? tmp[4] : '');
                formObj.yd_fcty_tp_cy_flg.value = (tmp[5] != undefined && tmp[5] != null ? tmp[5] : '');
                formObj.yd_fcty_tp_cfs_flg.value = (tmp[6] != undefined && tmp[6] != null ? tmp[6] : '');
                formObj.yd_fcty_tp_rail_rmp_flg.value = (tmp[7] != undefined && tmp[7] != null ? tmp[7] : '');
                formObj.yd_oshp_cd.value = (tmp[8] != undefined && tmp[8] != null ? tmp[8] : '');
                formObj.calcStorageComboItems.value = (tmp[13] != undefined && tmp[13] != null ? tmp[13] : '');
                formObj.calcStorageEqComboItems.value = (tmp[14] != undefined && tmp[14] != null ? tmp[14] : '');
                var rtnOfcCd = "";
                if (sheetObjects[4].RowCount() == 0 ||
                    ((formObj.yd_cd != undefined && formObj.yd_cd.value != null && formObj.yd_cd.value != '' &&
                            tmp_yd_cd_hidden != undefined && tmp_yd_cd_hidden != null && tmp_yd_cd_hidden != '' &&
                            formObj.yd_cd.value != tmp_yd_cd_hidden) ||
                        (formObj.cost_ofc_cd_hidden != undefined && formObj.cost_ofc_cd_hidden.value != null && formObj.cost_ofc_cd_hidden.value != '' &&
                            formObj.cost_ofc_cd != undefined && formObj.cost_ofc_cd.value != null && formObj.cost_ofc_cd.value != '' &&
                            formObj.cost_ofc_cd_hidden.value != formObj.cost_ofc_cd.value))) {
                            
                    rtnOfcCd = getOfcCdByYardCd(); //tes_getInputValue('cost_ofc_cd', SEARCH02, 'yd_cd', 'setCostOfcReadOnlyFalse');
                    setCostOfcReadOnlyFalse(rtnOfcCd);
                    
                } else {
                    setCostOfcReadOnlyFalse(rtnOfcCd);
                }
                if (sheetObjects[2].RowCount() > 0) {
                    setCalcStorageManualCostCode(sheetObjects[2]);
                }
                if (sheetObjects[3].RowCount() > 0) {
                    setCalcStorageManualCostCode(sheetObjects[3]);
                }
                if (sheetObjects[8].RowCount() > 0) {
                    setCalcStorageEqManualCostCode(sheetObjects[8]);
                }
            } else {
                formObj.is_valid_yd_cd.value = '';
                formObj.yd_cd_hidden.value = '';
                formObj.yd_nm.value = '';
                ComShowMessage(ComGetMsg('TES10066'));
            }
        } else {
            formObj.is_valid_yd_cd.value = '';
            formObj.yd_cd_hidden.value = '';
            formObj.yd_nm.value = '';
            ComShowMessage(ComGetMsg('TES10066'));
        }
    } else {
        formObj.is_valid_yd_cd.value = '';
        formObj.yd_cd_hidden.value = '';
        formObj.yd_nm.value = '';
        ComShowMessage(ComGetMsg('TES10066'));
    }
}

/** replaceAll
 * 
 */
function replaceAll(temp, org, rep) {
    return temp.split(org).join(rep);
}

/**
 *  setAgmtCostCd
 */
function setAgmtCostCd() {
    var formObj = document.form;
    var costCdFtrRmk = formObj.cost_cd_ftr_rmk.value;

    if (costCdFtrRmk != null && costCdFtrRmk != "") {
        var tmpArr = costCdFtrRmk.split("|");

        for (var i = 0; i < tmpArr.length; i++) {
            agmt_lgs_cost_cd.SetSelectCode(tmpArr[i]);
        }
    }
}

/**
 * validation check [S/P Code]
 * @return
 */
function checkValidVndrCode() {
    var formObj = document.form;
    var tmp = '';
    if (formObj.is_valid_vndr_seq.value != undefined && formObj.is_valid_vndr_seq.value != null && doSepRemove(formObj.is_valid_vndr_seq.value, ' ') != '') {
        tmp = formObj.is_valid_vndr_seq.value.split('|');
        if (tmp.length > 0) {
            formObj.is_valid_vndr_seq.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_vndr_seq.value != null && formObj.is_valid_vndr_seq.value == 'Y') {
                formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
                //					formObj.vndr_seq_nm.value=(tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
            } else {
                formObj.is_valid_vndr_seq.value = '';
                formObj.vndr_seq_hidden.value = '';
                ComShowMessage(ComGetMsg('TES21040'));
            }
        } else {
            formObj.is_valid_vndr_seq.value = '';
            formObj.vndr_seq_hidden.value = '';
            ComShowMessage(ComGetMsg('TES21040'));
        }
    } else {
        formObj.is_valid_vndr_seq.value = '';
        formObj.vndr_seq_hidden.value = '';
        ComShowMessage(ComGetMsg('TES21040'));
    }
}

/**
 * set common code
 * @return
 */
function setCommonCode() {
    var formObj = document.form;
    var tmp = '';
    if (formObj.tmp_common_code.value != undefined && formObj.tmp_common_code.value != null && doSepRemove(formObj.tmp_common_code.value, ' ') != '') {
        tmp = formObj.tmp_common_code.value.split('--');
        if (tmp.length > 0) {
            for (var i = 0; i < tmp.length; i++) {
                tmp[i] = (tmp[i] != undefined && tmp[i] != null ? tmp[i] : '');
            }
            CNTR_TPSZ_CD = tmp[0];
            ST_A_LGS_COST_CD = tmp[5];
            EQ_TPSZ_CD = tmp[7];
        }
    }
    sheetObjects[1].SetColProperty("cntr_tpsz_cd", { ComboText: CNTR_TPSZ_CD, ComboCode: CNTR_TPSZ_CD });
    sheetObjects[2].SetColProperty("cntr_tpsz_cd", { ComboText: CNTR_TPSZ_CD, ComboCode: CNTR_TPSZ_CD });
    sheetObjects[2].SetColProperty("lgs_cost_cd", { ComboText: ST_A_LGS_COST_CD, ComboCode: ST_A_LGS_COST_CD });
    sheetObjects[3].SetColProperty("lgs_cost_cd", { ComboText: ST_A_LGS_COST_CD, ComboCode: ST_A_LGS_COST_CD });
    sheetObjects[8].SetColProperty("lgs_cost_cd", { ComboText: "SRNDCH|SRNDGS", ComboCode: "SRNDCH|SRNDGS" });
    sheetObjects[8].SetColProperty("eq_tpsz_cd", { ComboText: EQ_TPSZ_CD, ComboCode: EQ_TPSZ_CD });
    var formObj = document.form;
    if (!ComIsNull(formObj.inv_no_tmp.value)) {
        formObj.inv_no.value = formObj.inv_no_tmp.value;
        formObj.vndr_seq.value = vndr_seq;
        retrieve('Y');
    }
}


//	function setPeriodFromTo(){
//		var formObj = document.form;
//		var to_dt = new String(formObj.DB_DATE.value).substring(0,8);
//		var fr_dt;
//		if (to_dt!=undefined && to_dt!=null && to_dt!='' && to_dt.length==8 && !isNaN(to_dt)){
//			fr_dt = tes_getDiffDate(to_dt, -1, 'M') + to_dt.substring(6,8);
//			if (fr_dt!=undefined && fr_dt!=null && fr_dt!='' && fr_dt.length==8){
//				if (fr_dt.substring(6,8) > getEndDay(fr_dt.substring(0,4),fr_dt.substring(4,6))){
//					fr_dt = fr_dt.substring(0,6) + getEndDay(fr_dt.substring(0,4),fr_dt.substring(4,6));
//				}
//				formObj.fm_eff_dt.value = fr_dt.substring(0,4)+'-'+fr_dt.substring(4,6)+'-'+fr_dt.substring(6,8);
//				formObj.to_eff_dt.value = to_dt.substring(0,4)+'-'+to_dt.substring(4,6)+'-'+to_dt.substring(6,8);
//			}
//		}
//	}

/**
 * set [S/P Code], [Inv. No.] readonly
 * @param {string}	READONLY_YN		Y or N
 * @return
 */
function setHeaderKeyValueReadonly(READONLY_YN) {
    var formObj = document.form;
    if (READONLY_YN != undefined && READONLY_YN != null && doSepRemove(READONLY_YN, ' ') == 'Y') {
        formObj.vndr_seq.readOnly = true;
        formObj.inv_no.readOnly = true;
    } else {
        formObj.vndr_seq.readOnly = false;
        formObj.inv_no.readOnly = false;
    }
    //ComEnableObject(formObj.vndr_seq, formObj.vndr_seq.readOnly);
    //ComEnableObject(formObj.inv_no, formObj.inv_no.readOnly);
}

/**
 * Calculated AMT
 * @param 	{sheet}	sheetObj			ibsheet
 * @param 	{string}colnm				column name
 * @return	{int}	tot_inv_amt_val		Calculated AMT
 */
function getShtTotCalcAmt(sheetObj, colnm) {
    var tot_inv_amt_val = 0;
    for (var i = sheetObj.HeaderRows(); i < (sheetObj.HeaderRows() + sheetObj.RowCount()); i++) {
        //no support[check again]CLT if (sheetObj.RowSumable(i) && sheetObj.GetCellValue(i,colnm)!=null && sheetObj.GetCellValue(i,colnm)!='' &&

        if ((sheetObj.GetCellValue(i, "calc_tp_cd") == "M" || sheetObj.GetCellValue(i, "calc_tp_cd") == "S" || sheetObj.GetCellValue(i, "calc_tp_cd") == "A") && sheetObj.GetCellValue(i, colnm) != undefined && !isNaN(parseFloat(sheetObj.GetCellValue(i, colnm))) && sheetObj.GetRowStatus(i) != 'D') {
            //tot_inv_amt_val = Number(tot_inv_amt_val) + Number(parseFloat(sheetObj.GetCellValue(i,colnm)));
            tot_inv_amt_val = Math.round(Number(tot_inv_amt_val) * 1000) / 1000 + Math.round(Number(sheetObj.GetCellValue(i, colnm)) * 1000) / 1000;

        }
    }
    tot_inv_amt_val = Math.round(Number(tot_inv_amt_val) * 1000) / 1000;
    tot_inv_amt_val = tes_chkAmtFmt(tot_inv_amt_val, curr_cd.GetSelectCode());
    return tot_inv_amt_val;
}


//		/**
//	 * @param {string}	src
//	 * @return
//	 */
//	function matchManualStorageCostCode(src){
//		if (src==undefined || src==null || src==''){return false;}
//		var formObj = document.form;
//		var arr_cost_cd;
//		if (formObj.calcStorageComboItems.value!=null && formObj.calcStorageComboItems.value!=''){
//			arr_cost_cd = formObj.calcStorageComboItems.value.split('|');
//		}
//		for (var i=0; arr_cost_cd!=null && i<arr_cost_cd.length; i++){
//			if (src==arr_cost_cd[i]){
//				return true; 
//			}
//		}
//		return false;
//	}
//
//	function setShtStatus(sheetObj, sts_colnm, to_sts) {
//		if (sheetObj.RowCount > 0)
//		{
//			if (sts_colnm!=null && sts_colnm!=undefined && sts_colnm!='' &&
//				to_sts!=null && to_sts!=undefined && to_sts!='')
//			{
//				for (i=1; i<sheetObj.Rows; i++)
//				{
//					sheetObj.SetCellValue(i,sts_colnm) = to_sts;
//				}
//			}
//		}
//	}
//
//	function setShtStatus2(sheetObj, to_sts) {
//		if (sheetObj.RowCount > 0)
//		{
//			if (to_sts!=null && to_sts!=undefined && to_sts!='')
//			{
//				for (i=1; i<sheetObj.Rows; i++)
//				{
//					sheetObj.RowStatus(i) = to_sts;
//				}
//			}
//		}
//	}

/**
 * mandatory value validation check
 * @return
 */
function fnChkSearchForm() {
    var formObj = document.form;
    if (formObj.vndr_seq.value == null || formObj.vndr_seq.value == '') {
        ComShowMessage(ComGetMsg('TES23007', 'VNDR Code'));
        formObj.vndr_seq.focus();
        return false;
    } else if (formObj.inv_no.value == null || formObj.inv_no.value == '') {
        ComShowMessage(ComGetMsg('TES21026', 'Inv No'));
        formObj.inv_no.focus();
        return false;
    }
    return true;
}

/**
 * set element disabled
 * @return
 */
function setElementDiabled(eleTp, eleNm, ELE_DISABLED) {
    if (eleNm == undefined || eleNm == null || eleNm == '' ||
        eleTp == undefined || eleTp == null || eleTp == '' ||
        ELE_DISABLED == undefined || ELE_DISABLED == null || ELE_DISABLED == '') {
        return false;
    }
    var formObj = document.form;
    var numOfEle = formObj.elements.length;
    for (var i = 0; i < numOfEle; i++) {
        if (formObj.elements[i].type == eleTp && formObj.elements[i].name == eleNm) {
            formObj.elements[i].disabled = (ELE_DISABLED == 'Y' ? true : false);
        }
    }
}

/**
 * check element
 * @param {string}	eleTp			element
 * @param {string}	eleNm			element
 * @param {string}	ELE_CHECKED		
 * @return
 */
function setElementChecked(eleTp, eleNm, ELE_CHECKED) {
    if (eleNm == undefined || eleNm == null || eleNm == '' || eleTp == undefined || eleTp == null || eleTp == '' || ELE_CHECKED == undefined || ELE_CHECKED == null || ELE_CHECKED == '') {
        return false;
    }
    var formObj = document.form;
    var numOfEle = formObj.elements.length;
    for (var i = 0; i < numOfEle; i++) {
        if (formObj.elements[i].type == eleTp && formObj.elements[i].name == eleNm) {
            formObj.elements[i].checked = (ELE_CHECKED == 'Y' ? true : false);
        }
    }
}

/**
 * get form element count
 * @param {form}	formObj		form
 * @param {string}	eleTp		element
 * @param {string}	eleNm		element
 * @return
 */
function getElementCnt(formObj, eleTp, eleNm) {
    var cnt = 0;
    var element;
    var numOfEle = formObj.elements.length;
    for (var i = 0; i < numOfEle; i++) {
        if (formObj.elements[i].type == eleTp && formObj.elements[i].name == eleNm) {
            cnt++;
        }
    }
    return cnt;
}

/**
 * add '&'
 * @param params
 * @return
 */
function getSaveString(params) {
    var saveString = null;
    if (params == null) {
        saveString = "";
    } else {
        saveString = params.join("&");
    }
    return saveString;
}

/**
 * [Period] change event
 * @return
 */
function period_ChkMod() {
    var formObj = document.form;
    if (hasAutoCalcData(sheetObjects[2]) || hasAutoCalcData(sheetObjects[3])) {
        if (formObj.fm_prd_dt.value != sheetObjects[4].GetCellValue(1, 'fm_prd_dt') || formObj.to_prd_dt.value != sheetObjects[4].GetCellValue(1, 'to_prd_dt')) {
            if (confirm(ComGetMsg('TES40009'))) {
                removeAutoCalcDataAll();
            } else {
                formObj.fm_prd_dt.value = sheetObjects[4].GetCellValue(1, 'fm_prd_dt');
                formObj.to_prd_dt.value = sheetObjects[4].GetCellValue(1, 'to_prd_dt');
                return false;
            }
        }
    }
    return false;
}

/**
 * validation check [Period]
 * @param {string]	obj	
 * @return
 */
function validateDateObj(obj) {
    if (obj.readOnly == true) {
        return false;
    }
    obj.value = obj.value;
    if (obj.value == null || obj.value == '') {
        return false;
    }
    if (!checkPeriodFormat(obj.value) || !tes_isValidDateObject(obj.value, '-')) {
        ComShowMessage(ComGetMsg('TES23011'));
        obj.focus();
        return false;
    }
    var formObj = document.form;
    if (formObj.fm_prd_dt.value != null && doSepRemove(formObj.fm_prd_dt.value, ' ') != '' &&
        formObj.to_prd_dt.value != null && doSepRemove(formObj.to_prd_dt.value, ' ') != '' &&
        !isValFmTo(formObj.fm_prd_dt.value, formObj.to_prd_dt.value)) {
        ComShowMessage(ComGetMsg('TES24012'));
        return false;
    }
    return true;
}

/**
 * validation check from date, to date
 * @param {string}	fmDt	
 * @param {string}	toDt	
 * @return
 */
function isValFmTo(fmDt, toDt) {
    if (fmDt == undefined || fmDt == null || doSepRemove(fmDt, ' ') == '' || toDt == undefined || toDt == null || doSepRemove(toDt, ' ') == '') {
        return false;
    }
    var str_fmDt = fmDt.replace(/-/gi, '');
    var str_toDt = toDt.replace(/-/gi, '');
    if (isNaN(str_fmDt) || isNaN(str_toDt) || doSepRemove(str_fmDt, ' ').length != 8 || doSepRemove(str_toDt, ' ').length != 8) {
        return false;
    }
    if (parseInt(str_toDt, 10) - parseInt(str_fmDt, 10) <= 0) {
        return false;
    }
    return true;
}

/**
 * validation check [Issue DT], [RCV Date]
 * @param {string]	obj	
 * @return
 */
function validateDateObj2(obj) {
    if (obj.readOnly == true) {
        return false;
    }
    obj.value = obj.value;
    if (obj.value == null || obj.value == '') {
        return false;
    }
    if (!checkPeriodFormat(obj.value) || !tes_isValidDateObject(obj.value, '-')) {
        ComShowMessage(ComGetMsg('TES23011'));
        obj.focus();
        return false;
    }
    var formObj = document.form;
    if (formObj.iss_dt.value != null && doSepRemove(formObj.iss_dt.value, ' ') != '' &&
        formObj.rcv_dt.value != null && doSepRemove(formObj.rcv_dt.value, ' ') != '' &&
        !isValIssRcv()) {
        ComShowMessage('Issue date must be earlier than RCV date.');
        return false;
    }
    return true;
}

/**
 * validation check Issue DT, RCV Date
 * @return
 */
function isValIssRcv() {
    var str_issDt = document.form.iss_dt.value.replace(/-/gi, '');
    var str_rcvDt = document.form.rcv_dt.value.replace(/-/gi, '');
    if (isNaN(str_issDt) || isNaN(str_rcvDt) || doSepRemove(str_issDt, ' ').length != 8 || doSepRemove(str_rcvDt, ' ').length != 8) {
        return false;
    }
    if (parseInt(str_issDt, 10) - parseInt(str_rcvDt, 10) > 0) {
        return false;
    }
    return true;
}

/**
 * check Period format
 * @param {string}	prd_dt
 * @return
 */
function checkPeriodFormat(prd_dt) {
    var date_regexp = /(^\d{4}\-\d{2}\-\d{2}$)/;
    if (!tes_checkFormat2(prd_dt, date_regexp)) {
        return false;
    } else {
        return true;
    }
}

/**
 * [Cost Group] set tml_cost_grp_cd(TM, TP, SD, SP)
 * [Cost Calc. Method] set tml_calc_ind_cd(TP, SP), sto_dys_ind_cd(IO, DT)
 * @return
 */
function setCalcCostCond() {
    var formObj = document.form;
    var tml_cost_grp_cd = '';
    var sto_dys_ind_cd = '';
    tml_cost_grp_cd = 'SD';
    if (formObj.StorageFD[0].checked == true) {
        sto_dys_ind_cd = 'IO';
    } else if (formObj.StorageFD[1].checked == true) {
        sto_dys_ind_cd = 'DT';
    } else {
        sto_dys_ind_cd = '';
    }
    formObj.tml_inv_tp_cd.value = 'ST';
    formObj.tml_cost_grp_cd.value = tml_cost_grp_cd;
    formObj.sto_dys_ind_cd.value = sto_dys_ind_cd;
}

/**
 * check confirm message
 * @param 	{string}	ALMSG_YN	confirm
 * @return
 */
function chk_conf(ALMSG_YN) {
    if (confirm_done) {
        if (ALMSG_YN != undefined && ALMSG_YN == 'Y') {
            ComShowMessage(ComGetMsg('TES24044'));
        }
        return false;
    }
    return true;
}

/**
 * check vndr_seq, inv_no
 * @param {string}	ALMSG_YN	
 * @return
 */
function chk_hdr_saved(ALMSG_YN) {
    if (!save_conf_01) {
        if (ALMSG_YN != undefined && ALMSG_YN == 'Y') {
            ComShowMessage(ComGetMsg('TES40045')); //ComShowMessage('기본 정보 미저장 상태!');
        }
        return false;
    }
    return true;
}

/**
 * check reject status message
 * @param {string}	ALMSG_YN	confirm
 * @return
 */
function chk_rjct(ALMSG_YN) {
    if (sheetObjects[5].RowCount() > 0 && sheetObjects[5].GetCellValue(1, 'tml_inv_rjct_sts_cd') != undefined && sheetObjects[5].GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'RJ') {
        if (ALMSG_YN != undefined && ALMSG_YN == 'Y') {
            ComShowMessage(ComGetMsg('TES40035'));
        }
        return false;
    }
    return true;
}

/**
 * set [Total AMT]
 * total_amt = ttl_inv_amt + vat_amt - whld_tax_amt (readOnly)
 * @return
 */
function set_total_amount() {
    var formObj = document.form;
    var ttl_inv_amt = 0;
    var vat_amt = 0;
    var whld_tax_amt = 0;
    if (formObj.ttl_inv_amt.value !== '' || formObj.ttl_inv_amt != undefined) {
        ttl_inv_amt = ComTrimAll(formObj.ttl_inv_amt.value, ",");
    }
    if (formObj.vat_amt.value != '' || formObj.vat_amt != undefined) {
        vat_amt = ComTrimAll(formObj.vat_amt.value, ",");
    }
    if (formObj.whld_tax_amt.value != '' || formObj.vat_amt != undefined) {
        whld_tax_amt = ComTrimAll(formObj.whld_tax_amt.value, ",");
    }
    formObj.total_amt.value = tes_chkAmtFmt(tes_round((Number(ttl_inv_amt) + Number(vat_amt) - Number(whld_tax_amt)), 2), curr_cd.GetSelectCode());
}

/**
 * reject event
 * @return
 */
function rjctInv() {
    var formObj = document.form;
    formObj.tml_inv_rjct_sts_cd.value = 'RJ';
    formObj.tml_inv_rjct_sts_cd.title = tes_getInvRejectStsFullNm('RJ');
    doActionRejectHiddenSheet(sheetObjects[5], formObj, IBSAVE);
}

/**
 * set enable element
 * @return
 */
function enableForm() {
    var formObj = document.form;
    setHeaderKeyValueReadonly('N');
    formObj.yd_cd.readOnly = false;
    formObj.cost_ofc_cd.readOnly = true;
    formObj.fm_prd_dt.readOnly = false;
    formObj.to_prd_dt.readOnly = false;
    formObj.iss_dt.readOnly = false;
    formObj.ttl_inv_amt.readOnly = false;
    formObj.rcv_dt.readOnly = false;
    formObj.vat_amt.readOnly = false;
    formObj.err_inv_no.readOnly = false;
    comboObjects[0].enable = true;
    checkWhldTaxAmtMode();
    setElementDiabled('checkbox', 'hld_flg', 'N');
    setElementDiabled('radio', 'StorageFD', 'N');
    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
}

/**
 * set disable element
 * @return
 */
function disableForm() {
    var formObj = document.form;
    setHeaderKeyValueReadonly('N');
    formObj.reset();
    formObj.yd_cd.readOnly = true;
    formObj.cost_ofc_cd.readOnly = true;
    formObj.fm_prd_dt.readOnly = true;
    formObj.to_prd_dt.readOnly = true;
    formObj.iss_dt.readOnly = true;
    formObj.ttl_inv_amt.readOnly = true;
    formObj.rcv_dt.readOnly = true;
    formObj.vat_amt.readOnly = true;
    formObj.err_inv_no.readOnly = true;
    formObj.whld_tax_amt.readOnly = true;
    comboObjects[0].enable = false;
    setElementDiabled('checkbox', 'hld_flg', 'Y');
    setElementDiabled('radio', 'StorageFD', 'Y');
    //tes_setBackColorAllTextTypeReadonly(document.form);
    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
}

/**
 * set enable element
 * @param {string}	YN_KEEP_KEY_VALUE	reset
 * @return
 */
function enablePage(YN_KEEP_KEY_VALUE) {
    var formObj = document.form;
    var temp_vndr_seq = '';
    var temp_vndr_seq_nm = '';
    var temp_is_valid_vndr_seq = '';
    var temp_yd_cd = '';
    var temp_inv_no = '';
    var temp_curr_cd = '';
    var temp_fm_prd_dt = '';
    var temp_to_prd_dt = '';
    var temp_iss_dt = '';
    var temp_rcv_dt = '';
    if (YN_KEEP_KEY_VALUE != undefined && YN_KEEP_KEY_VALUE != null && YN_KEEP_KEY_VALUE == 'Y') {
        temp_vndr_seq = formObj.vndr_seq.value;
        temp_vndr_seq_nm = formObj.vndr_seq_nm.value;
        temp_is_valid_vndr_seq = formObj.is_valid_vndr_seq.value;
        temp_yd_cd = formObj.yd_cd.value;
        temp_inv_no = formObj.inv_no.value;
        temp_fm_prd_dt = formObj.fm_prd_dt.value;
        temp_to_prd_dt = formObj.to_prd_dt.value;
        temp_curr_cd = comboObjects[0].GetSelectCode();
        temp_iss_dt = formObj.iss_dt.value;
        temp_rcv_dt = formObj.rcv_dt.value;
    }
    formObj.reset();
    if (YN_KEEP_KEY_VALUE != undefined && YN_KEEP_KEY_VALUE != null && YN_KEEP_KEY_VALUE == 'Y') {
        formObj.vndr_seq.value = temp_vndr_seq;
        formObj.vndr_seq_nm.value = temp_vndr_seq_nm;
        formObj.is_valid_vndr_seq.value = temp_is_valid_vndr_seq;
        formObj.inv_no.value = temp_inv_no;
        formObj.yd_cd.value = temp_yd_cd;
        formObj.inv_ofc_cd.value = inv_ofc_cd;
        formObj.fm_prd_dt.value = temp_fm_prd_dt;
        formObj.to_prd_dt.value = temp_to_prd_dt;
        comboObjects[0].SetSelectText(temp_curr_cd != null && temp_curr_cd != '' ? temp_curr_cd : def_curr_cd);
        comboObjects[0].SetSelectCode(temp_curr_cd != null && temp_curr_cd != '' ? temp_curr_cd : def_curr_cd);
        formObj.iss_dt.value = temp_iss_dt;
        formObj.rcv_dt.value = temp_rcv_dt;
        if (formObj.yd_cd.value != null && doSepRemove(formObj.yd_cd.value, ' ') != '') {
            var rtnVal = getYdCdCostCdList(); // tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');	        
	        if(rtnVal.length > 0){
	        	checkValidYardCode(rtnVal);
	        }	
        }
    }
    setHeaderKeyValueReadonly('N');
    formObj.yd_cd.readOnly = false;
    formObj.cost_ofc_cd.readOnly = true;
    formObj.fm_prd_dt.readOnly = false;
    formObj.to_prd_dt.readOnly = false;
    formObj.iss_dt.readOnly = false;
    formObj.ttl_inv_amt.readOnly = false;
    formObj.rcv_dt.readOnly = false;
    formObj.vat_amt.readOnly = false;
    //formObj.err_inv_no.readOnly = false;
    comboObjects[0].enable = true;
    checkWhldTaxAmtMode();
    setElementDiabled('checkbox', 'hld_flg', 'N');
    setElementDiabled('radio', 'StorageFD', 'N');
    setSheetsEnable(-1, false);
    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
}

/**
 * set disable element
 * @param {string}	YN_KEEP_KEY_VALUE
 * @return
 */
function disablePage(YN_KEEP_KEY_VALUE) {
    var formObj = document.form;
    var temp_vndr_seq = '';
    var temp_vndr_seq_nm = '';
    var temp_is_valid_vndr_seq = '';
    var temp_inv_no = '';
    if (YN_KEEP_KEY_VALUE != undefined && YN_KEEP_KEY_VALUE != null && YN_KEEP_KEY_VALUE == 'Y') {
        temp_vndr_seq = formObj.vndr_seq.value;
        temp_vndr_seq_nm = formObj.vndr_seq_nm.value;
        temp_is_valid_vndr_seq = formObj.is_valid_vndr_seq.value;
        temp_inv_no = formObj.inv_no.value;
    }
    formObj.reset();
    if (YN_KEEP_KEY_VALUE != undefined && YN_KEEP_KEY_VALUE != null && YN_KEEP_KEY_VALUE == 'Y') {
        formObj.vndr_seq.value = temp_vndr_seq;
        formObj.vndr_seq_nm.value = temp_vndr_seq_nm;
        formObj.is_valid_vndr_seq.value = temp_is_valid_vndr_seq;
        formObj.inv_no.value = temp_inv_no;
    }
    setHeaderKeyValueReadonly('N');
    formObj.yd_cd.readOnly = true;
    formObj.cost_ofc_cd.readOnly = true;
    formObj.fm_prd_dt.readOnly = true;
    formObj.to_prd_dt.readOnly = true;
    formObj.iss_dt.readOnly = true;
    formObj.ttl_inv_amt.readOnly = true;
    formObj.rcv_dt.readOnly = true;
    formObj.vat_amt.readOnly = true;
    formObj.err_inv_no.readOnly = true;
    formObj.whld_tax_amt.readOnly = true;
    setElementDiabled('checkbox', 'hld_flg', 'Y');
    setElementDiabled('radio', 'StorageFD', 'Y');
    setSheetsEnable(-1, false);
    sheetObjects[0].RemoveAll();
    sheetObjects[1].RemoveAll();
    sheetObjects[2].RemoveAll();
    sheetObjects[3].RemoveAll();
    sheetObjects[4].RemoveAll(); //main_hidden
    sheetObjects[5].RemoveAll(); //rjct_hidden
    sheetObjects[6].RemoveAll(); //conf_hidden
    sheetObjects[7].RemoveAll(); //dupchk_hidden
    sheetObjects[8].RemoveAll();
    //comboObjects[0].Code = ''; //curr_cd
    comboObjects[0].SetSelectText(def_curr_cd);
    comboObjects[0].SetSelectCode(def_curr_cd);
    comboObjects[0].enable = false;
    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
}

/**
 * New2 button click event
 * @return
 */
function disablePage2(YN_KEEP_KEY_VALUE) {
    var formObj = document.form;
    var temp_vndr_seq = '';
    var temp_vndr_seq_nm = '';
    var temp_yd_cd = '';
    var temp_curr_cd = '';
    var temp_fm_prd_dt = '';
    var temp_to_prd_dt = '';
    var temp_iss_dt = '';
    var temp_rcv_dt = '';
    temp_vndr_seq = formObj.vndr_seq.value;
    temp_vndr_seq_nm = formObj.vndr_seq_nm.value;
    temp_is_valid_vndr_seq = formObj.is_valid_vndr_seq.value;
    temp_yd_cd = formObj.yd_cd.value;
    temp_fm_prd_dt = formObj.fm_prd_dt.value;
    temp_to_prd_dt = formObj.to_prd_dt.value;
    temp_curr_cd = comboObjects[0].GetSelectCode();
    temp_iss_dt = formObj.iss_dt.value;
    temp_rcv_dt = formObj.rcv_dt.value;
    formObj.reset();
    formObj.vndr_seq.value = temp_vndr_seq;
    formObj.vndr_seq_nm.value = temp_vndr_seq_nm;
    formObj.is_valid_vndr_seq.value = temp_is_valid_vndr_seq;
    formObj.yd_cd.value = temp_yd_cd;
    formObj.inv_ofc_cd.value = inv_ofc_cd;
    formObj.fm_prd_dt.value = temp_fm_prd_dt;
    formObj.to_prd_dt.value = temp_to_prd_dt;
    comboObjects[0].SetSelectText(temp_curr_cd != null && temp_curr_cd != '' ? temp_curr_cd : def_curr_cd);
    comboObjects[0].SetSelectCode(temp_curr_cd != null && temp_curr_cd != '' ? temp_curr_cd : def_curr_cd);
    comboObjects[0].enable = false;
    formObj.iss_dt.value = temp_iss_dt;
    formObj.rcv_dt.value = temp_rcv_dt;
    if (formObj.yd_cd.value != null && doSepRemove(formObj.yd_cd.value, ' ') != '') {
    	var rtnVal = getYdCdCostCdList(); // tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');	        
	    if(rtnVal.length > 0){
	    	checkValidYardCode(rtnVal);
	    }
    }
    setHeaderKeyValueReadonly('N');
    formObj.yd_cd.readOnly = true;
    formObj.cost_ofc_cd.readOnly = true;
    formObj.fm_prd_dt.readOnly = true;
    formObj.to_prd_dt.readOnly = true;
    formObj.iss_dt.readOnly = true;
    formObj.ttl_inv_amt.readOnly = true;
    formObj.rcv_dt.readOnly = true;
    formObj.vat_amt.readOnly = true;
    formObj.err_inv_no.readOnly = true;
    formObj.whld_tax_amt.readOnly = true;
    setElementDiabled('checkbox', 'hld_flg', 'Y');
    setElementDiabled('radio', 'StorageFD', 'Y');
    setSheetsEnable(-1, false);
    sheetObjects[0].RemoveAll();
    sheetObjects[1].RemoveAll();
    sheetObjects[2].RemoveAll();
    sheetObjects[3].RemoveAll();
    sheetObjects[4].RemoveAll(); //main_hidden
    sheetObjects[5].RemoveAll(); //rjct_hidden
    sheetObjects[6].RemoveAll(); //conf_hidden
    sheetObjects[7].RemoveAll(); //dupchk_hidden
    sheetObjects[8].RemoveAll();
    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
}

/**
 * reject Initialization data
 * @return
 */
function disableAftRjct() {
    var formObj = document.form;
    setHeaderKeyValueReadonly('N');
    formObj.reset();
    formObj.yd_cd.readOnly = true;
    formObj.cost_ofc_cd.readOnly = true;
    formObj.fm_prd_dt.readOnly = true;
    formObj.to_prd_dt.readOnly = true;
    formObj.iss_dt.readOnly = true;
    formObj.ttl_inv_amt.readOnly = true;
    formObj.rcv_dt.readOnly = true;
    formObj.vat_amt.readOnly = true;
    formObj.err_inv_no.readOnly = true;
    setElementDiabled('checkbox', 'hld_flg', 'Y');
    setElementDiabled('radio', 'StorageFD', 'Y');
    setSheetsEnable(-1, false);
    sheetObjects[0].RemoveAll();
    sheetObjects[1].RemoveAll();
    sheetObjects[2].RemoveAll();
    sheetObjects[3].RemoveAll();
    sheetObjects[4].RemoveAll();
    sheetObjects[6].RemoveAll(); //conf_hidden
    sheetObjects[7].RemoveAll(); //dupchk_hidden
    sheetObjects[8].RemoveAll();
    comboObjects[0].SetSelectText(''); //curr_cd
    comboObjects[0].SetSelectCode(''); //curr_cd
    comboObjects[0].enable = false;
    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
}

/**
 * confirm 후 모든 element readonly 상태로 세팅
 * @return
 */
function disableAftConf() {
    var formObj = document.form;
    setHeaderKeyValueReadonly('N'); //header의 key값(vnrd_seq와 inv_no)를 활성화 한다
    formObj.yd_cd.readOnly = true;
    formObj.cost_ofc_cd.readOnly = true;
    formObj.fm_prd_dt.readOnly = true;
    formObj.to_prd_dt.readOnly = true;
    formObj.iss_dt.readOnly = true;
    formObj.ttl_inv_amt.readOnly = true;
    formObj.rcv_dt.readOnly = true;
    formObj.vat_amt.readOnly = true;
    formObj.err_inv_no.readOnly = true;
    comboObjects[0].enable = false;
    setElementDiabled('checkbox', 'hld_flg', 'Y');
    setElementDiabled('radio', 'StorageFD', 'Y');
    disableSheetEditable(sheetObjects[0]);
    disableSheetEditable(sheetObjects[1]);
    disableSheetEditable(sheetObjects[2]);
    disableSheetEditable(sheetObjects[3]);
    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
}

/**
 * disable sheet change editable
 * @param sheet
 * @return
 */
function disableSheetEditable(sheet) {
    //no support[check again]CLT 		for (var i=1; sheet!=null && i<=sheet.Rows; i++){
    sheet.SetRowEditable(i, 0);
}

/**
 * TPB popup set row disable
 * @param {int}		sheet_idx	sheet index
 * @param {sheet}	sheet		ibsheet
 * @param {int}		row_num		sheet rownum
 * @return
 */

function disableTPBrow(sheet_idx, sheet, row_num) {
    if (sheet_idx != null && sheet != null) {
        if (sheet.GetCellValue(row_num, 'n3pty_flg') != undefined && sheet.GetCellValue(row_num, 'n3pty_flg') == 'Y') {
            if (sheet_idx == '3') {
                setShtCellsEditable2(sheet, row_num, 'lgs_cost_cd|inv_xch_rt|stay_dys||free_dys|paid_day|free_dy_xcld_dys|ovr_dys|ctrt_rt|inv_amt', 'N');
            } else if (sheet_idx == '4') {
                setShtCellsEditable2(sheet, row_num, 'lgs_cost_cd|ovr_vol_qty|stk_vol_qty|diff_vol_qty|inv_vol_qty|fp_teu_qty|inv_vol_qty|fp_teu_qty|ctrt_rt|inv_xch_rt', 'N');
            } else if (sheet_idx == '5') {
                setShtCellsEditable2(sheet, row_num, 'lgs_cost_cd|inv_xch_rt|stay_dys||free_dys|paid_day|free_dy_xcld_dys|ovr_dys|ctrt_rt|inv_amt', 'N');
            }
        }
    }
}

/**
 * TPB I/F data set disable
 * @param {int}		sheet_idx	sheet index
 * @param {sheet}	sheet		ibsheet
 * @return
 */
function checkTPBdataEditable(sheet_idx, sheet) {
    for (var i = sheet.HeaderRows(); sheet_idx != null && sheet != null && i < (sheet.HeaderRows() + sheet.RowCount()); i++) {
        if (sheet.GetCellValue(i, 'n3pty_flg') != null && sheet.GetCellValue(i, 'n3pty_flg') == 'Y') {
            if (sheet_idx == '3') {
                setShtCellsEditable2(sheet, i, 'lgs_cost_cd|inv_xch_rt|stay_dys||free_dys|paid_day|free_dy_xcld_dys|ovr_dys|ctrt_rt|inv_amt', 'N');
            } else if (sheet_idx == '4') {
                setShtCellsEditable2(sheet, i, 'lgs_cost_cd|ovr_vol_qty|stk_vol_qty|diff_vol_qty|inv_vol_qty|fp_teu_qty|inv_vol_qty|fp_teu_qty|ctrt_rt|inv_xch_rt', 'N');
            } else if (sheet_idx == '8') {
                setShtCellsEditable2(sheet, i, 'lgs_cost_cd|inv_xch_rt|stay_dys||free_dys|paid_day|free_dy_xcld_dys|ovr_dys|ctrt_rt|inv_amt', 'N');
            }
        } else {
            if (sheet.GetCellValue(i, 'calc_tp_cd') == 'M') {
                sheet.SetCellEditable(i, 'lgs_cost_cd', 1);
            } else {
                sheet.SetCellEditable(i, 'lgs_cost_cd', 0);
            }
        }
    }
}

/**
 * Cost Calc. tab Row Add set Editable
 * @param {sheet}		sheetObj	ibsheet
 * @param {int}		rownum		row number
 * @param {string}		colnms		column name
 * @param {string}		to_sts		Y or N
 * @param {string}		EXCEPTION	
 * @return
 */
function setShtCellsEditable(sheetObj, rownum, colnms, to_sts, EXCEPTION) {
    //setShtCellsEditable(sheetObj, 1, 'COL_NM|COL_NM2|COL_NM3', 'N')
    if (rownum == null || rownum == undefined || colnms == null || colnms == undefined || to_sts == null || to_sts == undefined) {
        return false;
    }
    var arr_colnms = colnms.split('|');
    for (var i = 0; i < arr_colnms.length; i++) {
        if (EXCEPTION != undefined && EXCEPTION == 'EXCEPTION') {
            sheetObj.SetCellEditable(rownum, arr_colnms[i], (to_sts != null && to_sts == 'Y' ? 1 : 0));
        } else {
            if (sheetObj.GetCellValue(rownum, 'calc_tp_cd') == 'M') {
                sheetObj.SetCellEditable(rownum, arr_colnms[i], (to_sts != null && to_sts == 'Y' ? 1 : 0));
            }
        }
    }
}

/**
 * TPB popup row set disable
 * @param {sheet}	sheetObj	ibsheet
 * @param {int}		rownum		add row number
 * @param {string}	colnms		column name
 * @param {string}	to_sts		Y or N
 * @return
 */
function setShtCellsEditable2(sheetObj, rownum, colnms, to_sts) {
    if (rownum == null || rownum == undefined || colnms == null || colnms == undefined || to_sts == null || to_sts == undefined) {
        return false;
    }
    var arr_colnms = colnms.split('|');
    for (var i = 0; arr_colnms != null && i < arr_colnms.length; i++) {
        sheetObj.SetCellEditable(rownum, arr_colnms[i], (to_sts != null && to_sts == 'Y' ? 1 : 0));
    }
}

/**
 * set Coin sheet status
 * @return
 */
function setCoinShtStat() {
    var formObj = document.form;
    formObj.sht_01_ttl_box.value = 0;
    formObj.sht_01_full.value = 0;
    formObj.sht_01_mt.value = 0;
    //formObj.sht_01_ts_bkg.value		= 0;
    formObj.sht_01_ts_same_yard.value = 0;
    formObj.sht_01_D2.value = 0;
    formObj.sht_01_D2.value = 0;
    formObj.sht_01_D4.value = 0;
    formObj.sht_01_D5.value = 0;
    formObj.sht_01_D7.value = 0;
    formObj.sht_01_D8.value = 0;
    formObj.sht_01_D9.value = 0;
    //		formObj.sht_01_DW.value=0;
    //		formObj.sht_01_DX.value=0;
    formObj.sht_01_R2.value = 0;
    formObj.sht_01_R4.value = 0;
    formObj.sht_01_R5.value = 0;
    formObj.sht_01_F2.value = 0;
    formObj.sht_01_F4.value = 0;
    formObj.sht_01_F5.value = 0;
    formObj.sht_01_O2.value = 0;
    formObj.sht_01_O4.value = 0;
    formObj.sht_01_S2.value = 0;
    formObj.sht_01_S4.value = 0;
    formObj.sht_01_T2.value = 0;
    formObj.sht_01_T4.value = 0;
    formObj.sht_01_A2.value = 0;
    formObj.sht_01_A4.value = 0;
    formObj.sht_01_P2.value = 0;
    formObj.sht_01_P4.value = 0;
    formObj.sht_01_Z2.value = 0;
    formObj.sht_01_Z4.value = 0;
    formObj.sht_01_ttl_box.value = sheetObjects[0].RowCount();
    for (var i = 1; i <= sheetObjects[0].RowCount(); i++) {
        if (sheetObjects[0].GetCellValue(i, "cntr_sty_cd") != undefined && sheetObjects[0].GetCellValue(i, "cntr_sty_cd") != null && sheetObjects[0].GetCellValue(i, "cntr_sty_cd") != '') {
            try {
                with(formObj) {
                    if (sheetObjects[0].GetCellValue(i, "cntr_sty_cd") == 'F') {
                        sht_01_full.value++;
                    } else if (sheetObjects[0].GetCellValue(i, "cntr_sty_cd") == 'M') {
                        sht_01_mt.value++;
                    }
                }
            } catch (e) {
                //ComShowMessage(e);
            }
        }
        /*
if (sheetObjects[0].GetCellValue(i,"locl_ts_ind_cd")!=undefined && sheetObjects[0].GetCellValue(i,"locl_ts_ind_cd")!=null && sheetObjects[0].GetCellValue(i,"locl_ts_ind_cd")!='')
			{
				try {
					with (formObj) {
if (sheetObjects[0].GetCellValue(i,"locl_ts_ind_cd")=='T'){
							sht_01_ts_bkg.value++;
						}
					}
				} catch(e){
					//ComShowMessage(e);
				}
			}
			*/
        if (sheetObjects[0].GetCellValue(i, "sam_locl_ts_ind_cd") != undefined && sheetObjects[0].GetCellValue(i, "sam_locl_ts_ind_cd") != null && sheetObjects[0].GetCellValue(i, "sam_locl_ts_ind_cd") != '') {
            try {
                with(formObj) {
                    if (sheetObjects[0].GetCellValue(i, "sam_locl_ts_ind_cd") == 'T') {
                        sht_01_ts_same_yard.value++;
                    }
                }
            } catch (e) {
                //ComShowMessage(e);
            }
        }
    }
    // Type/Size code get count
    for (var i = 1; i <= sheetObjects[0].RowCount(); i++) {
        if (sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") != undefined && sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") != null && sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") != '') {
            try {
                with(formObj) {
                    eval('sht_01_' + sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd")).value++;
                }
            } catch (e) {
                //ComShowMessage(e);
            }
        }
    }
}

/**
 * Save button click event
 * @return
 */
function fnChkForm() {
    var formObj = document.form;
    if (formObj.vndr_seq.value == null || formObj.vndr_seq.value == '') {
        ComShowMessage(ComGetMsg('TES23007', 'VNDR Code'));
        formObj.vndr_seq.focus();
        return false;
//    } else if (formObj.is_valid_vndr_seq.value == null || formObj.is_valid_vndr_seq.value != 'Y') {
//        ComShowMessage(ComGetMsg('TES23008', 'VNDR Code'));
//        formObj.vndr_seq.focus();
//        return false;
    } else if (formObj.inv_no.value == null || formObj.inv_no.value == '') {
        ComShowMessage(ComGetMsg('TES21026', 'Inv No'));
        formObj.inv_no.focus();
        return false;
    } else if (formObj.yd_cd.value == null || formObj.yd_cd.value == '') {
        ComShowMessage(ComGetMsg('TES21026', 'Yard Code'));
        formObj.yd_cd.focus();
        return false;
//    } else if (formObj.is_valid_yd_cd.value == null || formObj.is_valid_yd_cd.value != 'Y') {
//        ComShowMessage(ComGetMsg('TES23008', 'Yard Code'));
//        formObj.yd_cd.focus();
//        return false;
    } else if (formObj.inv_ofc_cd.value == null || formObj.inv_ofc_cd.value == '') {
        ComShowMessage(ComGetMsg('TES21026', 'Inv OFC'));
        return false;
    } else if (formObj.cost_ofc_cd.value == null || formObj.cost_ofc_cd.value == '') {
        ComShowMessage(ComGetMsg('TES21026', 'Cost OFC'));
        formObj.cost_ofc_cd.focus();
        return false;
//    } else if (formObj.is_valid_cost_ofc_cd.value == null || formObj.is_valid_cost_ofc_cd.value != 'Y') {
//        ComShowMessage(ComGetMsg('TES23008', 'Cost OFC'));
//        formObj.cost_ofc_cd.focus();
//        return false;
    } else if (formObj.curr_cd.value == null || formObj.curr_cd.value == '') {
        ComShowMessage(ComGetMsg('TES21026', 'Currency'));
        return false;
    } else if (formObj.fm_prd_dt.value == null || formObj.fm_prd_dt.value == '') {
        ComShowMessage(ComGetMsg('TES21026', 'FromPeriod'));
        formObj.fm_prd_dt.focus();
        return false;
    } else if (formObj.to_prd_dt.value == null || formObj.to_prd_dt.value == '') {
        ComShowMessage(ComGetMsg('TES21026', 'ToPeriod'));
        formObj.to_prd_dt.focus();
        return false;
    } else if (!validateDateObj(formObj.fm_prd_dt)) {
        formObj.fm_prd_dt.focus();
        return false;
    } else if (!validateDateObj(formObj.to_prd_dt)) {
        formObj.to_prd_dt.focus();
        return false;
    } else if (formObj.ttl_inv_amt.value == null || formObj.ttl_inv_amt.value == '') {
        ComShowMessage(ComGetMsg('TES21026', 'Inv AMT'));
        formObj.ttl_inv_amt.focus();
        return false;
    } else if (formObj.iss_dt.value == null || formObj.iss_dt.value == '') {
        ComShowMessage(ComGetMsg('TES21026', 'Issue Date'));
        formObj.iss_dt.focus();
        return false;
    } else if (formObj.rcv_dt.value == null || formObj.rcv_dt.value == '') {
        ComShowMessage(ComGetMsg('TES21026', 'RCV Date'));
        formObj.rcv_dt.focus();
        return false;
    } else if (formObj.iss_dt.value != null && doSepRemove(formObj.iss_dt.value, ' ') != '' &&
        formObj.rcv_dt.value != null && doSepRemove(formObj.rcv_dt.value, ' ') != '' &&
        !isValIssRcv()) {
        ComShowMessage('Issue date must be earlier than RCV date.');
        return false;
    } else if ((formObj.err_inv_no.value == null || formObj.err_inv_no.value != '') &&
        (formObj.is_valid_err_inv_no.value == null || formObj.is_valid_err_inv_no.value != 'Y')) {
        ComShowMessage(ComGetMsg('TES40063', 'ERR INV.NO'));
        formObj.err_inv_no.focus();
        return false;
    }
    if (formObj.hld_flg.checked == true) {
        if (formObj.hld_rmk.value == null || formObj.hld_rmk.value == '') {
            ComShowMessage(ComGetMsg('TES23005'));
            return false;
        }
        formObj.hld_flg.value = 'Y';
    } else {
        formObj.hld_flg.value = 'N';
        //formObj.hld_rmk.value='';
    }
    if (formObj.StorageFD[0].checked != true && formObj.StorageFD[1].checked != true) {
        ComShowMessage(ComGetMsg('TES40011'));
        return false;
    }
    return true;
}

/**
 * set sheet form data
 * @param {string}	MODE	status(save, confirm...)
 * @return
 */
function setHdSheet2Form(MODE) {
    var formObj = document.form;
    //		ComShowMessage('setHdSheet2Form: rowcnt:'+sheetObjects[4].RowCount);
    if (sheetObjects[4].RowCount() == 1) {
        formObj.tml_so_ofc_cty_cd.value = sheetObjects[4].GetCellValue(1, 'tml_so_ofc_cty_cd');
        formObj.tml_so_seq.value = sheetObjects[4].GetCellValue(1, 'tml_so_seq');
        if (MODE != undefined && MODE != null && MODE == 'CONFIRM') {
            formObj.confirm_mode.value = '';
            //				ComShowMessage('setHdSheet2Form - CONFIRM');
        } else {
            //formObj.inv_ofc_cd.value = sheetObjects[4].GetCellValue(1,'inv_ofc_cd');
            formObj.yd_cd.value = sheetObjects[4].GetCellValue(1, 'yd_cd');
            formObj.yd_cd_hidden.value = sheetObjects[4].GetCellValue(1, 'yd_cd');
            formObj.yd_nm.value = sheetObjects[4].GetCellValue(1, 'yd_nm');
            if (sheetObjects[4].GetCellValue(1, 'fm_prd_dt') != null && sheetObjects[4].GetCellValue(1, 'fm_prd_dt') != '') {
                formObj.fm_prd_dt.value = sheetObjects[4].GetCellValue(1, 'fm_prd_dt');
            }
            formObj.cost_ofc_cd.value = sheetObjects[4].GetCellValue(1, 'cost_ofc_cd');
            formObj.cost_ofc_cd_hidden.value = sheetObjects[4].GetCellValue(1, 'cost_ofc_cd');
            formObj.vndr_seq.value = tes_lpad(sheetObjects[4].GetCellValue(1, 'vndr_seq'), 6, '0');
            if (sheetObjects[4].GetCellValue(1, 'to_prd_dt') != null && sheetObjects[4].GetCellValue(1, 'to_prd_dt') != '') {
                formObj.to_prd_dt.value = sheetObjects[4].GetCellValue(1, 'to_prd_dt');
            }
            //				formObj.fm_prd_dt.value = sheetObjects[4].GetCellValue(1,'fm_prd_dt')!=null&&sheetObjects[4].GetCellValue(1,'fm_prd_dt')!=''?sheetObjects[4].GetCellValue(1,'fm_prd_dt'):'';
            //				formObj.to_prd_dt.value	= sheetObjects[4].GetCellValue(1,'to_prd_dt')!=null&&sheetObjects[4].GetCellValue(1,'to_prd_dt')!=''?sheetObjects[4].GetCellValue(1,'to_prd_dt'):'';
            formObj.inv_no.value = sheetObjects[4].GetCellValue(1, 'inv_no');
            formObj.iss_dt.value = sheetObjects[4].GetCellValue(1, 'iss_dt');
            formObj.ttl_inv_amt.value = tes_chkAmtFmt(sheetObjects[4].GetCellValue(1, 'ttl_inv_amt'), sheetObjects[4].GetCellValue(1, 'curr_cd'));
            formObj.rcv_dt.value = sheetObjects[4].GetCellValue(1, 'rcv_dt');
            formObj.hld_rmk.value = "AA"; //sheetObjects[4].GetCellValue(1,'hld_rmk');
            if (sheetObjects[4].GetCellValue(1, 'hld_flg') != undefined && sheetObjects[4].GetCellValue(1, 'hld_flg') == 'Y') {
                formObj.hld_flg.checked = true;
            } else {
                formObj.hld_flg.checked = false;
            }
        }

        formObj.cost_cd_ftr_rmk.value = sheetObjects[4].GetCellValue(1, 'cost_cd_ftr_rmk');

        formObj.vat_amt.value = tes_chkAmtFmt(sheetObjects[4].GetCellValue(1, 'vat_amt'), sheetObjects[4].GetCellValue(1, 'curr_cd'));
        comboObjects[0].SetSelectCode(sheetObjects[4].GetCellValue(1, 'curr_cd'));
        comboObjects[0].SetSelectText(sheetObjects[4].GetCellValue(1, 'curr_cd'));
        formObj.curr_cd_tmp.value = sheetObjects[4].GetCellValue(1, 'curr_cd');
        resetSheetDataProperty(comboObjects[0].GetSelectCode());
        formObj.tml_inv_tp_cd.value = sheetObjects[4].GetCellValue(1, 'tml_inv_tp_cd');
        var inv_sts_cd = sheetObjects[4].GetCellValue(1, 'tml_inv_sts_cd');
        formObj.tml_inv_sts_cd.value = inv_sts_cd;
        if (inv_sts_cd != undefined && inv_sts_cd == 'R') {
            inv_sts_cd = 'RC'
        } else if (inv_sts_cd != undefined && inv_sts_cd == 'C') {
            inv_sts_cd = 'CF'
        } else if (inv_sts_cd != undefined && inv_sts_cd == 'P') {
            inv_sts_cd = 'AP'
        } else if (inv_sts_cd != undefined && inv_sts_cd == 'A') {
            inv_sts_cd = 'AR'
        }
        formObj.tml_inv_sts_cd2.value = inv_sts_cd;
        formObj.tml_inv_sts_cd2.title = tes_getInvStsFullNm(inv_sts_cd);
        var rjct_sts_cd = sheetObjects[4].GetCellValue(1, 'tml_inv_rjct_sts_cd');
        formObj.tml_inv_rjct_sts_cd.value = (rjct_sts_cd != null && doSepRemove(rjct_sts_cd, ' ') != '' ? rjct_sts_cd : 'NL');
        formObj.tml_inv_rjct_sts_cd.title = tes_getInvRejectStsFullNm(rjct_sts_cd != null && doSepRemove(rjct_sts_cd, ' ') != '' ? rjct_sts_cd : 'NL');
        formObj.inv_rjct_rmk.value = sheetObjects[4].GetCellValue(1, 'inv_rjct_rmk');
        formObj.err_inv_no.value = sheetObjects[4].GetCellValue(1, 'err_inv_no');
        formObj.whld_tax_amt.value = tes_chkAmtFmt(sheetObjects[4].GetCellValue(1, 'whld_tax_amt'), sheetObjects[4].GetCellValue(1, 'curr_cd'));
        set_total_amount();
        var tml_cost_grp_cd = sheetObjects[4].GetCellValue(1, 'tml_cost_grp_cd');
        var tml_calc_ind_cd = sheetObjects[4].GetCellValue(1, 'tml_calc_ind_cd');
        var sto_dys_ind_cd = sheetObjects[4].GetCellValue(1, 'sto_dys_ind_cd');
        //ComShowMessage('tml_cost_grp_cd:'+tml_cost_grp_cd+'\n' + 'tml_calc_ind_cd:'+tml_calc_ind_cd+'\n'+'sto_dys_ind_cd:'+sto_dys_ind_cd+'\n');
        formObj.tml_cost_grp_cd.value = tml_cost_grp_cd;
        formObj.tml_calc_ind_cd.value = tml_calc_ind_cd;
        formObj.sto_dys_ind_cd.value = sto_dys_ind_cd;
        setElementChecked('radio', 'StorageFD', 'N');
        if (sto_dys_ind_cd != undefined && doSepRemove(sto_dys_ind_cd, ' ').length == 2) {
            if (doSepRemove(sto_dys_ind_cd, ' ') == 'IO') {
                formObj.StorageFD[0].checked = true;
            } else if (doSepRemove(sto_dys_ind_cd, ' ') == 'DT') {
                formObj.StorageFD[1].checked = true;
            }
        }
		
		var costCdFtrRmk = formObj.cost_cd_ftr_rmk.value;
        getAgmtCostCdList(1, 75, 150, costCdFtrRmk); // tes_getComboItem('agmt_lgs_cost_cd', 2, SEARCHLIST10, '', 'vndr_seq|yd_cd|agmt_ftr_inv_tp_cd|atb_dt', 'setAgmtCostCd');

    } else if (sheetObjects[4].RowCount() > 0) {
        ComShowMessage(ComGetMsg('TES40060'));
        return false;
    } else {
        ComShowMessage(ComGetMsg('TES21035'));
        return false;
    }
}

/**
 * set sheet enable
 * @param {int}		to_sht_idx		sheet index
 * @param {boolean}	ENABLE_SHEETS	
 * @return
 */
function setSheetsEnable(to_sht_idx, ENABLE_SHEETS) {
    if (!ENABLE_SHEETS) {
        tabObjects[0].enable = false;
        return false;
    }
    tabObjects[0].enable = true;
    if (to_sht_idx != undefined && to_sht_idx != null && to_sht_idx != '' && (to_sht_idx >= 0 && to_sht_idx <= 5)) {
        tabObjects[0].SetSelectedIndex(to_sht_idx);
    }

    enable_sheet_01 = tabObjects[0].GetTabDisable(0);
    enable_sheet_02 = tabObjects[0].GetTabDisable(1);
    enable_sheet_03 = tabObjects[0].GetTabDisable(2);
    enable_sheet_04 = tabObjects[0].GetTabDisable(3);
    enable_sheet_05 = tabObjects[0].GetTabDisable(4);
}

/**
 * retrieve
 * @param {string}	REMOVE_YN
 * @return
 */
function retrieve(REMOVE_YN) {
    try {
        var formObj = document.form;
        if (fnChkSearchForm()) {
            cntr_list_onchange_cnt = 1;
            if (REMOVE_YN != undefined && REMOVE_YN == 'Y') {
                sheetObjects[0].RemoveAll();
                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();
                sheetObjects[3].RemoveAll();
                sheetObjects[4].RemoveAll();
                sheetObjects[5].RemoveAll();
                sheetObjects[6].RemoveAll();
                sheetObjects[7].RemoveAll();
                sheetObjects[8].RemoveAll();
            }
            formObj.t3sht_tot_inv_amt.value = '';
            formObj.t4sht_tot_inv_amt.value = '';
            doActionMainHiddenSheet(sheetObjects[4], formObj, IBSEARCH);
            /*
            if (sheetObjects[4].RowCount()== 1 && sheetObjects[4].GetCellValue(1,'tml_inv_tp_cd')=='ST') {
            					doActionIBSheetAllSheets(sheetObjects[0],formObj,IBSEARCH);
            				}
            */
        }
    } catch (e) {}
}

/**
 * COIN,DSCP sheet retrieve
 * @return
 */
function retrieveCntrList() {
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); //COIN,DSCP - retrieve
}

/**
 * FP sheet retrieve
 * @return
 */
function retrievePoolDtlList() {
    doActionIBSheet4(sheetObjects[3], document.form, IBSEARCH); //FP만 - retrieve
}

//2016.10.11 Currency FormToSheet Add
function setDefaultCurrencyFormToSheet(sheetObj, row, colName){
    var formObj = document.form;
    
    var formCurrCd = ComGetObjValue(formObj.curr_cd);
    
    sheetObj.SetCellValue(row, colName, formCurrCd, 0);
}
