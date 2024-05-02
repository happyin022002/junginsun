/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0029.js
*@FileTitle  : Customer Code Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================*/
/****************************************************************************************
Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * business script for esm_bkg_0029
 */
//function esm_bkg_0029() {
//	this.processButtonClick=processButtonClick;
//	this.setSheetObject=setSheetObject;
//	this.loadPage=loadPage;
//	this.initSheet=initSheet;
//	this.initControl=initControl;
//	this.doActionIBSheet=doActionIBSheet;
//	this.setTabObject=setTabObject;
//	this.validateForm=validateForm;
//	this.sheet1_OnClick=sheet1_OnClick;
//}
// common global variables
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var tab1SearchFlag=false;
var tab2SearchFlag=false;
var tab3SearchFlag=false;
var sheetObjects=new Array();
var sheetCnt=0;
var isCA_Usr=false;
var msgType = "A6A";
// Event handler processing by button click event
document.onclick=processButtonClick;
// Event handler processing by button name
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try {   
		var srcName=ComGetEvent("name");
        if (!ComIsBtnEnable(srcName)) return;
		var row=sheetObject.GetSelectRow();
		var bl_no=sheetObject.GetCellValue(row, "bl_no");
		switch (srcName) {
		case "btn_Retrieve":
			tab1SearchFlag=true;
			doActionIBSheet(sheetObject, formObject, SEARCH, 1);
			tabObjects[0].SetSelectedIndex(0);
			tab1SearchFlag=false;
			break;
		case "btn_Save":
			if (ComIsBtnEnable("btn_Save"))
				doActionIBSheet(sheetObject, formObject, MODIFY);
			break;
		case "btn_Delete":
			if (ComIsBtnEnable("btn_Delete")) {
				sheetObject.SetCellValue(1, "mf_sts_cd","D",0);
				sheetObject.SetCellValue(1, "cstms_trsm_sts_cd","03",0);
				doActionIBSheet(sheetObject, formObject, REMOVE);
			}
			break;
		case "btn_Reactivate":
			if (ComIsBtnEnable("btn_Reactivate")) {
				sheetObject.SetCellValue(1, "mf_sts_cd","A",0);
				sheetObject.SetCellValue(1, "cstms_trsm_sts_cd","00",0);
				doActionIBSheet(sheetObject, formObject, REMOVE);
			}
			break;
		case "btn_Print":
			if (validateForm(sheetObject, formObject, COMMAND01)) {
				formObject.com_mrdPath.value="apps/opus/esm/bkg/customsdeclaration/customsreport/canada/report/ESM_BKG_5014.mrd";
				var strArg="/rp [" + formObject.bl_no.value + "]";
				formObject.com_mrdArguments.value=strArg;
				ComOpenRDPopup();
			}
			break;
		case "btn_Container":
			if (validateForm(sheetObject, formObject, COMMAND01)) {
				ComOpenWindowCenter("/opuscntr/ESM_BKG_0037.do?pgmNo=ESM_BKG_0037&bl_no=" + bl_no + "&cnt_cd=CA", "0037", 620, 420);
			}
			break;
		case "btn_CM":
			if (validateForm(sheetObject, formObject, COMMAND01)) {
				ComOpenWindowCenter("/opuscntr/ESM_BKG_0036.do?pgmNo=ESM_BKG_0036&bl_no=" + bl_no + "&cnt_cd=CA", "0036", 850, 550);
			}
			break;
		case "btn_ViewMsg":
//			if (validateForm(sheetObject, formObject, COMMAND01) && tabObjects[0].selectedIndex == 1 && sheetObjects[2].RowCount()> 0) {
			if (validateForm(sheetObject, formObject, COMMAND01) && tabObjects[0].GetSelectedIndex() == 1 && sheetObjects[2].RowCount()> 0) {
				var row=sheetObjects[2].GetSelectRow();
				var p1=sheetObjects[2].GetCellValue(row, "cnd_ack_rcv_id");
				var p2=sheetObjects[2].GetCellValue(row, "ack_desc");
				var p3=sheetObjects[2].GetCellValue(row, "cnd_ack_sub_cd");
				var p4=sheetObjects[2].GetCellValue(row, "result_desc");
				var p5=sheetObjects[2].GetCellValue(row, "cnd_ack_err_note_desc");
				var p6=sheetObjects[2].GetCellValue(row, "cstms_rjct_msg");
				var p7=sheetObjects[2].GetCellValue(row, "err_cd_desc");
				var p8=sheetObjects[2].GetCellValue(row, "err_tp_ctnt");
				var rcv_dt=sheetObjects[2].GetCellValue(row, "rcv_dt_date");
				var rcv_seq=sheetObjects[2].GetCellValue(row, "rcv_seq");
				
				ComOpenWindowCenter("/opuscntr/ESM_BKG_0433.do?pgmNo=ESM_BKG_0433&p1=" + p1 + "&p2=" + p2 + "&p3=" + p3 + "&p4=" + p4 + "&p5=" + p5 + "&p6="
						+ p6 + "&p7=" + p7 + "&p8=" + p8 + "&rcv_dt=" + rcv_dt + "&rcv_seq=" + rcv_seq, "0433", 620, 430);
			} else if (tabObjects[0].GetSelectedIndex() != 1) {
				ComShowCodeMessage("BKG95001", "select [Customs Result]");
			} else {
				ComShowCodeMessage("BKG00095");
			}
			break;
		case "btn_Transmit":
			if (ComIsBtnEnable("btn_Transmit")) {
				doActionIBSheet(sheetObject, formObject, MODIFY02);
			}
			break;
		case "btn_cust_s":
			formObject.cust_tp.value="S";
			formObject.cust_cnt_cd.value=formObject.frm_cust_cnt_cd1.value;
			formObject.cust_seq.value=formObject.frm_cust_seq1.value;
			doActionIBSheet(sheetObjects[0], formObject, SEARCH03);
			break;
		case "btn_cust_c":
			formObject.cust_tp.value="C";
			formObject.cust_cnt_cd.value=formObject.frm_cust_cnt_cd2.value;
			formObject.cust_seq.value=formObject.frm_cust_seq2.value;
			doActionIBSheet(sheetObjects[0], formObject, SEARCH03);
			break;
		case "btn_cust_n":
			formObject.cust_tp.value="N";
			formObject.cust_cnt_cd.value=formObject.frm_cust_cnt_cd3.value;
			formObject.cust_seq.value=formObject.frm_cust_seq3.value;
			doActionIBSheet(sheetObjects[0], formObject, SEARCH03);
			break;
		case "btn_cust_d":
			formObject.cust_tp.value="D";
			formObject.cust_cnt_cd.value=formObject.frm_in_tz_yd_cd1.value;
			formObject.cust_seq.value=formObject.frm_in_tz_yd_cd2.value;
			doActionIBSheet(sheetObjects[0], formObject, SEARCH03);
			break;
		case "btn_Terminal":
			if (ComIsBtnEnable("btn_Terminal")) {
				doActionIBSheet(sheetObject, formObject, MODIFY03);
			}
			break;
		case "btn_Close":
			ComClosePopup();
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComFuncErrMsg(e);
		} else {
			ComFuncErrMsg(e);
		}
	}
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage(isCA_Usr, strUsr_id) {
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
	this.isCA_Usr=isCA_Usr;
	doActionIBSheet(sheetObjects[0], document.form, INIT);
	if (document.form.type.value != "add" && document.form.bl_no.value != "") {
		doActionIBSheet(sheetObjects[0], document.form, SEARCH, 1);
	}
	//axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	//axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	//axon_event.addListener('keydown', 'obj_KeyDown', 'form');
	axon_event.addListenerForm  ('change', 'bkg_change', document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	document.form.bl_no.focus();
	//document.form.frm_cstms_trsm_sts_cd.SetEnable(0);
	frm_cstms_trsm_sts_cd.disabled = true;
	for (i=1; i <= sheetObjects[4].RowCount(); i++) {
		if (strUsr_id == sheetObjects[4].GetCellValue(i, "attr_ctnt3")) {
			frm_cstms_trsm_sts_cd.SetEnable(1);
			break;
		}
	}
}
function bkg_change()
{
	formObj = document.form;
	switch (ComGetEvent("name")) {
		case "frm_del_cd":
		formObj.f_cmd.value=SEARCH02;
		var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0029GS.do", FormQueryString(formObj));
		formObj.frm_hub_loc_cd.value=ComGetEtcData(sXml, "hub_loc_cd");
		formObj.frm_ibd_loc_gds_desc.value=ComGetEtcData(sXml, "ibd_loc_gds_desc");
		break;
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
	case "sheet1":
	    with(sheetObj){
			var HeadTitle1="|blno|filer||crn|stage||mblno|full_mty_cd|||||vvd|por|pol|pod|eta|del|qty||wgt||hub|loc|hblcount|bdr|||||||||";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cstms_file_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"mf_sts_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"trsp_tp_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"full_mty_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cstms_mf_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cstms_trsm_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"frt_clt_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"obl_rdem_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"m_bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ccn_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vps_eta_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"pck_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ams_pck_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cgo_wgt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"hub_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibd_loc_gds_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"hbl_count",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bdr_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"in_tz_yd_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"in_tz_yd_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"in_tz_yd_zip_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"in_tz_yd_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"in_tz_yd_addr",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"in_tz_yd_cty_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"in_tz_yd_ste_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"in_tz_yd_cnt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"diff_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"t_bdr_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			   
			InitColumns(cols);
			SetSheetHeight(80);
			SetEditable(1);
        }
		break;
	case "sheet2":
	    with(sheetObj){
			var HeadTitle1="|cnt_cd1|seq1|zip_id1|cty_nm1|ste_cd1|cstms_decl_cnt_cd1|nm1|addr1|cnt_cd2|seq2|zip_id2|cty_nm2|ste_cd2|cstms_decl_cnt_cd2|nm2|addr2|to_ord_flg|cnt_cd3|seq3|zip_id3|cty_nm3|ste_cd3|cstms_decl_cnt_cd3|nm3|addr3";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_zip_id1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_cty_nm1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_ste_cd1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cstms_decl_cnt_cd1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm1",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_addr1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_zip_id2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_cty_nm2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_ste_cd2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cstms_decl_cnt_cd2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm2",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_addr2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"to_ord_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq3",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_zip_id3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_cty_nm3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_ste_cd3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cstms_decl_cnt_cd3",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm3",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_addr3",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			
			InitColumns(cols);
			SetSheetHeight(80);
			SetEditable(1);
        }
		break;
	case "sheet3":
	    with(sheetObj){
			var HeadTitle1="SEQ|MSG|Receive Date|VVD|POL|POD|NVO|Status|Status|Reject Code(RC)|Reject Code(RC)|||||";
			var HeadTitle2="SEQ|MSG|Receive Date|VVD|POL|POD|NVO|Ack.|Result|Reason|DESC.";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rcv_msg_tp_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"rcv_dt_date",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cstms_file_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnd_ack_rcv_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnd_ack_sub_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cstms_rjct_msg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"err_cd_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ack_desc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"result_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnd_ack_err_note_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"err_tp_ctnt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rcv_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			   
			InitColumns(cols);
			SetSheetHeight(320);
			SetEditable(1);
			sheetObj.SetDataLinkMouse("cnd_ack_rcv_id",1);
			sheetObj.SetDataLinkMouse("cnd_ack_sub_cd",1);
			sheetObj.SetDataLinkMouse("cstms_rjct_msg",1);
			SetColProperty("rcv_dt_date", {Format:"####-##-####:##:##"} );
		}
		break;
	case "sheet4":
	    with(sheetObj){
			var HeadTitle1="SEQ|Manifest File No.|NVO|Pieces Count|Pieces Count|HUB|Consignee";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"hm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"pck_qty",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ams_pck_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"hub_loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cust_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			   
			InitColumns(cols);
			SetSheetHeight(320);
			SetEditable(1);
        }
		break;
	case "sheet5":
	    with(sheetObj){
			var HeadTitle1="ID";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt3",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			   
			InitColumns(cols);
			SetSheetHeight(50);
			SetEditable(1);
        }
		break;
	}
}
/**
 * register Tab Object to tabObjects array
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++]=tab_obj;
}
/**
* initialize IBCombo
* @param tabObj Tab Object
* @param tabNo Tab No.
*/
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt=0;
			InsertItem( "Customer", "");
			InsertItem( "Customs Result", "");
			InsertItem( "H.B/L List", "");
		}
		break;
	}
}
/**
* handling Combo event
* @param tabObj Tab Object
* @param tabNo Tab No.
*/
function tab1_OnChange(tabObj, nItem) {
	//var objs=document.all.item("tabLayer");
	//objs[nItem].style.display="Inline";
	//objs[beforetab].style.display="none";
	//objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
	//beforetab=nItem;
	if(!tab1SearchFlag){
		if (nItem == 1 && !tab2SearchFlag) {
			//tab2
			doActionIBSheet(sheetObjects[2], document.form, SEARCH, 2);
			tab2SearchFlag=true;
		} else if (nItem == 2 && !tab3SearchFlag) {
			//tab3
			doActionIBSheet(sheetObjects[3], document.form, SEARCH, 3);
			tab3SearchFlag=true;
		}
	}
	
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	for(var i = 0; i<objs.length; i++){
		if(i != nItem){
			objs[i].style.display="none";
			objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		}
	}
	beforetab=nItem;
}
/**
 * handling process for on search
 */
