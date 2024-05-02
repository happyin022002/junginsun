/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_TES_0064.js
*@FileTitle : On-Dock Rail Charge Invoice Creation & Correction
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================*/
/*******************************************************************************
 * Event classify code: [initialization]INIT=0; [input]ADD=1;
 * [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3; [modify]MODIFY=4;
 * [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 * character constant COMMAND01=11; ~ COMMAND20=30;
 ******************************************************************************/
// global variable
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var beforetab2 = 1;
var sheetObjects = new Array();
var sheetObjectsMap = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
var save_conf_01 = false;
var retrieve_conf_01 = false;
var recalc_val = "Y";
var lgs_cost_cd_combo = '';
var parmObj = new Array();

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick() {
    /** *** using extra sheet valuable if there are more 2 sheets **** */

    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];
    var sheetObject_main = sheetObjects[3];
    var formObj = document.form;
    try {
        var srcName = ComGetEvent("name");
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
                tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
                retrieveEvent(sheetObject_main, formObj);
                break;
                
            case "btn_new":
                sheetObjects[0].RemoveAll();
                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();
                sheetObjects[3].RemoveAll();
                formObj.reset();
                formObj.yd_cd_hidden.value = "";

                formObj.agmt_ftr_inv_tp_cd.value = "ON";

                setInitComponent("N");
                
                getCurrencyList(0, 70, 100)    //tes_getComboItem('curr_cd', 1, SEARCH03, '', 'inv_ofc_cd');
			    	
                tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
                agmt_lgs_cost_cd.RemoveAll();
                break;
                
            case "btn_new2":
                var tmp_vndr_seq = formObj.vndr_seq.value;
                var tmp_vndr_seq_hidden = formObj.vndr_seq_hidden.value;
                var tmp_is_valid_vndr_seq_hidden = formObj.is_valid_vndr_seq.value;
                var tmp_vndr_seq_nm = formObj.vndr_seq_nm.value;

                var tmp_yd_cd = formObj.yd_cd.value;
                var tmp_yd_nm = formObj.yd_nm.value;

                var tmp_cost_ofc_cd = formObj.cost_ofc_cd.value;
                var tmp_inv_ofc_cd = formObj.inv_ofc_cd.value;

                var tmp_iss_dt = formObj.iss_dt.value;
                var tmp_rcv_dt = formObj.rcv_dt.value;
                var tmp_wrk_dt = formObj.wrk_dt.value;

                sheetObjects[0].RemoveAll();
                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();
                sheetObjects[3].RemoveAll();

                formObj.reset();

                formObj.vndr_seq.value = tmp_vndr_seq;
                formObj.vndr_seq_hidden.value = tmp_vndr_seq_hidden;
                formObj.is_valid_vndr_seq.value = tmp_is_valid_vndr_seq_hidden;
                formObj.vndr_seq_nm.value = tmp_vndr_seq_nm;

                formObj.yd_cd.value = tmp_yd_cd;
                formObj.yd_nm.value = tmp_yd_nm;

                formObj.cost_ofc_cd.value = tmp_cost_ofc_cd;
                
                getCurrencyList(0, 70, 100)    //tes_getComboItem('curr_cd', 1, SEARCH03, '', 'inv_ofc_cd');                                
                
                formObj.inv_ofc_cd.value = tmp_inv_ofc_cd;

                formObj.iss_dt.value = tmp_iss_dt;
                formObj.rcv_dt.value = tmp_rcv_dt;
                formObj.wrk_dt.value = tmp_wrk_dt;

                formObj.agmt_ftr_inv_tp_cd.value = "ON";

                //                 curr_cd.SetSelectText("USD");
                validateVndrSeq();
                validateYardCode();
                setInitComponent("N");
                tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
                agmt_lgs_cost_cd.RemoveAll();
                break;
                
            case "btn_save":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == "C") {
                    ComShowMessage("Confirmed Invoice !!");
                    return false;
                }
                if (ComGetDaysBetween(formObj.iss_dt, formObj.rcv_dt) < 0) {
                    ComShowMessage('Issue date must be earlier than RCV date.');
                    return false;
                }

                if (!fnChkEmptyObj(formObj.vndr_seq)) return;
                if (!fnChkEmptyObj(formObj.inv_no)) return;
                if (!fnChkEmptyObj(formObj.yd_cd)) return;

                if (!fnChkEmptyObj(formObj.ttl_inv_amt)) return;
                if (!fnChkEmptyObj(formObj.iss_dt)) return;
                if (!fnChkEmptyObj(formObj.rcv_dt)) return;
                if (!fnChkEmptyObj(formObj.wrk_dt)) return;

                formObj.cost_cd_ftr_rmk.value = replaceAll(agmt_lgs_cost_cd.GetSelectCode(), ',', '|');

                invHeaderSave(sheetObject_main, formObj);
                retrieveEvent(sheetObject_main, formObj);
                break;
                
                // Vender Serch Event
            case "btn_vndr":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == "C") {
                    ComShowMessage("Confirmed Invoice !!");
                    return false;
                }
                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // com_ens_051_dispaly.value;
                var classId = "COM_ENS_0C1";
                var param = '?classId=' + classId;
                var chkStr = dispaly.substring(0, 3)
                    // radio PopUp
                if (chkStr == "1,0") {
                    ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 770, 520, 'getVender', dispaly);
                } else {
                    ComShowMessage(ComGetMsg('TES21003'));
                    return;
                }
                break;
                
            case "btn_cost_ofc":
                if (formObj.cost_ofc_cd.readOnly) {
                    ComShowMessage(ComGetMsg('TES23007', 'Yard Code'));
                    return false;
                }
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == "C") {
                    ComShowMessage("Confirmed Invoice !!");
                    return false;
                }
                if (formObj.cost_ofc_cd.readOnly) {
                    return false;
                }
                var dispaly = '1,0,1,1,1,1,1,1,1,1,1,1';
                var classId = "COM_ENS_071";
                var param = '?classId=' + classId;
                var chkStr = dispaly.substring(0, 3);
                // radio PopUp
                if (chkStr == "1,0") {
                    ComOpenPopup('/opuscntr/COM_ENS_071.do' + param, 770, 500, 'getOfcCd', dispaly, true);
                } else {
                    ComShowMessage(ComGetMsg('TES21003'));
                    return;
                }
                break;
                
            case "btn_yard":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == "C") {
                    ComShowMessage("Confirmed Invoice !!");
                    return false;
                }
                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // com_ens_051_dispaly.value;
                var classId = "COM_ENS_061";
                var param = '?classId=' + classId;
                var chkStr = dispaly.substring(0, 3);
                // radio PopUp
                if (chkStr == "1,0") {
                    ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 770, 530, 'getYard', dispaly, true);
                } else {
                    ComShowMessage(ComGetMsg('TES21003'));
                    return;
                }
                break;
                
            case "btns_calendar1":
                var cal = new ComCalendar();
                cal.select(formObj.iss_dt, 'yyyy-MM-dd');
                break;
                
            case "btns_calendar2":
                var cal = new ComCalendar();
                cal.select(formObj.rcv_dt, 'yyyy-MM-dd');
                break;
                
            case "btns_calendar3":
                var cal = new ComCalendar();
                cal.select(formObj.wrk_dt, 'yyyy-MM-dd');
                break;
                
            case "btns_remarks":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == "C") {
                    ComShowMessage("Confirmed Invoice !!");
                    return false;
                }
                if (formObj.hld_flg.checked == true) {
                    //var remarkVal = ComOpenWindowCenter('ESD_TES_9210RemarksPopup.screen?hld_rmk_inp_nm=' + formObj.hld_rmk.value, 'popup_remarks', 450, 140, false);
                    ComOpenPopup('ESD_TES_9210RemarksPopup.screen?hld_rmk_inp_nm=' + formObj.hld_rmk.value, 450, 140, "", "1,0,1,1,1,1,1", true);
                }
                break;
                
            case "btng_fileimport1":
                if (!save_conf_01) {
                    ComShowMessage(ComGetMsg('TES21005'));
                    return false;
                }
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == "C") {
                    ComShowMessage("Confirmed Invoice !!");
                    return false;
                }
                if (!fnChkEmptyObj(formObj.vndr_seq)) return;
                if (!fnChkEmptyObj(formObj.yd_cd)) return;
                if (!fnChkEmptyObj(formObj.rcv_dt)) return;
                if (formObj.vndr_seq.value == null || formObj.vndr_seq.value == "" ||
                    formObj.yd_cd.value == null || formObj.yd_cd.value == "" || formObj.is_valid_yd_cd.value != 'Y')
                    return false;
                if (sheetObject.RowCount() > 0 || sheetObject1.RowCount() > 0) {
                    var confirm_value = confirm(ComGetMsg('TES22006'));
                    if (!confirm_value) return false;
                    if (deleteContanerList()) gridSave();
                }
                //2016.09.09 AGMT COST CD Add
                var params = "";
                    params += "?wrk_dt="+formObj.wrk_dt.value;
                    params += "&min_wrk_dt="+formObj.min_wrk_dt.value;
                    params += "&cost_cd_ftr_rmk="+replaceAll(agmt_lgs_cost_cd.GetSelectCode(), ',', '|');
                
                ComOpenWindow('ESD_TES_9130.screen' + params, window, "dialogWidth:550px;dialogHeight:420px;help:no;status:no;resizable:no;", true);
                //ComOpenWindow('ESD_TES_9130.screen?wrk_dt=' + formObj.wrk_dt.value + "&min_wrk_dt=" + formObj.min_wrk_dt.value, window, "dialogWidth:550px;dialogHeight:420px;help:no;status:no;resizable:no;", true);
                t1sheet1_OnLoadFinish(sheetObject);
                t2sheet1_OnLoadFinish(sheetObject1);
                break;
                
            case "btng_save1":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == "C") {
                    ComShowMessage("Confirmed Invoice !!");
                    return false;
                }
                if (CheckCNTRListMandatoryCol() == false) {
                    return false;
                }
                gridSave();
                break;
                
            case "t1btng_clear":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == "C") {
                    ComShowMessage("Confirmed Invoice !!");
                    return false;
                }
                if (formObj.vndr_seq.value == null || formObj.vndr_seq.value == "" ||
                    formObj.yd_cd.value == null || formObj.yd_cd.value == "" || formObj.is_valid_yd_cd.value != 'Y')
                    return false;
                if (sheetObject.RowCount() > 0 || sheetObject1.RowCount() > 0) {
                    var confirm_value = confirm(ComGetMsg('TES22006'));
                    if (!confirm_value) return false;
                    if (deleteContanerList()) gridSave();
                }
                break;
                
            case "btng_todiscrepancy1":
                if (!save_conf_01) {
                    ComShowMessage(ComGetMsg('TES21005'));
                    return false;
                }
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == "C") {
                    ComShowMessage("Confirmed Invoice !!");
                    return false;
                }
                if (sheetObject.RowCount() < 1) {
                    ComShowMessage(ComGetMsg('TES21008'));
                    return false;
                }
                if (sheetObject.CheckedRows("chk") < 1) {
                    ComShowMessage(ComGetMsg('TES21009'));
                    return false;
                }
                // toDiscreption(sheetObject,sheetObject1);
                modifyContainerVerifyStatus(sheetObject, sheetObject1, 'DC', 'Y');
                break;
                
            case "t1btng_downexcel":
                doActionIBSheet1(sheetObject, formObj, IBDOWNEXCEL);
                break;
                
            case "btng_costcalc1":
                if (!save_conf_01) {
                    ComShowMessage(ComGetMsg('TES21005'));
                    return false;
                }
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == "C") {
                    ComShowMessage("Confirmed Invoice !!");
                    return false;
                }
                if (!validMandatoryItemContainerList(sheetObjects[0])) {
                    return false;
                }
                var sheets = new Array();
                sheets[0] = sheetObjects[0];
                if (tes_isModified2(sheets)) {
                    ComShowMessage(ComGetMsg('TES21011'));
                    recalc_val = "N";
                    return false;
                }
                if (sheetObjects[0].RowCount() > 0 && (sheetObjects[2].RowCount() == 0 || recalc_val == "N")) {
                    formObj.cost_calc_mode.value = "N";
                }

                doActionIBSheet3(sheetObjects[2], formObj, IBSEARCH_ASYNC02);
                break;
                
            case "t2btng_clear":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == "C") {
                    ComShowMessage("Confirmed Invoice !!");
                    return false;
                }
                if (formObj.vndr_seq.value == null || formObj.vndr_seq.value == "" ||
                    formObj.yd_cd.value == null || formObj.yd_cd.value == "" || formObj.is_valid_yd_cd.value != 'Y')
                    return false;
                if (sheetObject.RowCount() > 0 || sheetObject1.RowCount() > 0) {
                    var confirm_value = confirm(ComGetMsg('TES22006'));
                    if (!confirm_value) return false;
                    if (deleteContanerList()) gridSave();
                }
                break;
                
            case "t2btng_verification":
                if (!save_conf_01) {
                    ComShowMessage(ComGetMsg('TES21005'));
                    return false;
                }
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == "C") {
                    ComShowMessage("Confirmed Invoice !!");
                    return false;
                }
                if (sheetObject1.RowCount() < 1) {
                    ComShowMessage(ComGetMsg('TES21012'));
                    return false;
                }
                if (sheetObject1.CheckedRows("chk") < 1) {
                    ComShowMessage(ComGetMsg('TES21009'));
                    return false;
                }
                // toCoincidence(sheetObject1,sheetObject);
                modifyContainerVerifyStatus(sheetObject1, sheetObject, 'CO', 'Y');
                break;
                
            case "t2btng_reject":
                if (!save_conf_01) {
                    ComShowMessage(ComGetMsg('TES21005'));
                    return false;
                }
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == "C") {
                    ComShowMessage("Confirmed Invoice !!");
                    return false;
                }
                if (sheetObject1.RowCount() < 1) {
                    ComShowMessage(ComGetMsg('TES21012'));
                    return false;
                }
                ComOpenWindowCenter('ESD_TES_9020RejectPopup.screen?rjct_sts_inp_nm=inv_rjct_rmk&rjct_fn_nm=rjctInv', 'popup_reject', 400, 200, true);
                break;
                
            case "t2btng_print":
                var fromObj = new Array();
                var rdObj = new Array();

                fromObj[0] = formObj;
                if (sheetObjects[1].RowCount() < 1) {
                    ComShowMessage(ComGetMsg('TES21013'));
                    return;
                }
                // RD 로 보내기 위한 설정
                parmObj[0] = "1";
                parmObj[1] = "";
                parmObj[2] = "N";
                parmObj[3] = RD_path + "apps/opus/esd/tes/serviceproviderinvoicemanage/ondockrailchargeinvoicemanage/report/ESD_TES_8060.mrd"; // RD
                parmObj[4] = rdObj;
                parmObj[5] = fromObj;
                rdObjModaless(RdReport, parmObj, 1000, 700);
                break;
                
            case "t2btng_downexcel":
                doActionIBSheet2(sheetObject1, formObj, IBDOWNEXCEL);
                break;

            case "t3btng_costCal":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                
                if (formObj.tml_inv_sts_cd.value == "C") {
                    ComShowMessage("Confirmed Invoice !!");
                    return false;
                }

                var param = "?yd_cd=" + formObj.yd_cd.value + "&vndr_seq=" + formObj.vndr_seq.value + "&vndr_seq_nm=" + formObj.vndr_seq_nm.value + "&prgm_id=ESD_TES_0064&cost_cd_inv_tp_cd=ON&min_wrk_dt=" + formObj.min_wrk_dt.value + "&curr_cd=" + formObj.curr_cd.value + "&max_wrk_dt=" + formObj.max_wrk_dt.value + "&iss_dt=" + formObj.iss_dt.value;
                //ComOpenPopup(sUrl,                     iWidth, iHeight, sFunc,            sDisplay,        bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                ComOpenPopup("ESD_TES_9001.do" + param, 840, 670, "setCostCode2", "1,0,1,1,1,1,1", true, false, null, null, null, 'Cost Calculation', 'no');
                break;

            case "t3btng_clear":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == "C") {
                    ComShowMessage("Confirmed Invoice !!");
                    return false;
                }
                if (formObj.vndr_seq.value == null || formObj.vndr_seq.value == "" ||
                    formObj.yd_cd.value == null || formObj.yd_cd.value == "" || formObj.is_valid_yd_cd.value != 'Y')
                    return false;
                if (sheetObject.RowCount() > 0 || sheetObject1.RowCount() > 0 || sheetObject2.RowCount() > 0) {
                    var confirm_value = confirm(ComGetMsg('TES22006'));
                    if (!confirm_value) return false;
                    if (deleteContanerList()) gridSave();
                }
                break;
                
            case "t3btng_rowadd":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == "C") {
                    ComShowMessage("Confirmed Invoice !!");
                    return false;
                }
                costCalcRowAdd(sheetObject2);
                break;
                
            case "t3btng_rowdel":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == "C") {
                    ComShowMessage("Confirmed Invoice !!");
                    return false;
                }
                costCalcRowDel(sheetObject2);
                break;
                
            case "btng_save3":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == "C") {
                    ComShowMessage("Confirmed Invoice !!");
                    return false;
                }
                for (var i = sheetObject2.HeaderRows(); i < sheetObject2.HeaderRows() + sheetObject2.RowCount(); i++) {
                    if ((sheetObject2.GetCellValue(i, 'calc_tp_cd') == 'M' || sheetObject2.GetCellValue(i, 'calc_tp_cd') == 'S') && sheetObject2.GetCellValue(i, 'lgs_cost_cd') == '') {
                        ComShowMessage("There is no Cost Code.");
                        return false;
                    }

                    if ((sheetObject2.GetCellValue(i, 'calc_tp_cd') == 'M' || sheetObject2.GetCellValue(i, 'calc_tp_cd') == 'S') && sheetObject2.GetCellValue(i, 'calc_rmk') == '') {
                        ComShowMessage("Please,  must input remarks"); //
                        return false;
                    }

                    if (sheetObject2.GetCellValue(i, 'wrk_dt') == '') {
                        ComShowMessage("Please, input Working Date.");
                        return false;
                    }

                }
                gridSave();
                break;
                
            case "btng_totalamount3":
                var url_str = "ESD_TES_9060Popup.screen?tml_inv_tp_cd=" + document.form.tml_inv_tp_cd.value + "&tml_so_ofc_cty_cd=" + document.form.tml_so_ofc_cty_cd.value + "&tml_so_seq=" + document.form.tml_so_seq.value;
                ComOpenWindow(url_str, window, "dialogWidth:510px;dialogHeight:370px;help:no;status:no;resizable:yes;", true);
                break;
                
            case "btng_confirm3":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == "C") {
                    ComShowMessage("Confirmed Invoice !!");
                    return false;
                }
                if (recalc_val != "Y") {
                    ComShowMessage(ComGetMsg('TES22012'));
                    return false;
                }
                if (sheetObject2.RowCount() == 0) {
                    ComShowMessage(ComGetMsg('TES21015'));
                    return false;
                }
                if (formObj.ttl_inv_amt.value != formObj.tot_inv_amt.value) {
                    ComShowMessage(ComGetMsg('TES21016'));
                    return false;
                }

                if (!fnChkEmptyObj(formObj.wrk_dt)) return;

                if (ComGetDaysBetween(formObj.iss_dt, formObj.rcv_dt) < 0) {
                    ComShowMessage('Issue date must be earlier than RCV date.');
                    return false;
                }
                for (var i = sheetObject2.HeaderRows(); i < sheetObject2.HeaderRows() + sheetObject2.RowCount(); i++) {
                    if ((sheetObject2.GetCellValue(i, 'calc_tp_cd') == 'M' || sheetObject2.GetCellValue(i, 'calc_tp_cd') == 'S') && sheetObject2.GetCellValue(i, 'lgs_cost_cd') == '') {
                        ComShowMessage(ComGetMsg('TES40018'));
                        return false;
                    }

                    if (sheetObject2.GetCellValue(i, 'wrk_dt') == '') {
                        ComShowMessage("Please, input Working Date.");
                        return false;
                    }

                    if ((sheetObject2.GetCellValue(i, 'curr_cd') != curr_cd.GetSelectCode()) && (sheetObject2.GetCellValue(i, 'inv_xch_rt') == 0) && (sheetObject2.GetCellValue(i, 'calc_tp_cd') == 'A')) {
                        ComShowMessage('There is no exchange rate at the suitable column.');
                        return false;
                    }
                }
                formObj.tml_inv_sts_cd.value = "C";
                if (sheetObjects[2].RowCount() > 0) {
                    doActionIBSheet3(sheetObjects[2], formObj, IBSAVE);
                }
                invHeaderSave(sheetObject_main, formObj);
                formObj.tml_inv_sts_nm.value = "CF";
                for (var e = 0; e < formObj.elements.length; e++) {
                    var el = formObj.elements[e];
                    ComEnableObject(el, false);
                    $('button').prop('disabled', false);
                }
                ComEnableManyObjects(true, formObj.vndr_seq, formObj.inv_no);
                sheetObjects[0].SetEditable(0);
                sheetObjects[1].SetEditable(0);
                sheetObjects[2].SetEditable(0);
                ComShowMessage(ComGetMsg('TES40010'));
                tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt|wrk_dt"));
                break;
                
        } // end switch
        
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(ComGetMsg('TES21025')); // ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e.message);
        }
    }
}

