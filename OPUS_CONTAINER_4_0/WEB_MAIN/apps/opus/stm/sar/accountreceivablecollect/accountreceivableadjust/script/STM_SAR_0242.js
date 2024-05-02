/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : STM_SAR_0242.jsp
 *@FileTitle  : Offset AP Search Popup
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/08/06
=========================================================*/

// IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;

// html form
var frm = null;

function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

// ===================================================================================
// initializing
// ===================================================================================
/**
 * initializing sheet implementing onLoad event handler in body tag adding
 * first-served functions after loading screen.
 */
function loadPage() {
	// global variable set
	frm = document.form;
	sheet1 = sheetObjects[0];
	sheetCnt = sheetObjects.length;
	
	// sheet initialize
	for ( var i = 0; i < sheetCnt; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	// Form event register
	initControl();
}

/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case
 * as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
		with (sheetObj) {
			switch (sheetObj.id) {
				case "sheet1":
					var HeadTitle1 = "||Office|Supplier|Vendor Name|Invoice No|Invoice Date|Currency|Amount|offset_tp|org_inv_amt|ap_xch_rt|gl_dt";
					var headCount = ComCountHeadTitle(HeadTitle1);

					SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 1 });

					var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
					var headers = [ { Text : HeadTitle1, Align : "Center" } ];
					InitHeaders(headers, info);

					var cols = [ { Type : "Status",		Hidden : 1, Width : 0,		Align : "Center",	ColMerge : 1,	SaveName : "ibflag",			KeyField : 0,	CalcLogic : "",	Format : "",		PointCount : 0,	UpdateEdit : 1,	InsertEdit : 1	}, 
					             { Type : "CheckBox", 	Hidden : 0, Width : 40,		Align : "Center",	ColMerge : 1,	SaveName : "checkbox",			KeyField : 0,	CalcLogic : "",	Format : "",		PointCount : 0,	UpdateEdit : 1,	InsertEdit : 1	}, 
					             { Type : "Text", 		Hidden : 0, Width : 60,		Align : "Center",	ColMerge : 1,	SaveName : "ofc_cd",			KeyField : 0,	CalcLogic : "",	Format : "",		PointCount : 0,	UpdateEdit : 0,	InsertEdit : 0	}, 
					             { Type : "Text",		Hidden : 0,	Width : 60,		Align : "Center",	ColMerge : 1,	SaveName : "vndr_no",			KeyField : 0,	CalcLogic : "",	Format : "",		PointCount : 0,	UpdateEdit : 0,	InsertEdit : 0	}, 
					             { Type : "Text",		Hidden : 0,	Width : 220,	Align : "Left",		ColMerge : 1,	SaveName : "vndr_lgl_eng_nm",	KeyField : 0,	CalcLogic : "",	Format : "",		PointCount : 0,	UpdateEdit : 0,	InsertEdit : 0	}, 
					             { Type : "Text",		Hidden : 0,	Width : 130,	Align : "Center",	ColMerge : 1,	SaveName : "inv_no",			KeyField : 0,	CalcLogic : "",	Format : "",		PointCount : 0,	UpdateEdit : 0,	InsertEdit : 0	}, 
					             { Type : "Text",		Hidden : 0,	Width : 80,		Align : "Center",	ColMerge : 1,	SaveName : "inv_dt",			KeyField : 0,	CalcLogic : "",	Format : "ymd",		PointCount : 0,	UpdateEdit : 0,	InsertEdit : 0	}, 
					             { Type : "Text",		Hidden : 0,	Width : 60,		Align : "Center",	ColMerge : 1,	SaveName : "inv_curr_cd",		KeyField : 0,	CalcLogic : "",	Format : "",		PointCount : 0,	UpdateEdit : 0,	InsertEdit : 0	}, 
					             { Type : "Text",		Hidden : 0,	Width : 100,	Align : "Right",	ColMerge : 1,	SaveName : "inv_amt",			KeyField : 0,	CalcLogic : "",	Format : "Float",	PointCount : 2,	UpdateEdit : 1,	InsertEdit : 1,	EditLen : 18 }, 
					             { Type : "Text",		Hidden : 1,	Width : 0,		Align : "Center",	ColMerge : 1,	SaveName : "offst_tp_cd" }, 
					             { Type : "Text",		Hidden : 1,	Width : 0,		Align : "Right",	ColMerge : 1,	SaveName : "org_inv_amt",		KeyField : 0,	CalcLogic : "",	Format : "Float",	PointCount : 2 }, 
					             { Type : "Text",		Hidden : 1,	Width : 0,		Align : "Right",	ColMerge : 1,	SaveName : "ap_xch_rt",			KeyField : 0,	CalcLogic : "",	Format : "Float",	PointCount : 7 }, 
					             { Type : "Text",		Hidden : 1,	Width : 0,		Align : "Center",	ColMerge : 1,	SaveName : "gl_dt" }, 
					             { Type : "Text",		Hidden : 1,	Width : 0,		Align : "Center",	ColMerge : 1,	SaveName : "dp_prcs_knt" } 
					             ];
					InitColumns(cols);
					SetEditable(1);
					SetColProperty("inv_dt", {Format:"####-##-##"} );   
//					SetSheetHeight(330);
					resizeSheet();
					break;
		}
	}
}