function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		var red="#FF0000";
		var blue="#0000FF";
		SetRowFontColor(4,red);
		SetRowFontColor(5,blue);
		SetRowFontColor(7,red);
	}
}
// handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction, tabno) {
	sheetObj.ShowDebugMsg(false);
	var sXml;
	var sParam;
	switch (sAction) {
	case INIT:
		formObj.f_cmd.value=INIT;
		sXml=sheetObj.GetSearchData("ESM_BKG_0029GS.do", FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		ComXml2ComboItem(arrXml[0], frm_wgt_ut_cd, "val", "name");
		ComXml2ComboItem(arrXml[1], frm_trsp_tp_id, "attr_ctnt1", "attr_ctnt1|attr_ctnt2");
		var trsm_sts="<SHEET><DATA COLORDER='code|name' COLSEPARATOR='☜☞' TOTAL='3'>" +
	                   "<TR><![CDATA[00☜☞Original]]></TR>" +
	                   "<TR><![CDATA[03☜☞Delete]]></TR>" +
	                   "<TR><![CDATA[04☜☞Update]]></TR></DATA></SHEET>";
		ComXml2ComboItem(trsm_sts, frm_cstms_trsm_sts_cd, "code", "name");
		frm_wgt_ut_cd.InsertItem(0, "", "");
		frm_cstms_trsm_sts_cd.InsertItem(0, "", "");
		sheetObjects[4].LoadSearchData(arrXml[2],{Sync:0} );
		if (formObj.type.value == "add") {
			//DUMMY BL 조회
			formObj.f_cmd.value=SEARCH01;
			sXml=sheetObj.GetSearchData("ESM_BKG_0029GS.do", FormQueryString(formObj));
			formObj.bl_no.value=ComGetEtcData(sXml, "dummy_bl_no");
			formObj.frm_cstms_file_tp_cd.value="3";
			formObj.frm_ccn_no.value="9165" + ComGetEtcData(sXml, "dummy_bl_no");
			formObj.frm_m_bl_no.value=ComGetEtcData(sXml, "dummy_bl_no");
			formObj.frm_full_mty_cd.checked=true;
			document.getElementById("frm_mf_sts_cd").innerHTML="Active";
			// DUMMY BL
			setButtonDisabled('add');
			tabObjects[0].SetTabDisable(1, true);
			tabObjects[0].SetTabDisable(2, true);
		} else if (formObj.bl_no.value == "") {
			tabObjects[0].SetTabDisable(1, true);
			tabObjects[0].SetTabDisable(2, true);
		}
		break;
	case SEARCH: //Retrieve, Tab1
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			formObj.tab_no.value=tabno;
			sXml=sheetObj.GetSearchData("ESM_BKG_0029GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0) {
				sheetObjects[tabno].LoadSearchData(arrXml[tabno],{Sync:1} );
			}
			if (tabno == 1) {
				sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
				if (sheetObjects[0].RowCount()> 0) {
					IBS_CopyRowToForm(sheetObjects[0], formObj, 1, "frm_");
					var vFontColor="#000000";
					if (sheetObjects[0].GetCellValue(1, "mf_sts_cd") == "Active") {
						vFontColor="blue";
					} else if (sheetObjects[0].GetCellValue(1, "mf_sts_cd") == "Deleted") {
						vFontColor="red";
					}
					document.getElementById("frm_mf_sts_cd").innerHTML="<font color='" + vFontColor + "'>"
					+ sheetObjects[0].GetCellValue(1, "mf_sts_cd") + "</font>";
					formObj.frm_pck_qty.value=ComAddComma2(formObj.frm_pck_qty, "#,###");
					formObj.frm_cgo_wgt.value=ComAddComma2(formObj.frm_cgo_wgt, "#,###.00");
					frm_wgt_ut_cd.SetSelectCode(sheetObjects[0].GetCellValue(1, "wgt_ut_cd"));
					frm_trsp_tp_id.SetSelectCode(sheetObjects[0].GetCellValue(1, "trsp_tp_id"));
					frm_cstms_trsm_sts_cd.SetSelectCode(sheetObjects[0].GetCellValue(1, "cstms_trsm_sts_cd"));
				}
				if (sheetObjects[1].RowCount()> 0) {
					IBS_CopyRowToForm(sheetObjects[1], formObj, 1, "frm_");
				}
				//Retrieve 
				tab2SearchFlag=false;
				tab3SearchFlag=false;
				var objs=document.all.item("tabLayer");
				objs[0].style.display="Inline";
				if (beforetab != 0) {
					objs[beforetab].style.display="none";
					tabObjects[0].selectedIndex=0;
				}
				beforetab=0;
				if (formObj.bl_no.value == formObj.frm_m_bl_no.value) {
//					frm_trsp_tp_id.SetEnable(0);
				} else {
					frm_trsp_tp_id.SetEnable(1);
					frm_trsp_tp_id.SetBackColor("#CCFFFD");
				}
				//Retrieve 
				if (sheetObjects[0].GetCellValue(1, "hbl_count") > 0) {
					if (tabObjects[0].GetTabDisable(2))
					{
						tabObjects[0].SetTabDisable(2, false);;
					}
				} else {
					tabObjects[0].SetTabDisable(2, true);
				}
				if (tabObjects[0].GetTabDisable(1))
				{
					tabObjects[0].SetTabDisable(1, false);
				}
				if (sheetObjects[0].GetCellValue(1, "bl_no") == sheetObjects[0].GetCellValue(1, "m_bl_no")) {
//					frm_trsp_tp_id.disabled=true;
//					frm_trsp_tp_id.SetEnable(0);
				} else {
//					frm_trsp_tp_id.disabled=false;
					frm_trsp_tp_id.SetEnable(1);
				}
				if (sheetObjects[0].GetCellValue(1, "bdr_flg") == "Y") {
					if (isCA_Usr == "false") {
						setButtonDisabled('bdr');
					} else {
						setButtonDisabled('nbdr');
					}
				} else if (sheetObjects[0].GetCellValue(1, "bdr_flg") == "N") {
					setButtonDisabled('nbdr');
				} else {
					setButtonDisabled('init');
				}
				
			} else if (tabno == 2) {
				for ( var i=2; i <= sheetObjects[2].RowCount()+ 1; i++) {
					sheetObjects[2].SetCellFontColor(i, "cnd_ack_rcv_id","#0000FF");
					sheetObjects[2].SetCellFontUnderline(i, "cnd_ack_rcv_id",1);
					sheetObjects[2].SetCellFontColor(i, "cnd_ack_sub_cd","#0000FF");
					sheetObjects[2].SetCellFontUnderline(i, "cnd_ack_sub_cd",1);
					sheetObjects[2].SetCellFontColor(i, "cstms_rjct_msg","#0000FF");
					sheetObjects[2].SetCellFontUnderline(i, "cstms_rjct_msg",1);
					if (sheetObj.GetCellValue(i, "cnd_ack_sub_cd") == "37" || sheetObj.GetCellValue(i, "cnd_ack_sub_cd") == "21") {
						sheetObj.SetRowFontColor(i,"#FF0000");
					} else if (sheetObj.GetCellValue(i, "cnd_ack_sub_cd") == "01") {
						sheetObj.SetRowFontColor(i,"#0000FF");
					}
				}
			}
			msgType = formObj.frm_cstms_mf_tp_cd.value;
			ComOpenWait(false);
		}
		break;
	case MODIFY: //Save
		if (formObj.type.value == "add") {
			sheetObjects[0].DataInsert(1);
			sheetObjects[0].SetCellValue(1, "bl_no",formObj.bl_no.value,0);
			sheetObjects[1].DataInsert(1);
		}
		if (validateForm(sheetObj, formObj, sAction)) {
			IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");
			IBS_CopyFormToRow(formObj, sheetObjects[1], 1, "frm_");
			sheetObjects[0].SetCellValue(1, "wgt_ut_cd",frm_wgt_ut_cd.GetSelectCode());
			sheetObjects[0].SetCellValue(1, "trsp_tp_id",frm_trsp_tp_id.GetSelectCode());
			sheetObjects[0].SetCellValue(1, "cstms_trsm_sts_cd",frm_cstms_trsm_sts_cd.GetSelectCode(),0);
			if (!sheetObjects[0].IsDataModified()&& !sheetObjects[1].IsDataModified()) {
				ComShowCodeMessage('BKG00743');
				return;
			}
			
			if(!ComShowCodeConfirm("BKG00350")) {
            	return false;
            }
			
			ComOpenWait(true);
			// save
			sheetObjects[0].SetRowStatus(1,"U");
			sheetObjects[1].SetRowStatus(1,"U");
			
			sParam=ComGetSaveString(sheetObjects) + "&f_cmd=" + MODIFY01;
			var sXml=sheetObjects[0].GetSaveData("ESM_BKG_0029GS.do", sParam);
			//save success message
			if (sXml != "") sheetObj.LoadSaveData(sXml,{Sync:1});
			
			if (ComBkgErrMessage(sheetObjects[0], sXml)) {
				if (ComShowCodeConfirm("BKG01023", msgType, "Canada Customs")) {
					// transmit
					doActionIBSheet(sheetObj, formObj, MODIFY02, -1)
				}
				if (formObj.type.value == "add") {
					formObj.type.value="edit";
					doActionIBSheet(sheetObjects[0], document.form, SEARCH, 1);
				}
			}
			ComOpenWait(false);
		}
		break;
	case REMOVE: //Delete, Reactivate
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			//(Reactivate)
			sheetObj.SetRowStatus(1,"U");
			sParam=sheetObj.GetSaveString(sheetObj) + "&f_cmd=" + REMOVE;
			sXml=sheetObj.GetSaveData("ESM_BKG_0029GS.do", sParam);
			//sheetObj.loadSaveXml(sXml);
			sheetObj.LoadSaveData(sXml);
			if (ComBkgErrMessage(sheetObjects[0], sXml)) {
				if (ComShowCodeConfirm("BKG01023", msgType, "Canada Customs")) {
					// transmit
					doActionIBSheet(sheetObj, formObj, MODIFY02, -1)
				} else {
					// Reload
					doActionIBSheet(sheetObjects[2], document.form, SEARCH, 1);
				}
			}
			ComOpenWait(false);
		}
		break;
	case MODIFY02: //Transmit
		if (validateForm(sheetObj, formObj, sAction)) {
			sParam="f_cmd=" + MODIFY02;
			sParam=sParam + "&" + sheetObjects[0].GetSaveString(true);
			// Confirm message
			if (tabno != -1) {
				if (ComShowCodeConfirm("BKG01023", msgType, "Canada Customs")) {
					ComOpenWait(true);
					sXml=sheetObjects[0].GetSaveData("ESM_BKG_0029GS.do", sParam);
					if (ComBkgErrMessage(sheetObjects[0], sXml)) {
						sheetObj.LoadSaveData(sXml);
						doActionIBSheet(sheetObj, formObj, SEARCH, 1)
					}
					ComOpenWait(false);
				}
			} else {
				sXml=sheetObjects[0].GetSaveData("ESM_BKG_0029GS.do", sParam);
				sheetObj.LoadSaveData(sXml);
				if (ComBkgErrMessage(sheetObjects[0], sXml)) {
					doActionIBSheet(sheetObj, formObj, SEARCH, 1)
				}
			}
		}
		break;
	case SEARCH03:
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH03;
			sXml=sheetObj.GetSearchData("ESM_BKG_0029GS.do", FormQueryString(formObj));
			if (ComBkgErrMessage(sheetObjects[0], sXml)) {
				var custTp=formObj.cust_tp.value;
				if (custTp == "S") {
					formObj.frm_cust_nm1.value=ComGetEtcData(sXml, "cust_nm");
					formObj.frm_cust_addr1.value=ComGetEtcData(sXml, "cust_addr");
				} else if (custTp == "C") {
					formObj.frm_cust_nm2.value=ComGetEtcData(sXml, "cust_nm");
					formObj.frm_cust_addr2.value=ComGetEtcData(sXml, "cust_addr");
				} else if (custTp == "N") {
					formObj.frm_cust_nm3.value=ComGetEtcData(sXml, "cust_nm");
					formObj.frm_cust_addr3.value=ComGetEtcData(sXml, "cust_addr");
				} else if (custTp == "D") {
					formObj.frm_in_tz_yd_nm.value=ComGetEtcData(sXml, "cust_nm");
					formObj.frm_in_tz_yd_addr.value=ComGetEtcData(sXml, "cust_addr");
					formObj.frm_in_tz_yd_cty_nm.value=ComGetEtcData(sXml, "loc_nm");
					formObj.frm_in_tz_yd_ste_cd.value=ComGetEtcData(sXml, "ste_cd");
					formObj.frm_in_tz_yd_cnt_cd.value=ComGetEtcData(sXml, "cnt_cd");
					formObj.frm_in_tz_yd_zip_id.value=ComGetEtcData(sXml, "zip_cd");
				}
			}
			ComOpenWait(false);
		}
		break;
	case MODIFY03: //Terminal
		if (validateForm(sheetObj, formObj, sAction)) {
			sParam="f_cmd=" + MODIFY03;
			sParam=sParam + "&" + sheetObjects[0].GetSaveString(true);
			// Confirm message
			if (tabno != -1) {
				if (ComShowCodeConfirm("BKG01023", "PA", "Terminal")) {
					ComOpenWait(true);
					sXml=sheetObjects[0].GetSaveData("ESM_BKG_0029GS.do", sParam);
					if (ComBkgErrMessage(sheetObjects[0], sXml)) {
						sheetObj.LoadSaveData(sXml);
						doActionIBSheet(sheetObj, formObj, SEARCH, 1)
					}
					ComOpenWait(false);
				}
			} else {
				sXml=sheetObjects[0].GetSaveData("ESM_BKG_0029GS.do", sParam);
				sheetObj.LoadSaveData(sXml);
				if (ComBkgErrMessage(sheetObjects[0], sXml)) {
					doActionIBSheet(sheetObj, formObj, SEARCH, 1)
				}
			}
		}
	break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case SEARCH: //Retrieve, Tab1
		if (ComIsNull(formObj.bl_no)) {
			ComShowMessage('B/L No. is mandatory item.');
			return false;
		}