function setRemarkVal(rtnVal) {
    var formObj = document.form;
    formObj.hld_rmk.value = rtnVal;
}

/**
 * getYardName
 * 
 */
function getYardName() {
    var formObj = document.form;
    if (formObj.yd_cd.value == null || formObj.yd_cd.value.trim() == '') {
        return false;
    }
    doActionIBSheet_main(sheetObjects[3], formObj, IBSEARCH_ASYNC04);
}

/**
 * @param {string}
 *            strEleNums
 * @return
 */
function setEleNums(strEleNums) {
    var eleNums = new Array();
    eleNums = strEleNums.split("|");
    return eleNums;
}

/**
 * Verification, Discrepancy
 * 
 * @param {ibsheet}
 *            fromSheet sheet object
 * @param {ibsheet}
 *            toSheet sheet object
 * @param {String}
 *            cntr_status
 * @param {String}
 *            modi_flg
 * 
 * (cntr_status : 'CO'/'DC' modi_flg : 'Y'/'' )
 */
function modifyContainerVerifyStatus(fromSheet, toSheet, cntr_status, modi_flg) {
    for (var i = fromSheet.HeaderRows(); i < fromSheet.HeaderRows() + fromSheet.RowCount(); i++) {
        if (fromSheet.GetCellValue(i, 'chk') == '1') {
            fromSheet.SetCellValue(i, 'vrfy_rslt_ind_cd', cntr_status);
            fromSheet.SetCellValue(i, 'modi_flg', modi_flg);
        }
    }
    var queryStr = '';
    queryStr = fromSheet.GetSaveString(false, false, 'chk');
    tes_copy_rows_to2(toSheet, queryStr, true);
    for (var i = fromSheet.RowCount(); i >= fromSheet.HeaderRows(); i--) {
        if (fromSheet.GetCellValue(i, 'chk') == '1') {
            fromSheet.RowDelete(i, false);
        }
    }
}

/**
 * enter check
 * 
 * @param funcNm
 * @return
 */
function enterCheck(funcNm) {
    var formObj = document.form;
    if (funcNm == undefined || funcNm == null || funcNm.trim() == '') {
        return false;
    }
    if (event.keyCode == 13) {
        retrieveEvent(sheetObjects[3], formObj);
    }
}

/**
 * registering IBSheet Object as list adding process for list in case of needing
 * batch processing with other items defining list on the top of source
 * 
 * @param {ibsheet}
 *            sheet_obj sheet object
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
    sheetObjectsMap[sheet_obj.id] = sheet_obj;
}

/**
 * set common code
 * 
 * @return
 */
function setCommonCode() {
    var formObj = document.form;
    var tmp = '';
    if (formObj.tmp_common_code.value != undefined && formObj.tmp_common_code.value != null && formObj.tmp_common_code.value.trim() != '') {
        tmp = formObj.tmp_common_code.value.split('--');
        if (tmp.length > 0) {
            for (var i = 0; i < tmp.length; i++) {
                tmp[i] = (tmp[i] != undefined && tmp[i] != null ? tmp[i] : '');
            }
            CNTR_TPSZ_CD = tmp[0];
            ON_A_LGS_COST_CD = tmp[2];
        }
    }
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    var sheetObject_main = sheetObjects[3];
    if (!ComIsNull(formObj.inv_no_tmp.value)) {
        formObj.inv_no.value = formObj.inv_no_tmp.value;
        formObj.vndr_seq.value = vndr_seq;
        retrieveEvent(sheetObject_main, formObj);
    }
}

/**
 * initializing sheet implementing onLoad event handler in body tag adding
 * first-served functions after loading screen.
 */
function loadPage() {
    for (i = 0; i < comboObjects.length; i++) {
        initCombo(comboObjects[i], i + 1);
    }
    
    getComCdList(); // CNTR_TPSZ_CD, MT_A_LGS_COST_CD, CARR_CD     //tes_getInputValue('tmp_common_code', SEARCH17, '', 'setCommonCode');  
    getWhldTaxAmtMode();  // WHLD_TAX_READONLY_MODE      //tes_getInputValueInvoice('whld_tax_amt_mode', SEARCH05, 'inv_ofc_cd', 'setWhldTaxAmtMode');
     
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    for (i = 0; i < tabObjects.length; i++) {
        initTab(tabObjects[i], i + 1);
        tabObjects[i].SetSelectedIndex(0);
    }
    
    setInitComponent("N");
    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
    
    save_conf_01 = false;
    
    if(getCurrencyList(0, 70, 100)){    //tes_getComboItem('curr_cd', 1, SEARCH03, '', 'inv_ofc_cd', 'setCalcColFormat');
    	resetSheetDataProperty(comboObjects[0].GetSelectCode());
    }
    
    var formObj = document.form;
    formObj.vndr_seq.focus();
    
    t1sheet1_OnLoadFinish(t1sheet1);
    t2sheet1_OnLoadFinish(t2sheet1);
    t3sheet1_OnLoadFinish(t3sheet1);

    axon_event.addListener('keydown', 'ComKeyEnter', 'form');

    //hidden 처리되어 있는 값을 초기화 하도록 해줌 2014.08.26
    $(document.form).bind("reset", function() {
        $(this).find('input[type=hidden]').each(function() {
            this.value = ''
        });
    });
    
    var sheetObject_main = sheetObjects[3];
    if (!ComIsNull(formObj.inv_no_tmp.value)) {
        formObj.inv_no.value = formObj.inv_no_tmp.value;
        formObj.vndr_seq.value = vndr_seq;
        retrieveEvent(sheetObject_main, formObj);
    }
}

/**
 * 
 * @return
 */
function setWhldTaxAmtMode() {
    var formObj = document.form;
    var tmp = '';
    tmp = formObj.whld_tax_amt_mode.value;
    if (tmp != undefined && tmp != null && tmp.trim() == 'Y') {
        WHLD_TAX_READONLY_MODE = false;
    } else {
        WHLD_TAX_READONLY_MODE = true;
    }
}

/**
 * 
 * @return
 */
function setCalcColFormat() {
    resetSheetDataProperty(comboObjects[0].GetSelectCode());
}

/**
 * IBCombo Object adding process for list in case of needing batch
 * processing with other items defining list on the top of source
 */
function setComboObject(combo_obj) {
    comboObjects[comboCnt++] = combo_obj;
}

/**
 * set Combo List
 */
function initCombo(comboObj, comboNo, combo_val, def_val, tpszCodeValue) {
    var cnt = 0;
    var tpszCodeArray = (tpszCodeValue != null) ? tpszCodeValue.split("|") : "";
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
                    //InsertItem(cnt++, new String(tmp[i]), new String(tmp[i]));
                    InsertItem(cnt++, tmp[i], tmp[i]);
                }
                if (def_val != undefined && def_val != null && def_val.trim() != '') {
                    SetSelectCode(def_val, true);
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

        case 3:
            with(comboObj) {
                SetColAlign(0, "left");
                SetColWidth(0, "40");
                for (i = 0; i < tpszCodeArray.length; i++) {
                    valueArray = tpszCodeArray[i].split("--");
                    InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]);
                }
            }
            break;
    }
}

/**
 * setting sheet initial values and header param : sheetObj ==> , sheetNo
 * ==> adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	sheetObj.UseUtf8=true;
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with(sheetObj){
				var HeadTitle="|STS||Seq.|PAGE|modi_flg|VVD|CNTR No.|Type/Size|F/M|DG|Working Date|"
				+ "bkg_no|bkg_no_split|CLM Date|Rail Billing  \nDate|Verify \n Result|dscr_ind_nm|Remark|dscr_rsn|"
				+ "tml_so_ofc_cty_cd|tml_so_seq|tml_so_cntr_list_seq|vrfy_rslt_ind_cd|atb_dt|vndr_seq|"
				+ "vsl_cd|skd_voy_no|skd_dir_cd|finc_vsl_finc_vsl_cd|finc_skd_voy_no|finc_skd_dir_cd|dscr_dtl_ind_cd";
				
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:8, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ 
							{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sts",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
							{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"page",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"modi_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_clss_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"wrk_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no_split",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"clm_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rail_bil_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dscr_ind_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dscr_ind_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dscr_rsn",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tml_so_ofc_cty_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tml_so_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tml_so_cntr_list_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vrfy_rslt_ind_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"atb_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"finc_vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"finc_skd_voy_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"finc_skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dscr_dtl_ind_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no_tp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				SetColProperty("cntr_sty_cd", {ComboText:cntr_sty_cdCode, ComboCode:cntr_sty_cdCode} );
				SetColProperty("dcgo_clss_cd", {ComboText:dcgo_clss_cdCode, ComboCode:dcgo_clss_cdCode} );					 
				SetEditable(1);
				SetSheetHeight(300);
			}
		break;
		
		case 2:     //sheet2 init
			with(sheetObj){
				var HeadTitle="|STS||Seq.|PAGE|modi_flg|dscr_ind_cd|Dscr Ind Nm|CNTR No.|Type /\nSize|F/M|DG|Working Date|"
				+ "bkg_no|bkg_no_split|CLM Date|Rail Billing Date|Remark|dscr_rsn|"
				+ "tml_so_ofc_cty_cd|tml_so_seq|tml_so_cntr_list_seq|vrfy_rslt_ind_cd|atb_dt|vvd_no|vndr_seq|"
				+ "vsl_cd|skd_voy_no|skd_dir_cd|finc_vsl_finc_vsl_cd|finc_skd_voy_no|finc_skd_dir_cd";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:9, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sts",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"page",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"modi_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dscr_ind_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dscr_ind_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_clss_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Date",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"wrk_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no_split",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"clm_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rail_bil_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dscr_rsn",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tml_so_ofc_cty_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tml_so_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tml_so_cntr_list_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vrfy_rslt_ind_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"atb_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"finc_vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"finc_skd_voy_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"finc_skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dscr_dtl_ind_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no_tp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				SetColProperty("dcgo_clss_cd", {ComboText:dcgo_clss_cdCode, ComboCode:dcgo_clss_cdCode} );
				SetColProperty("cntr_tpsz_cd", {ComboText:CNTR_TPSZ_CD, ComboCode:CNTR_TPSZ_CD} );
				SetColProperty("cntr_sty_cd", {ComboText:cntr_sty_cdCode, ComboCode:cntr_sty_cdCode} );					
				SetEditable(1);	
				resizeSheet();//SetSheetHeight(300);
			}
		break;
		
		case 3:     //sheet3 init
			with(sheetObj){					
				var HeadTitle="STS|PAGE|tml_so_ofc_cty_cd|tml_so_seq|tml_so_dtl_seq|calc_cost_grp_cd|Calcuration Type|vsl_cd|skd_voy_no|skd_dir_cd|vvd_no|"
				+ "Cost Code|Type /\n Size|Working Date|Applied \nDate|DG|fm_tr_vol_val|to_tr_vol_val|Vol.Tier|acct_cd|CalculatedVol.|Revised Vol.|"
				+ "UOM|Rate|AGMT\nCurr.|Exch.Rate|Amount|Amount2|Remarks|3rd Party|atb_dt|cntr_no|dcgo_ind_cd|stay_dys|free_dys|ovr_dys|"
				+ "fp_calc_prd_cd|stk_vol_qty|fp_teu_qty|inv_vol_qty|diff_vol_qty|ovr_vol_qty|calc_amt|"
				+ "finc_vsl_finc_vsl_cd|finc_skd_voy_no|finc_skd_dir_cd|lgs_cost_cd2|cntr_tpsz_cd2|tml_agmt_ofc_cty_cd|tml_agmt_seq"
				+ "|tml_agmt_ver_no|curr_chk|";
				
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:12, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"page",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tml_so_ofc_cty_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tml_so_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tml_so_dtl_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"calc_cost_grp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"calc_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vvd_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Date",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"wrk_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tml_wrk_dy_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_ind_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"fm_tr_vol_val",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"to_tr_vol_val",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"tier",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"acct_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"calc_vol_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Popup",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rvis_vol_qty",          KeyField:0,   CalcLogic:"",   Format:"",     		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vol_tr_ut_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_rt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"inv_xch_rt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:4,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"inv_amt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"calc_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"calc_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Popup",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"atb_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"stay_dys",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"free_dys",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ovr_dys",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"fp_calc_prd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"stk_vol_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"fp_teu_qty",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"inv_vol_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"diff_vol_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ovr_vol_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"finc_vsl_finc_vsl_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"finc_skd_voy_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"finc_skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tml_agmt_ofc_cty_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tml_agmt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tml_agmt_ver_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"curr_chk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"semi_auto_calc_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
							
				InitColumns(cols);
				SetColProperty("calc_tp_cd", {ComboText:"AutoCalculatedCost|ManualInputCost|SemiAutoInputCost", ComboCode:"A|M|S"} );
				SetColProperty("tml_wrk_dy_cd", {ComboText:tml_wrk_dy_cdCode, ComboCode:tml_wrk_dy_cdCode} );
				SetColProperty("dcgo_ind_cd", {ComboText:dcgo_clss_cdCode, ComboCode:dcgo_clss_cdCode} );
				SetColProperty("vol_tr_ut_cd", {ComboText:vol_tr_ut_cdCode, ComboCode:vol_tr_ut_cdCode} );
				SetColProperty("lgs_cost_cd", {ComboText:ON_A_LGS_COST_CD, ComboCode:ON_A_LGS_COST_CD} );
				SetColProperty("cntr_tpsz_cd", {ComboText:CNTR_TPSZ_CD, ComboCode:CNTR_TPSZ_CD} );
				SetEditable(1);	
				resizeSheet();//SetSheetHeight(300);
			}
		break;
		
		case 4:      //main_hidden init
			with(sheetObj){              
				var HeadTitle="|STS|tml_so_ofc_cty_cd|tml_so_seq|inv_ofc_cd|cost_ofc_cd|inv_no|vndr_seq|yd_cd|yd_nm|curr_cd|ttl_inv_amt|vat_amt|ttl_calc_amt|fm_prd_dt|hld_flg|hld_rmk|"
				+"to_prd_dt|tml_inv_tp_cd|tml_cost_grp_cd|tml_calc_ind_cd|sto_dys_ind_cd|iss_dt|rcv_dt|eff_dt|pay_due_dt|pay_flg|tml_inv_sts_cd|tml_inv_sts_nm|tml_inv_rjct_sts_cd|"
				+"inv_cfm_dt|tml_agmt_ofc_cty_cd|tml_agmt_seq|tml_agmt_ver_no|whld_inv_amt|inv_rjct_rmk|rtro_tml_inv_flg|wrk_dt|cost_cd_ftr_rmk";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:0 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sts",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"inv_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"cost_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"vndr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"yd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"yd_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"ttl_inv_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"vat_amt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"ttl_calc_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"fm_prd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"hld_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"hld_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"to_prd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_cost_grp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_calc_ind_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"sto_dys_ind_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"iss_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"rcv_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"pay_due_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"pay_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_sts_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_rjct_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"inv_cfm_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"whld_tax_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"inv_rjct_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"rtro_tml_inv_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"wrk_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"cost_cd_ftr_rmk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
					
				InitColumns(cols);					
				SetEditable(1);
				SetSheetHeight(300);
			}
		break;
		
		case 5:      //hidden_sheets4_etc init
			with(sheetObj){					  
				var HeadTitle="etcData";				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);				
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:500,  Align:"Center",  ColMerge:1,   SaveName:"etc_data",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				
				InitColumns(cols);				
				SetEditable(1);
				SetSheetHeight(240);				      
			}
		break;
	}
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[1]);
    ComResizeSheet(sheetObjects[2]);
}

/**
 * ibsheet1
 * 
 * @param {ibsheet}
 *            sheet_obj sheet object
 * @param {form}
 *            formObj from object
 * @param {String}
 *            sAction action value
 */
