/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : STM_SCO_0100.js
*@FileTitle  : STM Office Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
// common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();        
var comboCnt=0;
var gCurRow=0;
var now_select_sheet1=0 ;
var max_lu_tp_cd=0 ;
var bankofc="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** setting sheet object *****/
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
			case "btn_retrieve":				
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				break;
			case "btn_new":
				doActionIBSheet(sheetObject1, formObj, IBCLEAR);
				break;
			case "btn_save":
				doActionIBSheet(sheetObject1, formObj, IBSAVE);
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('SAP00001');
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
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/** 
 * registering IBCombo Object as list
 * param : combo_obj
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */ 
function setComboObject(combo_obj) {  
    comboObjects[comboCnt++]=combo_obj;  
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	} 
	
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
	
    initControl();
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	document.form.f_rep_ots_ofc_cd.readOnly=true;
}

/**
 * @param {IBMultiCombo} comboObj comboObj
 * @return none
 * @see #
 * @author
 * @version 2014 04 02
 */
function initCombo(comboObj, comboNo) { 
	switch (comboObj.options.id) {
	   case "mdm_ofc_cd":
			with (comboObj) {
		   		ValidChar(2);
			}
            break;
	   case "f_bank_ofc":
			with (comboObj) {
		   		ValidChar(2);
			}
           break;	            
	   case "f_rct_doc_cd":
		   with (comboObj) {
		   		SetColAlign(0, "left");
		   		SetColWidth(0, "90");
		   		SetColWidth(1, "90");
	   	   }
		   break;	
	}
}

/**
 * Removing IBSheet Row
 **/
function rowRemove(sheetObj){
	ComRowHideDelete(sheetObj, "DelChk");
}
/**
 * loading HTML Control event <br>
 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence number in sheetObjects array
 **/
function initControl() {
	//** Date Separator **/
	DATE_SEPARATOR="-";
	var formObj=document.form;
    //handling Axon event. event catch
	axon_event.addListenerFormat('blur', 'obj_blur'    , formObj); 	//- handling code when OnBeforeDeactivate(blur) event
	axon_event.addListenerFormat('focus'  , 'obj_focus'   , formObj);  //- handling code when OnBeforeActivate event in case of existing dataformat property
   // axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj); 	//- handling code when onkeypress event in case of existing dataformat property
   // axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);
    axon_event.addListenerForm  ('change'          , 'obj_onchange', formObj);
//    axon_event.addListenerForm  ('keypress'        , 'obj_keypress', formObj);
}

function obj_onchange(){
	var formObj  = document.form;

	switch(ComGetEvent("name")){
		case "f_misc_lss_lmt_amt":
			if (parseFloat(formObj.f_misc_lss_lmt_amt.value) > 0) {
				ComShowMessage("ML Limitation has to be in [ -99.99 ~ 0 ] ");
				formObj.f_misc_lss_lmt_amt.value = "";
				ComSetFocus(document.all.item("f_misc_lss_lmt_amt"));				
			}			
			else if (parseFloat(formObj.f_misc_lss_lmt_amt.value) < -99.99) {
				ComShowMessage("ML Limitation has to be in [ -99.99 ~ 0 ] ");
				formObj.f_misc_lss_lmt_amt.value = "";
				ComSetFocus(document.all.item("f_misc_lss_lmt_amt"));
			}
			break;
			
		case "f_misc_incm_lmt_amt":
			if (parseFloat(formObj.f_misc_incm_lmt_amt.value) < 0) {
				ComShowMessage("MI Limitation has to be in [ 0 ~ 99.99 ] ");
				formObj.f_misc_incm_lmt_amt.value = "";
				ComSetFocus(document.all.item("f_misc_incm_lmt_amt"));				
			}			
			break;
			
	}
}


function f_ots_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;
	var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
	
	if (newCode == "COU") {					
		formObj.f_rep_ots_ofc_cd.readOnly=false;
		formObj.f_rep_ots_ofc_cd.style.backgroundColor="#FFFFFF";
	} else {
		formObj.f_rep_ots_ofc_cd.readOnly=true;
		formObj.f_rep_ots_ofc_cd.style.backgroundColor="#E8E7EC";
		formObj.f_rep_ots_ofc_cd.value="";
	}
}

function f_ofc_entr_lvl_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);  
}

function f_bank_ctrl_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;

	if (newCode == "ARO") {  		
		f_bank_ofc.SetSelectCode(-1, true); 
		f_bank_ofc.SetEnable(false);
	} else {
		f_bank_ofc.SetEnable(true);
	}
}

function mdm_ofc_cd_OnBlur() { 
	var sheetObject1=sheetObjects[0];
	var formObj=document.form;
	doActionIBSheet(sheetObject1, formObj, IBSEARCH);   
}

//function mdm_ofc_cd_OnChange(comboObj) {
//	alert("mdm_ofc_cd_OnChange");
//	ComKeyOnlyAlphabet('upper');
//}
/** 
 * handling OnKeyPress events <br>
 * handling process for input validation by object's dataformat   <br>
 */ 
