/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1104.js
*@FileTitle  : Europe Advanced Manifest - Arrival Notice
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================*/

/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

var comboObjects=new Array();
var comboCnt=0;
// Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// array of YD_CD related to POFE : mapping to form_cstms_yd_cd property 
var eu_1st_port_yd_cd=new Array();
/**
 * registering Combo Object as list
 * 
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj;
}
/**
 * initializing Combo Object
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
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
	}
}
// Event handler processing by button name */
function processButtonClick() {
	/* */
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_MrnDelete":
			doActionIBSheet(sheetObject1, formObject, MULTI02);
			break;		
		case "btn_retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;
		case "btn_new":
			doActionIBSheet(sheetObject1, formObject, IBINSERT);
			break;
		case "btn_save":
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;
		case "btn_transmit":
			doActionIBSheet(sheetObject1, formObject, MULTI01);
			break;
		case "btn_viewMsg":
			var row=sheetObject1.GetSelectRow();
			var edi_rcv_dt_msg=sheetObject1.GetCellValue(row, "edi_rcv_dt_msg");
			ComOpenWindowCenter(	"/opuscntr/ESM_BKG_1112.do?pgmNo=ESM_BKG_1112&edi_rcv_dt=" +  edi_rcv_dt_msg + "&edi_rcv_seq=" + sheetObject1.GetCellValue(row, "edi_rcv_seq"), "1104", 600, 620, false);
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	var formObj=document.form;
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for (i=0; i < comboObjects.length; i++) {
		initCombo(comboObjects[i], i + 1);
	}
	//axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
	axon_event.addListenerForm('change', 'obj_change', document.form);
	axon_event.addListenerForm("click","obj_Click", document.form);
	SetButtonStatus();
}
 /**
 * handling buttons on loading
 */
function SetButtonStatus(){
	if(document.form.vvd.value == ''){
		ComBtnDisable("btn_transmit");
	}else{
		if(document.form.form_crr_cd.value == ConstantMgr.getCompanyCode()){
			if(document.form.form_an_edi_svc_flg.value == 'Y'){
				ComBtnEnable("btn_transmit");
			}else{
				ComBtnDisable("btn_transmit");
			}
   	 	}else{
   	 		ComBtnDisable("btn_transmit");
   	 	} 
		
		// HJS EU Staff 인 경우에만 All MRN Delete 버튼과 ENS ETA 수정용 체크박스 활성화
		if(sheetObjects[0].GetCellValue(1, "eu_stf_flg") == "Y"){
			document.getElementById("modify_ens_eta").disabled = false;
//			document.getElementById("modify_ens_eta").checked = true;		
			document.getElementById("btn_MrnDelete").style.display='';
		}else{
			document.getElementById("modify_ens_eta").disabled = true;
			document.getElementById("modify_ens_eta").checked = false;			
			document.getElementById("btn_MrnDelete").style.display='none';
		}		
    }
} 

var enterFlag = 0;
function obj_ComKeyEnter(event){
	 if (event.keyCode==13){
		 var srcName=ComGetEvent("name");
		 if(srcName=="form_vvd"){
			 enterFlag=1;
			 obj_change();
		 }else{
			 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		 }
	 }
}
/**
 * handling event after loading
 * @param sheetObj
 * @return
 */