function doActionIBSheet1(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH:
            formObj.f_cmd.value = SEARCH01;
            formObj.vrfy_rslt_ind_cd.value = "CO";
            var searchXml = sheetObj.GetSearchData("ESD_TES_0064GS.do", tesFrmQryStr(formObj, 'calcOnDockComboItems|tmp_common_code|cntrTpszComboItems'));
            if (searchXml != "") {
            	sheetObj.LoadSearchData(searchXml, { Append: 1, Sync: 1 });
            }
            break;
            
        case IBSAVE: // Save
            formObj.f_cmd.value = MULTI;
            var param = sheetObj.GetSaveString() + "&" + sheetObjects[1].GetSaveString();
            var savexml = sheetObj.GetSaveData("ESD_TES_0064GS.do", param + '&' + tesFrmQryStr(formObj, 'calcOnDockComboItems|tmp_common_code|cntrTpszComboItems'));
            if (savexml != ""){
            	sheetObj.LoadSaveData(savexml, true);
            }
            break;
            
        case IBINSERT:
            var Row = sheetObj.DataInsert();
            break;
            
        case IBDOWNEXCEL: // down excel
            if (sheetObj.RowCount() < 1) { // no data
                ComShowCodeMessage("COM132501");
            } else {
                sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1 });
            }
            break;
    }
}

/**
 * handling sheet process
 * 
 * @param {ibsheet}
 *            sheet_obj sheet object
 * @param {form}
 *            formObj from object
 * @param {String}
 *            sAction action value
 */
function doActionIBSheet2(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH:
            formObj.f_cmd.value = SEARCH01;
            formObj.vrfy_rslt_ind_cd.value = "DC";
            var searchXml = sheetObj.GetSearchData("ESD_TES_0064GS.do", tesFrmQryStr(formObj, 'calcOnDockComboItems|tmp_common_code|cntrTpszComboItems'));
            if (searchXml != "") sheetObj.LoadSearchData(searchXml, { Append: 1, Sync: 1 });
            break;
            
        case IBSAVE: // Save
            break;
            
        case IBINSERT:
            var sRow = sheetObj.DataInsert();
            sheetObj.SetCellValue(sRow, "a", sheetObj.GetCellValue(sRow - 1, "a"), 0);
            break;
            
        case IBDOWNEXCEL: // down excel
            if (sheetObj.RowCount() < 1) { // no data
                ComShowCodeMessage("COM132501");
            } else {
                sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1 });
            }
            break;

        case IBSEARCH_ASYNC02:
            formObj.f_cmd.value = MULTI03;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0064GS.do", tesFrmQryStr(formObj, 'calcOnDockComboItems|tmp_common_code|cntrTpszComboItems'));
            var arrXml = searchXml.split("|$$|");
            sheetObjects[0].LoadSearchData(arrXml[0], { Sync: 0 });
            sheetObjects[1].LoadSearchData(arrXml[1], { Sync: 0 });
            searchXml = null;
            arrXml[0] = null;
            arrXml[1] = null;
            arrXml[2] = null;

            break;
    }
}

// handling sheet process
/**
 * @param {ibsheet}
 *            sheet_obj sheet object
 * @param {form}
 *            formObj from object
 * @param {String}
 *            sAction action value
 */
function doActionIBSheet3(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH:
            formObj.f_cmd.value = SEARCH02;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0064GS.do", tesFrmQryStr(formObj, 'calcOnDockComboItems|tmp_common_code|cntrTpszComboItems'));
            if (searchXml != "") {
            	sheetObj.LoadSearchData(searchXml, { Append: 1, Sync: 1 });
            }
            break;

        case IBSEARCH_ASYNC02:
            formObj.f_cmd.value = SEARCH18;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0064GS.do", tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            var dbCount = ComGetEtcData(searchXml, "db_cnt");
            var dbInv = ComGetEtcData(searchXml, "inv_no");

            if (dbCount > 0) { //db이 존재한다면
                if (ComShowConfirm("Double Billing Inv [ " + dbInv + " ] exists. Do you want to continue?")) {
                    tabObjects[0].SetSelectedIndex(2);
                    sheetObjects[2].RemoveAll();
                    doActionIBSheet3(sheetObjects[2], formObj, IBSEARCH);
                    t3sheet1_OnLoadFinish(sheetObjects[2]);
                    recalc_val = "Y";
                } else {
                    tabObjects[0].SetSelectedIndex(1);
                    doActionIBSheet2(sheetObjects[1], formObj, IBSEARCH_ASYNC02);
                }

            } else {
                tabObjects[0].SetSelectedIndex(2);
                sheetObjects[2].RemoveAll();
                doActionIBSheet3(sheetObjects[2], formObj, IBSEARCH);
                t3sheet1_OnLoadFinish(sheetObjects[2]);
                recalc_val = "Y";
            }
            break;

        case IBSAVE: // Save
            formObj.f_cmd.value = MULTI01;
            var param = sheetObj.GetSaveString();
            var savexml = sheetObj.GetSaveData("ESD_TES_0064GS.do", tesFrmQryStr(formObj, 'calcOnDockComboItems|tmp_common_code|cntrTpszComboItems|wrk_dt') + '&' + param);
            if (savexml != "") {
            	sheetObj.LoadSaveData(savexml, true);
            }
            break;
            
        case IBDELETE: // TES_TML_SO_DTL, TES_TML_SO_RVIS_LIST,
            // TES_N3RD_PTY_IF
            formObj.f_cmd.value = REMOVE01;
            var saveXml = sheetObj.GetSaveData("ESD_TES_0064GS.do", tesFrmQryStr(formObj, 'calcOnDockComboItems|tmp_common_code|cntrTpszComboItems'));
            sheetObj.LoadSaveData(saveXml, true);
            break;
    }
}

/**
 * handling sheet process
 * 
 * @param {ibsheet}
 *            sheet_obj sheet object
 * @param {form}
 *            formObj from object
 * @param {String}
 *            sAction action value
 */
function doActionIBSheet_main(sheetObj, formObj, sAction) { //main_hidden_OnSearchEnd
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH:
            formObj.f_cmd.value = SEARCH;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0064GS.do", tesFrmQryStr(formObj, 'calcOnDockComboItems|tmp_common_code|cntrTpszComboItems'));
            if (searchXml != "")
                sheetObj.LoadSearchData(searchXml, { Append: 0, Sync: 1 });
            break;
            
        case IBSAVE: // Save
            if (formObj.tml_so_seq.value == null || formObj.tml_so_seq.value == "") {
                formObj.f_cmd.value = ADD;
            } else {
                formObj.f_cmd.value = MODIFY;
            }
            var param = sheetObj.GetSaveString();

            var savexml = sheetObj.GetSaveData("ESD_TES_0064GS.do", tesFrmQryStr(formObj, 'calcOnDockComboItems|tmp_common_code|cntrTpszComboItems') + '&' + param);
            if (savexml != "") {
                sheetObj.RemoveAll();
                sheetObj.LoadSaveData(savexml, true);
            }
            break;
            
        case IBSEARCH_ASYNC04:
            formObj.f_cmd.value = SEARCH16;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0064GS.do", tesFrmQryStr(formObj, 'calcOnDockComboItems|tmp_common_code|cntrTpszComboItems'));
            var ydNm = ComGetEtcData(searchXml, "yd_nm");
            formObj.yd_nm.value = ydNm;
            validateYardCode();
            searchXml = null;
            break;

        case IBSEARCH_ASYNC05:
            formObj.f_cmd.value = SEARCH17;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0064GS.do", tesFrmQryStr(formObj, 'calcOnDockComboItems|tmp_common_code|cntrTpszComboItems'));
            var vndrNm = ComGetEtcData(searchXml, "vndr_nm");
            formObj.vndr_seq_nm.value = vndrNm;;
            searchXml = null;
            break;

    }
}

/**
 * hidden_sheets4_etc
 * 
 * @param {ibsheet}
 *            sheet_obj sheet object
 * @param {form}
 *            formObj from object
 * @param {String}
 *            sAction action value
 */
function doActionIBSheet_hidden_sheets4_etc(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH_ASYNC01: // Retrieve
            formObj.f_cmd.value = SEARCH10;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0064GS.do", tesFrmQryStr(formObj, 'calcOnDockComboItems|tmp_common_code|cntrTpszComboItems'));
            if (searchXml != "") {
                sheetObj.LoadSearchData(searchXml, { Append: 1, Sync: 1 });
            }
            break;
    }
}

/**
 * registering IBTab Object as list adding process for list in case of
 * needing batch processing with other items defining list on the top of
 * source
 * 
 * @param {tabObject}
 *            tab_obj tab object
 */
function setTabObject(tab_obj) {
    tabObjects[tabCnt++] = tab_obj;
}

/**
 * tab initialization
 * 
 * @param {tabObject}
 *            tabObj tab object
 * @param {tabNo}
 *            tabNo tab number
 */
function initTab(tabObj, tabNo) {
    switch (tabNo) {
        case 1:
            with(tabObj) {
                var cnt = 0;
                InsertItem("Verification", "");
                InsertItem("Discrepancy", "");
                InsertItem("Cost Calculation", "");
            }
            break;
    }
}

/**
 * tab change event
 * 
 * @param {tabObject}
 *            tabObj tab object
 * @param {String}
 *            nItem item
 */
function tab1_OnChange(tabObj, nItem) {
    var formObj = document.form;
    var objs = document.all.item("tabLayer");
    objs[nItem].style.display = "Inline";

    for (var i = 0; i < objs.length; i++) {
        if (i != nItem) {
            objs[i].style.display = "none";
            objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
        }
    }
    beforetab = nItem;
    resizeSheet();
}

/**
 * tab click event
 */
function tab1_OnClick(tabObj, tabNo) {
    var formObj = document.form;
    if (save_conf_01) {
        // ComShowMessage("tab1_OnClick nItem:"+tabNo);
        switch (tabNo) {}
    }
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
    with(formObj) {}
    return true;
}

/**
 * Component initialization
 * 
 * @param {String}
 *            sFlag flag Value
 */
function setInitComponent(sFlag) {
    var formObj = document.form;
    var flag_value = false;
    if (sFlag == "Y") {
        flag_value = true;
    } else {
        flag_value = false;
    }
    for (var e = 0; e < formObj.elements.length; e++) {
        var el = formObj.elements[e];
        ComEnableObject(el, false);
        $('button').prop('disabled', flag_value);

    }
    if (sFlag == "Y") { // 2010.10.15 rtro_tml_inv_flg 추가
        ComEnableManyObjects(true, formObj.yd_cd, formObj.cost_ofc_cd, formObj.ttl_inv_amt, formObj.iss_dt, formObj.vat_amt, formObj.rcv_dt, formObj.wrk_dt, formObj.hld_flg, formObj.err_inv_no, formObj.rtro_tml_inv_flg);

        if (WHLD_TAX_READONLY_MODE == false) {
            ComEnableObject(formObj.whld_tax_amt, true);
        }
    }

    ComEnableManyObjects(true, formObj.vndr_seq, formObj.inv_no);
    formObj.cost_ofc_cd.readOnly = true;

    //tabObjects[0].SetEnable=flag_value;
    //  	var tabObj=tabObjects[0];
    //  	for(var i=0; i < tabObj.GetCount(); i++) {
    //		tabObj.SetTabDisable(i, !flag_value);
    //	}

    var oldTabIdx = tab1.GetSelectedIndex();
    tab1.SetTabDisable(1, !flag_value);
    tab1.SetTabDisable(2, !flag_value);
    tab1.SetSelectedIndex(oldTabIdx);

    sheetObjects[0].SetEditable(flag_value);
    sheetObjects[1].SetEditable(flag_value);
    sheetObjects[2].SetEditable(flag_value);

    ComEnableObject(formObj.btn_pre_inquiry_cond, true);
    ComEnableObject(formObj.btn_retrieve, true);
    ComEnableObject(formObj.btn_new2, true);
    ComEnableObject(formObj.btn_new, true);
    ComEnableObject(formObj.btn_save, true);
    ComEnableObject(formObj.btn_vndr, true);
    ComEnableObject(formObj.btn_yard, true);
    ComEnableObject(formObj.btn_cost_ofc, true);
    ComEnableObject(formObj.btns_remarks, true);
    ComEnableObject(formObj.btns_calendar1, true);
    ComEnableObject(formObj.btns_calendar2, true);
    ComEnableObject(formObj.btns_calendar3, true);

    ComEnableObject(formObj.t1btng_clear, true);
    ComEnableObject(formObj.btng_todiscrepancy1, true);
    ComEnableObject(formObj.btng_fileimport1, true);
    ComEnableObject(formObj.btng_save1, true);
    ComEnableObject(formObj.t1btng_downexcel, true);
    ComEnableObject(formObj.btng_costcalc1, true);

    ComEnableObject(formObj.t2btng_clear, true);
    ComEnableObject(formObj.t2btng_verification, true);
    ComEnableObject(formObj.t2btng_reject, true);
    ComEnableObject(formObj.t2btng_downexcel, true);
    ComEnableObject(formObj.t2btng_print, true);

    ComEnableObject(formObj.t3btng_costCal, true);
    ComEnableObject(formObj.t3btng_clear, true);
    ComEnableObject(formObj.t3btng_rowadd, true);
    ComEnableObject(formObj.t3btng_rowdel, true);
    ComEnableObject(formObj.btng_save3, true);
    ComEnableObject(formObj.btng_totalamount3, true);
    ComEnableObject(formObj.btng_confirm3, true);

}

/**
 * check Search form
 * 
 * @param {form}
 *            formObj form object
 */
function fnChkSearchForm(formObj) {
    if (!fnChkEmptyObj(formObj.vndr_seq)) return false;
    if (!fnChkEmptyObj(formObj.inv_no)) return false;
    return true;
}

/**
 * Object Validation
 * 
 * @param obj -
 *            validation object
 */
function fnChkEmptyObj(obj) {
    if (obj.type == "text" || obj.type == "textarea" ||
        obj.type == "password" || obj.type == "file") {
        if (obj.value == null || obj.value == '') {
            ComShowMessage(ComGetMsg('TES21026', obj.title));
            obj.focus();
            return false;
        }
    } else if (obj.type.indexOf('select') != -1) {
        if (obj.selectedIndex == -1) {
            ComShowMessage(ComGetMsg('TES21027', obj.title));
            obj.focus();
            return false;
        }
    } else if (obj.type == 'radio') {
        var group = formObj[obj.name];
        var checked = false;
        if (!group.length)
            checked = obj.checked;
        else
            for (var r = 0; r < group.length; r++)
                if ((checked = group[r].checked))
                    break;
        if (!checked) {
            ComShowMessage(ComGetMsg('TES21027'), obj.title);
            obj.focus();
            return false;
        }
    } else if (obj.type == 'checkbox') {
        var group = formObj[obj.name];
        if (group.length) {
            var checked = false;
            for (var r = 0; r < group.length; r++)
                if ((checked = group[r].checked))
                    break;
            if (!checked) {
                ComShowMessage(ComGetMsg('TES21027', obj.title));
                obj.focus();
                return false;
            }
        }
    }
    return true;
}

