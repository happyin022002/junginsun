/*********************************************************************
 * * 1.0 Creation
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TES_0001.js
 *@FileTitle  :  Marine Terminal Invoice
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/23
 *********************************************************************/
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
var io_hidden = '';
var tmp_seq = 0;
var costCalculated = "N";
var parmObj = new Array();
var checkFIO = 0;
var rtnValue = "";
var gAtbDtComboItems = "";//2016.07.13 Add

document.onclick = processButtonClick;

/***
 *  Event handler processing by button name 
 */
function processButtonClick() {
    var formObj = document.form;
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];
    var main_hidden = sheetObjects[3];
    var vvd_hidden = sheetObjects[4];
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
                retrieveAll();
                break;

            case "btn_new":
//                try {
//                    tes_removeTESCommonALLIframes();
//                    tes_removeTESInvoiceCommonALLIframes();
//                } catch (e) {}
                resetSheets();
                formObj.reset();
                formObj.yd_cd_hidden.value = "";
                
                getCurrencyList(0, 70, 100);  //tes_getComboItem('curr_cd', 1, SEARCH03, '', 'inv_ofc_cd'); 		
                agmt_lgs_cost_cd.RemoveAll();
                //                    tes_getComboItem('agmt_lgs_cost_cd', 2, SEARCHLIST10, '', 'vndr_seq|yd_cd|agmt_ftr_inv_tp_cd|atb_dt', 'setAgmtCostCd');
                setInitComponent("N");
                tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
                formObj.agmt_ftr_inv_tp_cd.value = "MT";
                break;

            case "btn_new2":
                var tmp_vndr_seq = formObj.vndr_seq.value;
                var tmp_vndr_seq_hidden = formObj.vndr_seq_hidden.value;
                var tmp_is_valid_vndr_seq = formObj.is_valid_vndr_seq.value;
                var tmp_vndr_seq_nm = formObj.vndr_seq_nm.value;

                var tmp_yd_cd = formObj.yd_cd.value;
                var tmp_yd_nm = formObj.yd_nm.value;
                var tmp_yd_cd_hidden = formObj.yd_cd_hidden.value;
                var tmp_is_valid_yd_cd = formObj.is_valid_yd_cd.value;
                var tmp_yd_chr_cd = formObj.yd_chr_cd.value;
                var tmp_yd_fcty_tp_mrn_tml_flg = formObj.yd_fcty_tp_mrn_tml_flg.value;
                var tmp_yd_fcty_tp_cy_flg = formObj.yd_fcty_tp_cy_flg.value;
                var tmp_yd_fcty_tp_cfs_flg = formObj.yd_fcty_tp_cfs_flg.value;
                var tmp_yd_fcty_tp_rail_rmp_flg = formObj.yd_fcty_tp_rail_rmp_flg.value;
                var tmp_yd_oshp_cd = formObj.yd_oshp_cd.value;

                var tmp_cost_ofc_cd = formObj.cost_ofc_cd.value;
                var tmp_cost_ofc_hidden = formObj.cost_ofc_hidden.value;
                var tmp_is_valid_cost_ofc = formObj.is_valid_cost_ofc.value;
                var tmp_inv_ofc_cd = formObj.inv_ofc_cd.value;

                var tmp_iss_dt = formObj.iss_dt.value;
                var tmp_rcv_dt = formObj.rcv_dt.value;				
				
                resetSheets();
                formObj.reset();      

                formObj.vndr_seq.value = tmp_vndr_seq;
                formObj.vndr_seq_hidden.value = tmp_vndr_seq_hidden;
                formObj.is_valid_vndr_seq.value = tmp_is_valid_vndr_seq;
                formObj.vndr_seq_nm.value = tmp_vndr_seq_nm;

                formObj.yd_cd.value = tmp_yd_cd;
                formObj.yd_nm.value = tmp_yd_nm;

                formObj.yd_cd_hidden.value = tmp_yd_cd_hidden;
                formObj.is_valid_yd_cd.value = tmp_is_valid_yd_cd;
                formObj.yd_chr_cd.value = tmp_yd_chr_cd;
                formObj.yd_fcty_tp_mrn_tml_flg.value = tmp_yd_fcty_tp_mrn_tml_flg;
                formObj.yd_fcty_tp_cy_flg.value = tmp_yd_fcty_tp_cy_flg;
                formObj.yd_fcty_tp_cfs_flg.value = tmp_yd_fcty_tp_cfs_flg;
                formObj.yd_fcty_tp_rail_rmp_flg.value = tmp_yd_fcty_tp_rail_rmp_flg;
                formObj.yd_oshp_cd.value = tmp_yd_oshp_cd;

                formObj.cost_ofc_cd.value = tmp_cost_ofc_cd;
                formObj.cost_ofc_hidden.value = tmp_cost_ofc_hidden;
                formObj.is_valid_cost_ofc.value = tmp_is_valid_cost_ofc;                
                getCurrencyList(0, 70, 100); 		//tes_getComboItem('curr_cd', 1, SEARCH03, '', 'inv_ofc_cd');
                formObj.inv_ofc_cd.value = tmp_inv_ofc_cd;

                formObj.iss_dt.value = tmp_iss_dt;
                formObj.rcv_dt.value = tmp_rcv_dt;

                formObj.agmt_ftr_inv_tp_cd.value = "MT";

                agmt_lgs_cost_cd.RemoveAll();
                
                // tes_getComboItem('agmt_lgs_cost_cd', 2, SEARCHLIST10, '', 'vndr_seq|yd_cd|agmt_ftr_inv_tp_cd|atb_dt', 'setAgmtCostCd');

                validateVndrSeq();
                validateYardCode();
                setInitComponent("N");
                tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
                break;

            case "btn_vndr":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == "C") {
                    ComShowMessage("Confirmed Invoice !!");
                    return false;
                }
                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                var classId = "COM_ENS_0C1";
                var param = '?classId=' + classId;
                var chkStr = dispaly.substring(0, 3);
                // radio PopUp
                if (chkStr == "1,0") {
                    ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 770, 520, 'getVender', dispaly);
                } else {
                    ComShowMessage(ComGetMsg('TES10004'));
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
                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                var classId = "COM_ENS_061";
                var param = '?classId=' + classId;
                var chkStr = dispaly.substring(0, 3)
                    // radio PopUp
                if (chkStr == "1,0") {
                    ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 770, 500, 'getYard', dispaly, true);
                } else {
                    ComShowMessage(ComGetMsg('TES10004'));
                    return;
                }
                //					getAccumulateVol();
                break;

            case "btn_cost_ofc":
                if (formObj.cost_ofc_cd.readOnly) {
                    ComShowMessage(ComGetMsg('TES21024'));
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
                var chkStr = dispaly.substring(0, 3)
                    // radio PopUp
                if (chkStr == "1,0") {
                    ComOpenPopup('/opuscntr/COM_ENS_071.do' + param, 770, 450, 'getOfcCd', dispaly, true);
                } else {
                    ComShowMessage(ComGetMsg('TES10004'));
                    return;
                }
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
                    //						ComOpenWindowCenter('ESD_TES_9210RemarksPopup.screen?hld_rmk_inp_nm=hld_rmk', 'popup_remarks', 300, 140, true);
                    ComOpenPopup('ESD_TES_9210RemarksPopup.screen?hld_rmk_inp_nm=' + formObj.hld_rmk.value, 450, 140, "", "1,0,1,1,1,1,1", true);
                }
                break;

            case "btns_calendar1":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == 'C') {
                    ComShowMessage('Confirmed Invoice !!');
                    return false;
                }
                var cal = new ComCalendar();
                cal.select(formObj.iss_dt, 'yyyy-MM-dd');
                break;

            case "btns_calendar2":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == 'C') {
                    ComShowMessage('Confirmed Invoice !!');
                    return false;
                }
                var cal = new ComCalendar();
                cal.select(formObj.rcv_dt, 'yyyy-MM-dd');
                break;

            case "btns_accumulate":
                if (formObj.vndr_seq.value == null || formObj.vndr_seq.value == '' ||
                    formObj.yd_cd.value == null || formObj.yd_cd.value == '' || formObj.is_valid_yd_cd.value != 'Y')
                    return false;
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == 'C') {
                    ComShowMessage('Confirmed Invoice !!');
                    return false;
                }
                ComOpenWindowCenter('ESD_TES_9220AcumulatePopup.screen', 'popup_accumaulate', 620, 390, true);
                break;

            case "btn_save":
                //alert("start btn_save");
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage("Rejected Invoice !!");
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == "C") {
                    ComShowMessage("Confirmed Invoice !!");
                    return false;
                }
                if (!fnChkEmptyObj(formObj.vndr_seq)) return;
                if (!fnChkEmptyObj(formObj.inv_no)) return;
                if (!fnChkEmptyObj(formObj.yd_cd)) return;
                if (!fnChkEmptyObj(formObj.inv_ofc_cd)) return;
                if (!fnChkEmptyObj(formObj.cost_ofc_cd)) return;

                if (formObj.curr_cd.value == null || formObj.curr_cd.value.trim() == '') {
                    ComShowMessage(ComGetMsg('TES40039')); //
                    return false;
                }

                if (!fnChkEmptyObj(formObj.ttl_inv_amt)) return;
                if (!fnChkEmptyObj(formObj.iss_dt)) return;
                if (!fnChkEmptyObj(formObj.rcv_dt)) return;
                if (ComGetDaysBetween(formObj.iss_dt, formObj.rcv_dt) < 0) {
                    ComShowMessage('Issue date must be earlier than RCV date.');
                    return false;
                }

                formObj.cost_cd_ftr_rmk.value = replaceAll(agmt_lgs_cost_cd.GetSelectCode(), ',', '|');

                doActionMainHidden(main_hidden, formObj, IBSAVE);
                break;

            case "btng_plus":
                if (formObj.tml_so_ofc_cty_cd.value == '' || formObj.tml_so_seq.value == '') {
                    ComShowMessage(ComGetMsg('TES21005'));
                    return false;
                }
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage('Rejected Invoice !!');
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == 'C') {
                    ComShowMessage('Confirmed Invoice !!');
                    return false;
                }
                // REV_YRMON - 2007.05.08 ... Start
                //				    if(check_revYRMON() == false){
                //                        return false;
                //                    }
                // REV_YRMON - 2007.05.08 ... END
                if (sheetObjects[4].RowCount() > 0 && (sheetObject.IsDataModified() || sheetObject1.IsDataModified())) {
                    ComShowMessage(ComGetMsg('TES40007'));
                    return false;
                }
                if (sheetObjects[0].RowCount() > 0 && sheetObject2.RowCount() == 0) {
                    ComShowMessage(ComGetMsg('TES40014'));
                    return false;
                }
                if (sheetObjects[4].RowCount() > 0 && sheetObject2.IsDataModified()) {
                    ComShowMessage(ComGetMsg('TES40013'));
                    return false;
                }
                //					if(ComShowConfirm(ComGetMsg('TES21018'))){
                //formObj.tab1.selectedIndex=0;
                tabObjects[0].SetSelectedIndex(0);
                sheetObject.RemoveAll();
                sheetObject1.RemoveAll();
                sheetObject2.RemoveAll();
                ComEnableManyObjects(true, formObj.vvd, formObj.io_bnd_cd);
                //formObj.atb_dt.value = ''; 
                //atb_dt.RemoveAll(); //2016-06-16 수정
                initAtbDtComboItem(); //2016.07.13 Add
                formObj.vvd.value = '';
                formObj.vvd.focus();
                ShowCalculatedAmountByVVD();
                //					}
                break;

            case "btng_minus":
                if (formObj.tml_so_ofc_cty_cd.value == '' || formObj.tml_so_seq.value == '') {
                    ComShowMessage(ComGetMsg('TES21005'));
                    return false;
                }
                if (sheetObject.RowCount() == 0 && sheetObject1.RowCount() == 0 && sheetObject2.RowCount() == 0 && vvd_hidden.FindText('vvd', formObj.vvd.value + io_hidden) == -1) {
                    formObj.vvd.value = '';
                    //formObj.atb_dt.value = '';
                    //atb_dt.RemoveAll(); //2016-06-16 수정
                    initAtbDtComboItem(); //2016.07.13 Add
                } else {
                    listClear();
                }
                break;

            case "btng_back":
                if (vvd_hidden.FindText('vvd', formObj.vvd.value + io_hidden) == vvd_hidden.HeaderRows()) {
                    ComShowMessage(ComGetMsg('TES21022'));
                    return false;
                } else {
                    findPage(-1);
                }
                break;

            case "btng_next":
                if (vvd_hidden.FindText('vvd', formObj.vvd.value + io_hidden) == vvd_hidden.RowCount()) {
                    ComShowMessage(ComGetMsg('TES21023'));
                    return false;
                } else {
                    findPage(1);
                }
                break;

            case "t1btng_getcntr":
                if (formObj.tml_so_ofc_cty_cd.value == null || formObj.tml_so_ofc_cty_cd.value == '') {
                    ComShowMessage(ComGetMsg('TES21005'));
                    return false;
                }
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage('Rejected Invoice !!');
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == 'C') {
                    ComShowMessage('Confirmed Invoice !!');
                    return false;
                }
                if (!fnChkEmptyObj(formObj.vndr_seq)) return;
                if (!fnChkEmptyObj(formObj.yd_cd)) return;
                if (!fnChkEmptyObj(formObj.rcv_dt)) return;
                if (!fnChkEmptyObj(formObj.vvd)) return;

                if (!fnChkEmptyObj(formObj.io_bnd_cd)) return;

                if (!fnChkEmptyObj(formObj.atb_dt)) return;
                if (sheetObject.RowCount() > 0 || sheetObject1.RowCount() > 0) {
                    if (ComShowConfirm(ComGetMsg('TES40032', formObj.vvd.value + formObj.io_bnd_cd.value))) {
                        sheetObject.RemoveAll();
                        sheetObject1.RemoveAll();
                        doActionIBSheet1(sheetObject, formObj, IBCLEAR);
                    } else {
                        return false;
                    }
                }
                
                // 2016-06-16 수정
                /*
                var sAtbDt = atb_dt.GetSelectText();
                var sCalSeq = document.form.call_yd_ind_seq.value; 
                //atb_dt.RemoveAll();
                initAtbDtComboItem(); //2016.07.13 Add
                atb_dt.InsertItem(0, sAtbDt, sAtbDt);
                atb_dt.SetSelectCode(0, true);
                document.form.call_yd_ind_seq.value = sCalSeq;
                */
                //2016.09.09 AGMT COST CD Add
                var params = "";
                    params +="?cntr_tpsz_cd="+CNTR_TPSZ_CD;
                    params +="&cost_cd_ftr_rmk="+replaceAll(agmt_lgs_cost_cd.GetSelectCode(), ',', '|');
                ComOpenWindow('ESD_TES_9010.screen' + params, window, 'dialogWidth:710px;dialogHeight:520px;help:no;status:no;resizable:yes;', true);
                //ComOpenWindow('ESD_TES_9010.screen?cntr_tpsz_cd=' + CNTR_TPSZ_CD, window, 'dialogWidth:710px;dialogHeight:520px;help:no;status:no;resizable:yes;', true);
                break;

            case "t1btng_save":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage('Rejected Invoice !!');
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == 'C') {
                    ComShowMessage('Confirmed Invoice !!');
                    return false;
                }
                if (formObj.tml_so_ofc_cty_cd.value == null || formObj.tml_so_ofc_cty_cd.value == '') {
                    ComShowMessage(ComGetMsg('TES21005'));
                    return false;
                }
                if (formObj.page.value == '') {
                    ComShowMessage('[CASE 1] The system will retrieve the invoice data automatically due to the error to call the related information. \nPlease input the VVD data again for invoice auditing after completion of retrieve.');
                    retrieveAll();
                    return false;
                }
                if (CheckCNTRListMandatoryCol() == false) {
                    return false;
                }
                if (sheetObject2.RowCount() > 0) {
                    needRecalculation();
                }
                if (formObj.atb_dt.value == '' || formObj.atb_dt.value == null) {
                    ComShowMessage(ComGetMsg('TES40036'));
                    return false;
                }
                var verifyCnt = 0;
                for (var i = sheetObject.HeaderRows(); i < sheetObject.HeaderRows() + sheetObject.RowCount(); i++) {
                    //            			if(sheetObject.CellValue(i,'dscr_ind_cd') != 'CO' && sheetObject.CellValue(i,'dscr_ind_cd') != 'HO' ){
                    if (sheetObject.GetCellValue(i, 'dscr_ind_cd') != '' && sheetObject.GetCellValue(i, 'dscr_ind_cd') != 'HO') {
                        verifyCnt++;
                    }
                }
                if (verifyCnt > 0) {
                    ComShowMessage("There are containers without correct verify result.\nPlease check whether container list, VVD, bound, F/M are correctly input.");
                }
                
                // 2016-06-16 수정
                //var sAtbDt = atb_dt.GetSelectText();
                //var sCalSeq = document.form.call_yd_ind_seq.value; 
                //atb_dt.RemoveAll();
                //initAtbDtComboItem(); //2016.07.13 Add
                //atb_dt.InsertItem(0, sAtbDt, sAtbDt);
                //atb_dt.SetSelectCode(0, true);  
                
                //document.form.call_yd_ind_seq.value = sCalSeq;
                
                doActionIBSheet1(sheetObject, formObj, IBSAVE);
                break;

            case "t1btng_downexcel":
                if (sheetObject.RowCount() < 1) { //no data
                    ComShowCodeMessage("COM132501");
                } else {
                    doActionIBSheet1(sheetObject, formObj, IBDOWNEXCEL);
                }
                break;

            case "t1btng_clear":
                listClear();
                break;

            case "t1btng_todiscrepancy":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage('Rejected Invoice !!');
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == 'C') {
                    ComShowMessage('Confirmed Invoice !!');
                    return false;
                }
                if (sheetObject.RowCount() < 1) {
                    ComShowMessage(ComGetMsg('TES21008'));
                    return false;
                }
                if (sheetObject.CheckedRows('chk') < 1) {
                    ComShowMessage(ComGetMsg('TES21009'));
                    return false;
                }
                modifyContainerVerifyStatus(sheetObject, sheetObject1, 'DC', '');
                break;

                //                case "t1btng_db_check":
                //                	if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
                //                		ComShowMessage('Rejected Invoice !!');
                //                		return false;
                //                	}
                //                	if (formObj.tml_inv_sts_cd.value == 'C') {
                //                		ComShowMessage('Confirmed Invoice !!');
                //                		return false;
                //                	}
                //                	if (sheetObject.RowCount()< 1){
                //                		ComShowMessage(ComGetMsg('TES21008'));
                //                		return false;
                //                	}
                //
                //                	doActionIBSheet1(sheetObject, formObj, IBSEARCH_ASYNC02);
                //                	
                //                	break;

            case "t1btng_costcalc":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage('Rejected Invoice !!');
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == 'C') {
                    ComShowMessage('Confirmed Invoice !!');
                    return false;
                }
                var auto_cnt = 0;
                if (!isValidAgmtSts()) {
                    return false;
                }
                if (CheckCNTRListMandatoryCol() == false) {
                    return false;
                }
                //                    if(!isValidAgmtCurrCD()){
                //                        return false;
                //                    }
                if (sheetObject2.RowCount() > 0) {
                    ComShowMessage(ComGetMsg('TES40053'));
                    return false;
                }
                if (sheetObject.IsDataModified() || sheetObject1.IsDataModified()) {
                    ComShowMessage(ComGetMsg('TES21011'));
                    return false;
                }
                //formObj.tab1.selectedIndex=2;

                doActionIBSheet3(sheetObject2, formObj, IBSEARCH_ASYNC02);

                break;

            case "t2btng_clear":
                listClear();
                break;

            case "t2btng_reverify":
                if (sheetObject.RowCount() == 0 && sheetObject1.RowCount() == 0) {
                    ComShowMessage(ComGetMsg('TES21017'));
                    return false;
                }
                doActionIBSheet2(sheetObject1, formObj, IBSEARCH);
                break;

            case "t2btng_verification":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage('Rejected Invoice !!');
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == 'C') {
                    ComShowMessage('Confirmed Invoice !!');
                    return false;
                }
                if (sheetObject1.RowCount() < 1) {
                    ComShowMessage(ComGetMsg('TES21008'));
                    return false;
                }
                if (sheetObject1.CheckedRows('chk') < 1) {
                    ComShowMessage(ComGetMsg('TES21009'));
                    return false;
                }
                modifyContainerVerifyStatus(sheetObject1, sheetObject, 'CO', 'Y');
                break;

            case "t2btng_reject":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage('Rejected Invoice !!');
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == 'C') {
                    ComShowMessage('Confirmed Invoice !!');
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
                if (sheetObjects[3].RowCount() < 1 || sheetObjects[1].RowCount() < 1) {
                    ComShowMessage(ComGetMsg('TES21013'));
                    return;
                }
                parmObj[0] = '1';
                parmObj[1] = '';
                parmObj[2] = 'N';
                parmObj[3] = RD_path + 'apps/opus/esd/tes/serviceproviderinvoicemanage/marineterminalinvoicemanage/report/ESD_TES_0805.mrd'; // RD 화면
                parmObj[4] = rdObj;
                parmObj[5] = fromObj;
                rdObjModaless(RdReport, parmObj, 1000, 700);
                break;

            case "t2btng_downexcel":
                doActionIBSheet2(sheetObject1, formObj, IBDOWNEXCEL);
                break;

            case "t3btng_allocate":
                var url_str = 'ESD_TES_1003Popup.screen';
                url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
                url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
                ComOpenWindow(url_str, window, "dialogWidth:800px; dialogHeight:425px; help:no; status:no; resizable:yes;", true);
                break;

            case "t3btng_clear":
                listClear();
                break;

            case "t3btng_rowadd":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage('Rejected Invoice !!');
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == 'C') {
                    ComShowMessage('Confirmed Invoice !!');
                    return false;
                }
                if (formObj.vvd.value == '' || formObj.atb_dt.value == '') {
                    ComShowMessage('VVD must be entered before you input cost calculation data manually!');
                    return false;
                }
                var vvd_row = vvd_hidden.FindText('vvd', formObj.vvd.value + io_hidden);
                if (vvd_row < 0) {
                    ComShowMessage('[CASE 2] The system will retrieve the invoice data automatically due to the error to call the related information. ' +
                        '\nPlease input the VVD data again for invoice auditing after completion of retrieve.');
                    retrieveAll();
                    return false;
                }
                if (vvd_hidden.GetCellValue(vvd_row, 'vvd_vsl_cd') == '' || vvd_hidden.GetCellValue(vvd_row, 'vvd_skd_voy_no') == '' || vvd_hidden.GetCellValue(vvd_row, 'vvd_skd_dir_cd') == '' || vvd_hidden.GetCellValue(vvd_row, 'vvd_atb_dt') == '') {
                    ComShowMessage('[CASE 3] The system will retrieve the invoice data automatically due to the error to call the related information. ' +
                        '\nPlease input the VVD data again for invoice auditing after completion of retrieve.');
                    retrieveAll();
                    return false;
                }
                if (sheetObject.RowCount() == 0 && sheetObject1.RowCount() == 0 && sheetObject2.RowCount() == 0) {
                    ComEnableManyObjects(false, formObj.vvd, formObj.io_bnd_cd);
                }
                var row = sheetObject2.DataInsert(-1);
                sheetObject2.SetCellValue(row, 'calc_cost_grp_cd', 'TM', 0);
                sheetObject2.SetCellValue(row, 'calc_tp_cd', 'M', 0);
                sheetObject2.SetCellValue(row, 'cntr_tpsz_cd', '', 0);
                sheetObject2.SetCellValue(row, 'io_bnd_cd', io_hidden, 0);
                sheetObject2.SetCellValue(row, 'dcgo_ind_cd', 'N', 0);
                sheetObject2.SetCellValue(row, 'vol_tr_ut_cd', '', 0);
                sheetObject2.CellComboItem(row, 'lgs_cost_cd', {
                    ComboText: formObj.calcTerminalComboItems.value,
                    ComboCode: formObj.calcTerminalComboItems.value
                });
                                
                setDefaultCurrencyFormToSheet(sheetObject2, row, "curr_cd"); //2016.10.11 Currency FormToSheet Add
                
                sheetObject2.SetCellValue(row, 'lgs_cost_cd', '', 0);
                sheetObject2.SetCellValue(row, 'tml_crr_cd', '', 0);
                sheetObject2.SetCellValue(row, 'ioc_cd', '', 0);
                sheetObject2.SetCellValue(row, 'rc_flg', '', 0);
                sheetObject2.SetCellValue(row, 'lane_cd', '', 0);
                sheetObject2.SetCellValue(row, 'tml_wrk_dy_cd', '', 0);
                sheetObject2.SetCellValue(row, 'inv_xch_rt', '1.00', 0);
                sheetObject2.SetCellValue(row, 'vsl_cd', vvd_hidden.GetCellValue(vvd_row, 'vvd_vsl_cd'), 0);
                sheetObject2.SetCellValue(row, 'skd_voy_no', vvd_hidden.GetCellValue(vvd_row, 'vvd_skd_voy_no'), 0);
                sheetObject2.SetCellValue(row, 'skd_dir_cd', vvd_hidden.GetCellValue(vvd_row, 'vvd_skd_dir_cd'), 0);
                sheetObject2.SetCellValue(row, 'atb_dt', vvd_hidden.GetCellValue(vvd_row, 'vvd_atb_dt'), 0);
                sheetObject2.SetCellValue(row, 'page_rows', tmp_seq++, 0);
                setShtCellsEditable(sheetObject2, row, 'lgs_cost_cd|cntr_tpsz_cd|dcgo_ind_cd|tml_wrk_dy_cd|ioc_cd|tml_trns_mod_cd|lane_cd|sub_trd_cd|vol_tr_ut_cd|ctrt_rt|calc_vol_qty|inv_xch_rt|inv_amt|rc_flg', 'Y');
                break;

            case "t3btng_rowdel":
                var flag = false;
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage('Rejected Invoice !!');
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == 'C') {
                    ComShowMessage('Confirmed Invoice !!');
                    return false;
                }
                if (sheetObject2.RowCount() > 0) {
                    var selectedRow = sheetObject2.GetSelectionRows('|').split('|');
                    for (var i = selectedRow.length - 1; i >= 0; i--) {
                        if (sheetObject2.GetCellValue(selectedRow[i], "tml_so_dtl_seq") == null || sheetObject2.GetCellValue(selectedRow[i], "tml_so_dtl_seq").trim() == '' || parseInt(sheetObject2.GetCellValue(selectedRow[i], "tml_so_dtl_seq")) == 0) {
                            sheetObject2.RowDelete(selectedRow[i], false);
                        } else {
                            flag = true;
                            sheetObject2.SetRowStatus(selectedRow[i], 'D');
                            sheetObject2.SetRowHidden(selectedRow[i], 1);
                            sheetObject2.SetCellValue(selectedRow[i], "inv_amt", 0, 0);
                        }
                    }
                    if (flag == true) {
                        formObj.delete_mode.value = 'ROW';
                        doActionIBSheet3(sheetObject2, formObj, IBDELETE);
                        formObj.delete_mode.value = '';
                    }
                }
                break;

            case "t3btng_save":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage('Rejected Invoice !!');
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == 'C') {
                    ComShowMessage('Confirmed Invoice !!');
                    return false;
                }
                if (formObj.atb_dt.value == '' || formObj.atb_dt.value == null) {
                    ComShowMessage(ComGetMsg('TES40036'));
                    return false;
                }
                //				    if(check_revYRMON() == false){
                //                        return false;
                //                    }
                needRecalculation();
                if (checkCostCalculation() == false) {
                    return false;
                }
                doActionIBSheet3(sheetObject2, formObj, IBSAVE);
                break;

            case "t3btng_totalamount":
                var url_str = "ESD_TES_9040Pop.screen";
                ComOpenWindow(url_str, window, "help:no;status:no;resizable:no;dialogWidth:510px;dialogHeight:350px", true);
                break;

            case "t3btng_confirm":
                if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
                    ComShowMessage('Rejected Invoice !!');
                    return false;
                }
                if (formObj.tml_inv_sts_cd.value == 'C') {
                    ComShowMessage('Confirmed Invoice !!');
                    return false;
                }
                if (ComGetDaysBetween(formObj.iss_dt, formObj.rcv_dt) < 0) {
                    ComShowMessage('Issue date must be earlier than RCV date.');
                    return false;
                }
                if (formObj.ttl_inv_amt.value != formObj.tot_inv_amt.value) {
                    ComShowMessage(ComGetMsg('TES21016'));
                    return false;
                }
                if (sheetObject2.RowCount() == 0) {
                    ComShowMessage('There is no Calculation data.');
                    return false;
                }
                for (var i = sheetObject2.HeaderRows(); i < sheetObject2.HeaderRows() + sheetObject2.RowCount(); i++) {
                    if (sheetObject2.GetCellValue(i, 'lgs_cost_cd') == 'SVXXJO' && sheetObject2.GetCellValue(i, 'inv_amt') > 0) {
                        if ((sheetObject2.GetCellValue(i, 'rvis_vol_qty') == '' || sheetObject2.GetCellValue(i, 'rvis_vol_qty') == 0) || (sheetObject2.GetCellValue(i, 'n3pty_flg') == '' || sheetObject2.GetCellValue(i, 'n3pty_flg') != 'Y') || sheetObject2.GetCellValue(i, 'tml_crr_cd') == '') {
                            ComShowMessage(ComGetMsg('TES40022'));
                            return false;
                        }
                        //							if(sheetObject2.CellValue(i,'inv_amt') <= 0){
                        //								ComShowMessage('Amount should be bigger than 0 when you have 3rd Party(SVXXJO).');
                        //								return false;
                        //							}
                    }
                }
                needRecalculation();
                if (checkCostCalculation() == false) {
                    return false;
                }
                document.getElementById("costCalcFlg").value = "C";
                //save 'Detailes' inadvance to keep 'curr_cd in detail' from saving in header
                //doActionIBSheet3(sheetObject2, formObj, IBSAVE);
                doActionMainHidden(main_hidden, formObj, IBSEARCH_ASYNC01);
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

                if (formObj.atb_dt.value == '' || formObj.atb_dt.value == null) {
                    ComShowMessage(ComGetMsg('TES40036'));
                    return false;
                }
                
                // 2016-06-16 수정
                //var sAtbDt = atb_dt.GetSelectText();
                //var sCalSeq = document.form.call_yd_ind_seq.value; 
                //atb_dt.RemoveAll();
                //initAtbDtComboItem(); //2016.07.13 Add
                //atb_dt.InsertItem(0, sAtbDt, sAtbDt);
                //atb_dt.SetSelectCode(0, true);  
                
                //document.form.call_yd_ind_seq.value = sCalSeq;
                
                var param = "?yd_cd=" + formObj.yd_cd.value + "&yd_nm=" + formObj.yd_nm.value + "&vvd=" + formObj.vvd.value + "&vndr_seq=" + formObj.vndr_seq.value + "&vndr_seq_nm=" + formObj.vndr_seq_nm.value + "&curr_cd=" + formObj.curr_cd.value + "&prgm_id=ESD_TES_0001&cost_cd_inv_tp_cd=MT&atb_dt=" + atb_dt.GetSelectText();
                //ComOpenPopup(sUrl,                     iWidth, iHeight, sFunc,            sDisplay,        bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                ComOpenPopup("ESD_TES_9001.do" + param, 830, 670, "setCostCode", "1,0,1,1,1,1,1", true, false, null, null, null, 'Cost Calculation', 'no');
                break;

        } // end switch
    } catch (e) {
        if (e == '[object Error]') {
            ComShowCodeMessage('TES21025');
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
 * check search form
 * @param {form} formObj   form object 
 * @return
 */
function fnChkSearchForm(formObj) {
    if (!fnChkEmptyObj(formObj.vndr_seq)) return false;
    if (!fnChkEmptyObj(formObj.inv_no)) return false;
    return true;
}

/** eheck enter key
 * 
 * @param {String} funcNm	function name
 * @return
 */
function enterCheck(funcNm) {
    var formObj = document.form;
    if (funcNm == undefined || funcNm == null || funcNm.trim() == '') {
        return false;
    }
    if (event.keyCode == 13) {
        retrieveAll();
    }
}

/**
 * Object Validation
 *
 * @param {object} obj    - validation할 object
 */
function fnChkEmptyObj(obj) {
    if (obj.type == 'text' || obj.type == 'textarea' || obj.type == 'password' || obj.type == 'file') {
        if (obj.value == null || obj.value == '') {
            ComShowMessage(ComGetMsg('TES21026', obj.title));
            obj.focus();
            return false;
        }
    } else if (obj.type.indexOf('select') != -1) {
        if (obj.selectedIndex == -1) {
            ComShowMessage(ComGetMsg('TES21026', obj.title));
            obj.focus();
            return false;
        }
    } else if (obj.type == 'radio') {
        var group = formObj[obj.name];
        var checked = false;
        if (!group.length) {
            checked = obj.checked;
        } else {
            for (var r = 0; r < group.length; r++) {
                if ((checked = group[r].checked)) {
                    break;
                }
            }
        }
        if (!checked) {
            ComShowMessage(ComGetMsg('TES21027', obj.title));
            obj.focus();
            return false;
        }
    } else if (obj.type == 'checkbox') {
        var group = formObj[obj.name];
        if (group.length) {
            var checked = false;
            for (var r = 0; r < group.length; r++) {
                if ((checked = group[r].checked)) {
                    break;
                }
            }
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
 */
function validChkForm(formObj) {
    for (var e = 0; e < formObj.elements.length; e++) {
        var el = formObj.elements[e];
        if (el.valid == '1') {
            if (!fnChkEmptyObj(el)) return false;
        }
    }
    return true;
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param {ibsheet}	sheet_obj   sheet object
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
    sheetObjectsMap[sheet_obj.id] = sheet_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    getComCdList(); // CNTR_TPSZ_CD, MT_A_LGS_COST_CD, CARR_CD     //tes_getInputValue('tmp_common_code', SEARCH17, '', 'setCommonCode');
    
    //ComShowMessage('loadPage');
    for (i = 0; i < comboObjects.length; i++) {
        initCombo(comboObjects[i], i + 1);
    }
		
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    for (i = 0; i < tabObjects.length; i++) {
        initTab(tabObjects[i], i + 1);
        tab1.SetTabDisable(1, true);
        tab1.SetTabDisable(2, true);
        tab1.SetSelectedIndex(0);
    }
    
    var formObj = document.form;
    
	if(getCurrencyList(0, 70, 100)){ 
		resetSheetDataProperty(comboObjects[0].GetSelectCode());
	}
	
	  
	getWhldTaxAmtMode();  // WHLD_TAX_READONLY_MODE      //tes_getInputValueInvoice('whld_tax_amt_mode', SEARCH05, 'inv_ofc_cd', 'setWhldTaxAmtMode');
	
	if(getManualLgsCostCd()){ // MANUAL_LGS_COST_CD        //tes_getInputValue('manual_lgs_cost_cd', SEARCH16, 'calc_cost_grp_cd', '');
		formObj.manual_lgs_cost_cd.value = MANUAL_LGS_COST_CD;
	}
	        
    //tes_getComboItem('curr_cd', 1, SEARCH03, '', 'inv_ofc_cd', 'setCalcColFormat');
    
    setInitComponent('N');
    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
    
    formObj.vndr_seq.focus();

    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    
    if (!ComIsNull(formObj.inv_no_tmp.value)) {
        // [TES] special character, characterSet problem
        formObj.inv_no.value = formObj.inv_no_tmp.value;
        formObj.vndr_seq.value = vndr_seq;
        retrieveAll();
    }
}

/** set tax mod 
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

/** set calc column format
 * 
 * @return
 */
function setCalcColFormat() {

}

/** set common code
 * 
 * @return
 */
function setCommonCode() { //alert("start setCommonCode");
    var formObj = document.form;
    var tmp = '';
    if (formObj.tmp_common_code.value != undefined && formObj.tmp_common_code.value != null && formObj.tmp_common_code.value.trim() != '') {
        tmp = formObj.tmp_common_code.value.split('--');
        if (tmp.length > 0) {
            for (var i = 0; i < tmp.length; i++) {
                tmp[i] = (tmp[i] != undefined && tmp[i] != null ? tmp[i] : '');
            }
            CNTR_TPSZ_CD = tmp[0];
            MT_A_LGS_COST_CD = tmp[1];
            CARR_CD = tmp[6];
        }
    }
    
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    var sheetObject_main = sheetObjects[3];
    
    if (!ComIsNull(formObj.inv_no_tmp.value)) {
        // [TES] special character, characterSet problem
        formObj.inv_no.value = formObj.inv_no_tmp.value;
        formObj.vndr_seq.value = vndr_seq;
        retrieveAll();
    }
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

/** 
 * Initialization Combo list
 * @param {comoObj}	comboObj	combo Object
 * @param {int}		comboNo 	combo no
 * @param {String}	combo_val 	combo value
 * @param {String}	def_val 	def value 
 */
function initCombo(comboObj, comboNo, combo_val, def_val) {
    var cnt = 0;
    switch (comboNo) {
        case 1: //currency
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
    }
}

/**
 * setting sheet initial values and header
 * @param {ibsheet} sheetObj 	==> , 
 * @param {int} 	sheetNo 	==>  
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //t1sheet1 init
			with(sheetObj){
				//		                (35, 6, 0, true);
				var HeadTitle="|STS||Seq.|modi_flg|CNTR No.|Type/\nSize|F/M|I/O|DG|Working\n Date|IPC|Mode|Lane|Lane2|Sub Trade|T/S|R/D Term|BKG NO|Verify \n Result|Remarks|"
				+ "tml_so_cntr_list_seq|vrfy_rslt_ind_cd|atb_dt|vvd|"
				+ "vsl_cd|skd_voy_no|skd_dir_cd|dscr_dtl_ind_cd|bb_cgo_flg|awk_cgo_flg|rc_flg|"
				+ "bkg_no|bkg_no_split|bl_no|bl_no_tp|bl_no_chk";
				
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ 
							{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sts",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"modi_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_clss_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"wrk_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ioc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tml_trns_mod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lane_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lane_cd2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"locl_ts_ind_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcvde_term_ind_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no_con",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dscr_ind_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tml_so_cntr_list_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vrfy_rslt_ind_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"atb_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dscr_dtl_ind_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rc_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no_split",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no_tp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);		
				SetEditable(1);
				SetColProperty("cntr_sty_cd", {ComboText:cntr_sty_cdCode, ComboCode:cntr_sty_cdCode} );
				SetColProperty("io_bnd_cd", {ComboText:io_bnd_cdCode, ComboCode:io_bnd_cdCode} );
				SetColProperty("dcgo_clss_cd", {ComboText:dcgo_clss_cdCode, ComboCode:dcgo_clss_cdCode} );
				SetColProperty("ioc_cd", {ComboText:"|"+ioc_cdText, ComboCode:"|"+ioc_cdCode} );
				SetColProperty("tml_trns_mod_cd", {ComboText:"|"+tml_trns_mod_cdText, ComboCode:"|"+tml_trns_mod_cdCode} );
				SetColProperty("locl_ts_ind_cd", {ComboText:locl_ts_ind_cdCode, ComboCode:locl_ts_ind_cdCode} );
				SetColProperty("cntr_tpsz_cd", {ComboText:CNTR_TPSZ_CD, ComboCode:CNTR_TPSZ_CD} );
				SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
				SetSheetHeight(240);
			}		
		break;
		
		case 2:      //t2sheet1 init
			with(sheetObj){
				//	                 (35, 7, 0, true);
				var HeadTitle="|STS||Seq.|Modi Flg|Discrepancy Type|CNTR No.|Type/\nSize|F/M|I/O|DG|Working\n Date|IPC|Mode|Lane|Lane2|Sub Trade|T/S|R/D Term|BKG NO|"
				+ "vrfy_rslt_ind_cd|Remarks|tml_so_cntr_list_seq|atb_dt|vvd|"
				+ "vsl_cd|skd_voy_no|skd_dir_cd|dscr_dtl_ind_cd|bb_cgo_flg|awk_cgo_flg|rc_flg"
				+ "bkg_no|bkg_no_split|bl_no|bl_no_tp|bl_no_chk";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sts",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"modi_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"dscr_ind_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_clss_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"wrk_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ioc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tml_trns_mod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lane_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lane_cd2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"locl_ts_ind_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcvde_term_ind_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no_con",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vrfy_rslt_ind_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"cntr_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tml_so_cntr_list_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"atb_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dscr_dtl_ind_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rc_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no_split",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no_tp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);	
				SetEditable(1);
				SetColProperty("cntr_sty_cd", {ComboText:cntr_sty_cdCode, ComboCode:cntr_sty_cdCode} );
				SetColProperty("io_bnd_cd", {ComboText:"|"+io_bnd_cdCode, ComboCode:"X|"+io_bnd_cdCode} );
				SetColProperty("dcgo_clss_cd", {ComboText:dcgo_clss_cdCode, ComboCode:dcgo_clss_cdCode} );
				SetColProperty("ioc_cd", {ComboText:"|"+ioc_cdText, ComboCode:"|"+ioc_cdCode} );
				SetColProperty("tml_trns_mod_cd", {ComboText:"|"+tml_trns_mod_cdText, ComboCode:"|"+tml_trns_mod_cdCode} );
				SetColProperty("locl_ts_ind_cd", {ComboText:locl_ts_ind_cdCode, ComboCode:locl_ts_ind_cdCode} );
				SetColProperty("cntr_tpsz_cd", {ComboText:CNTR_TPSZ_CD, ComboCode:CNTR_TPSZ_CD} );
				SetColProperty("dscr_ind_cd", {ComboText:dscr_ind_cdText, ComboCode:dscr_ind_cdCode} );
				SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
				resizeSheet();//SetSheetHeight(240);
			}
		break;
		
		case 3:      //t3sheet1 init
			with(sheetObj){
				//		                (52, 9, 0, true);
				var HeadTitle="SEQ|STS|tml_so_dtl_seq|calc_cost_grp_cd|Calculation Type|vsl_cd|skd_voy_no|skd_dir_cd|"
				+ "Cost Code|lgs_cost_cd2|Type/\n Size|I/O|DG|Reefer|Applied\n Date|IPC|Mode|Lane|Lane|Sub Trade|fm_tr_vol_val|to_tr_vol_val|"
				+ "Vol.Tier|acct_cd|Calculated\nVol.|Revised\n Vol.|"
				+ "UOM|Rate|AGMT\nCurr.|Exch.\nRate|Reefer\nMntr Days|Amount|Remarks|Carrier|3rd\nParty|atb_dt|cntr_no|wrk_dt|stay_dys|free_dys|ovr_dys|"
				+ "fp_calc_prd_cd|stk_vol_qty|fp_teu_qty|inv_vol_qty|diff_vol_qty|ovr_vol_qty|calc_amt|"
				+ "curr_chk||";
				
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"page_rows",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tml_so_dtl_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"calc_cost_grp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"calc_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_ind_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rc_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"tml_wrk_dy_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"ioc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tml_trns_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lane_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lane_cd2",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"fm_tr_vol_val",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"to_tr_vol_val",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"tier",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"acct_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"calc_vol_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Popup",     Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"rvis_vol_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vol_tr_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ctrt_rt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"inv_xch_rt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:5,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"rf_mntr_dys",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"calc_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tml_crr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Popup",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"semi_auto_calc_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"atb_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"wrk_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"stay_dys",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"free_dys",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ovr_dys",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"fp_calc_prd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"stk_vol_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"fp_teu_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"inv_vol_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"diff_vol_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ovr_vol_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"calc_amt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tml_agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tml_agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tml_agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"curr_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"accm_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }];
				
				InitColumns(cols);		
				SetEditable(1);
				SetColProperty("calc_tp_cd", {ComboText:"AutoCalculatedCost|ManualInputCost|SemiAutoInputCost", ComboCode:"A|M|S"} );
				SetColProperty("io_bnd_cd", {ComboText:io_bnd_cdCode, ComboCode:io_bnd_cdCode} );
				SetColProperty("dcgo_ind_cd", {ComboText:dcgo_clss_cdCode, ComboCode:dcgo_clss_cdCode} );
				SetColProperty("tml_wrk_dy_cd", {ComboText:tml_wrk_dy_cdCode, ComboCode:tml_wrk_dy_cdCode} );
				SetColProperty("ioc_cd", {ComboText:ioc_cdText, ComboCode:ioc_cdCode} );
				SetColProperty("rc_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
				SetColProperty("vol_tr_ut_cd", {ComboText:vol_tr_ut_cdCode, ComboCode:vol_tr_ut_cdCode} );
				SetColProperty("lgs_cost_cd", {ComboText:MT_A_LGS_COST_CD, ComboCode:MT_A_LGS_COST_CD} );
				SetColProperty("cntr_tpsz_cd", {ComboText:CNTR_TPSZ_CD, ComboCode:CNTR_TPSZ_CD} );
				SetColProperty("tml_crr_cd", {ComboText:"|"+CARR_CD, ComboCode:"|"+CARR_CD} );
				SetColProperty("tml_trns_mod_cd", {ComboText:"|"+tml_trns_mod_cdText, ComboCode:"|"+tml_trns_mod_cdCode} );
				SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
				resizeSheet();//SetSheetHeight(240);
			}
		break;
		
		case 4:      //main_hidden init
			with(sheetObj){
				//		             (39, 4, 0, true);
				var HeadTitle="|STS|tml_so_ofc_cty_cd|tml_so_seq|inv_ofc_cd|cost_ofc_cd|inv_no|vndr_seq|yd_cd|yd_nm|curr_cd|ttl_inv_amt|vat_amt|ttl_calc_amt|fm_prd_dt|hld_flg|hld_rmk|"
				+"to_prd_dt|tml_inv_tp_cd|tml_cost_grp_cd|tml_calc_ind_cd|sto_dys_ind_cd|iss_dt|rcv_dt|eff_dt|pay_due_dt|pay_flg|tml_inv_sts_cd|tml_inv_sts_nm|tml_inv_rjct_sts_cd|"
				+"inv_cfm_dt|tml_agmt_ofc_cty_cd|tml_agmt_seq|tml_agmt_ver_no|inv_rjct_rmk|vndr_nm|err_inv_no|whld_tax_amt|rtro_tml_inv_flg|cost_cd_ftr_rmk";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sts",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"inv_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cost_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"vndr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"yd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"yd_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"ttl_inv_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"vat_amt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"ttl_calc_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"fm_prd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"hld_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"hld_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"to_prd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"tml_cost_grp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"tml_calc_ind_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"sto_dys_ind_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"iss_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"rcv_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"pay_due_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"pay_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_sts_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_rjct_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"inv_cfm_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"inv_rjct_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"vndr_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"err_inv_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"whld_tax_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"rtro_tml_inv_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cost_cd_ftr_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
				
				InitColumns(cols);
				SetVisible(false);
				SetEditable(1);
			}
		
		
		break;
		
		case 5:      //vvd_hidden init
			with(sheetObj){
				//		              (14, 0, 0, true);
				var HeadTitle="STATUS|OFC_CTY|SO_SEQ|VVD_SEQ|VSL_CD|VOY_NO|DIR_CD|IO_BND|ATB_DT|VVD_TYPE|CRE_DT|VVD_AMOUNT|VVD|REV_YRMON|VVD_CALL_YD_IND_SEQ";//2016.07.13 Add
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd_ibflag",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_tml_so_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_tml_so_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_tml_so_vvd_list_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_skd_voy_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_skd_dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_io_bnd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_atb_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_type",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_amt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rev_yrmon",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_call_yd_ind_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } /*2016.07.13 Add*/
							];
				
				InitColumns(cols);
				SetSheetHeight(240);
				SetEditable(1);
			}
		break;
		
		case 6:      //sheet_accumulate Vol. init
			with(sheetObj){
				//		               SetSheetHeight(240);
				//		             (3, 0, 0, true);
				var HeadTitle="ibflg|pay_vol_qty|accm_seq";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pay_vol_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"accm_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				
				InitColumns(cols);
				SetSheetHeight(240);
				SetEditable(1);
			}
		break;
		
		case 7:      //costRvisCntr_hidden init
			with(sheetObj){
				//			               (32, 4, 0, true);
				var HeadTitle="STS|OFC CD|SO SEQ|DTL SEQ|RVIS SEQ|INV TP|CALC GROUP|RVIS TYPE|COST CD"
				+ "|CNTR NO|BKG NO|BKG NO SPLIT|VSL|VOYAGE|DIR|CUZ CNTR|RHND RSN|RVIS RMK"
				+"|CALC TYPE|IOC_CD|LANE_CD|IO_BND|CNTR TPSZ|FM_TR|TO_TR|DCGO|tml_wrk_dy_cd|trns_mod|Reefer|rvis_ind_flg|page_rows|Carrier";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_ibflag" },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_tml_so_ofc_cty_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_tml_so_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_tml_so_dtl_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_tml_so_rvis_list_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_tml_inv_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_calc_cost_grp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_tml_rvis_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_lgs_cost_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_bkg_no_split",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_skd_dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_cuz_cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_rhnd_rsn_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_rvis_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_calc_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_ioc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_lane_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_io_bnd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_fm_tr_vol_val",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_to_tr_vol_val",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_dcgo_ind_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_tml_wrk_dy_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_tml_trns_mod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_rc_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_ind_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_page_rows",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rvis_tml_crr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
				
				InitColumns(cols);
				SetVisible(false);
				SetEditable(1);
			}
		break;
		
		case 8:      //costN3ptyCntr_hidden init
			with(sheetObj){
				//			                (48, 4, 0, true);
				var HeadTitle="SEQ|STS|n3rd_tml_if_ofc_cd|n3rd_tml_if_seq|n3rd_tml_n3pty_if_sts_cd|n3rd_inv_no|n3rd_vndr_seq|n3rd_yd_cd|" +
				"n3rd_lgs_cost_cd|n3rd_acct_cd|n3rd_tml_so_ofc_cty_cd|n3rd_tml_so_seq|n3rd_tml_so_dtl_seq|"         +
				"n3rd_n3pty_bil_tp_cd|n3rd_cntr_no|n3rd_cntr_tpsz_cd|n3rd_bkg_no|n3rd_bkg_no_split|"                +
				"n3rd_vndr_cust_div_cd|"        +
				"n3rd_vndr_cnt_cd|n3rd_n3pty_vndr_seq|n3rd_cust_cnt_cd|n3rd_cust_seq|n3rd_n3pty_ofc_cd|"            +
				"n3rd_curr_cd|n3rd_if_amt|n3rd_if_rmk|n3rd_cxl_flg|n3rd_calc_tp_cd|n3rd_ioc_cd|n3rd_lane_cd|n3rd_io_bnd_cd|"        +
				"n3rd_fm_tr_vol_val|n3rd_to_tr_vol_val|n3rd_vvd|n3rd_dcgo_clss_cd|n3rd_tml_wrk_dy_cd|bl_no|bl_no_tp|bl_no_chk|" +
				"n3rd_acct_cd|vsl_cd|voy_no|dir_cd|trns_mod|ERR INVOICE|Reefer|CARRIER";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_page_rows",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Status",    Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_ibflag" },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_if_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_if_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_n3pty_if_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_vndr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_yd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_lgs_cost_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_acct_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_so_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_so_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_so_dtl_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_n3pty_bil_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_bkg_no_split",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_vndr_cust_div_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_vndr_cnt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_n3pty_vndr_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_cust_cnt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_cust_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_n3pty_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_if_amt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_if_rmk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_cxl_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_calc_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_ioc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_lane_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_io_bnd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_fm_tr_vol_val",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_to_tr_vol_val",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_vvd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_dcgo_ind_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_wrk_dy_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_bl_no_tp",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_bl_no_chk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_acct_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_skd_voy_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_skd_dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_trns_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_err_inv_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_rc_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3rd_tml_crr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
				
				InitColumns(cols);
				SetVisible(false);
				SetEditable(1);
			}
		break;
		
		case 9:      //costCalc_hidden init
			with(sheetObj){
				//		               (7, 4, 0, true);
				var HeadTitle="SEQ|VSL_CD|VOY_NO|DIR_CD|IO_BND_CD|INV_AMT|RVIS_CNTR_LIST_CD";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tml_so_vvd_list_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inv_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_cntr_list_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				SetVisible(false);
				SetEditable(1);
			}
		break;
		
		case 10:
			with(sheetObj){
				//		                (1, 4, 0, true);
				var HeadTitle="DATA";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"etc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
				
				InitColumns(cols);
				SetVisible(false);
				SetEditable(1);
			}
		break;
		
		case 11:      //t3sheet1 init
			with(sheetObj){
				//		                (5, 4, 0, true);
				var HeadTitle="vvd|io_bnd_cd|cost_cd|inv_amt";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vvd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sum_basis",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				SetVisible(false);
				SetEditable(1);
			}
		break;
		
		case 12:      //vvd_check_hidden init
			with(sheetObj){
			
				//			              (8, 0, 0, true);
				var HeadTitle="STATUS|OFC_CTY|SO_SEQ|VVD_SEQ|VSL_CD|VOY_NO|DIR_CD";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd_ibflag",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_tml_so_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_tml_so_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_tml_so_vvd_list_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_skd_voy_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_skd_dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_atb_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				
				InitColumns(cols);
				SetSheetHeight(240);
				SetEditable(1);
		}
		break;
	}
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[1]);
    ComResizeSheet(sheetObjects[2]);
}

/**
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param {tab object}	tab_obj	tab object
 */
function setTabObject(tab_obj) {
    tabObjects[tabCnt++] = tab_obj;
}

/**
 * Initialization Tab 
 * @param(tabObj)  tab object 
 * @param(tabNo)   tab no
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
    if (document.form.tml_so_ofc_cty_cd.value == '' && document.form.tml_so_seq.value == '') {
        tabObj.SetTabDisable(1);
    } else {
        tabObj.SetTabDisable(0);
    }
    tabObj.SetSelectedIndex(0);
}

/**
 * Tab change event
 * @param(tabObj)  tab object 
 * @param(nItem)   item     
 */
function tab1_OnChange(tabObj, nItem) {
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
 * Validation check date format
 * @param {ojbect}	obj	object
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
            ComShowMessage('Issue date must be earlier than RCV date.'); //ComShowMessage('Issue date이 RCV date보다 작아야 합니다.');
            return false;
        }
    }
}