function obj_keypress() {
	switch (ComGetEvent().name) {	
		case "mdm_ofc_cd":
			ComKeyOnlyAlphabet('upper');
			break;
		case "f_bank_ofc":
			ComKeyOnlyAlphabet('upper');
			break;		
		case "f_agn_pfx_cd":
			ComKeyOnlyAlphabet('upper');
			break;		
	}
}
//handling Axon event 2
function obj_blur(){
    ComChkObjValid(ComGetEvent());
	var src=ComGetEvent("name")
}
function obj_focus(){
    ComClearSeparator(ComGetEvent());
}
//function obj_keypress(){
//	var src = window.ComGetEvent().getAttribute("name")
//}
function form_keyup(){
	ComKeyEnter('lengthnextfocus');
}
function obj_onclick(){
	var src=ComGetEvent("name")
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;	
	switch (sheetObj.id) {
	case "sheet1": //t1sheet1 init
        with(sheetObj){
			  var HeadTitle1="|OFC_CD|OFC_ENTR_LVL_CD|OFC_INQ_LVL_CD|OFC_BRNC_AGN_TP_CD|BANK_CTRL_CD|BANK_CHG_ACCT_CD|LOCL_CURR_CD|AGN_CMB_CD|AGN_PFX_CD|AGN_CURR_CD|AGN_OTS_LMT_AMT|AGN_OTS_LMT_FLG|OTS_CATE_CD|OTS_CD|OVPAY_TP_CD|MISC_LSS_LMT_AMT|MISC_INCM_LMT_AMT|OTS_IF_FLG|REP_OTS_OFC_CD|ENBL_FLG|RCT_TP_CD|RCT_DOC_CD|RCT_UNAPY_FLG|BANK_OFC";
			  HeadTitle1=HeadTitle1 + "|rct_ofc_tit_nm|rct_ofc_addr|rct_ofc_telcm_fax_no_ctnt|rct_tit_nm|rct_rmk|rct_spcl_rmk|rct_ofc_spcl_no_ctnt|ar_prn_tit_nm|f_ar_cr_cust_prn_ctnt|ar_prn_ctnt|ref_eml" ;
			  var headCount=ComCountHeadTitle(HeadTitle1);
			  (headCount, 0, 0, true);			
			  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );			
			  var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			  InitHeaders(headers, info);
			  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							{Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"ofc_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"ofc_entr_lvl_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ofc_inq_lvl_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ofc_brnc_agn_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"bank_ctrl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"bank_chg_acct_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"locl_curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"agn_cmb_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"agn_pfx_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"agn_curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"agn_ots_lmt_amt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"agn_ots_lmt_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ots_cate_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ots_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ovpay_tp_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"misc_lss_lmt_amt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"misc_incm_lmt_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ots_if_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"rep_ots_ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"enbl_flg",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"rct_tp_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"rct_doc_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"rct_unapy_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"bank_ofc",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ofc_wrtf_tp_cd1",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ofc_wrtf_tp_cd2",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ofc_wrtf_tp_cd3",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ofc_wrtf_tp_cd4",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ofc_wrtf_tp_cd5",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ofc_adj_tp_cd1",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ofc_adj_tp_cd2",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ofc_adj_tp_cd3",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ofc_adj_tp_cd4",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ofc_adj_tp_cd5",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"rct_ofc_tit_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"rct_ofc_addr",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"rct_ofc_telcm_fax_no_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"rct_tit_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"rct_rmk",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"rct_spcl_rmk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"rct_ofc_spcl_no_ctnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ar_prn_tit_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ar_cr_cust_prn_ctnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ar_prn_ctnt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ref_eml",                	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
			   
			  InitColumns(cols);			
			  SetEditable(1);
			  SetVisible(false);
            }
        break;   
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	if (!validateForm(sheetObj, formObj, sAction))		
		return;
	switch (sAction) {	
		case IBSAVE:
			if (!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}
			//inv ofc 사전 체크 
			var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND05 + "&lu_tp_cd=CHK_INV_AR_OFC&ofc_cd=" + mdm_ofc_cd.GetSelectCode());
			var checkInvOfc=ComGetEtcData(sXml,"inv_ar_ofc");
			if(checkInvOfc != 'Y'){
				ComShowCodeMessage('SCO00013');
				return false;
			}
			
			var sheet1_row_count=sheetObj.RowCount();
			if (sheet1_row_count < 1) { // Insert
				var idx=sheetObj.DataInsert();
			} else { // update 
				sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ib_flag","U");
			}
			formToSheet(sheetObj, formObj); // form object=> Sheet Object
			var sParamSheet=sheetObj.GetSaveString(true);
 			formObj.f_cmd.value=MULTI01;	
 			var sParam=FormQueryString(formObj);
 			if( sParamSheet != "" ){
				sParam += "&" + sParamSheet ;
			}
 			ComOpenWait(true);
 			var sXml=sheetObj.GetSaveData("STM_SCO_0100GS.do", sParam);
 			sheetObj.LoadSaveData(sXml);
 			var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(State != "S"){	
			   ComOpenWait(false);
			   ComShowCodeMessage('SCO00003'); //Saving data is fail			   
			   return false;
		    } else if(State == "S"){			   
			   ComOpenWait(false);		
			   ComShowCodeMessage('SCO00001'); //Data saved successfully.
			   doActionIBSheet(sheetObj, formObj, IBSEARCH);
		    } 			
 			break;	
		case IBCLEAR:
			FormObjectClear("N");
			sheetObjects[0].RemoveAll();
			break;	
		case IBSEARCH: //retrieve
			if (!validateForm(sheetObj,formObj,sAction)) {	
				return false;
			}
			
			//inv ofc 사전 체크 
			var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND05 + "&lu_tp_cd=CHK_INV_AR_OFC&ofc_cd=" + mdm_ofc_cd.GetSelectCode());
			var checkInvOfc=ComGetEtcData(sXml,"inv_ar_ofc");
			if(checkInvOfc != 'Y'){
				ComShowCodeMessage('SCO00013');
				return false;
			}
			
			formObj.f_cmd.value=SEARCH;
			ComOpenWait(true);
			var sXml=sheetObj.GetSearchData("STM_SCO_0100GS.do", FormQueryString(formObj));
			formObj.retrieve_chk.value="Y";	
			if (ScoIsEmptyXml(sXml)) {  
				ComShowCodeMessage('SCO00002');	
				ComOpenWait(false);
				return false;  
			} else {
				sheetObj.LoadSearchData(sXml,{Sync:1} );
			}
			ComOpenWait(false);
			break;			
		case IBSEARCH_ASYNC01: 			
			//ComOpenWait(true);
			//retrieve AR Office List 				
			var ofcStr=ScoGetComboItems(sheetObj, "STM_SCO_0100GS.do", SEARCH01, "", "ofc_cd_list");
			MakeComboObject2(mdm_ofc_cd, ofcStr, "N");
//			ScoAddComboItem(formObj.mdm_ofc_cd, ofcStr, "2", "Y");
		   	//retrieve Lookup List 	
			// entry level
			var comboItems=ScoGetLookupComboItems(sheetObj, "OFC LEVEL");
			ScoAddComboItem(f_ofc_entr_lvl_cd, comboItems, "2", "Y");
			//inquiry level
			var comboItems=ScoGetLookupComboItems(sheetObj, "INQUIRY LEVEL");
			ScoAddComboItem(f_ofc_inq_lvl_cd, comboItems, "2", "Y");
			//BA Type
			var comboItems=ScoGetLookupComboItems(sheetObj, "OFC BA TYPE");
			ScoAddComboItem(f_ofc_brnc_agn_tp_cd, comboItems, "2", "Y");
			//Bank Control
			var comboItems=ScoGetLookupComboItems(sheetObj, "BANK CONTROL");
			ScoAddComboItem(f_bank_ctrl_cd, comboItems, "2", "Y");
			//Bank Office
//			MakeComboObject3(formObj.f_bank_ofc, ofcStr, "Y");
			//Bank Charge
//			var comboItems = ScoGetLookupComboItems(sheetObj, "BANK CHARGE");
//			ScoAddComboItem(formObj.f_bank_chg_acct_cd, comboItems, "2", "Y");
			// Local Currency Code	
//			var currStr = ScoGetComboItems(sheetObj, "SARCommonGS.do", SEARCH08, "", "curr_cd_list");			
//			MakeComboObject(formObj.f_locl_curr_cd, currStr, "Y");
			// ASA Case
			var comboItems=ScoGetLookupComboItems(sheetObj, "ASA CASE");
			ScoAddComboItem(f_agn_cmb_cd, comboItems, "2", "Y");
			// Currency
//			MakeComboObject(formObj.f_agn_curr_cd, currStr, "Y");
			// OTS Summary
			var comboItems=ScoGetLookupComboItems(sheetObj, "OTS SUMMARY");
			ScoAddComboItem(f_ots_cate_cd, comboItems, "2", "Y");
			// OTS
			var comboItems=ScoGetLookupComboItems(sheetObj, "OUTSTANDING");
			ScoAddComboItem(f_ots_cd, comboItems, "2", "Y");
			// OPY Type
			var comboItems=ScoGetLookupComboItems(sheetObj, "OPY TYPE");
			ScoAddComboItem(f_ovpay_tp_cd, comboItems, "2", "Y");
			// Receipt Type
			var comboItems=ScoGetLookupComboItems(sheetObj, "RECEIPT TYPE");
			ScoAddComboItem(f_rct_tp_cd, comboItems, "2", "Y");
			// Receipt Doc
			var comboItems=ScoGetLookupComboItems(sheetObj, "RECEIPT DOC");
			ScoAddComboItem(f_rct_doc_cd, comboItems, "2", "Y");
			// Representative Office Code
			//MakeComboObject(formObj.f_rep_ots_ofc_cd, ofcStr, "Y");				
			//ComOpenWait(false);
			 
			// Office Write-off
			var ofcWrtfTp = ScoGetComboItems(sheetObj, "STM_SCO_0100GS.do", SEARCH03, "", "ofc_wrtf_tp_list");
			MakeComboObject2(f_ofc_wrtf_tp_cd1, ofcWrtfTp, "Y");
			MakeComboObject2(f_ofc_wrtf_tp_cd2, ofcWrtfTp, "Y");
			MakeComboObject2(f_ofc_wrtf_tp_cd3, ofcWrtfTp, "Y");
			MakeComboObject2(f_ofc_wrtf_tp_cd4, ofcWrtfTp, "Y");
			MakeComboObject2(f_ofc_wrtf_tp_cd5, ofcWrtfTp, "Y");
			
			// Office Adjustment 2016.07.11
			var ofcAdjTp = ScoGetComboItems(sheetObj, "STM_SCO_0100GS.do", SEARCH04, "", "ofc_adj_tp_list");
			MakeComboObject2(f_ofc_adj_tp_cd1, ofcAdjTp, "Y");
			MakeComboObject2(f_ofc_adj_tp_cd2, ofcAdjTp, "Y");
			MakeComboObject2(f_ofc_adj_tp_cd3, ofcAdjTp, "Y");
			MakeComboObject2(f_ofc_adj_tp_cd4, ofcAdjTp, "Y");
			MakeComboObject2(f_ofc_adj_tp_cd5, ofcAdjTp, "Y");
			
			break;	
		case IBSEARCH_ASYNC02:
			formObj.f_cmd.value=SEARCH02;
			var sXml=sheetObj.GetSearchData("STM_SCO_0100GS.do", FormQueryString(formObj));
			var bankOfcStr=ComGetEtcData(sXml, "bank_ofc_cd_list");
			comboObjects[5].RemoveAll();
			//Bank Office
			MakeComboObject3(f_bank_ofc, bankOfcStr, "N");
			break;	
	  }
}
function MakeComboObject2(cmbObj, arrStr, vacantRow) {
	var cnt=0;
	if (vacantRow == "Y") {
		cmbObj.InsertItem(0, "", "");
		cnt=1;
	}
	for (var i=1; i < arrStr.length; i++ ) {
		var arrStr2=arrStr[i].split("^");
		var code=arrStr2[0];
		cmbObj.InsertItem(cnt, code + "|" + arrStr2[1] , code);
		cnt++;
	}
	cmbObj.SetDropHeight(190);
}
function MakeComboObject3(cmbObj, arrStr, vacantRow) {
	var cnt=0;
	if (vacantRow == "Y") {
		cmbObj.InsertItem(0, "", "");
		cnt=1;
	}
	var arrStr2=arrStr.split("^");
	for (var i=1; i < arrStr2.length; i++ ) {
		var code=arrStr2[i];
		cmbObj.InsertItem(cnt, code , code);
		cnt++;
	}
	cmbObj.SetDropHeight(190);
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH: //retrieve
			if (mdm_ofc_cd.GetSelectCode()== ""){
				ComShowCodeMessage('SCO00004', 'Choose', 'Office Code');
				return false;	
			}
			break;			
		case IBSAVE: //retrieve
			if ( formObj.retrieve_chk.value == "N"){
				ComShowCodeMessage('SCO00004', 'Retrieve', 'before Saving');
				return false;	
			}
			
			
			if (f_ofc_brnc_agn_tp_cd.GetSelectCode().length > 3){
				ComShowCodeMessage('SCO00004', 'Check Lookup Code(OFC BA TYPE) !', 'BA Type should be under 3 digits');				
				return false;				
			}
			if (f_bank_ctrl_cd.GetSelectCode().length > 10){
				ComShowCodeMessage('SCO00004', 'Check Lookup Code(BANK COLTROL) !', 'Bank Control should be under 10 digits');				
				return false;				
			}
			if (f_bank_ofc.GetSelectCode().length > 6){
				ComShowCodeMessage('SCO00004', 'Check Office Setup!', 'Bank Office should be under 6 digits');				
				return false;				
			}
//			if (formObj.f_bank_chg_acct_cd.Code.length > 6){
//				ComShowCodeMessage('SCO00004', 'Check Lookup Code(BANK CHARGE) !', 'Bank Charge should be under 6 digits');
//				formObj.f_bank_chg_acct_cd.focus();
//				return false;				
//			}
//			if (formObcd.Code.length > 3){
//				ComShowCodeMessage('SCO00004', 'Check currency setup !', 'Local Currency Code should be under 3 digits');
//				formObj..focus();
//				return false;				
//			}
			if (f_agn_cmb_cd.GetSelectCode().length > 10){
				ComShowCodeMessage('SCO00004', 'Check Lookup Code(ASA CASE) !', 'ASA Case should be under 10 digits');
				return false;				
			}
//			if (formObj.f_agn_curr_cd.Code.length > 3){
//				ComShowCodeMessage('SCO00004', 'Check Currency setup !', 'Currency should be under 3 digits');
//				formObj.f_agn_curr_cd.focus();
//				return false;				
//			}
			if (f_ots_cate_cd.GetSelectCode().length > 10){
				ComShowCodeMessage('SCO00004', 'Check Lookup Code(OTS SUMMARY) !', 'OTS Summary should be under 10 digits');
				return false;				
			}
			
			if (f_ots_cd.GetSelectCode().length > 10){
				ComShowCodeMessage('SCO00004', 'Check Lookup Code(OUTSTANDING) !', 'OTS should be under 10 digits');
				return false;				
			}
			if (f_ovpay_tp_cd.GetSelectCode().length > 10){
				ComShowCodeMessage('SCO00004', 'Check Lookup Code(OPY TYPE) !', 'OPY Type should be under 10 digits');
				return false;				
			}
			if (f_rct_tp_cd.GetSelectCode().length > 3){
				ComShowCodeMessage('SCO00004', 'Check Lookup Code(RECEIPT TYPE) !', 'Receipt Type should be under 3 digits');				
				return false;				
			}
			/*if (f_rct_doc_cd.GetSelectCode().length > 3){
				ComShowCodeMessage('SCO00004', 'Check Lookup Code(RECEIPT DOC) !', 'Receipt Doc should be under 3 digits');				
				return false;				
			}*/
			if (formObj.f_rep_ots_ofc_cd.value.length > 6){
				ComShowCodeMessage('SCO00004', 'Check Office Setup !', 'Representitive Office Code should be under 6 digits');
				formObj.f_rep_ots_ofc_cd.focus();
				return false;				
			}
			
			//추가 요건 2014-11-27
			if (f_ofc_entr_lvl_cd.GetSelectCode() == ""){
				ComShowMessage('Please, Entry Level should be selected'); 				
				return false;				
			}
			
			if (f_ofc_inq_lvl_cd.GetSelectCode() == ""){
				ComShowMessage('Please, Inquiry Level should be selected');  
				return false;				
			}
			
			if (f_ofc_brnc_agn_tp_cd.GetSelectCode() == ""){
				ComShowMessage('Please, BA Type should be selected');
				return false;				
			}
			
			if (f_ots_cate_cd.GetSelectCode() == ""){
				ComShowMessage('Please, OTS Summary should be selected');
				return false;				
			}
			
			if (f_ots_cd.GetSelectCode() == ""){
				ComShowMessage('Please, OTS should be selected');
				return false;				
			}
			
			//BA Type이 BRH이면 Bank Control 필수 입력
			if(f_ofc_brnc_agn_tp_cd.GetSelectCode() == 'BRH'){
				if(f_bank_ctrl_cd.GetSelectCode() == ""){
					ComShowMessage('BA Type : Branch , Bank Control should be selected'); 
					return false; 
				}
			}
			//Bank Control 이 OTH이면 Bank Office 필수 입력
			if(f_bank_ctrl_cd.GetSelectCode() == 'OTH'){
				if(f_bank_ofc.GetSelectCode() == ""){
					ComShowMessage('Bank Control : Other , Bank Office should be selected'); 
					return false;
				}
			}
			//BA Type이 AGT이면 Agent Information
			if(f_ofc_brnc_agn_tp_cd.GetSelectCode() == 'AGT'){
				if(f_agn_cmb_cd.GetSelectCode() == ""
					|| ComIsEmpty(formObj.f_agn_pfx_cd) || ComIsEmpty(formObj.f_agn_ots_lmt_amt)){
					ComShowMessage('BA Type : Agent , Agent Information should be inputted'); 
					return false;
				}
			}
			//OTS가 COU이면 Rep. Office 필수 입력. ARO이면 비활성화
			if(f_ots_cd.GetSelectCode() == 'COU'){   
				if(ComIsEmpty(formObj.f_rep_ots_ofc_cd)){ 
					ComShowMessage('OTS : Country , Rep. Office should be inputted');   
					formObj.f_rep_ots_ofc_cd.focus();  
					return false; 
				}   
			} 
			//BA Type이 ALL or BRH이면 필수 입력 
			if(f_ofc_brnc_agn_tp_cd.GetSelectCode() == 'BRH' || f_ofc_brnc_agn_tp_cd.GetSelectCode() == 'ALL'){
				if(formObj.f_misc_lss_lmt_amt.value == ""){
					ComShowMessage('BA Type : Branch Or ALL , ML Limitation should be inputted'); 
					formObj.f_misc_lss_lmt_amt.focus(); 
					return false;
				}
				
				if(formObj.f_misc_incm_lmt_amt.value == ""){
					ComShowMessage('BA Type : Branch Or ALL , MI Limitation should be inputted'); 
					formObj.f_misc_incm_lmt_amt.focus();
					return false;   
				}
				
				if(f_rct_tp_cd.GetSelectCode() == ""){
					ComShowMessage('BA Type : Branch Or ALL , Receipt Type should be selected');
					return false;    
				}
				
				if(f_rct_doc_cd.GetSelectCode() == ""){
					ComShowMessage('BA Type : Branch Or ALL , Receipt DOC should be selected');
					return false;    
				}
			}
			
			break;	
	}
	return true;
}
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj=document.form;
	if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
		f_ofc_entr_lvl_cd.SetSelectCode(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "ofc_entr_lvl_cd"));
		f_ofc_inq_lvl_cd.SetSelectCode(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "ofc_inq_lvl_cd"));
		f_ofc_brnc_agn_tp_cd.SetSelectCode(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "ofc_brnc_agn_tp_cd"));
		f_bank_ctrl_cd.SetSelectCode(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "bank_ctrl_cd"));
