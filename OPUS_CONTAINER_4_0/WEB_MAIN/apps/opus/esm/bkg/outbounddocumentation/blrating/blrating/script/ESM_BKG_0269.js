/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0269.js
*@FileTitle  : Freight & Charge_S/C Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @fileoverview business script for
* @author CLT
 */
/**
 * @extends 
 * @class esm_bkg_0269 : esm_bkg_0269 
 */
/* developer's work*/
// global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var prefix="sheet3_"; //IBSheet divider 
// Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	if (document.form.bkg_no.value == '') {
		ComShowCodeMessage("BKG00463");// there is no BKG no for searching
		ComClosePopup(); 
	}
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//sheetObjects[i].WaitImageVisible = false;
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
* initControl : initializing sheet  
*/
function initControl() {
	//** Date divider **/
	DATE_SEPARATOR="-";
	var formObject=document.form;
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObject); //- out of focus
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', formObject); //- focus in
	//axon_event.addListener('keydown', 'check_Enter', 'form');
	//axon_event.addListener('keydown', 'easteregg', 'form'); //- keyboard
	//setting date
	var rCntr_cdr_dt=formObject.application_date.value.substr(0,4)+'-'+formObject.application_date.value.substr(4,2)+'-'+formObject.application_date.value.substr(6,2) ;		
	ComSetObjValue(formObject.frm_cntr_cdr_dt, rCntr_cdr_dt);	
	//invisible waiting box on first sheet
	sheetObjects[0].SetWaitImageVisible(0);
	var formObj=document.form;
	//axon_event.addListener('keydown', 'easteregg', 'form'); //- keyboard
}
var ee_arr=[82,76,65,88,79,82,85,68];
var ee_idx=0;
/* Hidden easteregg */
function easteregg() {
	if (ee_arr[ee_idx++]==event.keyCode) {
		if (ee_arr.length==ee_idx) {
			ee_idx=0;
			for (var ee=0; ee<sheetObjects.length; ee++) {
				sheetObjects[ee].Down2Excel({ HiddenColumn:0});
			}
		}
	} else {
		ee_idx=0;
	}
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet0":
	    with(sheetObj){
			var HeadTitle1="TP/SZ|CGO|QTY|EQ SUB|QTY";
			var headCount=5;
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cgo",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"qty",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:12 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eq_sub",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"eq_sub_qty",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:12 } ];
   
			InitColumns(cols);
			SetSheetHeight(210);
			SetEditable(1);
			SetCountPosition(0);
        }
		break;	
	case "sheet1":
	    with(sheetObj){
			var HeadTitle1="";
			var headCount=25;
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_no" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_cdr_dt1" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_cgo_tp_cd" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bdr_cng_flg" },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd" },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cmdt_nm" },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rep_cmdt_cd" },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rep_cmdt_nm" },
						 {Type:"Float",     Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"act_wgt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Float",     Hidden:0,  Width:0,    Align:"Right",   ColMerge:0,   SaveName:"meas_qty",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"meas_ut_cd" },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_por_cd" },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_pol_cd" },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_pod_cd" },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"del_cd" },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"vv_pol_cd" },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"vv_pod_cd" },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rcv_term_cd" },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"de_term_cd" },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"special" },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"frt_term_cd" },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"sc_no" },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_vvd" } ];
       
			InitColumns(cols);
			SetVisible(0);
			SetEditable(1);
        }
		break;
	case "sheet2":
	    with(sheetObj){
			var HeadTitle1="";
			var headCount=17;
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"s_cust_cnt_cd" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"s_cust_seq" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"s_cust_nm" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"c_cust_cnt_cd" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"c_cust_seq" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"c_cust_nm" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"n_cust_cnt_cd" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"n_cust_seq" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"n_cust_nm" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"a_cust_cnt_cd" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"a_cust_seq" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"a_cust_nm" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"p_cust_cnt_cd" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"p_cust_seq" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"p_cust_nm" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"p_ctrt_pty_nm" } ];
       
			InitColumns(cols);
			SetVisible(0);
			SetEditable(1);
        }
		break;
	case "sheet3":
	    with(sheetObj){
			var HeadTitle1=" |PT|Commodity Description|POR|POL|POD|DEL|D.Call|R/D|Per|CGO\nTP|Cur|Amount|Trans Mode\n(O/D)|Q’TY|Rate\nDetail |Route\nNote |CMDT\nNote|Special\nNote|ARB\nNote|O.IHC WGT\n(Ton<=)|O.IHC WGT\n(<Ton)|O.ARB WGT\n(Ton<=)|O.ARB WGT\n(<Ton)|D.ARB WGT\n(Ton<=)|D.ARB WGT\n(<Ton)|D.IHC WGT\n(Ton<=)|D.IHC WGT\n(<Ton)|multi_curr|";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"_flg",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rt_mtch_patt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_nm",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dir_call_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rcv_de_term_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"fnl_frt_rt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trns_mod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Float",     Hidden:0,  Width:45,   Align:"Right",   ColMerge:1,   SaveName:"op_cntr_qty",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dtl",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"note",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnote",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },	//2015.11.26. cnote_ctnt, snote_ctnt, arb_note_ctnt 추가 
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"snote",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"arb_note",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"oi_min_cgo_wgt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"oi_max_cgo_wgt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"oa_min_cgo_wgt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"oa_max_cgo_wgt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"da_min_cgo_wgt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"da_max_cgo_wgt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"di_min_cgo_wgt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"di_max_cgo_wgt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"multi_curr",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"nt" },
             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rcv_term_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"de_term_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_bse_port_def_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_via_port_def_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_dir_call_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_rat_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_prc_cgo_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_prc_trsp_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_rcv_de_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_prc_cmdt_def_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_fnl_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_bse_port_def_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_via_port_def_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_dir_call_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rat_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_prc_cgo_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_prc_trsp_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rcv_de_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_prc_cmdt_def_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_fnl_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_bse_port_def_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_via_port_def_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_dir_call_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rat_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_prc_cgo_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_prc_trsp_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rcv_de_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_prc_cmdt_def_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_fnl_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_bse_port_def_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_via_port_def_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_dir_call_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_rat_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_prc_cgo_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_prc_trsp_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_rcv_de_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_prc_cmdt_def_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_fnl_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"usr_id",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ctrt_cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dry_cgo_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"awk_cgo_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dcgo_flg",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rc_flg",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bb_cgo_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"soc_flg",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"prop_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"prc_gen_spcl_rt_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"prc_cmdt_hdr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"prc_rout_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"prc_rt_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"note_ctnt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cnote_ctnt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },	//2015.11.26. cnote_ctnt, snote_ctnt, arb_note_ctnt 추가
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"snote_ctnt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"arb_note_ctnt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rat_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_fnl_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rap_bkg_conv_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rap_note_conv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rap_note_conv_rule_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rap_note_conv_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rap_rt_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rap_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rap_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rar_bkg_conv_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rar_note_conv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rar_note_conv_rule_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rar_note_conv_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rar_rt_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rar_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rar_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_dor_bkg_conv_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_dor_note_conv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_dor_note_conv_rule_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_dor_note_conv_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_dor_rt_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_dor_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_dor_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_typ_bkg_conv_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_typ_note_conv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_typ_note_conv_rule_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_typ_note_conv_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_typ_rt_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_typ_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_typ_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_app_bkg_conv_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_app_note_conv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_app_note_conv_rule_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_app_note_conv_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_app_rt_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_app_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_app_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_ras_bkg_conv_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_ras_note_conv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_ras_note_conv_rule_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_ras_note_conv_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_ras_rt_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_ras_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_ras_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_arb_bkg_conv_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_arb_note_conv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_arb_note_conv_rule_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_arb_note_conv_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_arb_rt_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_arb_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_arb_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_add_bkg_conv_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_add_note_conv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_add_note_conv_rule_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_add_note_conv_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_add_rt_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_add_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_add_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rap_bkg_conv_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rap_note_conv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rap_note_conv_rule_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rap_note_conv_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rap_rt_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rap_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rap_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rar_bkg_conv_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rar_note_conv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rar_note_conv_rule_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rar_note_conv_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rar_rt_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rar_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rar_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_dor_bkg_conv_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_dor_note_conv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_dor_note_conv_rule_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_dor_note_conv_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_dor_rt_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_dor_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_dor_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_typ_bkg_conv_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_typ_note_conv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_typ_note_conv_rule_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_typ_note_conv_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_typ_rt_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_typ_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_typ_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rap_bkg_conv_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rap_note_conv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rap_note_conv_rule_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rap_note_conv_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rap_da_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rap_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rap_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rar_bkg_conv_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rar_note_conv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rar_note_conv_rule_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rar_note_conv_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rar_da_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rar_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rar_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_dor_bkg_conv_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_dor_note_conv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_dor_note_conv_rule_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_dor_note_conv_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_dor_da_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_dor_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_dor_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_typ_bkg_conv_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_typ_note_conv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_typ_note_conv_rule_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_typ_note_conv_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_typ_da_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_typ_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_typ_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rac_bkg_conv_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rac_note_conv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rac_note_conv_rule_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rac_note_conv_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rac_rt_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rac_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rac_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rac_bkg_conv_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rac_note_conv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rac_note_conv_rule_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rac_note_conv_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rac_rt_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rac_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rac_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rac_bkg_conv_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rac_note_conv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rac_note_conv_rule_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rac_note_conv_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rac_da_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rac_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rac_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"op_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ov_rout_via_port_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dv_rout_via_port_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dp_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"por_mtch_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"del_mtch_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rap_conv_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rar_conv_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_dor_conv_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_typ_conv_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rac_conv_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_ras_conv_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_typ_conv_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rac_conv_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_typ_conv_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rac_conv_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_prc_cgo_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dp_seq",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_calc_frt_rt_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_calc_frt_rt_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_calc_frt_rt_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_calc_frt_rt_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_calc_frt_rt_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cgo_cate_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_subst_cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_fm",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },		//2015.11.26. oi_fm,oa_fm,da_fm, di_fm
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_fm",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_fm",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_fm",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_frt_term_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_frt_term_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_frt_term_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_frt_term_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
             {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" } 
             ];
       
			InitColumns(cols);
			SetSheetHeight(162);
			SetEditable(1);
			SetCountPosition(0);
            /* ori ihc */
	      /* ori arb */
	      /* dest arb */
	      /* dest ihc */
	      /* Surcharge Save column */
	      /* note conversion detail  */
	      /* for DTL information */
	      /* POL, DEL Match logic */
	      /* CONVSERION DATA */
		}
		break;
	case "sheet4": /* SurCharge */ 
		with (sheetObj) { 
	    	  var HeadTitle1=" Charge |PCT BSE |Cur |Rate |Rate as |Per |Amount |IN |Term |Cargo |rcv Term |DeTerm |IMO | ";
	    	  var headCount=17;
	    	  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	    	  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    	  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	    	  InitHeaders(headers, info);

	    	  var cols = [ {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"chg_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pct_bse_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Float",     Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"chg_ut_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"rat_as_qty",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Float",     Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"chg_amt",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"frt_incl_xcld_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"frt_term_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"rcv_term_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"de_term_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"soc_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"prc_hngr_bar_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"in_ga_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"tax_flg",             	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },		//tax_flg
	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"tax_cnt_cd",           	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	             {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
	          
	    	  InitColumns(cols);
	    	  SetVisible(0);
	    	  SetEditable(1);
	    }
		break;
	case "sheet5": /* Break Down */ 
		with(sheetObj){
			var HeadTitle1=" Charge |Cur |Rate |Rate as |Per |Amount |IN |Term |Cargo |rcv Term |DeTerm |IMO |M | Hide ";
			var headCount=33;
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"chg_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"chg_ut_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"rat_as_qty",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Float",     Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"chg_amt",                KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"incl_oft_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"frt_term_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"rcv_term_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"de_term_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"m",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"hide",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"dry_cgo_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"awk_cgo_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"rc_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bb_cgo_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"soc_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"prc_gen_spcl_rt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"prc_cmdt_hdr_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"prc_rout_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"op_cntr_qty",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"prc_rt_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"fnl_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"eq_subst_cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"por_mtch_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"del_mtch_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
      
			InitColumns(cols);
			SetVisible(0);
			SetEditable(1);
              /* POL, DEL Match logic */
		}
		break;	
	}
}
//Event handler processing by button name */
function processButtonClick() {
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject0=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	var sheetObject2=sheetObjects[2];
	var sheetObject3=sheetObjects[3];
	var sheetObject4=sheetObjects[4];
	var sheetObject5=sheetObjects[5];
	/*******************************************************/
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject3, formObj, SEARCH01);
			break;
		case "btn_Select":
			//ComOpenWait(true); // waiting box is visible 
			/* 
			 * Select button click logic  
			 * 1. function of Multi Rate 
			 * 2. QTY Validation
			 * 3. function of Break Down  
			 * 4. in case PER TYPE is PC  at surcharge,  adding logic 
			 * 5. calculating Surcharge 
			 * 6. Data setting in screen 'Charge' 
			 */
			//1. Multi Rate function
			//1. checking validation   checking the number of TP/SZ TYPE 
			var rArray=new Array();
			var formObj=document.form;
			var sheetObj0=sheetObjects[0];
			var sheetObj1=sheetObjects[1];
			var sheetObj3=sheetObjects[3];
			var sheetObj4=sheetObjects[4];
			var sheetObj5=sheetObjects[5];
			/* adding Multi rate  */
			var cnt0_row=sheetObj0.GetTotalRows();
			var cnt3_row=sheetObj3.GetTotalRows();
			var flg_cnt=0 ;
			for ( var z=1; z <= cnt3_row; z++){
				if(sheetObj3.GetCellValue(z,"_flg") == 1){
					flg_cnt++;
				}
			}
			if(flg_cnt == 0){
				ComShowCodeMessage("BKG00249");////BKG00249  :  "No Selected Row";
				return;
			}
			// comparing standard sheet and sheet which should be compared
			var tmpPertpsz='';  
			var tmpCgo='';  
			var tmpPersub='';
			var tmpQty1A=0;
			var comPer='';
			var comQty=0;
			var cflag=false;
			var t_Tpsz_cd='';  
			var t_Qty1A=0;
			// standard sheet
			 for ( var i=1; i <= cnt0_row; i++){
				tmpPertpsz=sheetObj0.GetCellValue(i,"cntr_tpsz_cd");
				tmpCgo=sheetObj0.GetCellValue(i,"cgo");
				tmpPersub=sheetObj0.GetCellValue(i,"eq_sub");
				tmpQty1A=sheetObj0.GetCellValue(i,"qty");
				// target sheet 
				for ( var ix=1; ix <= cnt3_row; ix++){	
					comPer=sheetObj3.GetCellValue(ix,"cntr_tpsz_cd");
					if(comPer == '20') comPer='D2';
					if(comPer == '40') comPer='D4';
					// checked target
					if(sheetObj3.GetCellValue(ix,"_flg") == 1){
						//alert(tmpPertpsz +"::::"+ comPer+";;;"+sheetObj3.CellValue(ix,"prc_cgo_tp_cd")+";;"+tmpCgo);
						//in case per_tpsz and sub_per are same  
						if ((tmpPertpsz == comPer)
							//&&(tmpCgo == sheetObj3.CellValue(ix,"prc_cgo_tp_cd")) 
							) {
							comQty=comQty + parseFloat(sheetObj3.GetCellValue(ix,"op_cntr_qty"));
							cflag=true;
						}
					}
				}
				t_Tpsz_cd='';
				t_Qty1A=0;
				for ( var z=1; z <= cnt0_row; z++){
					t_Tpsz_cd=sheetObj0.GetCellValue(z,"cntr_tpsz_cd");
					if(t_Tpsz_cd == tmpPertpsz){
						t_Qty1A=t_Qty1A + parseFloat(sheetObj0.GetCellValue(z,"qty"));
					}
				}
				//alert(t_Qty1A+"::"+tmpQty1A+"::"+comQty);
				if(cflag){
					cflag=false; 
					// in case it is different to compare with total
					if(t_Qty1A != comQty){
						//  in case the Qty of sheet is bigger than one of the previous sheet
						if(tmpQty1A < comQty){ 
							ComShowMessage("Dose not match with BKG quantity!"); 
							return;
						}
					//  in case the Qty of previous sheet is bigger than one of comparing sheet
					}else if(tmpQty1A > comQty ){//  in case the Qty of sheet0 is bigger than one of comparing sheet
						if(!ComShowConfirm("Dose not match with BKG quantity! do you want to continue ?")){
							return;
						}
					// in case of same,  Multi rate 
					}else{
						var tPer='';
						var tCgo='';
						var tpor='';
						var tpol='';
						var tpod='';
						var tdel='';
						for ( var ix=1; ix <= cnt3_row; ix++){				
							// in checked ones
							if(sheetObj3.GetCellValue(ix,"_flg") == 1){
								if(tPer == sheetObj3.GetCellValue(ix,"rat_ut_cd")
										&& tCgo == sheetObj3.GetCellValue(ix,"cgo_tp_cd")){
									tpor=sheetObj3.GetCellValue(ix,"bkg_por_cd");
									tpol=sheetObj3.GetCellValue(ix,"bkg_pol_cd");
									tpod=sheetObj3.GetCellValue(ix,"bkg_pod_cd");
									tdel=sheetObj3.GetCellValue(ix,"del_cd");
									if(tpor  != sheetObj3.GetCellValue(ix,"bkg_por_cd")|| tpol  != sheetObj3.GetCellValue(ix,"bkg_pol_cd")|| tpod  != sheetObj3.GetCellValue(ix,"bkg_pod_cd")|| tdel  != sheetObj3.GetCellValue(ix,"del_cd")){
										if (!ComShowConfirm("Do you want to select 'MULTI-RATE' ?")){
											return;	
										}else{
											break;
										}
									}
								}
								tPer=sheetObj3.GetCellValue(ix,"rat_ut_cd");
								tCgo=sheetObj3.GetCellValue(ix,"cgo_tp_cd");
							}
						}
					}
				}
				tmpQty1A=0;
				comQty=0;
			}
			 
			 //mixed currency check
			 if(formObj.frm_t10sheet1_brk_dwn_flg.value != "Y"){	//break down unticked
				 
				 for ( var ix=1; ix <= cnt3_row; ix++){	
					 if (sheetObj3.GetCellValue(ix,"_flg") == 1 && sheetObj3.GetCellValue(ix,"multi_curr") == "Y"){
//						 ComShowMessage("You cannot select rate including mixed currencies because 'Break Down' is unticked. Please tick that check box.");
						 ComShowCodeMessage("BKG08335");
						 return;
					 }
				 }
			 }
			 
			 
			/**
			 * ESM_BKG_0079_08 
			 * in case Per Type is selected less, the Per Type which is not selected : showing like that; Rate = .00, Rate As = TP/SZ QTY , Amount = .00  
			 * in case Per Type is selected , adding row as the number of selected Per Type and showing the amount differently
			 *  
			 */
			 var pArray=new Array();
			 var tpsz_cd1='';
			 var tpsz_cd2='';
			 var tpsz_qty1=0;
			 var tpsz_qty2=0;
			 var x=0;
			 for ( var i=1; i <= cnt0_row; i++){
				 tpsz_cd1=sheetObj0.GetCellValue(i,"cntr_tpsz_cd");
			 	for ( var ix=1; ix <= cnt3_row; ix ++){
			 		if(sheetObj3.GetCellValue(ix,"_flg") == 1){
			 			tpsz_cd2=sheetObj3.GetCellValue(ix,"rat_ut_cd");
			 				if( tpsz_cd1 == tpsz_cd2 ){
			 					tpsz_qty2=tpsz_qty2 + parseInt(sheetObj3.GetCellValue(ix,"op_cntr_qty"));
			 				}
			 		}
			 	}
			 	tpsz_qty1=sheetObj0.GetCellValue(i,"qty");
			 	if(tpsz_qty1 > tpsz_qty2){
			 		var cnt=tpsz_qty1 - tpsz_qty2 ;
			 		var obj=new Object();// setting value 
			 		obj.tpsz_cd=tpsz_cd1;
			 		obj.tpsz_qty=cnt;
			 		pArray[x++]=obj;
			 	}
			 }
			 	/* 3. Break Down  
			 	 * in case Break Down Indicator is checked in Charge screen;
			 	 *  dividing each CHG Code which is displayed OFT   (splitting Charge information, OA, OI, TH, DA, DI) 
			 	 *  forwarding the split value to charge screen
			 	 * inserting surcharge insert query to each Row, to reference from PC Logic 
			 	 *  
			 	 * */
			 	sheetObj5.RemoveAll();// initializing
				/* 6.  Data setting in Charge( script of function 3 and function 6 is mixed)
				 *    adding function of Break Down to OFT setting Logic in Charge
				 */ 
				var idx=0;
				for ( var ix=1; ix <= cnt3_row; ix++) {
					if (sheetObj3.GetCellValue(ix,"_flg") == 1){
						var newRow=sheetObj5.DataInsert(-1); // adding the last line of row in IBSheet
						var obj=new Object(); // setting  
							obj.charge='OFT';
							obj.cur=sheetObj3.GetCellValue(ix, "curr_cd");
						// when it Breaks Down , splitting Amount 
						if(formObj.frm_t10sheet1_brk_dwn_flg.value == "Y"){
							obj.rate=sheetObj3.GetCellValue(ix, "rt_calc_frt_rt_amt");
						}else{ //if it is not Break Down, setting tot Amount 
							obj.rate=sheetObj3.GetCellValue(ix, "fnl_frt_rt_amt");
						}
						obj.rate_as=sheetObj3.GetCellValue(ix, "op_cntr_qty");
						obj.per=sheetObj3.GetCellValue(ix, "rat_ut_cd");
						obj.cargo=sheetObj3.GetCellValue(ix, "cgo_cate_cd");
						obj.term=sheetObj3.GetCellValue(ix, "rcv_term_cd") +"/"+ sheetObj3.GetCellValue(ix,"de_term_cd");
//							obj.term_cd = sheetObj1.CellValue(1,  "term_cd");
						obj.term_cd=formObj.term_cd.value;
						obj.imo=sheetObj3.GetCellValue(ix, "imdg_clss_cd");
							/* forwarding the value from OFT to see the Note in Charge*/
						obj.prcPttCd=sheetObj3.GetCellValue(ix,"rt_mtch_patt_cd").substr(1,4);
						obj.propNo=sheetObj3.GetCellValue(ix, "prop_no");
						obj.amdtSeq=sheetObj3.GetCellValue(ix, "amdt_seq");
						obj.svcScpCd=sheetObj3.GetCellValue(ix, "svc_scp_cd");
						obj.genSpclTp=sheetObj3.GetCellValue(ix, "prc_gen_spcl_rt_tp_cd");
						obj.cmdtHdrSeq=sheetObj3.GetCellValue(ix, "prc_cmdt_hdr_seq");
						obj.routSeq=sheetObj3.GetCellValue(ix, "prc_rout_seq");
						obj.noteRtSeq=sheetObj3.GetCellValue(ix, "prc_rt_seq");
						obj.incl='N';
						obj.m='A';
							/* 2010.03.31 forwarding into TP/SZ Charge (because there is per type  (20,40,BL)  */
						obj.rat_ut2_cd=sheetObj3.GetCellValue(ix, "cntr_tpsz_cd");
						obj.rat_ut3_cd=sheetObj3.GetCellValue(ix, "eq_subst_cntr_tpsz_cd");
						rArray[idx++]=obj;
							// setting data which is broken down at sheet 5 to use in the Surcharge
						sheetObj5.SetCellValue(newRow, "chg_cd"		       ,'OFT');
						sheetObj5.SetCellValue(newRow, "curr_cd"	           ,sheetObj3.GetCellValue(ix, "curr_cd"	        ));
						if(formObj.frm_t10sheet1_brk_dwn_flg.value == "Y"){
							sheetObj5.SetCellValue(newRow, "chg_ut_amt"	   ,sheetObj3.GetCellValue(ix, "rt_calc_frt_rt_amt"	));
							}else{
								sheetObj5.SetCellValue(newRow, "chg_ut_amt"	   ,sheetObj3.GetCellValue(ix, "fnl_frt_rt_amt"	    ));
							}
							sheetObj5.SetCellValue(newRow, "rat_as_qty"	       ,sheetObj3.GetCellValue(ix, "op_cntr_qty"	        ));
							sheetObj5.SetCellValue(newRow, "rat_ut_cd"	           ,sheetObj3.GetCellValue(ix, "rat_ut_cd"	        ));
							if(formObj.frm_t10sheet1_brk_dwn_flg.value == "Y"){
								sheetObj5.SetCellValue(newRow, "chg_amt"	       ,sheetObj3.GetCellValue(ix, "rt_fnl_frt_rt_amt") * sheetObj3.GetCellValue(ix, "op_cntr_qty"));
							}else{
								sheetObj5.SetCellValue(newRow, "chg_amt"	       ,sheetObj3.GetCellValue(ix, "fnl_frt_rt_amt") * sheetObj3.GetCellValue(ix, "op_cntr_qty"));
							}
							sheetObj5.SetCellValue(newRow, "incl_oft_flg"	       ,'N');
							sheetObj5.SetCellValue(newRow, "frt_term_cd"	       ,sheetObj1.GetCellValue(1, "frt_term_cd"	    ));
							sheetObj5.SetCellValue(newRow, "cgo_tp_cd"	           ,sheetObj3.GetCellValue(ix, "cgo_cate_cd"	        ));
							sheetObj5.SetCellValue(newRow, "rcv_term_cd"	       ,sheetObj3.GetCellValue(ix, "rcv_term_cd"	    ));
							sheetObj5.SetCellValue(newRow, "de_term_cd"	       ,sheetObj3.GetCellValue(ix, "de_term_cd"	        ));
							sheetObj5.SetCellValue(newRow, "imdg_clss_cd"	       ,sheetObj3.GetCellValue(ix, "imdg_clss_cd"	    ));
							sheetObj5.SetCellValue(newRow, "m"		               ,'A');
							sheetObj5.SetCellValue(newRow, "hide"	  	   	       ,' ');
							sheetObj5.SetCellValue(newRow, "bkg_no" 	           ,sheetObj3.GetCellValue(ix, "bkg_no" 	        ));
							sheetObj5.SetCellValue(newRow, "cntr_tpsz_cd" 	       ,sheetObj3.GetCellValue(ix, "cntr_tpsz_cd" 	    ));
							sheetObj5.SetCellValue(newRow, "ctrt_cntr_tpsz_cd"	   ,sheetObj3.GetCellValue(ix, "ctrt_cntr_tpsz_cd"	));
							sheetObj5.SetCellValue(newRow, "dry_cgo_flg"          ,sheetObj3.GetCellValue(ix, "dry_cgo_flg"        ));
							sheetObj5.SetCellValue(newRow, "awk_cgo_flg"          ,sheetObj3.GetCellValue(ix, "awk_cgo_flg"        ));
							sheetObj5.SetCellValue(newRow, "dcgo_flg"	           ,sheetObj3.GetCellValue(ix, "dcgo_flg"	        ));
							sheetObj5.SetCellValue(newRow, "rc_flg" 	           ,sheetObj3.GetCellValue(ix, "rc_flg" 	        ));
							sheetObj5.SetCellValue(newRow, "bb_cgo_flg"	   	   ,sheetObj3.GetCellValue(ix, "bb_cgo_flg"	        ));
							sheetObj5.SetCellValue(newRow, "soc_flg"	           ,sheetObj3.GetCellValue(ix, "soc_flg"	        ));
							sheetObj5.SetCellValue(newRow, "prc_gen_spcl_rt_tp_cd",sheetObj3.GetCellValue(ix, "prc_gen_spcl_rt_tp_cd"  ));
							sheetObj5.SetCellValue(newRow, "prc_cmdt_hdr_seq"     ,sheetObj3.GetCellValue(ix, "prc_cmdt_hdr_seq"       ));
							sheetObj5.SetCellValue(newRow, "prc_rout_seq"         ,sheetObj3.GetCellValue(ix, "prc_rout_seq"           ));
							sheetObj5.SetCellValue(newRow, "op_cntr_qty"          ,sheetObj3.GetCellValue(ix, "op_cntr_qty"            ));
							sheetObj5.SetCellValue(newRow, "prc_rt_seq"           ,sheetObj3.GetCellValue(ix, "prc_rt_seq"             ));
							sheetObj5.SetCellValue(newRow, "fnl_frt_rt_amt"       ,sheetObj3.GetCellValue(ix, "fnl_frt_rt_amt"         ));
							/* POL, DEL Match Logic */
							sheetObj5.SetCellValue(newRow, "por_mtch_flg"		   ,sheetObj3.GetCellValue(ix, "por_mtch_flg"         ));
							sheetObj5.SetCellValue(newRow, "del_mtch_flg"		   ,sheetObj3.GetCellValue(ix, "del_mtch_flg"         ));
							sheetObj5.SetCellValue(newRow, "eq_subst_cntr_tpsz_cd"		   ,sheetObj3.GetCellValue(ix, "eq_subst_cntr_tpsz_cd"         ));
							sheetObj5.SetCellValue(newRow, "ibflag"               ,"U");
							var comp1_cd=sheetObj3.GetCellValue(ix,"rat_ut_cd");
//						for ( var p = 0; p < pArray.length; p++) {
//							var comp2_cd =  pArray[p].tpsz_cd;
//							var newRow = sheetObj5.DataInsert(-1); 
//							if(comp1_cd == comp2_cd){
//								var obj		= new Object();// setting
//								obj.charge	= 'OFT';
//								obj.cur		= sheetObj3.CellValue(ix, "curr_cd");
//								obj.rate	= 0.00;
//								obj.rate_as	= pArray[p].tpsz_qty;
//								obj.per		= sheetObj3.CellValue(ix, "rat_ut_cd");
//								obj.cargo	= sheetObj3.CellValue(ix, "cgo_cate_cd");
//								obj.term	= sheetObj3.CellValue(ix,"rcv_term_cd") +"/"+ sheetObj3.CellValue(ix,"de_term_cd");
//								obj.imo		= sheetObj3.CellValue(ix, "imdg_clss_cd");
//								obj.m		= 'A';
//								
//								/* forwarding the value from OFT to see the Note in Charge */
//								obj.prcPttCd	= sheetObj3.CellValue(ix,"rt_mtch_patt_cd").substr(1,4);
//								obj.propNo		= sheetObj3.CellValue(ix, "prop_no");
//								obj.amdtSeq		= sheetObj3.CellValue(ix, "amdt_seq");
//								obj.svcScpCd	= sheetObj3.CellValue(ix, "svc_scp_cd");
//								obj.genSpclTp	= sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd");
//								obj.cmdtHdrSeq	= sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq");
//								obj.routSeq		= sheetObj3.CellValue(ix, "prc_rout_seq");
//								obj.noteRtSeq	= sheetObj3.CellValue(ix, "prc_rt_seq");
//								
//								
//								//setting data which is broken down at sheet 5 to use in the Surcharge 
//								sheetObj5.CellValue(newRow, "chg_cd"		       ) = 'OFT'; ///////
//								sheetObj5.CellValue(newRow, "curr_cd"	           ) = sheetObj3.CellValue(ix, "curr_cd"	        );
//								sheetObj5.CellValue(newRow, "chg_ut_amt"	   	   ) = 0.00;   
//								
//								sheetObj5.CellValue(newRow, "rat_as_qty"	       ) = sheetObj3.CellValue(ix, "op_cntr_qty"	        );     
//								sheetObj5.CellValue(newRow, "rat_ut_cd"	           ) = sheetObj3.CellValue(ix, "rat_ut_cd"	        );     
//								sheetObj5.CellValue(newRow, "chg_amt"	           ) =  0 ;       
//     
//								sheetObj5.CellValue(newRow, "frt_term_cd"	       ) = sheetObj1.CellValue(1, "frt_term_cd"	    );     
//								sheetObj5.CellValue(newRow, "cgo_tp_cd"	           ) = sheetObj3.CellValue(ix, "cgo_cate_cd"	        );     
//								sheetObj5.CellValue(newRow, "rcv_term_cd"	       ) = sheetObj3.CellValue(ix, "rcv_term_cd"	    );     
//								sheetObj5.CellValue(newRow, "de_term_cd"	       ) = sheetObj3.CellValue(ix, "de_term_cd"	        );     
//								sheetObj5.CellValue(newRow, "imdg_clss_cd"	       ) = sheetObj3.CellValue(ix, "imdg_clss_cd"	    );     
//     
//								sheetObj5.CellValue(newRow, "bkg_no" 	           ) = sheetObj3.CellValue(ix, "bkg_no" 	        );     
//								sheetObj5.CellValue(newRow, "cntr_tpsz_cd" 	       ) = sheetObj3.CellValue(ix, "cntr_tpsz_cd" 	    );     
//								sheetObj5.CellValue(newRow, "ctrt_cntr_tpsz_cd"	   ) = sheetObj3.CellValue(ix, "ctrt_cntr_tpsz_cd"	);     
//								sheetObj5.CellValue(newRow, "dry_cgo_flg"          ) = sheetObj3.CellValue(ix, "dry_cgo_flg"        );    
//								sheetObj5.CellValue(newRow, "awk_cgo_flg"          ) = sheetObj3.CellValue(ix, "awk_cgo_flg"        );    
//								sheetObj5.CellValue(newRow, "dcgo_flg"	           ) = sheetObj3.CellValue(ix, "dcgo_flg"	        );     
//								sheetObj5.CellValue(newRow, "rc_flg" 	           ) = sheetObj3.CellValue(ix, "rc_flg" 	        );     
//								sheetObj5.CellValue(newRow, "bb_cgo_flg"	   	   ) = sheetObj3.CellValue(ix, "bb_cgo_flg"	        );     
//								sheetObj5.CellValue(newRow, "soc_flg"	           ) = sheetObj3.CellValue(ix, "soc_flg"	        );     
//								sheetObj5.CellValue(newRow, "prc_gen_spcl_rt_tp_cd") = sheetObj3.CellValue(ix, "prc_gen_spcl_rt_tp_cd"  );    
//								sheetObj5.CellValue(newRow, "prc_cmdt_hdr_seq"     ) = sheetObj3.CellValue(ix, "prc_cmdt_hdr_seq"       );    
//								sheetObj5.CellValue(newRow, "prc_rout_seq"         ) = sheetObj3.CellValue(ix, "prc_rout_seq"           );    
//								sheetObj5.CellValue(newRow, "op_cntr_qty"          ) = sheetObj3.CellValue(ix, "op_cntr_qty"            );    
//								sheetObj5.CellValue(newRow, "prc_rt_seq"           ) = sheetObj3.CellValue(ix, "prc_rt_seq"             );
//								sheetObj5.CellValue(newRow, "fnl_frt_rt_amt"       ) = sheetObj3.CellValue(ix, "fnl_frt_rt_amt"         );
//								sheetObj5.CellValue(newRow, "ibflag"               ) = "U";   	
//								
//								rArray[idx++] = obj;
//							}
//						}
					}
				}
			/* 3. Break Down function
			 * dividing the CHG Code each PT Code
			 * applying divided CHG_CD in case of Breaking down 
			 * skip in case it is not Breaking down
			 * */
			if(formObj.frm_t10sheet1_brk_dwn_flg.value == "Y"){
				//applying divided CHG_CD in case of Breaking down
			 	for ( var ix=1; ix<= cnt3_row; ix++){
			 		if(sheetObj3.GetCellValue(ix,"_flg") == 1){
			 			var pt_cd=sheetObj3.GetCellValue(ix,"rt_mtch_patt_cd").substr(1,4); // PT TYPE
						if(pt_cd.substr(1,1) == 1){
							if(sheetObj3.GetCellValue(ix,"oa_fnl_frt_rt_amt") !='0'){ //  don't display in case cost is 0 when it is broken down
								var newRow=sheetObj5.DataInsert(-1); // adding the last line of row in IBSheet
				 				var obj=new Object();// setting  
				 				obj.charge='OAR';
								obj.cur=sheetObj3.GetCellValue(ix, "oa_curr_cd");
								obj.rate=sheetObj3.GetCellValue(ix, "oa_calc_frt_rt_amt");
								obj.rate_as=sheetObj3.GetCellValue(ix, "op_cntr_qty");
								obj.per=sheetObj3.GetCellValue(ix, "rat_ut_cd");
								obj.cargo=sheetObj3.GetCellValue(ix, "cgo_cate_cd");
								obj.term=sheetObj3.GetCellValue(ix, "rcv_term_cd") + "/"+ sheetObj3.GetCellValue(ix, "de_term_cd");
								//			 				obj.term_cd = sheetObj1.CellValue(1,  "frt_term_cd");
				 				obj.term_cd=sheetObj3.GetCellValue(ix, "oa_frt_term_cd");//formObj.term_cd.value;
			 					obj.imo=sheetObj3.GetCellValue(ix, "imdg_clss_cd");
				 				obj.incl='N';
				 				obj.m='A';
								/* forwarding the value from OFT to see the Note in Charge */
								obj.prcPttCd=sheetObj3.GetCellValue(ix,"rt_mtch_patt_cd").substr(1,4);
								obj.propNo=sheetObj3.GetCellValue(ix, "prop_no");
								obj.amdtSeq=sheetObj3.GetCellValue(ix, "amdt_seq");
								obj.svcScpCd=sheetObj3.GetCellValue(ix, "svc_scp_cd");
								obj.genSpclTp=sheetObj3.GetCellValue(ix, "prc_gen_spcl_rt_tp_cd");
								obj.cmdtHdrSeq=sheetObj3.GetCellValue(ix, "prc_cmdt_hdr_seq");
								obj.routSeq=sheetObj3.GetCellValue(ix, "prc_rout_seq");
								obj.noteRtSeq=sheetObj3.GetCellValue(ix, "prc_rt_seq");
				 				rArray[idx++]=obj;
				 				//setting data which is broken down at sheet 5 to use in the Surcharge 
				 				sheetObj5.SetCellValue(newRow, "chg_cd"		       ,'OAR');
								sheetObj5.SetCellValue(newRow, "curr_cd"	       ,sheetObj3.GetCellValue(ix, "oa_curr_cd"	        ));
								sheetObj5.SetCellValue(newRow, "chg_ut_amt"	       ,sheetObj3.GetCellValue(ix, "oa_fnl_frt_rt_amt"	));
								sheetObj5.SetCellValue(newRow, "rat_as_qty"	       ,sheetObj3.GetCellValue(ix, "op_cntr_qty"	        ));
								sheetObj5.SetCellValue(newRow, "rat_ut_cd"	           ,sheetObj3.GetCellValue(ix, "rat_ut_cd"	        ));
								sheetObj5.SetCellValue(newRow, "chg_amt"	           ,sheetObj3.GetCellValue(ix, "oa_fnl_frt_rt_amt") * sheetObj3.GetCellValue(ix, "op_cntr_qty"));
								sheetObj5.SetCellValue(newRow, "incl_oft_flg"	       ,'N');
								sheetObj5.SetCellValue(newRow, "frt_term_cd"	       ,sheetObj3.GetCellValue(ix, "oa_frt_term_cd"	    ));
								sheetObj5.SetCellValue(newRow, "cgo_tp_cd"	           ,sheetObj3.GetCellValue(ix, "cgo_cate_cd"	        ));
								sheetObj5.SetCellValue(newRow, "rcv_term_cd"	       ,sheetObj3.GetCellValue(ix, "rcv_term_cd"	    ));
								sheetObj5.SetCellValue(newRow, "de_term_cd"	       ,sheetObj3.GetCellValue(ix, "de_term_cd"	        ));
								sheetObj5.SetCellValue(newRow, "imdg_clss_cd"	       ,sheetObj3.GetCellValue(ix, "imdg_clss_cd"	    ));
								sheetObj5.SetCellValue(newRow, "m"		               ,'A');
								sheetObj5.SetCellValue(newRow, "hide"	  	   	       ,' ');
								sheetObj5.SetCellValue(newRow, "bkg_no" 	           ,sheetObj3.GetCellValue(ix, "bkg_no" 	        ));
								sheetObj5.SetCellValue(newRow, "cntr_tpsz_cd" 	       ,sheetObj3.GetCellValue(ix, "cntr_tpsz_cd" 	    ));
								sheetObj5.SetCellValue(newRow, "ctrt_cntr_tpsz_cd"	   ,sheetObj3.GetCellValue(ix, "ctrt_cntr_tpsz_cd"	));
								sheetObj5.SetCellValue(newRow, "dry_cgo_flg"          ,sheetObj3.GetCellValue(ix, "dry_cgo_flg"        ));
								sheetObj5.SetCellValue(newRow, "awk_cgo_flg"          ,sheetObj3.GetCellValue(ix, "awk_cgo_flg"        ));
								sheetObj5.SetCellValue(newRow, "dcgo_flg"	           ,sheetObj3.GetCellValue(ix, "dcgo_flg"	        ));
								sheetObj5.SetCellValue(newRow, "rc_flg" 	           ,sheetObj3.GetCellValue(ix, "rc_flg" 	        ));
								sheetObj5.SetCellValue(newRow, "bb_cgo_flg"	   	   ,sheetObj3.GetCellValue(ix, "bb_cgo_flg"	        ));
								sheetObj5.SetCellValue(newRow, "soc_flg"	           ,sheetObj3.GetCellValue(ix, "soc_flg"	        ));
								sheetObj5.SetCellValue(newRow, "prc_gen_spcl_rt_tp_cd",sheetObj3.GetCellValue(ix, "prc_gen_spcl_rt_tp_cd"  ));
								sheetObj5.SetCellValue(newRow, "prc_cmdt_hdr_seq"     ,sheetObj3.GetCellValue(ix, "prc_cmdt_hdr_seq"       ));
								sheetObj5.SetCellValue(newRow, "prc_rout_seq"         ,sheetObj3.GetCellValue(ix, "prc_rout_seq"           ));
								sheetObj5.SetCellValue(newRow, "op_cntr_qty"          ,sheetObj3.GetCellValue(ix, "op_cntr_qty"            ));
								sheetObj5.SetCellValue(newRow, "prc_rt_seq"           ,sheetObj3.GetCellValue(ix, "prc_rt_seq"             ));
								sheetObj5.SetCellValue(newRow, "fnl_frt_rt_amt"       ,sheetObj3.GetCellValue(ix, "fnl_frt_rt_amt"         ));
								/* POL, DEL Match Logic  */
								sheetObj5.SetCellValue(newRow, "por_mtch_flg"		   ,sheetObj3.GetCellValue(ix, "por_mtch_flg"         ));
								sheetObj5.SetCellValue(newRow, "del_mtch_flg"		   ,sheetObj3.GetCellValue(ix, "del_mtch_flg"         ));
								sheetObj5.SetCellValue(newRow, "eq_subst_cntr_tpsz_cd"		   ,sheetObj3.GetCellValue(ix, "eq_subst_cntr_tpsz_cd"         ));
								sheetObj5.SetCellValue(newRow, "ibflag"               ,"U");
							}
						}
			 			if(pt_cd.substr(0,1) == 1){
			 				if(sheetObj3.GetCellValue(ix,"oi_calc_frt_rt_amt") !='0'){ //  don't display in case cost is 0 when it is broken down
				 				var newRow=sheetObj5.DataInsert(-1); // adding the last line of row in IBSheet
				 				var obj=new Object();// setting 
				 				obj.charge='OIH';
								obj.cur=sheetObj3.GetCellValue(ix, "oi_curr_cd");
								obj.rate=sheetObj3.GetCellValue(ix, "oi_calc_frt_rt_amt");
								obj.rate_as=sheetObj3.GetCellValue(ix, "op_cntr_qty");
								obj.per=sheetObj3.GetCellValue(ix, "rat_ut_cd");
								obj.cargo=sheetObj3.GetCellValue(ix, "cgo_cate_cd");
								obj.term=sheetObj3.GetCellValue(ix, "rcv_term_cd") + "/"+ sheetObj3.GetCellValue(ix,"de_term_cd");
								obj.term_cd=sheetObj3.GetCellValue(ix, "oi_frt_term_cd");//sheetObj1.GetCellValue(1, "frt_term_cd");
								obj.imo=sheetObj3.GetCellValue(ix,  "imdg_clss_cd");
				 				obj.incl='N';
				 				obj.m='A';
								/* forwarding the value from OFT to see the Note in Charge */
								obj.prcPttCd=sheetObj3.GetCellValue(ix,"rt_mtch_patt_cd").substr(1,4);
								obj.propNo=sheetObj3.GetCellValue(ix, "prop_no");
								obj.amdtSeq=sheetObj3.GetCellValue(ix, "amdt_seq");
								obj.svcScpCd=sheetObj3.GetCellValue(ix, "svc_scp_cd");
								obj.genSpclTp=sheetObj3.GetCellValue(ix, "prc_gen_spcl_rt_tp_cd");
								obj.cmdtHdrSeq=sheetObj3.GetCellValue(ix, "prc_cmdt_hdr_seq");
								obj.routSeq=sheetObj3.GetCellValue(ix, "prc_rout_seq");
								obj.noteRtSeq=sheetObj3.GetCellValue(ix, "prc_rt_seq");
								rArray[idx++]=obj;
				 				//setting data which is broken down at sheet 5 to use in the Surcharge 
				 				sheetObj5.SetCellValue(newRow, "chg_cd"		       ,'OIH');
								sheetObj5.SetCellValue(newRow, "curr_cd"	       ,sheetObj3.GetCellValue(ix, "oi_curr_cd"	        ));
								sheetObj5.SetCellValue(newRow, "chg_ut_amt"	       ,sheetObj3.GetCellValue(ix, "oi_fnl_frt_rt_amt"	));
								sheetObj5.SetCellValue(newRow, "rat_as_qty"	       ,sheetObj3.GetCellValue(ix, "op_cntr_qty"	        ));
								sheetObj5.SetCellValue(newRow, "rat_ut_cd"	           ,sheetObj3.GetCellValue(ix, "rat_ut_cd"	        ));
								sheetObj5.SetCellValue(newRow, "chg_amt"	           ,sheetObj3.GetCellValue(ix, "oi_fnl_frt_rt_amt") * sheetObj3.GetCellValue(ix, "op_cntr_qty"));
								sheetObj5.SetCellValue(newRow, "incl_oft_flg"	       ,'N');
								sheetObj5.SetCellValue(newRow, "frt_term_cd"	       ,sheetObj3.GetCellValue(ix, "oi_frt_term_cd"	    ));
								sheetObj5.SetCellValue(newRow, "cgo_tp_cd"	           ,sheetObj3.GetCellValue(ix, "cgo_cate_cd"	        ));
								sheetObj5.SetCellValue(newRow, "rcv_term_cd"	       ,sheetObj3.GetCellValue(ix, "rcv_term_cd"	    ));
								sheetObj5.SetCellValue(newRow, "de_term_cd"	       ,sheetObj3.GetCellValue(ix, "de_term_cd"	        ));
								sheetObj5.SetCellValue(newRow, "imdg_clss_cd"	       ,sheetObj3.GetCellValue(ix, "imdg_clss_cd"	    ));
								sheetObj5.SetCellValue(newRow, "m"		               ,'A');
								sheetObj5.SetCellValue(newRow, "hide"	  	   	       ,' ');
								sheetObj5.SetCellValue(newRow, "bkg_no" 	           ,sheetObj3.GetCellValue(ix, "bkg_no" 	        ));
								sheetObj5.SetCellValue(newRow, "cntr_tpsz_cd" 	       ,sheetObj3.GetCellValue(ix, "cntr_tpsz_cd" 	    ));
								sheetObj5.SetCellValue(newRow, "ctrt_cntr_tpsz_cd"	   ,sheetObj3.GetCellValue(ix, "ctrt_cntr_tpsz_cd"	));
								sheetObj5.SetCellValue(newRow, "dry_cgo_flg"          ,sheetObj3.GetCellValue(ix, "dry_cgo_flg"        ));
								sheetObj5.SetCellValue(newRow, "awk_cgo_flg"          ,sheetObj3.GetCellValue(ix, "awk_cgo_flg"        ));
								sheetObj5.SetCellValue(newRow, "dcgo_flg"	           ,sheetObj3.GetCellValue(ix, "dcgo_flg"	        ));
								sheetObj5.SetCellValue(newRow, "rc_flg" 	           ,sheetObj3.GetCellValue(ix, "rc_flg" 	        ));
								sheetObj5.SetCellValue(newRow, "bb_cgo_flg"	   	   ,sheetObj3.GetCellValue(ix, "bb_cgo_flg"	        ));
								sheetObj5.SetCellValue(newRow, "soc_flg"	           ,sheetObj3.GetCellValue(ix, "soc_flg"	        ));
								sheetObj5.SetCellValue(newRow, "prc_gen_spcl_rt_tp_cd",sheetObj3.GetCellValue(ix, "prc_gen_spcl_rt_tp_cd"  ));
								sheetObj5.SetCellValue(newRow, "prc_cmdt_hdr_seq"     ,sheetObj3.GetCellValue(ix, "prc_cmdt_hdr_seq"       ));
								sheetObj5.SetCellValue(newRow, "prc_rout_seq"         ,sheetObj3.GetCellValue(ix, "prc_rout_seq"           ));
								sheetObj5.SetCellValue(newRow, "op_cntr_qty"          ,sheetObj3.GetCellValue(ix, "op_cntr_qty"            ));
								sheetObj5.SetCellValue(newRow, "prc_rt_seq"           ,sheetObj3.GetCellValue(ix, "prc_rt_seq"             ));
								sheetObj5.SetCellValue(newRow, "fnl_frt_rt_amt"       ,sheetObj3.GetCellValue(ix, "fnl_frt_rt_amt"         ));
								/* POL, DEL Match Logic  */
								sheetObj5.SetCellValue(newRow, "por_mtch_flg"		   ,sheetObj3.GetCellValue(ix, "por_mtch_flg"         ));
								sheetObj5.SetCellValue(newRow, "del_mtch_flg"		   ,sheetObj3.GetCellValue(ix, "del_mtch_flg"         ));
								sheetObj5.SetCellValue(newRow, "eq_subst_cntr_tpsz_cd"		   ,sheetObj3.GetCellValue(ix, "eq_subst_cntr_tpsz_cd"         ));
								sheetObj5.SetCellValue(newRow, "ibflag"               ,"U");
			 				}
			 			}
			 			if(pt_cd.substr(2,1) == 1){
			 				if(sheetObj3.GetCellValue(ix,"da_calc_frt_rt_amt") !='0'){ // don't display in case cost is 0 when it is broken down
				 				var newRow=sheetObj5.DataInsert(-1); // adding the last line of row in IBSheet
				 				var obj=new Object();// setting 
				 				obj.charge='DAR';
								obj.cur=sheetObj3.GetCellValue(ix, "da_curr_cd");
								obj.rate=sheetObj3.GetCellValue(ix, "da_calc_frt_rt_amt");
								obj.rate_as=sheetObj3.GetCellValue(ix, "op_cntr_qty");
								obj.per=sheetObj3.GetCellValue(ix, "rat_ut_cd");
								obj.cargo=sheetObj3.GetCellValue(ix, "cgo_cate_cd");
								obj.term=sheetObj3.GetCellValue(ix, "rcv_term_cd") + "/"+ sheetObj3.GetCellValue(ix, "de_term_cd");
								//			 				obj.term_cd	= sheetObj1.CellValue(1,  "frt_term_cd");
				 				obj.term_cd=sheetObj3.GetCellValue(ix, "da_frt_term_cd");//formObj.term_cd.value;
				 				obj.imo=sheetObj3.GetCellValue(ix, "imdg_clss_cd");
				 				obj.incl='N';
				 				obj.m='A';
								/* forwarding the value from OFT to see the Note in Charge */
								obj.prcPttCd=sheetObj3.GetCellValue(ix,"rt_mtch_patt_cd").substr(1,4);
								obj.propNo=sheetObj3.GetCellValue(ix, "prop_no");
								obj.amdtSeq=sheetObj3.GetCellValue(ix, "amdt_seq");
								obj.svcScpCd=sheetObj3.GetCellValue(ix, "svc_scp_cd");
								obj.genSpclTp=sheetObj3.GetCellValue(ix, "prc_gen_spcl_rt_tp_cd");
								obj.cmdtHdrSeq=sheetObj3.GetCellValue(ix, "prc_cmdt_hdr_seq");
								obj.routSeq=sheetObj3.GetCellValue(ix, "prc_rout_seq");
								obj.noteRtSeq=sheetObj3.GetCellValue(ix, "prc_rt_seq");
				 				rArray[idx++]=obj;
				 				//setting data which is broken down at sheet 5 to use in the Surcharge 
				 				sheetObj5.SetCellValue(newRow, "chg_cd"		       ,'DAR');
								sheetObj5.SetCellValue(newRow, "curr_cd"	       ,sheetObj3.GetCellValue(ix, "da_curr_cd"	        ));
								sheetObj5.SetCellValue(newRow, "chg_ut_amt"	       ,sheetObj3.GetCellValue(ix, "da_fnl_frt_rt_amt"	));
								sheetObj5.SetCellValue(newRow, "rat_as_qty"	       ,sheetObj3.GetCellValue(ix, "op_cntr_qty"	        ));
								sheetObj5.SetCellValue(newRow, "rat_ut_cd"	           ,sheetObj3.GetCellValue(ix, "rat_ut_cd"	        ));
								sheetObj5.SetCellValue(newRow, "chg_amt"	           ,sheetObj3.GetCellValue(ix, "da_fnl_frt_rt_amt") * sheetObj3.GetCellValue(ix, "op_cntr_qty"));
								sheetObj5.SetCellValue(newRow, "incl_oft_flg"	       ,'N');
								sheetObj5.SetCellValue(newRow, "frt_term_cd"	       ,sheetObj3.GetCellValue(ix, "da_frt_term_cd"	    ));
								sheetObj5.SetCellValue(newRow, "cgo_tp_cd"	           ,sheetObj3.GetCellValue(ix, "cgo_cate_cd"	        ));
								sheetObj5.SetCellValue(newRow, "rcv_term_cd"	       ,sheetObj3.GetCellValue(ix, "rcv_term_cd"	    ));
								sheetObj5.SetCellValue(newRow, "de_term_cd"	       ,sheetObj3.GetCellValue(ix, "de_term_cd"	        ));
								sheetObj5.SetCellValue(newRow, "imdg_clss_cd"	       ,sheetObj3.GetCellValue(ix, "imdg_clss_cd"	    ));
								sheetObj5.SetCellValue(newRow, "m"		               ,'A');
								sheetObj5.SetCellValue(newRow, "hide"	  	   	       ,' ');
								sheetObj5.SetCellValue(newRow, "bkg_no" 	           ,sheetObj3.GetCellValue(ix, "bkg_no" 	        ));
								sheetObj5.SetCellValue(newRow, "cntr_tpsz_cd" 	       ,sheetObj3.GetCellValue(ix, "cntr_tpsz_cd" 	    ));
								sheetObj5.SetCellValue(newRow, "ctrt_cntr_tpsz_cd"	   ,sheetObj3.GetCellValue(ix, "ctrt_cntr_tpsz_cd"	));
								sheetObj5.SetCellValue(newRow, "dry_cgo_flg"          ,sheetObj3.GetCellValue(ix, "dry_cgo_flg"        ));
								sheetObj5.SetCellValue(newRow, "awk_cgo_flg"          ,sheetObj3.GetCellValue(ix, "awk_cgo_flg"        ));
								sheetObj5.SetCellValue(newRow, "dcgo_flg"	           ,sheetObj3.GetCellValue(ix, "dcgo_flg"	        ));
								sheetObj5.SetCellValue(newRow, "rc_flg" 	           ,sheetObj3.GetCellValue(ix, "rc_flg" 	        ));
								sheetObj5.SetCellValue(newRow, "bb_cgo_flg"	   	   ,sheetObj3.GetCellValue(ix, "bb_cgo_flg"	        ));
								sheetObj5.SetCellValue(newRow, "soc_flg"	           ,sheetObj3.GetCellValue(ix, "soc_flg"	        ));
								sheetObj5.SetCellValue(newRow, "prc_gen_spcl_rt_tp_cd",sheetObj3.GetCellValue(ix, "prc_gen_spcl_rt_tp_cd"  ));
								sheetObj5.SetCellValue(newRow, "prc_cmdt_hdr_seq"     ,sheetObj3.GetCellValue(ix, "prc_cmdt_hdr_seq"       ));
								sheetObj5.SetCellValue(newRow, "prc_rout_seq"         ,sheetObj3.GetCellValue(ix, "prc_rout_seq"           ));
								sheetObj5.SetCellValue(newRow, "op_cntr_qty"          ,sheetObj3.GetCellValue(ix, "op_cntr_qty"            ));
								sheetObj5.SetCellValue(newRow, "prc_rt_seq"           ,sheetObj3.GetCellValue(ix, "prc_rt_seq"             ));
								sheetObj5.SetCellValue(newRow, "fnl_frt_rt_amt"       ,sheetObj3.GetCellValue(ix, "fnl_frt_rt_amt"         ));
								/* POL, DEL Match Logic  */
								sheetObj5.SetCellValue(newRow, "por_mtch_flg"		   ,sheetObj3.GetCellValue(ix, "por_mtch_flg"         ));
								sheetObj5.SetCellValue(newRow, "del_mtch_flg"		   ,sheetObj3.GetCellValue(ix, "del_mtch_flg"         ));
								sheetObj5.SetCellValue(newRow, "eq_subst_cntr_tpsz_cd"		   ,sheetObj3.GetCellValue(ix, "eq_subst_cntr_tpsz_cd"         ));
								sheetObj5.SetCellValue(newRow, "ibflag"               ,"U");
			 				}
			 			}
			 			if(pt_cd.substr(3,1) == 1){
			 				if(sheetObj3.GetCellValue(ix,"di_calc_frt_rt_amt") !='0'){ //don't display in case cost is 0 when it is broken down
				 				var newRow=sheetObj5.DataInsert(-1); // adding the last line of row in IBSheet
				 				var obj=new Object();// setting 
				 				obj.charge='DIH';
								obj.cur=sheetObj3.GetCellValue(ix, "di_curr_cd");
								obj.rate=sheetObj3.GetCellValue(ix, "di_calc_frt_rt_amt");
								obj.rate_as=sheetObj3.GetCellValue(ix, "op_cntr_qty");
								obj.per=sheetObj3.GetCellValue(ix, "rat_ut_cd");
								obj.cargo=sheetObj3.GetCellValue(ix, "cgo_cate_cd");
								obj.term=sheetObj3.GetCellValue(ix, "rcv_term_cd") + "/"+ sheetObj3.GetCellValue(ix, "de_term_cd");
	//			 				obj.term_cd	= sheetObj1.CellValue(1,  "frt_term_cd");
				 				obj.term_cd=sheetObj3.GetCellValue(ix, "di_frt_term_cd");//formObj.term_cd.value;
				 				obj.imo=sheetObj3.GetCellValue(ix, "imdg_clss_cd");
				 				obj.incl='N';
				 				obj.m='A';
								/* forwarding the value from OFT to see the Note in Charge */
								obj.prcPttCd=sheetObj3.GetCellValue(ix,"rt_mtch_patt_cd").substr(1,4);
								obj.propNo=sheetObj3.GetCellValue(ix, "prop_no");
								obj.amdtSeq=sheetObj3.GetCellValue(ix, "amdt_seq");
								obj.svcScpCd=sheetObj3.GetCellValue(ix, "svc_scp_cd");
								obj.genSpclTp=sheetObj3.GetCellValue(ix, "prc_gen_spcl_rt_tp_cd");
								obj.cmdtHdrSeq=sheetObj3.GetCellValue(ix, "prc_cmdt_hdr_seq");
								obj.routSeq=sheetObj3.GetCellValue(ix, "prc_rout_seq");
								obj.noteRtSeq=sheetObj3.GetCellValue(ix, "prc_rt_seq");
				 				rArray[idx++]=obj;
				 				//setting data which is broken down at sheet 5 to use in the Surcharge 
				 				sheetObj5.SetCellValue(newRow, "chg_cd"		       ,'DIH');
								sheetObj5.SetCellValue(newRow, "curr_cd"	           ,sheetObj3.GetCellValue(ix, "di_curr_cd"	        ));
								sheetObj5.SetCellValue(newRow, "chg_ut_amt"	       ,sheetObj3.GetCellValue(ix, "di_fnl_frt_rt_amt"	));
								sheetObj5.SetCellValue(newRow, "rat_as_qty"	       ,sheetObj3.GetCellValue(ix, "op_cntr_qty"	        ));
								sheetObj5.SetCellValue(newRow, "rat_ut_cd"	           ,sheetObj3.GetCellValue(ix, "rat_ut_cd"	        ));
								sheetObj5.SetCellValue(newRow, "chg_amt"	           ,sheetObj3.GetCellValue(ix, "di_fnl_frt_rt_amt") * sheetObj3.GetCellValue(ix, "op_cntr_qty"));
								sheetObj5.SetCellValue(newRow, "incl_oft_flg"	       ,'N');
								sheetObj5.SetCellValue(newRow, "frt_term_cd"	       ,sheetObj3.GetCellValue(ix, "di_frt_term_cd"	    ));
								sheetObj5.SetCellValue(newRow, "cgo_tp_cd"	           ,sheetObj3.GetCellValue(ix, "cgo_cate_cd"	        ));
								sheetObj5.SetCellValue(newRow, "rcv_term_cd"	       ,sheetObj3.GetCellValue(ix, "rcv_term_cd"	    ));
								sheetObj5.SetCellValue(newRow, "de_term_cd"	       ,sheetObj3.GetCellValue(ix, "de_term_cd"	        ));
								sheetObj5.SetCellValue(newRow, "imdg_clss_cd"	       ,sheetObj3.GetCellValue(ix, "imdg_clss_cd"	    ));
								sheetObj5.SetCellValue(newRow, "m"		               ,'A');
								sheetObj5.SetCellValue(newRow, "hide"	  	   	       ,' ');
								sheetObj5.SetCellValue(newRow, "bkg_no" 	           ,sheetObj3.GetCellValue(ix, "bkg_no" 	        ));
								sheetObj5.SetCellValue(newRow, "cntr_tpsz_cd" 	       ,sheetObj3.GetCellValue(ix, "cntr_tpsz_cd" 	    ));
								sheetObj5.SetCellValue(newRow, "ctrt_cntr_tpsz_cd"	   ,sheetObj3.GetCellValue(ix, "ctrt_cntr_tpsz_cd"	));
								sheetObj5.SetCellValue(newRow, "dry_cgo_flg"          ,sheetObj3.GetCellValue(ix, "dry_cgo_flg"        ));
								sheetObj5.SetCellValue(newRow, "awk_cgo_flg"          ,sheetObj3.GetCellValue(ix, "awk_cgo_flg"        ));
								sheetObj5.SetCellValue(newRow, "dcgo_flg"	           ,sheetObj3.GetCellValue(ix, "dcgo_flg"	        ));
								sheetObj5.SetCellValue(newRow, "rc_flg" 	           ,sheetObj3.GetCellValue(ix, "rc_flg" 	        ));
								sheetObj5.SetCellValue(newRow, "bb_cgo_flg"	   	   ,sheetObj3.GetCellValue(ix, "bb_cgo_flg"	        ));
								sheetObj5.SetCellValue(newRow, "soc_flg"	           ,sheetObj3.GetCellValue(ix, "soc_flg"	        ));
								sheetObj5.SetCellValue(newRow, "prc_gen_spcl_rt_tp_cd",sheetObj3.GetCellValue(ix, "prc_gen_spcl_rt_tp_cd"  ));
								sheetObj5.SetCellValue(newRow, "prc_cmdt_hdr_seq"     ,sheetObj3.GetCellValue(ix, "prc_cmdt_hdr_seq"       ));
								sheetObj5.SetCellValue(newRow, "prc_rout_seq"         ,sheetObj3.GetCellValue(ix, "prc_rout_seq"           ));
								sheetObj5.SetCellValue(newRow, "op_cntr_qty"          ,sheetObj3.GetCellValue(ix, "op_cntr_qty"            ));
								sheetObj5.SetCellValue(newRow, "prc_rt_seq"           ,sheetObj3.GetCellValue(ix, "prc_rt_seq"             ));
								sheetObj5.SetCellValue(newRow, "fnl_frt_rt_amt"       ,sheetObj3.GetCellValue(ix, "fnl_frt_rt_amt"         ));
								/* POL, DEL Match Logic  */
								sheetObj5.SetCellValue(newRow, "por_mtch_flg"		   ,sheetObj3.GetCellValue(ix, "por_mtch_flg"         ));
								sheetObj5.SetCellValue(newRow, "del_mtch_flg"		   ,sheetObj3.GetCellValue(ix, "del_mtch_flg"         ));
								sheetObj5.SetCellValue(newRow, "eq_subst_cntr_tpsz_cd"		   ,sheetObj3.GetCellValue(ix, "eq_subst_cntr_tpsz_cd"         ));
								sheetObj5.SetCellValue(newRow, "ibflag"               ,"U");
			 				}
			 			}
			 		}
			 	}
			}
			//adding POR_MTCH, DEL_MTCH 
//			for ( var b=1; b <= cnt3_row; b++){
//				if(sheetObj3.GetCellValue(b,"_flg") == 1){
//					if(sheetObj3.GetCellValue(b,"por_mtch_flg") == 'N'){
//						var obj=new Object(); //setting
//						if(sheetObj3.GetCellValue(b,"rcv_term_cd")=="Y"){
//							obj.charge='OAR';
//						}else{
//							obj.charge='OIH';
//						}
//						obj.curr='';
//						obj.rate='';
//						obj.rate_as='';
//						obj.per='';
//						obj.cargo=sheetObj3.GetCellValue(b,"cgo_cate_cd");
//						obj.incl='N';
//						obj.term_cd=formObj.term_cd.value;
//						obj.term=sheetObj3.GetCellValue(b,"rcv_term_cd") +"/"+ sheetObj3.GetCellValue(b,"de_term_cd");
//						obj.imo=sheetObj3.GetCellValue(b,"imdg_clss_cd");
//						obj.m='A';
//						rArray[idx++]=obj;
//					}
//					if(sheetObj3.GetCellValue(b,"del_mtch_flg") == 'N'){
//						var obj=new Object(); //setting
//						if(sheetObj3.GetCellValue(b,"de_term_cd")=="Y"){
//							obj.charge='DAR';
//						}else{
//							obj.charge='DIH';
//						}
//						obj.curr='';
//						obj.rate='';
//						obj.rate_as='';
//						obj.per='';
//						obj.cargo=sheetObj3.GetCellValue(b,"cgo_cate_cd");
//						obj.incl='N';
//						obj.term_cd=formObj.term_cd.value;
//						obj.term=sheetObj3.GetCellValue(b,"rcv_term_cd") +"/"+ sheetObj3.GetCellValue(b,"de_term_cd");
//						obj.imo=sheetObj3.GetCellValue(b,"imdg_clss_cd");
//						obj.m='A';
//						rArray[idx++]=obj;
//					}
//				}
//			}
			//5. Surcharge   ->    inserting Sheet5 and  inserting into Sheet4 by Searching   
//			doActionIBSheet(sheetObject3, formObj, IBSAVE);
			doActionIBSheet(sheetObject5, formObj, IBSAVE);
			//6. Data setting at charge
			var sch=sheetObjects[4].GetTotalRows();
			for ( var i=1; i <= sch; i++)
			{ 
				var obj=new Object(); //setting
				obj.charge=sheetObj4.GetCellValue(i,"chg_cd");
				obj.cur=sheetObj4.GetCellValue(i,"curr_cd");
				obj.rate=sheetObj4.GetCellValue(i,"chg_ut_amt");
				obj.rate_as=sheetObj4.GetCellValue(i,"rat_as_qty");
				/* in case Per Type is PC ,inserting AMT 
				 * in case of forwarding '' to Charge , calculating automatically*/
				/* deleting Logic  */   
//				if(sheetObj4.CellValue(i,"rat_ut_cd") =="PC"){
//					obj.amt = sheetObj4.CellValue(i,"chg_amt");
//				}
				obj.amt=sheetObj4.GetCellValue(i,"chg_amt");
				obj.per=sheetObj4.GetCellValue(i,"rat_ut_cd");
				obj.cargo=sheetObj4.GetCellValue(i,"cgo_tp_cd");
				obj.incl=sheetObj4.GetCellValue(i,"frt_incl_xcld_div_cd");
				obj.term_cd=sheetObj4.GetCellValue(i,"frt_term_cd");
				obj.term=sheetObj4.GetCellValue(i,"rcv_term_cd") +"/"+ sheetObj4.GetCellValue(i,"de_term_cd");
				obj.imo=sheetObj4.GetCellValue(i,"imdg_clss_cd");
				obj.tax=sheetObj4.GetCellValue(i,"tax_flg");
				obj.taxcnt=sheetObj4.GetCellValue(i,"tax_cnt_cd");
				obj.m='A';
				rArray[idx++]=obj;
			}
			//7. forwarding Application Date and Commodity to Charge 
				var _obj=new Object(); //setting
				_obj.appldt=ComGetObjValue(formObj.frm_appldt);
				_obj.cmdtcd=ComGetObjValue(formObj.frm_cmdtcd);
				_obj.repcmdtcd=ComGetObjValue(formObj.frm_rep_cmdt_cd);
				_obj.actionType="Commodity";
				rArray[idx++]=_obj;
			
			
			
			ComPopUpReturnValue(rArray); //setting retVal.
			
			ComClosePopup(); 
			
			break;
		case "pop_on_board_date":
			var cal=new ComCalendar();
			cal.select(formObj.frm_cntr_cdr_dt, 'yyyy-MM-dd');
			break;
		case "btn_Close":
			var idx=0;
			var rArray=new Array();
			var sheetObj3=sheetObjects[3];
			var sheetObj4=sheetObjects[4];
			var cnt3_row=sheetObj3.GetTotalRows();
			var flg_cnt=0 ;
				for ( var z=1; z <= cnt3_row; z++){
					if(sheetObj3.GetCellValue(z,"_flg") == 1){
						flg_cnt++;
					}
				}
				// getting Surcharge when Close button is clicked
//				if(flg_cnt == 0  ){
					doActionIBSheet(sheetObject5, formObj, SEARCH03);
//				}
				// Data setting in Charge 
				var cnt4_row=sheetObj4.GetTotalRows();
				var sch=sheetObjects[4].GetTotalRows();
				if(sch == 0 ){
					var obj=new Object(); //setting value
					obj.prcPttCd="";
					obj.genSpclTp="";
					obj.cmdtHdrSeq="";
					obj.routSeq="";
					obj.actionType="Close";
					rArray[idx++]=obj;
				}else{
					if(sch > 0){
						for ( var i=1; i <= sch; i++)
						{
							var obj=new Object(); // setting value
							obj.charge=sheetObj4.GetCellValue(i,"chg_cd");
							obj.cur=sheetObj4.GetCellValue(i,"curr_cd");
							obj.rate=sheetObj4.GetCellValue(i,"chg_ut_amt");
							obj.rate_as=sheetObj4.GetCellValue(i,"rat_as_qty");
							obj.amt=sheetObj4.GetCellValue(i,"chg_amt");
							obj.per=sheetObj4.GetCellValue(i,"rat_ut_cd");
							obj.cargo=sheetObj4.GetCellValue(i,"cgo_tp_cd");
							obj.incl=sheetObj4.GetCellValue(i,"frt_incl_xcld_div_cd");
							obj.term_cd=sheetObj4.GetCellValue(i,"frt_term_cd");
							obj.term=sheetObj4.GetCellValue(i,"rcv_term_cd") +"/"+ sheetObj4.GetCellValue(i,"de_term_cd");
							obj.imo=sheetObj4.GetCellValue(i,"imdg_clss_cd");
							obj.tax=sheetObj4.GetCellValue(i,"tax_flg");		//2016.03.22 tax charge
							obj.taxcnt=sheetObj4.GetCellValue(i,"tax_cnt_cd");
							obj.m='A';
							obj.prcPttCd="";
							obj.genSpclTp="";
							obj.cmdtHdrSeq="";
							obj.routSeq="";
							obj.actionType="Close";
							rArray[idx++]=obj;
						}
					}
				}
				ComPopUpReturnValue(rArray);//setting retVal .
				ComClosePopup(); 
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
			bkg_error_ComShowMessage(e.message);
		} else {
			ComShowMessage(e.message);
			bkg_error_ComShowMessage(e.message);
		}
	}
}
// handling of Sheet 
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	//ComOpenWait(true); //showing the waiting box 
	switch (sAction) {
	case IBSEARCH: 
		try {
				//1.inserting parameter or setting selected value before searching
				ComSetObjValue(formObj.f_cmd, SEARCH);
				// 2.searching
				var sXml=sheetObj.GetSearchData("ESM_BKG_0269GS.do", FormQueryString(formObj));
				pagedMaxCnt=sheetObj.HeaderRows();// initializing variable for changing color
				// 3.handling result 
				var arrXml=sXml.split("|$$|");
				var State=ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY");
				/* adding retrieve success or fail */
				if (State != "S"){
					ComShowCodeMessage('BKG00450');
				}
								
				for ( var inx=0; inx < arrXml.length; inx++) {
					if(inx == 3){
						doActionIBSheet(sheetObjects[3], formObj, SEARCH01); //retrieve execute 
					} else {
						sheetObjects[inx].LoadSearchData(arrXml[inx],{Sync:1} ); 
					}
				}
					
				
				//searching 
				formObj.frm_cntr_cdr_dt.value=formObj.application_date.value.substr(0,4)+'-'+formObj.application_date.value.substr(4,2)+'-'+formObj.application_date.value.substr(6,2);
				formObj.frm_appldt.value=ComGetObjValue(formObj.frm_cntr_cdr_dt);
				formObj.frm_cmdtcd.value=ComGetObjValue(formObj.frm_cmdt_cd);
				formObj.frm_repcmdtcd.value=ComGetObjValue(formObj.frm_rep_cmdt_cd);
				formObj.frm_frt_term_cd.value=ComGetObjValue(formObj.term_cd);
				ComOpenWait(false); //disappearing waiting box 
				
			} catch (e) {
				if (e == "[Faile to retrieve data.]") {
					ComShowMessage("BKG00450");
					//bkg_error_ComShowMessage(e.message);
				} else {
					ComShowMessage(e.message);
					//bkg_error_ComShowMessage(e.message);
				}
			}
		break;
	case SEARCH01: 
		try {
				/* 
				 *  it is able to rate automatically after changing date
				 * 2010.05.13 */
				formObj.application_date.value=ComGetObjValue(formObj.frm_cntr_cdr_dt);
				formObj.application_date.value=formObj.application_date.value.replace(/-/gi,"");
				//1.inserting parameter or setting selected value before searching  
				//  AutoRating by scope of parameter
				ComSetObjValue(formObj.frm_svc_scp_cd, formObj.svc_scp_cd.value);
				ComSetObjValue(formObj.f_cmd, SEARCH01);
				// 2.searching

				var sXml=sheetObj.GetSearchData("ESM_BKG_0269GS.do", FormQueryString(formObj));					
				sheetObj.LoadSearchData(sXml,{Sync:0} );
				
				
		//		var sXml = sheetObj.GetSearchXml("ESM_BKG_0269GS.do",FormQueryString(formObj));
		//		var arrXml = sXml.split("|$$|");
		//
		//		for ( var inx = 3;  inx < arrXml.length+3; inx++) {
		//			sheetObjects[inx].LoadSearchXml(arrXml[inx-3]);
		//		}
				formObj.frm_appldt.value=ComGetObjValue(formObj.frm_cntr_cdr_dt);
				formObj.frm_cmdtcd.value=ComGetObjValue(formObj.frm_cmdt_cd);
				formObj.frm_repcmdtcd.value=ComGetObjValue(formObj.frm_rep_cmdt_cd);
				ComOpenWait(false); //disappearing waiting box 
			} catch (e) {
				if (e == "[Faile to retrieve data.]") {
					ComShowMessage("BKG00450");
					bkg_error_ComShowMessage(e.message);
				} else {
					ComShowMessage(e.message);
					bkg_error_ComShowMessage(e.message);
				}
			}
			break;
	case IBSAVE: //  saving into table for surcharge
		if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value=MULTI;
//			var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0269GS.do", FormQueryString(formObj));
//			sheetObj.LoadSaveXml(SaveXml);
//			var sParam = sheetObj.GetSaveString();
//			sheetObj.doSave("ESM_BKG_0269GS.do" , sParam);
//			
//			var sParam = ComGetSaveString(sheetObjects[3]);
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true); // showing the waiting box
			var sParam=ComGetSaveString(sheetObjects[5]);
			sParam += "&" + FormQueryString(formObj);
			var SaveXml=sheetObj.GetSaveData("ESM_BKG_0269GS.do", sParam);
            var sheetObject4=sheetObjects[4];
            sheetObjects[4].LoadSaveData(SaveXml);
		break;
	case SEARCH03: //  applying surcharge in case of clicking Close button 
		if(!validateForm(sheetObj,formObj,sAction)) return;
		formObj.f_cmd.value=SEARCH03;
		sParam += "&"+ FormQueryString(formObj);
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true); // showing the waiting box
		var SaveXml=sheetObj.GetSaveData("ESM_BKG_0269GS.do", sParam);
		var sheetObject4=sheetObjects[4];
		sheetObjects[4].LoadSaveData(SaveXml);
		break;
	}
	ComOpenWait(false); //disappearing waiting box 
}