/*
 * Initialization Component
 * @param {String}	sFlag
 */
function setInitComponent(sFlag) { //alert("start setInitComponent");
    var formObj = document.form;
    var flag_value = false;
    
    if (sFlag == "Y") {
        flag_value = true;
    } else {
        flag_value = false;
    }
    
    for (var e = 0; e < formObj.elements.length; e++) {
        var el = formObj.elements[e];
        if (formObj.elements[e].type == "button" && formObj.elements[e].parentElement.className == "page_title") {
            // title disable 방지
        } else {
            ComEnableObject(el, false);
        }
    }
    if (sFlag == "Y") {
        ComEnableManyObjects(true, formObj.yd_cd, formObj.cost_ofc_cd, formObj.pay_vol_qty, formObj.ttl_inv_amt, formObj.iss_dt, formObj.vat_amt, formObj.rcv_dt, formObj.hld_flg, formObj.rtro_tml_inv_flg, formObj.err_inv_no );
        //                             formObj.rtro_tml_inv_flg,
        if (WHLD_TAX_READONLY_MODE == false) {
            ComEnableObject(formObj.whld_tax_amt, true);
        }
    }
    ComEnableManyObjects(true, formObj.vndr_seq, formObj.inv_no);
    formObj.cost_ofc_cd.readOnly = true;
    formObj.atb_dt.readOnly = true;  //2016-06-16 수정

    var oldTabIdx = tab1.GetSelectedIndex();
    tab1.SetTabDisable(1, !flag_value);
    tab1.SetTabDisable(2, !flag_value);
    tab1.SetSelectedIndex(oldTabIdx);
    sheetObjects[0].SetEditable(flag_value);
    sheetObjects[1].SetEditable(flag_value);
    sheetObjects[2].SetEditable(flag_value);
    comboObjects[0].SetEnable(flag_value);
    ComEnableObject(formObj.btn_pre_inquiry_cond, true);
    ComEnableObject(formObj.btn_retrieve, true);
    ComEnableObject(formObj.btn_new2, true);
    ComEnableObject(formObj.btn_new, true);
    ComEnableObject(formObj.btn_save, true);
    ComEnableObject(formObj.t1btng_clear, true);
    ComEnableObject(formObj.t1btng_todiscrepancy, true);
    //        ComEnableObject(formObj.t1btng_db_check, true);
    ComEnableObject(formObj.t1btng_getcntr, true);
    ComEnableObject(formObj.t1btng_save, true);
    ComEnableObject(formObj.t1btng_downexcel, true);
    ComEnableObject(formObj.t1btng_costcalc, true);
    ComEnableObject(formObj.btns_remarks, true);
    ComEnableObject(formObj.btng_plus, true);
    ComEnableObject(formObj.btng_minus, true);
    ComEnableObject(formObj.btng_back, true);
    ComEnableObject(formObj.btng_next, true);
    ComEnableObject(formObj.maxi, true);
    ComEnableObject(formObj.btn_vndr, true);
    ComEnableObject(formObj.btn_yard, true);
    ComEnableObject(formObj.btn_cost_ofc, true);
    ComEnableObject(formObj.btns_accumulate, true);
    ComEnableObject(formObj.btns_calendar1, true);
    ComEnableObject(formObj.btns_calendar2, true);

    ComEnableObject(formObj.t2btng_reverify, true);
    ComEnableObject(formObj.t2btng_clear, true);
    ComEnableObject(formObj.t2btng_verification, true);
    ComEnableObject(formObj.t2btng_reject, true);
    ComEnableObject(formObj.t2btng_downexcel, true);
    ComEnableObject(formObj.t2btng_print, true);

    ComEnableObject(formObj.t3btng_costCal, true);
    ComEnableObject(formObj.t3btng_clear, true);
    ComEnableObject(formObj.t3btng_rowadd, true);
    ComEnableObject(formObj.t3btng_rowdel, true);
    ComEnableObject(formObj.t3btng_save, true);
    ComEnableObject(formObj.t3btng_totalamount, true);
    ComEnableObject(formObj.t3btng_confirm, true);
}

