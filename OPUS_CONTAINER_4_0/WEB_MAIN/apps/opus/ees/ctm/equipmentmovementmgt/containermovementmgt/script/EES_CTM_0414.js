/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_ctm_0414.js
*@FileTitle  :  Update of EDI Message (Error)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class ees_ctm_0414 : business script for ees_ctm_0414 
     */
/* developer job */
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var sheetValidation=true;
var appendCondParam=null;
var appendPageNo=null;
var appendOnePageRows=null;
var appendPageNo=1;
var okCount=0;
var errorCount=0;
var ignoredCount=0;
var totalCount=0;
var errorXml="";
var saveXml=new Array();
var sheet2valid=true;
var fromSheet1=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick() {
        var sheetObj1=sheetObjects[0];
        var sheetObj2=sheetObjects[1];
        var frmObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch (srcName) {
                case "btn_Calendar":
                    if (!window.event.srcElement.disabled) {
                        var cal=new ComCalendarFromTo();
                        cal.select(frmObj.p_date1, frmObj.p_date2, "yyyy-MM-dd");
                    }
                    break;
                case "btn_vvdchange":
                    with (sheetObj1) {
                        if (CheckedRows("Sel") < 1) {
                            ComShowCodeMessage("CTM30001");
                            return;
                        } else {
                            if (frmObj.vvdsts_change_combo.value == "VVD") {
                                if (frmObj.vvdcd_change.value.length < 9) {
                                    ComShowCodeMessage("CTM20073");
                                    return;
                                }
                            }
                            RenderSheet(0);
                            var arr=FindCheckedRow("Sel").split("|");
                            var vvdstsChange="";
                            for (var i=0; i<arr.length-1; i++) {
                                if (frmObj.vvdsts_change_combo.value == "VVD") {
                                    if (GetCellEditable(arr[i], "vvd_cd")) {
                                        SetCellValue(arr[i], "vvd_cd",frmObj.vvdcd_change.value,0);
                                        SetCellValue(arr[i], "crnt_vsl_cd",frmObj.vvdcd_change.value.substring(0, 4),0);
                                        SetCellValue(arr[i], "crnt_skd_voy_no",frmObj.vvdcd_change.value.substring(4, 8),0);
                                        SetCellValue(arr[i], "crnt_skd_dir_cd",frmObj.vvdcd_change.value.substring(8, 9),0);
                                        SetRowStatus(arr[i],"U");
                                    }
                                } else {
                                    if (GetCellEditable(arr[i], "edi_mvmt_sts_cd")) {
                                        SetCellValue(arr[i], "edi_mvmt_sts_cd",frmObj.stscd_change.value,0);
                                        SetRowStatus(arr[i],"U");
                                    }
                                }
                            }
                            RenderSheet(1);
                        }
                    }
                    break;
                case "btn_more":
                    doActionIBSheet(sheetObj1, frmObj, IBSEARCHAPPEND, appendCondParam, appendPageNo);
                    break;
                case "btn_detail":
                    sheet1_OnDblClick(sheetObj1, sheetObj1.GetSelectRow());
                    break;
                case "btn_downexcel":
                    sheetObj1.WaitImageVisible = false;
                    sheetObj2.WaitImageVisible = false;
                    ComOpenWait(true);
                    if(sheetObj1.RowCount() < 1){//no data
                    	ComShowCodeMessage("COM132501");
                    	}else{
                    		sheetObj1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj1), SheetDesign:1,Merge:1 });
                    	}
                    ComOpenWait(false);
                    sheetObj2.SetWaitImageVisible(1);
                    sheetObj1.SetWaitImageVisible(1);
                    break;
                case "btn_retrieve":
                    if (!checkFormField()) return;
                    sheetObj1.SetHeaderCheck(0, "Sel",0);
                    doActionIBSheet(sheetObj1, frmObj, IBSEARCH);
                    break;
                case "btn_save":
                    doActionIBSheet(sheetObj1, frmObj, IBSAVE);   
                    break;
                case "btn_close":
                	ComClosePopup(); 
                    break;
                case "btn2_retrieve":    
                    btn2Retrieve();
                    break;
                case "btn2_save":
                    btn2Save();
                    break;
                case "btn2_add":
                    addRow();
                    break;
                case "btn2_delete":
                    btn2Delete();
                    break;
                case "btn2_new":
                    DomSetFormObjDisable(frmObj, false);
                    statusCombo.SetEnable(1);
                    mvmt_edi_msg_tp_id.SetEnable(1);
                    p_yard2.SetEnable(1);
                    ioStatusCombo.SetEnable(1);
                    sheetObj1.SetEditable(1);
                    ComBtnEnable("btn_vvdchange");
                    ComBtnEnable("btn_retrieve");
                    // making Save button enable in case Area combo is same with login user's server ID
                    if (frmObj.user_svr_id.value == frmObj.mvmt_edi_msg_area_cd.value) {
                        ComBtnEnable("btn_save");
                    } else {
                        ComBtnDisable("btn_save");
                    }
                    sheetObj2.RemoveAll();
                    ComBtnDisable("btn2_add");
                    ComBtnDisable("btn2_delete");
                    ComBtnDisable("btn2_save");
                    sheetObj2.SetActionMenu("");
                    if (sheetObj1.CheckedRows("Sel") == 1 && sheetObj1.GetCellValue(sheetObj1.FindCheckedRow("Sel").split("|")[0], "mvmt_edi_rslt_cd") == "Y") {
                        doActionIBSheet(sheetObj1, frmObj, IBSEARCH);
                    }
                    break;
            } // end switch
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
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
    function setSheetObject(sheetObj) {
       sheetObjects[sheetCnt++]=sheetObj;
    }
    /**
     * registering IBMultiCombo Object as list
     * param : combo_obj
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setComboObject(combo_obj) {
       comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(var i=0;i<comboObjects.length;i++) {
            initCombo(comboObjects[i], comboObjects[i].options.id);
        }
        // button Disable
        ComBtnDisable("btn_more");
        ComBtnDisable("btn_detail");
        ComBtnDisable("btn_vvdchange");
        ComBtnDisable("btn2_add");
        ComBtnDisable("btn2_delete");
        ComBtnDisable("btn2_retrieve");
        ComBtnDisable("btn2_save");
        setEventProcess("cntrno_disp", "yd_cd_disp", "lcc_cd", "rcc_cd", "vvd_combo", "vvdcd_change");
        axon_event.addListener("change", "obj_onchange", "vvdsts_change_combo");
        with (document.form) {
            // Request Setting
            vvd_combo.value=vvdCombo.value;
            if (cntrFullStsCd.value != "") cntr_full_sts_cd.value=cntrFullStsCd.value;
            vvd_combo.value=vvdCombo.value;
            mvmt_edi_rslt_cd.value=mvmtEdiRsltCd.value;
            if (rtyKnt.value != "") rty_knt.value=rtyKnt.value;
            // retrieving server ID by login user's office code
            doActionIBSheet(sheetObjects[0], document.form, SEARCH16);
            if (requestYN.value == "Y") doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            // focusing on page loading
           // p_date1.focus();
        }
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj, sheetNo) {
        switch (sheetNo) {
            case 1:    // sheet[0] init
                var cnt=0;
                with(sheetObj){
					  document.form.pagerows.value=500;
					  (43, 4, 0, true);
					  SetSelectionMode(smSelectionList);
					  var HeadTitle="|Seq.||Container No.|T/S|ORG YD|Event Date|Receiving Date|Booking No.|EDI Booking|B/L No.|VVD Code|Call sign/Lloyd|Seal No.|Chassis No.|M.G Set|S/P|Mode|LCC|RTN YD|POL|POD|STS|I/O|F/M|E/I|Retry|Result error message|Remark(s)";
					  HeadTitle += "|crnt_vsl_cd|crnt_skd_voy_no|crnt_skd_dir_cd|call_sgn_no|lloyd_no|mvmt_edi_rslt_cd|mvmt_edi_msg_area_cd|mvmt_edi_msg_seq|mvmt_edi_msg_tp_id|mvmt_edi_msg_yrmondy|mvmt_edi_tp_cd|upd_flag";
					  SetEditEnterBehavior("tab");
					
					  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					  var headers = [ { Text:HeadTitle, Align:"Center"} ];
					  InitHeaders(headers, info);
					
					  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
					{Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Sel" },
					{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
					{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"evnt_yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"evnt_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_locl_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
					{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"edi_bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
					{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"call_sgn_lloyd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"chss_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mgst_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lcc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dest_yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"edi_mvmt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
					{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"edi_gate_io_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_full_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
					{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_sght_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rty_knt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:350,  Align:"Left",    ColMerge:0,   SaveName:"mvmt_edi_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"cnmv_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:499 },
					{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"crnt_vsl_cd" },
					{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"crnt_skd_voy_no" },
					{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"crnt_skd_dir_cd" },
					{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"call_sgn_no" },
					{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"lloyd_no" },
					{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"wbl_no" },
					{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pkup_no" },
					{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_rslt_cd" },
					{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_area_cd" },
					{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_seq" },
					{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_tp_id" },
					{Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_yrmondy" },
					{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_tp_cd" },
					{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"upd_flag" } ];
					   
					  InitColumns(cols);
					
					  SetEditable(1);
					  SetDataAutoTrim(1);
					  SetColProperty("evnt_dt", {Format:"####-##-####:##"} );
					  SetColProperty("cre_locl_dt", {Format:"####-##-####:##"} );
					  SetWaitTimeOut(36000);
					  SetSheetHeight(354);
					  }
					

                break;
            case 2:    //sheet[1] init
                //setting height
//            	sheetObj.SetSheetHeight(377);
                initSheet2();
                break;
        }
    }
    /**
     * setting Combo text and value
     * param : comboObj, comboNo
     * adding case as numbers of counting combos
     */
    function initCombo(comboObj, comboId) {
        var frmObj=document.form;
        with (comboObj) {
            //no support[check again]CLT UseCode=true;
            switch (comboId) {
                case "tpszCombo":
                    SetMultiSelect(1);
                    SetDropHeight(160);
                    var rtnValues=code_get("CNTR_TPSZ_CD", "'N' AND CNTR_TPSZ_CD  NOT IN ('Q2', 'Q4')", "DELT_FLG", "MDM_CNTR_TP_SZ");
                    // creating cntr_tpsz_cd IBMulticombo (CoCtm.js)
                    parseMultiCombo(comboObj, "^#^" + rtnValues, "ALL^#^" + rtnValues);
                    if (cntr_tpsz_cd.value != "") {
                        Text=cntr_tpsz_cd.value;
                    } else {
                        Text="ALL";
                    }
                    break;
                case "statusCombo":    // ComboObject Value Settting
                    SetMultiSelect(1);
                    SetDropHeight(160);
                    InsertItem(0, "ALL", "");
                    InsertItem(1, "OP", "OP");
                    InsertItem(2, "EN", "EN");
                    InsertItem(3, "TN", "TN");
                    InsertItem(4, "OC", "OC");
                    InsertItem(5, "VL", "VL");
                    InsertItem(6, "VD", "VD");
                    InsertItem(7, "IC", "IC");
                    InsertItem(8, "ID", "ID");
                    InsertItem(9, "TS", "TS");
                    InsertItem(10, "MT", "MT");
                    InsertItem(11, "ER", "ER");
                    InsertItem(12, "CP", "CP");
                    InsertItem(13, "CT", "CT");
                    InsertItem(14, "CE", "CE");
                    InsertItem(15, "CO", "CO");
                    InsertItem(16, "CI", "CI");
                    InsertItem(17, "CD", "CD");
                    InsertItem(18, "CM", "CM");
                    InsertItem(19, "ZZ", "ZZ");
                    if (frmObj.edi_mvmt_sts_cd.value != "") {
                        Text=ComReplaceStr(frmObj.edi_mvmt_sts_cd.value, "'", "");
                    } else {
                        Text="ALL";
                    }
                    break;
                case "mvmt_edi_msg_tp_id":    // ComboObject Value Settting
                    SetDropHeight(160);
                    InsertItem(0, "322", "322");
                    InsertItem(1, "COD", "COD");
                    InsertItem(2, "PRV", "PRV");
                    InsertItem(3, "222", "222");
                    InsertItem(4, "SPP", "SPP");
                    InsertItem(5, "ALL (Excl SPP)", "ALL");
                    Code=frmObj.mvmtEdiMsgTpId.value;
                    break;
                case "ioStatusCombo":    // ComboObject Value Settting
                    SetMultiSelect(1);
                    SetDropHeight(160);
                    InsertItem(0, "ALL", "");
                    InsertItem(1, "I|In-Gate", "I");
                    InsertItem(2, "O|Out-Gate", "O");
                    InsertItem(3, "AE|Loaded On Vessel", "AE");
                    InsertItem(4, "UV|Unloaded From Vessel", "UV");
                    InsertItem(5, "A|Arrived. Shipment has arrived at the location specified", "A");
                    InsertItem(6, "AL|Loaded On Rail", "AL");
                    InsertItem(7, "AO|Loaded On Barge", "AO");
                    InsertItem(8, "B|Bad Order (Inoperative or Damaged). Shipment was on a piece of equipment that failed", "B");
                    InsertItem(9, "D|Completed Unloading At Delivery Location. Shipment was delivered to the consignee or receiver", "D");
                    InsertItem(10, "N|No Paperwork Received With Shipment or Equipment", "N");
                    InsertItem(11, "OA|Out-Gate", "OA");
                    InsertItem(12, "P|Departed Terminal Location. Shipment has left the carrier's terminal or other control point", "P");
                    InsertItem(13, "R|Interchange received", "R");
                    InsertItem(14, "RL|Rail Departure From Origin Intermodal Ramp", "RL");
                    InsertItem(15, "UR|Unloaded From A Rail Car", "UR");
                    if (frmObj.edi_gate_io_cd.value != "") {
                        Text=ComReplaceStr(frmObj.edi_gate_io_cd.value, "'", "");
                    } else {
                        Text="ALL";
                    }
                    break;
            }
        }
    }
    //handling process for Sheet
    function doActionIBSheet(sheetObj, frmObj, sAction, CondParam, PageNo) {
        sheetObj.ShowDebugMsg(false);
        switch (sAction) {
            case IBSEARCH:   
                if (validateForm(sheetObj, frmObj, sAction)) {
                    //sheetObjects[0].SetWaitImageVisible(0);
                    sheetObjects[0].WaitImageVisible=false;
                    //sheetObjects[1].SetWaitImageVisible(0);
                    sheetObjects[1].WaitImageVisible=false;
                    ComOpenWait(true);
                    frmObj.vvdcd_change.value="";
                    appendPageNo=1;
                    // creating condition for using in query in case p_date1 and p_date2 gap is under 5 days
                    var getDaysBetween=ComGetDaysBetween(frmObj.p_date1.value, frmObj.p_date2.value);
                    frmObj.p_date3.value="";
                    if (getDaysBetween < 5) {
                        for (var i=0; i<=getDaysBetween; i++) {
                            if (i > 0) {
                                frmObj.p_date3.value=frmObj.p_date3.value + ", ";
                            }
                            frmObj.p_date3.value=frmObj.p_date3.value + "'" + ComGetUnMaskedValue(ComGetDateAdd(frmObj.p_date1.value, "D", i), "ymd") + "'";
                        }
                    }
                    sheetObjects[1].RemoveAll();
                    ComBtnDisable("btn2_add");
                    ComBtnDisable("btn2_delete");
                    ComBtnDisable("btn2_retrieve");
                    ComBtnDisable("btn2_save");
                    sheetObjects[1].SetActionMenu("");
                    frmObj.f_cmd.value=SEARCH;
                    appendCondParam=FormQueryString(frmObj);
                    sheetObj.DoSearch("EES_CTM_0404GS.do", appendCondParam );
                }
                break;
            case IBSEARCHAPPEND:   
                if (validateForm(sheetObj, frmObj, sAction)) {
                    sheetObjects[0].SetWaitImageVisible(0);
                    sheetObjects[1].SetWaitImageVisible(0);
                    ComOpenWait(true);
                    frmObj.f_cmd.value=SEARCH;
                    sheetObj.DoSearch("EES_CTM_0404GS.do", CondParam+"&"+ "i_page=" + PageNo,{Append:true} );
                }
                break;
            case IBSAVE:    
                if (sheetObj.CheckedRows("Sel") < 1) {
                    ComShowCodeMessage("CTM30001");
                    return;
                } else if (sheetObj.CheckedRows("Sel") > 500) {
                    ComShowCodeMessage("CTM10051", "500");
                    return;
                } else if (sheetObj.IsDataModified()&& !sheetObj.GetSaveString(false, true, "Sel")) {
                    return;
                }
                if (ComShowCodeConfirm("CTM30006")) {
                    sheetObjects[0].SetWaitImageVisible(0);
                    sheetObjects[1].SetWaitImageVisible(0);
                    ComOpenWait(true);
                    // initializing global variables
                    okCount=0;
                    errorCount=0;
                    ignoredCount=0;
                    totalCount=0;
                    errorXml="";
                    saveXml=new Array();
                    // Object Disable
                    ComBtnDisable("btn_vvdchange");
                    ComBtnDisable("btn_more");
                    ComBtnDisable("btn_detail");
                    ComBtnDisable("btn_downexcel");
                    ComBtnDisable("btn_retrieve");
                    ComBtnDisable("btn_save");
                    DomSetFormObjDisable(frmObj, true);
                    tpszCombo.SetEnable(0);
                    statusCombo.SetEnable(0);
                    mvmt_edi_msg_tp_id.SetEnable(0);
                    p_yard2.SetEnable(0);
                    ioStatusCombo.SetEnable(0);
                    with (sheetObj) {
                        RenderSheet(0);
                        // sheet[0] Sort
                        ColumnSort("cntr_no|evnt_dt", "ASC", "ASC|ASC", true);
                        var queryString="";
                        var startIdx=0;
                        var endIdx=0;
                        var checkIdxArr=(FindCheckedRow("Sel").substring(0, FindCheckedRow("Sel").length - 1)).split("|");
                        var checkCount=checkIdxArr.length;
                        var loopCount=0;
                        if (checkCount < (sendRows * maxThreadCount) + 1) {
                            loopCount=Math.ceil(checkCount / sendRows);
                        } else {
                            sendRows=Math.ceil(checkCount / maxThreadCount);
                            loopCount=maxThreadCount;
                        }
                        for (var i=1; i<=loopCount; i++) {
                            if (i == loopCount) {
                                endIdx=checkCount - 1;
                            } else {
                                endIdx += sendRows;
                                var currStartIdx=Number(startIdx) + Number(endIdx);
                                var currEndIdx=endIdx;
                                for (var k=currStartIdx; k<=checkCount; k++) {
                                	if (GetCellValue(checkIdxArr[currEndIdx], "cntr_no") == GetCellValue(checkIdxArr[k], "cntr_no")) {
                                        endIdx=k;
                                    } else {
                                        break;
                                    }
                                }
                            }
                            var tempString="";
                            for (var h=startIdx; h<=endIdx; h++) {
                            	tempString=("&mvmt_edi_rmk=" + GetCellValue(checkIdxArr[h], "mvmt_edi_rmk"));
                            	queryString += (ComReplaceStr(RowSaveStr(checkIdxArr[h]), tempString, "") + "&");
                                tempString="";
                            }
                            xmlHttpPost ("EES_CTM_0404GS.do", queryString + "AJAX=Y&f_cmd=" + MULTI, "rtnUpdateParses", checkIdxArr[startIdx]);
                            queryString="";
                            if ((endIdx-startIdx) > sendRows) {
                                i += (Math.ceil((endIdx-startIdx) / sendRows) - 1);
                            }
                            startIdx=endIdx + 1;
                            sendCount++;
                        }
                        // sheet[0] ReSort
                        ColumnSort("evnt_dt", "ASC", "ASC", true);
                        RenderSheet(1);
                        SetHeaderCheck(0, "Sel",0);
                    }
                }
                break;
            case SEARCH16:
            	frmObj.user_svr_id.value=ComGetEtcData(sheetObj.GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH16), "rtnValue");
                if (frmObj.mvmtEdiMsgAreaCd.value != "") {
                    frmObj.mvmt_edi_msg_area_cd.value=frmObj.mvmtEdiMsgAreaCd.value;
                } else {
                    var userSvrId=frmObj.user_svr_id.value;
                    if (userSvrId == "KOR" || userSvrId == "CHN" || userSvrId == "SWA" || userSvrId == "EUR" || userSvrId == "USA") {
                        frmObj.mvmt_edi_msg_area_cd.value=frmObj.user_svr_id.value;
                    } else {
                        frmObj.mvmt_edi_msg_area_cd.value="";
                        ComBtnDisable("btn_save");
                    }
                }
                break;
            case SEARCH02:    // retrieving sheet2 
                if (sheetObjects[0].CheckedRows("Sel") < 1) {
                    ComShowCodeMessage("CTM30001");
                    return;
                } else if (sheetObjects[0].CheckedRows("Sel") > 1) {
                    ComShowCodeMessage("CTM20071");
                    return;
                } else {
                    sheetObjects[0].SetWaitImageVisible(0);
                    sheetObjects[1].SetWaitImageVisible(0);
                    ComOpenWait(true);
                    var pCntrno=sheetObjects[0].GetCellValue(sheetObjects[0].FindCheckedRow("Sel").split("|")[0], "cntr_no");
                    sheetObj.DoSearch("EES_CTM_0414GS.do", "f_cmd=" + SEARCH02 + "&p_cntrno=" + pCntrno.substring(0+"&"+ 10) + "&check_digit=" + pCntrno.substring(10, 11) );
                }
                break;
            case MULTI:    
                if (validateForm(sheetObj, frmObj, sAction)) {
                    if (fromSheet1 > 0) {
                        if (sheetObj.IsDataModified()) {
                            if (sheetObj.GetSaveString()) {
                                var sParam2=ComSetPrifix(sheetObj.GetSaveString(), "sheet2_");
                                if (sParam2 == "") {
                                    ComShowCodeMessage("CTM20118");
                                    return;
                                }
                                if (ComShowCodeConfirm("CTM30006")) {
                                    var sParam1=ComSetPrifix(sheetObjects[0].GetSaveString(false, false, "Sel"), "sheet1_");
                                    var arrPrefix=new Array("sheet1_", "sheet2_");
                                    sheetObj.LoadSaveData(sheetObj.GetSaveData("EES_CTM_0414GS.do", sParam1 + "&" + sParam2 + "&f_cmd=" + MULTI + "&" + ComGetPrefixParam(arrPrefix)));
                                }
                            }
                        }
                    } else {
                        if (sheetObj.GetSaveString(false) == "") {
                            ComShowCodeMessage("CTM20118");
                            return;
                        }
                        sheetObj.RemoveEtcData();
                        sheetObj.doSave("EES_CTM_0430GS.do", "f_cmd=" + MULTI);
                    }
                }
                break;
        }
    }
    function rtnUpdateParses(rtnXml, startId) {
        sendCount--;
        if (!ComGetEtcData(rtnXml, "total_count")) {
            errorXml=rtnXml;
        } else {
            rtnXml=ComReplaceStr(rtnXml, "^#^", "'");
            okCount += Number(ComGetEtcData(rtnXml, "ok_count"));
            errorCount += Number(ComGetEtcData(rtnXml, "error_count"));
            ignoredCount += Number(ComGetEtcData(rtnXml, "ignored_count"));
            totalCount += Number(ComGetEtcData(rtnXml, "total_count"));
            saveXml[sendCount]=rtnXml;
        }
        if (sendCount < 1) {
           var frmObj=document.form;
            // Object Enable
            ComBtnEnable("btn_vvdchange");
            ComBtnEnable("btn_more");
            ComBtnEnable("btn_detail");
            ComBtnEnable("btn_downexcel");
            ComBtnEnable("btn_retrieve");
            ComBtnEnable("btn_save");
            DomSetFormObjDisable(frmObj, false);
            tpszCombo.SetEnable(1);
            statusCombo.SetEnable(1);
            mvmt_edi_msg_tp_id.SetEnable(1);
            p_yard2.SetEnable(1);
            ioStatusCombo.SetEnable(1);
            ComOpenWait(false);
            sheetObjects[1].SetWaitImageVisible(1);
            sheetObjects[0].SetWaitImageVisible(1);
            if (errorXml != "") {
            	sheetObjects[0].LoadSaveData(errorXml);
            } else {
                ComOpenPopup("/opuscntr/EES_CTM_0432.do" +
                             "?ok_count=" + okCount +
                             "&error_count=" + errorCount +
                             "&ignored_count=" + ignoredCount +
                             "&total_count=" + totalCount, 300, 250, "", "0,1", true);
            }
        }
    }
    /**
     * calling function in EES_CTM_0432 pop up
     */
    function popup0432Function(event) {
        var frmObj=document.form;
        // displaying error data in sheet[0]
        if (event == "errorView") {
            with (sheetObjects[0]) {
                RemoveAll();
                RenderSheet(0);
                SetWaitImageVisible(0);
                sheetObjects[1].SetWaitImageVisible(0);
                ComOpenWait(true);
                for (var i=0; i<=saveXml.length-1; i++) {
                	LoadSearchData(saveXml[i],{Append:1 , Sync:1} );
                }
                // sheet[0] sort
                ColumnSort("evnt_dt", "ASC", "ASC", true);
                RenderSheet(1);
                if (RowCount()> 0) {
                    ComBtnEnable("btn_detail");
                    ComBtnEnable("btn_vvdchange");
                }
                ComBtnDisable("btn_more");
            }
            var frmObj=document.form;
            frmObj.disp_total.value="";
            frmObj.rtv_total.value="";
            frmObj.gnd_total.value="";
        // clearing screen
        } else if (event == "reset") {
            sheetObjects[0].RemoveAll();
            var frmObj=document.form;
            frmObj.disp_total.value="";
            frmObj.rtv_total.value="";
            frmObj.gnd_total.value="";
            // button Disable
            ComBtnDisable("btn_more");
            ComBtnDisable("btn_detail");
            ComBtnDisable("btn_vvdchange");
            ComBtnDisable("btn2_add");
            ComBtnDisable("btn2_delete");
            ComBtnDisable("btn2_retrieve");
            ComBtnDisable("btn2_save");
            // focus
            //frmObj.p_date1.focus();
        }
    }
    /**
     * handling OnKeyUp event in HTML Object
     */
    /**
     * handling OnChange event in HTML Object
     */
    function obj_onchange(event) {
        var frmObj=document.form;
        switch(event.srcElement.name) {
            // handling by vvdsts_change_combo option
            case "vvdsts_change_combo":
                var vvdStsCombo=frmObj.vvdsts_change_combo;
                if (vvdStsCombo.value == "VVD") {
                    frmObj.vvdcd_change.style.display="inline";
                    frmObj.stscd_change.style.display="none";
                    frmObj.stscd_change.selectedIndex=0;
                  //  frmObj.vvdcd_change.focus();
                } else {
                    frmObj.stscd_change.style.display="inline";
                    frmObj.vvdcd_change.style.display="none";
                    frmObj.vvdcd_change.value="";
//                    frmObj.stscd_change.focus();
                }
                break;
        }
        onShowErrMsg=false;
    }
    /**
     * handling MultiSelection OnCheckClick event in tpszCombo
     */
    function tpszCombo_OnCheckClick(comboObj, index, code) {
        // calling coCtm의 multiComboOnCheckClick 
        multiComboOnCheckClick(comboObj, Index,cntr_tpsz_cd);
    }
    /**
     * handling MultiSelection OnCheckClick event in statusCombo
     */
    function statusCombo_OnCheckClick(comboObj, index, code) {
        // calling coCtm의 multiComboOnCheckClick 
        multiComboOnCheckClick(comboObj, index, document.form.edi_mvmt_sts_cd);
    }
    /**
     * handling MultiSelection OnChange event in  mvmt_edi_msg_tp_id
     */
    function mvmt_edi_msg_tp_id_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var mvmtEdiRsltCd=document.form.mvmt_edi_rslt_cd;
        if (newIndex == "SPP") {
            mvmtEdiRsltCd.value="Y";
            ComEnableObject(mvmtEdiRsltCd, false);
        } else {
            mvmtEdiRsltCd.value="N";
            ComEnableObject(mvmtEdiRsltCd, true);
        }
    }
    /**
     * handling MultiSelection OnCheckClick event inioStatusCombo
     */
    function ioStatusCombo_OnCheckClick(comboObj, index, code) {
        // calling multiComboOnCheckClick
        multiComboOnCheckClick(comboObj, index, document.form.edi_gate_io_cd);
    }
    /**
     * handling OnSearchEnd event in Sheet1
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            var frmObj=document.form;
            with(sheetObj) {
            	frmObj.disp_total.value=ComAddComma(RowCount());
                if (appendPageNo < 2) {
                	frmObj.rtv_total.value=ComAddComma(sheetObj.EtcDataString("rtv_total"));
                	//document.form.rtv_total.value=ComAddComma(RowCount());
                    if (sheetObj.EtcDataString("mvmt_edi_rslt_cd") == "X") {
                        frmObj.gnd_total.value="";
                    } else {
                        frmObj.gnd_total.value=ComAddComma(sheetObj.EtcDataString("gnd_total"));
                    }
                    if (RowCount()> 0) {
                        ComBtnEnable("btn_detail");
                        ComBtnEnable("btn_vvdchange");
                        ComBtnEnable("btn2_retrieve");
                    } else {
                        ComBtnDisable("btn_detail");
                        ComBtnDisable("btn_vvdchange");
                        ComBtnDisable("btn2_retrieve");
                    }
                }
                row_Editable(sheetObj, appendPageNo, frmObj.pagerows.value);
                if (RowCount()< ComGetUnMaskedValue(frmObj.rtv_total.value, "int")) {
                    appendPageNo=Math.ceil(RowCount()/ frmObj.pagerows.value) + 1;
                    ComBtnEnable("btn_more");
                } else {
                    ComBtnDisable("btn_more");
                }
            }
            if (frmObj.user_svr_id.value == frmObj.mvmt_edi_msg_area_cd.value) {
                ComBtnEnable("btn_save");
            } else {
                ComBtnDisable("btn_save");
            }
        }
        ComOpenWait(false);
        sheetObjects[1].SetWaitImageVisible(1);
        sheetObjects[0].SetWaitImageVisible(1);
    }
     /**
      * event when clicking cell in IBSheet data part
      * @param {sheetObj} String :  IBSheet cell name
      * @param {Row} Long : cell Row Index
      * @param {Col} Long : cell Column Index
      * @param {Value} String : changed value
      * @param {CellX} Long : cell x-coordinate
      * @param {CellY} Long : cell y-coordinate
      * @param {CellW} Long : cell width
      * @param {CellH} Long : cell length
      */
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
        with(sheetObj) {
            if (ColSaveName(Col) != "Sel") {
                var sRowStr=GetSelectionRows("/");
                var arr=sRowStr.split("/");
                if (arr.length > 1) {
                    for (i=0; i<arr.length; i++) {
                        if (GetCellEditable(arr[i], "Sel")) {
                            SetCellValue(arr[i], "Sel","1",0);
                        }
                    }
                }
            }
        }
    }
    /**
     * event when double clicking cell in IBSheet data part
     * @param {sheetObj} String :  IBSheet cell name
     * @param {Row} Long : cell Row Index
     * @param {Col} Long : cell Column Index
     * @param {Value} String : changed value
     * @param {CellX} Long : cell x-coordinate
     * @param {CellY} Long : cell y-coordinate
     * @param {CellW} Long : cell width
     * @param {CellH} Long : cell length
     */
    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
        with (sheetObj) {
            if (ColSaveName(Col) != "Sel") {
                ComOpenPopup("/opuscntr/EES_CTM_0442.do" +
                             "?mvmt_edi_msg_area_cd=" + Cellvalue(Row, "mvmt_edi_msg_area_cd") +
                             "&mvmt_edi_msg_seq=" + Cellvalue(Row, "mvmt_edi_msg_seq") +
                             "&mvmt_edi_msg_tp_id=" + Cellvalue(Row, "mvmt_edi_msg_tp_id") +
                             "&mvmt_edi_msg_yrmondy=" + Cellvalue(Row, "mvmt_edi_msg_yrmondy") +
                             "&mvmt_edi_tp_cd=" + Cellvalue(Row, "mvmt_edi_tp_cd"), 920, 485, "", "0,1");
            }
        }
    }
    /**
     * handling OnKeyUp event in Sheet1
     */
    function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
        with (sheetObj) {
            switch(ColSaveName(Col)) {
                case "cntr_no":
                    if (GetEditText().length > 10) {
                        SelectCell(Row, Col++);
                    }
                    break;
            }
        }
    }
    /**
     * handling OnChange event in Sheet1
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
        with (sheetObj) {
            if (ColSaveName(Col) != "Sel") {
                SetCellValue(Row, "Sel","1",0);
            }
            if (ColSaveName(Col) == "cnmv_rmk") {
            	SetRowStatus(Row,(GetCellValue(Row, "upd_flag") == "" ? "R" : GetCellValue(Row, "upd_flag")));
            } else {
            	SetCellValue(Row, "upd_flag",GetRowStatus(Row),0);
            }
            if (Value != CellSearchValue(Row, Col)) {
                switch(ColSaveName(Col)) {
                    case "cntr_no":
                    	var xml=GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH10 + "&p_cntrno=" + Value);
                        rtnValue=ComGetEtcData(xml, "rtnValue");
                        if (!rtnValue) {
                            SetCellValue(Row, "cntr_tpsz_cd",CellSearchValue(Row, "cntr_tpsz_cd"),0);
                            LoadSearchData(xml,{Sync:0} );
                            sheetValidation=false;
                            SelectCell(Row, Col, true, CellSearchValue(Row, Col));
                        } else {
                            sheetValidation=true;
                            // rtnValue = "CNTR_NO"|"CNMV_STS_CD"|"CNTR_TPSZ_CD"|"CRNT_YD_CD"|"ACIAC_DIV_CD"|"COM_CRE_FLG"|"IMDT_EXT_FLG"
                            var arr=rtnValue.split("|");
                            SetCellValue(Row, "cntr_tpsz_cd",arr[2],0);
                            SelectCell(Row, "cntr_tpsz_cd");
                        }
                        break;
                    case "bkg_no":
                        if (Value != "" && !code_search(Value, "BKG_NO", "BKG_BOOKING")) {
                            sheetValidation=false;
                            SelectCell(Row, Col, true, CellSearchValue(Row, Col));
                        } else {
                            sheetValidation=true;
                        }
                        break;
                    case "vvd_cd":
                    	var xml=GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH12 + "&vvdcode=" + Value);
                        var rtnValue=ComGetEtcData(xml, "rtnValue");
                        if (!rtnValue) {
                        	LoadSearchData(xml,{Sync:0} );
                            sheetValidation=false;
                            SelectCell(Row, Col, true, CellSearchValue(Row, Col));
                        } else {
                            sheetValidation=true;
                            SetCellValue(Row, "crnt_vsl_cd",Value.substring(0, 4),0);
                            SetCellValue(Row, "crnt_skd_voy_no",Value.substring(4, 8),0);
                            SetCellValue(Row, "crnt_skd_dir_cd",Value.substring(8, 9),0);
                        }
                        break;
                    case "edi_mvmt_sts_cd":
                    	var xml=GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH09 + "&mvmt_sts_cd=" + Value);
                        var rtnValue=ComGetEtcData(xml, "rtnValue");
                        if (rtnValue == "0" || rtnValue == "") {
                            ComShowCodeMessage("CTM20102");
                            sheetValidation=false;
                            SelectCell(Row, Col, true, CellSearchValue(Row, Col));
                        } else {
                            sheetValidation=true;
                        }
                        break;
                }
            }
        }
    }
function row_Editable(sheetObj, PageNo, OnePageRows) {
 var startRowNo=OnePageRows* (PageNo - 1) + 1;
 var endRowNo=OnePageRows* PageNo;
        with (sheetObj) {
            RenderSheet(0);
            for (var i=startRowNo; i<=endRowNo; i++) {
            	if (GetCellValue(i, "mvmt_edi_rslt_cd") == "Y" || GetCellValue(i, "mvmt_edi_sght_cd") == "X") {
                    SetRowEditable(i,0);
                } else {
                	if (GetCellValue(i, "edi_mvmt_sts_cd") != "VL" && GetCellValue(i, "edi_mvmt_sts_cd") != "VD") {
                        SetCellEditable(i, "vvd_cd",0);
                    }
                }
            }
            RenderSheet(1);
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, frmObj, sAction) {
        with (frmObj) {
        }
        return true;
    }
    function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            var rtnStr=sheetObj.GetEtcData("rtnStr");
            if (rtnStr != null && rtnStr != "" && rtnStr !=  "undefined") {
                ComShowMessage(rtnStr);
            } else {
                // 전역변수 fromSheet1 체크
                if (fromSheet1 > 0) {
                    var sheet1selectRow=sheetObjects[0].FindCheckedRow("Sel").split("|")[0];
                    sheetObjects[0].SetCellValue(sheet1selectRow, "rty_knt",parseInt(sheetObjects[0].GetCellValue(sheet1selectRow, "rty_knt")) + 1);
                    sheetObjects[0].SetCellValue(sheet1selectRow, "mvmt_edi_rmk","OK.PROCESSED");
                    sheetObjects[0].SetCellValue(sheet1selectRow, "mvmt_edi_rslt_cd","Y");
                }
            }
            fromSheet1=0;
            doActionIBSheet(sheetObj, document.form, SEARCH02);
        }
    }
    /**
     * handling OnSearchEnd evnet in Sheet2
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
        ComOpenWait(false);
        if (ErrMsg == "") {
            if (sheetObj.RowCount()> 0) {
                var frmObj=document.form;
                DomSetFormObjDisable(frmObj, true);
                statusCombo.SetEnable(0);
                mvmt_edi_msg_tp_id.SetEnable(0);
                p_yard2.SetEnable(0);
                ioStatusCombo.SetEnable(0);
                sheetObjects[0].SetEditable(0);
                sheetObjects[1].SetActionMenu("Insert|Overwrite");
                ComBtnDisable("btn_vvdchange");
                ComBtnDisable("btn_more");
                ComBtnDisable("btn_retrieve");
                ComBtnDisable("btn_save");
                ComBtnEnable("btn2_add");
                ComBtnEnable("btn2_delete");
                ComBtnEnable("btn2_save");
                row_Editable4Sheet2();
            } else {
                ComBtnDisable("btn2_add");
                ComBtnDisable("btn2_delete");
                ComBtnDisable("btn2_save");
            }
        }
        sheetObjects[0].SetWaitImageVisible(1);
        sheetObjects[1].SetWaitImageVisible(1);
    }
    /**
     * Sheet2의 OnMouseDown 이벤트 처리
     */
    function sheet2_OnMouseDown(sheetObj, Button, Shift, X, Y) {
        with(sheetObj) {
            if (RowCount()> 0) {
                // click한 row와 아래 row가 모두 RowEditable이 false면 btn2_add를 disable - 2010-07-08 : Rqst by IHJang
                if (!GetRowEditable(MouseRow()) && !GetRowEditable(MouseRow()+ 1)) {
                    ComBtnDisable("btn2_add");
                    SetActionMenu("");
                } else {
                    ComBtnEnable("btn2_add");
                    SetActionMenu("Insert|Overwrite");
                    if (Button == 2) {
                        SetSelectRow(MouseRow());
                    }
                }
            }
        }
    }
    /**
     * handling OnSelectMenu in Sheet2
     */
    function sheet2_OnSelectMenu(sheetObj, MenuString) {
        var sheet1CheckRow=sheetObjects[0].FindCheckedRow("Sel").split("|")[0];
        with (sheetObj) {
            switch (MenuString) {
                case "Insert":
                    if (!addRow()) return;
                    var row=GetSelectRow();
                    if (GetCellEditable(row, "mvmt_sts_cd") && sheetObjects[0].GetCellValue(sheet1CheckRow, "edi_mvmt_sts_cd") != "") {
                    	SetCellValue(row, "mvmt_sts_cd",sheetObjects[0].GetCellValue(sheet1CheckRow, "edi_mvmt_sts_cd"));
                    }
                    if (!sheet2valid) {
                        RowDelete(row, false);
                        sheet2valid=true;
                        return;
                    }
                    if (GetCellEditable(row, "org_yd_cd") && sheetObjects[0].GetCellValue(sheet1CheckRow, "evnt_yd_cd") != "") {
                    	SetCellValue(row, "org_yd_cd",sheetObjects[0].GetCellValue(sheet1CheckRow, "evnt_yd_cd"));
                    }
                    if (!sheet2valid) {
                        RowDelete(row, false);
                        sheet2valid=true;
                        return;
                    }
                    if (GetCellEditable(row, "cnmv_evnt_dt") && sheetObjects[0].GetCellText(sheet1CheckRow, "evnt_dt") != "") {
                        SetCellValue(row, "cnmv_evnt_dt",sheetObjects[0].GetCellText(sheet1CheckRow, "evnt_dt"));
                    }
                    if (!sheet2valid) {
                        RowDelete(row, false);
                        sheet2valid=true;
                        return;
                    }
                    if (GetCellEditable(row, "cntr_id") && sheetObjects[0].GetCellValue(sheet1CheckRow, "vvd_cd") != "") {
                    	SetCellValue(row, "cntr_id",sheetObjects[0].GetCellValue(sheet1CheckRow, "vvd_cd"));
                    }
                    if (!sheet2valid) {
                        RowDelete(row, false);
                        sheet2valid=true;
                        return;
                    }
                    if (GetCellEditable(row, "vndr_seq") && (sheetObjects[0].GetCellValue(sheet1CheckRow, "vndr_seq") != "" && sheetObjects[0].GetCellValue(sheet1CheckRow, "vndr_seq") != "0")) {
                    	SetCellValue(row, "vndr_seq",sheetObjects[0].GetCellValue(sheet1CheckRow, "vndr_seq"));
                    }
                    if (!sheet2valid) {
                        RowDelete(row, false);
                        sheet2valid=true;
                        return;
                    }
                    if (GetCellEditable(row, "chss_no") && sheetObjects[0].GetCellValue(sheet1CheckRow, "chss_no") != "") {
                    	SetCellValue(row, "chss_no",sheetObjects[0].GetCellValue(sheet1CheckRow, "chss_no"));
                    }
                    if (!sheet2valid) {
                        RowDelete(row, false);
                        sheet2valid=true;
                        return;
                    }
                    if (GetCellEditable(row, "mgst_no") && sheetObjects[0].GetCellValue(sheet1CheckRow, "mgst_no") != "") {
                    	SetCellValue(row, "mgst_no",sheetObjects[0].GetCellValue(sheet1CheckRow, "mgst_no"));
                    }
                    if (!sheet2valid) {
                        RowDelete(row, false);
                        sheet2valid=true;
                        return;
                    }
                    if (GetCellEditable(row, "cntr_seal_no") && sheetObjects[0].GetCellValue(sheet1CheckRow, "cntr_seal_no") != "") {
                    	SetCellValue(row, "cntr_seal_no",sheetObjects[0].GetCellValue(sheet1CheckRow, "cntr_seal_no"));
                    }
                    if (!sheet2valid) {
                        RowDelete(row, false);
                        sheet2valid=true;
                        return;
                    }
                    if (GetCellEditable(row, "wbl_no") && sheetObjects[0].GetCellValue(sheet1CheckRow, "wbl_no") != "") {
                    	SetCellValue(row, "wbl_no",sheetObjects[0].GetCellValue(sheet1CheckRow, "wbl_no"));
                    }
                    if (!sheet2valid) {
                        RowDelete(row, false);
                        sheet2valid=true;
                        return;
                    }
                    if (GetCellEditable(row, "pkup_no") && sheetObjects[0].GetCellValue(sheet1CheckRow, "pkup_no") != "") {
                    	SetCellValue(row, "pkup_no",sheetObjects[0].GetCellValue(sheet1CheckRow, "pkup_no"));
                    }
                    if (!sheet2valid) {
                        RowDelete(row, false);
                        sheet2valid=true;
                        return;
                    }
                    if (sheetObjects[0].GetCellValue(sheet1CheckRow, "mvmt_edi_msg_area_cd") != "") {
                    	SetCellValue(row, "mvmt_edi_msg_area_cd",sheetObjects[0].GetCellValue(sheet1CheckRow, "mvmt_edi_msg_area_cd"),0);
                    }
                    if (sheetObjects[0].GetCellValue(sheet1CheckRow, "mvmt_edi_msg_seq") != "") {
                    	SetCellValue(row, "mvmt_edi_msg_seq",sheetObjects[0].GetCellValue(sheet1CheckRow, "mvmt_edi_msg_seq"),0);
                    }
                    if (sheetObjects[0].GetCellValue(sheet1CheckRow, "mvmt_edi_msg_yrmondy") != "") {
                    	SetCellValue(row, "mvmt_edi_msg_yrmondy",sheetObjects[0].GetCellValue(sheet1CheckRow, "mvmt_edi_msg_yrmondy"),0);
                    }
                    if (sheetObjects[0].GetCellValue(sheet1CheckRow, "mvmt_edi_tp_cd") != "") {
                    	SetCellValue(row, "mvmt_edi_tp_cd",sheetObjects[0].GetCellValue(sheet1CheckRow, "mvmt_edi_tp_cd"),0);
                    }
                    break;
                case "Overwrite":
                    var row=GetSelectRow();
                    if (!GetRowEditable(row)) {
                        ComShowCodeMessage("CTM20108");
                        return;
                    } else {
                        var mvmtStsCd=GetCellText(row, "mvmt_sts_cd") + "";
                        var orgYdCd=GetCellText(row, "org_yd_cd") + "";
                        var destYdCd=GetCellText(row, "dest_yd_cd") + "";
                        var cnmvEvntDt=GetCellText(row, "cnmv_evnt_dt");
                        var cntrId=GetCellText(row, "cntr_id") + "";
                        var vndrSeq=GetCellText(row, "vndr_seq") + "";
                        var chssNo=GetCellText(row, "chss_no") + "";
                        var mgstNo=GetCellText(row, "mgst_no") + "";
                        var cntrSealNo=GetCellText(row, "cntr_seal_no") + "";
                        var wblNo=GetCellText(row, "wbl_no") + "";
                        var pkupNo=GetCellText(row, "pkup_no") + "";
                        if (GetCellEditable(row, "mvmt_sts_cd") && sheetObjects[0].GetCellValue(sheet1CheckRow, "edi_mvmt_sts_cd") != "") {
                        	SetCellValue(row, "mvmt_sts_cd",sheetObjects[0].GetCellValue(sheet1CheckRow, "edi_mvmt_sts_cd"));
                        }
                        if (!sheet2valid) {
                            if (GetCellEditable(row, "mvmt_sts_cd")) SetCellValue(row, "mvmt_sts_cd",mvmtStsCd,0);
                            sheet2valid=true;
                            clearStatus(sheetObj, row);
                            clearColor(sheetObj, row);
                            SelectCell(row, "mvmt_sts_cd", true);
                            return;
                        }
                        if (GetCellEditable(row, "org_yd_cd") && sheetObjects[0].GetCellValue(sheet1CheckRow, "evnt_yd_cd") != "") {
                        	SetCellValue(row, "org_yd_cd",sheetObjects[0].GetCellValue(sheet1CheckRow, "evnt_yd_cd"));
                        }
                        if (!sheet2valid) {
                            if (GetCellEditable(row, "org_yd_cd")) SetCellValue(row, "org_yd_cd",orgYdCd,0);
                            if (GetCellEditable(row, "mvmt_sts_cd")) SetCellValue(row, "mvmt_sts_cd",mvmtStsCd,0);
                            sheet2valid=true;
                            clearStatus(sheetObj, row);
                            clearColor(sheetObj, row);
                            SelectCell(row, "org_yd_cd", true);
                            return;
                        }
                        if (GetCellEditable(row, "cnmv_evnt_dt") && sheetObjects[0].GetCellText(sheet1CheckRow, "evnt_dt") != "") {
                            SetCellValue(row, "cnmv_evnt_dt",sheetObjects[0].GetCellText(sheet1CheckRow, "evnt_dt"));
                        }
                        if (!sheet2valid) {
                            if (GetCellEditable(row, "cnmv_evnt_dt")) SetCellValue(row, "cnmv_evnt_dt",cnmvEvntDt,0);
                            if (GetCellEditable(row, "dest_yd_cd")) SetCellValue(row, "dest_yd_cd",destYdCd,0);
                            if (GetCellEditable(row, "org_yd_cd")) SetCellValue(row, "org_yd_cd",orgYdCd,0);
                            if (GetCellEditable(row, "mvmt_sts_cd")) SetCellValue(row, "mvmt_sts_cd",mvmtStsCd,0);
                            sheet2valid=true;
                            clearStatus(sheetObj, row);
                            clearColor(sheetObj, row);
                            SelectCell(row, "cnmv_evnt_dt", true);
                            return;
                        }
                        if (GetCellEditable(row, "cntr_id") && sheetObjects[0].GetCellValue(sheet1CheckRow, "vvd_cd") != "") {
                        	SetCellValue(row, "cntr_id",sheetObjects[0].GetCellValue(sheet1CheckRow, "vvd_cd"));
                        }
                        if (!sheet2valid) {
                            if (GetCellEditable(row, "cntr_id")) SetCellValue(row, "cntr_id",cntrId,0);
                            if (GetCellEditable(row, "cnmv_evnt_dt")) SetCellValue(row, "cnmv_evnt_dt",cnmvEvntDt,0);
                            if (GetCellEditable(row, "dest_yd_cd")) SetCellValue(row, "dest_yd_cd",destYdCd,0);
                            if (GetCellEditable(row, "org_yd_cd")) SetCellValue(row, "org_yd_cd",orgYdCd,0);
                            if (GetCellEditable(row, "mvmt_sts_cd")) SetCellValue(row, "mvmt_sts_cd",mvmtStsCd,0);
                            sheet2valid=true;
                            clearStatus(sheetObj, row);
                            clearColor(sheetObj, row);
                            SelectCell(row, "cntr_id", true);
                            return;
                        }
                        if (GetCellEditable(row, "vndr_seq") && (sheetObjects[0].GetCellValue(sheet1CheckRow, "vndr_seq") != "" && sheetObjects[0].GetCellValue(sheet1CheckRow, "vndr_seq") != "0")) {
                        	SetCellValue(row, "vndr_seq",sheetObjects[0].GetCellValue(sheet1CheckRow, "vndr_seq"));
                        }
                        if (!sheet2valid) {
                            if (GetCellEditable(row, "vndr_seq")) SetCellValue(row, "vndr_seq",vndrSeq,0);
                            if (GetCellEditable(row, "cntr_id")) SetCellValue(row, "cntr_id",cntrId,0);
                            if (GetCellEditable(row, "cnmv_evnt_dt")) SetCellValue(row, "cnmv_evnt_dt",cnmvEvntDt,0);
                            if (GetCellEditable(row, "dest_yd_cd")) SetCellValue(row, "dest_yd_cd",destYdCd,0);
                            if (GetCellEditable(row, "org_yd_cd")) SetCellValue(row, "org_yd_cd",orgYdCd,0);
                            if (GetCellEditable(row, "mvmt_sts_cd")) SetCellValue(row, "mvmt_sts_cd",mvmtStsCd,0);
                            sheet2valid=true;
                            clearStatus(sheetObj, row);
                            clearColor(sheetObj, row);
                            SelectCell(row, "vndr_seq", true);
                            return;
                        }
                        if (GetCellEditable(row, "chss_no") && sheetObjects[0].GetCellValue(sheet1CheckRow, "chss_no") != "") {
                        	SetCellValue(row, "chss_no",sheetObjects[0].GetCellValue(sheet1CheckRow, "chss_no"));
                        }
                        if (!sheet2valid) {
                            if (GetCellEditable(row, "chss_no")) SetCellValue(row, "chss_no",chssNo,0);
                            if (GetCellEditable(row, "vndr_seq")) SetCellValue(row, "vndr_seq",vndrSeq,0);
                            if (GetCellEditable(row, "cntr_id")) SetCellValue(row, "cntr_id",cntrId,0);
                            if (GetCellEditable(row, "cnmv_evnt_dt")) SetCellValue(row, "cnmv_evnt_dt",cnmvEvntDt,0);
                            if (GetCellEditable(row, "dest_yd_cd")) SetCellValue(row, "dest_yd_cd",destYdCd,0);
                            if (GetCellEditable(row, "org_yd_cd")) SetCellValue(row, "org_yd_cd",orgYdCd,0);
                            if (GetCellEditable(row, "mvmt_sts_cd")) SetCellValue(row, "mvmt_sts_cd",mvmtStsCd,0);
                            sheet2valid=true;
                            clearStatus(sheetObj, row);
                            clearColor(sheetObj, row);
                            SelectCell(row, "chss_no", true);
                            return;
                        }
                        if (GetCellEditable(row, "mgst_no") && sheetObjects[0].GetCellValue(sheet1CheckRow, "mgst_no") != "") {
                        	SetCellValue(row, "mgst_no",sheetObjects[0].GetCellValue(sheet1CheckRow, "mgst_no"));
                        }
                        if (!sheet2valid) {
                            if (GetCellEditable(row, "mgst_no")) SetCellValue(row, "mgst_no",mgstNo,0);
                            if (GetCellEditable(row, "chss_no")) SetCellValue(row, "chss_no",chssNo,0);
                            if (GetCellEditable(row, "vndr_seq")) SetCellValue(row, "vndr_seq",vndrSeq,0);
                            if (GetCellEditable(row, "cntr_id")) SetCellValue(row, "cntr_id",cntrId,0);
                            if (GetCellEditable(row, "cnmv_evnt_dt")) SetCellValue(row, "cnmv_evnt_dt",cnmvEvntDt,0);
                            if (GetCellEditable(row, "dest_yd_cd")) SetCellValue(row, "dest_yd_cd",destYdCd,0);
                            if (GetCellEditable(row, "org_yd_cd")) SetCellValue(row, "org_yd_cd",orgYdCd,0);
                            if (GetCellEditable(row, "mvmt_sts_cd")) SetCellValue(row, "mvmt_sts_cd",mvmtStsCd,0);
                            sheet2valid=true;
                            clearStatus(sheetObj, row);
                            clearColor(sheetObj, row);
                            SelectCell(row, "mgst_no", true);
                            return;
                        }
                        if (GetCellEditable(row, "cntr_seal_no") && sheetObjects[0].GetCellValue(sheet1CheckRow, "cntr_seal_no") != "") {
                        	SetCellValue(row, "cntr_seal_no",sheetObjects[0].GetCellValue(sheet1CheckRow, "cntr_seal_no"));
                        }
                        if (!sheet2valid) {
                            if (GetCellEditable(row, "cntr_seal_no")) SetCellValue(row, "cntr_seal_no",cntrSealNo,0);
                            if (GetCellEditable(row, "mgst_no")) SetCellValue(row, "mgst_no",mgstNo,0);
                            if (GetCellEditable(row, "chss_no")) SetCellValue(row, "chss_no",chssNo,0);
                            if (GetCellEditable(row, "vndr_seq")) SetCellValue(row, "vndr_seq",vndrSeq,0);
                            if (GetCellEditable(row, "cntr_id")) SetCellValue(row, "cntr_id",cntrId,0);
                            if (GetCellEditable(row, "cnmv_evnt_dt")) SetCellValue(row, "cnmv_evnt_dt",cnmvEvntDt,0);
                            if (GetCellEditable(row, "dest_yd_cd")) SetCellValue(row, "dest_yd_cd",destYdCd,0);
                            if (GetCellEditable(row, "org_yd_cd")) SetCellValue(row, "org_yd_cd",orgYdCd,0);
                            if (GetCellEditable(row, "mvmt_sts_cd")) SetCellValue(row, "mvmt_sts_cd",mvmtStsCd,0);
                            sheet2valid=true;
                            clearStatus(sheetObj, row);
                            clearColor(sheetObj, row);
                            SelectCell(row, "cntr_seal_no", true);
                            return;
                        }
                        if (GetCellEditable(row, "wbl_no") && sheetObjects[0].GetCellValue(sheet1CheckRow, "wbl_no") != "") {
                        	SetCellValue(row, "wbl_no",sheetObjects[0].GetCellValue(sheet1CheckRow, "wbl_no"));
                        }
                        if (!sheet2valid) {
                            if (GetCellEditable(row, "wbl_no")) SetCellValue(row, "wbl_no",wblNo,0);
                            if (GetCellEditable(row, "cntr_seal_no")) SetCellValue(row, "cntr_seal_no",cntrSealNo,0);
                            if (GetCellEditable(row, "mgst_no")) SetCellValue(row, "mgst_no",mgstNo,0);
                            if (GetCellEditable(row, "chss_no")) SetCellValue(row, "chss_no",chssNo,0);
                            if (GetCellEditable(row, "vndr_seq")) SetCellValue(row, "vndr_seq",vndrSeq,0);
                            if (GetCellEditable(row, "cntr_id")) SetCellValue(row, "cntr_id",cntrId,0);
                            if (GetCellEditable(row, "cnmv_evnt_dt")) SetCellValue(row, "cnmv_evnt_dt",cnmvEvntDt,0);
                            if (GetCellEditable(row, "dest_yd_cd")) SetCellValue(row, "dest_yd_cd",destYdCd,0);
                            if (GetCellEditable(row, "org_yd_cd")) SetCellValue(row, "org_yd_cd",orgYdCd,0);
                            if (GetCellEditable(row, "mvmt_sts_cd")) SetCellValue(row, "mvmt_sts_cd",mvmtStsCd,0);
                            sheet2valid=true;
                            clearStatus(sheetObj, row);
                            clearColor(sheetObj, row);
                            SelectCell(row, "wbl_no", true);
                            return;
                        }
                        if (GetCellEditable(row, "pkup_no") && sheetObjects[0].GetCellValue(sheet1CheckRow, "pkup_no") != "") {
                        	SetCellValue(row, "pkup_no",sheetObjects[0].GetCellValue(sheet1CheckRow, "pkup_no"));
                        }
                        if (!sheet2valid) {
                            if (GetCellEditable(row, "pkup_no")) SetCellValue(row, "pkup_no",pkupNo,0);
                            if (GetCellEditable(row, "wbl_no")) SetCellValue(row, "wbl_no",wblNo,0);
                            if (GetCellEditable(row, "cntr_seal_no")) SetCellValue(row, "cntr_seal_no",cntrSealNo,0);
                            if (GetCellEditable(row, "mgst_no")) SetCellValue(row, "mgst_no",mgstNo,0);
                            if (GetCellEditable(row, "chss_no")) SetCellValue(row, "chss_no",chssNo,0);
                            if (GetCellEditable(row, "vndr_seq")) SetCellValue(row, "vndr_seq",vndrSeq,0);
                            if (GetCellEditable(row, "cntr_id")) SetCellValue(row, "cntr_id",cntrId,0);
                            if (GetCellEditable(row, "cnmv_evnt_dt")) SetCellValue(row, "cnmv_evnt_dt",cnmvEvntDt,0);
                            if (GetCellEditable(row, "dest_yd_cd")) SetCellValue(row, "dest_yd_cd",destYdCd,0);
                            if (GetCellEditable(row, "org_yd_cd")) SetCellValue(row, "org_yd_cd",orgYdCd,0);
                            if (GetCellEditable(row, "mvmt_sts_cd")) SetCellValue(row, "mvmt_sts_cd",mvmtStsCd,0);
                            sheet2valid=true;
                            clearStatus(sheetObj, row);
                            clearColor(sheetObj, row);
                            SelectCell(row, "pkup_no", true);
                            return;
                        }
                    }
                    break;
            }
        fromSheet1 ++;
        }
    }
    function clearColor(sheetObj, Row) {
        with (sheetObj) {
            RenderSheet(0);
            SetRowBackColor(Row,0);
            for(i=0;i<LastCol();i++) {
                if (!GetCellEditable(Row, i)) {
                    //no support[check again]CLT CellBackColor(Row, i)=UnEditableColor;
                }
            }
            RenderSheet(1);
        }
    }
    /**
     * common_0430.js
     *
     * function deleteCondition(rmSubstr)
     * function deleteRow(sheetObj, Row)
     * function row_Editable4Sheet2()
     * function sheet2_OnChange(sheetObj, Row, Col, Value)
     * function sheet2_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH)
     */