/**
 * Form Validation
 * 
 * @param :
 *            obj - validation할 object
 */
function validChkForm(formObj) {
    for (var e = 0; e < formObj.elements.length; e++) {
        var el = formObj.elements[e];
        if (el.value == '1') {
            if (!fnChkEmptyObj(el)) return false;
        }
    }
    return true;
}

/**
 * @param {object}
 *            obj object
 */
function isNum(obj) {
    if (!ComIsNumber(obj)) {
        obj.value = '';
    }
}

/**
 * @param {object}
 *            obj object
 */
function isApNum(obj) {
    if (!ComIsAlphabet(obj, "n")) {
        obj.value = '';
    }
}

/*
 * @param {String} rowArray row
 */
function getYard(rowArray) {
    var colArray = rowArray[0];
    document.all.yd_cd.value = colArray[3];
    document.all.yd_nm.value = colArray[4];
    document.all.yd_cd_hidden.value = colArray[3];
    if (colArray[3] != undefined && colArray[3] != null && colArray[3].trim() != '') {
        // checkValidYardCode()에서 yd_cd가 있다면 MDM_YARD의 OFC_CD를 가져와서 넣어준다.       
        var rtnVal = getYdCdCostCdList(); // tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');           
        if(rtnVal.length > 0){
        	checkValidYardCode(rtnVal);
        } 
    }
    // document.all.cost_ofc_cd .class = "noinput1";
    document.all.cost_ofc_cd.readOnly = false;
}

function setCostOfcReadOnlyFalse(argOfcCd) {
    var formObj = document.form;   
    formObj.cost_ofc_cd.readOnly = false;    
    
    if(!tesIsEmpty(argOfcCd)){
    	formObj.cost_ofc_cd.value = argOfcCd;
    	formObj.cost_ofc_hidden.value = argOfcCd;
    }
}

/* 
 */
// function checkValidCostOfc(){
// var formObj = document.form;
// if (formObj.is_valid_cost_ofc.value!=null &&
// formObj.is_valid_cost_ofc.value=='Y'){
// formObj.cost_ofc_hidden.value = formObj.cost_ofc_cd.value;
// } else {
// formObj.cost_ofc_hidden.value = '';
// ComShowMessage(ComGetMsg('TES21038'));
// formObj.cost_ofc_cd.value = '';
// }
// }

/**
 * cost ofc code valid check
 */
function checkValidCostOfc() {
    var formObj = document.form;
    var tmp = '';
    if (formObj.is_valid_cost_ofc_cd.value != undefined && formObj.is_valid_cost_ofc_cd.value != null && formObj.is_valid_cost_ofc_cd.value.trim() != '') {
        tmp = formObj.is_valid_cost_ofc_cd.value.split('|');
        if (tmp.length > 0) {
            formObj.is_valid_cost_ofc_cd.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_cost_ofc_cd.value != null && formObj.is_valid_cost_ofc_cd.value == 'Y') {
                if (tmp[1] != undefined && tmp[1] != null && tmp[1].trim() != '') {
                    if (tmp[1].trim() != 'Y') {
                        ComShowMessage(ComGetMsg('TES21036'));
                        // formObj.yd_cd.focus();
                    }
                } else {
                    ComShowMessage(ComGetMsg('TES21037'));
                    return false;
                }
            } else {
                formObj.is_valid_cost_ofc_cd.value = '';
                ComShowMessage(ComGetMsg('TES21038'));
                return false;
            }
        } else {
            formObj.is_valid_cost_ofc_cd.value = '';
            ComShowMessage(ComGetMsg('TES21038'));
            return false;
        }
    } else {
        formObj.is_valid_cost_ofc_cd.value = '';
        ComShowMessage(ComGetMsg('TES21038'));
        return false;
    }
}

/*
 * @param {String} rowArray row
 */
function getOfcCd(rowArray) {
    var colArray = rowArray[0];
    document.all.cost_ofc_cd.value = (colArray[3] != undefined && colArray[3] != null ? colArray[3] : '');
}

/*
 * YardCode Validation
 */
function checkValidYardCode(rtnVal) {
    var formObj = document.form;
    var tmp_yd_cd_hidden;
    var tmp = '';
    if (rtnVal != undefined && rtnVal != null && rtnVal != '') {
        tmp = rtnVal.split('--');
        if (tmp.length > 0) {
            formObj.is_valid_yd_cd.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_yd_cd.value != null && formObj.is_valid_yd_cd.value == 'Y') {
                // ComShowMessage('yd_cd_hidden:' +
                // formObj.yd_cd_hidden.value + '\nyd_cd:' +
                // formObj.yd_cd.value);
                if (formObj.yd_cd.value != null && formObj.yd_cd.value.trim() != '' && formObj.yd_cd_hidden.value != formObj.yd_cd.value) {
                    if (sheetObjects[3].RowCount() > 0 &&
                        formObj.yd_cd.value.trim() != sheetObjects[3].GetCellValue(1, 'yd_cd').trim() &&
                        (sheetObjects[0].RowCount() > 0 || sheetObjects[2].RowCount() > 0)) {
                        if (!confirm(ComGetMsg('TES40027'))) {
                            formObj.yd_cd.value = formObj.yd_cd_hidden.value;
                            return false;
                        } else {
                            if (deleteContanerList()) gridSave();
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
                formObj.calcOnDockComboItems.value = (tmp[10] != undefined && tmp[10] != null ? tmp[10] : '');
                var rtnOfcCd = "";
                if ((formObj.tml_so_ofc_cty_cd.value == '' && formObj.tml_so_seq.value == '') || formObj.yd_cd.value != tmp_yd_cd_hidden || formObj.cost_ofc_hidden.value != formObj.cost_ofc_cd.value) {                    
                   	rtnOfcCd = getOfcCdByYardCd(); //tes_getInputValue('cost_ofc_cd', SEARCH02, 'yd_cd', 'setCostOfcReadOnlyFalse');
                    setCostOfcReadOnlyFalse(rtnOfcCd);
                } else {
                    setCostOfcReadOnlyFalse(rtnOfcCd);
                }
                if (sheetObjects[2].RowCount() > 0) {
                    setCalcOnDocklManualCostCode(sheetObjects[2]);
                }
            } else {
                ComShowMessage(ComGetMsg('TES21039'));
                formObj.is_valid_yd_cd.value = '';
                formObj.yd_cd_hidden.value = '';
                formObj.yd_nm.value = '';
                // formObj.yd_cd .value = '';
                formObj.yd_cd.focus();
            }
        } else {
            ComShowMessage(ComGetMsg('TES21039'));
            formObj.is_valid_yd_cd.value = '';
            formObj.yd_cd_hidden.value = '';
            formObj.yd_nm.value = '';
            // formObj.yd_cd .value = '';
            formObj.yd_cd.focus();
        }
    } else {
        ComShowMessage(ComGetMsg('TES21039'));
        formObj.is_valid_yd_cd.value = '';
        formObj.yd_cd_hidden.value = '';
        formObj.yd_nm.value = '';
        // formObj.yd_cd .value = '';
        formObj.yd_cd.focus();
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

/*
 * VndrCode Validation
 */
function checkValidVndrCode() {
    // ComShowMessage("checkValidVndrCode");
    var formObj = document.form;
    var tmp = '';
    // ComShowMessage('is_valid_vndr_seq:'+formObj.is_valid_vndr_seq.value);
    if (formObj.is_valid_vndr_seq.value != undefined && formObj.is_valid_vndr_seq.value != null && formObj.is_valid_vndr_seq.value.trim() != '') {
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
                formObj.vndr_seq.focus();
            }
        } else {
            formObj.is_valid_vndr_seq.value = '';
            formObj.vndr_seq_hidden.value = '';
            ComShowMessage(ComGetMsg('TES21040'));
            formObj.vndr_seq.focus();
        }
    } else {
        formObj.is_valid_vndr_seq.value = '';
        formObj.vndr_seq_hidden.value = '';
        ComShowMessage(ComGetMsg('TES21040'));
        formObj.vndr_seq.focus();
    }
}

/*
 */
function getVender(rowArray) {
    var colArray = rowArray[0];
    // ComShowMessage(colArray);
    document.all.vndr_seq.value = colArray[2];
    document.all.vndr_seq_nm.value = colArray[4];
}

/*
 * function deleteComma(src){ //ComShowMessage("deleteComma"); var
 * src=String(src); if (src==null || trim(src)==''){ return ''; } return
 * src.replace(/,/gi,''); }
 */

/**
 * @param {String}
 *            src
 */
function addComma2(src) {
    var src = new String(src);
    if (src == null || trim(src) == '') {
        return '';
    }
    var re = /(-?\d+)(\d{3})/;
    while (re.test(src)) {
        src = src.replace(re, "$1,$2");
    }
    return src;
}

/**
 * check Number
 */
function checkNumber() {
    var objEv = ComGetEvent();
    var numPattern = /([^0-9])/;
    numPattern = objEv.value.match(numPattern);
    if (numPattern != null) {
        ComShowMessage(ComGetMsg('TES21041'));
        objEv.value = "";
        objEv.focus();
        return false;
    }
}

/**
 * Reject
 * 
 */
function rjctInv() {
    var formObj = document.form;
    formObj.tml_inv_rjct_sts_cd.value = 'RJ';
    invHeaderSave(sheetObjects[3], formObj);
    retrieveEvent(sheetObjects[3], formObj);
}

/**
 * Invoice No input event
 * 
 */
function onKeyInvNoEnvent() {
    var formObj = document.form;
    retrieveEvent(sheetObjects[3], formObj);
}

/**
 * Validation CostOFC
 * 
 */
function validateCostOFC() {
    var formObj = document.form;
    if (formObj.cost_ofc_cd.readOnly == false) {
        if ((formObj.cost_ofc_hidden.value == null || formObj.cost_ofc_hidden.value.trim() == '') || formObj.cost_ofc_cd.value != formObj.cost_ofc_hidden.value) {
            getCostOfcValidYN(); // tes_getInputValue('is_valid_cost_ofc_cd', SEARCH04, 'cost_ofc_cd|yd_cd', 'checkValidCostOfc');
        }
    }
}

/**
 * Validation YardCode
 * 
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
        
        var rtnVal = getYdCdCostCdList(); // tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');           
        if(rtnVal.length > 0){
        	checkValidYardCode(rtnVal);
        }        
    }
}

/**
 * Validation vndr_seq
 * 
 */
function validateVndrSeq() {
    var formObj = document.form;
    if (formObj.vndr_seq.value == null || formObj.vndr_seq.value.trim() == '') {
        formObj.vndr_seq_hidden.value = '';
        formObj.is_valid_vndr_seq.value = '';
        return false;
    }
    
    if (formObj.vndr_seq.value.length < 6) {
        formObj.vndr_seq.value = tes_lpad(formObj.vndr_seq.value, 6, 0);
    }
    
    if ((formObj.vndr_seq_hidden.value == null || formObj.vndr_seq_hidden.value.trim() == '') || formObj.vndr_seq.value.trim() != formObj.vndr_seq_hidden.value.trim()) {
        formObj.vndr_seq_hidden.value = '';
        formObj.is_valid_vndr_seq.value = '';
		
		var sRtnVal = getVndrSeqNm();
        if(sRtnVal == "Y"){
        	formObj.is_valid_vndr_seq.value = sRtnVal;
        	formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
        }
        
        //doActionIBSheet_main(sheetObjects[3], formObj, IBSEARCH_ASYNC05);
        //tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVndrCode');
    }
}

/**
 * add dot
 * 
 * @param {object}
 *            obj object
 * @param {int}
 *            len length
 */
function addDot(obj, len) {
    var tem_val = 0;
    var strLen = 0;
    tem_val = obj.value;
    obj.value = (tem_val == 0 ? "0.00" : tem_val);
    if (obj.value.indexOf(".") == -1) strLen = 0;
    else
        strLen = tes_getStrLen(obj.value.substr(obj.value.indexOf(".") + 1, tes_getStrLen(obj.value)));
    if (strLen > len) {
        obj.value = obj.value.substr(0, obj.value.indexOf(".") + len + 1);
    }
}

/**
 * add dot
 * 
 * @param {object}
 *            obj object
 * @param {int}
 *            len length
 */
function addDot2(src, len) {
    var tem_val = 0;
    tem_val = src;
    src = (tem_val == 0 ? "0.00" : tem_val);
    if (src.indexOf(".") == -1) src += ".";
    var strLen = tes_getStrLen(src.substr(src.indexOf(".") + 1, tes_getStrLen(src)));
    if (strLen < len) {
        for (var i = 0; i < (len - strLen); i++) {
            src += "0";
        }
    } else if (strLen > len) {
        src = src.substr(0, src.indexOf(".") + len + 1);
    }
    return src;
}

/*
 * Header Data save @param {ibsheet} sheetObject_main ib sheet @param {form}
 * formObj form object
 */
function invHeaderSave(sheetObject_main, formObj) { //alert("start invHeaderSave");
    //     validChkForm(formObj);
    setForm2HdSheet(sheetObject_main);
    doActionIBSheet_main(sheetObject_main, formObj, IBSAVE);
    onSaveEnd(sheetObject_main);
}

/*
 * Sheet Save end event @param {ibsheet} sheetObj
 */
function onSaveEnd(sheetObj) {
    if (sheetObj.RowCount() == 1) {
        setHdSheet2Form(sheetObj);
    } else if (sheetObj.RowCount() > 1) {
        ComShowMessage(ComGetMsg('TES21032'));
        return;
    } else {
        // setHeaderKeyValueReadonly('N');
        // /setSheetsEnable(0, false, false, false, false, false);
        ComShowMessage(ComGetMsg('TES21034'));
        return;
    }
}

/**
 * Sheet Click Event
 * 
 */
function t1sheet1_OnClick(t1sheet1, row, col) {
    var formObj = document.form;
    formObj.temp_val.value = "";
    if (t1sheet1.ColSaveName(col) == "cntr_sty_cd") {
        formObj.temp_val.value = t1sheet1.GetCellValue(row, "cntr_sty_cd");
    } else if (t1sheet1.ColSaveName(col) == "dcgo_clss_cd") { // cjlick
        // 여부만
        // 확인
        formObj.temp_val.value = "Y";
    }
    if (t1sheet1.ColSaveName(col) == "chk" && t1sheet1.GetCellValue(row, 'dscr_ind_cd') != 'CO' && t1sheet1.GetCellEditable(row, "chk") == false) {
        t1sheet1.SetCellEditable(row, "chk", 1);
        if (t1sheet1.GetCellValue(row, "chk") == 1) {
            t1sheet1.SetCellValue(row, "chk", 0, 0);
        } else {
            t1sheet1.SetCellValue(row, "chk", 1, 0);
        }
    }
}

/**
 * clear Auto Calculated List
 * 
 */
function clearCalcList() {
    var formObj = document.form;
    var confirm_value = false;
    if (formObj.temp_val.value.length > 0) { // onClick 이벤트 발생으로 인한 onChange임을 확인
        confirm_value = confirm(ComGetMsg('TES23070'));
        if (confirm_value) {
            for (var i = sheetObjects[2].HeaderRows(); i < sheetObjects[2].HeaderRows() + sheetObjects[2].RowCount(); i++) {
                if (sheetObjects[2].GetCellValue(i, "calc_tp_cd") == "A") {
                    sheetObjects[2].SetRowStatus(i, "D");
                    i--;
                }
            }
        }
    }
    return confirm_value;
}

/**
 * Sheet Change Event
 * 
 */
var change_count = 0;

function t1sheet1_OnChange(t1sheet1, row, col) {
    var formObj = document.form;
    if (formObj.temp_val.value.length > 0) {
        change_count++;
    }
    if (change_count == 1) {
        clearCalcList();
        recalc_val == "N";
    }
    if (t1sheet1.ColSaveName(col) == "cntr_sty_cd") {} else if (t1sheet1.ColSaveName(col) == "dcgo_clss_cd") {}
}

/**
 * sheet load event
 */
function t1sheet1_OnLoadFinish(sheetObj) {
    var formObj = document.form;
    var max_wrk_dt = "";
    var min_wrk_dt = "";

    if (sheetObj.RowCount() > 1) {
        max_wrk_dt = sheetObj.GetCellValue(sheetObj.HeaderRows(), "wrk_dt");
        min_wrk_dt = sheetObj.GetCellValue(sheetObj.HeaderRows(), "wrk_dt");
    }

    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        if (max_wrk_dt < sheetObj.GetCellValue(i, "wrk_dt")) max_wrk_dt = sheetObj.GetCellValue(i, "wrk_dt");
        if (min_wrk_dt > sheetObj.GetCellValue(i, "wrk_dt")) min_wrk_dt = sheetObj.GetCellValue(i, "wrk_dt");
        if (sheetObj.GetCellValue(i, "modi_flg") == "Y") {
            sheetObj.SetCellEditable(i, "chk", 1);
        }
        if (formObj.tml_inv_sts_cd.value == "R" && (formObj.tml_inv_rjct_sts_cd.value == "NL" || formObj.tml_inv_rjct_sts_cd.value == "RL")) {
            sheetObj.SetCellEditable(i, "cntr_sty_cd", 1);
            sheetObj.SetCellEditable(i, "dcgo_clss_cd", 1);
        }
        if (sheetObj.GetCellValue(i, "dscr_dtl_ind_cd") == "F") {
            sheetObj.SetCellBackColor(i, "cntr_sty_cd", "#FFFF66");
            sheetObj.SetCellFontColor(i, "cntr_sty_cd", "#FF0000");
        } else if (sheetObj.GetCellValue(i, "dscr_dtl_ind_cd") == "T") {
            sheetObj.SetCellBackColor(i, "cntr_tpsz_cd", "#FFFF66");
            sheetObj.SetCellFontColor(i, "cntr_tpsz_cd", "#FF0000");
        }
        if (sheetObj.GetCellValue(i, 'dscr_ind_cd') == 'CO') {
            sheetObj.SetToolTipText(i, 'dscr_ind_cd', 'Verification');
        } else if (sheetObj.GetCellValue(i, 'dscr_ind_cd') == 'HO') {
            sheetObj.SetToolTipText(i, 'dscr_ind_cd', 'NYK List only');
        } else if (sheetObj.GetCellValue(i, 'dscr_ind_cd') == 'HD') {
            sheetObj.SetToolTipText(i, 'dscr_ind_cd', 'NYK List double');
        } else if (sheetObj.GetCellValue(i, 'dscr_ind_cd') == 'NH') {
            sheetObj.SetToolTipText(i, 'dscr_ind_cd', 'Not in NYK source');
        } else if (sheetObj.GetCellValue(i, 'dscr_ind_cd') == 'DB') {
            sheetObj.SetToolTipText(i, 'dscr_ind_cd', 'Double billing');
        } else if (sheetObj.GetCellValue(i, 'dscr_ind_cd') == 'DD') {
            sheetObj.SetToolTipText(i, 'dscr_ind_cd', 'Discrepancy by detail data');
        } else if (sheetObj.GetCellValue(i, 'dscr_ind_cd') == 'NN') {
            sheetObj.SetToolTipText(i, 'dscr_ind_cd', 'Container does not exist in this yard');
        }
    }

    if (sheetObj.RowCount() == 1) { // There is one row in the sheetObj.
        document.form.max_wrk_dt.value = max_wrk_dt;
        document.form.min_wrk_dt.value = max_wrk_dt;
    } else {
        document.form.max_wrk_dt.value = document.form.wrk_dt.value;
        document.form.min_wrk_dt.value = document.form.wrk_dt.value;
    }

    sumaryContainerList(sheetObj);
    validateYardCode();
}

/**
 * Sheet LoadFinish Event
 * 
 */
function t2sheet1_OnLoadFinish(sheetObj) {
    var formObj = document.form;
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        if (formObj.tml_inv_sts_cd.value == "R" && (formObj.tml_inv_rjct_sts_cd.value == "NL" || formObj.tml_inv_rjct_sts_cd.value == "RL")) {
            // sheetObj.CellEditable(i,"cntr_sty_cd" ) = true;
            sheetObj.SetCellEditable(i, "dcgo_clss_cd", 1);
        }
        if (sheetObj.GetCellValue(i, "dscr_dtl_ind_cd") == "F") {
            sheetObj.SetCellBackColor(i, "cntr_sty_cd", "#FFFF66");
            sheetObj.SetCellFontColor(i, "cntr_sty_cd", "#FF0000");
        } else if (sheetObj.GetCellValue(i, "dscr_dtl_ind_cd") == "T") {
            sheetObj.SetCellBackColor(i, "cntr_tpsz_cd", "#FFFF66");
            sheetObj.SetCellFontColor(i, "cntr_tpsz_cd", "#FF0000");
        }
        //			if(document.form.yd_cd.value.substring(0,2) == 'US' && (sheetObj.GetCellValue(i,'dscr_ind_cd') == 'HD'||sheetObj.GetCellValue(i,'dscr_ind_cd') == 'DB')){
        //			    sheetObj.SetCellEditable(i, 'chk',0);
        //			}
    }
}