//		formObj.f_bank_chg_acct_cd.Code         = sheetObj.CellValue(sheetObjects[0].SelectRow, "bank_chg_acct_cd");
//		formObcd.Code             = sheetObj.CellValue(sheetObjects[0].SelectRow, "locl_curr_cd");
		f_agn_cmb_cd.SetSelectCode(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "agn_cmb_cd"));
		formObj.f_agn_pfx_cd.value=sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "agn_pfx_cd");
//		formObj.f_agn_curr_cd.Code              = sheetObj.CellValue(sheetObjects[0].SelectRow, "agn_curr_cd");
		formObj.f_agn_ots_lmt_amt.value=sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "agn_ots_lmt_amt");
		formObj.f_agn_ots_lmt_flg_val.value=sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "agn_ots_lmt_flg");
		if (formObj.f_agn_ots_lmt_flg_val.value == "Y"){
			formObj.f_agn_ots_lmt_flg.checked=true;			
		} else {
			formObj.f_agn_ots_lmt_flg.checked=false;
		}

		f_ots_cd.SetSelectCode(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "ots_cd"));
		//formObj.f_ots_ofc_cd.value              = sheetObj.CellValue(sheetObjects[0].SelectRow, "ots_ofc_cd");
		f_ovpay_tp_cd.SetSelectCode(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "ovpay_tp_cd"));
		formObj.f_misc_lss_lmt_amt.value=sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "misc_lss_lmt_amt");
		formObj.f_misc_incm_lmt_amt.value=sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "misc_incm_lmt_amt");
		formObj.f_ots_if_flg_val.value=sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "ots_if_flg");
		formObj.f_rep_ots_ofc_cd.value=sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "rep_ots_ofc_cd");
		f_rct_tp_cd.SetSelectCode(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "rct_tp_cd"));
		f_rct_doc_cd.SetSelectCode(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "rct_doc_cd"));
		formObj.f_rct_unapy_flg_val.value=sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "rct_unapy_flg");
		f_bank_ofc.SetSelectCode(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "bank_ofc"));
		
		f_ofc_wrtf_tp_cd1.SetSelectCode(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "ofc_wrtf_tp_cd1"));
		f_ofc_wrtf_tp_cd2.SetSelectCode(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "ofc_wrtf_tp_cd2"));
		f_ofc_wrtf_tp_cd3.SetSelectCode(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "ofc_wrtf_tp_cd3"));
		f_ofc_wrtf_tp_cd4.SetSelectCode(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "ofc_wrtf_tp_cd4"));
		f_ofc_wrtf_tp_cd5.SetSelectCode(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "ofc_wrtf_tp_cd5"));
		
		f_ofc_adj_tp_cd1.SetSelectCode(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "ofc_adj_tp_cd1"));
		f_ofc_adj_tp_cd2.SetSelectCode(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "ofc_adj_tp_cd2"));
		f_ofc_adj_tp_cd3.SetSelectCode(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "ofc_adj_tp_cd3"));
		f_ofc_adj_tp_cd4.SetSelectCode(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "ofc_adj_tp_cd4"));
		f_ofc_adj_tp_cd5.SetSelectCode(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "ofc_adj_tp_cd5"));
		
		if (formObj.f_ots_if_flg_val.value == "Y"){
			formObj.f_ots_if_flg.checked=true;			
		} else {
			formObj.f_ots_if_flg.checked=false;
		}
		if (formObj.f_rct_unapy_flg_val.value == "Y"){
			formObj.f_rct_unapy_flg.checked=true;			
		} else {
			formObj.f_rct_unapy_flg.checked=false;
		}
		formObj.f_rct_ofc_tit_nm.value=sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "rct_ofc_tit_nm");
		formObj.f_rct_ofc_addr.value=sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "rct_ofc_addr");
		formObj.f_rct_ofc_telcm_fax_no_ctnt.value=sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "rct_ofc_telcm_fax_no_ctnt");
		formObj.f_rct_tit_nm.value=sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "rct_tit_nm");
		formObj.f_rct_rmk.value=sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "rct_rmk");
		formObj.f_rct_spcl_rmk.value=sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "rct_spcl_rmk");
		formObj.f_rct_ofc_spcl_no_ctnt.value=sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "rct_ofc_spcl_no_ctnt");
		formObj.f_ar_prn_tit_nm.value=sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "ar_prn_tit_nm");
		formObj.f_ar_cr_cust_prn_ctnt.value=sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "ar_cr_cust_prn_ctnt");
		formObj.f_ar_prn_ctnt.value=sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "ar_prn_ctnt");
		formObj.ref_eml.value=sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "ref_eml");
		
		//OTS Summary 다시 세팅 
		var comboItems=ScoGetLookupComboItems(sheetObj, "OTS SUMMARY","&ofc_cd=" + mdm_ofc_cd.GetSelectCode());  
		f_ots_cate_cd.RemoveAll(); 
		ScoAddComboItem(f_ots_cate_cd, comboItems, "2", "Y"); 
		f_ots_cate_cd.SetSelectCode(sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "ots_cate_cd"));
		
		//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	}
}
function formToSheet(sheetObj, formObj) {
		if (formObj.f_ots_if_flg.checked == true){
			formObj.f_ots_if_flg_val.value="Y";			
		} else {
			formObj.f_ots_if_flg_val.value="N";	
		}
		if (formObj.f_rct_unapy_flg.checked == true){
			formObj.f_rct_unapy_flg_val.value="Y";				
		} else {
			formObj.f_rct_unapy_flg_val.value="N";		
		}
		if (formObj.f_agn_ots_lmt_flg.checked == true){
			formObj.f_agn_ots_lmt_flg_val.value="Y";				
		} else {
			formObj.f_agn_ots_lmt_flg_val.value="N";		
		}
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ofc_cd",mdm_ofc_cd.GetSelectCode());
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ofc_entr_lvl_cd",f_ofc_entr_lvl_cd.GetSelectCode());
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ofc_inq_lvl_cd",f_ofc_inq_lvl_cd.GetSelectCode());
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ofc_brnc_agn_tp_cd",f_ofc_brnc_agn_tp_cd.GetSelectCode());
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "bank_ctrl_cd",f_bank_ctrl_cd.GetSelectCode());
//	    sheetObj.CellValue(sheetObjects[0].SelectRow, "bank_chg_acct_cd")     = formObj.f_bank_chg_acct_cd.Code;
//	    sheetObj.CellValue(sheetObjects[0].SelectRow, "locl_curr_cd")         = formObcd.Code;
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "agn_cmb_cd",f_agn_cmb_cd.GetSelectCode());
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "agn_pfx_cd",formObj.f_agn_pfx_cd.value);
//	    sheetObj.CellValue(sheetObjects[0].SelectRow, "agn_curr_cd")          = formObj.f_agn_curr_cd.Code;
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "agn_ots_lmt_amt",formObj.f_agn_ots_lmt_amt.value);
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "agn_ots_lmt_flg",formObj.f_agn_ots_lmt_flg_val.value);
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ots_cate_cd",f_ots_cate_cd.GetSelectCode());
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ots_cd",f_ots_cd.GetSelectCode());
//	    sheetObj.CellValue(sheetObjects[0].SelectRow, "ots_ofc_cd")           = formObj.f_ots_ofc_cd.value;
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ovpay_tp_cd",f_ovpay_tp_cd.GetSelectCode());
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "misc_lss_lmt_amt",formObj.f_misc_lss_lmt_amt.value);
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "misc_incm_lmt_amt",formObj.f_misc_incm_lmt_amt.value);
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ots_if_flg",formObj.f_ots_if_flg_val.value);
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "rep_ots_ofc_cd",formObj.f_rep_ots_ofc_cd.value);
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "rct_tp_cd",f_rct_tp_cd.GetSelectCode());
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "rct_doc_cd",f_rct_doc_cd.GetSelectCode());
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "rct_unapy_flg",formObj.f_rct_unapy_flg_val.value);
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "bank_ofc",f_bank_ofc.GetSelectCode());//bankofc[0];  //
	    
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ofc_wrtf_tp_cd1",f_ofc_wrtf_tp_cd1.GetSelectCode());
		sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ofc_wrtf_tp_cd2",f_ofc_wrtf_tp_cd2.GetSelectCode());
		sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ofc_wrtf_tp_cd3",f_ofc_wrtf_tp_cd3.GetSelectCode());
		sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ofc_wrtf_tp_cd4",f_ofc_wrtf_tp_cd4.GetSelectCode());
		sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ofc_wrtf_tp_cd5",f_ofc_wrtf_tp_cd5.GetSelectCode());  
		
		sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ofc_adj_tp_cd1",f_ofc_adj_tp_cd1.GetSelectCode());
		sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ofc_adj_tp_cd2",f_ofc_adj_tp_cd2.GetSelectCode());
		sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ofc_adj_tp_cd3",f_ofc_adj_tp_cd3.GetSelectCode());
		sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ofc_adj_tp_cd4",f_ofc_adj_tp_cd4.GetSelectCode());
		sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ofc_adj_tp_cd5",f_ofc_adj_tp_cd5.GetSelectCode());  
		
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "rct_ofc_tit_nm",formObj.f_rct_ofc_tit_nm.value);
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "rct_ofc_addr",formObj.f_rct_ofc_addr.value);
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "rct_ofc_telcm_fax_no_ctnt",formObj.f_rct_ofc_telcm_fax_no_ctnt.value);
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "rct_tit_nm",formObj.f_rct_tit_nm.value);
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "rct_rmk",formObj.f_rct_rmk.value );
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "rct_spcl_rmk",formObj.f_rct_spcl_rmk.value);
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "rct_ofc_spcl_no_ctnt",formObj.f_rct_ofc_spcl_no_ctnt.value );
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ar_prn_tit_nm",formObj.f_ar_prn_tit_nm.value  );
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ar_cr_cust_prn_ctnt",formObj.f_ar_cr_cust_prn_ctnt.value  );
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ar_prn_ctnt",formObj.f_ar_prn_ctnt.value );
	    sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "ref_eml",formObj.ref_eml.value );
}
function mdm_ofc_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var formObj=document.form;
	form.retrieve_chk.value="N";
	FormObjectClear("Y");
	sheetObjects[0].RemoveAll();
}
//function f_rct_tp_cd_OnChange(comboObj,value,text){
//	var formObj = document.form;
//	
//	if (formObj.f_rct_tp_cd.Code.length > 3){
//		ComShowCodeMessage('SCO00004', 'Check Lookup Code(RECEIPT DOC) !', 'Digits of Receipt Doc should be 3digits');
//		return false;				
//	}
//}
function FormObjectClear(chgMdmOfcChk) {
	var formObj=document.form;
	form.retrieve_chk.value="N";
	sheetObjects[0].RemoveAll();
	if (chgMdmOfcChk == "N"){
		mdm_ofc_cd.SetSelectCode("");
	}	
	f_ofc_entr_lvl_cd.SetSelectCode("");
	f_ofc_inq_lvl_cd.SetSelectCode("");
	f_ofc_brnc_agn_tp_cd.SetSelectCode("");
	f_bank_ctrl_cd.SetSelectCode("");
//	formObj.f_bank_chg_acct_cd.Code   ="";
//	formObcd.Code       ="";
	f_agn_cmb_cd.SetSelectCode("");
	formObj.f_agn_pfx_cd.value="";
//	formObj.f_agn_curr_cd.Code        ="";
	formObj.f_agn_ots_lmt_amt.value="";
	formObj.f_agn_ots_lmt_flg_val.value="";
	f_ots_cate_cd.SetSelectCode("");
	f_ots_cd.SetSelectCode("");
//	formObj.f_ots_ofc_cd.value        ="";
	f_ovpay_tp_cd.SetSelectCode("");
	formObj.f_misc_lss_lmt_amt.value="";
	formObj.f_misc_incm_lmt_amt.value="";
	formObj.f_ots_if_flg_val.value="";
	formObj.f_ots_if_flg.checked=false;
	formObj.f_rep_ots_ofc_cd.value="";
	f_rct_tp_cd.SetSelectCode("");
	f_rct_doc_cd.SetSelectCode("");
	formObj.f_rct_unapy_flg_val.value="";
	formObj.f_rct_unapy_flg.checked=false;
	f_bank_ofc.SetSelectCode("");
	
	f_ofc_wrtf_tp_cd1.SetSelectCode("");
	f_ofc_wrtf_tp_cd2.SetSelectCode("");
	f_ofc_wrtf_tp_cd3.SetSelectCode("");
	f_ofc_wrtf_tp_cd4.SetSelectCode("");
	f_ofc_wrtf_tp_cd5.SetSelectCode("");
	
	f_ofc_adj_tp_cd1.SetSelectCode("");
	f_ofc_adj_tp_cd2.SetSelectCode("");
	f_ofc_adj_tp_cd3.SetSelectCode("");
	f_ofc_adj_tp_cd4.SetSelectCode("");
	f_ofc_adj_tp_cd5.SetSelectCode("");
	
	formObj.f_rct_ofc_tit_nm.value="";
	formObj.f_rct_ofc_addr.value="";
	formObj.f_rct_ofc_telcm_fax_no_ctnt.value="";
	formObj.f_rct_tit_nm.value="";
	formObj.f_rct_rmk.value="";
	formObj.f_rct_spcl_rmk.value="";
	formObj.f_rct_ofc_spcl_no_ctnt.value="";
	formObj.f_ar_prn_tit_nm.value="";
	formObj.f_ar_cr_cust_prn_ctnt.value="";
	formObj.f_ar_prn_ctnt.value="";
	formObj.ref_eml.value="";
}


