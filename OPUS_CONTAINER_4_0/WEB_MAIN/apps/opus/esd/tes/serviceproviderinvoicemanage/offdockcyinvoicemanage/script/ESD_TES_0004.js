/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TES_0004.js
*@FileTitle  : Off-Dock CY Invoice Creation & Correction
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
=========================================================*/
/**
 * @extends Tes
 * @class ESD_TES_0004 : Defining business script for Off-Dock CY Invoice Creation & Correction
 */
var save_conf_01 = false; // vndr_seq, inv_no
var confirm_done = false; // CONFIRM
var parmObj = new Array();
var enable_sheet_01 = 1;
var enable_sheet_02 = 1;
var enable_sheet_03 = 1;
var enable_sheet_04 = 1;
var enable_sheet_05 = 1;
var enable_sheet_06 = 1;
var comboObjects = new Array();
var comboCnt = 0;
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var sheetObjects = new Array();
var sheetObjectsMap = new Array();
var sheetCnt = 0;
var cntr_list_onchange_cnt = 1;
var cnt = 0;
var curr_chk = false;
var def_curr_cd = '';
var groval_tmp;
var tmp_row = 0;
var searchEQFlag = false;

// Defining button events. 
document.onclick = processButtonClick;

/**
 * Handling button event.
 * @return
 */
