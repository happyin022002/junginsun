/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0079_08.js
*@FileTitle  : Freight & Charge
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================*/
/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
				
 ***************************************************************************************/

// global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var beforetab_sub=1;
var beforetab_trob=1;
var sheetObjects=new Array();
var sheetCnt=0;
var prefix1="t10sheet1_";
var prefix2="t10sheet2_";
var prefix3="t10sheet3_";
var prefix4="t10sheet4_";
var prefix5="t10sheet5_";
var prefix6="t10sheet6_";
var prefix7="t10sheet7_";
var prefix8="t10sheet8_";
var CAF_Select_Box=null;
var CAF_MAP=null;
var tab_alert_msg=false;
var auto_rating=false;
var isOpenSelfAudit=false;
var isOpenSelfAudit2=false;
// Event handler processing by button click event  */
document.onclick=checkLoad;
function checkLoad(){	//'target' undefined error
	var readyState = document.readyState;
	if(readyState != 'interactive' && readyState != 'complete') {
		setTimeout("checkLoad()", 100);
	}
	else {
		processButtonClick();
	}
}
// Event handler processing by button name */

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		sheetObjects[i].SetWaitImageVisible(0);
		ComEndConfigSheet(sheetObjects[i]);
	}
	var formObj=document.form;
	if(formObj.bkg_no.value != ""){ 
		ComSetObjValue(formObj.frm_t10sheet1_bkg_no ,formObj.bkg_no.value);
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}
	//------------------------------------------------>
	// setInquiyDirsableButton 이벤트 호출
	if(ComGetObjValue(formObj.isInquiry) == "Y"){
		setInquiryDisableButton();
	}
	//------------------------------------------------>
	initControl();
	ComSetUIItem(sheetObjects[0], formObj, "BKG", "ESM_BKG_0079_08");
	ComOpenWait(false); 
}
/**
 * init Control 
 **/
function initControl() {
	DATE_SEPARATOR="-";
	//axon_event.addListenerFormat('beforeactivate'	, 'obj_activate'	, form); 
//	axon_event.addListenerFormat('beforedeactivate'	, 'obj_deactivate'	, form);
//	axon_event.addListenerForm('keypress'			, 'obj_KeyPress'	, form); 
	axon_event.addListenerForm('keydown'			, 'check_Enter'		, form);
	axon_event.addListenerForm('change'			, 'obj_change'		, form);
	applyShortcut();
}
 /**
  * setting sheet initial values and header
  * @param sheetObj
  * @param sheetNo
  * @return
  */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	try {
		switch (sheetNo) {
		case 1: //t1sheet1 init
		    with(sheetObj){
		      var HeadTitle1="||||||||||||||||||||||||||||||||||||||||||";
	
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
	
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"ibflag" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bkg_no" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_no" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"rt_aply_dt" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"aud_sts_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"rt_bl_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"rt_bl_tp_cd_old" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"mst_cvrd_bl" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"frt_term_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"por_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"pol_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"pod_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"del_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"rep_cmdt_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"rep_cmdt_nm" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"cmdt_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"cmdt_nm" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"taa_no" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"trf_lnr_itm_no" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"pre_rly_port_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"pst_rly_port_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"cust_nm" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"rcv_term_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"de_term_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"svc_scp_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bkg_svc_scp_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"rfa_no" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"rp_prop_sts_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"trf_lnr_itm_no" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"cstms_desc" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"sc_no1" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"sc_no2" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"sp_prop_sts_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"brk_dwn_flg" },
		             {Type:"Float",     Hidden:0, Width:0,    Align:"Right",   ColMerge:0,   SaveName:prefix1+"act_wgt",				KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"wgt_ut_cd" },
		             {Type:"Float",     Hidden:0, Width:0,    Align:"Right",   ColMerge:0,   SaveName:prefix1+"meas_qty",				KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"meas_ut_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"special" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"rmark_yn" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"rfa_yn" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"cntr_prt_flg" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"ppd_rcv_ofc_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"ppd_payr_cnt_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"ppd_payr_cust_seq" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"clt_ofc_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"clt_payr_cnt_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"clt_payr_cust_seq" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bkg_sts_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bkg_rt_whf_expt_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"cobiz_auth_no" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bkg_ctrt_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"prc_rt_mtch_patt_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"prc_gen_spcl_rt_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"prc_cmdt_hdr_seq" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"prc_rout_seq" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"hngr_flg" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"rc_flg" },
		             {Type:"Int",       Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"decl_cgo_chg_amt",		KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"decl_cgo_curr_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"doc_loc_cd" }        ];
		       
		      InitColumns(cols);
	
		      SetEditable(1);
		      SetCountPosition(0);
		      SetVisible(false);
            }
			break;
		case 2: //t1sheet1 init
		    with(sheetObj){
		      var HeadTitle="|||Charge||Tariff Item No.|Cur||Rate|Rated As|Per||||Amount|IN|Term|Third||Payer|Payer|||Cargo|Term|Term|IMO|M|Hide";
	
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
	
		      var cols = [ {Type:"Status",    Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"ibflag" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"bkg_no" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"rt_seq" },
		             {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"chg_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"exist_chg_cd" },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"trf_itm_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		             {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"curr_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"exist_curr_cd" },
		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix2+"chg_ut_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix2+"rat_as_qty",        KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"PopupEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"rat_ut_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"exist_rat_ut_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"rat_ut2_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"rat_ut3_cd" },
		             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix2+"chg_amt",           KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"incl_oft_flg",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"frt_term_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"n3pty_rcv_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"exist_ofc_cd" },
		             {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"n3pty_cust_cnt_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		             {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"n3pty_cust_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"exist_cust_cnt" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"exist_cust_seq" },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"cgo_cate_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"rcv_term_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"de_term_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"imdg_clss_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"auto_rat_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"prn_hdn_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"note_rt_seq" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"prop_no" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"amdt_seq" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"svc_scp_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"gen_spcl_rt_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"cmdt_hdr_seq" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"rout_seq" }, 
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"tax_flg" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"tax_cnt_cd" },
		             {Type:"Text",      Hidden:1, Width:80,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"dp_prcs_knt" },
		             {Type:"Text",      Hidden:1, Width:80,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"vn_flg" },
		             {Type:"Text",      Hidden:1, Width:80,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"vn_cnt_cd" }];
		       
		      InitColumns(cols);
	
		      SetEditable(1);
		      SetCountPosition(0);
		      //conversion of function[check again]CLT 				InitDataValid(0, prefix2 + "chg_cd"			, vtEngUpOnly);
		      SetColProperty(0 ,  prefix2 +"chg_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		      //conversion of function[check again]CLT 				InitDataValid(0, prefix2 + "curr_cd"		, vtEngUpOnly);
		      SetColProperty(0 ,  prefix2 +"curr_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
		      //conversion of function[check again]CLT 				InitDataValid(0, prefix2 + "rat_ut_cd"		, vtEngUpOther, "0123456789");		// rat_ut_cd
		      SetColProperty(0 ,  prefix2 +"rat_ut_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		      //conversion of function[check again]CLT 				InitDataValid(0, prefix2 + "incl_oft_flg"	, vtCharOnly, "ineINE");
		      SetColProperty(0 ,  prefix2 +"incl_oft_flg" , {AcceptKeys:"[ineINE]" });
		      //conversion of function[check again]CLT 				InitDataValid(0, prefix2 + "frt_term_cd"	, vtCharOnly, "cpCP");
		      SetColProperty(0 ,  prefix2 +"frt_term_cd" , {AcceptKeys:"[cpCP]" });
		      //conversion of function[check again]CLT 				InitDataValid(0, prefix2 + "n3pty_rcv_ofc_cd"	, vtEngUpOnly);
		      SetColProperty(0 ,  prefix2 +"n3pty_rcv_ofc_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
		      //conversion of function[check again]CLT 				InitDataValid(0, prefix2 + "n3pty_cust_cnt_cd"	, vtEngUpOnly);
		      SetColProperty(0 ,  prefix2 +"n3pty_cust_cnt_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
		      //conversion of function[check again]CLT 				InitDataValid(0, prefix2 + "n3pty_cust_seq"	, vtNumericOther, ".");
		      SetColProperty(0 ,  prefix2 +"n3pty_cust_seq" , {AcceptKeys:"N|[.]"});
		      //conversion of function[check again]CLT 				InitDataValid(0, prefix2 + "cgo_cate_cd"	, vtEngUpOnly);
		      SetColProperty(0 ,  prefix2 +"cgo_cate_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
		      
		      var rc=ComGetObjValue(document.form.frm_rcv_term_cd).valueOf();
		      var de=ComGetObjValue(document.form.frm_de_term_cd).valueOf();
		      //conversion of function[check again]CLT 				InitDataValid(0, prefix2 + "rcv_term_cd"	, vtCharOnly , rc);
		      SetColProperty(0 ,  prefix2 +"rcv_term_cd" , {AcceptKeys:"["+rc+"]"});
		      //conversion of function[check again]CLT 				InitDataValid(0, prefix2 + "de_term_cd"		, vtCharOnly , de);
		      SetColProperty(0 ,  prefix2 +"de_term_cd" , {AcceptKeys:"["+de+"]"});
		      //conversion of function[check again]CLT 				InitDataValid(0, prefix2 + "auto_rat_cd"	, vtEngUpOnly);
		      SetColProperty(0 ,  prefix2 +"auto_rat_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
		      
		      SetDataLinkMouse(prefix2 + "chg_cd",1);
		      SetDataLinkMouse(prefix2 + "curr_cd",1);
		      SetDataLinkMouse(prefix2 + "rat_ut_cd",1);
		      SetDataLinkMouse(prefix2 + "n3pty_cust_seq",1);
		      SetShowButtonImage(2);
		      SetSheetHeight(210);
//		      updateSheetSize(sheetObj);
	      	}
			break;
		case 3: //t1sheet1 init
		    with(sheetObj){
		      var HeadTitle1="||||";
	
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
	
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix3+"ibflag" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix3+"type" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix3+"curr_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix3+"chg_amt" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix3+"ofc_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix3+"cnt_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix3+"cust_seq" } ];
		       
		      InitColumns(cols);
	
		      SetEditable(1);
		      SetCountPosition(0);
		      SetVisible(false);
            }
			break;
		case 4: //t1sheet1 init
		    with(sheetObj){
		      var HeadTitle1="||";
	
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
	
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix4+"ibflag" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix4+"cntr_tpsz_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix4+"cgo" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix4+"qty" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix4+"eq_sub" } ];
		       
		      InitColumns(cols);
	
		      SetEditable(1);
		      SetCountPosition(0);
		      SetVisible(false);
            }
		    break;		
		case 5: //t1sheet5 init
		    with(sheetObj){
		      var HeadTitle1="||||";
	
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
	
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix5+"ibflag" },
				             {Type:"Text",      Hidden:0, Width:200,    Align:"Center",  ColMerge:1,   SaveName:prefix5+"pchg_cd" },
				             {Type:"Text",      Hidden:0, Width:200,    Align:"Center",  ColMerge:1,   SaveName:prefix5+"pct_bse_cd" },
				             {Type:"Text",      Hidden:0, Width:200,    Align:"Center",  ColMerge:1,   SaveName:prefix5+"chg_cd" },
				             {Type:"Text",      Hidden:0, Width:200,    Align:"Center",  ColMerge:1,   SaveName:prefix5+"curr_cd" },
				             {Type:"Text",      Hidden:0, Width:200,    Align:"Center",  ColMerge:1,   SaveName:prefix5+"pay_term_cd" },
				             {Type:"Text",      Hidden:0, Width:200,    Align:"Center",  ColMerge:1,   SaveName:prefix5+"scg_amt" } ];
		       
		      InitColumns(cols);
	
		      SetEditable(1);
		      SetCountPosition(0);
		      SetVisible(false);
            }
		    break;
		case 6: //t1sheet6 init
		    with(sheetObj){
		      var HeadTitle1="|cntr_dp_seq|bkg_no|cntr_no|cntr_vol_qty|cntr_tpsz_cd|rc_flg|dcgo_flg|awk_cgo_flg|bb_cgo_flg|hngr_flg|soc_flg||rcv_term|de_term|op_cntr_qty|flex_hgt_flg|";
	
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
	
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix6+"ibflag" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix6+"cntr_dp_seq" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix6+"bkg_no" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix6+"cntr_no" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix6+"cntr_vol_qty" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix6+"cntr_tpsz_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix6+"rc_flg" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix6+"dcgo_flg" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix6+"awk_cgo_flg" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix6+"bb_cgo_flg" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix6+"hngr_flg" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix6+"soc_flg" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix6+"rcv_term_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix6+"de_term_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix6+"op_cntr_qty" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix6+"flex_hgt_flg" } ];
		       
		      InitColumns(cols);
	
		      SetEditable(1);
		      SetCountPosition(0);
		      SetVisible(false);
            }
		break;	
		case 7: //t1sheet7 init
		    with(sheetObj){
		      var HeadTitle="|||||||||||||||||||||||||||||||||||";
	
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
	
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix7+"ibflag" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix7+"bkg_no" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix7+"rt_seq" },
		             {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix7+"chg_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix7+"exist_chg_cd" },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix7+"trf_itm_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		             {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix7+"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix7+"exist_curr_cd" },
		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix7+"chg_ut_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix7+"rat_as_qty",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"PopupEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix7+"rat_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix7+"exist_rat_ut_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"rat_ut2_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"rat_ut3_cd" },
		             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix7+"chg_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix7+"incl_oft_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix7+"frt_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix7+"n3pty_rcv_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix7+"exist_ofc_cd" },
		             {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:prefix7+"n3pty_cust_cnt_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		             {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix7+"n3pty_cust_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix7+"exist_cust_cnt" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix7+"exist_cust_seq" },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix7+"cgo_cate_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix7+"rcv_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix7+"de_term_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix7+"imdg_clss_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix7+"auto_rat_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix7+"prn_hdn_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix7+"note_rt_seq" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix7+"prop_no" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix7+"amdt_seq" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix7+"svc_scp_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix7+"gen_spcl_rt_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix7+"cmdt_hdr_seq" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix7+"rout_seq" } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetVisible(false);
            }
		break;
		case 8: //t1sheet5 init
		    with(sheetObj){
		      var HeadTitle1="||||";
	
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
	
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix8+"ibflag" },
				             {Type:"Text",      Hidden:0, Width:200,    Align:"Center",  ColMerge:1,   SaveName:prefix8+"pchg_cd" },
				             {Type:"Text",      Hidden:0, Width:200,    Align:"Center",  ColMerge:1,   SaveName:prefix8+"pct_bse_cd" },
				             {Type:"Text",      Hidden:0, Width:200,    Align:"Center",  ColMerge:1,   SaveName:prefix8+"chg_cd" },
				             {Type:"Text",      Hidden:0, Width:200,    Align:"Center",  ColMerge:1,   SaveName:prefix8+"curr_cd" },
				             {Type:"Text",      Hidden:0, Width:200,    Align:"Center",  ColMerge:1,   SaveName:prefix8+"pay_term_cd" },
				             {Type:"Text",      Hidden:0, Width:200,    Align:"Center",  ColMerge:1,   SaveName:prefix8+"scg_amt" } ];
		       
		      InitColumns(cols);
	
		      SetEditable(1);
		      SetCountPosition(0);
		      SetVisible(false);
            }
		    break;
		
		}
	} catch (ex) {
		fnBkgErrorAlert('initSheet', ex);
	}
}

function updateSheetSize(sheetObj){
	  if(typeof sheetObj == "undefined") {
		  sheetObj = sheetObjects[1];
	  }
	  var obj = $("#" + sheetObj.id).offset();
	  var marginDefault = 270;
	  var marginHeight = obj.top + marginDefault;
	  var winHeight = $(parent.window).height();
	  var sheetHeight = winHeight - marginHeight;

	  with(sheetObj){
		SetSheetHeight(sheetHeight > 90?sheetHeight:90);
	  }    
} 

 /**
  * check Dumy data
  */
 function fnDumyNotValidCheck(){
	var formObj=document.form;
	if(formObj.frm_t10sheet1_sc_no1.value.indexOf("DUM") != -1 
	|| formObj.frm_t10sheet1_rfa_no.value.indexOf("DUM") != -1 
	|| formObj.frm_t10sheet1_taa_no.value.indexOf("DUM") != -1){
		if('B' != ComGetObjValue(rt_bl_tp_cd)){
			ComShowCodeMessage("BKG08152");
			return true;
		}
	}
	fnCozNotValidCheck();
	return false;
}
/**
 * check fnCozNotValidCheck
 */
function fnCozNotValidCheck(){
	var formObj=document.form;
	if ('Y' == ComGetObjValue(formObj.bdrflag) && 'N' == ComGetObjValue(formObj.caflag)) {
		// BY Kim
	}else{
		//RFA COZ pass 
		if(formObj.frm_t10sheet1_rfa_no.value.indexOf("COZ") != -1 ){	
			ComSetObjValue(formObj.frm_t10sheet1_rfa_no, 'COZ00000001');
			ComSetObjValue(rt_bl_tp_cd, "B");
		}
	}
}
var isShowOrgBlNo=true;
// Event handler processing by button name */
function processButtonClick() {
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var sheetObject3=sheetObjects[2];
	var sheetObject4=sheetObjects[3];
	var sheetObject5=sheetObjects[4];
	var sheetObject6=sheetObjects[5];
	/** **************************************************** */
	var formObj=document.form;
	ComSetObjValue(formObj.f_cmd, SEARCH);
	try {
		var srcName=ComGetEvent("name");
		if(srcName != "btn_splitPop"){
    		if(layList.style.display == ""){
    			layList.style.display="none";
    		}    	    			
		}
		if(ComGetBtnDisable(srcName)) return false;
		/** * POP UP Charge (S) ** */
		switch (srcName) {
		case "btn_splitPop":
			doActionIBSheet(sheetObject1,formObj,COMMAND03);					
			break;           
		case "pop_bkg_no":
			fnSetSelectNumberBox('span_bkg_no', 'text_bkg_no');
			break;
		case "pop_bl_no":
			fnSetSelectNumberBox('span_bl_no', 'text_bl_no');
			break;
		case "pop_covered":
//			if ('Y' == ComGetObjValue(formObj.bdrflag) && 'N' == ComGetObjValue(formObj.caflag)) {
//				return;
//			}	
			var _Width='320';
			var _Height='430';
			var pgmNo="&pgmNo=ESM_BKG_0771";
			var param="f_cmd=" + SEARCH +"&bkg_no="+ComGetObjValue(formObj.bkg_no)+"&bl_no="+ComGetObjValue(formObj.bl_no)+"&bdrflag="+ComGetObjValue(formObj.bdrflag)+"&caflag="+ComGetObjValue(formObj.caflag);
			var url="ESM_BKG_0771.do?" + param + pgmNo;
			var rValue771=ComOpenPopup(url, _Width, _Height, 'getBKG_0771', '0,0', true, true, 0, "", 1);
			break;
		case "pop_rfa_no":
			var rfaNO=ComGetObjValue(formObj.frm_t10sheet1_rfa_no);			
			var pgmNo="ESM_PRI_2019";
			var pgmUrl="/opuscntr/ESM_PRI_2019.do";
			var params="&s_rfa_no=" + rfaNO;  // ==> RFA No.
			var parentPgmNo=pgmNo.substring(0, 8) + 'M001';   
			var src="&pgmUrl=" + ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
 
			var winObj=window.open("ESM_PRI_2019.do?parentPgmNo=" + parentPgmNo + src, ""); 
			break;
		case "pop_sc_no":
			var sc_no=ComGetObjValue(formObj.frm_t10sheet1_sc_no1) + ComGetObjValue(formObj.frm_t10sheet1_sc_no2);
			var scNo=sc_no.substring(0, 3);
			var scNoS=sc_no.substring(3, sc_no.length);
			var pgmNo="ESM_PRI_0004";
			var pgmUrl="/opuscntr/ESM_PRI_0004.do";
			var params="&sc_no_p=" + scNo + "&sc_no_s=" + scNoS; // =======>S/C
																	// No.
			var parentPgmNo=pgmNo.substring(0, 8) + 'M001';   
			var src="&pgmUrl=" + ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
			window.open("ESM_PRI_0004.do?parentPgmNo=" + parentPgmNo + src, "");      
			break;
		case "pop_tta_no":
			var taa_no=ComGetObjValue(formObj.frm_t10sheet1_taa_no);
			var pgmNo="ESM_PRI_3007";        // TAA Main Program No
			var pgmUrl="/opuscntr/ESM_PRI_3007.do"     // TAA Main screen url
			var params="&cond_taa_no=" + taa_no;    // TAA NO
			var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
			var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
			var sUrl="ESM_PRI_3007.do?parentPgmNo=" + parentPgmNo + src;
			var iWidth=1024;
			var iHeight=700;
			var leftpos=(screen.width - iWidth) / 2;
			if (leftpos < 0)
			leftpos=0;
			var toppos=(screen.height - iHeight) / 2;
			if (toppos < 0)
			toppos=0;
			window.open(sUrl, "");
			break;
		case "pop_prepaid":
			var _Width='540';
			var _Height='320';
			var param="bkg_no="+ComGetObjValue(formObj.bkg_no) + "&ca_flg="+ComGetObjValue(formObj.caflag);
			var pgmNo="&pgmNo=ESM_BKG_0961";
			var url="ESM_BKG_0961.do?" + param + pgmNo + "&call_type=PPD";
			var rValue961=ComOpenPopup(url, _Width, _Height, 'getBKG_0961', '0,0', true, true, 0, "", 1);
			getBKG_0961(rValue961, "PPD");
			break;
		case "pop_collect":
			var _Width='540';
			var _Height='320';
			var param="bkg_no="+ComGetObjValue(formObj.bkg_no) + "&ca_flg="+ComGetObjValue(formObj.caflag);
			var pgmNo="&pgmNo=ESM_BKG_0961";
			var url="ESM_BKG_0961.do?" + param + pgmNo + "&call_type=CCT";
			var rValue961=ComOpenPopup(url, _Width, _Height, 'getBKG_0961', '0,0', true, true, 0, "", 1);
			getBKG_0961(rValue961,"CCT")
			break;
		case "btn_t10note":
			var _Width='1050';
			var _Height='550';
			var pgmNo="&pgmNo=ESM_BKG_0270";
			var svc_scp_cd=ComGetObjValue(formObj.frm_t10sheet1_svc_scp_cd);
			var bkg_no=ComGetObjValue(formObj.frm_t10sheet1_bkg_no);
			var sc_no=ComGetObjValue(formObj.frm_t10sheet1_sc_no1) + ComGetObjValue(formObj.frm_t10sheet1_sc_no2);
			// Parameter for UI 270 
			var note_rt_seq="";
			var prop_no="";
			var amdt_seq="";
			var svc_scp_cd="";
			var gen_spcl_rt_tp_cd="";
			var cmdt_hdr_seq="";
			var rout_seq="";
			var cnt=sheetObject2.RowCount();
			var sheetObj=sheetObject2;
			if(cnt > 0){
				for (var i=0; i < cnt; i++){
					if(sheetObj.GetCellValue(i,prefix2 + "chg_cd") =="OFT"){
						note_rt_seq=sheetObj.GetCellValue(i,prefix2 + "note_rt_seq");
						prop_no=sheetObj.GetCellValue(i,prefix2 + "prop_no");
						amdt_seq=sheetObj.GetCellValue(i,prefix2 + "amdt_seq");
						svc_scp_cd=sheetObj.GetCellValue(i,prefix2 + "svc_scp_cd");
						gen_spcl_rt_tp_cd=sheetObj.GetCellValue(i,prefix2 + "gen_spcl_rt_tp_cd");
						cmdt_hdr_seq=sheetObj.GetCellValue(i,prefix2 + "cmdt_hdr_seq");
						rout_seq=sheetObj.GetCellValue(i,prefix2 + "rout_seq");
						break;
					}
				}
			}
			/* not open in case of no data(Prop No, Seq, ScpCd) */
			if((prop_no+amdt_seq+svc_scp_cd).length <= 0 | prop_no+amdt_seq+svc_scp_cd =='') return;
			var rfa_no=formObj.frm_t10sheet1_rfa_no.value;
			// RFA has not Note, so not open
			if(rfa_no.length > 0 | rfa_no !='') return;
			if(svc_scp_cd.length >0) svc_scp_cd=svc_scp_cd.substring(0,3);
			var param=
			'bkg_no=' + bkg_no + 
			'&application_date=' + ComGetObjValue(formObj.application_date) + 
			'&sc_no=' + sc_no + 
			'&svc_scp_cd=' + svc_scp_cd + 
			'&note_rt_seq=' + note_rt_seq + 
			'&prop_no=' + prop_no +
			'&amdt_seq=' + amdt_seq + 
			'&gen_spcl_rt_tp_cd=' +gen_spcl_rt_tp_cd +
			'&cmdt_hdr_seq=' + cmdt_hdr_seq + 
			'&rout_seq=' + rout_seq;
			var url="ESM_BKG_0270.do?" + param + pgmNo;

			ComOpenWindow(url, "BKG_Win", "scroll:;dialogWidth:" + _Width + ";dialogHeight:" + _Height+ "px" , true);
			break;
		case "btn_t10websimon":
			var _Width='1020';
			var _Height='530';
			var param='';
			var url="http://websimon.dxi.com/cws202/DxiServlet.WsServlet/login";
			ComOpenWindow(url, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true);
			break;
		case "btn_t10add":
			if(fnDumyNotValidCheck()){
				return;
			}
			/* 
			 * 1. add row in grid
			 * 2. setting Rate, Rate As, Amount to 0
			 * 3. IN = 'N'
			 * 4. setting Term by Freight Term
			 * 5. setting DR to Cargo
			 * 6. setting R/D Term to BKG R/D Term
			 * 7. setting M to M(Auto/Manual)
			 */
			 var newRow=setDataInsert(sheetObject2, 1);
			 sheetObject2.SetRowStatus(newRow,"R");
			break;
		case "btn_t10del":
			/*1. remove selected row */ 
			var cnt=sheetObject2.RowCount();
			var sRow=sheetObject2.GetSelectRow();
			if(sheetObject2.RowCount()== 0) return false;
			var selRows=sheetObject2.GetCellValue(sRow, prefix2 + "auto_rat_cd");
			if(selRows == ''){
				ComShowMessage(ComGetMsg("COM12189"));
				return false;
			}
			fnGetRowHidden(sheetObject2,sRow);// 2.row hidden
			for ( var ix=1; ix <= cnt; ix++) {
				if (!sheetObject2.GetRowHidden(ix)) {
					sheetObject2.SelectCell(ix,1);
					break;
				}
			}
			for ( var z=1; z <= cnt; z++) {
				fnChargePercentageRate(sheetObject2, z, '', '');
			}
			break;
		case "btn_t10merge":
			/* 
			1. Charge code selected from the first row, change the selected row
			2. show message [BKG00897] and return in case of  Charge code of selected row is less then 3
			3. show message [BKG00898] and return in case of Currency is less then 3
			4. show message [BKG00904] and return in case of Term is less then 1
			5. show message [BKG00905] and return in case of Third is less then 1
			6. show message [BKG00934] and go press in case of select 'Yes'
			7. Selected rows and rows with the same currency Charge Code Different Message [BKG00935] show returns after
			8. Selected rows and rows with the same Term Charge Code for different message [BKG00936] show returns after
			9. show message [BKG00937] and return in case of IN is not 'N'
			10. If you do not have the selected row and Charge Code Message [BKG08134] show returns after
			11. Add a row above the selected row
			12. Charge, Cur, Term, Third set used in the comparison
			13. Rate=0, Amount=0
			14. Rate As=1
			15. IN=N
			16. Per=BL
			17. Cargo=DR
			18. R/D Term=BKG R/D Term
			19. M(Auto/Manual)=M
			20. Amount to add to the sum of the selected Charge Code, adding the Delete Row
			 */
			var cnt=sheetObject2.RowCount();
			if (cnt == 0) {
				ComShowCodeMessage("BKG00095");
				return false;
			}
			var sRow=sheetObject2.GetSelectRow();
			var Charge=sheetObject2.GetCellValue(sRow, prefix2 + "chg_cd");
			var Currency=sheetObject2.GetCellValue(sRow, prefix2 + "curr_cd");
			var Term=sheetObject2.GetCellValue(sRow, prefix2 + "frt_term_cd");
			var Third=sheetObject2.GetCellValue(sRow, prefix2 + "n3pty_rcv_ofc_cd");
			if (Charge.length < 3) {
				ComShowCodeMessage("BKG00897");
				return false;
			}
			if (Currency.length < 3) {
				ComShowCodeMessage("BKG00898");
				return false;
			}
			if (Term.length < 1) {
				ComShowCodeMessage("BKG00904");
				return false;
			}
			// total count 
			var cnt=sheetObject2.RowCount();
			var c_cnt=0;
			var _flag=true;
			for ( var ix=1; ix <= cnt; ix++) {
				if (Charge == sheetObject2.GetCellValue(ix, prefix2 + "chg_cd")) {
					if (Currency != sheetObject2.GetCellValue(ix, prefix2 + "curr_cd")) {
						ComShowCodeMessage("BKG00935");
						// "Currency code is different.";
						sheetObject2.SelectCell(ix, prefix2 + "curr_cd");
						_flag=false;
						break;
					}
					if (Term != sheetObject2.GetCellValue(ix, prefix2 + "frt_term_cd")) {
						ComShowCodeMessage("BKG00936");
						// " Payer is different";
						sheetObject2.SelectCell(ix, prefix2 + "frt_term_cd");
						_flag=false;
						break;
					}
					if (Third != sheetObject2.GetCellValue(ix, prefix2 + "n3pty_rcv_ofc_cd")) {
						ComShowCodeMessage("BKG00905");
						// "Third Office is not available";
						sheetObject2.SelectCell(ix, prefix2 + "n3pty_rcv_ofc_cd");
						_flag=false;
						break;
					}		
					if ('N' != sheetObject2.GetCellValue(ix, prefix2 + "incl_oft_flg")) {
						ComShowCodeMessage("BKG00937");
						// Only normal charge can be merged.";
						sheetObject2.SelectCell(ix, prefix2 + "incl_oft_flg");
						_flag=false;
						break;
					}
					if ('' == sheetObject2.GetCellValue(ix, prefix2 + "chg_cd")) {
						ComShowCodeMessage("BKG00897");
						// "[{?msg1}] is not available.";
						sheetObject2.SelectCell(ix, prefix2 + "chg_cd");
						_flag=false;
						break;
					}
					c_cnt++;
				}
			}
			if (!_flag){
				return;
			}
			//No need to merge -> No charge to merge 
			if(c_cnt==1){
				ComShowCodeMessage("BKG08134");return;
			}
			if (!ComShowCodeConfirm("BKG00934", "["+Charge+"]"))
				return;
			var total_amount=0.000;
			var t_cnt=sheetObject2.RowCount();
			for ( var t=1; t <= t_cnt; t++) {
				if(Charge == sheetObject2.GetCellValue(t, prefix2 + "chg_cd")
						&& 'D' != sheetObject2.GetCellValue(t, prefix2 + "ibflag")
				){
					var amount=sheetObject2.GetCellValue(t, prefix2 + "chg_amt");
					total_amount=parseFloat(total_amount) + parseFloat(amount);
					fnGetRowHidden(sheetObject2,t);// 2.row hidden
				}
			}
			var nRow=sheetObject2.DataInsert();
			sheetObject2.SetCellValue(nRow, prefix2 + "chg_cd",Charge,0);
			sheetObject2.SetCellValue(nRow, prefix2 + "trf_itm_no",'',0);
			sheetObject2.SetCellValue(nRow, prefix2 + "curr_cd",Currency,0);
			sheetObject2.SetCellValue(nRow, prefix2 + "chg_ut_amt",total_amount,0);
			sheetObject2.SetCellValue(nRow, prefix2 + "chg_amt",total_amount,0);
			sheetObject2.SetCellValue(nRow, prefix2 + "rat_as_qty",'1',0);
			sheetObject2.SetCellValue(nRow, prefix2 + "rat_ut_cd",'BL',0);
			sheetObject2.SetCellValue(nRow, prefix2 + "incl_oft_flg",'N',0);
			sheetObject2.SetCellValue(nRow, prefix2 + "frt_term_cd",Term,0);
			sheetObject2.SetCellValue(nRow, prefix2 + "n3pty_rcv_ofc_cd",Third,0);
			sheetObject2.SetCellValue(nRow, prefix2 + "n3pty_cust_cnt_cd",'',0);
			sheetObject2.SetCellValue(nRow, prefix2 + "n3pty_cust_seq",'',0);
			sheetObject2.SetCellValue(nRow, prefix2 + "cgo_cate_cd",'DR',0);
			sheetObject2.SetCellValue(nRow, prefix2 + "rcv_term_cd",ComGetObjValue(formObj.frm_t10sheet1_rcv_term_cd),0);
			sheetObject2.SetCellValue(nRow, prefix2 + "de_term_cd",ComGetObjValue(formObj.frm_t10sheet1_de_term_cd),0);
			sheetObject2.SetCellValue(nRow, prefix2 + "imdg_clss_cd",'',0);
			sheetObject2.SetCellValue(nRow, prefix2 + "auto_rat_cd",'M',0);
			sheetObject2.SetCellValue(nRow, prefix2 + "prn_hdn_flg",'0',0);
			// Hidden
			var r_cnt=sheetObject2.RowCount();
			for ( var t=1; t <= r_cnt; t++) {
				var _type=sheetObject2.GetCellValue(t, prefix2 + "ibflag");
				if( _type != undefined){
					if(sheetObject2.GetRowHidden(t)){
						if('D' != sheetObject2.GetCellValue(t, prefix2 + "ibflag")){
							sheetObject2.SetRowStatus(t,"D");
						}
					}
				}
			}
			break;
		case "btn_t10surcharge_Inquiry":
			var _Width='1300';
			var _Height='510';
			var pgmNo="&pgmNo=ESM_PRI_4011";
			var param=
				'bkg_no=' + ComGetObjValue(formObj.bkg_no) + 
				'&svc_scp_cd=' + ComGetObjValue(formObj.frm_t10sheet1_svc_scp_cd)
				// '&chg_cd=' + ComGetObjValue(formObj.chg_cd)
				;
			var url="ESM_PRI_4011_POP.do?" + param + pgmNo;	
			
//			ComOpenWindowCenter(url,  "ESM_PRI_4011", _Width, _Height, false);
			ComOpenPopup(url, _Width, _Height, "", "none", false); 
			
			break;
		case "btn_t10whf":
			if (ComGetObjValue(formObj.bkg_no) != ComGetObjValue(formObj.frm_t10sheet1_bkg_no)) {
				ComShowCodeMessage("BKG00048");
				return;
			}
			var _Width='700';
			var _Height='530';
			var param="bkg_no="+ComGetObjValue(formObj.bkg_no);
			var pgmNo="&pgmNo=ESM_BKG_0699";
			var url="ESM_BKG_0699.do?" + param + pgmNo;
			
			rValue=ComOpenPopup(url, _Width, _Height, 'ESM_BKG_0699', '0,0', true, true, 0, prefix2 + "chg_cd", 1);
						
			break;
		case "btn_t10doc":
			if (ComGetObjValue(formObj.bkg_no) == ""){
				ComShowCodeMessage("BKG01049");
				return;
			}
			if (ComGetObjValue(formObj.bkg_no) != ComGetObjValue(formObj.frm_t10sheet1_bkg_no)) {
				ComShowCodeMessage("BKG00048");
				return;
			}
			
			var _Width='500';
			var _Height='300';
			var pgmNo="&pgmNo=ESM_BKG_0704";
			var param="f_cmd=" + SEARCH +"&bkg_no="+ComGetObjValue(formObj.bkg_no)+"&caFlg="+ComGetObjValue(formObj.caflag);
			var url="ESM_BKG_0704.do?" + param + pgmNo;
			var rValue=ComOpenPopup(url, _Width, _Height, 'ESM_BKG_0704', '0,0', true, true, 0, "", 1);
			break;
		case "btn_t10caf":
			var debug=false;
			// 1. make CAF list by map
			CAF_MAP=null;
			CAF_MAP=new fnBkgJsMap();
			var cnt=sheetObject2.RowCount();
			for ( var ix=1; ix <= cnt; ix++) {
				var charge=sheetObject2.GetCellValue(ix, prefix2 + "chg_cd");
				var currency=sheetObject2.GetCellValue(ix, prefix2 + "curr_cd");
				var type_charge=charge +"("+currency+")";
				if(charge == "CAF") type_charge="CAF";
				var amount=sheetObject2.GetCellValue(ix, prefix2 + "chg_amt");
				if (CAF_MAP.containsKey(type_charge)) {
					//summary if same pay
					var cobj=CAF_MAP.get(type_charge);
					if (cobj.currency == currency) {
						// summary if same Currency
						cobj.amount=parseFloat(cobj.amount) + parseFloat(amount)
					} else {
						//difference Currency
						cobj.diffyn='Y';
						// difference pay
						var obj=new Object();
						obj.charge=charge;
						obj.currency=currency;
						obj.amount=amount;
						obj.diffyn='N';
						CAF_MAP.put(type_charge, obj);						
					}
				}else{
					//difference pay
					var obj=new Object();
					obj.charge=charge;
					obj.currency=currency;
					obj.amount=amount;
					obj.diffyn='N';
					CAF_MAP.put(type_charge, obj);
				}
			}
			var _Width='900';
//			var _Height='310';
			var _Height='470';
			var param="bkg_no="+ComGetObjValue(formObj.bkg_no);
			var url="ESM_BKG_0700.do?" + param + pgmNo;;
			rValue=ComOpenPopup(url, _Width, _Height, 'getBKG_0700', '0,0', true, true, 0, prefix2 + "chg_cd", 1);
			getBKG_0700(rValue);
			break;
		case "btn_t10bkg_qty":
			var pgmNo="&pgmNo=ESM_BKG_1051";
			var bkg_no=ComGetObjValue(formObj.bkg_no);
			var url="ESM_BKG_1051.do?func=&bkg_no="+bkg_no+pgmNo;
			ComOpenWindowCenter(url, "ESM_BKG_1051", 860, 450, false);
			break;
		/** * BUTTON Charge (S) ** */
		case "btn_t10retrieve":
			fnClearForm();
			fnClearSelect('svc_scp_cd');// Service Scope
			doActionIBSheet(sheetObject1, formObj, IBSEARCH);
			auto_rating="false";
			break;
		case "btn_t10save":
			tab_alert_msg=true;
			doActionIBSheet(sheetObject2, formObj, IBSAVE);
			auto_rating="false";
			break;
		case "btn_t10cntr_rate":
			if(ComIsEmpty(formObj.frm_t10sheet1_bl_no.value)){
				ComShowMessage(ComGetMsg("BKG00400"));
				ComSetFocus(formObj.frm_t10sheet1_bl_no);
				return false;
			}
			
//			var _Width = '1030';
//			var _Height = '650';
			var param = "bkg_no="+ComGetObjValue(formObj.bkg_no);
			var pgmNo = "&pgmNo=ESM_BKG_1043";
			var url = "ESM_BKG_1043.do?" + param + pgmNo;
//			ComOpenWindowCenter(url, "BKG_Win",  _Width , _Height + "px", false);
			ComOpenWindowCenter(url, "BKG_Win",  1030 , 700, false);
			break;
			
		case "btn_t10auto_rating":
			//return if start with 'DUM'  			
			if(formObj.frm_t10sheet1_sc_no1.value.indexOf("DUM") != -1 
			|| formObj.frm_t10sheet1_rfa_no.value.indexOf("DUM") != -1 
			|| formObj.frm_t10sheet1_taa_no.value.indexOf("DUM") != -1){
				//ComShowCodeMessage("BKG08121");
			}
			if ('' == ComGetObjValue(formObj.frm_t10sheet1_sc_no1)
				&&	'' == ComGetObjValue(formObj.frm_t10sheet1_rfa_no)
				&&	'' == ComGetObjValue(formObj.frm_t10sheet1_taa_no)
			) {
				ComShowMessage(ComGetMsg("BKG08148"));return ;
			}
			if (formObj.brk_dwn_flg.checked) {
				ComSetObjValue(formObj.frm_t10sheet1_brk_dwn_flg, "Y");
			} else {
				ComSetObjValue(formObj.frm_t10sheet1_brk_dwn_flg, "N");
			}
			if (ComGetObjValue(formObj.bkg_no) != ComGetObjValue(formObj.frm_t10sheet1_bkg_no)) {
				ComShowCodeMessage("BKG00048");
				return;
			}
			if(formObj.bkg_no.value == '' || formObj.bkg_no.value.length < 10){
				ComShowMessage(ComGetMsg("BKG00399"));	return ;
			}
			if(formObj.bl_no.value == ''){
				ComShowMessage(ComGetMsg("BKG00400"));	return ;
			}
			if(formObj.frm_t10sheet1_rt_aply_dt.value == ''){
				ComShowMessage(ComGetMsg("BKG08086"));
				ComSetFocus(formObj.frm_t10sheet1_rt_aply_dt); return ;
			}
			if(ComGetObjValue(formObj.bkg_no)!= ComGetObjValue(formObj.frm_t10sheet1_bkg_no)
			 ||ComGetObjValue(formObj.bl_no)!= ComGetObjValue(formObj.frm_t10sheet1_bl_no)
			){
				ComShowMessage(ComGetMsg("BKG01053"));return ;
			}
			//return if have not svc code
			if(ComGetObjValue(formObj.svc_scp_cd).trim() == ''){
				ComShowMessage(ComGetMsg("BKG08136"));
				ComSetFocus(formObj.svc_scp_cd); return ;
			}
			ComSetObjValue(formObj.svc_scp_cd,ComGetObjValue(formObj.frm_t10sheet1_svc_scp_cd));	
			//if(fnAutoRatingRFACheck(ComGetObjValue(formObj.frm_t10sheet1_bkg_no))){ return;}
			var _Width='1050';
			var _Height='600';
			auto_rating=true;
			ComSetObjValue(formObj.application_date, ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt).split('-').join(""));
			ComSetObjValue(formObj.sc_no, ComGetObjValue(formObj.frm_t10sheet1_sc_no1) + ComGetObjValue(formObj.frm_t10sheet1_sc_no2));
			var v_bkg_no=ComGetObjValue(formObj.frm_t10sheet1_bkg_no);
			var v_rfa_no=ComGetObjValue(formObj.frm_t10sheet1_rfa_no);
			var v_date=ComGetObjValue(formObj.application_date);
			var v_sc_no=ComGetObjValue(formObj.frm_t10sheet1_sc_no1) + ComGetObjValue(formObj.frm_t10sheet1_sc_no2);
			var v_taa_no=ComGetObjValue(formObj.frm_t10sheet1_taa_no);
			var v_ca_flg=ComGetObjValue(formObj.caflag);
			var url='';
			var pgmNo="&pgmNo=ESM_BKG_0739";
			var param=
				'bkg_no=' + v_bkg_no + 
				'&application_date=' + v_date + 
				'&rfa_no=' + v_rfa_no +
				'&sc_no=' + v_sc_no + 
				'&taa_no=' + v_taa_no +
				'&frt_term_cd=' + ComGetObjValue(frt_term_cd) +
				'&svc_scp_cd=' + ComGetObjValue(formObj.svc_scp_cd) +
				'&frm_t10sheet1_brk_dwn_flg=' + ComGetObjValue(formObj.frm_t10sheet1_brk_dwn_flg) +  
				'&ca_flg=' + v_ca_flg
				;
			if('' != v_rfa_no){
				if(fnAutoratingRfaAvailable(v_bkg_no ,v_rfa_no,v_date,v_ca_flg) ){
					if(ComGetObjValue(formObj.frm_t10sheet1_brk_dwn_flg)=="N"){
//						ComShowMessage("RFA only allows 'Break Down' status.");
						ComShowMessage(ComGetMsg("BKG08336"));
						return ;
					}
					
					url="ESM_BKG_0739.do?" + param + pgmNo;
					// 1. query result
					// 2. result is 'Y' -> skip
					// 3. result is 'N' -> open popup 0739.
					rValue=ComOpenPopup(url, _Width, _Height, 'getBKG_0269', '0,0', true, true, 0, prefix2 + "chg_cd", 1);
					// rValue = ComOpenWindowCenter2(url, "1111" , 1200,1000,
					// false,"scrollbars=yes,resizeable=no");
					getBKG_0269(rValue);
				}
			}
			else if('' != ComGetObjValue(formObj.frm_t10sheet1_taa_no)){
				if(fnAutoratingTaaAvailable(v_bkg_no,v_taa_no,v_date,v_ca_flg)){
					if(ComGetObjValue(formObj.frm_t10sheet1_brk_dwn_flg)=="N"){
//						ComShowMessage("TAA only allows 'Break Down' status.");
						ComShowMessage(ComGetMsg("BKG08340"));
						return ;
					}

					pgmNo="&pgmNo=ESM_BKG_1076";
					url="ESM_BKG_1076.do?" + param + pgmNo;
					rValue=ComOpenPopup(url, _Width, _Height, 'getBKG_0269','0,0', true, true, 0, prefix2 + "chg_cd", 1);
					getBKG_0269(rValue);
				}
			}
			else if ('' != ComGetObjValue(formObj.frm_t10sheet1_sc_no1)) {
				if(fnAutoratingScAvailable(v_bkg_no ,v_sc_no,v_date,v_ca_flg) ){
					// 1. query result
					// 2. result is 'Y' -> skip
					// 3. result is 'N' -> open popup 0269.
					pgmNo="&pgmNo=ESM_BKG_0269";
					url="ESM_BKG_0269.do?" + param + pgmNo;
					rValue=ComOpenPopup(url, _Width, _Height, 'getBKG_0269', '0,0', true, true, 0, prefix2 + "chg_cd", 1);
				    // rValue = ComOpenWindowCenter2(url, "1111" , 1200,1000,
					// false,"scrollbars=yes,resizeable=no");
					getBKG_0269(rValue);
					if(rValue != null){
						var actionType=rValue[0].actionType;
						if('Close' != actionType){
							fnSearchScNoValidationCheck();
						}
					}
				}
			}
			break;
		case "btn_t10exchange_rating":
			var _Width='470';
			var _Height='470';
			var pgmNo="&pgmNo=ESM_BKG_0945";
			var param="bkg_no="+ComGetObjValue(formObj.bkg_no);
			var url="ESM_BKG_0945.do?" + param + pgmNo;;
			ComOpenWindowCenter(url, "BKG_Win", _Width , _Height, true,true);
			break;
		case "btn_t10clear":
			// not clear in case of bdr and caf
			if ('Y' == ComGetObjValue(formObj.bdrflag) && 'N' == ComGetObjValue(formObj.caflag)) {
				return;
			}
			sheetObjects[1].RemoveAll();
			ComSetObjValue(formObj.removeAll, "Y" );
			/**
			 * by 김태경 요청 formObj.frm_t10sheet1_bkg_no.value="";
			 * formObj.bkg_no.value=""; fnClearForm();
			 * fnClearSelect('svc_scp_cd');// Service Scope ComResetAll();
			 */
			try{
				parent.initCAControl("", "N", "N", "N", "");
			}catch(e){}
			break;
		case "btn_t10remark":
			if (ComGetObjValue(formObj.bkg_no) != ComGetObjValue(formObj.frm_t10sheet1_bkg_no)) {
				ComShowCodeMessage("BKG00048");
				return;
			}
			var _Width='750';
			var _Height='470';
			var pgmNo="&pgmNo=ESM_BKG_0265";
			var param="bkg_no="+ComGetObjValue(formObj.bkg_no);
			/* readOnly Flg=Y in case of BDR */
			if ('Y' == ComGetObjValue(formObj.bdrflag) && 'N' == ComGetObjValue(formObj.caflag)) {
				var url="ESM_BKG_0265.do?readOnly=" +'Y'+ "&" + param + pgmNo;
			}else{
				var url="ESM_BKG_0265.do?" + param + pgmNo;
			}
			rValue=ComOpenWindow(url, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px;dialogHeight:" + _Height + "px", true);
			doActionIBSheet(sheetObject1, formObj, IBSEARCH);
			break;
		case "btn_t10self":
			if(ComIsEmpty(formObj.frm_t10sheet1_bl_no.value)){
				ComShowMessage(ComGetMsg("BKG00400"));
				ComSetFocus(formObj.frm_t10sheet1_bl_no);
				return false;
			}
			var _Width='1000';
			var _Height='728';
			var pgmNo="&pgmNo=ESM_BKG_0263";
			var param="bl_no="+ ComGetObjValue(formObj.bl_no).substr(0,12)+"&ca_flg="+ ComGetObjValue(formObj.caflag);
			var url="ESM_BKG_0263.do?" + param + pgmNo;
			ComOpenPopupWithTarget(url, _Width, _Height, "selfRetrieve", "none", false);
			break;
		case "btn_t10tpb_link":
			if(ComIsEmpty(formObj.frm_t10sheet1_bkg_no.value)){
				ComShowMessage(ComGetMsg("BKG00463"));
				ComSetFocus(formObj.frm_t10sheet1_bkg_no);
				return false;
			}
			var _Width='680';
			var _Height='400';
			var pgmNo="&pgmNo=ESM_BKG_1084";
			var param="bkg_no="+ComGetObjValue(formObj.bkg_no)
            +"&bl_no="   +  ComGetObjValue(formObj.bl_no).substr(0,12)
            // +"&ntc_seq=" + '2'
            +"&cust_cd=" + ComGetObjValue(formObj.frm_p_t10sheet3_cnt_cd) + ComGetObjValue(formObj.frm_p_t10sheet3_cust_seq)
            +"&cust_nm="+ sheetObjects[0].GetCellValue(1,prefix1 + "cust_nm") ;
//			var url="/opuscntr/ESM_BKG_1084.do?" + param + pgmNo;
			var url="ESM_BKG_1084.do?" + param + pgmNo;
//			ComOpenPopupWithTarget(url, _Width, _Height, "", "none", false);
			ComOpenWindowCenter(url, "ESM_BKG_1084", _Width, _Height, true);
			break;
		case "btn_t10search_date":
			var bkg_no=ComGetObjValue(formObj.bkg_no);
			var bdrflag=ComGetObjValue(formObj.bdrflag);
			var caflag=ComGetObjValue(formObj.caflag);
			if(!bkg_no.length > 0 | bkg_no =='') return;
			var pgmNo="&pgmNo=ESM_BKG_1077";
			var param='bkg_no='+bkg_no+"&bdrflag="+bdrflag+"&caflag="+caflag;
			var url="ESM_BKG_1077.do?"+ param + pgmNo;
			rValue=ComOpenPopup(url, 600, 440, 'getBKG_1077', '0,0', true, true, 0, prefix2 + "bkg_no", 1);
			if(rValue == undefined) return;
			getBKG_1077(rValue);
			break;
		case "pop_del_cgo_curr_cd":
			var decl_cgo_curr_cd=ComGetObjValue(formObj.frm_t10sheet1_decl_cgo_curr_cd);
			var url = "/opuscntr/COM_ENS_N13.do?pgmNo=COM_ENS_N13";
			
//			ComOpenPopup('/opuscntr/COM_ENS_N13.do?pgmNo=COM_ENS_N13', 700, 450, 'getCOM_ENC_N13', '1,0,1,1,1', true, true, Row, prefix2 + "curr_cd", 1);
			ComOpenPopup(url, 700,    450,     'getCOM_CUR_N13', '1,0,1,1,1', true);

			
//			var pgmNo="ESM_PRI_3007";        // TAA Main Program No
//			var pgmUrl="/opuscntr/ESM_PRI_3007.do"     // TAA Main screen url
//			var params="&cond_taa_no=" + taa_no;    // TAA NO
//			var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
//			var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
//			var sUrl="ESM_PRI_3007.do?parentPgmNo=" + parentPgmNo + src;
//			var iWidth=1024;
//			var iHeight=700;
//			var leftpos=(screen.width - iWidth) / 2;
//			if (leftpos < 0)
//			leftpos=0;
//			var toppos=(screen.height - iHeight) / 2;
//			if (toppos < 0)
//			toppos=0;
//			window.open(sUrl, "");
			break;
		} // end switch
	} catch (e) {
		if( e.name == "TypeError") {
			return false;
		}else{
    		ComShowMessage(e.message);
		}
	}
}
var comp_bl_no='';
var comp_rt_aply_dt='';
var comp_sc_no1='';
var comp_rfa_no='';
var comp_taa_no='';
var comp_pofc_cd='';
var comp_pcnt_cd='';
var comp_pcust_seq='';
var comp_cofc_cd='';
var comp_ccnt_cd='';
var comp_ccust_seq='';
/**
 * setting basic data before modify
 */
function fnModifyCheckBefore(){
	var formObj=document.form;
	 comp_bl_no=ComGetObjValue(formObj.frm_t10sheet1_bl_no);
	 comp_rt_aply_dt=ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt);
	 comp_sc_no1=ComGetObjValue(formObj.frm_t10sheet1_sc_no1);
	 comp_rfa_no=ComGetObjValue(formObj.frm_t10sheet1_rfa_no);
	 comp_taa_no=ComGetObjValue(formObj.frm_t10sheet1_taa_no);
	 comp_pofc_cd=ComGetObjValue(formObj.frm_p_t10sheet3_ofc_cd);
	 comp_pcnt_cd=ComGetObjValue(formObj.frm_p_t10sheet3_cnt_cd);
	 comp_pcust_seq=ComGetObjValue(formObj.frm_p_t10sheet3_cust_seq);
	 comp_cofc_cd=ComGetObjValue(formObj.frm_c_t10sheet3_ofc_cd);
	 comp_ccnt_cd=ComGetObjValue(formObj.frm_c_t10sheet3_cnt_cd);
	 comp_ccust_seq=ComGetObjValue(formObj.frm_c_t10sheet3_cust_seq);
}
/**
 * check basic data after modify 
 */