function f_ofc_wrtf_tp_cd1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var formObj=document.form;	
	var fOfcWrtfTpCd1 = formObj.f_ofc_wrtf_tp_cd1.value;
	var fOfcWrtfTpCd2 = formObj.f_ofc_wrtf_tp_cd2.value;
	var fOfcWrtfTpCd3 = formObj.f_ofc_wrtf_tp_cd3.value;
	var fOfcWrtfTpCd4 = formObj.f_ofc_wrtf_tp_cd4.value;
	var fOfcWrtfTpCd5 = formObj.f_ofc_wrtf_tp_cd5.value;
	
	if ( fOfcWrtfTpCd1 != "" ) {
		if ( fOfcWrtfTpCd1 == fOfcWrtfTpCd2 || fOfcWrtfTpCd1 == fOfcWrtfTpCd3 || fOfcWrtfTpCd1 == fOfcWrtfTpCd4 || fOfcWrtfTpCd1 == fOfcWrtfTpCd5) {
			ComShowCodeMessage("SCO00012", " ## Type [" + fOfcWrtfTpCd1 + "]");
			f_ofc_wrtf_tp_cd1.SetSelectCode("");
		}
	}
}

function f_ofc_wrtf_tp_cd2_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var formObj=document.form;	
	var fOfcWrtfTpCd1 = formObj.f_ofc_wrtf_tp_cd1.value;
	var fOfcWrtfTpCd2 = formObj.f_ofc_wrtf_tp_cd2.value;
	var fOfcWrtfTpCd3 = formObj.f_ofc_wrtf_tp_cd3.value;
	var fOfcWrtfTpCd4 = formObj.f_ofc_wrtf_tp_cd4.value;
	var fOfcWrtfTpCd5 = formObj.f_ofc_wrtf_tp_cd5.value;
	
	if ( fOfcWrtfTpCd2 != "" ) {
		if ( fOfcWrtfTpCd2 == fOfcWrtfTpCd1 || fOfcWrtfTpCd2 == fOfcWrtfTpCd3 || fOfcWrtfTpCd2 == fOfcWrtfTpCd4 || fOfcWrtfTpCd2 == fOfcWrtfTpCd5) {
			ComShowCodeMessage("SCO00012", " ## Type [" + fOfcWrtfTpCd2 + "]");
			f_ofc_wrtf_tp_cd2.SetSelectCode("");
		}
	}
}

