/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0021.js
*@FileTitle  : Payments Slip
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class ESM_FMS_0021 : ESM_FMS_0021 Payments Slip definition of biz script for creation screen
 */
// common global variables 
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Effective Date inserted previously (Use to prevent calling server when same value is inserted)
var pre_eff_dt="";
// Event handler processing by button click event*/
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
     var sheetObject=sheetObjects[0];
     var sheetObject1=sheetObjects[1];
     var sheetObject2=sheetObjects[2];
     var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
        	case "btn_prepayments": // Prepayments Button
        		if(validateForm(sheetObject,formObject,IBSEARCH,'N') == false) return;
        		if(sheetObject.RowCount()!= 0) {
        			formObject.ppay_hir_no.value="";
        			sheetObject.RemoveAll();
        		}
        		setTotalAmount('S');
        		var flet_ctrt_no=formObject.flet_ctrt_no.value;
        		var csr_curr_cd=formObject.csr_curr_cd.value;
        		ComOpenPopup("ESM_FMS_0024.do?flet_ctrt_no="+flet_ctrt_no+"&csr_curr_cd="+csr_curr_cd, 900, 450, "setPrepayments", "1,0,1,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0024");
				break;
        	case "btn_charterersExp": // Acct Management Button
        		if(validateForm(sheetObject,formObject,IBSEARCH,'N') == false) return;
        		if(!preWorkCheck()) return; 
        		initCheckBox(sheetObject);
        		for (var ir=sheetObject.LastRow(); ir>=sheetObject.HeaderRows(); ir--) {
        			if(sheetObject.GetCellValue(ir,"pop_gb") == "CHT") {
        				sheetObject.SetCellValue(ir,"DelChk",1,0);
        				rowRemove(sheetObject, "");
        			}
        		}
        		setTotalAmount('S');
        		var flet_ctrt_no=formObject.flet_ctrt_no.value;
        		var csr_curr_cd=formObject.csr_curr_cd.value;
        		ComOpenPopup("ESM_FMS_0025.do?flet_ctrt_no="+flet_ctrt_no+"&csr_curr_cd="+csr_curr_cd, 900, 378, "setCharterersExp", "1,0,1,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0025");
        		initType();
				break;
        	case "btn_offhireExp": // Offhire Exp Button
        		if(validateForm(sheetObject,formObject,IBSEARCH,'N') == false) return;
        		if(!preWorkCheck()) return; 
        		initCheckBox(sheetObject);
        		for (var ir=sheetObject.LastRow(); ir>=sheetObject.HeaderRows(); ir--) {
        			if(sheetObject.GetCellValue(ir,"pop_gb") == "OFF") {
        				sheetObject.SetCellValue(ir,"DelChk",1,0);
        				rowRemove(sheetObject, "");
        			}
        		}
        		setTotalAmount('S');
        		var flet_ctrt_no=formObject.flet_ctrt_no.value;
        		var csr_curr_cd=formObject.csr_curr_cd.value;
        		ComOpenPopup("ESM_FMS_0026.do?flet_ctrt_no="+flet_ctrt_no+"&csr_curr_cd="+csr_curr_cd, 900, 378, "setOffhireExp", "1,0,1,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0026");
        		initType();
        		break;
        	case "btn_ownersAccount": // Not Used.
        		if(validateForm(sheetObject,formObject,IBSEARCH,'N') == false) return;
        		if(!preWorkCheck()) return; 
        		initCheckBox(sheetObject);
        		for (var ir=sheetObject.LastRow(); ir>=sheetObject.HeaderRows(); ir--) {
        			if(sheetObject.GetCellValue(ir,"pop_gb") == "OWN") {
        				sheetObject.SetCellValue(ir,"DelChk",1,0);
        				rowRemove(sheetObject, "");
        			}
        		}
        		setTotalAmount('S');
        		var flet_ctrt_no=formObject.flet_ctrt_no.value;
        		var csr_curr_cd=formObject.csr_curr_cd.value;
        		ComOpenPopup("ESM_FMS_0028.do?flet_ctrt_no="+flet_ctrt_no+"&csr_curr_cd="+csr_curr_cd, 900, 378, "setOwnersAccount", "1,0,1,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0028");
        		initType();
        		break;
        	case "btn_bodBor": // BOD/BOR Button
        		if(validateForm(sheetObject,formObject,IBSEARCH,'N') == false) return;
        		if(!preWorkCheck()) return; 
        		initCheckBox(sheetObject);
        		for (var ir=sheetObject.LastRow(); ir>=sheetObject.HeaderRows(); ir--) {
        			if(sheetObject.GetCellValue(ir,"pop_gb") == "OIL") {
        				sheetObject.SetCellValue(ir,"DelChk",1,0);
        				rowRemove(sheetObject, "");
        			}
        		}
        		setTotalAmount('S');
        		var flet_ctrt_no=formObject.flet_ctrt_no.value;
        		var csr_curr_cd=formObject.csr_curr_cd.value;
        		
        		//NYK Modify 2014.10.27
        		var flet_ctrt_tp_cd = formObject.param_flet_ctrt_tp_cd.value;
        		
        		//NYK Modify 2014.10.22
        		var param = "";
        			param +="flet_ctrt_no="+flet_ctrt_no;
        		    param +="&csr_curr_cd="+csr_curr_cd;
        		    param +="&apro_flg=";
        		    param +="&flet_ctrt_tp_cd="+flet_ctrt_tp_cd;
        		    param +="&call_slip_tp_cd="+gCallSlipTpCdPayment; // 비용에서 Call
        		
        		ComOpenPopup("ESM_FMS_0027.do?"+param, 900, 378, "setBodBor", "1,0,1,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0027");
        		//ComOpenPopup("ESM_FMS_0027.do?flet_ctrt_no="+flet_ctrt_no+"&csr_curr_cd="+csr_curr_cd+"&apro_flg=", 900, 378, "setBodBor", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0027");
        		initType();
        		break;
        	case "btn_rowAdd": // Row Add Button
        		if(validateForm(sheetObject,formObject,IBSEARCH,'N') == false) return;
        		if(!preWorkCheck()) return; 
        		var row=sheetObject.DataInsert(-1);
        		sheetObject.SetCellValue(row,"vndr_seq"		,formObject.ownr_cd.value,0);
        		sheetObject.SetCellValue(row,"ctr_cd"		,formObject.ap_ctr_cd.value,0);
        		sheetObject.SetCellValue(row,"slp_loc_cd"	,formObject.loc_cd.value,0);
        		sheetObject.SetCellValue(row,"slp_eff_dt"	,formObject.eff_dt.value,0);
        		sheetObject.SetCellValue(row,"flet_src_tp_cd","99",0);
        		sheetObject.SetCellEditable(row, "acct_cd",1);
        		//sheetObject.SetCellEditable(row, "ctr_cd",0);
        		sheetObject.SetCellEditable(row, "csr_amt",1);
        		sheetObject.SetCellEditable(row, "bunker_vvd",1);
        		sheetObject.SetCellEditable(row, "csr_desc",1);
        		var currCd=formObject.csr_curr_cd.value;
        		// -------------------------------------------------------
				//  In case Currency is KRW / JPY / PAB, checking to prevent inserting decimal point
				// -------------------------------------------------------
        		if(ComFmsCheckCurrencyYn(currCd)) {
        			sheetObject.InitCellProperty(row, "csr_amt",{ Type:"Int",Align:"Right",Format:"NullInteger"} );
        		}
        		
        		initType();
        		
        		//TI,TO에 따른 VVD 조회.
        		doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC03,"bunker_vvd", row);
        		break;
        	case "btn_rowDel": // Row Del Button
        		if(validateForm(sheetObject,formObject,IBSEARCH,'N') == false) return;
        		
        		if(checkBoxCheckYn(sheetObject, "DelChk")) {
            		rowRemove(sheetObject, "");
            	}
        		setTotalAmount('S');
        		break;
        	/*case "btn_retrieve": // Acct Management Button
        		doActionIBSheet(sheetObject,formObject,IBSEARCH);
        		initType();
        		break;
        	*/	
        	case "btn_new": // Acct Management Button
        		if(!initConfirm()) return;
        		clearAll();
        		break;
        	case "btn_save": // Acct Management Button
        		if(validateForm(sheetObject,formObject,IBSEARCH,'N') == false) return;
        		doActionIBSheet(sheetObject,formObject,IBSAVE);
        		break;
        	case "btn_hireStatement": // Acct Management Button
        		if(sheetObject.RowCount()> 0){
					var csr_no=formObject.csr_no.value;
					var vsl_eng_nm=formObject.vsl_eng_nm.value;
			 		//Only print SLP_FUNC_CD = 'P' or 'S' or 'T'
			 		/*if (   csr_no.substring(2,3) == 'P'
			 			|| csr_no.substring(2,3) == 'S'
			 			|| csr_no.substring(2,3) == 'T') {
			 			ComOpenPopup("ESM_FMS_0075.do?csr_no="+ csr_no+"&pgm_id=esm_fms_0021&vsl_eng_nm="+vsl_eng_nm+"", 750, 153, "sendMail", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0075");
			 		} else {
						ComShowCodeMessage("FMS01511");
						return;
			 		}*/
			 		ComOpenPopup("ESM_FMS_0075.do?csr_no="+ csr_no+"&pgm_id=esm_fms_0021&vsl_eng_nm="+vsl_eng_nm+"", 750, 153, "sendMail", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0075");
				} else {
					ComShowCodeMessage('FMS00015');
				}
        		break;
        	case "btn_taxEvidence": // Acct Management Button
        		if(validateForm(sheetObject,formObject,IBSEARCH,'N') == false) return;
        		setInitVatApply(sheetObject);
        		var v_evid_tp_cd=form.evid_tp_cd_val.value;
        		var tax_inv_yrmon=formObject.eff_dt.value;
        		ComOpenPopup("ESM_FMS_0029.do?tax_inv_yrmon="+tax_inv_yrmon+"&evid_tp_cd="+v_evid_tp_cd, 917, 562,"setTaxEvidence", "1,0,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0029");
        		break;
        	case "btn_slipInquiry": // Acct Management Button
        		ComOpenPopup("ESM_FMS_0041_1.do?popup=yes", 1024, 700, "setSlipInquiry", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0041_1");
        		break;
        	case "btn_print": // Acct Management Button
        		rdOpen(document.form);
        		break;
        	case "btn_vslpop": // Acct Management Button
        		ComOpenPopup("ESM_FMS_0022.do?pgmNo=ESM_FMS_0022", 520, 470,"setVslCd", "1,0,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0022");
        		break;
        	case "btn_ctrtpop": // Acct Management Button
        		if(formObject.vsl_cd.value == "") {
        			ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01231'));
        			return;
        		}
        		
        		clearAll("CTRT"); //NYK Modify 2014.10.21
        		
        		if(formObject.slp_tp[0].checked) {
        			ComOpenPopup("ESM_FMS_0023.do?vsl_cd=" + formObject.vsl_cd.value+"&typeFlag=" + "TI|OW", 520, 405,"setContractNo", "1,0,1,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0023");
        		} else if (formObject.slp_tp[1].checked){
        			ComOpenPopup("ESM_FMS_0023.do?vsl_cd=" + formObject.vsl_cd.value+"&typeFlag=" + "TI|TO|OW", 520, 405,"setContractNo", "1,0,1,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0023");
        		} else if (formObject.slp_tp[2].checked){
        			ComOpenPopup("ESM_FMS_0023.do?vsl_cd=" + formObject.vsl_cd.value+"&typeFlag=" + "TI|TO|OW", 520, 405,"setContractNo", "1,0,1,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0023");
        		}
        		break;
        	case "rqst_dt_cal": 
        		var cal=new ComCalendar();
        		cal.select(form.rqst_dt, 'yyyy-MM-dd');
        		break;
        	case "eff_dt_cal": 
        		var cal=new ComCalendar();
        		cal.select(form.eff_dt, 'yyyy-MM-dd');
        		break;
        	case "btn_totalCal": //Not Used.
        		if(validateForm(sheetObject,formObject,IBSEARCH,'N') == false) return;
        		if(!preWorkCheck()) return; 
        		if(sheetObject.RowCount()!= 0) {
        			setTotalAmount('S');
        		}
        		break;
        		
        		
        	case "btn_retrieve" : //2015.11.27 CSR No 검색
        		doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC04);
        		break;
        	case "btn_csr_no" : //2015.11.27 CSR No 검색
        		//ComSetObjValue(formObject.csr_no, "");
        		doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC04,"btn_csr_no");
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
 * initializing sheet 
 * implementing onLoad event handler in body tag 
 *  adding first-served functions after loading screen. 
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
    }
    initControl();
    sheet1_OnLoadFinish(sheet1);
    
    resizeSheet();        
}
/**
 * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
 * adding first-served functions after loading screen. 
 */
function sheet1_OnLoadFinish(sheetObj) { 
	sheetObj.SetWaitImageVisible(0);
	doActionIBSheet(sheetObj, document.form, IBROWSEARCH);
	doActionIBSheet(sheetObj, document.form, IBROWSEARCH , "evid_tp_cd");
    
    //NYK Modify 2014.10.14
    initDefaultDate();

    sheetObj.SetWaitImageVisible(1);
}
/**
 * setting sheet initial values and header <br>
 * adding case as numbers of counting sheets <br>
 * <br><b>Example :</b>
 * <pre>
 *     initSheet(sheetObj,1);
 * </pre>
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
 * @return N/A
 * @author 
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetObj.id) {
        case "sheet1":
            with(sheetObj){
	              var HeadTitle=" |Sel|Seq|Seq|Acct Nm|Acct Cd|Ownr Cd|Ctr Cd|City|Eff. Date|Slip Amount|VVD Code|Key Number|Description|Inv Seq|Flet Src Type Code|Inv Dtl Seq|Ownr Acct Slip Csr No|Flet Iss Type Code|Eff Dt|Exp Dt|VAT\nApply|PopGb|Vat Flag|SLP_TP_CD|SLP_FUNC_CD|SLP_OFC_CD|SLP_ISS_DT|SLP_SER_NO|SLP_SEQ_NO|Ctrt No|Bnk Seq|Key Flg|Tax Seq|Curr Cd|Auto Flg|Org Flet Ctrt No|Acct Item Seq";
	
	              SetConfig( { SearchMode:2, Page:20, FrozenCol:0} );
	
	              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ 
	                         {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                         {Type:"DummyCheck",Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"DelChk" },
		                     {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq_no" },
		                     {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"slp_seq_num",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
		                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"acct_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
		                     //{Type:"Popup",     Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"acct_nm",    	   	   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     //{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"acct_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6, AcceptKeys:"N"},
		                     {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"acct_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6, AcceptKeys:"N"},
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ctr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6, AcceptKeys:"N"},
		                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"slp_loc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		                     {Type:"Date",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"slp_eff_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"csr_amt",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bunker_vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10, AcceptKeys:"E|N" , InputCaseSensitive:1 },
		                     {Type:"Text",      Hidden:0, Width:175,  Align:"Left",    ColMerge:0,   SaveName:"key_number",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                     {Type:"Text",      Hidden:0, Width:284,  Align:"Left",    ColMerge:1,   SaveName:"csr_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:500 },
		                     {Type:"Text",      Hidden:1, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"inv_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"flet_src_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"inv_dtl_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"ownr_acct_slp_csr_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"flet_iss_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"CheckBox",  Hidden:1, Width:38,   Align:"Center",  ColMerge:0,   SaveName:"vat_apply",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
		                     {Type:"Text",      Hidden:1, Width:38,   Align:"Center",  ColMerge:0,   SaveName:"pop_gb",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:38,   Align:"Center",  ColMerge:0,   SaveName:"vat_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"ap_slp_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"ap_slp_func_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"ap_slp_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"ap_slp_iss_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"ap_slp_ser_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"ap_slp_seq_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"flet_ctrt_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"bnk_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"key_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"tax_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"auto_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"org_flet_ctrt_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"acct_itm_seq",   	   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, ];
	               
	              InitColumns(cols);
	              SetSheetHeight(250);
	              SetDataLinkMouse("acct_cd",1);
	              SetShowButtonImage(2);
	              SetEditable(1);
	            }
            break;
        case "sheet2":      //sheet2
            with(sheetObj){
            	  var prefix="tax_";
	              var HeadTitle="|Seq|Sel|tax_inv_yrmon|ofc_cd|tax_iss_cd|tax_vat_tp_cd|tax_naid_flg|tax_div_cd|fa_flg|tax_pl_cd|tax_nsl_flg|spl_rgst_no|ownr_nm|co_nm|bzct_nm|bztp_nm|spl_addr|iss_dt|spl_amt|tax_amt|total_amt|SLP_TP_CD|SLP_FUNC_CD|SLP_OFC_CD|SLP_ISS_DT|SLP_SER_NO|CRE_USR_ID|UPD_USR_ID";
	              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
	                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
	                     {Type:"Date",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tax_inv_yrmon", KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tax_iss_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tax_vat_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:161,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tax_naid_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:161,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tax_div_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"fa_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:99,   Align:"Right",   ColMerge:0,   SaveName:prefix+"tax_pl_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tax_nsl_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"spl_rgst_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:161,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ownr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:161,  Align:"Center",  ColMerge:0,   SaveName:prefix+"co_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bzct_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bztp_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"spl_addr",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	                     {Type:"Date",      Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"iss_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	                     {Type:"Float",     Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"spl_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:0 },
	                     {Type:"Float",     Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tax_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:0 },
	                     {Type:"Float",     Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"total_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:prefix+"slp_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:prefix+"slp_func_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:prefix+"slp_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"slp_iss_dt",    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:prefix+"slp_ser_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"cre_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"upd_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	               
	              InitColumns(cols);
	              SetSheetHeight(120);
	              SetEditable(1);
                }
            break;
        case "sheet3":      //sheet3
            with(sheetObj){
                var prefix="txd_";
           
	            var HeadTitle1=" |순번|Sel|품명|공급가액|세액|합계";
	            var headCount=ComCountHeadTitle(HeadTitle1);
	            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Type:"Status",    Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tax_dtl_ser_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"DelChk" },
	             {Type:"Text",      Hidden:0,  Width:440,  Align:"Center",  ColMerge:1,   SaveName:prefix+"itm_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"spl_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"tax_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"total_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 } ];
	             
	            InitColumns(cols);
	            SetSheetHeight(120);
	            SetEditable(1);
            }
            break;
        case "sheet4":      //sheet4
            with(sheetObj){
        		 var prefix="mst_";
	             var HeadTitle1=" |Seq|Sel|slp_ofc_cd|ap_ctr_cd|loc_cd|chk_acct_cd|chk_ctr_cd|chk_bunker_vvd|pre_work_flag|evid_tp_cd_val|usd_locl_xch_rt|flet_ctrt_no|vsl_cd|vsl_eng_nm|flet_ctrt_tp_cd|csr_curr_cd|slp_iss_dt|usr_nm|csr_no|slp_desc|slp_tp|evid_tp_cd|rqst_dt|eff_dt|ownr_cd|ppay_hir_no|vat_flg|cre_usr_id|upd_usr_id|dr_amt|diff_amt|balance_amt";
	             var headCount=ComCountHeadTitle(HeadTitle1);
	             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	             InitHeaders(headers, info);
	             var cols = [ {Type:"Status",    Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"DelChk" },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"slp_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"ap_ctr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"loc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"chk_acct_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"chk_ctr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"chk_bunker_vvd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"pre_work_flag",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"evid_tp_cd_val",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"usd_locl_xch_rt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"flet_ctrt_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"vsl_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"vsl_eng_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"flet_ctrt_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"csr_curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Date",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"slp_iss_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"usr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"csr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"slp_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"slp_tp",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"evid_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Date",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"rqst_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Date",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"eff_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"ownr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"ppay_hir_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"vat_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"cre_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"upd_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"dr_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"diff_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"balance_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
	              
	             InitColumns(cols);
	             SetSheetHeight(120);
	             SetEditable(1);
         }
        break;
    }
}
/**
 * Handling IBSheet's process(Retrieve, Save) <br>
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * @param {form}    formObj Mandatory html form object
 * @param {int}     sAction mandatory,Constant Variable
 **/ 
