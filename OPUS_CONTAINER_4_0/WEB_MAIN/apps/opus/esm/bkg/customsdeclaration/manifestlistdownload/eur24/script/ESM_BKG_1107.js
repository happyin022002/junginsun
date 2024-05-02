/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : esm_bkg_1107.js
 *@FileTitle: Europe Advanced Manifest : B/L Inquiry - customer Information
 *@author   : CLT
 *@version  : 1.0
 *@since    : 2014/06/24
 =========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
/**
 * @fileoverview JavaScript is commonly used in business as a calendar-related functions have been defined.
 */
/**
 * @extends
 * @class B/L Inquiry : B/L Inquiry business script.
 */

/* Developer Work */
// global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var seal_knd_str="M|E";
var seal_pty_tp_str="CA|SH|AA|CU|AB|AC|TO";
// global variable
var intervalId="";
var temp_cntr_no='';
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/** *** using extra sheet valuable if there are more 2 sheets **** */
	var sheetObject0=sheetObjects[0]; // Tab1 : BL Info
	var sheetObject1=sheetObjects[1]; // Tab2-1 : Container
	var sheetObject2=sheetObjects[2]; // Tab3 : Customer
	var sheetObject3=sheetObjects[3]; // Tab2-2 : Container MF
	var sheetObject4=sheetObjects[4]; // Tab4 : DG
	/** **************************************************** */
	var formObject=document.form;
	// try{
	var srcName=ComGetEvent("name");
	if(ComGetBtnDisable(srcName)) return false;
	switch (srcName) {
	case "btn_Retrieve":
		doActionIBSheet(sheetObject1, formObject, IBSEARCH);
		break;
	case "btn_New":
		doActionIBSheet(sheetObject1, formObject, IBRESET);
		break;
	case "btn_Save":
		doActionIBSheet(sheetObject1, formObject, IBSAVE);
		break;
	case "btn_Mark":
		doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC01);
		break;
	case "btn_Transmit":
		doActionIBSheet(sheetObject1, formObject, MULTI01);
		break;
	case "btn_Close":
		ComClosePopup(); 
		break;
	case "btn_RowAdd1":
		doActionIBSheet(sheetObject2, formObject, IBINSERT);
		break;
	case "btn_RowAdd2":
		doActionIBSheet(sheetObject3, formObject, IBINSERT);
		break;
	case "btn_RowAdd3":
		doActionIBSheet(sheetObject4, formObject, IBINSERT);
		break;
	case "btn_RowDel1":
		doActionIBSheet(sheetObject2, formObject, IBDELETE);
		break;
	case "btn_RowDel2":
		doActionIBSheet(sheetObject3, formObject, IBDELETE);
		break;
	case "btn_RowDel3":
		doActionIBSheet(sheetObject4, formObject, IBDELETE);
		break;
	case "pop_shipper":
		doActionIBSheet(sheetObject1, formObject, COMMAND01);
		break;
	case "pop_fwrd":
		doActionIBSheet(sheetObject1, formObject, COMMAND05);
		break;
	case "pop_consignee":
		doActionIBSheet(sheetObject1, formObject, COMMAND03);
		break;
	case "pop_notify":
		doActionIBSheet(sheetObject1, formObject, COMMAND04);
		break;
	case "btn_MrnDelete":
		doActionIBSheet(sheetObject1, formObject, MULTI02);
		break;
	case "btn_MrnReactivate":
		doActionIBSheet(sheetObject1, formObject, MULTI03);
		break;
	}// end switch
	// }catch(e){
	// if( e == "[object Error]"){
	// ComShowMessage(OBJECT_ERROR);
	// }else{
	// ComShowMessage(e);
	// }
	// }
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * IBMulti Combo Object array
 * 
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj;
}
/**
 * IBTab Object regist array adding process for list in case of needing batch processing with other items
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++]=tab_obj;
}
/**
 * initializing Tab Setting Tab items.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt=0;
			InsertItem( "Customer Info.", "");
			InsertItem( "Container Info.", "");
			InsertItem( "Danger Info.", "");
		}
		break;
	}
}
/**
 * Event when clicking Tab activating selected tab items.
 */