function processButtonClick() {
    /** *** Setting each tab's sheet variable. **** */
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];
    var sheetObject3 = sheetObjects[3];
    var sheetObject4 = sheetObjects[4];
    var sheetObject5 = sheetObjects[5]; // main_hidden
    var sheetObject6 = sheetObjects[6]; // rjct_hidden
    var sheetObject7 = sheetObjects[7]; // conf_hidden
    var sheetObject8 = sheetObjects[8]; // dupchk_hidden
    var sheetObject9 = sheetObjects[9]; // EQ
    /** **************************************************** */
    var formObj = document.form;
    try {
        var srcName = ComGetEvent("name");
        if (ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
            case "btn_pre_inquiry_cond":
                var url_str = 'ESD_TES_0013.do';
                url_str += '?pgmNo=ESD_TES_0013&parentPgmNo=ESD_TES_M001';
                url_str += '&pre_cond_inv_no=' + document.form.pre_cond_inv_no.value;
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
                
            case "btn_retrieve":
                retrieve('Y');
                break;
                
            case "btn_vndr":
                if (formObj.vndr_seq.readOnly == true) {
                    return false;
                }
                // if (!chk_rjct('Y')){ return false; }
                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // com_ens_051_dispaly.value;
                var classId = "COM_ENS_0C1";
                var param = '?classId=' + classId;
                var chkStr = dispaly.substring(0, 3);
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
                    ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 810, 530, 'getYard', dispaly, true);
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
                var dispaly = '1,0,1,1,1,1,1,1,1,1,1,1'; // "1,0,1,1,0,1,1,1";
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
  //              try {
//                    tes_removeTESCommonALLIframes();
//                    tes_removeTESInvoiceCommonALLIframes();
//                } catch (e) {}
                cntr_list_onchange_cnt = 1;
                confirm_done = false;
                save_conf_01 = false;
                tes_new0004();
                document.form.yd_cd_hidden.value = "";

                document.form.agmt_ftr_inv_tp_cd.value = "OTOS";

                document.form.vndr_seq.focus();
                agmt_lgs_cost_cd.RemoveAll();
                break;
                
            case "btn_new2":
                cntr_list_onchange_cnt = 1;
                confirm_done = false;
                save_conf_01 = false;
                disablePage2();

                ComEnableObject(formObj.ttl_inv_amt, true);
                ComEnableObject(formObj.vat_amt, true);

                if (document.form.vndr_seq.value != null && document.form.vndr_seq.value != '') {
                    document.form.inv_no.focus();
                } else {
                    document.form.vndr_seq.focus();
                }

                document.form.agmt_ftr_inv_tp_cd.value = "OTOS";

                document.form.tml_odck_flg.disabled = false;
                agmt_lgs_cost_cd.RemoveAll();
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
                    doActionMainHiddenSheet(sheetObject5, formObj, IBSAVE);
                    cntr_list_onchange_cnt = 1;
                }
                break;
                
            case "btns_calendar1":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (formObj.fm_prd_dt.readOnly == true) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                var cal = new ComCalendar();
                cal.select(formObj.fm_prd_dt, 'yyyy-MM-dd');
                break;
                
            case "btns_calendar2":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (formObj.to_prd_dt.readOnly == true) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                var cal = new ComCalendar();
                cal.select(formObj.to_prd_dt, 'yyyy-MM-dd');
                break;
                
            case "btns_calendar3":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (formObj.iss_dt.readOnly == true) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                var cal = new ComCalendar();
                cal.select(formObj.iss_dt, 'yyyy-MM-dd');
                break;
                
            case "btns_calendar4":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (formObj.rcv_dt.readOnly == true) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                var cal = new ComCalendar();
                cal.select(formObj.rcv_dt, 'yyyy-MM-dd');
                break;
                
            case "btns_calendar5":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                var cal = new ComCalendar();
                cal.select(formObj.cal5, 'yyyy-MM-dd');
                break;
                
            case "btns_remarks":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (sheetObject5.RowCount() != 1) {
                    return false;
                }
                var display = "1,0,1,1,1,1,1,1,1,1,1,1";
                if (formObj.hld_flg.checked == true) {
                    ComOpenPopup('ESD_TES_9210RemarksPopup.screen?hld_rmk_inp_nm=' + $('#hld_rmk').val(), 450, 125, '', display, true);
                }
                break;
                
            case "t1btng_listclear":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!save_conf_01) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (sheetObject.RowCount() > 0 || sheetObject1.RowCount() > 0 || sheetObject2.RowCount() > 0 || sheetObject3.RowCount() > 0) {
                    if (confirm(ComGetMsg('TES24053'))) {
                        removeOffdockCYInvoice01();
                    }
                } else {
                    ComShowMessage(ComGetMsg('TES23015'));
                }
                break;
                
            case "t1btng_fileimport":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!save_conf_01) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (formObj.vndr_seq.value == undefined || formObj.vndr_seq.value == null || doSepRemove(formObj.vndr_seq.value, ' ') == '' || formObj.yd_cd.value == undefined || formObj.yd_cd.value == null || doSepRemove(formObj.yd_cd.value, ' ') == '') {
                    ComShowMessage(ComGetMsg('TES40025', 'VNDR Code/YD_CD'));
                    return false;
                }
                if (formObj.fm_prd_dt.value == undefined || formObj.fm_prd_dt.value == null || formObj.fm_prd_dt.value == '' || formObj.to_prd_dt.value == undefined || formObj.to_prd_dt.value == null || formObj.to_prd_dt.value == '') {
                    ComShowMessage(ComGetMsg('TES24016'));
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
                var tml_cost_grp_cd;
                var tml_calc_ind_cd;
                var sto_dys_ind_cd;
                if (sheetObjects[5].RowCount() == 1) {
                    tml_cost_grp_cd = sheetObjects[5].GetCellValue(1, 'tml_cost_grp_cd');
                    tml_calc_ind_cd = sheetObjects[5].GetCellValue(1, 'tml_calc_ind_cd');
                    sto_dys_ind_cd = sheetObjects[5].GetCellValue(1, 'sto_dys_ind_cd');
                } else {
                    ComShowMessage(ComGetMsg('TES23017'));
                    return false;
                }
                var url = 'ESD_TES_9140FileImportPopup.screen';
                url = url + '?tml_so_ofc_cty_cd=' + sheetObjects[5].GetCellValue(1, 'tml_so_ofc_cty_cd') + '&tml_so_seq=' + sheetObjects[5].GetCellValue(1, 'tml_so_seq');
                url = url + '&vndr_seq=' + formObj.vndr_seq.value + '&yd_cd=' + formObj.yd_cd.value;
                url = url + '&fm_prd_dt=' + formObj.fm_prd_dt.value + '&to_prd_dt=' + formObj.to_prd_dt.value + '&rcv_dt=' + formObj.rcv_dt.value;
                url = url + '&tml_cost_grp_cd=' + tml_cost_grp_cd + '&tml_calc_ind_cd=' + tml_calc_ind_cd + '&sto_dys_ind_cd=' + sto_dys_ind_cd;
                url = url + '&cntr_tpsz_cd=' + CNTR_TPSZ_CD + '&inv_no=' + formObj.inv_no.value + "&agmt_ftr_inv_tp_cd=" + formObj.agmt_ftr_inv_tp_cd.value;
                //2016.09.09 AGMT COST CD Add
                url = url + '&cost_cd_ftr_rmk='+replaceAll(agmt_lgs_cost_cd.GetSelectCode(), ',', '|');
                ComOpenWindow(url, window, "dialogWidth:610px;dialogHeight:400px; help:no; status:no; resizable:yes;", true);
                break;
                
            case "t1btng_save":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!save_conf_01) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (sheetObject.RowCount() > 0) {
                    var params = new Array();
                    params[0] = sheetObjects[0].GetSaveString(false, false);
                    params[1] = sheetObjects[1].GetSaveString(false, false);
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
                    var formObj = document.form;
                    doActionIBSheet(sheetObject, formObj, IBSAVE);
                }
                break;
                
            case "t1btng_downexcel":
                if (sheetObject.RowCount() < 1) { //no data
                    ComShowCodeMessage("COM132501");
                } else {
                    doActionIBSheet(sheetObject, formObj, IBDOWNEXCEL);
                }

                break;
                
            case "t1btng_todiscrepancy":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!save_conf_01) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                var iCheckRow = '';
                if (sheetObject.RowCount() > 0) {
                    iCheckRow = sheetObject.FindCheckedRow('chk') + "|";
                    if (iCheckRow != undefined && iCheckRow != null && iCheckRow != '' && iCheckRow != '|') {
                        var arrRow = iCheckRow.split("|");
                        if (iCheckRow != null && arrRow.length > 0) {
                            for (var idx = 0; idx < arrRow.length; idx++) {
                                sheetObject.SetCellValue(arrRow[idx], 'vrfy_rslt_ind_cd', 'DC', 0);
                                sheetObject.SetCellValue(arrRow[idx], 'modi_flg', '', 0);
                            }
                            //						tes_copy_rows_to(sheetObject, sheetObject1, 'chk', sheetObject.GetSaveString(false, false, 'chk'), true);
                            tes_copy_rows_to2(sheetObject1, sheetObject.GetSaveString(false, false, 'chk'), true);
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
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!save_conf_01) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (sheetObject.GetEnable() == false) {
                    return false;
                }

                if (document.form.org_tml_odck_flg.value != document.form.tml_odck_flg.value) {
                    alert("Off/On is not saved. Please save Invoice Header.");
                    return false;
                }

                if (sheetObject.RowCount() > 0) {
                    curr_chk = false; // reset
                    if (sheetObjects[5].RowCount() == 1) {
                        if (sheetObjects[5].GetCellValue(1, 'curr_cd') != curr_cd.GetSelectCode()) {
                            ComShowMessage(ComGetMsg('TES40002', 'Currency'));
                            return false;
                        }
                    } else {
                        return false;
                    }
                    for (var i = sheetObject.HeaderRows(); i < (sheetObject.HeaderRows() + sheetObject.RowCount()); i++) {
                        if (sheetObject.GetCellValue(i, 'cntr_tpsz_cd') == null || sheetObject.GetCellValue(i, 'cntr_tpsz_cd') == '') {
                            ComShowMessage(ComGetMsg('TES40016', 'Type/Size'));
                            return false;
                        }
                    }
                    for (var i = sheetObject.HeaderRows(); i < (sheetObject.HeaderRows() + sheetObject.RowCount()); i++) {
                        if (sheetObject.GetCellValue(i, 'cntr_sty_cd') == null || sheetObject.GetCellValue(i, 'cntr_sty_cd') == '') {
                            ComShowMessage(ComGetMsg('TES40016', 'F/M'));
                            return false;
                        }
                    }
                    for (var j = sheetObject.HeaderRows(); j < (sheetObject.HeaderRows() + sheetObject.RowCount()); j++) {
                        if (sheetObject.GetCellValue(j, 'dcgo_clss_cd') == null || sheetObject.GetCellValue(j, 'dcgo_clss_cd') == '') {
                            ComShowMessage(ComGetMsg('TES40016', 'DG'));
                            return false;
                        }
                    }
                    if (formObj.TMNL.checked == true) {
                        for (var j = sheetObject.HeaderRows(); j < (sheetObject.HeaderRows() + sheetObject.RowCount()); j++) {
                            if (sheetObject.GetCellValue(j, 'tml_trns_mod_cd') == null || sheetObject.GetCellValue(j, 'tml_trns_mod_cd') == '') {
                                ComShowMessage(ComGetMsg('TES40016', 'Mode'));
                                return false;
                            }
                        }
                    }
                    var sheets = new Array();
                    sheets[0] = sheetObjects[0];
                    sheets[1] = sheetObjects[1];
                    if (!tes_isAllDataSaved(sheets)) {
                        ComShowMessage(ComGetMsg('TES23020'));
                        return false;
                    }
                    var params = new Array();
                    params[0] = sheetObjects[0].GetSaveString(false, false);
                    params[1] = sheetObjects[1].GetSaveString(false, false);
                    if (tes_isModified(sheets, params)) {
                        ComShowMessage(ComGetMsg('TES23021'));
                        return false;
                    }
                    if (formObj.fm_prd_dt.value == undefined || formObj.fm_prd_dt.value == null || formObj.fm_prd_dt.value == '') {
                        ComShowMessage(ComGetMsg('TES23022'));
                        return false;
                    } else {
                        if (!checkPeriodFormat(formObj.fm_prd_dt.value) || !tes_isValidDateObject(formObj.fm_prd_dt.value,
                                '-')) {
                            ComShowMessage(ComGetMsg('TES23011'));
                            formObj.fm_prd_dt.focus();
                            return false;
                        }
                    }
                    var cost_calc_tmnl = false;
                    var cost_calc_day = false;
                    var cost_calc_pool = true;
                    var curr_tab_idx = 0;
                    if (formObj.TMNL.checked == true) {
                        cost_calc_tmnl = true;
                        curr_tab_idx = 2;
                    } else {
                        cost_calc_tmnl = false;
                    }
                    if (formObj.StorageDay.checked == true) {
                        cost_calc_day = true;
                        if (formObj.TMNL.checked == false) {
                            curr_tab_idx = 3;
                        }
                    } else {
                        cost_calc_day = false;
                        if (formObj.TMNL.checked == false) {
                            curr_tab_idx = 4;
                        }
                    }
                    if (!cost_calc_tmnl && !cost_calc_day) {
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
                    setSheetsEnable(curr_tab_idx, true);

                    doActionIBSheet3(sheetObjects[2], formObj, IBSEARCH_ASYNC02);

                    //				doActionIBSheetCalc(sheetObject2, formObj, IBSEARCH);
                } else {
                    ComShowMessage(ComGetMsg('TES23024'));
                }
                break;
                
            case "t2btng_listclear":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!save_conf_01) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (sheetObject.RowCount() > 0 || sheetObject1.RowCount() > 0 || sheetObject2.RowCount() > 0 || sheetObject3.RowCount() > 0) {
                    if (confirm(ComGetMsg('TES23053'))) {
                        removeOffdockCYInvoice01();
                    }
                } else {
                    ComShowMessage(ComGetMsg('TES23015'));
                }
                break;
                
            case "t2btng_verification":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!save_conf_01) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                var iCheckRow = '';
                if (sheetObject1.RowCount() > 0) {
                    iCheckRow = sheetObject1.FindCheckedRow('chk') + "|";
                    if (iCheckRow != undefined && iCheckRow != null && iCheckRow != '' && iCheckRow != '|') {
                        var arrRow = iCheckRow.split("|");
                        if (iCheckRow != null && arrRow.length > 0) {
                            for (var idx = 0; idx < arrRow.length; idx++) {
                                sheetObject1.SetCellValue(arrRow[idx], 'vrfy_rslt_ind_cd', 'CO');
                                sheetObject1.SetCellValue(arrRow[idx], 'modi_flg', 'Y', 0);
                            }
                            //						tes_copy_rows_to(sheetObject1, sheetObject, 'chk', sheetObject1.GetSaveString(false, false, 'chk'), true);
                            tes_copy_rows_to2(sheetObject, sheetObject1.GetSaveString(false, false, 'chk'), true);
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
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!save_conf_01) {
                    return false;
                }
                if (sheetObject5.RowCount() != 1) {
                    return false;
                }
                var display = "1,0,1,1,1,1,1,1,1,1,1,1";
                ComOpenPopup('ESD_TES_9020RejectPopup.screen?rjct_sts_inp_nm=inv_rjct_rmk&rjct_fn_nm=rjctInv', 400, 150, '', display, true);
                break;
                
            case "t2btng_print":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                // ComShowMessage('t2btng_print');
                // return;
                if (sheetObject1.RowCount() > 0) {
                    printDiscrepancyContainerList();
                } else {
                    ComShowMessage(ComGetMsg('TES23026'));
                    return false;
                }
                break;
                
            case "t2btng_downexcel":
                if (sheetObject1.RowCount() < 1) { //no data
                    ComShowCodeMessage("COM132501");
                } else {
                    doActionIBSheet2(sheetObject1, formObj, IBDOWNEXCEL);
                }

                break;
                
            case "t2btng_rowadd":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                doActionIBSheet2(sheetObject1, formObj, IBINSERT);
                break;

            case "t3btng_costCal":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!save_conf_01) {
                    return false;
                }

                if (!chkSaveTmlOdckFlg()) {
                    alert("Off/On Dock is not saved.");
                    return false;
                }

                var param = "?yd_cd=" + formObj.yd_cd.value + "&vndr_seq=" + formObj.vndr_seq.value + "&vndr_seq_nm=" + formObj.vndr_seq_nm.value + "&fm_prd_dt=" + formObj.fm_prd_dt.value + "&curr_cd=" + formObj.curr_cd.value + "&to_prd_dt=" + formObj.to_prd_dt.value + "&atb_dt=" + formObj.fm_prd_dt.value + "&prgm_id=ESD_TES_0004_1&cost_cd_inv_tp_cd=" + (document.form.tml_odck_flg.value == "Y" ? "MT" : "OT");

                //ComOpenPopup(sUrl,                     iWidth, iHeight, sFunc,            sDisplay,        bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                ComOpenPopup("ESD_TES_9001.do" + param, 840, 670, "setCostCode2", "1,0,1,1,1,1,1", true, false, null, null, null, 'Cost Calculation', 'no');

                break;

            case "t3btng_clear":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!save_conf_01) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (sheetObject.RowCount() > 0 || sheetObject1.RowCount() > 0 || sheetObject2.RowCount() > 0 || sheetObject3.RowCount() > 0) {
                    if (confirm(ComGetMsg('TES23053'))) {
                        removeOffdockCYInvoice01();
                    }
                } else {
                    ComShowMessage(ComGetMsg('TES23015'));
                }
                break;
                
            case "t3btng_rowadd":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!chkSaveTmlOdckFlg()) {
                    alert("Off/On Dock is not saved.");
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
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!save_conf_01) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                doActionIBSheet3(sheetObject2, formObj, IBSAVE);
                break;
                
            case "t3btng_totalamount":
                if (sheetObject5.RowCount() != 1) {
                    return false;
                }
                var url_str = 'ESD_TES_9050Popup.screen';
                url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
                url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
                // window.open(url_str, 'popup_rev_calc_vol', 'width=600px, height=400px, location=0, status=0, resizable=1');
                //			 ComOpenWindow(url_str,  'ESD_TES_9050Popup',  "dialogWidth:610px; dialogHeight:420px; help:no; status:no; resizable:yes;" , true);
                //ComOpenPopup(url_str, 610, 420, '', "1,0,1,1,1,1,1,1,1,1,1,1", true);
                ComOpenWindow(url_str, window, "help:no;status:no;resizable:yes;dialogWidth:" + 610 + "px;dialogHeight:" + 355 + "px", true);
                break;
                
            case "t3btng_confirm":
                if (confirm_done) {
                    ComShowMessage(ComGetMsg('TES23027'));
                    return false;
                }
                if (sheetObject5.RowCount() != 1) {
                    return false;
                }
                doActionConfirmHiddenSheet(sheetObject7, formObj, IBSAVE);
                break;

            case "t4btng_costCal":
                if (!chk_conf('Y')) {
                    return false;
                }

                if (!chk_rjct('Y')) {
                    return false;
                }
                var param = "?yd_cd=" + formObj.yd_cd.value + "&vndr_seq=" + formObj.vndr_seq.value + "&vndr_seq_nm=" + formObj.vndr_seq_nm.value + "&fm_prd_dt=" + formObj.fm_prd_dt.value + "&curr_cd=" + formObj.curr_cd.value + "&to_prd_dt=" + formObj.to_prd_dt.value + "&prgm_id=ESD_TES_0004_2&cost_cd_inv_tp_cd=OS";

                //ComOpenPopup(sUrl,                     iWidth, iHeight, sFunc,            sDisplay,        bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                ComOpenPopup("ESD_TES_9001.do" + param, 840, 670, "setCostCode", "1,0,1,1,1,1,1", true, false, null, null, null, 'Cost Calculation', 'no');
                break;

            case "t4btng_listclear":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!save_conf_01) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (sheetObject.RowCount() > 0 || sheetObject1.RowCount() > 0 || sheetObject2.RowCount() > 0 || sheetObject3.RowCount() > 0) {
                    if (confirm(ComGetMsg('TES23053'))) {
                        removeOffdockCYInvoice01();
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
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!save_conf_01) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                doActionIBSheet4(sheetObject3, formObj, IBSAVE);
                break;
                
            case "t4btng_totalamount":
                if (sheetObject5.RowCount() != 1) {
                    return false;
                }
                var url_str = 'ESD_TES_9050Popup.screen';
                url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
                url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
                // window.open(url_str, 'popup_rev_calc_vol', 'width=600px,
                // height=400px, location=0, status=0, resizable=1');
                //			window.ComOpenWindow(url_str,  window,"dialogWidth:610px; dialogHeight:420px; help:no; status:no; resizable:yes;", true);
                //ComOpenPopup(url_str, 610, 420, '', "1,0,1,1,1,1,1,1,1,1,1,1", true);
                ComOpenWindow(url_str, window, "help:no;status:no;resizable:yes;dialogWidth:" + 610 + "px;dialogHeight:" + 355 + "px", true);
                break;
                
            case "t4btng_confirm":
                if (confirm_done) {
                    ComShowMessage(ComGetMsg('TES23027'));
                    return false;
                }
                // ComShowMessage("t4btng_confirm");
                if (sheetObject5.RowCount() != 1) {
                    return false;
                }
                doActionConfirmHiddenSheet(sheetObject7, formObj, IBSAVE);
                break;
                
            case "t5btng_listclear":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!save_conf_01) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (sheetObject4.RowCount() > 0) {
                    if (confirm(ComGetMsg('TES40012'))) {
                        removeOffdockCYInvoice02();
                    }
                } else {
                    ComShowMessage(ComGetMsg('TES23015'));
                }
                break;
                
            case "t5btng_rowadd":
                if (!chk_conf('Y')) {
                    return false;
                }
                doActionIBSheet5(sheetObject4, formObj, IBINSERT);
                break;
                
            case "t5btng_rowdel":
                if (!chk_conf('Y')) {
                    return false;
                }
                doActionIBSheet5(sheetObject4, formObj, IBDELETE);
                break;
                
            case "t5btng_save":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!save_conf_01) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                doActionIBSheet5(sheetObject4, formObj, IBSAVE);
                break;
                
            case "t5btng_totalamount":
                if (sheetObject5.RowCount() != 1) {
                    return false;
                }
                var url_str = 'ESD_TES_9050Popup.screen';
                url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
                url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
                // window.open(url_str, 'popup_rev_calc_vol', 'width=600px,
                // height=400px, location=0, status=0, resizable=1');
                //			window.ComOpenWindow(url_str,  window, "dialogWidth:610px; dialogHeight:420px; help:no; status:no; resizable:yes;", true);
                //ComOpenPopup(url_str, 610, 420, '', "1,0,1,1,1,1,1,1,1,1,1,1", true);
                ComOpenWindow(url_str, window, "help:no;status:no;resizable:yes;dialogWidth:" + 610 + "px;dialogHeight:" + 355 + "px", true);
                break;
                
            case "t5btng_reject":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (!save_conf_01) {
                    return false;
                }
                if (sheetObject5.RowCount() != 1) {
                    return false;
                }
                var display = "1,0,1,1,1,1,1,1,1,1,1,1";
                ComOpenPopup('ESD_TES_9020RejectPopup.screen?rjct_sts_inp_nm=inv_rjct_rmk&rjct_fn_nm=rjctInv', 400, 150, '', display, true);
                break;
                
            case "t5btng_confirm":
                if (confirm_done) {
                    ComShowMessage(ComGetMsg('TES23027'));
                    return false;
                }
                // ComShowMessage("t5btng_confirm");
                if (sheetObject5.RowCount() != 1) {
                    return false;
                }
                doActionConfirmHiddenSheet(sheetObject7, formObj, IBSAVE);
                break;
                
            case "t6btng_costCal":
                if (!chk_conf('Y')) {
                    return false;
                }

                if (!chk_rjct('Y')) {
                    return false;
                }
                var param = "?yd_cd=" + formObj.yd_cd.value + "&vndr_seq=" + formObj.vndr_seq.value + "&vndr_seq_nm=" + formObj.vndr_seq_nm.value + "&fm_prd_dt=" + formObj.fm_prd_dt.value + "&curr_cd=" + formObj.curr_cd.value + "&to_prd_dt=" + formObj.to_prd_dt.value + "&prgm_id=ESD_TES_0004_3&cost_cd_inv_tp_cd=OE";

                //ComOpenPopup(sUrl,                     iWidth, iHeight, sFunc,            sDisplay,        bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                ComOpenPopup("ESD_TES_9001.do" + param, 840, 670, "setCostCode3", "1,0,1,1,1,1,1", true, false, null, null, null, 'Cost Calculation', 'no');
                break;

            case "t6btng_listclear":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!save_conf_01) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                if (sheetObject9.RowCount() > 0) {
                    if (confirm(ComGetMsg('TES40064'))) {
                        removeOffdockCYInvoice03();
                    }
                } else {
                    ComShowMessage(ComGetMsg('TES23015'));
                }
                break;
                
            case "t6btng_rowadd":
                if (!chk_conf('Y')) {
                    return false;
                }
                doActionIBSheet6(sheetObject9, formObj, IBINSERT);
                break;
                
            case "t6btng_rowdel":
                if (!chk_conf('Y')) {
                    return false;
                }
                doActionIBSheet6(sheetObject9, formObj, IBDELETE);
                break;
                
            case "t6btng_save":
                if (!chk_conf('Y')) {
                    return false;
                }
                if (!save_conf_01) {
                    return false;
                }
                if (!chk_rjct('Y')) {
                    return false;
                }
                doActionIBSheet6(sheetObject9, formObj, IBSAVE);
                break;
                
            case "t6btng_totalamount":
                if (sheetObject5.RowCount() != 1) {
                    return false;
                }
                var url_str = 'ESD_TES_9050Popup.screen';
                url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
                url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
                // window.open(url_str, 'popup_rev_calc_vol', 'width=600px,
                // height=400px, location=0, status=0, resizable=1');
                //			window.ComOpenWindow(url_str,  window,"dialogWidth:610px; dialogHeight:420px; help:no; status:no; resizable:yes;", true);
                //ComOpenPopup(url_str, 610, 420, '', "1,0,1,1,1,1,1,1,1,1,1,1", true);
                ComOpenWindow(url_str, window, "help:no;status:no;resizable:yes;dialogWidth:" + 610 + "px;dialogHeight:" + 355 + "px", true);
                break;
                
            case "t6btng_confirm":
                if (confirm_done) {
                    ComShowMessage(ComGetMsg('TES23027'));
                    return false;
                }
                // ComShowMessage("t4btng_confirm");
                if (sheetObject5.RowCount() != 1) {
                    return false;
                }
                doActionConfirmHiddenSheet(sheetObject7, formObj, IBSAVE);
                break;
                
        } // end switch
    } catch (e) {
        ComShowMessage(e.message);
        if (e == "[object Error]") {
            ComShowMessage(ComGetMsg('TES23028'));
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * Setting vender name.
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
 * Setting yard name
 * @param rowArray
 * @return
 */
function getYard(rowArray) {
    var colArray = rowArray[0];
    document.all.yd_cd.value = colArray[3];
    document.all.yd_nm.value = colArray[4];
    document.all.yd_cd_hidden.value = colArray[3];
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
    doActionMainHiddenSheet(sheetObjects[5], formObj, IBSEARCH_ASYNC04);
}

/**
 * Setting Cost OFC
 * @param rowArray
 * @return
 */
function getOfcCd(rowArray) {
    var colArray = rowArray[0];
    document.all.cost_ofc_cd.value = (colArray[3] != undefined && colArray[3] != null ? colArray[3] : '');
}

/**
 * Register IBSheet object on sheetObjects array.
 * @param {sheet}	sheet_obj	ibsheet
 * @return
 */
function setSheetObject(sheet_obj) {
    // ComShowMessage('setSheetObject');
    sheetObjects[sheetCnt++] = sheet_obj;
    sheetObjectsMap[sheet_obj.id] = sheet_obj;
}

/**
 * is checked.
 * @param {sheet}	shtObj	ibsheet
 * @param {string}	chk_nm	check box name
 * @return
 */
function confirmChecked(shtObj, chk_nm) {
    var chk_nm = (chk_nm == null && chk_nm == undefined) ? 'chk' : chk_nm;
    if (shtObj.RowCount() > 0) {
        //no support[check again]CLT 		for ( var i=1; i < shtObj.Rows; i++)
        {
            if (shtObj.GetCellValue(i, chk_nm) == 1) {
                return true;
            }
        }
    }
    return false;
}

/**
 * Coding event handler for body tag's OnLoad. Add  pre-process functions after loading by browser.
 * @return
 */
function loadPage() {
    disableForm();
    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
    
    if(getComCdList()){ // CNTR_TPSZ_CD, MT_A_LGS_COST_CD, CARR_CD     //tes_getInputValue('tmp_common_code', SEARCH17, '', 'setCommonCode');
    	OT_A_LGS_COST_CD = OT_A_LGS_COST_CD + "|TMNDFL|TMNDMT|TMNDTS|SVSSFL|SVSSMT|SVSSTS|SVSSTM";  
    	sheetObjects[1].SetColProperty("cntr_tpsz_cd", { ComboText: CNTR_TPSZ_CD, ComboCode: CNTR_TPSZ_CD });
	    sheetObjects[2].SetColProperty("cntr_tpsz_cd", { ComboText: CNTR_TPSZ_CD, ComboCode: CNTR_TPSZ_CD });
	    sheetObjects[2].SetColProperty("lgs_cost_cd", { ComboText: OT_A_LGS_COST_CD, ComboCode: OT_A_LGS_COST_CD });
	    sheetObjects[3].SetColProperty("cntr_tpsz_cd", { ComboText: CNTR_TPSZ_CD, ComboCode: CNTR_TPSZ_CD });
	    sheetObjects[3].SetColProperty("lgs_cost_cd", { ComboText: OS_A_LGS_COST_CD, ComboCode: OS_A_LGS_COST_CD });
	    sheetObjects[4].SetColProperty("lgs_cost_cd", { ComboText: OS_A_LGS_COST_CD, ComboCode: OS_A_LGS_COST_CD });
	    sheetObjects[9].SetColProperty("eq_tpsz_cd", { ComboText: EQ_TPSZ_CD, ComboCode: EQ_TPSZ_CD });	    
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
    //document.form.vndr_seq.value = "101401";
    //document.form.inv_no.value = "TESIN TEST";
}

/**
 * Setting common variable.
 * @return
 */
function setWhldTaxAmtMode() {
    var formObj = document.form;
    var tmp = '';
    tmp = formObj.whld_tax_amt_mode.value;
    if (tmp != undefined && tmp != null && tmp == 'Y') {
        whld_tax_readonly_mode = false;
    } else {
        whld_tax_readonly_mode = true;
    }
}

/**
 * Setting readonly.
 * @param {string}	YN_SET_BACKCOLOR
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
 * Setting sheet data attribute.
 * @return
 */
function setCalcColFormat() {
    //resetSheetDataProperty(comboObjects[0].GetSelectCode());
}

/**
 * Array define top on source.
 * @param {combo}	combo_obj	combo object
 * @return
 */
function setComboObject(combo_obj) {
    comboObjects[comboCnt++] = combo_obj;
}

/**
 * Initialize combo.
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
                if (combo_val != undefined && combo_val != null) {
                    tmp = combo_val.split('|');
                }
                for (var i = 0; combo_val != undefined && combo_val != null && tmp != null && i < tmp.length; i++) {
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
                    if (sheetObjects[5].RowCount() > 0 && (curr_cd.GetSelectCode() == null || curr_cd.GetSelectCode() == '')) {
                        curr_cd.SetSelectText(sheetObjects[5].GetCellValue(1, 'curr_cd'));
                        curr_cd.SetSelectCode(sheetObjects[5].GetCellValue(1, 'curr_cd'));
                        def_curr_cd = (sheetObjects[5].GetCellValue(1, 'curr_cd') != null && sheetObjects[5].GetCellValue(1, 'curr_cd') != '') ? sheetObjects[5].GetCellValue(1, 'curr_cd') : '';
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
 * Initialize sheets.
 * @param {sheet}	sheetObj	ibsheet
 * @param {int}		sheetNo		sheet index
 * @return
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
	    case 1:   //t1sheet1 init
		    with(sheetObj){
			   var HeadTitle="||Seq.|CNTR No.|Type/Size|Gate In|Gate Out|F/M|I/O|DG|B/B|Mode|Verify\nResult|Remarks|";
			   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
			   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			   var headers = [ { Text:HeadTitle, Align:"Center"} ];
			   InitHeaders(headers, info);
			   var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                KeyField:0,   CalcLogic:"" },
				              {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
				              {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
				              {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
				              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
				              {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"inv_gate_in_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
				              {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"inv_gate_out_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
				              {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
				              {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
				              {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_clss_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
				              {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
				              {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tml_trns_mod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
				              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dscr_ind_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
				              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cntr_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
				              {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"tml_so_cntr_list_seq",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
				              {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
				              {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no_split",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
				              {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"vrfy_rslt_ind_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
				              {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"modi_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
				              {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"gate_in_td_dys",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
				              {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"gate_out_td_dys",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
				              {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"inv_stay_dys",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
				              {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_gate_in_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
				              {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_gate_out_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
				              {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_stay_dys",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
				              {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"stay_diff_dys",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				              {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_flg",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				              {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rc_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			    
			   InitColumns(cols);
			   SetEditable(1);
			   SetSheetHeight(230);
			   SetColProperty("inv_gate_in_dt", {Format:"YmdHm"} );
			   SetColProperty("inv_gate_out_dt", {Format:"YmdHm"} );
			   SetColProperty("mvmt_gate_in_dt", {Format:"YmdHm"} );
			   SetColProperty("mvmt_gate_out_dt", {Format:"YmdHm"} );
			   SetColProperty("cntr_sty_cd", {ComboText:cntr_sty_cdCode, ComboCode:cntr_sty_cdCode} );
			   SetColProperty("io_bnd_cd", {ComboText:io_bnd_cdCode, ComboCode:io_bnd_cdCode} );
			   SetColProperty("dcgo_clss_cd", {ComboText:dcgo_clss_cdCode, ComboCode:dcgo_clss_cdCode} );
			   SetColProperty("bb_cgo_flg", {ComboText:'Y|N', ComboCode:'Y|N'} );
			   SetColProperty("tml_trns_mod_cd", {ComboText:"|"+tml_trns_mod_cdText, ComboCode:"|"+tml_trns_mod_cdCode} );
			   SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
			}
			break;
       
       case 2: // t2sheet1 init
    	   with(sheetObj){
				var HeadTitle0="|Discrepancy Type| |Seq.|CNTR No.|Type/|F/M|Gate In|Gate In|G/I|Gate Out|Gate Out|G/O\|Remarks|";
				var HeadTitle1="|Discrepancy Type||Seq.||Size||MVMT|Invoice|Diff.|MVMT|Invoice|Diff.||";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle0, Align:"Center"},{ Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							{Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"dscr_ind_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },							
							{Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_gate_in_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"inv_gate_in_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"gate_in_td_dys",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_gate_out_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"inv_gate_out_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"gate_out_td_dys",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntr_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"tml_so_cntr_list_seq",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no_split",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"vrfy_rslt_ind_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"modi_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_clss_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_flg",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rc_flg",                KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"tml_trns_mod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 }];
				
				InitColumns(cols);
				SetEditable(1);
				SetSheetHeight(230);
				SetColProperty("inv_gate_in_dt", {Format:"YmdHm"} );
				SetColProperty("inv_gate_out_dt", {Format:"YmdHm"} );
				SetColProperty("mvmt_gate_in_dt", {Format:"YmdHm"} );
				SetColProperty("mvmt_gate_out_dt", {Format:"YmdHm"} );
				SetColProperty("dscr_ind_cd", {ComboText:dscr_ind_cdText, ComboCode:dscr_ind_cdCode} );
				SetColProperty("cntr_sty_cd", {ComboText:cntr_sty_cdCode, ComboCode:cntr_sty_cdCode} );
				SetColProperty("cntr_tpsz_cd", {ComboText:CNTR_TPSZ_CD, ComboCode:CNTR_TPSZ_CD} );
				SetHeaderRowHeight(10);
				SetCellBackColor(1,2,"#555555");
				SetRangeBackColor(1, 4, 1, 14,"#555555");
				//SetRangeBackColor(1, 10, 1, 11,"#555555");
				SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
			}
			break;
				
       case 3: // t3sheet1 init
			with(sheetObj){       
			       var HeadTitle="|Calculated Type|Cost Code|Type/Size|Calculated\nVol.|Reefer|Mode|Year\nMonth|Revised Vol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remarks|3rd Party|";
			       SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge: 0 } );
			       var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			       var headers = [ { Text:HeadTitle, Align:"Center"} ];
			       InitHeaders(headers, info);
			       var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
						        {Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"calc_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Int",       Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"calc_vol_qty",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rc_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tml_trns_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rev_yrmon",            KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Popup",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rvis_vol_qty",         KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						        {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vol_tr_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						        {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ctrt_rt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_xch_rt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"calc_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						        {Type:"Popup",     Hidden:0, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"n3pty_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						        {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"calc_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_dtl_seq",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"calc_cost_grp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
						        {Type:"Text",      Hidden:1, Width:125,  Align:"Left",    ColMerge:0,   SaveName:"lgs_cost_cd2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"dcgo_ind_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"free_dys",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"inv_amt2",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"ovr_dys",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"paid_day",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"stay_dys",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"diff_vol_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"fp_calc_prd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"fp_teu_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"inv_vol_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"ovr_vol_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"stk_vol_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"wrk_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"acct_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"curr_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						        {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"semi_auto_calc_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
			        
			       InitColumns(cols);
			       SetEditable(1);
			       SetSheetHeight(230);
			       
			       SetColProperty("calc_tp_cd", {ComboText:"AutoCalculatedCost|ManualInputCost|SemiAutoInputCost", ComboCode:"A|M|S"} );
			       SetColProperty("lgs_cost_cd", {ComboText:OT_A_LGS_COST_CD, ComboCode:OT_A_LGS_COST_CD} );
			       SetColProperty("cntr_tpsz_cd", {ComboText:CNTR_TPSZ_CD, ComboCode:CNTR_TPSZ_CD} );
			       SetColProperty("vol_tr_ut_cd", {ComboText:vol_tr_ut_cdCode, ComboCode:vol_tr_ut_cdCode} );
			       SetColProperty("rc_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
			       SetColProperty("tml_trns_mod_cd", {ComboText:"|"+tml_trns_mod_cdText, ComboCode:"|"+tml_trns_mod_cdCode} );
			       SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
	       	}
			break;
			
       case 4: // t4sheet1 init
		    with(sheetObj){
			     var HeadTitle="|Calculated Type|Cost Code|CNTR No.|Type/\nSize|I/O|DG.|Year\Month|Stay\nDays|F/Days|Paid\nDays|Exclude\nDays|Over\nDays|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remarks|3rd Party|";
			     SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge: 0 } );
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
					            {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ctrt_rt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_xch_rt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"calc_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					            {Type:"Popup",     Hidden:0, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"n3pty_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					            {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"calc_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:125,  Align:"Left",    ColMerge:0,   SaveName:"lgs_cost_cd2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"calc_cost_grp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
					            {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_dtl_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"calc_vol_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"rvis_vol_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"diff_vol_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"fp_calc_prd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"fp_teu_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"inv_vol_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"ovr_vol_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"stk_vol_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"wrk_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"acct_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"curr_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"ovr_dys2",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rc_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"semi_auto_calc_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
			      
			     InitColumns(cols);			
			     SetEditable(1);
			     SetSheetHeight(230);
			     SetColProperty("calc_tp_cd", {ComboText:"AutoCalculatedCost|ManualInputCost|SemiAutoInputCost", ComboCode:"A|M|S"} );
			     SetColProperty("lgs_cost_cd", {ComboText:OS_A_LGS_COST_CD, ComboCode:OS_A_LGS_COST_CD} );
			     SetColProperty("cntr_tpsz_cd", {ComboText:CNTR_TPSZ_CD, ComboCode:CNTR_TPSZ_CD} );
			     SetColProperty("io_bnd_cd", {ComboText:io_bnd_cdCode, ComboCode:io_bnd_cdCode} );
			     SetColProperty("vol_tr_ut_cd", {ComboText:vol_tr_ut_cdCode, ComboCode:vol_tr_ut_cdCode} );
			     SetColProperty("dcgo_ind_cd", {ComboText:dcgo_clss_cdCode, ComboCode:dcgo_clss_cdCode} );
			     SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
     		}
     		break;
     		
       case 5: // t5sheet1 init
			 with(sheetObj){
				  var HeadTitle="|Calculated Type|Cost Code|Date|Stacking\nVol.|Vol. by\nInvoice|Differ|Free\nPool|Over\nVol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remarks";
				  SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
				  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				  var headers = [ { Text:HeadTitle, Align:"Center"} ];
				  InitHeaders(headers, info);
				  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"calc_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"wrk_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"stk_vol_qty",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_vol_qty",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Float",     Hidden:0,  Width:37,   Align:"Right",   ColMerge:0,   SaveName:"diff_vol_qty",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fp_teu_qty",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"ovr_vol_qty",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Combo",     Hidden:0, Width:35,   Align:"Right",   ColMerge:0,   SaveName:"vol_tr_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ctrt_rt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_xch_rt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"calc_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"calc_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:125,  Align:"Left",    ColMerge:0,   SaveName:"lgs_cost_cd2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"calc_cost_grp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_dtl_seq",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"fp_calc_prd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"calc_vol_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"io_bnd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"rvis_vol_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"dcgo_ind_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"free_dys",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"inv_amt2",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"ovr_dys",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"paid_day",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"stay_dys",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"acct_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"curr_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rc_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rev_yrmon",            KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				  InitColumns(cols);
				  SetEditable(1);
				  SetSheetHeight(230);
				  SetColProperty("calc_tp_cd", {ComboText:"Auto Calculated Cost|Manual Input Cost", ComboCode:"A|M"} );
				  SetColProperty("lgs_cost_cd", {ComboText:OS_A_LGS_COST_CD, ComboCode:OS_A_LGS_COST_CD} );
				  SetColProperty("vol_tr_ut_cd", {ComboText:vol_tr_ut_cdCode, ComboCode:vol_tr_ut_cdCode} );
				  SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
				  
				  //ShowSubSum([{StdCol:"calc_tp_cd", SumCols:"4|5|6|7|8|10|11", Sort:false, ShowCumulate:false, CaptionCol:1, OtherColText:"calc_tp_cd=%s;lgs_cost_cd=TTL"}]);
				  
				  ShowSubSum([{StdCol:"calc_tp_cd", SumCols:"stk_vol_qty|inv_vol_qty|diff_vol_qty|fp_teu_qty|ovr_vol_qty|ctrt_rt|inv_xch_rt|inv_amt", Sort:false, ShowCumulate:false, CaptionCol:1, OtherColText:"calc_tp_cd=%s;lgs_cost_cd=TTL"}]);
				  
				  SetDataRowMerge(false);
			}
			break;	
			 
       case 6: // main_hidden
			with(sheetObj){
		        var HeadTitle="tml_so_ofc_cty_cd|tml_so_seq|inv_ofc_cd|cost_ofc_cd|inv_no|vndr_seq|yd_cd|yd_nm|curr_cd|ttl_inv_amt|vat_amt|ttl_calc_amt|fm_prd_dt|hld_flg|hld_rmk|to_prd_dt|tml_inv_tp_cd|tml_cost_grp_cd|tml_calc_ind_cd|sto_dys_ind_cd|iss_dt|rcv_dt|eff_dt|pay_due_dt|pay_flg|tml_inv_sts_cd|tml_inv_rjct_sts_cd|inv_cfm_dt|inv_rjct_dt|tml_agmt_ofc_cty_cd|tml_agmt_seq|tml_agmt_ver_no|inv_rjct_rmk|cre_usr_id|cre_dt|upd_usr_id|upd_dt|tml_odck_flg|cost_cd_ftr_rmk";
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
				            {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_odck_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cost_cd_ftr_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
		         
		        InitColumns(cols);
		        SetEditable(0);
                }
				break;
				
       case 7: // rjct_hidden
			with(sheetObj){
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
            }
			break;

       case 8: // conf_hidden
           with(sheetObj){
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
            
       case 9: // dupchk_hidden
           with(sheetObj){
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
          		
	     case 10: // t6sheet1 init
			    with(sheetObj){
				     var HeadTitle="|Calculated Type|Cost Code|EQ No.|Type/\nSize|I/O|DG.|Year\Month|Stay\nDays|F/Days|Paid\nDays|Exclude\nDays|Over\nDays|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remarks|3rd Party|";
				     SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge: 0 } );
				     var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				     var headers = [ { Text:HeadTitle, Align:"Center"} ];
				     InitHeaders(headers, info);
				     var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
						            {Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"calc_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"eq_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						            {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_ind_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rev_yrmon",            KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Int",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"stay_dys",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Int",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"free_dys",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"paid_day",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						            {Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"free_dy_xcld_dys",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						            {Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"ovr_dys",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"vol_tr_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						            {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ctrt_rt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_xch_rt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
						            {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"calc_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						            {Type:"Popup",     Hidden:0, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"n3pty_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						            {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"calc_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Text",      Hidden:1, Width:125,  Align:"Left",    ColMerge:0,   SaveName:"lgs_cost_cd2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"calc_cost_grp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
						            {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_dtl_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Text",      Hidden:1, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"calc_vol_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Text",      Hidden:1, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"rvis_vol_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Text",      Hidden:1, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"diff_vol_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"fp_calc_prd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"fp_teu_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"inv_vol_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"ovr_vol_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"stk_vol_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"wrk_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"acct_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"curr_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"ovr_dys2",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rc_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"semi_auto_calc_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						            {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"eq_knd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
						            ];
				      
				     InitColumns(cols);			
				     SetEditable(1);
				     SetSheetHeight(230);
				     SetColProperty("calc_tp_cd", {ComboText:"AutoCalculatedCost|ManualInputCost|SemiAutoInputCost", ComboCode:"A|M|S"} );
				     SetColProperty("eq_tpsz_cd", {ComboText:EQ_TPSZ_CD, ComboCode:EQ_TPSZ_CD} );
				     SetColProperty("io_bnd_cd", {ComboText:io_bnd_cdCode, ComboCode:io_bnd_cdCode} );
				     SetColProperty("vol_tr_ut_cd", {ComboText:vol_tr_ut_cdCode, ComboCode:vol_tr_ut_cdCode} );
				     SetColProperty("dcgo_ind_cd", {ComboText:dcgo_clss_cdCode, ComboCode:dcgo_clss_cdCode} );
				     SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
	     		}
			    break;
			    
       	case 11: // trd_if_hidden
			with(sheetObj){
		           var HeadTitle="STS|calc_cost_grp_cd|tml_if_ofc_cd|tml_if_seq|tml_n3pty_if_sts_cd|"
					           + "tml_inv_tp_cd|inv_no|vndr_seq|yd_cd|lgs_cost_cd|acct_cd|"
					           + "tml_so_ofc_cty_cd|tml_so_seq|tml_so_cntr_list_seq|tml_so_dtl_seq|tml_so_dtl_seq3|n3pty_bil_tp_cd|"
					           + "cntr_no|cntr_tpsz_cd|bkg_no|bkg_no_split|finc_vsl_cd|"
					           + "finc_skd_voy_no|finc_skd_dir_cd|vndr_cust_div_cd|vndr_cnt_cd|n3pty_vndr_seq|"
					           + "cust_cnt_cd|cust_seq|n3pty_ofc_cd|curr_cd|if_amt|"
					           + "if_rmk|cxl_flg|calc_tp_cd|ioc_cd|lane_cd|"
					           + "io_bnd_cd|fm_tr_vol_val|to_tr_vol_val|n3rd_if_rmk";
		
		           SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
		           var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		           var headers = [ { Text:HeadTitle, Align:"Center"} ];
		           InitHeaders(headers, info);
		           var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_ibflag" },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_calc_cost_grp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_if_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_if_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_n3pty_if_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_inv_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_inv_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_vndr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_yd_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_lgs_cost_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_acct_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_so_ofc_cty_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_so_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_so_cntr_list_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_so_dtl_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tmp_dtl_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tmp_tpb_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_n3pty_bil_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_bkg_no_split",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_finc_vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_finc_skd_voy_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_finc_skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_vndr_cust_div_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_vndr_cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_n3pty_vndr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_cust_cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_cust_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_n3pty_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_if_amt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_cxl_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_calc_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_ioc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_lane_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_io_bnd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_fm_tr_vol_val",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_to_tr_vol_val",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_vvd_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tmp_tpb_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_if_rmk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		            
		           InitColumns(cols);
		           SetEditable(0);
            }
           	break;
           	
       case 12: // trd_if_hidden_2
           with(sheetObj){
	            var HeadTitle="STS|calc_cost_grp_cd|tml_if_ofc_cd|tml_if_seq|tml_n3pty_if_sts_cd|"
	            + "tml_inv_tp_cd|inv_no|vndr_seq|yd_cd|lgs_cost_cd|acct_cd|"
	            + "tml_so_ofc_cty_cd|tml_so_seq|tml_so_cntr_list_seq|tml_so_dtl_seq|tml_so_dtl_seq3|n3pty_bil_tp_cd|"
	            + "cntr_no|cntr_tpsz_cd|bkg_no|bkg_no_split|finc_vsl_cd|"
	            + "finc_skd_voy_no|finc_skd_dir_cd|vndr_cust_div_cd|vndr_cnt_cd|n3pty_vndr_seq|"
	            + "cust_cnt_cd|cust_seq|n3pty_ofc_cd|curr_cd|if_amt|"
	            + "if_rmk|cxl_flg|calc_tp_cd|ioc_cd|lane_cd|"
	            + "io_bnd_cd|fm_tr_vol_val|to_tr_vol_val|n3rd_if_rmk";
	            SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
	            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            InitHeaders(headers, info);
	            var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_ibflag" },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_calc_cost_grp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_if_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_if_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_n3pty_if_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_inv_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_inv_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_vndr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_yd_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_lgs_cost_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_acct_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_so_ofc_cty_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_so_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_so_cntr_list_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_so_dtl_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tmp_dtl_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tmp_tpb_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_n3pty_bil_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_bkg_no_split",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_finc_vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_finc_skd_voy_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_finc_skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_vndr_cust_div_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_vndr_cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_n3pty_vndr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_cust_cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_cust_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_n3pty_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_if_amt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_cxl_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_calc_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_ioc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_lane_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_io_bnd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_fm_tr_vol_val",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_to_tr_vol_val",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_vvd_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tmp_tpb_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_if_rmk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	             
	            InitColumns(cols);
	            SetEditable(0);
            }
           	break;

       case 13: // rvis_hidden
           with(sheetObj){
	           var HeadTitle="|tml_so_ofc_cty_cd|tml_so_seq|tml_so_dtl_seq|tml_so_dtl_seq2|tml_so_rvis_list_seq|tml_inv_tp_cd|calc_cost_grp_cd|tml_rvis_tp_cd|lgs_cost_cd"
					           + "|cntr_no|cntr_tpsz_cd|cntr_sty_cd|tml_rvis_ind_flg|rvis_gate_in_flg|rvis_gate_out_flg|inv_gate_in_dt|inv_gate_out_dt|bkg_no|bkg_no_split|"
					           + "vsl_cd|skd_voy_no|skd_dir_cd|cuz_cntr_no|rhnd_rsn_cd|rvis_rmk";
	           SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:1, DataRowMerge:0 } );
	           var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	           var headers = [ { Text:HeadTitle, Align:"Center"} ];
	           InitHeaders(headers, info);
	           var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rvis_ibflag",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_tml_so_ofc_cty_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_tml_so_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_tml_so_dtl_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_tml_so_dtl_seq2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_tml_so_rvis_list_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_tml_inv_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_calc_cost_grp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_tml_rvis_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_lgs_cost_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_cntr_sty_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_tml_rvis_ind_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_rvis_gate_in_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_rvis_gate_out_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_inv_gate_in_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_inv_gate_out_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_bkg_no_split",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_skd_dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_cuz_cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_rhnd_rsn_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rvis_rvis_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	            
	           InitColumns(cols);
	           SetEditable(0);
           }
           break;            
	 }
}

/**
 * Off-dock CY Invoice Terminal manual cost_cd retrieve
 * @return
 */
function getCalcTerminalManualCostCode() {
//    document.form.yd_chr_inv_tp_cd.value = 'OT';
//    tes_getInputValue('calcTerminalComboItems', SEARCH08, 'yd_chr_inv_tp_cd|yd_fcty_tp_cfs_flg|yd_fcty_tp_rail_rmp_flg|yd_oshp_cd', '');
}

/**
 * Off-dock CY Invoice Storage manual cost_cd retrieve
 * @return
 */
function getCalcStorageManualCostCode() {
//    document.form.yd_chr_inv_tp_cd.value = 'OS';
//    tes_getInputValue('calcStorageComboItems', SEARCH08, 'yd_chr_inv_tp_cd|yd_fcty_tp_cfs_flg|yd_fcty_tp_rail_rmp_flg|yd_oshp_cd', '');
}

/**
 * Setting Terminal Cost Code
 * @param {sheet}	sheet	ibsheet
 * @return
 */
function setCalcTerminalManualCostCode(sheet) {
    var formObj = document.form;
    for (var i = 1; i <= sheet.RowCount(); i++) {
        if (sheet.GetCellValue(i, 'calc_tp_cd') == 'M' || sheet.GetCellValue(i, 'calc_tp_cd') == 'S') {
            org_val = sheet.GetCellValue(i, 'lgs_cost_cd');
            org_sts = sheet.GetRowStatus(i);
            sheet.CellComboItem(i, 'lgs_cost_cd', { ComboText: formObj.calcTerminalComboItems.value, ComboCode: formObj.calcTerminalComboItems.value });
            sheet.SetCellValue(i, 'lgs_cost_cd', sheet.GetCellValue(i, 'lgs_cost_cd2'), 0);
            if (sheet.GetCellValue(i, 'lgs_cost_cd') == null || sheet.GetCellValue(i, 'lgs_cost_cd') == '') {
                sheet.SetCellValue(i, 'lgs_cost_cd', org_val, 0);
            }

            sheet.SetRowStatus(i, org_sts);
        }
    }
}

/**
 * Setting Free Pool & Day Cost Code
 * @param {sheet}	sheet	ibsheet
 * @return
 */
function setCalcStorageManualCostCode(sheet) {
    var formObj = document.form;
    for (var i = 1; i <= sheet.RowCount(); i++) {
        if (sheet.GetCellValue(i, 'calc_tp_cd') == 'M' || sheet.GetCellValue(i, 'calc_tp_cd') == 'S') {
            org_val = sheet.GetCellValue(i, 'lgs_cost_cd');
            org_sts = sheet.GetRowStatus(i);
            sheet.CellComboItem(i, 'lgs_cost_cd', {
                ComboText: formObj.calcStorageComboItems.value,
                ComboCode: formObj.calcStorageComboItems.value
            });
            sheet.SetCellValue(i, 'lgs_cost_cd', sheet.GetCellValue(i, 'lgs_cost_cd2'));
            if (sheet.GetCellValue(i, 'lgs_cost_cd') == null || sheet.GetCellValue(i, 'lgs_cost_cd').trim() == '') {
                sheet.SetCellValue(i, 'lgs_cost_cd', org_val);
            }

            sheet.SetRowStatus(i, org_sts);
        }
    }
}

/** setCalcOffEqManualCostCode
 * 
 * @param sheet
 */
function setCalcOffEqManualCostCode(sheet) {
    var formObj = document.form;
    for (var i = 1; i <= sheet.RowCount(); i++) {
        if (sheet.GetCellValue(i, 'calc_tp_cd') == 'M' || sheet.GetCellValue(i, 'calc_tp_cd') == 'S') {
            org_val = sheet.GetCellValue(i, 'lgs_cost_cd');
            org_sts = sheet.GetRowStatus(i);
            sheet.CellComboItem(i, 'lgs_cost_cd', {
                ComboText: formObj.calcOffEqComboItems.value,
                ComboCode: formObj.calcOffEqComboItems.value
            });
            sheet.SetCellValue(i, 'lgs_cost_cd', sheet.GetCellValue(i, 'lgs_cost_cd2'));
            if (sheet.GetCellValue(i, 'lgs_cost_cd') == null || sheet.GetCellValue(i, 'lgs_cost_cd').trim() == '') {
                sheet.SetCellValue(i, 'lgs_cost_cd', org_val);
            }

            sheet.SetRowStatus(i, org_sts);
        }
    }
}

/**
 * Removing sheet's data.
 * @return
 */
function removeOffdockCYInvoice01() {
    var formObj = document.form;
    var sheetObj = sheetObjects[0];
    sheetObj.ShowDebugMsg(false);
    formObj.f_cmd.value = REMOVE01;
    var param = sheetObj.GetSaveString();
    var sXml = sheetObj.GetSaveData("ESD_TES_0004GS.do", param + '&' + tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
    sheetObj.LoadSaveData(sXml, true);
    /*
     * var sxml0 = sheetObj.EtcData("sxml0"); var sxml1 =
     * sheetObj.EtcData("sxml1"); var sxml2 = sheetObj.EtcData("sxml2"); var
     * sxml3 = sheetObj.EtcData("sxml3"); sheetObjects[0].RemoveEtcData();
     * sheetObjects[0].LoadSearchXml(sxml0); sheetObjects[1].LoadSearchXml(sxml1);
     * sheetObjects[2].LoadSearchXml(sxml2); sheetObjects[3].LoadSearchXml(sxml3);
     */
    sXml = null; // sxml0=null; sxml1=null; sxml2=null; sxml3=null;
    initCoinShtStat();
    sheetObjects[0].RemoveAll();
    sheetObjects[1].RemoveAll();
    sheetObjects[2].RemoveAll();
    sheetObjects[3].RemoveAll();
    setElementDiabled('checkbox', 'TMNL', 'N');
    setElementDiabled('checkbox', 'StorageDay', 'N');
    setElementDiabled('radio', 'CostCalcMethod', 'N');
    formObj.t3sht_tot_inv_amt.value = "0";
    formObj.t4sht_tot_inv_amt.value = "0";
    formObj.t5sht_tot_inv_amt.value = "0";
}

/**
 * Removing CALC.ByPool sheet's data
 * @return
 */
function removeOffdockCYInvoice02() {
    var formObj = document.form;
    var sheetObj = sheetObjects[4];
    sheetObj.ShowDebugMsg(false);
    formObj.f_cmd.value = REMOVE02;
    var param = sheetObj.GetSaveString();
    var sXml = sheetObj.GetSaveData("ESD_TES_0004GS.do", param + '&' + tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
    sheetObj.LoadSaveData(sXml, true);
    /*
     * var sxml0 = sheetObj.EtcData("sxml0"); sheetObjects[0].RemoveEtcData();
     * sheetObjects[0].LoadSearchXml(sxml0);
     */
    sXml = null; // sxml0=null;
    sheetObjects[4].RemoveAll();
}

function removeOffdockCYInvoice03() {
    var formObj = document.form;
    var sheetObj = sheetObjects[9];
    sheetObj.ShowDebugMsg(false);
    formObj.f_cmd.value = REMOVE07;
    var param = sheetObj.GetSaveString();
    var sXml = sheetObj.GetSaveData("ESD_TES_0004GS.do", param + '&' + tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
    sheetObj.LoadSaveData(sXml, true);
    /*
     * var sxml0 = sheetObj.EtcData("sxml0"); sheetObjects[0].RemoveEtcData();
     * sheetObjects[0].LoadSearchXml(sxml0);
     */
    sXml = null; // sxml0=null;
    sheetObjects[9].RemoveAll();
}

/**
 * Checking modify or not.
 * @return
 */
function t1sheet1_ChkMod() {
    if (sheetObjects[0].RowCount() > 0 && (hasAutoCalcData(sheetObjects[2]) || hasAutoCalcData(sheetObjects[3]))) {
        for (var i = sheetObjects[0].HeaderRows(); i < (sheetObjects[0].HeaderRows() + sheetObjects[0].RowCount()); i++) {
            if (sheetObjects[0].GetCellValue(i, 'ibflag') == 'U' && (sheetObjects[0].GetCellValue(i, 'cntr_sty_cd') != sheetObjects[0].CellSearchValue(i, 'cntr_sty_cd') || sheetObjects[0].GetCellValue(i, 'io_bnd_cd') != sheetObjects[0].CellSearchValue(i, 'io_bnd_cd') || sheetObjects[0].GetCellValue(i, 'dcgo_clss_cd') != sheetObjects[0].CellSearchValue(i, 'dcgo_clss_cd') || sheetObjects[0].GetCellValue(i, 'bb_cgo_flg') != sheetObjects[0].CellSearchValue(i, 'bb_cgo_flg'))) {
                return true;
            }
        }
    }
    return false;
}

/**
 * Checking exist sheet's data.
 * @return
 */
function hasAllCalcData() {
    var sheet_obj;
    for (var i = 3; i <= 5; i++) {
        sheet_obj = eval('document.t' + i + 'sheet1');
        if (sheet_obj != null && sheet_obj.RowCount() > 0) {
            return true;
        }
    }
    return false;
}

/**
 * Checking auto or not.
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
 * Checking manual or not.
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
 * Removing data.
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
    formObj.f_cmd.value = REMOVE03;
    var sXml = sheetObjects[2].GetSaveData("ESD_TES_0004GS.do", tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
    var arrXml = sXml.split("|$$|");
    sheetObjects[2].LoadSaveData(arrXml[0], true);
    sXml = null;
}

/**
 * Removing row.
 * @return
 */
function removeAutoCalcData2() {
    if (sheetObjects[4].RowCount() > 0) {
        for (var i = (sheetObjects[4].HeaderRows() + sheetObjects[4].RowCount() - 1); i >= sheetObjects[4].HeaderRows(); i--) {
            if (sheetObjects[4].GetCellValue(i, 'calc_tp_cd') != undefined && sheetObjects[4].GetCellValue(i, 'calc_tp_cd') == 'A') {
                sheetObjects[4].RowDelete(i, false);
            }
        }
    }
    var formObj = document.form;
    var sheetObj = sheetObjects[4];
    sheetObjects[4].ShowDebugMsg(false);
    formObj.f_cmd.value = REMOVE05;
    var sXml = sheetObjects[4].GetSaveData("ESD_TES_0004GS.do", tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
    sheetObjects[4].LoadSaveData(sXml, true);
    sXml = null;
}

/**
 * Removing row.
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
    if (sheetObjects[4].RowCount() > 0) {
        for (var i = (sheetObjects[4].HeaderRows() + sheetObjects[4].RowCount() - 1); i >= sheetObjects[4].HeaderRows(); i--) {
            if (sheetObjects[4].GetCellValue(i, 'calc_tp_cd') != undefined && sheetObjects[4].GetCellValue(i, 'calc_tp_cd') == 'A') {
                sheetObjects[4].RowDelete(i, false);
            }
        }
    }
    var formObj = document.form;
    var sheetObj = sheetObjects[2];
    sheetObjects[2].ShowDebugMsg(false);
    formObj.f_cmd.value = REMOVE04;
    var sXml = sheetObjects[2].GetSaveData("ESD_TES_0004GS.do", tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
    //			sheetObjects[2].LoadSaveXml(sXml, true);
    sXml = null;
}

/**
 * Removing row.
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
    if (sheetObjects[4].RowCount() > 0) {
        for (var i = (sheetObjects[4].HeaderRows() + sheetObjects[4].RowCount() - 1); i >= sheetObjects[4].HeaderRows(); i--) {
            sheetObjects[4].RowDelete(i, false);
        }
    }
    var formObj = document.form;
    var sheetObj = sheetObjects[2];
    sheetObjects[2].ShowDebugMsg(false);
    formObj.f_cmd.value = REMOVE06;
    sheetObjects[2].GetSaveData("ESD_TES_0004GS.do", tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
}

/**
 * Container List(CO, DC), COst Calc. List(TMNL, FD, FP) Coding retrieve, save...
 * @param {sheet}	sheetObj	ibsheet
 * @param {form}	formObj		form object
 * @param {int}	sAction		f_cmd
 * @return
 */
function doActionIBSheetAllSheets(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: // retrieve
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            var arr_sht = getCostCalcShtToSaveArr('N');
            formObj.f_cmd.value = SEARCHLIST03;
            var sXml = sheetObj.GetSearchData("ESD_TES_0004GS.do", tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
            var arrXml = sXml.split("|$$|");
            for (var i = 0; arrXml != null && i < arrXml.length; i++) {
                if (i == 5) {
                    sheetObjects[9].LoadSearchData(arrXml[i], {
                        Sync: 1
                    });
                } else {
                    sheetObjects[i].LoadSearchData(arrXml[i], {
                        Sync: 1
                    });
                }

            }
            break;
        case IBSAVE: // save
            break;
    }
}

/**
 * Verification Sheet, Discrepancy Coding retrieve, save...
 * @param {sheet}	sheetObj	ibsheet
 * @param {form}	formObj		form object
 * @param {int}		sAction		f_cmd
 * @param {string}	SKIP_CHK
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction, SKIP_CHK) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: // retrieve
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            formObj.f_cmd.value = SEARCHLIST;
            var sXml = sheetObj.GetSearchData("ESD_TES_0004GS.do", tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
            var arrXml = sXml.split("|$$|");
            for (var i = 0; arrXml != null && i < arrXml.length; i++) {
                sheetObjects[i].LoadSearchData(arrXml[i], { Sync: 1 });
            }
            break;
            
        case IBSAVE: // save
            if (!checkPeriodModified()) {
                return false;
            }
            
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            var params = new Array();
            params[0] = sheetObjects[0].GetSaveString(false, true);
            params[1] = sheetObjects[1].GetSaveString(false, true);
            //document.write("<br><br>at GetSaveString => "+params[0]);
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
            var sXml = sheetObjects[0].GetSaveData("ESD_TES_0004GS.do", getSaveString(params) + '&' + tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
            var arrXml = sXml.split("|$$|");
            for (var i = 0; arrXml != null && i < arrXml.length; i++) {
                sheetObjects[i].LoadSearchData(arrXml[i], { Sync: 1 });
            }
            break;
            
        case IBINSERT:
            var Row = sheetObj.DataInsert();
            break;
            
        case IBDOWNEXCEL:
            sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1 });
            break;
    }
}

/**
 * Coding retrieve, save...
 * @param {sheet}	sheetObj	ibsheet
 * @param {form}	formObj		form object
 * @param {int}		sAction		f_cmd
 * @return
 */
function doActionIBSheet2(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBINSERT:
            var Row = sheetObj.DataInsert(-1);
            break;
            
        case IBDOWNEXCEL:
            sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1 });
            break;
            
        case IBSEARCH_ASYNC02:
            formObj.f_cmd.value = MULTI05;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0004GS.do", tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
            var arrXml = searchXml.split("|$$|");
            sheetObjects[0].LoadSearchData(arrXml[0], { Sync: 0 });
            sheetObjects[1].LoadSearchData(arrXml[1], { Sync: 0 });
            searchXml = null;
            arrXml[0] = null;
            arrXml[1] = null;

            break;
    }
}

/**
 * Auto calculating CACL.TMNL tab and CALC.FD tab.
 * @param {sheet}	sheetObj	ibsheet
 * @param {form}	formObj		form object
 * @param {int}		sAction		f_cmd
 * @return
 */
function doActionIBSheetCalc(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: // retrieve
            formObj.f_cmd.value = SEARCHLIST01;
            var sXml = sheetObj.GetSearchData("ESD_TES_0004GS.do", tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
            var arrXml = sXml.split("|$$|");
            for (var i = 0; arrXml != null && i < arrXml.length; i++) {
                sheetObjects[i + 2].LoadSearchData(arrXml[i], { Append: 1, Sync: 1 });
            }
            break;
    }
}

function doActionIBSheet3(sheetObj, formObj, sAction, SKIP_CHK) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: // retrieve
            formObj.f_cmd.value = SEARCHLIST02; // DTL total retrieve
            var sXml = sheetObj.GetSearchData("ESD_TES_0004GS.do", tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
            var arrXml = sXml.split("|$$|");
            for (var i = 0; arrXml != null && i < arrXml.length; i++) {
                if (i == 3) {
                    sheetObjects[9].LoadSearchData(arrXml[i], { Sync: 1 });
                } else {
                    sheetObjects[i + 2].LoadSearchData(arrXml[i], { Sync: 1 });
                }
            }
            break;

        case IBSEARCH_ASYNC02:
            formObj.f_cmd.value = SEARCH18;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0004GS.do", tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
            var dbCount = ComGetEtcData(searchXml, "db_cnt");
            var dbInv = ComGetEtcData(searchXml, "inv_no");

            if (dbCount > 0) { //db이 존재한다면
                if (ComShowConfirm("Double Billing Inv [ " + dbInv + " ] exists. Do you want to continue?")) {
                    doActionIBSheetCalc(sheetObjects[2], formObj, IBSEARCH);

                } else {
                    tabObjects[0].SetSelectedIndex(1);
                    doActionIBSheet2(sheetObjects[1], formObj, IBSEARCH_ASYNC02);
                }

            } else {
                doActionIBSheetCalc(sheetObjects[2], formObj, IBSEARCH);
            }

            break;

        case IBSAVE: // save
            if (!checkPeriodModified()) {
                return false;
            }
            
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            
            var colnms = 'lgs_cost_cd';
            var arr_colnms = colnms.split('|');
            var pass = true;
            
            for (var i = 1; i <= sheetObj.RowCount(); i++) {
                if (sheetObj.GetCellValue(i, 'calc_tp_cd') == 'M' && (sheetObj.GetRowStatus(i) == 'I' || sheetObj.GetRowStatus(i) == 'U')) {
                    if (sheetObj.GetCellValue(i, 'rev_yrmon') == null || sheetObj.GetCellValue(i, 'rev_yrmon') == "") {
                        ComShowMessage("Please input Year-Month(YYYYMM).");
                        return false;
                    }
                    
                    if (sheetObj.GetCellValue(i, 'inv_amt') == null || parseFloat(sheetObj.GetCellValue(i, 'inv_amt')) == 0) {
                        ComShowMessage("Please input Amount.");
                        return false;
                    }

                    if (sheetObj.GetCellValue(i, 'calc_rmk') == null || sheetObj.GetCellValue(i, 'calc_rmk') == "") {
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

                if (sheetObj.GetCellValue(i, 'calc_tp_cd') == 'S' && (sheetObj.GetRowStatus(i) == 'I' || sheetObj.GetRowStatus(i) == 'U')) {
                    // Manual Input 비용 계산 적용 Year Month 컬럼 추가 ( 4342. 01. 19 - 이경한과장 요청 TMNL 추가)
                    if (sheetObj.GetCellValue(i, 'rev_yrmon') == null || sheetObj.GetCellValue(i, 'rev_yrmon') == "") {
                        ComShowMessage("Please input Year-Month(YYYYMM).");
                        return false;
                    }
                    
                    // Manual Input Amount가 0인 경우 ( 4342. 01. 19 - 이경한과장 )
                    // Amount Check Integer체크하던것을 Float으로 변경 ( 2009-02-13 - 이경한과장 )
                    if (sheetObj.GetCellValue(i, 'inv_amt') == null || parseFloat(sheetObj.GetCellValue(i, 'inv_amt')) == 0) {
                        ComShowMessage("Please input Amount.");
                        return false;
                    }

                    if (sheetObj.GetCellValue(i, 'calc_rmk') == null || sheetObj.GetCellValue(i, 'calc_rmk') == "") {
                        ComShowMessage("Please,  must input remarks.");
                        return false;
                    }
                }
            }

            if (!pass) {
                ComShowMessage(ComGetMsg('TES23029'));
                return false;
            }

            var arr_sht = getCostCalcShtToSaveArr('Y');
            formObj.f_cmd.value = MULTI01;
            var params = new Array();

            for (var i = 0; arr_sht != null && i < arr_sht.length; i++) {
                params[i] = sheetObjects[arr_sht[i]].GetSaveString(false, true);
            }

            var sheets = new Array();
            for (var i = 0; arr_sht != null && i < arr_sht.length; i++) {
                sheets[i] = sheetObjects[arr_sht[i]];
            }

            if (SKIP_CHK == undefined || SKIP_CHK == null || SKIP_CHK == '' || SKIP_CHK != 'Y') {
                if (!tes_isModified(sheets, params)) {
                    ComShowMessage(ComGetMsg('TES23018'));
                    break;
                }
                if (!chkCostCalcSaveSts(2)) {
                    return false;
                }
            }
            var sXml = sheetObj.GetSaveData("ESD_TES_0004GS.do", getSaveString(params) + '&' + tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
            var arrXml = sXml.split("|$$|");
            for (var i = 0; arrXml != null && i < arrXml.length; i++) {
                if (i == 3) {
                    sheetObjects[9].LoadSearchData(arrXml[i], { Sync: 1 });
                } else {
                    sheetObjects[i + 2].LoadSearchData(arrXml[i], { Sync: 1 });
                }

            }
            break;

        case IBINSERT:
            var Row = sheetObj.DataInsert(-1);
            sheetObj.SetCellValue(Row, "calc_cost_grp_cd", "TM", 0);
            sheetObj.SetCellValue(Row, "calc_tp_cd", "M", 0);
            sheetObj.SetCellValue(Row, "cntr_tpsz_cd", "", 0);
            sheetObj.SetCellValue(Row, "io_bnd_cd", "", 0);
            sheetObj.SetCellValue(Row, "vol_tr_ut_cd", "", 0);
            sheetObj.CellComboItem(Row, 'lgs_cost_cd', { ComboText: formObj.calcTerminalComboItems.value, ComboCode: formObj.calcTerminalComboItems.value });
            sheetObj.SetCellValue(Row, "lgs_cost_cd", "", 0);
            sheetObj.SetCellValue(Row, "inv_xch_rt", 1, 0);
            sheetObj.SetCellValue(Row, "rc_flg", "N", 0);
            // sheetObj.SetCellValue(Row,"tmp_dtl_seq") = getMaxTmpDtlSeq(sheetObj) +
            // 1;
            
            setDefaultCurrencyFormToSheet(sheetObj, Row, "curr_cd");//2016.10.11 Currency FormToSheet Add
            
            setShtCellsEditable(sheetObj, Row, 'lgs_cost_cd|cntr_tpsz_cd|rev_yrmon|io_bnd_cd|calc_vol_qty|vol_tr_ut_cd|ctrt_rt|inv_amt|inv_xch_rt|rc_flg|tml_trns_mod_cd', 'Y');
            // setShtCellsEditable(sheetObj,Row,'rvis_vol_qty','N');
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
            break;
            
        case IBDOWNEXCEL:
            sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1 });
            break;
    }
}

/**
 * Coding retrieve, save...
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {form} 	formObj		Form Object
 * @param {int}		sAction		f_cmd
 * @param {string}	SKIP_CHK
 * @return
 */
function doActionIBSheet4(sheetObj, formObj, sAction, SKIP_CHK) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: // retrieve
            break;
            
        case IBSAVE: // save
            if (!checkPeriodModified()) {
                return false;
            }
            if (!validateForm(sheetObj, formObj, sAction)) {
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
            
            /* save */
            var arr_sht = getCostCalcShtToSaveArr();
            formObj.f_cmd.value = MULTI01;
            var params = new Array();
            
            for (var i = 0; arr_sht != null && i < arr_sht.length; i++) {
                params[i] = sheetObjects[arr_sht[i]].GetSaveString(false, true);
            }
            
            var sheets = new Array();
            for (var i = 0; arr_sht != null && i < arr_sht.length; i++) {
                sheets[i] = sheetObjects[arr_sht[i]];
            }
            
            if (SKIP_CHK == undefined || SKIP_CHK == null || SKIP_CHK == '' || SKIP_CHK != 'Y') {
                if (!tes_isModified(sheets, params)) {
                    ComShowMessage(ComGetMsg('TES23018'));
                    break;
                }
                if (!chkCostCalcSaveSts(3)) {
                    return false;
                }
            }
            
            var sXml = sheetObj.GetSaveData("ESD_TES_0004GS.do", getSaveString(params) + '&' + tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
            var arrXml = sXml.split("|$$|");
            for (var i = 0; arrXml != null && i < arrXml.length; i++) {
                if (i == 3) {
                    sheetObjects[9].LoadSearchData(arrXml[i], {
                        Sync: 1
                    });
                } else {
                    sheetObjects[i + 2].LoadSearchData(arrXml[i], {
                        Sync: 1
                    });
                }
            }
            //				sheetObj.LoadSaveXml(sXml, true);
            //				var sxml0;
            //				var sxml1;
            //
            //				for ( var i = 0; arr_sht != null && i < arr_sht.length; i++) {
            //					if (i == 0) {
            //						sxml0 = sheetObj.EtcData(eval(new String('sxml' + new String(i))));
            //					} else if (i == 1) {
            //						sxml1 = sheetObj.EtcData(eval(new String('sxml' + new String(i))));
            //					}
            //				}
            //				sheetObj.RemoveEtcData();
            //
            //				for ( var i = 0; arr_sht != null && i < arr_sht.length; i++) {
            //					sheetObjects[arr_sht[i]].LoadSearchXml(eval('sxml' + new String(i)));
            //				}
            //				sXml = null;
            //				sxml0 = null;
            //				sxml1 = null;
            break;

        case IBINSERT:
            var Row = sheetObj.DataInsert(-1);
            sheetObj.SetCellValue(Row, "calc_cost_grp_cd", "SD", 0);
            sheetObj.SetCellValue(Row, "calc_tp_cd", "M", 0);
            sheetObj.SetCellValue(Row, "cntr_tpsz_cd", "", 0);
            sheetObj.SetCellValue(Row, "io_bnd_cd", "", 0);
            sheetObj.SetCellValue(Row, "dcgo_ind_cd", "", 0);
            sheetObj.SetCellValue(Row, "vol_tr_ut_cd", "", 0);
            sheetObj.CellComboItem(Row, 'lgs_cost_cd', { ComboText: formObj.calcStorageComboItems.value,  ComboCode: formObj.calcStorageComboItems.value});
            sheetObj.SetCellValue(Row, "lgs_cost_cd", "", 0);
            sheetObj.SetCellValue(Row, "inv_xch_rt", 1, 0);
            // sheetObj.SetCellValue(Row,"tmp_dtl_seq") = getMaxTmpDtlSeq(sheetObj) +
            // 1;
            
            setDefaultCurrencyFormToSheet(sheetObj, Row, "curr_cd");//2016.10.11 Currency FormToSheet Add
            
            setShtCellsEditable(sheetObj, Row, 'lgs_cost_cd|rev_yrmon|stay_dys|ctrt_rt|inv_amt|inv_xch_rt', 'Y');
            setShtCellsEditable(sheetObj, Row, 'free_dys|paid_day|free_dy_xcld_dys', 'N');
            break;


        case IBDELETE:
            if (sheetObj.RowCount() > 0) {
                var Row = sheetObj.GetSelectRow();
                var calc_tp_cd = sheetObj.GetCellValue(Row, "calc_tp_cd");
                if (calc_tp_cd != null && (calc_tp_cd == 'M' || calc_tp_cd == 'S')) {
                    if (sheetObj.GetCellValue(Row, "tml_so_dtl_seq") == null || sheetObj.GetCellValue(Row, "tml_so_dtl_seq") == '' || parseInt(sheetObj.GetCellValue(Row, "tml_so_dtl_seq"),
                            10) == 0) {
                        sheetObj.RowDelete(Row, false);
                    } else {
                        sheetObj.SetRowStatus(Row, 'D');
                        sheetObj.SetRowHidden(Row, 1);
                        sheetObj.SetCellValue(Row, "inv_amt", 0, 0);
                    }
                    document.form.t4sht_tot_inv_amt.value = getShtTotCalcAmt(sheetObj, 'inv_amt');

                } else if (calc_tp_cd != null && (calc_tp_cd == 'A')) {
                    ComShowMessage(ComGetMsg('TES21046'));
                }
            }
            break;
            
        case IBDOWNEXCEL:
            sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1 });
            break;
    }
}

function doActionIBSheet6(sheetObj, formObj, sAction, SKIP_CHK) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: // retrieve
            break;
            
        case IBSAVE: // save
            if (!checkPeriodModified()) {
                return false;
            }
            
            if (!validateForm(sheetObj, formObj, sAction)) {
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
            
            /* save */
            formObj.f_cmd.value = MULTI01;
            formObj.dtl_by_eq_only_mode.value = 'Y';
            var params = new Array();
            params[0] = sheetObjects[9].GetSaveString(false, true);

            var sheets = new Array();
            sheets[0] = sheetObjects[9];

            if (SKIP_CHK == undefined || SKIP_CHK == null || SKIP_CHK == '' || SKIP_CHK != 'Y') {
                if (!tes_isModified(sheets, params)) {
                    ComShowMessage(ComGetMsg('TES23018'));
                    break;
                }
                if (!chkCostCalcSaveSts(9)) {
                    return false;
                }
            }
            
            var sXml = sheetObj.GetSaveData("ESD_TES_0004GS.do", getSaveString(params) + '&' + tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
            sheetObj.LoadSaveData(sXml, true);
            formObj.dtl_by_eq_only_mode.value = '';
            //				var arrXml=sXml.split("|$$|"); 
            //				for (var i=0; arrXml!=null && i<arrXml.length; i++) {
            //					sheetObjects[i+2].LoadSearchData(arrXml[i],{Sync:1} );
            //				}

            //				sheetObj.LoadSaveXml(sXml, true);
            //				var sxml0;
            //				var sxml1;
            //
            //				for ( var i = 0; arr_sht != null && i < arr_sht.length; i++) {
            //					if (i == 0) {
            //						sxml0 = sheetObj.EtcData(eval(new String('sxml' + new String(i))));
            //					} else if (i == 1) {
            //						sxml1 = sheetObj.EtcData(eval(new String('sxml' + new String(i))));
            //					}
            //				}
            //				sheetObj.RemoveEtcData();
            //
            //				for ( var i = 0; arr_sht != null && i < arr_sht.length; i++) {
            //					sheetObjects[arr_sht[i]].LoadSearchXml(eval('sxml' + new String(i)));
            //				}
            //				sXml = null;
            //				sxml0 = null;
            //				sxml1 = null;
            break;

        case IBINSERT:
            var Row = sheetObj.DataInsert(-1);
            sheetObj.SetCellValue(Row, "calc_cost_grp_cd", "EQ", 0);
            sheetObj.SetCellValue(Row, "calc_tp_cd", "M", 0);
            //	sheetObj.SetCellValue(Row, "eq_tpsz_cd","",0);
            sheetObj.CellComboItem(Row, 'eq_tpsz_cd', { ComboText: EQ_TPSZ_CD, ComboCode: EQ_TPSZ_CD });
            sheetObj.SetCellValue(Row, "io_bnd_cd", "", 0);
            sheetObj.SetCellValue(Row, "dcgo_ind_cd", "", 0);
            sheetObj.SetCellValue(Row, "vol_tr_ut_cd", "", 0);
            sheetObj.CellComboItem(Row, 'lgs_cost_cd', { ComboText: document.form.calcOffEqComboItems.value, ComboCode: document.form.calcOffEqComboItems.value });
            sheetObj.SetCellValue(Row, "lgs_cost_cd", "", 0);
            sheetObj.SetCellValue(Row, "inv_xch_rt", 1, 0);
            // sheetObj.SetCellValue(Row,"tmp_dtl_seq") = getMaxTmpDtlSeq(sheetObj) +
            // 1;
            
            setDefaultCurrencyFormToSheet(sheetObj, Row, "curr_cd");//2016.10.11 Currency FormToSheet Add
            
            setShtCellsEditable(sheetObj, Row, 'lgs_cost_cd|rev_yrmon|stay_dys|ctrt_rt|inv_amt|inv_xch_rt', 'Y');
            setShtCellsEditable(sheetObj, Row, 'free_dys|paid_day|free_dy_xcld_dys', 'N');
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
                    document.form.t6sht_tot_inv_amt.value = getShtTotCalcAmt(sheetObj, 'inv_amt');

                } else if (calc_tp_cd != null && (calc_tp_cd == 'A')) {
                    ComShowMessage(ComGetMsg('TES21046'));
                }
            }
            break;
            
        case IBDOWNEXCEL:
            sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1 });
            break;
    }
}

