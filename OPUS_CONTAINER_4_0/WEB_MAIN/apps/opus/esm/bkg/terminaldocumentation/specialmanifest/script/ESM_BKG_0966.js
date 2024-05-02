﻿﻿/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0966.js
*@FileTitle  : DG Declare EDI Transmit
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_BKG_0966 : business script for ESM_BKG_0966.
 */
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var nextSearchIdx=0;
document.onclick=processButtonClick;

function processButtonClick() {
    var sheetObject1= sheetObjects[0];
    var sheetObject2= sheetObjects[1];
    var formObject=document.form;
    try {
        var obj = event.target || event.srcElement;
           if ($(obj).prop('disabled')) {
         return;
         }
        var srcName= ComGetEvent("name");
        switch (srcName) {
        case "btn_Retrieve":
            doActionIBSheet(sheetObject1, formObject, SEARCH02);
            break;
        case "btn2_RowAdd":
            if (!ComChkValid(formObject)) return;
            var row=sheetObject2.DataInsert(-1);
            setSearchCond(sheetObject2, formObject);
            sheetObject2.SelectCell(row, "cgo_opr_cd");
            break;
        case "btn2_Delete":
            if (sheetObject2.GetRowStatus(sheetObject2.GetSelectRow()) != "I") {
                sheetObject2.SetRowStatus(sheetObject2.GetSelectRow(),"D");
                sheetObject2.SetRowEditable(sheetObject2.GetSelectRow(), 0);
                sheetObject2.SetRowBackColor(sheetObject2.GetSelectRow(),"#C0C0C0");
//                if (formObject.dg_list_local_yn.value == "N") {
//                    sheetObject2.SetRowHidden(sheetObject2.GetSelectRow(), 1);
//                } else {
//                    sheetObject2.SetSelectRow(sheetObject2.GetSelectRow() + 1);
//                }
            } else {
                sheetObject2.SetRowStatus(sheetObject2.GetSelectRow(),"D");
            }
//            sheetObject2.SetRowHidden(sheetObject2.GetSelectRow(), 1);
            break;
        case "btn1_BayPlan":
            // Bay plan setup 화면만 띄우고 아무것도 안함
            openBayPlanPop(formObject, "2", false);
            break;
        case "btn1_New":
            ComResetAll();
            formObject.ack_rcv_sts_cd_name.style.backgroundColor="white";
            break;
        case "btn1_Save":
            doActionIBSheet(sheetObject2, formObject, IBSAVE);
            break;
        case "btn1_Append_Retrieve":
            doActionIBSheet(sheetObject1, formObject, SEARCH14);
            break;
        case "btn1_Close_SCG":
        case "btn1_Open_SCG":
            doActionIBSheet(sheetObject1, formObject, MODIFY);
            break;
        case "btn1_EDITransmit":
            doActionIBSheet(sheetObject2, formObject, MULTI01);
            break;
        case "btn1_EDICancel":
            doActionIBSheet(sheetObject2, formObject, MULTI02);
            break;
        case "btn1_SentResult":
            sheet2_OnDblClick(sheetObject2,sheetObject2.GetSelectRow(), 6);
            break;
        case "btn1_DownExcel":
             if(sheetObjects[1].RowCount() < 1){
                ComShowCodeMessage("COM132501");
            }else{
                ComOpenWait(true);
                sheetObjects[1].Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
                ComOpenWait(false);
            }
            break;
        case "btn1_Filter" :
            doActionIBSheet(sheetObject2, formObject, COMMAND01);
            break;
        case "filter_bl_no" :
            visibleFalse("1");
            break;
        case "filter_cntr_no" :
            visibleFalse("2");
            break;
        case "filter_dg_ref_no" :
            visibleFalse("3");
            break;
        case "btn2_history":
            var row=sheetObjects[1].GetSelectRow();
            if (row < 1) return;
            if (sheetObjects[1].GetRowStatus(row) == "I") return;
            var url= "ESM_BKG_1605.do?pgmNo=ESM_BKG_1605"
                    +"&dType="+getRadioValue(formObject.d_type)
                    +"&vvdCd="+formObject.vvd_cd.value
                    +"&portCd="+formObject.port_cd.value
                    +"&blNo="+sheetObjects[1].GetCellValue(row, "bl_no")
                    +"&cntrNo="+sheetObjects[1].GetCellValue(row, "cntr_no")
                    +"&polCd="+sheetObjects[1].GetCellValue(row, "pol_cd")
                    +"&podCd="+sheetObjects[1].GetCellValue(row, "pod_cd")
                    +"&originPgm=ESM_BKG_0966";
            ComOpenWindowCenter(url, "ESM_BKG_1605", 1120, 600, true);
            break;
        case "btn1_Substitute":
            var row=sheetObjects[1].GetSelectRow();
//            if (row < 1) return;
            ComOpenPopup("ESM_BKG_0978.do", 500, 600, "callBack0978", "none", false);
            break;
        }
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }
}