function fnModifyCheckAfter(){
	var formObj=document.form;
	var bmodify=false;
	if(comp_bl_no != ComGetObjValue(formObj.frm_t10sheet1_bl_no)){
		bmodify=true;
	}
	if(comp_rt_aply_dt != ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt)){
		bmodify=true;
	}
	if(comp_sc_no1 != ComGetObjValue(formObj.frm_t10sheet1_sc_no1)){
		bmodify=true;
	}
	if(comp_rfa_no != ComGetObjValue(formObj.frm_t10sheet1_rfa_no)){
		bmodify=true;
	}
	if(comp_taa_no != ComGetObjValue(formObj.frm_t10sheet1_taa_no)){
		bmodify=true;
	}
	if(comp_pofc_cd != ComGetObjValue(formObj.frm_p_t10sheet3_ofc_cd)){
		bmodify=true;
	}
	if(comp_pcnt_cd != ComGetObjValue(formObj.frm_p_t10sheet3_cnt_cd)){
		bmodify=true;
	}
	if(comp_pcust_seq != ComGetObjValue(formObj.frm_p_t10sheet3_cust_seq)){
		bmodify=true;
	}
	if(comp_cofc_cd != ComGetObjValue(formObj.frm_c_t10sheet3_ofc_cd)){
		bmodify=true;
	}
	if(comp_ccnt_cd != ComGetObjValue(formObj.frm_c_t10sheet3_cnt_cd)){
		bmodify=true;
	}
	if(comp_ccust_seq != ComGetObjValue(formObj.frm_c_t10sheet3_cust_seq)){
		bmodify=true;
	}
	if(bmodify){
		ComSetObjValue(document.form.modify_flag, "Y");
	}
	return true;
}
/**
 * check SC no validation
 */
function fnSearchScNoValidationCheck(){
	var formObj=document.form;
	var v_date=ComGetObjValue(formObj.application_date);
	var v_sc_no=ComGetObjValue(formObj.frm_t10sheet1_sc_no1) + ComGetObjValue(formObj.frm_t10sheet1_sc_no2);
	// 1.validation
	if('' == v_sc_no ) return;
	if('' == v_date ) return;
	var input_text=v_sc_no+"|"+ v_date;
	// 2.search
	var param=param + "&f_cmd=" + SEARCH02 + "&input_text=" + input_text;
	var sXml=sheetObjects[1].GetSearchData("ESM_Booking_UtilGS.do", param);
	var output_text=ComGetEtcData(sXml, "output_text");
	// 3.output
	if ('Y' != output_text) {
		ComShowMessage(ComGetMsg("BKG08147", v_sc_no ));
		return ;
	}
}
/**
 * row hidden
 * @param sheetObj
 * @param r
 * @return
 */
function fnGetRowHidden(sheetObj,r){
	sheetObj.SetRowHidden(r,1);
	sheetObj.SetRowStatus(r,"D");
}
/**
 * call back function after BKG_0269 call
 * @param _val
 * @return
 */