/**
 * Sheet reset data
 */
function resetSheets() {
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
    sheetObjects[10].RemoveAll();
}

function validateAgmtCurrCD() {
//    var formObj = document.form;
//    if (ComIsNull(formObj.atb_dt.value)) {
//        return false;
//    }
//    tes_getInputValueInvoice('agmtCurrCd', SEARCH01, 'tml_inv_tp_cd|yd_cd|vndr_seq|atb_dt', '');
}

function isValidAgmtCurrCD() {
    //var formObj = document.form;
//    if (formObj.curr_cd.value == null || formObj.curr_cd.value.trim() == '') {
//        ComShowMessage(ComGetMsg('TES40039'));
//        return false;
//    }
//    if (formObj.curr_cd.value != main_hidden.GetCellValue(1, 'curr_cd')) {
//        ComShowMessage(ComGetMsg('TES40040'));
//        return false;
//    }
//    if (formObj.atb_dt.value == null || formObj.atb_dt.value.trim() == '') {
//        ComShowMessage(ComGetMsg('TES40036'));
//        return false;
//    }
//    if (formObj.atb_dt.value == null || formObj.atb_dt.value.trim() == '') {
//        ComShowMessage(ComGetMsg('TES40002', 'ATB Date'));
//        return false;
//    }
//    if (formObj.agmtCurrCd.value.trim() == formObj.curr_cd.value.trim()) {
//        return true;
//    } else {
//        ComShowMessage(ComGetMsg('TES40028', formObj.agmtCurrCd.value, formObj.curr_cd.value));
//        return false;
//    }
//    if (formObj.agmtCurrCd.value == null || formObj.agmtCurrCd.value.trim() == '') {
//        tes_getInputValueInvoice('agmtCurrCd', SEARCH01, 'tml_inv_tp_cd|yd_cd|vndr_seq|atb_dt', '');
//        ComShowMessage(ComGetMsg('TES40029'));
//        return false;
//    }
//    return false;
}

function validateAgmtSts() {
//    if (document.form.tml_inv_tp_cd.value == '' || document.form.yd_cd.value == '' || document.form.vndr_seq.value == '' || document.form.atb_dt.value == '') {
//        return false;
//    }
//    tes_getInputValueInvoice('agmtSts', SEARCH04, 'tml_inv_tp_cd|yd_cd|vndr_seq|atb_dt', '');
}

/** 
 * Validation Agreement Status
 *  
 * @return
 */
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
        ComShowMessage('Failed to read Agreement. \nPlease Retrieve again.');
        return false;
    }
    return true;
}

/**
 *  get Yard
 *  @param(rowArray)
 */
function getYard(rowArray) {
    var colArray = rowArray[0];
    document.all.yd_cd.value = colArray[3];
    document.all.yd_nm.value = colArray[4];
    document.all.yd_cd_hidden.value = colArray[3];
    if (colArray[3] != undefined && colArray[3] != null && colArray[3].trim() != '') {
        var rtnVal = getYdCdCostCdList(); // tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');   
        
        if(rtnVal.length > 0){
        	checkValidYardCode(rtnVal);
        }
        // tes_getInputValue('laneCode', SEARCH19, 'yd_cd', 'initLaneCode');
    }
    document.all.cost_ofc_cd.readOnly = false;
}

/**
 *  Validation check yard code
 */
function validateYardCode() {
    var formObj = document.form;
    if (formObj.yd_cd.value == null || formObj.yd_cd.value.trim() == '') {
        formObj.yd_cd_hidden.value = '';
        formObj.is_valid_yd_cd.value = '';
        return false;
    }
    if ((formObj.yd_cd_hidden.value == null || formObj.yd_cd_hidden.value.trim() == '') || formObj.yd_cd.value.trim() != formObj.yd_cd_hidden.value.trim()) {
        formObj.is_valid_yd_cd.value = '';
        // tes_getInputValue('laneCode', SEARCH19, 'yd_cd', 'initLaneCode');
        var rtnVal = getYdCdCostCdList(); // tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');   
        
        if(rtnVal.length > 0){
        	checkValidYardCode(rtnVal);
        }
    }
}

function getYardName() {
    var formObj = document.form;
    if (formObj.yd_cd.value == null || formObj.yd_cd.value.trim() == '') {
        return false;
    }
    doActionMainHidden(sheetObjects[3], formObj, IBSEARCH_ASYNC04);
}

/**
 * Verification, Discrepancy sheet Initialization LaneCode Combo
 *
 */
function initLaneCode(rtnSLanCd) {    
    if (rtnSLanCd != null && rtnSLanCd != "undefined") {
        sheetObjects[0].SetColProperty("lane_cd", { ComboText: rtnSLanCd + '|OTH', ComboCode: rtnSLanCd + '|OTH' });
        sheetObjects[1].SetColProperty("lane_cd", { ComboText: rtnSLanCd + '|OTH', ComboCode: rtnSLanCd + '|OTH' });
        sheetObjects[2].SetColProperty("lane_cd", { ComboText: rtnSLanCd + '|OTH', ComboCode: rtnSLanCd + '|OTH' });
    } else {
        sheetObjects[0].SetColProperty("lane_cd", { ComboText: 'OTH', ComboCode: 'OTH' });
        sheetObjects[1].SetColProperty("lane_cd", { ComboText: 'OTH', ComboCode: 'OTH' });
        sheetObjects[2].SetColProperty("lane_cd", { ComboText: 'OTH', ComboCode: 'OTH' });
    }
}

function initLaneCode2(rtnSLanCd) {     
    if (rtnSLanCd != null && rtnSLanCd != "undefined") {
        sheetObjects[0].SetColProperty("lane_cd", { ComboText: rtnSLanCd + '|OTH', ComboCode: rtnSLanCd + '|OTH' });
        sheetObjects[1].SetColProperty("lane_cd", { ComboText: rtnSLanCd + '|OTH', ComboCode: rtnSLanCd + '|OTH' });
        sheetObjects[2].SetColProperty("lane_cd", { ComboText: rtnSLanCd + '|OTH', ComboCode: rtnSLanCd + '|OTH' });
    } else {
        sheetObjects[0].SetColProperty("lane_cd", { ComboText: 'OTH', ComboCode: 'OTH' });
        sheetObjects[1].SetColProperty("lane_cd", { ComboText: 'OTH', ComboCode: 'OTH' });
        sheetObjects[2].SetColProperty("lane_cd", { ComboText: 'OTH', ComboCode: 'OTH' });
    }
    doActionIBSheet1(sheetObjects[0], document.form, IBSEARCH); // t1sheet1_OnSearchEnd
}

/**
 * Verification, Discrepancy sheet Initialization Sub Trade Combo
 *
 */
function initSubTrade(rtnSubTrdCd) { 
    if (rtnSubTrdCd != null && rtnSubTrdCd != "undefined") {        
        sheetObjects[0].SetColProperty("sub_trd_cd", { ComboText: ' |OTH|' + rtnSubTrdCd,  ComboCode: ' |O|' + rtnSubTrdCd });
        sheetObjects[1].SetColProperty("sub_trd_cd", { ComboText: ' |OTH|' + rtnSubTrdCd,  ComboCode: ' |O|' + rtnSubTrdCd });
        sheetObjects[2].SetColProperty("sub_trd_cd", { ComboText: ' |OTH|' + rtnSubTrdCd,  ComboCode: ' |O|' + rtnSubTrdCd });
    } else {
        sheetObjects[0].SetColProperty("sub_trd_cd", { ComboText: 'OTH', ComboCode: 'O' });
        sheetObjects[1].SetColProperty("sub_trd_cd", { ComboText: 'OTH', ComboCode: 'O' });
        sheetObjects[2].SetColProperty("sub_trd_cd", { ComboText: 'OTH', ComboCode: 'O' });
    }
}


/**
 * validation check YardCode
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
                //					if (formObj.yd_cd.value!=null && formObj.yd_cd.value.trim()!='' && formObj.yd_cd_hidden.value!=formObj.yd_cd.value)
                //					{
                //						if (sheetObjects[3].RowCount > 0 && formObj.yd_cd.value.trim()!=sheetObjects[3].CellValue(1,'yd_cd').trim()
                //						      &&(sheetObjects[4].RowCount > 0 || sheetObjects[7].RowCount > 0))
                //						{
                //							if (!confirm(ComGetMsg('TES40027')))
                //							{
                //								formObj.yd_cd.value = formObj.yd_cd_hidden.value;
                //								return false;
                //							} else {
                //								if(deleteContanerList("ALL")) gridSave();
                //							}
                //						}
                //					}
                tmp_yd_cd_hidden = formObj.yd_cd_hidden.value;
                formObj.yd_cd_hidden.value = formObj.yd_cd.value;
                //                    formObj.yd_nm.value=(tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');
                formObj.yd_chr_cd.value = (tmp[3] != undefined && tmp[3] != null ? tmp[3] : '');
                formObj.yd_fcty_tp_mrn_tml_flg.value = (tmp[4] != undefined && tmp[4] != null ? tmp[4] : '');
                formObj.yd_fcty_tp_cy_flg.value = (tmp[5] != undefined && tmp[5] != null ? tmp[5] : '');
                formObj.yd_fcty_tp_cfs_flg.value = (tmp[6] != undefined && tmp[6] != null ? tmp[6] : '');
                formObj.yd_fcty_tp_rail_rmp_flg.value = (tmp[7] != undefined && tmp[7] != null ? tmp[7] : '');
                formObj.yd_oshp_cd.value = (tmp[8] != undefined && tmp[8] != null ? tmp[8] : '');
                formObj.calcTerminalComboItems.value = (tmp[9] != undefined && tmp[9] != null ? tmp[9] : '');
                var tmp_yd_cd = formObj.yd_cd.value;
                var tmp2;
                var retval = '';
                tmp2 = tmp[9].split('|');
                for (var i = 0; tmp2 != null && i < tmp2.length; i++) {
                    //                        if (!(( tmp_yd_cd=='KRPUSYK' || tmp_yd_cd=='KRPUSYG' || 
                    //                        		tmp_yd_cd=='KRKANY4' || tmp_yd_cd=='KRPUSKC'
                    //                        		|| tmp_yd_cd=='JPTYOY1' || tmp_yd_cd=='JPOSAY1'
                    //                        	) && tmp2[i]=='SVXXJO')) {
                    retval += tmp2[i] + (i < tmp2.length - 1 ? '|' : '');
                    //                        }
                }
                formObj.calcTerminalComboItems.value = retval;
                var rtnOfcCd = "";
                if ((formObj.tml_so_ofc_cty_cd.value == '' && formObj.tml_so_seq.value == '') || formObj.yd_cd.value != tmp_yd_cd_hidden || formObj.cost_ofc_hidden.value != formObj.cost_ofc_cd.value) {                    
                	rtnOfcCd = getOfcCdByYardCd(); //tes_getInputValue('cost_ofc_cd', SEARCH02, 'yd_cd', 'setCostOfcReadOnlyFalse');
                    setCostOfcReadOnlyFalse(rtnOfcCd);
                } else {
                    setCostOfcReadOnlyFalse(rtnOfcCd);
                }
                if (sheetObjects[2].RowCount() > 0) {
                    setCalcTerminalManualCostCode(sheetObjects[2]);
                }
                // vndr_seq,yd_cd별 accm_seq,pay_vol_qty를 가져오기.
                sheetObjects[5].RemoveAll();
                doActionAccmHidden(sheetObjects[5], formObj, IBSEARCH);
            } else {
                ComShowMessage(ComGetMsg('TES21039'));
                formObj.is_valid_yd_cd.value = '';
                formObj.yd_cd_hidden.value = '';
                formObj.yd_nm.value = '';
            }
        } else {
            ComShowMessage(ComGetMsg('TES21039'));
            formObj.is_valid_yd_cd.value = '';
            formObj.yd_cd_hidden.value = '';
            formObj.yd_nm.value = '';
        }
    } else {
        ComShowMessage(ComGetMsg('TES21039'));
        formObj.is_valid_yd_cd.value = '';
        formObj.yd_cd_hidden.value = '';
        formObj.yd_nm.value = '';
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
 * Validation check vndr_seq
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

        //doActionMainHidden(sheetObjects[3], formObj, IBSEARCH_ASYNC05);

        //tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVndrCode');
    }
}

/**
 *  VndrCode Validation
 */