/**
 * Coding retrieve, save...
 * @param {ibsheet}sheetObj 	IBSheet Object
 * @param {form} 	formObj		Form Object
 * @param {int}	sAction		f_cmd
 * @param {string}	SKIP_CHK
 * @return
 */
function doActionIBSheet5(sheetObj, formObj, sAction, SKIP_CHK) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: // retrieve
            formObj.f_cmd.value = SEARCHLIST02;
            formObj.dtl_by_pool_only_mode.value = 'Y';
            var sXml = sheetObj.GetSearchData("ESD_TES_0004GS.do", tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
            sheetObj.LoadSearchData(sXml, { Sync: 1 });
            //				var sxml0 = sheetObj.EtcData('sxml0');
            //				sheetObj.RemoveEtcData();
            //				sheetObjects[4].LoadSearchXml(sxml0);
            //				sXml = null;
            //				sxml0 = null;
            formObj.dtl_by_pool_only_mode.value = '';
            break;
            
        case IBSAVE: // save
            if (!checkPeriodModified()) {
                return false;
            }
            
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            
            var colnms = 'lgs_cost_cd';
            var arr_colnms = colnms.split('|');
            var pass = true;
            
            for (var i = 1; i <= sheetObj.RowCount(); i++) {
                if (sheetObj.GetCellValue(i, 'calc_tp_cd') == 'M' && (sheetObj.GetRowStatus(i) == 'I' || sheetObj.GetRowStatus(i) == 'U')) {
                    ComGetMsg('TES23045')
                    if (sheetObj.GetCellValue(i, 'lgs_cost_cd') == null || sheetObj.GetCellValue(i, 'lgs_cost_cd') == "") {
                        ComShowMessage(ComGetMsg('TES23045'));
                        return false;
                    }
                    if (sheetObj.GetCellValue(i, 'wrk_dt') == null || sheetObj.GetCellValue(i, 'wrk_dt') == "") {
                        ComShowMessage(ComGetMsg('TES40025', 'Date')); //ComShowMessage("Please input Date.");
                        return false;
                    }
                    if (sheetObj.GetCellValue(i, 'inv_amt') == null || parseFloat(sheetObj.GetCellValue(i, 'inv_amt')) == 0) {
                        ComShowMessage(ComGetMsg('TES40025', 'Amount')); //ComShowMessage("Please input Amount.");
                        return false;
                    }

                    if (sheetObj.GetCellValue(i, 'calc_rmk') == null || sheetObj.GetCellValue(i, 'calc_rmk').trim() == "") {
                        ComShowMessage("Please,  must input remarks in manual calculation type.");
                        return false;
                    }
                    //						for ( var j = 0; j < arr_colnms.length; j++) {
                    //							if (sheetObj.GetCellValue(i, arr_colnms[j]) == null || sheetObj.GetCellValue(i, arr_colnms[j]) == '') {
                    //								pass = false;
                    //								sheetObj.RowFontColor(i) = "#FF0000";
                    //							} else {
                    //								if (pass) {
                    //									sheetObj.RowFontColor(i) = sheetObj.DataFontColor;
                    //								}
                    //							}
                    //						}
                }
            }
            //				if (!pass) {
            //					ComShowMessage(ComGetMsg('TES23029'));
            //					return false;
            //				}
            var params = new Array();
            params[0] = sheetObjects[4].GetSaveString(false, true);
            var sheets = new Array();
            sheets[0] = sheetObjects[4];
            formObj.f_cmd.value = MULTI01;
            formObj.dtl_by_pool_only_mode.value = 'Y';
            if (SKIP_CHK == undefined || SKIP_CHK == null || SKIP_CHK == '' || SKIP_CHK != 'Y') {
                if (!tes_isModified(sheets, params)) {
                    ComShowMessage(ComGetMsg('TES23018'));
                    break;
                }
            }
            var sXml = sheetObj.GetSaveData("ESD_TES_0004GS.do", getSaveString(params) + '&' + tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
            sheetObj.LoadSaveData(sXml, true);
            formObj.dtl_by_pool_only_mode.value = '';
            //				var sxml0 = sheetObj.EtcData("sxml0");
            //				// ComShowMessage('sxml0:\n\n'+sxml0);
            //				sheetObj.RemoveEtcData();
            //				sheetObjects[4].LoadSearchXml(sxml0);
            //				formObj.dtl_by_pool_only_mode.value = '';
            //				sXml = null;
            //				sxml0 = null;
            break;

        case IBINSERT:
            var Row = sheetObj.DataInsert(-1);
            sheetObj.SetCellValue(Row, "calc_cost_grp_cd", "SP", 0);
            sheetObj.SetCellValue(Row, "calc_tp_cd", "M", 0);
            sheetObj.SetCellValue(Row, "cntr_tpsz_cd", "", 0);
            sheetObj.SetCellValue(Row, "io_bnd_cd", "", 0);
            sheetObj.SetCellValue(Row, "fp_calc_prd_cd", "D", 0);
            sheetObj.SetCellValue(Row, "inv_xch_rt", "1", 0);
            // sheetObj.SetCellValue(Row,"tmp_dtl_seq") = getMaxTmpDtlSeq(sheetObj) +
            // 1;


            sheetObj.CellComboItem(Row, 'lgs_cost_cd', formObj.calcStorageComboItems.value, formObj.calcStorageComboItems.value);
            sheetObj.SetCellValue(Row, "lgs_cost_cd", "", "");

            setDefaultCurrencyFormToSheet(sheetObj, Row, "curr_cd");//2016.10.11 Currency FormToSheet Add
            
            var SaveJson = sheetObj.GetSaveJson(1);
            sheetObj.LoadSearchData(SaveJson, { Sync: 1});

            setShtCellsEditable(sheetObj, Row, 'lgs_cost_cd|wrk_dt|stk_vol_qty|inv_vol_qty|diff_vol_qty|fp_teu_qty|ovr_vol_qty|vol_tr_ut_cd|ctrt_rt|inv_amt|calc_rmk|n3pty_flg|inv_xch_rt', 'Y');

            //t5sheet1_ShowSubSum(sheetObj);
            t5sheet1_TotCalcAmt(sheetObj);
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
                    t5sheet1_ShowSubSum(sheetObj);
                    t5sheet1_TotCalcAmt(sheetObj);

                } else if (calc_tp_cd != null && (calc_tp_cd == 'A')) {
                    ComShowMessage(ComGetMsg('TES21046'));
                }
            }
            break;

        case IBDOWNEXCEL:
            sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1 });
            break;
    }
}

/**
 * Main Hidden Coding retrieve, save...
 * @param {sheet}	sheetObj	ibsheet
 * @param {form}	formObj		form
 * @param {int}		sAction		action code
 * @return
 */