function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj=document.form;
	
	// 4.HTML variable and Binding 	
	IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
	
	var _row=sheetObj.LastRow();	
	if(_row == 0) return;
	ComSetObjValue(formObj.frm_act_wgt,  sheetObj.GetCellText(_row, "act_wgt"));// Weight
	ComSetObjValue(formObj.frm_meas_qty, sheetObj.GetCellText(_row, "meas_qty"));// Measure
	
	//setting the freight term of OFT as selected value on charge screen
	with (sheetObj) {
		if (RowCount() && 0 < RowCount()) {
			for ( var i=1; i <= LastRow(); i++) {
				SetCellValue(i, "frt_term_cd", ComGetObjValue(document.form.term_cd));
			}
		}
	}
}

/**
* handling event after searching
*/
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj=document.form;
	
	// 4.HTML variable and Binding 	
	IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");

}

/**
 * handling event after searching
 */
//function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
//	var formObj = document.form;
//	var c_row = sheetObj.LastRow;
//	with (sheetObj) {
//		for ( var row = 1; row <= c_row; row++) {
//			if (sheetObj.CellValue(row, "nt") != ''){
//				sheetObj.CellFontColor(row, "nt_v") = "#FF0000";
//			}
//		}
//	}
//	
//}
/**
 * mouse
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
function sheet3_OnMouseMove(Button, Shift, X, Y) {
	var sheetObj=sheetObjects[3];
	var m_row=sheetObj.MouseRow();
	var m_col=sheetObj.MouseCol();
	if (m_row > 0 && m_col == 16) {
		sheetObj.SetToolTipText(m_row, m_col,sheetObj.GetCellText(m_row, "nt"));
	}
}
/**
 * getSelectedRow
 * forwarding selected row
 */
