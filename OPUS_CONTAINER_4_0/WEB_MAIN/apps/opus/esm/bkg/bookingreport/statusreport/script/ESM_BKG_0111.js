/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0111.js
*@FileTitle  : booking report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// Common global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var combo1=null;
var comboCnt=0;
var tabItem=0;
var seqSheet1=0;
var seqSheet2=0;
var loadPageCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++]=sheet_obj;
}
function setComboObject(combo_obj) {
    comboObjects[comboCnt++]=combo_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    for (i=0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }

    doActionIBSheet(sheetObjects[0], document.form, COMMAND01); 
    for (k=0; k < tabObjects.length; k++) {
        initTab(tabObjects[k], k + 1);
        tabObjects[k].SetSelectedIndex(0);
    }
    //MultiCombo initialization
    for ( var k=1; k < comboObjects.length - 1; k++) {
        initCombo(comboObjects[k]);
    }
    document.form.vvd.focus();
    initControl();
    loadPageCnt=1;
}
/**
 * The initial setting combo
 * @param {IBMultiCombo} comboObj  comboObj
 */
function initCombo(comboObj) {
    comboObj.SetMultiSelect(0);
//no support[check again]CLT    
    comboObj.UseCode=true;
    // comboObj.LineColor = "#ffffff";
    // comboObj.SetColAlign("left|left");
    comboObj.SetMultiSeparator(",");
    comboObj.SetDropHeight(150);
}
/**
 * HTML Control Event Dynamically loaded <br>
 * {@link #loadPage}Call Initialize IBSheet Object. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects Sequence number in the array
 */