function f_ofc_wrtf_tp_cd3_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var formObj=document.form;	
	var fOfcWrtfTpCd1 = formObj.f_ofc_wrtf_tp_cd1.value;
	var fOfcWrtfTpCd2 = formObj.f_ofc_wrtf_tp_cd2.value;
	var fOfcWrtfTpCd3 = formObj.f_ofc_wrtf_tp_cd3.value;
	var fOfcWrtfTpCd4 = formObj.f_ofc_wrtf_tp_cd4.value;
	var fOfcWrtfTpCd5 = formObj.f_ofc_wrtf_tp_cd5.value;
	
	if ( fOfcWrtfTpCd3 != "" ) {
		if ( fOfcWrtfTpCd3 == fOfcWrtfTpCd1 || fOfcWrtfTpCd3 == fOfcWrtfTpCd2 || fOfcWrtfTpCd3 == fOfcWrtfTpCd4 || fOfcWrtfTpCd3 == fOfcWrtfTpCd5) {
			ComShowCodeMessage("SCO00012", " ## Type [" + fOfcWrtfTpCd3 + "]");
			f_ofc_wrtf_tp_cd3.SetSelectCode("");
		}
	}
}

function f_ofc_wrtf_tp_cd4_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var formObj=document.form;	
	var fOfcWrtfTpCd1 = formObj.f_ofc_wrtf_tp_cd1.value;
	var fOfcWrtfTpCd2 = formObj.f_ofc_wrtf_tp_cd2.value;
	var fOfcWrtfTpCd3 = formObj.f_ofc_wrtf_tp_cd3.value;
	var fOfcWrtfTpCd4 = formObj.f_ofc_wrtf_tp_cd4.value;
	var fOfcWrtfTpCd5 = formObj.f_ofc_wrtf_tp_cd5.value;
	
	if ( fOfcWrtfTpCd4 != "" ) {
		if ( fOfcWrtfTpCd4 == fOfcWrtfTpCd1 || fOfcWrtfTpCd4 == fOfcWrtfTpCd2 || fOfcWrtfTpCd4 == fOfcWrtfTpCd3 || fOfcWrtfTpCd4 == fOfcWrtfTpCd5) {
			ComShowCodeMessage("SCO00012", " ## Type [" + fOfcWrtfTpCd4 + "]");
			f_ofc_wrtf_tp_cd4.SetSelectCode("");
		}
	}
}