function doActionMainHiddenSheet(sheetObj, formObj, sAction) {    //main_hidden_OnSearchEnd
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: // retrieve
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch("ESD_TES_0004GS.do", tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'), { Sync: 1 });
            break;

        case IBSEARCH_ASYNC04:
            formObj.f_cmd.value = SEARCH16;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0004GS.do", tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
            var ydNm = ComGetEtcData(searchXml, "yd_nm");
            formObj.yd_nm.value = ydNm;
            validateYardCode();
            searchXml = null;
            break;

        case IBSEARCH_ASYNC05:
            formObj.f_cmd.value = SEARCH17;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0004GS.do", tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
            var vndrNm = ComGetEtcData(searchXml, "vndr_nm");
            formObj.vndr_seq_nm.value = vndrNm;
            searchXml = null;
            break;

        case IBSAVE: // save
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            
            if (sheetObj.RowCount() == 0) {
                if (fnChkSearchForm()) {
                    formObj.f_cmd.value = SEARCH;
                    sheetObjects[8].RemoveAll();
                    sheetObjects[8].DoSearch("ESD_TES_0004GS.do", tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
                    if (sheetObjects[8].RowCount() == 0) {
                        formObj.f_cmd.value = ADD;
                    } else if (sheetObjects[8].RowCount() == 1) {
                        if (sheetObjects[8].GetCellValue(1, 'tml_inv_tp_cd') == 'TM') {
                            ComShowMessage(ComGetMsg('TES23030', 'Terminal invoice'));
                            sheetObjects[5].RemoveAll();
                            return false;
                        } else if (sheetObjects[8].GetCellValue(1, 'tml_inv_tp_cd') == 'ST') {
                            ComShowMessage(ComGetMsg('TES23030', 'Storage invoice'));
                            sheetObjects[5].RemoveAll();
                            return false;
                        } else if (sheetObjects[8].GetCellValue(1, 'tml_inv_tp_cd') == 'ON') {
                            ComShowMessage(ComGetMsg('TES23030', 'On-dock invoice'));
                            sheetObjects[5].RemoveAll();
                            return false;
                        }
                        if (!confirm(ComGetMsg('TES24071'))) {
                            sheetObjects[0].RemoveAll();
                            sheetObjects[1].RemoveAll();
                            sheetObjects[2].RemoveAll();
                            sheetObjects[3].RemoveAll();
                            sheetObjects[4].RemoveAll();
                            sheetObjects[5].RemoveAll();
                            sheetObjects[6].RemoveAll();
                            sheetObjects[7].RemoveAll();
                            sheetObjects[8].RemoveAll();
                            sheetObjects[9].RemoveAll();
                            return false;
                        } else {
                            try {
                                formObj.f_cmd.value = SEARCH;
                                sheetObjects[5].DoSearch("ESD_TES_0004GS.do", tesFrmQryStr(formObj + "&" + 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
                                if (sheetObjects[5].RowCount() == 1) {
                                    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH); // COIN,DSCP - retrieve
                                    setCalcCostCond();
                                    doActionIBSheet3(sheetObjects[2], formObj, IBSEARCH); // Calc.XXX - retrieve
                                    var cost_calc_tmnl = false;
                                    var cost_calc_day = false;
                                    var cost_calc_pool = true;
                                    var curr_tab_idx = 0;
                                    if (formObj.TMNL.checked == true) {
                                        cost_calc_tmnl = true;
                                    } else {
                                        cost_calc_tmnl = false;
                                    }
                                    if (formObj.StorageDay.checked == true) {
                                        cost_calc_day = true;
                                    } else {
                                        cost_calc_day = false;
                                    }
                                    if (sheetObjects[1].RowCount() > 0) {
                                        curr_tab_idx = 1;
                                    }
                                    setSheetsEnable(curr_tab_idx, true);
                                }
                                break;
                            } catch (e) {
                                ComShowMessage(e.message);
                                sheetObjects[0].RemoveAll();
                                sheetObjects[1].RemoveAll();
                                sheetObjects[2].RemoveAll();
                                sheetObjects[3].RemoveAll();
                                sheetObjects[4].RemoveAll();
                                sheetObjects[5].RemoveAll();
                                sheetObjects[6].RemoveAll();
                                sheetObjects[7].RemoveAll();
                                sheetObjects[8].RemoveAll();
                                sheetObjects[9].RemoveAll();
                                return false;
                            }
                        }
                    } else {
                        ComShowMessage(ComGetMsg('TES23031'));
                        sheetObjects[0].RemoveAll();
                        sheetObjects[1].RemoveAll();
                        sheetObjects[2].RemoveAll();
                        sheetObjects[3].RemoveAll();
                        sheetObjects[4].RemoveAll();
                        sheetObjects[5].RemoveAll();
                        sheetObjects[6].RemoveAll();
                        sheetObjects[7].RemoveAll();
                        sheetObjects[8].RemoveAll();
                        sheetObjects[9].RemoveAll();
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
                    ComShowMessage(ComGetMsg('TES21035'));
                    return false;
                }
            } else {
                ComShowMessage(ComGetMsg('TES23031'));
                return false;
            }
            
            formObj.ttl_inv_amt.value = tes_deleteComma(formObj.ttl_inv_amt.value);
            formObj.vat_amt.value = tes_deleteComma(formObj.vat_amt.value);
            formObj.whld_tax_amt.value = tes_deleteComma(formObj.whld_tax_amt.value);
            var param = sheetObj.GetSaveString();
            var savexml = sheetObj.GetSaveData("ESD_TES_0004GS.do", param + '&' + tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
            if (savexml != "") {
                sheetObj.RemoveAll();
                sheetObj.LoadSaveData(savexml);
            }
            break;
            
        case IBINSERT:
            var Row = sheetObj.DataInsert();
            break;
            
        case IBDOWNEXCEL: // Downloading excel.
            sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1 });
            break;
    }
}

/**
 * Reject Hidden Coding retrieve, save...
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
            var savexml = sheetObj.GetSaveData("ESD_TES_0004GS.do", tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
            sheetObj.LoadSaveData(savexml, true);
            break;
    }
}

/**
 * Validating [Each. Rate]
 * @param {sheet}	sheets	Cost Calc. sheets
 * @return
 */
function checkInvXchRt(sheets) {
    var returnValue = true;
    var curr_cd_hdr = curr_cd.GetSelectCode();
    for (var i = 0; i < sheets.length; i++) {
        for (var j = sheets[i].HeaderRows(); sheets[i] != null && sheets[i].RowCount() > 0 && j < (sheets[i].HeaderRows() + sheets[i].RowCount()); j++) {
            if (sheets[i].GetCellValue(j, 'calc_tp_cd') == 'A') {
                if (curr_cd_hdr != undefined && curr_cd_hdr != null && curr_cd_hdr != '' && sheets[i].GetCellValue(j, 'curr_cd') != undefined && sheets[i].GetCellValue(j, 'curr_cd') != null && sheets[i].GetCellValue(j, 'curr_cd') != '' && sheets[i].GetCellValue(j, 'curr_cd') != curr_cd_hdr && parseFloat(sheets[i].GetCellValue(j, 'inv_xch_rt')) <= 0) {
                    sheets[i].SetCellBackColor(j, 'inv_xch_rt', sheets[i], "#FF9999");
                    returnValue = false;
                }
            }
        }
    }
    return returnValue;
}

/**
 * Confirm  Hidden Coding retrieve, save...
 * @param {sheet}	sheetObj	ibsheet
 * @param {form}	formObj		form
 * @param {int}	sAction		action code
 * @return
 */
function doActionConfirmHiddenSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: // confirm
            break;
            
        case IBSAVE: // save
            if (sheetObjects[2].RowCount() <= 0 && sheetObjects[3].RowCount() <= 0 && sheetObjects[4].RowCount() <= 0 && sheetObjects[9].RowCount() <= 0) {
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
            sheets2[2] = sheetObjects[4];
            //				sheets2[3]=sheetObjects[9]; EQ는 넣지 안아도 됨 다 MANUAL로 생성

            if (!checkInvXchRt(sheets2)) {
                ComShowMessage(ComGetMsg('TES21026', 'Exch.Rate'));
                return false;
            }
            
            if (formObj.ttl_inv_amt.value == null || formObj.ttl_inv_amt.value == '') {
                formObj.ttl_inv_amt.value = 0;
            }
            
            var ttl_inv_amt = tes_deleteComma(formObj.ttl_inv_amt.value);
            if (isNaN(parseFloat(tes_deleteComma(formObj.ttl_inv_amt.value)))) {
                ComShowMessage(ComGetMsg('TES24008', 'INV AMT'));
                return false;
            }
            
            var total_inv_amt = 0;
            var TMNL_check = false;
            var StorageByDay_check = false;
            var StorageByPool_check = true;
            var StorageByEQl_check = true;
            var tml_cost_grp_cd = sheetObjects[5].GetCellValue(1, 'tml_cost_grp_cd');
            var tml_calc_ind_cd = sheetObjects[5].GetCellValue(1, 'tml_calc_ind_cd');
            var sto_dys_ind_cd = sheetObjects[5].GetCellValue(1, 'sto_dys_ind_cd');
            if (tml_cost_grp_cd != undefined && tml_cost_grp_cd.length == 2) {
                if (tml_cost_grp_cd.substring(0, 1) == 'T') {
                    TMNL_check = true;
                }
                if (tml_cost_grp_cd.substring(1, 2) == 'D') {
                    StorageByDay_check = true;
                }
            } else {
                ComShowMessage(ComGetMsg('TES24036'));
                return false;
            }
            if (TMNL_check) {
                if (formObj.t3sht_tot_inv_amt.value != null && formObj.t3sht_tot_inv_amt.value != '') {
                    total_inv_amt = total_inv_amt + parseFloat(tes_deleteComma(formObj.t3sht_tot_inv_amt.value)) * 1000000;
                }
            }
            if (StorageByDay_check) {
                if (formObj.t4sht_tot_inv_amt.value != null && formObj.t4sht_tot_inv_amt.value != '') {
                    total_inv_amt = total_inv_amt + parseFloat(tes_deleteComma(formObj.t4sht_tot_inv_amt.value)) * 1000000;
                }
            }
            if (StorageByPool_check) {
                if (formObj.t5sht_tot_inv_amt.value != null && formObj.t5sht_tot_inv_amt.value != '') {
                    total_inv_amt = total_inv_amt + parseFloat(tes_deleteComma(formObj.t5sht_tot_inv_amt.value)) * 1000000;
                }
            }
            if (StorageByEQl_check) {
                if (formObj.t6sht_tot_inv_amt.value != null && formObj.t6sht_tot_inv_amt.value != '') {
                    total_inv_amt = total_inv_amt + parseFloat(tes_deleteComma(formObj.t6sht_tot_inv_amt.value)) * 1000000;
                }
            }
            total_inv_amt /= 1000000;
            // ComShowMessage('ttl_inv_amt:'+ttl_inv_amt+' /
            // total_inv_amt:'+total_inv_amt + '\n\n'
            // +parseFloat(tes_deleteComma(formObj.t3sht_tot_inv_amt.value)) + '\n'
            // +parseFloat(tes_deleteComma(formObj.t4sht_tot_inv_amt.value)) + '\n'
            // +parseFloat(tes_deleteComma(formObj.t5sht_tot_inv_amt.value)));
            if (ttl_inv_amt != total_inv_amt) {
                ComShowMessage(ComGetMsg('TES24037', 'INV AMT', 'AMT'));
                return false;
            }
            
            doActionMainHiddenSheet(sheetObjects[5], formObj, IBSAVE); // hdr information save
            doActionIBSheet3(sheetObjects[2], formObj, IBSAVE, 'Y'); // calc list (TMNL,ByDay) information save
            doActionIBSheet5(sheetObjects[4], formObj, IBSAVE, 'Y'); // calc list (ByPool) information save
            // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            formObj.confirm_mode.value = 'CONFIRM';
            formObj.f_cmd.value = MULTI02;
            var param = sheetObj.GetSaveString();
            var savexml = sheetObj.GetSaveData("ESD_TES_0004GS.do", param + '&' + tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
            if (savexml != "") {
                sheetObj.RemoveAll();
                sheetObj.LoadSaveData(savexml, true);
            }

            break;
    }
}

/**
 * Comparing period and sheet period.
 * @return
 */
function checkPeriodModified() {
    var formObj = document.form;
    // if
    // (formObj.fm_prd_dt.value.replace(/-/gi,'')!=sheetObjects[5].GetCellValue(1,"fm_prd_dt").replace(/-/gi,'')
    // ||
    // formObj.to_prd_dt.value.replace(/-/gi,'')!=sheetObjects[5].GetCellValue(1,"to_prd_dt").replace(/-/gi,''))
    if (formObj.fm_prd_dt.value != sheetObjects[5].GetCellValue(1, "fm_prd_dt") || formObj.to_prd_dt.value != sheetObjects[5].GetCellValue(1, "to_prd_dt")) {
        ComShowMessage(ComGetMsg('TES24038'));
        return false;
    }
    return true;
}

/**
 *  off, on change 시 
 */
function tmlOdckFlgChange() {
    var formObj = document.form;

    if (document.form.tml_odck_flg.value == "Y") {
        document.form.calcTerminalComboItems.value = (groval_tmp[9] != undefined && groval_tmp[9] != null ? groval_tmp[9] : '');
    } else {
        document.form.calcTerminalComboItems.value = (groval_tmp[11] != undefined && groval_tmp[11] != null ? groval_tmp[11] : '');
    }

    if (sheetObjects[2].RowCount() > 0 || sheetObjects[3].RowCount() > 0 || sheetObjects[4].RowCount() > 0 || sheetObjects[9].RowCount() > 0) { // 데이터가 하나라도 있을때
        if (sheetObjects[2].RowCount() == 0 && sheetObjects[3].RowCount() == 0 && sheetObjects[4].RowCount() == 1 && sheetObjects[4].GetCellValue(1, "lgs_cost_cd") == "TTL") { //ttl 이면
            if (document.form.tml_odck_flg.value == "Y") {
                setElementDiabled('checkbox', 'TMNL', 'N');
                setElementDiabled('checkbox', 'StorageDay', 'Y');
                setElementDiabled('radio', 'CostCalcMethod', 'N');

                document.form.StorageDay.checked = false;

            } else {
                setElementDiabled('checkbox', 'TMNL', 'N');
                setElementDiabled('checkbox', 'StorageDay', 'N');
                setElementDiabled('radio', 'CostCalcMethod', 'N');

                document.form.StorageDay.checked = true;
            }

            //					main_hidden.SetCellValue(1, 'tml_odck_flg', document.form.tml_odck_flg.value);

            if (formObj.tml_odck_flg.value == "N") {
                if (formObj.TMNL.checked == true && formObj.StorageDay.checked == true) {
                    formObj.agmt_ftr_inv_tp_cd.value = "OTOS";
                } else if (formObj.TMNL.checked == true) {
                    formObj.agmt_ftr_inv_tp_cd.value = "OT";
                } else if (formObj.StorageDay.checked == true) {
                    formObj.agmt_ftr_inv_tp_cd.value = "OS";
                } else {
                    formObj.agmt_ftr_inv_tp_cd.value = "";
                }

            } else {
                if (formObj.TMNL.checked == true) {
                    formObj.agmt_ftr_inv_tp_cd.value = "OFON";
                } else {
                    formObj.agmt_ftr_inv_tp_cd.value = "";
                }
            }
            
			var costCdFtrRmk = formObj.cost_cd_ftr_rmk.value;
        	getAgmtCostCdList(1, 75, 150, costCdFtrRmk); // tes_getComboItem('agmt_lgs_cost_cd', 2, SEARCHLIST10, '', 'vndr_seq|yd_cd|agmt_ftr_inv_tp_cd|atb_dt', 'setAgmtCostCd');

        } else {
            alert("After You delete all data, You can change this data.");
            if (document.form.tml_odck_flg.value == "Y") {
                document.form.tml_odck_flg.value = "N";
            } else {
                document.form.tml_odck_flg.value = "Y";
            }
        }


    } else { //데이터가 하나도 없을때
        if (document.form.tml_odck_flg.value == "Y") {
            setElementDiabled('checkbox', 'TMNL', 'N');
            setElementDiabled('checkbox', 'StorageDay', 'Y');
            setElementDiabled('radio', 'CostCalcMethod', 'N');

            document.form.StorageDay.checked = false;

        } else {
            setElementDiabled('checkbox', 'TMNL', 'N');
            setElementDiabled('checkbox', 'StorageDay', 'N');
            setElementDiabled('radio', 'CostCalcMethod', 'N');

            document.form.StorageDay.checked = true;
        }

        //				main_hidden.SetCellValue(1, 'tml_odck_flg', document.form.tml_odck_flg.value);

        if (formObj.tml_odck_flg.value == "N") {
            if (formObj.TMNL.checked == true && formObj.StorageDay.checked == true) {
                formObj.agmt_ftr_inv_tp_cd.value = "OTOS";
            } else if (formObj.TMNL.checked == true) {
                formObj.agmt_ftr_inv_tp_cd.value = "OT";
            } else if (formObj.StorageDay.checked == true) {
                formObj.agmt_ftr_inv_tp_cd.value = "OS";
            } else {
                formObj.agmt_ftr_inv_tp_cd.value = "";
            }

        } else {
            if (formObj.TMNL.checked == true) {
                formObj.agmt_ftr_inv_tp_cd.value = "OFON";
            } else {
                formObj.agmt_ftr_inv_tp_cd.value = "";
            }
        }
		
		var costCdFtrRmk = formObj.cost_cd_ftr_rmk.value;
        getAgmtCostCdList(1, 75, 150, costCdFtrRmk); // tes_getComboItem('agmt_lgs_cost_cd', 2, SEARCHLIST10, '', 'vndr_seq|yd_cd|agmt_ftr_inv_tp_cd|atb_dt', 'setAgmtCostCd');       

    }
}

/**
 * off on edit 여부 체크
 */
function chkEnableTmlOdckFlg() {
    if (sheetObjects[2].RowCount() > 0 || sheetObjects[3].RowCount() > 0 || sheetObjects[4].RowCount() > 0) { // 데이터가 하나도 없을때
        document.form.tml_odck_flg.disabled = true;

        if (sheetObjects[2].RowCount() == 0 && sheetObjects[3].RowCount() == 0 && sheetObjects[4].RowCount() == 1 && sheetObjects[4].GetCellValue(1, "lgs_cost_cd") == "TTL") {
            document.form.tml_odck_flg.disabled = false;
        }
    } else {
        document.form.tml_odck_flg.disabled = false;
    }
}

/**
 *  저장여부 체크
 */
function chkSaveTmlOdckFlg() {
    if (document.form.tml_odck_flg.value == main_hidden.GetCellValue(1, 'tml_odck_flg')) {
        return true;
    } else {
        return false;
    }
}



/**
 * main hidden sheet After completing sheet retrieve, functions.
 * @param {ibsheet}	main_hidden main hidden sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function main_hidden_OnSearchEnd(main_hidden, ErrMsg) {    // doActionMainHiddenSheet
    var formObj = document.form;
    if (main_hidden.RowCount() == 1) {
        if (formObj.inv_ofc_cd == undefined || formObj.inv_ofc_cd.value == null || formObj.inv_ofc_cd.value == '') {
            ComShowMessage('No Inv OFC data is found in the session');
            return false;
        }
        if (main_hidden.GetCellValue(1, 'inv_ofc_cd') == undefined || main_hidden.GetCellValue(1, 'inv_ofc_cd') == null || main_hidden.GetCellValue(1, 'inv_ofc_cd') == '') {
            ComShowMessage('No Inv OFC data is retrieved');
            return false;
        }
        if (main_hidden.GetCellValue(1, 'inv_ofc_cd') != formObj.inv_ofc_cd.value) {
            ComShowMessage("No authority to correct/delete the invoice - Invoice office mismatch!");
            return false;
        }

        if (main_hidden.GetCellValue(1, 'tml_inv_rjct_sts_cd') == "RJ") {
            ComShowMessage('This is Rejected Invoice.');
            return false;
        }

        if (main_hidden.GetCellValue(1, 'tml_inv_tp_cd') != 'OF') {
            setHeaderKeyValueReadonly('N');
            setSheetsEnable(-1, false);
            formObj.reset();

            if (main_hidden.GetCellValue(1, 'tml_inv_tp_cd') == 'TM') {
                ComShowMessage(ComGetMsg('TES23030', 'Terminal invoice'));
            } else if (main_hidden.GetCellValue(1, 'tml_inv_tp_cd') == 'ST') {
                ComShowMessage(ComGetMsg('TES23030', 'Storage invoice'));
            } else if (main_hidden.GetCellValue(1, 'tml_inv_tp_cd') == 'ON') {
                ComShowMessage(ComGetMsg('TES23030', 'On-dock invoice'));
            } else {
                ComShowMessage(ComGetMsg('TES21034'));
            }
            return;
        }
        if (main_hidden.GetCellValue(1, 'tml_inv_sts_cd') != undefined && main_hidden.GetCellValue(1, 'tml_inv_sts_cd') == 'C') {
            if (confirm(ComGetMsg('TES23039'))) {
                formObj.f_cmd.value = MULTI03;
                var param = main_hidden.GetSaveString();
                var savexml = sheetObjects[7].GetSaveData("ESD_TES_0004GS.do", param + '&' + tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
                sheetObjects[7].LoadSaveData(savexml, true);
                return false;
            } else {
                tes_new0004();
                return false;
            }
        } else if (main_hidden.GetCellValue(1, 'tml_inv_sts_cd') != undefined && main_hidden.GetCellValue(1, 'tml_inv_sts_cd') == 'A') {
            tes_new0004();
            ComShowMessage(ComGetMsg('TES24040'));
            return false;
        } else if (main_hidden.GetCellValue(1, 'tml_inv_sts_cd') != undefined && main_hidden.GetCellValue(1, 'tml_inv_sts_cd') == 'P') {
            tes_new0004();
            ComShowMessage(ComGetMsg('TES24041'));
            return false;
        } else if (main_hidden.GetCellValue(1, 'tml_inv_sts_cd') != undefined && main_hidden.GetCellValue(1, 'tml_inv_sts_cd') == 'R') {
            // pass
        } else {
            tes_new0004();
            ComShowMessage(ComGetMsg('TES40051'));
            return false;
        }

        if (main_hidden.GetCellValue(1, 'tml_inv_rjct_sts_cd') != undefined && main_hidden.GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'RJ') {
            if (confirm(ComGetMsg('TES23042'))) {
                formObj.f_cmd.value = MULTI04; // Setting 'NL' reject status.
                var param = main_hidden.GetSaveString();
                var savexml = sheetObjects[6].GetSaveData("ESD_TES_0004GS.do", param + '&' + tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
                sheetObjects[6].LoadSaveData(savexml, true);
                return false;
            } else {
                tes_new0004();
                return false;
            }
        }
        
        confirm_done = false;

        var tmp_vndr_seq = formObj.vndr_seq.value;
        var tmp_vndr_seq_hidden = formObj.vndr_seq_hidden.value;
        var tmp_is_valid_vndr_seq = formObj.is_valid_vndr_seq.value;
        var tmp_vndr_seq_nm = formObj.vndr_seq_nm.value;
        var tmp_inv_no = formObj.inv_no.value;

        formObj.reset();
        enableForm();
        setHeaderKeyValueReadonly('Y');
        save_conf_01 = true;

        //20150430 추가
        document.form.org_tml_odck_flg.value = main_hidden.GetCellValue(1, 'tml_odck_flg');
        document.form.tml_odck_flg.value = main_hidden.GetCellValue(1, 'tml_odck_flg');
        if (document.form.tml_odck_flg.value == "" || document.form.tml_odck_flg.value == undefined) {
            document.form.tml_odck_flg.value = 'N';
            document.form.org_tml_odck_flg.value = 'N';
        }

        if (document.form.tml_odck_flg.value == "Y") {
            setElementDiabled('checkbox', 'TMNL', 'N');
            setElementDiabled('checkbox', 'StorageDay', 'Y');
        }

        formObj.vndr_seq_hidden.value = tmp_vndr_seq_hidden;
        formObj.is_valid_vndr_seq.value = tmp_is_valid_vndr_seq;
        formObj.vndr_seq_nm.value = tmp_vndr_seq_nm;

        if (formObj.yd_cd.value != null && formObj.yd_cd.value != '') {            
	        var rtnVal = getYdCdCostCdList(); // tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');           
	        if(rtnVal.length > 0){
	        	checkValidYardCode(rtnVal);
	        }           
        }
        
        setHdSheet2Form();
        
        validateAgmtSts();
        var cost_calc_tmnl = false;
        var cost_calc_day = false;
        var cost_calc_pool = true;
        var curr_tab_idx = 0;
        if (formObj.TMNL.checked == true) {
            cost_calc_tmnl = true;
        } else {
            cost_calc_tmnl = false;
        }
        if (formObj.StorageDay.checked == true) {
            cost_calc_day = true;
        } else {
            cost_calc_day = false;
        }

        setSheetsEnable(-1, true);
        validateVndrSeq();
        try {
            for (var i = 0; i < formObj.elements.length; i++) {
                if (formObj.elements[i].name != null && formObj.elements[i].name != '' &&
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
        doActionIBSheetAllSheets(sheetObjects[0], formObj, IBSEARCH);
        init_Arr_sht_chk();
    } else if (main_hidden.RowCount() > 1) {
        ComShowMessage(ComGetMsg('TES24043'));
        tes_new0004();
        return false;
    } else if (main_hidden.RowCount() == 0) {
        if (!confirm(ComGetMsg('TES40031'))) {
            tes_new0004('Y');
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
    } else {
        // pass
    }
}

/**
 * After complete save, function.
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
        if (main_hidden.GetCellValue(1, 'tml_inv_tp_cd') != 'OF') {
            setHeaderKeyValueReadonly('N');
            setSheetsEnable(-1, false);
            formObj.reset();

            if (main_hidden.GetCellValue(1, 'tml_inv_tp_cd') == 'TM') {
                ComShowMessage(ComGetMsg('TES23030', 'Terminal invoice'));
            } else if (main_hidden.GetCellValue(1, 'tml_inv_tp_cd') == 'ST') {
                ComShowMessage(ComGetMsg('TES23030', 'Storage invoice'));
            } else if (main_hidden.GetCellValue(1, 'tml_inv_tp_cd') == 'ON') {
                ComShowMessage(ComGetMsg('TES23030', 'On-dock invoice'));
            } else {
                ComShowMessage(ComGetMsg('TES21034'));
            }
            return;
        }

        if (main_hidden.GetCellValue(1, 'tml_inv_sts_cd') != undefined && main_hidden.GetCellValue(1, 'tml_inv_sts_cd') == 'C') {
            if (confirm(ComGetMsg('TES23039'))) {
                formObj.f_cmd.value = MULTI03;
                var savexml = sheetObjects[7].GetSaveData("ESD_TES_0004GS.do", tesFrmQryStr(formObj, 'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
                sheetObjects[7].LoadSaveData(savexml, true);
                return; // false;
            } else {
                tes_new0004();
                return; // false;
            }
        } else {
            confirm_done = false;
            enableForm();
            setHeaderKeyValueReadonly('Y');
        }
        
        //20150430 추가
        document.form.org_tml_odck_flg.value = main_hidden.GetCellValue(1, 'tml_odck_flg');
        document.form.tml_odck_flg.value = main_hidden.GetCellValue(1, 'tml_odck_flg');
        if (document.form.tml_odck_flg.value == "" || document.form.tml_odck_flg.value == undefined) {
            document.form.tml_odck_flg.value = 'Y';
            document.form.org_tml_odck_flg.value = 'N';
        }

        if (document.form.tml_odck_flg.value == "Y") {
            setElementDiabled('checkbox', 'TMNL', 'N');
            setElementDiabled('checkbox', 'StorageDay', 'Y');
        }

        save_conf_01 = true;
        if (formObj.confirm_mode.value != undefined && formObj.confirm_mode.value == 'CONFIRM') {
            setHdSheet2Form('CONFIRM');
        } else {
            setHdSheet2Form('SAVE');
        }

        if (formObj.yd_cd.value != null && formObj.yd_cd.value != '') {
           	var rtnVal = getYdCdCostCdList(); // tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');           
	        if(rtnVal.length > 0){
	        	checkValidYardCode(rtnVal);
	        } 
        }
        validateAgmtCurrCD();
        validateAgmtSts();
        var cost_calc_tmnl = false;
        var cost_calc_day = false;
        var cost_calc_pool = true;
        var curr_tab_idx = 0;
        if (formObj.TMNL.checked == true) {
            cost_calc_tmnl = true;
        } else {
            cost_calc_tmnl = false;
        }
        if (formObj.StorageDay.checked == true) {
            cost_calc_day = true;
        } else {
            cost_calc_day = false;
        }
        setSheetsEnable(-1, true);
        tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
    } else if (main_hidden.RowCount() > 1) {
        ComShowMessage(ComGetMsg('TES24043'));
        tes_new0004();
        return false;
    } else {
        setHeaderKeyValueReadonly('N');
        setSheetsEnable(-1, false);
        // formObj.reset();
        ComShowMessage(ComGetMsg('TES21034'));
        return false;
    }
}

/**
 * reject hidden sheet After completing sheet retrieve, functions.
 * @param {ibsheet}	rjct_hidden reject hidden sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function rjct_hidden_OnSaveEnd(rjct_hidden, ErrMsg) {
    var formObj = document.form;
    if (rjct_hidden.RowCount() == 1) {
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
        tes_new0004();
        return false;
    } else {
        return false;
    }
}

/**
 * conf hidden sheet After completing sheet retrieve, functions.
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
            ComShowMessage(ComGetMsg('TES24044'));
            disableAftConf();
        } else {
            confirm_done = false;
            enableForm();
            retrieve();
        }
    } else if (conf_hidden.RowCount() > 1) {
        ComShowMessage(ComGetMsg('TES40046'));
        tes_new0004();
        return false;
    } else {
        return false;
    }
}

/**
 * Coding event for OnMouseMove.
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
 * Coding event for OnSearchEnd.
 * @param {sheet}	t1sheet1	Verification sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t1sheet1_OnSearchEnd(t1sheet1, ErrMsg) {
    setCoinShtStat();
    if (confirm_done) {
        disableSheetEditable(t1sheet1);
    }
    t1sheet1_SetChkBoxDisabled();
    chkEnableTmlOdckFlg();
}

/**
 * Coding event for OnSaveEnd.
 * @param {sheet}	t1sheet1	Verification sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t1sheet1_OnSaveEnd(t1sheet1, ErrMsg) {
    setCoinShtStat();
    if (confirm_done) {
        disableSheetEditable(t1sheet1);
    }
    t1sheet1_SetChkBoxDisabled();
    chkEnableTmlOdckFlg();
}

/**
 * Set check box disable.
 * @return
 */
function t1sheet1_SetChkBoxDisabled() {
    var DISABLE_YN;
    if (isAutoCalcDataExisting()) {
        DISABLE_YN = 'Y';
    } else {
        DISABLE_YN = 'N';
    }
    DISABLE_YN = 'N';
    if (sheetObjects[0].RowCount() > 0) {
        for (var i = 1; i <= sheetObjects[0].RowCount(); i++) {
            //					sheetObjects[0].SetCellValue(i, "cntr_rmk",ComToString( sheetObjects[0].GetCellValue(i, "cntr_rmk") ),0);
            // sheetObjects[0].CellEditable(i,'chk') = false;
            if (DISABLE_YN != null && DISABLE_YN == 'Y') {
                sheetObjects[0].SetCellEditable(i, 'chk', 0);
            } else {
                sheetObjects[0].SetCellEditable(i, 'chk', (sheetObjects[0].GetCellValue(i, 'modi_flg') == 'Y' ? 1 : 0));
            }
        }
    }
}

/**
 * Set check box disable.
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
            sheetObjects[1].SetCellValue(i, "cntr_rmk", ComToString(sheetObjects[1].GetCellValue(i, "cntr_rmk")), 0);
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
 * Checking exist calculated data.
 * @return
 */
function isAutoCalcDataExisting() {
    if (sheetObjects[2].RowCount() > 0) {
        for (var i = sheetObjects[2].HeaderRows(); i < (sheetObjects[2].HeaderRows() + sheetObjects[2].RowCount()); i++) {
            if (sheetObjects[2].GetCellValue(i, 'calc_tp_cd') == 'A' && sheetObjects[2].GetCellValue(i, 'ibflag') != 'D') {
                return true;
            }
        }
    }
    if (sheetObjects[3].RowCount() > 0) {
        for (var i = sheetObjects[3].HeaderRows(); i < (sheetObjects[3].HeaderRows() + sheetObjects[3].RowCount()); i++) {
            if (sheetObjects[3].GetCellValue(i, 'calc_tp_cd') == 'A' && sheetObjects[3].GetCellValue(i, 'ibflag') != 'D') {
                return true;
            }
        }
    }
    return false;
}

/**
 * Checking exist calculated data.
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
    if (sheetObjects[3].RowCount() > 0) {
        for (var i = sheetObjects[3].HeaderRows(); i < (sheetObjects[3].HeaderRows() + sheetObjects[3].RowCount()); i++) {
            if (sheetObjects[3].GetCellValue(i, 'calc_tp_cd') == 'A' && sheetObjects[3].GetCellValue(i, 'ibflag') != 'R') {
                return true;
            }
        }
    }
    return false;
}

/**
 * Auto calculate or not
 * @param {sheet}	sheetObj	ibsheet
 * @return
 */
function isAutoCalcDataMod(sheetObj) {
    if (sheetObjects[2].RowCount() > 0) {
        for (var i = sheetObjects[2].HeaderRows(); i < (sheetObjects[2].HeaderRows() + sheetObjects[2].RowCount()); i++) {
            if ( // sheetObj.GetCellValue(i,'ibflag')!='I' ||
                (sheetObjects[2].GetCellValue(i, "tml_so_dtl_seq") != null && sheetObjects[2].GetCellValue(i, "tml_so_dtl_seq") != '' && parseInt(
                    sheetObjects[2].GetCellValue(i, "tml_so_dtl_seq"), 10) > 0)) {
                return true;
            }
        }
    }
    if (sheetObjects[3].RowCount() > 0) {
        for (var i = sheetObjects[3].HeaderRows(); i < (sheetObjects[3].HeaderRows() + sheetObjects[3].RowCount()); i++) {
            if ( // sheetObj.GetCellValue(i,'ibflag')!='I' ||
                (sheetObjects[3].GetCellValue(i, "tml_so_dtl_seq") != null && sheetObjects[3].GetCellValue(i, "tml_so_dtl_seq") != '' && parseInt(
                    sheetObjects[3].GetCellValue(i, "tml_so_dtl_seq"), 10) > 0)) {
                return true;
            }
        }
    }
    return false;
}

/**
 * Checking modify or not and deleting data.
 * @param {sheet}	t1sheet1	Verification sheet
 * @param {int}		row			selected row
 * @param {int}		col			selected col
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
 * Coding event for OnSearchEnd.
 * @param {sheet}	t2sheet1	Discrepancy sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t2sheet1_OnSearchEnd(t2sheet1, ErrMsg) {
    if (confirm_done) {
        disableSheetEditable(t2sheet1);
        return true;
    }
    // t2sheet1.ColumnSort("dscr_ind_cd|cntr_tpsz_cd|cntr_sty_cd","ASC");
    t2sheet1_SetChkBoxDisabled();
    t2sheet1_ChkSrc();
    chkEnableTmlOdckFlg();
}

/**
 * Coding event for OnSaveEnd.
 * @param {sheet}	t2sheet1	Discrepancy sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t2sheet1_OnSaveEnd(t2sheet1, ErrMsg) {
    if (confirm_done) {
        disableSheetEditable(t2sheet1);
    }
    // t2sheet1.ColumnSort("dscr_ind_cd|cntr_tpsz_cd|cntr_sty_cd","ASC");
    t2sheet1_SetChkBoxDisabled();
    t2sheet1_ChkSrc();
    chkEnableTmlOdckFlg();
}

/**
 * Setting Gate In, Out colum attribute.
 * @return
 */
function t2sheet1_ChkSrc() {
    var formObj = document.form;
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
            if (formObj.CostCalcMethod2.checked == false) { //2016-01-12 SP일 경우 색상 변경 삭제 요청
                sheetObjects[1].SetCellBackColor(i, 'mvmt_gate_out_dt', "#FF9999");
            }
            
        } else if (sDscrIndCd == 'NH') {
            sheetObjects[1].SetCellBackColor(i, 'cntr_no', "#FF9999");
            sheetObjects[1].SetCellBackColor(i, 'cntr_tpsz_cd', "#FF9999");
            
        } else if (sDscrIndCd == 'DB') {
            sheetObjects[1].SetCellBackColor(i, 'cntr_no', "#FF9999");
            
        } else if (sDscrIndCd == 'AM') {
            sheetObjects[1].SetCellBackColor(i, 'cntr_no', "#FF9999");
            sheetObjects[1].SetCellBackColor(i, 'mvmt_gate_in_dt', "#FF9999");
            if (formObj.CostCalcMethod2.checked == false) { //2016-01-12 SP일 경우 색상 변경 삭제 요청
                sheetObjects[1].SetCellBackColor(i, 'mvmt_gate_out_dt', "#FF9999");
            }
        }
    }
}

/**
 * Coding event for OnDblclick.
 * @param {sheet}	sheetObj	Discrepancy sheet
 * @param {int}		row			selected row
 * @param {int}		col			selected col
 * @return
 */
function t2sheet1_OnDblClick(sheetObj, row, col) {
    if (sheetObj.ColSaveName(col) == "dscr_ind_cd") {
        var count = 0;
        var chkrow = "";
        while (true) {
            checkrow = sheetObj.FindText("dscr_ind_cd", sheetObj.GetCellText(row, col), count, -1);
            if (checkrow == "-1")
                break;
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
 * Checking delete or not at all data.
 * @param Index_Code
 * @param Text
 * @return
 */
function curr_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
    // ComShowMessage('curr_cd_OnChange:'+comboObjects[0].Code);
    var formObj = document.form;
    var main_sheet_obj = sheetObjects[5];
    if (main_sheet_obj.RowCount() == 1) {
        if ((main_sheet_obj.GetCellValue(1, 'curr_cd') != comboObjects[0].GetSelectCode())
            //							|| (curr_cd_tmp.value != undefined 
            //									&& formObj.curr_cd_tmp.value != null
            //									&& formObj.curr_cd_tmp.value != '' 
            //										&& formObj.curr_cd_tmp.value != comboObjects[0].GetSelectCode())
        ) {
            resetInputValue();
        }
        if (hasAllCalcData()) {
            if (formObj.curr_cd_tmp.value != comboObjects[0].GetSelectCode()) {
                if (!confirm('Currency code has been changed. ' + ComGetMsg('TES40039'))) {
                    comboObjects[0].SetSelectText(formObj.curr_cd_tmp.value);
                    comboObjects[0].SetSelectCode(formObj.curr_cd_tmp.value);
                } else {
                    removeCalcDataAll();
                    resetSheetDataProperty(comboObjects[0].GetSelectCode());
                }
            }
        }
        //formObj.curr_cd_tmp.value=comboObjects[0].GetSelectCode();
    }
}

/**
 * Initialize [Inv Amt], [TAX]
 * @return
 */
function resetInputValue() {
    var formObj = document.form;
    formObj.ttl_inv_amt.value = '';
    formObj.vat_amt.value = '';
}

/**
 * Setting sheet data attribute.
 * @param {string}		CURR_CD		Currency code
 * @return
 */
function resetSheetDataProperty(CURR_CD) {
    if (CURR_CD != undefined && tes_isNoDecimalPointCurrCD(CURR_CD)) {
        var cols = [{ Type: "Int", Hidden: 0, Width: 70, Align: "Right", ColMerge: 0, SaveName: "ctrt_rt", KeyField: 0, CalcLogic: "", Format: "Integer", PointCount: 0, UpdateEdit: 0, InsertEdit: 0 }, 
        			{ Type: "Int", Hidden: 0, Width: 70, Align: "Right", ColMerge: 0, SaveName: "inv_amt", KeyField: 0, CalcLogic: "", Format: "Integer", PointCount: 0, UpdateEdit: 0, InsertEdit: 0 }];
        sheetObjects[2].InitColumns(cols);
        sheetObjects[3].InitColumns(cols);
        sheetObjects[4].InitColumns(cols);
        //				sheetObjects[2].InitDataProperty(0, 9, dtData, 60, daRight, false, "ctrt_rt", false, "", dfInteger, 0, false, false);
        //				sheetObjects[2].InitDataProperty(0, 12, dtData, 60, daRight, false, "inv_amt", false, "", dfInteger, 0, false, false);
        //				sheetObjects[3].InitDataProperty(0, 14, dtData, 60, daRight, false, "ctrt_rt", false, "", dfInteger, 0, false, false);
        //				sheetObjects[3].InitDataProperty(0, 17, dtData, 60, daRight, false, "inv_amt", false, "", dfInteger, 0, false, false);
        //				sheetObjects[4].InitDataProperty(0, 10, dtData, 60, daRight, false, "ctrt_rt", false, "", dfInteger, 0, false, false);
        //				sheetObjects[4].InitDataProperty(0, 13, dtData, 60, daRight, false, "inv_amt", false, "", dfInteger, 0, false, false);
    } else {
        var cols = [{ Type: "Float", Hidden: 0, Width: 70, Align: "Right", ColMerge: 0, SaveName: "ctrt_rt", KeyField: 0, CalcLogic: "", Format: "Float", PointCount: 2, UpdateEdit: 0, InsertEdit: 0 }, 
        			{ Type: "Float", Hidden: 0, Width: 70, Align: "Right", ColMerge: 0, SaveName: "inv_amt", KeyField: 0, CalcLogic: "", Format: "Float", PointCount: 2, UpdateEdit: 0, InsertEdit: 0 }];
        sheetObjects[2].InitColumns(cols);
        sheetObjects[3].InitColumns(cols);
        sheetObjects[4].InitColumns(cols);
        //				sheetObjects[2].InitDataProperty(0, 9, dtData, 60, daRight, false, "ctrt_rt", false, "", dfFloat, 2, false, false);
        //				sheetObjects[2].InitDataProperty(0, 12, dtData, 60, daRight, false, "inv_amt", false, "", dfFloat, 2, false, false);
        //				sheetObjects[3].InitDataProperty(0, 14, dtData, 60, daRight, false, "ctrt_rt", false, "", dfFloat, 2, false, false);
        //				sheetObjects[3].InitDataProperty(0, 17, dtData, 60, daRight, false, "inv_amt", false, "", dfFloat, 2, false, false);
        //				sheetObjects[4].InitDataProperty(0, 10, dtData, 60, daRight, false, "ctrt_rt", false, "", dfFloat, 2, false, false);
        //				sheetObjects[4].InitDataProperty(0, 13, dtData, 60, daRight, false, "inv_amt", false, "", dfFloat, 2, false, false);
    }
}

/**
 * Coding event for OnChange
 * @param {sheet}	t3sheet1	Cost Calc.(TMNL) sheet
 * @param {int}		Row			The row's Row Index
 * @param {int}		Col			The row's Column Index
 * @param {string}	Value
 * @return
 */
function t3sheet1_OnChange(t3sheet1, Row, Col, Value) {
    var formObj = document.form;
    var sName = t3sheet1.ColSaveName(Col);
    var tmp;
    if (sName == "inv_amt") {
        document.form.t3sht_tot_inv_amt.value = getShtTotCalcAmt(t3sheet1, 'inv_amt');
    }
    if (sName == "rvis_vol_qty" || sName == "calc_vol_qty" || sName == "ctrt_rt" || sName == "inv_xch_rt" || sName == "vol_tr_ut_cd") {
        t3sheet1.SetCellValue(Row, 'inv_xch_rt', Math.abs(t3sheet1.GetCellValue(Row, 'inv_xch_rt')));
        if (t3sheet1.GetCellValue(Row, 'inv_xch_rt') > 0) {
            //					t3sheet1.SetCellBackColor(Row, 'inv_xch_rt',"#000000");
        }
        t3sheet1_RecalcCalcAmt(t3sheet1, Row);
    }

    // CHM-201432447 [TES] Semi-updated의 revised vol 입력기능 보완 2014-12-09
    if (sName == 'cntr_tpsz_cd' && t3sheet1.GetCellValue(Row, 'cntr_tpsz_cd') != '' && CostCdValidForCalcTpSz(t3sheet1.GetCellValue(Row, 'lgs_cost_cd'), t3sheet1.GetCellValue(Row, 'cntr_tpsz_cd')) == false
        /*&& (t3sheet1.CellValue(Row,'vol_tr_ut_cd')=="C" || t3sheet1.CellValue(Row,'vol_tr_ut_cd')=="")*/
    ) {
        ComShowMessage("Reefer EQ should be selected fot your cost code");
        t3sheet1.SetCellValue(Row, 'cntr_tpsz_cd', '');
    }
}

/**
 * Set amount
 * @param {sheet}	t3sheet1	Cost Calc.(TMNL) sheet
 * @param {int}		Row			The cell's Row Index	
 * @return
 */
function t3sheet1_RecalcCalcAmt(sheetObj, Row) {
    var sCurrCd = document.form.curr_cd.value;
        
    if (sheetObj.RowCount() > 0) {
        if (sheetObj.GetCellValue(Row, 'calc_tp_cd') == 'A') {
            if (sheetObj.GetCellValue(Row, 'rvis_vol_qty') != null && sheetObj.GetCellValue(Row, 'rvis_vol_qty') != '' && !isNaN(sheetObj.GetCellValue(Row, 'rvis_vol_qty')) && sheetObj.GetCellValue(Row, 'ctrt_rt') != null && sheetObj.GetCellValue(Row, 'ctrt_rt') != '' && !isNaN(sheetObj.GetCellValue(Row, 'ctrt_rt'))) {
            	var nInvAmt = (parseInt(sheetObj.GetCellValue(Row, 'rvis_vol_qty'), 10)) * parseFloat(sheetObj.GetCellValue(Row, 'ctrt_rt'));
        
		        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
		        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
		        }
		        nInvAmt = Math.round(nInvAmt*100)/100; //exchange rate 계산후 소수점 2자리로 화면과 똑같이 DB에도 저장하기 위해서 수정함.
                sheetObj.SetCellValue(Row, 'inv_amt', nInvAmt);
            }
            
            if (sheetObj.GetCellValue(Row, 'curr_cd') != undefined && sheetObj.GetCellValue(Row, 'curr_cd') != null && sheetObj.GetCellValue(Row, 'curr_cd') != '' && curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' && curr_cd.GetSelectCode() != sheetObj.GetCellValue(Row, 'curr_cd') && !isNaN(sheetObj.GetCellValue(Row, 'inv_xch_rt')) && parseFloat(sheetObj.GetCellValue(Row, 'inv_xch_rt')) > 0) {
                var nInvAmt = parseFloat(sheetObj.GetCellValue(Row, 'inv_amt')) * parseFloat(sheetObj.GetCellValue(Row, 'inv_xch_rt'));
        
		        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
		        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
		        }
		        nInvAmt = Math.round(nInvAmt*100)/100; //exchange rate 계산후 소수점 2자리로 화면과 똑같이 DB에도 저장하기 위해서 수정함.
                sheetObj.SetCellValue(Row, 'inv_amt', nInvAmt);
            }
        } else if (sheetObj.GetCellValue(Row, 'calc_tp_cd') == 'M' || sheetObj.GetCellValue(Row, 'calc_tp_cd') == 'S') {
            //if (sheetObj.GetCellValue(Row, 'calc_vol_qty') != null && sheetObj.GetCellValue(Row, 'calc_vol_qty') != '' && !isNaN(sheetObj.GetCellValue(Row, 'calc_vol_qty')) && sheetObj.GetCellValue(Row, 'ctrt_rt') != null && sheetObj.GetCellValue(Row, 'ctrt_rt') != '' && !isNaN(sheetObj.GetCellValue(Row, 'ctrt_rt'))) {
                if (sheetObj.GetCellValue(Row, 'rvis_vol_qty') != null && sheetObj.GetCellValue(Row, 'rvis_vol_qty') != '' && !isNaN(sheetObj.GetCellValue(Row, 'rvis_vol_qty')) && sheetObj.GetCellValue(Row, 'rvis_vol_qty') > 0) {
                    sheetObj.SetCellValue(Row, 'calc_vol_qty', sheetObj.GetCellValue(Row, 'rvis_vol_qty'));
                }
                var nInvAmt = (parseInt(sheetObj.GetCellValue(Row, 'calc_vol_qty'), 10) * parseFloat(sheetObj.GetCellValue(Row, 'ctrt_rt')));
        
		        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
		        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
		        }
		        nInvAmt = Math.round(nInvAmt*100)/100; //exchange rate 계산후 소수점 2자리로 화면과 똑같이 DB에도 저장하기 위해서 수정함.
                sheetObj.SetCellValue(Row, 'inv_amt', nInvAmt);
            //}
            //if (curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' && !isNaN(sheetObj.GetCellValue(Row, 'inv_xch_rt')) && parseFloat(sheetObj.GetCellValue(Row, 'inv_xch_rt')) > 0) {
                var nInvAmt = parseFloat(sheetObj.GetCellValue(Row, 'inv_amt')) * parseFloat(sheetObj.GetCellValue(Row, 'inv_xch_rt'));
        
		        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
		        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
		        }
		        nInvAmt = Math.round(nInvAmt*100)/100; //exchange rate 계산후 소수점 2자리로 화면과 똑같이 DB에도 저장하기 위해서 수정함.
                sheetObj.SetCellValue(Row, 'inv_amt', nInvAmt);
            //}
        }
        
        if ((sheetObj.GetCellValue(Row, 'cntr_tpsz_cd') != undefined && sheetObj.GetCellValue(Row, 'cntr_tpsz_cd') != null && sheetObj.GetCellValue(Row, 'cntr_tpsz_cd') != '') && (sheetObj.GetCellValue(Row, 'vol_tr_ut_cd') != undefined && sheetObj.GetCellValue(Row, 'vol_tr_ut_cd') != null && sheetObj.GetCellValue(Row, 'vol_tr_ut_cd') != '')) {
        	var nInvAmt = sheetObj.GetCellValue(Row, 'inv_amt') * tes_getTEUconv(sheetObj.GetCellValue(Row, 'vol_tr_ut_cd'), sheetObj.GetCellValue(Row, 'cntr_tpsz_cd'));
        
	        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
	        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
	        }
	        nInvAmt = Math.round(nInvAmt*100)/100; //exchange rate 계산후 소수점 2자리로 화면과 똑같이 DB에도 저장하기 위해서 수정함.
            sheetObj.SetCellValue(Row, 'inv_amt', nInvAmt);
        }
    }
}

