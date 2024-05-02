/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0109.js
*@FileTitle  : GRI Calculation - Arbitrary
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================*/
    //  ===================================================================================
    //  Global Variable
    //  ===================================================================================
    //  Common Global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheet1;
    var sheet2;
    var sheet3;
    var sheet4;
    //  Opener object
    var vOpener=window.dialogArguments;
    //  Sheet1 Column 
    var C1_GRPSEQ="gri_grp_seq";
//  var C1_APPL_OPTION    = "flt_pct_tp_cd";
    var C1_APPLICATION="gri_appl_div_cd";
    var C1_POINT="rout_pnt_loc_def_cd";
    var C1_TRANSMODE="prc_trsp_mod_cd";
    var C1_TERM="rcv_de_term_cd";
    var C1_BASEPORT="bse_port_def_cd";
    var C1_VIA="via_port_def_cd";
    var C1_POINT_O="point_o";
    var C1_TRANSMODE_O="transmode_o";
    var C1_TERM_O="term_o";
    var C1_BASEPORT_O="baseport_o";
    var C1_VIA_O="via_o";
    //  Sheet2 Column 
    var C2_PER="rat_ut_cd";
    var C2_CARGOTYPE="prc_cgo_tp_cd";
    var C2_CURRENCY="curr_cd";
    var C2_AMT="gri_rt_amt";
    var C2_RTO="gri_rt_rto";
    //  Sheet3 Column 
    var C3_POINT="rout_pnt_loc_def_cd";
    var C3_POINT_NM="rout_pnt_loc_def_nm";
    var C3_TRANSMODE="prc_trsp_mod_cd";
    var C3_TRANSMODE_NM="prc_trsp_mod_nm";
    var C3_TERM="rcv_de_term_cd";
    var C3_TERM_NM="rcv_de_term_nm";
    var C3_BASEPORT="bse_port_def_cd";
    var C3_BASEPORT_NM="bse_port_def_nm";
    var C3_VIA="via_port_def_cd";
    var C3_VIA_NM="via_port_def_nm";
    var C3_CURRENCY="curr_cd";
    //  Sheet5 Column 
    var C5_APPLICATION="gri_appl_div_cd";
    var C5_POINT="rout_pnt_loc_def_cd";
    var C5_TRANSMODE="prc_trsp_mod_cd";
    var C5_TERM="rcv_de_term_cd";
    var C5_BASEPORT="bse_port_def_cd";
    var C5_VIA="via_port_def_cd";
    var C5_APPL_OPTION="flt_pct_tp_cd";
    var C5_PER="rat_ut_cd";
    var C5_CARGOTYPE="prc_cgo_tp_cd";
    var C5_CURRENCY="curr_cd";
    var C5_AMT="gri_rt_amt";
    var C5_RTO="gri_rt_rto";
    //  Sheet6 Column 
    var C6_PROPOSAL="prop_frt_rt_amt";
    var C6_POINT="rout_pnt_loc_def_cd";
    var C6_TRANSMODE="prc_trsp_mod_cd";
    var C6_TERM="rcv_de_term_cd";
    var C6_BASEPORT="bse_port_def_cd";
    var C6_VIA="via_port_def_cd";
    var C6_PER="rat_ut_cd";
    var C6_CARGOTYPE="prc_cgo_tp_cd";
    var C6_CURRENCY="curr_cd";
    var C6_APPL_OPTION="flt_pct_tp_cd";
    var C6_GRI_AMT="gri_appl_amt";
    var C6_AMT="gri_rt_amt";
    var C6_RTO="gri_rt_rto";
    //  BIZ Global Variable
    var isSelectCell_1=true;
    var isConfirmQestion=true;
    var gCurrRow1;
    //  Filter combo
    var gArrPointRange={};  // route by Point
    var gArrPointCob={}; // Point Mode combo
    var gArrTransCob={};    // Trans Mode combo
    var gArrTermCob={};     // Term combo
    var gArrBPortCob={};    // Base Port combo
    var gArrVIACob={};      // VIA combo
    //  ===================================================================================
    //  Event handler processing by button click even
    //  ===================================================================================
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  N/A
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.18
     */
    function processButtonClick(){
        var form=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            
            switch(srcName) {
                /** Upper Grid *********************************************************************************************/
                case "btn_RowAdd":
                    doActionIBSheet(sheet1, form, IBINSERT);
                    break;
                case "btn_RowCopy":
                    doActionIBSheet(sheet1, form, IBCOPYROW);
                    break;
                case "btn_Delete":
                    doActionIBSheet(sheet1, form, IBDELETE);
                    break;
                    /** Lower Grid *********************************************************************************************/
                case "btn_RowAdd2":
                    doActionIBSheet2(sheet2, form, IBINSERT);
                    break;
                case "btn_RowCopy2":
                    doActionIBSheet2(sheet2, form, IBCOPYROW);
                    break;
                case "btn_Delete2":
                    doActionIBSheet2(sheet1, form, IBDELETE);
                    break;
                case "btn_Save2":
                    doActionIBSheet2(sheet2, form, IBSAVE);
                    break;
                    /** OK, Cancle, Close *********************************************************************************************/
                case "btn_OK":
                    if (sheet1.IsDataModified()|| sheet2.IsDataModified()) {
                        ComShowCodeMessage('PRI00007'); //msgs['PRI00007']='It can not be saved without input of detailed information.';
                        return;
                    }
                    if (ComPriConfirmSave()) {
                        doActionIBSheet5(sheet5, form, IBSEARCH); // Getting GRI Calculation to be applied
                    }
                    break;
                case "btn_Cancle":
                    if (ComPriConfirmSave()) {
                        doActionIBSheet6(sheet6, form, IBDELETE); // Deleting applied GRI Calculation
                    }
                    break;
                case "btn_Close":
                	ComClosePopup(); 
                    break;
            } //end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    /**
     * registering IBSheet Object as list</b>
     * adding process for list in case of needing batch processing with other items </b>
     * defining list on the top of source</b>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj IBSheet Object
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.18
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * implementing onLoad event handler in body tag <br>
     * adding first-served functions after loading screen. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  N/A
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.18
     */
    function loadPage() {
        var form=document.form;
        if( form.prop_no.value == "" || form.amdt_seq.value == "" || form.svc_scp_cd.value == "" || form.add_chg_tp_cd.value == ""
            || form.org_dest_tp_cd.value == "" || form.gri_appl_tp_cd.value == "" || form.prop_sts_cd.value == "") {
        	ComClosePopup(); 
        }
        sheet1=sheetObjects[0]; // upper grid
        sheet2=sheetObjects[1]; // lower grid
        sheet3=sheetObjects[2]; // combo grid
        sheet4=sheetObjects[3]; // find_text 
        sheet5=sheetObjects[4]; // all GRI Calculation to be applied
        sheet6=sheetObjects[5]; // Abitrary list  - for checking duplication
        sheetCnt=sheetObjects.length;
        for(i=0;i<sheetCnt;i++){
            ComConfigSheet(sheetObjects[i]); 
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]); 
        }
        setButtonControl("");
        axon_event.addListenerForm('click', 'obj_click', form);
        ComOpenWait(true);
        doActionIBSheet3(sheet3, form, IBSEARCH); // for creating combo 
        ComOpenWait(false);
        var statusObjValue=form.gri_appl_tp_cd.value;
        var propStsCd=form.prop_sts_cd.value;
        if(statusObjValue == "Y") {
            setButtonControl("CANCEL");
        }else{
            setButtonControl("OK");
        }
        // it not Initial 
        if(propStsCd != "I"){
            setButtonControl("");
        }
    }
    /**
     * initializing sheet <br>
     * adding first-served functions after loading screen. <br>
     * adding case as numbers of counting sheets. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBSheet} sheetObj : Sheet Object
     * @param {int} sheetNo : Sheet Object Tag's ID Serial No
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.18
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1": // upper grid
                with (sheet1) {
                HeadTitle1="ibflag|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|org_dest_tp_cd|gri_grp_seq|Application|Point|TransMode|Term|BasePort|VIA|point org|trans org|term org|baseport org|via org";
//                (ComCountHeadTitle(HeadTitle1), 0, 0, false);

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                       {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                       {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"org_dest_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:C1_GRPSEQ,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:C1_APPLICATION,    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:C1_POINT,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:C1_TRANSMODE,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:C1_TERM,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:C1_BASEPORT,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:C1_VIA,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C1_POINT_O,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C1_TRANSMODE_O,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C1_TERM_O,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C1_BASEPORT_O,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C1_VIA_O,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
                 
                InitColumns(cols);

                SetEditable(1);
                SetDataAutoTrim(1);
                SetWaitImageVisible(0);
                SetColProperty(C1_APPLICATION, {ComboText:"|Include|Exclude", ComboCode:"=|I|E"} );
                InitComboNoMatchText(true);
                SetSheetHeight(120);

                }
                break;
            case "sheet2": // lower grid
                with (sheet2) {
                var HeadTitle1="status|Sel.|Seq.|prop no|amdt_seq|svc_scp_cd|org_dest_tp_cd|gri_grp_seq|gri_adj_seq|flt_pct_tp_cd|Per|Cargo Type|Currency|GRI Amount|Percentage(%)";
//                (ComCountHeadTitle(HeadTitle1), 0, 0, false);

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                          {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                          {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                          {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"org_dest_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"gri_grp_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"gri_adj_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"flt_pct_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:C2_PER,            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:C2_CARGOTYPE,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:C2_CURRENCY,       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:C2_AMT,            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
                          {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:C2_RTO,            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 } ];
                 
                InitColumns(cols);

                SetEditable(1);
                SetDataAutoTrim(1);
                SetWaitImageVisible(0);
                SetColProperty(C2_PER, {ComboText:perComboText, ComboCode:perComboValue} );
                SetColProperty(C2_CARGOTYPE, {ComboText:cargoComboText, ComboCode:cargoComboValue} );
                SetSheetHeight(120);
                }
                break;
            case "sheet3": // hidden grid : selected combo data on parent window
                with (sheet3) {
                var HeadTitle1="rnum|Point|Point Nm|Trans\nMode|Trans\nMode Nm|Term|Term Nm|Base Port|Base Port nm|VIA|VIA nm|Currency"
//                (ComCountHeadTitle(HeadTitle1), 0, 0, false);

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"rnum",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:C3_POINT,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:C3_POINT_NM,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:C3_TRANSMODE,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C3_TRANSMODE_NM,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:C3_TERM,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:C3_TERM_NM,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:C3_BASEPORT,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:C3_BASEPORT_NM,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:C3_VIA,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:C3_VIA_NM,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:C3_CURRENCY,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
                 
                InitColumns(cols);

                SetEditable(1);
                SetDataAutoTrim(1);
                SetWaitImageVisible(0);
                SetSheetHeight(100);

                }
                break;
            case "sheet4": // for find_text 
                with (sheet4) {
                var HeadTitle1="f_text1"
//                (ComCountHeadTitle(HeadTitle1), 0, 0, false);
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"f_text1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
                 
                InitColumns(cols);

                SetEditable(1);
                SetWaitImageVisible(0);
                var idx=sheet4.DataInsert();
                SetSheetHeight(70);

                }
                break;
            case "sheet5": // all GRI Calculation list
                with (sheet5) {
                var HeadTitle1="Seq.|gri_grp_seq|gri_adj_seq|Application|Point|TransMode|Term|BasePort|VIA|Appl Option|Per|Cargo Type|Currency|amt|percentage";
//                (ComCountHeadTitle(HeadTitle1), 0, 0, false);

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"gri_grp_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"gri_adj_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_APPLICATION,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_POINT,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_TRANSMODE,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_TERM,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_BASEPORT,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_VIA,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_APPL_OPTION,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_PER,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_CARGOTYPE,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_CURRENCY,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                          {Type:"Float",     Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_AMT,            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                          {Type:"Int",       Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_RTO,            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0 } ];
                 
                InitColumns(cols);

                SetEditable(1);
                SetDataAutoTrim(1);
                SetWaitImageVisible(0);
                SetSheetHeight(100);
                }
                break;
            case "sheet6": // Arbitrary list
                with (sheet6) {
                var HeadTitle1="status|update cnt|Seq.|prop_no|amdt_seq|svc_scp_cd|add_chg_tp_cd|org_dest_tp_cd|add_chg_seq|gri_grp_seq|proposal|Point|Trans Mode|Term|Base Port|VIA|Per|Cargo Type|Currency|appl opt|gri_appl_amt|amt|rto"
//                (ComCountHeadTitle(HeadTitle1), 0, 0, false);

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"up_cnt",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0 },
                       {Type:"Seq",       Hidden:0, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"seq" },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:0,  Width:20,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"add_chg_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"org_dest_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"add_chg_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"gri_grp_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Int",       Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_PROPOSAL,       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0 },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_POINT,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_TRANSMODE,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_TERM,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_BASEPORT,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_VIA,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_PER,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_CARGOTYPE,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_CURRENCY,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_APPL_OPTION,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                       {Type:"Float",     Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_GRI_AMT,        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                       {Type:"Float",     Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_AMT,            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                       {Type:"Int",       Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_RTO,            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0 } ];
                 
                InitColumns(cols);

                SetEditable(1);
                SetDataAutoTrim(1);
                SetWaitImageVisible(0);
                SetSheetHeight(100);
                }
                break;
        }
    }
    //  ===================================================================================
    //  Axson Event Handler
    //  ===================================================================================
    /**
     * Object's Onclick event handler <br>
     * Checking validation of inputed value according to object's dataformat  <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  N/A
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.24
     */
    function obj_click(){
        var form=document.form;
        var obj=event.srcElement;
        switch(ComGetEvent("name")){
            case "rdo_appl_option":
                setEditAmtPer("CLICK");
                break;
        }
    }
    //  ===================================================================================
    //  UI Object Event Handler
    //  ===================================================================================
    /**
     * OnSearchEnd evnet handler after retrieving sheet3 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {string} errMsg : error message
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.18
     */
    function sheet3_OnSearchEnd(sheetObj, errMsg) {
        if (errMsg == "" && sheet3.SearchRows()> 0) {
            setPointComboMake();
            setCurrencyComboMake();
            doActionIBSheet(sheet1, form, IBSEARCH);
        }
    }
    /**
     * OnSearchEnd evnet handler after retrieving sheet1 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {string} errMsg : error message
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.20
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
        var form=document.form;
        if (errMsg == "" && sheet1.RowCount()> 0) {
            var chkPointCd="", chkPointNm=""; // 
            var pointRange, arrPointRange, startRng, endRng;
            var pointComboArrCd="=", pointComboArrNm=" "; 
            var startRow1=sheet1.HeaderRows();
            var endRow1=sheet1.HeaderRows()+ sheet1.RowCount();
            for(var k=startRow1; k < endRow1; k++) {
                // Creating Trans 
            	var pointCd=sheet1.GetCellValue(k, C1_POINT_O);
                setSheet1ComboNextMake("SEARCH", k, C1_POINT, pointCd, "");
                var transModeCd=sheet1.GetCellValue(k, C1_TRANSMODE_O);
//                sheet1.GetCellvalue2(k, C1_TRANSMODE)=transModeCd;
                sheet1.SetCellValue(k, C1_TRANSMODE, transModeCd);
                // Creating Term 
                setSheet1ComboNextMake("SEARCH", k, C1_TRANSMODE, transModeCd, "");
                var termCd=sheet1.GetCellValue(k, C1_TERM_O);
//                sheet1.GetCellvalue2(k, C1_TERM)=termCd;
                sheet1.SetCellValue(k, C1_TERM, termCd);
                // Creating Base Port 
                setSheet1ComboNextMake("SEARCH", k, C1_TERM, termCd, "");
                var basePortCd=sheet1.GetCellValue(k, C1_BASEPORT_O);
//                sheet1.GetCellvalue2(k, C1_BASEPORT)=basePortCd;
                sheet1.SetCellValue(k, C1_BASEPORT, basePortCd);
                // Creating Via 
                setSheet1ComboNextMake("SEARCH", k, C1_BASEPORT, basePortCd, "");
                var viaCd=sheet1.GetCellValue(k, C1_VIA_O);
//                sheet1.GetCellvalue2(k, C1_VIA)=viaCd;
                sheet1.SetCellValue(k, C1_VIA, viaCd);
                sheet1.SetRowStatus(k,"R");
            }
        }
    }
    /**
     * OnSearchEnd evnet handler after retrieving sheet2 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {string} errMsg : error message
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.24
     */
    function sheet2_OnSearchEnd(sheetObj, errMsg) {
        var form=document.form;
        if (errMsg == "") {
            if(sheet2.RowCount()> 0) {
                setEditAmtPer("SEARCH");
            }
        }
    }
    /**
     * OnSearchEnd evnet handler after retrieving sheet5 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {string} errMsg : error message
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.24
     */
    function sheet5_OnSearchEnd(sheetObj, errMsg) {
        var form=document.form;
        if (errMsg == "" && sheet5.RowCount()> 0) {
            doActionIBSheet6(sheet6, form, IBSEARCH); // getting Arbitrary to be applied to check duplication
        } else {
            ComShowCodeMessage('PRI00007'); // 'It can not be saved without input of detailed information.'
            ComOpenWait(false);
            return;
        }
        if (errMsg != "") {
            ComOpenWait(false);
        }
    }
    /**
     * OnSearchEnd evnet handler after retrieving sheet6 <br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     * </pre>
     * 
     * @param {IBSheet} sheetObj : Sheet Object
     * @param {string} errMsg : error message
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.24
     */
    function sheet6_OnSearchEnd(sheetObj, errMsg) {
        if (errMsg == "" && sheet6.RowCount()> 0) {
            setChkAppDupRow();
        } else {
            if (sheet6.RowCount()== 0) {
                ComShowCodeMessage("PRI01097"); // There is no arbitrary to apply GRI.
            }
            ComOpenWait(false);
        }
    }
    /**
     * sheet6_OnSaveEnd evnet handler after saving sheet6<br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     * </pre>
     * 
     * @param {IBSheet} sheetObj : Sheet Object
     * @param {string} ErrMsg : 
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.24
     */
    function sheet6_OnSaveEnd(sheetObj, ErrMsg)  {
        if (ErrMsg == "") {
            ComShowCodeMessage('PRI01072');
            ComPopUpReturnValue("OK");
        }else{
            ComOpenWait(false);
        }
    }
    /**
     * sheet1_OnComboChange evnet handler <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {IBSheet} Row 
     * @param  {IBSheet} Col 
     * @param  {IBSheet} Code
     * @param  {IBSheet} Text 
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.20
     */
    function sheet1_OnComboChange(sheetObj, Row, Col, Code, Text) {
        var form=document.form;
        var colName=sheet1.ColSaveName(Col);
        switch(colName) {
            case C1_APPLICATION:
            	var appValue=sheet1.GetCellValue(Row, colName).replace(/=/g,"").replace(/ /g,"");
                if(appValue == "E" || appValue == "") {
                    sheet2.RemoveAll();
                }
                break;
            case C1_POINT:     // Point Selection?
            case C1_TRANSMODE: // Trans Mode Selection?
            case C1_TERM:      // Term Selection?
            case C1_BASEPORT:  // Base Port Selection?
                ComOpenWait(true);
                setSheet1ComboNextMake("CHANGE", Row, colName, Code, Text);
                break;
        }
    }
    /**
     * Sheet2_Onchange function to check possibility of Per,Cargo type selection when changing sheet2, Per Cargo Type comboSelection<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {int} colName : Selected row
     * @param  {int} colCode
     * @param  {string} colText 
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.20
     */
    function sheet2_OnChange(sheetObj, Row, Col, Value) {
        var colName=sheetObj.ColSaveName(Col);
        var validPerClass="A,F,O,Q,S,P";
        switch(colName) {
            case "prc_cgo_tp_cd":
            	var ratUtCd=sheetObj.GetCellValue(Row, "rat_ut_cd");
                if (Value == "AK" && ( ComIsNull(ratUtCd) || validPerClass.indexOf(ratUtCd.charAt(0)) < 0 )) {
                     ComShowCodeMessage("PRI08003");
                     sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","",0);
                }
                break;
            case "rat_ut_cd":
            	if(sheetObj.GetCellValue(Row, "prc_cgo_tp_cd") == "AK" && ( ComIsNull(Value) || validPerClass.indexOf(Value.charAt(0)) < 0 )) {
                    ComShowCodeMessage("PRI08003");
                    sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","",0);
                }
                break;
        }
    }
    /**
     * sheet1_OnSelectCell evnet handler <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {Long} OldRow : previous selected Cell's Row Index
     * @param  {Long} OldCol : previous selected Cell's Column Index
     * @param  {Long} NewRow : current selected Cell's Row Index
     * @param  {Long} NewCol : current selected Cell's Column Index
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.18
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        if(!isSelectCell_1) {
            isSelectCell_1=true;
            return false;
        }
        var form=document.form;
        var oldGrpSeq=sheet1.GetCellValue(OldRow, C1_GRPSEQ);
        var newGrpSeq=sheet1.GetCellValue(NewRow, C1_GRPSEQ);
        if(OldRow < 0 || sheet1.GetRowStatus(OldRow) == "D"){
            setSheet1RowChanged(NewRow);
        }else{
            if( ( sheet1.IsDataModified()|| sheet2.IsDataModified()) && ( oldGrpSeq != newGrpSeq) ){
                if (ComShowCodeConfirm("PRI00006")){
                    isSelectCell_1=false;
                    sheet1.SelectCell(OldRow, OldCol, false);
                    isConfirmQestion=false;
                    doActionIBSheet2(sheet2, form, IBSAVE);
                    return false;
                }else{
                    isSelectCell_1=false;
                    sheet1.SelectCell(OldRow, OldCol, false);
                    return false;
                }
            }
            if( oldGrpSeq != newGrpSeq ) {
                setSheet1RowChanged(NewRow);
            }
        }
    }
    /**
     * sheet1_OnSort evnet handler <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {int} Col :sorted column idx
     * @param  {string} SortArrow : "ASC","DESC"
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.18
     */
    /*
function sheet1_OnSort(sheetObj, Col, SortArrow) {
    if( sheet1.RowCount()== 0 || sheet1.IsDataModified()) { return; }
var grpSeq=sheet1.GetCellValue(sheet1.GetSelectRow(), C1_GRPSEQ);
    var colName=sheet1.ColSaveName(Col);
    var curRow1=sheet1.GetSelectRow();
var curGetRowStatus1=sheet1.GetRowStatus(sheet1.GetSelectRow());
if( curGetRowStatus1 == "D" || curGetRowStatus1 == "I" ) {
        sheet2.RemoveAll();
    }else{
        setSheet1RowChanged(curRow1);
    }
}
     */
    /**
     * setSheet1RowChanged evnet handler <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {int} NewRow : new row
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.18
     */
    function setSheet1RowChanged(NewRow) {
        var form=document.form;
        gCurrRow1=NewRow;
        doActionIBSheet2(sheet2, form, IBSEARCH);
    }
    /**
     * Creating information for point combo by inputted point on Arbitray screen<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param N/A
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.20
     */
    function setPointComboMake() {
        var chkPointCd="", chkPointNm=""; 
        var pointRange, arrPointRange, startRng, endRng;
        var pointComboArrCd="=", pointComboArrNm=" "; 
        var startRow3=sheet3.HeaderRows();
        var endRow3=sheet3.HeaderRows()+ sheet3.RowCount();
        for(var k=startRow3; k < endRow3; k++) {
        	chkPointCd=sheet3.GetCellValue(k, C3_POINT);           // Point Cd
        	chkPointNm=sheet3.GetCellValue(k, C3_POINT_NM);        // Point Nm
            pointRange=sheet3.GetColSameDataRange(k, C3_POINT); 
            gArrPointRange[chkPointCd]=pointRange;             
            pointComboArrCd=pointComboArrCd + "|" + chkPointCd;
            pointComboArrNm=pointComboArrNm + "|" + chkPointCd + "\t" +chkPointNm;
            arrPointRange=pointRange.split("|");
            startRng=parseInt(arrPointRange[0],10);
            endRng=parseInt(arrPointRange[1],10);
            if(endRng > startRng) {
                k=k + (endRng - startRng);
            }
        }
        sheet1.SetColProperty(C1_POINT, {ComboText:pointComboArrNm, ComboCode:pointComboArrCd} );
    }
    /**
     * Creating information for Currency combo by inputted currency on Arbitray screen<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param N/A
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.20
     */
    function setCurrencyComboMake() {
        var chkCurrencyCd=""; 
        var currencyRange, arrCurrencyRange, startRng, endRng;
        var currencyComboArrCd="="; 
        var currencyComboArrNm=" "; 
        var startRow3=sheet3.HeaderRows();
        var endRow3=sheet3.HeaderRows()+ sheet3.RowCount();
        for(var k=startRow3; k < endRow3; k++) {
        	chkCurrencyCd=sheet3.GetCellValue(k, C3_CURRENCY);
            currencyRange=sheet3.GetColSameDataRange(k, C3_CURRENCY); 
            currencyComboArrCd=currencyComboArrCd + "|" + chkCurrencyCd;
            currencyComboArrNm=currencyComboArrNm + "|" + chkCurrencyCd;
            arrCurrencyRange=currencyRange.split("|");
            startRng=parseInt(arrCurrencyRange[0],10);
            endRng=parseInt(arrCurrencyRange[1],10);
            if(endRng > startRng) {
                k=k + (endRng - startRng);
            }
        }
        sheet2.SetColProperty(C2_CURRENCY, {ComboText:currencyComboArrNm, ComboCode:currencyComboArrCd} );
    }
    /**
     * Creating filtered combo by sheet3's point route information when selecting sheet1's combo<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {int} colRow     : row for creating combo
     * @param  {string} colName 
     * @param  {string} colCode 
     * @param  {string} colText 
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.20
     */
    function setSheet1ComboNextMake(mod, colRow, colName, colCode, colText) {
        setSheet1ComboInit(colRow, colName); 
        sheet4.SetCellValue(1, "f_text1","",0);
        var colCode=ComReplaceStr(colCode                               ,'=','');
        var thePointCd=ComReplaceStr(sheet1.GetCellValue(colRow, C1_POINT)    ,'=','');
        var theTransModeCd=ComReplaceStr(sheet1.GetCellValue(colRow, C1_TRANSMODE),'=','');
        var theTermCd=ComReplaceStr(sheet1.GetCellValue(colRow, C1_TERM)     ,'=','');
        var theBasePortCd=ComReplaceStr(sheet1.GetCellValue(colRow, C1_BASEPORT) ,'=','');
        if(thePointCd.length > 0 &&  undefined == gArrPointRange[thePointCd]) { // Checking Point Range 
            ComShowCodeMessage("PRI00308", "check", "Point Range."); 
            ComOpenWait(false);
            return;
        }
        var startRow=sheet3.HeaderRows();
        var endRow=sheet3.HeaderRows()+ sheet3.RowCount();
        if("" != thePointCd) {
            var arrRange=gArrPointRange[thePointCd].split("|"); // Point Range Filtering 
            startRow=parseInt(arrRange[0],10);
            endRow=parseInt(arrRange[1],10) + 1;
        }
        var chkFindNum;
        var tmpText;
        var chkPointCd, chkTransModeCd, chkTransNm, chkTermCd, chkTermNm, chkBasePortCd, chkBasePortNm, chkVIACd, chkVIANm;
        var compPointCd=thePointCd;
        var compTransModeCd=theTransModeCd;
        var compTermCd=theTermCd;
        var compBasePortCd=theBasePortCd;
        switch(colName) {
            case C1_POINT: //Setting Trans Mode combo when selecting point
                var keyPoint="[" + thePointCd + "]";
                var arrTransCd="=", arrTransNm=" ";
                if(undefined == gArrTransCob[keyPoint]) { //Creating trans combo by sheet3's point information if not exist Trans combo
                    for(var i=startRow; i < endRow; i++) {
                    	chkPointCd=sheet3.GetCellValue(i, C3_POINT); // point Mode Cd
                    	chkTransModeCd=sheet3.GetCellValue(i, C3_TRANSMODE); // Trans Mode Cd
                    	chkTransNm=sheet3.GetCellValue(i, C3_TRANSMODE_NM); // Trans Mode Nm
                        if("" == colCode) { compPointCd=chkPointCd; }
                        if( chkTransModeCd != "" && compPointCd == chkPointCd ) {
                            chkFindNum=sheet4.FindText("f_text1", "[" + chkTransModeCd + "]", 1, 2, true);
                            if(chkFindNum < 0){
                                // Creating Trans combo data
                                arrTransCd=arrTransCd + "|" + chkTransModeCd;
                                arrTransNm=arrTransNm + "|" + chkTransNm;
                                tmpText=sheet4.GetCellValue(1, "f_text1");
                                sheet4.SetCellValue(1, "f_text1",tmpText + "[" + chkTransModeCd + "]",0);
                            }
                        }
                    }
                    // Creating Trans combo information for reuse
                    gArrTransCob[keyPoint]=arrTransNm + "??" + arrTransCd;
                }
                var filterArrTrans=gArrTransCob[keyPoint].split("??");
                sheet1.CellComboItem(colRow,C1_TRANSMODE, {ComboText:filterArrTrans[0], ComboCode:filterArrTrans[1]} );
                sheet1.SetCellValue(colRow, C1_TRANSMODE," ",0);
                if(mod == "CHANGE") {
                    setSheet1ComboNextMake("CHANGE", colRow, C1_TRANSMODE, "", "");
                }
                break;
            case C1_TRANSMODE: // When selectin Trans Mode
                var keyTrans="[" + thePointCd + "][" + theTransModeCd + "]";
                var arrTermCd="=", arrTermNm=" ";
                if(undefined == gArrTermCob[keyTrans]) { // Creating Term combo by sheet3's point information if not exist Term combo
                    for(var i=startRow; i < endRow; i++) {
                    	chkPointCd=sheet3.GetCellValue(i, C3_POINT); // point Mode Cd
                    	chkTransModeCd=sheet3.GetCellValue(i, C3_TRANSMODE); // Trans Mode Cd
                    	chkTermCd=sheet3.GetCellValue(i, C3_TERM);        // Term Cd
                    	chkTermNm=sheet3.GetCellValue(i, C3_TERM_NM);     // Term Nm
                        if("" == thePointCd) { compPointCd=chkPointCd; }
                        if("" == colCode) { compTransModeCd=chkTransModeCd; }
                        if( chkTermCd != "" && compPointCd == chkPointCd && compTransModeCd == chkTransModeCd ) {
                            chkFindNum=sheet4.FindText("f_text1", "[" + chkTermCd + "]", 1, 2, true);
                            if(chkFindNum < 0){
                                // Creating Trans combo data
                                arrTermCd=arrTermCd + "|" + chkTermCd;
                                arrTermNm=arrTermNm + "|" + chkTermNm;
                                tmpText=sheet4.GetCellValue(1, "f_text1");
                                sheet4.SetCellValue(1, "f_text1",tmpText + "[" + chkTermCd + "]",0);
                            }
                        }
                    }
                    // Creating Trans combo information for reuse
                    gArrTermCob[keyTrans]=arrTermNm + "??" + arrTermCd;
                }
                var filterArrTerm=gArrTermCob[keyTrans].split("??");
                sheet1.CellComboItem(colRow,C1_TERM, {ComboText:filterArrTerm[0], ComboCode:filterArrTerm[1]} );
                sheet1.SetCellValue(colRow, C1_TERM," ",0);
                if(mod == "CHANGE") {
                    setSheet1ComboNextMake("CHANGE", colRow, C1_TERM, "", "");
                }
                break;
            case C1_TERM:      // When selecting Term
                var keyTerm="[" + thePointCd + "][" + theTransModeCd + "][" +theTermCd + "]";
                var arrBasePortCd="=", arrBasePortNm=" ";
                if(undefined == gArrBPortCob[keyTerm]) { //Creating Base Port combo by sheet3's  Point, Trans Mode, Term, Base Port information if not exist Term combo
                    for(var i=startRow; i < endRow; i++) {
                    	chkPointCd=sheet3.GetCellValue(i, C3_POINT); // point Mode Cd
                    	chkTransModeCd=sheet3.GetCellValue(i, C3_TRANSMODE); // Trans Mode Cd
                    	chkTermCd=sheet3.GetCellValue(i, C3_TERM);        // Term Cd
                    	chkBasePortCd=sheet3.GetCellValue(i, C3_BASEPORT);    // Base Port Cd
                    	chkBasePortNm=sheet3.GetCellValue(i, C3_BASEPORT_NM); // Base Port Nm
                        if("" == thePointCd) { compPointCd=chkPointCd; }
                        if("" == theTransModeCd) { compTransModeCd=chkTransModeCd; }
                        if("" == colCode) { compTermCd=chkTermCd; }
                        if( chkBasePortCd != "" && compPointCd == chkPointCd && compTransModeCd == chkTransModeCd && compTermCd == chkTermCd) {
                            chkFindNum=sheet4.FindText("f_text1", "[" + chkBasePortCd + "]", 1, 2, true);
                            if(chkFindNum < 0){
                               // Creating Trans combo data
                                arrBasePortCd=arrBasePortCd + "|" + chkBasePortCd;
                                arrBasePortNm=arrBasePortNm + "|" + chkBasePortCd + "\t" + chkBasePortNm;
                                tmpText=sheet4.GetCellValue(1, "f_text1");
                                sheet4.SetCellValue(1, "f_text1",tmpText + "[" + chkBasePortCd + "]",0);
                            }
                        }
                    }
                    // Creating Trans combo information for reuse
                    gArrBPortCob[keyTerm]=arrBasePortNm + "??" + arrBasePortCd;
                }
                var filterArrBport=gArrBPortCob[keyTerm].split("??");
                sheet1.CellComboItem(colRow,C1_BASEPORT, {ComboText:filterArrBport[0], ComboCode:filterArrBport[1]} );
                sheet1.SetCellValue(colRow, C1_BASEPORT," ",0);
                if(mod == "CHANGE") {
                    setSheet1ComboNextMake("CHANGE", colRow, C1_BASEPORT, "", "");
                }
                break;
            case C1_BASEPORT:     //When selecting Base Port
                var keyBPort="[" + thePointCd + "][" + theTransModeCd + "][" +theTermCd + "][" + theBasePortCd + "]";
                var arrVIACd="=", arrVIANm=" "; 
                if(undefined == gArrVIACob[keyBPort]) { //Creating VIA combo by sheet3's  Point, Trans Mode, Term, Base Port information if not exist VIA combo
                    for(var i=startRow; i < endRow; i++) {
                    	chkPointCd=sheet3.GetCellValue(i, C3_POINT); // point Mode Cd
                    	chkTransModeCd=sheet3.GetCellValue(i, C3_TRANSMODE); // Trans Mode Cd
                    	chkTermCd=sheet3.GetCellValue(i, C3_TERM);        // Term Cd
                    	chkBasePortCd=sheet3.GetCellValue(i, C3_BASEPORT);    // Base Port Cd
                    	chkVIACd=sheet3.GetCellValue(i, C3_VIA);    // VIA Cd
                    	chkVIANm=sheet3.GetCellValue(i, C3_VIA_NM); // VIA Nm
                        if("" == thePointCd){ compPointCd=chkPointCd; }
                        if("" == theTransModeCd) { compTransModeCd=chkTransModeCd; }
                        if("" == theTermCd) { compTermCd=chkTermCd; }
                        if("" == colCode) { compBasePortCd=chkBasePortCd; }
                        if( chkVIACd != "" && compPointCd == chkPointCd && compTransModeCd == chkTransModeCd && compTermCd == chkTermCd && compBasePortCd == chkBasePortCd ) {
                            chkFindNum=sheet4.FindText("f_text1", "[" + chkVIACd + "]", 1, 2, true);
                            if(chkFindNum < 0){
                                // Creating Trans combo data
                                arrVIACd=arrVIACd + "|" + chkVIACd;
                                arrVIANm=arrVIANm + "|" + chkVIACd + "\t" + chkVIANm;
                                tmpText=sheet4.GetCellValue(1, "f_text1");
                                sheet4.SetCellValue(1, "f_text1",tmpText + "[" + chkVIACd + "]",0);
                            }
                        }
                    }
                    // Creating Trans combo information for reuse
                    gArrVIACob[keyBPort]=arrVIANm + "??" + arrVIACd;
                }
                var filterArrVia=gArrVIACob[keyBPort].split("??");
                sheet1.CellComboItem(colRow,C1_VIA, {ComboText:filterArrVia[0], ComboCode:filterArrVia[1]} );
                sheet1.SetCellValue(colRow, C1_VIA," ",0);
                if(mod == "CHANGE") {
                    ComOpenWait(false);
                }
                break;
        }
    }
    /**
     * Initializing Sheet's combo by using Row and column name<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {int} colRow  : Selected row
     * @param  {string} colName : Selected Combo Name
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.20
     */
    function setSheet1ComboInit(colRow, colName) {
        switch(colName) {
            case C1_POINT: // Setting Term combo when selecting Point
                sheet1.CellComboItem(colRow,C1_TRANSMODE, {ComboText:"", ComboCode:"="} );
                sheet1.SetCellValue(colRow, C1_TRANSMODE," ",0);
                sheet1.CellComboItem(colRow,C1_TERM, {ComboText:"", ComboCode:"="} );
                sheet1.SetCellValue(colRow, C1_TERM," ",0);
                sheet1.CellComboItem(colRow,C1_BASEPORT, {ComboText:"", ComboCode:"="} );
                sheet1.SetCellValue(colRow, C1_BASEPORT," ",0);
                sheet1.CellComboItem(colRow,C1_VIA, {ComboText:"", ComboCode:"="} );
                sheet1.SetCellValue(colRow, C1_VIA," ",0);
                break;
            case C1_TRANSMODE:     // When selecting Trans Mode
                sheet1.CellComboItem(colRow,C1_TERM, {ComboText:"", ComboCode:"="} );
                sheet1.SetCellValue(colRow, C1_TERM," ",0);
                sheet1.CellComboItem(colRow,C1_BASEPORT, {ComboText:"", ComboCode:"="} );
                sheet1.SetCellValue(colRow, C1_BASEPORT," ",0);
                sheet1.CellComboItem(colRow,C1_VIA, {ComboText:"", ComboCode:"="} );
                sheet1.SetCellValue(colRow, C1_VIA," ",0);
                break;
            case C1_TERM:      // When selecting term Mode
                sheet1.CellComboItem(colRow,C1_BASEPORT, {ComboText:"", ComboCode:"="} );
                sheet1.SetCellValue(colRow, C1_BASEPORT," ",0);
                sheet1.CellComboItem(colRow,C1_VIA, {ComboText:"", ComboCode:"="} );
                sheet1.SetCellValue(colRow, C1_VIA," ",0);
                break;
            case C1_BASEPORT:     //// When selecting  Base Port
                sheet1.CellComboItem(colRow,C1_VIA, {ComboText:"", ComboCode:"="} );
                sheet1.SetCellValue(colRow, C1_VIA," ",0);
                break;
        }
    }
    /**
     *  Function to get grp seq value<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param N/A
     * @return {int} maxGrpSeq
     * @see #
     * @author 
     * @version 2009.08.24
     */
    function getMaxGrpSeq() {
        var maxGrpSeq=0;
        var chkGrpSeq=0;
        var startRow1=sheet1.HeaderRows();
        var endRow1=sheet1.HeaderRows()+ sheet1.RowCount();
        for(var k=startRow1; k < endRow1; k++) {
        	chkGrpSeq=parseInt(sheet1.GetCellValue(k, C1_GRPSEQ),10);
            if(chkGrpSeq > maxGrpSeq) { maxGrpSeq=chkGrpSeq; }
        }
        return maxGrpSeq + 1;
    }
    /**
     * Function to get Max adjustment sequence <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param N/A
     * @return {int} maxGrpSeq
     * @see #
     * @author 
     * @version 2009.08.24
     */
    function getMaxAdjSeq() {
        var maxAdjSeq=0;
        var chkAdjSeq=0;
        var startRow2=sheet2.HeaderRows();
        var endRow2=sheet2.HeaderRows()+ sheet2.RowCount();
        for(var k=startRow2; k < endRow2; k++) {
        	chkAdjSeq=parseInt(sheet2.GetCellValue(k, "gri_adj_seq"),10);
            if(chkAdjSeq > maxAdjSeq) { maxAdjSeq=chkAdjSeq; }
        }
        return maxAdjSeq + 1;
    }
    /**
     * Getting information whether row existing on sheet<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBSheet} sheetObj
     * @param {string} status : "", "I","U","D","R"
     * @return {boolean} tf
     * @see #
     * @author 
     * @version 2009.08.24
     */
    function getIsRowCount(sheetObj, status) {
        var tf=false;
        var rowCnt=0;
        if (null == "" == status || "" == status) {
            rowCnt=sheetObj.RowCount();
        }else{
            rowCnt = sheetObj.RowCount(status);
        }
        if(rowCnt > 0) tf=true;
        return tf;
    }
    /**
     * Function to get sheet's row count<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBSheet} sheetObj
     * @param {string} status : "", "I","U","D","R"
     * @return {boolean} tf
     * @see #
     * @author 
     * @version 2009.08.24
     */
    function getRows(sheetObj, status) {
        var rowCnt=0;
        if (null == "" == status || "" == status) {
            rowCnt=sheetObj.RowCount();
        }else{
            rowCnt = sheetObj.RowCount(status);
        }
        return rowCnt;
    }
    /**
     * Checking duplication to apply CreatingGRI Calculation - Arbitray and creating data<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param N/A
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.24
     */
    function setChkAppDupRow() {
        var form=document.form;
        var startRow5=sheet5.HeaderRows();
        var endRow5=sheet5.HeaderRows()+ sheet5.RowCount();
        var startRow6=sheet6.HeaderRows();
        var endRow6=sheet6.HeaderRows()+ sheet6.RowCount();
        var totalCnt=0;
        var calGrpSeq, calApplication, calApplOpt;
        var calAmt=0.00, calRto=0;
        var calKey, calTarget;
        var calPoint, calTransMode, calTerm, calBasePort, calVIA, calPer, calCargoType, calCurrency;
        var compPoint, compTransMode, compTerm, compBasePort, compVIA;
        var arbCnt=0;
        var arbAmdtSeq, arbProposal=0.00;
        var arbKey, arbTarget;
        var arbPoint, arbTransMode, arbTerm, arbBasePort, arbVIA, arbPer, arbCargoType, arbCurrency;
        var abrGriAmt=0.00, addAbrGriAmt=0.00;
        var chkApplication, excludeKey, excludeCompKey, exPoint, exTransMode, exTerm, exBasePort, exVIA;
        for(var i=startRow5; i < endRow5; i++) {
        	calGrpSeq=sheet5.GetCellValue(i, "gri_grp_seq");
        	calApplication=sheet5.GetCellValue(i, C5_APPLICATION);
            if(calApplication == "I") {
            	calApplOpt=sheet5.GetCellValue(i, C5_APPL_OPTION);
            	calAmt=parseFloat(sheet5.GetCellValue(i, C5_AMT));
            	calRto=parseInt(sheet5.GetCellValue(i, C5_RTO),10);
            	calPoint=sheet5.GetCellValue(i, C5_POINT);
            	calTransMode=sheet5.GetCellValue(i, C5_TRANSMODE);
            	calTerm=sheet5.GetCellValue(i, C5_TERM);
            	calBasePort=sheet5.GetCellValue(i, C5_BASEPORT);
            	calVIA=sheet5.GetCellValue(i, C5_VIA);
        		calPer=sheet5.GetCellValue(i, C5_PER);
        		calCargoType=sheet5.GetCellValue(i, C5_CARGOTYPE);
        		calCurrency=sheet5.GetCellValue(i, C5_CURRENCY);
                compPoint=calPoint    ;
                compTransMode=calTransMode;
                compTerm=calTerm     ;
                compBasePort=calBasePort ;
                compVIA=calVIA      ;
                for(var k=startRow6; k < endRow6; k++) {
                    var OK=false;
                    arbAmdtSeq=sheet6.GetCellValue(k, "amdt_seq");
                    arbCnt=sheet6.GetCellValue(k, "up_cnt");
                    arbProposal=parseInt(sheet6.GetCellValue(k, C6_PROPOSAL),10);
                    arbPoint=sheet6.GetCellValue(k, C6_POINT);
                    arbTransMode=sheet6.GetCellValue(k, C6_TRANSMODE);
                    arbTerm=sheet6.GetCellValue(k, C6_TERM);
                    arbBasePort=sheet6.GetCellValue(k, C6_BASEPORT);
                    arbVIA=sheet6.GetCellValue(k, C6_VIA);
                    arbPer=sheet6.GetCellValue(k, C6_PER);
                    arbCargoType=sheet6.GetCellValue(k, C6_CARGOTYPE);
                    arbCurrency=sheet6.GetCellValue(k, C6_CURRENCY);
                    if(calPoint == "") { compPoint=arbPoint; }
                    if(calTransMode == "") { compTransMode=arbTransMode; }
                    if(calTerm == "") { compTerm=arbTerm; }
                    if(calBasePort == "") { compBasePort=arbBasePort; }
                    if(calVIA == "") { compVIA=arbVIA; }
                    //Point, TransMode, Term, BasePort, Via filter
                    calKey=compPoint + compTransMode + compTerm + compBasePort + compVIA;
                    arbKey=arbPoint + arbTransMode + arbTerm + arbBasePort + arbVIA;
                    // Per, Cargo Type, Currency to be applied
                    calTarget=calPer + calCurrency;
                    arbTarget=arbPer + arbCurrency;
                    if(calKey == arbKey && calTarget == arbTarget) {
                        OK=true;
                        for(var e=startRow5; e < endRow5; e++) {
                        	chkApplication=sheet5.GetCellValue(e, C5_APPLICATION);
                            if(chkApplication == "E") {
                            	exPoint=sheet5.GetCellValue(e, C5_POINT);
                            	exTransMode=sheet5.GetCellValue(e, C5_TRANSMODE);
                            	exTerm=sheet5.GetCellValue(e, C5_TERM);
                            	exBasePort=sheet5.GetCellValue(e, C5_BASEPORT);
                            	exVIA=sheet5.GetCellValue(e, C5_VIA);
                                if(exPoint == "") { exPoint=arbPoint; }
                                if(exTransMode == "") { exTransMode=arbTransMode; }
                                if(exTerm == "") { exTerm=arbTerm; }
                                if(exBasePort == "") { exBasePort=arbBasePort; }
                                if(exVIA == "") { exVIA=arbVIA; }
                                excludeKey=exPoint + "_" + exTransMode + "_" + exTerm + "_" + exBasePort + "_" + exVIA;
                                excludeCompKey=arbPoint + "_" + arbTransMode + "_" + arbTerm + "_" + arbBasePort + "_" + arbVIA;
                                if(excludeKey == excludeCompKey) { 
                                    OK=false;
                                    break;
                                }else{
                                    OK=true;
                                }
                            }
                        }
                    }
                    if(OK) {
                        totalCnt++;
                        arbCnt++;
                        if(calApplOpt == "F") { // amt
                            addAbrGriAmt=parseFloat(calAmt);
                        }else{ // rto
                            addAbrGriAmt=arbProposal * (calRto / 100);
                        }
                        abrGriAmt=parseFloat(sheet6.GetCellValue(k, C6_GRI_AMT));
                        sheet6.SetCellValue(k, C6_GRI_AMT,abrGriAmt + addAbrGriAmt);
                        sheet6.SetCellValue(k, "up_cnt",arbCnt);
                        sheet6.SetCellValue(k, "gri_grp_seq",calGrpSeq);
                        sheet6.SetRowStatus(k,"U");
                    } // end OK
                } // end for Arbitrary
            } // end if(calApplication == "I")
        } // end for Calculation
        if(totalCnt == 0) {
            ComShowCodeMessage("PRI01097"); // There is no arbitrary to apply GRI.
            ComOpenWait(false);
            return;
        }
        doActionIBSheet6(sheet6, form, IBSAVE);
    }
    /**
     *  Setting Sheet2's cell editable property by Appcication Option<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param : applOpttion code
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.25
     */
    function setEditAmtPer(mod) {
        var form=document.form;
        var obj=form.rdo_appl_option;
        var rdoApplOptionValue=ComGetObjValue(obj);
        var startRow2=sheet2.HeaderRows();
        var endRow2=sheet2.HeaderRows()+ sheet2.RowCount();
        var isAmt=false;
        var amt, rto;
        if(mod == "SEARCH") {
            for(var i=startRow2; i < endRow2; i++ ) {
            	amt=sheet2.GetCellValue(i, C2_AMT);
            	rto=sheet2.GetCellValue(i, C2_RTO);
                if(amt == "") {
                    sheet2.SetCellEditable(i, C2_AMT,0);
                    sheet2.SetCellEditable(i, C2_RTO,1);
                } else {
                    isAmt=true;
                    sheet2.SetCellEditable(i, C2_AMT,1);
                    sheet2.SetCellEditable(i, C2_RTO,0);
                }
                sheet2.SetCellValue(i, "flt_pct_tp_cd",rdoApplOptionValue,0);
                sheet2.SetRowStatus(i,"R");
            }
            if(isAmt){
                obj[0].checked=true;
            }else{
                obj[1].checked=true;
            }
        }else if(mod == "CLICK"){
            for(var i=startRow2; i < endRow2; i++ ) {
                if(rdoApplOptionValue == "F") {
                    sheet2.SetCellEditable(i, C2_AMT,1);
                    sheet2.SetCellEditable(i, C2_RTO,0);
                    sheet2.SetCellValue(i, C2_RTO,"",0);
                } else {
                    sheet2.SetCellEditable(i, C2_AMT,0);
                    sheet2.SetCellEditable(i, C2_RTO,1);
                    sheet2.SetCellValue(i, C2_AMT,"",0);
                }
                sheet2.SetCellValue(i, "flt_pct_tp_cd",rdoApplOptionValue,0);
            }
        }else if(mod == "ROWADD") {
            if(rdoApplOptionValue == "F") {
                sheet2.SetCellEditable(sheet2.GetSelectRow(), C2_AMT,1);
                sheet2.SetCellEditable(sheet2.GetSelectRow(), C2_RTO,0);
            } else {
                sheet2.SetCellEditable(sheet2.GetSelectRow(), C2_AMT,0);
                sheet2.SetCellEditable(sheet2.GetSelectRow(), C2_RTO,1);
            }
            sheet2.SetCellValue(sheet2.GetSelectRow(), "flt_pct_tp_cd",rdoApplOptionValue,0);
        }
    }
    /**
     * Controlling button by mode<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param : mod : user defined variable
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.25
     */
    function setButtonControl(mod) {
        var form=document.form;
        if(mod == "OK") {
            sheet1.SetCountFormat("[Apply : No]  " + sheet1.GetCountFormat());
            sheet1.SetEditable(1);
            sheet2.SetEditable(1);
            ComEnableObject(form.rdo_appl_option[0], true);
            ComEnableObject(form.rdo_appl_option[1], true);
            ComBtnEnable("btn_RowAdd");
            ComBtnEnable("btn_RowCopy");
            ComBtnEnable("btn_Delete");
            ComBtnEnable("btn_RowAdd2");
            ComBtnEnable("btn_RowCopy2");
            ComBtnEnable("btn_Delete2");
            ComBtnEnable("btn_Save2");
            ComBtnEnable("btn_OK");
        } else if (mod == "CANCEL") {
            sheet1.SetCountFormat("[Apply : Yes] " + sheet1.GetCountFormat());
            sheet1.SetEditable(0);
            sheet2.SetEditable(0);
            ComBtnEnable("btn_Cancle");
        } else {
            sheet1.SetEditable(0);
            sheet2.SetEditable(0);
            ComEnableObject(form.rdo_appl_option[0], false);
            ComEnableObject(form.rdo_appl_option[1], false);
            ComBtnDisable("rdo_appl_option");
            ComBtnDisable("btn_RowAdd");
            ComBtnDisable("btn_RowCopy");
            ComBtnDisable("btn_Delete");
            ComBtnDisable("btn_RowAdd2");
            ComBtnDisable("btn_RowCopy2");
            ComBtnDisable("btn_Delete2");
            ComBtnDisable("btn_Save2");
            ComBtnDisable("btn_OK");
            ComBtnDisable("btn_Cancle");
        }
    }
    /**
     * Function to call Retrieving/Saving server function<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {object} formObj : form Object
     * @param  {sAction} sAction
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.18
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheet1.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH: // Retrieving upper grid 
                formObj.f_cmd.value=SEARCH;
                var sXml = sheet1.DoSearch("ESM_PRI_0109GS.do", FormQueryString(formObj) );
                break;
            case IBINSERT: //Row Add
            case IBCOPYROW: //Row copy
                if(getRows(sheet1, "R|U|I") == 0 && sAction == IBCOPYROW) { return; } // Prohibiting from copying in case of no row
                if ( getRows(sheet1, "R|U|I") != 0 ) { //checking in case of row exits
                    if ( sheet1.IsDataModified()|| sheet2.IsDataModified()) {
                        if (ComShowCodeConfirm("PRI00006")) { // 'Data was changed. Do you want to save?';
                            doActionIBSheet2(sheet2, form, IBSAVE);
                        }
                        return;
                    }
                    if ( sheet1.IsDataModified()&& getRows(sheet2, "R|U|I") == 0 ) {
                        ComShowCodeMessage('PRI00007'); // 'It can not be saved without input of detailed information.';
                        return;
                    }
                }
                isSelectCell_1=false;
                sheet2.RemoveAll();
                if(sAction == IBINSERT) {
                    ComOpenWait(true);
                    var idx=sheet1.DataInsert();
                    sheet1.SetCellValue(idx, "prop_no",formObj.prop_no.value,0);
                    sheet1.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value,0);
                    sheet1.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value,0);
                    sheet1.SetCellValue(idx, "org_dest_tp_cd",formObj.org_dest_tp_cd.value,0);
                    sheet1.SetCellValue(idx, C1_GRPSEQ,getMaxGrpSeq(),0);
                    setSheet1ComboNextMake("CHANGE", idx, C1_POINT, "", "");
                    isSelectCell_1=false;
                    sheet1.SelectCell(idx, C1_APPLICATION, false);
                    ComOpenWait(false);
                    break;
                }else if(sAction == IBCOPYROW){
                    var idx=sheet1.DataCopy();
                    sheet1.SetCellValue(idx, C1_GRPSEQ,getMaxGrpSeq(),0);
                    isSelectCell_1=false;
                    sheet1.SelectCell(idx, C1_APPLICATION, false);
                }
                break;
            case IBDELETE: //Delete
                if(getRows(sheet1, "R|U|I") == 0) { //Prohibiting from deleting in case of no row
                    return false;
                }
                var iCnt=0;
                var eCnt=0;
                if( sheet1.GetCellValue(sheet1.GetSelectRow(), C1_APPLICATION) == "I" ){
                    var sRow=sheet1.FindStatusRow("R|U|I");
                    var arrRow=sRow.split(";");
                    for (var idx=0; idx < arrRow.length-1; idx++){
                    	if(sheet1.GetCellValue(arrRow[idx], C1_APPLICATION) == "I"){
                            iCnt++;
                    	}else if(sheet1.GetCellValue(arrRow[idx], C1_APPLICATION) == "E"){
                            eCnt++;
                        }
                    }
                }
                if(iCnt == 1 && eCnt > 0){
                    return false;
                }
                var delCnt=deleteRowCheck(sheet1, "chk", true);
                if(sheet1.GetRowStatus(sheet1.GetSelectRow()) == "D") {
                    sheet2.RemoveAll();
                }
                break;
            case IBSAVE: //Save
                ComOpenWait(true);
                formObj.f_cmd.value=MULTI; //7
                var sParam=FormQueryString(formObj);
                var sParamSheet1=sheet1.GetSaveString();
                if (sParamSheet1 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
                }
                var sParamSheet2=sheet2.GetSaveString();
                if (sParamSheet2 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                }
                var sXml=sheetObj.GetSaveData("ESM_PRI_0109GS.do", sParam);
                sheet2.LoadSaveData(sXml);
                sXml=ComDeleteMsg(sXml);
                sheet1.LoadSaveData(sXml);
                if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
                    ComShowCodeMessage('PRI00101');
                }
                ComOpenWait(false);
                break;
        }
    }
    /**
     * Function to call Retrieving/Saving server function<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {object} formObj
     * @param  {sAction} sAction
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.18
     */
    function doActionIBSheet2(sheetObj, formObj, sAction) {
        sheet2.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH: 
                formObj.f_cmd.value=SEARCH01; // Retrieving lower grid
                var griGrpSeq=sheet1.GetCellValue(gCurrRow1, C1_GRPSEQ);
                ComOpenWait(true);
                var sXml = sheet2.DoSearch("ESM_PRI_0109GS.do", FormQueryString(formObj) + "&gri_grp_seq=" + griGrpSeq );
                ComOpenWait(false);
                break;
            case IBINSERT: //Row Add
            case IBCOPYROW: //Row copy
            	if (sheet1.RowCount()==0) break;
            	var appValue= sheet1.GetCellValue(sheet1.GetSelectRow(), C1_APPLICATION).replace(/ /g,"").replace(/=/g,"");
                if(appValue == "E" || appValue == "") {
                    return;
                }
                var sheet1GriGrpSeq=sheet1.GetCellValue(sheet1.GetSelectRow(), C1_GRPSEQ);
                if( getRows(sheet1, "R|U|I") ==0 || sheet1.GetRowStatus(sheet1.GetSelectRow()) == "D" || undefined == sheet1GriGrpSeq || "" == sheet1GriGrpSeq || null == sheet1GriGrpSeq ) {
                    ComShowCodeMessage('PRI00007'); // 'It can not be saved without input of detailed information.';
                    return;
                }
                var idx=sheet2.HeaderRows();
                if(sAction == IBINSERT) {
                    idx=sheet2.DataInsert();
                    sheet2.SetCellValue(idx, "prop_no",formObj.prop_no.value,0);
                    sheet2.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value,0);
                    sheet2.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value,0);
                    sheet2.SetCellValue(idx, "org_dest_tp_cd",formObj.org_dest_tp_cd.value,0);
                    setEditAmtPer("ROWADD");
                }else if(sAction == IBCOPYROW){
                    idx=sheet2.DataCopy();
                }
                sheet2.SetCellValue(idx, "gri_grp_seq",sheet1.GetCellValue(sheet1.GetSelectRow(), C1_GRPSEQ),0);
                sheet2.SetCellValue(idx, "gri_adj_seq",getMaxAdjSeq(),0);
                sheet2.SelectCell(idx, C2_PER);
                break;
            case IBDELETE: //Delete
                if(getRows(sheet2, "R|U|I") == 0) { return; } // Probihiting from deleting in case of no row
                deleteRowCheck(sheet2, "chk", true);
                break;
            case IBSAVE: //Save
                if(!sheet1.IsDataModified()&& !sheet2.IsDataModified()){
                    return;
                }
                if (!validateForm(sheet1, form, IBSAVE)) { return false; }
                if (!validateForm(sheet2, form, IBSAVE)) { return false; }
                if(isConfirmQestion){
                    if (ComPriConfirmSave()) {
                        doActionIBSheet(sheet1, form, IBSAVE);
                    }
                }else{
                    doActionIBSheet(sheet1, form, IBSAVE);
                }
                isConfirmQestion=true;
                break;
        }
    }
    /**
     * Function to call Retrieving/Saving server function <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {object} formObj : form Object
     * @param  {sAction} sAction
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.18
     */
    function doActionIBSheet3(sheetObj, formObj, sAction) {
        sheet3.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH: 
                formObj.f_cmd.value=SEARCH02;
                var pGriGrpSeq=sheet1.GetCellValue(sheet1.GetSelectRow(), C1_GRPSEQ);
                var orgDestTpCd=form.org_dest_tp_cd.value;
                var sXml = sheet3.DoSearch("ESM_PRI_0109GS.do", FormQueryString(formObj) + "&gri_grp_seq=" + pGriGrpSeq + "&org_dest_tp_cd=" + orgDestTpCd );
                break;
        }
    }
    /**
     * Function to call Retrieving/Saving server function <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {object} formObj : form Object
     * @param  {sAction} sAction 
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.18
     */
    function doActionIBSheet5(sheetObj, formObj, sAction) {
        sheet5.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH: 
                sheet5.RemoveAll();
                formObj.f_cmd.value=SEARCH03;
                ComOpenWait(true);
                sheet5.DoSearch("ESM_PRI_0109GS.do", FormQueryString(formObj) );
                break;
        }
    }
    /**
     * ?Function to call Retrieving/Saving server function <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {object} formObj : form Object
     * @param  {sAction} sAction 
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.18
     */
    function doActionIBSheet6(sheetObj, formObj, sAction) {
        sheet6.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH: 
                sheet6.RemoveAll();
                formObj.f_cmd.value=SEARCH04; // Getting Arbitrary to check duplication
                sheet6.DoSearch("ESM_PRI_0109GS.do", FormQueryString(formObj) );
                break;
            case IBSAVE:
                formObj.f_cmd.value=MULTI02;
                var sParamSheet6=sheet6.GetSaveString();
                if (sheet6.IsDataModified()&& sParamSheet6 == "") {
                    ComShowCodeMessage("PRI01097"); // There is no arbitrary to apply GRI.
                    ComOpenWait(false);
                    return;
                }
                var sXml=sheet6.GetSaveData("ESM_PRI_0109GS.do", FormQueryString(formObj) + "&" + sParamSheet6);
                sheet6.LoadSaveData(sXml);
                break;
            case IBDELETE:
                ComOpenWait(true);
                formObj.f_cmd.value=MULTI03;
                sheet6.RemoveAll();
                var idx=sheet6.DataInsert();
                sheet6.SetRowStatus(idx,"U");
                sheet6.SetCellValue(idx, "prop_no",formObj.prop_no.value);
                sheet6.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value);
                sheet6.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
                sheet6.SetCellValue(idx, "add_chg_tp_cd",formObj.add_chg_tp_cd.value);
                sheet6.SetCellValue(idx, "org_dest_tp_cd",formObj.org_dest_tp_cd.value);
                var sParamSheet6=sheet6.GetSaveString();
                var sXml=sheet6.GetSaveData("ESM_PRI_0109GS.do", FormQueryString(formObj) + "&" + sParamSheet6);
                sheet6.LoadSaveData(sXml);
                break;
        }
    }
    /**
     * handling process for input validation<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {object} formObj 
     * @param  {sAction} sAction
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.18
     */
    function validateForm(sheetObj, formObj, sAction){
        var form=document.form;
        var sheetID=sheetObj.id;
        if(sheetID == "sheet1") { // upper grid
            switch (sAction) {
                case IBSAVE: 
                    var currRow1=sheet1.GetSelectRow();
                    var isNewRow1=-1;
                    var isAddExclude=false;
                    var chkApplication;
                    var startRow=sheet1.HeaderRows();
                    var endRow=sheet1.HeaderRows()+ sheet1.RowCount();
                    for(var i=startRow; i < endRow; i++ ) {
                    	if(sheet1.GetRowStatus(i) != "D") {
                    		if(sheet1.GetRowStatus(i) == "I") { isNewRow1=i ;}
                    		chkApplication=ComReplaceStr(sheet1.GetCellValue(i, C1_APPLICATION).replace(/ /g,""),"=","");
                            if(chkApplication == "") {
                                ComShowCodeMessage("PRI00337", "Application");
                                isSelectCell_1=false;
                                sheet1.SelectCell(i, C1_APPLICATION);
                                return false;
                            }
                            if(chkApplication == "I"){
                                isAddExclude=true;
                            }
                        }
                    }
                    if(getIsRowCount(sheet1, "R|U|I") && !isAddExclude){
                        ComShowCodeMessage("PRI04007", "Include");
                        sheet1.SelectCell(sheet1.GetSelectRow(), C1_APPLICATION);
                        return false;
                    }
                    if( isNewRow1 > -1 && (currRow1 != isNewRow1) ) {
                        ComShowCodeMessage('PRI00007'); //msgs['PRI00007']='It can not be saved without input of detailed information.';
                        return false;
                    }
                    return true;
                    break;
            } // end switch
        } // if end - sheet1
        else if(sheetID == "sheet2") { // lower grid
            switch (sAction) {
                case IBSAVE: 
                    var rdoFltPctTpCdValue=ComGetObjValue(formObj.rdo_appl_option);
                    var sheet1AppVal= sheet1.GetCellValue(sheet1.GetSelectRow(), C1_APPLICATION).replace(/ /g,"").replace(/=/g,"");
                    if(sheet1AppVal == "E") {
                        return true;
                    }
                    if( sheet1AppVal == "I" && getIsRowCount(sheet1, "R|U|I") && !getIsRowCount(sheet2, "R|U|I") ) {
                        ComShowCodeMessage('PRI00007'); //msgs['PRI00007']='It can not be saved without input of detailed information.';
                        return false;
                    }
                    if (sheet2.IsDataModified()) {
                        var chkPer, chkCargoType, chkCurrency, chkAMT, chkRTO;
                        var startRow2=sheet2.HeaderRows();
                        var endRow2=sheet2.HeaderRows()+ sheet2.RowCount();
                        for(var i=startRow2; i < endRow2; i++ ) {
                        	if(sheet2.GetRowStatus(i) != "D") {
                        		chkPer=ComReplaceStr(sheet2.GetCellValue(i, C2_PER).replace(/ /g,""),"=","");
//                                chkCargoType = ComReplaceStr(sheet2.CellValue(i, C2_CARGOTYPE).replace(/ /g,"").replace(/=/g,""),"=","");
                        		chkCurrency=ComReplaceStr(sheet2.GetCellValue(i, C2_CURRENCY).replace(/ /g,"").replace(/=/g,""),"=","");
                        		chkAMT=sheet2.GetCellValue(i, C2_AMT);
                        		chkRTO=sheet2.GetCellValue(i, C2_RTO);
                                if(chkPer == "") {
                                    ComShowCodeMessage("PRI00337", "Per");
                                    sheet2.SelectCell(i, C2_PER);
                                    return false;
                                }
//                                if(chkCargoType == "") {
//                                    ComShowCodeMessage("PRI00337", "Cargo Type");
//                                    sheet2.SelectCell(i, C2_CARGOTYPE);
//                                    return false;
//                                }
                                if(chkCurrency == 0) {
                                    ComShowCodeMessage("PRI00337", "Currency");
                                    sheet2.SelectCell(i, C2_CURRENCY);
                                    return false;
                                }
                                if( rdoFltPctTpCdValue == "F" && (chkAMT == 0 || chkAMT == "" ) ) {
                                    ComShowCodeMessage("PRI00337", "GRI Amount");
                                    sheet2.SelectCell(i, C2_AMT, true);
                                    return false;
                                }
                                if( rdoFltPctTpCdValue == "P" && (chkRTO == 0 || chkRTO == "" ) ) {
                                    ComShowCodeMessage("PRI00337", "Percentage");
                                    sheet2.SelectCell(i, C2_RTO, true);
                                    return false;
                                }
                            } // end if D
                        } // end for
                    } // end if sheet2.IsDataModified()
                    return true;
                    break;
            } // end switch
        } // end else if
    }
