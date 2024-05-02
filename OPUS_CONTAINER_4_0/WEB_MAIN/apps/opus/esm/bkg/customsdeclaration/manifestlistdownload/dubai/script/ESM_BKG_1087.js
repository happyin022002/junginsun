/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ui_bkg_1087.js
*@FileTitle  : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
/****************************************************************************************
Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
//function esm_bkg_1087() {
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
//common global variables
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var tab2SearchFlag=false;
var tab3SearchFlag=false;
var sheetObjects=new Array();
var sheetCnt=0;
var aryPrefix=new Array("s1_", "s2_");
// Event handler processing by button click event
document.onclick=processButtonClick;
// Event handler processing by button name
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, SEARCH, 1);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject, formObject, MULTI);
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
function loadPage() {
	for (k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
		sheetObjects[i].SetWaitImageVisible(0);
	}
	doActionIBSheet(sheetObjects[0], document.form, SEARCH);
//	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
//	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
//	axon_event.addListener('keydown', 'obj_KeyDown', 'form');
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
		with (sheetObj) {
			var HeadTitle1="|bl_no|pod_cd|vsl_cd|skd_voy_no|skd_dir_cd|du_rotn_no|du_line_id|du_voy_agn_id|org_port_cd|por_cd|pol_cd|pod_cd|del_cd|du_mf_no|du_cgo_cd|du_cntr_svc_tp_cd|du_trd_cd|du_ts_mod_cd|cnsl_cgo_flg|org_cnt_cd|org_bl_no|org_vsl_cd|org_skd_voy_no|org_skd_dir_cd|org_vsl_nm|mk_no_ctnt|du_cmdt_cd|cmdt_desc|pck_qty|du_pck_desc|du_pck_tp_cd|cntr_no|cntr_knt|bkg_teu_qty|tare_wgt|cgo_wgt|grs_wgt|meas_qty|du_ttl_qty|du_frt_wgt|plt_qty|s_bkg_cust_tp_cd|s_cust_cnt_cd|s_cust_nm|s_cust_addr|s_org_cust_nm|s_org_cust_addr|c_bkg_cust_tp_cd|c_du_cust_id|c_cust_nm|c_cust_addr|c_org_cust_nm|c_org_cust_addr|n_bkg_cust_tp_cd|n_cust_nm|n_cust_addr";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bl_no" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"du_rotn_no" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"du_line_id" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"du_voy_agn_id" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"org_port_cd" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"por_cd" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"del_cd" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"du_mf_no" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"du_cgo_cd" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"du_cntr_svc_tp_cd" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"du_trd_cd" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"du_ts_mod_cd" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cnsl_cgo_flg" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"org_cnt_cd" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"org_bl_no" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"org_vsl_cd" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"org_skd_voy_no" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"org_skd_dir_cd" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vsl_nm" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"mk_no_ctnt" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"du_cmdt_cd" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_desc" },
				  {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pck_qty",            KeyField:0,   CalcLogic:"",   Format:"NullFloat" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"du_pck_desc" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"du_pck_tp_cd" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no" },
				  {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_knt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat" },
				  {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bkg_teu_qty",        KeyField:0,   CalcLogic:"",   Format:"NullFloat" },
				  {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"tare_wgt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat" },
				  {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cgo_wgt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat" },
				  {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"grs_wgt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat" },
				  {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"meas_qty",           KeyField:0,   CalcLogic:"",   Format:"NullFloat" },
				  {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"du_ttl_qty",         KeyField:0,   CalcLogic:"",   Format:"NullFloat" },
				  {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"du_frt_wgt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat" },
				  {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"plt_qty",            KeyField:0,   CalcLogic:"",   Format:"NullFloat" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"s_bkg_cust_tp_cd" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"s_cust_cnt_cd" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"s_cust_nm" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"s_cust_addr" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"s_org_cust_nm" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"s_org_cust_addr" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"c_bkg_cust_tp_cd" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"c_du_cust_id" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"c_cust_nm" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"c_cust_addr" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"c_org_cust_nm" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"c_org_cust_addr" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"n_bkg_cust_tp_cd" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"n_cust_nm" },
				  {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"n_cust_addr" } ];
			InitColumns(cols);
			SetEditable(1);
			sheet1.SetVisible(false);
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
 * initialize Tab Object
 */