/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * register combo Object to comboObjects array
 *
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
    comboObjects[comboCnt++]=combo_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage(dType, ofcCd) {
    var formObj= document.form;
    for (i=0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    if (dType == "D" || dType == "") {
        formObj.d_type[0].checked= true;
    } else if (dType == "T") {
        formObj.d_type[1].checked= true;
    } else if (dType == "L") {
        formObj.d_type[2].checked= true;
    }
    var comboObjMaxLen=comboObjects.length;
    for (i=0; i < comboObjMaxLen; i++) {
        initCombo(comboObjects[i], i + 1);
    }
    ComSetDisplay("btn1_Close_SCG", true);
    ComSetDisplay("btn1_Open_SCG", false);
    ComBtnDisable("btn1_EDITransmit");
    ComBtnDisable("btn1_EDICancel");
    ComBtnDisable("btn1_Append_Retrieve");
    ComBtnDisable("btn1_Close_SCG");
//    ComBtnDisable("btn2_Delete");

    axon_event.addListenerForm('keydown', 'obj_enter', document.form);
    axon_event.addListenerForm('change',  'obj_change', document.form);

    if(ofcCd != "RTMBB") {
        comboObjects[0].SetEnable(0);
        formObj.frm_svc_rqst_no.readOnly= true;
        formObj.frm_svc_rqst_no.style.backgroundColor= "#E8E7EC";
        formObj.frm_svc_rqst_no.value= "";
//    } else if(ofcCd != "FXTBO") {
//        formObj.frm_svc_rqst_no.readOnly= true;
//        formObj.frm_svc_rqst_no.style.backgroundColor= "#E8E7EC";
//        formObj.frm_svc_rqst_no.value= "";
//    }
//    if(ofcCd == "LEHBB") {
//        formObj.frm_brth_yd_cd.readOnly=true;
//        formObj.frm_brth_yd_cd.style.backgroundColor="#E8E7EC";
//        formObj.frm_brth_yd_cd.value="";
//        formObj.frm_yd_nm.readOnly=true;
//        formObj.frm_yd_nm.style.backgroundColor="#E8E7EC";
//        formObj.frm_yd_nm.value="";
    }
}

/**
 * initalizeCombo Object
 *
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comNo) {
    var i=0;
    switch (comboObj.options.id) {
        case "rtm_call_no": {   // Number of Calling (For RTM)
            i=0;
            with (comboObj) {
                InsertItem(i++, "", "0");
                InsertItem(i++, "1", "1");
                InsertItem(i++, "2", "2");
                Code="0";
            }
            break;
        }
    } // end switch
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    var sheetId= sheetObj.id;
    var formObj= document.form;
    switch (sheetId) {
    case "sheet1": // top master info
        with(sheetObj){
              var HeadTitle1="|d_type|vvd_cd|port_cd|eta_d|eta_t|etd_d|etd_t|yd_cd|loc_nm|auto_snd_tp_cd|vsl_cd|vsl_nm|vsl_cnt_cd|lloyd_no|call_sgn_no|rtm_call_no|ssr_no|ack_rslt_id|local_db_yn";
              var headCount= ComCountHeadTitle(HeadTitle1);
              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);
              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"d_type",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"port_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eta_d",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eta_t",           KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"etd_d",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"etd_t",           KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"brth_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"yd_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"auto_snd_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vsl_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vsl_eng_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vsl_cnt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"lloyd_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"call_sgn_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"rtm_call_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"svc_rqst_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"ack_rslt_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"local_db_yn",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"spcl_cgo_prnr_clz_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
                    
              InitColumns(cols);
              SetEditable(1);
              InitViewFormat(0, "eta_d", "yyyymmdd");
              InitViewFormat(0, "eta_t", "hhmm");
              InitViewFormat(0, "etd_d", "yyyymmdd");
              InitViewFormat(0, "etd_t", "hhmm");
              SetSheetHeight(100);
        }
    break;
 
    case "sheet2":
        with(sheetObj){
              var HeadTitle1="|merge_bl_no|bkg_no|Seq.|Setup\nFlag|B/L No.|POL|POD|DG Ref. No.|Cargo\nOper.|Container No.|TP/SZ|DG\nInquiry|Cell Position" +
              "|Class|Compati\n-bility|Emergency Tel.|PIC|UN No.|Flash\nPoint/℃|Package\nGroup|Marine\nPollutant|Limited\nquantity|EMS|Net Weight|Gross Weight" +
              "|Net Exp Weight|Outer\nPackage Qty|Outer Code|Packages|Substance|Technical Name|Send Type|Msg Snd No|First Msg Snd No" +
              "|cntr_cgo_seq|in_imdg_pck_qty1|in_imdg_pck_cd1|in_pck_desc|out_pck_desc|cntr_cnt|imdg_un_no_seq|cntr_no_old|cntr_ref_no|mfag_no|diff_rmk|hcdg_flg|emer_rspn_gid_no|xtd_stay_prmt_no|imdg_subs_rsk_lbl_cd1|imdg_subs_rsk_lbl_cd2|imdg_subs_rsk_lbl_cd3|imdg_subs_rsk_lbl_cd4|dup_cntr|dup_cell|spcl_cgo_seq|spcl_cntr_seq|cell_chk|||";
              var headCount=ComCountHeadTitle(HeadTitle1);
              SetConfig ({ SearchMode:2, FrozenCol:10, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 });
              var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);
              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"merge_bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:12 },
                     {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"stup_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:12, AcceptKeys:"E|N",   InputCaseSensitive:1},
                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5,  AcceptKeys:"E|N",   InputCaseSensitive:1},
                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5,  AcceptKeys:"E|N",   InputCaseSensitive:1},
                     {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"dcgo_ref_no",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"cgo_opr_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3,  AcceptKeys:"E",     InputCaseSensitive:1},
                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14, AcceptKeys:"E|N|[- ]",   InputCaseSensitive:1},
                     {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2,  AcceptKeys:"E|N",   InputCaseSensitive:1},
                     {Type:"Popup",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cell_psn_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
                     
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"imdg_clss_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3,  AcceptKeys:"N|[.]"},
                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"imdg_comp_grp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"emer_cntc_phn_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"emer_cntc_pson_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   InputCaseSensitive:1 },
                     {Type:"Popup",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
                     {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"flsh_pnt_cdo_temp",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   AcceptKeys:"N|[.]|[-]" },
                     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"imdg_pck_grp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eur_dcgo_mrn_polut_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"imdg_lmt_qty_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ems_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"net_wgt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 ,AcceptKeys:"N|[.]"},
                     {Type:"Text",      Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"grs_wgt",            KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 ,AcceptKeys:"N|[.]"},
                     
                     {Type:"Text",      Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"net_explo_wgt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,AcceptKeys:"N|[.]"},
                     {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"out_imdg_pck_qty1",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   AcceptKeys:"N" },
                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"out_imdg_pck_cd1",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   AcceptKeys:"E|N",   InputCaseSensitive:1},
                     {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"eur_outr_pck_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"prp_shp_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"hzd_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"send_type",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:170,  Align:"Center",  ColMerge:0,   SaveName:"msg_snd_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"first_msg_snd_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:80, SaveName:"cntr_cgo_seq"},
                     {Type:"Text",      Hidden:1, Width:80, SaveName:"in_imdg_pck_qty1"},
                     {Type:"Text",      Hidden:1, Width:80, SaveName:"in_imdg_pck_cd1"},
                     {Type:"Text",      Hidden:1, Width:80, SaveName:"eur_inr_pck_desc"},
                     {Type:"Text",      Hidden:1, Width:80, SaveName:"cntr_cnt"},
                     {Type:"Text",      Hidden:1, Width:80, SaveName:"imdg_un_no_seq"},
                     {Type:"Text",      Hidden:1, Width:80, SaveName:"cntr_no_old"},
                     {Type:"Text",      Hidden:1, Width:80, SaveName:"cntr_ref_no"},
                     {Type:"Text",      Hidden:1, Width:90, SaveName:"mfag_no"},
                     {Type:"Text",      Hidden:1, Width:90, SaveName:"diff_rmk"},
                     {Type:"Text",      Hidden:1, Width:90, SaveName:"hcdg_flg"},
                     {Type:"Text",      Hidden:1, Width:90, SaveName:"emer_rspn_gid_no"},
                     {Type:"Text",      Hidden:1, Width:90, SaveName:"xtd_stay_prmt_no"},
                     {Type:"Text",      Hidden:1, Width:80, SaveName:"imdg_subs_rsk_lbl_cd1"},
                     {Type:"Text",      Hidden:1, Width:80, SaveName:"imdg_subs_rsk_lbl_cd2"},
                     {Type:"Text",      Hidden:1, Width:80, SaveName:"imdg_subs_rsk_lbl_cd3"},
                     {Type:"Text",      Hidden:1, Width:80, SaveName:"imdg_subs_rsk_lbl_cd4"},
					 {Type:"Text",      Hidden:1, Width:80, SaveName:"dup_cntr"},
					 {Type:"Text",      Hidden:1, Width:80, SaveName:"dup_cell"},
					 {Type:"Text",      Hidden:1, Width:80, SaveName:"spcl_cgo_seq"},
					 {Type:"Text",      Hidden:1, Width:80, SaveName:"spcl_cntr_seq"},
					 {Type:"Text",      Hidden:1, Width:80, SaveName:"cell_chk"}];

              InitColumns(cols);
              SetEditable(1);
              SetWaitImageVisible(0);
              SetEllipsis(1);
              SetShowButtonImage(1);
              SetColProperty("imdg_pck_grp_cd", {ComboText:"|Ⅰ|Ⅱ|Ⅲ|N", ComboCode:"|1|2|3|N"} );
              SetColProperty("imdg_lmt_qty_flg", {ComboText:"|Y|N", ComboCode:"|Y|N"} );
              FrozenCols=8;
              SetSelectionMode(smSelectionList);
              ComResizeSheet(sheetObj);
              var height = GetSheetHeight();
              SetSheetHeight(height - 40);
              SetCountPosition(0);

              if (cntCd == "GB") {
                  SetColProperty("eur_dcgo_mrn_polut_cd", {ComboText:"N|Y|P|PP", ComboCode:"N|Y|P|PP"} );
              } else {
                  var cntCd=formObj.cnt_cd.value;
                  SetColProperty("eur_dcgo_mrn_polut_cd", {ComboText:"|Y|N", ComboCode:"|Y|N"} );
              }
            }
        break;
    }
}
/**
 * handling sheet process
 *
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction, row, col) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {

    case SEARCH02: // Retrieve Button
        if(!validateForm(sheetObj,formObj,sAction))return;
        formObj.f_cmd.value=SEARCH02;
		if(formObj.auto_update.checked) {
			formObj.auto_update.value="Y";
		}else{
			formObj.auto_update.value="N";
		}
        formObj.search_d_type.value = getRadioValue(formObj.d_type);
        ComOpenWait(true);
        setTimeout( function () {
            nextSearchIdx = 0;
            var sXml= sheetObjects[0].GetSearchData("ESM_BKG_0965GS.do", FormQueryString(formObj));
            var arrXml=sXml.split("|$$|");
            formObj.cntr_cnt.value=""; // initalize Total Container field
            formObj.dg_list_local_yn.value= ComGetEtcData(arrXml[0], "dgListLocalYn");
            var sentStatus= ComGetEtcData(arrXml[0], "ediSentStatus");
            
            if (ComBkgErrMessage(sheetObj, sXml)) {
                sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
                sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
            }
            setSentStatusFiledColor(sentStatus);
            setSearchCond(sheetObjects[1], formObj);

            ComOpenWait(false);
        } , 100);
        break;
        
    case IBSAVE: // Save Button
    	if(!validateForm(sheetObj,formObj,sAction))return;
    	var rowCnt=sheetObjects[1].RowCount();
        if(!ComShowCodeConfirm("BKG00350")) return; // "Do you want to save your change(s)?"
//        var dgListLocalYn = ComGetEtcData(arrXml[0], "dgListLocalYn");
        
        if (formObj.dg_list_local_yn.value == "N") { // 데이터 있는지 없는지 여부
        	for(var i=1; i<=rowCnt; i++) {
            	if( sheetObjects[1].GetCellValue(i,"ibflag") != "D" ){
            		sheetObjects[1].SetRowStatus(i, "I");
            	}
            }

            sheetObjects[0].SetRowStatus(1, "I");
        }

        	
        formObj.f_cmd.value=MULTI;
        
        var sParam="";
        var sParamSheet1=sheetObjects[0].GetSaveString();
        if (sParamSheet1 != "") {
            sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
        }
        var sParamSheet2=sheetObjects[1].GetSaveString({"AllSave":1}); // 전체 저장
        if (sParamSheet2 != "") {
            sParam += "&" + ComSetPrifix(sParamSheet2, "sheet2_");
        }
        
        sParam += "&" + FormQueryString(formObj);
        ComOpenWait(true);
        
        setTimeout( function () {
            var sXml=sheetObjects[1].GetSaveData("ESM_BKG_0965GS.do", sParam);
            sheetObjects[1].LoadSaveData(sXml);
            ComOpenWait(false);
        } , 100);
        break;

    case MULTI01: // EDI Transmit Button
        if(!validateForm(sheetObj,formObj,sAction))return;
        if(!ComShowCodeConfirm("BKG95003", "Transmit")) return; // "Do you want to {?msg1}?"
        
        ComOpenWait(true);

        var rowCnt=sheetObjects[1].RowCount();
        for(var i=1; i<=rowCnt; i++) {
            if (!sheetObjects[1].GetRowHidden(i)) {
                if (sheetObjects[1].GetCellValue(i, "stup_flg") == "V" || (sheetObjects[1].GetCellValue(i, "stup_flg") == "C" && sheetObjects[1].GetCellValue(i, "cgo_opr_cd") == "NYK")) {
                    sheetObjects[1].SetRowStatus(i,"I");
                } else {
                	ComShowCodeMessage("COM12114","setup-flag."); //  'Please check {?msg1}';
                	ComOpenWait(false);
                	return false;
                }
                if (formObj.send_type_check_orgin.checked) {
                    sheetObj.SetCellValue(i, "send_type", "", 0);
                }
            }
        }
        formObj.send_type_check_orgin.checked=false;
        formObj.f_cmd.value=MULTI01;
        formObj.trans_type.value="ORIGIN_SEND";
        
        var sParam="";
        var sParamSheet=sheetObjects[1].GetSaveString();
        if (sParamSheet != "") {
            sParam += "&" + sParamSheet;
        }
        sParam += "&" + FormQueryString(formObj);
        sheetObjects[1].DoSave("ESM_BKG_0965GS.do", {Param : sParam, Quest:0, Sync:1, Mode : 2});
        
        break;

    case MULTI02: // EDI Cancel Button
        if(!validateForm(sheetObj,formObj,sAction)) return;

        if(!ComShowConfirm(ComGetMsg("BKG95003", "[EDI Cancel Transmit]"))) return; // "Do you want to {?msg1}?"
        
        ComOpenWait(true);
        
        var rowCnt=sheetObjects[1].RowCount();
        for(var i=1; i<=rowCnt; i++) {
            if (!sheetObjects[1].GetRowHidden(i)) {
                if (sheetObjects[1].GetCellValue(i, "stup_flg") == "V" || (sheetObjects[1].GetCellValue(i, "stup_flg") == "C" && sheetObjects[1].GetCellValue(i, "cgo_opr_cd") == "NYK")) {
                    sheetObjects[1].SetRowStatus(i,"I");
                }
            }
        }
        formObj.f_cmd.value=MULTI01;
        formObj.trans_type.value="CANCEL_SEND";
        var sParam="";
        var sParamSheet=sheetObjects[1].GetSaveString();
        if (sParamSheet != "") {
            sParam += "&" + sParamSheet;
        }
        sParam += "&" + FormQueryString(formObj);
        sheetObjects[1].DoSave("ESM_BKG_0965GS.do", {Param : sParam, Quest:0, Sync:1, Mode : 2});
        break;
        
    case COMMAND01 :
        
        var row = 1;
        if (formObj.filter_bl_no.value != "") {
            row = sheetObj.FindText("bl_no", formObj.filter_bl_no.value, nextSearchIdx, 2, false);
        } else if (formObj.filter_cntr_no.value != "") {
            row = sheetObj.FindText("cntr_no", formObj.filter_cntr_no.value, nextSearchIdx, 2, false);
        } else if (formObj.filter_dg_ref_no.value != "") {
        	row = sheetObj.FindText("dcgo_ref_no", formObj.filter_dg_ref_no.value, nextSearchIdx, 2, false);
        }
        if (row < 1) {
            ComShowCodeMessage("BKG00395");
            nextSearchIdx = 0;
            return;
        } else {
            nextSearchIdx= row + 1;
        }
        sheetObj.SetSelectRow(row);
        break;
        
    case SEARCH11 : //  validation (bl_no / pol_cd / pod_cd) in case input
        formObj.f_cmd.value=SEARCH11;
        ComOpenWait(true);
        
        var sXml=sheetObjects[1].GetSearchData("ESM_BKG_0965GS.do", FormQueryString(formObj));
        ComOpenWait(false);
        var pol=ComGetEtcData(sXml, "pol");
        var pod=ComGetEtcData(sXml, "pod");
        
        if(pol != "") {
            sheetObjects[1].SetCellValue(row, "pol_cd", pol);
            sheetObjects[1].SetCellValue(row, "pod_cd", pod);
        } else {
            ComShowCodeMessage('BKG06012', "[B/L No.]");
            sheetObjects[1].SetCellValue(row, "bl_no", "");
            sheetObjects[1].SetCellValue(row, "pol_cd", "");
            sheetObjects[1].SetCellValue(row, "pod_cd", "");
        }
        break;
        
    case SEARCH12 : //  validation (cntr_no) in case of input
        formObj.f_cmd.value=SEARCH12;
        ComOpenWait(true);
        var cgoOprCd = sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "cgo_opr_cd") ;
        var sParam = "&cgo_opr_cd=" + cgoOprCd;
        
        var sXml=sheetObjects[1].GetSearchData("ESM_BKG_0965GS.do", FormQueryString(formObj) + sParam);
        ComOpenWait(false);
        var cntrCgoSeq = ComGetEtcData(sXml, "cntrCgoSeq");
        var cntrRefNo = ComGetEtcData(sXml, "cntrRefNo");
        var cntrTpszCd = ComGetEtcData(sXml, "cntrTpszCd");
        if (cntrCgoSeq == "0") {
            ComShowCodeMessage('BKG06012', "[Container No.]");
            sheetObjects[1].SetCellValue(row, col, "", 0);
            sheetObjects[1].SetCellValue(row, "cntr_cgo_seq", "", 0);
            sheetObjects[1].SetCellValue(row, "cntr_ref_no", "", 0);
            sheetObjects[1].SetCellValue(row, "cntr_tpsz_cd", "", 0);
            sheetObjects[1].SelectCell(row, col);
        } else {
            sheetObjects[1].SetCellValue(row, "cntr_cgo_seq", cntrCgoSeq);
            sheetObjects[1].SetCellValue(row, "cntr_ref_no", cntrRefNo);
            sheetObjects[1].SetCellValue(row, "cntr_tpsz_cd", cntrTpszCd);
        }
        break;
        
    case SEARCH13 : //  validation (pol_cd, pod_cd) in case of input
        formObj.f_cmd.value=SEARCH13;
        ComOpenWait(true);
        var sXml=sheetObjects[1].GetSearchData("ESM_BKG_0965GS.do", FormQueryString(formObj));
        ComOpenWait(false);
        if(ComGetEtcData(sXml, "pol_cd")=="N"){
        	ComShowCodeMessage('BKG06012', "Port");
        	if(formObj.pol_cd.value=="Y"){
    		  sheetObjects[1].SetCellValue(row, "pol_cd", "");
              sheetObjects[1].SelectCell(row, col);
        	}else if(formObj.pod_cd.value=="Y"){
    		  sheetObjects[1].SetCellValue(row, "pod_cd", "");
              sheetObjects[1].SelectCell(row, col);
        	}
        }
    	sheetObjects[1].SelectCell(row, col);
        break;
        
    case SEARCH14 : // Booking Data Append Button
        IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");
        if(sheetObjects[0].IsDataModified()== true || sheetObjects[1].IsDataModified()== true) {
            ComShowCodeMessage('BKG06098');
            return;
        }
        if(!ComShowConfirm(ComGetMsg("BKG95003", "[append from BKG data]"))) {
            return;
        }
        formObj.f_cmd.value=SEARCH14;
        ComOpenWait(true);

        var sXml=sheetObjects[1].GetSearchData("ESM_BKG_0965GS.do", FormQueryString(formObj));
        ComOpenWait(false);
        var appendRow=sheetObjects[1].RowCount()+ 1;
        sheetObjects[1].LoadSearchData(sXml,{Append:1 , Sync:1} );
        formObj.bl_no.value="";
        for(var i=appendRow; i <=  sheetObjects[1].RowCount(); i++) {
            sheetObjects[1].SetCellValue(i, "seq","A",0);
            sheetObjects[1].SetRowStatus(i,"I");
            sheetObjects[1].SetCellBackColor(i, "seq","#FFFF00");
        } // end for(i)
        break;
        
    case MODIFY: // btn1_Close_SCG, btn1_Open_SCG
        
        formObj.f_cmd.value=MODIFY;
        formObj.search_d_type.value = getRadioValue(formObj.d_type);

        if (formObj.frm_spcl_cgo_prnr_clz_flg.value == "N") {
            formObj.frm_spcl_cgo_prnr_clz_flg.value = "Y";
        }else{
            formObj.frm_spcl_cgo_prnr_clz_flg.value = "N";
        }
        ComOpenWait(true);
        var sXml= sheetObjects[0].GetSearchData("ESM_BKG_0965GS.do", FormQueryString(formObj));
        ComOpenWait(false);
        var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
        if(State != "S"){
            ComShowMessage(ComResultMessage(sXml));
        }else if(State == "S"){
            ComShowCodeMessage('BKG00166');
            if (formObj.frm_spcl_cgo_prnr_clz_flg.value == "N") {
                ComSetDisplay("btn1_Close_SCG", true);
                ComSetDisplay("btn1_Open_SCG", false);
                ComBtnEnable("btn1_Close_SCG");
//                ComBtnEnable("btn2_Delete");
            }else{
                ComSetDisplay("btn1_Close_SCG", false);
                ComSetDisplay("btn1_Open_SCG", true);
                ComBtnEnable("btn1_Open_SCG");
//                ComBtnEnable("btn2_Delete");
            }
        }
        break;
    }
}

function obj_enter() {
    var keyValue = ComGetEvent("keycode");
    var obj = ComGetEvent();
    if (keyValue == 13) {
        if (obj.name == "d_type" || obj.name == "vvd_cd" || obj.name == "port_cd" || obj.name == "bay_plan_upload_check") {
            doActionIBSheet(sheetObjects[1], document.form, SEARCH02);
        } else if (obj.name == "filter_bl_no" || obj.name == "filter_cntr_no" || obj.name =="filter_dg_ref_no") {
            doActionIBSheet(sheetObjects[1], document.form, COMMAND01);
        }
    }
}

/**
 * change Sent Status color
 */
function setSentStatusFiledColor(sentStatus) {
    var formObj=document.form;
    var obj=formObj.ack_rcv_sts_cd_name;
    obj.style.color="white";
    if (sentStatus == "") {
        formObj.ack_rcv_sts_cd_name.value="Nil";
        obj.style.backgroundColor="gray";
    } else if (sentStatus == "P") {
        formObj.ack_rcv_sts_cd_name.value="Processing";
        obj.style.backgroundColor="gray";
    } else if (sentStatus == "A") {
        formObj.ack_rcv_sts_cd_name.value="Sent, Accepted";
        obj.style.backgroundColor="blue";
    } else if (sentStatus == "C") {
        formObj.ack_rcv_sts_cd_name.value="Sent, Wrong but Acceptable";
        obj.style.backgroundColor="yellowgreen";
    } else if (sentStatus == "R") {
        formObj.ack_rcv_sts_cd_name.value="Sent, Not Acceptable";
        obj.style.backgroundColor="red";
    }
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
    switch (sAction) {
        case SEARCH02:
            if (! ComChkValid(formObj))
                return false;
            break;
        case IBSAVE:
            
            IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");

            var sheet1RowCnt = sheetObjects[1].RowCount();
            if (sheet1RowCnt == 0)      return false;
            if (!ComChkValid(formObj))  return false;
            if (!checkFirstSearchCond())return false;
            
            var vslInfoLocalYn=sheetObjects[0].GetCellValue(1, "local_db_yn");
            var dgListLocalYn=formObj.dg_list_local_yn.value;
            if (!sheetObjects[0].IsDataModified() && !sheetObjects[1].IsDataModified() && vslInfoLocalYn == "Y" && dgListLocalYn == "Y")
            {
            	if(formObj.cell_chk.value != 'Y'){
            		ComShowCodeMessage('BKG00260'); // "Data NOT Changed"
                    return false;
            	}
            }

            for ( var i = 1; i <= sheet1RowCnt; i++) {
                if (sheetObjects[1].GetRowStatus(i) == "D") continue;
                if (sheetObjects[1].GetRowHidden(i) == "1") continue;
                
                if (ComIsNull(sheetObj.GetCellValue(i, "cgo_opr_cd"))) {
                    ComShowCodeMessage("BKG01101", "Cargo Operator");
                    sheetObj.SelectCell(i, "cgo_opr_cd");
                    return false;
                } else if (ComIsNull(sheetObj.GetCellValue(i, "bl_no"))) {
                    ComShowCodeMessage("BKG01101", "B/L No.");
                    sheetObj.SelectCell(i, "bl_no");
                    return false;
                } else if (ComIsNull(sheetObj.GetCellValue(i, "pol_cd"))) {
                    ComShowCodeMessage("BKG01101", "POL");
                    sheetObj.SelectCell(i, "pol_cd");
                    return false;
                } else if (ComIsNull(sheetObj.GetCellValue(i, "pod_cd"))) {
                    ComShowCodeMessage("BKG01101", "POD");
                    sheetObj.SelectCell(i, "pod_cd");
                    return false;
                } else if (ComIsNull(sheetObj.GetCellValue(i, "cntr_no"))) {
                    ComShowCodeMessage("BKG01101", "Container No.");
                    sheetObj.SelectCell(i, "cntr_no");
                    return false;
                } else if (ComIsNull(sheetObj.GetCellValue(i, "dcgo_ref_no"))) {
                    ComShowCodeMessage("BKG01101", "DG Ref. No.");
                    sheetObj.SelectCell(i, "dcgo_ref_no");
                    return false;
                } else if (ComIsNull(sheetObj.GetCellValue(i, "imdg_un_no"))) {
                    ComShowCodeMessage("BKG01101", "UN No.");
                    sheetObj.SelectCell(i, "imdg_un_no");
                    return false;
                } else if (ComIsNull(sheetObj.GetCellValue(i, "grs_wgt"))) {
                    ComShowCodeMessage("BKG01101", "Gross Weight");
                    sheetObj.SelectCell(i, "grs_wgt");
                    return false;
                } else if (ComIsNull(sheetObj.GetCellValue(i, "out_imdg_pck_cd1"))) {
                    ComShowCodeMessage("BKG01101", "Outer Code");
                    sheetObj.SelectCell(i, "out_imdg_pck_cd1");
                    return false;
                }else if (ComIsNull(sheetObj.GetCellValue(i, "cntr_tpsz_cd"))) {
	                ComShowCodeMessage("BKG01101", "CNTR TP/SZ");
	                sheetObj.SelectCell(i, "cntr_tpsz_cd");
	                return false;
			    } else if (ComIsNull(sheetObj.GetCellValue(i, "net_wgt"))) {
			        ComShowCodeMessage("BKG01101", "Net Weight");
			        sheetObj.SelectCell(i, "net_wgt");
			        return false;
				} else if (ComIsNull(sheetObj.GetCellValue(i, "eur_dcgo_mrn_polut_cd"))) {
				    ComShowCodeMessage("BKG01101", "Marine Polluant");
				    sheetObj.SelectCell(i, "eur_dcgo_mrn_polut_cd");
				    return false;
				} else if (ComIsNull(sheetObj.GetCellValue(i, "out_imdg_pck_qty1"))) {
				    ComShowCodeMessage("BKG01101", "Outer Package Qty");
				    sheetObj.SelectCell(i, "out_imdg_pck_qty1");
				    return false;
				} else if (ComIsNull(sheetObj.GetCellValue(i, "imdg_lmt_qty_flg"))) {
				    ComShowCodeMessage("BKG01101", "Limited Quantity");
				    sheetObj.SelectCell(i, "imdg_lmt_qty_flg");
				    return false;
				}
                if(sheetObj.GetCellValue(i, "imdg_clss_cd") == "3" &&
                        (sheetObj.GetCellValue(i, "flsh_pnt_cdo_temp") == "") ) {
                    ComShowCodeMessage("BKG00540", "[Container No. : " + sheetObj.GetCellValue(i, "cntr_no") + "]");
                    sheetObj.SelectCell(i, "flsh_pnt_cdo_temp");
                    return false;
                }
                // Load, Transit : 동일한 Cell Position 에 다른 CNTR No. 가 존재하는경우
                if (getRadioValue(formObj.d_type) != "D") {
                    var cellPsn = sheetObj.GetCellValue(i, "cell_psn_no");
                    var cntrNo  = sheetObj.GetCellValue(i, "cntr_no");
                    for ( var j = 1; j <= sheet1RowCnt; j++) {
                        if (sheetObjects[1].GetRowStatus(j) == "D") continue;
                        if (sheetObjects[1].GetRowHidden(j) == "1") continue;
                        if (i != j && !ComIsNull(cellPsn)) {
                            if (cellPsn == sheetObj.GetCellValue(j, "cell_psn_no") && cntrNo != sheetObj.GetCellValue(j, "cntr_no")) {
                                ComShowCodeMessage("BKG00460", "Cell Position = " + cellPsn);    // "Duplication occurred.({?msg1})"
                                sheetObj.SelectCell(j, "cell_psn_no");
                                return false;
                        	}
                            if (cellPsn != sheetObj.GetCellValue(j, "cell_psn_no") && cntrNo == sheetObj.GetCellValue(j, "cntr_no")) {
                                ComShowCodeMessage("BKG06112", "Cell Position", "Cell Position (" + cellPsn + " , " + sheetObj.GetCellValue(j, "cell_psn_no") + ")");   //"Different {?msg1} exsits for the same container [{?msg2}]"
                                sheetObj.SelectCell(i, "cell_psn_no");
                                return false;
                        	}
                        }
                    }
                }
               if (!ComIsNull(sheetObj.GetCellValue(i, "emer_cntc_phn_no"))) {
                    for (var j = 0; j < sheetObj.GetCellValue(i, "emer_cntc_phn_no").length; j++) {
                        var str=sheetObj.GetCellValue(i, "emer_cntc_phn_no").charAt(j);
                        if ((str.charCodeAt(0) >= 65 && str.charCodeAt(0) <= 90) || (str.charCodeAt(0) >= 97 && str.charCodeAt(0) <= 122)) {
                            ComShowCodeMessage("BKG00388", "Emergency Tel. can not have Alphabet");
                            sheetObj.SelectCell(i, "emer_cntc_phn_no");
                            return false;
                        }
                    }
                }
            }
            break;
        case MULTI01 :
            IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");

            var sheet1RowCnt = sheetObjects[1].RowCount();
            if (sheet1RowCnt == 0)      return false;
            if (!checkFirstSearchCond())return false;
            
            if(sheetObjects[0].IsDataModified() || sheetObjects[1].IsDataModified()) {
                ComShowCodeMessage('BKG06098'); // "There are some changed items, so you can transmit after save."
                return false;
            }
            
            for(var i=1; i<=sheet1RowCnt; i++) {
                if (sheetObjects[1].GetRowHidden(i) == "1") continue;
                
                if (ComIsNull(sheetObj.GetCellValue(i, "stup_flg"))) {
                    ComShowCodeMessage("BKG01101", "Setup Flag");
                    sheetObj.SelectCell(i, "stup_flg");
                    return false;
                } else if (ComIsNull(sheetObj.GetCellValue(i, "cntr_no"))) {
                    ComShowCodeMessage("BKG01101", "Container No.");
                    sheetObj.SelectCell(i, "cntr_no");
                    return false;
                } else if (!formObj.d_type[2].checked && formObj.port_cd.value != "DEHAM" && ComIsNull(sheetObj.GetCellValue(i, "cell_psn_no"))) {
                    ComShowCodeMessage("BKG01101", "Cell Position");
                    sheetObj.SelectCell(i, "cell_psn_no");
                    return false;
                } else if (ComIsNull(sheetObj.GetCellValue(i, "imdg_un_no"))) {
                    ComShowCodeMessage("BKG01101", "UN No.");
                    sheetObj.SelectCell(i, "imdg_un_no");
                    return false;
                } else if (ComIsNull(sheetObj.GetCellValue(i, "imdg_pck_grp_cd"))) {
                    ComShowCodeMessage("BKG01101", "Package Guoup");
                    sheetObj.SelectCell(i, "imdg_pck_grp_cd");
                    return false;
                } else if (ComIsNull(sheetObj.GetCellValue(i, "ems_no"))) {
                    ComShowCodeMessage("BKG01101", "EMS");
                    sheetObj.SelectCell(i, "ems_no");
                    return false;
                } else if (ComIsNull(sheetObj.GetCellValue(i, "net_wgt")) || "0" == sheetObj.GetCellValue(i, "net_wgt")) {
                    ComShowCodeMessage("BKG01101", "Net Weight");
                    sheetObj.SelectCell(i, "net_wgt");
                    return false;
                } else if (ComIsNull(sheetObj.GetCellValue(i, "grs_wgt")) || "0" == sheetObj.GetCellValue(i, "grs_wgt")) {
                    ComShowCodeMessage("BKG01101", "Gross Weight");
                    sheetObj.SelectCell(i, "grs_wgt");
                    return false;
                } else if (ComIsNull(sheetObj.GetCellValue(i, "out_imdg_pck_cd1"))) {
                    ComShowCodeMessage("BKG01101", "Outer Code");
                    sheetObj.SelectCell(i, "out_imdg_pck_cd1");
                    return false;
                } else if (ComIsNull(sheetObj.GetCellValue(i, "packages"))) {
                    ComShowCodeMessage("BKG01101", "Packages");
                    sheetObj.SelectCell(i, "packages");
                    return false;
                }
            }
            break;
            
        case MULTI02 :
            IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");

            var sheet1RowCnt = sheetObjects[1].RowCount();
            if (sheet1RowCnt == 0)      return false;
            if (!checkFirstSearchCond())return false;
            
            if(sheetObjects[0].IsDataModified() || sheetObjects[1].IsDataModified()) {
                ComShowCodeMessage('BKG06098'); // "There are some changed items, so you can transmit after save."
                return false;
            }
            if (sheetObj.GetCellValue(1, "send_type") == "") {
                ComShowCodeMessage("BKG06096"); // "Unable to send cancel message without original sent message."
                return false;
            } else if (sheetObj.GetCellValue(1, "send_type") == "C") {
                ComShowCodeMessage("BKG00572"); // "It is already canceled"
                return false;
            }
            break;
    }
    return true;
}

/**
 * check search condition
 */
function checkFirstSearchCond() {
    var formObj=document.form;
    formObj.search_d_type.value = getRadioValue(formObj.d_type);
    if(formObj.hid_d_type.value != formObj.search_d_type.value ||
            formObj.hid_vvd_cd.value != formObj.vvd_cd.value ||
            formObj.hid_port_cd.value!= formObj.port_cd.value ) {
        ComShowCodeMessage("BKG06118", "Declaration : " + formObj.hid_d_type.value + ", VVD : " + formObj.hid_vvd_cd.value+", Port : "+formObj.hid_port_cd.value, "Declaration : "+formObj.search_d_type.value+", VVD : "+formObj.vvd_cd.value+", Port : "+formObj.port_cd.value); // "Condition was changed!\n(BEFORE:{?msg1}) -> (AFTER:{?msg2})" 
        return false;
    }
    return true;
}

/**
 * save search condition.
 */
function setSearchCond(sheetObj, formObj) {
    if(sheetObj.RowCount()> 0) {
        formObj.hid_d_type.value=formObj.search_d_type.value;
        formObj.hid_vvd_cd.value=formObj.vvd_cd.value;
        formObj.hid_port_cd.value=formObj.port_cd.value;
    }
}

/**
 * change form field
 */
function obj_change() {
    var formObject=document.form;
    var srcName=ComGetEvent("name");
    var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
    var srcValue=window.event.srcElement.getAttribute("value");
    if(srcName == "frm_brth_yd_cd") {
        ComOpenWait(true);
        formObject.f_cmd.value=SEARCH04;
        var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0965GS.do", FormQueryString(formObject));
        var yardName=ComGetEtcData(sXml, "yardName");
        formObject.frm_yd_nm.value=(yardName == undefined) ? "" : yardName;
        ComOpenWait(false);
    } else if (srcName == "bay_plan_upload_check") {
        if (formObject.bay_plan_upload_check.checked) {
            openBayPlanPop(formObject, "10", true);
        } else {
            formObject.bay_pln_id.value="";
        }
    }
}

/**
 * callback function of un_no popup
 */
function callBack0204(aryPopupData, row, col, sheetIdx) {
    var sheetObj=sheetObjects[sheetIdx];
    var colArray=aryPopupData[0];
    
    var imdgUnNo=colArray[2];
    var imdgUnNoSeq=colArray[3];
    var imdgClssCd=colArray[4];
    var imdgCompGrpCd=colArray[5];
    var imdgPckGrpCd=colArray[6];
    var prpShpNm=colArray[7];
    var hzdDesc=colArray[9];
    var flshPntCdoTemp=colArray[14];
    var emsNo=colArray[17];
    if(imdgPckGrpCd==""){
        imdgPckGrpCd = "N";
    }
    sheetObj.SetCellValue(row, "imdg_un_no",imdgUnNo,0);
    sheetObj.SetCellValue(row, "imdg_un_no_seq",imdgUnNoSeq,0);
    sheetObj.SetCellValue(row, "imdg_clss_cd",imdgClssCd,0);
    sheetObj.SetCellValue(row, "imdg_comp_grp_cd",imdgCompGrpCd,0);
    sheetObj.SetCellValue(row, "ems_no",emsNo,0);
    sheetObj.SetCellValue(row, "imdg_pck_grp_cd",imdgPckGrpCd,0);
    
//    sheetObj.SetCellValue(row, "flsh_pnt_cdo_temp",flshPntCdoTemp,0);
    sheetObj.SetCellValue(row, "prp_shp_nm",prpShpNm,0);
    sheetObj.SetCellValue(row, "hzd_desc",hzdDesc,0);
 }

/**
 * BL No and Cntr No가 같을 때 같은 값 입력(Cell Position, TP/SZ) 
 */
function copyCellValueSheet2(sheetObj, rowCnt, row, col, value) {
    var blNo=sheetObj.GetCellValue(row, "bl_no");
    var cntrNo=sheetObj.GetCellValue(row, "cntr_no");

    if(blNo != "" && cntrNo != ""){
        for(var i=1; i <= rowCnt; i++) {
            if(sheetObj.GetCellValue(i, "bl_no")==blNo && sheetObj.GetCellValue(i, "cntr_no")==cntrNo){
                sheetObj.SetCellValue(i, col, value, 0);
            }
        }
    }
}

/**
 * filter condition visible
 */
function visibleFalse(searchType) {
    var formObject = document.form;
    nextSearchIdx = 0;
    if (searchType == "1") { // B/L
        formObject.filter_cntr_no.readOnly = true;
        formObject.filter_cntr_no.value = "";
        formObject.filter_dg_ref_no.readOnly = true;
        formObject.filter_dg_ref_no.value = "";
        formObject.filter_bl_no.readOnly = false;
    } else if (searchType == "2") { // CNTR No.
        formObject.filter_bl_no.readOnly = true;
        formObject.filter_bl_no.value = "";
        formObject.filter_dg_ref_no.readOnly = true;
        formObject.filter_dg_ref_no.value = "";
        formObject.filter_cntr_no.readOnly = false;
    } else if (searchType == "3") { // DG Ref No.
        formObject.filter_cntr_no.readOnly = true;
        formObject.filter_cntr_no.value = "";
        formObject.filter_bl_no.readOnly = true;
        formObject.filter_bl_no.value = "";
        formObject.filter_dg_ref_no.readOnly = false;
    }
}

/**
 * Bay plan Popup 화면에서 더블클릭한 BayplanId 설정
 */
function setBayplnId(bayplnId) {
    document.form.bay_pln_id.value=bayplnId;
}

function sheet1_OnSearchEnd(sheet1, ErrMsg) {
    var formObj = document.form;
    IBS_CopyRowToForm(sheet1, formObj, 1, "frm_");
    if (sheet1.RowCount()== 1) {
        formObj.frm_eta_d.value = ComGetMaskedValue(formObj.frm_eta_d.value, "ymd");
        formObj.frm_eta_t.value = ComGetMaskedValue(formObj.frm_eta_t.value, "hm");
        formObj.frm_etd_d.value = ComGetMaskedValue(formObj.frm_etd_d.value, "ymd");
        formObj.frm_etd_t.value = ComGetMaskedValue(formObj.frm_etd_t.value, "hm");
    }
}

function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
    var formObj = document.form;
    formObj.bay_pln_id.value = "";
    var chkResult ="";
    var fstStwCell = "";
    var fstNewStwCell = -1;
    
    if (formObj.f_cmd.value==SEARCH02) {
        if(formObj.dg_list_local_yn.value == "N") {// disabled EDI Transmit and EDI  Cancel button after retrieve Booking data
            ComBtnDisable("btn1_EDITransmit");
            ComBtnDisable("btn1_EDICancel");
            ComBtnDisable("btn1_Append_Retrieve");
            ComBtnDisable("btn1_Close_SCG");
//            ComBtnDisable("btn2_Delete");
        } else {
            ComBtnEnable("btn1_EDITransmit");
            ComBtnEnable("btn1_EDICancel");
            ComBtnEnable("btn1_Append_Retrieve");
//            ComBtnEnable("btn2_Delete");
            if (formObj.frm_spcl_cgo_prnr_clz_flg.value == "N") {
                ComSetDisplay("btn1_Close_SCG", true);
                ComSetDisplay("btn1_Open_SCG", false);
                ComBtnEnable("btn1_Close_SCG");
//                ComBtnEnable("btn2_Delete");
            }else{
                ComSetDisplay("btn1_Close_SCG", false);
                ComSetDisplay("btn1_Open_SCG", true);
                ComBtnEnable("btn1_Open_SCG");
//                ComBtnEnable("btn2_Delete");
            }
        }
        
        with (sheetObj) {
            if(formObj.dg_list_local_yn.value == "N") {
                SetColBackColor("dg","#C0C0C0");
            }
            if (RowCount()> 0) {
                formObj.cntr_cnt.value = GetCellValue(1,"cntr_cnt");
            }

            for ( var i=1; i <= RowCount(); i++) {
                if(GetCellValue(i, "flsh_pnt_cdo_temp") == "")  {
                    if(GetCellValue(i, "imdg_clss_cd") == "3" ) {
                        SetCellBackColor(i, "flsh_pnt_cdo_temp","#FF8040");
                    }
                }
                if(GetCellValue(i, "cell_psn_no") == "") {
                    SetCellBackColor(i, "cell_psn_no","#FFFF00");
                }
                if(GetCellValue(i, "imdg_un_no") == "") {
                    SetCellBackColor(i, "imdg_un_no","#FFFF00");
                }
                if(GetCellValue(i, "imdg_pck_grp_cd") == "") {
                    SetCellBackColor(i, "imdg_pck_grp_cd","#FFFF00");
                }
                if(GetCellValue(i, "eur_dcgo_mrn_polut_cd") == "") {
                    SetCellBackColor(i, "eur_dcgo_mrn_polut_cd","#FFFF00");
                }
                if(GetCellValue(i, "imdg_lmt_qty_flg") == "") {
                    SetCellBackColor(i, "imdg_lmt_qty_flg","#FFFF00");
                }
                if(GetCellValue(i, "ems_no") == "") {
                    SetCellBackColor(i, "ems_no","#FFFF00");
                }
                if(GetCellValue(i, "net_wgt") == "") {
                    SetCellBackColor(i, "net_wgt","#FFFF00");
                }
                if(GetCellValue(i, "grs_wgt") == "") {
                    SetCellBackColor(i, "grs_wgt","#FFFF00");
                }
                if (GetCellValue(i, "cgo_opr_cd") == "NYK" && !ComIsNull(GetCellValue(i, "cntr_no"))) {
                    SetCellEditable(i, "cntr_no",0);
                } else {
                    SetCellEditable(i, "cntr_no",1);
                }
                if (GetCellValue(i, "cell_chk") == "2"){ // Cell-Position Update 발생
                	SetCellBackColor(i, "cell_psn_no","#D1B2FF");
                	SetRowStatus(i, "U");
                	fstStwCell++;
                }
                if(GetCellValue(i, "cell_chk")=="1"){
                	chkResult++;
                }
                if(fstStwCell == 1){ // 제일 위의 Updated stowage으로 이동하기 위한 값. 
                	fstStwNewCell = i;
                }
                SetCellEditable(i, "bl_no",0);
            }
            if(formObj.dg_list_local_yn.value=="Y"){ // 저장 된 상태에서만 메시지가 나오게
            	if(chkResult != RowCount()){ 
            	  	formObj.cell_chk.value== "Y"
  	            	ComShowCodeMessage("COM12114", " purple box in the sheet which is updated cell position and you should save data."); // 'Please check {?msg1}';
            	  	SelectCell(fstStwNewCell,"cell_psn_no"); // Updated Stowage 중에서 제일 위의 값으로 cell 이동
            	  	chkResult = "";
  	            }else{
  	            	formObj.cell_chk.value== "N"
  	            }
            }
            	
            }
        }
    }

