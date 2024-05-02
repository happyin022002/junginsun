/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_2001.js
*@FileTitle : Guarantee Creation & Adjustment
*@FileTitle : Monthly
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// global variable
var sheetObjects = new Array();
var sheetCnt = 0;
var comboVal;
var iCheckRow = "";
/**
 * Event handler processing by button click event 
 */
document.onclick = processButtonClick;

/**
 * Event handler processing by button name
 **/
function processButtonClick() {
    /***** using extra sheet valuable if there are more 2 sheets *****/
    var sheetObject1 = sheetObjects[0]; // Container List Sheet.
    var sheetObject2 = sheetObjects[1]; // Header Info Hidden Sheet.
    /*******************************************************/
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        switch (srcName) {
            case "btn_retrieve":
                if (ComIsNull(formObject.gnte_no.value)) {
                    ComShowCodeMessage('TES70101'); // Please enter Reference Number.
                    formObject.gnte_no.focus();
                    return false;
                }
                
                if (formObject.gnte_no.value.length != 12) {
                    ComShowCodeMessage('TES70109'); // Please check length Guarantee No.
                    formObject.gnte_no.focus();
                    return false;
                }
                doActionIBSheet(sheetObject2, formObject, IBSEARCH);
                break;
                
            case "btn_new":
                initFormHdr(); // Header Form Init.
                initFormCntrList(); // Container List Sheet Init.
                document.getElementById("gnte_no").focus();
                break;
                
            case "btn_save":
                if (document.getElementById("delt_flg").value == "Y") {
                    ComShowCodeMessage('TES70118'); // Already Deleted.
                    return;
                }
                                
                if(!gnte_validatCustomerCode()){return;} 
                if(!gnte_validateVndrSeq()){return;}
                if(!gnte_validateYardCode()){return;}
                if(!gnte_validateOfficeCode()){return;}
                
                /* Header Info */
                //if (!ComIsNull(sheetObject2.GetCellValue(1, "ofc_cd") ) &&
                if (sheetObject2.GetCellValue(1, "ofc_cd") != "-1" && sheetObject2.GetCellValue(1, "ofc_cd") != document.getElementById("cre_ofc_cd").value) {
                    ComShowCodeMessage('TES70121'); // No authority to correct/delete the Guarantee - Creation office mismatch!
                    return false;
                }
                
                if (ComIsNull(formObject.gnte_cust_cd.value)) {
                    ComShowCodeMessage('TES70102'); // Please enter Customer Code.
                    formObject.gnte_cust_cd.focus();
                    return false;
                }
                
                if (formObject.gnte_cust_cd.value.length == 8) {
                    if (ComIsAlphabet(formObject.gnte_cust_cd.value.substring(0, 2)) == false) {
                        ComShowCodeMessage('TES70111'); // This is invalid Customer Code.
                        return false;
                    }
                    if (ComIsNumber(formObject.gnte_cust_cd.value.substring(2, 8)) == false) {
                        ComShowCodeMessage('TES70111'); // This is invalid Customer Code.
                        return false;
                    }
                }
                
                if (ComIsNull(formObject.vndr_seq.value)) {
                    ComShowCodeMessage('TES10011'); // Please enter Service Provider Code.
                    formObject.vndr_seq.focus();
                    return false;
                }                
                
                if ( ComIsNull(formObject.yd_cd.value) ) {                	
                	ComShowCodeMessage('TES10009');    // Please enter Yard Code.
                	formObject.yd_cd.focus();                	
                	return false;
                }
                
                /* Container List */
                for (var i = sheetObject1.HeaderRows(); i < sheetObject1.HeaderRows() + sheetObject1.RowCount(); i++) {
                    if (ComIsNull(sheetObject1.GetCellValue(i, "cntr_no"))) {
                        ComShowCodeMessage('TES70104'); // Please enter Container No.
                        return false;
                    }
                    // Container No. & Bkg No. Duplication Check.
                    if (!checkDupCntrNo(sheetObject1, i)) {
                        return false;
                    }
                    if (formObject.gnte_tp_cd.value == "ST") {
                        if (ComIsNull(sheetObject1.GetCellValue(i, "fm_dt"))) {
                            ComShowCodeMessage('TES70106'); // Please enter Container List start date.
                            return false;
                        }
                        if (ComIsNull(sheetObject1.GetCellValue(i, "to_dt"))) {
                            ComShowCodeMessage('TES70107'); // Please enter Container List end date.
                            return false;
                        }
                        if (ComGetDaysBetween(sheetObject1.GetCellValue(i, "fm_dt"), sheetObject1.GetCellValue(i, "to_dt")) < 0) {
                            ComShowCodeMessage('TES24012'); // Start date must be earlier than end date.
                            sheetObject1.SetCellValue(i, "to_dt", "", 0);
                            return false;
                        }
                    } else {
                        sheetObject1.SetCellValue(i, "fm_dt", "", 0);
                        sheetObject1.SetCellValue(i, "to_dt", "", 0);
                    }
                    if (ComIsNull(sheetObject1.GetCellValue(i, "gnte_amt"))) {
                        ComShowCodeMessage('TES70105'); // Please enter Amount.
                        return false;
                    }
                    if (isNaN(sheetObject1.GetCellValue(i, 'gnte_amt')) || sheetObject1.GetCellValue(i, 'gnte_amt') <= 0) {
                        ComShowCodeMessage('TES60102'); //Amount should be greater than 0.
                        return false;
                    }
                }
                // Reference Number(Guarantee No.)
                if (ComIsNull(document.getElementById("gnte_no").value)) {
                    formObject.f_cmd.value = ADD;
                    doActionIBSheet(sheetObject2, formObject, IBSAVE);
                    // Reference Number(Guarantee No.)
                } else if (!ComIsNull(document.getElementById("gnte_no").value) && formObject.gnte_no.value == sheetObject2.GetCellValue(1, "gnte_no")) {
                    formObject.f_cmd.value = MODIFY;
                    doActionIBSheet(sheetObject2, formObject, IBSAVE);
                }
                break;

            case "btn_irregular":
                if (document.getElementById("delt_flg").value == "Y") {
                    ComShowCodeMessage('TES70118'); // Already Deleted.
                    return;
                }
                if (document.getElementById("gnte_tp_cd").value != sheetObject2.GetCellValue(1, "gnte_tp_cd")) {
                    ComShowCodeMessage('TES70112'); // Save Guarantee before proceeding.
                    return false;
                }
                // Irregular Popup 
                if (sheetObject1.CheckedRows('chk') < 1) {
                    ComShowCodeMessage('TES21009');
                    return false;
                }

                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";
                var classId = "ESD_TES_2006";
                var param = "?";
                var chkStr = dispaly.substring(0, 3)
                var cntr_seq = "";
                iCheckRow = sheetObject1.FindCheckedRow("chk");
                var arrRow = iCheckRow.split("|");
                if (iCheckRow != null && arrRow.length >= 1) {
                    for (var i = 0; i < arrRow.length; i++) {
                        if (sheetObject1.GetCellValue(arrRow[i], "tml_gnte_cntr_list_seq") == null ||
                            sheetObject1.GetCellValue(arrRow[i], "tml_gnte_cntr_list_seq") == '') {
                            ComShowCodeMessage('TES70112'); // 'Save Guarantee before proceeding'
                            cntr_seq = "";
                            return false;
                        } else {
                            if (!ComIsNull(sheetObject1.GetCellValue(arrRow[i], "chk_irr"))) {
                                ComShowCodeMessage('TES70115'); // Irregular exists already.
                                cntr_seq = '';
                                return false;
                            } else if (!ComIsNull(sheetObject1.GetCellValue(arrRow[i], "chk_tpb_if"))) {
                                ComShowCodeMessage('TES70120'); // TPB I/F exists already.
                                cntr_seq = '';
                                return false;
                            } else {
                                cntr_seq = cntr_seq + sheetObject1.GetCellValue(arrRow[i], "tml_gnte_cntr_list_seq") + ",";
                            }
                        }
                    }
                    cntr_seq = cntr_seq.substring(0, cntr_seq.length - 1);
                }
                param = param + 'pgmNo=ESD_TES_2006&parentPgmNo=ESD_TES_M001' + '&gnte_flg=Y' + '&gnte_no=' + document.getElementById("gnte_no").value + '&cntr_seq=' + cntr_seq;
                var irregularUrl = "ESD_TES_2006.do" + param;
                location.href = irregularUrl;
                break;

            case "btn_tpbif":
                if (document.getElementById("delt_flg").value == "Y") {
                    ComShowCodeMessage('TES70118'); // Already Deleted.
                    return false;
                }
                
                var sGnteNo = document.getElementById("gnte_no").value;
                var sCurrCd = document.getElementById("curr_cd").value;
                var sYdCd = document.getElementById("yd_cd").value;      
                
                if (ComIsNull(sYdCd)) {
                    ComShowCodeMessage('TES10009');    // Please enter Yard Code.
                    return false;
                }
                
                // TPB BillingCase Code
                var arrBillCase;
                var isTpbBill = false;

                comboVal = tes_tpbBillcaseCodeVal(document.getElementById("n3pty_bil_tp_cd_tmp").value);

                arrBillCase = comboVal.split("|");
                for (i = 0; arrBillCase != null && i < arrBillCase.length; i++) {
                    if (arrBillCase[i] != null && arrBillCase[i] != "" && arrBillCase[i] == document.getElementById("gnte_tp_cd").value) {
                        isTpbBill = true;
                        break;
                    }
                }

                if (document.getElementById("gnte_tp_cd").value != sheetObject2.GetCellValue(1, "gnte_tp_cd")) {
                    ComShowCodeMessage('TES70112'); // Save Guarantee before proceeding.
                    return false;
                }

                if (isTpbBill == false) {
                    ComShowCodeMessage('TES70802'); // Please check charge type. The charge type is not registered on TPB.
                    return false;
                }
                // MODAL 로 변경할것.(4342-12-09)
                // TPB IF Report Designer 
                // Irregular Or TPB IF Print
                var dispaly = "0,1,1,1,1,1,1,1,1,1,1,1";
                var classId = "ESD_TES_2008";
                var param = '?classId=' + classId;
                var chkStr = dispaly.substring(0, 3)
                var cntr_seq = "";
                
                if (sheetObject1.CheckedRows('chk') < 1) {
                    ComShowCodeMessage('TES21009'); // There is no selected data.
                    return false;
                }
                
                iCheckRow = sheetObject1.FindCheckedRow("chk");
                var arrRow = iCheckRow.split("|");
                
                if (iCheckRow != null && arrRow.length >= 1) {
                    for (var i = 0; i < arrRow.length; i++) {
                        if (sheetObject1.GetCellValue(arrRow[i], "tml_gnte_cntr_list_seq") == null || sheetObject1.GetCellValue(arrRow[i], "tml_gnte_cntr_list_seq") == '') {
                            ComShowCodeMessage('TES70112'); // 'Save Guarantee before proceeding'
                            cntr_seq = "";
                            return false;
                        } else {
                            if (!ComIsNull(sheetObject1.GetCellValue(arrRow[i], "chk_irr"))) {
                                ComShowCodeMessage('TES70115'); // Irregular exists already.
                                cntr_seq = '';
                                return false;
                            } else if (!ComIsNull(sheetObject1.GetCellValue(arrRow[i], "chk_tpb_if"))) {
                                ComShowCodeMessage('TES70120'); // TPB I/F exists already.
                                cntr_seq = '';
                                return false;
                            } else {
                                cntr_seq = cntr_seq + sheetObject1.GetCellValue(arrRow[i], "tml_gnte_cntr_list_seq") + ",";
                            }
                        }
                    }
                    cntr_seq = cntr_seq.substring(0, cntr_seq.length - 1);
                }
                
                param = param + 'pgmNo=ESD_TES_2008&parentPgmNo=ESD_TES_M001' + '&gnte_no=' + sGnteNo + '&curr_cd=' + sCurrCd + '&yd_cd=' + sYdCd + '&cntr_seq=' + cntr_seq;
                
                // radio PopUp
                if (chkStr == "0,1") {
                    ComOpenPopup('ESD_TES_2008.do' + param, 500, 370, '', dispaly, true);
                } else {
                    ComShowCodeMessage('TES10004'); //There is lack of data for pop-up display.
                    return;
                }
                break;

            case "btn_print":
                if ((sheetObjects[0].HeaderRows() + sheetObjects[0].RowCount()) <= 1) {
                    ComShowCodeMessage('TES21017'); // 'There is no data.';
                    return false;
                } else {
                    for (var i = sheetObjects[0].HeaderRows(); i < (sheetObjects[0].HeaderRows() + sheetObjects[0].RowCount()); i++) {
                        if (ComIsNull(sheetObject1.GetCellValue(i, "chk_tpb_if")) && ComIsNull(sheetObject1.GetCellValue(i, "chk_irr"))) {
                            ComShowCodeMessage('TES70119'); // 'TPB I/F Or Irregular Print
                            return false;
                        }
                    }
                    var url_str = 'ESD_TES_2003.screen';
                    url_str = url_str + '?pgmNo=ESD_TES_2003&parentPgmNo=ESD_TES_M001';
                    url_str = url_str + '&gnte_no=' + document.form.gnte_no.value;
                    ComOpenWindow(url_str, window, "dialogWidth:900px; dialogHeight:700px; help:no; status:no; resizable:yes;", true);
                }
                break;

            case "btn_delete":
                if (document.getElementById("delt_flg").value == "Y") {
                    ComShowCodeMessage('TES70118'); // Already Deleted.
                    return;
                }
                
                // Guarantee 내용 모두 삭제					
                if (!ComIsNull(sheetObject2.GetCellValue(1, "ofc_cd")) && sheetObject2.GetCellValue(1, "ofc_cd") != document.getElementById("cre_ofc_cd").value) {
                    ComShowCodeMessage('TES70121'); // No authority to correct/delete the Guarantee - Creation office mismatch!
                    return false;
                }
                
                if (!ComIsNull(document.getElementById("gnte_no").value) && ComShowConfirm(ComGetMsg('TES70113'))) {
                    tes_getInputValueGuarantee('is_valid_TPB', SEARCH03, 'gnte_no', 'checkNonTPB');
                }
                break;

            case "btn_refno":
                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                var classId = "ESD_TES_2004";
                var param = '?cre_flg=G&classId=' + classId;
                var chkStr = dispaly.substring(0, 3)
                    // radio PopUp
                if (chkStr == "1,0") {
                    ComOpenPopup('ESD_TES_2004.do' + param, 500, 360, '', dispaly, true);
                } else {
                    ComShowCodeMessage('TES10004'); //There is lack of data for pop-up display.
                    return;
                }
                break;

            case "btn_custcd":
                var dispaly = "1,0,1,1,1,1,1,1,1,1";
                var classId = "COM_ENS_041";
                var param = '?classId=' + classId;
                var chkStr = dispaly.substring(0, 3)
                    // radio PopUp
                if (chkStr == "1,0") {
                    ComOpenPopup('/opuscntr/COM_ENS_041.do' + param, 770, 490, 'getCust', dispaly, true);
                } else {
                    ComShowCodeMessage('TES10004'); //There is lack of data for pop-up display.
                    return;
                }
                break;

            case "btn_vndr":
                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                var classId = "COM_ENS_0C1";
                var param = '?classId=' + classId;
                var chkStr = dispaly.substring(0, 3);
                // radio PopUp
                if (chkStr == "1,0") {
                    ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 700, 540, 'getVender', dispaly, true);
                } else {
                    ComShowCodeMessage('TES10004'); // There is lack of data for pop-up display.
                    return;
                }
                break;

            case "btng_rowadd":
                if (document.getElementById("delt_flg").value == "Y") {
                    ComShowCodeMessage('TES70118'); // Already Deleted.
                    return;
                }
                
                var Row = sheetObject1.DataInsert();

                break;

            case "btng_rowdelete":
                if (document.getElementById("delt_flg").value == "Y") {
                    ComShowCodeMessage('TES70118'); // Already Deleted.
                    return;
                }
                
                var delRow = "";
                iCheckRow = sheetObject1.FindCheckedRow('chk');
                var arrChkRow = iCheckRow.split("|");
                if (iCheckRow != "" && arrChkRow.length > 0) {
                    for (var i = arrChkRow.length - 1; i >= 0; i--) {
                        // TPB I/F, Irregular
                        var delId = arrChkRow[i];
                        if (delId != null && delId != "") {
                            if (ComIsNull(sheetObject1.GetCellValue(delId, "chk_tpb_if")) && ComIsNull(sheetObject1.GetCellValue(delId, "chk_irr"))) {
                                if (ComIsNull(sheetObject1.GetCellValue(delId, "cntr_no"))) {
                                    sheetObject1.RowDelete(delId, false);
                                } else {
                                    if (!ComIsNull(sheetObject1.GetCellValue(delId, "tml_gnte_cntr_list_seq"))) {
                                        sheetObject1.SetRowHidden(delId, 1);
                                    }
                                    sheetObject1.SetRowStatus(delId, "D");
                                }
                            }
                        }
                    }
                }
                // Set Amount
                document.getElementById("ttl_amt").value = getShtTotAmt(sheetObject1, "gnte_amt");
                break;

            case "btn_yard":
                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                var classId = "COM_ENS_061";
                var param = '?classId=' + classId;
                var chkStr = dispaly.substring(0, 3)
                    // radio PopUp
                if (chkStr == "1,0") {
                    ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 790, 500, 'getYard', dispaly, true);                    
                } else {
                    ComShowMessage(ComGetMsg('TES10004'));
                    return;
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
 * defining list on the top of source. <br>
 * @param{ibsheet}		sheet_obj		IBSheet Object
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
    // TPB BillingCase Code TES
    tes_getInputValueInvoice('n3pty_bil_tp_cd_tmp', SEARCH07, '', 'setTpbBillcaseCode');

    // Inquiry, Irregular
    if (document.getElementById("irr_flg").value == "Y" || document.getElementById("inq_flg").value == "Y") {
        doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
    } else {
        initFormHdr();
    }
    document.getElementById("gnte_no").focus();

    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

/**
 * Billing Case data combo
 * @return
 */
function setTpbBillcaseCode() {
    //tes_tpbBillcaseCode(sheetObjects[0], document.getElementById('n3pty_bil_tp_cd_tmp').value, 'n3pty_bil_tp_cd', '', '', 'getList');
}

/**
 * setting sheet initial values and header
 * adding case as numbers of counting sheets
 * 
 * @param {ibsheet}  	sheetObj	Sheet Object
 * @param {int,String} 	sheetNo		Sheet Object 
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetObj.id) {
		case "sheet1":      //sheet1 init ( Container List )
			with(sheetObj){			
				var HeadTitle1="| |Seq|TPB|IR|Container No.|SZ|BKG No.|BL No.|VVD|SC No.|" +
				"From DT|To DT|Amount|Invoice No.|Bkg No. List|BKG No Org|TML IF OFC|TML IF SEQ|IRR NO";
				var headCount=ComCountHeadTitle(HeadTitle1);
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							{Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"tml_gnte_cntr_list_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk_tpb_if",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk_irr",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sc_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Date",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"fm_dt",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
							{Type:"Date",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"to_dt",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
							{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"gnte_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"tpb_inv_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no_list_ctnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no2",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"tml_if_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"tml_if_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"irr_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				
				SetEditable(1);
				SetCountPosition(0);
				SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
				//				      SetSheetHeight(220);//162;
				resizeSheet();
				SetColProperty("bkg_no", {ComboText:"", ComboCode:""} );		
			}		
		break;
		
		case "sheet2":      //sheet2 init ( Header Info )
			with(sheetObj){			
				var HeadTitle1="STS|Ref no|Office|Size|Currency|Yard|Yard Name|Cust Cd|Cust Name|Bkg Sts|Amt|Phone No.|Fax No.|Department|Remark|Del|User|Cre Date";
				var headCount=ComCountHeadTitle(HeadTitle1);
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"gnte_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"gnte_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"vndr_seq_name",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"gnte_cust_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"gnte_cust_cd_name",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"yd_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ttl_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pic_phn_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"pic_fax_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"dept_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"gnte_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"delt_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				
				SetEditable(1);
				SetCountPosition(0);
				SetSheetHeight(100);
			}
		break;	
	}    
}

/**
 * handling IBSheet (Header ) process<br>
 * 
 * @param {ibsheet}		sheetObj	IBSheet Object
 * @param {Object}		formObj		Form Object
 * @param {String}		sAction		Action Command
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            formObj.f_cmd.value = SEARCH;
            var sXml = sheetObj.GetSearchData("ESD_TES_2001GS.do", tesFrmQryStr(formObj));
            var arrXml = sXml.split("|$$|");
            for (var i = 0; arrXml != null && i < arrXml.length; i++) {
                sheetObjects[i].LoadSearchData(arrXml[i], { Sync: 1 });
            }
            sXml = null;
            arrXml = null;
            break;
            
        case IBSAVE: //sheet2 Save
            var param = sheetObj.GetSaveString();
            var savexml = sheetObjects[1].GetSaveData("ESD_TES_2001GS.do", tesFrmQryStr(formObj) + '&' + param);
            sheetObjects[1].LoadSaveData(savexml, true);
            break;
            
        case IBINSERT: // Input
            break;
            
        case IBDELETE: // Delete
            formObj.f_cmd.value = REMOVE;
            var param = sheetObj.GetSaveString();
            var savexml = sheetObj.GetSaveData("ESD_TES_2001GS.do", tesFrmQryStr(formObj));
            doActionIBSheet(sheetObj, formObj, IBSEARCH);
            break;
		
		case MULTI: //sheet1 Save
            formObj.f_cmd.value = MULTI;
            var param = sheetObjects[0].GetSaveString();
            var saveXml = sheetObjects[0].GetSaveData("ESD_TES_2001GS.do", tesFrmQryStr(formObj) + '&' + param);
            sheetObjects[0].LoadSaveData(savexml, true);            
            var sKey = ComGetEtcData(saveXml, "TRANS_RESULT_KEY");
            if(sKey == "S"){
            	ComShowCodeMessage('TES90108'); // Data saved successfully  
            }
            break;    
    }
}

/**
 * set Reference No <br>
 * 
 * @param{Array}		rowArray	rowArray
 */
function getRefNo(rowArray) {
    document.all.gnte_no.value = rowArray[0];
}

/**
 * set Customer info (Code, Name) <br>
 * 
 * @param{Array}		rowArray	rowArray
 */
function getCust(rowArray) {
    var colArray = rowArray[0];
    document.all.gnte_cust_cd.value = colArray[3];    
    document.all.gnte_cust_cd_name.value = colArray[4];
}

/**
 * set Vender info( Code, Name) <br>
 * 
 * @param{Array}		rowArray	rowArray
 */
function getVender(rowArray) {
    var colArray = rowArray[0];
    document.all.vndr_seq.value = colArray[2];    
    document.all.vndr_seq_name.value = colArray[4];
}

/**
 * Form Object Guarantee Value <br>
 **/
function initFormHdr() {
    sheetObjects[1].RemoveAll();
    document.getElementById("gnte_no").value = "";
    document.getElementById("ofc_cd").value = document.getElementById("cre_ofc_cd").value;
    document.getElementById("delt_flg").value = "";
    document.getElementById("gnte_tp_cd").value = "ST";
    document.getElementById("curr_cd").value = "USD";
    document.getElementById("bkg_sts_cd").value = "F";
    document.getElementById("yd_cd").value = "";
    document.getElementById("yd_nm").value = "";
    document.getElementById("gnte_cust_cd").value = "";
    document.getElementById("gnte_cust_cd_name").value = "";
    document.getElementById("gnte_cust_cd_hidden").value = "";
    document.getElementById("is_valid_gnte_cust_cd").value = "";
    document.getElementById("vndr_seq").value = "";
    document.getElementById("vndr_seq_name").value = "";
    document.getElementById("vndr_seq_hidden").value = "";
    document.getElementById("is_valid_vndr_seq").value = "";
    document.getElementById("ttl_amt").value = "";
    document.getElementById("gnte_rmk").value = "";
    document.getElementById("pic_phn_no").value = "";
    document.getElementById("pic_fax_no").value = "";
    document.getElementById("dept_no").value = "";
    document.getElementById("gnte_no").readOnly = false;
    document.getElementById("gnte_no").className = "";
    tes_getInputValue('DB_DATE', SEARCH06, '', 'setCreDate');
    document.getElementById("regflag").value = "Y";
}

/**
 * Form Object Guarantee Value <br>
 **/
function initFormCntrList() {
    sheetObjects[0].RemoveAll();
    sheetObjects[0].SetColHidden("fm_dt", 0);
    sheetObjects[0].SetColHidden("to_dt", 0);
}

/**
 * gnte_tp_cd(Type) 'ST'(Storage)  <br>
 * gnte_tp_cd(Type) 'FL'(Flip), 'CY'(Other)<br>
 **/
function setTypeCntrDt() {
    if (document.getElementById("gnte_tp_cd").value == 'ST') {
        sheetObjects[0].SetColHidden("fm_dt", 0);
        sheetObjects[0].SetColHidden("to_dt", 0);
    } else {
        sheetObjects[0].SetColHidden("fm_dt", 1);
        sheetObjects[0].SetColHidden("to_dt", 1);
    }
}

/**
 * ESD_TES_2008 TPB I/F Guarantee retrieve <br>
 */
function tpbRetrive() {
    doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
}

/**
 * sheet1 ( Container List ) Data change event <br>
 * 
 * @param{ibsheet}		sheetObj	Sheet Object
 * @param{string}		Row			Row Index.
 * @param{string}		Col			Col Index.
 * @param{string}		Value		Value
 */
function sheet1_OnChange(sheet1, Row, Col, Value) {
    var sName = sheet1.ColSaveName(Col);
    var formObject = document.form;
    document.getElementById("rowId").value = Row;
    // container bkg no inquiry
    document.getElementById("cntr_no_tmp").value = sheet1.GetCellValue(Row, "cntr_no");
    if (sName == 'cntr_no') {
        if (ComIsNull(sheet1.GetCellValue(Row, "cntr_no"))) {
            return false;
        }
        // UpperCase
        sheet1.SetCellValue(Row, "cntr_no", sheet1.GetCellValue(Row, "cntr_no").toUpperCase(), 0);
        // checkDigsit
        sheet1.SetCellValue(Row, "cntr_no", cntrCheckDigit(sheet1.GetCellValue(Row, "cntr_no")), 0);
        // Container No. Duplication Check.
        if (!checkDupCntrNo(sheet1, Row)) {
            return false;
        }
        // Container No.로 Bkg No. search.
        searchBkgNoList(sheet1, Row);
    }
    
    if (sName == 'bkg_no' && document.getElementById("retrieveFlg").value == 'N') {
        searchCntrInfo();
    }
    
    if (sName == 'gnte_amt') {
        if (isNaN(sheet1.GetCellValue(Row, 'gnte_amt')) || sheet1.GetCellValue(Row, 'gnte_amt') <= 0) {
            ComShowCodeMessage('TES60102'); //Amount should be greater than 0.
            return false;
        }
        document.getElementById("ttl_amt").value = getShtTotAmt(sheet1, 'gnte_amt');
    }
    
    if (sName == 'to_dt') {
        if (ComGetDaysBetween(sheet1.GetCellValue(Row, "fm_dt"), sheet1.GetCellValue(Row, "to_dt")) < 0) {
            ComShowCodeMessage('TES24012'); // Start date must be earlier than end date.
            sheet1.SetCellValue(Row, "to_dt", "", 0);
            return false;
        }
    }
}

/**
 * sheet1 (Guarantee Conatainer Info ) search end event <br>
 * 
 * @param{ibsheet}		sheetObj	Sheet Object
 * @param{string}		errMsg		Error Message
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
    var formObject = document.form;
    ComOpenWait(false);
    if (errMsg == '') {
        for (var i = sheetObj.HeaderRows(); i < (sheetObj.HeaderRows() + sheetObj.RowCount()); i++) {
            if ((!ComIsNull(sheetObj.GetCellValue(i, "tml_if_ofc_cd")) && !ComIsNull(sheetObj.GetCellValue(i, "tml_if_seq"))) || !ComIsNull(sheetObj.GetCellValue(i, "irr_no"))) {
                setShtCellsEditable2(sheetObj, i, 'cntr_no|bkg_no|bkg_no|fm_dt|to_dt|gnte_amt|bkg_no2', 'N');
            }
        }
    } else {
        ComShowMessage(errMsg);
    }
}

/** 
 * Cell Editable
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

/**
 * sheet2 (Guarantee Header Info ) search end event <br>
 * 
 * @param{ibsheet}		sheetObj	Sheet Object
 * @param{string}		errMsg		Error Message
 */
function sheet2_OnSearchEnd(sheetObj, errMsg) {
    var formObject = document.form;
    ComOpenWait(false);
    if (errMsg == '') {
        //if ( !ComIsNull( sheetObjects[1].GetCellValue(1, "gnte_no") ) ) {
        if (sheetObjects[1].RowCount() > 0) {
            document.getElementById("regflag").value = "N";
            document.getElementById("retrieveFlg").value = "Y";
            document.getElementById("gnte_no").value = sheetObjects[1].GetCellValue(1, "gnte_no");
            document.getElementById("delt_flg").value = sheetObjects[1].GetCellValue(1, "delt_flg");
            document.getElementById("gnte_tp_cd").value = sheetObjects[1].GetCellValue(1, "gnte_tp_cd");
            document.getElementById("curr_cd").value = sheetObjects[1].GetCellValue(1, "curr_cd");
            document.getElementById("bkg_sts_cd").value = sheetObjects[1].GetCellValue(1, "bkg_sts_cd");
            document.getElementById("yd_cd").value = sheetObjects[1].GetCellValue(1, "yd_cd");
            document.getElementById("yd_nm").value = sheetObjects[1].GetCellValue(1, "yd_nm");
            document.getElementById("gnte_cust_cd").value = sheetObjects[1].GetCellValue(1, "gnte_cust_cd");
            document.getElementById("gnte_cust_cd_name").value = sheetObjects[1].GetCellValue(1, "gnte_cust_cd_name");
            document.getElementById("vndr_seq").value = sheetObjects[1].GetCellValue(1, "vndr_seq");
            document.getElementById("vndr_seq_name").value = sheetObjects[1].GetCellValue(1, "vndr_seq_name");
            document.getElementById("ttl_amt").value = sheetObjects[1].GetCellValue(1, "ttl_amt"); // tes_chkAmtFmt( sheetObjects[1].GetCellValue(1, "ttl_amt"), sheetObjects[1].GetCellValue(1, "curr_cd") );
            document.getElementById("gnte_rmk").value = sheetObjects[1].GetCellValue(1, "gnte_rmk");
            document.getElementById("pic_phn_no").value = sheetObjects[1].GetCellValue(1, "pic_phn_no");
            document.getElementById("pic_fax_no").value = sheetObjects[1].GetCellValue(1, "pic_fax_no");
            document.getElementById("dept_no").value = sheetObjects[1].GetCellValue(1, "dept_no");
            //document.getElementById("cost_ofc_cd").value = sheetObjects[1].GetCellValue(1, "dept_no");
            document.getElementById("is_valid_dept_no").value = "Y";
            document.getElementById("cre_dt").value = sheetObjects[1].GetCellValue(1, "cre_dt");
            document.getElementById("gnte_cust_cd_hidden").value = sheetObjects[1].GetCellValue(1, "gnte_cust_cd");
            document.getElementById("vndr_seq_hidden").value = sheetObjects[1].GetCellValue(1, "vndr_seq");
            document.getElementById("ofc_cd").value = sheetObjects[1].GetCellValue(1, "ofc_cd");
            document.getElementById("cre_usr_id").value = sheetObjects[1].GetCellValue(1, "cre_usr_id");
            document.getElementById("gnte_no").readOnly = true;
            document.getElementById("gnte_no").className = "input2";
            // fm_dt, to_dt CellHidden
            setTypeCntrDt();
            // Container Bkg No. List ComboBox
            for (var i = sheetObjects[0].HeaderRows(); i < (sheetObjects[0].HeaderRows() + sheetObjects[0].RowCount()); i++) {
                sheetObjects[0].CellComboItem(i, "bkg_no", { ComboText: sheetObjects[0].GetCellValue(i, "bkg_no_list_ctnt") });
                sheetObjects[0].SetCellValue(i, "bkg_no", sheetObjects[0].GetCellValue(i, "bkg_no2"), 0);
            }
            document.getElementById("retrieveFlg").value = "N";
        } else {
            document.getElementById("regflag").value = "Y";
            initFormHdr();
        }
    } else {
        ComShowMessage(errMsg);
    }
}

/**
 * sheet2 (Guarantee Header Info ) save end event <br>
 * 
 * @param{ibsheet}		sheetObj	Sheet Object
 * @param{string}		errMsg		Error Message
 */
function sheet2_OnSaveEnd(sheetObj, errMsg) {    
    var formObject = document.form;
    ComOpenWait(false);
    if (errMsg == "") {
        if (formObject.f_cmd.value == ADD) {
            document.getElementById("gnte_no").value = sheetObj.GetEtcData("gnte_no");
        }
        doActionIBSheet(sheetObjects[0], formObject, MULTI);
    } 
}

/**
 * sheet1 (Guarantee Header Info ) save end event <br>
 * 
 * @param{ibsheet}		sheetObj	Sheet Object
 * @param{string}		errMsg		Error Message
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {    
	var formObject = document.form;
	doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
}

/**
 * sheet2 (Guarantee Header Info ) <br>
 * 
 * @param{ibsheet}		sheetObj	Sheet Object
 * @param{string}		colnm
 */
function getShtTotAmt(sheetObj, colnm) {
    var tot_amt_val = 0;
    for (var i = sheetObj.HeaderRows(); i < (sheetObj.HeaderRows() + sheetObj.RowCount()); i++) {
    	var rVal = sheetObj.GetCellValue(i, colnm);
        if (sheetObj.GetRowSumable(i) && rVal != null && rVal != '' && rVal != undefined && !isNaN(parseFloat(rVal)) && sheetObj.GetRowStatus(i) != 'D' ) {
            tot_amt_val = Math.round(Number(tot_amt_val) * 10000) / 10000 + Math.round(Number(sheetObj.GetCellValue(i, colnm)) * 10000) / 10000;
        }
    }
    tot_amt_val = Math.round(Number(tot_amt_val) * 10000) / 10000;
    tot_amt_val = tes_chkAmtFmt(tot_amt_val, document.form.curr_cd.value);
    return tot_amt_val;
}

/**
 * set create date
 * 
 */
function setCreDate() {
    /* from 한달전 ~ to 오늘 */
    var formObj = document.form;
    var cre_dt = new String(formObj.DB_DATE.value).substring(0, 8);
    if (cre_dt != undefined && cre_dt != null && ComTrim(cre_dt) != '' && cre_dt.length == 8) {
        formObj.cre_dt.value = cre_dt.substring(0, 4) + '-' + cre_dt.substring(4, 6) + '-' + cre_dt.substring(6, 8);
    }
}

/**
 * Check TPB IF 
 * 
 */
function checkNonTPB() {
    var arrTPB = document.getElementById("is_valid_TPB").value.split("|");
    var delCnt = 0;
    var delNotCnt = 0;
    for (var i = 0; i < arrTPB.length; i++) {
        if (arrTPB[i] == "Y") {
            delCnt++;
        } else if (arrTPB[i] == "N") {
            delNotCnt++;
            //				ComShowCodeMessage('TES70114'); // 'TPB No. exists already. Please have it deleted first at TPB';
        } else if (arrTPB[i] == "X") {
            delNotCnt++;
        } else if (arrTPB[i] == "O") {
            delCnt++;
        }
    }
    if (delCnt > 0 && delNotCnt == 0) {
        doActionIBSheet(sheetObjects[1], document.form, IBDELETE);
    } else if (delNotCnt > 0) {    	
        ComShowCodeMessage('TES70120'); // 'TPB No. exists already. Please have it deleted first at TPB';
        return false;
    }    
}

/**
 * Container No. Duplication Check. <br>
 * 
 * @param{ibsheet}		sheetObj	IBSheet Object.
 * @param{int,string}	row			Row Index.
 */
function checkDupCntrNo(sheetObj, row) {
    for (var i = sheetObjects[0].HeaderRows(); i < (sheetObjects[0].HeaderRows() + sheetObjects[0].RowCount()); i++) {
        if (i != row) {
            if ((sheetObjects[0].GetCellValue(i, "cntr_no") == sheetObjects[0].GetCellValue(row, "cntr_no")) &&
                (sheetObjects[0].GetCellValue(i, "bkg_no") == sheetObjects[0].GetCellValue(row, "bkg_no")) &&
                sheetObjects[0].GetCellValue(i, "ibflag") != 'D'
            ) {
                ComShowCodeMessage("TES70117", sheetObjects[0].GetCellValue(row, "cntr_no"), sheetObjects[0].GetCellValue(row, "bkg_no")); //[Container No. Dup] Container No. : " + guaranteeCommonVO.getCntrNo() + " exists already.
                return false;
            }
        }
    }
    return true;
}

/**
 * Container No. BKG No. List <br>
 * 
 * @param{ibsheet}		sheetObj	IBSheet Object.
 * @param{int,string}	row			Row Index.
 */
function searchBkgNoList(sheetObj, row, retrieveFlg) {
    // container bkg no inquiry
    document.getElementById("cntr_no_tmp").value = sheetObj.GetCellValue(row, "cntr_no");
    if (retrieveFlg == 'Y') {
        tes_getComboItemGuarantee('bkg_no_list', row, SEARCH05, '', 'cntr_no_tmp', '');
    } else {
        tes_getComboItemGuarantee('bkg_no_list', row, SEARCH05, '', 'cntr_no_tmp', 'searchCntrInfo', sheetObj);
    }
}

/**
 * Container No. BKG No. Container Info retrieve <br>
 * 
 */
function searchCntrInfo() {
    if (!ComIsNull(sheetObjects[0].GetCellValue(document.getElementById("rowId").value, "bkg_no"))) {
        document.getElementById("bkg_no_tmp").value = sheetObjects[0].GetCellValue(document.getElementById("rowId").value, "bkg_no");
        tes_getInputValueGuarantee('is_valid_cntr_info', SEARCH01, 'cntr_no_tmp|bkg_no_tmp', 'checkValidCntrInfo');
    } else {
        sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "cntr_no", "", 0);
        sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "cntr_tpsz_cd", "", 0);
        sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "bkg_no", "", 0);
        sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "bl_no", "", 0);
        sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "vvd_cd", "", 0);
        sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "sc_no", "", 0);
        document.getElementById("cntr_no_tmp").value = "";
        document.getElementById("bkg_no_tmp").value = "";
        ComShowCodeMessage("TES70116"); // This is invalid Container No.
    }
}