function checkValidVndrCode() {
    var formObj = document.form;
    var tmp = '';
    //ComShowMessage('is_valid_vndr_seq:'+formObj.is_valid_vndr_seq.value);
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
 *  Grid get Vender value
 *  @param(rowArray) 
 */
function getVender(rowArray) {
    var colArray = rowArray[0];
    //ComShowMessage(colArray);
    document.all.vndr_seq.value = colArray[2];
    document.all.vndr_seq_nm.value = colArray[4];
}

/**
 * get Grid Vender value
 *  @param {int}	rowArray	로우배열
 *  @param {int}	row 		셀의 row index
 *  @param {int}	col 		셀의 col index	
 */
function getVenderGrid(rowArray, row, col) {
    var colArray = rowArray[0];
    //ComShowMessage(colArray[2].substr(2,6));
    //ComShowMessage(row+" : "+ col);
    sheetObjects[2].SetCellValue(row, col, colArray[2]);
}

/**
 * Validation check CostOFC
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

/* Validation check CostOfc
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
                        //ComShowMessage(ComGetMsg('TES21036'));
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

/* get OfcCd
 * @param(rowArray )  rowArray
 */
function getOfcCd(rowArray) {
    var colArray = rowArray[0];
    document.all.cost_ofc_cd.value = (colArray[3] != undefined && colArray[3] != null ? colArray[3] : '');
}

/**
 *  set CostOfc
 */
function setCostOfcReadOnlyFalse(argOfcCd) {
    var formObj = document.form;   
    formObj.cost_ofc_cd.readOnly = false;    
    
    if(!tesIsEmpty(argOfcCd)){
    	formObj.cost_ofc_cd.value = argOfcCd;
    	formObj.cost_ofc_hidden.value = argOfcCd;
    }
}

/**
 * set Cost Calculation Combo Code
 * sheet : Cost Calculation Tab
 * @param {ibsheet}	sheet sheet
 * @param {String}	INIT	 INIT
 */
function setCalcTerminalManualCostCode(sheet, INIT) {
    var formObj = document.form;
    for (var i = 1; i <= sheet.RowCount(); i++) {
        if ((sheet.GetCellValue(i, 'calc_tp_cd') == 'M' || sheet.GetCellValue(i, 'calc_tp_cd') == 'S') && sheet.GetCellValue(i, 'lgs_cost_cd') == '') {
            org_sts = sheet.GetRowStatus(i);
            sheet.CellComboItem(i, 'lgs_cost_cd', {
                ComboText: formObj.calcTerminalComboItems.value,
                ComboCode: formObj.calcTerminalComboItems.value
            });
            sheet.SetCellValue(i, 'lgs_cost_cd', sheet.GetCellValue(i, 'lgs_cost_cd2'), 0);
            sheet.SetRowStatus(i, org_sts);
        }
    }
}

/**
 * get AtbDt
 * Call : VVD Onblur, Bnd Onchage
 * @param {object}	obj	object
 */
function getAtbDt(obj) { //alert("start getAtbDt");
    //	ComShowMessage("getAtbDt");
    var formObj = document.form;
    var vvd_hidden = sheetObjects[4];
    var vvd = formObj.vvd.value + formObj.io_bnd_cd.value;
    var tmp_date = '20' + formObj.vvd.value.substr(4, 4) + '01'; //공통 항차 일경우 : CNTC1607MM
    var atbDt;
    io_hidden = formObj.io_bnd_cd.value;
    //formObj.atb_dt.value = '';
    
    //atb_dt.RemoveAll(); //2016-06-16 수정
    initAtbDtComboItem(); //2016.07.13 Add
    //		alert(obj.value.length);
    if (obj == undefined || obj.value == null || obj.value.trim() == '') {
        return false;
    } else if (obj.value.length == 9 || obj.value.length == 1) {
        if (!fnChkEmptyObj(formObj.yd_cd)) return;
        if (!fnChkEmptyObj(formObj.vvd)) return;
        if (formObj.vvd.value.substr(0, 4) == 'CNTC') {
            if (formObj.vvd.value.substr(8, 1) != 'M') {
                ComShowMessage(ComGetMsg('TES40052', 'VVD'));
                //formObj.atb_dt.value = '';
                //atb_dt.RemoveAll(); //2016-06-16 수정
                initAtbDtComboItem(); //2016.07.13 Add
                formObj.page.value = '';
                return false;
            }
            var rtnSLanCd = getSLaneCd(); //tes_getInputValue('laneCode', SEARCH19, 'yd_cd|vvd', 'initLaneCode');
			if(rtnSLanCd.length > 0){
				initLaneCode(rtnSLanCd);
			}            
            
			//atbDt = 'B|' + atb_dt.GetSelectText() + '|'; //2016-06-16 수정
            //atbDt = atbDt.split('|');
            
            //2015.07.13 Add 공통 항차에서 구한 atbDt를 가지고 comboItem을 Make 한다.
            //2016.07.13 Add
            var tempAtbDt = get_Year(tmp_date) + '-' + get_Month(tmp_date) + '-' + ComGetLastDay(parseInt(get_Year(tmp_date), 10), parseInt(get_Month(tmp_date), 10));
            //var tmpAtdDt = atb_dt.GetSelectText();
            setMakeAtbDtComboItem("B", tempAtbDt, "", "" );//공통 항차에서 구한 atddt를 담는다.
            var atdDt = getAtbDtComboItem(0); //[0] : Type, [1] : ATB_DT, [2] : REV_YRMON, [3] : CALL_YD_IND_SEQ
           
            ComEnableObject(formObj.atb_dt, true);
            if (vvd_hidden.IsDataModified()) {
                for (var i = vvd_hidden.RowCount(); i > 0; i--) {
                    if (vvd_hidden.GetCellValue(i, 'vvd_ibflag') == 'I') {
                        vvd_hidden.RowDelete(i, false);
                    }
                }
            }
            if (vvd_hidden.FindText('vvd', vvd) < 0) {
                var row = vvd_hidden.DataInsert(-1);
                vvd_hidden.SetCellValue(row, 'vvd_vsl_cd'           , formObj.vvd.value.substr(0, 4));
                vvd_hidden.SetCellValue(row, 'vvd_skd_voy_no'       , formObj.vvd.value.substr(4, 4));
                vvd_hidden.SetCellValue(row, 'vvd_skd_dir_cd'       , formObj.vvd.value.substr(8, 1));
                vvd_hidden.SetCellValue(row, 'vvd_io_bnd_cd'        , formObj.io_bnd_cd.value);
                vvd_hidden.SetCellValue(row, 'vvd_atb_dt'           , atbDt[1]); //2015.07.13 Add
                vvd_hidden.SetCellValue(row, 'vvd'                  , formObj.vvd.value + formObj.io_bnd_cd.value);
                vvd_hidden.SetCellValue(row, 'vvd_type'             , atbDt[0]); //atbDt.substr(0,1);
                vvd_hidden.SetCellValue(row, 'rev_yrmon'            , atbDt[2]); //atbDt.substr(0,1);
                vvd_hidden.SetCellValue(row, 'vvd_call_yd_ind_seq'  , atbDt[3]); //2015.07.13 Add
                formObj.vvd_type.value                              = atbDt[0]; //atbDt.substr(0,1);
            }
            formObj.page.value = vvd_hidden.FindText('vvd', vvd) + ' / ' + vvd_hidden.RowCount();
            //var tempAtbDt = get_Year(tmp_date) + '-' + get_Month(tmp_date) + '-' + ComGetLastDay(parseInt(get_Year(tmp_date), 10), parseInt(get_Month(tmp_date), 10));
            
            //atb_dt.InsertItem(0, tempAtbDt, tempAtbDt);            
    		//atb_dt.SetSelectCode(0, true);
    		atb_dt.SetSelectIndex(0);//2015.07.13 Add
            formObj.atb_dt.readOnly = false;
        } else {
            doActionVVDHidden(vvd_hidden, formObj, IBSEARCH_ASYNC01);
        }
    } else {
        ComShowMessage(ComGetMsg('TES21047'));
        //formObj.atb_dt.value = '';
        //atb_dt.RemoveAll(); //2016-06-16 수정
        initAtbDtComboItem(); //2016.07.13 Add
        return false;
    }
}

/** validation check invoice
 * 
 * @return
 */
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

/** validation check invoice code
 * 
 * @return
 */
function checkValidErrInvNo() {
    var formObj = document.form;
    if (formObj.is_valid_err_inv_no.value != undefined && formObj.is_valid_err_inv_no.value != null && formObj.is_valid_err_inv_no.value.trim() == 'Y') {
        sheetObjects[3].SetCellValue(1, 'err_inv_no', formObj.err_inv_no.value);
    } else {
        formObj.is_valid_err_inv_no.value = '';
        ComShowMessage(ComGetMsg('TES40058', 'ERR INV.NO'));
    }
}

/**
 * retrieve invice all data
 */
function retrieveAll() {
    var formObj = document.form;
    var main_hidden = sheetObjects[3];
    var sheetObj1 = sheetObjects[0];
    resetSheets();
    if (!fnChkEmptyObj(formObj.vndr_seq)) return false;
    if (!fnChkEmptyObj(formObj.inv_no)) return false;
    formObj.vvd.value = '';
    //formObj.atb_dt.value = '';   
    //atb_dt.RemoveAll(); //2016-06-16 수정
    initAtbDtComboItem(); //2016.07.13 Add
    document.getElementById("costCalcFlg").value = "";
    doActionMainHidden(main_hidden, formObj, IBSEARCH);
}

/**
 * Marine Terminal Invoice
 * @param {ibsheet}	sheetObj	sheet object	 
 */
function isMRInvoice(sheetObj) {
    if (sheetObj.GetCellValue(1, "tml_inv_tp_cd") == "ON") {
        ComShowMessage(ComGetMsg('TES21029'));
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
    } else if (sheetObj.GetCellValue(1, "tml_inv_tp_cd") == "TM") {
        return true;
    }
}

/**
 * Cost Calculation Tab Mandatory Item Check & Validation
 */
function checkCostCalculation() {
    var sheetObject2 = sheetObjects[2];
    var formObj = document.form;
    for (var i = sheetObject2.HeaderRows(); i < sheetObject2.HeaderRows() + sheetObject2.RowCount(); i++) {
        if ((sheetObject2.GetCellValue(i, 'calc_tp_cd') == 'M' || sheetObject2.GetCellValue(i, 'calc_tp_cd') == 'S') && sheetObject2.GetCellValue(i, 'lgs_cost_cd') == '') {
            ComShowMessage(ComGetMsg('TES40018'));
            return false;
        }

        if ((sheetObject2.GetCellValue(i, 'calc_tp_cd') == 'M' || sheetObject2.GetCellValue(i, 'calc_tp_cd') == 'S') && sheetObject2.GetCellValue(i, 'calc_rmk') == '') {
            ComShowMessage("Please,  must input remarks."); //
            return false;
        }

        if (sheetObject2.GetCellValue(i, 'vsl_cd') == '' || sheetObject2.GetCellValue(i, 'skd_voy_no') == '' || sheetObject2.GetCellValue(i, 'skd_dir_cd') == '' || sheetObject2.GetCellValue(i, 'atb_dt') == '') {
            ComShowMessage('[CASE 4] The system will retrieve the invoice data automatically due to the error to call the related information. ' +
                '\nPlease input the VVD data again for invoice auditing after completion of retrieve.');
            retrieveAll();
            return false;
        }
        //             if ((formObj.yd_cd.value=='KRPUSKC' 
        //               || formObj.yd_cd.value=='JPTYOY1' || formObj.yd_cd.value=='JPOSAY1'
        //             	)
        //               &&(sheetObject2.CellValue(i,'tml_crr_cd')==null || sheetObject2.CellValue(i,'tml_crr_cd')==''))
        //             {
        //                 ComShowMessage('Carrier code is mandatory at '+formObj.yd_cd.value);
        //                 return false;
        //             }
        //             if ( ( (formObj.yd_cd.value=='KRPUSYK' || 
        //            		 formObj.yd_cd.value=='KRPUSYG' ||
        //           			 formObj.yd_cd.value=='KRKANY4'
        //            		)
        //                && formObj.inv_ofc_cd.value == 'SELTOB' )
        //                && ( sheetObject2.CellValue(i,'tml_crr_cd')==null || sheetObject2.CellValue(i,'tml_crr_cd')=='') )
        //             {
        //                 ComShowMessage('[SELTOB] Carrier code is mandatory at '+formObj.yd_cd.value);
        //                 return false;
        //             }
        /*
if(sheetObject2.GetCellValue(i,"cntr_tpsz_cd") == ""){
			    ComShowMessage("Not Selected Type/Size");
			    return false;
			 }
			 */
        if (sheetObject2.GetCellValue(i, 'lgs_cost_cd') == 'SVXXJO') {
            /*
            if( (sheetObject2.GetCellValue(i,'rvis_vol_qty') ==''||sheetObject2.GetCellValue(i,'rvis_vol_qty') == 0)
            || (sheetObject2.GetCellValue(i,'n3pty_flg') == ''||sheetObject2.GetCellValue(i,'n3pty_flg') != 'Y')|| sheetObject2.GetCellValue(i,'tml_crr_cd') == '')
                             {
                                 ComShowMessage(ComGetMsg('TES40022'));
            					 //msgs['TES40022'] = 'Revised Vol / 3rd Party / Carrier are mandatory items on SVXXJO.' ;
                                 return false;
                             }
            */
            if (sheetObject2.GetCellValue(i, 'tml_crr_cd') == '') {
                ComShowMessage('Carrier are mandatory items on SVXXJO.');
                return false;
            }
            //				 if(sheetObject2.CellValue(i,'inv_amt') <= 0){
            //                     ComShowMessage('Amount should be bigger than 0 when you have 3rd Party(SVXXJO).');
            //                     return false;
            //                 }
        }
        if (sheetObject2.GetCellValue(i, 'n3pty_flg') == 'Y' && sheetObject2.GetCellValue(i, 'lgs_cost_cd') != 'SVXXJO' && sheetObject2.GetCellValue(i, 'ctrt_rt') <= 0) {
            ComShowMessage('Contract Rate should be bigger than 0 when you have 3rd Party');
            return false;
        }
        if ((sheetObject2.GetCellValue(i, 'curr_cd') != formObj.curr_cd.value) && (sheetObject2.GetCellValue(i, 'inv_xch_rt') == 0) && (sheetObject2.GetCellValue(i, 'calc_tp_cd') == 'A')) {
            ComShowMessage('There is no exchange rate at the suitable column.');
            return false;
        }
    }
    return true;
}

/**
 * Header Search Event
 * @param {ibsheet}	sheetObj	IBsheet Object
 * */
function main_hidden_OnSearchEnd(sheetObj) { //doActionMainHidden
    var formObj = document.form;
    if (isMRInvoice(sheetObj) == false) {
        return false;
    }
    
    if (formObj.f_cmd.value == MODIFY01) {
        mainHidden2Form(sheetObj, formObj);
        ComShowMessage('Confirmed!');
        setInitComponent('N');        
        // tabObjects[0].SetEnable(1);
        tabObjects[0].SetSelectedIndex(1);
        return false;
    }
    
    if (formObj.f_cmd.value == MODIFY02) {
        mainHidden2Form(sheetObj, formObj);
        ComShowMessage('Rejected!');
        setInitComponent('N');
        //		    tabObjects[0].SetEnable(1);
        tabObjects[0].SetSelectedIndex(1);
        return false;
    }
    
    if (sheetObj.RowCount() == 1) {
        if (formObj.inv_ofc_cd.value == '' || formObj.inv_ofc_cd.value == null || formObj.inv_ofc_cd.value == undefined) {
            ComShowMessage('No Inv OFC data is found in the session');
            return false;
        }
        
        if (formObj.inv_ofc_cd.value != sheetObj.GetCellValue(1, 'inv_ofc_cd')) {
            ComShowMessage(ComGetMsg('TES21050'));
            return false;
        }

        if (sheetObj.GetCellValue(1, 'tml_inv_rjct_sts_cd').trim() == 'RJ') {
            ComShowMessage("This is Rejected Invoice.");
            return false;
        }

        if (sheetObj.GetCellValue(1, 'tml_inv_sts_cd').trim() == 'A') {
            ComShowMessage(ComGetMsg('TES23040'));
            setInitComponent("N");
            return false;
        } else if (sheetObj.GetCellValue(1, 'tml_inv_sts_cd').trim() == 'P') {
            ComShowMessage(ComGetMsg('TES23041'));
            setInitComponent("N");
            return false;
        } else if (sheetObj.GetCellValue(1, 'tml_inv_sts_cd').trim() == 'D') {
            ComShowMessage('Paid Invoice!');
            setInitComponent("N");
            return false;
        } else if (sheetObj.GetCellValue(1, 'tml_inv_sts_cd').trim() == 'C') {
            if (ComShowConfirm(ComGetMsg('TES22029'))) { //'Confirmed Invoice 입니다. 수정하시겠습니까?')
                sheetObj.SetCellValue(1, 'tml_inv_sts_cd', 'R');
                sheetObj.SetCellValue(1, 'tml_inv_sts_nm', 'RC');
                if (sheetObj.GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'RJ') {
                    //sheetObj.CellValue(1,'tml_inv_rjct_sts_cd') = 'RL';
                    //AP_IF_DT = NULL,  HPC_CRE_FLG = NULL, LEA_CRE_FLG = NULL
                    //AP_CXL_DT = NULL, HPC_CXL_FLG = NULL, LEA_CXL_FLG = NULL
                    //AP_PAY_DT = NULL, HPC_DELT_FLG = NULL
                    doActionMainHidden(sheetObj, formObj, IBSEARCH_ASYNC03);
                } else {
                    doActionMainHidden(sheetObj, formObj, IBSAVE);
                }
            } else {
                setInitComponent("N");
                //		            tabObjects[0].SetEnable(1);
                tabObjects[0].SetSelectedIndex(1);
                return false;
            }
        }

        //validateVndrSeq();
        setInitComponent("Y");
        ComEnableManyObjects(false, formObj.vndr_seq, formObj.inv_no);
        
        if (formObj.f_cmd.value == ADD) {
            ComEnableManyObjects(true, formObj.vvd, formObj.io_bnd_cd);
            formObj.vvd.focus();
        }
        
        tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
        mainHidden2Form(sheetObj, formObj);
        
        var rtnVal = getYdCdCostCdList(); // tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');           
        if(rtnVal.length > 0){
        	checkValidYardCode(rtnVal);
        }      
        
        var rtnSubTrdCd = getSubTrdCd(); //tes_getInputValue('subTrade', SEARCH22, '', 'initSubTrade');        
        if(rtnSubTrdCd.length > 0){
        	initSubTrade(rtnSubTrdCd);
        }    
        
    	var costCdFtrRmk = formObj.cost_cd_ftr_rmk.value;
        getAgmtCostCdList(1, 75, 150, costCdFtrRmk); // tes_getComboItem('agmt_lgs_cost_cd', 2, SEARCHLIST10, '', 'vndr_seq|yd_cd|agmt_ftr_inv_tp_cd|atb_dt', 'setAgmtCostCd');

    } else if (sheetObj.RowCount() > 1) {
        ComShowMessage(ComGetMsg('TES21032')); // [ERR] multi header data are retrieved.
    } else {
        if (ComShowConfirm(ComGetMsg('TES40031'))) { // Invoice number does not exist.\n\n Would you like to create it as a new invoice?
            setInitComponent("Y");
            formObj.yd_cd.focus();
        } else {
            setInitComponent("N");
        }
    }
}

/**
 * Header Save end event
 * @param {ibsheet}	sheetObj	IBsheet object
 * */
function main_hidden_OnSaveEnd(sheetObj) { // doActionMainHidden
    //     if ( sheetObj.RowCount < 1 ) {
    //         formObj   = document.form;
    //         doActionMainHidden(sheetObj, formObj, IBSEARCH);         
    //     } else {
    if (sheetObj.RowCount() == 1) {
        mainHidden2Form(sheetObj, document.form);
    }
    if (document.form.f_cmd.value == MODIFY01) {
        mainHidden2Form(sheetObj, document.form);
        var errMsg = sheetObj.GetEtcData("successFlg");
        if (errMsg != "Fail") {
            ComShowMessage('Confirmed!');
        }
        setInitComponent("N");
        //		    tabObjects[0].SetEnable(1);
        tabObjects[0].SetSelectedIndex(1);
        return false;
    }
    //     }
}

/**
 * main_hidden Sheet form copy
 * @param {ibsheet}	sheetObj	sheetObj
 * @param {form}	formObj		formObj
 */
function mainHidden2Form(sheetObj, formObj) { //alert("start mainHidden2Form");
    formObj.tml_so_ofc_cty_cd.value = sheetObj.GetCellValue(1, 'tml_so_ofc_cty_cd');
    formObj.tml_so_seq.value = sheetObj.GetCellValue(1, 'tml_so_seq');
    formObj.cost_ofc_cd.value = sheetObj.GetCellValue(1, 'cost_ofc_cd');
    formObj.cost_ofc_hidden.value = sheetObj.GetCellValue(1, 'cost_ofc_cd');
    formObj.inv_no.value = sheetObj.GetCellValue(1, 'inv_no');
    formObj.vndr_seq.value = sheetObj.GetCellValue(1, 'vndr_seq');
    formObj.yd_cd.value = sheetObj.GetCellValue(1, 'yd_cd');
    formObj.yd_cd_hidden.value = sheetObj.GetCellValue(1, 'yd_cd');
    formObj.yd_nm.value = sheetObj.GetCellValue(1, 'yd_nm');
    //formObj.curr_cd.Code=sheetObj.GetCellValue(1, 'curr_cd' );
    //formObj.curr_cd.text=sheetObj.GetCellValue(1, 'curr_cd' );
    comboObjects[0].SetSelectCode(sheetObj.GetCellValue(1, 'curr_cd'));
    comboObjects[0].SetSelectText(sheetObj.GetCellValue(1, 'curr_cd'));
    formObj.curr_cd_tmp.value = sheetObj.GetCellValue(1, 'curr_cd');
    resetSheetDataProperty(formObj.curr_cd.value);
    formObj.hld_rmk.value = sheetObj.GetCellValue(1, 'hld_rmk');
    formObj.iss_dt.value = sheetObj.GetCellValue(1, 'iss_dt');
    formObj.rcv_dt.value = sheetObj.GetCellValue(1, 'rcv_dt');
    formObj.tml_inv_rjct_sts_cd.value = sheetObj.GetCellValue(1, 'tml_inv_rjct_sts_cd');

    formObj.cost_cd_ftr_rmk.value = sheetObj.GetCellValue(1, 'cost_cd_ftr_rmk');

    if (sheetObj.GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'NL') {
        formObj.tml_inv_rjct_sts_nm.value = 'Normal';
    } else if (sheetObj.GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'RJ') {
        formObj.tml_inv_rjct_sts_nm.value = 'Rejected';
    } else if (sheetObj.GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'RL') {
        formObj.tml_inv_rjct_sts_nm.value = 'Reject Lifted';
    }
    //        formObj.tml_inv_rjct_sts_cd.value   = sheetObj.CellValue(1, 'tml_inv_rjct_sts_cd');
    formObj.tml_inv_sts_cd.value = sheetObj.GetCellValue(1, 'tml_inv_sts_cd');
    formObj.tml_inv_sts_nm.value = sheetObj.GetCellValue(1, 'tml_inv_sts_nm');
    formObj.ttl_inv_amt.value = tes_chkAmtFmt(sheetObj.GetCellValue(1, 'ttl_inv_amt'), sheetObj.GetCellValue(1, 'curr_cd'));
    formObj.vat_amt.value = tes_chkAmtFmt(sheetObj.GetCellValue(1, 'vat_amt'), sheetObj.GetCellValue(1, 'curr_cd'));
    formObj.whld_tax_amt.value = tes_chkAmtFmt(sheetObj.GetCellValue(1, 'whld_tax_amt'), sheetObj.GetCellValue(1, 'curr_cd'));
    //        formObj.total_amt.value   			= tes_chkAmtFmt((Number(sheetObj.CellValue(1, 'ttl_inv_amt' ))
    //                                                             + Number(sheetObj.CellValue(1, 'vat_amt'     ))
    //                                                             - Number(sheetObj.CellValue(1, 'whld_tax_amt'))), formObj.curr_cd.Code);
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
}

/** search end event
 * 
 * @param {ibsheet} sheetObj	IBsheet object
 * @return
 */
function vvd_check_hidden_OnSearchEnd(sheetObj) { // doActionVVDHidden
    var vvd = sheetObj.GetCellValue(1, 'vvd_vsl_cd') + sheetObj.GetCellValue(1, 'vvd_skd_voy_no') + sheetObj.GetCellValue(1, 'vvd_skd_dir_cd');
    //alert("sheetObj.RowCount:"+sheetObj.RowCount);
    if (sheetObj.RowCount() == 1) {
        //                if (confirm('Same VVD('+vvd+') exists.\n\n You should seperate amount by each VVD.\n\n Do you want to split the amount by VVD ?')){
        if (confirm('Same Vessel Voyage No. with different Direction(VVD:' + vvd + ') exists.\n\nYou need to seperate amount by each VVD.\n\nDo you want to split the amount by VVD ?')) {
            var url_str = 'ESD_TES_1003Pop.screen';
            url_str = url_str + '?tml_so_ofc_cty_cd=' + document.form.tml_so_ofc_cty_cd.value;
            url_str = url_str + '&tml_so_seq=' + document.form.tml_so_seq.value;
            url_str = url_str + '&yd_cd=' + document.form.yd_cd.value;
            url_str = url_str + '&bound_lgs_cost_cd=' + document.form.bound_lgs_cost_cd.value;
            url_str = url_str + '&vvd_vsl_cd=' + document.form.vvd.value.substr(0, 4);
            url_str = url_str + '&vvd_skd_voy_no=' + document.form.vvd.value.substr(4, 4);
            url_str = url_str + '&vvd_skd_dir_cd=' + document.form.vvd.value.substr(8, 1);
            url_str = url_str + '&vvd=' + document.form.vvd.value;
            url_str = url_str + '&vvd_atb_dt=' + atb_dt.GetSelectText(); //2016-06-16 수정
            url_str = url_str + '&vvd_io_bnd_cd=' + document.form.io_bnd_cd.value;
            url_str = url_str + '&vvd_vsl_cd2=' + sheetObj.GetCellValue(1, 'vvd_vsl_cd');
            url_str = url_str + '&vvd_skd_voy_no2=' + sheetObj.GetCellValue(1, 'vvd_skd_voy_no');
            url_str = url_str + '&vvd_skd_dir_cd2=' + sheetObj.GetCellValue(1, 'vvd_skd_dir_cd');
            url_str = url_str + '&vvd2=' + vvd;
            url_str = url_str + '&vvd_atb_dt2=' + sheetObj.GetCellValue(1, 'vvd_atb_dt');
            url_str = url_str + '&vvd_io_bnd_cd2=' + "";
            ComOpenWindow(url_str, window, "dialogWidth:800px; dialogHeight:425px; help:no; status:no; resizable:yes;", true);
        }
    }
}


/**
 * search end event
 * @param {ibsheet}	sheetObj	IBsheet object 
 */
function vvd_hidden_OnSearchEnd(sheetObj) { // main_hidden_OnSearchEnd
    var formObj = document.form;
    if (formObj.f_cmd.value == SEARCH11) {
        
        //2016.07.13 Add
        gAtbDtComboItems = sheetObj.GetEtcData("etcxml");
    	var atbDt = gAtbDtComboItems.split('#');
    	
    	for (var i = 0; i < atbDt.length; i++) {
    		var tempArr = atbDt[i].split('|');
    		
    		//[0] : Type, [1] : ATB_DT, [2] : REV_YRMON, [3] : CALL_YD_IND_SEQ
    		atb_dt.InsertItem(i, tempArr[1], tempArr[1]);
    		//atb_dt.SetSelectCode(0, true);
    	}
    	
    	if(gAtbDtComboItems != ""){
    	    atb_dt.SetSelectIndex(0); //2016.07.13 Add 첫벗째 Item을 선택. OnChange에서 callYdIndSeq의 값을 담는다.
    	}
    	//alert("::::::::::::::::"+atb_dt.GetSelectCode()+":::::::::::::::"+atb_dt.GetSelectText());
    	
        if (atbDt == undefined || atbDt == null || atbDt == '') {
            ComShowMessage(ComGetMsg('TES40052', 'VVD'));
            //formObj.atb_dt.value = '';
			//atb_dt.RemoveAll(); //2016-06-16 수정
			initAtbDtComboItem(); //2016.07.13 Add
            formObj.page.value = '';
            return false;
        } else {
            
            if (sheetObj.IsDataModified()) {
                for (var i = sheetObj.RowCount(); i > 0; i--) {
                    if (sheetObj.GetCellValue(i, 'vvd_ibflag') == 'I') {
                        sheetObj.RowDelete(i, false); //2016.07.20 최종 VVD + IO BNd 데이타만 존재 하게 하는 구문. Save 전에 등록된 데이타는 삭제처리함.
                    }
                }
            }
            if (sheetObj.FindText('vvd', formObj.vvd.value + io_hidden) < 0) {
                var row = sheetObj.DataInsert(-1);
                
                //var tmArr = atb_dt.GetSelectCode().split('|');//2016.07.
                
                //2016.07.13 Add
                var selIdx = atb_dt.GetSelectIndex();
                var tmArr = getAtbDtComboItem(selIdx) //[0] : Type, [1] : ATB_DT, [2] : REV_YRMON, [3] : CALL_YD_IND_SEQ;
                
                sheetObj.SetCellValue(row, 'vvd_vsl_cd'             , formObj.vvd.value.substr(0, 4));
                sheetObj.SetCellValue(row, 'vvd_skd_voy_no'         , formObj.vvd.value.substr(4, 4));
                sheetObj.SetCellValue(row, 'vvd_skd_dir_cd'         , formObj.vvd.value.substr(8, 1));
                sheetObj.SetCellValue(row, 'vvd_io_bnd_cd'          , formObj.io_bnd_cd.value);
                sheetObj.SetCellValue(row, 'vvd_atb_dt'             , tmArr[1]);
                sheetObj.SetCellValue(row, 'vvd'                    , formObj.vvd.value + formObj.io_bnd_cd.value);
                sheetObj.SetCellValue(row, 'vvd_type'               , tmArr[0]); //atbDt.substr(0,1);
                sheetObj.SetCellValue(row, 'rev_yrmon'              , tmArr[2]); //atbDt.substr(0,1);
                sheetObj.SetCellValue(row, 'vvd_call_yd_ind_seq'    , tmArr[3]); //2016.07.13 Add
                formObj.vvd_type.value = tmArr[0]; //atbDt.substr(0,1);
            }
            
//            if (atbDt[1].length == 0) {} else {
//                formObj.atb_dt.value = atbDt[1]; //atbDt.substr(1,10);
//            }
        }
        
        formObj.agmtSts.value = getAgmtStatusCd(); // validateAgmtSts();
        
    } else { //alert("SEARCH11 diff");
        if (sheetObj.RowCount() == 0 && formObj.tml_so_ofc_cty_cd.value != '' && formObj.tml_so_seq.value != '') {
            ComEnableManyObjects(true, formObj.vvd, formObj.io_bnd_cd);
        }
        if (sheetObj.RowCount() > 0 && ComIsNull(formObj.vvd.value) && ComIsNull(formObj.atb_dt.value)) {
            if (formObj.vvd.value == '' && sheetObj.GetCellValue(1, 'vvd_atb_dt') != '' && formObj.tml_so_seq.value != '') {
                formObj.vvd.value = sheetObj.GetCellValue(1, "vvd_vsl_cd") + sheetObj.GetCellValue(1, "vvd_skd_voy_no") + sheetObj.GetCellValue(1, "vvd_skd_dir_cd");
                formObj.io_bnd_cd.value = sheetObj.GetCellValue(1, "vvd_io_bnd_cd");
                //formObj.atb_dt.value = sheetObj.GetCellValue(1, "vvd_atb_dt");
                
                //atb_dt.RemoveAll(); //2016-06-16 수정
                initAtbDtComboItemByVvdHidden(sheetObj, 1);
                //atb_dt.SetSelectCode(0, true);
                
                formObj.vvd_type.value = sheetObj.GetCellValue(1, "vvd_type");
                io_hidden = sheetObj.GetCellValue(1, "vvd_io_bnd_cd");
                
                if (formObj.yd_cd.value != '' && formObj.vvd.value != '') {
                    var rtnSLanCd = getSLaneCd(); //tes_getInputValue('laneCode', SEARCH19, 'yd_cd|vvd', 'initLaneCode2');
					if(rtnSLanCd.length > 0){
						initLaneCode2(rtnSLanCd);
					}	
                }
                
                if (sheetObjects[3].RowCount() == 1 && sheetObjects[3].GetCellValue(1, 'tml_inv_sts_cd') != 'C') {
                	formObj.agmtSts.value = getAgmtStatusCd(); // validateAgmtSts();
                }
                //  doActionIBSheet1(sheetObjects[0], formObj, IBSEARCH);
            }
        }
    }
		
    if (sheetObj.RowCount() > 0) {
        if (formObj.yd_cd.value != '' && formObj.vvd.value != '') {            
            var rtnSLanCd = getSLaneCd(); //tes_getInputValue('laneCode', SEARCH19, 'yd_cd|vvd', 'initLaneCode');
			if(rtnSLanCd.length > 0){
				initLaneCode(rtnSLanCd);
			}	
        }
        formObj.page.value = sheetObj.FindText('vvd', formObj.vvd.value + formObj.io_bnd_cd.value) + ' / ' + sheetObj.RowCount();
    }
	
	var costCdFtrRmk = formObj.cost_cd_ftr_rmk.value;
    getAgmtCostCdList(1, 75, 150, costCdFtrRmk); // tes_getComboItem('agmt_lgs_cost_cd', 2, SEARCHLIST10, '', 'vndr_seq|yd_cd|agmt_ftr_inv_tp_cd|atb_dt', 'setAgmtCostCd');    

    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
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
 * t1sheet1 Search end event
 * @param {ibsheet}	sheetObj	IBsheet object
 */
function t1sheet1_OnSearchEnd(sheetObj) { // doActionIBSheet1
    var formObj = document.form;
    formObj.sht_01_ttl.value = 0;
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
    //        formObj.sht_01_DW.value=0;
    //        formObj.sht_01_DX.value=0;
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
    formObj.sht_01_ttl.value = sheetObjects[0].RowCount();
    for (var i = 1; i <= sheetObj.RowCount(); i++) {
        with(formObj) {
            if (sheetObj.GetCellValue(i, "cntr_sty_cd") == 'F') {
                sht_01_full.value++;
            } else if (sheetObj.GetCellValue(i, "cntr_sty_cd") == 'M') {
                sht_01_mt.value++;
            }
            if (sheetObj.GetCellValue(i, "locl_ts_ind_cd") == 'T') {
                sht_01_ts_same_yard.value++;
            }
            try {
                eval('sht_01_' + sheetObj.GetCellValue(i, "cntr_tpsz_cd")).value++;
            } catch (e) {
                //ComShowMessage(e); 
            }
        }
    }
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        if (sheetObj.GetCellValue(i, 'modi_flg') == 'Y') {
            //toSheetObj1.InitCellProperty(Row, "chk", dtCheckBox);
            sheetObj.SetCellEditable(i, 'chk', 1);
            sheetObj.SetCellValue(i, 'chk', 0);
        }
        //        	sheetObj.SetCellValue(i,'lane_cd',sheetObj.GetCellValue(i,'lane_cd2'),0);
        //			if(sheetObj.CellValue(i,'dscr_ind_cd')=='CO'){
        //			    sheetObj.ToolTipText(i,'dscr_ind_cd') = 'Verification';
        //			}else 
        if (sheetObj.GetCellValue(i, 'dscr_ind_cd') == 'HO') {
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
        //			if(sheetObj.CellValue(i,'dscr_ind_cd') != 'CO' && sheetObj.CellValue(i,'dscr_ind_cd') != 'HO' ){
        if (sheetObj.GetCellValue(i, 'dscr_ind_cd') != '' && sheetObj.GetCellValue(i, 'dscr_ind_cd') != 'HO') {
            sheetObj.SetCellBackColor(i, 'dscr_ind_cd', "#FF0000");
            sheetObj.SetCellFontColor(i, 'dscr_ind_cd', "#FFFF00");
        } else {
            sheetObj.SetCellBackColor(i, 'dscr_ind_cd', "#FFFFFF");
            //			    sheetObj.CellFontColor(i,'dscr_ind_cd') = "#000000";
        }
    }
    if (sheetObjects[4].RowCount() > 0 && (sheetObjects[0].RowCount() > 0 || sheetObjects[1].RowCount() > 0 || sheetObjects[2].RowCount() > 0)) {
        ComEnableManyObjects(false, formObj.vvd, formObj.io_bnd_cd);
    }
}

/** t1 sheet save end event
 * 
 * @param {String} ErrMsg	err message
 * @return
 */
function t1sheet1_OnSaveEnd(ErrMsg) {
    var formObj = document.form;
    ComEnableManyObjects(false, formObj.vvd, formObj.io_bnd_cd);
    
    var costCdFtrRmk = formObj.cost_cd_ftr_rmk.value;
    getAgmtCostCdList(1, 75, 150, costCdFtrRmk); // tes_getComboItem('agmt_lgs_cost_cd', 2, SEARCHLIST10, '', 'vndr_seq|yd_cd|agmt_ftr_inv_tp_cd|atb_dt', 'setAgmtCostCd');
    
    //        ComShowMessage('Container List Saved!');
}

/** t2 sheet search end event
 * 
 * @param {ibsheet} sheetObj	IBsheet object
 * @return
 */
function t2sheet1_OnSearchEnd(sheetObj) {
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        sheetObj.SetCellValue(i, 'chk', 0);
        if (document.form.yd_cd.value.substring(0, 2) == 'US' && (sheetObj.GetCellValue(i, 'dscr_ind_cd') == 'HD' || sheetObj.GetCellValue(i, 'dscr_ind_cd') == 'DB')) {
            sheetObj.SetCellEditable(i, 'chk', 0);
        }
        //			sheetObj.SetCellValue(i,'lane_cd',sheetObj.GetCellValue(i,'lane_cd2'),0);
        //			if(sheetObj.CellValue(i,'dscr_dtl_ind_cd') == 'F'){
        //			    sheetObj.CellBackColor(i,'cntr_sty_cd') = "#FF9999";
        //			}else if(sheetObj.CellValue(i,'dscr_dtl_ind_cd') == 'I'){
        //			    sheetObj.CellBackColor(i,'io_bnd_cd') = "#FF9999";
        //			}
    }
}

/** t3 sheet search end event
 * 
 * @param {ibsheet} sheetObj	sheet object
 * @return
 */
function t3sheet1_OnSearchEnd(sheetObj) {
    var formObj = document.form;
    var cur_sts;
    var accm_vol = 0;
    tmp_seq = 0;
    if (formObj.f_cmd.value == SEARCH04) {
        for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
            if (sheetObj.GetCellValue(i, 'calc_tp_cd') == 'A') {
                sheetObj.SetRowStatus(i, 'I');
            }
            if (sheetObj.GetCellValue(i, 'accm_chk') == 'Y') {
                accm_vol = parseFloat(accm_vol) + parseFloat(sheetObj.GetCellValue(i, 'rvis_vol_qty'));
            }
        }
        if (formObj.accm_seq.value != '') {
            formObj.pay_vol_qty.value = ComAddComma(parseInt(tes_deleteComma(formObj.pay_vol_qty.value)) + parseInt(Math.round(accm_vol)));
        }
    }
    
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        sheetObj.SetCellValue(i, "calc_rmk", ComToString(sheetObj.GetCellValue(i, "calc_rmk")), 0);

        if (sheetObj.GetCellValue(i, 'calc_tp_cd') == 'M') {
            cur_sts = sheetObj.GetRowStatus(i);
            sheetObj.CellComboItem(i, 'lgs_cost_cd', { ComboText: formObj.calcTerminalComboItems.value, ComboCode: formObj.calcTerminalComboItems.value });
            sheetObj.SetCellValue(i, 'lgs_cost_cd', sheetObj.GetCellValue(i, 'lgs_cost_cd2'), 0);
            setShtCellsEditable(sheetObj, i, 'lgs_cost_cd|cntr_tpsz_cd|dcgo_ind_cd|tml_wrk_dy_cd|ioc_cd|lane_cd|vol_tr_ut_cd|ctrt_rt|calc_vol_qty|inv_xch_rt|inv_amt|rc_flg|tml_trns_mod_cd', 'Y');
            sheetObj.SetRowStatus(i, cur_sts);

        } else if (sheetObj.GetCellValue(i, "calc_tp_cd") == "S") {
            //요청이 오면 넣어준다
            cur_sts = sheetObj.GetRowStatus(i);
            sheetObj.CellComboItem(i, 'lgs_cost_cd', { ComboText: formObj.calcTerminalComboItems.value, ComboCode: formObj.calcTerminalComboItems.value });
            sheetObj.SetCellValue(i, 'lgs_cost_cd', sheetObj.GetCellValue(i, 'lgs_cost_cd2'), 0);
            // setShtCellsEditable( sheetObj, i, 'cntr_tpsz_cd|rvis_vol_qty|rf_mntr_dys', 'Y', 'EXCEPTION');
            setShtCellsEditable(sheetObj, i, 'lgs_cost_cd|cntr_tpsz_cd|dcgo_ind_cd|tml_wrk_dy_cd|ioc_cd|lane_cd|vol_tr_ut_cd|ctrt_rt|calc_vol_qty|inv_xch_rt|inv_amt|rc_flg|tml_trns_mod_cd', 'Y', 'EXCEPTION');
            sheetObj.SetRowStatus(i, cur_sts);
        }

        sheetObj.SetCellValue(i, 'lane_cd', sheetObj.GetCellValue(i, 'lane_cd2'), 0);
        cur_sts = sheetObj.GetRowStatus(i);
        sheetObj.SetCellValue(i, 'page_rows', tmp_seq++, 0);
        sheetObj.SetRowStatus(i, cur_sts);
        
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
        } else if (sheetObj.GetCellValue(i, 'vol_tr_ut_cd') == 'W') {
            sheetObj.SetToolTipText(i, 'vol_tr_ut_cd', 'Tonne');
        }
        
        if (formObj.curr_cd.value != sheetObj.GetCellValue(i, 'curr_cd') && sheetObj.GetCellValue(i, 'curr_cd') != '') {
            setShtCellsEditable(sheetObj, i, 'inv_xch_rt', 'Y', 'EXCEPTION');
        }
        //            if(sheetObj.CellValue(i,'lgs_cost_cd') == 'SVXXJO' && sheetObj.CellValue(i,'n3pty_flg') == 'Y'){
        //                sheetObj.CellEditable(i,'inv_amt') = false;
        //                sheetObj.CellEditable(i,'ctrt_rt') = false;
        //                sheetObj.CellEditable(i,'calc_vol_qty') = false;
        //                sheetObj.CellEditable(i,'rvis_vol_qty') = false;
        //            }else{
        //                sheetObj.CellEditable(i,'inv_amt') = true;
        //                sheetObj.CellEditable(i,'ctrt_rt') = true;
        //                sheetObj.CellEditable(i,'calc_vol_qty') = true;
        //                sheetObj.CellEditable(i,'rvis_vol_qty') = true;
        //            }
    }
    
    if (formObj.vvd.value != '' && (sheetObjects[0].RowCount() > 0 || sheetObjects[1].RowCount() > 0 || sheetObjects[2].RowCount() > 0)) {
        ComEnableManyObjects(false, formObj.vvd, formObj.io_bnd_cd);
    }
    
    checkTPBdataEditable(sheetObj);
}