function tab1_OnChange(tabObj, nItem) {
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab].style.display="none";
	// --------------- important --------------------------//
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab=nItem;
}
/**
 * cntr list combo change event
 * 
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function vvd_OnBlur() {
	document.form.vvd_text.value = vvd.GetSelectCode();
}

function vvd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	
	document.form.cstms_yd_cd.value=comboObj.GetText(newCode, 1);
}

/**
 * Combo Object Initialization
 * 
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	switch (comboObj.options.id) {
	case "trsp_mod_id":
		var i=0;
		with (comboObj) {
			SetColBackColor(0,"#FFFFFF");
			SetDropHeight(200);
			SetMultiSelect(0);
			SetMaxSelect(1);
		}
		break;
	case "seal_pty_tp_cd":
		with (comboObj) {
			SetColBackColor(0,"#CCFFFD");
			SetDropHeight(200);
			SetMultiSelect(0);
			SetMaxSelect(1);
		}
		break;
	case "wgt_ut_cd":
		var i=0;
		with (comboObj) {
			SetColBackColor(0,"#FFFFFF");
			SetDropHeight(200);
			SetMultiSelect(0);
			SetMaxSelect(1);
		}
		break;
	case "meas_ut_cd":
		var i=0;
		with (comboObj) {
			SetColBackColor(0,"#FFFFFF");
			SetDropHeight(200);
			SetMultiSelect(0);
			SetMaxSelect(1);
		}
		break;
	case "msg_type":
		var i=0;
		with (comboObj) {
			SetColBackColor(0,"#CCFFFD");
			SetDropHeight(200);
			SetMultiSelect(0);
			SetMaxSelect(1);
		}
		break;
	case "vvd":
		with (comboObj) {
			SetDropHeight(200);
			SetMultiSelect(0);
			SetMaxSelect(1);
		}
		break;
	}
}
var start_bl_no_flag=false;
function loadPage() {
	for (k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		tabObjects[k].SetSelectedIndex(0);
	}
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
		sheetObjects[i].SetWaitImageVisible(0);
	}
	for (i=0; i < comboObjects.length; i++) {
		initCombo(comboObjects[i], i + 1);
	}
	axon_event.addListenerForm("FocusIn", "obj_FocusIn", document.form);
	axon_event.addListenerForm("FocusOut", "obj_FocusOut", document.form);
//	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
//	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('change', 'obj_change', document.form);
	SetComboData(document.form.code_list.value);
	if (document.form.bl_no.value != "") {
		doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
		var formObj=document.form;
		if (vvd.GetItemCount() == 1) {
		} else if (vvd.GetItemCount() > 1) {
			//formObj.vvd.focus();
			ComShowCodeMessage('BKG95001', 'select a VVD|Pofe');
			SetButtonStatus();
			return;
		} else {
			ComShowCodeMessage('BKG03061', 'BL:' + formObj.bl_no.value);
			SetButtonStatus();
			return;
		}
		start_bl_no_flag=true;
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	} else {
		document.form.bl_no.focus();
	}
	SetButtonStatus();
}


/**
 * setting sheet initial values and header param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1":
		with (sheetObj) {
       
	        if (location.hostname != "")
	        var HeadTitle1="| |bl_no|cstms_port_cd|type_cd|msg_func_id|vsl_cd|skd_voy_no|skd_dir_cd|snd_dt|mvmt_ref_no|vvd|vsl_eng_nm|lloyd_no|por_cd|bkg_pol_cd|bkg_pod_cd|del_cd|rcv_term_cd|de_term_cd|pck_qty|pck_tp_cd|act_wgt|wgt_ut_cd|meas_qty|meas_ut_cd|cstms_desc|pol_cd|cstms_yd_cd|eu_stf_flg";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	//        (headCount, 0, 0, true);	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	               {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cstms_port_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"type_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"msg_func_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"skd_voy_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"skd_dir_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"snd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"mvmt_ref_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vsl_eng_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"lloyd_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"por_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"bkg_pol_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"bkg_pod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"del_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"rcv_term_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"de_term_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"pck_qty",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"pck_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"act_wgt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"wgt_ut_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"meas_qty",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"meas_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cstms_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cstms_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"eu_stf_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
	         
	        InitColumns(cols);	
	        SetEditable(1);
	        SetSheetHeight(302);
	        SetWaitImageVisible(0);        
		}
		break;
	case "t1sheet1":
		with (sheetObj) {
       
	        if (location.hostname != "")
	        var HeadTitle1="|Sel.|Seq.|vvd|cstms_port_cd|bl_no|Container No.|TP/SZ|SEAL No. 1|SEAL No. 2|SEAL No. 2|Type|Package|Package|Weight|Weight|Measure|Measure";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	        //(headCount, 0, 0, true);
	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	               {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Sel" },
	               {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cstms_port_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,  AcceptKeys:"E|N" , InputCaseSensitive:1},
	               {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"seal_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:20,  AcceptKeys:"E|N" , InputCaseSensitive:1 },
	               {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"seal_no2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:20,  AcceptKeys:"E|N" , InputCaseSensitive:1 },
	               {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"seal_no3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"full_mty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,  AcceptKeys:"E|N" , InputCaseSensitive:1 },
	               {Type:"Int",       Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pck_qty",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:3,   UpdateEdit:1,   InsertEdit:1},
	               {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:2,  AcceptKeys:"E|N" , InputCaseSensitive:1 },
	               {Type:"Float",     Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"act_wgt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E|N" , InputCaseSensitive:1},
	               {Type:"Float",     Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"meas_qty",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1, EditLen:12,  AcceptKeys:"N" , InputCaseSensitive:1 },
	               {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"meas_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,  EditLen:3,  AcceptKeys:"E|N" , InputCaseSensitive:1 } ];
	         
	        InitColumns(cols);
	        SetEditable(1);
	        SetSheetHeight(130);
	        SetColProperty("full_mty_cd", {ComboText:"F\tFull|P\tEmpty", ComboCode:"F|M"} );
	        SetColProperty("wgt_ut_cd", {ComboText:"KGS|LBS", ComboCode:"KGS|LBS"} );
	        SetShowButtonImage(2);
		}
		break;
	case "t2sheet1":
		with (sheetObj) {
    
		        if (location.hostname != "")
		        var HeadTitle1="|Seq.|bl_no|vvd|cstms_port_cd";
		        HeadTitle1 += "|S_BKG_CUST_TP_CD|S_CUST_CNT_CD|S_CUST_SEQ|S_CUST_NM|S_CUST_ADDR|S_CUST_CTY_NM|S_CSTMS_DECL_CNT_CD|S_CUST_ZIP_ID|S_EUR_CSTMS_ST_NM|S_EORI_NO|S_IBFLAG"
		        HeadTitle1 += "|F_BKG_CUST_TP_CD|F_CUST_CNT_CD|F_CUST_SEQ|F_CUST_NM|F_CUST_ADDR|F_CUST_CTY_NM|F_CSTMS_DECL_CNT_CD|F_CUST_ZIP_ID|F_EUR_CSTMS_ST_NM|F_EORI_NO|F_IBFLAG"
		        HeadTitle1 += "|C_BKG_CUST_TP_CD|C_CUST_CNT_CD|C_CUST_SEQ|C_CUST_NM|C_CUST_ADDR|C_CUST_CTY_NM|C_CSTMS_DECL_CNT_CD|C_CUST_ZIP_ID|C_EUR_CSTMS_ST_NM|C_EORI_NO|C_IBFLAG"
		        HeadTitle1 += "|N_BKG_CUST_TP_CD|N_CUST_CNT_CD|N_CUST_SEQ|N_CUST_NM|N_CUST_ADDR|N_CUST_CTY_NM|N_CSTMS_DECL_CNT_CD|N_CUST_ZIP_ID|N_EUR_CSTMS_ST_NM|N_EORI_NO|N_IBFLAG"
		        var headCount=ComCountHeadTitle(HeadTitle1);
		        //(headCount, 0, 0, true);
		
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		        InitHeaders(headers, info);
		
		        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		               {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cstms_port_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"s_bkg_cust_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"s_cust_cnt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"s_cust_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"s_cust_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"s_cust_addr",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"s_cust_cty_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"s_cstms_decl_cnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"s_cust_zip_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"s_eur_cstms_st_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"s_eori_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"s_ibflag",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"f_bkg_cust_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"f_cust_cnt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"f_cust_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"f_cust_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"f_cust_addr",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"f_cust_cty_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"f_cstms_decl_cnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"f_cust_zip_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"f_eur_cstms_st_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"f_eori_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"f_ibflag",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"c_bkg_cust_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"c_cust_cnt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"c_cust_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"c_cust_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"c_cust_addr",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"c_cust_cty_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"c_cstms_decl_cnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"c_cust_zip_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"c_eur_cstms_st_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"c_eori_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"c_ibflag",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n_bkg_cust_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n_cust_cnt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n_cust_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n_cust_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n_cust_addr",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n_cust_cty_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"n_cstms_decl_cnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"n_cust_zip_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"n_eur_cstms_st_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"n_eori_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"n_ibflag",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		         
        			InitColumns(cols);

        			SetEditable(1);
        			SetVisible(false);
		}
		break;
	case "t3sheet1":
		with (sheetObj) {
      
	        if (location.hostname != "")
	        var HeadTitle1="|Sel.|Seq.|vvd|bl_no|dcgo_seq|cstms_port_cd|Container No.|UN No.|IMDG Class|Pacakge|Pacakge|Gross Weight|Gross Weight";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	       // (headCount, 0, 0, true);
	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		               {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Sel" },
		               {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cstms_port_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:200, Align:"Center",  ColMerge:1,   SaveName:"cntr_no",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14,  AcceptKeys:"E|N" , InputCaseSensitive:1  },
		               {Type:"Text",      Hidden:0,  Width:150, Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4, AcceptKeys:"E|N" , InputCaseSensitive:1  },
		               {Type:"Text",      Hidden:0,  Width:150, Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, AcceptKeys:"E|N" , InputCaseSensitive:1 },
		               {Type:"Int",       Hidden:0,  Width:100, Align:"Center",  ColMerge:1,   SaveName:"pck_qty",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:3,   UpdateEdit:1,   InsertEdit:1},
		               {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E|N" , InputCaseSensitive:1  },
		               {Type:"Float",     Hidden:0,  Width:100, Align:"Center",  ColMerge:1,   SaveName:"grs_wgt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1  },
		               {Type:"Combo",     Hidden:0,  Width:50,  Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1} ];
	         
	        	InitColumns(cols);	
    			SetEditable(1);
    			SetSheetHeight(262);
	            SetColProperty("wgt_ut_cd", {ComboText:"KGS|LBS", ComboCode:"KGS|LBS"} );
		}
		break;
	case "t4sheet1":
		with (sheetObj) {
	       
	        if (location.hostname != "")
	        var HeadTitle1="|Sel.|Seq.|vvd|bl_no|cstms_port_Cd|Container No.|Cntr Seq.|Package|Package|Weight|Weight|Measure|Measure|Mark|Mark|Description|HS";
	        var headCount=ComCountHeadTitle(HeadTitle1);
//	        (headCount, 0, 0, true);
	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	               {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Sel" },
	               {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:1,   SaveName:"Seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"vvd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bl_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cstms_port_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_cgo_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Int",       Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pck_qty",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E|N" , InputCaseSensitive:1   },
	               {Type:"Float",     Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_mf_wgt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Float",     Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"meas_qty",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
	               {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"meas_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, AcceptKeys:"E|N" , InputCaseSensitive:1  },
	               {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cntr_mf_mk_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"MDPop",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0, Width:300,  Align:"Left",    ColMerge:1,   SaveName:"cntr_mf_gds_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_hs_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
	         
	        InitColumns(cols);
			SetEditable(1);
			SetSheetHeight(170);
			SetEllipsis(1);
	        SetColProperty("wgt_ut_cd", {ComboText:"KGS|LBS", ComboCode:"KGS|LBS"} );
	        SetShowButtonImage(2);
	        SetAutoRowHeight(0);

		}
		break;
	case "sheet2":
		with (sheetObj) {
	        if (location.hostname != "")
	            var HeadTitle="||bl_no|cntr_no|seal_no_seq|seal_no|knd_cd|pty_tp|pty_nm|vvd|cstms_port_cd";
	            var headCount=ComCountHeadTitle(HeadTitle);
	//            (headCount, 0, 0, true);
	
	            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Type:"Status",    Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                   {Type:"DummyCheck", Hidden:0, Width:40,    Align:"Center",  ColMerge:0,   SaveName:"sel" },
	                   {Type:"Text",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:140,  Align:"Right",   ColMerge:0,   SaveName:"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:140,  Align:"Right",   ColMerge:0,   SaveName:"seal_no_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:140,  Align:"Right",   ColMerge:0,   SaveName:"seal_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seal_knd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"seal_pty_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"seal_pty_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cstms_port_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	             
	            InitColumns(cols);
				SetEditable(1);
				SetDataAutoTrim(0);
				SetVisible(false);
		}
		break;
	}
}
/**
 * handling sheet process
 */