function getBKG_0269(_val) {
	if (_val == null || _val == undefined ) return;
	var formObj=document.form;
	var obj=_val;
	var sheetObj=sheetObjects[1];
	var sheetObj6=sheetObjects[6]
	var ct=sheetObj.RowCount();
	// 0.default setting
	var y=0;
	var sheetObj0=sheetObjects[0];
	sheetObj0.SetCellValue(1, prefix1 + "prc_rt_mtch_patt_cd",obj[y].prcPttCd);
	sheetObj0.SetCellValue(1, prefix1 + "prc_gen_spcl_rt_tp_cd",obj[y].genSpclTp);
	sheetObj0.SetCellValue(1, prefix1 + "prc_cmdt_hdr_seq",obj[y].cmdtHdrSeq);
	sheetObj0.SetCellValue(1, prefix1 + "prc_rout_seq",obj[y].routSeq);
	var actionType=obj[y].actionType;
	var rowInsert=false;
	var ar=0; 
	var z=0;
	var newRow=0;
	var newRow6=0;
	var rArray=new Array();
	ComOpenWait(true);
	// for batch delete in case of AUTO RATING
	ComSetObjValue(formObj.autoRate, "Y" );
	//AUTO RATING HISTORY Sheet Init
	sheetObjects[6].RemoveAll();
	if('Close' == actionType){
		//1. close  
		if (ComShowConfirm(ComGetMsg("BKG08108"))) {
			// Grid Init 
			for ( var ir=1; ir <= ct; ir++) {
				var auto_rat_cd=sheetObj.GetCellValue(ir, prefix2 + "auto_rat_cd");
				if ('M' != auto_rat_cd && 'I' != auto_rat_cd) {
					fnGetRowHidden(sheetObj,ir);// 2.row hidden
				}
			}
			var tcnt=obj.length;
			for ( var z=0; z < tcnt; z++) {
				if(undefined == obj[z]) break;
				if( '' == obj[z].charge || undefined == obj[z].charge) continue;
				newRow=sheetObj.DataInsert(-1);
				newRow6=sheetObj6.DataInsert(-1);
				var term=obj[z].term;
				var term1,term2;
				if(term != null){
					term=obj[z].term.split("/");
					term1=term[0];
					term2=term[1];
				}
				sheetObj.SetRowStatus(newRow,"R");
				sheetObj.SetCellValue(newRow, prefix2 + "chg_cd",obj[z].charge);
				sheetObj.SetCellValue(newRow, prefix2 + "curr_cd",obj[z].cur);
				//DP_PRCS_KNT 조회 ...
				var dp_prcs_knt = fnGetDpPrcsKnt(sheetObj, obj[z].cur);
				sheetObj.SetCellValue(newRow, prefix2 + "dp_prcs_knt", dp_prcs_knt);

				sheetObj.SetCellValue(newRow, prefix2 + "rat_ut_cd",obj[z].per);
				sheetObj.SetCellValue(newRow, prefix2 + "rat_ut2_cd",obj[z].rat_ut2_cd);
				sheetObj.SetCellValue(newRow, prefix2 + "rat_ut3_cd",obj[z].rat_ut3_cd);
				sheetObj.SetCellValue(newRow, prefix2 + "chg_ut_amt",obj[z].rate);
				sheetObj.SetCellValue(newRow, prefix2 + "rat_as_qty",obj[z].rate_as);
				
				sheetObj.SetCellValue(newRow, prefix2 + "tax_flg",obj[z].tax);	//tax_flg
				sheetObj.SetCellValue(newRow, prefix2 + "tax_cnt_cd",obj[z].taxcnt);
				if(obj[z].tax =="Y" && obj[z].taxcnt =="VN"){
					sheetObj.SetCellValue(newRow, prefix2 + "vn_flg","Y");
				}else{
					sheetObj.SetCellValue(newRow, prefix2 + "vn_flg","N");
				}
				
//				alert(obj[z].charge+"/"+obj[z].tax);
				
				if(obj[z].tax == "Y"){
					sheetObj.SetCellValue(newRow, prefix2 + "prn_hdn_flg","Y");	//tax_flg
					if(obj[z].per == "PC"){
						sheetObj.SetCellEditable(newRow, prefix2 + "chg_cd", 0);
						sheetObj.SetCellEditable(newRow, prefix2 + "curr_cd", 0);
						sheetObj.SetCellEditable(newRow, prefix2 + "chg_ut_amt", 0);
						sheetObj.SetCellEditable(newRow, prefix2 + "rat_ut_cd", 0);
					}
				}

				/* add History item */			
				sheetObj6.SetRowStatus(newRow6,"R");
				sheetObj6.SetCellValue(newRow6, prefix7 + "chg_cd",obj[z].charge);
				sheetObj6.SetCellValue(newRow6, prefix7 + "curr_cd",obj[z].cur);
				sheetObj6.SetCellValue(newRow6, prefix7 + "rat_ut_cd",obj[z].per);
				sheetObj6.SetCellValue(newRow6, prefix7 + "rat_ut2_cd",obj[z].rat_ut2_cd);
				sheetObj6.SetCellValue(newRow6, prefix7 + "rat_ut3_cd",obj[z].rat_ut3_cd);
				sheetObj6.SetCellValue(newRow6, prefix7 + "chg_ut_amt",obj[z].rate);
				sheetObj6.SetCellValue(newRow6, prefix7 + "rat_as_qty",obj[z].rate_as);
				/*
				 * setting AMT in case of Per Type = PC
				 */
				if(obj[z].per == "PC"){
					sheetObj.SetCellValue(newRow, prefix2 + "chg_amt",obj[z].amt);
				}
				sheetObj6.SetCellValue(newRow6, prefix7 + "chg_amt",obj[z].amt);
				sheetObj.SetCellValue(newRow, prefix2 + "incl_oft_flg",obj[z].incl);
				sheetObj.SetCellValue(newRow, prefix2 + "frt_term_cd",obj[z].term_cd);
				sheetObj.SetCellValue(newRow, prefix2 + "cgo_cate_cd",obj[z].cargo);
				sheetObj.SetCellValue(newRow, prefix2 + "rcv_term_cd",term1);
				sheetObj.SetCellValue(newRow, prefix2 + "de_term_cd",term2);
				sheetObj.SetCellValue(newRow, prefix2 + "auto_rat_cd",obj[z].m);
				sheetObj.SetCellValue(newRow, prefix2 + "imdg_clss_cd",obj[z].imo);
				sheetObj.SetCellValue(newRow, prefix2 + "note_rt_seq",obj[z].noteRtSeq);
				sheetObj.SetCellValue(newRow, prefix2 + "prop_no",obj[z].propNo);
				sheetObj.SetCellValue(newRow, prefix2 + "amdt_seq",obj[z].amdtSeq);
				sheetObj.SetCellValue(newRow, prefix2 + "svc_scp_cd",obj[z].svcScpCd);
				sheetObj.SetCellValue(newRow, prefix2 + "gen_spcl_rt_tp_cd",obj[z].genSpclTp);
				sheetObj.SetCellValue(newRow, prefix2 + "cmdt_hdr_seq",obj[z].cmdtHdrSeq);
				sheetObj.SetCellValue(newRow, prefix2 + "rout_seq",obj[z].routSeq);
				/* add History item*/						
				sheetObj6.SetCellValue(newRow6, prefix7 + "incl_oft_flg",obj[z].incl);
				sheetObj6.SetCellValue(newRow6, prefix7 + "frt_term_cd",obj[z].term_cd);
				sheetObj6.SetCellValue(newRow6, prefix7 + "cgo_cate_cd",obj[z].cargo);
				sheetObj6.SetCellValue(newRow6, prefix7 + "rcv_term_cd",term1);
				sheetObj6.SetCellValue(newRow6, prefix7 + "de_term_cd",term2);
				sheetObj6.SetCellValue(newRow6, prefix7 + "auto_rat_cd",obj[z].m);
				sheetObj6.SetCellValue(newRow6, prefix7 + "imdg_clss_cd",obj[z].imo);
				sheetObj6.SetCellValue(newRow6, prefix7 + "note_rt_seq",obj[z].noteRtSeq);
				sheetObj6.SetCellValue(newRow6, prefix7 + "prop_no",obj[z].propNo);
				sheetObj6.SetCellValue(newRow6, prefix7 + "amdt_seq",obj[z].amdtSeq);
				sheetObj6.SetCellValue(newRow6, prefix7 + "svc_scp_cd",obj[z].svcScpCd);
				sheetObj6.SetCellValue(newRow6, prefix7 + "gen_spcl_rt_tp_cd",obj[z].genSpclTp);
				sheetObj6.SetCellValue(newRow6, prefix7 + "cmdt_hdr_seq",obj[z].cmdtHdrSeq);
				sheetObj6.SetCellValue(newRow6, prefix7 + "rout_seq",obj[z].routSeq);
			}
		}
	}else{
		// row add
		rowInsert=true;
		// Grid init
		for ( var ir=1; ir <= ct; ir++) {
			if(sheetObj.GetRowHidden(ir) || sheetObj.GetRowStatus(ir) == "D")continue; // hidden
			var auto_rat_cd=sheetObj.GetCellValue(ir, prefix2 + "auto_rat_cd");
			var chg_cd=sheetObj.GetCellValue(ir, prefix2 + "chg_cd");
			var chg_ut_amt=sheetObj.GetCellValue(ir, prefix2 + "chg_ut_amt");
			
			if ('M' != auto_rat_cd && 'I' != auto_rat_cd) {
				// clear in case of OFT, Rate = 0, M = 'A' or 'U'
				if('OFT' == chg_cd && '0' == chg_ut_amt ){ 
					fnGetRowHidden(sheetObj,ir);// 2.row hidden
				}else{
					fnGetRowHidden(sheetObj,ir);// 2.row hidden
				}
			}
		}
		// frm_appldt : frm_cmdt_cd,
		var c_leng=obj.length - 1;
		if('Commodity' == obj[c_leng].actionType){
			ComSetObjValue(formObj.frm_t10sheet1_rt_aply_dt , obj[c_leng].appldt);
//			ComSetObjValue(formObj.frm_t10sheet1_cmdt_cd 	, obj[c_leng].cmdtcd);
//			ComSetObjValue(formObj.frm_t10sheet1_rep_cmdt_cd, obj[c_leng].repcmdtcd);
		}else if('TAA_No' == obj[c_leng].actionType){
		//tripropno :  frm_t10sheet1_taa_no, 
			sheetObj.SetCellValue(1, prefix2 + "trf_itm_no",obj[c_leng].tripropno);
		}

	}
	if(rowInsert){
		//no data not found 시
		if(ct == 0) sheetObj.RemoveAll(); // Grid Init
		var tcnt=obj.length;
		for ( var z=0; z < tcnt; z++) {
			if(undefined == obj[z]) break;
			if( '' == obj[z].charge || undefined == obj[z].charge) continue;
			if( 'OFT'  == obj[z].charge){ 
				newRow=sheetObj.DataInsert(0);
				newRow6=sheetObj6.DataInsert(0);
			}else{ 
				newRow=sheetObj.DataInsert(-1);
				newRow6=sheetObj6.DataInsert(-1)
			}
			var term=obj[z].term;
			var term1,term2;
			if(term != null){
				term=obj[z].term.split("/");
				term1=term[0];
				term2=term[1];
			}
			sheetObj.SetRowStatus(newRow,"R");
			
			sheetObj.SetCellValue(newRow, prefix2 + "bkg_no",ComGetObjValue(formObj.bkg_no));
			sheetObj.SetCellValue(newRow, prefix2 + "chg_cd",obj[z].charge);
			sheetObj.SetCellValue(newRow, prefix2 + "curr_cd",obj[z].cur);
			//DP_PRCS_KNT 조회 ...
			var dp_prcs_knt = fnGetDpPrcsKnt(sheetObj, obj[z].cur);
			sheetObj.SetCellValue(newRow, prefix2 + "dp_prcs_knt", dp_prcs_knt);
//			alert(obj[z].rate+"/"+obj[z].cur+"/"+dp_prcs_knt);

			sheetObj.SetCellValue(newRow, prefix2 + "rat_ut_cd",obj[z].per);
			sheetObj.SetCellValue(newRow, prefix2 + "rat_ut2_cd",obj[z].rat_ut2_cd);
			sheetObj.SetCellValue(newRow, prefix2 + "rat_ut3_cd",obj[z].rat_ut3_cd);
			sheetObj.SetCellValue(newRow, prefix2 + "chg_ut_amt",obj[z].rate);
			sheetObj.SetCellValue(newRow, prefix2 + "rat_as_qty",obj[z].rate_as);
			sheetObj.SetCellValue(newRow, prefix2 + "tax_flg",obj[z].tax);	//tax_flg
			sheetObj.SetCellValue(newRow, prefix2 + "tax_cnt_cd",obj[z].taxcnt);
			if(obj[z].tax == "Y" && obj[z].taxcnt == "VN"){
				sheetObj.SetCellValue(newRow, prefix2 + "vn_flg","Y");
			}else{
				sheetObj.SetCellValue(newRow, prefix2 + "vn_flg","N");
			}
			
			if(obj[z].tax=="Y"){
				sheetObj.SetCellValue(newRow, prefix2 + "prn_hdn_flg","Y");
				if(obj[z].per == "PC"){
					sheetObj.SetCellEditable(newRow, prefix2 + "chg_cd", 0);
					sheetObj.SetCellEditable(newRow, prefix2 + "curr_cd", 0);
					sheetObj.SetCellEditable(newRow, prefix2 + "chg_ut_amt", 0);
					sheetObj.SetCellEditable(newRow, prefix2 + "rat_ut_cd", 0);
				}
			}
			
			sheetObj6.SetRowStatus(newRow6,"R");
			sheetObj6.SetCellValue(newRow6, prefix7 + "bkg_no",ComGetObjValue(formObj.bkg_no));
			sheetObj6.SetCellValue(newRow6, prefix7 + "chg_cd",obj[z].charge);
			sheetObj6.SetCellValue(newRow6, prefix7 + "curr_cd",obj[z].cur);
			sheetObj6.SetCellValue(newRow6, prefix7 + "rat_ut_cd",obj[z].per);
			sheetObj6.SetCellValue(newRow6, prefix7 + "rat_ut2_cd",obj[z].rat_ut2_cd);
			sheetObj6.SetCellValue(newRow6, prefix7 + "rat_ut3_cd",obj[z].rat_ut3_cd);
			sheetObj6.SetCellValue(newRow6, prefix7 + "chg_ut_amt",obj[z].rate);
			sheetObj6.SetCellValue(newRow6, prefix7 + "rat_as_qty",obj[z].rate_as);
			/*
			 * setting AMT in case of per type = 'PC'
			 */
			if(obj[z].per == "PC"){
				sheetObj.SetCellValue(newRow, prefix2 + "chg_amt",obj[z].amt);
			}
			if('OFT'  == obj[z].charge){
				sheetObj6.SetCellValue(newRow6, prefix7 + "chg_amt",obj[z].rate * obj[z].rate_as);
			}else{
				sheetObj6.SetCellValue(newRow6, prefix7 + "chg_amt",obj[z].amt);
			}
			
			sheetObj.SetCellValue(newRow, prefix2 + "incl_oft_flg",obj[z].incl);
			sheetObj.SetCellValue(newRow, prefix2 + "frt_term_cd",obj[z].term_cd);
			sheetObj.SetCellValue(newRow, prefix2 + "cgo_cate_cd",obj[z].cargo);
			sheetObj.SetCellValue(newRow, prefix2 + "rcv_term_cd",term1);
			sheetObj.SetCellValue(newRow, prefix2 + "de_term_cd",term2);
			sheetObj.SetCellValue(newRow, prefix2 + "auto_rat_cd",obj[z].m);
			sheetObj.SetCellValue(newRow, prefix2 + "imdg_clss_cd",obj[z].imo);
			sheetObj.SetCellValue(newRow, prefix2 + "note_rt_seq",obj[z].noteRtSeq);
			sheetObj.SetCellValue(newRow, prefix2 + "prop_no",obj[z].propNo);
			sheetObj.SetCellValue(newRow, prefix2 + "amdt_seq",obj[z].amdtSeq);
			sheetObj.SetCellValue(newRow, prefix2 + "svc_scp_cd",obj[z].svcScpCd);
			sheetObj.SetCellValue(newRow, prefix2 + "gen_spcl_rt_tp_cd",obj[z].genSpclTp);
			sheetObj.SetCellValue(newRow, prefix2 + "cmdt_hdr_seq",obj[z].cmdtHdrSeq);
			sheetObj.SetCellValue(newRow, prefix2 + "rout_seq",obj[z].routSeq);
			/* add History item */		
			sheetObj6.SetCellValue(newRow6, prefix7 + "incl_oft_flg",obj[z].incl);
			sheetObj6.SetCellValue(newRow6, prefix7 + "frt_term_cd",obj[z].term_cd);
			sheetObj6.SetCellValue(newRow6, prefix7 + "cgo_cate_cd",obj[z].cargo);
			sheetObj6.SetCellValue(newRow6, prefix7 + "rcv_term_cd",term1);
			sheetObj6.SetCellValue(newRow6, prefix7 + "de_term_cd",term2);
			sheetObj6.SetCellValue(newRow6, prefix7 + "auto_rat_cd",obj[z].m);
			sheetObj6.SetCellValue(newRow6, prefix7 + "imdg_clss_cd",obj[z].imo);
			sheetObj6.SetCellValue(newRow6, prefix7 + "note_rt_seq",obj[z].noteRtSeq);
			sheetObj6.SetCellValue(newRow6, prefix7 + "prop_no",obj[z].propNo);
			sheetObj6.SetCellValue(newRow6, prefix7 + "amdt_seq",obj[z].amdtSeq);
			sheetObj6.SetCellValue(newRow6, prefix7 + "svc_scp_cd",obj[z].svcScpCd);
			sheetObj6.SetCellValue(newRow6, prefix7 + "gen_spcl_rt_tp_cd",obj[z].genSpclTp);
			sheetObj6.SetCellValue(newRow6, prefix7 + "cmdt_hdr_seq",obj[z].cmdtHdrSeq);
			sheetObj6.SetCellValue(newRow6, prefix7 + "rout_seq",obj[z].routSeq);
		}
		 var cnt=sheetObj.RowCount();
		 var exist_DIH=false;
		 var exist_OIH=false;
		 for ( var ix=1; ix <= cnt; ix++) {
			 if(sheetObj.GetRowHidden(ix) || sheetObj.GetRowStatus(ix) == "D") continue;
			 if("DIH" == sheetObj.GetCellValue(ix, prefix2 + "chg_cd") && 'I' == sheetObj.GetCellValue(ix, prefix2 + "auto_rat_cd")){
				 exist_DIH=true;
	 		 }
			 if("OIH" == sheetObj.GetCellValue(ix, prefix2 + "chg_cd") && 'I' == sheetObj.GetCellValue(ix, prefix2 + "auto_rat_cd")){
	 			exist_OIH=true;
	 		 }
		 }
		 for ( var iz=1; iz <= cnt; iz++) {
			 if(sheetObj.GetRowHidden(iz) || sheetObj.GetRowStatus(iz) == "D") continue;
			 if("DIH" == sheetObj.GetCellValue(iz, prefix2 + "chg_cd") && 'I' != sheetObj.GetCellValue(iz, prefix2 + "auto_rat_cd")){
				 if(exist_DIH)fnGetRowHidden(sheetObj,iz);// 2.row hidden
	 		 }
			 if("OIH" == sheetObj.GetCellValue(iz, prefix2 + "chg_cd") && 'I' != sheetObj.GetCellValue(iz, prefix2 + "auto_rat_cd")){
				 if(exist_OIH)fnGetRowHidden(sheetObj,iz);// 2.row hidden
	 		 }
		 }
	}
	// history sheet copy 
	//fnAutoRatingHistory(sheetObjects[6]);
	// TPsz value setting
	fnSetCntrTpsz(sheetObj);
	// note button color change
	fnExistNoteButtonColor();
	//Self-Audit auto popup condition
	isOpenSelfAudit2=true;
	setForceFocus();
	ComOpenWait(false);

}
 /**
  * set container type size
  * @param sheetObj
  * @return
  */
 function fnSetCntrTpsz(sheetObj) {
	 var sheetObj2=sheetObjects[1];
	 var sheetObj4=sheetObjects[3];
	 var cnt2=sheetObj2.RowCount();
	 var cnt4=sheetObj4.RowCount();
	 if(cnt4 == 0) return;
	 var scell=0;
	 // in case of multi cgo(ex.DG+RF), don't add oft empty row
	 if(document.form.multi_cgo.value=="Y") return;
	 
	 // OFT select on first
	 for ( var ix=1; ix <= cnt2; ix++) {
		 if (sheetObj2.GetRowHidden(ix) || sheetObj2.GetRowStatus(ix) == "D") continue;
		 if("OFT" == sheetObj2.GetCellValue(ix, prefix2 + "chg_cd")){
 			sheetObj2.SelectCell(ix,1);
 			scell++;
 		 }
 		break;
	 } 
	 var newRow ;
	 var ctp , rat_ut2;
	 var tp ,eq_sub; 
	 for ( var i=1; i <= cnt4; i++) {
		 tp=sheetObj4.GetCellValue(i, prefix4 + "cntr_tpsz_cd");
		 eq_sub=sheetObj4.GetCellValue(i, prefix4 + "eq_sub");
		 sp_cgo=sheetObj4.GetCellValue(i, prefix4 + "cgo");
		  if(eq_sub == '') eq_sub=tp;
		  if(tp.substring(0,1)=="Q") continue; //Q 타입의 OFT 가 누락된 경우는 빈 row를 생성해주지 않는다. 2015/09/10 #7088
		 //  Autorating screen : per type 40.20
		 ctp=0; rat_ut2='';
		 // compare
		 for ( var j=1; j <= cnt2; j++) {
			 if (sheetObj2.GetRowHidden(j)|| sheetObj2.GetRowStatus(j) == "D" || 'OFT' != sheetObj2.GetCellValue(j, prefix2 + "chg_cd")) continue;
			 // rat_ut2 = sheetObj2.CellValue(j, prefix2 + "rat_ut_cd"); //
				// new value from auto_rating
			 rat_ut2=sheetObj2.GetCellValue(j, prefix2 + "rat_ut2_cd");
			 rat_ut3=sheetObj2.GetCellValue(j, prefix2 + "rat_ut3_cd");
			 cgo=sheetObj2.GetCellValue(j, prefix2 + "cgo_cate_cd");
			 if(tp == rat_ut2 && eq_sub == rat_ut3 && sp_cgo == cgo){
				 ctp++;
			 }
		 }
		 // in case of no data 
		 if(ctp == 0){
			 if(scell>0){
				 newRow=setDataInsert(sheetObj2, 3);
			 }else{
				 newRow=setDataInsert(sheetObj2, 4);
			 }
			sheetObj2.SetRowStatus(newRow,"R");
		 	sheetObj2.SetCellValue(newRow, prefix2 + "chg_cd",'OFT');
		 	sheetObj2.SetCellValue(newRow, prefix2 + "curr_cd",'USD');
			//DP_PRCS_KNT 조회 ...
			var dp_prcs_knt = fnGetDpPrcsKnt(sheetObj, 'USD');
		 	sheetObj2.SetCellValue(newRow, prefix2 + "dp_prcs_knt", dp_prcs_knt);

		 	if(sheetObj4.GetCellValue(i, prefix4 + "eq_sub") != undefined && sheetObj4.GetCellValue(i, prefix4 + "eq_sub") !== ''){
		 		sheetObj2.SetCellValue(newRow, prefix2 + "rat_ut_cd",sheetObj4.GetCellValue(i, prefix4 + "eq_sub"));
		 	}else{
		 		sheetObj2.SetCellValue(newRow, prefix2 + "rat_ut_cd",sheetObj4.GetCellValue(i, prefix4 + "cntr_tpsz_cd"));
		 	}
		 	sheetObj2.SetCellValue(newRow, prefix2 + "rat_as_qty",sheetObj4.GetCellValue(i, prefix4 + "qty"));
		 	sheetObj2.SetCellValue(newRow, prefix2 + "cgo_cate_cd",sheetObj4.GetCellValue(i, prefix4 + "cgo"));
		 	

		 }
	 }
 }
/**
 * history auto rating
 * @param sheetObj
 * @return
 */