/**
 * Coding event for OnClick.
 * @param {sheet}	t3sheet1	Cost Calc.(TMNL) sheet
 * @param {int}		Row			The cell's Row Index
 * @param {int}		Col			The cell's Column Index
 * @param {string}	Value
 * @return
 */
function t3sheet1_OnClick(t3sheet1, Row, Col, Value) {
    if (t3sheet1.ColSaveName(Col) == 'calc_rmk') {
        // ComShowMessage(' cell value:' + t3sheet1.GetCellValue(Row,'ctrt_rt') + '
        // / ' + t3sheet1.GetCellValue(Row,'inv_amt') );
    }
}

/**
 * Coding event for OnSaveEnd.
 * @param {sheet}	t1sheet1	Cost Calc.(TMNL) sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t3sheet1_OnSaveEnd(t3sheet1, ErrMsg) {
    if (confirm_done) {
        disableSheetEditable(t3sheet1);
    }
    init_Arr_sht_chk();
    var formObj = document.form;
    if (formObj.calcTerminalComboItems.value == null || doSepRemove(formObj.calcTerminalComboItems.value, ' ') == '') {
        // getCalcTerminalManualCostCode();
    }
    if (t3sheet1.RowCount() > 0) {
        t1sheet1_SetChkBoxDisabled();
        t2sheet1_SetChkBoxDisabled();
        document.form.t3sht_tot_inv_amt.value = getShtTotCalcAmt(t3sheet1, 'inv_amt');
        setElementDiabled('checkbox', 'TMNL', 'Y');
        setElementDiabled('radio', 'CostCalcMethod', 'Y');
        for (var i = 1; i <= t3sheet1.RowCount(); i++) {
            if (t3sheet1.GetCellValue(i, "calc_tp_cd") == "A") {
                if (t3sheet1.GetCellValue(i, "curr_cd") != undefined && t3sheet1.GetCellValue(i, "curr_cd") != null && t3sheet1.GetCellValue(i, "curr_cd") != '' && curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' && t3sheet1.GetCellValue(i, "curr_cd") != curr_cd.GetSelectCode()) {
                    setShtCellsEditable(t3sheet1, i, 'inv_xch_rt', 'Y', 'EXCEPTION');
                }
            } else if (t3sheet1.GetCellValue(i, "calc_tp_cd") == "M") {
                setShtCellsEditable(t3sheet1, i, 'lgs_cost_cd|cntr_tpsz_cd|rev_yrmon|io_bnd_cd|calc_vol_qty|inv_amt|inv_xch_rt', 'Y');

            } else if (t3sheet1.GetCellValue(i, "calc_tp_cd") == "S") {
                // 양부장님 요청 semi updated 추가)
                setShtCellsEditable(t3sheet1, i, 'lgs_cost_cd|cntr_tpsz_cd|rev_yrmon|io_bnd_cd|calc_vol_qty|inv_amt|inv_xch_rt', 'Y', 'EXCEPTION');
            }
        }
        setCalcTerminalManualCostCode(t3sheet1);
        checkTPBdataEditable('3', t3sheet1);
    } else {
        document.form.t3sht_tot_inv_amt.value = 0;
        setElementDiabled('checkbox', 'TMNL', 'N');
        // setElementDiabled('radio','CostCalcMethod','Y');
    }

    chkEnableTmlOdckFlg();
}

/**
 * Comparing with currency code and agreement's currency.
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
 * Coding event for OnSearchEnd.
 * @param {sheet}	t3sheet1	Cost Calc.(TMNL) sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t3sheet1_OnSearchEnd(t3sheet1, ErrMsg) {
    if (confirm_done) {
        disableSheetEditable(t3sheet1);
    }
    init_Arr_sht_chk();
    var formObj = document.form;
    if (formObj.calcTerminalComboItems.value == null || doSepRemove(formObj.calcTerminalComboItems.value, ' ') == '') {
        // getCalcTerminalManualCostCode();
    }
    if (t3sheet1.RowCount() > 0) {
        // t1sheet1_SetChkBoxDisabled();
        // t2sheet1_SetChkBoxDisabled();
        document.form.t3sht_tot_inv_amt.value = tes_chkAmtFmt(getShtTotCalcAmt(t3sheet1, 'inv_amt'));
        setElementDiabled('checkbox', 'TMNL', 'Y');
        setElementDiabled('radio', 'CostCalcMethod', 'Y');
        for (var i = 1; i <= t3sheet1.RowCount(); i++) {
            if (t3sheet1.GetCellValue(i, "calc_tp_cd") == "A") {
                if (t3sheet1.GetCellValue(i, "curr_cd") != undefined && t3sheet1.GetCellValue(i, "curr_cd") != null && t3sheet1.GetCellValue(i, "curr_cd") != '' && curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' && t3sheet1.GetCellValue(i, "curr_cd") != curr_cd.GetSelectCode()) {
                    setShtCellsEditable(t3sheet1, i, 'inv_xch_rt', 'Y', 'EXCEPTION');
                }
                t3sheet1.SetCellValue(i, "calc_rmk", ComToString(t3sheet1.GetCellValue(i, "calc_rmk")), 0);

            } else if (t3sheet1.GetCellValue(i, "calc_tp_cd") == "M") {
                setShtCellsEditable(t3sheet1, i, 'lgs_cost_cd|cntr_tpsz_cd|rev_yrmon|io_bnd_cd|calc_vol_qty|vol_tr_ut_cd|ctrt_rt|inv_amt|inv_xch_rt|rc_flg|tml_trns_mod_cd', 'Y');
                t3sheet1.SetCellValue(i, "calc_rmk", ComToString(t3sheet1.GetCellValue(i, "calc_rmk")), 0);

            } else if (t3sheet1.GetCellValue(i, "calc_tp_cd") == "S") {
                setShtCellsEditable(t3sheet1, i, 'cntr_tpsz_cd|rev_yrmon|io_bnd_cd|calc_vol_qty|vol_tr_ut_cd|ctrt_rt|inv_amt|inv_xch_rt|rc_flg|tml_trns_mod_cd', 'Y', 'EXCEPTION');
                setShtCellsEditable(t3sheet1, i, 'ctrt_rt|calc_vol_qty|inv_xch_rt', 'N', 'EXCEPTION');
                t3sheet1.SetCellValue(i, "calc_rmk", ComToString(t3sheet1.GetCellValue(i, "calc_rmk")), 0);

            }
        }
        setCalcTerminalManualCostCode(t3sheet1);
        checkTPBdataEditable('3', t3sheet1);
    } else {
        document.form.t3sht_tot_inv_amt.value = 0;
        setElementDiabled('checkbox', 'TMNL', 'N');
        // setElementDiabled('radio','CostCalcMethod','Y');
    }

    chkEnableTmlOdckFlg();
    validateYardCode();
}

/**
 * Opening Revised Volumn input screen.
 * @param {sheet}	sheetObj	Cost Calc.(TMNL) sheet
 * @param {int}		row			selected row
 * @param {int}		col			selected col
 * @return
 */
function t3sheet1_OnPopupClick(sheetObj, row, col) {
    var formObj = document.form;
    if (sheetObj.ColSaveName(col) == "rvis_vol_qty") {
        if (sheetObj.GetCellValue(row, 'calc_tp_cd') == 'M' && (sheetObj.GetCellValue(row, 'tml_so_dtl_seq') == '' || sheetObj.GetCellValue(row, 'tml_so_dtl_seq') == null || sheetObj.GetCellValue(row, 'tml_so_dtl_seq') == 0)) {
            ComShowMessage('You have to Revised Vol. Input after save calculated result.');
            return false;
        }
        if (formObj.CostCalcMethod[0].checked == true) { // TP
            if (sheetObj.GetCellValue(row, 'lgs_cost_cd') == undefined || sheetObj.GetCellValue(row, 'lgs_cost_cd') == null || doSepRemove(sheetObj.GetCellValue(row, 'lgs_cost_cd'), ' ') == '') {
                ComShowMessage(ComGetMsg('TES23045'));
                return false;
            }
            var url_str = 'ESD_TES_9030Popup.screen';
            url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
            url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
            url_str = url_str + '&tml_so_dtl_seq=' + sheetObj.GetCellValue(row, 'tml_so_dtl_seq');
            url_str = url_str + '&calc_tp_cd=' + sheetObj.GetCellValue(row, 'calc_tp_cd');
            url_str = url_str + '&param_lgs_cost_cd=' + sheetObj.GetCellValue(row, 'lgs_cost_cd');
            url_str = url_str + '&param_cntr_tpsz_cd=' + sheetObj.GetCellValue(row, 'cntr_tpsz_cd');
            url_str = url_str + '&param_dcgo_clss_cd=' + sheetObj.GetCellValue(row, 'dcgo_ind_cd');
            url_str = url_str + '&param_rc_flg=' + sheetObj.GetCellValue(row, 'rc_flg');
            url_str = url_str + '&ot_a_lgs_cost_cd=' + OT_A_LGS_COST_CD;
            url_str = url_str + '&calcTerminalComboItems=' + formObj.calcTerminalComboItems.value;
            url_str = url_str + '&cntr_tpsz_cd=' + CNTR_TPSZ_CD;
            url_str = url_str + '&cntr_sty_cdCode=' + cntr_sty_cdCode;
            url_str = url_str + '&sheet_curr_row=' + row;
            window.ComOpenWindow(url_str, window, "dialogWidth:650px;dialogHeight:380px;help:no;status:no;resizable:yes;", true);
        } else if (formObj.CostCalcMethod[1].checked == true || formObj.CostCalcMethod[2].checked) { // Separate   //20150617 Gates추가
            if (sheetObj.GetCellValue(row, 'lgs_cost_cd') == undefined || sheetObj.GetCellValue(row, 'lgs_cost_cd') == null || doSepRemove(sheetObj.GetCellValue(row, 'lgs_cost_cd'), ' ') == '') {
                ComShowMessage(ComGetMsg('TES23045'));
                return false;
            }
            var url_str = 'ESD_TES_9240Popup.screen';
            url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
            url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
            url_str = url_str + '&tml_so_dtl_seq=' + sheetObj.GetCellValue(row, 'tml_so_dtl_seq');
            url_str = url_str + '&calc_tp_cd=' + sheetObj.GetCellValue(row, 'calc_tp_cd');
            url_str = url_str + '&param_lgs_cost_cd=' + sheetObj.GetCellValue(row, 'lgs_cost_cd');
            url_str = url_str + '&param_cntr_tpsz_cd=' + sheetObj.GetCellValue(row, 'cntr_tpsz_cd');
            url_str = url_str + '&param_dcgo_clss_cd=' + sheetObj.GetCellValue(row, 'dcgo_ind_cd');
            url_str = url_str + '&param_rc_flg=' + sheetObj.GetCellValue(row, 'rc_flg');
            url_str = url_str + '&ot_a_lgs_cost_cd=' + OT_A_LGS_COST_CD;
            url_str = url_str + '&calcTerminalComboItems=' + formObj.calcTerminalComboItems.value;
            url_str = url_str + '&cntr_tpsz_cd=' + CNTR_TPSZ_CD;
            url_str = url_str + '&cntr_sty_cdCode=' + cntr_sty_cdCode;
            url_str = url_str + '&sheet_curr_row=' + row;
            url_str = url_str + '&fm_prd_dt=' + formObj.fm_prd_dt.value;
            ComOpenWindow(url_str, window, "dialogWidth:650px; dialogHeight:430px; help:no; status:no; resizable:yes;", true);
        }
    } else if (sheetObj.ColSaveName(col) == "n3pty_flg") {
        if (sheetObj.GetCellValue(row, 'tml_so_dtl_seq') == '' || sheetObj.GetCellValue(row, 'tml_so_dtl_seq') == null || sheetObj.GetCellValue(row, 'tml_so_dtl_seq') == 0) {
            ComShowMessage('You have to 3rd party Input after save calculated result.');
            return false;
        }
        if (sheetObj.GetCellValue(row, 'calc_cost_grp_cd') == null || doSepRemove(sheetObj.GetCellValue(row, 'calc_cost_grp_cd'), ' ') == '') {
            ComShowMessage(ComGetMsg('TES24046'));
            return false;
        }
        if (curr_cd.GetSelectCode() == null || doSepRemove(curr_cd.GetSelectCode(), ' ') == '') {
            ComShowMessage(ComGetMsg('TES40041', 'Currency code'));
            return false;
        }
        if (sheetObj.GetCellValue(row, 'lgs_cost_cd') == undefined || sheetObj.GetCellValue(row, 'lgs_cost_cd') == null || doSepRemove(sheetObj.GetCellValue(row, 'lgs_cost_cd'), ' ') == '') {
            ComShowMessage(ComGetMsg('TES23045'));
            return false;
        }
        if (sheetObj.GetCellValue(row, 'inv_amt') != undefined && sheetObj.GetCellValue(row, 'inv_amt') != null && sheetObj.GetCellValue(row, 'inv_amt') < 0) {
            return false;
        }
        var url_str = 'ESD_TES_9233Popup.screen';
        url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
        url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
        url_str = url_str + '&tml_so_dtl_seq=' + sheetObj.GetCellValue(row, 'tml_so_dtl_seq');
        url_str = url_str + '&tml_inv_tp_cd=' + formObj.tml_inv_tp_cd.value;
        url_str = url_str + '&calc_cost_grp_cd=' + sheetObj.GetCellValue(row, 'calc_cost_grp_cd');
        url_str = url_str + '&calc_tp_cd=' + sheetObj.GetCellValue(row, 'calc_tp_cd');
        url_str = url_str + '&vndr_seq=' + formObj.vndr_seq.value;
        url_str = url_str + '&inv_no=' + formObj.inv_no.value;
        url_str = url_str + '&inv_ofc_cd=' + formObj.inv_ofc_cd.value;
        url_str = url_str + '&param_lgs_cost_cd=' + sheetObj.GetCellValue(row, 'lgs_cost_cd');
        url_str = url_str + '&param_cntr_tpsz_cd=' + sheetObj.GetCellValue(row, 'cntr_tpsz_cd');
        url_str = url_str + '&curr_cd=' + curr_cd.GetSelectCode();
        url_str = url_str + '&inv_amt=' + sheetObj.GetCellValue(row, 'inv_amt');
        url_str = url_str + '&param_rc_flg=' + sheetObj.GetCellValue(row, 'rc_flg');
        url_str = url_str + '&sheet_curr_row=' + row;
        url_str = url_str + '&sheet_idx=3';
        url_str = url_str + '&yd_cd=' + formObj.yd_cd.value;
        url_str = url_str + '&ctrt_rt=' + sheetObj.GetCellValue(row, 'ctrt_rt');
        url_str = url_str + '&inv_xch_rt=' + sheetObj.GetCellValue(row, 'inv_xch_rt');
        url_str = url_str + '&rvis_vol_qty=' + sheetObj.GetCellValue(row, 'rvis_vol_qty');
        //window.ComOpenWindow(url_str,  window,"dialogWidth:710px; dialogHeight:440px; help:no; status:no; resizable:yes;",  true);
        ComOpenWindow(url_str, window, "help:no;status:no;resizable:yes;dialogWidth:" + 820 + "px;dialogHeight:" + 700 + "px", true);
    }
}

/**
 * Opening 3rd Party Interface input screen.
 * @param {sheet}	sheetObj	Cost Calc.(SR by FD) sheet
 * @param {int}		row			selected row
 * @param {int}		col			selected col
 * @return
 */
function t4sheet1_OnPopupClick(sheetObj, row, col) {
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
        if (sheetObj.GetCellValue(row, 'lgs_cost_cd') == undefined || sheetObj.GetCellValue(row, 'lgs_cost_cd') == null || doSepRemove(sheetObj.GetCellValue(row, 'lgs_cost_cd'), ' ') == '') {
            ComShowMessage(ComGetMsg('TES23045'));
            return false;
        }
        if (curr_cd.GetSelectCode() == null || doSepRemove(curr_cd.GetSelectCode(), ' ') == '') {
            ComShowMessage(ComGetMsg('TES40041', 'Currency code'));
            return false;
        }
        if ((sheetObj.GetCellValue(row, 'calc_tp_cd') != null && sheetObj.GetCellValue(row, 'calc_tp_cd') == 'A') && (sheetObj.GetCellValue(row, 'cntr_no') == undefined || sheetObj.GetCellValue(row, 'cntr_no') == null || doSepRemove(sheetObj.GetCellValue(row, 'cntr_no'), ' ') == '')) {
            ComShowMessage(ComGetMsg('TES23047'));
            return false;
        }
        if (sheetObj.GetCellValue(row, 'inv_amt') != undefined && sheetObj.GetCellValue(row, 'inv_amt') != null && sheetObj.GetCellValue(row, 'inv_amt') < 0) {
            return false;
        }
        var url_str = 'ESD_TES_9233Popup.screen';
        url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
        url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
        url_str = url_str + '&tml_so_dtl_seq=' + sheetObj.GetCellValue(row, 'tml_so_dtl_seq');
        url_str = url_str + '&tml_inv_tp_cd=' + formObj.tml_inv_tp_cd.value;
        url_str = url_str + '&calc_cost_grp_cd=' + sheetObj.GetCellValue(row, 'calc_cost_grp_cd');
        url_str = url_str + '&calc_tp_cd=' + sheetObj.GetCellValue(row, 'calc_tp_cd');
        url_str = url_str + '&vndr_seq=' + formObj.vndr_seq.value;
        url_str = url_str + '&inv_no=' + formObj.inv_no.value;
        url_str = url_str + '&param_lgs_cost_cd=' + sheetObj.GetCellValue(row, 'lgs_cost_cd');
        url_str = url_str + '&param_cntr_tpsz_cd=' + sheetObj.GetCellValue(row, 'cntr_tpsz_cd');
        url_str = url_str + '&curr_cd=' + curr_cd.GetSelectCode();
        url_str = url_str + '&sheet_curr_row=' + row;
        url_str = url_str + '&sheet_idx=4';
        url_str = url_str + '&param_cntr_no=' + sheetObj.GetCellValue(row, 'cntr_no');
        url_str = url_str + '&inv_amt=' + sheetObj.GetCellValue(row, 'inv_amt');
        url_str = url_str + '&yd_cd=' + formObj.yd_cd.value;
        url_str = url_str + '&ctrt_rt=' + sheetObj.GetCellValue(row, 'ctrt_rt');
        url_str = url_str + '&inv_xch_rt=' + sheetObj.GetCellValue(row, 'inv_xch_rt');
        url_str = url_str + '&ovr_dys=' + sheetObj.GetCellValue(row, 'ovr_dys');
        //window.ComOpenWindow(url_str,  window, "dialogWidth:730px; dialogHeight:440px; help:no; status:no; resizable:yes;", true);
        ComOpenWindow(url_str, window, "help:no;status:no;resizable:yes;dialogWidth:" + 820 + "px;dialogHeight:" + 700 + "px", true);
    }
}

/**
 * Coding event for OnSaveEnd.
 * @param {ibsheet}	t4sheet1	Cost Calc.(SR by FP)sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t4sheet1_OnSaveEnd(t4sheet1, ErrMsg) {
    if (confirm_done) {
        disableSheetEditable(t4sheet1);
    }
    init_Arr_sht_chk();
    // Retrieving manual cost code
    var formObj = document.form;
    if (formObj.calcStorageComboItems.value == null || doSepRemove(formObj.calcStorageComboItems.value, ' ') == '') {
        // getCalcStorageManualCostCode();
    }
    if (t4sheet1.RowCount() > 0) {
        setElementDiabled('checkbox', 'StorageDay', 'Y');
        setElementDiabled('radio', 'CostCalcMethod', 'Y');
        // t1sheet1_SetChkBoxDisabled();
        // t2sheet1_SetChkBoxDisabled();
        for (var i = 1; i <= t4sheet1.RowCount(); i++) {
            if (t4sheet1.GetCellValue(i, "calc_tp_cd") == "A") {
                if (t4sheet1.GetCellValue(i, "curr_cd") != undefined && t4sheet1.GetCellValue(i, "curr_cd") != null && t4sheet1.GetCellValue(i, "curr_cd") != '' && curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' && t4sheet1.GetCellValue(i, "curr_cd") != curr_cd.GetSelectCode()) {
                    setShtCellsEditable(t4sheet1, i, 'inv_xch_rt', 'Y', 'EXCEPTION');
                }
            } else if (t4sheet1.GetCellValue(i, "calc_tp_cd") == "M") {
                setShtCellsEditable(t4sheet1, i, 'lgs_cost_cd|rev_yrmon|stay_dys|ctrt_rt|inv_amt|inv_xch_rt', 'Y');
                setShtCellsEditable(t4sheet1, i, 'free_dys|paid_day|free_dy_xcld_dys', 'N');
            }
        }
        setCalcStorageManualCostCode(t4sheet1);
        checkTPBdataEditable('4', t4sheet1);
    } else {
        document.form.t4sht_tot_inv_amt.value = 0;
        if (t6sheet1.RowCount() == 0) {
            setElementDiabled('checkbox', 'StorageDay', 'N');
        }
    }

    chkEnableTmlOdckFlg();
}

/**
 * Coding event for OnSearchEnd.
 * @param {ibsheet}	t4sheet1	Cost Calc.(SR by FP)sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t4sheet1_OnSearchEnd(t4sheet1, ErrMsg) {
    if (confirm_done) {
        disableSheetEditable(t4sheet1);
    }
    init_Arr_sht_chk();
    // Retrieving manual cost code
    var formObj = document.form;
    if (formObj.calcStorageComboItems.value == null || doSepRemove(formObj.calcStorageComboItems.value, ' ') == '') {
        // getCalcStorageManualCostCode();
    }
    if (t4sheet1.RowCount() > 0) {
        setElementDiabled('checkbox', 'StorageDay', 'Y');
        setElementDiabled('radio', 'CostCalcMethod', 'Y');
        // t1sheet1_SetChkBoxDisabled();
        // t2sheet1_SetChkBoxDisabled();
        document.form.t4sht_tot_inv_amt.value = tes_chkAmtFmt(getShtTotCalcAmt(
            t4sheet1, 'inv_amt'));
        for (var i = 1; i <= t4sheet1.RowCount(); i++) {
            if (t4sheet1.GetCellValue(i, "calc_tp_cd") == "A") {
                if (t4sheet1.GetCellValue(i, "curr_cd") != undefined && t4sheet1.GetCellValue(i, "curr_cd") != null && t4sheet1.GetCellValue(i, "curr_cd") != '' && curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' && t4sheet1.GetCellValue(i, "curr_cd") != curr_cd.GetSelectCode()) {
                    setShtCellsEditable(t4sheet1, i, 'inv_xch_rt', 'Y', 'EXCEPTION');
                }
                t4sheet1.SetCellValue(i, "calc_rmk", ComToString(t4sheet1.GetCellValue(i, "calc_rmk")), 0);

            } else if (t4sheet1.GetCellValue(i, "calc_tp_cd") == "M") {
                setShtCellsEditable(t4sheet1, i, 'lgs_cost_cd|rev_yrmon|stay_dys|ctrt_rt|inv_amt|inv_xch_rt', 'Y');
                setShtCellsEditable(t4sheet1, i, 'free_dys|paid_day|free_dy_xcld_dys', 'N');
                t4sheet1.SetCellValue(i, "calc_rmk", ComToString(t4sheet1.GetCellValue(i, "calc_rmk")), 0);

            } else if (t4sheet1.GetCellValue(i, "calc_tp_cd") == "S") {
                setShtCellsEditable(t4sheet1, i, 'rev_yrmon|inv_amt|inv_xch_rt', 'Y', 'EXCEPTION');
                setShtCellsEditable(t4sheet1, i, 'stay_dys|ctrt_rt|inv_xch_rt|free_dys|paid_day|free_dy_xcld_dys', 'N', "EXCEPTION");
                t4sheet1.SetCellValue(i, "calc_rmk", ComToString(t4sheet1.GetCellValue(i, "calc_rmk")), 0);
            }
        }
        setCalcStorageManualCostCode(t4sheet1);
        checkTPBdataEditable('4', t4sheet1);
    } else {
        document.form.t4sht_tot_inv_amt.value = 0;
        if (document.form.tml_odck_flg.value == 'N') { //20150430 추가
            if (t6sheet1.RowCount() == 0) {
                setElementDiabled('checkbox', 'StorageDay', 'N');
            }
        }

    }

    chkEnableTmlOdckFlg();
}

/**
 * Coding event for OnChange.
 * @param {sheet}		t4sheet1	Cost Calc.(SR by FD) sheet
 * @param {int}		Row			The cell's Row Index
 * @param {int}		Col			The cell's Column Index
 * @param {string}	Value
 * @return
 */
function t4sheet1_OnChange(t4sheet1, Row, Col, Value) {
    var sName = t4sheet1.ColSaveName(Col);
    var sCurrCd = document.form.curr_cd.value;
    
    if (sName == "stay_dys" || sName == "free_dys" || sName == "paid_day" || sName == "free_dy_xcld_dys" || sName == "ovr_dys" || sName == "ctrt_rt" || sName == 'vol_tr_ut_cd') {
        if (isNaN(t4sheet1.GetCellValue(Row, 'free_dys')) || parseInt(t4sheet1.GetCellValue(Row, 'free_dys'), 10) < 0) {
            t4sheet1.SetCellValue(Row, 'free_dys', 0, 0);
        }
        if (isNaN(t4sheet1.GetCellValue(Row, 'paid_day')) || parseInt(t4sheet1.GetCellValue(Row, 'paid_day'), 10) < 0) {
            t4sheet1.SetCellValue(Row, 'paid_day', 0, 0);
        }
        if (isNaN(t4sheet1.GetCellValue(Row, 'free_dy_xcld_dys')) || parseInt(t4sheet1.GetCellValue(Row, 'free_dy_xcld_dys'), 10) < 0) {
            t4sheet1.SetCellValue(Row, 'free_dy_xcld_dys', 0, 0);
        }
        t4sheet1_RecalcCalcAmt(t4sheet1, Row);
    }

    if (sName == "inv_xch_rt") {
        t4sheet1.SetCellValue(Row, 'inv_xch_rt', Math.abs(t4sheet1.GetCellValue(Row, 'inv_xch_rt')));
        if (t4sheet1.GetCellValue(Row, 'inv_xch_rt') > 0) {
            t4sheet1.SetCellBackColor(Row, 'inv_xch_rt', "#NAN", 0, 0, 0);
        }
        
        if (t4sheet1.GetCellValue(Row, 'calc_tp_cd') == 'A') {
            if (t4sheet1.GetCellValue(Row, 'curr_cd') != undefined && t4sheet1.GetCellValue(Row, 'curr_cd') != null && t4sheet1.GetCellValue(Row, 'curr_cd') != '' && curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' && curr_cd.GetSelectCode() != t4sheet1.GetCellValue(Row, 'curr_cd') && !isNaN(t4sheet1.GetCellValue(Row, 'inv_xch_rt')) && Number(t4sheet1.GetCellValue(Row, 'inv_xch_rt')) > 0) {
                var nInvAmt = Number(t4sheet1.GetCellValue(Row, 'ovr_dys')) * Number(t4sheet1.GetCellValue(Row, 'ctrt_rt')) * Number(t4sheet1.GetCellValue(Row, 'inv_xch_rt'));
        
		        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
		        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
		        }                
		        nInvAmt = Math.round(nInvAmt*100)/100; //exchange rate 계산후 소수점 2자리로 화면과 똑같이 DB에도 저장하기 위해서 수정함.
                t4sheet1.SetCellValue(Row, 'inv_amt', nInvAmt);
            }
        } else if (t4sheet1.GetCellValue(Row, 'calc_tp_cd') == 'M') {
            if (curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' && !isNaN(t4sheet1.GetCellValue(Row, 'inv_xch_rt')) && Number(t4sheet1.GetCellValue(Row, 'inv_xch_rt')) > 0) {
            	var nInvAmt = Number(t4sheet1.GetCellValue(Row, 'ovr_dys')) * Number(t4sheet1.GetCellValue(Row, 'ctrt_rt')) * Number(t4sheet1.GetCellValue(Row, 'inv_xch_rt'));
        
		        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
		        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
		        }                 
		        nInvAmt = Math.round(nInvAmt*100)/100; //exchange rate 계산후 소수점 2자리로 화면과 똑같이 DB에도 저장하기 위해서 수정함.
                t4sheet1.SetCellValue(Row, 'inv_amt', nInvAmt);
            }
        }
    }
    if (sName == "inv_amt" && t4sheet1.GetCellValue(Row, 'calc_tp_cd') == 'M') {
        document.form.t4sht_tot_inv_amt.value = getShtTotCalcAmt(t4sheet1, 'inv_amt');
    }
}


/**
 * Calculating [Inv Amt]
 * @param {sheet}	t4sheet1	Cost Calc.(SR by FD) sheet
 * @param {int}		Row			The cell's Row Index
 * @return
 */
function t4sheet1_RecalcCalcAmt(t4sheet1, Row) {
	var sCurrCd = document.form.curr_cd.value;
        
    if (t4sheet1.RowCount() > 0) {
        if (t4sheet1.GetCellValue(Row, 'stay_dys') == -1) {
            t4sheet1.SetRowFontColor(Row, "#FF0000");
        } else {
            t4sheet1.SetRowFontColor(Row, t4sheet1.GetDataFontColor());
        }
        if (t4sheet1.GetCellValue(Row, "calc_tp_cd") == "A") {
            t4sheet1.SetCellValue(Row, 'ovr_dys', Number(t4sheet1.GetCellValue(Row, 'ovr_dys2')) - Number(t4sheet1.GetCellValue(Row, 'paid_day')) - Number(t4sheet1.GetCellValue(Row, 'free_dy_xcld_dys')));
        } else if (t4sheet1.GetCellValue(Row, "calc_tp_cd") == "M") {
            t4sheet1.SetCellValue(Row, 'ovr_dys', Number(t4sheet1.GetCellValue(Row, 'stay_dys')) - Number(t4sheet1.GetCellValue(Row, 'free_dys')) - Number(t4sheet1.GetCellValue(Row, 'paid_day')) - Number(t4sheet1.GetCellValue(Row, 'free_dy_xcld_dys')));
        }

        var ovr_dys = Number(t4sheet1.GetCellValue(Row, 'ovr_dys'));
        if (isNaN(ovr_dys) || parseInt(ovr_dys, 10) < 0) {
            ovr_dys = 0;
            t4sheet1.SetCellValue(Row, 'ovr_dys', 0, 0);
        }
        
       	var nInvAmt = Number(ovr_dys) * Number(t4sheet1.GetCellValue(Row, 'ctrt_rt')) * (Number(t4sheet1.GetCellValue(Row, 'inv_xch_rt')) > 0 ? Number(t4sheet1.GetCellValue(Row, 'inv_xch_rt')) : 1);
        
        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
        }    

        t4sheet1.SetCellValue(Row, 'inv_amt', nInvAmt);
        /*
         * if (t4sheet1.GetCellValue(Row,'calc_tp_cd')=='A') { if
         * (t4sheet1.CellValue(Row,'curr_cd')!=undefined &&
         * t4sheet1.CellValue(Row,'curr_cd')!=null &&
         * t4sheet1.CellValue(Row,'curr_cd')!='' &&
         * document.form.curr_cd.Code!=undefined &&
         * document.form.curr_cd.Code!=null && document.form.curr_cd.Code!='' &&
         * document.form.curr_cd.Code!=t4sheet1.CellValue(Row,'curr_cd') &&
         * !isNaN(t4sheet1.CellValue(Row,'inv_xch_rt')) &&
         * Number(t4sheet1.CellValue(Row,'inv_xch_rt'))>0) {
         * t4sheet1.CellValue(Row,'inv_amt') = Number(ovr_dys) *
         * Number(t4sheet1.CellValue(Row,'ctrt_rt')) *
         * (Number(t4sheet1.CellValue(Row,'inv_xch_rt'))>0?Number(t4sheet1.CellValue(Row,'inv_xch_rt')):1); } }
         * else if (t4sheet1.CellValue(Row,'calc_tp_cd')=='M'){ if
         * (document.form.curr_cd.Code!=undefined &&
         * document.form.curr_cd.Code!=null && document.form.curr_cd.Code!='' &&
         * !isNaN(t4sheet1.CellValue(Row,'inv_xch_rt')) &&
         * Number(t4sheet1.CellValue(Row,'inv_xch_rt'))>0) {
         * t4sheet1.CellValue(Row,'inv_amt') = Number(ovr_dys) *
         * Number(t4sheet1.CellValue(Row,'ctrt_rt')) *
         * (Number(t4sheet1.CellValue(Row,'inv_xch_rt'))>0?Number(t4sheet1.CellValue(Row,'inv_xch_rt')):1); } }
         */
        if ((t4sheet1.GetCellValue(Row, 'cntr_tpsz_cd') != undefined && t4sheet1.GetCellValue(Row, 'cntr_tpsz_cd') != null && doSepRemove(t4sheet1.GetCellValue(Row, 'cntr_tpsz_cd'), ' ') != '') && (t4sheet1.GetCellValue(Row, 'vol_tr_ut_cd') != undefined && t4sheet1.GetCellValue(Row, 'vol_tr_ut_cd') != null && doSepRemove(t4sheet1.GetCellValue(Row, 'vol_tr_ut_cd'), ' ') != '')) {
        	var nInvAmt = t4sheet1.GetCellValue(Row, 'inv_amt') * tes_getTEUconv(t4sheet1.GetCellValue(Row, 'vol_tr_ut_cd'), t4sheet1.GetCellValue(Row, 'cntr_tpsz_cd'));
        
	        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
	        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
	        }           
            
            t4sheet1.SetCellValue(Row, 'inv_amt', nInvAmt);
        }
    }
}

/**
 * Opening 3rd Party Interface input screen.
 * @param {sheet}	t4sheet1	Cost Calc.(SR by FP) sheet
 * @param {int}		row			The cell's Row Index
 * @param {int}		col			The cell's Column Index
 * @return
 */
function t5sheet1_OnPopupClick(sheetObj, row, col) {
    var formObj = document.form;
    if (sheetObj.ColSaveName(col) == "n3pty_flg") {
        if (sheetObj.GetCellValue(row, 'calc_cost_grp_cd') == null || doSepRemove(sheetObj.GetCellValue(row, 'calc_cost_grp_cd'), ' ') == '') {
            ComShowMessage(ComGetMsg('TES24046'));
            return false;
        }
        if (curr_cd.GetSelectCode() == null || doSepRemove(curr_cd.GetSelectCode(), ' ') == '') {
            ComShowMessage(ComGetMsg('TES40041', 'Currency code'));
            return false;
        }
        if (sheetObj.GetCellValue(row, 'lgs_cost_cd') == undefined || sheetObj.GetCellValue(row, 'lgs_cost_cd') == null || doSepRemove(sheetObj.GetCellValue(row, 'lgs_cost_cd'), ' ') == '') {
            ComShowMessage(ComGetMsg('TES23045'));
            return false;
        }
        if (sheetObj.GetCellValue(row, 'inv_amt') != undefined && sheetObj.GetCellValue(row, 'inv_amt') != null && sheetObj.GetCellValue(row, 'inv_amt') < 0) {
            return false;
        }
        var url_str = 'ESD_TES_9233Popup.screen';
        url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
        url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
        url_str = url_str + '&tml_so_dtl_seq=' + sheetObj.GetCellValue(row, 'tml_so_dtl_seq');
        url_str = url_str + '&tml_inv_tp_cd=' + formObj.tml_inv_tp_cd.value;
        url_str = url_str + '&calc_cost_grp_cd=' + sheetObj.GetCellValue(row, 'calc_cost_grp_cd');
        url_str = url_str + '&calc_tp_cd=' + sheetObj.GetCellValue(row, 'calc_tp_cd');
        url_str = url_str + '&vndr_seq=' + formObj.vndr_seq.value;
        url_str = url_str + '&inv_no=' + formObj.inv_no.value;
        url_str = url_str + '&param_lgs_cost_cd=' + sheetObj.GetCellValue(row, 'lgs_cost_cd');
        url_str = url_str + '&param_cntr_tpsz_cd=' + sheetObj.GetCellValue(row, 'cntr_tpsz_cd');
        url_str = url_str + '&curr_cd=' + curr_cd.GetSelectCode();
        url_str = url_str + '&sheet_curr_row=' + row;
        url_str = url_str + '&sheet_idx=5';
        ComOpenWindow(url_str, window, "dialogWidth:820px;dialogHeight:700px;help:no;status:no;resizable:yes;", true);
    }
}