var err_yn="N";
var ens_edi_svc_flg="N";
var dr_yn="N";
var ata_yn="";
var arn_yn="";
function doActionIBSheet(sheetObj, formObj, sAction, Row, Col) {
	// sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case IBSEARCH: // Retrieve
		if (!validateForm(sheetObj, formObj, sAction)) return false;
		ComOpenWait(true);
		ens_edi_svc_flg == "N"; //ens_edi_svc_flg Initialization
		doActionIBSheet(sheetObj, formObj, COMMAND06);
		formObj.f_cmd.value=SEARCH;
		formObj.vvd.value=comboObjects[0].GetSelectCode();
		var sXml=sheetObj.GetSearchData("ESM_BKG_1107GS.do",FormQueryString(formObj));
		
		
		var arrXml=sXml.split("|$$|");
		var State=ComGetEtcData(arrXml[0], ComWebKey.Trans_Result_Key);
		err_yn=ComGetEtcData(arrXml[0], "err_yn");
		ens_edi_svc_flg=ComGetEtcData(arrXml[0], "ens_edi_svc_flg");
		dr_yn=ComGetEtcData(arrXml[0], "dr_yn");
		ata_yn=ComGetEtcData(arrXml[0], "ata_yn");
		arn_yn=ComGetEtcData(arrXml[0],"arn_yn");
		
		if(ComGetEtcData(arrXml[0],"eu_stf_flg")=="Y"){
			formObj.eu_stf_flg.value="Y"
		}else{
			formObj.eu_stf_flg.value="N"
		}
		
//		if(document.form.eu_stf_flg.value=="Y"){
//			document.getElementById("btn_MrnDelete").style.display='';
//			document.getElementById("btn_MrnReactivate").style.display='';
//		}else{
//			document.getElementById("btn_MrnDelete").style.display='none';
//			document.getElementById("btn_MrnReactivate").style.display='none';
//		}
		
		if (State == "S") {
//			sheetObj.RenderSheet(0);
			ComEtcDataXmlToForm(arrXml[0], formObj);
			formObj.s_eori_no_ori.value=formObj.s_eori_no.value;
			formObj.c_eori_no_ori.value=formObj.c_eori_no.value;
			formObj.n_eori_no_ori.value=formObj.n_eori_no.value;
			formObj.f_eori_no_ori.value=formObj.f_eori_no.value;
			sheetObjects[2].LoadSearchData(arrXml[0],{Sync:1} );
			sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
			sheetObjects[3].LoadSearchData(arrXml[2],{Sync:1} );
			sheetObjects[4].LoadSearchData(arrXml[1],{Sync:1} );
			sheetObjects[4].SelectCell(0, 0);// DG Info
			sheetObjects[5].LoadSearchData(arrXml[3],{Sync:1} );
//			sheetObj.RenderSheet(1);
			if (ComGetEtcData(arrXml[0], "bl_no") == undefined
					&& sheetObjects[0].GetTotalRows()== 0
					&& sheetObjects[2].GetTotalRows()== 0) {
				ComShowCodeMessage("BKG00889"); // No Data Found
			} else {
				
				// UI 수정중 알수없는 함수를 만나 주석처리함 추후에 대체방법을 알게 되면 수정해야함
				formObj.type_cd.value = "I";
				formObj.wgt_ut_cd.value = ComGetEtcData(arrXml[0], "wgt_ut_cd") == "" ? 'KGS': ComGetEtcData(arrXml[0], "wgt_ut_cd");
				formObj.meas_ut_cd.value = ComGetEtcData(arrXml[0], "meas_ut_cd") == "" ? 'CBM': ComGetEtcData(arrXml[0], "meas_ut_cd");
				 if(formObj.pck_qty.value != "") ComAddComma2( formObj.pck_qty.value, "#,###.#");
				if (formObj.act_wgt.value != "")
					AddComma(formObj.act_wgt, "#,###.#");
				if (formObj.meas_qty.value != "")
					AddComma(formObj.meas_qty, "#,###.#");
			}
			temp_cntr_no=sheetObjects[2].GetCellValue(1, 'cntr_no');
			setCMInfo(1);
			//type_cd.SetSelectedIndex(0);
			if( formObj.cstms_yd_cd.value.substring(0,2) == "GB" && formObj.mvmt_ref_no.value != "" && formObj.kts_send_dt.value < "2011012123"){
				ComShowCodeMessage('BKG01142',formObj.bl_no.value,'21th');
			}else if( formObj.cstms_yd_cd.value.substring(0,2) != "GB" && formObj.mvmt_ref_no.value != "" && formObj.kts_send_dt.value < "2011011817"){
				ComShowCodeMessage('BKG01142',formObj.bl_no.value,'18th');
			}
		} else {
			ComShowMessage(ComResultMessage(sXml));
		}
		SetButtonStatus(); // Button GetEnable()d
		ComOpenWait(false);
		break;
	case SEARCH01: // Retrieve
		formObj.f_cmd.value=SEARCH01;
		var val=sheetObj.GetCellValue(Row, Col);
		var params=FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
 		var sXml=sheetObj.GetSearchData("ESM_BKG_1107GS.do", params);
		var cntr_no=ComGetEtcData(sXml, "cntr_no");
		var cntr_tpsz_cd=ComGetEtcData(sXml, "cntr_tpsz_cd");
		if (cntr_no == undefined) {
			ComShowCodeMessage("BKG06012", val);
			sheetObj.SetCellValue(Row, "cntr_no","",0);
			sheetObj.SetCellValue(Row, "cntr_tpsz_cd","",0);
			// sheetObj.ReturnCellData(Row, "cntr_no");
			sheetObj.SelectCell(Row, "cntr_no");
		} else {
			sheetObj.SetCellValue(Row, "cntr_tpsz_cd",cntr_tpsz_cd,0);
			sheetObj.SetCellValue(Row, "cntr_no",cntr_no,0);
		}
		break;
	case SEARCH02: // VVD Combo setting
		formObj.f_cmd.value=SEARCH02;
		//formObj.vvd.RemoveAll();
		//form.cstms_yd_cd.value = "";
 		var sXml=sheetObj.GetSearchData("ESM_BKG_1107GS.do",FormQueryString(formObj));
		var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
		if (State == "S") {
			if(ComGetTotalRows(sXml) =='0'){
				return;
			}
			comboObjects[0].SetMultiSeparator("|");
			ComXml2ComboItem(sXml, comboObjects[0], "vvd","vvd|cstms_yd_cd|vsl_eng_name|lloyd_no", true);
			var arr=new Array();
			var vvd=new Array();
			arr=ComBkgXml2ComboString(sXml, "vvd", "vvd");
			if (arr == undefined || arr == '') {
				//doActionIBSheet(comboObjects[0], formObj, COMMAND06);
				// ComShowCodeMessage("BKG00889"); // No Data Found
				return;
			}
			vvd=arr[0].split(",");
			var vsl_eng_nm=new Array();
			arr=ComBkgXml2ComboString(sXml, "vsl_eng_nm", "vsl_eng_nm");
			vsl_eng_nm=arr[0].split(",");
			var lloyd_no=new Array();
			arr=ComBkgXml2ComboString(sXml, "lloyd_no", "lloyd_no");
			lloyd_no=arr[0].split(",");
			formObj.vsl_eng_nm.value=vsl_eng_nm[0];
			formObj.lloyd_no.value=lloyd_no[0];
			comboObjects[0].SetSelectIndex(0);
			
			var cstms_yd_cd=new Array();
			arr=ComBkgXml2ComboString(sXml, "cstms_yd_cd", "cstms_yd_cd");
			cstms_yd_cd=arr[0].split(",");
			formObj.cstms_yd_cd.value=cstms_yd_cd[0];
			
			return;
		}
		break;
	case MULTI02: // MRN Delete
		if (!validateForm(sheetObj, formObj, MULTI02))
		return false;
		
		formObj.f_cmd.value = MULTI02;
		sheetObj.DoSearch("ESM_BKG_1107GS.do", FormQueryString(formObj));
		
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
		
	break;
		case MULTI03: // MRN Delete
		if (!validateForm(sheetObj, formObj, MULTI03))
		return false;
		
		formObj.f_cmd.value = MULTI03;
		sheetObj.DoSearch("ESM_BKG_1107GS.do", FormQueryString(formObj));
		
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
		
	break;
	case IBROWSEARCH:
		formObj.f_cmd.value=SEARCH03;
		formObj.sheet_id.value=sheetObj.id;
		sheetObj.DoSearch("ESM_BKG_1107GS.do", FormQueryString(formObj) );
		if (sheetObj.RowCount()== 0)
			sheetObj.RemoveAll();
		break;
	case IBRESET: // New
		var bl_no_tmp;
		var cstms_yd_cd_tmp ;
		if (start_bl_no_flag) { 
			cstms_yd_cd_tmp=formObj.cstms_yd_cd.value;
		} else {
			//vvd.RemoveAll();
		}
		formObj.reset();
		formObj.cstms_yd_cd.value=cstms_yd_cd_tmp;
//		formObj.wgt_ut_cd.SetSelectCode("KGS");
//		formObj.meas_ut_cd.SetSelectCode("CBM");
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
		SetButtonStatus(); // Button Disabled
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_Transmit");
		document.form.bl_no.focus();
		break;
	case COMMAND06: // Remove Grid
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
		formObj.s_cust_cnt_cd.value='' ;
		formObj.s_cust_seq.value='' ;
		formObj.s_cust_nm.value='' ;
		formObj.s_cust_addr.value='';
		formObj.s_cust_cty_nm.value='';
		formObj.s_cstms_decl_cnt_cd.value='';
		formObj.s_cust_zip_id.value='';
		formObj.s_eur_cstms_st_nm.value='';
		formObj.s_eori_no.value='';
		formObj.f_cust_cnt_cd.value='' ;
		formObj.f_cust_seq.value='' ;
		formObj.f_cust_nm.value='' ;
		formObj.f_cust_addr.value='';
		formObj.f_cust_cty_nm.value='';
		formObj.f_cstms_decl_cnt_cd.value='';
		formObj.f_cust_zip_id.value='';
		formObj.f_eur_cstms_st_nm.value='';
		formObj.f_eori_no.value='';
		formObj.n_cust_cnt_cd.value='' ;
		formObj.n_cust_seq.value='' ;
		formObj.n_cust_nm.value='' ;
		formObj.n_cust_addr.value='';
		formObj.n_cust_cty_nm.value='';
		formObj.n_cstms_decl_cnt_cd.value='';
		formObj.n_cust_zip_id.value='';
		formObj.n_eur_cstms_st_nm.value='';
		formObj.n_eori_no.value='';
		formObj.c_cust_cnt_cd.value='' ;
		formObj.c_cust_seq.value='' ;
		formObj.c_cust_nm.value='' ;
		formObj.c_cust_addr.value='';
		formObj.c_cust_cty_nm.value='';
		formObj.c_cstms_decl_cnt_cd.value='';
		formObj.c_cust_zip_id.value='';
		formObj.c_eur_cstms_st_nm.value='';
		formObj.c_eori_no.value=''
		SetButtonStatus(); // Button Disabled
		break;
	case IBSAVE: // Save
		if (!validateForm(sheetObj, formObj, IBSAVE))
			return false;
		ComOpenWait(true, true);
		formObj.f_cmd.value=MULTI;
		var sheet2=sheetObjects[1];
		// sheet2.RemoveAll();
		// Customer Info Handling
		if (formObj.s_cust_nm.value == '' && formObj.s_cust_addr.value == ''
				&& formObj.s_cust_cty_nm.value == ''
				&& formObj.s_cstms_decl_cnt_cd.value == ''
				&& formObj.s_cust_zip_id.value == ''
				&& formObj.s_eur_cstms_st_nm.value == ''
				&& formObj.s_eori_no.value == '') {
			formObj.s_ibflag.value='D';
		}
		if (formObj.f_cust_nm.value == '' && formObj.f_cust_addr.value == ''
				&& formObj.f_cust_cty_nm.value == ''
				&& formObj.f_cstms_decl_cnt_cd.value == ''
				&& formObj.f_cust_zip_id.value == ''
				&& formObj.f_eur_cstms_st_nm.value == ''
				&& formObj.f_eori_no.value == '') {
			formObj.f_ibflag.value='D';
		}
		if (formObj.n_cust_nm.value == '' && formObj.n_cust_addr.value == ''
				&& formObj.n_cust_cty_nm.value == ''
				&& formObj.n_cstms_decl_cnt_cd.value == ''
				&& formObj.n_cust_zip_id.value == ''
				&& formObj.n_eur_cstms_st_nm.value == ''
				&& formObj.n_eori_no.value == '') {
			formObj.n_ibflag.value='D';
		}
		if (formObj.c_cust_nm.value == '' && formObj.c_cust_addr.value == ''
				&& formObj.c_cust_cty_nm.value == ''&& formObj.c_cstms_decl_cnt_cd.value == ''
				&& formObj.c_cust_zip_id.value == ''&& formObj.c_eur_cstms_st_nm.value == ''&& formObj.c_eori_no.value == '') {
			formObj.c_ibflag.value='D';
		}
		var params='';
		params += FormQueryString(formObj);
		params += "&"+ ComSetPrifix(ComGetSaveString(sheetObjects[0], false, true),	"t1_");
		params += "&"+ ComSetPrifix(ComGetSaveString(sheetObjects[3], false, true),	"t5_");// CNTR MF Info
		params += "&"+ ComSetPrifix(ComGetSaveString(sheetObjects[2], false, true),	"t3_");// CNTR Info
		params += "&"+ ComSetPrifix(ComGetSaveString(sheetObjects[4], false, true), "t4_");// DG Info
		params += "&"+ ComSetPrifix(ComGetSaveString(sheetObjects[5], false, true),	"t6_");// CNTR SEAL
		// formObj.flatfile.value = params;
		// alert(ComSetPrifix(ComGetSaveString(sheetObjects[2], false, true),
		// "t3_"));
 		var sXml=sheetObj.GetSaveData("ESM_BKG_1107GS.do", params);
		var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
		if (State == "S") {
//			sheetObj.RenderSheet(0);
			sheetObj.LoadSearchData(sXml,{Sync:1} );
//			sheetObj.RenderSheet(1);
			ComOpenWait(false);
			// ComShowCodeMessage("BKG00166"); // Data Saved Successfully!!
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		} else {
			ComOpenWait(false);
			ComShowMessage(ComResultMessage(sXml));
		}
		break;
	case IBINSERT:// Row Add
		var row=GetAddRowIndex(sheetObj);
		break;
	case IBDELETE:// Row Del
		var sheetID=sheetObj.id;
		if (sheetObj.CheckedRows(1) == 0) {
			ComShowCodeMessage('BKG00249'); // No Selected Row
			return;
		}
		ComShowCodeMessage('BKG03037');
		ComRowHideDelete(sheetObj, "Sel");
		var selectedRow=sheetObj.GetSelectRow();
		if (sheetID == 't1sheet1') {
			// CNTR MF sheet Info Remove
			var maxLength=sheetObjects[3].RowCount();
			for ( var i=1; i <= maxLength; i++) {
				if (sheetObjects[3].GetCellValue(i, "cntr_no").trim() == sheetObjects[2].GetCellValue(selectedRow, "cntr_no").trim()) {
					sheetObjects[3].SetRowHidden(i,1);// Row Hidden
					sheetObjects[3].SetRowStatus(i,"D");// Row Status=D
				}
			}
			// Seal No sheet  Info Remove
			maxLength=sheetObjects[5].RowCount();
			for ( var i=1; i <= maxLength; i++) {
				if (sheetObjects[5].GetCellValue(i, "cntr_no").trim() == sheetObjects[2].GetCellValue(selectedRow, "cntr_no").trim()) {
					sheetObjects[5].SetRowHidden(i,1);// Row Hidden
					sheetObjects[5].SetRowStatus(i,"D");// Row Status=D
				}
			}
		}
		break;
	case IBSEARCH_ASYNC01: // Mark
		ComOpenWindowCenter("ESM_BKG_1036.do?pgmNo=ESM_BKG_1036&bl_mk_desc="+ formObj.bl_mk_desc.value, "ESM_BKG_1036", 330, 248);
		break;
	case MULTI01: // Transmit Manifest
		if (!ComShowConfirm(ComGetMsg("BKG95003", "Transmit"))) {
			return false;
		}
		if (err_yn != "N") { // Error
			ComShowCodeMessage("BKG01133", document.form.bl_no.value, "");
			return;
		}
		if (dr_yn != "N") {
			ComShowCodeMessage("BKG01138", vvd.value, "");
			return;
		}
		if (arn_yn == "Y") {
			ComShowCodeMessage('BKG01145',vvd.value);
			return;    
		}
		var reg=/^[A-Z]{2}([a-zA-Z0-9]{1,15}$)/; 
		var reg2=/TEST|NONE/;
		var temp_eori_no=formObj.s_eori_no_ori.value;
		if (temp_eori_no != ""
				&& (!reg.test(temp_eori_no) || reg2.test(temp_eori_no
						.toUpperCase()))) {
			ComShowCodeMessage('BKG01143', 'Shipper ');
			formObj.s_eori_no.focus();
			return;
		}
		temp_eori_no=formObj.c_eori_no_ori.value;
		if (temp_eori_no != ""&& (!reg.test(temp_eori_no) || reg2.test(temp_eori_no.toUpperCase()))) {
			ComShowCodeMessage('BKG01143', 'Consignee ');
			formObj.c_eori_no.focus();
			return;
		}
		temp_eori_no=formObj.f_eori_no_ori.value;
		if (temp_eori_no != ""
				&& (!reg.test(temp_eori_no) || reg2.test(temp_eori_no.toUpperCase()))) {
			ComShowCodeMessage('BKG01143', 'FWRD ');
			formObj.f_eori_no.focus();
			return;
		}
		temp_eori_no=formObj.n_eori_no_ori.value;
		if (temp_eori_no != ""&& (!reg.test(temp_eori_no) || reg2.test(temp_eori_no.toUpperCase()))) {
			ComShowCodeMessage('BKG01143', 'Notify ');
			formObj.n_eori_no.focus();
			return;
		}
//		alert(vvd.GetSelectCode());
		var vvd= formObj.vvd.value;
		var sParam="ibflag=U" + "&" + "p_send_yn=Y&" + "vsl_cd="+ vvd.substring(0, 4) + "&" + "skd_voy_no="
				+ vvd.substring(4, 8) + "&" + "skd_dir_cd="
				+ vvd.substring(8, 9) + "&" + "bl_no=" + formObj.bl_no.value
				+ "&" + "eu_1st_port=" + formObj.cstms_port_cd.value;
		formObj.f_cmd.value=MULTI01;
		sParam += "&" + FormQueryString(formObj);
		ComOpenWait(true, true);
 		var sXml=sheetObj.GetSaveData("ESM_BKG_1106GS.do", sParam);
		var key=ComGetEtcData(sXml, "KEY");
		intervalId=setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
		break;
	case COMMAND01: // save
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH04;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.cust_type.value="S";
 			sheetObj.DoSearch("ESM_BKG_1107GS.do", FormQueryString(formObj) );
			ComOpenWait(false);
		}
		break;
	case COMMAND05: // save
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH04;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.cust_type.value="F";
 			sheetObj.DoSearch("ESM_BKG_1107GS.do", FormQueryString(formObj) );
			ComOpenWait(false);
		}
		break;
	case COMMAND03: // save
		// alert("test3");
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH04;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.cust_type.value="C";
 			sheetObj.DoSearch("ESM_BKG_1107GS.do", FormQueryString(formObj) );
			ComOpenWait(false);
		}
		break;
	case COMMAND04: // save
		// alert("test3");
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH04;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.cust_type.value="N";
 			sheetObj.DoSearch("ESM_BKG_1107GS.do", FormQueryString(formObj) );
			ComOpenWait(false);
		}
		break;
	}
}
/**
 * BackEndJob Result Validation<br>
 * 
 * @param sheetObj
 * @param sKey
 */
