/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0041.js
*@FileTitle  : AMS Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================*/
/****************************************************************************************
Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_BKG-0041 : business script for ESM_BKG-0041
 */
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var changetab=0;
var sheetObjects=new Array();
var sheetCnt=0;
/** ********************* EDTITABLE MULIT COMBO START ******************* */
var comboCnt=0;
var comboObjects=new Array();
var rcv_term_cdMultiComboDataAdded=false;
var de_term_cdMultiComboDataAdded=false;
var customs_result_codeXml=null;
var resultXmlFor1=null;
var resultXmlFor2=null;
/**
 * register combo Object to comboObjects array
 * 
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) { 
	comboObjects[comboCnt++]=combo_obj;
}
/**
 * Combo basic setting
 */
function initCombo(comboObj, comboId) {
	var formObject=document.form
	comboObj.SetDropHeight(135);
	comboObj.SetMultiSelect(0);
	comboObj.SetUseEdit(0);
	if (comboObj.options.id == "filer") {
		comboObj.SetDropHeight(235);
		comboObj.SetMultiSelect(1);
	} else if (comboObj.options.id == "customs_result_code") {
		comboObj.SetDropHeight(235);
		comboObj.SetUseEdit(1);
	} else if (comboObj.options.id == "eq_ofc"){
		comboObj.SetDropHeight(300);
		comboObj.SetMultiSelect(1);
	}
	initComboEditable(comboObj)
}
function initComboEditable(combo) {
	with (combo) {
		SetUseAutoComplete(1);
	}
}
// Event handler processing by button click event
document.onclick=processButtonClick;
// Event handler processing by button name
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
        
		if (!ComIsBtnEnable(srcName)) return;
        
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, document.form, IBSEARCH);
			break;
		case "btn_BLInquiry":
			doActionIBSheet(sheetObject1, document.form, SEARCH11);
			break;
		case "btn_InquiryByCntr":
			doActionIBSheet(sheetObject1, document.form, SEARCH12);
			break;
		case "btn_BlCharge":
			doActionIBSheet(sheetObject1, document.form, SEARCH13);
			break;
		case "btn_RailAmsHistory":
			doActionIBSheet(sheetObject1, document.form, SEARCH14);
			break;
		case "btn_Downexcel":
			if(sheetObject1.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				doActionIBSheet(sheetObject1, document.form, IBDOWNEXCEL);
			}
			break;
		case "btn_Print":
			doActionIBSheet(sheetObject1, document.form, SEARCH15);
			break;
		
		case "btn_2q4q":
			doActionIBSheet(sheetObject1, document.form, SEARCH07);
			break;
		case "btn_2r4r":
			doActionIBSheet(sheetObject1, document.form, SEARCH08);
			break;
		
		case "btn_2z":
			doActionIBSheet(sheetObject1, document.form, SEARCH04);
			break;
		case "btn_6h6i":
			doActionIBSheet(sheetObject1, document.form, SEARCH05);
			break;
		case "btn_non3Z":
			doActionIBSheet(sheetObject1, document.form, SEARCH06);
			break;
		case "btn_calendar":
			if (formObject.fromd.disabled)
				return;
			var cal=new ComCalendarFromTo();
			cal.select(formObject.fromd, formObject.tod, 'yyyy-MM-dd');
			break;
		case "btn_Close":
			ComClosePopup();
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
	for ( var k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		tabObjects[k].SetSelectedIndex(0);
	}
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
		sheetObjects[i].SetWaitImageVisible(0);
	}
	for ( var k=0 ; k < comboObjects.length ; k++ ) {
		initCombo(comboObjects[k], k+1);
	}
	initControl();
	// delay 0.1 sec
	doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
	
	if (document.form.mbl_no.value != "") {
		tabObjects[0].SetSelectedIndex(1);
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	
	if(document.form.hid_vvd.value != "" && document.form.hid_last_pol.value != "") {
		tab1.SetSelectedIndex(3);
	}
}
/**
 * handling process for key event
 */
 function obj_KeyUp() {
	 var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	 var formObject=document.form;
	 var srcName=ComGetEvent("name");
	 var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	 var srcValue=window.event.srcElement.getAttribute("value");
	 if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
		 ComSetNextFocus();
	 }
 }
 /**
  * Dynamically load HTML Control event in page. <br>
  * Initialize IBSheet Object by calling this function from {@link #loadPage} function.
  **/
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR="-";
	var formObject=document.form;
	//axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); // - 키보드 입력할때
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListener('click', 'chkClick2', 'form');
	axon_event.addListenerForm('change', 'chkChange2', formObject);
	//axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: //sheet1 init
	    with(sheetObj){
			var HeadTitle="Seq.|Code|M.B/L No.|Manifest File No.|Filer|C.STS|Stage|VVD|POL|POD|DEL|HUB|CNTR No.|TP/SZ|F|O|C|P|Consignee/Notify|P/MIB No.|TP|FTZ|P/MIB Issue Date|P/MIB Accepted Date|Arrival Date|Arrival Accepted Date|Export Date|Export Accepted Date|R|D|Customs Reply Date|S/C|||||";
			var headCount=ComCountHeadTitle(HeadTitle) + 1;
			SetConfig( { SearchMode:2, MergeSheet:7, Page:20 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dspo_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mbl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ams_file_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"filer",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mf_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cstms_mf_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"hub_loc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"frt_clt_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"obl_rdem_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cstms_clr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_prt_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cust_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ibd_trsp_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibd_trsp_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"free_trd_zn_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"ibd_trsp_iss_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"ibd_trsp_acpt_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"ibd_trsp_arr_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"ibd_trsp_arr_acpt_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"ibd_trsp_xpt_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"ibd_trsp_xpt_acpt_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"de_term_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"arr_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"sc_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cstms_dspo_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bl_cnt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"total",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];

			InitColumns(cols);
//			SetSheetHeight(320);
			SetSheetHeight($(window).height() - AnchorPosition_getPageOffsetTop(sheetObj) - 50);
			
//			ComResizeSheet(sheetObj);
//			SetSheetWidth(1280);
			SetEditable(0);
            }
		break;
	case 2: //sheet2 init
	    with(sheetObj){
			var HeadTitle="Seq.|Code|M.B/L No.|CNTR No.|TP/SZ|Rail AMS File No.|VVD|POL|POD|DEL|HUB|F|O|C|Consignee/Notify|FTZ|P/MIB No.|P/MIB Accepted Date|Arrival Date|Pick-Up No.|Pick-Up No.\nReleased|Pick-Up No.\nRelease Date|R|D|Customs Reply Date|S/C|||||";
			var headCount=ComCountHeadTitle(HeadTitle);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dspo_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ams_file_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rail_crr_ref_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"hub_loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"frt_clt_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"obl_rdem_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cstms_clr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cust_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"free_trd_zn_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"usa_ib_trsp_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"ibd_trsp_acpt_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"ibd_trsp_arr_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:1, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"pkup_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"pkup_released",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"pkup_date",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"de_term_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"arr_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"sc_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cstms_dspo_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"total",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
			   
			InitColumns(cols);
            SetSheetHeight($(window).height() - AnchorPosition_getPageOffsetTop(sheetObjects[0]) - 70);
//			ComResizeSheet(sheetObj);

			SetEditable(0);
			SetCountFormat("[SELECTDATAROW / TOTALROWS]");
      }
		break;
	case 3: // ISF5
	    with(sheetObj){
			var HeadTitle="Seq.|M.B/L No.|Manifest File No.|Filer|M/H|VVD|POL|POD|Action\nType|Customs Result|Description|Send Date|Receive Date|Consignee/Notify";
			var headCount=ComCountHeadTitle(HeadTitle) + 2;
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
						 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mbl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ams_file_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"filer",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mh",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"isf_act_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"isf_rslt_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"isf_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"snd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rcv_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cust_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"isf_rslt_cd" },
						 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bkg_no" } ];
			InitColumns(cols);
			SetSheetHeight(280);
            SetSheetHeight($(window).height() - AnchorPosition_getPageOffsetTop(sheetObjects[0]) - 70);
//			ComResizeSheet(sheetObj);

			SetEditable(0);
            }
	    break;
	    
	    
		case 4: // sheet4 baplie
			with (sheetObj) {
			var HeadTitle = "|Seq.|Container No.|Container\nOperator|L.POL|POL|POD|TP/SZ|Full/Empty|Cargo Type|Stow\nPosition|IMO Class"
							+ "|UN No.|Original\nPOD|Customs Result|Customs Response|Description|Sent Time|Receiving Date|vsl_eng_nm|vsl_voy|crr_cd|tmp1|tmp2|search_vvd_cd|excludeca";
			var headCount = ComCountHeadTitle(HeadTitle);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq",			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
			             
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"opr_cd",		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"l_pol",			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol",			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod",			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"sztp",			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"fmInd",			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"fe",			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"sti_pos",		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"imdg",			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"unno",			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"o_pod",			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cust_result",	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cust_rspn",		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"description",	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"sent_time",		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"receive_date",	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 
						 {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vsl_eng_nm",	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vsl_voy",		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"crr_cd",		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"tmp1",			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"tmp2",			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"search_vvd_cd",	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"excludeca",		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			
			InitColumns(cols);
			SetSheetHeight(300);
//			ComResizeSheet(sheetObj);

			SetEditable(0);
			}
		break;
	}
}
//handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
	sheetObj.ShowDebugMsg(false);
	var targetSheet=null;
	switch (sAction) {
	case IBCLEAR: // 화면 로딩시 코드 조회
		formObj.f_cmd.value=COMMAND01;
        var sXml=sheetObj.GetSearchData("ESM_BKG_1120GS.do", FormQueryString(formObj));
        var arrXml=sXml.split("|$$|");
        
        if (arrXml.length > 0) 
            ComXml2ComboItem(arrXml[0], rhq, "val", "desc");
        rhq.index=-1;
		break;
	case IBSEARCH: // retrieve
		var selTab=tabObjects[0].GetSelectedIndex();
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		ComOpenWait(true);		
		formObj.f_cmd.value=SEARCH;
		var para="&general_or_rail=";
		if (selTab == 0) {
			para += "GENERAL";
			resultXmlFor1=null;
		} else if (selTab == 1) {
			para += "RAILAMS";
			resultXmlFor2=null;
		} else if (selTab == 2) {
			para += "ISF5";
		} else if (selTab == 3) {
			para += "BAPLIE";
		}
		targetSheet=sheetObjects[selTab];
		var sXml=targetSheet.GetSearchData("ESM_BKG_0041GS.do", FormQueryString(formObj) + "&tmp3=" + para);
		targetSheet.LoadSearchData(sXml,{Sync:0} );
		if (selTab == 2) {
			formObj.manifest.value=ComGetEtcData(sXml, "manifest");
			formObj.accepted.value=ComGetEtcData(sXml, "accepted");
			formObj.rejected.value=ComGetEtcData(sXml, "rejected");
			formObj.none.value=ComGetEtcData(sXml, "none");
			formObj.target.value=ComGetEtcData(sXml, "target");
			formObj.unmanifest.value=ComGetEtcData(sXml, "unmanifest");
		}
		ComOpenWait(false);
		break;
	case IBSEARCHAPPEND: // retrieve page
        var selTab=tabObjects[0].GetSelectedIndex();
		if (!validateForm(sheetObj, formObj, IBSEARCH))
			return false;
		formObj.f_cmd.value=SEARCH;
        var para="&general_or_rail=";
        if (selTab == 0) {
            para += "GENERAL";
            resultXmlFor1=null;
        } else if (selTab == 1) {
            para += "RAILAMS";
            resultXmlFor2=null;
        } else if (selTab == 2) {
            para += "ISF5";
        } else if (selTab == 3) {
            para += "BAPLIE";
        }
		if (formObj.retrieve_remains.value != "") {
			CondParam=CondParam + "&tmp4=" + formObj.retrieve_remains.value
		}
		if (formObj.retrieve_remains_for_report.value != "") {
			CondParam=CondParam + "&tmp4=" + formObj.retrieve_remains_for_report.value
		}
	
		sheetObj.DoSearch("ESM_BKG_0041GS.do", FormQueryString(formObj) + "&tmp3=" + para + "&" + CondParam+"&"+ "page_no=" + PageNo +
		"&last_rnum=" + sheetObj.GetCellValue(sheetObj.LastRow(), "seq") +
		"&last_bl=" + sheetObj.GetCellValue(sheetObj.LastRow(), "ams_file_no"), {Append:true});

		break;
	case SEARCH03: //open
		formObj.f_cmd.value=SEARCH03;
		var sXml=sheetObj.GetSearchData("ESM_BKG_0041GS.do", FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		/* R/D R- OUTBOUND RECEIVED */
		/* R/D D- INBOUND DELIVERY */
		/* CUSTOMS RESULT CODE */
		customs_result_codeXml=arrXml[0];
		ComXml2ComboItem(arrXml[1], rcv_term_cd, "val", "val|desc");
		ComXml2ComboItem(arrXml[2], de_term_cd, "val", "val|desc");
		ComXml2ComboItem(arrXml[3], filer, "val", "val|desc");
		ComXml2ComboItem(arrXml[4], customs_result_code_grp, "val", "val|desc");
		ComXml2ComboItem(arrXml[5], eq_ofc, "eq_ctrl_ofc_cd", "eq_ctrl_ofc_cd");
		
		filer.InsertItem(0, "ALL|ALL", "ALL");
		filer.DeleteItem(1);
		filer.DeleteItem(1);
		
		formObj.vvd.focus();
		break;
	case IBDOWNEXCEL: // excel
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		var selTab=tabObjects[0].GetSelectedIndex();
		ComOpenWait(true, true);
		var totalRowBigger="";
		if (sheetObjects[selTab].RowCount()> 0) {
			if (sheetObjects[selTab].RowCount()< sheetObjects[selTab].GetTotalRows()) {
				formObj.retrieve_remains.value=sheetObjects[selTab].GetTotalRows();
				totalRowBigger=sheetObjects[selTab].GetTotalRows();
				sheetObjects[selTab].SetTopRow(sheetObjects[selTab].RowCount());
			}
			sheetObjects[selTab].Down2Excel( {DownCols: makeHiddenSkipCol(			sheetObjects[selTab]), SheetDesign:1,Merge:1 });
		}
		ComOpenWait(false);
		break;
	case SEARCH04: // 2Z
		var selTab=tabObjects[0].GetSelectedIndex();
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		ComOpenWait(true);
		formObj.f_cmd.value=SEARCH;
		var para="&general_or_rail=";
		if (selTab == 0) {
			para += "GENERAL";
		} else if (selTab == 1) {
			para += "RAILAMS";
		}
		targetSheet=sheetObjects[selTab];
		targetSheet.DoSearch("ESM_BKG_0041GS.do", FormQueryString(formObj) + "&tmp3=2Z" + para );
		ComOpenWait(false);
		break;
	case SEARCH05: // 6H6I
		var selTab=tabObjects[0].GetSelectedIndex();
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		ComOpenWait(true);
		formObj.f_cmd.value=SEARCH;
		var para="&general_or_rail=";
		if (selTab == 0) {
			para += "GENERAL";
		} else if (selTab == 1) {
			para += "RAILAMS";
		}
		targetSheet=sheetObjects[selTab];
		targetSheet.DoSearch("ESM_BKG_0041GS.do", FormQueryString(formObj) + "&tmp3=6H6I" + para );
		ComOpenWait(false);
		break;
	case SEARCH06: // Non-3Z
		var selTab=tabObjects[0].GetSelectedIndex();
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		ComOpenWait(true);
		formObj.f_cmd.value=SEARCH;
		var para="&general_or_rail=";
		if (selTab == 0) {
			para += "GENERAL";
		} else if (selTab == 1) {
			para += "RAILAMS";
		}
		targetSheet=sheetObjects[selTab];
		targetSheet.DoSearch("ESM_BKG_0041GS.do", FormQueryString(formObj) + "&tmp3=3Z" + para );
		ComOpenWait(false);
		break;
	
	case SEARCH07: // 2Q4Q
		var selTab = tabObjects[0].GetSelectedIndex();
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		var para = "&general_or_rail=";
		if (selTab == 0) {
			para += "GENERAL";
		} else if (selTab == 1) {
			para += "RAILAMS";
		}
		targetSheet = sheetObjects[selTab];
		targetSheet.DoSearch("ESM_BKG_0041GS.do", FormQueryString(formObj) + "&tmp3=2Q4Q" + para);
		ComOpenWait(false);
		break;
		
	case SEARCH08: // 2R4R
		var selTab = tabObjects[0].GetSelectedIndex();
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		var para = "&general_or_rail=";
		if (selTab == 0) {
			para += "GENERAL";
		} else if (selTab == 1) {
			para += "RAILAMS";
		}
		targetSheet = sheetObjects[selTab];
		targetSheet.DoSearch("ESM_BKG_0041GS.do", FormQueryString(formObj) + "&tmp3=2R4R" + para);
		ComOpenWait(false);
		break;
	
	case SEARCH11: //B/L Inquiry
		if (validateForm(sheetObj, formObj, sAction)) {
			var selTab=tabObjects[0].GetSelectedIndex();
			var selRow=sheetObjects[selTab].GetSelectRow();
			var bl_no=sheetObjects[selTab].GetCellValue(selRow, "ams_file_no");
			var param="bl_no=" + bl_no;
			if (formObj.office.value == "Origin") {
				param=param + "&pgmNo=ESM_BKG_0034-01"
			} else {
				param=param + "&pgmNo=ESM_BKG_0034-03"
			}
			ComOpenWindowCenter("/opuscntr/ESM_BKG_0034_POP.do?" + param, "ESM_BKG_0034", 1250, 700, false);
		}
		break;
	case SEARCH12: //btn_InquiryByCntr
		if (validateForm(sheetObj, formObj, sAction)) {
			var selTab=tabObjects[0].GetSelectedIndex();
			var selRow=sheetObjects[selTab].GetSelectRow();
			var cntr_no=sheetObjects[selTab].GetCellValue(selRow, "cntr_no");
			var param="cntr_no=" + cntr_no;
			ComOpenWindowCenter("/opuscntr/ESM_BKG_0518_POP.do?pgmNo=ESM_BKG_0518&" + param, "ESM_BKG_0518", 1024, 560);
		}
		break;
	case SEARCH13: //btn_BlCharge
		if (validateForm(sheetObj, formObj, sAction)) {
			var selTab=tabObjects[0].GetSelectedIndex();
			var selRow=sheetObjects[selTab].GetSelectRow();
			var bl_no=sheetObjects[selTab].GetCellValue(selRow, "ams_file_no");
			var bkg_no=sheetObjects[selTab].GetCellValue(selRow, "bkg_no");
			var param="pgmNo=ESM_BKG_0079&openTab=B9&bkg_no=" + bkg_no;
			ComOpenWindowCenter("ESM_BKG_0079_Q_POP.do?" + param, "ESM_BKG_0079", 1280, 800,false);
//			comBkgCallPopBkgCharge(sheetObj.CellValue(selRow, prefix+"bkg_no"));
//			comBkgCallPopBkgDetail(sheetObj.CellValue(rowIdx, prefix+"bkg_no"));
//			var param = "pgmNo=ESM_BKG_0079&openTab=B9&isPop=Y&bkg_no=" + bkg_no;
//			ComOpenWindowCenter("/opuscntr/ESM_BKG_0079.do?" + param, "ESM_BKG_0079", 1024, 650, true);
		}
		break;
	case SEARCH14: //btn_RailAmsHistory
		if (validateForm(sheetObj, formObj, sAction)) {
			var selTab=tabObjects[0].GetSelectedIndex();
			var selRow=sheetObjects[selTab].GetSelectRow();
			var cntr_no=sheetObjects[selTab].GetCellValue(selRow, "cntr_no");
			var bl_no=sheetObjects[selTab].GetCellValue(selRow, "ams_file_no");
			var vvd=sheetObjects[selTab].GetCellValue(selRow, "vvd");
			var param="cntr_no=" + cntr_no + "&vvd=" + vvd + "&bl_no=" + bl_no;
			ComOpenWindowCenter("ESM_BKG_1037.do?pgmNo=ESM_BKG_1037&" + param, "ESM_BKG_1037", 1024, 610, true);
		}
		break;
	case SEARCH15: //Print
		if (validateForm(sheetObj, formObj, sAction)) {
			var selTab=tabObjects[0].GetSelectedIndex();
			if (sheetObjects[selTab].RowCount()< sheetObjects[selTab].GetTotalRows()) {
				formObj.retrieve_remains_for_report.value=sheetObjects[selTab].GetTotalRows();
				sheetObjects[selTab].SetTopRow(sheetObjects[selTab].RowCount());
			} else {
				var targetDo="ESM_BKG_0867.do";
				if (selTab == 1) {
					targetDo="ESM_BKG_5027.do";
				}
				ComOpenWindowCenter("/opuscntr/" + targetDo, "0867" + tabObjects[0].GetSelectedIndex(), 1024, 690, false);
				break;
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
	case IBSEARCH:
	case SEARCH04:
	case SEARCH05:
	case SEARCH06:
	case SEARCH07:
	case SEARCH08:
		if (!ComChkObjValid(formObj.mbl_no))
			return false;
		if(tabObjects[0].GetSelectedIndex() == 0 || tabObjects[0].GetSelectedIndex() == 1 || tabObjects[0].GetSelectedIndex() == 2) {
			if (formObj.mbl_no.value == "" && formObj.ams_file_no.value == "") {
				if (formObj.date_search.checked) {
					if (formObj.fromd.value == "" || formObj.fromt.value == "" || formObj.tod.value == "" || formObj.tot.value == "") {
						ComShowCodeMessage("BKG00626", "Date & Time Fields");
						return false;
					}
					if (ComGetDaysBetween(formObj.fromd.value, formObj.tod.value) > 30) {
						ComShowCodeMessage("BKG00462", "30 days");
						return false;
					}
				} else {
					if (formObj.vvd.value == "" || formObj.vvd.value.length != 9) {
						ComShowCodeMessage("BKG00626", "VVD");
						return false;
					}
					if (formObj.pod.value == "" && formObj.pol.value == "") {
						ComShowCodeMessage("BKG00626", "POL OR POD");
						return false;
					}
				}
			}
		}
		else if(tabObjects[0].GetSelectedIndex() == 3) {
			if (formObj.vvd.value == "" || formObj.vvd.value.length != 9) {
				ComShowCodeMessage("BKG00626", "VVD");
				return false;
			}
			if (formObj.last_pol.value == "" && formObj.last_pol.value == "") {
				ComShowCodeMessage("BKG00626", "Last Foreign POL");
				return false;
			}
		}
		
		break;
	case IBDOWNEXCEL:
		var selTab=tabObjects[0].GetSelectedIndex();
		if (sheetObjects[selTab].RowCount()== 0) {
			ComShowCodeMessage("BKG00889"); // No data found
			return false;
		}
		break;
	case SEARCH11:
	case SEARCH12:
	case SEARCH13:
	case SEARCH14:
	case SEARCH15:
		var selTab=tabObjects[0].GetSelectedIndex();
		if (sheetObjects[selTab].RowCount()== 0) {
			ComShowCodeMessage("BKG00889");
			return false;
		}
		break;
	}
	return true;
}
/**
 * register Tab Object to tabObjects array
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++]=tab_obj;
}
// initializing tab
function initTab(tabObj, tabNo) {
	with (tabObj) {
		var cnt=0;
		InsertItem( "General", "");
		InsertItem( "CN Rail AMS", "");
		InsertItem( "ISF-5", "");
//		InsertItem( "BAPLIE", "");
	}
}
/**
 * handling Tab event
 */
function tab1_OnChange(tabObj, nItem) {
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	
	for(var i = 0; i<objs.length; i++){
		if(i != nItem){
			objs[i].style.display="none";
			objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		}
	}
	beforetab=nItem;
	
	document.getElementById("pol1").required = false;
	document.getElementById("pod1").required = false;
	document.getElementById("del1").required = false;
	document.getElementById("hub1").required = false;
	
	document.getElementById("pol2").required = false;
	document.getElementById("pod2").required = false;
	document.getElementById("del2").required = false;
	document.getElementById("hub2").required = false;
	
	document.getElementById("last_pol").required = false;
	
	if (tabObjects[0].GetSelectedIndex()< 2) {
		document.getElementById("pol1").required = true;
		document.getElementById("pod1").required = true;
		document.getElementById("del1").required = true;
		
		// General/Rail AMS Tab
		// Delete condition : last foreign pol
//		document.getElementById("lastPol").style.display = "none";
		document.getElementById("lastPolTd1").style.display = "none";
		document.getElementById("lastPolTd2").style.display = "none";
		
		if(tabObjects[0].GetSelectedIndex() == 0){
			document.getElementById("general").style.display = "none";			
			document.getElementById("general_1").style.display = "inline";
			doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
		}else{
			document.getElementById("general").style.display = "inline";			
			document.getElementById("general_1").style.display = "none";			
		}
		document.getElementById("general").style.left = "190";
		document.getElementById("general").style.top = "38";
		
		formObj=document.form;
		var rtn_type;
		if (formObj.mbl_no.value == "" && formObj.ams_file_no.value == "") {
			if (formObj.date_search.checked) {
				if (formObj.fromd.value == "" || formObj.fromt.value == "" || formObj.tod.value == "" || formObj.tot.value == "") {
					rtn_type=false;
				}
				if (ComGetDaysBetween(formObj.fromd.value, formObj.tod.value) > 30) {
					rtn_type=false;
				}
			} else {
				if (formObj.vvd.value == "" || formObj.vvd.value.length != 9) {
					rtn_type=false;
				}
				if (formObj.pod.value == "" && formObj.pol.value == "") {
					rtn_type=false;
				}
			}
		}
		if(rtn_type != false){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);			
		}
		
		for(var i=0; i<document.form.elements.length; i++)
		{
			if (document.form.elements[i].name == "excl_rls" ||
					document.form.elements[i].name == "cntr_prt_flg" ||
					document.form.elements[i].name == "final_flg")
			{
				document.form.elements[i].disabled=false;
				document.form.elements[i].className="input";
			}
		}
		
		for(var i=0; i<document.form.elements.length; i++)
		{
			if (document.form.elements[i].name == "hub1" || 
					document.form.elements[i].name == "b_stf" || 
					document.form.elements[i].name == "l_rep" || 
					document.form.elements[i].name == "pmib_tp" || 
					document.form.elements[i].name == "mbl_no" || 
					document.form.elements[i].name == "ams_file_no")
			{
				document.form.elements[i].disabled=false;
				document.form.elements[i].className="input";
			}
		}
		eq_ofc.SetEnable(1);
		rcv_term_cd.SetEnable(1);
		de_term_cd.SetEnable(1);
		filer.SetEnable(1);
		customs_result_code_grp.SetEnable(1);
		customs_result_code.SetEnable(1);
		
		
		document.form.cntr_prt_flg.checked = false;
		document.form.final_flg.checked = false;
		
		document.form.cust_arr_exp[1].checked=true;
		document.form.cust_arr_exp[0].disabled=true;
		document.form.cust_arr_exp[2].disabled=false;
		
		ComBtnEnable('btn_Print');
		ComBtnEnable('btn_InquiryByCntr');
		ComBtnEnable('btn_2q4q');
		ComBtnEnable('btn_2r4r');
		ComBtnEnable('btn_2z');
		ComBtnEnable('btn_6h6i');
		ComBtnEnable('btn_non3Z');
		ComBtnEnable('btn_RailAmsHistory');
		ComBtnEnable('btn_BLInquiry');
		ComBtnEnable('btn_BlCharge');
		
		if (tabObjects[0].GetSelectedIndex()== 0) {
			document.form.cust_arr_exp[3].disabled=false;
		} else {
			document.form.cust_arr_exp[3].disabled=true;
		}
	} else if (tabObjects[0].GetSelectedIndex() == 2) {
		document.getElementById("pol1").required = true;
		document.getElementById("pod1").required = true;
		document.getElementById("del1").required = true;
		
		// ISF-5 Tab
		// Delete condition : last foreign pol
//		document.getElementById("lastPol").style.display = "none";
		document.getElementById("lastPolTd1").style.display = "none";
		document.getElementById("lastPolTd2").style.display = "none";
		document.getElementById("general").style.display = "inline";		
		document.getElementById("general_1").style.display = "none";
		document.getElementById("general").style.left = "190";
		document.getElementById("general").style.top = "38";
		
		formObj=document.form;
		var rtn_type;
		if (formObj.mbl_no.value == "" && formObj.ams_file_no.value == "") {
			if (formObj.date_search.checked) {
				if (formObj.fromd.value == "" || formObj.fromt.value == "" || formObj.tod.value == "" || formObj.tot.value == "") {
					rtn_type=false;
				}
				if (ComGetDaysBetween(formObj.fromd.value, formObj.tod.value) > 30) {
					rtn_type=false;
				}
			} else {
				if (formObj.vvd.value == "" || formObj.vvd.value.length != 9) {
					rtn_type=false;
				}
				if (formObj.pod.value == "" && formObj.pol.value == "") {
					rtn_type=false;
				}
			}
		}
		if(rtn_type != false){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);			
		}
		
		for(var i=0; i<document.form.elements.length; i++)
		{
			if (document.form.elements[i].name == "mbl_no" ||
					document.form.elements[i].name == "ams_file_no" ||
					document.form.elements[i].name == "cntr_prt_flg")
			{
				document.form.elements[i].disabled=false;
				document.form.elements[i].className="input";
			}
		}
		
		for(var i=0; i<document.form.elements.length; i++)
		{
			if (document.form.elements[i].name == "hub1" || 
					document.form.elements[i].name == "b_stf" || 
					document.form.elements[i].name == "l_rep" || 
					document.form.elements[i].name == "pmib_tp" ||
                    document.form.elements[i].name == "excl_rls" ||
					document.form.elements[i].name == "final_flg")
			{
				document.form.elements[i].disabled=true;
				document.form.elements[i].className="input2";
			}
		}
		
		eq_ofc.SetEnable(0);
		rcv_term_cd.SetEnable(0);
		de_term_cd.SetEnable(0);
		filer.SetEnable(0);
		customs_result_code_grp.SetEnable(0);
		customs_result_code.SetEnable(0);
		
		document.form.final_flg.checked = false;
		
		document.form.cust_arr_exp[0].checked=true;
		document.form.cust_arr_exp[0].disabled=false;
//		document.form.cust_arr_exp[1].disabled = false;
		document.form.cust_arr_exp[2].disabled=true;
		document.form.cust_arr_exp[3].disabled=true;
		
		ComBtnDisable('btn_Print');
		ComBtnDisable('btn_InquiryByCntr');
		ComBtnDisable('btn_2q4q');
		ComBtnDisable('btn_2r4r');
		ComBtnDisable('btn_2z');
		ComBtnDisable('btn_6h6i');
		ComBtnDisable('btn_non3Z');
		ComBtnDisable('btn_RailAmsHistory');
		
		ComBtnEnable('btn_BLInquiry');
		ComBtnEnable('btn_BlCharge');

	}
	else if (tabObjects[0].GetSelectedIndex() == 3) {
		document.getElementById("last_pol").required = true;
		
		// BAPLIE
		// Add condition : last foreign pol
//		document.getElementById("lastPol").style.display = "inline";
		document.getElementById("lastPolTd1").style.display = "inline";
		document.getElementById("lastPolTd2").style.display = "inline";
		document.getElementById("general").style.display = "inline";		
		document.getElementById("general_1").style.display = "none";		
		document.getElementById("general").style.left = "300";
		document.getElementById("general").style.top = "41";
		
		formObj = document.form;
		var rtn_type;
		if (formObj.mbl_no.value == "" && formObj.ams_file_no.value == "") {
			if (formObj.date_search.checked) {
				if (formObj.fromd.value == "" || formObj.fromt.value == "" || formObj.tod.value == "" || formObj.tot.value == "") {
					rtn_type = false;
				}
				if (ComGetDaysBetween(formObj.fromd.value, formObj.tod.value) > 30) {
					rtn_type = false;
				}
			} else {
				if (formObj.vvd.value == "" || formObj.vvd.value.length != 9) {
					rtn_type = false;
				}
				if (formObj.last_pol.value == "") {
					rtn_type = false;
				}
			}
		}
		
		// BAPLIE Tab으로 이동될때는 자동 조회되지 않도록 한다.
		//if(rtn_type != false){
		//	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);			
		//}

		// attribute : enabled -> disabled
		for(var i=0; i<document.form.elements.length; i++)
		{
			if (document.form.elements[i].name == "hub1" || 
					document.form.elements[i].name == "del1" || 
					document.form.elements[i].name == "b_stf" ||
					document.form.elements[i].name == "l_rep" ||
					document.form.elements[i].name == "pmib_tp" ||
					document.form.elements[i].name == "mbl_no" ||
					document.form.elements[i].name == "ams_file_no" ||
					document.form.elements[i].name == "excl_rls" ||
					document.form.elements[i].name == "cntr_prt_flg" ||
					document.form.elements[i].name == "final_flg")
			{
				document.form.elements[i].disabled=true;
				document.form.elements[i].className="input2";
			}
		}
		
		eq_ofc.SetEnable(0);
		rcv_term_cd.SetEnable(0);
		de_term_cd.SetEnable(0);
		filer.SetEnable(0);
		customs_result_code_grp.SetEnable(0);
		customs_result_code.SetEnable(0);
		
		document.form.cust_arr_exp[0].checked = true;
		document.form.cust_arr_exp[0].disabled = false;
		document.form.cust_arr_exp[2].disabled = true;
		document.form.cust_arr_exp[3].disabled = true;
		
		// attribute style : enbaled -> disabled
		document.form.pol1.className = "input";
		document.form.pod1.className = "input";
		document.form.del1.className = "input2";
		document.form.hub1.className = "input2";
		
//		document.form.eq_ofc.className = "input2";
		document.form.b_stf.className = "input2";
		document.form.l_rep.className = "input2";
		document.form.pmib_tp.className = "input2";
		document.form.mbl_no.className = "input2";
		document.form.ams_file_no.className = "input2";

		ComBtnDisable('btn_BLInquiry');
		ComBtnDisable('btn_InquiryByCntr');
		ComBtnDisable('btn_BlCharge');
		ComBtnDisable('btn_Print');
		ComBtnDisable('btn_2q4q');
		ComBtnDisable('btn_2r4r');
		ComBtnDisable('btn_2z');
		ComBtnDisable('btn_6h6i');
		ComBtnDisable('btn_non3Z');
		ComBtnDisable('btn_RailAmsHistory');
	}
	
	if (tabObjects[0].GetSelectedIndex() == 1) {
		document.getElementById("railAms").style.display = "inline";
		document.getElementById("useDateCond").rowSpan = 3;
		
		var tbl=document.getElementById("changeTbl"); 
		var oRow = tbl.insertRow(2);
		oRow.className = "tr2_head";
		var oCell = oRow.insertCell(-1);
		oCell.colSpan = 2;
		oCell.align = "left";
		oCell.innerHTML = "<input type='radio' name='cust_arr_exp' value='ETA' class='trans'>&nbsp;<strong>POD ETA</strong>";
	} else {
		document.getElementById("railAms").style.display = "none";
		if(changetab == 1) {
			document.getElementById("useDateCond").rowSpan = 2;
			var tbl=document.getElementById("changeTbl"); 
			var oRow = tbl.deleteRow(2);
		}
	}
	changetab = nItem;
}
/**
 * change event
 */
function chkChange2() {
	var srcName=ComGetEvent("name");
	var srcObj=event.srcElement;
//	if (srcName == "mbl_no") {
//		if (srcObj.value != "" && srcObj.value.length != 12) { // Toyota B/L
//			ComShowCodeMessage('BKG00241'); // "B/L No. is Invalid."
//		}
//	} else if (srcName == "ams_file_no") {
//		if (srcObj.value != "" && srcObj.value.length != 12) {
//			ComShowCodeMessage('BKG00388', "AMS FILE NO"); // "Data is invalid. ({?msg1} )"
//		}
//	}
	
	if(srcName == "pol1"){		
		document.form.pol.value = document.form.pol1.value;
		document.form.pol2.value = document.form.pol1.value;		
	}else if(srcName == "pod1"){
		document.form.pod.value = document.form.pod1.value;
		document.form.pod2.value = document.form.pod1.value;				
	}else if(srcName == "del1"){
		document.form.del.value = document.form.del1.value;
		document.form.del2.value = document.form.del1.value;				
	}else if(srcName == "hub1"){
		document.form.hub.value = document.form.hub1.value;
		document.form.hub2.value = document.form.hub1.value;						
	}else if(srcName == "pol2"){
		document.form.pol.value = document.form.pol2.value;
		document.form.pol1.value = document.form.pol2.value;				
	}else if(srcName == "pod2"){
		document.form.pod.value = document.form.pod2.value;
		document.form.pod1.value = document.form.pod2.value;						
	}else if(srcName == "del2"){
		document.form.del.value = document.form.del2.value;
		document.form.del1.value = document.form.del2.value;						
	}else if(srcName == "hub2"){
		document.form.hub.value = document.form.hub2.value;
		document.form.hub1.value = document.form.hub2.value;								
	}
}
/**
 * click event
 */
function chkClick2() {
	var srcName=ComGetEvent("name");
	var srcObj=event.srcElement;
	var form=document.form;
	if (srcName == "date_search") {
		if (srcObj.checked) {
			form.fromd.className="input1";
			form.fromt.className="input1";
			form.tod.className="input1";
			form.tot.className="input1";
			form.vvd.className="input";
			form.pol.className="input";
			form.pod.className="input";
			form.fromd.focus();
		} else {
			form.fromd.className="input2";
			form.fromt.className="input2";
			form.tod.className="input2";
			form.tot.className="input2";
			form.vvd.className="input1";
			form.pol.className="input1";
			form.pod.className="input1";
		}
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		for ( var i=1; i <= LastRow(); i++) {
			SetToolTipText(i, "dspo_cd",GetCellValue(i, "cstms_dspo_nm"));
			if (GetCellValue(i, "mbl_no") != GetCellValue(i, "ams_file_no")) {
				//AMS FILE MBL number or blue.
				SetCellFontColor(i, "ams_file_no","#0000FF");
			}
			if (GetCellValue(i, "free_trd_zn_flg") == "Y") {
				//free_trd_zn_flg 'Y' is red.
				SetCellFontColor(i, "free_trd_zn_flg","#FF0000");
			}
			if (GetCellValue(i, "dspo_cd") == "6H") {
				SetRowFontColor(i,"#FF0000");
			} else if (GetCellValue(i, "dspo_cd") == "6I") {
				SetRowFontColor(i,"#0000FF");
			}
		}
		if(sheetObj.RowCount() > 0){
			document.getElementById("bl_cnt").innerHTML=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "total");
		}
	}
}
/**
 * sheet2 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		for ( var i=1; i <= LastRow(); i++) {
			SetToolTipText(i, "dspo_cd",GetCellValue(i, "cstms_dspo_nm"));
			if (GetCellValue(i, "free_trd_zn_flg") == "Y") {
				//free_trd_zn_flg 'Y' is red.
				SetCellFontColor(i, "free_trd_zn_flg","#FF0000");
			}
		}
	}
}
/**
 * sheet3
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		for ( var i=1; i <= LastRow(); i++) {
			if (GetCellValue(i, "mh") == "H") {
				//House BL blue
				SetCellFontColor(i, "ams_file_no","#0000FF");
			}
			if (GetCellValue(i, "isf_rslt_cd") == "01") {
				SetCellFontColor(i, "isf_rslt_desc","#FF0000");
				SetCellFontColor(i, "isf_rmk","#FF0000");
			}
		}
	}
}
/**
 * IBSheet GetSearchXml function of the XML data obtained through IBMultiCombo item allows to insert.
 */