function f_ofc_wrtf_tp_cd5_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var formObj=document.form;	
	var fOfcWrtfTpCd1 = formObj.f_ofc_wrtf_tp_cd1.value;
	var fOfcWrtfTpCd2 = formObj.f_ofc_wrtf_tp_cd2.value;
	var fOfcWrtfTpCd3 = formObj.f_ofc_wrtf_tp_cd3.value;
	var fOfcWrtfTpCd4 = formObj.f_ofc_wrtf_tp_cd4.value;
	var fOfcWrtfTpCd5 = formObj.f_ofc_wrtf_tp_cd5.value;
	
	if ( fOfcWrtfTpCd5 != "" ) {
		if ( fOfcWrtfTpCd5 == fOfcWrtfTpCd1 || fOfcWrtfTpCd5 == fOfcWrtfTpCd2 || fOfcWrtfTpCd5 == fOfcWrtfTpCd3 || fOfcWrtfTpCd5 == fOfcWrtfTpCd4) {
			ComShowCodeMessage("SCO00012", " ## Type [" + fOfcWrtfTpCd5 + "]");
			f_ofc_wrtf_tp_cd5.SetSelectCode("");
		}
	}
}

function f_ofc_adj_tp_cd1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var formObj=document.form;	
	var fOfcAdjTpCd1 = formObj.f_ofc_adj_tp_cd1.value;
	var fOfcAdjTpCd2 = formObj.f_ofc_adj_tp_cd2.value;
	var fOfcAdjTpCd3 = formObj.f_ofc_adj_tp_cd3.value;
	var fOfcAdjTpCd4 = formObj.f_ofc_adj_tp_cd4.value;
	var fOfcAdjTpCd5 = formObj.f_ofc_adj_tp_cd5.value;
	
	if ( fOfcAdjTpCd1 != "" ) {
		if ( fOfcAdjTpCd1 == fOfcAdjTpCd2 || fOfcAdjTpCd1 == fOfcAdjTpCd3 || fOfcAdjTpCd1 == fOfcAdjTpCd4 || fOfcAdjTpCd1 == fOfcAdjTpCd5) {
			ComShowCodeMessage("SCO00012", " ## Type [" + fOfcAdjTpCd1 + "]");
			f_ofc_adj_tp_cd1.SetSelectCode("");
		}
	}
}

