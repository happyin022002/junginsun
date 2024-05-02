/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0159.js
*@FileTitle  : ESM_BKG_0159
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Added code to make a good JSDoc ------------------*/
/**
 * @fileoverview JavaScript File is commonly using. calendar functions have is defined.
 * @author 
 */
/**
 * @extends
 * @class ESM_BKG_0159 : business script for ESM_BKG_0159
 */
// Common global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var bkgNo="";
var state="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/** ***  Tab ->two or more sheet : sheet  a variable assignment **** */
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject, document.form, IBSEARCH);
			break;
		case "btn_ediDownload":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;
		case "btn_cllForEdi":
			doActionIBSheet(sheetObject, formObject, COMMAND03);
			break;
		case "btn_edi":
			doActionIBSheet(sheetObject, formObject, COMMAND04);
			break;
		case "btn_faxemail":
			doActionIBSheet(sheetObject, formObject, COMMAND08);
			break;
		case "btn_sort":
			doActionIBSheet(sheetObject, formObject, COMMAND05);
			break;
		case "btn_new":
			document.form.reset();
			sheetObject.RemoveAll();
//			formObject.in_vvd_cd.focus();
			if (formObject.in_list_type_temp[0].checked) {
				document.all["pod_cd"].className="input1";
				document.all["pod_yd_cd"].className="input1";
				document.all["pol_cd"].className="input";
				document.all["pol_yd_cd"].className="input";
				formObject.in_pod_ts1.disabled = true;
				formObject.in_pod_ts2.disabled = true;
				formObject.in_pol_ts1.disabled = false;
				formObject.in_pol_ts2.disabled = false;
			} else {
				document.all["pod_cd"].className="input";
				document.all["pod_yd_cd"].className="input";
				document.all["pol_cd"].className="input1";
				document.all["pol_yd_cd"].className="input1";
				formObject.in_pod_ts1.disabled = false;
				formObject.in_pod_ts2.disabled = false;
				formObject.in_pol_ts1.disabled = true;
				formObject.in_pol_ts2.disabled = true;
			}
			break;
		case "btn_downExcel":
			doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
			break;
//		case "TAO/ODCY":
//			doActionIBSheet(sheetObjects[3], formObject, COMMAND09);
//			break;
		case "btn_print":
			doActionIBSheet(sheetObject, formObject, COMMAND06);
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
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 * @param sheet_obj IBSheet Object
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
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
	// IBMultiCombo initialization
	for ( var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}
	initControl();
	var formObj = document.form;
	doActionIBSheet(sheetObjects[5], formObj, SEARCH04);
	if(document.form.pop_mode.value == "VGM"){
		formObj.bkg_no_list.value = opener.form.bkg_no_list.value;
		formObj.in_vvd_cd.value = formObj.vgm_vvd.value;
		formObj.in_pol_cd.value = formObj.vgm_pol.value;
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}
}
/**
 * HTML Control on the page  loaded dynamically  the event. <br>
 * {@ link # loadPage} function this function  call initializes the IBSheet Object. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects array  sequence number
 */
function initControl() {
	// ** Date Delimiter **/
	DATE_SEPARATOR="-";
	var formObject=document.form;
	axon_event.addListenerForm('blur', 'obj_deactivate', formObject); // - Focus
	// Out
//	axon_event.addListenerFormat('focus', 'obj_activate', formObject); // - Focus
	// In
//	// axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // -
	
	// Keyboard
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	ComBtnDisable("btn_ediDownload");
	ComBtnDisable("btn_cllForEdi");
	ComBtnDisable("btn_edi");
	ComBtnDisable("btn_sort");
	ComBtnDisable("btn_downExcel");
//	ComBtnDisable("TAO/ODCY");
	ComBtnDisable("btn_print");
	ComBtnDisable("btn_faxemail");
	
	if(formObject.where_gubun.value == "ESM_BKG_0159-1"){
		formObject.in_pod_ts1.disabled = true;
		formObject.in_pod_ts2.disabled = true;
		formObject.in_pol_ts1.disabled = false;
		formObject.in_pol_ts2.disabled = false;
	}else{
		formObject.in_pod_ts1.disabled = false;
		formObject.in_pod_ts2.disabled = false;
		formObject.in_pol_ts1.disabled = true;
		formObject.in_pol_ts2.disabled = true;
	}
	
	doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
	// document.form.in_vvd_cd.focus()
}

/**
 * HTML Control onkeypress event Keyboard input and control.
 */
//function obj_keypress() {
//	switch (ComGetEvent("dataformat")) {
//	case "uppernum":
//		// enter only uppercase letters in English. English  uppercase+ numbers  -> ComKeyOnlyAlphabet('uppernum');
//		ComKeyOnlyAlphabet('uppernum');
//		break;
//	case "upper":
//		// enter only uppercase letters in English. English  uppercase+ numbers  -> ComKeyOnlyAlphabet('uppernum');
//		ComKeyOnlyAlphabet('upper');
//		break;
//	case "uppernum2":
//		// enter only uppercase letters in English. English  uppercase+ numbers  -> ComKeyOnlyAlphabet('uppernum');
//		ComKeyAlphabetNChar('uppernum');
//		break;
//	default:
//		// only numbers Input(integer, date, time)
//		ComKeyOnlyNumber(ComGetEvent());
//	}
//}
/**
 * The initial setting combo
 * 
 * @param {IBMultiCombo}
 *            comboObj comboObj
 */