function getCheckedRows(colName) {
	var sheetObj=sheetObjects[3];
	var formObj=document.form;
	var checkRows=sheetObj.CheckedRows('radio');
	if (checkRows == 0){
		return null;
	}
	var rArray=null; // array which include row data
	var cArray=null; // array which include column data
	try {
//no support[check again]CLT 		var rows=sheetObj.Rows;
		var idx=0;
		rArray=new Array(checkRows);
		for ( var i=0; i < rows; i++) {
			if (sheetObj.GetCellValue(i, 'radio') == 1) {
				cArray=sheetObj.GetCellValue(i, colName);
				rArray[idx++]=cArray;
			}
		}
	} catch (e) {
		bkg_error_ComShowMessage(e.message);
	}
	return rArray;
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		//             if (!isNumber(formObj.iPage)) {
		//                 return false;
		//             }
	}
	return true;
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
 *  Checking Validation on onblur event<br>
 **/
function obj_activate() {
	//Validation 
	switch (event.srcElement.name) {
	case "frm_cntr_cdr_dt":
		ComClearSeparator(event.srcElement);
		break;
	default:
		break;
	}
}
/**
 * Checking Validation on onblur event <br>
 **/
function obj_deactivate() {
	//Validation 
	switch (event.srcElement.name) {
	case "frm_cntr_cdr_dt":
		var formObj=document.form;
		ComAddSeparator(event.srcElement);
		formObj.application_date.value=formObj.frm_cntr_cdr_dt.value.replace(/-/gi,""); //  forwarding modified value in case of modifying CRD Data
		break;
	default:
		break;
	}
}
/*handling enter key*/
function check_Enter() {
	if (event.keyCode == 13)
		doActionIBSheet(sheetObjects[3], document.form, SEARCH01);
}
 /**
  *  Remark MemoPad 
  */
 function sheet3_OnClick(sheetObj, row, col, value) {
	  // getting Detail information to String 
//	  detail_info(sheetObj, row, col);
	  //  Return String 
	  var rt_data=detail_info1(sheetObj, row, col); 
	  var id=rt_data.lastIndexOf('$$');  
	  var sc_title=rt_data.substring(0,id);
	  var sc_data=rt_data.substring(id+2,rt_data.length);
	  var note_ctnt=sheetObj.GetCellValue(row,"note_ctnt");
	  var cnote_ctnt=sheetObj.GetCellValue(row,"cnote_ctnt");		//2015.11.26
	  var snote_ctnt=sheetObj.GetCellValue(row,"snote_ctnt");
	  var arb_note_ctnt=sheetObj.GetCellValue(row,"arb_note_ctnt");
	  // in case of clicking DTL sheet, opening DTL pop up 
      if (sheetObj.ColSaveName(col) == "dtl") {
    	  if(sheetObj.GetCellValue(row, "dtl") == '' ) return;
//      	ComShowMemoPad(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax)
//      	ComShowMemoPad(sheetObj, null,18, null, null, null, 1000);
//						var param= "?bkg_no="+sheetObj.CellValue(rowIdx, prefix+"bkg_no");
    	  	var param="?title=Detail_INFO&pgmId=0269&sheetIdx=3&sheetRow="+row+"&sheetCol="+col;
//			var param="?title=Detail_INFO&text="+sc_data;
		  	//ComOpenWindowCenter2("/opuscntr/ESM_BKG_0988.do"+param, "Detail INFO", 500,270, false,"scrollbars=yes,resizable=no");
			ComOpenPopup('/opuscntr/ESM_BKG_0988.do'+param, 700, 355, 'Detail INFO', '0,0', true);
		}
      //  in case of clicking sheet, opening Note Conversion pop up
      if (sheetObj.ColSaveName(col) =="note"){
    	  if(sheetObj.GetCellValue(row,"note_ctnt") == '') return;
//    	  var param="?title="+"NOTE CONV"+"&text="+encodeURIComponent(note_ctnt);
    	  var param="?title="+"NOTE CONV"+"&sheetIdx=3&sheetRow="+row+"&sheetCol="+col;
    	  //ComOpenWindowCenter2("/opuscntr/ESM_BKG_0988.do"+param, "NOTE CONV" , 500,270, false,"scrollbars=yes,resizeable=no");
    	  ComOpenPopup('/opuscntr/ESM_BKG_0988.do'+param, 550, 355, 'NOTE CONV', '0,0', true);
      }else if(sheetObj.ColSaveName(col) =="cnote"){
    	  if(sheetObj.GetCellValue(row,"cnote_ctnt") == '') return;
//    	  var param="?title="+"NOTE CONV"+"&text="+encodeURIComponent(cnote_ctnt);
    	  var param="?title="+"NOTE CONV"+"&sheetIdx=3&sheetRow="+row+"&sheetCol="+col;
    	  //ComOpenWindowCenter2("/opuscntr/ESM_BKG_0988.do"+param, "NOTE CONV" , 500,270, false,"scrollbars=yes,resizeable=no");
    	  ComOpenPopup('/opuscntr/ESM_BKG_0988.do'+param, 550, 355, 'NOTE CONV', '0,0', true);
      }else if(sheetObj.ColSaveName(col) =="snote"){
    	  if(sheetObj.GetCellValue(row,"snote_ctnt") == '') return;
//    	  var param="?title="+"NOTE CONV"+"&text="+encodeURIComponent(snote_ctnt);
    	  var param="?title="+"NOTE CONV"+"&sheetIdx=3&sheetRow="+row+"&sheetCol="+col;
    	  //ComOpenWindowCenter2("/opuscntr/ESM_BKG_0988.do"+param, "NOTE CONV" , 500,270, false,"scrollbars=yes,resizeable=no");
    	  ComOpenPopup('/opuscntr/ESM_BKG_0988.do'+param, 550, 355, 'NOTE CONV', '0,0', true);
      }else if(sheetObj.ColSaveName(col) =="arb_note"){
    	  if(sheetObj.GetCellValue(row,"arb_note_ctnt") == '') return;
//    	  var param="?title="+"NOTE CONV"+"&text="+encodeURIComponent(arb_note_ctnt);
    	  var param="?title="+"NOTE CONV"+"&sheetIdx=3&sheetRow="+row+"&sheetCol="+col;
    	  //ComOpenWindowCenter2("/opuscntr/ESM_BKG_0988.do"+param, "NOTE CONV" , 500,270, false,"scrollbars=yes,resizeable=no");
    	  ComOpenPopup('/opuscntr/ESM_BKG_0988.do'+param, 550, 355, 'NOTE CONV', '0,0', true);
      }else if(sheetObj.ColSaveName(col) =="cmdt_nm"){
    	  if(sheetObj.GetCellValue(row,"cmdt_nm") == '') return;
    	  var param="?title="+"CMDT DESC"+"&sheetIdx=3&sheetRow="+row+"&sheetCol="+col;
    	  ComOpenPopup('/opuscntr/ESM_BKG_0988.do'+param, 550, 355, 'CMDT DESC', '0,0', true);
      }
  }
  /**
   * getting cmdt desc , in case column of Commodity focus out 
  */ 
  function getCOM_CMDT_POPUP(rowArray) {
	   var formObject=document.form;    	 
	   var colArray=rowArray[0];
	   formObject.frm_cmdt_cd.value=colArray[3];
	   sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "frm_cmdt_cd",colArray[3],0);
	   formObject.frm_cmdt_nm.value=colArray[4];
	   sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "frm_cmdt_nm",colArray[4],0);
