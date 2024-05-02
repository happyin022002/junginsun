/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0222.js
*@FileTitle  : Agreement Surcharge Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/01
=========================================================*/


var _errMsg = '';

var _rateTypeStr;
var _locNodeStr;
var _currencyStr;
var _effDtStr;
var CurRowCount=0;

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
    var sheetObject=sheetObjects[0];
    var sheetObject1=sheetObjects[1];
    var sheetObject2=sheetObjects[2];
    var cnt=0;
    switch(sheetNo)     {
        case 1: //sheet0 init ( ATMT Header ) Hidden Sheet
            with(sheetObj) {
                var HeadTitle1="AGMT CITY CODE|AGMT NO|VNDR_SEQ|VNDR_NM|CONTRACT OFFICE CODE|REFERENCE NUMBER|PIC NAME|REMARK" ;
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
                    {Type:"Text", Hidden:0, Width:100, Align:"Left", ColMerge:1, SaveName:"inter_rmk",            KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:10 }
                ];
                InitColumns(cols);
                SetEditable(1);
                SetCountPosition(0);
                SetHeaderRowHeight(25);
                SetVisible(0);                
            }
            break;

        case 2: //sheet1 init ( Child S/P )
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
                SetCountPosition(0);
                SetHeaderRowHeight(25);
                SetSheetHeight(85, 1);
            }
            break;

        case 3: //sheet2 init ( Rate )
            with(sheetObj) {
                var HeadTitle1="|Seq|Container Verification Result|Container Verification Result|Duplication|Surcharge|Common|Auto-Apply|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type" +
                               "|Effective Date|Effective Date|All Route|From|From|Via|Via|Door|Door|To|To|Fixed\nRatio Div|Currency|One Way\n(CY rate)|Round Trip\n(DR rate)" +
                               "|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size" +
                               "|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size" +
                               "|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size" +
                               "|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size" +
                               "|Weight\nTier|UOM|COA|UDU|UDU2" ;
                var HeadTitle2="|Seq|Status|Description|Duplication|Surcharge|Common|Auto-Apply|Cost\nMode|Trans\nMode|T/Ship|Cargo\nType|Cargo\nNature|Customer\nCode|Commodity\nGroup Code|Rail Service\nType" +
                               "|From|To|All Route|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Fixed\nRatio Div|Currency|One Way\n(CY rate)|Round Trip\n(DR rate)" +
                               "|ALAL|DAL|RAL|AAL|FAL|TAL|SAL|OAL|PAL|AL2" +
                               "|AL4|AL5|AL7|AL9|D2|D4|D5|D7|R2|R4" +
                               "|R5|R7|A2|A4|F2|F4|F5|T2|T4|S2" +
                               "|S4|O2|O4|P2|P4" +
                               "|Weight\nTier|UOM|COA|UDU" +
                               "|CK_VF|EQ|CHK2|OFC|AGMT_SEQ|TP_NO|NOD_SEQ|RT_SEQ|UDU2";
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol: 5, ComboMaxHeight:200 } );
                var info    = { Sort:1, ColMove:1, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"chk",                    KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1 },
                    {Type:"Seq",      Hidden:0, Width:40,  Align:"Right",  ColMerge:1, SaveName:"ui_seqno",               KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"Status",   Hidden:0, Width:45,  Align:"Center", ColMerge:1, SaveName:"ibflag",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:0 },
                    {Type:"Text",     Hidden:0, Width:170, Align:"Left",   ColMerge:1, SaveName:"rlt",                    KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:200 },
                    {Type:"Text",     Hidden:0, Width:90,  Align:"Left",   ColMerge:1, SaveName:"rlt2",                   KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:200 },

                    {Type:"Combo",    Hidden:0, Width:200, Align:"Left",   ColMerge:1, SaveName:"trsp_scg_cd",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"CheckBox", Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"com_scg_aply_flg",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0 },
                    {Type:"CheckBox", Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"wo_aply_flg",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0 },
                    {Type:"Combo",    Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"trsp_cost_mod_cd",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"agmt_trsp_tp_cd",        KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"trsp_bnd_cd",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1 },
                    {Type:"Combo",    Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"cgo_tp_cd",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"spcl_cgo_cntr_tp_cd",    KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Text",     Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"cust_cd",                KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"Text",     Hidden:0, Width:80,  Align:"Center", ColMerge:1, SaveName:"cmdt_grp_cd",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:6 },
                    {Type:"Combo",    Hidden:0, Width:90,  Align:"Center", ColMerge:1, SaveName:"rail_svc_tp_cd",         KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"eff_fm_dt",              KeyField:0, CalcLogic:"", Format:"Ymd",       PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"eff_to_dt",              KeyField:0, CalcLogic:"", Format:"Ymd",       PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Combo",    Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"agmt_rout_all_flg",      KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:50 },

                    {Type:"Text",     Hidden:0, Width:50,  Align:"Center", ColMerge:1, SaveName:"fm_nod_cd",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"fm_nod_yd",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Text",     Hidden:0, Width:50,  Align:"Center", ColMerge:1, SaveName:"via_nod_cd",             KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"via_nod_yd",             KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Text",     Hidden:0, Width:50,  Align:"Center", ColMerge:1, SaveName:"dor_nod_cd",             KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"dor_nod_yd",             KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Text",     Hidden:0, Width:50,  Align:"Center", ColMerge:1, SaveName:"to_nod_cd",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"to_nod_yd",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"agmt_scg_rt_div_cd",     KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"curr_cd",                KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"Float",    Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"trsp_one_wy_rt",         KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:1, InsertEdit:1, EditLen:18 },
                    {Type:"Float",    Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"trsp_rnd_rt",            KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:1, InsertEdit:1, EditLen:18 },

                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_alal",                KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_dal",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_ral",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_aal",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_fal",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_tal",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_sal",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_oal",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_pal",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al2",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al4",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al5",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al7",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al9",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_d2",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_d4",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_d5",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_d7",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_r2",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_r4",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_r5",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_r7",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_a2",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_a4",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_f2",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_f4",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_f5",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_t2",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_t4",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_s2",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_s4",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_o2",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_o4",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_p2",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:25,  Align:"Center", ColMerge:1, SaveName:"eq_p4",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"Text",     Hidden:0, Width:60,  Align:"Right",  ColMerge:1, SaveName:"to_wgt",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:9 },
                    {Type:"Combo",    Hidden:0, Width:80,  Align:"Center", ColMerge:1, SaveName:"wgt_meas_ut_cd",         KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"CheckBox", Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"agmt_cost_flg",          KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"Text",     Hidden:0, Width:100, Align:"Left",   ColMerge:1, SaveName:"usr_def_rmk",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:500 },

                    {Type:"CheckBox", Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"ck_vf",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"org_eqtype",             KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"CheckBox", Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"chk2",                   KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1 },

                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_ofc_cty_cd",   KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_seq",          KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:6 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_rt_tp_ser_no", KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:4 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_scg_nod_seq",  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12},
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_scg_rt_seq",   KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12},
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"org_usr_def_rmk",        KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:500}
                ];
                InitColumns(cols);
                SetEditable(1);
                SetColProperty('trsp_scg_cd',         {ComboText:trsp_scg_cdText,             ComboCode:trsp_scg_cdCode} );
                SetColProperty('trsp_cost_mod_cd',    {ComboText:"|"+trsp_cost_mod_cdCode,    ComboCode:"|"+trsp_cost_mod_cdCode} );
                SetColProperty('agmt_trsp_tp_cd',     {ComboText:"|"+agmt_trsp_tp_cdCode,     ComboCode:"|"+agmt_trsp_tp_cdCode} );
                SetColProperty('trsp_bnd_cd',         {ComboText:"|Y|N",                      ComboCode:"|Y|N"} );
                SetColProperty('cgo_tp_cd',           {ComboText:"|"+cgo_tp_cdCode,           ComboCode:"|"+cgo_tp_cdCode} );
                SetColProperty('spcl_cgo_cntr_tp_cd', {ComboText:"|"+spcl_cgo_cntr_tp_cdCode, ComboCode:"|"+spcl_cgo_cntr_tp_cdCode} );
                SetColProperty('rail_svc_tp_cd',      {ComboText:"|"+rail_svc_tp_cdCode,      ComboCode:"|"+rail_svc_tp_cdCode} );
                SetColProperty('curr_cd',             {ComboText:"|"+curr_cdCode,             ComboCode:"|"+curr_cdCode} );
                SetColProperty('agmt_rout_all_flg',   {ComboText:"|Y|N",                      ComboCode:"|Y|N"} );
                SetColProperty('wgt_meas_ut_cd',      {ComboText:"|KGS|LBS",                  ComboCode:"|KGS|LBS"} );
                SetColProperty('agmt_scg_rt_div_cd',  {ComboText:"|Fixed|Ratio",              ComboCode:"|F|R"} );
                
                SetSheetHeight(350);
            }
            break;

        case 4: //sheet3 init ( Rate )
            with(sheetObj) {
                var HeadTitle1="|Seq|Chassis Verification Result|Chassis Verification Result|Duplication|Surcharge|Common|Auto-Apply|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type" +
                               "|Effective Date|Effective Date|All Route|From|From|Via|Via|Door|Door|To|To|Fixed\nRatio Div|Currency|One Way\n(CY rate)|Round Trip\n(DR rate)" +
                               "|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size" +
                               "|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size" +
                               "|Weight\nTier|UOM|COA|UDU|UDU2" ;
                var HeadTitle2="|Seq|Status|Description|Duplication|Surcharge|Common|Auto-Apply|Cost\nMode|Trans\nMode|Cargo\nType|Customer\nCode|Commodity\nGroup Code|Rail Service\nType" +
                               "|From|To|All Route|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Fixed\nRatio Div|Currency|One Way\n(CY rate)|Round Trip\n(DR rate)" +
                               "|ALAL|SFAL|SLAL|TAAL|GNAL|EGAL|AL2|AL4|AL5|AL8" +
                               "|SF2|SF4|SL2|TA2|GN4|GN5|EG5|EG8|ZT4|CB4" +
                               "|Weight\nTier|UOM|COA|UDU" +
                               "|CK_VF|EQ|CHK2|OFC|AGMT_SEQ|TP_NO|NOD_SEQ|RT_SEQ|UDU2";
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol: 5, ComboMaxHeight:200 } );
                var info    = { Sort:1, ColMove:1, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"chk",                    KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1 },
                    {Type:"Seq",      Hidden:0, Width:40,  Align:"Right",  ColMerge:1, SaveName:"ui_seqno",               KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"Status",   Hidden:0, Width:45,  Align:"Center", ColMerge:1, SaveName:"ibflag",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:0 },
                    {Type:"Text",     Hidden:0, Width:170, Align:"Left",   ColMerge:1, SaveName:"rlt",                    KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:200 },
                    {Type:"Text",     Hidden:0, Width:90,  Align:"Left",   ColMerge:1, SaveName:"rlt2",                   KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:200 },

                    {Type:"Combo",    Hidden:0, Width:200, Align:"Left",   ColMerge:1, SaveName:"trsp_scg_cd",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"CheckBox", Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"com_scg_aply_flg",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0 },
                    {Type:"CheckBox", Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"wo_aply_flg",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0 },
                    {Type:"Combo",    Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"trsp_cost_mod_cd",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"agmt_trsp_tp_cd",        KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:1, Width:40,  Align:"Center", ColMerge:1, SaveName:"cgo_tp_cd",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
/*010*/             {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"cust_cd",                KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"Text",     Hidden:1, Width:80,  Align:"Center", ColMerge:1, SaveName:"cmdt_grp_cd",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:6 },
                    {Type:"Combo",    Hidden:1, Width:90,  Align:"Center", ColMerge:1, SaveName:"rail_svc_tp_cd",         KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },

                    {Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"eff_fm_dt",              KeyField:0, CalcLogic:"", Format:"Ymd",       PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"eff_to_dt",              KeyField:0, CalcLogic:"", Format:"Ymd",       PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Combo",    Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"agmt_rout_all_flg",      KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:50 },

                    {Type:"Text",     Hidden:0, Width:50,  Align:"Center", ColMerge:1, SaveName:"fm_nod_cd",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"fm_nod_yd",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Text",     Hidden:1, Width:50,  Align:"Center", ColMerge:1, SaveName:"via_nod_cd",             KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:1, Width:40,  Align:"Center", ColMerge:1, SaveName:"via_nod_yd",             KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
/*020*/             {Type:"Text",     Hidden:1, Width:50,  Align:"Center", ColMerge:1, SaveName:"dor_nod_cd",             KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:1, Width:40,  Align:"Center", ColMerge:1, SaveName:"dor_nod_yd",             KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Text",     Hidden:0, Width:50,  Align:"Center", ColMerge:1, SaveName:"to_nod_cd",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"to_nod_yd",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"agmt_scg_rt_div_cd",     KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"curr_cd",                KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"Float",    Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"trsp_one_wy_rt",         KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:1, InsertEdit:1, EditLen:18 },
                    {Type:"Float",    Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"trsp_rnd_rt",            KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:1, InsertEdit:1, EditLen:18 },

                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_alal",                KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_sfal",                KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
/*030*/             {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_slal",                KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_taal",                KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_gnal",                KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_egal",                KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al2",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al4",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al5",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_al8",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_sf2",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_sf4",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
/*040*/             {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_sl2",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_ta2",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_gn4",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_gn5",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_eg5",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_eg8",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_zt4",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_cb4",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"Text",     Hidden:0, Width:60,  Align:"Right",  ColMerge:1, SaveName:"to_wgt",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:9 },
                    {Type:"Combo",    Hidden:0, Width:80,  Align:"Center", ColMerge:1, SaveName:"wgt_meas_ut_cd",         KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"CheckBox", Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"agmt_cost_flg",          KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
/*050*/             {Type:"Text",     Hidden:0, Width:100, Align:"Left",   ColMerge:1, SaveName:"usr_def_rmk",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:500 },

                    {Type:"CheckBox", Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"ck_vf",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"org_eqtype",             KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"CheckBox", Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"chk2",                   KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1 },

                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_ofc_cty_cd",   KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_seq",          KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:6 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_rt_tp_ser_no", KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:4 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_scg_nod_seq",  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12},
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_scg_rt_seq",   KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12},
/*060*/             {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"org_usr_def_rmk",        KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:500}
                ];
                InitColumns(cols);
                SetEditable(1);
                SetColProperty('trsp_scg_cd',        {ComboText:trsp_scg_cdText,          ComboCode:trsp_scg_cdCode} );
                SetColProperty('trsp_cost_mod_cd',   {ComboText:"|"+trsp_cost_mod_cdCode, ComboCode:"|"+trsp_cost_mod_cdCode} );
                SetColProperty('agmt_trsp_tp_cd',    {ComboText:"|"+agmt_trsp_tp_cdCode,  ComboCode:"|"+agmt_trsp_tp_cdCode} );
                SetColProperty('cgo_tp_cd',          {ComboText:"|"+cgo_tp_cdCode,        ComboCode:"|"+cgo_tp_cdCode} );
                SetColProperty('rail_svc_tp_cd',     {ComboText:"|"+rail_svc_tp_cdCode,   ComboCode:"|"+rail_svc_tp_cdCode} );
                SetColProperty('curr_cd',            {ComboText:"|"+curr_cdCode,          ComboCode:"|"+curr_cdCode} );
                SetColProperty('agmt_rout_all_flg',  {ComboText:"|Y|N",                   ComboCode:"|Y|N"} );
                SetColProperty('wgt_meas_ut_cd',     {ComboText:"|KGS|LBS",               ComboCode:"|KGS|LBS"} );
                SetColProperty('agmt_scg_rt_div_cd', {ComboText:"|Fixed|Ratio",           ComboCode:"|F|R"} );
                
                SetSheetHeight(350);
            }
            break;

        case 5: //sheet4 init ( Rate )
            with(sheetObj) {
                var HeadTitle1="|Seq|Genset Verification Result|Genset Verification Result|Duplication|Surcharge|Common|Auto-Apply|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type" +
                               "|Effective Date|Effective Date|All Route|From|From|Via|Via|Door|Door|To|To|Fixed\nRatio Div|Currency|One Way\n(CY rate)|Round Trip\n(DR rate)" +
                               "|EQ Type/Size|EQ Type/Size|EQ Type/Size" +
                               "|Weight\nTier|UOM|COA|UDU" ;
                var HeadTitle2="|Seq|Status|Description|Duplication|Surcharge|Common|Auto-Apply|Cost\nMode|Trans\nMode|Cargo\nType|Customer\nCode|Commodity\nGroup Code|Rail Service\nType" +
                               "|From|To|All Route|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Fixed\nRatio Div|Currency|One Way\n(CY rate)|Round Trip\n(DR rate)" +
                               "|ALAL|CG|UG" +
                               "|Weight\nTier|UOM|COA|UDU" +
                               "|CK_VF|EQ|CHK2|OFC|AGMT_SEQ|TP_NO|NOD_SEQ|RT_SEQ";
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol: 5, ComboMaxHeight:200 } );
                var info    = { Sort:1, ColMove:1, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"chk",                    KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1 },
                    {Type:"Seq",      Hidden:0, Width:40,  Align:"Right",  ColMerge:1, SaveName:"ui_seqno",               KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"Status",   Hidden:0, Width:45,  Align:"Center", ColMerge:1, SaveName:"ibflag",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:0 },
                    {Type:"Text",     Hidden:0, Width:170, Align:"Left",   ColMerge:1, SaveName:"rlt",                    KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:200 },
                    {Type:"Text",     Hidden:0, Width:90,  Align:"Left",   ColMerge:1, SaveName:"rlt2",                   KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:200 },

                    {Type:"Combo",    Hidden:0, Width:200, Align:"Left",   ColMerge:1, SaveName:"trsp_scg_cd",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"CheckBox", Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"com_scg_aply_flg",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"wo_aply_flg",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"Combo",    Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"trsp_cost_mod_cd",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"agmt_trsp_tp_cd",        KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:1, Width:40,  Align:"Center", ColMerge:1, SaveName:"cgo_tp_cd",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
/*010*/             {Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"cust_cd",                KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"Text",     Hidden:1, Width:80,  Align:"Center", ColMerge:1, SaveName:"cmdt_grp_cd",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:6 },
                    {Type:"Combo",    Hidden:1, Width:90,  Align:"Center", ColMerge:1, SaveName:"rail_svc_tp_cd",         KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },

/*013*/             {Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"eff_fm_dt",              KeyField:0, CalcLogic:"", Format:"Ymd",       PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"eff_to_dt",              KeyField:0, CalcLogic:"", Format:"Ymd",       PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Combo",    Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"agmt_rout_all_flg",      KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:50 },

                    {Type:"Text",     Hidden:0, Width:50,  Align:"Center", ColMerge:1, SaveName:"fm_nod_cd",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"fm_nod_yd",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Text",     Hidden:1, Width:50,  Align:"Center", ColMerge:1, SaveName:"via_nod_cd",             KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:1, Width:40,  Align:"Center", ColMerge:1, SaveName:"via_nod_yd",             KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
/*020*/             {Type:"Text",     Hidden:1, Width:50,  Align:"Center", ColMerge:1, SaveName:"dor_nod_cd",             KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:1, Width:40,  Align:"Center", ColMerge:1, SaveName:"dor_nod_yd",             KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Text",     Hidden:0, Width:50,  Align:"Center", ColMerge:1, SaveName:"to_nod_cd",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"to_nod_yd",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"agmt_scg_rt_div_cd",     KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
                    {Type:"Combo",    Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"curr_cd",                KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"Float",    Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"trsp_one_wy_rt",         KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:1, InsertEdit:1, EditLen:18 },
                    {Type:"Float",    Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"trsp_rnd_rt",            KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:1, InsertEdit:1, EditLen:18 },

                    {Type:"CheckBox", Hidden:0, Width:35,  Align:"Center", ColMerge:1, SaveName:"eq_alal",                KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_cg",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
/*030*/             {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"eq_ug",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },

                    {Type:"Text",     Hidden:0, Width:60,  Align:"Right",  ColMerge:1, SaveName:"to_wgt",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:9 },
                    {Type:"Combo",    Hidden:0, Width:80,  Align:"Center", ColMerge:1, SaveName:"wgt_meas_ut_cd",         KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"CheckBox", Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"agmt_cost_flg",          KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"Text",     Hidden:0, Width:100, Align:"Left",   ColMerge:1, SaveName:"usr_def_rmk",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:500 },
                    
                    {Type:"CheckBox", Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"ck_vf",                  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"org_eqtype",             KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                    {Type:"CheckBox", Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"chk2",                   KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1 },

                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_ofc_cty_cd",   KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_seq",          KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:6 },
/*040*/             {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_rt_tp_ser_no", KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:4 },
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_scg_nod_seq",  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12},
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_scg_rt_seq",   KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12},
                    {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"org_usr_def_rmk",        KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:500}
                ];
                InitColumns(cols);
                SetEditable(1);
                SetColProperty('trsp_scg_cd',        {ComboText:trsp_scg_cdText,          ComboCode:trsp_scg_cdCode} );
                SetColProperty('trsp_cost_mod_cd',   {ComboText:"|"+trsp_cost_mod_cdCode, ComboCode:"|"+trsp_cost_mod_cdCode} );
                SetColProperty('agmt_trsp_tp_cd',    {ComboText:"|"+agmt_trsp_tp_cdCode,  ComboCode:"|"+agmt_trsp_tp_cdCode} );
                SetColProperty('cgo_tp_cd',          {ComboText:"|"+cgo_tp_cdCode,        ComboCode:"|"+cgo_tp_cdCode} );
                SetColProperty('rail_svc_tp_cd',     {ComboText:"|"+rail_svc_tp_cdCode,   ComboCode:"|"+rail_svc_tp_cdCode} );
                SetColProperty('curr_cd',            {ComboText:"|"+curr_cdCode,          ComboCode:"|"+curr_cdCode} );
                SetColProperty('agmt_rout_all_flg',  {ComboText:"|Y|N",                   ComboCode:"|Y|N"} );
                SetColProperty('wgt_meas_ut_cd',     {ComboText:"|KGS|LBS",               ComboCode:"|KGS|LBS"} );
                SetColProperty('agmt_scg_rt_div_cd', {ComboText:"|Fixed|Ratio",           ComboCode:"|F|R"} );
                
                SetSheetHeight(350);
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
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
*/
function loadPage(rateTypeStr2, rateTypeStr3, rateTypeStr4
                , locNodeStr2,  locNodeStr3,  locNodeStr4
                , currencyStr2, currencyStr3, currencyStr4
                , effDtStr2,    effDtStr3,    effDtStr4) {
    for(var i=0;i<sheetObjects.length;i++) {
        ComConfigSheet(sheetObjects[i] ); 
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }

    for(k=0;k<tabObjects.length;k++) {
        initTab(tabObjects[k],k+1);
        tabObjects[k].SetSelectedIndex(-1);
    }

    doSearch();

    // Agreement Creation ( ESD_TRS_0221 ) 화면에서 넘어온 값 설정하기
    var formObject = document.form;
    if(rateTypeStr2.substring(rateTypeStr2.length-1, rateTypeStr2.length) == '|') {
    	rateTypeStr2 = rateTypeStr2 + ' ';
    }
    formObject.rate_type2.value = rateTypeStr2;
    formObject.rate_type3.value = rateTypeStr3;
    formObject.rate_type4.value = rateTypeStr4;
    formObject.loc_node2.value = locNodeStr2;
    formObject.loc_node3.value = locNodeStr3;
    formObject.loc_node4.value = locNodeStr4;
    formObject.currency2.value = currencyStr2;
    formObject.currency3.value = currencyStr3;
    formObject.currency4.value = currencyStr4;
    formObject.eff_dt2.value = effDtStr2;
    formObject.eff_dt3.value = effDtStr3;
    formObject.eff_dt4.value = effDtStr4;

    if (document.form.parm_eq_knd_cd.value == 'U') {
        tabObjects[0].SetSelectedIndex(0);
    } else if (document.form.parm_eq_knd_cd.value == 'Z') {
        tabObjects[0].SetSelectedIndex(1);
    } else {
        tabObjects[0].SetSelectedIndex(2);
    }
}

/*------------------From here the common JavaScript function is defined.     ------------------*/

/* /Common global variable */
var openWindownm='AGMT';
var sheetObjects=new Array();
var sheetCnt=0;
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=0;
var currenttab=0;
// is retrieved by sheet object index number
var isSheetRetrieved=new Array();
isSheetRetrieved[2] = false;
isSheetRetrieved[3] = false;
isSheetRetrieved[4] = false;

document.onclick=processButtonClick;

/* At the bottom of the business by adding a global variable is used to declare. */
var sheetCnt=0;
var Mincount=0;

/* Button to process certain filename, separated on a quarterly event handler to handle */
function processButtonClick() {
    var sheetObject=sheetObjects[0]; //Agreement Header Information
    var sheetObject1=sheetObjects[1]; //Agreement Child S/P Information
    var rate_sheetObject=sheetObjects[2]; //Agreement Rate Information
    if (currenttab == 0) {
        rate_sheetObject=sheetObjects[2]; //Agreement Rate Information
    }else if (currenttab == 1) {
        rate_sheetObject=sheetObjects[3]; //Agreement Rate Information
    }else{
        rate_sheetObject=sheetObjects[4]; //Agreement Rate Information
    }

    /*******************************************************/
    var formObject=document.form;
   try {
       var srcName=ComGetEvent("name");
       switch(srcName) {
            case "btn_retrieve":
                doActionIBSheet(rate_sheetObject, formObject, "RETRIEVE");
            break;
            case "btn_minimize":
                Mincount=(Mincount+1)%2;
                Minimize(Mincount);
            break;
            case "btn_Close":
                ComClosePopup();
            break;    
            case "btn_creation":
                openAgmtHdrPopup();
            break;
            case "btng_rowadd":
                doActionIBSheet(rate_sheetObject,formObject,IBINSERT);
            break;
            case "btng_loadexcel":
                //document.all.btng_verify2.disabled = true;
                doActionIBSheet(rate_sheetObject,formObject,IBLOADEXCEL);
            break;
            case "btng_delete":
                doActionIBSheet(rate_sheetObject,formObject,IBDELETE);
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
            case "btng_downexcel":
              var sheetRowCount=rate_sheetObject.RowCount();
              if(sheetRowCount > 0){
                doActionIBSheet(rate_sheetObject,formObject,IBDOWNEXCEL);
              }
            break;
            case "btng_help":
                openHelp();
            break;
       } // end switch
   }catch(e) {
       if( e == "[object Error]") {
            ComShowCodeMessage('TRS90031');
       } else {
            ComShowMessage(e.message);
       }
   }
}

/*
* handling of Sheet 
*/
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    var formObject=document.form;
    var x1="";
    switch(sAction) {
        case IBSEARCH:
            formObj.f_cmd.value=SEARCH01;        
            sheetObjects[0].DoSearch("ESD_TRS_0220GS.do", TrsFrmQryString(formObj) );

            if(sheetObjects[0].SearchRows() == 0) {
                formObj.f_cmd.value=SEARCH02;
                sheetObjects[1].DoSearch("ESD_TRS_0220GS.do", TrsFrmQryString(formObj) );
            }
            break;

        case "RETRIEVE":
            formObj.f_cmd.value = SEARCH02; 
            sheetObj.DoSearch("ESD_TRS_0229GS.do", TrsFrmQryString(formObj));
            break;

        case IBINSERT:
            var row = 0;
            if(sheetObjects[0].RowCount()== 0) {
                ComShowCodeMessage('TRS90081');
                return;
            }

            row = sheetObj.DataInsert(-1);

            sheetObj.SetCellValue(row, 'ck_vf', 1, 0);
            sheetObj.SetCellValue(row, 'chk',   1, 0);

            // Agreement Creation ( ESD_TRS_0221 ) 화면에서 넘어온 값 설정하기
            if (formObj.rate_type2.value != '' && formObj.rate_type2.value != null 
            		&& formObj.rate_type2.value != 'undefined' && formObj.rate_type2.value != undefined) {
                _rateTypeStr = formObj.rate_type2.value;
                _effDtStr    = formObj.eff_dt2.value;
                _locNodeStr  = formObj.loc_node2.value;
                _currencyStr = formObj.currency2.value;
            } else if (formObj.rate_type3.value != '' && formObj.rate_type3.value != null 
            		&& formObj.rate_type3.value != 'undefined' && formObj.rate_type3.value != undefined) {
                _rateTypeStr = formObj.rate_type3.value;
                _effDtStr    = formObj.eff_dt3.value;
                _locNodeStr  = formObj.loc_node3.value;
                _currencyStr = formObj.currency3.value;
            } else if (formObj.rate_type4.value != '' && formObj.rate_type4.value != null 
            		&& formObj.rate_type4.value != 'undefined' && formObj.rate_type4.value != undefined) {
                _rateTypeStr = formObj.rate_type4.value;
                _effDtStr    = formObj.eff_dt4.value;
                _locNodeStr  = formObj.loc_node4.value;
                _currencyStr = formObj.currency4.value;
            }
            
            if(_rateTypeStr != '' && _rateTypeStr != null && _rateTypeStr != 'undefined' && _rateTypeStr != undefined) {
//            	if (currenttab == 0) {
                    sheetObj.SetRangeValue(_rateTypeStr, row, sheetObj.SaveNameCol("trsp_cost_mod_cd"), row, sheetObj.SaveNameCol("rail_svc_tp_cd"), "|", "^"); // 7,14
                    sheetObj.SetRangeValue(_effDtStr,    row, sheetObj.SaveNameCol("eff_fm_dt"),        row, sheetObj.SaveNameCol("eff_to_dt"), "|", "^"); // 15,16
                    sheetObj.SetRangeValue(_locNodeStr,  row, sheetObj.SaveNameCol("fm_nod_cd"),        row, sheetObj.SaveNameCol("to_nod_yd"), "|", "^"); // 18,25
                    sheetObj.SetRangeValue(_currencyStr, row, sheetObj.SaveNameCol("curr_cd"),          row, sheetObj.SaveNameCol("curr_cd"), "|", "^"); // 27
//            	} else {
//                    sheetObj.SetRangeValue(_rateTypeStr, row, sheetObj.SaveNameCol("trsp_cost_mod_cd"), row, sheetObj.SaveNameCol("rail_svc_tp_cd"), "|", "^"); // 7,12
//                    sheetObj.SetRangeValue(_effDtStr,    row, sheetObj.SaveNameCol("eff_fm_dt"),        row, sheetObj.SaveNameCol("eff_to_dt"), "|", "^"); //13,14
//                    sheetObj.SetRangeValue(_locNodeStr,  row, sheetObj.SaveNameCol("fm_nod_cd"),        row, sheetObj.SaveNameCol("to_nod_yd"), "|", "^"); //16,23
//                    sheetObj.SetRangeValue(_currencyStr, row, sheetObj.SaveNameCol("curr_cd"),          row, sheetObj.SaveNameCol("curr_cd"), "|", "^"); //25
//            	}
            }

            ///////////////////////////////////////////////////////////////////////////////////////////
            // Editable Status, Default Values Settings - 2014.12.04    Hyungwook Choi
            ///////////////////////////////////////////////////////////////////////////////////////////
            if (currenttab == 0) {
                // can't modify Rate Type variables
            	for(var colz = sheetObj.SaveNameCol("trsp_cost_mod_cd"); colz < sheetObj.SaveNameCol("eff_to_dt"); colz++) { // 7,16
                	sheetObj.SetCellEditable(row, colz, 0);
                }
            	
                for(var i = sheetObj.SaveNameCol("eff_fm_dt"); i < sheetObj.SaveNameCol("usr_def_rmk"); i++) { // 15,67
                    sheetObj.SetCellEditable(row, i, 1);
                }
                // Set CargoNature editable : TODO
                //if(sheetObj.GetCellValue(row, "cgo_tp_cd") == "F") {
                //	sheetObj.SetCellEditable(row, "spcl_cgo_cntr_tp_cd", 1);
                //}
            } else if (currenttab == 1) {
                for(var i = sheetObj.SaveNameCol("trsp_cost_mod_cd"); i < sheetObj.SaveNameCol("cgo_tp_cd"); i++) { //7,9
                    sheetObj.SetCellEditable(row, i, 0);
                }
                for(var i = sheetObj.SaveNameCol("cgo_tp_cd"); i <= sheetObj.SaveNameCol("usr_def_rmk"); i++) { //9,50
                    sheetObj.SetCellEditable(row, i, 1);
                }
            } else if (currenttab == 2) {
                for(var i = sheetObj.SaveNameCol("trsp_cost_mod_cd"); i <= sheetObj.SaveNameCol("usr_def_rmk"); i++) { //7,33
                    sheetObj.SetCellEditable(row, i, 1);
                }
            }
            sheetObj.SetCellValue(row, "agmt_scg_rt_div_cd", "F", 0);
            sheetObj.SetCellEditable(row, "agmt_scg_rt_div_cd", 0);
            
            // WHEN surcharge code is SCOWAL THEN can't input or modify Weight Tier and UON field
            if(sheetObj.GetCellValue(row, "trsp_scg_cd") == "SCOWAL"){
                sheetObj.SetCellEditable(row, "to_wgt", 1);
                sheetObj.SetCellEditable(row, "wgt_meas_ut_cd", 1);
            } else {
                sheetObj.SetCellEditable(row, "to_wgt", 0);
                sheetObj.SetCellEditable(row, "wgt_meas_ut_cd", 0);
            }
            ///////////////////////////////////////////////////////////////////////////////////////////
            // Editable Status, Default Values Settings - 2014.12.04    Hyungwook Choi
            ///////////////////////////////////////////////////////////////////////////////////////////

            sheetObj.SetCellValue(row, "trsp_agmt_rt_tp_ser_no", formObj.parm_trsp_agmt_rt_tp_ser_no.value, 0);

            break;

        case IBDELETE:
            var checkList=sheetObj.FindCheckedRow('chk');
            var checkArray=checkList.split('|');
            for(var k=checkArray.length-1; k>=0; k--) {
                sheetObj.RowDelete(checkArray[k], false);
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
            if(sheetObj.RowCount() < 1) {
                ComShowCodeMessage("COM132501"); // no data
            } else {
                sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObj), CheckBoxOnValue:'Y', CheckBoxOffValue:'N', SheetDesign:1, Merge:1 });
            }
            break;
    }
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * Preferences Tab
 * Set the tab item.
 */
function initTab(tabObj , tabNo) {
    switch(tabNo) {
        case 1:
            with (tabObj) {
                var cnt=0;
                InsertItem("Container", "");
                InsertItem("Chassis",   "");
                InsertItem("Genset",    "");
            }
            break;
    }
}

/**
 * Register as an array IBTab Object
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
    objs[beforetab].style.display="none";
    objs[nItem].style.display="Inline";
    //--------------- This is important --------------------------//
    objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    //------------------------------------------------------//
    beforetab=nItem;
    currenttab=nItem;
    var formObj=document.form;
    if (currenttab == 0) {
        formObj.fm_eq_knd_cd.value = "U";

        if(!isSheetRetrieved[2]) {
            doActionIBSheet(sheetObjects[2], formObj, "RETRIEVE");
        }
    } else if (currenttab == 1) {
        formObj.fm_eq_knd_cd.value = "Z";

        if(!isSheetRetrieved[3]) {
            doActionIBSheet(sheetObjects[3], formObj, "RETRIEVE");
        }
    } else {
        formObj.fm_eq_knd_cd.value = "G";

        if(!isSheetRetrieved[4]) {
            doActionIBSheet(sheetObjects[4], formObj, "RETRIEVE");
        }
    }
}

/**
  * Views that occur after the EVENT
  */
function sheet0_OnSearchEnd(sheetObj, errMsg) {
    var formObj = document.form;
    if(sheetObj.RowCount() > 0) {
        formObj.fm_vndr_prmry_seq.value=sheetObj.GetCellValue(1, "vndr_prmry_seq");
        formObj.fm_vndr_prmry_nm.value=sheetObj.GetCellValue(1, "vndr_prmry_nm");
        formObj.fm_agmt_ref_no.value=sheetObj.GetCellValue(1, "agmt_ref_no");
        formObj.fm_ctrt_ofc_cd.value=sheetObj.GetCellValue(1, "ctrt_ofc_cd");
        formObj.fm_inter_rmk.value=sheetObj.GetCellValue(1, "inter_rmk");
    }
}

/**
 * Views that occur after the EVENT
 */
function sheet2_OnSearchEnd(sheetObj, code, errMsg) {
    var formObject = document.form;
    formObject.verify_result_1.value     = "0";
    formObject.verify_result_str_1.value = "( UPDATE DISABLE! )";
    formObject.updated_rows_cnt_1.value  = "0";
    formObject.total_rows_cnt_1.value    = "0";
    formObject.verify_check_yn_1.value   = "N";
    var sheetRowCount = sheetObj.RowCount();
    for(var k=sheetObj.HeaderRows(); k<sheetRowCount+sheetObj.HeaderRows(); k++) {
    	if(sheetObj.GetCellValue(k, "trsp_agmt_scg_rt_seq") != "") {
            sheetObj.SetRowEditable(k, 0);
        }
    }
    
	if(code == 0)
		isSheetRetrieved[2] = true;
	
    eq_OnSearchEnd(sheetObj, errMsg);
}

/**
 * Views that occur after the EVENT
 */
function sheet3_OnSearchEnd(sheetObj, code, errMsg) {
    var formObject = document.form;
    formObject.verify_result_2.value     = "0";
    formObject.verify_result_str_2.value = "( UPDATE DISABLE! )";
    formObject.updated_rows_cnt_2.value  = "0";
    formObject.total_rows_cnt_2.value    = "0";
    formObject.verify_check_yn_2.value   = "N";
    var sheetRowCount = sheetObj.RowCount();
    for(var k=sheetObj.HeaderRows(); k<sheetRowCount+sheetObj.HeaderRows(); k++) {
    	// keep retrieved usr_def_rmk for saving changed usr_def_rmk
    	sheetObj.SetCellValue(k, "org_usr_def_rmk", sheetObj.GetCellValue(k, "usr_def_rmk"), 0);
       	if(sheetObj.GetCellValue(k, "trsp_agmt_scg_rt_seq") != "" || sheetObj.GetCellValue(k, "ibflag") == "") {
            sheetObj.SetRowEditable(k, 0);
        }
    }
    
	if(code == 0)
		isSheetRetrieved[3] = true;
	
    eq_OnSearchEnd(sheetObj, errMsg);
}

/**
 * Views that occur after the EVENT
 */
function sheet4_OnSearchEnd(sheetObj, code, errMsg) {
    var formObject = document.form;
    formObject.verify_result_3.value     = "0";
    formObject.verify_result_str_3.value = "( UPDATE DISABLE! )";
    formObject.updated_rows_cnt_3.value  = "0";
    formObject.total_rows_cnt_3.value    = "0";
    formObject.verify_check_yn_3.value   = "N";
    var sheetRowCount = sheetObj.RowCount();
    for(var k=sheetObj.HeaderRows(); k<sheetRowCount+sheetObj.HeaderRows(); k++) {
    	// keep retrieved usr_def_rmk for saving changed usr_def_rmk
    	sheetObj.SetCellValue(k, "org_usr_def_rmk", sheetObj.GetCellValue(k, "usr_def_rmk"), 0);
    	if(sheetObj.GetCellValue(k, "trsp_agmt_scg_rt_seq") != "") {
            sheetObj.SetRowEditable(k, 0);
        }
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
		if(sheetObj.GetCellValue(row, "rlt") != 'OK' && sheetObj.GetCellValue(row, 'com_scg_aply_flg') != '1') {
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

	  // 3. Checking Unchecked Check Box / Setting Description to 'OK'
	  // Common : Check   ===> Checking O / Setting Description to 'OK'
	  // Common : Uncheck ===> Checking X / Setting Description X
	  for(var idx = 0; idx < checkArrayOnVerify.length; idx++) {
		  rate_sheetObject.SetCellValue(checkArrayOnVerify[idx], 'chk',   1, 0);
		  rate_sheetObject.SetCellValue(checkArrayOnVerify[idx], 'chk2',  1, 0);
		  rate_sheetObject.SetCellValue(checkArrayOnVerify[idx], 'ck_vf', 1, 0);
	      if(rate_sheetObject.GetCellValue(checkArrayOnVerify[idx], 'com_scg_aply_flg') == '1') {
	    	  rate_sheetObject.SetCellValue(checkArrayOnVerify[idx], 'rlt', 'OK', 0);
	      }
	      if(rate_sheetObject.GetCellValue(checkArrayOnVerify[idx], 'trsp_agmt_scg_rt_seq') == '') {
	    	  rate_sheetObject.SetRowStatus(checkArrayOnVerify[idx], "I");
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
    }
}

/**
 * Save event on Sheet2
 */
function sheet2_OnSaveEnd(sheetObj, errMsg) {
    ComOpenWait(false);
    if( errMsg.length > 0 ) {
        _errMsg = errMsg;
    } else {
        _errMsg = '';
    }
    var formObject = document.form;
    doActionIBSheet(sheetObj, formObject, "RETRIEVE");
}

/**
 * Save event on Sheet3
 */
function sheet3_OnSaveEnd(sheetObj, errMsg) {
    ComOpenWait(false);
    if( errMsg.length > 0 ) {
        _errMsg = errMsg;
    } else {
        _errMsg = '';
    }
    var formObject = document.form;
    doActionIBSheet(sheetObj, formObject, "RETRIEVE");
}

/**
 * Save event on Sheet4
 */
function sheet4_OnSaveEnd(sheetObj, errMsg) {
    ComOpenWait(false);
    if( errMsg.length > 0 ) {
        _errMsg = errMsg;
    } else {
        _errMsg = '';
    }
    var formObject = document.form;
    doActionIBSheet(sheetObj, formObject, "RETRIEVE");
}

/**
 * to work on sheet2 Excel Upload EVENT
 */
function sheet2_OnLoadExcel(sheetObj, result, code, msg) {
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
function sheet4_OnLoadExcel(sheetObj, result, code, msg){
    if(isExceedMaxRow(msg))return;
    eq_OnLoadExcel(sheetObj);
}

/**
 * To work at Excel Upload EVENT
 */
function eq_OnLoadExcel(sheetObj) {
    var formObj = document.form;
    ComOpenWait(true);
    
    // Agreement Creation ( ESD_TRS_0221 ) 화면에서 넘어온 값 설정하기
    if (formObj.rate_type2.value != '' && formObj.rate_type2.value != null 
    		&& formObj.rate_type2.value != 'undefined' && formObj.rate_type2.value != undefined) {
        _rateTypeStr = formObj.rate_type2.value;
        _effDtStr    = formObj.eff_dt2.value;
        _locNodeStr  = formObj.loc_node2.value;
        _currencyStr = formObj.currency2.value;
    } else if (formObj.rate_type3.value != '' && formObj.rate_type3.value != null 
    		&& formObj.rate_type3.value != 'undefined' && formObj.rate_type3.value != undefined) {
        _rateTypeStr = formObj.rate_type3.value;
        _effDtStr    = formObj.eff_dt3.value;
        _locNodeStr  = formObj.loc_node3.value;
        _currencyStr = formObj.currency3.value;
    } else if (formObj.rate_type4.value != '' && formObj.rate_type4.value != null 
    		&& formObj.rate_type4.value != 'undefined' && formObj.rate_type4.value != undefined) {
        _rateTypeStr = formObj.rate_type4.value;
        _effDtStr    = formObj.eff_dt4.value;
        _locNodeStr  = formObj.loc_node4.value;
        _currencyStr = formObj.currency4.value;
    }
    
    for(var k=sheetObj.HeaderRows(); k<sheetObj.RowCount()+sheetObj.HeaderRows(); k++) {
        if (k >= CurRowCount) {
	        sheetObj.SetCellValue(k, 'ck_vf', 1, 0);
	        sheetObj.SetCellValue(k, 'chk', 1, 0);
	        //2015.05.11
	        if(_rateTypeStr != '' && _rateTypeStr != null && _rateTypeStr != 'undefined' && _rateTypeStr != undefined) {
	        	if (currenttab == 0) {
	        		var startRange = sheetObj.SaveNameCol("trsp_cost_mod_cd"); // 7
	        		var endRange = sheetObj.SaveNameCol("rail_svc_tp_cd"); // 14
	                sheetObj.SetRangeValue(_rateTypeStr, k, startRange, k, endRange, "|", "^"); // 7,14
	                
	                // can't modify Rate Type variables
	        		var startFor = sheetObj.SaveNameCol("trsp_cost_mod_cd"); // 7
	        		var endFor = sheetObj.SaveNameCol("eff_fm_dt"); // 15
	            	for(var colz = startFor; colz < endFor; colz++) { //7,15
	                	sheetObj.SetCellEditable(k, colz, 0);
	                }
	                // Set CargoNature editable : TODO
	                //if(sheetObj.GetCellValue(k, "cgo_tp_cd") == "F") {
	                //	sheetObj.SetCellEditable(k, "spcl_cgo_cntr_tp_cd", 1);
	                //}
	        	}
	        }
	        
	        sheetObj.SetCellValue(k, 'rlt', '', 0);
	   	    sheetObj.SetCellValue(k, 'trsp_agmt_scg_rt_seq', '', 0);

	        if(sheetObj.GetCellValue(k, "c	go_tp_cd") == "M" && sheetObj.GetCellValue(k, "spcl_cgo_cntr_tp_cd").length > 0) {
	             ComShowCodeMessage("TRS90421");
	             sheetObj.SelectCell(k, "spcl_cgo_cntr_tp_cd");
	         }
	        
	        if( sheetObj.GetCellValue(k, "com_scg_aply_flg") == "1") {
	            // Common : Check ===> All Route ~ UOM : "", Inactive
//                if( currenttab == 0 ) {
	        		var startFor = sheetObj.SaveNameCol("agmt_rout_all_flg"); // 17
	        		var endFor = sheetObj.SaveNameCol("wgt_meas_ut_cd"); // 67
                    for(var i = startFor; i <= endFor; i++) { // 17,67
                        sheetObj.SetCellValue(k, i, "", 0);
                        sheetObj.SetCellEditable(k, i, 0);
                    }
//                } else if( currenttab == 1 ) {
//	        		var startFor = sheetObj.SaveNameCol("agmt_rout_all_flg"); // 15
//	        		var endFor = sheetObj.SaveNameCol("usr_def_rmk"); // 50
//                    for(var i = startFor; i <= endFor; i++) { // 15,50
//                        sheetObj.SetCellValue(k, i, "", 0);
//                        sheetObj.SetCellEditable(k, i, 0);
//                    }
//                } else {
//	        		var startFor = sheetObj.SaveNameCol("agmt_rout_all_flg"); // 15
//	        		var endFor = sheetObj.SaveNameCol("usr_def_rmk"); // 33
//                    for(var i = startFor; i <= endFor; i++) { // 15,33
//                        sheetObj.SetCellValue(k, i, "", 0);
//                        sheetObj.SetCellEditable(k, i, 0);
//                    }
//                }
	        } else {
	            // WHEN surcharge code is SCOWAL THEN can't input or modify Weight Tier and UON field
	            if(sheetObj.GetCellValue(k, "trsp_scg_cd") == "SCOWAL") {
            		var toWgt = sheetObj.GetCellValue(k, "to_wgt").toUpperCase();
            		if(!ComIsNumber(toWgt, ".")){
	            		if(toWgt !="MAX"){
	            			toWgt = "";
	            		}
            		}
	            	sheetObj.SetCellValue(k, "to_wgt", toWgt, 0);
	            	sheetObj.SetCellValue(k, "wgt_meas_ut_cd", sheetObj.GetCellValue(k, "wgt_meas_ut_cd").toUpperCase(), 0);
	                sheetObj.SetCellEditable(k, "to_wgt", 1);
	                sheetObj.SetCellEditable(k, "wgt_meas_ut_cd", 1);
	            } else {
                	sheetObj.SetCellValue(k, "to_wgt", "", 0);
                	sheetObj.SetCellValue(k, "wgt_meas_ut_cd", "", 0);
                    sheetObj.SetCellEditable(k, "to_wgt", 0);
                    sheetObj.SetCellEditable(k, "wgt_meas_ut_cd", 0);
	            }
	        }
        }
    }
    ComOpenWait(false);
}

/**
 * SHEET EVENT that occurs when the value changes
 */
function sheet2_OnChange(sheetObj, row, col, value) {
    eq_OnChange(sheetObj, row, col, value);
}

/**
 * SHEET EVENT that occurs when the value changes
 */
function sheet3_OnChange(sheetObj, row, col, value) {
    eq_OnChange(sheetObj, row, col, value);
}

/**
 * SHEET EVENT that occurs when the value changes
 */
function sheet4_OnChange(sheetObj, row, col, value) {
    eq_OnChange(sheetObj, row, col, value);
}

/**
* SHEET EVENT that occurs when the value changes
*/
function eq_OnChange(sheetObj, row, col, value) {
    var value2 = sheetObj.GetCellValue(row, "com_scg_aply_flg");
    var value3 = sheetObj.GetCellValue(row, "wo_aply_flg");

    //Node to change the conditions and reasons for chk if it is not included in the IF statement when checking the Compare check box full ride itself is not in order to speed up the check.
    if( sheetObj.ColSaveName(col) != "chk" ) {
        sheetObj.SetCellValue(row,'chk',1,0);
        sheetObj.SetCellValue(row,'ck_vf',1,0);
        sheetObj.SetCellValue(row,'rlt',"",0);
        if( sheetObj.ColSaveName(col) == "fm_nod_cd" ) {
            var lvfm=doSepRemove(sheetObj.GetCellValue(row,"fm_nod_cd").toUpperCase(), " ");
            sheetObj.SetCellValue(row, "fm_nod_cd",lvfm,0);
            if( dohancheck(lvfm) ) {
                if( lvfm.length == 5 ) {
                    getYardSheetCombo1(sheetObj, document.form, row, col, "fm_nod_yd", lvfm); //Varidation check
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
            if( dohancheck(lvvia) ) {
                if( lvvia.length == 5 ) {
                    getYardSheetCombo1(sheetObj, document.form, row, col, "via_nod_yd", lvvia); //Varidation check
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
            if( dohancheck(lvto) ) {
                if( lvto.length == 5 ) {
                    getYardSheetCombo1(sheetObj, document.form, row, col, "to_nod_yd", lvto); //Varidation check
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
            if( dohancheck(lvdor) ) {
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
        }
        // 1. Common : Check                     ===> All Route ~ UOM : Inactive
        // 2. Surcharge : Fuel surcharge(SCFAAL) ===> Fixed Ratio Div : Fixed, Active
        // 3. Surcharge : Other 27 Cases         ===> Fixed Ratio Div : Fixed, Inactive
        else if( sheetObj.ColSaveName(col) == "trsp_scg_cd" ) {
            if(value2 == "1") {
//                if( currenttab == 0 ) {
	        		var startFor = sheetObj.SaveNameCol("fm_nod_cd"); // 17
	        		var endFor = sheetObj.SaveNameCol("wgt_meas_ut_cd"); // 67
                    for(var i = startFor; i <= endFor; i++) { //17,67
                        sheetObj.SetCellValue(row, i, "", 0);
                        sheetObj.SetCellEditable(row, i, 0);
                    }
//                } else if( currenttab == 1 ) {
//	        		var startFor = sheetObj.SaveNameCol("agmt_rout_all_flg"); // 15
//	        		var endFor = sheetObj.SaveNameCol("usr_def_rmk"); // 50
//                    for(var i = startFor; i <= endFor; i++) { //15,50
//                        sheetObj.SetCellValue(row, i, "", 0);
//                        sheetObj.SetCellEditable(row, i, 0);
//                    }
//                } else {
//	        		var startFor = sheetObj.SaveNameCol("agmt_rout_all_flg"); // 15
//	        		var endFor = sheetObj.SaveNameCol("usr_def_rmk"); // 33
//                    for(var i = startFor; i <= endFor; i++) { //15,33
//                        sheetObj.SetCellValue(row, i, "", 0);
//                        sheetObj.SetCellEditable(row, i, 0);
//                    }
//                }
            } else {
//                if( currenttab == 0 ) {
                    sheetObj.SetRangeValue(_effDtStr,    row, sheetObj.SaveNameCol("eff_fm_dt"), row, sheetObj.SaveNameCol("eff_to_dt"), "|", "^"); //15,16
                    sheetObj.SetRangeValue(_locNodeStr,  row, sheetObj.SaveNameCol("fm_nod_cd"), row, sheetObj.SaveNameCol("to_nod_yd"), "|", "^"); //18,25
                    sheetObj.SetRangeValue(_currencyStr, row, sheetObj.SaveNameCol("curr_cd"),   row, sheetObj.SaveNameCol("curr_cd"), "|", "^"); //27
                    
	        		var startFor = sheetObj.SaveNameCol("eff_fm_dt"); // 15
	        		var endFor = sheetObj.SaveNameCol("wgt_meas_ut_cd"); // 67
                    for(var i = startFor; i <= endFor; i++) { //15,67
                        sheetObj.SetCellEditable(row, i, 1);
                    }
//                } else if( currenttab == 1 ) {
//                    sheetObj.SetRangeValue(_effDtStr,    row, sheetObj.SaveNameCol("eff_fm_dt"), row, sheetObj.SaveNameCol("eff_to_dt"), "|", "^"); //13,14
//                    sheetObj.SetRangeValue(_locNodeStr,  row, sheetObj.SaveNameCol("fm_nod_cd"), row, sheetObj.SaveNameCol("to_nod_yd"), "|", "^"); //16,23
//                    sheetObj.SetRangeValue(_currencyStr, row, sheetObj.SaveNameCol("curr_cd"),   row, sheetObj.SaveNameCol("curr_cd"), "|", "^"); //25
//                    
//	        		var startFor = sheetObj.SaveNameCol("eff_fm_dt"); // 13
//	        		var endFor = sheetObj.SaveNameCol("usr_def_rmk"); // 50
//                    for(var i = startFor; i <= endFor; i++) { //13,50
//                        sheetObj.SetCellEditable(row, i, 1);
//                    }
//                } else {
//                    sheetObj.SetRangeValue(_effDtStr,    row, sheetObj.SaveNameCol("eff_fm_dt"), row, sheetObj.SaveNameCol("eff_to_dt"), "|", "^"); //13,14
//                    sheetObj.SetRangeValue(_locNodeStr,  row, sheetObj.SaveNameCol("fm_nod_cd"), row, sheetObj.SaveNameCol("to_nod_yd"), "|", "^"); //16,23
//                    sheetObj.SetRangeValue(_currencyStr, row, sheetObj.SaveNameCol("curr_cd"),   row, sheetObj.SaveNameCol("curr_cd"), "|", "^"); //25
//                    
//	        		var startFor = sheetObj.SaveNameCol("eff_fm_dt"); // 13
//	        		var endFor = sheetObj.SaveNameCol("usr_def_rmk"); // 33
//                    for(var i = startFor; i <= endFor; i++) { //13,33
//                        sheetObj.SetCellEditable(row, i, 1);
//                    }
//                }

                if(sheetObj.GetCellValue(row, "trsp_scg_cd") == "SCFAAL") {
                    sheetObj.SetCellValue(row, "agmt_scg_rt_div_cd", "F", 0);
                    sheetObj.SetCellEditable(row, "agmt_scg_rt_div_cd", 1);
                } else {
//                	if( currenttab == 0 ) {
                        sheetObj.SetRangeValue(_effDtStr,    row, sheetObj.SaveNameCol("eff_fm_dt"), row, sheetObj.SaveNameCol("eff_to_dt"), "|", "^"); //15,16
                        sheetObj.SetRangeValue(_locNodeStr,  row, sheetObj.SaveNameCol("fm_nod_cd"), row, sheetObj.SaveNameCol("to_nod_yd"), "|", "^"); //18,25
                        sheetObj.SetRangeValue(_currencyStr, row, sheetObj.SaveNameCol("curr_cd"),   row, sheetObj.SaveNameCol("curr_cd"), "|", "^"); //27
//                	} else {
//                        sheetObj.SetRangeValue(_effDtStr,    row, sheetObj.SaveNameCol("eff_fm_dt"), row, sheetObj.SaveNameCol("eff_to_dt"), "|", "^"); //13,14
//                        sheetObj.SetRangeValue(_locNodeStr,  row, sheetObj.SaveNameCol("fm_nod_cd"), row, sheetObj.SaveNameCol("to_nod_yd"), "|", "^"); //16,23
//                        sheetObj.SetRangeValue(_currencyStr, row, sheetObj.SaveNameCol("curr_cd"),   row, sheetObj.SaveNameCol("curr_cd"), "|", "^"); //25
//                	}

                    sheetObj.SetCellValue(row, "agmt_scg_rt_div_cd", "F", 0);
                    sheetObj.SetCellEditable(row, "agmt_scg_rt_div_cd", 0);
                }
                
                // WHEN surcharge code is SCOWAL THEN can't input or modify Weight Tier and UON field
                if(sheetObj.GetCellValue(row, col) == "SCOWAL"){
                    sheetObj.SetCellEditable(row, "to_wgt", 1); 
                    sheetObj.SetCellEditable(row, "wgt_meas_ut_cd", 1);
                } else {
                	sheetObj.SetCellValue(row, "to_wgt", "", 0);
                	sheetObj.SetCellValue(row, "wgt_meas_ut_cd", "", 0);
                    sheetObj.SetCellEditable(row, "to_wgt", 0);
                    sheetObj.SetCellEditable(row, "wgt_meas_ut_cd", 0);
                }
            }
        }

        // Fixed/Ratio Div : Ratio       ===> Currency : Inactive
        // Fixed/Ratio Div : "" OR Fixed ===> Currency : Active
        else if( sheetObj.ColSaveName(col) == "agmt_scg_rt_div_cd" ) {
            if(value == "R") {
                sheetObj.SetCellValue(row, "curr_cd", "");
                sheetObj.SetCellEditable(row, "curr_cd", 0);
            } else {
                sheetObj.SetCellEditable(row, "curr_cd", 1);
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
        } else if( sheetObj.ColSaveName(col) == "agmt_trsp_tp_cd" ) {
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
        } else if(sheetObj.ColSaveName(col) == "usr_def_rmk" && sheetObj.GetCellValue(row, "ibflag") == "I") {
        	sheetObj.SetCellValue(row, "org_usr_def_rmk", sheetObj.GetCellValue(row, "usr_def_rmk"), 0);
        }
    }
}

/**
 * EVENT sheet2 COLUMN click that occurs when
 */
function sheet2_OnClick(sheetObj, row , col , value) {
    eq_OnClick(sheetObj, row , col , value);
}

/**
 * EVENT sheet3 COLUMN click that occurs when
 */
function sheet3_OnClick(sheetObj, row , col , value) {
     eq_OnClick(sheetObj, row , col , value);
}

/**
 * EVENT sheet4 COLUMN click that occurs when
 */
function sheet4_OnClick(sheetObj, row , col , value) {
    eq_OnClick(sheetObj, row , col , value);
}

/**
 * Sheet COLUMN click on the EVENT that occurs when
 */
function eq_OnClick(sheetObj, row , col , value) {
    var value2;
    var value3;
    var value4;
    // skip event when clicked cell is not editable
    if(!sheetObj.GetCellEditable(row, col)) return;

    if( sheetObj.ColSaveName(col) == "fm_nod_yd" ) {
        value=doSepRemove(sheetObj.GetCellValue(row, "fm_nod_cd"), " ");
        if( value.length > 0 ) {
            getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
        } else {
            sheetObj.SetCellValue(row, "fm_nod_cd","",0);
        }
    } else if( sheetObj.ColSaveName(col) == "to_nod_yd" ) {
        value=doSepRemove(sheetObj.GetCellValue(row, "to_nod_cd"), " ");
        if( value.length > 0 ) {
            getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
        } else {
            sheetObj.SetCellValue(row, "to_nod_cd","",0);
        }
    } else if (sheetObj.ColSaveName(col) == "via_nod_yd" ) {
        value=doSepRemove(sheetObj.GetCellValue(row, "via_nod_cd"), " ");
        if( value.length > 0 ) {
            getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
        } else {
            sheetObj.SetCellValue(row, "via_nod_cd","",0);
        }
    } else if( sheetObj.ColSaveName(col) == "dor_nod_yd" ) {
        value=doSepRemove(sheetObj.GetCellValue(row, "dor_nod_cd"), " ");
        if( value.length > 0 ) {
            getZoneSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
        } else {
            sheetObj.SetCellValue(row, "dor_nod_cd","",0);
        }
    } else if( sheetObj.ColSaveName(col) == "com_scg_aply_flg") {
        var isComScgAply = sheetObj.GetCellValue(row, "com_scg_aply_flg");
        var trspScgCd = sheetObj.GetCellValue(row, "trsp_scg_cd");
        var ibFlag = sheetObj.GetCellValue(row, "ibflag");
        
    	var doHide = true;
    	if(isComScgAply == "1") {
    		doHide = true;
    	} else if(isComScgAply == "0") {
    		doHide = false;
    	} else { // no change
    		return;
    	}

        // Common : Check ===> All Route ~ UOM : "", Inactive
        if(doHide) {
//            if( currenttab == 0 ) {
        		var startFor = sheetObj.SaveNameCol("agmt_rout_all_flg"); // 17
        		var endFor = sheetObj.SaveNameCol("wgt_meas_ut_cd"); // 67
                for(var i = startFor; i <= endFor; i++) {
                    sheetObj.SetCellValue(row, i, "", 0);
                    sheetObj.SetCellEditable(row, i, 0);
                }
//            } else if( currenttab == 1 ) {
//        		var startFor = sheetObj.SaveNameCol("agmt_rout_all_flg"); // 15
//        		var endFor = sheetObj.SaveNameCol("usr_def_rmk"); // 50
//                for(var i = startFor; i <= endFor; i++) {
//                    sheetObj.SetCellValue(row, i, "", 0);
//                    sheetObj.SetCellEditable(row, i, 0);
//                }
//            } else {
//        		var startFor = sheetObj.SaveNameCol("agmt_rout_all_flg"); // 15
//        		var endFor = sheetObj.SaveNameCol("usr_def_rmk"); // 33
//                for(var i = startFor; i <= endFor; i++) {
//                    sheetObj.SetCellValue(row, i, "", 0);
//                    sheetObj.SetCellEditable(row, i, 0);
//                }
//            }
        }
        // Common : Uncheck
        // 1. All Route ~ UOM                    ===> "", Inactive
        // 2. Surcharge : Fuel Surcharge(SCFAAL) ===> Fixed Ratio Div : Fixed, Active
        // 3. Surcharge : Other 27 Cases         ===> Fixed Ratio Div : Fixed, Inactive
        else {
            sheetObj.SetRangeValue(_effDtStr,    row, sheetObj.SaveNameCol("eff_fm_dt"), row, sheetObj.SaveNameCol("eff_to_dt"), "|", "^"); //15,16
            sheetObj.SetRangeValue(_currencyStr, row, sheetObj.SaveNameCol("curr_cd"),   row, sheetObj.SaveNameCol("curr_cd"), "|", "^"); //27
            if( currenttab == 0 ) {
//                sheetObj.SetRangeValue(_effDtStr,    row, sheetObj.SaveNameCol("eff_fm_dt"), row, sheetObj.SaveNameCol("eff_to_dt"), "|", "^"); //15,16
//                sheetObj.SetRangeValue(_currencyStr, row, sheetObj.SaveNameCol("curr_cd"),   row, sheetObj.SaveNameCol("curr_cd"), "|", "^"); //27
// TODO TEST
        		var startFor = sheetObj.SaveNameCol("agmt_rout_all_flg"); // 17
        		var endFor = sheetObj.SaveNameCol("wgt_meas_ut_cd"); // 67
                for(var i = startFor; i <= endFor; i++) {
                    sheetObj.SetCellEditable(row, i, 1);
                }
            } else if( currenttab == 1 ) {
//                sheetObj.SetRangeValue(_effDtStr,    row, sheetObj.SaveNameCol("eff_fm_dt"), row, sheetObj.SaveNameCol("eff_to_dt"), "|", "^"); //13,14
//                sheetObj.SetRangeValue(_currencyStr, row, sheetObj.SaveNameCol("curr_cd"),   row, sheetObj.SaveNameCol("curr_cd"), "|", "^"); //25

        		var startFor = sheetObj.SaveNameCol("eff_fm_dt"); // 13
        		var endFor = sheetObj.SaveNameCol("wgt_meas_ut_cd"); // 50
                for(var i = startFor; i <= endFor; i++) {
                    sheetObj.SetCellEditable(row, i, 1);
                }
            } else {
//                sheetObj.SetRangeValue(_effDtStr,    row, sheetObj.SaveNameCol("eff_fm_dt"), row, sheetObj.SaveNameCol("eff_to_dt"), "|", "^"); //13,14
//                sheetObj.SetRangeValue(_currencyStr, row, sheetObj.SaveNameCol("curr_cd"),   row, sheetObj.SaveNameCol("curr_cd"), "|", "^"); //25

        		var startFor = sheetObj.SaveNameCol("eff_fm_dt"); // 13
        		var endFor = sheetObj.SaveNameCol("wgt_meas_ut_cd"); // 33
                for(var i = startFor; i <= endFor; i++) {
                    sheetObj.SetCellEditable(row, i, 1);
                }
            }

            if(trspScgCd == "SCFAAL") {
                sheetObj.SetCellValue(row, "agmt_scg_rt_div_cd", "F", 0);
                sheetObj.SetCellEditable(row, "agmt_scg_rt_div_cd", 1);
            } else {
//                if( currenttab == 0 ) {
                    sheetObj.SetRangeValue(_locNodeStr,  row, sheetObj.SaveNameCol("fm_nod_cd"), row, sheetObj.SaveNameCol("to_nod_yd"), "|", "^"); //18,25
//                } else {
//                    sheetObj.SetRangeValue(_locNodeStr,  row, sheetObj.SaveNameCol("fm_nod_cd"), row, sheetObj.SaveNameCol("to_nod_yd"), "|", "^"); //16,23
//                }
                sheetObj.SetCellValue(row, "agmt_scg_rt_div_cd", "F", 0);
                sheetObj.SetCellEditable(row, "agmt_scg_rt_div_cd", 0);
            }
            
            // WHEN surcharge code is SCOWAL THEN can't input or modify Weight Tier and UON field
            if(trspScgCd == "SCOWAL"){
                sheetObj.SetCellEditable(row, "to_wgt", 1); 
                sheetObj.SetCellEditable(row, "wgt_meas_ut_cd", 1);
            } else {
            	sheetObj.SetCellValue(row, "to_wgt", "", 0);
            	sheetObj.SetCellValue(row, "wgt_meas_ut_cd", "", 0);
                sheetObj.SetCellEditable(row, "to_wgt", 0);
                sheetObj.SetCellEditable(row, "wgt_meas_ut_cd", 0);
            }
        }
    }
}

// 
function doSearch() {
    var sheetObject=sheetObjects[0];
    var formObject=document.form;
    doActionIBSheet(sheetObject, formObject, IBSEARCH, "", "");
}

   /**
  * Container Reset screen
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
  * Container Reset screen
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
  * Container Reset screen
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
   * Sheet expand / collapse
   */
  function Minimize(nItem) {
    var objs=document.all.item("MiniLayer");
      if( nItem == "1" ) {
          objs.style.display="none";
          sheetObjects[2].SetSheetHeight(sheetObjects[2].GetSheetHeight(23));
          sheetObjects[3].SetSheetHeight(sheetObjects[3].GetSheetHeight(23));
          sheetObjects[4].SetSheetHeight(sheetObjects[4].GetSheetHeight(23));
      } else {
          objs.style.display="inline";
          sheetObjects[2].SetSheetHeight(sheetObjects[2].GetSheetHeight(18));
          sheetObjects[3].SetSheetHeight(sheetObjects[3].GetSheetHeight(18));
          sheetObjects[4].SetSheetHeight(sheetObjects[4].GetSheetHeight(18));
      }
  }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Verify Start
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

var errCnt = 0;
var checkArrayOnVerify = "";
  
/**
 * Check Container Verify
 */
function valcheck_two1(sheetObj) {
    var formObject=document.form;
    // reset sequence
    sheetObj.ReNumberSeq();

        formObject.verify_result_str_1.value="Collect data is being precessed. Please wait.";
        ComOpenWait(true);
        sheetObj.SetWaitImageVisible(0);
        document.all.btng_verify.disabled=false;
        formObject.f_cmd.value=SEARCH02;
        //Upon completion ck_vf verify the value of '1 '-> '0' is changed to.
        var check_verify = sheetObj.CheckedRows('ck_vf');
        var check_row=sheetObj.CheckedRows('chk');
        if(check_verify == '' || check_row == '') {
            ComOpenWait(false);
            ComShowMessage(ComGetMsg("TRS90036"));
            return;
        }

        if(!validateForm(sheetObj, formObject)) {
            formObject.verify_result_str_1.value = "Mandatory field is missing.";
            ComOpenWait(false);
            return false;
        }

        // 2015.05.14 check EQ Type/Size field
        var isNullEqTySz = true;
        var checkList = sheetObj.FindCheckedRow('chk');
        var checkArray = checkList.split('|');
        for(var row = 0; row < checkArray.length; row++) {
	        var isComScgAply = sheetObj.GetCellValue(checkArray[row], "com_scg_aply_flg");
	        var start = sheetObj.SaveNameCol("eq_alal");
	        var end = sheetObj.SaveNameCol("eq_p4");
	        
	        if(isComScgAply =="1") {
	        	isNullEqTySz = false;
	        } else {
		        for(var col = start; col <= end; col++) {
		            if(sheetObj.GetCellValue(checkArray[row], col) == "1") {
		            	isNullEqTySz = false;
		            	break;
		            }
		        }	
	        }
	        
	        if (isNullEqTySz) {
	            formObject.verify_result_str_1.value = "EQ Type/Size field is missing.";
	            ComShowCodeMessage("TRS90410", "EQ Type/Size");
	            sheetObj.SelectCell(checkArray[i], "eq_alal");
	            ComOpenWait(false);
	        	return false;
	        }
        }

        formObject.verify_result_str_1.value = "Verify is being processed. Please wait.";
        errCnt = 0; //initialize global variable

        var dupRow=sheetObj.ColValueDup("trsp_scg_cd|trsp_cost_mod_cd|agmt_trsp_tp_cd|trsp_bnd_cd|cgo_tp_cd|spcl_cgo_cntr_tp_cd|cust_cd|cmdt_grp_cd|rail_svc_tp_cd|eff_fm_dt|eff_to_dt|" +
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
                                        "to_wgt|wgt_meas_ut_cd|usr_def_rmk");
        var dupRow2=dupRow - 1;
        if(dupRow != -1) {
            ComShowCodeMessage("TRS90412", "row " + dupRow2);
            sheetObj.SetSelectRow(dupRow);
            sheetObj.SetCellValue(dupRow, 'rlt', 'DUP', 0);
            ComOpenWait(false);
            sheetObj.SetWaitImageVisible(1);
            return;
        }

        var dupKey = "trsp_scg_cd|trsp_cost_mod_cd|agmt_trsp_tp_cd|trsp_bnd_cd|cgo_tp_cd|spcl_cgo_cntr_tp_cd|cust_cd|cmdt_grp_cd|rail_svc_tp_cd|" +
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
                     "to_wgt|wgt_meas_ut_cd|usr_def_rmk";
        var effectiveDateCheck = checkEffectiveDate(sheetObj, dupKey)
        if(!effectiveDateCheck) {
            //ComShowCodeMessage("TRS90412", "Effective Date");
            ComOpenWait(false);
            sheetObj.SetWaitImageVisible(1);
            return;
        }

        // 1. Unchecking Checked Check Box
        // Common : Check   ===> Unchecking O
        // Common : Uncheck ===> Unchecking X
        var checkList = sheetObj.FindCheckedRow('chk');
        checkArrayOnVerify = checkList.split('|'); // set global variable
        for(var idx = 0; idx < checkArray.length; idx++) {
            if(sheetObj.GetCellValue(checkArrayOnVerify[idx], 'com_scg_aply_flg') == '1') {
                sheetObj.SetCellValue(checkArrayOnVerify[idx], 'chk',   0, 0);
                sheetObj.SetCellValue(checkArrayOnVerify[idx], 'chk2',  0, 0);
                sheetObj.SetCellValue(checkArrayOnVerify[idx], 'ck_vf', 0, 0);
            } else {
                sheetObj.SetCellValue(checkArrayOnVerify[idx], 'chk',   1, 0);
                sheetObj.SetCellValue(checkArrayOnVerify[idx], 'chk2',  1, 0);
                sheetObj.SetCellValue(checkArrayOnVerify[idx], 'ck_vf', 1, 0);
            }

            // 2015.05.07 if all node values are empty then agmt_rout_all_flg is Y or N
            if( sheetObj.GetCellValue(checkArrayOnVerify[idx], "fm_nod_cd") != ""
            	|| sheetObj.GetCellValue(checkArrayOnVerify[idx], "via_nod_cd") != ""
            	|| sheetObj.GetCellValue(checkArrayOnVerify[idx], "to_nod_cd") != ""
            	|| sheetObj.GetCellValue(checkArrayOnVerify[idx], "dor_nod_cd") != "" ) {
            	sheetObj.SetCellValue(checkArrayOnVerify[idx], "agmt_rout_all_flg", "N", 0);
            } else {
            	sheetObj.SetCellValue(checkArrayOnVerify[idx], "agmt_rout_all_flg", "Y", 0);
            }
        }

        // skip when only one row is checked and it's common surcharge apply flag is true
        var check_row = sheetObj.CheckedRows('chk');
        if(check_row == '') {
        	sheet5_OnSearchEnd(sheetObjects[5], "");
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
    var formObject=document.form;
    // reset sequence
    sheetObj.ReNumberSeq();

        formObject.verify_result_str_2.value="Collect data is being precessed. Please wait.";
        ComOpenWait(true);
        document.all.btng_verify.disabled=false;
        formObject.f_cmd.value=SEARCH02;
        //Upon completion ck_vf verify the value of '1 '-> '0' is changed to.
        var check_verify = sheetObj.CheckedRows('ck_vf');
        var check_row=sheetObj.CheckedRows('chk');
        if(check_verify == '' || check_row == '') {
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
	        
	        if(isComScgAply =="1") {
	        	isNullEqTySz = false;
	        } else {
		        for(var col = start; col <= end; col++) {
		            if(sheetObj.GetCellValue(checkArray[row], col) == "1") {
		            	isNullEqTySz = false;
		            	break;
		            }
		        }	
	        }
	        
	        if (isNullEqTySz) {
	            formObject.verify_result_str_1.value = "EQ Type/Size field is missing.";
	            ComShowCodeMessage("TRS90410", "EQ Type/Size");
	            sheetObj.SelectCell(checkArray[i], "eq_alal");
	            ComOpenWait(false);
	        	return false;
	        }
        }

        formObject.verify_result_str_2.value = "Verify is being processed. Please wait.";
        errCnt = 0; //initialize global variable

        var dupRow=sheetObj.ColValueDup("trsp_scg_cd|trsp_cost_mod_cd|agmt_trsp_tp_cd|cgo_tp_cd|cust_cd|cmdt_grp_cd|rail_svc_tp_cd|eff_fm_dt|eff_to_dt|" +
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
                                        "to_wgt|wgt_meas_ut_cd|usr_def_rmk");
        var dupRow2=dupRow - 1;
        if(dupRow != -1) {
            ComShowCodeMessage("TRS90412", "row " + dupRow2);
            sheetObj.SetSelectRow(dupRow);
            sheetObj.SetCellValue(dupRow, 'rlt', 'DUP', 0);
            ComOpenWait(false);
            return;
        }

        var dupKey = "trsp_scg_cd|trsp_cost_mod_cd|agmt_trsp_tp_cd|cgo_tp_cd|cust_cd|cmdt_grp_cd|rail_svc_tp_cd|" +
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
                     "to_wgt|wgt_meas_ut_cd|usr_def_rmk";
        var effectiveDateCheck = checkEffectiveDate(sheetObj, dupKey);
        if(!effectiveDateCheck) {
            //ComShowCodeMessage("TRS90412", "Effective Date");
            ComOpenWait(false);
            return;
        }

        // 1. Unchecking Checked Check Box
        // Common : Check   ===> Unchecking O
        // Common : Uncheck ===> Unchecking X
        var checkList = sheetObj.FindCheckedRow('chk');
        var checkArray = checkList.split('|');
        for(var idx = 0; idx < checkArray.length; idx++) {
            if(sheetObj.GetCellValue(checkArray[idx], 'com_scg_aply_flg') == '1') {
                sheetObj.SetCellValue(checkArray[idx], 'chk',   0, 0);
                sheetObj.SetCellValue(checkArray[idx], 'chk2',  0, 0);
                sheetObj.SetCellValue(checkArray[idx], 'ck_vf', 0, 0);
            } else {
                sheetObj.SetCellValue(checkArray[idx], 'chk',   1, 0);
                sheetObj.SetCellValue(checkArray[idx], 'chk2',  1, 0);
                sheetObj.SetCellValue(checkArray[idx], 'ck_vf', 1, 0);
            }

            // 2015.05.07 if all node values are empty then agmt_rout_all_flg is Y or N
            if( sheetObj.GetCellValue(checkArray[idx], "fm_nod_cd") != ""
            	|| sheetObj.GetCellValue(checkArray[idx], "via_nod_cd") != ""
            	|| sheetObj.GetCellValue(checkArray[idx], "to_nod_cd") != ""
            	|| sheetObj.GetCellValue(checkArray[idx], "dor_nod_cd") != "" ) {
            	sheetObj.SetCellValue(checkArray[idx], "agmt_rout_all_flg", "N", 0);
            } else {
            	sheetObj.SetCellValue(checkArray[idx], "agmt_rout_all_flg", "Y", 0);
            }
        }

        // skip when only one row is checked and it's common surcharge apply flag is true
        var check_row = sheetObj.CheckedRows('chk');
        if(check_row == '') {
        	sheet5_OnSearchEnd(sheetObjects[5], "");
            return;
        }

        var queryStr = sheetObj.GetSaveString(0, 1, 'chk');
        sheetObjects[5].RemoveAll();
        sheetObjects[5].DoSearch("ESD_TRS_0221GS.do", TrsFrmQryString(formObject)+'&'+queryStr, {Sync:1});
}

/**
 * Genset Verify Check
 */
function valcheck_two3(sheetObj) {
    var formObject=document.form;
    // reset sequence
    sheetObj.ReNumberSeq();

        formObject.verify_result_str_3.value="Collect data is being precessed. Please wait.";
        ComOpenWait(true);
        document.all.btng_verify.disabled=false;
        formObject.f_cmd.value=SEARCH02;
        //Upon completion ck_vf verify the value of '1 '-> '0' is changed to.
        var check_verify    = sheetObj.CheckedRows('ck_vf');
        var check_row=sheetObj.CheckedRows('chk');
        if(check_verify == '' || check_row == '')  {
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
	        var end = sheetObj.SaveNameCol("eq_ug");
	        
	        if(isComScgAply =="1") {
	        	isNullEqTySz = false;
	        } else {
		        for(var col = start; col <= end; col++) {
		            if(sheetObj.GetCellValue(checkArray[row], col) == "1") {
		            	isNullEqTySz = false;
		            	break;
		            }
		        }
	        }
	        
	        if (isNullEqTySz) {
	            formObject.verify_result_str_1.value = "EQ Type/Size field is missing.";
	            ComShowCodeMessage("TRS90410", "EQ Type/Size");
	            sheetObj.SelectCell(checkArray[i], "eq_alal");
	            ComOpenWait(false);
	        	return false;
	        }
        }

        formObject.verify_result_str_3.value = "Verify is being processed. Please wait.";
        errCnt = 0; //initialize global variable

        var dupRow=sheetObj.ColValueDup("trsp_scg_cd|trsp_cost_mod_cd|agmt_trsp_tp_cd|cgo_tp_cd|cust_cd|cmdt_grp_cd|rail_svc_tp_cd|eff_fm_dt|eff_to_dt|" +
                                        "fm_nod_cd|fm_nod_yd|to_nod_cd|to_nod_yd|" +
                                        "eq_alal|eq_cg|eq_ug|" +
                                        "to_wgt|wgt_meas_ut_cd|usr_def_rmk");
        var dupRow2=dupRow - 1;
        if(dupRow != -1) {
            ComShowCodeMessage("TRS90412", "row " + dupRow2);
            sheetObj.SetSelectRow(dupRow);
            sheetObj.SetCellValue(dupRow, 'rlt', 'DUP', 0);
            ComOpenWait(false);
            return;
        }

        var dupKey = "trsp_scg_cd|trsp_cost_mod_cd|agmt_trsp_tp_cd|cgo_tp_cd|cust_cd|cmdt_grp_cd|rail_svc_tp_cd|" +
                     "fm_nod_cd|fm_nod_yd|to_nod_cd|to_nod_yd|" +
                     "eq_alal|eq_cg|eq_ug|" +
                     "to_wgt|wgt_meas_ut_cd|usr_def_rmk";
        var effectiveDateCheck = checkEffectiveDate(sheetObj, dupKey)
        if(!effectiveDateCheck) {
            ComOpenWait(false); // Layered atmospheric image display
            return;
        }
        
        // 1. Unchecking Checked Check Box
        // Common : Check   ===> Unchecking O
        // Common : Uncheck ===> Unchecking X
        var checkList = sheetObj.FindCheckedRow('chk');
        var checkArray = checkList.split('|');
        for(var idx = 0; idx < checkArray.length; idx++) {
            if(sheetObj.GetCellValue(checkArray[idx], 'com_scg_aply_flg') == '1') {
                sheetObj.SetCellValue(checkArray[idx], 'chk',   0, 0);
                sheetObj.SetCellValue(checkArray[idx], 'chk2',  0, 0);
                sheetObj.SetCellValue(checkArray[idx], 'ck_vf', 0, 0);
            } else {
                sheetObj.SetCellValue(checkArray[idx], 'chk',   1, 0);
                sheetObj.SetCellValue(checkArray[idx], 'chk2',  1, 0);
                sheetObj.SetCellValue(checkArray[idx], 'ck_vf', 1, 0);
            }

            // 2015.05.07 if all node values are empty then agmt_rout_all_flg is Y or N
            if( sheetObj.GetCellValue(checkArray[idx], "fm_nod_cd") != ""
            	|| sheetObj.GetCellValue(checkArray[idx], "via_nod_cd") != ""
            	|| sheetObj.GetCellValue(checkArray[idx], "to_nod_cd") != ""
            	|| sheetObj.GetCellValue(checkArray[idx], "dor_nod_cd") != "" ) {
            	sheetObj.SetCellValue(checkArray[idx], "agmt_rout_all_flg", "N", 0);
            } else {
            	sheetObj.SetCellValue(checkArray[idx], "agmt_rout_all_flg", "Y", 0);
            }
        }

        // skip when only one row is checked and it's common surcharge apply flag is true
        var check_row = sheetObj.CheckedRows('chk');
        if(check_row == '') {
        	sheet5_OnSearchEnd(sheetObjects[5], "");
            return;
        }

        var queryStr = sheetObj.GetSaveString(0, 1, 'chk');
        sheetObjects[5].RemoveAll();
        sheetObjects[5].DoSearch("ESD_TRS_0221GS.do", TrsFrmQryString(formObject)+'&'+queryStr, {Sync:1});
}

/**
 * 2015.03.19    Hyungwook Choi
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

/**
 * Save Container Verify pass rate
 */
function update1(sheetObj) {
    ComOpenWait(true);
    var formObject=document.form;
    var sheetRowCount=sheetObj.RowCount();
    var check_verify=sheetObj.CheckedRows('ck_vf');
    var check_result=false;

    var check_row = sheetObj.CheckedRows('chk');
    if(check_row == '') {
        ComOpenWait(false);
        ComShowMessage(ComGetMsg("TRS90036"));
        return;
    }

    for(var k = sheetObj.HeaderRows(); k < sheetRowCount + sheetObj.HeaderRows(); k++) {
        if (sheetObj.GetRowStatus(k) != 'R') {
            if(sheetObj.GetCellValue(k, 'rlt') != 'OK') {
                check_result = true;
            }
        }
    }

    if(check_verify > 0 && check_result) {
        ComOpenWait(false);
        ComShowCodeMessage('TRS90039');
        formObject.verify_result_str_1.value="Please click on the 'Verify' button.";
        return false;
    }

    var y1=formObject.fm_agmtno.value;
    formObject.message_1.value="S";
    var verify_2=formObject.verify_result_1.value;
    var verify_3=formObject.verify_check_yn_1.value;
    formObject.total_rows_cnt_1.value=sheetObj.RowCount();

    if(sheetRowCount > 0) {
        if(verify_2 == 0 && verify_3 == "Y") {

            var checkList = sheetObj.FindCheckedRow('chk');
            var checkArray = checkList.split('|');
            for(var idx = 0; idx < checkArray.length; idx++) {
                // 2015.05.07 if all node values are empty then agmt_rout_all_flg is Y or N
                if( sheetObj.GetCellValue(checkArray[idx], "fm_nod_cd") != ""
                	|| sheetObj.GetCellValue(checkArray[idx], "via_nod_cd") != ""
                	|| sheetObj.GetCellValue(checkArray[idx], "to_nod_cd") != ""
                	|| sheetObj.GetCellValue(checkArray[idx], "dor_nod_cd") != "" ) {
                	sheetObj.SetCellValue(checkArray[idx], "agmt_rout_all_flg", "N", 0);
                } else {
                	sheetObj.SetCellValue(checkArray[idx], "agmt_rout_all_flg", "Y", 0);
                }
            }
        	
            formObject.f_cmd.value=MULTI01;
            sheetObj.DoSave("ESD_TRS_0221GS.do", TrsFrmQryString(formObject), "chk", false, true);

            if(formObject.message_1.value=="V") {
            } else if(formObject.message_1.value=="S") {
                 if(_errMsg == '' || _errMsg == null) {
                     formObject.updated_rows_cnt_1.value = sheetObj.CheckedRows('chk');
                     formObject.verify_result_str_1.value = "Saving has been completed.";
                 } else {
                     formObject.updated_rows_cnt_1.value = '0';
                     formObject.verify_result_str_1.value = _errMsg;
                 }
            }
            formObject.message_1.value="";
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
    ComOpenWait(true);
    var formObject=document.form;
    var sheetRowCount=sheetObj.RowCount();
    var check_verify=sheetObj.CheckedRows('ck_vf');
    var check_result=false;

    var check_row = sheetObj.CheckedRows('chk');
    if(check_row == '') {
        ComOpenWait(false);
        ComShowCodeMessage('TRS90036');
        return;
    }

    for(var k = sheetObj.HeaderRows(); k < sheetRowCount + sheetObj.HeaderRows(); k++) {
        if (sheetObj.GetRowStatus(k) != 'R') {
            if(sheetObj.GetCellValue(k, 'rlt') != 'OK') {
                check_result = true;
            }
        }
    }

    if(check_verify > 0 && check_result) {
        ComOpenWait(false);
        ComShowCodeMessage('TRS90039');
        formObject.verify_result_str_2.value="Please click on the 'Verify' button.";
        return false;
    }

    var y1=formObject.fm_agmtno.value;
    formObject.message_2.value="S";
    var verify_2=formObject.verify_result_2.value;
    var verify_3=formObject.verify_check_yn_2.value;
    formObject.total_rows_cnt_2.value=sheetObj.RowCount();

    if(sheetRowCount > 0) {
       if(verify_2 == 0 && verify_3 == "Y") {
           var checkList = sheetObj.FindCheckedRow('chk');
           var checkArray = checkList.split('|');
           for(var idx = 0; idx < checkArray.length; idx++) {
               // 2015.05.07 if all node values are empty then agmt_rout_all_flg is Y or N
               if( sheetObj.GetCellValue(checkArray[idx], "fm_nod_cd") != ""
               	|| sheetObj.GetCellValue(checkArray[idx], "via_nod_cd") != ""
               	|| sheetObj.GetCellValue(checkArray[idx], "to_nod_cd") != ""
               	|| sheetObj.GetCellValue(checkArray[idx], "dor_nod_cd") != "" ) {
               	sheetObj.SetCellValue(checkArray[idx], "agmt_rout_all_flg", "N", 0);
               } else {
               	sheetObj.SetCellValue(checkArray[idx], "agmt_rout_all_flg", "Y", 0);
               }
           }
           
            formObject.f_cmd.value=MULTI01;
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
        }else{
            ComOpenWait(false);
            ComShowCodeMessage('TRS90039');
        }
    }
}

/**
 * Save Genset Verify pass rate
 */
function update3(sheetObj) {
    ComOpenWait(true);
    var formObject=document.form;
    var sheetRowCount=sheetObj.RowCount();
    var check_verify=sheetObj.CheckedRows('ck_vf');
    var check_result=false;

    var check_row = sheetObj.CheckedRows('chk');
    if(check_row == '') {
        ComOpenWait(false);
        ComShowCodeMessage('TRS90036');
        return;
    }

    for(var k = sheetObj.HeaderRows(); k < sheetRowCount + sheetObj.HeaderRows(); k++) {
        if (sheetObj.GetRowStatus(k) != 'R') {
            if(sheetObj.GetCellValue(k, 'rlt') != 'OK') {
                check_result = true;
            }
        }
    }

    if(check_verify > 0 && check_result) {
        ComOpenWait(false);
        ComShowCodeMessage('TRS90039');
        formObject.verify_result_str_3.value="Please click on the 'Verify' button.";
        return false;
    }

    var y1=formObject.fm_agmtno.value;
    formObject.message_3.value="S";
    var verify_2=formObject.verify_result_3.value;
    var verify_3=formObject.verify_check_yn_3.value;
    formObject.total_rows_cnt_3.value=sheetObj.RowCount();

    if(sheetRowCount > 0) {
        if(verify_2 == 0 && verify_3 == "Y") {
            var checkList = sheetObj.FindCheckedRow('chk');
            var checkArray = checkList.split('|');
            for(var idx = 0; idx < checkArray.length; idx++) {
                // 2015.05.07 if all node values are empty then agmt_rout_all_flg is Y or N
                if( sheetObj.GetCellValue(checkArray[idx], "fm_nod_cd") != ""
                	|| sheetObj.GetCellValue(checkArray[idx], "via_nod_cd") != ""
                	|| sheetObj.GetCellValue(checkArray[idx], "to_nod_cd") != ""
                	|| sheetObj.GetCellValue(checkArray[idx], "dor_nod_cd") != "" ) {
                	sheetObj.SetCellValue(checkArray[idx], "agmt_rout_all_flg", "N", 0);
                } else {
                	sheetObj.SetCellValue(checkArray[idx], "agmt_rout_all_flg", "Y", 0);
                }
            }
            
            formObject.f_cmd.value=MULTI01;
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
        }else{
            ComOpenWait(false);
            ComShowCodeMessage('TRS90039');
        }
    }
}

/**
 * Verify Rule pop-up
 */
function openHelp() {
    var formObj=document.form;
    var Option="width=680,height=700,menubar=0,status=0,scrollbars=3,resizable=0";
    window.open('apps/opus/esd/trs/agreementmanage/agreementmanage/html/surcharge_verify_rule.htm', "popupHelp2", Option);
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
//                        break;
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