//		if (ComChkLen(formObj.bl_no, 12) != 2) { // Toyota B/L
//			ComShowCodeMessage('BKG00626', 'B/L No.'); 
//			return false;
//		}
		break;
	case MODIFY:
		if (formObj.type.value != "add" && (sheetObjects[0].RowCount()<= 0 || sheetObjects[0].GetCellValue(1, "bl_no") == "")) {
			ComShowCodeMessage('BKG00395');
			return false;
		}
		if (formObj.bl_no.value != formObj.frm_m_bl_no.value) {
			if (ComIsNull(frm_trsp_tp_id.GetSelectCode())) {
				ComShowMessage('B/L Transporation Type is mandatory item.');
				return false;
			}
		}
		
		if (!ComChkValid(formObj))
			return false;
		
		if (ComIsNull(formObj.frm_por_cd)) {
			ComShowMessage('POR is mandatory item.');
			return false;
		}
		if (ComIsNull(formObj.frm_pol_cd)) {
			ComShowMessage('POL is mandatory item.');
			return false;
		}
		if (ComIsNull(formObj.frm_del_cd)) {
			ComShowMessage('DEL is mandatory item.');
			return false;
		}
		if (ComIsNull(formObj.frm_pck_qty)) {
			ComShowMessage("Q'ty is mandatory item.");
			return false;
		}
		if (ComIsNull(formObj.frm_cgo_wgt)) {
			ComShowMessage("WGT is mandatory item.");
			return false;
		}
		
		
		break;
	case MODIFY01:
	case MODIFY02:
	case COMMAND01:
		if (formObj.type.value != "add" && (sheetObjects[0].RowCount()<= 0 || sheetObjects[0].GetCellValue(1, "bl_no") == "")) {
			ComShowCodeMessage('BKG00395');
			return false;
		}
		if( formObj.frm_hub_loc_cd.value == "" || ComIsNull(formObj.frm_hub_loc_cd)){
			// Mandatory field is missing. Please enter HUB
			ComShowCodeMessage('BKG00887', 'HUB');
			return false;
		}
		break;
	case SEARCH03:
		if (ComIsNull(formObj.cust_cnt_cd)) {
			ComShowMessage('Country Code is mandatory item.');
			return false;
		}
		if (ComIsNull(formObj.cust_seq)) {
			ComShowMessage('Country Seq. is mandatory item.');
			return false;
		}
		break;
		
	case MODIFY03: //Terminal
		if (formObj.frm_pod_cd.value.substr(0, 2) != 'CA')
		{
			ComShowCodeMessage('BKG00388', 'POD should be Canada for Terminal EDI');
			return false;
		}
		if( formObj.frm_hub_loc_cd.value == "" || ComIsNull(formObj.frm_hub_loc_cd)){
			// Mandatory field is missing. Please enter HUB
			ComShowCodeMessage('BKG00887', 'HUB');
			return false;
		}
		break;

	}
	return true;
}
/**
 * Sheet3 mouse event
 */