function doActionIBSheet(sheetObj,formObj,sAction,col,row) {
	sheetObj.ShowDebugMsg(false);
    switch(sAction) {
			case IBSEARCH:      
				if(!validateForm(sheetObj,formObj,sAction))  return true;
  				formObj.f_cmd.value=SEARCH;
  				sheetObj.DoSearch("ESM_FMS_0021GS.do", FormQueryString(formObj) );
            	
			case IBSAVE:        
				if(!validateForm(sheetObj,formObj,sAction))  return true;
				if(sheetObj.RowCount()== 0) {
		 			ComShowCodeMessage("FMS00007");
		 			return;
		 		}
				//Checking Tax Evidence
				//NYK Modify 2014.11.11 Tax Not Used.
				/*if(   formObj.evid_tp_cd_val.value == "1"
				   || formObj.evid_tp_cd_val.value == "4") {
					if(sheetObjects[2].RowCount()== 0) {
						ComShowCodeMessage("FMS01458");
						return;
					}
				}*/
				formObj.f_cmd.value=MULTI;
				//var arrSheets = new Array(sheetObjects[0], sheetObjects[1], sheetObjects[2], sheetObjects[3]);
				//var sParam = ComGetSaveString(arrSheets);
				//var sParam = sheetObj.GetSaveString(); 
				//if (sheetObj.IsDataModified && sParam == "") {
					//return; 
				//}
				if(!saveConfirm()) return;
				var arrSheet=new Array(sheetObjects[0], sheetObjects[1]);
				var param=ComGetSaveString(arrSheet);
				if (sheetObj.IsDataModified()&& param == "") {
					return; 
				}
				//NYK Modify 2014.11.11 Tax Not Used.
				/*
				// Creating Tax Invoice 
				var evid_tp_cd=form.evid_tp_cd_val.value;
				//var tax_pl_cd = sheetObjects[1].RowCount;
				var vatCnt=sheetObj.CheckedRows("vat_apply");
				var taxCnt=sheetObjects[2].RowCount();
				if(taxCnt > 0 && evid_tp_cd == "1") {
					if(formObj.csr_curr_cd.value == "KRW") {
						if(sheetObjects[1].GetCellValue(1,"tax_tax_pl_cd") != "1") {
							setMakeTaxEvidence(sheetObj);
						}
					} else {
						if(vatCnt == taxCnt) {
							if(sheetObjects[1].GetCellValue(1,"tax_tax_pl_cd") != "1") {
								setMakeTaxEvidence(sheetObj);
							}
						} else {
							if(sheetObjects[1].GetCellValue(1,"tax_tax_pl_cd") != "1") {
								ComShowCodeMessage('FMS01457',taxCnt);
								return;
							}
						}
					}
				}*/
				// Total Amount
				setTotalAmount('S');
				// Checking Balance (value > 0)
				if(!checkBalance(sheetObj)) return;
				// Creating Slip Master Data
				setMakeSlipMstData();
				var arrSheets=new Array(sheetObjects[0], sheetObjects[1], sheetObjects[2], sheetObjects[3]);
				var sParam=ComGetSaveString(arrSheets);
				if (sheetObj.IsDataModified()&& sParam == "") {
					return; 
				}
				var aryPrefix=new Array("", "tax_", "txd_", "mst_");
				sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
	       		var sXml=sheetObj.GetSaveData("ESM_FMS_0021GS.do", sParam);
	       		var arrXml=sXml.split("|$$|");
	       		if (arrXml.length > 0) {
	       			//sheetObj.InitCellProperty(0, "seq_no", dtData); 
	       			sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
	       			//sheetObj.LoadSaveXml(arrXml[0]);
	       		}
            	break;
			case IBROWSEARCH:   
            	if(col == "csr_curr_cd") {
            		sheetObj.SetWaitImageVisible(0);
	        		formObj.f_cmd.value=SEARCH01;
 	        		var sXml=sheetObj.GetSearchData("ESM_FMS_0076GS.do" , FormQueryString(formObj)+"&curr_cd="+formObj.csr_curr_cd.value);
		   			var currCd=ComGetEtcData(sXml, "currCd");
		   			if(typeof currCd == "undefined" || currCd == "") {
		   				formObj.csr_curr_cd.value="";
						ComAlertFocus(formObj.csr_curr_cd, ComGetMsg("FMS01142"));
		   			} else {
		   				var currCd=formObj.csr_curr_cd.value;
		   				for(var ir=1; ir<=sheetObj.LastRow(); ir++) {
		   					if(sheetObj.GetCellValue(ir, "flet_src_tp_cd") == "99") {
		   						// -------------------------------------------------------
		   						// In case Currency is KRW / JPY / PAB, checking to prevent inserting decimal point
		   						// -------------------------------------------------------
	    		   				if(ComFmsCheckCurrencyYn(currCd)) {
	    		        			sheetObj.InitCellProperty(ir, "csr_amt",{ Type:"Int",Align:"Right",Format:"NullInteger"} );
	    		        		} else {
	    		        			sheetObj.InitCellProperty(ir, "csr_amt",{ Type:"Float",Align:"Right",Format:"NullFloat",PointCount:2} );
	    		        		}
		   					}
		   				}
		   			}
		   			sheetObj.SetWaitImageVisible(1);
				} else if(col == "vsl_cd") {
					sheetObj.SetWaitImageVisible(0);
					formObj.f_cmd.value=SEARCH01;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		   			var vslEngNm=ComGetEtcData(sXml, "vslEngNm");
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
		   				formObj.vsl_eng_nm.value=vslEngNm;
		   				
		   				initDefaultContractNo(); //NYK Modify 2014.10.21
					} else {
						formObj.vsl_cd.value="";
						formObj.vsl_eng_nm.value="";
						ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS01056"));
						return;
					}
		   			sheetObj.SetWaitImageVisible(1);
	    		} else if (col == "flet_ctrt_no") {
	    			sheetObj.SetWaitImageVisible(0);
	    			var f_query = "";					
					f_query += "f_cmd=" + SEARCH02; 
					f_query += "&flet_ctrt_no="+formObj.flet_ctrt_no.value;	 			
					f_query += "&call_slip_tp_cd="+gCallSlipTpCdPayment; //수입,비용 전표구분.
					
					var sXml = sheetObj.GetSearchData("FMS_COMGS.do",f_query);
					
					var fletCtrtTpCd=ComGetEtcData(sXml, "fletCtrtTpCd");
					var fletCtrtTpNm=ComGetEtcData(sXml, "fletCtrtTpNm");
					var vndrSeq=ComGetEtcData(sXml, "vndrSeq");
					var vndrNm=ComGetEtcData(sXml, "vndrNm");
					if(typeof fletCtrtTpNm != "undefined" && fletCtrtTpNm != "" ) {
						formObj.flet_ctrt_tp_cd.value=fletCtrtTpNm;
		   				formObj.param_flet_ctrt_tp_cd.value=fletCtrtTpCd;
		   				if(vndrSeq == "") {
		   					formObj.ownr_cd.value="";
		   					formObj.ownr_nm.value="";
		   				} else {
		   					formObj.ownr_cd.value=vndrSeq;
		   					formObj.ownr_nm.value=vndrNm;
		   				}
		   				
		   				//NYK Modify 2014.10.22
		   				initPrePaymentButton();
					}
	    			/*
					formObj.f_cmd.value=SEARCH;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0035GS.do" , FormQueryString(formObj));
		   			var fletCtrtTpNm=ComGetEtcData(sXml, "fletCtrtTpNm");
		   			var fletCtrtTpCd=ComGetEtcData(sXml, "fletCtrtTpCd");
		   			if(typeof fletCtrtTpNm != "undefined" && fletCtrtTpNm != "" ) {
		   				formObj.flet_ctrt_tp_cd.value=fletCtrtTpNm;
		   				formObj.param_flet_ctrt_tp_cd.value=fletCtrtTpCd;
		   				if(ComGetEtcData(sXml, "vndrNm") == "") {
		   					formObj.ownr_cd.value="";
		   					formObj.ownr_nm.value="";
		   				} else {
		   					formObj.ownr_cd.value=ComGetEtcData(sXml, "vndrSeq");
		   					formObj.ownr_nm.value=ComGetEtcData(sXml, "vndrNm");
		   				}
		   				
		   				//NYK Modify 2014.10.22
		   				initPrePaymentButton();
		   				
					}*/
		   			sheetObj.SetWaitImageVisible(1);
	    		} else if (col == "eff_dt") {
	    			sheetObj.SetWaitImageVisible(0);
					formObj.f_cmd.value=SEARCH09;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , ComReplaceStr(FormQueryString(formObj),"-",""));
 		   			
 		   			var closFlg=ComGetEtcData(sXml, "clos_yn");
 		   			var effDt=ComGetEtcData(sXml, "eff_dt");
 		   			var oldEffDt=ComGetUnMaskedValue(formObj.eff_dt, "ymd");
		   			var usdLoclXchRt=ComGetEtcData(sXml, "usdLoclXchRt");
 				
		   			if(typeof usdLoclXchRt != "undefined" && usdLoclXchRt != "" ) {
		   				formObj.usd_locl_xch_rt.value=usdLoclXchRt;
					}
		   			
		   			if (closFlg=="C"){
						//closed, and open item not exists
						if (ComTrim(effDt) == ""){
							ComShowCodeMessage("FMS20009", oldEffDt.substring(0,6));
							formObj.eff_dt.value="";
							return;					
						}
						//closed, and user confirmed, setting next month 1 day
						if (ComShowCodeConfirm('FMS20010',oldEffDt, effDt)){
							formObj.eff_dt.value=effDt;
							
							//Sheet Set.
							setSheetSlpEffDtChange(sheetObj);
    						
						}else{
							formObj.eff_dt.value="";
						}
					//before closing month, and before closing previous month
					}else if (closFlg=="X"){
						//Two or more un-closed month exist ! Do you want ignore it 
						//if (!ComShowCodeConfirm("FMS20011")){
						//	formObj.eff_dt.value="";
						//  formObj.eff_dt.focus();
						//}
						
						//Sheet Set.
						setSheetSlpEffDtChange(sheetObj);
						
					//in case of not existing data
					}else if (closFlg=="E"){
						ComShowCodeMessage("FMS20012", oldEffDt.substring(0,6));
						formObj.eff_dt.value="";
					}else{						
						//Sheet Set.
						setSheetSlpEffDtChange(sheetObj);
					}    		   			
		   			
		   			sheetObj.SetWaitImageVisible(1);
	    		} else if (col == "acct_cd") {
	    			sheetObj.SetWaitImageVisible(0);
	    			var curr_cd=formObj.csr_curr_cd.value;
	    			if(curr_cd != "KRW") {
	    				if(formObj.chk_acct_cd.value == "111811") {
	    					ComShowCodeMessage('FMS01475');
	    					sheetObj.SetCellValue(row, "acct_cd","",0);
		   					sheetObj.SelectCell(row, "acct_cd");
		   					return false;
	    				}
	    			}
					formObj.f_cmd.value=SEARCH01;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0069GS.do" , FormQueryString(formObj)+"&acct_cd="+formObj.chk_acct_cd.value+"&pnd_tgt_flg=N");
		   			var cdName=ComGetEtcData(sXml, "acctNm");
		   			//var prefix = "inv_";
		   			if(typeof cdName == "undefined" || cdName == "" ) {
		   				ComShowCodeMessage('FMS01336');
	   					sheetObj.SetCellValue(row, "acct_cd","",0);
	   					sheetObj.SelectCell(row, "acct_cd");
					} else {
						var acct_cd=sheetObj.GetCellValue(row, "acct_cd");
						/*2015.10.14 NYK 에서는 Account Level별 VVD 체크를 하지 않음.
						// VVD Level Check by Account
						if(checkAcctCdVvdLevelMdt(sheetObj, row)) {
    						sheetObj.SetCellEditable(row, "bunker_vvd",0);
    						sheetObj.SetCellValue(row,"bunker_vvd","",0);
    					} else {
    						if(checkAcctCdVvdLevel(sheetObj, row)) {
	    						sheetObj.SetCellEditable(row, "bunker_vvd",1);
	    						sheetObj.SetCellValue(row,"bunker_vvd","",0);
    						} else {
    							sheetObj.SetCellEditable(row, "bunker_vvd",0);
	    						sheetObj.SetCellValue(row,"bunker_vvd","",0);
    						}
    					}
    					*/
						// Checking Key Number 
						if(checkKeyNumber(sheetObj, acct_cd)) {
							sheetObj.SetCellEditable(row, "key_number",1);
							sheetObj.SetCellValue(row,"key_flg","Y",0);
						} else {
							sheetObj.SetCellEditable(row, "key_number",0);
							sheetObj.SetCellValue(row,"key_flg","",0);
						}
					}
					sheetObj.SetWaitImageVisible(1);
	    		} else if (col == "ctr_cd") {
	    			sheetObj.SetWaitImageVisible(0);
					formObj.f_cmd.value=SEARCH01;
 		   			
					var sXml=sheetObj.GetSearchData("ESM_FMS_0021GS.do" , FormQueryString(formObj)+"&acct_cd="+formObj.chk_acct_cd.value);
		   			
					var slpLocCd=ComGetEtcData(sXml, "slpLocCd");

		   			if(typeof slpLocCd == "undefined" || slpLocCd == "" ) {
		   				ComShowCodeMessage('FMS01441');
	   					sheetObj.SetCellValue(row, "slp_loc_cd","",0);
	   					sheetObj.SetCellValue(row, "ctr_cd","",0);
	   					sheetObj.SelectCell(row, "ctr_cd");
					} else {
						sheetObj.SetCellValue(row, "slp_loc_cd",slpLocCd,0);
					}
		   			
		   			sheetObj.SetWaitImageVisible(1);
	    		} else if (col == "bunker_vvd") {
	    			sheetObj.SetWaitImageVisible(0);
					//formObj.f_cmd.value=SEARCH13;
					//var acct_cd="";
					/* 2015.10.14 NYK 에서는 Account Level 별 VVD 를 체크 하지 않음.
					// VVD Level Check by Account
					if(checkAcctCdVvdLevel(sheetObj, row)) {
						acct_cd=formObj.chk_acct_cd.value;
					}
					*/
					//2015.11.19 NYK Not Used.
					/*
					acct_cd=formObj.chk_acct_cd.value;
					
					var vvd_cd=sheetObj.GetCellValue(row, "bunker_vvd");
 		   			
					var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , FormQueryString(formObj)+"&acct_cd="+acct_cd+"&vvd_cd="+vvd_cd);
		   			
		   			var bunkerVvd=ComGetEtcData(sXml, "vslCd");

   					if(acct_cd != "") {
   						if(typeof bunkerVvd == "undefined" || bunkerVvd == "" ) {
    		   				ComShowCodeMessage('FMS01443');
		   					sheetObj.SetCellValue(row, "bunker_vvd","",0);
		   					sheetObj.SelectCell(row, "bunker_vvd");
    					} else {
	   						if(parseInt(bunkerVvd) < 2) {
	   							ComShowCodeMessage('FMS01473');
	   							//sheetObj.CellEditable(row, "bunker_vvd") = false;
			   					sheetObj.SetCellValue(row, "bunker_vvd","",0);
			   					sheetObj.SelectCell(row, "bunker_vvd");
	   						}
    					}
   					} else {
    		   			if(typeof bunkerVvd == "undefined" || bunkerVvd == "" ) {
    		   				ComShowCodeMessage('FMS01443');
		   					sheetObj.SetCellValue(row, "bunker_vvd","",0);
		   					sheetObj.SelectCell(row, "bunker_vvd");
    					}
   					}*/
   					sheetObj.SetWaitImageVisible(1);
	        	} else if(col == "evid_tp_cd"){
	        		CoFmsGetTaxCombo('FORM', document.form, sheetObj, gEvidenceClassTaxCode, 'evid_tp_cd_combo', 'evid_tp_nm_combo');
	                setEvidenceType();
	        	} else {
	        		sheetObj.SetWaitImageVisible(0);
	        		formObj.f_cmd.value=SEARCH10;
 		   			
	        		var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		   			
	        		var apCtrCd=ComGetEtcData(sXml, "apCtrCd");
		   			var locCd=ComGetEtcData(sXml, "locCd");
		   			
		   			// Center Code Setting
		   			if(typeof apCtrCd != "undefined" && apCtrCd != "" ) {
		   				formObj.ap_ctr_cd.value=apCtrCd;
					} 
		   			// City Code Setting
		   			if(typeof locCd != "undefined" && locCd != "" ) {
						formObj.loc_cd.value=locCd;
					}
		   			sheetObj.SetWaitImageVisible(1);
	        	}
			case IBINSERT:      
            	break;
            	
			case IBSEARCH_ASYNC01: //NYK Modify 2014.10.14
        		sheetObj.SetWaitImageVisible(0);
        		var f_query = "";					
				f_query += "f_cmd=" + SEARCH; 
				f_query += "&csr_type="+formObj.csr_type.value;	 			
				f_query += "&slp_ofc_cd="+formObj.slp_ofc_cd.value; 
				
				//var sXml = sheetObj.GetSearchXml("FMS_COMGS.do","" , f_query, true);
				var sXml = sheetObj.GetSearchData("FMS_COMGS.do",f_query);
				
	   			var varRqstDt = ComGetEtcData(sXml, "rqst_dt");
	   			var varEffDt = ComGetEtcData(sXml, "eff_dt");

	   			if(typeof varRqstDt != "undefined" && varRqstDt != "" ) {
	   				formObj.rqst_dt.value = ComGetMaskedValue(varRqstDt,"ymd");
				} 
	   			
	   			if(typeof varEffDt != "undefined" && varEffDt != "" ) {
					formObj.eff_dt.value = ComGetMaskedValue(varEffDt,"ymd");
				}
	   			sheetObj.SetWaitImageVisible(1);
				
				eff_dt_change();
				break;
            	
			case IBSEARCH_ASYNC02: //NYK Modify 2014.10.21				
				if(formObj.vsl_cd.value == "") return;				
				var f_query = "";					
				f_query += "f_cmd=" + SEARCH01; 
				f_query += "&vsl_cd="+formObj.vsl_cd.value;	 			
				f_query += "&type_flag="+gFletCtrtTpCdAll; 
				
				var sXml = sheetObj.GetSearchData("FMS_COMGS.do",f_query);

	   			var varFletCtrtNo = ComGetEtcData(sXml, "flet_ctrt_no");
	   			
	   			if(typeof varFletCtrtNo != "undefined" && varFletCtrtNo != "" ) {
					formObj.flet_ctrt_no.value = varFletCtrtNo;
				}else{
					ComShowCodeMessage("FMS20001","Agreement");
					clearAll();
					return;
				}
				if(formObj.flet_ctrt_no.value != ""){
					contract_no_change();
				}
				break;
            	
			case IBSEARCH_ASYNC03: //NYK Modify 2015.09.02				
				var f_query = "";					
				f_query += "f_cmd=" + SEARCH04; 
				f_query += "&flet_ctrt_no="+formObj.flet_ctrt_no.value;	 			
				f_query += "&eff_dt="+formObj.eff_dt.value; 
				
				var sXml = sheetObj.GetSearchData("FMS_COMGS.do",f_query);

	   			var vvds = ComGetEtcData(sXml, "vvds");
	   			
	   			if(typeof vvds != "undefined" && vvds != "" ) {
	   				var arrVvdCd=vvds.split("|");
		        	if(arrVvdCd.length > 0){
		          		sheetObj.SetCellValue(row, "bunker_vvd", arrVvdCd[0], 0);
		          	}
				}
				break;
            	
			case IBSEARCH_ASYNC04: //NYK Modify 2015.11.27				
				//아래 ValidateForm 에서 팝업을 호출 하도록 함.
				if(!validateForm(sheetObj,formObj,sAction, "N" , col))  return true;
  				
				formObj.f_cmd.value=SEARCH03;
				var sXml=sheetObj.GetSearchData("ESM_FMS_0021GS.do" , FormQueryString(formObj));

        		var slpDesc		=ComGetEtcData(sXml, "slpDesc");
	   			var slpTp		=ComGetEtcData(sXml, "slpTp");
	   			var evidTpCd	=ComGetEtcData(sXml, "evidTpCd");
	   			var rqstDt		=ComGetEtcData(sXml, "rqstDt");
	   			var effDt		=ComGetEtcData(sXml, "effDt");
	   			var vndrSeq		=ComGetEtcData(sXml, "vndrSeq");
	   			var vndrNm		=ComGetEtcData(sXml, "vndrNm");
	   			var ppayHirNo	=ComGetEtcData(sXml, "ppayHirNo");
	   			var csrCurrCd	=ComGetEtcData(sXml, "csrCurrCd");
	   			
				var arrXml=sXml.split("|$$|");
	       		if (arrXml.length > 0) { 
	       			ComSetObjValue(formObj.slp_desc, slpDesc);
	       			setEvidenceType();
	       			ComSetObjValue(formObj.rqst_dt, ComGetMaskedValue(rqstDt,"ymd"));
	       			ComSetObjValue(formObj.eff_dt, ComGetMaskedValue(effDt,"ymd"));
	       			ComSetObjValue(formObj.ownr_cd, vndrSeq);
	       			ComSetObjValue(formObj.ownr_nm, vndrNm);
	       			ComSetObjValue(formObj.ppay_hir_no, ppayHirNo);
	       			ComSetObjValue(formObj.csr_curr_cd, csrCurrCd);
	       			
	       			if(slpTp == formObj.slp_tp[0].value){
	       				formObj.slp_tp[0].checked=true;
	       			}else if(slpTp == formObj.slp_tp[1].value){
	       				formObj.slp_tp[1].checked=true;
	       			}else if(slpTp == formObj.slp_tp[2].value){
	       				formObj.slp_tp[2].checked=true;
	       			}
	       			
	       			sheetObj.RemoveAll();
	       			
	       			sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
	       			
	       			setTotalAmount("S");
	       		}
  				
				break;
    }
}
/**
 * Loading Event of HTML_Control existing on page dynamically <br>
 * Calling the function from {@link #loadPage} to initialize IBSheet Object <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence of sheetObjects array
 **/