/** t3 sheet1 save end event
 * 
 * @param sheetObj
 * @return
 */
function t3sheet1_OnSaveEnd(sheetObj) {
    sheetObjects[6].RemoveAll();
    sheetObjects[7].RemoveAll();
    checkTPBdataEditable(sheetObj);
}

/**
 * 
 * @param vndr_seq
 * @param lgs_cost_cd
 * @param rf_mntr_dys
 * @return
 */
function calc_rf_mntr_dys(vndr_seq, lgs_cost_cd, rf_mntr_dys) {
    try {
        if ((vndr_seq != null && vndr_seq != undefined && vndr_seq == '180020') &&
            (lgs_cost_cd != null && lgs_cost_cd != undefined && lgs_cost_cd == 'TMRFMO')) {
            if (rf_mntr_dys != null && rf_mntr_dys.trim() != '' && rf_mntr_dys != undefined && !isNaN(rf_mntr_dys)) {
                return rf_mntr_dys;
            }
        }
    } catch (e) {
        return 1;
    }
    return 1;
}

/** t3 sheet1 change event
 * 
 * @param sheetObj		sheet Object
 * @param row			row
 * @param col			col
 * @param value			value
 * @return
 */
function t3sheet1_OnChange(sheetObj, row, col, value) { //alert("start t3sheet1_OnChange");
    var rvis_qty = sheetObj.GetCellValue(row, 'rvis_vol_qty');
    var rate = sheetObj.GetCellValue(row, 'ctrt_rt');
    var inv_xch_rt = sheetObj.GetCellValue(row, 'inv_xch_rt');
    var n3rd_hidden = sheetObjects[7];
    var rvis_hidden = sheetObjects[6];
    var formObj = document.form;
    var sCurrCd = formObj.curr_cd.value;
    //var sSheetCurrCd = sheetObj.GetCellValue(row, 'curr_cd');
    
    if (sheetObj.ColSaveName(col) == "inv_amt") {
        if (sheetObj.GetCellValue(row, 'lgs_cost_cd') == 'SVXXJO' && sheetObj.GetCellValue(row, 'n3pty_flg') == 'Y') {
            if (sheetObj.GetCellValue(row, 'inv_amt') > 0) {
                var tmp_row = -1
                for (var i = n3rd_hidden.HeaderRows(); i < n3rd_hidden.HeaderRows() + n3rd_hidden.RowCount(); i++) {
                    if (sheetObj.GetCellValue(row, 'page_rows') == n3rd_hidden.GetCellValue(i, 'n3rd_page_rows')) {
                        tmp_row = i
                    }
                }
                if (tmp_row == -1) {
                    formObj.tmp_dtl_seq.value = sheetObj.GetCellValue(row, 'tml_so_dtl_seq');
                    formObj.tmp_if_amt.value = sheetObj.GetCellValue(row, 'inv_amt');
                    formObj.tmp_calc_vol_qty.value = sheetObj.GetCellValue(row, 'calc_vol_qty');
                    formObj.tmp_rvis_vol_qty.value = sheetObj.GetCellValue(row, 'rvis_vol_qty');
                    formObj.tmp_ctrt_rt.value = sheetObj.GetCellValue(row, 'ctrt_rt');
                    formObj.tmp_inv_xch_rt.value = sheetObj.GetCellValue(row, 'inv_xch_rt');
                    doActionN3rdHidden(sheetObjects[8], formObj, IBSAVE);
                    ComShowMessage('Correceted amount has been applied to the 3rd Party.');
                } else {
                    n3rd_hidden.SetCellValue(tmp_row, 'n3rd_if_amt', sheetObj.GetCellValue(row, col));
                    ComShowMessage('Correceted amount has been applied to the 3rd Party.');
                }
            } else {
                ComShowMessage('Amount shoule be bigger than 0 when you have 3rd Party(SVXXJO).');
                //                    sheetObj.ReturnCellData(row,'inv_amt');
            }
        }
        ShowCalculatedAmountByVVD();
        
    } else if (sheetObj.ColSaveName(col) == "rvis_vol_qty") {        
        var nInvAmt = tes_round(parseFloat(rvis_qty) * parseFloat(rate) * parseFloat(inv_xch_rt) * parseFloat(calc_rf_mntr_dys(document.form.vndr_seq.value, sheetObj.GetCellValue(row, 'lgs_cost_cd'), sheetObj.GetCellValue(row, 'rf_mntr_dys'))), 2);
        
        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
        }
        
        sheetObj.SetCellValue(row, 'inv_amt', nInvAmt);
        
    } else if (sheetObj.ColSaveName(col) == "ctrt_rt") {
        if (sheetObj.GetCellValue(row, 'n3pty_flg') == 'Y' && sheetObj.GetCellValue(row, 'lgs_cost_cd') != 'SVXXJO' && sheetObj.GetCellValue(row, 'ctrt_rt') <= 0) {
            ComShowMessage('Contract rate shoule be bigger than 0 when you have 3rd Party.');
            //                sheetObj.ReturnCellData(row,'ctrt_rt');
        }
        
        var nInvAmt = tes_round(parseFloat(rvis_qty) * parseFloat(rate) * parseFloat(inv_xch_rt) * parseFloat(calc_rf_mntr_dys(document.form.vndr_seq.value, sheetObj.GetCellValue(row, 'lgs_cost_cd'), sheetObj.GetCellValue(row, 'rf_mntr_dys'))), 2);
        
        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
        }
        
        sheetObj.SetCellValue(row, 'inv_amt', nInvAmt);
    } else if (sheetObj.ColSaveName(col) == 'calc_vol_qty') {
        if (sheetObj.GetCellValue(row, 'calc_tp_cd') == 'M' || sheetObj.GetCellValue(row, 'calc_tp_cd') == 'S') {
            sheetObj.SetCellValue(row, 'rvis_vol_qty', sheetObj.GetCellValue(row, 'calc_vol_qty'));
        }
    } else if (sheetObj.ColSaveName(col) == 'lgs_cost_cd') {
        if (sheetObj.GetCellValue(row, 'calc_tp_cd') == 'M') {
            sheetObj.SetCellValue(row, 'tml_trns_mod_cd', '');
            if (sheetObj.GetCellValue(row, 'lgs_cost_cd') == 'SVLDTS' || sheetObj.GetCellValue(row, 'lgs_cost_cd') == 'TPNDTS' || sheetObj.GetCellValue(row, 'lgs_cost_cd') == 'TMNDTS') {
                sheetObj.CellComboItem(row, 'tml_trns_mod_cd', {
                    ComboText: "|" + ts_trns_mod_cdText,
                    ComboCode: "|" + ts_trns_mod_cdCode
                });
            } else if (sheetObj.GetCellValue(row, 'lgs_cost_cd') == 'TMNDFL' || sheetObj.GetCellValue(row, 'lgs_cost_cd') == 'TMNDMT' || sheetObj.GetCellValue(row, 'lgs_cost_cd') == 'SVLDFL' || sheetObj.GetCellValue(row, 'lgs_cost_cd') == 'SVLDMT' || sheetObj.GetCellValue(row, 'lgs_cost_cd') == 'TPNDFL' || sheetObj.GetCellValue(row, 'lgs_cost_cd') == 'TPNDMT') {
                sheetObj.CellComboItem(row, 'tml_trns_mod_cd', {
                    ComboText: "|" + lc_trns_mod_cdText,
                    ComboCode: "|" + lc_trns_mod_cdCode
                });
            } else {
                sheetObj.CellComboItem(row, 'tml_trns_mod_cd', {
                    ComboText: "|" + tml_trns_mod_cdText,
                    ComboCode: "|" + tml_trns_mod_cdCode
                });
            }
        }
        //            if(sheetObj.CellValue(row,'tml_so_dtl_seq').trim() !='' && sheetObj.CellValue(row,'lgs_cost_cd').trim() == 'TMRFGO'){
        //            	if(sheetObj.CellValue(row,'lgs_cost_cd').trim() == sheetObj.CellSearchValue(row,'lgs_cost_cd').trim()){
        //            		openMGSet(row);
        //            	}else{
        //            		ComShowMessage("save sheet...!!");
        //            	}
        //            }
    } else if (sheetObj.ColSaveName(col) == 'inv_xch_rt') {
        if (sheetObj.GetCellValue(row, 'inv_xch_rt') == 0) {
            var nInvAmt = sheetObj.GetCellValue(row, 'rvis_vol_qty') * sheetObj.GetCellValue(row, 'ctrt_rt') * calc_rf_mntr_dys(document.form.vndr_seq.value, sheetObj.GetCellValue(row, 'lgs_cost_cd'), sheetObj.GetCellValue(row, 'rf_mntr_dys'));
        
	        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
	        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
	        }
            
            if (sheetObj.GetCellValue(row, 'calc_tp_cd') == 'A') {
                //        			sheetObj.SetCellValue(row,'inv_amt',sheetObj.GetCellValue(row,'calc_amt'));
                sheetObj.SetCellValue(row, 'inv_amt', nInvAmt);
            } else if (sheetObj.GetCellValue(row, 'calc_tp_cd') == 'M'|| sheetObj.GetCellValue(row, 'calc_tp_cd') == 'S') {
                sheetObj.SetCellValue(row, 'inv_amt', nInvAmt);
            }
        } else {
            sheetObj.SetCellValue(row, 'inv_xch_rt', Math.abs(sheetObj.GetCellValue(row, 'inv_xch_rt')));
            
            var nInvAmt = tes_round(sheetObj.GetCellValue(row, 'rvis_vol_qty') * sheetObj.GetCellValue(row, 'ctrt_rt') * sheetObj.GetCellValue(row, 'inv_xch_rt') * calc_rf_mntr_dys(document.form.vndr_seq.value, sheetObj.GetCellValue(row, 'lgs_cost_cd'), sheetObj.GetCellValue(row, 'rf_mntr_dys')), 2);
        
	        if(sCurrCd == "CLP" || sCurrCd == "DJF" || sCurrCd == "IDR" || sCurrCd == "VND" || sCurrCd == "VUV" || sCurrCd == "XAF" || sCurrCd == "XPF"){
	        	nInvAmt = Math.round(nInvAmt); //2016-05-16 수정
	        }
	        
            if (sheetObj.GetCellValue(row, 'calc_tp_cd') == 'A') {
                //            		sheetObj.SetCellValue(row,'inv_amt', tes_round(sheetObj.GetCellValue(row, 'inv_xch_rt') * sheetObj.GetCellValue(row,'calc_amt'), 2));
                sheetObj.SetCellValue(row, 'inv_amt', nInvAmt);
            } else if (sheetObj.GetCellValue(row, 'calc_tp_cd') == 'M' || sheetObj.GetCellValue(row, 'calc_tp_cd') == 'S') {
                sheetObj.SetCellValue(row, 'inv_amt', nInvAmt);
            }
        }
        //        }else if(sheetObj.ColSaveName(col) == 'n3pty_flg'){
        //            if(sheetObj.CellValue(row,'n3pty_flg') == 'Y'){
        //                sheetObj.CellEditable(row,'inv_amt') = false;
        //                sheetObj.CellEditable(row,'ctrt_rt') = false;
        //                sheetObj.CellEditable(row,'calc_vol_qty') = false;
        //                sheetObj.CellEditable(row,'rvis_vol_qty') = false;
        //                sheetObj.CellEditable(row,'lgs_cost_cd') = false;
        //            }else{
        //                sheetObj.CellEditable(row,'inv_amt') = true;
        //                sheetObj.CellEditable(row,'ctrt_rt') = true;
        //                sheetObj.CellEditable(row,'calc_vol_qty') = true;
        //                sheetObj.CellEditable(row,'rvis_vol_qty') = true;
        //                sheetObj.CellEditable(row,'lgs_cost_cd') = true;
        //            }
        // cntr_tpsz_cd, dcgo_clss_cd, tml_wrk_dy_cd, ioc_cd, lane_ce, tml_crr_cd
    } else if (sheetObj.ColSaveName(col) == 'cntr_tpsz_cd' || sheetObj.ColSaveName(col) == 'dcgo_ind_cd' || sheetObj.ColSaveName(col) == 'tml_wrk_dy_cd' || sheetObj.ColSaveName(col) == 'ioc_cd' || sheetObj.ColSaveName(col) == 'rc_flg' || sheetObj.ColSaveName(col) == 'tml_trns_mod_cd' || sheetObj.ColSaveName(col) == 'lane_cd' || sheetObj.ColSaveName(col) == 'tml_crr_cd') {
        for (var i = n3rd_hidden.HeaderRows(); i < n3rd_hidden.HeaderRows() + n3rd_hidden.RowCount(); i++) {
            if (sheetObj.GetCellValue(row, 'page_rows') == n3rd_hidden.GetCellValue(i, 'n3rd_page_rows')) {
                n3rd_hidden.SetCellValue(i, 'n3rd_' + sheetObj.ColSaveName(col), sheetObj.GetCellValue(row, col), 0);
            }
        }
        for (var i = rvis_hidden.HeaderRows(); i < rvis_hidden.HeaderRows() + rvis_hidden.RowCount(); i++) {
            if (sheetObj.GetCellValue(row, 'page_rows') == rvis_hidden.GetCellValue(i, 'rvis_page_rows')) {
                rvis_hidden.SetCellValue(i, 'rvis_' + sheetObj.ColSaveName(col), sheetObj.GetCellValue(row, col), 0);
            }
        }

        if (sheetObj.ColSaveName(col) == 'cntr_tpsz_cd' && sheetObj.GetCellValue(row, 'cntr_tpsz_cd') != '' && CostCdValidForCalcTpSz(sheetObj.GetCellValue(row, 'lgs_cost_cd'), sheetObj.GetCellValue(row, 'cntr_tpsz_cd')) == false && (sheetObj.GetCellValue(row, 'vol_tr_ut_cd') == "C" || sheetObj.GetCellValue(row, 'vol_tr_ut_cd') == "")) {
            ComShowMessage("Reefer EQ should be selected fot your cost code");
            sheetObj.SetCellValue(row, 'cntr_tpsz_cd', '');
        }
    }
}