function doActionValidationResult(sheetObj, sKey) {
 	var sXml=sheetObj.GetSearchData("ESM_BKG_1106GS.do?f_cmd=" + SEARCH03+ "&key=" + sKey);
	var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
	// ComShowMessage("doActionValidationResult "+sJbStsFlg);
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		// Success Msg
		ComShowCodeMessage('BKG00101');
		// resultlist.innerHTML = "<pre>"+ ComGetEtcData(sXml,
		// "RESULT")+"</pre>";
		return;
	} else if (sJbStsFlg == "FAIL") {
		// Error
		clearInterval(intervalId);
		ComOpenWait(false);
		// Error Msg
		ComShowMessage(ComResultMessage(sXml));
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // Retrieve
		
		if (ComIsNull(formObj.bl_no)) {
			ComShowCodeMessage('BKG00104', 'B/L No.');
			formObj.bl_no.focus();
			return false;
		}
//		alert(formObj.cstms_yd_cd.value);
//		alert(ComIsNull(formObj.cstms_yd_cd));
//		if (ComIsNull(formObj.cstms_yd_cd) || formObj.cstms_yd_cd.value == 'undefined') {
//			ComShowCodeMessage('BKG00104', 'VVD');
//			return false;
//		}
		return true;
		break;
	case IBSAVE: // save
		var sheetObj1=sheetObjects[2];// CNTR
		for ( var i=1; i < sheetObj1.RowCount()+ 1; i++) {
			if (sheetObj1.GetCellValue(i, "cntr_no") == "") {
				// alert("[Container Info.] Container No. is Mandatory item.");
				ComShowCodeMessage('BKG00104', 'Container Info.');
				tabObjects[0].SetSelectedIndex(1);
				sheetObj1.SelectCell(i, "cntr_no");
				return false;
			}
			
		}
		var sheetObj3=sheetObjects[4];// DG
		for ( var i=1; i < sheetObj3.RowCount()+ 1; i++) {
			if (sheetObj3.GetCellValue(i, "cntr_no") == "") {
				// alert("[Danger Info.] Container No. is Mandatory item.");
				ComShowCodeMessage('BKG00104', 'Danger Container Info.');
				tabObjects[0].SetSelectedIndex(2);
				sheetObj3.SelectCell(i, "cntr_no");
				return false;
			}
		}
		
		if (!ComShowCodeConfirm("BKG00350")){
			return false;
		}
		return true;
		break;
	case MULTI02: // 저장
		if(!ComShowCodeConfirm('COM12194', 'MRN'))
			return false;
	
		return true;
	break;
	
	case MULTI03: // 저장
		if(!ComShowCodeConfirm('BKG95003', 'reactivate MRN'))
			return false;
	
		return true;
	break;
	case COMMAND01: // Retrieve
		var cust_cnt;
		var cust_seq;
		cust_cnt=formObj.s_cust_cnt_cd;
		cust_seq=formObj.s_cust_seq;
		if (!ComChkObjValid(cust_cnt)|| !ComChkObjValid(cust_seq, true, true, false))
			return false;
		return true;
		break;
	case COMMAND05: // Retrieve
		var cust_cnt;
		var cust_seq;
		cust_cnt=formObj.f_cust_cnt_cd;
		cust_seq=formObj.f_cust_seq;
		if (!ComChkObjValid(cust_cnt)|| !ComChkObjValid(cust_seq, true, true, false))
			return false;
		return true;
		break;
	case COMMAND03: // Retrieve
		var cust_cnt;
		var cust_seq;
		cust_cnt=formObj.c_cust_cnt_cd;
		cust_seq=formObj.c_cust_seq;
		if (!ComChkObjValid(cust_cnt)|| !ComChkObjValid(cust_seq, true, true, false))
			return false;
		return true;
		break;
	case COMMAND04: // Retrieve
		var cust_cnt;
		var cust_seq;
		cust_cnt=formObj.n_cust_cnt_cd;
		cust_seq=formObj.n_cust_seq;
		if (!ComChkObjValid(cust_cnt)|| !ComChkObjValid(cust_seq, true, true, false))
			return false;
		return true;
		break;
	}
}
/**
 * t1sheet1 On Change Event Handling
 */