function sheet2_OnDblClick(sheetObj,Row,Col) {
    var colSaveName=sheetObj.ColSaveName(Col);
    switch(colSaveName) {
        case "seq" :
        case "cgo_opr_cd" :
        case "bl_no" :
        case "pol_cd" :
        case "pod_cd" :
        case "dcgo_ref_no" :
        case "cntr_no" :
            if(!sheetObj.GetCellEditable(Row, colSaveName)) {
                if(sheetObj.RowCount()== 0) {
                    ComShowCodeMessage('BKG00095');
                    return false;
                }
                var formObj=document.form;

                var sUrl="ESM_BKG_0970_P.do?";
                var sParam="callGubun=ESM_BKG_0966"
                + "&d_type="+getRadioValue(formObj.d_type)
                + "&vvd_cd="+formObj.vvd_cd.value
                + "&port_cd="+formObj.port_cd.value
                + "&bl_no="+sheetObj.GetCellValue(Row, 'bl_no')
                + "&cntr_no="+sheetObj.GetCellValue(Row, 'cntr_no')
                + "&cntr_cgo_seq="+sheetObj.GetCellValue(Row, 'cntr_cgo_seq');
                ComOpenWindowCenter(sUrl + sParam, "ESM_BKG_0970_P", 1050, 700, false);
            }
            break;
    }
}