/**
 * t3 sheet click event
 * @param(sheetObj) sheet Object
 * @param(row) 		row
 * @param(col) 		col
 * @param(value) 	value
 */
function t3sheet1_OnClick(sheetObj, row, col, value) {
    if (sheetObj.ColSaveName(col) == "lgs_cost_cd") {
        if (sheetObj.GetCellValue(row, 'n3pty_flg') == 'Y') {
            ComShowMessage('You cannot edit cost code when you have 3rd Party.');
        }
    }
}

/**
 * Cost Calculation Sheet popup Event 
 * @param {ibsheet}	sheetObj	sheet object
 * @param {String}	row			row
 * @param {String}	col			col
 */
function t3sheet1_OnPopupClick(sheetObj, row, col) {
    var formObj = document.form;
    var rvis_vol_qty = 0;
    if (sheetObj.GetCellValue(row, "tml_so_dtl_seq") == null || sheetObj.GetCellValue(row, "tml_so_dtl_seq") == '') {
        ComShowMessage('Save Cost Calculation before proceeding');
        return false;
    }
    if (sheetObj.GetCellValue(row, "inv_amt") != sheetObj.CellSearchValue(row, "inv_amt")) {
        ComShowMessage('Amount has been changed. Save Cost Calculation before proceeding');
        return false;
    }
    if (sheetObj.ColSaveName(col) == "n3pty_flg") {
        if ((sheetObj.GetCellValue(row, 'lgs_cost_cd') == "SVXXJO" && sheetObj.GetCellValue(row, 'inv_amt') <= 0)) {
            ComShowMessage('Invoice amount should be bigger than 0 to insert 3rd Party.');
            return false;
            /*
}else if(sheetObj.GetCellValue(row,'lgs_cost_cd')!="SVXXJO" && sheetObj.GetCellValue(row,'ctrt_rt')<=0){
		        ComShowMessage('Contract rate should be bigger than 0 to insert 3rd Party.');
		        return false;
				*/
        }
        if (sheetObj.GetCellValue(row, "lgs_cost_cd") != "TMXXDC") {
            var url_str = "ESD_TES_9232Pop.screen"; // ESD_TES_9232.jsp
            url_str += "?tml_so_ofc_cty_cd=" + formObj.tml_so_ofc_cty_cd.value;
            url_str += "&tml_so_seq=" + formObj.tml_so_seq.value;
            url_str += "&inv_ofc_cd=" + formObj.inv_ofc_cd.value;
            url_str += "&vndr_seq=" + formObj.vndr_seq.value;
            url_str += "&yd_cd=" + formObj.yd_cd.value;
            url_str += "&inv_no=" + encodeURIComponent(formObj.inv_no.value);
            url_str += "&curr_cd=" + formObj.curr_cd.value;
            url_str += "&vvd=" + formObj.vvd.value;
            url_str += "&tml_inv_tp_cd=" + formObj.tml_inv_tp_cd.value; //sheetObjects[3].GetCellValue(row,"tml_inv_tp_cd"); //main
            url_str += "&calc_cost_grp_cd=" + sheetObj.GetCellValue(row, "calc_cost_grp_cd");
            url_str += "&calc_tp_cd=" + sheetObj.GetCellValue(row, "calc_tp_cd");
            url_str += "&lgs_cost_cd=" + sheetObj.GetCellValue(row, "lgs_cost_cd");
            url_str += "&cntr_tpsz_cd=" + sheetObj.GetCellValue(row, "cntr_tpsz_cd");
            url_str += "&dcgo_ind_cd=" + sheetObj.GetCellValue(row, "dcgo_ind_cd");
            url_str += "&tml_wrk_dy_cd=" + sheetObj.GetCellValue(row, "tml_wrk_dy_cd");
            url_str += "&tml_trns_mod_cd=" + sheetObj.GetCellValue(row, "tml_trns_mod_cd");
            url_str += "&io_bnd_cd=" + sheetObj.GetCellValue(row, "io_bnd_cd");
            url_str += "&ioc_cd=" + sheetObj.GetCellValue(row, "ioc_cd");
            url_str += "&lane_cd=" + sheetObj.GetCellValue(row, "lane_cd2");
            url_str += "&cal_vol=" + sheetObj.GetCellValue(row, "calc_vol_qty");
            url_str += "&fm_tr_vol_val=" + sheetObj.GetCellValue(row, "fm_tr_vol_val");
            url_str += "&to_tr_vol_val=" + sheetObj.GetCellValue(row, "to_tr_vol_val");
            url_str += "&tml_so_dtl_seq=" + sheetObj.GetCellValue(row, "tml_so_dtl_seq");
            url_str += "&rvis_vol_qty=" + sheetObj.GetCellValue(row, "rvis_vol_qty");;
            url_str += "&acct_cd=" + sheetObj.GetCellValue(row, "acct_cd");
            url_str += "&inv_amt=" + sheetObj.GetCellValue(row, "inv_amt");
            url_str += "&ctrt_rt=" + sheetObj.GetCellValue(row, "ctrt_rt");
            url_str += "&inv_xch_rt=" + sheetObj.GetCellValue(row, "inv_xch_rt");
            url_str += "&tml_crr_cd=" + sheetObj.GetCellValue(row, "tml_crr_cd");
            url_str += "&n3rd_page_rows=" + sheetObj.GetCellValue(row, "page_rows");
            url_str += "&err_inv_no=" + formObj.err_inv_no.value;
            url_str += "&opener_row=" + row;
            ComOpenWindow(url_str, window, "dialogWidth:820px;dialogHeight:700px;help:no;status:no;resizable:yes;", true);
        }
    } else if (sheetObj.ColSaveName(col) == "rvis_vol_qty") {
        if (sheetObj.GetCellValue(row, "lgs_cost_cd") == "") {
            ComShowMessage(ComGetMsg('TES21045')); //ComShowMessage("Not Selected Cost Code");
            return false;
        }
        if (sheetObj.GetCellValue(row, "cntr_tpsz_cd") == "") {
            ComShowMessage("Not Selected Type/Size");
            return false;
        }
        if (sheetObj.GetCellValue(row, "lgs_cost_cd") == 'SVXXJO') {
            ComShowMessage(ComGetMsg('TES40021'));
            return false;
        }
        if (sheetObj.GetCellValue(row, "lgs_cost_cd") != "TMXXDC" && sheetObj.GetCellValue(row, "calc_tp_cd") == "A") {
            var url_str = "ESD_TES_9032Pop.screen";
            url_str += "?tml_so_ofc_cty_cd=" + formObj.tml_so_ofc_cty_cd.value;
            url_str += "&tml_so_seq=" + formObj.tml_so_seq.value;
            url_str += "&vndr_seq=" + formObj.vndr_seq.value;
            url_str += "&yd_cd=" + formObj.yd_cd.value;
            url_str += "&vvd=" + formObj.vvd.value;
            url_str += "&lgs_cost_cd=" + sheetObj.GetCellValue(row, "lgs_cost_cd");
            url_str += "&cntr_tpsz_cd=" + sheetObj.GetCellValue(row, "cntr_tpsz_cd");
            url_str += "&io_bnd_cd=" + sheetObj.GetCellValue(row, "io_bnd_cd");
            url_str += "&dcgo_ind_cd=" + sheetObj.GetCellValue(row, "dcgo_ind_cd");
            url_str += "&ioc_cd=" + sheetObj.GetCellValue(row, "ioc_cd");
            url_str += "&lane_cd=" + sheetObj.GetCellValue(row, "lane_cd2");
            url_str += "&tml_wrk_dy_cd=" + sheetObj.GetCellValue(row, "tml_wrk_dy_cd");
            url_str += "&tml_trns_mod_cd=" + sheetObj.GetCellValue(row, "tml_trns_mod_cd");
            url_str += "&cal_vol=" + sheetObj.GetCellValue(row, "calc_vol_qty");
            url_str += "&fm_tr_vol_val=" + sheetObj.GetCellValue(row, "fm_tr_vol_val");
            url_str += "&to_tr_vol_val=" + sheetObj.GetCellValue(row, "to_tr_vol_val");
            url_str += "&rvis_vol_qty=" + sheetObj.GetCellValue(row, "rvis_vol_qty");
            url_str += "&vol_tr_ut_cd=" + sheetObj.GetCellValue(row, "vol_tr_ut_cd");
            url_str += "&calc_tp_cd=" + sheetObj.GetCellValue(row, "calc_tp_cd");
            url_str += "&cntr_sty_cd=" + sheetObj.GetCellValue(row, "cntr_sty_cd");
            url_str += "&tml_so_dtl_seq=" + sheetObj.GetCellValue(row, "tml_so_dtl_seq");
            url_str += "&ctrt_rt=" + sheetObj.GetCellValue(row, "ctrt_rt");
            url_str += "&page_rows=" + sheetObj.GetCellValue(row, "page_rows");
            url_str += "&tml_crr_cd=" + sheetObj.GetCellValue(row, "tml_crr_cd");
            url_str += "&opener_row=" + row;
            url_str += "&sub_trd_cd=" + sheetObj.GetCellValue(row, "sub_trd_cd");
            url_str += "&rc_flg=" + sheetObj.GetCellValue(row, "rc_flg");
            ComOpenWindow(url_str, window, "dialogWidth:550px;dialogHeight:450px;help:no;status:no;resizable:yes;", true);
        } else if (sheetObj.GetCellValue(row, "lgs_cost_cd") != "TMXXDC" && (sheetObj.GetCellValue(row, "calc_tp_cd") == "M" || sheetObj.GetCellValue(row, "calc_tp_cd") == "S")) {

            formObj.temp_lgs_cost_cd.value = sheetObj.GetCellValue(row, "lgs_cost_cd");
            doActionRvisHidden(sheetObjects[8], formObj, IBSEARCH);
            var divCDValue = sheetObjects[8].GetEtcData("etcxml");
            if (divCDValue == "RH") {
                var url_str = "ESD_TES_9190.screen";
                url_str += "?tml_so_ofc_cty_cd=" + formObj.tml_so_ofc_cty_cd.value;
                url_str += "&tml_so_seq=" + formObj.tml_so_seq.value;
                url_str += "&tml_so_dtl_seq=" + sheetObj.GetCellValue(row, "tml_so_dtl_seq");
                url_str += "&vvd=" + formObj.vvd.value;
                url_str += "&yd_cd=" + formObj.yd_cd.value;
                url_str += "&lgs_cost_cd=" + sheetObj.GetCellValue(row, "lgs_cost_cd");
                url_str += "&cntr_tpsz_cd=" + sheetObj.GetCellValue(row, "cntr_tpsz_cd");
                url_str += "&io_bnd_cd=" + sheetObj.GetCellValue(row, "io_bnd_cd");
                url_str += "&dcgo_clss_cd=" + sheetObj.GetCellValue(row, "dcgo_ind_cd");
                url_str += "&ioc_cd=" + sheetObj.GetCellValue(row, "ioc_cd");
                url_str += "&lane_cd=" + sheetObj.GetCellValue(row, "lane_cd");
                url_str += "&tml_wrk_dy_cd=" + sheetObj.GetCellValue(row, "tml_wrk_dy_cd");
                url_str += "&vol_tr_ut_cd=" + sheetObj.GetCellValue(row, "vol_tr_ut_cd");
                url_str += "&rh_vol_qty=" + sheetObj.GetCellValue(row, "rvis_vol_qty");
                url_str += "&ctrt_rt=" + sheetObj.GetCellValue(row, "ctrt_rt");
                url_str += "&page_rows=" + sheetObj.GetCellValue(row, "page_rows");
                url_str += "&opener_row=" + row;
                url_str += "&sub_trd_cd=" + sheetObj.GetCellValue(row, "sub_trd_cd");
                url_str += "&rc_flg=" + sheetObj.GetCellValue(row, "rc_flg");
                ComOpenWindow(url_str, window, "dialogWidth:550px;dialogHeight:450px;help:no;status:no;resizable:yes;", true);
            } else {
                var url_str = "ESD_TES_9032Pop.screen";
                url_str += "?tml_so_ofc_cty_cd=" + formObj.tml_so_ofc_cty_cd.value;
                url_str += "&tml_so_seq=" + formObj.tml_so_seq.value;
                url_str += "&tml_so_dtl_seq=" + sheetObj.GetCellValue(row, "tml_so_dtl_seq");
                url_str += "&vndr_seq=" + formObj.vndr_seq.value;
                url_str += "&yd_cd=" + formObj.yd_cd.value;
                url_str += "&vvd=" + formObj.vvd.value;
                url_str += "&lgs_cost_cd=" + sheetObj.GetCellValue(row, "lgs_cost_cd");
                url_str += "&cntr_tpsz_cd=" + sheetObj.GetCellValue(row, "cntr_tpsz_cd");
                url_str += "&io_bnd_cd=" + sheetObj.GetCellValue(row, "io_bnd_cd");
                url_str += "&dcgo_ind_cd=" + sheetObj.GetCellValue(row, "dcgo_ind_cd");
                url_str += "&ioc_cd=" + sheetObj.GetCellValue(row, "ioc_cd");
                url_str += "&lane_cd=" + sheetObj.GetCellValue(row, "lane_cd");
                url_str += "&tml_wrk_dy_cd=" + sheetObj.GetCellValue(row, "tml_wrk_dy_cd");
                url_str += "&tml_trns_mod_cd=" + sheetObj.GetCellValue(row, "tml_trns_mod_cd");
                url_str += "&cal_vol=" + sheetObj.GetCellValue(row, "calc_vol_qty");
                url_str += "&fm_tr_vol_val=" + sheetObj.GetCellValue(row, "fm_tr_vol_val");
                url_str += "&to_tr_vol_val=" + sheetObj.GetCellValue(row, "to_tr_vol_val");
                url_str += "&rvis_div=" + divCDValue;
                url_str += "&rvis_vol_qty=" + sheetObj.GetCellValue(row, "rvis_vol_qty");
                url_str += "&calc_tp_cd=" + sheetObj.GetCellValue(row, "calc_tp_cd");
                url_str += "&opener_row=" + row;
                url_str += "&tml_so_dtl_seq=" + sheetObj.GetCellValue(row, "tml_so_dtl_seq");
                url_str += "&ctrt_rt=" + sheetObj.GetCellValue(row, "ctrt_rt");
                url_str += "&page_rows=" + sheetObj.GetCellValue(row, "page_rows");
                url_str += "&tml_crr_cd=" + sheetObj.GetCellValue(row, "tml_crr_cd");
                url_str += "&sub_trd_cd=" + sheetObj.GetCellValue(row, "sub_trd_cd");
                url_str += "&rc_flg=" + sheetObj.GetCellValue(row, "rc_flg");
                ComOpenWindow(url_str, window, "dialogWidth:550px;dialogHeight:450px;help:no;status:no;resizable:yes;", true);
            }
        }
    }
}

/** search end event
 * 
 * @param sheetObj
 * @return
 */
function total_hidden_OnSearchEnd(sheetObj) {
    ShowCalculatedAmountByVVD();
}

/** pay_vol_qty, accm_seq 
 * 
 * @param (sheetObj) sheet object
 * @return
 */
function accm_hidden_OnSearchEnd(sheetObj) {
    var formObj = document.form;
    if (sheetObj.RowCount() > 0) {
        formObj.pay_vol_qty.value = addComma(sheetObj.GetCellValue(1, 'pay_vol_qty'));
        formObj.accm_seq.value = sheetObj.GetCellValue(1, 'accm_seq');
    }
}

/** setShtCellsEditable2
 * 
 * @param sheetObj
 * @param rownum
 * @param colnms
 * @param to_sts
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

/** check TPB data GetEditable()
 * 
 * @param sheet
 * @return
 */
function checkTPBdataEditable(sheet) {
    for (var i = sheet.HeaderRows(); sheet != null && i < (sheet.HeaderRows() + sheet.RowCount()); i++) {
        if (sheet.GetCellValue(i, "calc_tp_cd") == "M" || sheet.GetCellValue(i, "calc_tp_cd") == "S") {
            if (sheet.GetCellValue(i, 'n3pty_flg') != null && sheet.GetCellValue(i, 'n3pty_flg').trim() == 'Y') {
                setShtCellsEditable2(sheet, i, 'calc_vol_qty|rvis_vol_qty|ctrt_rt|inv_xch_rt|inv_amt', 'N');
            }
        }
    }
}

/**  add Comma
 * 
 * @param src
 * @return
 */
function addComma(src) {
    var src = String(src);
    if (src == null || ComTrim(src) == '') {
        return '';
    }
    var re = /(-?\d+)(\d{3})/;
    while (re.test(src)) {
        src = src.replace(re, "$1,$2");
    }
    return src;
}

/**
 * Verification, Discrepancy
 * (cntr_status : 'CO'/'DC'
 *  modi_flg    : 'Y'/''   )
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
 * Verification, Discrepancy, CostCalculation tab data clear
 */
function listClear() {
    var formObj = document.form;
    var sheetObj = sheetObjects[2];
    var accm_vol = 0;
    if (formObj.tml_inv_rjct_sts_cd.value == 'RJ') {
        ComShowMessage("Rejected Invoice !!");
        return false;
    }
    if (formObj.tml_inv_sts_cd.value == "C") {
        ComShowMessage("Confirmed Invoice !!");
        return false;
    }
    if ((sheetObjects[0].RowCount() > 0 || sheetObjects[1].RowCount() > 0) || sheetObjects[2].RowCount() > 0 || sheetObjects[4].RowCount() > 0) {
        if (ComShowConfirm(ComGetMsg('TES40032', formObj.vvd.value + formObj.io_bnd_cd.value))) { //formObj.vvd.value+formObj.io_bnd_cd.value+"의 Data를 삭제하시겠습니까? ")){
            if (formObj.accm_seq.value != '') {
                for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
                    if (sheetObj.GetCellValue(i, 'accm_chk') == 'Y') {
                        accm_vol = parseFloat(accm_vol) + parseFloat(sheetObj.GetCellValue(i, 'rvis_vol_qty'));
                    }
                }
                formObj.pay_vol_qty.value = tes_addComma(parseInt(tes_deleteComma(formObj.pay_vol_qty.value)) - parseInt(Math.round(accm_vol)));
                doActionMainHidden(sheetObjects[3], formObj, IBSAVE);
            }
            doActionIBSheet1(sheetObjects[0], formObj, IBDELETE);
            retrieveAll();
        } else {
            return false;
        }
    } else {
        ComShowMessage(formObj.vvd.value + formObj.io_bnd_cd.value + " There is no data to delete.");
    }
}

/**
 * ATB Date find page
 * @param(dir) dir
 */
function findPage(dir) {
    var vvd_hidden = sheetObjects[4];
    var formObj = document.form;
    var page = vvd_hidden.FindText('vvd', formObj.vvd.value + io_hidden);
    if (page == -1) {
        ComShowMessage(ComGetMsg('TES40026'));
        return false;
    }
    // REV_YRMON - 2007.05.08 ... Start
    //	    if(check_revYRMON() == false){
    //            return false;
    //        }
    // REV_YRMON - 2007.05.08 ... END
    page = page + eval(dir);
    formObj.vvd.value = vvd_hidden.GetCellValue(page, 'vvd').substring(0, 9);
    formObj.vvd_type.value = vvd_hidden.GetCellValue(page, 'vvd_type');
    ComEnableObject(formObj.io_bnd_cd), true;
    formObj.io_bnd_cd.value = vvd_hidden.GetCellValue(page, 'vvd_io_bnd_cd');
    io_hidden = vvd_hidden.GetCellValue(page, 'vvd_io_bnd_cd');
    ComEnableObject(formObj.io_bnd_cd, false);
    
    //atb_dt.RemoveAll(); //2016-06-16 수정
    //atb_dt.InsertItem(0, vvd_hidden.GetCellValue(page, 'vvd_atb_dt'), vvd_hidden.GetCellValue(page, 'vvd_atb_dt'));
    //atb_dt.SetSelectCode(0, true);
    
    initAtbDtComboItemByVvdHidden(vvd_hidden, page);//2016.07.13 Add
                
    //formObj.atb_dt.value = vvd_hidden.GetCellValue(page, 'vvd_atb_dt');
    formObj.page.value = page + ' / ' + vvd_hidden.RowCount();
    
    var rtnSLanCd = getSLaneCd(); //tes_getInputValue('laneCode', SEARCH19, 'yd_cd|vvd', 'initLaneCode2');
	if(rtnSLanCd.length > 0){
		initLaneCode2(rtnSLanCd);
	}	
    
}

/**
 * need Recalculation
 */