function fnAutoRatingHistory(sheetObj) {
	// init
	sheetObj.RemoveAll();
	// copy
	sheetObjects[1].Copy2SheetCol(sheetObj,"","",-1,-1,-1,1,false,false);
	// hidden row
	for ( var ix=1; ix <= sheetObj.RowCount(); ix++) {
		if('D' != sheetObj.GetCellValue(ix, prefix7 + "ibflag")){
			fnGetRowHidden(sheetObj,ix);// 2.row hidden
		}
	}
	for ( var ix=1; ix <= sheetObj.RowCount(); ix++) {
		if('A' != sheetObj.GetCellValue(ix, prefix7 + "auto_rat_cd")){
			fnGetRowHidden(sheetObj,ix);// 2.row hidden
		}
	}
}
 var temp_value='';
 var change_prn_hdn_flg=false;
 /**
  * t10Sheet2 on before edit event handling
  * @param sheetObj
  * @param Row
  * @param Col
  * @return
  */
 function t10sheet2_OnBeforeEdit(sheetObj, Row, Col) {
	 t10sheet2_OnClick(sheetObj, Row, Col);
 }
 /**
  * t10Sheet2 click event handling
  * @param sheetObj
  * @param Row
  * @param Col
  * @param Value
  * @return
  */
 function t10sheet2_OnClick(sheetObj, Row, Col, Value) {
	  var formObj=document.form;
		var type_gubun=sheetObj.ColSaveName(Col);
		if ( type_gubun == prefix2 + "chg_cd"
			|| type_gubun == prefix2 + "trf_itm_no"
			|| type_gubun == prefix2 + "curr_cd"
			|| type_gubun == prefix2 + "chg_ut_amt"
			|| type_gubun == prefix2 + "rat_as_qty"
			|| type_gubun == prefix2 + "n3pty_rcv_ofc_cd"
			|| type_gubun == prefix2 + "n3pty_cust_cnt_cd"
			|| type_gubun == prefix2 + "n3pty_cust_seq"
			|| type_gubun == prefix2 + "incl_oft_flg"
			|| type_gubun == prefix2 + "frt_term_cd"
		) {
			temp_value=sheetObj.GetCellText(Row, Col) ;
		}
		if ( type_gubun == prefix2 + "prn_hdn_flg"){
			change_prn_hdn_flg=true;
		}
}
/**
 * t10Sheet2 change event handling
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function t10sheet2_OnChange(sheetObj, Row, Col, Value) {
	var formObj=document.form;
	var chg_cd=sheetObj.GetCellValue(Row, prefix2 + "chg_cd");
	
	
	if (sheetObj.ColSaveName(Col) == prefix2 + "chg_cd") {
		if (
			('WHF' == chg_cd )&&('N' == ComGetObjValue(formObj.frm_t10sheet1_bkg_rt_whf_expt_cd))
		){
			ComShowCodeMessage("BKG00971"); 
		}
		/**
		Result 14. turn Hide in case of CHARGE=FRB
		 */
		if ('FRB' == chg_cd ){
			sheetObj.SetCellValue(Row, prefix2 + "prn_hdn_flg",1,0);
		}else{
			sheetObj.SetCellValue(Row, prefix2 + "prn_hdn_flg",0,0);
		}
	} else if (sheetObj.ColSaveName(Col) == prefix2 + "chg_ut_amt" || sheetObj.ColSaveName(Col) == prefix2 + "curr_cd") {
		 if(sheetObj.ColSaveName(Col) == prefix2 + "chg_ut_amt"){
				var iLen = sheetObj.GetCellValue(Row, prefix2 + "dp_prcs_knt");
				var val = ComRound(sheetObj.GetCellValue(Row, prefix2 + "chg_ut_amt"), iLen);
				sheetObj.SetCellValue(Row, prefix2 + "chg_ut_amt", val, 0);
		 }		
		/*
		 * Rate x rated as/100 = amount
		 */		
		if( sheetObj.GetCellValue(Row, prefix2 + "chg_ut_amt") !== "" && sheetObj.GetCellValue(Row, prefix2 + "rat_as_qty") !=="" ){
			var val;
			if(sheetObj.GetCellValue(Row, prefix2 + "tax_flg") =="Y"){
				if(sheetObj.GetCellValue(Row, prefix2 + "rat_ut_cd") !="PC"){
					val = fnCalcAmount(sheetObj.GetCellValue(Row, prefix2 + "chg_ut_amt"), sheetObj.GetCellValue(Row, prefix2 + "rat_as_qty"), sheetObj.GetCellValue(Row, prefix2 + "dp_prcs_knt"));
				}
				sheetObj.SetCellValue(Row, prefix2 + "chg_amt", val,0);
			}else{
				if(sheetObj.GetCellValue(Row, prefix2 + "rat_ut_cd") =="PC"){
					val = fnCalcRateAmount(sheetObj.GetCellValue(Row, prefix2 + "chg_ut_amt"), sheetObj.GetCellValue(Row, prefix2 + "rat_as_qty"), sheetObj.GetCellValue(Row, prefix2 + "dp_prcs_knt"));
				}else{
					val = fnCalcAmount(sheetObj.GetCellValue(Row, prefix2 + "chg_ut_amt"), sheetObj.GetCellValue(Row, prefix2 + "rat_as_qty"), sheetObj.GetCellValue(Row, prefix2 + "dp_prcs_knt"));
				}
				sheetObj.SetCellValue(Row, prefix2 + "chg_amt", val,0);
			}
		}
		
	} else if (sheetObj.ColSaveName(Col) == prefix2 + "rat_as_qty") {
			
		/*
		 * Rate x rated as/100 = amount
		 */
		if( sheetObj.GetCellValue(Row, prefix2 + "chg_ut_amt") !=="" && sheetObj.GetCellValue(Row, prefix2 + "rat_as_qty") !=="" ){
			var val;
			if(sheetObj.GetCellValue(Row, prefix2 + "rat_ut_cd") =="PC"){
				val = fnCalcRateAmount(sheetObj.GetCellValue(Row, prefix2 + "chg_ut_amt"), sheetObj.GetCellValue(Row, prefix2 + "rat_as_qty"), sheetObj.GetCellValue(Row, prefix2 + "dp_prcs_knt"));
			}else{
				val = fnCalcAmount(sheetObj.GetCellValue(Row, prefix2 + "chg_ut_amt"), sheetObj.GetCellValue(Row, prefix2 + "rat_as_qty"), sheetObj.GetCellValue(Row, prefix2 + "dp_prcs_knt"));
			}
			sheetObj.SetCellValue(Row, prefix2 + "chg_amt", val,0);		
		}
	} else if (sheetObj.ColSaveName(Col) == prefix2 + "incl_oft_flg") {
		/*
		 * User can chage I/N 
		 * Indicator type : I / N / E
		 * check : Logic of auto display IN, PRI
		 * font is italic in case of I/E
		 */
		var incl_oft_flg=sheetObj.GetCellValue(Row, prefix2 + "incl_oft_flg").toUpperCase();
		sheetObj.SetCellValue(Row, prefix2 + "incl_oft_flg",incl_oft_flg,0);
		if ('I' == incl_oft_flg || 'E' == incl_oft_flg) {
			sheetObj.SetCellFont("FontItalic", Row, 1,Row,30,1);
			sheetObj.SetCellBackColor(Row, prefix2 + "chg_cd","#99CCFF");// blue
		}else{
			sheetObj.SetCellFont("FontItalic", Row, 1,Row,30,0);
			sheetObj.SetCellBackColor(Row, prefix2 + "chg_cd","#FFFFFF");// white
		}
	} else if (sheetObj.ColSaveName(Col) == prefix2 + "frt_term_cd") {
		/*
		 * P – prepaid. C – collect
		 * need validation : can not collect for RF
		 */
		var frt_term_cd_code=sheetObj.GetCellValue(Row, prefix2 + "frt_term_cd").toUpperCase();
		var cgo_cate_cd=sheetObj.GetCellValue(Row, prefix2 + "cgo_cate_cd").toUpperCase();
		sheetObj.SetCellValue(Row, prefix2 + "frt_term_cd",frt_term_cd_code,0);
		var incl_oft_flg=sheetObj.GetCellValue(Row, prefix2 + "incl_oft_flg");
		if ('RF' == cgo_cate_cd && 'C' == frt_term_cd_code && 'N' == incl_oft_flg ) {
			//ComShowCodeMessage("BKG08057");
		}
	} else if (sheetObj.ColSaveName(Col) == prefix2 + "rcv_term_cd") {
		sheetObj.SetCellValue(Row, prefix2 + "rcv_term_cd",sheetObj.GetCellValue(Row, prefix2 + "rcv_term_cd").toUpperCase(),0);
	} else if (sheetObj.ColSaveName(Col) == prefix2 + "de_term_cd") {
		sheetObj.SetCellValue(Row, prefix2 + "de_term_cd",sheetObj.GetCellValue(Row, prefix2 + "de_term_cd").toUpperCase(),0);
	} else if (sheetObj.ColSaveName(Col) == prefix2 + "cgo_cate_cd") {
		/*
		 * P – prepaid. C – collect
		 * need validation : can not collect for RF
		 */
		var frt_term_cd_code=sheetObj.GetCellValue(Row, prefix2 + "frt_term_cd");
		var cgo_cate_cd=sheetObj.GetCellValue(Row, prefix2 + "cgo_cate_cd");
		var incl_oft_flg=sheetObj.GetCellValue(Row, prefix2 + "incl_oft_flg");
		if ('RF' == cgo_cate_cd && 'C' == frt_term_cd_code && 'N' == incl_oft_flg ) {
			//ComShowCodeMessage("BKG08057");
		}
	}
	ComSetObjValue(document.form.modify_flag, "Y");

}
 /**
  * calculate Amount
  * - Rate x rated as = amount
  * @param val1
  * @param val2
  * @param digit	//소숫점 반올림 자릿수
  * @return
  */
 function fnCalcAmount(val1,val2,digit) {
	var digitNum = Math.pow(10, digit);
	 
	var amount=Math.round(parseFloat(val1) * parseFloat(digitNum) * parseFloat(val2))/parseFloat(digitNum);
	return amount.toFixed(digit);
 }
  /**
   * calculate Amount
   * - Rate x rated as/100 = amount
   * @param val1
   * @param val2
   * @param digit	//소숫점 반올림 자릿수
   * @return
   */
 function fnCalcRateAmount(val1,val2,digit) {
	var amount=(parseFloat(val1) * parseFloat(val2))/100;
	
	return amount.toFixed(digit);
 }
   /**
    * check CAF
    * @param sheetObj
    * @return
    */
   function fnCAFCheck(sheetObj){
   	var count=0;
   	var idx=0;
   	var cnt=sheetObj.RowCount();
   	for ( var ix=1; ix <= cnt; ix++) {
var rate_chg_cd=sheetObj.GetCellValue(ix, prefix2 + "chg_cd");
   		if('CAF' == rate_chg_cd && !sheetObj.GetRowHidden(ix)){
   			count++; idx=ix ; 
   		}
   	}
   	if(count > 1){
   		if(tab_alert_msg){
   			ComShowMessage(ComGetMsg("BKG08135"));
   		}   	
   		//var sRow = sheetObj.SelectRow;
   		// var findRow = sheetObj.FindText(prefix2 + "chg_cd", "CAF");
   		sheetObj.SelectCell(idx, prefix2 + "chg_cd");
   		return false;
   	}
   	return true;
   }
 /**
  * t10Sheet2 on after edit event handling
  * @param sheetObj
  * @param Row
  * @param Col
  * @param Value
  * @return
  */
 function t10sheet2_OnAfterEdit(sheetObj, Row, Col, Value) {
	 
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) == prefix2 + "chg_cd"
			||sheetObj.ColSaveName(Col) == prefix2 + "curr_cd"
			||sheetObj.ColSaveName(Col) == prefix2 + "chg_ut_amt"
			||sheetObj.ColSaveName(Col) == prefix2 + "rat_as_qty"
			||sheetObj.ColSaveName(Col) == prefix2 + "rat_ut_cd"
			||sheetObj.ColSaveName(Col) == prefix2 + "n3pty_rcv_ofc_cd"
			||sheetObj.ColSaveName(Col) == prefix2 + "n3pty_cust_cnt_cd"
			||sheetObj.ColSaveName(Col) == prefix2 + "n3pty_cust_seq"
			||sheetObj.ColSaveName(Col) == prefix2 + "incl_oft_flg"
			||sheetObj.ColSaveName(Col) == prefix2 + "frt_term_cd"
			) {
			if (sheetObj.ColSaveName(Col) == prefix2 + "chg_cd") {
				var chg_cd=sheetObj.GetCellValue(Row, prefix2 + "chg_cd");
				if(chg_cd == '' || undefined == chg_cd) return;
				var param=param + "&f_cmd=" + SEARCH14 + "&chg_cd=" + chg_cd;
				var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
				var exist_flg=ComGetEtcData(sXml, "exist_flg");
				var tax_flg=ComGetEtcData(sXml, "tax_flg");
				var tax_cnt_cd=ComGetEtcData(sXml, "tax_cnt_cd");
				if ('Y' != exist_flg) {
					ComShowMessage(ComGetMsg("BKG00970", chg_cd ));
					sheetObj.SetCellValue(Row, prefix2 + "exist_chg_cd",'N');
					sheetObj.SetCellValue(Row, prefix2 + "tax_flg", "");
					sheetObj.SetCellValue(Row, prefix2 + "tax_cnt_cd", "");
					return ;
				}else{
					sheetObj.SetCellValue(Row, prefix2 + "exist_chg_cd",'');
					sheetObj.SetCellValue(Row, prefix2 + "tax_flg",tax_flg);
					sheetObj.SetCellValue(Row, prefix2 + "tax_cnt_cd",tax_cnt_cd);
					if(tax_flg == "Y" && tax_cnt_cd == "VN"){
						sheetObj.SetCellValue(Row, prefix2 + "vn_flg","Y");
					}else{
						sheetObj.SetCellValue(Row, prefix2 + "vn_flg","N");
					}
				}
				
				
//				var param=param + "&f_cmd=" + SEARCHLIST16 + "&input_text=" + chg_cd;
//				var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
//				var output_text=ComGetEtcData(sXml, "output_text");
//				if ('Y' != output_text) {
//					ComShowMessage(ComGetMsg("BKG00970", chg_cd ));
//					sheetObj.SetCellValue(Row, prefix2 + "exist_chg_cd",'N');
//					return ;
//				}else{
//					sheetObj.SetCellValue(Row, prefix2 + "exist_chg_cd",'');
//				}
			} else if (sheetObj.ColSaveName(Col) == prefix2 + "curr_cd") {
				//------------------------------------------------>
				/*
				 * in case of input not register currency code
				 * “XXX is not registered code. 
				 * Please check the charge code again.” cmd = SEARCHLIST18
				 */
				if(temp_value == sheetObj.GetCellText(Row, Col) ) return;
				var curr_cd=sheetObj.GetCellValue(Row, prefix2 + "curr_cd");
				if(curr_cd == '' || undefined == curr_cd) return;
				var param=param + "&f_cmd=" + SEARCH17 + "&curr_cd=" + curr_cd;
				var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
				var exist_curr_cd=ComGetEtcData(sXml, "exist_curr_cd");
				var dp_prcs_knt  =ComGetEtcData(sXml, "dp_prcs_knt");
				
				if ('Y' != exist_curr_cd) {
					ComShowCodeMessage("BKG00898");
					sheetObj.SetCellValue(Row, prefix2 + "exist_curr_cd",'N');
					sheetObj.SetCellValue(Row, prefix2 + "dp_prcs_knt",'2');		//default 2 digit
					return ;
				}else{
					sheetObj.SetCellValue(Row, prefix2 + "exist_curr_cd",'');
					sheetObj.SetCellValue(Row, prefix2 + "dp_prcs_knt",dp_prcs_knt);
				}
			} else if (sheetObj.ColSaveName(Col) == prefix2 + "rat_ut_cd") {
				//------------------------------------------------>
				/*
				 * in case of input not register currency code
				 * “XXX is not registered code. 
				 * Please check the charge code again.” cmd = SEARCHLIST18
				 */
				if(temp_value == sheetObj.GetCellText(Row, Col) ) return;
				var rat_ut_cd=sheetObj.GetCellValue(Row, prefix2 + "rat_ut_cd");
				if(rat_ut_cd == '' || undefined == rat_ut_cd) return;
				var param=param + "&f_cmd=" + COMMAND01 + "&input_text=" + rat_ut_cd;
				var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
				var output_text=ComGetEtcData(sXml, "output_text");
				if ('Y' != output_text) {
					ComShowCodeMessage("BKG00901");
					sheetObj.SetCellValue(Row, prefix2 + "exist_rat_ut_cd",'N');
					return ;
				}else{
					sheetObj.SetCellValue(Row, prefix2 + "exist_rat_ut_cd",'');
					var cnt=sheetObj.RowCount();
					for ( var ix=1; ix <= cnt; ix++) {
						fnChargePercentageRate(sheetObj, ix, '', '');
					}
				}		
			} else if (sheetObj.ColSaveName(Col) == prefix2 + "n3pty_rcv_ofc_cd") {
				/*
				 * SEARCHLIST19  79-08 event check Third (Offce cd) 
				 * cmd = SEARCHLIST19
				 */
				if('' == sheetObj.GetCellText(Row, Col)) {
					sheetObj.SetCellValue(Row, prefix2 + "exist_ofc_cd",'');
					return;
				}
				if(temp_value == sheetObj.GetCellText(Row, Col) ) return;
				var ofc_cd=sheetObj.GetCellValue(Row, prefix2 + "n3pty_rcv_ofc_cd");
				if(ofc_cd == '' || undefined == ofc_cd) return;
				var output_text=fnOfcCdCheck(ofc_cd);
				if ('Y' != output_text) {
					// Third Office is not available
			 		ComShowCodeMessage("BKG00044",'Third Office Code'); 
//			 		sheetObj.SetCellValue(Row, prefix2 + "n3pty_cust_cnt_cd",'');
//			 		sheetObj.SetCellValue(Row, prefix2 + "n3pty_cust_seq",'');
					sheetObj.SetCellValue(Row, prefix2 + "exist_ofc_cd",'N');
					return ;
				}else{
					sheetObj.SetCellValue(Row, prefix2 + "exist_ofc_cd",'');
//					fnRepCustomer(sheetObj,Row,ofc_cd);
				}
			} else if (sheetObj.ColSaveName(Col) == prefix2 + "n3pty_cust_cnt_cd"
			) {
				/*
				 * SEARCHLIST06  79-08 event check  Payer (custCntCd)  
				 * cmd = SEARCHLIST06
				 */
				var cust_cnt_cd=sheetObj.GetCellValue(Row, prefix2 + "n3pty_cust_cnt_cd");
				var cust_seq=sheetObj.GetCellValue(Row, prefix2 + "n3pty_cust_seq");
				if(cust_cnt_cd != '') {
					var input_text=cust_cnt_cd;
					var param=param + "&f_cmd=" + SEARCHLIST06 + "&input_text=" + input_text;
					var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
					var output_text=ComGetEtcData(sXml, "output_text");
					if ('Y' != output_text) {
						ComShowCodeMessage("BKG00906");
						sheetObj.SetCellValue(Row, prefix2 + "exist_cust_cnt",'N');
						return ;
					}else{
						sheetObj.SetCellValue(Row, prefix2 + "exist_cust_cnt",'');
					}
					if(cust_seq == '') sheetObj.SetCellValue(Row, prefix2 + "exist_cust_seq",'N');
				}else{
					sheetObj.SetCellValue(Row, prefix2 + "exist_cust_cnt",'');
				}
			} else if (sheetObj.ColSaveName(Col) == prefix2 + "n3pty_cust_seq"
			) { 
				//------------------------------------------------>
				/*
				 * SEARCHLIST20 79-08 event check Payer (custCntCd, custSeq)
				 */
				var cust_cnt_cd=sheetObj.GetCellValue(Row, prefix2 + "n3pty_cust_cnt_cd");
				var cust_seq=sheetObj.GetCellValue(Row, prefix2 + "n3pty_cust_seq");
				if(cust_cnt_cd != '' && cust_seq != '') {
					var input_text=cust_cnt_cd+"|"+cust_seq;
					var param=param + "&f_cmd=" + SEARCHLIST20 + "&input_text=" + input_text;
					var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
					var output_text=ComGetEtcData(sXml, "output_text");
					if ('N' != output_text) {
						ComShowCodeMessage("BKG00906");
						sheetObj.SetCellValue(Row, prefix2 + "exist_cust_seq",'N');
						return ;
					}else{
						sheetObj.SetCellValue(Row, prefix2 + "exist_cust_seq",'');
					}
				}else if(cust_cnt_cd == '' && cust_seq == ''){
					sheetObj.SetCellValue(Row, prefix2 + "exist_cust_seq",'');
				}else{
					if(cust_cnt_cd == ''){
						sheetObj.SelectCell(Row, prefix2 + "n3pty_cust_cnt_cd");
					}else if(cust_seq == ''){
						sheetObj.SelectCell(Row, prefix2 + "n3pty_cust_seq");
					}
					sheetObj.SetCellValue(Row, prefix2 + "exist_cust_seq",'N');
					return;
				}
			} else if (sheetObj.ColSaveName(Col) == prefix2 + "frt_term_cd"
			) {
				//------------------------------------------------>
				// "SOME WARNING MSG FOR RATING STAFF'S ATTENTION. For example:
				// a. Hanger cntr, GOH should be ppd
				// b. Reefer cntr, OFT must be ppd.
				// c. Personal effect & used household goods must be ppd.
				var chg_cd=sheetObj.GetCellValue(Row, prefix2 + "chg_cd");
				var frt_term_cd_code=sheetObj.GetCellValue(Row, prefix2 + "frt_term_cd");
				if('Y' == ComGetObjValue(formObj.frm_t10sheet1_rc_flg)){
					if(chg_cd == 'OFT'&& frt_term_cd_code != 'P' ) {
						ComShowCodeMessage("BKG08131");
					}
				}
				if('Y' == ComGetObjValue(formObj.frm_t10sheet1_hngr_flg)){
					if(chg_cd == 'GOH'&& frt_term_cd_code != 'P' ) {
						ComShowCodeMessage("BKG08133");
					}
				}
				if('961900' == ComGetObjValue(formObj.frm_t10sheet1_cmdt_cd)){
					if(frt_term_cd_code != 'P' ) {
						//ComShowCodeMessage("BKG08132");
					}
				}
			}
			//------------------------------------------------>
			// [BKG00913] // OFT(or ASC) Currency must be 'USD' or 'AUD' or
			// 'EUR' or 'JPY' or 'GBP' or 'DEM'
			if(sheetObj.ColSaveName(Col) == prefix2 + "chg_cd" || sheetObj.ColSaveName(Col) == prefix2 + "curr_cd"){
				var chg_cd=sheetObj.GetCellValue(Row, prefix2 + "chg_cd");
				var curr_cd=sheetObj.GetCellValue(Row, prefix2 + "curr_cd");
//				if(chg_cd != '' && curr_cd != ''){
//					if('OFT' == chg_cd ||'ASC' == chg_cd){
//						if('USD' == curr_cd||'AUD' == curr_cd|| 'EUR' == curr_cd ||'JPY' == curr_cd||'GBP' == curr_cd||'DEM' == curr_cd ){
//						}else{
//							ComShowCodeMessage("BKG00913");
//						}
//					}
//				}
			}
			// setting 1 in case of per = BL
			var rate_rat_ut_cd=sheetObj.GetCellValue(Row, prefix2 + "rat_ut_cd");
			if(sheetObj.ColSaveName(Col) == prefix2 + "rat_ut_cd"){
				if ('BL' == rate_rat_ut_cd ) {					
					sheetObj.SetCellValue(Row, prefix2 + "rat_as_qty",1.00);
				}
			}
//			fnSplitAmount();
			var cnt=sheetObj.RowCount();
			for ( var ix=1; ix <= cnt; ix++) {
				fnChargePercentageRate(sheetObj, ix, Col, Value);
			}
		}
		// manual display in case of charge/currency/rate/rated as/per/amount/in
		if (
			sheetObj.ColSaveName(Col) == prefix2 + "chg_cd"
			||sheetObj.ColSaveName(Col) == prefix2 + "curr_cd"
			||sheetObj.ColSaveName(Col) == prefix2 + "chg_ut_amt"
			||sheetObj.ColSaveName(Col) == prefix2 + "rat_as_qty"
			||sheetObj.ColSaveName(Col) == prefix2 + "rat_ut_cd"
			// ||sheetObj.ColSaveName(Col) == prefix2 + "frt_term_cd"
			||sheetObj.ColSaveName(Col) == prefix2 + "incl_oft_flg"
			) {
			// check change Y/N 
			if(temp_value != sheetObj.GetCellText(Row, Col) ){
				// not change in case of M
				if( 'M' != sheetObj.GetCellValue(Row, prefix2 + "auto_rat_cd")&& 'I' != sheetObj.GetCellValue(Row, prefix2 + "auto_rat_cd")){
					sheetObj.SetCellValue(Row, prefix2 + "auto_rat_cd",'U');
				}
				// OFT change is not change in case of autorating
				if('' == sheetObj.GetCellValue(Row, prefix2 + "bkg_no")){
					if( 'OFT' == sheetObj.GetCellValue(Row, prefix2 + "chg_cd")){
						sheetObj.SetCellValue(Row, prefix2 + "auto_rat_cd",'M');
					}	
				}
			}
		}
		if (sheetObj.ColSaveName(Col) != prefix2+"frt_term_cd") {
			isOpenSelfAudit2=true;
		}
}
 /**
  * charge percentage rate
  * @param sheetObj
  * @param Row
  * @param Col
  * @param Value
  * @return
  */
function fnChargePercentageRate(sheetObj, Row, Col, Value) {
	if(sheetObj.GetRowHidden(Row) || "D" == sheetObj.GetRowStatus(Row)) return;
	var formObj=document.form;
	// except calculate logic when status = 'A'
	var auto_rat_cd=sheetObj.GetCellValue(Row, prefix2 + "auto_rat_cd")
	var rate_chg_cd=sheetObj.GetCellValue(Row, prefix2 + "chg_cd");
	var rate_rat_ut_cd=sheetObj.GetCellValue(Row, prefix2 + "rat_ut_cd");
	var result=0.00;
	var sumAmount=0.00;
	var rat_as_qty=sheetObj.GetCellValue(Row, prefix2 + "rat_as_qty");
	var chg_ut_amt=sheetObj.GetCellValue(Row, prefix2 + "chg_ut_amt");
	var tax_flg   =sheetObj.GetCellValue(Row, prefix2 + "tax_flg");
	var dp_prcs_knt = sheetObj.GetCellValue(Row, prefix2 + "dp_prcs_knt");
	try {
		if('Y' == tax_flg){
			if ('PC' == rate_rat_ut_cd ) {
				return;
			}else{
				result=fnCalcAmount(chg_ut_amt, rat_as_qty,dp_prcs_knt) ;
				sheetObj.SetCellValue(Row, prefix2 + "chg_amt",result);
			}
		}else{
			if('TVA' == rate_chg_cd && 'PC' == rate_rat_ut_cd && 'I' == auto_rat_cd){
			   return;
			}else 
			if ('CAF' == rate_chg_cd &&'PC' == rate_rat_ut_cd ) {
				// 100으로 나눈값으로 처리
				result=(parseFloat(sheetObj.GetCellValue(Row, prefix2 + "chg_ut_amt")) * parseFloat(rat_as_qty)) /100;
				sheetObj.SetCellValue(Row, prefix2 + "chg_amt",result.toFixed(2));
			}else
			if ('PC' == rate_rat_ut_cd ) {
				sumAmount=fnSumAmountToal(sheetObj,Row);
				chg_ut_amt = sumAmount.toFixed(dp_prcs_knt);
				sheetObj.SetCellValue(Row, prefix2 + "chg_ut_amt",chg_ut_amt);
				result=fnCalcRateAmount(chg_ut_amt, rat_as_qty, dp_prcs_knt);
				sheetObj.SetCellValue(Row, prefix2 + "chg_amt",result);
			}else{
				result=fnCalcAmount(chg_ut_amt, rat_as_qty,dp_prcs_knt) ;
				sheetObj.SetCellValue(Row, prefix2 + "chg_amt",result);
			}
		}
	} catch (ex) {
		fnBkgErrorAlert('fnChargePercentageRate', ex);
	}	
}
/**
 * sum amountToal
 * @param sheetObj
 * @param cRow
 * @return
 */
function fnSumAmountToal(sheetObj , cRow) {
	// return in case of RowCount = 0  
	var jcnt=sheetObj.RowCount();
	if(jcnt == 0) 	return 0;
	var sheetObj5=sheetObjects[4];
	var cnt=sheetObj5.RowCount();
	// return in case of not PC;
	var sumAmount=0.00;
	if('PC' != sheetObj.GetCellValue(cRow, prefix2 + "rat_ut_cd")){
		return sumAmount;
	}
	var i_rat_ut_cd=sheetObj.GetCellValue(cRow, prefix2 + "rat_ut_cd");
	if('PC' == i_rat_ut_cd) {
		var pp_chg_cd=sheetObj.GetCellValue(cRow, prefix2 + "chg_cd");
		// 4. get RATE in case of existing CHARGE, CUR, PER, TERM
		for ( var ix=1; ix <= cnt; ix++) {
			var c_pchg_cd=sheetObj5.GetCellValue(ix, prefix5 + "pchg_cd");
			// p_chage_cd = object5
		 	if(pp_chg_cd == c_pchg_cd){
		 		var o_chg_cd=sheetObj5.GetCellValue(ix, prefix5 + "chg_cd");
		 		var o_curr_cd=sheetObj.GetCellValue(cRow, prefix2 + "curr_cd");
		 		var o_frt_term_cd=sheetObj.GetCellValue(cRow, prefix2 + "frt_term_cd");
				// use OFT Term if Ocean Freight is 0
			 	if(o_frt_term_cd =="O"){
			 		findRow=sheetObj.FindText(prefix2 + "chg_cd", "OFT");
			 		if(findRow){
			 			o_frt_term_cd=sheetObj.GetCellValue(findRow, prefix2 + "frt_term_cd");
			 		}
			 	}
			 	for ( var j=1; j <= jcnt; j++) {
			 		var p_chg_cd=sheetObj.GetCellValue(j, prefix2 + "chg_cd");
			 		var p_curr_cd=sheetObj.GetCellValue(j, prefix2 + "curr_cd");
			 		var p_frt_term_cd=sheetObj.GetCellValue(j, prefix2 + "frt_term_cd");
			 		var rat_ut_cd=sheetObj.GetCellValue(j, prefix2 + "rat_ut_cd");	
			 		var incl_oft_flg=sheetObj.GetCellValue(j, prefix2 + "incl_oft_flg");
					if('PC' == rat_ut_cd) continue;// except PC
					if('I' == incl_oft_flg || 'E' == incl_oft_flg) continue;// except I,E
					// except hidden value
					if(sheetObj.GetRowHidden(j) || sheetObj.GetRowStatus(j) == "D")continue;
					if(p_chg_cd.length > 0 && p_curr_cd.length > 0 && p_frt_term_cd.length > 0 ){
						if (p_chg_cd == o_chg_cd &&p_curr_cd == o_curr_cd && p_frt_term_cd == o_frt_term_cd ) {
							sumAmount=sumAmount + parseFloat(sheetObj.GetCellValue(j, prefix2 + "chg_amt"));
					 	}
					}
			 	 }
		 	}
		}
	}
	return sumAmount;
}
/**
 * sum amountToal
 * @param sheetObj
 * @param cRow
 * @return
 */
function fnGstSumAmountToal(sheetObj , cRow) {
	// return in case of RowCount equal 0
	var jcnt=sheetObj.RowCount();
	if(jcnt == 0) 	return 0;
	var sheetObj5=sheetObjects[4];
	var cnt=sheetObj5.RowCount();
	// return in case of not PC
	var sumAmount=0.00;
	// not calculate total in case of not PC
	if('PC' != sheetObj.GetCellValue(cRow, prefix2 + "rat_ut_cd")){
		return sumAmount;
	}
	var i_rat_ut_cd=sheetObj.GetCellValue(cRow, prefix2 + "rat_ut_cd");
	if('PC' == i_rat_ut_cd) {
		var pp_chg_cd=sheetObj.GetCellValue(cRow, prefix2 + "chg_cd");
		// 4. get RATE in case of existing CHARGE, CUR, PER, TERM
		for ( var ix=1; ix <= cnt; ix++) {
			var c_pchg_cd=sheetObj5.GetCellValue(ix, prefix5 + "pchg_cd");
 			// p_chage_cd = object5
 		 	if(pp_chg_cd == c_pchg_cd){
 		 		var o_chg_cd=sheetObj5.GetCellValue(ix, prefix5 + "chg_cd");
 		 		var o_curr_cd=sheetObj.GetCellValue(cRow, prefix2 + "curr_cd");
 			 	for ( var j=1; j <= jcnt; j++) {
 			 		var p_chg_cd=sheetObj.GetCellValue(j, prefix2 + "chg_cd");
 			 		var p_curr_cd=sheetObj.GetCellValue(j, prefix2 + "curr_cd");
 			 		var rat_ut_cd=sheetObj.GetCellValue(j, prefix2 + "rat_ut_cd");
 			 		var incl_oft_flg=sheetObj.GetCellValue(j, prefix2 + "incl_oft_flg");
 					if('PC' == rat_ut_cd) continue;// except PC
 					if('I' == incl_oft_flg || 'E' == incl_oft_flg) continue;// except I,E
 					// except hidden value
 					if(sheetObj.GetRowHidden(j) || sheetObj.GetRowStatus(j) == "D")continue;
 					if(p_chg_cd.length > 0 && p_curr_cd.length > 0 ){
 						if (p_chg_cd == o_chg_cd &&p_curr_cd == o_curr_cd) {
 							sumAmount=sumAmount + parseFloat(sheetObj.GetCellValue(j, prefix2 + "chg_amt"));
 					 	}
 					}
 			 	 }
 		 	}
		}
	}
	return sumAmount;
}
  
//-----------------------------------------------------------------------
/**
 * Check your 3rd office
 * @param sheetObj
 * @param Row
 * @param vnTaxChg
 */
function fnVNCheck3rdOffice(sheetObj, Row, vnTaxChg){
	if(sheetObj.GetRowHidden(Row) || "D" == sheetObj.GetRowStatus(Row)) return true;
  	if(vnTaxChg == "") return true;
  	var formObj=document.form;
  	var rate_chg_cd		=sheetObj.GetCellValue(Row, prefix2 + "chg_cd");
  	var rate_rat_ut_cd	=sheetObj.GetCellValue(Row, prefix2 + "rat_ut_cd");
  	var tax_flg   		=sheetObj.GetCellValue(Row, prefix2 + "tax_flg");
  	var n3pty_rcv_ofc_cd=sheetObj.GetCellValue(Row, prefix2 + "n3pty_rcv_ofc_cd");
  	var frt_term_cd		=sheetObj.GetCellValue(Row, prefix2 + "frt_term_cd");
  	var incl_oft_flg	=sheetObj.GetCellValue(Row, prefix2 + "incl_oft_flg");
  	var rate_tax 		=[];
  	var sheet5_cnt		=0;
  	var sheet5_chg_cd	="";
  	var sheet5_pchg_cd	="";
  	var sheetObject5	=sheetObjects[4];
  	
  	var cnt=sheetObject5.RowCount();
  	
  	if('Y' == tax_flg || 'I' == incl_oft_flg || 'E' == incl_oft_flg)		return true;
	if("" == n3pty_rcv_ofc_cd)						return true;
	
	if("VN" != fnLocCdByOfcCd(n3pty_rcv_ofc_cd).substring(0,2))		return true;
  	
	var chkCnt = 0;
  	//for vnTaxChg
  	for(var i=0;i<vnTaxChg.length;i++){
  		rate_tax = vnTaxChg[i];	//rate_tax[0] : chg_cd, rate_tax[1] : frt_term_cd
  		
  		//PRI manualSurcharge
  		for(var j=0;j<cnt+1;j++){

  			sheet5_chg_cd = sheetObject5.GetCellValue(j+1, prefix5 + "chg_cd");
  			sheet5_pchg_cd = sheetObject5.GetCellValue(j+1, prefix5 + "pchg_cd");
  			
  			//check 3rd office가 베트남tax에 대한 source charge 라면...
  			if(rate_chg_cd == sheet5_chg_cd && rate_tax == sheet5_pchg_cd){
  				
  				//전체 charge 중에서 3rd 가 동일한 TAX 를 입력한 charge가 존재하면 pass..
  				var cnt2 = sheetObj.RowCount();
  				for(var k=1;k<cnt2+1;k++){
  					if(k==Row)	continue;	//본인 charge는 skip한다.
  					if('I' == sheetObj.GetCellValue(k, prefix2 + "incl_oft_flg") || 'E' == sheetObj.GetCellValue(k, prefix2 + "incl_oft_flg"))	
  						continue;
  					
  					if('Y' == sheetObj.GetCellValue(k, prefix2 + "tax_flg") && 'PC' == sheetObj.GetCellValue(k, prefix2 + "rat_ut_cd"))				
  						continue;
  					
  					if(frt_term_cd != sheetObj.GetCellValue(k, prefix2 + "frt_term_cd"))
  						continue;
  					
  					if(n3pty_rcv_ofc_cd == sheetObj.GetCellValue(k, prefix2 + "n3pty_rcv_ofc_cd")
  						&& rate_tax == sheetObj.GetCellValue(k, prefix2 + "chg_cd")
  					){
  						chkCnt++;
  						continue;
  					}
  				}
  			}
  		}
  	}
  	if(chkCnt==0)		return false;
  	else if(chkCnt==1)	return true;		//pass..
  	else				return false;		
}

/**
 * Check your 3rd office
 * @param sheetObj
 * @param Row
 * @param vnTaxChg
 */
function fnNoVNCheck3rdOffice(sheetObj, Row){
	if(sheetObj.GetRowHidden(Row) || "D" == sheetObj.GetRowStatus(Row)) return true;
  	var formObj=document.form;
  	var rate_chg_cd		=sheetObj.GetCellValue(Row, prefix2 + "chg_cd");
  	var rate_rat_ut_cd	=sheetObj.GetCellValue(Row, prefix2 + "rat_ut_cd");
  	var tax_flg   		=sheetObj.GetCellValue(Row, prefix2 + "tax_flg");
  	var n3pty_rcv_ofc_cd=sheetObj.GetCellValue(Row, prefix2 + "n3pty_rcv_ofc_cd");
  	var frt_term_cd		=sheetObj.GetCellValue(Row, prefix2 + "frt_term_cd");
  	var incl_oft_flg	=sheetObj.GetCellValue(Row, prefix2 + "incl_oft_flg");
  	
  	if('Y' == tax_flg || 'I' == incl_oft_flg || 'E' == incl_oft_flg)		
  		return true;
	if("" == n3pty_rcv_ofc_cd)						return true;
	
	if("VN" != fnLocCdByOfcCd(n3pty_rcv_ofc_cd).substring(0,2))		return true;
  	
  	var sheet8_cnt		=0;
  	var sheet8_chg_cd	="";
  	var sheet8_pchg_cd	="";
  	var sheetObject8	=sheetObjects[7];
  	var cnt=sheetObject8.RowCount();
	var chkCnt = 0;
	var isVnchg = false;
	//PRI tax manualSurcharge
	for(var j=0;j<cnt+1;j++){
		sheet8_chg_cd = sheetObject8.GetCellValue(j+1, prefix8 + "chg_cd");
		sheet8_pchg_cd = sheetObject8.GetCellValue(j+1, prefix8 + "pchg_cd");
		
		//check 3rd office가 베트남tax에 대한 source charge 라면...
		if(rate_chg_cd == sheet8_chg_cd){
			isVnchg = true;
			//전체 charge 중에서 3rd 가 동일한 TAX 를 입력한 charge가 존재하면 pass..
			var cnt2 = sheetObj.RowCount();
			for(var k=1;k<cnt2+1;k++){
				if(k==Row)	continue;	//본인 charge는 skip한다.
				if('I' == sheetObj.GetCellValue(k, prefix2 + "incl_oft_flg") || 'E' == sheetObj.GetCellValue(k, prefix2 + "incl_oft_flg"))	
					continue;
				if('Y' == sheetObj.GetCellValue(k, prefix2 + "tax_flg") && 'PC' == sheetObj.GetCellValue(k, prefix2 + "rat_ut_cd"))
					continue;
				
				if(frt_term_cd != sheetObj.GetCellValue(k, prefix2 + "frt_term_cd"))
					continue;
				
				if(n3pty_rcv_ofc_cd == sheetObj.GetCellValue(k, prefix2 + "n3pty_rcv_ofc_cd")
						&& sheet8_pchg_cd == sheetObj.GetCellValue(k, prefix2 + "chg_cd"))
				{
					chkCnt++;
					continue;
				}
			}
		}
	}
	if(isVnchg){
	  	if(chkCnt==0)		return false;
	  	else if(chkCnt==1)	return true;		//pass..
	  	else				return false;		
	}else{
		return true;
	}
}

/**
 * Obtain the Vietnam Tax for Charge Rate.
 * @param sheetObj
 */
function fnVNTaxCharge(sheetObj, frt_term_cd){
	var taxChg = [];
	var cnt=sheetObj.RowCount();
	for(var i=1; i < cnt+1; i++){
		if(sheetObj.GetRowHidden(i) || "D" == sheetObj.GetRowStatus(i)){
			continue;
		}
		if(frt_term_cd == "P" || frt_term_cd == "C"){
			if(sheetObj.GetCellValue(i, prefix2 + "tax_flg") == "Y" 
				&& sheetObj.GetCellValue(i, prefix2 + "rat_ut_cd") == "PC"
				&& sheetObj.GetCellValue(i, prefix2 + "vn_flg") == "Y"
				&& sheetObj.GetCellValue(i, prefix2 + "frt_term_cd") == frt_term_cd
			){
				taxChg.push(sheetObj.GetCellValue(i, prefix2 + "chg_cd"));
			}
		}else{
			if(sheetObj.GetCellValue(i, prefix2 + "tax_flg") == "Y" 
				&& sheetObj.GetCellValue(i, prefix2 + "rat_ut_cd") == "PC"
				&& sheetObj.GetCellValue(i, prefix2 + "vn_flg") == "Y"
			){
				taxChg.push(sheetObj.GetCellValue(i, prefix2 + "chg_cd"));
			}
		}
	}
	
	

	//중복 charge 제거 로직 추가.
	return taxChg.reduce(function(a,b){if(a.indexOf(b)<0)a.push(b);return a;},[]);
}


