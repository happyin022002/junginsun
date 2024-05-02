/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_PRD_0035.js
 *@FileTitle  : OceanRoute Manual Creation
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/08/01
=========================================================*/
// Common global variable 
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var myWin = '';
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btng_rowadd":
				doActionIBSheet(sheetObject, formObject, IBINSERT);
				break;
			case "btng_rowcopy":
				doActionIBSheet(sheetObject, formObject, IBCOPYROW);
				break;
			case "btng_rowdel":
				doActionIBSheet(sheetObject, formObject, IBDELETE);
				break;
			case "btn_ok":
				doSetValue(sheetObject, formObject);
				break;
			case "btn_close":
				ComClosePopup();
				break;
		} 
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111'));
		} else {
			ComShowMessage(e.message);
		}
	}
}
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
	for (var i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
}
/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
		case 1:
			with (sheetObj) {
				var HeadTitle = "Seq.|Chk|STS|OCN Flag|RMK|RMK|Priority|POL|1st Link|1st Link|1st Link|1st Link|1st Link|2nd Link|2nd Link|2nd Link|2nd Link|2nd Link|3rd Link|3rd Link|3rd Link|3rd Link|3rd Link|4th Link|4th Link|4th Link|4th Link|4th Link|POD|FDRFLG1|FDRFLG2|FDRFLG3|FDRFLG4|PRIOR|TTIME|TTDY|TTHR|TT1|TT2|TT3|TT4|STIMIE|STDY|STHR|ST1|ST2|ST3|TSIND|FU|POD1ETB|POL2ETB|POD2ETB|POL3ETB|POD3ETB|POL4ETB|LNKCNT";
				var HeadTitle1 = "Seq.|Chk|STS|OCN Flag|Type|Note|Priority|POL|Pol|Lane|Dir|Type|Pod|Pol|Lane|Dir|Type|Pod|Pol|Lane|Dir|Type|Pod|Pol|Lane|Dir|Type|Pod|POD";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
				var headers = [
						{ Text : HeadTitle, Align : "Center" }, { Text : HeadTitle1, Align : "Center" }
				];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "Seq", 	Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "s_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "CheckBox", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "s_chk", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Status", 	Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "ibflag", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Combo", 	Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "s_route_flg", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Combo", 	Hidden : 0, Width : 60, Align : "Left", ColMerge : 1, SaveName : "s_route_rmk", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", 	Hidden : 0, Width : 100, Align : "Left", ColMerge : 1, SaveName : "s_route_note", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0},
						{ Type : "Text", 	Hidden : 0, Width : 70, Align : "Center", ColMerge : 1, SaveName : "s_prior", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, AcceptKeys : "|[123456789]" , EditLen : 1},
						{ Type : "Text", 	Hidden : 0, Width : 70, Align : "Center", ColMerge : 1, SaveName : "s_pol", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, AcceptKeys : "E|[0123456789]", InputCaseSensitive : 1 },
						{ Type : "Text", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_pol1", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "s_ts1_lane", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, AcceptKeys : "E|[0123456789]", InputCaseSensitive : 1 },
						{ Type : "Text", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "s_dir1", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, AcceptKeys : "E", InputCaseSensitive : 1 },
						{ Type : "Text", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_ts1_type", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "PopupEdit", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_pod1", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 5, AcceptKeys : "E|[0123456789]", InputCaseSensitive : 1 },
						{ Type : "Text", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_pol2", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "s_ts2_lane", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, AcceptKeys : "E|[0123456789]", InputCaseSensitive : 1 },
						{ Type : "Text", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_dir2", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, AcceptKeys : "E", InputCaseSensitive : 1 },
						{ Type : "Text", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_ts2_type", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "PopupEdit", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_pod2", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 5, AcceptKeys : "E|[0123456789]", InputCaseSensitive : 1 },
						{ Type : "Text", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_pol3", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "s_ts3_lane", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, AcceptKeys : "E|[0123456789]", InputCaseSensitive : 1 },
						{ Type : "Text", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_dir3", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, AcceptKeys : "E", InputCaseSensitive : 1 },
						{ Type : "Text", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_ts3_type", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "PopupEdit", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_pod3", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 5, AcceptKeys : "E|[0123456789]", InputCaseSensitive : 1 },
						{ Type : "Text", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_pol4", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "s_ts4_lane", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, AcceptKeys : "E|[0123456789]", InputCaseSensitive : 1 },
						{ Type : "Text", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_dir4", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, AcceptKeys : "E", InputCaseSensitive : 1 },
						{ Type : "Text", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_ts4_type", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "PopupEdit", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "s_pod4", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 5, AcceptKeys : "E|[0123456789]", InputCaseSensitive : 1 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Center", ColMerge : 1, SaveName : "s_pod", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 40, Align : "Center", ColMerge : 1, SaveName : "s_fdr_flg1", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 40, Align : "Center", ColMerge : 1, SaveName : "s_fdr_flg2", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 40, Align : "Center", ColMerge : 1, SaveName : "s_fdr_flg3", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 40, Align : "Center", ColMerge : 1, SaveName : "s_fdr_flg4", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 75, Align : "Center", ColMerge : 1, SaveName : "s_t_time", KeyField : 0, CalcLogic : "|s_t_t1|+|s_t_t2|+|s_t_t3|+|s_t_t4|", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 75, Align : "Center", ColMerge : 1, SaveName : "s_t_t_dy", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 75, Align : "Center", ColMerge : 1, SaveName : "s_t_t_hr", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_t_t1", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_t_t2", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_t_t3", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_t_t4", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 75, Align : "Center", ColMerge : 1, SaveName : "s_s_time", KeyField : 0, CalcLogic : "|s_s_t1|+|s_s_t2|+|s_s_t3|", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 75, Align : "Center", ColMerge : 1, SaveName : "s_s_t_dy", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 75, Align : "Center", ColMerge : 1, SaveName : "s_s_t_hr", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_s_t1", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_s_t2", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_s_t3", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_ts_ind", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 70, Align : "Center", ColMerge : 1, SaveName : "s_f_u", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_pod1_etb", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_pol2_etb", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_pod2_etb", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_pol3_etb", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_pod3_etb", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_pol4_etb", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_lnk_cnt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_row_copy_flg", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "sDoubtFlg", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 20, Align : "Center", ColMerge : 1, SaveName : "s_dup_allow", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 }
				];
				InitColumns(cols);
				SetEditable(1);
				SetWaitImageVisible(0);
				SetColProperty(0, "s_t_t_dy", { Format : "##" });
				SetColProperty(0, "s_t_t_hr", { Format : "##" });
				InitComboNoMatchText(true);
				SetRangeBackColor(1, 4, 1, 27, "#555555");
				SetColProperty(0, "s_route_flg", { ComboText : "|Guide|Standard|Temporary|AddCall|Validation", ComboCode : "|G|S|T|A|V" });
				SetColProperty(0, "s_route_rmk", { ComboText : "|SpaceShortage|CustomerRequest|PortSkip|VSLPhaseOut|CustomsProblem|ClericalError|The Others", ComboCode : "|SpaceShortage|CustomerRequest|PortSkip|VSLPhaseOut|CustomsProblem|ClericalError|The Others" });
				ComResizeSheet(sheetObj);
			}
			break;
	}
}
// handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	var Row;
	if (!opener) {
		opener = parent;
	}
	openerFormObj = opener.document.form;
	ComOpenWait(true);
	switch (sAction) {
		case IBINSERT:
			var iRow = sheetObj.DataInsert();
			sheetObj.SetCellValue(iRow, "s_pol", openerFormObj.pol_port_cd.value, 0);
			sheetObj.SetCellValue(iRow, "s_pod", openerFormObj.pod_port_cd.value, 0);
			sheetObj.SetCellValue(iRow, "s_pol1", openerFormObj.pol_port_cd.value, 0);
			break;
		case IBCOPYROW:
			Row = sheetObj.DataCopy();
			sheetObj.SetCellValue(Row, "s_row_copy_flg", "Y", 0);
			break;
		case IBDELETE:
			Row = sheetObj.GetSelectRow();
			sheetObj.RowDelete(Row);
			break;
	}
	ComOpenWait(false);
}
// handling pop up open
function sheet1_OnPopupClick(sheetObj, row, col) {
	var oriLoc = "";
	var destLoc = "";
	var lane = "";
	var gubun = "";
	var idx = sheetObj.ColSaveName(col).substring(5);
	if (sheetObj.ColSaveName(col) == "s_pod" + idx) {
		gubun = idx;
		oriLoc = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "s_pol" + idx);
		destLoc = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "s_pod" + idx);
		lane = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "s_ts" + idx + "_lane");
	}
	myWin = window.open('ESD_PRD_0040.do' + '?ori_loc=' + oriLoc + '&dest_loc=' + destLoc + '&f_cmd=' + SEARCH + '&lane=' + lane + '&gubun=' + gubun + '&row=' + sheetObj.GetSelectRow() + '&col=' + sheetObj.GetSelectCol(), "compop", "status=1,width=" + 800 + ",height=" + 300
			+ ",resizable=yes,scrollbars=no,left=" + 100 + ",top=" + 100);
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
	}
	return true;
}
/** *************************************************************************** */
function changeSelect(gubun) {
	var frm = document.form;
	var val = ''
	if (gubun == 'T') {
		val = frm.select1[frm.select1.selectedIndex].value;
		frm.ts_type.value = (val == 0) ? "" : val;
	}
	if (gubun == 'S') {
		val = frm.select2[frm.select2.selectedIndex].value;
		frm.stay_time.value = (val == 0) ? "0" : val;
	}
}
var portInd = '';
function getCOM_ENS_051(rArray) {
	var cArray = rArray[0];
	var frm = document.form;
	if (portInd == 'ORGI') {
		frm.pol_cont_cd.value = cArray[5];
		frm.pol_cnty_cd.value = cArray[8];
		frm.pol_port_cd.value = '';
	}
	if (portInd == 'DEST') {
		frm.pod_cont_cd.value = cArray[5];
		frm.pod_cnty_cd.value = cArray[8];
		frm.pod_port_cd.value = ''
	}
	if (portInd == 'POL') {
		frm.pol_cont_cd.value = cArray[5];
		frm.pol_cnty_cd.value = cArray[8];
		frm.pol_port_cd.value = cArray[3];
	}
	if (portInd == 'POD') {
		frm.pod_cont_cd.value = cArray[5];
		frm.pod_cnty_cd.value = cArray[8];
		frm.pod_port_cd.value = cArray[3];
	}
}
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var ColName = sheetObj.ColSaveName(Col);
	// input
	var sPol = "";
	var sPod = "";
	var sLane = "";
	var sDir = "";
	// output
	var rowCnt = 0;
	sheetObj.SetEtcData("rowCnt", '');
	var polx = "";
	var podx = "";
	var lanex = "";
	var svc_tpx = "";
	var ttx = "";
	var dirx = "";
	var fdr_flgx = "";
	var polxetb = "";
	var podxetb = "";
	// index gubun
	var tsIdx = '';
	var next = 0;
	if (sheetObj.GetCellValue(Row, "s_route_flg") == "T" && sheetObj.GetCellValue(Row, "s_route_rmk") == "The Others") {
		sheetObj.SetCellEditable(Row, "s_route_note", 1);
	} else {
		sheetObj.SetCellEditable(Row, "s_route_note", 0);
	}
	if (sheetObj.ColSaveName(Col) == "s_route_flg" && Value == "T") {
		ComShowMessage(ComGetMsg('PRD90102'));
		sheetObj.SelectCell(Row, "s_route_rmk");
		sheetObj.SetCellValue(Row, "s_route_rmk", '', 0);
		sheetObj.SetCellValue(Row, "s_route_note", '', 0);
	} else if (sheetObj.ColSaveName(Col) == "s_route_flg" && Value != "T") {
		sheetObj.SetCellValue(Row, "s_route_rmk", '', 0);
		sheetObj.SetCellValue(Row, "s_route_note", '', 0);
	} else if (sheetObj.ColSaveName(Col) == "s_route_rmk" && Value != "The Others") {
		sheetObj.SetCellValue(Row, "s_route_note", '', 0);
	} else if (sheetObj.ColSaveName(Col) == "s_route_note" && Value != " ") {
		if (sheetObj.GetCellValue(Row, "s_route_rmk") != "The Others") {
			sheetObj.SetCellValue(Row, "s_route_note", '', 0);
		}
	}
	if (sheetObj.ColSaveName(Col) == "s_route_flg" && Value == "V") {
		ComShowMessage(ComGetMsg('PRD90104', 'Validation'));
		sheetObj.SetCellValue(Row, "s_route_flg", sheetObj.GetCellValue(Row, "s_upd_ind_cd"), 0);
		return;
	}
	// preventing to select on DROP BOX in case of 'S'
	var idx = sheetObj.GetComboInfo(Row, "s_route_rmk", "SelectedIndex");
	if ((sheetObj.GetCellValue(Row, "s_route_flg") != "T") && (sheetObj.ColSaveName(Col) == "s_route_rmk") && idx > 0) {
		sheetObj.SetCellValue(Row, "s_route_rmk", ' ', 0);
		ComShowMessage(ComGetMsg('PRD90103'));
	}
	if ((sheetObj.GetCellValue(Row, "s_route_flg") == "T") && (sheetObj.ColSaveName(Col) == "s_route_rmk") && idx < 1) {
		sheetObj.SelectCell(Row, "s_route_rmk");
		sheetObj.SetCellValue(Row, "s_route_rmk", '', 0);
		ComShowMessage(ComGetMsg('PRD90102'));
	}
	if (ColName == "s_pol1" || ColName == "s_pod1" || ColName == "s_ts1_lane" ||  ColName == "s_dir1" ) {
		tsIdx = '1';
		sPol = sheetObj.GetCellValue(Row, "s_pol1");
		sPod = sheetObj.GetCellValue(Row, "s_pod1");
		sLane = sheetObj.GetCellValue(Row, "s_ts1_lane");
		sDir = sheetObj.GetCellValue(Row, "s_dir1");
	} else if (ColName == "s_pol2" || ColName == "s_pod2" || ColName == "s_ts2_lane"  ||  ColName == "s_dir2" ) {
		tsIdx = '2';
		sPol = sheetObj.GetCellValue(Row, "s_pol2");
		sPod = sheetObj.GetCellValue(Row, "s_pod2");
		sLane = sheetObj.GetCellValue(Row, "s_ts2_lane");
		sDir = sheetObj.GetCellValue(Row, "s_dir2");
	} else if (ColName == "s_pol3" || ColName == "s_pod3" || ColName == "s_ts3_lane"  ||  ColName == "s_dir3" ) {
		tsIdx = '3';
		sPol = sheetObj.GetCellValue(Row, "s_pol3");
		sPod = sheetObj.GetCellValue(Row, "s_pod3");
		sLane = sheetObj.GetCellValue(Row, "s_ts3_lane");
		sDir = sheetObj.GetCellValue(Row, "s_dir3");
	} else if (ColName == "s_pol4" || ColName == "s_pod4" || ColName == "s_ts4_lane"  ||  ColName == "s_dir4" ) {
		tsIdx = '4';
		sPol = sheetObj.GetCellValue(Row, "s_pol4");
		sPod = sheetObj.GetCellValue(Row, "s_pod4");
		sLane = sheetObj.GetCellValue(Row, "s_ts4_lane");
		sDir = sheetObj.GetCellValue(Row, "s_dir4");
	}
	next = ComParseInt(tsIdx) + 1;
	if (sPol == "" && sPod == "" && sLane == "" && sDir == "") {
		return;
	}
	var rowCnt = 0;
	if (sPod.length == 5) {
		ComOpenWait(true);
		sheetObj.DoSearch("ESD_PRD_0035GS.do", "f_cmd=" + SEARCH11 + "&ori_loc=" + sPol + "&dest_loc=" + sPod + "&lane=" + sLane + "&dir=" + sDir + "&row=" + Row + "&col=" + Col, { Sync : 2, Append : 1 });
		rowCnt = sheetObj.GetEtcData("rowCnt");
		ComOpenWait(false);
		if (tsIdx == '4' && sPod != sheetObj.GetCellValue(sheetObj.GetSelectRow(), "s_pod")) {
			ComShowMessage(ComGetMsg('PRD90012'));
			return;
		}
	}
	if (rowCnt != 1) {
		polx = sPol;
		podx = sPod;
		lanex = sLane;
		svc_tpx = '';
		ttx = '';
		dirx = '';
		fdr_flgx = '';
		polxetb = '';
		podxetb = '';
	} else {
		polx = sheetObj.GetEtcData("polx");
		podx = sheetObj.GetEtcData("podx");
		lanex = sheetObj.GetEtcData("lanex");
		svc_tpx = sheetObj.GetEtcData("svc_tpx");
		ttx = sheetObj.GetEtcData("ttx");
		dirx = sheetObj.GetEtcData("dirx");
		fdr_flgx = sheetObj.GetEtcData("fdr_flgx");
		polxetb = sheetObj.GetEtcData("polxetb");
		podxetb = sheetObj.GetEtcData("podxetb");
	}

	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "s_ts" + tsIdx + "_lane", lanex, 0);
	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "s_pod" + tsIdx, podx, 0);
	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "s_ts" + tsIdx + "_type", svc_tpx, 0);
	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "s_t_t" + tsIdx, ttx, 0);
