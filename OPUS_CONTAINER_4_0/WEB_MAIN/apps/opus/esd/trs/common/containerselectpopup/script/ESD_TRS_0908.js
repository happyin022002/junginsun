/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESD_TRS_0908.js
 *@FileTitle : Empty Repo & S/T On/Off Hire S/O Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESD_TRS_0908 : business script for ESD_TRS_0908
 */

var sheetObjects = new Array();
var sheetCnt = 0;
var sheetObjSingle;
var preSelectRow = 0;
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[2], document.form, 'IBSEARCH04');
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
		with(sheetObj) {
			var HeadTitle0="|BKG No|TRO\nSEQ|S/O No|W/O No|S/O\nTP/SZ|Original\nBKG No|Revised\nTRO SEQ";
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle0, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [ {Type:"Radio",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"tro_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"trsp_so_ofc_cty_cd_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"trsp_wo_ofc_cty_cd_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_bkg_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_tro_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsp_so_ofc_cty_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsp_so_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsp_wo_ofc_cty_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsp_wo_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Status",    Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } 
			           ];
	
			InitColumns(cols);
			SetEditable(1);
			SetSheetHeight(ComGetSheetHeight(sheetObj, 7));
		}
		break;
	case 2:
		with(sheetObj){
			var HeadTitle0="|BKG No|BKG STS|CNTR No|TP/SZ|Applied S/O No|Duplication Check";
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle0, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [ {Type:"Radio",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"apply_so_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dup_check",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Status",    Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Seq",       Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibseq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"org_apply_so_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } 
			           ];
	
			InitColumns(cols);
			SetEditable(1);
//			SetSheetHeight(ComGetSheetHeight(sheetObj, 7));
			ComResizeSheet(sheetObj);
		}
		break;
	case 3:
		with(sheetObj){
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:"", Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [ {Type:"Status",    Hidden:0, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"ibflag",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"prov_cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	
			InitColumns(cols);
			SetEditable(0);
			SetVisible(false);		
		}
		break;
	case 4:
		with(sheetObj){
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:"", Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [ {Type:"Status",    Hidden:0, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"ibflag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:100,    Align:"Center",  ColMerge:1,   SaveName:"bkg_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	
			InitColumns(cols);
			SetSheetHeight(250);
			SetEditable(0);
			SetVisible(false);		
		}
		break;
	}
}

document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_close":
				ComClosePopup();
				break;
			case "btn_apply":
				doActionIBSheet(sheetObjects[1], formObject, 'IBSEARCH03');
				break;
		} 
	} catch (e) {
		if (e == "[object Error]") {
			errMsg = ComGetMsg("COM12111");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e.message);
		}
	}
}