/**
 * Sheet LoadFinish Event
 * 
 */
function t3sheet1_OnLoadFinish(sheetObj) {
    var formObj = document.form;
    var tot_amt = 0;
    if (sheetObj.RowCount() > 0) {
        setCalcOnDocklManualCostCode(sheetObj, 'Y');
        for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
            if (sheetObj.GetCellValue(i, 'calc_tp_cd') == 'M' || sheetObj.GetCellValue(i, 'calc_tp_cd') == 'S') {
                sheetObj.InitCellProperty(i, "rvis_vol_qty", {
                    Type: "Data"
                });
            } else {
                // if(max_wrk_dt < sheetObj.GetCellValue(i, "wrk_dt")) max_wrk_dt
                // =sheetObj.GetCellValue(i, "wrk_dt");
                // if(min_wrk_dt > sheetObj.GetCellValue(i, "wrk_dt")) min_wrk_dt
                // =sheetObj.GetCellValue(i, "wrk_dt");
            }
            if (sheetObj.GetCellValue(i, "tml_so_dtl_seq") == "0") {
                sheetObj.SetRowStatus(i, "I");
            } else {
                sheetObj.SetRowStatus(i, "R");
            }
            if (sheetObj.GetCellValue(i, 'tml_wrk_dy_cd') == 'WD') {
                sheetObj.SetToolTipText(i, 'tml_wrk_dy_cd', 'Week day');
            } else if (sheetObj.GetCellValue(i, 'tml_wrk_dy_cd') == 'SA') {
                sheetObj.SetToolTipText(i, 'tml_wrk_dy_cd', 'Saturday');
            } else if (sheetObj.GetCellValue(i, 'tml_wrk_dy_cd') == 'SU') {
                sheetObj.SetToolTipText(i, 'tml_wrk_dy_cd', 'Sunday');
            } else if (sheetObj.GetCellValue(i, 'tml_wrk_dy_cd') == 'HO') {
                sheetObj.SetToolTipText(i, 'tml_wrk_dy_cd', 'Holiday');
            }
            if (sheetObj.GetCellValue(i, 'vol_tr_ut_cd') == 'C') {
                sheetObj.SetToolTipText(i, 'vol_tr_ut_cd', 'Container');
            } else if (sheetObj.GetCellValue(i, 'vol_tr_ut_cd') == 'T') {
                sheetObj.SetToolTipText(i, 'vol_tr_ut_cd', 'TEU');
            } else if (sheetObj.GetCellValue(i, 'vol_tr_ut_cd') == 'U') {
                sheetObj.SetToolTipText(i, 'vol_tr_ut_cd', 'BOX');
            } else if (sheetObj.GetCellValue(i, 'vol_tr_ut_cd') == 'M') {
                sheetObj.SetToolTipText(i, 'vol_tr_ut_cd', 'Move');
            } else if (sheetObj.GetCellValue(i, 'vol_tr_ut_cd') == 'G') {
                sheetObj.SetToolTipText(i, 'vol_tr_ut_cd', 'Gang/Hour');
            }
        }
        calcurationTotalAmt(sheetObj, formObj);
    }
}

/**
 * search end event
 */
function t1sheet1_OnSearchEnd(sheetObj, errMsg) {
    if (errMsg != null && errMsg) {
        ComShowMessage(errMsg);
    }
}

/**
 * search end event
 */
function t3sheet1_OnSearchEnd(sheetObj, errMsg) { // alert("start
    // t3sheet1_OnSearchEnd");
    var formObj = document.form;
    var tmp_cnt = 0;
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        sheetObj.CellComboItem(i, 'cntr_tpsz_cd', {
            ComboText: document.form.cntrTpszComboItems.value,
            ComboCode: document.form.cntrTpszComboItems.value
        });
        sheetObj.SetCellValue(i, "lgs_cost_cd", sheetObj.GetCellValue(i, "lgs_cost_cd2"), 0);
        sheetObj.SetCellValue(i, "cntr_tpsz_cd", sheetObj.GetCellValue(i, "cntr_tpsz_cd2"), 0);

        if (sheetObj.GetCellValue(i, 'calc_tp_cd') == 'M') {
            setShtCellsEditable(sheetObj, i, "lgs_cost_cd|cntr_tpsz_cd|tml_wrk_dy_cd|dcgo_ind_cd|wrk_dt|rvis_vol_qty|vol_tr_ut_cd|ctrt_rt|calc_vol_qty|inv_amt|calc_rmk|n3pty_flg|inv_xch_rt", 'Y');
        }

        if (sheetObj.GetCellValue(i, 'calc_tp_cd') == 'S') {
            //			  	setShtCellsEditable(sheetObj,i,"lgs_cost_cd|cntr_tpsz_cd|tml_wrk_dy_cd|dcgo_ind_cd|rvis_vol_qty|vol_tr_ut_cd|ctrt_rt|calc_vol_qty|inv_amt|calc_rmk|n3pty_flg|inv_xch_rt",'Y');
            setShtCellsEditable(sheetObj, i, 'lgs_cost_cd|stay_dys|calc_vol_qty|ctrt_rt|inv_amt|inv_xch_rt', 'Y', "EXCEPTION");
            setShtCellsEditable(sheetObj, i, 'free_dys|paid_day|free_dy_xcld_dys', 'N', "EXCEPTION");
        }

        if (curr_cd.GetSelectCode() != sheetObj.GetCellValue(i, 'curr_cd') && sheetObj.GetCellValue(i, 'curr_cd') != '') {
            setShtCellsEditable(sheetObj, i, 'inv_xch_rt', 'Y', 'EXCEPTION');
        }
    }
}

/**
 * Cost Calculation set Combo Code
 * 
 */
function setCalcOnDocklManualCostCode(sheet, INIT) {
    var formObj = document.form;
    for (var i = sheet.HeaderRows(); i < sheet.HeaderRows() + sheet.RowCount(); i++) {
        if (sheet.GetCellValue(i, 'calc_tp_cd') == 'M' || sheet.GetCellValue(i, 'calc_tp_cd') == 'S') {
            org_sts = sheet.GetRowStatus(i);
            sheet.CellComboItem(i, 'lgs_cost_cd', {
                ComboText: formObj.calcOnDockComboItems.value,
                ComboCode: formObj.calcOnDockComboItems.value
            });
            sheet.CellComboItem(i, 'cntr_tpsz_cd', {
                ComboText: formObj.cntrTpszComboItems.value,
                ComboCode: formObj.cntrTpszComboItems.value
            });
            sheet.SetCellValue(i, 'lgs_cost_cd', sheet.GetCellValue(i, 'lgs_cost_cd2'), 0);
            sheet.SetCellValue(i, 'cntr_tpsz_cd', sheet.GetCellValue(i, 'cntr_tpsz_cd2'), 0);
            sheet.SetRowStatus(i, org_sts);
        }
    }
}

/**
 * 
 * @param sheetObj
 * @return
 */
function isOnDockInvoice(sheetObj) {
    if (sheetObj.RowCount() == 1) {
        if (sheetObj.GetCellValue(1, "tml_inv_tp_cd") == "TM") {
            ComShowMessage(ComGetMsg('TES22026'));
            setInitComponent("N");
            return false;
        } else if (sheetObj.GetCellValue(1, "tml_inv_tp_cd") == "OF") {
            ComShowMessage(ComGetMsg('TES21030'));
            setInitComponent("N");
            return false;
        } else if (sheetObj.GetCellValue(1, "tml_inv_tp_cd") == "ST") {
            ComShowMessage(ComGetMsg('TES21031'));
            setInitComponent("N");
            return false;
        } else if (sheetObj.GetCellValue(1, "tml_inv_tp_cd") == "ON") {
            return true;
        }
    }
}

/**
 * search end event
 * 
 */