//	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "s_dir" + tsIdx, dirx, 0);
	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "s_fdr_flg" + tsIdx, fdr_flgx, 0);
	if (tsIdx == '1') {
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "s_pod" + tsIdx + "_etb", podxetb, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "s_f_u", 'N', 0);
	} else if (tsIdx == '2' || tsIdx == '3') {
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "s_pol" + tsIdx, polx, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "s_pol" + tsIdx + "_etb", polxetb, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "s_pod" + tsIdx + "_etb", podxetb, 0);
	} else if (tsIdx == '4') {
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "s_pol" + tsIdx, polx, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "s_pol" + tsIdx + "_etb", polxetb, 0);
	}
	if ((tsIdx == '1' || tsIdx == '2' || tsIdx == '3') && podx != sheetObj.GetCellValue(sheetObj.GetSelectRow(), "s_pod")) {
		if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "s_ts" + tsIdx + "_lane") == "" || sheetObj.GetCellValue(sheetObj.GetSelectRow(), "s_ts" + tsIdx + "_type") == "") {
			if (podx != sheetObj.GetCellValue(sheetObj.GetSelectRow(), "s_pol" + next)) {
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "s_pol" + next, "", 0);
			}
			return;
		}
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "s_pol" + next, podx, 0);
	}
	// calculating ST when tsIdx is 2,3,4, if data is changed after 'ROW COPY'-> recalculate
	if (tsIdx == '2' || tsIdx == '3' || tsIdx == '4') {
		// getting podEtb which is tsIdx-1
		var podEtb = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "s_pod" + (tsIdx - 1) + "_etb");
		var podEtbNum = 0;
		if (podEtb != '') {
			podEtbNum = ((podEtb == 'SUN') ? 7 : ((podEtb == 'MON') ? 6 : ((podEtb == 'TUE') ? 5 : ((podEtb == 'WED') ? 4 : ((podEtb == 'THU') ? 3 : ((podEtb == 'FRI') ? 2 : ((podEtb == 'SAT') ? 1 : 0)))))))
		}
		var polEtb = polxetb;
		var polEtbNum = 0;
		if (polEtb != '') {
			polEtbNum = ((polEtb == 'SUN') ? 7 : ((polEtb == 'MON') ? 6 : ((polEtb == 'TUE') ? 5 : ((polEtb == 'WED') ? 4 : ((polEtb == 'THU') ? 3 : ((polEtb == 'FRI') ? 2 : ((polEtb == 'SAT') ? 1 : 0)))))))
		}
		var calEtb = podEtbNum - polEtbNum;
		var st = ((calEtb == -1) ? 7 : ((calEtb == -2) ? 6 : ((calEtb == -3) ? 5 : ((calEtb == -4) ? 4 : ((calEtb == -5) ? 3 : ((calEtb == -6) ? 2 : ((calEtb == 0) ? 1 : ((calEtb == 1) ? 1 : ((calEtb == 2) ? 3 : ((calEtb == 3) ? 4
				: ((calEtb == 4) ? 5 : ((calEtb == 5) ? 6 : ((calEtb == 6) ? 7 : 0))))))))))))) * 24;
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "s_s_t" + (tsIdx - 1), st, 0);
	}
}
/*
 * getting how many links are there 0 -> there is invalid link
 */