function t1sheet1_OnChange(sheetObj, row, col, val) {
	var formObject=document.form;
	var col_save_name=sheetObj.ColSaveName(col);
	if (sheetObj.ColSaveName(col) == "cntr_no"&& sheetObj.GetCellValue(row, "cntr_no") != "") {
		for ( var i=1; i <= sheetObj.LastRow(); i++) {
			if (i == row)
				continue;
			if (sheetObj.GetCellValue(i, "cntr_no") == sheetObj.GetCellValue(row,"cntr_no")) {
				// "Container No. [{?msg1}] is duplicated. Check container
				// number.
				ComShowCodeMessage("BKG00965", sheetObj.GetCellValue(row,"cntr_no"));
				sheetObj.SetCellValue(row, "cntr_no","",0);
				sheetObj.SelectCell(row, "cntr_no");
				return;
			}
		}
		doActionIBSheet(sheetObj, document.form, SEARCH01, row, col);
		temp_cntr_no=sheetObj.GetCellValue(row, "cntr_no");
	}
	var bl_no=sheetObj.GetCellValue(row, "bl_no");
	var cntr_no=sheetObj.GetCellValue(row, "cntr_no").toUpperCase();
	/* seal_no */
	if (col_save_name == "seal_no" || col_save_name == "seal_no2") {
		var fmObject=sheetObjects[5];
		var arrRow=findText(fmObject, "cntr_no", cntr_no);
		var len=arrRow.length;
		if (len <= 1) {
			if (val != '') {
				var newRow=fmObject.DataInsert(-1);
				fmObject.SetCellValue(newRow, "bl_no",bl_no,0);
				fmObject.SetCellValue(newRow, "cntr_no",cntr_no,0);
				fmObject.SetCellValue(newRow, "seal_no",val,0);
			} else {
				if (col_save_name == "seal_no") {
					fmObject.SetCellValue(arrRow[0], "seal_no",val,0);
				} else {
					fmObject.SetCellValue(arrRow[0], "seal_no",val,0);
				}
			}
		} else {
			if (col_save_name == "seal_no") {
				fmObject.SetCellValue(arrRow[0], "seal_no",val,0);
			} else {
				fmObject.SetCellValue(arrRow[1], "seal_no",val,0);
			}
		}
		rowDelete(fmObject, "seal_no", '');
		setAllSealNo();
	}
}
/**
 * t3sheet1 On Change Event Handling
 */