/**
 * Calculating [Inv Amt]
 * @param {sheet}	t4sheet1	Cost Calc.(SR by FP) sheet
 * @param {int}		Row			The cell's Row Index
 * @return
 */
function t5sheet1_RecalcCalcAmt(t5sheet1, Row) {
    var sCurrCd = document.form.curr_cd.value;
    	
    if (t5sheet1.RowCount() > 0) {
        t5sheet1.SetCellValue(Row, 'ovr_vol_qty', t5sheet1.GetCellValue(Row, 'inv_vol_qty') - t5sheet1.GetCellValue(Row, 'fp_teu_qty'));
        t5sheet1.SetCellValue(Row, 'diff_vol_qty', t5sheet1.GetCellValue(Row, 'stk_vol_qty') - t5sheet1.GetCellValue(Row, 'inv_vol_qty'));
        var ovr_vol_qty = t5sheet1.GetCellValue(Row, 'ovr_vol_qty');
        if (isNaN(ovr_vol_qty) || parseInt(ovr_vol_qty, 10) < 0) {
            ovr_vol_qty = 0;
            t5sheet1.SetCellValue(Row, 'ovr_vol_qty', 0, 0);
        }
        
        var nInvAmt = ovr_vol_qty * t5sheet1.GetCellValue(Row, 'ctrt_rt');
        
        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
        } 
	        
        t5sheet1.SetCellValue(Row, 'inv_amt', nInvAmt);
        
        if (t5sheet1.GetCellValue(Row, 'calc_tp_cd') == 'A') {
            if (t5sheet1.GetCellValue(Row, 'curr_cd') != undefined && t5sheet1.GetCellValue(Row, 'curr_cd') != null && t5sheet1.GetCellValue(Row, 'curr_cd') != '' && curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' && curr_cd.GetSelectCode() != t5sheet1.GetCellValue(Row,
                    'curr_cd') && !isNaN(t5sheet1.GetCellValue(Row, 'inv_xch_rt')) && parseFloat(t5sheet1.GetCellValue(Row, 'inv_xch_rt')) > 0) {
            	
            	var nInvAmt = parseFloat(t5sheet1.GetCellValue(Row, 'inv_amt')) * parseFloat(t5sheet1.GetCellValue(Row, 'inv_xch_rt'));
        
		        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
		        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
		        } 
		        
                t5sheet1.SetCellValue(Row, 'inv_amt', nInvAmt);
            }
        } else if (t5sheet1.GetCellValue(Row, 'calc_tp_cd') == 'M') {
            if (curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' && !isNaN(t5sheet1.GetCellValue(Row, 'inv_xch_rt')) && parseFloat(t5sheet1.GetCellValue(Row, 'inv_xch_rt')) > 0) {
                
             	var nInvAmt = parseFloat(t5sheet1.GetCellValue(Row, 'inv_amt')) * parseFloat(t5sheet1.GetCellValue(Row, 'inv_xch_rt'));
        
		        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
		        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
		        } 
                
                t5sheet1.SetCellValue(Row, 'inv_amt', nInvAmt);
            }
        }
        t5sheet1_ChkDifferVol(t5sheet1, Row);
    }
}

/**
 * Comparing with invoice vol. and diff vol.
 * @param {sheet}	t5sheet1	ibsheet
 * @param {int}		Row			The cell's Row Index
 * @return
 */
function t5sheet1_ChkDifferVol(t5sheet1, Row) {
    var diff_vol_qty = parseFloat(t5sheet1.GetCellValue(Row, 'diff_vol_qty'));
    var inv_vol_qty = parseFloat(t5sheet1.GetCellValue(Row, 'inv_vol_qty'));
    var result = (diff_vol_qty / inv_vol_qty);
    if (result > 0.01) {
        t5sheet1.SetRowFontColor(Row, "#FF0000");
    } else {
        t5sheet1.SetRowFontColor(Row, t5sheet1.GetDataFontColor());
    }
}

/**
 * Comparing invoice vol. and diff vol.
 * @param {sheet}	t5sheet1	ibsheet
 * @return
 */
function t5sheet1_ChkDifferVol2(t5sheet1) {
    if (t5sheet1.RowCount() > 0) {
        var diff_vol_qty = 0;
        var inv_vol_qty = 0;
        var result = 0;
        for (var i = 1; i <= t5sheet1.RowCount(); i++) {
            diff_vol_qty = parseFloat(t5sheet1.GetCellValue(i, 'diff_vol_qty'));
            inv_vol_qty = parseFloat(t5sheet1.GetCellValue(i, 'inv_vol_qty'));
            result = (Math.abs(diff_vol_qty) / Math.abs(inv_vol_qty));
            if (result > 0.01) {
                t5sheet1.SetRowFontColor(i, "#FF0000");
            } else {
                t5sheet1.SetRowFontColor(i, t5sheet1.GetDataFontColor());
            }
        }
    }
}

/**
 * Coding event for OnClick.
 * @param {sheet}	t4sheet1	Cost Calc.(SR by FP) sheet
 * @param {int}		Row			The cell's Row Index
 * @param {int}		Col			The cell's Column Index
 * @param {string}	Value
 * @return
 */
function t5sheet1_OnClick(t5sheet1, Row, Col, Value) {
    if (t5sheet1.ColSaveName(Col) == 'calc_rmk') {
        // ComShowMessage(' cell value:' + t5sheet1.GetCellValue(Row,'lgs_cost_cd')
        // );
    }
}

/**
 * Calculating Cost Calc.(SR by FP) sheet [Calculated AMT]
 * @param {sheet}	t5sheet1	Cost Calc.(SR by FP) sheet
 * @return
 */
function t5sheet1_TotCalcAmt(t5sheet1) {
    document.form.t5sht_tot_inv_amt.value = tes_chkAmtFmt(getShtTotCalcAmt(t5sheet1, 'inv_amt'));
}

/**
 * Cost Calc.(SR by FP) sheet 
 * @param {sheet}	t5sheet1	Cost Calc.(SR by FP) sheet
 * @return
 */
function t5sheet1_MonthlyRowManage(t5sheet1) {
    for (var i = 0; i < t5sheet1.RowCount(); i++) {
        if (t5sheet1.GetCellValue(i, "calc_tp_cd") == "A") {
            if (t5sheet1.GetCellValue(i, "fp_calc_prd_cd") == "M") {
                t5sheet1.InitCellProperty(i, 'wrk_dt', {Type: "Data", Align: "Center", Format: "dfDateYm" });
            }
        }
    }
}

function t6sheet1_TotCalcAmt(t6sheet1) {
    document.form.t6sht_tot_inv_amt.value = tes_chkAmtFmt(getShtTotCalcAmt(t6sheet1, 'inv_amt'));
}

/** t6sheet1_OnChange
 * 
 * @param t6sheet1
 * @param Row
 * @param Col
 * @param Value
 */
function t6sheet1_OnChange(t6sheet1, Row, Col, Value) {
    var sName = t6sheet1.ColSaveName(Col);
    var sCurrCd = document.form.curr_cd.value;
        
    if (sName == "stay_dys" || sName == "free_dys" || sName == "paid_day" || sName == "free_dy_xcld_dys" || sName == "ovr_dys" || sName == "ctrt_rt" || sName == 'vol_tr_ut_cd') {
        if (isNaN(t6sheet1.GetCellValue(Row, 'free_dys')) || parseInt(t6sheet1.GetCellValue(Row, 'free_dys'), 10) < 0) {
            t6sheet1.SetCellValue(Row, 'free_dys', 0, 0);
        }
        if (isNaN(t6sheet1.GetCellValue(Row, 'paid_day')) || parseInt(t6sheet1.GetCellValue(Row, 'paid_day'), 10) < 0) {
            t6sheet1.SetCellValue(Row, 'paid_day', 0, 0);
        }
        if (isNaN(t6sheet1.GetCellValue(Row, 'free_dy_xcld_dys')) || parseInt(t6sheet1.GetCellValue(Row, 'free_dy_xcld_dys'), 10) < 0) {
            t6sheet1.SetCellValue(Row, 'free_dy_xcld_dys', 0, 0);
        }
        t6sheet1_RecalcCalcAmt(t6sheet1, Row);
    }

    if (sName == "inv_xch_rt") {
        t6sheet1.SetCellValue(Row, 'inv_xch_rt', Math.abs(t6sheet1.GetCellValue(Row, 'inv_xch_rt')));
        if (t6sheet1.GetCellValue(Row, 'inv_xch_rt') > 0) {
            t6sheet1.SetCellBackColor(Row, 'inv_xch_rt', "#NAN", 0, 0, 0);
        }
        if (t6sheet1.GetCellValue(Row, 'calc_tp_cd') == 'A') {
            if (t6sheet1.GetCellValue(Row, 'curr_cd') != undefined && t6sheet1.GetCellValue(Row, 'curr_cd') != null && t6sheet1.GetCellValue(Row, 'curr_cd') != '' && curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' && curr_cd.GetSelectCode() != t6sheet1.GetCellValue(Row, 'curr_cd') && !isNaN(t6sheet1.GetCellValue(Row, 'inv_xch_rt')) && Number(t6sheet1.GetCellValue(Row, 'inv_xch_rt')) > 0) {
                var nInvAmt = Number(t6sheet1.GetCellValue(Row, 'ovr_dys')) * Number(t6sheet1.GetCellValue(Row, 'ctrt_rt')) * Number(t6sheet1.GetCellValue(Row, 'inv_xch_rt'));
        
		        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
		        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
		        } 
                
                t6sheet1.SetCellValue(Row, 'inv_amt', nInvAmt);
            }
        } else if (t6sheet1.GetCellValue(Row, 'calc_tp_cd') == 'M') {
            if (curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' && !isNaN(t6sheet1.GetCellValue(Row, 'inv_xch_rt')) && Number(t6sheet1.GetCellValue(Row, 'inv_xch_rt')) > 0) {
           		var nInvAmt = Number(t6sheet1.GetCellValue(Row, 'ovr_dys')) * Number(t6sheet1.GetCellValue(Row, 'ctrt_rt')) * Number(t6sheet1.GetCellValue(Row, 'inv_xch_rt'));
        
		        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
		        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
		        } 
                
                t6sheet1.SetCellValue(Row, 'inv_amt', nInvAmt);
            }
        }
    }

    if (sName == "eq_no" && t6sheet1.GetCellValue(Row, 'eq_no') != "" && (t6sheet1.GetCellValue(Row, 'calc_tp_cd') == 'M' || t6sheet1.GetCellValue(Row, 'calc_tp_cd') == 'S') && searchEQFlag == false) {
        searchEQFlag = true;
        document.form.eq_no.value = t6sheet1.GetCellValue(Row, 'eq_no');
        tmp_row = Row;
        var rtnVal = getEquipTypeCd();     // tes_getInputValue('tmp_eq_tpsz_cd', SEARCHLIST09, 'eq_no', 'chkEqNo');
        if(rtnVal.length > 0){
        	chkEqNo(rtnVal);
        }

    } else if (sName == "eq_no" && t6sheet1.GetCellValue(Row, 'eq_no') != "" && (t6sheet1.GetCellValue(Row, 'calc_tp_cd') == 'M' || t6sheet1.GetCellValue(Row, 'calc_tp_cd') == 'S') && searchEQFlag == true) {
        alert("Different row is searching for Type/Size");
        t6sheet1.SetCellValue(Row, 'eq_no', "");
        t6sheet1.SelectCell(Row, "eq_no", 1);
    }


    if (sName == "eq_tpsz_cd" && (t6sheet1.GetCellValue(Row, 'calc_tp_cd') == 'M' || t6sheet1.GetCellValue(Row, 'calc_tp_cd') == 'S')) {
        if (t6sheet1.GetCellValue(Row, 'lgs_cost_cd') == "SRFDGS") {
            if (t6sheet1.GetCellValue(Row, 'eq_tpsz_cd') == "CLG" || t6sheet1.GetCellValue(Row, 'eq_tpsz_cd') == "UMG") {
                //
            } else {
                alert("Select Genset Type/Size.");
                t6sheet1.SetCellValue(Row, 'eq_tpsz_cd', 'CLG');
            }

        } else {
            if (t6sheet1.GetCellValue(Row, 'eq_tpsz_cd') == "CLG" || t6sheet1.GetCellValue(Row, 'eq_tpsz_cd') == "UMG") {
                alert("Select Chassis Type/Size.");
                t6sheet1.SetCellValue(Row, 'eq_tpsz_cd', 'CH2');
            }
        }
    }

    if (sName == "lgs_cost_cd" && (t6sheet1.GetCellValue(Row, 'calc_tp_cd') == 'M' || t6sheet1.GetCellValue(Row, 'calc_tp_cd') == 'S')) {
        if (t6sheet1.GetCellValue(Row, 'lgs_cost_cd') == "SRFDGS") {
            t6sheet1.SetCellValue(Row, 'eq_knd_cd', "G");
            t6sheet1.SetCellValue(Row, 'eq_tpsz_cd', "CLG");
            t6sheet1.SetCellValue(Row, 'eq_no', "");
        } else {
            t6sheet1.SetCellValue(Row, 'eq_knd_cd', "Z");
            t6sheet1.SetCellValue(Row, 'eq_tpsz_cd', "CH2");
            t6sheet1.SetCellValue(Row, 'eq_no', "");
        }
    }

    if (sName == "inv_amt" && t6sheet1.GetCellValue(Row, 'calc_tp_cd') == 'M') {
        document.form.t6sht_tot_inv_amt.value = getShtTotCalcAmt(t6sheet1, 'inv_amt');
    }

}

/** t6sheet1_OnSearchEnd
 * 
 * @param t4sheet1
 * @param ErrMsg
 */
function t6sheet1_OnSearchEnd(t6sheet1, ErrMsg) {
    if (confirm_done) {
        disableSheetEditable(t6sheet1);
    }
    init_Arr_sht_chk();
    // Retrieving manual cost code
    var formObj = document.form;
    if (formObj.calcStorageComboItems.value == null || doSepRemove(formObj.calcStorageComboItems.value, ' ') == '') {
        // getCalcStorageManualCostCode();
    }
    if (t6sheet1.RowCount() > 0) {
        // t1sheet1_SetChkBoxDisabled();
        // t2sheet1_SetChkBoxDisabled();
        setElementDiabled('checkbox', 'StorageDay', 'Y');
        setElementDiabled('radio', 'CostCalcMethod', 'Y');

        document.form.t6sht_tot_inv_amt.value = tes_chkAmtFmt(getShtTotCalcAmt(t6sheet1, 'inv_amt'));
        for (var i = 1; i <= t6sheet1.RowCount(); i++) {
            if (t6sheet1.GetCellValue(i, "calc_tp_cd") == "A") {
                if (t6sheet1.GetCellValue(i, "curr_cd") != undefined && t6sheet1.GetCellValue(i, "curr_cd") != null && t6sheet1.GetCellValue(i, "curr_cd") != '' && curr_cd.GetSelectCode() != undefined && curr_cd.GetSelectCode() != null && curr_cd.GetSelectCode() != '' && t6sheet1.GetCellValue(i, "curr_cd") != curr_cd.GetSelectCode()) {
                    setShtCellsEditable(t6sheet1, i, 'inv_xch_rt', 'Y', 'EXCEPTION');
                }
                t6sheet1.SetCellValue(i, "calc_rmk", ComToString(t6sheet1.GetCellValue(i, "calc_rmk")), 0);

            } else if (t6sheet1.GetCellValue(i, "calc_tp_cd") == "M") {
                setShtCellsEditable(t6sheet1, i, 'lgs_cost_cd|eq_no|rev_yrmon|stay_dys|ctrt_rt|inv_amt|inv_xch_rt', 'Y');
                setShtCellsEditable(t6sheet1, i, 'free_dys|paid_day|free_dy_xcld_dys', 'N');
                t6sheet1.SetCellValue(i, "calc_rmk", ComToString(t6sheet1.GetCellValue(i, "calc_rmk")), 0);

            } else if (t6sheet1.GetCellValue(i, "calc_tp_cd") == "S") {
                setShtCellsEditable(t6sheet1, i, 'rev_yrmon|inv_amt|inv_xch_rt', 'Y', 'EXCEPTION');
                setShtCellsEditable(t6sheet1, i, 'stay_dys|ctrt_rt|inv_xch_rt|free_dys|paid_day|free_dy_xcld_dys', 'N', "EXCEPTION");
                t6sheet1.SetCellValue(i, "calc_rmk", ComToString(t6sheet1.GetCellValue(i, "calc_rmk")), 0);
            }
        }
        setCalcOffEqManualCostCode(t6sheet1);
        checkTPBdataEditable('10', t6sheet1);
    } else {
        document.form.t6sht_tot_inv_amt.value = 0;
        if (document.form.tml_odck_flg.value == 'N') { //20150430 추가
            if (t4sheet1.RowCount() == 0) {
                setElementDiabled('checkbox', 'StorageDay', 'N');
            }
        }
    }

    chkEnableTmlOdckFlg();
}

/** t6sheet1_OnSaveEnd
 * 
 * @param t6sheet1
 * @param ErrMsg
 */
function t6sheet1_OnSaveEnd(t6sheet1, ErrMsg) {
    if (confirm_done) {
        disableSheetEditable(t6sheet1);
    }

    init_Arr_sht_chk();

    var formObj = document.form;

    if (formObj.calcStorageComboItems.value == null || doSepRemove(formObj.calcStorageComboItems.value, ' ') == '') {
        // getCalcStorageManualCostCode();
    }

    if (t6sheet1.RowCount() > 0) {
        setPeriodReadonly('Y');

        for (var i = 1; i <= t6sheet1.RowCount(); i++) {
            if (t6sheet1.GetCellValue(i, "calc_tp_cd") == "A") {
                if (t6sheet1.GetCellValue(i, "curr_cd") != undefined && t6sheet1.GetCellValue(i, "curr_cd") != null && t6sheet1.GetCellValue(i, "curr_cd") != '' && curr_cd.Code != undefined && curr_cd.Code != null && curr_cd.Code != '' && t6sheet1.GetCellValue(i, "curr_cd") != curr_cd.GetSelectCode()) {
                    setShtCellsEditable(t6sheet1, i, 'inv_xch_rt', 'Y', 'EXCEPTION');
                }
            } else if (t6sheet1.GetCellValue(i, "calc_tp_cd") == "M") {
                setShtCellsEditable(t6sheet1, i, 'lgs_cost_cd|rev_yrmon|stay_dys|ctrt_rt|inv_amt|inv_xch_rt', 'Y');
                setShtCellsEditable(t6sheet1, i, 'free_dys|paid_day|free_dy_xcld_dys', 'N');
            }
        }

        setCalcOffEqManualCostCode(t6sheet1);

        t6sheet1_TotCalcAmt(t6sheet1);
        checkTPBdataEditable('10', t6sheet1);

    } else {
        document.form.t6sht_tot_inv_amt.value = 0;
        setPeriodReadonly('N');
        if (t4sheet1.RowCount() == 0) {
            setElementDiabled('checkbox', 'StorageDay', 'N');
        }
    }

    chkEnableTmlOdckFlg();

}

/** t6sheet1_OnPopupClick
 * 
 * @param sheetObj
 * @param row
 * @param col
 * @returns {Boolean}
 */
function t6sheet1_OnPopupClick(sheetObj, row, col) {
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
        if (sheetObj.GetCellValue(row, 'lgs_cost_cd') == undefined || sheetObj.GetCellValue(row, 'lgs_cost_cd') == null || doSepRemove(sheetObj.GetCellValue(row, 'lgs_cost_cd'), ' ') == '') {
            ComShowMessage(ComGetMsg('TES23045'));
            return false;
        }
        if (curr_cd.GetSelectCode() == null || doSepRemove(curr_cd.GetSelectCode(), ' ') == '') {
            ComShowMessage(ComGetMsg('TES40041', 'Currency code'));
            return false;
        }
        if ((sheetObj.GetCellValue(row, 'calc_tp_cd') != null && sheetObj.GetCellValue(row, 'calc_tp_cd') == 'A') && (sheetObj.GetCellValue(row, 'cntr_no') == undefined || sheetObj.GetCellValue(row, 'cntr_no') == null || doSepRemove(sheetObj.GetCellValue(row, 'cntr_no'), ' ') == '')) {
            ComShowMessage(ComGetMsg('TES23047'));
            return false;
        }
        if (sheetObj.GetCellValue(row, 'inv_amt') != undefined && sheetObj.GetCellValue(row, 'inv_amt') != null && sheetObj.GetCellValue(row, 'inv_amt') < 0) {
            return false;
        }
        var url_str = 'ESD_TES_9233Popup.screen';
        url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
        url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
        url_str = url_str + '&tml_so_dtl_seq=' + sheetObj.GetCellValue(row, 'tml_so_dtl_seq');
        url_str = url_str + '&tml_inv_tp_cd=' + formObj.tml_inv_tp_cd.value;
        url_str = url_str + '&calc_cost_grp_cd=' + sheetObj.GetCellValue(row, 'calc_cost_grp_cd');
        url_str = url_str + '&calc_tp_cd=' + sheetObj.GetCellValue(row, 'calc_tp_cd');
        url_str = url_str + '&vndr_seq=' + formObj.vndr_seq.value;
        url_str = url_str + '&inv_no=' + formObj.inv_no.value;
        url_str = url_str + '&param_lgs_cost_cd=' + sheetObj.GetCellValue(row, 'lgs_cost_cd');
        url_str = url_str + '&param_cntr_tpsz_cd=' + sheetObj.GetCellValue(row, 'cntr_tpsz_cd');
        url_str = url_str + '&curr_cd=' + curr_cd.GetSelectCode();
        url_str = url_str + '&sheet_curr_row=' + row;
        url_str = url_str + '&sheet_idx=6';
        url_str = url_str + '&param_cntr_no=' + sheetObj.GetCellValue(row, 'cntr_no');
        url_str = url_str + '&inv_amt=' + sheetObj.GetCellValue(row, 'inv_amt');
        url_str = url_str + '&yd_cd=' + formObj.yd_cd.value;
        url_str = url_str + '&ctrt_rt=' + sheetObj.GetCellValue(row, 'ctrt_rt');
        url_str = url_str + '&inv_xch_rt=' + sheetObj.GetCellValue(row, 'inv_xch_rt');
        url_str = url_str + '&ovr_dys=' + sheetObj.GetCellValue(row, 'ovr_dys');
        //window.ComOpenWindow(url_str,  window, "dialogWidth:730px; dialogHeight:440px; help:no; status:no; resizable:yes;", true);
        ComOpenWindow(url_str, window, "help:no;status:no;resizable:yes;dialogWidth:" + 820 + "px;dialogHeight:" + 700 + "px", true);
    }
}

function t6sheet1_RecalcCalcAmt(t6sheet1, Row) {
    var sCurrCd = document.form.curr_cd.value;
    if (t6sheet1.RowCount() > 0) {
        if (t6sheet1.GetCellValue(Row, 'stay_dys') == -1) {
            t6sheet1.SetRowFontColor(Row, "#FF0000");
        } else {
            t6sheet1.SetRowFontColor(Row, t6sheet1.GetDataFontColor());
        }
        if (t6sheet1.GetCellValue(Row, "calc_tp_cd") == "A") {
            t6sheet1.SetCellValue(Row, 'ovr_dys', Number(t6sheet1.GetCellValue(Row, 'ovr_dys2')) - Number(t6sheet1.GetCellValue(Row, 'paid_day')) - Number(t6sheet1.GetCellValue(Row, 'free_dy_xcld_dys')));
        } else if (t6sheet1.GetCellValue(Row, "calc_tp_cd") == "M") {
            t6sheet1.SetCellValue(Row, 'ovr_dys', Number(t6sheet1.GetCellValue(Row, 'stay_dys')) - Number(t6sheet1.GetCellValue(Row, 'free_dys')) - Number(t6sheet1.GetCellValue(Row, 'paid_day')) - Number(t6sheet1.GetCellValue(Row, 'free_dy_xcld_dys')));
        }

        var ovr_dys = Number(t6sheet1.GetCellValue(Row, 'ovr_dys'));
        if (isNaN(ovr_dys) || parseInt(ovr_dys, 10) < 0) {
            ovr_dys = 0;
            t6sheet1.SetCellValue(Row, 'ovr_dys', 0, 0);
        }
        
        var nInvAmt = Number(ovr_dys) * Number(t6sheet1.GetCellValue(Row, 'ctrt_rt')) * (Number(t6sheet1.GetCellValue(Row, 'inv_xch_rt')) > 0 ? Number(t6sheet1.GetCellValue(Row, 'inv_xch_rt')) : 1);
        
        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
        } 

        t6sheet1.SetCellValue(Row, 'inv_amt', nInvAmt);
        /*
         * if (t6sheet1.GetCellValue(Row,'calc_tp_cd')=='A') { if
         * (t6sheet1.CellValue(Row,'curr_cd')!=undefined &&
         * t6sheet1.CellValue(Row,'curr_cd')!=null &&
         * t6sheet1.CellValue(Row,'curr_cd')!='' &&
         * document.form.curr_cd.Code!=undefined &&
         * document.form.curr_cd.Code!=null && document.form.curr_cd.Code!='' &&
         * document.form.curr_cd.Code!=t6sheet1.CellValue(Row,'curr_cd') &&
         * !isNaN(t6sheet1.CellValue(Row,'inv_xch_rt')) &&
         * Number(t6sheet1.CellValue(Row,'inv_xch_rt'))>0) {
         * t6sheet1.CellValue(Row,'inv_amt') = Number(ovr_dys) *
         * Number(t6sheet1.CellValue(Row,'ctrt_rt')) *
         * (Number(t6sheet1.CellValue(Row,'inv_xch_rt'))>0?Number(t6sheet1.CellValue(Row,'inv_xch_rt')):1); } }
         * else if (t6sheet1.CellValue(Row,'calc_tp_cd')=='M'){ if
         * (document.form.curr_cd.Code!=undefined &&
         * document.form.curr_cd.Code!=null && document.form.curr_cd.Code!='' &&
         * !isNaN(t6sheet1.CellValue(Row,'inv_xch_rt')) &&
         * Number(t6sheet1.CellValue(Row,'inv_xch_rt'))>0) {
         * t6sheet1.CellValue(Row,'inv_amt') = Number(ovr_dys) *
         * Number(t6sheet1.CellValue(Row,'ctrt_rt')) *
         * (Number(t6sheet1.CellValue(Row,'inv_xch_rt'))>0?Number(t6sheet1.CellValue(Row,'inv_xch_rt')):1); } }
         */
        if ((t6sheet1.GetCellValue(Row, 'cntr_tpsz_cd') != undefined && t6sheet1.GetCellValue(Row, 'cntr_tpsz_cd') != null && doSepRemove(t6sheet1.GetCellValue(Row, 'cntr_tpsz_cd'), ' ') != '') && (t6sheet1.GetCellValue(Row, 'vol_tr_ut_cd') != undefined && t6sheet1.GetCellValue(Row, 'vol_tr_ut_cd') != null && doSepRemove(t6sheet1.GetCellValue(Row, 'vol_tr_ut_cd'), ' ') != '')) {
        	var nInvAmt = t6sheet1.GetCellValue(Row, 'inv_amt') * tes_getTEUconv(t6sheet1.GetCellValue(Row, 'vol_tr_ut_cd'), t6sheet1.GetCellValue(Row, 'cntr_tpsz_cd'));
        
	        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
	        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
	        } 
            
            t6sheet1.SetCellValue(Row, 'inv_amt', nInvAmt);
        }
    }
}

/**
 * Register IBTab object on array. 
 * @param tab_obj
 * @return
 */
function setTabObject(tab_obj) {
    tabObjects[tabCnt++] = tab_obj;
    // ComShowMessage("setTabObject" + tabCnt);
}

/**
 * Initialize tab.
 * @param {tab}		tabObj		tab object
 * @param {int}		tabNo		tab index
 * @return
 */
function initTab(tabObj, tabNo) {
    // ComShowMessage("initTab - " + tabNo);
    switch (tabNo) {
        case 1:
            with(tabObj) {
                var cnt = 0;
                InsertItem("  Verification  ", "");
                InsertItem("  Discrepancy  ", "");
                InsertItem("Cost Calc.(TMNL)", "");
                InsertItem("Cost Calc.(SR by FD)", "");
                InsertItem("Cost Calc.(SR by FP)", "");
                InsertItem("Cost Calc.(SR by EQ)", "");
            }
            break;
    }
    if (!save_conf_01) {
        tabObj.enable = false;
    } else {
        tabObj.enable = true;
    }
}

/**
 * Coding event for OnChange.
 * @param {tab}		tabObj		tab object
 * @param {int}		nItem		pre tab index
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
 * Coding event for OnClick.
 * @param {tab}		tabObj		tab object
 * @param {int}		tabNo		tab index
 * @return
 */
function tab1_OnClick(tabObj, tabNo) {
    if (save_conf_01) {
        // ComShowMessage("tab1_OnClick nItem:"+tabNo);
        switch (tabNo) {
            case 2:
                setCalcTerminalManualCostCode(sheetObjects[2]);
                break;
            case 3:
                setCalcStorageManualCostCode(sheetObjects[3]);
                break;
            case 4:
                setCalcStorageManualCostCode(sheetObjects[4]);
                break;
            case 5:
                setCalcOffEqManualCostCode(sheetObjects[9]);
                break;
        }
    }
}

/**
 * Validating input value.
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {form} 	formObj		Form Object
 * @param {int}		sAction		f_cmd
 * @return
 */
function validateForm(sheetObj, formObj, sAction) {
    with(formObj) {
        // if (!isNumber(formObj.iPage)) {
        // return false;
        // }
    }
    return true;
}

/**
 * Opening report.
 * @return
 */
function printDiscrepancyContainerList() {
    var fromObj = new Array();
    var rdObj = new Array();

    fromObj[0] = document.form;
    rdObj[0] = sheetObjects[0];
    // RD_path = "http://yoo:9001/opuscntr/";
    parmObj[0] = "1";
    parmObj[1] = "";
    parmObj[2] = "N";
    parmObj[3] = RD_path + "apps/opus/esd/tes/serviceproviderinvoicemanage/offdockcyinvoicemanage/report/ESD_TES_0807.mrd";
    parmObj[4] = rdObj;
    parmObj[5] = fromObj;
    rdObjModaless(RdReport, parmObj, 1000, 700);
}

function tes_allComEnableObj0004(formObj, type) {
    formObj.reset();
    var numOfEle = formObj.elements.length;
    for (var i = 0; i < numOfEle; i++) {
        ComEnableObject(formObj.elements[i], type);
    }
    comboObjects[0].SetEnable(0);
}

/**
 * 
 * @param {form}	formObj		form object
 * @return
 */
function tes_initComp0004(formObj) {
    tes_allComEnableObj0004(formObj, false);
    ComEnableObject(formObj.vndr_seq, true);
    ComEnableObject(formObj.inv_no, true);
    formObj.vndr_seq.readOnly = false;
    formObj.inv_no.readOnly = false;
}

/**
 * Initialize screen.
 * @param {string}	YN_KEEP_KEY_VALUE		
 * @return
 */
function tes_new0004(YN_KEEP_KEY_VALUE) {
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
    setElementDiabled('checkbox', 'TMNL', 'Y');

    setElementDiabled('checkbox', 'StorageDay', 'Y');
    if (document.form.tml_odck_flg.value == 'N') { //20150430 추가
        setElementDiabled('checkbox', 'StorageDay', 'N');
    }

    setElementDiabled('radio', 'CostCalcMethod', 'Y');
    setSheetsEnable(-1, false);
    sheetObjects[0].RemoveAll();
    sheetObjects[1].RemoveAll();
    sheetObjects[2].RemoveAll();
    sheetObjects[3].RemoveAll();
    sheetObjects[4].RemoveAll();
    sheetObjects[5].RemoveAll();
    sheetObjects[6].RemoveAll();
    sheetObjects[7].RemoveAll();
    sheetObjects[8].RemoveAll();
    sheetObjects[9].RemoveAll();
    // comboObjects[0].Code = '';
    comboObjects[0].SetSelectText(def_curr_cd);
    comboObjects[0].SetSelectCode(def_curr_cd);
    comboObjects[0].SetEnable(0);
    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));

    document.form.tml_odck_flg.disabled = false;
}

/**
 * Transforming array at string.
 * @param {string}	strEleNums	
 * @return
 */
function setEleNums(strEleNums) {
    var eleNums = new Array();
    eleNums = strEleNums.split("|");
    return eleNums;
}

/**
 * Coding event for OnSearchEnd.
 * @param {sheet}	t5sheet1	Cost Calc.(SR by FP) sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t5sheet1_OnSearchEnd(t5sheet1, ErrMsg) {
    if (confirm_done) {
        disableSheetEditable(t5sheet1);
    }

    init_Arr_sht_chk();

    var formObj = document.form;

    if (t5sheet1.RowCount() > 0) {

        setPeriodReadonly('Y');

        for (var i = 1; i <= t5sheet1.RowCount(); i++) {
            if (t5sheet1.GetCellValue(i, "calc_tp_cd") == "A") {
                if (t5sheet1.GetCellValue(i, "curr_cd") != undefined && t5sheet1.GetCellValue(i, "curr_cd") != null && t5sheet1.GetCellValue(i, "curr_cd") != '' && curr_cd.Code != undefined && curr_cd.Code != null && curr_cd.Code != '' && t5sheet1.GetCellValue(i, "curr_cd") != curr_cd.GetSelectCode()) {
                    setShtCellsEditable(t5sheet1, i, 'inv_xch_rt', 'Y', 'EXCEPTION');
                }
                t5sheet1.SetCellValue(i, "calc_rmk", ComToString(t5sheet1.GetCellValue(i, "calc_rmk")));

            } else if (t5sheet1.GetCellValue(i, "calc_tp_cd") == "M") {
                setShtCellsEditable(t5sheet1, i, 'lgs_cost_cd|wrk_dt|stk_vol_qty|inv_vol_qty|diff_vol_qty|fp_teu_qty|ovr_vol_qty|vol_tr_ut_cd|ctrt_rt|inv_amt|calc_rmk|n3pty_flg|inv_xch_rt', 'Y');
                t5sheet1.SetCellValue(i, "calc_rmk", ComToString(t5sheet1.GetCellValue(i, "calc_rmk")));
            }
        }

        t5sheet1_MonthlyRowManage(t5sheet1);

        t5sheet1_ShowSubSum(t5sheet1);

        setCalcStorageManualCostCode(t5sheet1);

        t5sheet1_TotCalcAmt(t5sheet1);

        t5sheet1_ChkDifferVol2(t5sheet1);

        checkTPBdataEditable('5', t5sheet1);

    } else {
        document.form.t5sht_tot_inv_amt.value = 0;
        setPeriodReadonly('N');
    }

    chkEnableTmlOdckFlg();
}

/**
 * Coding event for OnSaveEnd.
 * @param {sheet}	t4sheet1	Cost Calc.(SR by FP) sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t5sheet1_OnSaveEnd(t5sheet1, ErrMsg) {
    if (confirm_done) {
        disableSheetEditable(t5sheet1);
    }

    init_Arr_sht_chk();

    var formObj = document.form;

    if (formObj.calcStorageComboItems.value == null || doSepRemove(formObj.calcStorageComboItems.value, ' ') == '') {
        // getCalcStorageManualCostCode();
    }

    if (t5sheet1.RowCount() > 0) {

        setPeriodReadonly('Y');

        t5sheet1_ShowSubSum(t5sheet1);

        for (var i = 1; i <= t5sheet1.RowCount(); i++) {
            if (t5sheet1.GetCellValue(i, "calc_tp_cd") == "A") {
                if (t5sheet1.GetCellValue(i, "curr_cd") != undefined && t5sheet1.GetCellValue(i, "curr_cd") != null && t5sheet1.GetCellValue(i, "curr_cd") != '' && curr_cd.Code != undefined && curr_cd.Code != null && curr_cd.Code != '' && t5sheet1.GetCellValue(i, "curr_cd") != curr_cd.GetSelectCode()) {
                    setShtCellsEditable(t5sheet1, i, 'inv_xch_rt', 'Y', 'EXCEPTION');
                }
            } else if (t5sheet1.GetCellValue(i, "calc_tp_cd") == "M") {
                setShtCellsEditable(t5sheet1, i, 'lgs_cost_cd|wrk_dt|stk_vol_qty|inv_vol_qty|diff_vol_qty|fp_teu_qty|ovr_vol_qty|vol_tr_ut_cd|ctrt_rt|inv_amt|calc_rmk|n3pty_flg|inv_xch_rt', 'Y');
            }
        }

        setCalcStorageManualCostCode(t5sheet1);

        t5sheet1_TotCalcAmt(t5sheet1);

        t5sheet1_ChkDifferVol2(t5sheet1);

        checkTPBdataEditable('5', t5sheet1);

    } else {
        document.form.t5sht_tot_inv_amt.value = 0;
        setPeriodReadonly('N');
    }

    chkEnableTmlOdckFlg();

}

/**
 * Coding event for OnChagne.
 * @param {sheet}		t4sheet1	Cost Calc.(SR by FP) sheet
 * @param {int}		Row			The cell's Row Index
 * @param {int}		Col			The cell's Column Index
 * @param {string}	Value
 * @return
 */