function getLinkCnt(sheetObj, insertRow) {
	var findPodIdx = 0;
	// -----------------
	// checking if there are all information of link
	for (index = 1; index < 5; index++) {
		if (sheetObj.GetCellValue(insertRow, "s_pol" + index) != "" && sheetObj.GetCellValue(insertRow, "s_ts" + index + "_lane") != "" && sheetObj.GetCellValue(insertRow, "s_ts" + index + "_type") != "" && sheetObj.GetCellValue(insertRow, "s_pod" + index) != "") {
			findPodIdx++;
		}
	}
	return findPodIdx;
}
// checking before save
function chkRoute(sheetObj) {
	if (sheetObj.CheckedRows("s_chk") > 0) {
		var checkedRow = sheetObj.FindCheckedRow("s_chk");
		var arrRow = checkedRow.split("|");
		var findPodIdx = 0;

		for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
			var insertRow = i;
			// lane,type should be exists when value of pol1 OR pod1 is exists
			// pol2 shouldn't be exist when pod1 and pod are same
			if (sheetObj.GetCellValue(insertRow, "s_pol1") != "" || sheetObj.GetCellValue(insertRow, "s_pod1") != "") {
				if (sheetObj.GetCellValue(insertRow, "s_ts1_lane") == "" || sheetObj.GetCellValue(insertRow, "s_ts1_type") == "" || sheetObj.GetCellValue(insertRow, "s_dir1") == "") {
					return false;
				}
			}
			if (sheetObj.GetCellValue(insertRow, "s_pol1") != "" && sheetObj.GetCellValue(insertRow, "s_pod1") == sheetObj.GetCellValue(insertRow, "s_pod")) {
				if (sheetObj.GetCellValue(insertRow, "s_pol2") != "") {
					return false;
				}
				findPodIdx = 1;
			}
			// ---------------
			if (sheetObj.GetCellValue(insertRow, "s_pol2") != "" || sheetObj.GetCellValue(insertRow, "s_pod2") != "") {
				if (sheetObj.GetCellValue(insertRow, "s_ts2_lane") == "" || sheetObj.GetCellValue(insertRow, "s_ts2_type") == "" || sheetObj.GetCellValue(insertRow, "s_dir2") == "" ) {
					return false;
				}
			}
			if (sheetObj.GetCellValue(insertRow, "s_pol2") != "" && sheetObj.GetCellValue(insertRow, "s_pod2") == sheetObj.GetCellValue(insertRow, "s_pod")) {
				if (sheetObj.GetCellValue(insertRow, "s_pol3") != "") {
					return false;
				}
				findPodIdx = 2;
			}
			// -----------------
			if (sheetObj.GetCellValue(insertRow, "s_pol3") != "" || sheetObj.GetCellValue(insertRow, "s_pod3") != "") {
				if (sheetObj.GetCellValue(insertRow, "s_ts3_lane") == "" || sheetObj.GetCellValue(insertRow, "s_ts3_type") == "" || sheetObj.GetCellValue(insertRow, "s_dir3") == "" ) {
					return false;
				}
			}
			if (sheetObj.GetCellValue(insertRow, "s_pol3") != "" && sheetObj.GetCellValue(insertRow, "s_pod3") == sheetObj.GetCellValue(insertRow, "s_pod")) {
				if (sheetObj.GetCellValue(insertRow, "s_pol4") != "") {
					return false;
				}
				findPodIdx = 3;
			}
			// -----------------
			if (sheetObj.GetCellValue(insertRow, "s_pol4") != "" || sheetObj.GetCellValue(insertRow, "s_pod4") != "") {
				if (sheetObj.GetCellValue(insertRow, "s_ts4_lane") == "" || sheetObj.GetCellValue(insertRow, "s_ts4_type") == "" || sheetObj.GetCellValue(insertRow, "s_dir4") == "") {
					return false;
				}
			}
			// FALSE when last pod4 and POD are different
			if (sheetObj.GetCellValue(insertRow, "s_pol4") != "" && sheetObj.GetCellValue(insertRow, "s_pod4") != sheetObj.GetCellValue(insertRow, "s_pod")) {
				return false;
			} else {
				findPodIdx = 4;
			}
			// -----------------
			// data after findPodIdx must not exist
			//    
			for ( var index = (1 + findPodIdx); index < 5; index++) {
				if (sheetObj.GetCellValue(insertRow, "s_pol" + index) != "") {
					return false;
				}
				if (sheetObj.GetCellValue(insertRow, "s_ts" + index + "_lane") != "") {
					return false;
				}
				if (sheetObj.GetCellValue(insertRow, "s_ts" + index + "_lane") != "") {
					return false;
				}
				if (sheetObj.GetCellValue(insertRow, "s_dir" + index) != "") {
					return false;
				}
				if (sheetObj.GetCellValue(insertRow, "s_pod" + index) != "") {
					return false;
				}
			}
		}
		return true;
	}
}