function t3sheet1_OnChange(sheetObj, row, col, val) {
	var formObject=document.form;
	var col_save_name=sheetObj.ColSaveName(col);
	if (sheetObj.ColSaveName(col) == "cntr_no" && sheetObj.GetCellValue(row, "cntr_no") != "") {
		/*
		 * for(var i=1; i<=sheetObj.LastRow; i++){ if(i == row) continue;
		 * if(sheetObj.CellValue(i, "cntr_no") == sheetObj.CellValue(row,
		 * "cntr_no")){ //"Container No. [{?msg1}] is duplicated. Check
		 * container number. ComShowCodeMessage("BKG00965",
		 * sheetObj.CellValue(row, "cntr_no")); sheetObj.CellValue2(row,
		 * "cntr_no") = ""; sheetObj.SelectCell(row, "cntr_no"); return; } }
		 */
		doActionIBSheet(sheetObj, document.form, SEARCH01, row, col);
	}
}
/**
 * t4sheet1 On Change Event Handling
 */
function t4sheet1_OnChange(sheetObj, row, col, val) {
}
/**
 * Form Focus In Event Handling
 */
function obj_FocusIn() {
	var srcObj=window.ComGetEvent();
	var srcName=ComGetEvent("name");
	var srcValue=window.event.srcElement.getAttribute("value");
	// if(srcName == "pck_qty" || srcName == "act_wgt" || srcName ==
	// "meas_qty"){
	if (srcName == "act_wgt" || srcName == "meas_qty") {
		srcObj.style.textAlign="left";
		if (srcValue.substr(srcValue.length - 4) == ".000") {
			srcObj.value=srcValue.substr(0, srcValue.length - 4);
		}
	}
	if (srcName == "temp") {
		srcObj.style.textAlign="left";
		if (srcValue == "0.0") {
			srcObj.value="";
		}
	}
}
/**
 * Form Focus Out Event Handling
 */
function obj_FocusOut() {
	var srcObj=window.ComGetEvent();
	var srcName=ComGetEvent("name");
	var srcValue=window.event.srcElement.getAttribute("value");
	// if(srcName == "pck_qty" || srcName == "act_wgt" || srcName ==
	// "meas_qty"){
	if (srcName == "act_wgt" || srcName == "meas_qty") {
		srcObj.style.textAlign="right";
		AddComma(srcObj, "#,###.#");
	}
	if (srcName == "temp") {
		srcObj.style.textAlign="right";
		if (srcValue == "") {
			srcObj.value="0.0";
		} else {
			AddComma(srcObj, "#,###.#");
		}
	}
}
/**
 * Key Up Event Handling
 */
