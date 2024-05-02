/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_ctm_0404.js
*@FileTitle  : Update of EDI Message (All MSG)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
***************************************************************************************/
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
var deletedCount=0;
var totalCount=0;
var errorXml="";
var saveXml=new Array();
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
    var sheetObj1=sheetObjects[0];
    var frmObj=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
            case "btn_Calendar":
                    var cal=new ComCalendarFromTo();
                    cal.select(frmObj.p_date1, frmObj.p_date2, "yyyy-MM-dd");
                break;
            case "btn_vvdchange":
                with (sheetObj1) {
                    if (CheckedRows("Sel") < 1) {
                        ComShowCodeMessage("CTM30001");
                        return;
                    } else {
                        if (frmObj.vvdsts_change_combo.value == "VVD") {
//                            if (frmObj.vvdcd_change.value.length < 9) {
//                                ComShowCodeMessage("CTM20073");
//                                return;
//                            }
                        	
                        	if (frmObj.vvdcd_change.value.length == 7) {
                            	if(confirm("Is this OSCAR VVD?")){
                    			    var strQuery="f_cmd=" + SEARCH06 + "&p_vvd=" + frmObj.vvdcd_change.value;
                    			    var returnXml=sheetObjects[0].GetSearchData("EES_CTM_0406GS.do", strQuery);
                    			    var rtnValue=ComGetEtcData(returnXml, "rtnStr");
                    			    
                    			    if(rtnValue!=null && rtnValue!="" && rtnValue.length==9){
                    			    	 frmObj.vvdcd_change.value = rtnValue.trim()
                    			    	 
                    			    }else{
                    			    	ComShowCodeMessage("CTM20073"); // VVD Code is Not Exists
                    			    	return false;
                    			    }
                    			}
                        	}
                        }
                        
                        
                        if(!ComShowCodeConfirm("CTM99999", "Do you really want to Edit?"))
                        	return;
                        var arr=FindCheckedRow("Sel").split("|");
                        for (var i=0; i<arr.length; i++) {
                        	if (frmObj.vvdsts_change_combo.value == "CNTR") {
                                if (GetCellEditable(arr[i], "cntr_no")) {
                                    SetCellValue(arr[i], "cntr_no",frmObj.vvdcd_change.value,0);
                                    SetRowStatus(arr[i],"U");
                                }
                            } else if (frmObj.vvdsts_change_combo.value == "YARD") {
                                if (GetCellEditable(arr[i], "evnt_yd_cd")) {
                                    SetCellValue(arr[i], "evnt_yd_cd",frmObj.vvdcd_change.value,0);
                                    SetRowStatus(arr[i],"U");
                                }
                            } else if (frmObj.vvdsts_change_combo.value == "BKG") {
                                if (GetCellEditable(arr[i], "bkg_no")) {
                                    SetCellValue(arr[i], "bkg_no",frmObj.vvdcd_change.value,0);
                                    SetRowStatus(arr[i],"U");
                                }
                            } else if (frmObj.vvdsts_change_combo.value == "FM") {
                                if (GetCellEditable(arr[i], "cntr_full_sts_cd")) {
                                    SetCellValue(arr[i], "cntr_full_sts_cd",frmObj.vvdcd_change.value,0);
                                    SetRowStatus(arr[i],"U");
                                }
                            } else if (frmObj.vvdsts_change_combo.value == "VVD") {
                                if (GetCellEditable(arr[i], "vvd_cd")) {
                                    SetCellValue(arr[i], "vvd_cd",frmObj.vvdcd_change.value,0);
                                    SetCellValue(arr[i], "crnt_vsl_cd",frmObj.vvdcd_change.value.substring(0, 4),0);
                                    SetCellValue(arr[i], "crnt_skd_voy_no",frmObj.vvdcd_change.value.substring(4, 8),0);
                                    SetCellValue(arr[i], "crnt_skd_dir_cd",frmObj.vvdcd_change.value.substring(8, 9),0);
                                    SetRowStatus(arr[i],"U");
                                }
                            } else if (frmObj.vvdsts_change_combo.value == "REMARK") {
                                if (GetCellEditable(arr[i], "cnmv_rmk")) {
                                    SetCellValue(arr[i], "cnmv_rmk",frmObj.vvdcd_change.value,0);
                                    SetRowStatus(arr[i],"U");
                                }
                            } else {
                                if (GetCellEditable(arr[i], "edi_mvmt_sts_cd")) {
                                    SetCellValue(arr[i], "edi_mvmt_sts_cd",frmObj.stscd_change.value,0);
                                    SetRowStatus(arr[i],"U");
                                }
                            }
                        }
                    }
                }
                break;
            case "btn_delete":
                with (sheetObj1) {
                    if (CheckedRows("Sel") < 1) {
                        ComShowCodeMessage("CTM30001");
                        return;
                    } else {
                        if(!ComShowCodeConfirm("CTM99999", "Do you really want to Delete?"))
                        	return;
                        var arr=FindCheckedRow("Sel").split("|");
                        for (var i=0; i<arr.length; i++) {
                            if (GetCellValue(arr[i], "cnmv_rmk") == "") {
                            	ComShowCodeMessage("CTM99999", "Please input Remark(s).");
                            	return;
                            }
                        }
                        for (var i=0; i<arr.length; i++) {
                            if (GetCellEditable(arr[i], "mvmt_edi_rslt_cd")) {
                                SetCellValue(arr[i], "mvmt_edi_rslt_cd", "D", 0);
                                SetRowStatus(arr[i],"U");
                                SetRowEditable(arr[i], false);
                            }
                        }
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
                sheetObj1.WaitImageVisible=false;
                ComOpenWait(true);
                if(sheetObj1.RowCount() < 1){//no data
                	ComShowCodeMessage("COM132501");
                    ComOpenWait(false);
                }else{
                    sheetObj1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj1), SheetDesign:1,Merge:1 });
                }
                //sheetObj1.SetWaitImageVisible(1);
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
    ComBtnDisable("btn_delete");
    
    axon_event.addListenerForm('blur', 'obj_onkeyup', document.form);
    // CTM-COMMON (& exception)
    setEventProcess("cntrno_disp", "yd_cd_disp", "lcc_cd", "rcc_cd", "vvd_combo", "vvdcd_change");
    
    // OnKeyPress event (common function)
    axon_event.addListener("keypress", "obj_keypress", "cntrno_disp", "yd_cd_disp", "lcc_cd", "rcc_cd", "vvdcd_change");
    // OnKeyUp event
    axon_event.addListener("keyup", "obj_onkeyup", "cntrno_disp", "yd_cd_disp", "lcc_cd", "rcc_cd", "vvdcd_change");
    // OnChange event 
    axon_event.addListener("change", "obj_onchange", "vvdsts_change_combo", "mvmt_edi_rslt_cd");

    sheetObj=sheetObjects[0];
    setComboData(sheetObj);
    
    with (document.form) {
        // Request Setting
        vvd_combo.value=vvdCombo.value;
        if (cntrFullStsCd.value != "") cntr_full_sts_cd.value=cntrFullStsCd.value;
        vvd_combo.value=vvdCombo.value;
        mvmt_edi_rslt_cd.value=mvmtEdiRsltCd.value;
        if (rtyKnt.value != "") rty_knt.value=rtyKnt.value;
        // retrieving server ID with office code of login user
        doActionIBSheet(sheetObjects[0], document.form, SEARCH16);
        // retrieving in case parameter exists as Request
        if (requestYN.value == "Y") doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        // focusing on page loading
        p_date1.focus();
        p_date2.focus();
    }
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    with (sheetObj) {
        switch (sheetNo) {
        case 1:    // sheet[0] init
        document.form.pagerows.value=500;
        //(43, 4, 0, true);
        SetSelectionMode(smSelectionList);
        
        var HeadTitle="|Seq.||Container No.|T/S|ORG YD|Event Date|Receiving Date|DM Flg|DM Flg Dt|DM Unflg Dt|Booking No.|EDI Booking|EDI B/L No.|VVD Code|EDI VVD Code|EDI Vessel Name|Call sign/Lloyd|EQR Ref. No.|EDI EQR Ref. No.|Seal No.|Chassis No.|M.G Set|S/P|EDI Carrier Code|EDI Stowage|Mode|LCC|RTN YD|POL|POD|STS|Gate In/Out|F/M|Export/Import|Retry|Result|Result error message|Remark(s)";
        HeadTitle += "|crnt_vsl_cd|crnt_skd_voy_no|crnt_skd_dir_cd|call_sgn_no|lloyd_no|wbl_no|pkup_no|mvmt_edi_msg_area_cd|mvmt_edi_msg_seq|mvmt_edi_msg_tp_id|mvmt_edi_msg_yrmondy|mvmt_edi_tp_cd|upd_flag";
        HeadTitle += "|dest_loc_nm|dest_ste_nm|vgm_doc_id_no|vgm_wgt|vgm_edi_wgt_ut_cd|vgm_doc_tp_cd|vgm_dt_tp_cd|vgm_hndl_dt|vgm_cust_cntc_tp_cd|vgm_cust_cntc_nm|vgm_cust_fax_no|vgm_cust_eml|vgm_cust_phn_no|vgm_cust_addr|WO No.|TIR No.|EDI CRR No.|TRSP DOC No.|FLT FILE REF No.|Update User ID";
        SetEditEnterBehavior("tab");

        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:8, DataRowMerge:1 } );

        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        var headers = [ { Text:HeadTitle, Align:"Center"} ];
        InitHeaders(headers, info);

        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
               {Type:"Seq",        Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
               {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Sel" },
               {Type:"Text",       Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
               {Type:"Text",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"evnt_yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
               {Type:"Text",       Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"evnt_dt",               KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cre_locl_dt",           KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Combo",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_dmg_flg",    	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
               {Type:"Text",       Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"dmg_flg_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
               {Type:"Text",       Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"dmg_unflg_dt",          KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
               {Type:"Text",       Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
               {Type:"Text",       Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"edi_bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
               {Type:"Text",       Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"edi_vvd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"vsl_eng_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"call_sgn_lloyd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mty_pln_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
               {Type:"Text",       Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"edi_mty_eq_repo_ref_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"chss_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mgst_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"usa_edi_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_stwg_psn_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lcc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dest_yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"edi_mvmt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
               {Type:"Text",       Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"edi_gate_io_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_full_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
               {Type:"Text",       Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_sght_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rty_knt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_rslt_cd" },
               {Type:"Text",       Hidden:0, Width:350,  Align:"Left",    ColMerge:0,   SaveName:"mvmt_edi_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:499 },
               {Type:"Text",       Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"cnmv_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:499 },
               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"crnt_vsl_cd" },
               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"crnt_skd_voy_no" },
               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"crnt_skd_dir_cd" },
               {Type:"Text",       Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"call_sgn_no" },
               {Type:"Text",       Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"lloyd_no" },
               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"wbl_no" },
               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pkup_no" },
               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_area_cd" },
               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_seq" },
               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_tp_id" },
               {Type:"Text",       Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_yrmondy" },
               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_tp_cd" },
               {Type:"Text",       Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"upd_flag" },
               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dest_loc_nm" },
               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dest_ste_nm" },
               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vgm_doc_id_no" },
               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vgm_wgt" },
               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vgm_edi_wgt_ut_cd" },
               {Type:"Text",       Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vgm_doc_tp_cd" },
               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vgm_dt_tp_cd" },
               {Type:"Text",       Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vgm_hndl_dt",           KeyField:0,   CalcLogic:"",   Format:"YmdHm"},
               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vgm_cust_cntc_tp_cd" },
               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vgm_cust_cntc_nm" },
               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vgm_cust_fax_no" },
               {Type:"Text",       Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vgm_cust_eml" },
               {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vgm_cust_phn_no" },
               {Type:"Text",       Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vgm_cust_addr" },
               {Type:"Text",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"wo_no" ,               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tir_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"edi_crr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trsp_doc_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"flt_file_ref_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",       Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id" }];
         
                InitColumns(cols);

              SetEditable(1);
              SetDataAutoTrim(1);
              //SetGetCountPosition(0);
              //SetColProperty("evnt_dt", {Format:"####-##-## ##:##"} );
              //SetColProperty("cre_locl_dt", {Format:"####-##-## ##:##"} );
              
              // upper case & numbers only
              SetColProperty(0,"cntr_no",{AcceptKeys:"N|E" , InputCaseSensitive:1} );
              SetColProperty(0,"bkg_no", {AcceptKeys:"N|E" , InputCaseSensitive:1});
              SetColProperty(0,"vvd_cd", {AcceptKeys:"N|E" , InputCaseSensitive:1});
              SetColProperty(0,"edi_mvmt_sts_cd", {AcceptKeys:"N|E" , InputCaseSensitive:1});
              SetColProperty(0,"cntr_full_sts_cd",{AcceptKeys:"N|E" , InputCaseSensitive:1});
              SetWaitTimeOut(36000);
//              SetSheetHeight(450);
              resizeSheet();
              break;
        }
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
                // calling code_get in coCtm.js
                var rtnValues=code_get("CNTR_TPSZ_CD", "'N' AND CNTR_TPSZ_CD  NOT IN ('Q2', 'Q4')", "DELT_FLG", "MDM_CNTR_TP_SZ");
                // creating cntr_tpsz_cd IBMulticombo (CoCtm.js)
                parseMultiCombo(comboObj, "^#^" + rtnValues, "ALL^#^" + rtnValues);
                document.form.tpszCombo_text.value = "ALL";
                if (frmObj.cntr_tpsz_cd.value != "") {
                    Text=frmObj.cntr_tpsz_cd.value;
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
                SetSelectIndex(0);
                break;

            case "mvmt_edi_msg_tp_id":    // ComboObject Value Settting
                SetDropHeight(160);
                InsertItem(0, "322", "322");
                InsertItem(1, "COD", "COD");
                InsertItem(2, "SPP", "SPP");
                InsertItem(3, "ALL", "ALL");
                Code=frmObj.mvmtEdiMsgTpId.value;
                SetSelectIndex(3);
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
                InsertItem(16, "ST|Status Change. Damage to Sound, Sound to Damage", "ST");
                if (frmObj.edi_gate_io_cd.value != "") {
                    Text=ComReplaceStr(frmObj.edi_gate_io_cd.value, "'", "");
                } else {
                    Text="ALL";
                }
                SetSelectIndex(0);
                break;
        }
    }
}

function setComboData(sheetObj) {
	with (sheetObj) {
		var cntrDmgFlg ="|Y|N";
		
		for(i=1; i<=RowCount(); i++) {
			var cntrDmgFlg=GetCellValue(i,"cntr_dmg_flg");
		}
		SetColProperty("cntr_dmg_flg", {ComboText:cntrDmgFlg, ComboCode:cntrDmgFlg});
	}
}


//handling process for Sheet
function doActionIBSheet(sheetObj, frmObj, sAction, CondParam, PageNo) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {

        case IBSEARCH:   
            if (validateForm(sheetObj, frmObj, sAction)) {
            	if (frmObj.mvmt_edi_rmk.value) {
                	if (ComGetUnMaskedValue(ComGetDateAdd(frmObj.p_date1.value, "D", 7), "ymd") < ComGetUnMaskedValue(frmObj.p_date2.value, "ymd")) {
                        ComShowCodeMessage("CTM30012", "1 week");
                        frmObj.p_date1.focus();
                        return;
                    }
                	if (frmObj.mvmt_edi_msg_area_cd.value == "") {
                		ComShowCodeMessage("CTM99999", "Please select Area except ALL");
                        frmObj.mvmt_edi_msg_area_cd.focus();
                        return;
                	}
                	if (frmObj.mvmt_edi_rslt_cd.value == "Y" || frmObj.mvmt_edi_rslt_cd.value == "ALL") {
                		ComShowCodeMessage("CTM99999", "Please select Result except ALL & OK");
                        frmObj.mvmt_edi_rslt_cd.focus();
                        return;
                	}
            	}
            	
            	if (frmObj.err_wt_ok.value) {
                	if (ComGetUnMaskedValue(ComGetDateAdd(frmObj.p_date1.value, "D", 7), "ymd") < ComGetUnMaskedValue(frmObj.p_date2.value, "ymd")) {
                        ComShowCodeMessage("CTM30012", "1 week");
                        frmObj.p_date1.focus();
                        return;
                    }
                	if (frmObj.mvmt_edi_msg_area_cd.value == "") {
                		ComShowCodeMessage("CTM99999", "Please select Area except ALL");
                        frmObj.mvmt_edi_msg_area_cd.focus();
                        return;
                	}
            	}
            	
            	if(frmObj.null_flg.checked==true){
            		frmObj.null_flg.value="Y";
            	}else{
            		frmObj.null_flg.value="";
            	}
            	
                sheetObjects[0].WaitImageVisible=false;
                ComOpenWait(true);
                frmObj.vvdcd_change.value="";
                appendPageNo=1;

                // creating option for query in case date gap between p_date1 & p_date2 is under 5 days
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
                frmObj.f_cmd.value=SEARCH;
                appendCondParam=FormQueryString(frmObj);

                // Do not use DoSearch4Fx !!(for sending evnt_dt, cre_locl_dt to GATENEW &  CTM-COMMON as String type )
                sheetObj.DoSearch("EES_CTM_0404GS.do", appendCondParam );
            }
            break;

        case IBSEARCHAPPEND:    
            if (validateForm(sheetObj, frmObj, sAction)) {
                sheetObjects[0].WaitImageVisible=false;
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                // Using DoSearch (for sending evnt_dt, cre_locl_dt to GATENEW &  CTM-COMMON as String type)
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
                sheetObjects[0].WaitImageVisible=false;
                ComOpenWait(true);
                // initializing global variables
                okCount=0;
                errorCount=0;
                ignoredCount=0;
                deletedCount=0;
                totalCount=0;
                errorXml="";
                saveXml=new Array();

                // Object Disable
                ComBtnDisable("btn_vvdchange");
                ComBtnDisable("btn_delete");
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
                    //RenderSheet(0);
                    // sheet[0] Sort
                    ColumnSort("cntr_no|evnt_dt", "ASC", "ASC|ASC", true);
                    var queryString="";
                    var startIdx=0;
                    var endIdx=0;
                    var checkIdxArr=(FindCheckedRow("Sel").substring(0, FindCheckedRow("Sel").length)).split("|");
                    var checkCount=checkIdxArr.length;
                    var loopCount=0;
                    // in case checked row count < sendRows * maxThreadCount
                    if (checkCount < (sendRows * maxThreadCount) + 1) {
                        loopCount=Math.ceil(checkCount / sendRows);
                    // in case checked row count < sendRows * maxThreadCount
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

                        // getting row data
                        var tempString="";
                        for (var h=startIdx; h<=endIdx; h++) {
                            tempString=("&mvmt_edi_rmk=" + GetCellValue(checkIdxArr[h], "mvmt_edi_rmk"));
                            queryString += (ComReplaceStr(RowSaveStr(checkIdxArr[h]), tempString, "") + "&");
                            tempString="";
                        }

                        // transmission
                        xmlHttpPost ("EES_CTM_0404GS.do", queryString + "AJAX=Y&f_cmd=" + MULTI, "rtnUpdateParses", checkIdxArr[startIdx]);
                        queryString="";

                        // because of multiple duplicated container no
                        // moving loop as the count of duplicate cases 
                        // in case endIdx-startIdx > sendRows
                        if ((endIdx-startIdx) > sendRows) {
                            i += (Math.ceil((endIdx-startIdx) / sendRows) - 1);
                        }
                        startIdx=endIdx + 1;

                        sendCount++;
                    }

                    // sheet[0] ReSort
                    ColumnSort("evnt_dt", "ASC", "ASC", true);
                    //RenderSheet(1);
                    SetHeaderCheck(0, "Sel",0);
                }
            }
            break;

        case SEARCH16:
            // retrieving server ID for login user
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
            
            frmObj.p_date1.value=ComGetEtcData(sheetObj.GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH26), "rtnValue");
            frmObj.p_date2.value=ComGetEtcData(sheetObj.GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH26), "rtnValue");
            
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
        deletedCount += Number(ComGetEtcData(rtnXml, "deleted_count"));
        totalCount += Number(ComGetEtcData(rtnXml, "total_count"));
        saveXml[sendCount]=rtnXml;
    }
    if (sendCount < 1) {
       var frmObj=document.form;
        // Object Enable
        ComBtnEnable("btn_vvdchange");
        ComBtnEnable("btn_delete");
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
        sheetObjects[0].SetWaitImageVisible(1);
        if (errorXml != "") {
            sheetObjects[0].LoadSaveData(errorXml);
        } else {
            ComOpenPopup("/opuscntr/EES_CTM_0432.do" +
                         "?ok_count=" + okCount +
                         "&error_count=" + errorCount +
                         "&ignored_count=" + ignoredCount +
                         "&deleted_count=" + deletedCount +
                         "&total_count=" + totalCount, 300, 280, "", "0,1", true);
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
            //RenderSheet(0);
            WaitImageVisible=false;
            ComOpenWait(true);
            // loading saveXml data to sheet[0]
            for (var i=0; i<=saveXml.length-1; i++) {
                LoadSearchData(saveXml[i],{Append:1 , Sync:0} );
            }
            // sheet[0] sort
            ColumnSort("evnt_dt", "ASC", "ASC", true);
            //RenderSheet(1);
            if (RowCount()> 0) {
                ComBtnEnable("btn_detail");
                ComBtnEnable("btn_vvdchange");
                ComBtnEnable("btn_delete");
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
        ComBtnDisable("btn_delete");
        // focus
        frmObj.p_date1.focus();
    }
}

/**
 * handling OnKeyUp event in HTML Object
 */
function obj_onkeyup(event) {
    srcValue = event.srcElement.value;  
    var frmObj = document.form;
    var sheetObj = sheetObjects[0];
    switch(event.srcElement.name) {
        case "cntrno_disp":
            frmObj.cntrno_disp.value = frmObj.cntrno_disp.value.toUpperCase();
            var cntrnoDisp = frmObj.cntrno_disp;
            if (cntrnoDisp.value.length > 1) {
                frmObj.p_cntrno.value = cntrnoDisp.value;
                if (cntrnoDisp.value.length > 9) {
                    // calling cntr_search in CTM common function in case p_cntrno is 11 characters
                    cntrno=frmObj.p_cntrno.value.toUpperCase();
                    var xml=sheetObj.GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH10 + "&p_cntrno=" + cntrno);
                    var rtnValue=ComGetEtcData(xml, "rtnValue");
                    if (rtnValue == null) {
//                        if (typeof(frmObj.check_digit) == "object") frmObj.check_digit.value="";
                        if (typeof(frmObj.ctnr_tpsz_cd) == "object") frmObj.ctnr_tpsz_cd.value="";
                        ComShowCodeMessage("CTM10004");
                        setFocusIndex(event.srcElement, 1);
                    } else {
//                        frmObj.check_digit.value="";
                        parseCTNRNo(rtnValue, frmObj);
                        setFocusIndex(event.srcElement, 1);
                    }
//                    if (!cntr_search()) {
//                        cntrnoDisp.select();
//                        cntrnoDisp.focus();
//                    } else {
//                        setFocusIndex(event.srcElement, 1);
//                    }
//                } else {
//                    frmObj.check_digit.value = "";
                }
            } else {
                frmObj.p_cntrno.value = "";
//                frmObj.check_digit.value = "";
            }
            break;

        case "yd_cd_disp":
            var ydCdDisp = frmObj.yd_cd_disp;
            if (ydCdDisp.value.length > 1) {
                frmObj.p_yard1.value = ydCdDisp.value;
                if (ydCdDisp.value.length > 4) {
                      // calling yard_search() in CTM common function in case p_yard1 is 5 characters
                    var p_yard=frmObj.p_yard1.value;
                    frmObj.f_cmd.value=SEARCH11;
                    var xml=sheetObj.GetSearchData("CTMCommonGS.do", FormQueryString(frmObj));
                    var rtnValue=ComGetEtcData(xml, "rtnValue");
                    svrChk=ComGetEtcData(xml, "svrChk");
                    if (p_yard2 == null || p_yard2 == 'null' || rtnValue == null) {
                    	p_yard2.RemoveAll();
                        ComShowCodeMessage("CTM10001");
                        p_yard2.focus();
                    } else {
                        parseYardMultiCombo(rtnValue, p_yard2);
                        p_yard2.focus();
                    }
//                      if (!yard_search()) {
//                            ydCdDisp.select();
//                            ydCdDisp.focus();
//                      } else {
//                            p_yard2.focus();
//                      }
                } else {
                    p_yard2.RemoveAll();
                }
            } else {
                frmObj.p_yard1.value = "";
                p_yard2.RemoveAll();
            }
            break;

        case "vvdcd_change":
//        	if (frmObj.vvdsts_change_combo.value == "VVD") {
//	            var vvdCd = frmObj.vvdcd_change;
//	            if (vvdCd.value.length > 8) {
//	                var xml = sheetObj.GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH12 + "&vvdcode=" + vvdCd.value);
//	                var rtnValue = ComGetEtcData(xml, "rtnValue");
//	                if (rtnValue) {
//	                    if (sheetObj.CheckedRows("Sel") < 1) return;
//	                    if (sheetObj.RowCount < 1) return;
//	                } else {
//	                    sheetObj.LoadSearchData(xml);
//	                    vvdCd.select();
//	                    vvdCd.focus();
//	                }
//	            }
//	            break;
//        	} else {
        		break; 
//        	}

        case "lcc_cd":
        case "rcc_cd":
            var loc_cd = event.srcElement;
            // calling code_search() in CTM common function in case 5 characters entered in lcc_cd or rcc_cd 
            if (loc_cd.value.length > 4) {
                // focusing on current element in case result is false means no value in Table
                if (!code_search(loc_cd.value, "LOC_CD", "MDM_LOCATION")) {
                    event.srcElement.select();
                    event.srcElement.focus();
                //  focusing on next element
                } else {
                    setFocusIndex(loc_cd, 1);
                }
            }
          break;
    }
    onShowErrMsg = false;    
}

/**
 * handling OnChange event in HTML Object
 */
function obj_onchange(event) {
    var frmObj=document.form;
    switch(ComGetEvent("name")) {
        case "vvdsts_change_combo":
            var vvdStsCombo=frmObj.vvdsts_change_combo;
            frmObj.vvdcd_change.style.width="120px";
            
            if (vvdStsCombo.value == "STATUS") {
                frmObj.stscd_change.style.display="inline";
                frmObj.vvdcd_change.style.display="none";
                frmObj.vvdcd_change.value="";
                frmObj.stscd_change.focus();
            } else {
                frmObj.vvdcd_change.style.display="inline";
                frmObj.stscd_change.style.display="none";
                frmObj.stscd_change.selectedIndex=0;
                frmObj.vvdcd_change.value="";
                if (vvdStsCombo.value == "CNTR") {
                	frmObj.vvdcd_change.maxLength = 11;
                } else if (vvdStsCombo.value == "YARD") {
                	frmObj.vvdcd_change.maxLength = 7;
                } else if (vvdStsCombo.value == "BKG") {
                	frmObj.vvdcd_change.maxLength = 13;
                } else if (vvdStsCombo.value == "VVD") {
                	var vvdCd = frmObj.vvdcd_change;
    	            if (vvdCd.value.length > 8) {
    	                var xml = sheetObj.GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH12 + "&vvdcode=" + vvdCd.value);
    	                var rtnValue = ComGetEtcData(xml, "rtnValue");
    	                if (rtnValue) {
    	                    if (sheetObj.CheckedRows("Sel") < 1) return;
    	                    if (sheetObj.RowCount < 1) return;
    	                } else {
    	                    sheetObj.LoadSearchData(xml);
    	                    vvdCd.select();
    	                    vvdCd.focus();
    	                }
    	            }
    	            break;
                	frmObj.vvdcd_change.maxLength = 9;
                } else if (vvdStsCombo.value == "FM") {
                	frmObj.vvdcd_change.maxLength = 2;
                	
                }else if (vvdStsCombo.value == "REMARK") {
                	frmObj.vvdcd_change.maxLength = 200;
                	frmObj.vvdcd_change.style.width="250px";
                }
                
                frmObj.vvdcd_change.focus();
            }
            break;
        case "mvmt_edi_rslt_cd":
            var rsltCd=frmObj.mvmt_edi_rslt_cd;

            if (rsltCd.value == "N") {
            	frmObj.err_wt_ok.disabled = false;
            } else {
            	frmObj.err_wt_ok.disabled = true;
            	frmObj.err_wt_ok.value = "";
            }
            break;
    }
    onShowErrMsg=false;
}

/**
 * handling MultiSelection OnCheckClick event in tpszCombo
 */
function tpszCombo_OnCheckClick(comboObj, index, code) {
    // coCtm??multiComboOnCheckClick ??출
	multiComboOnCheckClick(comboObj, index, document.form.cntr_tpsz_cd);
	if(code == "") {
		document.form.tpszCombo_text.value = "ALL";
	}
}
//tpszCombo
function tpszCombo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	if (document.form.tpszCombo_text.value != "ALL") {
	    document.form.tpszCombo_text.value = newCode;
	}
}

function tpszCombo_OnBlur(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	if (tpszCombo.GetSelectCode()) {
	    document.form.tpszCombo_text.value = tpszCombo.GetSelectCode();
	}
}
/**
 * handling MultiSelection OnCheckClick event in    
 */
function statusCombo_OnCheckClick(comboObj, index, code) {
    // CoCtm.js multiComboOnCheckClick
    multiComboOnCheckClick(comboObj, index, document.form.edi_mvmt_sts_cd);
}

function vvd_combo_onchange() {
    form.vvd_value.value = "";
}

/**
 * mvmt_edi_msg_tp_id??MultiSelection OnChange ??벤??처리
 */
function mvmt_edi_msg_tp_id_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    var mvmtEdiRsltCd=document.form.mvmt_edi_rslt_cd;
    if (oldIndex == "SPP") {
        mvmtEdiRsltCd.value="Y";
        ComEnableObject(mvmtEdiRsltCd, false);
    } else {
        mvmtEdiRsltCd.value="N";
        ComEnableObject(mvmtEdiRsltCd, true);
    }
}

/**
 * handling MultiSelection OnCheckClick event in ioStatusCombo
 */
function ioStatusCombo_OnCheckClick(comboObj, index, code) {
    // coCtm??multiComboOnCheckClick ??출
    multiComboOnCheckClick(comboObj, index, document.form.edi_gate_io_cd);
}

/**
 * handling OnSearchEnd event in Sheet1
 */
function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg) {
    ComOpenWait(false);
    if (ErrMsg == "") {
        var frmObj=document.form;
        with(sheetObj) {
            frmObj.disp_total.value=ComAddComma(RowCount());

            // in case of not first retrieving 
            if (appendPageNo < 2) {
                frmObj.rtv_total.value=ComAddComma(GetEtcData("rtv_total"));
                // showing GRAND TOTAL in case mvmt_edi_rslt_cd for retrieving option is not 'X'
                if (GetEtcData("mvmt_edi_rslt_cd") == "X") {
                    frmObj.gnd_total.value="";
                } else {
                    frmObj.gnd_total.value=ComAddComma(GetEtcData("gnd_total"));
                }
                if (RowCount()> 0) {
                    ComBtnEnable("btn_detail");
                    ComBtnEnable("btn_vvdchange");
                    ComBtnEnable("btn_delete");
                } else {
                    ComBtnDisable("btn_detail");
                    ComBtnDisable("btn_vvdchange");
                    ComBtnEnable("btn_delete");
                }
            }

            // TEST
//            SetCellValue(2, "mvmt_edi_rslt_cd", "Y");
//            SetCellValue(3, "mvmt_edi_rslt_cd", "Y");
//            SetCellValue(4, "mvmt_edi_rslt_cd", "X");
//            SetCellValue(5, "mvmt_edi_rslt_cd", "D");
//            SetCellValue(6, "mvmt_edi_rslt_cd", "D");
            
            // changing row edit status according to EDI Result
            row_Editable(sheetObj, appendPageNo, frmObj.pagerows.value);
            if (RowCount()< ComGetUnMaskedValue(frmObj.rtv_total.value, "int")) {

                // setting page number for APPEND retrieving
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
    sheetObjects[0].SetWaitImageVisible(1);
}

function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
    if(Code == 0){
        ComShowCodeMessage("COM132601");
    }
}

function sheet1_OnDownFinish(sheetObj, downloadType, result) {
    ComOpenWait(false);
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
                         "?mvmt_edi_msg_area_cd=" + GetCellValue(Row, "mvmt_edi_msg_area_cd") +
                         "&mvmt_edi_msg_seq=" + GetCellValue(Row, "mvmt_edi_msg_seq") +
                         "&mvmt_edi_msg_tp_id=" + GetCellValue(Row, "mvmt_edi_msg_tp_id") +
                         "&mvmt_edi_msg_yrmondy=" + GetCellValue(Row, "mvmt_edi_msg_yrmondy") +
                         "&mvmt_edi_tp_cd=" + GetCellValue(Row, "mvmt_edi_tp_cd"), 920, 485, "", "0,1");
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
        // checking changed row's CheckBox 
        if (ColSaveName(Col) != "Sel") {
            SetCellValue(Row, "Sel","1",0);
        }
        // copying RowStatus value to updateflag in case of changing in cnmv_rmk
        if (ColSaveName(Col) == "cnmv_rmk") {
        	//alert("upd_flag<<" + GetCellValue(Row, "upd_flag") + ">>");
            SetRowStatus(Row,(GetCellValue(Row, "upd_flag") == "" ? "I" : GetCellValue(Row, "upd_flag")));
        } else {
        	//alert("GetRowStatus<<" + GetRowStatus(Row) + ">>");
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
                	var xml=GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH19 + "&code_value=" + Value + "&column_nm=" + "DMST_BKG_NO" + "&table_nm=" + "DOM_BOOKING");
                    var rtnValue=ComGetEtcData(xml, "rtnValue");
                    if (rtnValue != "" && rtnValue == "1") {
	                	sheetValidation=true;
                    } else {
                    	if(GetCellValue(Row, "bkg_no").length==10){
                            if (Value != "" && !code_search(Value, "BKG_NO", "CTM_BOOKING")) {
                                sheetValidation=false;
                                SelectCell(Row, Col, true, CellSearchValue(Row, Col));
                            } else {
                                sheetValidation=true;
                            }
	                	}else{
	                        if (Value != "" && !code_search(Value, "BKG_NO", "BKG_BOOKING")) {
		                            sheetValidation=false;
		                            SelectCell(Row, Col, true, CellSearchValue(Row, Col));
	                        } else {
	                            sheetValidation=true;
	                        }
	                	}
                    }

                    break;

                case "vvd_cd":
                	if (Value != "" ) {
                		if(GetCellValue(Row, "vvd_cd").length==7){
//                			if(confirm("Is this OSCAR VVD?")){
                				document.form.org_vvd_cd.value = GetCellValue(Row, "vvd_cd");
                			    var strQuery="f_cmd=" + SEARCH06 + "&p_vvd=" + GetCellValue(Row, "vvd_cd");
                			    var returnXml=sheetObj.GetSearchData("EES_CTM_0406GS.do", strQuery);
                			    var rtnValue=ComGetEtcData(returnXml, "rtnStr");
                			    
                			    if(rtnValue!=null && rtnValue!="" && rtnValue.length==9){
                			    	alert(document.form.org_vvd_cd.value+" ==> " + rtnValue + "   VVD is changed." )
                			    	SetCellValue(Row, "vvd_cd",  rtnValue.trim());
                			    	 
                			    }else{
                			    	ComShowCodeMessage("CTM20073"); // VVD Code is Not Exists
                			    	SetCellValue(Row, "vvd_cd","");
                			    	return false;
                			    }

//                			}else{
//        	                    var xml=GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH23 + "&vvdcode=" + Value);
//        	                    var rtnValue=ComGetEtcData(xml, "rtnValue");
//        	                    if (!rtnValue) {
//        	                        //LoadSearchData(xml,{Sync:0} );
//        	                        showErrMessage(ComGetSelectSingleNode(xml, "MESSAGE"));
//        	                        sheetValidation=false;
//        	                        SetCellValue(Row, "vvd_cd","");
//                                    SelectCell(Row, Col, true, CellSearchValue(Row, Col));
//        	                    } else {
//        	                        sheetValidation=true;
//        	                        SetCellValue(Row, "crnt_vsl_cd",Value.substring(0, 4),0);
//        	                        SetCellValue(Row, "crnt_skd_voy_no",Value.substring(4, 8),0);
//        	                        SetCellValue(Row, "crnt_skd_dir_cd",Value.substring(8, 9),0);
//        	                    }
//                				
//                			}
                			
                		}else{
        	                    var xml=GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH23 + "&vvdcode=" + Value);
        	                    rtnValue=ComGetEtcData(xml, "rtnValue");
        	                    if (!rtnValue) {
        	                        //LoadSearchData(xml,{Sync:0} );
        	                        showErrMessage(ComGetSelectSingleNode(xml, "MESSAGE"));
        	                        sheetValidation=false;
        	                        SetCellValue(Row, "vvd_cd","");
                                    SelectCell(Row, Col, true, CellSearchValue(Row, Col));
        	                    } else {
        	                        sheetValidation=true;
        	                        SetCellValue(Row, "crnt_vsl_cd",Value.substring(0, 4),0);
        	                        SetCellValue(Row, "crnt_skd_voy_no",Value.substring(4, 8),0);
        	                        SetCellValue(Row, "crnt_skd_dir_cd",Value.substring(8, 9),0);
        	                    }
                				
                		}
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

/**
 * changing row edit status according to EDI Result, Movement Status Cd
 */
function row_Editable(sheetObj, PageNo, OnePageRows) {
var startRowNo=OnePageRows* (PageNo - 1) + 1;
var endRowNo=OnePageRows* PageNo;
    with (sheetObj) {
        //RenderSheet(0);
        for (var i=startRowNo; i<=endRowNo; i++) {
            if (GetCellValue(i, "mvmt_edi_rslt_cd") == "Y" || GetCellValue(i, "mvmt_edi_sght_cd") == "X" || GetCellValue(i, "mvmt_edi_rslt_cd") == "D") {
                SetRowEditable(i, false);
            } else {
                if (GetCellValue(i, "edi_mvmt_sts_cd") != "VL" && GetCellValue(i, "edi_mvmt_sts_cd") != "VD") {
                    SetCellEditable(i, "vvd_cd", false);
                }
            }
            
            if (GetCellValue(i, "mvmt_edi_rslt_cd") == "Y") {
            	SetCellValue(i, "mvmt_edi_rslt_cd", "OK", 0);
            } else if (GetCellValue(i, "mvmt_edi_rslt_cd") == "N") {
            	SetCellValue(i, "mvmt_edi_rslt_cd", "Error", 0);
            } else if (GetCellValue(i, "mvmt_edi_rslt_cd") == "D") {
            	SetCellValue(i, "mvmt_edi_rslt_cd", "Deleted", 0);
            } else {
            	SetCellValue(i, "mvmt_edi_rslt_cd", "Ignored", 0);
            }
            SetRowStatus(i, "");
        }
        //RenderSheet(1);
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

function resizeSheet(){
    for (i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i], 75);
    }
}