function t5sheet1_OnChange(t5sheet1, Row, Col, Value) {

    if (t5sheet1.GetCellValue(Row, 'calc_tp_cd') == 'M' && t5sheet1.ColSaveName(Col) == 'wrk_dt') {
        if (t5sheet1.GetCellValue(Row, 'wrk_dt') != null || doSepRemove(t5sheet1.GetCellValue(Row, 'wrk_dt'), ' ') == '') {
            t5sheet1.SetCellValue(Row, 'rev_yrmon', t5sheet1.GetCellValue(Row, 'wrk_dt').substring(0, 6));
        }
    }

    var sName = t5sheet1.ColSaveName(Col);
    if (sName == "inv_vol_qty" || sName == "fp_teu_qty" || sName == "ctrt_rt" || sName == "inv_xch_rt") {
    	t5sheet1.SetCellValue(Row, 'inv_xch_rt', Math.abs(t5sheet1.GetCellValue(Row, 'inv_xch_rt')));
        
        if (t5sheet1.GetCellValue(Row, 'inv_xch_rt') > 0) {
            t5sheet1.SetCellBackColor(Row, 'inv_xch_rt', '#000000');
        }

        t5sheet1_RecalcCalcAmt(t5sheet1, Row);
    }
    
    if (sName == "inv_amt") {
        t5sheet1_TotCalcAmt(t5sheet1);
    }
    
    t5sheet1_ShowSubSum(t5sheet1);
}

/**
 * Calculating Cost Calc.(SR by FP) sheet
 * @param {sheet}	t5sheet1	Cost Calc.(SR by FP) sheet
 * @return
 */
function t5sheet1_ShowSubSum(t5sheet1) {
    //alert('t5sheet1_ShowSubSum');

    //t5sheet1.HideSubSum();

    //t5sheet1.ShowSubSum("calc_tp_cd", "4|5|6|7|8|10|11", -1, false, false, -1, "calc_tp_cd=%s;lgs_cost_cd=TTL");

    //t5sheet1.ShowSubSum([{StdCol:"calc_tp_cd", SumCols:"4|5|6|7|8|10|11", Sort:false, ShowCumulate:false, CaptionCol:1, CaptionText:"calc_tp_cd=%s;lgs_cost_cd=TTL"}]);
    //t5sheet1.ShowSubSum([{StdCol:"calc_tp_cd", SumCols:"4", Sort:false, ShowCumulate:false, CaptionCol:1, CaptionText:"TTL"}]);
    //t5sheet1.ShowSubSum([{StdCol:"calc_tp_cd", SumCols:"4", Sort:false}]);
    //t5sheet1.HideSubSum();
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


function setCostCode(sheetObj) {
    if (sheetObj.CheckedRows("sel") < 1) {
        return;
    }
    var targetSheetObj = sheetObjectsMap['t4sheet1'];
    var idx;
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        if (!sheetObj.GetCellValue(i, "sel")) continue;
        idx = targetSheetObj.DataInsert(-1);

        targetSheetObj.CellComboItem(idx, 'lgs_cost_cd', { ComboText: document.form.calcStorageComboItems.value, ComboCode: document.form.calcStorageComboItems.value });

        targetSheetObj.SetCellValue(idx, "calc_tp_cd", sheetObj.GetCellValue(i, "calc_tp_cd"));
        targetSheetObj.SetCellValue(idx, "lgs_cost_cd", sheetObj.GetCellValue(i, "lgs_cost_cd"));
        targetSheetObj.SetCellValue(idx, "cntr_tpsz_cd", sheetObj.GetCellValue(i, "cntr_tpsz_cd"));
        targetSheetObj.SetCellValue(idx, "io_bnd_cd", sheetObj.GetCellValue(i, "io_bnd_cd"));
        targetSheetObj.SetCellValue(idx, "dcgo_ind_cd", sheetObj.GetCellValue(i, "dcgo_ind_cd"));
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

        targetSheetObj.SetCellValue(idx, 'inv_xch_rt', sheetObj.GetCellValue(i, "inv_xch_rt"));
        targetSheetObj.SetCellValue(idx, "calc_cost_grp_cd", "SD");
        targetSheetObj.SetCellValue(idx, 'semi_auto_calc_flg', 'Y');

        targetSheetObj.SetCellValue(idx, "calc_rmk", sheetObj.GetCellValue(i, "agmt_dtl_rmk"));

        setShtCellsEditable(targetSheetObj, idx, 'rev_yrmon|inv_amt', 'Y', 'EXCEPTION');
        setShtCellsEditable(targetSheetObj, idx, 'stay_dys|ctrt_rt|inv_xch_rt|free_dys|paid_day|free_dy_xcld_dys', 'N', "EXCEPTION");

        document.form.t4sht_tot_inv_amt.value = getShtTotCalcAmt(targetSheetObj, 'inv_amt');

    }
}