function initControl() {
	DATE_SEPARATOR="-";
	axon_event.addListener  ('click'   , 'slp_tp_click'   	 , 'slp_tp');		// Getting Name information after inserting Vessel Code
    axon_event.addListenerForm  ('blur'			   , 'obj_deactivate', form); 	//- form Code Handling to OnBeforeDeactivate(blur) Event of All Controls

    doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH);
    //CoFmsGetCombo('FORM', document.form, sheetObjects[0], 'CD01745', 'evid_tp_cd', 'evid_tp_nm');
    setCsrDate();
	//Disable  Payments Slip Print Button
	ComBtnDisable("btn_print");
	//Disable Payments Slip HireStatement Button
	ComBtnDisable("btn_hireStatement");
	//Disable Payments Slip TaxEvidence Button
	ComBtnDisable("btn_taxEvidence");
}
//Axon Event Handling 2. Event Handling Function --- start

 /**
 * Checking Validation in onblur Event of HTML Control <br>
 **/
function obj_deactivate(){
	switch(ComGetEvent("name")){
    	case "rqst_dt": 
    	case "eff_dt": 
    		ComChkObjValid(ComGetEvent());
    		if (ComGetEvent("name") == 'eff_dt') {
    			if(pre_eff_dt == form.eff_dt.value) return;
     	    	eff_dt_change();
     	    } else if(ComGetEvent("name") == 'rqst_dt') {
     	    	var rqstDt = form.rqst_dt.value;
     	    	var slpIssDt = form.slp_iss_dt.value;
     	    	if(parseInt(slpIssDt.trimAll('-')) < parseInt(slpIssDt.trimAll('-'))) {
     	    		form.rqst_dt.value="";
     	    		ComAlertFocus(form.rqst_dt, ComGetMsg("FMS01438"));
     	    		return;
     	    	}
     	    }
			break;
	}
}
/**
 * Removing Mask Separator in onfocus Event of HTML Control <br>
 **/
function obj_activate(){
	ComClearSeparator(ComGetEvent());
}
/**
 * Getting relevant Name when Changing VslCd <br>
 **/
function vsl_cd_change() {
	form.vsl_eng_nm.value="";
	form.flet_ctrt_no.value="";
 	if (form.vsl_cd.value != "" && form.vsl_cd.value.trim().length == 4) {
 		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'vsl_cd');
 	} else {
 		form.vsl_cd.value="";
 		ComAlertFocus(form.vsl_cd, ComGetMsg("FMS01231"));
 	}
}
/**
  *  Decide existing of Currency Code value in IBSheet insert value <br>
  * @return none
  **/
 function csr_curr_cd_change() {
 	if(form.csr_curr_cd.value.trim().length == 3) {
		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'csr_curr_cd');
 	} else {
 		if(form.csr_curr_cd.value != "") {
 			form.csr_curr_cd.value="";
 			ComAlertFocus(form.csr_curr_cd, ComGetMsg("FMS01077"));
 		}
 	}
}
 
 //NYK Modify 2014.10.14
 function initDefaultDate(){
     doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);    	
 }
 
/**
 * Checking when changing Effective Date <br>
 **/
function eff_dt_change() {
	if (form.eff_dt.value != "" && ComIsDate(form.eff_dt.value)) {
		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'eff_dt');
  	}else{
  		ComAlertFocus(form.eff_dt, ComGetMsg("FMS01565"));
  	}
}
/**
 * Control Prepayments Button when selecting Slip Type <br>
 * @return none
 **/
function slp_tp_click() {
	//Disable Payments Slip TaxEvidence Button
	ComBtnDisable("btn_taxEvidence");
	if(form.slp_tp[0].checked) {
		//sheetObjects[0].RemoveAll();
		//form.evid_tp_cd.selectedIndex = 2;
		if(   form.flet_ctrt_no.value != ""
		   && form.flet_ctrt_no.value.substring(4,6) == 'TO') {
    		setEvidenceType();
    		clearAll();
		} else {
			setEvidenceType();
    		//Enable Payments Slip Prepayments Button 
    		ComBtnEnable("btn_prepayments");
    		//Setting Total Amount
    		setTotalAmount();
		}
	} else if (form.slp_tp[1].checked){
		form.pre_work_flag.value == "";
		//form.evid_tp_cd.selectedIndex = 2;
		setEvidenceType();
		//sheetObjects[0].RemoveAll();
		//Disable Payments Slip Prepayments Button 
		ComBtnDisable("btn_prepayments");
		//Setting Total Amount
		setTotalAmount();
	} else if (form.slp_tp[2].checked){
		form.pre_work_flag.value == "";
		//form.evid_tp_cd.selectedIndex = 2;
		setEvidenceType();
		//sheetObjects[0].RemoveAll();
		//Disable Payments Slip Prepayments Button
		ComBtnDisable("btn_prepayments");
		//Setting Total Amount
		setTotalAmount();
	}
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	form.csr_curr_cd.readOnly=false;
	//NYK Modify 2014.11.11
	//form.evid_tp_cd.disabled=false;
}
/**
 * Setting Current Date into CSR Date
 */
function setCsrDate() {
     document.form.slp_iss_dt.value = ComFmsCurrentDate();
}
//Axon Event Handling 2. Event Handling Function --- end
/**
  * Insert Part of Vessel Code<br>
  * @param {arry} aryPopupData
  */
function setVslCd(aryPopupData){
	form.vsl_cd.value=aryPopupData[0][2];
	form.vsl_eng_nm.value=aryPopupData[0][3];
	form.flet_ctrt_no.value="";
	
	//NYK Modify 2014.10.21
	if(form.vsl_cd.value != ""){
		vsl_cd_change();
	}
}
/**
 * Insert Part of Contract No<br>
 * @param {arry} aryPopupData
 */
function setContractNo(aryPopupData){
	form.flet_ctrt_no.value=aryPopupData[0][3];
	contract_no_change();
}
/**
 * Insert Part of Prepayments<br>
 * @param {arry} aryPopupData
 */
function setPrepayments(aryPopupData) {
	// FLAG Value to check whether Prepayments data is selected in case of P Slip
	form.pre_work_flag.value="1";
	var row=sheetObjects[0].DataInsert(-1);
	form.ppay_hir_no.value=aryPopupData[0].ppay_hir_no;
	sheetObjects[0].SetCellEditable(row, "DelChk",0);
	sheetObjects[0].SetCellValue(row,"acct_cd","111431",0);
	sheetObjects[0].SetCellValue(row,"ctr_cd",aryPopupData[0].ctr_cd,0);
	sheetObjects[0].SetCellValue(row,"slp_loc_cd",aryPopupData[0].slp_loc_cd,0);
	sheetObjects[0].SetCellValue(row,"vndr_seq",form.ownr_cd.value,0);
	sheetObjects[0].SetCellValue(row,"slp_eff_dt",form.eff_dt.value,0);
	sheetObjects[0].SetCellValue(row,"csr_amt",aryPopupData[0].inv_amt_sum,0);
	sheetObjects[0].SetCellValue(row,"csr_desc",aryPopupData[0].acct_desc,0);
	//sheetObjects[0].CellValue2(row,"flet_ctrt_no") = form.flet_ctrt_no.value;
	sheetObjects[0].SetCellValue(row,"flet_ctrt_no",aryPopupData[0].flet_ctrt_no,0);
	sheetObjects[0].SetCellValue(row,"inv_seq",aryPopupData[0].inv_seq,0);
	sheetObjects[0].SetCellValue(row,"inv_dtl_seq",aryPopupData[0].inv_dtl_seq,0);
	sheetObjects[0].SetCellValue(row,"flet_src_tp_cd",aryPopupData[0].flet_src_tp_cd,0);
	sheetObjects[0].SetCellValue(row,"flet_iss_tp_cd",aryPopupData[0].flet_iss_tp_cd,0);
	sheetObjects[0].SetCellValue(row,"eff_dt",aryPopupData[0].eff_dt,0);
	sheetObjects[0].SetCellValue(row,"exp_dt",aryPopupData[0].exp_dt,0);
	sheetObjects[0].SetCellValue(row,"curr_cd",form.csr_curr_cd.value,0);
	//sheetObjects[0].SetCellEditable(row, "acct_cd",0);
	initCellPropertyAndEdit(sheetObjects[0], row, "acct_cd");
	setTotalAmount('S');
	//Disable Payments Slip Prepayments Button 
	ComBtnDisable("btn_prepayments");
	initType();
}
/**
 * Setting data retrieved in Charterers Account PopUp
 * @param {arry} aryPopupData
 */
function setCharterersExp(aryPopupData) {
	//sheetObjects[0].RemoveAll();
	for(var i=0; i<aryPopupData.length; i++) {
		var charterExpData=aryPopupData[i];
		var row=sheetObjects[0].DataInsert(-1);
		sheetObjects[0].SetCellValue(row,"acct_nm",charterExpData.acct_nm,0);
		sheetObjects[0].SetCellValue(row,"acct_cd",charterExpData.acct_cd,0);
		sheetObjects[0].SetCellValue(row,"vndr_seq",form.ownr_cd.value,0);
		sheetObjects[0].SetCellValue(row,"ctr_cd",charterExpData.ctr_cd,0);
		sheetObjects[0].SetCellValue(row,"slp_loc_cd",charterExpData.slp_loc_cd,0);
		sheetObjects[0].SetCellValue(row,"slp_eff_dt",form.eff_dt.value,0);
		sheetObjects[0].SetCellValue(row,"curr_cd",charterExpData.curr_cd,0);
		if(charterExpData.chtr_pay_rcv_cd == "Charterer") {
			sheetObjects[0].SetCellValue(row,"csr_amt",charterExpData.inv_amt,0);
		} else {
			sheetObjects[0].SetCellValue(row,"csr_amt",charterExpData.inv_amt * -1,0);
		}
		sheetObjects[0].SetCellValue(row,"bunker_vvd",charterExpData.vvd_bunker,0);
		sheetObjects[0].SetCellValue(row,"csr_desc",charterExpData.inv_desc,0);
		sheetObjects[0].SetCellValue(row,"flet_iss_tp_cd",charterExpData.flet_iss_tp_cd,0);
		sheetObjects[0].SetCellValue(row,"flet_ctrt_no",charterExpData.flet_ctrt_no,0);
		//sheetObjects[0].CellValue2(row,"flet_ctrt_no") = form.flet_ctrt_no.value;
		sheetObjects[0].SetCellValue(row,"inv_seq",charterExpData.inv_seq,0);
		sheetObjects[0].SetCellValue(row,"inv_dtl_seq",charterExpData.inv_dtl_seq,0);
		sheetObjects[0].SetCellValue(row,"flet_src_tp_cd",charterExpData.flet_src_tp_cd,0);
		sheetObjects[0].SetCellValue(row,"org_flet_ctrt_no",charterExpData.flet_ctrt_no,0);
		sheetObjects[0].SetCellValue(row,"pop_gb","CHT",0);
		if(checkKeyNumber(sheetObjects[0], charterExpData.acct_cd)) {
			sheetObjects[0].SetCellEditable(row, "key_number",1);
			sheetObjects[0].SetCellValue(row,"key_flg","Y",0);
		}
		//sheetObjects[0].SetCellEditable(row, "acct_cd",0);
		initCellPropertyAndEdit(sheetObjects[0], row, "acct_cd");
	}
	setTotalAmount('S');
	initType();
}
/**
 * Setting data retrieved in Offhire Expenses PopUp
 * @param {arry} aryPopupData
 */