/**
 * Vietnam TAX check
 * @param sheetObj
 * @param type
 * @returns {Boolean}
 */
function fnVNCheckOffice(sheetObj, type){
  	var cnt=sheetObj.RowCount();
	for(var i=1; i < cnt+1; i++){
		if(sheetObj.GetRowHidden(i) || "D" == sheetObj.GetRowStatus(i)){
			continue;
		}
		if(sheetObj.GetCellValue(i, prefix2 + "frt_term_cd") == type){
			if(sheetObj.GetCellValue(i, prefix2 + "tax_flg") == "Y" 
				&& sheetObj.GetCellValue(i, prefix2 + "rat_ut_cd") == "PC"
				&& sheetObj.GetCellValue(i, prefix2 + "vn_flg") == "Y"){

				return i;
			}
		}
	}
	return 0;
}

  
var current_Row='';
var current_Col='';
/**
 * t10Sheet2 on popup click event handling
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function t10sheet2_OnPopupClick(sheetObj, Row, Col) {
	current_Row=Row;
	current_Col=Col;
	if (sheetObj.ColSaveName(Col) == prefix2 + "chg_cd") {
		ComOpenPopup('/opuscntr/ESM_BKG_0975.do?pgmNo=ESM_BKG_0975&chg_cd='+sheetObj.GetCellValue(Row, prefix2 + "chg_cd"), 650, 570, 'getBKG_0975', '0,0', true, true, Row, prefix2 + "chg_cd", 1);
	} else if (sheetObj.ColSaveName(Col) == prefix2 + "curr_cd") {
		ComOpenPopup('/opuscntr/COM_ENS_N13.do?pgmNo=COM_ENS_N13', 700, 450, 'getCOM_ENC_N13', '1,0,1,1,1', true, true, Row, prefix2 + "curr_cd", 1);
	} else if (sheetObj.ColSaveName(Col) == prefix2 + "rat_ut_cd") {
		ComOpenPopup('/opuscntr/ESM_PRI_4002.do?pgmNo=ESM_PRI_4002', 1024, 650, 'getPRI_4002', '1,0,1,1,1', false, true, Row, prefix2 + "rat_ut_cd", 1);
	} else if (sheetObj.ColSaveName(Col) == prefix2 + "n3pty_cust_seq") {
		ComOpenPopup('/opuscntr/COM_ENS_041.do?pgmNo=COM_ENS_041', 800, 440, 'getCOM_ENS_041', '1,0,1,1,1', true, true, Row, prefix2 + "n3pty_cust_seq", 1);
	}
}
/**
 * call back function after BKG_0961 
 * @param _val
 * @param rType
 * @return
 */
function getBKG_0961(_val,rType) {
	if (_val == null) return;// return in case of null
	var formObj=document.form;
	var obj=_val;
	if("PPD" == rType){
		ComSetObjValue(formObj.frm_p_t10sheet3_cnt_cd, obj.cust_cnt_cd );
		ComSetObjValue(formObj.frm_p_t10sheet3_cust_seq, obj.cust_seq );
		ComSetObjValue(formObj.frm_p_t10sheet3_cust_seq_enable, '');
	}else{
		ComSetObjValue(formObj.frm_c_t10sheet3_cnt_cd, obj.cust_cnt_cd);
		ComSetObjValue(formObj.frm_c_t10sheet3_cust_seq, obj.cust_seq);
		ComSetObjValue(formObj.frm_c_t10sheet3_cust_seq_enable, '');
	}
}
/**
 * call back function after BKG_0771
 * @param _val
 * @return
 */
function getBKG_0771(_val) {
	if (_val == null) return;// return in case of null
	try{
		if(_val.msg == "OK"){
			tab_alert_msg=true;
			doActionIBSheet(sheetObjects[1], document.form, IBSAVE);
		}
	}catch(e){
		fnBkgErrorAlert('getBKG_0771', e);
	}
}
/**
 * call back function after BKG_0700
 * @param _val
 * @return
 */
function getBKG_0700(_val) {
	if (_val == null) return;// return in case of null
	var obj=_val;
	var sheetObj=sheetObjects[1];
	// [1.row hidden] check exist CAF -->At any case, do not overwrite the current CAF row
//	var cnt=sheetObj.RowCount();
//	for ( var ix=1; ix <= cnt; ix++) {
//		var chg_cd=sheetObj.GetCellValue(ix, prefix2 + "chg_cd");
//		if("CAF" == chg_cd){
//			fnGetRowHidden(sheetObj,ix);// 2.row hidden
//		}
//	}
	//CAF : add new row 
	var newRow=setDataInsert(sheetObj, 1);
	sheetObj.SetRowStatus(newRow,"R");
	sheetObj.SetCellValue(newRow, prefix2 + "chg_cd",obj.caf_charge);
	sheetObj.SetCellValue(newRow, prefix2 + "curr_cd",obj.caf_cur);
	sheetObj.SetCellValue(newRow, prefix2 + "rat_ut_cd",obj.caf_per);
	sheetObj.SetCellValue(newRow, prefix2 + "chg_ut_amt",obj.caf_rate);
	sheetObj.SetCellValue(newRow, prefix2 + "rat_as_qty",obj.caf_rate_as);
	sheetObj.SetCellValue(newRow, prefix2 + "chg_amt",obj.caf_amount);
}
/**
 * setting data for insert
 * @param sheetObj
 * @param sNo
 * @return
 */
function setDataInsert(sheetObj, sNo) {
	var formObj=document.form;
	switch (sNo) {
	case 1:
		var nRow=sheetObj.DataInsert(-1);
		sheetObj.SetCellValue(nRow, prefix2 + "chg_cd",'' , 0);
		sheetObj.SetCellValue(nRow, prefix2 + "trf_itm_no",'' , 0);
		sheetObj.SetCellValue(nRow, prefix2 + "curr_cd",'' , 0);
		sheetObj.SetCellValue(nRow, prefix2 + "chg_ut_amt",'0' , 0);
		sheetObj.SetCellValue(nRow, prefix2 + "rat_as_qty",'0' , 0);
		sheetObj.SetCellValue(nRow, prefix2 + "rat_ut_cd",'' , 0);
		sheetObj.SetCellValue(nRow, prefix2 + "chg_amt",'0' , 0);
		sheetObj.SetCellValue(nRow, prefix2 + "incl_oft_flg",'N' , 0);
		sheetObj.SetCellValue(nRow, prefix2 + "frt_term_cd",ComGetObjValue(frt_term_cd), 0);
		sheetObj.SetCellValue(nRow, prefix2 + "n3pty_rcv_ofc_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "n3pty_cust_cnt_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "n3pty_cust_seq",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "cgo_cate_cd",'DR', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "rcv_term_cd",ComGetObjValue(formObj.frm_t10sheet1_rcv_term_cd), 0);
		sheetObj.SetCellValue(nRow, prefix2 + "de_term_cd",ComGetObjValue(formObj.frm_t10sheet1_de_term_cd), 0);
		sheetObj.SetCellValue(nRow, prefix2 + "imdg_clss_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "auto_rat_cd",'M', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "prn_hdn_flg",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "tax_flg",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "tax_cnt_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "vn_flg",'', 0);
		break;
	case 2:
		var nRow=sheetObj.DataInsert(-1); // add to bottom
		sheetObj.SetCellValue(nRow, prefix2 + "chg_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "trf_itm_no",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "curr_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "chg_ut_amt",'0', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "rat_as_qty",'0', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "rat_ut_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "chg_amt",'0', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "incl_oft_flg",'N', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "frt_term_cd",ComGetObjValue(frt_term_cd), 0);
		sheetObj.SetCellValue(nRow, prefix2 + "n3pty_rcv_ofc_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "n3pty_cust_cnt_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "n3pty_cust_seq",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "cgo_cate_cd",'DR', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "rcv_term_cd",ComGetObjValue(formObj.frm_t10sheet1_rcv_term_cd), 0);
		sheetObj.SetCellValue(nRow, prefix2 + "de_term_cd",ComGetObjValue(formObj.frm_t10sheet1_de_term_cd), 0);
		sheetObj.SetCellValue(nRow, prefix2 + "imdg_clss_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "auto_rat_cd",'A', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "prn_hdn_flg",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "tax_flg",'N', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "tax_cnt_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "vn_flg",'N', 0);
		break;
	case 3:
		var nRow=sheetObj.DataInsert(); // add to below cursor
		sheetObj.SetCellValue(nRow, prefix2 + "chg_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "trf_itm_no",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "curr_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "chg_ut_amt",'0', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "rat_as_qty",'0', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "rat_ut_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "chg_amt",'0', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "incl_oft_flg",'N', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "frt_term_cd",ComGetObjValue(frt_term_cd), 0);
		sheetObj.SetCellValue(nRow, prefix2 + "n3pty_rcv_ofc_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "n3pty_cust_cnt_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "n3pty_cust_seq",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "cgo_cate_cd",'DR', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "rcv_term_cd",ComGetObjValue(formObj.frm_t10sheet1_rcv_term_cd), 0);
		sheetObj.SetCellValue(nRow, prefix2 + "de_term_cd",ComGetObjValue(formObj.frm_t10sheet1_de_term_cd), 0);
		sheetObj.SetCellValue(nRow, prefix2 + "imdg_clss_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "auto_rat_cd",'A', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "prn_hdn_flg",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "tax_flg",'N', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "tax_cnt_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "vn_flg",'N', 0);
		break;
	case 4:
		var nRow=sheetObj.DataInsert(0);// add first
		sheetObj.SetCellValue(nRow, prefix2 + "chg_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "trf_itm_no",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "curr_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "chg_ut_amt",'0', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "rat_as_qty",'0', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "rat_ut_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "chg_amt",'0', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "incl_oft_flg",'N', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "frt_term_cd",ComGetObjValue(frt_term_cd), 0);
		sheetObj.SetCellValue(nRow, prefix2 + "n3pty_rcv_ofc_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "n3pty_cust_cnt_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "n3pty_cust_seq",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "cgo_cate_cd",'DR', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "rcv_term_cd",ComGetObjValue(formObj.frm_t10sheet1_rcv_term_cd), 0);
		sheetObj.SetCellValue(nRow, prefix2 + "de_term_cd",ComGetObjValue(formObj.frm_t10sheet1_de_term_cd), 0);
		sheetObj.SetCellValue(nRow, prefix2 + "imdg_clss_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "auto_rat_cd",'A', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "prn_hdn_flg",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "tax_flg",'N', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "tax_cnt_cd",'', 0);
		sheetObj.SetCellValue(nRow, prefix2 + "vn_flg",'N', 0);
		break;
	}
	return nRow;
}
/**
 * call back function after t10sheet2_OnPopupClick
 * @param rowArray
 * @param Row
 * @param Col
 * @param sheetIdx
 * @return
 */
function getBKG_0975(rowArray, Row, Col, sheetIdx) {
	sheetObjects[sheetIdx].SetCellValue(Row, prefix2 + "exist_chg_cd",'');
	sheetObjects[sheetIdx].SetCellValue(Row, Col,rowArray[0][1]);
	sheetObjects[sheetIdx].SetCellValue(Row, prefix2 + "tax_flg",rowArray[0][3]);
	sheetObjects[sheetIdx].SetCellValue(Row, prefix2 + "tax_cnt_cd"		,"");
	sheetObjects[sheetIdx].SetCellValue(Row, prefix2 + "vn_flg"			,"N");
	
	
	if(rowArray[0][3]=="Y"){
		var param="&f_cmd=" + SEARCH14 + "&chg_cd=" + rowArray[0][1];
		var sXml=sheetObjects[sheetIdx].GetSearchData("ESM_Booking_UtilGS.do", param);
		var tax_cnt_cd=ComGetEtcData(sXml, "tax_cnt_cd");
		sheetObjects[sheetIdx].SetCellValue(Row, prefix2 + "tax_cnt_cd",tax_cnt_cd);
		if(tax_cnt_cd == "VN"){
			sheetObjects[sheetIdx].SetCellValue(Row, prefix2 + "vn_flg","Y");
		}else{
			sheetObjects[sheetIdx].SetCellValue(Row, prefix2 + "vn_flg","N");
		}
	}
}
/**
 * call back function after t10sheet2_OnPopupClick
 * @param rowArray
 * @param Row
 * @param Col
 * @param sheetIdx
 * @return
 */
function getCOM_ENC_N13(rowArray, Row, Col, sheetIdx) {
	sheetObjects[sheetIdx].SetCellValue(Row, prefix2 + "exist_curr_cd",'');
	sheetObjects[sheetIdx].SetCellValue(Row, Col,rowArray[0][2]);
}
/**
 * call back function after t10sheet2_OnPopupClick
 * @param rowArray
 * @param Row
 * @param Col
 * @param sheetIdx
 * @return
 */
function getPRI_4002(rowArray, Row, Col, sheetIdx) {
	sheetObjects[sheetIdx].SetCellValue(Row, prefix2 + "exist_rat_ut_cd",'');
	sheetObjects[sheetIdx].SetCellValue(Row, Col,rowArray[0][3]);
}
/**
 * call back function after t10sheet2_OnPopupClick
 * @param rowArray
 * @param Row
 * @param Col
 * @param sheetIdx
 * @return
 */
function getCOM_ENS_041(rowArray, Row, Col, sheetIdx) {
	var _val=rowArray[0][3];
	sheetObjects[sheetIdx].SetCellValue(Row, prefix2 + "n3pty_cust_cnt_cd",_val.substring(0, 2));
	sheetObjects[sheetIdx].SetCellValue(Row, prefix2 + "n3pty_cust_seq",_val.substring(2));
	sheetObjects[sheetIdx].SetCellValue(Row, prefix2 + "exist_cust_seq",'');
}
/**
 * setting date from UI_1077
 * @param rValue
 */
function getBKG_1077 (rValue){
	  var formObj=document.form;
	  ComSetObjValue(formObj.frm_t10sheet1_rt_aply_dt, rValue);
}
/**
 * call back function after pop_del_cgo_curr_cd Click
 * @param rowArray
 * @return
 */
function getCOM_CUR_N13(rowArray) {
	var formObj=document.form;
	formObj.frm_t10sheet1_decl_cgo_curr_cd.value = rowArray[0][2];
}

/**
 * Sheet process handling
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = 1;
	var formObj=document.form;
	var aryPrefix=new Array(prefix1, prefix2, prefix3,prefix4,prefix5,prefix6,prefix7,prefix8);
	switch (sAction) {
	case INIT:      //Default
		var sXml=document.frm.sXml.value;
		var arrXml=sXml.split("|$$|");    
		if (arrXml.length > 0){
			ComBkgXml2ComboItem(arrXml[0], rt_bl_tp_cd, "val", "name");
		}
		if (arrXml.length > 1){
			ComBkgXml2ComboItem(arrXml[1], frt_term_cd, "val", "name");			
		}
	case IBSEARCH: //Retrieve
		if (!validateForm(sheetObj, formObj, sAction))  return;
		// init
		ComSetObjValue(formObj.autoRate, "N" );
		ComSetObjValue(formObj.removeAll, "N" );
		fnClearForm();
		sheetObjects[6].RemoveAll();
		fnClearSelect('svc_scp_cd');// Service Scope
		// 1. setting parameter before retrieve
		ComSetObjValue(formObj.f_cmd, SEARCH);
		ComSetObjValue(formObj.application_date, ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt).split('-').join(""));
		ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.frm_t10sheet1_bkg_no));
		ComSetObjValue(formObj.bl_no, ComGetObjValue(formObj.frm_t10sheet1_bl_no));
		ComOpenWait(true);
		// 2. retrieve
		var sXml=sheetObj.GetSearchData("ESM_BKG_0079_08GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		// 3. result transaction
		var arrXml=sXml.split("|$$|");
		var State=ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY");
		if ( State == "S" ) {
			for ( var inx=0; inx < arrXml.length; inx++) {
				sheetObjects[inx].LoadSearchData(arrXml[inx],{Sync:1} );
			}
			
			ComOpenWait(false);
			ComSetObjValue(formObj.caflag,ComGetEtcData(arrXml[0], "caflag"));
			ComSetObjValue(formObj.bdrflag,ComGetEtcData(arrXml[0], "bdrflag"));
			ComSetObjValue(formObj.oblIssFlg,ComGetEtcData(arrXml[0], "oblIssFlg"));
			ComSetObjValue(formObj.multi_cgo,ComGetEtcData(arrXml[0], "multi_cgo"));
			// auto filling ofc_cd
			if( '' != ComGetEtcData(arrXml[0], "rOfc_cd") && undefined != ComGetEtcData(arrXml[0], "rOfc_cd")){
				ComSetObjValue(formObj.rOfc_cd,ComGetEtcData(arrXml[0], "rOfc_cd"));
				var rOfc_cd=ComGetObjValue(formObj.rOfc_cd).split("|");
				if(ComIsEmpty(formObj.frm_p_t10sheet3_ofc_cd.value)){
					ComSetObjValue(formObj.frm_p_t10sheet3_ofc_cd, rOfc_cd[0]);
				}
				if(ComIsEmpty(formObj.frm_p_t10sheet3_cnt_cd.value)){
					ComSetObjValue(formObj.frm_p_t10sheet3_cnt_cd, rOfc_cd[1]);
				}
				if(ComIsEmpty(formObj.frm_p_t10sheet3_cust_seq.value) || '0' == ComGetObjValue(formObj.frm_p_t10sheet3_cust_seq) ){
					ComSetObjValue(formObj.frm_p_t10sheet3_cust_seq, rOfc_cd[2]);
				}
				if(ComIsEmpty(formObj.frm_c_t10sheet3_ofc_cd.value)){
					ComSetObjValue(formObj.frm_c_t10sheet3_ofc_cd, rOfc_cd[3]);
				}
				if(ComIsEmpty(formObj.frm_c_t10sheet3_cnt_cd.value)){
					ComSetObjValue(formObj.frm_c_t10sheet3_cnt_cd, rOfc_cd[4]);
				}
				if(ComIsEmpty(formObj.frm_c_t10sheet3_cust_seq.value) || '0' == ComGetObjValue(formObj.frm_c_t10sheet3_cust_seq)){
					ComSetObjValue(formObj.frm_c_t10sheet3_cust_seq, rOfc_cd[5]);
				}
			}
			// enable/disable by BDR FLAG 
			if ('Y' == ComGetObjValue(formObj.bdrflag) && 'N' == ComGetObjValue(formObj.caflag)) {
				setBookingEditable(false);
			}else{
				setBookingEditable(true);
			}
			//1. change Note button color 
			fnExistNoteButtonColor();
			ComSetObjValue(formObj.sc_available,'Y');
			ComSetObjValue(formObj.rfa_available,'Y');
			ComSetObjValue(formObj.taa_available,'Y');
			fnCheckNumber('sc_no',  ComGetObjValue(formObj.frm_t10sheet1_sc_no1)+ComGetObjValue(formObj.frm_t10sheet1_sc_no2));
			fnCheckNumber('rfa_no', ComGetObjValue(formObj.frm_t10sheet1_rfa_no));
			fnCheckNumber('taa_no', ComGetObjValue(formObj.frm_t10sheet1_taa_no));
			
			//Bill Type default : N 
			ComSetObjValue(rt_bl_tp_cd, fnNullToBlank(ComGetObjValue(formObj.frm_t10sheet1_rt_bl_tp_cd), "N"));
			
			// Freight Term setting
			ComSetObjValue(frt_term_cd, fnNullToBlank(ComGetObjValue(formObj.frm_t10sheet1_frt_term_cd), "P"));
			
			ComSetObjValue(document.form.modify_flag, "N");
			// check change Y/N
			fnModifyCheckBefore();
			// - fnCheckBrk_dwn_flg
			/* set N to Break Down FLG in case of TPE, TPW, other Y */ 
			fnCheckBrk_dwn_flg();
			temp_value='';
			change_prn_hdn_flg=false;
			//save버튼 처리 jsy
			if(ComGetObjValue(formObj.isInquiry) == "Y"){
				setInquiryDisableButton();
			}
			try{
				// C/A button Control 
				parent.initCAControl(	ComGetObjValue(formObj.bkg_no), 
										ComGetObjValue(formObj.caflag), 
										ComGetObjValue(formObj.bdrflag), 
										ComGetEtcData(arrXml[0], "ca_exist_flg"), 
										ComGetObjValue(formObj.bl_no));
			}catch(e){}
			// show message in case of not exist Service Scope 
			var message=ComGetEtcData(arrXml[0],"message");
			if(message != null){
				var rmsg=message.split("<||>");
				if(rmsg[3] != undefined && rmsg[3].length > 0) {
					ComShowMessage(rmsg[3]);
				}
			}
		}else{
			ComShowMessage(ComGetMsg("BKG00095"));
			fnClearForm();
			fnClearSelect('svc_scp_cd');// Service Scope
			ComResetAll();
			ComOpenWait(false);
		}
		//fnSearchRtAplyDateCheck();
		// disable button in case of inquiry
		if(ComGetObjValue(formObj.isInquiry) == "Y"){
			setInquiryDisableButton();
		}
		selfAuditExecute();
//		if (isOpenSelfAudit && ComShowCodeConfirm("BKG08185")) {  //Do you continue to self-audit?
//			document.getElementById("btn_t10self").fireEvent("onclick");
//		}
//		isOpenSelfAudit = false;
//		isOpenSelfAudit2 = false;
		return;
		//break;
	case IBSAVE: //Save
		if (!validateForm(sheetObj, formObj, sAction)) return false;
		// return in case of start with DUM
		/* check validation in case of contract is one more and exist DUM */
		if(!ComIsEmpty(formObj.frm_t10sheet1_sc_no1.value)&&!ComIsEmpty(formObj.frm_t10sheet1_rfa_no.value)
		  ||!ComIsEmpty(formObj.frm_t10sheet1_rfa_no.value)&&!ComIsEmpty(formObj.frm_t10sheet1_taa_no.value)
		  ||!ComIsEmpty(formObj.frm_t10sheet1_sc_no1.value)&&!ComIsEmpty(formObj.frm_t10sheet1_taa_no.value)
		  ||!ComIsEmpty(formObj.frm_t10sheet1_sc_no1.value)&&!ComIsEmpty(formObj.frm_t10sheet1_rfa_no.value)&&!ComIsEmpty(formObj.frm_t10sheet1_taa_no.value))		
		{
			if(formObj.frm_t10sheet1_sc_no1.value.indexOf("DUM") != -1 || formObj.frm_t10sheet1_rfa_no.value.indexOf("DUM") != -1 ||formObj.frm_t10sheet1_taa_no.value.indexOf("DUM") != -1){
				if(tab_alert_msg){
					ComShowCodeMessage("BKG08150");
				}
				return false;
			}
		}
		if(ComIsEmpty(formObj.frm_t10sheet1_sc_no1.value)&&ComIsEmpty(formObj.frm_t10sheet1_rfa_no.value)&&ComIsEmpty(formObj.frm_t10sheet1_taa_no.value)){
			if(tab_alert_msg){
				ComShowCodeMessage("BKG08149");
			}
			return false;
		}
		//check number 
		//check in case of clear data
		if(!ComIsEmpty(formObj.frm_t10sheet1_sc_no1.value)){
			if('N' == ComGetObjValue(formObj.sc_available)){
			//Unable to save due to invalid S/C No.!
				if(tab_alert_msg){ComShowCodeMessage("BKG00281");ComSetFocus(formObj.frm_t10sheet1_sc_no1);}
				return false;
			}
		}
		// check in case of clear data		
		if(!ComIsEmpty(formObj.frm_t10sheet1_rfa_no.value)){
			if('N' == ComGetObjValue(formObj.rfa_available)){
			//Unable to save due to invalid RFA No.!
				if(tab_alert_msg){ComShowCodeMessage("BKG00282");ComSetFocus(formObj.frm_t10sheet1_rfa_no); }
				return false;
			}
		}
		//check in case of clear data		
		if(!ComIsEmpty(formObj.frm_t10sheet1_taa_no.value)){
			if('N' == ComGetObjValue(formObj.taa_available)){
			//Unable to save due to wrong code.
				if(tab_alert_msg){ComShowCodeMessage("BKG08146");ComSetFocus(formObj.frm_t10sheet1_taa_no); }
				return false;
			}
		}
//2014.10.07. 		
//		/**
//		 * showing message Error in case of Rate equal 0 or Rated As is 0
//		 * check when save click
//		 * Rate = 0 :  BKG00899 , Message : Rate is not
//		 * available
//		 */
//		var cnt=sheetObj.RowCount();
//		for ( var ix=1; ix <= cnt; ix++) {
//			if(!sheetObj.GetRowHidden(ix) && sheetObj.GetRowStatus(ix)!= "D"){
//				if(sheetObj.GetCellText(ix, prefix2 + "chg_ut_amt") == "0.00" ){
//					if(tab_alert_msg){
//						ComShowMessage(ComGetMsg("BKG00899", "["+ix+"] Row" ));
//					}
//					sheetObj.SelectCell(ix, prefix2 + "chg_ut_amt");
//					return false;
//				}
//			}
//		}
		/**
		 * Rate As = 0 :  BKG00900 , Message : Rated As is not available
		 */
		for ( var ix=1; ix <= cnt; ix++) {
			if(!sheetObj.GetRowHidden(ix) && sheetObj.GetRowStatus(ix)!= "D"){
				if(sheetObj.GetCellText(ix, prefix2 + "rat_as_qty") == "0.000" ){
					if(tab_alert_msg){
						ComShowMessage(ComGetMsg("BKG00900", "["+ix+"] Row" ));
					}
					sheetObj.SelectCell(ix, prefix2 + "rat_as_qty");
					return false;
				}
			}
		}
		/**
		 * Amount = 0 :  BKG00900 , Message : Rated As is not available
		 */
		for ( var ix=1; ix <= cnt; ix++) {
			if(!sheetObj.GetRowHidden(ix) && sheetObj.GetRowStatus(ix)!= "D"){
				if(Number(sheetObj.GetCellText(ix, prefix2 + "chg_amt")) == "0" ){
					if(tab_alert_msg){
						ComShowMessage(ComGetMsg("BKG00902", "["+ix+"] Row" ));
					}
					sheetObj.SelectCell(ix, prefix2 + "chg_amt");
					return false;
				}
			}
		}
		var exsit_Falg=true;
		// CCT must not equal PPD At
		if(ComGetObjValue(formObj.frm_p_t10sheet3_ofc_cd).length != 0 && ComGetObjValue(formObj.frm_c_t10sheet3_ofc_cd).length != 0){
			if(ComGetObjValue(formObj.frm_p_t10sheet3_ofc_cd) == ComGetObjValue(formObj.frm_c_t10sheet3_ofc_cd)){
				if(tab_alert_msg){
					ComShowMessage(ComGetMsg("BKG00931"));
				}
				ComSetFocus(formObj.frm_p_t10sheet3_ofc_cd);
				return false;
			}
		}
		if(exsit_Falg){
			findRow=sheetObj.FindText(prefix2 + "exist_chg_cd", "N");
			if (findRow > 0) {
				if(tab_alert_msg){
					ComShowMessage(ComGetMsg("BKG06012", "["+findRow+"] Row" ));
				}
				sheetObj.SelectCell(findRow, prefix2 + "chg_cd");
				return false;
			}
			  findRow=sheetObj.FindText(prefix2 + "exist_curr_cd", "N");
			if (findRow > 0) {
				if(tab_alert_msg){
					ComShowMessage(ComGetMsg("BKG06012", "["+findRow+"] Row" ));
				}
				sheetObj.SelectCell(findRow, prefix2 + "curr_cd");
				return false;
			}
			  findRow=sheetObj.FindText(prefix2 + "exist_rat_ut_cd", "N");
			if (findRow > 0) {
				if(tab_alert_msg){
					ComShowMessage(ComGetMsg("BKG06012", "["+findRow+"] Row" ));
				}
				sheetObj.SelectCell(findRow, prefix2 + "rat_ut_cd");
				return false;
			}
			  findRow=sheetObj.FindText(prefix2 + "exist_ofc_cd", "N");
			if (findRow > 0) {
				if(tab_alert_msg){
					ComShowMessage(ComGetMsg("BKG06012", "["+findRow+"] Row" ));
				}
				sheetObj.SelectCell(findRow, prefix2 + "n3pty_rcv_ofc_cd");
				return false;
			}
			  findRow=sheetObj.FindText(prefix2 + "exist_cust_cnt", "N");
			if (findRow > 0) {
				if(tab_alert_msg){
					ComShowMessage(ComGetMsg("BKG06012", "["+findRow+"] Row" ));
				}
				sheetObj.SelectCell(findRow, prefix2 + "n3pty_cust_cnt_cd");
				return false;
			}
			  findRow=sheetObj.FindText(prefix2 + "exist_cust_seq", "N");
			if (findRow > 0) {
				if(tab_alert_msg){
					ComShowMessage(ComGetMsg("BKG06012", "["+findRow+"] Row" ));
				}
				sheetObj.SelectCell(findRow, prefix2 + "n3pty_cust_seq");
				return false;
			}
			// error check : check duplicate third office, collect
			// not showing
			// 1. check Prepaid condition
			if(ComGetObjValue(formObj.frm_p_t10sheet3_ofc_cd).length >= 5){
				findRow=sheetObj.FindText(prefix2 + "n3pty_rcv_ofc_cd", ComGetObjValue(formObj.frm_p_t10sheet3_ofc_cd));
				if (findRow > 0) {
					if(tab_alert_msg){
						ComShowMessage(ComGetMsg("BKG00912", "["+findRow+"] Row" ));
					}
					sheetObj.SelectCell(findRow, prefix2 + "n3pty_rcv_ofc_cd");
					return false;
				}
			}
			if(ComGetObjValue(formObj.frm_c_t10sheet3_ofc_cd).length >= 5){
				//2. check Collect condition 
				findRow=sheetObj.FindText(prefix2 + "n3pty_rcv_ofc_cd", ComGetObjValue(formObj.frm_c_t10sheet3_ofc_cd));
				if (findRow > 0) {
					if(tab_alert_msg){
						ComShowMessage(ComGetMsg("BKG00912", "["+findRow+"] Row" ));
					}
					sheetObj.SelectCell(findRow, prefix2 + "n3pty_rcv_ofc_cd");
					return false;
				}
			}
			// check items before save
			var cnt=sheetObj.RowCount();
			var rf_check_count=0;
			for ( var ix=1; ix <= cnt; ix++) {
				if(sheetObj.GetRowHidden(ix) || "D" == sheetObj.GetRowStatus(ix)) continue;
				// showing error message in case of currency is not USD,AUD,EUR,JPY,GBP,DEM
				// [BKG00913]
				var chg_cd=sheetObj.GetCellValue(ix, prefix2 + "chg_cd");
//				if ("OFT" == chg_cd || "ASC" == chg_cd) {
//					var curr_cd=sheetObj.GetCellValue(ix, prefix2 + "curr_cd");
//					if('USD' == curr_cd||'AUD' == curr_cd|| 'EUR' == curr_cd ||'JPY' == curr_cd||'GBP' == curr_cd||'DEM' == curr_cd ){
//					}else{
//						if(tab_alert_msg){
//							ComShowCodeMessage("BKG00913");
//							// OFT(or ASC) Currency must be 'USD' or 'AUD' or
//							// 'EUR' or 'JPY' or 'GBP' or'DEM'
//						}
//						sheetObj.SelectCell(ix, prefix2 + "curr_cd");
//						return false;
//					}
//				}
				/*
				 * P – prepaid. C – collect
				 * [validation need] collect disable in case of RF
				 */
				var frt_term_cd_code=sheetObj.GetCellValue(ix, prefix2 + "frt_term_cd");
				var cgo_cate_cd=sheetObj.GetCellValue(ix, prefix2 + "cgo_cate_cd");
				var incl_oft_flg=sheetObj.GetCellValue(ix, prefix2 + "incl_oft_flg");
				if ('RF' == cgo_cate_cd && 'C' == frt_term_cd_code && 'N' == incl_oft_flg ) {
					rf_check_count++;
				}
				/*
				 * showing BKG08056 in case of not existing payment term
				 *  "{?msg1} does not have payment term";
				 */
				if('' == frt_term_cd_code){
					if(tab_alert_msg){
						ComShowMessage(ComGetMsg("BKG08056", "["+chg_cd+"]" ));
					}
					 sheetObj.SelectCell(ix, prefix2 + "frt_term_cd");
					 return false;
				}
				var cust_cnt_cd=sheetObj.GetCellValue(ix, prefix2 + "n3pty_cust_cnt_cd");
				var cust_seq=sheetObj.GetCellValue(ix, prefix2 + "n3pty_cust_seq");
				var rcv_ofc_cd=sheetObj.GetCellValue(ix, prefix2 + "n3pty_rcv_ofc_cd");
				if((rcv_ofc_cd.length >= 5)&&(cust_cnt_cd.length == 0)){
					if(tab_alert_msg){
//						ComShowMessage(ComGetMsg("BKG00651", "["+ix+"] Row" ));
						ComShowMessage(ComGetMsg("BKG00767", "["+ix+"] Row - 3rd Payer code" ));
					}
					 sheetObj.SelectCell(ix, prefix2 + "n3pty_cust_cnt_cd");
					 return false;					
				}
				if((rcv_ofc_cd.length >= 5)&&(cust_seq.length == 0)){
					if(tab_alert_msg){
//						ComShowMessage(ComGetMsg("BKG00651", "["+ix+"] Row" ));
						ComShowMessage(ComGetMsg("BKG00767", "["+ix+"] Row - 3rd Payer code" ));
					}
					 sheetObj.SelectCell(ix, prefix2 + "n3pty_cust_seq");
					 return false;					
				}
				if((cust_cnt_cd.length >= 2)&&(rcv_ofc_cd.length == 0)){
					if(tab_alert_msg){
//						ComShowMessage(ComGetMsg("BKG00651", "["+ix+"] Row" ));
						ComShowMessage(ComGetMsg("BKG00767", "["+ix+"] Row - 3rd Office code" ));
					}
					 sheetObj.SelectCell(ix, prefix2 + "n3pty_rcv_ofc_cd");
					 return false;					
				}
				if((cust_cnt_cd.length >= 2)&&(cust_seq.length == 0)){
					if(tab_alert_msg){
//						ComShowMessage(ComGetMsg("BKG00651", "["+ix+"] Row" ));
						ComShowMessage(ComGetMsg("BKG00767", "["+ix+"] Row - 3rd Payer code" ));
					}
					 sheetObj.SelectCell(ix, prefix2 + "n3pty_cust_seq");
					 return false;					
				}
				if((cust_seq.length >= 1)&&(cust_cnt_cd.length == 0)){
					if(tab_alert_msg){
//						ComShowMessage(ComGetMsg("BKG00651", "["+ix+"] Row" ));
						ComShowMessage(ComGetMsg("BKG00767", "["+ix+"] Row - 3rd Payer code" ));
					}
					 sheetObj.SelectCell(ix, prefix2 + "n3pty_cust_cnt_cd");
					 return false;					
				}
				if((cust_seq.length >= 1)&&(rcv_ofc_cd.length == 0)){
					if(tab_alert_msg){
//						ComShowMessage(ComGetMsg("BKG00651", "["+ix+"] Row" ));
						ComShowMessage(ComGetMsg("BKG00767", "["+ix+"] Row - 3rd Office code" ));
					}
					 sheetObj.SelectCell(ix, prefix2 + "n3pty_rcv_ofc_cd");
					 return false;					
				}
			}
		}
		//show alert
		if(rf_check_count > 0){
			if (!ComShowConfirm("[Warning]"+ComGetMsg("BKG08057"))){
				return false;
			}
		}
		//INFO transaction after rating in case of  CHARGE CODE = WSC and existing CONTAINER에 PARTIAL   
		var cntr_prt_flg=sheetObjects[0].GetCellValue(1, prefix1 + "cntr_prt_flg");
		if(cntr_prt_flg == "Y" && auto_rating == true){
			var cnt=sheetObj.RowCount();
			var chg_cd="";
			var auto_rat_cd="";
			var _ibflag="";
			for( var i=1 ; i <= cnt ; i++){
				chg_cd=sheetObj.GetCellValue(i, prefix2 + "chg_cd");
				auto_rat_cd=sheetObj.GetCellValue(i, prefix2 + "auto_rat_cd");
				_ibflag=sheetObj.GetCellValue(i, prefix2 + "ibflag");
				if (_ibflag != "D" && chg_cd == "WSC" && (auto_rat_cd == "A" || auto_rat_cd == "U")){
					ComShowMessage(ComGetMsg("BKG08181"));
					i=cnt + 1;
				}
			}
		}
		// "Master B/L No. can't be used for
		// covered B/L No. Please check B/L No. again."
		var comp1_bl_no=ComGetObjValue(formObj.frm_t10sheet1_bl_no);
		var comp2_bl_no=ComGetObjValue(formObj.covered_name_c);
		ComSetObjValue(formObj.frm_t10sheet1_mst_cvrd_bl, ComGetObjValue(formObj.covered_name_c));
		// 1. setting parameter before retrieve
		ComSetObjValue(formObj.f_cmd, MULTI);
		// select box : rt_bl_tp_cd
		ComSetObjValue(formObj.frm_t10sheet1_rt_bl_tp_cd, ComGetObjValue(rt_bl_tp_cd));
		// select box : frt_term_cd
		ComSetObjValue(formObj.frm_t10sheet1_frt_term_cd, ComGetObjValue(frt_term_cd));
		// select box : svc_scp_cd
		ComSetObjValue(formObj.frm_t10sheet1_svc_scp_cd, ComGetObjValue(formObj.svc_scp_cd));
		// check box : frm_t11sheet1_brk_dwn_flg
		if (formObj.brk_dwn_flg.checked) {
			ComSetObjValue(formObj.frm_t10sheet1_brk_dwn_flg, "Y");
		} else {
			ComSetObjValue(formObj.frm_t10sheet1_brk_dwn_flg, "N");
		}
		// setting bkg_ctrt_tp_cd 
		var bkg_ctrt_tp_cd='';
		if (!ComIsEmpty(formObj.frm_t10sheet1_taa_no.value)) {
			bkg_ctrt_tp_cd='T';
		}else if (!ComIsEmpty(formObj.frm_t10sheet1_rfa_no.value)) {
			bkg_ctrt_tp_cd='R';
		}else if (!ComIsEmpty(formObj.frm_t10sheet1_sc_no1.value)) {
			bkg_ctrt_tp_cd='S';
		}
		// binding to form
		if (IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_")) {};
		// setting SheetObject
		sheetObjects[0].SetCellValue(1, prefix1 + "taa_no",ComGetObjValue(formObj.frm_t10sheet1_taa_no));
		sheetObjects[0].SetCellValue(1, prefix1 + "bkg_ctrt_tp_cd",bkg_ctrt_tp_cd);
		sheetObjects[0].SetCellValue(1, prefix1 + "ppd_rcv_ofc_cd",ComGetObjValue(formObj.frm_p_t10sheet3_ofc_cd));
		sheetObjects[0].SetCellValue(1, prefix1 + "ppd_payr_cnt_cd",ComGetObjValue(formObj.frm_p_t10sheet3_cnt_cd));
		sheetObjects[0].SetCellValue(1, prefix1 + "ppd_payr_cust_seq",ComGetObjValue(formObj.frm_p_t10sheet3_cust_seq));
		sheetObjects[0].SetCellValue(1, prefix1 + "clt_ofc_cd",ComGetObjValue(formObj.frm_c_t10sheet3_ofc_cd));
		sheetObjects[0].SetCellValue(1, prefix1 + "clt_payr_cnt_cd",ComGetObjValue(formObj.frm_c_t10sheet3_cnt_cd));
		sheetObjects[0].SetCellValue(1, prefix1 + "clt_payr_cust_seq",ComGetObjValue(formObj.frm_c_t10sheet3_cust_seq));
		if(tab_alert_msg){
			//Check your 3rd office
			var vnTaxChg = fnVNTaxCharge(sheetObj);
			var check3rd = false;
			var check_chg_cd = "";
			if("" != vnTaxChg){		//Vietnam Tax Charge가 존재할때
				var cnt=sheetObj.RowCount();
				for( var ix=1; ix <= cnt; ix++) {
					vnTaxChg = fnVNTaxCharge(sheetObj, sheetObj.GetCellValue(ix, prefix2 + "frt_term_cd"));
					if(!fnVNCheck3rdOffice(sheetObj, ix, vnTaxChg)){
						check3rd = true;
						check_chg_cd = sheetObj.GetCellValue(ix, prefix2 + "chg_cd");
						break;
					}
				}
			}else{					//Vietnam Tax Charge가 없을때
				var cnt=sheetObj.RowCount();
				var sheetObject8 = sheetObjects[7];
				for( var ix=1; ix <= cnt; ix++) {
					if(!fnNoVNCheck3rdOffice(sheetObj, ix)){
						check3rd = true;
						check_chg_cd = sheetObj.GetCellValue(ix, prefix2 + "chg_cd");
						break;
					}
				}
			}
			//Check Prepaid, Collect Office
			var checkPrepaid = false;
			var idx_charge = fnVNCheckOffice(sheetObj, "P");
			var p_check_chg_cd = "";
//			if(fnVNCheckOffice(sheetObj,"P")){
			if(idx_charge > 0){
				if('VN' != fnLocCdByOfcCd(ComGetObjValue(formObj.frm_p_t10sheet3_ofc_cd)).substring(0,2)){
					p_check_chg_cd = sheetObj.GetCellValue(idx_charge, prefix2 + "chg_cd");
					checkPrepaid = true;
  				}
			}
			
			var checkCollect = false;
			idx_charge = fnVNCheckOffice(sheetObj, "C");
			var c_check_chg_cd = "";
//			if(fnVNCheckOffice(sheetObj,"C")){
			if(idx_charge > 0){
				if('VN' != fnLocCdByOfcCd(ComGetObjValue(formObj.frm_c_t10sheet3_ofc_cd)).substring(0,2)){
					c_check_chg_cd = sheetObj.GetCellValue(idx_charge, prefix2 + "chg_cd");
					checkCollect = true;
  				}
			}

			if ('Y' == ComGetObjValue(formObj.bdrflag) && 'N' == ComGetObjValue(formObj.caflag)) {
				// in case of change
				if(change_prn_hdn_flg){
					if(check3rd){
						if(!ComShowConfirm(ComGetMsg("BKG08361",check_chg_cd))){
							return false; // Are you sure to save the changes?
						}
					}
					if(checkPrepaid){
						ComShowMessage(ComGetMsg("BKG08362",p_check_chg_cd));
						return false;
					}
					if(checkCollect){
						ComShowMessage(ComGetMsg("BKG08363",c_check_chg_cd));
						return false;
					}
					
					if(check3rd){
					}else{
						// Do you want to save changed information in 'Hide' column?
						if (!ComShowConfirm(ComGetMsg("BKG08128"))){
							return false; 
						}
					}
				}else{
					// "Only 'Hide' can be changed after BDR. Please issue C/A."	  
					ComShowMessage(ComGetMsg("BKG08174"));
					return false; 
				}
			}else{
				if(check3rd){
					if(!ComShowConfirm(ComGetMsg("BKG08358",check_chg_cd)))
						return false;
				}
				if(checkPrepaid){
					ComShowMessage(ComGetMsg("BKG08359",p_check_chg_cd));
						return false;
				}
				if(checkCollect){
					ComShowMessage(ComGetMsg("BKG08360",c_check_chg_cd));
						return false;
				}else{
					if(check3rd){
					}else{
						if(!ComShowConfirm(ComGetMsg("BKG00350")))
							return false; // Are you sure to save the changes?
					}
				}				
			}
		}
		/* remove point in case of Save  
		 * Cur = KRW, JPY, IDR, ITL
		 */
//		fnSplitSetAmount();
		formObj.f_cmd.value=MULTI;
		
		// 2. execute by save condition
		var sParam=ComGetSaveString(sheetObjects, true, true);
		if (sParam == "")
			return false;
		sParam += "&" + FormQueryString(formObj); // hidden param value
		sParam += "&" + ComGetPrefixParam(aryPrefix);
		ComOpenWait(true);
		//Self-Audit auto popup Y/N after Save
		//in case of change isOpenSelfAudit(except frt_term) or Application Date
		isOpenSelfAudit=
			isOpenSelfAudit2 ||
			ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt) != ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt_bak);
		
		// 2.Save
		var sXml=sheetObj.GetSaveData("ESM_BKG_0079_08GS.do", sParam);
		// 3.result transaction 
		var State=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
		if(State != null){
			if ( State == "S" ) {
				sheetObj.LoadSaveData(sXml);
				ComShowMessage(ComGetMsg("BKG06071"));

				if(tab_alert_msg){// protect retrieving in case of move TAB
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				}
			} else {
				fnExceptionMessage(sXml);
			}
		}
		break;
	case COMMAND03: // Input
		formObj.f_cmd.value=COMMAND03;
		var param="&f_cmd=" + COMMAND03 + "&bkg_no=" + ComGetObjValue(formObj.frm_t10sheet1_bkg_no);
		var sXml=sheetObj.GetSearchData("ESM_BKG_0079_01GS.do", param);
	 	var bkg_split_no_list=ComGetEtcData(sXml, "bkg_split_no_list");
	 	bkgSplitNoListPop(formObj.frm_t10sheet1_bkg_no,bkg_split_no_list,-15);         	
	 	break;	
	case SEARCH01:
		formObj.f_cmd.value=SEARCH01;
		var param="&f_cmd=" + SEARCH01 + "&bkg_no=" + ComGetObjValue(formObj.frm_t10sheet1_bkg_no);
		sheetObj.GetSearchData("ESM_BKG_0079_08GS.do", param);
		/*

		 * 
		 */
		
		
		
//		var param="&f_cmd=" + COMMAND03 + "&bkg_no=" + ComGetObjValue(formObj.frm_t10sheet1_bkg_no);
//		var sXml=sheetObj.GetSearchData("ESM_BKG_0079_01GS.do", param);
//	 	var bkg_split_no_list=ComGetEtcData(sXml, "bkg_split_no_list");
//	 	bkgSplitNoListPop(formObj.frm_t10sheet1_bkg_no,bkg_split_no_list,-15);         	
	 	break;	
	}
	ComOpenWait(false); 
}
/**
 * input select value to object in the booking split no popup
 * input to object from booking split no
 * @param splitno
 * @return
 */
