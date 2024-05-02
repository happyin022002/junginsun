/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESD_TRS_0226.js
*@FileTitle  : Agreement Rate Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/10
=========================================================*/
/**
 * Define the initial values and headers of sheets
 * European S/O
 */
function initSheet(sheetObj, sheetNo) {
  var sheetObject=sheetObjects[0];
  var sheetObject1=sheetObjects[1];
  var sheetObject2=sheetObjects[2];
  var cnt=0;
  switch(sheetNo) {
  case 1: //sheet0 init ( ATMT Header ) Hidden Sheet
  with(sheetObj){
    var HeadTitle1="AGMT CITY CODE|AGMT NO|VNDR_SEQ|VNDR_NM|CONTRACT OFFICE CODE|REFERENCE NUMBER|PIC NAME|REMARK" ;

    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    InitHeaders(headers, info);

    var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"trsp_agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
           {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"trsp_agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
           {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"vndr_prmry_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
           {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"vndr_prmry_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
           {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ctrt_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
           {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"agmt_ref_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
           {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"agmt_pic_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
           {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"inter_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 } ];
     
    InitColumns(cols);

    SetEditable(1);
    SetCountPosition(0);
    SetVisible(0);
    //SetHeaderRowHeight(25);
    //SetSheetHeight(0);
    }
  break;
  case 2: //sheet1 init ( Child S/P )
  with(sheetObj){
    var HeadTitle1="SEQ|Child Service\nProvider|Child Service\nProvider" ;

    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    InitHeaders(headers, info);

    var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
           {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
           {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:1,   SaveName:"vndr_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:100 } ];
     
    InitColumns(cols);
	SetEditable(1);
	SetCountPosition(0);
	SetHeaderRowHeight(25);
	SetSheetHeight(85);
    }
  break;
  case 3: //sheet2 init ( Rate )
  with(sheetObj){
    var HeadTitle1="|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|From|From|Via|Via|Door|Door|To|To|Currency|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|One Way\n(CY rate)|Round Trip\n(DR rate)|Feeder Term|Feeder Term|No of\nContainer|Weight\nTier|UOM|Reverse|COA|Effective Date|Effective Date|UDU" ;
    var HeadTitle2="|Cost\nMode|Trans\nMode|T/Ship|Cargo\nType|Cargo\nNature|Customer\nCode|Commodity\nGroup Code|Rail Service\nType|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Currency|ALAL|DAL|RAL|AAL|FAL|TAL|SAL|OAL|PAL|AL2|AL4|AL5|AL7|AL9|D2|D4|D5|D7|R2|R4|R5|R7|A2|A4|F2|F4|F5|T2|T4|S2|S4|O2|O4|P2|P4|One Way\n(CY rate)|Round Trip\n(DR rate)|Receiving|Delivery|No of\nContainer|Weight\nTier|UOM|Reverse|COA|From|To|UDU" ;

    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
    var headers = [ { Text:HeadTitle1, Align:"Center"},
                { Text:HeadTitle2, Align:"Center"} ];
    InitHeaders(headers, info);

    var cols = [
           {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
           {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"trsp_cost_mod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"agmt_trsp_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"trsp_bnd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
           {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_cntr_tp_cd",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
           {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cust_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
           {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_grp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
           {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rail_svc_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
           {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
           {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_yd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"via_nod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
           {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"via_nod_yd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dor_nod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
           {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dor_nod_yd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
           {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_yd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_alal",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_dal",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N"  },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_ral",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N"  },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_aal",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N"  },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_fal",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_tal",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_sal",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_oal",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_pal",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_al2",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_al4",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_al5",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_al7",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_al9",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"eq_d2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"eq_d4",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"eq_d5",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"eq_d7",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"eq_r2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"eq_r4",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"eq_r5",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"eq_r7",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"eq_a2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"eq_a4",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"eq_f2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"eq_f4",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"eq_f5",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"eq_t2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"eq_t4",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"eq_s2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"eq_s4",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"eq_o2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"eq_o4",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"eq_p2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"eq_p4",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"trsp_one_wy_rt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:1,   EditLen:18 },
           {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"trsp_rnd_rt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:1,   EditLen:18 },
           {Type:"Combo",     Hidden:0, Width:62,   Align:"Center",  ColMerge:1,   SaveName:"wtr_rcv_term_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
           {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"wtr_de_term_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
           {Type:"Int",       Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_bdl_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
           {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"to_wgt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:9 },
           {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_meas_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
           {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trsp_rvs_aply_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
           {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cost_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"Date",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eff_fm_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
           {Type:"Date",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eff_to_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
           {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"usr_def_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:500 },
           {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ck_vf",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
           {Type:"Status",    Hidden:1, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 }
           ];
     
    InitColumns(cols);

    SetEditable(1);//Permissionofwholeediting(selection,Defaultfalse)
    SetColProperty('trsp_cost_mod_cd', {ComboText:"|"+trsp_cost_mod_cdCode, ComboCode:"|"+trsp_cost_mod_cdCode} );
    SetColProperty('agmt_trsp_tp_cd', {ComboText:"|"+agmt_trsp_tp_cdCode, ComboCode:"|"+agmt_trsp_tp_cdCode} );
    SetColProperty('cgo_tp_cd', {ComboText:"|"+cgo_tp_cdCode, ComboCode:"|"+cgo_tp_cdCode} );
    SetColProperty('rail_svc_tp_cd', {ComboText:"|"+rail_svc_tp_cdCode, ComboCode:"|"+rail_svc_tp_cdCode} );
    SetColProperty('curr_cd', {ComboText:"|"+curr_cdCode, ComboCode:"|"+curr_cdCode} );
    SetColProperty('wtr_rcv_term_cd', {ComboText:"|"+wtr_term_cdCode, ComboCode:"|"+wtr_term_cdCode} );
    SetColProperty('wtr_de_term_cd', {ComboText:"|"+wtr_term_cdCode, ComboCode:"|"+wtr_term_cdCode} );
    SetColProperty('trsp_rvs_aply_flg', {ComboText:"|Y|N", ComboCode:"|Y|N"} );
    document.form.header_row.value=HeaderRows()-1;
    SetSheetHeight(334);
    }
  break;
  case 4: //sheet3 init ( Rate )
  with(sheetObj){
    
    var HeadTitle1="|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|From|From|Via|Via|Door|Door|To|To|Currency|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|One Way\n(CY rate)|Round Trip\n(DR rate)|Feeder Term|Feeder Term|No of\nChassis|Weight\nTier|UOM|Reverse|COA|Effective Date|Effective Date|UDU";
    var HeadTitle2="|Cost\nMode|Trans\nMode|Cargo\nType|Customer\nCode|Commodity\nGroup Code|Rail Service\nType|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Currency|ALAL|SFAL|SLAL|TAAL|GNAL|EGAL|AL2|AL4|AL5|AL8|SF2|SF4|SL2|TA2|GN4|GN5|EG5|EG8|ZT4|CB4|One Way\n(CY rate)|Round Trip\n(DR rate)|Receiving|Delivery|No of\nChassis|Weight\nTier|UOM|Reverse|COA|From|To|UDU" ;

    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
    var headers = [ { Text:HeadTitle1, Align:"Center"},
                { Text:HeadTitle2, Align:"Center"} ];
    InitHeaders(headers, info);

    var cols = [
           {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
           {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"trsp_cost_mod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"agmt_trsp_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"Combo",     Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cust_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
           {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_grp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
           {Type:"Combo",     Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rail_svc_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
           {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
           {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_yd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"via_nod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
           {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"via_nod_yd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dor_nod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
           {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dor_nod_yd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
           {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_yd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_alal",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_sfal",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_slal",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_taal",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_gnal",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_egal",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_al2",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_al4",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_al5",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_al8",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"eq_sf2",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"eq_sf4",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"eq_sl2",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"eq_ta2",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"eq_gn4",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"eq_gn5",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"eq_eg5",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"eq_eg8",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"eq_zt4",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"eq_cb4",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"trsp_one_wy_rt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:1,   EditLen:18 },
           {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"trsp_rnd_rt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:1,   EditLen:18 },
           {Type:"Combo",     Hidden:0, Width:62,   Align:"Center",  ColMerge:1,   SaveName:"wtr_rcv_term_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
           {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"wtr_de_term_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
           {Type:"Int",       Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_bdl_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
           {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"to_wgt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:9 },
           {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_meas_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
           {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trsp_rvs_aply_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
           {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cost_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"Date",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eff_fm_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
           {Type:"Date",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eff_to_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
           {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"usr_def_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:500 },
           {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ck_vf",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
           {Type:"Status",    Hidden:1, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 }
           ];
     
    InitColumns(cols);

    SetEditable(1);
    SetColProperty('trsp_cost_mod_cd', {ComboText:"|"+trsp_cost_mod_cdCode, ComboCode:"|"+trsp_cost_mod_cdCode} );
    SetColProperty('agmt_trsp_tp_cd', {ComboText:"|"+agmt_trsp_tp_cdCode, ComboCode:"|"+agmt_trsp_tp_cdCode} );
    SetColProperty('cgo_tp_cd', {ComboText:"|"+cgo_tp_cdCode, ComboCode:"|"+cgo_tp_cdCode} );
    SetColProperty('rail_svc_tp_cd', {ComboText:"|"+rail_svc_tp_cdCode, ComboCode:"|"+rail_svc_tp_cdCode} );
    SetColProperty('curr_cd', {ComboText:"|"+curr_cdCode, ComboCode:"|"+curr_cdCode} );
    SetColProperty('wtr_rcv_term_cd', {ComboText:"|"+wtr_term_cdCode, ComboCode:"|"+wtr_term_cdCode} );
    SetColProperty('wtr_de_term_cd', {ComboText:"|"+wtr_term_cdCode, ComboCode:"|"+wtr_term_cdCode} );
    SetColProperty('trsp_rvs_aply_flg', {ComboText:"|Y|N", ComboCode:"|Y|N"} );
    document.form.header_row.value=HeaderRows()-1;
    SetSheetHeight(334);
    }
  break;
  case 5: //sheet4 init ( Rate )
  with(sheetObj){
   
    var HeadTitle1="|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|From|From|Via|Via|Door|Door|To|To|Currency|EQ Type/Size|EQ Type/Size|EQ Type/Size|One Way\n(CY rate)|Round Trip\n(DR rate)|Feeder Term|Feeder Term|No of\nGenset|Weight\nTier|UOM|Reverse|COA|Effective Date|Effective Date|UDU";
    var HeadTitle2="|Cost\nMode|Trans\nMode|Cargo\nType|Customer\nCode|Commodity\nGroup Code|Rail Service\nType|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Currency|ALAL|CG|UG|One Way\n(CY rate)|Round Trip\n(DR rate)|Receiving|Delivery|No of\nGenset|Weight\nTier|UOM|Reverse|COA|From|To|UDU" ;

    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
    var headers = [ { Text:HeadTitle1, Align:"Center"},
                { Text:HeadTitle2, Align:"Center"} ];
    InitHeaders(headers, info);

    var cols = [
           {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
           {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"trsp_cost_mod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"agmt_trsp_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"Combo",     Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cust_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
           {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_grp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
           {Type:"Combo",     Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rail_svc_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
           {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
           {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_yd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"via_nod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
           {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"via_nod_yd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dor_nod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
           {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dor_nod_yd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
           {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_yd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
           {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"eq_alal",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"eq_cg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"eq_ug",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"trsp_one_wy_rt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:1,   EditLen:18 },
           {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"trsp_rnd_rt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:1,   EditLen:18 },
           {Type:"Combo",     Hidden:0, Width:62,   Align:"Center",  ColMerge:1,   SaveName:"wtr_rcv_term_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
           {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"wtr_de_term_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
           {Type:"Int",       Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_bdl_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
           {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"to_wgt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:9 },
           {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_meas_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
           {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trsp_rvs_aply_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
           {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cost_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
           {Type:"Date",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eff_fm_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
           {Type:"Date",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eff_to_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
           {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"usr_def_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:500 },
           {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ck_vf",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
           {Type:"Status",    Hidden:1, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 }
           ];
     
    InitColumns(cols);

    SetEditable(1);
    SetColProperty('trsp_cost_mod_cd', {ComboText:"|"+trsp_cost_mod_cdCode, ComboCode:"|"+trsp_cost_mod_cdCode} );
    SetColProperty('agmt_trsp_tp_cd', {ComboText:"|"+agmt_trsp_tp_cdCode, ComboCode:"|"+agmt_trsp_tp_cdCode} );
    SetColProperty('cgo_tp_cd', {ComboText:"|"+cgo_tp_cdCode, ComboCode:"|"+cgo_tp_cdCode} );
    SetColProperty('rail_svc_tp_cd', {ComboText:"|"+rail_svc_tp_cdCode, ComboCode:"|"+rail_svc_tp_cdCode} );
    SetColProperty('curr_cd', {ComboText:"|"+curr_cdCode, ComboCode:"|"+curr_cdCode} );
    SetColProperty('wtr_rcv_term_cd', {ComboText:"|"+wtr_term_cdCode, ComboCode:"|"+wtr_term_cdCode} );
    SetColProperty('wtr_de_term_cd', {ComboText:"|"+wtr_term_cdCode, ComboCode:"|"+wtr_term_cdCode} );
    SetColProperty('trsp_rvs_aply_flg', {ComboText:"|Y|N", ComboCode:"|Y|N"} );
    document.form.header_row.value=HeaderRows()-1;
    SetSheetHeight(334);
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
	}
    doSearch();
    if (document.form.parm_eq_knd_cd.value == 'U') {
    	tabObjects[0].SetSelectedIndex(0);
    	tab1_OnChange("", 0);
    } else if (document.form.parm_eq_knd_cd.value == 'Z') {
    	tabObjects[0].SetSelectedIndex(1);
    	tab1_OnChange("", 1);
    } else {
    	tabObjects[0].SetSelectedIndex(2);
    	tab1_OnChange("", 2);
    }
}
/*------------------ Defining general java script function   ------------------*/
/* General global variable */
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
var Mincount=0;
/* Branch processing event handler with the name of button */
function processButtonClick(){
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	var sheetObject2=sheetObjects[2];
	var sheetObject3=sheetObjects[3];
	/*******************************************************/
	var formObject=document.form;
	var rate_sheetObject=sheetObjects[2]; //Agreement Rate information
    if (currenttab == 0) {
    	rate_sheetObject=sheetObjects[2]; //Agreement Rate information
    }else if (currenttab == 1) {
    	rate_sheetObject=sheetObjects[3]; //Agreement Rate information
    }else{
    	rate_sheetObject=sheetObjects[4]; //Agreement Rate information
    }
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btn_retrieve":
			if (currenttab == 0) {
				formObject.cur_page_cnt1.value=1;
			}else if (currenttab == 1) {
				formObject.cur_page_cnt2.value=1;
			}else{
				formObject.cur_page_cnt3.value=1;
			}
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
			if(Number(ipageNo) < 1){
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
			if( (Number(ipageNo) > Number(formObject.tot_page_cnt1.value)) || totpage < 1){
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
			if(Number(ipageNo) < 1){
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
			if( (Number(ipageNo) > Number(formObject.tot_page_cnt1.value)) || totpage < 1){
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
			if(Number(ipageNo) < 1){
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
			if( (Number(ipageNo) > Number(formObject.tot_page_cnt3.value)) || totpage < 1){
				var errMessage=ComGetMsg('TRS90351','','','');  
				ComShowMessage(errMessage);
				break;
			}               
			formObject.cur_page_cnt3.value=ipageNo;
			doActionIBSheet(rate_sheetObject,formObject,"RETRIEVE"); 
			break;
		case "btn_downexcel":
			doActionIBSheet(rate_sheetObject,formObject,"DOWNEXCEL");     // DOWN XLS to CSV 
			break;
		case "btng_downexcel":
			var sheet2_count=rate_sheetObject.RowCount();
			if(sheet2_count > 0){
				doActionIBSheet(rate_sheetObject,formObject,IBDOWNEXCEL);
			}
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
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('TRS90031');
		} else {
			ComShowMessage(e.message);
		}
	}
}
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
	var formObject=document.form;
	var x1="";
    switch(sAction) {
    case IBSEARCH:
    	formObj.f_cmd.value=SEARCH01;
    	sheetObjects[0].DoSearch("ESD_TRS_0220GS.do", TrsFrmQryString(formObj), { Sync:2 } );
		formObj.f_cmd.value=SEARCH02;
		sheetObjects[1].DoSearch("ESD_TRS_0220GS.do", TrsFrmQryString(formObj), { Sync:2 } );
    	break;
    case "RETRIEVE":
    	formObj.f_cmd.value=SEARCH02; 
    	formObj.grid_flg.value='Y';
    	if (currenttab == 0) {
    		formObject.cur_page_cnt.value=formObject.cur_page_cnt1.value;
    		formObject.tot_page_cnt.value=formObject.tot_page_cnt1.value;
			formObject.page_size.value=formObject.page_size1.value;
    	}else if (currenttab == 1) {
    		formObject.cur_page_cnt.value=formObject.cur_page_cnt2.value;
    		formObject.tot_page_cnt.value=formObject.tot_page_cnt2.value;
    		formObject.page_size.value=formObject.page_size1.value;
    	}else{
    		formObject.cur_page_cnt.value=formObject.cur_page_cnt3.value;
    		formObject.tot_page_cnt.value=formObject.tot_page_cnt3.value;
    		formObject.page_size.value=formObject.page_size1.value;
    	}
    	sheetObj.DoSearch("ESD_TRS_0226GS.do", TrsFrmQryString(formObj), { Sync:2 }  );
    	break;
    case "DOWNEXCEL":
		ComOpenWait(true);
		formObj.f_cmd.value=SEARCH03;
	    formObj.grid_flg.value='N';
	    formObj.target="_blank"
		formObj.action="ESD_TRS_0226DL.do";
	    formObj.submit();
	    ComOpenWait(false);
    	break;
    case IBDOWNEXCEL:
        sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObj), CheckBoxOnValue:'Y', CheckBoxOffValue:'N', SheetDesign:1, Merge:1 });
    	break;
    }
}
function doSearch() {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	doActionIBSheet(sheetObject, formObject, IBSEARCH, "", "");
}
/**
* Onkeydown event
*/
function gotopage(){
	var formObject=document.form;
	var tot_page="";
	var cur_page="";
	var rate_sheetObject=sheetObjects[2]; //Agreement Rate information
	if (currenttab == 0) {
		rate_sheetObject=sheetObjects[2]; //Agreement Rate information
		cur_page=formObject.cur_page_cnt1.value;
		tot_page=formObject.tot_page_cnt1.value;
   }else if (currenttab == 1) {
   	rate_sheetObject=sheetObjects[3]; //Agreement Rate information
   	cur_page=formObject.cur_page_cnt2.value;
   	tot_page=formObject.tot_page_cnt2.value;
   }else{
   	rate_sheetObject=sheetObjects[4]; //Agreement Rate information
   	cur_page=formObject.cur_page_cnt3.value;
   	tot_page=formObject.tot_page_cnt3.value;
   }
	if( (Number(cur_page) > Number(tot_page)) || tot_page < 1){
		var errMessage=ComGetMsg('TRS90351','','','');  
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
			InsertItem( "Container" , "");
			InsertItem( "Chassis" , "");
			InsertItem( "Genset" , "");
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
function sheet0_OnSearchEnd(sheetObj,errMsg){
	//RowCount
	var formObj=document.form;
	if(sheetObj.RowCount()> 0) {
		formObj.fm_vndr_prmry_seq.value=sheetObj.GetCellValue(1, "vndr_prmry_seq");
		formObj.fm_vndr_prmry_nm.value=sheetObj.GetCellValue(1, "vndr_prmry_nm");
		formObj.fm_agmt_ref_no.value=sheetObj.GetCellValue(1, "agmt_ref_no");
		formObj.fm_ctrt_ofc_cd.value=sheetObj.GetCellValue(1, "ctrt_ofc_cd");
		formObj.fm_inter_rmk.value=sheetObj.GetCellValue(1, "inter_rmk");
	}
}
 /**
   * EVENT after inquiring
    * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
 */
function sheet2_OnSearchEnd(sheetObj, code, errMsg){
	//RowCount
	var formObj=document.form;
	var cmd=formObj.f_cmd.value;
	var cur_page=formObj.cur_page_cnt1.value;
	if( cmd == SEARCH02 && sheetObj.RowCount()> 0 && cur_page == "1") {
		var tot_cnt=sheetObj.GetEtcData('TOT_CNT');
    	formObj.tot_page_cnt1.value=tot_cnt;
	}
    
	if(code == 0)
		isSheetRetrieved[2] = true;
}
 /**
   * EVENT after inquiring
    * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
 */
function sheet3_OnSearchEnd(sheetObj, code, errMsg){
	//RowCount
	var formObj=document.form;
	var cmd=formObj.f_cmd.value;
	var cur_page=formObj.cur_page_cnt2.value;
	if( cmd == SEARCH02 && sheetObj.RowCount()> 0 && cur_page == "1") {
    	var tot_cnt=sheetObj.GetEtcData('TOT_CNT');
    	formObj.tot_page_cnt2.value=tot_cnt;
	}
    
	if(code == 0)
		isSheetRetrieved[3] = true;
}
 /**
   * EVENT after inquiring
    * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
 */
 function sheet4_OnSearchEnd(sheetObj, code, errMsg){
	 //RowCount
	 var formObj=document.form;
	 var cmd=formObj.f_cmd.value;
	 var cur_page=formObj.cur_page_cnt2.value;
	 if( cmd == SEARCH02 && sheetObj.RowCount()> 0 && cur_page == "1") {
		 var tot_cnt=sheetObj.GetEtcData('TOT_CNT');
		 formObj.tot_page_cnt3.value=tot_cnt;
	 }
    
	if(code == 0)
		isSheetRetrieved[4] = true;
 }
 /**
 * Loading the list of external combo box
 */
 function getComboList(obj, comObj, sep) { //object, value receiving part, kind of Node
	comObj = eval(comObj.id); 
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
 		sheet2.SetSheetHeight(ComGetSheetHeight(sheet2, 18));
 		sheet3.SetSheetHeight(ComGetSheetHeight(sheet3, 18));
 		sheet4.SetSheetHeight(ComGetSheetHeight(sheet4, 18));
 	} else {
 		objs.style.display="inline";
 		sheet2.SetSheetHeight(ComGetSheetHeight(sheet2, 14));
 		sheet3.SetSheetHeight(ComGetSheetHeight(sheet3, 14));
 		sheet4.SetSheetHeight(ComGetSheetHeight(sheet4, 14));
 	}
 }
  /**
   * EVENT after changing value of sheet
    * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
   */
  function sheet2_OnChange(sheetObj, row , col , value) {
	  eq_OnChange(sheetObj, row , col , value);
  }
  /**
   * EVENT after changing value of sheet
    * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
   */
  function sheet3_OnChange(sheetObj, row , col , value) {
	  eq_OnChange(sheetObj, row , col , value);
  }
  /**
   * EVENT after changing value of sheet
    * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
   */
  function sheet4_OnChange(sheetObj, row , col , value) {
	  eq_OnChange(sheetObj, row , col , value);
  }
  /**
   * EVENT after changing value of sheet
  */
  function eq_OnChange(sheetObj, row , col , value) {
 	 if( sheetObj.ColSaveName(col) == "fm_nod_cd" ) {
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
function eq_OnClick(sheetObj, row , col , value)
{
    if(sheetObj.GetRowStatus(row) != "R")
    {
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
	  }
    }
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
		ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 820, 500, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
	}
  function openRateHistory(sheetObject)
  {
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
      if(checkArray.length != 0){
          resultcheck=1;
          for(var i=0; i<checkArray.length-1; i++){
if(sheetObject.GetCellValue(checkArray[0], 'trsp_cost_mod_cd') == sheetObject.GetCellValue(checkArray[i], 'trsp_cost_mod_cd')){
              }else{
                  resultcheck++;
              }
          }
      }
  	if(resultcheck == 1){
  		var myOption="width=980,height=480,menubar=0,status=0,scrollbars=0,resizable=0";
          var param="?"+TrsFrmQryString(formObj);
  		myWin=window.open('/opuscntr/ESD_TRS_0227.do' + param, "Hispopup", myOption);  		
  	}else if(resultcheck == 0){
  		ComShowCodeMessage('TRS90215');
  	}else if(resultcheck > 1){
  		ComShowCodeMessage('TRS90357');
  	}
  }
  /*
   * When the size of page is changed
   */
  function input_change() {
	  reset_all1();
	  reset_all2();
	  reset_all3();
  }
  /**
   *  Container Reset
   */
  function reset_all1(){
	  var formObject=document.form;
	  formObject.tot_page_cnt1.value="";
	  formObject.cur_page_cnt1.value="";
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
	  sheet4.RemoveEtcData();
	  sheet4.RemoveAll();
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