function initCombo(comboObj) {
	comboObj.SetMultiSelect(1);
	comboObj.SetLineColor("#ffffff");
	comboObj.SetColAlign(0, "left");
	comboObj.SetColAlign(1, "left");
	comboObj.SetMultiSeparator(",");
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 * @param sheetObj sheet Object
 * @param sheetNo
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": // sheet1 init
		with (sheetObj) {
	        var HeadTitle1="ibflag|cntr_no2|Seq.|Sel.|VVD CD|Container No.|" +
	        "TP|Seal No.|Kind/Code|Kind/Code|W/O|WGT|WGT (T)|E.WGT (T)|" +
	        "PKG|PKG|VGM WGT|Booking No.|B/L No.|POR|POR|POR|" +
	        "A/POL|A/POL|A/POL|A/POD|A/POD|A/POD|B/POL|B/POL|B/POL|B/POD|B/POD|B/POD|Full P/UP Yard|Full P/UP Yard|DEL|DEL|DEL|" +
	        "BS|R|D|TS|CTP|Hot|Special Cargo|Special Cargo|" +
	        "Former Lane|Former VVD|Customer|Customs Description|Yard|Gate In Date|S.O.C|" +
	        "STOW|HTS Code|HS Code|Meas|" +
	        "Pre1.VVD|Pre2.VVD|Pre3.VVD|Pre4.VVD|Trunk VVD|Post1.VVD|Post2.VVD|Post3.VVD|Post4.VVD|" +
	        "Pre1.POL|Pre2.POL|Pre3.POL|Pre4.POL|Post1.POL|Post2.POL|Post3.POL|Post4.POL";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	        SetConfig( { SearchMode:2, FrozenCol:14, MergeSheet:7, Page:20, DataRowMerge:0 } );
	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_no2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:false },
		               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:false },
		               {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
		               
		               {Type:"Text",      Hidden:1, Width:170,    Align:"Center",  ColMerge:0,   SaveName:"out_vvd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		   			   
		               {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               
		               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seal_knd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seal_pty_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"wo_flg",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               
		               {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"a_cntr_wgt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cntr_wgt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"e_cntr_wgt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",               KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:25,   Align:"Right",   ColMerge:0,   SaveName:"pck_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Float",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"vgm_wgt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",            PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:95,   Align:"Left",    ColMerge:0,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:95,   Align:"Left",    ColMerge:0,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"por_nod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"por_nm" },
		               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"pol_yd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bpol_nm" },
		               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"pod_yd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bpod_nm" },
		               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"a_pol_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"pol_nod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"apol_nm" },
		               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"a_pod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"pod_nod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"apod_nm" },
		               {Type:"Text",      Hidden:0,  Width:52,   Align:"Center",  ColMerge:0,   SaveName:"pkup_loc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:27,   Align:"Center",  ColMerge:0,   SaveName:"pkup_nod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"del_nod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"del_nm" },
		               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"blck_stwg_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"de_term_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ts_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hot_de_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_desc_type",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"spcl_cgo_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:370,  Align:"Left",    ColMerge:0,   SaveName:"cust_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               
		               {Type:"Text",      Hidden:1,  Width:0,  Align:"Left",    ColMerge:0,   SaveName:"cstms_desc"},
		               
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"org_yd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"soc_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"stwg_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//		               {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"blck_stwg_hub_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"hamo_trf_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_hs_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"meas_qty",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"prevvd1",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"prevvd2",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"prevvd3",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"prevvd4",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"trunkvvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"postvvd1",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"postvvd2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"postvvd3",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"postvvd4",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"pre1pol",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"pre2pol",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"pre3pol",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"pre4pol",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"post1pol",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"post2pol",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"post3pol",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"post4pol",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	        InitColumns(cols);
	        SetEditable(1);
	        SetCountPosition(0);
            SetShowButtonImage(1);
	        SetSheetHeight(254);
		}
		break;
	case "sheet2": 
		with (sheetObj) {
	        var HeadTitle1="f_text1"
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	        var cols = [ {Type:"Text",  Hidden:0,  Width:200,  Align:"Left",  ColMerge:0,  SaveName:"f_text1",  KeyField:0,  CalcLogic:"",  Format:"",  PointCount:0 } ];
	        InitColumns(cols);
	        SetEditable(1);
	        SetVisible(0);
	        SetWaitTimeOut(6000);
	        SetSheetHeight(20, 1);
		}
		break;
	case "sheet3": // sheet_search
		cnt=0;
		with (sheetObj) {
	        var HeadTitle1="ibflag|SysCd|TmplMrd|Title|TmplParam|RcvInfo|SndNm|SndEml|Filekey|RcvEml|Contents|Bkg_no|Bl_no|TmplMrdPdf|itr|";
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	        var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"syscd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"tmplmrd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"title",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"tmplparam",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"rcvinfo",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"sndnm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"sndeml",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"filekey",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"rcveml",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"contents",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"history_gubun",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"tmplmrdpdf",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"itr",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 } ];
	        InitColumns(cols);
	        SetEditable(1);
	        SetSheetHeight(100, 1);
		}
		break;
	case "sheet4": // sheet1 init
		with (sheetObj) {
	        var HeadTitle1="BOUND|BKG_NO|BL_NO|SPLIT|ATD_DT|ATA_DT|AWK_FRONT|AWK_HEIGHT|AWK_LEFT|AWK_REAR|AWK_RIGHT|BKG_ACT_WGT|BKG_ACT_WGT_TP_CD" +
	        "|BKG_CGO_TP_CD|BKG_HOT_DEL_FLG|BKG_MEAS_QTY|BKG_MEAS_TP_CD|BKG_STS_CD|CARRIER_VSL_CD|CARRIERS_VOY_NO|CMDY_NM|CNEE_NM|CNTR_MEAS_QTY|CNTR_MEAS_TP_CD" +
	        "|CNTR_NO|CNTR_TPSZ_CD|CNTR_WGT_QTY|CNTR_WGT_TP_CD|CSTMS_RMK|DEL_LOC|DEPOT_CD|DG_CLS|DMG_STS|EMS|ETA_DT|ETD_DT|FSH_POINT|HUMIDITY|LANE_CODE|MAR_POL|PKG_GRP" +
	        "|BKG_PKG_QTY|BKG_PKG_TP_CD|POD_LOC|POL_LOC|RE_CMMD_NM|RF_TEMP|VENT|SEAL_NO|SHPR_NM|SOC_IND|SUBSI_RSK_FLG|UN_CD" +
	        "|CNTR_PKG_QTY|CNTR_PKG_TP_CD|DG_CGO_FLAG|RF_FLAG|AK_FLAG|HG_FLAG|EQ_SUB_FLAG|RD_FLAG|DST_SVC_ROUT|EXT_REMARK|BKG_TP|MST_BKG_NO";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	        SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	        var cols = [ {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bound" },
		               {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:false },
		               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:false },
		               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"split",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"atd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ata_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Int",       Hidden:0,  Width:60,   Align:"Center",   ColMerge:0,   SaveName:"awk_front",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",   ColMerge:0,   SaveName:"awk_height",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",   ColMerge:0,   SaveName:"awk_left",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",   ColMerge:0,   SaveName:"awk_rear",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",   ColMerge:0,   SaveName:"awk_right",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",    ColMerge:0,   SaveName:"bkg_act_wgt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",    ColMerge:0,   SaveName:"bkg_act_wgt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"bkg_hot_del_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bkg_meas_qty",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"bkg_meas_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bkg_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"carrier_vsl_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"carriers_voy_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"cmdy_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cnee_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"cntr_meas_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_meas_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_wgt_qty",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_wgt_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cstms_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_loc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"depot_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"dg_cls",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"dmg_sts",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ems",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:370,  Align:"Center",  ColMerge:0,   SaveName:"eta_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"etd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"fsh_point",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"humidity",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"lane_code",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"mar_pol",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"pkg_grp",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Center",   ColMerge:0,   SaveName:"bkg_pkg_qty",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Center",   ColMerge:0,   SaveName:"bkg_pkg_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Center",   ColMerge:0,   SaveName:"pod_loc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Center",   ColMerge:0,   SaveName:"pol_loc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Center",   ColMerge:0,   SaveName:"re_cmmd_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Center",   ColMerge:0,   SaveName:"rf_temp",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Center",   ColMerge:0,   SaveName:"vent",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Center",   ColMerge:0,   SaveName:"seal_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Center",   ColMerge:0,   SaveName:"shpr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Center",   ColMerge:0,   SaveName:"soc_ind",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Center",   ColMerge:0,   SaveName:"subsi_rsk_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:60,   Align:"Center",   ColMerge:0,   SaveName:"un_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_pkg_qty",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_pkg_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dg_cgo_flag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rf_flag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ak_flag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"hg_flag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"eq_sub_flag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rd_flag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dst_svc_rout",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ext_remark",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bkg_tp",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"mst_bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	        InitColumns(cols);
	        SetEditable(1);
	        SetSheetHeight(175);
		}
		break;
	case "sheet5": // LCL Cntr
		with (sheetObj) {
	        var HeadTitle1="cntr_no|cnt_flag"
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	        var cols = [ {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cntr_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"ibflag",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
	        InitColumns(cols);
	        SetEditable(1);
	        SetSheetHeight(80, 1);
		}
		break;
	case "sheet6": //Block Stowage
		with (sheetObj) {
			SetEditable(0);
			SetCountPosition(0);
		}
		break;
	}
}
/**
 * Sheet handling process
 * @param sheetObj Sheet
 * @param formObj form Object
 * @param sAction Work-handling code
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	// sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case COMMAND09: // retrieve
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		formObj.f_cmd.value=SEARCH02;
		if (formObj.in_list_type_temp[0].checked)
			formObj.in_list_type.value="L";
		else
			formObj.in_list_type.value="D";
		var xXml = sheetObj.GetSearchData("ESM_BKG_0159GS.do", FormQueryString(formObj) );
		sheetObj.LoadSearchData(xXml,{Sync:1} );
		ComEtcDataToForm(formObj, sheetObj);
		state=sheetObj.GetEtcData("TRANS_RESULT_KEY");
		if (state == "S") {
			var columnSkipList="";
			if(formObj.in_list_type.value == "D") {
				columnSkipList="dst_svc_rout";
			} else {
				columnSkipList="";
			}
			if(sheetObj.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				sheetObj.Down2Excel({ HiddenColumn:0,TreeLevel:false,AutoSizeColumn:1});
			}
		}
		ComOpenWait(false);
		break;
	case IBSEARCH: // retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			//top.document.body.scrollTop = 0;
			formObj.f_cmd.value=SEARCH;
			if (formObj.in_list_type_temp[0].checked)
				formObj.in_list_type.value="L";
			else
				formObj.in_list_type.value="D";
			if (formObj.in_ofc_cd_type_temp[0].checked)
				formObj.in_ofc_cd_type.value="B";
			else
				formObj.in_ofc_cd_type.value="S";
			if (formObj.in_pol_ts1.checked && formObj.in_pol_ts2.checked || !formObj.in_pol_ts1.checked && !formObj.in_pol_ts2.checked)
				formObj.in_pol_ts.value="";
			else if (formObj.in_pol_ts1.checked)
				formObj.in_pol_ts.value="L";
			else if (formObj.in_pol_ts2.checked)
				formObj.in_pol_ts.value="T";
			if (formObj.in_pod_ts1.checked && formObj.in_pod_ts2.checked || !formObj.in_pod_ts1.checked && !formObj.in_pod_ts2.checked)
				formObj.in_pod_ts.value="";
			else if (formObj.in_pod_ts1.checked)
				formObj.in_pod_ts.value="L";
			else if (formObj.in_pod_ts2.checked)
				formObj.in_pod_ts.value="T";
			if (formObj.in_cntr_cfm_flg1.checked && formObj.in_cntr_cfm_flg2.checked || !formObj.in_cntr_cfm_flg1.checked
					&& !formObj.in_cntr_cfm_flg2.checked)
				formObj.in_cntr_cfm_flg.value="";
			else if (formObj.in_cntr_cfm_flg1.checked)
				formObj.in_cntr_cfm_flg.value="Y";
			else if (formObj.in_cntr_cfm_flg2.checked)
				formObj.in_cntr_cfm_flg.value="N";
			if (formObj.in_cntr_match_temp.checked)
				formObj.in_cntr_match.value="N";
			else
				formObj.in_cntr_match.value="Y";
			if (formObj.in_dcgo_flg.checked)
				formObj.in_dcgo_flg.value="Y";
			else
				formObj.in_dcgo_flg.value="";
			if (formObj.in_rc_flg.checked)
				formObj.in_rc_flg.value="Y";
			else
				formObj.in_rc_flg.value="";
			if (formObj.in_awk_cgo_flg.checked)
				formObj.in_awk_cgo_flg.value="Y";
			else
				formObj.in_awk_cgo_flg.value="";
			if (formObj.in_bb_cgo_flg.checked)
				formObj.in_bb_cgo_flg.value="Y";
			else
				formObj.in_bb_cgo_flg.value="";
			if (formObj.in_stwg_cd.checked)
				formObj.in_stwg_cd.value="Y";
			else
				formObj.in_stwg_cd.value="";
			if (formObj.in_hot_de_flg.checked)
				formObj.in_hot_de_flg.value="Y";
			else
				formObj.in_hot_de_flg.value="";
			if (formObj.in_rd_cgo_flg.checked)
				formObj.in_rd_cgo_flg.value="Y";
			else
				formObj.in_rd_cgo_flg.value="";
			if (formObj.in_soc_flg.checked)
				formObj.in_soc_flg.value="Y";
			else
				formObj.in_soc_flg.value="";
			if (formObj.in_prct_flg.checked)
				formObj.in_prct_flg.value="Y";
			else
				formObj.in_prct_flg.value="";

			if (formObj.in_hngr_flg.checked)
				formObj.in_hngr_flg.value = "Y";
			else
				formObj.in_hngr_flg.value = "";

			if (formObj.in_including_type_temp.checked)
				formObj.in_including_type.value="Y";
			else
				formObj.in_including_type.value="N";
			// alert(formObj.in_including_type.value);
			// formObj.in_bkg_cgo_tp_cd.value = formObj.in_bkg_cgo_tp_cd.Code;
			// alert(formObj.in_bkg_cgo_tp_cd.value);
			if (in_bkg_cgo_tp_cd.GetSelectCode()== "A")
				formObj.in_bkg_cgo_tp_cd_temp.value="A";
			if (in_bkg_cgo_tp_cd.GetSelectCode()== "F")
				formObj.in_bkg_cgo_tp_cd_temp.value="F";
			if (in_bkg_cgo_tp_cd.GetSelectCode()== "P")
				formObj.in_bkg_cgo_tp_cd_temp.value="P";
			if (in_bkg_cgo_tp_cd.GetSelectCode()== "R")
				formObj.in_bkg_cgo_tp_cd_temp.value="R";
			if (in_bkg_cgo_tp_cd.GetSelectCode()== "B")
				formObj.in_bkg_cgo_tp_cd_temp.value="B";
			if (in_bkg_cgo_tp_cd.GetSelectCode()== "")
				formObj.in_bkg_cgo_tp_cd_temp.value="";
			// alert(formObj.in_bkg_cgo_tp_cd.value);
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			var sParam="";
			var sParamSheet2=sheetObjects[0].GetSaveString();
			if (sParamSheet2 != "") {
				sParam += "&" + ComSetPrifix(sParamSheet2, "");
			}
			sParam += "&" + FormQueryString(formObj);
			// alert(sParam);
			top.document.body.scrollTop=0;
			var sXml=sheetObj.GetSearchData("ESM_BKG_0159GS.do", sParam);
			var key=ComGetEtcData(sXml, "KEY");
			// top.document.body.scrollTop = 0;
			intervalId=setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
		}
		break;
	case IBSAVE: // Save
		if (validateForm(sheetObj, formObj, sAction)) {
			//top.document.body.scrollTop = 0;
			formObj.f_cmd.value=MULTI;
			if (formObj.in_pol_ts1.checked && formObj.in_pol_ts2.checked || !formObj.in_pol_ts1.checked && !formObj.in_pol_ts2.checked)
				formObj.in_pol_ts.value="";
			else if (formObj.in_pol_ts1.checked)
				formObj.in_pol_ts.value="L";
			else if (formObj.in_pol_ts2.checked)
				formObj.in_pol_ts.value="T";
			
			if (formObj.in_including_type_temp.checked)
				formObj.in_including_type.value="Y";
			else
				formObj.in_including_type.value="N";

			if (formObj.in_cntr_match_temp.checked)
				formObj.in_cntr_match.value="N";
			else
				formObj.in_cntr_match.value="Y";
			
			// sheetObj.CheckAll("del_chk") = 1;
			// ComOpenWait(true);
			sheetObjects[0].SetWaitImageVisible(0);
			ComOpenWait(true);
			for ( var i=1; i < sheetObjects[0].RowCount()+ 1; i++) {
				//sheetObjects[0].CellValue(i, "ibflag") = "I";
				sheetObjects[0].SetRowStatus(i,"I");
			}
			var sParam="";
			var sParamSheet2=sheetObjects[0].GetSaveString();
			if (sParamSheet2 != "") {
				sParam += "&" + ComSetPrifix(sParamSheet2, "");
			}
			sParam += "&" + FormQueryString(formObj);
			// ComOpenWait(true);
			top.document.body.scrollTop=0;
			var sXml=sheetObjects[0].GetSaveData("ESM_BKG_0159GS.do", sParam);
			var key=ComGetEtcData(sXml, "KEY");
			// ComOpenWait(true);
			// alert("!!!!!");
			// top.document.body.scrollTop = 0;
			intervalId=setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
			// top.document.body.scrollTop = 0;
		}
		break;
	case COMMAND01: // Input
		formObj.f_cmd.value=INIT;
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		var sXml=sheetObj.GetSearchData("ESM_BKG_0159GS.do", FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		ComXml2ComboItem(arrXml[0], in_bkg_cgo_tp_cd, "val", "desc");
		// ComXml2ComboItem(arrXml[0], formObj.in_bkg_cgo_tp_cd, "val", "name");
		in_bkg_cgo_tp_cd.SetDropHeight(300);
		// ComXml2ComboItem(arrXml[1], formObj.in_cntr_tpsz_cd, "cntr_tpsz_cd",
		// "cntr_tpsz_cd|cntr_tpsz_cd");
		ComXml2ComboItem(arrXml[1], in_cntr_tpsz_cd, "cntr_tpsz_cd", "cntr_tpsz_cd");
		in_cntr_tpsz_cd.SetDropHeight(300);
		// comboObjects[1].Code = "D2,D4";
		// ComXml2ComboItem(arrXml[2], in_rcv_term_cd, "val",
		// "val|name");
		ComXml2ComboItem(arrXml[2], in_rcv_term_cd, "val", "name");
		in_rcv_term_cd.SetDropHeight(300);
		// ComXml2ComboItem(arrXml[2], formObj.in_de_term_cd, "val",
		// "val|name");
		ComXml2ComboItem(arrXml[3], in_de_term_cd, "val", "name");
		in_de_term_cd.SetDropHeight(300);
		// ComXml2ComboItem(arrXml[3], formObj.in_org_trns_svd_mod_cd, "val",
		// "val|name");
		ComXml2ComboItem(arrXml[4], in_org_trns_svd_mod_cd, "val", "name");
		in_org_trns_svd_mod_cd.SetDropHeight(300);
		// ComXml2ComboItem(arrXml[3], formObj.in_dest_trns_svc_mod_cd, "val",
		// "val|name");
		ComXml2ComboItem(arrXml[4], in_dest_trns_svc_mod_cd, "val", "name");
		in_dest_trns_svc_mod_cd.SetDropHeight(300);
		ComOpenWait(false);
		break;
	case IBDOWNEXCEL:
		var noRows="";
		if (validateForm(sheetObj, formObj, sAction)) {
			for ( var i=1; i <= sheetObj.RowCount()+ 1; i++) {
				if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "") {
					noRows=noRows + i + "|";
				}
			}
			
			if (noRows.length > 0)
				noRows=noRows.substring(0, noRows.length - 1);
			
			if(sheetObj.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				sheetObj.Down2Excel({ SheetDesign:1, DownCols:makeHiddenSkipCol(sheetObj), Merge:1});  
			}
		}
		break;
	case COMMAND03: // Input
		var inListType="";
		if (formObj.in_list_type_temp[0].checked)
			inListType="L";
		else
			inListType="D";
		var inVvdCd=formObj.in_vvd_cd.value;
		var inPolCd=formObj.in_pol_cd.value;
		var inPodCd=formObj.in_pod_cd.value;
		var inPolTs="";
		if (formObj.in_pol_ts1.checked && formObj.in_pol_ts2.checked || !formObj.in_pol_ts1.checked && !formObj.in_pol_ts2.checked)
			inPolTs="";
		else if (formObj.in_pol_ts1.checked)
			inPolTs="L";
		else if (formObj.in_pol_ts2.checked)
			inPolTs="T";
		var sUrl="/opuscntr/ESM_BKG_0155.do?pgmNo=ESM_BKG_0155&inListType=" + inListType + "&inVvdCd=" + inVvdCd + "&inPolCd=" + inPolCd
				+ "&inPodCd=" + inPodCd;
		ComOpenWindowCenter(sUrl, "ESM_BKG_0155", 1024, 580, true);
		break;
	case COMMAND04: // Input
		if (validateForm(sheetObj, formObj, sAction)) {
			var inListType="";
			if (formObj.in_list_type_temp[0].checked)
				inListType="L";
			else
				inListType="D";
			var inVvdCd=formObj.in_vvd_cd.value;
			var inPolCd=formObj.in_pol_cd.value;
			var inPodCd=formObj.in_pod_cd.value;
			var sUrl="/opuscntr/ESM_BKG_0723.do?pgmNo=ESM_BKG_0723&inListType=" + inListType + "&inVvdCd=" + inVvdCd + "&inPolCd=" + inPolCd
					+ "&inPodCd=" + inPodCd;
			ComOpenWindowCenter(sUrl, "ESM_BKG_0723", 420, 430, true);
		}
		break;
	case COMMAND05: // btn_sort
		var sUrl="/opuscntr/ESM_BKG_0161.do?pgmNo=ESM_BKG_0161&codeGubun=CD02298";
		ComOpenWindowCenter(sUrl, "ESM_BKG_0161", 450, 280, true);
		break;
	case COMMAND08: // Input
		var sUrl="/opuscntr/ESM_BKG_0221.do?pgmNo=ESM_BKG_0221&ui_id=ESM_BKG_0159&ok_hidden=Y";
		ComOpenWindowCenter(sUrl, "ESM_BKG_0221", 360, 200, true);
		break;
	case COMMAND06: // Input
		var inListType="";
		if (formObj.in_list_type_temp[0].checked)
			inListType="L";
		else
			inListType="D";
		var inOfcCdType="";
		if (formObj.in_ofc_cd_type_temp[0].checked)
			inOfcCdType="B";
		else
			inOfcCdType="S";
		var inPolTs="";
		if (formObj.in_pol_ts1.checked && formObj.in_pol_ts2.checked || !formObj.in_pol_ts1.checked && !formObj.in_pol_ts2.checked)
			inPolTs="";
		else if (formObj.in_pol_ts1.checked)
			inPolTs="L";
		else if (formObj.in_pol_ts2.checked)
			inPolTs="T";
		var inPodTs="";
		if (formObj.in_pod_ts1.checked && formObj.in_pod_ts2.checked || !formObj.in_pod_ts1.checked && !formObj.in_pod_ts2.checked)
			inPodTs="";
		else if (formObj.in_pod_ts1.checked)
			inPodTs="L";
		else if (formObj.in_pod_ts2.checked)
			inPodTs="T";
		var inCntrCfmFlg="";
		if (formObj.in_cntr_cfm_flg1.checked && formObj.in_cntr_cfm_flg2.checked || !formObj.in_cntr_cfm_flg1.checked
				&& !formObj.in_cntr_cfm_flg2.checked)
			inCntrCfmFlg="";
		else if (formObj.in_cntr_cfm_flg1.checked)
			inCntrCfmFlg="Y";
		else if (formObj.in_cntr_cfm_flg2.checked)
			inCntrCfmFlg="N";
		var inCntrMatch="";
		if (formObj.in_cntr_match_temp.checked)
			inCntrMatch="N";
		else
			inCntrMatch="Y";
		var inDcgoFlg="";
		if (formObj.in_dcgo_flg.checked)
			inDcgoFlg="Y";
		else
			inDcgoFlg="";
		var inRcFlg="";
		if (formObj.in_rc_flg.checked)
			inRcFlg="Y";
		else
			inRcFlg="";
		var inAwkCgoFlg="";
		if (formObj.in_awk_cgo_flg.checked)
			inAwkCgoFlg="Y";
		else
			inAwkCgoFlg="";
		var inBbCgoFlg="";
		if (formObj.in_bb_cgo_flg.checked)
			inBbCgoFlg="Y";
		else
			inBbCgoFlg="";
		var inStwgCd="";
		if (formObj.in_stwg_cd.checked)
			inStwgCd="Y";
		else
			inStwgCd="";
		var inHotDeFlg="";
		if (formObj.in_hot_de_flg.checked)
			inHotDeFlg="Y";
		else
			inHotDeFlg="";
		var inRdCgoFlg="";
		if (formObj.in_rd_cgo_flg.checked)
			inRdCgoFlg="Y";
		else
			inRdCgoFlg="";
		var inSocFlg="";
		if (formObj.in_soc_flg.checked)
			inSocFlg="Y";
		else
			inSocFlg="";
		var inPrctFlg="";
		if (formObj.in_prct_flg.checked)
			inPrctFlg="Y";
		else
			inPrctFlg="";

		var inHngrFlg = "";
		if (formObj.in_hngr_flg.checked)
			inHngrFlg = "Y";
		else
			inHngrFlg = "";
		
		var inIncludingType="";
		if (formObj.in_including_type_temp.checked)
			inIncludingType="Y";
		else
			inIncludingType="N";
		var inBkgCgoTpCd="";
		var tempArray=in_bkg_cgo_tp_cd.GetSelectCode().split(",");
		for ( var i=0; i < tempArray.length; i++) {
			// alert(tempArray[i]);
			inBkgCgoTpCd=inBkgCgoTpCd + "'" + tempArray[i] + "',";
		}
		if (inBkgCgoTpCd == "'',")
			inBkgCgoTpCd="";
		if (inBkgCgoTpCd.length > 0)
			inBkgCgoTpCd=inBkgCgoTpCd.substr(0, inBkgCgoTpCd.length - 1);
		var inCntrTpszCd="";
		var tempArray=in_cntr_tpsz_cd.GetSelectCode().split(",");
		for ( var i=0; i < tempArray.length; i++) {
			// alert(tempArray[i]);
			inCntrTpszCd=inCntrTpszCd + "'" + tempArray[i] + "',"
		}
		if (inCntrTpszCd == "'',")
			inCntrTpszCd="";
		if (inCntrTpszCd.length > 0)
			inCntrTpszCd=inCntrTpszCd.substr(0, inCntrTpszCd.length - 1);
		var inRcvTermCd="";
		var tempArray=in_rcv_term_cd.GetSelectCode().split(",");
		for ( var i=0; i < tempArray.length; i++) {
			// alert(tempArray[i]);
			inRcvTermCd=inRcvTermCd + "'" + tempArray[i] + "',"
		}
		if (inRcvTermCd == "'',")
			inRcvTermCd="";
		if (inRcvTermCd.length > 0)
			inRcvTermCd=inRcvTermCd.substr(0, inRcvTermCd.length - 1);
		var inDeTermCd="";
		var tempArray=in_de_term_cd.GetSelectCode().split(",");
		for ( var i=0; i < tempArray.length; i++) {
			// alert(tempArray[i]);
			inDeTermCd=inDeTermCd + "'" + tempArray[i] + "',"
		}
		if (inDeTermCd == "'',")
			inDeTermCd="";
		if (inDeTermCd.length > 0)
			inDeTermCd=inDeTermCd.substr(0, inDeTermCd.length - 1);
		var inOrgTrnsSvdModCd="";
		var tempArray=in_org_trns_svd_mod_cd.GetSelectCode().split(",");
		for ( var i=0; i < tempArray.length; i++) {
			// alert(tempArray[i]);
			inOrgTrnsSvdModCd=inOrgTrnsSvdModCd + "'" + tempArray[i] + "',"
		}
		if (inOrgTrnsSvdModCd == "'',")
			inOrgTrnsSvdModCd="";
		if (inOrgTrnsSvdModCd.length > 0)
			inOrgTrnsSvdModCd=inOrgTrnsSvdModCd.substr(0, inOrgTrnsSvdModCd.length - 1);
		var inDestTrnsSvcModCd="";
		var tempArray=in_dest_trns_svc_mod_cd.GetSelectCode().split(",");
		for ( var i=0; i < tempArray.length; i++) {
			// alert(tempArray[i]);
			inDestTrnsSvcModCd=inDestTrnsSvcModCd + "'" + tempArray[i] + "',"
		}
		if (inDestTrnsSvcModCd == "'',")
			inDestTrnsSvcModCd="";
		if (inDestTrnsSvcModCd.length > 0)
			inDestTrnsSvcModCd=inDestTrnsSvcModCd.substr(0, inDestTrnsSvcModCd.length - 1);
		
		var spclStwgParam="";
		for(var stwgCol=1; stwgCol<=sheetObjects[5].LastCol(); stwgCol++){
			var blckStwgCd = sheetObjects[5].GetCellValue(0, stwgCol);
			var stwgValue = Number(sheetObjects[5].GetCellValue(1, stwgCol));
			if(stwgValue=="") stwgValue=0;
			if(spclStwgParam==""){
				spclStwgParam = blckStwgCd + " : " + stwgValue;
			}else{
				spclStwgParam = spclStwgParam + ",     " + blckStwgCd + " : " + stwgValue;
			}
		}//getparam("$72")
		
		// alert(inIncludingType);
		var param="/rp [" + inListType + "][" + inOfcCdType + "][" + formObj.in_ofc_cd.value + "][" + formObj.in_bkg_sts_cd.value + "]["
				+ inBkgCgoTpCd + "][" + formObj.in_vvd_cd.value + "][" + formObj.in_pol_cd.value + "][" + inPolTs + "][" + formObj.in_pod_cd.value
				+ "][" + inPodTs + "][" + inCntrTpszCd + "][" + formObj.in_por_cd.value + "][" + formObj.in_del_cd.value + "][" + inRcvTermCd + "]["
				+ inDeTermCd + "][" + inOrgTrnsSvdModCd + "][" + inDestTrnsSvcModCd + "][" + inDcgoFlg + "][" + inRcFlg + "][" + inAwkCgoFlg + "]["
				+ inBbCgoFlg + "][" + inStwgCd + "][" + inHotDeFlg + "][" + inRdCgoFlg + "][" + inSocFlg + "][" + inPrctFlg + "][" + inCntrCfmFlg
				+ "][" + inCntrMatch + "][" + formObj.in_order_by_type.value + "][" + formObj.in_pol_yd_cd.value + "][" + formObj.in_pod_yd_cd.value
				+ "][" + formObj.in_scc_cd.value + "][" + formObj.vvd_nkm.value + "][" + formObj.un_loc_cd.value + "][" + formObj.vps_eta_dt.value
				+ "][" + formObj.vps_etd_dt.value + "][" + formObj.vps_etb_dt.value + "][" + formObj.d2.value + "][" + formObj.d4.value + "]["
				+ formObj.d5.value + "][" + formObj.d7.value + "][" + formObj.d8.value + "][" + formObj.d9.value + "][" + formObj.dw.value + "]["
				+ formObj.dx.value + "][" + formObj.r2.value + "][" + formObj.r4.value + "][" + formObj.r5.value + "][" + formObj.f2.value + "]["
				+ formObj.f4.value + "][" + formObj.f5.value + "][" + formObj.o2.value + "][" + formObj.o4.value + "][" + formObj.s2.value + "]["
				+ formObj.s4.value + "][" + formObj.t2.value + "][" + formObj.t4.value + "][" + formObj.a2.value + "][" + formObj.a4.value + "]["
				+ formObj.p2.value + "][" + formObj.p4.value + "][" + formObj.total20.value + "][" + formObj.total40.value + "][" + formObj.totalTpSize.value
				+ "][" + formObj.full.value + "][" + formObj.empty.value + "][" + formObj.local.value + "][" + formObj.ts.value + "]["
				+ formObj.ewgt.value + "][" + formObj.wgt.value + "][" + formObj.measure.value + "][" 
				+ spclStwgParam + "][" //72번째
				+ inIncludingType + "][" + inHngrFlg + "][" + formObj.o5.value + "][]";
		formObj.com_mrdArguments.value=param;
		ComOpenRDPopup("width=1024, height=650");
		// ComOpenWindowCenter(sUrl, "0783", 1024, 720, false);
		break;
	case COMMAND07: // Input
		comBkgCallPopBkgDetail(bkgNo);
		// var sUrl = "/opuscntr/ESM_BKG_0079.do?pgmNo=ESM_BKG_0079&bkg_no=" + bkgNo;
		// ComOpenWindowCenter(sUrl, "ESM_BKG_0079", 1024, 630, false);
		break;
		
	case SEARCH04: //Block Stowage setting
		formObj.f_cmd.value=SEARCH04;
		var blckStwg=ComSearchEtcData(sheetObj, "ESM_BKG_0159GS.do",FormQueryString(formObj), 'blck_stwg');
		initSheetBlckStwg(blckStwg);
		break;
	}
}
/**
 * BackEndJob handling
 * @param sheetObj Sheet
 * @param sKey sKey
 */
function doActionValidationResult(sheetObj, sKey) {
	sheetObjects[5].RemoveAll();
	sheetObjects[5].DataInsert();
	// top.document.body.scrollTop = 0;
	var formObj=document.form;
	// sheetObjects[0].WaitImageVisble = false;
	// ComOpenWait(true);
	// top.document.body.scrollTop = 0;
	var sXml=sheetObj.GetSearchData("ESM_BKG_0159GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey + "&formCommand=" + formObj.f_cmd.value);
	// ComOpenWait(true);
	var arrXml=sXml.split("|$$|");
	var sJbStsFlg=ComGetEtcData(arrXml[0], "jb_sts_flg");
	formObj.vessel_name.value=ComGetEtcData(arrXml[0], "vessel_name");
	// alert(formObj.vessel_name.value);
	// top.document.body.scrollTop = 0;
	// When an error occurs, the standby shut down.
	if (!ComBkgErrMessage(sheetObj, arrXml[0])) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		//alert(document.form.f_cmd.value);
		clearInterval(intervalId);
		ComOpenWait(false);
		if (document.form.f_cmd.value == "2") {
			sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
			sheetObjects[4].LoadSearchData(arrXml[1],{Sync:1} );
			state=sheetObjects[0].GetEtcData("TRANS_RESULT_KEY");
			if (state == "S") {
				var d2=0;
				var d4=0;
				var d5=0;
				var d7=0;
				var d8=0;
				var d9=0;
				var dw=0;
				var dx=0;
				var r2=0;
				var r4=0;
				var r5=0;
				var f2=0;
				var f4=0;
				var f5=0;
				var o2=0;
				var o4=0;
				var o5=0;
				var s2=0;
				var s4=0;
				var t2=0;
				var t4=0;
				var a2=0;
				var a4=0;
				var p2=0;
				var p4=0;
				var z2=0;
				var z4=0;
				var totalTpSize=0;
				var local=0;
				var full=0;
				var empty=0;
				var ts=0;
				var wgt=0;
				var wgt2=0;
				var wgt3=0;
				var measure=0;
				var total20=0;
				var total40=0;
				var cntrTpszCd="";
				var blckStwgCd="";
				sheetObjects[0].SetColFontColor("bkg_no","#0000FF");
				sheetObjects[0].SetColFontUnderline("bkg_no",1);
				var skip=false;
				for ( var i=1; i <= sheetObjects[0].RowCount(); i++) {
					for (var j=1; j < sheetObjects[4].RowCount()+ 1; j++) {
						if (sheetObjects[0].GetCellValue(i, "cntr_no") == sheetObjects[4].GetCellValue(j, "cntr_no")) {
							if (sheetObjects[4].GetCellValue(j, "ibflag") == "Y") {
								skip=true;
							} else {
								sheetObjects[4].SetCellValue(j, "ibflag","Y",0);
							}
							break;
						}
					}
					if (!skip) {
						if (sheetObjects[0].GetCellValue(i, "seq") == "") {
							sheetObjects[0].SetRowEditable(i,0);
						}
						cntrTpszCd=sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd");
						if (cntrTpszCd == "D2") {
							d2=d2 + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "D4") {
							d4=d4 + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "D5") {
							d5=d5 + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "D7") {
							d7=d7 + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "D8") {
							d8=d8 + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "D9") {
							d9=d9 + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "DW") {
							dw=dw + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "DX") {
							dx=dx + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "R2") {
							r2=r2 + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "R4") {
							r4=r4 + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "R5") {
							r5=r5 + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "R7") {
							r5 = r5 + 1;
							totalTpSize = totalTpSize + 1;
						}
						if (cntrTpszCd == "R8") {
							r5 = r5 + 1;
							totalTpSize = totalTpSize + 1;
						}
						if (cntrTpszCd == "R9") {
							r5 = r5 + 1;
							totalTpSize = totalTpSize + 1;
						}
						if (cntrTpszCd == "F2") {
							f2=f2 + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "F4") {
							f4=f4 + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "F5") {
							f5=f5 + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "O2") {
							o2=o2 + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "O4") {
							o4=o4 + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "O5") {
							o5 = o5 + 1;
							totalTpSize = totalTpSize + 1;
						}
						if (cntrTpszCd == "S2") {
							s2=s2 + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "S4") {
							s4=s4 + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "T2") {
							t2=t2 + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "T4") {
							t4=t4 + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "A2") {
							a2=a2 + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "A4") {
							a4=a4 + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "P2") {
							p2=p2 + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (cntrTpszCd == "P4") {
							p4=p4 + 1;
							totalTpSize=totalTpSize + 1;
//							wgt=wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
//							wgt2=wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
//							measure=measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
						}
						if (sheetObjects[0].GetCellValue(i, "seq") != "") {
							if (sheetObjects[0].GetCellValue(i, "ts_cd").substring(0, 1) == "T")
								ts=ts + 1;
							else
								local=local + 1;
							if (sheetObjects[0].GetCellValue(i, "bkg_cgo_tp_cd") != "P")
								full=full + 1;
							else
								empty=empty + 1;
						}
						blckStwgCd=sheetObjects[0].GetCellValue(i, "blck_stwg_cd");
						for(var stwgCol=1; stwgCol<=sheetObjects[5].LastCol(); stwgCol++){
							if(blckStwgCd==sheetObjects[5].ColSaveName(0, stwgCol)){
								var orgStwgValue = Number(sheetObjects[5].GetCellValue(1, stwgCol));
								if(orgStwgValue=="") orgStwgValue=0;
								sheetObjects[5].SetCellValue(1, stwgCol, orgStwgValue+1);
							}
						}
					}
					skip=false;
					
					if (cntrTpszCd == "D2") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "D4") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "D5") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "D7") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "D8") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "D9") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "DW") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "DX") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "R2") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "R4") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "R5") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "R7") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "R8") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "R9") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "F2") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "F4") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "F5") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "O2") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "O4") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "O5") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "S2") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "S4") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "T2") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "T4") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "A2") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "A4") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "P2") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
					if (cntrTpszCd == "P4") {
						wgt = wgt + sheetObjects[0].GetCellValue(i, "cntr_wgt") * 1;
						wgt2 = wgt2 + sheetObjects[0].GetCellValue(i, "e_cntr_wgt") * 1;
						measure = measure + sheetObjects[0].GetCellValue(i, "meas_qty") * 1;
					}
				}
				total20=d2 + r2 + f2 + o2 + s2 + t2 + a2 + p2;
				total40=d4 + d5 + d7 + d8+ d9 + dw + dx + r4 + r5 + f4 + f5 + o4 + o5 + s4 + t4 + a4 + p4;
				formObj.d2.value=d2;
				formObj.d4.value=d4;
				formObj.d5.value=d5;
				formObj.d7.value=d7;
				formObj.d8.value=d8;
				formObj.d9.value=d9;
				formObj.dw.value=dw;
				formObj.dx.value=dx;
				formObj.r2.value=r2;
				formObj.r4.value=r4;
				formObj.r5.value=r5;
				formObj.f2.value=f2;
				formObj.f4.value=f4;
				formObj.f5.value=f5;
				formObj.o2.value=o2;
				formObj.o4.value=o4;
				formObj.o5.value=o5;
				formObj.s2.value=s2;
				formObj.s4.value=s4;
				formObj.t2.value=t2;
				formObj.t4.value=t4;
				formObj.a2.value=a2;
				formObj.a4.value=a4;
				formObj.p2.value=p2;
				formObj.p4.value=p4;
				formObj.total20.value=total20;
				formObj.total40.value=total40;
				formObj.totalTpSize.value=totalTpSize;
				formObj.local.value=local;
				formObj.ts.value=ts;
				formObj.empty.value=empty;
				formObj.full.value=full;
				formObj.wgt.value=wgt;
				// alert(wgt2);
				// alert(wgt2/1000);
				formObj.ewgt.value=wgt2;
				// alert(measure);
				formObj.measure.value=measure / 1000;
				// alert(formObj.measure.value);
				// alert(formObj.measure.value);
				var rowCnt=sheetObjects[0].RowCount();
				// alert(rowCnt);
				var arrVvd  = formObj.in_vvd_cd.value.split(",")

				if (rowCnt == 0 || arrVvd.length > 1 ) {
					ComBtnDisable("btn_ediDownload");
					ComBtnDisable("btn_cllForEdi");
					ComBtnDisable("btn_edi");
					ComBtnDisable("btn_sort");
					ComBtnDisable("btn_downExcel");
//					ComBtnDisable("TAO/ODCY");
					ComBtnDisable("btn_print");
					ComBtnDisable("btn_faxemail");
					if ( arrVvd.length > 1 ){
						ComBtnEnable("btn_downExcel");
					}
					if ( rowCnt == 0 ){
						ComBtnDisable("btn_downExcel");
					}
				} else {
					// alert(formObj.in_list_type_temp[0].checked );
					if (formObj.in_list_type_temp[0].checked) {
						ComBtnEnable("btn_ediDownload");
						ComBtnEnable("btn_cllForEdi");
						ComBtnDisable("btn_edi");
					} else {
						ComBtnDisable("btn_ediDownload");
						ComBtnDisable("btn_cllForEdi");
						ComBtnEnable("btn_edi");
					}
					ComBtnEnable("btn_sort");
					ComBtnEnable("btn_downExcel");
//					ComBtnEnable("TAO/ODCY");
					ComBtnEnable("btn_print");
					ComBtnEnable("btn_faxemail");
				}
				sheetObj.CheckAll("del_chk",0);
				formObj.wgt.value=ComGetMaskedValue(formObj.wgt.value, 'int');
				formObj.ewgt.value=ComGetMaskedValue(formObj.ewgt.value, 'int');
				formObj.measure.value=ComGetMaskedValue(formObj.measure.value, 'float');
				// formObj.measure.value =
				// ComGetMaskedValue(formObj.measure.value,'float');
				// alert(formObj.measure.value);
				if (formObj.in_list_type_temp[0].checked) {
					sheetObjects[0].SetCellValue(0, "vvd_cd","Former VVD");
					sheetObjects[0].SetCellValue(0, "slan_cd","Former Lane");
				} else {
					sheetObjects[0].SetCellValue(0, "vvd_cd","Next VVD");
					sheetObjects[0].SetCellValue(0, "slan_cd","Next Lane");
				}
			}
		} else {
			//alert("test");
			ComShowMessage(ComResultMessage(arrXml[0]));
		}
		return;
	} else if (sJbStsFlg == "FAIL") {
		// Error
		clearInterval(intervalId);
		ComOpenWait(false);
		// Error Message
		ComShowMessage(ComResultMessage(arrXml[0]));
	}
}
/**
 * gubun results: cll or cdl are change mandatory 
 * @param gubun gubun
 */