function initControl() {
    var formObject=document.form;
    axon_event.addListener('keydown', 'ComKeyEnter', 'form');// Enter key
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    switch (sheetNo) {
    case 1: //t1sheet1 init
        with(sheetObj){
        
          //if (location.hostname != "")
          //no support[check again]CLT              InitHostInfo(location.hostname, location.port, page_path);
//          var HeadTitle1="Seq|B/L No.|Booking No.|Filer|Filer|Shipper|Shipper|Shipper|Shipper|Shipper|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Notify|Notify|Notify|Notify|Notify|Notify|B/L Data (Match)|B/L Data (Match)|B/L Data (Match)|B/L Data (Match)|B/L Data (Match)|B/L Data (Match)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|Container|Container|Container|Container|Container";
//          var HeadTitle2="Seq|B/L No.|Booking No.|US|CA|NM|AD|CT|CN|ZIP|NM|AD|CT|ST|CN|ZIP|NM|AD|CT|ST|CN|ZIP|Package|Package|Weight|Weight|Measure|Measure|Package|Weight|Measure|DS|MK|HTS|HS|NCM|Container |S|Package|Weight|Measure";
          var HeadTitle1="Seq|B/L No.|Booking No.|POL|POD|Filer|Filer|Shipper|Shipper|Shipper|Shipper|Shipper|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Notify|Notify|Notify|Notify|Notify|Notify|B/L Data (Match with C/M)|B/L Data (Match with C/M)|B/L Data (Match with C/M)|B/L Data (Match with C/M)|B/L Data (Match with C/M)|B/L Data (Match with C/M)|TOTAL C/M (Container Manifest)|TOTAL C/M (Container Manifest)|TOTAL C/M (Container Manifest)|TOTAL C/M (Container Manifest)|TOTAL C/M (Container Manifest)|TOTAL C/M (Container Manifest)|TOTAL C/M (Container Manifest)|TOTAL C/M (Container Manifest)|Container|Container|Container|Container|Container";
          var HeadTitle2="Seq|B/L No.|Booking No.|POL|POD|US|CA|NM|AD|CT|CN|ZIP|NM|AD|CT|ST|CN|ZIP|NM|AD|CT|ST|CN|ZIP|Package|Package|Weight|Weight|Measure|Measure|Package|Weight|Measure|DS|MK|HTS|HS|NCM|Container |S|Package|Weight|Measure";
    
          SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:3 } );
    
          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
          var headers = [ { Text:HeadTitle1, Align:"Center"},
                      { Text:HeadTitle2, Align:"Center"} ];
          InitHeaders(headers, info);
    
          var cols = [ {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"usa_cstms_file_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cnd_cstms_file_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm_s",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_addr_s",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_cty_nm_s",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cstms_decl_cnt_cd_s",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_zip_id_s",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm_c",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_addr_c",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_cty_nm_c",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_ste_cd_c",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cstms_decl_cnt_cd_c",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_zip_id_c",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm_n",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_addr_n",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_cty_nm_n",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_ste_cd_n",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cstms_decl_cnt_cd_n",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_zip_id_n",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Int",      Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"pck_qty_da",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"pck_qty_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Float",      Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"act_wgt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"act_wet_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Float",      Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"meas_qty_da",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"meas_qty_chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Int",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty_cm",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Float",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Float",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"meas_qty_cm",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_gds_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_mk_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_hts",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_hs",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_ncm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Int",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty_co",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Float",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cntr_wgt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Float",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"meas_qty_co",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cust_nm" },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"check" },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"good_idx" },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"error_idx" } ];
           
          InitColumns(cols);
    
          SetEditable(0);
          SetCountPosition(0);
          SetSheetHeight(450);
        }
        break;
    case 2: //t2sheet1 init
        with(sheetObj){
        
          //if (location.hostname != "")
          //no support[check again]CLT              InitHostInfo(location.hostname, location.port, page_path);
//          var HeadTitle1="Seq|H/B No.|Manifest File No.|Master B/L No.|Shipper|Shipper|Shipper|Shipper|Consignee|Consignee|Consignee|Consignee|Consignee|Notify|Notify|House B/L Data (Match)|House B/L Data (Match)|House B/L Data (Match)|House B/L Data (Match)|House B/L Data (Match)|House B/L Data (Match)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|Container|Container|Container|Container|Container";
//          var HeadTitle2="Seq|H/B No.|Manifest File No.|Master B/L No.|NM|AD|CT|CN|NM|AD|CT|ST|CN|NM|AD|Package|Package|Weight|Weight|Measure|Measure|Package|Weight|Measure|DS|MK|HTS|NCM|AMS| Container|S|Package|Weight|Measure";
          var HeadTitle1="Seq|H/B No.|Manifest File No.|Master B/L No.|POL|POD|Shipper|Shipper|Shipper|Shipper|Consignee|Consignee|Consignee|Consignee|Consignee|Notify|Notify|House B/L Data (Match)|House B/L Data (Match)|House B/L Data (Match)|House B/L Data (Match)|House B/L Data (Match)|House B/L Data (Match)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|Container|Container|Container|Container|Container";
          var HeadTitle2="Seq|H/B No.|Manifest File No.|Master B/L No.|POL|POD|NM|AD|CT|CN|NM|AD|CT|ST|CN|NM|AD|Package|Package|Weight|Weight|Measure|Measure|Package|Weight|Measure|DS|MK|HTS|NCM|AMS| Container|S|Package|Weight|Measure";
    
          SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:4, DataRowMerge:0 } );
    
          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
          var headers = [ { Text:HeadTitle1, Align:"Center"},
                      { Text:HeadTitle2, Align:"Center"} ];
          InitHeaders(headers, info);
    
          var cols = [ {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bhl_no" },
                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"b_usa_cstms_file_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"b_bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"b_pol_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"b_pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"b_cust_nm_s",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"b_cust_addr_s",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"b_cust_ct_s",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"b_cust_cn_s",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"b_cust_nm_c",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"b_cust_addr_c",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"b_cust_ct_c",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"b_cust_st_c",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"b_cust_cn_c",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"b_cust_nm_n",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"b_cust_addr_n",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"b_pck_qty_da",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"b_pck_qty_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Float",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"b_hbl_wgt_da",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"b_hbl_wgt_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Float",      Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"b_meas_qty_da",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"b_meas_qty_chk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Int",      Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"b_pck_qty_cm",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Float",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"b_cntr_wgt_cm",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Float",      Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"b_meas_qty_cm",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"b_cntr_mf_gds_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"b_cntr_mf_mk_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"b_cntr_mf_hts",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"b_cntr_mf_ncm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"b_cntr_mf_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"b_cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"b_cntr_seal_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Int",      Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"b_pck_qty_co",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Float",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"b_cntr_wgt_co",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Float",      Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"b_meas_qty_co",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cust_nm" },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"check" },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"good_idx" },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"error_idx" },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no" } ];
           
          InitColumns(cols);
    
          SetEditable(0);
          SetCountPosition(0);
          SetSheetHeight(450);
        }
        break;
    }
}
//Event handler processing by button name */
function processButtonClick() {
    /***** two or more sheet : use sheet  a variable assignment  *****/
    var sheetObject1=sheetObjects[0];
    var sheetObject2=sheetObjects[1];
    /** **************************************************** */
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch (srcName) {
        case "btn_Retrieve":
            if (tabItem == 0) {
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            } else {
                doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
            }
            break;
        case "btn_New":
            ComResetAll();
            t1sheet1.RemoveAll();
            t2sheet1.RemoveAll();
            document.getElementById('t1sheet1_tot').innerHTML = "";
            document.getElementById('t2sheet1_tot').innerHTML = "";
            document.form.tab_item.value=tabItem;
            break;
        case "btn_SaveExcel":
            if (tabItem == 0) {
//method change[check again]CLT                 
                if(sheetObject1.RowCount() < 1){//no data
                  ComShowCodeMessage("COM132501");
                }else{
                  //sheetObject1.Down2Excel({ HiddenColumn:-1,TreeLevel:false});
                  sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
                }
            } else {
//method change[check again]CLT                 
                if(sheetObject2.RowCount() < 1){//no data
                  ComShowCodeMessage("COM132501");
                }else{
                  //sheetObject2.Down2Excel({ HiddenColumn:-1,TreeLevel:false});
                  sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:1 });
                }
            }
            break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
    case IBSEARCH: //search
        if (!validateForm(sheetObj, formObj, sAction))
            return;
        sheetObj.SetWaitImageVisible(0);
        ComOpenWait(true);
        sheetObj.SetFocusAfterProcess(0);
        formObj.f_cmd.value=SEARCH;
