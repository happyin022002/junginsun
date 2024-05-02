/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0225.js
*@FileTitle  : Agreement Rate Correction
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/

var _errMsg = '';

/**
 * Define the initial values and headers of sheets
 * European S/O
 */
function initSheet(sheetObj, sheetNo) {
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];  
    var cnt = 0;

    switch(sheetNo) {
        case 1: // sheet0 init ( ATMT Header ) Hidden Sheet
            with(sheetObj) {
                var HeadTitle1="AGMT CITY CODE|AGMT NO|VNDR_SEQ|VNDR_NM|CONTRACT OFFICE CODE|REFERENCE NUMBER|PIC NAME|REMARK|CREATION OFFICE|CREATION USER" ;
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [
                    {Type:"Text", Hidden:0, Width:100, Align:"Left", ColMerge:1, SaveName:"trsp_agmt_ofc_cty_cd", KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:10 },
                    {Type:"Text", Hidden:0, Width:100, Align:"Left", ColMerge:1, SaveName:"trsp_agmt_seq",        KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:10 },
                    {Type:"Text", Hidden:0, Width:100, Align:"Left", ColMerge:1, SaveName:"vndr_prmry_seq",       KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:10 },
                    {Type:"Text", Hidden:0, Width:100, Align:"Left", ColMerge:1, SaveName:"vndr_prmry_nm",        KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:10 },
                    {Type:"Text", Hidden:0, Width:100, Align:"Left", ColMerge:1, SaveName:"ctrt_ofc_cd",          KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:10 },
                    {Type:"Text", Hidden:0, Width:100, Align:"Left", ColMerge:1, SaveName:"agmt_ref_no",          KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:10 },
                    {Type:"Text", Hidden:0, Width:100, Align:"Left", ColMerge:1, SaveName:"agmt_pic_nm",          KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:10 },
                    {Type:"Text", Hidden:0, Width:100, Align:"Left", ColMerge:1, SaveName:"inter_rmk",            KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:10 },
                    {Type:"Text", Hidden:0, Width:100, Align:"Left", ColMerge:1, SaveName:"cre_ofc_cd",           KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:10 },
                    {Type:"Text", Hidden:0, Width:100, Align:"Left", ColMerge:1, SaveName:"cre_usr_id",           KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:10 }
                ];
                InitColumns(cols);
                SetEditable(1);
                SetHeaderRowHeight(25);
                SetVisible(false);
            }
            break;

        case 2: // sheet1 init ( Child S/P )
            with(sheetObj) {
                var HeadTitle1="SEQ|Child Service\nProvider|Child Service\nProvider" ;
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [
                    {Type:"Seq",  Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:"",         KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:0 },
                    {Type:"Text", Hidden:0, Width:60, Align:"Center", ColMerge:1, SaveName:"vndr_seq", KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:10 },
                    {Type:"Text", Hidden:0, Width:40, Align:"Left",   ColMerge:1, SaveName:"vndr_nm",  KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:100 }
                ];
                InitColumns(cols);
                SetEditable(1);
                SetHeaderRowHeight(25);
                SetSheetHeight(85, 1);
                SetCountPosition(0);
            }
            break;

        case 3: // sheet2 init ( Rate )
            with(sheetObj) {
                var HeadTitle1="|Seq|Container Verification Result|Container Verification Result|Duplication|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type" +
                               "|From|From|Via|Via|Door|Door|To|To|Currency" +
                               "|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size" +
                               "|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size" +
                               "|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size" +
                               "|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size" +
                               "|One Way\n(CY rate)|Round Trip\n(DR rate)|Feeder Term|Feeder Term|No of\nContainer|Weight\nTier|UOM|Reverse|COA|Effective Date|Effective Date|UDU" +
                               "|UDU2" ;
                var HeadTitle2="|Seq|Status|Description|Duplication|Cost\nMode|Trans\nMode|T/Ship|Cargo\nType|Cargo\nNature|Customer\nCode|Commodity\nGroup Code|Rail Service\nType" +
                               "|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Currency" +
                               "|ALAL|DAL|RAL|AAL|FAL|TAL|SAL|OAL|PAL|AL2" +
                               "|AL4|AL5|AL7|AL9|D2|D4|D5|D7|R2|R4" +
                               "|R5|R7|A2|A4|F2|F4|F5|T2|T4|S2" +
                               "|S4|O2|O4|P2|P4" +
                               "|One Way\n(CY rate)|Round Trip\n(DR rate)|Receiving|Delivery|No of\nContainer|Weight\nTier|UOM|Reverse|COA|From|To|UDU" +
                               "|UDU2" ;
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol: 5 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center" }, { Text:HeadTitle2, Align:"Center" } ];
                InitHeaders(headers, info);
                var cols = [
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"chk",                    KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1 },
                    {Type:"Seq",      Hidden:0, Width:40,  Align:"Right",  ColMerge:1, SaveName:"ui_seqno",               KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"Status",   Hidden:0, Width:45,  Align:"Center", ColMerge:1, SaveName:"ibflag",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:0 },
                    {Type:"Text",     Hidden:0, Width:170, Align:"Left",   ColMerge:1, SaveName:"rlt",                    KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:200 },
                    {Type:"Text",     Hidden:0, Width:90,  Align:"Left",   ColMerge:1, SaveName:"rlt2",                   KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:200 },

                    {Type:"Combo",    Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"trsp_cost_mod_cd",       KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"agmt_trsp_tp_cd",        KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"trsp_bnd_cd",            KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1 },
                    {Type:"Combo",    Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"cgo_tp_cd",              KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"spcl_cgo_cntr_tp_cd",    KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10},
                    {Type:"Text",     Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"cust_cd",                KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"Text",     Hidden:0, Width:80,  Align:"Center", ColMerge:1, SaveName:"cmdt_grp_cd",            KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:6 },
                    {Type:"Combo",    Hidden:0, Width:90,  Align:"Center", ColMerge:1, SaveName:"rail_svc_tp_cd",         KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },

                    {Type:"Text",     Hidden:0, Width:50,  Align:"Center", ColMerge:1, SaveName:"fm_nod_cd",              KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"fm_nod_yd",              KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Text",     Hidden:0, Width:50,  Align:"Center", ColMerge:1, SaveName:"via_nod_cd",             KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"via_nod_yd",             KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Text",     Hidden:0, Width:50,  Align:"Center", ColMerge:1, SaveName:"dor_nod_cd",             KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"dor_nod_yd",             KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Text",     Hidden:0, Width:50,  Align:"Center", ColMerge:1, SaveName:"to_nod_cd",              KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"to_nod_yd",              KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"curr_cd",                KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },

                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_alal",                KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_dal",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_ral",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_aal",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_fal",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_tal",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_sal",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_oal",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_pal",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al2",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al4",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al5",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al7",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al9",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_d2",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_d4",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_d5",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_d7",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_r2",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_r4",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_r5",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_r7",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_a2",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_a4",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_f2",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_f4",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_f5",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_t2",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_t4",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_s2",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_s4",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_o2",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_o4",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_p2",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_p4",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },

                    {Type:"Float",    Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"trsp_one_wy_rt",         KeyField:0, CalcLogic:"", Format:"NullFloat",   PointCount:3, UpdateEdit:1, InsertEdit:1, EditLen:18 },
                    {Type:"Float",    Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"trsp_rnd_rt",            KeyField:0, CalcLogic:"", Format:"NullFloat",   PointCount:3, UpdateEdit:1, InsertEdit:1, EditLen:18 },
                    {Type:"Combo",    Hidden:0, Width:62,  Align:"Center", ColMerge:1, SaveName:"wtr_rcv_term_cd",        KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1 },
                    {Type:"Combo",    Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"wtr_de_term_cd",         KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1 },
                    {Type:"Int",      Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"trsp_agmt_bdl_qty",      KeyField:0, CalcLogic:"", Format:"NullInteger", PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"Text",     Hidden:0, Width:60,  Align:"Right",  ColMerge:1, SaveName:"to_wgt",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:9 },
                    {Type:"Combo",    Hidden:0, Width:50,  Align:"Center", ColMerge:1, SaveName:"wgt_meas_ut_cd",         KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"Combo",    Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_rvs_aply_flg",      KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"CheckBox", Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"agmt_cost_flg",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"eff_fm_dt",              KeyField:0, CalcLogic:"", Format:"Ymd",         PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"eff_to_dt",              KeyField:0, CalcLogic:"", Format:"Ymd",         PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Text",     Hidden:0, Width:100, Align:"Left",   ColMerge:1, SaveName:"usr_def_rmk",            KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:500 },

                    {Type:"CheckBox", Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"ck_vf",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"Text",     Hidden:1, Width:150, Align:"Center", ColMerge:1, SaveName:"org_eqtype",             KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:200 }, 
                    {Type:"CheckBox", Hidden:1, Width:30,  Align:"Center", ColMerge:1, SaveName:"chk2",                   KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1 },

                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_ofc_cty_cd",   KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:6 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_rt_tp_ser_no", KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:4 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_nod_seq",      KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12},
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_rt_seq",       KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12},
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"org_usr_def_rmk",        KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:500},
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"rownum",      	          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:500},

                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_alal_rt_seq",         KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_dal_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_ral_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_aal_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_fal_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_tal_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_sal_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_oal_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_pal_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_al2_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_al4_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_al5_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_al7_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_al9_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_d2_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_d4_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_d5_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_d7_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_r2_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_r4_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_r5_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_r7_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_a2_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_a4_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_f2_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_f4_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_f5_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_t2_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_t4_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_s2_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_s4_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_o2_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_o4_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_p2_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_p4_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:150, Align:"Center", ColMerge:1, SaveName:"org_rt_seq",             KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1000 }
                ];
                InitColumns(cols);
                SetEditable(1);
                SetColProperty('trsp_cost_mod_cd',  {ComboText:"|"+trsp_cost_mod_cdCode, ComboCode:"|"+trsp_cost_mod_cdCode} );
                SetColProperty('agmt_trsp_tp_cd',   {ComboText:"|"+agmt_trsp_tp_cdCode,  ComboCode:"|"+agmt_trsp_tp_cdCode} );
                SetColProperty('trsp_bnd_cd',       {ComboText:"|Y|N",        ComboCode:"|Y|N"} );
                SetColProperty('cgo_tp_cd',         {ComboText:"|"+cgo_tp_cdCode,        ComboCode:"|"+cgo_tp_cdCode} );
                SetColProperty('spcl_cgo_cntr_tp_cd', {ComboText:"|"+spcl_cgo_cntr_tp_cdCode,        ComboCode:"|"+spcl_cgo_cntr_tp_cdCode} );
                SetColProperty('rail_svc_tp_cd',    {ComboText:"|"+rail_svc_tp_cdCode,   ComboCode:"|"+rail_svc_tp_cdCode} );
                SetColProperty('curr_cd',           {ComboText:"|"+curr_cdCode,          ComboCode:"|"+curr_cdCode} );
                SetColProperty('wtr_rcv_term_cd',   {ComboText:"|"+wtr_term_cdCode,      ComboCode:"|"+wtr_term_cdCode} );
                SetColProperty('wtr_de_term_cd',    {ComboText:"|"+wtr_term_cdCode,      ComboCode:"|"+wtr_term_cdCode} );
                SetColProperty('wgt_meas_ut_cd',    {ComboText:"|KGS|LBS",               ComboCode:"|KGS|LBS"} );
                SetColProperty('trsp_rvs_aply_flg', {ComboText:"|Y|N",                   ComboCode:"|Y|N"} );
                SetColProperty("cust_cd",           {AcceptKeys:"E|[0123456789]",        InputCaseSensitive:1});
                SetColProperty("dor_nod_cd",        {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("dor_nod_yd",        {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("fm_nod_cd",         {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("fm_nod_yd",         {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("via_nod_cd",        {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("via_nod_yd",        {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("to_nod_cd",         {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("to_nod_yd",         {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                document.form.header_row.value = HeaderRows() - 1;
                SetRangeBackColor(1, 1, 1, 70, "#555555");
                SetSheetHeight(230);
            }
            break;

        case 4: // sheet3 init ( Rate )
            with(sheetObj) {
                var HeadTitle1="|Seq|Chassis Verification Result|Chassis Verification Result|Duplication|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type" +
                               "|From|From|Via|Via|Door|Door|To|To|Currency" +
                               "|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size" +
                               "|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size" +
                               "|One Way\n(CY rate)|Round Trip\n(DR rate)|Feeder Term|Feeder Term|No of\nChassis|Weight\nTier|UOM|Reverse|COA|Effective Date|Effective Date|UDU" +
                               "|UDU2";
                var HeadTitle2="|Seq|Status|Description|Duplication|Cost\nMode|Trans\nMode|Cargo\nType|Customer\nCode|Commodity\nGroup Code|Rail Service\nType" +
                               "|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Currency" +
                               "|ALAL|SFAL|SLAL|TAAL|GNAL|EGAL|AL2|AL4|AL5|AL8" +
                               "|SF2|SF4|SL2|TA2|GN4|GN5|EG5|EG8|ZT4|CB4" +
                               "|One Way\n(CY rate)|Round Trip\n(DR rate)|Receiving|Delivery|No of\nChassis|Weight\nTier|UOM|Reverse|COA|From|To|UDU" +
                               "|UDU2" ;
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol: 5 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center" }, { Text:HeadTitle2, Align:"Center" } ];
                InitHeaders(headers, info);
                var cols = [
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"chk",                    KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1 },
                    {Type:"Seq",      Hidden:0, Width:40,  Align:"Right",  ColMerge:1, SaveName:"ui_seqno",               KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"Status",   Hidden:0, Width:45,  Align:"Center", ColMerge:1, SaveName:"ibflag",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:0 },
                    {Type:"Text",     Hidden:0, Width:170, Align:"Left",   ColMerge:1, SaveName:"rlt",                    KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:200 },
                    {Type:"Text",     Hidden:0, Width:90,  Align:"Left",   ColMerge:1, SaveName:"rlt2",                   KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:200 },

                    {Type:"Combo",    Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"trsp_cost_mod_cd",       KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"agmt_trsp_tp_cd",        KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:1, Width:40,  Align:"Center", ColMerge:1, SaveName:"cgo_tp_cd",              KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"cust_cd",                KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"Text",     Hidden:1, Width:80,  Align:"Center", ColMerge:1, SaveName:"cmdt_grp_cd",            KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:6 },
                    {Type:"Combo",    Hidden:1, Width:90,  Align:"Center", ColMerge:1, SaveName:"rail_svc_tp_cd",         KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },

                    {Type:"Text",     Hidden:0, Width:50,  Align:"Center", ColMerge:1, SaveName:"fm_nod_cd",              KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"fm_nod_yd",              KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Text",     Hidden:1, Width:50,  Align:"Center", ColMerge:1, SaveName:"via_nod_cd",             KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:1, Width:40,  Align:"Center", ColMerge:1, SaveName:"via_nod_yd",             KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Text",     Hidden:1, Width:50,  Align:"Center", ColMerge:1, SaveName:"dor_nod_cd",             KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:1, Width:40,  Align:"Center", ColMerge:1, SaveName:"dor_nod_yd",             KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Text",     Hidden:0, Width:50,  Align:"Center", ColMerge:1, SaveName:"to_nod_cd",              KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"to_nod_yd",              KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"curr_cd",                KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },

                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_alal",                KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_sfal",                KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_slal",                KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_taal",                KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_gnal",                KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_egal",                KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al2",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al4",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al5",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al8",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_sf2",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_sf4",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_sl2",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_ta2",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_gn4",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_gn5",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_eg5",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_eg8",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_zt4",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_cb4",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },

                    {Type:"Float",    Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"trsp_one_wy_rt",         KeyField:0, CalcLogic:"", Format:"NullFloat",   PointCount:3, UpdateEdit:1, InsertEdit:1, EditLen:18 },
                    {Type:"Float",    Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"trsp_rnd_rt",            KeyField:0, CalcLogic:"", Format:"NullFloat",   PointCount:3, UpdateEdit:1, InsertEdit:1, EditLen:18 },
                    {Type:"Combo",    Hidden:0, Width:62,  Align:"Center", ColMerge:1, SaveName:"wtr_rcv_term_cd",        KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1 },
                    {Type:"Combo",    Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"wtr_de_term_cd",         KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1 },
                    {Type:"Int",      Hidden:0, Width:60,  Align:"Right",  ColMerge:1, SaveName:"trsp_agmt_bdl_qty",      KeyField:0, CalcLogic:"", Format:"NullInteger", PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Right",  ColMerge:1, SaveName:"to_wgt",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:9 },
                    {Type:"Text",     Hidden:1, Width:50,  Align:"Center", ColMerge:1, SaveName:"wgt_meas_ut_cd",         KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"Combo",    Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_rvs_aply_flg",      KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"CheckBox", Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"agmt_cost_flg",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"eff_fm_dt",              KeyField:0, CalcLogic:"", Format:"Ymd",         PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"eff_to_dt",              KeyField:0, CalcLogic:"", Format:"Ymd",         PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Text",     Hidden:0, Width:100, Align:"Left",   ColMerge:1, SaveName:"usr_def_rmk",            KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:500 },

                    {Type:"CheckBox", Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"ck_vf",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"Text",     Hidden:1, Width:150, Align:"Center", ColMerge:1, SaveName:"org_eqtype",             KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:200 },
                    {Type:"CheckBox", Hidden:1, Width:0,   Align:"Center", ColMerge:1, SaveName:"chk2",                   KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1 },

                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_ofc_cty_cd",   KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:6 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_rt_tp_ser_no", KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:4 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_nod_seq",      KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12},
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_rt_seq",       KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12},
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"org_usr_def_rmk",        KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:500},

                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_alal_rt_seq",         KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_sfal_rt_seq",         KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_slal_rt_seq",         KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_taal_rt_seq",         KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_gnal_rt_seq",         KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_egal_rt_seq",         KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_al2_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_al4_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_al5_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_al8_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_sf2_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_sf4_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_sl2_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_ta2_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_gn4_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_gn5_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_eg5_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_eg8_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_gt4_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_cb4_rt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:150, Align:"Center", ColMerge:1, SaveName:"org_rt_seq",             KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1000 }
                ];
                InitColumns(cols);
                SetEditable(1);
                SetColProperty('trsp_cost_mod_cd',  {ComboText:"|"+trsp_cost_mod_cdCode, ComboCode:"|"+trsp_cost_mod_cdCode} );
                SetColProperty('agmt_trsp_tp_cd',   {ComboText:"|"+agmt_trsp_tp_cdCode,  ComboCode:"|"+agmt_trsp_tp_cdCode} );
                SetColProperty('cgo_tp_cd',         {ComboText:"|"+cgo_tp_cdCode,        ComboCode:"|"+cgo_tp_cdCode} );
                SetColProperty('rail_svc_tp_cd',    {ComboText:"|"+rail_svc_tp_cdCode,   ComboCode:"|"+rail_svc_tp_cdCode} );
                SetColProperty('curr_cd',           {ComboText:"|"+curr_cdCode,          ComboCode:"|"+curr_cdCode} );
                SetColProperty('wtr_rcv_term_cd',   {ComboText:"|"+wtr_term_cdCode,      ComboCode:"|"+wtr_term_cdCode} );
                SetColProperty('wtr_de_term_cd',    {ComboText:"|"+wtr_term_cdCode,      ComboCode:"|"+wtr_term_cdCode} );
                SetColProperty('wgt_meas_ut_cd',    {ComboText:"|KGS|LBS",               ComboCode:"|KGS|LBS"} );
                SetColProperty('trsp_rvs_aply_flg', {ComboText:"|Y|N",                   ComboCode:"|Y|N"} );
                SetColProperty("cust_cd",           {AcceptKeys:"E|[0123456789]",        InputCaseSensitive:1});
                SetColProperty("dor_nod_cd",        {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("dor_nod_yd",        {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("fm_nod_cd",         {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("fm_nod_yd",         {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("via_nod_cd",        {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("via_nod_yd",        {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("to_nod_cd",         {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("to_nod_yd",         {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                document.form.header_row.value = HeaderRows() - 1;
                SetSheetHeight(230);
                SetRangeBackColor(1, 1, 1, 60, "#555555");
            }
            break;

        case 5:
            with(sheetObj) {
                var HeadTitle1="|Seq|Genset Verification Result|Genset Verification Result|Duplication|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type" +
                               "|From|From|Via|Via|Door|Door|To|To|Currency" +
                               "|EQ Type/Size|EQ Type/Size|EQ Type/Size" +
                               "|One Way\n(CY rate)|Round Trip\n(DR rate)|Feeder Term|Feeder Term|No of\nGenset|Weight\nTier|UOM|Reverse|COA|Effective Date|Effective Date|UDU";
                var HeadTitle2="|Seq|Status|Description|Duplication|Cost\nMode|Trans\nMode|Cargo\nType|Customer\nCode|Commodity\nGroup Code|Rail Service\nType" +
                               "|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Currency" +
                               "|ALAL|CG|UG" +
                               "|One Way\n(CY rate)|Round Trip\n(DR rate)|Receiving|Delivery|No of\nGenset|Weight\nTier|UOM|Reverse|COA|From|To|UDU";
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol:5 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center" }, { Text:HeadTitle2, Align:"Center" } ];
                InitHeaders(headers, info);
                var cols = [
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"chk",                    KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1 },
                    {Type:"Seq",      Hidden:0, Width:40,  Align:"Right",  ColMerge:1, SaveName:"ui_seqno",               KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"Status",   Hidden:0, Width:45,  Align:"Center", ColMerge:1, SaveName:"ibflag",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:0 },
                    {Type:"Text",     Hidden:0, Width:170, Align:"Left",   ColMerge:1, SaveName:"rlt",                    KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:200 },
                    {Type:"Text",     Hidden:0, Width:90,  Align:"Left",   ColMerge:1, SaveName:"rlt2",                   KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:200 },

                    {Type:"Combo",    Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"trsp_cost_mod_cd",       KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"agmt_trsp_tp_cd",        KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:1, Width:40,  Align:"Center", ColMerge:1, SaveName:"cgo_tp_cd",              KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"cust_cd",                KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"Text",     Hidden:1, Width:80,  Align:"Center", ColMerge:1, SaveName:"cmdt_grp_cd",            KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:6 },
                    {Type:"Combo",    Hidden:1, Width:90,  Align:"Center", ColMerge:1, SaveName:"rail_svc_tp_cd",         KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },

/*010*/             {Type:"Text",     Hidden:0, Width:50,  Align:"Center", ColMerge:1, SaveName:"fm_nod_cd",              KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"fm_nod_yd",              KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Text",     Hidden:1, Width:50,  Align:"Center", ColMerge:1, SaveName:"via_nod_cd",             KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:1, Width:40,  Align:"Center", ColMerge:1, SaveName:"via_nod_yd",             KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Text",     Hidden:1, Width:50,  Align:"Center", ColMerge:1, SaveName:"dor_nod_cd",             KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:1, Width:40,  Align:"Center", ColMerge:1, SaveName:"dor_nod_yd",             KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Text",     Hidden:0, Width:50,  Align:"Center", ColMerge:1, SaveName:"to_nod_cd",              KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"to_nod_yd",              KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"Combo",    Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"curr_cd",                KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },

                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_alal",                KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
/*020*/             {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_cg",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_ug",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },

                    {Type:"Float",    Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"trsp_one_wy_rt",         KeyField:0, CalcLogic:"", Format:"NullFloat",   PointCount:3, UpdateEdit:1, InsertEdit:1, EditLen:18 },
                    {Type:"Float",    Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"trsp_rnd_rt",            KeyField:0, CalcLogic:"", Format:"NullFloat",   PointCount:3, UpdateEdit:1, InsertEdit:1, EditLen:18 },
                    {Type:"Combo",    Hidden:0, Width:62,  Align:"Center", ColMerge:1, SaveName:"wtr_rcv_term_cd",        KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1 },
                    {Type:"Combo",    Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"wtr_de_term_cd",         KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1 },
                    {Type:"Int",      Hidden:1, Width:60,  Align:"Right",  ColMerge:1, SaveName:"trsp_agmt_bdl_qty",      KeyField:0, CalcLogic:"", Format:"NullInteger", PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Right",  ColMerge:1, SaveName:"to_wgt",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:9 },
                    {Type:"Text",     Hidden:1, Width:50,  Align:"Center", ColMerge:1, SaveName:"wgt_meas_ut_cd",         KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"Combo",    Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_rvs_aply_flg",      KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"CheckBox", Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"agmt_cost_flg",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
/*030*/             {Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"eff_fm_dt",              KeyField:0, CalcLogic:"", Format:"Ymd",         PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"eff_to_dt",              KeyField:0, CalcLogic:"", Format:"Ymd",         PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Text",     Hidden:0, Width:100, Align:"Left",   ColMerge:1, SaveName:"usr_def_rmk",            KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:500 },

                    {Type:"CheckBox", Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"ck_vf",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"Text",     Hidden:1, Width:150, Align:"Center", ColMerge:1, SaveName:"org_eqtype",             KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:200 },
                    {Type:"CheckBox", Hidden:1, Width:0,   Align:"Center", ColMerge:1, SaveName:"chk2",                   KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1 },

                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_ofc_cty_cd",   KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:6 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_rt_tp_ser_no", KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:4 },
/*040*/             {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_nod_seq",      KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12},
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_rt_seq",       KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12},
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"org_usr_def_rmk",        KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:500},
                    
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_alal_rt_seq",         KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_cg_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_ug_rt_seq",           KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12, HeaderCheck:0 },
                    {Type:"Text",     Hidden:1, Width:150, Align:"Center", ColMerge:1, SaveName:"org_rt_seq",             KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1000 }
                ];
                InitColumns(cols);
                SetEditable(1);
                SetColProperty('trsp_cost_mod_cd',  {ComboText:"|"+trsp_cost_mod_cdCode, ComboCode:"|"+trsp_cost_mod_cdCode} );
                SetColProperty('agmt_trsp_tp_cd',   {ComboText:"|"+agmt_trsp_tp_cdCode,  ComboCode:"|"+agmt_trsp_tp_cdCode} );
                SetColProperty('cgo_tp_cd',         {ComboText:"|"+cgo_tp_cdCode,        ComboCode:"|"+cgo_tp_cdCode} );
                SetColProperty('rail_svc_tp_cd',    {ComboText:"|"+rail_svc_tp_cdCode,   ComboCode:"|"+rail_svc_tp_cdCode} );
                SetColProperty('curr_cd',           {ComboText:"|"+curr_cdCode,          ComboCode:"|"+curr_cdCode} );
                SetColProperty('wtr_rcv_term_cd',   {ComboText:"|"+wtr_term_cdCode,      ComboCode:"|"+wtr_term_cdCode} );
                SetColProperty('wtr_de_term_cd',    {ComboText:"|"+wtr_term_cdCode,      ComboCode:"|"+wtr_term_cdCode} );
                SetColProperty('wgt_meas_ut_cd',    {ComboText:"|KGS|LBS",               ComboCode:"|KGS|LBS"} );
                SetColProperty('trsp_rvs_aply_flg', {ComboText:"|Y|N",                   ComboCode:"|Y|N"} );
                SetColProperty("cust_cd",           {AcceptKeys:"E|[0123456789]",        InputCaseSensitive:1});
                SetColProperty("dor_nod_cd",        {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("dor_nod_yd",        {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("fm_nod_cd",         {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("fm_nod_yd",         {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("via_nod_cd",        {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("via_nod_yd",        {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("to_nod_cd",         {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("to_nod_yd",         {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                document.form.header_row.value = HeaderRows() - 1;
                SetSheetHeight(230);
                SetRangeBackColor(1, 1, 1, 60,"#555555");
            }
            break;

        case 6: // VERIFY & UPDATE RETURN
            with(sheetObj) {
                var HeadTitle1="Num|Chk|Status|Description|Duplication|Chk2";
                var HeadTitle2="Num|Chk|Status|Description|Duplication|Chk2";
                SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [
                    {Type:"Int",      Hidden:0, Width:30,  Align:"Right",  ColMerge:1, SaveName:"row_num",      KeyField:0, CalcLogic:"", Format:"NullInteger", PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:10 },
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"chk",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:0, InsertEdit:0 },
                    {Type:"Status",   Hidden:0, Width:45,  Align:"Center", ColMerge:1, SaveName:"ibflag",       KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:0 },
                    {Type:"Text",     Hidden:0, Width:170, Align:"Left",   ColMerge:1, SaveName:"rlt",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:200 },
                    {Type:"Text",     Hidden:0, Width:70,  Align:"Left",   ColMerge:1, SaveName:"rlt2",         KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:200 },
                    {Type:"CheckBox", Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"ck_vf",        KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:8 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_tmp_seq", KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:50 }
                ];
                InitColumns(cols);
                SetEditable(1);
                SetVisible(0);
            }
            break;
    }
}

/**
 * Setting sheets and initialization 
 * Implementing the onLoad event handler of body tag
 * Adding the preceding function after loading page
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++) {
        ComConfigSheet(sheetObjects[i] ); 
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]); 
    }
    for(k=0;k<tabObjects.length;k++) {
        initTab(tabObjects[k],k+1);
        tabObjects[k].SetSelectedIndex(-1);
    }
    DoSearch("");
    var paramEqKndCdVal = document.form.parm_eq_knd_cd.value;
    if (paramEqKndCdVal == 'U' || paramEqKndCdVal == "") {
        tabObjects[0].SetSelectedIndex(0);
    } else if (paramEqKndCdVal == 'Z') {
        tabObjects[0].SetSelectedIndex(1);
    } else {
        tabObjects[0].SetSelectedIndex(2);
    }
}

/*------------------ Defining general java script function   ------------------*/

/* General global variable */
var openWindownm='AGMT';
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
var Mincount=0;
var CurRowCount=0;

var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=0;
var currenttab=0;
// is retrieved by sheet object index number
var isSheetRetrieved=new Array();
isSheetRetrieved[2] = false;
isSheetRetrieved[3] = false;
isSheetRetrieved[4] = false;

/* Branch processing event handler with the name of button */
function processButtonClick() {
    var sheetObject=sheetObjects[0];
    var sheetObject1=sheetObjects[1];
    var sheetObject2=sheetObjects[2];
    var sheetObject3=sheetObjects[3];
    /*******************************************************/
    var formObject=document.form;
    var rate_sheetObject=sheetObjects[2]; //Agreement Rate information
    if (currenttab == 0) {
        rate_sheetObject=sheetObjects[2]; //Agreement Rate information
    } else if (currenttab == 1) {
        rate_sheetObject=sheetObjects[3]; //Agreement Rate information
    } else {
        rate_sheetObject=sheetObjects[4]; //Agreement Rate information
    }

    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
        case "btn_retrieve":
            if (currenttab == 0) {
                formObject.cur_page_cnt1.value=1;
            }else if (currenttab == 1) {
                formObject.cur_page_cnt2.value=1;
            }else{
                formObject.cur_page_cnt3.value=1;
            }
            formObject.cur_page_cnt.value=1;
            doActionIBSheet(rate_sheetObject,formObject,"RETRIEVE");
            break;
        case "btn_minimize":
            Mincount=(Mincount+1)%2;
            Minimize(Mincount);
            break;
        case "btn_Close":
            ComClosePopup();
            break;
        case "reward1":
            var ipageNo=formObject.cur_page_cnt1.value;
            ipageNo--;
            if(Number(ipageNo) < 1) {
                var errMessage=ComGetMsg('TRS90351','','','');  
                ComShowMessage(errMessage);
                break;
            }  
            formObject.cur_page_cnt1.value=ipageNo;
            doActionIBSheet(rate_sheetObject,formObject,"RETRIEVE");
            break;
        case "forward1":
            var ipageNo=formObject.cur_page_cnt1.value;
            var totpage=formObject.tot_page_cnt1.value;
            ipageNo++;  
            if( (Number(ipageNo) > Number(formObject.tot_page_cnt1.value)) || totpage < 1) {
                var errMessage=ComGetMsg('TRS90351','','','');  
                ComShowMessage(errMessage);
                break;
            }
            formObject.cur_page_cnt1.value=ipageNo;
            doActionIBSheet(rate_sheetObject,formObject,"RETRIEVE"); 
            break;
        case "reward2":
            var ipageNo=formObject.cur_page_cnt2.value;
            ipageNo--;
            if(Number(ipageNo) < 1) {
                var errMessage=ComGetMsg('TRS90351','','','');  
                ComShowMessage(errMessage);
                break;
            }  
            formObject.cur_page_cnt2.value=ipageNo;
            doActionIBSheet(rate_sheetObject,formObject,"RETRIEVE");
            break;
        case "forward2":
            var ipageNo=formObject.cur_page_cnt2.value;
            var totpage=formObject.tot_page_cnt2.value;
            ipageNo++;  
            if( (Number(ipageNo) > Number(formObject.tot_page_cnt1.value)) || totpage < 1) {
                var errMessage=ComGetMsg('TRS90351','','','');  
                ComShowMessage(errMessage);
                break;
            }               
            formObject.cur_page_cnt2.value=ipageNo;
            doActionIBSheet(rate_sheetObject,formObject,"RETRIEVE"); 
            break;
        case "reward3":
            var ipageNo=formObject.cur_page_cnt3.value;
            ipageNo--;
            if(Number(ipageNo) < 1) {
                var errMessage=ComGetMsg('TRS90351','','','');  
                ComShowMessage(errMessage);
                break;
            }  
            formObject.cur_page_cnt3.value=ipageNo;
            doActionIBSheet(rate_sheetObject,formObject,"RETRIEVE");
            break;
        case "forward3":
            var ipageNo=formObject.cur_page_cnt3.value;
            var totpage=formObject.tot_page_cnt3.value;
            ipageNo++;  
            if( (Number(ipageNo) > Number(formObject.tot_page_cnt3.value)) || totpage < 1) {
                var errMessage=ComGetMsg('TRS90351','','','');
                ComShowMessage(errMessage);
                break;
            }
            formObject.cur_page_cnt3.value=ipageNo;
            doActionIBSheet(rate_sheetObject,formObject,"RETRIEVE");
            break;
        case "btng_loadexcel":
            doActionIBSheet(rate_sheetObject,formObject,IBLOADEXCEL);
        break;
        case "btng_downexcel":
            var sheet2_count=rate_sheetObject.RowCount();
            if(sheet2_count > 0){
                doActionIBSheet(rate_sheetObject,formObject,IBDOWNEXCEL);
            }
            break;
        case "btng_reset":
            if (currenttab == 0) {
                reset_all1();
            }else if (currenttab == 1) {
                reset_all2();
            }else{
                reset_all3();
            }
        break;
        case "btng_verify":
            if (currenttab == 0) {
                valcheck_two1(rate_sheetObject);
            }else if (currenttab == 1) {
                valcheck_two2(rate_sheetObject);
            }else{
                valcheck_two3(rate_sheetObject);
            }
        break;
        case "btng_update":
            if (currenttab == 0) {
                update1(rate_sheetObject);
            }else if (currenttab == 1) {
                update2(rate_sheetObject);
            }else{
                update3(rate_sheetObject);
            }
        break;
        case "btng_delete": //Removing RATE 
        	doActionIBSheet(rate_sheetObject, formObject, IBDELETE, "");
        break;
        case "btng_calendar1":
            getCalendar1();
        break;
        case "btng_calendar2":
            getCalendar2();
        break;
        case "btng_calendar3":
            getCalendar3();
        break;
        case "btng_date_apply1":
            date_apply(rate_sheetObject, "1");
        break;
        case "btng_date_apply2":
            date_apply(rate_sheetObject, "2");
        break;
        case "btng_date_apply3":
            date_apply(rate_sheetObject, "3");
        break;
        case "btng_scaling":
            var cre_ofc_cd=formObject.fm_account_ofc_cd.value;        
            var choice_cre_ofc_cd=sheetObject.GetCellValue(1, "cre_ofc_cd");
            rat_caling(rate_sheetObject);

            break;
        case "btng_rowadd":
            doActionIBSheet(rate_sheetObject,formObject,IBINSERT);
        break;
        case "btng_help":
            openHelp();
        break;
        case "btns_frmnode": //FromNode Popup
            openHireYardPopup('getFromNode');
        break;
        case "btns_vianode": //ViaNode Popup
            openHireYardPopup('getViaNode');
        break;
        case "btns_tonode": //ToNode Popup
            openHireYardPopup('getToNode');
        break;
        case "btns_dornode": //DoorLocation Popup
            openHireYardPopup('getDorLoc');
        break;
        case "btng_history":
            openRateHistory(rate_sheetObject);
            break;
        } // end switch
    } catch(e) {
        if( e == "[object Error]") {
            ComShowCodeMessage('TRS90031');
        } else {
            ComShowMessage(e.message);
        }
    }
}

function comPopupOK() {
    var opener = window.dialogArguments;
    if (!opener) opener = window.opener;
    if (!opener) opener = parent;
    if (!opener) {
        opener.callBack();
    }
}
 
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    var formObject=document.form;
    var x1="";
    switch(sAction) {
    case IBSEARCH:
        formObj.f_cmd.value=SEARCH01;
        sheetObjects[0].DoSearch("ESD_TRS_0220GS.do", TrsFrmQryString(formObj) );
         formObj.f_cmd.value=SEARCH02;
        sheetObjects[1].DoSearch("ESD_TRS_0220GS.do", TrsFrmQryString(formObj) );
        break;
    case "RETRIEVE":
        formObj.f_cmd.value=SEARCH02;
        if (currenttab == 0) {
            formObject.cur_page_cnt.value=formObject.cur_page_cnt1.value;
            formObject.tot_page_cnt.value=formObject.tot_page_cnt1.value;
            formObject.page_size.value=formObject.page_size1.value;
        }else if (currenttab == 1) {
            formObject.cur_page_cnt.value=formObject.cur_page_cnt2.value;
            formObject.tot_page_cnt.value=formObject.tot_page_cnt2.value;
            formObject.page_size.value=formObject.page_size2.value;
        }else{
            formObject.cur_page_cnt.value=formObject.cur_page_cnt3.value;
            formObject.tot_page_cnt.value=formObject.tot_page_cnt3.value;
            formObject.page_size.value=formObject.page_size3.value;
        }
         sheetObj.DoSearch("ESD_TRS_0226GS.do", TrsFrmQryString(formObject) );
        break;
    case IBDOWNEXCEL:
        if(sheetObj.RowCount() < 1){//no data
            ComShowCodeMessage("COM132501");
            }else{
                sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObj), CheckBoxOnValue:'Y', CheckBoxOffValue:'N', SheetDesign:1, Merge:1 });
            }
        
        break;
    case IBLOADEXCEL:
        var agmtno=formObj.fm_agmtno.value;
        var ctrt_ofc_cd=formObj.fm_ctrt_ofc_cd.value;
        if(sheetObjects[0].RowCount()== 0) {
             ComShowCodeMessage('TRS90081');
            return;
        }
        if(agmtno !="" && ctrt_ofc_cd !=""){
            CurRowCount = sheetObj.RowCount()+ sheetObj.HeaderRows();

            sheetObj.SetWaitImageVisible(0);
             sheetObj.LoadExcel({Append:1} );
             for(var i=sheetObj.RowCount()+ sheetObj.HeaderRows(); i >= sheetObj.HeaderRows(); i--){
                 if(sheetObj.GetCellValue(i, "trsp_cost_mod_cd") == ""){
                    sheetObj.RowDelete(i, false);
                }
            }
        }else{
            ComShowCodeMessage('TRS90081');
        }
        break;
    case IBDELETE:
        if( sheetObj.CheckedRows("chk") < 1 ) {
            errMsg=ComGetMsg("TRS90036");
            ComShowMessage(errMsg);
            return false;
        } else {
            eq_delete_ui(sheetObj, "chk");
            if( sheetObj.CheckedRows("chk") < 1 ) return false;
//            formObj.f_cmd.value=REMOVE;
//            sheetObj.DoSave("ESD_TRS_0221GS.do", TrsFrmQryString(formObj), -1, false, true);
        }
        break;
    case IBINSERT:
        var row=0;
        if(sheetObjects[0].RowCount()== 0) {
            ComShowCodeMessage('TRS90081');
            return;
        }
        row=sheetObj.DataInsert(-1);
        sheetObj.SetCellValue(row,'ck_vf',1,0);
        sheetObj.SetCellValue(row,'chk',1,0);
        var fm_eff_fm_dt="";
        var fm_eff_to_dt="";
        if (currenttab == 0) {
            fm_eff_fm_dt=formObj.fm_eff_fm_dt1.value;
            fm_eff_to_dt=formObj.fm_eff_to_dt1.value;
        }else if (currenttab == 1) {
            fm_eff_fm_dt=formObj.fm_eff_fm_dt2.value;
            fm_eff_to_dt=formObj.fm_eff_to_dt2.value;
        }else{
            fm_eff_fm_dt=formObj.fm_eff_fm_dt3.value;
            fm_eff_to_dt=formObj.fm_eff_to_dt3.value;
        }
        sheetObj.SetCellValue(row,"eff_fm_dt",fm_eff_fm_dt,0);
        sheetObj.SetCellValue(row,"eff_to_dt",fm_eff_to_dt,0);

        if (currenttab == 0) {
            if(sheetObj.GetCellValue(row, "trsp_cost_mod_cd").substring(0, 1) == "W" || sheetObj.GetCellValue(row, "trsp_cost_mod_cd").substring(1, 2) == "W") {
                sheetObj.SetCellEditable(row, "trsp_bnd_cd", 1);
                sheetObj.SetCellValue(row, "trsp_bnd_cd", "Y", 0);
            } else {
                sheetObj.SetCellValue(row, "trsp_bnd_cd", "", 0);
                sheetObj.SetCellEditable(row, "trsp_bnd_cd", 0);
            }
        }

        break;
    }
}

function DoSearch() {
    var sheetObject = sheetObjects[0];
    var formObject = document.form;
    doActionIBSheet(sheetObject, formObject, IBSEARCH, "", "");
}

/**
 * Onkeydown event
 */
function gotopage() {
    var formObject=document.form;
    var tot_page="";
    var cur_page="";
    var rate_sheetObject=sheetObjects[2]; //Agreement Rate information
    if (currenttab == 0) {
        rate_sheetObject=sheetObjects[2]; //Agreement Rate information
        cur_page=formObject.cur_page_cnt1.value;
        tot_page=formObject.tot_page_cnt1.value;
    } else if (currenttab == 1) {
        rate_sheetObject=sheetObjects[3]; //Agreement Rate information
        cur_page=formObject.cur_page_cnt2.value;
        tot_page=formObject.tot_page_cnt2.value;
    } else {
        rate_sheetObject=sheetObjects[4]; //Agreement Rate information
        cur_page=formObject.cur_page_cnt3.value;
        tot_page=formObject.tot_page_cnt3.value;
    }
    
    if( (Number(cur_page) > Number(tot_page)) || tot_page < 1) {
        var errMessage=ComGetMsg('TRS90351', '', '', '');  
        ComShowMessage(errMessage);
        return;
    }
    doActionIBSheet(rate_sheetObject,formObject,"RETRIEVE"); 
}

/**
 * Register IBSheet Object with array
 * call from comSheetObject(id)
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * Setting Tab 
 * Setting the Items of Tab 
*/
function initTab(tabObj , tabNo) {
    switch(tabNo) {
        case 1:
            with (tabObj) {
                var cnt=0 ;
                InsertItem("Container", "");
                InsertItem("Chassis",   "");
                InsertItem("Genset",    "");
            }
            break;
    }
}

/**
  * Registering IBTab Object as array
*/
function setTabObject(tab_obj) {
    tabObjects[tabCnt++]=tab_obj;
}

/**
  * Event clicking a tab
  * Activating the selected tab 
*/
function tab1_OnChange(tabObj , nItem) {
    var objs=document.all.item("tabLayer");
    objs[beforetab].style.display="none";
    objs[nItem].style.display="Inline";
    //------------------------------------------------------//
    objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    //------------------------------------------------------//
    beforetab=nItem;
    currenttab=nItem;
    var formObj=document.form;
    if (currenttab == 0) {
        formObj.fm_eq_knd_cd.value="U";

        if(!isSheetRetrieved[2]) {
            doActionIBSheet(sheetObjects[2], formObj, "RETRIEVE");
        }
    }else if (currenttab == 1) {
        formObj.fm_eq_knd_cd.value="Z";

        if(!isSheetRetrieved[3]) {
            doActionIBSheet(sheetObjects[3], formObj, "RETRIEVE");
        }
    }else{
        formObj.fm_eq_knd_cd.value="G";

        if(!isSheetRetrieved[4]) {
            doActionIBSheet(sheetObjects[4], formObj, "RETRIEVE");
        }
    }
}

/**
 * EVENT after inquiring
 * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
 */
function sheet0_OnSearchEnd(sheetObj,errMsg) {
    var formObj = document.form;
    if(sheetObj.RowCount() > 0) {
        formObj.fm_vndr_prmry_seq.value = sheetObj.GetCellValue(1, "vndr_prmry_seq");
        formObj.fm_vndr_prmry_nm.value  = sheetObj.GetCellValue(1, "vndr_prmry_nm");
        formObj.fm_agmt_ref_no.value    = sheetObj.GetCellValue(1, "agmt_ref_no");
        formObj.fm_ctrt_ofc_cd.value    = sheetObj.GetCellValue(1, "ctrt_ofc_cd");
        formObj.fm_inter_rmk.value      = sheetObj.GetCellValue(1, "inter_rmk");
    }
}

/**
 * EVENT after inquiring
 * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
 */
function sheet2_OnSearchEnd(sheetObj, code, errMsg) {
    var formObject = document.form;
    formObject.verify_result_1.value     = "0";
    formObject.verify_result_str_1.value = "( UPDATE DISABLE! )";
    formObject.updated_rows_cnt_1.value  = "0";
    formObject.total_rows_cnt_1.value    = "0";
    formObject.verify_check_yn_1.value   = "N";
    var formObj = document.form;
    var cmd = formObj.f_cmd.value;
    var cur_page = formObj.cur_page_cnt1.value;
    if( cmd == SEARCH02 && sheetObj.RowCount() > 0 && cur_page == "1") {
        var tot_cnt = sheetObj.GetEtcData('TOT_CNT');
        formObj.tot_page_cnt1.value = tot_cnt;
    }
    
	if(code == 0)
		isSheetRetrieved[2] = true;
	
    eq_OnSearchEnd(sheetObj, errMsg);
}

/**
 * EVENT after inquiring
 * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
 */
function sheet3_OnSearchEnd(sheetObj, code, errMsg) {
    var formObject = document.form;
    formObject.verify_result_2.value     = "0";
    formObject.verify_result_str_2.value = "( UPDATE DISABLE! )";
    formObject.updated_rows_cnt_2.value  = "0";
    formObject.total_rows_cnt_2.value    = "0";
    formObject.verify_check_yn_2.value   = "N";
    var formObj=document.form;
    var cmd=formObj.f_cmd.value;
    var cur_page=formObj.cur_page_cnt1.value;
    if( cmd == SEARCH02 && sheetObj.RowCount() > 0 && cur_page == "1") {
        var tot_cnt=sheetObj.GetEtcData('TOT_CNT');
        formObj.tot_page_cnt2.value=tot_cnt;
    }

    for(var k = sheetObj.HeaderRows(); k < sheetObj.HeaderRows() + sheetObj.RowCount(); k++) {
    	// keep retrieved usr_def_rmk for saving changed usr_def_rmk
    	sheetObj.SetCellValue(k, "org_usr_def_rmk", sheetObj.GetCellValue(k, "usr_def_rmk"), 0);
    }
    
	if(code == 0)
		isSheetRetrieved[3] = true;
    
    eq_OnSearchEnd(sheetObj, errMsg);
}

/**
 * EVENT after inquiring
 * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
 */
function sheet4_OnSearchEnd(sheetObj, code, errMsg) {
    var formObject = document.form;
    formObject.verify_result_3.value     = "0";
    formObject.verify_result_str_3.value = "( UPDATE DISABLE! )";
    formObject.updated_rows_cnt_3.value  = "0";
    formObject.total_rows_cnt_3.value    = "0";
    formObject.verify_check_yn_3.value   = "N";
    var cmd=formObject.f_cmd.value;
    var cur_page=formObject.cur_page_cnt1.value;
    if( cmd == SEARCH02 && sheetObj.RowCount() > 0 && cur_page == "1") {
        var tot_cnt=sheetObj.GetEtcData('TOT_CNT');
        formObject.tot_page_cnt3.value=tot_cnt;
    }

    for(var k = sheetObj.HeaderRows(); k < sheetObj.HeaderRows() + sheetObj.RowCount(); k++) {
    	// keep retrieved usr_def_rmk for saving changed usr_def_rmk
    	sheetObj.SetCellValue(k, "org_usr_def_rmk", sheetObj.GetCellValue(k, "usr_def_rmk"), 0);
    }
    
	if(code == 0)
		isSheetRetrieved[4] = true;
    
    eq_OnSearchEnd(sheetObj, errMsg);
}

/**
 * Views that occur after the EVENT
 */
function sheet5_OnSearchEnd(sheetObj, errMsg) {
    //////////////////////////////////////////////////////
	var formObject = document.form;
    var rate_sheetObject=sheetObjects[2];
    if (currenttab == 0) {
        rate_sheetObject=sheetObjects[2];
    } else if (currenttab == 1) {
        rate_sheetObject=sheetObjects[3];
    } else {
        rate_sheetObject=sheetObjects[4];
    }

    var len = sheetObj.RowCount();
    for(var row = 2; row < len+2; row++) {
    	rate_sheetObject.SetCellValue(sheetObj.GetCellValue(row, "row_num")+1, "rlt", sheetObj.GetCellValue(row, "rlt"), 0);
    	rate_sheetObject.SetCellValue(sheetObj.GetCellValue(row, "row_num")+1, "rlt2", sheetObj.GetCellValue(row, "rlt2"), 0);
		if(sheetObj.GetCellValue(row, "rlt") != 'OK') {
		    if (currenttab == 0) {
		    	formObject.verify_result_str_1.value = 1;
		    } else if (currenttab == 1) {
		    	formObject.verify_result_str_2.value = 1;
		    } else {
		    	formObject.verify_result_str_3.value = 1;
		    }
			errCnt++; // global variable
		}
    }

    if (currenttab == 0) {
        formObject.verify_result_1.value = errCnt;
        formObject.verify_check_yn_1.value = "Y";
        
        if(formObject.verify_result_1.value > 0) {
            formObject.verify_result_str_1.value = "There are 'Verify Error.'";
            document.all.btng_verify.disabled = false;
        } else {
            formObject.message_1.value = "";
            formObject.verify_result_str_1.value = "Verify are done. Please click on the 'Update' button to save.";
        }
    } else if (currenttab == 1) {
		formObject.verify_result_2.value = errCnt;
		formObject.verify_check_yn_2.value = "Y";
		
		if(formObject.verify_result_2.value > 0) {
		    formObject.verify_result_str_2.value = "There are 'Verify Error.'";
		    document.all.btng_verify.disabled = false;
		} else {
		    formObject.message_2.value = "";
		    formObject.verify_result_str_2.value = "Verify are done. Please click on the 'Update' button to save.";
		}
    } else {
        formObject.verify_result_3.value = errCnt;
        formObject.verify_check_yn_3.value = "Y";

        if(formObject.verify_result_3.value > 0) {
            formObject.verify_result_str_3.value = "There are 'Verify Error.'";
            document.all.btng_verify.disabled=false;
        } else {
            formObject.message_3.value = "";
            formObject.verify_result_str_3.value = "Verify are done. Please click on the 'Update' button to save.";
        }
    }

    formObject.trsp_tmp_seq.value = sheetObj.GetCellValue(2, "trsp_tmp_seq");
    ComOpenWait(false);
    
    //////////////////////////////////////////////////////
}

/**
* eq_OnSearchEnd
*/
function eq_OnSearchEnd(sheetObj, errMsg) {
    for(var row = sheetObj.HeaderRows(); row < sheetObj.HeaderRows() + sheetObj.RowCount(); row++) {
        sheetObj.SetCellValue(row, 'chk', 0, 0);
        sheetObj.SetCellValue(row, 'chk2', 0, 0);
        sheetObj.SetCellValue(row, 'ck_vf', 0, 0);
        sheetObj.SetCellValue(row, 'ibflag', '', 0);

        if(sheetObj.GetCellValue(row, "trsp_agmt_rt_seq") != "") {
            sheetObj.SetCellEditable(row, 'trsp_cost_mod_cd', 0);
            sheetObj.SetCellEditable(row, 'agmt_trsp_tp_cd', 0);
            sheetObj.SetCellEditable(row, 'trsp_bnd_cd', 0);
            sheetObj.SetCellEditable(row, 'cgo_tp_cd', 0);
            sheetObj.SetCellEditable(row, 'spcl_cgo_cntr_tp_cd', 0);            
            sheetObj.SetCellEditable(row, 'cust_cd', 0);
            sheetObj.SetCellEditable(row, 'cmdt_grp_cd', 0);
            sheetObj.SetCellEditable(row, 'rail_svc_tp_cd', 0);
            sheetObj.SetCellEditable(row, 'fm_nod_cd', 0);
            sheetObj.SetCellEditable(row, 'fm_nod_yd', 0);
            sheetObj.SetCellEditable(row, 'via_nod_cd', 0);
            sheetObj.SetCellEditable(row, 'via_nod_yd', 0);
            sheetObj.SetCellEditable(row, 'dor_nod_cd', 0);
            sheetObj.SetCellEditable(row, 'dor_nod_yd', 0);
            sheetObj.SetCellEditable(row, 'to_nod_cd', 0);
            sheetObj.SetCellEditable(row, 'to_nod_yd', 0);
            sheetObj.SetCellEditable(row, 'wtr_rcv_term_cd', 0);
            sheetObj.SetCellEditable(row, 'wtr_de_term_cd', 0);
            sheetObj.SetCellEditable(row, 'trsp_agmt_bdl_qty', 0);
            sheetObj.SetCellEditable(row, 'to_wgt', 0);
            sheetObj.SetCellEditable(row, 'wgt_meas_ut_cd', 0);
        }
    }
}

/**
 * EVENT after changing value of sheet
 * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
 */
function sheet2_OnChange(sheetObj, row, col, value) {
	var colSaveNm = sheetObj.ColSaveName(col);
    if (colSaveNm == "trsp_one_wy_rt" || colSaveNm == "trsp_rnd_rt") {
    	if (parseFloat(value) < 0) {
    		sheetObj.SetCellValue(row, colSaveNm, "0.00", 0);
    	}
    }
    
	eq_OnChange(sheetObj, row, col, value);
    if (sheetObj.GetRowStatus(row) != 'I' && sheetObj.ColSaveName(col) != "chk") {
        var org_eqtype=sheetObj.GetCellValue(row, "org_eqtype");
        if (org_eqtype.length > 1) org_eqtype="," + org_eqtype ;
        if( sheetObj.ColSaveName(col) == "eq_d2" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",D2",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',D2', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_d4" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",D4",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',D4', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_d5" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",D5",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',D5', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_d7" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",D7",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',D7', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_r2" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",R2",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',R2', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_r4" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",R4",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',R4', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_r5" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",R5",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',R5', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_r7" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",R7",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',R7', ''),0);
            }    
        }else if( sheetObj.ColSaveName(col) == "eq_a2" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",A2",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',A2', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_a4" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",A4",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',A4', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_f2" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",F2",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',F2', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_f4" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",F4",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',F4', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_f5" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",F5",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',F5', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_t2" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",T2",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',T2', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_t4" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",T4",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',T4', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_s2" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",S2",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',S2', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_s4" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",S4",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',S4', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_o2" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",O2",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',O2', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_o4" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",O4",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',O4', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_p2" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",P2",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',P2', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_p4" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",P4",0);
            }else{
                 sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',P4', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_alal" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",ALAL",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',ALAL', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_dal" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",DAL",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',DAL', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_ral" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",RAL",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',RAL', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_aal" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",AAL",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',AAL', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_fal" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",FAL",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',FAL', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_tal" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",TAL",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',TAL', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_sal" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",SAL",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',SAL', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_oal" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",OAL",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',OAL', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_pal" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",PAL",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',PAL', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_al2" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",AL2",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',AL2', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_al4" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",AL4",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',AL4', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_al5" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",AL5",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',AL5', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_al7" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",AL7",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',AL7', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_al9" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",AL9",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',AL9', ''),0);
            }
        }
        var after_org_eqtype=sheetObj.GetCellValue(row, "org_eqtype");
        if (after_org_eqtype.length > 1 && after_org_eqtype.substring(0,1) == ",")
            sheetObj.SetCellValue(row, "org_eqtype",sheetObj.GetCellValue(row, "org_eqtype").substring(1,100),0);
    }
}

/**
 * EVENT after changing value of sheet
 * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
 */
function sheet3_OnChange(sheetObj, row , col , value) {
    var colSaveNm = sheetObj.ColSaveName(col);
    if (colSaveNm == "trsp_one_wy_rt" || colSaveNm == "trsp_rnd_rt") {
    	if (parseFloat(value) < 0) {
    		sheetObj.SetCellValue(row, colSaveNm, "0.00", 0);
    	}
    }
    
    eq_OnChange(sheetObj, row , col , value);
    if (sheetObj.GetRowStatus(row) != 'I' && sheetObj.ColSaveName(col) != "chk") {
        var org_eqtype=sheetObj.GetCellValue(row, "org_eqtype");
        if (org_eqtype.length > 1) org_eqtype="," + org_eqtype ;
        if( sheetObj.ColSaveName(col) == "eq_sf4" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",SF4",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',SF4', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_sl2" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",SL2",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',SL2', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_ta2" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",TA2",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',TA2', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_gn4" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",GN4",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',GN4', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_gn5" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",GN5",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',GN5', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_eg5" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",EG5",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',EG5', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_eg8" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",EG8",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',EG8', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_zt4" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",ZT4",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',ZT4', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_cb4" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",CB4",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',CB4', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_alal" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",ALAL",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',ALAL', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_sfal" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",SFAL",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',SFAL', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_slal" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",SLAL",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',SLAL', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_taal" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",TAAL",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',TAAL', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_gnal" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",GNAL",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',GNAL', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_egal" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",EGAL",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',EGAL', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_al2" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",AL2",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',AL2', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_al4" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",AL4",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',AL4', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_al5" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",AL5",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',AL5', ''),0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_al8" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype + ",AL8",0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype",org_eqtype.replace(',AL8', ''),0);
            }
        }
        var after_org_eqtype=sheetObj.GetCellValue(row, "org_eqtype");
        if (after_org_eqtype.length > 1 && after_org_eqtype.substring(0,1) == ",")
            sheetObj.SetCellValue(row, "org_eqtype",sheetObj.GetCellValue(row, "org_eqtype").substring(1,100),0);
    }
}

/**
 * EVENT after changing value of sheet
    * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
 */
function sheet4_OnChange(sheetObj, row, col, value) {
	var colSaveNm = sheetObj.ColSaveName(col);
    if (colSaveNm == "trsp_one_wy_rt" || colSaveNm == "trsp_rnd_rt") {
    	if (parseFloat(value) < 0) {
    		sheetObj.SetCellValue(row, colSaveNm, "0.00", 0);
    	}
    }
    
    eq_OnChange(sheetObj, row, col, value);
    if (sheetObj.GetRowStatus(row) != 'I' && sheetObj.ColSaveName(col) != "chk") {
        var org_eqtype=sheetObj.GetCellValue(row, "org_eqtype");
        if (org_eqtype.length > 1) org_eqtype="," + org_eqtype ;
        if( sheetObj.ColSaveName(col) == "eq_alal" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype", org_eqtype + ", ALAL", 0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype", org_eqtype.replace(', ALAL', ''), 0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_cg" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype", org_eqtype + ", CG", 0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype", org_eqtype.replace(', CG', ''), 0);
            }
        }else if( sheetObj.ColSaveName(col) == "eq_ug" ) {
            if (value == "" || value == "0"){
                sheetObj.SetCellValue(row, "org_eqtype", org_eqtype + ", UG", 0);
            }else{
                sheetObj.SetCellValue(row, "org_eqtype", org_eqtype.replace(', UG', ''), 0);
            } 
        }
        var after_org_eqtype=sheetObj.GetCellValue(row, "org_eqtype");
        if (after_org_eqtype.length > 1 && after_org_eqtype.substring(0,1) == ",")
            sheetObj.SetCellValue(row, "org_eqtype", sheetObj.GetCellValue(row, "org_eqtype").substring(1,100),0);
    }
}

/**
 * EVENT after changing value of sheet
*/
function eq_OnChange(sheetObj, row, col, value) {
    if( sheetObj.ColSaveName(col) != "chk" ) {
        sheetObj.SetCellValue(row,'chk',1,0);
        sheetObj.SetCellValue(row,'ck_vf',1,0);
        sheetObj.SetCellValue(row,'rlt',"",0);

        if( sheetObj.ColSaveName(col) == "cust_cd" ) {
            if(isNaN(value.substring(2, 7))) {
                ComShowMessage("Invalid customer code!");
                sheetObj.SetCellValue(row, "cust_cd", "");
                return;
            } else {
                if(value != "" && value != null && value != undefined) {
                    document.form.f_cmd.value = INIT;
                    document.form.custCode.value = value;
                    var sXml = sheetObj.GetSearchData("ESD_TRS_0221GS.do", FormQueryString(document.form));
                    if(ComGetTotalRows(sXml) == "0") {
                        ComShowMessage("No corresponding customer code!");
                        sheetObj.SetCellValue(row, "cust_cd", "");
                        return;
                    }
                }
            }
        } else if( sheetObj.ColSaveName(col) == "fm_nod_cd" ) {
            var lvfm=doSepRemove(sheetObj.GetCellValue(row,"fm_nod_cd").toUpperCase(), " ");
            sheetObj.SetCellValue(row, "fm_nod_cd",lvfm,0);
            if( doengnumcheck(lvfm) ) {
                if( lvfm.length == 5 ) {
                    getYardSheetCombo1(sheetObj, document.form, row, col, "fm_nod_yd", lvfm); //Checking validation
                    if( sheetObj.GetCellValue(row, "fm_nod_cd") != "" ) {
                        getYardSheetCombo(sheetObj, document.form, row, "fm_nod_yd", lvfm);
                    } else {
                        sheetObj.CellComboItem(row,"fm_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "fm_nod_yd","",0);
                    }
                } else {
                    if( lvfm.length == 0 ) {
                        sheetObj.CellComboItem(row,"fm_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "fm_nod_yd","",0);
                    } else {
                        errMsg=ComGetMsg("TRS90122");
                        ComShowMessage(errMsg);
                        sheetObj.SetCellValue(row,"fm_nod_cd","",0);
                        sheetObj.SelectCell(row,"fm_nod_cd");
                        sheetObj.CellComboItem(row,"fm_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "fm_nod_yd","",0);
                    }
                }
            } else {
                sheetObj.SetCellValue(row,"fm_nod_cd","",0);
                sheetObj.SelectCell(row,"fm_nod_cd");
                sheetObj.CellComboItem(row,"fm_nod_yd", {ComboText:"", ComboCode:""} );
                sheetObj.SetCellValue(row, "fm_nod_yd","",0);
            }
        } else if( sheetObj.ColSaveName(col) == "via_nod_cd" ) {
            var lvvia=doSepRemove(sheetObj.GetCellValue(row,"via_nod_cd").toUpperCase(), " ");
            sheetObj.SetCellValue(row,"via_nod_cd",lvvia);
            if( doengnumcheck(lvvia) ) {
                if( lvvia.length == 5 ) {
                    getYardSheetCombo1(sheetObj, document.form, row, col, "via_nod_yd", lvvia); //Checking validation
                    if( sheetObj.GetCellValue(row, "via_nod_cd") != "" ) {
                        getYardSheetCombo(sheetObj, document.form, row, "via_nod_yd", lvvia);
                    } else {
                        sheetObj.CellComboItem(row,"via_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "via_nod_yd","",0);
                    }
                } else {
                    if( lvvia.length == 0 ) {
                        sheetObj.CellComboItem(row,"via_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "via_nod_yd","",0);
                    } else {
                        errMsg=ComGetMsg("TRS90122");
                        ComShowMessage(errMsg);
                        sheetObj.SetCellValue(row,"via_nod_cd","",0);
                        sheetObj.SelectCell(row,"via_nod_cd");
                        sheetObj.CellComboItem(row,"via_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "via_nod_yd","",0);
                    }
                }
            } else {
                sheetObj.SetCellValue(row,"via_nod_cd","",0);
                sheetObj.SelectCell(row,"via_nod_cd");
                sheetObj.CellComboItem(row,"via_nod_yd", {ComboText:"", ComboCode:""} );
                sheetObj.SetCellValue(row, "via_nod_yd","",0);
            }
        } else if( sheetObj.ColSaveName(col) == "to_nod_cd" ) {
            var lvto=doSepRemove(sheetObj.GetCellValue(row,"to_nod_cd").toUpperCase(), " ");
            sheetObj.SetCellValue(row,"to_nod_cd",lvto);
            if( doengnumcheck(lvto) ) {
                if( lvto.length == 5 ) {
                    getYardSheetCombo1(sheetObj, document.form, row, col, "to_nod_yd", lvto); //Checking validation
                    if( sheetObj.GetCellValue(row, "to_nod_cd") != "" ) {
                        getYardSheetCombo(sheetObj, document.form, row, "to_nod_yd", lvto);
                    } else {
                        sheetObj.CellComboItem(row,"to_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "to_nod_yd","",0);
                    }
                } else {
                    if( lvto.length == 0 ) {
                        sheetObj.CellComboItem(row,"to_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "to_nod_yd","",0);
                    } else {
                        errMsg=ComGetMsg("TRS90122");
                        ComShowMessage(errMsg);
                        sheetObj.SetCellValue(row,"to_nod_cd","",0);
                        sheetObj.SelectCell(row,"to_nod_cd");
                        sheetObj.CellComboItem(row,"to_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "to_nod_yd","",0);
                    }
                }
            } else {
                sheetObj.SetCellValue(row,"to_nod_cd","",0);
                sheetObj.SelectCell(row,"to_nod_yd");
                sheetObj.CellComboItem(row,"to_nod_yd", {ComboText:"", ComboCode:""} );
                sheetObj.SetCellValue(row, "to_nod_yd","",0);
            }
        } else if( sheetObj.ColSaveName(col) == "dor_nod_cd" ) {
            var lvdor=doSepRemove(sheetObj.GetCellValue(row,"dor_nod_cd").toUpperCase(), " ");
            sheetObj.SetCellValue(row,"dor_nod_cd",lvdor);
            if( doengnumcheck(lvdor) ) {
                if( lvdor.length == 5 ) {
                    getZoneSheetCombo1(sheetObj, document.form, row, col, "dor_nod_yd", lvdor);
                    if( sheetObj.GetCellValue(row, "dor_nod_cd") != "" ) {
                        getZoneSheetCombo(sheetObj, document.form, row, "dor_nod_yd", lvdor);
                    } else {
                        sheetObj.CellComboItem(row,"dor_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "dor_nod_yd","",0);
                    }
                } else {
                    if( lvdor.length == 0 ) {
                        sheetObj.CellComboItem(row,"dor_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "dor_nod_yd","",0);
                    } else {
                        errMsg=ComGetMsg("TRS90122");
                        ComShowMessage(errMsg);
                        sheetObj.SetCellValue(row,"dor_nod_cd","",0);
                        sheetObj.SelectCell(row,"dor_nod_cd");
                        sheetObj.CellComboItem(row,"dor_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "dor_nod_yd","",0);    
                    }
                }
            } else {
                sheetObj.SetCellValue(row,"dor_nod_cd","",0);
                sheetObj.SelectCell(row,"dor_nod_cd");
                sheetObj.CellComboItem(row,"dor_nod_yd", {ComboText:"", ComboCode:""} );
                sheetObj.SetCellValue(row, "dor_nod_yd","",0);
            }
        } else if( sheetObj.ColSaveName(col) == "to_wgt" ) {
            var lvWgt = doSepRemove(sheetObj.GetCellValue(row, "to_wgt").toUpperCase(), " ");
            var strArray = lvWgt.split(".");
            if(isNaN(lvWgt)) {
                if(lvWgt != "MAX") {
                    ComShowMessage("Only 'MAX' or number(1234567890.) could be inputted.");
                    sheetObj.SetCellValue(row, "to_wgt", "", 0);
                    return;
                }
            } else {
                if(strArray[0].length > 6) {
                    ComShowMessage("Weight Tier coud not exceed 999999.99");
                    sheetObj.SetCellValue(row, "to_wgt", "", 0);
                    return;
                }
            }

            sheetObj.SetCellValue(row, "to_wgt", lvWgt, 0);
        }
        
        // Depends on TransMode value, Enable or Disable Bound Column
        // Case(TransMode) :
        //  - Water : Enable Bound
        //  - Other : Delete & Disable Bound
        else if( sheetObj.ColSaveName(col) == "agmt_trsp_tp_cd" ) {
            if (value.substring(0, 1) == "W" || value.substring(1, 2) == "W") {
                sheetObj.SetCellEditable(row, "trsp_bnd_cd", 1);
            } else {
                sheetObj.SetCellValue(row, "trsp_bnd_cd", "", 0);
                sheetObj.SetCellEditable(row, "trsp_bnd_cd", 0);
            }
        } else if( sheetObj.ColSaveName(col) == "cgo_tp_cd" ) {
            if (value == "F") {
                sheetObj.SetCellEditable(row, "spcl_cgo_cntr_tp_cd", 1);
            } else {
                sheetObj.SetCellValue(row, "spcl_cgo_cntr_tp_cd", "", 0);
                sheetObj.SetCellEditable(row, "spcl_cgo_cntr_tp_cd", 0);
            }
        }
    }
}

/**
 * sheet2 COLUMN click EVENT
*/
function sheet2_OnClick(sheetObj, row , col , value) {
    eq_OnClick(sheetObj, row , col , value);
}
 
/**
 * sheet3 COLUMN click EVENT
 */
function sheet3_OnClick(sheetObj, row , col , value) {
    eq_OnClick(sheetObj, row , col , value);
}
 
/**
 * sheet4 COLUMN click EVENT
 */
function sheet4_OnClick(sheetObj, row , col , value) {
    eq_OnClick(sheetObj, row , col , value);
}

/**
 * Sheet에서 COLUMN click EVENT
 */
function eq_OnClick(sheetObj, row, col, value) {
    if(sheetObj.GetCellValue(row, "trsp_agmt_rt_seq") == "") {
        if( sheetObj.ColSaveName(col) == "fm_nod_yd" ) {
            value=doSepRemove(sheetObj.GetCellValue(row, "fm_nod_cd"), " ");
            if( value.length > 0 ) {
                getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
            } else {
                sheetObj.SetCellValue(row, "fm_nod_cd", "", 0);
            }
        } else if( sheetObj.ColSaveName(col) == "to_nod_yd" ) {
            value=doSepRemove(sheetObj.GetCellValue(row, "to_nod_cd"), " ");
            if( value.length > 0 ) {
                getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
            } else {
                sheetObj.SetCellValue(row, "to_nod_cd", "", 0);
            }
        } else if (sheetObj.ColSaveName(col) == "via_nod_yd" ) {
            value=doSepRemove(sheetObj.GetCellValue(row, "via_nod_cd"), " ");
            if( value.length > 0 ) {
                getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
            } else {
                sheetObj.SetCellValue(row, "via_nod_cd", "", 0);
            }
        } else if( sheetObj.ColSaveName(col) == "dor_nod_yd" ) {
            value=doSepRemove(sheetObj.GetCellValue(row, "dor_nod_cd"), " ");
            if( value.length > 0 ) {
                getZoneSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
            } else {
                sheetObj.SetCellValue(row, "dor_nod_cd", "", 0);
            }
        }
    }
}

/**
 * Loading the list of external combo box
 */
 function getComboList(obj, comObj, sep) {
     var formObj=document.form;
     var lvobj=doSepRemove(obj.value.toUpperCase(), " ");
     obj.value=lvobj;
     
    if( comObj.name == 'search_fm_yard' ){
        comObj = search_fm_yard;
    }else if( comObj.name == 'search_via_yard' ){
        comObj = search_via_yard;
    }else if( comObj.name == 'search_to_yard' ){
        comObj = search_to_yard;
    }else if( comObj.name == 'search_door_yard' ){
        comObj = search_door_yard;
    }
     
     if( lvobj == "" ) {
         obj.value="";
         comObj.RemoveAll();
         return false;
     } else if( lvobj.length != 5 ) {
         errMsg=ComGetMsg("TRS90074");
         ComShowMessage(errMsg);
         obj.focus();
         return false;
     }
     if( !doengnumcheck(lvobj) ) {
         obj.value="";
         comObj.RemoveAll();
         obj.focus();
         return false;
     }
     if( sep == 'F' ) {
         formObj.TRSP_SO_EQ_KIND.value="";
         lvFromNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
     } else if( sep == 'V' ) {
         formObj.TRSP_SO_EQ_KIND.value="";
         lvViaNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
     } else if( sep == 'T' ) {
         formObj.TRSP_SO_EQ_KIND.value="A";
         lvToNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
     } else if( sep == 'D' ) {
         formObj.TRSP_SO_EQ_KIND.value="";
         lvDoorLoc=getZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
     }
     comObj.focus();
 }
 /**
 * Resizing sheet
  */
 function Minimize(nItem) {
     var objs=document.all.item("MiniLayer");
     if( nItem == "1" ) {
         objs.style.display="none";
         sheet2.SetSheetHeight(ComGetSheetHeight(sheet2, 17));
         sheet3.SetSheetHeight(ComGetSheetHeight(sheet3, 17));
         sheet4.SetSheetHeight(ComGetSheetHeight(sheet4, 17));
     } else {
         objs.style.display="inline";
         sheet2.SetSheetHeight(ComGetSheetHeight(sheet2, 9));
         sheet3.SetSheetHeight(ComGetSheetHeight(sheet3, 9));
         sheet4.SetSheetHeight(ComGetSheetHeight(sheet4, 9));
     }
 }

function setAgmt_info() {
    var formObj=document.form;
    var agmt_rt_tp_cd="";
    /* Removal of unused due to distance Type
    if ( formObj.fm_trsp_agmt_rt_tp_radio[0].checked == true ) {
        agmt_rt_tp_cd="P";
    }else if( formObj.fm_trsp_agmt_rt_tp_radio[1].checked == true ) {
        agmt_rt_tp_cd="D";
    }else if( formObj.fm_trsp_agmt_rt_tp_radio[2].checked == true ) {
        agmt_rt_tp_cd="PD";
    }else{
        agmt_rt_tp_cd="DP";
    }*/
    agmt_rt_tp_cd="P" // Pair Type set to always
    formObj.fm_trsp_agmt_rt_tp_cd.value=agmt_rt_tp_cd;     
}

var errCnt = 0;

/**
  * Container Verify check
  */
function valcheck_two1(sheetObj) {
    var formObject = document.form;
    // reset sequence
    sheetObj.ReNumberSeq();

    // reset result desctiption
    reSetResultText(sheetObj, row);

    setAgmt_info();

        formObject.verify_result_str_1.value = "Collect data is being precessed. Please wait.";
        ComOpenWait(true);
        sheetObj.SetWaitImageVisible(0);
        document.all.btng_verify.disabled = false;
        formObject.f_cmd.value = SEARCH01;

        // Upon completion ck_vf verify the value of '1 '-> '0' is changed to.
        var check_row = sheetObj.CheckedRows('chk');
        if(check_row == '') {
            ComOpenWait(false);
            sheetObj.SetWaitImageVisible(1);
            ComShowMessage(ComGetMsg("TRS90036"));
            return;
        }

        if(!validateForm(sheetObj, formObject)) {
            formObject.verify_result_str_1.value = "Mandatory field is missing.";
            ComOpenWait(false);
            sheetObj.SetWaitImageVisible(1);
            return false;
        }

        // 2015.05.14 check EQ Type/Size field
        var isNullEqTySz = true;
        var checkList = sheetObj.FindCheckedRow('chk');
        var checkArray = checkList.split('|');
        for(var row = 0; row < checkArray.length; row++) {
	        var start = sheetObj.SaveNameCol("eq_alal");
	        var end = sheetObj.SaveNameCol("eq_p4");
	        
	        for(var col = start; col <= end; col++) {
	            if(sheetObj.GetCellValue(checkArray[row], col) == "1") {
	            	isNullEqTySz = false;
	            	break;
	            }
	        }
	        
	        if (isNullEqTySz) {
	            formObject.verify_result_str_1.value = "EQ Type/Size field is missing.";
	            ComShowCodeMessage("TRS90410", "EQ Type/Size");
	            sheetObj.SelectCell(checkArray[i], "eq_alal");
	            ComOpenWait(false);
	            sheetObj.SetWaitImageVisible(1);
	        	return false;
	        }
        }

        formObject.verify_result_str_1.value = "Verify is being processed. Please wait.";
        errCnt = 0; //initialize global variable

        var dupRow=sheetObj.ColValueDup("trsp_cost_mod_cd|agmt_trsp_tp_cd|trsp_bnd_cd|cgo_tp_cd|spcl_cgo_cntr_tp_cd|cust_cd|cmdt_grp_cd|rail_svc_tp_cd|" +
                "fm_nod_cd|fm_nod_yd|via_nod_cd|via_nod_yd|dor_nod_cd|dor_nod_yd|to_nod_cd|to_nod_yd|" +
                "eq_alal|eq_dal|eq_ral|eq_aal|eq_fal|eq_tal|eq_sal|eq_oal|eq_pal|" +
                "eq_al2|eq_al4|eq_al5|eq_al7|eq_al9|" +
                "eq_d2|eq_d4|eq_d5|eq_d7|" +
                "eq_r2|eq_r4|eq_r5|eq_r7|" +
                "eq_a2|eq_a4|" +
                "eq_f2|eq_f4|eq_f5|" +
                "eq_t2|eq_t4|" +
                "eq_s2|eq_s4|" +
                "eq_o2|eq_o4|" +
                "eq_p2|eq_p4|" +
                "wtr_rcv_term_cd|wtr_de_term_cd|to_wgt|wgt_meas_ut_cd|trsp_agmt_bdl_qty|eff_fm_dt|eff_to_dt|usr_def_rmk");

        var dupRow2=dupRow - 1;
        if(dupRow != -1) {
            ComShowCodeMessage("TRS90412", "row " + dupRow2);
            sheetObj.SetSelectRow(dupRow);
            sheetObj.SetCellValue(dupRow, 'rlt', 'DUP', 0);
            ComOpenWait(false);
            sheetObj.SetWaitImageVisible(1);
            return;
        }
        
        var dupKey = "trsp_cost_mod_cd|agmt_trsp_tp_cd|trsp_bnd_cd|cgo_tp_cd|spcl_cgo_cntr_tp_cd|cust_cd|cmdt_grp_cd|rail_svc_tp_cd|" +
                "fm_nod_cd|fm_nod_yd|via_nod_cd|via_nod_yd|dor_nod_cd|dor_nod_yd|to_nod_cd|to_nod_yd|" +
                "eq_alal|eq_dal|eq_ral|eq_aal|eq_fal|eq_tal|eq_sal|eq_oal|eq_pal|" +
                "eq_al2|eq_al4|eq_al5|eq_al7|eq_al9|" +
                "eq_d2|eq_d4|eq_d5|eq_d7|" +
                "eq_r2|eq_r4|eq_r5|eq_r7|" +
                "eq_a2|eq_a4|" +
                "eq_f2|eq_f4|eq_f5|" +
                "eq_t2|eq_t4|" +
                "eq_s2|eq_s4|" +
                "eq_o2|eq_o4|" +
                "eq_p2|eq_p4|" +
                "wtr_rcv_term_cd|wtr_de_term_cd|to_wgt|wgt_meas_ut_cd|trsp_agmt_bdl_qty|usr_def_rmk";
        
        
        var effectiveDateCheck =  checkEffectiveDate(sheetObj, dupKey);
        if(!effectiveDateCheck) {
//            ComShowCodeMessage("TRS90412", "Effective Date");
            ComOpenWait(false);
            sheetObj.SetWaitImageVisible(1);
             return;
        }
        
        // set TRSP_AGMT_RT_SEQ list to delete
        setRateSequence(sheetObj, checkArray, "eq_alal", "eq_p4", "_rt_seq");

        var queryStr = sheetObj.GetSaveString(0, 1, 'chk');
        sheetObjects[5].RemoveAll();
        sheetObjects[5].DoSearch("ESD_TRS_0221GS.do", TrsFrmQryString(formObject)+'&'+queryStr, {Sync:1});
}

/**
  * Chassis/Genset Verify check
  */
function valcheck_two2(sheetObj) {
    var formObject=document.form;
    // reset sequence
    sheetObj.ReNumberSeq();

    // reset result desctiption
    reSetResultText(sheetObj, row);

    setAgmt_info();

        formObject.verify_result_str_2.value = "Collect data is being precessed. Please wait.";
        ComOpenWait(true);
        sheetObj.SetWaitImageVisible(0);
        document.all.btng_verify.disabled = false;
        formObject.f_cmd.value = SEARCH01;

        //Upon completion ck_vf verify the value of '1 '-> '0' is changed to.
        var check_row = sheetObj.CheckedRows('chk');
        if(check_row == '') {
            ComOpenWait(false);
            ComShowCodeMessage('TRS90036');
            return;
        }

        // 2015.05.14 check EQ Type/Size field
        var isNullEqTySz = true;
        var checkList = sheetObj.FindCheckedRow('chk');
        var checkArray = checkList.split('|');
        for(var row = 0; row < checkArray.length; row++) {
	        var isComScgAply = sheetObj.GetCellValue(checkArray[row], "com_scg_aply_flg");
	        var start = sheetObj.SaveNameCol("eq_alal");
	        var end = sheetObj.SaveNameCol("eq_cb4");
	        
	        for(var col = start; col <= end; col++) {
	            if(sheetObj.GetCellValue(checkArray[row], col) == "1") {
	            	isNullEqTySz = false;
	            	break;
	            }
	        }
	        
	        if (isNullEqTySz) {
	            formObject.verify_result_str_1.value = "EQ Type/Size field is missing.";
	            ComShowCodeMessage("TRS90410", "EQ Type/Size");
	            sheetObj.SelectCell(checkArray[i], "eq_alal");
	            ComOpenWait(false);
	            sheetObj.SetWaitImageVisible(1);
	        	return false;
	        }
        }

        formObject.verify_result_str_2.value="Verify is being processed. Please wait.";
        errCnt = 0; //initialize global variable

        var dupRow=sheetObj.ColValueDup("trsp_cost_mod_cd|agmt_trsp_tp_cd|cgo_tp_cd|cust_cd|cmdt_grp_cd|rail_svc_tp_cd|" +
                "fm_nod_cd|fm_nod_yd|to_nod_cd|to_nod_yd|" +
                "eq_alal|eq_sfal|eq_slal|eq_taal|eq_gnal|eq_egal|" +
                "eq_al2|eq_al4|eq_al5|eq_al8|" +
                "eq_sf2|eq_sf4|" +
                "eq_sl2|" +
                "eq_ta2|" +
                "eq_gn4|eq_gn5|" +
                "eq_eq5|eq_eq8|" +
                "eq_zt4|" +
                "eq_cb4|" +
                "wtr_rcv_term_cd|wtr_de_term_cd|trsp_agmt_bdl_qty|eff_fm_dt|eff_to_dt|usr_def_rmk");

        var dupRow2=dupRow - 1;
        if(dupRow != -1) {
            ComShowCodeMessage("TRS90412", "row " + dupRow2);
            sheetObj.SetSelectRow(dupRow);
            sheetObj.SetCellValue(dupRow, 'rlt', 'DUP', 0);
            ComOpenWait(false);
            sheetObj.SetWaitImageVisible(1);
            return;
        }
        
        var dupKey = "trsp_cost_mod_cd|agmt_trsp_tp_cd|cgo_tp_cd|cust_cd|cmdt_grp_cd|rail_svc_tp_cd|" +
                "fm_nod_cd|fm_nod_yd|to_nod_cd|to_nod_yd|" +
                "eq_alal|eq_sfal|eq_slal|eq_taal|eq_gnal|eq_egal|" +
                "eq_al2|eq_al4|eq_al5|eq_al8|" +
                "eq_sf2|eq_sf4|" +
                "eq_sl2|" +
                "eq_ta2|" +
                "eq_gn4|eq_gn5|" +
                "eq_eq5|eq_eq8|" +
                "eq_zt4|" +
                "eq_cb4|" +
                "wtr_rcv_term_cd|wtr_de_term_cd|trsp_agmt_bdl_qty|usr_def_rmk";
        
        var effectiveDateCheck =  checkEffectiveDate(sheetObj, dupKey);
        if(!effectiveDateCheck) {
        	ComOpenWait(false);
            sheetObj.SetWaitImageVisible(1);
            return;
        }
        
        // set TRSP_AGMT_RT_SEQ list to delete
        setRateSequence(sheetObj, checkArray, "eq_alal", "eq_cb4", "_rt_seq");
        
        var queryStr = sheetObj.GetSaveString(0, 1, 'chk');
        sheetObjects[5].RemoveAll();
        sheetObjects[5].DoSearch("ESD_TRS_0221GS.do", TrsFrmQryString(formObject)+'&'+queryStr, {Sync:1});
}

/**
  * Check Genset Verify
  */
function valcheck_two3(sheetObj) {
    var formObject=document.form;
    // reset sequence
    sheetObj.ReNumberSeq();

    // reset result desctiption
    reSetResultText(sheetObj, row);

    setAgmt_info();

        formObject.verify_result_str_3.value = "Collect data is being precessed. Please wait.";
        ComOpenWait(true);
        sheetObj.SetWaitImageVisible(0);
        document.all.btng_verify.disabled = false;
        formObject.f_cmd.value = SEARCH01;

        // Upon completion ck_vf verify the value of '1 '-> '0' is changed to.
        var check_row = sheetObj.CheckedRows('chk');
        if(check_row == '') {
            ComOpenWait(false);
            sheetObj.SetWaitImageVisible(1);
            ComShowCodeMessage('TRS90036');
            return;
        }

        // 2015.05.14 check EQ Type/Size field
        var isNullEqTySz = true;
        var checkList = sheetObj.FindCheckedRow('chk');
        var checkArray = checkList.split('|');
        for(var row = 0; row < checkArray.length; row++) {
	        var isComScgAply = sheetObj.GetCellValue(checkArray[row], "com_scg_aply_flg");
	        var start = sheetObj.SaveNameCol("eq_alal");
	        var end = sheetObj.SaveNameCol("eq_ug");
	        
	        for(var col = start; col <= end; col++) {
	            if(sheetObj.GetCellValue(checkArray[row], col) == "1") {
	            	isNullEqTySz = false;
	            	break;
	            }
	        }
	        
	        if (isNullEqTySz) {
	            formObject.verify_result_str_1.value = "EQ Type/Size field is missing.";
	            ComShowCodeMessage("TRS90410", "EQ Type/Size");
	            sheetObj.SelectCell(checkArray[i], "eq_alal");
	            ComOpenWait(false);
	            sheetObj.SetWaitImageVisible(1);
	        	return false;
	        }
        }

        formObject.verify_result_str_3.value="Verify is being processed. Please wait.";
        errCnt = 0; //initialize global variable

        var dupRow=sheetObj.ColValueDup("trsp_cost_mod_cd|agmt_trsp_tp_cd|cgo_tp_cd|cust_cd|cmdt_grp_cd|rail_svc_tp_cd|" +
                "fm_nod_cd|fm_nod_yd|to_nod_cd|to_nod_yd|" +
                "eq_alal|eq_cg|eq_ug|" +
                "wtr_rcv_term_cd|wtr_de_term_cd|eff_fm_dt|eff_to_dt|usr_def_rmk");

        var dupRow2=dupRow - 1;
        if(dupRow != -1) {
            ComShowCodeMessage("TRS90412", "row " + dupRow2);
            sheetObj.SetSelectRow(dupRow);
            sheetObj.SetCellValue(dupRow, 'rlt', 'DUP', 0);
            ComOpenWait(false);
            sheetObj.SetWaitImageVisible(1);
            return;
        }
        
        var dupKey = "trsp_cost_mod_cd|agmt_trsp_tp_cd|cgo_tp_cd|cust_cd|cmdt_grp_cd|rail_svc_tp_cd|" +
                "fm_nod_cd|fm_nod_yd|to_nod_cd|to_nod_yd|" +
                "eq_alal|eq_cg|eq_ug|" +
                "wtr_rcv_term_cd|wtr_de_term_cd|usr_def_rmk";
        
        var effectiveDateCheck =  checkEffectiveDate(sheetObj, dupKey);
        if(!effectiveDateCheck) {
            ComOpenWait(false);
            sheetObj.SetWaitImageVisible(1);
            return;
        }
        
        // set TRSP_AGMT_RT_SEQ list to delete
        setRateSequence(sheetObj, checkArray, "eq_alal", "eq_ug", "_rt_seq");
        
        var queryStr = sheetObj.GetSaveString(0, 1, 'chk');
        sheetObjects[5].RemoveAll();
        sheetObjects[5].DoSearch("ESD_TRS_0221GS.do", TrsFrmQryString(formObject)+'&'+queryStr, {Sync:1});
}

/**
 * Mandatory Field Check
 */
function validateForm(sheetObj, formObj) {
    var checkList = sheetObj.FindCheckedRow('chk');
    var checkArray = checkList.split('|');
    for(var i = 0; i < checkArray.length; i++) {
        if(sheetObj.GetCellValue(checkArray[i], "trsp_cost_mod_cd") == "") {
            ComShowCodeMessage("TRS90410", "Cost Mode");
            sheetObj.SelectCell(checkArray[i], "trsp_cost_mod_cd");
            return false;
        }
        if(sheetObj.GetCellValue(checkArray[i], "agmt_trsp_tp_cd") == "") {
            ComShowCodeMessage("TRS90410", "Trans Mode");
            sheetObj.SelectCell(checkArray[i], "agmt_trsp_tp_cd");
            return false;
        }

        /* 2015.05.20 NULL value acceptable
        if(sheetObj.GetCellValue(checkArray[i], "trsp_bnd_cd") == "" && 
          (sheetObj.GetCellValue(checkArray[i], "agmt_trsp_tp_cd").substring(0, 1) == "W" || sheetObj.GetCellValue(checkArray[i], "agmt_trsp_tp_cd").substring(1, 2) == "W"))
        {
            ComShowCodeMessage("TRS90410", "T/Ship");
            sheetObj.SelectCell(checkArray[i], "trsp_bnd_cd");
            return false;
        }
        */
        
        if(sheetObj.GetCellValue(checkArray[i], "cgo_tp_cd") == "") {
            ComShowCodeMessage("TRS90410", "Cargo Type");
            sheetObj.SelectCell(checkArray[i], "cgo_tp_cd");
            return false;
        }
        // 2015.04.20 append condition : CargoType is F and CargoNature
        // 2015.04.23 Cargo Nature is not mandatory when Cargo Type is Full
//        if(sheetObj.GetCellValue(checkArray[i], "cgo_tp_cd") == "F" && sheetObj.GetCellValue(checkArray[i], "spcl_cgo_cntr_tp_cd") == "")
//        {
//            ComShowCodeMessage("TRS90410", "Cargo Nature");
//            sheetObj.SelectCell(checkArray[i], "spcl_cgo_cntr_tp_cd");
//            return false;
//        }

        if(sheetObj.GetCellValue(checkArray[i], "cgo_tp_cd") == "M" && sheetObj.GetCellValue(checkArray[i], "spcl_cgo_cntr_tp_cd").length > 0) {
             ComShowCodeMessage("TRS90421");
             sheetObj.SelectCell(checkArray[i], "spcl_cgo_cntr_tp_cd");
             return false;
        }
    }
    return true;
}

/**
  * Saving the rate passing Container Verify function
  */
function update1(sheetObj) {
    var formObject = document.form;
    
    ComOpenWait(true);
    var sheet2_count = sheetObj.RowCount();
    var check_verify = sheetObj.CheckedRows('ck_vf');
    var check_result = false;

    var check_row = sheetObj.CheckedRows('chk');
    if(check_row == '') {
        ComOpenWait(false);
        ComShowMessage(ComGetMsg("TRS90036"));
        return;
    }

    for(var k = sheetObj.HeaderRows(); k < sheet2_count + sheetObj.HeaderRows(); k++) {
        if (sheetObj.GetRowStatus(k) == 'I' || sheetObj.GetRowStatus(k) == 'U') {
            if(sheetObj.GetCellValue(k, 'rlt') != 'OK') {
                check_result = true;
            }
        }
    }

    if(check_verify > 0 && check_result) {
        ComOpenWait(false);
        ComShowCodeMessage('TRS90039');
        formObject.verify_result_str_1.value = "Please click on the 'Verify' button.";
        return false;
    }

    var y1 = formObject.fm_agmtno.value;
    formObject.message_1.value = "S";
    var verify_2 = formObject.verify_result_1.value;
    var verify_3 = formObject.verify_check_yn_1.value;
    var checkList = sheetObj.FindCheckedRow('chk');
    var checkArray = checkList.split('|');
    formObject.total_rows_cnt_1.value = checkArray.length;

    if(sheet2_count > 0) {
        if(verify_2 == 0 && verify_3 == "Y") {
            formObject.f_cmd.value = MULTI;
            sheetObj.DoSave("ESD_TRS_0221GS.do", TrsFrmQryString(formObject), "chk", false, true);
            if(formObject.message_1.value == "V") {
            } else if (formObject.message_1.value == "S") {
                if(_errMsg == '' || _errMsg == null) {
                    formObject.updated_rows_cnt_1.value = sheetObj.CheckedRows('chk');
                    formObject.verify_result_str_1.value = "Saving has been completed.";
                } else {
                    formObject.updated_rows_cnt_1.value = '0';
                    formObject.verify_result_str_1.value = _errMsg;
                }
            }
            formObject.message_1.value = "";
        } else {
            ComOpenWait(false);
            ComShowCodeMessage('TRS90039');
        }
    }
}

/**
  * Saving the rate passing Chassis Verify function
  */
function update2(sheetObj) {
    var formObject = document.form;
    
    ComOpenWait(true);
    var sheet2_count = sheetObj.RowCount();
    var check_verify = sheetObj.CheckedRows('ck_vf');
    var check_result = false;

    var check_row = sheetObj.CheckedRows('chk');
    if(check_row == '') {
        ComOpenWait(false);
        ComShowCodeMessage('TRS90036');
        return;
    }

    for(var k = sheetObj.HeaderRows(); k < sheet2_count + sheetObj.HeaderRows(); k++) {
        if (sheetObj.GetRowStatus(k) == 'I' || sheetObj.GetRowStatus(k) == 'U') {
            if(sheetObj.GetCellValue(k, 'rlt') != 'OK') {
                check_result = true;
            }
        }
    }

    if(check_verify > 0 && check_result) {
        ComOpenWait(false);
        ComShowCodeMessage('TRS90039');
        formObject.verify_result_str_1.value = "Please click on the 'Verify' button.";
        return false;
    }

    var y1 = formObject.fm_agmtno.value;
    formObject.message_2.value = "S";
    var verify_2 = formObject.verify_result_2.value;
    var verify_3 = formObject.verify_check_yn_2.value;
    var checkList = sheetObj.FindCheckedRow('chk');
    var checkArray = checkList.split('|');
    formObject.total_rows_cnt_2.value = checkArray.length;

    if(sheet2_count > 0) {
        if(verify_2 == 0 && verify_3 == "Y") {
            formObject.f_cmd.value = MULTI;
            sheetObj.DoSave("ESD_TRS_0221GS.do", TrsFrmQryString(formObject), "chk", false, true);
            if(formObject.message_2.value == "V") {
            	
            } else if(formObject.message_2.value == "S") {
                if(_errMsg == '' || _errMsg == null) {
                    formObject.updated_rows_cnt_2.value = sheetObj.CheckedRows('chk');
                    formObject.verify_result_str_2.value = "Saving has been completed.";
                } else {
                    formObject.updated_rows_cnt_2.value = '0';
                    formObject.verify_result_str_2.value = _errMsg;
                }
            }
            formObject.message_2.value = "";
        } else {
            ComOpenWait(false);
            ComShowCodeMessage('TRS90039');
        }
    }
}

/**
  * Saving the rate passing Genset Verify function
  */
function update3(sheetObj) {
    var formObject = document.form;
    ComOpenWait(true);
    var sheet2_count = sheetObj.RowCount();
    var check_verify = sheetObj.CheckedRows('ck_vf');
    var check_result = false;
    
    var check_row = sheetObj.CheckedRows('chk');
    if(check_row == '') {
        ComOpenWait(false);
        ComShowCodeMessage('TRS90036');
        return;
    }

    for(var k = sheetObj.HeaderRows(); k < sheet2_count + sheetObj.HeaderRows(); k++) {
        if (sheetObj.GetRowStatus(k) == 'I' || sheetObj.GetRowStatus(k) == 'U') {
            if(sheetObj.GetCellValue(k, 'rlt') != 'OK') {
                check_result = true;
            }
        }
    }

    if(check_verify > 0 && check_result) {
        ComOpenWait(false);
        ComShowCodeMessage('TRS90039');
        formObject.verify_result_str_1.value = "Please click on the 'Verify' button.";
        return false;
    }

    var y1 = formObject.fm_agmtno.value;
    formObject.message_3.value = "S";
    var verify_2 = formObject.verify_result_3.value;
    var verify_3 = formObject.verify_check_yn_3.value;
    var checkList = sheetObj.FindCheckedRow('chk');
    var checkArray = checkList.split('|');
    formObject.total_rows_cnt_3.value = checkArray.length;

    if(sheet2_count > 0)     {
        if(verify_2 == 0 && verify_3 == "Y") {
            formObject.f_cmd.value = MULTI;
            sheetObj.DoSave("ESD_TRS_0221GS.do", TrsFrmQryString(formObject), "chk", false, true);
            if(formObject.message_3.value == "V") {
            	
            } else if(formObject.message_3.value == "S") {
                if(_errMsg == '' || _errMsg == null) {
                    formObject.updated_rows_cnt_3.value = sheetObj.CheckedRows('chk');
                    formObject.verify_result_str_3.value = "Saving has been completed.";
                } else {
                    formObject.updated_rows_cnt_3.value = '0';
                    formObject.verify_result_str_3.value = _errMsg;
                }
            }
            formObject.message_3.value = "";
        } else {
            ComOpenWait(false);
            ComShowCodeMessage('TRS90039');
        }
    }
}

/**
  * sheet2 Excel Upload
  */
function sheet2_OnLoadExcel(sheetObj, result, code, msg) {
    if(isExceedMaxRow(msg))return;
    eq_OnLoadExcel(sheetObj);
}

 /**
 * sheet3 Excel Upload
 */
 function sheet3_OnLoadExcel(sheetObj, result, code, msg) {
	 if(isExceedMaxRow(msg))return;
     eq_OnLoadExcel(sheetObj);
 }
 /**
 * sheet4 Excel Upload
 */
 function sheet4_OnLoadExcel(sheetObj, result, code, msg) {
	 if(isExceedMaxRow(msg))return;
     eq_OnLoadExcel(sheetObj);
 }
 /**
 * Excel Upload
 */
 function eq_OnLoadExcel(sheetObj) {
     var formObj=document.form;
     ComOpenWait(true);
     for(var k=sheetObj.HeaderRows(); k<sheetObj.RowCount()+sheetObj.HeaderRows(); k++) {
         if (k >= CurRowCount) {
             sheetObj.SetCellValue(k,'chk',1,0);
             sheetObj.SetCellValue(k,'ck_vf',1,0);

             sheetObj.SetCellValue(k,'rlt','',0);
             sheetObj.SetCellValue(k,'trsp_agmt_rt_seq','',0);
             
     		var toWgt = sheetObj.GetCellValue(k, "to_wgt").toUpperCase();
     		if(!ComIsNumber(toWgt, ".")){
         		if(toWgt !="MAX"){
         			toWgt = "";
         		}
     		}
         	sheetObj.SetCellValue(k, "to_wgt", toWgt, 0);
        	sheetObj.SetCellValue(k, "wgt_meas_ut_cd", sheetObj.GetCellValue(k, "wgt_meas_ut_cd").toUpperCase(), 0);

             if(sheetObj.GetCellValue(k, "cgo_tp_cd") == "M" && sheetObj.GetCellValue(k, "spcl_cgo_cntr_tp_cd").length > 0) {
            	 ComShowCodeMessage("TRS90421");
                 sheetObj.SelectCell(k, "spcl_cgo_cntr_tp_cd");
             }
         }
     }
     ComOpenWait(false);
 }
 /**
  * An Event after saving Container 
  */
function sheet2_OnSaveEnd(sheetObj, errMsg) {
	ComOpenWait(false);
    eq_SaveEnd(sheetObj, errMsg);
}
 /**
 * An Event after saving Chassis 
 */
 function sheet3_OnSaveEnd(sheetObj, errMsg) {
    ComOpenWait(false);
     eq_SaveEnd(sheetObj, errMsg);
 }
 /**
 * An Event after saving Genset 
 */
 function sheet4_OnSaveEnd(sheetObj, errMsg) {
    ComOpenWait(false);
     eq_SaveEnd(sheetObj, errMsg);
 }
 /**
 * An Event after saving 
 */
 function eq_SaveEnd(sheetObj, errMsg) {
      if( errMsg.length > 0 ) {
         _errMsg = errMsg;
     } else {
         if( document.form.f_cmd.value == REMOVE ) {
             eq_delete(sheetObj, "chk"); 
             errMsg=ComGetMsg("TRS90331");
             ComShowMessage(errMsg);
         }else if( document.form.f_cmd.value == MULTI ) {
             for(var k=sheetObj.HeaderRows(); k<sheetObj.RowCount()+sheetObj.HeaderRows(); k++)
             {
                 sheetObj.SetCellValue(k, "org_eqtype","",0);
                 sheetObj.SetCellValue(k, "org_rt_seq","",0);
                 sheetObj.SetRowStatus(k,"R");
             }
         }
         _errMsg = '';
     }
     doActionIBSheet(sheetObj, document.form, "RETRIEVE");
 }
 /*
  * Deleting checked data from grid
  */
 function eq_delete_ui(fromSheet, sStatus) {
     var fromRow=0;
     var sRow=fromSheet.FindCheckedRow(sStatus);
     var arrRow=sRow.split("|");
     for (ir=arrRow.length-1; ir >=0 ; ir--) {
         fromRow=arrRow[ir];
         if (fromSheet.GetCellValue(fromRow,"ibflag") == 'I') {
             fromSheet.RowDelete(fromRow, false);
         }
     }
 }
 /*
  * Deleting checked data from grid
  */
 function eq_delete(fromSheet, sStatus) {
     var fromRow=0;
     var sRow=fromSheet.FindCheckedRow(sStatus);
     var arrRow=sRow.split("|");
     for (ir=arrRow.length-1; ir >=0 ; ir--) {
         fromRow=arrRow[ir];
         // Removing from origin
         fromSheet.RowDelete(fromRow, false);
     }
 }
  /*
   * When Effective Date is changed
   */
  function input_change() {
      reset_all1();
      reset_all2();
      reset_all3();
  }
/*
* Multi-Calendar input Pop-Up
*/
function getCalendar1() {
    var cal=new ComCalendarFromTo();
    cal.displayType="date";
    cal.select(document.form.fm_eff_fm_dt1, document.form.fm_eff_to_dt1, 'yyyy-MM-dd');
}
/*
* Multi-Calendar input Pop-Up
*/
function getCalendar2() {
    var cal=new ComCalendarFromTo();
    cal.displayType="date";
    cal.select(document.form.fm_eff_fm_dt2, document.form.fm_eff_to_dt2, 'yyyy-MM-dd');
}
/*
* Multi-Calendar input Pop-Up
*/
function getCalendar3() {
    var cal=new ComCalendarFromTo();
    cal.displayType="date";
    cal.select(document.form.fm_eff_fm_dt3, document.form.fm_eff_to_dt3, 'yyyy-MM-dd');
}

function date_apply(fromSheet, sheetno) {
    var formObj=document.form;
    var sheet_count=fromSheet.RowCount();
    var eff_fm_dt="";
    var eff_to_dt="";
    if (sheetno == "1") {
        eff_fm_dt=doSepRemove(doSepRemove(formObj.fm_eff_fm_dt1.value, " "), "-");
        eff_to_dt=doSepRemove(doSepRemove(formObj.fm_eff_to_dt1.value, " "), "-");
    }else if (sheetno == "2") {
        eff_fm_dt=doSepRemove(doSepRemove(formObj.fm_eff_fm_dt2.value, " "), "-");
        eff_to_dt=doSepRemove(doSepRemove(formObj.fm_eff_to_dt2.value, " "), "-");
    }else if (sheetno == "3") {
        eff_fm_dt=doSepRemove(doSepRemove(formObj.fm_eff_fm_dt3.value, " "), "-");
        eff_to_dt=doSepRemove(doSepRemove(formObj.fm_eff_to_dt3.value, " "), "-");
    }
    if ( eff_fm_dt.length < 8 || eff_to_dt.length < 8) {
        ComShowCodeMessage('TRS90070');
        return;
    }
    if (fromSheet.CheckedRows('chk') == 0 ) {
        ComShowCodeMessage('TRS90386', 'There is no row selected to update');
        return;
    }
    if (!ComShowCodeConfirm("TRS90386", "Are you sure to update effective date of ticked rows?")) return;
    if(sheet_count>0){
        for(var t=2; t < sheet_count+2; t++) {
            if( fromSheet.GetCellValue(t, 'chk') == '1' )
            {
                fromSheet.SetCellValue(t, 'eff_fm_dt',eff_fm_dt);
                fromSheet.SetCellValue(t, 'eff_to_dt',eff_to_dt);
            }
        }
        ComShowCodeMessage('TRS90386', 'Date Apply Completed');
    }
}
/**
 * RATE SCALING event
 **/
function rat_caling(fromSheet) {
    var formObject=document.form;
    var sheet_count=fromSheet.RowCount();
    var y1=formObject.fm_scal_rate_type.value;
    var y2=formObject.fm_round_off.value;
    var y3=formObject.fm_scal_value.value;
    var y4=formObject.fm_scal_uom.value;
    var updateFlg=false;
    var x1="";
    var x2="";
    if(sheet_count>0){
        for(var t=2; t < sheet_count+2; t++) {
            if( fromSheet.GetCellValue(t, 'chk') == '1' ) {
                var rate_oneway=fromSheet.GetCellValue(t, 'trsp_one_wy_rt');
                var rate_round=fromSheet.GetCellValue(t, 'trsp_rnd_rt');
                if(y4 =="0"){  //Scaling UOM %
                    if(y1 =="1"){  //oneway
                        x1=parseFloat(rate_oneway) + parseFloat((y3 * rate_oneway)/100)  ;
                    if(rate_oneway !=""){                
                        if(y2=="1"){                    
                            fromSheet.SetCellValue(t, 'trsp_one_wy_rt',myRound(x1,1));
                        }else if(y2=="0"){                                                    
                            fromSheet.SetCellValue(t, 'trsp_one_wy_rt',myRound(x1,0));
                        }else if(y2=="2"){                                                    
                            fromSheet.SetCellValue(t, 'trsp_one_wy_rt',myRound(x1,2));
                        }else{                                                                                            
                            fromSheet.SetCellValue(t, 'trsp_one_wy_rt',myRound(x1,3));
                        }
                        fromSheet.SelectCell(t,'trsp_one_wy_rt');
                        updateFlg=true;
                    }
                    }else{  //Roundtrip
                        x2=parseFloat(rate_round) + parseFloat((y3 * rate_round)/100); 
                    if(rate_round !=""){
                        if(y2=="1"){
                            fromSheet.SetCellValue(t, 'trsp_rnd_rt',myRound(x2,1));
                        }else if(y2=="0"){
                            fromSheet.SetCellValue(t, 'trsp_rnd_rt',myRound(x2,0));
                        }else if(y2=="2"){
                            fromSheet.SetCellValue(t, 'trsp_rnd_rt',myRound(x2,2));
                        }else{
                            fromSheet.SetCellValue(t, 'trsp_rnd_rt',myRound(x2,3));
                        }
                        fromSheet.SelectCell(t,'trsp_rnd_rt');
                        updateFlg=true;
                    }
                    }
                }else{
                    if(y1 =="1"){  //oneway
                        if(rate_oneway !=""){
                            fromSheet.SetCellValue(t, 'trsp_one_wy_rt',parseFloat(rate_oneway) +  parseFloat(y3));
                            fromSheet.SelectCell(t,'trsp_one_wy_rt');
                            updateFlg=true;
                        }
                    }else{  //Roundtrip
                        if(rate_round !=""){
                            fromSheet.SetCellValue(t, 'trsp_rnd_rt',parseFloat(rate_round) + parseFloat(y3));
                            fromSheet.SelectCell(t,'trsp_rnd_rt');
                            updateFlg=true;
                        }
                    }
                }
            }
        }//for(var t=1; t < p; t++) {
            if(updateFlg) ComShowCodeMessage('COM12116', 'Rate Scaling');
        }    
}
/**
*  Container Reset
*/
function reset_all1(){
    var formObject=document.form;
    formObject.tot_page_cnt1.value="";
    formObject.cur_page_cnt1.value="";
    formObject.verify_result_1.value="";
    formObject.verify_result_str_1.value="";
    formObject.updated_rows_cnt_1.value="";
    formObject.total_rows_cnt_1.value="";
    formObject.verify_check_yn_1.value="N";
    sheet2.RemoveEtcData();
    sheet2.RemoveAll();
}
/**
*  Chassis Reset
*/
function reset_all2(){
    var formObject=document.form;
    formObject.tot_page_cnt2.value="";
    formObject.cur_page_cnt2.value="";
    formObject.verify_result_2.value="";
    formObject.verify_result_str_2.value="";
    formObject.updated_rows_cnt_2.value="";
    formObject.total_rows_cnt_2.value="";
    formObject.verify_check_yn_2.value="N";
    sheet3.RemoveEtcData();
    sheet3.RemoveAll();
}
/**
*  Genset Reset
*/
function reset_all3(){
    var formObject=document.form;
    formObject.tot_page_cnt3.value="";
    formObject.cur_page_cnt3.value="";
    formObject.verify_result_3.value="";
    formObject.verify_result_str_3.value="";
    formObject.updated_rows_cnt_3.value="";
    formObject.total_rows_cnt_3.value="";
    formObject.verify_check_yn_3.value="N";
    sheet4.RemoveEtcData();
    sheet4.RemoveAll();
}
/*
 * Verify Rule popup
 */
function openHelp() {
    var formObj=document.form;
    var Option="width=680,height=700,menubar=0,status=0,scrollbars=3,resizable=0";
    window.open('apps/opus/esd/trs/agreementmanage/agreementmanage/html/pair_verify_rule.htm', "popupHelpP", Option);
}
   /**
* From Node popup's return value
*/
function getFromNode(rowArray) {
    var formObject=document.form;
    var colArray=rowArray[0];
    var node=colArray[3];
    var lvLoc=node.substring(0, 5);
    var lvYard=node.substring(5, 7);
    formObject.search_fm_loc.value=lvLoc;
    getYardCombo(search_fm_yard, sheetObjects[0], formObject, lvLoc);
    search_fm_yard.SetSelectCode(lvYard);    
}
/**
* Via Node popup's return value
*/
function getViaNode(rowArray) {
    var formObject=document.form;
    var colArray=rowArray[0];
    var node=colArray[3];
    var lvLoc=node.substring(0, 5);
    var lvYard=node.substring(5, 7);
    formObject.search_via_loc.value=lvLoc;
       getYardCombo(search_via_yard, sheetObjects[0], formObject, lvLoc);
       search_via_yard.SetSelectCode(lvYard);
}
/**
* To Node popup's return value
*/
function getToNode(rowArray) {
       var formObject=document.form;
       var colArray=rowArray[0];
       var node=colArray[3];
       var lvLoc=node.substring(0, 5);
       var lvYard=node.substring(5, 7);
       formObject.search_to_loc.value=lvLoc;
       getYardCombo(search_to_yard, sheetObjects[0], formObject, lvLoc);
       search_to_yard.SetSelectCode(lvYard);
}
/**
* Door Location popup's return value
*/
function getDorLoc(rowArray) {
    var formObject=document.form;
    var colArray=rowArray[0];
    var node=colArray[3];
    var lvLoc=node.substring(0, 5);
    var lvYard=node.substring(5, 7);
    formObject.search_door_loc.value=lvLoc;
    getZoneCombo(search_door_yard, sheetObjects[0], formObject, lvLoc);
    search_door_yard.SetSelectCode(lvYard);
}
/**
* General Node popup
*/
function openHireYardPopup(objName) {
    var formObject=document.form;
    var cmdt_cd_val="";   
    var rep_cmdt_cd_val="";   
    var cmdt_desc_val="";   
    var classId=objName;
    var xx1=""; //CONTI
    var xx2=""; //SUB CONTI
    var xx3=""; //COUNTRY
    var xx4=""; //STATE
    var xx5=""; //CONTROL OFFIC
    var xx6=""; //LOC CODE
    var xx7=""; //LOC NAME
    var xx8="";
    var xx9="";
    if( objName == "getDorLoc" ) {
        v6="zone"
    } else {
        v6="yard";
    }
    var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&mode="+v6;
    ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 772, 500, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}
  function openRateHistory(sheetObject) {
      var formObj=document.form;
      var checkList=sheetObject.FindCheckedRow('chk');
      var checkArray=checkList.split('|');
      var resultcheck=0;
      if(checkList.length < 1) {
          ComShowCodeMessage('TRS90215'); 
          return;
      }
      var agmt_no=formObj.fm_agmtno.value;
      var trsp_agmt_rt_tp_cd=formObj.fm_trsp_agmt_rt_tp_cd.value;
      var trsp_cost_mod_cd=sheetObject.GetCellValue(checkArray[0], 'trsp_cost_mod_cd');
      var agmt_trsp_tp_cd=sheetObject.GetCellValue(checkArray[0], 'agmt_trsp_tp_cd');
      var cgo_tp_cd=sheetObject.GetCellValue(checkArray[0], 'cgo_tp_cd');
      var cust_cd=sheetObject.GetCellValue(checkArray[0], 'cust_cd');
      var cmdt_grp_cd=sheetObject.GetCellValue(checkArray[0], 'cmdt_grp_cd');
      var rail_svc_tp_cd=sheetObject.GetCellValue(checkArray[0], 'rail_svc_tp_cd');
      var fm_nod_cd=sheetObject.GetCellValue(checkArray[0], 'fm_nod_cd');
      var fm_nod_yd=sheetObject.GetCellValue(checkArray[0], 'fm_nod_yd');
      var via_nod_cd=sheetObject.GetCellValue(checkArray[0], 'via_nod_cd');
      var via_nod_yd=sheetObject.GetCellValue(checkArray[0], 'via_nod_yd');
      var dor_nod_cd=sheetObject.GetCellValue(checkArray[0], 'dor_nod_cd');
      var dor_nod_yd=sheetObject.GetCellValue(checkArray[0], 'dor_nod_yd');
      var to_nod_cd=sheetObject.GetCellValue(checkArray[0], 'to_nod_cd');
      var to_nod_yd=sheetObject.GetCellValue(checkArray[0], 'to_nod_yd');
      var trsp_dist_tp_cd=sheetObject.GetCellValue(checkArray[0], 'trsp_dist_tp_cd');
      var trsp_agmt_dist=sheetObject.GetCellValue(checkArray[0], 'trsp_agmt_dist');
      var dist_meas_ut_cd=sheetObject.GetCellValue(checkArray[0], 'dist_meas_ut_cd');
      formObj.chk_trsp_cost_mod_cd.value=trsp_cost_mod_cd   ;
      formObj.chk_agmt_trsp_tp_cd.value=agmt_trsp_tp_cd    ;
      formObj.chk_cgo_tp_cd.value=cgo_tp_cd          ;
      formObj.chk_cust_cd.value=cust_cd            ;
      formObj.chk_cmdt_grp_cd.value=cmdt_grp_cd        ;
      formObj.chk_rail_svc_tp_cd.value=rail_svc_tp_cd     ;
      formObj.chk_fm_nod_cd.value=fm_nod_cd          ;
      formObj.chk_fm_nod_yd.value=fm_nod_yd          ;
      formObj.chk_via_nod_cd.value=via_nod_cd         ;
      formObj.chk_via_nod_yd.value=via_nod_yd         ;
      formObj.chk_dor_nod_cd.value=dor_nod_cd         ;
      formObj.chk_dor_nod_yd.value=dor_nod_yd         ;
      formObj.chk_to_nod_cd.value=to_nod_cd          ;
      formObj.chk_to_nod_yd.value=to_nod_yd          ;
      formObj.chk_trsp_dist_tp_cd.value=trsp_dist_tp_cd    ;
      formObj.chk_trsp_agmt_dist.value=trsp_agmt_dist     ;
      formObj.chk_dist_meas_ut_cd.value=dist_meas_ut_cd    ;
      if(checkArray.length > 0){
          resultcheck=1;
          for(var i=0; i<checkArray.length-1; i++){
              if(sheetObject.GetCellValue(checkArray[0], 'trsp_cost_mod_cd') == sheetObject.GetCellValue(checkArray[i], 'trsp_cost_mod_cd')){
              }else{
                  resultcheck++;
              }
          }
      }
      if(resultcheck == 1){
          var myOption="width=980,height=530,menubar=0,status=0,scrollbars=0,resizable=0";
          var param="?"+TrsFrmQryString(formObj);
          myWin=window.open('/opuscntr/ESD_TRS_0227.do' + param, "Hispopup", myOption);          
      }else if(resultcheck == 0){
          ComShowCodeMessage('TRS90215');
      }else if(resultcheck > 1){
          ComShowCodeMessage('TRS90357');
      }
  }
  
  /**
   * EffectiveDate Duplicate Check
   * @param sheetObj
   * @param dupKey
   * @returns {Boolean}
   */
  
  function checkEffectiveDate(sheetObj, dupKey) {
		
	    var dupRows = sheetObj.ColValueDupRows(dupKey, 1, 1);
	    
	    var effectiveDateCheck = true;
	    if(dupRows != "") {
	        var dupKeyArray = dupKey.split("|"); //중복검사 컬럼
	    	
	        var dupRowsArray = dupRows.split("|");
	        var dupRowsArray2 = dupRowsArray[0].split(","); //중복된 최초 기중행
	        var dupRowsArray3 = dupRowsArray[1].split(","); //기준행으로 중복된 행
	        var dupRowsArray4 = dupRowsArray2.concat(dupRowsArray3);
	        var checkLen2 = dupRowsArray2.length;
	        var checkLen3 = dupRowsArray3.length;
	        var checkLen4 = dupRowsArray4.length;
	        var colValueJoin2;
	        var colValueJoin3;

	        var effectiveDateCheck = true;
	        // 중복된 최초 기준행별로 유효일자 검사
	        for(var idx = 0; idx < checkLen2; idx++) {
	            var dateCheck = true;
	        	// 중복된 최초 기준행의 중복검사 컬럼들 값을 합침
	            colValueJoin2 = "";
				for(var dup = 0; dup < dupKeyArray.length; dup++) {
					colValueJoin2 += sheetObj.GetCellValue(dupRowsArray2[idx], dupKeyArray[dup]);
				}
	        	// 기준행으로 중복된 행이 비교대상이됨
				for(var idx2 = 0; idx2 < checkLen3; idx2++) {
					// 기준행으로 중복된 행의 중복검사 컬럼들 값을 합침
					colValueJoin3 = "";
					for(var dup = 0; dup < dupKeyArray.length; dup++) {
						colValueJoin3 += sheetObj.GetCellValue(dupRowsArray3[idx2], dupKeyArray[dup]);
					}
					
					// 중복행인 경우 유효일자 검사
					if(colValueJoin2 == colValueJoin3) {
	                    var checkedEffFmDt = sheetObj.GetCellValue(dupRowsArray2[idx], "eff_fm_dt");
	                    var checkedEffToDt = sheetObj.GetCellValue(dupRowsArray2[idx], "eff_to_dt");
	                    var sheetRowEffFmDt = sheetObj.GetCellValue(dupRowsArray3[idx2], "eff_fm_dt");
	                    var sheetRowEffToDt = sheetObj.GetCellValue(dupRowsArray3[idx2], "eff_to_dt");
	                    if((sheetRowEffFmDt <= checkedEffFmDt && checkedEffFmDt <= sheetRowEffToDt) ||
	                 	   (sheetRowEffFmDt <= checkedEffToDt && checkedEffToDt <= sheetRowEffToDt) ||
	                 	   (checkedEffFmDt <= sheetRowEffFmDt && sheetRowEffToDt <= checkedEffToDt) ||
	                 	   (sheetRowEffFmDt <= checkedEffFmDt && checkedEffToDt <= sheetRowEffToDt)
	                    ) {
	                        dateCheck = false;

		                    if(sheetObj.GetRowEditable(dupRowsArray2[idx])){
		    					sheetObj.SetCellValue(dupRowsArray2[idx], 'rlt', 'Effective Date Duplicate.', 0);
		    					sheetObj.SetCellValue(dupRowsArray2[idx], 'rlt2', sheetObj.GetCellValue(dupRowsArray2[idx],'ui_seqno') + " & " + sheetObj.GetCellValue(dupRowsArray3[idx2],'ui_seqno'), 0);
		                    }
		                    if(sheetObj.GetRowEditable(dupRowsArray3[idx2])){
		    					sheetObj.SetCellValue(dupRowsArray3[idx2], 'rlt', 'Effective Date Duplicate.', 0);
		    					sheetObj.SetCellValue(dupRowsArray3[idx2], 'rlt2', sheetObj.GetCellValue(dupRowsArray2[idx],'ui_seqno') + " & " + sheetObj.GetCellValue(dupRowsArray3[idx2],'ui_seqno'), 0);
		                    }
		                    sheetObj.SelectCell(dupRowsArray3[idx2], "eff_fm_dt");
//		                    break;
	                    }
					}
					
				}

		        if(!dateCheck) {
		            effectiveDateCheck = false;
		        }
	        }
		}
	    return effectiveDateCheck;
  }
  
  /**
   * Set rate sequence to delete
   */
  function setRateSequence(sheetObj, checkRowArray, startColSaveName, endColSaveName, colSaveNamePostfix) {
	  for(var row = 0; row < checkRowArray.length; row++) {
	        var start = sheetObj.SaveNameCol(startColSaveName);
	        var end = sheetObj.SaveNameCol(endColSaveName);
	        var start_seq = sheetObj.SaveNameCol(startColSaveName + colSaveNamePostfix);
	        var end_seq = sheetObj.SaveNameCol(endColSaveName + colSaveNamePostfix);
	        var org_rt_seq = "";
	        var cnt = 0;
	        
	        for(var col = start; col <= end; col++) {
	        	// check only UPDATE case
	        	if(sheetObj.GetCellValue(checkRowArray[row], "ibflag") != "U")
	        		continue;
	        	// when unchecked
	            if(sheetObj.GetCellValue(checkRowArray[row], col) == "" || sheetObj.GetCellValue(checkRowArray[row], col) == "0") {
	            	var ndx = start_seq + cnt;
	            	// when rt_seq exist
	            	if(sheetObj.GetCellValue(checkRowArray[row], ndx).length > 0) {
	            		var nm = sheetObj.ColSaveName(ndx);
	            		var tpsz = nm.substring(3, nm.lastIndexOf("rt_seq"));
		            	org_rt_seq = org_rt_seq + tpsz + sheetObj.GetCellValue(checkRowArray[row], ndx) + ","; // SAMPLE : d4_34938294,
	            	}else{
	            		org_rt_seq = org_rt_seq + "0,";
	            	}
	            }
	            cnt ++;
	        }
	        
	        sheetObj.SetCellValue(checkRowArray[row], "org_rt_seq", org_rt_seq.substring(0, org_rt_seq.length-1), 0);
	        //alert("org_eqtype: " + sheetObj.GetCellValue(checkRowArray[row], "org_eqtype"));
	        //alert("org_rt_seq: " + sheetObj.GetCellValue(checkRowArray[row], "org_rt_seq"));
      }
  }

  /**
   * Reset Verification Result Description & Duplication
   * @param sheetObj
   * @param row
   */
  function reSetResultText(sheetObj, row) {
  	if(row=='') {
  		row = 0;
  	}
      var Row1 = sheetObj.FindText("rlt", 'Effective Date Duplicate.', row, -1, 0);
      if(Row1 == -1) {
      	return;
      }
      if(sheetObj.GetCellValue(Row1, "chk") == "0") {
      	sheetObj.SetCellValue(Row1, 'rlt', '', 0);
      	sheetObj.SetCellValue(Row1, 'rlt2', '', 0);
      }
  	
  	reSetResultText(sheetObj, Row1+1);
  	return;
  }

  /**
   * Tool Tip
   * @param sheetObj
   * @param Button
   * @param Shift
   * @param X
   * @param Y
   */
  function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y) {
  	if(mouseRow < 2) return;
  	var formObj = document.form;
  	var mouseRow = sheetObj.MouseRow();
  	var mouseCol = sheetObj.MouseCol();
  	var colSaveName = sheetObj.ColSaveName(mouseCol);
  	switch(colSaveName) {
  		case "fm_nod_yd" :
  		case "via_nod_yd" :
  		case "to_nod_yd" :
  		case "dor_nod_yd" :  
  			setYdNameToolTip(sheetObj, mouseRow, mouseCol, formObj);
  			break;
  		case "fm_nod_cd" :
  		case "via_nod_cd" :
  		case "to_nod_cd" :
  		case "dor_nod_cd" :	
  			setLocationNameToolTip(sheetObj, mouseRow, mouseCol, formObj);
  			break;
  		default : break;	
  	}
  }

  /**
   * Tool Tip
   * @param sheetObj
   * @param Button
   * @param Shift
   * @param X
   * @param Y
   */
  function sheet3_OnMouseMove(sheetObj, Button, Shift, X, Y) {
  	if(mouseRow < 2) return;
  	var formObj = document.form;
  	var mouseRow = sheetObj.MouseRow();
  	var mouseCol = sheetObj.MouseCol();
  	var colSaveName = sheetObj.ColSaveName(mouseCol);
  	switch(colSaveName) {
  		case "fm_nod_yd" :
  		case "via_nod_yd" :
  		case "to_nod_yd" :
  		case "dor_nod_yd" :  
  			setYdNameToolTip(sheetObj, mouseRow, mouseCol, formObj);
  			break;
  		case "fm_nod_cd" :
  		case "via_nod_cd" :
  		case "to_nod_cd" :
  		case "dor_nod_cd" :	
  			setLocationNameToolTip(sheetObj, mouseRow, mouseCol, formObj);
  			break;
  		default : break;	
  	}
  }

  /**
   * Tool Tip
   * @param sheetObj
   * @param Button
   * @param Shift
   * @param X
   * @param Y
   */
  function sheet4_OnMouseMove(sheetObj, Button, Shift, X, Y) {
  	if(mouseRow < 2) return;
  	var formObj = document.form;
  	var mouseRow = sheetObj.MouseRow();
  	var mouseCol = sheetObj.MouseCol();
  	var colSaveName = sheetObj.ColSaveName(mouseCol);
  	switch(colSaveName) {
  		case "fm_nod_yd" :
  		case "via_nod_yd" :
  		case "to_nod_yd" :
  		case "dor_nod_yd" :  
  			setYdNameToolTip(sheetObj, mouseRow, mouseCol, formObj);
  			break;
  		case "fm_nod_cd" :
  		case "via_nod_cd" :
  		case "to_nod_cd" :
  		case "dor_nod_cd" :	
  			setLocationNameToolTip(sheetObj, mouseRow, mouseCol, formObj);
  			break;
  		default : break;	
  	}
  }

  /**
   * 
   * @param sheetObj
   * @param Row
   * @param Col
   * @param formObj
   */
  function setYdNameToolTip(sheetObj, Row, Col, formObj) {
  	var nodValue = sheetObj.GetCellValue(Row, Col-1);
  	var ydValue = sheetObj.GetCellValue(Row, Col);
  	var CurNodYard;
  	if(!ComIsNull(ydValue)) {
  		CurNodYard = nodValue + ydValue;
		sheetObj.SetToolTipText(Row, Col, GetYardName(sheetObj, formObj, CurNodYard, "Y"));
  	} else {
  		sheetObj.SetToolTipText(Row, Col, "");
  	}
  }

  /**
   * 
   * @param sheetObj
   * @param Row
   * @param Col
   * @param formObj
   */
  function setLocationNameToolTip(sheetObj, Row, Col, formObj) {
  	var nodValue = sheetObj.GetCellValue(Row, Col);
  	if(!ComIsNull(nodValue)) {
		sheetObj.SetToolTipText(Row, Col, GetYardName(sheetObj, formObj, nodValue, "N"));
  	} else {
  		sheetObj.SetToolTipText(Row, Col, "");
  	}
  }