function needRecalculation() {
    var formObj = document.form;
    var sheetObj = sheetObjects[0];
    var sheetObj1 = sheetObjects[1];
    var sheetObj2 = sheetObjects[2];
    var main_hidden = sheetObjects[3];
    var accm_hidden = sheetObjects[5];
    var accm_vol = 0;
    if (formObj.yd_cd.value != main_hidden.GetCellValue(1, 'yd_cd')) {
        if (ComShowConfirm(ComGetMsg('TES40033', 'Yard Code'))) {
            if (formObj.accm_seq.value != '') {
                for (var i = sheetObj2.HeaderRows(); i < sheetObj2.HeaderRows() + sheetObj.RowCount(); i++) {
                    if (sheetObj2.GetCellValue(i, 'accm_chk') == 'Y') {
                        accm_vol = parseFloat(accm_vol) + parseFloat(sheetObj2.GetCellValue(i, 'rvis_vol_qty'));
                    }
                }
                formObj.pay_vol_qty.value = addComma(parseInt(tes_deleteComma(formObj.pay_vol_qty.value)) - parseInt(Math.round(accm_vol)));
                doActionMainHidden(sheetObjects[3], formObj, IBSAVE);
            }
            sheetObj2.RemoveAll();
            doActionIBSheet3(sheetObj2, formObj, IBDELETE);
            doActionIBSheet1(sheetObj, formObj, IBSAVE);
        }
    }
    if (accm_hidden.RowCount() > 0) {
        if (ComReplaceStr(formObj.pay_vol_qty.value, ',', '') != accm_hidden.GetCellValue(1, 'pay_vol_qty')) {
            if (ComShowConfirm(ComGetMsg('TES40033', 'Accumulated Volume'))) {
                sheetObj2.RemoveAll();
                doActionIBSheet3(sheetObj2, formObj, IBDELETE);
                doActionIBSheet1(sheetObj, formObj, IBSAVE);
            }
        }
    }
    if (sheetObj.IsDataModified() || sheetObj1.IsDataModified()) {
        if (sheetObj2.FindText('calc_tp_cd', 'Auto Calculated Cost') > 0) {
            if (ComShowConfirm(ComGetMsg('TES40033', 'Verification Data'))) {
                if (formObj.accm_seq.value != '') {
                    for (var i = sheetObj2.HeaderRows(); i < sheetObj2.HeaderRows() + sheetObj.RowCount(); i++) {
                        if (sheetObj2.GetCellValue(i, 'accm_chk') == 'Y') {
                            accm_vol = parseFloat(accm_vol) + parseFloat(sheetObj2.GetCellValue(i, 'rvis_vol_qty'));
                        }
                    }
                    formObj.pay_vol_qty.value = addComma(parseInt(tes_deleteComma(formObj.pay_vol_qty.value)) - parseInt(Math.round(accm_vol)));
                    doActionMainHidden(sheetObjects[3], formObj, IBSAVE);
                }
                sheetObj2.RemoveAll();
                doActionIBSheet3(sheetObj2, formObj, IBDELETE);
                doActionIBSheet1(sheetObj, formObj, IBSAVE);
            }
        }
    }
    return true;
}

/** setShtCellsEditable
 * 
 * @param sheetObj        	sheet object
 * @param rownum			row number
 * @param colnms			colnms
 * @param to_sts			status
 * @param EXCEPTION			
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
 * Show Calculated Amount By VVD
 */
function ShowCalculatedAmountByVVD() {
    var sheetObj = sheetObjects[2];
    var tot_hidden = sheetObjects[10];
    var formObj = document.form;
    var total_amt = 0;
    var curr_amt = 0;
    for (var i = tot_hidden.HeaderRows(); i < tot_hidden.HeaderRows() + tot_hidden.RowCount(); i++) {
        if ((tot_hidden.GetCellValue(i, 'vvd') + tot_hidden.GetCellValue(i, 'io_bnd_cd')) != (formObj.vvd.value + io_hidden)) {
            //                total_amt = Math.round(total_amt*100)/100 + Math.round(tot_hidden.CellValue(i,'inv_amt')*100)/100;
            total_amt = tes_round((Number(total_amt) + Number(tot_hidden.GetCellValue(i, 'inv_amt'))), 2);
        }
    }
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        //            curr_amt = Math.round(curr_amt*100)/100 + Math.round(sheetObj.CellValue(i,'inv_amt')*100)/100;
        //            curr_amt = eval(parseFloat(curr_amt) + parseFloat(sheetObj.CellValue(i,'inv_amt')));
        curr_amt = tes_round((Number(curr_amt) + Number(sheetObj.GetCellValue(i, 'inv_amt'))), 2);
    }
    //        curr_amt = Math.round(curr_amt*100)/100;
    //        total_amt = Math.round((total_amt + curr_amt)*100)/100;
    curr_amt = tes_round(Number(curr_amt), 2);
    total_amt = tes_round((Number(total_amt) + Number(curr_amt)), 2);
    formObj.vvd_inv_amt.value = tes_chkAmtFmt(curr_amt, formObj.curr_cd.value);
    formObj.tot_inv_amt.value = tes_chkAmtFmt(total_amt, formObj.curr_cd.value);
}

/**
 * Check CNTR List Mandatory Column
 */
function CheckCNTRListMandatoryCol() {
    var formObj = document.form;
    var flag = true;
    for (j = 0; j < 1; j++) {
        for (i = sheetObjects[j].HeaderRows(); i < sheetObjects[j].HeaderRows() + sheetObjects[j].RowCount(); i++) {
            if (sheetObjects[j].GetCellValue(i, 'cntr_sty_cd') == '' || sheetObjects[j].GetCellValue(i, 'cntr_sty_cd') == null) {
                flag = false;
            }
            if (sheetObjects[j].GetCellValue(i, 'io_bnd_cd') == '' || sheetObjects[j].GetCellValue(i, 'io_bnd_cd') == null) {
                flag = false;
            }
            if (sheetObjects[j].GetCellValue(i, 'dcgo_clss_cd') == '' || sheetObjects[j].GetCellValue(i, 'dcgo_clss_cd') == null) {
                flag = false;
            }
            if (sheetObjects[j].GetCellValue(i, 'ioc_cd') == '' || sheetObjects[j].GetCellValue(i, 'ioc_cd') == null) {
                flag = false;
            }
            //	            if(sheetObjects[j].CellValue(i,'lane_cd') == '' || sheetObjects[j].CellValue(i,'lane_cd') == null){
            //	                flag = false;
            //	            }
            if (sheetObjects[j].GetCellValue(i, 'locl_ts_ind_cd') == '' || sheetObjects[j].GetCellValue(i, 'locl_ts_ind_cd') == null) {
                flag = false;
            }
            if (sheetObjects[j].GetCellValue(i, 'cntr_tpsz_cd') == '' || sheetObjects[j].GetCellValue(i, 'cntr_tpsz_cd') == null) {
                flag = false;
            }
            if (sheetObjects[j].GetCellValue(i, 'tml_trns_mod_cd') == '' || sheetObjects[j].GetCellValue(i, 'tml_trns_mod_cd') == null) {
                flag = false;
            }
        }
    }
    if (flag == false) {
        ComShowMessage(ComGetMsg('TES22037', 'CNTR Type/size, I/O, F/M, DG, WorkingDate, IPC, Mode, Lane, T/S')); //' I/O, F/M, DG, WorkingDate, IPC, Lane, T/S는 필수 입력항목입니다. 확인하십시오.');
        return false;
    }
    for (j = 0; j < 2; j++) {
        for (i = sheetObjects[j].HeaderRows(); i < sheetObjects[j].HeaderRows() + sheetObjects[j].RowCount(); i++) {
            if (sheetObjects[j].GetCellValue(i, 'io_bnd_cd') != io_hidden && sheetObjects[j].GetCellValue(i, 'io_bnd_cd') != '') {
                flag = false;
            }
            if (j == 1 && sheetObjects[j].GetRowStatus(i) == 'U' && sheetObjects[j].GetCellValue(i, 'io_bnd_cd') != io_hidden) {
                sheetObjects[j].SetCellValue(i, 'io_bnd_cd', 'X');
            }
        }
    }
    if (flag == false) {
        ComShowMessage(ComGetMsg('TES40054'));
        return false;
    }
    return true;
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
    }
    //formObj.total_amt.value = tes_chkAmtFmt((Number(ttl_inv_amt) + Number(vat_amt) - Number(whld_tax_amt)), formObj.curr_cd.Code);
    //	    formObj.total_amt.value = tes_chkAmtFmt((Number(ttl_inv_amt*100) + Number(vat_amt*100) - Number(whld_tax_amt*100))/100, formObj.curr_cd.Code);
    formObj.total_amt.value = tes_chkAmtFmt(tes_round((Number(ttl_inv_amt) + Number(vat_amt) - Number(whld_tax_amt)), 2), curr_cd.GetSelectCode());
}

/**
 * Reject button click event
 *
 */
function rjctInv() {
    sheetObjects[3].SetCellValue(1, 'tml_inv_rjct_sts_cd', 'RJ');
    doActionMainHidden(sheetObjects[3], document.form, IBSEARCH_ASYNC02);
}

/**
 * Currency Code change
 */