// ===================================================================================
// Private function
// ===================================================================================
/**
 * handling process for input validation
 */
function validateForm() {
	if (!ComChkObjValid(frm.inv_dt_fm) || !ComChkObjValid(frm.inv_dt_to)) {
		return false;
	}
	
	if (!ComIsNull(frm.inv_dt_fm.value) && !ComIsNull(frm.inv_dt_to.value)
			&& ComGetDaysBetween(frm.inv_dt_fm.value, frm.inv_dt_to.value) < 0) {
		ComShowCodeMessage('COM12133', 'Invoice to-date', 'from-date', 'grater');
		frm.inv_dt_fm.focus();
		return false;
	}
	
	return true;
}

/**
 * cal total invoice amount
 */
function caltInvSum() {
	var totalSum = 0.00;
	var checked = 0;
	
	for ( var i = 1; i <= sheet1.RowCount(); i++) {
		if (sheet1.GetCellValue(i, "checkbox") == 1) {
			totalSum += ComRound(ComReplaceStr(sheet1.GetCellValue(i, "inv_amt"),",",""), 2);
			checked++;
		}
	}
	
	if (checked > 0) {
		return totalSum;
	}
	
	return totalSum;
}

// ===================================================================================
// Form Event Processing
// ===================================================================================

// Button event handler
document.onclick = processButtonClick;

/**
 * Button event handler function
 */
function processButtonClick() {
	var srcName=ComGetEvent("name");
	if(ComGetBtnDisable(srcName)) return false;
	var chkALL = frm.chkALL;
	var chkBRH = frm.chkBRH;
	var chkAGT = frm.chkAGT;
	
	switch (srcName) {
			
		case "btns_calendar_fm": // calendar from
			var cal = new ComCalendar();
			cal.select(frm.inv_dt_fm, 'yyyy-MM-dd');
			break;
			
		case "btns_calendar_to": // calendar to
			var cal = new ComCalendar();
			cal.select(frm.inv_dt_to, 'yyyy-MM-dd');
			break;
			
		case "btns_vndr_popup":
			var url = "STM_SAR_0002.do";
			var win = ComOpenPopup(url, 600, 400, "callback_tns_vndr_popup", "0,0", true);
			break;
			
		case "btn_searchlist":
			doActionIBSheet(SEARCHLIST);
			break;
			
		case "btn_OK":
			comPopupOK();
			break;
			
		case "btn_Close":
			ComClosePopup();
			break;
			
	}
}

/**
 * Form Event register
 */
function initControl() {
	// focus out
	axon_event.addListenerFormat('change', 'obj_change', frm);
	axon_event.addListenerFormat('keydown', 'obj_keydown', frm);
}

/**
 * HTML Control onChange
 */
function obj_change() {
	switch (event.srcElement.name) {
		case "vndr_no":
			frm.vndr_lgl_eng_nm.value = "";
			break;
			
		default:
			break;
		
	}
}

/**
 * Handling OnKeyDown even <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param N/A
 * @return N/A
 * @author
 * @version 2009.04.17
 */
function obj_keydown() {
	// Proposal No,S/C No.,Retrieving by enter key
	var eleName = event.srcElement.name;	
	var keyValue = null;
	
	if (event == undefined || event == null) {
		keyValue = 13;
	} else {
		keyValue = event.keyCode ? event.keyCode : event.which ? event.which
				: event.charCode;
	}
	
	if (keyValue == 13) {
		doActionIBSheet(SEARCHLIST);
	}
}


/**
 * COM_COM_0007 : Vendor code
 */
function callback_tns_vndr_popup(rowArray) {
	var colArray = rowArray[0];
	
	// SarShowPopupData(rowArray);
	frm.vndr_no.value = colArray[1];
	frm.vndr_lgl_eng_nm.value = colArray[2];
}

// ===================================================================================
// Sheet Event
// ===================================================================================
/**
 * sheet1 편집처리후 이벤트
 * 
 * @param {long} row 해당 셀의 Row Index
 * @param {long} col 해당 셀의 Column Index
 * @param {string} col 해당 셀의 value
 * 
 */
function sheet1_OnChange(sheet, row, col, value) {
	if (sheet.ColSaveName(col) == "checkbox" || sheet.ColSaveName(col) == "inv_amt") {
		frm.inv_amt.value = ComGetMaskedValue(caltInvSum(), "float");
	}
}

/**
 * add float digits
 * 
 * @param {float} fval float value
 * @param {int} digits float digits
 * @param {float} add float digits
 * 
 */
function addDigits(fval, digits) {
	var sval = fval + "";
	
	if (sval.indexOf(".") >= 0) {
		return fval;
	}
	
	sval += ".";
	
	for ( var i = 0; i < digits; i++) {
		sval += "0";
	}
	
	return parseFloat(sval);
}

// ===================================================================================
// do Action Processing
// ===================================================================================
/**
 * Do action
 * 
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	if (sAction == SEARCHLIST) {
		if (validateForm()) {
			ComOpenWait(true);
			setTimeout( function () {
				frm.f_cmd.value = SEARCHLIST;
				var sXml = sheet1.GetSearchData("STM_SAR_0242GS.do", FormQueryString(frm));
				sheet1.LoadSearchData(sXml, { Sync : 1 });
				frm.inv_amt.value = "";
				ComOpenWait(false);  
			} , 100);
		}
	}
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}