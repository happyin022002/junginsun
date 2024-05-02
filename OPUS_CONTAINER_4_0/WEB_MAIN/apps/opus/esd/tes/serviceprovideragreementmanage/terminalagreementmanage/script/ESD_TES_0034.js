/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TES_0034.js
*@FileTitle  : AGMT Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/23
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// global variable
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var sheetObjects = new Array();
var sheetCnt = 0;

//var stoTotalErrCount	= 0;

var comboObjects = new Array();
var comboCnt = 0;
var verifyObjects = "";
var thrpCostFlg = "";
var doActionIBSheet6SearchFlg = "";
var tab2VerifyFlg = false; ///"";
var tab4VerifyFlg = false; // "";
var tab5VerifyFlg = false; // ""; 
var tab2VerifyCount = "";
var tab4VerifyCount = "";
var tab5VerifyCount = "";
var costCodeT = "";
var costCodeS = "";
var lgsCostCDSheet = "";
var terminalLgsCostCDSheet = "";
var storageLgsCostCDSheet = "";
var tplgsCostCDSheet = "";
var currCDSheet = "";
var laneCDSheet1 = "";
var laneCDSheet2 = "";
var agmtNoCopy = "";
var agmtVerCopy = "";
var dataTerminalErrCount = 0;
var dataStorageErrCount = 0;
var agmtRegFlg = "";
var hdrRetrieveFlg = "";
var currCodeDef = "";

var gap_tm = 2; //terminal full empty
var gap_st = 1; //storage full empty
var gap_eq = 0; //eq strorage full empty

var subTrdTxt = "";
var subTrdSheet = "";
var tempSubTrdTxt = "";

/**
 * // Event handler processing by button click event 
 */
document.onclick = processButtonClick;

/**
 * Event handler processing by button name 
 */
function processButtonClick() {
    /***** using extra sheet valuable if there are more 2 sheets *****/
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];
    var sheetObject3 = sheetObjects[3];
    var sheetObject4 = sheetObjects[4];
    var sheetObject5 = sheetObjects[5]; //t1sheet3
    var sheetObject6 = sheetObjects[6];
    var sheetObject7 = sheetObjects[7];
    var sheetObject8 = sheetObjects[8];
    /*******************************************************/
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        if (srcName == "cntr_ts" && document.form.cntr_ts[2].disabled == false) {} else if (ComGetBtnDisable(srcName)) return false;

        switch (srcName) {
            case "btn_retrieve":
                //sheetObject2.RemoveAll();
                if (ComIsNull(formObject.yd_cd.value)) {
                    ComShowCodeMessage('TES10009'); //Please enter Yard Code.
                    formObject.yd_cd.focus();
                    return false;
                }
                
                if (ComIsNull(formObject.yd_cd_name.value)) {
                    ComShowCodeMessage('TES10010'); //There is no Yard Code Name.\n\n Please enter Yard Code again.
                    formObject.yd_cd.focus();
                    return false;
                }
                
                if (ComIsNull(formObject.vndr_seq.value)) {
                    ComShowCodeMessage('TES10011'); //Please enter Service Provider Code.
                    formObject.vndr_seq.focus();
                    return false;
                }
                
                if (formObject.inquiryFlg.value != "Y") {
                    if (formObject.vndr_seq_name.value == "") {
                        ComShowCodeMessage('TES10011'); //Please enter Service Provider Code.
                        return false;
                    }
                }
                
                switch (tabObjects[0].GetSelectedIndex()) {
                    case 0:
                        formObject.tml_agmt_tp_cd.value = "T";
                        formObject.f_cmd.value = SEARCH;
                        doActionIBSheet6(sheetObject5, formObject, IBSEARCH);
                        if (doActionIBSheet6SearchFlg != "NoData") {
                            doActionIBSheet3(sheetObject2, formObject, IBSEARCH);
                        }
                        formObject.tml_agmt_tp_cd.value = "S";
                        formObject.f_cmd.value = SEARCH;
                        if (doActionIBSheet6SearchFlg != "NoData") {
                            doActionIBSheet5(sheetObject4, formObject, IBSEARCH);
                        }
                        break;

                    case 1:
                        formObject.tml_agmt_tp_cd.value = "T";
                        formObject.f_cmd.value = SEARCH;
                        doActionIBSheet6(sheetObject5, formObject, IBSEARCH);
                        if (doActionIBSheet6SearchFlg != "NoData") {
                            doActionIBSheet3(sheetObject2, formObject, IBSEARCH);
                        }
                        formObject.tml_agmt_tp_cd.value = "S";
                        formObject.f_cmd.value = SEARCH;
                        if (doActionIBSheet6SearchFlg != "NoData") {
                            doActionIBSheet5(sheetObject4, formObject, IBSEARCH);
                        }
                        formObject.tml_agmt_tp_cd.value = "E";
                        formObject.f_cmd.value = SEARCH;
                        if (doActionIBSheet6SearchFlg != "NoData") {
                            doActionIBSheet9(sheetObject8, formObject, IBSEARCH);
                        }
                        break;

                    case 2:
                        formObject.tml_agmt_tp_cd.value = "S";
                        formObject.f_cmd.value = SEARCH;
                        doActionIBSheet6(sheetObject5, formObject, IBSEARCH);
                        if (doActionIBSheet6SearchFlg != "NoData") {
                            doActionIBSheet5(sheetObject4, formObject, IBSEARCH);
                        }
                        formObject.tml_agmt_tp_cd.value = "T";
                        formObject.f_cmd.value = SEARCH;
                        if (doActionIBSheet6SearchFlg != "NoData") {
                            doActionIBSheet3(sheetObject2, formObject, IBSEARCH);
                        }
                        formObject.tml_agmt_tp_cd.value = "E";
                        formObject.f_cmd.value = SEARCH;
                        if (doActionIBSheet6SearchFlg != "NoData") {
                            doActionIBSheet9(sheetObject8, formObject, IBSEARCH);
                        }
                        break;

                    case 3:
                        formObject.tml_agmt_tp_cd.value = "S";
                        formObject.f_cmd.value = SEARCH;
                        doActionIBSheet6(sheetObject5, formObject, IBSEARCH);
                        if (doActionIBSheet6SearchFlg != "NoData") {
                            doActionIBSheet5(sheetObject4, formObject, IBSEARCH);
                        }
                        formObject.tml_agmt_tp_cd.value = "T";
                        formObject.f_cmd.value = SEARCH;
                        if (doActionIBSheet6SearchFlg != "NoData") {
                            doActionIBSheet3(sheetObject2, formObject, IBSEARCH);
                        }

                        formObject.tml_agmt_tp_cd.value = "E";
                        formObject.f_cmd.value = SEARCH;
                        if (doActionIBSheet6SearchFlg != "NoData") {
                            doActionIBSheet9(sheetObject8, formObject, IBSEARCH);
                        }

                    case 4:
                        formObject.tml_agmt_tp_cd.value = "S";
                        formObject.f_cmd.value = SEARCH;
                        doActionIBSheet6(sheetObject5, formObject, IBSEARCH);
                        if (doActionIBSheet6SearchFlg != "NoData") {
                            doActionIBSheet5(sheetObject4, formObject, IBSEARCH);
                        }
                        formObject.tml_agmt_tp_cd.value = "T";
                        formObject.f_cmd.value = SEARCH;
                        if (doActionIBSheet6SearchFlg != "NoData") {
                            doActionIBSheet3(sheetObject2, formObject, IBSEARCH);
                        }
                        formObject.tml_agmt_tp_cd.value = "E";
                        formObject.f_cmd.value = SEARCH;
                        if (doActionIBSheet6SearchFlg != "NoData") {
                            doActionIBSheet9(sheetObject8, formObject, IBSEARCH);
                        }
                        break;
                }
                break;

            case "btn_new":
                agmt_no = "";
                agmtRegFlg = "";
                hdrRetrieveFlg = "";
                formObject.reset();
                formObject.inquiryFlg.value = "";
                formObject.tml_agmt_sts_cd.value = "";
                initFormValue();
                initFormDisabled();
                document.form.yd_cd_hidden.value = '';
                //      	            document.form.vndr_seq_hidden.value="";

                sheetObject.RemoveAll();
                sheetObject1.RemoveAll();
                sheetObject2.RemoveAll();
                sheetObject3.RemoveAll();
                sheetObject4.RemoveAll();
                sheetObject5.RemoveAll();
                sheetObject8.RemoveAll();
                formObject.yd_cd.readOnly = false;
                formObject.vndr_seq.readOnly = false;
                formObject.ctrt_ofc_cd.readOnly = false;
                formObject.amend_flg[0].disabled = true;
                formObject.amend_flg[1].disabled = true;
                break;

            case "btn_delete":
                if ((formObject.tml_agmt_ofc_cty_cd.value != "" ||
                        formObject.tml_agmt_ofc_cty_cd.value != null) &&
                    formObject.tml_agmt_ver_no.value != "" &&
                    formObject.yd_cd.value != "" &&
                    formObject.vndr_seq.value != "") {
                    removeAgreementHDR();
                } else {
                    ComShowCodeMessage('TES10003'); //There is no Agreement to be deleted.
                }
                break;

            case "btn_volcaam":
                ComOpenWindow("ESD_TES_9200.do", window, "dialogWidth:610px;dialogHeight:650px;help:no;status:no;resizable:yes;", true);
                break;

            case "btn_yard":
                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                var classId = "COM_ENS_061";
                var param = '?classId=' + classId;
                var chkStr = dispaly.substring(0, 3)
                    // radio PopUp
                if (chkStr == "1,0") {
                    ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 770, 500, 'getYard', dispaly);
                } else {
                    ComShowCodeMessage('TES10004'); //There is lack of data for pop-up display.
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
                    ComShowCodeMessage('TES10004'); //There is lack of data for pop-up display.
                    return;
                }
                break;

            case "btns_calendar1":
                var cal = new ComCalendar(); //calendarPopup();
                cal.select(formObject.eff_fm_dt, 'yyyy-MM-dd');
                break;

            case "btns_calendar2":
                var cal = new ComCalendar();
                cal.select(formObject.eff_to_dt, 'yyyy-MM-dd');
                break;

            case "btn_save":
                if (ComIsNull(formObject.yd_cd.value)) {
                    ComShowCodeMessage('TES10009'); //Please enter Yard Code.
                    return false;
                }
                if (ComIsNull(formObject.yd_cd_name.value)) {
                    ComShowCodeMessage('TES10010'); //There is no Yard Code Name.\n\n Please enter Yard Code again.
                    return false;
                }
                if (ComIsNull(formObject.vndr_seq.value)) {
                    ComShowCodeMessage('TES10011'); //Please enter Service Provider Code.
                    return false;
                }
                if (ComIsNull(formObject.ctrt_ofc_cd.value)) {
                    ComShowCodeMessage('TES10023'); // Please enter Contract Office.
                    return false;
                }
                if (formObject.inquiryFlg.value != "Y") {
                    if (formObject.vndr_seq_name.value == "") {
                        ComShowCodeMessage('TES10011'); //Please enter Service Provider Code.
                        return false;
                    }
                }
                if (agmtRegFlg == "N") {
                    ComShowCodeMessage('TES10095'); //These are saving canceled Yard code and vendor SEQ.\n\n Please check again.
                    return false;
                }
                if (hdrRetrieveFlg != "Y") {
                    ComShowCodeMessage('TES10096'); //Please check Agreement after Retrieve.
                    return false;
                }
                if (ComIsNull(formObject.eff_fm_dt.value)) {
                    ComShowCodeMessage('TES10024'); //Please enter Effective Date.
                    formObject.eff_fm_dt.focus();
                    return false;
                }
                if (!ComIsDate(formObject.eff_fm_dt)) {
                    ComShowCodeMessage('TES10013'); //Date is not correct.
                    formObject.eff_fm_dt.focus();
                    return false;
                }
                if (!checkEffFormat(formObject.eff_fm_dt.value)) {
                    ComShowCodeMessage('TES10013'); //Date is not correct.
                    formObject.eff_fm_dt.focus();
                    return false;
                }
                if (ComIsNull(formObject.eff_to_dt.value)) {
                    ComShowCodeMessage('TES10013'); //Date is not correct.
                    formObject.eff_to_dt.focus();
                    return false;
                }
                if (!ComIsDate(formObject.eff_to_dt)) {
                    ComShowCodeMessage('TES10013'); //Date is not correct.
                    formObject.eff_to_dt.focus();
                    return false;
                }
                if (!checkEffFormat(formObject.eff_to_dt.value)) {
                    ComShowCodeMessage('TES10013'); //Date is not correct.
                    formObject.eff_to_dt.focus();
                    return false;
                }
                if (ComIsNull(getElementValue(formObject, 'radio', 'auto_xtd_flg'))) {
                    ComShowCodeMessage('TES10014'); //Please check Auto Ext.
                    return false;
                }
                var agmtHdrRmkFlg = "";
                if (formObject.tml_agmt_sts_cd.value == "") {
                    var iRow = 1;
                    sheetObjects[5].SetRowStatus(iRow, "I");
                    sheetObjects[5].SetCellValue(iRow, "yd_cd", formObject.yd_cd.value, 0); // 3
                    sheetObjects[5].SetCellValue(iRow, "yd_nm", formObject.yd_cd_name.value, 0); // 4
                    sheetObjects[5].SetCellValue(iRow, "vndr_seq", formObject.vndr_seq.value, 0); // 5
                    sheetObjects[5].SetCellValue(iRow, "vndr_lgl_eng_nm", formObject.vndr_seq_name.value, 0); // 6
                    sheetObjects[5].SetCellValue(iRow, "ctrt_ofc_cd", formObject.ctrt_ofc_cd.value, 0); // 7
                    sheetObjects[5].SetCellValue(iRow, "eff_fm_dt", formObject.eff_fm_dt.value, 0); // 8
                    sheetObjects[5].SetCellValue(iRow, "eff_to_dt", formObject.eff_to_dt.value, 0); // 9
                    sheetObjects[5].SetCellValue(iRow, "auto_xtd_flg", getElementValue(formObject, 'radio', 'auto_xtd_flg'), 0); // 10
                    sheetObjects[5].SetCellValue(iRow, "agmt_rmk", formObject.agmt_rmk.value, 0); // 12
                    if (agmtRegFlg == "Y") {
                        topBtnSave_OnlyTopSave();
                        agmtRegFlg = "";
                    }
                } else if (formObject.tml_agmt_sts_cd.value == "C") {
                    // 8, 9, 10, 12
                    if (sheetObjects[5].GetCellValue(1, "eff_fm_dt") == formObject.eff_fm_dt.value &&
                        sheetObjects[5].GetCellValue(1, "eff_to_dt") == formObject.eff_to_dt.value &&
                        sheetObjects[5].GetCellValue(1, "auto_xtd_flg") == getElementValue(formObject, 'radio', 'auto_xtd_flg') &&
                        getElementValue(formObject, 'radio', 'amend_flg') == "N" &&
                        sheetObjects[5].GetCellValue(1, "agmt_rmk").trim() != formObject.agmt_rmk.value.trim()) {
                        agmtHdrRmkFlg = "Y";
                    } else {
                        agmtHdrRmkFlg = "N";
                    }
                    if (agmtHdrRmkFlg == "Y") {
                        topBtnSave_RmkSave();
                    } else if (agmtHdrRmkFlg == "N") {
                        topBtnSave_Confirm();
                    }
                } else if (formObject.tml_agmt_sts_cd.value == "P") {
                    topBtnSave_Process();
                }
                break;

            case "t1btng_retreive1":
                doActionIBSheet(sheetObject, formObject, IBINSERT);
                break;

            case "t1btng_retreive2":
                doActionIBSheet2(sheetObject1, formObject, IBINSERT);
                break;

            case "t1btng_registertpcc":
                if (formObject.tml_agmt_sts_cd.value != "") {
                    //	                        if(sheetObjects[5].CellValue(1, 1) == "" || sheetObjects[5].CellValue(1, 2) == ""){
                    if (sheetObjects[5].GetCellValue(1, "tml_agmt_ofc_cty_cd") == "") {
                        ComShowCodeMessage('TES10005'); //There is no mandatory item.\n\n Please check again.
                        return false;
                    }
                    var display = "0,0,0, 0";
                    ComOpenPopup('ESD_TES_9180.do?cost_cd=' + document.form.lgs_cost_cd_t.value + '&agmt_no=' + document.form.tml_agmt_ofc_cty_cd.value + '&agmt_ver_no=' + document.form.tml_agmt_ver_no.value, 550, 480, '', 'none', false);

                    //ComOpenPopup('ESD_TES_9180.do?cost_cd='+document.form.lgs_cost_cd_t.value+'&agmt_no='+document.form.tml_agmt_ofc_cty_cd.value+'&agmt_ver_no='+document.form.tml_agmt_ver_no.value, 400, 430, '', display, true);
                } else {
                    ComShowCodeMessage('TES10007'); //Agreement header information is not entered/saved.\n\n Please check again.
                }
                break;

            case "t1btng_agmtcopy":
                var dispaly = "none"; //com_ens_051_dispaly.value;
                var classId = "ESD_TES_9070";
                var param = '?classId=' + classId;
                ComOpenPopup('/opuscntr/ESD_TES_9070.do' + param, 570, 500, '', dispaly, true);
                //ComOpenWindow("ESD_TES_9070.do",  window,  "dialogWidth:500px; dialogHeight:50px; help:no; status:no; resizable:no; scrollbars:no;" , false);
                //ComOpenWindow("ESD_TES_9070.do" + param,  window,  "dialogWidth:570px;dialogHeight:600px;help:no;status:no;resizable:yes;" , true);
                break;

            case "t1btng_new":
                initformTerminalDTLs();
                sheetObject.RemoveAll();
                sheetObject1.RemoveAll();
                break;

            case "t1btng_save":
                var iRow = "1";
                sheetObjects[5].SetRowStatus(iRow, "U"); // 0
                sheetObjects[5].SetCellValue(iRow, "lgs_cost_cd", formObject.lgs_cost_cd_t.value, 0); // 13
                sheetObjects[5].SetCellValue(iRow, "auto_calc_flg", getElementValue(formObject, 'radio', 'auto_calc_flg'), 0); //14
                sheetObjects[5].SetCellValue(iRow, "tml_agmt_vol_ut_cd", formObject.tml_agmt_vol_ut_cd[1].value, 0); // 15
                sheetObjects[5].SetCellValue(iRow, "curr_cd", formObject.curr_cd_t.value, 0); // 16
                sheetObjects[5].SetCellValue(iRow, "cmnc_hrmnt", "T", 0); // 19
                if (comboObjects[0].GetSelectCode() == "" || comboObjects[0].GetSelectCode() == undefined) {
                    ComShowCodeMessage('TES10016'); //Please select Cost code.
                    return false;
                }
                if (ComIsNull(formObject.tml_agmt_vol_ut_cd[1].value)) {
                    ComShowCodeMessage('TES10017'); //Please select Vol. UOM.
                    return false;
                }
                if (ComIsNull(formObject.curr_cd_t.value)) {
                    ComShowCodeMessage('TES10018'); //Please select Currency.
                    return false;
                }
                formObject.tml_agmt_tp_cd.value = "T";
                formObject.tml_agmt_vol_ut_cd[0].value = formObject.tml_agmt_vol_ut_cd[1].value;
                formObject.curr_cd.value = comboObjects[1].GetSelectCode();
                formObject.lgs_cost_cd.value = comboObjects[0].GetSelectCode();
                if (formObject.tml_agmt_sts_cd.value != "") {
                    if (comboObjects[0].GetSelectCode().substring(0, 2) == "TP") {
                        formObject.f_cmd.value = SEARCH01;
                        //sheetObjects[6].DoSearch("ESD_TES_ThrpccGS.do", tesFrmQryStr(formObject) );

                        var sXml = sheetObjects[6].GetSearchData("ESD_TES_ThrpccGS.do", tesFrmQryStr(formObject));
                        sheetObjects[6].LoadSearchData(sXml, { Sync: 1 });

                        var thrp_gb;
                        if (formObject.thrpFlg.value != "Y") {
                            thrp_gb = ComShowConfirm(ComGetMsg('TES10019')); //There is no registered Cost Code with the Throughput Rate.\n\n Do you want to register now?
                            if (thrp_gb == true) {
                                ComOpenPopup('ESD_TES_9180.do?cost_cd="' + document.form.lgs_cost_cd_t.value + '"&agmt_no="' + document.form.tml_agmt_ofc_cty_cd.value + '"&agmt_ver_no="' + document.form.tml_agmt_ver_no.value + '"', 550, 480, '', "none", false);
                            }
                        } else {
                            formObject.f_cmd.value = MULTI01;
                            doActionIBSheet6(sheetObject5, formObject, IBSAVE);
                        }
                    } else {
                        formObject.f_cmd.value = MULTI01;
                        doActionIBSheet6(sheetObject5, formObject, IBSAVE);
                    }
                } else {
                    ComShowCodeMessage('TES10020'); //There is no Agreement header information.\n\n Please check again.
                }
                break;

            case "t1btng_apply":
                if (ComIsNull(formObject.yd_cd.value)) {
                    ComShowCodeMessage('TES10009'); //Please enter Yard Code.
                    return false;
                }
                if (ComIsNull(formObject.vndr_seq.value)) {
                    ComShowCodeMessage('TES10011'); //Please enter Service Provider Code.
                    return false;
                }
                if (ComIsNull(formObject.ctrt_ofc_cd.value)) {
                    ComShowCodeMessage('TES10023'); //Please enter Contract Office.
                    return false;
                }
                if (ComIsNull(formObject.eff_fm_dt.value)) {
                    ComShowCodeMessage('TES10024'); //Please enter Effective Date.
                    return false;
                }
                if (ComIsNull(formObject.eff_to_dt.value)) {
                    ComShowCodeMessage('TES10024'); //Please enter Effective Date.
                    return false;
                }
                if (ComIsNull(getElementValue(formObject, 'radio', 'auto_xtd_flg'))) {
                    ComShowCodeMessage('TES10014'); //Please check Auto Ext.
                    return false;
                }
                if (ComIsNull(formObject.lgs_cost_cd_t.value)) {
                    ComShowCodeMessage('TES10016'); //Please select Cost code.
                    return false;
                }
                if (ComIsNull(formObject.tml_agmt_vol_ut_cd[1].value)) {
                    ComShowCodeMessage('TES10017'); //Please select Vol. UOM.
                    return false;
                }
                if (ComIsNull(formObject.curr_cd_t.value)) {
                    ComShowCodeMessage('TES10018'); //Please select Currency.
                    return false;
                }
                if (agreementVaildate(verifyObjects)) {
                    if (formObject.tml_agmt_vol_ut_cd[1].value == "C") {
                        if (ComIsNull(getElementValue(formObject, 'radio', 'cntr_ts'))) {
                            ComShowCodeMessage('TES10026'); //Please select container Type/Size.
                            return false;
                        }
                    }
                    if (ComIsNull(formObject.agmt_rate.value)) {
                        ComShowCodeMessage('TES10027'); //Please enter Rate.
                        return false;
                    }
                    sheetObject6.RemoveAll();
                    if (formObject.lgs_cost_cd_t.value.substring(0, 2) != "TP") {
                        formObject.lgs_cost_cd.value = formObject.lgs_cost_cd_t.value;
                        doActionIBSheet7(sheetObject6, formObject, IBSEARCH);
                    }
                    // Terminal Rate Input To Terminal Rate List Data Insert ( ESD_TES_AGMTINPUTLIST.js )
                    terminalRateInputList();
                    tabObjects[0].SetSelectedIndex(1);
                }
                break;

            case "t2btng_rowadd":
                doActionIBSheet3(sheetObject2, formObject, IBINSERT);
                break;

            case "t2btng_save":
                if (ComIsNull(formObject.yd_cd.value)) {
                    ComShowCodeMessage('TES10009');
                    return false;
                }
                if (ComIsNull(formObject.yd_cd_name.value)) {
                    ComShowCodeMessage('TES10010');
                    return false;
                }
                if (ComIsNull(formObject.vndr_seq.value)) {
                    ComShowCodeMessage('TES10011');
                    return false;
                }
                if (formObject.inquiryFlg.value != "Y") {
                    if (formObject.vndr_seq_name.value == "") {
                        ComShowCodeMessage('TES10011');
                        return false;
                    }
                }
                if (agmtRegFlg == "N") {
                    ComShowCodeMessage('TES10095');
                    return false;
                }
                if (hdrRetrieveFlg != "Y") {
                    ComShowCodeMessage('TES10096');
                    return false;
                }
                if (ComIsNull(formObject.eff_fm_dt.value)) {
                    ComShowCodeMessage('TES10012');
                    formObject.eff_fm_dt.focus();
                    return false;
                }
                if (!ComIsDate(formObject.eff_fm_dt)) {
                    ComShowCodeMessage('TES10013');
                    formObject.eff_fm_dt.focus();
                    return false;
                }
                if (!checkEffFormat(formObject.eff_fm_dt.value)) {
                    ComShowCodeMessage('TES10013');
                    formObject.eff_fm_dt.focus();
                    return false;
                }
                if (ComIsNull(formObject.eff_to_dt.value)) {
                    ComShowCodeMessage('TES10012');
                    formObject.eff_to_dt.focus();
                    return false;
                }
                if (!ComIsDate(formObject.eff_to_dt)) {
                    ComShowCodeMessage('TES10013'); //Date is not correct.
                    formObject.eff_to_dt.focus();
                    return false;
                }
                if (!checkEffFormat(formObject.eff_to_dt.value)) {
                    ComShowCodeMessage('TES10013'); //Date is not correct.
                    formObject.eff_to_dt.focus();
                    return false;
                }
                if (ComIsNull(getElementValue(formObject, 'radio', 'auto_xtd_flg'))) {
                    ComShowCodeMessage('TES10014'); //Please check Auto Ext.
                    return false;
                }
                if (formObject.tml_agmt_sts_cd.value == "") {
                    var iRow = 1;
                    sheetObjects[5].SetRowStatus(iRow, "I"); // 0
                    sheetObjects[5].SetCellValue(iRow, "yd_cd", formObject.yd_cd.value, 0); // 3
                    sheetObjects[5].SetCellValue(iRow, "yd_nm", formObject.yd_cd_name.value, 0); // 4
                    sheetObjects[5].SetCellValue(iRow, "vndr_seq", formObject.vndr_seq.value, 0); // 5
                    sheetObjects[5].SetCellValue(iRow, "vndr_lgl_eng_nm", formObject.vndr_seq_name.value, 0); // 6
                    sheetObjects[5].SetCellValue(iRow, "ctrt_ofc_cd", formObject.ctrt_ofc_cd.value, 0); // 7
                    sheetObjects[5].SetCellValue(iRow, "eff_fm_dt", formObject.eff_fm_dt.value, 0); // 8
                    sheetObjects[5].SetCellValue(iRow, "eff_to_dt", formObject.eff_to_dt.value, 0); // 9
                    sheetObjects[5].SetCellValue(iRow, "auto_xtd_flg", getElementValue(formObject, 'radio', 'auto_xtd_flg'), 0); // 10
                    sheetObjects[5].SetCellValue(iRow, "agmt_rmk", formObject.agmt_rmk.value, 0); // 12
                    topBtnSave_OnlyTopSave();
                } else if (formObject.tml_agmt_sts_cd.value == "C") {
                    topBtnSave_Confirm();
                } else if (formObject.tml_agmt_sts_cd.value == "P") {
                    topBtnSave_Process();
                }
                break;

            case "t2btng_new":
                sheetObject2.RemoveAll();
                break;

            case "t2btng_delete":
                var t2sheet1DelCount = 0;
                for (var i = 0; i < sheetObject2.RowCount(); i++) {
                    if (sheetObject2.GetCellValue(i + 3, 0) == 1) {
                        t2sheet1DelCount++;
                    }
                }
                if (t2sheet1DelCount > 0) {
                    rowDelete();
                    delete_Process();
                } else {
                    ComShowCodeMessage('TES10097'); //There is no date to delete.\n\n Please check again.
                }
                break;

            case "t2btng_downexcel":
                if (sheetObject2.RowCount() < 1) { //no data
                    ComShowCodeMessage("COM132501");
                } else {
                    doActionIBSheet3(sheetObject2, formObject, IBDOWNEXCEL);
                }

                break;

            case "t2btng_loadexcel":
                if (formObject.tml_agmt_sts_cd.value != "" && formObject.tml_agmt_ofc_cty_cd.value != "" && formObject.tml_agmt_ver_no.value != "") {
                    var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                    var classId = "ESD_TES_9160";
                    var param = '?classId=' + classId + "&sub_trd_cd=" + subTrdSheet + "&sub_trd_txt=" + subTrdTxt;

                    //						ComOpenPopup('/opuscntr/ESD_TES_9070.do' +param, 450, 470, '', dispaly, true); 
                    //						ComOpenWindow("ESD_TES_9160.do",  window,  "dialogWidth:710px; dialogHeight:600px; help:no; status:no; resizable:yes;" , true);
                    ComOpenPopup('/opuscntr/ESD_TES_9160.do' + param, 1000, 520, '', dispaly, true);
                } else {
                    ComShowCodeMessage('TES10030'); //There is no data on Load EXCEL.\n\n Please check again.
                }
                break;

            case "t2btng_verify":
                t2btng_verify(formObject, sheetObjects, sheetObject2, sheetObject7);
                /*var beforeibflag=new Array();
					if(formObject.tml_agmt_sts_cd.value!="" && formObject.tml_agmt_ofc_cty_cd.value!="" && formObject.tml_agmt_ver_no.value!="" && (sheetObjects[2].RowCount()>0)){
						if(dupRowCheck('T')==false){
							return false;
						}
						sheetObjects[2].ColumnSort("3lgs_cost_cd|3io_bnd_cd|3ioc_cd|3tml_dy_aply_tp_cd|3lane_cd|3dcgo_aply_tp_cd|3tml_vol_aply_tp_cd|3fm_tr_vol_val|3to_tr_vol_val|3tml_ovt_shft_cd|3thc_tp_cd", "ASC");
						for(i=0;i<sheetObject2.RowCount();i++){
							beforeibflag[i]=sheetObject2.GetRowStatus(i+3);
            			  }
						doActionIBSheet8(sheetObject7,formObject,IBSEARCH);
						if(dataTerminalErrCount>0){
							ComShowCodeMessage('TES10031');   //Please modify Terminal Rate List Sheet Data.
						} else {
							sheetObjects[2].ColumnSort("3auto_calc_flg", "DESC");
							tab2VerifyFlg=terminalRateListVerify_test1(beforeibflag);
							if(tab2VerifyFlg){
								ComShowCodeMessage('TES10032');    //Terminal Rate List Verify has been completed.
							} else {
								ComShowCodeMessage('TES10033');    //Please check Terminal Agreement again.
							}
							setTooltip(sheetObjects[2],3+'verify_result');
						}
					} else {
						ComShowCodeMessage('TES10034');   //There is no necessary data for Verify.\n\n Please check again.
					}*/
                break;

            case "t2btng_registeragree":
                agreementReg();
                break;

            case "t3btng_save":
                var iRow = 1;
                if (ComIsNull(formObject.tml_sto_agmt_tp_cd.value)) {
                    ComShowCodeMessage('TES10037'); //Please select SR AGMT Type.
                    return false;
                }
                if (ComIsNull(formObject.lgs_cost_cd_s.value)) {
                    ComShowCodeMessage('TES10016'); //Please select Cost code.
                    return false;
                }
                if (ComIsNull(formObject.tml_agmt_vol_ut_cd[2].value)) {
                    ComShowCodeMessage('TES10017'); //Please select Vol. UOM.
                    return false;
                }
                if (ComIsNull(formObject.cmnc_hrmnt.value)) {
                    ComShowCodeMessage('TES10040'); //Please enter Commence Time.
                    return false;
                }
                if (!isValidHHMM(formObject.cmnc_hrmnt)) {
                    ComShowCodeMessage('TES10041'); //Please enter Commence Time as HH:MM format.
                    return false;
                }
                if (!checkCmncFormat(formObject.cmnc_hrmnt.value)) {
                    ComShowCodeMessage('TES10041'); //Please enter Commence Time as HH:MM format.
                    return false;
                }
                if (ComIsNull(formObject.curr_cd_s.value)) {
                    ComShowCodeMessage('TES10018'); //Please select Currency.
                    return false;
                }
                var storageAutoCalcFlg = formObject.vfsArray.value.split(",");
                sheetObjects[5].SetRowStatus(iRow, "I"); // 0
                sheetObjects[5].SetCellValue(iRow, "lgs_cost_cd", formObject.lgs_cost_cd_s.value); // 13
                if (storageAutoCalcFlg[0] == "Y") {
                    sheetObjects[5].SetCellValue(iRow, "auto_calc_flg", "Y"); // 14
                }
                sheetObjects[5].SetCellValue(iRow, "tml_agmt_vol_ut_cd", formObject.tml_agmt_vol_ut_cd[2].value); // 15
                sheetObjects[5].SetCellValue(iRow, "curr_cd", formObject.curr_cd_s.value); // 16
                sheetObjects[5].SetCellValue(iRow, "thrp_cost_cd_flg", formObject.tml_sto_agmt_tp_cd.value); // 17
                sheetObjects[5].SetCellValue(iRow, "tml_sto_agmt_tp_cd", formObject.cmnc_hrmnt.value.substr(0, 2) + formObject.cmnc_hrmnt.value.substr(3, 5)); // 18
                sheetObjects[5].SetCellValue(iRow, "cmnc_hrmnt", "S"); // 19
                formObject.f_cmd.value = MULTI01;
                if (storageAutoCalcFlg[0] == "Y") {
                    formObject.auto_calc_flg[0].disabled = false;
                    formObject.auto_calc_flg[0].checked = true;
                    formObject.auto_calc_flg[0].value = "Y";
                }
                formObject.curr_cd.value = formObject.curr_cd_s.value;
                formObject.tml_agmt_vol_ut_cd[0].value = formObject.tml_agmt_vol_ut_cd[2].value;
                formObject.lgs_cost_cd.value = formObject.lgs_cost_cd_s.value;
                formObject.tml_agmt_tp_cd.value = "S";
                doActionIBSheet6(sheetObject5, formObject, IBSAVE);
                break;

            case "t3btng_retreive":
                doActionIBSheet4(sheetObject3, formObject, IBINSERT);
                break;

            case "t3btng_agmtcopy":
                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                var classId = "ESD_TES_9070";
                var param = '?classId=' + classId;
                ComOpenPopup('/opuscntr/ESD_TES_9070.do' + param, 570, 540, '', dispaly, true);
                //ComOpenWindow("ESD_TES_9070.do",  window,  "dialogWidth:800px; dialogHeight:500px; help:no; status:no; resizable:no; scrollbars:no;" , true);
                break;

            case "t3btng_new1":
                initformStorageFDDTLs();
                sheetObject3.RemoveAll();
                break;

            case "t3btng_apply1":
                if (ComIsNull(formObject.yd_cd.value)) {
                    ComShowCodeMessage('TES10009'); //Please enter Yard Code.
                    return false;
                }
                if (ComIsNull(formObject.vndr_seq.value)) {
                    ComShowCodeMessage('TES10011'); //Please enter Service Provider Code.
                    return false;
                }
                if (ComIsNull(formObject.ctrt_ofc_cd.value)) {
                    ComShowCodeMessage('TES10023'); //Please enter Contract Office.
                    return false;
                }
                if (ComIsNull(formObject.eff_fm_dt.value)) {
                    ComShowCodeMessage('TES10024'); //Please enter Effective Date.
                    return false;
                }
                if (ComIsNull(formObject.eff_to_dt.value)) {
                    ComShowCodeMessage('TES10024'); //Please enter Effective Date.
                    return false;
                }
                if (ComIsNull(getElementValue(formObject, 'radio', 'auto_xtd_flg'))) {
                    ComShowCodeMessage('TES10014'); //Please check Auto Ext.
                    return false;
                }
                if (ComIsNull(formObject.lgs_cost_cd_s.value)) {
                    ComShowCodeMessage('TES10014'); //Please check Auto Ext.
                    return false;
                }
                if (ComIsNull(formObject.tml_agmt_vol_ut_cd[2].value)) {
                    ComShowCodeMessage('TES10017'); //Please select Vol. UOM.
                    return false;
                }
                if (ComIsNull(formObject.cmnc_hrmnt.value)) {
                    ComShowCodeMessage('TES10040'); //Please enter Commence Time.
                    return false;
                }
                if (!isValidHHMM(formObject.cmnc_hrmnt)) {
                    ComShowCodeMessage('TES10041'); //Please enter Commence Time as HH:MM format.
                    return false;
                }
                if (!checkCmncFormat(formObject.cmnc_hrmnt.value)) {
                    ComShowCodeMessage('TES10041'); //Please enter Commence Time as HH:MM format.
                    return false;
                }
                if (ComIsNull(formObject.curr_cd_s.value)) {
                    ComShowCodeMessage('TES10018'); //Please select Currency.
                    return false;
                }
                if (formObject.storage_gb[0].checked == false && formObject.storage_gb[1].checked == false) {
                    ComShowCodeMessage('TES10042'); //Please select Free Days/Rate.
                    return false;
                }
                if (formObject.storage_gb[0].checked == true) {
                    if (ComIsNull(getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_FD'))) {
                        ComShowCodeMessage('TES10043'); //Please select DG Class.
                        return false;
                    }
                    if (getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_FD') == "A") {
                        if (ComIsNull(getElementValue(formObject, 'radio', 'dcgo_same_FD'))) {
                            ComShowCodeMessage('TES10044'); //Please select DG, NODG.
                            return false;
                        }
                    }
                    if (getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_FD') == "S") {
                        if (document.form.dcgo_n1st_clss_flg_FD.checked == false && document.form.dcgo_n2nd_clss_flg_FD.checked == false && document.form.dcgo_n3rd_clss_flg_FD.checked == false && document.form.dcgo_n4th_clss_flg_FD.checked == false && document.form.dcgo_n5th_clss_flg_FD.checked == false && document.form.dcgo_n6th_clss_flg_FD.checked == false && document.form.dcgo_n7th_clss_flg_FD.checked == false && document.form.dcgo_n8th_clss_flg_FD.checked == false && document.form.dcgo_n9th_clss_flg_FD.checked == false && document.form.dcgo_none_clss_flg_FD.checked == false) {
                            ComShowCodeMessage('TES10045'); //Please check DG Class.
                            return false;
                        }
                    }
                    if (ComIsNull(formObject.ft_dys.value)) {
                        ComShowCodeMessage('TES10046'); //Please enter Days.
                        return false;
                    }
                }
                if (formObject.storage_gb[1].checked == true) {
                    if (ComIsNull(getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_R'))) {
                        ComShowCodeMessage('TES10043'); //Please select DG Class.
                        return false;
                    }
                    if (getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_R') == "A") {
                        if (ComIsNull(getElementValue(formObject, 'radio', 'dcgo_same_R'))) {
                            ComShowCodeMessage('TES10044'); //Please select DG, NODG.
                            return false;
                        }
                    }
                    if (getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_R') == "S") {
                        if (document.form.dcgo_n1st_clss_flg_FD.checked == false && document.form.dcgo_n2nd_clss_flg_R.checked == false && document.form.dcgo_n3rd_clss_flg_R.checked == false && document.form.dcgo_n4th_clss_flg_R.checked == false && document.form.dcgo_n5th_clss_flg_R.checked == false && document.form.dcgo_n6th_clss_flg_R.checked == false && document.form.dcgo_n7th_clss_flg_R.checked == false && document.form.dcgo_n8th_clss_flg_R.checked == false && document.form.dcgo_n9th_clss_flg_R.checked == false && document.form.dcgo_none_clss_flg_R.checked == false) {
                            ComShowCodeMessage('TES10045'); //Please check DG Class.
                            return false;
                        }
                    }
                    if (sheetObjects[3].CheckedRows(0) == "0") {
                        ComShowCodeMessage('TES10047'); //Please check No of Volume Tier.
                        return false;
                    }
                    if (ComIsNull(formObject.agmt_ut_rt.value)) {
                        ComShowCodeMessage('TES10027'); //Please enter Rate.
                        return false;
                    }
                }
                if (formObject.tml_agmt_vol_ut_cd[2].value == "C") {
                    if (ComIsNull(getElementValue(formObject, 'radio', 'cntr_ts'))) {
                        ComShowCodeMessage('TES10026'); //Please select container Type/Size.
                        return false;
                    }
                }

                if (formObject.sto_tml_cntr_sty_cd.disabled == false) {
                    if (formObject.sto_tml_cntr_sty_cd.value == "") {
                        ComShowCodeMessage('TES21053'); //Please select container Type/Size.
                        return false;
                    }

                }

                storageRateInputList();
                tabObjects[0].SetSelectedIndex(3);
                break;

            case "t3btng_agmtcopy2":
                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                var classId = "ESD_TES_9070";
                var param = '?classId=' + classId;
                ComOpenPopup('/opuscntr/ESD_TES_9070.do' + param, 570, 500, '', dispaly, true);
                //ComOpenWindow("ESD_TES_9070.do",  window,  "dialogWidth:800px; dialogHeight:500px; help:no; status:no; resizable:no; scrollbars:no;" , true);
                break;

            case "t3btng_new2":
                initformStorageFPDTLs();
                break;

            case "t3btng_apply2":
                if (ComIsNull(formObject.yd_cd.value)) {
                    ComShowCodeMessage('TES10009'); //Please enter Yard Code.
                    return false;
                }
                if (ComIsNull(formObject.vndr_seq.value)) {
                    ComShowCodeMessage('TES10011'); //Please enter Service Provider Code.
                    return false;
                }
                if (ComIsNull(formObject.ctrt_ofc_cd.value)) {
                    ComShowCodeMessage('TES10023'); //Please enter Contract Office.
                    return false;
                }
                if (ComIsNull(formObject.eff_fm_dt.value)) {
                    ComShowCodeMessage('TES10024'); //Please enter Effective Date.
                    return false;
                }
                if (ComIsNull(formObject.eff_to_dt.value)) {
                    ComShowCodeMessage('TES10024'); //Please enter Effective Date.
                    return false;
                }
                if (ComIsNull(getElementValue(formObject, 'radio', 'auto_xtd_flg'))) {
                    ComShowCodeMessage('TES10014'); //Please check Auto Ext.
                    return false;
                }
                if (ComIsNull(formObject.lgs_cost_cd_s.value)) {
                    ComShowCodeMessage('TES10016'); //Please select Cost code.
                    return false;
                }
                if (ComIsNull(formObject.tml_agmt_vol_ut_cd[2].value)) {
                    ComShowCodeMessage('TES10017'); //Please select Vol. UOM.
                    return false;
                }
                if (ComIsNull(formObject.cmnc_hrmnt.value)) {
                    ComShowCodeMessage('TES10040'); //Please enter Commence Time.
                    return false;
                }
                if (!isValidHHMM(formObject.cmnc_hrmnt)) {
                    ComShowCodeMessage('TES10041'); //Please enter Commence Time as HH:MM format.
                    return false;
                }
                if (!checkCmncFormat(formObject.cmnc_hrmnt.value)) {
                    ComShowCodeMessage('TES10041'); //Please enter Commence Time as HH:MM format.
                    return false;
                }
                if (ComIsNull(formObject.curr_cd_s.value)) {
                    ComShowCodeMessage('TES10018'); //Please select Currency.
                    return false;
                }
                if (ComIsNull(getElementValue(formObject, 'radio', 'fp_calc_prd_cd'))) {
                    ComShowCodeMessage('TES10048'); //Please check Cal. Period.
                    return false;
                }
                if (ComIsNull(formObject.fp_teu_qty.value)) {
                    ComShowCodeMessage('TES10049'); //Please enter FP TEU.
                    return false;
                }
                if (ComIsNull(formObject.agmt_ut_rt_fp.value)) {
                    ComShowCodeMessage('TES10027'); //Please enter Rate.
                    return false;
                }
                storageRateInputList();
                tabObjects[0].SetSelectedIndex(3);
                break;

            case "t4btng_new":
                sheetObject4.RemoveAll();
                break;

            case "t4btng_rowadd":
                doActionIBSheet5(sheetObject4, formObject, IBINSERT);
                break;

            case "t4btng_delete":
                var t4sheet1DelCount = 0;
                for (var i = 0; i < sheetObject4.RowCount(); i++) {
                    if (sheetObject4.GetCellValue(i + 3, 0) == 1) {
                        t4sheet1DelCount++;
                    }
                }
                if (t4sheet1DelCount > 0) {
                    rowDelete();
                    delete_Process();
                } else {
                    ComShowCodeMessage('TES10097'); //There is no date to delete.\n\n Please check again.
                }
                break;

            case "t4btng_save":
                if (ComIsNull(formObject.yd_cd.value)) {
                    ComShowCodeMessage('TES10009');
                    return false;
                }
                if (ComIsNull(formObject.yd_cd_name.value)) {
                    ComShowCodeMessage('TES10010');
                    return false;
                }
                if (ComIsNull(formObject.vndr_seq.value)) {
                    ComShowCodeMessage('TES10011');
                    return false;
                }
                if (formObject.inquiryFlg.value != "Y") {
                    if (formObject.vndr_seq_name.value == "") {
                        ComShowCodeMessage('TES10011');
                        return false;
                    }
                }
                if (agmtRegFlg == "N") {
                    ComShowCodeMessage('TES10095'); //These are saving canceled Yard code and vendor SEQ.\n\n Please check again.
                    return false;
                }
                if (hdrRetrieveFlg != "Y") {
                    ComShowCodeMessage('TES10096');
                    return false;
                }
                if (ComIsNull(formObject.eff_fm_dt.value)) {
                    ComShowCodeMessage('TES10024');
                    formObject.eff_fm_dt.focus();
                    return false;
                }
                if (!ComIsDate(formObject.eff_fm_dt)) {
                    ComShowCodeMessage('TES10013');
                    formObject.eff_fm_dt.focus();
                    return false;
                }
                if (!checkEffFormat(formObject.eff_fm_dt.value)) {
                    ComShowCodeMessage('TES10013');
                    formObject.eff_fm_dt.focus();
                    return false;
                }
                if (ComIsNull(formObject.eff_to_dt.value)) {
                    ComShowCodeMessage('TES10024');
                    formObject.eff_to_dt.focus();
                    return false;
                }
                if (!ComIsDate(formObject.eff_to_dt)) {
                    ComShowCodeMessage('TES10013');
                    formObject.eff_to_dt.focus();
                    return false;
                }
                if (!checkEffFormat(formObject.eff_to_dt.value)) {
                    ComShowCodeMessage('TES10013');
                    formObject.eff_to_dt.focus();
                    return false;
                }
                if (ComIsNull(getElementValue(formObject, 'radio', 'auto_xtd_flg'))) {
                    ComShowCodeMessage('TES10014');
                    return false;
                }
                if (formObject.tml_agmt_sts_cd.value == "") {
                    var iRow = 1;
                    sheetObjects[5].SetRowStatus(iRow, "I"); // 0
                    sheetObjects[5].SetCellValue(iRow, "yd_cd", formObject.yd_cd.value, 0); // 3
                    sheetObjects[5].SetCellValue(iRow, "yd_nm", formObject.yd_cd_name.value, 0); //4
                    sheetObjects[5].SetCellValue(iRow, "vndr_seq", formObject.vndr_seq.value, 0); // 5
                    sheetObjects[5].SetCellValue(iRow, "vndr_lgl_eng_nm", formObject.vndr_seq_name.value, 0); // 6
                    sheetObjects[5].SetCellValue(iRow, "ctrt_ofc_cd", formObject.ctrt_ofc_cd.value, 0); // 7
                    sheetObjects[5].SetCellValue(iRow, "eff_fm_dt", formObject.eff_fm_dt.value, 0); // 8
                    sheetObjects[5].SetCellValue(iRow, "eff_to_dt", formObject.eff_to_dt.value, 0); // 9
                    sheetObjects[5].SetCellValue(iRow, "auto_xtd_flg", getElementValue(formObject, 'radio', 'auto_xtd_flg'), 0); // 10
                    sheetObjects[5].SetCellValue(iRow, "agmt_rmk", formObject.agmt_rmk.value, 0); // 12
                    topBtnSave_OnlyTopSave();
                } else if (formObject.tml_agmt_sts_cd.value == "C") {
                    topBtnSave_Confirm();
                } else if (formObject.tml_agmt_sts_cd.value == "P") {
                    topBtnSave_Process();
                }
                break;

            case "t4btng_downexcel":
                if (sheetObject4.RowCount() < 1) { //no data
                    ComShowCodeMessage("COM132501");
                } else {
                    doActionIBSheet5(sheetObject4, formObject, IBDOWNEXCEL);
                }

                break;

            case "t4btng_loadexcel":
                if (formObject.tml_agmt_sts_cd.value != "" && formObject.tml_agmt_ofc_cty_cd.value != "" && formObject.tml_agmt_ver_no.value != "") {
                    var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                    var classId = "ESD_TES_9170";
                    var param = '?classId=' + classId;
                    ComOpenPopup('/opuscntr/ESD_TES_9170.do' + param, 1000, 530, '', dispaly, true);
                    //        	    		  ComOpenWindow("ESD_TES_9170.do",  window,  "dialogWidth:710px; dialogHeight:400px; help:no; status:no; resizable:yes;" , true);
                } else {
                    ComShowCodeMessage('TES10030'); //There is no data on Load EXCEL.\n\n Please check again.
                }
                break;

            case "t4btng_verify":
                sheetObjects[4].ColumnSort("5lgs_cost_cd|5tml_sto_agmt_tp_cd|5io_bnd_cd|5ft_dys|5tml_cntr_sty_cd|5fm_tr_dys|5to_tr_dys", "ASC", "ASC|ASC|ASC|ASC|ASC|ASC|ASC", 1);
                setTimeout("t4sheet1_verify()", 1000);

                break;

            case "t4btng_registeragree":
                agreementReg();
                break;

            case "t5btng_rowadd":
                doActionIBSheet9(sheetObject8, formObject, IBINSERT);
                break;

            case "t5btng_new":
                sheetObject8.RemoveAll();
                break;

            case "t5btng_delete":
                var t5sheet1DelCount = 0;
                for (var i = 0; i < sheetObject8.RowCount(); i++) {
                    if (sheetObject8.GetCellValue(i + 2, 0) == 1) {
                        t5sheet1DelCount++;
                    }
                }
                if (t5sheet1DelCount > 0) {
                    rowDelete();
                    delete_Process();
                } else {
                    ComShowCodeMessage('TES10097'); //There is no date to delete.\n\n Please check again.
                }
                break;

            case "t5btng_loadexcel":
                if (formObject.tml_agmt_sts_cd.value != "" && formObject.tml_agmt_ofc_cty_cd.value != "" && formObject.tml_agmt_ver_no.value != "") {
                    var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                    var classId = "ESD_TES_9175";
                    var param = '?classId=' + classId;
                    ComOpenPopup('/opuscntr/ESD_TES_9175.do' + param, 1000, 530, '', dispaly, true);
                    //    	    		  ComOpenWindow("ESD_TES_9170.do",  window,  "dialogWidth:710px; dialogHeight:400px; help:no; status:no; resizable:yes;" , true);
                } else {
                    ComShowCodeMessage('TES10030'); //There is no data on Load EXCEL.\n\n Please check again.
                }
                break;

            case "t5btng_verify":
                for (var i = 2; i < sheetObjects[8].RowCount() + 2; i++) {
                    if (sheetObjects[8].GetCellValue(i, "9verify_result") == "") {
                        sheetObjects[8].SetCellBackColor(i, 1, "#0000FF");
                        tab5VerifyFlg = true;
                    } else if (sheetObjects[8].GetCellValue(i, "9verify_result") != "") {
                        sheetObjects[8].SetCellBackColor(i, 1, "#FF0000");
                    }
                }

                if (tab5VerifyFlg) {
                    ComShowCodeMessage('TES10128'); //EQ Storage Rate List Verify has been completed.
                } else {
                    ComShowCodeMessage('TES10129'); //Please check EQ Storage Agreement again.
                }

                //	     		   	 for(var i=3;i<sheetObjects[4].RowCount()+3;i++){
                //	     				sheetObjects[4].SetRowBackColor(i, "");
                //	     				sheetObjects[4].SetCellValue(i ,"5verify_result", "");
                //	     				// 69 column
                //	     				for(var j=0;j<100+gap_st; j++){
                //	     					sheetObjects[4].SetCellBackColor(i, j, "");
                //	     				}
                //	     			}	     			
                break;

            case "t5btng_save":
                if (ComIsNull(formObject.yd_cd.value)) {
                    ComShowCodeMessage('TES10009');
                    return false;
                }
                if (ComIsNull(formObject.yd_cd_name.value)) {
                    ComShowCodeMessage('TES10010');
                    return false;
                }
                if (ComIsNull(formObject.vndr_seq.value)) {
                    ComShowCodeMessage('TES10011');
                    return false;
                }
                if (formObject.inquiryFlg.value != "Y") {
                    if (formObject.vndr_seq_name.value == "") {
                        ComShowCodeMessage('TES10011');
                        return false;
                    }
                }
                if (agmtRegFlg == "N") {
                    ComShowCodeMessage('TES10095'); //These are saving canceled Yard code and vendor SEQ.\n\n Please check again.
                    return false;
                }
                if (hdrRetrieveFlg != "Y") {
                    ComShowCodeMessage('TES10096');
                    return false;
                }
                if (ComIsNull(formObject.eff_fm_dt.value)) {
                    ComShowCodeMessage('TES10024');
                    formObject.eff_fm_dt.focus();
                    return false;
                }
                if (!ComIsDate(formObject.eff_fm_dt)) {
                    ComShowCodeMessage('TES10013');
                    formObject.eff_fm_dt.focus();
                    return false;
                }
                if (!checkEffFormat(formObject.eff_fm_dt.value)) {
                    ComShowCodeMessage('TES10013');
                    formObject.eff_fm_dt.focus();
                    return false;
                }
                if (ComIsNull(formObject.eff_to_dt.value)) {
                    ComShowCodeMessage('TES10024');
                    formObject.eff_to_dt.focus();
                    return false;
                }
                if (!ComIsDate(formObject.eff_to_dt)) {
                    ComShowCodeMessage('TES10013');
                    formObject.eff_to_dt.focus();
                    return false;
                }
                if (!checkEffFormat(formObject.eff_to_dt.value)) {
                    ComShowCodeMessage('TES10013');
                    formObject.eff_to_dt.focus();
                    return false;
                }
                if (ComIsNull(getElementValue(formObject, 'radio', 'auto_xtd_flg'))) {
                    ComShowCodeMessage('TES10014');
                    return false;
                }
                if (formObject.tml_agmt_sts_cd.value == "") {
                    var iRow = 1;
                    sheetObjects[5].SetRowStatus(iRow, "I"); // 0
                    sheetObjects[5].SetCellValue(iRow, "yd_cd", formObject.yd_cd.value, 0); // 3
                    sheetObjects[5].SetCellValue(iRow, "yd_nm", formObject.yd_cd_name.value, 0); //4
                    sheetObjects[5].SetCellValue(iRow, "vndr_seq", formObject.vndr_seq.value, 0); // 5
                    sheetObjects[5].SetCellValue(iRow, "vndr_lgl_eng_nm", formObject.vndr_seq_name.value, 0); // 6
                    sheetObjects[5].SetCellValue(iRow, "ctrt_ofc_cd", formObject.ctrt_ofc_cd.value, 0); // 7
                    sheetObjects[5].SetCellValue(iRow, "eff_fm_dt", formObject.eff_fm_dt.value, 0); // 8
                    sheetObjects[5].SetCellValue(iRow, "eff_to_dt", formObject.eff_to_dt.value, 0); // 9
                    sheetObjects[5].SetCellValue(iRow, "auto_xtd_flg", getElementValue(formObject, 'radio', 'auto_xtd_flg'), 0); // 10
                    sheetObjects[5].SetCellValue(iRow, "agmt_rmk", formObject.agmt_rmk.value, 0); // 12
                    topBtnSave_OnlyTopSave();
                } else if (formObject.tml_agmt_sts_cd.value == "C") {
                    topBtnSave_Confirm();
                } else if (formObject.tml_agmt_sts_cd.value == "P") {
                    topBtnSave_Process();
                }
                break;

            case "t5btng_downexcel":
                if (sheetObject8.RowCount() < 1) { //no data
                    ComShowCodeMessage("COM132501");
                } else {
                    doActionIBSheet9(sheetObject8, formObject, IBDOWNEXCEL);
                }

                break;

            case "t5btng_registeragree":
                agreementReg();
                break;

        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowCodeMessage('TES21025'); //The service is not available now
        } else {
            ComShowMessage(e.message);
        }
    }
}

function t4sheet1_verify() {
    for (var i = 3; i < sheetObjects[4].RowCount() + 3; i++) {
        sheetObjects[4].SetRowBackColor(i, "");
        sheetObjects[4].SetCellValue(i, "5verify_result", "");
        // 69 column
        for (var j = 0; j < 100 + gap_st; j++) {
            sheetObjects[4].SetCellBackColor(i, j, "");
        }
    }

    var beforeibflag = new Array();
    if (document.form.tml_agmt_sts_cd.value != "" && document.form.tml_agmt_ofc_cty_cd.value != "" && document.form.tml_agmt_ver_no.value != "" && (sheetObjects[4].RowCount() > 0)) {
        if (dupRowCheck('S') == false) {
            return false;
        }


        for (i = 0; i < sheetObjects[4].RowCount(); i++) {
            beforeibflag[i] = sheetObjects[4].GetRowStatus(i + 3);
            // Verify Result initialization
            sheetObjects[4].SetCellValue(i + 3, "5verify_result", "");
        }

        doActionIBSheet8(sheetObjects[7], document.form, IBSEARCH);

        if (dataStorageErrCount > 0) {
            ComShowCodeMessage('TES10103'); //Please modify Storage Rate List Sheet Data.
        } else {
            tab4VerifyFlg = storageRateListVerify_test1(beforeibflag);

            if (tab4VerifyFlg) {
                ComShowCodeMessage('TES10104'); //Storage Rate List Verify has been completed.
            } else {
                ComShowCodeMessage('TES10105'); //Please check Storage Agreement again.
            }
            setTooltip(sheetObjects[4], 5 + 'verify_result');
        }
    } else {
        ComShowCodeMessage('TES10034'); //There is no necessary data for Verify.\n\n Please check again.
    }

}

/**
 * using extra sheet valuable if there are more 2 sheets
 */
function processChange() {
    /***** using extra sheet valuable if there are more 2 sheets *****/
    /*******************************************************/
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        switch (srcName) {
            case "tml_sto_agmt_tp_cd":
                var invalue = formObject.tml_sto_agmt_tp_cd.options[formObject.tml_sto_agmt_tp_cd.selectedIndex].value;
                if (invalue == "FD") {
                    document.all.item("srLayer")[0].style.display = "Inline";
                    document.all.item("srLayer")[1].style.display = "none";
                    document.form.tml_agmt_vol_ut_cd[2].disabled = false;
                    document.form.tml_agmt_vol_ut_cd[2].value = "C";
                }
                if (invalue == "FP") {
                    document.all.item("srLayer")[0].style.display = "none";
                    document.all.item("srLayer")[1].style.display = "Inline";
                    document.form.tml_agmt_vol_ut_cd[2].value = "T";
                    document.form.tml_agmt_vol_ut_cd[2].disabled = true;
                    document.form.tml_agmt_vol_ut_cd[2].value = "T";
                }
                break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowCodeMessage('TES21025'); //The service is not available now
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * 
 * @param {ibsheet}  	sheet_obj	Sheet Object
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    for (k = 0; k < tabObjects.length; k++) {
        initTab(tabObjects[k], k + 1);
        tabObjects[k].SetSelectedIndex(0);
    }
    for (p = 0; p < comboObjects.length; p++) {
        initCombo(comboObjects[p], p + 1, '', '', '', '', '', '', '');
    }
    //        var objs=document.all.item("tabLayer");
    //      	objs[1].style.display="none";
    //      	objs[2].style.display="none";
    //      	objs[3].style.display="none";
    /**
        var obj_mode=document.all.item("modeLayer");
      	obj_mode[1].style.display="none";
      	obj_mode[2].style.display="none";
      	**/
    var formObject = document.form;
    if (!ComIsNull(agmt_no)) {
        formObject.tml_agmt_ofc_cty_cd.value = agmt_no;
        formObject.tml_agmt_ver_no.value = agmt_ver_no;
        formObject.tml_agmt_tp_cd.value = "T";
        formObject.f_cmd.value = SEARCH;
        doActionIBSheet6(sheetObjects[5], formObject, IBSEARCH);
        if (doActionIBSheet6SearchFlg != "NoData") {
            doActionIBSheet3(sheetObjects[2], formObject, IBSEARCH);
        }
        formObject.tml_agmt_tp_cd.value = "S";
        formObject.f_cmd.value = SEARCH;
        if (doActionIBSheet6SearchFlg != "NoData") {
            doActionIBSheet5(sheetObjects[4], formObject, IBSEARCH);
        }

        formObject.tml_agmt_tp_cd.value = "E";
        formObject.f_cmd.value = SEARCH;
        if (doActionIBSheet6SearchFlg != "NoData") {
            doActionIBSheet9(sheetObjects[8], formObject, IBSEARCH);
        }
    } else {
        formObject.yd_cd.focus();
    }
    //no support[implemented common]CLT sheetObjects[2].SelectHighLight=false;
    //no support[implemented common]CLT sheetObjects[4].SelectHighLight=false;

    $(document.form).bind("reset", function() {
        $(this).find('input[type=hidden]').not(".not").each(function() {
            this.value = ''
        });
    });
}

/**
 * setting sheet initial values and header
 * adding case as numbers of counting sheets
 * 
 * @param {sheetObj}  	sheetObj	Sheet Object
 * @param {sheetNo}  	sheetNo		Sheet Object 
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:   // t1sheet1(No of Volume Tier) init
			with(sheetObj){
				var HeadTitle0="|Seq.|Tier Volume|Tier Volume|";
				var HeadTitle1="|Seq.|From|To|";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle0, Align:"Center"},{ Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sts",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
							{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"from",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"to",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
							{Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tier_volume",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 } ];
				
				InitColumns(cols);
				SetEditable(1);
				SetRangeBackColor(1,2,1,3,"#555555");
				SetSheetHeight(260);
			}
		break;
		
		case 2:	// t1sheet2(No of Overtime Shift)
			with(sheetObj){
				var HeadTitle="|Seq.|Overtime Shift";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
							{Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 } ];
							
				InitColumns(cols);
				SetEditable(1);
				SetSheetHeight(150);
			}
		break;
		
		case 3:	// t2sheet1(Terminal Rate List Tab)
			with(sheetObj){
			
				var HeadTitle0=" |STS|Cost Code|F/M|Auto\nCal.\nY/N|Volume \nUOM|Currency|TP CC|I/O|IPC/\nOcean|Mode|"
				+ "Applied Date|Applied Date|Applied Date|Applied Date|Lane|Sub Trade|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|"
				+ "Tier Vol.|Tier Vol.|OT\nShift|THC|"
				+ "Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|"
				+ "Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|"
				+ "Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|"
				+ "Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|"
				+ "Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|"
				+ "Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nGang Hour|Rate\nTonne|Verify\nResult|Remark";
				var HeadTitle1=" |STS|Cost Code|F/M|Auto\nCal.\nY/N|Volume \nUOM|Currency|TP CC|I/O|IPC/\nOcean|Mode|"
				+ "WD|Sat|Sun|H/D|Lane|Sub Trade|None|Same|Same|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|"
				+ "Fr|To|OT\nShift|THC|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|F2|F4|F5|O2|O4|S2|S4|T2|T4|A2|A4|P2|P4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nGang Hour|Rate\nTonne|Verify\nResult|Remark";
				var HeadTitle2=" |STS|Cost Code|F/M|Auto\nCal.\nY/N|Volume \nUOM|Currency|TP CC|I/O|IPC/\nOcean|Mode|"
				+ "WD|Sat|Sun|H/D|Lane|Sub Trade|None|No DG|DG|No DG|1|2|3|4|5|6|7|8|9|"
				+ "Fr|To|OT\nShift|THC|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|F2|F4|F5|O2|O4|S2|S4|T2|T4|A2|A4|P2|P4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nGang Hour|Rate\nTonne|Verify\nResult|Remark";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, MaxSort:14 } );
				var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle0, Align:"Center"},{ Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"chk"  },
							{Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"" },
							{Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"lgs_cost_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_cntr_sty_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"auto_calc_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_agmt_vol_ut_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"thrp_lgs_cost_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"io_bnd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ioc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_trns_mod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"wkdy_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sat_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sun_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"hol_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"lane_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sub_trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dg_none",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"same_dg_none",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"same_dg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sep_dg_none",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n1st_clss_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n2nd_clss_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n3rd_clss_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n4th_clss_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n5th_clss_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n6th_clss_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n7th_clss_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n8th_clss_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n9th_clss_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"fm_tr_vol_val",      KeyField:0,   CalcLogic:"",   Format:"#######",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
							{Type:"Int",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"to_tr_vol_val",      KeyField:0,   CalcLogic:"",    Format:"#######",        PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
							{Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_ovt_shft_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"thc_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d2",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d4",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d5",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d7",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d8",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d9",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dw",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dx",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r2",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r4",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r5",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r7",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"f2",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"f4",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"f5",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"o2",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"o4",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"s2",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"s4",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"t2",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"t4",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"a2",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"a4",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"p2",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"p4",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"teu_rate",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"box_rate",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"move_rate",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"gang_hour_rate",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tonne_rate",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"verify_result",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"remark",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_dy_aply_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_aply_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_vol_aply_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ts_rt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"agmt_dtl_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"vrfyflg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_agmt_dtl_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ibflag" } ];
				
				InitColumns(cols);
				SetEditable(1);
				resizeSheet();//SetSheetHeight(380);
				SetRangeBackColor(1, 10, 1, 17,"#555555");//
				SetRangeBackColor(1, 17, 2, 29,"#555555");//
				SetRangeBackColor(1, 29, 1, 58,"#555555");//
				SetColProperty(sheetNo+"lgs_cost_cd", {ComboText:lgsCostCDSheet, ComboCode:lgsCostCDSheet} );
				SetColProperty(sheetNo+"thrp_lgs_cost_cd", {ComboText:tplgsCostCDSheet, ComboCode:tplgsCostCDSheet} );
				SetColProperty(sheetNo+"curr_cd", {ComboText:currCDSheet, ComboCode:currCDSheet} );
				SetColProperty(sheetNo+"lane_cd", {ComboText:laneCDSheet1, ComboCode:laneCDSheet2} );
				SetColProperty(sheetNo+"auto_calc_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
				SetColProperty(sheetNo+"tml_agmt_vol_ut_cd", {ComboText:vol_ut_cdCode, ComboCode:vol_ut_cdCode} );
				SetColProperty(sheetNo+"io_bnd_cd", {ComboText:io_bnd_cdText, ComboCode:io_bnd_cdCode} );
				SetColProperty(sheetNo+"ioc_cd", {ComboText:ioc_cdText, ComboCode:ioc_cdCode} );
				SetColProperty(sheetNo+"tml_trns_mod_cd", {ComboText:"|Same|Truck|Rail|Barge|Feeder|Mother|Other", ComboCode:"|S|T|R|B|F|V|O"} );
				SetColProperty(sheetNo+"thc_tp_cd", {ComboText:" |GIO|LIFT|BOTH", ComboCode:thc_tp_cdCode} );
				SetColProperty(sheetNo+"wkdy_flg", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"sat_flg", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"sun_flg", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"hol_flg", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dg_none", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"same_dg_none", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"same_dg", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"sep_dg_none", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n1st_clss_flg", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n2nd_clss_flg", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n3rd_clss_flg", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n4th_clss_flg", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n5th_clss_flg", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n6th_clss_flg", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n7th_clss_flg", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n8th_clss_flg", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n9th_clss_flg", {ComboText:"|Y", ComboCode:"|Y"} );
				
				SetColProperty(sheetNo+"tml_cntr_sty_cd", {ComboText:"|Same|F|M", ComboCode:"|S|F|M"} );
				
				SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
				SetHeaderRowHeight(21);
				SetHeaderRowHeight(20);
			}             
		break;
		
		case 4:   // t3sheet1(Storage Rate Input Tab : No of Tier Days) init 
			with(sheetObj){
				var HeadTitle0=" |Seq.|Tier Volume|Tier Volume";
				var HeadTitle1=" |Seq.|From|To";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle0, Align:"Center"},{ Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
							{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 } ];
				
				InitColumns(cols);
				SetEditable(1);
				SetSheetHeight(130);
				SetCellBackColor(1,2,"#555555");
				SetCellBackColor(1,3,GetCellBackColor(1,2));
			}
		break;
		
		case 5:   //t4sheet1( Storage Rate List Tab) init 
			with(sheetObj){
			
				var HeadTitle0=" |STS|Cost Code|F/M|Volume\nUOM|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
				+ "DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|"
				+ "Exclude Date|Exclude Date|Exclude Date|"
				+ "DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|"
				+ "Tier Over Days|Tier Over Days|Cal.\nPeriod|Pool\nTEU|"
				+ "Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|"
				+ "Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|"
				+ "Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nTonne|Verify\nResult|Remark";
				var HeadTitle1=" |STS|Cost Code|F/M|Volume\nUOM|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
				+ "None|Same|Same|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|"
				+ "SA|SU|Ho|"
				+ "None|Same|Same|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|"
				+ "From|To|Cal.\nPeriod|Pool\nTEU|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|F2|F4|F5|O2|O4|S2|S4|T2|T4|A2|A4|P2|P4|"
				+ "D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|F2|F4|F5|O2|O4|S2|S4|T2|T4|A2|A4|P2|P4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nTonne|Verify\nResult|Remark";
				var HeadTitle2=" |STS|Cost Code|F/M|Volume\nUOM|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
				+ "None|No DG|DG|No DG|1|2|3|4|5|6|7|8|9|"
				+ "SA|SU|Ho|"
				+ "None|No DG|DG|No DG|1|2|3|4|5|6|7|8|9|"
				+ "From|To|Cal.\nPeriod|Pool\nTEU|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|F2|F4|F5|O2|O4|S2|S4|T2|T4|A2|A4|P2|P4|"
				+ "D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|F2|F4|F5|O2|O4|S2|S4|T2|T4|A2|A4|P2|P4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nTonne|Verify\nResult|Remark";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1,MaxSort:7  } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle0, Align:"Center"},{ Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo + "chk"},
							{Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"" },
							{Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"lgs_cost_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_cntr_sty_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_agmt_vol_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_sto_agmt_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"cmnc_hrmnt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ft_dys",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"io_bnd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dg_none_fd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"same_dg_none_fd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"same_dg_fd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sep_dg_none_fd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n1st_clss_flg_fd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n2nd_clss_flg_fd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n3rd_clss_flg_fd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n4th_clss_flg_fd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n5th_clss_flg_fd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n6th_clss_flg_fd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n7th_clss_flg_fd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n8th_clss_flg_fd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n9th_clss_flg_fd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sat_flg_fd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sun_flg_fd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"hol_flg_fd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dg_none_r",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"same_dg_none_r",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"same_dg_r",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sep_dg_none_r",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n1st_clss_flg_r",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n2nd_clss_flg_r",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n3rd_clss_flg_r",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n4th_clss_flg_r",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n5th_clss_flg_r",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n6th_clss_flg_r",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n7th_clss_flg_r",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n8th_clss_flg_r",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n9th_clss_flg_r",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"fm_tr_dys",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"to_tr_dys",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"fp_calc_prd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
							{Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"fp_teu_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d2_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d4_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d5_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d7_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d8_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d9_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dw_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dx_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r2_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r4_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r5_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r7_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"f2_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"f4_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"f5_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"o2_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"o4_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"s2_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"s4_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"t2_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"t4_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"a2_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"a4_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"p2_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"p4_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d2_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d4_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d5_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d7_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d8_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d9_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dw_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dx_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r2_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r4_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r5_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r7_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"f2_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"f4_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"f5_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"o2_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"o4_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"s2_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"s4_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"t2_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"t4_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"a2_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"a4_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"p2_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"p4_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"teu_rate",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"box_rate",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"move_rate",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tonne_rate",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"verify_result",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Popup",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"remark",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"agmt_dtl_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"xcld_dy_aply_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:250,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ts_rt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"vrfyflg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_agmt_dtl_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ibflag" } ];
				
				InitColumns(cols);
				SetEditable(1);
				resizeSheet();//SetSheetHeight(380);
				//SetCellBackColor(1,9,"#555555");//
				/*SetCellBackColor(0,2,SubHeaderColor);
				SetCellBackColor(0,4,SubHeaderColor);
				SetCellBackColor(0,6,SubHeaderColor);
				SetCellBackColor(0,8,SubHeaderColor);
				SetCellBackColor(0,22,SubHeaderColor);
				SetCellBackColor(0,38,SubHeaderColor);
				SetCellBackColor(0,41,SubHeaderColor);
				SetCellBackColor(0,67,SubHeaderColor);
				SetCellBackColor(0,93,SubHeaderColor);
				SetCellBackColor(0,95,SubHeaderColor);*/
				SetRangeBackColor(1, 10, 2, 22,"#555555");//
				SetRangeBackColor(1, 23, 1, 26,"#555555");//
				SetRangeBackColor(1, 27, 2, 38,"#555555");//
				SetRangeBackColor(1, 39, 1, 92,"#555555");//
				SetColProperty(sheetNo+"lgs_cost_cd", {ComboText:lgsCostCDSheet, ComboCode:lgsCostCDSheet} );
				SetColProperty(sheetNo+"tml_agmt_vol_ut_cd", {ComboText:vol_ut_cdCode, ComboCode:vol_ut_cdCode} );
				SetColProperty(sheetNo+"io_bnd_cd", {ComboText:io_bnd_cdText, ComboCode:io_bnd_cdCode} );
				SetColProperty(sheetNo+"curr_cd", {ComboText:currCDSheet, ComboCode:currCDSheet} );
				SetColProperty(sheetNo+"tml_sto_agmt_tp_cd", {ComboText:tml_sto_agmt_tp_cd_cdCode, ComboCode:tml_sto_agmt_tp_cd_cdCode} );
				SetColProperty(sheetNo+"ft_dys", {ComboText:"|F", ComboCode:"|F"} );
				SetColProperty(sheetNo+"fp_calc_prd_cd", {ComboText:"|D|M", ComboCode:"|D|M"} );
				SetColProperty(sheetNo+"sat_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"sun_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"hol_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dg_none_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"same_dg_none_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"same_dg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"sep_dg_none_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n1st_clss_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n2nd_clss_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n3rd_clss_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n4th_clss_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n5th_clss_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n6th_clss_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n7th_clss_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n8th_clss_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n9th_clss_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dg_none_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"same_dg_none_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"same_dg_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"sep_dg_none_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n1st_clss_flg_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n2nd_clss_flg_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n3rd_clss_flg_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n4th_clss_flg_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n5th_clss_flg_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n6th_clss_flg_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n7th_clss_flg_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n8th_clss_flg_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n9th_clss_flg_r", {ComboText:"|Y", ComboCode:"|Y"} );
				
				SetColProperty(sheetNo+"tml_cntr_sty_cd", {ComboText:"|Same|F|M", ComboCode:"|S|F|M"} );
				
				SetColProperty(sheetNo+"cmnc_hrmnt", {Format:"##:##"} );
				SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
				SetHeaderRowHeight(21);
				SetHeaderRowHeight(20);
			}
		break;
		
		case 6:   //t1sheet3 init	agmt info
			with(sheetObj){
			
				var HeadTitle="STS|amgt no.|agmt ver|yard|yardnm|vender|vendnm|eff fm|eff to|auto ext|ctrt ofc|remark|sts cd|cost cd|auto cacl|vol uom|currency|thrp_cost_cd_flg|SR AGMT Type|Commence Time|agmt_tp|cre ofc";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"tml_agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"tml_agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"yd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"yd_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"vndr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"vndr_lgl_eng_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"eff_fm_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"eff_to_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"auto_xtd_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"ctrt_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"agmt_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"tml_agmt_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"lgs_cost_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"auto_calc_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"tml_agmt_vol_ut_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"thrp_cost_cd_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"tml_sto_agmt_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"cmnc_hrmnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"tml_agmt_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"cre_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				
				InitColumns(cols);		
				SetEditable(1);
			}
		break;
		
		case 7:   //t1sheet4 init
			with(sheetObj){
			
				var HeadTitle="thrp_cost_cd";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"thrp_lgs_cost_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 } ];
				
				InitColumns(cols);
				SetEditable(1);
			}
		break;
		
		case 8:   //t1sheet5 (Verify Flag Sheet) init	
			with(sheetObj){
				var HeadTitle="cost_cd|vrfy";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 } ];
				
				InitColumns(cols);
				SetEditable(0);
			}
		break;
		
		case 9:   //t5sheet1( EQ Storage Rate List Tab) init 
			with(sheetObj){
			
				var HeadTitle0=" |STS|Cost Code|Volume\nUOM|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
				+ "Exclude Date|Exclude Date|Exclude Date|"
				+ "Tier Over Days|Tier Over Days|Cal.\nPeriod|Pool\nTEU|"
				+ "Days|Days|Days|Days|Days|Days|"
				+ "Days|Days|Days|"
				+ "Rate|Rate|Rate|Rate|Rate|Rate|"
				+ "Rate|Rate|Rate|"									              
				+ "Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nTonne|Verify\nResult|Remark";
				
				var HeadTitle1=" |STS|Cost Code|Volume\nUOM|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
				+ "SA|SU|Ho|"
				+ "From|To|Cal.\nPeriod|Pool\nTEU|"
				+ "SL2|TA2|GN4|EG5|CH2|CH4|CLG|UMG|Chassis-\nGenset|" 
				+ "SL2|TA2|GN4|EG5|CH2|CH4|CLG|UMG|Chassis-\nGenset|"
				+ "Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nTonne|Verify\nResult|Remark";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1,MaxSort:7  } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle0, Align:"Center"},{ Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo + "chk"},
							{Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"" },
							{Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"lgs_cost_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_agmt_vol_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_sto_agmt_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"cmnc_hrmnt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ft_dys",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"io_bnd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sat_flg_fd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sun_flg_fd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"hol_flg_fd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"fm_tr_dys",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"to_tr_dys",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"fp_calc_prd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
							
							{Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"fp_teu_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sl2_d",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ta2_d",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"gn4_d",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"eg5_d",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ch2_d",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ch4_d",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"clg_d",                  KeyField:0,   CalcLogic:"",   Format:"Integer",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"umg_d",                  KeyField:0,   CalcLogic:"",   Format:"Integer",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"com_d",                  KeyField:0,   CalcLogic:"",   Format:"Integer",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							
							{Type:"Float",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sl2_r",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ta2_r",                 KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"gn4_r",                 KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"eg5_r",                 KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ch2_r",                 KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							
							{Type:"Float",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ch4_r",                 KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"clg_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"umg_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"com_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"teu_rate",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"box_rate",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"move_rate",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tonne_rate",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"verify_result",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Popup",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"remark",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"agmt_dtl_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"xcld_dy_aply_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:250,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ts_rt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"vrfyflg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_agmt_dtl_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ibflag" } ];
				
				InitColumns(cols);
				SetEditable(1);
				resizeSheet();//SetSheetHeight(380);
				
				SetRangeBackColor(1, 9, 1, 33,"#555555");//
				//					              SetRangeBackColor(2, 9, 2, 31,"#555555");//
				//					              SetRangeBackColor(1, 23, 1, 26,"#555555");//
				//					              SetRangeBackColor(1, 27, 2, 38,"#555555");//
				//					              SetRangeBackColor(1, 39, 1, 92,"#555555");//
				SetColProperty(sheetNo+"lgs_cost_cd", {ComboText:"|SRNDCH|SRNDGS|SRFDCH|SRFDGS", ComboCode:"|SRNDCH|SRNDGS|SRFDCH|SRFDGS"} );
				SetColProperty(sheetNo+"tml_agmt_vol_ut_cd", {ComboText:vol_ut_cdCode, ComboCode:vol_ut_cdCode} );
				SetColProperty(sheetNo+"io_bnd_cd", {ComboText:io_bnd_cdText, ComboCode:io_bnd_cdCode} );
				SetColProperty(sheetNo+"curr_cd", {ComboText:currCDSheet, ComboCode:currCDSheet} );
				SetColProperty(sheetNo+"tml_sto_agmt_tp_cd", {ComboText:tml_sto_agmt_tp_cd_cdCode, ComboCode:tml_sto_agmt_tp_cd_cdCode} );
				SetColProperty(sheetNo+"ft_dys", {ComboText:"|F", ComboCode:"|F"} );
				SetColProperty(sheetNo+"fp_calc_prd_cd", {ComboText:"|D|M", ComboCode:"|D|M"} );
				SetColProperty(sheetNo+"sat_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"sun_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"hol_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				
				SetColProperty(sheetNo+"cmnc_hrmnt", {Format:"##:##"} );
				SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
				SetHeaderRowHeight(21);
				SetHeaderRowHeight(20);
			}
		break;            
	}
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[2]);
    ComResizeSheet(sheetObjects[4]);
    ComResizeSheet(sheetObjects[8]);
}

/**
 * handling sheet process. <br>
 * @param {ibsheet}		sheetObj	IBSheet Object
 * @param {Object}		formObj		Form Object
 * @param {String}		sAction		Action Command
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBINSERT:
            //var count=formObj.all.cnt1.value;
            var count = formObj.cnt1.value;
            sheetObj.RemoveAll();
            for (i = 0; i < count; i++) {
                Row = sheetObj.DataInsert(-1);
            }
            for (i = 0; i < count; i++) {
                if (i == 1 && count >= 1) {
                    sheetObj.SetCellValue(i + 1, 2, "1", 0);
                }
                if (i == (count - 1)) {
                    sheetObj.SetCellValue(i + 2, 3, "MAX", 0);
                }
            }

            if (count == 1) {
                sheetObj.SetCellValue(2, 0, 1, 0);
                sheetObj.SetCellValue(2, 2, "1", 0);
                sheetObj.SetCellValue(2, 3, "MAX", 0);
            }
            break;

        case SEARCH05: //Retrieve
            formObj.f_cmd.value = SEARCH05;
            if (tabObjects[0].GetSelectedIndex() == 0) {
                formObj.lgs_cost_cd.value = formObj.lgs_cost_cd_t.value;
            } else if (tabObjects[0].GetSelectedIndex() == 2) {
                formObj.lgs_cost_cd.value = formObj.lgs_cost_cd_s.value;
            }
            sheetObj.DoSearch("ESD_TES_0034Verify.do", tesFrmQryStr(formObj));

            //var sXml = sheetObj.GetSearchData("ESD_TES_0034Verify.do", tesFrmQryStr(formObj));
            //sheetObj.LoadSearchData(sXml, {Sync:1});
            //t1sheet1_OnSearchEnd_Copy(sheetObj, sXml);

            break;

        case SEARCH07: //Retrieve
            formObj.f_cmd.value = SEARCH07;
            //sheetObj.DoSearch("ESD_TES_0034Verify.do", tesFrmQryStr(formObj) );

            var sXml = sheetObj.GetSearchData("ESD_TES_0034Verify.do", tesFrmQryStr(formObj));
            sheetObj.LoadSearchData(sXml, { Sync: 1 });
            break;
    }
}

/**
 * handling sheet process
 * 
 * @param {ibsheet}		sheetObj	IBSheet Object
 * @param {Object}		formObj		Form Object
 * @param {String}		sAction		Action Command
 */
function doActionIBSheet2(sheetObj, formObj, sAction, isAppend) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBINSERT:
            //var count=formObj.all.cnt2.value;
            var count = formObj.cnt2.value;
            sheetObj.RemoveAll();
            for (i = 0; i < count; i++) {
                Row = sheetObj.DataInsert(0);
            }
            break;
        case SEARCH04:
            formObj.f_cmd.value = SEARCH04;
            //sheetObj.DoSearch("ESD_TES_0034Detail.do", FormQueryString(formObj),{Sync:2} );
            //sheetObj.DoSearch("ESD_TES_0034Detail.do", tesFrmQryStr(formObj),{Append:isAppend} );

            var sXml = sheetObj.GetSearchData("ESD_TES_0034Detail.do", tesFrmQryStr(formObj));
            sheetObj.LoadSearchData(sXml, { Sync: 1, Append: isAppend });
            t1sheet2_OnSearchEnd_Copy(sheetObj, sXml);
            break;
    }
}

/**
 * handling sheet process
 * 
 * @param {ibsheet}		sheetObj	IBSheet Object
 * @param {Object}		formObj		Form Object
 * @param {String}		sAction		Action Command
 */
function doActionIBSheet3(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve

            formObj.sheet_prefix.value = "3";
            formObj.f_cmd.value = SEARCH02;
            //sheetObj.DoSearch("ESD_TES_0035GS.do", tesFrmQryStr(formObj) );

            var sXml = sheetObj.GetSearchData("ESD_TES_0035GS.do", tesFrmQryStr(formObj));
            sheetObj.LoadSearchData(sXml, { Sync: 1 });

            break;
        case IBSAVE: //Save
            formObj.tml_agmt_tp_cd.value = "T";
            formObj.sheet_prefix.value = "3";
            formObj.f_cmd.value = MULTI;
            formObj.select_tab.value = tabObjects[0].GetSelectedIndex();
            sheetObj.DoSave("ESD_TES_0035GS.do", tesFrmQryStr(formObj), -1, false);
            break;
        case IBINSERT:
            var Row = sheetObj.DataInsert();
            sheetObj.SetCellEditable(Row, "3sub_trd_cd", 1);

            break;
        case IBDOWNEXCEL:
            //no support[check again]CLT 		sheetObj.Down2Excel4FreeForm(-1, false,false,true, "");
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
        case IBLOADEXCEL:
            sheetObj.LoadExcel();
            break;
    }
}

/**
 * handling sheet process
 * 
 * @param {ibsheet}		sheetObj	IBSheet Object
 * @param {Object}		formObj		Form Object
 * @param {String}		sAction		Action Command
 */
function doActionIBSheet4(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBINSERT:
            var count = formObj.cnt3.value;
            sheetObj.RemoveAll();
            for (i = 0; i < count; i++) {
                Row = sheetObj.DataInsert(0);
            }
            for (i = 0; i < count; i++) {
                if (i = 1 && count >= 1) {
                    sheetObj.SetCellValue(i + 1, 2, "1");
                }
                if (i = (count - 1)) {
                    sheetObj.SetCellValue(i + 2, 3, "MAX");
                }
            }
            if (count == 1) {
                sheetObj.SetCellValue(2, 0, 1);
                sheetObj.SetCellValue(2, 2, "1");
                sheetObj.SetCellValue(2, 3, "MAX");
            }
            break;
    }
}

/**
 * handling sheet process
 * 
 * @param {ibsheet}		sheetObj	IBSheet Object
 * @param {Object}		formObj		Form Object
 * @param {String}		sAction		Action Command
 */
function doActionIBSheet5(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            formObj.f_cmd.value = SEARCH;
            formObj.sheet_prefix.value = "5";
            formObj.f_cmd.value = SEARCH03;
            //sheetObj.DoSearch("ESD_TES_0035GS.do", tesFrmQryStr(formObj) );

            var sXml = sheetObj.GetSearchData("ESD_TES_0035GS.do", tesFrmQryStr(formObj));
            sheetObj.LoadSearchData(sXml, { Sync: 1 });

            break;

        case IBSAVE: //Save
            formObj.sheet_prefix.value = "5";
            formObj.f_cmd.value = MULTI05;
            formObj.select_tab.value = tabObjects[0].GetSelectedIndex();
            sheetObj.DoSave("ESD_TES_0035GS.do", tesFrmQryStr(formObj), -1, false);
            break;

        case IBINSERT:
            var Row = sheetObj.DataInsert();
            sheetObj.SetCellValue(Row, '5tml_sto_agmt_tp_cd', 'FD', 1);

            break;

        case IBDOWNEXCEL:
            //sheetObj.SpeedDown2Excel(-1);
            //no support[check again]CLT 			sheetObj.Down2Excel4FreeForm(-1, false,false,true, "");
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

        case IBLOADEXCEL:
            sheetObj.LoadExcel();
            break;

        case IBSEARCH_ASYNC05:
            formObj.f_cmd.value = SEARCH17;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0034GS.do", tesFrmQryStr(formObj));
            var vndrNm = ComGetEtcData(searchXml, "vndr_nm");
            formObj.vndr_seq_name.value = vndrNm;
            searchXml = null;

            break;
    }
}

/** doActionIBSheet9
 * 
 */
function doActionIBSheet9(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            formObj.f_cmd.value = SEARCH;
            formObj.sheet_prefix.value = "9";
            formObj.f_cmd.value = SEARCH08;
            //sheetObj.DoSearch("ESD_TES_0035GS.do", tesFrmQryStr(formObj) );

            var sXml = sheetObj.GetSearchData("ESD_TES_0035GS.do", tesFrmQryStr(formObj));
            sheetObj.LoadSearchData(sXml, { Sync: 1 });

            break;
        case IBSAVE: //Save
            formObj.sheet_prefix.value = "9";
            formObj.f_cmd.value = MULTI05;
            formObj.select_tab.value = tabObjects[0].GetSelectedIndex();
            sheetObj.DoSave("ESD_TES_0035GS.do", tesFrmQryStr(formObj), -1, false);
            break;
        case IBINSERT:
            var Row = sheetObj.DataInsert();
            sheetObj.SetCellValue(Row, '9tml_sto_agmt_tp_cd', 'FP', 1);

            break;
        case IBDOWNEXCEL:
            //sheetObj.SpeedDown2Excel(-1);
            //no support[check again]CLT 			sheetObj.Down2Excel4FreeForm(-1, false,false,true, "");
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
        case IBLOADEXCEL:
            sheetObj.LoadExcel();
            break;
    }
}

/**
 * Sheet hidden sheet agmt hdr<br>
 * @param {ibsheet}		sheetObj	IBSheet Object
 * @param {Object}		formObj		Form Object
 * @param {String}		sAction		Action Command
 **/
function doActionIBSheet6(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            sheetObj.RemoveAll();
            var sXml = sheetObj.GetSearchData("ESD_TES_0034GS.do", tesFrmQryStr(formObj));

            sheetObj.LoadSearchData(sXml, { Sync: 1 });
            doActionIBSheet6SearchFlg = "";
            doActionIBSheet6SearchFlg = insertData();
            if (doActionIBSheet6SearchFlg != "NoData") {
                lane_Change();
                initformDTL();
            }
            break;

        case IBSAVE: //Save
            if (sheetObj.selectedIndex == "0" && sheetObj.selectedIndex == "1") {
                formObj.tml_agmt_sts_cd.value = "T";
                formObj.tml_agmt_tp_cd.value = "T";
            } else if (sheetObj.selectedIndex == "2" && sheetObj.selectedIndex == "3") {
                formObj.tml_agmt_sts_cd.value = "S";
                formObj.tml_agmt_tp_cd.value = "S";
            }
            //				sheetObj.DoSave("ESD_TES_0034GS.do", tesFrmQryStr(formObj), -1, false);
            var sXml = sheetObj.GetSaveData("ESD_TES_0034GS.do", tesFrmQryStr(formObj));
            sheetObj.LoadSaveData(sXml, true);
            break;

        case IBSEARCH_ASYNC04:
            formObj.f_cmd.value = SEARCH16;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0034GS.do", tesFrmQryStr(formObj));
            var ydNm = ComGetEtcData(searchXml, "yd_nm");
            
            if(ydNm.length > 0){
            	formObj.yd_cd_name.value = ydNm;
            } else {            	
            	ComShowCodeMessage('TES10066');
            	formObj.yd_cd.value = "";
            	formObj.yd_cd_name.value = "";
            } 
                        
            //validateYardCode();
            searchXml = null;
            break;
    }
}


/*function t1sheet3_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	//*********************************************************************************
    	ComOpenWait(false);
    	doActionIBSheet6SearchFlg="";
		doActionIBSheet6SearchFlg=insertData();
		if(doActionIBSheet6SearchFlg != "NoData"){
			lane_Change();
			initformDTL();
		}
    	//ComOpenWait(false);
    }*/


/**
 * Sheet hidden sheet thrp code <br>
 * @param {ibsheet}		sheetObj	IBSheet Object
 * @param {Object}		formObj		Form Object
 * @param {String}		sAction		Action Command
 **/
function doActionIBSheet7(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            formObj.f_cmd.value = SEARCH01;
            //sheetObj.DoSearch("ESD_TES_ThrpccGS.do", tesFrmQryStr(formObj) );
            var sXml = sheetObj.GetSearchData("ESD_TES_ThrpccGS.do", tesFrmQryStr(formObj));
            sheetObj.LoadSearchData(sXml, { Sync: 1 });
            break;
        case IBSAVE:
            if (sheetObj.selectedIndex == "1" && sheetObj.selectedIndex == "2") {
                formObj.tml_agmt_sts_cd.value = "T";
            } else if (sheetObj.selectedIndex == "3" && sheetObj.selectedIndex == "4") {
                formObj.tml_agmt_sts_cd.value = "S";
            }
            sheetObj.DoSave("ESD_TES_0034GS.do", tesFrmQryStr(formObj), -1, false);
            break;
    }
}

/**
 * Sheet hidden sheet verify flag<br>
 * @param {ibsheet}		sheetObj	IBSheet Object
 * @param {Object}		formObj		Form Object
 * @param {String}		sAction		Action Command
 **/
function doActionIBSheet8(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH:
            sheetObjects[7].RemoveAll();
            formObj.select_tab.value = tabObjects[0].GetSelectedIndex();
            formObj.f_cmd.value = SEARCH07;
            if (tabObjects[0].GetSelectedIndex() == 1) {
                var param = sheetObjects[2].GetSaveString(true);
            } else if (tabObjects[0].GetSelectedIndex() == 3) {
                var param = sheetObjects[4].GetSaveString(true);
            }

            var sXml = sheetObjects[7].GetSearchData("ESD_TES_0034VerifyGS.do", param + '&' + tesFrmQryStr(formObj), "", true);
            sheetObjects[7].LoadSearchData(sXml, { Sync: 1 });
            break;
    }
}

/**
 * t2sheet1 (Terminal Rate List Tab ) Sheet Popup Click <br>
 * @param {ibsheet}		sheetObj	IBSheet Object
 * @param {int,String}	row			Row Index
 * @param {int,String}	col			Column Index
 **/
function t2sheet1_OnPopupClick(sheetObj, row, col) {
    var formObj = document.form;
    var myOption = "width=410,height=420,menubar=0,status=0,scrollbars=0,resizable=0";
    var myWin = window.open('', "popagmtcrermk1", myOption);
    myWin.focus();
    formObj.pop_cost_cd.value = sheetObjects[2].GetCellValue(row, "3lgs_cost_cd");
    formObj.pop_sheetObj.value = "t2sheet1";
    formObj.pop_row.value = row;
    formObj.pop_agmt_rmk.value = sheetObjects[2].GetCellValue(row, "3agmt_dtl_rmk");
    formObj.pop_mode.value = "create"
    formObj.action = 'ESD_TES_9080.screen';
    formObj.target = 'popagmtcrermk1';
    formObj.submit();
}

/**
 * t4sheet1 (Storage Rate List Tab ) Sheet Popup Click<br>
 * @param {ibsheet}		sheetObj	IBSheet Object
 * @param {int,String}	row			Row Index
 * @param {int,String}	col			Column Index
 **/
function t4sheet1_OnPopupClick(sheetObj, row, col) {
    var formObj = document.form;
    var myOption = "width=410,height=420,menubar=0,status=0,scrollbars=0,resizable=0";
    var myWin = window.open('', "popagmtcrermk2", myOption);
    myWin.focus();
    formObj.pop_cost_cd.value = sheetObjects[4].GetCellValue(row, "5lgs_cost_cd");
    formObj.pop_sheetObj.value = "t4sheet1";
    formObj.pop_row.value = row;
    formObj.pop_agmt_rmk.value = sheetObjects[4].GetCellValue(row, "5agmt_dtl_rmk");
    formObj.pop_mode.value = "create"
    formObj.action = 'ESD_TES_9080.screen';
    formObj.target = 'popagmtcrermk2';
    formObj.submit();
}

/**
 * IBTab Object 
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source. <br>
 * @param{tab_obj}		tab_obj		Tab Object
 */
function setTabObject(tab_obj) {
    tabObjects[tabCnt++] = tab_obj;
}

/**
 * Initialization Tab <br>
 * @param{ibtab}		tab_obj		Tab Object
 * @param{int,String}	tab No		Tab No
 */
function initTab(tabObj, tabNo) {
    switch (tabNo) {
        case 1:
            with(tabObj) {
                var cnt = 0;
                InsertItem("Terminal Rate Input", "");
                InsertItem("Terminal Rate List", "");
                InsertItem("Storage Rate Input", "");
                InsertItem("Storage Rate List", "");
                InsertItem("CHS / MGS Storage Rate List", "");
            }
            break;
    }
    tabObj.SetSelectedIndex(0);
}

/**
 * change event<br>
 * 
 * @param{ibTab}	tab_obj		Tab Object
 * @param{String}	nItem		Tab No
 */
function tab1_OnChange(tabObj, nItem) {
    var objs = document.all.item("tabLayer");
    objs[nItem].style.display = "Inline";
    objs[beforetab].style.display = "none";
    var idx = 0;
    for (idx; idx < objs.length; idx++) {
        if (idx != nItem) {
            objs[idx].style.display = "none";
            objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
        }
    }
    beforetab = nItem;
    resizeSheet();
}

/**
 * set Yard info( Code, Name) <br>
 * 
 * @param{Array}		rowArray	rowArray
 */
function getYard(rowArray) {
    var colArray = rowArray[0];
    document.all.yd_cd.value = colArray[3];
    document.all.yd_cd_name.value = colArray[4];
    // 1, 2
    //    	if(sheetObjects[5].CellValue(1, 1)!= "" && sheetObjects[5].CellValue(1, 2)!= "" && sheetObjects[5].CellValue(1, 1)!= undefined && sheetObjects[5].CellValue(1, 2)!= undefined){
    if (sheetObjects[5].GetCellValue(1, "tml_agmt_ofc_cty_cd") != "" && sheetObjects[5].GetCellValue(1, "tml_agmt_ofc_cty_cd") != undefined) {
        lane_Change();
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
    doActionIBSheet6(sheetObjects[5], formObj, IBSEARCH_ASYNC04);
}

/**
 * set Vendor info( Code, Name) <br>
 * 
 * @param{Array}		rowArray	rowArray
 */
function getVender(rowArray) {
    var colArray = rowArray[0];
    document.all.vndr_seq.value = colArray[2];
    document.all.vndr_seq_name.value = colArray[4];
}

/**
 * Agreement Copy <br>
 */
function AgreementCopy_before() {
    // Terminal Rate Input 
    if (tabObjects[0].GetSelectedIndex() == 0) {
        sheetObjects[2].RemoveAll();
        document.form.tml_agmt_tp_cd.value = "T";
        tabObjects[0].SetSelectedIndex(1);
        document.form.f_cmd.value = SEARCH;
        //doActionIBSheet6(sheetObjects[5],document.form,IBSEARCH);
        doActionIBSheet3(sheetObjects[2], document.form, IBSEARCH);
        //    		if (sheetObjects[5].CellValue(1, 1) != "" && sheetObjects[5].CellValue(1, 2) !="" && sheetObjects[5].CellValue(1, 3) !=""){
        if (sheetObjects[5].GetCellValue(1, "tml_agmt_ofc_cty_cd") != "" && sheetObjects[5].GetCellValue(1, "tml_agmt_ver_no") != "") {
            insertData();
            document.form.ctrt_ofc_cd.value = document.form.cre_ofc_cd.value
        }
        // Storage Rate Input 
    } else if (tabObjects[0].GetSelectedIndex() == 2) {
        sheetObjects[4].RemoveAll();
        document.form.tml_agmt_tp_cd.value = "S";
        tabObjects[0].SetSelectedIndex(3);
        document.form.f_cmd.value = SEARCH;
        //doActionIBSheet6(sheetObjects[5],document.form,IBSEARCH);
        doActionIBSheet5(sheetObjects[4], document.form, IBSEARCH);
        //    		if (sheetObjects[5].CellValue(1, 1) != "" && sheetObjects[5].CellValue(1, 2) !="" && sheetObjects[5].CellValue(1, 3) !=""){
        if (sheetObjects[5].GetCellValue(1, "tml_agmt_ofc_cty_cd") != "" && sheetObjects[5].GetCellValue(1, "tml_agmt_ver_no")) {
            insertData();
            document.form.ctrt_ofc_cd.value = document.form.cre_ofc_cd.value
        }
    }
}

/**
 * Agreement Rate info Copy . <br>
 */
function AgreementCopy() {
    sheetObjects[2].RemoveAll();
    document.form.tml_agmt_tp_cd.value = "T";
    tabObjects[0].SetSelectedIndex(1);
    document.form.f_cmd.value = SEARCH;
    doActionIBSheet3(sheetObjects[2], document.form, IBSEARCH);
    for (var i = 0; i < sheetObjects[2].RowCount(); i++) {
        sheetObjects[2].SetRowStatus(i + 3, "I");
    }
    sheetObjects[4].RemoveAll();
    document.form.tml_agmt_tp_cd.value = "S";
    tabObjects[0].SetSelectedIndex(3);
    document.form.f_cmd.value = SEARCH;
    doActionIBSheet5(sheetObjects[4], document.form, IBSEARCH);
    for (var i = 0; i < sheetObjects[4].RowCount(); i++) {
        sheetObjects[4].SetRowStatus(i + 3, "I");
    }
    //   		if (sheetObjects[5].CellValue(1, 1) != "" && sheetObjects[5].CellValue(1, 2) !="" && sheetObjects[5].CellValue(1, 3) !=""){
    if (sheetObjects[5].GetCellValue(1, "tml_agmt_ofc_cty_cd") != "" && sheetObjects[5].GetCellValue(1, "tml_agmt_ver_no") != "") {
        insertData();
        document.form.ctrt_ofc_cd.value = sheetObjects[5].GetCellValue(1, "ctrt_ofc_cd"); // 7
    }
}

/**
 * t2sheet1 ( Terminal Rate List Tab ) search end event <br>
 * 
 * @param{ibsheet}		sheetObj	Sheet Object
 * @param{String}		errMsg		Error Message
 */
function t2sheet1_OnSearchEnd(sheetObj, errMsg) {
    var formObject = document.form;
    var tmpModeValue = "";
    var sheetNo = 3;
    if (errMsg != null && errMsg != 0 && errMsg != "") {
        ComShowMessage(errMsg);
    }
    for (var i = 0; i < sheetObj.RowCount(); i++) {
        if (sheetObj.GetCellValue(i + 3, "3curr_cd") == "KRW" || sheetObj.GetCellValue(i + 3, "3curr_cd") == "JPY") {
            currRateModRow('terminal', i + 3, dfInteger);
        }

        var temp_verify_str = sheetObj.GetCellValue(i + 3, "3vrfyflg");
        var temp_cost_code_flg = temp_verify_str.split("|");

        //        	if( "Y" == temp_cost_code_flg[26]){
        //            	sheetObjects[2].SetCellEditable(i+3, "3tml_cntr_sty_cd", 1);
        //        	}
        //        		
        //        	if( "Y" == temp_cost_code_flg[28]){
        //            	sheetObjects[2].SetCellEditable(i+3, "3sub_trd_cd", 1);
        //        	}

    }
    setTooltip(sheetObj, sheetNo + 'remark');
}

/**
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 */
function t2sheet1_OnChange(sheetObj, Row, Col, Value) {
    var total_rate = "";
    for (i = 32 + gap_tm; i < 57 + gap_tm; i++) {
        total_rate = total_rate + "#" + sheetObj.GetCellValue(Row, i);
    }

    if (Col > 31 + gap_tm || Col < 57 + gap_tm) {
        sheetObj.SetCellValue(Row, "3ts_rt", total_rate, 0);
    }

    if (Col == 29 + gap_tm) {
        sheetObj.SetCellValue(Row, "3to_tr_vol_val", String(sheetObj.GetCellValue(Row, "3to_tr_vol_val")).toUpperCase());
        if (sheetObj.GetCellValue(Row, "3to_tr_vol_val") != "MAX") {
            if (!ComIsNumber(sheetObj.GetCellValue(Row, "3to_tr_vol_val"))) {
                //ComShowMessage("숫자와 MAX만 입력 가능합니다. 다시 확인하세요.");
                sheetObj.SetCellValue(Row, "3to_tr_vol_val", "", 0);
            }
        }
    }

    if (sheetObj.GetCellValue(Row, "3curr_cd") == "KRW" || sheetObj.GetCellValue(Row, "3curr_cd") == "JPY") {
        currRateModRow('terminal', Row, dfInteger);
    } else {
        currRateModRow('terminal', Row, dfFloat);
    }

    //    	if(sheetObj.GetCellValue(Row,"3lgs_cost_cd")=="TMNDTS"){
    //    		sheetObj.SetCellEditable(Row, "3tml_cntr_sty_cd", 1);
    //		}else{
    //			sheetObj.SetCellEditable(Row, "3tml_cntr_sty_cd", 0);
    //		}

    //    	if(sheetObj.GetCellValue(Row,"3lgs_cost_cd")!="" && (sheetObj.GetCellValue(Row,"3lgs_cost_cd").substring(0,2)=="TP" || sheetObj.GetCellValue(Row,"3lgs_cost_cd").substring(0,2)=="SV")){
    //    		sheetObj.SetCellEditable(Row, "3sub_trd_cd", 1);
    //		}else{
    //			sheetObj.SetCellEditable(Row, "3sub_trd_cd", 0);
    //		}  	
}

/**
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 */
function t3sheet1_OnChange(sheetObj, Row, Col, Value) {
    sheetObj.SetCellValue(Row, 3, String(sheetObj.GetCellValue(Row, 3)).toUpperCase());
    if (sheetObj.GetCellValue(Row, 3) != "MAX") {

        if (!ComIsNumber(sheetObj.GetCellValue(Row, 3))) {
            //ComShowMessage("숫자와 MAX만 입력 가능합니다. 다시 확인하세요.");
        }
    }
}

/**
 * t4sheet1 Sheet search end event <br>
 * 
 * @param{ibsheet}		sheetObj	Sheet Object
 * @param{string}		errMsg		Error Message
 */
function t4sheet1_OnSearchEnd(sheetObj, errMsg) {
    var formObject = document.form;
    var sheetNo = 5;
    if (errMsg != null && errMsg != 0 && errMsg != "") {
        ComShowMessage(errMsg);
    }
    for (var i = 0; i < sheetObj.RowCount(); i++) {
        if (sheetObj.GetCellValue(i + 3, "5curr_cd") == "KRW" || sheetObj.GetCellValue(i + 3, "5curr_cd") == "JPY") {
            currRateModRow('storage', i + 3, dfInteger);
        }

        var temp_verify_str = sheetObj.GetCellValue(i + 3, "5vrfyflg");
        var temp_cost_code_flg = temp_verify_str.split("|");

        if ("Y" == temp_cost_code_flg[27]) {
            sheetObjects[4].SetCellEditable(i + 3, "5tml_cntr_sty_cd", 1);
        }

    }
    setTooltip(sheetObj, sheetNo + 'remark');
}

/**
 * t1sheet2 (No of Overtime Shift) search end event <br>
 * 
 * @param{ibsheet}		sheetObj	Sheet Object
 * @param{String}		errMsg		Error Message
 */
function t1sheet2_OnSearchEnd_Copy(sheetObj, sXml) {
    var console = window.console || {
        log: function() {}
    };
    console.log('t1sheet2_OnSearchEnd_Copy');
    /*if(errMsg !=null && errMsg != 0 && errMsg != ""){
        ComShowMessage(errMsg);
    }*/
    var lccvalue = ComGetEtcData(sXml, "lgsCostCDText") || "";
    var tlccvalue = ComGetEtcData(sXml, "terminalLgsCostCDText") || "";
    var slccvalue = ComGetEtcData(sXml, "storageLgsCostCDText") || "";
    var cctvalue = ComGetEtcData(sXml, "currCDText") || "";
    var cctDefvalue = ComGetEtcData(sXml, "currCDTextDef") || "";
    var lctvalue = ComGetEtcData(sXml, "laneCDText") || "";
    var cttvalue = ComGetEtcData(sXml, "cntrTPText") || "";
    var cstvalue = ComGetEtcData(sXml, "cntrSZText") || "";

    document.form.lane_cdString.value = lctvalue;
    currCodeDef = cctDefvalue;
    lgsCostCDSheet = ComGetEtcData(sXml, "lgsCostCDSheet");
    terminalLgsCostCDSheet = ComGetEtcData(sXml, "terminalLgsCostCDSheet");
    storageLgsCostCDSheet = ComGetEtcData(sXml, "storageLgsCostCDSheet");
    sheetObjects[2].SetColProperty('3lgs_cost_cd', { ComboText: terminalLgsCostCDSheet, ComboCode: terminalLgsCostCDSheet });
    sheetObjects[4].SetColProperty('5lgs_cost_cd', { ComboText: storageLgsCostCDSheet, ComboCode: storageLgsCostCDSheet });
    tplgsCostCDSheet = " |" + ComGetEtcData(sXml, "tplgsCostCDText");
    sheetObjects[2].SetColProperty('3thrp_lgs_cost_cd', { ComboText: tplgsCostCDSheet, ComboCode: tplgsCostCDSheet });
    //currCDSheet  = " "+sheetObj.EtcData("currCDSheet");
    currCDSheet = ComGetEtcData(sXml, "currCDSheet");
    sheetObjects[2].SetColProperty('3curr_cd', { ComboText: currCDSheet, ComboCode: currCDSheet });
    sheetObjects[4].SetColProperty('5curr_cd', { ComboText: currCDSheet, ComboCode: currCDSheet });
    sheetObjects[8].SetColProperty('9curr_cd', { ComboText: currCDSheet, ComboCode: currCDSheet });

    laneCDSheet1 = " |Same|OTH" + ComGetEtcData(sXml, "laneCDSheet");
    laneCDSheet2 = " |Sam|OTH" + ComGetEtcData(sXml, "laneCDSheet");
    sheetObjects[2].SetColProperty('3lane_cd', { ComboText: laneCDSheet1, ComboCode: laneCDSheet2 });

    subTrdTxt = ComGetEtcData(sXml, "subTrdCDText");
    subTrdSheet = ComGetEtcData(sXml, "subTrdCDSheet");
    var tempArr1 = subTrdTxt.split("|");
    var tempArr2 = subTrdSheet.split("|");
    tempSubTrdTxt = "";

    for (var ii = 1; ii < tempArr1.length; ii++) {
        tempSubTrdTxt = tempSubTrdTxt + "|" + tempArr2[ii] + "\t" + tempArr1[ii];

        var opt = document.createElement('option'); //새로운 option 속성을 생성
        opt.text = tempArr2[ii]; //새로운 option의 text 지정
        opt.value = tempArr2[ii]; //새로운 option의 value 지정
        document.forms['form'].elements['sub_trd_cd'].add(opt) //select 태그에 sption을 추가
    }


    sheetObjects[2].SetColProperty('3sub_trd_cd', { ComboText: "|Same\tSame|OTH\tOTH" + tempSubTrdTxt, ComboCode: "|S|O" + subTrdSheet });

    for (p = 0; p < comboObjects.length; p++) {
        initCombo(comboObjects[p], p + 1, tlccvalue, slccvalue, cctvalue, lctvalue, cttvalue, cstvalue, cctDefvalue);
    }
}

function t1sheet2_OnSearchEnd(sheetObj, errMsg) {
    var console = window.console || {
        log: function() {}
    };
    console.log('t1sheet2_OnSearchEnd');
    /*if(errMsg !=null && errMsg != 0 && errMsg != ""){
        ComShowMessage(errMsg);
    }
    var lccvalue=sheetObj.GetEtcData("lgsCostCDText") || "";
    var tlccvalue=sheetObj.GetEtcData("terminalLgsCostCDText") || "";
    var slccvalue=sheetObj.GetEtcData("storageLgsCostCDText") || "";
    var cctvalue=sheetObj.GetEtcData("currCDText") || "";
    var cctDefvalue=sheetObj.GetEtcData("currCDTextDef") || "";
    var lctvalue=sheetObj.GetEtcData("laneCDText") || "";
    var cttvalue=sheetObj.GetEtcData("cntrTPText") || "";
    var cstvalue=sheetObj.GetEtcData("cntrSZText") || "";
    document.form.lane_cdString.value=lctvalue;
    currCodeDef=cctDefvalue;
    lgsCostCDSheet=sheetObj.GetEtcData("lgsCostCDSheet");
    terminalLgsCostCDSheet=sheetObj.GetEtcData("terminalLgsCostCDSheet");
    storageLgsCostCDSheet=sheetObj.GetEtcData("storageLgsCostCDSheet");
    sheetObjects[2].SetColProperty('3lgs_cost_cd', {ComboText:terminalLgsCostCDSheet, ComboCode:terminalLgsCostCDSheet} );
    sheetObjects[4].SetColProperty('5lgs_cost_cd', {ComboText:storageLgsCostCDSheet, ComboCode:storageLgsCostCDSheet} );
    tplgsCostCDSheet=" |"+sheetObj.GetEtcData("tplgsCostCDText");
    sheetObjects[2].SetColProperty('3thrp_lgs_cost_cd', {ComboText:tplgsCostCDSheet, ComboCode:tplgsCostCDSheet} );
    //currCDSheet  = " "+sheetObj.EtcData("currCDSheet");
    currCDSheet=sheetObj.GetEtcData("currCDSheet");
    sheetObjects[2].SetColProperty('3curr_cd', {ComboText:currCDSheet, ComboCode:currCDSheet} );
    sheetObjects[4].SetColProperty('5curr_cd', {ComboText:currCDSheet, ComboCode:currCDSheet} );
    laneCDSheet1=" |Same|OTH"+sheetObj.GetEtcData("laneCDSheet");
    laneCDSheet2=" |Sam|OTH"+sheetObj.GetEtcData("laneCDSheet");
    sheetObjects[2].SetColProperty('3lane_cd', {ComboText:laneCDSheet1, ComboCode:laneCDSheet2} );
    for(p=0;p< comboObjects.length;p++){
        initCombo (comboObjects[p],p+1, tlccvalue, slccvalue, cctvalue, lctvalue, cttvalue, cstvalue, cctDefvalue);
    }*/
}

/**
 * Initialization Combo Box <br>
 * 
 * @param{comboObj}		comboObj	Combo Object
 * @param{comboNo}		comboNo		Combo No
 * @param{tlccvalue}	tlccvalue	
 * @param{slccvalue}	slccvalue	
 * @param{cctvalue}		cctvalue	
 * @param{lctvalue}		lctvalue	
 * @param{cttvalue}		cttvalue	
 * @param{cstvalue}		cstvalue	
 * @param{cctDefvalue}	cctDefvalue	
 */
function initCombo(comboObj, comboNo, tlccvalue, slccvalue, cctvalue, lctvalue, cttvalue, cstvalue, cctDefvalue) {
    var cnt = 0;
    var tlccArray = tlccvalue.split("|");
    var slccArray = slccvalue.split("|");
    var cctArray = cctvalue.split("|");
    var lctArray = lctvalue.split("|");
    var cttArray = cttvalue.split("|");
    var cstArray = cstvalue.split("|");
    var valueArray;
    var time;
    switch (comboNo) {
        case 1: // lgs_cost_cd_t
            comboObj.RemoveAll();
            with(comboObj) {
                SetColAlign(0, "left");
                SetColWidth(0, "71");
                for (i = 0; i < tlccArray.length; i++) {
                    valueArray = tlccArray[i].split("--");
                    if (valueArray[0] == "") {
                        break;
                    }
                    InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]);
                    //InsertItem(cnt++, valueArray[0], valueArray[0]);
                }
            }
            break;
        case 2:
            comboObj.RemoveAll();
            with(comboObj) {
                SetColAlign(0, "left");
                SetColWidth(0, "71");
                for (i = 0; i < cctArray.length; i++) {
                    //valueArray = cctArray[i].split("--");
                    //InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]);
                    InsertItem(cnt++, cctArray[i], cctArray[i]);
                }
                Code = cctDefvalue;
            }
            break;
        case 3:
            comboObj.RemoveAll();
            with(comboObj) {
                SetColAlign(0, "left");
                SetColWidth(0, "71");
                //InsertItem(cnt++, '' + '|' + '', '');
                InsertItem(cnt++, 'Same' + '|' + '', 'Sam');
                InsertItem(cnt++, 'OTH' + '|' + '', 'OTH');
                for (i = 0; i < lctArray.length; i++) {
                    valueArray = lctArray[i].split("--");
                    if (i == (lctArray.length - 1)) {
                        break;
                    }
                    InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]);
                }
            }
            break;
        case 4:
            comboObj.RemoveAll();
            with(comboObj) {
                SetColAlign(0, "left");
                SetColWidth(0, "71");
                for (i = 0; i < cttArray.length; i++) {
                    valueArray = cttArray[i].split("--");
                    InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]);
                }
            }
            break;
        case 5:
            comboObj.RemoveAll();
            with(comboObj) {
                SetColAlign(0, "left");
                SetColWidth(0, "71");
                for (i = 0; i < cstArray.length; i++) {
                    valueArray = cstArray[i].split("--");
                    InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]);
                }
            }
            break;
        case 6:
            comboObj.RemoveAll();
            with(comboObj) {
                SetColAlign(0, "left");
                SetColWidth(0, "71");
                for (i = 0; i < slccArray.length; i++) {
                    valueArray = slccArray[i].split("--");
                    if (valueArray[0] == "") {
                        break;
                    }
                    InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]);
                }
            }
            break;
        case 7:
            comboObj.RemoveAll();
            with(comboObj) {
                SetColAlign(0, "left");
                SetColWidth(0, "71");
                for (i = 0; i < cctArray.length; i++) {
                    //valueArray = cctArray[i].split("--");
                    //InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]);
                    InsertItem(cnt++, cctArray[i], cctArray[i]);
                }
                Code = cctDefvalue;
            }
            break;
        case 8:
            comboObj.RemoveAll();
            with(comboObj) {
                SetColAlign(0, "left");
                SetColWidth(0, "71");
                for (i = 0; i < cttArray.length; i++) {
                    valueArray = cttArray[i].split("--");
                    InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]);
                }
            }
            break;
        case 9:
            comboObj.RemoveAll();
            with(comboObj) {
                SetColAlign(0, "left");
                SetColWidth(0, "71");
                for (i = 0; i < cstArray.length; i++) {
                    valueArray = cstArray[i].split("--");
                    InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]);
                }
            }
            break;
        case 10:
            with(comboObj) {
                SetColAlign(0, "left");
                SetColAlign(1, "left");
                SetColWidth(0, "30");
                SetColWidth(1, "50");
                var tmp = '';
                var tmp2 = '';
                var curr_def_val = '';
                if (combo_val != null) {
                    tmp = combo_val.split('--');
                }
                for (var i = 0; tmp != null && i < tmp.length; i++) {
                    tmp2 = '';
                    tmp2 = tmp[i].split('|');
                    if (tmp2 != null) {
                        InsertItem(cnt++, new String(tmp[i]), new String(tmp2[0]));
                        if (tmp2[0] != 'USD') {
                            curr_def_val = tmp2[0];
                        }
                    }
                }
                if (curr_def_val != undefined && curr_def_val != null && curr_def_val.trim() != '') {
                    Code = curr_def_val;
                }
            }
            break;
    }
}
/**
 * ComboBox Object <br>
 * adding process for list in case of needing batch processing with other items. <br>
 * defining list on the top of source. <br>
 * 
 * @param {combo_obj}  	combo_obj	Combo Object
 */
function setComboObject(combo_obj) {
    comboObjects[comboCnt++] = combo_obj;
}

/**
 * Terminal Rate Input Tab LGS Cost Code <br>
 * 
 * @param {Object}  	comObj		ComboBox Object
 * @param {int,String}	index		index
 * @param {String}  	text		text
 */
function lgs_cost_cd_t_OnChange(comObj, index, text) {
    document.form.lgs_cost_cd_t.value = comObj.GetSelectCode();
    costCodeT = comObj.GetSelectCode();
    if (comObj.GetSelectCode() == "TPNDFL" || comObj.GetSelectCode() == "SVLDFL" ||
        comObj.GetSelectCode() == "TMNDFL" || comObj.GetSelectCode() == "TMNDMT") {
        document.form.tml_trns_mod_cd[0].disabled = false;
        document.form.tml_trns_mod_cd[1].disabled = false;
        var obj_mode = document.all.item("modeLayer");
        obj_mode[0].style.display = "none";
        obj_mode[1].style.display = "inline";
        obj_mode[2].style.display = "none";
    } else if (comObj.GetSelectCode() == "TPNDTS" || comObj.GetSelectCode() == "SVLDTS" || comObj.GetSelectCode() == "TMNDTS") {
        document.form.tml_trns_mod_cd[0].disabled = false;
        document.form.tml_trns_mod_cd[1].disabled = false;
        var obj_mode = document.all.item("modeLayer");
        obj_mode[0].style.display = "none";
        obj_mode[1].style.display = "none";
        obj_mode[2].style.display = "inline";
    } else {
        document.form.tml_trns_mod_cd[0].disabled = true;
        document.form.tml_trns_mod_cd[1].disabled = true;
    }
    comboObjects[1].SetSelectCode(currCodeDef);
    document.form.command_h.value = "S";
    if (comboObjects[0].GetSelectCode() != "") {
        doActionIBSheet(sheetObjects[0], document.form, SEARCH05);
    }
}

/**
 * Storage Rate Input Tab LGS Cost Code<br>
 * 
 * @param {comObj}  	comObj		ComboBox Object
 * @param {index}  		index		index
 * @param {text}  		text		text
 */
function lgs_cost_cd_s_OnChange(comObj, index, text) {
    document.form.lgs_cost_cd_s.value = comObj.GetSelectCode();
    costCodeS = comObj.GetSelectCode();
    document.form.command_h.value = "S";
    if (comboObjects[5].GetSelectCode() != "") {
        doActionIBSheet(sheetObjects[0], document.form, SEARCH05);
    }
}

/**
 * Terminal Rate Input Tab Currency Code<br>
 * 
 * @param {comObj}  	comObj		ComboBox Object
 * @param {index}  		index		index
 * @param {text}  		text		text
 */
function curr_cd_t_OnChange(comObj, index, text) {
    document.form.curr_cd_t.value = comObj.GetSelectCode();
    document.form.command_h.value = "S";
}

/**
 * Storage Rate Input Tab Currency Code<br>
 * 
 * @param {comObj}  	comObj		ComboBox Object
 * @param {index}  		index		index
 * @param {text}  		text		text
 */
function curr_cd_s_OnChange(comObj, index, text) {
    document.form.curr_cd_s.value = comObj.GetSelectCode();
    document.form.command_h.value = "S";
}

/**
 * Lane Code change event<br>
 * 
 * @param {comObj}  	comObj		ComboBox Object
 * @param {index}  		index		index
 * @param {text}  		text		text
 */
function lane_cd_OnChange(comObj, index, text) {
    document.form.lane_cd.value = comObj.GetSelectCode();
    document.form.command_h.value = "S";
}

/**
 * Terminal Rate Input Tab Container Type<br>
 * 
 * @param {comObj}  	comObj		ComboBox Object
 * @param {index}  		index		index
 * @param {text}  		text		text
 */
function cntr_type_t_OnChange(comObj, index, text) {
    document.form.cntr_type_t.value = comObj.GetSelectCode();
    document.form.command_h.value = "S";
}

/**
 * Storage Rate Input Tab Container Type<br>
 * 
 * @param {comObj}  	comObj		ComboBox Object
 * @param {index}  		index		index
 * @param {text}  		text		text
 */
function cntr_type_s_OnChange(comObj, index, text) {
    document.form.cntr_type_s.value = comObj.GetSelectCode();
    document.form.command_h.value = "S";
}

/**
 * Terminal Rate Input Tab Container Size <br>
 * 
 * @param {comObj}  	comObj		ComboBox Object
 * @param {index}  		index		index
 * @param {text}  		text		text
 */
function cntr_size_t_OnChange(comObj, index, text) {
    document.form.cntr_size_t.value = comObj.GetSelectCode();
    document.form.command_h.value = "S";
}

/**
 * Storage Rate Input Tab Container Size <br>
 * 
 * @param {comObj}  	comObj		ComboBox Object
 * @param {index}  		index		index
 * @param {text}  		text		text
 */
function cntr_size_s_OnChange(comObj, index, text) {
    document.form.cntr_size_s.value = comObj.GetSelectCode();
    document.form.command_h.value = "S";
}

/**
 * Detail Lgs Cost Code <br>
 * 
 * @param {comObj}  	comObj		ComboBox Object
 * @param {index}  		index		index
 * @param {text}  		text		text
 */
function cost_code_dc_OnChange(comObj, index, text) {
    document.form.lgs_cost_dtl_cd.value = comObj.GetSelectCode();
    document.form.command_h.value = "S";
}

/**
 * Lane change event<br>
 * 
 */
function lane_Change() {
    document.form.command_h.value = "S";
    doActionIBSheet2(sheetObjects[1], document.form, SEARCH04);
    comboObjects[0].SetSelectCode(sheetObjects[5].GetCellValue(1, "lgs_cost_cd"), false); // 13
    //comboObjects[1].Code2		= sheetObjects[5].CellValue(1, 16);
    //}
}

/**
 * Agreement Header Info Validate.<br>
 * 
 * @param {formObject}  	formObject		Form Object
 */
function hdr_validate(formObject) {
    if (ComIsNull(formObject.yd_cd.value)) {
        ComShowCodeMessage('TES10009');
        return false;
    }
    if (!ComChkLen(formObject.yd_cd, 7)) {
        ComShowCodeMessage('TES10107');
        return false;
    }
    if (ComIsNull(formObject.vndr_seq.value)) {
        ComShowCodeMessage('TES10011');
        return false;
    }
    if (!ComIsNumber(formObject.vndr_seq)) {
        ComShowCodeMessage('TES10108');
        return false;
    }
    if (ComIsNull(formObject.ctrt_ofc_cd.value)) {
        ComShowCodeMessage('TES10023');
        return false;
    }
    if (ComIsNull(formObject.eff_fm_dt.value)) {
        ComShowCodeMessage('TES10012');
        return false;
    }
    if (!ComIsNull(formObject.eff_fm_dt.value)) {
        if (!ComIsDate(formObject.eff_fm_dt)) {
            ComShowCodeMessage('TES10013');
            return false;
        }
    }
    if (ComIsNull(formObject.eff_to_dt.value)) {
        ComShowCodeMessage('TES10012');
        return false;
    }
    if (!ComIsNull(formObject.eff_to_dt.value)) {
        if (!ComIsDate(formObject.eff_to_dt)) {
            ComShowCodeMessage('TES10013');
            return false;
        }
    }
    if (ComIsNull(getElementValue(formObject, 'radio', 'auto_xtd_flg'))) {
        ComShowCodeMessage('TES10014');
        return false;
    }
    return true;
}

/**
 * t1sheet1 (No of Volume Tier) search end event
 * 
 * @param {ibsheet} 	sheetObj	Sheet Object
 * @param {String}  	errMsg		Error Message
 */
function t1sheet1_OnSearchEnd(sheetObj, errMsg) {
    var console = window.console || {
        log: function() {}
    };
    if (errMsg != null && errMsg != 0 && errMsg != "") {
        ComShowMessage(errMsg);
    }
    var verifystr = sheetObj.GetEtcData("verifyText");
    var thrpFlg = sheetObj.GetEtcData("thrpFlg");
    //ComShowMessage(verifystr);
    document.form.thrpFlg.value = thrpFlg;
    var vfsArray = verifystr.split("|");
    if (tabObjects[0].GetSelectedIndex() == 0) {
        comboObjects[0].SetSelectCode(costCodeT, false);
        //comboObjects[5].SetSelectCode("",false);
        comboObjects[5].SetSelectCode(-1, false);
    } else if (tabObjects[0].GetSelectedIndex() == 2) {
        comboObjects[5].SetSelectCode(costCodeS, false);
        //comboObjects[0].SetSelectCode("",false);
        comboObjects[0].SetSelectCode(-1, false);
    }
    initVerify(vfsArray);
    //		if(sheetObjects[5].CellValue(1, 13)!=comboObjects[0].Code || sheetObjects[5].CellValue(1, 13)!=comboObjects[5].Code){
    if (sheetObjects[5].GetCellValue(1, "lgs_cost_cd") != comboObjects[0].GetSelectCode() ||
        sheetObjects[5].GetCellValue(1, "lgs_cost_cd") != comboObjects[5].GetSelectCode()) {
        if (tabObjects[0].GetSelectedIndex() == 0) {
            comboObjects[1].SetSelectCode(currCodeDef);
        } else if (tabObjects[0].GetSelectedIndex() == 2) {
            comboObjects[6].SetSelectCode(currCodeDef);
        }
    }

    if (sheetObjects[5].GetCellValue(1, "cmnc_hrmnt") == "") { // 19
        document.form.cmnc_hrmnt.value = "24:00";
    }
    //agreementVaildate(vfsArray);
    verifyObjects = vfsArray;
    document.form.vfsArray.value = vfsArray;
}

/**
 * Initialization Verify info<br>
 * 
 * @param {Array} 	vfsArray	vfsArray
 */
function initVerify(vfsArray) {
    var tab_count = 0;
    var terminal_tab_count = 0;
    var storage_tab_count = 0;
    initFormValue();
    initFormDisabled();
    for (var i = 1; i < 10; i++) {
        if (vfsArray[i] == "Y") {
            tab_count++;
            terminal_tab_count++;
        }
    }
    for (var i = 10; i < 19; i++) {
        if (vfsArray[i] == "Y") {
            storage_tab_count++;
        }
    }
    if (storage_tab_count > 0) {
        if (tabObjects[0].GetSelectedIndex() == 0) {
            ComShowCodeMessage('TES10052');
            comboObjects[0].SetSelectCode(-1, false);
            return false;
        }
        document.form.tml_agmt_vol_ut_cd[2].disabled = false;
        //document.form.tml_agmt_vol_ut_cd[2].value = sheetObjects[5].CellValue(1, 15);
        if (comboObjects[5].GetSelectCode() == sheetObjects[5].GetCellValue(1, "lgs_cost_cd")) { // 13
            document.form.tml_agmt_vol_ut_cd[2].value = sheetObjects[5].GetCellValue(1, "tml_agmt_vol_ut_cd"); // 15
        } else {
            document.form.tml_agmt_vol_ut_cd[2].value = "";
        }
        comboObjects[6].SetEnable(1);
        if (sheetObjects[5].GetCellValue(1, "tml_agmt_vol_ut_cd") == "C") { // 15
            document.form.cntr_ts[2].disabled = false;
            document.form.cntr_ts[3].disabled = false;
        }
    } else if (terminal_tab_count > 0) {
        if (tabObjects[0].GetSelectedIndex() == 2) {
            ComShowCodeMessage('TES10053');
            comboObjects[5].SetSelectCode(-1, false);
            return false;
        }
        document.form.tml_agmt_vol_ut_cd[1].disabled = false;
        if (comboObjects[0].GetSelectCode() == sheetObjects[5].GetCellValue(1, "lgs_cost_cd")) { // 13
            document.form.tml_agmt_vol_ut_cd[1].value = sheetObjects[5].GetCellValue(1, 15);
        } else {
            document.form.tml_agmt_vol_ut_cd[1].value = "";
        }
        comboObjects[1].SetEnable(1);
        if (sheetObjects[5].GetCellValue(1, "tml_agmt_vol_ut_cd") == "C") { // 15
            document.form.cntr_ts[0].disabled = false;
            document.form.cntr_ts[1].disabled = false;
        }
    } else {
        comboObjects[0].SetSelectCode(-1, false);
        comboObjects[5].SetSelectCode(-1, false);
    }
    if (tabObjects[0].GetSelectedIndex() == 0) {
        document.form.tml_agmt_vol_ut_cd[1].value = "C";
        selectVolUOM();
    } else if (tabObjects[0].GetSelectedIndex() == 2) {
        document.form.tml_agmt_vol_ut_cd[2].value = "C";
        selectVolUOM();
    }
    // com_auto_calc_flg
    if (vfsArray[0] == "Y") {
        document.form.auto_calc_flg[0].checked = false;
        document.form.auto_calc_flg[1].checked = false;
        //document.form.auto_calc_flg[0].disabled=false;
        //document.form.auto_calc_flg[1].disabled=false;
        for (var i = 0; i < getElementCnt(document.form, 'radio', 'auto_calc_flg'); i++) {
            if (sheetObjects[5].GetCellValue(1, "auto_calc_flg") == "Y") { // 14
                document.form.auto_calc_flg[i].checked = true;
                document.form.auto_calc_flg[i + 1].checked = false;
                break;
            } else if (sheetObjects[5].GetCellValue(1, "auto_calc_flg") == "N") { // 14
                document.form.auto_calc_flg[i].checked = false;
                document.form.auto_calc_flg[i + 1].checked = true;
                break;
            }
        }
        document.form.auto_calc_flg[0].checked = true;
        document.form.auto_calc_flg[1].checked = false;
        document.form.auto_calc_flg.value = vfsArray[0];
    } else if (vfsArray[0] == "N") {
        document.form.auto_calc_flg[0].checked = false;
        document.form.auto_calc_flg[1].checked = true;
        document.form.auto_calc_flg.value = vfsArray[0];
    }
    // tml_thrp_cost_cd_flg
    if (vfsArray[1] == "Y") {
        //document.form.io_bnd_cd[1].disabled=false;
    }
    // tml_io_bnd_flg
    if (vfsArray[2] == "Y") {
        document.form.io_bnd_cd[1].disabled = false;
        document.form.io_bnd_cd[1].value = "S";
    }
    // tml_ioc_flg
    if (vfsArray[3] == "Y") {
        document.form.ioc_cd.disabled = false;
        document.form.ioc_cd.value = "S";
    }
    // tml_aply_dt_flg
    if (vfsArray[4] == "Y") {
        document.form.tml_dy_aply_tp_cd[0].disabled = false;
        document.form.tml_dy_aply_tp_cd[1].disabled = false;
        document.form.wkdy_flg.disabled = false;
        document.form.sat_flg.disabled = false;
        document.form.sun_flg.disabled = false;
        document.form.hol_flg.disabled = false;
        document.form.tml_dy_aply_tp_cd[0].checked = true;
        selectAplySame();
    }
    // tml_lane_flg
    if (vfsArray[5] == "Y") {
        //document.form.lane_cd.disable = false;
        comboObjects[2].SetEnable(1);
        comboObjects[2].SetSelectCode("Sam");
    }
    // tml_dcgo_aply_flg
    if (vfsArray[6] == "Y") {
        document.form.dcgo_aply_tp_cd[0].disabled = false;
        document.form.dcgo_aply_tp_cd[1].disabled = false;
        document.form.dcgo_aply_tp_cd[2].disabled = false;
        document.form.dcgo_n1st_clss_flg.disabled = false;
        document.form.dcgo_n2nd_clss_flg.disabled = false;
        document.form.dcgo_n3rd_clss_flg.disabled = false;
        document.form.dcgo_n4th_clss_flg.disabled = false;
        document.form.dcgo_n5th_clss_flg.disabled = false;
        document.form.dcgo_n6th_clss_flg.disabled = false;
        document.form.dcgo_n7th_clss_flg.disabled = false;
        document.form.dcgo_n8th_clss_flg.disabled = false;
        document.form.dcgo_n9th_clss_flg.disabled = false;
        document.form.dcgo_none_clss_flg.disabled = false;
        document.form.dcgo_aply_tp_cd[0].checked = true;
        selectDGNone('');
    }
    // tml_tr_vol_flg
    if (vfsArray[7] == "Y") {
        document.form.cnt1.disabled = false;
        document.form.cnt1.value = 1;
        var iRow = sheetObjects[0].DataInsert(-1);
        sheetObjects[0].SetCellValue(iRow, 0, "1", 0);
        sheetObjects[0].SetCellValue(iRow, 2, "1", 0);
        sheetObjects[0].SetCellValue(iRow, 3, "MAX", 0);
    }
    // tml_ovt_shft_flg
    if (vfsArray[8] == "Y") {
        document.form.cnt2.disabled = false;
        document.form.cnt2.value = 1;
    }
    // tml_thc_flg
    if (vfsArray[9] == "Y") {
        document.form.thc_tp_cd[0].disabled = false;
        document.form.thc_tp_cd_flg.disabled = false;
        document.form.thc_tp_cd[1].disabled = false;
        document.form.thc_tp_cd[2].disabled = false;
        document.form.thc_tp_cd[0].checked = true;
    }
    // sto_com_agmt_tp_flg
    if (vfsArray[10] == "Y") {
        document.form.tml_sto_agmt_tp_cd.disabled = false;
        document.form.ft_dys.disabled = false;
        document.form.agmt_ut_rt.disabled = false;
        document.form.tml_sto_agmt_tp_cd.value = "FD";
    }
    // sto_com_cmnc_tm_flg
    if (vfsArray[11] == "Y") {
        document.form.cmnc_hrmnt.disabled = false;
        document.form.ft_dys.disabled = false;
        document.form.agmt_ut_rt.disabled = false;
    }
    // sto_free_dy_io_bnd_flg
    if (vfsArray[12] == "Y") {
        document.form.io_bnd_cd[2].disabled = false;
        document.form.io_bnd_cd[3].disabled = false;
        document.form.ft_dys.disabled = false;
        document.form.agmt_ut_rt.disabled = false;
    }
    // sto_free_dy_flg
    if (vfsArray[13] == "Y") {
        //document.form.storage_gb[0].checked = true;
        //document.form.storage_gb[1].checked = false;
        document.form.storage_gb[0].disabled = false;
        document.form.storage_gb[1].disabled = false;
        document.form.ft_dys.disabled = false;
        document.form.agmt_ut_rt.disabled = false;
    }
    // sto_free_dy_dcgo_tm_flg
    if (vfsArray[14] == "Y") {
        document.form.dcgo_aply_tp_cd_FD[0].disabled = false;
        document.form.dcgo_aply_tp_cd_FD[1].disabled = false;
        document.form.dcgo_aply_tp_cd_FD[2].disabled = false;
        document.form.dcgo_n1st_clss_flg_FD.disabled = false;
        document.form.dcgo_n2nd_clss_flg_FD.disabled = false;
        document.form.dcgo_n3rd_clss_flg_FD.disabled = false;
        document.form.dcgo_n4th_clss_flg_FD.disabled = false;
        document.form.dcgo_n5th_clss_flg_FD.disabled = false;
        document.form.dcgo_n6th_clss_flg_FD.disabled = false;
        document.form.dcgo_n7th_clss_flg_FD.disabled = false;
        document.form.dcgo_n8th_clss_flg_FD.disabled = false;
        document.form.dcgo_n9th_clss_flg_FD.disabled = false;
        document.form.dcgo_none_clss_flg_FD.disabled = false;
    }
    // sto_free_dy_xcld_dt_flg
    if (vfsArray[15] == "Y") {
        document.form.sat_flg_FD.disable = false;
        document.form.sun_flg_FD.disable = false;
        document.form.hol_flg_FD.disable = false;
    }
    // sto_free_dy_dcgo_rt_flg
    if (vfsArray[16] == "Y") {
        document.form.dcgo_aply_tp_cd_R[0].disabled = false;
        document.form.dcgo_aply_tp_cd_R[1].disabled = false;
        document.form.dcgo_aply_tp_cd_R[2].disabled = false;
        document.form.dcgo_n1st_clss_flg_R.disabled = false;
        document.form.dcgo_n2nd_clss_flg_R.disabled = false;
        document.form.dcgo_n3rd_clss_flg_R.disabled = false;
        document.form.dcgo_n4th_clss_flg_R.disabled = false;
        document.form.dcgo_n5th_clss_flg_R.disabled = false;
        document.form.dcgo_n6th_clss_flg_R.disabled = false;
        document.form.dcgo_n7th_clss_flg_R.disabled = false;
        document.form.dcgo_n8th_clss_flg_R.disabled = false;
        document.form.dcgo_n9th_clss_flg_R.disabled = false;
        document.form.dcgo_none_clss_flg_R.disabled = false;
    }
    // sto_free_dy_tr_dy_flg
    if (vfsArray[17] == "Y") {
        document.form.cnt3.disable = false;
        document.form.cnt3.value = 1;
        var iRow = sheetObjects[3].DataInsert(-1);
        sheetObjects[3].SetCellValue(iRow, 0, "1", 0);
        sheetObjects[3].SetCellValue(iRow, 2, "1", 0);
        sheetObjects[3].SetCellValue(iRow, 3, "MAX", 0);
    }
    // sto_fp_calc_prd_flg
    if (vfsArray[18] == "Y") {
        document.form.fp_calc_prd_cd[0].disabled = false;
        document.form.fp_calc_prd_cd[1].disabled = false;
        document.form.agmt_ut_rt_fp.disabled = false;
    }
    // sto_fp_teu_flg
    if (vfsArray[19] == "Y") {
        document.form.fp_teu_qty.disabled = false;
        document.form.agmt_ut_rt_fp.disabled = false;
    }

    if (vfsArray[26] == "Y") {
        document.form.tml_cntr_sty_cd.disabled = false;
    }

    if (vfsArray[27] == "Y") {
        document.form.sto_tml_cntr_sty_cd.disabled = false;
    }

    if (vfsArray[28] == "Y") {
        document.form.sub_trd_cd.disabled = false;
    }
}

/**
 * Initialization Form Object Value <br>
 * 
 */
function initFormValue() {
    document.form.auto_calc_flg[1].checked = false;
    document.form.tml_agmt_vol_ut_cd[0].value = "";
    document.form.tml_agmt_vol_ut_cd[1].value = "";
    document.form.tml_agmt_vol_ut_cd[2].value = "";
    //comboObjects[0].Code2	= "-1";
    comboObjects[1].SetSelectCode("-1", false);
    document.form.io_bnd_cd[1].value = "";
    document.form.ioc_cd.value = "";
    document.form.tml_trns_mod_cd[0].value = "";
    document.form.tml_trns_mod_cd[1].value = "";
    document.form.tml_dy_aply_tp_cd[0].checked = false;
    document.form.tml_dy_aply_tp_cd[1].checked = false;
    document.form.wkdy_flg.checked = false;
    document.form.sat_flg.checked = false;
    document.form.sun_flg.checked = false;
    document.form.hol_flg.checked = false;
    comboObjects[2].SetSelectCode("-1", false);
    document.form.lane_cd.value = "";
    document.form.dcgo_aply_tp_cd[0].checked = false;
    document.form.dcgo_aply_tp_cd[1].checked = false;
    document.form.dcgo_aply_tp_cd[2].checked = false;
    document.form.dcgo_same[0].checked = false;
    document.form.dcgo_same[1].checked = false;
    document.form.dcgo_n1st_clss_flg.checked = false;
    document.form.dcgo_n2nd_clss_flg.checked = false;
    document.form.dcgo_n3rd_clss_flg.checked = false;
    document.form.dcgo_n4th_clss_flg.checked = false;
    document.form.dcgo_n5th_clss_flg.checked = false;
    document.form.dcgo_n6th_clss_flg.checked = false;
    document.form.dcgo_n7th_clss_flg.checked = false;
    document.form.dcgo_n8th_clss_flg.checked = false;
    document.form.dcgo_n9th_clss_flg.checked = false;
    document.form.dcgo_none_clss_flg.checked = false;
    document.form.cnt1.disable = false;
    document.form.cnt1.value = 0;
    document.form.cnt2.disable = false;
    document.form.cnt2.value = 0;
    document.form.thc_tp_cd[0].checked = false;
    document.form.thc_tp_cd_flg.checked = false;
    document.form.thc_tp_cd[1].checked = false;
    document.form.thc_tp_cd[2].checked = false;
    document.form.cntr_ts[0].checked = false;
    document.form.cntr_ts[1].checked = false;
    document.form.agmt_rate.value = "";
    comboObjects[3].SetSelectCode("-1", false);
    comboObjects[4].SetSelectCode("-1", false);
    document.form.agmt_rate.value = "";
    document.form.tml_sto_agmt_tp_cd.value = "";

    document.form.cmnc_hrmnt.value = "";

    document.form.tml_agmt_vol_ut_cd[2].value = "";
    //comboObjects[5].Code2="-1";
    comboObjects[6].SetSelectCode("-1", false);
    document.form.storage_gb[0].checked = false;
    document.form.storage_gb[1].checked = false;
    document.form.io_bnd_cd[2].value = "";
    document.form.dcgo_aply_tp_cd_FD[0].checked = false;
    document.form.dcgo_aply_tp_cd_FD[1].checked = false;
    document.form.dcgo_aply_tp_cd_FD[2].checked = false;
    document.form.dcgo_same_FD[0].checked = false;
    document.form.dcgo_same_FD[1].checked = false;
    document.form.dcgo_n1st_clss_flg_FD.checked = false;
    document.form.dcgo_n2nd_clss_flg_FD.checked = false;
    document.form.dcgo_n3rd_clss_flg_FD.checked = false;
    document.form.dcgo_n4th_clss_flg_FD.checked = false;
    document.form.dcgo_n5th_clss_flg_FD.checked = false;
    document.form.dcgo_n6th_clss_flg_FD.checked = false;
    document.form.dcgo_n7th_clss_flg_FD.checked = false;
    document.form.dcgo_n8th_clss_flg_FD.checked = false;
    document.form.dcgo_n9th_clss_flg_FD.checked = false;
    document.form.dcgo_none_clss_flg_FD.checked = false;
    document.form.sat_flg_FD.checked = false;
    document.form.sun_flg_FD.checked = false;
    document.form.hol_flg_FD.checked = false;
    document.form.ft_dys.value = "";
    document.form.io_bnd_cd[3].value = "";
    document.form.dcgo_aply_tp_cd_R[0].checked = false;
    document.form.dcgo_aply_tp_cd_R[1].checked = false;
    document.form.dcgo_aply_tp_cd_R[2].checked = false;
    document.form.dcgo_same_R[0].checked = false;
    document.form.dcgo_same_R[1].checked = false;
    document.form.dcgo_n1st_clss_flg_R.checked = false;
    document.form.dcgo_n2nd_clss_flg_R.checked = false;
    document.form.dcgo_n3rd_clss_flg_R.checked = false;
    document.form.dcgo_n4th_clss_flg_R.checked = false;
    document.form.dcgo_n5th_clss_flg_R.checked = false;
    document.form.dcgo_n6th_clss_flg_R.checked = false;
    document.form.dcgo_n7th_clss_flg_R.checked = false;
    document.form.dcgo_n8th_clss_flg_R.checked = false;
    document.form.dcgo_n9th_clss_flg_R.checked = false;
    document.form.dcgo_none_clss_flg_R.checked = false;
    document.form.cnt3.value = 0;
    document.form.cnt3.disable = false;
    document.form.agmt_ut_rt.value = "";
    document.form.cntr_ts[2].checked = false;
    document.form.cntr_ts[3].checked = false;
    comboObjects[7].SetSelectCode("-1", false);
    comboObjects[8].SetSelectCode("-1", false);
    document.form.fp_calc_prd_cd[0].checked = false;
    document.form.fp_calc_prd_cd[1].checked = false;
    document.form.fp_teu_qty.value = "";
    document.form.agmt_ut_rt_fp.value = "";
    document.form.tml_cntr_sty_cd.value = "";
    document.form.sto_tml_cntr_sty_cd.value = "";
    document.form.sub_trd_cd.value = "";

}

/**
 * Initialization Form Object Disable<br>
 * 
 */
function initFormDisabled() {
    document.form.tml_agmt_vol_ut_cd[1].value = "";
    document.form.tml_agmt_vol_ut_cd[2].value = "";
    document.form.tml_agmt_vol_ut_cd[1].disabled = true;
    comboObjects[1].SetEnable(0);
    sheetObjects[0].RemoveAll();
    sheetObjects[1].RemoveAll();
    sheetObjects[3].RemoveAll();
    document.form.auto_calc_flg[0].disabled = true;
    document.form.auto_calc_flg[1].disabled = true;
    document.form.io_bnd_cd[1].disabled = true;
    document.form.ioc_cd.disabled = true;
    document.form.tml_dy_aply_tp_cd[0].disabled = true;
    document.form.tml_dy_aply_tp_cd[1].disabled = true;
    document.form.wkdy_flg.disabled = true;
    document.form.sat_flg.disabled = true;
    document.form.sun_flg.disabled = true;
    document.form.hol_flg.disabled = true;
    comboObjects[2].SetEnable(0);
    document.form.dcgo_aply_tp_cd[0].disabled = true;
    document.form.dcgo_aply_tp_cd[1].disabled = true;
    document.form.dcgo_aply_tp_cd[2].disabled = true;
    document.form.dcgo_n1st_clss_flg.disabled = true;
    document.form.dcgo_n2nd_clss_flg.disabled = true;
    document.form.dcgo_n3rd_clss_flg.disabled = true;
    document.form.dcgo_n4th_clss_flg.disabled = true;
    document.form.dcgo_n5th_clss_flg.disabled = true;
    document.form.dcgo_n6th_clss_flg.disabled = true;
    document.form.dcgo_n7th_clss_flg.disabled = true;
    document.form.dcgo_n8th_clss_flg.disabled = true;
    document.form.dcgo_n9th_clss_flg.disabled = true;
    document.form.dcgo_none_clss_flg.disabled = true;
    document.form.cnt1.value = 0;
    document.form.cnt1.disabled = true;
    document.form.cnt2.value = 0;
    document.form.cnt2.disabled = true;
    document.form.thc_tp_cd[0].disabled = true;
    document.form.thc_tp_cd_flg.disabled = true;
    document.form.thc_tp_cd[1].disabled = true;
    document.form.thc_tp_cd[2].disabled = true;
    document.form.cntr_ts[0].disabled = true;
    document.form.cntr_ts[1].disabled = true;
    comboObjects[3].SetEnable(0);
    comboObjects[4].SetEnable(0);
    document.form.agmt_rate.disabled = true;
    document.form.tml_sto_agmt_tp_cd.disabled = true;
    document.form.tml_agmt_vol_ut_cd[2].disabled = true;
    document.form.cmnc_hrmnt.disabled = true;
    comboObjects[6].SetEnable(0);
    document.form.storage_gb[0].disabled = true;
    document.form.storage_gb[1].disabled = true;
    document.form.io_bnd_cd[2].disabled = true;
    document.form.dcgo_aply_tp_cd_FD[0].disabled = true;
    document.form.dcgo_aply_tp_cd_FD[1].disabled = true;
    document.form.dcgo_aply_tp_cd_FD[2].disabled = true;
    document.form.dcgo_same_FD[0].disabled = true;
    document.form.dcgo_same_FD[1].disabled = true;
    document.form.dcgo_n1st_clss_flg_FD.disabled = true;
    document.form.dcgo_n2nd_clss_flg_FD.disabled = true;
    document.form.dcgo_n3rd_clss_flg_FD.disabled = true;
    document.form.dcgo_n4th_clss_flg_FD.disabled = true;
    document.form.dcgo_n5th_clss_flg_FD.disabled = true;
    document.form.dcgo_n6th_clss_flg_FD.disabled = true;
    document.form.dcgo_n7th_clss_flg_FD.disabled = true;
    document.form.dcgo_n8th_clss_flg_FD.disabled = true;
    document.form.dcgo_n9th_clss_flg_FD.disabled = true;
    document.form.dcgo_none_clss_flg_FD.disabled = true;
    document.form.sat_flg_FD.disabled = true;
    document.form.sun_flg_FD.disabled = true;
    document.form.hol_flg_FD.disabled = true;
    document.form.ft_dys.disabled = true;
    document.form.io_bnd_cd[3].disabled = true;
    document.form.dcgo_aply_tp_cd_R[0].disabled = true;
    document.form.dcgo_aply_tp_cd_R[1].disabled = true;
    document.form.dcgo_aply_tp_cd_R[2].disabled = true;
    document.form.dcgo_same_R[0].disabled = true;
    document.form.dcgo_same_R[1].disabled = true;
    document.form.dcgo_n1st_clss_flg_R.disabled = true;
    document.form.dcgo_n2nd_clss_flg_R.disabled = true;
    document.form.dcgo_n3rd_clss_flg_R.disabled = true;
    document.form.dcgo_n4th_clss_flg_R.disabled = true;
    document.form.dcgo_n5th_clss_flg_R.disabled = true;
    document.form.dcgo_n6th_clss_flg_R.disabled = true;
    document.form.dcgo_n7th_clss_flg_R.disabled = true;
    document.form.dcgo_n8th_clss_flg_R.disabled = true;
    document.form.dcgo_n9th_clss_flg_R.disabled = true;
    document.form.dcgo_none_clss_flg_R.disabled = true;
    document.form.cnt3.value = 0;
    document.form.cnt3.disabled = true;
    document.form.agmt_ut_rt.disabled = true;
    document.form.cntr_ts[2].disabled = true;
    document.form.cntr_ts[3].disabled = true;
    comboObjects[7].SetEnable(0);
    comboObjects[8].SetEnable(0);
    document.form.fp_calc_prd_cd[0].disabled = true;
    document.form.fp_calc_prd_cd[1].disabled = true;
    document.form.fp_teu_qty.disabled = true;
    document.form.agmt_ut_rt_fp.disabled = true;
    document.form.tml_cntr_sty_cd.disabled = true;
    document.form.sto_tml_cntr_sty_cd.disabled = true;
    document.form.sub_trd_cd.disabled = true;

}

/**
 * Agreement Validate.<br>
 * @param{vfsArray}		vfsArray	vfsArray
 */
function agreementVaildate(vfsArray) {
    if (vfsArray[0] == "Y") {
        if (document.form.auto_calc_flg[0].checked == false && document.form.auto_calc_flg[1].checked == false) {
            ComShowCodeMessage('TES10055');
            return false;
        }
    }
    if (vfsArray[1] == "Y") {
        //document.form.io_bnd_cd[1].disabled=false;
    }
    if (vfsArray[2] == "Y") {
        if (ComIsNull(document.form.io_bnd_cd[1].value)) {
            ComShowCodeMessage('TES10056');
            return false;
        }
    }
    if (vfsArray[3] == "Y") {
        if (ComIsNull(document.form.ioc_cd.value)) {
            ComShowCodeMessage('TES10057');
            return false;
        }
    }
    if (vfsArray[4] == "Y") {
        if (ComIsNull(getElementValue(document.form, 'radio', 'tml_dy_aply_tp_cd'))) {
            ComShowCodeMessage('TES10058');
            return false;
        }
    }
    /**
    if(vfsArray[5] == "Y"){
    	if(ComIsNull(document.form.lane_cd.value)){
    		ComShowCodeMessage('TES10059');
    		return false;
    	}
    }
    **/
    if (vfsArray[6] == "Y") {
        if (ComIsNull(getElementValue(document.form, 'radio', 'dcgo_aply_tp_cd'))) {
            ComShowCodeMessage('TES10043');
            return false;
        }
        if (getElementValue(document.form, 'radio', 'dcgo_aply_tp_cd') == "A") {
            if (ComIsNull(getElementValue(document.form, 'radio', 'dcgo_same'))) {
                ComShowCodeMessage('TES10044');
                return false;
            }
        }
        if (getElementValue(document.form, 'radio', 'dcgo_aply_tp_cd') == "S") {
            if (document.form.dcgo_n1st_clss_flg.checked == false && document.form.dcgo_n2nd_clss_flg.checked == false && document.form.dcgo_n3rd_clss_flg.checked == false && document.form.dcgo_n4th_clss_flg.checked == false && document.form.dcgo_n5th_clss_flg.checked == false && document.form.dcgo_n6th_clss_flg.checked == false && document.form.dcgo_n7th_clss_flg.checked == false && document.form.dcgo_n8th_clss_flg.checked == false && document.form.dcgo_n9th_clss_flg.checked == false && document.form.dcgo_none_clss_flg.checked == false) {
                ComShowCodeMessage('TES10045');
                return false;
            }
        }
    }
    if (vfsArray[7] == "Y") {
        if (sheetObjects[0].CheckedRows(0) == "0") {
            ComShowCodeMessage('TES10047');
            return false;
        } else {
            if (sheetObjects[0].GetCellValue(sheetObjects[0].FindCheckedRow(0) + "|".substr(0, 1), 2) == "" || sheetObjects[0].GetCellValue(sheetObjects[0].FindCheckedRow(0) + "|".substr(0, 1), 3) == "") {
                ComShowCodeMessage('TES10062');
                return false;
            }
        }
    }
    if (vfsArray[8] == "Y") {
        if (sheetObjects[1].CheckedRows(0) == "0") {
            ComShowCodeMessage('TES10063');
            return false;
        } else {
            if (sheetObjects[1].GetCellValue(sheetObjects[1].FindCheckedRow(0) + "|".substr(0, 1), 2) == "") {
                ComShowCodeMessage('TES10064');
                return false;
            }
        }
    }
    if (vfsArray[9] == "Y") {
        if (ComIsNull(getElementValue(document.form, 'radio', 'thc_tp_cd'))) {
            ComShowCodeMessage('TES10065');
            return false;
        }
    }
    if (vfsArray[10] == "Y") {
        if (ComIsNull(document.form.tml_sto_agmt_tp_cd.value)) {
            ComShowCodeMessage('TES10037');
            return false;
        }
    }
    if (vfsArray[11] == "Y") {
        if (ComIsNull(document.form.cmnc_hrmnt.value)) {
            ComShowCodeMessage('TES10037');
            return false;
        }
    }
    if (vfsArray[12] == "Y") {
        if (document.form.storage_gb[0].checked == true) {
            if (ComIsNull(document.form.io_bnd_cd[2].value)) {
                ComShowCodeMessage('TES10056');
                return false;
            }
        } else if (document.form.storage_gb[1].checked == true) {
            if (ComIsNull(document.form.io_bnd_cd[3].value)) {
                ComShowCodeMessage('TES10056');
                return false;
            }
        }
    }
    if (vfsArray[13] == "Y") {
        if (document.form.storage_gb[0].checked == false && document.form.storage_gb[1].checked == false) {
            ComShowCodeMessage('TES10042');
            return false;
        }
    }
    if (vfsArray[14] == "Y") {
        if (ComIsNull(getElementValue(document.form, 'radio', 'dcgo_aply_tp_cd_FD'))) {
            ComShowCodeMessage('TES10043');
            return false;
        }
        if (getElementValue(document.form, 'radio', 'dcgo_aply_tp_cd_FD') == "A") {
            if (ComIsNull(getElementValue(document.form, 'radio', 'dcgo_same_FD'))) {
                ComShowCodeMessage('TES10044');
                return false;
            }
        }
        if (getElementValue(document.form, 'radio', 'dcgo_aply_tp_cd_FD') == "S") {
            if (document.form.dcgo_n1st_clss_flg_FD.checked == false && document.form.dcgo_n2nd_clss_flg_FD.checked == false && document.form.dcgo_n3rd_clss_flg_FD.checked == false && document.form.dcgo_n4th_clss_flg_FD.checked == false && document.form.dcgo_n5th_clss_flg_FD.checked == false && document.form.dcgo_n6th_clss_flg_FD.checked == false && document.form.dcgo_n7th_clss_flg_FD.checked == false && document.form.dcgo_n8th_clss_flg_FD.checked == false && document.form.dcgo_n9th_clss_flg_FD.checked == false && document.form.dcgo_none_clss_flg_FD.checked == false) {
                ComShowCodeMessage('TES10045');
                return false;
            }
        }
    }
    /**
    if(vfsArray[15] == "Y"){
    	if (document.form.sat_flg_FD.checked == false && document.form.sun_flg_FD.checked == false && document.form.hol_flg_FD.checked == false){
    		ComShowMessage("Exclude Date 선택하세요.");
    		return false;
    	}
    }
    **/
    if (vfsArray[16] == "Y") {
        if (ComIsNull(getElementValue(document.form, 'radio', 'dcgo_aply_tp_cd_R'))) {
            ComShowCodeMessage('TES10043');
            return false;
        }
        if (getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_R') == "A") {
            if (ComIsNull(getElementValue(document.form, 'radio', 'dcgo_same_R'))) {
                ComShowCodeMessage('TES10044');
                return false;
            }
        }
        if (getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_R') == "S") {
            if (document.form.dcgo_n1st_clss_flg_R.checked == false && document.form.dcgo_n2nd_clss_flg_R.checked == false && document.form.dcgo_n3rd_clss_flg_R.checked == false && document.form.dcgo_n4th_clss_flg_R.checked == false && document.form.dcgo_n5th_clss_flg_R.checked == false && document.form.dcgo_n6th_clss_flg_R.checked == false && document.form.dcgo_n7th_clss_flg_R.checked == false && document.form.dcgo_n8th_clss_flg_R.checked == false && document.form.dcgo_n9th_clss_flg_R.checked == false && document.form.dcgo_none_clss_flg_R.checked == false) {
                ComShowCodeMessage('TES10045');
                return false;
            }
        }
    }
    /**
    	if(vfsArray[17] == "Y"){
    		if(sheetObjects[4].CheckedRows(0) == "0"){
    			ComShowMessage("No of Tier Days 확인하세요.");
    			return false;
    		}else{
    	if(sheetObjects[4].GetCellValue(sheetObjects[0].FindCheckedRow(0)+"|".substr(0,1),2)==""||sheetObjects[4].GetCellValue(sheetObjects[0].FindCheckedRow(0)+"|".substr(0,1),3)==""){
    				ComShowMessage("No of Volume Days 값을 입력하세요.");
    				return false;
    			}
    		}
    	}
    	**/
    if (vfsArray[18] == "Y") {
        if (document.form.fp_calc_prd_cd[0].checked == false || document.form.fp_calc_prd_cd[1].checked == false) {
            ComShowCodeMessage('TES10048');
            return false;
        }
    }
    if (vfsArray[19] == "Y") {
        if (ComIsNull(document.form.fp_teu_qty.value)) {
            ComShowCodeMessage('TES10049');
            return false;
        }
    }

    if (vfsArray[26] == "Y") {
        if (ComIsNull(document.form.tml_cntr_sty_cd.value)) {
            ComShowCodeMessage('TES21053');
            document.form.tml_cntr_sty_cd.focus();
            return false;
        }

    }

    if (vfsArray[27] == "Y") {
        if (ComIsNull(document.form.sto_tml_cntr_sty_cd.value)) {
            ComShowCodeMessage('TES21053');
            document.form.sto_tml_cntr_sty_cd.focus();
            return false;
        }
    }
    if (vfsArray[28] == "Y") {
        if (ComIsNull(document.form.sub_trd_cd.value)) {
            ComShowCodeMessage('TES21055');
            document.form.sub_trd_cd.focus();
            return false;
        }
    }

    return true;
}

/**
 * Validationg check time format <br>
 * @param {obj}    obj		Objcet
 **/
function isValidHHMM(obj) {
    str = obj.value.replace(":", "");
    //ComShowMessage(str);
    if (!isNumHHMM(obj)) {
        return false;
    }
    if (str.length != 4) {
        return false;
    }
    var hour = str.substring(0, 2);
    var minute = str.substring(2, 4);
    if (parseInt(hour) <= 23 && parseInt(minute) <= 59)
        return true;
    else if (parseInt(hour) == 24 && parseInt(minute) == 00) {
        return true;
    } else {
        obj.value = "";
        return false;
    }
}

/**
 * Input Value check <br>
 * @param {obj}		obj		Object
 **/
function isNumHHMM(obj) {
    var chars = ":0123456789";
    return ComIsContainsCharsOnly(obj, chars);
}

/**
 * Input Value Check. <br>
 * @param {obj}    Text Value
 **/
function chkInput(obj) {
    //	ComShowMessage(obj.maxLength + ' / ' + obj.value.length);
    //	ComShowMessage('strleng: '+getStrLen(obj.value));
    if (obj.maxLength < getStrLen(obj.value)) {
        obj.value = ''; //substring(obj.value,0,obj.maxLength);
        obj.focus();
        return false;
    }
}

/**
 * @param {obj}    Text Value
 **/
function isNum(obj) {
    if (!ComIsNumber(obj)) {
        obj.value = '';
    }
}

/**
 * @param {obj}    Text Value
 **/
function isNum1(obj) {
    if (!ComIsNumber(obj, '-')) {
        obj.value = '';
    }
}

/**
 * @param {obj}    Text Value
 **/
function isApNum(obj) {
    if (!ComIsAlphabet(obj, 'u')) {
        obj.value = '';
    }
}

/**
 * @param {obj}    Text Value
 **/
function isApNum1(obj) {
    if (!ComIsAlphabet(obj, 'n')) {
        obj.value = '';
    }
    //obj.value = obj.value.toUpperCase();
}

/**
 * @param {obj}    Text Value
 **/
function isApNum2(obj) {
    if (!ComIsAlphabet(obj, 'n')) {
        obj.value = '';
    }
    obj.value = obj.value.toUpperCase();
}

/**
 * @param {src}    Text Value
 **/
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
 * Agreement Format Check. <br>
 * @param {dt}    Text Value
 **/
function checkAgmtFormat(dt) {
    var date_regexp = "^([A-Z]{3}\\d{5})$";
    if (dt.search(date_regexp) != -1) {
        return true;
    } else {
        return false;
    }
}

/**
 * Commence Time as HH:MM format Check. <br>
 * @param {dt}    Text Value
 **/
function checkCmncFormat(dt) {
    var date_regexp = "^(\\d{2}:\\d{2})$";
    if (dt.search(date_regexp) != -1) {
        return true;
    } else {
        return false;
    }
}

/**
 * Effective Date As Format Check. <br>
 * @param {dt}    dt	Text Value
 **/
function checkEffFormat(dt) {
    var date_regexp = "^(\\d{4}-\\d{2}-\\d{2})$";
    if (!checkFormat(dt, date_regexp)) {
        return false;
    }
    /*
    		var date_regexp=/(^\d{4}-\d{2}-\d{2}$)/;
    		if (fm_prd_dt.search(date_regexp) != -1) {
    			return true;
    		} else {
    			return false;
    		}
    */
    return true;
}

/** check format
 * @param {object}    Text Value
 * @param {regexp}    
 **/
function checkFormat(object, regexp) {
    if (object == null || object == "") {
        return false;
    } else {
        re = new RegExp(regexp, "gi");
        if (!re.test(object)) {
            return false;
        }
    }
    return true;
}

/**
 * Validation check Yard Code <br>
 **/
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
        tes_getInputValue('is_valid_yd_cd', SEARCH05, 'yd_cd', 'checkValidYardCode');
    }
}

/**
 * Yard Code  Validate Check. <br>
 **/
function checkValidYardCode() {
    var formObj = document.form;
    var tmp = '';
    if (formObj.is_valid_yd_cd.value != undefined && formObj.is_valid_yd_cd.value != null && formObj.is_valid_yd_cd.value.trim() != '') {
        tmp = formObj.is_valid_yd_cd.value.split('|');
        if (tmp.length > 0) {
            formObj.is_valid_yd_cd.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_yd_cd.value != null && formObj.is_valid_yd_cd.value == 'Y') {
                //					formObj.yd_cd_name.value=(tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');
                formObj.yd_cd_hidden.value = formObj.yd_cd.value;
                //					if(sheetObjects[5].CellValue(1, 1)!= "" && sheetObjects[5].CellValue(1, 2)!= "" && sheetObjects[5].CellValue(1, 1)!= undefined && sheetObjects[5].CellValue(1, 2)!= undefined){
                if (sheetObjects[5].GetCellValue(1, "tml_agmt_ofc_cty_cd") != "" && sheetObjects[5].GetCellValue(1, "tml_agmt_ofc_cty_cd") != undefined) {
                    lane_Change();
                }
                /**
                formObj.yd_cd_deltflg.value=(tmp[9]!=undefined&&tmp[9]!=null?tmp[9]:'');
                if(formObj.yd_cd_deltflg.value=="Y"){
                		ComShowCodeMessage('TES10129');
                }
                **/
                vndr_seq_Focus();
            } else {
                formObj.is_valid_yd_cd.value = '';
                formObj.yd_cd_hidden.value = '';
                //formObj.yd_cd.value = '';
                formObj.yd_cd_name.value = '';
                ComShowCodeMessage('TES10066');
            }
        } else {
            formObj.is_valid_yd_cd.value = '';
            formObj.yd_cd_hidden.value = '';
            //formObj.yd_cd.value = '';
            formObj.yd_cd_name.value = '';
            ComShowCodeMessage('TES10066');
        }
    } else {
        formObj.is_valid_yd_cd.value = '';
        formObj.yd_cd_hidden.value = '';
        //formObj.yd_cd.value = '';
        formObj.yd_cd_name.value = '';
        ComShowCodeMessage('TES10066');
    }
}

/**
 * Vendor Code  Validate. <br>
 **/
function validateVendorCode() {
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
        
        var sRtnVal = getVndrSeqNm("vndr_seq_name");
        if(sRtnVal == "Y"){
        	formObj.is_valid_vndr_seq.value = sRtnVal;
        	formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
        } else {
        	formObj.vndr_seq.value = "";
        }
        
        //doActionIBSheet5(sheetObjects[5], formObj, IBSEARCH_ASYNC05);
        //tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVendorCode');
    }
}

/**
 * Vendor Code  Validate Check. <br>
 **/
function checkValidVendorCode() {
    var formObj = document.form;
    var tmp = '';
    if (formObj.is_valid_vndr_seq.value != undefined && formObj.is_valid_vndr_seq.value != null && formObj.is_valid_vndr_seq.value.trim() != '') {
        tmp = formObj.is_valid_vndr_seq.value.split('|');
        if (tmp.length > 0) {
            formObj.is_valid_vndr_seq.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_vndr_seq.value != null && formObj.is_valid_vndr_seq.value == 'Y') {
                //					formObj.vndr_seq_name.value=(tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
                formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
                cont_ofc_Focus();
            } else {
                formObj.is_valid_vndr_seq.value = '';
                formObj.vndr_seq_hidden.value = '';
                //formObj.vndr_seq.value = '';
                formObj.vndr_seq_name.value = '';
                ComShowCodeMessage('TES10067');
            }
        } else {
            formObj.is_valid_vndr_seq.value = '';
            formObj.vndr_seq_hidden.value = '';
            //formObj.vndr_seq.value = '';
            formObj.vndr_seq_name.value = '';
            ComShowCodeMessage('TES10067');
        }
    } else {
        formObj.is_valid_vndr_seq.value = '';
        formObj.vndr_seq_hidden.value = '';
        //formObj.vndr_seq.value = '';
        formObj.vndr_seq_name.value = '';
        ComShowCodeMessage('TES10067');
    }
}

/**
 * Form Object Value Setting. <br>
 * Agreement Header Info t1sheet3. <br>
 **/
function insertData() {
    var formObject = document.form;
    var tml_agmt_sts_cd = "";
    hdrRetrieveFlg = "Y";
    agmt_no = "";
    //sheetObjects[5].CellValue(1, 1) : agmt_no
    //sheetObjects[5].CellValue(1, 2) : agmt_ver
    //sheetObjects[5].CellValue(1, 3) : yd_cd
    /* if ( sheetObjects[5].GetCellValue(1, "tml_agmt_ofc_cty_cd") != ""
        	&& sheetObjects[5].GetCellValue(1, "tml_agmt_ver_no") != "" ) { */ // nodata일 경우 -1 값 넘어와 조건 변경 
    if (sheetObjects[5].RowCount() > 0) {
        //sheetObjects[5].CellValue(1, 21) : creation office
        if (sheetObjects[5].GetCellValue(1, "cre_ofc_cd") != formObject.cre_ofc_cd.value) {
            ComShowCodeMessage('TES50203'); // ComShowMessage('No authority to correct/delete the agreement - Creation office mismatch!');
            agmt_no = "";
            agmtRegFlg = "";
            hdrRetrieveFlg = "";
            formObject.reset();
            formObject.inquiryFlg.value = "";
            formObject.tml_agmt_sts_cd.value = "";
            initFormValue();
            initFormDisabled();
            sheetObjects[0].RemoveAll();
            sheetObjects[1].RemoveAll();
            sheetObjects[2].RemoveAll();
            sheetObjects[3].RemoveAll();
            sheetObjects[4].RemoveAll();
            sheetObjects[5].RemoveAll();
            formObject.yd_cd.readOnly = false;
            formObject.vndr_seq.readOnly = false;
            formObject.ctrt_ofc_cd.readOnly = false;
            formObject.amend_flg[0].disabled = true;
            formObject.amend_flg[1].disabled = true;
            return "NoData";
        }
        formObject.tml_agmt_ofc_cty_cd.value = sheetObjects[5].GetCellValue(1, "tml_agmt_ofc_cty_cd");
        formObject.tml_agmt_ver_no.value = sheetObjects[5].GetCellValue(1, "tml_agmt_ver_no");
        formObject.yd_cd.value = sheetObjects[5].GetCellValue(1, "yd_cd");
        formObject.yd_cd_name.value = sheetObjects[5].GetCellValue(1, "yd_nm");
        formObject.vndr_seq.value = sheetObjects[5].GetCellValue(1, "vndr_seq");
        formObject.vndr_seq_name.value = sheetObjects[5].GetCellValue(1, "vndr_lgl_eng_nm");
        formObject.eff_fm_dt.value = sheetObjects[5].GetCellValue(1, "eff_fm_dt");
        formObject.eff_to_dt.value = sheetObjects[5].GetCellValue(1, "eff_to_dt");
        formObject.auto_xtd_flg.value = sheetObjects[5].GetCellValue(1, "auto_xtd_flg");
        formObject.ctrt_ofc_cd.value = sheetObjects[5].GetCellValue(1, "ctrt_ofc_cd");
        formObject.tml_agmt_sts_cd.value = sheetObjects[5].GetCellValue(1, "tml_agmt_sts_cd");
        tml_agmt_sts_cd = sheetObjects[5].GetCellValue(1, "tml_agmt_sts_cd");
        formObject.agmt_rmk.value = sheetObjects[5].GetCellValue(1, "agmt_rmk");
        //comboObjects[0].Code	 				= sheetObjects[5].CellValue(1, 13); 
        //comboObjects[5].Code	 				= sheetObjects[5].CellValue(1, 13); sheetObjects[5].CellValue(1, 13) : cost_cd
        formObject.auto_calc_flg.value = sheetObjects[5].GetCellValue(1, "auto_calc_flg");
        formObject.tml_agmt_vol_ut_cd[1].value = sheetObjects[5].GetCellValue(1, "tml_agmt_vol_ut_cd");
        //comboObjects[1].Code	 				= sheetObjects[5].CellValue(1, 16); 
        //comboObjects[6].Code	 				= sheetObjects[5].CellValue(1, 16); sheetObjects[5].CellValue(1, 16) : currency
        //formObject.tml_sto_agmt_tp_cd.value	= sheetObjects[5].CellValue(1, 18);
        //formObject.cmnc_hrmnt.value			= sheetObjects[5].CellValue(1, 19);
        document.form.command_h.value = "S";
        formObject.yd_cd.readOnly = true;
        formObject.vndr_seq.readOnly = true;
        formObject.ctrt_ofc_cd.readOnly = true;
        for (var i = 0; i < getElementCnt(formObject, 'radio', 'auto_xtd_flg'); i++) {
            if (sheetObjects[5].GetCellValue(1, "auto_xtd_flg") == "Y") {
                formObject.auto_xtd_flg[i].checked = true;
                formObject.auto_xtd_flg[i + 1].checked = false;
                break;
            } else if (sheetObjects[5].GetCellValue(1, "auto_xtd_flg") == "N") {
                formObject.auto_xtd_flg[i].checked = false;
                formObject.auto_xtd_flg[i + 1].checked = true;
                break;
            }
        }
        for (var i = 0; i < getElementCnt(formObject, 'radio', 'auto_xtd_flg'); i++) {
            if (formObject.tml_agmt_sts_cd.value == "P") {
                formObject.auto_xtd_flg[i].disabled = false;
            }
        }
        for (var i = 0; i < getElementCnt(formObject, 'radio', 'amend_flg'); i++) {
            if (formObject.tml_agmt_sts_cd.value == "P") {
                formObject.amend_flg[i].disabled = true;
            } else if (formObject.tml_agmt_sts_cd.value == "C") {
                formObject.amend_flg[i].disabled = false;
            }
        }
        for (var i = 0; i < getElementCnt(formObject, 'radio', 'auto_calc_flg'); i++) {
            //                if(sheetObjects[5].CellValue(1, 14)=="Y"){
            if (sheetObjects[5].GetCellValue(1, "auto_calc_flg") == "Y") {
                formObject.auto_calc_flg[i].checked = true;
                formObject.auto_calc_flg[i + 1].checked = false;
                break;
            } else if (sheetObjects[5].GetCellValue(1, "auto_calc_flg") == "N") {
                formObject.auto_calc_flg[i].checked = false;
                formObject.auto_calc_flg[i + 1].checked = true;
                break;
            }
        }
        document.form.auto_calc_flg.value = sheetObjects[5].GetCellValue(1, "auto_calc_flg"); // 14
        document.form.initFormDTLFlg.value = "Y"
        if (tml_agmt_sts_cd == "C") {
            document.form.amend_flg[0].disabled = false;
            document.form.amend_flg[1].disabled = false;
            document.form.amend_flg[0].checked = false;
            document.form.amend_flg[1].checked = true;
        } else if (tml_agmt_sts_cd == "P") {} else if (tml_agmt_sts_cd == "" || tml_agmt_sts_cd == null) {
            document.form.initFormDTLFlg.value = "N"
            document.form.tml_agmt_ofc_cty_cd.value = "";
            document.form.tml_agmt_ver_no.value = "";
            document.form.yd_cd.value = "";
            document.form.yd_cd_name.value = "";
            document.form.vndr_seq.value = "";
            document.form.vndr_seq_name.value = "";
            document.form.eff_fm_dt.value = "";
            document.form.eff_to_dt.value = "";
            document.form.auto_xtd_flg[0].checked = false;
            document.form.auto_xtd_flg[1].checked = false;
            document.form.amend_flg[0].checked = false;
            document.form.amend_flg[1].checked = false;
            document.form.agmt_rmk.value = "";
        }
        //        } else if(sheetObjects[5].CellValue(1, 1) == "" && sheetObjects[5].CellValue(1, 2) == ""){ 1: ofc_cd, 2:seq )
        /*} else if(sheetObjects[5].GetCellValue(1, "tml_agmt_ofc_cty_cd") == "" ) {*/ //nodata일 경우 -1 값 넘어와 조건 변경
    } else if (sheetObjects[5].RowCount() < 1) {
        var hdr_gb = ComShowConfirm(ComGetMsg('TES10116'));
        if (hdr_gb == true) {
            agmtRegFlg = "Y";
            document.form.initFormDTLFlg.value = "N"
            document.form.tml_agmt_ofc_cty_cd.value = "";
            document.form.tml_agmt_ver_no.value = "";
            initFormValue();
            initFormDisabled();
        } else {
            agmtRegFlg = "N";
            //document.form.reset();
        }
        return "NoData"
            //        } else if(sheetObjects[5].CellValue(1, 1) != "" && sheetObjects[5].CellValue(1, 2) != "" && sheetObjects[5].CellValue(1, 3) == "" && sheetObjects[5].CellValue(1, 5) == ""){
            /*} else if(sheetObjects[5].GetCellValue(1, "tml_agmt_ofc_cty_cd") != "" && sheetObjects[5].GetCellValue(1, "tml_agmt_ver_no") != "" && sheetObjects[5].GetCellValue(1, "vndr_seq") == "" ){ */ //불필요 조건
    }
}

/**
 * Form Object Detail Value Setting. <br>
 **/
function initformDTL() {
    if (document.form.initFormDTLFlg.value == "Y") {
        document.form.tml_agmt_vol_ut_cd[1].value = "";
        document.form.tml_agmt_vol_ut_cd[2].value = "";
        document.form.tml_agmt_vol_ut_cd[1].disabled = false;
        comboObjects[0].SetEnable(1);
        comboObjects[1].SetEnable(1);
        sheetObjects[0].RemoveAll();
        sheetObjects[1].RemoveAll();
        sheetObjects[3].RemoveAll();
        document.form.auto_calc_flg[0].checked = false;
        document.form.auto_calc_flg[1].checked = false;
        if (tabObjects[0].GetSelectedIndex() == "0" || tabObjects[0].GetSelectedIndex() == "1") {
            comboObjects[0].SetSelectCode(sheetObjects[5].GetCellValue(1, "lgs_cost_cd")); // 13
            comboObjects[1].SetSelectCode(sheetObjects[5].GetCellValue(1, "curr_cd")); // 16
            document.form.auto_calc_flg.value = sheetObjects[5].GetCellValue(1, "auto_calc_flg"); // 14
            document.form.tml_agmt_vol_ut_cd[1].value = sheetObjects[5].GetCellValue(1, "tml_agmt_vol_ut_cd"); // 15
        } else if (tabObjects[0].GetSelectedIndex() == "2" || tabObjects[0].GetSelectedIndex() == "3") {
            comboObjects[5].SetSelectCode(sheetObjects[5].GetCellValue(1, "lgs_cost_cd")); // 13
            comboObjects[6].SetSelectCode(sheetObjects[5].GetCellValue(1, "curr_cd")); // 16
            document.form.tml_agmt_vol_ut_cd[2].value = sheetObjects[5].GetCellValue(1, "tml_agmt_vol_ut_cd"); // 15
            document.form.tml_sto_agmt_tp_cd.value = sheetObjects[5].GetCellValue(1, "tml_sto_agmt_tp_cd"); // 18
            document.form.cmnc_hrmnt.value = sheetObjects[5].GetCellValue(1, "cmnc_hrmnt").substr(0, 2) + ":" + sheetObjects[5].GetCellValue(1, "cmnc_hrmnt").substr(2, 4); // 19
        }
        for (var i = 0; i < getElementCnt(document.form, 'radio', 'auto_calc_flg'); i++) {
            if (sheetObjects[5].GetCellValue(1, "auto_calc_flg") == "Y") { // 14
                document.form.auto_calc_flg[i].checked = true;
                document.form.auto_calc_flg[i + 1].checked = false;
                break;
            } else if (sheetObjects[5].GetCellValue(1, "auto_calc_flg") == "N") { // 14
                document.form.auto_calc_flg[i].checked = false;
                document.form.auto_calc_flg[i + 1].checked = true;
                break;
            }
        }
    }
}

/**
 * Form Object Detail Value Setting. <br>
 **/
function initformTerminalDTLs() {
    document.form.io_bnd_cd[1].value = "";
    document.form.ioc_cd.value = "";
    document.form.tml_trns_mod_cd.value = "";
    document.form.tml_dy_aply_tp_cd[0].checked = false;
    document.form.tml_dy_aply_tp_cd[1].checked = false;
    document.form.wkdy_flg.checked = false;
    document.form.sat_flg.checked = false;
    document.form.sun_flg.checked = false;
    document.form.hol_flg.checked = false;
    comboObjects[2].SetSelectCode(-1);
    document.form.dcgo_aply_tp_cd[0].checked = false;
    document.form.dcgo_aply_tp_cd[1].checked = false;
    document.form.dcgo_aply_tp_cd[2].checked = false;
    document.form.dcgo_n1st_clss_flg.checked = false;
    document.form.dcgo_n2nd_clss_flg.checked = false;
    document.form.dcgo_n3rd_clss_flg.checked = false;
    document.form.dcgo_n4th_clss_flg.checked = false;
    document.form.dcgo_n5th_clss_flg.checked = false;
    document.form.dcgo_n6th_clss_flg.checked = false;
    document.form.dcgo_n7th_clss_flg.checked = false;
    document.form.dcgo_n8th_clss_flg.checked = false;
    document.form.dcgo_n9th_clss_flg.checked = false;
    document.form.dcgo_none_clss_flg.checked = false;
    document.form.cnt1.value = 0;
    document.form.cnt2.value = 0;
    document.form.thc_tp_cd[0].checked = false;
    document.form.thc_tp_cd_flg.checked = false;
    document.form.thc_tp_cd[1].checked = false;
    document.form.thc_tp_cd[2].checked = false;
    document.form.cntr_ts[0].checked = false;
    document.form.cntr_ts[1].checked = false;
    comboObjects[3].SetSelectCode(-1);
    comboObjects[4].SetSelectCode(-1);
    document.form.agmt_rate.value = "";
}

/**
 * Form Object Storage FreeDay Detail Value Setting. <br>
 **/
function initformStorageFDDTLs() {
    document.form.storage_gb[0].checked = false;
    document.form.storage_gb[1].checked = false;
    document.form.io_bnd_cd[2].value = "";
    document.form.sat_flg_FD.checked = false;
    document.form.sun_flg_FD.checked = false;
    document.form.hol_flg_FD.checked = false;
    document.form.dcgo_aply_tp_cd_FD[0].checked = false;
    document.form.dcgo_aply_tp_cd_FD[1].checked = false;
    document.form.dcgo_aply_tp_cd_FD[2].checked = false;
    document.form.dcgo_same_R[0].checked = false;
    document.form.dcgo_same_R[1].checked = false;
    document.form.dcgo_same_R[0].disabled = true;
    document.form.dcgo_same_R[1].disabled = true;
    document.form.dcgo_n1st_clss_flg_FD.checked = false;
    document.form.dcgo_n2nd_clss_flg_FD.checked = false;
    document.form.dcgo_n3rd_clss_flg_FD.checked = false;
    document.form.dcgo_n4th_clss_flg_FD.checked = false;
    document.form.dcgo_n5th_clss_flg_FD.checked = false;
    document.form.dcgo_n6th_clss_flg_FD.checked = false;
    document.form.dcgo_n7th_clss_flg_FD.checked = false;
    document.form.dcgo_n8th_clss_flg_FD.checked = false;
    document.form.dcgo_n9th_clss_flg_FD.checked = false;
    document.form.dcgo_none_clss_flg_FD.checked = false;
    document.form.ft_dys.value = "";
    document.form.io_bnd_cd[3].value = "";
    document.form.dcgo_n1st_clss_flg_R.checked = false;
    document.form.dcgo_n2nd_clss_flg_R.checked = false;
    document.form.dcgo_n3rd_clss_flg_R.checked = false;
    document.form.dcgo_n4th_clss_flg_R.checked = false;
    document.form.dcgo_n5th_clss_flg_R.checked = false;
    document.form.dcgo_n6th_clss_flg_R.checked = false;
    document.form.dcgo_n7th_clss_flg_R.checked = false;
    document.form.dcgo_n8th_clss_flg_R.checked = false;
    document.form.dcgo_n9th_clss_flg_R.checked = false;
    document.form.dcgo_none_clss_flg_R.checked = false;
    document.form.cnt3.value = 0;
    document.form.agmt_ut_rt.value = "";
    document.form.cntr_ts[2].checked = false;
    document.form.cntr_ts[3].checked = false;
    comboObjects[7].SetSelectCode(-1);
    comboObjects[8].SetSelectCode(-1);
}

/**
 * Form Object Storage FreePool Detail Value Setting. <br>
 **/
function initformStorageFPDTLs() {
    document.form.fp_calc_prd_cd[0].checked = false;
    document.form.fp_calc_prd_cd[1].checked = false;
    document.form.fp_teu_qty.value = "";
    document.form.agmt_ut_rt_fp.value = "";
}

/**
 * Form Object Storage FreePool Detail Value Setting. <br>
 **/
function removeAgreementHDR() {
    document.form.f_cmd.value = REMOVE;
    doActionIBSheet6(sheetObjects[5], document.form, IBSEARCH);
}

/**
 * Volume Unit Select CNTR Type / Size Setting. <br>
 **/
function selectVolUOM() {
    if (document.form.tml_agmt_vol_ut_cd[1].value != "C") {
        document.form.cntr_ts[2].checked = false;
        document.form.cntr_ts[3].checked = false;
        for (var i = 0; i < getElementCnt(document.form, 'radio', 'cntr_ts'); i++) {
            document.form.cntr_ts[0].disabled = true;
            document.form.cntr_ts[1].disabled = true;
        }
        comboObjects[3].SetEnable(0);
        comboObjects[4].SetEnable(0);
    } else if (document.form.tml_agmt_vol_ut_cd[1].value == "C") {
        document.form.cntr_ts[0].checked = true;
        for (var i = 0; i < getElementCnt(document.form, 'radio', 'cntr_ts'); i++) {
            document.form.cntr_ts[0].disabled = false;
            document.form.cntr_ts[1].disabled = false;
        }
    }
    if (document.form.tml_agmt_vol_ut_cd[2].value != "C") {
        document.form.cntr_ts[2].checked = false;
        document.form.cntr_ts[3].checked = false;
        for (var i = 0; i < getElementCnt(document.form, 'radio', 'cntr_ts'); i++) {
            document.form.cntr_ts[2].disabled = true;
            document.form.cntr_ts[3].disabled = true;
        }
        comboObjects[7].SetEnable(0);
        comboObjects[8].SetEnable(0);
    } else if (document.form.tml_agmt_vol_ut_cd[2].value == "C") {
        document.form.cntr_ts[2].checked = true;
        for (var i = 0; i < getElementCnt(document.form, 'radio', 'cntr_ts'); i++) {
            document.form.cntr_ts[2].disabled = false;
            document.form.cntr_ts[3].disabled = false;
        }
    }
    document.form.agmt_rate.disabled = false;
}

/**
 * Terminal Rate Input Tab Applied Date Same Selected CheckBox Setting. <br>
 **/
function selectAplySame() {
    document.form.wkdy_flg.checked = true;
    document.form.sat_flg.checked = true;
    document.form.sun_flg.checked = true;
    document.form.hol_flg.checked = true;
    document.form.wkdy_flg.disabled = true;
    document.form.sat_flg.disabled = true;
    document.form.sun_flg.disabled = true;
    document.form.hol_flg.disabled = true;
}

/**
 * Terminal Rate Input Tab Applied Date Separate Selected CheckBox Setting. <br>
 **/
function selectAplySep() {
    document.form.wkdy_flg.checked = false;
    document.form.sat_flg.checked = false;
    document.form.sun_flg.checked = false;
    document.form.hol_flg.checked = false;
    document.form.wkdy_flg.disabled = false;
    document.form.sat_flg.disabled = false;
    document.form.sun_flg.disabled = false;
    document.form.hol_flg.disabled = false;
}

/**
 * DG Class None Selected CheckBox Setting. <br>
 * @param{dg_gb}	DG Class (_FD: Storage FreeDay, _R:Storage Rate, null:Terminal )
 **/
function selectDGNone(dg_gb) {
    var cnt = 0;
    var numOfEle = document.form.elements.length;
    var element;
    for (var i = 0; i < numOfEle; i++) {
        if (document.form.elements[i].name.substr(0, 5) == "dcgo_" && document.form.elements[i].name.substr(9, 12) == "_clss_flg" && dg_gb == "") {
            document.form.elements[i].disabled = true;
            document.form.elements[i].checked = false;
        } else if (document.form.elements[i].name.substr(0, 5) == "dcgo_" && document.form.elements[i].name.substr(9, 12) == "_clss_flg_FD" && dg_gb == "_FD") {
            document.form.elements[i].disabled = true;
            document.form.elements[i].checked = false;
        } else if (document.form.elements[i].name.substr(0, 5) == "dcgo_" && document.form.elements[i].name.substr(9, 12) == "_clss_flg_R" && dg_gb == "_R") {
            document.form.elements[i].disabled = true;
            document.form.elements[i].checked = false;
        }
    }
    for (var i = 0; i < numOfEle; i++) {
        if (document.form.elements[i].name == "dcgo_same" && dg_gb == "") {
            document.form.elements[i].disabled = true;
            document.form.elements[i].checked = false;
        } else if (document.form.elements[i].name == "dcgo_same_FD" && dg_gb == "_FD") {
            document.form.elements[i].disabled = true;
            document.form.elements[i].checked = false;
        } else if (document.form.elements[i].name == "dcgo_same_R" && dg_gb == "_R") {
            document.form.elements[i].disabled = true;
            document.form.elements[i].checked = false;
        }
    }
}

/**
 * DG Class Same Selected CheckBox Setting. <br>
 * @param{dg_gb}	DG Class (_FD: Storage FreeDay, _R:Storage Rate, null:Terminal )
 **/
function selectDGSame(dg_gb) {
    //document.form.dcgo_same.disabled=true;
    var cnt = 0;
    var numOfEle = document.form.elements.length;
    var element;
    for (var i = 0; i < numOfEle; i++) {
        if (document.form.elements[i].name.substr(0, 5) == "dcgo_" && document.form.elements[i].name.substr(9, 12) == "_clss_flg" && dg_gb == "") {
            document.form.elements[i].disabled = true;
            document.form.elements[i].checked = false;
        } else if (document.form.elements[i].name.substr(0, 5) == "dcgo_" && document.form.elements[i].name.substr(9, 12) == "_clss_flg_FD" && dg_gb == "_FD") {
            document.form.elements[i].disabled = true;
            document.form.elements[i].checked = false;
        } else if (document.form.elements[i].name.substr(0, 5) == "dcgo_" && document.form.elements[i].name.substr(9, 12) == "_clss_flg_R" && dg_gb == "_R") {
            document.form.elements[i].disabled = true;
            document.form.elements[i].checked = false;
        }
    }
    for (var i = 0; i < numOfEle; i++) {
        if (document.form.elements[i].name == "dcgo_same" && dg_gb == "") {
            document.form.elements[i].disabled = false;
        } else if (document.form.elements[i].name == "dcgo_same_FD" && dg_gb == "_FD") {
            document.form.elements[i].disabled = false;
        } else if (document.form.elements[i].name == "dcgo_same_R" && dg_gb == "_R") {
            document.form.elements[i].disabled = false;
        }
    }
}

/**
 * DG Class Separate Selected CheckBox Setting. <br>
 * @param{dg_gb}	DG Class (_FD: Storage FreeDay, _R:Storage Rate, null:Terminal )
 **/
function selectDGSep(dg_gb) {
    var cnt = 0;
    var numOfEle = document.form.elements.length;
    var element;
    for (var i = 0; i < numOfEle; i++) {
        if (document.form.elements[i].name.substr(0, 5) == "dcgo_" && document.form.elements[i].name.substr(9, 12) == "_clss_flg" && dg_gb == "") {
            document.form.elements[i].disabled = false;
        } else if (document.form.elements[i].name.substr(0, 5) == "dcgo_" && document.form.elements[i].name.substr(9, 12) == "_clss_flg_FD" && dg_gb == "_FD") {
            document.form.elements[i].disabled = false;
        } else if (document.form.elements[i].name.substr(0, 5) == "dcgo_" && document.form.elements[i].name.substr(9, 12) == "_clss_flg_R" && dg_gb == "_R") {
            document.form.elements[i].disabled = false;
        }
    }
    for (var i = 0; i < numOfEle; i++) {
        if (document.form.elements[i].name == "dcgo_same" && dg_gb == "") {
            document.form.elements[i].disabled = true;
            document.form.elements[i].checked = false;
        } else if (document.form.elements[i].name == "dcgo_same_FD" && dg_gb == "_FD") {
            document.form.elements[i].disabled = true;
            document.form.elements[i].checked = false;
        } else if (document.form.elements[i].name == "dcgo_same_R" && dg_gb == "_R") {
            document.form.elements[i].disabled = true;
            document.form.elements[i].checked = false;
        }
    }
}

/**
 * DG Class Same DG Selected CheckBox Setting. <br>
 * @param{dg_gb}	DG Class (_FD: Storage FreeDay, _R:Storage Rate, null:Terminal )
 **/
function same_dg(dg_gb) {
    var cnt = 0;
    var element;
    var numOfEle = document.form.elements.length;
    for (var i = 0; i < numOfEle; i++) {
        if (document.form.elements[i].name.substr(0, 5) == "dcgo_" && document.form.elements[i].name.substr(9, 12) == "_clss_flg" && dg_gb == "") {
            //document.form.elements[i].checked = true;
            if (document.form.elements[i].name.substr(4, 6) == "_none_") {
                document.form.elements[i].checked = false;
            }
        } else if (document.form.elements[i].name.substr(0, 5) == "dcgo_" && document.form.elements[i].name.substr(9, 12) == "_clss_flg_FD" && dg_gb == "_FD") {
            //document.form.elements[i].checked = true;
            if (document.form.elements[i].name.substr(4, 6) == "_none_") {
                document.form.elements[i].checked = false;
            }
        } else if (document.form.elements[i].name.substr(0, 5) == "dcgo_" && document.form.elements[i].name.substr(9, 12) == "_clss_flg_R" && dg_gb == "_R") {
            //document.form.elements[i].checked = true;
            if (document.form.elements[i].name.substr(4, 6) == "_none_") {
                document.form.elements[i].checked = false;
            }
        }
    }
}

/**
 * DG Class Same NODG Selected CheckBox Setting. <br>
 * @param{dg_gb}	DG Class (_FD: Storage FreeDay, _R:Storage Rate, null:Terminal )
 **/
function same_nodg(dg_gb) {
    var cnt = 0;
    var element;
    var numOfEle = document.form.elements.length;
    for (var i = 0; i < numOfEle; i++) {
        if (document.form.elements[i].name.substr(0, 5) == "dcgo_" && document.form.elements[i].name.substr(9, 12) == "_clss_flg" && dg_gb == "") {
            if (document.form.elements[i].name.substr(4, 6) != "_none_") {
                document.form.elements[i].checked = false;
            }
        } else if (document.form.elements[i].name.substr(0, 5) == "dcgo_" && document.form.elements[i].name.substr(9, 12) == "_clss_flg_FD" && dg_gb == "_FD") {
            if (document.form.elements[i].name.substr(4, 6) != "_none_") {
                document.form.elements[i].checked = false;
            }
        } else if (document.form.elements[i].name.substr(0, 5) == "dcgo_" && document.form.elements[i].name.substr(9, 12) == "_clss_flg_R" && dg_gb == "_R") {
            if (document.form.elements[i].name.substr(4, 6) != "_none_") {
                document.form.elements[i].checked = false;
            }
        }
    }
}

/**
 * CNTR Type/Size All Selected Setting. <br>
 * @param{i}	( 0: Terminal, 1: Storage )
 **/
function selectTSAll(i) {
    if (i == 0) {
        comboObjects[3].SetSelectCode("-1", false);
        comboObjects[4].SetSelectCode("-1", false);
        comboObjects[3].SetEnable(0);
        comboObjects[4].SetEnable(0);
        document.form.agmt_rate.disabled = false;
    }
    if (i == 1) {
        comboObjects[7].SetSelectCode("-1", false);
        comboObjects[8].SetSelectCode("-1", false);
        comboObjects[7].SetEnable(0);
        comboObjects[8].SetEnable(0);
        document.form.agmt_ut_rt.disabled = false;
    }
}

/**
 * CNTR Type/Size By Type / Size Selected Setting. <br>
 * @param{i}	( 0: Terminal, 1: Storage )
 **/
function selectTS(i) {
    if (i == 0) {
        comboObjects[3].SetEnable(1);
        comboObjects[4].SetEnable(1);
        document.form.agmt_rate.disabled = false;
    }
    if (i == 1) {
        comboObjects[7].SetEnable(1);
        comboObjects[8].SetEnable(1);
        document.form.agmt_ut_rt.disabled = false;
    }
}

/**
 * CNTR Type/Size By Type / Size Selected Setting. <br>
 * @param{i}	( 0: Terminal, 1: Storage )
 **/
function selectType(i) {
    if (i == 0) {
        comboObjects[4].SetSelectCode("-1", false);
        comboObjects[4].SetEnable(0);
    }
    if (i == 1) {
        comboObjects[8].SetSelectCode("-1", false);
        comboObjects[8].SetEnable(0);
    }
}

/**
 * Add Dot. <br>
 * @param{obj}	Value
 **/
function addDot(obj) {
    var tem_val = 0;
    tem_val = obj.value;
    obj.value = (tem_val == 0 ? "0.00" : tem_val);
    if (obj.value.indexOf(".") == -1) obj.value += ".";
    var strLen = getStrLen(obj.value.substr(obj.value.indexOf(".") + 1, getStrLen(obj.value)));
    if (strLen < 2) {
        for (var i = 0; i < (2 - strLen); i++) {
            obj.value += "0";
        }
    }
}

/**
 * Add Dot. <br>
 * @param{src}	Value
 **/
function addDot2(src) {
    var tem_val = 0;
    tem_val = src;
    src = (tem_val == 0 ? "0.00" : tem_val);
    if (src.indexOf(".") == -1) src += ".";
    var strLen = getStrLen(src.substr(src.indexOf(".") + 1, getStrLen(src)));
    if (strLen < 2) {
        for (var i = 0; i < (2 - strLen); i++) {
            src += "0";
        }
    }
    return src;
}

/**
 * Terminal Agreement Confirm. <br>
 **/
function terminalAgreementConfirm() {
    formObject = document.form;
    formObject.sheet_prefix.value = "3";
    formObject.f_cmd.value = MULTI02;
    sheetObjects[5].SetRowStatus(1, "I"); // 0
    sheetObjects[5].SetCellValue(1, "tml_agmt_sts_cd", "C"); // 11
    //		sheetObjects[5].DoAllSave("ESD_TES_0034GS.do", tesFrmQryStr(formObject));
    sheetObjects[5].DoAllSave("ESD_TES_0034Detail.do", tesFrmQryStr(formObject));
}

/**
 * Storage Agreement Confirm. <br>
 **/
function storageAgreementConfirm() {
    formObject = document.form;
    formObject.sheet_prefix.value = "5";
    formObject.f_cmd.value = MULTI02;
    sheetObjects[5].SetRowStatus(1, "I"); // 0
    sheetObjects[5].SetCellValue(1, "tml_agmt_sts_cd", "C"); // 11
    sheetObjects[5].DoAllSave("ESD_TES_0034Detail.do", tesFrmQryStr(formObject));
    //		sheetObjects[5].DoAllSave("ESD_TES_0034GS.do", tesFrmQryStr(formObject));
}

/**
 * t1sheet3 After Save Execute. <br>
 * @param{ibsheet}	t1sheet3	Sheet Object
 * @param{String}	ErrMsg		Error Message
 **/
function t1sheet3_OnSaveEnd(t1sheet3, ErrMsg) {
    var srcName = ComGetEvent("name");
    if (ErrMsg == undefined || ErrMsg == "") {
        if (srcName == "btn_save") {
            ComShowCodeMessage('TES10069');
        } else if (srcName == "t1btng_save") {
            ComShowCodeMessage('TES10070');
        } else if (srcName == "t3btng_save") {
            ComShowCodeMessage('TES10071');
        } else {
            ComShowCodeMessage('TES10072');
            document.form.tml_agmt_ver_no.value = t1sheet3.GetEtcData("agmt_ver");
            formObject.tml_agmt_tp_cd.value = "T";
            formObject.tml_agmt_ver_no.value = "";
            formObject.f_cmd.value = SEARCH;
            doActionIBSheet6(sheetObjects[5], formObject, IBSEARCH);
        }
    } else {
        ComShowCodeMessage('TES10077', ErrMsg); // Save Fail {?msg1}
    }
}

/**
 * t1sheet3 After Search Execute. <br>
 * @param{ibsheet}	t1sheet3	Sheet Object
 * @param{String}	ErrMsg		Error Message
 **/
function t1sheet3_OnSearchEnd(sheetObj, ErrMsg) {
    var srcName = ComGetEvent("name");
    if (ErrMsg == undefined || ErrMsg == "") {
        if (srcName == "btn_delete") {
            ComShowMessage('Agreement is deleted successfully.');

            sheetObjects[0].RemoveAll();
            sheetObjects[1].RemoveAll();
            sheetObjects[2].RemoveAll();
            sheetObjects[3].RemoveAll();
            sheetObjects[4].RemoveAll();

            document.form.reset();
            initFormValue();
            initFormDisabled();
            document.form.yd_cd.readOnly = false;
            document.form.vndr_seq.readOnly = false;
            document.form.ctrt_ofc_cd.readOnly = false;
        }


    } else {
        ComShowCodeMessage('TES10077', ErrMsg); // Save Fail {?msg1}
    }


}

/**
 * t1sheet4 After Save Execute. <br>
 * @param{ibsheet}	t1sheet4	Sheet Object
 * @param{String}	ErrMsg		Error Message
 **/
function t1sheet4_OnSaveEnd(t1sheet4, ErrMsg) {
    var srcName = ComGetEvent("name");
    var formObject = document.form;
    if (ErrMsg == undefined || ErrMsg == "") {
        ComShowCodeMessage('TES10072');
        document.form.tml_agmt_ver_no.value = t1sheet4.GetEtcData("agmt_ver");
        formObject.tml_agmt_tp_cd.value = "T";
        formObject.tml_agmt_ver_no.value = "";
        formObject.f_cmd.value = SEARCH;
        doActionIBSheet6(sheetObjects[5], formObject, IBSEARCH);
        //doActionIBSheet3(sheetObjects[2],formObject,IBSEARCH);
    } else {
        ComShowCodeMessage('TES10077', ErrMsg);
    }
}

/**
 * t1sheet5 (Verify Flag Sheet) After Search Execute. <br>
 **/
function t1sheet5_OnSearchEnd() {
    dataTerminalErrCount = 0;
    dataStorageErrCount = 0;
    if (tabObjects[0].GetSelectedIndex() == 1) {
        dataTerminalErrCount = dataTerminalVerify();
    } else if (tabObjects[0].GetSelectedIndex() == 3) {
        dataStorageErrCount = dataStorageVerify();
        //ComShowMessage("dataStorageErrCount : "+dataStorageErrCount);
    }
}

/**
 * Terminal Rate List Tab (t2sheet1) After Save Process Execute. <br>
 * @param{ibsheet}	t2sheet1	Sheet Object
 * @param{String}	ErrMsg		Error Message
 **/
function t2sheet1_OnSaveEnd(t2sheet1, ErrMsg) {
    var srcName = ComGetEvent("name");
    if (ErrMsg == undefined || ErrMsg == "") {
        if (srcName == "t2btng_save") {
            ComShowCodeMessage('TES10110');
        } else if (srcName == "t2btng_registeragree") {
            ComShowCodeMessage('TES10074');
        } else if (srcName == "btn_save") {
            ComShowCodeMessage('TES10111');
        } else if (srcName == "t2btng_delete") {
            ComShowCodeMessage('TES10127');
        }
        tab2VerifyFlg = "";
        document.form.tml_agmt_ver_no.value = t2sheet1.GetEtcData("agmt_ver");
    } else {
        ComShowCodeMessage('TES10077', ErrMsg);
    }
}

/**
 * Storage Rate List Tab (t4sheet1) After Save Process Execute. <br>
 * @param {ibsheet}	t4sheet1	IBSheet Object
 * @param {String}	ErrMsg		Error Message
 * @return
 */
function t4sheet1_OnSaveEnd(t4sheet1, ErrMsg) {
    var srcName = ComGetEvent("name");
    if (ErrMsg == undefined || ErrMsg == "") {
        if (srcName == "t4btng_save") {
            ComShowCodeMessage('TES10110');
        } else if (srcName == "t4btng_registeragree") {
            ComShowCodeMessage('TES10074');
        } else if (srcName == "btn_save") {
            ComShowCodeMessage('TES10111');
        } else if (srcName == "t4btng_delete") {
            ComShowCodeMessage('TES10128');
        }
        tab4VerifyFlg = "";
        document.form.tml_agmt_ver_no.value = t4sheet1.GetEtcData("agmt_ver");
    } else {
        ComShowCodeMessage('TES10077', ErrMsg);
    }
}

function t5sheet1_OnSaveEnd(t5sheet1, ErrMsg) {
    var srcName = ComGetEvent("name");
    if (ErrMsg == undefined || ErrMsg == "") {
        if (srcName == "t5btng_save") {
            ComShowCodeMessage('TES10110');
        } else if (srcName == "t5btng_registeragree") {
            ComShowCodeMessage('TES10074');
        } else if (srcName == "btn_save") {
            ComShowCodeMessage('TES10111');
        } else if (srcName == "t5btng_delete") {
            ComShowCodeMessage('TES10128');
        }
        tab5VerifyFlg = "";
        document.form.tml_agmt_ver_no.value = t5sheet1.GetEtcData("agmt_ver");
    } else {
        ComShowCodeMessage('TES10077', ErrMsg);
    }
}

/**
 * 
 * @param {String}	gb 
 * @return
 */
function checkTHC(gb) {
    if (gb == 1) {
        document.form.thc_tp_cd_flg.checked = false;
        document.form.thc_tp_cd[1].checked = false;
        document.form.thc_tp_cd[2].checked = false;
        document.form.thc_tp_cd[1].disabled = true;
        document.form.thc_tp_cd[2].disabled = true;
    } else if (gb == 2) {
        document.form.thc_tp_cd[0].checked = false;
        document.form.thc_tp_cd[1].checked = false;
        document.form.thc_tp_cd[2].checked = false;
        document.form.thc_tp_cd[1].disabled = false;
        document.form.thc_tp_cd[2].disabled = false;
    }
}

/**
 * 
 * @return
 */
function freeDays() {
    document.form.io_bnd_cd[3].value = "";
    document.form.io_bnd_cd[3].disabled = true;
    document.form.io_bnd_cd[2].disabled = false;
    document.form.io_bnd_cd[2].value = "S";
    for (var i = 0; i < getElementCnt(document.form, 'radio', 'dcgo_aply_tp_cd_FD'); i++) {
        document.form.dcgo_aply_tp_cd_FD[i].disabled = false;
    }
    document.form.dcgo_n1st_clss_flg_FD.disabled = false;
    document.form.dcgo_n2nd_clss_flg_FD.disabled = false;
    document.form.dcgo_n3rd_clss_flg_FD.disabled = false;
    document.form.dcgo_n4th_clss_flg_FD.disabled = false;
    document.form.dcgo_n5th_clss_flg_FD.disabled = false;
    document.form.dcgo_n6th_clss_flg_FD.disabled = false;
    document.form.dcgo_n7th_clss_flg_FD.disabled = false;
    document.form.dcgo_n8th_clss_flg_FD.disabled = false;
    document.form.dcgo_n9th_clss_flg_FD.disabled = false;
    document.form.dcgo_none_clss_flg_FD.disabled = false;
    document.form.dcgo_aply_tp_cd_FD[0].checked = true;
    selectDGNone('_FD');
    document.form.sat_flg_FD.disabled = false;
    document.form.sun_flg_FD.disabled = false;
    document.form.hol_flg_FD.disabled = false;
    document.form.ft_dys.disabled = false;
    for (var i = 0; i < getElementCnt(document.form, 'radio', 'dcgo_aply_tp_cd_R'); i++) {
        document.form.dcgo_aply_tp_cd_R[i].disabled = true;
    }
    document.form.dcgo_n1st_clss_flg_R.disabled = true;
    document.form.dcgo_n2nd_clss_flg_R.disabled = true;
    document.form.dcgo_n3rd_clss_flg_R.disabled = true;
    document.form.dcgo_n4th_clss_flg_R.disabled = true;
    document.form.dcgo_n5th_clss_flg_R.disabled = true;
    document.form.dcgo_n6th_clss_flg_R.disabled = true;
    document.form.dcgo_n7th_clss_flg_R.disabled = true;
    document.form.dcgo_n8th_clss_flg_R.disabled = true;
    document.form.dcgo_n9th_clss_flg_R.disabled = true;
    document.form.dcgo_none_clss_flg_R.disabled = true;
    for (var i = 0; i < getElementCnt(document.form, 'radio', 'dcgo_aply_tp_cd_R'); i++) {
        document.form.dcgo_aply_tp_cd_R[i].checked = false;
    }
    document.form.dcgo_n1st_clss_flg_R.checked = false;
    document.form.dcgo_n2nd_clss_flg_R.checked = false;
    document.form.dcgo_n3rd_clss_flg_R.checked = false;
    document.form.dcgo_n4th_clss_flg_R.checked = false;
    document.form.dcgo_n5th_clss_flg_R.checked = false;
    document.form.dcgo_n6th_clss_flg_R.checked = false;
    document.form.dcgo_n7th_clss_flg_R.checked = false;
    document.form.dcgo_n8th_clss_flg_R.checked = false;
    document.form.dcgo_n9th_clss_flg_R.checked = false;
    document.form.dcgo_none_clss_flg_R.checked = false;
    document.form.cnt3.disabled = true;
    document.form.cnt3.value = 0;
    //sheetObjects[3].RemoveAll();
    if (sheetObjects[3].RowCount() == 1) {} else if (sheetObjects[3].RowCount() > 1) {
        sheetObjects[3].RemoveAll();
        document.form.cnt3.value = 1;
        var iRow = sheetObjects[3].DataInsert(-1);
        sheetObjects[3].SetCellValue(iRow, 0, "1", 0);
        sheetObjects[3].SetCellValue(iRow, 2, "1", 0);
        sheetObjects[3].SetCellValue(iRow, 3, "MAX", 0);
    } else {
        sheetObjects[3].RemoveAll();
    }
    document.form.agmt_ut_rt.value = "";
    document.form.agmt_ut_rt.disabled = true;
}

/**
 * 
 * @return
 */
function rate() {
    document.form.io_bnd_cd[2].value = "";
    document.form.io_bnd_cd[2].disabled = true;
    document.form.io_bnd_cd[3].disabled = false;
    document.form.io_bnd_cd[3].value = "S";
    if (sheetObjects[3].GetCellValue(2, 0) == "1" && sheetObjects[3].GetCellValue(2, 2) == "1" && sheetObjects[3].GetCellValue(2, 3) == "MAX") {
        document.form.cnt3.value = 1;
        //document.form.cnt3.disabled = false;
    }
    for (var i = 0; i < getElementCnt(document.form, 'radio', 'dcgo_aply_tp_cd_R'); i++) {
        document.form.dcgo_aply_tp_cd_R[i].disabled = false;
    }
    document.form.dcgo_n1st_clss_flg_R.disabled = false;
    document.form.dcgo_n2nd_clss_flg_R.disabled = false;
    document.form.dcgo_n3rd_clss_flg_R.disabled = false;
    document.form.dcgo_n4th_clss_flg_R.disabled = false;
    document.form.dcgo_n5th_clss_flg_R.disabled = false;
    document.form.dcgo_n6th_clss_flg_R.disabled = false;
    document.form.dcgo_n7th_clss_flg_R.disabled = false;
    document.form.dcgo_n8th_clss_flg_R.disabled = false;
    document.form.dcgo_n9th_clss_flg_R.disabled = false;
    document.form.dcgo_none_clss_flg_R.disabled = false;
    document.form.dcgo_aply_tp_cd_R[0].checked = true;
    selectDGNone('_R');
    document.form.cnt3.disabled = false;
    document.form.agmt_ut_rt.disabled = false;
    for (var i = 0; i < getElementCnt(document.form, 'radio', 'dcgo_aply_tp_cd_FD'); i++) {
        document.form.dcgo_aply_tp_cd_FD[i].disabled = true;
    }
    document.form.dcgo_n1st_clss_flg_FD.disabled = true;
    document.form.dcgo_n2nd_clss_flg_FD.disabled = true;
    document.form.dcgo_n3rd_clss_flg_FD.disabled = true;
    document.form.dcgo_n4th_clss_flg_FD.disabled = true;
    document.form.dcgo_n5th_clss_flg_FD.disabled = true;
    document.form.dcgo_n6th_clss_flg_FD.disabled = true;
    document.form.dcgo_n7th_clss_flg_FD.disabled = true;
    document.form.dcgo_n8th_clss_flg_FD.disabled = true;
    document.form.dcgo_n9th_clss_flg_FD.disabled = true;
    document.form.dcgo_none_clss_flg_FD.disabled = true;
    for (var i = 0; i < getElementCnt(document.form, 'radio', 'dcgo_aply_tp_cd_FD'); i++) {
        document.form.dcgo_aply_tp_cd_FD[i].checked = false;
    }
    document.form.dcgo_n1st_clss_flg_FD.checked = false;
    document.form.dcgo_n2nd_clss_flg_FD.checked = false;
    document.form.dcgo_n3rd_clss_flg_FD.checked = false;
    document.form.dcgo_n4th_clss_flg_FD.checked = false;
    document.form.dcgo_n5th_clss_flg_FD.checked = false;
    document.form.dcgo_n6th_clss_flg_FD.checked = false;
    document.form.dcgo_n7th_clss_flg_FD.checked = false;
    document.form.dcgo_n8th_clss_flg_FD.checked = false;
    document.form.dcgo_n9th_clss_flg_FD.checked = false;
    document.form.dcgo_none_clss_flg_FD.checked = false;
    document.form.sat_flg_FD.disabled = true;
    document.form.sun_flg_FD.disabled = true;
    document.form.hol_flg_FD.disabled = true;
    document.form.sat_flg_FD.checked = false;
    document.form.sun_flg_FD.checked = false;
    document.form.hol_flg_FD.checked = false;
    document.form.ft_dys.value = "";
    document.form.ft_dys.disabled = true;
}

/**
 * 
 * @param {String}	tml_agmt_ofc_cty_cd
 * @param {String}	tml_agmt_ver_no
 * @return
 */
function detailRetrieve(tml_agmt_ofc_cty_cd, tml_agmt_ver_no) {
    document.form.tml_agmt_ofc_cty_cd.value = tml_agmt_ofc_cty_cd;
    document.form.tml_agmt_ver_no.value = tml_agmt_ver_no;
    document.form.f_cmd.value = SEARCH;
    doActionIBSheet6(sheetObjects[5], document.form, IBSEARCH);
}

/**
 * 
 * @param {Object}		obj
 * @param {String}		isChkFmt
 * @param {int,String}	int_str
 * @return
 */
function tes_cmnctime(obj, isChkFmt, int_str) {
    if (isChkFmt == undefined || isChkFmt == null || isChkFmt.trim() == '') {
        if (!isNumHHMM(obj)) {
            obj.value = '';
        }
    } else if (isChkFmt != undefined && isChkFmt != null && isChkFmt == 'Y') {
        var int_char = (int_str != undefined && int_str != null & int_str.trim() != '' ? int_str.trim() : ':');
        var src = obj.value;
        for (var i = 0; src != null && i < src.length; i++) {
            if ((i != 2 && !ComIsNumber(src.charAt(i))) || ((i == 2) && !isNumColon2(src.charAt(i)))) {
                src = src.substring(0, i) + src.substring(i + 1, src.length);
            } else {
                if ((i == 2) && (src.charAt(i) != int_char)) {
                    src = src.substring(0, i) + int_char + src.substring(i, src.length);
                }
            }
        }
        obj.value = src;
    }
    return true;
}

/**
 * . <br>
 * 
 * @param {String}    Value     Text Value
 **/
function isNumColon2(val) {
    var chars = ":0123456789";
    return ComIsContainsCharsOnly(val, chars);
}

/**
 * Form Vendor Code Focus 이동. <br>
 **/
function vndr_seq_Focus() {
    document.form.vndr_seq.focus();
}

/**
 * Form Contract Office Code Focus <br>
 **/
function cont_ofc_Focus() {
    document.form.ctrt_ofc_cd.focus();
}

/**
 * get Element Count
 * @param {Object}	formObject	Form Object
 * @param {String}	eleTp		element Type
 * @param {String}	eleNm		element Name
 **/
function getElementCnt(formObject, eleTp, eleNm) {
    var cnt = 0;
    var element;
    var numOfEle = formObject.elements.length;
    for (var i = 0; i < numOfEle; i++) {
        if (formObject.elements[i].type == eleTp && formObject.elements[i].name == eleNm) {
            cnt++;
        }
    }
    return cnt;
}

/**
 * Form Object Value retrieve <br>
 * 
 * @param {Object}	formObject	Form Object
 * @param {String}	eleTp		element Type
 * @param {String}	eleNm		element Name
 **/
function getElementValue(formObject, eleTp, eleNm) {
    var element;
    var numOfEle = formObject.elements.length;
    for (var i = 0; i < numOfEle; i++) {
        if (formObject.elements[i].type == eleTp && formObject.elements[i].name == eleNm) {
            if (formObject.elements[i].checked == true) {
                var ele_value = formObject.elements[i].value;
                break;
            }
        }
    }
    return ele_value;
}

/**
 * Form Object Check retrieve <br>
 * 
 * @param {Object}	formObject	Form Object
 * @param {String}	eleTp		element Type
 * @param {String}	eleNm		element Name
 **/
function getElementCheck(formObject, eleTp, eleNm) {
    var element;
    var numOfEle = formObject.elements.length;
    for (var i = 0; i < numOfEle; i++) {
        if (formObject.elements[i].type == eleTp && formObject.elements[i].name == eleNm) {
            if (formObject.elements[i].checked == true) {
                return true;
            } else {
                return false;
            }
        }
    }
}

/**
 * Date Validate. <br>
 * 
 * @param {Object}		obj		Object
 **/
function validateDateObj(obj) {
    if (obj.readOnly == true) {
        return false;
    }
    obj.value = obj.value.trim();
    if (obj.value == null || obj.value.trim() == '') {
        return false;
    }
    if (!checkPeriodFormat(obj.value) || !tes_isValidDateObject(obj.value, '-')) {
        ComShowCodeMessage('TES10013');
        obj.focus();
        return false;
    }
    var formObj = document.form;
    if (formObj.eff_fm_dt.value != null && formObj.eff_fm_dt.value.trim() != '' &&
        formObj.eff_to_dt.value != null && formObj.eff_to_dt.value.trim() != '' &&
        !isValFmTo(formObj.eff_fm_dt.value, formObj.eff_to_dt.value)) {
        ComShowCodeMessage('TES10112');
        return false;
    }
}

/**
 * From ~ To Date Validate. <br>
 * 
 * @param {String}		fmDt		From Date
 * @param {String}		toDt		To Date
 **/
function isValFmTo(fmDt, toDt) {
    if (fmDt == undefined || fmDt == null || fmDt.trim() == '' || toDt == undefined || toDt == null || toDt.trim() == '') {
        return false;
    }
    var str_fmDt = fmDt.replace(/-/gi, '');
    var str_toDt = toDt.replace(/-/gi, '');
    if (isNaN(str_fmDt) || isNaN(str_toDt) || str_fmDt.trim().length != 8 || str_toDt.trim().length != 8) {
        return false;
    }
    if (parseInt(str_toDt, 10) - parseInt(str_fmDt, 10) <= 0) {
        return false;
    }
    return true;
}

/**
 * From ~ To Date Period Check Format. <br>
 * 
 * @param {String}		prd_dt		Period Date
 **/
function checkPeriodFormat(prd_dt) {
    var date_regexp = /(^\d{4}\-\d{2}\-\d{2}$)/;
    if (!tes_checkFormat2(prd_dt, date_regexp)) {
        return false;
    } else {
        return true;
    }
}

/**
 * Header Info Remark Save.<br>
 * 
 **/
function topBtnSave_RmkSave() {
    var formObject = document.form;
    var sheetObject5 = sheetObjects[5];
    formObject.agmt_confirm_flg.value = "agmtRmk";
    formObject.f_cmd.value = MULTI03;
    //			sheetObject5.DoAllSave("ESD_TES_0034GS.do", tesFrmQryStr(formObject));
    var SaveStr = sheetObject5.GetSaveString(true);
    var sXml = sheetObject5.GetSaveData("ESD_TES_0034GS.do", tesFrmQryStr(formObject) + '&' + SaveStr);
    sheetObject5.LoadSaveData(sXml, true);
}

/**
 * Only Header Info Save.<br>
 * 
 **/
function topBtnSave_OnlyTopSave() {
    var formObject = document.form;
    var sheetObject5 = sheetObjects[5];
    formObject.tml_agmt_ofc_cty_cd.value = "";
    formObject.tml_agmt_ver_no.value = "";
    formObject.tml_agmt_tp_cd.value = "T";
    formObject.f_cmd.value = SEARCH06;
    doActionIBSheet6(sheetObject5, formObject, IBSEARCH);
    // 1, 2 tml_agmt_ofc_cty_cd, tml_agmt_seq
    //		if(sheetObjects[5].CellValue(1, 1) != "" && sheetObjects[5].CellValue(1, 2) != "" ) {
    //if(sheetObjects[5].GetCellValue(1, "tml_agmt_ofc_cty_cd") != "" ) {
    if (sheetObjects[5].GetCellValue(1, "tml_agmt_ofc_cty_cd") == "" || sheetObjects[5].GetCellValue(1, "tml_agmt_ofc_cty_cd") == -1) { // TEXT or -1
        if (agmtRegFlg == "Y") {
            formObject.f_cmd.value = ADD;
            doActionIBSheet6(sheetObject5, formObject, IBSAVE);
            formObject.f_cmd.value = SEARCH;
            doActionIBSheet6(sheetObject5, formObject, IBSEARCH);
            agmtRegFlg = "";
        }
    } else {
        ComShowCodeMessage('TES10113'); // There is registered Agreement with same Yard, Vendor.
    }
}

/**
 * Agreement Confirm Save.<br>
 * 
 **/
function topBtnSave_Confirm() {
    var formObject = document.form;
    var sheetObject2 = sheetObjects[2];
    var sheetObject4 = sheetObjects[4];
    var sheetObject5 = sheetObjects[5];
    var sheetObject8 = sheetObjects[8];

    var sheet2TransCount = 0;
    var sheet4TransCount = 0;
    var sheet8TransCount = 0;

    var modifyTop = "N";
    var modifySheet = "N";
    var remarkFlg = "N";
    // 8, 9, 10
    if (sheetObjects[5].GetCellValue(1, "eff_fm_dt") == formObject.eff_fm_dt.value &&
        sheetObjects[5].GetCellValue(1, "eff_to_dt") == formObject.eff_to_dt.value &&
        sheetObjects[5].GetCellValue(1, "auto_xtd_flg") == getElementValue(formObject, 'radio', 'auto_xtd_flg')) {
        modifyTop = "N";
    } else {
        modifyTop = "Y";
    }
    if (sheetObjects[5].GetCellValue(1, "agmt_rmk") != formObject.agmt_rmk.value) { // 12
        remarkFlg = "Y";
    }
    if (tabObjects[0].GetSelectedIndex() == 1) {
        for (var i = 0; i < sheetObjects[2].RowCount(); i++) {
            if (sheetObjects[2].GetCellValue(i + 3, "3ibflag") == "U" ||
                sheetObjects[2].GetCellValue(i + 3, "3ibflag") == "D" ||
                sheetObjects[2].GetCellValue(i + 3, "3ibflag") == "I") {
                sheet2TransCount = sheet2TransCount + 1;
            }
        }
        if (sheet2TransCount > 0) {
            modifySheet = "Y";
        }
    } else if (tabObjects[0].GetSelectedIndex() == 3) {
        for (var i = 0; i < sheetObjects[4].RowCount(); i++) {
            if (sheetObjects[4].GetCellValue(i + 3, "5ibflag") == "U" ||
                sheetObjects[4].GetCellValue(i + 3, "5ibflag") == "D" ||
                sheetObjects[4].GetCellValue(i + 3, "5ibflag") == "I") {
                sheet4TransCount = sheet4TransCount + 1;
            }
        }
        if (sheet4TransCount > 0) {
            modifySheet = "Y";
        }
    } else if (tabObjects[0].GetSelectedIndex() == 4) {
        for (var i = 0; i < sheetObjects[8].RowCount(); i++) {
            if (sheetObjects[8].GetCellValue(i + 2, "9ibflag") == "U" ||
                sheetObjects[8].GetCellValue(i + 2, "9ibflag") == "D" ||
                sheetObjects[8].GetCellValue(i + 2, "9ibflag") == "I") {
                sheet8TransCount = sheet8TransCount + 1;
            }
        }
        if (sheet8TransCount > 0) {
            modifySheet = "Y";
        }
    } else {
        modifySheet = "N";
    }
    if ((modifyTop == "Y" || getElementValue(formObject, 'radio', 'amend_flg') == "Y") && modifySheet == "Y") {
        ComShowCodeMessage('TES10114');
        return false;
    }
    if (modifyTop == "N" && getElementValue(formObject, 'radio', 'amend_flg') != "Y" && modifySheet == "N") {
        ComShowCodeMessage('TES10115');
        return false;
    }
    if (getElementValue(formObject, 'radio', 'amend_flg') == "Y" && modifySheet == "N") {
        formObject.agmt_confirm_flg.value = "level1";
        formObject.f_cmd.value = MULTI03;
        //			sheetObject2.DoAllSave("ESD_TES_0034GS.do", tesFrmQryStr(formObject));            
        var SaveStr = sheetObject2.GetSaveString(true);
        var sXml = sheetObject2.GetSaveData("ESD_TES_0034GS.do", tesFrmQryStr(formObject) + '&' + SaveStr);
        sheetObject2.LoadSaveData(sXml, true);
    } else if (modifyTop == "Y" && getElementValue(formObject, 'radio', 'amend_flg') != "Y" && modifySheet == "N") {
        formObject.agmt_confirm_flg.value = "level2";
        formObject.f_cmd.value = MULTI03;
        var SaveStr = sheetObject2.GetSaveString(true);
        var sXml = sheetObject2.GetSaveData("ESD_TES_0034GS.do", tesFrmQryStr(formObject) + '&' + SaveStr);
        sheetObject2.LoadSaveData(sXml, true);
    } else if (modifyTop == "N" && getElementValue(formObject, 'radio', 'amend_flg') != "Y" && modifySheet == "Y") {
        formObject.agmt_confirm_flg.value = "sheet";
        if (tabObjects[0].GetSelectedIndex() == 1) {
            if (sheet2TransCount > 0) {
                formObject.tml_agmt_tp_cd.value = "T";
                formObject.sheet_prefix.value = "3";
                formObject.f_cmd.value = MULTI03;
                formObject.select_tab.value = tabObjects[0].GetSelectedIndex();
                //sheetObject2.DoAllSave("ESD_TES_0034GS.do", tesFrmQryStr(formObject));
                var SaveStr = sheetObject2.GetSaveString(true);
                var sXml = sheetObject2.GetSaveData("ESD_TES_0034GS.do", tesFrmQryStr(formObject) + '&' + SaveStr);
                sheetObject2.LoadSaveData(sXml, true);
            }
        } else if (tabObjects[0].GetSelectedIndex() == 3) {
            if (sheet4TransCount > 0) {
                formObject.tml_agmt_tp_cd.value = "S";
                formObject.sheet_prefix.value = "5";
                formObject.f_cmd.value = MULTI03;
                formObject.select_tab.value = tabObjects[0].GetSelectedIndex();
                var SaveStr = sheetObject4.GetSaveString(true);
                var sXml = sheetObject4.GetSaveData("ESD_TES_0034GS.do", tesFrmQryStr(formObject) + '&' + SaveStr);
                sheetObject4.LoadSaveData(sXml, true);
            }
        } else if (tabObjects[0].GetSelectedIndex() == 4) {
            if (sheet8TransCount > 0) {
                formObject.tml_agmt_tp_cd.value = "E"; //
                formObject.sheet_prefix.value = "9";
                formObject.f_cmd.value = MULTI03;
                formObject.select_tab.value = tabObjects[0].GetSelectedIndex();
                var SaveStr = sheetObject8.GetSaveString(true);
                var sXml = sheetObject8.GetSaveData("ESD_TES_0034GS.do", tesFrmQryStr(formObject) + '&' + SaveStr);
                sheetObject8.LoadSaveData(sXml, true);
            }
        }
    }
    formObject.inquiryFlg.value = "";
    newRetrieve();
}

/**
 * Agreement Process Save.<br>
 * 
 **/
function topBtnSave_Process() {
    var formObject = document.form;
    var sheetObject2 = sheetObjects[2];
    var sheetObject4 = sheetObjects[4];
    var sheetObject5 = sheetObjects[5];
    var sheetObject8 = sheetObjects[8];
    var sheet2TransCount = 0;
    var sheet4TransCount = 0;
    var sheet8TransCount = 0;
    var modifyTop = "N";
    // 8, 9, 10, 12
    if (sheetObjects[5].GetCellValue(1, "eff_fm_dt") == formObject.eff_fm_dt.value &&
        sheetObjects[5].GetCellValue(1, "eff_to_dt") == formObject.eff_to_dt.value &&
        sheetObjects[5].GetCellValue(1, "auto_xtd_flg") == getElementValue(formObject, 'radio', 'auto_xtd_flg') &&
        sheetObjects[5].GetCellValue(1, "agmt_rmk") == formObject.agmt_rmk.value) {
        modifyTop = "N";
    } else {
        modifyTop = "Y";
    }
    for (var i = 0; i < sheetObjects[2].RowCount(); i++) {
        if (sheetObjects[2].GetCellValue(i + 3, "3ibflag") == "U" ||
            sheetObjects[2].GetCellValue(i + 3, "3ibflag") == "D" ||
            sheetObjects[2].GetCellValue(i + 3, "3ibflag") == "I") {
            sheet2TransCount = sheet2TransCount + 1;
        }
    }
    for (var i = 0; i < sheetObjects[4].RowCount(); i++) {
        if (sheetObjects[4].GetCellValue(i + 3, "5ibflag") == "U" ||
            sheetObjects[4].GetCellValue(i + 3, "5ibflag") == "D" ||
            sheetObjects[4].GetCellValue(i + 3, "5ibflag") == "I") {
            sheet4TransCount = sheet4TransCount + 1;
        }
    }
    for (var i = 0; i < sheetObjects[8].RowCount(); i++) {
        if (sheetObjects[8].GetCellValue(i + 2, "9ibflag") == "U" ||
            sheetObjects[8].GetCellValue(i + 2, "9ibflag") == "D" ||
            sheetObjects[8].GetCellValue(i + 2, "9ibflag") == "I") {
            sheet8TransCount = sheet8TransCount + 1;
        }
    }
    if (tabObjects[0].GetSelectedIndex() == 1) {
        if (modifyTop == "N" && sheet2TransCount == 0 && sheetObjects[2].RowCount() > 0) {
            ComShowCodeMessage('TES10115');
            return false;
        }
        formObject.tml_agmt_tp_cd.value = "T";
        formObject.sheet_prefix.value = "3";
        formObject.f_cmd.value = MULTI03;
        formObject.select_tab.value = tabObjects[0].GetSelectedIndex();
        var SaveStr = sheetObject2.GetSaveString(true);
        var sXml = sheetObject2.GetSaveData("ESD_TES_0034GS.do", tesFrmQryStr(formObject) + '&' + SaveStr);
        sheetObject2.LoadSaveData(sXml, true);
        newRetrieve();
    } else if (tabObjects[0].GetSelectedIndex() == 3) {
        if (modifyTop == "N" && sheet4TransCount == 0 && sheetObjects[4].RowCount() > 0) {
            ComShowCodeMessage('TES10115');
            return false;
        }
        formObject.tml_agmt_tp_cd.value = "S";
        formObject.sheet_prefix.value = "5";
        formObject.f_cmd.value = MULTI03;
        formObject.select_tab.value = tabObjects[0].GetSelectedIndex();
        var SaveStr = sheetObject4.GetSaveString(true);
        var sXml = sheetObject4.GetSaveData("ESD_TES_0034GS.do", tesFrmQryStr(formObject) + '&' + SaveStr);
        sheetObject4.LoadSaveData(sXml, true);
        newRetrieve();
    } else if (tabObjects[0].GetSelectedIndex() == 4) {
        if (modifyTop == "N" && sheet8TransCount == 0 && sheetObjects[8].RowCount() > 0) {
            ComShowCodeMessage('TES10115');
            return false;
        }
        formObject.tml_agmt_tp_cd.value = "E";
        formObject.sheet_prefix.value = "9";
        formObject.f_cmd.value = MULTI03;
        formObject.select_tab.value = tabObjects[0].GetSelectedIndex();
        var SaveStr = sheetObject8.GetSaveString(true);
        var sXml = sheetObject8.GetSaveData("ESD_TES_0034GS.do", tesFrmQryStr(formObject) + '&' + SaveStr);
        sheetObject8.LoadSaveData(sXml, true);
        newRetrieve();
    } else if (tabObjects[0].GetSelectedIndex() == 0 || tabObjects[0].GetSelectedIndex() == 2) {
        formObject.f_cmd.value = MULTI03;
        formObject.select_tab.value = tabObjects[0].GetSelectedIndex();
        //			sheetObject5.DoAllSave("ESD_TES_0034GS.do", tesFrmQryStr(formObject));			
        var SaveStr = sheetObject5.GetSaveString(true);
        var sXml = sheetObject5.GetSaveData("ESD_TES_0034GS.do", tesFrmQryStr(formObject) + '&' + SaveStr);
        sheetObject5.LoadSaveData(sXml, true);
    }
}

/**
 * Agreement Process Save.<br>
 * 
 **/
function newRetrieve() {
    var formObject = document.form;
    var sheetObject2 = sheetObjects[2];
    var sheetObject4 = sheetObjects[4];
    var sheetObject5 = sheetObjects[5];
    var sheetObject8 = sheetObjects[8];

    switch (tabObjects[0].GetSelectedIndex()) {
        case 0:
            formObject.tml_agmt_tp_cd.value = "T";
            formObject.f_cmd.value = SEARCH;
            doActionIBSheet6(sheetObject5, formObject, IBSEARCH);
            if (doActionIBSheet6SearchFlg != "NoData") {
                doActionIBSheet3(sheetObject2, formObject, IBSEARCH);
            }
            formObject.tml_agmt_tp_cd.value = "S";
            formObject.f_cmd.value = SEARCH;
            if (doActionIBSheet6SearchFlg != "NoData") {
                doActionIBSheet5(sheetObject4, formObject, IBSEARCH);
            }
            formObject.tml_agmt_tp_cd.value = "E";
            formObject.f_cmd.value = SEARCH;
            if (doActionIBSheet6SearchFlg != "NoData") {
                doActionIBSheet9(sheetObject8, formObject, IBSEARCH);
            }
            break;
        case 1:
            formObject.tml_agmt_tp_cd.value = "T";
            formObject.f_cmd.value = SEARCH;
            doActionIBSheet6(sheetObject5, formObject, IBSEARCH);
            if (doActionIBSheet6SearchFlg != "NoData") {
                doActionIBSheet3(sheetObject2, formObject, IBSEARCH);
            }
            break;
        case 2:
            formObject.tml_agmt_tp_cd.value = "S";
            formObject.f_cmd.value = SEARCH;
            doActionIBSheet6(sheetObject5, formObject, IBSEARCH);
            if (doActionIBSheet6SearchFlg != "NoData") {
                doActionIBSheet5(sheetObject4, formObject, IBSEARCH);
            }
            formObject.tml_agmt_tp_cd.value = "T";
            formObject.f_cmd.value = SEARCH;
            if (doActionIBSheet6SearchFlg != "NoData") {
                doActionIBSheet3(sheetObject2, formObject, IBSEARCH);
            }
            formObject.tml_agmt_tp_cd.value = "E";
            formObject.f_cmd.value = SEARCH;
            if (doActionIBSheet6SearchFlg != "NoData") {
                doActionIBSheet9(sheetObject8, formObject, IBSEARCH);
            }
            break;
        case 3:
            formObject.tml_agmt_tp_cd.value = "S";
            formObject.f_cmd.value = SEARCH;
            doActionIBSheet6(sheetObject5, formObject, IBSEARCH);
            if (doActionIBSheet6SearchFlg != "NoData") {
                doActionIBSheet5(sheetObject4, formObject, IBSEARCH);
            }
        case 4:
            formObject.tml_agmt_tp_cd.value = "E";
            formObject.f_cmd.value = SEARCH;
            doActionIBSheet6(sheetObject5, formObject, IBSEARCH);
            if (doActionIBSheet6SearchFlg != "NoData") {
                doActionIBSheet9(sheetObject8, formObject, IBSEARCH);
            }
            break;
    }
}


/**
 * Sheet Duplicate Row Check.<br>
 * @param{amgtGB}	amgtGB	Agreement Gubun Value ( T:Terminal, S:Storage )
 **/
function dupRowCheck(amgtGB) {
    var dupRowCount = 0;
    var nullRmkCount = 0;
    
    if (amgtGB == "T") {
        var dupRowInfo = sheetObjects[2].ColValueDupRows("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33", false, true);
        var dupRowInfo2 = sheetObjects[2].ColValueDupRows("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|65", false, true);
        
        // Check Validation.
        var dupRowCostCd	= sheetObjects[2].ColValueDupRows("3lgs_cost_cd", false, true);
        if ( dupRowCostCd != "" ) {
        	var arrDupRow	= dupRowCostCd.split("|");
        	var dupRowCd	= arrDupRow[0].split(",");
        	var dupRowCd2	= arrDupRow[1].split(",");
            
        	// IO_Bound Same, I/O Check Validation.
        	var validErrCnt = 0;
        	var chkArrCd = [];
        	chkArrCd = ["IO", "OI", "S"];
        	validErrCnt = dupRow_validCheck(dupRowCd, dupRowCd2, sheetObjects[2], "3", chkArrCd, "io_bnd_cd");
        	
        	// IPC_Ocean Same, I/O Check Validation.
    		chkArrCd = ["IO", "OI", "S"];
    		validErrCnt = validErrCnt + dupRow_validCheck(dupRowCd, dupRowCd2, sheetObjects[2], "3", chkArrCd, "ioc_cd");

        	if ( validErrCnt > 0 ) {
            	ComShowCodeMessage('TES10029', validErrCnt);
            	return false;
            } else {
            	return true;
            }
        }
        
        if (dupRowInfo != "") {
            var dupRow = dupRowInfo.split("|");
            var dupRowNum = dupRow[1].split(",");
            var dupRowNum2 = dupRow[0].split(",");

            //remark에 따라
            var dupRowRmk = "";
            var dupRowRmkNum = "";
            if (dupRowInfo2 != "") {
                dupRowRmk = dupRowInfo2.split("|");
                dupRowRmkNum = dupRowRmk[1].split(",");
            }


            if (dupRowNum.length > 0) {
                for (var i = 0; i < dupRowNum.length; i++) {
                    if (sheetObjects[2].GetCellValue(dupRowNum[i], "3auto_calc_flg") == "N") {
                        if (sheetObjects[2].GetCellValue(dupRowNum[i], "3remark") == "" || sheetObjects[2].GetCellValue(dupRowNum2[i], "3remark") == "") {
                            if (sheetObjects[2].GetCellValue(dupRowNum[i], "3remark") == "") {
                                sheetObjects[2].SetCellValue(dupRowNum[i], "3verify_result", "Fill the remark.;");
                                sheetObjects[2].SetCellBackColor(dupRowNum[i], "3verify_result", "#FF0000");
                                sheetObjects[2].SetCellBackColor(dupRowNum[i], 1, "#FF0000");
                                nullRmkCount++;
                            }
                            if (sheetObjects[2].GetCellValue(dupRowNum2[i], "3remark") == "") {
                                sheetObjects[2].SetCellBackColor(dupRowNum2[i], "3verify_result", "#FF0000");
                                sheetObjects[2].SetCellBackColor(dupRowNum2[i], 1, "#FF0000");
                                sheetObjects[2].SetCellValue(dupRowNum2[i], "3verify_result", "Fill the remark.;");
                                nullRmkCount++;
                            }
                        }
                    }
                }

                if (nullRmkCount > 0) {
                    alert("Fill the remark.");
                    return false;
                }


                for (var i = 0; i < dupRowNum.length; i++) {
                    if (sheetObjects[2].GetCellValue(dupRowNum[i], "3auto_calc_flg") == "Y") {
                        sheetObjects[2].SetRowBackColor(dupRowNum[i], "#FF0000");
                        dupRowCount++;
                    }
                }

                for (var i = 0; i < dupRowRmkNum.length; i++) {
                    if (sheetObjects[2].GetCellValue(dupRowRmkNum[i], "3auto_calc_flg") == "N") {
                        sheetObjects[2].SetRowBackColor(dupRowRmkNum[i], "#FF0000");
                        dupRowCount++;
                    }
                }

                if (dupRowCount > 0) {
                    ComShowCodeMessage('TES10119', dupRowCount);
                    return false;
                } else {
                    return true;
                }
            } else {
                return true;
            }
        }
    } else if (amgtGB == "S") {
        var dupRowInfo = sheetObjects[4].ColValueDupRows("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42", false, true);
        var dupRowInfo2 = sheetObjects[4].ColValueDupRows("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|99", false, true);

        if (dupRowInfo != "") {
            var dupRow = dupRowInfo.split("|");
            var dupRowNum = dupRow[1].split(",");
            var dupRowNum2 = dupRow[0].split(",");

            var dupRowRmk = "";
            var dupRowRmkNum = "";

            if (dupRowInfo2 != "") {
                dupRowRmk = dupRowInfo2.split("|");
                dupRowRmkNum = dupRowRmk[1].split(",");
            }


            if (dupRowNum.length > 0) { //기존 로직
                for (var i = 0; i < dupRowNum.length; i++) {
                    var sCostCd = sheetObjects[4].GetCellValue(dupRowNum[i], "5lgs_cost_cd");
                    if (sCostCd == "SRXXDC" || sCostCd == "SRXXDM" || sCostCd == "SRXXMT" || sCostCd == "SRXXXX") { //수동비용 SRXXDC SRXXDM SRXXMT SRXXXX 
                        if (sheetObjects[4].GetCellValue(dupRowNum[i], "5remark") == "" || sheetObjects[4].GetCellValue(dupRowNum2[i], "5remark") == "") {
                            if (sheetObjects[4].GetCellValue(dupRowNum[i], "5remark") == "") {
                                sheetObjects[4].SetCellBackColor(dupRowNum[i], "5verify_result", "#FF0000");
                                sheetObjects[4].SetCellBackColor(dupRowNum[i], 1, "#FF0000");
                                sheetObjects[4].SetCellValue(dupRowNum[i], "5verify_result", "Fill the remark.;");
                                nullRmkCount++;
                            }

                            if (sheetObjects[4].GetCellValue(dupRowNum2[i], "5remark") == "") {
                                sheetObjects[4].SetCellBackColor(dupRowNum2[i], "5verify_result", "#FF0000");
                                sheetObjects[4].SetCellBackColor(dupRowNum2[i], 1, "#FF0000");
                                sheetObjects[4].SetCellValue(dupRowNum2[i], "5verify_result", "Fill the remark.;");
                                nullRmkCount++;
                            }
                        }
                    }
                }

                if (nullRmkCount > 0) {
                    alert("Fill the remark.");
                    return false;
                }

                for (var i = 0; i < dupRowNum.length; i++) {
                    var sCostCd = sheetObjects[4].GetCellValue(dupRowNum[i], "5lgs_cost_cd");
                    if (sCostCd != "SRXXDC" && sCostCd != "SRXXDM" && sCostCd != "SRXXMT" && sCostCd != "SRXXXX") { //수동비용 아닐때 SRXXDC SRXXDM SRXXMT SRXXXX
                        sheetObjects[4].SetRowBackColor(dupRowNum[i], "#FF0000");
                        dupRowCount++;
                    }
                }

                if (dupRowRmkNum.length > 0) { //추가로직 20150603
                    for (var i = 0; i < dupRowRmkNum.length; i++) {
                        var sCostCd = sheetObjects[4].GetCellValue(dupRowRmkNum[i], "5lgs_cost_cd");
                        if (sCostCd == "SRXXDC" || sCostCd == "SRXXDM" || sCostCd == "SRXXMT" || sCostCd == "SRXXXX") { //수동비용 일때 SRXXDC SRXXDM SRXXMT SRXXXX
                            sheetObjects[4].SetRowBackColor(dupRowRmkNum[i], "#FF0000");
                            dupRowCount++;
                        }
                    }
                }

                if (dupRowCount > 0) {
                    ComShowCodeMessage('TES10119', dupRowCount);
                    return false;
                } else {
                    return true;
                }
            } else {
                return true;
            }

        }


        //			if(dupRowInfo != ""){
        //				var dupRow=dupRowInfo.split("|");
        //				var dupRowNum=dupRow[1].split(",");
        //				var dupRowNum2=dupRow[0].split(",");
        //				
        //				if(dupRowNum.length > 0){
        //					for(var i=0 ; i < dupRowNum.length ;i++ ) {
        //						if(sheetObjects[4].GetCellValue(dupRowNum[i],"5lgs_cost_cd") == "SRXXDC"){//수동비용
        //							if(sheetObjects[4].GetCellValue(dupRowNum[i],"5remark")=="" || sheetObjects[4].GetCellValue(dupRowNum2[i],"5remark")=="" ){
        //								sheetObjects[4].SetRowBackColor(dupRowNum[i],"#FF0000");
        //								if(sheetObjects[4].GetCellValue(dupRowNum[i],"5remark")==""){
        //									sheetObjects[4].SetCellValue(dupRowNum[i],"5verify_result", "Fill the remark.;");
        //								}
        //								if(sheetObjects[4].GetCellValue(dupRowNum2[i],"5remark")==""){
        //									sheetObjects[4].SetRowBackColor(dupRowNum[i],"#FF0000");
        //									sheetObjects[4].SetCellValue(dupRowNum2[i],"5verify_result", "Fill the remark.;");
        //								}
        //								
        //								dupRowCount++;
        //								
        //							}else if(sheetObjects[4].GetCellValue(dupRowNum[i],"5remark") == sheetObjects[4].GetCellValue(dupRowNum2[i],"5remark") ){
        //								sheetObjects[4].SetRowBackColor(dupRowNum[i],"#FF0000");
        //								dupRowCount++;
        //							}
        //							
        //						}else{//자동비용
        //							sheetObjects[4].SetRowBackColor(dupRowNum[i],"#FF0000");
        //							dupRowCount++;
        //						}
        //					}
        //					
        //					if(dupRowCount>0){
        //						ComShowCodeMessage('TES10119', dupRowCount);	
        //						return false;
        //					}else{
        //						return true;
        //					}
        //					
        //				}
        //				
        //			}

    }

}
/**
 * Sheet Row Delete.<br>
 * 
 **/
function rowDelete() {
    var sheet = "";
    var k = 0;
    var prefix = "";
    if (tabObjects[0].GetSelectedIndex() == 1) {
        sheet = sheetObjects[2];
        prefix = "3"
    } else if (tabObjects[0].GetSelectedIndex() == 3) {
        sheet = sheetObjects[4];
        prefix = "5"
    } else if (tabObjects[0].GetSelectedIndex() == 4) {
        sheet = sheetObjects[8];
        prefix = "9"
    }
    for (var i = 0; i < sheet.RowCount(); i++) {
        if (sheet.GetCellValue(i + 3, prefix + "ibflag") == "I" && sheet.GetCellValue(i + 3, 0) == 1) {
            sheet.RowDelete(i + 3, false);
            k++;
            i = i - k;
        }
    }
}
/**
 * Sheet Row Delete.<br>
 * 
 **/
function delete_Process() {
    var formObject = document.form;
    var rowCheckCount = 0;
    var sheet = "";
    if (tabObjects[0].GetSelectedIndex() == 1) {
        sheet = sheetObjects[2];
    } else if (tabObjects[0].GetSelectedIndex() == 3) {
        sheet = sheetObjects[4];
    } else if (tabObjects[0].GetSelectedIndex() == 4) {
        sheet = sheetObjects[8];
    }
    var sRow = sheet.FindCheckedRow(0) + "|";
    var arrRow = sRow.split("|");
    if (arrRow.length > 0) {
        if (tabObjects[0].GetSelectedIndex() == 1) {
            formObject.tml_agmt_tp_cd.value = "T";
            formObject.sheet_prefix.value = "3";
            formObject.f_cmd.value = REMOVE01;
            formObject.select_tab.value = tabObjects[0].GetSelectedIndex();
            var SaveStr = sheetObjects[2].GetSaveString(false, true, 0);
            var sXml = sheetObjects[2].GetSaveData("ESD_TES_0034GS.do", tesFrmQryStr(formObject) + '&' + SaveStr);
            sheetObjects[2].LoadSaveData(sXml, true);
        } else if (tabObjects[0].GetSelectedIndex() == 3) {
            formObject.tml_agmt_tp_cd.value = "S";
            formObject.sheet_prefix.value = "5";
            formObject.f_cmd.value = REMOVE01;
            formObject.select_tab.value = tabObjects[0].GetSelectedIndex();
            var SaveStr = sheetObjects[4].GetSaveString(false, true, 0);
            var sXml = sheetObjects[4].GetSaveData("ESD_TES_0034GS.do", tesFrmQryStr(formObject) + '&' + SaveStr);
            sheetObjects[4].LoadSaveData(sXml, true);
        } else if (tabObjects[0].GetSelectedIndex() == 4) {
            formObject.tml_agmt_tp_cd.value = "E";
            formObject.sheet_prefix.value = "9";
            formObject.f_cmd.value = REMOVE01;
            formObject.select_tab.value = tabObjects[0].GetSelectedIndex();
            var SaveStr = sheetObjects[8].GetSaveString(false, true, 0);
            var sXml = sheetObjects[8].GetSaveData("ESD_TES_0034GS.do", tesFrmQryStr(formObject) + '&' + SaveStr);
            sheetObjects[8].LoadSaveData(sXml, true);
        }
        formObject.inquiryFlg.value = "";
    }
    newRetrieve();
}
/**
 * Agreement Rate List Regist.<br>
 * 
 **/
function agreementReg() {
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];
    var sheetObject3 = sheetObjects[3];
    var sheetObject4 = sheetObjects[4];
    var sheetObject5 = sheetObjects[5];
    var sheetObject6 = sheetObjects[6];
    var sheetObject7 = sheetObjects[7];
    var sheetObject8 = sheetObjects[8];
    var formObject = document.form;
    var noTerminalReadCount = 0;
    var noStorageReadCount = 0;
    var noEqStorageReadCount = 0;

    for (i = 1; i < (sheetObject2.RowCount() + 1); i++) {
        if (sheetObject2.GetRowStatus(i + 2) != "R") {
            noTerminalReadCount++;
        }
    }
    
    for (i = 1; i < (sheetObject4.RowCount() + 1); i++) {
        if (sheetObject4.GetRowStatus(i + 2) != "R") {
            noStorageReadCount++;
        }
    }

    for (i = 1; i < (sheetObject8.RowCount() + 1); i++) {
        if (sheetObject8.GetRowStatus(i + 2) != "R") {
            noEqStorageReadCount++;
        }
    }
    
    if (sheetObject5.GetCellValue(1, "tml_agmt_sts_cd") == "P") { // 11
        var thrpFlg = "N";
        var volACCFlg = "N";
        if (sheetObject2.RowCount() > 0) {
            if (tab2VerifyFlg) {} else {
                ComShowCodeMessage('TES10098');  // Terminal Rate List Verify has not been completed.
                return false;
            }
        }
        
        if (sheetObject4.RowCount() > 0) {
            if (tab4VerifyFlg) {} else {
                ComShowCodeMessage('TES10106'); // Storage Rate List Verify has not been completed.
                return false;
            }
        }
        
        if (sheetObject8.RowCount() > 0) {
            if (tab5VerifyFlg) {} else {
                ComShowCodeMessage('TES10130'); // EQ Storage Rate List Verify has not been completed.
                return false;
            }
        }
        
        for (i = 1; i < (sheetObject2.RowCount() + 1); i++) {
            if (sheetObject2.GetCellValue(i + 2, "3thrp_lgs_cost_cd") != "") {
                thrpFlg = "Y";
            }
            if (sheetObject2.GetCellValue(i + 2, "3fm_tr_vol_val") > 0 && sheetObject2.GetCellValue(i + 2, "3to_tr_vol_val") < 9999999) {
                volACCFlg = "Y";
            }
        }
        
        if (noTerminalReadCount == 0 && noStorageReadCount == 0 && noStorageReadCount == 0 && (sheetObject2.RowCount() > 0 || sheetObject4.RowCount() > 0 || sheetObject8.RowCount() > 0)) {
            if (thrpFlg == "Y" || volACCFlg == "Y") {
                formObject.f_cmd.value = MULTI04;
                formObject.select_tab.value = 1;
                var param = sheetObjects[2].GetSaveString(true);
                var sXml = sheetObjects[3].GetSearchData("ESD_TES_0034Detail.do", param + '&' + tesFrmQryStr(formObject), "", true);
                sheetObjects[3].LoadSearchData(sXml, { Sync: 1 });
                //	alert(ComGetEtcData(sXml, "regFlg"));
                var regProcessFlg = ComGetEtcData(sXml, "regFlg").split("|"); //sheetObjects[3].GetEtcData("regFlg").split("|");
                //	alert(regProcessFlg[0]);
                //	alert(regProcessFlg[1]);
            } else {
                var regProcessFlg = ",";
            }
            
            if (regProcessFlg[0] == "N" && regProcessFlg[1] == "N") {
                ComShowCodeMessage('TES10099'); // Throughput Cost Code and Volume Accumulated Method has not been registered.\n\n Please check again.
                return false;
            } else if (regProcessFlg[0] == "N") {
                ComShowCodeMessage('TES10100');  // Cost Code related with Throughput Rate has not been registered.\n\n Please check again.
                return false;
            } else if (regProcessFlg[1] == "N") {
                ComShowCodeMessage('TES10101');  // Volume Accumulate Method related with Tier Vol. adaption has not been registered.\n\n Please check again.
                return false;
            }
            //window.showModalDialog("ESD_TES_9090.do?openerUIName=035", window, "dialogWidth:308px; dialogHeight:170px; help:no; status:no; resizable:yes;");
            terminalAgreementConfirm();
        } else if (noTerminalReadCount > 0 || noStorageReadCount > 0 || noEqStorageReadCount > 0) {
            if (noTerminalReadCount > 0 && noStorageReadCount > 0 && noEqStorageReadCount > 0) {
                ComShowCodeMessage('TES10127');  // Terminal/Storage/EQ Storage Rate List Data have not been saved/modified.\n\n Please complete save/modify Data.
                return false;
            } else if (noTerminalReadCount > 0 && noStorageReadCount > 0) {
                ComShowCodeMessage('TES10125');  // Terminal/Storage Rate List Data have not been saved/modified.\n\n Please complete save/modify Data.
                return false;
            } else if (noTerminalReadCount > 0) {
                ComShowCodeMessage('TES10102');  // Saving/Modification of Terminal Rate List Data has not been completed.\n\n Please complete saving/modification the Data.
                return false;
            } else if (noStorageReadCount > 0) {
                ComShowCodeMessage('TES10109');  // Saving/modification of Storage Rate List Data has not been completed.\n\n Please complete saving/modification the Data.
                return false;
            }
            
        } else if (sheetObject2.RowCount() == 0 && sheetObject4.RowCount() == 0 && sheetObject8.RowCount() == 0) {
            ComShowCodeMessage('TES10126'); // There is no Rate List Data.\n\n Please check again.
            return false;
        }
        
    } else if (sheetObject5.GetCellValue(1, "tml_agmt_sts_cd") == "C") { // 11
        if (noTerminalReadCount > 0 && noStorageReadCount > 0 && noEqStorageReadCount > 0) {
            ComShowCodeMessage('TES10127'); // Terminal/Storage Rate List Data have not been saved/modified.\n\n Please complete save/modify Data.
            return false;
            
        } else if (noTerminalReadCount > 0 && noStorageReadCount > 0) {
            ComShowCodeMessage('TES10125'); // Terminal/Storage Rate List Data have not been saved/modified.\n\n Please complete save/modify Data.
            return false;
            
        } else if (noTerminalReadCount > 0) {
            ComShowCodeMessage('TES10102'); // Saving/Modification of Terminal Rate List Data has not been completed.\n\n Please complete saving/modification the Data.
            return false;
            
        } else if (noStorageReadCount > 0) {
            ComShowCodeMessage('TES10109'); // Saving/modification of Storage Rate List Data has not been completed.\n\n Please complete saving/modification the Data.
            return false;
        }
        ComShowCodeMessage('TES10036'); // This is Confirmed Terminal Rate List.
    }
}
/**
 * 
 * @param {String}		gb
 * @param {int,String}	Row
 * @param {String}		dateGB
 * @return
 */
function currRateModRow(gb, Row, dateGB) {
    var pointCount = 0;
    if (dateGB == dfInteger) {
        pointCount = 0;
    } else if (dateGB == dfFloat) {
        pointCount = 2;
    }
    if (gb == "terminal") {
        var sheetObj = sheetObjects[2];
        var sheetNo = 3;
        sheetObj.InitCellProperty(Row, sheetNo + "d2", dtData, daCenter, sheetNo + "d2", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "d4", dtData, daCenter, sheetNo + "d4", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "d5", dtData, daCenter, sheetNo + "d5", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "d7", dtData, daCenter, sheetNo + "d7", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "d8", dtData, daCenter, sheetNo + "d8", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "d9", dtData, daCenter, sheetNo + "d9", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "dw", dtData, daCenter, sheetNo + "dw", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "dx", dtData, daCenter, sheetNo + "dx", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "r2", dtData, daCenter, sheetNo + "r2", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "r4", dtData, daCenter, sheetNo + "r4", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "r5", dtData, daCenter, sheetNo + "r5", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "r7", dtData, daCenter, sheetNo + "r7", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "f2", dtData, daCenter, sheetNo + "f2", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "f4", dtData, daCenter, sheetNo + "f4", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "f5", dtData, daCenter, sheetNo + "f5", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "o2", dtData, daCenter, sheetNo + "o2", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "o4", dtData, daCenter, sheetNo + "o4", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "s2", dtData, daCenter, sheetNo + "s2", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "s4", dtData, daCenter, sheetNo + "s4", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "t2", dtData, daCenter, sheetNo + "t2", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "t4", dtData, daCenter, sheetNo + "t4", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "a2", dtData, daCenter, sheetNo + "a2", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "a4", dtData, daCenter, sheetNo + "a4", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "p2", dtData, daCenter, sheetNo + "p2", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "p4", dtData, daCenter, sheetNo + "p4", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "teu_rate", dtData, daCenter, sheetNo + "teu_rate", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "box_rate", dtData, daCenter, sheetNo + "box_rate", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "move_rate", dtData, daCenter, sheetNo + "move_rate", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, sheetNo + "gang_hour_rate", dtData, daCenter, sheetNo + "gang_hour_rate", "", dateGB, pointCount, 18);
    } else if (gb == "storage") {
        var sheetObj = sheetObjects[4];
        sheetObj.InitCellProperty(Row, "5d2_r", dtData, daCenter, "5d2_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5d4_r", dtData, daCenter, "5d4_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5d5_r", dtData, daCenter, "5d5_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5d7_r", dtData, daCenter, "5d7_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5d8_r", dtData, daCenter, "5d8_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5d9_r", dtData, daCenter, "5d9_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5dw_r", dtData, daCenter, "5dw_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5dx_r", dtData, daCenter, "5dx_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5r2_r", dtData, daCenter, "5r2_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5r4_r", dtData, daCenter, "5r4_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5r5_r", dtData, daCenter, "5r5_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5r7_r", dtData, daCenter, "5r7_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5f2_r", dtData, daCenter, "5f2_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5f4_r", dtData, daCenter, "5f4_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5f5_r", dtData, daCenter, "5f5_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5o2_r", dtData, daCenter, "5o2_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5o4_r", dtData, daCenter, "5o4_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5s2_r", dtData, daCenter, "5s2_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5s4_r", dtData, daCenter, "5s4_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5t2_r", dtData, daCenter, "5t2_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5t4_r", dtData, daCenter, "5t4_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5a2_r", dtData, daCenter, "5a2_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5a4_r", dtData, daCenter, "5a4_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5p2_r", dtData, daCenter, "5p2_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5p4_r", dtData, daCenter, "5p4_r", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5teu_rate", dtData, daCenter, "5teu_rate", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5box_rate", dtData, daCenter, "5box_rate", "", dateGB, pointCount, 18);
        sheetObj.InitCellProperty(Row, "5move_rate", dtData, daCenter, "5move_rate", "", dateGB, pointCount, 18);
    }
}
/**
 * 
 * @param {ibsheet}		sheetObj
 * @param {int,String}	row
 * @param {int,String}	col
 * @param {String}		Value
 * @return
 */
function t4sheet1_OnChange(sheetObj, row, col, Value) {
    var total_rate = "";
    var daysTotalRate = 0;
    var rateTotalRate = 0;
    if (sheetObj.GetCellValue(row, "5ft_dys") == "F") {
        for (i = 42 + gap_st; i < 67 + gap_st; i++) {
            total_rate = total_rate + "#" + sheetObj.GetCellValue(row, i);
            daysTotalRate = parseInt(sheetObj.GetCellValue(row, i)) + daysTotalRate;
        }
        if (col > 41 + gap_st || col < 67 + gap_st) {
            sheetObj.SetCellValue(row, "5ts_rt", total_rate, 0);
        }
    }
    if (sheetObj.GetCellValue(row, "5ft_dys") == "" || sheetObj.GetCellValue(row, "5ft_dys") == undefined) {
        for (i = 67 + gap_st; i < 92 + gap_st; i++) {
            total_rate = total_rate + "#" + sheetObj.GetCellValue(row, i);
            rateTotalRate = parseInt(sheetObj.GetCellValue(row, i)) + rateTotalRate;
        }
        if (col > 66 + gap_st || col < 92 + gap_st) {
            sheetObj.SetCellValue(row, "5ts_rt", total_rate, 0);
        }
    }
    if (sheetObj.GetCellValue(row, "5curr_cd") == "KRW" || sheetObj.GetCellValue(row, "5curr_cd") == "JPY") {
        currRateModRow('storage', row, dfInteger);
    } else {
        currRateModRow('storage', row, dfFloat);
    }

    if (sheetObj.GetCellValue(row, "5lgs_cost_cd") == "SRNDTS") {
        sheetObj.SetCellEditable(row, "5tml_cntr_sty_cd", 1);
    } else {
        sheetObj.SetCellEditable(row, "5tml_cntr_sty_cd", 0);
    }

    if (col == 39 + gap_st) {
        sheetObj.SetCellValue(row, "5to_tr_dys", sheetObj.GetCellValue(row, "5to_tr_dys"));
        if (sheetObj.GetCellValue(row, "5to_tr_dys") != "MAX") {
            if (!ComIsNumber(sheetObj.GetCellValue(row, "5to_tr_dys"))) {
                //ComShowMessage("숫자와 MAX만 입력 가능합니다. 다시 확인하세요.");
                sheetObj.SetCellValue(row, "5to_tr_dys", "", 0);
            }
        }
    }

    if (sheetObj.ColSaveName(col) == "5tml_sto_agmt_tp_cd" && sheetObj.GetCellValue(row, col) == "FP") {
        sheetObj.SetCellValue(row, "5tml_agmt_vol_ut_cd", "T");
    } else if (sheetObj.ColSaveName(col) == "5tml_sto_agmt_tp_cd" && sheetObj.GetCellValue(row, col) == "FD") {
        sheetObj.SetCellValue(row, "5tml_agmt_vol_ut_cd", "C");
    }

    if (sheetObj.ColSaveName(col) == "5cmnc_hrmnt") {
        var time = Value; //sheetObj.GetEditText();
        var hour = time.substring(0, 2);
        var minute = time.substring(2, 4);
        if (parseInt(hour) < 10) {
            hour = '0' + parseInt(hour);
        }
        if (parseInt(minute) == 0 || minute == '  ') {
            minute = '00';
        } else if (parseInt(minute) < 10) {
            minute = '0' + parseInt(minute);
        }
        if (parseInt(hour) <= 23 && parseInt(minute) <= 59) {
            sheetObj.SetCellValue(row, '5cmnc_hrmnt', hour + ':' + minute, 0);
            return true;
        } else if (parseInt(hour) == 24 && parseInt(minute) == 00) {
            sheetObj.SetCellValue(row, '5cmnc_hrmnt', hour + ':' + minute, 0);
            return true;
        } else {
            ComShowCodeMessage('TES50102'); // ComShowMessage('Please insert correct time');
            sheetObj.SetCellValue(row, '5cmnc_hrmnt', '', 0);
            return false;
        }
    }
}

/** t5sheet1_OnChange
 * 
 * @param sheetObj
 * @param row
 * @param col
 * @param Value
 * @returns {Boolean}
 */
function t5sheet1_OnChange(sheetObj, row, col, Value) {
    var total_rate = "";
    var daysTotalRate = 0;
    var rateTotalRate = 0;
    //        if(sheetObj.GetCellValue(row, "9ft_dys")=="F"){
    for (i = 16 + gap_eq; i < 34 + gap_eq; i++) {
        total_rate = total_rate + "#" + sheetObj.GetCellValue(row, i);
        daysTotalRate = parseInt(sheetObj.GetCellValue(row, i)) + daysTotalRate;
    }

    //            for(i=28+gap_eq ;i< 30+gap_eq;i++){
    //            	total_rate=total_rate+"#"+sheetObj.GetCellValue(row, i);
    //            	daysTotalRate=parseInt(sheetObj.GetCellValue(row, i))+daysTotalRate;
    //            }  

    if (col > 15 + gap_eq || col < 34 + gap_eq) {
        sheetObj.SetCellValue(row, "9ts_rt", total_rate, 0);
    }
    //        }


    //        if(sheetObj.GetCellValue(row, "9ft_dys")=="" || sheetObj.GetCellValue(row, "9ft_dys")==undefined){
    //            for(i=24+gap_eq ;i< 32+gap_eq;i++){
    //            	total_rate=total_rate+"#"+sheetObj.GetCellValue(row, i);
    //            	rateTotalRate=parseInt(sheetObj.GetCellValue(row, i))+rateTotalRate;
    //            }
    ////            for(i=30+gap_eq ;i< 32+gap_eq;i++){
    ////            	total_rate=total_rate+"#"+sheetObj.GetCellValue(row, i);
    ////            	rateTotalRate=parseInt(sheetObj.GetCellValue(row, i))+rateTotalRate;
    ////            }            
    ////            
    //            if (col >23+gap_eq || col < 32+gap_eq){
    //                sheetObj.SetCellValue(row,"9ts_rt",total_rate,0);
    //            }
    //        }
    if (sheetObj.GetCellValue(row, "9curr_cd") == "KRW" || sheetObj.GetCellValue(row, "9curr_cd") == "JPY") {
        currRateModRow('storage', row, dfInteger);
    } else {
        currRateModRow('storage', row, dfFloat);
    }

    if (col == 39 + gap_eq) {
        sheetObj.SetCellValue(row, "9to_tr_dys", sheetObj.GetCellValue(row, "9to_tr_dys"));
        if (sheetObj.GetCellValue(row, "9to_tr_dys") != "MAX") {
            if (!ComIsNumber(sheetObj.GetCellValue(row, "9to_tr_dys"))) {
                //ComShowMessage("숫자와 MAX만 입력 가능합니다. 다시 확인하세요.");
                sheetObj.SetCellValue(row, "9to_tr_dys", "", 0);
            }
        }
    }

    if (sheetObj.ColSaveName(col) == "9tml_sto_agmt_tp_cd" && sheetObj.GetCellValue(row, col) == "FP") {
        sheetObj.SetCellValue(row, "9tml_agmt_vol_ut_cd", "T");
    } else if (sheetObj.ColSaveName(col) == "9tml_sto_agmt_tp_cd" && sheetObj.GetCellValue(row, col) == "FD") {
        sheetObj.SetCellValue(row, "9tml_agmt_vol_ut_cd", "C");
    }

    if (sheetObj.ColSaveName(col) == "9cmnc_hrmnt") {
        var time = Value; //sheetObj.GetEditText();
        var hour = time.substring(0, 2);
        var minute = time.substring(2, 4);
        if (parseInt(hour) < 10) {
            hour = '0' + parseInt(hour);
        }
        if (parseInt(minute) == 0 || minute == '  ') {
            minute = '00';
        } else if (parseInt(minute) < 10) {
            minute = '0' + parseInt(minute);
        }
        if (parseInt(hour) <= 23 && parseInt(minute) <= 59) {
            sheetObj.SetCellValue(row, '9cmnc_hrmnt', hour + ':' + minute, 0);
            return true;
        } else if (parseInt(hour) == 24 && parseInt(minute) == 00) {
            sheetObj.SetCellValue(row, '9cmnc_hrmnt', hour + ':' + minute, 0);
            return true;
        } else {
            ComShowCodeMessage('TES50102'); // ComShowMessage('Please insert correct time');
            sheetObj.SetCellValue(row, '9cmnc_hrmnt', '', 0);
            return false;
        }
    }
}
/*******************************************************************
 * 2. Agreement Rate List Input
 * 
 ******************************************************************/
/**
 * Terminal Rate Input To Terminal Rate List Data Insert 
 */
function terminalRateInputList() {
    var formObject = document.form;
    var sheetNo = "3";
    var k = sheetObjects[2].RowCount() + 1;
    var eq_loop_count = 0;
    var sheet1_parameters = new Array();
    sheet1_parameters = sheetObjects[0].FindCheckedRow(0) + "|".split("|");
    var sheet2_parameters = new Array();
    sheet2_parameters = sheetObjects[1].FindCheckedRow(0) + "|".split("|");
    sheetObjects[2].DataInsert(-1);
    sheetObjects[2].SetCellValue(k + 2, 0, " ");
    sheetObjects[2].SetCellValue(k + 2, 1, " ");
    sheetObjects[2].SetCellValue(k + 2, sheetNo + "lgs_cost_cd", comboObjects[0].GetSelectCode());
    sheetObjects[2].SetCellValue(k + 2, sheetNo + "tml_cntr_sty_cd", formObject.tml_cntr_sty_cd.value); //auto_calc_flg
    sheetObjects[2].SetCellValue(k + 2, sheetNo + "auto_calc_flg", getElementValue(formObject, 'radio', 'auto_calc_flg')); //auto_calc_flg
    sheetObjects[2].SetCellValue(k + 2, sheetNo + "tml_agmt_vol_ut_cd", formObject.tml_agmt_vol_ut_cd[1].value);
    sheetObjects[2].SetCellValue(k + 2, sheetNo + "curr_cd", comboObjects[1].GetSelectCode());
    if (formObject.lgs_cost_cd_t.value.substring(0, 2) == "TP") {
        sheetObjects[2].SetCellValue(k + 2, sheetNo + "thrp_lgs_cost_cd", "");
    } else {
        sheetObjects[2].SetCellValue(k + 2, sheetNo + "thrp_lgs_cost_cd", sheetObjects[6].GetCellValue(1, 0)); //tt_cd
    }
    sheetObjects[2].SetCellValue(k + 2, sheetNo + "io_bnd_cd", formObject.io_bnd_cd[1].value);
    sheetObjects[2].SetCellValue(k + 2, sheetNo + "ioc_cd", formObject.ioc_cd.value);
    sheetObjects[2].SetCellValue(k + 2, sheetNo + "tml_trns_mod_cd", formObject.tml_trns_mod_cd[0].value + formObject.tml_trns_mod_cd[1].value);
    if (formObject.wkdy_flg.checked == true) {
        sheetObjects[2].SetCellValue(k + 2, sheetNo + "wkdy_flg", formObject.wkdy_flg.value);
    } else {
        sheetObjects[2].SetCellValue(k + 2, sheetNo + "wkdy_flg", "");
    }
    if (formObject.sat_flg.checked == true) {
        sheetObjects[2].SetCellValue(k + 2, sheetNo + "sat_flg", formObject.sat_flg.value);
    } else {
        sheetObjects[2].SetCellValue(k + 2, sheetNo + "sat_flg", "");
    }
    if (formObject.sun_flg.checked == true) {
        sheetObjects[2].SetCellValue(k + 2, sheetNo + "sun_flg", formObject.sun_flg.value);
    } else {
        sheetObjects[2].SetCellValue(k + 2, sheetNo + "sun_flg", "");
    }
    if (formObject.hol_flg.checked == true) {
        sheetObjects[2].SetCellValue(k + 2, sheetNo + "hol_flg", formObject.hol_flg.value);
    } else {
        sheetObjects[2].SetCellValue(k + 2, sheetNo + "hol_flg", "");
    }
    if (formObject.lane_cd.value == "sam") {
        sheetObjects[2].SetCellValue(k + 2, sheetNo + "lane_cd", "Same");
    } else {
        sheetObjects[2].SetCellValue(k + 2, sheetNo + "lane_cd", formObject.lane_cd.value);
    }

    sheetObjects[2].SetCellValue(k + 2, sheetNo + "sub_trd_cd", formObject.sub_trd_cd.value);

    if (getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd') == "N") {
        sheetObjects[2].SetCellValue(k + 2, sheetNo + "dg_none", "Y");
    } else if (getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd') == "A") {
        if (getElementValue(formObject, 'radio', 'dcgo_same') == "Y") {
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "same_dg", "Y");
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n1st_clss_flg", "Y");
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n2nd_clss_flg", "Y");
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n3rd_clss_flg", "Y");
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n4th_clss_flg", "Y");
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n4th_clss_flg", "Y");
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n6th_clss_flg", "Y");
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n7th_clss_flg", "Y");
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n8th_clss_flg", "Y");
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n9th_clss_flg", "Y");
        } else if (getElementValue(formObject, 'radio', 'dcgo_same') == "N") {
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "same_dg_none", "Y");
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "sep_dg_none", "Y");
        }
    } else if (getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd') == "S") {
        if (formObject.dcgo_none_clss_flg.checked == true) {
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "sep_dg_none", "Y");
        } else {
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "sep_dg_none", "");
        }
        if (formObject.dcgo_n1st_clss_flg.checked == true) {
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n1st_clss_flg", "Y");
        } else {
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n1st_clss_flg", "");
        }
        if (formObject.dcgo_n2nd_clss_flg.checked == true) {
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n2nd_clss_flg", "Y");
        } else {
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n2nd_clss_flg", "");
        }
        if (formObject.dcgo_n3rd_clss_flg.checked == true) {
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n3rd_clss_flg", "Y");
        } else {
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n3rd_clss_flg", "");
        }
        if (formObject.dcgo_n4th_clss_flg.checked == true) {
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n4th_clss_flg", "Y");
        } else {
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n4th_clss_flg", "");
        }
        if (formObject.dcgo_n5th_clss_flg.checked == true) {
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n5th_clss_flg", "Y");
        } else {
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n5th_clss_flg", "");
        }
        if (formObject.dcgo_n6th_clss_flg.checked == true) {
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n6th_clss_flg", "Y");
        } else {
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n6th_clss_flg", "");
        }
        if (formObject.dcgo_n7th_clss_flg.checked == true) {
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n7th_clss_flg", "Y");
        } else {
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n7th_clss_flg", "");
        }
        if (formObject.dcgo_n8th_clss_flg.checked == true) {
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n8th_clss_flg", "Y");
        } else {
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n8th_clss_flg", "");
        }
        if (formObject.dcgo_n9th_clss_flg.checked == true) {
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n9th_clss_flg", "Y");
        } else {
            sheetObjects[2].SetCellValue(k + 2, sheetNo + "dcgo_n9th_clss_flg", "");
        }
    }
    if (sheetObjects[0].CheckedRows(0) == "0") {
        sheetObjects[2].SetCellValue(k + 2, sheetNo + "fm_tr_vol_val", "");
        sheetObjects[2].SetCellValue(k + 2, sheetNo + "to_tr_vol_val", "");
    } else {
        sheetObjects[2].SetCellValue(k + 2, sheetNo + "fm_tr_vol_val", sheetObjects[0].GetCellValue(sheet1_parameters[0], 2));
        sheetObjects[2].SetCellValue(k + 2, sheetNo + "to_tr_vol_val", sheetObjects[0].GetCellValue(sheet1_parameters[0], 3));
    }
    //		if(sheetObjects[1].CheckedRows(0) == "0"){
    //			sheetObjects[2].SetCellValue(k+2, sheetNo +"tml_ovt_shft_cd","");
    //		}else{
    //			sheetObjects[2].SetCellValue(k+2, sheetNo +"tml_ovt_shft_cd",sheetObjects[1].GetCellValue(sheet2_parameters[0], 2));
    //		}
    sheetObjects[2].SetCellValue(k + 2, sheetNo + "thc_tp_cd", getElementValue(formObject, 'radio', 'thc_tp_cd'));
    if (formObject.tml_agmt_vol_ut_cd[1].value == "C") {
        if (formObject.cntr_ts[0].checked == true) {
            for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                sheetObjects[2].SetCellValue(k + 2, l, formObject.agmt_rate.value);
            }
        } else if (formObject.cntr_ts[1].checked == true) {
            if (comboObjects[3].GetSelectCode() == "All" && comboObjects[4].GetSelectCode() == "All") {
                for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                    sheetObjects[2].SetCellValue(k + 2, l, formObject.agmt_rate.value);
                }
            }
            if (comboObjects[3].GetSelectCode() == "All" && (comboObjects[4].GetSelectCode() != "" || comboObjects[4].GetSelectCode() != undefined)) {
                var typeName = comboObjects[3].GetSelectCode();
                var sizeName = comboObjects[4].GetSelectCode();
                var cntr_type_list = new Array();
                cntr_type_list[0] = "D";
                cntr_type_list[1] = "R";
                cntr_type_list[2] = "F";
                cntr_type_list[3] = "O";
                cntr_type_list[4] = "S";
                cntr_type_list[5] = "T";
                cntr_type_list[6] = "A";
                cntr_type_list[7] = "P";
                for (var l = 0; l < 8; l++) {
                    sheetObjects[2].SetCellValue(k + 2, "3" + cntr_type_list[l].toLowerCase() + sizeName, formObject.agmt_rate.value);
                    switch ("3" + cntr_type_list[l].toLowerCase() + sizeName) {
                        case "3d2":
                            sheetObjects[2].SetCellValue(k + 2, "3d2", formObject.agmt_rate.value);
                            break;
                        case "3d4":
                            sheetObjects[2].SetCellValue(k + 2, "3d4", formObject.agmt_rate.value);
                            break;
                        case "3d5":
                            sheetObjects[2].SetCellValue(k + 2, "3d5", formObject.agmt_rate.value);
                            break;
                        case "3d7":
                            sheetObjects[2].SetCellValue(k + 2, "3d7", formObject.agmt_rate.value);
                            break;
                        case "3d8":
                            sheetObjects[2].SetCellValue(k + 2, "3d8", formObject.agmt_rate.value);
                            break;
                        case "3d9":
                            sheetObjects[2].SetCellValue(k + 2, "3d9", formObject.agmt_rate.value);
                            break;
                        case "3dw":
                            sheetObjects[2].SetCellValue(k + 2, "3dw", formObject.agmt_rate.value);
                            break;
                        case "3dx":
                            sheetObjects[2].SetCellValue(k + 2, "3dx", formObject.agmt_rate.value);
                            break;
                    }
                }
            }
            if ((comboObjects[3].GetSelectCode() != "" || comboObjects[3].GetSelectCode() != undefined) && comboObjects[4].GetSelectCode() == "All") {
                var typeName = comboObjects[3].GetSelectCode();
                var sizeName = comboObjects[4].GetSelectCode();
                var cntr_size_list = new Array();
                cntr_size_list[0] = "2";
                cntr_size_list[1] = "4";
                cntr_size_list[2] = "5";
                cntr_size_list[3] = "6";
                cntr_size_list[4] = "7";
                cntr_size_list[5] = "8";
                cntr_size_list[6] = "9";
                cntr_size_list[7] = "w";
                cntr_size_list[8] = "x";
                for (var l = 0; l < 9; l++) {
                    sheetObjects[2].SetCellValue(k + 2, "3" + typeName.toLowerCase() + cntr_size_list[l], formObject.agmt_rate.value);
                    switch ("3" + typeName.toLowerCase() + cntr_size_list[l]) {
                        case "3d2":
                            sheetObjects[2].SetCellValue(k + 2, "3d2", formObject.agmt_rate.value);
                            break;
                        case "3d4":
                            sheetObjects[2].SetCellValue(k + 2, "3d4", formObject.agmt_rate.value);
                            break;
                        case "3d5":
                            sheetObjects[2].SetCellValue(k + 2, "3d5", formObject.agmt_rate.value);
                            break;
                        case "3d7":
                            sheetObjects[2].SetCellValue(k + 2, "3d7", formObject.agmt_rate.value);
                            break;
                        case "3d8":
                            sheetObjects[2].SetCellValue(k + 2, "3d8", formObject.agmt_rate.value);
                            break;
                        case "3d9":
                            sheetObjects[2].SetCellValue(k + 2, "3d9", formObject.agmt_rate.value);
                            break;
                        case "3dw":
                            sheetObjects[2].SetCellValue(k + 2, "3dw", formObject.agmt_rate.value);
                            break;
                        case "3dx":
                            sheetObjects[2].SetCellValue(k + 2, "3dx", formObject.agmt_rate.value);
                            break;
                    }
                }
            }
            if ((formObject.cntr_type_t.value != "" && formObject.cntr_type_t.value != undefined) && (formObject.cntr_size_t.value == "" || formObject.cntr_size_t.value == undefined)) {
                var typeName = formObject.cntr_type_t.value;
                switch (typeName) {
                    case "D":
                        for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                            if (l < 40 + gap_tm) {
                                sheetObjects[2].SetCellValue(k + 2, l, formObject.agmt_rate.value);
                            } else {
                                sheetObjects[2].SetCellValue(k + 2, l, 0);
                            }
                        }
                        break;
                    case "R":
                        for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                            if (l > 39 + gap_tm && l < 44 + gap_tm) {
                                sheetObjects[2].SetCellValue(k + 2, l, formObject.agmt_rate.value);
                            } else {
                                sheetObjects[2].SetCellValue(k + 2, l, 0);
                            }
                        }
                        break;
                    case "F":
                        for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                            if (l > 43 + gap_tm && l < 47 + gap_tm) {
                                sheetObjects[2].SetCellValue(k + 2, l, formObject.agmt_rate.value);
                            } else {
                                sheetObjects[2].SetCellValue(k + 2, l, 0);
                            }
                        }
                        //sheetObjects[2].CellValue(k+2, 55)=formObject.agmt_rate.value;																
                        break;
                    case "O":
                        for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                            if (l > 46 + gap_tm && l < 49 + gap_tm) {
                                sheetObjects[2].SetCellValue(k + 2, l, formObject.agmt_rate.value);
                            } else {
                                sheetObjects[2].SetCellValue(k + 2, l, 0);
                            }
                        }
                        break;
                    case "S":
                        for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                            if (l > 48 + gap_tm && l < 51 + gap_tm) {
                                sheetObjects[2].SetCellValue(k + 2, l, formObject.agmt_rate.value);
                            } else {
                                sheetObjects[2].SetCellValue(k + 2, l, 0);
                            }
                        }
                        break;
                    case "T":
                        for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                            if (l > 50 + gap_tm && l < 53 + gap_tm) {
                                sheetObjects[2].SetCellValue(k + 2, l, formObject.agmt_rate.value);
                            } else {
                                sheetObjects[2].SetCellValue(k + 2, l, 0);
                            }
                        }
                        break;
                    case "A":
                        for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                            if (l > 52 + gap_tm && l < 55 + gap_tm) {
                                sheetObjects[2].SetCellValue(k + 2, l, formObject.agmt_rate.value);
                            } else {
                                sheetObjects[2].SetCellValue(k + 2, l, 0);
                            }
                        }
                        break;
                    case "P":
                        for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                            if (l > 53 + gap_tm && l < 56 + gap_tm) {
                                sheetObjects[2].SetCellValue(k + 2, l, formObject.agmt_rate.value);
                            } else {
                                sheetObjects[2].SetCellValue(k + 2, l, 0);
                            }
                        }
                        break;
                }
            } else if ((formObject.cntr_type_t.value == "" || formObject.cntr_type_t.value == undefined) && (formObject.cntr_size_t.value != "" && formObject.cntr_size_t.value != undefined)) {
                switch (formObject.cntr_size_t.value) {
                    case "2":
                        for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                            sheetObjects[2].SetCellValue(k + 2, l, 0);
                        }
                        sheetObjects[2].SetCellValue(k + 2, 32 + gap_tm, formObject.agmt_rate.value);
                        sheetObjects[2].SetCellValue(k + 2, 40 + gap_tm, formObject.agmt_rate.value);
                        sheetObjects[2].SetCellValue(k + 2, 44 + gap_tm, formObject.agmt_rate.value);
                        sheetObjects[2].SetCellValue(k + 2, 46 + gap_tm, formObject.agmt_rate.value);
                        sheetObjects[2].SetCellValue(k + 2, 48 + gap_tm, formObject.agmt_rate.value);
                        sheetObjects[2].SetCellValue(k + 2, 50 + gap_tm, formObject.agmt_rate.value);
                        sheetObjects[2].SetCellValue(k + 2, 52 + gap_tm, formObject.agmt_rate.value);
                        sheetObjects[2].SetCellValue(k + 2, 54 + gap_tm, formObject.agmt_rate.value);
                        break;
                    case "4":
                        for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                            sheetObjects[2].SetCellValue(k + 2, l, 0);
                        }
                        sheetObjects[2].SetCellValue(k + 2, 33 + gap_tm, formObject.agmt_rate.value);
                        sheetObjects[2].SetCellValue(k + 2, 41 + gap_tm, formObject.agmt_rate.value);
                        sheetObjects[2].SetCellValue(k + 2, 45 + gap_tm, formObject.agmt_rate.value);
                        sheetObjects[2].SetCellValue(k + 2, 47 + gap_tm, formObject.agmt_rate.value);
                        sheetObjects[2].SetCellValue(k + 2, 49 + gap_tm, formObject.agmt_rate.value);
                        sheetObjects[2].SetCellValue(k + 2, 51 + gap_tm, formObject.agmt_rate.value);
                        sheetObjects[2].SetCellValue(k + 2, 53 + gap_tm, formObject.agmt_rate.value);
                        sheetObjects[2].SetCellValue(k + 2, 55 + gap_tm, formObject.agmt_rate.value);
                        break;
                    case "5":
                        for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                            sheetObjects[2].SetCellValue(k + 2, l, 0);
                        }
                        sheetObjects[2].SetCellValue(k + 2, 34 + gap_tm, formObject.agmt_rate.value);
                        sheetObjects[2].SetCellValue(k + 2, 42 + gap_tm, formObject.agmt_rate.value);
                        sheetObjects[2].SetCellValue(k + 2, 46 + gap_tm, formObject.agmt_rate.value);
                        break;
                    case "7":
                        for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                            sheetObjects[2].SetCellValue(k + 2, l, 0);
                        }
                        sheetObjects[2].SetCellValue(k + 2, 35 + gap_tm, formObject.agmt_rate.value);
                        sheetObjects[2].SetCellValue(k + 2, 43 + gap_tm, formObject.agmt_rate.value);
                        break;
                    case "8":
                        for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                            sheetObjects[2].SetCellValue(k + 2, l, 0);
                        }
                        sheetObjects[2].SetCellValue(k + 2, 36 + gap_tm, formObject.agmt_rate.value);
                        break;
                    case "9":
                        for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                            sheetObjects[2].SetCellValue(k + 2, l, 0);
                        }
                        sheetObjects[2].SetCellValue(k + 2, 37 + gap_tm, formObject.agmt_rate.value);
                        break;
                    case "W":
                        for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                            sheetObjects[2].SetCellValue(k + 2, l, 0);
                        }
                        sheetObjects[2].SetCellValue(k + 2, 38 + gap_tm, formObject.agmt_rate.value);
                        break;
                    case "X":
                        for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                            sheetObjects[2].SetCellValue(k + 2, l, 0);
                        }
                        sheetObjects[2].SetCellValue(k + 2, 39 + gap_tm, formObject.agmt_rate.value);
                        break;
                }
            } else if ((formObject.cntr_type_t.value != "" && formObject.cntr_type_t.value != undefined) && (formObject.cntr_size_t.value != "" && formObject.cntr_size_t.value != undefined)) {
                var typeName = comboObjects[3].GetSelectCode();
                var sizeName = comboObjects[4].GetSelectCode();
                cntrTypeSize = typeName + sizeName;
                switch ("3" + typeName.toLowerCase() + sizeName) {
                    case "3d2":
                        sheetObjects[2].SetCellValue(k + 2, "3d2", formObject.agmt_rate.value);
                        break;
                    case "3d4":
                        sheetObjects[2].SetCellValue(k + 2, "3d4", formObject.agmt_rate.value);
                        break;
                    case "3d5":
                        sheetObjects[2].SetCellValue(k + 2, "3d5", formObject.agmt_rate.value);
                        break;
                    case "3d7":
                        sheetObjects[2].SetCellValue(k + 2, "3d7", formObject.agmt_rate.value);
                        break;
                    case "3d8":
                        sheetObjects[2].SetCellValue(k + 2, "3d8", formObject.agmt_rate.value);
                        break;
                    case "3d9":
                        sheetObjects[2].SetCellValue(k + 2, "3d9", formObject.agmt_rate.value);
                        break;
                    case "3dw":
                        sheetObjects[2].SetCellValue(k + 2, "3dw", formObject.agmt_rate.value);
                        break;
                    case "3dx":
                        sheetObjects[2].SetCellValue(k + 2, "3dx", formObject.agmt_rate.value);
                        break;
                }
                sheetObjects[2].SetCellValue(k + 2, "3" + cntrTypeSize.toLowerCase(), formObject.agmt_rate.value);
            }
        }
    }
    if (formObject.tml_agmt_vol_ut_cd[1].value == "T") {
        sheetObjects[2].SetCellValue(k + 2, 57 + gap_tm, formObject.agmt_rate.value);
    } else {
        sheetObjects[2].SetCellValue(k + 2, 57 + gap_tm, "");
    }
    if (formObject.tml_agmt_vol_ut_cd[1].value == "U") {
        sheetObjects[2].SetCellValue(k + 2, 58 + gap_tm, formObject.agmt_rate.value);
    } else {
        sheetObjects[2].SetCellValue(k + 2, 58 + gap_tm, "");
    }
    if (formObject.tml_agmt_vol_ut_cd[1].value == "M") {
        sheetObjects[2].SetCellValue(k + 2, 59 + gap_tm, formObject.agmt_rate.value);
    } else {
        sheetObjects[2].SetCellValue(k + 2, 59 + gap_tm, "");
    }
    if (formObject.tml_agmt_vol_ut_cd[1].value == "G") {
        sheetObjects[2].SetCellValue(k + 2, 60 + gap_tm, formObject.agmt_rate.value);
    } else {
        sheetObjects[2].SetCellValue(k + 2, 60 + gap_tm, "");
    }
    sheetObjects[2].SetCellValue(k + 2, 61 + gap_tm, "");
    sheetObjects[2].SetCellValue(k + 2, 62 + gap_tm, "");
    sheetObjects[2].SetCellValue(k + 2, 63 + gap_tm, getElementValue(formObject, 'radio', 'tml_dy_aply_tp_cd'));
    sheetObjects[2].SetCellValue(k + 2, 64 + gap_tm, getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd'));
    if (sheetObjects[0].CheckedRows(0) == "1" || sheetObjects[0].GetCellValue(sheet1_parameters[1], 2) == "1" || sheetObjects[0].GetCellValue(sheet1_parameters[1], 3) == "MAX") {
        sheetObjects[2].SetCellValue(k + 2, 65 + gap_tm, "N");
    } else {
        sheetObjects[2].SetCellValue(k + 2, 66 + gap_tm, "S");
    }
    sheetObjects[2].SetCellValue(k + 2, 67 + gap_tm, document.form.vfsArray.value);
    eq_flg = sheetObjects[2].ColValueDup("1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61");
    comp_flg = sheetObjects[2].ColValueDup("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33");

    if (eq_flg == -1 && comp_flg == -1) {
        sheetObjects[2].SetRowStatus(k + 2, "I");
        k++;
        //break;
    } else if (eq_flg == -1 && comp_flg > -1) {
        terminalRateInputListComparison(k + 2);
    } else {
        sheetObjects[2].RowDelete(k + 2, false);
        ComShowCodeMessage('TES10117'); // There is sane condition rate.\n\n Please check the Agreement
    }
    //span_kkk1.innerHTML = "<table border=1 cellspacing=0 cellpadding=0>"+str+"</table>";
}
/**
 * Agreement Storage Rate Input > Rate List
 * @return
 */
function storageRateInputList() {
    var formObject = document.form;
    var k = sheetObjects[4].RowCount() + 1;
    var loop1 = sheetObjects[3].CheckedRows(0);
    if (loop1 == 0) {
        loop1 = 1;
    }
    if (formObject.tml_sto_agmt_tp_cd.value == "FP") {
        loop1 = 1;
    }
    var sheet1_parameters = new Array();
    sheet1_parameters = sheetObjects[3].FindCheckedRow(0) + "|".split("|");

    if (formObject.tml_sto_agmt_tp_cd.value == "FD") {
        //sheetObjects[2].RemoveAll();
        for (var i = 1; i <= loop1; i++) {
            sheetObjects[4].DataInsert(-1);
            sheetObjects[4].SetCellValue(k + 2, 0, "");
            sheetObjects[4].SetCellValue(k + 2, 1, "");
            sheetObjects[4].SetCellValue(k + 2, 2, formObject.lgs_cost_cd_s.value); //GetSelectCode()
            sheetObjects[4].SetCellValue(k + 2, 3, formObject.sto_tml_cntr_sty_cd.value); //F/M
            sheetObjects[4].SetCellValue(k + 2, 3 + gap_st, formObject.tml_agmt_vol_ut_cd[2].value);
            sheetObjects[4].SetCellValue(k + 2, 4 + gap_st, formObject.curr_cd_s.value);
            sheetObjects[4].SetCellValue(k + 2, 5 + gap_st, formObject.tml_sto_agmt_tp_cd.value);
            sheetObjects[4].SetCellValue(k + 2, 6 + gap_st, formObject.cmnc_hrmnt.value);
            if (formObject.storage_gb[0].checked == true) {
                sheetObjects[4].SetCellValue(k + 2, 7 + gap_st, "F");
                sheetObjects[4].SetCellValue(k + 2, 8 + gap_st, formObject.io_bnd_cd[2].value);
            } else if (formObject.storage_gb[1].checked == true) {
                sheetObjects[4].SetCellValue(k + 2, 7 + gap_st, "");
                sheetObjects[4].SetCellValue(k + 2, 8 + gap_st, formObject.io_bnd_cd[3].value);
            }
            if (getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_FD') == "N") {
                sheetObjects[4].SetCellValue(k + 2, 9 + gap_st, "Y");
            } else if (getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_FD') == "A") {
                if (getElementValue(formObject, 'radio', 'dcgo_same_FD') == "Y") {
                    sheetObjects[4].SetCellValue(k + 2, 11 + gap_st, "Y");
                    sheetObjects[4].SetCellValue(k + 2, 13 + gap_st, "Y");
                    sheetObjects[4].SetCellValue(k + 2, 14 + gap_st, "Y");
                    sheetObjects[4].SetCellValue(k + 2, 15 + gap_st, "Y");
                    sheetObjects[4].SetCellValue(k + 2, 16 + gap_st, "Y");
                    sheetObjects[4].SetCellValue(k + 2, 17 + gap_st, "Y");
                    sheetObjects[4].SetCellValue(k + 2, 18 + gap_st, "Y");
                    sheetObjects[4].SetCellValue(k + 2, 19 + gap_st, "Y");
                    sheetObjects[4].SetCellValue(k + 2, 20 + gap_st, "Y");
                    sheetObjects[4].SetCellValue(k + 2, 21 + gap_st, "Y");
                } else if (getElementValue(formObject, 'radio', 'dcgo_same_FD') == "N") {
                    sheetObjects[4].SetCellValue(k + 2, 10 + gap_st, "Y");
                    sheetObjects[4].SetCellValue(k + 2, 12 + gap_st, "Y");
                }
            } else if (getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_FD') == "S") {
                if (formObject.dcgo_none_clss_flg_FD.checked == true) {
                    sheetObjects[4].SetCellValue(k + 2, 12 + gap_st, "Y");
                } else {
                    sheetObjects[4].SetCellValue(k + 2, 12 + gap_st, "");
                }
                if (formObject.dcgo_n1st_clss_flg_FD.checked == true) {
                    sheetObjects[4].SetCellValue(k + 2, 13 + gap_st, "Y");
                } else {
                    sheetObjects[4].SetCellValue(k + 2, 13 + gap_st, "");
                }
                if (formObject.dcgo_n2nd_clss_flg_FD.checked == true) {
                    sheetObjects[4].SetCellValue(k + 2, 14 + gap_st, "Y");
                } else {
                    sheetObjects[4].SetCellValue(k + 2, 14 + gap_st, "");
                }
                if (formObject.dcgo_n3rd_clss_flg_FD.checked == true) {
                    sheetObjects[4].SetCellValue(k + 2, 15 + gap_st, "Y");
                } else {
                    sheetObjects[4].SetCellValue(k + 2, 15 + gap_st, "");
                }
                if (formObject.dcgo_n4th_clss_flg_FD.checked == true) {
                    sheetObjects[4].SetCellValue(k + 2, 16 + gap_st, "Y");
                } else {
                    sheetObjects[4].SetCellValue(k + 2, 16 + gap_st, "");
                }
                if (formObject.dcgo_n5th_clss_flg_FD.checked == true) {
                    sheetObjects[4].SetCellValue(k + 2, 17 + gap_st, "Y");
                } else {
                    sheetObjects[4].SetCellValue(k + 2, 17 + gap_st, "");
                }
                if (formObject.dcgo_n6th_clss_flg_FD.checked == true) {
                    sheetObjects[4].SetCellValue(k + 2, 18 + gap_st, "Y");
                } else {
                    sheetObjects[4].SetCellValue(k + 2, 18 + gap_st, "");
                }
                if (formObject.dcgo_n7th_clss_flg_FD.checked == true) {
                    sheetObjects[4].SetCellValue(k + 2, 19 + gap_st, "Y");
                } else {
                    sheetObjects[4].SetCellValue(k + 2, 19 + gap_st, "");
                }
                if (formObject.dcgo_n8th_clss_flg_FD.checked == true) {
                    sheetObjects[4].SetCellValue(k + 2, 20 + gap_st, "Y");
                } else {
                    sheetObjects[4].SetCellValue(k + 2, 20 + gap_st, "");
                }
                if (formObject.dcgo_n9th_clss_flg_FD.checked == true) {
                    sheetObjects[4].SetCellValue(k + 2, 21 + gap_st, "Y");
                } else {
                    sheetObjects[4].SetCellValue(k + 2, 21 + gap_st, "");
                }
            }
            if (formObject.sat_flg_FD.checked == true) {
                sheetObjects[4].SetCellValue(k + 2, 22 + gap_st, formObject.sat_flg_FD.value);
            } else {
                sheetObjects[4].SetCellValue(k + 2, 22 + gap_st, "");
            }
            if (formObject.sun_flg_FD.checked == true) {
                sheetObjects[4].SetCellValue(k + 2, 23 + gap_st, formObject.sun_flg_FD.value);
            } else {
                sheetObjects[4].SetCellValue(k + 2, 23 + gap_st, "");
            }
            if (formObject.hol_flg_FD.checked == true) {
                sheetObjects[4].SetCellValue(k + 2, 24 + gap_st, formObject.hol_flg_FD.value);
            } else {
                sheetObjects[4].SetCellValue(k + 2, 24 + gap_st, "");
            }
            if (getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_R') == "N") {
                sheetObjects[4].SetCellValue(k + 2, 25 + gap_st, "Y");
            } else if (getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_R') == "A") {
                if (getElementValue(formObject, 'radio', 'dcgo_same_R') == "Y") {
                    sheetObjects[4].SetCellValue(k + 2, 27 + gap_st, "Y");
                    sheetObjects[4].SetCellValue(k + 2, 29 + gap_st, "Y");
                    sheetObjects[4].SetCellValue(k + 2, 30 + gap_st, "Y");
                    sheetObjects[4].SetCellValue(k + 2, 31 + gap_st, "Y");
                    sheetObjects[4].SetCellValue(k + 2, 32 + gap_st, "Y");
                    sheetObjects[4].SetCellValue(k + 2, 33 + gap_st, "Y");
                    sheetObjects[4].SetCellValue(k + 2, 34 + gap_st, "Y");
                    sheetObjects[4].SetCellValue(k + 2, 35 + gap_st, "Y");
                    sheetObjects[4].SetCellValue(k + 2, 36 + gap_st, "Y");
                    sheetObjects[4].SetCellValue(k + 2, 37 + gap_st, "Y");
                } else if (getElementValue(formObject, 'radio', 'dcgo_same_R') == "N") {
                    sheetObjects[4].SetCellValue(k + 2, 26 + gap_st, "Y");
                    sheetObjects[4].SetCellValue(k + 2, 28 + gap_st, "Y");
                }
            } else if (getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_R') == "S") {
                if (formObject.dcgo_none_clss_flg_R.checked == true) {
                    sheetObjects[4].SetCellValue(k + 2, 28 + gap_st, "Y");
                } else {
                    sheetObjects[4].SetCellValue(k + 2, 28 + gap_st, "");
                }
                if (formObject.dcgo_n1st_clss_flg_R.checked == true) {
                    sheetObjects[4].SetCellValue(k + 2, 29 + gap_st, "Y");
                } else {
                    sheetObjects[4].SetCellValue(k + 2, 29 + gap_st, "");
                }
                if (formObject.dcgo_n2nd_clss_flg_R.checked == true) {
                    sheetObjects[4].SetCellValue(k + 2, 30 + gap_st, "Y");
                } else {
                    sheetObjects[4].SetCellValue(k + 2, 30 + gap_st, "");
                }
                if (formObject.dcgo_n3rd_clss_flg_R.checked == true) {
                    sheetObjects[4].SetCellValue(k + 2, 31 + gap_st, "Y");
                } else {
                    sheetObjects[4].SetCellValue(k + 2, 31 + gap_st, "");
                }
                if (formObject.dcgo_n4th_clss_flg_R.checked == true) {
                    sheetObjects[4].SetCellValue(k + 2, 32 + gap_st, "Y");
                } else {
                    sheetObjects[4].SetCellValue(k + 2, 32 + gap_st, "");
                }
                if (formObject.dcgo_n5th_clss_flg_R.checked == true) {
                    sheetObjects[4].SetCellValue(k + 2, 33 + gap_st, "Y");
                } else {
                    sheetObjects[4].SetCellValue(k + 2, 33 + gap_st, "");
                }
                if (formObject.dcgo_n6th_clss_flg_R.checked == true) {
                    sheetObjects[4].SetCellValue(k + 2, 34 + gap_st, "Y");
                } else {
                    sheetObjects[4].SetCellValue(k + 2, 34 + gap_st, "");
                }
                if (formObject.dcgo_n7th_clss_flg_R.checked == true) {
                    sheetObjects[4].SetCellValue(k + 2, 35 + gap_st, "Y");
                } else {
                    sheetObjects[4].SetCellValue(k + 2, 35 + gap_st, "");
                }
                if (formObject.dcgo_n8th_clss_flg_R.checked == true) {
                    sheetObjects[4].SetCellValue(k + 2, 36 + gap_st, "Y");
                } else {
                    sheetObjects[4].SetCellValue(k + 2, 36 + gap_st, "");
                }
                if (formObject.dcgo_n9th_clss_flg_R.checked == true) {
                    sheetObjects[4].SetCellValue(k + 2, 37 + gap_st, "Y");
                } else {
                    sheetObjects[4].SetCellValue(k + 2, 37 + gap_st, "");
                }
            }
            if (formObject.storage_gb[0].checked == true) {
                sheetObjects[4].SetCellValue(k + 2, 38 + gap_st, "");
                sheetObjects[4].SetCellValue(k + 2, 39 + gap_st, "");
            } else if (formObject.storage_gb[1].checked == true) {
                //if(sheetObjects[3].RowCount >0){
                sheetObjects[4].SetCellValue(k + 2, 38 + gap_st, sheetObjects[3].GetCellValue(sheet1_parameters[i - 1], 2));
                sheetObjects[4].SetCellValue(k + 2, 39 + gap_st, sheetObjects[3].GetCellValue(sheet1_parameters[i - 1], 3));
                //}
            }
            sheetObjects[4].SetCellValue(k + 2, 40 + gap_st, formObject.fp_teu_qty.value);
            if (formObject.storage_gb[0].checked == true) {
                if (formObject.tml_agmt_vol_ut_cd[2].value == "U" || formObject.tml_agmt_vol_ut_cd[2].value == "M") {
                    for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                        sheetObjects[4].SetCellValue(k + 2, l, formObject.ft_dys.value);
                    }
                }
                //if(formObject.tml_agmt_vol_ut_cd[2].value=="C"){
                if (formObject.cntr_ts[2].checked == true) {
                    for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                        sheetObjects[4].SetCellValue(k + 2, l, formObject.ft_dys.value);
                    }
                } else if (formObject.cntr_ts[3].checked == true) {
                    if (comboObjects[7].GetSelectCode() == "All" && comboObjects[8].GetSelectCode() == "All") {
                        for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                            sheetObjects[4].SetCellValue(k + 2, l, formObject.ft_dys.value);
                        }
                    }
                    if (comboObjects[7].GetSelectCode() == "All" && (comboObjects[8].GetSelectCode() != "" || comboObjects[8].GetSelectCode() != undefined)) {
                        var typeName = comboObjects[7].GetSelectCode();
                        var sizeName = comboObjects[8].GetSelectCode();
                        var cntr_type_list = new Array();
                        cntr_type_list[0] = "D";
                        cntr_type_list[1] = "R";
                        cntr_type_list[2] = "F";
                        cntr_type_list[3] = "O";
                        cntr_type_list[4] = "S";
                        cntr_type_list[5] = "T";
                        cntr_type_list[6] = "A";
                        cntr_type_list[7] = "P";
                        for (var l = 0; l < 8; l++) {
                            sheetObjects[4].SetCellValue(k + 2, "5" + cntr_type_list[l].toLowerCase() + sizeName + "_fd", formObject.ft_dys.value);
                        }
                    }
                    if ((comboObjects[7].GetSelectCode() != "" || comboObjects[8].GetSelectCode() != undefined) && comboObjects[8].GetSelectCode() == "All") {
                        var typeName = comboObjects[7].GetSelectCode();
                        var sizeName = comboObjects[8].GetSelectCode();
                        var cntr_size_list = new Array();
                        cntr_size_list[0] = "2";
                        cntr_size_list[1] = "4";
                        cntr_size_list[2] = "5";
                        cntr_size_list[3] = "6";
                        cntr_size_list[4] = "7";
                        cntr_size_list[5] = "8";
                        cntr_size_list[6] = "9";
                        cntr_size_list[7] = "w";
                        cntr_size_list[8] = "x";
                        for (var l = 0; l < 9; l++) {
                            sheetObjects[4].SetCellValue(k + 2, "5" + typeName.toLowerCase() + cntr_size_list[l] + "_fd", formObject.ft_dys.value);
                        }
                    }
                    if ((formObject.cntr_type_s.value != "" && formObject.cntr_type_s.value != undefined) && (formObject.cntr_size_s.value == "" || formObject.cntr_size_s.value == undefined)) {
                        var typeName = formObject.cntr_type_s.value;
                        switch (typeName) {
                            case "D":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    if (l < 50 + gap_st) {
                                        sheetObjects[4].SetCellValue(k + 2, l, formObject.ft_dys.value);
                                    } else {
                                        sheetObjects[4].SetCellValue(k + 2, l, 0);
                                    }
                                }
                                break;
                            case "R":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    if (l > 49 + gap_st && l < 54 + gap_st) {
                                        sheetObjects[4].SetCellValue(k + 2, l, formObject.ft_dys.value);
                                    } else {
                                        sheetObjects[4].SetCellValue(k + 2, l, 0);
                                    }
                                }
                                break;
                            case "F":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    if (l > 53 + gap_st && l < 57 + gap_st) {
                                        sheetObjects[4].SetCellValue(k + 2, l, formObject.ft_dys.value);
                                    } else {
                                        sheetObjects[4].SetCellValue(k + 2, l, 0);
                                    }
                                }
                                sheetObjects[4].SetCellValue(k + 2, 65 + gap_st, formObject.ft_dys.value);
                                break;
                            case "O":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    if (l > 56 + gap_st && l < 59 + gap_st) {
                                        sheetObjects[4].SetCellValue(k + 2, l, formObject.ft_dys.value);
                                    } else {
                                        sheetObjects[4].SetCellValue(k + 2, l, 0);
                                    }
                                }
                                break;
                            case "S":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    if (l > 58 + gap_st && l < 61 + gap_st) {
                                        sheetObjects[4].SetCellValue(k + 2, l, formObject.ft_dys.value);
                                    } else {
                                        sheetObjects[4].SetCellValue(k + 2, l, 0);
                                    }
                                }
                                break;
                            case "T":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    if (l > 60 + gap_st && l < 63 + gap_st) {
                                        sheetObjects[4].SetCellValue(k + 2, l, formObject.ft_dys.value);
                                    } else {
                                        sheetObjects[4].SetCellValue(k + 2, l, 0);
                                    }
                                }
                                break;
                            case "A":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    if (l > 62 + gap_st && l < 65 + gap_st) {
                                        sheetObjects[4].SetCellValue(k + 2, l, formObject.ft_dys.value);
                                    } else {
                                        sheetObjects[4].SetCellValue(k + 2, l, 0);
                                    }
                                }
                                break;
                            case "P":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    if (l > 64 + gap_st && l < 67 + gap_st) {
                                        sheetObjects[4].SetCellValue(k + 2, l, formObject.ft_dys.value);
                                    } else {
                                        sheetObjects[4].SetCellValue(k + 2, l, 0);
                                    }
                                }
                                break;
                        }
                        //}else if(formObject.cntr_size[1].value!=""){
                    } else if ((formObject.cntr_type_s.value == "" || formObject.cntr_type_s.value == undefined) && (formObject.cntr_size_s.value != "" && formObject.cntr_size_s.value != undefined)) {
                        switch (formObject.cntr_size_s.value) {
                            case "2":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    sheetObjects[4].SetCellValue(k + 2, l, 0);
                                }
                                sheetObjects[4].SetCellValue(k + 2, 42 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(k + 2, 50 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(k + 2, 54 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(k + 2, 57 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(k + 2, 59 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(k + 2, 61 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(k + 2, 63 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(k + 2, 65 + gap_st, formObject.ft_dys.value);
                                break;
                            case "4":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    sheetObjects[4].SetCellValue(k + 2, l, 0);
                                }
                                sheetObjects[4].SetCellValue(k + 2, 43 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(k + 2, 51 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(k + 2, 55 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(k + 2, 58 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(k + 2, 60 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(k + 2, 62 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(k + 2, 64 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(k + 2, 66 + gap_st, formObject.ft_dys.value);
                                break;
                            case "5":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    sheetObjects[4].SetCellValue(k + 2, l, 0);
                                }
                                sheetObjects[4].SetCellValue(k + 2, 44 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(k + 2, 52 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(k + 2, 56 + gap_st, formObject.ft_dys.value);
                                break;
                            case "7":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    sheetObjects[4].SetCellValue(k + 2, l, 0);
                                }
                                sheetObjects[4].SetCellValue(k + 2, 45 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(k + 2, 53 + gap_st, formObject.ft_dys.value);
                                break;
                            case "8":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    sheetObjects[4].SetCellValue(k + 2, l, 0);
                                }
                                sheetObjects[4].SetCellValue(k + 2, 46 + gap_st, formObject.ft_dys.value);
                                break;
                            case "9":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    sheetObjects[4].SetCellValue(k + 2, l, 0);
                                }
                                sheetObjects[4].SetCellValue(k + 2, 47 + gap_st, formObject.ft_dys.value);
                                break;
                            case "W":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    sheetObjects[4].SetCellValue(k + 2, l, 0);
                                }
                                sheetObjects[4].SetCellValue(k + 2, 48 + gap_st, formObject.ft_dys.value);
                                break;
                            case "X":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    sheetObjects[4].SetCellValue(k + 2, l, 0);
                                }
                                sheetObjects[4].SetCellValue(k + 2, 49 + gap_st, formObject.ft_dys.value);
                                break;
                        }
                    } else if ((formObject.cntr_type_s.value != "" && formObject.cntr_type_s.value != undefined) && (formObject.cntr_size_s.value != "" && formObject.cntr_size_s.value != undefined)) {
                        var typeName = comboObjects[7].GetSelectCode();
                        var sizeName = comboObjects[8].GetSelectCode();
                        cntrTypeSize = typeName + sizeName;
                        sheetObjects[4].SetCellValue(k + 2, "5" + cntrTypeSize.toLowerCase() + "_fd", formObject.ft_dys.value);
                    }
                }
                //}
            }
            if (formObject.storage_gb[1].checked == true) {
                if (formObject.tml_agmt_vol_ut_cd[2].value == "C") {
                    if (formObject.cntr_ts[2].checked == true) {
                        for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                            sheetObjects[4].SetCellValue(k + 2, l, formObject.agmt_ut_rt.value);
                        }
                    } else if (formObject.cntr_ts[3].checked == true) {
                        if (comboObjects[7].GetSelectCode() == "All" && comboObjects[8].GetSelectCode() == "All") {
                            for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                sheetObjects[4].SetCellValue(k + 2, l, formObject.agmt_ut_rt.value);
                            }
                        }
                        if (comboObjects[7].GetSelectCode() == "All" && (comboObjects[8].GetSelectCode() != "" || comboObjects[8].GetSelectCode() != undefined)) {
                            var typeName = comboObjects[7].GetSelectCode();
                            var sizeName = comboObjects[8].GetSelectCode();
                            var cntr_type_list = new Array();
                            cntr_type_list[0] = "D";
                            cntr_type_list[1] = "R";
                            cntr_type_list[2] = "F";
                            cntr_type_list[3] = "O";
                            cntr_type_list[4] = "S";
                            cntr_type_list[5] = "T";
                            cntr_type_list[6] = "A";
                            cntr_type_list[7] = "P";
                            for (var l = 0; l < 8; l++) {
                                sheetObjects[4].SetCellValue(k + 2, "5" + cntr_type_list[l].toLowerCase() + sizeName + "_r", formObject.agmt_ut_rt.value);
                            }
                        }
                        if ((comboObjects[7].GetSelectCode() != "" || comboObjects[8].GetSelectCode() != undefined) && comboObjects[8].GetSelectCode() == "All") {
                            var typeName = comboObjects[7].GetSelectCode();
                            var sizeName = comboObjects[8].GetSelectCode();
                            var cntr_size_list = new Array();
                            cntr_size_list[0] = "2";
                            cntr_size_list[1] = "4";
                            cntr_size_list[2] = "5";
                            cntr_size_list[3] = "6";
                            cntr_size_list[4] = "7";
                            cntr_size_list[5] = "8";
                            cntr_size_list[6] = "9";
                            cntr_size_list[7] = "w";
                            cntr_size_list[8] = "x";
                            for (var l = 0; l < 9; l++) {
                                sheetObjects[4].SetCellValue(k + 2, "5" + typeName.toLowerCase() + cntr_size_list[l] + "_r", formObject.agmt_ut_rt.value);
                            }
                        }
                        if (formObject.cntr_type_s.value != "" && formObject.cntr_size_s.value == "") {
                            var typeName = formObject.cntr_type_s.value;
                            switch (typeName) {
                                case "D":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        if (l < 75 + gap_st) {
                                            sheetObjects[4].SetCellValue(k + 2, l, formObject.agmt_ut_rt.value);
                                        } else {
                                            sheetObjects[4].SetCellValue(k + 2, l, 0);
                                        }
                                    }
                                    break;
                                case "R":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        if (l > 74 + gap_st && l < 79 + gap_st) {
                                            sheetObjects[4].SetCellValue(k + 2, l, formObject.agmt_ut_rt.value);
                                        } else {
                                            sheetObjects[4].SetCellValue(k + 2, l, 0);
                                        }
                                    }
                                    break;
                                case "F":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        if (l > 78 + gap_st && l < 82 + gap_st) {
                                            sheetObjects[4].SetCellValue(k + 2, l, formObject.agmt_ut_rt.value);
                                        } else {
                                            sheetObjects[4].SetCellValue(k + 2, l, 0);
                                        }
                                    }
                                    sheetObjects[4].SetCellValue(k + 2, 90 + gap_st, formObject.agmt_ut_rt.value);
                                    break;
                                case "O":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        if (l > 81 + gap_st && l < 84 + gap_st) {
                                            sheetObjects[4].SetCellValue(k + 2, l, formObject.agmt_ut_rt.value);
                                        } else {
                                            sheetObjects[4].SetCellValue(k + 2, l, 0);
                                        }
                                    }
                                    break;
                                case "S":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        if (l > 83 + gap_st && l < 86 + gap_st) {
                                            sheetObjects[4].SetCellValue(k + 2, l, formObject.agmt_ut_rt.value);
                                        } else {
                                            sheetObjects[4].SetCellValue(k + 2, l, 0);
                                        }
                                    }
                                    break;
                                case "T":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        if (l > 85 + gap_st && l < 88 + gap_st) {
                                            sheetObjects[4].SetCellValue(k + 2, l, formObject.agmt_ut_rt.value);
                                        } else {
                                            sheetObjects[4].SetCellValue(k + 2, l, 0);
                                        }
                                    }
                                    break;
                                case "A":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        if (l > 87 + gap_st && l < 90 + gap_st) {
                                            sheetObjects[4].SetCellValue(k + 2, l, formObject.agmt_ut_rt.value);
                                        } else {
                                            sheetObjects[4].SetCellValue(k + 2, l, 0);
                                        }
                                    }
                                    break;
                                case "P":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        if (l > 89 + gap_st && l < 92 + gap_st) {
                                            sheetObjects[4].SetCellValue(k + 2, l, formObject.agmt_ut_rt.value);
                                        } else {
                                            sheetObjects[4].SetCellValue(k + 2, l, 0);
                                        }
                                    }
                                    break;
                            }
                            //}else if(formObject.cntr_size[1].value!=""){
                        } else if (formObject.cntr_type_s.value == "" && formObject.cntr_size_s.value != "") {
                            switch (formObject.cntr_size_s.value) {
                                case "2":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        sheetObjects[4].SetCellValue(k + 2, l, 0);
                                    }
                                    sheetObjects[4].SetCellValue(k + 2, 67 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(k + 2, 75 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(k + 2, 79 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(k + 2, 82 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(k + 2, 84 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(k + 2, 86 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(k + 2, 88 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(k + 2, 90 + gap_st, formObject.agmt_ut_rt.value);
                                    break;
                                case "4":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        sheetObjects[4].SetCellValue(k + 2, l, 0);
                                    }
                                    sheetObjects[4].SetCellValue(k + 2, 68 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(k + 2, 76 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(k + 2, 80 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(k + 2, 83 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(k + 2, 85 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(k + 2, 87 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(k + 2, 89 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(k + 2, 91 + gap_st, formObject.agmt_ut_rt.value);
                                    break;
                                case "5":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        sheetObjects[4].SetCellValue(k + 2, l, 0);
                                    }
                                    sheetObjects[4].SetCellValue(k + 2, 69 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(k + 2, 77 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(k + 2, 81 + gap_st, formObject.agmt_ut_rt.value);
                                    break;
                                case "7":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        sheetObjects[4].SetCellValue(k + 2, l, 0);
                                    }
                                    sheetObjects[4].SetCellValue(k + 2, 70 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(k + 2, 78 + gap_st, formObject.agmt_ut_rt.value);
                                    break;
                                case "8":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        sheetObjects[4].SetCellValue(k + 2, l, 0);
                                    }
                                    sheetObjects[4].SetCellValue(k + 2, 71 + gap_st, formObject.agmt_ut_rt.value);
                                    break;
                                case "9":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        sheetObjects[4].SetCellValue(k + 2, l, 0);
                                    }
                                    sheetObjects[4].SetCellValue(k + 2, 72 + gap_st, formObject.agmt_ut_rt.value);
                                    break;
                                case "W":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        sheetObjects[4].SetCellValue(k + 2, l, 0);
                                    }
                                    sheetObjects[4].SetCellValue(k + 2, 73 + gap_st, formObject.agmt_ut_rt.value);
                                    break;
                                case "X":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        sheetObjects[4].SetCellValue(k + 2, l, 0);
                                    }
                                    sheetObjects[4].SetCellValue(k + 2, 74 + gap_st, formObject.agmt_ut_rt.value);
                                    break;
                            }
                        } else if (formObject.cntr_type_s.value != "" && formObject.cntr_size_s.value != "") {
                            var typeName = comboObjects[7].GetSelectCode();
                            var sizeName = comboObjects[8].GetSelectCode();
                            cntrTypeSize = typeName + sizeName;
                            sheetObjects[4].SetCellValue(k + 2, "5" + cntrTypeSize.toLowerCase() + "_f", formObject.agmt_ut_rt.value);
                        }
                    }
                }
            }
            //if(formObject.storage_gb[1].checked==true){	
            //	showErrMessage(formObject.tml_agmt_vol_ut_cd[2].value );			 
            if (formObject.tml_agmt_vol_ut_cd[2].value == "T") {
                sheetObjects[4].SetCellValue(k + 2, 92 + gap_st, formObject.agmt_ut_rt.value);
            } else {
                sheetObjects[4].SetCellValue(k + 2, 92 + gap_st, "");
            }
            if (formObject.tml_agmt_vol_ut_cd[2].value == "U") {
                sheetObjects[4].SetCellValue(k + 2, 93 + gap_st, formObject.agmt_ut_rt.value);
            } else {
                sheetObjects[4].SetCellValue(k + 2, 93 + gap_st, "");
            }
            if (formObject.tml_agmt_vol_ut_cd[2].value == "M") {
                sheetObjects[4].SetCellValue(k + 2, 94 + gap_st, formObject.agmt_ut_rt.value);
            } else {
                sheetObjects[4].SetCellValue(k + 2, 94 + gap_st, "");
            }
            //}
            sheetObjects[4].SetCellValue(k + 2, 95 + gap_st, "");
            sheetObjects[4].SetCellValue(k + 2, 96 + gap_st, "");
            if (formObject.storage_gb[0].checked == true) {
                if (formObject.sat_flg_FD.disabled == false && formObject.sun_flg_FD.disabled == false && formObject.hol_flg_FD.disabled == false) {
                    if (formObject.sat_flg_FD.checked == true || formObject.sun_flg_FD.checked == true || formObject.hol_flg_FD.checked == true) {
                        sheetObjects[4].SetCellValue(k + 2, 98 + gap_st, "S");
                    } else {
                        sheetObjects[4].SetCellValue(k + 2, 98 + gap_st, "N");
                    }
                }
            } else if (formObject.storage_gb[1].checked == true) {
                sheetObjects[4].SetCellValue(k + 2, 98 + gap_st, "");
            }
            //if(sheetObjects[0].CheckedRows(0) == "1" || sheetObjects[0].CellValue(sheet1_parameters[1], 2) == "1" || sheetObjects[0].CellValue(sheet1_parameters[1], 3) == "MAX"	){
            //	sheetObjects[4].CellValue(k+2, 63)="N";
            //}else{ 
            //	sheetObjects[4].CellValue(k+2, 63)="S";	
            //}    
            //sheetObjects[4].RowStatus(k+2) = "I";
            //k++;
            eq_flg = sheetObjects[4].ColValueDup("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98");
            comp_flg = sheetObjects[4].ColValueDup("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41");
            /**
            if(eq_flg > 0){ 
            	sheetObjects[4].RowDelete(k+2, false);
            	break;
            }else{
            sheetObjects[4].SetRowStatus(k+2,"I");
            k++;	
            }
            **/
            if (eq_flg == -1 && comp_flg == -1) {
                sheetObjects[4].SetRowStatus(k + 2, "I");
                k++;
                //break;
            } else if (eq_flg == -1 && comp_flg > -1) {
                storageRateInputListComparison(k + 2);
            } else {
                sheetObjects[4].RowDelete(k + 2, false);
                ComShowCodeMessage('TES10117'); // There is sane condition rate.\n\n Please check the Agreement.
            }
        }
    } else if (formObject.tml_sto_agmt_tp_cd.value == "FP") {
        sheetObjects[4].DataInsert(-1);
        sheetObjects[4].SetCellValue(k + 2, 0, "");
        sheetObjects[4].SetCellValue(k + 2, 1, "");
        sheetObjects[4].SetCellValue(k + 2, 2, formObject.lgs_cost_cd_s.value);
        sheetObjects[4].SetCellValue(k + 2, 3, formObject.sto_tml_cntr_sty_cd.value); //F/M
        sheetObjects[4].SetCellValue(k + 2, 3 + gap_st, formObject.tml_agmt_vol_ut_cd[2].value);
        sheetObjects[4].SetCellValue(k + 2, 4 + gap_st, formObject.curr_cd_s.value);
        sheetObjects[4].SetCellValue(k + 2, 5 + gap_st, formObject.tml_sto_agmt_tp_cd.value);
        sheetObjects[4].SetCellValue(k + 2, 6 + gap_st, formObject.cmnc_hrmnt.value);
        sheetObjects[4].SetCellValue(k + 2, 40 + gap_st, getElementValue(formObject, 'radio', 'fp_calc_prd_cd'));
        sheetObjects[4].SetCellValue(k + 2, 41 + gap_st, formObject.fp_teu_qty.value);
        if (formObject.tml_agmt_vol_ut_cd[2].value == "T") {
            sheetObjects[4].SetCellValue(k + 2, 92 + gap_st, formObject.agmt_ut_rt_fp.value);
        } else {
            sheetObjects[4].SetCellValue(k + 2, 92 + gap_st, "");
        }
        if (formObject.tml_agmt_vol_ut_cd[2].value == "U") {
            sheetObjects[4].SetCellValue(k + 2, 93 + gap_st, formObject.agmt_ut_rt_fp.value);
        } else {
            sheetObjects[4].SetCellValue(k + 2, 93 + gap_st, "");
        }
        if (formObject.tml_agmt_vol_ut_cd[2].value == "M") {
            sheetObjects[4].SetCellValue(k + 2, 94 + gap_st, formObject.agmt_ut_rt_fp.value);
        } else {
            sheetObjects[4].SetCellValue(k + 2, 94 + gap_st, "");
        }
        //sheetObjects[4].RowStatus(k+2) = "I";
        //k++;		
        eq_flg = sheetObjects[4].ColValueDup("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99");
        if (eq_flg > 0) {
            sheetObjects[4].RowDelete(k + 2, false);
        } else {
            sheetObjects[4].SetRowStatus(k + 2, "I");
            k++;
        }
    }
    //span_kkk1.innerHTML = "<table border=1 cellspacing=0 cellpadding=0>"+str+"</table>";
}
/**
 * 
 * @param {int,String}	sheetRowNum
 * @return
 */
function terminalRateInputListComparison(sheetRowNum) {
    var formObject = document.form;
    var baseRowInfo = sheetObjects[2].GetCellValue(sheetRowNum, 2) + sheetObjects[2].GetCellValue(sheetRowNum, 3) + sheetObjects[2].GetCellValue(sheetRowNum, 4) + sheetObjects[2].GetCellValue(sheetRowNum, 5) + sheetObjects[2].GetCellValue(sheetRowNum, 6) + sheetObjects[2].GetCellValue(sheetRowNum, 7) + sheetObjects[2].GetCellValue(sheetRowNum, 8) + sheetObjects[2].GetCellValue(sheetRowNum, 9) + sheetObjects[2].GetCellValue(sheetRowNum, 10) + sheetObjects[2].GetCellValue(sheetRowNum, 11) + sheetObjects[2].GetCellValue(sheetRowNum, 12) + sheetObjects[2].GetCellValue(sheetRowNum, 13) + sheetObjects[2].GetCellValue(sheetRowNum, 14) + sheetObjects[2].GetCellValue(sheetRowNum, 15) + sheetObjects[2].GetCellValue(sheetRowNum, 16) + sheetObjects[2].GetCellValue(sheetRowNum, 17) + sheetObjects[2].GetCellValue(sheetRowNum, 18) + sheetObjects[2].GetCellValue(sheetRowNum, 19) + sheetObjects[2].GetCellValue(sheetRowNum, 20) + sheetObjects[2].GetCellValue(sheetRowNum, 21) + sheetObjects[2].GetCellValue(sheetRowNum, 22) + sheetObjects[2].GetCellValue(sheetRowNum, 23) + sheetObjects[2].GetCellValue(sheetRowNum, 24) + sheetObjects[2].GetCellValue(sheetRowNum, 25) + sheetObjects[2].GetCellValue(sheetRowNum, 26) + sheetObjects[2].GetCellValue(sheetRowNum, 27) + sheetObjects[2].GetCellValue(sheetRowNum, 28) + sheetObjects[2].GetCellValue(sheetRowNum, 29) + sheetObjects[2].GetCellValue(sheetRowNum, 30) + sheetObjects[2].GetCellValue(sheetRowNum, 31) + sheetObjects[2].GetCellValue(sheetRowNum, 32) + sheetObjects[2].GetCellValue(sheetRowNum, 33);
    var compaRowInfo = "";

    sheetObjects[2].RowDelete(sheetRowNum, false);

    for (var i = 0; i < sheetObjects[2].RowCount(); i++) {
        compaRowInfo = sheetObjects[2].GetCellValue(i + 3, 2) + sheetObjects[2].GetCellValue(i + 3, 3) + sheetObjects[2].GetCellValue(i + 3, 4) + sheetObjects[2].GetCellValue(i + 3, 5) + sheetObjects[2].GetCellValue(i + 3, 6) + sheetObjects[2].GetCellValue(i + 3, 7) + sheetObjects[2].GetCellValue(i + 3, 8) + sheetObjects[2].GetCellValue(i + 3, 9) + sheetObjects[2].GetCellValue(i + 3, 10) + sheetObjects[2].GetCellValue(i + 3, 11) + sheetObjects[2].GetCellValue(i + 3, 12) + sheetObjects[2].GetCellValue(i + 3, 13) + sheetObjects[2].GetCellValue(i + 3, 14) + sheetObjects[2].GetCellValue(i + 3, 15) + sheetObjects[2].GetCellValue(i + 3, 16) + sheetObjects[2].GetCellValue(i + 3, 17) + sheetObjects[2].GetCellValue(i + 3, 18) + sheetObjects[2].GetCellValue(i + 3, 19) + sheetObjects[2].GetCellValue(i + 3, 20) + sheetObjects[2].GetCellValue(i + 3, 21) + sheetObjects[2].GetCellValue(i + 3, 22) + sheetObjects[2].GetCellValue(i + 3, 23) + sheetObjects[2].GetCellValue(i + 3, 24) + sheetObjects[2].GetCellValue(i + 3, 25) + sheetObjects[2].GetCellValue(i + 3, 26) + sheetObjects[2].GetCellValue(i + 3, 27) + sheetObjects[2].GetCellValue(i + 3, 28) + sheetObjects[2].GetCellValue(i + 3, 29) + sheetObjects[2].GetCellValue(i + 3, 30) + sheetObjects[2].GetCellValue(i + 3, 31) + sheetObjects[2].GetCellValue(i + 3, 32) + sheetObjects[2].GetCellValue(i + 3, 33);

        if (baseRowInfo == compaRowInfo) {
            if (formObject.tml_agmt_vol_ut_cd[1].value == "C") {
                if (formObject.cntr_ts[0].checked == true) {
                    for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                        sheetObjects[2].SetCellValue(i + 3, l, formObject.agmt_rate.value);
                    }
                } else if (formObject.cntr_ts[1].checked == true) {
                    if (comboObjects[3].GetSelectCode() == "All" && comboObjects[4].GetSelectCode() == "All") {
                        for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                            sheetObjects[2].SetCellValue(i + 3, l, formObject.agmt_rate.value);
                        }
                    }
                    if (comboObjects[3].GetSelectCode() == "All" && (comboObjects[4].GetSelectCode() != "" || comboObjects[4].GetSelectCode() != undefined)) {
                        var typeName = comboObjects[3].GetSelectCode();
                        var sizeName = comboObjects[4].GetSelectCode();
                        var cntr_type_list = new Array();
                        cntr_type_list[0] = "D";
                        cntr_type_list[1] = "R";
                        cntr_type_list[2] = "F";
                        cntr_type_list[3] = "O";
                        cntr_type_list[4] = "S";
                        cntr_type_list[5] = "T";
                        cntr_type_list[6] = "A";
                        cntr_type_list[7] = "P";
                        for (var l = 0; l < 8; l++) {
                            sheetObjects[2].SetCellValue(i + 3, "3" + cntr_type_list[l].toLowerCase() + sizeName, formObject.agmt_rate.value);
                            switch ("3" + cntr_type_list[l].toLowerCase() + sizeName) {
                                case "3d2":
                                    sheetObjects[2].SetCellValue(i + 3, "3d2", formObject.agmt_rate.value);
                                    break;
                                case "3d4":
                                    sheetObjects[2].SetCellValue(i + 3, "3d4", formObject.agmt_rate.value);
                                    break;
                                case "3d5":
                                    sheetObjects[2].SetCellValue(i + 3, "3d5", formObject.agmt_rate.value);
                                    break;
                                case "3d7":
                                    sheetObjects[2].SetCellValue(i + 3, "3d7", formObject.agmt_rate.value);
                                    break;
                                case "3d8":
                                    sheetObjects[2].SetCellValue(i + 3, "3d8", formObject.agmt_rate.value);
                                    break;
                                case "3d9":
                                    sheetObjects[2].SetCellValue(i + 3, "3d9", formObject.agmt_rate.value);
                                    break;
                                case "3dw":
                                    sheetObjects[2].SetCellValue(i + 3, "3dw", formObject.agmt_rate.value);
                                    break;
                                case "3dx":
                                    sheetObjects[2].SetCellValue(i + 3, "3dx", formObject.agmt_rate.value);
                                    break;
                            }
                        }
                    }
                    if ((comboObjects[3].GetSelectCode() != "" || comboObjects[3].GetSelectCode() != undefined) && comboObjects[4].GetSelectCode() == "All") {
                        var typeName = comboObjects[3].GetSelectCode();
                        var sizeName = comboObjects[4].GetSelectCode();
                        var cntr_size_list = new Array();
                        cntr_size_list[0] = "2";
                        cntr_size_list[1] = "4";
                        cntr_size_list[2] = "5";
                        cntr_size_list[3] = "6";
                        cntr_size_list[4] = "7";
                        cntr_size_list[5] = "8";
                        cntr_size_list[6] = "9";
                        cntr_size_list[7] = "w";
                        cntr_size_list[8] = "x";
                        for (var l = 0; l < 9; l++) {
                            sheetObjects[2].SetCellValue(i + 3, "3" + typeName.toLowerCase() + cntr_size_list[l], formObject.agmt_rate.value);
                            switch ("3" + typeName.toLowerCase() + cntr_size_list[l]) {
                                case "3d2":
                                    sheetObjects[2].SetCellValue(i + 3, "3d2", formObject.agmt_rate.value);
                                    break;
                                case "3d4":
                                    sheetObjects[2].SetCellValue(i + 3, "3d4", formObject.agmt_rate.value);
                                    break;
                                case "3d5":
                                    sheetObjects[2].SetCellValue(i + 3, "3d5", formObject.agmt_rate.value);
                                    break;
                                case "3d7":
                                    sheetObjects[2].SetCellValue(i + 3, "3d7", formObject.agmt_rate.value);
                                    break;
                                case "3d8":
                                    sheetObjects[2].SetCellValue(i + 3, "3d8", formObject.agmt_rate.value);
                                    break;
                                case "3d9":
                                    sheetObjects[2].SetCellValue(i + 3, "3d9", formObject.agmt_rate.value);
                                    break;
                                case "3dw":
                                    sheetObjects[2].SetCellValue(i + 3, "3dw", formObject.agmt_rate.value);
                                    break;
                                case "3dx":
                                    sheetObjects[2].SetCellValue(i + 3, "3dx", formObject.agmt_rate.value);
                                    break;
                            }
                        }
                    }
                    if ((formObject.cntr_type_t.value != "" && formObject.cntr_type_t.value != undefined) && (formObject.cntr_size_t.value == "" || formObject.cntr_size_t.value == undefined)) {
                        var typeName = formObject.cntr_type_t.value;
                        switch (typeName) {
                            case "D":
                                for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                                    if (l < 40 + gap_tm) {
                                        sheetObjects[2].SetCellValue(i + 3, l, formObject.agmt_rate.value);
                                    } else {
                                        sheetObjects[2].SetCellValue(i + 3, l, 0);
                                    }
                                }
                                break;
                            case "R":
                                for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                                    if (l > 39 + gap_tm && l < 44 + gap_tm) {
                                        sheetObjects[2].SetCellValue(i + 3, l, formObject.agmt_rate.value);
                                    } else {
                                        sheetObjects[2].SetCellValue(i + 3, l, 0);
                                    }
                                }
                                break;
                            case "F":
                                for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                                    if (l > 43 + gap_tm && l < 47 + gap_tm) {
                                        sheetObjects[2].SetCellValue(i + 3, l, formObject.agmt_rate.value);
                                    } else {
                                        sheetObjects[2].SetCellValue(i + 3, l, 0);
                                    }
                                }
                                //sheetObjects[2].CellValue(i+3, 55)=formObject.agmt_rate.value;																
                                break;
                            case "O":
                                for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                                    if (l > 46 + gap_tm && l < 49 + gap_tm) {
                                        sheetObjects[2].SetCellValue(i + 3, l, formObject.agmt_rate.value);
                                    } else {
                                        sheetObjects[2].SetCellValue(i + 3, l, 0);
                                    }
                                }
                                break;
                            case "S":
                                for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                                    if (l > 48 + gap_tm && l < 51 + gap_tm) {
                                        sheetObjects[2].SetCellValue(i + 3, l, formObject.agmt_rate.value);
                                    } else {
                                        sheetObjects[2].SetCellValue(i + 3, l, 0);
                                    }
                                }
                                break;
                            case "T":
                                for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                                    if (l > 50 + gap_tm && l < 53 + gap_tm) {
                                        sheetObjects[2].SetCellValue(i + 3, l, formObject.agmt_rate.value);
                                    } else {
                                        sheetObjects[2].SetCellValue(i + 3, l, 0);
                                    }
                                }
                                break;
                            case "A":
                                for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                                    if (l > 52 + gap_tm && l < 55 + gap_tm) {
                                        sheetObjects[2].SetCellValue(i + 3, l, formObject.agmt_rate.value);
                                    } else {
                                        sheetObjects[2].SetCellValue(i + 3, l, 0);
                                    }
                                }
                                break;
                            case "P":
                                for (var l = 32 + gap_tm; l < 57 + gap_tm; l++) {
                                    if (l > 53 + gap_tm && l < 56 + gap_tm) {
                                        sheetObjects[2].SetCellValue(i + 3, l, formObject.agmt_rate.value);
                                    } else {
                                        sheetObjects[2].SetCellValue(i + 3, l, 0);
                                    }
                                }
                                break;
                                /**									
                                case "D":
                                	for(var l=32; l<57 ; l++)
                                	{ 
                                		if(l< 39){
                                			sheetObjects[2].SetCellValue(i+3, l,formObject.agmt_rate.value);
                                		}
                                	}																	 									
                                	break;										
                                case "R":
                                	for(var l=32; l<57 ; l++)
                                	{ 
                                		if(l> 38 && l < 43){
                                			sheetObjects[2].SetCellValue(i+3, l,formObject.agmt_rate.value);
                                		}
                                	}										
                                	break;									
                                case "F":
                                	for(var l=32; l<57 ; l++)
                                	{ 
                                		if(l> 42 && l < 45){
                                			sheetObjects[2].SetCellValue(i+3, l,formObject.agmt_rate.value);
                                		}
                                	}
                                			sheetObjects[2].SetCellValue(i+3, 55,formObject.agmt_rate.value);
                                	break;								
                                case "O":
                                	for(var l=32; l<57 ; l++)
                                	{ 
                                		if(l> 44 && l < 47){
                                			sheetObjects[2].SetCellValue(i+3, l,formObject.agmt_rate.value);
                                		}
                                	}																										
                                	break;
                                case "S":		
                                	for(var l=32; l<57 ; l++)
                                	{ 
                                		if(l> 46 && l < 49){
                                			sheetObjects[2].SetCellValue(i+3, l,formObject.agmt_rate.value);
                                		}
                                	}											
                                	break;										
                                case "T":
                                	for(var l=32; l<57 ; l++)
                                	{ 
                                		if(l> 48 && l < 51){
                                			sheetObjects[2].SetCellValue(i+3, l,formObject.agmt_rate.value);
                                		}
                                	}									
                                	break; 								
                                case "A":
                                	for(var l=32; l<57 ; l++)
                                	{ 
                                		if(l > 50 && l < 53){
                                			sheetObjects[2].SetCellValue(i+3, l,formObject.agmt_rate.value);
                                		}
                                	}									
                                	break; 								
                                case "P":
                                	for(var l=32; l<57 ; l++)
                                	{ 
                                		if(l > 52 && l < 55){
                                			sheetObjects[2].SetCellValue(i+3, l,formObject.agmt_rate.value);
                                		}
                                	}									
                                	break;
                                	**/
                        }
                    } else if ((formObject.cntr_type_t.value == "" || formObject.cntr_type_t.value == undefined) && (formObject.cntr_size_t.value != "" && formObject.cntr_size_t.value != undefined)) {
                        switch (formObject.cntr_size_t.value) {
                            case "2":
                                sheetObjects[2].SetCellValue(i + 3, 32 + gap_tm, formObject.agmt_rate.value);
                                sheetObjects[2].SetCellValue(i + 3, 40 + gap_tm, formObject.agmt_rate.value);
                                sheetObjects[2].SetCellValue(i + 3, 44 + gap_tm, formObject.agmt_rate.value);
                                sheetObjects[2].SetCellValue(i + 3, 46 + gap_tm, formObject.agmt_rate.value);
                                sheetObjects[2].SetCellValue(i + 3, 48 + gap_tm, formObject.agmt_rate.value);
                                sheetObjects[2].SetCellValue(i + 3, 50 + gap_tm, formObject.agmt_rate.value);
                                sheetObjects[2].SetCellValue(i + 3, 52 + gap_tm, formObject.agmt_rate.value);
                                sheetObjects[2].SetCellValue(i + 3, 54 + gap_tm, formObject.agmt_rate.value);
                                break;
                            case "4":
                                sheetObjects[2].SetCellValue(i + 3, 33 + gap_tm, formObject.agmt_rate.value);
                                sheetObjects[2].SetCellValue(i + 3, 41 + gap_tm, formObject.agmt_rate.value);
                                sheetObjects[2].SetCellValue(i + 3, 45 + gap_tm, formObject.agmt_rate.value);
                                sheetObjects[2].SetCellValue(i + 3, 47 + gap_tm, formObject.agmt_rate.value);
                                sheetObjects[2].SetCellValue(i + 3, 49 + gap_tm, formObject.agmt_rate.value);
                                sheetObjects[2].SetCellValue(i + 3, 51 + gap_tm, formObject.agmt_rate.value);
                                sheetObjects[2].SetCellValue(i + 3, 53 + gap_tm, formObject.agmt_rate.value);
                                sheetObjects[2].SetCellValue(i + 3, 55 + gap_tm, formObject.agmt_rate.value);
                                break;
                            case "5":
                                sheetObjects[2].SetCellValue(i + 3, 34 + gap_tm, formObject.agmt_rate.value);
                                sheetObjects[2].SetCellValue(i + 3, 42 + gap_tm, formObject.agmt_rate.value);
                                sheetObjects[2].SetCellValue(i + 3, 46 + gap_tm, formObject.agmt_rate.value);
                                break;
                            case "7":
                                sheetObjects[2].SetCellValue(i + 3, 35 + gap_tm, formObject.agmt_rate.value);
                                sheetObjects[2].SetCellValue(i + 3, 43 + gap_tm, formObject.agmt_rate.value);
                                break;
                            case "8":
                                sheetObjects[2].SetCellValue(i + 3, 36 + gap_tm, formObject.agmt_rate.value);
                                break;
                            case "9":
                                sheetObjects[2].SetCellValue(i + 3, 37 + gap_tm, formObject.agmt_rate.value);
                                break;
                            case "W":
                                sheetObjects[2].SetCellValue(i + 3, 38 + gap_tm, formObject.agmt_rate.value);
                                break;
                            case "X":
                                sheetObjects[2].SetCellValue(i + 3, 39 + gap_tm, formObject.agmt_rate.value);
                                break;
                        }
                    } else if ((formObject.cntr_type_t.value != "" && formObject.cntr_type_t.value != undefined) && (formObject.cntr_size_t.value != "" && formObject.cntr_size_t.value != undefined)) {
                        var typeName = comboObjects[3].GetSelectCode();
                        var sizeName = comboObjects[4].GetSelectCode();
                        cntrTypeSize = typeName + sizeName;
                        switch ("3" + typeName.toLowerCase() + sizeName) {
                            case "3d2":
                                sheetObjects[2].SetCellValue(i + 3, "3d2", formObject.agmt_rate.value);
                                break;
                            case "3d4":
                                sheetObjects[2].SetCellValue(i + 3, "3d4", formObject.agmt_rate.value);
                                break;
                            case "3d5":
                                sheetObjects[2].SetCellValue(i + 3, "3d5", formObject.agmt_rate.value);
                                break;
                            case "3d7":
                                sheetObjects[2].SetCellValue(i + 3, "3d7", formObject.agmt_rate.value);
                                break;
                            case "3d8":
                                sheetObjects[2].SetCellValue(i + 3, "3d8", formObject.agmt_rate.value);
                                break;
                            case "3d9":
                                sheetObjects[2].SetCellValue(i + 3, "3d9", formObject.agmt_rate.value);
                                break;
                            case "3dw":
                                sheetObjects[2].SetCellValue(i + 3, "3dw", formObject.agmt_rate.value);
                                break;
                            case "3dx":
                                sheetObjects[2].SetCellValue(i + 3, "3dx", formObject.agmt_rate.value);
                                break;
                        }
                        sheetObjects[2].SetCellValue(i + 3, "3" + cntrTypeSize.toLowerCase(), formObject.agmt_rate.value);
                    }
                }
            }
            if (formObject.tml_agmt_vol_ut_cd[1].value == "T") {
                sheetObjects[2].SetCellValue(i + 3, 57 + gap_tm, formObject.agmt_rate.value);
            } else {
                sheetObjects[2].SetCellValue(i + 3, 57 + gap_tm, "");
            }
            if (formObject.tml_agmt_vol_ut_cd[1].value == "U") {
                sheetObjects[2].SetCellValue(i + 3, 58 + gap_tm, formObject.agmt_rate.value);
            } else {
                sheetObjects[2].SetCellValue(i + 3, 58 + gap_tm, "");
            }
            if (formObject.tml_agmt_vol_ut_cd[1].value == "M") {
                sheetObjects[2].SetCellValue(i + 3, 59 + gap_tm, formObject.agmt_rate.value);
            } else {
                sheetObjects[2].SetCellValue(i + 3, 59 + gap_tm, "");
            }
        }
        compaRowInfo = "";
    }
}
/**
 * 
 * @param {int,String}	sheetRowNum
 * @return
 */
function storageRateInputListComparison(sheetRowNum) {
    var formObject = document.form;
    var baseRowInfo = sheetObjects[4].GetCellValue(sheetRowNum, 2) + sheetObjects[4].GetCellValue(sheetRowNum, 3) + sheetObjects[4].GetCellValue(sheetRowNum, 4) + sheetObjects[4].GetCellValue(sheetRowNum, 5) + sheetObjects[4].GetCellValue(sheetRowNum, 6) + sheetObjects[4].GetCellValue(sheetRowNum, 7) + sheetObjects[4].GetCellValue(sheetRowNum, 8) + sheetObjects[4].GetCellValue(sheetRowNum, 9) + sheetObjects[4].GetCellValue(sheetRowNum, 10) + sheetObjects[4].GetCellValue(sheetRowNum, 11) + sheetObjects[4].GetCellValue(sheetRowNum, 12) + sheetObjects[4].GetCellValue(sheetRowNum, 13) + sheetObjects[4].GetCellValue(sheetRowNum, 14) + sheetObjects[4].GetCellValue(sheetRowNum, 15) + sheetObjects[4].GetCellValue(sheetRowNum, 16) + sheetObjects[4].GetCellValue(sheetRowNum, 17) + sheetObjects[4].GetCellValue(sheetRowNum, 18) + sheetObjects[4].GetCellValue(sheetRowNum, 19) + sheetObjects[4].GetCellValue(sheetRowNum, 20) + sheetObjects[4].GetCellValue(sheetRowNum, 21) + sheetObjects[4].GetCellValue(sheetRowNum, 22) + sheetObjects[4].GetCellValue(sheetRowNum, 23) + sheetObjects[4].GetCellValue(sheetRowNum, 24) + sheetObjects[4].GetCellValue(sheetRowNum, 25) + sheetObjects[4].GetCellValue(sheetRowNum, 26) + sheetObjects[4].GetCellValue(sheetRowNum, 27) + sheetObjects[4].GetCellValue(sheetRowNum, 28) + sheetObjects[4].GetCellValue(sheetRowNum, 29) + sheetObjects[4].GetCellValue(sheetRowNum, 28) + sheetObjects[4].GetCellValue(sheetRowNum, 31) + sheetObjects[4].GetCellValue(sheetRowNum, 30) + sheetObjects[4].GetCellValue(sheetRowNum, 33) + sheetObjects[4].GetCellValue(sheetRowNum, 32) + sheetObjects[4].GetCellValue(sheetRowNum, 34) + sheetObjects[4].GetCellValue(sheetRowNum, 34) + sheetObjects[4].GetCellValue(sheetRowNum, 36) + sheetObjects[4].GetCellValue(sheetRowNum, 36) + sheetObjects[4].GetCellValue(sheetRowNum, 38) + sheetObjects[4].GetCellValue(sheetRowNum, 38) + sheetObjects[4].GetCellValue(sheetRowNum, 39) + sheetObjects[4].GetCellValue(sheetRowNum, 40) + sheetObjects[4].GetCellValue(sheetRowNum, 41);
    var compaRowInfo = "";
    sheetObjects[4].RowDelete(sheetRowNum, false);
    for (var i = 0; i < sheetObjects[4].RowCount(); i++) {
        compaRowInfo = sheetObjects[4].GetCellValue(i + 3, 2) + sheetObjects[4].GetCellValue(i + 3, 3) + sheetObjects[4].GetCellValue(i + 3, 4) + sheetObjects[4].GetCellValue(i + 3, 5) + sheetObjects[4].GetCellValue(i + 3, 6) + sheetObjects[4].GetCellValue(i + 3, 7) + sheetObjects[4].GetCellValue(i + 3, 8) + sheetObjects[4].GetCellValue(i + 3, 9) + sheetObjects[4].GetCellValue(i + 3, 10) + sheetObjects[4].GetCellValue(i + 3, 11) + sheetObjects[4].GetCellValue(i + 3, 12) + sheetObjects[4].GetCellValue(i + 3, 13) + sheetObjects[4].GetCellValue(i + 3, 14) + sheetObjects[4].GetCellValue(i + 3, 15) + sheetObjects[4].GetCellValue(i + 3, 16) + sheetObjects[4].GetCellValue(i + 3, 17) + sheetObjects[4].GetCellValue(i + 3, 18) + sheetObjects[4].GetCellValue(i + 3, 19) + sheetObjects[4].GetCellValue(i + 3, 20) + sheetObjects[4].GetCellValue(i + 3, 21) + sheetObjects[4].GetCellValue(i + 3, 22) + sheetObjects[4].GetCellValue(i + 3, 23) + sheetObjects[4].GetCellValue(i + 3, 24) + sheetObjects[4].GetCellValue(i + 3, 25) + sheetObjects[4].GetCellValue(i + 3, 26) + sheetObjects[4].GetCellValue(i + 3, 27) + sheetObjects[4].GetCellValue(i + 3, 28) + sheetObjects[4].GetCellValue(i + 3, 29) + sheetObjects[4].GetCellValue(i + 3, 30) + sheetObjects[4].GetCellValue(i + 3, 33) + sheetObjects[4].GetCellValue(i + 3, 32) + sheetObjects[4].GetCellValue(i + 3, 34) + sheetObjects[4].GetCellValue(i + 3, 34) + sheetObjects[4].GetCellValue(i + 3, 36) + sheetObjects[4].GetCellValue(i + 3, 36) + sheetObjects[4].GetCellValue(i + 3, 38) + sheetObjects[4].GetCellValue(i + 3, 38) + sheetObjects[4].GetCellValue(i + 3, 39) + sheetObjects[4].GetCellValue(i + 3, 40) + sheetObjects[4].GetCellValue(i + 3, 41);
        if (baseRowInfo == compaRowInfo) {
            if (formObject.storage_gb[0].checked == true) {
                //if(formObject.tml_agmt_vol_ut_cd[2].value=="C"){
                if (formObject.tml_agmt_vol_ut_cd[2].value == "U" || formObject.tml_agmt_vol_ut_cd[2].value == "M") {
                    for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                        sheetObjects[4].SetCellValue(i + 3, l, formObject.ft_dys.value);
                    }
                }
                if (formObject.cntr_ts[2].checked == true) {
                    for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                        sheetObjects[4].SetCellValue(i + 3, l, formObject.ft_dys.value);
                    }
                } else if (formObject.cntr_ts[3].checked == true) {
                    if (comboObjects[7].GetSelectCode() == "All" && comboObjects[8].GetSelectCode() == "All") {
                        for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                            sheetObjects[4].SetCellValue(i + 3, l, formObject.ft_dys.value);
                        }
                    }
                    if (comboObjects[7].GetSelectCode() == "All" && (comboObjects[8].GetSelectCode() != "" || comboObjects[8].GetSelectCode() != undefined)) {
                        var typeName = comboObjects[7].GetSelectCode();
                        var sizeName = comboObjects[8].GetSelectCode();
                        var cntr_type_list = new Array();
                        cntr_type_list[0] = "D";
                        cntr_type_list[1] = "R";
                        cntr_type_list[2] = "F";
                        cntr_type_list[3] = "O";
                        cntr_type_list[4] = "S";
                        cntr_type_list[5] = "T";
                        cntr_type_list[6] = "A";
                        cntr_type_list[7] = "P";
                        for (var l = 0; l < 8; l++) {
                            sheetObjects[4].SetCellValue(i + 3, "5" + cntr_type_list[l].toLowerCase() + sizeName + "_fd", formObject.ft_dys.value);
                        }
                    }
                    if ((comboObjects[7].GetSelectCode() != "" || comboObjects[8].GetSelectCode() != undefined) && comboObjects[8].GetSelectCode() == "All") {
                        var typeName = comboObjects[7].GetSelectCode();
                        var sizeName = comboObjects[8].GetSelectCode();
                        var cntr_size_list = new Array();
                        cntr_size_list[0] = "2";
                        cntr_size_list[1] = "4";
                        cntr_size_list[2] = "5";
                        cntr_size_list[3] = "6";
                        cntr_size_list[4] = "7";
                        cntr_size_list[5] = "8";
                        cntr_size_list[6] = "9";
                        cntr_size_list[7] = "w";
                        cntr_size_list[8] = "x";
                        for (var l = 0; l < 9; l++) {
                            sheetObjects[4].SetCellValue(i + 3, "5" + typeName.toLowerCase() + cntr_size_list[l] + "_fd", formObject.ft_dys.value);
                        }
                    }
                    if ((formObject.cntr_type_s.value != "" && formObject.cntr_type_s.value != undefined) && (formObject.cntr_size_s.value == "" || formObject.cntr_size_s.value == undefined)) {
                        var typeName = formObject.cntr_type_s.value;
                        switch (typeName) {
                            case "D":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    if (l < 50) {
                                        sheetObjects[4].SetCellValue(i + 3, l, formObject.ft_dys.value);
                                    }
                                }
                                break;
                            case "R":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    if (l > 49 + gap_st && l < 54 + gap_st) {
                                        sheetObjects[4].SetCellValue(i + 3, l, formObject.ft_dys.value);
                                    }
                                }
                                break;
                            case "F":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    if (l > 53 + gap_st && l < 57 + gap_st) {
                                        sheetObjects[4].SetCellValue(i + 3, l, formObject.ft_dys.value);
                                    }
                                }
                                sheetObjects[4].SetCellValue(i + 3, 65, formObject.ft_dys.value);
                                break;
                            case "O":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    if (l > 56 + gap_st && l < 59 + gap_st) {
                                        sheetObjects[4].SetCellValue(i + 3, l, formObject.ft_dys.value);
                                    }
                                }
                                break;
                            case "S":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    if (l > 58 + gap_st && l < 61 + gap_st) {
                                        sheetObjects[4].SetCellValue(i + 3, l, formObject.ft_dys.value);
                                    }
                                }
                                break;
                            case "T":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    if (l > 60 + gap_st && l < 63 + gap_st) {
                                        sheetObjects[4].SetCellValue(i + 3, l, formObject.ft_dys.value);
                                    }
                                }
                                break;
                            case "A":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    if (l > 62 + gap_st && l < 65 + gap_st) {
                                        sheetObjects[4].SetCellValue(i + 3, l, formObject.ft_dys.value);
                                    }
                                }
                                break;
                            case "P":
                                for (var l = 42 + gap_st; l < 67 + gap_st; l++) {
                                    if (l > 64 + gap_st && l < 67 + gap_st) {
                                        sheetObjects[4].SetCellValue(i + 3, l, formObject.ft_dys.value);
                                    }
                                }
                                break;
                        }
                        //}else if(formObject.cntr_size[1].value!=""){
                    } else if ((formObject.cntr_type_s.value == "" || formObject.cntr_type_s.value == undefined) && (formObject.cntr_size_s.value != "" && formObject.cntr_size_s.value != undefined)) {
                        switch (formObject.cntr_size_s.value) {
                            case "2":
                                sheetObjects[4].SetCellValue(i + 3, 42 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(i + 3, 50 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(i + 3, 54 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(i + 3, 57 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(i + 3, 59 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(i + 3, 61 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(i + 3, 63 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(i + 3, 65 + gap_st, formObject.ft_dys.value);
                                break;
                            case "4":
                                sheetObjects[4].SetCellValue(i + 3, 43 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(i + 3, 51 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(i + 3, 55 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(i + 3, 58 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(i + 3, 60 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(i + 3, 62 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(i + 3, 64 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(i + 3, 66 + gap_st, formObject.ft_dys.value);
                                break;
                            case "5":
                                sheetObjects[4].SetCellValue(i + 3, 44 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(i + 3, 52 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(i + 3, 56 + gap_st, formObject.ft_dys.value);
                                break;
                            case "7":
                                sheetObjects[4].SetCellValue(i + 3, 45 + gap_st, formObject.ft_dys.value);
                                sheetObjects[4].SetCellValue(i + 3, 53 + gap_st, formObject.ft_dys.value);
                                break;
                            case "8":
                                sheetObjects[4].SetCellValue(i + 3, 46 + gap_st, formObject.ft_dys.value);
                                break;
                            case "9":
                                sheetObjects[4].SetCellValue(i + 3, 47 + gap_st, formObject.ft_dys.value);
                                break;
                            case "W":
                                sheetObjects[4].SetCellValue(i + 3, 48 + gap_st, formObject.ft_dys.value);
                                break;
                            case "X":
                                sheetObjects[4].SetCellValue(i + 3, 49 + gap_st, formObject.ft_dys.value);
                                break;
                        }
                    } else if ((formObject.cntr_type_s.value != "" && formObject.cntr_type_s.value != undefined) && (formObject.cntr_size_s.value != "" && formObject.cntr_size_s.value != undefined)) {
                        var typeName = comboObjects[7].GetSelectCode();
                        var sizeName = comboObjects[8].GetSelectCode();
                        cntrTypeSize = typeName + sizeName;
                        sheetObjects[4].SetCellValue(i + 3, "5" + cntrTypeSize.toLowerCase() + "_fd", formObject.ft_dys.value);
                    }
                }
                //}
            }
            if (formObject.storage_gb[1].checked == true) {
                if (formObject.tml_agmt_vol_ut_cd[2].value == "C") {
                    if (formObject.cntr_ts[2].checked == true) {
                        for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                            sheetObjects[4].SetCellValue(i + 3, l, formObject.agmt_ut_rt.value);
                        }
                    } else if (formObject.cntr_ts[3].checked == true) {
                        if (comboObjects[7].GetSelectCode() == "All" && comboObjects[8].GetSelectCode() == "All") {
                            for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                sheetObjects[4].SetCellValue(i + 3, l, formObject.agmt_ut_rt.value);
                            }
                        }
                        if (comboObjects[7].GetSelectCode() == "All" && (comboObjects[8].GetSelectCode() != "" || comboObjects[8].GetSelectCode() != undefined)) {
                            var typeName = comboObjects[7].GetSelectCode();
                            var sizeName = comboObjects[8].GetSelectCode();
                            var cntr_type_list = new Array();
                            cntr_type_list[0] = "D";
                            cntr_type_list[1] = "R";
                            cntr_type_list[2] = "F";
                            cntr_type_list[3] = "O";
                            cntr_type_list[4] = "S";
                            cntr_type_list[5] = "T";
                            cntr_type_list[6] = "A";
                            cntr_type_list[7] = "P";
                            for (var l = 0; l < 8; l++) {
                                sheetObjects[4].SetCellValue(i + 3, "5" + cntr_type_list[l].toLowerCase() + sizeName + "_r", formObject.agmt_ut_rt.value);
                            }
                        }
                        if ((comboObjects[7].GetSelectCode() != "" || comboObjects[8].GetSelectCode() != undefined) && comboObjects[8].GetSelectCode() == "All") {
                            var typeName = comboObjects[7].GetSelectCode();
                            var sizeName = comboObjects[8].GetSelectCode();
                            var cntr_size_list = new Array();
                            cntr_size_list[0] = "2";
                            cntr_size_list[1] = "4";
                            cntr_size_list[2] = "5";
                            cntr_size_list[3] = "6";
                            cntr_size_list[4] = "7";
                            cntr_size_list[5] = "8";
                            cntr_size_list[6] = "9";
                            cntr_size_list[7] = "w";
                            cntr_size_list[8] = "x";
                            for (var l = 0; l < 9; l++) {
                                sheetObjects[4].SetCellValue(i + 3, "5" + typeName.toLowerCase() + cntr_size_list[l] + "_r", formObject.agmt_ut_rt.value);
                            }
                        }
                        if (formObject.cntr_type_s.value != "" && formObject.cntr_size_s.value == "") {
                            var typeName = formObject.cntr_type_s.value;
                            switch (typeName) {
                                case "D":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        if (l < 75 + gap_st) {
                                            sheetObjects[4].SetCellValue(i + 3, l, formObject.agmt_ut_rt.value);
                                        }
                                    }
                                    break;
                                case "R":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        if (l > 74 + gap_st && l < 79 + gap_st) {
                                            sheetObjects[4].SetCellValue(i + 3, l, formObject.agmt_ut_rt.value);
                                        }
                                    }
                                    break;
                                case "F":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        if (l > 78 + gap_st && l < 82 + gap_st) {
                                            sheetObjects[4].SetCellValue(i + 3, l, formObject.agmt_ut_rt.value);
                                        }
                                    }
                                    sheetObjects[4].SetCellValue(i + 3, 90 + gap_st, formObject.agmt_ut_rt.value);
                                    break;
                                case "O":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        if (l > 81 + gap_st && l < 84 + gap_st) {
                                            sheetObjects[4].SetCellValue(i + 3, l, formObject.agmt_ut_rt.value);
                                        }
                                    }
                                    break;
                                case "S":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        if (l > 83 + gap_st && l < 86 + gap_st) {
                                            sheetObjects[4].SetCellValue(i + 3, l, formObject.agmt_ut_rt.value);
                                        }
                                    }
                                    break;
                                case "T":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        if (l > 85 + gap_st && l < 88 + gap_st) {
                                            sheetObjects[4].SetCellValue(i + 3, l, formObject.agmt_ut_rt.value);
                                        }
                                    }
                                    break;
                                case "A":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        if (l > 87 && l < 90) {
                                            sheetObjects[4].SetCellValue(i + 3, l, formObject.agmt_ut_rt.value);
                                        }
                                    }
                                    break;
                                case "P":
                                    for (var l = 67 + gap_st; l < 92 + gap_st; l++) {
                                        if (l > 89 + gap_st && l < 92 + gap_st) {
                                            sheetObjects[4].SetCellValue(i + 3, l, formObject.agmt_ut_rt.value);
                                        }
                                    }
                                    break;
                            }
                            //}else if(formObject.cntr_size[1].value!=""){
                        } else if (formObject.cntr_type_s.value == "" && formObject.cntr_size_s.value != "") {
                            switch (formObject.cntr_size_s.value) {
                                case "2":
                                    sheetObjects[4].SetCellValue(i + 3, 67 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(i + 3, 75 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(i + 3, 79 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(i + 3, 82 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(i + 3, 84 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(i + 3, 86 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(i + 3, 88 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(i + 3, 90 + gap_st, formObject.agmt_ut_rt.value);
                                    break;
                                case "4":
                                    sheetObjects[4].SetCellValue(i + 3, 68 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(i + 3, 76 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(i + 3, 80 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(i + 3, 83 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(i + 3, 85 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(i + 3, 87 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(i + 3, 89 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(i + 3, 91 + gap_st, formObject.agmt_ut_rt.value);
                                    break;
                                case "5":
                                    sheetObjects[4].SetCellValue(i + 3, 69 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(i + 3, 77 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(i + 3, 81 + gap_st, formObject.agmt_ut_rt.value);
                                    break;
                                case "7":
                                    sheetObjects[4].SetCellValue(i + 3, 70 + gap_st, formObject.agmt_ut_rt.value);
                                    sheetObjects[4].SetCellValue(i + 3, 78 + gap_st, formObject.agmt_ut_rt.value);
                                    break;
                                case "8":
                                    sheetObjects[4].SetCellValue(i + 3, 71 + gap_st, formObject.agmt_ut_rt.value);
                                    break;
                                case "9":
                                    sheetObjects[4].SetCellValue(i + 3, 72 + gap_st, formObject.agmt_ut_rt.value);
                                    break;
                                case "W":
                                    sheetObjects[4].SetCellValue(i + 3, 73 + gap_st, formObject.agmt_ut_rt.value);
                                    break;
                                case "X":
                                    sheetObjects[4].SetCellValue(i + 3, 74 + gap_st, formObject.agmt_ut_rt.value);
                                    break;
                            }
                        } else if (formObject.cntr_type_s.value != "" && formObject.cntr_size_s.value != "") {
                            var typeName = comboObjects[7].GetSelectCode();
                            var sizeName = comboObjects[8].GetSelectCode();
                            cntrTypeSize = typeName + sizeName;
                            sheetObjects[4].SetCellValue(i + 3, "5" + cntrTypeSize.toLowerCase() + "_r", formObject.agmt_ut_rt.value);
                        }
                    }
                }
            }
        }
        compaRowInfo = "";
    }
}
/*******************************************************************
 * 3. Agreement Terminal Rate List
 * 
 ******************************************************************/
/**
 * Terminal Rate List Tab Data Verify. <br>
 * @param{string}		beforeibflag	beforeibflag
 **/
function terminalRateListVerify_test1(beforeibflag) {
    //		sheetObjects[2].ColumnSort("3auto_calc_flg", "DESC");
    var sheetNo = 3;
    var k = sheetObjects[2].RowCount() + 1;
    var count = 0;
    var n = 1;
    var costCodeKey = "";
    var costCodeVrfyFlg = "";
    verifyKey = new Array();
    verifyKey_1 = new Array();
    verifyKey_2 = new Array();
    verifyKey_3 = new Array();
    verifyKey_4 = new Array();
    verifyKey_5 = new Array();
    verifyKey_6 = new Array();
    verifyKey_7 = new Array();
    verifyKey_8 = new Array();
    verifyKey_9 = new Array();
    verifyKey_10 = new Array();
    var costCount = 0;
    var countkey = 0;
    costCodeNcount = new Array();
    /**
    for(i=1;i<k;i++){
    		if(costCodeKey ==""){
    			costCodeKey=sheetObjects[2].GetCellValue(i+2, sheetNo+"lgs_cost_cd");
    			costCodeVrfyFlg=sheetObjects[2].GetCellValue(i+2, sheetNo+"vrfyflg");
    		}
    		if(sheetObjects[2].GetCellValue(i+3, sheetNo+"lgs_cost_cd")!=""){
    			if(sheetObjects[2].GetCellValue(i+2, sheetNo+"lgs_cost_cd") == sheetObjects[2].GetCellValue(i+3, sheetNo+"lgs_cost_cd")){
    						costCount++;
    			}else if(sheetObjects[2].GetCellValue(i+2, sheetNo+"lgs_cost_cd") != sheetObjects[2].GetCellValue(i+3, sheetNo+"lgs_cost_cd")){
    						costCodeNcount[countkey]=costCodeKey+"#"+(costCount+1)+"#"+costCodeVrfyFlg;
    						countkey++;
    						costCodeKey="";
    						costCodeVrfyFlg="";
    						costCount=0;
    				}
    		}else{
    				break;
    		}
    }
    **/
    for (i = 1; i < k; i++) {
        if (sheetObjects[2].GetCellValue(i + 2, sheetNo + "auto_calc_flg") == "Y") {
            if (costCodeKey == "") {
                costCodeKey = sheetObjects[2].GetCellValue(i + 2, sheetNo + "lgs_cost_cd");
                costCodeVrfyFlg = sheetObjects[2].GetCellValue(i + 2, sheetNo + "vrfyflg");
            }
            if (sheetObjects[2].GetCellValue(i + 3, sheetNo + "lgs_cost_cd") != "") {
                if (sheetObjects[2].GetCellValue(i + 2, sheetNo + "lgs_cost_cd") == sheetObjects[2].GetCellValue(i + 3, sheetNo + "lgs_cost_cd")) {
                    costCount++;
                } else if (sheetObjects[2].GetCellValue(i + 2, sheetNo + "lgs_cost_cd") != sheetObjects[2].GetCellValue(i + 3, sheetNo + "lgs_cost_cd")) {
                    costCodeNcount[countkey] = costCodeKey + "#" + (costCount + 1) + "#" + costCodeVrfyFlg;
                    countkey++;
                    costCodeKey = "";
                    costCodeVrfyFlg = "";
                    costCount = 0;
                }
            } else {
                break;
            }
        }
    }
    var rowStatus = new Array();
    var errCount = 0;
    var totalErrCount = 0;
    var local_count = 0;
    var startRow = 0;
    var lastRow = 0;
    for (var ii = 0; ii < costCodeNcount.length; ii++) {
        var cost_code = "";
        var cost_code_flg = "";
        cost_code = costCodeNcount[ii].split("#");
        cost_code_flg = cost_code[2].split("|");
        for (j = 0; j < cost_code[1]; j++) {
            // tml_dcgo_aply_flg
            if (cost_code_flg[6] == "Y") {
                verifyKey_1[j] = sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "auto_calc_flg")
                    //+"|"+ sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd")
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_cntr_sty_cd") //추가 2015.0403
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sub_trd_cd") //추가 2015.0403					
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "thc_tp_cd") + "," + (local_count + 3);
            }
            // tml_aply_dt_flg
            if (cost_code_flg[4] == "Y") {
                verifyKey_2[j] = sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "auto_calc_flg")
                    //+"|"+ sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd")
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_cntr_sty_cd") //추가 2015.0403									
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sub_trd_cd") //추가 2015.0403
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "thc_tp_cd");
            }
            // tml_io_bnd_flg
            if (cost_code_flg[2] == "Y") {
                verifyKey_3[j] = sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_cntr_sty_cd") //추가 2015.0403					
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sub_trd_cd") //추가 2015.0403
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "thc_tp_cd");
            }
            // tml_ioc_flg
            if (cost_code_flg[3] == "Y") {
                verifyKey_4[j] = sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "auto_calc_flg") //+"|"+ sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd")
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_cntr_sty_cd") //추가 2015.0403
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sub_trd_cd") //추가 2015.0403
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "thc_tp_cd");
            }
            // tml_lane_flg
            if (cost_code_flg[5] == "Y") {
                verifyKey_5[j] = sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "auto_calc_flg")
                    //+"|"+ sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd")
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_cntr_sty_cd") //추가 2015.0403
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sub_trd_cd") //추가 2015.0403
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "thc_tp_cd");
            }
            // tml_thc_flg
            if (cost_code_flg[9] == "Y") {
                verifyKey_6[j] = sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "auto_calc_flg")
                    //+"|"+ sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd")
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_cntr_sty_cd") //추가 2015.0403
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sub_trd_cd") //추가 2015.0403
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_ovt_shft_cd");
            }
            // tml_tr_vol_flg
            if (cost_code_flg[7] == "Y") {
                verifyKey_7[j] = sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "auto_calc_flg")
                    //+"|"+ sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd")
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_cntr_sty_cd") //추가 2015.0403
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sub_trd_cd") //추가 2015.0403
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "thc_tp_cd");
            }
            // tml_trns_mod_flg
            if (cost_code_flg[25] == "Y") {
                verifyKey_8[j] = sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "auto_calc_flg")
                    //+"|"+ sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd")
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_cntr_sty_cd") //추가 2015.0403
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sub_trd_cd") //추가 2015.0403
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "thc_tp_cd")  + "," + (local_count + 3);
            }
            //tml_cntr_sty_cd
            if (cost_code_flg[26] == "Y") {
                verifyKey_9[j] = sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "auto_calc_flg")
                    //+"|"+ sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd")
                    //					+ "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "io_bnd_cd")
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sub_trd_cd") //추가 2015.0403
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "lane_cd")
                    //					+ "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dg_none")
                    //					+ "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "same_dg_none")
                    //					+ "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "same_dg")
                    //					+ "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sep_dg_none")
                    //					+ "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg")
                    //					+ "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg")
                    //					+ "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg")
                    //					+ "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg")
                    //					+ "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg")
                    //					+ "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg")
                    //					+ "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg")
                    //					+ "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg")
                    //					+ "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg")
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "thc_tp_cd");
            }

            //sub_trd_cd
            if (cost_code_flg[28] == "Y") {
                verifyKey_10[j] = sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_cntr_sty_cd") //추가 2015.0403
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "hol_flg")
                    //					+ "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sub_trd_cd")//추가 2015.0403
                    //					+ "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "lane_cd")
                    + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "thc_tp_cd");
            }

            local_count++;
        } // for (j = 0; j < cost_code[1]; j++) {



        if (ii == 0) {
            startRow = 3;
            lastRow = local_count + 2;
        } else if (ii > 0) {
            startRow = lastRow + 1;
            lastRow = local_count + 2;
        }
        for (jj = startRow; jj <= lastRow; jj++) {
            rowStatus[jj] = sheetObjects[2].GetCellValue(jj, sheetNo + "ibflag");
            //				alert(rowStatus[jj]);
        }

        if (errCount == 0) {
            // 20 : rt_cntr_tpsz_flg, 21 : rt_teu_flg, 22 : rt_bx_flg, 23 : rt_mv_flg
            if (cost_code_flg[20] == "Y" || cost_code_flg[21] == "Y" ||
                cost_code_flg[22] == "Y" || cost_code_flg[23] == "Y") {
                errCount = terminal_cntr_rate_verify(startRow, lastRow);
            }
        }

        if (errCount == 0) {
            // tml_dcgo_aply_flg
            if (cost_code_flg[6] == "Y") {
                errCount = terminal_dg_class_verify(verifyKey_1, startRow, lastRow) + errCount;
                for (jj = 0; jj < verifyKey_1.length; jj++) {
                    verifyKey_1 = Array();
                }
            }
        }
        if (errCount == 0) {
            // tml_thc_flg
            if (cost_code_flg[9] == "Y") {
                errCount = terminal_thc_verify(verifyKey_6, startRow, lastRow) + errCount;
                for (jj = 0; jj < verifyKey_6.length; jj++) {
                    verifyKey_6 = Array();
                }
            }
        }
        // tml_ovt_shft_flg
        if (cost_code_flg[8] == "Y") {
            //ovt_shft_verify(inputListData7, startRow, lastRow);
        }
        if (errCount == 0) {
            // tml_tr_vol_flg
            if (cost_code_flg[7] == "Y") { //alert("verifyKey_7==>"+verifyKey_7+ " startRow==>"+startRow+" lastRow==>"+lastRow);
                errCount = terminal_tr_vol_val_verify(verifyKey_7, startRow, lastRow) + errCount;
                for (jj = 0; jj < verifyKey_7.length; jj++) {
                    verifyKey_7 = Array();
                }
            }
        }
        //			if(errCount==0){
        //					if(cost_code_flg[6]=="Y"){
        //							errCount  = terminal_dg_class_verify(verifyKey_1, startRow, lastRow)+errCount;
        //							for(jj=0;jj<verifyKey_1.length;jj++){
        //				 					verifyKey_1 = Array();
        //				 			}
        //					}
        //			}
        if (errCount == 0) {
            // tml_lane_flg
            if (cost_code_flg[5] == "Y") {
                errCount = terminal_lane_cd_verify(verifyKey_5, startRow, lastRow) + errCount;
                for (jj = 0; jj < verifyKey_5.length; jj++) {
                    verifyKey_5 = Array();
                }
            }
        }
        if (errCount == 0) {
            // tml_aply_dt_flg
            if (cost_code_flg[4] == "Y") {
                errCount = terminal_aply_dy_verify(verifyKey_2, startRow, lastRow) + errCount;
                for (jj = 0; jj < verifyKey_2.length; jj++) {
                    verifyKey_2 = Array();
                }
            }
        }
        if (errCount == 0) {
            // tml_trns_mod_flg
            if (cost_code_flg[25] == "Y") {
                errCount = terminal_mode_verify(verifyKey_8, startRow, lastRow) + errCount;
                for (jj = 0; jj < verifyKey_8.length; jj++) {
                    verifyKey_8 = Array();
                }
            }
        }
        if (errCount == 0) {
            // tml_ioc_flg
            if (cost_code_flg[3] == "Y") {
                errCount = terminal_ioc_cd_verify(verifyKey_4, startRow, lastRow) + errCount;
                for (jj = 0; jj < verifyKey_4.length; jj++) {
                    verifyKey_4 = Array();
                }
            }
        }
        if (errCount == 0) {
            // tml_io_bnd_flg
            if (cost_code_flg[2] == "Y") {
                errCount = terminal_io_bnd_cd_verify(verifyKey_3, startRow, lastRow) + errCount;
                for (jj = 0; jj < verifyKey_3.length; jj++) {
                    verifyKey_3 = Array();
                }
            }
        }


        if (errCount == 0) {
            // tml_cntr_sty_cd
            if (cost_code_flg[26] == "Y") {
                errCount = terminal_cntr_sty_cd_verify2(verifyKey_9, startRow, lastRow) + errCount;
                for (jj = 0; jj < verifyKey_9.length; jj++) {
                    verifyKey_9 = Array();
                }
            }
        }

        if (errCount == 0) {
            // sub_trd_cd
            if (cost_code_flg[28] == "Y") {
                if ("" == sheetObjects[2].GetCellValue(local_count + 3, sheetNo + "sub_trd_cd")) {
                    sheetObjects[2].SetCellValue(local_count + 3, "3sub_trd_cd", "Sub Trade Column Error", 0);
                    sheetObjects[2].SetCellBackColor(local_count + 3, 1, "#FF0000");
                }

                errCount = terminal_sub_trd_cd_verify(verifyKey_10, startRow, lastRow) + errCount;
                for (jj = 0; jj < verifyKey_10.length; jj++) {
                    verifyKey_10 = Array();
                }

            }
        }


        for (jj = 0; jj < verifyKey_1.length; jj++) {
            verifyKey_1 = Array();
        }
        for (jj = 0; jj < verifyKey_2.length; jj++) {
            verifyKey_2 = Array();
        }
        for (jj = 0; jj < verifyKey_3.length; jj++) {
            verifyKey_3 = Array();
        }
        for (jj = 0; jj < verifyKey_4.length; jj++) {
            verifyKey_4 = Array();
        }
        for (jj = 0; jj < verifyKey_5.length; jj++) {
            verifyKey_5 = Array();
        }
        for (jj = 0; jj < verifyKey_6.length; jj++) {
            verifyKey_6 = Array();
        }
        for (jj = 0; jj < verifyKey_7.length; jj++) {
            verifyKey_7 = Array();
        }
        /**
			for(jj=0;jj<verifyKey_8.length;jj++){
					verifyKey_8=Array();
 			}
		   **/
        totalErrCount = errCount + totalErrCount;
        errCount = 0;
        for (jj = startRow; jj <= lastRow; jj++) {
            sheetObjects[2].SetRowStatus(jj, beforeibflag[jj - 3]);
            if (sheetObjects[2].GetCellValue(jj, sheetNo + "verify_result") == "") {
                sheetObjects[2].SetCellBackColor(jj, 1, "#0000FF");
            } else if (sheetObjects[2].GetCellValue(jj, sheetNo + "verify_result") != "") {
                sheetObjects[2].SetCellBackColor(jj, 1, "#FF0000");
            }
        }
        //rowStatus[jj] = Array();

    } // for (var ii = 0; ii < costCodeNcount.length; ii++) {


    sheetObjects[2].ColumnSort("3lgs_cost_cd|3io_bnd_cd|3ioc_cd|3tml_dy_aply_tp_cd|3sub_trd_cd|3lane_cd|3dcgo_aply_tp_cd|3tml_vol_aply_tp_cd|3tml_ovt_shft_cd|3thc_tp_cd|3tml_cntr_sty_cd|3fm_tr_vol_val|3to_tr_vol_val", "ASC", "DESC|ASC|ASC|ASC|ASC|ASC|ASC|ASC|ASC|ASC|ASC|ASC|ASC", 1);
    //		sheetObjects[2].ColumnSort("3lgs_cost_cd", "DESC");
    //		sheetObjects[2].ColumnSort("3lgs_cost_cd|3io_bnd_cd|3ioc_cd|3lane_cd|3fm_tr_vol_val|3to_tr_vol_val|3tml_ovt_shft_cd|3thc_tp_cd", "ASC");

    if (totalErrCount > 0) {
        return false;
    } else if (totalErrCount == 0) {
        for (var i = 1; i < k; i++) {
            if (sheetObjects[2].GetCellValue(i + 2, sheetNo + "auto_calc_flg") == "N") {
                sheetObjects[2].SetRowStatus(i + 2, beforeibflag[i - 1]);
                sheetObjects[2].SetCellBackColor(i + 2, 1, "#0000FF");
            }
        }
        return true;
    }
    totalErrCount = 0;

}


/**
 * 
 * @param verifyKey_10
 * @param startRow
 * @param lastRow
 * @returns
 */
function terminal_sub_trd_cd_verify(verifyKey_10, startRow, lastRow) {
    var i;
    var j = 0;
    var sheetNo = 3;
    var dupkey = new Array();
    var dupTempKey = "";
    for (i = 0; i < verifyKey_10.length; i++) {
        if (i == 0) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_10[i];
            j++
        }
        if (dupTempKey != verifyKey_10[i]) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_10[i];
            j++;
        }
    }
    var dupString = new Array();
    var dupStringSheet = new Array();
    var dupStringKey = new Array();
    var seqDupRowKey = new Array();
    var err_count = 0;

    for (i = 0; i < dupkey.length; i++) {
        dupString[i] = sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_cntr_sty_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "hol_flg")
            //						+ "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sub_trd_cd")
            //						+ "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lane_cd")
            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "thc_tp_cd");
        k = 0;
        for (var j = startRow; j <= lastRow; j++) {
            dupStringSheet[j] = sheetObjects[2].GetCellValue(j, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_cntr_sty_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "hol_flg")
                //								+ "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sub_trd_cd")
                //								+ "|" + sheetObjects[2].GetCellValue(j, sheetNo + "lane_cd")
                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "thc_tp_cd");

            if (dupString[i] == dupStringSheet[j]) {
                k++;
                dupStringKey[j] = sheetObjects[2].GetCellValue(j, sheetNo + "sub_trd_cd");
            } else {
                k++;
                dupStringKey[j] = "";
            }
        }

        err_count = err_count + terminal_sub_trd_cd_fun(dupStringKey, startRow);
        dupStringKey = Array();
    }
    return err_count;
}

/** terminal_sub_trd_cd_fun
 * 
 * @param dupStringKey
 * @param startRow
 * @returns {Number}
 */
function terminal_sub_trd_cd_fun(dupStringKey, startRow) {
    var err_count = 0;
    var inputString = "";
    var tempArray = new Array();
    tempArray[0] = "";
    tempArray[1] = "";
    tempArray[2] = "";
    var j = 0;
    //subTrdSheet
    var originalSubTrdCd = "";
    var inputSubTrdCd = "";
    var sameCodeCount = 0;
    var inputSubTrdString = "";
    var originalSubTrdString = "";
    for (var i = startRow; i < dupStringKey.length; i++) {
        if (dupStringKey[i] != "") {
            if (dupStringKey[i] == "S") {
                tempArray[0] = "S"
            } else if (dupStringKey[i] == "O") {
                tempArray[1] = "O"
            } else if (dupStringKey[i] != "S" && dupStringKey[i] != "O" && dupStringKey[i] != "") {
                tempArray[2] = "L"
                inputString = dupStringKey[i] + "|" + inputString;
            } else {
                tempArray[0] = "";
                tempArray[1] = "";
                tempArray[2] = "";
            }
        }
    }
    if (tempArray[0] == "S" && tempArray[1] == "" && tempArray[2] == "") {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    } else if (tempArray[0] == "" && tempArray[1] == "O" && tempArray[2] == "L") {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    } else if (tempArray[0] == "" && tempArray[1] == "" && tempArray[2] == "L") {
        originalSubTrdCd = subTrdSheet.split("|");
        inputSubTrdCd = inputString.split("|");
        for (var i = 0; i < inputSubTrdCd.length; i++) {
            for (j = 2; j < originalSubTrdCd.length; j++) {
                if (inputSubTrdCd[i] == originalSubTrdCd[j]) {
                    inputSubTrdCd[i] = "";
                    originalSubTrdCd[j] = "";
                }
            }
        }
        for (var i = 0; i < inputSubTrdCd.length; i++) {
            inputSubTrdString = inputSubTrdString + inputSubTrdCd[i];
        }
        for (j = 2; j < originalSubTrdCd.length; j++) {
            originalSubTrdString = originalSubTrdString + originalSubTrdCd[j];
        }
        if (inputSubTrdString == "" && originalSubTrdString == "") {
            for (var i = startRow; i < dupStringKey.length; i++) {
                if (dupStringKey[i] != "") {
                    sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                    sheetObjects[2].SetCellBackColor(i, 1, "#0000FF");
                }
            }
        } else {
            for (var i = startRow; i < dupStringKey.length; i++) {
                //					sheetObjects[2].SetCellValue(i,"3verify_result","Sub Trade Column Error",0);
                //					sheetObjects[2].SetCellBackColor(i,1,"#FF0000");

                if (dupStringKey[i] != "") {
                    sheetObjects[2].SetCellValue(i, "3verify_result", "Sub Trade Column Error", 0);
                    sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");
                    err_count++;
                }

            }
        }
    } else {
        for (var i = startRow; i < dupStringKey.length; i++) {
            //				sheetObjects[2].SetCellValue(i,"3verify_result","Sub Trade Column Error",0);
            //				sheetObjects[2].SetCellBackColor(i,1,"#FF0000");

            if (dupStringKey[i] != "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "Sub Trade Column Error", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");
                err_count++;
            }

        }
    }

    return err_count;
}


/**
 * 
 * @param verifyKey_10
 * @param startRow
 * @param lastRow
 * @returns
 */
function terminal_cntr_sty_cd_verify2(verifyKey_9, startRow, lastRow) {
    var i;
    var j = 0;
    var sheetNo = 3;
    var dupkey = new Array();
    var dupTempKey = "";
    for (i = 0; i < verifyKey_9.length; i++) {
        if (i == 0) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_9[i];
            j++
        }
        if (dupTempKey != verifyKey_9[i]) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_9[i];
            j++;
        }
    }
    var dupString = new Array();
    var dupStringSheet = new Array();
    var dupStringKey = new Array();
    var seqDupRowKey = new Array();
    var err_count = 0;

    for (i = 0; i < dupkey.length; i++) {
        dupString[i] = sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "auto_calc_flg")
            //						+ "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "io_bnd_cd")
            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sub_trd_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lane_cd")
            //						+ "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dg_none")
            //						+ "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "same_dg_none")
            //						+ "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "same_dg")
            //						+ "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sep_dg_none")
            //						+ "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n1st_clss_flg")
            //						+ "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n2nd_clss_flg")
            //						+ "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n3rd_clss_flg")
            //						+ "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n4th_clss_flg")
            //						+ "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n5th_clss_flg")
            //						+ "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n6th_clss_flg")
            //						+ "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n7th_clss_flg")
            //						+ "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n8th_clss_flg")
            //						+ "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n9th_clss_flg")
            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "thc_tp_cd");

        k = 0;
        for (var j = startRow; j <= lastRow; j++) {
            dupStringSheet[j] = sheetObjects[2].GetCellValue(j, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "auto_calc_flg")
                //								+ "|" + sheetObjects[2].GetCellValue(j, sheetNo + "io_bnd_cd")
                + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sub_trd_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "lane_cd")
                //								+ "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dg_none")
                //								+ "|" + sheetObjects[2].GetCellValue(j, sheetNo + "same_dg_none")
                //								+ "|" + sheetObjects[2].GetCellValue(j, sheetNo + "same_dg")
                //								+ "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sep_dg_none")
                //								+ "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n1st_clss_flg")
                //								+ "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n2nd_clss_flg")
                //								+ "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n3rd_clss_flg")
                //								+ "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n4th_clss_flg")
                //								+ "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n5th_clss_flg")
                //								+ "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n6th_clss_flg")
                //								+ "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n7th_clss_flg")
                //								+ "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n8th_clss_flg")
                //								+ "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n9th_clss_flg")
                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "thc_tp_cd");

            if (dupString[i] == dupStringSheet[j]) {
                k++;
                dupStringKey[j] = sheetObjects[2].GetCellValue(j, sheetNo + "tml_cntr_sty_cd");
            } else {
                k++;
                dupStringKey[j] = "";
            }
        }

        err_count = err_count + terminal_cntr_sty_cd_fun2(dupStringKey, startRow);
        dupStringKey = Array();
    }
    return err_count;
}

/** terminal_sub_trd_cd_fun
 * 
 * @param dupStringKey
 * @param startRow
 * @returns {Number}
 */
function terminal_cntr_sty_cd_fun2(dupStringKey, startRow) {
    var err_count = 0;
    var inputString = "";
    var tempArray = new Array();
    tempArray[0] = "";
    tempArray[1] = "";
    tempArray[2] = "";
    var j = 0;
    //subTrdSheet
    var originalSubTrdCd = "";
    var inputSubTrdCd = "";
    var sameCodeCount = 0;
    var inputSubTrdString = "";
    var originalSubTrdString = "";
    for (var i = startRow; i < dupStringKey.length; i++) {
        if (dupStringKey[i] != "") {
            if (dupStringKey[i] == "S") {
                tempArray[0] = "S"
            } else if (dupStringKey[i] == "F") {
                tempArray[1] = "F"
            } else if (dupStringKey[i] != "S" && dupStringKey[i] != "F" && dupStringKey[i] != "") {
                tempArray[2] = "M"
                inputString = dupStringKey[i] + "|" + inputString;
            } else {
                tempArray[0] = "";
                tempArray[1] = "";
                tempArray[2] = "";
            }
        }
    }
    if (tempArray[0] == "S" && tempArray[1] == "" && tempArray[2] == "") {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    } else if (tempArray[0] == "" && tempArray[1] == "F" && tempArray[2] == "M") {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    } else {
        for (var i = startRow; i < dupStringKey.length; i++) {
            sheetObjects[2].SetCellValue(i, "3verify_result", "F/M Column Error", 0);
            sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");

            if (dupStringKey[i] != "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "F/M Trade Column Error", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");
                err_count++;
            }

        }
    }

    return err_count;
}

/**
 * 
 * @param dupStringKey
 * @param startRow
 * @returns {Number}
 */
//	function terminal_sub_trd_cd_fun(dupStringKey, startRow){
//		var inputString="";
//		var err_count=0;
//		for(var i=startRow; i < dupStringKey.length; i++) {
//			if(dupStringKey[i] != "") {
//				inputString=inputString + dupStringKey[i];
//			}
//		}
//		
//		if(inputString.indexOf("s")==-1) {//Same 이 없으면서
//			if(inputString.indexOf("o")==-1){//OTH 없으면 
//				err_count=1;
//			}else{//OTH 있으면서 다른것도 있어야 한다.
//				err_count=1;
//				for(var g=0; g<inputString.length; g++){
//					if("o" != inputString.charAt(g)){
//						err_count=0;
//					}
//				}
//			}
//			
//		}else if(inputString.indexOf("s")>-1) {//Same이 있으면서
//			for(var h=0; h<inputString.length; h++){
//				if("s" != inputString.charAt(h)){
//					err_count=1;
//				}
//			}
//			
//		} else {
//			err_count=1;
//			
//		}
//		
//		if(err_count > 0) {
//			err_count=0;
//			for(var i=startRow; i < dupStringKey.length; i++) {
//				if(dupStringKey[i] != "") {
//					sheetObjects[2].SetCellValue(i,"3verify_result","Sub Trade Column Error",0);
//					sheetObjects[2].SetCellBackColor(i,1,"#FF0000");
//					err_count++;
//				}
//			}
//		} else if(err_count == 0) {
//			for(var i=startRow; i < dupStringKey.length; i++) {
//				if(dupStringKey[i] != "") {
//					sheetObjects[2].SetCellValue(i,"3verify_result","",0);
//					sheetObjects[2].SetCellBackColor(i,1,"#0000FF");
//				}
//			}
//		}
//		return err_count;
//	}

/**
 * 
 * @param verifyKey_9
 * @param startRow
 * @param lastRow
 * @returns
 */
function terminal_cntr_sty_cd_verify(verifyKey_9, startRow, lastRow) {
    var i;
    var j = 0;
    var sheetNo = 3;
    var dupkey = new Array();
    var dupTempKey = "";
    for (i = 0; i < verifyKey_9.length; i++) {
        if (i == 0) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_9[i];
            j++
        }
        if (dupTempKey != verifyKey_9[i]) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_9[i];
            j++;
        }
    }
    var dupString = new Array();
    var dupStringSheet = new Array();
    var dupStringKey = new Array();
    var seqDupRowKey = new Array();
    var err_count = 0;

    for (i = 0; i < dupkey.length; i++) {
        dupString[i] = sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sub_trd_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "thc_tp_cd");
        k = 0;
        for (var j = startRow; j <= lastRow; j++) {
            dupStringSheet[j] = sheetObjects[2].GetCellValue(j, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sub_trd_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "thc_tp_cd");

            if (dupString[i] == dupStringSheet[j]) {
                k++;
                dupStringKey[j] = sheetObjects[2].GetCellValue(j, sheetNo + "tml_cntr_sty_cd");
            } else {
                k++;
                dupStringKey[j] = "";
            }
        }

        err_count = err_count + terminal_cntr_sty_cd_fun(dupStringKey, startRow);
        dupStringKey = Array();
    }
    return err_count;
}

function terminal_cntr_sty_cd_fun(dupStringKey, startRow) {
    var inputString = "";
    var err_count = 0;
    for (var i = startRow; i < dupStringKey.length; i++) {
        if (dupStringKey[i] != "") {
            inputString = inputString + dupStringKey[i];
        }
    }
    if (inputString == "S" || inputString == "FM" || inputString == "MF") {
        err_count = 0;
    } else {
        err_count = 1;
    }

    if (err_count > 0) {
        err_count = 0;
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "F/M Column Error", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");
                err_count++;
            }
        }
    } else if (err_count == 0) {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    }
    return err_count;
}
/**
 * Terminal Rate List Tab Thc Data Verify. <br>
 * @param{verifyKey_6}	verifyKey_6	verifyKey_6
 * @param{startRow}		startRow	startRow
 * @param{lastRow}		lastRow		lastRow
 **/
function terminal_thc_verify(verifyKey_6, startRow, lastRow) {
    var i;
    var j = 0;
    var sheetNo = 3;
    var dupkey = new Array();
    var dupTempKey = "";
    for (i = 0; i < verifyKey_6.length; i++) {
        if (i == 0) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_6[i];
            j++
        }
        if (dupTempKey != verifyKey_6[i]) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_6[i];
            j++;
        }
    }
    var dupString = new Array();
    var dupStringSheet = new Array();
    var dupStringKey = new Array();
    var seqDupRowKey = new Array();
    var k = 0;
    var err_count = 0;

    for (i = 0; i < dupkey.length; i++) {
        dupString[i] = sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_cntr_sty_cd") //20150408 추가
            //+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo + "tml_agmt_vol_ut_cd")
            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sub_trd_cd") //20150408 추가
            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_ovt_shft_cd");
        k = 0;
        for (var j = startRow; j <= lastRow; j++) {
            dupStringSheet[j] = sheetObjects[2].GetCellValue(j, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_cntr_sty_cd")
                //+"|"+ sheetObjects[2].CellValue(j, sheetNo + "tml_agmt_vol_ut_cd")
                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sub_trd_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_ovt_shft_cd");
            //if(j!=dupkey[i]){
            if (dupString[i] == dupStringSheet[j]) {
                k++;
                dupStringKey[j] = sheetObjects[2].GetCellValue(j, sheetNo + "thc_tp_cd");
            } else {
                k++;
                dupStringKey[j] = "";
            }
            //}
        }
        err_count = err_count + terminal_thcVerifyFun(dupStringKey, startRow);
        dupStringKey = Array();
    }
    return err_count;
}
/**
 * Terminal Rate List Tab Thc Data Verify. <br>
 * @param{dupStringKey}		dupStringKey	dupStringKey
 * @param{startRow}			startRow		startRow
 **/
function terminal_thcVerifyFun(dupStringKey, startRow) {
    var inputString = "";
    var err_count = 0;
    for (var i = startRow; i < dupStringKey.length; i++) {
        if (dupStringKey[i] != "") {
            inputString = inputString + dupStringKey[i];
        }
    }
    if (inputString == "GL" || inputString == "LG" || inputString == "T") {
        err_count = 0;
    } else {
        err_count = 1;
    }
    if (err_count > 0) {
        err_count = 0;
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "THC Column Error", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");
                err_count++;
            }
        }
    } else if (err_count == 0) {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    }
    return err_count;
}
/**
 * Terminal Rate List Tab Io Bound Code Data Verify. <br>
 * @param{verifyKey_3}	verifyKey_3	verifyKey_3
 * @param{startRow}		startRow	startRow
 * @param{lastRow}		lastRow		lastRow
 **/
function terminal_io_bnd_cd_verify(verifyKey_3, startRow, lastRow) {
    var i;
    var j = 0;
    var sheetNo = 3;
    var dupkey = new Array();
    var dupTempKey = "";
    for (i = 0; i < verifyKey_3.length; i++) {
        if (i == 0) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_3[i];
            j++
        }
        if (dupTempKey != verifyKey_3[i]) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_3[i];
            j++;
        }
    }
    var dupString = new Array();
    var dupStringSheet = new Array();
    var dupStringKey = new Array();
    var seqDupRowKey = new Array();
    var err_count = 0;

    for (i = 0; i < dupkey.length; i++) {
        dupString[i] = sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_cntr_sty_cd")
            //+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo + "tml_agmt_vol_ut_cd")
            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sub_trd_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "thc_tp_cd");
        k = 0;
        for (var j = startRow; j <= lastRow; j++) {
            dupStringSheet[j] = sheetObjects[2].GetCellValue(j, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_cntr_sty_cd")
                //+"|"+ sheetObjects[2].CellValue(j, sheetNo + "tml_agmt_vol_ut_cd")
                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sub_trd_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "thc_tp_cd");
            if (dupString[i] == dupStringSheet[j]) {
                k++;
                dupStringKey[j] = sheetObjects[2].GetCellValue(j, sheetNo + "io_bnd_cd");
            } else {
                k++;
                dupStringKey[j] = "";
            }
        }
        err_count = err_count + terminal_ioBoundFun(dupStringKey, startRow);
        dupStringKey = Array();
    }
    return err_count;
}
/**
 * Terminal Rate List Tab Io Bound Data Verify. <br>
 * @param{dupStringKey}		dupStringKey	dupStringKey
 * @param{startRow}			startRow		startRow
 **/
function terminal_ioBoundFun(dupStringKey, startRow) {
    var inputString = "";
    var err_count = 0;
    for (var i = startRow; i < dupStringKey.length; i++) {
        if (dupStringKey[i] != "") {
            inputString = inputString + dupStringKey[i];
        }
    }
    if (inputString == "S" || inputString == "IO" || inputString == "OI") {
        err_count = 0;
    } else {
        err_count = 1;
    }
    if (err_count > 0) {
        err_count = 0;
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "IO Bound Column Error", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");
                err_count++;
            }
        }
    } else if (err_count == 0) {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    }
    return err_count;
}
/**
 * Terminal Rate List Tab Ioc Code Data Verify. <br>
 * @param{verifyKey_4}	verifyKey_4	verifyKey_4
 * @param{startRow}		startRow	startRow
 * @param{lastRow}		lastRow		lastRow
 **/
function terminal_ioc_cd_verify(verifyKey_4, startRow, lastRow) {
    var i;
    var j = 0;
    var sheetNo = 3;
    var dupkey = new Array();
    var dupTempKey = "";
    for (i = 0; i < verifyKey_4.length; i++) {
        if (i == 0) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_4[i];
            j++
        }
        if (dupTempKey != verifyKey_4[i]) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_4[i];
            j++;
        }
    }
    var dupString = new Array();
    var dupStringSheet = new Array();
    var dupStringKey = new Array();
    var seqDupRowKey = new Array();
    var err_count = 0;

    for (i = 0; i < dupkey.length; i++) {
        dupString[i] = sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_cntr_sty_cd")
            //+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo + "tml_agmt_vol_ut_cd")
            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sub_trd_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "thc_tp_cd");
        k = 0;
        for (var j = startRow; j <= lastRow; j++) {
            dupStringSheet[j] = sheetObjects[2].GetCellValue(j, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_cntr_sty_cd")
                //+"|"+ sheetObjects[2].CellValue(j, sheetNo + "tml_agmt_vol_ut_cd")			
                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sub_trd_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "thc_tp_cd");
            if (dupString[i] == dupStringSheet[j]) {
                k++;
                dupStringKey[j] = sheetObjects[2].GetCellValue(j, sheetNo + "ioc_cd");
            } else {
                k++;
                dupStringKey[j] = "";
            }
        }
        err_count = err_count + terminal_iocFun(dupStringKey, startRow);
        dupStringKey = Array();
    }
    return err_count;
}
/**
 * Terminal Rate List Tab Ioc Code Data Verify. <br>
 * @param{startRow}		startRow	startRow
 * @param{dupStringKey}		dupStringKey	dupStringKey
 **/
function terminal_iocFun(dupStringKey, startRow) {
    var inputString = "";
    var err_count = 0;
    for (var i = startRow; i < dupStringKey.length; i++) {
        if (dupStringKey[i] != "") {
            inputString = inputString + dupStringKey[i];
        }
    }
    if (inputString == "S" || inputString == "IO" || inputString == "OI") {
        err_count = 0;
    } else {
        err_count = 1;
    }
    if (err_count > 0) {
        err_count = 0;
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "IPC/Ocean Column Error", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");
                err_count++;
            }
        }
    } else if (err_count == 0) {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    }
    return err_count;
}
/**
 * Terminal Rate List Tab Mode Data Verify. <br>
 * @param{verifyKey_8}	verifyKey_8	verifyKey_8
 * @param{startRow}		startRow	startRow
 * @param{lastRow}		lastRow		lastRow
 **/
function terminal_mode_verify(verifyKey_8, startRow, lastRow) {
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    // MODE 관련 Check Logic 수정 
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    var err_count = 0;
    var iVerifyRow = 0; 
    var sDupString = "";
    var aTemp = new Array();    
    var sVerifyKey = new Array();
    
    for(var i=0 ; i < verifyKey_8.length; i++){	 
    	var aVerifyFlg = ["", ""];
    	
    	sVerifyKey = verifyKey_8[i].split(",");     
    	aTemp = sVerifyKey[0].split("|");
    	iVerifyRow = sVerifyKey[1]; 
    	
		for(var j=sheetObjects[2].HeaderRows() ; j<sheetObjects[2].HeaderRows() + sheetObjects[2].RowCount(); j++){
			sDupString = sheetObjects[2].GetCellValue(j, "3lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(j, "3auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(j, "3tml_cntr_sty_cd")
			            //+"|"+ sheetObjects[2].CellValue(j, "3tml_agmt_vol_ut_cd")
			            + "|" + sheetObjects[2].GetCellValue(j, "3io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(j, "3ioc_cd") + "|" + sheetObjects[2].GetCellValue(j, "3wkdy_flg") 
			            + "|" + sheetObjects[2].GetCellValue(j, "3sat_flg") + "|" + sheetObjects[2].GetCellValue(j, "3sun_flg") + "|" + sheetObjects[2].GetCellValue(j, "3hol_flg") 
			            + "|" + sheetObjects[2].GetCellValue(j, "3sub_trd_cd") + "|" + sheetObjects[2].GetCellValue(j, "3lane_cd") + "|" + sheetObjects[2].GetCellValue(j, "3dg_none") 
			            + "|" + sheetObjects[2].GetCellValue(j, "3same_dg_none") + "|" + sheetObjects[2].GetCellValue(j, "3same_dg") + "|" + sheetObjects[2].GetCellValue(j, "3sep_dg_none") 
			            + "|" + sheetObjects[2].GetCellValue(j, "3dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, "3dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, "3dcgo_n3rd_clss_flg") 
			            + "|" + sheetObjects[2].GetCellValue(j, "3dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, "3dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, "3dcgo_n6th_clss_flg") 
			            + "|" + sheetObjects[2].GetCellValue(j, "3dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, "3dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, "3dcgo_n9th_clss_flg") 
			            + "|" + sheetObjects[2].GetCellValue(j, "3fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, "3to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, "3tml_ovt_shft_cd") 
			            + "|" + sheetObjects[2].GetCellValue(j, "3thc_tp_cd");
            
            if (sheetObjects[2].GetCellValue(j, "3verify_result") == "") {    
            	sheetObjects[2].SetCellBackColor(j, 1, "#0000FF");
            }
                
    		if(sVerifyKey[0] == sDupString){		    	
    			if(aVerifyFlg[0] == "" && sheetObjects[2].GetCellValue(j, "3tml_trns_mod_cd") == "S"){
    				aVerifyFlg[0] = sheetObjects[2].GetCellValue(j, "3tml_trns_mod_cd");
    			} else if(aVerifyFlg[0] != "S" && sheetObjects[2].GetCellValue(j, "3tml_trns_mod_cd") != "S"){
    				aVerifyFlg[1] = "L";
    			}		    			
				    	
    		}  // if(verifyKey_1[i] == sDupString){ end
		}  // for(var j=sheetObjects[2].HeaderRows() ; j<sheetObjects[2].HeaderRows() + sheetObjects[2].RowCount(); j++){ end       
		
		if (aVerifyFlg[0] == "S" && aVerifyFlg[1] == "") {	        
            if (sheetObjects[2].GetCellValue(iVerifyRow, "3verify_result") == "") {
                sheetObjects[2].SetCellValue(iVerifyRow, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(iVerifyRow, 1, "#0000FF");
            }
	        
	    } else if (aVerifyFlg[0] == "" && aVerifyFlg[1] == "L") {
            if (sheetObjects[2].GetCellValue(iVerifyRow, "3verify_result") == "") {
                sheetObjects[2].SetCellValue(iVerifyRow, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(iVerifyRow, 1, "#0000FF");
            }
	    } else {
            sheetObjects[2].SetCellValue(iVerifyRow, "3verify_result", "Mode Column Error", 0);
            sheetObjects[2].SetCellBackColor(iVerifyRow, 1, "#FF0000");
            err_count++;
	    }    
	    
    }  // for(var i=0 ; i<verifyKey_1.length; i++){	
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
//    var i;
//    var j = 0;
//    var sheetNo = 3;
//    var dupkey = new Array();
//    var dupTempKey = "";
//    for (i = 0; i < verifyKey_8.length; i++) {
//        if (i == 0) {
//            dupkey[j] = i + startRow;
//            dupTempKey = verifyKey_8[i];
//            j++
//        }
//        if (dupTempKey != verifyKey_8[i]) {
//            dupkey[j] = i + startRow;
//            dupTempKey = verifyKey_8[i];
//            j++;
//        }
//    }
//    var dupString = new Array();
//    var dupStringSheet = new Array();
//    var dupStringKey = new Array();
//    var seqDupRowKey = new Array();
//    var err_count = 0;
//
//    for (i = 0; i < dupkey.length; i++) {
//        dupString[i] = sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_cntr_sty_cd")
//            //+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo + "tml_agmt_vol_ut_cd")
//            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "wkdy_flg") 
//            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "hol_flg") 
//            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sub_trd_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dg_none") 
//            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sep_dg_none") 
//            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n3rd_clss_flg") 
//            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n6th_clss_flg") 
//            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n9th_clss_flg") 
//            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_ovt_shft_cd") 
//            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "thc_tp_cd");
//        k = 0;
//        for (var j = startRow; j <= lastRow; j++) {
//            dupStringSheet[j] = sheetObjects[2].GetCellValue(j, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_cntr_sty_cd")
//                //+"|"+ sheetObjects[2].CellValue(j, sheetNo + "tml_agmt_vol_ut_cd")
//                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "wkdy_flg") 
//                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "hol_flg") 
//                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sub_trd_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dg_none") 
//                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sep_dg_none") 
//                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n3rd_clss_flg") 
//                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n6th_clss_flg") 
//                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n9th_clss_flg") 
//                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_ovt_shft_cd") 
//                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "thc_tp_cd");
//            if (dupString[i] == dupStringSheet[j]) {
//                k++;
//                dupStringKey[j] = sheetObjects[2].GetCellValue(j, sheetNo + "tml_trns_mod_cd");
//            } else {
//                k++;
//                dupStringKey[j] = "";
//            }
//        }
//        err_count = err_count + terminal_modeFun(dupStringKey, startRow, sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lgs_cost_cd"));
//        dupStringKey = Array();
//    }
    return err_count;
}
/**
 * Terminal Rate List Tab Mode Data Verify. <br>
 * @param{dupStringKey}		dupStringKey	dupStringKey
 * @param{startRow}			startRow	startRow
 * @param{lgsCostCd}		lgsCostCd	lgsCostCd
 **/
function terminal_modeFun(dupStringKey, startRow, lgsCostCd) {
    var err_count = 0;
    var inputString = "";
    var tempArray = new Array();
    tempArray[0] = "";
    tempArray[1] = "";
    tempArray[2] = "";
    var j = 0;
    var originalModeCd = "";
    var inputModeCd = "";
    var inputModeString = "";
    var originalModeString = "";
    for (var i = startRow; i < dupStringKey.length; i++) {
        if (dupStringKey[i] != "") {
            //					if(dupStringKey[i]=="S"){
            //							tempArray[0] = "S"
            //					}else if(dupStringKey[i]=="O"){
            //							tempArray[1] = "O"
            //					}else if(dupStringKey[i]!="S" && dupStringKey[i]!="O" && dupStringKey[i]!=""){
            //							tempArray[2] = "L"
            //							inputString = dupStringKey[i]+"|"+inputString;
            //					}else{
            //							tempArray[0] = "";
            //							tempArray[1] = "";
            //							tempArray[2] = "";
            //					}
            if (dupStringKey[i] == "S") {
                tempArray[0] = "S"
            } else if (dupStringKey[i] != "S" && dupStringKey[i] != "") {
                tempArray[1] = "L"
            } else {
                tempArray[0] = "";
                tempArray[1] = "";
            }
        }
    }
    if (tempArray[0] == "S" && tempArray[1] == "") {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    } else if (tempArray[0] == "" && tempArray[1] == "L") {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    } else {
        for (var i = startRow; i < dupStringKey.length; i++) {
            sheetObjects[2].SetCellValue(i, "3verify_result", "Mode Column Error", 0);
            sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");
            err_count++;
        }
    }
    //	if(tempArray[0]=="S" && tempArray[1] == "" && tempArray[2] == ""){
    //			for(var i=startRow;i<dupStringKey.length;i++){
    //					if(dupStringKey[i]!=""){
    //								sheetObjects[2].CellValue2(i,"3verify_result") = "";
    //								sheetObjects[2].CellBackColor(i,1) = "#0000FF";
    //					}
    //			}
    //	}else if(tempArray[0]=="" && tempArray[1] == "O" &&  tempArray[2] == "L"){
    //			for(var i=startRow;i<dupStringKey.length;i++){
    //					if(dupStringKey[i]!=""){
    //								sheetObjects[2].CellValue2(i,"3verify_result") = "";
    //								sheetObjects[2].CellBackColor(i,1) = "#0000FF";
    //					}
    //			}
    //	}else if(tempArray[0]=="" && tempArray[1] == "" && tempArray[2] == "L"){
    //			originalModeCd  = " |S|T|R|B|F|V|O".split("|");
    //			inputModeCd = inputString.split("|");
    //			for(var i=0;i<inputModeCd.length;i++){
    //					for(j=2;j<originalModeCd.length;j++){
    //							if(inputModeCd[i]==originalModeCd[j]){
    //									inputModeCd[i]="";
    //									originalModeCd[j]="";
    //							}
    //					}
    //			}
    //
    //			for(var i=0;i<inputModeCd.length;i++){
    //					inputModeString  = inputModeString +inputModeCd[i];
    //			}
    //
    //			for(j=2;j<originalModeCd.length;j++){
    //					originalModeString  = originalModeString+originalModeCd [j];
    //			}
    //			
    //			for(var i=startRow;i<dupStringKey.length;i++){
    //					if(dupStringKey[i]!=""){
    //								sheetObjects[2].CellValue2(i,"3verify_result") = "";
    //								sheetObjects[2].CellBackColor(i,1) = "#0000FF";
    //					}
    //			}
    //			
    //			if(inputModeString=="" && originalModeString==""){
    //					for(var i=startRow;i<dupStringKey.length;i++){
    //							if(dupStringKey[i]!=""){
    //										sheetObjects[2].CellValue2(i,"3verify_result") = "";
    //										sheetObjects[2].CellBackColor(i,1) = "#0000FF";
    //							}
    //					}
    //			}else{
    //					for(var i=startRow;i<dupStringKey.length;i++){
    //							sheetObjects[2].CellValue2(i,"3verify_result") = "Mode Column Error";
    //							sheetObjects[2].CellBackColor(i,1) = "#FF0000";
    //							err_count++;
    //					}
    //			}
    //	}else {	    
    //			for(var i=startRow;i<dupStringKey.length;i++){
    //					sheetObjects[2].CellValue2(i,"3verify_result") = "Mode Column Error";
    //					sheetObjects[2].CellBackColor(i,1) = "#FF0000";
    //					err_count++;
    //			}
    //	}
    return err_count;
    //
    //		var inputString = "";
    //		var err_count = 0;
    //		for(var i=startRow;i<dupStringKey.length;i++){
    //				if(dupStringKey[i]!=""){
    //						inputString  = inputString + dupStringKey[i];
    //				}
    //		}
    //
    //		for(var i=startRow;i<dupStringKey.length;i++){
    //				if(sheetObjects[2].CellValue(i,"3lgs_cost_cd") == "TPNDFL" || sheetObjects[2].CellValue(i,"3lgs_cost_cd") == "SVLDFL" || sheetObjects[2].CellValue(i,"3lgs_cost_cd") == "TMNDFL" ){
    //						if(inputString=="S" || inputString == "TRS" || inputString == "TSR" || inputString == "STR" || inputString == "SRT" || inputString == "RTS" || inputString == "RST"){
    //								//err_count = 0;
    //						}else{
    //								//err_count = 1;
    //								err_count++;
    //						}
    ////				}else if(sheetObjects[2].CellValue(i,"3lgs_cost_cd") == "TPNDTS" || sheetObjects[2].CellValue(i,"3lgs_cost_cd") == "SVLDTS" || sheetObjects[2].CellValue(i,"3lgs_cost_cd") == "TMNDFL"){
    ////						if(inputString=="S" || inputString == "FV" || inputString == "VF"){
    //				}else if(sheetObjects[2].CellValue(i,"3lgs_cost_cd") == "TPNDTS" || sheetObjects[2].CellValue(i,"3lgs_cost_cd") == "SVLDTS" || sheetObjects[2].CellValue(i,"3lgs_cost_cd") == "TMNDTS"){
    //						if(inputString=="S" || inputString == "FV" || inputString == "VF" || inputString == "BVF"|| inputString == "BFV"|| inputString == "FBV"|| inputString == "FVB"|| inputString == "VBF"|| inputString == "VFB" ){
    //								//err_count = 0;
    //						}else{
    //								//err_count = 1;
    //								err_count++;
    //						}
    //				}
    //		}
    //
    //		if(err_count > 0){
    //				err_count  = 0;
    //				for(var i=startRow;i<dupStringKey.length;i++){
    //						if(dupStringKey[i]!=""){
    //									sheetObjects[2].CellValue2(i,"3verify_result") = "Mode Column Error";
    //									sheetObjects[2].CellBackColor(i,1) = "#FF0000";
    //									err_count++;
    //						}
    //				}
    //		}else if(err_count == 0){
    //				for(var i=startRow;i<dupStringKey.length;i++){
    //						if(dupStringKey[i]!=""){
    //									sheetObjects[2].CellValue2(i,"3verify_result") = "";
    //									sheetObjects[2].CellBackColor(i,1) = "#0000FF";
    //						}
    //				}
    //		}
    //		return err_count;
}
/**
 * Terminal Rate List Tab Apply Date Data Verify. <br>
 * @param{verifyKey_2}	verifyKey_2	verifyKey_2
 * @param{startRow}		startRow	startRow
 * @param{lastRow}		lastRow		lastRow
 **/
function terminal_aply_dy_verify(verifyKey_2, startRow, lastRow) {
    var i;
    var j = 0;
    var sheetNo = 3;
    var dupkey = new Array();
    var dupTempKey = "";
    for (i = 0; i < verifyKey_2.length; i++) {
        if (i == 0) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_2[i];
            j++
        }
        if (dupTempKey != verifyKey_2[i]) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_2[i];
            j++;
        }
    }
    var dupString = new Array();
    var dupStringSheet = new Array();
    var dupStringKey = new Array();
    var seqDupRowKey = new Array();
    var err_count = 0;

    for (i = 0; i < dupkey.length; i++) {
        dupString[i] = sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_cntr_sty_cd")
            //+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo + "tml_agmt_vol_ut_cd")
            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sub_trd_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "thc_tp_cd");
        k = 0;
        for (var j = startRow; j <= lastRow; j++) {
            dupStringSheet[j] = sheetObjects[2].GetCellValue(j, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_cntr_sty_cd")
                //+"|"+ sheetObjects[2].CellValue(j, sheetNo + "tml_agmt_vol_ut_cd")
                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sub_trd_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "thc_tp_cd");
            if (dupString[i] == dupStringSheet[j]) {
                k++;
                dupStringKey[j] = sheetObjects[2].GetCellValue(j, sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "hol_flg");
            } else {
                k++;
                dupStringKey[j] = "NaN";
            }
        }
        err_count = err_count + terminal_aply_dyFun(dupStringKey, startRow);
        dupStringKey = Array();
    }
    return err_count;
}
/**
 * Terminal Rate List Tab Apply Date Data Verify. <br>
 * @param{startRow}		startRow	startRow
 * @param{dupStringKey}		dupStringKey		lastRow
 **/
function terminal_aply_dyFun(dupStringKey, startRow) {
    var inputString = "";
    var err_count = 0;
    var tempArray = "";
    var tempArrayKey = "";
    var tempString = "";
    var tempstartRow = startRow;
    for (var i = startRow; i < dupStringKey.length; i++) {
        if (dupStringKey[i] != "NaN") {
            if (tempstartRow < i) {
                tempArrayKey = dupStringKey[i].split("|");
                for (var j = 0; j < 4; j++) {
                    if (tempArray[j] == "Y" && tempArrayKey[j] == "Y") {
                        tempArray[j] = "S";
                    } else if ((tempArray[j] == "" && tempArrayKey[j] == "Y") || (tempArray[j] == "Y" && tempArrayKey[j] == "")) {
                        tempArray[j] = "Y";
                    } else if (tempArray[j] == "" && tempArrayKey[j] == "") {
                        tempArray[j] = "";
                    } else if ((tempArray[j] == "S" && tempArrayKey[j] == "Y") || (tempArray[j] == "S" && tempArrayKey[j] == "")) {
                        tempArray[j] = "S";
                    }
                }
            } else {
                tempArray = dupStringKey[i].split("|");
            }
        } else {
            tempstartRow = tempstartRow + 1;
        }
        tempArrayKey = "";
    }
    for (k = 0; k < 4; k++) {
        tempString = tempString + tempArray[k];
    }
    if (tempString != "YYYY") {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "NaN") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "Applied Day Column Error", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");
                err_count++;
            }
        }
    } else if (tempString == "YYYY") {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "NaN") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    }
    return err_count;
}
/**
 * Terminal Rate List Tab DG Class Data Verify. <br>
 * @param{verifyKey_1}	verifyKey_1	verifyKey_1
 * @param{startRow}		startRow	startRow
 * @param{lastRow}		lastRow		lastRow
 **/
function terminal_dg_class_verify(verifyKey_1, startRow, lastRow) {
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    // DG 관련 Check Logic 수정 
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    var err_count = 0;
    var iVerifyRow = 0; 
    var sDupString = "";
    var aTemp = new Array();    
    var sVerifyKey = new Array();
    
    for(var i=0 ; i<verifyKey_1.length; i++){	 
    	var aVerifyFlg = ["", "", "", "", "", "", "", "", "", "", "", "", ""];
    	
    	sVerifyKey = verifyKey_1[i].split(",");     
    	aTemp = sVerifyKey[0].split("|");;
    	iVerifyRow = sVerifyKey[1];
    	
    	if (aTemp[2] != "M") {		    
			for(var j=sheetObjects[2].HeaderRows() ; j<sheetObjects[2].HeaderRows() + sheetObjects[2].RowCount(); j++){
					sDupString = sheetObjects[2].GetCellValue(j, "3lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(j, "3auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(j, "3tml_cntr_sty_cd")                
		                + "|" + sheetObjects[2].GetCellValue(j, "3io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(j, "3ioc_cd") + "|" + sheetObjects[2].GetCellValue(j, "3tml_trns_mod_cd") 
		                + "|" + sheetObjects[2].GetCellValue(j, "3wkdy_flg") + "|" + sheetObjects[2].GetCellValue(j, "3sat_flg") + "|" + sheetObjects[2].GetCellValue(j, "3sun_flg") + "|" + sheetObjects[2].GetCellValue(j, "3hol_flg") 
		                + "|" + sheetObjects[2].GetCellValue(j, "3sub_trd_cd") + "|" + sheetObjects[2].GetCellValue(j, "3lane_cd") 
		                + "|" + sheetObjects[2].GetCellValue(j, "3fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, "3to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, "3tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(j, "3thc_tp_cd");
		            
		            if (sheetObjects[2].GetCellValue(j, "3verify_result") == "") {    
		            	sheetObjects[2].SetCellBackColor(j, 1, "#0000FF");
		            }
		                
		    		if(sVerifyKey[0] == sDupString){
		    			// Single Row 체크로직
		    			var aDgFlag = new Array();
		    			var iSinglErr = 0;
		    			
				    	aDgFlag[0] = sheetObjects[2].GetCellValue(j, "3dg_none");
				    	aDgFlag[1] = sheetObjects[2].GetCellValue(j, "3same_dg_none");
				    	aDgFlag[2] = sheetObjects[2].GetCellValue(j, "3same_dg");
				    	aDgFlag[3] = sheetObjects[2].GetCellValue(j, "3sep_dg_none");
				    	aDgFlag[4] = sheetObjects[2].GetCellValue(j, "3dcgo_n1st_clss_flg");
				    	aDgFlag[5] = sheetObjects[2].GetCellValue(j, "3dcgo_n2nd_clss_flg");
				    	aDgFlag[6] = sheetObjects[2].GetCellValue(j, "3dcgo_n3rd_clss_flg");
				    	aDgFlag[7] = sheetObjects[2].GetCellValue(j, "3dcgo_n4th_clss_flg");
				    	aDgFlag[8] = sheetObjects[2].GetCellValue(j, "3dcgo_n5th_clss_flg");
				    	aDgFlag[9] = sheetObjects[2].GetCellValue(j, "3dcgo_n6th_clss_flg");
				    	aDgFlag[10] = sheetObjects[2].GetCellValue(j, "3dcgo_n7th_clss_flg");
				    	aDgFlag[11] = sheetObjects[2].GetCellValue(j, "3dcgo_n8th_clss_flg");
				    	aDgFlag[12] = sheetObjects[2].GetCellValue(j, "3dcgo_n9th_clss_flg");
				    					    	
				    	if(aDgFlag[1] == "Y" && aDgFlag[2] == "Y"){
				    		iSinglErr++;
				    	} else if ((aDgFlag[1] == "Y" || aDgFlag[2] == "Y") &&  aDgFlag[3] == "Y"){
				    		iSinglErr++;
				    	} else if (aDgFlag[0] == "Y" && (aDgFlag[2] == "Y" || aDgFlag[3] == "Y" || aDgFlag[3] == "Y")){
				    		iSinglErr++;
				    	} else if (aDgFlag[3] == "Y" && (aDgFlag[4] == "Y" || aDgFlag[5] == "Y" || aDgFlag[6] == "Y" || aDgFlag[7] == "Y" || aDgFlag[8] == "Y" || aDgFlag[9] == "Y" || aDgFlag[10] == "Y" || aDgFlag[11] == "Y" || aDgFlag[12] == "Y")) {
				    		iSinglErr++;
				    	}       
					    
					    if (iSinglErr > 0){
					        sheetObjects[2].SetCellValue(iVerifyRow, "3verify_result", "DG Column Error", 0);
				            sheetObjects[2].SetCellBackColor(iVerifyRow, 1, "#FF0000");	
				            err_count = iSinglErr;			            
					    } 
					    // Single Row 체크로직 end
		    			
		    			// Multi Row 체크로직 
		    			if(aVerifyFlg[0] == ""){
		    				aVerifyFlg[0] = sheetObjects[2].GetCellValue(j, "3dg_none");
		    			} else if(sheetObjects[2].GetCellValue(j, "3dg_none") == "Y"){
		    				aVerifyFlg[0] = "S";
		    			}
		    			
		    			if(aVerifyFlg[1] == ""){
		    				aVerifyFlg[1] = sheetObjects[2].GetCellValue(j, "3same_dg_none");
		    			} else if(sheetObjects[2].GetCellValue(j, "3same_dg_none") == "Y"){
		    				aVerifyFlg[1] = "S";
		    			}
		    			
		    			if(aVerifyFlg[2] == ""){
		    				aVerifyFlg[2] = sheetObjects[2].GetCellValue(j, "3same_dg");
		    			} else if(sheetObjects[2].GetCellValue(j, "3same_dg") == "Y"){
		    				aVerifyFlg[2] = "S";
		    			}
		    			
		    			if(aVerifyFlg[3] == ""){
		    				aVerifyFlg[3] = sheetObjects[2].GetCellValue(j, "3sep_dg_none");
		    			} else if(sheetObjects[2].GetCellValue(j, "3sep_dg_none") == "Y"){
		    				aVerifyFlg[3] = "S";
		    			}
		    			
		    			if(aVerifyFlg[4] == ""){
		    				aVerifyFlg[4] = sheetObjects[2].GetCellValue(j, "3dcgo_n1st_clss_flg");
		    			} else if(sheetObjects[2].GetCellValue(j, "3dcgo_n1st_clss_flg") == "Y"){
		    				aVerifyFlg[4] = "S";
		    			}
		    			
		    			if(aVerifyFlg[5] == ""){
		    				aVerifyFlg[5] = sheetObjects[2].GetCellValue(j, "3dcgo_n2nd_clss_flg");
		    			} else if(sheetObjects[2].GetCellValue(j, "3dcgo_n2nd_clss_flg") == "Y"){
		    				aVerifyFlg[5] = "S";
		    			}
		    			
		    			if(aVerifyFlg[6] == ""){
		    				aVerifyFlg[6] = sheetObjects[2].GetCellValue(j, "3dcgo_n3rd_clss_flg");
		    			} else if(sheetObjects[2].GetCellValue(j, "3dcgo_n3rd_clss_flg") == "Y"){
		    				aVerifyFlg[6] = "S";
		    			}
		    			
		    			if(aVerifyFlg[7] == ""){
		    				aVerifyFlg[7] = sheetObjects[2].GetCellValue(j, "3dcgo_n4th_clss_flg");
		    			} else if(sheetObjects[2].GetCellValue(j, "3dcgo_n4th_clss_flg") == "Y"){
		    				aVerifyFlg[7] = "S";
		    			}
		    			
		    			if(aVerifyFlg[8] == ""){
		    				aVerifyFlg[8] = sheetObjects[2].GetCellValue(j, "3dcgo_n5th_clss_flg");
		    			} else if(sheetObjects[2].GetCellValue(j, "3dcgo_n5th_clss_flg") == "Y"){
		    				aVerifyFlg[8] = "S";
		    			}
		    			
		    			if(aVerifyFlg[9] == ""){
		    				aVerifyFlg[9] = sheetObjects[2].GetCellValue(j, "3dcgo_n6th_clss_flg");
		    			} else if(sheetObjects[2].GetCellValue(j, "3dcgo_n6th_clss_flg") == "Y"){
		    				aVerifyFlg[9] = "S";
		    			}
		    			
		    			if(aVerifyFlg[10] == ""){
		    				aVerifyFlg[10] = sheetObjects[2].GetCellValue(j, "3dcgo_n7th_clss_flg");
		    			} else if(sheetObjects[2].GetCellValue(j, "3dcgo_n7th_clss_flg") == "Y"){
		    				aVerifyFlg[10] = "S";
		    			}
		    			
		    			if(aVerifyFlg[11] == ""){
		    				aVerifyFlg[11] = sheetObjects[2].GetCellValue(j, "3dcgo_n8th_clss_flg");
		    			} else if(sheetObjects[2].GetCellValue(j, "3dcgo_n8th_clss_flg") == "Y"){
		    				aVerifyFlg[11] = "S";
		    			}
		    			
		    			if(aVerifyFlg[12] == ""){
		    				aVerifyFlg[12] = sheetObjects[2].GetCellValue(j, "3dcgo_n9th_clss_flg");
		    			} else if(sheetObjects[2].GetCellValue(j, "3dcgo_n9th_clss_flg") == "Y"){
		    				aVerifyFlg[12] = "S";
		    			}
					    	
	    		}  // if(verifyKey_1[i] == sDupString){ end
			}  // for(var j=sheetObjects[2].HeaderRows() ; j<sheetObjects[2].HeaderRows() + sheetObjects[2].RowCount(); j++){ end       
			
			var tempHdrString = "";
	    	var tempDtlString = "";
	    
			for (var k = 0; k < 3; k++) {
		        tempHdrString = tempHdrString + "|" + aVerifyFlg[k];
		    }
	    
		    for (var k = 3; k < 13; k++) {
		        tempDtlString = tempDtlString + "|" + aVerifyFlg[k];
		    }
			
			if (tempHdrString == "|Y||" && tempDtlString == "||||||||||") {	       
		        if (sheetObjects[2].GetCellValue(iVerifyRow, "3verify_result") == "") {
		            sheetObjects[2].SetCellValue(iVerifyRow, "3verify_result", "", 0);
		            sheetObjects[2].SetCellBackColor(iVerifyRow, 1, "#0000FF");
		        }
		        
		    } else if (tempHdrString == "||Y|Y" && tempDtlString == "||||||||||") {	        
		        if (sheetObjects[2].GetCellValue(iVerifyRow, "3verify_result") == "") {
		            sheetObjects[2].SetCellValue(iVerifyRow, "3verify_result", "", 0);
		            sheetObjects[2].SetCellBackColor(iVerifyRow, 1, "#0000FF");
		        }	  
		              
		    } else if (tempHdrString == "|||" && tempDtlString == "|Y|Y|Y|Y|Y|Y|Y|Y|Y|Y") {	        
		        if (sheetObjects[2].GetCellValue(iVerifyRow, "3verify_result") == "") {
		            sheetObjects[2].SetCellValue(iVerifyRow, "3verify_result", "", 0);
		            sheetObjects[2].SetCellBackColor(iVerifyRow, 1, "#0000FF");
		        }
		        
		    } else {        
	            sheetObjects[2].SetCellValue(iVerifyRow, "3verify_result", "DG Column Error", 0);
	            sheetObjects[2].SetCellBackColor(iVerifyRow, 1, "#FF0000");
	            err_count++;	        
		    }
		}  // if (aTemp[2] != "M") {  end
	    
    }  // for(var i=0 ; i<verifyKey_1.length; i++){	
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    // 이전 로직 주석 처리
    
//	var i;
//	var err_count = 0;
//    var j = 0;
//    var sheetNo = 3;
//    var dupkey = new Array();
//    var dupTempKey = "";
//        
//    for (i = 0; i < verifyKey_1.length; i++) {
//        if (i == 0) {
//            dupkey[j] = i + startRow;
//            dupTempKey = verifyKey_1[i];
//            j++
//        }
//        if (dupTempKey != verifyKey_1[i]) {
//            dupkey[j] = i + startRow;
//            dupTempKey = verifyKey_1[i];
//            j++;
//        }
//    }
//    var dupString = new Array();
//    var dupStringSheet = new Array();
//    var dupStringKey = new Array();
//    var seqDupRowKey = new Array();
//    
//
//    for (i = 0; i < dupkey.length; i++) {
//        if (sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_cntr_sty_cd") != "M") {
//            dupString[i] = sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_cntr_sty_cd") //추가 2015.0403			
//                //+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"tml_agmt_vol_ut_cd")
//                + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sub_trd_cd") //추가 2015.0403	
//                + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "thc_tp_cd");
//
//            k = 0;
//            for (var j = startRow; j <= lastRow; j++) {
//                dupStringSheet[j] = sheetObjects[2].GetCellValue(j, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_cntr_sty_cd") //추가 2015.0403	
//                    //+"|"+ sheetObjects[2].CellValue(j, sheetNo+"tml_agmt_vol_ut_cd")
//                    + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sub_trd_cd") //추가 2015.0403										
//                    + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "to_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "thc_tp_cd");
//                if (dupString[i] == dupStringSheet[j]) {
//                    k++;
//                    dupStringKey[j] = sheetObjects[2].GetCellValue(j, sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n9th_clss_flg");
//                } else {
//                    k++;
//                    dupStringKey[j] = "NaN";
//                }
//            }
//
//            err_count = err_count + terminal_dg_classFun(dupStringKey, startRow, sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lgs_cost_cd"));
//            dupStringKey = Array();
//
//        }
//
//    }

    return err_count;
}
/**
 * Terminal Rate List Tab DG Class Data Verify. <br>
 * @param{dupStringKey}		dupStringKey	dupStringKey
 * @param{startRow}			startRow		startRow
 * @param{lgsCosdCd}		lgsCosdCd		lgsCosdCd
 **/
function terminal_dg_classFun(dupStringKey, startRow, lgsCosdCd) {
    var inputString = "";
    var err_count = 0;
    var tempArrayHdr = "";
    var tempArrayDtl = "";
    var tempArrayHdrKey = "";
    var tempArrayDtlKey = "";
    var tempHdrString = "";
    var tempDtlString = "";
    var tempstartRow = startRow;
    for (var i = startRow; i < dupStringKey.length; i++) {
        if (dupStringKey[i] != "NaN") {
            //if ( lgsCosdCd == "SVLDTS") {								    
            //    alert( tempstartRow + " : " + i + " : " + tempstartRow<i );								    
            //
            //}
            if (tempstartRow < i) {
                tempArrayHdrKey = dupStringKey[i].split("|");
                for (var j = 0; j < 3; j++) {
                    // ................... 
                    //if ( lgsCosdCd == "SVLDTS") {
                    //    alert( j + " : " + tempArrayHdr[j] + " : " + tempArrayHdr[j] );								    
                    //}
                    if (tempArrayHdr[j] == "Y" && tempArrayHdrKey[j] == "Y") {
                        tempArrayHdr[j] = "S";
                    } else if ((tempArrayHdr[j] == "" && tempArrayHdrKey[j] == "Y") || (tempArrayHdr[j] == "Y" && tempArrayHdrKey[j] == "")) {
                        tempArrayHdr[j] = "Y";
                    } else if (tempArrayHdr[j] == "" && tempArrayHdrKey[j] == "") {
                        tempArrayHdr[j] = "";
                    } else if ((tempArrayHdr[j] == "S" && tempArrayHdrKey[j] == "Y") || (tempArrayHdr[j] == "S" && tempArrayHdrKey[j] == "")) {
                        tempArrayHdr[j] = "S";
                    }
                }
                tempArrayDtlKey = dupStringKey[i].split("|");
                for (j = 3; j < 13; j++) {
                    if (tempArrayDtl[j] == "Y" && tempArrayDtlKey[j] == "Y") {
                        tempArrayDtl[j] = "S";
                    } else if ((tempArrayDtl[j] == "" && tempArrayDtlKey[j] == "Y") || (tempArrayDtl[j] == "Y" && tempArrayDtlKey[j] == "")) {
                        tempArrayDtl[j] = "Y";
                    } else if (tempArrayDtl[j] == "" && tempArrayDtlKey[j] == "") {
                        tempArrayDtl[j] = "";
                    } else if ((tempArrayDtl[j] == "S" && tempArrayDtlKey[j] == "Y") || (tempArrayDtl[j] == "S" && tempArrayDtlKey[j] == "")) {
                        tempArrayDtl[j] = "S";
                    }
                }
                
            } else { // if (tempstartRow < i) {
                tempArrayHdr = dupStringKey[i].split("|");
                tempArrayDtl = dupStringKey[i].split("|");
            } // if (tempstartRow < i) {
            
        } else { // if (dupStringKey[i] != "NaN") {
            tempstartRow = tempstartRow + 1;
        } // if (dupStringKey[i] != "NaN") {
        
        tempArrayHdrKey = "";
        tempArrayDtlKey = "";
    }
    
    for (var k = 0; k < 3; k++) {
        tempHdrString = tempHdrString + "|" + tempArrayHdr[k];
    }
    
    for (var k = 3; k < 13; k++) {
        tempDtlString = tempDtlString + "|" + tempArrayDtl[k];
    }
    
    if (tempHdrString == "|Y||" && tempDtlString == "||||||||||") {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "NaN" && sheetObjects[2].GetCellValue(i, "3verify_result") == "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    } else if (tempHdrString == "||Y|Y" && tempDtlString == "||||||||||") {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "NaN" && sheetObjects[2].GetCellValue(i, "3verify_result") == "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    } else if (tempHdrString == "|||" && tempDtlString == "|Y|Y|Y|Y|Y|Y|Y|Y|Y|Y") {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "NaN" && sheetObjects[2].GetCellValue(i, "3verify_result") == "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    } else {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "NaN") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "DG Column Error", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");
                err_count++;
            }
        }
    }
    
    return err_count;
}
/**
 * Terminal Rate List Tab Lane Code Data Verify. <br>
 * @param{verifyKey_5}	verifyKey_5	verifyKey_5
 * @param{startRow}		startRow	startRow
 * @param{lastRow}		lastRow		lastRow
 **/
function terminal_lane_cd_verify(verifyKey_5, startRow, lastRow) {
    var i;
    var j = 0;
    var sheetNo = 3;
    var dupkey = new Array();
    var dupTempKey = "";
    
    for (i = 0; i < verifyKey_5.length; i++) {
        if (i == 0) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_5[i];
            j++
        }
        if (dupTempKey != verifyKey_5[i]) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_5[i];
            j++;
        }
    }
    
    var dupString = new Array();
    var dupStringSheet = new Array();
    var dupStringKey = new Array();
    var seqDupRowKey = new Array();
    var err_count = 0;

    for (i = 0; i < dupkey.length; i++) {
        dupString[i] = sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_cntr_sty_cd") //20150406 추가
            //+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"tml_agmt_vol_ut_cd")
            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_trns_mod_cd") 
            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sun_flg")  
            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sub_trd_cd") //20150406 추가
            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "same_dg") 
            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n2nd_clss_flg") 
            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n5th_clss_flg") 
            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n8th_clss_flg") 
            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "to_tr_vol_val") 
            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "thc_tp_cd");
        k = 0;
        for (var j = startRow; j <= lastRow; j++) {
            dupStringSheet[j] = sheetObjects[2].GetCellValue(j, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_cntr_sty_cd")
                //+"|"+ sheetObjects[2].CellValue(j, sheetNo+"tml_agmt_vol_ut_cd")
                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_trns_mod_cd") 
                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sun_flg") 
                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sub_trd_cd") 
                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dg_none") + "|"  + sheetObjects[2].GetCellValue(j, sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "same_dg") 
                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n2nd_clss_flg") 
                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n5th_clss_flg") 
                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n8th_clss_flg") 
                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "to_tr_vol_val") 
                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "thc_tp_cd");
            if (dupString[i] == dupStringSheet[j]) {
                k++;
                dupStringKey[j] = sheetObjects[2].GetCellValue(j, sheetNo + "lane_cd");
            } else {
                k++;
                dupStringKey[j] = "";
            }
        }
        
        err_count = err_count + terminal_lane_cdFun(dupStringKey, startRow);

        if (err_count > 0) { //20150416 sub trade가 추가되면서 구조적으로 달라짐
            return err_count;
        }

        dupStringKey = Array();
    }
    verifyKey_5 = "";
    return err_count;
}
/**
 * Terminal Rate List Tab Lane Code Data Verify. <br>
 * @param{dupStringKey}		dupStringKey	dupStringKey
 * @param{startRow}			startRow		startRow
 **/
function terminal_lane_cdFun(dupStringKey, startRow) {
    var err_count = 0;
    var inputString = "";
    var tempArray = new Array();
    tempArray[0] = "";
    tempArray[1] = "";
    tempArray[2] = "";
    var j = 0;
    //laneCDSheet2
    var originalLaneCd = "";
    var inputLaneCd = "";
    var sameCodeCount = 0;
    var inputLaneString = "";
    var originalLaneString = "";
    for (var i = startRow; i < dupStringKey.length; i++) {
        if (dupStringKey[i] != "") {
            if (dupStringKey[i] == "Sam") {
                tempArray[0] = "S"
            } else if (dupStringKey[i] == "OTH") {
                tempArray[1] = "O"
            } else if (dupStringKey[i] != "Sam" && dupStringKey[i] != "OTH" && dupStringKey[i] != "") {
                tempArray[2] = "L"
                inputString = dupStringKey[i] + "|" + inputString;
            } else {
                tempArray[0] = "";
                tempArray[1] = "";
                tempArray[2] = "";
            }
        }
    }
    
    if (tempArray[0] == "S" && tempArray[1] == "" && tempArray[2] == "") {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#0000FF");
            }
        }
        
    } else if (tempArray[0] == "" && tempArray[1] == "O" && tempArray[2] == "L") {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#0000FF");
            }
        }
        
    } else if (tempArray[0] == "" && tempArray[1] == "" && tempArray[2] == "L") {
        originalLaneCd = laneCDSheet2.split("|");
        inputLaneCd = inputString.split("|");
        
        for (var i = 0; i < inputLaneCd.length; i++) {
            for (j = 2; j < originalLaneCd.length; j++) {
                if (inputLaneCd[i] == originalLaneCd[j]) {
                    inputLaneCd[i] = "";
                    originalLaneCd[j] = "";
                }
            }
        }
        
        for (var i = 0; i < inputLaneCd.length; i++) {
            inputLaneString = inputLaneString + inputLaneCd[i];
        }
        
        for (j = 2; j < originalLaneCd.length; j++) {
            originalLaneString = originalLaneString + originalLaneCd[j];
        }
        
        if (inputLaneString == "" && originalLaneString == "") {
            for (var i = startRow; i < dupStringKey.length; i++) {
                if (dupStringKey[i] != "") {
                    sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                    sheetObjects[2].SetCellBackColor(i, 1, "#0000FF");
                }
            }
        } else {
            for (var i = startRow; i < dupStringKey.length; i++) {
                //					sheetObjects[2].SetCellValue(i,"3verify_result","Lane Column Error",0);
                //					sheetObjects[2].SetCellBackColor(i,1,"#FF0000");

                if (dupStringKey[i] != "") {
                    sheetObjects[2].SetCellValue(i, "3verify_result", "Lane Column Error", 0);
                    sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");
                    err_count++;
                }

            }
        }
        
    } else {
        for (var i = startRow; i < dupStringKey.length; i++) {
            //				sheetObjects[2].SetCellValue(i,"3verify_result","Lane Column Error",0);
            //				sheetObjects[2].SetCellBackColor(i,1,"#FF0000");

            if (dupStringKey[i] != "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "Lane Column Error", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");
                err_count++;
            }

        }
    }
    /**
    if(sameCodeCount>1){
    		for(var i=startRow;i<dupStringKey.length;i++){
    				sheetObjects[2].SetCellValue(i,"3verify_result","Lane Column Error",0);
    				sheetObjects[2].SetCellBackColor(i,1,"#FF0000");
    				err_count++;
    		}
    }
    **/
    return err_count;
}
/**
 * Terminal Rate List Tab Tier Volume Value Data Verify. <br>
 * @param{startRow}		startRow	startRow
 * @param{lastRow}		lastRow		lastRow
 * @param{verifyKey_7}		verifyKey_7	verifyKey_7
 **/
function terminal_tr_vol_val_verify(verifyKey_7, startRow, lastRow) {
    var i;
    var j = 0;
    var sheetNo = 3;
    var dupkey = new Array();
    var dupTempKey = "";
    for (i = 0; i < verifyKey_7.length; i++) {
        if (i == 0) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_7[i];
            j++
        }
        if (dupTempKey != verifyKey_7[i]) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_7[i];
            j++;
        }
    }
    var dupString = new Array();
    var dupStringSheet = new Array();
    var dupStringKey = new Array();
    var seqDupRowKey = new Array();
    var err_count = 0;

    for (i = 0; i < dupkey.length; i++) {
        dupString[i] = sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_cntr_sty_cd")
            //+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"tml_agmt_vol_ut_cd")
            + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sub_trd_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(dupkey[i], sheetNo + "thc_tp_cd");
        k = 0;
        for (var j = startRow; j <= lastRow; j++) {
            dupStringSheet[j] = sheetObjects[2].GetCellValue(j, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "auto_calc_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_cntr_sty_cd")
                //+"|"+ sheetObjects[2].CellValue(j, sheetNo+"tml_agmt_vol_ut_cd")
                + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "io_bnd_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "ioc_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_trns_mod_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "wkdy_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sat_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sun_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "hol_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sub_trd_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "lane_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "same_dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "same_dg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "sep_dg_none") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n1st_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n2nd_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n3rd_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n4th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n5th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n6th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n7th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n8th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "dcgo_n9th_clss_flg") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "tml_ovt_shft_cd") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "thc_tp_cd");
            if (dupString[i] == dupStringSheet[j]) {
                k++;
                dupStringKey[j] = sheetObjects[2].GetCellValue(j, sheetNo + "fm_tr_vol_val") + "|" + sheetObjects[2].GetCellValue(j, sheetNo + "to_tr_vol_val");
            } else {
                k++;
                dupStringKey[j] = "";
            }
        }
        err_count = err_count + terminal_tr_vol_valFun(dupStringKey, startRow);
        dupStringKey = Array();
    }
    return err_count;
}
/**
 * Terminal Rate List Tab Tier Volume Value Data Verify. <br>
 * @param{dupStringKey}		dupStringKey	dupStringKey
 * @param{startRow}			startRow		startRow
 **/
function terminal_tr_vol_valFun(dupStringKey, startRow) {
    var inputString = "";
    var err_count = 0;
    var tempArray = "";
    var tempArrayKey = "";
    var tempString = "";
    var tempstartRow = startRow;
    for (var i = startRow; i < dupStringKey.length; i++) {
        if (dupStringKey[i] != "") {
            if (tempstartRow < i) {
                tempArrayKey = dupStringKey[i].split("|");
                if (tempArray[1].toUpperCase() == "MAX") {
                    tempArray[1] = 9999999;
                }
                if (tempArrayKey[1].toUpperCase() == "MAX") {
                    tempArrayKey[1] = 9999999;
                }
                if (tempArray[0] < 1 || tempArrayKey[0] < 1) {
                    err_count = 1;
                }
                if (tempArray[0] == tempArrayKey[0]) {
                    err_count = 1;
                }
                if (tempArray[1] != (parseInt(tempArrayKey[0]) - 1)) {
                    err_count = 1;
                } else if (tempArray[1] == (parseInt(tempArrayKey[0]) - 1)) {
                    tempArray[1] = tempArrayKey[1];
                }
            } else {
                tempArray = dupStringKey[i].split("|");
                if (tempArray[1].toUpperCase() == "MAX") {
                    tempArray[1] = 9999999;
                }
            }
        } else {
            tempstartRow = tempstartRow + 1;
        }
        tempArrayKey = "";
    }
    if (tempArray[0] == 1 && tempArray[1] == 9999999) {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    } else {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "Tier Vol. Column Error", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");
                err_count++;
            }
        }
    }
    if (err_count > 0) { //alert("err_count==>"+err_count);
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[2].SetCellValue(i, "3verify_result", "Tier Vol. Column Error", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");
                err_count++;
            }
        }
    }
    return err_count;
}
/**
 * Terminal Rate List Tab Container Rate Data Verify. <br>
 * @param{startRow}		startRow	startRow
 * @param{lastRow}		lastRow		lastRow
 **/
function terminal_cntr_rate_verify(startRow, lastRow) {
    var tr_rate = 0;
    var teu_rate = 0;
    var box_rate = 0;
    var move_rate = 0;
    var ganghour_rate = 0;
    var cntrRateErrCount = 0;
    var i = 0;
    var j = 0;
    
    for (i = startRow; i <= lastRow; i++) {
        for (j = 32 + gap_tm; j < 57 + gap_tm; j++) {
            tr_rate = parseInt(sheetObjects[2].GetCellValue(i, j)) + tr_rate;
        }
        
        teu_rate = sheetObjects[2].GetCellValue(i, "3teu_rate");
        box_rate = sheetObjects[2].GetCellValue(i, "3box_rate");
        move_rate = sheetObjects[2].GetCellValue(i, "3move_rate");
        ganghour_rate = sheetObjects[2].GetCellValue(i, "3gang_hour_rate");
        tonne_rate = sheetObjects[2].GetCellValue(i, "3tonne_rate");
        
        if (sheetObjects[2].GetCellValue(i, "3tml_agmt_vol_ut_cd") == "C") {
            if (teu_rate == 0 && box_rate == 0 && move_rate == 0 && ganghour_rate == 0 && tonne_rate == 0) {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#0000FF");
            } else {
                sheetObjects[2].SetCellValue(i, "3verify_result", "Rate by Container Type Size Column Error", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");
                if (teu_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3teu_rate", "#FF0000");
                }
                
                if (box_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3box_rate", "#FF0000");
                }
                
                if (move_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3move_rate", "#FF0000");
                }
                
                if (ganghour_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3gang_hour_rate", "#FF0000");
                }
                
                if (tonne_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3tonne_rate", "#FF0000");
                }

                cntrRateErrCount++;
            }
        } else if (sheetObjects[2].GetCellValue(i, "3tml_agmt_vol_ut_cd") == "T") {
            if (tr_rate == 0 && teu_rate != 0 && box_rate == 0 && move_rate == 0 && ganghour_rate == 0 && tonne_rate == 0) {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#0000FF");
            } else {
                sheetObjects[2].SetCellValue(i, "3verify_result", "Rate by Container Type Size Column Error", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");

                if (teu_rate == 0 || teu_rate == "") {
                    sheetObjects[2].SetCellBackColor(i, "3teu_rate", "#FF0000");
                }

                if (tr_rate > 0) {
                    for (j = 32 + gap_tm; j < 57 + gap_tm; j++) {
                        sheetObjects[2].SetCellBackColor(i, j, "#FF0000");
                    }
                }
                
                if (box_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3box_rate", "#FF0000");
                }
                
                if (move_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3move_rate", "#FF0000");
                }
                
                if (ganghour_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3gang_hour_rate", "#FF0000");
                }
                
                if (tonne_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3tonne_rate", "#FF0000");
                }
                cntrRateErrCount++;
            }
        } else if (sheetObjects[2].GetCellValue(i, "3tml_agmt_vol_ut_cd") == "U") {
            if (tr_rate == 0 && teu_rate == 0 && box_rate != 0 && move_rate == 0 && ganghour_rate == 0 && tonne_rate == 0) {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");
            } else {
                sheetObjects[2].SetCellValue(i, "3verify_result", "Rate by Container Type Size Column Error", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");

                if (tr_rate > 0) {
                    for (j = 32 + gap_tm; j < 57 + gap_tm; j++) {
                        sheetObjects[2].SetCellBackColor(i, j, "#FF0000");
                    }
                }
                
                if (teu_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3teu_rate", "#FF0000");
                }
                
                if (box_rate == 0 || box_rate == "") {
                    sheetObjects[2].SetCellBackColor(i, "3box_rate", "#FF0000");
                }
                
                if (move_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3move_rate", "#FF0000");
                }
                
                if (ganghour_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3gang_hour_rate", "#FF0000");
                }
                
                if (tonne_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3tonne_rate", "#FF0000");
                }
                cntrRateErrCount++;
            }
        } else if (sheetObjects[2].GetCellValue(i, "3tml_agmt_vol_ut_cd") == "M") {
            if (tr_rate == 0 && teu_rate == 0 && box_rate == 0 && move_rate != 0 && ganghour_rate == 0 && tonne_rate == 0) {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");
            } else {
                sheetObjects[2].SetCellValue(i, "3verify_result", "Rate by Container Type Size Column Error", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");

                if (tr_rate > 0) {
                    for (j = 32 + gap_tm; j < 57 + gap_tm; j++) {
                        sheetObjects[2].SetCellBackColor(i, j, "#FF0000");
                    }
                }
                
                if (teu_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3teu_rate", "#FF0000");
                }
                
                if (box_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3box_rate", "#FF0000");
                }
                
                if (move_rate == 0 || move_rate == "") {
                    sheetObjects[2].SetCellBackColor(i, "3move_rate", "#FF0000");
                }
                
                if (ganghour_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3gang_hour_rate", "#FF0000");
                }
                                
                if (tonne_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3tonne_rate", "#FF0000");
                }
                cntrRateErrCount++;
            }
        }  else if (sheetObjects[2].GetCellValue(i, "3tml_agmt_vol_ut_cd") == "G") {
            if (tr_rate == 0 && teu_rate == 0 && box_rate == 0 && move_rate == 0 && ganghour_rate != 0 && tonne_rate == 0) {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");
            } else {
                sheetObjects[2].SetCellValue(i, "3verify_result", "Rate by Container Type Size Column Error", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");

                if (tr_rate > 0) {
                    for (j = 32 + gap_tm; j < 57 + gap_tm; j++) {
                        sheetObjects[2].SetCellBackColor(i, j, "#FF0000");
                    }
                }
                
                if (teu_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3teu_rate", "#FF0000");
                }
                
                if (box_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3box_rate", "#FF0000");
                }
                
                if (move_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3move_rate", "#FF0000");
                }
                
                if (ganghour_rate == 0 || ganghour_rate == "") {
                    sheetObjects[2].SetCellBackColor(i, "3gang_hour_rate", "#FF0000");
                }
                
                if (tonne_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3tonne_rate", "#FF0000");
                }
                cntrRateErrCount++;
            }
            
        }  else if (sheetObjects[2].GetCellValue(i, "3tml_agmt_vol_ut_cd") == "W") {
            if (tr_rate == 0 && teu_rate == 0 && box_rate == 0 && move_rate == 0 && ganghour_rate == 0 && tonne_rate != 0) {
                sheetObjects[2].SetCellValue(i, "3verify_result", "", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");
            } else {
                sheetObjects[2].SetCellValue(i, "3verify_result", "Rate by Container Type Size Column Error", 0);
                sheetObjects[2].SetCellBackColor(i, 1, "#FF0000");

                if (tr_rate > 0) {
                    for (j = 32 + gap_tm; j < 57 + gap_tm; j++) {
                        sheetObjects[2].SetCellBackColor(i, j, "#FF0000");
                    }
                }
                
                if (teu_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3teu_rate", "#FF0000");
                }
                
                if (box_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3box_rate", "#FF0000");
                }
                
                if (move_rate == 0 || move_rate == "") {
                    sheetObjects[2].SetCellBackColor(i, "3move_rate", "#FF0000");
                }
                
                if (ganghour_rate > 0) {
                    sheetObjects[2].SetCellBackColor(i, "3gang_hour_rate", "#FF0000");
                }
                                
                if (tonne_rate == 0 || tonne_rate == "") {
                    sheetObjects[2].SetCellBackColor(i, "3tonne_rate", "#FF0000");
                }
                cntrRateErrCount++;
            }
            
        }  
        //			if(tr_rate == 0 && teu_rate == 0 && box_rate == 0 && move_rate == 0 && ganghour_rate == 0){
        //				sheetObjects[2].SetCellValue(i,"3verify_result","Rate by Container Type Size Column Error",0);
        //				sheetObjects[2].SetCellBackColor(i,1,"#FF0000");
        //				cntrRateErrCount++;
        //			}
        tr_rate = 0;
    }
    return cntrRateErrCount;
}
/**
 * Terminal Rate List Tab Data Verify. <br>
 **/
function dataTerminalVerify() {
    var k = sheetObjects[2].RowCount() + 3;
    var dataErrCount = 0;
    var vrfyFlg;
    
    for (var i = 3; i < k; i++) {
        
        vrfyFlg = sheetObjects[7].GetCellValue(i - 2, 1).split("|");
        sheetObjects[2].SetCellValue(i, "3vrfyflg", sheetObjects[7].GetCellValue(i - 2, 1), 0);
        sheetObjects[2].SetRowBackColor(i, "#FFFFFF");
        
        if (vrfyFlg[0] != sheetObjects[2].GetCellValue(i, '3auto_calc_flg')) {
            sheetObjects[2].SetCellBackColor(i, '3auto_calc_flg', "#FF0000");
            dataErrCount++;
        }
        
        if (sheetObjects[2].GetCellValue(i, '3auto_calc_flg') == "Y") {           
            
            if (sheetObjects[2].GetCellValue(i, '3lgs_cost_cd') != sheetObjects[7].GetCellValue(i - 2, 0)) {
                sheetObjects[2].SetCellBackColor(i, '3lgs_cost_cd', "#FF0000");
                dataErrCount++;
            }
            
            if (sheetObjects[2].GetCellValue(i, '3lgs_cost_cd') == "") {
                sheetObjects[2].SetCellBackColor(i, '3lgs_cost_cd', "#FF0000");
                dataErrCount++;
            }
            
            // com_auto_calc_flg
            if (vrfyFlg[0] != sheetObjects[2].GetCellValue(i, '3auto_calc_flg')) {
                sheetObjects[2].SetCellBackColor(i, '3auto_calc_flg', "#FF0000");
                dataErrCount++;
            }
            
            // volume UOM  2016-05-23 추가
            if (vrfyFlg[0] == "Y" && sheetObjects[2].GetCellValue(i, '3tml_agmt_vol_ut_cd') == "W") {
                sheetObjects[2].SetCellBackColor(i, '3tml_agmt_vol_ut_cd', "#FF0000");
                sheetObjects[2].SetCellValue(i, "3verify_result", "It isn't permitted to register 'W' as Volume UOM for auto cost codes.");
                dataErrCount++;
            }
            
            // tml_io_bnd_flg
            if (vrfyFlg[2] == "Y") {
                if (sheetObjects[2].GetCellValue(i, '3io_bnd_cd') != "I" && sheetObjects[2].GetCellValue(i, '3io_bnd_cd') != "O" && sheetObjects[2].GetCellValue(i, '3io_bnd_cd') != "S") {
                    sheetObjects[2].SetCellBackColor(i, '3io_bnd_cd', "#FF0000");
                    dataErrCount++;
                }
            } else if (vrfyFlg[2] == "N") {
                if (sheetObjects[2].GetCellValue(i, '3io_bnd_cd') != "") {
                    sheetObjects[2].SetCellBackColor(i, '3io_bnd_cd', "#FF0000");
                    dataErrCount++;
                }
            }
            // tml_ioc_flg
            if (vrfyFlg[3] == "Y") {
                if (sheetObjects[2].GetCellValue(i, '3ioc_cd') != "I" && sheetObjects[2].GetCellValue(i, '3ioc_cd') != "O" && sheetObjects[2].GetCellValue(i, '3ioc_cd') != "S") {
                    sheetObjects[2].SetCellBackColor(i, '3ioc_cd', "#FF0000");
                    dataErrCount++;
                }
            } else if (vrfyFlg[3] == "N") {
                if (sheetObjects[2].GetCellValue(i, '3ioc_cd') != "") {
                    sheetObjects[2].SetCellBackColor(i, '3ioc_cd', "#FF0000");
                    dataErrCount++;
                }
            }
            if (sheetObjects[2].GetCellValue(i, '3curr_cd') == "") {
                sheetObjects[2].SetCellBackColor(i, '3curr_cd', "#FF0000");
                dataErrCount++;
            }
            // tml_aply_dt_flg
            if (vrfyFlg[4] == "Y") {
                if (sheetObjects[2].GetCellValue(i, '3wkdy_flg') == "" && sheetObjects[2].GetCellValue(i, '3sat_flg') == "" && sheetObjects[2].GetCellValue(i, '3sun_flg') == "" && sheetObjects[2].GetCellValue(i, '3hol_flg') == "") {
                    sheetObjects[2].SetCellBackColor(i, '3wkdy_flg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3sat_flg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3sun_flg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3hol_flg', "#FF0000");
                    dataErrCount++;
                }
            } else if (vrfyFlg[4] == "N") {
                if (sheetObjects[2].GetCellValue(i, '3wkdy_flg') != "" || sheetObjects[2].GetCellValue(i, '3sat_flg') != "" || sheetObjects[2].GetCellValue(i, '3sun_flg') != "" || sheetObjects[2].GetCellValue(i, '3hol_flg') != "") {
                    sheetObjects[2].SetCellBackColor(i, '3wkdy_flg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3sat_flg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3sun_flg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3hol_flg', "#FF0000");
                    dataErrCount++;
                }
            }
            // tml_lane_flg
            if (vrfyFlg[5] == "Y") {
                if (sheetObjects[2].GetCellValue(i, '3lane_cd') == "") {
                    sheetObjects[2].SetCellBackColor(i, '3lane_cd', "#FF0000");
                    dataErrCount++;
                }
            } else if (vrfyFlg[5] == "N") {
                if (sheetObjects[2].GetCellValue(i, '3lane_cd').trim() != "") {
                    sheetObjects[2].SetCellBackColor(i, '3lane_cd', "#FF0000");
                    dataErrCount++;
                }
            }
            // tml_dcgo_aply_flg
            if (vrfyFlg[6] == "Y") {
                if (sheetObjects[2].GetCellValue(i, '3dg_none') == "" &&
                    sheetObjects[2].GetCellValue(i, '3same_dg_none') == "" &&
                    sheetObjects[2].GetCellValue(i, '3same_dg') == "" &&
                    sheetObjects[2].GetCellValue(i, '3sep_dg_none') == "" &&
                    sheetObjects[2].GetCellValue(i, '3dcgo_n1st_clss_flg') == "" &&
                    sheetObjects[2].GetCellValue(i, '3dcgo_n2nd_clss_flg') == "" &&
                    sheetObjects[2].GetCellValue(i, '3dcgo_n3rd_clss_flg') == "" &&
                    sheetObjects[2].GetCellValue(i, '3dcgo_n4th_clss_flg') == "" &&
                    sheetObjects[2].GetCellValue(i, '3dcgo_n5th_clss_flg') == "" &&
                    sheetObjects[2].GetCellValue(i, '3dcgo_n6th_clss_flg') == "" &&
                    sheetObjects[2].GetCellValue(i, '3dcgo_n7th_clss_flg') == "" &&
                    sheetObjects[2].GetCellValue(i, '3dcgo_n8th_clss_flg') == "" &&
                    sheetObjects[2].GetCellValue(i, '3dcgo_n9th_clss_flg') == "" &&
                    (sheetObjects[2].GetCellValue(i, '3tml_cntr_sty_cd') == "" || sheetObjects[2].GetCellValue(i, '3tml_cntr_sty_cd') == "F" || sheetObjects[2].GetCellValue(i, '3tml_cntr_sty_cd') == "S")
                ) {
                    sheetObjects[2].SetCellBackColor(i, '3dg_none', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3same_dg_none', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3same_dg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3sep_dg_none', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3dcgo_n1st_clss_flg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3dcgo_n2nd_clss_flg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3dcgo_n3rd_clss_flg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3dcgo_n4th_clss_flg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3dcgo_n5th_clss_flg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3dcgo_n6th_clss_flg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3dcgo_n7th_clss_flg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3dcgo_n8th_clss_flg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3dcgo_n9th_clss_flg', "#FF0000");
                    dataErrCount++;
                }
            } else if (vrfyFlg[6] == "N") {
                if (sheetObjects[2].GetCellValue(i, '3dg_none') != "" ||
                    sheetObjects[2].GetCellValue(i, '3same_dg_none') != "" ||
                    sheetObjects[2].GetCellValue(i, '3same_dg') != "" ||
                    sheetObjects[2].GetCellValue(i, '3sep_dg_none') != "" ||
                    sheetObjects[2].GetCellValue(i, '3dcgo_n1st_clss_flg') != "" ||
                    sheetObjects[2].GetCellValue(i, '3dcgo_n2nd_clss_flg') != "" ||
                    sheetObjects[2].GetCellValue(i, '3dcgo_n3rd_clss_flg') != "" ||
                    sheetObjects[2].GetCellValue(i, '3dcgo_n4th_clss_flg') != "" ||
                    sheetObjects[2].GetCellValue(i, '3dcgo_n5th_clss_flg') != "" ||
                    sheetObjects[2].GetCellValue(i, '3dcgo_n6th_clss_flg') != "" ||
                    sheetObjects[2].GetCellValue(i, '3dcgo_n7th_clss_flg') != "" ||
                    sheetObjects[2].GetCellValue(i, '3dcgo_n8th_clss_flg') != "" ||
                    sheetObjects[2].GetCellValue(i, '3dcgo_n9th_clss_flg') != "") {
                    sheetObjects[2].SetCellBackColor(i, '3dg_none', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3same_dg_none', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3same_dg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3sep_dg_none', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3dcgo_n1st_clss_flg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3dcgo_n2nd_clss_flg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3dcgo_n3rd_clss_flg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3dcgo_n4th_clss_flg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3dcgo_n5th_clss_flg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3dcgo_n6th_clss_flg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3dcgo_n7th_clss_flg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3dcgo_n8th_clss_flg', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3dcgo_n9th_clss_flg', "#FF0000");
                    dataErrCount++;
                }
            }
            // tml_tr_vol_flg
            if (vrfyFlg[7] == "Y") {
                if (sheetObjects[2].GetCellValue(i, '3fm_tr_vol_val') == "" && sheetObjects[2].GetCellValue(i, '3to_tr_vol_val') == "") {
                    sheetObjects[2].SetCellBackColor(i, '3fm_tr_vol_val', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3to_tr_vol_val', "#FF0000");
                    dataErrCount++;
                }
            } else if (vrfyFlg[7] == "N") {
                if (sheetObjects[2].GetCellValue(i, '3fm_tr_vol_val') != "" || sheetObjects[2].GetCellValue(i, '3to_tr_vol_val') != "") {
                    sheetObjects[2].SetCellBackColor(i, '3fm_tr_vol_val', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3to_tr_vol_val', "#FF0000");
                    dataErrCount++;
                }
            }
            // tml_ovt_shft_flg
            //				if (vrfyFlg[8] == "Y"){
            //					if(sheetObjects[2].GetCellValue(i,'3tml_ovt_shft_cd') == "" ){
            //						sheetObjects[2].SetCellBackColor(i,'3tml_ovt_shft_cd',"#FF0000");
            //						dataErrCount++;
            //					}
            //				} else if (vrfyFlg[8] == "N"){
            //					if(sheetObjects[2].GetCellValue(i,'3tml_ovt_shft_cd') != "" ){
            //						sheetObjects[2].SetCellBackColor(i,'3tml_ovt_shft_cd',"#FF0000");
            //						dataErrCount++;
            //					}
            //				}
            // tml_thc_flg
            if (vrfyFlg[9] == "Y") {
                if (sheetObjects[2].GetCellValue(i, '3thc_tp_cd') == "") {
                    sheetObjects[2].SetCellBackColor(i, '3thc_tp_cd', "#FF0000");
                    dataErrCount++;
                }
            } else if (vrfyFlg[9] != "Y") {
                if (sheetObjects[2].GetCellValue(i, '3thc_tp_cd') != "") {
                    sheetObjects[2].SetCellBackColor(i, '3thc_tp_cd', "#FF0000");
                    dataErrCount++;
                }
            }
            // rt_cntr_tpsz_flg
            if (vrfyFlg[20] == "N") {
                if (sheetObjects[2].GetCellValue(i, '3d2') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3d4') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3d5') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3d7') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3d8') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3d9') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3dw') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3dx') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3r4') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3r5') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3r7') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3f2') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3f4') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3o2') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3o4') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3s2') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3s4') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3t2') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3t4') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3a2') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3a4') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3p2') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3p4') > 0 ||
                    sheetObjects[2].GetCellValue(i, '3f5') > 0) {
                    sheetObjects[2].SetCellBackColor(i, '3d2', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3d4', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3d5', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3d7', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3d8', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3d9', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3dw', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3dx', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3r4', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3r5', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3r7', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3f2', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3f4', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3o2', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3o4', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3s2', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3s4', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3t2', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3t4', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3a2', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3a4', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3p2', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3p4', "#FF0000");
                    sheetObjects[2].SetCellBackColor(i, '3f5', "#FF0000");
                    dataErrCount++;
                }
            }
            // rt_teu_flg
            if (vrfyFlg[21] == "N") {
                if (sheetObjects[2].GetCellValue(i, '3teu_rate') > 0) {
                    sheetObjects[2].SetCellBackColor(i, '3teu_rate', "#FF0000");
                    dataErrCount++;
                }
            }
            // rt_bx_flg
            if (vrfyFlg[22] == "N") {
                if (sheetObjects[2].GetCellValue(i, '3box_rate') > 0) {
                    sheetObjects[2].SetCellBackColor(i, '3box_rate', "#FF0000");
                    dataErrCount++;
                }
            }
            // rt_mv_flg
            if (vrfyFlg[23] == "N") {
                if (sheetObjects[2].GetCellValue(i, '3move_rate') > 0) {
                    sheetObjects[2].SetCellBackColor(i, '3move_rate', "#FF0000");
                    dataErrCount++;
                }
            }
            // tml_trns_mod_flg
            if (vrfyFlg[25] == "Y") {
                if (sheetObjects[2].GetCellValue(i, '3tml_trns_mod_cd') == "") {
                    sheetObjects[2].SetCellBackColor(i, '3tml_trns_mod_cd', "#FF0000");
                    dataErrCount++;
                }
                //								if(sheetObjects[2].CellValue(i,'3tml_trns_mod_cd') != "" ){
                //										if(sheetObjects[2].CellValue(i, "3lgs_cost_cd")=="TPNDFL" || sheetObjects[2].CellValue(i, "3lgs_cost_cd")=="SVLDFL" || sheetObjects[2].CellValue(i, "3lgs_cost_cd")=="TMNDFL"){
                //												if(sheetObjects[2].CellValue(i,'3tml_trns_mod_cd') == 'F' || sheetObjects[2].CellValue(i,'3tml_trns_mod_cd') == 'V'){
                //														sheetObjects[2].CellBackColor(i,'3tml_trns_mod_cd') = "#FF0000";
                //														dataErrCount++;
                //												}
                //										}else if(sheetObjects[2].CellValue(i, "3lgs_cost_cd")=="TPNDTS" || sheetObjects[2].CellValue(i, "3lgs_cost_cd")=="SVLDTS" || sheetObjects[2].CellValue(i, "3lgs_cost_cd")=="TMNDFL"){
                //												if(sheetObjects[2].CellValue(i,'3tml_trns_mod_cd') == 'T' || sheetObjects[2].CellValue(i,'3tml_trns_mod_cd') == 'R' ){
                //
                ////												if(sheetObjects[2].CellValue(i,'3tml_trns_mod_cd') == 'T' || sheetObjects[2].CellValue(i,'3tml_trns_mod_cd') == 'R' || sheetObjects[2].CellValue(i,'3tml_trns_mod_cd') == 'B'){
                //
                //														sheetObjects[2].CellBackColor(i,'3tml_trns_mod_cd') = "#FF0000";
                //														dataErrCount++;
                //												}
                //										}
                //								}
            } else if (vrfyFlg[25] == "N") {
                if (sheetObjects[2].GetCellValue(i, '3tml_trns_mod_cd') != "") {
                    sheetObjects[2].SetCellBackColor(i, '3tml_trns_mod_cd', "#FF0000");
                    dataErrCount++;
                }
            }
            //tml_cntr_sty_cd
            if (vrfyFlg[26] == "Y") {
                if (sheetObjects[2].GetCellValue(i, '3tml_cntr_sty_cd') == "") {
                    sheetObjects[2].SetCellBackColor(i, '3tml_cntr_sty_cd', "#FF0000");
                    dataErrCount++;
                }
            } else if (vrfyFlg[26] != "Y") {
                if (sheetObjects[2].GetCellValue(i, '3tml_cntr_sty_cd') != "") {
                    sheetObjects[2].SetCellBackColor(i, '3tml_cntr_sty_cd', "#FF0000");
                    dataErrCount++;
                }
            }

            //sub_trd_cd
            if (vrfyFlg[28] == "Y") {
                if (sheetObjects[2].GetCellValue(i, '3sub_trd_cd') == "") {
                    sheetObjects[2].SetCellBackColor(i, '3sub_trd_cd', "#FF0000");
                    dataErrCount++;
                }
            } else if (vrfyFlg[28] != "Y") {
                if (sheetObjects[2].GetCellValue(i, '3sub_trd_cd') != "") {
                    sheetObjects[2].SetCellBackColor(i, '3sub_trd_cd', "#FF0000");
                    dataErrCount++;
                }
            }

            vrfyFlg = "";
        }
    }
    return dataErrCount;
}
/*******************************************************************
 * 4. Agreement Storage Rate List
 * 
 ******************************************************************/
/**
 * Storage Rate List Tab Data Verify. <br>
 * @param{string}	beforeibflag	beforeibflag
 **/
function storageRateListVerify_test1(beforeibflag) {
    var sheetNo = 5;
    var k = sheetObjects[4].RowCount() + 1;
    var count = 0;
    var n = 1;
    var costCodeKey = "";
    var costCodeVrfyFlg = "";
    verifyKey = new Array();
    verifyKey_1 = new Array();
    verifyKey_2 = new Array();
    verifyKey_3 = new Array();
    verifyKey_4 = new Array();
    verifyKey_5 = new Array();

    //		stoTotalErrCount =0;   // vaidation check err count

    var costCount = 0;
    var countkey = 0;
    costCodeNcount = new Array();

    for (i = 1; i < k; i++) {
        if (costCodeKey == "") {
            costCodeKey = sheetObjects[4].GetCellValue(i + 2, sheetNo + "lgs_cost_cd");
            costCodeVrfyFlg = sheetObjects[4].GetCellValue(i + 2, sheetNo + "vrfyflg");
        }

        if (sheetObjects[4].GetCellValue(i + 3, sheetNo + "lgs_cost_cd") != "") {
            if (sheetObjects[4].GetCellValue(i + 2, sheetNo + "lgs_cost_cd") == sheetObjects[4].GetCellValue(i + 3, sheetNo + "lgs_cost_cd")) {
                costCount++;
            } else if (sheetObjects[4].GetCellValue(i + 2, sheetNo + "lgs_cost_cd") != sheetObjects[4].GetCellValue(i + 3, sheetNo + "lgs_cost_cd")) {
                costCodeNcount[countkey] = costCodeKey + "#" + (costCount + 1) + "#" + costCodeVrfyFlg;
                countkey++;
                costCodeKey = "";
                costCodeVrfyFlg = "";
                costCount = 0;
            }
        } else {
            break;
        }
    } //for..[]
    var rowStatus = new Array();
    var rowAgmtType = new Array();
    var rowFtDys = new Array();
    var errCount = 0;
    var totalErrCount = 0;

    var local_count = 0;
    var startRow = 0;
    var lastRow = 0;
    for (var ii = 0; ii < costCodeNcount.length; ii++) {
        var cost_code = "";
        var cost_code_flg = "";
        cost_code = costCodeNcount[ii].split("#");
        cost_code_flg = cost_code[2].split("|");

        for (j = 0; j < cost_code[1]; j++) {
            // 14 : sto_free_dy_dcgo_tm_flg, 16 : sto_free_dy_dcgo_rt_flg
            if ((cost_code_flg[14] == "Y" || cost_code_flg[16] == "Y") &&
                sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "tml_sto_agmt_tp_cd") == "FD") {
                verifyKey_1[j] = sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "tml_cntr_sty_cd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "tml_sto_agmt_tp_cd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "ft_dys") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "io_bnd_cd")
                    //+ "|" + sheetObjects[4].CellValue(local_count+3, sheetNo+"sat_flg_fd")
                    //+ "|" + sheetObjects[4].CellValue(local_count+3, sheetNo+"sun_flg_fd")
                    //+ "|" + sheetObjects[4].CellValue(local_count+3, sheetNo+"hol_flg_fd")
                    + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "fm_tr_dys") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "to_tr_dys") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "fp_teu_qty");
            }
            // 12 : sto_free_dy_io_bnd_flg
            if (cost_code_flg[12] == "Y" && sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "tml_sto_agmt_tp_cd") == "FD") {
                verifyKey_2[j] = sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "tml_cntr_sty_cd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "tml_sto_agmt_tp_cd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "ft_dys")
                    //+ "|" + sheetObjects[4].CellValue(local_count+3, sheetNo + "sat_flg_fd")
                    //+ "|" + sheetObjects[4].CellValue(local_count+3, sheetNo + "sun_flg_fd")
                    //+ "|" + sheetObjects[4].CellValue(local_count+3, sheetNo + "hol_flg_fd")
                    + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dg_none_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "same_dg_none_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "same_dg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "sep_dg_none_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dg_none_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "same_dg_none_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "same_dg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "sep_dg_none_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "fm_tr_dys") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "to_tr_dys") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "fp_teu_qty");
            }

            if (sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "tml_sto_agmt_tp_cd") == "FD") {
                verifyKey_3[j] = sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "tml_cntr_sty_cd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "tml_sto_agmt_tp_cd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "io_bnd_cd")
                    //+"|"+ sheetObjects[4].CellValue(local_count + 3, sheetNo + "sat_flg_fd")
                    //+"|"+ sheetObjects[4].CellValue(local_count + 3, sheetNo + "sun_flg_fd")
                    //+"|"+ sheetObjects[4].CellValue(local_count + 3, sheetNo + "hol_flg_fd")
                    + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dg_none_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "same_dg_none_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "same_dg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "sep_dg_none_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dg_none_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "same_dg_none_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "same_dg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "sep_dg_none_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "fm_tr_dys") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "to_tr_dys") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "fp_teu_qty");
            }

            if (cost_code_flg[17] == "Y" &&
                sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "ft_dys") == "" &&
                sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "tml_sto_agmt_tp_cd") == "FD") {
                verifyKey_4[j] = sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "tml_cntr_sty_cd")
                    //						+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd")
                    + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "tml_sto_agmt_tp_cd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "ft_dys") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "io_bnd_cd")
                    //+"|"+ sheetObjects[4].CellValue(local_count + 3, sheetNo + "sat_flg_fd")
                    //+"|"+ sheetObjects[4].CellValue(local_count + 3, sheetNo + "sun_flg_fd")
                    //+"|"+ sheetObjects[4].CellValue(local_count + 3, sheetNo + "hol_flg_fd")
                    + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dg_none_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "same_dg_none_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "same_dg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "sep_dg_none_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dg_none_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "same_dg_none_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "same_dg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "sep_dg_none_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "fp_teu_qty");
            }

            if (cost_code_flg[27] == "Y" &&
                sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "tml_sto_agmt_tp_cd") == "FD") {
                verifyKey_5[j] = sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "lgs_cost_cd")
                    //						+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd")
                    + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "tml_sto_agmt_tp_cd") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "ft_dys")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "io_bnd_cd")
                    //+"|"+ sheetObjects[4].CellValue(local_count + 3, sheetNo + "sat_flg_fd")
                    //+"|"+ sheetObjects[4].CellValue(local_count + 3, sheetNo + "sun_flg_fd")
                    //+"|"+ sheetObjects[4].CellValue(local_count + 3, sheetNo + "hol_flg_fd")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dg_none_fd")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "same_dg_none_fd")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "same_dg_fd")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "sep_dg_none_fd")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg_fd")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg_fd")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg_fd")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg_fd")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg_fd")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg_fd")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg_fd")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg_fd")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg_fd")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dg_none_r")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "same_dg_none_r")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "same_dg_r")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "sep_dg_none_r")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg_r")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg_r")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg_r")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg_r")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg_r")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg_r")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg_r")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg_r")
                    //						+ "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg_r")
                    + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "fm_tr_dys") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "to_tr_dys") + "|" + sheetObjects[4].GetCellValue(local_count + 3, sheetNo + "fp_teu_qty");
            }

            local_count++;
        }
        if (ii == 0) {
            startRow = 3;
            lastRow = local_count + 2;
        } else if (ii > 0) {
            startRow = lastRow + 1;
            lastRow = local_count + 2;
        }

        for (jj = startRow; jj <= lastRow; jj++) {
            rowStatus[jj] = sheetObjects[4].GetCellValue(jj, sheetNo + "ibflag");
            rowFtDys[jj] = sheetObjects[4].GetCellValue(jj, sheetNo + "ft_dys");
            rowAgmtType[jj] = sheetObjects[4].GetCellValue(jj, sheetNo + "tml_sto_agmt_tp_cd");
        }
        // 20 : rt_cntr_tpsz_flg, 21 : rt_teu_flg, 22 : rt_bx_flg, 23 : rt_mv_flg
        if (cost_code_flg[20] == "Y" || cost_code_flg[21] == "Y" ||
            cost_code_flg[22] == "Y" || cost_code_flg[23] == "Y") {
            errCount = storage_cntr_rate_verify(startRow, lastRow);
        }

        if (errCount == 0) {
            if (cost_code_flg[12] == "Y" && verifyKey_2.length > 0) {
                errCount = storage_io_bnd_cd_verify(verifyKey_2, startRow, lastRow, rowFtDys) + errCount;
                for (jj = 0; jj < verifyKey_2.length; jj++) {
                    verifyKey_2 = Array();
                }
            }
        }
        if (errCount == 0) {
            if (verifyKey_3.length > 0) {
                errCount = storage_ft_day_verify(verifyKey_3, startRow, lastRow) + errCount;
                for (jj = 0; jj < verifyKey_3.length; jj++) {
                    verifyKey_3 = Array();
                }
            }
        }
        if (errCount == 0) {
            if (cost_code_flg[17] == "Y" && verifyKey_4.length > 0) {
                errCount = storage_tr_vol_val_verify(verifyKey_4, startRow, lastRow, rowFtDys) + errCount;
                for (jj = 0; jj < verifyKey_4.length; jj++) {
                    verifyKey_4 = Array();
                }
            }
        }

        if (errCount == 0) {
            // 14 : sto_free_dy_dcgo_tm_flg, 16 : sto_free_dy_dcgo_rt_flg
            if ((cost_code_flg[14] == "Y" || cost_code_flg[16] == "Y") && verifyKey_1.length > 0) {
                errCount = storage_dg_class_verify(verifyKey_1, startRow, lastRow, rowFtDys) + errCount;
                for (jj = 0; jj < verifyKey_1.length; jj++) {
                    verifyKey_1 = Array();
                }
            }
        }

        if (errCount == 0) {
            if (cost_code_flg[27] == "Y" && verifyKey_5.length > 0) {
                errCount = storage_cntr_sty_cd_verify(verifyKey_5, startRow, lastRow, rowFtDys) + errCount;
                for (jj = 0; jj < verifyKey_5.length; jj++) {
                    verifyKey_5 = Array();
                }
            }
        }

        for (jj = 0; jj < verifyKey_1.length; jj++) {
            verifyKey_1 = Array();
        }
        for (jj = 0; jj < verifyKey_2.length; jj++) {
            verifyKey_2 = Array();
        }
        for (jj = 0; jj < verifyKey_3.length; jj++) {
            verifyKey_3 = Array();
        }
        for (jj = 0; jj < verifyKey_4.length; jj++) {
            verifyKey_4 = Array();
        }
        for (jj = 0; jj < verifyKey_5.length; jj++) {
            verifyKey_5 = Array();
        }

        totalErrCount = errCount + totalErrCount;
        errCount = 0;

        for (jj = startRow; jj <= lastRow; jj++) {
            sheetObjects[4].SetRowStatus(jj, beforeibflag[jj - 3]);
            if (sheetObjects[4].GetCellValue(jj, sheetNo + "verify_result") == "") {
                sheetObjects[4].SetCellBackColor(jj, 1, "#0000FF");
            } else if (sheetObjects[4].GetCellValue(jj, sheetNo + "verify_result") != "") {
                sheetObjects[4].SetCellBackColor(jj, 1, "#FF0000");
            }
        }
        //rowStatus[jj] = Array();
        rowFtDys = Array();
    }

    if (totalErrCount > 0) {
        return false;
    } else if (totalErrCount == 0) {
        return true;
    }
    //		stoTotalErrCount=0;
}
/**
 * Storage Rate List Tab Io Bound Code Data Verify. <br>
 * @param{verifyKey_2}	verifyKey_2	verifyKey_2
 * @param{startRow}		startRow	startRow
 * @param{lastRow}		lastRow		lastRow
 * @param{rowFtDys}		rowFtDys	rowFtDys
 **/
function storage_io_bnd_cd_verify(verifyKey_2, startRow, lastRow, rowFtDys) {
    var i;
    var j = 0;
    var sheetNo = 5;
    var dupkey = new Array();
    var dupTempKey = "";
    for (i = 0; i < verifyKey_2.length; i++) {
        if (i == 0) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_2[i];
            j++
        }
        if (dupTempKey != verifyKey_2[i]) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_2[i];
            j++;
        }
    }
    var dupString = new Array();
    var dupStringSheet = new Array();
    var dupStringKey = new Array();
    var dupNotFStringKey = new Array();
    var seqDupRowKey = new Array();
    var err_count = 0;
    for (i = 0; i < dupkey.length; i++) {
        dupString[i] = sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "lgs_cost_cd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "tml_cntr_sty_cd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "tml_agmt_vol_ut_cd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "tml_sto_agmt_tp_cd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "ft_dys")
            //+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo + "sat_flg_fd")
            //+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo + "sun_flg_fd")
            //+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo + "hol_flg_fd")
            + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dg_none_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "same_dg_none_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "same_dg_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "sep_dg_none_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n1st_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n2nd_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n3rd_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n4th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n5th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n6th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n7th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n8th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n9th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dg_none_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "same_dg_none_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "same_dg_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "sep_dg_none_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n1st_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n2nd_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n3rd_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n4th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n5th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n6th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n7th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n8th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n9th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "fm_tr_dys") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "to_tr_dys") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "fp_teu_qty");
        k = 0;
        for (var j = startRow; j <= lastRow; j++) {
            dupStringSheet[j] = sheetObjects[4].GetCellValue(j, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "tml_cntr_sty_cd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "tml_agmt_vol_ut_cd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "tml_sto_agmt_tp_cd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "ft_dys")
                //+"|"+ sheetObjects[4].CellValue(j, sheetNo + "sat_flg_fd")
                //+"|"+ sheetObjects[4].CellValue(j, sheetNo + "sun_flg_fd")
                //+"|"+ sheetObjects[4].CellValue(j, sheetNo + "hol_flg_fd")
                + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dg_none_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "same_dg_none_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "same_dg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "sep_dg_none_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n1st_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n2nd_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n3rd_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n4th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n5th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n6th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n7th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n8th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n9th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dg_none_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "same_dg_none_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "same_dg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "sep_dg_none_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n1st_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n2nd_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n3rd_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n4th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n5th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n6th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n7th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n8th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n9th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "fm_tr_dys") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "to_tr_dys") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "fp_teu_qty");

            if (dupString[i] == dupStringSheet[j] && sheetObjects[4].GetCellValue(j, sheetNo + "ft_dys") == "F") {
                k++;
                dupStringKey[j] = sheetObjects[4].GetCellValue(j, sheetNo + "io_bnd_cd");
            } else {
                k++;
                dupStringKey[j] = "";
            }

            if (dupString[i] == dupStringSheet[j] && sheetObjects[4].GetCellValue(j, sheetNo + "ft_dys") == "") {
                dupNotFStringKey[j] = sheetObjects[4].GetCellValue(j, sheetNo + "io_bnd_cd");
            } else {
                dupNotFStringKey[j] = "";
            }

        }

        err_count = err_count + storage_ioBoundFun(dupStringKey, dupNotFStringKey, startRow);
        dupStringKey = Array();
    }
    return err_count;
}
/**
 * Storage Rate List Tab Io Bound Verify.<br>
 * @param{dupStringKey}	dupStringKey	dupStringKey
 * @param{startRow}		startRow		startRow
 **/
function storage_ioBoundFun(dupStringKey, dupNotFStringKey, startRow) {
    var inputString = "";
    var inputNotFString = "";

    var chkIO;
    var err_count = 0;

    for (var i = startRow; i < dupStringKey.length; i++) {
        if (dupStringKey[i] != undefined && dupStringKey[i] != "") {
            inputString = inputString + dupStringKey[i];
        }
    }

    for (var i = startRow; i < dupNotFStringKey.length; i++) {
        if (dupNotFStringKey[i] != undefined && dupNotFStringKey[i] != "") {
            inputNotFString = inputNotFString + dupNotFStringKey[i];
        }
    }

    if (inputString == "S" || inputString == "IO" || inputString == "OI") {
        chkIO = 0;
    } else {
        chkIO = 1;
    }

    if (chkIO > 0) {
        err_count = 0;
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != null && dupStringKey[i] != "") {
                sheetObjects[4].SetCellValue(i, "5verify_result", "IO Bound Column Error", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#FF0000");
                err_count++;
            }
        }
    } else if (err_count == 0) {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[4].SetCellValue(i, "5verify_result", "", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    }
    if (err_count > 0) {
        return err_count;
    }

    if (inputNotFString == "S" || inputNotFString == "IO" || inputNotFString == "OI") {
        chkIO = 0;
    } else {
        chkIO = 1;
    }

    if (chkIO > 0) {
        err_count = 0;
        for (var i = startRow; i < dupNotFStringKey.length; i++) {
            if (dupNotFStringKey[i] != null && dupNotFStringKey[i] != "") {
                sheetObjects[4].SetCellValue(i, "5verify_result", "IO Bound Column Error");
                sheetObjects[4].SetCellBackColor(i, 1, "#FF0000");
                err_count++;
            }
        }
    } else if (err_count == 0) {
        for (var i = startRow; i < dupNotFStringKey.length; i++) {
            if (dupNotFStringKey[i] != "") {
                sheetObjects[4].SetCellValue(i, "5verify_result", "");
                sheetObjects[4].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    }

    //		stoTotalErrCount = stoTotalErrCount + err_count; 
    return err_count;
}
/**
 * Storage Rate List Tab Ft Day Data Verify. <br>
 * @param{verifyKey_4}	verifyKey_4	verifyKey_4
 * @param{startRow}		startRow	startRow
 * @param{lastRow}		lastRow		lastRow
 **/
function storage_ft_day_verify(verifyKey_4, startRow, lastRow) {
    var i;
    var j = 0;
    var sheetNo = 5;
    var dupString = new Array();
    var dupStringSheet = new Array();
    var dupStringKey = new Array();
    var seqDupRowKey = new Array();
    for (var j = startRow; j <= lastRow; j++) {
        dupStringSheet[j] = sheetObjects[4].GetCellValue(j, sheetNo + "lgs_cost_cd");
        k = 0;
        if (sheetObjects[4].GetCellValue(j, sheetNo + "tml_sto_agmt_tp_cd") == "FD") {
            k++;
            dupStringKey[j] = sheetObjects[4].GetCellValue(j, sheetNo + "ft_dys");

            if (sheetObjects[4].GetCellValue(j, sheetNo + "ft_dys") == "") {
                dupStringKey[j] = "NaN";
            }
        } else {
            k++;
            dupStringKey[j] = "NaN";
        }
    }
    var err_count = storage_ft_dayFun(dupStringKey, startRow, lastRow);
    dupStringKey = Array();
    return err_count;
}
/**
 * Storage Rate List Tab Ft Day Data. <br>
 * @param{dupStringKey}	dupStringKey	dupStringKey
 * @param{startRow}		startRow		startRow
 * @param{lastRow}		lastRow			lastRow
 **/
function storage_ft_dayFun(dupStringKey, startRow, lastRow) {
    var inputString = "";
    var err_count = 0;
    var countF = 0;
    var countNaN = 0;
    for (var i = startRow; i < dupStringKey.length; i++) {
        if (dupStringKey[i] != "") {
            if (dupStringKey[i] == "F") {
                countF++;
            } else if (dupStringKey[i] == "NaN") {
                countNaN++;
            }
        }
    }

    if (countF > 0 && countNaN > 0) {
        err_count = 0;
    } else {
        err_count = 1;
    }
    /**
    if(inputString == "FNaN"){
    		err_count=0;
    }else{
    		err_count=1;
    }
    **/
    if (err_count > 0) {
        err_count = 0;
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[4].SetCellValue(i, "5verify_result", "FT Day Column Error", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#FF0000");
                err_count++;
            }
        }
    } else if (err_count == 0) {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[4].SetCellValue(i, "5verify_result", "", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    }
    //		stoTotalErrCount = stoTotalErrCount + err_count;
    return err_count;
}
/**
 * Storage Rate List Tab DG Class Data Verify. <br>
 * @param{verifyKey_1}	verifyKey_1	verifyKey_1
 * @param{startRow}		startRow	startRow
 * @param{lastRow}		lastRow		lastRow
 * @param{rowFtDys}		rowFtDys	rowFtDys
 **/
function storage_dg_class_verify(verifyKey_1, startRow, lastRow, rowFtDys) {
    var i;
    var j = 0;
    var sheetNo = 5;
    var dupkey = new Array();
    var dupTempKey = "";
    var rowFtDys1 = new Array();
    for (i = 0; i < verifyKey_1.length; i++) {
        if (i == 0) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_1[i];
            j++
        }
        if (dupTempKey != verifyKey_1[i]) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_1[i];
            j++;
        }
    }
    var dupString = new Array();
    var dupStringSheet = new Array();
    var dupStringKey = new Array();
    var seqDupRowKey = new Array();
    var err_count = 0;
    for (i = 0; i < dupkey.length; i++) {
        if (sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "tml_cntr_sty_cd") != "M") {
            dupString[i] = sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "lgs_cost_cd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "tml_cntr_sty_cd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "tml_agmt_vol_ut_cd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "tml_sto_agmt_tp_cd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "ft_dys") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "io_bnd_cd")
                //+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"sat_flg_fd")
                //+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"sun_flg_fd")
                //+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"hol_flg_fd")
                + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "fm_tr_dys") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "to_tr_dys") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "fp_teu_qty");

            k = 0;
            for (var j = startRow; j <= lastRow; j++) {
                dupStringSheet[j] = sheetObjects[4].GetCellValue(j, sheetNo + "lgs_cost_cd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "tml_cntr_sty_cd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "tml_agmt_vol_ut_cd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "tml_sto_agmt_tp_cd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "ft_dys") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "io_bnd_cd")
                    //+"|"+ sheetObjects[4].CellValue(j, sheetNo+"sat_flg_fd")
                    //+"|"+ sheetObjects[4].CellValue(j, sheetNo+"sun_flg_fd")
                    //+"|"+ sheetObjects[4].CellValue(j, sheetNo+"hol_flg_fd")
                    + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "fm_tr_dys") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "to_tr_dys") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "fp_teu_qty");

                if (dupString[i] == dupStringSheet[j]) {
                    k++;
                    if (rowFtDys[j] == "F") {
                        dupStringKey[j] = sheetObjects[4].GetCellValue(j, sheetNo + "dg_none_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "same_dg_none_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "same_dg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "sep_dg_none_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n1st_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n2nd_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n3rd_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n4th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n5th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n6th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n7th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n8th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n9th_clss_flg_fd");
                    } else if (rowFtDys[j] == "") {
                        dupStringKey[j] = sheetObjects[4].GetCellValue(j, sheetNo + "dg_none_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "same_dg_none_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "same_dg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "sep_dg_none_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n1st_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n2nd_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n3rd_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n4th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n5th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n6th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n7th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n8th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n9th_clss_flg_r");
                    }
                } else {
                    k++;
                    dupStringKey[j] = "NaN";
                }
            }

            err_count = err_count + storage_dg_classFun(dupStringKey, startRow, rowFtDys);
            dupStringKey = Array();
        }
    }
    return err_count;
}
/**
 * Storage Rate List Tab DG Class Data Verify. <br>
 * @param{dupStringKey}	dupStringKey	dupStringKey
 * @param{startRow}		startRow	startRow
 * @param{rowFtDys}		rowFtDys	rowFtDys
 **/
function storage_dg_classFun(dupStringKey, startRow, rowFtDys) {
    var inputString = "";
    var err_count = 0;
    var tempArrayHdr = "";
    var tempArrayDtl = "";
    var tempArrayHdrKey = "";
    var tempArrayDtlKey = "";
    var tempHdrString = "";
    var tempDtlString = "";
    var tempstartRow = startRow;

    for (var i = startRow; i < dupStringKey.length; i++) {
        if (dupStringKey[i] != "NaN") {
            if (tempstartRow < i) {
                tempArrayHdrKey = dupStringKey[i].split("|");
                for (var j = 0; j < 3; j++) {
                    if (tempArrayHdr[j] == "Y" && tempArrayHdrKey[j] == "Y") {
                        tempArrayHdr[j] = "S";
                    } else if ((tempArrayHdr[j] == "" && tempArrayHdrKey[j] == "Y") || (tempArrayHdr[j] == "Y" && tempArrayHdrKey[j] == "")) {
                        tempArrayHdr[j] = "Y";
                    } else if (tempArrayHdr[j] == "" && tempArrayHdrKey[j] == "") {
                        tempArrayHdr[j] = "";
                    } else if ((tempArrayHdr[j] == "S" && tempArrayHdrKey[j] == "Y") || (tempArrayHdr[j] == "S" && tempArrayHdrKey[j] == "")) {
                        tempArrayHdr[j] = "S";
                    }
                }
                tempArrayDtlKey = dupStringKey[i].split("|");
                for (j = 3; j < 13; j++) {
                    if (tempArrayDtl[j] == "Y" && tempArrayDtlKey[j] == "Y") {
                        tempArrayDtl[j] = "S";
                    } else if ((tempArrayDtl[j] == "" && tempArrayDtlKey[j] == "Y") || (tempArrayDtl[j] == "Y" && tempArrayDtlKey[j] == "")) {
                        tempArrayDtl[j] = "Y";
                    } else if (tempArrayDtl[j] == "" && tempArrayDtlKey[j] == "") {
                        tempArrayDtl[j] = "";
                    } else if ((tempArrayDtl[j] == "S" && tempArrayDtlKey[j] == "Y") || (tempArrayDtl[j] == "S" && tempArrayDtlKey[j] == "")) {
                        tempArrayDtl[j] = "S";
                    }
                }
            } else {
                tempArrayHdr = dupStringKey[i].split("|");
                tempArrayDtl = dupStringKey[i].split("|");
            }
        } else {
            tempstartRow = tempstartRow + 1;
        }
        tempArrayHdrKey = "";
        tempArrayDtlKey = "";
    }

    for (var k = 0; k < 3; k++) {
        tempHdrString = tempHdrString + "|" + tempArrayHdr[k];
    }
    for (var k = 3; k < 13; k++) {
        tempDtlString = tempDtlString + "|" + tempArrayDtl[k];
    }

    if (tempHdrString == "|Y||" && tempDtlString == "||||||||||") {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "NaN") {
                sheetObjects[4].SetCellValue(i, "5verify_result", "", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    } else if (tempHdrString == "||Y|Y" && tempDtlString == "||||||||||") {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "NaN") {
                sheetObjects[4].SetCellValue(i, "5verify_result", "", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    } else if (tempHdrString == "|||" && tempDtlString == "|Y|Y|Y|Y|Y|Y|Y|Y|Y|Y") {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "NaN") {
                sheetObjects[4].SetCellValue(i, "5verify_result", "", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    } else {
        /**
        	if(rowFtDys[i-startRow]=="F"){
        			for(var i=startRow;i<dupStringKey.length;i++){
        					if(dupStringKey[i]!="NaN"){
        							sheetObjects[4].SetCellValue(i,"5verify_result","DG for Free Day Column for Error",0);
        							sheetObjects[4].SetCellBackColor(i,1,"#FF0000");
        							err_count++;
        					}
        			}
        	}
        	if(rowFtDys[i-startRow]==""){
        			for(var i=startRow;i<dupStringKey.length;i++){
        					if(dupStringKey[i]!="NaN"){
        							sheetObjects[4].SetCellValue(i,"5verify_result","DG for Rate Column for Error",0);
        							sheetObjects[4].SetCellBackColor(i,1,"#FF0000");
        							err_count++;
        					}
        			}
        	}
        **/
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (rowFtDys[i] == "F") {
                if (dupStringKey[i] != "NaN") {
                    sheetObjects[4].SetCellValue(i, "5verify_result", "DG for Free Day Column for Error", 0);
                    sheetObjects[4].SetCellBackColor(i, 1, "#FF0000");
                    err_count++;
                }
            } else if (rowFtDys[i] == "") {
                if (dupStringKey[i] != "NaN") {
                    sheetObjects[4].SetCellValue(i, "5verify_result", "DG for Rate Column for Error", 0);
                    sheetObjects[4].SetCellBackColor(i, 1, "#FF0000");
                    err_count++;
                }
            }
        }
    }
    //		stoTotalErrCount = stoTotalErrCount + err_count;
    return err_count;
}

/** storage_cntr_sty_cd_verify
 * 
 * @param verifyKey_5
 * @param startRow
 * @param lastRow
 * @param rowFtDys
 * @returns {Number}
 */
function storage_cntr_sty_cd_verify(verifyKey_5, startRow, lastRow, rowFtDys) {
    var i;
    var j = 0;
    var sheetNo = 5;
    var dupkey = new Array();
    var dupTempKey = "";
    for (i = 0; i < verifyKey_5.length; i++) {
        if (i == 0) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_5[i];
            j++
        }
        if (dupTempKey != verifyKey_5[i]) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_5[i];
            j++;
        }
    }
    var dupString = new Array();
    var dupStringSheet = new Array();
    var dupStringKey = new Array();
    var dupNotFStringKey = new Array();
    var seqDupRowKey = new Array();
    var err_count = 0;

    for (i = 0; i < dupkey.length; i++) {
        dupString[i] = sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "lgs_cost_cd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "tml_sto_agmt_tp_cd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "ft_dys")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"io_bnd_cd")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"dg_none_fd")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"same_dg_none_fd")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"same_dg_fd")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"sep_dg_none_fd")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"dcgo_n1st_clss_flg_fd")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"dcgo_n2nd_clss_flg_fd")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"dcgo_n3rd_clss_flg_fd")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"dcgo_n4th_clss_flg_fd")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"dcgo_n5th_clss_flg_fd")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"dcgo_n6th_clss_flg_fd")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"dcgo_n7th_clss_flg_fd")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"dcgo_n8th_clss_flg_fd")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"dcgo_n9th_clss_flg_fd")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"dg_none_r")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"same_dg_none_r")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"same_dg_r")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"sep_dg_none_r")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"dcgo_n1st_clss_flg_r")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"dcgo_n2nd_clss_flg_r")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"dcgo_n3rd_clss_flg_r")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"dcgo_n4th_clss_flg_r")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"dcgo_n5th_clss_flg_r")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"dcgo_n6th_clss_flg_r")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"dcgo_n7th_clss_flg_r")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"dcgo_n8th_clss_flg_r")
            //				+"|"+ sheetObjects[4].GetCellValue(dupkey[i], sheetNo+"dcgo_n9th_clss_flg_r")
            + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "fm_tr_dys") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "to_tr_dys") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "fp_teu_qty");

        k = 0;
        for (var j = startRow; j <= lastRow; j++) {
            dupStringSheet[j] = sheetObjects[4].GetCellValue(j, sheetNo + "lgs_cost_cd")
                //														+"|"+ sheetObjects[4].CellValue(j, sheetNo+"tml_agmt_vol_ut_cd")
                + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "tml_sto_agmt_tp_cd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "ft_dys")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"io_bnd_cd")
                //+"|"+ sheetObjects[4].CellValue(j, sheetNo+"sat_flg_fd")
                //+"|"+ sheetObjects[4].CellValue(j, sheetNo+"sun_flg_fd")
                //+"|"+ sheetObjects[4].CellValue(j, sheetNo+"hol_flg_fd")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"dg_none_fd")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"same_dg_none_fd")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"same_dg_fd")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"sep_dg_none_fd")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"dcgo_n1st_clss_flg_fd")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"dcgo_n2nd_clss_flg_fd")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"dcgo_n3rd_clss_flg_fd")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"dcgo_n4th_clss_flg_fd")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"dcgo_n5th_clss_flg_fd")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"dcgo_n6th_clss_flg_fd")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"dcgo_n7th_clss_flg_fd")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"dcgo_n8th_clss_flg_fd")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"dcgo_n9th_clss_flg_fd")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"dg_none_r")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"same_dg_none_r")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"same_dg_r")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"sep_dg_none_r")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"dcgo_n1st_clss_flg_r")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"dcgo_n2nd_clss_flg_r")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"dcgo_n3rd_clss_flg_r")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"dcgo_n4th_clss_flg_r")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"dcgo_n5th_clss_flg_r")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"dcgo_n6th_clss_flg_r")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"dcgo_n7th_clss_flg_r")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"dcgo_n8th_clss_flg_r")
                //					+"|"+ sheetObjects[4].GetCellValue(j, sheetNo+"dcgo_n9th_clss_flg_r")
                + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "fm_tr_dys") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "to_tr_dys") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "fp_teu_qty");

            if (dupString[i] == dupStringSheet[j] && sheetObjects[4].GetCellValue(j, sheetNo + "ft_dys") == "F") {
                k++;
                dupStringKey[j] = sheetObjects[4].GetCellValue(j, sheetNo + "tml_cntr_sty_cd");
            } else {
                k++;
                dupStringKey[j] = "";
            }

            if (dupString[i] == dupStringSheet[j] && sheetObjects[4].GetCellValue(j, sheetNo + "ft_dys") == "") {
                dupNotFStringKey[j] = sheetObjects[4].GetCellValue(j, sheetNo + "tml_cntr_sty_cd");
            } else {
                dupNotFStringKey[j] = "";
            }

        }

        err_count = err_count + storage_cntr_sty_cdFun2(dupStringKey, dupNotFStringKey, startRow);
        dupStringKey = Array();
    }
    return err_count;
}

function storage_cntr_sty_cdFun(dupStringKey, dupNotFStringKey, startRow) {
    var inputString = "";
    var inputNotFString = "";

    var chkIO;
    var err_count = 0;

    for (var i = startRow; i < dupStringKey.length; i++) {
        if (dupStringKey[i] != undefined && dupStringKey[i] != "") {
            inputString = inputString + dupStringKey[i];
        }
    }

    for (var i = startRow; i < dupNotFStringKey.length; i++) {
        if (dupNotFStringKey[i] != undefined && dupNotFStringKey[i] != "") {
            inputNotFString = inputNotFString + dupNotFStringKey[i];
        }
    }

    if (inputString == "S" || inputString == "FM" || inputString == "MF") {
        chkIO = 0;
    } else {
        chkIO = 1;
    }

    if (chkIO > 0) {
        err_count = 0;
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != null && dupStringKey[i] != "") {
                sheetObjects[4].SetCellValue(i, "5verify_result", "F/M Column Error", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#FF0000");
                err_count++;
            }
        }
    } else if (err_count == 0) {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[4].SetCellValue(i, "5verify_result", "", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    }
    if (err_count > 0) {
        return err_count;
    }

    if (inputNotFString == "S" || inputNotFString == "FM" || inputNotFString == "MF") {
        chkIO = 0;
    } else {
        chkIO = 1;
    }

    if (chkIO > 0) {
        err_count = 0;
        for (var i = startRow; i < dupNotFStringKey.length; i++) {
            if (dupNotFStringKey[i] != null && dupNotFStringKey[i] != "") {
                sheetObjects[4].SetCellValue(i, "5verify_result", "F/M Column Error");
                sheetObjects[4].SetCellBackColor(i, 1, "#FF0000");
                err_count++;
            }
        }
    } else if (err_count == 0) {
        for (var i = startRow; i < dupNotFStringKey.length; i++) {
            if (dupNotFStringKey[i] != "") {
                sheetObjects[4].SetCellValue(i, "5verify_result", "");
                sheetObjects[4].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    }

    //		stoTotalErrCount = stoTotalErrCount + err_count; 
    return err_count;
}

/** empty 일때는 dg를 안넣어도 되게 
 *  
 * @param dupStringKey
 * @param dupNotFStringKey
 * @param startRow
 * @returns {Number}
 */
function storage_cntr_sty_cdFun2(dupStringKey, dupNotFStringKey, startRow) {
    var err_count = 0;
    var inputString = "";
    var tempArray = new Array();
    tempArray[0] = "";
    tempArray[1] = "";
    tempArray[2] = "";
    var j = 0;
    //subTrdSheet
    var originalSubTrdCd = "";
    var inputSubTrdCd = "";
    var sameCodeCount = 0;
    var inputSubTrdString = "";
    var originalSubTrdString = "";

    for (var i = startRow; i < dupStringKey.length; i++) {
        if (dupStringKey[i] != "") {
            if (dupStringKey[i] == "S") {
                tempArray[0] = "S"
            } else if (dupStringKey[i] == "F") {
                tempArray[1] = "F"
            } else if (dupStringKey[i] != "S" && dupStringKey[i] != "F" && dupStringKey[i] != "") {
                tempArray[2] = "M"
                inputString = dupStringKey[i] + "|" + inputString;
            } else {
                tempArray[0] = "";
                tempArray[1] = "";
                tempArray[2] = "";
            }
        }
    }
    if (tempArray[0] == "S" && tempArray[1] == "" && tempArray[2] == "") {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[4].SetCellValue(i, "5verify_result", "", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    } else if (tempArray[0] == "" && tempArray[1] == "F" && tempArray[2] == "M") {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[4].SetCellValue(i, "5verify_result", "", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    } else {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[4].SetCellValue(i, "5verify_result", "F/M Column Error", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#FF0000");
                err_count++;
            }

        }
    }

    if (err_count > 0) {
        return err_count;
    }

    //
    for (var i = startRow; i < dupNotFStringKey.length; i++) {
        if (dupNotFStringKey[i] != "") {
            if (dupNotFStringKey[i] == "S") {
                tempArray[0] = "S"
            } else if (dupNotFStringKey[i] == "F") {
                tempArray[1] = "F"
            } else if (dupNotFStringKey[i] != "S" && dupNotFStringKey[i] != "F" && dupNotFStringKey[i] != "") {
                tempArray[2] = "M"
                inputString = dupNotFStringKey[i] + "|" + inputString;
            } else {
                tempArray[0] = "";
                tempArray[1] = "";
                tempArray[2] = "";
            }
        }
    }
    if (tempArray[0] == "S" && tempArray[1] == "" && tempArray[2] == "") {
        for (var i = startRow; i < dupNotFStringKey.length; i++) {
            if (dupNotFStringKey[i] != "") {
                sheetObjects[4].SetCellValue(i, "5verify_result", "", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    } else if (tempArray[0] == "" && tempArray[1] == "F" && tempArray[2] == "M") {
        for (var i = startRow; i < dupNotFStringKey.length; i++) {
            if (dupNotFStringKey[i] != "") {
                sheetObjects[4].SetCellValue(i, "5verify_result", "", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    } else {
        for (var i = startRow; i < dupNotFStringKey.length; i++) {

            if (dupNotFStringKey[i] != "") {
                sheetObjects[4].SetCellValue(i, "5verify_result", "F/M Column Error", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#FF0000");
                err_count++;
            }

        }
    }


    return err_count;
}


/**
 * Storage Rate List Tab Tier Volume Value Data Verify. <br>
 * @param{verifyKey_4}	verifyKey_4	verifyKey_4
 * @param{startRow}		startRow	startRow
 * @param{lastRow}		lastRow		lastRow
 * @param{rowFtDys}		rowFtDys	rowFtDys
 **/
function storage_tr_vol_val_verify(verifyKey_4, startRow, lastRow, rowFtDys) {
    var i;
    var j = 0;
    var sheetNo = 5;
    var dupkey = new Array();
    var dupTempKey = "";
    for (i = 0; i < verifyKey_4.length; i++) {
        if (i == 0) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_4[i];
            j++
        }
        if (dupTempKey != verifyKey_4[i]) {
            dupkey[j] = i + startRow;
            dupTempKey = verifyKey_4[i];
            j++;
        }
    }
    var dupString = new Array();
    var dupStringSheet = new Array();
    var dupStringKey = new Array();
    var seqDupRowKey = new Array();
    var err_count = 0;

    for (i = 0; i < dupkey.length; i++) {
        dupString[i] = sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "lgs_cost_cd")
            //										+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"tml_agmt_vol_ut_cd")
            + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "tml_cntr_sty_cd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "tml_sto_agmt_tp_cd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "ft_dys") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "io_bnd_cd")
            //+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"sat_flg_fd")
            //+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"sun_flg_fd")
            //+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"hol_flg_fd")
            + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dg_none_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "same_dg_none_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "same_dg_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "sep_dg_none_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n1st_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n2nd_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n3rd_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n4th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n5th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n6th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n7th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n8th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n9th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dg_none_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "same_dg_none_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "same_dg_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "sep_dg_none_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n1st_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n2nd_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n3rd_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n4th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n5th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n6th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n7th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n8th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "dcgo_n9th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(dupkey[i], sheetNo + "fp_teu_qty");

        k = 0;
        for (var j = startRow; j <= lastRow; j++) {
            dupStringSheet[j] = sheetObjects[4].GetCellValue(j, sheetNo + "lgs_cost_cd")
                //														+"|"+ sheetObjects[4].CellValue(j, sheetNo+"tml_agmt_vol_ut_cd")
                + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "tml_cntr_sty_cd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "tml_sto_agmt_tp_cd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "ft_dys") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "io_bnd_cd")
                //+"|"+ sheetObjects[4].CellValue(j, sheetNo+"sat_flg_fd")
                //+"|"+ sheetObjects[4].CellValue(j, sheetNo+"sun_flg_fd")
                //+"|"+ sheetObjects[4].CellValue(j, sheetNo+"hol_flg_fd")
                + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dg_none_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "same_dg_none_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "same_dg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "sep_dg_none_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n1st_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n2nd_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n3rd_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n4th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n5th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n6th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n7th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n8th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n9th_clss_flg_fd") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dg_none_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "same_dg_none_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "same_dg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "sep_dg_none_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n1st_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n2nd_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n3rd_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n4th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n5th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n6th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n7th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n8th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "dcgo_n9th_clss_flg_r") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "fp_teu_qty");

            if (dupString[i] == dupStringSheet[j] && sheetObjects[4].GetCellValue(j, sheetNo + "ft_dys") == "" && sheetObjects[4].GetCellValue(j, sheetNo + "tml_sto_agmt_tp_cd") != "FP") {
                k++;
                dupStringKey[j] = sheetObjects[4].GetCellValue(j, sheetNo + "fm_tr_dys") + "|" + sheetObjects[4].GetCellValue(j, sheetNo + "to_tr_dys");

            } else {
                k++;
                dupStringKey[j] = "";
            }
        }

        err_count = err_count + storage_tr_vol_valFun(dupStringKey, startRow, rowFtDys);
        dupStringKey = Array();
    }
    return err_count;
}
/**
 * Storage Rate List Tab Tier Volume Value Data Verify. <br>
 * @param{dupStringKey}	dupStringKey	dupStringKey
 * @param{startRow}		startRow	startRow
 * @param{rowFtDys}		rowFtDys	rowFtDys
 **/
function storage_tr_vol_valFun(dupStringKey, startRow, rowFtDys) {
    var inputString = "";
    var err_count = 0;
    var tempArray = "";
    var tempArrayKey = "";
    var tempString = "";
    var tempstartRow = startRow;
    for (var i = startRow; i < dupStringKey.length; i++) {
        if (dupStringKey[i] != "") {
            if (tempstartRow < i) {
                tempArrayKey = dupStringKey[i].split("|");
                if (tempArray[1].toUpperCase() == "MAX") {
                    tempArray[1] = 999;
                }
                if (tempArrayKey[1].toUpperCase() == "MAX") {
                    tempArrayKey[1] = 999;
                }
                if (tempArray[0] < 1 || tempArrayKey[0] < 1) {
                    err_count = 1;
                }
                if (tempArray[0] == tempArrayKey[0]) {
                    err_count = 1;
                }
                if (tempArray[1] != (parseInt(tempArrayKey[0]) - 1)) {
                    err_count = 1;
                } else if (tempArray[1] == (parseInt(tempArrayKey[0]) - 1)) {
                    tempArray[1] = tempArrayKey[1];
                }
            } else {
                tempArray = dupStringKey[i].split("|");
                if (tempArray[1].toUpperCase() == "MAX") {
                    tempArray[1] = 999;
                }
            }
        } else {
            tempstartRow = tempstartRow + 1;
        }
        tempArrayKey = "";
    }
    if (tempArray[0] == 1 && tempArray[1] == 999) {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[4].SetCellValue(i, "5verify_result", "", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#0000FF");
            }
        }
    } else {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[4].SetCellValue(i, "5verify_result", "Last Tier Over Days in 'To' column must be 999.", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#FF0000");
                err_count++;
            }
        }
    }
    if (err_count > 0) {
        for (var i = startRow; i < dupStringKey.length; i++) {
            if (dupStringKey[i] != "") {
                sheetObjects[4].SetCellValue(i, "5verify_result", "Last Tier Over Days in 'To' column must be 999.", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#FF0000");
                err_count++;
            }
        }
    }

    //		stoTotalErrCount = err_count + stoTotalErrCount;
    return err_count;
}
/**
 * Storage Rate List Tab Container Rate Data Verify. <br>
 * @param{startRow}		startRow	startRow
 * @param{lastRow}		lastRow		lastRow
 **/
function storage_cntr_rate_verify(startRow, lastRow) {
    var tr_rate = 0;
    var tr_days = 0;
    var tr_total = 0;
    var teu_rate = 0;
    var box_rate = 0;
    var move_rate = 0;
    var cntrRateErrCount = 0;
    var i = 0;
    var j = 0;
    for (i = startRow; i <= lastRow; i++) {
        for (j = 42 + gap_st; j < 67 + gap_st; j++) {
            tr_days = parseInt(sheetObjects[4].GetCellValue(i, j)) + tr_days;
        }
        for (j = 67 + gap_st; j < 92 + gap_st; j++) {
            tr_rate = parseInt(sheetObjects[4].GetCellValue(i, j)) + tr_rate;
        }

        tr_total = tr_rate + tr_days;
        teu_rate = sheetObjects[4].GetCellValue(i, "5teu_rate");
        box_rate = sheetObjects[4].GetCellValue(i, "5box_rate");
        move_rate = sheetObjects[4].GetCellValue(i, "5move_rate");

        if (sheetObjects[4].GetCellValue(i, "5tml_sto_agmt_tp_cd") == "FD" && sheetObjects[4].GetCellValue(i, '5ft_dys') == "") {
            if (sheetObjects[4].GetCellValue(i, "5tml_agmt_vol_ut_cd") == "C") {
                if (teu_rate == 0 && box_rate == 0 && move_rate == 0) {
                    sheetObjects[4].SetCellValue(i, "5verify_result", "", 0);
                    sheetObjects[4].SetCellBackColor(i, 1, "#0000FF");
                } else {
                    sheetObjects[4].SetCellValue(i, "5verify_result", "Days / Rate Column Error", 0);
                    sheetObjects[4].SetCellBackColor(i, 1, "#FF0000");
                    cntrRateErrCount++;
                }
            } else if (sheetObjects[4].GetCellValue(i, "5tml_agmt_vol_ut_cd") == "T") {
                if (tr_total == 0 && teu_rate > 0 && box_rate == 0 && move_rate == 0) {
                    sheetObjects[4].SetCellValue(i, "5verify_result", "", 0);
                    sheetObjects[4].SetCellBackColor(i, 1, "#0000FF");
                } else {
                    sheetObjects[4].SetCellValue(i, "5verify_result", "Days / Rate Column Error", 0);
                    sheetObjects[4].SetCellBackColor(i, 1, "#FF0000");
                    cntrRateErrCount++;
                }
            } else if (sheetObjects[4].GetCellValue(i, "5tml_agmt_vol_ut_cd") == "U") {
                if (tr_total == 0 && teu_rate == 0 && box_rate > 0 && move_rate == 0) {
                    sheetObjects[4].SetCellValue(i, "5verify_result", "", 0);
                    sheetObjects[4].SetCellBackColor(i, 1, "#0000FF");
                } else {
                    sheetObjects[4].SetCellValue(i, "5verify_result", "Days / Rate Column Error", 0);
                    sheetObjects[4].SetCellBackColor(i, 1, "#FF0000");
                    cntrRateErrCount++;
                }
            } else if (sheetObjects[4].GetCellValue(i, "5tml_agmt_vol_ut_cd") == "M") {
                if (tr_total == 0 && teu_rate == 0 && box_rate == 0 && move_rate > 0) {
                    sheetObjects[4].SetCellValue(i, "5verify_result", "", 0);
                    sheetObjects[4].SetCellBackColor(i, 1, "#0000FF");
                } else {
                    sheetObjects[4].SetCellValue(i, "5verify_result", "Days / Rate Column Error", 0);
                    sheetObjects[4].SetCellBackColor(i, 1, "#FF0000");
                    cntrRateErrCount++;
                }
            }
            /**
            if(tr_rate == 0 && tr_days == 0 && teu_rate == 0 && box_rate == 0 && move_rate == 0){
            		sheetObjects[4].SetCellValue(i,"5verify_result","Days / Rate Column Error",0);
            		sheetObjects[4].SetCellBackColor(i,1,"#FF0000");
            		cntrRateErrCount++;
            }
            **/
            if (sheetObjects[4].GetCellValue(i, "5ft_dys") == "" && sheetObjects[4].GetCellValue(i, "5tml_agmt_vol_ut_cd") == "C") {
                if (tr_days == 0) {
                    sheetObjects[4].SetCellValue(i, "5verify_result", "", 0);
                    sheetObjects[4].SetCellBackColor(i, 1, "#0000FF");
                } else if (tr_days > 0) {
                    sheetObjects[4].SetCellValue(i, "5verify_result", "Days Column Error", 0);
                    sheetObjects[4].SetCellBackColor(i, 1, "#FF0000");
                    cntrRateErrCount++;
                }
            }
        } else if (sheetObjects[4].GetCellValue(i, "5tml_sto_agmt_tp_cd") == "FD" && sheetObjects[4].GetCellValue(i, '5ft_dys') == "F") {
            if ((tr_rate + move_rate + box_rate + teu_rate) > 0) {
                sheetObjects[4].SetCellValue(i, "5verify_result", "Rate Column Error", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#FF0000");
                cntrRateErrCount++;
            } else if (tr_days > 0) {
                sheetObjects[4].SetCellValue(i, "5verify_result", "", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#0000FF");
            }
        } else if (sheetObjects[4].GetCellValue(i, "5tml_sto_agmt_tp_cd") == "FP") {
            if ((tr_days + move_rate) > 0) {
                sheetObjects[4].SetCellValue(i, "5verify_result", "Days / Rate Column Error", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#FF0000");
                cntrRateErrCount++;
            } else if ((tr_rate + tr_days + box_rate + move_rate) == 0 && teu_rate > 0) {
                sheetObjects[4].SetCellValue(i, "5verify_result", "", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#0000FF");
            }
            if (sheetObjects[4].GetCellValue(i, "5fp_teu_qty") > 0) {
                sheetObjects[4].SetCellValue(i, "5verify_result", "", 0);
                sheetObjects[4].SetCellBackColor(i, 1, "#0000FF");
            }
            //              2015 01 27 변경				
            //				else if(sheetObjects[4].GetCellValue(i,"5fp_teu_qty")==0){
            //					sheetObjects[4].SetCellValue(i,"5verify_result","Pool TEU Column Error",0);
            //					sheetObjects[4].SetCellBackColor(i,1,"#FF0000");
            //					cntrRateErrCount++;
            //				}
        }
        tr_rate = 0;
        tr_days = 0;
    }
    //		stoTotalErrCount = cntrRateErrCount + stoTotalErrCount;		
    return cntrRateErrCount;
}
/**
 * Storage Rate List Tab Data Verify. <br>
 **/
function dataStorageVerify() {
    var k = sheetObjects[4].RowCount() + 3;
    var dataErrCount = 0;
    var vrfyFlg;
    var vrfyRateSum = 0;
    var vrfyDysSum = 0;
    for (var i = 3; i < k; i++) {
        vrfyFlg = sheetObjects[7].GetCellValue(i - 2, 1).split("|");
        sheetObjects[4].SetCellValue(i, "5vrfyflg", sheetObjects[7].GetCellValue(i - 2, 1), 0);
        sheetObjects[4].SetRowBackColor(i, "#FFFFFF");
        if (sheetObjects[4].GetCellValue(i, "5lgs_cost_cd") != sheetObjects[7].GetCellValue(i - 2, 0)) {
            sheetObjects[4].SetCellBackColor(i, "5lgs_cost_cd", "#FF0000");
            dataErrCount++;
        }
        if (sheetObjects[4].GetCellValue(i, "5lgs_cost_cd") == "") {
            sheetObjects[4].SetCellBackColor(i, "5lgs_cost_cd", "#FF0000");
            dataErrCount++;
        }
        if (sheetObjects[4].GetCellValue(i, "5curr_cd") == "") {
            sheetObjects[4].SetCellBackColor(i, "5curr_cd", "#FF0000");
            dataErrCount++;
        }

        vrfyDysSum = parseInt(sheetObjects[4].GetCellValue(i, '5d2_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5d4_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5d5_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5d7_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5d8_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5d9_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5dw_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5dx_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5r4_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5r5_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5r7_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5f2_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5f4_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5o2_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5o4_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5s2_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5s4_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5t2_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5t4_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5a2_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5a4_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5p2_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5p4_fd')) + parseInt(sheetObjects[4].GetCellValue(i, '5f5_fd'));
        //		alert(vrfyDysSum);
        vrfyRateSum = parseInt(sheetObjects[4].GetCellValue(i, '5d2_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5d4_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5d5_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5d7_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5d8_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5d9_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5dw_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5dx_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5r4_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5r5_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5r7_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5f2_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5f4_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5o2_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5o4_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5s2_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5s4_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5t2_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5t4_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5a2_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5a4_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5p2_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5p4_r')) + parseInt(sheetObjects[4].GetCellValue(i, '5f5_r'));

        if (sheetObjects[4].GetCellValue(i, '5tml_agmt_vol_ut_cd') == "C" && sheetObjects[4].GetCellValue(i, '5ft_dys') == "") {
            if (sheetObjects[4].GetCellValue(i, '5teu_rate') > 0) {
                sheetObjects[4].SetCellBackColor(i, '5teu_rate', "#FF0000");
                dataErrCount++;
            } else if (sheetObjects[4].GetCellValue(i, '5box_rate') > 0) {
                sheetObjects[4].SetCellBackColor(i, '5box_rate', "#FF0000");
                dataErrCount++;
            } else if (sheetObjects[4].GetCellValue(i, '5move_rate') > 0) {
                sheetObjects[4].SetCellBackColor(i, '5move_rate', "#FF0000");
                dataErrCount++;
            } else if (sheetObjects[4].GetCellValue(i, '5tonne_rate') > 0) {
                sheetObjects[4].SetCellBackColor(i, '5tonne_rate', "#FF0000");
                dataErrCount++;
            }
        } else if (sheetObjects[4].GetCellValue(i, '5tml_agmt_vol_ut_cd') == "T" && sheetObjects[4].GetCellValue(i, '5ft_dys') == "") {
            if (vrfyDysSum > 0 || vrfyRateSum > 0) {
            } else if (sheetObjects[4].GetCellValue(i, '5teu_rate') == 0.00) {
                sheetObjects[4].SetCellBackColor(i, '5teu_rate', "#FF0000");
                dataErrCount++;
            } else if (sheetObjects[4].GetCellValue(i, '5box_rate') > 0) {
                sheetObjects[4].SetCellBackColor(i, '5box_rate', "#FF0000");
                dataErrCount++;
            } else if (sheetObjects[4].GetCellValue(i, '5move_rate') > 0) {
                sheetObjects[4].SetCellBackColor(i, '5move_rate', "#FF0000");
                dataErrCount++;
            } else if (sheetObjects[4].GetCellValue(i, '5tonne_rate') > 0) {
                sheetObjects[4].SetCellBackColor(i, '5tonne_rate', "#FF0000");
                dataErrCount++;
            }
        } else if (sheetObjects[4].GetCellValue(i, '5tml_agmt_vol_ut_cd') == "U" && sheetObjects[4].GetCellValue(i, '5ft_dys') == "") {
            if (sheetObjects[4].GetCellValue(i, '5teu_rate') > 0) {
                sheetObjects[4].SetCellBackColor(i, '5teu_rate', "#FF0000");
                dataErrCount++;
            } else if (sheetObjects[4].GetCellValue(i, '5box_rate') == 0.00) {
                sheetObjects[4].SetCellBackColor(i, '5box_rate', "#FF0000");
                dataErrCount++;
            } else if (sheetObjects[4].GetCellValue(i, '5move_rate') > 0) {
                sheetObjects[4].SetCellBackColor(i, '5move_rate', "#FF0000");
                dataErrCount++;
            } else if (sheetObjects[4].GetCellValue(i, '5tonne_rate') > 0) {
                sheetObjects[4].SetCellBackColor(i, '5tonne_rate', "#FF0000");
                dataErrCount++;
            }
        } else if (sheetObjects[4].GetCellValue(i, '5tml_agmt_vol_ut_cd') == "M" && sheetObjects[4].GetCellValue(i, '5ft_dys') == "") {
            if (sheetObjects[4].GetCellValue(i, '5teu_rate') > 0) {
                sheetObjects[4].SetCellBackColor(i, '5teu_rate', "#FF0000");
                dataErrCount++;
            } else if (sheetObjects[4].GetCellValue(i, '5box_rate') > 0) {
                sheetObjects[4].SetCellBackColor(i, '5box_rate', "#FF0000");
                dataErrCount++;
            } else if (sheetObjects[4].GetCellValue(i, '5move_rate') == 0.00) {
                sheetObjects[4].SetCellBackColor(i, '5move_rate', "#FF0000");
                dataErrCount++;
            } else if (sheetObjects[4].GetCellValue(i, '5tonne_rate') > 0) {
                sheetObjects[4].SetCellBackColor(i, '5tonne_rate', "#FF0000");
                dataErrCount++;
            }
        } else if (sheetObjects[4].GetCellValue(i, '5tml_agmt_vol_ut_cd') == "M" && sheetObjects[4].GetCellValue(i, '5ft_dys') == "") {
            if (sheetObjects[4].GetCellValue(i, '5teu_rate') > 0) {
                sheetObjects[4].SetCellBackColor(i, '5teu_rate', "#FF0000");
                dataErrCount++;
            } else if (sheetObjects[4].GetCellValue(i, '5box_rate') > 0) {
                sheetObjects[4].SetCellBackColor(i, '5box_rate', "#FF0000");
                dataErrCount++;
            } else if (sheetObjects[4].GetCellValue(i, '5move_rate') > 0) {
                sheetObjects[4].SetCellBackColor(i, '5move_rate', "#FF0000");
                dataErrCount++;
            } else if (sheetObjects[4].GetCellValue(i, '5tonne_rate') = 0.00) {
                sheetObjects[4].SetCellBackColor(i, '5tonne_rate', "#FF0000");
                dataErrCount++;
            }
        }
        
        if (sheetObjects[4].GetCellValue(i, '5ft_dys') == "F") {
            if (sheetObjects[4].GetCellValue(i, '5teu_rate') > 0) {
                sheetObjects[4].SetCellBackColor(i, '5teu_rate', "#FF0000");
                dataErrCount++;
            } else if (sheetObjects[4].GetCellValue(i, '5box_rate') > 0) {
                sheetObjects[4].SetCellBackColor(i, '5box_rate', "#FF0000");
                dataErrCount++;
            } else if (sheetObjects[4].GetCellValue(i, '5move_rate') > 0) {
                sheetObjects[4].SetCellBackColor(i, '5move_rate', "#FF0000");
                dataErrCount++;
            }
        }
        
        // sto_com_cmnc_tm_flg
        if (vrfyFlg[0] == "Y" && sheetObjects[4].GetCellValue(i, '5tml_agmt_vol_ut_cd') == "W") {
            sheetObjects[4].SetCellBackColor(i, '5tml_agmt_vol_ut_cd', "#FF0000");
            sheetObjects[4].SetCellValue(i, "5verify_result", "It isn't permitted to register 'W' as Volume UOM for auto cost codes.");
            dataErrCount++;
        } 
        
        // sto_com_cmnc_tm_flg
        if (vrfyFlg[11] == "Y") {
            if (sheetObjects[4].GetCellValue(i, '5cmnc_hrmnt') == "") {
                sheetObjects[4].SetCellBackColor(i, '5cmnc_hrmnt', "#FF0000");
                dataErrCount++;
            }
        } else if (vrfyFlg[11] == "N") {
            if (sheetObjects[4].GetCellValue(i, '5cmnc_hrmnt') != "") {
                sheetObjects[4].SetCellBackColor(i, '5cmnc_hrmnt', "#FF0000");
                dataErrCount++;
            }
        }
        /**
		if (vrfyFlg[12] == "Y" && sheetObjects[4].GetCellValue(i,'5ft_dys')=="F"){
		if(sheetObjects[4].GetCellValue(i,'5io_bnd_cd') == ""){
							sheetObjects[4].SetCellBackColor(i,'5io_bnd_cd',"#FF0000");
							dataErrCount++;
						}
		}else if (vrfyFlg[12] == "Y" && sheetObjects[4].GetCellValue(i,'5ft_dys')==""){
		if(sheetObjects[4].GetCellValue(i,'5io_bnd_cd') != ""){
							sheetObjects[4].SetCellBackColor(i,'5io_bnd_cd',"#FF0000");
							dataErrCount++;
						}
					}else if (vrfyFlg[12] == "N"){
		if(sheetObjects[4].GetCellValue(i,'5io_bnd_cd') != ""){
							sheetObjects[4].SetCellBackColor(i,'5io_bnd_cd',"#FF0000");
							dataErrCount++;
						}
					}
					**/
        // sto_free_dy_io_bnd_flg
        if (vrfyFlg[12] == "Y" && sheetObjects[4].GetCellValue(i, '5tml_sto_agmt_tp_cd') == "FD") {
            if (sheetObjects[4].GetCellValue(i, '5io_bnd_cd') == "") {
                sheetObjects[4].SetCellBackColor(i, '5io_bnd_cd', "#FF0000");
                dataErrCount++;
            }
        } else if (vrfyFlg[12] == "N") {
            if (sheetObjects[4].GetCellValue(i, '5io_bnd_cd') != "") {
                sheetObjects[4].SetCellBackColor(i, '5io_bnd_cd', "#FF0000");
                dataErrCount++;
            }
        }
        // sto_free_dy_flg
        if (vrfyFlg[13] == "Y") {
            if (sheetObjects[4].GetCellValue(i, '5tml_sto_agmt_tp_cd') != "FD" && sheetObjects[4].GetCellValue(i, '5tml_sto_agmt_tp_cd') != "FP") {
                sheetObjects[4].SetCellBackColor(i, '5tml_sto_agmt_tp_cd', "#FF0000");
                dataErrCount++;
            }
        }
        //		else if (vrfyFlg[13] == "N"){ //20150521 주석처리함
        //			if(sheetObjects[4].GetCellValue(i,'5tml_sto_agmt_tp_cd') != ""){
        //							sheetObjects[4].SetCellBackColor(i,'5tml_sto_agmt_tp_cd',"#FF0000");
        //							dataErrCount++;
        //			}
        //		}
        // sto_free_dy_dcgo_tm_flg (sheetObjects[2].GetCellValue(i,'3tml_cntr_sty_cd')== "" || sheetObjects[2].GetCellValue(i,'3tml_cntr_sty_cd')== "F" || sheetObjects[2].GetCellValue(i,'3tml_cntr_sty_cd')== "S")
        if (sheetObjects[4].GetCellValue(i, '5ft_dys') == "F" && vrfyFlg[14] == "Y") {
            if ((sheetObjects[4].GetCellValue(i, '5dg_none_fd') == "" &&
                    sheetObjects[4].GetCellValue(i, '5same_dg_none_fd') == "" &&
                    sheetObjects[4].GetCellValue(i, '5same_dg_fd') == "" &&
                    sheetObjects[4].GetCellValue(i, '5sep_dg_none_fd') == "" &&
                    sheetObjects[4].GetCellValue(i, '5dcgo_n1st_clss_flg_fd') == "" &&
                    sheetObjects[4].GetCellValue(i, '5dcgo_n2nd_clss_flg_fd') == "" &&
                    sheetObjects[4].GetCellValue(i, '5dcgo_n3rd_clss_flg_fd') == "" &&
                    sheetObjects[4].GetCellValue(i, '5dcgo_n4th_clss_flg_fd') == "" &&
                    sheetObjects[4].GetCellValue(i, '5dcgo_n5th_clss_flg_fd') == "" &&
                    sheetObjects[4].GetCellValue(i, '5dcgo_n6th_clss_flg_fd') == "" &&
                    sheetObjects[4].GetCellValue(i, '5dcgo_n7th_clss_flg_fd') == "" &&
                    sheetObjects[4].GetCellValue(i, '5dcgo_n8th_clss_flg_fd') == "" &&
                    sheetObjects[4].GetCellValue(i, '5dcgo_n9th_clss_flg_fd') == "" &&
                    (sheetObjects[4].GetCellValue(i, '5tml_cntr_sty_cd') == "" || sheetObjects[4].GetCellValue(i, '5tml_cntr_sty_cd') == "F" || sheetObjects[4].GetCellValue(i, '5tml_cntr_sty_cd') == "S")) ||
                (sheetObjects[4].GetCellValue(i, '5same_dg_none_fd') == "Y" && sheetObjects[4].GetCellValue(i, '5same_dg_fd') == "Y")) {
                sheetObjects[4].SetCellBackColor(i, '5dg_none_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5same_dg_none_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5same_dg_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5sep_dg_none_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n1st_clss_flg_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n2nd_clss_flg_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n3rd_clss_flg_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n4th_clss_flg_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n5th_clss_flg_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n6th_clss_flg_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n7th_clss_flg_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n8th_clss_flg_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n9th_clss_flg_fd', "#FF0000");
                dataErrCount++;
            }
        } else if (vrfyFlg[14] == "N") {
            if (sheetObjects[4].GetCellValue(i, '5dg_none_fd') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5same_dg_none_fd') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5same_dg_fd') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5sep_dg_none_fd') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5dcgo_n1st_clss_flg_fd') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5dcgo_n2nd_clss_flg_fd') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5dcgo_n3rd_clss_flg_fd') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5dcgo_n4th_clss_flg_fd') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5dcgo_n5th_clss_flg_fd') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5dcgo_n6th_clss_flg_fd') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5dcgo_n7th_clss_flg_fd') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5dcgo_n8th_clss_flg_fd') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5dcgo_n9th_clss_flg_fd') == "Y") {
                sheetObjects[4].SetCellBackColor(i, '5dg_none_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5same_dg_none_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5same_dg_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5sep_dg_none_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n1st_clss_flg_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n2nd_clss_flg_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n3rd_clss_flg_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n4th_clss_flg_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n5th_clss_flg_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n6th_clss_flg_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n7th_clss_flg_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n8th_clss_flg_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n9th_clss_flg_fd', "#FF0000");
                dataErrCount++;
            }
        }
        /**
					if (vrfyFlg[15] == "Y"){
		if(sheetObjects[4].GetCellValue(i,'5sat_flg_fd') == "" && sheetObjects[4].GetCellValue(i,'5sun_flg_fd') == "" && sheetObjects[4].GetCellValue(i,'5hol_flg_fd') == "" ){
							sheetObjects[4].SetCellBackColor(i,'5sat_flg_fd',"#FF0000");
							sheetObjects[4].SetCellBackColor(i,'5sun_flg_fd',"#FF0000");
							sheetObjects[4].SetCellBackColor(i,'5hol_flg_fd',"#FF0000");
							//sheetObjects[4].CellBackColor(i,'5xcld_dy_aply_tp_cd') = "E";
							dataErrCount++;
						}
					}else if (vrfyFlg[15] == "N"){
		if(sheetObjects[4].GetCellValue(i,'5sat_flg_fd') == "Y" || sheetObjects[4].GetCellValue(i,'5sun_flg_fd') == "Y" || sheetObjects[4].GetCellValue(i,'5hol_flg_fd') == "Y" ){
							sheetObjects[4].SetCellBackColor(i,'5sat_flg_fd',"#FF0000");
							sheetObjects[4].SetCellBackColor(i,'5sun_flg_fd',"#FF0000");
							sheetObjects[4].SetCellBackColor(i,'5hol_flg_fd',"#FF0000");
							//sheetObjects[4].CellBackColor(i,'5xcld_dy_aply_tp_cd') = "I";
							dataErrCount++;
						}
					}
					**/
        // sto_free_dy_dcgo_rt_flg
        if (sheetObjects[4].GetCellValue(i, '5ft_dys') == "" && vrfyFlg[16] == "Y") {
            if ((sheetObjects[4].GetCellValue(i, '5dg_none_r') == "" &&
                    sheetObjects[4].GetCellValue(i, '5same_dg_none_r') == "" &&
                    sheetObjects[4].GetCellValue(i, '5same_dg_r') == "" &&
                    sheetObjects[4].GetCellValue(i, '5sep_dg_none_r') == "" &&
                    sheetObjects[4].GetCellValue(i, '5dcgo_n1st_clss_flg_r') == "" &&
                    sheetObjects[4].GetCellValue(i, '5dcgo_n2nd_clss_flg_r') == "" &&
                    sheetObjects[4].GetCellValue(i, '5dcgo_n3rd_clss_flg_r') == "" &&
                    sheetObjects[4].GetCellValue(i, '5dcgo_n4th_clss_flg_r') == "" &&
                    sheetObjects[4].GetCellValue(i, '5dcgo_n5th_clss_flg_r') == "" &&
                    sheetObjects[4].GetCellValue(i, '5dcgo_n6th_clss_flg_r') == "" &&
                    sheetObjects[4].GetCellValue(i, '5dcgo_n7th_clss_flg_r') == "" &&
                    sheetObjects[4].GetCellValue(i, '5dcgo_n8th_clss_flg_r') == "" &&
                    sheetObjects[4].GetCellValue(i, '5dcgo_n9th_clss_flg_r') == "" &&
                    (sheetObjects[4].GetCellValue(i, '5tml_cntr_sty_cd') == "" || sheetObjects[4].GetCellValue(i, '5tml_cntr_sty_cd') == "F" || sheetObjects[4].GetCellValue(i, '5tml_cntr_sty_cd') == "S")) ||
                (sheetObjects[4].GetCellValue(i, '5same_dg_none_r') == "Y" &&
                    sheetObjects[4].GetCellValue(i, '5same_dg_r') == "Y")) {
                sheetObjects[4].SetCellBackColor(i, '5dg_none_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5same_dg_none_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5same_dg_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5sep_dg_none_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n1st_clss_flg_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n2nd_clss_flg_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n3rd_clss_flg_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n4th_clss_flg_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n5th_clss_flg_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n6th_clss_flg_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n7th_clss_flg_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n8th_clss_flg_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n9th_clss_flg_r', "#FF0000");
                dataErrCount++;
            }
        } else if (vrfyFlg[16] == "N") {
            if (sheetObjects[4].GetCellValue(i, '5dg_none_r') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5same_dg_none_r') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5same_dg_r') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5sep_dg_none_r') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5dcgo_n1st_clss_flg_r') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5dcgo_n2nd_clss_flg_r') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5dcgo_n3rd_clss_flg_r') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5dcgo_n4th_clss_flg_r') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5dcgo_n5th_clss_flg_r') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5dcgo_n6th_clss_flg_r') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5dcgo_n7th_clss_flg_r') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5dcgo_n8th_clss_flg_r') == "Y" ||
                sheetObjects[4].GetCellValue(i, '5dcgo_n9th_clss_flg_r') == "Y") {
                sheetObjects[4].SetCellBackColor(i, '5dg_none_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5same_dg_none_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5same_dg_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5sep_dg_none_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n1st_clss_flg_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n2nd_clss_flg_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n3rd_clss_flg_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n4th_clss_flg_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n5th_clss_flg_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n6th_clss_flg_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n7th_clss_flg_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n8th_clss_flg_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dcgo_n9th_clss_flg_r', "#FF0000");
                dataErrCount++;
            }
        }
        // sto_free_dy_tr_dy_flg
        if (vrfyFlg[17] == "Y" && sheetObjects[4].GetCellValue(i, '5ft_dys') == "F" && sheetObjects[4].GetCellValue(i, '5tml_sto_agmt_tp_cd') == "FD") {
            if (sheetObjects[4].GetCellValue(i, '5fm_tr_dys') != "" &&
                sheetObjects[4].GetCellValue(i, '5to_tr_dys') != "") {
                sheetObjects[4].SetCellBackColor(i, '5fm_tr_dys', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5to_tr_dys', "#FF0000");
                dataErrCount++;
            }
        } else if (vrfyFlg[17] == "Y" && sheetObjects[4].GetCellValue(i, '5ft_dys') == "" && sheetObjects[4].GetCellValue(i, '5tml_sto_agmt_tp_cd') == "FD") {
            if (sheetObjects[4].GetCellValue(i, '5fm_tr_dys') == "" ||
                sheetObjects[4].GetCellValue(i, '5to_tr_dys') == "") {
                sheetObjects[4].SetCellBackColor(i, '5fm_tr_dys', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5to_tr_dys', "#FF0000");
                dataErrCount++;
            }
        } else if (vrfyFlg[17] == "N") {
            if (sheetObjects[4].GetCellValue(i, '5fm_tr_dys') != "" ||
                sheetObjects[4].GetCellValue(i, '5to_tr_dys') != "") {
                sheetObjects[4].SetCellBackColor(i, '5fm_tr_dys', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5to_tr_dys', "#FF0000");
                dataErrCount++;
            }
        }
        // sto_fp_calc_prd_flg
        if (vrfyFlg[18] == "Y" && sheetObjects[4].GetCellValue(i, '5tml_sto_agmt_tp_cd') == "FP") {
            if (sheetObjects[4].GetCellValue(i, '5fp_calc_prd_cd') == "") {
                sheetObjects[4].SetCellBackColor(i, '5fp_calc_prd_cd', "#FF0000");
                dataErrCount++;
            }
        } else if (vrfyFlg[18] == "N") {
            if (sheetObjects[4].GetCellValue(i, '5fp_calc_prd_cd') != "") {
                sheetObjects[4].SetCellBackColor(i, '5fp_calc_prd_cd', "#FF0000");
                dataErrCount++;
            }
        }
        // sto_fp_teu_flg
        if (vrfyFlg[19] == "Y" && sheetObjects[4].GetCellValue(i, '5tml_sto_agmt_tp_cd') == "FP") {
            if (sheetObjects[4].GetCellValue(i, '5fp_teu_qty') == 0) {
                sheetObjects[4].SetCellBackColor(i, '5fp_teu_qty', "#FF0000");
                dataErrCount++;
            }
            //			else if(sheetObjects[4].GetCellValue(i,'5teu_rate') == 0 && sheetObjects[4].GetCellValue(i,'5box_rate') == 0 ) {
            //							sheetObjects[4].SetCellBackColor(i,'5teu_rate',"#FF0000");
            //							sheetObjects[4].SetCellBackColor(i,'5box_rate',"#FF0000");
            //							dataErrCount++;
            //			}
        } else if (vrfyFlg[19] == "N") {
            if (sheetObjects[4].GetCellValue(i, '5fp_teu_qty') > 0) {
                sheetObjects[4].SetCellBackColor(i, '5fp_teu_qty', "#FF0000");
                dataErrCount++;
            }
        }


        if (vrfyFlg[27] == "Y") {
            if (sheetObjects[4].GetCellValue(i, '5tml_cntr_sty_cd') == "") {
                sheetObjects[4].SetCellBackColor(i, '5tml_cntr_sty_cd', "#FF0000");
                dataErrCount++;
            }
        }

        if (sheetObjects[4].GetCellValue(i, '5ft_dys') == "F") {
            if (vrfyRateSum > 0) {
                sheetObjects[4].SetCellBackColor(i, '5d2_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5d2_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5d4_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5d5_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5d7_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5d8_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5d9_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dw_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dx_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5r2_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5r4_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5r5_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5r7_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5f2_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5f4_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5o2_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5o4_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5s2_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5s4_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5t2_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5t4_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5a2_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5a4_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5p2_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5p4_r', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5f5_r', "#FF0000");

                dataErrCount++;
            }
        } else if (sheetObjects[4].GetCellValue(i, '5ft_dys') == "") {
            if (vrfyDysSum > 0) {
                sheetObjects[4].SetCellBackColor(i, '5d2_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5d4_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5d5_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5d7_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5d8_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5d9_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dw_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5dx_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5r2_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5r4_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5r5_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5r7_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5f2_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5f4_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5o2_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5o4_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5s2_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5s4_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5t2_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5t4_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5a2_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5a4_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5p2_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5p4_fd', "#FF0000");
                sheetObjects[4].SetCellBackColor(i, '5f5_fd', "#FF0000");
                dataErrCount++;
            }
        }
        if (sheetObjects[4].GetCellValue(i, '5tml_sto_agmt_tp_cd') == "FP") {
            //						sheetObjects[4].SetCellValue(i,'5d2_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5d4_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5d5_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5d7_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5d8_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5d9_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5dw_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5dx_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5r2_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5r4_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5r5_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5r7_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5f2_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5f4_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5o2_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5o4_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5s2_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5s4_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5t2_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5t4_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5a2_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5a4_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5p2_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5p4_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5f5_fd',0.00);
            //						sheetObjects[4].SetCellValue(i,'5d2_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5d4_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5d5_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5d7_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5d8_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5d9_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5dw_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5dx_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5r2_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5r4_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5r5_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5r7_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5f2_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5f4_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5o2_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5o4_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5s2_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5s4_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5t2_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5t4_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5a2_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5a4_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5p2_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5p4_r',0.00);
            //						sheetObjects[4].SetCellValue(i,'5f5_r',0.00);
            //sheetObjects[4].CellValue(i,'5box_rate')   = 0.00;
            //sheetObjects[4].CellValue(i,'5move_rate')  = 0.00;
        }
        /**
        if(vrfyRateSum > 0 && vrfyRateSum > 0){
        		sheetObjects[4].SetCellValue(i,'5d2_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5d4_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5d5_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5d7_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5d8_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5d9_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5dw_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5dx_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5r2_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5r4_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5r5_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5r7_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5f2_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5f4_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5o2_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5o4_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5s2_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5s4_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5t2_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5t4_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5a2_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5a4_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5p2_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5p4_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5f5_fd',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5d2_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5d4_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5d5_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5d7_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5d8_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5d9_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5dw_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5dx_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5r2_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5r4_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5r5_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5r7_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5f2_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5f4_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5o2_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5o4_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5s2_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5s4_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5t2_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5t4_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5a2_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5a4_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5p2_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5p4_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5f5_r',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5teu_rate',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5box_rate',"#FF0000");
        		sheetObjects[4].SetCellValue(i,'5move_rate',"#FF0000");
        		dataErrCount++;
        }
        **/
        //dataErrCount  = errCount;
        vrfyFlg = "";
    }
    return dataErrCount;
}

var verify_t;
var verify_t1;
var beforeibflag;


/*var beforeibflag=new Array();
if(formObject.tml_agmt_sts_cd.value!="" && formObject.tml_agmt_ofc_cty_cd.value!="" && formObject.tml_agmt_ver_no.value!="" && (sheetObjects[2].RowCount()>0)){
	if(dupRowCheck('T')==false){
		return false;
	}
	sheetObjects[2].ColumnSort("3lgs_cost_cd|3io_bnd_cd|3ioc_cd|3tml_dy_aply_tp_cd|3lane_cd|3dcgo_aply_tp_cd|3tml_vol_aply_tp_cd|3fm_tr_vol_val|3to_tr_vol_val|3tml_ovt_shft_cd|3thc_tp_cd", "ASC");
	for(i=0;i<sheetObject2.RowCount();i++){
		beforeibflag[i]=sheetObject2.GetRowStatus(i+3);
	  }
	doActionIBSheet8(sheetObject7,formObject,IBSEARCH);
	if(dataTerminalErrCount>0){
		ComShowCodeMessage('TES10031');   //Please modify Terminal Rate List Sheet Data.
	} else {
		sheetObjects[2].ColumnSort("3auto_calc_flg", "DESC");
		tab2VerifyFlg=terminalRateListVerify_test1(beforeibflag);
		if(tab2VerifyFlg){
			ComShowCodeMessage('TES10032');    //Terminal Rate List Verify has been completed.
		} else {
			ComShowCodeMessage('TES10033');    //Please check Terminal Agreement again.
		}
		setTooltip(sheetObjects[2],3+'verify_result');
	}
} else {
	ComShowCodeMessage('TES10034');   //There is no necessary data for Verify.\n\n Please check again.
}*/

// Temp function
function t2btng_verify(formObject, sheetObjects, sheetObject2, sheetObject7) {
    beforeibflag = new Array();

    if (formObject.tml_agmt_sts_cd.value != "" && formObject.tml_agmt_ofc_cty_cd.value != "" && formObject.tml_agmt_ver_no.value != "" && (sheetObjects[2].RowCount() > 0)) {
        for (i = 0; i < sheetObjects[2].RowCount() + 3; i++) {
            sheetObjects[2].SetRowBackColor(i, "");
            // 69 column
            for (j = 0; j < 69; j++) {
                sheetObjects[2].SetCellBackColor(i, j, "");
            }
        }

        for (k = 0; k < sheetObjects[2].RowCount(); k++) {
            beforeibflag[k] = sheetObjects[2].GetRowStatus(k + 3);
            // Verify Result initialization
            sheetObjects[2].SetCellValue(k + 3, "3verify_result", "");
        }

        if (dupRowCheck('T') == false) {
            return false;
        }

        sheetObjects[2].ColumnSort("3auto_calc_flg|3lgs_cost_cd|3io_bnd_cd|3ioc_cd|3tml_dy_aply_tp_cd|3sub_trd_cd|3lane_cd|3dcgo_aply_tp_cd|3tml_vol_aply_tp_cd|3tml_ovt_shft_cd|3thc_tp_cd|3tml_cntr_sty_cd|3fm_tr_vol_val|3to_tr_vol_val", "ASC", "DESC|ASC|ASC|ASC|ASC|ASC|ASC|ASC|ASC|ASC|ASC|ASC|ASC|ASC", 1);
        //			sheetObjects[2].ColumnSort("3auto_calc_flg|3lgs_cost_cd|3io_bnd_cd|3ioc_cd|3tml_dy_aply_tp_cd|3lane_cd|3dcgo_aply_tp_cd|3tml_vol_aply_tp_cd|3fm_tr_vol_val|3to_tr_vol_val|3tml_ovt_shft_cd|3thc_tp_cd|3tml_cntr_sty_cd|3sub_trd_cd", "ASC", "DESC|ASC|ASC|ASC|ASC|ASC|ASC|ASC|ASC|ASC|ASC|ASC|ASC", 1);
        // SetCellBackColor SetRowBackColor
        // timer
        verify_t = setTimeout("t2btng_verify_1()", 1);

    } else {
        ComShowCodeMessage('TES10034'); //There is no necessary data for Verify.\n\n Please check again.
    }
}

function t2btng_verify_1() {

    doActionIBSheet8(sheetObjects[7], document.form, IBSEARCH);

    if (dataTerminalErrCount > 0) {
        ComShowCodeMessage('TES10031'); //Please modify Terminal Rate List Sheet Data.
    } else {
        verify_t1 = setTimeout("t2btng_verify_2()", 1);
    }
}

function t2btng_verify_2() {
    tab2VerifyFlg = terminalRateListVerify_test1(beforeibflag);

    if (tab2VerifyFlg) {
        ComShowCodeMessage('TES10032'); //Terminal Rate List Verify has been completed.
    } else {
        ComShowCodeMessage('TES10033'); //Please check Terminal Agreement again.
    }
    setTooltip(sheetObjects[2], 3 + 'verify_result');
} 


/**
 * Array Data Duplicate Remove
 * 
 * @param arr
 * @returns {Array}
 */
function dupRemove (arr) {
	var chk = [];
	for (var i = 0; i < arr.length; i++) {
		if (chk.length == 0) {
			chk.push(arr[i]);
		} else {
			var flg = true;
			for (var j = 0; j < chk.length; j++) {
				if (chk[j] == arr[i]) {
					flg = false;
					break;
				}
			}
			if (flg) {
				chk.push(arr[i]);
			}
		}
	}
	return chk;
}


/**
 * I/O Bound, IPC/Ocean Validation Check( Same Or I/O 만 가능.)
 * 
 * @param dupRowCd 중복된 첫번째 행
 * @param dupRowCd2 중복된 행
 * @param sheetObject
 * @param sheetNo
 * @param chkArrCd [S, IO, OI] Same Or IO만 가능한 경우.
 * @param validChkCd io_bnd_cd, ioc_cd
 * @returns {Number}
 */
function dupRow_validCheck(dupRowCd, dupRowCd2, sheetObject, sheetNo, chkArrCd, validChkCd) {
	var validErrCnt	= 0;
	sheetNo == null || sheetNo == "undefined" ? "3" : sheetNo;
	
	for ( var i = 0; i < dupRowCd.length; i++) {
		// Auto Calc Method = 'Auto'
		if (sheetObject.GetCellValue(dupRowCd[i], sheetNo + "auto_calc_flg") == "Y") {
			var dupRowString = [];
			var dupRowIdx = [];
			var dupRowOriString = "";
			var dupRowOriStringKey = "";
			var dupRowChkStringKey = "";
			var dupRowOriCostCd = "";
			var dupRowChkCostCd = "";
			var keyIdx	= "";
			var k = 0;
			var chkFlg = false;
			var costCodeVerifyFlg = sheetObject.GetCellValue(dupRowCd[i], sheetNo + "vrfyflg")

			var costCodeFlg = costCodeVerifyFlg.split("|");
			if ( validChkCd == "io_bnd_cd" ) {	// tml_io_bnd_flg
				if ( costCodeFlg[2] == "Y") {
					chkFlg = true;
				}
			}
			if ( validChkCd == "ioc_cd" ) {	// tml_ioc_flg
				if ( costCodeFlg[3] == "Y") {
					chkFlg = true;
				}
			}
			
			if ( chkFlg ) {
				dupRowOriStringKey = sheetObject.GetCellValue(dupRowCd[i], sheetNo + "lgs_cost_cd") + "|" + sheetObject.GetCellValue(dupRowCd[i], sheetNo + validChkCd);
				dupRowString[k] = sheetObject.GetCellValue(dupRowCd[i], sheetNo + validChkCd);
				for ( var j = 0; j < dupRowCd2.length; j++ ) {
					keyIdx	= sheetObject.FindText(sheetNo + "lgs_cost_cd", sheetObject.GetCellValue(dupRowCd[i], sheetNo + "lgs_cost_cd"), dupRowCd2[j], 0, 0);
					dupRowChkStringKey = sheetObject.GetCellValue(keyIdx, sheetNo + "lgs_cost_cd") + "|" + sheetObject.GetCellValue(keyIdx, sheetNo + validChkCd);
		
					if ( keyIdx > 0 ) {
		    			if ( dupRowOriStringKey != dupRowChkStringKey ) {
							k++;
							dupRowString[k] = sheetObject.GetCellValue(dupRowCd2[j], sheetNo + validChkCd);
		    			}
					}
				}
	
				var chkCd = dupRemove(dupRowString);
				var chkStr = "";
				var chkFlg = true;
				for ( var x = 0; x < chkCd.length; x++ ) {
					chkStr = chkStr + chkCd[x];
				} 
	
				for ( var ii =0; ii < chkArrCd.length; ii++ ) {
					if ( chkArrCd[ii] != chkStr ) {
						chkFlg	= false;
					} else {
						chkFlg	= true;
						break;
					}
				}
				
				// CostCode validation check Cell background color change.
				if ( !chkFlg ) {
					validErrCnt++;
					sheetObject.SetCellBackColor(dupRowCd[i], sheetNo + validChkCd, "#FF0000");
					dupRowOriCostCd = sheetObject.GetCellValue(dupRowCd[i], sheetNo + "lgs_cost_cd");
					for ( var j = 0; j < dupRowCd2.length; j++ ) {
						dupRowChkCostCd = sheetObject.GetCellValue(dupRowCd2[j], sheetNo + "lgs_cost_cd");
		    			if ( dupRowOriCostCd == dupRowChkCostCd ) {
		    				sheetObject.SetCellBackColor( dupRowCd2[j], sheetNo + validChkCd, "#FF0000");
		    			}
					}				
				}
			}
		}
	}
	
	return validErrCnt;
}