/*
 * handling of Sheet
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	var openerMainSheet = opener.sheetObjects[formObj.mainSheetArrayNo.value];
	switch (sAction) {
		case IBSEARCH: {
			formObj.f_cmd.value = SEARCH01;
			var checkList = openerMainSheet.FindCheckedRow('chk1');
			var checkArray = checkList.split('|');
			var queryStr = '';
			for ( var i = 0; i < checkArray.length; i++) {
				queryStr += '&ibflag=R';
				queryStr += '&bkg_no=' + openerMainSheet.GetCellValue(checkArray[i], 'bkg_no');
				queryStr += '&trsp_so_ofc_cty_cd=' + openerMainSheet.GetCellValue(checkArray[i], 'trsp_so_ofc_cty_cd');
				queryStr += '&trsp_so_seq=' + openerMainSheet.GetCellValue(checkArray[i], 'trsp_so_seq');
			}
			sheetObj.DoSearch("ESD_TRS_0908GS.do", TrsFrmQryString(formObj) + "&" + queryStr, { Sync : 2, Append : false });
			break;
		}
		case 'IBSEARCH02': {
			formObj.f_cmd.value = SEARCH02;
			var mainSheetObj = sheetObjects[0];
			var query = mainSheetObj.GetSaveString(true, true);
			sheetObj.DoSearch("ESD_TRS_0908GS.do", TrsFrmQryString(formObj) + "&" + query, { Sync : 2, Append : false });
			break;
		}
		case 'IBSEARCH03':
			formObj.f_cmd.value = SEARCH03;
			var query = '';
			var openMainQuery = '';
			var prefix = 'main_';
			openMainQuery += '&prefix=' + prefix;
			openMainQuery += '&mode=duplicate_check';
			for ( var i = openerMainSheet.HeaderRows(); i < openerMainSheet.RowCount() + openerMainSheet.HeaderRows(); i++) {
				if (openerMainSheet.GetCellValue(i, 'trsp_bnd_cd') == 'O' && (openerMainSheet.GetCellValue(i, 'trsp_cost_dtl_mod_cd') == 'DR' || openerMainSheet.GetCellValue(i, 'trsp_cost_dtl_mod_cd') == 'DOOR')) {
					openMainQuery += '&' + prefix + 'ibflag=S';
					openMainQuery += '&' + prefix + 'bkg_no=' + openerMainSheet.GetCellValue(i, 'bkg_no');
					openMainQuery += '&' + prefix + 'eq_no=' + openerMainSheet.GetCellValue(i, 'eq_no');
					openMainQuery += '&' + prefix + 'trsp_so_ofc_cty_cd=' + openerMainSheet.GetCellValue(i, 'trsp_so_ofc_cty_cd');
					openMainQuery += '&' + prefix + 'trsp_so_seq=' + openerMainSheet.GetCellValue(i, 'trsp_so_seq');
				}
			}
			var openerSecondSheet = opener.sheetObjects[1];
			for ( var i = openerSecondSheet.HeaderRows(); i < openerSecondSheet.RowCount() + openerSecondSheet.HeaderRows(); i++) {
				if (openerSecondSheet.GetCellValue(i, 'trsp_bnd_cd') == 'O' && (openerSecondSheet.GetCellValue(i, 'trsp_cost_dtl_mod_cd') == 'DR' || openerSecondSheet.GetCellValue(i, 'trsp_cost_dtl_mod_cd') == 'DOOR') && openerSecondSheet.GetCellValue(i, 'eq_no') != '') {
					openMainQuery += '&' + prefix + 'ibflag=S';
					openMainQuery += '&' + prefix + 'bkg_no=' + openerSecondSheet.GetCellValue(i, 'bkg_no');
					openMainQuery += '&' + prefix + 'eq_no=' + openerSecondSheet.GetCellValue(i, 'eq_no');
					openMainQuery += '&' + prefix + 'trsp_so_ofc_cty_cd=' + openerSecondSheet.GetCellValue(i, 'trsp_so_ofc_cty_cd');
					openMainQuery += '&' + prefix + 'trsp_so_seq=' + openerSecondSheet.GetCellValue(i, 'trsp_so_seq');
				}
			}
			for ( var i = sheetObj.HeaderRows(); i <= sheetObj.RowCount() + sheetObj.HeaderRows(); i++) {
				sheetObj.SetCellValue(i, 'dup_check', '', 0);
				if (sheetObj.GetCellValue(i, 'org_apply_so_seq') != '') {
					continue;
				} else if (sheetObj.GetCellValue(i, 'apply_so_seq') != '') {
					query = "";
					query += '&ibflag=S'
					query += '&bkg_no=' + sheetObj.GetCellValue(i, 'bkg_no');
					query += '&eq_no=' + sheetObj.GetCellValue(i, 'eq_no');
					query += '&por_cd=' + i;
					formObj.f_cmd.value = SEARCH04;
					sheetObj.DoRowSearch(i, "ESD_TRS_0968.screen", TrsFrmQryString(formObj) + "&" + query + "&" + openMainQuery, { Sync : 2 });
				}
			}
			break;
		case 'IBSEARCH04':
			formObj.f_cmd.value = SEARCH03;
			sheetObj.DoSearch("ESD_TRS_0908GS.do", TrsFrmQryString(formObj), { Sync : 2, Append : false });
			break;
	}
}

function sheet1_OnChange(sheetObj, row, col, value) {
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(col);
	switch (colName) {
		case 'ibcheck': {
			var bkg_no = sheetObj.GetCellValue(row, 'bkg_no');
			var org_bkg_no = sheetObj.GetCellValue(row, 'org_bkg_no');
			var eq_tpsz_cd = sheetObj.GetCellValue(row, 'eq_tpsz_cd');
			formObject.f_cmd.value = SEARCH04;
			sheetObjects[3].DoSearch("ESD_TRS_0908GS.do", TrsFrmQryString(formObject) + "&" + 'orgBkgNo=' + org_bkg_no + '&bkgNo=' + bkg_no, { Sync : 2 });
			changeBkgNo(sheetObjects[1], bkg_no, org_bkg_no, eq_tpsz_cd);
			break;
		}
	}
}

function sheet2_OnClick(sheetObj, row, col, value) {
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(col);
	var mainSheet = sheetObjects[0];
	switch (colName) {
		case 'ibcheck': {
			if (sheetObj.GetRowEditable(row)) {
				var checkList = mainSheet.FindCheckedRow('ibcheck');
				var checkArray = checkList.split('|');
				var selectedMainRow = checkArray[0];
				var selected_bkg_no = mainSheet.GetCellValue(selectedMainRow, 'bkg_no');
				var selected_org_bkg_no = mainSheet.GetCellValue(selectedMainRow, 'org_bkg_no');
				var selected_so_no = mainSheet.GetCellValue(selectedMainRow, 'trsp_so_ofc_cty_cd_seq');
				for ( var i = sheetObj.HeaderRows(); i < sheetObj.RowCount() + sheetObj.HeaderRows(); i++) {
					if (sheetObj.GetCellValue(i, 'org_apply_so_seq') != '') {
						continue;
					} else if (isAppliableBkgNo(sheetObj.GetCellValue(i, 'bkg_no')) && i == row) {
						sheetObj.SetCellValue(i, 'apply_so_seq', selected_so_no, 0);
					} else if (isAppliableBkgNo(sheetObj.GetCellValue(i, 'bkg_no')) && sheetObj.GetCellValue(i, 'apply_so_seq') == selected_so_no && i != row) {
						sheetObj.SetCellValue(i, 'apply_so_seq', '', 0);
					}
				}
				break;
			}
		}
	}
}

/**
 * sheet1_OnSearchEnd
 */