function sheet3_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	var sheetObj=sheetObjects[2];
	var row=sheetObj.MouseRow();
	var col=sheetObj.MouseCol();
	if (row > 1) {
		if (sheetObj.ColSaveName(col) == "cnd_ack_rcv_id") {
			sheetObj.SetToolTipText(row, col,sheetObj.GetCellText(row, "ack_desc"));
		} else if (sheetObj.ColSaveName(col) == "cnd_ack_sub_cd") {
			sheetObj.SetToolTipText(row, col,sheetObj.GetCellText(row, "result_desc"));
		} else if (sheetObj.ColSaveName(col) == "cstms_rjct_msg") {
			sheetObj.SetToolTipText(row, col,sheetObj.GetCellText(row, "err_cd_desc"));
		}
	}
}
 /**
  * setting button disable/enable
  */
function setButtonDisabled(type) {
	switch (type) {
	case "add":
		ComBtnDisable("btn_Retrieve");
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_Reactivate");
		ComBtnDisable("btn_Print");
		// ComBtnDisable("btn_ViewMsg");
		document.form.frm_por_cd.readOnly=false;
		document.form.frm_pol_cd.readOnly=false;
		document.form.frm_por_cd.className="input";
		document.form.frm_pol_cd.className="input";
		break;
	case "bdr":
		ComBtnEnable("btn_Retrieve");
		ComBtnEnable("btn_Print");
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_Reactivate");
		ComBtnDisable("btn_Transmit");
		ComBtnDisable("btn_Terminal");
		break;
	case "nbdr":
		ComBtnEnable("btn_Retrieve");
		ComBtnEnable("btn_Print");
		ComBtnEnable("btn_Save");
		ComBtnEnable("btn_Transmit");
		ComBtnEnable("btn_Terminal");
		if (sheetObjects[0].GetCellValue(1, "mf_sts_cd") == "Active") {
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_Delete");
			ComBtnDisable("btn_Reactivate");
		} else if (sheetObjects[0].GetCellValue(1, "mf_sts_cd") == "Deleted") {
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Delete");
			ComBtnEnable("btn_Reactivate");
		}
		break;
	case "init":
		ComBtnEnable("btn_Retrieve");
		ComBtnEnable("btn_Save");
		ComBtnEnable("btn_Delete");
		ComBtnEnable("btn_Reactivate");
		ComBtnEnable("btn_Print");
		ComBtnEnable("btn_Container");
		ComBtnEnable("btn_CM");
		ComBtnEnable("btn_ViewMsg");
		ComBtnEnable("btn_Transmit");
		ComBtnEnable("btn_Terminal");
		break;
	}
}
/**
 * handling KEY UP
 */