function sheet2_OnPopupClick(sheetObj, Row, Col) {
    var formObj=document.form;
    with (sheetObj) {
        var sName=ColSaveName(Col);
        var sUrl="";
        var sParam="";
        var trnVal="";
        switch (sName) {
            case "fwrd_id":
                sUrl="/opuscntr/ESM_BKG_0969.do";
                rtnVal=ComOpenWindowCenter(sUrl, "ESM_BKG_0969", 600, 400, true);
                if (rtnVal != null) {
                    sheetObj.SetCellValue(Row, 'fwrd_id',rtnVal.cd,0);
                }
                break;
            case "dg":
                if(formObj.dg_list_local_yn.value == "Y") {
                    sUrl="ESM_BKG_0967.do?";
                    sParam="callGubun=ESM_BKG_0966"
                        + "&d_type="+getRadioValue(formObj.d_type)
                        + "&vvd_cd="+formObj.vvd_cd.value
                        + "&port_cd="+formObj.port_cd.value
                        + "&bl_no="+sheetObj.GetCellValue(Row, 'bl_no')
                        + "&bkg_no="+sheetObj.GetCellValue(Row, 'bkg_no')
                        + "&cntr_no="+sheetObj.GetCellValue(Row, 'cntr_no')
                        + "&cntr_cgo_seq="+sheetObj.GetCellValue(Row, 'cntr_cgo_seq')
                        + "&berth_cd="+formObj.frm_brth_yd_cd.value
                        + "&berth_nm="+formObj.frm_yd_nm.value;
                    rtnVal=ComOpenWindowCenter(sUrl + sParam, "ESM_BKG_0967", 1024, 600, false);
                    if (rtnVal != "N") {
                        doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
                    }
                } else {
                    ComShowCodeMessage('BKG06100');
                }
                break;
            case "imdg_un_no" :
                ComOpenPopup("ESM_BKG_0204.do?imdg_un_no=" + sheetObj.GetCellValue(Row, 'imdg_un_no') + "&bkg_no=" + sheetObj.GetCellValue(Row, 'bkg_no'), 920, 450, "callBack0204", '1,0,1,1,1,1,1', true, false, Row, Col, 1);
                break;
        }
    }
}
/**
 * handling sheet click
 */