function main_hidden_OnSearchEnd(sheetObj) { //alert("main_hidden_OnSearchEnd===========");
    var formObj = document.form;
    retrieve_conf_01 = true;
    if (sheetObj.RowCount() == 1) {
        if (isOnDockInvoice(sheetObj) == false) {
            return false;
        }
        if (formObj.inv_ofc_cd.value == '' || formObj.inv_ofc_cd.value == null || formObj.inv_ofc_cd.value == undefined) {
            ComShowMessage('No Inv OFC data is found in the session');
            return false;
        }
        if (formObj.inv_ofc_cd.value != sheetObj.GetCellValue(1, 'inv_ofc_cd')) {
            ComShowMessage("No authority to correct/delete the invoice - Invoice office mismatch!");
            return false;
        }

        save_conf_01 = true;
        setHdSheet2Form(sheetObj);

        if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
            ComShowMessage("Rejected Invoice !!");
            return false;
        }

        if (document.form.tml_so_ofc_cty_cd.value != null || document.form.tml_so_ofc_cty_cd.value != "" ||
            document.form.tml_so_seq.value != null || document.form.tml_so_seq.value != "" ||
            (document.form.tml_inv_rjct_sts_cd.value != "RJ" && document.form.tml_inv_sts_cd.value != "R") || // Received
            // &
            // Rejected
            document.form.tml_inv_sts_cd.value != "A" || document.form.tml_inv_sts_cd.value != "P") {
            if (sheetObj.GetCellValue(1, 'tml_inv_sts_cd') == "C") {
                var confirm_value = confirm(ComGetMsg('TES22029'));
                if (confirm_value) {
                    if (document.form.tml_inv_rjct_sts_cd.value == "RJ") {
                        document.form.tml_inv_rjct_sts_cd.value = "RL";
                    }
                    document.form.tml_inv_sts_cd.value = "R";
                    invHeaderSave(sheetObj, document.form);
                    sheetObj.RemoveAll();
                    doActionIBSheet_main(sheetObj, formObj, IBSEARCH);
                    setInitComponent("Y");
                    sheetObjects[0].SetEditable(1);
                    sheetObjects[1].SetEditable(1);
                    sheetObjects[2].SetEditable(1);
                } else {
                    setInitComponent("N");
                    return false;
                }
            } else {
                setInitComponent("Y");
                sheetObjects[0].SetEditable(1);
                sheetObjects[1].SetEditable(1);
                sheetObjects[2].SetEditable(1);
            } // AP
            // Interfased
        } else {
            setInitComponent("Y");
            sheetObjects[0].SetEditable(1);
            sheetObjects[1].SetEditable(1);
            sheetObjects[2].SetEditable(1);
            ComEnableManyObjects(false, vndr_seq, inv_no);
            return false;
        }
        
        if (document.form.yd_cd.value != null && document.form.yd_cd.value.trim() != '') {
        	var rtnVal = getYdCdCostCdList(); // tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');           
	        if(rtnVal.length > 0){
	        	checkValidYardCode(rtnVal);
	        }            
        }
        
        validateVndrSeq();

        doActionIBSheet_hidden_sheets4_etc(sheetObjects[4], formObj, IBSEARCH_ASYNC01);
        var tpszCodeValue = sheetObjects[4].GetEtcData("tpszCode");
        var costCodeValue = sheetObjects[4].GetEtcData("costCode");
        for (p = 1; p < comboObjects.length; p++) {
            initCombo(comboObjects[p], p + 1, "", "", tpszCodeValue);
        }
        sheetEtcDataToForm(document.form, sheetObjects[4]);
        doActionIBSheet1(sheetObjects[0], formObj, IBSEARCH);
        t1sheet1_OnLoadFinish(sheetObjects[0]);
        doActionIBSheet2(sheetObjects[1], formObj, IBSEARCH);
        t2sheet1_OnLoadFinish(sheetObjects[1]);
        sheetObjects[2].RemoveAll();
        formObj.cost_calc_mode.value = "R";
        doActionIBSheet3(sheetObjects[2], formObj, IBSEARCH);
        t3sheet1_OnLoadFinish(sheetObjects[2]);
        try {
            for (var i = 0; i < formObj.elements.length; i++) {
                if (formObj.elements[i].name != null && formObj.elements[i].name.trim() != '' &&
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
        tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt|wrk_dt"));
		
		var costCdFtrRmk = formObj.cost_cd_ftr_rmk.value;
        getAgmtCostCdList(1, 75, 150, costCdFtrRmk); // tes_getComboItem('agmt_lgs_cost_cd', 2, SEARCHLIST10, '', 'vndr_seq|yd_cd|agmt_ftr_inv_tp_cd|atb_dt', 'setAgmtCostCd');        

    } else if (sheetObj.RowCount() > 1) {
        ComShowMessage(ComGetMsg('TES21032'));
        return;
    } else {
        var confirm_value = ComShowConfirm(ComGetMsg('TES40031'));
        if (confirm_value) {
            setInitComponent("Y");
            sheetObjects[0].SetEditable(1);
            sheetObjects[1].SetEditable(1);
            sheetObjects[2].SetEditable(1);
            formObj.yd_cd.focus();
        } else {
            setInitComponent("N");
            return;
        }
    }
    return true;
}

function main_hidden_OnSaveEnd(sheetObj) {    
    var costCdFtrRmk = document.form.cost_cd_ftr_rmk.value;
    getAgmtCostCdList(1, 75, 150, costCdFtrRmk); // tes_getComboItem('agmt_lgs_cost_cd', 2, SEARCHLIST10, '', 'vndr_seq|yd_cd|agmt_ftr_inv_tp_cd|atb_dt', 'setAgmtCostCd');    
}

/*
 * Etc Sheet Data Form Copy
 */
function sheetEtcDataToForm(formObj, sheetObj) {
    formObj.cntrTpszComboItems.value = sheetObj.GetEtcData("tpszCode");
}

/*
 * Form Data Sheet Copy
 */
function setForm2HdSheet(sheetObj) {
    var formObj = document.form;
    if (sheetObj.RowCount() == 0) {
        // Add row
        sheetObj.DataInsert(0);
    } else if (sheetObj.RowCount() == 1) {
        sheetObj.SetRowStatus(1, "U");
    } else {
        ComShowMessage('ERR');
        return false;
    }
    sheetObj.SetCellValue(1, 'tml_so_ofc_cty_cd', formObj.tml_so_ofc_cty_cd.value);
    sheetObj.SetCellValue(1, 'tml_so_seq', formObj.tml_so_seq.value);
    sheetObj.SetCellValue(1, 'tml_inv_tp_cd', formObj.tml_inv_tp_cd.value);
    sheetObj.SetCellValue(1, 'inv_ofc_cd', formObj.inv_ofc_cd.value);
    sheetObj.SetCellValue(1, 'cost_ofc_cd', formObj.cost_ofc_cd.value);
    sheetObj.SetCellValue(1, 'inv_no', formObj.inv_no.value);
    sheetObj.SetCellValue(1, 'vndr_seq', formObj.vndr_seq.value);
    sheetObj.SetCellValue(1, 'yd_cd', formObj.yd_cd.value);
    //	sheetObj.SetCellValue(1, 'curr_cd'			  ,curr_cd.GetSelectCode());
    sheetObj.SetCellValue(1, 'ttl_inv_amt', ComTrimAll(formObj.ttl_inv_amt.value, ","));
    sheetObj.SetCellValue(1, 'vat_amt', ComTrimAll(formObj.vat_amt.value, ","));
    sheetObj.SetCellValue(1, 'whld_tax_amt', ComTrimAll(formObj.whld_tax_amt.value, ","));
    sheetObj.SetCellValue(1, 'iss_dt', formObj.iss_dt.value);
    sheetObj.SetCellValue(1, 'rcv_dt', formObj.rcv_dt.value);
    sheetObj.SetCellValue(1, 'tml_inv_sts_cd', formObj.tml_inv_sts_cd.value);
    sheetObj.SetCellValue(1, 'tml_inv_rjct_sts_cd', formObj.tml_inv_rjct_sts_cd.value);
    sheetObj.SetCellValue(1, 'hld_rmk', formObj.hld_rmk.value);
    sheetObj.SetCellValue(1, 'inv_rjct_rmk', formObj.inv_rjct_rmk.value);

    sheetObj.SetCellValue(1, 'wrk_dt', formObj.wrk_dt.value);

    sheetObj.SetCellValue(1, 'cost_cd_ftr_rmk', formObj.cost_cd_ftr_rmk.value);


    if (formObj.hld_flg.checked == true) {
        sheetObj.SetCellValue(1, 'hld_flg', 'Y');
    } else {
        sheetObj.SetCellValue(1, 'hld_flg', '');
    }
    if (formObj.rtro_tml_inv_flg.checked == true) {
        sheetObj.SetCellValue(1, 'rtro_tml_inv_flg', 'Y');
    } else {
        sheetObj.SetCellValue(1, 'rtro_tml_inv_flg', '');
    }
}

/*
 * Header Sheet Data Form Copy
 */
function setHdSheet2Form(sheetObj) {
    var formObj = document.form;
    if (sheetObj.RowCount() == 1) {
        formObj.tml_so_ofc_cty_cd.value = sheetObj.GetCellValue(1, 'tml_so_ofc_cty_cd');
        formObj.tml_so_seq.value = sheetObj.GetCellValue(1, 'tml_so_seq');
        formObj.cost_ofc_cd.value = sheetObj.GetCellValue(1, 'cost_ofc_cd');
        formObj.cost_ofc_hidden.value = sheetObj.GetCellValue(1, 'cost_ofc_cd');
        formObj.inv_no.value = sheetObj.GetCellValue(1, 'inv_no');
        formObj.vndr_seq.value = sheetObj.GetCellValue(1, 'vndr_seq');
        formObj.yd_cd.value = sheetObj.GetCellValue(1, 'yd_cd');
        formObj.yd_cd_hidden.value = sheetObj.GetCellValue(1, 'yd_cd');
        formObj.yd_nm.value = sheetObj.GetCellValue(1, 'yd_nm');

        comboObjects[0].SetSelectCode(sheetObj.GetCellValue(1, 'curr_cd'));
        comboObjects[0].SetSelectText(sheetObj.GetCellValue(1, 'curr_cd'));

        formObj.curr_cd_tmp.value = sheetObj.GetCellValue(1, 'curr_cd');

        formObj.ttl_inv_amt.value = tes_chkAmtFmt(sheetObj.GetCellValue(1, 'ttl_inv_amt'), sheetObj.GetCellValue(1, 'curr_cd'));
        formObj.vat_amt.value = tes_chkAmtFmt(sheetObj.GetCellValue(1, 'vat_amt'), sheetObj.GetCellValue(1, 'curr_cd'));
        formObj.hld_rmk.value = sheetObj.GetCellValue(1, 'hld_rmk');
        formObj.iss_dt.value = sheetObj.GetCellValue(1, 'iss_dt');
        formObj.rcv_dt.value = sheetObj.GetCellValue(1, 'rcv_dt');
        formObj.wrk_dt.value = sheetObj.GetCellValue(1, 'wrk_dt');

        formObj.tml_inv_rjct_sts_cd.value = sheetObj.GetCellValue(1, 'tml_inv_rjct_sts_cd');
        if (sheetObj.GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'NL') {
            formObj.tml_inv_rjct_sts_nm.value = 'Normal';
        } else if (sheetObj.GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'RJ') {
            formObj.tml_inv_rjct_sts_nm.value = 'Reject';
        } else if (sheetObj.GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'RL') {
            formObj.tml_inv_rjct_sts_nm.value = 'Reject Lifted';
        }

        formObj.cost_cd_ftr_rmk.value = sheetObj.GetCellValue(1, 'cost_cd_ftr_rmk');

        formObj.tml_inv_sts_cd.value = sheetObj.GetCellValue(1, 'tml_inv_sts_cd');
        formObj.whld_tax_amt.value = tes_chkAmtFmt(sheetObj.GetCellValue(1, 'whld_tax_amt'), sheetObj.GetCellValue(1, 'curr_cd'));
        formObj.tml_inv_sts_nm.value = sheetObj.GetCellValue(1, 'tml_inv_sts_nm');
        formObj.total_amt.value = tes_chkAmtFmt(tes_round((Number(sheetObj.GetCellValue(1, 'ttl_inv_amt')) + Number(sheetObj.GetCellValue(1, 'vat_amt')) - Number(sheetObj.GetCellValue(1, 'whld_tax_amt'))), 2), curr_cd.GetSelectCode());
        if (sheetObj.GetCellValue(1, 'hld_flg') == 'Y') {
            formObj.hld_flg.checked = true;
        } else {
            formObj.hld_flg.checked = false;
        }
        if (sheetObj.GetCellValue(1, 'rtro_tml_inv_flg') == 'Y') {
            formObj.rtro_tml_inv_flg.checked = true;
        } else {
            formObj.rtro_tml_inv_flg.checked = false;
        }
    }
}

// btn_retrieve Event
function retrieveEvent(sheetObj, formObj) { // alert("start retrieveEvent");
    if (!fnChkSearchForm(formObj)) return false;
    sheetObjects[0].RemoveAll();
    sheetObjects[1].RemoveAll();
    sheetObjects[2].RemoveAll();
    sheetObjects[3].RemoveAll();
    sheetObjects[4].RemoveAll();
    // main hidden sheet
    doActionIBSheet_main(sheetObj, formObj, IBSEARCH);
    return true;
}

/**
 * Discrepancy List, Coincidency List
 * 
 */
function toCoincidence(fromSheetObj, toSheetObj) {
    // ComShowMessage("toCoincidence");
    var formObj = document.form;
    var orgStatus = "";
    for (var i = fromSheetObj.HeaderRows(); i < fromSheetObj.HeaderRows() + fromSheetObj.RowCount(); i++) {
        orgStatus = fromSheetObj.GetRowStatus(i);
        if (fromSheetObj.GetCellValue(i, "chk")) {
            var Row = toSheetObj.DataInsert(-1);
            toSheetObj.SetCellEditable(Row, "chk", 1);
            toSheetObj.SetCellValue(Row, "page", fromSheetObj.GetCellValue(i, "page"));
            toSheetObj.SetCellValue(Row, "sts", "I");
            toSheetObj.SetCellValue(Row, "modi_flg", "Y");
            toSheetObj.SetCellValue(Row, "cntr_no", fromSheetObj.GetCellValue(i, "cntr_no"));
            toSheetObj.SetCellValue(Row, "cntr_tpsz_cd", fromSheetObj.GetCellValue(i, "cntr_tpsz_cd"));
            toSheetObj.SetCellValue(Row, "cntr_sty_cd", fromSheetObj.GetCellValue(i, "cntr_sty_cd"));
            // toSheetObj.SetCellValue(Row,"io_bnd_cd" ) = fromSheetObj.GetCellValue(i,
            // "io_bnd_cd" );
            toSheetObj.SetCellValue(Row, "wrk_dt", fromSheetObj.GetCellValue(i, "wrk_dt"));
            toSheetObj.SetCellValue(Row, "bkg_no", fromSheetObj.GetCellValue(i, "bkg_no"));
            toSheetObj.SetCellValue(Row, "bkg_no_split", fromSheetObj.GetCellValue(i, "bkg_no_split"));
            toSheetObj.SetCellValue(Row, "dcgo_clss_cd", fromSheetObj.GetCellValue(i, "dcgo_clss_cd"));
            toSheetObj.SetCellValue(Row, "clm_dt", fromSheetObj.GetCellValue(i, "clm_dt"));
            toSheetObj.SetCellValue(Row, "rail_bil_dt", fromSheetObj.GetCellValue(i, "rail_bil_dt"));
            toSheetObj.SetCellValue(Row, "dscr_rsn", fromSheetObj.GetCellValue(i, "dscr_rsn"));
            toSheetObj.SetCellValue(Row, "cntr_rmk", fromSheetObj.GetCellValue(i, "cntr_rmk"));
            toSheetObj.SetCellValue(Row, "dscr_ind_cd", fromSheetObj.GetCellValue(i, "dscr_ind_cd"));
            toSheetObj.SetCellValue(Row, "dscr_ind_nm", fromSheetObj.GetCellValue(i, "dscr_ind_nm"));
            toSheetObj.SetCellValue(Row, "tml_so_ofc_cty_cd", fromSheetObj.GetCellValue(i, "tml_so_ofc_cty_cd"));
            toSheetObj.SetCellValue(Row, "tml_so_seq", fromSheetObj.GetCellValue(i, "tml_so_seq"));
            toSheetObj.SetCellValue(Row, "vrfy_rslt_ind_cd", "CO");
            toSheetObj.SetCellValue(Row, "vsl_cd", fromSheetObj.GetCellValue(i, "vsl_cd"));
            toSheetObj.SetCellValue(Row, "skd_voy_no", fromSheetObj.GetCellValue(i, "skd_voy_no"));
            toSheetObj.SetCellValue(Row, "skd_dir_cd", fromSheetObj.GetCellValue(i, "skd_dir_cd"));
            toSheetObj.SetCellValue(Row, "atb_dt", fromSheetObj.GetCellValue(i, "atb_dt"));
            toSheetObj.SetCellValue(Row, "vvd_no", fromSheetObj.GetCellValue(i, "vvd_no"));
            toSheetObj.SetCellValue(Row, "vndr_seq", fromSheetObj.GetCellValue(i, "vndr_seq"));
            fromSheetObj.SetRowHidden(i, 1);
            fromSheetObj.SetRowStatus(i, "D");
            if (orgStatus == "I") i--;
        }
    }
    formObj.tab1.selectedIndex = 0;
    sumaryContainerList(toSheetObj);
}

/**
 * Verification List, Discrepancy List
 * 
 */
function toDiscreption(fromSheetObj, toSheetObj) {
    var formObj = document.form;
    var orgStatus = "";
    for (var i = fromSheetObj.HeaderRows(); i < fromSheetObj.HeaderRows() + fromSheetObj.RowCount(); i++) {
        orgStatus = fromSheetObj.GetRowStatus(i);
        if (fromSheetObj.GetCellValue(i, "chk")) {
            var Row = toSheetObj.DataInsert(-1);
            toSheetObj.SetCellEditable(Row, "chk", 1);
            toSheetObj.SetCellValue(Row, "page", fromSheetObj.GetCellValue(i, "page"));
            toSheetObj.SetCellValue(Row, "sts", "I");
            toSheetObj.SetCellValue(Row, "modi_flg", "");
            toSheetObj.SetCellValue(Row, "cntr_no", fromSheetObj.GetCellValue(i, "cntr_no"));
            toSheetObj.SetCellValue(Row, "cntr_tpsz_cd", fromSheetObj.GetCellValue(i, "cntr_tpsz_cd"));
            toSheetObj.SetCellValue(Row, "cntr_sty_cd", fromSheetObj.GetCellValue(i, "cntr_sty_cd"));
            toSheetObj.SetCellValue(Row, "wrk_dt", fromSheetObj.GetCellValue(i, "wrk_dt"));
            toSheetObj.SetCellValue(Row, "bkg_no", fromSheetObj.GetCellValue(i, "bkg_no"));
            toSheetObj.SetCellValue(Row, "bkg_no_split", fromSheetObj.GetCellValue(i, "bkg_no_split"));
            toSheetObj.SetCellValue(Row, "dcgo_clss_cd", fromSheetObj.GetCellValue(i, "dcgo_clss_cd"));
            toSheetObj.SetCellValue(Row, "clm_dt", fromSheetObj.GetCellValue(i, "clm_dt"));
            toSheetObj.SetCellValue(Row, "rail_bil_dt", fromSheetObj.GetCellValue(i, "rail_bil_dt"));
            toSheetObj.SetCellValue(Row, "dscr_rsn", fromSheetObj.GetCellValue(i, "dscr_rsn"));
            toSheetObj.SetCellValue(Row, "cntr_rmk", fromSheetObj.GetCellValue(i, "cntr_rmk"));
            toSheetObj.SetCellValue(Row, "dscr_ind_cd", fromSheetObj.GetCellValue(i, "dscr_ind_cd"));
            toSheetObj.SetCellValue(Row, "dscr_ind_nm", fromSheetObj.GetCellValue(i, "dscr_ind_nm"));
            toSheetObj.SetCellValue(Row, "tml_so_ofc_cty_cd", fromSheetObj.GetCellValue(i, "tml_so_ofc_cty_cd"));
            toSheetObj.SetCellValue(Row, "tml_so_seq", fromSheetObj.GetCellValue(i, "tml_so_seq"));
            toSheetObj.SetCellValue(Row, "vrfy_rslt_ind_cd", "DC");
            toSheetObj.SetCellValue(Row, "vsl_cd", fromSheetObj.GetCellValue(i, "vsl_cd"));
            toSheetObj.SetCellValue(Row, "skd_voy_no", fromSheetObj.GetCellValue(i, "skd_voy_no"));
            toSheetObj.SetCellValue(Row, "skd_dir_cd", fromSheetObj.GetCellValue(i, "skd_dir_cd"));
            toSheetObj.SetCellValue(Row, "atb_dt", fromSheetObj.GetCellValue(i, "atb_dt"));
            toSheetObj.SetCellValue(Row, "vvd_no", fromSheetObj.GetCellValue(i, "vvd_no"));
            toSheetObj.SetCellValue(Row, "vndr_seq", fromSheetObj.GetCellValue(i, "vndr_seq"));
            fromSheetObj.SetRowHidden(i, 1);
            fromSheetObj.SetRowStatus(i, "D");
            if (orgStatus == "I") i--;
        }
    }
    formObj.tab1.selectedIndex = 1;
}

/**
 * Grid Data save
 * 
 */
function gridSave() { // alert("start gridSave");
    var formObj = document.form;
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];
    var sheetObject_main = sheetObjects[3];
    var tab_index = tab1.GetSelectedIndex();
    if (!save_conf_01) {
        ComShowMessage(ComGetMsg('TES21005'));
        return false;
    }
    if (sheetObject.RowCount() > 0 || sheetObject1.RowCount() > 0) {
        doActionIBSheet1(sheetObject, formObj, IBSAVE);
    }
    if (sheetObject2.RowCount() > 0) {
        doActionIBSheet3(sheetObjects[2], formObj, IBSAVE);
    }
    retrieveEvent(sheetObject_main, formObj);
}

/**
 * Verification Container List Summary
 * 
 */
function sumaryContainerList(sheetObject) {
    var formObj = document.form;
    // ComShowMessage("sumaryContainerList : "+sheetObject.RowCount);
    var cntTot = 0;
    var cntSizeD2 = 0;
    var cntSizeO2 = 0;
    var cntSizeD4 = 0;
    var cntSizeO4 = 0;
    var cntSizeD5 = 0;
    var cntSizeS2 = 0;
    var cntSizeD7 = 0;
    var cntSizeS4 = 0;
    var cntSizeD8 = 0;
    var cntSizeT2 = 0;
    var cntSizeD9 = 0;
    var cntSizeT4 = 0;
    var cntSizeDW = 0;
    var cntSizeA2 = 0;
    var cntSizeDX = 0;
    var cntSizeA4 = 0;
    var cntSizeR2 = 0;
    var cntSizeP2 = 0;
    var cntSizeR4 = 0;
    var cntSizeP4 = 0;
    var cntSizeR5 = 0;
    var cntSizeZ2 = 0;
    var cntSizeF2 = 0;
    var cntSizeZ4 = 0;
    var cntSizeF4 = 0;
    var cntSizeF5 = 0;
    var cntFull = 0;
    var cntEmpty = 0;
    var cntTs = 0;
    var cntSameTs = 0;
    for (var i = sheetObject.HeaderRows(); i < sheetObject.HeaderRows() + sheetObject.RowCount(); i++) {
        cntTot++;
        if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "D2") cntSizeD2++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "D4") cntSizeD4++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "D5") cntSizeD5++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "D7") cntSizeD7++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "D8") cntSizeD8++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "D9") cntSizeD9++;
        //			else if(sheetObject.GetCellValue(i, "cntr_tpsz_cd" ) == "DW") cntSizeDW++;
        //			else if(sheetObject.GetCellValue(i, "cntr_tpsz_cd" ) == "DX") cntSizeDX++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "R2") cntSizeR2++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "R4") cntSizeR4++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "R5") cntSizeR5++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "F2") cntSizeF2++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "F4") cntSizeF4++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "F5") cntSizeF5++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "O2") cntSizeO2++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "O4") cntSizeO4++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "S2") cntSizeS2++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "S4") cntSizeS4++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "T2") cntSizeT2++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "T4") cntSizeT4++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "A2") cntSizeA2++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "A4") cntSizeA4++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "P2") cntSizeP2++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "P4") cntSizeP4++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "Z2") cntSizeZ2++;
        else if (sheetObject.GetCellValue(i, "cntr_tpsz_cd") == "Z4") cntSizeZ4++;
        if (sheetObject.GetCellValue(i, "cntr_sty_cd") == "F") cntFull++;
        else if (sheetObject.GetCellValue(i, "cntr_sty_cd") == "M") cntEmpty++;
    }
    formObj.size_d2.value = ComAddComma(cntSizeD2);
    formObj.size_d4.value = ComAddComma(cntSizeD4);
    formObj.size_d5.value = ComAddComma(cntSizeD5);
    formObj.size_d7.value = ComAddComma(cntSizeD7);
    formObj.size_d8.value = ComAddComma(cntSizeD8);
    formObj.size_d9.value = ComAddComma(cntSizeD9);
    //			formObj.size_dw       .value=ComAddComma(cntSizeDW);
    //			formObj.size_dx       .value=ComAddComma(cntSizeDX);
    formObj.size_r2.value = ComAddComma(cntSizeR2);
    formObj.size_r4.value = ComAddComma(cntSizeR4);
    formObj.size_r5.value = ComAddComma(cntSizeR5);
    formObj.size_f2.value = ComAddComma(cntSizeF2);
    formObj.size_f4.value = ComAddComma(cntSizeF4);
    formObj.size_f5.value = ComAddComma(cntSizeF5);
    formObj.size_o2.value = ComAddComma(cntSizeO2);
    formObj.size_o4.value = ComAddComma(cntSizeO4);
    formObj.size_s2.value = ComAddComma(cntSizeS2);
    formObj.size_s4.value = ComAddComma(cntSizeS4);
    formObj.size_t2.value = ComAddComma(cntSizeT2);
    formObj.size_t4.value = ComAddComma(cntSizeT4);
    formObj.size_a2.value = ComAddComma(cntSizeA2);
    formObj.size_a4.value = ComAddComma(cntSizeA4);
    formObj.size_p2.value = ComAddComma(cntSizeP2);
    formObj.size_p4.value = ComAddComma(cntSizeP4);
    formObj.size_z2.value = ComAddComma(cntSizeZ2);
    formObj.size_z4.value = ComAddComma(cntSizeZ4);
    formObj.container_tot.value = ComAddComma(cntTot);
    formObj.full.value = ComAddComma(cntFull);
    formObj.empty.value = ComAddComma(cntEmpty);
}