function setOffhireExp(aryPopupData) {
	for(var i=0; i<aryPopupData.length; i++) {
		var offhireExpData=aryPopupData[i];
		var row=sheetObjects[0].DataInsert(-1);
		sheetObjects[0].SetCellValue(row,"acct_nm",offhireExpData.acct_nm,0);
		sheetObjects[0].SetCellValue(row,"acct_cd",offhireExpData.acct_cd,0);
		sheetObjects[0].SetCellValue(row,"vndr_seq",form.ownr_cd.value,0);
		sheetObjects[0].SetCellValue(row,"ctr_cd",offhireExpData.ctr_cd,0);
		sheetObjects[0].SetCellValue(row,"slp_loc_cd",offhireExpData.slp_loc_cd,0);
		sheetObjects[0].SetCellValue(row,"slp_eff_dt",form.eff_dt.value,0);
		sheetObjects[0].SetCellValue(row,"curr_cd",offhireExpData.curr_cd,0);
		sheetObjects[0].SetCellValue(row,"csr_amt",-offhireExpData.inv_amt,0);
		sheetObjects[0].SetCellValue(row,"bunker_vvd",offhireExpData.vvd_bunker,0);
		sheetObjects[0].SetCellValue(row,"csr_desc",offhireExpData.inv_desc,0);
		sheetObjects[0].SetCellValue(row,"flet_iss_tp_cd",offhireExpData.flet_iss_tp_cd,0);
		sheetObjects[0].SetCellValue(row,"flet_ctrt_no",offhireExpData.flet_ctrt_no,0);
		//sheetObjects[0].CellValue2(row,"flet_ctrt_no") = form.flet_ctrt_no.value;
		sheetObjects[0].SetCellValue(row,"inv_seq",offhireExpData.inv_seq,0);
		sheetObjects[0].SetCellValue(row,"inv_dtl_seq",offhireExpData.inv_dtl_seq,0);
		sheetObjects[0].SetCellValue(row,"flet_src_tp_cd",offhireExpData.flet_src_tp_cd,0);
		sheetObjects[0].SetCellValue(row,"eff_dt",offhireExpData.eff_dt,0);
		sheetObjects[0].SetCellValue(row,"exp_dt",offhireExpData.exp_dt,0);
		sheetObjects[0].SetCellValue(row,"org_flet_ctrt_no",offhireExpData.flet_ctrt_no,0);
		sheetObjects[0].SetCellValue(row,"pop_gb","OFF",0);
		if(checkKeyNumber(sheetObjects[0], offhireExpData.acct_cd)) {
			sheetObjects[0].SetCellEditable(row, "key_number",1);
			sheetObjects[0].SetCellValue(row,"key_flg","Y",0);
		}
		//sheetObjects[0].SetCellEditable(row, "acct_cd",0);
		initCellPropertyAndEdit(sheetObjects[0], row, "acct_cd");
	}
	setTotalAmount('S');
	initType();
}
/**
 * Setting data retrieved in Owner’s Account PopUp
 * @param {arry} aryPopupData
 */
function setOwnersAccount(aryPopupData) {
	var olay_amt=0;
	var olay_rt_amt=0;
	var n1st_amt_sum=0;
	var manhour_ch_amt=0;
	for(var i=0; i<aryPopupData.length; i++) {
		var ownersAccountData=aryPopupData[i];
		var row=sheetObjects[0].DataInsert(-1);
		sheetObjects[0].SetCellValue(row,"acct_nm",ownersAccountData.acct_nm,0);
		sheetObjects[0].SetCellValue(row,"acct_cd",ownersAccountData.acct_cd,0);
		sheetObjects[0].SetCellValue(row,"vndr_seq",form.ownr_cd.value,0);
		sheetObjects[0].SetCellValue(row,"ctr_cd",ownersAccountData.ctr_cd,0);
		sheetObjects[0].SetCellValue(row,"slp_loc_cd",ownersAccountData.slp_loc_cd,0);
		if(i == 0) {
			olay_rt_amt=ownersAccountData.flet_olay_comm_rt_amt;
		}
		sheetObjects[0].SetCellValue(row,"slp_eff_dt",form.eff_dt.value,0);
		sheetObjects[0].SetCellValue(row,"curr_cd",ownersAccountData.curr_cd,0);
		sheetObjects[0].SetCellValue(row,"csr_amt",-ownersAccountData.n1st_amt,0);
		sheetObjects[0].SetCellValue(row,"bunker_vvd",ownersAccountData.vvd_bunker,0);
		sheetObjects[0].SetCellValue(row,"csr_desc",ownersAccountData.ap_desc,0);
		sheetObjects[0].SetCellValue(row,"flet_src_tp_cd",ownersAccountData.flet_src_tp_cd,0);
		sheetObjects[0].SetCellValue(row,"ap_slp_tp_cd",ownersAccountData.slp_tp_cd,0);
		sheetObjects[0].SetCellValue(row,"ap_slp_func_cd",ownersAccountData.slp_func_cd,0);
		sheetObjects[0].SetCellValue(row,"ap_slp_ofc_cd",ownersAccountData.slp_ofc_cd,0);
		sheetObjects[0].SetCellValue(row,"ap_slp_iss_dt",ownersAccountData.slp_iss_dt,0);
		sheetObjects[0].SetCellValue(row,"ap_slp_ser_no",ownersAccountData.slp_ser_no,0);
		sheetObjects[0].SetCellValue(row,"ap_slp_seq_no",ownersAccountData.slp_seq_no,0);
		/*
		sheetObjects[0].SetCellValue(row,"slp_tp_cd",ownersAccountData.slp_tp_cd,0);
		sheetObjects[0].SetCellValue(row,"slp_func_cd",ownersAccountData.slp_func_cd,0);
		sheetObjects[0].SetCellValue(row,"slp_ofc_cd",ownersAccountData.slp_ofc_cd,0);
		sheetObjects[0].SetCellValue(row,"slp_iss_dt",ownersAccountData.slp_iss_dt,0);
		sheetObjects[0].SetCellValue(row,"slp_ser_no",ownersAccountData.slp_ser_no,0);
		sheetObjects[0].SetCellValue(row,"slp_seq_no",ownersAccountData.slp_seq_no,0);
		*/
		sheetObjects[0].SetCellValue(row,"pop_gb","OWN",0);
		//sheetObjects[0].CellEditable(row, "key_number") = true;
		n1st_amt_sum += -parseFloat(ownersAccountData.n1st_amt);
		manhour_ch_amt += parseFloat(ownersAccountData.manhour_ch);
		//sheetObjects[0].SetCellEditable(row, "acct_cd",0);
		initCellPropertyAndEdit(sheetObjects[0], row, "acct_cd");
	}
	if(olay_rt_amt > 0) {
		olay_amt=(n1st_amt_sum * olay_rt_amt / 100).toFixed(2);
		var ownersAccountData=aryPopupData[0];
		var row=sheetObjects[0].DataInsert(-1);
		sheetObjects[0].SetCellValue(row,"acct_nm",ownersAccountData.acct_nm,0);
		sheetObjects[0].SetCellValue(row,"acct_cd","422011",0);
		sheetObjects[0].SetCellValue(row,"vndr_seq",form.ownr_cd.value,0);
		sheetObjects[0].SetCellValue(row,"ctr_cd",ownersAccountData.ctr_cd,0);
		sheetObjects[0].SetCellValue(row,"slp_loc_cd",ownersAccountData.slp_loc_cd,0);
		sheetObjects[0].SetCellValue(row,"slp_eff_dt",form.eff_dt.value,0);
		sheetObjects[0].SetCellValue(row,"curr_cd",ownersAccountData.curr_cd,0);
		sheetObjects[0].SetCellValue(row,"csr_amt",olay_amt,0);
		sheetObjects[0].SetCellValue(row,"bunker_vvd","CNTC" + form.eff_dt.value.trimAll('-').substring(2,6) + "MM",0);
		sheetObjects[0].SetCellValue(row,"csr_desc","O/A, OUTLAY COMM",0);
		sheetObjects[0].SetCellValue(row,"flet_src_tp_cd","10",0);
		sheetObjects[0].SetCellValue(row,"ap_slp_tp_cd",ownersAccountData.slp_tp_cd,0);
		sheetObjects[0].SetCellValue(row,"ap_slp_func_cd",ownersAccountData.slp_func_cd,0);
		sheetObjects[0].SetCellValue(row,"ap_slp_ofc_cd",ownersAccountData.slp_ofc_cd,0);
		sheetObjects[0].SetCellValue(row,"ap_slp_iss_dt",ownersAccountData.slp_iss_dt,0);
		sheetObjects[0].SetCellValue(row,"ap_slp_ser_no",ownersAccountData.slp_ser_no,0);
		sheetObjects[0].SetCellValue(row,"ap_slp_seq_no",ownersAccountData.slp_seq_no,0);
		/*
		sheetObjects[0].SetCellValue(row,"slp_tp_cd",ownersAccountData.slp_tp_cd,0);
		sheetObjects[0].SetCellValue(row,"slp_func_cd",ownersAccountData.slp_func_cd,0);
		sheetObjects[0].SetCellValue(row,"slp_ofc_cd",ownersAccountData.slp_ofc_cd,0);
		sheetObjects[0].SetCellValue(row,"slp_iss_dt",ownersAccountData.slp_iss_dt,0);
		sheetObjects[0].SetCellValue(row,"slp_ser_no",ownersAccountData.slp_ser_no,0);
		sheetObjects[0].SetCellValue(row,"slp_seq_no",ownersAccountData.slp_seq_no,0);
		*/
		sheetObjects[0].SetCellValue(row,"pop_gb","OWN",0);
		//sheetObjects[0].CellEditable(row, "key_number") = true;
		//sheetObjects[0].SetCellEditable(row, "acct_cd",0);
		initCellPropertyAndEdit(sheetObjects[0], row, "acct_cd");
	}
	if(manhour_ch_amt > 0) {
		for(var i=0; i<aryPopupData.length; i++) {
			var ownersAccountData=aryPopupData[i];
			if(parseFloat(ownersAccountData.manhour_ch) > 0) {
				var row=sheetObjects[0].DataInsert(-1);
				sheetObjects[0].SetCellValue(row,"acct_nm","Miscellaneous Income",0);
				sheetObjects[0].SetCellValue(row,"acct_cd","422011",0);
				sheetObjects[0].SetCellValue(row,"vndr_seq",form.ownr_cd.value,0);
				sheetObjects[0].SetCellValue(row,"ctr_cd",form.ap_ctr_cd.value,0);
				sheetObjects[0].SetCellValue(row,"slp_loc_cd",form.loc_cd.value,0);
				sheetObjects[0].SetCellValue(row,"slp_eff_dt",form.eff_dt.value,0);
				sheetObjects[0].SetCellValue(row,"curr_cd",ownersAccountData.curr_cd,0);
				sheetObjects[0].SetCellValue(row,"csr_amt",-ownersAccountData.manhour_ch,0);
				sheetObjects[0].SetCellValue(row,"bunker_vvd","CNTC" + form.eff_dt.value.trimAll('-').substring(2,6) + "MM",0);
				sheetObjects[0].SetCellValue(row,"csr_desc","(Manhour CHG) " + ownersAccountData.ap_desc,0);
				sheetObjects[0].SetCellValue(row,"flet_src_tp_cd","11",0);
				sheetObjects[0].SetCellValue(row,"ap_slp_tp_cd",ownersAccountData.slp_tp_cd,0);
				sheetObjects[0].SetCellValue(row,"ap_slp_func_cd",ownersAccountData.slp_func_cd,0);
				sheetObjects[0].SetCellValue(row,"ap_slp_ofc_cd",ownersAccountData.slp_ofc_cd,0);
				sheetObjects[0].SetCellValue(row,"ap_slp_iss_dt",ownersAccountData.slp_iss_dt,0);
				sheetObjects[0].SetCellValue(row,"ap_slp_ser_no",ownersAccountData.slp_ser_no,0);
				sheetObjects[0].SetCellValue(row,"ap_slp_seq_no",ownersAccountData.slp_seq_no,0);
				sheetObjects[0].SetCellValue(row,"pop_gb","OWN",0);
	 			//sheetObjects[0].SetCellEditable(row, "acct_cd",0);
				initCellPropertyAndEdit(sheetObjects[0], row, "acct_cd");
			}
		}
	}
	setTotalAmount('S');
	initType();
}
/**
 * Setting data retrieved in BOD, BOR Settlement PopUp
 * @param {arry} aryPopupData
 */
function setBodBor(aryPopupData) {
// Auto creation of Transfer Slip
	var autoFlg="N";
	var contrctTypeFlg = "N"; //NYK Modify 2014.10.27
	//if(   form.flet_ctrt_no.value.substring(4,6) == 'TO' && confirm(ComGetMsg('FMS01477'))) {
	if(   form.flet_ctrt_no.value.substring(4,6) == 'TO' ) {
		//autoFlg="N";
		contrctTypeFlg = "Y";
	}
	for(var i=0; i<aryPopupData.length; i++) {
		var bodBorData=aryPopupData[i];
		var row=sheetObjects[0].DataInsert(-1);
		sheetObjects[0].SetCellValue(row,"acct_nm",bodBorData.acct_nm,0);
		sheetObjects[0].SetCellValue(row,"acct_cd",bodBorData.acct_cd,0);
		sheetObjects[0].SetCellValue(row,"vndr_seq",form.ownr_cd.value,0);
		sheetObjects[0].SetCellValue(row,"ctr_cd",bodBorData.ctr_cd,0);
		sheetObjects[0].SetCellValue(row,"slp_loc_cd",bodBorData.slp_loc_cd,0);
		//sheetObjects[0].CellValue2(row,"flet_olay_comm_rt_amt") = ownersAccountData.flet_olay_comm_rt_amt;
		sheetObjects[0].SetCellValue(row,"slp_eff_dt",form.eff_dt.value,0);
		sheetObjects[0].SetCellValue(row,"curr_cd",bodBorData.curr_cd,0);
		
		if("N" == contrctTypeFlg){ //용선
			if(bodBorData.bnk_tp_cd == "BOD") {
				sheetObjects[0].SetCellValue(row,"csr_amt",bodBorData.bnk_amt,0);
			} else {
				sheetObjects[0].SetCellValue(row,"csr_amt",-bodBorData.bnk_amt,0);
			}
		}else{//대선
			sheetObjects[0].SetCellValue(row,"csr_amt",bodBorData.bnk_amt,0);
		}
		
		sheetObjects[0].SetCellValue(row,"bunker_vvd",bodBorData.vvd_bunker,0);
		sheetObjects[0].SetCellValue(row,"csr_desc",bodBorData.bnk_desc,0);
		sheetObjects[0].SetCellValue(row,"flet_src_tp_cd",bodBorData.flet_src_tp_cd,0);
		sheetObjects[0].SetCellValue(row,"flet_ctrt_no",bodBorData.flet_ctrt_no,0);
		sheetObjects[0].SetCellValue(row,"bnk_seq",bodBorData.bnk_seq,0);
		sheetObjects[0].SetCellValue(row,"pop_gb","OIL",0);
		sheetObjects[0].SetCellEditable(row, "ctr_cd",0);
		if(checkKeyNumber(sheetObjects[0], bodBorData.acct_cd)) {
			sheetObjects[0].SetCellEditable(row, "key_number",1);
			sheetObjects[0].SetCellValue(row,"key_flg","Y",0);
		}
		/*if(autoFlg == "Y") {
			sheetObjects[0].SetCellValue(row,"auto_flg","Y",0);
		}*/
		/*
		if(autoFlg == "Y") {
			//for(var i=0; i<aryPopupData.length; i++) {
				//var bodBorData = aryPopupData[i];
				var row=sheetObjects[0].DataInsert(-1);
				sheetObjects[0].SetCellValue(row,"acct_nm",sheetObjects[0].GetCellValue(row-1,"acct_nm"),0);
				sheetObjects[0].SetCellValue(row,"acct_cd","gAcctCdByBunker",0);
				sheetObjects[0].SetCellValue(row,"vndr_seq",form.ownr_cd.value,0);
				sheetObjects[0].SetCellValue(row,"ctr_cd",sheetObjects[0].GetCellValue(row-1,"ctr_cd"),0);
				sheetObjects[0].SetCellValue(row,"slp_loc_cd",sheetObjects[0].GetCellValue(row-1,"slp_loc_cd"),0);
				//sheetObjects[0].CellValue2(row,"flet_olay_comm_rt_amt") = ownersAccountData.flet_olay_comm_rt_amt;
				sheetObjects[0].SetCellValue(row,"slp_eff_dt",form.eff_dt.value,0);
				sheetObjects[0].SetCellValue(row,"curr_cd",sheetObjects[0].GetCellValue(row-1,"curr_cd"),0);
				sheetObjects[0].SetCellValue(row,"csr_amt",-1 * sheetObjects[0].GetCellValue(row-1,"csr_amt"),0);
				//if(bodBorData.acct_cd == "951111") {
				
				if(bodBorData.acct_cd == "956115") {
					sheetObjects[0].SetCellValue(row,"bunker_vvd","",0);
				} else {
					sheetObjects[0].SetCellValue(row,"bunker_vvd",bodBorData.vvd_bunker,0);
				}
				
				//Account Code = gAcctCdByBunker then  null
				//sheetObjects[0].CellValue2(row,"bunker_vvd") = sheetObjects[0].CellValue(row-1,"bunker_vvd");
				sheetObjects[0].SetCellValue(row,"csr_desc",sheetObjects[0].GetCellValue(row-1,"csr_desc"),0);
				sheetObjects[0].SetCellValue(row,"flet_src_tp_cd",sheetObjects[0].GetCellValue(row-1,"flet_src_tp_cd"),0);
				//sheetObjects[0].CellValue2(row,"flet_ctrt_no") = sheetObjects[0].CellValue(row-1,"flet_ctrt_no");
				//sheetObjects[0].CellValue2(row,"bnk_seq") = sheetObjects[0].CellValue(row-1,"bnk_seq");
				sheetObjects[0].SetCellValue(row,"pop_gb","OIL",0);
				sheetObjects[0].SetCellEditable(row, "ctr_cd",1);
				if(checkKeyNumber(sheetObjects[0], gAcctCdByBunker)) {
					sheetObjects[0].SetCellEditable(row, "key_number",1);
					sheetObjects[0].SetCellValue(row,"key_flg","Y",0);
				}
				sheetObjects[0].SetCellValue(row,"auto_flg","Y",0);
			//}
		}
		*/
		//sheetObjects[0].SetCellEditable(row, "acct_cd",0);
		initCellPropertyAndEdit(sheetObjects[0], row, "acct_cd");
	}
	setTotalAmount('S');
	initType();
}