function sheet2_OnClick(sheetObj, row, col) {
    var colSaveName=sheetObj.ColSaveName(col);
    switch(colSaveName) {
        case "packages" :
        case "prp_shp_nm" :
        case "hzd_desc" :
            ComShowMemoPad(sheetObj, null, null, false, 250, 80);
            break;
    }
}

/**
 * sheet Change event
 */
function sheet2_OnChange(sheetObj, row, col, value) {
    var rowCnt=sheetObj.RowCount();
    var colSaveName=sheetObj.ColSaveName(col);
    var formObj=document.form;
    switch(colSaveName) {
        case "cell_psn_no" :
            copyCellValueSheet2(sheetObj, rowCnt, row, "cell_psn_no", value);
            break;
        case "imdg_clss_cd" :
        case "imdg_un_no" :
            if(sheetObjects[1].GetCellValue(row, "imdg_clss_cd") == "Nil") {
                sheetObjects[1].SetCellFontColor(row, "imdg_clss_cd","#FF0000");
            } else {
                sheetObjects[1].SetCellFontColor(row, "imdg_clss_cd","#000000");
            }
            if(sheetObjects[1].GetCellValue(row, "imdg_un_no") == "Nil") {
                sheetObjects[1].SetCellFontColor(row, "imdg_un_no","#FF0000");
            } else {
                sheetObjects[1].SetCellFontColor(row, "imdg_un_no","#000000");
            }
            break;

        case "bl_no" :
            if (value != "") {
                if (ComIsNull(sheetObj.GetCellValue(row, "cgo_opr_cd"))) {
                    ComShowCodeMessage("BKG00445", "Cargo Operator");
                    sheetObj.SetCellValue(row, "bl_no", "");
                    sheetObj.SelectCell(row, "cgo_opr_cd");
                    return;
                }
                if (sheetObj.GetCellValue(row, "cgo_opr_cd") == "NYK") {
                    formObj.cond_type.value="bl_no";
                    formObj.cond_value.value=value;
                    doActionIBSheet(sheetObjects[1],formObj,SEARCH11, row, col);
                }
                
            }
            break;
        case "cntr_no" :
            if (value != "") {
            	 if (ComIsNull(sheetObj.GetCellValue(row, "cgo_opr_cd"))) {
                     ComShowCodeMessage("BKG00445", "Cargo Operator");
                     sheetObj.SetCellValue(row, "cntr_no", "");
                     sheetObj.SelectCell(row, "cgo_opr_cd");
                     return;
                 }
                if (sheetObj.GetCellValue(row, "cgo_opr_cd") == "NYK") {
                    formObj.cond_type.value="cntr_no";
                    formObj.cond_value.value=value;
                    formObj.bl_no.value = sheetObjects[1].GetCellValue(row, "bl_no");
                    doActionIBSheet(sheetObjects[1],formObj,SEARCH12, row, col);
                } else if (sheetObj.GetRowStatus(row) == "I" && sheetObj.GetCellValue(row, "cgo_opr_cd") != "NYK") {
                    sheetObj.SetCellValue(row, "cntr_ref_no", sheetObj.GetCellValue(row, "cntr_no"));
                }   
            }
            break;
        case "cntr_tpsz_cd" :
            copyCellValueSheet2(sheetObj, rowCnt, row, "cntr_tpsz_cd", value);
            break;
        case "pol_cd" :
        	if(value !="") {
                formObj.cond_value.value=value;
                formObj.pol_cd.value ="Y"
            	formObj.pod_cd.value ="N"
                doActionIBSheet(sheetObjects[1],formObj,SEARCH13, row, col);
        	}
        	break;
        case "pod_cd" :
        	if(value !="") {
                formObj.cond_value.value=value;
                formObj.pol_cd.value ="N"
            	formObj.pod_cd.value ="Y"
                doActionIBSheet(sheetObjects[1],formObj,SEARCH13, row, col);
        	}
        	break;	
    }
}