function ComXml2Combo2(xmlStr, cmbObj, codeCol, textCol, condCol, condVal) {
	if (xmlStr == null || xmlStr == "" || cmbObj == null || cmbObj == "") {
		return;
	}
	if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
		return;
	}
	if (condCol == null || condCol == "" || condVal == null || condVal == "") {
		return;
	}
	try {
		cmbObj.RemoveAll();
		
		var xmlDoc = ComGetXmlDoc(xmlStr);
		if (xmlDoc == null) return;
		var xmlRoot = xmlDoc.documentElement;
		
		
		if (xmlRoot == null) {
			return;
		}
		
		var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}
		var col=dataNode.getAttribute("COLORDER");
		var colArr=col.split("|");
		var sep=dataNode.getAttribute("COLSEPARATOR");
		var total=dataNode.getAttribute("TOTAL");
		var dataChildNodes=dataNode.childNodes;
		if (dataChildNodes == null) {
			return;
		}
		var colListIdx=Array();
		var arrText=textCol.split("|");
		for ( var i=0; i < colArr.length; i++) {
			if (colArr[i] == codeCol) {
				colListIdx[0]=i;
			}
			for ( var j=0; j < arrText.length; j++) {
				if (colArr[i] == arrText[j]) {
					colListIdx[j + 1]=i;
				}
			}
		}
		var condListIdx=0;
		for ( var i=0; i < colArr.length; i++) {
			if (colArr[i] == condCol) {
				condListIdx=i;
			}
		}
		var k=0;
		for ( var i=0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
			var item="";
			for ( var j=1; j < colListIdx.length; j++) {
				item += arrData[colListIdx[j]];
				if (j < colListIdx.length - 1) {
					item += "|";
				}
			}
			if (arrData[condListIdx] == condVal || condVal == "ALL" || condVal == "All") {
				cmbObj.InsertItem(k, item, arrData[colListIdx[0]]);
				k++;
			}
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}
/**
 * Check if the value entered in MultiCombo added to the treatment.
 */