function obj_KeyUp() {
	var formObj=document.form;
	var srcObj=window.ComGetEvent();
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	if (srcName == "" || srcName == "act_wgt" || srcName == "meas_qty") {
		AddComma(srcObj, "#,###.###", srcMaxLength);
	}
	if (srcName == "temp") {
		AddComma(srcObj, "#,###.##", srcMaxLength);
	}
	if ((srcName == "s_cust_cnt_cd" || srcName == "f_cust_cnt_cd"|| srcName == "c_cust_cnt_cd" || srcName == "n_cust_cnt_cd")
			&& ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}
/**
 * Form Change Event Handling
 * 
 * @return
 */
function obj_change() {
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (srcName == "bl_no") {
		var cstms_yd_cd_tmp ;
		if (start_bl_no_flag) {
			cstms_yd_cd_tmp = formObj.cstms_yd_cd.value;
		} else {
			formObj.cstms_yd_cd.value = "";
			//vvd.RemoveAll();
		}
		
		formObj.cstms_yd_cd.value = cstms_yd_cd_tmp;
		//
		doActionIBSheet(sheetObjects[0], formObj, COMMAND06);
		doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
	}
}


/**
 * Form data Initialization
 */
function initFormData() {
	var frmChild=document.getElementsByTagName("input");
	for ( var i=0; i < frmChild.length; i++) {
		if (frmChild[i].type == "text" && frmChild[i].name != "bl_no") {
			frmChild[i].value="";
		}
		if (frmChild[i].type == "hidden") {
			if (frmChild[i].name == "bl_mk_desc"
					|| frmChild[i].name == "bkg_pol_cd"
					|| frmChild[i].name == "bkg_pod_cd"
					|| frmChild[i].name == "chn_mf_snd_ind_cd") {
				frmChild[i].value="";
			}
		}
		if (frmChild[i].type == "checkbox") {
			frmChild[i].checked=false;
		}
	}
	wgt_ut_cd.SetSelectCode("KGS");
	meas_ut_cd.SetSelectCode("CBM");
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
}
/**
 * Add Comma Function
 */
function AddComma(obj, sFormat, len) {
	try {
		var sVal=obj.value.replace(/\,/g, "");
		switch (sFormat) {
		case "#,###":
			obj.value=ComAddComma(sVal);
			break;
		case "#,###.#":
			if (sVal == ".")
				sVal="0.";
			p=sVal.split(".");
			p[0]=ComAddComma(p[0]);
			if (p.length <= 1)
				obj.value=p[0] + ".000";
			else if (p.length == 2)
				obj.value=p[0] + "." + p[1].substr(0, 3);
			else if (p.length > 2)
				obj.value=p[0] + "." + p[1].substr(0, 3);
			else
				sVal="";
			break;
		case "#,###.##":
			if (sVal == ".")
				sVal="0.";
			p=sVal.split(".");
			p[0]=ComAddComma(p[0]);
			if (p.length <= 1) {
				if (p[0].length > len - 3) {
					sVal=p[0].substr(0, len - 3).replace(/\,/g, "");
					p[0]=ComAddComma(sVal);
				}
				obj.value=p[0];
			} else if (p.length == 2)
				obj.value=p[0] + "." + p[1].substr(0, 2);
			else if (p.length > 2)
				obj.value=p[0] + "." + p[1].substr(0, 2);
			else
				sVal="";
			break;
		case "#,###.###":
			if (sVal == ".")
				sVal="0.";
			p=sVal.split(".");
			p[0]=ComAddComma(p[0]);
			if (p.length <= 1) {
				if (p[0].length > len - 4) {
					sVal=p[0].substr(0, len - 3).replace(/\,/g, "");
					p[0]=ComAddComma(sVal);
				}
				obj.value=p[0];
			} else if (p.length == 2)
				obj.value=p[0] + "." + p[1].substr(0, 3);
			else if (p.length > 2)
				obj.value=p[0] + "." + p[1].substr(0, 3);
			else
				sVal="";
			break;
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}
/**
 * Row Add Event Handling
 */
function GetAddRowIndex(sheetObj) {
	if (sheetObj.id == "t4sheet1" && temp_cntr_no == '') {
		ComShowCodeMessage('BKG00104', 'Container No.');
		return;
	}
	var row=sheetObj.DataInsert(-1);
	sheetObj.SetCellValue(row, "vvd",vvd.value,0);
	sheetObj.SetCellValue(row, "cstms_port_cd",document.form.cstms_port_cd.value,0);
	sheetObj.SetCellValue(row, "bl_no",document.form.bl_no.value,0);
	// alert(sheetObj.CellValue(row, "vvd") + " : " + sheetObj.CellValue(row,
	// "cstms_port_cd") + " : " + sheetObj.CellValue(row, "bl_no"));
	if (sheetObj.id == "t4sheet1") {
		setSeq();
		sheetObj.SetCellValue(row, "cntr_no",temp_cntr_no,0);
	}
	return row;
}
/**
 * Button Handling
 */
function SetButtonStatus() {
	if (document.form.bl_no.value == "" || document.form.cstms_yd_cd.value == "" || document.form.cstms_yd_cd.value == 'undefined') {
		ComBtnDisable("btn_RowAdd1");
		ComBtnDisable("btn_RowDel1");
		ComBtnDisable("btn_RowAdd2");
		ComBtnDisable("btn_RowDel2");
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_Transmit");
		ComBtnDisable("btn_Mark");
	} else {
		ComBtnEnable("btn_RowAdd1");
		ComBtnEnable("btn_RowDel1");
		ComBtnEnable("btn_RowAdd2");
		ComBtnEnable("btn_RowDel2");
		ComBtnEnable("btn_Save");
		if (ens_edi_svc_flg == "Y")
			ComBtnEnable("btn_Transmit");
		else
			ComBtnDisable("btn_Transmit");
		ComBtnEnable("btn_Mark");
	}
	if(document.form.eu_stf_flg.value=="Y"){
			document.getElementById("btn_MrnDelete").style.display='';
			document.getElementById("btn_MrnReactivate").style.display='';
	}else{
			document.getElementById("btn_MrnDelete").style.display='none';
			document.getElementById("btn_MrnReactivate").style.display='none';
	}
}
/**
 * Set Combo Data
 */
function SetComboData(sXml) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var arrXml=sXml.split("|$$|");
	var arrCombo;
	ComXml2ComboItem(arrXml[0], formObj.trsp_mod_id, "val", "desc");
	ComXml2ComboItem(arrXml[2], formObj.seal_pty_tp_cd, "val", "desc");
	ComXml2ComboItem(arrXml[3], formObj.wgt_ut_cd, "val", "desc");
	ComXml2ComboItem(arrXml[4], formObj.meas_ut_cd, "val", "desc");
//	formObj.wgt_ut_cd.SetSelectCode("KGS");
//	formObj.meas_ut_cd.SetSelectCode("CBM");
	// ComXml2ComboItem(arrXml[5], formObj.msg_type, "attr_ctnt1",
	// "attr_ctnt2");
	// if(formObj.trans_mode.value == "D"){
	// formObj.msg_type.Code = '0';
	// }else{
	// formObj.msg_type.Code = '9';
	// }
	// arrCombo = ComXml2ComboString(arrXml[1], "desc", "val");
	// sheetObj.InitDataCombo(0, "seal_knd_cd", " |"+arrCombo[0], "
	// |"+arrCombo[1]);
	// arrCombo = ComXml2ComboString(arrXml[2], "desc", "val");
	// sheetObj.InitDataCombo(0, "seal_pty_tp_cd", " |"+arrCombo[0], "
	// |"+arrCombo[1]);
	arrCombo=ComXml2ComboString(arrXml[3], "desc", "val");
	// sheetObj.InitDataCombo(0, "wgt_ut_cd", arrCombo[0], arrCombo[1]);
	arrCombo=ComXml2ComboString(arrXml[4], "desc", "val");
	// sheetObj.InitDataCombo(0, "meas_ut_cd", arrCombo[0], arrCombo[1]);
}
/**
 * sheet1 On Change Event Handling
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj=document.form;
	if (sheetObj.ColSaveName(Col) == "bl_no") {
		formObj.f_cmd.value=SEARCH01;
		formObj.strLocCd.value=sheetObj.GetCellValue(Row, Col);
		if (formObj.strLocCd.value != "") {
			doActionIBSheet(sheetObj, formObj, SEARCH01);
		}
	}
}
/**
 * t1sheet1 On Click Event Handling
 */
function t1sheet1_OnClick(sheetObj, Row, Col) {
	 if(sheetObj.ColSaveName(Col) == "full_mty_cd") return;
	temp_cntr_no=sheetObj.GetCellValue(Row, 'cntr_no');
	setCMInfo(Row);
	sheetObj.SelectCell(Row, sheetObj.ColSaveName(Col));
}
/**
 * t1sheet2 On Search End Event Handling
 */
function t1sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	if (ErrMsg != "")
		return;
	var formObj=document.form;
	if (sheetObj.RowCount()> 0) {
		setCMInfo(1);
		// alert(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "Seq"));
		t1sheet1_OnClick(sheetObjects[2], sheetObjects[2].GetSelectRow(),
				sheetObjects[2].SaveNameCol("cntr_no"));
	}
}

function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if (ErrMsg != "")
		return;
	
	var formObj=document.form;
	
	if (formObj.f_cmd.value == SEARCH04)
	{
		switch(formObj.cust_type.value)
		{
			case "S":
				formObj.s_cust_nm.value=sheetObj.GetEtcData("s_cust_nm") == undefined ? '': sheetObj.GetEtcData("s_cust_nm");
				formObj.s_cust_addr.value=sheetObj.GetEtcData("s_cust_addr") == undefined ? '': sheetObj.GetEtcData("s_cust_addr");
				break;
			case "F":
				formObj.f_cust_nm.value=sheetObj.GetEtcData("f_cust_nm") == undefined ? '': sheetObj.GetEtcData("f_cust_nm");
				formObj.f_cust_addr.value=sheetObj.GetEtcData("f_cust_addr") == undefined ? '': sheetObj.GetEtcData("f_cust_addr");
				break;
			case "C":
				formObj.c_cust_nm.value=sheetObj.GetEtcData("c_cust_nm") == undefined ? '' : sheetObj.GetEtcData("c_cust_nm");
				formObj.c_cust_addr.value=sheetObj.GetEtcData("c_cust_addr") == undefined ? '' : sheetObj.GetEtcData("c_cust_addr");
				break;
			case "N":
				formObj.n_cust_nm.value=sheetObj.GetEtcData("n_cust_nm") == undefined ? '': sheetObj.GetEtcData("n_cust_nm");
				formObj.n_cust_addr.value=sheetObj.GetEtcData("n_cust_addr") == undefined ? '': sheetObj.GetEtcData("n_cust_addr");
				break;
		}
	}
}