function initCellPropertyAndEdit(sheetObj, row, colname){
	sheetObj.InitCellProperty(row, colname,{ Type:"Text",Align:"Center"} );
	sheetObj.SetCellEditable(row, colname,0);
}


/**
 * Getting relevant Name when selecting Contract No<br>
 **/
function contract_no_change() {
	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'flet_ctrt_no');
	if(form.flet_ctrt_no.value.substring(4,6) == 'TO') {
		ComBtnDisable("btn_charterersExp");
		ComBtnDisable("btn_offhireExp");
		ComBtnDisable("btn_ownersAccount");
	}
}
/**
 * Control Tax Evidence Button when Evidence Type is changed <br>
 **/
function setButton(val) {
	//NYK Modify 2014.11.11 Tax Not Used.
	/*
	form.evid_tp_cd_val.value=val;
	if(val == 5) {
    	//Disable Payments Slip TaxEvidence Button
		ComBtnDisable("btn_taxEvidence");
	} else {
		//Enable Payments Slip TaxEvidence Button
		ComBtnEnable("btn_taxEvidence");
	}
	
	initType();*/
}
function initType(){
	var etcd = $("#evid_tp_cd_combo option:selected").text();
	var length = sheetObjects[0].RowCount();
	if(etcd=="TAX"){
		if(length ==0){
    		
    	}else{
    		for(var i=sheetObjects[0].HeaderRows(); i<= sheetObjects[0].LastRow(); i++){
    			sheetObjects[0].SetCellEditable(i, "vat_apply", 1);
    		}

    	}
	}else{
		var length = sheetObjects[0].RowCount();
    	if(length ==0){
    		
    	}else{
    		sheetObjects[0].CheckAll("vat_apply",0);
    		for(var i=sheetObjects[0].HeaderRows(); i<= sheetObjects[0].LastRow(); i++){
    			sheetObjects[0].SetCellEditable(i, "vat_apply", 0);
    		}

    	}
    	
	}
}

/**
 * Checking whether Prepayments data is selected when Slip Type is Prepayments <br>
 **/
function preWorkCheck() {
	if(form.slp_tp[0].checked) {
		if(form.pre_work_flag.value == "") {
			ComShowCodeMessage('FMS01445');
			return false;
		}
		return true;
	} else {
		return true;
	}
}
/**
 * Handling process for input validation <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {form}    formObj     Form Object
 * @param {int}     sAction     Action Code(Example:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL - Defined in CoObject.js)
 **/
function validateForm(sheetObj,formObj,sAction,flag, subAction){
	if(formObj.vsl_cd.value == "") {
		ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS01138"));
		return false;
	}
	if(!ComChkValid(formObj)) return false;
	
	//2015.11.27 기존에 등록된 전표 조회 화면 호출
	if(sAction == IBSEARCH_ASYNC04){
		var fletCtrtNo = ComGetObjValue(formObj.flet_ctrt_no);
		var csrType = ComGetObjValue(formObj.csr_type); 
		var tmpCsrNo = ComGetObjValue(formObj.csr_no);
		if(subAction == "btn_csr_no"){ // 돋보기일때는 무조건 조회 화면을 띄우도록 한다.
			tmpCsrNo = "";
		}		
		if(ComIsEmpty(tmpCsrNo)){
			ComOpenPopup("ESM_FMS_0087.do?flet_ctrt_no=" + fletCtrtNo+"&csr_type="+csrType, 1024, 550, "setCsrNo", "1,0,1,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0087");
			return false;
		}else{
			return true;
		}
	}
	/*
	var rqstDt = formObj.rqst_dt.value;
	var slpIssDt = formObj.slp_iss_dt.value;
	if(parseInt(rqstDt.trimAll('-')) < parseInt(slpIssDt.trimAll('-'))) {
		//ComAlertFocus(formObj.rqst_dt, ComGetMsg("FMS01438"));
		//return false;
	}*/
	if(flag != 'N') {
		if(formObj.slp_desc.value == "") {
			ComAlertFocus(formObj.slp_desc, ComGetMsg("FMS01444"));
    		return false;
		} else if (formObj.ownr_cd.value == "") {
			ComShowCodeMessage("FMS01447");
    		return false;
		}
		return true;
	}
	form.csr_curr_cd.readOnly=true;
	form.vsl_cd.readOnly=true;
	form.btn_vslpop.style.cursor="default";
	form.btn_vslpop.style.cursor="hand";
	form.btn_ctrtpop.style.cursor="default";
	form.btn_ctrtpop.style.cursor="hand";
}
/**
 * Initialize Screen <br>
 * @return none
 * @see #ComResetAll
 **/
function clearAll(flag) {
	var ap_ctr_cd=form.ap_ctr_cd.value;
	var loc_cd=form.loc_cd.value;
    //ComResetAll();
	//NYK Modify 2014.10.21
	switch(flag){
		case "CTRT" :
			var tmpVslCd = form.vsl_cd.value;
			var tmpVslEngNm = form.vsl_eng_nm.value;
			var tmpSlpTpIdx = 0;
			for(i=0 ; i<form.slp_tp.length ; i++){ 
				if(form.slp_tp[i].checked){
					tmpSlpTpIdx = i;
				}
			}
			ComResetAll();
			form.slp_tp[tmpSlpTpIdx].checked=true;
			form.vsl_cd.value = tmpVslCd;
			form.vsl_eng_nm.value = tmpVslEngNm;
			break;
		default :
			ComResetAll();
	    	form.slp_tp[0].disabled=false;
	    	form.slp_tp[1].disabled=false;
	    	form.slp_tp[2].disabled=false;
	    	form.slp_tp[0].checked=true;
			break;
	}
	
    setCsrDate();
	form.vsl_cd.readOnly=false;
	form.csr_curr_cd.readOnly=false;
	form.slp_desc.readOnly=false;
	form.rqst_dt.readOnly=false;
	form.eff_dt.readOnly=false;
	//NYK Modify 2014.11.11
	//form.evid_tp_cd.disabled=false; 
	form.btn_ctrtpop.style.cursor="hand";
	$('#btn_ctrtpop').attr('id', 'btn_ctrtpop');
	$('#btn_ctrtpop').attr('name', 'btn_ctrtpop');
	$('#no_btn_ctrtpop').attr('id', 'btn_ctrtpop');
	$('#no_btn_ctrtpop').attr('name', 'btn_ctrtpop');
	//document.images["btn_ctrtpop"].name="btn_ctrtpop";
	form.btn_vslpop.style.cursor="hand";
	$('#btn_vslpop').attr('id', 'btn_vslpop');
	$('#btn_vslpop').attr('name', 'btn_vslpop');
	$('#no_btn_vslpop').attr('id', 'btn_vslpop');
	$('#no_btn_vslpop').attr('name', 'btn_vslpop');
	//document.images["btn_vslpop"].name="btn_vslpop";
	form.rqst_dt_cal.style.cursor="hand";
	$('#rqst_dt_cal').attr('id', 'rqst_dt_cal');
	$('#rqst_dt_cal').attr('name', 'rqst_dt_cal');
	$('#no_rqst_dt_cal').attr('id', 'rqst_dt_cal');
	$('#no_rqst_dt_cal').attr('name', 'rqst_dt_cal');
	//document.images["rqst_dt_cal"].name="rqst_dt_cal";
	form.eff_dt_cal.style.cursor="hand";
	$('#eff_dt_cal').attr('id', 'eff_dt_cal');
	$('#eff_dt_cal').attr('name', 'eff_dt_cal');
	$('#no_eff_dt_cal').attr('id', 'eff_dt_cal');
	$('#no_eff_dt_cal').attr('name', 'eff_dt_cal');
	//document.images["eff_dt_cal"].name="eff_dt_cal";
	form.ap_ctr_cd.value=ap_ctr_cd;
	form.loc_cd.value=loc_cd;
	pre_eff_dt="";
	sheetObjects[0].SetColHidden("seq_no",0);
	sheetObjects[0].SetColHidden("slp_seq_num",1);
	//form.evid_tp_cd.selectedIndex = 2;
	setEvidenceType();
	  		
	//NYK Modify 2014.10.15
	initDefaultDate();
	
    //NYK Modify 2014.11.11
	//form.evid_tp_cd.disabled=false;
	//Disable  Payments Slip Print Button
	ComBtnDisable("btn_print");
	//Disable Payments Slip HireStatement Button
	ComBtnDisable("btn_hireStatement");
	//Enable Payments Slip Save Button
	ComBtnEnable("btn_save");
	//Enable Payments Slip Prepayments Button 
	ComBtnEnable("btn_prepayments");
	//Enable Payments Slip CharterersExp Button
	ComBtnEnable("btn_charterersExp");
	//Enable Payments Slip OffhireExp Button
	ComBtnEnable("btn_offhireExp");
	//Enable Payments Slip OwnersAccount Button
	ComBtnEnable("btn_ownersAccount");
	//Enable Payments Slip BodBor Button
	ComBtnEnable("btn_bodBor");
	//Enable Payments Slip RowAdd Button
	ComBtnEnable("btn_rowAdd");
	//Enable Payments Slip RowDel Button
	ComBtnEnable("btn_rowDel");
	//Disable Payments Slip TaxEvidence Button
	ComBtnDisable("btn_taxEvidence");
	//Enable Total Cal Button
	//ComBtnEnable("btn_totalCal");
	//Setting Total Amount
	setTotalAmount();
}
/**
 * Deleting row <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {String} 	prefix   	variable separator
 * @return none
 **/
function rowRemove(sheetObj, prefix) {
	
	var sRow=sheetObj.FindCheckedRow(prefix + "DelChk");
	if (sRow == "") return;
	//Making Row to Array
	var arrRow=sRow.split("|"); //result : "1|3|5|"
	for (var idx=arrRow.length-1; idx>=0; idx--){
		var row=arrRow[idx];
		sheetObj.SetRowHidden(row,1);
		sheetObj.SetRowStatus(row,"D");
	}
	//ComRowHideDelete(sheetObj, "DelChk");
}
/**
 * Initializing Check Box <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {String} 	prefix   	variable separator
 * @return none
 **/
function initCheckBox(sheetObj) {
	for (var ir=1; ir<=sheetObj.LastRow(); ir++) {
		sheetObj.SetCellValue(ir,"DelChk",0,0);
	}
}
/**
 * Checking whether implementing when Event is occurred  <br>
 * @return {boolean} okYn   In case of clicking OK button on Message confirm window okYn:true,  else okYn:false
 **/
function initConfirm() {
    var okYn=true;
 	//if(sheetObjects[0].RowCount > 0 && rowChangeYn()) {
 	if(sheetObjects[0].IsDataModified()) {
 		var okYn=confirm(ComGetMsg('FMS00002'));
 	}
 	return okYn;
}
/**
 * Handling Screen by Event(after saving) <br>
 * @return none
 **/
function saveReadOnly() {
	form.vsl_cd.readOnly=true;
	form.csr_curr_cd.readOnly=true;
	form.slp_desc.readOnly=true;
	form.rqst_dt.readOnly=true;
	form.eff_dt.readOnly=true;
	form.slp_tp.disabled=true;
	//NYK Modify 2014.11.11
	form.btn_vslpop.name="no_btn_vslpop";
	form.btn_vslpop.style.cursor="default";
	
	form.btn_ctrtpop.name="no_btn_ctrtpop";
	form.btn_ctrtpop.style.cursor="default";
	
	form.eff_dt_cal.name = "no_eff_dt_cal";
	form.eff_dt_cal.style.cursor="default";
	
	form.rqst_dt_cal.name="no_rqst_dt_cal";
	form.rqst_dt_cal.style.cursor="default";
	form.slp_tp[0].disabled=true;
	form.slp_tp[1].disabled=true;
	form.slp_tp[2].disabled=true;
	//Enable Payments Slip Print Button
	ComBtnEnable("btn_print");
	//Enable Payments Slip HireStatement Button
	ComBtnEnable("btn_hireStatement");
	//Disable Payments Slip Save Button
	ComBtnDisable("btn_save");
	//Disable Payments Slip Prepayments Button
	ComBtnDisable("btn_prepayments");
	//Disable Payments Slip CharterersExp Button
	ComBtnDisable("btn_charterersExp");
	//Disable Payments Slip OffhireExp Button
	ComBtnDisable("btn_offhireExp");
	//Disable Payments Slip OwnersAccount Button
	ComBtnDisable("btn_ownersAccount");
	//Disable Payments Slip BodBor Button
	ComBtnDisable("btn_bodBor");
	//Disable Payments Slip RowAdd Button
	ComBtnDisable("btn_rowAdd");
	//Disable Payments Slip RowDel Button
	ComBtnDisable("btn_rowDel");
	//Disable Total Cal Button
	//ComBtnDisable("btn_totalCal");
}
/**
 * Event occurred when value of cell is changed <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} row     	selected Row of sheetObj
 * @param {ibsheet} col     	selected Col of sheetObj
 * @param {String} value    	sheetObj insert value
 **/
function sheet1_OnChange(sheetObj,Row, Col, Value, OldValue, RaiseFlag) {
	//invAmtOnChange(sheetObj,row,col,value);
	var formObj = document.form;
	if(Value == OldValue) return;
	
	if (sheetObj.ColSaveName(Col)==("slp_eff_dt")) {
		var acctCd = sheetObj.GetCellValue(Row, "acct_cd"); 
		if(acctCd != "111431"){
			doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC03,"bunker_vvd", Row);
		}
	}
	
	checkAccountCode(sheetObj,Row,Col,Value,"");
}
/**
 * Decide existing of Currency Code value in IBSheet insert value <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} row     	selected Row of sheetObj
 * @param {ibsheet} col     	selected Col of sheetObj
 * @param {String} 	value    	sheetObj insert value
 * @param {String} 	prefix   	variable separator
 * @return none
 * @see #setCurrCd
 **/
function checkAccountCode(sheetObj,row,col,value,prefix) {
	
	if (sheetObj.ColSaveName(col)==("acct_cd")) {
        var acctCdValue=sheetObj.GetCellValue(row, "acct_cd");
        if(acctCdValue == "") return;
        if(acctCdValue.length < 6) {
        	ComShowCodeMessage('FMS01439');
    		sheetObj.SetCellValue(row	,"acct_cd"		,"",0);
    		sheetObj.SetCellValue(row	,"acct_nm"		,"",0);
    		sheetObj.SetCellValue(row	,"acct_itm_seq"	,"",0);
			sheetObj.SelectCell(row,"acct_cd");
			return;
		}
        // In case of P
        /* 2015.11.18 향후 정책 Modify 예정.
          if(form.slp_tp[0].checked) {
        	if(acctCdValue == "510911" || acctCdValue == "111431" || acctCdValue == "111071") {
        		ComShowCodeMessage('FMS01446'); //Account Code 510911, 111431, 111071 is not available in Prepayment type CSR.
        		sheetObj.SetCellValue(row	,"acct_cd"		,"",0);
        		sheetObj.SetCellValue(row	,"acct_nm"		,"",0);
        		sheetObj.SetCellValue(row	,"acct_itm_seq"	,"",0);
				sheetObj.SelectCell(row,"acct_cd");
        		return;
        	}
        // In case of S
        } else {
        	if(acctCdValue == "111431" || acctCdValue == "111071") {
        		ComShowCodeMessage('FMS01454'); //Account Code 111431, 111071 is not available.
        		sheetObj.SetCellValue(row	,"acct_cd"		,"",0);
        		sheetObj.SetCellValue(row	,"acct_nm"		,"",0);
        		sheetObj.SetCellValue(row	,"acct_itm_seq"	,"",0);
				sheetObj.SelectCell(row,"acct_cd");
        		return;
        	}
        }*/
        form.chk_acct_cd.value=acctCdValue;
		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "acct_cd", row);
	} else if (sheetObj.ColSaveName(col)==("ctr_cd")) {
        var ctrCdValue=sheetObj.GetCellValue(row, "ctr_cd");
        if(ctrCdValue == "") {
        	sheetObj.SetCellValue(row, "slp_loc_cd","");
        	return;
        }
        if(ctrCdValue.length < 6) {
        	ComShowCodeMessage('FMS01440');
    		sheetObj.SetCellValue(row, "ctr_cd","",0);
			sheetObj.SelectCell(row, "ctr_cd");
			return;
		}
        form.chk_ctr_cd.value=ctrCdValue;
		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "ctr_cd", row);
	} else if (sheetObj.ColSaveName(col)==("bunker_vvd")) {
        var bunkerVvdValue=sheetObj.GetCellValue(row, "bunker_vvd");
        if(bunkerVvdValue == "") return;
        if(bunkerVvdValue.length < 10) {
        	ComShowCodeMessage('FMS01442');
    		sheetObj.SetCellValue(row, "bunker_vvd","",0);
			sheetObj.SelectCell(row, "bunker_vvd");
			return;
		}
        /*
        if(bunkerVvdValue.substring(0,4) != form.vsl_cd.value) {
        	ComShowCodeMessage('FMS01144');
    		sheetObj.SetCellValue(row, "bunker_vvd","",0);
			sheetObj.SelectCell(row, "bunker_vvd");
			return;
		}
		*/
        form.chk_bunker_vvd.value=bunkerVvdValue;
        //2015.11.19 NYK Not Used.
		//doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "bunker_vvd", row);
	} else if (sheetObj.ColSaveName(col)==("csr_amt")) {
		setTotalAmount('S');
	}
}
/**
 * Event occured when clicking Cell <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} Row     	selected Row of sheetObj
 * @param {ibsheet} Col     	selected Col of sheetObj
 * @param {String} 	Value     	File Name
 **/
