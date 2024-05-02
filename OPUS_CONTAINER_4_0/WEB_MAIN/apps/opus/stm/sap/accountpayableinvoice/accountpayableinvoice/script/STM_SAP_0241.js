/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0241.js
*@FileTitle  : Prepayment Invoice Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
/****************************************************************************************
     Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                  MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;				
 ***************************************************************************************/
    /**
     * @extends 
     * @class Invoices : business script for STM_SAP_0241
     */
	var focusObj=null;
	// public variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var sheetObject1;
	var sheetObject2;
    var sheetObject3;	
    var prefix1; 
	var prefix2;
	var prefix3;
	var comboObjects=new Array();
	var comboCnt=0;
	var POINT;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		/*******************************************************/
		var formObj=document.form;
		var sheetObject1=sheetObjects[0];
     	try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_close":
					ComClosePopup(); 
					break;
				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
 				case "btn_apply":
 					doActionIBSheet(sheetObject2, formObj, MULTI01);
 					break;
 				case "btn_unapply":
 					doActionIBSheet(sheetObject3, formObj, MULTI02);
 					break;
			} // end switch
		}catch(e) {
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
	 * registering IBCombo Object as list
	 * @param combo_obj
	 * @return
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
	function loadPage() {
		var formObj=document.form;
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		initControl();
		this.sheetObject1=sheetObjects[0];
		this.sheetObject2=sheetObjects[1];
	    this.sheetObject3=sheetObjects[2];
	    this.prefix1=sheetObject1.id + "_"; 
	    this.prefix2=sheetObject2.id + "_";
	    this.prefix3=sheetObject3.id + "_";	 
	    this.POINT=parseInt(formObj.hid_point.value);
	    doActionIBSheet(sheetObject1, formObj, IBSEARCH);
	    
	   
	}
	/**
	 * Combo Setting default
	 * @param	{IBMultiCombo}	combo_obj.
	 * @param	{Number}	comboNo		Sequence number from combo object tag id
	 */
	function initCombo (comboObj, comboNo) {
	    //var cnt  = 0 ;
	    var formObject=document.form
	    switch(comboNo) {
			   case 1:
		           with (comboObj) {
			       }
	           break;
			   default :
		           with (comboObj) {
			       }
	           break;
	     }
	}	
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		switch(sheetNo) {
			case 1:      // hidden sheet (header) 
				with (sheetObj) {
			        var HeadTitle1="|inv_seq|vndr_no|inv_no|inv_curr_cd|inv_pay_curr_cd|inv_amt|inv_pay_amt|inv_dt|ap_inv_src_cd|inv_tp_lu_cd|inv_desc|bat_seq|inv_vat_amt|inv_term_nm|inv_term_dt|pay_mzd_lu_cd|ap_pay_grp_lu_cd|liab_coa_co_cd|liab_coa_rgn_cd|liab_coa_ctr_cd|liab_coa_acct_no|liab_coa_vvd_cd|liab_coa_inter_co_cd|pay_sts_flg|inv_func_amt|inv_vat_cd|inv_xch_rt|inv_xch_rt_tp_cd|inv_xch_dt|ery_stl_dt|attr_ctnt1|attr_ctnt2|attr_ctnt3|attr_ctnt4|attr_ctnt5|attr_ctnt6|attr_ctnt7|attr_ctnt8|attr_ctnt9|attr_ctnt10|attr_ctnt11|attr_ctnt12|attr_ctnt13|attr_ctnt14|attr_ctnt15|attr_cate_nm|ap_apsts_cd|inv_cxl_dt|cxl_usr_id|inv_cxl_amt|ofc_cd|glo_attr_cate_nm|glo_attr_ctnt1|glo_attr_ctnt2|glo_attr_ctnt3|glo_attr_ctnt4|glo_attr_ctnt5|glo_attr_ctnt6|glo_attr_ctnt7|glo_attr_ctnt8|glo_attr_ctnt9|glo_attr_ctnt10|glo_attr_ctnt11|glo_attr_ctnt12|glo_attr_ctnt13|glo_attr_ctnt14|glo_attr_ctnt15|glo_attr_ctnt16|glo_attr_ctnt17|glo_attr_ctnt18|glo_attr_ctnt19|glo_attr_ctnt20|pay_curr_inv_amt|gl_dt|inv_apro_rdy_flg|dtrb_set_seq|xter_bank_acct_seq|liab_cd_cmb_seq|vndr_lgl_eng_nm|prepay_tot_amt|prepay_rmn_tot_amt|f_curr";
			        var headCount=ComCountHeadTitle(HeadTitle1);
	
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:3, DataRowMerge:1 } );
	
			        var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_pay_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_amt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_pay_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ap_inv_src_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_tp_lu_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_desc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bat_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_vat_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_term_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_term_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_mzd_lu_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ap_pay_grp_lu_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"liab_coa_co_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"liab_coa_rgn_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"liab_coa_ctr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"liab_coa_acct_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"liab_coa_vvd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"liab_coa_inter_co_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_sts_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_func_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_vat_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_xch_rt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_xch_rt_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_xch_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ery_stl_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"attr_cate_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ap_apsts_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_cxl_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cxl_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_cxl_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ofc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"glo_attr_cate_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_curr_inv_amt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"gl_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_apro_rdy_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dtrb_set_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"xter_bank_acct_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"liab_cd_cmb_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_lgl_eng_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"prepay_tot_amt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"prepay_rmn_tot_amt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"functional_currency",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			         
			        InitColumns(cols);
	
					SetEditable(1);
					SetSheetHeight(135);
		    	}
			break;		
			case 2:      // apply sheet
				with (sheetObj) {
			        var HeadTitle1="|Apply|Amount to Apply|GL Date|Invoice Number|Amount Unpaid|Include Tax Amount|Supplier|Supplier Name|Invoice Description|Invoice ID|Invoice Currency|Payment Currency|Invoice Date|Payment Cross Rate Date";
			        var headCount=ComCountHeadTitle(HeadTitle1);
	
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			        var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
				               {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"apply",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"amount_apply",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"apply_gl_date",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"amount_unpaid",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"tax_unpaid",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vndr_lgl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"inv_desc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_pay_curr_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_cross_rate_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			         
			        InitColumns(cols);
	
			        SetEditable(1);
			        SetSheetHeight(160);
			    break;
			}
			case 3:      // unapply sheet
				with (sheetObj) {
			        var HeadTitle1="|Unapply|Item Amount Applied|Tax Amount Applied|GL Date|Invoice Number|Prepayment Line Num|Supplier|Supplier Name|Description|Invoice ID|Dist Line Number|Prepayment Invoice ID|Period Name|Prepayment ID|IF Flag";
			        var headCount=ComCountHeadTitle(HeadTitle1);
	
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			        var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
				               {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"unapply",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:130,  Align:"Right",   ColMerge:1,   SaveName:prefix+"prepay_amount_applied", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:130,  Align:"Right",   ColMerge:1,   SaveName:prefix+"tax_amount_applied",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"unapply_gl_date",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ppay_line_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_lgl_eng_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dtrb_desc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dtrb_line_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ppay_inv_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eff_yrmon",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1, Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"prepay_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"if_flag", 				KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			        InitColumns(cols);
	
			        SetEditable(1);
			        SetSheetHeight(160);
			}
			break;		
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction, CondParam) {
		sheetObj.ShowDebugMsg(false);
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		if(!validateForm(sheetObj,formObj,sAction)){
			return false;
		}
		switch (sAction) {
			case IBSEARCH: // RETRIEVE HEADER
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
				sheetObject3.RemoveAll();
				formObj.f_cmd.value=SEARCH;
				var sXml=sheetObj.GetSearchData("STM_SAP_0241GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				break;
			case SEARCH01: // RETRIEVE DETAIL
				formObj.f_cmd.value=SEARCH01;
				sheetObject2.RemoveAll();
				sheetObject3.RemoveAll();
				var sXml=sheetObj.GetSearchData("STM_SAP_0241GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(prefix2)+ "&" + ComGetPrefixParam(prefix3) + "&" + CondParam);
				//var sXml = sheetObj.GetSearchXml("STM_SAP_0241GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(prefix2)+ "&" + ComGetPrefixParam(prefix3)); 
				var arrXml=sXml.split("|$$|");
				sheetObject2.LoadSearchData(arrXml[0],{Sync:1} );
				sheetObject3.LoadSearchData(arrXml[1],{Sync:1} );
				break;	
			case COMMAND01: // RETRIEVE GL_DATE
				formObj.f_cmd.value=COMMAND01;
				var xmlStr=sheetObj.GetSearchData("STM_SAP_0241GS.do", "f_cmd=" + COMMAND01 + "&value0=" + inv_dt + "&value1=" + ofc_cd);
				if (SAPDecideErrXml(sheetObj, xmlStr)) {
					SetCellValue(Row, Col, "");
	                SelectCell(Row, Col, true, "");
	            } else {
	                var chk_period=ComGetEtcData(xmlStr, "chk_period");
	            }
				break;		
			case MULTI01: // Apply
				formObj.f_cmd.value=MULTI01;
				//checking mandatory
				var sParam1=ComGetSaveString(sheetObjects[0], true, true);
				if(sParam1 == "" ){
					//return;
				}
				var sParam2=ComGetSaveString(sheetObjects[1], true, true);
				if(sParam2 == "" ){
					//return;
				}
				var sParam=sParam1 + "&" + sParam2 + "&" +FormQueryString(formObj);
				ComOpenWait(true);
				var sXml=sheetObj.GetSaveData("STM_SAP_0241GS.do", sParam);
				sheetObj.LoadSaveData(sXml);
				ComOpenWait(false);
				if (SAPDecideErrXml(sheetObj, sXml)) return;
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				break;
			case MULTI02: // UnApply
				formObj.f_cmd.value=MULTI02;
				//checking mandatory
				var sParam1=ComGetSaveString(sheetObjects[0], true, true);
				if(sParam1 == "" ){
					//return;
				}
				var sParam3=ComGetSaveString(sheetObjects[2], true, true);
				if(sParam3 == "" ){
					//return;
				}
				
				
				var sParam=sParam1 + "&" + sParam3 + "&" +FormQueryString(formObj);
				ComOpenWait(true);
				var sXml=sheetObj.GetSaveData("STM_SAP_0241GS.do", sParam);
				sheetObj.LoadSaveData(sXml);
                ComOpenWait(false);
				if (SAPDecideErrXml(sheetObj, sXml)) return;
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				break;				
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		var sheetObject1=sheetObjects[0];
		switch (sAction) {
			case IBSEARCH: //retrieve
				if(formObj.hid_inv_seq.value == ""){
					ComShowCodeMessage("COM12113", "Prepayment Invoice Seq");
					return false;
				}
				break;
			case IBSAVE: //SAVE
				break;
			case MULTI02: // UnApply
				
				for(var i=1; i <= sheetObjects[2].RowCount(); i++ ) {
					if(sheetObjects[2].GetCellValue(i, prefix3 + "unapply") == "1" && sheetObjects[2].GetCellValue(i, prefix3 + "if_flag") == "Y") {
						ComShowCodeMessage("SAP00063", sheetObjects[2].GetCellValue(i, prefix3 + "inv_no"));   
						return false;
					}
				}
				break;
		}
		return true;
	}
	/**
	 * loading HTML Control event <br>
	 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sequence number in sheetObjects array
	 **/
	function initControl() {
		var form=document.form; 		
// 		axon_event.addListenerForm('keypress', 'obj_keypress',  form);    	  
// 		axon_event.addListenerForm('keyup',    'obj_keyup',   	form);
// 		axon_event.addListenerForm  ('blur', 'obj_deactivate',  form);   //blur  beforedeactivate  
// 		axon_event.addListenerFormat('focus', 'obj_activate', form);
	}
    /**
     * Form Element의 keypress 이벤트
     */  
	function obj_keypress() {
		switch(event.srcElement.dataformat){
			case "engup":
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "engnum":
				ComKeyOnlyAlphabet('uppernum');
				break;	
			case "int":
				//숫자 만입력하기
				ComKeyOnlyNumber(ComGetEvent());
				break;
			case "ymd":
				ComKeyOnlyNumber(ComGetEvent());
				break;
			case "ym":
				ComKeyOnlyNumber(ComGetEvent());
				break;	
			case "float":
				ComKeyOnlyNumber(ComGetEvent(), "-.");
				break;
			default:
				//common standard: recognization only number, english
				ComKeyOnlyAlphabet("num");
				break;     
		}
		if(event.KeyCode == 13){
			ComSetNextFocus(ComGetEvent());
		}
	}    
    /** 
     * handling keyup event of Object  <br>
     * checking validation of input value by dataformat of object  <br>
     */ 
	function obj_keyup(){
	}  
    /** 
     * handling work javascript OnFocus event  <br>
     */    
	function obj_activate() {
       	//delete mask separator
        ComClearSeparator(ComGetEvent());        
    }
    /** 
     * handling work javascript OnBlur event  <br>
     */    
    function obj_blur(){
    }    
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
     **/
	function obj_deactivate(){
		//ComChkObjValid(ComGetEvent());		
	}
    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {sheetObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {		
		if (ErrMsg != "") return;
		var formObj=document.form;
        with (sheetObj) {
            if (RowCount()< 1) {
            	sheetObj.RemoveAll();
            } else {
            	formObj.csr_no.value=sheetObj.GetCellValue(1, prefix1 + "inv_no");
            	formObj.vndr_no.value=sheetObj.GetCellValue(1, prefix1 + "vndr_no");
            	formObj.vndr_nm.value=sheetObj.GetCellValue(1, prefix1 + "vndr_lgl_eng_nm");
            	formObj.prepay_amt.value=sheetObj.GetCellValue(1, prefix1 + "inv_amt");
            	formObj.remain_amt.value=sheetObj.GetCellValue(1, prefix1 + "prepay_rmn_tot_amt");
            	for (var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++){
        			sheetObj.SetCellValue(i, prefix1+"functional_currency",formObj.f_curr.value,0);
        		}
            	doActionIBSheet(sheetObject2, formObj, SEARCH01, RowSaveStr(1));
            }
        }
	}		
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function sheet2_OnChange(sheetObj, Row, Col, Value) {
    	var formObj=document.form;
    	
        with (sheetObj) {
            switch (ColSaveName(Col)) {
                case prefix2 + "apply":
                	if (Value == "1") {
                		SetCellEditable(Row, prefix2 + "apply_gl_date",1);
                		SetCellEditable(Row, prefix2 + "amount_apply",1);
                		//GLDate setting
                		var gl_dt=formObj.sys_curr_date.value;
                		var ofc_cd=sheetObject1.GetCellValue(1, prefix1 + "ofc_cd");
                		var xmlStr=sheetObj.GetSearchData("STM_SAP_0241GS.do", "f_cmd=" + COMMAND01 + "&value0=" + gl_dt + "&value1=" + ofc_cd);
                		if (SAPDecideErrXml(sheetObj, xmlStr)) {
        	            } else {
        	                var get_gl_dt=ComGetEtcData(xmlStr, "gl_dt");
        	                if (get_gl_dt == "NO_DATA") {
        	                	ComShowCodeMessage("SAP00030");  
        	                	sheetObj.SetCellValue( Row, prefix2 + "apply","0");
        	                } else {
        	                	sheetObj.SetCellValue( Row, prefix2 + "apply_gl_date",get_gl_dt,0);
        	                	var remain_amt=parseFloat(ComReplaceStr(formObj.remain_amt.value, ",", ""));
        	                	var unpaid_amt=parseFloat(ComReplaceStr(sheetObj.GetCellValue( Row, prefix2 + "amount_unpaid"), ",", "")) + parseFloat(ComReplaceStr(sheetObj.GetCellValue( Row, prefix2 + "tax_unpaid"), ",", ""));
        	                	if ( remain_amt > 0 ) { 
	        	                	if (unpaid_amt <= remain_amt) {
	        	                		sheetObj.SetCellValue( Row, prefix2 + "amount_apply",SAPComAddComma2(unpaid_amt+"",POINT),0);
	        	                		formObj.remain_amt.value=SAPComAddComma2((remain_amt - unpaid_amt)+"", POINT) ; 
	        	                	} else {
	        	                		sheetObj.SetCellValue( Row, prefix2 + "amount_apply",formObj.remain_amt.value,0);
	        	                		formObj.remain_amt.value=SAPComAddComma2("0", POINT) ; 
	        	                		/*ComShowCodeMessage("SAP00037");  
	            	                	sheetObj.SetCellValue( Row, prefix2 + "apply","0",0);
	            	                	sheetObj.SetCellValue( Row, prefix2 + "apply_gl_date","",0);
	            	                	sheetObj.SetCellValue( Row, prefix2 + "amount_apply","0",0);
	            	                	sheetObj.SetCellEditable(Row, prefix2 + "apply_gl_date",0);
	            	                	sheetObj.SetCellEditable(Row, prefix2 + "amount_apply",0);*/
	        	                	}
        	                	} else {
        	                		ComShowCodeMessage("SAP00037");  
            	                	sheetObj.SetCellValue( Row, prefix2 + "apply","0",0);
            	                	sheetObj.SetCellValue( Row, prefix2 + "apply_gl_date","",0);
            	                	sheetObj.SetCellValue( Row, prefix2 + "amount_apply","0",0);
            	                	sheetObj.SetCellEditable(Row, prefix2 + "apply_gl_date",0);
            	                	sheetObj.SetCellEditable(Row, prefix2 + "amount_apply",0);
        	                	}
        	                }
        	            }
                	} else {
	                	var remain_amt=parseFloat(ComReplaceStr(formObj.remain_amt.value, ",", ""));
	                	var apply_amt=parseFloat(ComReplaceStr(sheetObj.GetCellValue( Row, prefix2 + "amount_apply"), ",", ""));
	               		formObj.remain_amt.value=SAPComAddComma2((remain_amt + apply_amt) + "", POINT) ; 
	               		sheetObj.SetCellValue( Row, prefix2 + "amount_apply","0",0);
                    	sheetObj.SetCellValue( Row, prefix2 + "apply_gl_date","",0);
                		SetCellEditable(Row, prefix2 + "apply_gl_date",0);
                		SetCellEditable(Row, prefix2 + "amount_apply",0);
                	}
                    break;
                case prefix2 + "amount_apply":    
                	var apply_amt=parseFloat(ComReplaceStr(sheetObj.GetCellValue( Row, prefix2 + "amount_apply"), ",", "")) ;
                	var unpaid_amt=parseFloat(ComReplaceStr(sheetObj.GetCellValue( Row, prefix2 + "amount_unpaid"), ",", "")) + parseFloat(ComReplaceStr(sheetObj.GetCellValue( Row, prefix2 + "tax_unpaid"), ",", ""));
                	var remain_amt=parseFloat(getCalcRemainAmt());
                	
              //  	formObj.remain_amt.value=SAPComAddComma2(getCalcRemainAmt() + "", POINT ) ; 
                	
                	if(apply_amt > unpaid_amt) {
                		ComShowCodeMessage("SAP00039", "Amount To Apply", "Amount Unpaid");  
                		sheetObj.SetCellValue( Row, prefix2 + "amount_apply","0",0);
                		formObj.remain_amt.value=SAPComAddComma2(getCalcRemainAmt() + "", POINT ) ; 
                		sheetObj.SetCellValue( Row, prefix2 + "apply","0");
                		break;
                	}
                	
                	if ( apply_amt  <= ( remain_amt + apply_amt) ) {
                		sheetObj.SetCellValue( Row, prefix2 + "amount_apply",SAPComAddComma2(sheetObj.GetCellValue( Row, prefix2 + "amount_apply"), POINT),0);
                		formObj.remain_amt.value=SAPComAddComma2(getCalcRemainAmt() + "", POINT ) ; 
                	} else {
                		ComShowCodeMessage("SAP00037");  
	                	sheetObj.SetCellValue( Row, prefix2 + "apply","0",0);
	                	sheetObj.SetCellValue( Row, prefix2 + "apply_gl_date","",0);
	                	sheetObj.SetCellValue( Row, prefix2 + "amount_apply","0");
	                	sheetObj.SetCellEditable(Row, prefix2 + "apply_gl_date",0);
	                	sheetObj.SetCellEditable(Row, prefix2 + "amount_apply", 0);
                	}                	
                	
                	break;
                case prefix2 + "apply_gl_date":
            		//GLDate setting
                	var gl_dt=sheetObj.GetCellValue(Row, prefix2 + "apply_gl_date");
                	var ofc_cd=sheetObject1.GetCellValue(1, prefix1 + "ofc_cd");
                	var xmlStr=sheetObj.GetSearchData("STM_SAP_0241GS.do", "f_cmd=" + COMMAND01 + "&value0=" + gl_dt + "&value1=" + ofc_cd);
            		if (SAPDecideErrXml(sheetObj, xmlStr)) {
    	            } else {
    	                var get_gl_dt=ComGetEtcData(xmlStr, "gl_dt");
    	                if (get_gl_dt == "NO_DATA") {
    	                	ComShowCodeMessage("SAP00030");  
    	                	sheetObj.SetCellValue( Row, prefix2 + "apply","0");
    	                	sheetObj.SetCellValue( Row, prefix2 + "apply_gl_date",sheetObj.CellSearchValue(Row, prefix2 + "apply_gl_date") ,0);
    	                } else {
    	                	sheetObj.SetCellValue( Row, prefix2 + "apply_gl_date",get_gl_dt,0);
    	                }
    	            }
                	break;    	
            }
        }
    }
    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {sheetObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
    }
    /**
     * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */	
	function sheet2_OnPopupClick(sheetObj, Row, Col){
		with (sheetObj) {
            switch (ColSaveName(Col)) {
                case  prefix2 + "apply_gl_date":    //apply_gl_date
                	var cal=new ComCalendarGrid(prefix2 + "apply_gl_date");
                	cal.endFunction="ComCalendar_EndFunction_apply";
        			cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
                	break;               	
            }
		}
	}    
	/**
	 * After completing calendar input, execute function.<br>
	 */
	function ComCalendar_EndFunction_apply(){
		with(sheetObjects[1]) {
			sheet2_OnChange(sheetObjects[1], GetSelectRow(), SaveNameCol(prefix2+"apply_gl_date"), GetCellValue(GetSelectRow(), prefix2+"apply_gl_date"));
		}
	}
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function sheet3_OnChange(sheetObj, Row, Col, Value) {
    	var formObj=document.form;
        with (sheetObj) {
            switch (ColSaveName(Col)) {
                case prefix3 + "unapply":
                	if (Value == "1") {
                		
                		//SAKURA에 전송한 데이타는 unapply 할 수 없다.
                		if( sheetObjects[2].GetCellValue(Row, prefix3 + "if_flag") == "Y") {
    						ComShowCodeMessage("SAP00063", sheetObjects[2].GetCellValue(Row, prefix3 + "inv_no"));  
    						sheetObj.SetCellValue( Row, prefix3 + "unapply","0");
    						return false;
    					}
                		
                		SetCellEditable(Row, prefix3 + "unapply_gl_date",1);
                		//GLDate setting
                		var gl_dt=sheetObject3.GetCellValue(Row, prefix3 + "unapply_gl_date");
                		var ofc_cd=sheetObject1.GetCellValue(1, prefix1 + "ofc_cd");
                		var xmlStr=sheetObj.GetSearchData("STM_SAP_0241GS.do", "f_cmd=" + COMMAND01 + "&value0=" + gl_dt + "&value1=" + ofc_cd);
                		if (SAPDecideErrXml(sheetObj, xmlStr)) {
        	            } else {
        	                var get_gl_dt=ComGetEtcData(xmlStr, "gl_dt");
        	                if (get_gl_dt == "NO_DATA") {
        	                	ComShowCodeMessage("SAP00038");  
        	                	sheetObj.SetCellValue( Row, prefix3 + "unapply","0");
        	                	sheetObj.SetCellValue( Row, prefix3 + "unapply_gl_date",sheetObj.CellSearchValue(Row, prefix3 + "unapply_gl_date") ,0);
        	                } else {
        	                	sheetObj.SetCellValue( Row, prefix3 + "unapply_gl_date",get_gl_dt,0);
        	                }
        	            }
                	} else {
                    	sheetObj.SetCellValue( Row, prefix3 + "unapply_gl_date",sheetObj.CellSearchValue(Row, prefix3 + "unapply_gl_date") ,0);
	            		SetCellEditable(Row, prefix3 + "unapply_gl_date",0);
                	}
                    break;
                case prefix3 + "unapply_gl_date":
            		//GLDate setting
                	var gl_dt=sheetObject3.GetCellValue(Row, prefix3 + "unapply_gl_date");
                	var ofc_cd=sheetObject1.GetCellValue(1, prefix1 + "ofc_cd");
                	var xmlStr=sheetObj.GetSearchData("STM_SAP_0241GS.do", "f_cmd=" + COMMAND01 + "&value0=" + gl_dt + "&value1=" + ofc_cd);
            		if (SAPDecideErrXml(sheetObj, xmlStr)) {
    	            } else {
    	                var get_gl_dt=ComGetEtcData(xmlStr, "gl_dt");
    	                if (get_gl_dt == "NO_DATA") {
    	                	ComShowCodeMessage("SAP00038");  
    	                	sheetObj.SetCellValue( Row, prefix3 + "unapply","0");
    	                	sheetObj.SetCellValue( Row, prefix3 + "unapply_gl_date",sheetObj.CellSearchValue(Row, prefix3 + "unapply_gl_date") ,0);
    	                } else {
    	                	sheetObj.SetCellValue( Row, prefix3 + "unapply_gl_date",get_gl_dt,0);
    	                }
    	            }
                	break;    
            }
        }
    }   
    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {sheetObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet3_OnSaveEnd(sheetObj, ErrMsg) {
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
    } 
    /**
     * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */	
	function sheet3_OnPopupClick(sheetObj, Row, Col){
		with (sheetObj) {
            switch (ColSaveName(Col)) {
                case  prefix3 + "unapply_gl_date":    //apply_gl_date
                	var cal=new ComCalendarGrid(prefix3 + "unapply_gl_date");
                	cal.endFunction="ComCalendar_EndFunction_unapply";
        			cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
                	break;               	
            }
		}
	}    
	/**
	 * After completing calendar input, execute function.<br>
	 */
	function ComCalendar_EndFunction_unapply(){
		with(sheetObjects[2]) {
			sheet3_OnChange(sheetObjects[2], GetSelectRow(), SaveNameCol(prefix3+"unapply_gl_date"), GetCellValue(GetSelectRow(), prefix3+"unapply_gl_date"));
		}
	}	
    /**
     * Prepayment Amount Remaining calc
     */   
    function getCalcRemainAmt() {
    	var orgRmnAmt=parseFloat(ComReplaceStr(sheetObject1.GetCellValue(1, prefix1 + "prepay_rmn_tot_amt"), ",", ""));
    	var sumApply=0;
    	for (var i=sheetObject2.HeaderRows(); i<= sheetObject2.LastRow(); i++){
    		if ( "1" == sheetObject2.GetCellValue(i, prefix2 +"apply") ) {
    			sumApply += parseFloat(ComReplaceStr(sheetObject2.GetCellValue( i, prefix2 + "amount_apply"), ",", ""));
    		}			
		}
    	return orgRmnAmt - parseFloat(sumApply);
    }
    
    

