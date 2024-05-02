/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_TRS_0927.js
 *@FileTitle : Confirmation Message Send Pop up
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/

/**------------------From here the common JavaScript function is defined.     ------------------*/
/** Common global variable */
var opensheetObject = opener.sheetObjects[0];
var sheetObjects = new Array();
var sheetCnt = 0;
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:   
			with (sheetObj) {
	        var HeadTitle="STS|Container No|SN|Related Trucker Code|Related Trucker Name|Related Trucker Fax No|Related Trucker E-Mail Address|Shipper Name|Shipper Fax Number|Shipper E-mail Address|Sent User|Sent Time|Sent Type";
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle, Align:"Center"} ];
	        InitHeaders(headers, info);
	        var cols = [ 
	               {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Seq",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"snd_seq" },
	               {Type:"PopupEdit", Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"rlt_trkr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"rlt_trkr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"rlt_trkr_fax_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:20 },
	               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"rlt_trkr_eml",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"shpr_cust_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"shpr_fax_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:20 },
	               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"shpr_eml",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"snd_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"snd_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"snd_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1,  Width:9,    Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1,  Width:9,    Align:"Center",  ColMerge:1,   SaveName:"trsp_so_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1,  Width:9,    Align:"Center",  ColMerge:1,   SaveName:"msg_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1,  Width:9,    Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1,  Width:9,    Align:"Center",  ColMerge:1,   SaveName:"snd_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1,  Width:9,    Align:"Center",  ColMerge:1,   SaveName:"snd_yn",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } 
	               ];
	        
	        InitColumns(cols);
	        SetSheetHeight(240);
	        SetEditable(1);
	        SetColProperty(0 ,"rlt_trkr_fax_no" , {AcceptKeys:"N"});
	        SetColProperty(0 ,"shpr_fax_no" , {AcceptKeys:"N"});
	        ComResizeSheet(sheetObj);
			}
		break;
	}
}
/** Event handler processing by button click event */
document.onclick = processButtonClick;
/** Event handler processing by button name */
function processButtonClick() {
	/** ***Case more than two additional sheets tab sheet is used to specify a variable **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	try {
		switch (ComGetEvent("name")) {
			case "btng_rowadd":
				doRowInsertData(sheetObject);
				break;
			case "btng_send":
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
			case "btng_delete":
				doRowDeleteData(sheetObject);
				break;
			case "btn_close":
				window.close();
				break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("TRS90106");
		} else {
			ComShowMessage(e.message);
		}
	}
}

function sheet_OnChange(sheetObj, Row, Col, Value) {
	var colName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	switch (colName) {
		case "rlt_trkr_seq":
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC01, Row, Value);
			break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction, Row, Value) {
	switch (sAction) {
		case IBSEARCH: // retrieve
			formObj.f_cmd.value = SEARCH02;
			formObj.f_trsp_so_ofc_cty_cd.value = opener.parmOfccd;
			formObj.f_trsp_so_seq.value = opener.parmSoseq;
			sheetObj.DoSearch("ESD_TRS_0927GS.do", TrsFrmQryString(formObj));
			break;
		case IBSAVE:
			formObj.f_cmd.value = MULTI01;
			if (sheetObj.GetCellValue(1, "snd_yn") != "Y") {
				sheetObj.SetRowStatus(1, "I");
			}
			if (!validateForm(sheetObj, formObj, sAction)) return;
			sheetObj.DoSave("ESD_TRS_0927GS.do", TrsFrmQryString(formObj), "ibflag", false, false);
			break;
		case IBSEARCH_ASYNC01:
			var queryString = "f_cmd=" + SEARCH01 + "&vndr_seq=" + Value;
			var sXml = sheetObj.GetSearchData("ESD_TRS_0927_ASYNC_GS.do", queryString);
			var vndrSeq = ComGetEtcData(sXml, 'vndr_seq');
			var faxNo = ComGetEtcData(sXml, 'fax_no');
			var vndrEml = ComGetEtcData(sXml, 'vndr_eml');
			var vndrLglEngNm = ComGetEtcData(sXml, 'vndr_lgl_eng_nm');
			sheetObj.SetCellValue(Row, "rlt_trkr_fax_no", faxNo, 0);
			sheetObj.SetCellValue(Row, "rlt_trkr_eml", vndrEml, 0);
			sheetObj.SetCellValue(Row, "rlt_trkr_nm", vndrLglEngNm, 0);
			if (vndrSeq == '') {
				sheetObj.SetCellValue(Row, "rlt_trkr_seq", vndrSeq, 0);
			}
			break;
	}
}

function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSAVE:
			for ( var i = 1; i < sheetObj.RowCount() + 1; i++) {
				if (sheetObj.GetCellValue(i, "snd_yn") != 'Y') {
					if ((!ComIsNull(sheetObj.GetCellValue(i, "rlt_trkr_fax_no")) || !ComIsNull(sheetObj.GetCellValue(i, "rlt_trkr_eml"))) && ComIsNull(sheetObj.GetCellValue(i, "rlt_trkr_nm"))) {
						ComShowCodeMessage("TRS90410", "Related Trucker Name");
						return false;
					}
					if ((!ComIsNull(sheetObj.GetCellValue(i, "shpr_fax_no")) || !ComIsNull(sheetObj.GetCellValue(i, "shpr_eml"))) && ComIsNull(sheetObj.GetCellValue(i, "shpr_cust_nm"))) {
						ComShowCodeMessage("TRS90410", "Shipper Name");
						return false;
					}
				}
			}
			return true;
			break;
	}
	return true;
}
/*
 * Copy to copy the row above the row below
 */
function doRowInsertData(sheetObj) {
	var rows = sheetObj.RowCount();
	sheetObj.DataInsert(rows + 1);
	for (ic = 1; ic <= sheetObj.LastCol(); ic++) {
		if (sheetObj.ColSaveName(ic) == 'snd_yn') {
			sheetObj.SetCellValue(rows + 1, sheetObj.ColSaveName(ic), "", 0);
		} else {
			sheetObj.SetCellValue(rows + 1, sheetObj.ColSaveName(ic), sheetObj.GetCellValue(rows, sheetObj.ColSaveName(ic)), 0);
		}
	}
}
/*
 * Delete the following Row
 */
function doRowDeleteData(sheetObj) {
	if (sheetObj.GetCellValue(sheetObj.RowCount(), "ibflag") == "I") {
		sheetObj.RowDelete(sheetObj.RowCount(), false);
	} else {
		ComShowCodeMessage("TRS90111");
	}
}
/**
 * When an error occurs, save the results to a common processing function DataSheetObject.prototype.event_OnSearchEnd defined in IBSheetConfig.js
 */
function sheet_OnSaveEnd(sheetObj, errMsg) {
	if (errMsg != -1) {
		if (errMsg.length > 0) {
			ComShowMessage(errMsg);
		} else {
			ComShowCodeMessage("TRS90043");
			ComClosePopup();
		}
	}
}
/**
 * When an error occurs, save the results to a common processing function DataSheetObject.prototype.event_OnSearchEnd defined in IBSheetConfig.js
 */
function sheet_OnSearchEnd(sheetObj, errMsg) {
	if (errMsg.length > 0) {
		ComShowMessage(errMsg);
	}
}
/*
 * IBSheet Pop-Up
 */
var doc_row = "";
function sheet_OnPopupClick(sheetObj, row, col) {
	doc_row = row;
	rep_OnPopupClick();
}
/**
 * call rep_commodity pop-up
 */
function rep_OnPopupClick() {
	var formObject = document.form;
	var cmdt_cd_val = ""; // Variables will be available for future use
	var rep_cmdt_cd_val = ""; // Variables will be available for future use
	var cmdt_desc_val = ""; // Variables will be available for future use
	var classId = "getCOM_ENS_rep";
	var xx1 = ""; // CONTI
	var xx2 = ""; // SUB CONTI
	var xx3 = ""; // COUNTRY
	var xx4 = ""; // STATE
	var xx5 = ""; // CONTROL OFFIC
	var xx6 = ""; // LOC CODE
	var xx7 = ""; // LOC NAME
	var xx8 = "";
	var xx9 = "";
	var param = "?conti_cd=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
	ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 700, 300, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1', true, false);
}
/**
 * call rep_commodity pop-up
 */
function getCOM_ENS_rep(rowArray) {
	for ( var i = 0; i < rowArray.length; i++) {
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[3];
		sheetObjects[0].SetCellValue(doc_row, "rlt_trkr_seq", colArray2, 1);
	}
}