function customs_result_code_grp_OnChange(comboObj, OlIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {

	if (comboObj.GetSelectCode()== "") customs_result_code.RemoveAll();
	ComXml2Combo2(customs_result_codeXml, customs_result_code, "cstms_dspo_cd", "cstms_dspo_cd|cstms_dspo_nm", "dspo_tp_cd", comboObj.GetSelectCode());
	
}
 /**
  * control double click event
  */
function sheet1_OnDblClick(SheetObj, Row, Col) {
	doActionIBSheet(SheetObj, document.form, SEARCH11);
}
/**
 * control double click event
 */
function sheet2_OnDblClick(SheetObj, Row, Col) {
	doActionIBSheet(SheetObj, document.form, SEARCH11);
}
/**
 * control result code on change event
 */
function customs_result_code_OnChange(comboObj, OlIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
	if (comboObj.GetSelectCode()== "" && comboObj.GetSelectText()!= "") {
		comboObj.InsertItem(-1, comboObj.GetSelectText().toUpperCase(), comboObj.GetSelectText().toUpperCase());
		comboObj.SetSelectIndex(comboObj.GetItemCount() - 1,false);
	}else if (comboObj.GetSelectCode() == "" && comboObj.GetSelectText() == "") {
		customs_result_code.RemoveAll();
	}
}
/**
* control combo check
*/
//var eqOfcAllEvt = true;
function eq_ofc_OnCheckClick(comboObj, s_index, s_code) {
//	if(s_index == 0 && s_code == "ALL" && eqOfcAllEvt) {
//		eqOfcAllEvt = true;
//		for(var i = 1; i < comboObj.GetItemCount(); i++) {
//			comboObj.SetItemCheck(i, false);
//		}
//		eqOfcAllEvt = false;
//	}
//	else if(!eqOfcAllEvt){
//		comboObj.SetItemCheck(0, false);
//		eqOfcAllEvt = true;
//	}
	
	
	if(s_index == 0 && s_code == "ALL") {
		combo_All_control(comboObj, s_index, s_code);
	}
	
}

function filer_OnCheckClick(comboObj, s_index, s_code) {
	if(s_index == 0 && s_code == "ALL") {
		combo_All_control(comboObj, s_index, s_code);
	}
}

function combo_All_control(comboObj, s_index, s_code) {
	var bChk = comboObj.GetItemCheck(s_index);
	for(var i = 1; i < comboObj.GetItemCount(); i++) {
		comboObj.SetItemCheck(i, bChk)
	}
}

/**
* control scroll event
*/
var iPageNo = 1;
function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
    doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
}

function sheet2_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
    doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
}
/**
* control click header event
*/
function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
	var form=document.form;
	var col=sheetObj.MouseCol()
	if (sheetObj.MouseRow()== 0 || sheetObj.MouseRow()== 1) {
		if (sheetObj.RowCount()< sheetObj.GetTotalRows()) {
			ComOpenWait(true);
			form.retrieve_remains.value=sheetObj.GetTotalRows();
			sheetObj.SetTopRow(sheetObj.RowCount());
			sheetObj.SetTopRow(0);
			sheetObj.ColumnSort(col);
			ComOpenWait(false);
		}
	}	
}
/**
* control click header event
*/
function sheet2_OnMouseDown(sheetObj, Button, Shift, X, Y) {
	var form=document.form;
	var col=sheetObj.MouseCol()
	if (sheetObj.MouseRow()== 0 || sheetObj.MouseRow()== 1) {
		if (sheetObj.RowCount()< sheetObj.GetTotalRows()) {
			ComOpenWait(true);
			form.retrieve_remains.value=sheetObj.GetTotalRows();
			sheetObj.SetTopRow(sheetObj.RowCount());
			sheetObj.SetTopRow(0);
			sheetObj.ColumnSort(col);
			ComOpenWait(false);
		}
	}
}