function doSetValue(sheetObj, formObj) {
	var openerSheet = opener.sheet1;
	var fmtStr = '';
	if (sheetObj.CheckedRows("s_chk") == 0) {
		ComShowMessage(ComGetMsg('PRD90106'));
		return;
	}
	// OCN_FLAG INPUT CHK
	if (!ocnFlagChk(sheetObj)) {
		ComShowCodeMessage('PRD90100');
		return;
	}
	if (!chkTempRmk(sheetObj)) {
		ComShowCodeMessage('PRD90107');
		return;
	}
	if (!chkRoute(sheetObj)) {
		ComShowCodeMessage('PRD90026');
		return;
	}
	if (!otherFlagChk(sheetObj)) {
		ComShowCodeMessage('PRD90124');
		return;
	}
	if (sheetObj.CheckedRows("s_chk") > 0) {
		var checkedRow = sheetObj.FindCheckedRow("s_chk");
		var arrRow = checkedRow.split("|");
		var endIdx = sheetObj.LastRow();
		for (var idx = sheetObj.HeaderRows(); idx < endIdx + 1; idx++) {
			if(false) {
				if (sheetObj.GetCellValue(idx, "s_chk") == 1) {
					var param = "";
						param += "f_cmd=" + SEARCH11;
						param += "&org_loc_cd=" + sheetObj.GetCellValue(idx, "s_pol");
						param += "&dest_loc_cd=" + sheetObj.GetCellValue(idx, "s_pod");
						param += "&n1st_pol_cd=" + sheetObj.GetCellValue(idx, "s_pol1");
						param += "&n1st_pod_cd=" + sheetObj.GetCellValue(idx, "s_pod1");
						param += "&n1st_lane_cd=" + sheetObj.GetCellValue(idx, "s_ts1_lane");
						param += "&n1st_skd_dir_cd=" + sheetObj.GetCellValue(idx, "s_dir1");
						param += "&n2nd_pol_cd=" + sheetObj.GetCellValue(idx, "s_pol2");
						param += "&n2nd_pod_cd=" + sheetObj.GetCellValue(idx, "s_pod2");
						param += "&n2nd_lane_cd=" + sheetObj.GetCellValue(idx, "s_ts2_lane");
						param += "&n2nd_skd_dir_cd=" + sheetObj.GetCellValue(idx, "s_dir2");
						param += "&n3rd_pol_cd=" + sheetObj.GetCellValue(idx, "s_pol3");
						param += "&n3rd_pod_cd=" + sheetObj.GetCellValue(idx, "s_pod3");
						param += "&n3rd_lane_cd=" + sheetObj.GetCellValue(idx, "s_ts3_lane");
						param += "&n3rd_skd_dir_cd=" + sheetObj.GetCellValue(idx, "s_dir3");
						param += "&n4th_pol_cd=" + sheetObj.GetCellValue(idx, "s_pol4");
						param += "&n4th_pod_cd=" + sheetObj.GetCellValue(idx, "s_pod4");
						param += "&n4th_lane_cd=" + sheetObj.GetCellValue(idx, "s_ts4_lane");
						param += "&n4th_skd_dir_cd=" + sheetObj.GetCellValue(idx, "s_dir4");
						param += "&row=" + idx + "&col=" + sheetObj.SaveNameCol("s_chk");
						
					sheetObj.DoRowSearch(idx, "ESD_PRD_0032_ROW_GS.do", param, { Sync : 2 });
					if (sheetObj.GetEtcData("rowCount") == 0) {
						sheetObj.SetCellValue(idx, "sDoubtFlg", "", 0);
						sheetObj.SetCellValue(idx, "s_dup_allow", "", 0);
					}
				}
				sheetObj.RemoveEtcData();
				if (sheetObj.GetCellValue(idx, "sDoubtFlg") == "Y") {
					if (!CONFIRM(ComGetMsg('PRD90053'))) {
						// continue;
					} else {
						sheetObj.SetCellValue(idx, "s_dup_allow", "Y", 0);
					}
				}
			}
			sheetObj.SetCellValue(idx, "sDoubtFlg", "", 0);
			sheetObj.SetCellValue(idx, "s_dup_allow", "", 0);
			
			// preventing to modify
			var insertRow = idx;
			if (sheetObj.GetCellValue(insertRow, "s_chk") == 1) {
				// setting sLnkCnt
				var sLnkCnt = getLinkCnt(sheetObj, insertRow);
				sheetObj.SetCellValue(insertRow, "s_lnk_cnt", sLnkCnt, 0);
				if (sLnkCnt == 1) {
					sheetObj.SetCellValue(insertRow, "s_ts_ind", 'D', 0);
				} else if (sLnkCnt > 1) {
					sheetObj.SetCellValue(insertRow, "s_ts_ind", 'T', 0);
				} else {
					ComShowMessage(ComGetMsg('PRD90105'));
					return;
				}
				var iRow = openerSheet.DataInsert(-1);
				openerSheet.SetRowEditable(iRow, 0);
				openerSheet.SetCellValue(iRow, "s_seq", "", 0);
				openerSheet.SetCellValue(iRow, "s_del", 0);
				openerSheet.SetCellValue(iRow, "ibflag", "I");
				openerSheet.SetCellValue(iRow, "s_pol", 	sheetObj.GetCellValue(insertRow, "s_pol"), 0);
				openerSheet.SetCellValue(iRow, "s_lane", 	sheetObj.GetCellValue(insertRow, "s_ts1_lane"), 0);
				openerSheet.SetCellValue(iRow, "s_dir", 	sheetObj.GetCellValue(insertRow, "s_dir1"), 0);
				openerSheet.SetCellValue(iRow, "s_svc_type", sheetObj.GetCellValue(insertRow, "s_ts1_type"), 0);
				openerSheet.SetCellValue(iRow, "s_ts1_port", sheetObj.GetCellValue(insertRow, "s_pol2"), 0);
				openerSheet.SetCellValue(iRow, "s_ts1_lane", sheetObj.GetCellValue(insertRow, "s_ts2_lane"), 0);
				openerSheet.SetCellValue(iRow, "s_ts1_dir",  sheetObj.GetCellValue(insertRow, "s_dir2"), 0);
				openerSheet.SetCellValue(iRow, "s_ts1_type", sheetObj.GetCellValue(insertRow, "s_ts2_type"), 0);
				openerSheet.SetCellValue(iRow, "s_ts2_port", sheetObj.GetCellValue(insertRow, "s_pol3"), 0);
				openerSheet.SetCellValue(iRow, "s_ts2_lane", sheetObj.GetCellValue(insertRow, "s_ts3_lane"), 0);
				openerSheet.SetCellValue(iRow, "s_ts2_dir",  sheetObj.GetCellValue(insertRow, "s_dir3"), 0);
				openerSheet.SetCellValue(iRow, "s_ts2_type", sheetObj.GetCellValue(insertRow, "s_ts3_type"), 0);
				openerSheet.SetCellValue(iRow, "s_ts3_port", sheetObj.GetCellValue(insertRow, "s_pol4"), 0);
				openerSheet.SetCellValue(iRow, "s_ts3_lane", sheetObj.GetCellValue(insertRow, "s_ts4_lane"), 0);
				openerSheet.SetCellValue(iRow, "s_ts3_dir", sheetObj.GetCellValue(insertRow, "s_dir4"), 0);
				openerSheet.SetCellValue(iRow, "s_ts3_type", sheetObj.GetCellValue(insertRow, "s_ts4_type"), 0);
				openerSheet.SetCellValue(iRow, "s_pod", sheetObj.GetCellValue(insertRow, "s_pod"), 0);
				fmtStr = ComLpad(sheetObj.GetCellValue(insertRow, "s_t_t_dy"), 2, 0) + ComLpad(sheetObj.GetCellValue(insertRow, "s_t_t_hr"), 2, 0);
				openerSheet.SetCellValue(iRow, "s_fmt_t_time", fmtStr, 0);
				fmtStr = ComLpad(sheetObj.GetCellValue(insertRow, "s_s_t_dy"), 2, 0) + ComLpad(sheetObj.GetCellValue(insertRow, "s_s_t_hr"), 2, 0);
				openerSheet.SetCellValue(iRow, "s_fmt_s_time", fmtStr, 0);
				openerSheet.SetCellValue(iRow, "s_route_flg", sheetObj.GetCellValue(insertRow, "s_route_flg"), 0);
				// openerSheet.CellValue2( iRow, "s_prior" ) = sheetObj.CellValue( insertRow , "s_prior");
				// PRIORITY AUTO RANKING -> DEFAULT 5 (temporary value)
				openerSheet.SetCellValue(iRow, "s_prior", '5', 0);
				openerSheet.SetCellValue(iRow, "s_f_u", sheetObj.GetCellValue(insertRow, "s_f_u"), 0);
				openerSheet.SetCellValue(iRow, "s_t_time", sheetObj.GetCellValue(insertRow, "s_t_time"), 0);
				openerSheet.SetCellValue(iRow, "s_s_time", sheetObj.GetCellValue(insertRow, "s_s_time"), 0);
				openerSheet.SetCellValue(iRow, "s_pol1", sheetObj.GetCellValue(insertRow, "s_pol1"), 0);
				openerSheet.SetCellValue(iRow, "s_pod1", sheetObj.GetCellValue(insertRow, "s_pod1"), 0);
				openerSheet.SetCellValue(iRow, "s_dir1", sheetObj.GetCellValue(insertRow, "s_dir1"), 0);
				openerSheet.SetCellValue(iRow, "s_fdr_flg1", sheetObj.GetCellValue(insertRow, "s_fdr_flg1"), 0);
				openerSheet.SetCellValue(iRow, "s_pol2", sheetObj.GetCellValue(insertRow, "s_pol2"), 0);
				openerSheet.SetCellValue(iRow, "s_pod2", sheetObj.GetCellValue(insertRow, "s_pod2"), 0);
				openerSheet.SetCellValue(iRow, "s_dir2", sheetObj.GetCellValue(insertRow, "s_dir2"), 0);
				openerSheet.SetCellValue(iRow, "s_fdr_flg2", sheetObj.GetCellValue(insertRow, "s_fdr_flg2"), 0);
				openerSheet.SetCellValue(iRow, "s_pol3", sheetObj.GetCellValue(insertRow, "s_pol3"), 0);
				openerSheet.SetCellValue(iRow, "s_pod3", sheetObj.GetCellValue(insertRow, "s_pod3"), 0);
				openerSheet.SetCellValue(iRow, "s_dir3", sheetObj.GetCellValue(insertRow, "s_dir3"), 0);
				openerSheet.SetCellValue(iRow, "s_fdr_flg3", sheetObj.GetCellValue(insertRow, "s_fdr_flg3"), 0);
				openerSheet.SetCellValue(iRow, "s_pol4", sheetObj.GetCellValue(insertRow, "s_pol4"), 0);
				openerSheet.SetCellValue(iRow, "s_pod4", sheetObj.GetCellValue(insertRow, "s_pod4"), 0);
				openerSheet.SetCellValue(iRow, "s_dir4", sheetObj.GetCellValue(insertRow, "s_dir4"), 0);
				openerSheet.SetCellValue(iRow, "s_fdr_flg4", sheetObj.GetCellValue(insertRow, "s_fdr_flg4"), 0);
				openerSheet.SetCellValue(iRow, "s_route_rmk", sheetObj.GetCellValue(insertRow, "s_route_rmk"), 0);// aaaaaaa
				openerSheet.SetCellValue(iRow, "s_route_note", sheetObj.GetCellValue(insertRow, "s_route_note"), 0);// aaaaaaa
				openerSheet.SetCellValue(iRow, "s_n1st_tztm_hrs", sheetObj.GetCellValue(insertRow, "s_t_t1"), 0);// aaaaaaa
				openerSheet.SetCellValue(iRow, "s_n2nd_tztm_hrs", sheetObj.GetCellValue(insertRow, "s_t_t2"), 0);// aaaaaaa
				openerSheet.SetCellValue(iRow, "s_n3rd_tztm_hrs", sheetObj.GetCellValue(insertRow, "s_t_t3"), 0);// aaaaaaa
				openerSheet.SetCellValue(iRow, "s_n4th_tztm_hrs", sheetObj.GetCellValue(insertRow, "s_t_t4"), 0);// aaaaaaa
				openerSheet.SetCellValue(iRow, "s_n1st_stay_tm_hrs", sheetObj.GetCellValue(insertRow, "s_s_t1"), 0);// aaaaaaa
				openerSheet.SetCellValue(iRow, "s_n2nd_stay_tm_hrs", sheetObj.GetCellValue(insertRow, "s_s_t2"), 0);// aaaaaaa
				openerSheet.SetCellValue(iRow, "s_n3rd_stay_tm_hrs", sheetObj.GetCellValue(insertRow, "s_s_t3"), 0);// aaaaaaa
				openerSheet.SetCellValue(iRow, "s_ts_ind_cd", sheetObj.GetCellValue(insertRow, "s_ts_ind"), 0);// aaaaaaa
				openerSheet.SetCellValue(iRow, "s_pod1_etb", sheetObj.GetCellValue(insertRow, "s_pod1_etb"), 0);// aaaaaaa
				openerSheet.SetCellValue(iRow, "s_pol2_etb", sheetObj.GetCellValue(insertRow, "s_pol2_etb"), 0);// aaaaaaa
				openerSheet.SetCellValue(iRow, "s_pod2_etb", sheetObj.GetCellValue(insertRow, "s_pod2_etb"), 0);// aaaaaaa
				openerSheet.SetCellValue(iRow, "s_pol3_etb", sheetObj.GetCellValue(insertRow, "s_pol3_etb"), 0);// aaaaaaa
				openerSheet.SetCellValue(iRow, "s_pod3_etb", sheetObj.GetCellValue(insertRow, "s_pod3_etb"), 0);// aaaaaaa
				openerSheet.SetCellValue(iRow, "s_pol4_etb", sheetObj.GetCellValue(insertRow, "s_pol4_etb"), 0);// aaaaaaa
				openerSheet.SetCellValue(iRow, "s_lnk_cnt", sheetObj.GetCellValue(insertRow, "s_lnk_cnt"), 0);// aaaaaaa
				openerSheet.SetCellValue(iRow, "s_dup_allow", sheetObj.GetCellValue(insertRow, "s_dup_allow"), 0);
			}
		}// FOR
		opener.ocnRoutSave();
	}// IF
}