function sheet1_OnClick(sheetObj,Row,Col,Value){
//    	if(form.csr_no.value == "") {
//	    	var v_evid_tp_cd=form.evid_tp_cd_val.value;
//	    	var csr_curr_cd=form.csr_curr_cd.value;
//	    	var tax_pl_cd=sheetObjects[1].GetCellValue(1,"tax_tax_pl_cd");
//	  		// In case of checking VAT Apply 
//	  		if (sheetObj.ColSaveName(Col)==("vat_apply")) {
//	  			if(sheetObj.GetCellValue(Row,"vat_apply") == 0) {
//		  			//if(evid_tp_cd == "1" || evid_tp_cd == "4") {
//		  			if(v_evid_tp_cd == "1" && tax_pl_cd == "2") {
//		  				if(csr_curr_cd == "KRW") {
//		  					sheetObj.SetCellValue(Row,"vat_apply",1);
//		  				} else {
//		  					if(sheetObjects[2].RowCount()== 0) {
//								ComShowCodeMessage("FMS01458");
//								sheetObj.SetCellValue(Row,"vat_apply",1);
//							} else {
//								if(sheetObjects[1].GetCellValue(1,"tax_tax_div_cd") == "1") {
//									if(parseFloat(sheetObj.GetCellValue(Row,"csr_amt")) < 0) {
//										ComShowCodeMessage("FMS01459"); // surplus message
//										sheetObj.SetCellValue(Row,"vat_apply",1);
//									}
//								} else {
//									if(parseFloat(sheetObj.GetCellValue(Row,"csr_amt")) > 0) {
//										ComShowCodeMessage("FMS01460"); // deficit message
//										sheetObj.SetCellValue(Row,"vat_apply",1);
//									}
//								}
//							}
//		  				}
//		  			} else {
//		  				sheetObj.SetCellValue(Row,"vat_apply",1);
//		  			}
//		  		}
//	  		}
//  		}
}
/**
 * Event called by Save Function to check Validation just before saving <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} row     	selected Row of sheetObj
 * @param {ibsheet} col     	selected Col of sheetObj
 * @param {String}  value    	sheetObj insert value
 **/
function sheet1_OnValidation(sheetObj,row,col,value) {
	var acctCdValue=sheetObj.GetCellValue(row, "acct_cd");
	var ctrtCdValue=sheetObj.GetCellValue(row, "ctr_cd");
	var csrAmtValue=sheetObj.GetCellValue(row, "csr_amt");
	var csrDescValue=sheetObj.GetCellValue(row, "csr_desc");
	var curr_cd=form.csr_curr_cd.value;

	// 111811 Account is able to be used onlt in case Currency is KRW, Prepayments Surtax(3rd Slip) is not checked
	if(acctCdValue != "") {
		if( curr_cd != "KRW" && acctCdValue == "111811" && sheetObj.GetCellValue(row,"vat_flg") != "3") {
			ComShowCodeMessage('FMS01475');
			sheetObj.SetCellValue(row,"acct_cd","",0);
			sheetObj.SelectCell(row,"acct_cd");
			sheetObj.ValidateFail(true);
			return;
		}
	}
	if(acctCdValue == "") {
		ComShowCodeMessage("FMS01073");
		sheetObj.SelectCell(row,"acct_cd");
		sheetObj.ValidateFail(true);
		return;
	} else if(ctrtCdValue == "") {
		ComShowCodeMessage("FMS01440");
		sheetObj.SelectCell(row,"ctr_cd");
		sheetObj.ValidateFail(true);
		return;
	} else if(csrAmtValue == "" || csrAmtValue == "0") {
		ComShowCodeMessage("FMS01448");
		sheetObj.SelectCell(row,"csr_amt");
		sheetObj.ValidateFail(true);
		return;
	} else if(csrDescValue == "") {
		ComShowCodeMessage("FMS01444");
		sheetObj.SelectCell(row,"csr_desc");
		sheetObj.ValidateFail(true);
		return;
	} 
	/* 2015.10.14 NYK 사용안함.
	//항차 체크
	var bunkerVvdValue=sheetObj.GetCellValue(row, "bunker_vvd");
	if((   acctCdValue.substring(0,1) == "4"
	    || acctCdValue.substring(0,1) == "6"
	    || acctCdValue.substring(0,1) == "7"
	    || acctCdValue.substring(0,2) == "51"
	    || acctCdValue == "956115"
	    || acctCdValue == "962111"
	    || acctCdValue == "111071") && !(   acctCdValue.substring(0,4) == "4212"
		   							     || acctCdValue.substring(0,4) == "5801"
		   							     || acctCdValue == "612900"
		   							     || acctCdValue == "712900") ) {
		//&& !(acctCdValue == "580111" || acctCdValue == "421211") vat_flg
		if(sheetObj.GetCellValue(row,"vat_flg") != "3") {
			if(bunkerVvdValue == "") {
				//In case of using ACC# 421211 , Require to insert VVD
				if (acctCdValue != "421211") {
					ComShowCodeMessage("FMS01155");
					sheetObj.SelectCell(row,"bunker_vvd");
					sheetObj.ValidateFail(true);
					return;						
				}
			}
		}
	} else {
		sheetObj.SetCellValue(row, "bunker_vvd","",0);
	}*/
	//NYK Modify 2014.10.28
	/*
	if(checkKeyNumber(sheetObj, acctCdValue)) {
		var keyNumberCol=sheetObj.SaveNameCol("key_number");
		var keyNumberValue=sheetObj.GetCellValue(row,keyNumberCol);
		if(sheetObj.GetCellValue(row,"vat_flg") == "") {
			if(keyNumberValue == "") {
				ComShowCodeMessage("FMS01456");
				sheetObj.SelectCell(row,"key_number");
				sheetObj.ValidateFail(true);
				return;
			}
		}
	}*/
}
function sheet1_OnPopupClick(sheetObj,Row,Col){
	ComOpenPopup("ESM_FMS_0076.do?flet_acct_cate_cd=CH", 550, 450, "setGridItemNm", "1,0,1,1,1,1", true, false, Row, Col, 0, "ESM_FMS_0076");
}

/**
 * Inserting setGridItemNm <br>
 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
 */
function setGridItemNm(aryPopupData, row, col, sheetIdx){
	sheetObjects[0].SetCellValue(row,"acct_nm",aryPopupData[0][2],0);
	sheetObjects[0].SetCellValue(row,"acct_cd",aryPopupData[0][3],0);
	sheetObjects[0].SetCellValue(row,"acct_itm_seq",aryPopupData[0][4],0);
	
	checkAccountCode(sheetObjects[0], row, col, "", "");
}	
/**
 * Conriem Save <br>
 * @return {boolean} okYn 
 **/
function saveConfirm() {
	//setTotalAmount('S');
	var okYn=ComShowConfirm(ComGetMsg("FMS00017"));
	return okYn;
}
/**
 * Calculating Total Amount <br>
 * @return none
 **/
function setTotalAmount(flag) {
	if(flag == "S") {
		var dr_amt=0;
		var diff_amt=0;
		for(var ir=1; ir<=sheetObjects[0].LastRow(); ir++) {
			if(   sheetObjects[0].GetCellValue(ir,"vat_flg") == ""
				|| sheetObjects[0].GetCellValue(ir,"vat_flg") == "1") {
				if(parseFloat(sheetObjects[0].GetCellValue(ir,"csr_amt")) > 0) {
					dr_amt += parseFloat(sheetObjects[0].GetCellValue(ir,"csr_amt"));
    			} else {
    				diff_amt += parseFloat(sheetObjects[0].GetCellValue(ir,"csr_amt"));
    			}
			}
		}
		form.dr_amt.value=ComAddComma(dr_amt.toFixed(2));
		form.diff_amt.value=ComAddComma(diff_amt.toFixed(2));
		form.balance_amt.value=ComAddComma((dr_amt + diff_amt).toFixed(2));
	} else {
		form.dr_amt.value="0.00";
 		form.diff_amt.value="0.00";
 		form.balance_amt.value="0.00";
	}
}
/**
 * Decision of whether Key Number is required by Account Code <br>
 * @param {ibsheet}	sheetObj    IBSheet Object
 * @param {String}  acctCd    	Account Code
 * @return {boolean} true : Existing, false : Not Existing
 **/
function checkKeyNumber(sheetObj, acctCd) {
	return false;
	/*
	if(   acctCd == "167111" 
	   || acctCd == "16712" 
	   || acctCd == "167191"
	   || (parseInt(acctCd) > 511300 && parseInt(acctCd) < 511499 && acctCd != "511351")
	   || (parseInt(acctCd) > 133810 && parseInt(acctCd) < 133891)) {
		return true;
	}
	return false;*/
}
/**
 * Making Tax Invoice / Invoice data <br>
 * @param {ibsheet}	sheetObj    IBSheet Object
 * @param {String}  acctCd    	Account Code
 * 2015.10.13 N Not Used.
 **/
