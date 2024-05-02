/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0221.js
*@FileTitle  : Agreement Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================*/

var _errMsg = '';

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
*/
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1: // sheet0 init ( ATMT Header ) Hidden Sheet
            with(sheetObj){            
                var HeadTitle1="AGMT CITY CODE|AGMT NO|VNDR_SEQ|VNDR_NM|CONTRACT OFFICE CODE|REFERENCE NUMBER|PIC NAME|REMARK" ;
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center" } ];
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
                    {Type:"Text", Hidden:1, Width:40,  Align:"Right",ColMerge:0, SaveName:"img_flg",              KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 }
                ];
            InitColumns(cols);
            SetEditable(1);
            SetVisible(0);
        }
        break;

        case 2: // sheet1 init ( Child S/P )
            with(sheetObj) {
                var HeadTitle1="SEQ|Child Service|Child Service" ;
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
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

        case 3: // sheet2 init ( Rate ) : Container Tab
            with(sheetObj) {
                var HeadTitle1="|Seq|Container Verification Result|Container Verification Result|Duplication|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type" +
                               "|From|From|Via|Via|Door|Door|To|To|Currency" +
                               "|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size" +
                               "|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size" +
                               "|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size" +
                               "|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size" +
                               "|One Way\n(CY rate)|Round Trip\n(DR rate)|Feeder Term|Feeder Term|No of\nContainer|Weight\nTier|UOM|Reverse|COA|Effective Date|Effective Date|UDU" +
                               "||";
                var HeadTitle2="|Seq|Status|Description|Duplication|Cost\nMode|Trans\nMode|T/Ship|Cargo\nType|Cargo\nNature|Customer\nCode|Commodity\nGroup Code|Rail Service\nType" +
                               "|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Currency" +
                               "|ALAL|DAL|RAL|AAL|FAL|TAL|SAL|OAL|PAL|AL2" +
                               "|AL4|AL5|AL7|AL9|D2|D4|D5|D7|R2|R4" +
                               "|R5|R7|A2|A4|F2|F4|F5|T2|T4|S2" +
                               "|S4|O2|O4|P2|P4" +
                               "|One Way\n(CY rate)|Round Trip\n(DR rate)|Receiving|Delivery|No of\nContainer|Weight\nTier|UOM|Reverse|COA|From|To|UDU" +
                               "||";
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:5, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
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
                    {Type:"Combo",    Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"spcl_cgo_cntr_tp_cd",    KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
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

                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_alal",                KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_dal",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_ral",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_aal",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_fal",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_tal",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_sal",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_oal",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_pal",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al2",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al4",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al5",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al7",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al9",                 KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_d2",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_d4",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_d5",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_d7",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_r2",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_r4",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_r5",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_r7",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_a2",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_a4",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_f2",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_f4",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_f5",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_t2",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_t4",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_s2",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_s4",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_o2",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_o4",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_p2",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_p4",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },

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
                    {Type:"CheckBox", Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"chk2",                   KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1 },

                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_ofc_cty_cd",   KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:6 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_rt_tp_ser_no", KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:4 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_nod_seq",      KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12},
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_rt_seq",       KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12},
                    {Type:"Text",     Hidden:1, Width:80,  Align:"Center", ColMerge:1, SaveName:"eq_knd_cd",              KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:10}
                ];
                InitColumns(cols);
                SetEditable(1);
                SetColProperty('trsp_cost_mod_cd',    {ComboText:"|"+trsp_cost_mod_cdCode,    ComboCode:"|"+trsp_cost_mod_cdCode} );
                SetColProperty('agmt_trsp_tp_cd',     {ComboText:"|"+agmt_trsp_tp_cdCode,     ComboCode:"|"+agmt_trsp_tp_cdCode} );
                SetColProperty('trsp_bnd_cd',         {ComboText:"|Y|N",                      ComboCode:"|Y|N"} );
                SetColProperty('cgo_tp_cd',           {ComboText:"|"+cgo_tp_cdCode,           ComboCode:"|"+cgo_tp_cdCode} );
                SetColProperty('spcl_cgo_cntr_tp_cd', {ComboText:"|"+spcl_cgo_cntr_tp_cdCode, ComboCode:"|"+spcl_cgo_cntr_tp_cdCode} );
                SetColProperty('rail_svc_tp_cd',      {ComboText:"|"+rail_svc_tp_cdCode,      ComboCode:"|"+rail_svc_tp_cdCode} );
                SetColProperty('curr_cd',             {ComboText:"|"+curr_cdCode,             ComboCode:"|"+curr_cdCode} );
                SetColProperty('wtr_rcv_term_cd',     {ComboText:"|"+wtr_term_cdCode,         ComboCode:"|"+wtr_term_cdCode} );
                SetColProperty('wtr_de_term_cd',      {ComboText:"|"+wtr_term_cdCode,         ComboCode:"|"+wtr_term_cdCode} );
                SetColProperty('wgt_meas_ut_cd',      {ComboText:"|KGS|LBS",                  ComboCode:"|KGS|LBS"} );
                SetColProperty('trsp_rvs_aply_flg',   {ComboText:"|Y|N",                      ComboCode:"|Y|N"} );

                SetColProperty("cust_cd",             {AcceptKeys:"E|[0123456789]",           InputCaseSensitive:1});
                SetColProperty("cmdt_grp_cd",         {AcceptKeys:"E|N",                      InputCaseSensitive:1});
                SetColProperty("dor_nod_cd",          {AcceptKeys:"E|N",                      InputCaseSensitive:1});
                SetColProperty("dor_nod_yd",          {AcceptKeys:"E|N",                      InputCaseSensitive:1});
                SetColProperty("fm_nod_cd",           {AcceptKeys:"E|N",                      InputCaseSensitive:1});
                SetColProperty("fm_nod_yd",           {AcceptKeys:"E|N",                      InputCaseSensitive:1});
                SetColProperty("via_nod_cd",          {AcceptKeys:"E|N",                      InputCaseSensitive:1});
                SetColProperty("via_nod_yd",          {AcceptKeys:"E|N",                      InputCaseSensitive:1});
                SetColProperty("to_nod_cd",           {AcceptKeys:"E|N",                      InputCaseSensitive:1});
                SetColProperty("to_nod_yd",           {AcceptKeys:"E|N",                      InputCaseSensitive:1});
                SetColProperty("to_wgt",              {AcceptKeys:"E|N",                      InputCaseSensitive:1});
                
                document.form.header_row.value = HeaderRows() - 1;
                SetRangeBackColor(1,1,1,65,"#555555");
                SetSheetHeight(456);
            }
            break;

        case 4: //sheet3 init ( Rate ) : Chassis Tab
            with(sheetObj) {
                var HeadTitle1="|Seq|Chassis Verification Result|Chassis Verification Result|Duplication|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type" +
                               "|From|From|Via|Via|Door|Door|To|To|Currency" +
                               "|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size" +
                               "|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size" +
                               "|One Way\n(CY rate)|Round Trip\n(DR rate)|Feeder Term|Feeder Term|No of\nChassis|Weight\nTier|UOM|Reverse|COA|Effective Date|Effective Date|UDU" +
                               "||";
                var HeadTitle2="|Seq|Status|Description|Duplication|Cost\nMode|Trans\nMode|Cargo\nType|Customer\nCode|Commodity\nGroup Code|Rail Service\nType" +
                               "|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Currency" +
                               "|ALAL|SFAL|SLAL|TAAL|GNAL|EGAL|AL2|AL4|AL5|AL8" +
                               "|SF2|SF4|SL2|TA2|GN4|GN5|EG5|EG8|ZT4|CB4" +
                               "|One Way\n(CY rate)|Round Trip\n(DR rate)|Receiving|Delivery|No of\nChassis|Weight\nTier|UOM|Reverse|COA|From|To|UDU" +
                               "||";
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:5, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, ColResize:1 };
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
                    {Type:"CheckBox", Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"chk2",                   KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1 },

                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_ofc_cty_cd",   KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:6 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_rt_tp_ser_no", KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:4 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_nod_seq",      KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12},
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_rt_seq",       KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12},
                    {Type:"Text",     Hidden:1, Width:80,  Align:"Center", ColMerge:1, SaveName:"eq_knd_cd",              KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:10}
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
                SetColProperty('trsp_rvs_aply_flg', {ComboText:"|Y|N",                   ComboCode:"|Y|N"} );

                SetColProperty("cust_cd",           {AcceptKeys:"E|[0123456789]",        InputCaseSensitive:1});
                SetColProperty("cmdt_grp_cd",       {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("fm_nod_cd",         {AcceptKeys:"E|N",                   InputCaseSensitive:1});      
                SetColProperty("fm_nod_yd",         {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("to_nod_cd",         {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("to_nod_yd",         {AcceptKeys:"E|N",                   InputCaseSensitive:1});   

                document.form.header_row.value = HeaderRows() - 1;
                SetRangeBackColor(1,1,1,3,"#555555");
                SetRangeBackColor(1,4,1,18,"#555555");
                SetRangeBackColor(1,19,1,54,"#555555");
                SetRangeBackColor(1,55,1,58,"#555555");
                SetRangeBackColor(1,62,1,64,"#555555");
                SetSheetHeight(456);
            }
            break;

        case 5: // sheet4 init ( Rate ) : GenSet Tab
            with(sheetObj) {
                var HeadTitle1="|Seq|Genset Verification Result|Genset Verification Result|Duplication|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type" +
                               "|From|From|Via|Via|Door|Door|To|To|Currency" +
                               "|EQ Type/Size|EQ Type/Size|EQ Type/Size" +
                               "|One Way\n(CY rate)|Round Trip\n(DR rate)|Feeder Term|Feeder Term|No of\nGenset|Weight\nTier|UOM|Reverse|COA|Effective Date|Effective Date|UDU" +
                               "||";
                var HeadTitle2="|Seq|Status|Description|Duplication|Cost\nMode|Trans\nMode|Cargo\nType|Customer\nCode|Commodity\nGroup Code|Rail Service\nType" +
                               "|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Currency" +
                               "|ALAL|CG|UG|One Way\n(CY rate)|Round Trip\n(DR rate)|Receiving|Delivery|No of\nGenset|Weight\nTier|UOM|Reverse|COA|From|To|UDU" +
                               "||";
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:5, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, ColResize:1 };
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
                    {Type:"Text",     Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"to_nod_yd",              KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"curr_cd",                KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },

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
/*030*/             {Type:"CheckBox", Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"agmt_cost_flg",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
					{Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"eff_fm_dt",              KeyField:0, CalcLogic:"", Format:"Ymd",         PointCount:0, 	UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"eff_to_dt",              KeyField:0, CalcLogic:"", Format:"Ymd",         PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Text",     Hidden:0, Width:100, Align:"Left",   ColMerge:1, SaveName:"usr_def_rmk",            KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:500 },
                    
                    {Type:"CheckBox", Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"ck_vf",                  KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"CheckBox", Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"chk2",                   KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1 },

                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_ofc_cty_cd",   KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_seq",          KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:6 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_rt_tp_ser_no", KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:4 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_nod_seq",      KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12},
/*040*/             {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_rt_seq",       KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12},
                    {Type:"Text",     Hidden:1, Width:80,  Align:"Center", ColMerge:1, SaveName:"eq_knd_cd",              KeyField:0, CalcLogic:"", Format:"",            PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:10}
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
                SetColProperty('trsp_rvs_aply_flg', {ComboText:"|Y|N",                   ComboCode:"|Y|N"} );

                SetColProperty("cust_cd",           {AcceptKeys:"E|[0123456789]",        InputCaseSensitive:1});
                SetColProperty("fm_nod_cd",         {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("fm_nod_yd",         {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("to_nod_cd",         {AcceptKeys:"E|N",                   InputCaseSensitive:1});
                SetColProperty("to_nod_yd",         {AcceptKeys:"E|N",                   InputCaseSensitive:1});

                document.form.header_row.value = HeaderRows() - 1;
                SetRangeBackColor(1,1,1,3,"#555555");
                SetRangeBackColor(1,4,1,18,"#555555");
                SetRangeBackColor(1,19,1,54,"#555555");
                SetRangeBackColor(1,55,1,58,"#555555");
                SetRangeBackColor(1,62,1,64,"#555555");
                SetSheetHeight(456);
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
* Sheet Default settings and initialization
*/
function loadPage() {
    for(k=0;k<tabObjects.length;k++) {
        initTab(tabObjects[k],k+1);
        tabObjects[k].SetSelectedIndex(0);
    }
    for(i=0;i<sheetObjects.length;i++) {
        ComConfigSheet(sheetObjects[i] ); 
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]); 
    }
    
    initControl();
}

/*------------------From here the common JavaScript function is defined.     ------------------*/

/* Common global variable */
var openWindownm='AGMT';
var sheetObjects=new Array();
var sheetCnt=0;
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var currenttab=0;

document.onclick=processButtonClick;

/* At the bottom of the business by adding a global variable is used to declare. */
var sheetCnt=0;
var Mincount=0;
var CurRowCount=0;

/* Button to process certain filename, separated on a quarterly event handler to handle */
function processButtonClick() {
    var sheetObject=sheetObjects[0]; //Agreement Header Information
    var sheetObject1=sheetObjects[1]; //Agreement Child S/P Information
    var rate_sheetObject=sheetObjects[2]; //Agreement Rate Information
    if (currenttab == 0) {
        rate_sheetObject=sheetObjects[2]; //Agreement Rate Information
    } else if (currenttab == 1) {
        rate_sheetObject=sheetObjects[3]; //Agreement Rate Information
    } else {
        rate_sheetObject=sheetObjects[4]; //Agreement Rate Information
    }

    /*******************************************************/
    var formObject=document.form;
   try {
       var srcName=ComGetEvent("name");
       switch(srcName) {
            /* [1.1.Lookup Logic] */
            case "btn_retrieve":
                if( validateFormSearch() ) {
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    formObject.cur_page_cnt.value = 1;
                    doActionIBSheet(rate_sheetObject, formObject, "RETRIEVE");
                }
            break;
            /* [1.2.minimize button - the screen to minimize] */
            case "btn_minimize":
                Mincount=(Mincount+1)%2;
                Minimize(Mincount);
            break;
            /* [1.3.Create button at the top of] */
            case "btn_creation":
                openAgmtHdrPopup();
            break;
            case "btn_attach":
                openAgmtAttachFilePopup();
            break;
            /* [1.4.At the top of the Agreement No. Button] */
            case "btn_agmtno":
                openAgmtNo();
            break;
            /* [2.1.Add button at the bottom row] */
            case "btng_rowadd":
                doActionIBSheet(rate_sheetObject,formObject,IBINSERT);
            break;
            /* [2.2.Add an Excel file at the bottom of sheet1] */
            case "btng_loadexcel":
                //document.all.btng_verify2.disabled = true;
                doActionIBSheet(rate_sheetObject,formObject,IBLOADEXCEL);
            break;
            /* [2.3.Delete button at the bottom row] */
            case "btng_delete":
                doActionIBSheet(rate_sheetObject,formObject,IBDELETE);
            break;
            /* [2.4.The reset button on all the information] */
            case "btng_reset":
                
                if (currenttab == 0) {
                    reset_all1();
                }else if (currenttab == 1) {
                    reset_all2();
                }else{
                    reset_all3();
                }
            break;
            /* [2.5.Button to verify at the bottom of the second stage] */
            case "btng_verify":
                if (currenttab == 0) {
                    valcheck_two1(rate_sheetObject);
                }else if (currenttab == 1) {
                    valcheck_two2(rate_sheetObject);
                }else{
                    valcheck_two3(rate_sheetObject);
                }
            break;
            /* [2.6.Final save button - the button at the bottom of the store all the information] */
            case "btng_update":
                if (currenttab == 0) {
                    update1(rate_sheetObject);
                }else if (currenttab == 1) {
                    update2(rate_sheetObject);
                }else{
                    update3(rate_sheetObject);
                }
            break;
            /* [2.7.Excel download button] */
            case "btng_downexcel":
                
                if(rate_sheetObject.RowCount() < 1){//no data
                    ComShowCodeMessage("COM132501");
                }else{
                    doActionIBSheet(rate_sheetObject,formObject,IBDOWNEXCEL);
                }
                
            break;
            /* [2.7.Button at the bottom of the Surcharge] */
            case "btng_surcharge":
                openAgmtScgPopup();
            break;
            /* [2.service provider's pop-up button] */
            case "btng_provider":
                rep_OnPopupClick();
            break;
            case "btng_calendar":
                getCalendar();
            break;
            case "btng_date_apply":
                date_apply(rate_sheetObject);
            break;
            case "btng_help":
                openHelp();
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

/**
 * 초기 이벤트 등록 
 */
 function initControl() {
    axon_event.addListener('blur', 'fm_agmtno_blur', 'fm_agmtno');
 }
 
//Agreement No 값 변경시 처리 
function fm_agmtno_blur() {
    var formObject=document.form;
    if(formObject.fm_agmtno.value == "") {
        formObject.fm_vndr_prmry_seq.value = "";
        formObject.fm_vndr_prmry_nm.value = "";
        formObject.fm_agmt_ref_no.value = "";
        formObject.fm_ctrt_ofc_cd.value = "";
        formObject.fm_inter_rmk.value = "";
        formObject.fm_eff_fm_dt.value = "";
        formObject.fm_eff_to_dt.value = "";        
        
        doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
        
        // List Search
        var rate_sheetObject = sheetObjects[2]; //Agreement Rate Information       
        formObject.cur_page_cnt.value = 1;
        doActionIBSheet(rate_sheetObject, formObject, "RETRIEVE");        
    }else{
        doSearchEnter();
    }
}


/*
* handling of Sheet 
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);

    switch(sAction) {
        case IBSEARCH:
            formObj.f_cmd.value=SEARCH01;   
            sheetObjects[0].DoSearch("ESD_TRS_0220GS.do", TrsFrmQryString(formObj) );
            
            if(sheetObjects[0].RowCount() < 1) {
                formObj.f_cmd.value=SEARCH02;
                sheetObjects[1].DoSearch("ESD_TRS_0220GS.do", TrsFrmQryString(formObj) );
            }
            break;
            
       case "RETRIEVE":
          formObj.f_cmd.value = SEARCH02; 
          sheetObj.DoSearch("ESD_TRS_0226GS.do", TrsFrmQryString(formObj));
          break;

       case IBINSERT:
            var row=0;
            if(sheetObjects[0].RowCount()== 0) {
                ComShowCodeMessage('TRS90081');
                return;
            }
            var fm_eff_fm_dt=formObj.fm_eff_fm_dt.value;
            var fm_eff_to_dt=formObj.fm_eff_to_dt.value;
            row=sheetObj.DataInsert(-1);
            sheetObj.SetCellValue(row,'ck_vf',1,0);
            sheetObj.SetCellValue(row,'chk',1,0);
            var formObj=document.form;
            var eff_fm_dt=doSepRemove(doSepRemove(formObj.fm_eff_fm_dt.value, " "), "-");
            var eff_to_dt=doSepRemove(doSepRemove(formObj.fm_eff_to_dt.value, " "), "-");
            sheetObj.SetCellValue(row,"eff_fm_dt",eff_fm_dt,0);
            sheetObj.SetCellValue(row,"eff_to_dt",eff_to_dt,0);

            var eq_knd_cd = "";
            if (currenttab == 0) {
                if(sheetObj.GetCellValue(row, "trsp_cost_mod_cd").substring(0, 1) == "W" || sheetObj.GetCellValue(row, "trsp_cost_mod_cd").substring(1, 2) == "W") {
                    sheetObj.SetCellEditable(row, "trsp_bnd_cd", 1);
                    sheetObj.SetCellValue(row, "trsp_bnd_cd", "Y", 0);
                } else {
                    sheetObj.SetCellValue(row, "trsp_bnd_cd", "", 0);
                    sheetObj.SetCellEditable(row, "trsp_bnd_cd", 0);
                }
                eq_knd_cd = "U";
            } else if (currenttab == 1) {
            	eq_knd_cd = "Z";
            } else {
            	eq_knd_cd = "G";
            }
            
            sheetObj.SetCellValue(row, "eq_knd_cd", eq_knd_cd, 0);
            break;
            
        case IBDELETE:
            if(sheetObj.CheckedRows("chk") == 0) {
                ComShowCodeMessage('TRS90386', 'No Target Data!');
                return;
            }
            var checkList = sheetObj.FindCheckedRow('chk');
            var checkArray = checkList.split('|');
            for(var k = checkArray.length - 1; k >= 0; k--) {
                if(sheetObj.GetRowStatus(checkArray[k]) == "I") {
                    sheetObj.RowDelete(checkArray[k], false);
                } else {
                    ComShowCodeMessage('TRS90386', 'Already updated.');
                    sheetObj.SetSelectRow(checkArray[k]);
                    return;
                }
            }
            break;

        case IBLOADEXCEL:
            var agmtno=formObj.fm_agmtno.value;
            var ctrt_ofc_cd=formObj.fm_ctrt_ofc_cd.value;
            if(sheetObjects[0].RowCount()== 0) {
                 ComShowCodeMessage('TRS90081');
                return;
            }

            if(agmtno !="" && ctrt_ofc_cd !="") {
                CurRowCount = sheetObj.RowCount()+ sheetObj.HeaderRows();
                
                sheetObj.SetWaitImageVisible(0);
                sheetObj.LoadExcel({Append:1} );
                for(var i=sheetObj.RowCount()+ sheetObj.HeaderRows(); i >= sheetObj.HeaderRows(); i--) {
                    if(sheetObj.GetCellValue(i, "trsp_cost_mod_cd") == "") {
                        sheetObj.RowDelete(i, false);
                    }
                }
            } else {
                ComShowCodeMessage('TRS90081');
            }
            break;
       case IBDOWNEXCEL:
           //parameter changed[check again]CLT
           if(sheetObj.RowCount() < 1) {//no data
               ComShowCodeMessage("COM132501");
           } else {
                 sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObj), CheckBoxOnValue:'Y', CheckBoxOffValue:'N', SheetDesign:1, Merge:1 });
           }
           break;
    }
}

// Agreement No. onKeyup Event
function doSearchEnter() {
    if( event.keyCode == 13 ) {
        if( validateFormSearch() ) {
            // Header Search
            var sheetObject=sheetObjects[0];
            var formObject=document.form;
            setgetUpper(formObject.fm_agmtno);
            doActionIBSheet(sheetObject, formObject, IBSEARCH, "", "");

            // List Search
            var rate_sheetObject = sheetObjects[2]; //Agreement Rate Information
            if (currenttab == 0) {
                rate_sheetObject = sheetObjects[2]; //Agreement Rate Information
            } else if (currenttab == 1) {
                rate_sheetObject = sheetObjects[3]; //Agreement Rate Information
            } else {
                rate_sheetObject = sheetObjects[4]; //Agreement Rate Information
            }
            formObject.cur_page_cnt.value = 1;
            doActionIBSheet(rate_sheetObject, formObject, "RETRIEVE");
        }
    }
}

/**
 * Lookups required validation
 */
function validateFormSearch() {
    var formObj=document.form;
    var agmtno=formObj.fm_agmtno.value;
    if( agmtno == "") { 
        errMsg=ComGetMsg("TRS90124");
        ComShowMessage(errMsg);
        formObj.fm_agmtno.focus();
        return false;
    }

    if( agmtno != ""  && agmtno.length < 4 ) { 
        errMsg=ComGetMsg("TRS90066");
        ComShowMessage(errMsg);
        formObj.fm_agmtno.focus();
        return false;
    }    

    if( agmtno != ""  &&  ! ComIsMoneyNumber( agmtno.substring(3) , false, true, true) ) { 
        errMsg=ComGetMsg("TRS90066");
        ComShowMessage(errMsg);
        formObj.fm_agmtno.focus();
        return false;
    }

    return true;
}

/**
 * Onkeydown event
 */
function gotopage() {
    var formObject = document.form;
    var tot_page = formObject.tot_page_cnt.value;
    var cur_page = formObject.cur_page_cnt.value;
    var rate_sheetObject = sheetObjects[2]; //Agreement Rate information
    if (currenttab == 0) {
        rate_sheetObject = sheetObjects[2]; //Agreement Rate information
    } else if (currenttab == 1) {
        rate_sheetObject = sheetObjects[3]; //Agreement Rate information
    } else {
        rate_sheetObject = sheetObjects[4]; //Agreement Rate information
    }
    
    if( (Number(cur_page) > Number(tot_page)) || tot_page < 1) {
        var errMessage = ComGetMsg('TRS90351','','','');  
        ComShowMessage(errMessage);
        return;
    }
    doActionIBSheet(rate_sheetObject, formObject, "RETRIEVE");
}

/**
 * Sheet Expand / Collapse
 */
function Minimize(nItem) {
    var objs=document.all.item("MiniLayer");
    if( nItem == "1" ) {
        objs.style.display="none";
        sheetObjects[2].SetSheetHeight(ComGetSheetHeight(sheetObjects[2], 17));
        sheetObjects[3].SetSheetHeight(ComGetSheetHeight(sheetObjects[3], 17));
    } else {
        objs.style.display="inline-block";
        sheetObjects[2].SetSheetHeight(ComGetSheetHeight(sheetObjects[2], 18));
        sheetObjects[3].SetSheetHeight(ComGetSheetHeight(sheetObjects[3], 18));
    }
}

/**
 * Screen Container Reset
 */
function reset_all1() {
    var formObject=document.form;
    formObject.verify_result_1.value="";
    formObject.verify_result_str_1.value="";
    formObject.updated_rows_cnt_1.value="";
    formObject.total_rows_cnt_1.value="";
    formObject.verify_check_yn_1.value="N";
    sheet2.RemoveEtcData();
    sheet2.RemoveAll();
}

/**
* Screen Chassis Reset
*/
function reset_all2() {
    var formObject=document.form;
    formObject.verify_result_2.value="";
    formObject.verify_result_str_2.value="";
    formObject.updated_rows_cnt_2.value="";
    formObject.total_rows_cnt_2.value="";
    formObject.verify_check_yn_2.value="N";
    sheet3.RemoveEtcData();
    sheet3.RemoveAll();
}

/**
* Screen Genset Reset
*/
function reset_all3() {
    var formObject=document.form;
    formObject.verify_result_3.value="";
    formObject.verify_result_str_3.value="";
    formObject.updated_rows_cnt_3.value="";
    formObject.total_rows_cnt_3.value="";
    formObject.verify_check_yn_3.value="N";
    sheet4.RemoveEtcData();
    sheet4.RemoveAll();
}

/**
 * Register as an array IBSheet Object
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * Set the tab item.
 */
function initTab(tabObj , tabNo) {
    switch(tabNo) {
        case 1:
            tabObj.InsertItem( "Container", "");
            tabObj.InsertItem( "Chassis",   "");
            tabObj.InsertItem( "Genset",    "");
            break;
    }
}

/**
 * setTabObject
 */
function setTabObject(tab_obj) {
    tabObjects[tabCnt++]=tab_obj;
}

/**
 * Click the Tab at the event-related
 * Elements selected tab is active.
 */
function tab1_OnChange(tabObj , nItem) {
    var objs=document.all.item("tabLayer");
    objs[nItem].style.display="";
    objs[beforetab].style.display="none";
    objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    beforetab=nItem;
    currenttab=nItem;
    var formObj=document.form;
    if (currenttab == 0) {
        formObj.fm_eq_knd_cd.value = "U";
    } else if (currenttab == 1) {
        formObj.fm_eq_knd_cd.value = "Z";
    } else {
        formObj.fm_eq_knd_cd.value = "G";
    }
}

/**
 * Views that occur after the EVENT
 */
function sheet0_OnSearchEnd(sheetObj, errMsg) {
    var formObj=document.form;
    if(sheetObj.RowCount() > 0)     {
        formObj.fm_vndr_prmry_seq.value = sheetObj.GetCellValue(1, "vndr_prmry_seq");
        formObj.fm_vndr_prmry_nm.value  = sheetObj.GetCellValue(1, "vndr_prmry_nm");
        formObj.fm_agmt_ref_no.value    = sheetObj.GetCellValue(1, "agmt_ref_no");
        formObj.fm_ctrt_ofc_cd.value    = sheetObj.GetCellValue(1, "ctrt_ofc_cd");
        formObj.fm_inter_rmk.value      = sheetObj.GetCellValue(1, "inter_rmk");
        
        // 해당 Agreement에 Image가 있을 경우 [Attach File] 버튼 색상 파란색으로 변경
		if(sheetObj.GetCellValue(1, "img_flg") == "Y"){
			ComGetObject("btn_attach").style.setProperty("color", BTN_BLUE, "important");
		} else{
			ComGetObject("btn_attach").style.setProperty("color", "", "");
		}
    }
}

/**
 * Views that occur after the EVENT
 */
function sheet2_OnSearchEnd(sheetObj, errMsg) {
    // Initializing
    var formObject = document.form;
    formObject.verify_result_1.value     = "0";
    formObject.verify_result_str_1.value = "( UPDATE DISABLE! )";
    formObject.updated_rows_cnt_1.value  = "0";
    formObject.total_rows_cnt_1.value    = "0";
    formObject.verify_check_yn_1.value   = "N";

    eq_OnSearchEnd(sheetObj, errMsg);
}

/**
 * Views that occur after the EVENT
 */
function sheet3_OnSearchEnd(sheetObj, errMsg) {
    // Initializing
    var formObject = document.form;
    formObject.verify_result_2.value     = "0";
    formObject.verify_result_str_2.value = "( UPDATE DISABLE! )";
    formObject.updated_rows_cnt_2.value  = "0";
    formObject.total_rows_cnt_2.value    = "0";
    formObject.verify_check_yn_2.value   = "N";

    eq_OnSearchEnd(sheetObj, errMsg);
}

/**
 * Views that occur after the EVENT
 */
function sheet4_OnSearchEnd(sheetObj, errMsg) {
    // Initializing
    var formObject = document.form;
    formObject.verify_result_3.value     = "0";
    formObject.verify_result_str_3.value = "( UPDATE DISABLE! )";
    formObject.updated_rows_cnt_3.value  = "0";
    formObject.total_rows_cnt_3.value    = "0";
    formObject.verify_check_yn_3.value   = "N";

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
}

/**
* eq_OnSearchEnd
*/
function eq_OnSearchEnd(sheetObj, errMsg) {
    for(var row = sheetObj.HeaderRows(); row < sheetObj.HeaderRows() + sheetObj.RowCount(); row++) {
        sheetObj.SetCellValue(row, 'chk',     0, 0);
        sheetObj.SetCellValue(row, 'chk2',    0, 0);
        sheetObj.SetCellValue(row, 'ck_vf',   0, 0);
        sheetObj.SetCellValue(row, 'ibflag', '', 0);

        if(sheetObj.GetCellValue(row, "trsp_agmt_rt_seq") != "") {
            sheetObj.SetRowEditable(row, 0);
        }
    }
}

/**
 * Save event on Sheet2
 */
function sheet2_OnSaveEnd(sheetObj, errMsg) {
    if( errMsg.length > 0 ) {
        _errMsg = errMsg;
    } else {
        _errMsg = '';
    }

    var checkList = sheetObj.FindCheckedRow('chk');
    var checkArray = checkList.split('|');
    var len = checkArray.length;
    var lastCol = sheetObj.LastCol();
    for(var idx = 0; idx < len; idx++) {
        sheetObj.SetCellValue(checkArray[idx], 'chk',   0, 0);
        sheetObj.SetCellValue(checkArray[idx], 'chk2',  0, 0);
        sheetObj.SetCellValue(checkArray[idx], 'ck_vf', 0, 0);
        sheetObj.SetCellValue(checkArray[idx], 'rlt',  "", 0);
        for(var colx =0; colx <= lastCol; colx++) {
        	if(sheetObj.ColSaveName(colx) != 'chk') {
        		sheetObj.SetCellEditable(checkArray[idx], colx, false);
        	} 
        }
    }
    ComOpenWait(false);
}

/**
 * Save event on Sheet3
 */
function sheet3_OnSaveEnd(sheetObj, errMsg) {
    if( errMsg.length > 0 ) {
        _errMsg = errMsg;
    } else {
        _errMsg = '';
    }

    var checkList = sheetObj.FindCheckedRow('chk');
    var checkArray = checkList.split('|');
    var lastCol = sheetObj.LastCol();
    for(var idx = 0; idx < checkArray.length; idx++) {
        sheetObj.SetCellValue(checkArray[idx], 'chk',   0, 0);
        sheetObj.SetCellValue(checkArray[idx], 'chk2',  0, 0);
        sheetObj.SetCellValue(checkArray[idx], 'ck_vf', 0, 0);
        sheetObj.SetCellValue(checkArray[idx], 'rlt',  "", 0);
        for(var colx = 0; colx <= lastCol; colx++) {
        	if(sheetObj.ColSaveName(colx) != 'chk') {
        		sheetObj.SetCellEditable(checkArray[idx], colx, false);
        	} 
        }
    }
    ComOpenWait(false);
}

/**
 * Save event on Sheet4
 */
function sheet4_OnSaveEnd(sheetObj, errMsg) {
    if( errMsg.length > 0 ) {
        _errMsg = errMsg;
    } else {
        _errMsg = '';
    }

    var checkList = sheetObj.FindCheckedRow('chk');
    var checkArray = checkList.split('|');
    var lastCol = sheetObj.LastCol();
    for(var idx = 0; idx < checkArray.length; idx++) {
        sheetObj.SetCellValue(checkArray[idx], 'chk',   0, 0);
        sheetObj.SetCellValue(checkArray[idx], 'chk2',  0, 0);
        sheetObj.SetCellValue(checkArray[idx], 'ck_vf', 0, 0);
        sheetObj.SetCellValue(checkArray[idx], 'rlt',  "", 0);
        for(var colx = 0; colx <= lastCol; colx++) {
        	if(sheetObj.ColSaveName(colx) != 'chk') {
        		sheetObj.SetCellEditable(checkArray[idx], colx, false);
        	} 
        }
    }
    ComOpenWait(false);
}

/**
 * SHEET EVENT that occurs when the value changes
 */
function sheet2_OnChange(sheetObj, row , col , value) {
    eq_OnChange(sheetObj, row , col , value);
}

/**
 * SHEET EVENT that occurs when the value changes
 */
function sheet3_OnChange(sheetObj, row , col , value) {
    eq_OnChange(sheetObj, row , col , value);
}

/**
 * SHEET EVENT that occurs when the value changes
 */
function sheet4_OnChange(sheetObj, row , col , value) {
    eq_OnChange(sheetObj, row , col , value);
}

/**
 * SHEET EVENT that occurs when the value changes
 */
function eq_OnChange(sheetObj, row, col, value) {
    // Node to change the conditions and reasons for chk if it is not included in the IF statement when checking the Compare check box full ride itself is not in order to speed up the check.
    if( sheetObj.ColSaveName(col) != "chk" ) {
        sheetObj.SetCellValue(row, 'chk',    1, 0);
        sheetObj.SetCellValue(row, 'ck_vf',  1, 0);
        sheetObj.SetCellValue(row, 'rlt',   "", 0);

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
            sheetObj.SetCellValue(row, "fm_nod_cd", lvfm, 0);
            if( doengnumcheck(lvfm) ) {
                if( lvfm.length == 5 ) {
                    getYardSheetCombo1(sheetObj, document.form, row, col, "fm_nod_yd", lvfm); // Validation check
                    if( sheetObj.GetCellValue(row, "fm_nod_cd") != "" ) {
                        getYardSheetCombo(sheetObj, document.form, row, "fm_nod_yd", lvfm);
                    } else {
                        sheetObj.CellComboItem(row, "fm_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "fm_nod_yd", "", 0);
                    }
                } else {
                    if( lvfm.length == 0 ) {
                        sheetObj.CellComboItem(row, "fm_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "fm_nod_yd", "", 0);
                    } else {
                        errMsg=ComGetMsg("TRS90122");
                        ComShowMessage(errMsg);
                        sheetObj.SetCellValue(row, "fm_nod_cd", "", 0);
                        sheetObj.SelectCell(row, "fm_nod_cd");
                        sheetObj.CellComboItem(row, "fm_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "fm_nod_yd", "", 0);
                    }
                }
            } else {
                sheetObj.SetCellValue(row, "fm_nod_cd", "", 0);
                sheetObj.SelectCell(row, "fm_nod_cd");
                sheetObj.CellComboItem(row, "fm_nod_yd", {ComboText:"", ComboCode:""} );
                sheetObj.SetCellValue(row, "fm_nod_yd", "", 0);
            }
        } else if( sheetObj.ColSaveName(col) == "via_nod_cd" ) {
            var lvvia=doSepRemove(sheetObj.GetCellValue(row,"via_nod_cd").toUpperCase(), " ");
            sheetObj.SetCellValue(row, "via_nod_cd", lvvia);
            if( doengnumcheck(lvvia) ) {
                if( lvvia.length == 5 ) {
                    getYardSheetCombo1(sheetObj, document.form, row, col, "via_nod_yd", lvvia); //Varidation check
                    if( sheetObj.GetCellValue(row, "via_nod_cd") != "" ) {
                        getYardSheetCombo(sheetObj, document.form, row, "via_nod_yd", lvvia);
                    } else {
                        sheetObj.CellComboItem(row, "via_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "via_nod_yd", "", 0);
                    }
                } else {
                    if( lvvia.length == 0 ) {
                        sheetObj.CellComboItem(row, "via_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "via_nod_yd", "", 0);
                    } else {
                        errMsg=ComGetMsg("TRS90122");
                        ComShowMessage(errMsg);
                        sheetObj.SetCellValue(row, "via_nod_cd", "", 0);
                        sheetObj.SelectCell(row, "via_nod_cd");
                        sheetObj.CellComboItem(row, "via_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "via_nod_yd", "", 0);
                    }
                }
            } else {
                sheetObj.SetCellValue(row, "via_nod_cd", "", 0);
                sheetObj.SelectCell(row,"via_nod_cd");
                sheetObj.CellComboItem(row, "via_nod_yd", {ComboText:"", ComboCode:""} );
                sheetObj.SetCellValue(row, "via_nod_yd", "", 0);
            }
        } else if( sheetObj.ColSaveName(col) == "to_nod_cd" ) {
            var lvto=doSepRemove(sheetObj.GetCellValue(row, "to_nod_cd").toUpperCase(), " ");
            sheetObj.SetCellValue(row, "to_nod_cd", lvto);
            if( doengnumcheck(lvto) ) {
                if( lvto.length == 5 ) {
                    getYardSheetCombo1(sheetObj, document.form, row, col, "to_nod_yd", lvto); //Varidation check
                    if( sheetObj.GetCellValue(row, "to_nod_cd") != "" ) {
                        getYardSheetCombo(sheetObj, document.form, row, "to_nod_yd", lvto);
                    } else {
                        sheetObj.CellComboItem(row, "to_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "to_nod_yd", "", 0);
                    }
                } else {
                    if( lvto.length == 0 ) {
                        sheetObj.CellComboItem(row, "to_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "to_nod_yd", "", 0);
                    } else {
                        errMsg=ComGetMsg("TRS90122");
                        ComShowMessage(errMsg);
                        sheetObj.SetCellValue(row, "to_nod_cd", "", 0);
                        sheetObj.SelectCell(row, "to_nod_cd");
                        sheetObj.CellComboItem(row, "to_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "to_nod_yd", "", 0);
                    }
                }
            } else {
                sheetObj.SetCellValue(row, "to_nod_cd", "", 0);
                sheetObj.SelectCell(row, "to_nod_yd");
                sheetObj.CellComboItem(row, "to_nod_yd", {ComboText:"", ComboCode:""} );
                sheetObj.SetCellValue(row, "to_nod_yd", "", 0);
            }
        } else if( sheetObj.ColSaveName(col) == "dor_nod_cd" ) {
            var lvdor=doSepRemove(sheetObj.GetCellValue(row,"dor_nod_cd").toUpperCase(), " ");
            sheetObj.SetCellValue(row, "dor_nod_cd", lvdor);
            if( doengnumcheck(lvdor) ) {
                if( lvdor.length == 5 ) {
                    getZoneSheetCombo1(sheetObj, document.form, row, col, "dor_nod_yd", lvdor);
                    if( sheetObj.GetCellValue(row, "dor_nod_cd") != "" ) {
                        getZoneSheetCombo(sheetObj, document.form, row, "dor_nod_yd", lvdor);
                    } else {
                        sheetObj.CellComboItem(row,"dor_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "dor_nod_yd", "", 0);
                    }
                } else {
                    if( lvdor.length == 0 ) {
                        sheetObj.CellComboItem(row, "dor_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "dor_nod_yd", "", 0);
                    } else {
                        errMsg=ComGetMsg("TRS90122");
                        ComShowMessage(errMsg);
                        sheetObj.SetCellValue(row, "dor_nod_cd", "", 0);
                        sheetObj.SelectCell(row, "dor_nod_cd");
                        sheetObj.CellComboItem(row, "dor_nod_yd", {ComboText:"", ComboCode:""} );
                        sheetObj.SetCellValue(row, "dor_nod_yd", "", 0);
                    }
                }
            } else {
                sheetObj.SetCellValue(row, "dor_nod_cd", "", 0);
                sheetObj.SelectCell(row, "dor_nod_cd");
                sheetObj.CellComboItem(row, "dor_nod_yd", {ComboText:"", ComboCode:""} );
                sheetObj.SetCellValue(row, "dor_nod_yd", "", 0);
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
        
        // 2015.03.10        Chanwoo Park
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
        } else if( sheetObj.ColSaveName(col) == "trsp_one_wy_rt" || sheetObj.ColSaveName(col) == "trsp_rnd_rt" ) {
        	if (parseFloat(value) < 0) {
        		sheetObj.SetCellValue(row, sheetObj.ColSaveName(col), "0.00", 0);
        	}
        }
    }
}

/**
 * EVENT sheet2 COLUMN click that occurs when
 */
function sheet2_OnClick(sheetObj, row, col, value) {
    eq_OnClick(sheetObj, row, col, value);
}

/**
 * EVENT sheet3 COLUMN click that occurs when
 */
function sheet3_OnClick(sheetObj, row, col, value) {
    eq_OnClick(sheetObj, row , col , value);
}

/**
 * EVENT sheet4 COLUMN click that occurs when
 */
function sheet4_OnClick(sheetObj, row, col, value) {
    eq_OnClick(sheetObj, row, col, value);
}

/**
 * EVENT sheet COLUMN click that occurs when
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
 * to work on sheet2 Excel Upload EVENT
 */
function sheet2_OnLoadExcel(sheetObj, result, code, msg){
    if(isExceedMaxRow(msg))return;
    eq_OnLoadExcel(sheetObj);
}

/**
 * to work on sheet3 Excel Upload EVENT
 */
function sheet3_OnLoadExcel(sheetObj, result, code, msg) {
    if(isExceedMaxRow(msg))return;
    eq_OnLoadExcel(sheetObj);
}

/**
 * to work on sheet4 Excel Upload EVENT
 */
function sheet4_OnLoadExcel(sheetObj, result, code, msg) {
    if(isExceedMaxRow(msg))return;
    eq_OnLoadExcel(sheetObj);
}

/**
 * To work at Excel Upload EVENT
 */
function eq_OnLoadExcel(sheetObj) {
     var formObj=document.form;
     ComOpenWait(true);
     for(var k=sheetObj.HeaderRows(); k<sheetObj.RowCount()+sheetObj.HeaderRows(); k++) {
         if (k >= CurRowCount ) { // In principle, comparing the condition euron> yidoe an unknown reason must be>=If you do not use to enter data into the first row can not be
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
        	
            // 2015.04.20 
            if(sheetObj.GetCellValue(k, "cgo_tp_cd") == "M" && sheetObj.GetCellValue(k, "spcl_cgo_cntr_tp_cd").length > 0) {
                 ComShowCodeMessage("TRS90421");
                 sheetObj.SelectCell(k, "spcl_cgo_cntr_tp_cd");
            }
            // 2015.05.20             
            var eq_knd_cd = "";
            if (currenttab == 0) {
                eq_knd_cd = "U";
            } else if (currenttab == 1) {
            	eq_knd_cd = "Z";
            } else {
            	eq_knd_cd = "G";
            }
            
            sheetObj.SetCellValue(k, "eq_knd_cd", eq_knd_cd, 0);
        }
    }
    ComOpenWait(false);
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


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Verify Start
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

var errCnt = 0;

/**
 * Check Container Verify
 */
function valcheck_two1(sheetObj) {
    var formObject = document.form;
    // reset sequence
    sheetObj.ReNumberSeq();

    	setAgmt_info();

    	formObject.verify_result_str_1.value = "Collect data is being precessed. Please wait.";
        ComOpenWait(true);
        sheetObj.SetWaitImageVisible(0);
        document.all.btng_verify.disabled = false;
        formObject.f_cmd.value = SEARCH01;

        // Upon completion ck_vf verify the value of '1 '-> '0' is changed to.
        var check_row=sheetObj.CheckedRows('chk');
        if(check_row == '') {
            ComOpenWait(false);
            sheetObj.SetWaitImageVisible(1);
            ComShowCodeMessage('TRS90036');
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
        var checkArrayLen = checkArray.length;
        for(var row = 0; row < checkArrayLen; row++) {
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
	        
	        // 2015.06.04	CHAN WOO PARK
	        // Row별 EQ TP/SZ 검증을 위해 초기화
	        isNullEqTySz = true;
	        sheetObj.SetCellValue(checkArray[row], "ibflag", "I", 0);
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

        var effectiveDateCheck = checkEffectiveDate(sheetObj, dupKey);
        if(!effectiveDateCheck) {
//            ComShowCodeMessage("TRS90412", "Effective Date");
            ComOpenWait(false);
            sheetObj.SetWaitImageVisible(1);
            return;
        }

        var queryStr = sheetObj.GetSaveString(0, 1, 'chk');
        sheetObjects[5].RemoveAll();
        sheetObjects[5].DoSearch("ESD_TRS_0221GS.do", TrsFrmQryString(formObject)+'&'+queryStr, {Sync:1});
}

/**
 * Check Chassis Verify
 */
function valcheck_two2(sheetObj) {
    var formObject = document.form;
    // reset sequence
    sheetObj.ReNumberSeq();

    setAgmt_info();

    formObject.verify_result_str_2.value = "Collect data is being precessed. Please wait.";
    ComOpenWait(true);
    sheetObj.SetWaitImageVisible(0);
    document.all.btng_verify.disabled = false;
    formObject.f_cmd.value = SEARCH01;

    // Upon completion ck_vf verify the value of '1 '-> '0' is changed to.
    var check_row=sheetObj.CheckedRows('chk');
    if(check_row == '') {
        ComOpenWait(false);
        sheetObj.SetWaitImageVisible(1);
        ComShowCodeMessage('TRS90036');
        return;
    }

    // 2015.06.04 check EQ Type/Size field
    var isNullEqTySz = true;
    var checkList = sheetObj.FindCheckedRow('chk');
    var checkArray = checkList.split('|');
    var checkArrayLen = checkArray.length;
    for(var row = 0; row < checkArrayLen; row++) {
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
        
        // Row별 EQ TP/SZ 검증을 위해 초기화
        isNullEqTySz = true;
        sheetObj.SetCellValue(checkArray[row], "ibflag", "I", 0);
    }
    
    formObject.verify_result_str_2.value = "Verify is being processed. Please wait.";
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
    var effectiveDateCheck = checkEffectiveDate(sheetObj, dupKey)
    if(!effectiveDateCheck) {
        //ComShowCodeMessage("TRS90412", "Effective Date");
        ComOpenWait(false);
        sheetObj.SetWaitImageVisible(1);
        return;
    }

    var queryStr = sheetObj.GetSaveString(0, 1, 'chk');
    sheetObjects[5].RemoveAll();
    sheetObjects[5].DoSearch("ESD_TRS_0221GS.do", TrsFrmQryString(formObject)+'&'+queryStr, {Sync:1});
}

/**
 * Check Genset Verify
 */
function valcheck_two3(sheetObj) {
    var formObject = document.form;
    // reset sequence
    sheetObj.ReNumberSeq();

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
        var checkArrayLen = checkArray.length;
        for(var row = 0; row < checkArrayLen; row++) {
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
	        
	        // 2015.06.04	CHAN WOO PARK
	        // Row별 EQ TP/SZ 검증을 위해 초기화
	        isNullEqTySz = true;
	        sheetObj.SetCellValue(checkArray[row], "ibflag", "I", 0);
        }

        formObject.verify_result_str_3.value = "Verify is being processed. Please wait.";
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
        var effectiveDateCheck = checkEffectiveDate(sheetObj, dupKey)
        if(!effectiveDateCheck) {
            //ComShowCodeMessage("TRS90412", "Effective Date");
            ComOpenWait(false);
            sheetObj.SetWaitImageVisible(1);
            return;
        }

        var queryStr = sheetObj.GetSaveString(0, 1, 'chk');
        sheetObjects[5].RemoveAll();
        sheetObjects[5].DoSearch("ESD_TRS_0221GS.do", TrsFrmQryString(formObject)+'&'+queryStr, {Sync:1});
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Verify End
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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

        if(sheetObj.GetCellValue(checkArray[i], "cgo_tp_cd") == "") {
            ComShowCodeMessage("TRS90410", "Cargo Type");
            sheetObj.SelectCell(checkArray[i], "cgo_tp_cd");
            return false;
        }

        if(sheetObj.GetCellValue(checkArray[i], "cgo_tp_cd") == "M" && sheetObj.GetCellValue(checkArray[i], "spcl_cgo_cntr_tp_cd").length > 0) {
             ComShowCodeMessage("TRS90421");
             sheetObj.SelectCell(checkArray[i], "spcl_cgo_cntr_tp_cd");
             return false;
        }
    }
    return true;
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Update Start
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 * Save Container Verify pass rate
 */
function update1(sheetObj) {
    var formObject = document.form;

    ComOpenWait(true);
    setAgmt_info();

    var sheet2_count = sheetObj.RowCount();
//    var check_verify = sheetObj.CheckedRows('ck_vf');
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

    if(check_result) {
        ComOpenWait(false);
        ComShowCodeMessage('TRS90039');
        formObject.verify_result_str_1.value="Please click on the 'Verify' button.";
        return false;
    }
    var y1=formObject.fm_agmtno.value;
    formObject.message_1.value="S";
    var verify_2=formObject.verify_result_1.value;
    var verify_3=formObject.verify_check_yn_1.value;
    var checkList = sheetObj.FindCheckedRow('chk');
    var checkArray = checkList.split('|');
    formObject.total_rows_cnt_1.value = checkArray.length;
    if(sheet2_count > 0) {
        if(verify_2 == 0 && verify_3 == "Y") {
            formObject.f_cmd.value=MULTI;
            sheetObj.DoSave("ESD_TRS_0221GS.do", TrsFrmQryString(formObject), "chk", false, true);

            if(formObject.message_1.value == "V") {
            } else if(formObject.message_1.value == "S") {
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
  * Passing rate Chassis Verify storage
  */
function update2(sheetObj) {
    var formObject=document.form;
    
    ComOpenWait(true);
    setAgmt_info();
    var sheet2_count=sheetObj.RowCount();
//    var check_verify=sheetObj.CheckedRows('ck_vf');
    var check_result=false;

    for(var k = sheetObj.HeaderRows(); k < sheet2_count + sheetObj.HeaderRows(); k++) {
        if (sheetObj.GetRowStatus(k) == 'I' || sheetObj.GetRowStatus(k) == 'U') {
            if(sheetObj.GetCellValue(k, 'rlt') != 'OK') {
                check_result = true;
            }
        }
    }

    if(check_result) {
        ComOpenWait(false);
        ComShowCodeMessage('TRS90039');
        formObject.verify_result_str_2.value="Please click on the 'Verify' button.";
        return false;
    }

    var y1=formObject.fm_agmtno.value;
    formObject.message_2.value="S";
    var verify_2=formObject.verify_result_2.value;
    var verify_3=formObject.verify_check_yn_2.value;
    var checkList = sheetObj.FindCheckedRow('chk');
    var checkArray = checkList.split('|');
    formObject.total_rows_cnt_2.value = checkArray.length;
    if(sheet2_count > 0) {
        if(verify_2 == 0 && verify_3 == "Y") {
            formObject.f_cmd.value=MULTI;
            sheetObj.DoSave("ESD_TRS_0221GS.do", TrsFrmQryString(formObject), "chk", false, true);

            if(formObject.message_2.value=="V") {
            } else if(formObject.message_2.value=="S") {
               if(_errMsg == '' || _errMsg == null) {
                   formObject.updated_rows_cnt_2.value = sheetObj.CheckedRows('chk');
                   formObject.verify_result_str_2.value = "Saving has been completed.";
               } else {
                   formObject.updated_rows_cnt_2.value = '0';
                   formObject.verify_result_str_2.value = _errMsg;
               }
            }
            formObject.message_2.value="";
        } else {
            ComOpenWait(false);
            ComShowCodeMessage('TRS90039');
        }
    }
}

/**
 * Save Genset Verify pass rate
 */
function update3(sheetObj) {
    var formObject=document.form;

    ComOpenWait(true);
    setAgmt_info();
    var sheet2_count=sheetObj.RowCount();
//    var check_verify=sheetObj.CheckedRows('ck_vf');
    var check_result=false;

    for(var k = sheetObj.HeaderRows(); k < sheet2_count + sheetObj.HeaderRows(); k++) {
        if (sheetObj.GetRowStatus(k) == 'I' || sheetObj.GetRowStatus(k) == 'U') {
            if(sheetObj.GetCellValue(k, 'rlt') != 'OK') {
                check_result = true;
            }
        }
    }

    if(check_result) {
        ComOpenWait(false);
        ComShowCodeMessage('TRS90039');
        formObject.verify_result_str_3.value="Please click on the 'Verify' button.";
        return false;
    }

    var y1=formObject.fm_agmtno.value;
    formObject.message_3.value="S";
    var verify_2=formObject.verify_result_3.value;
    var verify_3=formObject.verify_check_yn_3.value;
    var checkList = sheetObj.FindCheckedRow('chk');
    var checkArray = checkList.split('|');
    formObject.total_rows_cnt_3.value = checkArray.length;
    if(sheet2_count > 0) {
        if(verify_2 == 0 && verify_3 == "Y") {
            formObject.f_cmd.value=MULTI;
            sheetObj.DoSave("ESD_TRS_0221GS.do", TrsFrmQryString(formObject), "chk", false, true);
            
            if(formObject.message_3.value=="V") {
            } else if(formObject.message_3.value=="S") {
              if(_errMsg == '' || _errMsg == null) {
                  formObject.updated_rows_cnt_3.value = sheetObj.CheckedRows('chk');
                  formObject.verify_result_str_3.value = "Saving has been completed.";
              } else {
                  formObject.updated_rows_cnt_3.value = '0';
                  formObject.verify_result_str_3.value = _errMsg;
              }
            }
            formObject.message_3.value="";
        } else {
            ComOpenWait(false);
            ComShowCodeMessage('TRS90039');
        }
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Update End
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


// 
function openAgmtHdrPopup() {
    var formObject=document.form;
    var Option="width=1024,height=320,menubar=0,status=0,scrollbars=1,resizable=0";
    var agmt_no=formObject.fm_agmtno.value;  
    var param="?agmt_no="+agmt_no;
    var sUrl = '/opuscntr/ESD_TRS_0220.do' + param;  
    ComOpenPopup(sUrl, 1000, 320, "popupAgmtHdr", "1,0,1,1,1,1,1", true);
}

function openAgmtAttachFilePopup() {
    var formObject=document.form;
    var agmt_no=formObject.fm_agmtno.value;  
    var param="?agmt_no="+agmt_no;
    var sUrl = '/opuscntr/ESD_TRS_0238.do' + param;  
    if (document.getElementById("fm_agmtno").value != "" && document.getElementById("fm_agmtno").value != "") {+
    	ComOpenWindowCenter(sUrl, "popupAgmtAttachFile", 580, 520, true);
	}
}

//Agreement Surcharge Rate Creation Popup
function openAgmtScgPopup() {
    setAgmt_info();

    var sheetObj;
    if (currenttab == 0) {
        sheetObj = sheetObjects[2];
    } else if (currenttab == 1) {
        sheetObj = sheetObjects[3];
    } else {
        sheetObj = sheetObjects[4];
    }

    if(sheetObjects[0].RowCount() == 0) {
        ComShowCodeMessage('TRS90081'); // Please create or retrieve header information first.
        return;
    }

    var formObject = document.form;

    var sheetObject2 = sheetObjects[2];
    var sheetObject3 = sheetObjects[3];
    var sheetObject4 = sheetObjects[4];
    var checkList2   = sheetObject2.FindCheckedRow('chk');
    var checkList3   = sheetObject3.FindCheckedRow('chk');
    var checkList4   = sheetObject4.FindCheckedRow('chk');
    var arrRow2      = checkList2.split("|");
    var arrRow3      = checkList3.split("|");
    var arrRow4      = checkList4.split("|");
    var eq_knd_cd    = "";
    var trsp_agmt_rt_tp_ser_no = "";

    // checkList2.length ===> 0, 2, 5, 8, 11, 14, 17, 20, 23, 26......
    // arrRow2.length    ===> 1, 1, 2, 3,  4,  5,  6,  7,  8,  9......

    if(checkList2.length == 0 && checkList3.length == 0 && checkList4.length == 0) {
        ComShowCodeMessage('TRS90215'); // Please select at least one row.
        return;
    }

    if((currenttab == 0 && arrRow2.length > 1) || 
       (currenttab == 1 && arrRow3.length > 1) || 
       (currenttab == 2 && arrRow4.length > 1)) {
        ComShowCodeMessage('TRS90356'); // You can only handle one row at a time
        return;
    }

    if(currenttab == 0 && checkList2.length > 0 && arrRow2.length == 1) {
        var statusStr2 = formObject.updated_rows_cnt_1.value;
        if(statusStr2 == '0') {
            ComShowCodeMessage('TRS90409'); // Update has not been completed.
            return;
        }
        var rateTypeStr2 = sheetObject2.GetRangeValue(arrRow2[0],  5, arrRow2[0], 12, "|", "^");
        var locNodeStr2  = sheetObject2.GetRangeValue(arrRow2[0], 13, arrRow2[0], 20, "|", "^");
        var currencyStr2 = sheetObject2.GetRangeValue(arrRow2[0], 21, arrRow2[0], 21, "|", "^");
        var effDtStr2    = sheetObject2.GetRangeValue(arrRow2[0], 66, arrRow2[0], 67, "|", "^");
            eq_knd_cd    = sheetObject2.GetCellValue(arrRow2[0], 'eq_knd_cd');
        var spclCgoCntrTpCd = sheetObject2.GetCellValue(arrRow2[0], "spcl_cgo_cntr_tp_cd");
        trsp_agmt_rt_tp_ser_no = sheetObject2.GetCellValue(arrRow2[0], 'trsp_agmt_rt_tp_ser_no');
    }

    if(currenttab == 1 && checkList3.length > 0 && arrRow3.length == 1) {
        var statusStr3 = formObject.updated_rows_cnt_2.value;
        if(statusStr3 == '0') {
            ComShowCodeMessage('TRS90409'); // Update has not been completed.
            return;
        }
        var rateTypeStr3 = sheetObject3.GetRangeValue(arrRow3[0],  5, arrRow3[0], 10, "|", "^");
        var locNodeStr3  = sheetObject3.GetRangeValue(arrRow3[0], 11, arrRow3[0], 18, "|", "^");
        var currencyStr3 = sheetObject3.GetRangeValue(arrRow3[0], 19, arrRow3[0], 19, "|", "^");
        var effDtStr3    = sheetObject3.GetRangeValue(arrRow3[0], 49, arrRow3[0], 50, "|", "^");
            eq_knd_cd    = sheetObject3.GetCellValue(arrRow3[0], 'eq_knd_cd');
        trsp_agmt_rt_tp_ser_no = sheetObject3.GetCellValue(arrRow3[0], 'trsp_agmt_rt_tp_ser_no');
    }

    if(currenttab == 2 && checkList4.length > 0 && arrRow4.length == 1) {
        var statusStr4 = formObject.updated_rows_cnt_3.value;
        if(statusStr4 == '0') {
            ComShowCodeMessage('TRS90409'); // Update has not been completed.
            return;
        }
        var rateTypeStr4 = sheetObject4.GetRangeValue(arrRow4[0],  5, arrRow4[0], 10, "|", "^");
        var locNodeStr4  = sheetObject4.GetRangeValue(arrRow4[0], 11, arrRow4[0], 18, "|", "^");
        var currencyStr4 = sheetObject4.GetRangeValue(arrRow4[0], 19, arrRow4[0], 19, "|", "^");
        var effDtStr4    = sheetObject4.GetRangeValue(arrRow4[0], 32, arrRow4[0], 33, "|", "^");
            eq_knd_cd    = sheetObject4.GetCellValue(arrRow4[0], 'eq_knd_cd');
        trsp_agmt_rt_tp_ser_no = sheetObject4.GetCellValue(arrRow4[0], 'trsp_agmt_rt_tp_ser_no');
    }

    document.form.f_cmd.value = SEARCH11;
    var sXml = sheetObj.GetSearchData("ESD_TRS_0221GS.do", FormQueryString(document.form));
    if(ComGetTotalRows(sXml) != "0") {
        ComShowMessage("For US Rail, Use USA Rail Surcharge Screen!");
        document.form.fm_vndr_prmry_seq.select();
        return;
    }

    var agmt_no = formObject.fm_agmtno.value;
    var trsp_agmt_rt_tp_cd = formObject.fm_trsp_agmt_rt_tp_cd.value;
    var param ="?agmt_no="+agmt_no+"&trsp_agmt_rt_tp_cd="+trsp_agmt_rt_tp_cd
    +"&rateTypeStr2="+rateTypeStr2+"&rateTypeStr3="+rateTypeStr3+"&rateTypeStr4="+rateTypeStr4
    +"&locNodeStr2="+locNodeStr2+"&locNodeStr3="+locNodeStr3+"&locNodeStr4="+locNodeStr4
    +"&currencyStr2="+currencyStr2+"&currencyStr3="+currencyStr3+"&currencyStr4="+currencyStr4
    +"&effDtStr2="+effDtStr2+"&effDtStr3="+effDtStr3+"&effDtStr4="+effDtStr4
    +"&spclCgoCntrTpCd="+spclCgoCntrTpCd+"&eq_knd_cd="+eq_knd_cd+"&trsp_agmt_rt_tp_ser_no="+trsp_agmt_rt_tp_ser_no;
    var sUrl = '/opuscntr/ESD_TRS_0222.screen' + param;
    ComOpenPopup(sUrl, 1024, 720, "popupScg", "1,0,1,1,1,1,1", true);
}

function openAgmtNo() {
    var formObject=document.form;
    var Option="width=700,height=420,menubar=0,status=0,scrollbars=0,resizable=0";
    var agmt_no=formObject.fm_agmtno.value;   
    var param="?agmt_no="+agmt_no;
    var sUrl = '/opuscntr/ESD_TRS_0233.do' + param;
    ComOpenPopup(sUrl, 700, 450, "popupAgmtHdrList", "0,0", true);
    
}

/**
 * Verify Rule pop-up
 */
function openHelp() {
    var formObj=document.form;
    var Option="width=680,height=700,menubar=0,status=0,scrollbars=3,resizable=0";
     /*Removal of unused due to distance Type
     if ( formObj.fm_trsp_agmt_rt_tp_radio[0].checked == true ) {
         window.open('apps/opus/esd/trs/agreementmanage/agreementmanage/html/pair_verify_rule.htm', "popupHelpP", Option);
     }else if( formObj.fm_trsp_agmt_rt_tp_radio[1].checked == true ) {
         window.open('apps/opus/esd/trs/agreementmanage/agreementmanage/html/distance_verify_rule.htm', "popupHelpD", Option);
     }else{
         ComShowCodeMessage('TRS90386', 'Rule not Define.');
     }*/
    //Pair Type set to always
    window.open('apps/opus/esd/trs/agreementmanage/agreementmanage/html/pair_verify_rule.htm', "popupHelpP", Option);
}

/**
 * Calendar Pop-Up Multi-Input
 */
function getCalendar() {
    var cal=new ComCalendarFromTo();
    cal.displayType="date";
    cal.select(document.form.fm_eff_fm_dt, document.form.fm_eff_to_dt, 'yyyy-MM-dd');
}

/**
 * Effective Date EVENT that occurs when a change
 */
function input_change() {
    reset_all1();
    reset_all2();
    reset_all3();
}

/**
 * Agreement No Agreement No pop-up query returns a function that
 */
function getAgmtNo( value, vndr_seq, vndr_nm, agmt_ref_no, row ) {
    var formObject=document.form;
    formObject.fm_agmtno.value=value;  
    doActionIBSheet(sheetObjects[2],formObject,IBSEARCH);
}

// 
function date_apply(fromSheet) {
    var formObj=document.form;
    var sheet_count=fromSheet.RowCount();
    var eff_fm_dt="";
    var eff_to_dt="";
    eff_fm_dt=doSepRemove(doSepRemove(formObj.fm_eff_fm_dt.value, " "), "-");
    eff_to_dt=doSepRemove(doSepRemove(formObj.fm_eff_to_dt.value, " "), "-");
    if ( eff_fm_dt.length < 8 || eff_to_dt.length < 8 ) {
        ComShowCodeMessage('TRS90070');
        return;
    }
    if (fromSheet.CheckedRows('chk') == 0 ) {
        ComShowCodeMessage('TRS90386', 'There is no row selected to update');
        return;
    }
    if (!ComShowCodeConfirm("TRS90386", "Are you sure to update effective date of ticked rows?")) return;
    if( sheet_count > 0 ) {
        for(var t=2; t < sheet_count+2; t++) {
            if( fromSheet.GetCellValue(t, 'chk') == '1' ) {
                fromSheet.SetCellValue(t, 'eff_fm_dt',eff_fm_dt);
                fromSheet.SetCellValue(t, 'eff_to_dt',eff_to_dt);
            }
        }
        ComShowCodeMessage('TRS90386', 'Date Apply Completed');
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
                        //break;
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
