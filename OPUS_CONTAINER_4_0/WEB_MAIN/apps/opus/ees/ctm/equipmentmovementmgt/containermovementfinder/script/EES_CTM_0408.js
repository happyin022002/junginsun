/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ees_ctm_0408.js
*@FileTitle : Each Container
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/22
=========================================================*/

// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
        var sheetObj=sheetObjects[0];
        var frmObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_Calendar":
                    var cal=new ComCalendarFromTo();
                    cal.select(frmObj.p_date1, frmObj.p_date2, 'yyyy-MM-dd');
                    break;
                case "btn_retrieve":
                    if (!checkFormField()) return;
                    doActionIBSheet(sheetObj, frmObj, SEARCH01);
                    break;
                case "btn_new":
                    ComResetAll();
                    frmObj.p_cntrno.value="";
//                    frmObj.check_digit.value="";
                    frmObj.ctnr_tpsz_cd.value="";
                    frmObj.p_date1.value=frmObj.temp_date1.value;
                    frmObj.p_date2.value=frmObj.temp_date2.value;
                    // making btn_eachbkg Disable
                    ComBtnDisable("btn_eachbkg");
                    frmObj.p_cntrno.focus();
                    break;
                case "btn_eachbkg":
                    // calling function sheet1_OnDblClick 
                    sheet1_OnDblClick(sheetObj, sheetObj.GetSelectRow());
                    break;
                case "btn_delhist":
                    if (validateForm(sheetObj, frmObj)) {
                        ComOpenPopup("/opuscntr/EES_CTM_0415_POP.do?" +
                                     "p_cntrno=" + frmObj.p_cntrno.value + "&" +
//                                     "check_digit=" + frmObj.check_digit.value + "&" +
                                     "ctnr_tpsz_cd=" + frmObj.ctnr_tpsz_cd.value + "&" +
                                     "p_date1=" + frmObj.p_date1.value + "&" +
                                     "p_date2=" + frmObj.p_date2.value, 1020, 600, "", "0,1");
                    }
                    break;
                case "btn_close":
                    ComClosePopup(); 
                    break;

                case "btn_cycle_no":
                	if (validateForm(sheetObj, frmObj)) {
                		ComOpenPopup("/opuscntr/EES_CTM_0470_POP.do?cntr_no=" + frmObj.p_cntrno.value, 1000, 400, "", "0,1");
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
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
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
        // CTM-COMMON
        setEventProcess();
        // making btn_eachbkg Disable
        ComBtnDisable("btn_eachbkg");
        // retrieving again in case p_cntrno have value when on-loading
        if (document.form.p_cntrno.value) doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
        // focusing on page loading
        document.form.p_cntrno.focus();
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
             case 1:      //sheet1 init
                    with(sheetObj){                 
               var HeadTitle="CYC|C|STS|A/F|Origin YD|Return YD|Event Date|VVD Code|Booking No.|Booking No.|B/L No.|EQR Ref. No.|F/M|I/O|MSG|TP|HR|HB|D|E|R|R|SP|DM|DM Flg DT|DM Unflg DT|S/P|S/P|SCAC|EDI STOWAGE|RU Label Type|RU Label Value|Mode|Chassis No.|M.G Set|Seal No.|Waybill|Pick Up No.|Update Date (L)|Creation Date (L)|Update Date (S)|Creation Date (S)|Office|User Name|Remark(S)";
               var sTipAF="[ Auto Flag ]" +
               "<br>A : Missing status automatically created by system" +
               "<br>C : (International) \"TS, IC, MT\" status automatically created after \"VD\"" +
               "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      (USA domestic) \"CM\" status automatically created after \"CD\"" +
               "<br>N : When \"A\" status is modified manually, \"A\" becomes \"N\" status" +
               "<br>M : Added status" + 
               "<br>U : Status updated due to the next status" +
               "<br>E : Status created by Master/Lease" +
               "<br>S : When \"A\" status is modified by EDI message, \"A\" becomes \"S\" status";
               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:7, DataRowMerge:1 } );
               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
               var headers = [ { Text:HeadTitle, Align:"Center"} ];
               InitHeaders(headers, info);
               var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_cyc_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_co_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, },
                      {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_cre_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1, ToolTipText:sTipAF },
                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"org_yd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"dest_yd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:16 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"bkg_knt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      // mty_pln_no(ref_no) 추가 start by 2015/06/12 황미연 
                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"mty_pln_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      // mty_pln_no 추가 end
                      {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"fcntr_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ob_cntr_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , ToolTipText:"Bound indicator"},
                      {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_tp_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , ToolTipText:"[ Cargo type ] <br>F: Full, P: Reposition, R: Revenue"},
                      {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_hngr_rck_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , ToolTipText:"Hanger Rack, Y"},
                      {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_hngr_bar_atch_knt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , ToolTipText:"Hanger Bar"},
                      {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_disp_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , ToolTipText:"Disposal Candidate, Y"},
                      {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"imdt_ext_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , ToolTipText:"Immediate Exit, Y"},
                      {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_xch_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , ToolTipText:"Re-stuffing, F(From), T(To)"},
                      {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_rfub_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , ToolTipText:"Re-furbishing, Y"},
                      {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , ToolTipText:"Special, Y"},
                      {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_dmg_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , ToolTipText:"Damage, Y"},
                      {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"dmg_flg_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , ToolTipText:"Damage Flag Date"},
                      {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"dmg_unflg_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , ToolTipText:"Damage Unflag Date"},
                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_abbr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"usa_edi_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_stwg_psn_ctnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"rstr_usg_lbl_nm_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"rstr_usg_lbl_val_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_trsp_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"chss_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mgst_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"wbl_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"pkup_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"upd_locl_dt",             KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:16 },
                      {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cre_locl_dt",             KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:16 },
                      {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",                  KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:19 },
                      {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",                  KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:19 },
                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"usr_nm",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cnmv_rmk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
               InitColumns(cols);
               SetEditable(0);
               SetDataAutoTrim(1);
                     //no support[check again]CLT ToolTipOption="balloon:true; width:420; backcolor:#ffffff; forecolor:#14358B; icon:0;";
               SetSheetHeight(290);
               }
                break;
             case 2:      //sheet2 init
                    with(sheetObj){
                       var HeadTitle="ORG YD|Event Date|Receiving Date|Booking No.|B/L No.|EQR Ref. No.|VVD Code|VVD Code|VVD Code|STS|Gate In/Out|F/M|Export/Import|Result error message";
                       SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                       var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                       var headers = [ { Text:HeadTitle, Align:"Center"} ];
                       InitHeaders(headers, info);
                       var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"evnt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                  {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"evnt_dt",           KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:16 },
                                  {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cre_locl_dt",       KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:16 },
                                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                  // mty_pln_no(ref_no) 추가 start by 2015/06/12 황미연
                                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mty_pln_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                  // mty_pln_no(ref_no) 추가 end
                                  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"crnt_vsl_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"crnt_skd_voy_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                  {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"crnt_skd_dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"edi_mvmt_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"edi_gate_io_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_full_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                  {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_edi_sght_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                  {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"mvmt_edi_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
               InitColumns(cols);
               SetEditable(0);
               SetDataAutoTrim(1);
               SetDataAutoTrim(1);
               SetSheetHeight(200);
//               resizeSheet();
                     }
                break;
        }
    }
    //handling process for Sheet
    function doActionIBSheet(sheetObj, frmObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case SEARCH01:     
                if (validateForm(sheetObj, frmObj, sAction)) {
                    sheetObjects[0].SetWaitImageVisible(0);
                    sheetObjects[1].SetWaitImageVisible(0);
                    ComOpenWait(true);
                    frmObj.f_cmd.value=SEARCH;
                    var xml=sheetObj.GetSearchData("EES_CTM_0408GS.do", FormQueryString(frmObj));
                    var rtnValue=xml.split("|$$|");
                    sheetObjects[0].LoadSearchData(rtnValue[0],{Sync:1} );
                    sheetObjects[1].LoadSearchData(rtnValue[1],{Sync:1} );
                    sheetObjects[0].SelectCell(sheetObjects[0].LastRow(), 0);
                    sheetObjects[1].SelectCell(sheetObjects[1].LastRow(), 0);
                    sheet1_OnClick(sheetObj, sheetObj.GetSelectRow(), "bkg_no");
                }
                break;
        }
    }
    /**
     * handling OnSearchEnd event in Sheet1
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
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
        with (sheetObj) {           
            //if (ComGetLenByByte(GetCellValue(Row, "bkg_no")) > 0) {
            if (ComGetLenByByte(GetCellValue(Row, "bkg_no")) > 0) {
                // making btn_eachbkg Enable
                ComBtnEnable("btn_eachbkg");
            } else {
                // making btn_eachbkg Disable
                ComBtnDisable("btn_eachbkg");
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
            if (ComGetLenByByte(GetCellValue(Row, "bkg_no")) > 0 || ComGetLenByByte(GetCellValue(Row, "mty_pln_no")) > 0) {
                ComOpenPopup("/opuscntr/EES_CTM_0409_POP.do?" + "bkg_no=" + GetCellValue(Row , "bkg_no") + "&mty_pln_no=" + GetCellValue(Row , "mty_pln_no"), 1020, 600, "", "0,1");
            }
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
	    ComResizeSheet(sheetObjects[1]);
  }
    
    // That occurs when you move your mouse over the Event Sheet
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
        with(sheetObj) {
  			Row = MouseRow();
  			Col = MouseCol();        	
            var colName=ColSaveName(MouseCol());
            var sTipAF="[ Auto Flag ]" +
            "<br>A : Missing status automatically created by system" +
            "<br>C : (International) 'TS, IC, MT' Status automatically created after \'VD\'" +
            "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      (USA domestic) 'CM' Status automatically created after \'CD\'" +
            "<br>N : Once automatically created status (\'A\') modified by manual," +
            "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      \'A\' changed to \'N\'" +
            "<br>M : Added status." +
            "<br>U : Status updated due to next status." +
            "<br>E : Status created by Master/Lease."; 
            
            var sTipTP  = "[ Cargo type ] <br>F: Full, P: Reposition, R: Revenue";
            
            //if(colName == "mvmt_cre_tp_cd") SetToolTipText(Row, Col, sTipAF);
            if(colName == "bkg_cgo_tp_cd") SetToolTipText(Row, Col, sTipTP); 
        }
    }