function chkPriority(sheetObj) {
	if (sheetObj.CheckedRows("s_chk") > 0) {
		var checkedRow = sheetObj.FindCheckedRow("s_chk");
		var arrRow = checkedRow.split("|");

		for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
			// Priority Check
			if (sheetObj.GetCellValue(i, "s_prior") == "") {
				return false;
			}
		}
		return true;
	}
}

function ocnFlagChk(sheetObj) {
	if (sheetObj.CheckedRows("s_chk") > 0) {

		for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
			if (sheetObj.GetCellValue(i, "s_route_flg") == "") {
				return false;
			}
		}
		return true;
	}
}

function chkTempRmk(sheetObj) {
	if (sheetObj.CheckedRows("s_chk") > 0) {
		var checkedRow = sheetObj.FindCheckedRow("s_chk");

		for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
			// tempflg Check
			if (sheetObj.GetCellValue(i, "s_route_flg") == "T") {
				if (sheetObj.GetComboInfo(i, "s_route_rmk", "SelectedIndex") == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
/**
 * checking before clicking OK button - show message when the value of Note is null selected in the row that Type is "The Other"
 * 
 * @return
 */
function otherFlagChk(sheetObj) {
	for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
		if ((sheetObj.GetCellValue(i, "s_route_rmk") == "The Others") && (ComTrim(sheetObj.GetCellValue(i, "s_route_note")) == "")) {
			return false;
		}
		return true;
	}
}

function CONFIRM(msg1) {
	msg1 = "\n" + "────────────────────────────────     \n\n" + "\n" + "" + msg1 + "\n" + "\n" + "\n────────────────────────────────     \n" + "If you click 'Cancel' button, this route can't be created.";
	return confirm(msg1);
}