/**
 * set Container Info <br>
 * tmp[0]. Valid
 * tmp[1]. cntr_no
 * tmp[2]. cntr_tpsz_cd
 * tmp[3]. bkg_no
 * tmp[4]. bl_no
 * tmp[5]. vvd_cd
 * tmp[6]. sc_no
 */
function checkValidCntrInfo() {
    // Container Info Setting. 
    var formObj = document.form;
    var tmp = '';
    //alert("checkValidCntrInfo-->"+formObj.is_valid_cntr_info.value);
    if (formObj.is_valid_cntr_info.value != undefined &&
        formObj.is_valid_cntr_info.value != null &&
        formObj.is_valid_cntr_info.value.trim() != '') {
        tmp = formObj.is_valid_cntr_info.value.split('|');
        if (tmp.length > 0) {
            formObj.is_valid_cntr_info.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_cntr_info.value != null && formObj.is_valid_cntr_info.value == 'Y') {
                sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "cntr_tpsz_cd", (tmp[2] != undefined && tmp[2] != null ? tmp[2] : ''), 0);
                //					sheetObjects[0].CellValue2( document.getElementById("rowId").value, "bkg_no")		= (tmp[3] != undefined && tmp[3] != null ? tmp[3] : '');
                sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "bl_no", (tmp[4] != undefined && tmp[4] != null ? tmp[4] : ''), 0);
                sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "vvd_cd", (tmp[5] != undefined && tmp[5] != null ? tmp[5] : ''), 0);
                sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "sc_no", (tmp[6] != undefined && tmp[6] != null ? tmp[6] : ''), 0);
                //					document.getElementById("cntr_no_tmp").value	= "";
                document.getElementById("bkg_no_tmp").value = "";
            } else {
                sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "cntr_no", "", 0);
                sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "cntr_tpsz_cd", "", 0);
                sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "bkg_no", "", 0);
                sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "bl_no", "", 0);
                sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "vvd_cd", "", 0);
                sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "sc_no", "", 0);
                document.getElementById("cntr_no_tmp").value = "";
                document.getElementById("bkg_no_tmp").value = "";
                ComShowCodeMessage("TES70116"); // This is invalid Container No.
            }
        } else {
            sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "cntr_no", "", 0);
            sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "cntr_tpsz_cd", "", 0);
            sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "bkg_no", "", 0);
            sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "bl_no", "", 0);
            sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "vvd_cd", "", 0);
            sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "sc_no", "", 0);
            document.getElementById("cntr_no_tmp").value = "";
            document.getElementById("bkg_no_tmp").value = "";
            ComShowCodeMessage("TES70116"); // This is invalid Container No.
        }
    } else {
        sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "cntr_no", "", 0);
        sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "cntr_tpsz_cd", "", 0);
        sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "bkg_no", "", 0);
        sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "bl_no", "", 0);
        sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "vvd_cd", "", 0);
        sheetObjects[0].SetCellValue(document.getElementById("rowId").value, "sc_no", "", 0);
        document.getElementById("cntr_no_tmp").value = "";
        document.getElementById("bkg_no_tmp").value = "";
        ComShowCodeMessage("TES70116"); // This is invalid Container No.
    }
}

/**
 * only English and numbers permitted <br>
 * @param {obj}    Text Value
 **/
function isApNum(obj) {
    if (!ComIsAlphabet(obj, 'u')) {
        obj.value = '';
    }
}

/**
 * only English and numbers permitted <br>
 * @param {obj}    Text Value
 **/
function isApNum2(obj) {
    if (!ComIsAlphabet(obj, 'n')) {
        obj.value = '';
    }
    obj.value = obj.value.toUpperCase();
}

/**
 * only English and numbers permitted <br>
 * @param {obj}    Text Value
 **/
function isApNum2(obj) {
    if (!ComIsAlphabet(obj, 'n')) {
        obj.value = '';
    }
    obj.value = obj.value.toUpperCase();
}

// UI 표준화관련 하단 여백 설정
function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
}

/**
 *  get Yard
 *  @param(rowArray)
 */
function getYard(rowArray) {
	var colArray=rowArray[0];
	document.all.yd_cd.value=colArray[3];
	document.all.yd_nm.value=colArray[4];
}