function setCostCode2(sheetObj) {
    if (sheetObj.CheckedRows("sel") < 1) {
        return;
    }
    var vvd_hidden = sheetObjects[4];
    //		    var vvd_row = sheetObjects[4].FindText('vvd', document.form.vvd.value+io_hidden);
    var targetSheetObj = sheetObjectsMap['t3sheet1'];
    var idx;
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        if (!sheetObj.GetCellValue(i, "sel")) continue;
        idx = targetSheetObj.DataInsert(-1);

        targetSheetObj.CellComboItem(idx, 'lgs_cost_cd', { ComboText: document.form.calcTerminalComboItems.value, ComboCode: document.form.calcTerminalComboItems.value });

        targetSheetObj.SetCellValue(idx, "calc_tp_cd", sheetObj.GetCellValue(i, "calc_tp_cd"));
        targetSheetObj.SetCellValue(idx, "lgs_cost_cd", sheetObj.GetCellValue(i, "lgs_cost_cd"));
        targetSheetObj.SetCellValue(idx, "cntr_tpsz_cd", sheetObj.GetCellValue(i, "cntr_tpsz_cd"));
        //			    targetSheetObj.SetCellValue(idx,"io_bnd_cd")       =  io_hidden;      

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
        targetSheetObj.SetCellValue(idx, "vol_tr_ut_cd", sheetObj.GetCellValue(i, "vol_tr_ut_cd"));
        targetSheetObj.SetCellValue(idx, "ctrt_rt", sheetObj.GetCellValue(i, "ctrt_rt"));
        targetSheetObj.SetCellValue(idx, "inv_amt", sheetObj.GetCellValue(i, "inv_amt"));
        targetSheetObj.SetCellValue(idx, "curr_cd", sheetObj.GetCellValue(i, "curr_cd"));
        targetSheetObj.SetCellValue(idx, "tml_crr_cd", '');
        targetSheetObj.SetCellValue(idx, 'calc_cost_grp_cd', 'TM');
        targetSheetObj.SetCellValue(idx, 'inv_xch_rt', sheetObj.GetCellValue(i, "inv_xch_rt"));
        targetSheetObj.SetCellValue(idx, 'semi_auto_calc_flg', 'Y');

        targetSheetObj.SetCellValue(idx, "calc_rmk", sheetObj.GetCellValue(i, "agmt_dtl_rmk"));
        //targetSheetObj.SetCellValue(idx,'vsl_cd')           = vvd_hidden.GetCellValue(vvd_row, 'vvd_vsl_cd');
        //targetSheetObj.SetCellValue(idx,'skd_voy_no')       = vvd_hidden.GetCellValue(vvd_row, 'vvd_skd_voy_no');
        //targetSheetObj.SetCellValue(idx,'skd_dir_cd')       = vvd_hidden.GetCellValue(vvd_row, 'vvd_skd_dir_cd');
        //targetSheetObj.SetCellValue(idx,'atb_dt')           = vvd_hidden.GetCellValue(vvd_row, 'vvd_atb_dt');

        setShtCellsEditable(targetSheetObj, idx, 'rev_yrmon|cntr_tpsz_cd|dcgo_ind_cd|tml_wrk_dy_cd|ioc_cd|tml_trns_mod_cd|lane_cd|vol_tr_ut_cd|inv_amt|rc_flg', 'Y', 'EXCEPTION');
        setShtCellsEditable(targetSheetObj, idx, 'ctrt_rt|calc_vol_qty|inv_xch_rt', 'N', 'EXCEPTION');
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
    var targetSheetObj = sheetObjectsMap['t6sheet1'];
    var idx;
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        if (!sheetObj.GetCellValue(i, "sel")) continue;
        idx = targetSheetObj.DataInsert(-1);

        // targetSheetObj.CellComboItem(idx,'eq_tpsz_cd', {ComboText:EQ_TPSZ_CD, ComboCode:EQ_TPSZ_CD} );
        targetSheetObj.CellComboItem(idx, 'lgs_cost_cd', { ComboText: document.form.calcOffEqComboItems.value, ComboCode: document.form.calcOffEqComboItems.value });

        targetSheetObj.SetCellValue(idx, "calc_tp_cd", sheetObj.GetCellValue(i, "calc_tp_cd"));
        targetSheetObj.SetCellValue(idx, "lgs_cost_cd", sheetObj.GetCellValue(i, "lgs_cost_cd"));
        targetSheetObj.SetCellValue(idx, "eq_tpsz_cd", sheetObj.GetCellValue(i, "cntr_tpsz_cd"));
        targetSheetObj.SetCellValue(idx, "io_bnd_cd", sheetObj.GetCellValue(i, "io_bnd_cd"));
        targetSheetObj.SetCellValue(idx, "dcgo_ind_cd", sheetObj.GetCellValue(i, "dcgo_ind_cd"));
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

        targetSheetObj.SetCellValue(idx, 'inv_xch_rt', sheetObj.GetCellValue(i, "inv_xch_rt"));
        targetSheetObj.SetCellValue(idx, "calc_cost_grp_cd", "EQ");
        targetSheetObj.SetCellValue(idx, 'semi_auto_calc_flg', 'Y');

        targetSheetObj.SetCellValue(idx, "calc_rmk", sheetObj.GetCellValue(i, "agmt_dtl_rmk"));

        setShtCellsEditable(targetSheetObj, idx, 'rev_yrmon|inv_amt', 'Y', 'EXCEPTION');
        setShtCellsEditable(targetSheetObj, idx, 'stay_dys|ctrt_rt|inv_xch_rt|free_dys|paid_day|free_dy_xcld_dys', 'N', "EXCEPTION");

        document.form.t6sht_tot_inv_amt.value = getShtTotCalcAmt(targetSheetObj, 'inv_amt');

    }
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
        
        if(!getInvDupYN()){ // Invoice Duplicate YN     tes_getInputValue('is_dup_inv_no', SEARCH21, 'inv_no|vndr_seq', 'checkInvDup');
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
 * Show bottom(total, summary)
 * @return
 */
function showSummary() {
    var div01 = document.all.SearchLayer01.style.display;
    var div02 = document.all.SearchLayer02.style.display;
    var obj = ComGetEvent();
    if (div01 == "inline") {
        //		obj.class="btn_down";
        $("#btnhide").removeClass("btn_up").addClass("btn_down");
        document.all.SearchLayer01.style.display = "none";
        document.all.SearchLayer02.style.display = "none";
    } else {
        //		obj.class="btn_up";
        $("#btnhide").removeClass("btn_down").addClass("btn_up");
        document.all.SearchLayer01.style.display = "inline";
        document.all.SearchLayer02.style.display = "inline";
    }
}

/**
 * Setting hld_rmk.
 * @return
 */
function setHldRmk() {
    var formObj = document.form;
    if (formObj.hld_flg.checked == false) {
        formObj.hld_rmk.value = '';
    }
}

/**
 * comparing Agreement and so header currency code.
 * @return
 */
function validateAgmtCurrCD() {
    document.form.agmtCurrCd.value =  getAgmtCurrCd();      // tes_getInputValueInvoice('agmtCurrCd', SEARCH01, 'tml_inv_tp_cd|yd_cd|vndr_seq|to_prd_dt', '');
}

/**
 * Checking currency codes.
 * @return
 */
function isValidAgmtCurrCD() {
    var formObj = document.form;
    // ComShowMessage(formObj.agmtCurrCd.value + ' / ' + formObj.curr_cd.Code);
    if (curr_cd.GetSelectCode() == null || doSepRemove(curr_cd.GetSelectCode(), ' ') == '') {
        ComShowMessage(ComGetMsg('TES40039'));
        return false;
    }
    if (curr_cd.GetSelectCode() != main_hidden.GetCellValue(1, 'curr_cd')) {
        ComShowMessage(ComGetMsg('TES40040'));
        return false;
    }
    if (formObj.to_prd_dt.value == null || doSepRemove(formObj.to_prd_dt.value, ' ') == '') {
        ComShowMessage(ComGetMsg('TES40038'));
        return false;
    }
    if (formObj.to_prd_dt.value != main_hidden.GetCellValue(1, 'to_prd_dt')) {
        ComShowMessage(ComGetMsg('TES40037'));
        return false;
    }
    if (formObj.agmtCurrCd.value == null || doSepRemove(formObj.agmtCurrCd.value, ' ') == '') {
        ComShowMessage(ComGetMsg('TES40030'));
        document.form.agmtCurrCd.value =  getAgmtCurrCd();      // tes_getInputValueInvoice('agmtCurrCd', SEARCH01, 'tml_inv_tp_cd|yd_cd|vndr_seq|to_prd_dt', '');       
        return false;
    } else {
        if (doSepRemove(formObj.agmtCurrCd.value, ' ') != doSepRemove(curr_cd.GetSelectCode(), ' ')) {
            return false;
        }
    }
    return true;
}

/**
 * Get agreement's status.
 * @return
 */
function validateAgmtSts() {
    document.form.agmtSts.value = getAgmtStatusCd(); // tes_getInputValueInvoice('agmtSts', SEARCH04, 'tml_inv_tp_cd|yd_cd|vndr_seq|to_prd_dt', '');
}

/**
 * Validating agreement status.
 * @return {boolean} 
 */
function isValidAgmtSts() {
    var formObj = document.form;
    var tmp = '';
    tmp = formObj.agmtSts.value;
    if (tmp != undefined && tmp != null && doSepRemove(tmp, ' ') != '') {
        tmp = tmp.split('|');
        if (tmp.length > 0) {
            if (tmp[0] != null && !isNaN(tmp[0])) {
                if (parseInt(tmp[0]) > 0) {
                    if (tmp[1] != undefined && tmp[1] != null) {
                        if (doSepRemove(tmp[1], ' ') == 'C') {
                            return true;
                        } else if (doSepRemove(tmp[1], ' ') == 'P') {
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
                    ComShowMessage(ComGetMsg('TES22030'));
                    return false;
                }
            } else {
                ComShowMessage(ComGetMsg('TES22030'));
                return false;
            }
        } else {
            ComShowMessage(ComGetMsg('TES22030'));
            return false;
        }
    } else {
        ComShowMessage(ComGetMsg('TES22030'));
        return false;
    }
    return true;
}

/**
 * Validating Error Inv. No.
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
 * Validating Cost OFC and get Cost OFC Code.
 * @return
 */
function validateCostOFC() {
    var formObj = document.form;
    if (formObj.cost_ofc_cd.value == null || doSepRemove(formObj.cost_ofc_cd.value, ' ') == '') {
        formObj.cost_ofc_cd_hidden.value = "";
        formObj.is_valid_cost_ofc_cd.value = "";
        return false;
    }
    
    if (formObj.cost_ofc_cd.readOnly == false) {
        if ((formObj.cost_ofc_cd_hidden.value == null || doSepRemove(formObj.cost_ofc_cd_hidden.value, ' ') == '') || formObj.cost_ofc_cd.value != doSepRemove(formObj.cost_ofc_cd_hidden.value, ' ')) {
            formObj.cost_ofc_cd_hidden.value = "";
            formObj.is_valid_cost_ofc_cd.value = "";
            
            if(getCostOfcValidYN()){  // tes_getInputValue('is_valid_cost_ofc_cd', SEARCH04, 'cost_ofc_cd|yd_cd', 'checkValidCostOfc');
            	formObj.is_valid_cost_ofc_cd.value = "Y";
            } 
        }
    }
}

/**
 * Validating Yard Code and get Yard Code
 * @return
 */
function validateYardCode() {
    var formObj = document.form;
//    if (formObj.yd_cd.value == null || doSepRemove(formObj.yd_cd.value, ' ') == '') {
//        formObj.yd_cd_hidden.value = '';
//        formObj.is_valid_yd_cd.value = '';
//        return false;
//    }
    // if ((formObj.yd_cd_hidden.value == null || doSepRemove(formObj.yd_cd_hidden.value, ' ') == '') || doSepRemove(formObj.yd_cd.value, ' ') != doSepRemove(formObj.yd_cd_hidden.value, ' ')) {
        formObj.is_valid_yd_cd.value = '';
        
        var rtnVal = getYdCdCostCdList(); // tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');           
        if(rtnVal.length > 0){
        	checkValidYardCode(rtnVal);
        }  
    //}
}

/**
 * Validating S/P Code and get S/P Name.
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
        
        //doActionMainHiddenSheet(sheetObjects[5], formObj, IBSEARCH_ASYNC05);
        //tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVndrCode');
    }
}

/**
 * Setting Cost OFC.
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
 * Validating Error Inv. No.
 * @return
 */
function checkValidErrInvNo() {
    var formObj = document.form;
    // ComShowMessage('checkValidErrInvNo -
    // is_valid_err_inv_no:'+formObj.is_valid_err_inv_no.value);
    if (formObj.is_valid_err_inv_no.value != undefined && formObj.is_valid_err_inv_no.value != null && doSepRemove(formObj.is_valid_err_inv_no.value, ' ') == 'Y') {} else {
        formObj.is_valid_err_inv_no.value = '';
        ComShowMessage(ComGetMsg('TES40058', 'ERR INV.NO'));
    }
}

/**
 * Validating Cost OFC.
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
                if (tmp[1] != undefined && tmp[1] != null && doSepRemove(tmp[1], ' ') != '') {
                    if (doSepRemove(tmp[1], ' ') != 'Y') {
                        ComShowMessage(ComGetMsg('TES21036'));
                        // formObj.yd_cd.focus();
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
 * Validating Yard Code.
 * @return
 */
function checkValidYardCode2() {
    checkValidYardCode('NEW2');
}

/**
 * Validating Yard Code.
 * @return
 */
function checkValidYardCode(type) {
    var formObj = document.form;
    var tmp = '';
    var tmp_yd_cd_hidden = '';
    if (type != undefined && type != null && doSepRemove(type, ' ') != '') {
        tmp = type.split('--');
        groval_tmp = formObj.is_valid_yd_cd.value.split('--');
        if (tmp.length > 0) {
            formObj.is_valid_yd_cd.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_yd_cd.value != null && formObj.is_valid_yd_cd.value == 'Y') {
                if (formObj.yd_cd.value != null && doSepRemove(formObj.yd_cd.value, ' ') != '' && formObj.yd_cd_hidden.value != formObj.yd_cd.value) {
                    if (sheetObjects[5].RowCount() > 0 && doSepRemove(formObj.yd_cd.value, ' ') != doSepRemove(sheetObjects[5].GetCellValue(1, 'yd_cd'), ' ') && (sheetObjects[0].RowCount() > 0 || sheetObjects[1].RowCount() > 0 || sheetObjects[2].RowCount() > 0 || sheetObjects[3].RowCount() > 0 || sheetObjects[4].RowCount() > 0 || sheetObjects[9].RowCount() > 0)) {
                        if (!confirm(ComGetMsg('TES23062'))) {
                            formObj.yd_cd.value = formObj.yd_cd_hidden.value;
                            return false;
                        } else {
                            ComShowMessage(ComGetMsg('TES23004'));
                            removeOffdockCYInvoice01();
                            removeOffdockCYInvoice02();
                        }
                    }
                }
                tmp_yd_cd_hidden = formObj.yd_cd_hidden.value;
                formObj.yd_cd_hidden.value = formObj.yd_cd.value;
                //				formObj.yd_nm.value=(tmp[2] != undefined && tmp[2] != null ? tmp[2] : '');
                formObj.yd_chr_cd.value = (tmp[3] != undefined && tmp[3] != null ? tmp[3] : '');
                formObj.yd_fcty_tp_mrn_tml_flg.value = (tmp[4] != undefined && tmp[4] != null ? tmp[4] : '');
                formObj.yd_fcty_tp_cy_flg.value = (tmp[5] != undefined && tmp[5] != null ? tmp[5] : '');
                formObj.yd_fcty_tp_cfs_flg.value = (tmp[6] != undefined && tmp[6] != null ? tmp[6] : '');
                formObj.yd_fcty_tp_rail_rmp_flg.value = (tmp[7] != undefined && tmp[7] != null ? tmp[7] : '');
                formObj.yd_oshp_cd.value = (tmp[8] != undefined && tmp[8] != null ? tmp[8] : '');

                formObj.calcOffEqComboItems.value = (tmp[15] != undefined && tmp[15] != null ? tmp[15] : '');

                if (formObj.tml_odck_flg.value == "Y") { //On Duck
                    formObj.calcTerminalComboItems.value = (tmp[9] != undefined && tmp[9] != null ? tmp[9] : '');
                } else { //Off Duck
                    formObj.calcTerminalComboItems.value = (tmp[11] != undefined && tmp[11] != null ? tmp[11] : '');
                }

                formObj.calcStorageComboItems.value = (tmp[12] != undefined && tmp[12] != null ? tmp[12] : '');
                var rtnOfcCd = "";
                
                //if (sheetObjects[5].RowCount() == 0 || ((formObj.yd_cd != undefined && formObj.yd_cd.value != null && formObj.yd_cd.value != '' && tmp_yd_cd_hidden != undefined && tmp_yd_cd_hidden != null && tmp_yd_cd_hidden != '' && formObj.yd_cd.value != tmp_yd_cd_hidden) || (formObj.cost_ofc_cd_hidden != undefined && formObj.cost_ofc_cd_hidden.value != null && formObj.cost_ofc_cd_hidden.value != '' && formObj.cost_ofc_cd != undefined && formObj.cost_ofc_cd.value != null && formObj.cost_ofc_cd.value != '' && formObj.cost_ofc_cd_hidden.value != formObj.cost_ofc_cd.value))) {                
                    rtnOfcCd = getOfcCdByYardCd(); //tes_getInputValue('cost_ofc_cd', SEARCH02, 'yd_cd', 'setCostOfcReadOnlyFalse'); 
                    setCostOfcReadOnlyFalse(rtnOfcCd);                    
                //} else {
                    //setCostOfcReadOnlyFalse(rtnOfcCd);
                //}
                if (type != undefined && type != null && type != '' && type == 'NEW2') {
                    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("cost_ofc_cd|vndr_seq|inv_no"));
                } else {
                    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
                }
                if (sheetObjects[2].RowCount() > 0) {
                    setCalcTerminalManualCostCode(sheetObjects[2]);
                }
                if (sheetObjects[3].RowCount() > 0) {
                    setCalcStorageManualCostCode(sheetObjects[3]);
                }
                if (sheetObjects[4].RowCount() > 0) {
                    setCalcStorageManualCostCode(sheetObjects[4]);
                }
                if (sheetObjects[9].RowCount() > 0) {
                    setCalcOffEqManualCostCode(sheetObjects[9]);
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
 * Validating S/P Code.
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
                //				formObj.vndr_seq_nm.value=(tmp[1] != undefined && tmp[1] != null ? tmp[1] : '');
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

function chkEqNo(rtnVal) {
    var formObj = document.form;

    if (rtnVal != undefined && rtnVal != "undefined" && rtnVal != null && doSepRemove(rtnVal, ' ') != '') {

        var arrEqTpszCd = rtnVal.split("\\");
        if (arrEqTpszCd[1] == sheetObjects[9].GetCellValue(tmp_row, "eq_knd_cd")) {
            sheetObjects[9].SetCellValue(tmp_row, "eq_tpsz_cd", arrEqTpszCd[0]);

        } else {
            if (arrEqTpszCd[1] == 'G') { //
                alert("Please input the number of Chassis EQ.");
                t6sheet1.SetCellValue(tmp_row, 'eq_no', "");
                sheetObjects[9].SelectCell(tmp_row, "eq_no", 1);
                t6sheet1.SetCellValue(tmp_row, 'eq_tpsz_cd', "CH2");

            } else { //
                alert("Please input the number of Genset EQ.");
                t6sheet1.SetCellValue(tmp_row, 'eq_no', "");
                sheetObjects[9].SelectCell(tmp_row, "eq_no", 1);
                t6sheet1.SetCellValue(tmp_row, 'eq_tpsz_cd', "CLG");

            }
        }

        arrEqTpszCd[0] = "";
        arrEqTpszCd[1] = "";

    } else {
        //		ComShowMessage(ComGetMsg('TES24006','EQ No'));
        alert("This EQ No. is invalid.");
        t6sheet1.SetCellValue(tmp_row, 'eq_no', "");
        sheetObjects[9].SelectCell(tmp_row, "eq_no", 1);
    }

    formObj.tmp_eq_tpsz_cd.value = "";
    searchEQFlag = false;
    document.form.eq_no.value = "";
}

/**
 * Setting common code.
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
            OT_A_LGS_COST_CD = tmp[3] + "|TMNDFL|TMNDMT|TMNDTS|SVSSFL|SVSSMT|SVSSTS|SVSSTM";
            OS_A_LGS_COST_CD = tmp[4];
            EQ_TPSZ_CD = tmp[7];
        }
    }
    sheetObjects[1].SetColProperty("cntr_tpsz_cd", { ComboText: CNTR_TPSZ_CD, ComboCode: CNTR_TPSZ_CD });
    sheetObjects[2].SetColProperty("cntr_tpsz_cd", { ComboText: CNTR_TPSZ_CD, ComboCode: CNTR_TPSZ_CD });
    sheetObjects[2].SetColProperty("lgs_cost_cd", { ComboText: OT_A_LGS_COST_CD, ComboCode: OT_A_LGS_COST_CD });
    sheetObjects[3].SetColProperty("cntr_tpsz_cd", { ComboText: CNTR_TPSZ_CD, ComboCode: CNTR_TPSZ_CD });
    sheetObjects[3].SetColProperty("lgs_cost_cd", { ComboText: OS_A_LGS_COST_CD, ComboCode: OS_A_LGS_COST_CD });
    sheetObjects[4].SetColProperty("lgs_cost_cd", { ComboText: OS_A_LGS_COST_CD, ComboCode: OS_A_LGS_COST_CD });
    sheetObjects[9].SetColProperty("eq_tpsz_cd", { ComboText: EQ_TPSZ_CD, ComboCode: EQ_TPSZ_CD });
    var formObj = document.form;
    if (!ComIsNull(formObj.inv_no_tmp.value)) {
        formObj.inv_no.value = formObj.inv_no_tmp.value;
        formObj.vndr_seq.value = vndr_seq;
        retrieve('Y');
    }
}

/**
 * Controlling S/P Code and Inv. No. readonly attribute.
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
}

/**
 * Controlling Period readonly attribute.
 * @param READONLY_YN
 * @return
 */
function setPeriodReadonly(READONLY_YN) {
    var formObj = document.form;
    if (READONLY_YN != undefined && READONLY_YN != null && doSepRemove(READONLY_YN, ' ') == 'Y') {
        formObj.fm_prd_dt.readOnly = true;
        formObj.to_prd_dt.readOnly = true;
    } else {
        formObj.fm_prd_dt.readOnly = false;
        formObj.to_prd_dt.readOnly = false;
    }
}

/**
 * Calculated AMT calculate
 * @param 	{sheet}	sheetObj			ibsheet
 * @param 	{string}colnm				column name
 * @return	{int}	tot_inv_amt_val		Calculated AMT
 */
function getShtTotCalcAmt(sheetObj, colnm) {
    var tot_inv_amt_val = 0;
    // for (var i=1; i<sheetObj.Rows; i++)
    for (var i = sheetObj.HeaderRows(); i < (sheetObj.HeaderRows() + sheetObj.RowCount()); i++) {
        if (sheetObj.GetRowSumable(i) == 1 && sheetObj.GetCellValue(i, colnm) != null && sheetObj.GetCellValue(i, colnm) != '' && sheetObj.GetCellValue(i, colnm) != undefined && !isNaN(parseFloat(sheetObj.GetCellValue(i, colnm))) && sheetObj.GetCellValue(i, 'ibflag') != 'D') {
            // tot_inv_amt_val = Number(tot_inv_amt_val) +
            // Number(parseFloat(sheetObj.GetCellValue(i,colnm)));
            tot_inv_amt_val = Number(tot_inv_amt_val) + Number(sheetObj.GetCellValue(i, colnm));
            result1 = Math.round(Number(tot_inv_amt_val) * 1000) / 1000 + Math.round(Number(sheetObj.GetCellValue(i, colnm)) * 1000) / 1000;
        }
    }
    tot_inv_amt_val = Math.round(Number(tot_inv_amt_val) * 1000) / 1000;
    tot_inv_amt_val = tes_chkAmtFmt(tot_inv_amt_val, curr_cd.GetSelectCode());
    return tot_inv_amt_val;
}

/**
 * Setting editable to each cell.
 * @param {sheet}		sheetObj	ibsheet
 * @param {int}		rownum		add row number
 * @param {string}		colnms		column name
 * @param {string}		to_sts		Y or N
 * @param {string}		EXCEPTION	
 * @return
 */
function setShtCellsEditable(sheetObj, rownum, colnms, to_sts, EXCEPTION) {
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
 * When completing input, row is disabled.
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
        sheetObj.SetCellEditable(rownum, arr_colnms[i], (to_sts != null && to_sts == 'Y' ? true : false));
    }
}

/**
 * Set calculating result on sheet bottom.
 * @return
 */
function setCoinShtStat() {
    var formObj = document.form;
    // Initialize.
    formObj.sht_01_ttl_box.value = 0;
    formObj.sht_01_full.value = 0;
    formObj.sht_01_mt.value = 0;
    formObj.sht_01_ts_same_yard.value = 0;
    formObj.sht_01_D2.value = 0;
    formObj.sht_01_D2.value = 0;
    formObj.sht_01_D4.value = 0;
    formObj.sht_01_D5.value = 0;
    formObj.sht_01_D7.value = 0;
    formObj.sht_01_D8.value = 0;
    formObj.sht_01_D9.value = 0;
    //	formObj.sht_01_DW.value=0;
    //	formObj.sht_01_DX.value=0;
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
    formObj.sht_01_ttl_box.value = sheetObjects[0].RowCount(); // total count.
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
            } catch (e) {}
        }
        if (sheetObjects[0].GetCellValue(i, "sam_locl_ts_ind_cd") != undefined && sheetObjects[0].GetCellValue(i, "sam_locl_ts_ind_cd") != null && sheetObjects[0].GetCellValue(i, "sam_locl_ts_ind_cd") != '') {
            try {
                with(formObj) {
                    if (sheetObjects[0].GetCellValue(i, "sam_locl_ts_ind_cd") == 'T') {
                        sht_01_ts_same_yard.value++;
                    }
                }
            } catch (e) {}
        }
    }
    // Get Type/Size code count.
    for (var i = 1; i <= sheetObjects[0].RowCount(); i++) {
        if (sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") != undefined && sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") != null && sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") != '') {
            try {
                with(formObj) {
                    eval('sht_01_' + sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd")).value++;
                }
            } catch (e) {}
        }
    }
}

/**
 * Removing component's values.
 * @return
 */
function initCoinShtStat() {
    var formObj = document.form;
    var numOfEle = formObj.elements.length;
    for (var i = 0; i < numOfEle; i++) {
        if (formObj.elements[i].name.length >= 6 && formObj.elements[i].name.substring(0, 6) == 'sht_01') {
            formObj.elements[i].value = '';
        }
    }
}

/**
 * Setting Total AMT.
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
 * reject
 * @return
 */
function rjctInv() {
    var formObj = document.form;
    formObj.tml_inv_rjct_sts_cd.value = 'RJ';
    formObj.tml_inv_rjct_sts_cd.title = tes_getInvRejectStsFullNm('RJ');
    doActionRejectHiddenSheet(sheetObjects[6], formObj, IBSAVE);
}

/**
 * Setting editable.
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
    comboObjects[0].SetEnable(1);
    checkWhldTaxAmtMode();
    setElementDiabled('checkbox', 'hld_flg', 'N');
    setElementDiabled('checkbox', 'TMNL', 'N');
    setElementDiabled('checkbox', 'StorageDay', 'N');
    if (document.form.tml_odck_flg.value == 'N') { //20150430 추가
        setElementDiabled('checkbox', 'StorageDay', 'N');
    }

    setElementDiabled('radio', 'CostCalcMethod', 'N');
    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
}

/**
 * Setting not editable.
 * @return
 */
function disableForm() {
    var formObj = document.form;
    setHeaderKeyValueReadonly('N');
    formObj.reset();
    formObj.yd_cd.readOnly = true;
    formObj.vndr_seq_nm.readOnly = true;
    formObj.cost_ofc_cd.readOnly = true;
    formObj.fm_prd_dt.readOnly = true;
    formObj.to_prd_dt.readOnly = true;
    formObj.iss_dt.readOnly = true;
    formObj.ttl_inv_amt.readOnly = true;
    formObj.rcv_dt.readOnly = true;
    formObj.vat_amt.readOnly = true;
    formObj.err_inv_no.readOnly = true;
    formObj.whld_tax_amt.readOnly = true;
    comboObjects[0].SetEnable(0);
    setElementDiabled('checkbox', 'hld_flg', 'Y');
    setElementDiabled('checkbox', 'TMNL', 'Y');
    setElementDiabled('checkbox', 'StorageDay', 'Y');
    setElementDiabled('radio', 'CostCalcMethod', 'Y');
    //	tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
}

/**
 * Setting editable. 
 * @param {string}	YN_KEEP_KEY_VALUE
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
        comboObjects[0].SetSelectText((temp_curr_cd != null && temp_curr_cd != '') ? temp_curr_cd : def_curr_cd);
        comboObjects[0].SetSelectCode((temp_curr_cd != null && temp_curr_cd != '') ? temp_curr_cd : def_curr_cd);
        formObj.iss_dt.value = temp_iss_dt;
        formObj.rcv_dt.value = temp_rcv_dt;
        if (formObj.yd_cd.value != null && formObj.yd_cd.value != '') {
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
    formObj.err_inv_no.readOnly = false;
    comboObjects[0].SetEnable(1);
    checkWhldTaxAmtMode();
    setElementDiabled('checkbox', 'hld_flg', 'N');
    setElementDiabled('checkbox', 'TMNL', 'N');
    setElementDiabled('checkbox', 'StorageDay', 'N');
    if (document.form.tml_odck_flg.value == 'N') { //20150430 추가
        setElementDiabled('checkbox', 'StorageDay', 'N');
    }

    setElementDiabled('radio', 'CostCalcMethod', 'N');
    setSheetsEnable(-1, false);
    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
}

/**
 * Setting not editable. 
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
    setElementDiabled('checkbox', 'TMNL', 'Y');
    setElementDiabled('checkbox', 'StorageDay', 'Y');
    setElementDiabled('radio', 'CostCalcMethod', 'Y');
    setSheetsEnable(-1, false);
    sheetObjects[0].RemoveAll();
    sheetObjects[1].RemoveAll();
    sheetObjects[2].RemoveAll();
    sheetObjects[3].RemoveAll();
    sheetObjects[4].RemoveAll();
    sheetObjects[5].RemoveAll();
    sheetObjects[6].RemoveAll();
    sheetObjects[7].RemoveAll();
    sheetObjects[8].RemoveAll();
    // comboObjects[0].Code = '';
    comboObjects[0].SetSelectText(def_curr_cd);
    comboObjects[0].SetSelectCode(def_curr_cd);
    comboObjects[0].SetEnable(0);
    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
}

/**
 * button event.
 * Removing values.
 * Setting not editable. 
 * @return
 */
function disablePage2() {
    var formObj = document.form;
    var temp_vndr_seq = '';
    var temp_vndr_seq_nm = '';
    var temp_is_valid_vndr_seq = '';
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
    comboObjects[0].SetSelectCode((temp_curr_cd != null && temp_curr_cd != '') ? temp_curr_cd : def_curr_cd);
    comboObjects[0].SetSelectText((temp_curr_cd != null && temp_curr_cd != '') ? temp_curr_cd : def_curr_cd);
    comboObjects[0].SetEnable(0);
    formObj.iss_dt.value = temp_iss_dt;
    formObj.rcv_dt.value = temp_rcv_dt;
    if (formObj.yd_cd.value != null && formObj.yd_cd.value != '') {
        var rtnVal = getYdCdCostCdList(); // tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', "checkValidYardCode2");           
        if(rtnVal.length > 0){
        	checkValidYardCode2();
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
    setElementDiabled('checkbox', 'TMNL', 'Y');
    setElementDiabled('checkbox', 'StorageDay', 'Y');
    setElementDiabled('radio', 'CostCalcMethod', 'Y');
    setSheetsEnable(-1, false);
    sheetObjects[0].RemoveAll();
    sheetObjects[1].RemoveAll();
    sheetObjects[2].RemoveAll();
    sheetObjects[3].RemoveAll();
    sheetObjects[4].RemoveAll();
    sheetObjects[5].RemoveAll();
    sheetObjects[6].RemoveAll();
    sheetObjects[7].RemoveAll();
    sheetObjects[8].RemoveAll();
    sheetObjects[9].RemoveAll();
    formObj.inv_no.focus();
    //tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt|inv_no"));
}

/**
 * After rejected, removing all data on screen.
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
    formObj.whld_tax_amt.readOnly = true;
    setElementDiabled('checkbox', 'hld_flg', 'Y');
    setElementDiabled('checkbox', 'TMNL', 'Y');
    setElementDiabled('checkbox', 'StorageDay', 'Y');
    setElementDiabled('radio', 'CostCalcMethod', 'Y');
    setSheetsEnable(-1, false);
    sheetObjects[0].RemoveAll();
    sheetObjects[1].RemoveAll();
    sheetObjects[2].RemoveAll();
    sheetObjects[3].RemoveAll();
    sheetObjects[4].RemoveAll();
    sheetObjects[5].RemoveAll();
    sheetObjects[7].RemoveAll();
    sheetObjects[8].RemoveAll();
    sheetObjects[9].RemoveAll();
    comboObjects[0].SetSelectText('');
    comboObjects[0].SetSelectCode('');
    comboObjects[0].SetEnable(0);
    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
}

/**
 * Setting readOnly.
 * @return
 */
function disableAftConf() {
    var formObj = document.form;
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
    comboObjects[0].SetEnable(0);
    setElementDiabled('checkbox', 'hld_flg', 'Y');
    setElementDiabled('checkbox', 'TMNL', 'Y');
    setElementDiabled('checkbox', 'StorageDay', 'Y');
    setElementDiabled('radio', 'CostCalcMethod', 'Y');
    disableSheetEditable(sheetObjects[0]);
    disableSheetEditable(sheetObjects[1]);
    disableSheetEditable(sheetObjects[2]);
    disableSheetEditable(sheetObjects[3]);
    disableSheetEditable(sheetObjects[4]);
    disableSheetEditable(sheetObjects[9]);
    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
}

/**
 * Changing editable to sheet.
 * @param sheet
 * @return
 */
function disableSheetEditable(sheet) {
    for (var i = 1; sheet != null && i <= sheet.Rows; i++) {
        sheet.SetRowEditable(i, 0);
    }
}

/**
 * When completing input, row is disable.
 * @param {int}		sheet_idx	sheet index
 * @param {sheet}	sheet		ibsheet
 * @param {int}		row_num		sheet rownum
 * @return
 */
function disableTPBrow(sheet_idx, sheet, row_num) {
    if (sheet_idx != null && sheet != null) {
        if (sheet.GetCellValue(row_num, 'n3pty_flg') != undefined && sheet.GetCellValue(row_num, 'n3pty_flg') == 'Y') {
            if (sheet_idx == '3') {
                setShtCellsEditable2(sheet, row_num, 'lgs_cost_cd|inv_xch_rt|calc_vol_qty|rvis_vol_qty|ctrt_rt|inv_amt', 'N');
            } else if (sheet_idx == '4') {
                setShtCellsEditable2(sheet, row_num, 'lgs_cost_cd|inv_xch_rt|stay_dys||free_dys|paid_day|free_dy_xcld_dys|ovr_dys|ctrt_rt|inv_amt', 'N');
            } else if (sheet_idx == '5') {
                setShtCellsEditable2(sheet, row_num, 'lgs_cost_cd|ovr_vol_qty|stk_vol_qty|diff_vol_qty|inv_vol_qty|fp_teu_qty|inv_vol_qty|fp_teu_qty|ctrt_rt|inv_xch_rt', 'N');
            } else if (sheet_idx == '6') {
                setShtCellsEditable2(sheet, row_num, 'lgs_cost_cd|inv_xch_rt|stay_dys||free_dys|paid_day|free_dy_xcld_dys|ovr_dys|ctrt_rt|inv_amt', 'N');
            }
        }
    }
}

/**
 * When is exist TPB I/F data, it is disable.
 * @param {int}		sheet_idx	sheet index
 * @param {sheet}	sheet		ibsheet
 * @return
 */
function checkTPBdataEditable(sheet_idx, sheet) {
    for (var i = sheet.HeaderRows(); sheet_idx != null && sheet != null && i < (sheet.HeaderRows() + sheet.RowCount()); i++) {
        if (sheet.GetCellValue(i, 'n3pty_flg') != null && sheet.GetCellValue(i, 'n3pty_flg') == 'Y') {
            // sheet.CellEditable(i,'lgs_cost_cd') = false;
            // sheet.RowEditable(i) = false;
            // sheet.CellEditable(i,'n3pty_flg') = true;
            if (sheet_idx == '3') {
                setShtCellsEditable2(sheet, i, 'inv_xch_rt|calc_vol_qty|rvis_vol_qty|ctrt_rt|inv_amt', 'N');
            } else if (sheet_idx == '4') {
                setShtCellsEditable2(sheet, i, 'inv_xch_rt|stay_dys||free_dys|paid_day|free_dy_xcld_dys|ovr_dys|ctrt_rt|inv_amt', 'N');
            } else if (sheet_idx == '5') {
                setShtCellsEditable2(sheet, i, 'ovr_vol_qty||inv_vol_qty||fp_teu_qty||inv_vol_qty|fp_teu_qty|ctrt_rt|inv_xch_rt', 'N');
            } else if (sheet_idx == '10') {
                setShtCellsEditable2(sheet, i, 'ovr_vol_qty||inv_vol_qty||fp_teu_qty||inv_vol_qty|fp_teu_qty|ctrt_rt|inv_xch_rt', 'N');
            }
        } else {
            if (sheet.GetCellValue(i, "calc_tp_cd") == "M") {
                sheet.SetCellEditable(i, 'lgs_cost_cd', 1);
            } else {
                sheet.SetCellEditable(i, 'lgs_cost_cd', 0);
            }
        }
    }
}

/**
 * Setting active/inactive to sheet(tab).
 * @param {int}		to_sht_idx		sheet index
 * @param {boolean}	ENABLE_SHEETS	
 * @return
 */
function setSheetsEnable(to_sht_idx, ENABLE_SHEETS) {
    if (!ENABLE_SHEETS) {
        tabObjects[0].enable = false;
        return false;
    }
    var currSelIdx = tabObjects[0].GetSelectedIndex();
    tabObjects[0].enable = true;
    var enable_tab_03 = 1; // 비활성
    var enable_tab_04 = 1; // 비활성
    var enable_tab_06 = 1; //비활성

    var calc_arr = getCostCalcShtToSaveArr('N');
    for (var i = 0; calc_arr != null && i < calc_arr.length; i++) {
        if (calc_arr[i] == 2) {
            enable_tab_03 = 0; //활성
        }
        if (calc_arr[i] == 3) {
            enable_tab_04 = 0; //활성
            enable_tab_06 = 0; //활성
        }
    }

    if (tabObjects[0].GetTabDisable(2) != enable_tab_03) {
        ////		tabObjects[0].TabEnable(2)=enable_tab_03;
        //		tabObjects[0].SetTabDisable(2 , true);
        //		sheetObjects[2].SetEditable(enable_tab_03);
        //		sheetObjects[2].SetEnable(enable_tab_03);

        tabObjects[0].SetTabDisable(2, enable_tab_03);
        //		sheetObjects[2].SetEditable(!enable_tab_03);
        //		sheetObjects[2].SetEnable(!enable_tab_03);


    }
    if (tabObjects[0].GetTabDisable(3) != enable_tab_04) {
        ////		tabObjects[0].TabEnable(3)=enable_tab_04;
        //		tabObjects[0].SetTabDisable(3 , true);
        //		sheetObjects[3].SetEditable(enable_tab_04);
        //		sheetObjects[3].SetEnable(enable_tab_04);
        //		
        //		tabObjects[0].SetTabDisable(5 , true);
        //		sheetObjects[9].SetEditable(enable_tab_06);
        //		sheetObjects[9].SetEnable(enable_tab_06);

        tabObjects[0].SetTabDisable(3, enable_tab_04);
        //		sheetObjects[3].SetEditable(!enable_tab_04);
        //		sheetObjects[3].SetEnable(!enable_tab_04);

        tabObjects[0].SetTabDisable(5, enable_tab_06);
        //		sheetObjects[9].SetEditable(!enable_tab_06);
        //		sheetObjects[9].SetEnable(!enable_tab_06);		

    }

    if (to_sht_idx != undefined && to_sht_idx != null && to_sht_idx != '' && (to_sht_idx >= 0 && to_sht_idx <= 5)) {
        tabObjects[0].SetSelectedIndex(to_sht_idx);
    } else {
        if (tabObjects[0].GetTabDisable(currSelIdx)) {
            tabObjects[0].SetSelectedIndex(0);
        } else {
            tabObjects[0].SetSelectedIndex(currSelIdx);
        }
    }

    enable_sheet_01 = tabObjects[0].GetTabDisable(0);
    enable_sheet_02 = tabObjects[0].GetTabDisable(1);
    enable_sheet_03 = tabObjects[0].GetTabDisable(2);
    enable_sheet_04 = tabObjects[0].GetTabDisable(3);
    enable_sheet_05 = tabObjects[0].GetTabDisable(4);
    enable_sheet_06 = tabObjects[0].GetTabDisable(5);
}

/**
 * Setting active/inactive to sheet(tab).
 * @param {int}		currIdx		tab index
 * @param {boolean}	enable
 * @return
 */
function setIndvSheetEnable(currIdx, enable) {
    tabObjects[0].SetEnable(1);
    tabObjects[0].SetTabDisable(currIdx, enable);
    sheetObjects[currIdx].SetEditable(enable);
}

/**
 * Setting active or not disable radio button.
 * @return
 */
function setRadioOptionEnable() {
    var formObj = document.form;
    if (formObj.TMNL.checked != true && formObj.StorageDay.checked != true) {
        setElementDiabled('radio', 'CostCalcMethod', 'Y');
    } else {
        setElementDiabled('radio', 'CostCalcMethod', 'N');
    }

    if (formObj.tml_odck_flg.value == "N") {
        if (formObj.TMNL.checked == true && formObj.StorageDay.checked == true) {
            formObj.agmt_ftr_inv_tp_cd.value = "OTOS";
        } else if (formObj.TMNL.checked == true) {
            formObj.agmt_ftr_inv_tp_cd.value = "OT";
        } else if (formObj.StorageDay.checked == true) {
            formObj.agmt_ftr_inv_tp_cd.value = "OS";
        } else {
            formObj.agmt_ftr_inv_tp_cd.value = "";
        }

    } else {
        if (formObj.TMNL.checked == true) {
            formObj.agmt_ftr_inv_tp_cd.value = "OFON";
        } else {
            formObj.agmt_ftr_inv_tp_cd.value = "";
        }
    }

    agmt_lgs_cost_cd.RemoveAll();
    
    var costCdFtrRmk = formObj.cost_cd_ftr_rmk.value;
    getAgmtCostCdList(1, 75, 150, costCdFtrRmk); // tes_getComboItem('agmt_lgs_cost_cd', 2, SEARCHLIST10, '', 'vndr_seq|yd_cd|agmt_ftr_inv_tp_cd|atb_dt', 'setAgmtCostCd');
}

/**
 * Save button click
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
    } else if (curr_cd.GetSelectCode() == null || curr_cd.GetSelectCode() == '') {
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
    } else if (formObj.iss_dt.value != null && formObj.iss_dt.value != '' && formObj.rcv_dt.value != null && formObj.rcv_dt.value != '' && !isValIssRcv()) {
        ComShowMessage('Issue date must be earlier than RCV date.');
        return false;
    } else if ((formObj.err_inv_no.value == null || formObj.err_inv_no.value != '') && (formObj.is_valid_err_inv_no.value == null || formObj.is_valid_err_inv_no.value != 'Y')) {
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
        formObj.hld_rmk.value = '';
    }
    if (formObj.TMNL.checked == true || formObj.StorageDay.checked == true) {
        if (formObj.CostCalcMethod[0].checked == false && formObj.CostCalcMethod[1].checked == false && formObj.CostCalcMethod[2].checked == false) {
            ComShowMessage(ComGetMsg('TES40011'));
            return false;
        }
    }
    return true;
}

/**
 * Setting form by sheet data.
 * @param {string}	MODE	
 * @return
 */
function setHdSheet2Form(MODE) {
    var formObj = document.form;
    if (sheetObjects[5].RowCount() == 1) {
        formObj.tml_so_ofc_cty_cd.value = sheetObjects[5].GetCellValue(1, 'tml_so_ofc_cty_cd');
        formObj.tml_so_seq.value = sheetObjects[5].GetCellValue(1, 'tml_so_seq');
        if (MODE != undefined && MODE != null && MODE == 'CONFIRM') {
            // formObj.confirm_mode.value = '';
            // ComShowMessage('setHdSheet2Form - CONFIRM');
        } else {
            formObj.inv_ofc_cd.value = sheetObjects[5].GetCellValue(1, 'inv_ofc_cd');
            formObj.cost_ofc_cd.value = sheetObjects[5].GetCellValue(1, 'cost_ofc_cd');
            formObj.cost_ofc_cd_hidden.value = sheetObjects[5].GetCellValue(1, 'cost_ofc_cd');
            formObj.vndr_seq.value = tes_lpad(sheetObjects[5].GetCellValue(1, 'vndr_seq'), 6, '0');
            formObj.yd_cd.value = sheetObjects[5].GetCellValue(1, 'yd_cd');
            formObj.yd_cd_hidden.value = sheetObjects[5].GetCellValue(1, 'yd_cd');
            formObj.yd_nm.value = sheetObjects[5].GetCellValue(1, 'yd_nm');
            formObj.fm_prd_dt.value = sheetObjects[5].GetCellValue(1, 'fm_prd_dt');
            formObj.to_prd_dt.value = sheetObjects[5].GetCellValue(1, 'to_prd_dt');
            formObj.inv_no.value = sheetObjects[5].GetCellValue(1, 'inv_no');
            formObj.iss_dt.value = sheetObjects[5].GetCellValue(1, 'iss_dt');
            formObj.ttl_inv_amt.value = tes_chkAmtFmt(sheetObjects[5].GetCellValue(1, 'ttl_inv_amt'), sheetObjects[5].GetCellValue(1, 'curr_cd'));
            formObj.rcv_dt.value = sheetObjects[5].GetCellValue(1, 'rcv_dt');
            formObj.hld_rmk.value = sheetObjects[5].GetCellValue(1, 'hld_rmk');
            formObj.tml_inv_rjct_sts_cd.value = sheetObjects[5].GetCellValue(1, 'tml_inv_rjct_sts_cd');

            if (sheetObjects[5].GetCellValue(1, 'hld_flg') != undefined && sheetObjects[5].GetCellValue(1, 'hld_flg') == 'Y') {
                formObj.hld_flg.checked = true;
            } else {
                formObj.hld_flg.checked = false;
            }
        }

        formObj.cost_cd_ftr_rmk.value = sheetObjects[5].GetCellValue(1, 'cost_cd_ftr_rmk');

        formObj.vat_amt.value = tes_chkAmtFmt(sheetObjects[5].GetCellValue(1, 'vat_amt'), sheetObjects[5].GetCellValue(1, 'curr_cd'));

        curr_cd.SetSelectText(sheetObjects[5].GetCellValue(1, 'curr_cd'));
        curr_cd.SetSelectCode(sheetObjects[5].GetCellValue(1, 'curr_cd'));

        formObj.curr_cd_tmp.value = sheetObjects[5].GetCellValue(1, 'curr_cd');
        resetSheetDataProperty(comboObjects[0].GetSelectCode());
        formObj.tml_inv_tp_cd.value = sheetObjects[5].GetCellValue(1, 'tml_inv_tp_cd');

        var inv_sts_cd = sheetObjects[5].GetCellValue(1, 'tml_inv_sts_cd');
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
        var rjct_sts_cd = sheetObjects[5].GetCellValue(1, 'tml_inv_rjct_sts_cd');
        formObj.tml_inv_rjct_sts_cd.value = (rjct_sts_cd != null && rjct_sts_cd != '' ? rjct_sts_cd : 'NL');
        formObj.tml_inv_rjct_sts_cd.title = tes_getInvRejectStsFullNm(rjct_sts_cd != null && rjct_sts_cd != '' ? rjct_sts_cd : 'NL');
        formObj.inv_rjct_rmk.value = sheetObjects[5].GetCellValue(1, 'inv_rjct_rmk');
        formObj.err_inv_no.value = sheetObjects[5].GetCellValue(1, 'err_inv_no');
        formObj.whld_tax_amt.value = tes_chkAmtFmt(sheetObjects[5].GetCellValue(1, 'whld_tax_amt'), sheetObjects[5].GetCellValue(1, 'curr_cd'));
        set_total_amount();
        var tml_cost_grp_cd = sheetObjects[5].GetCellValue(1, 'tml_cost_grp_cd');
        var tml_calc_ind_cd = sheetObjects[5].GetCellValue(1, 'tml_calc_ind_cd');
        var sto_dys_ind_cd = sheetObjects[5].GetCellValue(1, 'sto_dys_ind_cd');
        // ComShowMessage('tml_cost_grp_cd:'+tml_cost_grp_cd+'\n' +
        // 'tml_calc_ind_cd:'+tml_calc_ind_cd+'\n'+'sto_dys_ind_cd:'+sto_dys_ind_cd+'\n');
        formObj.tml_cost_grp_cd.value = tml_cost_grp_cd;
        formObj.tml_calc_ind_cd.value = tml_calc_ind_cd;
        formObj.sto_dys_ind_cd.value = sto_dys_ind_cd;
        /***********************************************************************
         * tml_cost_grp_cd - Cost Group Code : 'TM' : Terminal 'TP' : Terminal &
         * Storage by Free Pool 'TD' : Terminal & Storage by Free Day 'SP' :
         * Storage by Free Pool 'SD' : Storage by Free Day
         * 
         * tml_calc_ind_cd - Calculation Indicator : 'TP' : Throuput 'SP' :
         * Seperate
         * 
         * sto_dys_ind_cd - Storage Days Indicator : 'IO' : Gate In & Out Date
         * 
         **********************************************************************/
        // ComShowMessage(tml_cost_grp_cd + ' => ' + tml_cost_grp_cd.length + '
        // - ' + tml_cost_grp_cd.substring(0,1) + ' / ' +
        // tml_cost_grp_cd.substring(1,2));
        setElementChecked('checkbox', 'TMNL', 'N');
        setElementChecked('checkbox', 'StorageDay', 'N');
        setElementChecked('radio', 'CostCalcMethod', 'N');
        if (tml_cost_grp_cd != undefined && tml_cost_grp_cd.length == 2) {
            if (tml_cost_grp_cd.substring(0, 1) == 'T') {
                formObj.TMNL.checked = true;
            } else if (tml_cost_grp_cd.substring(0, 1) == 'S') {
                formObj.TMNL.checked = false;
            }
            if (tml_cost_grp_cd.substring(1, 2) == 'D') {
                formObj.StorageDay.checked = true;
            } else if (tml_cost_grp_cd.substring(1, 2) == 'P') {
                formObj.StorageDay.checked = false;
            }
        }
        if (formObj.TMNL.checked == true || formObj.StorageDay.checked == true) {
            setElementDiabled('radio', 'CostCalcMethod', 'N');
        } else {
            setElementDiabled('radio', 'CostCalcMethod', 'Y');
        }
        if (tml_calc_ind_cd != undefined && tml_calc_ind_cd.length == 2) {
            if (tml_calc_ind_cd == 'TP') {
                formObj.CostCalcMethod[0].checked = true;
            } else if (tml_calc_ind_cd == 'SP') {
                formObj.CostCalcMethod[1].checked = true;
            } else if (tml_calc_ind_cd == 'GP') {
                formObj.CostCalcMethod[2].checked = true;
            }
        }
        if (sheetObjects[2].RowCount() > 0) {
            setElementDiabled('checkbox', 'TMNL', 'Y');
            setElementDiabled('radio', 'CostCalcMethod', 'Y');
        }
        if (sheetObjects[3].RowCount() > 0 || sheetObjects[9].RowCount() > 0) {
            setElementDiabled('checkbox', 'StorageDay', 'Y');
            setElementDiabled('radio', 'CostCalcMethod', 'Y');
        }

        if (formObj.tml_odck_flg.value == "N") {
            if (formObj.TMNL.checked == true && formObj.StorageDay.checked == true) {
                formObj.agmt_ftr_inv_tp_cd.value = "OTOS";
            } else if (formObj.TMNL.checked == true) {
                formObj.agmt_ftr_inv_tp_cd.value = "OT";
            } else if (formObj.StorageDay.checked == true) {
                formObj.agmt_ftr_inv_tp_cd.value = "OS";
            } else {
                formObj.agmt_ftr_inv_tp_cd.value = "";
            }

        } else {
            if (formObj.TMNL.checked == true) {
                formObj.agmt_ftr_inv_tp_cd.value = "OFON";
            } else {
                formObj.agmt_ftr_inv_tp_cd.value = "";
            }
        }
		
		var costCdFtrRmk = formObj.cost_cd_ftr_rmk.value;
        getAgmtCostCdList(1, 75, 150, costCdFtrRmk); // tes_getComboItem('agmt_lgs_cost_cd', 2, SEARCHLIST10, '', 'vndr_seq|yd_cd|agmt_ftr_inv_tp_cd|atb_dt', 'setAgmtCostCd');

    } else if (sheetObjects[5].RowCount() > 0) {
        // ComShowMessage('ERR');
        ComShowMessage(ComGetMsg('TES22507', 'ERR'));
        return false;
    } else {
        // ComShowMessage('ERR2');
        ComShowMessage(ComGetMsg('TES22507', 'ERR'));
        return false;
    }
}

/**
 * Validating input.
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
 * Setting disable.
 * @param {string}	eleTp			element type
 * @param {string}	eleNm			element name
 * @param {string}	ELE_DISABLED	disable
 * @return
 */
function setElementDiabled(eleTp, eleNm, ELE_DISABLED) {
    if (eleNm == undefined || eleNm == null || eleNm == '' || eleTp == undefined || eleTp == null || eleTp == '' || ELE_DISABLED == undefined || ELE_DISABLED == null || ELE_DISABLED == '') {
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
 * Setting check.
 * @param {string}	eleTp			element type
 * @param {string}	eleNm			element name
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
 * Get element count.
 * @param {form}	formObj		form
 * @param {string}	eleTp		element type
 * @param {string}	eleNm		element name
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
 * Transform from array to string.
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
 * When changing period, initialize values.
 * @return
 */
function period_ChkMod() {
    var formObj = document.form;
    if (hasAutoCalcData(sheetObjects[2]) || hasAutoCalcData(sheetObjects[3]) || hasAutoCalcData(sheetObjects[4])) {
        if (formObj.fm_prd_dt.value != sheetObjects[5].GetCellValue(1, 'fm_prd_dt') || formObj.to_prd_dt.value != sheetObjects[5].GetCellValue(1, 'to_prd_dt')) {
            if (confirm(ComGetMsg('TES40009'))) {
                removeAutoCalcDataAll();
            } else {
                formObj.fm_prd_dt.value = sheetObjects[5].GetCellValue(1, 'fm_prd_dt');
                formObj.to_prd_dt.value = sheetObjects[5].GetCellValue(1, 'to_prd_dt');
                return false;
            }
        }
    }
    return false;
}

/**
 * Validating date object.
 * @param {string]
 * @return
 */
function validateDateObj(obj) {
    if (obj.readOnly == true) {
        return false;
    }
    obj.value = doSepRemove(obj.value, ' ');
    if (obj.value == null || obj.value == '') {
        return false;
    }
    if (!checkPeriodFormat(obj.value) || !tes_isValidDateObject(obj.value, '-')) {
        ComShowMessage(ComGetMsg('TES23011'));
        obj.focus();
        return false;
    }
    var formObj = document.form;
    if (formObj.fm_prd_dt.value != null && doSepRemove(formObj.fm_prd_dt.value, ' ') != '' && formObj.to_prd_dt.value != null && doSepRemove(formObj.to_prd_dt.value, ' ') != '' && !isValFmTo(formObj.fm_prd_dt.value, formObj.to_prd_dt.value)) {
        ComShowMessage(ComGetMsg('TES24012'));
        return false;
    }
    return true;
}

/**
 * Validating input dates.
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
 * Validating Issue DT, RCV Date
 * @param {string]
 * @return
 */
function validateDateObj2(obj) {
    if (obj.readOnly == true) {
        return false;
    }
    obj.value = doSepRemove(obj.value, ' ');
    if (obj.value == null || doSepRemove(obj.value, ' ') == '') {
        return false;
    }
    if (!checkPeriodFormat(obj.value) || !tes_isValidDateObject(obj.value, '-')) {
        ComShowMessage(ComGetMsg('TES23011'));
        obj.focus();
        return false;
    }
    var formObj = document.form;
    if (formObj.iss_dt.value != null && doSepRemove(formObj.iss_dt.value, ' ') != '' && formObj.rcv_dt.value != null && doSepRemove(formObj.rcv_dt.value, ' ') != '' && !isValIssRcv()) {
        ComShowMessage('Issue date must be earlier than RCV date.');
        return false;
    }
    return true;
}

/**
 * Validating RCV date.  
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
 * Validating Period.
 * @param {string}
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
 * Set tml_cost_grp_cd, tml_calc_ind_cd, sto_dys_ind_cd.
 * @return
 */
function setCalcCostCond() {
    var formObj = document.form;
    var tml_cost_grp_cd = '';
    var sto_dys_ind_cd = '';
    tml_cost_grp_cd = 'SD';
    if (formObj.TMNL.checked == true) {
        tml_cost_grp_cd = 'TM';
        if (formObj.StorageDay.checked == true) {
            tml_cost_grp_cd = 'TD';
        } else {
            tml_cost_grp_cd = 'TP';
        }
    } else {
        tml_cost_grp_cd = '';
        if (formObj.StorageDay.checked == true) {
            tml_cost_grp_cd = 'SD';
        } else {
            tml_cost_grp_cd = 'SP';
        }
    }
    if (formObj.CostCalcMethod[0].checked == true) {
        tml_calc_ind_cd = 'TP';
        sto_dys_ind_cd = 'IO';
    } else if (formObj.CostCalcMethod[1].checked == true) {
        tml_calc_ind_cd = 'SP';
        sto_dys_ind_cd = 'DT';
    } else if (formObj.CostCalcMethod[2].checked == true) {
        tml_calc_ind_cd = 'GP';
        sto_dys_ind_cd = 'DT';
    } else {
        tml_calc_ind_cd = '';
    }
    formObj.tml_inv_tp_cd.value = 'OF';
    formObj.tml_cost_grp_cd.value = tml_cost_grp_cd;
    formObj.tml_calc_ind_cd.value = tml_calc_ind_cd;
    formObj.sto_dys_ind_cd.value = sto_dys_ind_cd;

    if (formObj.tml_odck_flg.value == "N") {
        if (formObj.TMNL.checked == true && formObj.StorageDay.checked == true) {
            formObj.agmt_ftr_inv_tp_cd.value = "OTOS";
        } else if (formObj.TMNL.checked == true) {
            formObj.agmt_ftr_inv_tp_cd.value = "OT";
        } else if (formObj.StorageDay.checked == true) {
            formObj.agmt_ftr_inv_tp_cd.value = "OS";
        } else {
            formObj.agmt_ftr_inv_tp_cd.value = "";
        }

    } else {
        if (formObj.TMNL.checked == true) {
            formObj.agmt_ftr_inv_tp_cd.value = "OFON";
        } else {
            formObj.agmt_ftr_inv_tp_cd.value = "";
        }
    }



    // ComShowMessage(formObj.tml_cost_grp_cd.value + ' / ' +
    // formObj.sto_dys_ind_cd.value);
}

var arr_sht_chk = new Array();

/**
 * Save sheet on arr_sht_chk.
 * @param {int}	currShtIdx
 * @return
 */
function setChkCostCalcSht(currShtIdx) {
    if (arr_sht_chk != null) {
        var hasSht = false;
        for (var m = 0; arr_sht_chk != null && m < arr_sht_chk.length; m++) {
            if (arr_sht_chk[m] == currShtIdx) {
                hasSht = true;
                break;
            }
        }
        if (!hasSht) {
            arr_sht_chk[arr_sht_chk.length] = currShtIdx;
        }
    }
}

/**
 * 
 * Get sheet's idx.
 * @param ROWCOUNT_CHK_YN
 * @return
 */
function getCostCalcShtToSaveArr(ROWCOUNT_CHK_YN) {
    if (sheetObjects[5].RowCount() == 0) {
        return false;
    }
    var arr_sht_to_go = new Array();
    var tml_cost_grp_cd = sheetObjects[5].GetCellValue(1, 'tml_cost_grp_cd');
    if (tml_cost_grp_cd != undefined && tml_cost_grp_cd.length == 2) {
        if (tml_cost_grp_cd.substring(0, 1) == 'T') { // TMNL
            if (ROWCOUNT_CHK_YN != undefined && ROWCOUNT_CHK_YN == 'Y') {
                if (sheetObjects[2].RowCount() > 0 && sheetObjects[2].IsDataModified()) {
                    arr_sht_to_go[arr_sht_to_go.length] = 2;
                }
            } else {
                arr_sht_to_go[arr_sht_to_go.length] = 2;
            }
        }
        if (tml_cost_grp_cd.substring(1, 2) == 'D') { // By Day
            if (ROWCOUNT_CHK_YN != undefined && ROWCOUNT_CHK_YN == 'Y') {
                if (sheetObjects[3].RowCount() > 0 && sheetObjects[3].IsDataModified()) {
                    arr_sht_to_go[arr_sht_to_go.length] = 3;
                }
            } else {
                arr_sht_to_go[arr_sht_to_go.length] = 3;
            }
        }
    } else {
        return false;
    }
    return arr_sht_to_go;
}

/**
 * Initialize arr_sht_chk.
 * @return
 */
function init_Arr_sht_chk() {
    for (var i = 0; arr_sht_chk != null && i < arr_sht_chk.length; i++) {
        arr_sht_chk[i] = '';
    }
}

/**
 * Checking sheet save.
 * @param {int}	currShtIdx	sheet index
 * @return
 */
function chkCostCalcSaveSts(currShtIdx) {
    if (sheetObjects[5].RowCount() == 0) {
        return false;
    }
    setChkCostCalcSht(currShtIdx);
    var arr_sht = new Array();
    var toShtIdx = -1;
    var arr_sht = getCostCalcShtToSaveArr('Y');
    for (var i = 0; arr_sht != null && i < arr_sht.length; i++) {
        if (arr_sht[i] != currShtIdx) {
            toShtIdx = parseInt(arr_sht[i], 10);
            break;
        }
    }
    for (var j = 0; arr_sht_chk != null && j < arr_sht_chk.length; j++) {
        if (arr_sht_chk[j] == toShtIdx) {
            return true;
        }
    }
    if (toShtIdx < 0) {
        return true;
    } else {
        if (!confirm(ComGetMsg('TES24013'))) {
            return false;
        }
        tabObjects[0].SetSelectedIndex(toShtIdx);
    }
}

/**
 * When confirm, open message.
 * @param 	{string}	ALMSG_YN
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
 * opening message.
 * @param {string}	ALMSG_YN
 * @return
 */
function chk_rjct(ALMSG_YN) {
    if (sheetObjects[6].RowCount() > 0 && sheetObjects[6].GetCellValue(1, 'tml_inv_rjct_sts_cd') != undefined && sheetObjects[6].GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'RJ') {
        if (ALMSG_YN != undefined && ALMSG_YN == 'Y') {
            ComShowMessage(ComGetMsg('TES40035'));
        }
        return false;
    }
    return true;
}

/**
 * retrieve.
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
            formObj.t5sht_tot_inv_amt.value = '';
            formObj.t6sht_tot_inv_amt.value = '';
            doActionMainHiddenSheet(sheetObjects[5], formObj, IBSEARCH);
        }
    } catch (e) {}
}

/**
 * COIN,DSCP sheet retrieve
 * @return
 */
function retrieveCntrList() {
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); // COIN,DSCP - retrieve
}

/**
 * FP sheet retrieve
 * @return
 */
function retrievePoolDtlList() {
    doActionIBSheet5(sheetObjects[4], document.form, IBSEARCH); // FP - retrieve
}



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

//2016.10.11 Currency FormToSheet Add
function setDefaultCurrencyFormToSheet(sheetObj, row, colName){
    var formObj = document.form;
    
    var formCurrCd = ComGetObjValue(formObj.curr_cd);
    
    sheetObj.SetCellValue(row, colName, formCurrCd, 0);
}