function bkgSplitSet(splitno){
    document.form.frm_t10sheet1_bkg_no.value=splitno;
    document.form.frm_t10sheet1_bkg_no.focus();
    layList.style.display="none";
    isSplitNoOpen=false;
}
var Text_Bkg_No_Html=null;
var Select_Bkg_No_Html=null;
var Text_Bl_No_Html=null;
var Select_Bl_No_Html=null;
/**
 * set select number box
 * @param _name
 * @param _type
 * @return
 */
function fnSetSelectNumberBox(_name, _type) {
	var vobj=eval("document.all." + _name); // SELECT box position ID
	var sheetObj=sheetObjects[1];
	var formObj=document.form;
	var html="";
	try {
		switch (_type) {
		case 'text_bkg_no': //text
				if(ComIsEmpty(formObj.frm_t10sheet1_bkg_no.value)){
					ComShowMessage(ComGetMsg("BKG00463"));
					ComSetFocus(formObj.frm_t10sheet1_bkg_no);
					return false;
				}
				if (null == Select_Bkg_No_Html || ComGetObjValue(formObj.bkg_no) != ComGetObjValue(formObj.frm_t10sheet1_bkg_no)) {
					var param="&f_cmd=" + COMMAND03 + "&bkg_no=" + ComGetObjValue(formObj.frm_t10sheet1_bkg_no);
		var rXml=sheetObj.GetSearchData("ESM_BKG_0079_01GS.do", param);
					Select_Bkg_No_Html=ComGetEtcData(rXml, "bkg_split_no_list");
					if(Select_Bkg_No_Html.indexOf("<option") < 0) return false;
				}
				var obj=formObj.frm_t10sheet1_bkg_no;
				var top=document.body.clientTop+obj.offsetParent.offsetTop+obj.offsetTop+obj.offsetParent.offsetHeight + 10;
				var left=document.body.clientLeft+obj.offsetParent.offsetLeft+obj.offsetLeft + 10;
				vobj.innerHTML=Select_Bkg_No_Html;
				vobj.style.top=top;					
				vobj.style.left=left;
				vobj.style.display="inline";
		return;
			break; 
		case 'text_bl_no': //text
				if(ComIsEmpty(formObj.frm_t11sheet1_bl_no.value)){
					ComShowMessage(ComGetMsg("BKG00609"));
					ComSetFocus(formObj.frm_t11sheet1_bl_no);
					return false;
				}
				if (null == Select_Bl_No_Html || ComGetObjValue(formObj.bl_no) != ComGetObjValue(formObj.frm_t11sheet1_bl_no)) {
					fnSetBlNoStringCheck(ComGetObjValue(formObj.frm_t11sheet1_bl_no));
					var param=param + "&f_cmd=" + SEARCHLIST15 + "&input_text=" + ComGetObjValue(formObj.bl_no);
		var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
					var output_text=ComGetEtcData(sXml, "output_text");
					output_text=output_text + '^' + output_text;
					Select_Bl_No_Html=fnSetSelectString('fnSetBlNo', output_text);
				}
				var obj=formObj.frm_t11sheet1_bl_no;
				var top=document.body.clientTop+obj.offsetParent.offsetTop+obj.offsetTop+obj.offsetParent.offsetHeight + 10;
				var left=document.body.clientLeft+obj.offsetParent.offsetLeft+obj.offsetLeft + 10;
				vobj.innerHTML=Select_Bl_No_Html;
				vobj.style.top=top;					
				vobj.style.left=left;
				vobj.style.display="inline";
			break;
		}
	} catch (ex) {
		fnBkgErrorAlert('fnSetSelectNumberBox', ex);
	}
}
/**
 * BKG Split No list
 * @param split_list
 * @return
 */
function bkgSplitNoList(split_list){
	document.form.frm_t10sheet1_bkg_no.value=split_list.options[split_list.selectedIndex].value;
	span_bkg_no.style.display="none";
}
/**
 * set select string
 * @param _name
 * @param _value
 * @return
 */
function fnSetSelectString(_name, _value) {
	var html="";
	try {
		var aList=_value.split("^");
		var aCode, aName;
		var aCode=aList[0].split("$");
		var aName=aList[1].split("$");
		var len=aCode.length;
		if (len == 0)
			return;
		html="<select style='width:110;' class='input' size=5 multiple onChange='javascript:bkgSplitNoList(this);' name='" + _name + "'>"
		for ( var z=0; z < len; z++) {
			html += "<option value='" + aCode[z] + "'>" + aName[z] + "</option>";
		}
		html += "</table>";
	} catch (ex) {
		fnBkgErrorAlert('fnSetSelectString', ex);
	}
	return html;
}
/**
 * frt_term_cd change event handling
 * @param idx_cd
 * @param text
 * @return
 */
function frt_term_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;
	if(ComGetObjValue(formObj.frm_t10sheet1_frt_term_cd) != newText ){
		ComSetObjValue(formObj.modify_flag, "Y");
		/* adjust FRT_TERM_CD DATA */
		ComSetObjValue(formObj.frm_t10sheet1_frt_term_cd, newText);
	}else{
		ComSetObjValue(formObj.modify_flag, "N"); 
	}
}
/**
 * rt_bl_type_code change event handling
 * @param idx_cd
 * @param text
 * @return
 */
function rt_bl_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	 var formObj=document.form;
	if ('M' == newText) {
		document.all.covered_name.innerHTML="Covers";
//		document.all.covered_id_m.style.display="block";
		showControl('covered_id_m', true);
//		document.all.covered_id_c.style.display="none";
		showControl('covered_id_c', false);
//		document.all.covered_id_b.style.display="none";
		showControl('covered_id_b', false);
	} else if ('C' == newText) {
		document.all.covered_name.innerHTML="Covered By";
//		document.all.covered_id_c.style.display="block";
		showControl('covered_id_c', true);
//		document.all.covered_id_m.style.display="none";
		showControl('covered_id_m', false);
//		document.all.covered_id_b.style.display="none";
		showControl('covered_id_b', false);
		ComSetObjValue(formObj.covered_name_c, ComGetObjValue(formObj.frm_t10sheet1_mst_cvrd_bl));
	} else if ('B' == newText) {
		document.all.covered_name.innerHTML="INR Auth";
		showControl('covered_id_b', true);
//		document.all.covered_id_c.style.display="none";
		showControl('covered_id_c', false);
//		document.all.covered_id_m.style.display="none";
		showControl('covered_id_m', false);
//		document.all.covered_id_b.style.display="block";

	} else {
		document.all.covered_name.innerHTML="";
//		document.all.covered_id_m.style.display="none";
		showControl('covered_id_m', false);
//		document.all.covered_id_c.style.display="none";
		showControl('covered_id_c', false);
//		document.all.covered_id_b.style.display="none";
		showControl('covered_id_b', false);
	}
	if(ComGetObjValue(formObj.frm_t10sheet1_rt_bl_tp_cd) != newText ){
		ComSetObjValue(formObj.modify_flag, "Y");
	}else{
		ComSetObjValue(formObj.modify_flag, "N"); 
	}
}
 /**
  * handling process after ending t10sheet2 retrieve
  * @param sheetObj
  * @param ErrMsg
  * @return
  */
 function t10sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	 var l_row=sheetObj.RowCount();
	 var formObj=document.form;
	 for ( var i=1; i <= l_row; i++) {
		 var incl_oft_flg=sheetObj.GetCellValue(i, prefix2 + "incl_oft_flg");
		 if ('I' == incl_oft_flg || 'E' == incl_oft_flg) {
			 sheetObj.SetCellFont("FontItalic", i, 1, i,30,1);
			sheetObj.SetCellBackColor(i, prefix2 + "chg_cd","#99CCFF");// blue
		}
		 var tax_flg=sheetObj.GetCellValue(i, prefix2 + "tax_flg");
		 var rat_ut_cd=sheetObj.GetCellValue(i, prefix2 + "rat_ut_cd");
		 if('Y' == tax_flg && "PC" == rat_ut_cd){
			sheetObj.SetCellEditable(i, prefix2 + "chg_cd", 0);
			sheetObj.SetCellEditable(i, prefix2 + "curr_cd", 0);
			sheetObj.SetCellEditable(i, prefix2 + "chg_ut_amt", 0);
			sheetObj.SetCellEditable(i, prefix2 + "rat_ut_cd", 0);
		 }
	 }
 }
var trf_itm_no='';
/**
 * setting fnSetTrf_itm_no
 * @param sheetObj
 * @return
 */
function fnSetTrf_itm_no(sheetObj){
	var formObj=document.form;
	var cnt=sheetObj.RowCount();
	if (cnt == 0)	return;
	var sc_no=ComGetObjValue(formObj.frm_t10sheet1_sc_no1) + ComGetObjValue(formObj.frm_t10sheet1_sc_no2);
	var rfa_no=ComGetObjValue(formObj.frm_t10sheet1_rfa_no);
	var taa_no=ComGetObjValue(formObj.frm_t10sheet1_taa_no);
	if(sc_no != null && sc_no.length > 0){
		trf_itm_no=sc_no;
	}else{
		trf_itm_no='';
	}
	// trf_itm_no 
	for ( var i=1; i <= cnt; i++) {
		if(!sheetObj.GetRowHidden(i) && "D" != sheetObj.GetRowStatus(i)){
			var chg_cd=sheetObj.GetCellValue(i, prefix2 + "chg_cd");
			if ("OFT" == chg_cd) {
				if(ComIsEmpty(sheetObj.GetCellValue(i, prefix2 + "trf_itm_no"))){
					sheetObj.SetCellValue(i, prefix2 + "trf_itm_no",trf_itm_no);
				}
				break;
			}
		}
	}
}
/**
 * handling process after ending t10sheet1 retrieve
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function t10sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj=document.form;
	var cnt=sheetObj.RowCount();
	if (cnt == 0)
		return;
	try {
		
		//FORM VALUE BINDING 
		if (IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_")) {
		}
		;
//		alert(ComGetObjValue(formObj.frm_t10sheet1_doc_loc_cd));
		var l_row=sheetObj.RowCount();
		if(l_row == 0) return;
		
		// Weight
		ComSetObjValue(formObj.frm_t10sheet1_act_wgt, sheetObj.GetCellText(l_row, "t10sheet1_act_wgt"));
		// Measure
		ComSetObjValue(formObj.frm_t10sheet1_meas_qty, sheetObj.GetCellText(l_row, "t10sheet1_meas_qty"));
		// Declared Cargo Value
		ComSetObjValue(formObj.frm_t10sheet1_decl_cgo_chg_amt, sheetObj.GetCellText(l_row, "t10sheet1_decl_cgo_chg_amt"));
		ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.frm_t10sheet1_bkg_no));
		ComSetObjValue(formObj.bl_no, ComGetObjValue(formObj.frm_t10sheet1_bl_no));
		ComSetObjValue(formObj.sc_no, ComGetObjValue(formObj.frm_t10sheet1_sc_no1) + ComGetObjValue(formObj.frm_t10sheet1_sc_no2));
		ComSetObjValue(formObj.application_date, ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt).split('-').join(""));
		// Audit Status : E : RED
		if ('E' == ComGetObjValue(formObj.frm_t10sheet1_aud_sts_cd)) {
			formObj.frm_t10sheet1_aud_sts_cd.style.color='red';
			document.getElementById('btn_t10self').style.color="red";
		}else{
			formObj.frm_t10sheet1_aud_sts_cd.style.color='';
			document.getElementById('btn_t10self').style.color="";
		}
		//Remark(s) : Y : RED
		if ('Y' == ComGetObjValue(formObj.frm_t10sheet1_rmark_yn)) {
			document.getElementById('btn_t10remark').style.color='blue';
		}else{
			document.getElementById('btn_t10remark').style.color='';
		}
		//RED in case of existing WHF exemption
		if ('' != ComGetObjValue(formObj.frm_t10sheet1_bkg_rt_whf_expt_cd)) {
			document.getElementById('btn_t10whf').style.setProperty("color", BTN_BLUE, "important");
		}else{
			document.getElementById('btn_t10whf').style.setProperty("color", "#FFFFFF", "important");
		}
		//save button disable in case of X
		if ('X' == ComGetObjValue(formObj.frm_t10sheet1_bkg_sts_cd)) {
			ComBtnDisable("btn_t10save");
		}else{
			ComBtnEnable("btn_t10save");
		}
		//DOC Adjustment - btn_t10doc
		if ('' != ComGetObjValue(formObj.frm_t10sheet1_doc_loc_cd)) {
			document.getElementById('btn_t10doc').style.setProperty("color", BTN_BLUE, "important");
		}else{
			document.getElementById('btn_t10doc').style.setProperty("color", "#FFFFFF", "important");
		}

		// Service Scope setting
		var svc_scp_cd=ComGetObjValue(formObj.frm_t10sheet1_svc_scp_cd);
		var rName=svc_scp_cd.split("$");
		var rCode='';
		var _first=false;
		for ( var j=0; j < rName.length; j++) {
			if (_first) {
				rCode += '$';
			}
			rCode += rName[j].substring(0, 3);
			_first=true;
		}
		//- svc_scp_cd setting
		var r_value=rCode + "^" + svc_scp_cd;
		fnSetComboBox('svc_scp_cd', r_value, '');
		// - covered bl_no setting
		ComSetObjValue(formObj.covered_name_c, ComGetObjValue(formObj.frm_t10sheet1_mst_cvrd_bl));
		// - rt_bl_tp_cd Co_Biz B/L
		if ('B' == ComGetObjValue(formObj.frm_t10sheet1_rt_bl_tp_cd)) {
			var cobiz_auth_no=ComGetObjValue(formObj.frm_t10sheet1_cobiz_auth_no);
			var inrAuth1=cobiz_auth_no.substr(0,5);
			var inrAuth2=cobiz_auth_no.substr(5,2);
			var inrAuth3=cobiz_auth_no.substr(7,2);
			var inrAuth4=cobiz_auth_no.substr(9,4);
			var inrAuth5=cobiz_auth_no.substr(13,1);
			var inrAuth6=cobiz_auth_no.substr(14,4);
			// ComSetObjValue(formObj.inrAuth1,inrAuth1);
			ComSetObjValue(formObj.inrAuth2,inrAuth2);
			ComSetObjValue(formObj.inrAuth3,inrAuth3);
			// ComSetObjValue(formObj.inrAuth4,inrAuth4);
			ComSetObjValue(formObj.inrAuth5,inrAuth5);
			ComSetObjValue(formObj.inrAuth6,inrAuth6);
		}else{
			ComSetObjValue(formObj.frm_t10sheet1_cobiz_auth_no,'');	
			ComSetObjValue(formObj.inrAuth2,'');
			ComSetObjValue(formObj.inrAuth3,'');
			ComSetObjValue(formObj.inrAuth5,'');
			ComSetObjValue(formObj.inrAuth6,'');
		}
		//sc_no setting
		ComSetObjValue(formObj.frm_t10sheet1_sc_no1,ComGetObjValue(formObj.frm_t10sheet1_sc_no1) + ComGetObjValue(formObj.frm_t10sheet1_sc_no2))
		ComSetObjValue(formObj.frm_t10sheet1_sc_no2,'');
		// svc_scp_cd setting
		ComSetObjValue(formObj.svc_scp_cd, ComGetObjValue(formObj.frm_t10sheet1_bkg_svc_scp_cd));
		
	} catch (ex) {
		fnBkgErrorAlert('sheet1_OnSearchEnd', ex);
		return false;
	}
}
 /**
  * change color when auto rating or have 'Y'
  */
 function fnExistNoteButtonColor() {
 	var sheetObj=sheetObjects[1];
 	var cnt=sheetObj.RowCount();
 	var input_text="";
 	var output_text="";
 	var formObj=document.form;
 	try{
	 	if(cnt > 0){
	 		for (var i=0; i < cnt; i++){
	 			if(sheetObj.GetCellValue(i,prefix2 + "chg_cd") =="OFT"){
	 				var prop_no=sheetObj.GetCellValue(i,prefix2 + "prop_no");
	 				var amdt_seq=sheetObj.GetCellValue(i,prefix2 + "amdt_seq");
	 				var svc_scp_cd=sheetObj.GetCellValue(i,prefix2 + "svc_scp_cd");
	 				var note_rt_seq=sheetObj.GetCellValue(i,prefix2 + "note_rt_seq");
	 				var gen_spcl_rt_tp_cd=sheetObj.GetCellValue(i,prefix2 + "gen_spcl_rt_tp_cd");
	 				var cmdt_hdr_seq=sheetObj.GetCellValue(i,prefix2 + "cmdt_hdr_seq");
	 				var rout_seq=sheetObj.GetCellValue(i,prefix2 + "rout_seq");
	 				if(prop_no.length > 0 && amdt_seq.length > 0 && svc_scp_cd.length > 0 ){
	 					input_text=prop_no+"|"+amdt_seq+"|"+svc_scp_cd+"|"+note_rt_seq+"|"+gen_spcl_rt_tp_cd+"|"+cmdt_hdr_seq+"|"+rout_seq;
	 				}
	 				break;
	 			}
	 		}
	 		if(input_text.length > 0 && (ComGetObjValue(formObj.frm_t10sheet1_sc_no1) + ComGetObjValue(formObj.frm_t10sheet1_sc_no2)).length > 0) {
		 		var param=param + "&f_cmd=" + COMMAND03 + "&input_text=" + input_text;
		 		var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
		 		output_text=ComGetEtcData(sXml, "output_text");
	 		}
	 	}
	 	//change color
		if ('Y' == output_text) {
			document.getElementById('btn_t10note').style.color='blue';
		}else{
			document.getElementById('btn_t10note').style.color='';
		}
	 	//input OFT position to trf_itm_no  
		fnSetTrf_itm_no(sheetObj);
	} catch (ex) {
		fnBkgErrorAlert('fnExistNoteButtonColor', ex);
		return false;
	}
 }
  /**
   * check Brk_dwn_flag
   */
 function fnCheckBrk_dwn_flg(){
		var formObj=document.form;
 		var svc_scp_cd=ComGetObjValue(formObj.frm_t10sheet1_bkg_svc_scp_cd);
 		if(svc_scp_cd.length >0){
			svc_scp_cd=svc_scp_cd.substring(0,3);
			//[Service Scope] : N in case of TPE, TPW, other Y
//			if('TPE' == svc_scp_cd 
//				|| 'TPW' == svc_scp_cd 
//				|| 'ACE' == svc_scp_cd 
//				|| 'ACW' == svc_scp_cd 
//				|| 'MXE' == svc_scp_cd 
//				|| 'MXW' == svc_scp_cd 
//			){
//				formObj.brk_dwn_flg.checked=false;
//			}else{
				formObj.brk_dwn_flg.checked=true;
//			}
 		}
 }