//parameter changed[check again]CLT         
        sheetObj.DoSearch("ESM_BKG_0111GS.do", FormQueryString(formObj) );

        break;
    case COMMAND01: //CODE search                       
        formObj.f_cmd.value=SEARCH01;
        // sheetObj.DoSearch("ESM_BKG_0111GS.do",FormQueryString(formObj));
//parameter changed[check again]CLT         
        var searchXml=sheetObj.GetSearchData("ESM_BKG_0111GS.do", FormQueryString(formObj));
        var sXml=searchXml.split("|$$|");
        // US Filer
        ComBkgXml2ComboItem(sXml[0], usa_cstms_file_cd, "val", "name");
        // CA Filer
        ComBkgXml2ComboItem(sXml[0], cnd_cstms_file_cd, "val", "name");
        usa_cstms_file_cd.SetSelectIndex(1);
        cnd_cstms_file_cd.SetSelectIndex(1);
        break;
    }
}
function t1sheet1_OnSearchEnd(sheetObj){
    searchEnd(sheetObj);
    sheetObj.SelectCell(0, 0, false);
    ComOpenWait(false);
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
    if (formObj.vvd.value == '' || formObj.vvd.value.length != 9) {
        ComShowCodeMessage("BKG40047");// VVD is not available !
        formObj.vvd.focus();
        return false;
    } else {
        formObj.vsl_cd.value=formObj.vvd.value.substring(0, 4);
        formObj.skd_voy_no.value=formObj.vvd.value.substring(4, 8);
        formObj.skd_dir_cd.value=formObj.vvd.value.substring(8);
        // alert( formObj.vsl_cd.value + "_" + formObj.skd_voy_no.value + "_" + formObj.skd_dir_cd.value);
    }
    if (formObj.pol_cd.value == '' && formObj.pod_cd.value == '') {
        ComShowCodeMessage("BKG40047");// POL/POD is not available
        formObj.pol_cd.focus();
        return false;
    }
    if (formObj.cust_cnt_cd.value != '' && formObj.cust_seq.value == '') {
        ComShowCodeMessage("BKG00458");// invalid customer code
        formObj.cust_cnt_cd.focus();
        return false;
    }
    if (formObj.cust_cnt_cd.value == '' && formObj.cust_seq.value != '') {
        ComShowCodeMessage("BKG00458");// invalid customer code
        formObj.cust_seq.focus();
        return false;
    }
    if (formObj.pol_nod_cd.value != '') {
        formObj.pol_yd_cd.value=formObj.pol_cd.value + formObj.pol_nod_cd.value;
    } else {
        formObj.pol_yd_cd.value="";
    }
    if (formObj.pod_nod_cd.value != '') {
        formObj.pod_yd_cd.value=formObj.pod_cd.value + formObj.pod_nod_cd.value;
    } else {
        formObj.pod_yd_cd.value="";
    }
    return true;
}
/**
 * Register as array  to IBTab Object
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setTabObject(tab_obj) {
    tabObjects[tabCnt++]=tab_obj;
}
/**
 * initializing Tab
 * setting Tab items
 */
