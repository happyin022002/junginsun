/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : STM_SAR_3004.js
 *@FileTitle  : Adjust View Accounting
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/08/07
=========================================================*/

// ===================================================================================
// global variable
// ===================================================================================
// IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;

// html form
var frm = null;

/**
 * IBSheet Object를 배열로 등록
 * 
 * @param {ibsheet} sheetObj IBSheet Object
 */
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
	
	var action_type = frm.action_type.value;
	
	if (action_type == "ADJ") {
		document.title = "Adjust View Accounting";
		document.getElementById("title").innerText = "Adjust View Accounting";
		document.getElementById("key_title").innerText = "Adjust No";
		sheet1.SetCellValue(0, "adj_no", "Adjust No");
	} else if (action_type == "OFF") {
		document.title = "Offset View Accounting";
		document.getElementById("title").innerText = "Offset View Accounting";
		document.getElementById("key_title").innerText = "Offset No";
		sheet1.SetCellValue(0, "adj_no", "Offset No");
	} else if (action_type == "ASA") {
		document.title = "ASA View Accounting";
		document.getElementById("title").innerText = "ASA View Accounting";
		document.getElementById("key_title").innerText = "ASA No";
		sheet1.SetCellValue(0, "adj_no", "ASA No");
	}
	
	doActionIBSheet(SEARCHLIST);
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
				var HeadTitle1 = "|DIST. Type|B/L No|IF No|GL DATE|Charge|COA1|COA2|COA3|COA4|COA5|COA6|CUR|Debit AMT|Credit AMT|ACCT Ex.Rate|ACCT Debit AMT|ACCT Credit AMT|ACCT Ex.Date|Adjust Status|Adjust Type";
				var headCount = ComCountHeadTitle(HeadTitle1);
				 
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 1 });
				
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [ { Text : HeadTitle1, Align : "Center" } ];
				InitHeaders(headers, info);
				
				var cols = [ { Type : "Status",	Hidden : 1, Width : 0,		Align : "Center", ColMerge : 1, SaveName : "ibflag",			KeyField : 0, CalcLogic : "", Format : "",		PointCount : 0, UpdateEdit : 1, InsertEdit : 1 }, 
				             /*{ Type : "Text",	Hidden : 0, Width : 140,	Align : "Center", ColMerge : 1, SaveName : "adj_no",			KeyField : 0, CalcLogic : "", Format : "",		PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, */
				             { Type : "Text",	Hidden : 0,	Width : 90,		Align : "Center", ColMerge : 1, SaveName : "dtrb_src_tp_cd",	KeyField : 0, CalcLogic : "", Format : "",		PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text",	Hidden : 0, Width : 100,		Align : "Center", ColMerge : 1, SaveName : "bl_no",				KeyField : 0, CalcLogic : "", Format : "",		PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text",	Hidden : 0, Width : 100,		Align : "Center", ColMerge : 1, SaveName : "if_no",				KeyField : 0, CalcLogic : "", Format : "",		PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text",	Hidden : 0, Width : 90,		Align : "Center", ColMerge : 1,	SaveName : "gl_dt",				KeyField : 0, CalcLogic : "", Format : "Ymd",	PointCount : 0,	UpdateEdit : 0, InsertEdit : 0 },
				             { Type : "Text",	Hidden : 0, Width : 60,		Align : "Center", ColMerge : 1, SaveName : "chg_tp_cd",			KeyField : 0, CalcLogic : "", Format : "",		PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text",	Hidden : 0, Width : 50,		Align : "Center", ColMerge : 1, SaveName : "sgm_ctnt1",			KeyField : 0, CalcLogic : "", Format : "",		PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text",	Hidden : 0, Width : 50,		Align : "Center", ColMerge : 1, SaveName : "sgm_ctnt2",			KeyField : 0, CalcLogic : "", Format : "",		PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text",	Hidden : 0, Width : 50,		Align : "Center", ColMerge : 1, SaveName : "sgm_ctnt3",			KeyField : 0, CalcLogic : "", Format : "",		PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text",	Hidden : 0, Width : 50,		Align : "Center", ColMerge : 1, SaveName : "sgm_ctnt4",			KeyField : 0, CalcLogic : "", Format : "",		PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text",	Hidden : 0, Width : 50,		Align : "Center", ColMerge : 1, SaveName : "sgm_ctnt5",			KeyField : 0, CalcLogic : "", Format : "",		PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text",	Hidden : 0, Width : 100,	Align : "Center", ColMerge : 1, SaveName : "sgm_ctnt6",			KeyField : 0, CalcLogic : "", Format : "",		PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				            /* { Type : "Text",	Hidden : 0,	Width : 70,		Align : "Center", ColMerge : 1, SaveName : "acct_clss_cd",		KeyField : 0, CalcLogic : "", Format : "",		PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, */
				             { Type : "Text",	Hidden : 0, Width : 50,		Align : "Center", ColMerge : 1, SaveName : "curr_cd",			KeyField : 0, CalcLogic : "", Format : "",		PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Float",	Hidden : 0, Width : 95,		Align : "Right",  ColMerge : 1, SaveName : "inp_dr_amt",		KeyField : 0, CalcLogic : "", Format : "Float",	PointCount : 2, UpdateEdit : 0, InsertEdit : 0, EditLen : 18 }, 
				             { Type : "Float",	Hidden : 0, Width : 95,		Align : "Right",  ColMerge : 1, SaveName : "inp_cr_amt",		KeyField : 0, CalcLogic : "", Format : "Float",	PointCount : 2,	UpdateEdit : 0,	InsertEdit : 0,	EditLen : 18 }, 
				             { Type : "Float",	Hidden : 0,	Width : 90,		Align : "Right",  ColMerge : 1, SaveName : "conv_xch_rt",		KeyField : 0, CalcLogic : "", Format : "Float", PointCount : 8, UpdateEdit : 0, InsertEdit : 0, EditLen : 18 }, 
				             { Type : "Float",	Hidden : 0,	Width : 110,		Align : "Right",  ColMerge : 1,	SaveName : "acct_dr_amt",		KeyField : 0, CalcLogic : "", Format : "Float", PointCount : 2, UpdateEdit : 0, InsertEdit : 0, EditLen : 18 }, 
				             { Type : "Float",	Hidden : 0, Width : 110,		Align : "Right",  ColMerge : 1, SaveName : "acct_cr_amt",		KeyField : 0, CalcLogic : "", Format : "Float",	PointCount : 2,	UpdateEdit : 0,	InsertEdit : 0,	EditLen : 18 }, 
				             { Type : "Text",	Hidden : 0, Width : 90,		Align : "Center", ColMerge : 1,	SaveName : "acct_xch_rt_dt",	KeyField : 0, CalcLogic : "", Format : "Ymd",	PointCount : 0,	UpdateEdit : 0, InsertEdit : 0 }, 
				             { Type : "Text",	Hidden : 0, Width : 90,		Align : "Center", ColMerge : 1, SaveName : "adj_sts_cd",		KeyField : 0, CalcLogic : "", Format : "",		PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				             { Type : "Text",	Hidden : 0, Width : 90,		Align : "Center", ColMerge : 1, SaveName : "adj_tp_cd",		KeyField : 0, CalcLogic : "", Format : "",		PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }
				             ];
				InitColumns(cols);
				SetEditable(0);
//				SetSheetHeight(300);
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
	return true;
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
	var srcName = ComGetEvent("name");
	if(ComGetBtnDisable(srcName)) return false;
	switch (srcName) {
		case "btn_search":
			doActionIBSheet(SEARCHLIST);
			break;
			
		case "btn_excel":
			if (sheet1.RowCount() <= 0) {
				// msgs["SAR00030"] = "There is no data to search.";
				ComShowCodeMessage("SAR00030");
				return false;
			}
			
			sheet1.Down2Excel({HiddenColumn : 1, TreeLevel : false, SheetName : "acc_view" });
			break;
			
		case "btn_close":
			ComClosePopup();
			break;
			
	}
}

/**
 * Form Event register
 */
function initControl() {
	axon_event.addListenerFormat('keydown', 'obj_keydown', frm);
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
	var eleName = ComGetEvent("name");
	var keyValue = null;
	if (event == undefined || event == null) {
		keyValue = 13;
	} else {
		keyValue = event.keyCode ? event.keyCode : event.which ? event.which
				: event.charCode;
	}
	if (keyValue == 13 && (eleName == "adj_no" || eleName == "ots_ofc_cd")) {
		doActionIBSheet(SEARCHLIST);
	}
}

// ===================================================================================
// Sheet Event
// ===================================================================================

// ===================================================================================
//do Action Processing 
//===================================================================================
/**
 * Do action 
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	if (sAction == SEARCHLIST) {
		if (validateForm()) {
			sheet1.WaitImageVisible=false;
			ComOpenWait(true); 
			setTimeout( function () {
				frm.f_cmd.value = SEARCHLIST;
				var sXml = sheet1.GetSearchData("STM_SAR_3004GS.do", FormQueryString(frm));
				sheet1.LoadSearchData(sXml, { Sync : 1 });
				ComOpenWait(false); 
			} , 100);	
		}
	}
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0], 50);
}