/**
 * check Brk_dwn_flag_back
 */
function fnCheckBrk_dwn_flg_back(){
	var formObj=document.form;
	// 1. in case of existing RFA NO
	var rfa_no=ComGetObjValue(formObj.frm_t10sheet1_rfa_no);
	var taa_no=ComGetObjValue(formObj.frm_t10sheet1_taa_no);
	if(rfa_no.length >0){
		formObj.brk_dwn_flg.checked=true;
		formObj.brk_dwn_flg.disabled=true;
		ComSetObjValue(formObj.frm_t10sheet1_brk_dwn_flg, "Y");
	}else if(taa_no.length >0){
		formObj.brk_dwn_flg.checked=true;
		formObj.brk_dwn_flg.disabled=true;
		ComSetObjValue(formObj.frm_t10sheet1_brk_dwn_flg, "Y");
	}else{
	//2. in case of existing S/C NO and Service Scope 
		var svc_scp_cd=ComGetObjValue(formObj.frm_t10sheet1_bkg_svc_scp_cd);
		if(svc_scp_cd.length >0){
			svc_scp_cd=svc_scp_cd.substring(0,3);
//			if('TPE' == svc_scp_cd 
//			|| 'TPW' == svc_scp_cd 
//			|| 'ACE' == svc_scp_cd 
//			|| 'ACW' == svc_scp_cd 
//			|| 'MXE' == svc_scp_cd 
//			|| 'MXW' == svc_scp_cd 
//			){
//				return; 
//			}else{
				var brk_dwn_flg_check = ComGetObjValue(formObj.frm_t10sheet1_sc_no1)+ ComGetObjValue(formObj.frm_t10sheet1_sc_no2);
				if(brk_dwn_flg_check.length >0){
					//checked  
					formObj.brk_dwn_flg.checked=true;
					formObj.brk_dwn_flg.disabled=true;
					ComSetObjValue(formObj.frm_t10sheet1_brk_dwn_flg, "Y");
				}else{
					formObj.brk_dwn_flg.checked=false;
					formObj.brk_dwn_flg.disabled=false;
					ComSetObjValue(formObj.frm_t10sheet1_brk_dwn_flg, "N");
					return;
				}
//			}
		}else{
			return;
		}
	}
}
/**
 * null to blank
 * @param xval
 * @param yval
 * @return
 */
function fnNullToBlank(xval, yval) {
	return (xval != null && xval != "") ? xval : yval;
}
/**
 * handling process after ending t10sheet3 retrieve
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function t10sheet3_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj=document.form;
	var cnt=sheetObj.GetTotalRows();
	if (cnt == 0)
		return;
	try {
		for ( var i=1; i <= cnt; i++) {
			var type=sheetObj.GetCellValue(i, prefix3 + "type");
			var value1=sheetObj.GetCellValue(i, prefix3 + "curr_cd");
			var value2=sheetObj.GetCellValue(i, prefix3 + "chg_amt");
			if ('p_' == type) {
				fnSetShowTable('TOTAL_PPD', value1, value2);
			} else if ('c_' == type) {
				fnSetShowTable('TOTAL_CCT', value1, value2);
			} else if ('cct_' == type) {
				fnSetShowTable('TOTAL_3rdCCT', value1, value2);
				var rCombo=fnGetStringCombind(sheetObj, i);
				var result=rCombo + "^" + rCombo;
				fnSetComboBox('select_3rdCCT', result, '');
			} else if ('ppd_' == type) {
				fnSetShowTable('TOTAL_3rdPPD', value1, value2);
				var rCombo=fnGetStringCombind(sheetObj, i);
				var result=rCombo + "^" + rCombo;
				fnSetComboBox('select_3rdPPD', result, '');
			}
			IBS_CopyRowToForm(sheetObj, formObj, i, "frm_" + type);
		}
	} catch (ex) {
		fnBkgErrorAlert('sheet3_OnSearchEnd', ex);
		return false;
	}
}
/**
 * handling process after ending t10sheet4 retrieve
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function t10sheet4_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj=document.form;
	ComSetObjValue(formObj.frm_t10sheet1_rt_aply_dt_bak,formObj.frm_t10sheet1_rt_aply_dt.value);
//	if(ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt).length == 0 && sheetObjects[1].RowCount()== 0){
//		var sheetObj2=sheetObjects[1];
//		var sheetObj4=sheetObjects[3];
//		var cnt=sheetObj4.GetTotalRows();
//		if(cnt == 0) return;
//		sheetObj2.RemoveAll();  // Grid Init
//		for ( var i=1; i <= cnt; i++) {
//			var newRow=setDataInsert(sheetObj2, 2);
//			sheetObj2.SetRowStatus(newRow,"R");
//			sheetObj2.SetCellValue(newRow, prefix2 + "chg_cd",'OFT');
//			sheetObj2.SetCellValue(newRow, prefix2 + "curr_cd",'USD');
//			sheetObj2.SetCellValue(newRow, prefix2 + "rat_ut_cd",sheetObj4.GetCellValue(i, prefix4 + "cntr_tpsz_cd"));
//			sheetObj2.SetCellValue(newRow, prefix2 + "rat_as_qty",sheetObj4.GetCellValue(i, prefix4 + "qty"));
//			sheetObj2.SetCellValue(newRow, prefix2 + "cgo_cate_cd",sheetObj4.GetCellValue(i, prefix4 + "cgo"));
//		}
//	}
}
/**
 * set booking editable
 * @param isEnable
 * @return
 */
function setBookingEditable(isEnable){
	 var formObj=document.form;
	 var sheetObj=sheetObjects[1];
	 // input box
	 BkgEnableObject(formObj.frm_t10sheet1_rt_aply_dt, isEnable);
	 BkgEnableObject(formObj.frm_t10sheet1_rfa_no, isEnable);
	 BkgEnableObject(formObj.frm_t10sheet1_sc_no1, isEnable);
	 // BkgEnableObject(formObj.frm_t10sheet1_sc_no2, isEnable);
	 BkgEnableObject(formObj.frm_t10sheet1_taa_no, isEnable);
	 BkgEnableObject(formObj.frm_p_t10sheet3_ofc_cd, isEnable);
	 BkgEnableObject(formObj.frm_p_t10sheet3_cnt_cd, isEnable);
	 BkgEnableObject(formObj.frm_p_t10sheet3_cust_seq, isEnable);
	 BkgEnableObject(formObj.frm_c_t10sheet3_ofc_cd, isEnable);
	 BkgEnableObject(formObj.frm_c_t10sheet3_cnt_cd, isEnable);
	 BkgEnableObject(formObj.frm_c_t10sheet3_cust_seq, isEnable);
	 BkgEnableObject(formObj.frm_t10sheet1_brk_dwn_flg, isEnable);
//	 BkgEnableObject(formObj.covered_name_c, isEnable);
//	 BkgEnableObject(formObj.inrAuth2, isEnable);
//	 BkgEnableObject(formObj.inrAuth3, isEnable);
//	 BkgEnableObject(formObj.inrAuth5, isEnable);
//	 BkgEnableObject(formObj.inrAuth6, isEnable);
	 // select check_box
	 ComEnableManyIBCombo(isEnable, rt_bl_tp_cd, frt_term_cd);
	 // sheetObject
	 var backColor="#FFFFFF";
	 var chargeColor="#FFFFFF";
	 if(!isEnable){
		 ComBtnDisable("btn_t10add");
		 ComBtnDisable("btn_t10del");
		 ComBtnDisable("btn_t10merge");
		 backColor="#CCCCCC";// gray
		 chargeColor=backColor;// gray
	 }else{
		 ComBtnEnable("btn_t10add");
		 ComBtnEnable("btn_t10del");
		 ComBtnEnable("btn_t10merge");
		 formObj.frm_t10sheet1_rt_aply_dt.className="input1";
	 }
	 //Sheet_object :  ColBackColor
	 for(var nRow=1; nRow <= sheetObj.RowCount(); nRow++) {
		 sheetObj.SetRowBackColor(nRow,backColor);
		 sheetObj.SetCellEditable(nRow, prefix2 + "trf_itm_no",isEnable);
		 sheetObj.SetCellEditable(nRow, prefix2 + "chg_ut_amt",isEnable);
		 sheetObj.SetCellEditable(nRow, prefix2 + "rat_as_qty",isEnable);
		 sheetObj.SetCellBackColor(nRow, prefix2 + "chg_amt","#CCCCCC");
		 sheetObj.SetCellEditable(nRow, prefix2 + "incl_oft_flg",isEnable);
		 sheetObj.SetCellEditable(nRow, prefix2 + "frt_term_cd",isEnable);
		 sheetObj.SetCellEditable(nRow, prefix2 + "n3pty_rcv_ofc_cd",isEnable);
		 sheetObj.SetCellEditable(nRow, prefix2 + "n3pty_cust_cnt_cd",isEnable);
		 sheetObj.SetCellEditable(nRow, prefix2 + "cgo_cate_cd",isEnable);
		 sheetObj.SetCellEditable(nRow, prefix2 + "rcv_term_cd",isEnable);
		 sheetObj.SetCellEditable(nRow, prefix2 + "de_term_cd",isEnable);
		 sheetObj.SetCellEditable(nRow, prefix2 + "imdg_clss_cd",isEnable);
		 sheetObj.SetCellBackColor(nRow, prefix2 + "prn_hdn_flg","#FFFFFF");
		 sheetObj.SetCellBackColor(nRow, prefix2 + "chg_cd",chargeColor);
		 // change Blue color 
		 var incl_oft_flg=sheetObj.GetCellValue(nRow, prefix2 + "incl_oft_flg");
		 if ('I' == incl_oft_flg || 'E' == incl_oft_flg) {
			 sheetObj.SetCellBackColor(nRow, prefix2 + "chg_cd","#99CCFF");
		 }
	 }
	 if(isEnable){
		 t10sheet2_OnSearchEnd(sheetObj, '');
	 }
	 //remove point
//	 fnSplitAmount();
}
/**
 * IBMultiCombo batch Enable/Disable transaction  
 * set multiCombo activating / deactivating
 * @param bEnable
 * @param objs
 * @return
 */
function ComEnableManyIBCombo(bEnable, objs) {
    try {
        var args=arguments;
        if (args.length < 2) return;
        for(var i=1; i<args.length; i++) {
            if (args[i].tagName != undefined) {
            	args[i].SetEnable(bEnable);
            }
        } 
    } catch(err) { ComFuncErrMsg(err.message); }
}
/**
 * clear form
 * @return
 */
function fnClearForm() {
	var formObj=document.form;
	fnClearTextBox('TOTAL_PPD');// Prepaid
	fnClearTextBox('TOTAL_CCT');// Collect
	fnClearTextBox('TOTAL_3rdPPD');// 3rd Party - PPD
	fnClearTextBox('TOTAL_3rdCCT');// 3rd Party - CCT
	fnClearSelect('select_3rdCCT');// 3rd Party - CCT
	fnClearSelect('select_3rdPPD');// 3rd Party - PPD
	ComSetObjValue(formObj.frm_p_t10sheet3_ofc_cd, "");
	ComSetObjValue(formObj.frm_p_t10sheet3_cnt_cd, "");
	ComSetObjValue(formObj.frm_p_t10sheet3_cust_seq, "");
	ComSetObjValue(formObj.frm_c_t10sheet3_ofc_cd, "");
	ComSetObjValue(formObj.frm_c_t10sheet3_cnt_cd, "");
	ComSetObjValue(formObj.frm_c_t10sheet3_cust_seq, "");
	ComSetObjValue(formObj.covered_name_c, '');
	ComSetObjValue(formObj.frm_c_t10sheet3_ofc_cd_enable, '');
	ComSetObjValue(formObj.frm_p_t10sheet3_ofc_cd_enable, '');
	ComSetObjValue(formObj.frm_c_t10sheet3_cust_seq_enable, '');
	ComSetObjValue(formObj.frm_p_t10sheet3_cust_seq_enable, '');
	document.getElementById('frm_t10sheet1_sc_no1').style.color='';
	try{
		if(ComGetObjValue(formObj.isInquiry) == "Y"){
			setInquiryDisableButton();
		}
		parent.initCAControl("", "N", "N", "N", "");
	}catch(e){}
}
/**
 * combine String
 * @param sheetObj
 * @param y
 * @return
 */
function fnGetStringCombind(sheetObj, y) {
	try {
		var value1=sheetObj.GetCellValue(y, prefix3 + "ofc_cd");
		var value2=sheetObj.GetCellValue(y, prefix3 + "cnt_cd");
		var value3=sheetObj.GetCellValue(y, prefix3 + "cust_seq");
		var _ofc_cd=value1.split("|");
		var _cnt_cd=value2.split("|");
		var _cust_seq=value3.split("|");
		var _cnt=_ofc_cd.length;
		var vCombo='';
		var _first=false
		for ( var k=0; k < _cnt; k++) {
			if (_first) {
				vCombo += "$";
			}
			if(_ofc_cd[k] != '')
			vCombo += _ofc_cd[k] + "  :  " + _cnt_cd[k] + "  :  " + _cust_seq[k];
			_first=true
		}
	} catch (ex) {
		fnBkgErrorAlert('fnGetStringCombind', ex);
	}
	return vCombo;
}
/**
 * create show table
 * @param _name
 * @param _value1
 * @param _value2
 * @return
 */
function fnSetShowTable(_name, _value1, _value2) {
	try {
		var obj=eval("document.all." + _name); // SELECT box position ID
		var value1=_value1.split("|");
		var value2=_value2.split("|");
		var len=value1.length;
		if (len == 0)
			return;
		var html="";
		var val_amt=0.00;
		html="<div style='overflow:auto;height:48px;'><table width='100%' cellpadding='0' cellspacing='0' border='0'>"
		for ( var z=0; z < len; z++) {
			val_amt=ComAddComma2(parseFloat(fnNullToBlank(value2[z], '0.00'))+"", "#,###.00")
			html += "<tr>" + "	<td class='tr2_head3' width='12%' align='center'>" + value1[z] + "</td>" + "	<td class='input2' width='36%' align='right'>" + val_amt + "</td>" + "</tr>";
		}
		html += "</table></div>";
		obj.innerHTML=html;
	} catch (ex) {
		fnBkgErrorAlert('fnSetShowTable', ex);
	}
}
/**
 * clear select box
 * @param _id
 * @return
 */
function fnClearSelect(_id) {
	try {
		var obj=eval("document.all." + _id);
		for ( var i=obj.length - 1; i >= 0; i--) {
			obj[i]=null; // init
		}
	} catch (ex) {
		fnBkgErrorAlert('fnClearSelect', ex);
	}
}
/**
 * clear text box
 * @param _id
 * @return
 */
function fnClearTextBox(_id) {
	try {
		var obj=eval("document.all." + _id);
		var html="";
		obj.innerHTML=html;
	} catch (ex) {
		fnBkgErrorAlert('fnClearTextBox', ex);
	}
}
/**
* handling process for input validation
* @param sheetObj sheet Object
* @param formObj  form Object
* @param sAction 
*/
function validateForm(sheetObj, formObj, sAction) {
	 switch(sAction) {
		case IBSEARCH:
			if(ComIsEmpty(formObj.frm_t10sheet1_bkg_no.value)&&ComIsEmpty(formObj.frm_t10sheet1_bl_no.value)){
				//ComShowMessage(ComGetMsg("BKG00445"));
				ComSetFocus(formObj.frm_t10sheet1_bkg_no);
				return false;
			}
			ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.frm_t10sheet1_bkg_no));
			ComSetObjValue(formObj.bl_no, ComGetObjValue(formObj.frm_t10sheet1_bl_no));
			break;
        case IBSAVE:
        	//validation : BKG no(10), B/L no(12), 
        	//             showing message [BKG00445] and on focus in case of not existing application_date
			with (formObj) {
				if(bkg_no.value == '' || bkg_no.value.length < 10){
					if(tab_alert_msg){
						ComShowCodeMessage("BKG00399");ComSetFocus(formObj.frm_t10sheet1_bkg_no);
					}
					return false;
				}
				if(ComIsEmpty(formObj.frm_t10sheet1_bl_no.value)){
					if(tab_alert_msg){
						ComShowCodeMessage("BKG00400");ComSetFocus(formObj.frm_t10sheet1_bl_no);
					}
					return false;
				}
				if(ComIsEmpty(formObj.frm_t10sheet1_rt_aply_dt.value)){
					if(tab_alert_msg){
						ComShowCodeMessage("BKG08086");ComSetFocus(formObj.frm_t10sheet1_rt_aply_dt);
					}
					return false;
				}
				if(ComGetObjValue(formObj.bkg_no)!= ComGetObjValue(formObj.frm_t10sheet1_bkg_no)
				 ||ComGetObjValue(formObj.bl_no)!= ComGetObjValue(formObj.frm_t10sheet1_bl_no)
				){
					if(tab_alert_msg){
						ComShowMessage(ComGetMsg("BKG01053"));
					}
					return false;
				}
				//can not save in case of not existing At Info
				if(ComGetObjValue(formObj.frm_p_t10sheet3_ofc_cd).length == 0 || ComGetObjValue(formObj.frm_c_t10sheet3_ofc_cd).length == 0 ){
					if(tab_alert_msg){
						ComShowMessage(ComGetMsg("BKG08067"));
					}
					return false;
				}
				if(ComGetObjValue(formObj.frm_p_t10sheet3_cnt_cd).length == 0 ){
					if(tab_alert_msg){
						ComShowMessage(ComGetMsg("BKG00458"));ComSetFocus(formObj.frm_p_t10sheet3_cnt_cd);
					}
					return false;
				}
				if(ComGetObjValue(formObj.frm_p_t10sheet3_cust_seq).length == 0 ){
					if(tab_alert_msg){
						ComShowMessage(ComGetMsg("BKG00458"));ComSetFocus(formObj.frm_p_t10sheet3_cust_seq);
					}
					return false;
				}
				if(ComGetObjValue(formObj.frm_c_t10sheet3_cnt_cd).length == 0 ){
					if(tab_alert_msg){
						ComShowMessage(ComGetMsg("BKG00458"));ComSetFocus(formObj.frm_c_t10sheet3_cnt_cd);
					}
					return false;
				}
				if(ComGetObjValue(formObj.frm_c_t10sheet3_cust_seq).length == 0 ){
					if(tab_alert_msg){
						ComShowMessage(ComGetMsg("BKG00458"));ComSetFocus(formObj.frm_c_t10sheet3_cust_seq);
					}
					return false;
				}
				// can not save in case of OFC_CD validation is not checked 
				if('N' == ComGetObjValue(formObj.frm_c_t10sheet3_ofc_cd_enable)){
					if(tab_alert_msg){
						ComShowMessage(ComGetMsg("BKG00905"));ComSetFocus(formObj.frm_c_t10sheet3_ofc_cd);
					}
					return false;
				}
				if('N' == ComGetObjValue(formObj.frm_p_t10sheet3_ofc_cd_enable)){
					if(tab_alert_msg){
						ComShowMessage(ComGetMsg("BKG00905"));ComSetFocus(formObj.frm_p_t10sheet3_ofc_cd);
					}
					return false;
				}
				// condition add : cust_seq , cust_code 
				if('N' == ComGetObjValue(formObj.frm_p_t10sheet3_cust_seq_enable)){
					if(tab_alert_msg){
						ComShowMessage(ComGetMsg("BKG00458"));ComSetFocus(formObj.frm_p_t10sheet3_cust_seq);
					}
					return false;
				}
				if('N' == ComGetObjValue(formObj.frm_c_t10sheet3_cust_seq_enable)){
					if(tab_alert_msg){
						ComShowMessage(ComGetMsg("BKG00458"));
						ComSetFocus(formObj.frm_c_t10sheet3_cust_seq);
					}
					return false;
				}
				// Third Office check logic - P, C
				var p_ofc_cd = "";
				var c_ofc_cd = "";
				var arr_p_ofc_cd = "";
				var arr_c_ofc_cd = "";
				
				for ( var r=1; r <= sheetObj.RowCount(); r++) {
					if(sheetObj.GetRowHidden(r) || "D" == sheetObj.GetRowStatus(r)) continue;
					
					if(sheetObj.GetCellValue(r,prefix2 + "n3pty_rcv_ofc_cd").length >= 5){
						if(sheetObj.GetCellValue(r,prefix2 + "frt_term_cd") =="P"){
							p_ofc_cd += sheetObj.GetCellValue(r,prefix2 + "n3pty_rcv_ofc_cd")+"|";	
						}else if(sheetObj.GetCellValue(r,prefix2 + "frt_term_cd") =="C"){
							c_ofc_cd += sheetObj.GetCellValue(r,prefix2 + "n3pty_rcv_ofc_cd")+"|";	
						}
					}
				}
				
				if(p_ofc_cd.length > 0 ){
					p_ofc_cd = p_ofc_cd.substring(0, p_ofc_cd.length-1);
					arr_p_ofc_cd = p_ofc_cd.split("|");
				}
				if(c_ofc_cd.length > 0 ){
					c_ofc_cd = c_ofc_cd.substring(0, c_ofc_cd.length-1);
					arr_c_ofc_cd = c_ofc_cd.split("|");
				}
				
				for(var i=0; i< arr_p_ofc_cd.length ; i++){
					
					for(var j=0; j< arr_c_ofc_cd.length; j++){
						if(arr_p_ofc_cd[i] == arr_c_ofc_cd[j]){
							if(tab_alert_msg){
								ComShowMessage(ComGetMsg("BKG08350"));
								return false;
							}
						}
					}
				}				
				
				//add Covered B/L 
//				if(document.all.covered_id_c.style.display == 'block'){
				if(isShow('covered_id_c')){
					if(ComGetObjValue(formObj.covered_name_c).length == 0){
						if(tab_alert_msg){
							ComShowMessage(ComGetMsg("BKG08125"));
							ComSetFocus(formObj.covered_name_c);
						}
						return false;
					}
				}
				//add CO_BIZ B/L 
//				if(document.all.covered_id_b.style.display == 'block'){
				if(isShow('covered_id_b')){
					//input SG/AG
					if(!('SG'==ComGetObjValue(formObj.inrAuth2) || 'AG'==ComGetObjValue(formObj.inrAuth2) )){
						if(tab_alert_msg){
							ComShowCodeMessage("COM12193","SG/AG");ComSetFocus(formObj.inrAuth2);
						}
						return false;
					}
					if(ComGetObjValue(formObj.inrAuth3).length != 2){
						if(tab_alert_msg){
							ComShowCodeMessage("COM12193","INR Auth");ComSetFocus(formObj.inrAuth3);
						}
						return false;
					}
					if(ComGetObjValue(formObj.inrAuth5).length != 1){
						if(tab_alert_msg){
							ComShowCodeMessage("COM12193","INR Auth");ComSetFocus(formObj.inrAuth5);
						}
						return false;
					}
					if(ComGetObjValue(formObj.inrAuth6).length != 4){
						if(tab_alert_msg){
							ComShowCodeMessage("COM12193","INR Auth");ComSetFocus(formObj.inrAuth6);
						}
						return false;
					}
					var cobiz_auth_no = ComGetObjValue(formObj.inrAuth1)
					+ ComGetObjValue(formObj.inrAuth2)
					+ ComGetObjValue(formObj.inrAuth3)
					+ ComGetObjValue(formObj.inrAuth4)
					+ ComGetObjValue(formObj.inrAuth5)
					+ ComGetObjValue(formObj.inrAuth6)
					;
					ComSetObjValue(formObj.frm_t10sheet1_cobiz_auth_no,cobiz_auth_no);					
				}
				var sheetObj1=sheetObjects[1];
				var cnt=sheetObj1.RowCount();
				// [AUTO RATING] change status = 'U' before save
				if('Y' == ComGetObjValue(formObj.autoRate)){
					for ( var r=1; r <= cnt; r++) {
						if(!sheetObj1.GetRowHidden(r) && "D" != sheetObj1.GetRowStatus(r) && "0" != sheetObj1.GetCellValue(r, prefix2 + "chg_ut_amt")){
							sheetObj1.SetRowStatus(r,"U");
						}
					}
				}
				// [3.delete]
				for ( var ix=1; ix <= cnt; ix++) {
					var _type=sheetObj1.GetCellValue(ix, prefix2 + "ibflag");
					if( _type != undefined){
						if(sheetObj1.GetRowHidden(ix)){
							if('D' != sheetObj1.GetCellValue(ix, prefix2 + "ibflag")){
								sheetObj1.SetRowStatus(r,"D");
							}
						}
					}
				}
				var ObjCount=0;
				for ( var ix=1; ix <= cnt; ix++) {
					if(!sheetObj1.GetRowHidden(ix)){
						ObjCount++;
					}
				}
				if(ObjCount>0){
					if(fnDumyNotValidCheck()){
						return false;
					}
				}
			}
			break;
	}
	return true;
}
/**
 * set combo box
 * @param vCombo
 * @param vCode
 * @param vSelected
 * @return
 */