function clickListType(gubun) {
	var formObj=document.form;
	// var rowCnt = sheetObjects[0].RowCount;
	if (gubun == "0") {
		// alert(document.all["pod_cd"].className);
		document.all["pod_cd"].className="input1";
		document.all["pod_yd_cd"].className="input1";
		document.all["pol_cd"].className="input";
		document.all["pol_yd_cd"].className="input";
		formObj.in_cntr_match_temp.disabled=false;
		formObj.in_pod_ts1.checked = false;
		formObj.in_pod_ts2.checked = false;
		formObj.in_pod_ts1.disabled = true;
		formObj.in_pod_ts2.disabled = true;
		formObj.in_pol_ts1.disabled = false;
		formObj.in_pol_ts2.disabled = false;
		// if ( rowCnt > 0 )
		// {
		// ComBtnEnable("btn_cllForEdi");
		// ComBtnDisable("btn_edi");
		// }
	} else {
		document.all["pod_cd"].className="input";
		document.all["pod_yd_cd"].className="input";
		document.all["pol_cd"].className="input1";
		document.all["pol_yd_cd"].className="input1";
		formObj.in_cntr_match_temp.disabled=true;
		formObj.in_cntr_match_temp.checked=false;
		formObj.in_pol_ts1.checked = false;
		formObj.in_pol_ts2.checked = false;
		formObj.in_pol_ts1.disabled = true;
		formObj.in_pol_ts2.disabled = true;
		formObj.in_pod_ts1.disabled = false;
		formObj.in_pod_ts2.disabled = false;
		// if ( rowCnt > 0 )
		// {
		// ComBtnDisable("btn_cllForEdi");
		// ComBtnEnable("btn_edi");
		// }
	}
}
/**
 * handling process for input validation
 * @param sheetObj Sheet
 * @param formObj form Object
 * @param sAction Work-handling code
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // retrieve
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		var arrVvd  = formObj.in_vvd_cd.value.split(",");
		
		if (formObj.in_list_type_temp[0].checked) {
			if (ComTrim(formObj.in_vvd_cd.value) == "" || ComTrim(formObj.in_vvd_cd.value).length != 9) {
				if(arrVvd.length < 2 ){
					ComShowCodeMessage('BKG00213');
//					formObj.in_vvd_cd.focus();
					return false;
				}
			}
			if (formObj.in_pol_cd.value == "" || formObj.in_pol_cd.value.length != 5) {
				ComShowCodeMessage('BKG00213');
//				formObj.in_pol_cd.focus();
				return false;
			}
		} else {
			if (ComTrim(formObj.in_vvd_cd.value) == "" || ComTrim(formObj.in_vvd_cd.value).length != 9) {
				if(arrVvd.length < 2 ){
					ComShowCodeMessage('BKG00203');
//				formObj.in_vvd_cd.focus();
					return false;
				}
			}
			if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
				ComShowCodeMessage('BKG00203');
//				formObj.in_pod_cd.focus();
				return false;
			}
		}
		return true;
		break;
	case IBSAVE: // retrieve
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if (formObj.in_list_type_temp[0].checked) {
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00213');
//				formObj.in_vvd_cd.focus();
				return false;
			}
			if (formObj.in_pol_cd.value == "" || formObj.in_pol_cd.value.length != 5) {
				ComShowCodeMessage('BKG00213');
//				formObj.in_pol_cd.focus();
				return false;
			}
		} else {
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00203');
//				formObj.in_vvd_cd.focus();
				return false;
			}
			if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
				ComShowCodeMessage('BKG00203');
//				formObj.in_pod_cd.focus();
				return false;
			}
		}
		return true;
		break;
	case COMMAND03: // retrieve
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if (formObj.in_list_type_temp[0].checked) {
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00213');
//				formObj.in_vvd_cd.focus();
				return false;
			}
			if (formObj.in_pol_cd.value == "" || formObj.in_pol_cd.value.length != 5) {
				ComShowCodeMessage('BKG00213');
//				formObj.in_pol_cd.focus();
				return false;
			}
		} else {
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00203');
//				formObj.in_vvd_cd.focus();
				return false;
			}
			if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
				ComShowCodeMessage('BKG00203');
//				formObj.in_pod_cd.focus();
				return false;
			}
		}
		return true;
		break;
	case COMMAND04: // CDL EDI
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if (formObj.in_list_type_temp[0].checked) {
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00213');
//				formObj.in_vvd_cd.focus();
				return false;
			}
			if (formObj.in_pol_cd.value == "" || formObj.in_pol_cd.value.length != 5) {
				ComShowCodeMessage('BKG00213');
//				formObj.in_pol_cd.focus();
				return false;
			}
		} else {
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00203');
//				formObj.in_vvd_cd.focus();
				return false;
			}
			if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
				ComShowCodeMessage('BKG00203');
//				formObj.in_pod_cd.focus();
				return false;
			}
		}
		var vIsCheck=false;
		for ( var i=1; i <= sheetObj.RowCount()+ 1; i++) {
			if (sheetObj.GetCellValue(i, "del_chk") == 1) {
				vIsCheck=true;
				break;
			}
		}
		if (!vIsCheck) {
			// alert("test");
			ComShowCodeMessage('BKG00249', '');
			return false;
		}
		
		// when seal# or pkg is blank, then show the confirm message about go or stop
		var msg = "";
		var rowNums = [];
		for ( var i=1; i <= sheetObj.RowCount()+ 1; i++) {
			if (sheetObj.GetCellValue(i, "seq") == "" || sheetObj.GetCellValue(i, "del_chk") == 0) {
				continue;
			}
			if (sheetObj.GetCellValue(i, "cntr_seal_no") == "" || sheetObj.GetCellValue(i, "pck_qty") == "" || sheetObj.GetCellValue(i, "pck_tp_cd") == "" ) {
				if(msg != ""){
					msg = msg + "\n";
				}
				msg = msg + "#" + sheetObj.GetCellValue(i, "seq") + ". " + sheetObj.GetCellValue(i, "cntr_no") + " " + sheetObj.GetCellValue(i, "bkg_no");
				rowNums.push(i);
			}
		}
		if(msg != ""){
			if(!ComShowCodeConfirm("BKG08344", msg)){
				for (index = 0; index < rowNums.length; index++) {
				     var rnum = rowNums[index];
				     sheetObj.SetCellValue(rnum, "del_chk", 0);
				 } 
				return false;
			}
		}
		
		return true;
		break;
	case COMMAND05: // retrieve
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if (formObj.in_list_type_temp[0].checked) {
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00213');
//				formObj.in_vvd_cd.focus();
				return false;
			}
			if (formObj.in_pol_cd.value == "" || formObj.in_pol_cd.value.length != 5) {
				ComShowCodeMessage('BKG00213');
//				formObj.in_pol_cd.focus();
				return false;
			}
		} else {
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00203');
//				formObj.in_vvd_cd.focus();
				return false;
			}
			if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
				ComShowCodeMessage('BKG00203');
//				formObj.in_pod_cd.focus();
				return false;
			}
		}
		return true;
		break;
	case COMMAND06: // retrieve
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if (formObj.in_list_type_temp[0].checked) {
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00213');
//				formObj.in_vvd_cd.focus();
				return false;
			}
			if (formObj.in_pol_cd.value == "" || formObj.in_pol_cd.value.length != 5) {
				ComShowCodeMessage('BKG00213');
//				formObj.in_pol_cd.focus();
				return false;
			}
		} else {
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00203');
//				formObj.in_vvd_cd.focus();
				return false;
			}
			if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
				ComShowCodeMessage('BKG00203');
//				formObj.in_pod_cd.focus();
				return false;
			}
		}
		return true;
		break;
	}
	return true;
}
/**
 * Re-search as a condition selected from the pop-up sroting
 * @param sortString sortString
 */