/**
 * VVD NO ContainerList delete
 * 
 */
function deleteContanerList() { // alert("start deleteContanerList");
    var formObj = document.form;
    var orgStatus = "";
    var deleteRows_value = false;
    for (var i = sheetObjects[0].HeaderRows(); i < sheetObjects[0].HeaderRows() + sheetObjects[0].RowCount(); i++) {
        orgStatus = sheetObjects[0].GetRowStatus(i);
        sheetObjects[0].SetRowStatus(i, "D");
        if (orgStatus == "I") i--;
        deleteRows_value = true;
    }
    orgStatus = "";
    for (var i = sheetObjects[1].HeaderRows(); i < sheetObjects[1].HeaderRows() + sheetObjects[1].RowCount(); i++) {
        orgStatus = sheetObjects[1].GetRowStatus(i);
        sheetObjects[1].SetRowStatus(i, "D");
        if (orgStatus == "I") i--;
        deleteRows_value = true;
    }
    orgStatus = "";
    for (var i = sheetObjects[2].HeaderRows(); i < sheetObjects[2].HeaderRows() + sheetObjects[2].RowCount(); i++) {
        orgStatus = sheetObjects[2].GetRowStatus(i);
        if (sheetObjects[2].GetCellValue(i, "calc_tp_cd") != "M" && sheetObjects[2].GetCellValue(i, "calc_tp_cd") != "S") {
            sheetObjects[2].SetRowStatus(i, "D");
            if (orgStatus == "I") i--;
            deleteRows_value = true;
        }
    }
    return deleteRows_value;
}

/**
 * Sheet change Event
 * 
 */
function t3sheet1_OnChange(sheetObj, row, col) {
    var formObj = document.form;
    var sCurrCd = formObj.curr_cd.value;
    
    if (sheetObj.ColSaveName(col) == "rvis_vol_qty") {
        var nInvAmt = sheetObj.GetCellValue(row, "rvis_vol_qty") * sheetObj.GetCellValue(row, "ctrt_rt") * sheetObj.GetCellValue(row, "inv_xch_rt");
        
        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
        }
        
        sheetObj.SetCellValue(row, "inv_amt", nInvAmt);
        
    } else if (sheetObj.ColSaveName(col) == "ctrt_rt") {
    	var nInvAmt = sheetObj.GetCellValue(row, "rvis_vol_qty") * sheetObj.GetCellValue(row, "ctrt_rt") * sheetObj.GetCellValue(row, "inv_xch_rt");
        
        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
        }
        
        sheetObj.SetCellValue(row, "inv_amt", nInvAmt);
        
    } else if (sheetObj.ColSaveName(col) == "inv_amt") {
        calcurationTotalAmt(sheetObj, formObj);
        
    } else if (sheetObj.ColSaveName(col) == 'inv_xch_rt') {
        if (sheetObj.GetCellValue(row, 'inv_xch_rt') == 0) {
            if (sheetObj.GetCellValue(row, 'calc_tp_cd') == 'A') {
           		var nInvAmt = sheetObj.GetCellValue(row, 'calc_amt');
        
		        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
		        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
		        }
        
                sheetObj.SetCellValue(row, 'inv_amt', nInvAmt);
                
            } else if (sheetObj.GetCellValue(row, 'calc_tp_cd') == 'M' || sheetObj.GetCellValue(row, 'calc_tp_cd') == 'S') {
                var nInvAmt = sheetObj.GetCellValue(row, 'rvis_vol_qty') * sheetObj.GetCellValue(row, 'ctrt_rt');
        
		        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
		        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
		        }
		        
                sheetObj.SetCellValue(row, 'inv_amt', nInvAmt);
            }
        } else {
            sheetObj.SetCellValue(row, 'inv_xch_rt', Math.abs(sheetObj.GetCellValue(row, 'inv_xch_rt')));
            if (sheetObj.GetCellValue(row, 'calc_tp_cd') == 'A') {
            	var nInvAmt = sheetObj.GetCellValue(row, 'inv_xch_rt') * sheetObj.GetCellValue(row, 'calc_amt');
        
		        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
		        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
		        }
		        
                sheetObj.SetCellValue(row, 'inv_amt', nInvAmt);
                
            } else if (sheetObj.GetCellValue(row, 'calc_tp_cd') == 'M' || sheetObj.GetCellValue(row, 'calc_tp_cd') == 'S') {
                var nInvAmt = sheetObj.GetCellValue(row, 'rvis_vol_qty') * sheetObj.GetCellValue(row, 'ctrt_rt') * sheetObj.GetCellValue(row, 'inv_xch_rt');
        
		        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
		        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
		        }
                
                sheetObj.SetCellValue(row, 'inv_amt', nInvAmt);
            }
        }
    } else if (sheetObj.ColSaveName(col) == 'calc_vol_qty') {
        if (sheetObj.GetCellValue(row, 'calc_tp_cd') == 'M' || sheetObj.GetCellValue(row, 'calc_tp_cd') == 'S') {
            sheetObj.SetCellValue(row, 'rvis_vol_qty', sheetObj.GetCellValue(row, 'calc_vol_qty'));
        }
    }
}

/**
 * Cost Calc List TotalAmount Sum
 * 
 */
function calcurationTotalAmt(sheetObj, formObj) {
    var tot_amt = 0;
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        if (sheetObj.GetRowStatus(i) != "D")
            tot_amt = Math.round(tot_amt * 100) / 100 + Math.round(sheetObj.GetCellValue(i, "inv_amt") * 100) / 100;
    }
    formObj.tot_inv_amt.value = tes_chkAmtFmt(Math.round(tot_amt * 100) / 100, curr_cd.GetSelectCode());
}

var popupCnt = 0;
var popupCnt2 = 0;
var popupCnt3 = 0;

/**
 * Sheet popup Event
 * 
 */
function t3sheet1_OnPopupClick(sheetObj, row, col) {
    var formObj = document.form;
    var rvis_vol_qty = 0;
    if (sheetObj.ColSaveName(col) == "rvis_vol_qty") {
        if (sheetObj.GetCellValue(row, "lgs_cost_cd") != "TMXXDC" && sheetObj.GetCellValue(row, "calc_tp_cd") == "A") {
            var url_str = "ESD_TES_9031Pop.screen";
            url_str += "?tml_inv_tp_cd=" + formObj.tml_inv_tp_cd.value;
            url_str += "&tml_so_ofc_cty_cd=" + formObj.tml_so_ofc_cty_cd.value;
            url_str += "&tml_so_seq=" + formObj.tml_so_seq.value;
            url_str += "&vndr_seq=" + formObj.vndr_seq.value;
            url_str += "&yd_cd=" + formObj.yd_cd.value;
            url_str += "&lgs_cost_cd=" + sheetObj.GetCellValue(row, "lgs_cost_cd");
            url_str += "&cntr_tpsz_cd=" + sheetObj.GetCellValue(row, "cntr_tpsz_cd");
            url_str += "&dcgo_clss_cd=" + sheetObj.GetCellValue(row, "dcgo_ind_cd");
            url_str += "&cal_vol=" + sheetObj.GetCellValue(row, "calc_vol_qty");
            url_str += "&tml_wrk_dy_cd=" + sheetObj.GetCellValue(row, "tml_wrk_dy_cd");
            url_str += "&rvis_vol_qty=" + rvis_vol_qty;
            url_str += "&vol_tr_ut_cd=" + sheetObj.GetCellValue(row, "vol_tr_ut_cd");
            url_str += "&tml_so_dtl_seq=" + sheetObj.GetCellValue(row, "tml_so_dtl_seq");
            url_str += "&ctrt_rt=" + sheetObj.GetCellValue(row, "ctrt_rt");
            url_str += "&opener_row=" + row;
            popupCnt++;
            ComOpenWindow(url_str, window, "dialogWidth:600px;dialogHeight:400px;help:no;status:no;resizable:yes;", true);
        }
    } else if (sheetObj.ColSaveName(col) == "n3pty_flg") { //20150529 manual입력 가능
        //			if (sheetObj.GetCellValue(row,"lgs_cost_cd")!="TMXXDC" && sheetObj.GetCellValue(row,"calc_tp_cd")=="A")
        if (sheetObj.GetCellValue(row, "lgs_cost_cd") != "TMXXDC") {
            if (sheetObj.GetCellValue(row, 'tml_so_dtl_seq') == '' || sheetObj.GetCellValue(row, 'tml_so_dtl_seq') == null || sheetObj.GetCellValue(row, 'tml_so_dtl_seq') == 0) {
                ComShowMessage('You have to 3rd party Input after save calculated result.');
                return false;
            }
            if (sheetObj.GetCellValue(row, 'inv_amt') < 0) {
                ComShowMessage('Invoice amount should be bigger than 0 to insert 3rd Party.');
                return false;
            }
            if (sheetObj.GetCellValue(row, "lgs_cost_cd") == "") {
                ComShowMessage(ComGetMsg('TES22031'));
                return false;
            }
            if (sheetObj.GetCellValue(row, "cntr_tpsz_cd") == "") {
                ComShowMessage(ComGetMsg('TES22032'));
                return false;
            }
            if (sheetObj.GetCellValue(row, "dcgo_ind_cd") == "") {
                ComShowMessage(ComGetMsg('TES22033'));
                return false;
            }
            if (sheetObj.GetCellValue(row, "rvis_vol_qty") == "") {
                ComShowMessage(ComGetMsg('TES22034'));
                return false;
            }
            var url_str = "ESD_TES_9231Pop.screen";
            url_str += "?tml_inv_tp_cd=" + formObj.tml_inv_tp_cd.value;
            url_str += "&tml_so_ofc_cty_cd=" + formObj.tml_so_ofc_cty_cd.value;
            url_str += "&tml_so_seq=" + formObj.tml_so_seq.value;
            url_str += "&inv_ofc_cd=" + formObj.inv_ofc_cd.value;
            url_str += "&vndr_seq=" + formObj.vndr_seq.value;
            url_str += "&yd_cd=" + formObj.yd_cd.value;
            url_str += "&inv_no=" + formObj.inv_no.value;
            url_str += "&curr_cd=" + curr_cd.GetSelectCode();
            url_str += "&vvd_no=" + sheetObj.GetCellValue(row, "vvd_no");
            url_str += "&calc_tp_cd=" + sheetObj.GetCellValue(row, "calc_tp_cd");
            url_str += "&lgs_cost_cd=" + sheetObj.GetCellValue(row, "lgs_cost_cd");
            url_str += "&cntr_tpsz_cd=" + sheetObj.GetCellValue(row, "cntr_tpsz_cd");
            url_str += "&tml_wrk_dy_cd=" + sheetObj.GetCellValue(row, "tml_wrk_dy_cd");
            url_str += "&dcgo_clss_cd=" + sheetObj.GetCellValue(row, "dcgo_ind_cd");
            url_str += "&cal_vol=" + sheetObj.GetCellValue(row, "calc_vol_qty");
            url_str += "&fm_tr_vol_val=" + sheetObj.GetCellValue(row, "fm_tr_vol_val");
            url_str += "&to_tr_vol_val=" + sheetObj.GetCellValue(row, "to_tr_vol_val");
            url_str += "&tml_so_dtl_seq=" + sheetObj.GetCellValue(row, "tml_so_dtl_seq");
            url_str += "&rvis_vol_qty=" + sheetObj.GetCellValue(row, "rvis_vol_qty");
            url_str += "&inv_amt=" + sheetObj.GetCellValue(row, "inv_amt");
            url_str += "&ctrt_rt=" + sheetObj.GetCellValue(row, "ctrt_rt");
            url_str += "&inv_xch_rt=" + sheetObj.GetCellValue(row, "inv_xch_rt");
            url_str += "&opener_row=" + row;
            url_str += '&sheet_idx=3';
            popupCnt3++;
            ComOpenWindow(url_str, window, "dialogWidth:820px;dialogHeight:700px;help:no;status:no;resizable:yes;", true);
        }
    }
}

/**
 * Menual Cost Code
 * 
 */