function f_ofc_adj_tp_cd2_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var formObj=document.form;	
	var fOfcAdjTpCd1 = formObj.f_ofc_adj_tp_cd1.value;
	var fOfcAdjTpCd2 = formObj.f_ofc_adj_tp_cd2.value;
	var fOfcAdjTpCd3 = formObj.f_ofc_adj_tp_cd3.value;
	var fOfcAdjTpCd4 = formObj.f_ofc_adj_tp_cd4.value;
	var fOfcAdjTpCd5 = formObj.f_ofc_adj_tp_cd5.value;
	
	if ( fOfcAdjTpCd2 != "" ) {
		if ( fOfcAdjTpCd2 == fOfcAdjTpCd1 || fOfcAdjTpCd2 == fOfcAdjTpCd3 || fOfcAdjTpCd2 == fOfcAdjTpCd4 || fOfcAdjTpCd2 == fOfcAdjTpCd5) {
			ComShowCodeMessage("SCO00012", " ## Type [" + fOfcAdjTpCd2 + "]");
			f_ofc_adj_tp_cd2.SetSelectCode("");
		}
	}
}

function f_ofc_adj_tp_cd3_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var formObj=document.form;	
	var fOfcAdjTpCd1 = formObj.f_ofc_adj_tp_cd1.value;
	var fOfcAdjTpCd2 = formObj.f_ofc_adj_tp_cd2.value;
	var fOfcAdjTpCd3 = formObj.f_ofc_adj_tp_cd3.value;
	var fOfcAdjTpCd4 = formObj.f_ofc_adj_tp_cd4.value;
	var fOfcAdjTpCd5 = formObj.f_ofc_adj_tp_cd5.value;
	
	if ( fOfcAdjTpCd3 != "" ) {
		if ( fOfcAdjTpCd3 == fOfcAdjTpCd1 || fOfcAdjTpCd3 == fOfcAdjTpCd2 || fOfcAdjTpCd3 == fOfcAdjTpCd4 || fOfcAdjTpCd3 == fOfcAdjTpCd5) {
			ComShowCodeMessage("SCO00012", " ## Type [" + fOfcAdjTpCd3 + "]");
			f_ofc_adj_tp_cd3.SetSelectCode("");
		}
	}
}