function obj_KeyUp() {
	var formObj=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	if (ComGetEvent("name") == "bl_no") {
		ComKeyEnter();
	} else if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
	switch (ComGetEvent("dataformat")) {
	case "float":
		if (event.keyCode != 9) {
			document.form.elements[srcName].value=toMoney(document.form.elements[srcName].value);
			break;
		}
	}
	if (srcName == "frm_del_cd" && ComChkLen(formObj.frm_del_cd, 5) == 2) {
		formObj.f_cmd.value=SEARCH02;
		var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0029GS.do", FormQueryString(formObj));
		formObj.frm_hub_loc_cd.value=ComGetEtcData(sXml, "hub_loc_cd");
		formObj.frm_ibd_loc_gds_desc.value=ComGetEtcData(sXml, "ibd_loc_gds_desc");
	}
}
function formatCommas(numString) {
	var re=/,|\s+/g;
	numString=numString.replace(re, "");
	re=/(-?\d+)(\d{3})/;
	while (re.test(numString)) {
		numString=numString.replace(re, "$1,$2");
	}
	return numString;
}
function toMoney(value) {
	var indexOfPoint=value.indexOf(".");
	if (indexOfPoint == -1) {
		value=formatCommas(value);
	} else {
		value=formatCommas(value.substring(0, indexOfPoint)) + value.substring(indexOfPoint, value.length);
	}
	return value;
}
function frm_trsp_tp_id_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
	document.form.frm_del_cd.focus();
}
function frm_wgt_ut_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
	document.form.frm_hub_loc_cd.focus();
}