function initTab(tabObj, tabNo) {
    switch (tabNo) {
    case 1:
        with (tabObj) {
            var cnt=0;
            InsertItem( "Master B/L", "");
            InsertItem( "House B/L", "");
        }
        break;
    }
}
/**
 * Event when clicking Tab
 * activating selected tab items
 */
function tab1_OnChange(tabObj, nItem) {
    //var objs=document.all.item("tabLayer");
    var objs = document.getElementsByName("tabLayer");
    
    objs[nItem].style.display="Inline";
    objs[beforetab].style.display="none";
    tabItem=nItem;
    document.form.tab_item.value=tabItem;
    if (tabItem == 0) {
        document.getElementById('t1sheet1_tot').innerHTML=document.form.master_tot.value;
        //document.getElementById('tab_tot').innerHTML=document.form.master_tot.value;
    } else {
        document.getElementById('t2sheet1_tot').innerHTML=document.form.master_tot.value;
        //doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
        //document.getElementById('tab_tot').innerHTML = document.form.houser_tot.value;
    }
    /*
    if (tabItem == 0){
    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
    }else{
    doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    }
        if(nItem==0 &&tabLoad[0]!=1)
            frameLayer0.document.location='tab1.jsp?frame=Tab1';
        else if(nItem==1 &&tabLoad[1]!=1)
            frameLayer1.document.location='tab3.jsp?frame=Tab2';
     */
    // --------------- Importance --------------------------//
    objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
    // ------------------------------------------------------//
    beforetab=nItem;
    if(loadPageCnt == 0) return;
    
    document.getElementById('t1sheet1_tot').innerHTML = "";
    document.getElementById('t2sheet1_tot').innerHTML = "";
    if (nItem == 0) {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    } else {
        doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
    }
    
    //document.getElementById("btn_Retrieve").fireEvent("onclick");
}
// handling process after ending  retrieve
function searchEnd(sheetObj)// Generate a random variable
{
    with (sheetObj) {
        var redColor="#FF0000";
        var blueColor="#0000FF";
        for ( var i=2; i <= LastRow(); i++) {
            if (tabItem == 0) {
            //parameter changed[check again]CLT                 
                            SetCellFontColor(i, "bkg_no",blueColor);
            //parameter changed[check again]CLT                 
                            SetCellFontUnderline(i, "bkg_no",1);
            //parameter changed[check again]CLT                 
                            SetCellFontColor(i, "bl_no",blueColor);
            //parameter changed[check again]CLT                 
                            SetCellFontUnderline(i, "bl_no",1);
            if ("E" == GetCellValue(i, "pck_qty_chk")) {
            //parameter changed[check again]CLT                     
                SetCellFontColor(i, "pck_qty_chk",redColor);
                            }
            if ("E" == GetCellValue(i, "act_wet_chk")) {
            //parameter changed[check again]CLT                     
                SetCellFontColor(i, "act_wet_chk",redColor);
                            }
            if ("E" == GetCellValue(i, "meas_qty_chk")) {
            //parameter changed[check again]CLT                     
                SetCellFontColor(i, "meas_qty_chk",redColor);
                }
                /*
            if ("N" == GetCellValue(i, "cntr_mf_mk_desc")){
            //parameter changed[check again]CLT                     
            SetCellFontColor(i, "cntr_mf_mk_desc",redColor);
                }
                 */
                /*
                 * if ("N" == CellValue(i, "cntr_mf_hts")){ CellFontColor(i, "cntr_mf_hts") = redColor; } if ("N" == CellValue(i,
                 * "cntr_mf_hs")){ CellFontColor(i, "cntr_mf_hs") = redColor; } if ("N" == CellValue(i, "cntr_mf_ncm")){
                 * CellFontColor(i, "cntr_mf_ncm") = redColor; }
                 */
                if ("N" == GetCellValue(i, "cntr_mf_no")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "cntr_mf_no",redColor);
                                }
                                /*
                if ("N" == GetCellValue(i, "cntr_mf_gds_desc")){
                //parameter changed[check again]CLT                     
                SetCellFontColor(i, "cntr_mf_gds_desc",redColor);
                                }*/
                if ("E" == GetCellValue(i, "cntr_seal_seq")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "cntr_seal_seq",redColor);
                                }
                if ("E" == GetCellValue(i, "cust_nm_s")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "cust_nm_s",redColor);
                                }
                if ("E" == GetCellValue(i, "cust_addr_s")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "cust_addr_s",redColor);
                                }
                if ("E" == GetCellValue(i, "cust_cty_nm_s")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "cust_cty_nm_s",redColor);
                                }
                if ("E" == GetCellValue(i, "cstms_decl_cnt_cd_s")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "cstms_decl_cnt_cd_s",redColor);
                                }
                if ("E" == GetCellValue(i, "cust_zip_id_s")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "cust_zip_id_s",redColor);
                                }
                if ("E" == GetCellValue(i, "cust_nm_c")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "cust_nm_c",redColor);
                                }
                if ("E" == GetCellValue(i, "cust_addr_c")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "cust_addr_c",redColor);
                                }
                if ("E" == GetCellValue(i, "cust_cty_nm_c")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "cust_cty_nm_c",redColor);
                                }
                if ("E" == GetCellValue(i, "cust_ste_cd_c")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "cust_ste_cd_c",redColor);
                                }
                if ("E" == GetCellValue(i, "cstms_decl_cnt_cd_c")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "cstms_decl_cnt_cd_c",redColor);
                                }
                if ("E" == GetCellValue(i, "cust_zip_id_c")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "cust_zip_id_c",redColor);
                                }
                if ("E" == GetCellValue(i, "cust_nm_n")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "cust_nm_n",redColor);
                                }
                if ("E" == GetCellValue(i, "cust_addr_n")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "cust_addr_n",redColor);
                                }
                if ("E" == GetCellValue(i, "cust_cty_nm_n")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "cust_cty_nm_n",redColor);
                                }
                if ("E" == GetCellValue(i, "cust_ste_cd_n")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "cust_ste_cd_n",redColor);
                                }
                if ("E" == GetCellValue(i, "cstms_decl_cnt_cd_n")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "cstms_decl_cnt_cd_n",redColor);
                                }
                if ("E" == GetCellValue(i, "cust_zip_id_n")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "cust_zip_id_n",redColor);
                                }
                if ("E" == GetCellValue(i, "pck_qty_chk")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "pck_qty_chk",redColor);
                                }
                if ("E" == GetCellValue(i, "act_wet_chk")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "act_wet_chk",redColor);
                                }
                if ("E" == GetCellValue(i, "meas_qty_chk")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "meas_qty_chk",redColor);
                                }
                if ("E" == GetCellValue(i, "cntr_mf_gds_desc")) {     
                    SetCellFontColor(i, "cntr_mf_gds_desc",redColor);
                }
                if ("E" == GetCellValue(i, "cntr_mf_mk_desc")) {     
                    SetCellFontColor(i, "cntr_mf_mk_desc",redColor);
                }
                if ("E" == GetCellValue(i, "cntr_mf_hts")) {     
                    SetCellFontColor(i, "cntr_mf_hts",redColor);
                }
                if ("E" == GetCellValue(i, "cntr_mf_hs")) {     
                    SetCellFontColor(i, "cntr_mf_hs",redColor);
                }
                if ("E" == GetCellValue(i, "cntr_mf_ncm")) {     
                    SetCellFontColor(i, "cntr_mf_ncm",redColor);
                }
                
                            
            
            } else {
                //parameter changed[check again]CLT                 
                                SetCellFontColor(i, "b_bl_no",blueColor);
                //parameter changed[check again]CLT                 
                                SetCellFontUnderline(i, "b_bl_no",1);
                if ("E" == GetCellValue(i, "b_pck_qty_chk")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "b_pck_qty_chk",redColor);
                                }
                if ("E" == GetCellValue(i, "b_hbl_wgt_chk")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "b_hbl_wgt_chk",redColor);
                                }
                if ("E" == GetCellValue(i, "b_meas_qty_chk")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "b_meas_qty_chk",redColor);
                                }
                                /*
                if ("N" == GetCellValue(i, "b_cntr_mf_mk_desc")){
                //parameter changed[check again]CLT                     
                SetCellFontColor(i, "b_cntr_mf_mk_desc",redColor);
                }*/
                /*
                 * if ("N" == CellValue(i, "b_cntr_mf_hts")){ CellFontColor(i, "b_cntr_mf_hts") = redColor; } if ("N" ==
                 * CellValue(i, "b_cntr_mf_ncm")){ CellFontColor(i, "b_cntr_mf_ncm") = redColor; }
                 */
                /*
                 * if ("N" == CellValue(i, "b_cntr_mf_no")){ CellFontColor(i, "b_cntr_mf_no") = redColor; }
                 */
                /*
                 * if ("N" == CellValue(i, "b_cntr_mf_gds_desc")){ CellFontColor(i, "b_cntr_mf_gds_desc") = redColor; }
                 */
                if ("E" == GetCellValue(i, "b_cntr_seal_seq")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "b_cntr_seal_seq",redColor);
                                }
                if ("0" == GetCellValue(i, "b_pck_qty_cm")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "b_pck_qty_cm",redColor);
                                }
                if ("0" == GetCellValue(i, "b_cntr_wgt_cm")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "b_cntr_wgt_cm",redColor);
                                }
                if ("E" == GetCellValue(i, "b_cust_nm_s")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "b_cust_nm_s",redColor);
                                }
                if ("E" == GetCellValue(i, "b_cust_addr_s")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "b_cust_addr_s",redColor);
                                }
                if ("E" == GetCellValue(i, "b_cust_nm_c")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "b_cust_nm_c",redColor);
                                }
                if ("E" == GetCellValue(i, "b_cust_addr_c")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "b_cust_addr_c",redColor);
                                }
                if ("E" == GetCellValue(i, "b_cust_nm_n")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "b_cust_nm_n",redColor);
                                }
                if ("E" == GetCellValue(i, "b_cust_addr_n")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "b_cust_addr_n",redColor);
                                }
                if ("E" == GetCellValue(i, "b_pck_qty_chk")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "b_pck_qty_chk",redColor);
                                }
                if ("E" == GetCellValue(i, "b_hbl_wgt_chk")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "b_hbl_wgt_chk",redColor);
                                }
                if ("E" == GetCellValue(i, "b_meas_qty_chk")) {
                //parameter changed[check again]CLT                     
                    SetCellFontColor(i, "b_meas_qty_chk",redColor);
                }
            }
        }
        document.form.master_tot.value="Total : " + GetCellValue(LastRow(), "Seq") + " (Good : " + GetCellValue(LastRow(), "good_idx")
        + " , Error : " + GetCellValue(LastRow(), "error_idx") + ")";
        //document.getElementById('tab_tot').innerHTML=document.form.master_tot.value;
        document.getElementById('t1sheet1_tot').innerHTML=document.form.master_tot.value;
        document.getElementById('t2sheet1_tot').innerHTML=document.form.master_tot.value;
        // sheetObj.CountFormat = "[ 1 / " + seqSheet1 + " ]";
    }
}
// handling process after ending  retrieve
function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    ComOpenWait(false);
    with (sheetObj) {
        document.form.houser_tot.value="Total : " + GetCellValue(LastRow(), "Seq") + " (Good : " + GetCellValue(LastRow(), "good_idx")
        + " , Error : " + GetCellValue(LastRow(), "error_idx") + ")";
        document.getElementById('t2sheet1_tot').innerHTML=document.form.houser_tot.value;
                var redColor="#FF0000";
                var blueColor="#0000FF";
                for ( var i=2; i <= LastRow(); i++) {
        //parameter changed[check again]CLT             
                    SetCellFontColor(i, "b_bl_no",blueColor);
        //parameter changed[check again]CLT             
                    SetCellFontUnderline(i, "b_bl_no",1);
        if ("N" == GetCellValue(i, "b_pck_qty_chk")) {
        //parameter changed[check again]CLT                 
            SetCellFontColor(i, "b_pck_qty_chk",redColor);
                    }
        if ("N" == GetCellValue(i, "b_hbl_wgt_chk")) {
        //parameter changed[check again]CLT                 
            SetCellFontColor(i, "b_hbl_wgt_chk",redColor);
                    }
        if ("N" == GetCellValue(i, "b_meas_qty_chk")) {
        //parameter changed[check again]CLT                 
            SetCellFontColor(i, "b_meas_qty_chk",redColor);
                    }
                    /*
        if ("N" == GetCellValue(i, "b_cntr_mf_mk_desc")){
        //parameter changed[check again]CLT                 
        SetCellFontColor(i, "b_cntr_mf_mk_desc",redColor);
            }*/
            /*
             * if ("N" == CellValue(i, "b_cntr_mf_gds_desc")){ CellFontColor(i, "b_cntr_mf_gds_desc") = redColor; }
             */
        if ("E" == GetCellValue(i, "b_cntr_seal_seq")) {
        //parameter changed[check again]CLT                 
            SetCellFontColor(i, "b_cntr_seal_seq",redColor);
                    }
        if ("0" == GetCellValue(i, "b_pck_qty_cm")) {
        //parameter changed[check again]CLT                 
            SetCellFontColor(i, "b_pck_qty_cm",redColor);
                    }
        if ("0" == GetCellValue(i, "b_cntr_wgt_cm")) {
        //parameter changed[check again]CLT                 
            SetCellFontColor(i, "b_cntr_wgt_cm",redColor);
                    }
        if ("E" == GetCellValue(i, "b_cust_nm_s")) {
        //parameter changed[check again]CLT                 
            SetCellFontColor(i, "b_cust_nm_s",redColor);
                    }
        if ("E" == GetCellValue(i, "b_cust_addr_s")) {
        //parameter changed[check again]CLT                 
            SetCellFontColor(i, "b_cust_addr_s",redColor);
                    }
        if ("E" == GetCellValue(i, "b_cust_nm_c")) {
        //parameter changed[check again]CLT                 
            SetCellFontColor(i, "b_cust_nm_c",redColor);
                    }
        if ("E" == GetCellValue(i, "b_cust_addr_c")) {
        //parameter changed[check again]CLT                 
            SetCellFontColor(i, "b_cust_addr_c",redColor);
                    }
        if ("E" == GetCellValue(i, "b_cust_nm_n")) {
        //parameter changed[check again]CLT                 
            SetCellFontColor(i, "b_cust_nm_n",redColor);
                    }
        if ("E" == GetCellValue(i, "b_cust_addr_n")) {
        //parameter changed[check again]CLT                 
            SetCellFontColor(i, "b_cust_addr_n",redColor);
                    }
        if ("E" == GetCellValue(i, "b_pck_qty_chk")) {
        //parameter changed[check again]CLT                 
            SetCellFontColor(i, "b_pck_qty_chk",redColor);
                    }
        if ("E" == GetCellValue(i, "b_hbl_wgt_chk")) {
        //parameter changed[check again]CLT                 
            SetCellFontColor(i, "b_hbl_wgt_chk",redColor);
                    }
        if ("E" == GetCellValue(i, "b_meas_qty_chk")) {
        //parameter changed[check again]CLT                 
            SetCellFontColor(i, "b_meas_qty_chk",redColor);
            }
        if ("E" == GetCellValue(i, "b_cust_ct_s")) {     
                SetCellFontColor(i, "b_cust_ct_s",redColor);
                }
        if ("E" == GetCellValue(i, "b_cust_cn_s")) {     
            SetCellFontColor(i, "b_cust_cn_s",redColor);
            }
        if ("E" == GetCellValue(i, "b_cust_ct_c")) {     
            SetCellFontColor(i, "b_cust_ct_c",redColor);
            }
        if ("E" == GetCellValue(i, "b_cust_st_c")) {     
            SetCellFontColor(i, "b_cust_st_c",redColor);
            }
        if ("E" == GetCellValue(i, "b_cust_cn_c")) {     
            SetCellFontColor(i, "b_cust_cn_c",redColor);
            }
        if ("E" == GetCellValue(i, "b_cntr_mf_gds_desc")) {     
            SetCellFontColor(i, "b_cntr_mf_gds_desc",redColor);
            }
        if ("E" == GetCellValue(i, "b_cntr_mf_mk_desc")) {     
            SetCellFontColor(i, "b_cntr_mf_mk_desc",redColor);
            }
        if ("E" == GetCellValue(i, "b_cntr_mf_hts")) {     
            SetCellFontColor(i, "b_cntr_mf_hts",redColor);
            }
        if ("E" == GetCellValue(i, "b_cntr_mf_ncm")) {     
            SetCellFontColor(i, "b_cntr_mf_ncm",redColor);
            }
        if ("E" == GetCellValue(i, "b_cntr_mf_no")) {     
            SetCellFontColor(i, "b_cntr_mf_no",redColor);
            }
           /*
        if ("N" == GetCellValue(i, "b_cntr_mf_hts")){
        //parameter changed[check again]CLT                 
        SetCellFontColor(i, "b_cntr_mf_hts",redColor);
                    }
        if ("N" == GetCellValue(i, "b_cntr_mf_ncm")){
        //parameter changed[check again]CLT                 
        SetCellFontColor(i, "b_cntr_mf_ncm",redColor);
            }*/
            /*
             * if ("N" == CellValue(i, "b_cntr_mf_no")){ CellFontColor(i, "b_cntr_mf_no") = redColor; }
             */
        }
        //sheetObj.CountFormat = "[ 1 / " + seqSheet2 + " ]";
    }
}
/*
 *  Search Option or Item Option Modify
 * */