//no support[check again]CLT 
function sheet1_OnLoadFinish(sheetObj) {
	var formObj=document.form;
	initSheetData(sheetObjects[0], formObj);
	ComSetFocus(formObj.form_vvd_cd);
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
	          var HeadTitle1 = "| |eu_stf_flg|vvd|cvy_ref_no|cvy_ref_no_hidden|vsl_cd|skd_voy_no|skd_dir_cd|vsl_eng_nm|lloyd_no|piclb_desc|cstms_port_cd|eta_dt|etd_dt|n1st_port_ofc_cd|tml_cd|tml_nm|lst_clpt_cd|nxt_clpt_cd|rgst_no|rgst_dt|rgst_port_cd|grs_rgst_tong_wgt|net_rgst_tong_wgt|cre_usr_id|cre_dt|upd_usr_id|upd_dt|snd_usr_id|snd_dt|snd_ofc_cd|ack|result|cstms_yd_cd|edi_rcv_dt|edi_rcv_seq|edi_rcv_dt_msg|crr_cd|init_eta_dt|an_edi_svc_flg";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eu_stf_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vvd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cvy_ref_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cvy_ref_no_hidden",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"skd_voy_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"skd_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vsl_eng_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"lloyd_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"piclb_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cstms_port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"eta_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"etd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"n1st_port_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"tml_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"tml_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"lst_clpt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"nxt_clpt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"rgst_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"rgst_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"rgst_port_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"grs_rgst_tong_wgt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"net_rgst_tong_wgt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"snd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"snd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"snd_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"ack",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"result",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cstms_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"edi_rcv_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"edi_rcv_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"edi_rcv_dt_msg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"crr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"init_eta_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"an_edi_svc_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		      SetFocusAfterRowTransaction(0); 
		      SetEditable(1);
		      SetCountPosition(0);
		      SetWaitImageVisible(0);
		      
		      SetSheetHeight(302);
            }
	    	break;
	}
}
/**
 * handling process for Sheet
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: //retrieve
		if (!validateForm(sheetObj, formObj, sAction))
			return false;
		ComOpenWait(true);
		formObj.f_cmd.value=SEARCH;
//		formObj.f_cmd.value=SEARCH03;
		formObj.vvd.value=formObj.form_vvd.value;
		formObj.cvy_ref_no.value=formObj.form_cvy_ref_no.value;
		var cstms_yd_cd=formObj.form_cstms_yd_cd.value;
		formObj.cstms_yd_cd.value=formObj.form_cstms_yd_cd.value;
		var sXml=sheetObjects[0].GetSearchData("ESM_BKG_1104GS.do",	FormQueryString(formObj));
		sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
		if (sheetObj.RowCount()== 1) {
			IBS_CopyRowToForm(sheetObj, formObj, 1, "form_");
			if (cstms_yd_cd != '' && cstms_yd_cd != undefined)
				formObj.form_cstms_yd_cd.value=cstms_yd_cd;
		} else {
			ComShowCodeMessage('BKG00095', "VSL Code");
			initSheetData(sheetObj, formObj);
			ComSetFocus(formObj.form_vvd);
		}
		formObj.cstms_yd_cd2.value = formObj.form_tml_cd.value;
		if(formObj.form_ibflag.value == 'I'){ 
		formObj.form_tml_cd.value = "";
		}
		SetButtonStatus();
		ComOpenWait(false);
		break;
	case IBINSERT: // 
		initSheetData(sheetObj, formObj);
		SetButtonStatus();
	//	ComSetFocus(formObj.form_vvd);
		break;
	case IBSAVE: // 
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		formObj.form_cstms_port_cd.value=comboObjects[0].GetSelectText();
		IBS_CopyFormToRow(formObj, sheetObj, 1, "form_");
		ComOpenWait(true);
		formObj.f_cmd.value=MULTI;
		sheetObj.DoSave("ESM_BKG_1104GS.do", FormQueryString(formObj));
		formObj.form_tml_cd.value = formObj.cstms_yd_cd2.value
		ComOpenWait(false);
		break;
	case MULTI01: // 	
		formObj.vvd.value=formObj.form_vvd.value;
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		if(formObj.form_tml_cd.value==""){ //Save를 한뒤에 전송을 하기 위한 Validation
			ComShowCodeMessage("BKG01129");
			return false;
		}
		ComOpenWait(true);
		formObj.f_cmd.value=MULTI01;
		formObj.cvy_ref_no.value=formObj.form_cvy_ref_no.value;
		if (location.href.indexOf('opusdev') != -1 && formObj.form_ibflag.value == 'I') {
			if (formObj.form_snd_usr_id.value='') {
				ComShowCodeMessage("BKG01128");// No ENS data Found!
			} else {
				ComShowCodeMessage("BKG01129");// Please Save First!
			}
		}else{
			//parameter changed[check again]CLT 			
			var sXml=sheetObj.GetSearchData("ESM_BKG_1104GS.do", FormQueryString(formObj));
			var valResult=ComGetEtcData(sXml, "flatFile");
			formObj.flatfile.value=valResult;
			var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			if (State == "S") {
				ComShowCodeMessage("BKG00101"); // Data Transmitted Successfully!!
			}else{
				ComShowCodeMessage("BKG00099"); // Failed to transmit ED!!
			}
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
		ComOpenWait(false);
		break;
	case SEARCH02: // VVD Combo setting
		formObj.f_cmd.value=SEARCH02;
		formObj.p_vvd_cd.value=formObj.form_vvd.value;
//parameter changed[check again]CLT 		
		var sXml=sheetObj.GetSearchData("ESM_BKG_1104GS.do", FormQueryString(formObj));
		//alert(sXml);
		if (ComGetTotalRows(sXml) > 0) {
			ComBkgXml2ComboItem(sXml, comboObjects[0], "eu_1st_port",	"eu_1st_port|eu_1st_port_yd_cd", true);
			var arr=new Array();
			arr=ComBkgXml2ComboString(sXml, "eu_1st_port", "eu_1st_port");
			if (arr == undefined || arr == '') {
//				ComShowCodeMessage("BKG00889"); // No Data Found
				return;
			}
			arr=ComBkgXml2ComboString(sXml, "eu_1st_port_yd_cd",	"eu_1st_port_yd_cd");
			eu_1st_port_yd_cd=arr[0].split("|");
			formObj.form_cstms_yd_cd.value=eu_1st_port_yd_cd[0].substring(5);
			comboObjects[0].SetSelectIndex(0);
		}else{
			ComShowCodeMessage("BKG00889"); // No Data Found
			return;
		}
		break;
	case MULTI02:
		if (!validateForm(sheetObj, formObj, sAction))
			return;

		formObj.form_cstms_port_cd.value = comboObjects[0].GetSelectText();
		IBS_CopyFormToRow(formObj, sheetObj, 1, "form_");
		ComOpenWait(true);
		formObj.f_cmd.value = MULTI02;
		
		var xml = sheetObj.GetSaveData("ESM_BKG_1104GS.do", FormQueryString(formObj));
		sheetObj.LoadSaveData(xml);

		ComOpenWait(false);
		break;		
	}
}
// initializing sheet data
function initSheetData(sheetObj, formObj) {
	formObj.reset();
	cstms_port_cd.RemoveAll();
	cstms_port_cd.SetSelectText("");
	cstms_port_cd.SetBackColor("#FFFFFF");
	
	sheetObj.RemoveAll();
	sheetObj.DataInsert(-1);
	IBS_CopyRowToForm(sheetObj, formObj, 1, "form_");
	
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: { // 
		if (formObj.form_vvd.value == ""
				&& formObj.form_cvy_ref_no.value == "") {
			ComShowCodeMessage("BKG01090", "VVD", "CRN No.");
			ComSetFocus(formObj.form_vvd);
			return false;
		}
		break;
	}
	case IBSAVE: { // 
		// 
		if (!ComChkValid(formObj))
			return false;
		if (formObj.form_vvd.value == "") {
			ComShowCodeMessage('BKG00715', "VSL Code");
			ComSetFocus(formObj.form_vvd);
			return false;
		}
		var port=comboObjects[0].GetSelectCode();
		if(port != undefined && port != ''){
			port=port.substring(0,2);
		}
		if(port == 'NL' && formObj.form_cvy_ref_no.value == ""){
			ComShowCodeMessage('BKG00715', "CRN No.");
			ComSetFocus(formObj.form_cvy_ref_no);
			return false;
		}
		if (formObj.form_vsl_eng_nm.value == "") {
			ComShowCodeMessage('BKG00012');
			ComSetFocus(formObj.form_vsl_eng_nm);
			return false;
		}
		break;
	}
	case REMOVE: { // 
		// 
		if (!ComChkValid(formObj))
			return false;
		if (sheetObj.RowCount()== 0) {
			ComShowCodeMessage('BKG00889');
			return false;
		}
		if (sheetObj.RowCount()== 1) {
			if (sheetObj.GetCellValue(1, "vvd_cd") == ""
			|| sheetObj.GetCellValue(1, "pod_cd") == "") {
				ComShowCodeMessage('BKG00889');
				return false;
			}
		}
		break;
	}
	case MULTI01: {
		//
		if (!ComChkValid(formObj))	return false;
			if (formObj.form_vvd.value == "") {
				ComShowCodeMessage('BKG00715', "VSL Code");
				ComSetFocus(formObj.form_vvd);
				return false;
			}
			var port=comboObjects[0].GetSelectCode();
			if(port != undefined && port != ''){
				port=port.substring(0,2);
			}
			if(port == 'NL' && formObj.form_cvy_ref_no.value == ""){
				ComShowCodeMessage('BKG00715', "CRN No.");
				ComSetFocus(formObj.form_cvy_ref_no);
				return false;
			}
			if (formObj.form_n1st_port_ofc_cd.value == "") {
				ComShowCodeMessage('BKG01131');
				ComSetFocus(formObj.form_n1st_port_ofc_cd);
				return false;
			}
			
			// Do you want to transmit?
			if (!ComShowCodeConfirm("BKG06200", "")){
				return false;
			}
		}
	    break;
	case MULTI02: 
		// Are you sure to delete All MRN? If yes, previous all MRN will be deleted.
		if (!ComShowConfirm(ComGetMsg("BKG06154"))) {
			// 확인을 누르면 진행 계속
			return false
		}
		break;	
	} // end switch
	return true;
}
/**
 * handling event after saving
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
//	if (ErrMsg == "") {
//		if (document.form.f_cmd.value == MULTI02) {
//			ComShowCodeMessage('BKG00102');
//			return false;
//		}
//	}
}
/**
 * handling event after retrieving
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	//		if(ErrMsg == ""){
	//
	// if(sheetObj.Rowcount == 0){
	// ComShowCodeMessage('BKG00800');
	// }
	//			
	// }
}

/**
 * POL, POD Click 여부
 * @return
 */