function f_ofc_adj_tp_cd4_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var formObj=document.form;	
	var fOfcAdjTpCd1 = formObj.f_ofc_adj_tp_cd1.value;
	var fOfcAdjTpCd2 = formObj.f_ofc_adj_tp_cd2.value;
	var fOfcAdjTpCd3 = formObj.f_ofc_adj_tp_cd3.value;
	var fOfcAdjTpCd4 = formObj.f_ofc_adj_tp_cd4.value;
	var fOfcAdjTpCd5 = formObj.f_ofc_adj_tp_cd5.value;
	
	if ( fOfcAdjTpCd4 != "" ) {
		if ( fOfcAdjTpCd4 == fOfcAdjTpCd1 || fOfcAdjTpCd4 == fOfcAdjTpCd2 || fOfcAdjTpCd4 == fOfcAdjTpCd3 || fOfcAdjTpCd4 == fOfcAdjTpCd5) {
			ComShowCodeMessage("SCO00012", " ## Type [" + fOfcAdjTpCd4 + "]");
			f_ofc_adj_tp_cd4.SetSelectCode("");
		}
	}
}

function f_ofc_adj_tp_cd5_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var formObj=document.form;	
	var fOfcAdjTpCd1 = formObj.f_ofc_adj_tp_cd1.value;
	var fOfcAdjTpCd2 = formObj.f_ofc_adj_tp_cd2.value;
	var fOfcAdjTpCd3 = formObj.f_ofc_adj_tp_cd3.value;
	var fOfcAdjTpCd4 = formObj.f_ofc_adj_tp_cd4.value;
	var fOfcAdjTpCd5 = formObj.f_ofc_adj_tp_cd5.value;
	
	if ( fOfcAdjTpCd5 != "" ) {
		if ( fOfcAdjTpCd5 == fOfcAdjTpCd1 || fOfcAdjTpCd5 == fOfcAdjTpCd2 || fOfcAdjTpCd5 == fOfcAdjTpCd3 || fOfcAdjTpCd5 == fOfcAdjTpCd4) {
			ComShowCodeMessage("SCO00012", " ## Type [" + fOfcAdjTpCd5 + "]");
			f_ofc_adj_tp_cd5.SetSelectCode("");
		}
	}
}