function sheet1_OnSearchEnd(sheetObj, errCode, errMsg) {
	var formObj = document.form;
	if (errMsg != null && errMsg != '') {
		ComShowMessage(errMsg);
	} else {
		if (formObj.f_cmd.value == SEARCH01) {
			var checkList = sheetObj.FindCheckedRow('ibcheck');
			if (checkList == '') {
				sheetObj.SetCellValue(1, 'ibcheck', '1', 0);
			}
			var bkg_no = sheetObj.GetCellValue(1, 'bkg_no');
			var org_bkg_no = sheetObj.GetCellValue(1, 'org_bkg_no');
			formObj.f_cmd.value = SEARCH04;
			sheetObjects[3].DoSearch("ESD_TRS_0908GS.do", TrsFrmQryString(formObj) + "&" + 'orgBkgNo=' + org_bkg_no + '&bkgNo=' + bkg_no, { Sync : 2, Append : false });
			doActionIBSheet(sheetObjects[1], formObj, 'IBSEARCH02');
		}
	}
}

/**
 * sheet2_OnSearchEnd
 */
function sheet2_OnSearchEnd(sheetObj, errCode, errMsg) {
	var formObj = document.form;
	var mainSheetObj = sheetObjects[0];
	if (errMsg != null && errMsg != '') {
		ComShowMessage(errMsg);
	} else {
		var isSelect = false;
		if (formObj.f_cmd.value == SEARCH02) {
			for ( var i = 1; i < sheetObj.RowCount() + 1; i++) {
				if (sheetObj.GetRowEditable(i) == true) {
					preSelectRow = i;
					isSelect = true;
					break;
				}
			}
			if (isSelect) {
				preSelectRow = 0;
			}
			changeBkgNo(sheetObj, mainSheetObj.GetCellValue(1, 'bkg_no'), mainSheetObj.GetCellValue(1, 'org_bkg_no'), mainSheetObj.GetCellValue(1, 'eq_tpsz_cd'));
		}
		if (formObj.f_cmd.value == SEARCH04) {
			var resultStr = sheetObj.GetEtcData('RESULT');
			if (resultStr == 'F') {
				ComShowMessage('Duplicated data cannot be applied!!');
			} else if (resultStr == 'P') {
				applyCntrSelect(sheetObj);
			} else if (resultStr == 'S') {
				applyCntrSelect(sheetObj);
				ComShowCodeMessage('COM12116', 'Apply');
				ComClosePopup();
			}
		}
	}
}

