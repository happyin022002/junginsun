/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1076.js
*@FileTitle  :  TAA Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
           MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
           Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
/**
 * @fileoverview 
* @author CLT
 */
/**
 * @extends 
 * @class esm_bkg_1076 : esm_bkg_1076 - task script definition for screen
 */
	// public variable
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		if (document.form.bkg_no.value == '') {
			ComShowCodeMessage("BKG00463");// There's no BKG no for retrieve
			ComClosePopup(); 
		}
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			sheetObjects[i].SetWaitImageVisible(0);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
		var formObject=document.form;
		var rCntr_cdr_dt=formObject.application_date.value.substr(0,4)+'-'+formObject.application_date.value.substr(4,2)+'-'+formObject.application_date.value.substr(6,2) ;		
		ComSetObjValue(formObject.frm_cntr_cdr_dt, rCntr_cdr_dt);
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	var ee_arr=[82,76,65,88,79,82,85,68];
	var ee_idx=0;
	
	function initControl() {
		var formObj=document.form;
	}
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
	 * 
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
			      SetEditable(1);
			      SetSheetHeight(212);
	            }
			break;
			
		case "sheet1":
		    with(sheetObj){
		      var HeadTitle1="";
		      var headCount=23;
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_no" },
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
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"taa_no" } ];
		      	InitColumns(cols);
		      	SetEditable(1);
		      	SetVisible(0);
            }
			break;
			
		case "sheet2":
		    with(sheetObj){
			      var HeadTitle1="";
			      var headCount=16;
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
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"p_cust_nm" } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetVisible(0);
	            }
			break;
			
		case "sheet3":
		    with(sheetObj){
			      var HeadTitle1=" |PT|Commodity Description|POR|POL|POD|DEL|R/D|Per|CGO\nTP|Cur|Amount|Trans Mode\n(O/D)|Q’TY|Rate\nDetail |Route\nNote |ARB\nNote|O.IHC WGT\n(Ton<=)|O.IHC WGT\n(<Ton)|O.ARB WGT\n(Ton<=)|O.ARB WGT\n(<Ton)|D.ARB WGT\n(Ton<=)|D.ARB WGT\n(<Ton)|D.IHC WGT\n(Ton<=)|D.IHC WGT\n(<Ton)|multi_curr|";
			      var headCount=90;
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"_flg",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rt_mtch_patt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_nm",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rcv_de_term_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"fnl_frt_rt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trns_mod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:45,   Align:"Right",   ColMerge:1,   SaveName:"op_cntr_qty",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dtl",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"note",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
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
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ctrt_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"prc_rt_mtch_patt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"prop_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bq_seq",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_bq_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ctrt_cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rcv_term_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"de_term_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dry_cgo_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"awk_cgo_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dcgo_flg",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rc_flg",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bb_cgo_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"soc_flg",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cmdt_hdr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rout_seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_seq",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cgo_cate_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bq_por_appl_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bq_pol_appl_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bq_pod_appl_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bq_del_appl_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bq_por_rly_port_appl_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bq_pst_rly_port_appl_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_add_chg_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_add_chg_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cm_prc_cmdt_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cm_prc_cmdt_def_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
//			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rcv_term_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
//			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"de_term_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"op_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ov_rout_via_port_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dv_rout_via_port_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dp_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"op_prc_trsp_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dp_prc_trsp_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rat_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_prc_cgo_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_fnl_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_app_bkg_conv_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_app_note_conv_mapg_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_app_note_conv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_app_note_conv_rule_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_app_note_conv_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_app_rt_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_app_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_app_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_ras_bkg_conv_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_ras_note_conv_mapg_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_ras_note_conv_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_ras_note_conv_rule_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_ras_note_conv_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_ras_rt_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_ras_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_ras_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_bse_port_def_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_rat_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_prc_cgo_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_prc_trsp_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_rcv_de_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_fnl_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_calc_frt_rt_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_bse_port_def_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rat_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_prc_cgo_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_prc_trsp_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_rcv_de_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_fnl_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_calc_frt_rt_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_typ_rt_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_typ_conv_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_bse_port_def_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_rat_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_prc_cgo_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_prc_trsp_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_rcv_de_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_fnl_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_calc_frt_rt_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_bse_port_def_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rat_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_prc_cgo_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_prc_trsp_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_rcv_de_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_fnl_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_calc_frt_rt_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_typ_da_op_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_typ_conv_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"por_mtch_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"del_mtch_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_typ_conv_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_rac_conv_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oih_flg",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dih_flg",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"prc_gen_spcl_rt_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"prc_cmdt_hdr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"prc_rout_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"prc_rt_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"tri_prop_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"note_ctnt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"arb_note_ctnt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_typ_conv_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_calc_frt_rt_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dp_seq",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_subst_cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oi_frt_term_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oa_frt_term_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"da_frt_term_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"di_frt_term_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetSheetHeight(150);
	      		}
			break;
			
		case "sheet4": //Surcharge
		    with(sheetObj){
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
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"tax_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"tax_cnt_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetSheetHeight(162);
	            }
			break;
			
		case "sheet5": //Break Down logic
		    with(sheetObj){
			      var HeadTitle1=" Charge |Cur |Rate |Rate as |Per |Amount |IN |Term |Cargo |rcv Term |DeTerm |IMO |M | Hide ";
			      var headCount=31;
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"chg_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"chg_ut_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"rat_as_qty",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"chg_amt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"incl_oft_flg",   		 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
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
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"tri_prop_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_subst_cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"por_mtch_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"del_mtch_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetSheetHeight(162);
	            }
			break;
		}
	}
	//Event handler processing by button name */
	function processButtonClick() {
		/***** If sheets are more than 2 in one tab, use additional sheet variables *****/
		var sheetObject0=sheetObjects[0];
		var sheetObject1=sheetObjects[1];
		var sheetObject2=sheetObjects[2];
		var sheetObject3=sheetObjects[3];
		var sheetObject4=sheetObjects[4];
		var sheetObject5=sheetObjects[5];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn_Select":
					var rArray=new Array();
					var formObj=document.form;
					var sheetObj0=sheetObjects[0];
					var sheetObj1=sheetObjects[1];
					var sheetObj3=sheetObjects[3];
					var sheetObj4=sheetObjects[4];
					var sheetObj5=sheetObjects[5];
					/* Multi rate add */
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
					//  compare sheet with comparison sheet
					var tmpPertpsz='';  
					var tmpCgo='';  
					var tmpPersub='';
					var tmpQty1A=0;
					var comPer='';
					var comQty=0;
					var cflag=false;
					var t_Tpsz_cd='';  
					var t_Qty1A=0;
					// original sheet
					 for ( var i=1; i <= cnt0_row; i++){
						tmpPertpsz=sheetObj0.GetCellValue(i,"cntr_tpsz_cd");
						tmpCgo=sheetObj0.GetCellValue(i,"cgo");
						tmpPersub=sheetObj0.GetCellValue(i,"eq_sub");
						tmpQty1A=sheetObj0.GetCellValue(i,"qty");
						// comparison sheet 
						for ( var ix=1; ix <= cnt3_row; ix++){						
							comPer=sheetObj3.GetCellValue(ix,"cntr_tpsz_cd");
							if(comPer == '20') comPer='D2';
							if(comPer == '40') comPer='D4';
							// among checked
							if(sheetObj3.GetCellValue(ix,"_flg") == 1){
								//alert(tmpPertpsz +"::::"+ comPer+";;;"+sheetObj3.CellValue(ix,"prc_cgo_tp_cd")+";;"+tmpCgo);
								//If per_tpsz type and sub_per type are same
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
						if (cflag){
							cflag=false; 
							if(t_Qty1A != comQty){
								if(tmpQty1A < comQty){ 
									ComShowMessage("Dose not match with BKG quantity!"); 
									return;
								}
							} else if(tmpQty1A > comQty ){
								if(!ComShowConfirm("Dose not match with BKG quantity! do you want to continue ?")){
									return;
								}
							} else{
								var tPer='';
								var tCgo='';
								var tpor='';
								var tpol='';
								var tpod='';
								var tdel='';
								for ( var ix=1; ix <= cnt3_row; ix++){				
									// among checked
									if(sheetObj3.GetCellValue(ix,"_flg") == 1){
										if(tPer == sheetObj3.GetCellValue(ix,"rat_ut_cd") && tCgo == sheetObj3.GetCellValue(ix,"cgo_tp_cd")){
											tpor=sheetObj3.GetCellValue(ix,"bkg_por_cd");
											tpol=sheetObj3.GetCellValue(ix,"bkg_pol_cd");
											tpod=sheetObj3.GetCellValue(ix,"bkg_pod_cd");
											tdel=sheetObj3.GetCellValue(ix,"del_cd");
											if( tpor  != sheetObj3.GetCellValue(ix,"bkg_por_cd") || tpol  != sheetObj3.GetCellValue(ix,"bkg_pol_cd") || tpod  != sheetObj3.GetCellValue(ix,"bkg_pod_cd") || tdel  != sheetObj3.GetCellValue(ix,"del_cd") ){
												if (!ComShowConfirm("Do you want to select 'MULTI-RATE' ?")){
													return;	
												} else{
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
//								 ComShowMessage("You cannot select rate including mixed currencies because 'Break Down' is unticked. Please tick that check box.");
								 ComShowCodeMessage("BKG08335");
								 return;
							 }
						 }
					 }
					 
					/**
					 3. ESM_BKG_0079_08 
					 ＊ Per Type is selected, if less Per Type is not selected, the Rate is .00, Rate As the TP / SZ QTY, Amount .00 marked
					 ＊ Per Type is selected, each divided by the number if you choose low doeeojin Per Type Amount separated from each other by inserting the values ​​displayed differently
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
					 		var obj=new Object();// value setting
					 		obj.tpsz_cd=tpsz_cd1;
					 		obj.tpsz_qty=cnt;
					 		pArray[x++]=obj;
					 	}
					 }
					 	sheetObj5.RemoveAll();// sheet initialization
						var idx=0;
						for ( var ix=1; ix <= cnt3_row; ix++) {
							if (sheetObj3.GetCellValue(ix,"_flg") == 1){
								var newRow=sheetObj5.DataInsert(-1);
								var obj=new Object(); // value setting
									obj.charge='OFT';
									obj.cur=sheetObj3.GetCellValue(ix, "curr_cd");
									obj.rate=sheetObj3.GetCellValue(ix, "rt_calc_frt_rt_amt");
									obj.rate_as=sheetObj3.GetCellValue(ix, "op_cntr_qty");
									obj.per=sheetObj3.GetCellValue(ix, "rat_ut_cd");
									obj.cargo=sheetObj3.GetCellValue(ix, "cgo_cate_cd");
									obj.term=sheetObj3.GetCellValue(ix, "rcv_term_cd") +"/"+ sheetObj3.GetCellValue(ix,"de_term_cd");
									obj.term_cd=formObj.term_cd.value;
									obj.imo=sheetObj3.GetCellValue(ix, "imdg_clss_cd");
									obj.prcPttCd=sheetObj3.GetCellValue(ix,"rt_mtch_patt_cd").substr(0,4);
									obj.propNo=sheetObj3.GetCellValue(ix, "prop_no");
									obj.amdtSeq=sheetObj3.GetCellValue(ix, "amdt_seq");
									obj.svcScpCd=sheetObj3.GetCellValue(ix, "svc_scp_cd");
									obj.incl='N';
									obj.m='A';
									obj.rat_ut2_cd=sheetObj3.GetCellValue(ix, "cntr_tpsz_cd");
									obj.rat_ut3_cd=sheetObj3.GetCellValue(ix, "eq_subst_cntr_tpsz_cd");
									rArray[idx++]=obj;
									sheetObj5.SetCellValue(newRow, "chg_cd"		       ,'OFT');
									sheetObj5.SetCellValue(newRow, "curr_cd"	           ,sheetObj3.GetCellValue(ix, "curr_cd"	        ));
									sheetObj5.SetCellValue(newRow, "chg_ut_amt"	   ,sheetObj3.GetCellValue(ix, "rt_calc_frt_rt_amt"	));
									sheetObj5.SetCellValue(newRow, "rat_as_qty"	       ,sheetObj3.GetCellValue(ix, "op_cntr_qty"	        ));
									sheetObj5.SetCellValue(newRow, "rat_ut_cd"	           ,sheetObj3.GetCellValue(ix, "rat_ut_cd"	        ));
									sheetObj5.SetCellValue(newRow, "chg_amt"	       ,sheetObj3.GetCellValue(ix, "rt_fnl_frt_rt_amt") * sheetObj3.GetCellValue(ix, "op_cntr_qty"));
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
									sheetObj5.SetCellValue(newRow, "tri_prop_no"           ,sheetObj3.GetCellValue(ix, "tri_prop_no"             ));
									sheetObj5.SetCellValue(newRow, "por_mtch_flg"		   ,sheetObj3.GetCellValue(ix, "por_mtch_flg"         ));
									sheetObj5.SetCellValue(newRow, "del_mtch_flg"		   ,sheetObj3.GetCellValue(ix, "del_mtch_flg"         ));
									sheetObj5.SetCellValue(newRow, "eq_subst_cntr_tpsz_cd"		   ,sheetObj3.GetCellValue(ix, "eq_subst_cntr_tpsz_cd"         ));
									sheetObj5.SetCellValue(newRow, "ibflag"               ,"U");
									var comp1_cd=sheetObj3.GetCellValue(ix,"rat_ut_cd");
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
					 			var pt_cd=sheetObj3.GetCellValue(ix,"rt_mtch_patt_cd").substr(0,4); // PT TYPE
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
						 				obj.term_cd=sheetObj3.GetCellValue(ix, "oa_frt_term_cd");
					 					obj.imo=sheetObj3.GetCellValue(ix, "imdg_clss_cd");
						 				obj.incl='N';
						 				obj.m='A';
										/* forwarding the value from OFT to see the Note in Charge */
										obj.prcPttCd=sheetObj3.GetCellValue(ix,"rt_mtch_patt_cd").substr(0,4);
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
										obj.term_cd=sheetObj3.GetCellValue(ix, "oi_frt_term_cd");
										obj.imo=sheetObj3.GetCellValue(ix,  "imdg_clss_cd");
						 				obj.incl='N';
						 				obj.m='A';
										/* forwarding the value from OFT to see the Note in Charge */
										obj.prcPttCd=sheetObj3.GetCellValue(ix,"rt_mtch_patt_cd").substr(0,4);
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
						 				obj.term_cd=sheetObj3.GetCellValue(ix, "da_frt_term_cd");
						 				obj.imo=sheetObj3.GetCellValue(ix, "imdg_clss_cd");
						 				obj.incl='N';
						 				obj.m='A';
										/* forwarding the value from OFT to see the Note in Charge */
										obj.prcPttCd=sheetObj3.GetCellValue(ix,"rt_mtch_patt_cd").substr(0,4);
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
						 				obj.term_cd=sheetObj3.GetCellValue(ix, "di_frt_term_cd");
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
//					for( var j=1; j <= cnt3_row; j++){
//						if(sheetObj3.GetCellValue(j, "_flg") == 1){
//							if(sheetObj3.GetCellValue(j, "por_mtch_flg") == "N" ){
//								var obj=new Object(); //value setting
//								if(sheetObj3.GetCellValue(b,"rcv_term_cd")=="Y"){
//									obj.charge='OAR';
//								}else{
//									obj.charge='OIH';
//								}
////								obj.charge='OIH';
//								obj.curr='';
//								obj.rate='';
//								obj.rate_as='';
//								obj.per='';
//								obj.cargo=sheetObj3.GetCellValue(j,"cgo_cate_cd");
//								obj.incl='N';
//								obj.term_cd=formObj.term_cd.value;
//								obj.term=sheetObj3.GetCellValue(j,"rcv_term_cd") +"/"+ sheetObj3.GetCellValue(j,"de_term_cd");
//								obj.imo=sheetObj3.GetCellValue(j, "imdg_clss_cd");
//								obj.m='A';
//								rArray[idx++]=obj;
//							}
//							if(sheetObj3.GetCellValue(j, "del_mtch_flg") =="N"){
//								var obj=new Object(); //value setting
//								if(sheetObj3.GetCellValue(b,"de_term_cd")=="Y"){
//									obj.charge='DAR';
//								}else{
//									obj.charge='DIH';
//								}
////								obj.charge='DIH';
//								obj.curr='';
//								obj.rate='';
//								obj.rate_as='';
//								obj.per='';
//								obj.cargo=sheetObj3.GetCellValue(j,"cgo_cate_cd");
//								obj.incl='N';
//								obj.term_cd=formObj.term_cd.value;
//								obj.term=sheetObj3.GetCellValue(j,"rcv_term_cd") +"/"+ sheetObj3.GetCellValue(j,"de_term_cd");
//								obj.imo=sheetObj3.GetCellValue(j, "imdg_clss_cd");
//								obj.m='A';
//								rArray[idx++]=obj;
//							}
//						}	
//					}
					
				    doActionIBSheet(sheetObject5, formObj, IBSAVE);
					
					var sch=sheetObjects[4].GetTotalRows();
										 
					for ( var i=1; i <= sch; i++)
					{
						var obj=new Object(); //value setting
						obj.charge=sheetObj4.GetCellValue(i,"chg_cd");
						obj.cur=sheetObj4.GetCellValue(i,"curr_cd");
						obj.rate=sheetObj4.GetCellValue(i,"chg_ut_amt");
						obj.rate_as=sheetObj4.GetCellValue(i,"rat_as_qty");
						obj.per=sheetObj4.GetCellValue(i,"rat_ut_cd");
						obj.amt=sheetObj4.GetCellValue(i,"chg_amt");
						obj.cargo=sheetObj4.GetCellValue(i,"cgo_tp_cd");
						obj.incl=sheetObj4.GetCellValue(i,"incl_oft_flg");
						obj.term_cd=sheetObj4.GetCellValue(i,"frt_term_cd");
						obj.term=sheetObj4.GetCellValue(i,"rcv_term_cd") +"/"+ sheetObj4.GetCellValue(i,"de_term_cd");
						obj.imo=sheetObj4.GetCellValue(i,"imdg_clss_cd");
						obj.incl=sheetObj4.GetCellValue(i,"frt_incl_xcld_div_cd");
						obj.tax=sheetObj4.GetCellValue(i,"tax_flg");	//tax_flg
						obj.taxcnt=sheetObj4.GetCellValue(i,"tax_cnt_cd");
						obj.m='A';
						rArray[idx++]=obj;
					}
					
					for ( var ix=1; ix <= cnt3_row; ix++) {
						if (sheetObj3.GetCellValue(ix,"_flg") == 1){
							var _obj=new Object(); //value setting
							_obj.actionType="TAA_No";
							_obj.tripropno=sheetObj3.GetCellValue(ix,"tri_prop_no");
							rArray[idx++]=_obj;
						}
					}
					
					if( rArray.length > 1 ){					
					ComPopUpReturnValue(rArray); //retVal variables value setting.
					}else{
					ComClosePopup(); 
					}
					
				break;
			case "btn_Close":
				var idx=0;
				var formObj=document.form;
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
						doActionIBSheet(sheetObject5, formObj, SEARCH03);
					var sch=sheetObjects[4].GetTotalRows();
					if(sch == 0 ){
						var obj=new Object(); //value setting
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
								var obj=new Object(); //value setting
								obj.charge=sheetObj4.GetCellValue(i,"chg_cd");
								obj.cur=sheetObj4.GetCellValue(i,"curr_cd");
								obj.rate=sheetObj4.GetCellValue(i,"chg_ut_amt");
								obj.rate_as=sheetObj4.GetCellValue(i,"rat_as_qty");
								obj.per=sheetObj4.GetCellValue(i,"rat_ut_cd");
								obj.amt=sheetObj4.GetCellValue(i,"chg_amt");
								obj.cargo=sheetObj4.GetCellValue(i,"cgo_tp_cd");
								obj.incl=sheetObj4.GetCellValue(i,"incl_oft_flg");
								obj.term_cd=sheetObj4.GetCellValue(i,"frt_term_cd");
								obj.term=sheetObj4.GetCellValue(i, "rcv_term_cd") + "/"+ sheetObj4.GetCellValue(i, "de_term_cd");
								obj.imo=sheetObj4.GetCellValue(i,"imdg_clss_cd");
								obj.incl=sheetObj4.GetCellValue(i,"frt_incl_xcld_div_cd");
								obj.tax=sheetObj4.GetCellValue(i,"tax_flg");	//tax_flg
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
					
//					alert( rArray.lengt );
					if( rArray.length > 1 ){					
						ComPopUpReturnValue(rArray); //retVal variables value setting.
					}else{
					ComClosePopup(); 
					}
					
				break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				alert("지금은 사용하실 수가 없습니다 ");
				bkg_error_alert(e);
			} else {
				alert(e);
				bkg_error_alert(e);
			}
		}
	}
		// handling sheet process
		function doActionIBSheet(sheetObj, formObj, sAction) {
			sheetObj.ShowDebugMsg(false);
			switch (sAction) {
			case IBSEARCH: //retrieve1
					try{
						// sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true); 
						//1. selected value setting
						ComSetObjValue(formObj.f_cmd, SEARCH);
						// 2.retrieve execute
						var sXml=sheetObj.GetSearchData("ESM_BKG_1076GS.do", FormQueryString(formObj));
						pagedMaxCnt=sheetObj.HeaderRows();
						// variables initialization for changing color
						var formObj=document.form;
						// 3.result handling After retrieve
						var arrXml=sXml.split("|$$|");
						var State=ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY");
						/* add retrieve success and fail */
						if (State != "S"){
							ComShowCodeMessage('BKG00450');
						}
						
						for ( var inx=0; inx < arrXml.length; inx++) {	
							sheetObjects[inx].LoadSearchData(arrXml[inx],{Sync:1} );	
						}						
						formObj.frm_frt_term_cd.value=ComGetObjValue(formObj.term_cd); 
						
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
			case SEARCH01: // retrieve1
				try{
					ComSetObjValue(formObj.frm_svc_scp_cd, formObj.svc_scp_cd.value);	
					ComSetObjValue(formObj.f_cmd, SEARCH01);
					// sheetObj.DoSearch("ESM_BKG_1076GS.do", FormQueryString(formObj) );
					var sXml=sheetObj.GetSearchData("ESM_BKG_1076GS.do", FormQueryString(formObj));					
					sheetObj.LoadSearchData(sXml,{Sync:0} );
					
					ComOpenWait(false); 
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
				
			case IBSAVE: //  save temporary table for Surcharge
								
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value=MULTI;
				sheetObj.SetWaitImageVisible(0);			
				ComOpenWait(true);
				var sParam=ComGetSaveString(sheetObjects[5]);
				sParam += "&" + FormQueryString(formObj);				
				var SaveXml=sheetObj.GetSaveData("ESM_BKG_1076GS.do", sParam);				
				var sheetObject4=sheetObjects[4];			
				sheetObjects[4].LoadSaveData(SaveXml);			
				break;
				
			case SEARCH03: //If you click Close button,charge only  Surcharge
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value=SEARCH03;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				sParam += "&"+ FormQueryString(formObj);
				var SaveXml=sheetObj.GetSaveData("ESM_BKG_0739GS.do", sParam);
				var sheetObject4=sheetObjects[4];
				sheetObjects[4].LoadSaveData(SaveXml);
				break;	
			}
			ComOpenWait(false);
		}
		
		

		function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
			var formObj=document.form;
			
			// HTML variable and Binding 	
			IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");						
			var _row=sheetObjects[1].LastRow();
			if(_row == 0) return;
			ComSetObjValue(formObj.frm_act_wgt, sheetObjects[1].GetCellText(_row, "act_wgt"));// Weight
			ComSetObjValue(formObj.frm_meas_qty, sheetObjects[1].GetCellText(_row, "meas_qty"));// Measure

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
			
			// HTML variable and Binding 	
			IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");	
			
			doActionIBSheet(sheetObjects[3], formObj, SEARCH01);	//retrieve execute
		}
		
		/**
		 * event occured after Sheet retrieve
		 */
		var pageMaxCnt=1;
		function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		 	var formObj=document.form;
			var c_row=sheetObj.LastRow();
		    var multiCnt=0;
			var redColor="#FF0000";
			
			for(var i=1; i <= c_row; i++){
//				if(sheetObj.GetCellValue(row, "nt") != ''){
//					sheetObj.SetCellFontColor(row,"nt_v","#FF0000");
//				}
				
				var note=sheetObj.GetCellValue(i, "note_ctnt");
				if (!note.length == 0)
				{		
					sheetObj.SetCellValue(i,"note","Y");
					sheetObj.SetCellFontColor(i,15,redColor);
				} else{
					sheetObj.SetCellValue(i,"note","N");
				}
				
				var arb_note=sheetObj.GetCellValue(i, "arb_note_ctnt");
				if (!arb_note.length == 0)
				{		
					sheetObj.SetCellValue(i,"arb_note","Y");
				 	sheetObj.SetCellFontColor(i,16,redColor);
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
			
		 	pageMaxCnt=sheetObj.LastRow();
		 	c_row=0;
			sheetObj.ColumnSort("dp_seq");
			
			
			var obj =  document.getElementById('multi_curr_msg');
			if(multiCnt>0){
				obj.style.display = "Inline";
			}else{
				obj.style.display = "none";
			}
			
			obj =  document.getElementById('span_multi_curr_msg');
			if(multiCnt>0){
				obj.innerHTML = "*Freight Amount in red color has mixed currencies. Please click Rate Detail to check currency breakdowns.";
			}else{
				obj.innerHTML = "";
			}
			
			
			
			ComOpenWait(false);
			
		}
		
		
		 
		/**
		 * Mouse over
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
		  *  Remark MemoPad 
		  */
		function sheet3_OnClick(sheetObj, row, col, value) {
			  var rt_data=detail_info(sheetObj, row, col);
			  var id=rt_data.lastIndexOf('$$');
			  var rfa_data=rt_data.substring(id+2,rt_data.length);
			  var note_ctnt=sheetObj.GetCellValue(row,"note_ctnt");
			  if(sheetObj.ColSaveName(col) == "dtl"){
				  if(sheetObj.GetCellValue(row,"dtl") == '' ) return;
//				  var param="?title="+"Detail_INFO"+"&text="+rfa_data;
				  var param="?title=Detail_INFO&pgmId=1076&sheetIdx=3&sheetRow="+row+"&sheetCol="+col;
				  ComOpenPopup('/opuscntr/ESM_BKG_0988.do'+param, 550, 335, 'Detail INFO','0,0', true);
			  }
			  if(sheetObj.ColSaveName(col) == "note"){
				  if(sheetObj.GetCellValue(row,"note_ctnt") == '' ) return;
//				  var param="?title="+"NOTE CONV"+"&text="+encodeURIComponent(note_ctnt);
				  var param="?title=NOTE CONV&sheetIdx=3&sheetRow="+row+"&sheetCol="+col;
				  ComOpenPopup('/opuscntr/ESM_BKG_0988.do'+param, 550, 335, 'NOTE CONV', '0,0', true);
		      }else if(sheetObj.ColSaveName(col) =="arb_note"){
		    	  if(sheetObj.GetCellValue(row,"arb_note_ctnt") == '') return;
//		    	  var param="?title="+"NOTE CONV"+"&text="+encodeURIComponent(arb_note_ctnt);
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
		 * getSelectedRow
		 * send row value
		 */
		function getCheckedRows(colName) {
			var sheetObj=sheetObjects[3];
			var formObj=document.form;
			var checkRows=sheetObj.CheckedRows('radio');
			if (checkRows == 0){
				return null;
			}
			var rArray=null; //array for row data
			var cArray=null; //array for column data
			try {
				var idx=0;
				rArray=new Array(checkRows);
				for ( var i=0; i < rows; i++) {
					if (sheetObj.GetCellValue(i, 'radio') == 1) {
						cArray=sheetObj.GetCellValue(i, colName);
						rArray[idx++]=cArray;
					}
				}
			} catch (e) {
				bkg_error_alert(e);
			}
			return rArray;
		}
		/**
		 * handling process for input validation
		 */
		function validateForm(sheetObj, formObj, sAction) {
			
			var rcvTermCd = "" ; 			
			 switch(sAction) {			
			 	case IBSAVE:		    	
			 		 var sch=sheetObj.GetTotalRows();
			 		   for ( var i=1; i <= sch; i++){			 			
			 			  rcvTermCd = sheetObj.GetCellValue(i,"rcv_term_cd");
			 			   if( rcvTermCd == ''|| rcvTermCd == -1 ){		
								ComShowCodeMessage("BKG00391");
								return false;
							}
			 		   }
					break;
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
		 * bkg_error_alert error messege
		 */
		function bkg_error_alert(msg, ex) {
			alert('[ ' + msg + ' ]=[ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
		}
		function detail_info(sheetObj, row, col){
		     var dtl_title="";
		     var pt_cd ="";
		     var rt_string=""; 
		     var rt_head="";
			 var rt_dtl="";
		     var fnl_amount="";
		     var fnl="";
		     var typ_head="";
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
		  	 var sheetObj3=sheetObjects[3];
		  	 pt_cd=sheetObj.GetCellValue(row, "rt_mtch_patt_cd"); //PT TYPE
		     fnl_amount=sheetObj.GetCellText(row,"fnl_frt_rt_amt"); //FINAL AMOUNT
		     /* TYPE CONVERSION */
		     if(sheetObj.GetCellValue(row,"oa_typ_conv_ctnt") !='' || sheetObj.GetCellValue(row,"rt_typ_conv_ctnt") !='' || sheetObj.GetCellValue(row,"da_typ_conv_ctnt")!=''){
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
			  /* RT RAC CONVERSION */
		 	  if(sheetObj.GetCellValue(row,"rt_rac_conv_ctnt") !=''){
		 		  rt_rac_conv="\n" + sheetObj.GetCellValue(row,"rt_rac_conv_ctnt");
			  }
		     
		     if(pt_cd == "0000"){
		    	 rt_head += "\nPattern 1 : THR" +
		    	 			"\n" +	"------------------------------------------------------------------------------------------------" ;
		     }else if (pt_cd == "0100"){
		    	 rt_head += "\nPattern 2 : OAR + THR"+
		 					"\n" +	"------------------------------------------------------------------------------------------------" ; 
		     }else if (pt_cd == "0010"){
		    	 rt_head += "\nPattern 3 : THR + DAR"+
		 					"\n" +	"------------------------------------------------------------------------------------------------" ;
		     }else if (pt_cd =="0110"){
		    	 rt_head += "\nPattern 4 : OAR + THR + DAR"+
		 					"\n" +	"------------------------------------------------------------------------------------------------" ;
		     }else if (pt_cd =="1000"){
		    	 rt_head += "\nPattern 5 : OIH + THR"+
		 					"\n" +	"------------------------------------------------------------------------------------------------" ;
		     }else if (pt_cd =="1100"){
		    	 rt_head += "\nPattern 6 : OIH + OAR + THR"+
		 					"\n" +	"------------------------------------------------------------------------------------------------" ;
		     }else if (pt_cd =="1010"){
		    	 rt_head += "\nPattern 7 : OIH + THR + DAR"+
		 					"\n" +	"------------------------------------------------------------------------------------------------" ;
		     }else if (pt_cd =="1110"){
		    	 rt_head += "\nPattern 8 : OIH + OAR + THR + DAR"+
		 					"\n" +	"------------------------------------------------------------------------------------------------" ;
		     }else if (pt_cd =="0001"){
		    	 rt_head += "\nPattern 9 : THR + DIH"+
		 					"\n" +	"------------------------------------------------------------------------------------------------" ;
		     }else if (pt_cd =="0101"){
		    	 rt_head += "\nPattern 10 : OAR + THR + DIH"+
		 					"\n" +	"------------------------------------------------------------------------------------------------" ;
		     }else if (pt_cd =="1001"){
		    	 rt_head += "\nPattern 11 : OIH + THR + DIH"+
		 					"\n" +	"------------------------------------------------------------------------------------------------" ;
		     }else if (pt_cd =="1101"){
		    	 rt_head += "\nPattern 12 : OIH + OAR + THR + DIH"+
		 					"\n" +	"------------------------------------------------------------------------------------------------" ;
		     }else if (pt_cd =="1011"){
		    	 rt_head += "\nPattern 13 : OIH + THR + DAR + DIH"+
		 					"\n" +	"------------------------------------------------------------------------------------------------" ;
		     }else if (pt_cd == "0111"){
		    	 rt_head += "\nPattern 14 : OAR + THR + DAR + DIH"+
		 					"\n" +	"------------------------------------------------------------------------------------------------" ;
		     }else if (pt_cd =="0011"){
		    	 rt_head += "\nPattern 15 : THR + DAR + DIH"+
		 					"\n" +	"------------------------------------------------------------------------------------------------" ;
		     }
		     //getting _amt cost by sheetObj.CellText(to show 2digit)
		     if(pt_cd.substr(0,1) == 1){
		    	 /*    Ori IHC   */	
		    	 rt_dtl +="\n" +	'OIH : ' + sheetObj.GetCellValue(row,"oi_rout_pnt_loc_def_cd")+ ' - ' + sheetObj.GetCellValue(row,"oi_bse_port_def_cd") +
		    	 ' - '+ sheetObj.GetCellValue(row,"oi_prc_trsp_mod_cd")+' - ' + sheetObj.GetCellValue(row,"oi_rcv_de_term_cd")+' - ' + sheetObj.GetCellValue(row,"oi_curr_cd")+' - '+ sheetObj.GetCellText(row,"oi_fnl_frt_rt_amt") +  ' - ' + sheetObj.GetCellValue(row,"oi_rat_ut_cd")+' - ' + sheetObj.GetCellValue(row,"oi_prc_cgo_tp_cd") ;
		     }
		     if(pt_cd.substr(1,1) == 1){
		    	 /*    Ori ARB   */	
		    	 rt_dtl +="\n" +	'OAR : ' +sheetObj.GetCellValue(row,"oa_rout_pnt_loc_def_cd")+ ' - ' + sheetObj.GetCellValue(row,"oa_bse_port_def_cd")+
		    	 ' - ' + sheetObj.GetCellValue(row,"oa_prc_trsp_mod_cd")+' - ' + sheetObj.GetCellValue(row,"oa_rcv_de_term_cd")+' - ' + sheetObj.GetCellValue(row,"oa_curr_cd")+' - ';
		    	 rt_dtl += sheetObj.GetCellText(row,"oa_fnl_frt_rt_amt") +  ' - ' + sheetObj.GetCellValue(row,"oa_rat_ut_cd")+' - ' + sheetObj.GetCellValue(row,"oa_prc_cgo_tp_cd") ;
		     }
		     
		     /* Through Rate */	
		     rt_dtl +="\n" +	'THR : '+ sheetObj.GetCellValue(row,"op_rout_pnt_loc_def_cd")+' - '+sheetObj.GetCellValue(row,"ov_rout_via_port_def_cd")+' - '+ sheetObj.GetCellValue(row,"dv_rout_via_port_def_cd")+' - '+ sheetObj.GetCellValue(row,"dp_rout_pnt_loc_def_cd") +
		     ' - '+ sheetObj.GetCellValue(row,"trns_mod_cd")+' - '+ sheetObj.GetCellValue(row,"rcv_de_term_cd")+' - '+ sheetObj.GetCellValue(row,"curr_cd")+' - '+ sheetObj.GetCellText(row,"rt_fnl_frt_rt_amt")+' - '+ sheetObj.GetCellValue(row,"rt_rat_ut_cd")+' - '+ sheetObj.GetCellValue(row,"rt_prc_cgo_tp_cd") ;
		     
		     if(pt_cd.substr(2,1) == 1){
		    	 /*	Dest ARB   */	
		    	 rt_dtl +="\n" +	'DAR : ' + sheetObj.GetCellValue(row,"da_bse_port_def_cd")+ ' - ' + sheetObj.GetCellValue(row,"da_rout_pnt_loc_def_cd")+' - ' + sheetObj.GetCellValue(row,"da_prc_trsp_mod_cd")+' - ' + sheetObj.GetCellValue(row,"da_rcv_de_term_cd")+' - ' + sheetObj.GetCellValue(row,"da_curr_cd")+' - ';
		    	 rt_dtl += sheetObj.GetCellText(row,"da_fnl_frt_rt_amt") + ' - '+ sheetObj.GetCellValue(row,"da_rat_ut_cd") + ' - ' + sheetObj.GetCellValue(row,"da_prc_cgo_tp_cd");
		     }
		     if(pt_cd.substr(3,1) == 1){
		    	 /*  Dest IHC   */	
		    	 rt_dtl +="\n" +	'DIH : ' + sheetObj.GetCellValue(row,"di_bse_port_def_cd")+ ' - ' + sheetObj.GetCellValue(row,"di_rout_pnt_loc_def_cd")+' - ' + sheetObj.GetCellValue(row,"di_prc_trsp_mod_cd")+' - ' + sheetObj.GetCellValue(row,"di_rcv_de_term_cd")+' - ' + sheetObj.GetCellValue(row,"di_curr_cd")+' - '+ sheetObj.GetCellText(row,"di_fnl_frt_rt_amt")+' - '+ sheetObj.GetCellValue(row,"di_rat_ut_cd")+
		    	 ' - ' + sheetObj.GetCellValue(row,"di_prc_cgo_tp_cd");
		     }
		     
		     if(sheetObj.GetCellValue(row, "multi_curr") == "Y"){
			  		var arrMulti = [ ["","","N","N"],["","","N","N"],["","","N","N"],["","","N","N"],["","","N","N"] ];	//curr_cd, amt, display_yn, sum_yn
			  		
			  		if(pt_cd.substr(0,1) == 1){
			  			arrMulti[0][0] = sheetObj.GetCellValue(row,"oi_curr_cd");
			  			arrMulti[0][1] = sheetObj.GetCellText(row,"oi_fnl_frt_rt_amt");
			  		}
			  		if(pt_cd.substr(1,1) == 1){
			  			arrMulti[1][0] = sheetObj.GetCellValue(row,"oa_curr_cd");
			  			arrMulti[1][1] = sheetObj.GetCellText(row,"oa_fnl_frt_rt_amt");
			  		}
			  		arrMulti[2][0] = sheetObj.GetCellValue(row,"curr_cd");
			  		arrMulti[2][1] = sheetObj.GetCellText(row,"rt_fnl_frt_rt_amt");
			  		if(pt_cd.substr(2,1) == 1){
		  		  		arrMulti[3][0] = sheetObj.GetCellValue(row,"da_curr_cd");
		  		  		arrMulti[3][1] = sheetObj.GetCellText(row,"da_fnl_frt_rt_amt");
			  		}
			  		if(pt_cd.substr(3,1) == 1){
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
				  				arrMulti[i][1] = Number(arrMulti[i][1]) + Number(arrMulti[j][1]);
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
			  		fnl="\n=================================================\nFINAL : " + sheetObj.GetCellValue(row,"curr_cd") + " " + fnl_amount;
			  	}
		     
		     
//		     rt_dtl += "\n" +	'THR : '+ sheetObj.GetCellValue(row,"op_rout_pnt_loc_def_cd")+' - '+sheetObj.GetCellValue(row,"ov_rout_via_port_def_cd")+' - '+ sheetObj.GetCellValue(row,"dv_rout_via_port_def_cd")+' - '+ sheetObj.GetCellValue(row,"dp_rout_pnt_loc_def_cd") + ' - '+ sheetObj.GetCellValue(row,"trns_mod_cd")+' - '+ sheetObj.GetCellValue(row,"rcv_de_term_cd")+' - '+ sheetObj.GetCellValue(row,"curr_cd")+' - '+ sheetObj.GetCellValue(row,"rt_fnl_frt_rt_amt")+' - '+ sheetObj.GetCellValue(row,"rt_rat_ut_cd")+' - '+ sheetObj.GetCellValue(row,"rt_prc_cgo_tp_cd") ;
//		     typ_conv=typ_head + oa_typ_conv + oi_typ_conv + rt_typ_conv + da_typ_conv + di_typ_conv ;
//			 fnl="\n" +	"=================================================" + "\n" +	" FINAL : USD " + fnl_amount  
////			 rt_string += encodeURIComponent(dtl_title + rt_head+ rt_dtl + chg_row1 + typ_conv + fnl) ;
//			 rt_string += (dtl_title + rt_head+ rt_dtl + chg_row1 + typ_conv + fnl) ;
		     rt_string += (dtl_title + chg_row1 + rt_head+ rt_dtl + chg_row1 + typ_conv + rt_rar_conv + rt_rac_conv + rt_rap_conv + rt_dor_conv + rt_ras_conv + fnl) ;

			 var value=dtl_title + '$$' + rt_string;
			 return value ;
		}