function costCalcRowAdd(sheetObj) {
    var formObj = document.form;
    // ComShowMessage("costCalcRowAdd");
    var Row = sheetObj.DataInsert(-1);
    sheetObj.SetCellValue(Row, "tml_so_ofc_cty_cd", formObj.tml_so_ofc_cty_cd.value);
    sheetObj.SetCellValue(Row, "tml_so_seq", formObj.tml_so_seq.value);
    sheetObj.SetCellValue(Row, "calc_cost_grp_cd", 'ON');
    sheetObj.CellComboItem(Row, 'lgs_cost_cd', {
        ComboText: document.form.calcOnDockComboItems.value,
        ComboCode: document.form.calcOnDockComboItems.value
    });
    sheetObj.CellComboItem(Row, 'cntr_tpsz_cd', {
        ComboText: document.form.cntrTpszComboItems.value,
        ComboCode: document.form.cntrTpszComboItems.value
    });
    sheetObj.SetCellValue(Row, "calc_tp_cd", "M");
    sheetObj.SetCellValue(Row, "lgs_cost_cd", "");
    sheetObj.SetCellValue(Row, "cntr_tpsz_cd", "");
    sheetObj.SetCellValue(Row, "tml_wrk_dy_cd", "");
    sheetObj.SetCellValue(Row, "dcgo_ind_cd", "");
    sheetObj.SetCellValue(Row, "vol_tr_ut_cd", "");
    sheetObj.SetCellValue(Row, "inv_xch_rt", "1");
    sheetObj.InitCellProperty(Row, "rvis_vol_qty", {
        Type: "Data"
    });
    
    //2016.10.11 Currency FormToSheet Add
    setDefaultCurrencyFormToSheet(sheetObj, Row, "curr_cd");
    
    var cells = "lgs_cost_cd|cntr_tpsz_cd|wrk_dt||tml_wrk_dy_cd|dcgo_ind_cd|rvis_vol_qty|vol_tr_ut_cd|ctrt_rt|inv_amt|calc_vol_qty|calc_rmk|n3pty_flg|inv_xch_rt";
    setShtCellsEditable(sheetObj, Row, cells, 'Y');
}

/**
 * Menual Cost Code delete
 * 
 */
function costCalcRowDel(sheetObj) {
    var Row = sheetObj.GetSelectRow();
    var orgStatus = "";
    if (sheetObj.GetCellValue(Row, "calc_tp_cd") == "A") {
        ComShowMessage(ComGetMsg('TES21046'));
        return false;
    }
    sheetObj.SetRowHidden(Row, 1);
    sheetObj.SetRowStatus(Row, "D");
    calcurationTotalAmt(sheetObj, document.form);
}

/**
 * Menual CostCode set Editable Cell
 * 
 */
function setShtCellsEditable(sheetObj, rownum, colnms, to_sts, EXCEPTION) {
    // setShtCellsEditable(sheetObj, 1, 'COL_NM|COL_NM2|COL_NM3', 'N')
    // ComShowMessage('setShtCellsEditable!!');
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
 * Validation date format
 * 
 */
function validDate(obj) {
    var formObj = document.form;
    if (obj.value != "" && !ComIsDate(obj)) {
        ComShowMessage(ComGetMsg('TES21048'));
        obj.value = "";
        return false;
    }
    if (formObj.iss_dt != null && formObj.rcv_dt != null && formObj.iss_dt.value != '' && formObj.rcv_dt.value != '') {
        if (ComGetDaysBetween(formObj.iss_dt, formObj.rcv_dt) < 0) {
            ComShowMessage('Issue date must be earlier than RCV date.');
            return false;
        }
    }
}

/**
 * Container List Validation Cost Calculation Mandatory List
 * 
 */
function validMandatoryItemContainerList(sheetObj) {
    var validValue = true;
    var mandatoryItem = "Cntr No ";
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        if (sheetObj.GetCellValue(i, "cntr_no") == "" || sheetObj.GetCellValue(i, "cntr_no") == null) {
            mandatoryItem = "Cntr No ";
            validValue = false;
        }
        if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "" || sheetObj.GetCellValue(i, "cntr_tpsz_cd") == null) {
            mandatoryItem = "Type/Size ";
            validValue = false;
        }
        if (sheetObj.GetCellValue(i, "cntr_sty_cd") == "" || sheetObj.GetCellValue(i, "cntr_sty_cd") == null) {
            mandatoryItem = "F/M ";
            validValue = false;
        }
        if (sheetObj.GetCellValue(i, "dcgo_clss_cd") == "" || sheetObj.GetCellValue(i, "dcgo_clss_cd") == null) {
            mandatoryItem = "DG ";
            validValue = false;
        }
        if (sheetObj.GetCellValue(i, "wrk_dt") == "" || sheetObj.GetCellValue(i, "wrk_dt") == null) {
            mandatoryItem = "Working Date ";
            validValue = false;
        }
    }
    if (!validValue) ComShowMessage(mandatoryItem + ComGetMsg('TES22037'));
    return validValue;
}

function validateAgmtCurrCD() {
    document.form.agmtCurrCd.value =  getAgmtCurrCd();      // tes_getInputValueInvoice('agmtCurrCd', SEARCH01, 'tml_inv_tp_cd|yd_cd|vndr_seq|to_prd_dt', '');
}

function isValidAgmtCurrCD() {
    // calc tab 계산전에 so hdr의 currency와 agreement의 currency code가 일치하는지 여부를
    // 파악...
    var formObj = document.form;
    if (curr_cd.GetSelectCode() == null || curr_cd.GetSelectCode().trim() == '') {
        ComShowMessage(ComGetMsg('TES40039'));
        return false;
    }
    if (curr_cd.GetSelectCode() != main_hidden.GetCellValue(1, 'curr_cd')) {
        ComShowMessage(ComGetMsg('TES40040'));
        return false;
    }
    if (formObj.agmtCurrCd.value == null || formObj.agmtCurrCd.value.trim() == '') {
        ComShowMessage(ComGetMsg('TES40030'));
        document.form.agmtCurrCd.value =  getAgmtCurrCd();      // tes_getInputValueInvoice('agmtCurrCd', SEARCH01, 'tml_inv_tp_cd|yd_cd|vndr_seq|to_prd_dt', '');
        return false;
    }
    if (formObj.agmtCurrCd.value.trim() == curr_cd.GetSelectCode().trim()) {
        // ComShowMessage(1);
        return true;
    } else {
        ComShowMessage(ComGetMsg('TES40028', formObj.agmtCurrCd.value, curr_cd.GetSelectCode()));
        return false;
    }
    return false;
}

function validateAgmtSts() {
	document.form.agmtSts.value = getAgmtStatusCd(); // tes_getInputValueInvoice('agmtSts', SEARCH04, 'tml_inv_tp_cd|yd_cd|vndr_seq|to_prd_dt', '');
}

function isValidAgmtSts() {
    var formObj = document.form;
    var tmp = '';
    tmp = formObj.agmtSts.value;
    if (tmp != undefined && tmp != null && tmp.trim() != '') {
        tmp = tmp.split('|');
        if (tmp.length > 0) {
            if (tmp[0] != null && !isNaN(tmp[0])) {
                if (parseInt(tmp[0]) > 0) {
                    if (tmp[1] != undefined && tmp[1] != null) {
                        if (tmp[1].trim() == 'C') {
                            return true;
                        } else if (tmp[1].trim() == 'P') {
                            ComShowMessage(ComGetMsg('TES40005'));
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
                    ComShowMessage('[ERR-Agreement_01]');
                    return false;
                }
            } else {
                ComShowMessage('[ERR-Agreement_02]');
                return false;
            }
        } else {
            ComShowMessage('[ERR-Agreement_03]');
            return false;
        }
    } else {
        ComShowMessage('[ERR-Agreement_04]');
        return false;
    }
    return true;
}

/**
 * check Container Mandatory
 */
function CheckCNTRListMandatoryCol() {
    var flag = true;
    // Verification, Discrepancy
    for (j = 0; j < 1; j++) {
        for (i = sheetObjects[j].HeaderRows(); i < sheetObjects[j].HeaderRows() + sheetObjects[j].RowCount(); i++) {
            if (sheetObjects[j].GetCellValue(i, 'cntr_sty_cd') == '') {
                flag = false;
            }
            if (sheetObjects[j].GetCellValue(i, 'cntr_tpsz_cd') == '') {
                flag = false;
            }
            if (sheetObjects[j].GetCellValue(i, 'dcgo_clss_cd') == '') {
                flag = false;
            }
            if (sheetObjects[j].GetCellValue(i, 'wrk_dt') == '') {
                //                flag=false;
                sheetObjects[j].SetCellValue(i, 'wrk_dt', document.form.wrk_dt.value);
            }
        }
    }
    if (flag == false) {
        ComShowMessage(ComGetMsg('TES40008')); // ComShowMessage('CNTR Type
        // Size, F/M, DG,
        // WorkingDate 는 필수 입력항목입니다.
        // 확인하십시오.');
        return false;
    }
    return true;
}

/**
 * Currency Code change event
 */
function curr_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode) { // alert("start curr_cd_OnChange");
    var main_hidden = sheetObjects[3];
    var sheetObj2 = sheetObjects[2];
    var formObj = document.form;
    // alert("main_hidden.RowCount==>"+main_hidden.RowCount);
    if (main_hidden.RowCount() == 1) {
        if ((main_hidden.GetCellValue(1, 'curr_cd') != comboObjects[0].GetSelectCode()) ||
            (formObj.curr_cd_tmp.value != undefined && formObj.curr_cd_tmp.value != null && formObj.curr_cd_tmp.value != '' && formObj.curr_cd_tmp.value != comboObjects[0].GetSelectCode())) {
            resetInputValue();
        }
        if (sheetObj2.RowCount() > 0) {
            if (formObj.curr_cd_tmp.value != comboObjects[0].GetSelectCode()) {
                if (ComShowConfirm(ComGetMsg('TES40033'))) {
                    sheetObj2.RemoveAll();
                    doActionIBSheet3(sheetObj2, formObj, IBDELETE);
                    resetSheetDataProperty(comboObjects[0].GetSelectCode());
                } else {
                    comboObjects[0].SetSelectCode(formObj.curr_cd_tmp.value);
                }
            }
        }
        formObj.curr_cd_tmp.value = comboObjects[0].GetSelectCode();
    }
}

function resetInputValue() {
    var formObj = document.form;
    formObj.ttl_inv_amt.value = '';
    formObj.vat_amt.value = '';
}

function resetSheetDataProperty(CURR_CD) {
    if (CURR_CD != undefined && tes_isNoDecimalPointCurrCD(CURR_CD)) {
        var cols = [{ Type: "Int",      Hidden: 0,       Width: 70,       Align: "Right",     ColMerge: 0,         SaveName: "ctrt_rt",        KeyField: 0,        CalcLogic: "",     Format: "Integer",    PointCount: 0,    UpdateEdit: 0,    InsertEdit: 0 }, 
        				{ Type: "Int",       Hidden: 0,        Width: 70,      Align: "Right",      ColMerge: 0,      SaveName: "inv_amt",       KeyField: 0,        CalcLogic: "",      Format: "Integer",      PointCount: 0,     UpdateEdit: 0,      InsertEdit: 0   }];
        
        sheetObjects[2].InitColumns(cols);

    } else {
        var cols = [{ Type: "Float",     Hidden: 0,     Width: 70,     Align: "Right",    ColMerge: 0,     SaveName: "ctrt_rt",    KeyField: 0,      CalcLogic: "",   Format: "Float",     PointCount: 2,    UpdateEdit: 0,    InsertEdit: 0 }, 
        				{ Type: "Float",    Hidden: 0,     Width: 70,     Align: "Right",    ColMerge: 0,     SaveName: "inv_amt",     KeyField: 0,      CalcLogic: "",      Format: "Float",     PointCount: 2,     UpdateEdit: 0,      InsertEdit: 0  }];
        
        sheetObjects[2].InitColumns(cols);
    }
}

function validateErrInvNo() {
    var formObj = document.form;
    formObj.err_inv_no.value = formObj.err_inv_no.value.trim();
    if (formObj.err_inv_no.value != null && formObj.err_inv_no.value.trim() != '') {
    	
    	if(getErrInvValidYN()){      //tes_getInputValueInvoice('is_valid_err_inv_no', SEARCH03, 'tml_inv_tp_cd|yd_cd|vndr_seq|err_inv_no', 'checkValidErrInvNo');
        	sheetObjects[3].SetCellValue(1, 'err_inv_no', formObj.err_inv_no.value);
        } else {
        	formObj.is_valid_err_inv_no.value = '';
        }
    }
}

function checkValidErrInvNo() {
    var formObj = document.form;
    // ComShowMessage('checkValidErrInvNo -
    // is_valid_err_inv_no:'+formObj.is_valid_err_inv_no.value);
    if (formObj.is_valid_err_inv_no.value != undefined && formObj.is_valid_err_inv_no.value != null && formObj.is_valid_err_inv_no.value.trim() == 'Y') {
        sheetObjects[3].SetCellValue(1, 'err_inv_no', formObj.err_inv_no.value);
    } else {
        formObj.is_valid_err_inv_no.value = '';
        ComShowMessage(ComGetMsg('TES40058', 'ERR INV.NO'));
    }
}

function reSize() {
    var div01 = document.all.SearchLayer01.style.display;
    var div02 = document.all.SearchLayer02.style.display;
    var obj = ComGetEvent();
    if (div01 == "inline") {
        // obj.src="/opuscntr/img/opus/bu_prev01.gif";
        $('#up_down').removeClass('btn_up').addClass('btn_down');
        document.all.SearchLayer01.style.display = "none";
        document.all.SearchLayer02.style.display = "none";
    } else {
        // obj.src="/opuscntr/img/opus/bu_next01.gif";
        $('#up_down').removeClass('btn_down').addClass('btn_up');
        document.all.SearchLayer01.style.display = "inline";
        document.all.SearchLayer02.style.display = "inline";
    }
}

function fileImp() {
    doActionIBSheet1(sheetObjects[0], document.form, IBSEARCH);
    t1sheet1_OnLoadFinish(sheetObjects[0]);
    doActionIBSheet2(sheetObjects[1], document.form, IBSEARCH);
    t2sheet1_OnLoadFinish(sheetObjects[1]);
}

/**
 * total_amt : ttl_inv_amt + vat_amt - whld_tax_amt
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
        if (whld_tax_amt == "") whld_tax_amt = 0;
    }
    formObj.total_amt.value = tes_chkAmtFmt(tes_round((Number(ttl_inv_amt) + Number(vat_amt) - Number(whld_tax_amt)), 2), curr_cd.GetSelectCode());
}


function setCostCode2(sheetObj) {

    var formObj = document.form;

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

        targetSheetObj.CellComboItem(idx, 'lgs_cost_cd', {
            ComboText: document.form.calcOnDockComboItems.value,
            ComboCode: document.form.calcOnDockComboItems.value
        });

        targetSheetObj.SetCellValue(idx, "calc_tp_cd", sheetObj.GetCellValue(i, "calc_tp_cd"));
        targetSheetObj.SetCellValue(idx, "lgs_cost_cd", sheetObj.GetCellValue(i, "lgs_cost_cd"));
        targetSheetObj.SetCellValue(idx, "cntr_tpsz_cd", sheetObj.GetCellValue(i, "cntr_tpsz_cd"));
        //		    targetSheetObj.SetCellValue(idx,"io_bnd_cd")       =  io_hidden;      

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
        targetSheetObj.SetCellValue(idx, "stay_days", sheetObj.GetCellValue(i, "stay_days"));
        targetSheetObj.SetCellValue(idx, "vol_tr_ut_cd", sheetObj.GetCellValue(i, "vol_tr_ut_cd"));
        targetSheetObj.SetCellValue(idx, "ctrt_rt", sheetObj.GetCellValue(i, "ctrt_rt"));
        targetSheetObj.SetCellValue(idx, "inv_amt", sheetObj.GetCellValue(i, "inv_amt"));
        targetSheetObj.SetCellValue(idx, "curr_cd", sheetObj.GetCellValue(i, "curr_cd"));
        targetSheetObj.SetCellValue(idx, "tml_crr_cd", '');
        targetSheetObj.SetCellValue(idx, 'calc_cost_grp_cd', 'ON');
        targetSheetObj.SetCellValue(idx, 'inv_xch_rt', sheetObj.GetCellValue(i, "inv_xch_rt"));
        targetSheetObj.SetCellValue(idx, 'semi_auto_calc_flg', 'Y');

        targetSheetObj.SetCellValue(idx, "calc_rmk", sheetObj.GetCellValue(i, "agmt_dtl_rmk"));
        //	        targetSheetObj.SetCellValue(idx,'vsl_cd')           = vvd_hidden.GetCellValue(vvd_row, 'vvd_vsl_cd');
        //	        targetSheetObj.SetCellValue(idx,'skd_voy_no')       = vvd_hidden.GetCellValue(vvd_row, 'vvd_skd_voy_no');
        //	        targetSheetObj.SetCellValue(idx,'skd_dir_cd')       = vvd_hidden.GetCellValue(vvd_row, 'vvd_skd_dir_cd');
        //	        targetSheetObj.SetCellValue(idx,'atb_dt')           = vvd_hidden.GetCellValue(vvd_row, 'vvd_atb_dt');

        setShtCellsEditable(targetSheetObj, idx, 'lgs_cost_cd|cntr_tpsz_cd|wrk_dt|dcgo_ind_cd|tml_wrk_dy_cd|ioc_cd|tml_trns_mod_cd|lane_cd|vol_tr_ut_cd|ctrt_rt|calc_vol_qty|inv_xch_rt|inv_amt|rc_flg', 'Y', "EXCEPTION");
    }

    calcurationTotalAmt(targetSheetObj, formObj);
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
    obj.value = obj.value.toUpperCase();
}

//2016.10.11 Currency FormToSheet Add
function setDefaultCurrencyFormToSheet(sheetObj, row, colName){
    var formObj = document.form;
    
    var formCurrCd = ComGetObjValue(formObj.curr_cd);
    
    sheetObj.SetCellValue(row, colName, formCurrCd, 0);
}