/**
 * t1sheet On Popup Click Event Handling
 */
function t1sheet1_OnPopupClick(sheetObj, row, col) {
var bl_no=sheetObj.GetCellValue(row, "bl_no");
var cntr_no=sheetObj.GetCellValue(row, "cntr_no");
	var url="ESM_BKG_0697.do?bl_no=" + bl_no + "&cntr_no=" + cntr_no;
	ComOpenWindowCenter(url, "ESM_BKG_0697", 600, 390, true);
//	ComOpenPopup(url,  "600", "390","","1,0", false);
}
function t4sheet1_OnPopupClick(sheetObj, row, col) {
	// alert(sheetObj.id + " -> " + sheetObj.ColSaveName(col));
	var col_name=sheetObj.ColSaveName(col);
	switch (col_name) {
	case "MDPop":
//		var frm2=document.form;
//		var width=450;
//		var height=410;
//		var left=(screen.width - width) / 2;
//		var top=(screen.height - height) / 2;
//		var win=window.open("",	"ESM_BKG_0706","width="+ width+ ",height="+ height + ",left="  + left + ",top=" + top + ",toolbar=no,directories=no,status=no,scrollbars=no,resizable=no,modal=yes");
//		frm2.mk_desc.value=sheetObj.GetCellValue(row, "cntr_mf_mk_desc");
//		frm2.gds_desc.value=sheetObj.GetCellValue(row, "cntr_mf_gds_desc");
//		frm2.func.value="callbackMFDesc";
//		frm2.action="ESM_BKG_0706.do";
//		frm2.method="POST";
//		frm2.target="ESM_BKG_0706";
//		frm2.submit();
		var url="ESM_BKG_0706.do?mk_desc=" + sheetObj.GetCellValue(row, "cntr_mf_mk_desc") +
		                        "&gds_desc=" + sheetObj.GetCellValue(row, "cntr_mf_gds_desc");
		ComOpenPopup(url,"550","450","callbackMFDesc","1,0",true);
//		ComOpenWindowCenter(url, "ESM_BKG_0697", 600, 390, true);
		break;
	} // end switch
}
function callbackMFDesc(mk_desc, gds_desc) {
	sheetObjects[3].SetCellValue(sheetObjects[3].GetSelectRow(), "cntr_mf_mk_desc",mk_desc,0);
	sheetObjects[3].SetCellValue(sheetObjects[3].GetSelectRow(), "cntr_mf_gds_desc",gds_desc,0);
	// document.form.dirty_flag.value = 'Y'
}
/**
 * Set CM Info
 */
var cmTotal;
function setCMInfo(row) {
	// alert("selectCM : " + row);
	if (row > 0) {
		// retrieve CM
		showAndHideSheet(sheetObjects[3], "cntr_no", sheetObjects[2].GetCellValue(row, "cntr_no"));
		// rearangeSeq
		setSeq();
		// calculate sum
		// syncQuantity("pck_qty");
		// syncQuantity("grs_wgt");
		// sheetObjects[2].SelectCell(row,"cntr_no");
	}
}
/**
 * Sheet Show And Hide Function
 */
function showAndHideSheet(sheetObj, colName, colValue) {
	var rcnt=sheetObj.RowCount()+ 2;
	for (rn=1; rn < rcnt; rn++) {
		// alert(sheetObj.CellValue(rn, colName));
		if (sheetObj.GetRowStatus(rn) != 'D'&& sheetObj.GetCellValue(rn, colName) == colValue) {
			sheetObj.SetRowHidden(rn,0);
		} else {
			sheetObj.SetRowHidden(rn,1);
		}
	}
}
/**
 * Row Delete Btn Click Event Handling
 */
function rowDelete(sheetObj, colName, colValue) {
	var arrRow=findText(sheetObj, colName, colValue);
	for (ir=0; ir < arrRow.length; ir++) {
		if (arrRow[arrRow.length - 1 - ir] == '')
			continue;
		sheetObj.SetRowHidden(arrRow[arrRow.length - 1 - ir],1);
		sheetObj.SetRowStatus(arrRow[arrRow.length - 1 - ir],'D');
	}
}
/**
 * Set Seq Function
 */
function setSeq() {
	var rSeq=0;
	var rCnt=sheetObjects[3].RowCount();
	for (rn=1; rn <= rCnt; rn++) {
		var rsts=sheetObjects[3].GetRowStatus(rn);
		if (sheetObjects[3].GetRowHidden(rn))
			continue;
		// if(rsts != 'D' && sheetObjects[3].CellValue(rn, "Sel") == '0'){
		sheetObjects[3].SetCellValue(rn, "Seq",++rSeq,0);
		// sheetObjects[3].RowStatus(rn) = rsts;
		if (rSeq == 1)
			sheetObjects[3].SelectCell(0, 0);
	}
}
/**
 * All Container Seal No set
 */
function setAllSealNo() {
	var cntrObj=sheetObjects[2];
	var cntrCount=cntrObj.RowCount()+ 1;
	for (idx=1; idx < cntrCount; idx++) {
		setSealNo(cntrObj.GetCellValue(idx, "cntr_no"));
	}
}
/**
 * Find Column Index Function
 */
function findText(sheetObj, colName, colValue) {
	var idxs=new Array();
	var rcnt=sheetObj.RowCount()+ 1;
	for (ix=1; ix < rcnt; ix++) {
		if (sheetObj.GetRowStatus(ix) != 'D' && sheetObj.GetCellValue(ix, colName) == colValue) {
			idxs.push('' + ix);
		}
	}
	return idxs;
}
/**
 * Set Seal No Function
 */
function setSealNo(cntr_no) {
	var fmObject=sheetObjects[5]; // SealNo Hidden Sheet
	var toObject=sheetObjects[2]; // Container Sheet
	var arrToRow=findText(toObject, "cntr_no", cntr_no);
	if (arrToRow.length == 0) {
		return;
	}
	if (arrToRow.length > 1) {
		return;
	}
	var arrFmRow=findText(fmObject, "cntr_no", cntr_no);
	if (arrFmRow.length == 1) {
		toObject.SetCellValue(arrToRow[0], "seal_no",arrFmRow[0] == '' ? "": fmObject.GetCellValue(arrFmRow[0], "seal_no"));
		toObject.SetCellValue(arrToRow[0], "seal_no2",'',0);
	} else if (arrFmRow.length > 1) {
		toObject.SetCellValue(arrToRow[0], "seal_no",arrFmRow[0] == '' ? "": fmObject.GetCellValue(arrFmRow[0], "seal_no"));
		toObject.SetCellValue(arrToRow[0], "seal_no2",arrFmRow[1] == '' ? "": fmObject.GetCellValue(arrFmRow[1], "seal_no"));
	} else {
		toObject.SetCellValue(arrToRow[0], "seal_no",'',0);
		toObject.SetCellValue(arrToRow[0], "seal_no2",'',0);
	}
}

function saveSeal(flg, cntr_no){
//	if(flg != null && flg == 'Y'){
//		var cntrObj=sheetObjects[1];
//		var arrRow=ComFindText(cntrObj, "cntr_no", cntr_no);
//		cntrObj.SetCellValue(arrRow,"ibflag","U",0);
//	}
}




/* Developer Work End */