//	   alert(colArray[2]);
//	   alert(colArray[5]);
//	   formObject.frm_rep_cmdt_cd.value = colArra
}
  /*
   * handling event >>> changing color
   */ 
  	var pagedMaxCnt=1; 
  function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
	  with(sheetObj)
		var redColor="#FF0000";
	    var LastRow=sheetObjects[3].LastRow();
	    var formObj=document.form;
	    var multiCnt=0;
		for(var i=1; i <= LastRow; i++){
			var note=sheetObj.GetCellValue(i, "note_ctnt");
			 if (!note.length == 0)
			 {		sheetObj.SetCellValue(i,"note","Y");
			 		sheetObj.SetCellFontColor(i,16,redColor);
//					sheetObj.CellFont("FontItalic", i,16) = true;				 
			 }else{
				 sheetObj.SetCellValue(i,"note","N");
			 }
			var cnote=sheetObj.GetCellValue(i, "cnote_ctnt");
			 if (!cnote.length == 0)
			 {		sheetObj.SetCellValue(i,"cnote","Y");
			 		sheetObj.SetCellFontColor(i,17,redColor);
//					sheetObj.CellFont("FontItalic", i,16) = true;				 
			 }else{
				 sheetObj.SetCellValue(i,"cnote","N");
			 }
			var snote=sheetObj.GetCellValue(i, "snote_ctnt");
			 if (!snote.length == 0)
			 {		sheetObj.SetCellValue(i,"snote","Y");
			 		sheetObj.SetCellFontColor(i,18,redColor);
//					sheetObj.CellFont("FontItalic", i,16) = true;				 
			 }else{
				 sheetObj.SetCellValue(i,"snote","N");
			 }
			var arb_note=sheetObj.GetCellValue(i, "arb_note_ctnt");
			 if (!arb_note.length == 0)
			 {		sheetObj.SetCellValue(i,"arb_note","Y");
			 		sheetObj.SetCellFontColor(i,19,redColor);
//					sheetObj.CellFont("FontItalic", i,16) = true;				 
			 }else{
				 sheetObj.SetCellValue(i,"arb_note","N");
			 }

			 var oftCurr = sheetObj.GetCellValue(i, "curr_cd");
			 var cnt = 0;
			 if(sheetObj.GetCellValue(i, "oi_curr_cd")!="" && oftCurr != sheetObj.GetCellValue(i, "oi_curr_cd"))	cnt++;
			 if(sheetObj.GetCellValue(i, "oa_curr_cd")!="" && oftCurr != sheetObj.GetCellValue(i, "oa_curr_cd"))	cnt++;
			 if(sheetObj.GetCellValue(i, "da_curr_cd")!="" && oftCurr != sheetObj.GetCellValue(i, "da_curr_cd"))	cnt++;
			 if(sheetObj.GetCellValue(i, "di_curr_cd")!="" && oftCurr != sheetObj.GetCellValue(i, "di_curr_cd"))	cnt++;
			 
			 if(cnt>0){
				 sheetObj.SetCellValue(i, "multi_curr", "Y");
				 sheetObj.SetCellFontColor(i, "curr_cd", "#FF0000");
				 sheetObj.SetCellFontColor(i, "fnl_frt_rt_amt", "#FF0000");
				 multiCnt++;
			 }
			 
			 if(sheetObj.GetCellValue(i, "oi_frt_term_cd")!="" && sheetObj.GetCellValue(i, "oi_frt_term_cd")!="P" && sheetObj.GetCellValue(i, "oi_frt_term_cd")!="C"){
				 sheetObj.SetCellValue(i, "oi_frt_term_cd", ComGetObjValue(document.form.term_cd));
			 }
			 if(sheetObj.GetCellValue(i, "oa_frt_term_cd")!="" && sheetObj.GetCellValue(i, "oa_frt_term_cd")!="P" && sheetObj.GetCellValue(i, "oa_frt_term_cd")!="C"){
				 sheetObj.SetCellValue(i, "oa_frt_term_cd", ComGetObjValue(document.form.term_cd));
			 }
			 if(sheetObj.GetCellValue(i, "da_frt_term_cd")!="" && sheetObj.GetCellValue(i, "da_frt_term_cd")!="P" && sheetObj.GetCellValue(i, "da_frt_term_cd")!="C"){
				 sheetObj.SetCellValue(i, "da_frt_term_cd", ComGetObjValue(document.form.term_cd));
			 }
			 if(sheetObj.GetCellValue(i, "di_frt_term_cd")!="" && sheetObj.GetCellValue(i, "di_frt_term_cd")!="P" && sheetObj.GetCellValue(i, "di_frt_term_cd")!="C"){
				 sheetObj.SetCellValue(i, "di_frt_term_cd", ComGetObjValue(document.form.term_cd));
			 }
		}
		
		pagedMaxCnt=sheetObj.LastRow();
		LastRow=0;
	 	// sorting by DP_SEQ
		sheetObj.ColumnSort("dp_seq");
