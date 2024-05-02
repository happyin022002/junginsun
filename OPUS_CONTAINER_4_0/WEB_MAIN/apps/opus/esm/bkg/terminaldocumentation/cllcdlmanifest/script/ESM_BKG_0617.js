/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0617.js
 *@FileTitle : ESM_BKG_0617
 *Open Issues :
 *Change history :
 *@LastModifyDate : 28/04/2014
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_BKG_0617 : business script for ESM_BKG_0617 
 */

// Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var state="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	var obj = event.target || event.srcElement;
	if ($(obj).prop('disabled')) {	
	 return;
	}
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_downExcel":
			doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
			break;
		case "btn_printfor":
			doActionIBSheet(sheetObjects[1], document.form, COMMAND02);
			break;
		case "btn_retrieve":
			doActionIBSheet(sheetObject, document.form, IBSEARCH);
			break;
		case "btn_new":
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			formObject.reset();
			break;
		case "btn_cllForEDI":
		    doActionIBSheet(sheetObject, formObject, COMMAND01);
			break;
		case "btns_calendar": // 
			var cal=new ComCalendarFromTo();
			cal.select(formObject.in_cr_indate_start,
					formObject.in_cr_indate_end, 'yyyy-MM-dd');
			break;
		case "btns_calendar2": // 
			var cal=new ComCalendarFromTo();
			cal.select(formObject.in_cr_edate_start,
					formObject.in_cr_edate_end, 'yyyy-MM-dd');
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
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
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage()
{
	for (i=0; i < sheetObjects.length; i++) 
	{
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
}
/**
 * setting event
 */
function initControl() {
	DATE_SEPARATOR="-";
	var formObject=document.form;
	axon_event.addListenerForm  ('blur', 'obj_deactivate', formObject); //- focus in
	axon_event.addListenerFormat('focus', 'obj_activate', formObject); //- focus out	
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
//	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	ComBtnDisable("btn_downExcel");
	ComBtnDisable("btn_printfor");
	ComBtnDisable("btn_cllForEDI");
	document.form.in_cr_indate_start.focus();
	// alert(document.form.in_vvd_cd.value);
	// alert(document.form.in_pol_cd.value);
	if (document.form.in_vvd_cd.value != ""
			&& document.form.in_pol_cd.value != "") {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}
/**
 * when inputting search condition
 */
//function obj_KeyUp() {
//	//alert("test1");
//	var formObject=document.form;
//	var srcName=ComGetEvent("name");
//	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
//	var srcValue=window.event.srcElement.getAttribute("value");
//	if (ComChkLen(srcValue, srcMaxLength) == "2") {
//		ComSetNextFocus();
//	}
//}

/**
 * onBlur - checking Validation
 */
function obj_activate() {
	switch (ComGetEvent("name")) {
	case "in_cr_indate_start":
		ComClearSeparator(ComGetEvent());
		break;
	case "in_cr_indate_end":
		ComClearSeparator(ComGetEvent());
		break;
	case "in_cr_edate_start":
		ComClearSeparator(ComGetEvent());
		break;
	case "in_cr_edate_end":
		ComClearSeparator(ComGetEvent());
		break;
	default:
		break;
	}
}

function obj_deactivate() {
	switch (ComGetEvent("name")) {
	case "in_cr_indate_start":
		ComAddSeparator(ComGetEvent());
		break;
	case "in_cr_indate_end":
		ComAddSeparator(ComGetEvent());
		break;
	case "in_cr_edate_start":
		ComAddSeparator(ComGetEvent());
		break;
	case "in_cr_edate_end":
		ComAddSeparator(ComGetEvent());
		break;
	default:
		break;
	}
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo)
{
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID){
	case "sheet1": // sheet1 init
	    with(sheetObj){
		      var HeadTitle1="|Seq.|M|VVD|Carrier|CNTR|TP|Seal No.1|Seal No.2|CGO Status|Yard|POL|POD|F/POD|Stowage|Gross Weight|CGO Type|IMO|DM|Trans|Loading Date|Customs\nDescription|Booking No.|Call Sign|Vessel Name|EDI Receiving Date";
		
		      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [
		             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"mtch_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seal_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seal_no2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cgo_sts_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"evnt_yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"n1st_pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"stwg_cell_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"grs_wgt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"eur_tml_dmg_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trsp_mod_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cntr_ldis_dt",        KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cstms_decl_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"call_sgn_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"vsl_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"edi_rpt_msg_rcv_dt",  KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
		      SetSheetHeight(442);
		      SetEditable(0);
        }
	    break;
	case "sheet2": // sheet1 init
	    with(sheetObj){
	      var HeadTitle1="Seq.|M|VVD|CNTR|TP|Seal No.1|Seal No.2|Booking No.|CGO Status|POD|FPOD|Stowage|Gross Weight|CGO Type|IMD|DM|Customs\nDescription";
	
	      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ 
	             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"mtch_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seal_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seal_no2",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cgo_sts_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"n1st_pod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stwg_cell_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"grs_wgt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"eur_tml_dmg_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cstms_decl_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
	      InitColumns(cols);
	      SetSheetHeight(175);
	      SetEditable(0);
        }
		break;
	}
}
/**
 * handling process for Sheet
 * @param sheetObj Sheet
 * @param formObj 
 * @param sAction 
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // 
		// if (validateForm(sheetObj, formObj, sAction))
		formObj.f_cmd.value=SEARCH;
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		if (formObj.in_list_type_temp[0].checked)
			formObj.in_list_type.value="L";
		else
			formObj.in_list_type.value="D";
		if (formObj.in_check_gubun_temp1.checked)
			formObj.in_check_gubun.value="1";
		else if (formObj.in_check_gubun_temp2.checked)
			formObj.in_check_gubun.value="2";
		else if (formObj.in_check_gubun_temp3.checked)
			formObj.in_check_gubun.value="3";
		else if (formObj.in_check_gubun_temp4.checked)
			formObj.in_check_gubun.value="4";
		else
			formObj.in_check_gubun.value="5";
		var sXml=sheetObj.GetSearchData("ESM_BKG_0617GS.do",FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0) {
			sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
			sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
		}
		state=sheetObj.GetEtcData("TRANS_RESULT_KEY");
		
		if (state == "S") {
			
			if (sheetObj.RowCount()> 0) {
				ComBtnEnable("btn_downExcel");
				ComBtnEnable("btn_printfor");
				if (formObj.in_list_type_temp[0].checked)
					ComBtnEnable("btn_cllForEDI");
			} else {
				ComBtnDisable("btn_downExcel");
				ComBtnDisable("btn_printfor");
				ComBtnDisable("btn_cllForEDI");
			}
		}
		//sheetObj.DoSearch("ESM_BKG_0617GS.do", FormQueryString(formObj));
		ComOpenWait(false);
		break;
	case COMMAND01: // 
		var inListType="";
		if (formObj.in_list_type_temp[0].checked)
			inListType="L";
		else
			inListType="D";
		var inVvdCd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "vvd_cd");
		var inPolCd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "pol_cd");
		var inPodCd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "pod_cd");
		var sUrl="/opuscntr/ESM_BKG_0155.do?inListType=" + inListType
				+ "&inVvdCd=" + inVvdCd + "&inPolCd=" + inPolCd + "&inPodCd="
				+ inPodCd;
		ComOpenWindowCenter(sUrl, "ESM_BKG_0155", 1024, 600, true);
		break;
	case IBDOWNEXCEL:
		if(sheetObj.RowCount() < 1){//no data
			ComShowCodeMessage("COM132501");
		}else{
			sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });
		}
		
		break;
	case COMMAND02: // 
		ComOpenWindowCenter("/opuscntr/ESM_BKG_0805.do?pgmNo=ESM_BKG_0805","805", 950, 690, false);
		break;
	}
}
/**
 * handling process for input validation
 * @param sheetObj Sheet
 * @param formObj 
 * @param sAction 
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}
	return true;
}
/**
 * initializing according to gubun value
 * @param gubun gubun
 */
function setSearchGubun(gubun)
{
	var formObj=document.form;
	if (gubun == "1") {
		if (formObj.in_check_gubun_temp1.checked) {
			formObj.in_check_gubun_temp2.checked=false;
			formObj.in_check_gubun_temp3.checked=false;
			formObj.in_check_gubun_temp4.checked=false;
		}
	}
	if (gubun == "2") {
		if (formObj.in_check_gubun_temp2.checked) {
			formObj.in_check_gubun_temp1.checked=false;
			formObj.in_check_gubun_temp3.checked=false;
			formObj.in_check_gubun_temp4.checked=false;
		}
	}
	if (gubun == "3") {
		if (formObj.in_check_gubun_temp3.checked) {
			formObj.in_check_gubun_temp1.checked=false;
			formObj.in_check_gubun_temp2.checked=false;
			formObj.in_check_gubun_temp4.checked=false;
		}
	}
	if (gubun == "4") {
		if (formObj.in_check_gubun_temp4.checked) {
			formObj.in_check_gubun_temp1.checked=false;
			formObj.in_check_gubun_temp2.checked=false;
			formObj.in_check_gubun_temp3.checked=false;
		}
	}
}
/**
 * setting date field according to gubun value
 * @param obj obj
 * @param gubun gubun
 */
function setListTeye(obj, gubun) 
{
	var formObj=document.form;
	var obj=document.getElementById(obj);
	var obj2=document.getElementById("loadingDate");
	var obj3=document.getElementById("dischargingDate");
	if (gubun == "L") {
		$(obj).show();
		$(obj2).show();
		$(obj3).hide();
	} else if (gubun == "D") {
		$(obj).hide();
		$(obj2).hide();
		$(obj3).show();
	}
}