function setMakeTaxEvidence(sheetObj) {
	var taxCnt=sheetObjects[2].RowCount();
	var vatCnt=0;
	var idx=0;
	var krw_csr_amt=0;
	var etc_csr_amt=0;
	var currCd=form.csr_curr_cd.value;
	if(currCd == "KRW") {
		for (var ir=1; ir<=taxCnt; ir++){
			var row=sheetObj.DataInsert(-1);
			sheetObj.SetCellValue(row,"acct_cd","111811",0);
			sheetObj.SetCellValue(row,"ctr_cd",form.ap_ctr_cd.value,0);
 			sheetObj.SetCellValue(row,"slp_loc_cd",form.loc_cd.value,0);
			sheetObj.SetCellValue(row,"bunker_vvd","",0);
			sheetObj.SetCellValue(row,"csr_amt",parseInt(sheetObjects[2].GetCellValue(ir,"txd_tax_amt")).toFixed(0),0);
			//sheetObj.CellValue2(row,"csr_amt") = parseInt(sheetObjects[2].CellValue(ir,"txd_tax_amt"));
			//sheetObj.CellValue2(row,"csr_amt") = parseInt(sheetObjects[2].CellValue(ir,"txd_tax_amt")) * parseInt(form.usd_locl_xch_rt.value);
			sheetObj.SetCellValue(row,"csr_desc","선급부가세 " + form.vsl_cd.value + " (VAT)",0);
			sheetObj.SetCellValue(row,"curr_cd","KRW",0);
			sheetObj.SetCellValue(row,"slp_tp_cd","S",0);
			sheetObj.SetCellValue(row,"vndr_seq",form.ownr_cd.value,0);
 			sheetObj.SetCellValue(row,"slp_eff_dt",form.eff_dt.value,0);
 			sheetObj.SetCellValue(row,"flet_src_tp_cd","20",0);
 			//sheetObj.CellValue2(row,"flet_ctrt_no") = sheetObj.CellValue(row-1,"flet_ctrt_no");
 			//sheetObj.CellValue2(row,"bnk_seq") = sheetObj.CellValue(row-1,"bnk_seq");
 			//sheetObj.CellValue2(row,"pop_gb") = sheetObj.CellValue(row-1,"pop_gb");
 			//sheetObj.CellValue2(row,"key_number") = sheetObj.CellValue(row-i,"key_number");
 			sheetObj.SetCellValue(row,"key_flg",sheetObj.GetCellValue(row-1,"key_flg"),0);
 			sheetObj.SetCellValue(row,"vat_flg","1",0);
 			//sheetObj.CellValue2(row,"slp_tp_cd") = sheetObj.CellValue(row-1,"slp_tp_cd");
 			//sheetObj.CellValue2(row,"slp_func_cd") = sheetObj.CellValue(row-1,"slp_func_cd");
 			//sheetObj.CellValue2(row,"slp_ofc_cd") = sheetObj.CellValue(row-1,"slp_ofc_cd");
 			//sheetObj.CellValue2(row,"slp_iss_dt") = sheetObj.CellValue(row-1,"slp_iss_dt");
 			//sheetObj.CellValue2(row,"slp_ser_no") = sheetObj.CellValue(row-1,"slp_ser_no");
 			//sheetObj.CellValue2(row,"slp_seq_no") = sheetObj.CellValue(row-1,"slp_seq_no");
 			//sheetObj.CellValue2(row,"inv_seq") = sheetObj.CellValue(row-1,"inv_seq");
 			//sheetObj.CellValue2(row,"inv_dtl_seq") = sheetObj.CellValue(row-1,"inv_dtl_seq");
		}
	} else {
		for (var ir=1; ir<=sheetObj.LastRow(); ir++){
			if(sheetObj.GetCellValue(ir, "vat_apply") == 1) {
     			//sheetObj.CellValue2(ir, "vat_apply") = "1";
     			vatCnt=vatCnt + 1;
     			idx=idx + 1;
     			// Generating Slip 1, Slip 2, Slip 3 data
     			for (var i=0; i<=4; i++){
     				var row=sheetObj.DataInsert(-1);
         			if(i == 0) {
         				sheetObj.SetCellValue(row,"acct_cd",sheetObj.GetCellValue(ir,"acct_cd"),0);
         				//sheetObj.CellValue2(row,"acct_nm") = sheetObj.CellValue(ir,"acct_nm");
						sheetObj.SetCellValue(row,"csr_desc",sheetObj.GetCellValue(ir,"csr_desc") + " (VAT)",0);
						sheetObj.SetCellValue(row,"vndr_seq",sheetObj.GetCellValue(ir,"vndr_seq"),0);
						sheetObj.SetCellValue(row,"ctr_cd",sheetObj.GetCellValue(ir,"ctr_cd"),0);
						sheetObj.SetCellValue(row,"slp_loc_cd",sheetObj.GetCellValue(ir,"slp_loc_cd"),0);
						sheetObj.SetCellValue(row,"slp_eff_dt",sheetObj.GetCellValue(ir,"slp_eff_dt"),0);
						sheetObj.SetCellValue(row,"curr_cd",sheetObj.GetCellValue(ir,"curr_cd"),0);
						sheetObj.SetCellValue(row,"csr_amt",(parseFloat(sheetObj.GetCellValue(ir,"csr_amt")) * 0.1).toFixed(2),0);
						sheetObj.SetCellValue(row,"bunker_vvd",sheetObj.GetCellValue(ir,"bunker_vvd"),0);
						sheetObj.SetCellValue(row,"flet_src_tp_cd","20",0);
						sheetObj.SetCellValue(row,"flet_ctrt_no",sheetObj.GetCellValue(ir,"flet_ctrt_no"),0);
						sheetObj.SetCellValue(row,"bnk_seq",sheetObj.GetCellValue(ir,"bnk_seq"),0);
						sheetObj.SetCellValue(row,"pop_gb",sheetObj.GetCellValue(ir,"pop_gb"),0);
						//sheetObj.CellValue2(row,"key_number") = sheetObj.CellValue(ir,"key_number");
						sheetObj.SetCellValue(row,"key_flg",sheetObj.GetCellValue(ir,"key_flg"),0);
	         			sheetObj.SetCellValue(row,"vat_flg","1",0);
	         			/*
						sheetObj.SetCellValue(row,"slp_tp_cd",sheetObj.GetCellValue(ir,"slp_tp_cd"),0);
						sheetObj.SetCellValue(row,"slp_func_cd",sheetObj.GetCellValue(ir,"slp_func_cd"),0);
						sheetObj.SetCellValue(row,"slp_ofc_cd",sheetObj.GetCellValue(ir,"slp_ofc_cd"),0);
						sheetObj.SetCellValue(row,"slp_iss_dt",sheetObj.GetCellValue(ir,"slp_iss_dt"),0);
						sheetObj.SetCellValue(row,"slp_ser_no",sheetObj.GetCellValue(ir,"slp_ser_no"),0);
						sheetObj.SetCellValue(row,"slp_seq_no",sheetObj.GetCellValue(ir,"slp_seq_no"),0);
						sheetObj.SetCellValue(row,"inv_seq",sheetObj.GetCellValue(ir,"inv_seq"),0);
						sheetObj.SetCellValue(row,"inv_dtl_seq",sheetObj.GetCellValue(ir,"inv_dtl_seq"),0);
	         			*/
         			} else {
         				if(i == 1) {
	         				sheetObj.SetCellValue(row,"acct_cd","951111",0);
	         				//sheetObj.CellValue2(row,"acct_cd") = "956115";
							//sheetObj.CellValue2(row,"ctr_cd") = "111231";
		         			//sheetObj.CellValue2(row,"slp_loc_cd") = "HQFAC";
	         				sheetObj.SetCellValue(row,"ctr_cd",sheetObj.GetCellValue(row-i,"ctr_cd"),0);
	         				sheetObj.SetCellValue(row,"slp_loc_cd",sheetObj.GetCellValue(row-i,"slp_loc_cd"),0);
	         				sheetObj.SetCellValue(row,"bunker_vvd","",0);
	         				sheetObj.SetCellValue(row,"csr_amt",sheetObj.GetCellValue(row-i,"csr_amt"),0);
	         				sheetObj.SetCellValue(row,"csr_desc","환대체 " + form.vsl_cd.value + " (VAT)",0);
	         				sheetObj.SetCellValue(row,"curr_cd",sheetObj.GetCellValue(row-i,"curr_cd"),0);
	         				sheetObj.SetCellValue(row,"slp_tp_cd","S",0);
	         				sheetObj.SetCellValue(row,"vat_flg","2",0);
	         				sheetObj.SetCellValue(row,"tax_seq",i+1,0);
	         				form.make_tax_yn.value="Y";
	         			} else if(i == 2) {
	         				sheetObj.SetCellValue(row,"acct_cd",sheetObj.GetCellValue(row-i,"acct_cd"),0);
							sheetObj.SetCellValue(row,"ctr_cd",sheetObj.GetCellValue(row-i,"ctr_cd"),0);
							sheetObj.SetCellValue(row,"slp_loc_cd",sheetObj.GetCellValue(row-i,"slp_loc_cd"),0);
							sheetObj.SetCellValue(row,"bunker_vvd",sheetObj.GetCellValue(row-i,"bunker_vvd"),0);
							sheetObj.SetCellValue(row,"csr_amt",-sheetObj.GetCellValue(row-i,"csr_amt"),0);
							sheetObj.SetCellValue(row,"csr_desc",sheetObj.GetCellValue(row-i,"csr_desc"),0);
							sheetObj.SetCellValue(row,"curr_cd",sheetObj.GetCellValue(row-i,"curr_cd"),0);
	         				sheetObj.SetCellValue(row,"slp_tp_cd","S",0);
	         				sheetObj.SetCellValue(row,"vat_flg","2",0);
	         			} else if(i == 3) {
	         				sheetObj.SetCellValue(row,"acct_cd","111811",0);
	         				sheetObj.SetCellValue(row,"ctr_cd",sheetObj.GetCellValue(row-i,"ctr_cd"),0);
	         				sheetObj.SetCellValue(row,"slp_loc_cd",sheetObj.GetCellValue(row-i,"slp_loc_cd"),0);
	         				sheetObj.SetCellValue(row,"bunker_vvd","",0);
	         				sheetObj.SetCellValue(row,"csr_amt",parseInt(sheetObjects[2].GetCellValue(idx,"txd_tax_amt")).toFixed(0),0);
	         				//sheetObj.CellValue2(row,"csr_amt") = parseInt(sheetObjects[2].CellValue(idx,"txd_tax_amt"));
	         				//sheetObj.CellValue2(row,"csr_amt") = parseInt(sheetObjects[2].CellValue(ir,"txd_tax_amt")) * parseInt(form.usd_locl_xch_rt.value);
	         				sheetObj.SetCellValue(row,"csr_desc","선급부가세 " + form.vsl_cd.value + " (VAT)",0);
	         				sheetObj.SetCellValue(row,"curr_cd","KRW",0);
	         				sheetObj.SetCellValue(row,"slp_tp_cd","S",0);
	         				sheetObj.SetCellValue(row,"vat_flg","3",0);
	         				sheetObj.SetCellValue(row,"tax_seq",i+1,0);
	         				krw_csr_amt=krw_csr_amt + parseFloat(sheetObjects[2].GetCellValue(idx,"txd_tax_amt"));
	         			} else if(i == 4) {
	         				sheetObj.SetCellValue(row,"acct_cd","951111",0);
	         				//sheetObj.CellValue2(row,"acct_cd") = "956115";
	         				//sheetObj.CellValue2(row,"ctr_cd") = "111231";
		         			//sheetObj.CellValue2(row,"slp_loc_cd") = "HQFAC";
	         				sheetObj.SetCellValue(row,"ctr_cd",sheetObj.GetCellValue(row-i,"ctr_cd"),0);
	         				sheetObj.SetCellValue(row,"slp_loc_cd",sheetObj.GetCellValue(row-i,"slp_loc_cd"),0);
	         				sheetObj.SetCellValue(row,"bunker_vvd","",0);
	         				if(parseFloat(sheetObjects[2].GetCellValue(idx,"txd_tax_amt")) > 0) {
	         					sheetObj.SetCellValue(row,"csr_amt",(-(parseFloat(sheetObj.GetCellValue(ir,"csr_amt")) * 0.1) * parseInt(form.usd_locl_xch_rt.value)).toFixed(0),0);
	         					//sheetObj.CellValue2(row,"csr_amt") = (-(parseFloat(sheetObj.CellValue(ir,"csr_amt")) * 0.1) * parseInt(form.usd_locl_xch_rt.value)).toFixed(2);
	         					//sheetObj.CellValue2(row,"csr_amt") = (-(Math.abs(parseFloat(sheetObj.CellValue(ir,"csr_amt"))) * 0.1) * parseInt(form.usd_locl_xch_rt.value)).toFixed(2);
	         				} else {
	         					sheetObj.SetCellValue(row,"csr_amt",(-(parseFloat(sheetObj.GetCellValue(ir,"csr_amt")) * 0.1) * parseInt(form.usd_locl_xch_rt.value)).toFixed(0),0);
	         					//sheetObj.CellValue2(row,"csr_amt") = (-(parseFloat(sheetObj.CellValue(ir,"csr_amt")) * 0.1) * parseInt(form.usd_locl_xch_rt.value)).toFixed(2);
	         				}
	         				sheetObj.SetCellValue(row,"csr_desc","환대체 " + form.vsl_cd.value + " (VAT)",0);
	         				sheetObj.SetCellValue(row,"curr_cd","KRW",0);
	         				sheetObj.SetCellValue(row,"slp_tp_cd","S",0);
	         				sheetObj.SetCellValue(row,"vat_flg","3",0);
	         				sheetObj.SetCellValue(row,"tax_seq",i+1,0);
	         				//etc_csr_amt = etc_csr_amt + parseFloat(sheetObj.CellValue(ir,"csr_amt")) * 0.1;
	         				etc_csr_amt=etc_csr_amt + parseFloat(sheetObj.GetCellValue(row,"csr_amt"));
	         			}
         				sheetObj.SetCellValue(row,"vndr_seq",sheetObj.GetCellValue(row-i,"vndr_seq"),0);
         				sheetObj.SetCellValue(row,"slp_eff_dt",sheetObj.GetCellValue(row-i,"slp_eff_dt"),0);
	         			/*
	         			if(i == 2) {
							sheetObj.SetCellValue(row,"csr_amt",-sheetObj.GetCellValue(row-i,"csr_amt"),0);
	         			} else {
							sheetObj.SetCellValue(row,"csr_amt",sheetObj.GetCellValue(row-i,"csr_amt"),0);
	         			}
	         			*/
	         			sheetObj.SetCellValue(row,"flet_src_tp_cd","20",0);
	         			//sheetObj.CellValue2(row,"flet_ctrt_no") = sheetObj.CellValue(row-i,"flet_ctrt_no");
	         			//sheetObj.CellValue2(row,"bnk_seq") = sheetObj.CellValue(row-i,"bnk_seq");
	         			//sheetObj.CellValue2(row,"pop_gb") = sheetObj.CellValue(row-i,"pop_gb");
	         			//sheetObj.CellValue2(row,"key_number") = sheetObj.CellValue(row-i,"key_number");
	         			sheetObj.SetCellValue(row,"key_flg",sheetObj.GetCellValue(row-i,"key_flg"),0);
	         			//sheetObj.CellValue2(row,"vat_flg") = i+1;
	         			/*
						sheetObj.SetCellValue(row,"slp_tp_cd",sheetObj.GetCellValue(row-i,"slp_tp_cd"),0);
						sheetObj.SetCellValue(row,"slp_func_cd",sheetObj.GetCellValue(row-i,"slp_func_cd"),0);
						sheetObj.SetCellValue(row,"slp_ofc_cd",sheetObj.GetCellValue(row-i,"slp_ofc_cd"),0);
						sheetObj.SetCellValue(row,"slp_iss_dt",sheetObj.GetCellValue(row-i,"slp_iss_dt"),0);
						sheetObj.SetCellValue(row,"slp_ser_no",sheetObj.GetCellValue(row-i,"slp_ser_no"),0);
						sheetObj.SetCellValue(row,"slp_seq_no",sheetObj.GetCellValue(row-i,"slp_seq_no"),0);
						sheetObj.SetCellValue(row,"inv_seq",sheetObj.GetCellValue(row-i,"inv_seq"),0);
						sheetObj.SetCellValue(row,"inv_dtl_seq",sheetObj.GetCellValue(row-i,"inv_dtl_seq"),0);
	         			*/
         			}
     			}
     			// Generating Last Data
     			if(vatCnt == taxCnt) {
     				if(parseFloat(krw_csr_amt + etc_csr_amt) != 0 ) {
     					var row=sheetObj.DataInsert(-1);
     					//In case of surplus
     					if(parseFloat(sheetObjects[2].GetCellValue(idx,"txd_tax_amt")) > 0) {
	         				if(krw_csr_amt - Math.abs(etc_csr_amt) < 0 ) {
	         					sheetObj.SetCellValue(row,"acct_cd","580111",0);
	         					sheetObj.SetCellValue(row,"csr_amt",(krw_csr_amt - Math.abs(etc_csr_amt)).toFixed(0) * -1,0);
	         					//sheetObj.CellValue2(row,"csr_amt") = (krw_csr_amt - Math.abs(etc_csr_amt)).toFixed(2) * -1;
	         					//sheetObj.CellValue2(row,"csr_amt") = ((Math.abs(krw_csr_amt) - Math.abs(etc_csr_amt)) * parseInt(form.usd_locl_xch_rt.value)).toFixed(2) * -1;
	         					sheetObj.SetCellValue(row,"csr_desc","외환차손  " + form.vsl_cd.value,0);
	         				} else {
	         					sheetObj.SetCellValue(row,"acct_cd","421211",0);
	         					sheetObj.SetCellValue(row,"csr_amt",(Math.abs(krw_csr_amt) - Math.abs(etc_csr_amt)).toFixed(0) * -1,0);
	         					//sheetObj.CellValue2(row,"csr_amt") = (Math.abs(krw_csr_amt) - Math.abs(etc_csr_amt)).toFixed(2) * -1;
	         					//sheetObj.CellValue2(row,"csr_amt") = ((Math.abs(krw_csr_amt) - Math.abs(etc_csr_amt)) * parseInt(form.usd_locl_xch_rt.value)).toFixed(2) * -1;
	         					sheetObj.SetCellValue(row,"csr_desc","외환차익  " + form.vsl_cd.value,0);
	         				}
	         			//In case of deficit
     					} else {
     						if(Math.abs(krw_csr_amt) - Math.abs(etc_csr_amt) > 0 ) {
	         					sheetObj.SetCellValue(row,"acct_cd","580111",0);
	         					sheetObj.SetCellValue(row,"csr_amt",(Math.abs(krw_csr_amt) - Math.abs(etc_csr_amt)).toFixed(0),0);
	         					//sheetObj.CellValue2(row,"csr_amt") = (Math.abs(krw_csr_amt) - Math.abs(etc_csr_amt)).toFixed(2);
	         					//sheetObj.CellValue2(row,"csr_amt") = ((Math.abs(krw_csr_amt) - Math.abs(etc_csr_amt)) * parseInt(form.usd_locl_xch_rt.value)).toFixed(2);
	         					sheetObj.SetCellValue(row,"csr_desc","외환차손  " + form.vsl_cd.value,0);
	         				} else {
	         					sheetObj.SetCellValue(row,"acct_cd","421211",0);
	         					sheetObj.SetCellValue(row,"csr_amt",(Math.abs(krw_csr_amt) - Math.abs(etc_csr_amt)).toFixed(0),0);
	         					//sheetObj.CellValue2(row,"csr_amt") = (Math.abs(krw_csr_amt) - Math.abs(etc_csr_amt)).toFixed(2);
	         					//sheetObj.CellValue2(row,"csr_amt") = ((Math.abs(krw_csr_amt) - Math.abs(etc_csr_amt)) * parseInt(form.usd_locl_xch_rt.value)).toFixed(2);
	         					sheetObj.SetCellValue(row,"csr_desc","외환차익  " + form.vsl_cd.value,0);
	         				}
     					}
         				//sheetObj.CellValue2(row,"ctr_cd") = "111231";
	         			//sheetObj.CellValue2(row,"slp_loc_cd") = "HQFAC";
     					sheetObj.SetCellValue(row,"ctr_cd",sheetObj.GetCellValue(row-i,"ctr_cd"),0);
     					sheetObj.SetCellValue(row,"slp_loc_cd",sheetObj.GetCellValue(row-i,"slp_loc_cd"),0);
	         			sheetObj.SetCellValue(row,"bunker_vvd","",0);
	         			//sheetObj.CellValue2(row,"bunker_vvd") = "CNTC" + form.eff_dt.value.trimAll('-').substring(2,6) + "MM";
         				//sheetObj.CellValue2(row,"bunker_vvd") = sheetObj.CellValue(row-3,"bunker_vvd");
         				//sheetObj.CellValue2(row,"csr_amt") = (krw_csr_amt - etc_csr_amt).toFixed(2);
         				sheetObj.SetCellValue(row,"curr_cd","KRW",0);
         				sheetObj.SetCellValue(row,"slp_tp_cd","S",0);
         				sheetObj.SetCellValue(row,"vndr_seq",sheetObj.GetCellValue(row-1,"vndr_seq"),0);
         				sheetObj.SetCellValue(row,"slp_eff_dt",sheetObj.GetCellValue(row-1,"slp_eff_dt"),0);
	         			sheetObj.SetCellValue(row,"flet_src_tp_cd","20",0);
	         			//sheetObj.CellValue2(row,"flet_ctrt_no") = sheetObj.CellValue(row-1,"flet_ctrt_no");
	         			//sheetObj.CellValue2(row,"bnk_seq") = sheetObj.CellValue(row-1,"bnk_seq");
	         			//sheetObj.CellValue2(row,"pop_gb") = sheetObj.CellValue(row-1,"pop_gb");
	         			//sheetObj.CellValue2(row,"key_number") = sheetObj.CellValue(row-1,"key_number");
	         			sheetObj.SetCellValue(row,"key_flg",sheetObj.GetCellValue(row-1,"key_flg"),0);
	         			sheetObj.SetCellValue(row,"vat_flg","3",0);
	         			//sheetObj.CellValue2(row,"vat_flg") = "999";
	         			/*
						sheetObj.SetCellValue(row,"slp_tp_cd",sheetObj.GetCellValue(row-1,"slp_tp_cd"),0);
						sheetObj.SetCellValue(row,"slp_func_cd",sheetObj.GetCellValue(row-1,"slp_func_cd"),0);
						sheetObj.SetCellValue(row,"slp_ofc_cd",sheetObj.GetCellValue(row-1,"slp_ofc_cd"),0);
						sheetObj.SetCellValue(row,"slp_iss_dt",sheetObj.GetCellValue(row-1,"slp_iss_dt"),0);
						sheetObj.SetCellValue(row,"slp_ser_no",sheetObj.GetCellValue(row-1,"slp_ser_no"),0);
						sheetObj.SetCellValue(row,"slp_seq_no",sheetObj.GetCellValue(row-1,"slp_seq_no"),0);
						sheetObj.SetCellValue(row,"inv_seq",sheetObj.GetCellValue(row-1,"inv_seq"),0);
						sheetObj.SetCellValue(row,"inv_dtl_seq",sheetObj.GetCellValue(row-1,"inv_dtl_seq"),0);
		         			*/
     				}
     			}
     		}
     	}
	}
}
/**
 * Making Slip Master data <br>
 * @return none
 **/
