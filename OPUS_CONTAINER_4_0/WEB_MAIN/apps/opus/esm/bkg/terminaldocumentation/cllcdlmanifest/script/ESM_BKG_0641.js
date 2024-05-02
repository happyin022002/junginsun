/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0641.js
*@FileTitle  : Container Discharging Status Check
*@author     : CLT
*@version    : 
*@since      : 04/29/2014
=========================================================*/

/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
function processButtonClick() {
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
		case "btn_downExcel":
			doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
			break;
		case "btns_calendar": // calendar button
			// can't use before retrieve
			var cal=new ComCalendarFromTo();
			cal.select(formObject.in_edi_rpt_msg_rcv_dt_start, formObject.in_edi_rpt_msg_rcv_dt_end, 'yyyy-MM-dd');
			break;
		case "btns_calendar2": // calendar button
			// can't use before retrieve
			var cal=new ComCalendarFromTo();
			cal.select(formObject.in_cntr_ldis_dt_start, formObject.in_cntr_ldis_dt_end, 'yyyy-MM-dd');
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
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl()
}
/**
 * init control
 */
function initControl() {
	// ** Date delimiter **/
	DATE_SEPARATOR="-";
	var formObject=document.form;
	
	axon_event.addListenerForm  ('blur', 'obj_deactivate', formObject); //- focus in
	axon_event.addListenerFormat('focus', 'obj_activate', formObject); //- focus out
	
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
 	
	formObject.in_edi_rpt_msg_rcv_dt_start.focus();
	
	
}
function obj_activate() {
	switch (ComGetEvent("name")) {
	case "in_edi_rpt_msg_rcv_dt_start":
		ComClearSeparator(ComGetEvent());
		break;
	case "in_edi_rpt_msg_rcv_dt_end":
		ComClearSeparator(ComGetEvent());
		break;
	case "in_cntr_ldis_dt_start":
		ComClearSeparator(ComGetEvent());
		break;
	case "in_cntr_ldis_dt_end":
		ComClearSeparator(ComGetEvent());
		break;
	default:
		break;
	// return;
	// ComAddSeparator(ComGetEvent());
	// ComChkObjValid(ComGetEvent());
	}
}

function obj_deactivate() {
	switch (ComGetEvent("name")) {
	case "in_edi_rpt_msg_rcv_dt_start":
		ComAddSeparator(ComGetEvent());
		break;
	case "in_edi_rpt_msg_rcv_dt_end":
		ComAddSeparator(ComGetEvent());
		break;
	case "in_cntr_ldis_dt_start":
		ComAddSeparator(ComGetEvent());
		break;
	case "in_cntr_ldis_dt_end":
		ComAddSeparator(ComGetEvent());
		break;		
	}
}

/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
* @param sheetObj sheet Object
* @param sheetNo 
*/
function initSheet(sheetObj, sheetNo) {
	switch (sheetObj.id) {
	case "sheet1":
	    with(sheetObj){
	      var HeadTitle="|Seq|VVD|Carrier|Container No|TS|Seal No1|BKG|Cargo Status|Yard|POL|POD|Stowage|Gross Weight|Tare|Cargo Type|IMO|Dm|Discharging Date|Call Sign|Vessel Name|MSG In Date";
	      var headCount=ComCountHeadTitle(HeadTitle);
	
	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Status",    Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"tml_vvd_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"crr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cgo_sts_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"evnt_yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"stwg_cell_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"grs_wgt",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tare_wgt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cgo_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"imdg_clss_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"eur_tml_dmg_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cntr_ldis_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"call_sgn_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:0,   SaveName:"vsl_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"edi_rpt_msg_rcv_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	       
	      InitColumns(cols);
	
	      SetEditable(1);
	      SetSheetHeight(490);
      	}
		break;
	}
}
/**
* Sheet process handling
* @param sheetObj
* @param formObj
* @param sAction
* @return
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // Retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			//alert();	
			formObj.f_cmd.value=SEARCH;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_0641GS.do", FormQueryString(formObj), {Sync:2});
			ComOpenWait(false);
		}
		break;
	case IBDOWNEXCEL:
		if(sheetObj.RowCount() < 1){
			ComShowCodeMessage("COM132501");
		}else{
			sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });
       	 
		}
		break;
	}
}


/**
* handling process for input validation
* @param sheetObj sheet Object
* @param formObj  form Object
* @param sAction 
*/
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // Retrieve
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if (formObj.in_edi_rpt_msg_rcv_dt_start.value == ""
				|| formObj.in_edi_rpt_msg_rcv_dt_start.value.length != 10) {
			ComShowCodeMessage('BKG00341');
			return false;
		}
		if (formObj.in_edi_rpt_msg_rcv_dt_end.value == ""
				|| formObj.in_edi_rpt_msg_rcv_dt_end.value.length != 10) {
			ComShowCodeMessage('BKG00341');
			return false;
		}
//		var iDays=ComGetDaysBetween(
//				formObj.in_edi_rpt_msg_rcv_dt_start.value,
//				formObj.in_edi_rpt_msg_rcv_dt_end.value);
//		if (iDays > 7) {
//			ComShowCodeMessage('BKG00626', 'Peorid is more than a week!');
//			return false;
//		}
		return true;
		break;
	}
}