function changeBkgNo(sheetObj, bkg_no, org_bkg_no, eq_tpsz_cd) {
	for ( var i = sheetObj.HeaderRows(); i < sheetObj.RowCount() + sheetObj.HeaderRows(); i++) {
		if (sheetObj.GetCellValue(i, 'org_apply_so_seq') != '') {
			continue;
		} else if (isAppliableBkgNo(sheetObj.GetCellValue(i, 'bkg_no')) && checkReplaceCntrTpSz(eq_tpsz_cd, sheetObj.GetCellValue(i, 'eq_tpsz_cd'))) {
			sheetObj.SetRowEditable(i, 1);
			sheetObj.SetRowBackColor(i, "#EFFEB8");
		} else {
			sheetObj.SetRowEditable(i, 0);
			sheetObj.SetRowBackColor(i, "#EFEBEF");
		}
	}
}

function checkReplaceCntrTpSz(org_eq_tpsz_cd, tgt_eq_tpsz_cd) {
	if (org_eq_tpsz_cd == tgt_eq_tpsz_cd) {
		return true;
	}
	var sheetObj = sheetObjects[2];
	var idx = sheetObj.FindText('cntr_tpsz_cd', org_eq_tpsz_cd);
	var returnFlag = false;
	if (idx != -1) {
		for ( var i = idx; i < sheetObj.RowCount() + sheetObj.HeaderRows(); i++) {
			if (org_eq_tpsz_cd == sheetObj.GetCellValue(i, 'cntr_tpsz_cd')) {
				if (tgt_eq_tpsz_cd == sheetObj.GetCellValue(i, 'prov_cntr_tpsz_cd')) {
					returnFlag = true;
					break;
				}
			} else {
				break;
			}
		}
	}
	return returnFlag;
}


function applyCntrSelect(sheetObj) {
	var openerMainSheet = opener.sheetObjects[0];
	var checkList = openerMainSheet.FindCheckedRow('chk1');
	var checkArray = checkList.split('|');
	var trsp_so_seq = '';
	for ( var i = sheetObj.HeaderRows(); i < sheetObj.RowCount() + sheetObj.HeaderRows(); i++) {
		if (sheetObj.GetCellValue(i, 'org_apply_so_seq') != '') {
			continue;
		} else if (sheetObj.GetCellValue(i, 'apply_so_seq') != '' && sheetObj.GetCellValue(i, 'dup_check') == '') {
			trsp_so_seq = sheetObj.GetCellValue(i, 'apply_so_seq').substring(3);
			for ( var k = 0; k < checkArray.length; k++) {
				if (trsp_so_seq == openerMainSheet.GetCellValue(checkArray[k], 'trsp_so_seq')) {
					openerMainSheet.SetCellValue(checkArray[k], 'eq_no', sheetObj.GetCellValue(i, 'eq_no'), 0);
					openerMainSheet.SetCellValue(checkArray[k], 'eq_tpsz_cd', sheetObj.GetCellValue(i, 'eq_tpsz_cd'), 0);
					break;
				}
			}
		}
	}
}

function isAppliableBkgNo(bkgNoValue) {
	var sheetObj = sheetObjects[3];
	var returnFlag = false;
	for ( var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
		if (sheetObj.GetCellValue(i, 'bkg_no') == bkgNoValue) {
			returnFlag = true;
			break;
		}
	}
	return returnFlag;
}