function curr_cd_OnChange() {
    var main_hidden = sheetObjects[3];
    var sheetObj2 = sheetObjects[2];
    var formObj = document.form;
    var accm_vol = 0;
    if (main_hidden.RowCount() == 1) {
        if ((main_hidden.GetCellValue(1, 'curr_cd') != comboObjects[0].GetSelectCode()) ||
            (formObj.curr_cd_tmp.value != undefined && formObj.curr_cd_tmp.value != null && formObj.curr_cd_tmp.value != '' && formObj.curr_cd_tmp.value != comboObjects[0].GetSelectCode())) {
            resetInputValue();
        }
        if (sheetObj2.RowCount() > 0) {
            if (formObj.curr_cd_tmp.value != comboObjects[0].GetSelectCode()) {
                if (ComShowConfirm(ComGetMsg('TES40033', 'Currency Code'))) {
                    if (formObj.accm_seq.value != '') {
                        for (var i = sheetObj2.HeaderRows(); i < sheetObj2.HeaderRows() + sheetObj2.RowCount(); i++) {
                            if (sheetObj2.GetCellValue(i, 'accm_chk') == 'Y') {
                                accm_vol = parseFloat(accm_vol) + parseFloat(sheetObj2.GetCellValue(i, 'rvis_vol_qty'));
                            }
                        }
                        formObj.pay_vol_qty.value = addComma(parseInt(tes_deleteComma(formObj.pay_vol_qty.value)) - parseInt(Math.round(accm_vol)));
                    }
                    doActionMainHidden(main_hidden, formObj, IBSAVE);
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

/** reset Input Value
 * 
 * @return
 */
function resetInputValue() {
    var formObj = document.form;
    formObj.ttl_inv_amt.value = '';
    formObj.vat_amt.value = '';
}

/** set CURR_CD value
 * 
 * @param CURR_CD
 * @return
 */
function resetSheetDataProperty(CURR_CD) {
    if (CURR_CD != undefined && tes_isNoDecimalPointCurrCD(CURR_CD)) {

        var cols = [{ Type: "Int", Hidden: 0, Width: 70,  Align: "Right",  ColMerge: 0,  SaveName: "ctrt_rt",    KeyField: 0,  CalcLogic: "",  Format: "Integer",  PointCount: 0,  UpdateEdit: 0,  InsertEdit: 0 }, 
        			{ Type: "Int",  Hidden: 0,  Width: 70,  Align: "Right",  ColMerge: 0, SaveName: "inv_amt",  KeyField: 0,  CalcLogic: "",  Format: "Integer",  PointCount: 0,  UpdateEdit: 0,  InsertEdit: 0  }];
        sheetObjects[2].InitColumns(cols);
        // sheetObjects[2].InitDataProperty(0, 26 , dtData  ,    70,    daRight ,  false,    "ctrt_rt" ,  false,  "", dfInteger,   0,     false,       false);
        // sheetObjects[2].InitDataProperty(0, 30 , dtData  ,    70,    daRight ,  false,    "inv_amt" ,  false,  "", dfInteger,   0,     false,       false);
    } else {
    
    	var cols = [{ Type: "Float", Hidden: 0,  Width: 70,  Align: "Right", ColMerge: 0, SaveName: "ctrt_rt",  KeyField: 0,  CalcLogic: "",  Format: "Float",  PointCount: 2, UpdateEdit: 0,  InsertEdit: 0 }, 
    				{ Type: "Float",  Hidden: 0,  Width: 70,  Align: "Right",  ColMerge: 0, SaveName: "inv_amt",   KeyField: 0,  CalcLogic: "",   Format: "Float",  PointCount: 2,  UpdateEdit: 0,  InsertEdit: 0 }];
        sheetObjects[2].InitColumns(cols);
        // sheetObjects[2].InitDataProperty(0, 26 , dtData  ,    70,    daRight ,  false,    "ctrt_rt" ,  false,  "", dfFloat,     2,     false,       false);
        // sheetObjects[2].InitDataProperty(0, 30 , dtData  ,    70,    daRight ,  false,    "inv_amt" ,  false,  "", dfFloat,     2,     false,       false);
    }
}

/** Basic Info Save
 * 
 * @return
 */
function isBasicInfoSaved() {
    if (sheetObjects[3].RowCount() != 1) {
        ComShowMessage(ComGetMsg('TES22005'));
        document.form.vvd.value = '';
        return false;
    }
}

/** resize
 * 
 * @return
 */
function reSize() {
    var div01 = document.all.SearchLayer01.style.display;
    var div02 = document.all.SearchLayer02.style.display;
    var obj = ComGetEvent();
    if (div01 == "inline") {
        obj.className = "btn_down"
        document.all.SearchLayer01.style.display = "none";
        document.all.SearchLayer02.style.display = "none";
    } else {
        obj.className = "btn_up"
        document.all.SearchLayer01.style.display = "inline";
        document.all.SearchLayer02.style.display = "inline";
    }
}

/** sheet[0]
 * 
 * @return
 */
function fileimp() {
    doActionIBSheet1(sheetObjects[0], document.form, IBSEARCH);
}

/**
 *  @param sheetObj    sheet object
 *  @param formObj     form object
 *  @param sAction     Action	 
 */
function doActionMainHidden(sheetObj, formObj, sAction) { // main_hidden_OnSearchEnd    vvd_hidden_OnSearchEnd
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH:
            formObj.f_cmd.value = SEARCH;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0001GS.do", tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            var arrXml = searchXml.split("|$$|");
            sheetObj.RemoveEtcData();
            sheetObj.LoadSearchData(arrXml[0], { Sync: 0 });  // main_hidden_OnSearchEnd
            sheetObjects[4].LoadSearchData(arrXml[1], { Sync: 0 }); // vvd_hidden_OnSearchEnd
            searchXml = null;
            arrXml[0] = null;
            arrXml[1] = null;
            break;

        case IBSEARCH_ASYNC04:
            formObj.f_cmd.value = SEARCH16;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0001GS.do", tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
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

        case IBSAVE:
            //if(sheetObj.GetCellValue(1,'tml_so_seq') == null || sheetObj.GetCellValue(1,'tml_so_seq') == ''){
            if (sheetObj.GetCellValue(1, 'tml_so_seq') == '-1') {
                formObj.f_cmd.value = ADD;
            } else {
                formObj.f_cmd.value = MODIFY;
            }
            var param = sheetObj.GetSaveString();
            var saveXml = sheetObj.GetSaveData("ESD_TES_0001GS.do", param + '&' + tesFrmQryStr(formObj, param + '&calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            var arrXml = saveXml.split("|$$|");
            sheetObj.LoadSearchData(arrXml[0], { Sync: 0 });
            if (formObj.f_cmd.value == MODIFY) {
                sheetObjects[4].LoadSearchData(arrXml[1], { Sync: 0 });
            }
            sheetObjects[5].LoadSearchData(arrXml[2], { Sync: 0 });
            saveXml = null;
            arrXml[0] = null;
            arrXml[1] = null;
            arrXml[2] = null;
            break;
            
        case IBSEARCH_ASYNC01:
            formObj.f_cmd.value = MODIFY01;
            var param = sheetObj.GetSaveString() + '&' + sheetObjects[2].GetSaveString(false, false) + '&' + sheetObjects[6].GetSaveString(false, false) + '&' + sheetObjects[7].GetSaveString(false, false);
            var saveXml = sheetObj.GetSaveData("ESD_TES_0001GS.do", param + '&' + tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            var arrXml = saveXml.split("|$$|");
            if (arrXml.length > 1) {
                sheetObjects[3].RemoveAll();
                sheetObjects[4].RemoveAll();
                sheetObjects[5].RemoveAll();
                sheetObj.LoadSearchData(arrXml[0], { Sync: 0 });
                sheetObjects[4].LoadSearchData(arrXml[1], { Sync: 0 });
            } else if (arrXml.length == 1) {
                if (arrXml[0].indexOf("TES00089") != -1) {
                    ComShowMessage(ComGetMsg('TES70803'));
                } else if (arrXml[0].indexOf("TES00085") != -1) {
                    ComShowMessage(ComGetMsg('TES70607'));
                } else if (arrXml[0].indexOf("TES00086") != -1) {
                    ComShowMessage(ComGetMsg('TES70608'));
                }
            }
            saveXml = null;
            arrXml[0] = null;
            arrXml[1] = null;
            arrXml[2] = null;
            break;
            
        case IBSEARCH_ASYNC02:
            //Reject
            //alert("start IBSEARCH_ASYNC02==>"+IBSEARCH_ASYNC02);
            formObj.f_cmd.value = MODIFY02;
            var param = sheetObj.GetSaveString();
            var saveXml = sheetObj.GetSaveData("ESD_TES_0001GS.do", param + '&' + tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            sheetObjects[3].RemoveAll();
            sheetObjects[4].RemoveAll();
            sheetObjects[5].RemoveAll();
            var arrXml = saveXml.split("|$$|");
            //alert(arrXml.length);
            sheetObj.LoadSearchData(arrXml[0], { Sync: 0 });
            sheetObjects[4].LoadSearchData(arrXml[1], { Sync: 0 });
            saveXml = null;
            arrXml[0] = null;
            arrXml[1] = null;
            break;
            
        case IBSEARCH_ASYNC03:
            //Reject Lift
            //alert("start IBSEARCH_ASYNC03==>"+IBSEARCH_ASYNC03);
            formObj.f_cmd.value = MODIFY03;
            formObj.tml_so_ofc_cty_cd.value = sheetObj.GetCellValue(1, 'tml_so_ofc_cty_cd');
            formObj.tml_so_seq.value = sheetObj.GetCellValue(1, 'tml_so_seq');
            var saveXml = sheetObj.GetSearchData("ESD_TES_0001GS.do", tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            sheetObjects[3].RemoveAll();
            sheetObjects[4].RemoveAll();
            sheetObjects[5].RemoveAll();
            var arrXml = saveXml.split("|$$|");
            sheetObj.RemoveEtcData();
            sheetObj.LoadSearchData(arrXml[0], { Sync: 0 });
            sheetObjects[4].LoadSearchData(arrXml[1], { Sync: 0 });
            searchXml = null;
            arrXml[0] = null;
            arrXml[1] = null;
            break;
    }
}

/** VVD hidden form
 * 
 * @param sheetObj    sheet Object
 * @param formObj	  form  Object	
 * @param sAction	  action value
 * @return
 */
function doActionVVDHidden(sheetObj, formObj, sAction) { // vvd_check_hidden_OnSearchEnd
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH_ASYNC01:
            formObj.f_cmd.value = SEARCH11;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0001GS.do", tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            if (searchXml != "") {
            	sheetObj.LoadSearchData(searchXml, { Append: 1, Sync: 0 });
            }
            break;
            
        case IBSEARCH_ASYNC02:
            formObj.f_cmd.value = SEARCH15;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0001GS.do", tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            sheetObjects[11].RemoveAll();
            if (searchXml != "") {
            	sheetObj.LoadSearchData(searchXml, { Append: 1, Sync: 0 });
            }
            break;
    }
}

//    /** 
//     * 
//     * @param sheetObj			sheet Object
//     * @param formObj			form  Object		
//     * @param sAction			Action value
//     * @return
//     */ 
//    function doActionHidden(sheetObj, formObj, sAction){
//        sheetObj.ShowDebugMsg = false;
//        switch(sAction){
//            case IBSEARCH:
//            formObj.f_cmd.value = SEARCH13;
//            var searchXml = sheetObj.GetSearchXml("ESD_TES_0001GS.do", tesFrmQryStr(formObj));
//            if (searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
//        }
//    }

/** hidden form
 * 
 * @param sheetObj			sheet Object
 * @param formObj			form  Object		
 * @param sAction			Action value
 * @return
 */
function doActionAccmHidden(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH:
            formObj.f_cmd.value = SEARCH12;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0001GS.do", tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            if (searchXml != "") {
            	sheetObj.LoadSearchData(searchXml, { Append: 1, Sync: 0 });
            }
    }
}

/** hidden form 
 * 
 * @param sheetObj			sheet Object
 * @param formObj			form  Object		
 * @param sAction			Action value
 * @return
 */
function doActionRvisHidden(sheetObj, formObj, sAction) { //alert("start doActionRvisHidden");
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH:
            formObj.f_cmd.value = SEARCH08;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0001GS.do", tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            if (searchXml != "") {
            	sheetObj.LoadSearchData(searchXml, { Append: 1, Sync: 0 });
            }
    }
}

/** sheet retrieve
 * 
 * @param sheetObj		sheet object
 * @param formObj		form object
 * @param sAction		Action value
 * @return
 */
function doActionIBSheet1(sheetObj, formObj, sAction) { // t1sheet1_OnSearchEnd
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH:
            formObj.f_cmd.value = SEARCH01;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0001GS.do", tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            var arrXml = searchXml.split("|$$|");
            sheetObjects[0].LoadSearchData(arrXml[0], { Sync: 1 }); // t1sheet1_OnSearchEnd
            sheetObjects[1].LoadSearchData(arrXml[1], { Sync: 1 }); // t2sheet1_OnSearchEnd
            sheetObjects[2].LoadSearchData(arrXml[2], { Sync: 1 }); // t3sheet1_OnSearchEnd
            sheetObjects[5].LoadSearchData(arrXml[3], { Sync: 1 }); // accm_hidden_OnSearchEnd
            sheetObjects[8].LoadSearchData(arrXml[4], { Sync: 1 }); // amt_hidden_OnSearchEnd
            sheetObjects[10].LoadSearchData(arrXml[5], { Sync: 1 }); // total_hidden_OnSearchEnd
            searchXml = null;
            arrXml[0] = null;
            arrXml[1] = null;
            arrXml[2] = null;
            arrXml[3] = null;
            arrXml[4] = null;
            arrXml[5] = null;
            break;
            
        case IBSEARCH_ASYNC01:
            formObj.f_cmd.value = SEARCH02;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0001GS.do", tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            var arrXml = searchXml.split("|$$|");
            sheetObjects[0].LoadSearchData(arrXml[0], { Sync: 0 });
            sheetObjects[1].LoadSearchData(arrXml[1], { Sync: 0 });
            searchXml = null;
            arrXml[0] = null;
            arrXml[1] = null;
            break;
            //            case IBSEARCH_ASYNC02:
            //                formObj.f_cmd.value=MULTI02;
            //                var param=sheetObj.GetSaveString(false) + '&' + sheetObjects[1].GetSaveString(false);
            //                 var saveXml=sheetObj.GetSaveData("ESD_TES_0001GS.do", tesFrmQryStr(formObj,'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd') + '&' + param);
            //				var arrXml=saveXml.split("|$$|");
            //                sheetObjects[0].LoadSearchData(arrXml[0],{Sync:0} );
            //                sheetObjects[1].LoadSearchData(arrXml[1],{Sync:0} );
            //                searchXml=null; arrXml[0]=null; arrXml[1]=null;
            //                break;               
            
        case IBSAVE:
            formObj.f_cmd.value = MULTI01;
            var param = sheetObj.GetSaveString(false) + '&' + sheetObjects[1].GetSaveString(false);
            var saveXml = sheetObj.GetSaveData("ESD_TES_0001GS.do", tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd') + '&' + param);
            var arrXml = saveXml.split("|$$|");
            sheetObjects[0].LoadSearchData(arrXml[0], { Sync: 0 });
            sheetObjects[1].LoadSearchData(arrXml[1], { Sync: 0 });
            sheetObjects[2].LoadSearchData(arrXml[2], { Sync: 0 });
            searchXml = null;
            arrXml[0] = null;
            arrXml[1] = null;
            arrXml[2] = null;
            break;
            
        case IBDELETE:
            formObj.f_cmd.value = REMOVE01;
            var saveXml = sheetObj.GetSaveData("ESD_TES_0001GS.do", tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            sheetObj.LoadSaveData(saveXml, true);
            break;
            
        case IBCLEAR:
            formObj.f_cmd.value = REMOVE03;
            var saveXml = sheetObj.GetSaveData("ESD_TES_0001GS.do", tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            sheetObj.LoadSaveData(saveXml, true);
            break;
            
        case IBDOWNEXCEL:
            sheetObj.ExcelOption = "NOCOLOR";
            sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1 });
            sheetObj.ExcelOption = "";
            break;
    }
}

/** doActionIBSheet2
 * 
 * @param sheetObj		sheet Object
 * @param formObj		form  Object
 * @param sAction		sAction value
 * @return
 */
function doActionIBSheet2(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBDOWNEXCEL:
            sheetObj.ExcelOption = "NOCOLOR";
            sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1 });
            sheetObj.ExcelOption = "";
            break;
            
        case IBSEARCH:
            formObj.f_cmd.value = MULTI14;
            formObj.reverify_yn.value = "Y";
            var searchXml = sheetObj.GetSearchData("ESD_TES_0001GS.do", tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            var arrXml = searchXml.split("|$$|");
            sheetObj.LoadSearchData(arrXml[0], { Sync: 0 });
            sheetObjects[0].LoadSearchData(arrXml[1], { Sync: 0 });
            sheetObjects[1].LoadSearchData(arrXml[2], { Sync: 0 });
            sheetObj.RemoveEtcData();
            searchXml = null;
            arrXml[0] = null;
            arrXml[1] = null;
            arrXml[2] = null;

            formObj.reverify_yn.value = '';
            break;

        case IBSEARCH_ASYNC02:
            formObj.f_cmd.value = MULTI03;
            //				formObj.reverify_yn.value="Y";
            var searchXml = sheetObj.GetSearchData("ESD_TES_0001GS.do", tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            var arrXml = searchXml.split("|$$|");
            sheetObj.LoadSearchData(arrXml[0], { Sync: 0 });
            sheetObjects[0].LoadSearchData(arrXml[1], { Sync: 0 });
            sheetObjects[1].LoadSearchData(arrXml[2], { Sync: 0 });
            sheetObj.RemoveEtcData();
            searchXml = null;
            arrXml[0] = null;
            arrXml[1] = null;
            arrXml[2] = null;

            formObj.reverify_yn.value = '';
            break;
    }
}

/** cost calc 
 * 
 * @param sheetObj 		sheet object 
 * @param formObj		from  object
 * @param sAction		Actio value	
 * @return
 */
function doActionIBSheet3(sheetObj, formObj, sAction) { // t3sheet1_OnSearchEnd
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH:
            formObj.f_cmd.value = SEARCH04;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0001GS.do", tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            var arrXml = searchXml.split("|$$|");
            sheetObj.RemoveEtcData();
            sheetObjects[2].LoadSearchData(arrXml[0], { Append: 1, Sync: 1 });
            sheetObjects[8].LoadSearchData(arrXml[1], { Sync: 1 });
            sheetObjects[10].LoadSearchData(arrXml[2], { Sync: 1 });
            saveXml = null;
            arrXml[0] = null;
            arrXml[1] = null;
            arrXml[2] = null;
            break;

        case IBSEARCH_ASYNC02:
            formObj.f_cmd.value = SEARCH18;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0001GS.do", tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            var dbCount = ComGetEtcData(searchXml, "db_cnt");
            var dbInv = ComGetEtcData(searchXml, "inv_no");

            if (dbCount > 0) { //db이 존재한다면
                if (ComShowConfirm("Double Billing Inv [ " + dbInv + " ] exists. Do you want to continue?")) {
                    tabObjects[0].SetSelectedIndex(2);
                    doActionIBSheet3(sheetObjects[2], formObj, IBSEARCH);
                    if (formObj.accm_seq.value != '') {
                        doActionMainHidden(sheetObjects[3], formObj, IBSAVE);
                    }
                } else {
                    tabObjects[0].SetSelectedIndex(1);
                    doActionIBSheet2(sheetObjects[1], formObj, IBSEARCH_ASYNC02);
                }

            } else {
                tabObjects[0].SetSelectedIndex(2);
                doActionIBSheet3(sheetObjects[2], formObj, IBSEARCH);
                if (formObj.accm_seq.value != '') {
                    doActionMainHidden(sheetObjects[3], formObj, IBSAVE);
                }
            }
            break;

        case IBSAVE:
            formObj.f_cmd.value = MULTI02;

            if (sheetObj.GetCellValue(i, 'calc_tp_cd') == 'S' && (sheetObj.GetRowStatus(i) == 'I' || sheetObj.GetRowStatus(i) == 'U')) {
                if (sheetObj.GetCellValue(i, 'inv_amt') == null || parseFloat(sheetObj.GetCellValue(i, 'inv_amt')) == 0) {
                    ComShowMessage("Please input Amount.");
                    return false;
                }
            }

            var param = sheetObj.GetSaveString(false, false) + '&' + sheetObjects[6].GetSaveString(false, false) + '&' + sheetObjects[7].GetSaveString(false, false);
            var saveXml = sheetObj.GetSaveData("ESD_TES_0001GS.do", param + '&' + tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            var arrXml = saveXml.split("|$$|");
            sheetObj.LoadSearchData(arrXml[0], { Sync: 0 });
            sheetObjects[2].LoadSearchData(arrXml[0], { Sync: 0 }); // t3sheet1_OnSearchEnd
            sheetObjects[8].LoadSearchData(arrXml[1], { Sync: 0 }); // 
            sheetObjects[10].LoadSearchData(arrXml[2], { Sync: 0 });  // total_hidden_OnSearchEnd
            sheetObjects[4].LoadSearchData(arrXml[3], { Sync: 0 });  // vvd_hidden_OnSearchEnd
            sheetObj.RemoveEtcData();
            saveXml = null;
            arrXml[0] = null;
            arrXml[1] = null;
            arrXml[2] = null;
            arrXml[3] = null;
            auto_bound();
            break;
            
        case IBDELETE:
            formObj.f_cmd.value = REMOVE02;
            var param = sheetObj.GetSaveString(false, false);
            var saveXml = sheetObj.GetSaveData("ESD_TES_0001GS.do", param + '&' + tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            var arrXml = saveXml.split("|$$|");
            sheetObj.LoadSearchData(arrXml[0], { Sync: 0 });
            sheetObjects[2].LoadSearchData(arrXml[0], { Sync: 0 });
            sheetObjects[8].LoadSearchData(arrXml[1], { Sync: 0 });
            sheetObjects[10].LoadSearchData(arrXml[2], { Sync: 0 });
            sheetObjects[4].LoadSearchData(arrXml[3], { Sync: 0 });
            sheetObj.RemoveEtcData();
            saveXml = null;
            arrXml[0] = null;
            arrXml[1] = null;
            arrXml[2] = null;
            arrXml[3] = null;

            break;
    }
}

/** n3rd hidden
 * 
 * @param sheetObj		sheet object
 * @param formObj		froom object
 * @param sAction		Action value
 * @return
 */
function doActionN3rdHidden(sheetObj, formObj, sAction) { //alert("start doActionN3rdHidden");
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSAVE:
            formObj.f_cmd.value = MODIFY04;
            //              var param = sheetObj.GetSaveString(false,false,'n3pty_chk');
            var saveXml = sheetObj.GetSaveData("ESD_TES_0001GS.do", tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            sheetObj.LoadSaveData(saveXml, true);
            break;
    }
}

/**
 *  auto bound
 */
function auto_bound() { //alert("start auto_bound");
    var vvd_row = sheetObjects[4].FindText('vvd', document.form.vvd.value + io_hidden);
    var screen_vvd = document.form.vvd.value.substr(0, 8);
    var screen_vvd2 = document.form.vvd.value.substr(8, 1);
    var screen_vvd3 = "";
    if (screen_vvd2 == "E") {
        screen_vvd3 = screen_vvd + "W";
    } else if (screen_vvd2 == "W") {
        screen_vvd3 = screen_vvd + "E";
    } else if (screen_vvd2 == "S") {
        screen_vvd3 = screen_vvd + "N";
    } else if (screen_vvd2 == "N") {
        screen_vvd3 = screen_vvd + "S";
    }
    
    var vvd_cnt = 0;
    for (var i = 1; i <= sheetObjects[4].RowCount(); i++) { 
        //2017.01.06 Modify
        var tmpSheetVvd = sheetObjects[4].GetCellValue(i, 'vvd_vsl_cd') + sheetObjects[4].GetCellValue(i, 'vvd_skd_voy_no') + sheetObjects[4].GetCellValue(i, 'vvd_skd_dir_cd');
        if (screen_vvd3 == tmpSheetVvd) {
            vvd_cnt++;
        }
        /*
        if (screen_vvd3 == sheetObjects[4].GetCellValue(i, 'vvd').substr(0, 9)) {
            vvd_cnt++;
        }
        */
    }
    //alert("vvd_cnt:"+vvd_cnt);
    if (vvd_cnt == 0) {
        var tmpVvdVslCd = sheetObjects[4].GetCellValue(vvd_row, 'vvd_vsl_cd');//2017.01.06 Modify
        
        if (sheetObjects[2].RowCount() > 0 && (sheetObjects[4].GetCellValue(vvd_row, 'vvd_vsl_cd')) != 'CNTC') {
            var arr_manual_lgs_cost_cd = MANUAL_LGS_COST_CD.split('|');
            var cnt = 0;
            document.form.bound_lgs_cost_cd.value = "";
            for (var i = sheetObjects[2].HeaderRows(); i < sheetObjects[2].HeaderRows() + sheetObjects[2].RowCount(); i++) {
                if (sheetObjects[2].GetCellValue(i, 'calc_tp_cd') == 'M') {
                    if (document.form.bound_lgs_cost_cd.value == "") {
                        document.form.bound_lgs_cost_cd.value = sheetObjects[2].GetCellValue(i, 'lgs_cost_cd');
                    } else {
                        document.form.bound_lgs_cost_cd.value = document.form.bound_lgs_cost_cd.value + "','" + sheetObjects[2].GetCellValue(i, 'lgs_cost_cd');
                    }
                    
                    for (var j = 0; j < arr_manual_lgs_cost_cd.length; j++) {
                        if (arr_manual_lgs_cost_cd[j] == sheetObjects[2].GetCellValue(i, 'lgs_cost_cd')) { //alert(sheetObjects[2].GetCellValue(i,'lgs_cost_cd'));
                            if (sheetObjects[2].GetCellValue(i, 'lgs_cost_cd') == 'SVALFL' || sheetObjects[2].GetCellValue(i, 'lgs_cost_cd') == 'SVOSOT' || sheetObjects[2].GetCellValue(i, 'lgs_cost_cd') == 'SVTLLS') {
                                cnt = cnt + 1;
                            }
                        }
                    }
                    
                }
            }
            //alert("cnt==>"+cnt);              
            if (cnt > 0) {
                doActionVVDHidden(sheetObjects[11], document.form, IBSEARCH_ASYNC02);
                return false;
            }
        }
    } else {
        return false;
    }
}

/**
 * @param     : str	date
 * sample	: get_Year("2003-01-01"); get_Year("20030101");
 * @return 	: year
 **/
function get_Year(str) {
    //str = delete_Char(str,'-');
    //str = trim(str);
    return (str.substr(0, 4));
}

/**
 * @param     : str	=> date
 * sample	: get_Month("2003-01-01"); get_Month("20030101");
 * @return 	: month
 **/
function get_Month(str) {
    //str = delete_Char(str,'-');
    //str = trim(str);
    return (str.substr(4, 2));
}

/**
 *  MGSet input popup 
 * 
 * @param {ibsheet}	sheetObj	IBsheet object
 * @param {String}	Row			row Index
 * @param {String}	Col			col Index
 * @param {long}	CellX
 * @param {long}	CellY
 * @param {long}	CellW
 * @param {long}	CellH
 * @return
 */
function t3sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
    if (sheetObj.GetCellValue(Row, 'tml_so_dtl_seq').trim() != '' && sheetObj.GetCellValue(Row, 'lgs_cost_cd').trim() == 'TMRFGO') {
        if (sheetObj.GetCellValue(Row, 'lgs_cost_cd').trim() == sheetObj.CellSearchValue(Row, 'lgs_cost_cd2').trim()) {
            openMGSet(Row);
        } else {
            ComShowMessage("Please Double Click After Save Setting Values");
        }
    }
}

/**
 * Mgset open 
 *
 * @param {String}	row
 * @return
 */
function openMGSet(row) {
    var tml_so_ofc_cty_cd = ComGetObjValue(document.form.tml_so_ofc_cty_cd);
    var tml_so_seq = ComGetObjValue(document.form.tml_so_seq);
    var tml_so_dtl_seq = sheetObjects[2].GetCellValue(row, 'tml_so_dtl_seq');
    var curr_cd = document.form.curr_cd.GetSelectCode();
    var yd_cd = ComGetObjValue(document.form.yd_cd);
    var url_str = 'ESD_TES_1004Popup.screen?tml_so_ofc_cty_cd=' + tml_so_ofc_cty_cd + '&tml_so_seq=' + tml_so_seq + '&tml_so_dtl_seq=' + tml_so_dtl_seq + "&curr_cd=" + curr_cd + "&yd_cd=" + yd_cd;
    ComOpenWindow(url_str, window, "dialogWidth:800px; dialogHeight:440px; help:no; status:no; resizable:yes;", true);
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

function setCostCode(sheetObj) {

    if (sheetObj.CheckedRows("sel") < 1) {
        return;
    }

    var vvd_hidden = sheetObjects[4];
    var vvd_row = sheetObjects[4].FindText('vvd', document.form.vvd.value + io_hidden);
    
    //2017.01.06 Modify
    var tmpVvd = "";
    var tmpVslCd = "";
    var tmpSkdVoyNo = "";
    var tmpSkdDirCd = "";
    var tmpAtbDt = "";
    if(vvd_row < 0){
        tmpVvd = ComGetObjValue(document.form.vvd);
        if(tmpVvd.length == 8){
            tmpVslCd = tmpVvd.substr(0,4);
            tmpSkdVoyNo = tmpVvd.substr(4,4);
            tmpSkdDirCd = tmpVvd.substr(8,1);
        }
        tmpAtbDt = ComGetObjValue(document.form.atb_dt);
    }else{
        tmpVslCd = vvd_hidden.GetCellValue(vvd_row, "vvd_vsl_cd");
        tmpSkdVoyNo = vvd_hidden.GetCellValue(vvd_row, "vvd_skd_voy_no");
        tmpSkdDirCd = vvd_hidden.GetCellValue(vvd_row, "vvd_skd_dir_cd");
        tmpAtbDt = vvd_hidden.GetCellValue(vvd_row, "vvd_atb_dt");
    }
    
    
    var targetSheetObj = sheetObjectsMap['t3sheet1'];
    var idx;

    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        if (!sheetObj.GetCellValue(i, "sel")) continue;
        idx = targetSheetObj.DataInsert(-1);

        targetSheetObj.CellComboItem(idx, 'lgs_cost_cd', { ComboText: document.form.calcTerminalComboItems.value, ComboCode: document.form.calcTerminalComboItems.value });

        targetSheetObj.SetCellValue(idx, "calc_tp_cd", sheetObj.GetCellValue(i, "calc_tp_cd"));
        targetSheetObj.SetCellValue(idx, "lgs_cost_cd", sheetObj.GetCellValue(i, "lgs_cost_cd"));
        targetSheetObj.SetCellValue(idx, "cntr_tpsz_cd", sheetObj.GetCellValue(i, "cntr_tpsz_cd"));
        targetSheetObj.SetCellValue(idx, "io_bnd_cd", document.form.io_bnd_cd.value);
        targetSheetObj.SetCellValue(idx, "dcgo_ind_cd", sheetObj.GetCellValue(i, "dcgo_ind_cd"));

        if (sheetObj.GetCellValue(i, "dcgo_ind_cd") == 'ALL' || sheetObj.GetCellValue(i, "dcgo_ind_cd") == 'AN' || sheetObj.GetCellValue(i, "dcgo_ind_cd") == 'AS' || sheetObj.GetCellValue(i, "dcgo_ind_cd") == 'SN') {
            sheetObj.SetCellValue(i, "dcgo_ind_cd", '');
            targetSheetObj.SetCellValue(idx, "dcgo_ind_cd", sheetObj.GetCellValue(i, "dcgo_ind_cd"));
        }

        targetSheetObj.SetCellValue(idx, "rc_flg", sheetObj.GetCellValue(i, "rc_flg"));
        targetSheetObj.SetCellValue(idx, "tml_wrk_dy_cd", sheetObj.GetCellValue(i, "tml_wrk_dy_cd"));

        //	     ,DECODE(A.IOC_CD, 'I','IPC','S','Same','O','OCN') AS ioc_cd /* IPC */
        //	     ,DECODE(A.TML_TRNS_MOD_CD,'V','Mother','R','Rail','T','Truck','B','Barge','O','Other','S','Same','F','Feeder') AS tml_trns_mod_cd /* Mode */

        if (sheetObj.GetCellValue(i, "ioc_cd") == 'Same') {
            sheetObj.SetCellValue(i, "ioc_cd", 'S');
        } else if (sheetObj.GetCellValue(i, "ioc_cd") == 'IPC') {
            sheetObj.SetCellValue(i, "ioc_cd", 'I');
        } else if (sheetObj.GetCellValue(i, "ioc_cd") == 'OCN') {
            sheetObj.SetCellValue(i, "ioc_cd", 'O');
        }
        
        targetSheetObj.SetCellValue(idx, "ioc_cd", sheetObj.GetCellValue(i, "ioc_cd"));

        if (sheetObj.GetCellValue(i, "tml_trns_mod_cd") == 'Mother') {
            sheetObj.SetCellValue(i, "tml_trns_mod_cd", 'V');
        } else if (sheetObj.GetCellValue(i, "tml_trns_mod_cd") == 'Rail') {
            sheetObj.SetCellValue(i, "tml_trns_mod_cd", 'R');
        } else if (sheetObj.GetCellValue(i, "tml_trns_mod_cd") == 'Truck') {
            sheetObj.SetCellValue(i, "tml_trns_mod_cd", 'T');
        } else if (sheetObj.GetCellValue(i, "tml_trns_mod_cd") == 'Barge') {
            sheetObj.SetCellValue(i, "tml_trns_mod_cd", 'B');
        } else if (sheetObj.GetCellValue(i, "tml_trns_mod_cd") == 'Other') {
            sheetObj.SetCellValue(i, "tml_trns_mod_cd", 'O');
        } else if (sheetObj.GetCellValue(i, "tml_trns_mod_cd") == 'Same') {
            sheetObj.SetCellValue(i, "tml_trns_mod_cd", 'S');
        } else if (sheetObj.GetCellValue(i, "tml_trns_mod_cd") == 'Feeder') {
            sheetObj.SetCellValue(i, "tml_trns_mod_cd", 'F');
        }

        if (sheetObj.GetCellValue(i, "lane_cd") == 'Sam') {
            sheetObj.SetCellValue(i, "lane_cd", '');
        }

        targetSheetObj.SetCellValue(idx, "tml_trns_mod_cd", sheetObj.GetCellValue(i, "tml_trns_mod_cd"));
        targetSheetObj.SetCellValue(idx, "lane_cd", sheetObj.GetCellValue(i, "lane_cd"));
        targetSheetObj.SetCellValue(idx, "sub_trd_cd", sheetObj.GetCellValue(i, "sub_trd_cd"));
        targetSheetObj.SetCellValue(idx, "tier", sheetObj.GetCellValue(i, "tier"));
        targetSheetObj.SetCellValue(idx, "calc_vol_qty", sheetObj.GetCellValue(i, "calc_vol_qty"),0);
        targetSheetObj.SetCellValue(idx, "rvis_vol_qty", sheetObj.GetCellValue(i, "rvis_vol_qty"),0);
        targetSheetObj.SetCellValue(idx, "stay_days", sheetObj.GetCellValue(i, "stay_days"));
        targetSheetObj.SetCellValue(idx, "vol_tr_ut_cd", sheetObj.GetCellValue(i, "vol_tr_ut_cd"));
        targetSheetObj.SetCellValue(idx, "ctrt_rt", sheetObj.GetCellValue(i, "ctrt_rt"),0);
        targetSheetObj.SetCellValue(idx, "inv_amt", sheetObj.GetCellValue(i, "inv_amt"),0);
        targetSheetObj.SetCellValue(idx, "curr_cd", sheetObj.GetCellValue(i, "curr_cd"));

        targetSheetObj.SetCellValue(idx, 'calc_cost_grp_cd', 'TM');
        targetSheetObj.SetCellValue(idx, 'inv_xch_rt', sheetObj.GetCellValue(i, "inv_xch_rt"),0);
        
        
        targetSheetObj.SetCellValue(idx, 'vsl_cd',      tmpVslCd);
        targetSheetObj.SetCellValue(idx, 'skd_voy_no',  tmpSkdVoyNo);
        targetSheetObj.SetCellValue(idx, 'skd_dir_cd',  tmpSkdDirCd);
        targetSheetObj.SetCellValue(idx, 'atb_dt',      tmpAtbDt);
        /*
        targetSheetObj.SetCellValue(idx, 'vsl_cd', vvd_hidden.GetCellValue(vvd_row, "vvd_vsl_cd"));
        targetSheetObj.SetCellValue(idx, 'skd_voy_no', vvd_hidden.GetCellValue(vvd_row, "vvd_skd_voy_no"));
        targetSheetObj.SetCellValue(idx, 'skd_dir_cd', vvd_hidden.GetCellValue(vvd_row, "vvd_skd_dir_cd"));
        targetSheetObj.SetCellValue(idx, 'atb_dt', vvd_hidden.GetCellValue(vvd_row, "vvd_atb_dt"));
        */
        
        targetSheetObj.SetCellValue(idx, 'tml_crr_cd', "");
        targetSheetObj.SetCellValue(idx, 'semi_auto_calc_flg', 'Y');

        targetSheetObj.SetCellValue(idx, "calc_rmk", sheetObj.GetCellValue(i, "agmt_dtl_rmk"));

        setShtCellsEditable(targetSheetObj, idx, 'lgs_cost_cd|cntr_tpsz_cd|dcgo_ind_cd|tml_wrk_dy_cd|ioc_cd|tml_trns_mod_cd|lane_cd|vol_tr_ut_cd|rvis_vol_qty|ctrt_rt|calc_vol_qty|inv_xch_rt|inv_amt|rc_flg', 'Y', 'EXCEPTION');

    }
    ShowCalculatedAmountByVVD();
}

/**
 * Currency Code change
 */
function atb_dt_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) {
    //alert("atb_dt_OnChange OldIndex["+OldIndex+"] \n OldText["+OldText+"]\n OldCode["+OldCode+"]\n NewIndex["+NewIndex+"]\n NewText["+OldCode+"]\n NewCode["+NewCode+"]");
	
	//[0] : VVD TYPE, [1] : ATB_DT, [2]: REV_YRMON, [3]: CALL_YD_IND_SEQ
	//var tempArr = document.form.atb_dt.value.split("|");
    //document.form.vvd_type.value = tempArr[0]; 
	//document.form.call_yd_ind_seq.value = tempArr[3];
	
    //2016.07.13 Add
	var tmpArr = getAtbDtComboItem(NewIndex);
	ComSetObjValue(document.form.vvd_type          , tmpArr[0]);
	ComSetObjValue(document.form.call_yd_ind_seq   , tmpArr[3]);
}


/**
 * @param {obj}    Text Value
 **/
function isApNum2(obj) {
    obj.value = obj.value.toUpperCase();
}

/**
 * 2016.07.13 Add
 * Atb Dt String Data && Combo Item Init
 */
function initAtbDtComboItem(){
    gAtbDtComboItems = "";  //atb_dt combo item string data init
    atb_dt.RemoveAll();     // atb_dt combo item init.
}
function initAtbDtComboItemByVvdHidden(sheetObj, Row){
    //atb_dt.RemoveAll(); //2016-06-16 수정
    var tmpVvdType      = sheetObj.GetCellValue(Row, "vvd_type");
    var tmpAtdDt        = sheetObj.GetCellValue(Row, "vvd_atb_dt");
    var tmpRevYrmon     = sheetObj.GetCellValue(Row, "rev_yrmon");
    var tmpCallYdIndSeq = sheetObj.GetCellValue(Row, "vvd_call_yd_ind_seq");

    initAtbDtComboItem(); //2016.07.13 Add
    //2016.07.13 Add AtbDt외 Combo 코드를 가지고 전역변수 데이타를 만들어 준다.
    setMakeAtbDtComboItem(tmpVvdType, tmpAtdDt, tmpRevYrmon, tmpCallYdIndSeq);
    
    atb_dt.InsertItem(0, tmpAtdDt, tmpAtdDt);
    atb_dt.SetSelectIndex(0);
}
/**
 * ATD DT Combo Item의 String Data Append.
 * @param vvd_type : type
 * @param atb_dt   : YYYY-MM-DD
 * @param rev_yrmon : NULL or YYYY-MM
 * @param call_yd_ind_seq : NULL or Number(1,2,....)
 */
function setMakeAtbDtComboItem(vvd_type, atb_dt, rev_yrmon, call_yd_ind_seq){
    if(!ComIsEmpty(gAtbDtComboItems)){
        gAtbDtComboItems +="#";
    }
    gAtbDtComboItems +=vvd_type+"|";
    gAtbDtComboItems +=atb_dt+"|";
    gAtbDtComboItems +=rev_yrmon+"|";
    gAtbDtComboItems +=call_yd_ind_seq;
}
/**
 * 2016.07.13 Add
 * Atb Dt의 xml Data에서 선택된 Index의 데이타를 배열로 리턴한다.
 */
function getAtbDtComboItem(selIdx){
    //[0] : Type, [1] : ATB_DT, [2] : REV_YRMON, [3] : CALL_YD_IND_SEQ
    var rtnArray = new Array("", "", "", "");
    
    if(gAtbDtComboItems == "") return rtnArray; //빈값을 넘김.
    
    var atbDtRowItems = gAtbDtComboItems.split('#');
    
    for (var i = 0; i < atbDtRowItems.length; i++) {
        if(i == selIdx){
            var tempArr = atbDtRowItems[i].split('|');
            rtnArray[0] = tempArr[0]; //VVD TYPE
            rtnArray[1] = tempArr[1]; //ATB_DT
            rtnArray[2] = tempArr[2]; //REV_YRMON
            rtnArray[3] = tempArr[3]; //CALL_YD_IND_SEQ
        }
    }
    return rtnArray;
}

//2016.10.11 Currency FormToSheet Add
function setDefaultCurrencyFormToSheet(sheetObj, row, colName){
    var formObj = document.form;
    
    var formCurrCd = ComGetObjValue(formObj.curr_cd);
    
    sheetObj.SetCellValue(row, colName, formCurrCd, 0);
}