function t1sheet1_OnDblClick(sheetObj, rowIdx, colIdx) {
    if (colIdx == sheetObj.SaveNameCol("bkg_no")) {
        comBkgCallPopBkgDetail(sheetObj.GetCellValue(rowIdx, "bkg_no"));
    } else if (colIdx == sheetObj.SaveNameCol("bl_no")) {
        //                  var param= "?bkg_no="+sheetObj.CellValue(rowIdx, "bkg_no");
//        var param="?bkg_no=" + sheetObj.GetCellValue(rowIdx, "bkg_no");
//        ComOpenWindowCenter2("/opuscntr/ESM_BKG_0927_POP.do" + param, "BL Preview", 1024, 740, true, "scrollbars=yes,resizable=yes");

//        var blTpCd="W";
//        var blNo = sheetObj.GetCellValue(rowIdx, "bl_no");
//        if (blNo.substring(blNo.length-1, blNo.length) != "W") {
//            blTpCd="D";
//        }
//        var param="?bkg_no="   +sheetObj.SaveNameCol("bkg_no")
//        					  + "&bl_no="   +blNo+
//        					  + "&bl_tp_cd="+blTpCd;
//		ComOpenPopup('ESM_BKG_0927_POP.do?pgmNo=ESM_BKG_0927_POP'+param, 916, 750, "", '1,0,1,1', false);   
		
		var blNo=sheetObj.GetCellValue(rowIdx, "bl_no");
		var bkgNo=sheetObj.GetCellValue(rowIdx, "bkg_no");
		comBkgCallPop0927(bkgNo, blNo);
    
    }
}
/*
 *  Search Option or Item Option Modify
 * */
function t2sheet1_OnDblClick(sheetObj, rowIdx, colIdx) {
    if (colIdx == sheetObj.SaveNameCol("b_bkg_no")) {
        comBkgCallPopBkgDetail(sheetObj.GetCellValue(rowIdx, "bkg_no"));
    } else if (colIdx == sheetObj.SaveNameCol("b_bl_no")) {
        var param="?pgmNo=ESM_BKG_0079_POP&bkg_no=" + sheetObj.GetCellValue(rowIdx, "bkg_no");
        comBkgCallPopBkgDetail(sheetObj.GetCellValue(rowIdx, "bkg_no"));
    }
}