function sheet2_OnSaveEnd(sheetObj, Code) {
	if (Code < 0) {
		ComOpenWait(false);
 		return;
 	}
    if (sheetObj.RowCount() > 0) {
    	with (sheetObj) {
    		if (GetEtcData("dup_cntr_rst") == "Y") {
	    		ReDraw = false;
	    		// ComFindAll - 한개의 row값만 return될 경우 숫자형이므로 "|"으로 split되지 않음에 유의
  	    		var dupCntrRows = ComFindAll(sheetObj, "dup_cntr", "Y").toString().split("|"); // 컨테이너 중복을 체크
  	    		var dupCellRows = ComFindAll(sheetObj, "dup_cell", "Y").toString().split("|"); // 셀 포지션 중복을 체크
  	    		var fstErrRowCntr = -1;
  	    		var fstErrRowCell = -1;
  	    		
	    		for (var i in dupCntrRows) {
	    			if (i == 0) fstErrRowCntr = parseInt(dupCntrRows[i]);
	    			SetCellBackColor(parseInt(dupCntrRows[i]), "cntr_no", "#ffcccc"); // 중복 컨테이너 색칠
	    		}
	    		
	    		for (var i in dupCellRows) {
	    			if (i == 0) fstErrRowCell = parseInt(dupCellRows[i]);
	    			SetCellBackColor(parseInt(dupCellRows[i]), "cell_psn_no", "#ffcccc"); // 중복 셀 포지션 색칠
	    		}
	    		ReDraw = true;
	    		ComOpenWait(false);
	    		ComShowCodeMessage("BKG00460","Please check pink box in the sheet.");    // "Duplication occurred.({?msg1})"

	    		 // 시트상 제일 위에 있는 셀로 포커스
	    		if(fstErrRowCntr == -1 && fstErrRowCell != -1) SelectCell(fstErrRowCell,"cell_psn_no"); // 셀포지션 중복 만 존재
	    		else if( fstErrRowCntr != -1 && fstErrRowCell == -1 ) SelectCell(fstErrRowCntr,"cntr_no"); // 컨테이너 넘버 중복 만 존재
	    		else if( fstErrRowCntr != -1 && fstErrRowCell != -1 ){ // 둘 다 중복이 존재할 시
	    			if(parseInt(fstErrRowCell) > parseInt(fstErrRowCntr)){ 
	    				SelectCell(fstErrRowCntr,"cntr_no");
	    			}else if(parseInt(fstErrRowCell) < parseInt(fstErrRowCntr)){
	    				SelectCell(fstErrRowCell,"cell_psn_no"); 
	    			}else if(parseInt(fstErrRowCell) == parseInt(fstErrRowCntr)){
	    				SelectCell(fstErrRowCntr,"cntr_no");
	    			}
	    		} 
	    	} else { // 에러없이 제대로 데이터가 들어온 경우
	    		ComOpenWait(false);
	    	    var formObj = document.form;
	            if (formObj.f_cmd.value == MULTI01 || formObj.f_cmd.value == MULTI02) { // EDI 전송 or Cancel 전송
	                ComShowCodeMessage('BKG00101'); // "EDI was transmitted successfully."
	            } else {
	                ComShowCodeMessage('BKG00166'); // "Data Saved Successfully!!"
	            }
	            doActionIBSheet(sheetObj, formObj, SEARCH02);
	    	}
    	}
    }
}

function callBack0978(aryPopupData) {
    var updFlg = false;
    for (var i=0; i<aryPopupData.length; i++) {
        var arrIdx = ComFindAll(sheetObjects[1], 10, aryPopupData[i][2]);
        var toCntrNo = aryPopupData[i][3];
        
        if (arrIdx != -1) {
            var arrRows=arrIdx.split('|');
            for (var j = 0; j < arrRows.length; j++) {
                if (sheetObjects[1].GetCellValue(arrRows[j], "cgo_opr_cd") != "NYK") {
                    sheetObjects[1].SetCellValue(arrRows[j], "cntr_no", toCntrNo);
                }
            }
            updFlg = true;
        }
    }
//    if (!updFlg) {
//        return;
//    }
}

function getRadioValue(obj) {
    for (var i=0; i<obj.length; i++) {
        if (obj[i].checked) {
            return obj[i].value;
        }
    }
}