function obj_Click() {	
	var formObj = document.form;
	var srcName = ComGetEvent("name");
	var srcMaxLength = ComGetEvent("maxlength");
	var srcValue = ComGetEvent("value");
	var sheetObject1 = sheetObjects[0];
	if(srcName == "modify_ens_eta"){

		if(document.getElementById("modify_ens_eta").checked == true){
			formObj.form_init_eta_dt.disabled = false;
			formObj.form_init_eta_dt.className="input";
		}else{
			formObj.form_init_eta_dt.className="input2";
			formObj.form_init_eta_dt.disabled = true;
		}
		
	}	
}


/**
 * change event of form input field
 * 
 * @return
 */
function obj_change() {
	var formObj=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=ComGetEvent("maxlength");
	var srcValue=ComGetEvent("value");
	if (srcName == "form_vvd") {
		//formObj.form_vvd.value = formObj.form_vvd.value.toUpperCase();
		var temp_vvd=formObj.form_vvd.value;
		doActionIBSheet(sheetObjects[0], formObj, IBINSERT);
		formObj.form_vvd.value=temp_vvd;
		formObj.p_vvd_cd.value=formObj.form_vvd.value;
		doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
		if(enterFlag==1){
			enterFlag=0;
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	if (srcName == "cstms_port_cd") {
		var comboIndex=comboObjects[0].GetSelectIndex();
	}
}
/**
 * when inputting search condition
 */
function obj_KeyUp() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=ComGetEvent("maxlength");
	var srcValue=ComGetEvent("value");
	/*
	 * if(srcName == "form_vvd_cd" && ComChkLen(srcValue, srcMaxLength)== "2"){
	 * ComSetNextFocus(); }
	 */
}
/**
 * in case of changing container list combo
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cstms_port_cd_OnChange(comboObj, value, text) {
	var formObj=document.form;
	var index=comboObj.GetSelectIndex();
	formObj.form_cstms_yd_cd.value=eu_1st_port_yd_cd[index];
}