function fnSetComboBox(vCombo, vCode, vSelected) {
	var _spr="^"; // delimiter
	var obj=eval("document.all." + vCombo); // SELECT box position ID
	for ( var i=obj.length - 1; i >= 0; i--)
		obj[i]=null; // Init
	try {
		var result=vCode;
		if (result != "ERR" && result != "^") {
			var aList=result.split(_spr);
			var aCode, aName;
			var aCode=aList[0].split("$");
			var aName=aList[1].split("$");
			var optioncnt=obj.options.length;
			var codeindex=0;
			for ( var j=optioncnt; j < aCode.length + optioncnt; j++) {
				obj.options[j]=new Option();
				obj.options[j].text=aName[codeindex];
				obj.options[j].value=aCode[codeindex];
				if (vSelected == aCode[codeindex]) {
					obj.options[j].selected=true;
				}
				++codeindex;
			}
		}
	} catch (ex) {
		fnBkgErrorAlert('fnSetComboBox', ex);
	}
}
/**
* registering IBSheet Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
* @param sheet_obj IBSheet Object
*/
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* obj activate
*/
function obj_activate() {
	//check input Validation
	switch (event.srcElement.name) {
		case "frm_t10sheet1_rt_aply_dt":
			ComClearSeparator(event.srcElement);
			break;	
		default:
			break;
	}
}
/**
* obj deactivate
*/
function obj_change() {
	 var formObj=document.form;
	// check input Validation
	switch (event.srcElement.name) {
		case "frm_t10sheet1_sc_no1":
			fnCheckTrf_itm_no();
			break;
		// case "frm_t10sheet1_sc_no2":
			// fnSetTrf_itm_no();
			// break;
		case "frm_t10sheet1_rt_aply_dt":
			ComAddSeparator(event.srcElement);
			if(ComIsDate(event.srcElement)){
				fnCheckNumber('sc_no',  ComGetObjValue(formObj.frm_t10sheet1_sc_no1)+ComGetObjValue(formObj.frm_t10sheet1_sc_no2));
				fnCheckNumber('rfa_no', ComGetObjValue(formObj.frm_t10sheet1_rfa_no));
				fnCheckNumber('taa_no', ComGetObjValue(formObj.frm_t10sheet1_taa_no));	
			}
			break;
		case "frm_p_t10sheet3_ofc_cd":
			var r_val=fnOfcCdCheck(event.srcElement.value);
			if ("Y" != r_val) {
				event.srcElement.select(); 
				ComSetObjValue(formObj.frm_p_t10sheet3_ofc_cd_enable, 'N');
			}else{
				ComSetObjValue(formObj.frm_p_t10sheet3_ofc_cd_enable, 'Y');
			}
			break;
		case "frm_c_t10sheet3_ofc_cd":
			var r_val=fnOfcCdCheck(event.srcElement.value);
			if ("Y" != r_val) {
				event.srcElement.select(); 
				ComSetObjValue(formObj.frm_c_t10sheet3_ofc_cd_enable, 'N');
			}else{
				ComSetObjValue(formObj.frm_c_t10sheet3_ofc_cd_enable, 'Y');
			}
			break;
		case "frm_p_t10sheet3_cnt_cd":
			var cust_cnt_cd=ComGetObjValue(formObj.frm_p_t10sheet3_cnt_cd);
			var cust_seq=ComGetObjValue(formObj.frm_p_t10sheet3_cust_seq);
			if(cust_cnt_cd.length >0 && cust_seq.length >0 ){
				var r_val=fnCustSeqCheck(cust_cnt_cd,cust_seq);
				if ("N" != r_val) {
					event.srcElement.select(); 
					ComSetObjValue(formObj.frm_p_t10sheet3_cust_seq_enable, 'N');
				}else{
					ComSetObjValue(formObj.frm_p_t10sheet3_cust_seq_enable, 'Y');
				}
			}
			break;
		case "frm_p_t10sheet3_cust_seq":
			var cust_cnt_cd=ComGetObjValue(formObj.frm_p_t10sheet3_cnt_cd);
			var cust_seq=ComGetObjValue(formObj.frm_p_t10sheet3_cust_seq);
			if(cust_cnt_cd.length >0 && cust_seq.length >0 ){
				var r_val=fnCustSeqCheck(cust_cnt_cd,cust_seq);
				if ("N" != r_val) {
					event.srcElement.select(); 
					ComSetObjValue(formObj.frm_p_t10sheet3_cust_seq_enable, 'N');
				}else{
					ComSetObjValue(formObj.frm_p_t10sheet3_cust_seq_enable, 'Y');
				}
			}
			break;
		case "frm_c_t10sheet3_cnt_cd":
			var cust_cnt_cd=ComGetObjValue(formObj.frm_c_t10sheet3_cnt_cd);
			var cust_seq=ComGetObjValue(formObj.frm_c_t10sheet3_cust_seq);
			if(cust_cnt_cd.length >0 && cust_seq.length >0 ){
				var r_val=fnCustSeqCheck(cust_cnt_cd,cust_seq);
				if ("N" != r_val) {
					event.srcElement.select();
					ComSetObjValue(formObj.frm_c_t10sheet3_cust_seq_enable, 'N');
				}else{
					ComSetObjValue(formObj.frm_c_t10sheet3_cust_seq_enable, 'Y');
				}
			}
			break;
		case "frm_c_t10sheet3_cust_seq":
			var cust_cnt_cd=ComGetObjValue(formObj.frm_c_t10sheet3_cnt_cd);
			var cust_seq=ComGetObjValue(formObj.frm_c_t10sheet3_cust_seq);
			if(cust_cnt_cd.length >0 && cust_seq.length >0 ){
				var r_val=fnCustSeqCheck(cust_cnt_cd,cust_seq);
				if ("N" != r_val) {
					event.srcElement.select();
					ComSetObjValue(formObj.frm_c_t10sheet3_cust_seq_enable, 'N');
				}else{
					ComSetObjValue(formObj.frm_c_t10sheet3_cust_seq_enable, 'Y');
				}
			}
			break;
		case "frm_t10sheet1_rfa_no":
			var rfa_no=ComGetObjValue(formObj.frm_t10sheet1_rfa_no);	
			fnCozNotValidCheck();
			fnCheckNumber('rfa_no', rfa_no);
			break;
		case "frm_t10sheet1_taa_no":
			var taa_no=ComGetObjValue(formObj.frm_t10sheet1_taa_no) 
			fnCheckNumber('taa_no', taa_no);
			break;
//		case "frm_t10sheet1_bkg_no":
//		case "frm_t10sheet1_bl_no":
//			var srcName=ComGetEvent("name");
//			var srcValue=window.event.srcElement.getAttribute("value");
//			formObj.elements[srcName].value=srcValue.toUpperCase();
//			break;
		default:
			break;
	}
}
 /**
  * check TRF item No
  */
 function fnCheckTrf_itm_no() {
 	var sheetObj=sheetObjects[1];
	var formObj=document.form;
	var sc_no=ComGetObjValue(formObj.frm_t10sheet1_sc_no1) + ComGetObjValue(formObj.frm_t10sheet1_sc_no2);
 	var cnt=sheetObj.RowCount();
	if(sc_no != ''){	
		if(sc_no.indexOf("DUM") != -1 ){
			if (cnt != 0) {
		 		for ( var ix=1; ix <= cnt; ix++) {
		 			if (!sheetObj.GetRowHidden(ix)) {
		 				var trf_itm_no=sheetObj.GetCellValue(ix, prefix2 + "trf_itm_no");
		 				if(trf_itm_no.indexOf("DUM") != -1 ){
		 					sheetObj.SetCellValue(ix, prefix2 + "trf_itm_no",'');
		 				}
		 				break;
		 			}
		 		}
		 	}
			return;
		}
		if(fnCheckNumber('sc_no', sc_no)){
		if('Y' != ComGetObjValue(formObj.sc_available)) return;
		 	if (cnt != 0) {
		 		for ( var ix=1; ix <= cnt; ix++) {
		 			if (!sheetObj.GetRowHidden(ix)) {
		 				sheetObj.SetCellValue(ix, prefix2 + "trf_itm_no",sc_no);
		 				break;
		 			}
		 		}
		 	}
		}
	}else{
	 	if (cnt != 0) {
	 		for ( var ix=1; ix <= cnt; ix++) {
	 			if (!sheetObj.GetRowHidden(ix)) {
	 				sheetObj.SetCellValue(ix, prefix2 + "trf_itm_no",sc_no);
	 				break;
	 			}
	 		}
	 	}
	}
 }
 /**
  * check number
  * @param fnName
  * @param r_Number
  * @return
  */
 function fnCheckNumber(fnName,r_Number){
	 //return in case of number is null
 	if (ComIsEmpty(r_Number))  return false;
 	var formObj=document.form;
 	var r_input='frm_t10sheet1_';
	var r_Available='';
	// date setting
	//ComSetObjValue(formObj.application_date, ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt).split('-').join(""));
 	switch (fnName) {
 		case "sc_no":
 			if(formObj.frm_t10sheet1_sc_no1.value.indexOf("DUM") != -1 ){
 				r_Available='Y';
 				ComSetObjValue(formObj.sc_available,r_Available);
 				r_input=r_input+'sc_no1';
 				break;
 			}
 			// in case of not existing date 
/* 			if (ComIsEmpty(ComGetObjValue(formObj.application_date))){
 				r_Available='N';
 				ComSetObjValue(formObj.sc_available,r_Available);
 			}else{*/
 				// return not existing date
 				//if (!ComIsNumber(ComGetObjValue(formObj.application_date))) return;
 				ComSetObjValue(formObj.application_date, ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt).split('-').join(""));
 	 			formObj.f_cmd.value=SEARCHLIST13;
 	 			var param="f_cmd=" + SEARCHLIST13 
 	 						+"&bkg_no="+ComGetObjValue(formObj.bkg_no)
 	 						+"&page_type="+ComGetObjValue(formObj.page_type)
 	 						+"&application_date="+ComGetObjValue(formObj.application_date)
 	 						+"&ca_flg="+ComGetObjValue(formObj.caflag);
 	 			var sXml=sheetObjects[2].GetSearchData("ESM_BKG_0000GS.do?sc_no="+ r_Number, param);
 	 			r_Available=ComGetEtcData(sXml,"sc_available");
 	 			ComSetObjValue(formObj.sc_available,r_Available);
 			//}
 			r_input=r_input+'sc_no1';
 			break;
 		case "rfa_no":
 			if(formObj.frm_t10sheet1_rfa_no.value.indexOf("DUM") != -1 
 			 ||formObj.frm_t10sheet1_rfa_no.value.indexOf("COZ") != -1		
 			){
 				r_Available='Y'
 				ComSetObjValue(formObj.rfa_available,r_Available);
 				r_input=r_input+'rfa_no';
 				break;
 			}
/* 			if (ComIsEmpty(ComGetObjValue(formObj.application_date))){
 				r_Available='N';
 				ComSetObjValue(formObj.rfa_available,r_Available);
 			}else{*/
 				// return in case of not existing date
 				//if (!ComIsNumber(ComGetObjValue(formObj.application_date))) return;
 				ComSetObjValue(formObj.application_date, ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt).split('-').join(""));
 	 			formObj.f_cmd.value=SEARCHLIST12;
 	 			var param="f_cmd=" + SEARCHLIST12 
					+"&bkg_no="+ComGetObjValue(formObj.bkg_no)
					+"&page_type="+ComGetObjValue(formObj.page_type)
					+"&application_date="+ComGetObjValue(formObj.application_date)
					+"&ca_flg="+ComGetObjValue(formObj.caflag);
 	 			var sXml=sheetObjects[2].GetSearchData("ESM_BKG_0000GS.do?rfa_no="+ r_Number, param);
 	 			r_Available=ComGetEtcData(sXml,"rfa_available");
 	 			ComSetObjValue(formObj.rfa_available,r_Available);
 			//}
 			r_input=r_input+'rfa_no';
 			break;
 		case "taa_no":
 			if(formObj.frm_t10sheet1_taa_no.value.indexOf("DUM") != -1 ){
 				r_Available='Y'
 				ComSetObjValue(formObj.taa_available,'Y');
 				r_input=r_input+'taa_no';
 				break;
 			}
/* 			if (ComIsEmpty(ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt))){
 				r_Available='N';
 				ComSetObjValue(formObj.taa_available,r_Available);
 			}else{*/
 				// return in case of not existing date
 				//if (!ComIsNumber(ComGetObjValue(formObj.application_date))) return;
 				ComSetObjValue(formObj.application_date, ComGetObjValue(formObj.frm_t10sheet1_rt_aply_dt).split('-').join(""));
 	 			formObj.f_cmd.value=SEARCH06;
 	 			var param="f_cmd=" + SEARCH06 
					+"&bkg_no="+ComGetObjValue(formObj.bkg_no)
					+"&taa_no="+ComGetObjValue(formObj.frm_t10sheet1_taa_no)
					+"&page_type="+ComGetObjValue(formObj.page_type)
					+"&application_date="+ComGetObjValue(formObj.application_date)
					+"&ca_flg="+ComGetObjValue(formObj.caflag);
 	 			var sXml=sheetObjects[2].GetSearchData("ESM_BKG_0000GS.do?rfa_no="+ r_Number, param);
 	 			r_Available=ComGetEtcData(sXml,"taa_available");
 	 			ComSetObjValue(formObj.taa_available,r_Available);
 			//}
 			r_input=r_input+'taa_no';
 			break;
 	} // end switch
 	if('Y' == r_Available){
 		changeObjectColor('', '', r_input , "", "input");// enable
 	}else{
 		changeObjectColor('', '', r_input , "red", "input"); // disable
 	}
 	return true;
 }
 /**
  * check cust seq
  * @param cust_cnt_cd
  * @param cust_seq
  * @return
  */
 function fnCustSeqCheck(cust_cnt_cd,cust_seq) {
	var sheetObj=sheetObjects[3];
 	var input_text=cust_cnt_cd +"|"+ cust_seq;
 	var param=param + "&f_cmd=" + SEARCHLIST20 + "&input_text=" + input_text;
 	var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
 	var output_text=ComGetEtcData(sXml, "output_text");
 	if ('Y' == output_text) {
 		//ComShowCodeMessage("BKG00458"); // invalid customer code
 	}
 	return output_text;
 }
 /**
  * check auto ration RFA
  * @param v_bkg_no
  * @return
  */
 function fnAutoRatingRFACheck(v_bkg_no) {
	var sheetObj=sheetObjects[3];
 	var input_text=v_bkg_no;
 	var param=param + "&f_cmd=" + SEARCH04 + "&input_text=" + input_text;
 	var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
 	var output_text=ComGetEtcData(sXml, "output_text");
 	// autoration transaction in case of 'N' 
 	if ('N' == output_text) {
 		return false ;
 	}else{
 		ComShowCodeMessage("BKG08156"); 
 		return true;
 	}
 }
 /**
  * auto rating RFA available
  * @param v_bkg_no
  * @param v_rfa_no
  * @param v_date
  * @param v_ca_flg
  * @return
  */
 function fnAutoratingRfaAvailable(v_bkg_no ,v_rfa_no,v_date,v_ca_flg) {
	var sheetObj=sheetObjects[3];
 	var input_text=v_bkg_no +"|"+ v_rfa_no+"|"+ v_date+"|"+v_ca_flg;
 	var param=param + "&f_cmd=" + COMMAND04 + "&input_text=" + input_text;
 	var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
 	var output_text=ComGetEtcData(sXml, "output_text");
 	// skip in case of 'Y', open popup in case of 'N' before open 0739
 	// "The customer codes are unmatched btwn BKG and RFA. please check
	// itagain."
 	if ('N' == output_text) {
 		ComShowCodeMessage("BKG08104"); 
 		return false;// popup open~
 	}else{
 		return true; 
 	}
 }
 /**
  * auto rating SC available
  * @param v_bkg_no
  * @param v_sc_no
  * @param v_date
  * @param v_ca_flg
  * @return
  */
 function fnAutoratingScAvailable(v_bkg_no ,v_sc_no,v_date,v_ca_flg) {
	var sheetObj=sheetObjects[3];
	var input_text=v_bkg_no +"|"+ v_sc_no+"|"+ v_date+"|"+v_ca_flg;
 	var param=param + "&f_cmd=" + COMMAND05 + "&input_text=" + input_text;
 	var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
 	var output_text=ComGetEtcData(sXml, "output_text");
 	// skip in case of 'Y', open popup in case of 'N' before open 0269
 	if ('N' == output_text) {
 		if (ComShowConfirm(ComGetMsg("BKG08105"))){
 			return true;// popup open~
 		}
 		else {
 			return false;
 		}
 	}
 	else {
 		return true;
 	}
 }
 /**
  * auto rating TAA available
  * @param v_bkg_no
  * @param v_taa_no
  * @param v_date
  * @param v_ca_flg
  * @return
  */
 function fnAutoratingTaaAvailable(v_bkg_no,v_taa_no,v_date,v_ca_flg){
	 var sheetObj=sheetObjects[3];
	 var input_text=v_bkg_no +"|"+ v_taa_no+"|"+ v_date+"|"+v_ca_flg;
	 var param=param + "&f_cmd=" + COMMAND06 + "&input_text=" + input_text;
	 var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
	 var output_text=ComGetEtcData(sXml, "output_text");
	 if('N' == output_text){
  		ComShowCodeMessage("BKG08123");
 		return false;// popup open~
 	}else{
 		return true; 
 	}
 }
 /**
  * check OFC code
  * @param v_ofc_cd
  * @return
  */
 function fnOfcCdCheck(v_ofc_cd) {
	 var sheetObj=sheetObjects[3];
	 var param=param + "&f_cmd=" + SEARCHLIST19 + "&input_text=" + v_ofc_cd;
	 var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
	 var output_text=ComGetEtcData(sXml, "output_text");
	 if ('Y' != output_text) {
		//ComShowCodeMessage("BKG00905"); // Third Office is not available
	 }
	 return output_text;
 }
  /**
   * retrieve REP customer
   * @param sheetObj
   * @param Row
   * @param v_ofc_cd
   * @return
   */
  function fnRepCustomer(sheetObj,Row,v_ofc_cd){
 	 var param=param + "&f_cmd=" + COMMAND07 + "&input_text=" + v_ofc_cd;
 	 var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
 	 var output_text=ComGetEtcData(sXml, "output_text");
 	 var len=output_text.length;
 	 if (len != 0){
 		var value1=output_text.split("|"); 
 		sheetObj.SetCellValue(Row, prefix2 + "n3pty_cust_cnt_cd",value1[0]);
 		sheetObj.SetCellValue(Row, prefix2 + "n3pty_cust_seq",value1[1]);
 	 }
  }
/**
 * Map of BKG by javaScript
 */
function fnBkgJsMap() { 
	this._array=new Array();// Map Array
	this.pointer=0;
	this._getIndexByKey=function(key) {
		for ( var i=0; i < this._array.length; i++) {
			if (key == this._array[i][0]) {
				return i;
			}
		}
		return -1;
	}
	this.put=function(key, value) {
		var index=this._getIndexByKey(key)
		if (index == -1) {
			var newArray=new Array();// key, value Array
			newArray[0]=key;
			newArray[1]=value;
			this._array[this._array.length]=newArray;
		} else {
			this._array[index][1]=value;
		}
	}
	this.get=function(key) {
		for ( var i=0; i < this._array.length; i++) {
			if (this._array[i][0] == key)
				return this._array[i][1];
		}
	}
	this.containsKey=function(key) {
		for ( var i=0; i < this._array.length; i++) {
			if (this._array[i][0] == key)
				return true;
		}
		return false;
	}
	this.isNext=function() {
		var result;
		if (this._array.length > this.pointer) {
			result=true;
		} else {
			result=false;
		}
		this.pointer++;
		return result;
	}
	this.getKeyString=function(_type) {
		var _result='';
		if (_type == null)
			_type='|';
		for ( var i=0; i < this._array.length; i++) {
			_result=_result + _type + this._array[i][1].charge;
		}
		return _result;
	}
	this.getTextString=function(_type) {
		var _result='';
		if (_type == null)
			_type='|';
		for ( var i=0; i < this._array.length; i++) {
			_result=_result + _type + this._array[i][0];
		}
		return _result;
	}	
	this.size=function() {
		return this._array.length;
	}
	this.nowKey=function() {
		return this._array[this.pointer - 1][0];
	}
	this.nowValue=function() {
		return this._array[this.pointer - 1][1];
	}
}
 /**
  * check enter key
  */
function check_Enter() {
	var formObj=document.form;
	var srcName=ComGetEvent("name");
	var srcValue=ComGetEvent("value");
	if (event.keyCode == 13) {
		if(ComGetEvent("name") == "frm_t10sheet1_bkg_no" || ComGetEvent("name") == "frm_t10sheet1_bl_no"){
			fnClearForm();
			fnClearSelect('svc_scp_cd');// Service Scope
			formObj.elements[srcName].value=srcValue.toUpperCase();
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
}
/**
 * alert BKG Error
 * @param msg
 * @param ex
 * @return
 */
function fnBkgErrorAlert(msg, ex) {
	ComShowMessage('[ ' + msg + ' ] \n [ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
}
/**
 * Exception message
 * @param rXml
 * @return
 */
function fnExceptionMessage(rXml){
	var rMsg=ComGetEtcData(rXml,"Exception")
	var rmsg=rMsg.split("<||>");
	if(rmsg[3] != undefined && rmsg[3].length > 0) {
		ComShowMessage(rmsg[3]);
	}else{
		sheetObjects[0].LoadSaveData(rXml);
	}
}
/**
 * get Container quantity by type
 * @param cntrTpsz
 * @return
 */
function getCntrQtyByType(cntrTpsz){
	var sheetObj=sheetObjects[5];
	var tpSzs=null;
	var dry_cgo_flg=0;
	var dcgo_flg=0;
	var rc_flg=0;
	var awk_cgo_flg=0;
	var bb_cgo_flg=0;
	var hngr_flg=0;
	var soc_flg=0;
	var rcv_term_y=0;
	var rcv_term_d=0;
	var rcv_term_s=0;
	var rcv_term_t=0;
	var rcv_term_i=0;
	var de_term_y=0;
	var de_term_d=0;
	var de_term_s=0;
	var de_term_t=0;
	var de_term_o=0;
	var op_cntr_qty=0;
	tpSzs=ComFindText(sheetObj, prefix6 + "cntr_tpsz_cd", cntrTpsz);
	if(tpSzs != null && tpSzs.length > 0){
		for(idx=0;idx<tpSzs.length;idx++){
			// values
			var vol=ComIsEmpty(sheetObj.GetCellValue(tpSzs[idx],prefix6 + "cntr_vol_qty")) ? 0 : parseFloat(sheetObj.GetCellValue(tpSzs[idx],prefix6 + "cntr_vol_qty"));
			var rterm=sheetObj.GetCellValue(tpSzs[idx],prefix6 + "rcv_term_cd");
			var dterm=sheetObj.GetCellValue(tpSzs[idx],prefix6 + "de_term_cd");
			// special cargo
			if(sheetObj.GetCellValue(tpSzs[idx],prefix6 + "dcgo_flg") == 1) dcgo_flg += vol;
			if(sheetObj.GetCellValue(tpSzs[idx],prefix6 + "rc_flg") == 1) rc_flg += vol;
			if(sheetObj.GetCellValue(tpSzs[idx],prefix6 + "awk_cgo_flg") == 1) awk_cgo_flg += vol;
			if(sheetObj.GetCellValue(tpSzs[idx],prefix6 + "bb_cgo_flg") == 1) bb_cgo_flg += vol;
			if(sheetObj.GetCellValue(tpSzs[idx],prefix6 + "hngr_flg") == 1) hngr_flg += vol;
			if(sheetObj.GetCellValue(tpSzs[idx],prefix6 + "soc_flg") == 1) soc_flg += vol;
			// dry cargo
			if(sheetObj.GetCellValue(tpSzs[idx],prefix6 + "dcgo_flg") == 0 &&
					sheetObj.GetCellValue(tpSzs[idx],prefix6 + "rc_flg") == 0 &&
					sheetObj.GetCellValue(tpSzs[idx],prefix6 + "awk_cgo_flg") == 0 &&
					sheetObj.GetCellValue(tpSzs[idx],prefix6 + "bb_cgo_flg") == 0){
				dry_cgo_flg += vol;
			}
			// receive term / delivery term
			if(rterm == 'Y') rcv_term_y  += vol;
			if(rterm == 'D') rcv_term_d  += vol;
			if(rterm == 'S') rcv_term_s  += vol;
			if(rterm == 'T') rcv_term_t  += vol;
			if(rterm == 'I') rcv_term_i  += vol;
			if(dterm == 'Y') de_term_y  += vol;
			if(dterm == 'D') de_term_d  += vol;
			if(dterm == 'S') de_term_s  += vol;
			if(dterm == 'T') de_term_t  += vol;
			if(dterm == 'O') de_term_o  += vol;
			// total volumn
			op_cntr_qty += vol;
		}
	}
	if(cntrTpsz == 'D4' && document.form.flex_hgt_flg.value == 'Y'){
		tpSzs=ComFindText(sheetObj, "cntr_tpsz_cd", "D5");
		if(tpSzs != null && tpSzs.length > 0) {
			for(idx=0;idx<tpSzs.length;idx++){
				// values
				var vol=ComIsEmpty(sheetObj.GetCellValue(tpSzs[idx],prefix6 + "cntr_vol_qty")) ? 0 : parseFloat(sheetObj.GetCellValue(tpSzs[idx],prefix6 + "cntr_vol_qty"));
				var rterm=sheetObj.GetCellValue(tpSzs[idx],prefix6 + "rcv_term_cd");
				var dterm=sheetObj.GetCellValue(tpSzs[idx],prefix6 + "de_term_cd");
				// special cargo
				if(sheetObj.GetCellValue(tpSzs[idx],prefix6 + "dcgo_flg") == 1) dcgo_flg += vol;
				if(sheetObj.GetCellValue(tpSzs[idx],prefix6 + "rc_flg") == 1) rc_flg += vol;
				if(sheetObj.GetCellValue(tpSzs[idx],prefix6 + "awk_cgo_flg") == 1) awk_cgo_flg += vol;
				if(sheetObj.GetCellValue(tpSzs[idx],prefix6 + "bb_cgo_flg") == 1) bb_cgo_flg += vol;
				if(sheetObj.GetCellValue(tpSzs[idx],prefix6 + "hngr_flg") == 1) hngr_flg += vol;
				if(sheetObj.GetCellValue(tpSzs[idx],prefix6 + "soc_flg") == 1) soc_flg += vol;
				// dry cargo
				if(sheetObj.GetCellValue(tpSzs[idx],prefix6 + "dcgo_flg") == 0 &&
						sheetObj.GetCellValue(tpSzs[idx],prefix6 + "rc_flg") == 0 &&
						sheetObj.GetCellValue(tpSzs[idx],prefix6 + "awk_cgo_flg") == 0 &&
						sheetObj.GetCellValue(tpSzs[idx],prefix6 + "bb_cgo_flg") == 0){
					dry_cgo_flg += vol;
				}
				// receive term / delivery term
				if(rterm == 'Y') rcv_term_y  += vol;
				if(rterm == 'D') rcv_term_d  += vol;
				if(rterm == 'S') rcv_term_s  += vol;
				if(rterm == 'T') rcv_term_t  += vol;
				if(rterm == 'I') rcv_term_i  += vol;
				if(dterm == 'Y') de_term_y  += vol;
				if(dterm == 'D') de_term_d  += vol;
				if(dterm == 'S') de_term_s  += vol;
				if(dterm == 'T') de_term_t  += vol;
				if(dterm == 'O') de_term_o  += vol;
				// total volumn
				op_cntr_qty += vol;
			}
		}
	}
	// return array
	var cntrQtyArr=new Array();
	cntrQtyArr[0]=cntrTpsz;
	cntrQtyArr[1]="Difference";
	cntrQtyArr[2]=dry_cgo_flg;
	cntrQtyArr[3]=dcgo_flg;
	cntrQtyArr[4]=rc_flg;
	cntrQtyArr[5]=awk_cgo_flg;
	cntrQtyArr[6]=bb_cgo_flg;
	cntrQtyArr[7]=hngr_flg;
	cntrQtyArr[8]=soc_flg;
	cntrQtyArr[9]=rcv_term_y;
	cntrQtyArr[10]=rcv_term_d;
	cntrQtyArr[11]=rcv_term_s;
	cntrQtyArr[12]=rcv_term_t;
	cntrQtyArr[13]=rcv_term_i;
	cntrQtyArr[14]=de_term_y;
	cntrQtyArr[15]=de_term_d;
	cntrQtyArr[16]=de_term_s;
	cntrQtyArr[17]=de_term_t;
	cntrQtyArr[18]=de_term_o;
	cntrQtyArr[19]=op_cntr_qty;
	return cntrQtyArr;
}
/**
 * check modify
 */
function checkModify(){	
	var formObj=document.form;
	if(ComGetObjValue(formObj.isInquiry) == "Y") return;
	if(ComGetObjValue(formObj.caflag) == "Y")return;
	if(fnModifyCheckAfter()){
		if(ComGetObjValue(formObj.modify_flag) == "Y"){
			if (!ComShowConfirm(ComGetMsg("BKG00350")))
				return false; // Are you sure to save the changes?
			tab_alert_msg=false;
			doActionIBSheet(sheetObjects[1], document.form, IBSAVE);
		}
	}
}
/**
 * retrieve when clicking Tab
 * @param bkgNo
 * @return
 */
function searchData(bkgNo){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	ComSetObjValue(formObj.frm_t10sheet1_bkg_no ,bkgNo);
	ComSetObjValue(formObj.modify_flag,"N");
	doActionIBSheet(sheetObj, formObj, IBSEARCH);
}
/**
 * button disable
 */
function setInquiryDisableButton(){
	ComBtnDisable("btn_t10save");
	ComBtnDisable("btn_t10cntr_rate");
	ComBtnDisable("btn_t10auto_rating");
	ComBtnDisable("btn_t10exchange_rating");
	ComBtnDisable("btn_t10clear");
	ComBtnDisable("btn_t10remark");
	ComBtnDisable("btn_t10self");
	ComBtnDisable("btn_t10tpb_link");
}
/**
 * check RT apply date
 */
function fnSearchRtAplyDateCheck(){
	var formObj=document.form;
	var v_bkg_no=ComGetObjValue(formObj.frm_t10sheet1_bkg_no);
	// 1.validation
	if ('' == v_bkg_no ) return;
	var input_text=v_bkg_no;
	// 2.search
	var param=param+ "&f_cmd=" + SEARCH07 + "&input_text=" + input_text;
	var sXml=sheetObjects[1].GetSearchData("ESM_Booking_UtilGS.do", param);
	var output_text=ComGetEtcData(sXml,"output_text");
	if('N' == output_text && 'C' == ComGetObjValue(formObj.frm_t10sheet1_rt_bl_tp_cd)) {
		 ComSetObjValue(formObj.frm_t10sheet1_rt_aply_dt ,'');
		 ComShowCodeMessage("BKG08178");	 	 
	}
}

/*
 * DP_PRCS_KNT 조회 ...
 */
function fnGetDpPrcsKnt(sheetObj, curr_cd){
	var param="f_cmd=" + SEARCH17 + "&curr_cd=" + curr_cd;
	var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
	var dp_prcs_knt  =ComGetEtcData(sXml, "dp_prcs_knt");
	
	return dp_prcs_knt;
}


/**
 * self retrieve
 */
function selfRetrieve() {
	document.getElementById("btn_t10retrieve").fireEvent("onclick");
}
function selfAuditExecute(){
	if(undefined != document.form.skip_flag_fun_selfAuditExecute && "Y" == document.form.skip_flag_fun_selfAuditExecute.value){
		if (isOpenSelfAudit && ComShowCodeConfirm("BKG08185")) {  //Do you continue to self-audit?
			document.getElementById("btn_t10self").fireEvent("onclick");
		}
		isOpenSelfAudit=false;
		isOpenSelfAudit2=false;
	}
}

function showControl(clzNm, val) {
	$('.' + clzNm).css('display', val ? 'inline' : 'none');
}

function isShow(clzNm) {
	return $('.' + clzNm).css('display') == 'inline' || $('.' + clzNm).css('display') == 'block';
}

/*
 * MOUSE PASTE 이벤트
 */
function mousePaste(obj){
	setTimeout(function(){
    	checkSpecial(obj);	//특수문자 제외 로직
	}, 100)
}  

/**
 * search location code
 * @param v_ofc_cd
 * @return
 */
function fnLocCdByOfcCd(v_ofc_cd) {
	 var sheetObj=sheetObjects[3];
	 var param=param + "&f_cmd=" + SEARCH21 + "&ofc_cd=" + v_ofc_cd;
	 var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
	 var output_text=ComGetEtcData(sXml, "LOC_CD");
	 return output_text;
}