//		alert(formObj.frm_t10sheet1_brk_dwn_flg.value);
		
		var obj =  document.getElementById('multi_curr_msg');
		if(multiCnt>0){
			obj.style.display = "Inline";
		}else{
			obj.style.display = "none";
		}
		
		obj =  document.getElementById('span_multi_curr_msg');
		if(multiCnt>0){
			obj.innerHTML = "*Freight Amount in red color has mixed currencies. Please click Rate Detail to check currency breakdowns."
		}else{
			obj.innerHTML = ""
		}

  }

  /**
   * calling S/C Commodity . <br>
   * <br><b>Example :</b>
   * <pre>
   *     comBkgCallPop0657(callback_func,scNo,bkgNo,bkgVvd,porCd,delCd)
   * </pre>
   * @param {string} inserting self func,ref sheet index which should be called when pop up is selected
   * @return 
   * @author 
   * @version 2009.11.25
   */
  /* S/C pop up */
  function comBkgCallPop0657(callback_func,scNo,bkgNo,bkgVvd,porCd,delCd){
	  ComOpenPopup("ESM_BKG_0657.do?pgmNo=ESM_BKG_0657&bkg_no="+bkgNo+"&sc_no="+scNo+"&bkg_vvd="+bkgVvd+"&por_cd="+porCd+"&del_cd="+delCd, 625, 497, callback_func,"1,0,1,1,1", true);
  }
   /**
    * getting from S/C Commodity pop-up . <br>
    * <br><b>Example :</b>
    * <pre>
    *     callBack0657(arrBal);
    * </pre>
    * @param {string} inserting self func,ref sheet index which should be called when pop up is selected 
    * @return 
    * @author 
    * @version 2009.11.25
    */
    /* calling pop-up(MDM CMDT(0653)) OR setting as value of RepCmdt after calling S/C CMDT    
     * calling MDM pop-up in case value of RepCmdt is 0000 after opening the S/C CMDT pop-up
     * not open the MDM pop-up
     * 
     * 
     * */
	function callBack0657(arrVal){
    	var formObject=document.form;
    	var cmdtCd=arrVal[0][4];
    	var scpCd=(formObject.svc_scp_cd.value).substring(0,3);
    	var repCmdt=arrVal[0][5];
    	if(arrVal != null){	
	    	if(scpCd =="TPE"| scpCd =="ACE"| scpCd =="MXE"){
	    		ComSetObjValue(formObject.frm_cmdt_cd,arrVal[0][4]);
				ComSetObjValue(formObject.frm_cmdt_nm, arrVal[0][2]);
				ComSetObjValue(formObject.sc_code, arrVal[0][1]);
				ComSetObjValue(formObject.frm_rep_cmdt_cd, arrVal[0][5]);
	    	}else if(repCmdt =="0000"){
	    		ComSetObjValue(formObject.frm_cmdt_cd,arrVal[0][4]);
				ComSetObjValue(formObject.frm_cmdt_nm, arrVal[0][2]);
				ComSetObjValue(formObject.sc_code, arrVal[0][1]);
				ComSetObjValue(formObject.frm_rep_cmdt_cd, arrVal[0][5]);
	    	}else if(repCmdt =="0000"){
//				comBkgCallPop0653('callBack0653',formObject.frm_cmdt_cd.value,formObject.frm_rep_cmdt_cd.value);
//				comBkgCallPop0653('callBack0653','','');
//				var param = "?pgmNo=ESM_BKG_0653&cmdt_cd="+formObject.frm_cmdt_cd.value+"&rep_cmdt_cd="+formObject.frm_rep_cmdt_cd.value;
//				ComOpenPopup("ESM_BKG_0653.do"+param, 820, 680, callback_func,"1,0,1,1,1,1", true,false,0,0,0,popName);
	    		// Modal
				ComOpenPopup("ESM_BKG_0653.do", 820, 690, 'callBack0653',"1,0,1,1,1,1", true,false,0,0,0,'callBack0653');
	    	}else{
	    		ComSetObjValue(formObject.frm_cmdt_cd,arrVal[0][4]);
				ComSetObjValue(formObject.frm_cmdt_nm, arrVal[0][2]);
				ComSetObjValue(formObject.sc_code, arrVal[0][1]);
				ComSetObjValue(formObject.frm_rep_cmdt_cd, arrVal[0][5]);
			}
    	}
	}          
  /**
   *  function which is returned after calling CMDT screen. <br>
   * <br><b>Example :</b>
   * <pre>
   *     callBack00653(arrBal);
   * </pre>
   * @param {string}  inserting self func,ref sheet index which should be called when pop up is selected
   * @return 
   * @author 
   * @version 2009.11.25
   */    
	function callBack0653(arrVal){
  	 var formObject=document.form;
  	 		if(arrVal != null){				
				ComSetObjValue(formObject.frm_cmdt_cd, arrVal[0][3]);
				ComSetObjValue(formObject.frm_rep_cmdt_cd, arrVal[0][5]);
				ComSetObjValue(formObject.frm_cmdt_nm, arrVal[0][4]);	
			}
	}    	
   /* pop-up
    *  Pattern is not changed , but code is changed
    */ 
   function detail_info1(sheetObj, row, col)   
   {	
 	  /* Rate Detail 
 	   * 1. Rate Source - General Rate / Special Rate
 	   * 2. Pattern information
 	   * 3. Rate array ( showing Value for Text ) 
 	   * 4. Conversion 
 	   * 5. Final : USD 
       */
 	  /*
 	   *    1 : Through Rate, 
 	   *	2 : Origin ARB + Through Rate,
 	   *	3 : Through Rate + Dest ARB.
 	   *	4 : Origin ARB + Through Rate + Dest ARB
 	   *	5 : Origin IHC + Through Rate
 	   *	6 : Origin IHC + Origin ARB + Through Rate 
 	   *	7 : Origin IHC + Through Rate + Dest ARB
 	   *	8 : Origin IHC + Origin ARB + Through Rate + Dest ARB
 	   *	9 : Through Rate + Dest IHC
 	   *	10 : Origin ARB + Through Rate + Dest IHC
 	   *	11 : Origin IHC + Through Rate + Dest IHC
 	   *	12 : Origin IHC + Origin ARB + Through Rate + Dest IHC
 	   *  	13 : Origin IHC + Through Rate + Dest ARB + Dest IHC
 	   *	14 : Origin ARB + Through Rate + Dest ARB + Dest IHC
 	  */
   	  var dtl_title=""; // Detail Popup Title
 	  var pt_cd		//   classifying General Rate and Special Rate by Pattern Code
   	  var rt_string=""; //  variable which forward to Pop up like Title 
   	  var rt_dtl="";
   	  var rt_head="";
   	  var fnl_amount="";
   	  var fnl="";
   	  var typ_conv=""; //TYPE CONV
   	  var oa_typ_conv=""; // OA ARB TYP CONV 
   	  var oi_typ_conv=""; // OA IHC TYP CONV
   	  var rt_typ_conv=""; // RT TYP CONV 
   	  var da_typ_conv=""; // DA ARB TYP CONV 
   	  var di_typ_conv=""; // DA IHC TYP CONV
   	  var rt_rar_conv=""; // RT RAR CONV
   	  var rt_rac_conv=""; // RT RAC CONV
   	  var rt_rap_conv=""; // RT RAP CONV
   	  var rt_dor_conv=""; // RT DOR CONV
   	  var rt_ras_conv=""; // RT RAS CONV
   	  var chg_row1="\n" + "=================================================";
   	  var chg_row2="\n" + "--------------------------------------------------------------------------------------------------------------";
   	  var chg_row3="\n" + "=================================================";
 	  var sheetObj1=sheetObjects[1];
 	  pt_cd=sheetObj.GetCellValue(row, "rt_mtch_patt_cd") //PT TYPE
 	  fnl_amount=sheetObj.GetCellText(row,"fnl_frt_rt_amt") //FINAL AMOUNT
 	  if(pt_cd.substring(0,1) =='G'){
 		  dtl_title="General Rate"
 	  }else{ 
 		  dtl_title="Special Rate"
 	  }
	  /* TYPE CONVERSION */
 	  if(sheetObj.GetCellValue(row,"oa_typ_conv_ctnt") !=''|sheetObj.GetCellValue(row,"rt_typ_conv_ctnt") !='' | sheetObj.GetCellValue(row,"da_typ_conv_ctnt")!=''){
		  /* TYPE CONVERSION  */
		  // OA ARB TYP CONV
 		  if(sheetObj.GetCellValue(row,"oa_typ_rt_op_cd") !="+" && sheetObj.GetCellValue(row,"oa_typ_rt_op_cd" !="-") &&sheetObj.GetCellValue(row,"oa_typ_conv_ctnt") !='' ){
 			  oa_typ_conv="\n"+ sheetObj.GetCellValue(row,"oa_typ_conv_ctnt");
 		  }
		  // RT TYP CONV
 		  if(sheetObj.GetCellValue(row,"rt_typ_conv_ctnt") !=''){
 			  rt_typ_conv="\n"+ sheetObj.GetCellValue(row,"rt_typ_conv_ctnt");
		  }
		  // DA ARB TYP CONV
 		  if(sheetObj.GetCellValue(row,"da_typ_da_op_cd") !="+" && sheetObj.GetCellValue(row,"da_typ_da_op_cd" !="-") &&sheetObj.GetCellValue(row,"da_typ_conv_ctnt") !='' ){
 			  da_typ_conv="\n"+sheetObj.GetCellValue(row,"da_typ_conv_ctnt");
		  }
		  typ_conv="\n" + "TYPE CONVERSION" +
			 oa_typ_conv + rt_typ_conv + da_typ_conv +
			 "\n" + "=================================================";  
	  }
	  /* RT RAR CONVERSION */
 	  if(sheetObj.GetCellValue(row,"rt_rar_conv_ctnt") !=''){
 		  rt_rar_conv="\n" + sheetObj.GetCellValue(row,"rt_rar_conv_ctnt");
	  }
	  /* RT RAC CONVERSION */
 	  if(sheetObj.GetCellValue(row,"rt_rac_conv_ctnt") !=''){
 		  rt_rac_conv="\n" + sheetObj.GetCellValue(row,"rt_rac_conv_ctnt");
	  }
	  /* RT RAP CONVERSION */
 	  if(sheetObj.GetCellValue(row,"rt_rap_conv_ctnt") !=''){
 		  rt_rap_conv="\n" + sheetObj.GetCellValue(row,"rt_rap_conv_ctnt");
	  }
	  /* RT DOR CONVERSION */
 	  if(sheetObj.GetCellValue(row,"rt_dor_conv_ctnt") !=''){
 		  rt_dor_conv="\n" + sheetObj.GetCellValue(row,"rt_dor_conv_ctnt");
	  }
	  /* RT RAS CONVERSION */
 	  if(sheetObj.GetCellValue(row,"rt_ras_conv_ctnt") !=''){
 		  rt_ras_conv="\n" + sheetObj.GetCellValue(row,"rt_ras_conv_ctnt");
	  }
	  /* Detail logic */
	  /* 1 ROW FROM + VIA + TO + VIA */
	  /* 2 ROW TRANSMODE */
	  if(pt_cd.substr(1,4) == "0000"){
	    	 rt_head += "\nPattern 1 : THR" +
	    	 			"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	 }else if (pt_cd.substr(1,4) == "0100"){
	    	 rt_head += "\nPattern 2 : OAR + THR"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ; 
	 }else if (pt_cd.substr(1,4) == "0010"){
	    	 rt_head += "\nPattern 3 : THR + DAR"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	 }else if (pt_cd.substr(1,4) == "0110"){
	    	 rt_head += "\nPattern 4 : OAR + THR + DAR"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	 }else if (pt_cd.substr(1,4) =="1000"){
	    	 rt_head += "\nPattern 5 : OIH + THR"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	 }else if (pt_cd.substr(1,4) =="1100"){
	    	 rt_head += "\nPattern 6 : OIH + OAR + THR"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	 }else if (pt_cd.substr(1,4) =="1010"){
	    	 rt_head += "\nPattern 7 : OIH + THR + DAR"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	 }else if (pt_cd.substr(1,4) =="1110"){
	    	 rt_head += "\n" +	"Pattern 8 : OIH + OAR + THR + DAR"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	 }else if (pt_cd.substr(1,4) =="0001"){
	    	 rt_head += "\nPattern 9 : THR + DIH"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	 }else if (pt_cd.substr(1,4) =="0101"){
	    	 rt_head += "\nPattern 10 : OAR + THR + DIH"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	 }else if (pt_cd.substr(1,4) =="1001"){
	    	 rt_head += "\nPattern 11 : OIH + THR + DIH"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	 }else if (pt_cd.substr(1,4) =="1101"){
	    	 rt_head += "\nPattern 12 : OIH + OAR + THR + DIH"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	 }else if (pt_cd.substr(1,4) =="1011"){
	    	 rt_head += "\nPattern 13 : OIH + THR + DAR + DIH"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	 }else if (pt_cd.substr(1,4) == "0111"){
	    	 rt_head += "\nPattern 14 : OAR + THR + DAR + DIH"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	 }else if (pt_cd.substr(1,4) =="0011"){
	    	 rt_head += "\nPattern 15 : THR + DAR + DIH"+
	 					"\n" +	"--------------------------------------------------------------------------------------------------------------" ;
	 }
	  	// getting _amt cost by sheetObj.CellText(to show 2digit)
	  	if(pt_cd.substr(1,1) == 1){
/*    Ori IHC   */	rt_dtl +="\n" +	'OIH : ' + sheetObj.GetCellValue(row,"oi_rout_pnt_loc_def_cd")+ ' - ' + sheetObj.GetCellValue(row,"oi_via_port_def_cd")+' - '+ sheetObj.GetCellValue(row,"oi_dir_call_flg")+' - '+ sheetObj.GetCellValue(row,"oi_rat_ut_cd")+
' - ' + sheetObj.GetCellValue(row,"oi_prc_cgo_tp_cd")+' - ' + sheetObj.GetCellValue(row,"oi_prc_trsp_mod_cd")+' - ' + sheetObj.GetCellValue(row,"oi_rcv_de_term_cd")+' - ' + sheetObj.GetCellValue(row,"oi_prc_cmdt_def_cd")+' - ' + sheetObj.GetCellValue(row,"oi_curr_cd")+' - '+ sheetObj.GetCellText(row,"oi_fnl_frt_rt_amt")+' - ' + sheetObj.GetCellValue(row,"oa_rout_pnt_loc_def_cd") ;
	  	}
	  	if(pt_cd.substr(2,1) == 1){
/*    Ori ARB   */	rt_dtl +="\n" +	'OAR : ' +sheetObj.GetCellValue(row,"oa_rout_pnt_loc_def_cd")+ ' - '+ sheetObj.GetCellValue(row,"oa_via_port_def_cd")+' - ' + sheetObj.GetCellValue(row,"oa_bse_port_def_cd")+
' - ' + sheetObj.GetCellValue(row,"oa_prc_trsp_mod_cd")+' - ' + sheetObj.GetCellValue(row,"oa_rcv_de_term_cd")+' - ' + sheetObj.GetCellValue(row,"oa_curr_cd")+' - ';
	  											if(sheetObj.GetCellText(row,"rt_arb_frt_rt_amt")!= 0){
rt_dtl += sheetObj.GetCellText(row,"rt_arb_frt_rt_amt") + " (FIXED)" +  ' - ' + sheetObj.GetCellValue(row,"eq_subst_cntr_tpsz_cd")+' - ' + sheetObj.GetCellValue(row,"cgo_cate_cd") ;
	  											}else{
rt_dtl += sheetObj.GetCellText(row,"oa_fnl_frt_rt_amt") +  ' - ' + sheetObj.GetCellValue(row,"oa_rat_ut_cd")+' - ' + sheetObj.GetCellValue(row,"oa_prc_cgo_tp_cd") ;
	  											}
	  	}
/* Through Rate */	rt_dtl +="\n" +	'THR : '+ sheetObj.GetCellValue(row,"op_rout_pnt_loc_def_cd")+' - '+sheetObj.GetCellValue(row,"ov_rout_via_port_def_cd")+' - '+ sheetObj.GetCellValue(row,"dv_rout_via_port_def_cd")+' - '+ sheetObj.GetCellValue(row,"dp_rout_pnt_loc_def_cd") +
' - '+ sheetObj.GetCellValue(row,"trns_mod_cd")+' - '+ sheetObj.GetCellValue(row,"rcv_de_term_cd")+' - '+ sheetObj.GetCellValue(row,"curr_cd")+' - '+ sheetObj.GetCellText(row,"rt_fnl_frt_rt_amt")+' - '+ sheetObj.GetCellValue(row,"rt_rat_ut_cd")+' - '+ sheetObj.GetCellValue(row,"rt_prc_cgo_tp_cd") ;
	  	if(pt_cd.substr(3,1) == 1){
/*	Dest ARB   */	rt_dtl +="\n" +	'DAR : ' + sheetObj.GetCellValue(row,"da_bse_port_def_cd")+ ' - ' + sheetObj.GetCellValue(row,"da_via_port_def_cd")+' - '+ sheetObj.GetCellValue(row,"da_rout_pnt_loc_def_cd")+' - ' + sheetObj.GetCellValue(row,"da_prc_trsp_mod_cd")+' - ' + sheetObj.GetCellValue(row,"da_rcv_de_term_cd")+' - ' + sheetObj.GetCellValue(row,"da_curr_cd")+' - ';
	  											if(sheetObj.GetCellText(row,"rt_add_frt_rt_amt") != 0){
rt_dtl += sheetObj.GetCellText(row,"rt_add_frt_rt_amt") + " (FIXED)" +  ' - ' + sheetObj.GetCellValue(row,"eq_subst_cntr_tpsz_cd")+' - ' + sheetObj.GetCellValue(row,"cgo_cate_cd") ;
	  											}else{
rt_dtl += sheetObj.GetCellText(row,"da_fnl_frt_rt_amt") + ' - '+ sheetObj.GetCellValue(row,"da_rat_ut_cd") + ' - ' + sheetObj.GetCellValue(row,"da_prc_cgo_tp_cd");
	  											}
	  	}
	  	if(pt_cd.substr(4,1) == 1){
/*  Dest IHC   */	rt_dtl +="\n" +	'DIH : ' + sheetObj.GetCellValue(row,"di_bse_port_def_cd")+ ' - ' + sheetObj.GetCellValue(row,"di_via_port_def_cd")+' - '+ sheetObj.GetCellValue(row,"di_rout_pnt_loc_def_cd")+' - ' + sheetObj.GetCellValue(row,"di_prc_trsp_mod_cd")+' - ' + sheetObj.GetCellValue(row,"di_rcv_de_term_cd")+' - ' + sheetObj.GetCellValue(row,"di_curr_cd")+' - '+ sheetObj.GetCellText(row,"di_fnl_frt_rt_amt")+' - '+ sheetObj.GetCellValue(row,"di_rat_ut_cd")+
' - ' + sheetObj.GetCellValue(row,"di_prc_cgo_tp_cd");
	  	}
	  	
	  	if(sheetObj.GetCellValue(row, "multi_curr") == "Y"){
	  		var arrMulti = [ ["","","N","N"],["","","N","N"],["","","N","N"],["","","N","N"],["","","N","N"] ];	//curr_cd, amt, display_yn, sum_yn
	  		
	  		if(pt_cd.substr(1,1) == 1){
	  			arrMulti[0][0] = sheetObj.GetCellValue(row,"oi_curr_cd");
	  			arrMulti[0][1] = sheetObj.GetCellText(row,"oi_fnl_frt_rt_amt");
	  		}
	  		if(pt_cd.substr(2,1) == 1){
	  			if(sheetObj.GetCellText(row,"rt_arb_frt_rt_amt")!= 0){
		  			arrMulti[1][0] = sheetObj.GetCellValue(row,"oa_curr_cd");
		  			arrMulti[1][1] = sheetObj.GetCellText(row,"rt_arb_frt_rt_amt");
	  			}else{
		  			arrMulti[1][0] = sheetObj.GetCellValue(row,"oa_curr_cd");
		  			arrMulti[1][1] = sheetObj.GetCellText(row,"oa_fnl_frt_rt_amt");
	  			}
	  		}
	  		arrMulti[2][0] = sheetObj.GetCellValue(row,"curr_cd");
	  		arrMulti[2][1] = sheetObj.GetCellText(row,"rt_fnl_frt_rt_amt");
	  		if(pt_cd.substr(3,1) == 1){
	  			if(sheetObj.GetCellText(row,"rt_add_frt_rt_amt") != 0){
	  		  		arrMulti[3][0] = sheetObj.GetCellValue(row,"da_curr_cd");
	  		  		arrMulti[3][1] = sheetObj.GetCellText(row,"rt_add_frt_rt_amt");
	  			}else{
	  		  		arrMulti[3][0] = sheetObj.GetCellValue(row,"da_curr_cd");
	  		  		arrMulti[3][1] = sheetObj.GetCellText(row,"da_fnl_frt_rt_amt");
	  			}
	  		}
	  		if(pt_cd.substr(4,1) == 1){
  		  		arrMulti[4][0] = sheetObj.GetCellValue(row,"di_curr_cd");
  		  		arrMulti[4][1] = sheetObj.GetCellText(row,"di_fnl_frt_rt_amt");
	  		}
	  		for(var i=0; i<arrMulti.length; i++){
	  			if(arrMulti[i][0]=="")		continue;
	  			if(arrMulti[i][3]=="Y")		continue;
	  			
	  			arrMulti[i][2] = "Y";
	  			for(var j=i+1; j<arrMulti.length; j++){
		  			if(arrMulti[j][0]=="")		continue;
		  			if(arrMulti[j][3]=="Y")		continue;
		  			
		  			if(arrMulti[i][0] == arrMulti[j][0]){
		  				arrMulti[i][1] = arrMulti[i][1] + arrMulti[j][1];
		  				arrMulti[j][3] = "Y";
		  			}
	  			}
	  		}
	  		var o_fnl = "";
	  		for(var i=0; i<arrMulti.length; i++){
	  			if(arrMulti[i][2]=="Y"){
	  				o_fnl+=arrMulti[i][0]+" "+arrMulti[i][1]+"\n";
	  			}
	  		}
	  		fnl="\n=================================================\nFINAL : \n"+o_fnl;
	  	}else{
//	  		fnl="\n=================================================\nFINAL : USD " + fnl_amount;  
	  		fnl="\n=================================================\nFINAL : " + sheetObj.GetCellValue(row,"curr_cd") + " " + fnl_amount;
	  	}
		  //  encodeURIComponent 
//		  rt_string += encodeURIComponent(dtl_title + chg_row1 + rt_head+ rt_dtl + chg_row1 + typ_conv + rt_rar_conv + rt_rac_conv + rt_rap_conv + rt_dor_conv + rt_ras_conv + fnl) ;
  		rt_string += (dtl_title + chg_row1 + rt_head+ rt_dtl + chg_row1 + typ_conv + rt_rar_conv + rt_rac_conv + rt_rap_conv + rt_dor_conv + rt_ras_conv + fnl) ;
	  	  value=dtl_title + '$$' + rt_string;
	  	  return value ;
   }
    /* 2010.04.19 VERSION UP*/
/* the end of developer's work */