function setOrderBy(sortString) {
	// alert(sortString);
	document.form.in_order_by_type.value=sortString;
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
 * Sheet handling from checkbox
 * @param sheetObj Sheet
 * @param row row
 * @param col col
 */
function sheet1_OnClick(sheetObj, row, col) {
	var rowCnt=sheetObj.RowCount();
	var check=sheetObj.GetCellValue(row, "del_chk");
	var keyCntrNo=sheetObj.GetCellValue(row, "cntr_no");
	var colSaveName=sheetObj.ColSaveName(col);
	for (i=1; i <= rowCnt + 2; i++) {
		if (colSaveName == "del_chk") {
			if (check == 0) {
				if (i == row)
					continue;
				if (keyCntrNo == sheetObj.GetCellValue(i, "cntr_no")) {
					sheetObj.SetCellValue(i, "del_chk",1);
				}
			} else if (check == 1) {
				if (i == row)
					continue;
				if (keyCntrNo == sheetObj.GetCellValue(i, "cntr_no")) {
					sheetObj.SetCellValue(i, "del_chk",0);
				}
			}
		}
	} // end for(i)
}
/**
 * Sheet Bkg_no double click -> Popup 
 * @param sheetObj sheetObj
 * @param row row
 * @param col col
 */
function sheet1_OnDblClick(sheetObj, row, col) {
	var formObj=document.form;
	bkgNo=sheetObj.GetCellValue(row, "bkg_no");
	var colSaveName=sheetObj.ColSaveName(col);
	if (colSaveName == "bkg_no")
		doActionIBSheet(sheetObj, formObj, COMMAND07);
}
/**
 * In the pop-up screen, the fax number and e-mail address Input -> the call transfer function Call 
 * @param faxNo faxNo
 * @param eMail eMail
 */
function sendFaxEmail(faxNo, eMail) {
	var formObj=document.form;
	formObj.fax.value=faxNo;
	formObj.email.value=eMail;
	paramSet(sheetObjects[2], document.form);
}
/**
 * for send  Parameters setting, fax number and e-mail address
 * @param sheetObject sheetObject
 * @param formObj formObj
 */
function paramSet(sheetObject, formObj) {
	var sheetObjectData=sheetObjects[0];
	var rdParam="";
	var strPath="";
	var strPdf="";
	var bkg_no="";
	var inListType="";
	if (formObj.in_list_type_temp[0].checked)
		inListType="L";
	else
		inListType="D";
	var inOfcCdType="";
	if (formObj.in_ofc_cd_type_temp[0].checked)
		inOfcCdType="B";
	else
		inOfcCdType="S";
	var inPolTs="";
	if (formObj.in_pol_ts1.checked && formObj.in_pol_ts2.checked || !formObj.in_pol_ts1.checked && !formObj.in_pol_ts2.checked)
		inPolTs="";
	else if (formObj.in_pol_ts1.checked)
		inPolTs="L";
	else if (formObj.in_pol_ts2.checked)
		inPolTs="T";
	var inPodTs="";
	if (formObj.in_pod_ts1.checked && formObj.in_pod_ts2.checked || !formObj.in_pod_ts1.checked && !formObj.in_pod_ts2.checked)
		inPodTs="";
	else if (formObj.in_pod_ts1.checked)
		inPodTs="L";
	else if (formObj.in_pod_ts2.checked)
		inPodTs="T";
	var inCntrCfmFlg="";
	if (formObj.in_cntr_cfm_flg1.checked && formObj.in_cntr_cfm_flg2.checked || !formObj.in_cntr_cfm_flg1.checked
			&& !formObj.in_cntr_cfm_flg2.checked)
		inCntrCfmFlg="";
	else if (formObj.in_cntr_cfm_flg1.checked)
		inCntrCfmFlg="Y";
	else if (formObj.in_cntr_cfm_flg2.checked)
		inCntrCfmFlg="N";
	var inCntrMatch="";
	if (formObj.in_cntr_match_temp.checked)
		inCntrMatch="N";
	else
		inCntrMatch="Y";
	var inDcgoFlg="";
	if (formObj.in_dcgo_flg.checked)
		inDcgoFlg="Y";
	else
		inDcgoFlg="";
	var inRcFlg="";
	if (formObj.in_rc_flg.checked)
		inRcFlg="Y";
	else
		inRcFlg="";
	var inAwkCgoFlg="";
	if (formObj.in_awk_cgo_flg.checked)
		inAwkCgoFlg="Y";
	else
		inAwkCgoFlg="";
	var inBbCgoFlg="";
	if (formObj.in_bb_cgo_flg.checked)
		inBbCgoFlg="Y";
	else
		inBbCgoFlg="";
	var inStwgCd="";
	if (formObj.in_stwg_cd.checked)
		inStwgCd="Y";
	else
		inStwgCd="";
	var inHotDeFlg="";
	if (formObj.in_hot_de_flg.checked)
		inHotDeFlg="Y";
	else
		inHotDeFlg="";
	var inRdCgoFlg="";
	if (formObj.in_rd_cgo_flg.checked)
		inRdCgoFlg="Y";
	else
		inRdCgoFlg="";
	var inSocFlg="";
	if (formObj.in_soc_flg.checked)
		inSocFlg="Y";
	else
		inSocFlg="";
	var inPrctFlg="";
	if (formObj.in_prct_flg.checked)
		inPrctFlg="Y";
	else
		inPrctFlg="";
	
	var inHngrFlg = "";
	if (formObj.in_hngr_flg.checked)
		inHngrFlg = "Y";
	else
		inHngrFlg = "";
	
	var inIncludingType="";
	if (formObj.in_including_type_temp.checked)
		inIncludingType="Y";
	else
		inIncludingType="N";
	var inBkgCgoTpCd="";
	var tempArray=in_bkg_cgo_tp_cd.GetSelectCode().split(",");
	for ( var i=0; i < tempArray.length; i++) {
		// alert(tempArray[i]);
		inBkgCgoTpCd=inBkgCgoTpCd + "'" + tempArray[i] + "',";
	}
	if (inBkgCgoTpCd == "'',")
		inBkgCgoTpCd="";
	if (inBkgCgoTpCd.length > 0)
		inBkgCgoTpCd=inBkgCgoTpCd.substr(0, inBkgCgoTpCd.length - 1);
	var inCntrTpszCd="";
	var tempArray=in_cntr_tpsz_cd.GetSelectCode().split(",");
	for ( var i=0; i < tempArray.length; i++) {
		// alert(tempArray[i]);
		inCntrTpszCd=inCntrTpszCd + "'" + tempArray[i] + "',"
	}
	if (inCntrTpszCd == "'',")
		inCntrTpszCd="";
	if (inCntrTpszCd.length > 0)
		inCntrTpszCd=inCntrTpszCd.substr(0, inCntrTpszCd.length - 1);
	var inRcvTermCd="";
	var tempArray=in_rcv_term_cd.GetSelectCode().split(",");
	for ( var i=0; i < tempArray.length; i++) {
		// alert(tempArray[i]);
		inRcvTermCd=inRcvTermCd + "'" + tempArray[i] + "',"
	}
	if (inRcvTermCd == "'',")
		inRcvTermCd="";
	if (inRcvTermCd.length > 0)
		inRcvTermCd=inRcvTermCd.substr(0, inRcvTermCd.length - 1);
	var inDeTermCd="";
	var tempArray=in_de_term_cd.GetSelectCode().split(",");
	for ( var i=0; i < tempArray.length; i++) {
		// alert(tempArray[i]);
		inDeTermCd=inDeTermCd + "'" + tempArray[i] + "',"
	}
	if (inDeTermCd == "'',")
		inDeTermCd="";
	if (inDeTermCd.length > 0)
		inDeTermCd=inDeTermCd.substr(0, inDeTermCd.length - 1);
	var inOrgTrnsSvdModCd="";
	var tempArray=in_org_trns_svd_mod_cd.GetSelectCode().split(",");
	for ( var i=0; i < tempArray.length; i++) {
		// alert(tempArray[i]);
		inOrgTrnsSvdModCd=inOrgTrnsSvdModCd + "'" + tempArray[i] + "',"
	}
	if (inOrgTrnsSvdModCd == "'',")
		inOrgTrnsSvdModCd="";
	if (inOrgTrnsSvdModCd.length > 0)
		inOrgTrnsSvdModCd=inOrgTrnsSvdModCd.substr(0, inOrgTrnsSvdModCd.length - 1);
	var inDestTrnsSvcModCd="";
	var tempArray=in_dest_trns_svc_mod_cd.GetSelectCode().split(",");
	for ( var i=0; i < tempArray.length; i++) {
		// alert(tempArray[i]);
		inDestTrnsSvcModCd=inDestTrnsSvcModCd + "'" + tempArray[i] + "',"
	}
	if (inDestTrnsSvcModCd == "'',")
		inDestTrnsSvcModCd="";
	if (inDestTrnsSvcModCd.length > 0)
		inDestTrnsSvcModCd=inDestTrnsSvcModCd.substr(0, inDestTrnsSvcModCd.length - 1);
	
	var spclStwgParam="";
	for(var stwgCol=1; stwgCol<=sheetObjects[5].LastCol(); stwgCol++){
		var blckStwgCd = sheetObjects[5].GetCellValue(0, stwgCol);
		var stwgValue = Number(sheetObjects[5].GetCellValue(1, stwgCol));
		if(stwgValue=="") stwgValue=0;
		if(spclStwgParam==""){
			spclStwgParam = blckStwgCd + " : " + stwgValue;
		}else{
			spclStwgParam = spclStwgParam + ",     " + blckStwgCd + " : " + stwgValue;
		}
	}//getparam("$72")
	
	var rdParam="/rp [" + inListType + "][" + inOfcCdType + "][" + formObj.in_ofc_cd.value + "][" + formObj.in_bkg_sts_cd.value + "]["
			+ inBkgCgoTpCd + "][" + formObj.in_vvd_cd.value + "][" + formObj.in_pol_cd.value + "][" + inPolTs + "][" + formObj.in_pod_cd.value + "]["
			+ inPodTs + "][" + inCntrTpszCd + "][" + formObj.in_por_cd.value + "][" + formObj.in_del_cd.value + "][" + inRcvTermCd + "]["
			+ inDeTermCd + "][" + inOrgTrnsSvdModCd + "][" + inDestTrnsSvcModCd + "][" + inDcgoFlg + "][" + inRcFlg + "][" + inAwkCgoFlg + "]["
			+ inBbCgoFlg + "][" + inStwgCd + "][" + inHotDeFlg + "][" + inRdCgoFlg + "][" + inSocFlg + "][" + inPrctFlg + "][" + inCntrCfmFlg + "]["
			+ inCntrMatch + "][" + formObj.in_order_by_type.value + "][" + formObj.in_pol_yd_cd.value + "][" + formObj.in_pod_yd_cd.value + "]["
			+ formObj.in_scc_cd.value + "][" + formObj.vvd_nkm.value + "][" + formObj.un_loc_cd.value + "][" + formObj.vps_eta_dt.value + "]["
			+ formObj.vps_etd_dt.value + "][" + formObj.vps_etb_dt.value + "][" + formObj.d2.value + "][" + formObj.d4.value + "]["
			+ formObj.d5.value + "][" + formObj.d7.value + "][" + formObj.d8.value + "][" + formObj.d9.value + "][" + formObj.dw.value + "]["
			+ formObj.dx.value + "][" + formObj.r2.value + "][" + formObj.r4.value + "][" + formObj.r5.value + "][" + formObj.f2.value + "]["
			+ formObj.f4.value + "][" + formObj.f5.value + "][" + formObj.o2.value + "][" + formObj.o4.value + "][" + formObj.s2.value + "]["
			+ formObj.s4.value + "][" + formObj.t2.value + "][" + formObj.t4.value + "][" + formObj.a2.value + "][" + formObj.a4.value + "]["
			+ formObj.p2.value + "][" + formObj.p4.value + "][" + formObj.total20.value + "][" + formObj.total40.value + "][" + formObj.totalTpSize.value
			+ "][" + formObj.full.value + "][" + formObj.empty.value + "][" + formObj.local.value + "][" + formObj.ts.value + "]["
			+ formObj.ewgt.value + "][" + formObj.wgt.value + "][" + formObj.measure.value + "][" 
			+ spclStwgParam + "][" //72번째
			+ inIncludingType + "][" + inHngrFlg + "][" + formObj.o5.value + "][]";
	// alert(rdParam);
	// rdParam = "/rv form_bkgNo[( '" + bkg_no + "') ] form_type[2]
	// form_dataOnly[N] form_manifest[N] form_hiddeData[N] form_mainOnly[N]
	// form_level[(1)] form_remark[] form_Cntr[1] ";
	// rdParam += "form_CorrNo[] form_his_cntr[BKG_CONTAINER]
	// form_his_bkg[BKG_BOOKING] form_his_mkd[BKG_BL_MK_DESC]
	// form_his_xpt[BKG_XPT_IMP_LIC] form_his_bl[BKG_BL_DOC] /rp []
	// /riprnmargin";
	strPath="ESM_BKG_0783.mrd";
	if (formObj.in_list_type_temp[0].checked)
		strPdf=formObj.in_vvd_cd.value + "(CLL).pdf";
	else
		strPdf=formObj.in_vvd_cd.value + "(CDL).pdf";
	var bkgNo2="";
	if (sheetObjectData.RowCount()> 0) {
		bkgNo2="|";
	}
	var title="";
	if (formObj.in_list_type_temp[0].checked) {
		title = "Container Loading List(VVD: " + formObj.in_vvd_cd.value + ", Loading Port: " + formObj.in_pol_cd.value + ")";
	}else{
		title = "Container Discharging List(VVD: " + formObj.in_vvd_cd.value + ", Discharging Port: " + formObj.in_pod_cd.value + ")";
	}
	var Row1=sheetObject.DataInsert();
	sheetObject.SetCellValue(Row1, "bkg_no",bkgNo2,0);
	sheetObject.SetCellValue(Row1, "bl_no","",0);
	sheetObject.SetCellValue(Row1, "syscd","BKG",0);
	sheetObject.SetCellValue(Row1, "tmplmrd",strPath,0);
	sheetObject.SetCellValue(Row1, "batchflg","N",0);
	sheetObject.SetCellValue(Row1, "tmplparam",rdParam,0);
	sheetObject.SetCellValue(Row1, "rcvinfo",formObj.fax.value,0);
	sheetObject.SetCellValue(Row1, "tmplmrdpdf",strPdf,0);// change pdf name(RD file name)
	sheetObject.SetCellValue(Row1, "history_gubun","N",0);// change pdf name(RD file name)
	sheetObject.SetCellValue(Row1, "title",title,0);
	// ---> pdf name)
	sheetObject.SetCellValue(Row1, "itr","|$$|",0);
	var Row2=sheetObject.DataInsert();
	sheetObject.SetCellValue(Row2, "bkg_no",bkgNo2,0);
	sheetObject.SetCellValue(Row2, "bl_no","",0);
	sheetObject.SetCellValue(Row2, "syscd","BKG",0);
	sheetObject.SetCellValue(Row2, "tmplmrd",strPath,0);
	sheetObject.SetCellValue(Row2, "batchflg","N",0);
	sheetObject.SetCellValue(Row2, "tmplparam",rdParam,0);
	sheetObject.SetCellValue(Row2, "history_gubun","N",0);// change pdf name(RD file name)
//	 alert("ggg -> " + inListType);
//	 alert("Row2 : " + Row2);
	if (formObj.in_list_type_temp[0].checked) {
		sheetObject.SetCellValue(Row2, "title",title);
		sheetObject.SetCellValue(Row2, "contents","Dear Partner,\n\nPlease refer to the attachment for Container Loading List\n\n- VVD: "
				+ formObj.in_vvd_cd.value + "\n- Loading Port: " + formObj.in_pol_cd.value + "\n\nNYK Shipping Co., Ltd");
	} else {
		sheetObject.SetCellValue(Row2, "title",title);
		sheetObject.SetCellValue(Row2, "contents","Dear Partner,\n\nPlease refer to the attachment for Container Discharging List\n\n- VVD: "
			+ formObj.in_vvd_cd.value + "\n- Discharging Port: " + formObj.in_pod_cd.value + "\n\nNYK Shipping Co., Ltd");
	}
	//alert("ddd-> " + sheetObject.CellValue(Row2, "contents"));
	sheetObject.SetCellValue(Row2, "rcveml",formObj.email.value,0);// Receive e-mail address
	sheetObject.SetCellValue(Row2, "tmplmrdpdf",strPdf,0);// change pdf name(RD file name)
	// ---> pdf file name)
	sheetObject.SetCellValue(Row2, "itr","|$$|",0);
	FaxEmailSend(sheetObject, formObj);
}
/**
 * Fax and E-mail 
 * @param sheetObj sheetObj
 * @param formObject formObject
 */
function FaxEmailSend(sheetObj, formObject) {
	ComOpenWait(true);
	formObject.f_cmd.value=SEARCH01;
	var sXml=sheetObj.GetSaveData("ESM_BKG_0221GS.do", FormQueryString(formObject) + "&" + sheetObj.GetSaveString());
	ComOpenWait(false);
	if (sXml.substring(1, 6) == "ERROR") {
		//
		alert(ComResultMessage(sXml).split('<||>').join('\n'));
	} else {
		//
		var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
		// alert("State : [" + State + "]");
		if (State == "S") {
			ComShowCodeMessage('BKG06082');
		}
	}
	sheetObj.RemoveAll();
	return;
}

function sheet1_OnSearchEnd(sheetObj, errMsg) {
	ComOpenWait(false);
}

/**
* VVD Selection Inquiry Popup Open
*/
function getVvds(){
	var param = ""
	var pWin = ComOpenWindow("ESM_BKG_0753.do" + param,"open0753", "statebar=no,width=920,height=390,left=200,top=0");
}

/**
 * VVD Selection Inquiry Popup Value Import
 */
function setVvds(vvds){
  var formObj = document.form;
  document.form.in_vvd_cd.value = vvds;
}

function clearVvds(){
 document.form.in_vvd_cd.value = "";
}

function initSheetBlckStwg(blckStwg){
	var sheetObj = sheetObjects[5];
	var blckStwgArr;
	if(blckStwg==null || blckStwg==""){
		blckStwgArr="";
	} else{
		blckStwgArr= blckStwg.split("|"); 
	}
	var colWidth = Math.floor(90 / blckStwgArr.length);
	var colWidthStr = "10";
	
	with (sheetObj) {
		var HeadTitle1="Block Stowage|"+blckStwg
			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		InitHeaders(headers, info);
		var cols = [ {Type:"Text",       Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"title" }];
		var tempArray=in_org_trns_svd_mod_cd.GetSelectCode().split(",");
		for ( var i=0; i < blckStwgArr.length; i++) {
			var str = "cols.push({Type:'Text',     Hidden:0,  Width:55,   Align:'Center',  ColMerge:0,   SaveName:\""+blckStwgArr[i]+"\" })";
			eval(str);
			colWidthStr = colWidthStr + "|" + colWidth;
		}
		InitColumns(cols);
		SetSheetHeight(71);
		FitColWidth(colWidthStr);
		DataInsert(-1);
	}
}