function initTab(tabObj , tabNo) {
	switch(tabNo) {
		case 1:
		   with (tabObj) {
			   var cnt=0 ;
				InsertItem( "B/L Detail", "");
				InsertItem( "Customer Detail", "");
		   }
		break;
	}
	tabObj.SetSelectedIndex(0);
}
/**
* handling Tab Event
* @param tabObj Tab Object
* @param tabNo Tab No.
*/
function tab1_OnChange(tabObj, nItem) {
	var objs=document.all.item("tabLayer");
//	objs[nItem].style.display="Inline";
//	objs[beforetab].style.display="none";
//	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
	objs[nItem].style.display="Inline";
	for	(var i = 0; i < objs.length; i++) {
		if (i != nItem) {
			objs[i].style.display = "none";
			objs[i].style.zIndex=objs[nItem].style.zIndex -1 ;
		}
	}
	beforetab=nItem;
	if (nItem == 0)
		document.getElementById("title").innerHTML="Dubai Inbound Manifest - B/L Detail ";
	else
		document.getElementById("title").innerHTML="Dubai Inbound Manifest - Customer Detail ";
}
// handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction, tabno) {
	sheetObj.ShowDebugMsg(false);
	//
	formObj.f_cmd.value=sAction;
	switch (sAction) {
	case SEARCH: //Retrieve, Tab1
		ComOpenWait(true);
		var sXml=sheetObj.GetSearchData("ESM_BKG_1087GS.do", FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		sheetObj.LoadSearchData(arrXml[0],{Sync:0} );
		// DUBAI TRADE CODE
		ComXml2ComboItem(arrXml[1], bl_du_trd_cd, "val", "val|name");
		bl_du_trd_cd.InsertItem(0, "|", "");
		// DUBAI CARGO CODE
		ComXml2ComboItem(arrXml[2], bl_du_cgo_cd, "val", "val|desc");
		bl_du_cgo_cd.InsertItem(0, "|", "");
		// DUBAI CONTAINER SERVICE TYPE CODE
		ComXml2ComboItem(arrXml[3], bl_du_cntr_svc_tp_cd, "val", "val|desc");
		bl_du_cntr_svc_tp_cd.InsertItem(0, "|", "");
		// DUBAI TRANSSHIPMENT MODE CODE
		ComXml2ComboItem(arrXml[4], bl_du_ts_mod_cd, "val", "val|name");
		bl_du_ts_mod_cd.InsertItem(0, "|", "");
		//
		break;
	case MULTI: //Save
		if (validateForm(sheetObj, formObj, sAction)) {
			IBS_CopyFormToRow(formObj, sheetObj, 1, "bl_");
			sheetObj.SetCellValue(1, "du_trd_cd",bl_du_trd_cd.GetSelectCode());
			sheetObj.SetCellValue(1, "du_cgo_cd",bl_du_cgo_cd.GetSelectCode());
			sheetObj.SetCellValue(1, "du_cntr_svc_tp_cd",bl_du_cntr_svc_tp_cd.GetSelectCode());
			sheetObj.SetCellValue(1, "du_ts_mod_cd",bl_du_ts_mod_cd.GetSelectCode());
			var vvd=formObj.bl_org_vvd.value;
			if (vvd != "") {
				sheetObj.SetCellValue(1, "org_vsl_cd",vvd.substr(0,4),0);
				sheetObj.SetCellValue(1, "org_skd_voy_no",vvd.substr(4,4),0);
				sheetObj.SetCellValue(1, "org_skd_dir_cd",vvd.substr(8),0);
			}
			if (!sheetObj.IsDataModified()) {
				ComShowCodeMessage('BKG00743');
				return;
			}
			ComOpenWait(true);
			var sXml=sheetObj.GetSaveData("ESM_BKG_1087GS.do?f_cmd=" + MULTI, sheetObj.GetSaveString());
			//sheetObj.loadSaveXml(sXml); // 2014.08.20
			if (sXml != "") sheetObj.LoadSaveData(sXml,true);
			ComOpenWait(false);
		}
		break;
	}
}
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var formObj = document.form;
	tabObjects[0].SetSelectedIndex(formObj.tabIndex.value);
	if (sheetObj.RowCount() > 0) {
		IBS_CopyRowToForm(sheetObj, formObj, 1, "bl_");
		formObj.bl_pck_qty.value=ComAddComma2(formObj.bl_pck_qty, "#,###");
		formObj.bl_plt_qty.value=ComAddComma2(formObj.bl_plt_qty, "#,###");
		formObj.bl_cntr_knt.value=ComAddComma2(formObj.bl_cntr_knt, "#,###");
		formObj.bl_du_ttl_qty.value=ComAddComma2(formObj.bl_du_ttl_qty, "#,###");
		formObj.bl_tare_wgt.value=ComAddComma2(formObj.bl_tare_wgt, "#,###");
		formObj.bl_cgo_wgt.value=ComAddComma2(formObj.bl_cgo_wgt, "#,###");
		formObj.bl_bkg_teu_qty.value=ComAddComma2(formObj.bl_bkg_teu_qty, "#,###");
		formObj.bl_grs_wgt.value=ComAddComma2(formObj.bl_grs_wgt, "#,###");
		formObj.bl_du_frt_wgt.value=ComAddComma2(formObj.bl_du_frt_wgt, "#,###");
		formObj.bl_meas_qty.value=ComAddComma2(formObj.bl_meas_qty, "#,###");
		// 콤보세팅
		bl_du_trd_cd.SetSelectCode(sheetObj.GetCellValue(1, "du_trd_cd"));
		bl_du_cgo_cd.SetSelectCode(sheetObj.GetCellValue(1, "du_cgo_cd"));
		bl_du_cntr_svc_tp_cd.SetSelectCode(sheetObj.GetCellValue(1, "du_cntr_svc_tp_cd"));
		bl_du_ts_mod_cd.SetSelectCode(sheetObj.GetCellValue(1, "du_ts_mod_cd"));
		formObj.bl_org_vvd.value=sheetObj.GetCellValue(1, "org_vsl_cd")+ sheetObj.GetCellValue(1, "org_skd_voy_no")+ sheetObj.GetCellValue(1, "org_skd_dir_cd");
	}
	ComOpenWait(false);
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case MULTI: //Retrieve, Tab1
		if (!ComChkValid(formObj))
			return false;
		var elems=formObj.elements;
		for(var i=0; i < elems.length; i++) {
			var elem=elems[i];
			var sTitle=elem.getAttribute("caption");
			if (elem.type == "textarea") {
				if (elem.value.length > elem.getAttribute("maxlength")) {
					ComShowCodeMessage('COM12142', sTitle, elem.getAttribute("maxlength"));
					return false;
				}
			}
		}
		break;
	}
	return true;
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