function setMakeSlipMstData() {
	var prefix="mst_";
	var makeTaxYn=form.make_tax_yn.value;
	var drAmt =Number(ComGetUnMaskedValue(form.dr_amt.value,"float"));
	var diffAmt = Number(ComGetUnMaskedValue(form.diff_amt.value,"float"));
	var balanceAmt = Number(ComGetUnMaskedValue(form.balance_amt.value,"float"));
	var rqstDt = form.rqst_dt.value;
	var effDt = form.eff_dt.value;
	var slpIssDt = form.slp_iss_dt.value;
	if(makeTaxYn == "Y") {
		var dr_amt2=0;
		var dr_amt3=0;
		var dr_amt4=0;
		var dr_amt5=0;
		for(var ir=1; ir<=sheetObjects[0].LastRow(); ir++) {
			if(sheetObjects[0].GetCellValue(ir,"tax_seq") == "2") {
				dr_amt2 += Math.abs(parseFloat(sheetObjects[0].GetCellValue(ir,"csr_amt")));
			} else if(sheetObjects[0].GetCellValue(ir,"tax_seq") == "4") {
				dr_amt4 += Math.abs(parseFloat(sheetObjects[0].GetCellValue(ir,"csr_amt")));
			} else if(sheetObjects[0].GetCellValue(ir,"tax_seq") == "5") {
				dr_amt5 += Math.abs(parseFloat(sheetObjects[0].GetCellValue(ir,"csr_amt")));
			}
		}
		if(dr_amt4 > dr_amt5) {
			dr_amt3=dr_amt4;
		} else if(dr_amt5 > dr_amt4) {
			dr_amt3=dr_amt5;
		} else {
			dr_amt3=dr_amt4;
		}
		for (var i=0; i<=2; i++){
			var row=sheetObjects[3].DataInsert(-1);
    		sheetObjects[3].SetCellValue(row, prefix+"slp_ofc_cd",form.slp_ofc_cd.value,0);
    		sheetObjects[3].SetCellValue(row, prefix+"ap_ctr_cd",form.ap_ctr_cd.value,0);
    		sheetObjects[3].SetCellValue(row, prefix+"loc_cd",form.loc_cd.value,0);
    		sheetObjects[3].SetCellValue(row, prefix+"chk_acct_cd",form.chk_acct_cd.value,0);
    		sheetObjects[3].SetCellValue(row, prefix+"chk_ctr_cd",form.chk_ctr_cd.value,0);
    		sheetObjects[3].SetCellValue(row, prefix+"chk_bunker_vvd",form.chk_bunker_vvd.value,0);
    		sheetObjects[3].SetCellValue(row, prefix+"pre_work_flag",form.pre_work_flag.value,0);
    		sheetObjects[3].SetCellValue(row, prefix+"evid_tp_cd_val",form.evid_tp_cd_val.value,0);
    		sheetObjects[3].SetCellValue(row, prefix+"usd_locl_xch_rt",form.usd_locl_xch_rt.value,0);
    		sheetObjects[3].SetCellValue(row, prefix+"flet_ctrt_no",form.flet_ctrt_no.value,0);
    		sheetObjects[3].SetCellValue(row, prefix+"vsl_cd",form.vsl_cd.value,0);
    		sheetObjects[3].SetCellValue(row, prefix+"vsl_eng_nm",form.vsl_eng_nm.value,0);
    		sheetObjects[3].SetCellValue(row, prefix+"flet_ctrt_tp_cd",form.flet_ctrt_tp_cd.value,0);
    		sheetObjects[3].SetCellValue(row, prefix+"slp_iss_dt",slpIssDt,0);
    		sheetObjects[3].SetCellValue(row, prefix+"usr_nm",form.usr_nm.value,0);
    		sheetObjects[3].SetCellValue(row, prefix+"csr_no",form.csr_no.value,0);
    		sheetObjects[3].SetCellValue(row, prefix+"eff_dt",effDt.trimAll('-'),0);
    		sheetObjects[3].SetCellValue(row, prefix+"ownr_cd",form.ownr_cd.value,0);
    		sheetObjects[3].SetCellValue(row, prefix+"ppay_hir_no",form.ppay_hir_no.value,0);
    		if(i == 0) {
    			sheetObjects[3].SetCellValue(row, prefix+"csr_curr_cd",form.csr_curr_cd.value,0);
    			sheetObjects[3].SetCellValue(row, prefix+"slp_desc",form.slp_desc.value,0);
    			if(form.slp_tp[0].checked) {
    				sheetObjects[3].SetCellValue(row, prefix+"slp_tp",form.slp_tp[0].value,0);
    			} else if (form.slp_tp[1].checked){
    				sheetObjects[3].SetCellValue(row, prefix+"slp_tp",form.slp_tp[1].value,0);
    			} else if (form.slp_tp[2].checked){
    				sheetObjects[3].SetCellValue(row, prefix+"slp_tp",form.slp_tp[2].value,0);
    			}
    			sheetObjects[3].SetCellValue(row, prefix+"evid_tp_cd",form.evid_tp_cd.value,0);
    			sheetObjects[3].SetCellValue(row, prefix+"rqst_dt",rqstDt.trimAll('-'),0);
    			sheetObjects[3].SetCellValue(row, prefix+"vat_flg","1",0);
    			sheetObjects[3].SetCellValue(row, prefix+"dr_amt",drAmt,0);
        		sheetObjects[3].SetCellValue(row, prefix+"diff_amt",diffAmt,0);
        		sheetObjects[3].SetCellValue(row, prefix+"balance_amt",balanceAmt,0);
    		} else if(i == 1) {
    			sheetObjects[3].SetCellValue(row, prefix+"csr_curr_cd",form.csr_curr_cd.value,0);
    			//sheetObjects[3].CellValue2(row, prefix+"slp_desc") = "환대체 " + form.vsl_cd.value + " (VAT) " + form.slp_desc.value;
    			sheetObjects[3].SetCellValue(row, prefix+"slp_desc","환대체 " + form.vsl_cd.value + " (VAT)",0);
    			sheetObjects[3].SetCellValue(row, prefix+"slp_tp","S",0);
    			sheetObjects[3].SetCellValue(row, prefix+"evid_tp_cd",form.evid_tp_cd.value,0);
    			//sheetObjects[3].CellValue2(row, prefix+"evid_tp_cd") = "5";
    			sheetObjects[3].SetCellValue(row, prefix+"vat_flg","2",0);
    			sheetObjects[3].SetCellValue(row, prefix+"dr_amt",dr_amt2,0);
        		sheetObjects[3].SetCellValue(row, prefix+"diff_amt",dr_amt2,0);
        		sheetObjects[3].SetCellValue(row, prefix+"balance_amt",0,0);
    		} else if(i == 2) {
    			sheetObjects[3].SetCellValue(row, prefix+"csr_curr_cd","KRW",0);
    			//sheetObjects[3].CellValue2(row, prefix+"slp_desc") = "선급부가세 " + form.vsl_cd.value + " (VAT) " + form.slp_desc.value;
    			sheetObjects[3].SetCellValue(row, prefix+"slp_desc","선급부가세 " + form.vsl_cd.value + " (VAT)",0);
    			sheetObjects[3].SetCellValue(row, prefix+"slp_tp","S",0);
    			sheetObjects[3].SetCellValue(row, prefix+"evid_tp_cd",form.evid_tp_cd.value,0);
    			//sheetObjects[3].CellValue2(row, prefix+"evid_tp_cd") = "5";
    			sheetObjects[3].SetCellValue(row, prefix+"vat_flg","3",0);
    			sheetObjects[3].SetCellValue(row, prefix+"dr_amt",dr_amt3.toFixed(0),0);
        		sheetObjects[3].SetCellValue(row, prefix+"diff_amt",dr_amt3.toFixed(0),0);
        		sheetObjects[3].SetCellValue(row, prefix+"balance_amt",0,0);
    		}
    		sheetObjects[3].SetCellValue(row, prefix+"cre_usr_id",form.usr_id.value,0);
    		sheetObjects[3].SetCellValue(row, prefix+"upd_usr_id",form.usr_id.value,0);
		}
	} else {
		var row=sheetObjects[3].DataInsert(-1);
		sheetObjects[3].SetCellValue(row, prefix+"slp_ofc_cd",form.slp_ofc_cd.value,0);
		sheetObjects[3].SetCellValue(row, prefix+"ap_ctr_cd",form.ap_ctr_cd.value,0);
		sheetObjects[3].SetCellValue(row, prefix+"loc_cd",form.loc_cd.value,0);
		sheetObjects[3].SetCellValue(row, prefix+"chk_acct_cd",form.chk_acct_cd.value,0);
		sheetObjects[3].SetCellValue(row, prefix+"chk_ctr_cd",form.chk_ctr_cd.value,0);
		sheetObjects[3].SetCellValue(row, prefix+"chk_bunker_vvd",form.chk_bunker_vvd.value,0);
		sheetObjects[3].SetCellValue(row, prefix+"pre_work_flag",form.pre_work_flag.value,0);
		sheetObjects[3].SetCellValue(row, prefix+"evid_tp_cd_val",form.evid_tp_cd_val.value,0);
		sheetObjects[3].SetCellValue(row, prefix+"usd_locl_xch_rt",form.usd_locl_xch_rt.value,0);
		sheetObjects[3].SetCellValue(row, prefix+"flet_ctrt_no",form.flet_ctrt_no.value,0);
		sheetObjects[3].SetCellValue(row, prefix+"vsl_cd",form.vsl_cd.value,0);
		sheetObjects[3].SetCellValue(row, prefix+"vsl_eng_nm",form.vsl_eng_nm.value,0);
		sheetObjects[3].SetCellValue(row, prefix+"flet_ctrt_tp_cd",form.flet_ctrt_tp_cd.value,0);
		sheetObjects[3].SetCellValue(row, prefix+"csr_curr_cd",form.csr_curr_cd.value,0);
		sheetObjects[3].SetCellValue(row, prefix+"slp_iss_dt",slpIssDt,0);
		sheetObjects[3].SetCellValue(row, prefix+"usr_nm",form.usr_nm.value,0);
		sheetObjects[3].SetCellValue(row, prefix+"csr_no",form.csr_no.value,0);
		sheetObjects[3].SetCellValue(row, prefix+"slp_desc",form.slp_desc.value,0);
		if(form.slp_tp[0].checked) {
			sheetObjects[3].SetCellValue(row, prefix+"slp_tp",form.slp_tp[0].value,0);
		} else if(form.slp_tp[1].checked) {
			sheetObjects[3].SetCellValue(row, prefix+"slp_tp",form.slp_tp[1].value,0);
		} else if(form.slp_tp[2].checked) {
			sheetObjects[3].SetCellValue(row, prefix+"slp_tp",form.slp_tp[2].value,0);
		}
		sheetObjects[3].SetCellValue(row, prefix+"evid_tp_cd",form.evid_tp_cd.value,0);
		sheetObjects[3].SetCellValue(row, prefix+"rqst_dt",rqstDt.trimAll('-'),0);
		sheetObjects[3].SetCellValue(row, prefix+"eff_dt",effDt.trimAll('-'),0);
		sheetObjects[3].SetCellValue(row, prefix+"ownr_cd",form.ownr_cd.value,0);
		sheetObjects[3].SetCellValue(row, prefix+"ppay_hir_no",form.ppay_hir_no.value,0);
		sheetObjects[3].SetCellValue(row, prefix+"vat_flg","1",0);
		sheetObjects[3].SetCellValue(row, prefix+"cre_usr_id",form.usr_id.value,0);
		sheetObjects[3].SetCellValue(row, prefix+"upd_usr_id",form.usr_id.value,0);
		sheetObjects[3].SetCellValue(row, prefix+"dr_amt",drAmt,0);
		sheetObjects[3].SetCellValue(row, prefix+"diff_amt",diffAmt,0);
		sheetObjects[3].SetCellValue(row, prefix+"balance_amt",balanceAmt,0);
	}
}
/**
 * Checking Balance Amt <br>
 * @param {ibsheet}	sheetObj    IBSheet Object
 * @param none
 **/
function checkBalance(sheetObj) {
	var balanceAmt=form.balance_amt.value;
	if(parseFloat(balanceAmt) < 0) {
		for(var ir=1; ir<=sheetObj.LastRow(); ir++) {
			if(sheetObj.GetCellValue(ir,"vat_flg") != "") {
				sheetObj.SetCellValue(ir,"DelChk",1,0);
			}
		}
		rowRemove(sheetObj, "");
		ComShowCodeMessage("FMS01471");
		return false;
	}
	return true;
}
/**
 * 2015.10.14 NYK 사용하지 않음.
 * VVD Level Check by Account
 * Decide whether Voyage is required to insert by checking Account Voyage Level <br>
 * @param {ibsheet}	 sheetObj    IBSheet Object
 * @param {ibsheet}  row     	 selected Row of sheetObj
 * @return {boolean} true : Cheking Voyage Level, false : pass
 **/
function checkAcctCdVvdLevel(sheetObj, row) {
	//VVD Level Check by Account
	var acctCdValue=sheetObj.GetCellValue(row, "acct_cd");
	if((   acctCdValue.substring(0,1) == "4"
	    || acctCdValue.substring(0,1) == "6"
	    || acctCdValue.substring(0,1) == "7"
	    || acctCdValue.substring(0,2) == "51"
	    || acctCdValue == "956115"
	    || acctCdValue == "962111"
	    || acctCdValue == "111071") && !(   acctCdValue.substring(0,4) == "4212"
			    						 || acctCdValue.substring(0,4) == "5801"
			    						 || acctCdValue == "612900"
			    					     || acctCdValue == "712900")) {
		return true;
	} else {
		return false;
	}
}
/**
 * 2015.10.14 NYK 사용하지 않음.
 * VVD Level Check by Account(Checking whether Voyage about relevant Account is required to insert )
 * Decide whether Voyage about relevant Account is required to insert by checking Account Voyage Level <br>
 * @param {ibsheet}	 sheetObj    IBSheet Object
 * @param {ibsheet}  row     	 selected Row of sheetObj
 * @return {boolean} true : Madatory, false : pass
 **/
function checkAcctCdVvdLevelMdt(sheetObj, row) {
	//VVD Level Check by Account
	var acctCdValue=sheetObj.GetCellValue(row, "acct_cd");
	if(	  acctCdValue.substring(0,4) == "4212"
	   || acctCdValue.substring(0,4) == "5801"
	   || acctCdValue == "612900"
       || acctCdValue == "712900") {
		return true;
	} else {
		return false;
	}
}
/**
 * Setting Evidence Type Default value
 * ETC Data Default setting(Code Value:5) <br>
 **/
function setEvidenceType() {
	var length=form.evid_tp_cd_combo.length;
	if(length > 0) {
		for(var i=0; i<length; i++) {
			if(form.evid_tp_cd_combo.options[i].value == gEvidenceClassTaxF0) {
				form.evid_tp_cd_combo.selectedIndex=i;
				
				form.evid_tp_cd.value = $("#evid_tp_cd_combo option:selected").val();
				form.evid_tp_nm.value = $("#evid_tp_cd_combo option:selected").text();
				form.evid_tp_cd_val.value = $("#evid_tp_cd_combo option:selected").val();
				break;
			}
			/*
			if(form.evid_tp_cd.options[i].value == "5") {
				form.evid_tp_cd.selectedIndex=i;
				break;
			}*/
		}
	}		
}
/**
 * 2015.10.14 NYK Not Used.
 * Initializing VAT Apply Check box when clicking Tax Evidence Button
 * @param {ibsheet}	sheetObj    IBSheet Object
 **/
function setInitVatApply(sheetObj) {
	for(var ir=1; ir<=sheetObj.LastRow(); ir++) {
		sheetObj.SetCellValue(ir,"vat_apply",0,0);
	}
}
/**
 * Event occurred after completing search by DoSearch <br>
 * @param {ibsheet}	sheetObj    IBSheet Object
 * @param {String}  ErrMsg    	Error Message
 **/
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var csrNo=sheetObj.GetEtcData("csrNo");
	
	if(typeof csrNo != "undefined" && csrNo != "" ) {
		form.csr_no.value=csrNo;
    	// Setting Button and Input Box for Mandantory item
     	saveReadOnly();
    	/*
     	var csrNo=sheetObj.GetEtcData("csrNo");
		if(typeof csrNo != "undefined" && csrNo != "" ) {
			form.csr_no.value=csrNo;
		}
		*/
		sheetObj.SetColHidden("seq_no",1);
		sheetObj.SetColHidden("slp_seq_num",0);
     	for (var ir=1; ir<=sheetObj.LastRow(); ir++){
     		sheetObj.SetCellEditable(ir, "DelChk",0);
     		sheetObj.SetCellEditable(ir, "acct_cd",0);
     		sheetObj.SetCellEditable(ir, "inv_amt",0);
     		sheetObj.SetCellEditable(ir, "bunker_vvd",0);
     		sheetObj.SetCellEditable(ir, "key_number",0);
     		sheetObj.SetCellEditable(ir, "csr_desc",0);
     		sheetObj.SetCellEditable(ir, "vat_apply",0);
     	}
	} else {
		//Initializing Master data
		sheetObjects[3].RemoveAll();
		//Initializing Tax Invoice/ Invoice data
		for (var ir=sheetObj.LastRow(); ir>=sheetObj.HeaderRows(); ir--) {
			if(sheetObj.GetCellValue(ir,"flet_src_tp_cd") == "20") {
				sheetObj.SetCellValue(ir,"DelChk",1,0);
				rowRemove(sheetObj, "");
			} else {
				sheetObj.SetCellValue(ir, "vat_apply",0,0);
			}
		}
	}
	initType();
}

/**
 * Printing RD <br>
 * @param {ibsheet}	rdObject    IBSheet Object
 * @param {form}    formObj     Form Object
 **/
function rdOpen(formObject){
	if(sheetObjects[0].RowCount() == 0) {
		ComShowCodeMessage("FMS00015");
		return;
	}
	
	if(formObject.csr_no.value == "") {
		ComShowCodeMessage("FMS00015");
		return;
	}

	var rdParam = '/rv '+ RD_FormQueryString(formObject,1);
	var rdFile = 'apps/opus/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/ESM_FMS_031.mrd';

	formObject.com_mrdPath.value = rdFile;
	formObject.com_mrdArguments.value = rdParam;
    ComOpenRDPopup();
}


//NYK Modify 2014.10.21
function initDefaultContractNo(){
  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);   
}

//NYK Modify 2014.10.22
function initPrePaymentButton() {
	var formObj=document.form;
	var tmpFletCtrtTpCd = formObj.param_flet_ctrt_tp_cd.value;
	
	//대선인경우 : Prepayment && TO 일때는 비활성화 시킨다.
	if(formObj.slp_tp[0].checked){
    	if(tmpFletCtrtTpCd == gFletCtrtTpCdTO) {
    		//Disable Payments Slip Prepayments Button
    		ComBtnDisable("btn_prepayments");
    	}else{
    		//Disable Payments Slip Prepayments Button
    		ComBtnEnable("btn_prepayments");
    	}
	}else{
		ComBtnDisable("btn_prepayments");
	}
}    

function setSheetSlpEffDtChange(sheetObj){
	var formObj = document.form;
	if(pre_eff_dt != formObj.eff_dt.value){
		//Sheet Set.
		if(sheetObj.RowCount()> 0) {
			for(var ir=sheetObj.HeaderRows(); ir<=sheetObj.LastRow(); ir++) {
				sheetObj.SetCellValue(ir,"slp_eff_dt",formObj.eff_dt.value, 1);
			}
		}
		
		pre_eff_dt=formObj.eff_dt.value;
	}
}

//2015.11.27 CSR NO 찾는 팝업 콜백함수.
function setCsrNo(aryPopupData){
	var formObj = document.form;
	var tmpCsrNo = aryPopupData[0][3];
	ComSetObjValue(formObj.csr_no, tmpCsrNo);
	
	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC04);
}

function resizeSheet(){
    for (i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i], 100);
    }
}
