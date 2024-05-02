/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0223.js
*@FileTitle  : Agreement USA Rail Surcharge
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------From here the common JavaScript function is defined.    ------------------*/
/* Common global variable */
var openWindownm='AGMT';
var sheetObjects=new Array();
var sheetCnt=0;
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var currenttab=0;
var rail_road_codeCode;
var rail_road_codeText;
var CurRowCount=0;

/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
*/
function initSheet(sheetObj, sheetNo) {
    var sheetObject=sheetObjects[0];
    var sheetObject1=sheetObjects[1]; 
    var cnt=0;

    switch(sheetNo) {
        case 1: //sheet1 init ( Rate )
            with(sheetObj) {
                var HeadTitle1="|Status|Verification Result|DB Duplication|Rail Company|Rail Company|Agreement\nNo.|Reference\nNo.|Cargo\nNature|Common|Auto-Apply|Route|Route|Route|Route|Route|Cargo\Type|Ratio(%)|COA|Effective Date|Effective Date|Decimal|UDU|Creation\nDate|Update\nDate|Eq Size|Seq" ;
                var HeadTitle2="|Status|Description|DB Duplication|Code|Name|Agreement\nNo.|Reference\nNo.|Cargo\nNature|Common|Auto-Apply|All|ORG Loc|ORG Node|DEST Loc|DEST Node|Cargo\Type|Ratio(%)|COA|From|To|Decimal|UDU|Creation\nDate|Update\nDate|Eq Size|Seq" ;

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [
/*  0*/             {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"chk",               KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1 },
                    {Type:"Status",   Hidden:0, Width:45,  Align:"Center", ColMerge:1, SaveName:"ibflag",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:0 },
                    {Type:"Text",     Hidden:0, Width:170, Align:"Left",   ColMerge:1, SaveName:"rlt",               KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:200 },
                    {Type:"Text",     Hidden:0, Width:100, Align:"Left",   ColMerge:1, SaveName:"rlt2",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:200 },
                    {Type:"Text",     Hidden:0, Width:70,  Align:"Left",   ColMerge:1, SaveName:"vndr_seq",          KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:6 },
                    {Type:"Text",     Hidden:0, Width:180, Align:"Left",   ColMerge:1, SaveName:"vndr_nm",           KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:200 },
                    {Type:"PopupEdit",Hidden:0, Width:100, Align:"Center", ColMerge:1, SaveName:"agmt_no",           KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:9, AcceptKeys:"E|N", InputCaseSensitive:1 },
                    {Type:"Text",     Hidden:0, Width:100, Align:"Left",   ColMerge:1, SaveName:"agmt_ref_no",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:15 },
                    {Type:"Combo",    Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"spcl_cgo_cntr_tp_cd",KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"CheckBox", Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"com_scg_aply_flg",  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0 },
                    {Type:"CheckBox", Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"wo_aply_flg",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0 },
                    {Type:"CheckBox", Hidden:1, Width:50,  Align:"Center", ColMerge:1, SaveName:"agmt_rout_all_flg", KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, HeaderCheck:1, TrueValue:"Y", FalseValue:"N"  },
                    
/* 12*/             {Type:"Text",     Hidden:0, Width:65,  Align:"Center", ColMerge:1, SaveName:"fm_nod_cd",         KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:0, Width:65,  Align:"Center", ColMerge:1, SaveName:"fm_nod_yard",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1 },
                    {Type:"Text",     Hidden:0, Width:65,  Align:"Center", ColMerge:1, SaveName:"to_nod_cd",         KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:0, Width:65,  Align:"Center", ColMerge:1, SaveName:"to_nod_yard",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1 },
                    {Type:"Combo",    Hidden:0, Width:80,  Align:"Center", ColMerge:1, SaveName:"cgo_tp_cd",         KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1 },
                    {Type:"Float",    Hidden:0, Width:80,  Align:"Right",  ColMerge:1, SaveName:"trsp_rail_rto",     KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"CheckBox", Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"agmt_cost_flg",     KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"eff_fm_dt",         KeyField:0, CalcLogic:"", Format:"Ymd",       PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"eff_to_dt",         KeyField:0, CalcLogic:"", Format:"Ymd",       PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Text",     Hidden:0, Width:80,  Align:"Right",  ColMerge:1, SaveName:"rail_rto_no",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:4 },
                    {Type:"Text",     Hidden:0, Width:80,  Align:"Left",   ColMerge:1, SaveName:"usr_def_rmk",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:500 },
                    
/* 23*/             {Type:"Text",     Hidden:0, Width:130, Align:"Center", ColMerge:1, SaveName:"locl_cre_dt",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0 },
                    {Type:"Text",     Hidden:0, Width:130, Align:"Center", ColMerge:1, SaveName:"locl_upd_dt",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0 },
                    {Type:"Text",     Hidden:1, Width:30,  Align:"Center", ColMerge:1, SaveName:"agmt_eq_sz_no",     KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0 },
                    {Type:"Seq",      Hidden:1, Width:30,  Align:"Center", ColMerge:1, SaveName:"row_no",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1 },
                    {Type:"CheckBox", Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"ck_vf",             KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8, HeaderCheck:1, TrueValue:"Y", FalseValue:"N"  },
                    {Type:"Text",     Hidden:1, Width:30,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_scg_seq", KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0 },
                    {Type:"CheckBox", Hidden:1, Width:0,   Align:"Center", ColMerge:1, SaveName:"chk2",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1 },

/* 30*/             {Type:"Text",     Hidden:1, Width:65,  Align:"Center", ColMerge:1, SaveName:"h_fm_nod_cd",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:1, Width:65,  Align:"Center", ColMerge:1, SaveName:"h_fm_nod_yard",     KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:1 },
                    {Type:"Text",     Hidden:1, Width:65,  Align:"Center", ColMerge:1, SaveName:"h_to_nod_cd",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:1, Width:65,  Align:"Center", ColMerge:1, SaveName:"h_to_nod_yard",     KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:1 },
                    {Type:"Combo",    Hidden:1, Width:80,  Align:"Center", ColMerge:1, SaveName:"h_cgo_tp_cd",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:1 },
                    {Type:"Float",    Hidden:1, Width:80,  Align:"Right",  ColMerge:1, SaveName:"h_trsp_rail_rto",   KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"CheckBox", Hidden:1, Width:40,  Align:"Center", ColMerge:1, SaveName:"h_agmt_cost_flg",   KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"Date",     Hidden:1, Width:75,  Align:"Center", ColMerge:1, SaveName:"h_eff_fm_dt",       KeyField:0, CalcLogic:"", Format:"Ymd",       PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Date",     Hidden:1, Width:75,  Align:"Center", ColMerge:1, SaveName:"h_eff_to_dt",       KeyField:0, CalcLogic:"", Format:"Ymd",       PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Text",     Hidden:1, Width:80,  Align:"Right",  ColMerge:1, SaveName:"h_rail_rto_no",     KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:4 },
                    {Type:"Text",     Hidden:1, Width:80,  Align:"Left",   ColMerge:1, SaveName:"h_usr_def_rmk",     KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:500 },

/* 41*/             {Type:"Text",     Hidden:1, Width:65,  Align:"Center", ColMerge:1, SaveName:"n_fm_nod_cd",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:1, Width:65,  Align:"Center", ColMerge:1, SaveName:"n_fm_nod_yard",     KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:1 },
                    {Type:"Text",     Hidden:1, Width:65,  Align:"Center", ColMerge:1, SaveName:"n_to_nod_cd",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:1, Width:65,  Align:"Center", ColMerge:1, SaveName:"n_to_nod_yard",     KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:1 },
                    {Type:"Combo",    Hidden:1, Width:80,  Align:"Center", ColMerge:1, SaveName:"n_cgo_tp_cd",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:1 },
                    {Type:"Float",    Hidden:1, Width:80,  Align:"Right",  ColMerge:1, SaveName:"n_trsp_rail_rto",   KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"CheckBox", Hidden:1, Width:40,  Align:"Center", ColMerge:1, SaveName:"n_agmt_cost_flg",   KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"Date",     Hidden:1, Width:75,  Align:"Center", ColMerge:1, SaveName:"n_eff_fm_dt",       KeyField:0, CalcLogic:"", Format:"Ymd",       PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Date",     Hidden:1, Width:75,  Align:"Center", ColMerge:1, SaveName:"n_eff_to_dt",       KeyField:0, CalcLogic:"", Format:"Ymd",       PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Text",     Hidden:1, Width:80,  Align:"Right",  ColMerge:1, SaveName:"n_rail_rto_no",     KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:4 },
/* 51*/             {Type:"Text",     Hidden:1, Width:80,  Align:"Left",   ColMerge:1, SaveName:"n_usr_def_rmk",     KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:500 }
                ];

                InitColumns(cols);

                SetEditable(1);
                SetColProperty(0, "locl_cre_dt", {Format:"####-##-####:##:##"});
                SetColProperty(0, "locl_upd_dt", {Format:"####-##-####:##:##"});
                SetColProperty(0, "cgo_tp_cd",   {ComboText:"|FULL|EMPTY", ComboCode:"|F|M"});
                SetColProperty(0, 'spcl_cgo_cntr_tp_cd', {ComboText:"|"+spcl_cgo_cntr_tp_cdCode, ComboCode:"|"+spcl_cgo_cntr_tp_cdCode} );
                SetColProperty(0, "fm_nod_cd",   {AcceptKeys:"E|N",          InputCaseSensitive:1});
                SetColProperty(0, "to_nod_cd",   {AcceptKeys:"E|N",          InputCaseSensitive:1});
                SetColProperty(0, "rail_rto_no", {AcceptKeys:"N|[.]",      InputCaseSensitive:1});

                SetColProperty(0, "h_cgo_tp_cd", {ComboText:"|FULL|EMPTY", ComboCode:"|F|M"});
                SetColProperty(0, "n_cgo_tp_cd", {ComboText:"|FULL|EMPTY", ComboCode:"|F|M"});
                SetSheetHeight(410);
            }
            break;

        case 2: //sheet2 init ( ATMT Header ) Hidden Sheet
            with(sheetObj) {
                var HeadTitle1="|Status|Verification Result|DB Duplication|Rail Company|Rail Company|Agreement\nNo.|Reference\nNo.|Cargo\nNature|Surcharge\nKind|Auto-Apply|Route|Route|Route|Route|Route|Cargo\Type|Over Weight\n(LBS)|Total Amount|Total Amount|Total Amount|Total Amount|Total Amount|COA|Effective Date|Effective Date|UDU|Creation\nDate|Update\nDate|Eq Size|Seq" ;
                var HeadTitle2="|Status|Description|DB Duplication|Code|Name|Agreement\nNo.|Reference\nNo.|Cargo\nNature|Surcharge\nKind|Auto-Apply|All|ORG Loc|ORG Node|DEST Loc|DEST Node|Cargo\Type|Over Weight\n(LBS)|Cur|All|20'|40'|45'|COA|From|To|UDU|Creation\nDate|Update\nDate|Eq Size|Seq" ;

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"},  { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [
                    {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"chk",               KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1 },
                    {Type:"Status",   Hidden:0, Width:45,  Align:"Center", ColMerge:1, SaveName:"ibflag",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:0 },
                    {Type:"Text",     Hidden:0, Width:170, Align:"Left",   ColMerge:1, SaveName:"rlt",               KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:200 },
                    {Type:"Text",     Hidden:0, Width:100, Align:"Left",   ColMerge:1, SaveName:"rlt2",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:200 },
                    {Type:"Text",     Hidden:0, Width:70,  Align:"Left",   ColMerge:1, SaveName:"vndr_seq",          KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:6 },
                    {Type:"Text",     Hidden:0, Width:180, Align:"Left",   ColMerge:1, SaveName:"vndr_nm",           KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:200 },
                    {Type:"PopupEdit",Hidden:0, Width:100, Align:"Center", ColMerge:1, SaveName:"agmt_no",           KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:9, AcceptKeys:"E|N", InputCaseSensitive:1 },
                    {Type:"Text",     Hidden:0, Width:90,  Align:"Left",   ColMerge:1, SaveName:"agmt_ref_no",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:15 },
                    {Type:"Combo",    Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"spcl_cgo_cntr_tp_cd",KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Combo",    Hidden:0, Width:80,  Align:"Center", ColMerge:1, SaveName:"trsp_rail_scg_cd",  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:3 },
                    //{Type:"CheckBox", Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"com_scg_aply_flg",  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0 },
                    {Type:"CheckBox", Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"wo_aply_flg",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0 },
                    {Type:"CheckBox", Hidden:1, Width:50,  Align:"Center", ColMerge:1, SaveName:"agmt_rout_all_flg", KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
                    {Type:"Text",     Hidden:0, Width:65,  Align:"Center", ColMerge:1, SaveName:"fm_nod_cd",         KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:0, Width:65,  Align:"Center", ColMerge:1, SaveName:"fm_nod_yard",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1 },
                    {Type:"Text",     Hidden:0, Width:65,  Align:"Center", ColMerge:1, SaveName:"to_nod_cd",         KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5 },
                    {Type:"Text",     Hidden:0, Width:65,  Align:"Center", ColMerge:1, SaveName:"to_nod_yard",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1 },
                    {Type:"Combo",    Hidden:0, Width:80,  Align:"Center", ColMerge:1, SaveName:"cgo_tp_cd",         KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1 },
                    {Type:"Float",    Hidden:0, Width:80,  Align:"Center", ColMerge:1, SaveName:"lbs_ovr_wgt",       KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:3, UpdateEdit:1, InsertEdit:1, EditLen:9 },
                    {Type:"Combo",    Hidden:0, Width:50,  Align:"Center", ColMerge:1, SaveName:"curr_cd",           KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3 },
                    {Type:"Float",    Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"fx_scg_all_rt",     KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:3, UpdateEdit:1, InsertEdit:1, EditLen:15 },
                    {Type:"Float",    Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"fx_scg_20ft_rt",    KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:3, UpdateEdit:1, InsertEdit:1, EditLen:15 },
                    {Type:"Float",    Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"fx_scg_40ft_rt",    KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:3, UpdateEdit:1, InsertEdit:1, EditLen:15 },
                    {Type:"Float",    Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"fx_scg_45ft_rt",    KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:3, UpdateEdit:1, InsertEdit:1, EditLen:15 },
                    {Type:"CheckBox", Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"agmt_cost_flg",     KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                    {Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"eff_fm_dt",         KeyField:0, CalcLogic:"", Format:"Ymd",       PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"eff_to_dt",         KeyField:0, CalcLogic:"", Format:"Ymd",       PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                    {Type:"Text",     Hidden:0, Width:80,  Align:"Left",   ColMerge:1, SaveName:"usr_def_rmk",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:500 },
                    {Type:"Text",     Hidden:0, Width:130, Align:"Center", ColMerge:1, SaveName:"locl_cre_dt",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0 },
                    {Type:"Text",     Hidden:0, Width:130, Align:"Center", ColMerge:1, SaveName:"locl_upd_dt",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0 },
                    {Type:"Text",     Hidden:1, Width:30,  Align:"Center", ColMerge:1, SaveName:"agmt_eq_sz_no",     KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0 },
                    {Type:"Seq",      Hidden:1, Width:30,  Align:"Center", ColMerge:1, SaveName:"row_no",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0 },
                    {Type:"CheckBox", Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"ck_vf",             KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8, TrueValue:"Y", FalseValue:"N" },
                    {Type:"Text",     Hidden:1, Width:30,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_scg_seq", KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0 },
                    {Type:"CheckBox", Hidden:1, Width:0,   Align:"Center", ColMerge:1, SaveName:"chk2",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1 },
                    {Type:"Text",     Hidden:1, Width:0,   Align:"Center", ColMerge:1, SaveName:"fx_scg_all_rt_yn",  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:0 },
                    {Type:"Text",     Hidden:1, Width:0,   Align:"Center", ColMerge:1, SaveName:"fx_scg_20ft_rt_yn", KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:0 },
                    {Type:"Text",     Hidden:1, Width:0,   Align:"Center", ColMerge:1, SaveName:"fx_scg_40ft_rt_yn", KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:0 },
                    {Type:"Text",     Hidden:1, Width:0,   Align:"Center", ColMerge:1, SaveName:"fx_scg_45ft_rt_yn", KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:0 }
                ];

                InitColumns(cols);

                SetEditable(1);
                SetColProperty(0, "locl_cre_dt",      {Format:"####-##-####:##:##"});
                SetColProperty(0, "locl_upd_dt",      {Format:"####-##-####:##:##"});
                SetColProperty(0, "cgo_tp_cd",        {ComboText:"|FULL|EMPTY",        ComboCode:"|F|M"});
                SetColProperty(0, 'spcl_cgo_cntr_tp_cd', {ComboText:"|"+spcl_cgo_cntr_tp_cdCode, ComboCode:"|"+spcl_cgo_cntr_tp_cdCode} );
                SetColProperty(0, "curr_cd",          {ComboText:"|"+default_currText, ComboCode:"|"+default_currCode});
                SetColProperty(0, "trsp_rail_scg_cd", {ComboText:"|OWS|HZS|TTL",       ComboCode:"|OWS|HZS|TTL"});
                SetColProperty(0, "fm_nod_cd",        {AcceptKeys:"E|N",                 InputCaseSensitive:1});
                SetColProperty(0, "to_nod_cd",        {AcceptKeys:"E|N",                 InputCaseSensitive:1});
                SetSheetHeight(410);
              }
            break;

        case 3: // VERIFY & UPDATE RETURN
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
        case 4: // Agreement Header
            with(sheetObj) {
                var HeadTitle1="Chk.|S/P SEQ|S/P NAME|AGMT NO|Reference No|Contract Office|Remark" ;

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"check",       KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",     Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"vndr_seq",    KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
                             {Type:"Text",     Hidden:0, Width:140, Align:"Left",   ColMerge:1, SaveName:"vndr_nm",     KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0,   InsertEdit:0,   EditLen:200 },
                             {Type:"Text",     Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"agmt_no",     KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
                             {Type:"Text",     Hidden:0, Width:100, Align:"Left",   ColMerge:1, SaveName:"agmt_ref_no", KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0,   InsertEdit:0,   EditLen:200 },
                             {Type:"Text",     Hidden:0, Width:100, Align:"Center", ColMerge:1, SaveName:"ctrt_ofc_cd", KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0,   InsertEdit:0,   EditLen:200 },
                             {Type:"Text",     Hidden:0, Width:140, Align:"Left",   ColMerge:1, SaveName:"inter_rmk",   KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0,   InsertEdit:0,   EditLen:200 } ];

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
function loadPage() {
    for(i=0;i<sheetObjects.length;i++) {
        ComConfigSheet(sheetObjects[i] ); 
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]); 
    }
    
    for(k=0;k<tabObjects.length;k++) {
        initTab(tabObjects[k],k+1);
        tabObjects[k].SetSelectedIndex(0);
    }
    
    sheet1_OnLoadFinish();
}

/*
 * IBSheet using Object tag on the page creates an instance of the Event will occur when complete.
 */
function sheet1_OnLoadFinish() {
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    ComSetObjValue(formObj.cntr_vndr_svc_cd, "RAIL");
    ComSetObjValue(formObj.vndr_cost_cd,     "TR");
    ComSetObjValue(formObj.vndr_cnt_cd,      "US,CA");
    // Rail Company 멀티콤보 정보 조회
    doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
    getRailVendorComboList(rail_road_code , rail_road_codeCode , rail_road_codeText , ''); // Serveic Provider Multi Combo (Rail Load) setting
    initVendorCombo(rail_road_code);       
}

document.onclick=processButtonClick;

/* At the bottom of the business by adding a global variable is used to declare. */
var sheetCnt=0;
var Mincount=0;
/* Button to process certain filename, separated on a quarterly event handler to handle */
function processButtonClick() {
    var sheetObject=sheetObjects[0];
    var sheetObject1=sheetObjects[1];
    var rate_sheetObject=sheetObjects[0]; //Fuel Surcharge
    
    if (currenttab == 0) {
        rate_sheetObject=sheetObjects[0]; //Fuel Surcharge
    } else {
        rate_sheetObject=sheetObjects[1]; //Fixed Surcharge
    }
    /*******************************************************/
    var formObject=document.form;

    try {
       var srcName=ComGetEvent("name");
       switch(srcName) {
            case "btn_retrieve":
                if( tabObjects[0].GetSelectedIndex()== "0" ) {
                    if( validateFormSearch(formObject) ) {
                        doActionIBSheet(rate_sheetObject, formObject, IBSEARCH, "FUEL");                        
                    }                                            
                }else if ( tabObjects[0].GetSelectedIndex()== "1" ) {
                    if( validateFormSearch(formObject) ) {
                        doActionIBSheet(rate_sheetObject, formObject, IBSEARCH, "FIXED");                        
                    }                                            
                }        
            break;
            case "btn_minimize":
                Mincount=(Mincount+1)%2;
                Minimize(Mincount);
            break;
            case "btn_agmtno":
                openAgmtNo();
            break;
            case "btng_history":
                if( validateFormPop(rate_sheetObject) ) {
                    var myWindow=null;    
                    var url=null;
                    var checkList=rate_sheetObject.FindCheckedRow('chk');
                    var checkArray=checkList.split('|');
                    if( tabObjects[0].GetSelectedIndex()== "0" ) {
                        for( var i=0; i<checkArray.length; i++ ) {
                            url='?agmt_no='+rate_sheetObject.GetCellValue(checkArray[i], "agmt_no");
                            url += '&vndr_seq='+rate_sheetObject.GetCellValue(checkArray[i], "vndr_seq");
                            url += '&trsp_rail_scg_cd='+'FSG';
                            url += '&agmt_rout_all_flg='+rate_sheetObject.GetCellValue(checkArray[i], "agmt_rout_all_flg");
                            url += '&fm_nod_cd='+rate_sheetObject.GetCellValue(checkArray[i], "fm_nod_cd")+rate_sheetObject.GetCellValue(checkArray[i], "fm_nod_yard");
                            url += '&to_nod_cd='+rate_sheetObject.GetCellValue(checkArray[i], "to_nod_cd")+rate_sheetObject.GetCellValue(checkArray[i], "to_nod_yard");
                            url += '&cgo_tp_cd='+rate_sheetObject.GetCellValue(checkArray[i], "cgo_tp_cd");
                            url += '&eff_fm_dt='+rate_sheetObject.GetCellValue(checkArray[i], "eff_fm_dt");
                            url += '&eff_to_dt='+rate_sheetObject.GetCellValue(checkArray[i], "eff_to_dt");
                        }
                        myWindow=window.open('ESD_TRS_0234.do'+url, "scgPop", "scroll=no,status=no,help=no,width=900,height=400");
                        myWindow.focus();
                    }else if ( tabObjects[0].GetSelectedIndex()== "1" ) {
                        for( var i=0; i<checkArray.length; i++ ) {
                            url='?agmt_no='+rate_sheetObject.GetCellValue(checkArray[i], "agmt_no");
                            url += '&vndr_seq='+rate_sheetObject.GetCellValue(checkArray[i], "vndr_seq");
                            url += '&trsp_rail_scg_cd='+rate_sheetObject.GetCellValue(checkArray[i], "trsp_rail_scg_cd");
                            url += '&agmt_rout_all_flg='+rate_sheetObject.GetCellValue(checkArray[i], "agmt_rout_all_flg");
                            url += '&fm_nod_cd='+rate_sheetObject.GetCellValue(checkArray[i], "fm_nod_cd")+rate_sheetObject.GetCellValue(checkArray[i], "fm_nod_yard");
                            url += '&to_nod_cd='+rate_sheetObject.GetCellValue(checkArray[i], "to_nod_cd")+rate_sheetObject.GetCellValue(checkArray[i], "to_nod_yard");
                            url += '&cgo_tp_cd='+rate_sheetObject.GetCellValue(checkArray[i], "cgo_tp_cd");
                            url += '&eff_fm_dt='+rate_sheetObject.GetCellValue(checkArray[i], "eff_fm_dt");
                            url += '&eff_to_dt='+rate_sheetObject.GetCellValue(checkArray[i], "eff_to_dt");
                        }
                        myWindow=window.open('ESD_TRS_0234.do'+url, "scgPop", "scroll=no,status=no,help=no,width=900,height=400");
                        myWindow.focus();
                    }                    
                }                                
            break;
            case "btng_rowadd":
                doActionIBSheet(rate_sheetObject,formObject,IBINSERT);
            break;
            case "btng_delete":
                if( tabObjects[0].GetSelectedIndex()== "0" ) {
                    if( validateFormDel(rate_sheetObject, formObject) ) {
                        doActionIBSheet(rate_sheetObject, formObject, IBDELETE, "FUEL");                        
                    }                                                            
                }else if ( tabObjects[0].GetSelectedIndex()== "1" ) {
                    if( validateFormDel(rate_sheetObject, formObject) ) {
                        doActionIBSheet(rate_sheetObject, formObject, IBDELETE, "FIXED");                        
                    }                    
                }
            break;
            case "btng_update":
                if( tabObjects[0].GetSelectedIndex()== "0" ) {
                    if( validateForm(rate_sheetObject, formObject) && checkVerifyResult(rate_sheetObject) ) {
                        doActionIBSheet(rate_sheetObject, formObject, IBSAVE, "FUEL");
                    }                                                        
                }else if ( tabObjects[0].GetSelectedIndex()== "1" ) {
                    if( validateForm(rate_sheetObject, formObject) && checkVerifyResult(rate_sheetObject) ) {
                        doActionIBSheet(rate_sheetObject, formObject, IBSAVE, "FIXED");                        
                    }                    
                }
            break;
            case "btng_loadexcel":
                if( tabObjects[0].GetSelectedIndex()== "0" ) {
                    doActionIBSheet(rate_sheetObject, formObject, IBLOADEXCEL, "FUEL");                                                        
                }else if ( tabObjects[0].GetSelectedIndex()== "1" ) {
                    doActionIBSheet(rate_sheetObject, formObject, IBLOADEXCEL, "FIXED");
                }
            break;
            case "btng_verify":
            	if( validateForm(rate_sheetObject, formObject) ) {
                    if( tabObjects[0].GetSelectedIndex()== "0" ) {
                        valcheck_two1(rate_sheetObject);
                    }else if ( tabObjects[0].GetSelectedIndex()== "1" ) {
                        valcheck_two2(rate_sheetObject);                    
                    }                       
                } 
            break;
            case "btng_reset":
                if( tabObjects[0].GetSelectedIndex()== "0" ) {
                    rate_sheetObject.RemoveAll();
                }else if ( tabObjects[0].GetSelectedIndex()== "1" ) {
                    rate_sheetObject.RemoveAll();
                }
            break;
            case "btng_downexcel":
                if( tabObjects[0].GetSelectedIndex()== "0" ) {
                    doActionIBSheet(rate_sheetObject, formObject, IBDOWNEXCEL, "FUEL");
                }else if ( tabObjects[0].GetSelectedIndex()== "1" ) {
                    doActionIBSheet(rate_sheetObject, formObject, IBDOWNEXCEL, "FIXED");                    
                }
            break;
            case "btns_calendar":
                var cal=new ComCalendar();
                cal.select(formObject.eff_dt, 'yyyy-MM-dd');
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

/*
* handling of Sheet 
*/
function doActionIBSheet(sheetObj,formObj,sAction,srcName) {
    sheetObj.ShowDebugMsg(false);
    var formObject=document.form;
    var x1="";
    switch(sAction) {
        case IBSEARCH:
            switch(srcName) {
                 case "FUEL":
                    formObj.f_cmd.value=SEARCH01;
                    sheetObj.DoSearch("ESD_TRS_0223GS.do", TrsFrmQryString(formObj) );
                break;
                case "FIXED":
                    formObj.f_cmd.value=SEARCH02;
                    sheetObj.DoSearch("ESD_TRS_0223GS.do", TrsFrmQryString(formObj) );
                break;
            }
            break;
        case IBINSERT:
            var row=0;
            row=sheetObj.DataInsert(-1);
            sheetObj.SetCellValue(row,'ck_vf',1,0);
            sheetObj.SetCellValue(row,'agmt_eq_sz_no',"00",0);
            sheetObj.SetCellValue(row, 'chk', 1, 0);
            break;
        case IBDELETE:
            formObj.f_cmd.value = (srcName == "FUEL") ? REMOVE01 : (srcName == "FIXED") ? REMOVE02 : "";
            var checkList=sheetObj.FindCheckedRow('chk');
            var checkArray=checkList.split('|');
            
            for(var k=0; k<checkArray.length; k++) {
                if( sheetObj.GetCellValue(checkArray[k], "ibflag") == "I" ) {
                    sheetObj.RowDelete(checkArray[k], false);
                }
//                else {
//                    sheetObj.DoSave("ESD_TRS_0223GS.do", TrsFrmQryString(formObj), "chk", false, true);
//                }
            }
            break;
        case IBSAVE:
            switch(srcName) {
                case "FUEL":
                    for(var row = sheetObj.HeaderRows(); row < sheetObj.HeaderRows() + sheetObj.RowCount(); row++) {
                    	var resultVal = sheetObj.GetCellValue(row, "rlt");
                    	if(sheetObj.GetCellValue(row, "chk") == "1" && resultVal != "OK" && resultVal != "" && resultVal != null) {
                            ComShowMessage("There are 'Verify Error.'");
                            return;
                        }
                    }

                	formObj.f_cmd.value = MULTI01;
                    sheetObj.DoSave("ESD_TRS_0223GS.do", TrsFrmQryString(formObj), "chk", false, true);
                break;
                case "FIXED":
                    for(var row = sheetObj.HeaderRows(); row < sheetObj.HeaderRows() + sheetObj.RowCount(); row++) {
                    	var resultVal = sheetObj.GetCellValue(row, "rlt");
                    	if(sheetObj.GetCellValue(row, "chk") == "1" && resultVal != "OK" && resultVal != "" && resultVal != null) {
                            ComShowMessage("There are 'Verify Error.'");
                            return;
                        }
                    }

                    formObj.f_cmd.value = MULTI02;
                    sheetObj.DoSave("ESD_TRS_0223GS.do", TrsFrmQryString(formObj), "chk", false, true);
                break;
            }
            break;
        case IBLOADEXCEL:
            CurRowCount = sheetObj.RowCount()+ sheetObj.HeaderRows();
            switch(srcName) {
                case "FUEL":
                    sheetObj.LoadExcel({Append:1});
                break;
                case "FIXED":
                    sheetObj.LoadExcel({Append:1});
                break;
            }
            break;
        case IBDOWNEXCEL:    
            switch(srcName) {
                case "FUEL":
                case "FIXED":
                    if(sheetObj.RowCount() < 1){//no data
                        ComShowCodeMessage("COM132501");
                    }else{
                        sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObj), CheckBoxOnValue:'Y', CheckBoxOffValue:'N', SheetDesign:1, Merge:1 });
                    }
                break;
            }
            break;
        case IBSEARCH_ASYNC01:
            formObj.f_cmd.value=SEARCH;
            var sXml=sheetObj.GetSearchData("ESD_TRS_0999GS.do", FormQueryString(formObj)); 
            rail_road_codeCode=ComGetEtcData(sXml, "rail_vndr_code");
            rail_road_codeText=ComGetEtcData(sXml, "rail_vndr_desc");
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
             var cnt=0 ;
             InsertItem( "Fuel Surcharge" , "");
             InsertItem( "Fixed Surcharge" , "");
         }
         break;
     }
 }
 /**
 * Register as an array IBTab Object
 * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
 * Array defined at the top of the source
 */
 function setTabObject(tab_obj) {
     tabObjects[tabCnt++]=tab_obj;
 }
 /**
 * tab1_OnChange
 */
 function tab1_OnChange(tabObj , nItem) {
     var objs=document.all.item("tabLayer");
     objs[nItem].style.display="Inline";
     objs[beforetab].style.display="none";
     objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
     beforetab=nItem;
     currenttab=nItem;
 }
 /**
  * Sheet expand / collapse
  */
 function Minimize(nItem) {
     var objs=document.all.item("MiniLayer");
     if( nItem == "1" ) {
         objs.style.display="none";
         sheet1.SetSheetHeight(ComGetSheetHeight(sheet1, 17));
         sheet2.SetSheetHeight(ComGetSheetHeight(sheet2, 17));
     } else {
         objs.style.display="inline";
         sheet1.SetSheetHeight(ComGetSheetHeight(sheet1, 15));
         sheet2.SetSheetHeight(ComGetSheetHeight(sheet2, 15));
     }
 }

/**
* Rail Road combo selection event that changes the value of a textfield
**/
function rail_road_code_OnChange(comObj , oldindex, oldtext , oldcode , newindex, newtext , newcode) {
   if ( oldtext == newtext ) {
       return;
   }
   document.form.fm_vndr_nm.value = comObj.GetText(newcode,1);
   sheetObjects[0].RemoveAll();
   sheetObjects[1].RemoveAll();
}

function sheet1_OnSearchEnd(sheetObj, errMsg) {
    eq_OnSearchEnd(sheetObj, errMsg);
}

function sheet2_OnSearchEnd(sheetObj, errMsg) {
    eq_OnSearchEnd(sheetObj, errMsg);
}

/**
 * Views that occur after the EVENT
 */
function sheet3_OnSearchEnd(sheetObj, errMsg) {
    //////////////////////////////////////////////////////
	var formObject = document.form;
    var rate_sheetObject=sheetObjects[0];
    if (currenttab == 0) {
        rate_sheetObject=sheetObjects[0];
    } else if (currenttab == 1) {
        rate_sheetObject=sheetObjects[1];
    }

    var len = sheetObj.RowCount();
    for(var row = 2; row < len+2; row++) {
    	rate_sheetObject.SetCellValue(sheetObj.GetCellValue(row, "row_num")+1, "rlt", sheetObj.GetCellValue(row, "rlt"), 0);
    	rate_sheetObject.SetCellValue(sheetObj.GetCellValue(row, "row_num")+1, "rlt2", sheetObj.GetCellValue(row, "rlt2"), 0);
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

    formObject.trsp_tmp_seq.value = sheetObj.GetCellValue(2, "trsp_tmp_seq");
    ComOpenWait(false);
    //////////////////////////////////////////////////////
}

/**
 * Views that occur after the EVENT
 */
function sheet4_OnSearchEnd(sheetObj, errMsg) {
	var formObject = document.form;
    var rate_sheetObject=sheetObjects[0];
    if (currenttab == 0) {
        rate_sheetObject=sheetObjects[0];
    } else if (currenttab == 1) {
        rate_sheetObject=sheetObjects[1];
    }
    var row = rate_sheetObject.GetSelectRow();
    if(sheetObj.SearchRows() > 0) {
    	getAgmtNo( sheetObj.GetCellValue(1, "agmt_no"), sheetObj.GetCellValue(1, "vndr_seq"), sheetObj.GetCellValue(1, "vndr_nm"), sheetObj.GetCellValue(1, "agmt_ref_no"), row );
    } else {
    	ComShowMessage(ComGetMsg("TRS90066"));
        return false;
    }

    ComOpenWait(false);
}

function eq_OnSearchEnd(sheetObj, errMsg) {
    for(var row = sheetObj.HeaderRows(); row < sheetObj.HeaderRows() + sheetObj.RowCount(); row++) {
        if( tabObjects[0].GetSelectedIndex()== "0" ) {
            for(var i = 12, j = 30; i < 23, j < 40; i++, j++) {
                sheetObj.SetCellValue(row, j, sheetObj.GetCellValue(row, i), 0);
            }
            sheetObj.SetCellValue(row, "ibflag", "R", 0);

            if(sheetObj.GetCellValue(row, "com_scg_aply_flg") == "1") {
                for(var i = 12; i < 23; i++) {
                	if(i==16 || i==19 || i==20 || i==21 || i==22) // CARGO TYPE, EFFECTIVE DATE, DECIMAL, UDU
                		continue;
                    sheetObj.SetCellValue(row, i, "", 0);
                    sheetObj.SetCellEditable(row, i, 0);
                }
                sheetObj.SetCellValue(row, "ibflag", "R", 0);
            }
        } else if( tabObjects[0].GetSelectedIndex()== "1" ) {
            // Code here!!!
        }
    }
}

/**
 * Value change event on Sheet1 column
 */
function sheet1_OnChange(sheetObj, row, col, value) {
    if( sheetObj.ColSaveName(col) != "chk" ) {
        sheetObj.SetCellValue(row,'ck_vf',1,0);
        sheetObj.SetCellValue(row,'rlt',"",0);
        sheetObj.SetCellValue(row,'rlt2',"",0);
    }
    var formObj = document.form;
    var value2 = sheetObj.GetCellValue(row, "ibflag");
    if(sheetObj.ColSaveName(col) != "chk" && value2 =="U") {
    	sheetObj.SetCellValue(row, "chk", 1, 0);
    }
    if( sheetObj.ColSaveName(col) == "com_scg_aply_flg" ) {
        if( value == "1" ) {
            if( value2 == "I" ) {
                for(var i = 12, j = 41; i < 23, j < 51; i++, j++) {
                	if(i==16 || i==19 || i==20 || i==21 || i==22) // CARGO TYPE, EFFECTIVE DATE, DECIMAL, UDU
                		continue;
                    sheetObj.SetCellValue(row, j, sheetObj.GetCellValue(row, i), 0);
                }
            }

            for(var i = 12; i < 23; i++) {
            	if(i==16 || i==19 || i==20 || i==21 || i==22) // CARGO TYPE, EFFECTIVE DATE, DECIMAL, UDU
            		continue;
                sheetObj.SetCellValue(row, i, "", 0);
                sheetObj.SetCellEditable(row, i, 0);
            }
        } else {
            if( value2 == "I" ) {
                for(var i = 12, j = 41; i < 23, j < 51; i++, j++) {
                	if(i==16 || i==19 || i==20 || i==21 || i==22) // CARGO TYPE, EFFECTIVE DATE, DECIMAL, UDU
                		continue;
                    sheetObj.SetCellValue(row, i, sheetObj.GetCellValue(row, j), 0);
                    sheetObj.SetCellEditable(row, i, 1);
                }
            } else {
                for(var i = 12, j = 30; i < 23, j < 41; i++, j++) {
                	if(i==16 || i==19 || i==20 || i==21 || i==22) // CARGO TYPE, EFFECTIVE DATE, DECIMAL, UDU
                		continue;
                    sheetObj.SetCellEditable(row, i, 1);
                    sheetObj.SetCellValue(row, i, sheetObj.GetCellValue(row, j), 0);
                }
            }
        }
    } else if( sheetObj.ColSaveName(col) == "fm_nod_cd" ) {
        var lvfm=doSepRemove(sheetObj.GetCellValue(row,"fm_nod_cd").toUpperCase(), " ");
        sheetObj.SetCellValue(row, "fm_nod_cd",lvfm,0);
        if( lvfm.length == 5 ) {
            getYardSheetCombo1(sheetObj, document.form, row, col, "fm_nod_yard", lvfm); //Varidation check
            if( sheetObj.GetCellValue(row, "fm_nod_cd") != "" ) {
                getYardSheetCombo(sheetObj, document.form, row, "fm_nod_yard", lvfm);
            } else {
                sheetObj.SetCellValue(row, "fm_nod_yard","",0);
            }
        } else {
            if( lvfm.length == 0 ) {
                sheetObj.SetCellValue(row, "fm_nod_yard","",0);
            } else {
                errMsg=ComGetMsg("TRS90122");
                ComShowMessage(errMsg);
                sheetObj.SetCellValue(row,"fm_nod_cd","",0);
                sheetObj.SelectCell(row,"fm_nod_cd");
                sheetObj.SetCellValue(row, "fm_nod_yard","",0);
            }
        }
    } else if( sheetObj.ColSaveName(col) == "to_nod_cd" ) {
    	var lvto=doSepRemove(sheetObj.GetCellValue(row,"to_nod_cd").toUpperCase(), " ");
    	sheetObj.SetCellValue(row,"to_nod_cd",lvto);
        if( lvto.length == 5 ) {
            getYardSheetCombo1(sheetObj, document.form, row, col, "to_nod_yard", lvto); //Validation check
            if( sheetObj.GetCellValue(row, "to_nod_cd") != "" ) {
            	getYardSheetCombo(sheetObj, document.form, row, "to_nod_yard", lvto);
            } else {
            	sheetObj.SetCellValue(row, "to_nod_yard","",0);
            }              
        }else{
            if( lvto.length == 0 ) {
            	sheetObj.SetCellValue(row, "to_nod_yard","",0);
            } else {
            	errMsg=ComGetMsg("TRS90122");
            	ComShowMessage(errMsg);
            	sheetObj.SetCellValue(row,"to_nod_cd","",0);
            	sheetObj.SelectCell(row,"to_nod_cd");
            	sheetObj.SetCellValue(row, "to_nod_yard","",0);
            }
        }
    } else if(sheetObj.ColSaveName(col) == "agmt_no"){
    	var agmtno = sheetObj.GetCellValue(row, "agmt_no");
        if( agmtno == "") {
            return false;
        } else if ( agmtno.length < 4 ) {
            ComShowMessage(ComGetMsg("TRS90066"));
            return false;
        } else if (! ComIsMoneyNumber( agmtno.substring(3) , false, true, true) ) {
            ComShowMessage(ComGetMsg("TRS90066"));
            return false;
        }
        
        formObj.f_cmd.value=SEARCH01;
        sheetObjects[3].RemoveAll();
        var sXml = sheetObjects[3].GetSearchData("ESD_TRS_0233GS.do", TrsFrmQryString(formObj) + "&agmt_no=" + agmtno);
        if(ComGetEtcData(sXml, "TRANS_RESULT_KEY")=="F"){
        	ComShowMessage(ComGetMsg("TRS90066"));
            return false;
        }else{
        	sheetObjects[3].LoadSearchData(sXml);
        }
    }
}

/**
 * Value change event on Sheet2 column
 */
function sheet2_OnChange(sheetObj, row , col , value) {
    var formObj = document.form;
	if( sheetObj.ColSaveName(col) != "chk" ){
		sheetObj.SetCellValue(row,'ck_vf',1,0);
		sheetObj.SetCellValue(row,'rlt',"",0);
		sheetObj.SetCellValue(row,'rlt2',"",0);
	}
    var value2 = sheetObj.GetCellValue(row, "ibflag");
    if(sheetObj.ColSaveName(col) != "chk" && value2 =="U") {
    	sheetObj.SetCellValue(row, "chk", 1, 0);
    }

    if( sheetObj.ColSaveName(col) == "fx_scg_all_rt" ){
        if( sheetObj.GetCellValue(row, "fx_scg_all_rt") != "" ) {
            sheetObj.SetCellValue(row, "fx_scg_20ft_rt","");
            sheetObj.SetCellValue(row, "fx_scg_40ft_rt","");
            sheetObj.SetCellValue(row, "fx_scg_45ft_rt","");
            if( sheetObj.GetCellValue(row, "trsp_rail_scg_cd") == "OWS" ){
                sheetObj.SetCellValue(row,'agmt_eq_sz_no',"AL");
            }              
        }
    } else if( sheetObj.ColSaveName(col) == "fx_scg_20ft_rt" ||
                sheetObj.ColSaveName(col) == "fx_scg_40ft_rt" ||
                sheetObj.ColSaveName(col) == "fx_scg_45ft_rt" ) {
        if( sheetObj.GetCellValue(row, "fx_scg_all_rt") != "" ) {
            sheetObj.SetCellValue(row, "fx_scg_20ft_rt","");
            sheetObj.SetCellValue(row, "fx_scg_40ft_rt","");
            sheetObj.SetCellValue(row, "fx_scg_45ft_rt","");
        }    
        if( sheetObj.GetCellValue(row, "trsp_rail_scg_cd") == "OWS" ) {
            if( sheetObj.GetCellValue(row, "fx_scg_20ft_rt") != "" ) {
                  sheetObj.SetCellValue(row,'agmt_eq_sz_no',"20");
            }else if( sheetObj.GetCellValue(row, "fx_scg_40ft_rt") != "" ) {
                  sheetObj.SetCellValue(row,'agmt_eq_sz_no',"40");
            }else if( sheetObj.GetCellValue(row, "fx_scg_45ft_rt") != "" ) {
                  sheetObj.SetCellValue(row,'agmt_eq_sz_no',"45");
              }              
        }          
    } else if( sheetObj.ColSaveName(col) == "fm_nod_cd" ) {
        var lvfm=doSepRemove(sheetObj.GetCellValue(row,"fm_nod_cd").toUpperCase(), " ");
        if( lvfm.length == 5 ) {
            getYardSheetCombo1(sheetObj, document.form, row, col, "fm_nod_yard", lvfm); //Varidation check
            if( sheetObj.GetCellValue(row, "fm_nod_cd") != "" ) {
              getYardSheetCombo(sheetObj, document.form, row, "fm_nod_yard", lvfm);
          } else {
              sheetObj.SetCellValue(row, "fm_nod_yard","",0);
          }              
        } else {
            if( lvfm.length == 0 ) {
              sheetObj.SetCellValue(row, "fm_nod_yard","",0);
          } else {
              errMsg=ComGetMsg("TRS90122");
              ComShowMessage(errMsg);
              sheetObj.SetCellValue(row,"fm_nod_cd","",0);
              sheetObj.SelectCell(row,"fm_nod_cd");
              sheetObj.SetCellValue(row, "fm_nod_yard","",0);
          }              
        }
    } else if( sheetObj.ColSaveName(col) == "to_nod_cd" ) {
        var lvto=doSepRemove(sheetObj.GetCellValue(row,"to_nod_cd").toUpperCase(), " ");
        if( lvto.length == 5 ) {
            getYardSheetCombo1(sheetObj, document.form, row, col, "to_nod_yard", lvto); //Varidation check
            if( sheetObj.GetCellValue(row, "to_nod_cd") != "" ) {
            	getYardSheetCombo(sheetObj, document.form, row, "to_nod_yard", lvto);
            } else {
            	sheetObj.SetCellValue(row, "to_nod_yard","",0);
            }              
        }else{
            if( lvto.length == 0 ) {
            	sheetObj.SetCellValue(row, "to_nod_yard","",0);
            } else {
            	errMsg=ComGetMsg("TRS90122");
            	ComShowMessage(errMsg);
            	sheetObj.SetCellValue(row,"to_nod_cd","",0);
            	sheetObj.SelectCell(row,"to_nod_cd");
            	sheetObj.SetCellValue(row, "to_nod_yard","",0);
            }              
        }
    } else if( sheetObj.ColSaveName(col) == "trsp_rail_scg_cd" ){
        if( sheetObj.GetCellValue(row, "trsp_rail_scg_cd") == "HZS" || sheetObj.GetCellValue(row, "trsp_rail_scg_cd") == "TTL") {
            sheetObj.SetCellEditable(row, "lbs_ovr_wgt",0);
        }else if( sheetObj.GetCellValue(row, "trsp_rail_scg_cd") == "OWS" ){
            sheetObj.SetCellEditable(row, "lbs_ovr_wgt",1);
        }
    } else if(sheetObj.ColSaveName(col) == "agmt_no"){
    	var agmtno = sheetObj.GetCellValue(row, "agmt_no");
        if( agmtno == "") {
            return false;
        } else if ( agmtno.length < 4 ) {
            ComShowMessage(ComGetMsg("TRS90066"));
            return false;
        } else if (! ComIsMoneyNumber( agmtno.substring(3) , false, true, true) ) {
            ComShowMessage(ComGetMsg("TRS90066"));
            return false;
        }
        
        formObj.f_cmd.value=SEARCH01;
        sheetObjects[3].RemoveAll();
        var sXml = sheetObjects[3].GetSearchData("ESD_TRS_0233GS.do", TrsFrmQryString(formObj) + "&agmt_no=" + agmtno);
        if(ComGetEtcData(sXml, "TRANS_RESULT_KEY")=="F"){
        	ComShowMessage(ComGetMsg("TRS90066"));
            return false;
        }else{
        	sheetObjects[3].LoadSearchData(sXml);
        }
    }
}

/**
 * Popup event in Sheet1
 */
function sheet1_OnPopupClick (sheetObj , row , col ) {
    var colName=sheetObj.ColSaveName(col);
    switch(colName) {
        case('agmt_no'):
            popAgmtNo(sheetObj, row, col);
    }
}

/**
 * Fuel Surcharge Tab Excel Load Complete event
 * 
 */
function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
    if(isExceedMaxRow(msg))return;
    var sheetObj=sheetObjects[0];
    if(code==1) {
//    	for(var k=sheetObj.HeaderRows(); k<sheetObj.RowCount()+sheetObj.HeaderRows(); k++) {
//    		sheetObj.SetCellValue(k, 'ck_vf', 1, 0);
//            sheetObj.SetCellValue(k, 'agmt_eq_sz_no', "00", 0);
//            sheetObj.SetCellValue(k, 'chk', 1, 0);
//        }
    	var hdrRows = sheetObj.HeaderRows();
    	var rowCount = sheetObj.RowCount()+sheetObj.HeaderRows();
        for(var k = hdrRows; k < rowCount; k++) {
            if (k >= CurRowCount) {
	    		sheetObj.SetCellValue(k, 'ck_vf', 1, 0);
	            sheetObj.SetCellValue(k, 'agmt_eq_sz_no', "00", 0);
	            sheetObj.SetCellValue(k, 'chk', 1, 0);
            }
        }
    }
}

/**
 * Fixed Surcharge Tab Excel Load Complete event
 * 
 */
function sheet2_OnLoadExcel(sheetObj, result, code, msg) {
    if(isExceedMaxRow(msg))return;
    var sheetObj=sheetObjects[1];
    if(code==1) {
//          for(var k=sheetObj.HeaderRows(); k<sheetObj.RowCount()+sheetObj.HeaderRows(); k++) {
//              sheetObj.SetCellValue(k, 'ck_vf', 1, 0);
//              if( sheetObj.GetCellValue(k, 'trsp_rail_scg_cd') == "OWS" ) {
//                  if( sheetObj.GetCellValue(k, 'fx_scg_all_rt') != "" ) {
//                      sheetObj.SetCellValue(k, 'agmt_eq_sz_no', "AL");
//                  } else if( sheetObj.GetCellValue(k, 'fx_scg_20ft_rt') != "" ) {
//                      sheetObj.SetCellValue(k, 'agmt_eq_sz_no', "20");
//                  } else if( sheetObj.GetCellValue(k, 'fx_scg_40ft_rt') != "" ) {
//                      sheetObj.SetCellValue(k, 'agmt_eq_sz_no', "40");
//                  } else if( sheetObj.GetCellValue(k, 'fx_scg_45ft_rt') != "" ) {
//                      sheetObj.SetCellValue(k, 'agmt_eq_sz_no', "45");
//                  }
//              } else {
//                  sheetObj.SetCellValue(k,'agmt_eq_sz_no',"00");
//              }
//          }
    	var hdrRows = sheetObj.HeaderRows();
    	var rowCount = sheetObj.RowCount()+sheetObj.HeaderRows();
        for(var k = hdrRows; k < rowCount; k++) {
            if (k >= CurRowCount) {
	            sheetObj.SetCellValue(k, 'ck_vf', 1, 0);
	            sheetObj.SetCellValue(k, 'chk', 1, 0);
	            
	            if( sheetObj.GetCellValue(k, 'trsp_rail_scg_cd') == "OWS" ) {
	                if( sheetObj.GetCellValue(k, 'fx_scg_all_rt') != "" ) {
	                    sheetObj.SetCellValue(k, 'agmt_eq_sz_no', "AL", 0);
	                } else if( sheetObj.GetCellValue(k, 'fx_scg_20ft_rt') != "" ) {
	                    sheetObj.SetCellValue(k, 'agmt_eq_sz_no', "20", 0);
	                } else if( sheetObj.GetCellValue(k, 'fx_scg_40ft_rt') != "" ) {
	                    sheetObj.SetCellValue(k, 'agmt_eq_sz_no', "40", 0);
	                } else if( sheetObj.GetCellValue(k, 'fx_scg_45ft_rt') != "" ) {
	                    sheetObj.SetCellValue(k, 'agmt_eq_sz_no', "45", 0);
	                }
	            } else {
	                sheetObj.SetCellValue(k, 'agmt_eq_sz_no', "00", 0);
	            }
            }
        }
    }

}

/**
 * Popup event on Sheet2
 */
function sheet2_OnPopupClick (sheetObj , row , col) {
    var colName=sheetObj.ColSaveName(col);
    switch(colName) {
        case('agmt_no'):
            popAgmtNo(sheetObj, row, col);
    }
}

/**
 * Delete event in Sheet1
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {
    ComOpenWait(false);
	if( errMsg.length > 0 ) {
        ComShowMessage(errMsg);
    } else {
        if( document.form.f_cmd.value == REMOVE01 ) {
            errMsg=ComGetMsg("TRS90331");
            ComShowMessage(errMsg);
            eq_delete(sheetObj, "chk");
        }else if( document.form.f_cmd.value == MULTI01 ) {
            errMsg=ComGetMsg("COM12116", "Update");
            ComShowMessage(errMsg);
        }
    }
}

/**
 * Save event on Sheet2
 */
function sheet2_OnSaveEnd(sheetObj, errMsg) {
    ComOpenWait(false);
    if( errMsg.length > 0 ) {
        ComShowMessage(errMsg);
    } else {
        if( document.form.f_cmd.value == REMOVE02 ) {
            errMsg=ComGetMsg("TRS90331");
            ComShowMessage(errMsg);
            eq_delete(sheetObj, "chk");
        }else if( document.form.f_cmd.value == MULTI02 ) {
            errMsg=ComGetMsg("COM12116", "Update");
            ComShowMessage(errMsg);
        }
    }
}

/*
 * Delete a data check on the grid.
 */
function eq_delete(fromSheet, sStatus) {
    var fromRow=0;
    var sRow=fromSheet.FindCheckedRow(sStatus);
    var arrRow=sRow.split("|");
    //In reverse order from the source to move the rows of a particular state.
    for (ir=arrRow.length-1; ir >=0 ; ir--) {
        fromRow=arrRow[ir];
        //Clear from the source
        fromSheet.RowDelete(fromRow, false);
    }
}

/**
 * The date format when viewed with mandatory validation process handling
 */
function validateFormSearch(formObj) {
      var lvDate=ComTrimAll(ComTrimAll(formObj.eff_dt.value, " "), "-");
      var lvRailCode=ComTrimAll(rail_road_code.GetSelectText(), " ");
      if( lvDate == "" )
          formObj.eff_dt.value="";
      if( lvDate != "" ) { //Check the date the part
          if( !ComIsDate(lvDate) ) {
              errMsg=ComGetMsg("TRS90070");
              ComShowMessage(errMsg);
              formObj.eff_dt.focus();
              return false;
          }
      }
      if( lvRailCode == "" ) {
          errMsg=ComGetMsg("TRS90124");
          ComShowMessage(errMsg);
          return false;
      }
      formObj.hid_eff_dt.value=lvDate; //from Date
      return true;
  }

/**
 * CHECK that when you save the validation process is handled
 */
function validateFormDel(sheetObj, formObj) {
	if( sheetObj.CheckedRows("chk") < 1 ) {
        errMsg=ComGetMsg("TRS90036");
        ComShowMessage(errMsg);
        return false;
    }
    var checkList=sheetObj.FindCheckedRow('chk');
    var checkArray=checkList.split('|');
    for (ir=checkArray.length-2; ir >=0 ; ir--) {
    	if( sheetObj.GetCellValue(checkArray[ir], "locl_cre_dt") == "" ) {
    		sheetObj.RowDelete(checkArray[ir], false);
        }
    }
    if( sheetObj.CheckedRows("chk") < 1 ) {
    	return false;
    }
    return true;
}

/**
 * CHECK that when you save the validation process is handled
 */
function validateForm(sheetObj, formObj) {
  var errorMsg="";
  var checkList = sheetObj.FindCheckedRow('chk');
  var checkListArr = checkList.split('|');
  for(var idx = 0; idx < checkListArr.length; idx++) {
      if( sheetObj.GetCellValue(checkListArr[idx], "vndr_seq") == "" ||
          sheetObj.GetCellValue(checkListArr[idx], "vndr_nm") == "" ||
          sheetObj.GetCellValue(checkListArr[idx], "agmt_no") == "" ||
//         (sheetObj.GetCellValue(checkListArr[idx], 'com_scg_aply_flg') != '1' && sheetObj.GetCellValue(checkListArr[idx], "cgo_tp_cd") == "") ||
         sheetObj.GetCellValue(checkListArr[idx], "cgo_tp_cd") == "" ||
          sheetObj.GetCellValue(checkListArr[idx], "eff_fm_dt") == "" ||
          sheetObj.GetCellValue(checkListArr[idx], "eff_to_dt") == ""
//          ( ( sheetObj.GetCellValue(checkListArr[idx], "fm_nod_cd") == "" || sheetObj.GetCellValue(checkListArr[idx], "to_nod_cd") == "") &&
//              sheetObj.GetCellValue(checkListArr[idx], "agmt_rout_all_flg") == ""
//          ) 
          ) {
          if( sheetObj.GetCellValue(checkListArr[idx], "vndr_seq") == "" ) {
              errorMsg += "Rail Company Code, ";
          }
          if( sheetObj.GetCellValue(checkListArr[idx], "vndr_nm") == "" ) {
              errorMsg += "Rail Company Name, ";
          }
          if( sheetObj.GetCellValue(checkListArr[idx], "agmt_no") == "" ) {
              errorMsg += "Agreement No, ";
          }
          if( sheetObj.GetCellValue(checkListArr[idx], "trsp_rail_scg_cd") == "" ) {
              errorMsg += "Surcharge Kind, ";
          }
//          if(sheetObj.GetCellValue(checkListArr[idx], 'com_scg_aply_flg') != '1' && sheetObj.GetCellValue(checkListArr[idx], "cgo_tp_cd") == "") {
       	  if(sheetObj.GetCellValue(checkListArr[idx], "cgo_tp_cd") == "") {
              errorMsg += "Cargo Type, ";
          }
          if( sheetObj.GetCellValue(checkListArr[idx], "eff_fm_dt") == "" || sheetObj.GetCellValue(checkListArr[idx], "eff_to_dt") == "" ) {
              errorMsg += "Effective Date, ";
          }
//          if( ( sheetObj.GetCellValue(checkListArr[idx], "fm_nod_cd") == "" ||
//                  sheetObj.GetCellValue(checkListArr[idx], "to_nod_cd") == "") &&
//                  sheetObj.GetCellValue(checkListArr[idx], "agmt_rout_all_flg") == "" ) {
//                      errorMsg += ", Route";
//          }
          errMsg=ComGetMsg("COM130403", errorMsg.substring(0, errorMsg.length-2));
          ComShowMessage(errMsg);
          return false;
      }
      
      if(sheetObj.GetCellValue(checkListArr[idx], "cgo_tp_cd") == "M" && sheetObj.GetCellValue(checkListArr[idx], "spcl_cgo_cntr_tp_cd").length > 0) {
           ComShowCodeMessage("TRS90421");
           sheetObj.SelectCell(checkListArr[idx], "spcl_cgo_cntr_tp_cd");
           return false;
      }
  }
  return true;
}

/**
 * CHECK that when you save the validation process is handled
 */
function checkVerifyResult(sheetObj) {
  for( var i=2; i<sheetObj.RowCount()+2; i++ ) {
          if( sheetObj.GetCellValue(i, "chk") == "1" && 
              sheetObj.GetCellValue(i,'rlt') == "OK" ){
          } else if (sheetObj.GetCellValue(i, "chk") == "1" && 
                  sheetObj.GetCellValue(i,'rlt') != "OK") {
              ComShowCodeMessage('TRS90039');
              return false;
          }
  }
  return true;
}

/**
 *Agreement No popup views
 **/
function popAgmtNo(sheetObj, row, col) {
  var param="?main_row="+row;
  ComOpenPopup('/opuscntr/ESD_TRS_0233.do' + param, 700, 450, "popupAgmtHdrList", "0,0", true);
}

/**
 * History Popup CHECK sure that there is at work processing the validation process
 */
function validateFormPop(sheetObj) {
    if( sheetObj.CheckedRows("chk") < 1 ) {
        errMsg=ComGetMsg("TRS90036");
        ComShowMessage(errMsg);
        return false;
    }
    if( sheetObj.CheckedRows("chk") > 1 ) {
        errMsg=ComGetMsg("COM12177");
        ComShowMessage(errMsg);
        return false;
    }
    return true;
}

function getAgmtNo( value, value1, value2, value3, row ) {
    if( row == "" ) {
        var formObject=document.form;
        formObject.fm_agmtno.value=value;
    } else {
        if( tabObjects[0].GetSelectedIndex()== "0" ) {
            sheetObjects[0].SetCellValue(row, 'agmt_no',value, 0);
            sheetObjects[0].SetCellValue(row, 'vndr_seq',value1, 0);
            sheetObjects[0].SetCellValue(row, 'vndr_nm',value2, 0);
            sheetObjects[0].SetCellValue(row, 'agmt_ref_no',value3, 0);
        } else if ( tabObjects[0].GetSelectedIndex()== "1" ) {
            sheetObjects[1].SetCellValue(row, 'agmt_no',value, 0);
            sheetObjects[1].SetCellValue(row, 'vndr_seq',value1, 0);
            sheetObjects[1].SetCellValue(row, 'vndr_nm',value2, 0);
            sheetObjects[1].SetCellValue(row, 'agmt_ref_no',value3, 0);
        }
    }
}

var checkArrayOnVerify = "";

/**
 * Check Fuel Verify
 */
function valcheck_two1(sheetObj) {
    var formObject=document.form;
        ComOpenWait(true);
        formObject.f_cmd.value=SEARCH03;
        //Upon completion ck_vf verify the value of '1 '-> '0' is changed to.
        var check_row=sheetObj.CheckedRows('chk');
        if(check_row == '') {
            ComOpenWait(false);
            ComShowCodeMessage('TRS90036');
            return;
        }

        var dupRow=sheetObj.ColValueDup("vndr_seq|agmt_no|fm_nod_cd|fm_nod_yard|to_nod_cd|to_nod_yard|" +
        		                        "cgo_tp_cd|eff_fm_dt|eff_to_dt|usr_def_rmk");
        if(dupRow != -1) {
            ComShowCodeMessage("TRS90412", "row " + (dupRow-1));
            sheetObj.SetSelectRow(dupRow);
            sheetObj.SetCellValue(dupRow, 'rlt', 'Duplication', 0);
            sheetObj.SetCellValue(dupRow, 'rlt2', 'DUP', 0);
            ComOpenWait(false);
            return;
        }
        var dupKey = "vndr_seq|agmt_no|fm_nod_cd|fm_nod_yard|to_nod_cd|to_nod_yard|" +
                     "cgo_tp_cd|usr_def_rmk";
        var effectiveDateCheck = checkEffectiveDate(sheetObj, dupKey);
        if(!effectiveDateCheck) {
            ComOpenWait(false);
            ComShowCodeMessage("TRS90412", "Effective Date");
            return;
        }

        // 1. Unchecking Checked Check Box
        // Common : Check   ===> Unchecking O
        // Common : Uncheck ===> Unchecking X
        var checkList = sheetObj.FindCheckedRow('chk');
        checkArrayOnVerify = checkList.split('|');
        for(var idx = 0; idx < checkArrayOnVerify.length; idx++) {
            if(sheetObj.GetCellValue(checkArrayOnVerify[idx], 'com_scg_aply_flg') == '1') {
                sheetObj.SetCellValue(checkArrayOnVerify[idx], 'ck_vf', '0', 0);
            } else {
                sheetObj.SetCellValue(checkArrayOnVerify[idx], 'ck_vf', '1', 0);
            }

            // 2015.05.07 if all node values are empty then agmt_rout_all_flg is Y or N
            if( sheetObj.GetCellValue(checkArrayOnVerify[idx], "fm_nod_cd") != ""
            	|| sheetObj.GetCellValue(checkArrayOnVerify[idx], "to_nod_cd") != "" ) {
            	sheetObj.SetCellValue(checkArrayOnVerify[idx], "agmt_rout_all_flg", "N", 0);
            } else {
            	sheetObj.SetCellValue(checkArrayOnVerify[idx], "agmt_rout_all_flg", "Y", 0);
            }
        }
        var queryStr = sheetObj.GetSaveString(0, 1, 'chk');
        sheetObjects[2].RemoveAll();
        sheetObjects[2].DoSearch("ESD_TRS_0223GS.do", TrsFrmQryString(formObject)+'&'+queryStr, {Sync:1});
}

/**
 * Check Fix Verify
 */
function valcheck_two2(sheetObj) {
    var formObject=document.form;
        ComOpenWait(true);
        formObject.f_cmd.value=SEARCH04;
        //Upon completion ck_vf verify the value of '1 '-> '0' is changed to.
        var check_row=sheetObj.FindCheckedRow('chk');
        if(check_row == '') {
            ComOpenWait(false);
            ComShowCodeMessage('TRS90036');
            return;
        }
        
        var dupRow=sheetObj.ColValueDup("vndr_seq|agmt_no|trsp_rail_scg_cd|fm_nod_cd|fm_nod_yard|to_nod_cd|to_nod_yard|" +
        		"cgo_tp_cd|spcl_cgo_cntr_tp_cd|lbs_ovr_wgt|curr_cd|fx_scg_all_rt|fx_scg_20ft_rt|fx_scg_40ft_rt|fx_scg_45ft_rt|eff_fm_dt|eff_to_dt|usr_def_rmk");
        if(dupRow != -1) {
            ComShowCodeMessage("TRS90412", "row " + (dupRow-1));
            sheetObj.SetSelectRow(dupRow);
            sheetObj.SetCellValue(dupRow, 'rlt', 'Duplication', 0);
            sheetObj.SetCellValue(dupRow, 'rlt2', 'DUP', 0);
            ComOpenWait(false);
            return;
        }
        
        var dupKey = "vndr_seq|agmt_no|trsp_rail_scg_cd|fm_nod_cd|fm_nod_yard|to_nod_cd|to_nod_yard|" +
                "cgo_tp_cd|spcl_cgo_cntr_tp_cd|lbs_ovr_wgt|curr_cd|usr_def_rmk|fx_scg_all_rt_yn|fx_scg_20ft_rt_yn|fx_scg_40ft_rt_yn|fx_scg_45ft_rt_yn";

        var checkArray=check_row.split('|');
        for(var k=0; k<checkArray.length; k++) {
            sheetObj.SetCellValue(checkArray[k], 'fx_scg_all_rt_yn',  Number(sheetObj.GetCellValue(checkArray[k], "fx_scg_all_rt"))  > 0 ? "Y" : "N" + sheetObj.GetCellValue(checkArray[k], "trsp_agmt_scg_seq"), 0);
            sheetObj.SetCellValue(checkArray[k], 'fx_scg_20ft_rt_yn', Number(sheetObj.GetCellValue(checkArray[k], "fx_scg_20ft_rt")) > 0 ? "Y" : "N" + sheetObj.GetCellValue(checkArray[k], "trsp_agmt_scg_seq"), 0);
            sheetObj.SetCellValue(checkArray[k], 'fx_scg_40ft_rt_yn', Number(sheetObj.GetCellValue(checkArray[k], "fx_scg_40ft_rt")) > 0 ? "Y" : "N" + sheetObj.GetCellValue(checkArray[k], "trsp_agmt_scg_seq"), 0);
            sheetObj.SetCellValue(checkArray[k], 'fx_scg_45ft_rt_yn', Number(sheetObj.GetCellValue(checkArray[k], "fx_scg_45ft_rt")) > 0 ? "Y" : "N" + sheetObj.GetCellValue(checkArray[k], "trsp_agmt_scg_seq"), 0);
        }

        var dupKey1 = "vndr_seq|agmt_no|trsp_rail_scg_cd|fm_nod_cd|fm_nod_yard|to_nod_cd|to_nod_yard|cgo_tp_cd|spcl_cgo_cntr_tp_cd|lbs_ovr_wgt|curr_cd|usr_def_rmk|fx_scg_all_rt_yn";
        var dupKey2 = "vndr_seq|agmt_no|trsp_rail_scg_cd|fm_nod_cd|fm_nod_yard|to_nod_cd|to_nod_yard|cgo_tp_cd|spcl_cgo_cntr_tp_cd|lbs_ovr_wgt|curr_cd|usr_def_rmk|fx_scg_20ft_rt_yn";
        var dupKey3 = "vndr_seq|agmt_no|trsp_rail_scg_cd|fm_nod_cd|fm_nod_yard|to_nod_cd|to_nod_yard|cgo_tp_cd|spcl_cgo_cntr_tp_cd|lbs_ovr_wgt|curr_cd|usr_def_rmk|fx_scg_40ft_rt_yn";
        var dupKey4 = "vndr_seq|agmt_no|trsp_rail_scg_cd|fm_nod_cd|fm_nod_yard|to_nod_cd|to_nod_yard|cgo_tp_cd|spcl_cgo_cntr_tp_cd|lbs_ovr_wgt|curr_cd|usr_def_rmk|fx_scg_45ft_rt_yn";
        
        var effectiveDateCheck = checkEffectiveDate(sheetObj, dupKey1);
        effectiveDateCheck = (effectiveDateCheck == true) ? checkEffectiveDate(sheetObj, dupKey2) : false;
        effectiveDateCheck = (effectiveDateCheck == true) ? checkEffectiveDate(sheetObj, dupKey3) : false;
        effectiveDateCheck = (effectiveDateCheck == true) ? checkEffectiveDate(sheetObj, dupKey4) : false;
        if(!effectiveDateCheck) {
            ComOpenWait(false);
            ComShowCodeMessage("TRS90412", "Effective Date");
            return;
        }

        var checkList = sheetObj.FindCheckedRow('chk');
        checkArrayOnVerify = checkList.split('|');

        for(var idx=0; idx<checkArrayOnVerify.length; idx++) {
            // 2015.05.07 if all node values are empty then agmt_rout_all_flg is Y or N
            if( sheetObj.GetCellValue(checkArrayOnVerify[idx], "fm_nod_cd") != ""
            	|| sheetObj.GetCellValue(checkArrayOnVerify[idx], "to_nod_cd") != "" ) {
            	sheetObj.SetCellValue(checkArrayOnVerify[idx], "agmt_rout_all_flg", "N", 0);
            } else {
            	sheetObj.SetCellValue(checkArrayOnVerify[idx], "agmt_rout_all_flg", "Y", 0);
            }
        }

        var queryStr = sheetObj.GetSaveString(0, 1, 'chk');
        sheetObjects[2].RemoveAll();
        sheetObjects[2].DoSearch("ESD_TRS_0223GS.do", TrsFrmQryString(formObject)+'&'+queryStr, {Sync:1});
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
			for(var dup = 0; dup < dupKeyArray.length; dup++) {
				colValueJoin2 += sheetObj.GetCellValue(dupRowsArray2[idx], dupKeyArray[dup]);
			}
        	// 기준행으로 중복된 행이 비교대상이됨
			for(var idx2 = 0; idx2 < checkLen3; idx2++) {
				// 기준행으로 중복된 행의 중복검사 컬럼들 값을 합침
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
                        }
                        if(sheetObj.GetRowEditable(dupRowsArray3[idx2])){
        					sheetObj.SetCellValue(dupRowsArray3[idx2], 'rlt', 'Effective Date Duplicate.', 0);
                        }
                        break;
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

function openAgmtNo() {
    var formObject=document.form;
    var Option="width=700,height=420,menubar=0,status=0,scrollbars=0,resizable=0";
    var agmt_no=formObject.fm_agmtno.value;
    var param="?agmt_no="+agmt_no;
    ComOpenPopup('/opuscntr/ESD_TRS_0233.do' + param, 700, 450, "popupAgmtHdrList", "0,0", true);
}

/**
 * Tool Tip
 * @param sheetObj
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 */
function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	if(mouseRow < 2) return;
	var formObj = document.form;
	var mouseRow = sheetObj.MouseRow();
	var mouseCol = sheetObj.MouseCol();
	var colSaveName = sheetObj.ColSaveName(mouseCol);
	switch(colSaveName) {
		case "fm_nod_yard" :
		case "to_nod_yard" :  
			setYdNameToolTip(sheetObj, mouseRow, mouseCol, formObj);
			break;
		case "fm_nod_cd" :
		case "to_nod_cd" :	
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
function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	if(mouseRow < 2) return;
	var formObj = document.form;
	var mouseRow = sheetObj.MouseRow();
	var mouseCol = sheetObj.MouseCol();
	var colSaveName = sheetObj.ColSaveName(mouseCol);
	switch(colSaveName) {
		case "fm_nod_yard" :
		case "to_nod_yard" :  
			setYdNameToolTip(sheetObj, mouseRow, mouseCol, formObj);
			break;
		case "fm_nod_cd" :
		case "to_nod_cd" :	
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