/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   :  ESD_TRS_0079.js
 *@FileTitle  : Control Office Exception Case Creation
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/04/08
=========================================================*/

/* General global variable */
var curTab = 1;
var beforetab = 0;
var sheetObjects = new Array();
var sheetCnt = 0;
var cntr_tp_cdText = '';
var cntr_tp_cdCode = '';
var cntr_sz_cdText = '';
var cntr_sz_cdCode = '';
var F_trsp_cost_dtl_mod_cdCode = 'CY|DR';
var F_trsp_cost_dtl_mod_cdText = 'CY|DOOR';
var M_trsp_cost_dtl_mod_cdCode = 'ER|CN|CF';
var M_trsp_cost_dtl_mod_cdText = 'EMPTY REPO|CNTR S/T ON-HIRE|CNTR S/T OFF-HIRE';
var A_trsp_cost_dtl_mod_cdCode = 'CY|DR|ER|CN|CF';
var A_trsp_cost_dtl_mod_cdText = 'CY|DOOR|EMPTY REPO|CNTR S/T ON-HIRE|CNTR S/T OFF-HIRE';
var M_trsp_crr_mod_cdCode = 'WD|TD|RD';
var M_trsp_crr_mod_cdText = 'WD|TD|RD';

document.onclick = processButtonClick;

function processButtonClick() {
	/** *** Adding additional sheet variables to use more than one sheet per a tab **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
	        case "btn_retrieve": {
	        	doActionIBSheet(sheetObject, formObject, IBSEARCH);
	            break;
	        }
	        case 'btn_reset': {
	            formObject.reset();
	            break;
	        }
            case "btn_minimize": {
                if(document.all.MiniLayer.style.display != "none") {
                    document.all.MiniLayer.style.display="none";                
                } else {
                    document.all.MiniLayer.style.display="";                
                }
                ComResizeSheet(sheetObject);
                break;
            }
            case "btns_frmnode": {
                openHireYardPopup('getFromNode');
                break;
            }
            case "btns_vianode": { 
                openHireYardPopup('getViaNode');
                break;
            }
            case "btns_tonode": {
                openHireYardPopup('getToNode');
                break;
            }
            case "btns_dorloc": {
                openHireYardPopup('getDorLoc');
                break;
            }
            case "btns_office": {
//                if( validation_check()) {
                    var ofc_cd=formObject.input_office.value;
                    ComOpenWindow('ESD_TRS_0964.screen?ctrl_ofc_cd='+ofc_cd, 'OpneHistoryWin', 'top=200, left=200, width=600, height=370, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
//                }
                break;
            }
			case "btng_rowadd":
				doActionIBSheet(sheetObject, formObject, IBINSERT);
				break;
			case "btng_rowdel":
				doActionIBSheet(sheetObject, formObject, IBDELETE);
				break;
			case "btng_save":
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
		} 
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * Register IBSheet Object with array call from comSheetObject(id)
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Setting sheets and initialization Implementing the onLoad event handler of body tag Adding the preceding function after loading page
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	var formObj = document.form;
	formObj.f_cmd.value = SEARCH04;
	var xml = sheetObjects[0].GetSearchData("ESD_TRS_0079GS.do", TrsFrmQryString(formObj));
	sheetObjects[0].LoadSearchData(xml, { Sync : 1 });
	formObj.f_cmd.value = SEARCH05;
	xml = sheetObjects[0].GetSearchData("ESD_TRS_0079GS.do", TrsFrmQryString(formObj), { Sync : 1 });
	sheetObjects[0].LoadSearchData(xml, { Sync : 1 });
	//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	initCostMode();
}

/**
 * Define the initial values and headers of sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
		case 1:
			with (sheetObj) {
				var HeadTitle = "Del.|For COP/\nMTY Plan|Cost\nMode|Trans\nMode|Equipment\nTP     SZ|Equipment\nTP     SZ";
				HeadTitle += "|From Node|From Node|Via Node|Via Node|To Node|To Node|Door Node|Door Node";
				HeadTitle += "|Control\nOffice\nSetting|Control\nOffice\nCode|Creation\nDate";
				HeadTitle += "|Creation\nUser Name|Delete Date|Delete\nUser Name";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [{ Text : HeadTitle, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [
					{ Type:"CheckBox", Hidden:0, Width:50,  Align:"Center", ColMerge:0, SaveName:"delcheck",             KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:1, InsertEdit:1},
					{ Type:"Combo",    Hidden:0, Width:80,  Align:"Center", ColMerge:0, SaveName:"cgo_tp_cd",            KeyField:1, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:0, InsertEdit:1},
					{ Type:"Combo",    Hidden:0, Width:100, Align:"Center", ColMerge:0, SaveName:"trsp_cost_dtl_mod_cd", KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:0, InsertEdit:1},
					{ Type:"Combo",    Hidden:0, Width:60,  Align:"Center", ColMerge:0, SaveName:"trsp_crr_mod_cd",      KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:0, InsertEdit:1},
					{ Type:"Combo",    Hidden:0, Width:40,  Align:"Center", ColMerge:0, SaveName:"cntr_tp_cd",           KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:0, InsertEdit:1},
					{ Type:"Combo",    Hidden:0, Width:40,  Align:"Center", ColMerge:0, SaveName:"cntr_sz_cd",           KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:0, InsertEdit:1},
					{ Type:"Text",     Hidden:0, Width:60,  Align:"Center", ColMerge:0, SaveName:"fm_loc_value",         KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:5 },
					{ Type:"Text",     Hidden:0, Width:40,  Align:"Center", ColMerge:0, SaveName:"fm_yard_value",        KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:2 },
					{ Type:"Text",     Hidden:0, Width:60,  Align:"Center", ColMerge:0, SaveName:"via_loc_value",        KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:5 },
					{ Type:"Text",     Hidden:0, Width:40,  Align:"Center", ColMerge:0, SaveName:"via_yard_value",       KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:2 },
					{ Type:"Text",     Hidden:0, Width:60,  Align:"Center", ColMerge:0, SaveName:"to_loc_value",         KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:5 },
					{ Type:"Text",     Hidden:0, Width:40,  Align:"Center", ColMerge:0, SaveName:"to_yard_value",        KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:2 },
					{ Type:"Text",     Hidden:0, Width:60,  Align:"Center", ColMerge:0, SaveName:"dor_loc_value",        KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:5 },
					{ Type:"Text",     Hidden:0, Width:40,  Align:"Center", ColMerge:0, SaveName:"dor_yard_value",       KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:2 },
					{ Type:"Combo",    Hidden:0, Width:90,  Align:"Center", ColMerge:0, SaveName:"ctrl_ofc_div_cd",      KeyField:1, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:0, InsertEdit:1},
					{ Type:"Text",     Hidden:0, Width:90,  Align:"Center", ColMerge:0, SaveName:"ctrl_ofc_cd",          KeyField:1, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:5 },
					{ Type:"Date",     Hidden:0, Width:90,  Align:"Center", ColMerge:0, SaveName:"cre_dt",               KeyField:0, CalcLogic:"", Format:"Ymd", PointCount:0, UpdateEdit:0, InsertEdit:0},
					{ Type:"Text",     Hidden:0, Width:90,  Align:"Center", ColMerge:0, SaveName:"cre_usr_id",           KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:0, InsertEdit:0},
					{ Type:"Date",     Hidden:0, Width:90,  Align:"Center", ColMerge:0, SaveName:"upd_dt",               KeyField:0, CalcLogic:"", Format:"Ymd", PointCount:0, UpdateEdit:0, InsertEdit:0},
					{ Type:"Text",     Hidden:0, Width:90,  Align:"Center", ColMerge:0, SaveName:"upd_usr_id",           KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:0, InsertEdit:0},
					{ Type:"Status",   Hidden:1, Width:40,  Align:"Center", ColMerge:0, SaveName:"ibflag"       }, 
					{ Type:"Text",     Hidden:1, Width:0,   Align:"Center", ColMerge:0, SaveName:"fm_nod_cd"    },
					{ Type:"Text",     Hidden:1, Width:0,   Align:"Center", ColMerge:0, SaveName:"to_nod_cd"    }, 
					{ Type:"Text",     Hidden:1, Width:0,   Align:"Center", ColMerge:0, SaveName:"via_nod_cd"   },
					{ Type:"Text",     Hidden:1, Width:0,   Align:"Center", ColMerge:0, SaveName:"dor_nod_cd"   }, 
					{ Type:"Text",     Hidden:1, Width:0,   Align:"Center", ColMerge:0, SaveName:"delt_flg"     },
					{ Type:"Text",     Hidden:1, Width:0,   Align:"Center", ColMerge:0, SaveName:"org_delt_flg" }
				];
				InitColumns(cols);
				SetEditable(1);
				SetColProperty(0, 	"ctrl_ofc_div_cd", { ComboText : "By_From|By_To|By_Via|By_Door", ComboCode : "F|T|V|D" });
				SetColHidden(0,		'ibflag', 1);
				SetColProperty(0,	'cgo_tp_cd', { ComboText : cgo_tp_cdText, ComboCode : cgo_tp_cdCode });
				SetColProperty(0,	'trsp_cost_dtl_mod_cd', { ComboText : "" + A_trsp_cost_dtl_mod_cdText, ComboCode : "" + A_trsp_cost_dtl_mod_cdCode });
				SetColProperty(0,	'trsp_crr_mod_cd', { ComboText : "" + trsp_crr_mod_cdText, ComboCode : "" + trsp_crr_mod_cdCode });
				SetColProperty(0,	'fm_loc_value',  { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0,	'via_loc_value', { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0,	'to_loc_value',  { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0,	'dor_loc_value', { AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0,	'ctrl_ofc_cd',   { AcceptKeys : "E", InputCaseSensitive : 1 });
				ComResizeSheet(sheetObj);
			}
			break;
		}
}

function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH: // Retrieve
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESD_TRS_0079GS.do", TrsFrmQryString(formObj), { Sync : 1 });
			break;
		case IBSAVE: // Save
			if (!validateForm(sheetObj, formObj, sAction)) {
				return false;
			}
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESD_TRS_0079GS.do", TrsFrmQryString(formObj), 'ibflag', false);
			break;
		case IBDELETE: // Save
			for ( var idx = sheetObj.RowCount(); idx > 0; idx--) {
				if (sheetObj.GetCellValue(idx, 'delcheck') == 1 && sheetObj.GetRowStatus(idx) == 'I') {
					sheetObj.RowDelete(idx);
				}
			}
			break;
		case IBDOWNEXCEL:
			sheetObj.Down2Excel({ DownCols : makeHiddenSkipCol_TRS(sheetObj), SheetDesign : 1, Merge : 1 });
			break;
		case IBINSERT: // Insert
			var row = sheetObj.DataInsert(-1);
			sheetObj.InitCellProperty(row, 'fm_yard_value', { Type : "Combo" });
			sheetObj.InitCellProperty(row, 'to_yard_value', { Type : "Combo" });
			sheetObj.InitCellProperty(row, 'via_yard_value', { Type : "Combo" });
			sheetObj.InitCellProperty(row, 'dor_yard_value', { Type : "Combo" });
			sheetObj.SetCellEditable(row, 'via_loc_value', 0);
			sheetObj.SetCellEditable(row, 'via_yard_value', 0);
			sheetObj.SetCellEditable(row, 'dor_loc_value', 0);
			sheetObj.SetCellEditable(row, 'dor_yard_value', 0);
			sheetObj.CellComboItem(row, 'trsp_cost_dtl_mod_cd', { ComboText : "" + F_trsp_cost_dtl_mod_cdText, ComboCode : "" + F_trsp_cost_dtl_mod_cdCode });
			break;
	}
}

/**
 * Validating inputted values of form
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSAVE:
			for ( var k = 1; k < sheetObj.RowCount() + 1; k++) {
				var ctl_ofc_set = sheetObj.GetCellValue(k, 'ctrl_ofc_div_cd');
				if (sheetObj.GetRowStatus(k) == 'I' && ctl_ofc_set == 'V' && sheetObj.GetCellValue(k, 'via_loc_value') == '') {
					ComShowCodeMessage('COM12114', 'Via Node');
					sheetObj.SelectCell(k, 'via_loc_value');
					return false;
				}
				if (sheetObj.GetRowStatus(k) == 'I' && ctl_ofc_set == 'D' && sheetObj.GetCellValue(k, 'dor_loc_value') == '') {
					ComShowCodeMessage('COM12114', 'Door Node');
					sheetObj.SelectCell(k, 'dor_loc_value');
					return false;
				}
				if (sheetObj.GetCellEditable(k, 'to_yard_value') && sheetObj.GetCellValue(k, 'to_loc_value') == '') {
					ComShowCodeMessage('COM12114', 'To Node');
					sheetObj.SelectCell(k, 'to_loc_value');
					return false;
				}
				if (sheetObj.GetCellEditable(k, 'fm_loc_value') && sheetObj.GetCellValue(k, 'fm_loc_value') == '') {
					ComShowCodeMessage('COM12114', 'From Node');
					sheetObj.SelectCell(k, 'fm_loc_value');
					return false;
				}
				if (sheetObj.GetCellEditable(k, 'via_yard_value') && sheetObj.GetCellValue(k, 'via_loc_value') == '') {
					ComShowCodeMessage('COM12114', 'Via Node');
					sheetObj.SelectCell(k, 'via_loc_value');
					return false;
				}
				if (sheetObj.GetCellEditable(k, 'dor_loc_value') && sheetObj.GetCellValue(k, 'dor_loc_value') == '') {
					ComShowCodeMessage('COM12114', 'Door Node');
					sheetObj.SelectCell(k, 'dor_loc_value');
					return false;
				}
			}
			return true;
	}
}

/**
 * General processing method working when there is an error of inquiring result DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js
 */
function sheet_OnSearchEnd(sheetObj, code, errMsg) {
	var formObj = document.form;
	if (errMsg != null && errMsg != '') {
		ComShowMessage(errMsg);
	} else if (formObj.f_cmd.value == SEARCH05) {
		cntr_tp_cdText = sheetObj.GetEtcData('TEXT');
		cntr_tp_cdCode = sheetObj.GetEtcData('TEXT');
		sheetObj.RemoveEtcData();
		sheetObj.SetColProperty('cntr_tp_cd', { ComboText : "|" + cntr_tp_cdText, ComboCode : "|" + cntr_tp_cdCode });
	} else if (formObj.f_cmd.value == SEARCH04) {
		cntr_sz_cdText = sheetObj.GetEtcData('TEXT');
		cntr_sz_cdCode = sheetObj.GetEtcData('TEXT');
		sheetObj.RemoveEtcData();
		sheetObj.SetColProperty('cntr_sz_cd', { ComboText : "|" + cntr_sz_cdText, ComboCode : "|" + cntr_sz_cdCode });
	} else if (formObj.f_cmd.value == SEARCH06) {
		var ofc_cd = sheetObj.GetEtcData('OFC_CD');
		var ofc_tp_cd = sheetObj.GetEtcData('OFC_TP_CD');
		sheetObj.RemoveEtcData();
		if (ofc_cd == undefined || ofc_cd == '' || ofc_tp_cd == 'NO') {
			ComShowCodeMessage('LEA90008');
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), 'ctrl_ofc_cd', '', 0);
		}
	}
}

/**
 * Location 이나 Country Code
 * 
 */
function sheet_OnChange(sheetObj, row, col, value) {
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(col);
	if (!checkNode(sheetObj, row, colName, value)) {
		return;
	}
	formObject.TRSP_SO_EQ_KIND.value = '';
	if (value.length == 5) {
		formObject.f_cmd.value = SEARCH01;
		switch (colName) {
			case 'fm_loc_value':
				if (sheetObj.GetCellValue(row, 'trsp_cost_dtl_mod_cd') == 'CN') {
					formObject.TRSP_SO_EQ_KIND.value = 'N';
				}
				var queryString = "col=fm_yard_value&row=" + row + "&empty=Y&searchStr=" + sheetObj.GetCellValue(row, colName) + "&" + TrsFrmQryString(formObject);
				sheetObj.InitCellProperty(row, 'fm_yard_value', { Type : "Combo" });
				fm_yard_value = ComSearchEtcData(sheetObj, "ESD_TRS_0079GS.do", queryString, 'nod');
				sheetObj.SetCellEditable(row, 'fm_yard_value', 1);
				sheetObj.CellComboItem(row, 'fm_yard_value', { ComboText : "|" + fm_yard_value, ComboCode : "|" + fm_yard_value });
				break;
			case 'to_loc_value':
				if (sheetObj.GetCellValue(row, 'trsp_cost_dtl_mod_cd') == 'CF') {
					formObject.TRSP_SO_EQ_KIND.value = 'N';
				}
				var queryString = "col=to_yard_value&row=" + row + "&empty=Y&searchStr=" + sheetObj.GetCellValue(row, colName) + "&" + TrsFrmQryString(formObject);
				sheetObj.InitCellProperty(row, 'to_yard_value', { Type : "Combo" });
				to_yard_value = ComSearchEtcData(sheetObj, "ESD_TRS_0079GS.do", queryString, 'nod');
				sheetObj.SetCellEditable(row, 'to_yard_value', 1);
				sheetObj.CellComboItem(row, 'to_yard_value', { ComboText : "|" + to_yard_value, ComboCode : "|" + to_yard_value });
				break;
			case 'via_loc_value':
				var queryString = "col=via_yard_value&row=" + row + "&empty=Y&searchStr=" + sheetObj.GetCellValue(row, colName) + "&" + TrsFrmQryString(formObject);
				sheetObj.InitCellProperty(row, 'via_yard_value', { Type : "Combo" });
				via_yard_value = ComSearchEtcData(sheetObj, "ESD_TRS_0079GS.do", queryString, 'nod');
				sheetObj.SetCellEditable(row, 'via_yard_value', 1);
				sheetObj.CellComboItem(row, 'via_yard_value', { ComboText : "|" + via_yard_value, ComboCode : "|" + via_yard_value });
				break;
			case 'dor_loc_value':
				var queryString = "col=dor_yard_value&row=" + row + "&empty=Y&isZone=Y&searchStr=" + sheetObj.GetCellValue(row, colName) + "&" + TrsFrmQryString(formObject);
				sheetObj.InitCellProperty(row, 'dor_yard_value', { Type : "Combo" });
				dor_yard_value = ComSearchEtcData(sheetObj, "ESD_TRS_0079GS.do", queryString, 'nod');
				sheetObj.SetCellEditable(row, 'dor_yard_value', 1);
				sheetObj.CellComboItem(row, 'dor_yard_value', { ComboText : "|" + dor_yard_value, ComboCode : "|" + dor_yard_value });
				break;
		}
	} else if (value.length == 2) {
		removeYard(sheetObj, row, colName, value);
		formObject.f_cmd.value = SEARCH02;
		switch (colName) {
			case 'fm_loc_value':
				var queryString = "col=fm_yard_value&row=" + row + "&searchStr=" + value + "&" + TrsFrmQryString(formObject);
				var sXml = sheetObj.GetSearchData("ESD_TRS_0079GS.do", queryString);
				var vendorNoList = ComGetEtcData(sXml, 'CNT_CD');
				if (!checkCountry(vendorNoList)) {
					sheetObj.SetCellValue(row, colName, '', 0);
					return;
				}
				sheetObj.SetCellEditable(row, 'fm_yard_value', 0);
				break;
			case 'to_loc_value':
				var queryString = "col=to_yard_value&row=" + row + "&searchStr=" + value + "&" + TrsFrmQryString(formObject);
				var sXml = sheetObj.GetSearchData("ESD_TRS_0079GS.do", queryString);
				var vendorNoList = ComGetEtcData(sXml, 'CNT_CD');
				if (!checkCountry(vendorNoList)) {
					sheetObj.SetCellValue(row, colName, '', 0);
					return;
				}
				sheetObj.SetCellEditable(row, 'to_yard_value', 0);
				break;
			case 'via_loc_value':
				var queryString = "col=via_yard_value&row=" + row + "&searchStr=" + value + "&" + TrsFrmQryString(formObject);
				var sXml = sheetObj.GetSearchData("ESD_TRS_0079GS.do", queryString);
				var vendorNoList = ComGetEtcData(sXml, 'CNT_CD');
				if (!checkCountry(vendorNoList)) {
					sheetObj.SetCellValue(row, colName, '', 0);
					return;
				}
				sheetObj.SetCellEditable(row, 'via_yard_value', 0);
				break;
			case 'dor_loc_value':
				var queryString = "col=dor_yard_value&row=" + row + "&searchStr=" + value + "&" + TrsFrmQryString(formObject);
				var sXml = sheetObj.GetSearchData("ESD_TRS_0079GS.do", queryString);
				var vendorNoList = ComGetEtcData(sXml, 'CNT_CD');
				if (!checkCountry(vendorNoList)) {
					sheetObj.SetCellValue(row, colName, '', 0);
					return;
				}
				sheetObj.SetCellEditable(row, 'dor_yard_value', 0);
				break;
		}
	}
	switch (colName) {
		case 'ctrl_ofc_div_cd':
		case 'fm_loc_value':
		case 'to_loc_value':
		case 'via_loc_value':
		case 'dor_loc_value':
			setControlOfficeSetting(sheetObj, row);
			break;
		case 'delcheck':
			if (value == '1') {
				sheetObj.SetCellValue(row, 'delt_flg', 'Y', 0);
			} else {
				sheetObj.SetCellValue(row, 'delt_flg', 'N', 0);
			}
			if (sheetObj.GetCellValue(row, 'org_delt_flg') == sheetObj.GetCellValue(row, 'delt_flg')) {
				sheetObj.SetRowStatus(row, 'R');
			}
			break;
		case 'cgo_tp_cd':
			if (value == 'F') {
				sheetObj.CellComboItem(row, 'trsp_cost_dtl_mod_cd', { ComboText : "" + F_trsp_cost_dtl_mod_cdText, ComboCode : "" + F_trsp_cost_dtl_mod_cdCode });
				sheetObj.CellComboItem(row, 'trsp_crr_mod_cd', { ComboText : "" + trsp_crr_mod_cdText, ComboCode : "" + trsp_crr_mod_cdCode });
			} else if (value == 'M') {
				sheetObj.CellComboItem(row, 'trsp_cost_dtl_mod_cd', { ComboText : "" + M_trsp_cost_dtl_mod_cdText, ComboCode : "" + M_trsp_cost_dtl_mod_cdCode });
				sheetObj.CellComboItem(row, 'trsp_crr_mod_cd', { ComboText : "" + M_trsp_crr_mod_cdText, ComboCode : "" + M_trsp_crr_mod_cdCode });
			}
			break;
		case 'ctrl_ofc_cd':
			sheetObj.SetCellValue(row, colName, value, 0);
			if (ComTrim(value) != '') {
				formObject.f_cmd.value = SEARCH06;
				var queryString = "ctrl_ofc_cd=" + value + "&" + TrsFrmQryString(formObject);
				sheetObj.DoRowSearch(row, "ESD_TRS_0079GS.do", queryString, { Sync : 2 });
			}
			break;
	}
	switch (colName) {
		case ('fm_loc_value'):
		case ('fm_yard_value'):
			sheetObj.SetCellValue(row, 'fm_nod_cd', sheetObj.GetCellValue(row, 'fm_loc_value') + sheetObj.GetCellValue(row, 'fm_yard_value'), 0);
			break;
		case ('to_loc_value'):
		case ('to_yard_value'):
			sheetObj.SetCellValue(row, 'to_nod_cd', sheetObj.GetCellValue(row, 'to_loc_value') + sheetObj.GetCellValue(row, 'to_yard_value'), 0);
			break;
		case ('via_loc_value'):
		case ('via_yard_value'):
			sheetObj.SetCellValue(row, 'via_nod_cd', sheetObj.GetCellValue(row, 'via_loc_value') + sheetObj.GetCellValue(row, 'via_yard_value'), 0);
			break;
		case ('dor_loc_value'):
		case ('dor_yard_value'):
			sheetObj.SetCellValue(row, 'dor_nod_cd', sheetObj.GetCellValue(row, 'dor_loc_value') + sheetObj.GetCellValue(row, 'dor_yard_value'), 0);
			break;
		case ('trsp_cost_dtl_mod_cd'):
			sheetObj.SetCellValue(row, 'fm_loc_value', "", 0);
			sheetObj.SetCellValue(row, 'via_loc_value', "", 0);
			sheetObj.SetCellValue(row, 'to_loc_value', "", 0);
			removeYard(sheetObj, row, 'fm_loc_value', value);
			removeYard(sheetObj, row, 'via_loc_value', value);
			removeYard(sheetObj, row, 'to_loc_value', value);
			if (value == "DR" || value.trim() == "") {
				sheetObj.SetCellEditable(row, 'dor_yard_value', 1);
				sheetObj.SetCellEditable(row, 'dor_loc_value', 1);
			} else {
				sheetObj.SetCellValue(row, 'dor_loc_value', "", 0);
				removeYard(sheetObj, row, 'dor_loc_value', value);
				sheetObj.SetCellEditable(row, 'dor_yard_value', 0);
				sheetObj.SetCellEditable(row, 'dor_loc_value', 0);
			}
			if (value == 'CN' || value == 'CF') {
				sheetObj.SetCellValue(row, 'trsp_crr_mod_cd', "TD", 0);
				sheetObj.SetCellEditable(row, 'trsp_crr_mod_cd', 0);
			} else {
				sheetObj.SetCellEditable(row, 'trsp_crr_mod_cd', 1);
			}
			break;
		case ('trsp_crr_mod_cd'):
			if (value == 'RD' || value == 'TD' || value == 'WD') {
				sheetObj.SetCellValue(row, 'via_loc_value', "", 0);
				removeYard(sheetObj, row, 'via_loc_value', value);
				sheetObj.SetCellEditable(row, 'via_yard_value', 0);
				sheetObj.SetCellEditable(row, 'via_loc_value', 0);
			} else {
				sheetObj.SetCellEditable(row, 'via_yard_value', 1);
				sheetObj.SetCellEditable(row, 'via_loc_value', 1);
			}
			break;
		case ('cgo_tp_cd'):
			if (value == 'M') {
				sheetObj.SetCellValue(row, 'via_loc_value', "", 0);
				removeYard(sheetObj, row, 'via_loc_value', value);
				sheetObj.SetCellEditable(row, 'via_yard_value', 0);
				sheetObj.SetCellEditable(row, 'via_loc_value', 0);
				sheetObj.SetCellValue(row, 'dor_loc_value', "", 0);
				removeYard(sheetObj, row, 'dor_loc_value', value);
				sheetObj.SetCellEditable(row, 'dor_yard_value', 0);
				sheetObj.SetCellEditable(row, 'dor_loc_value', 0);
			} else {
				sheetObj.SetCellEditable(row, 'via_yard_value', 0);
				sheetObj.SetCellEditable(row, 'via_loc_value', 0);
				sheetObj.SetCellEditable(row, 'dor_yard_value', 0);
				sheetObj.SetCellEditable(row, 'dor_loc_value', 0);
			}
			break;
	}
}

function checkNode(sheetObj, row, colName, value) {
	if (colName != 'fm_loc_value' && colName != 'to_loc_value' && colName != 'via_loc_value' && colName != 'dor_loc_value') {
		return true;
	}
	if (value.length != 2 && value.length != 5) {
		switch (colName) {
			case 'fm_loc_value':
				sheetObj.SetCellValue(row, 'fm_loc_value', "", 0);
				break;
			case 'to_loc_value':
				sheetObj.SetCellValue(row, 'to_loc_value', "", 0);
				break;
			case 'via_loc_value':
				sheetObj.SetCellValue(row, 'via_loc_value', "", 0);
				break;
			case 'dor_loc_value':
				sheetObj.SetCellValue(row, 'dor_loc_value', "", 0);
				break;
		}
		removeYard(sheetObj, row, colName, value);
		return false;
	}
	return true;
}

function removeYard(sheetObj, row, col, value) {
	switch (col) {
		case 'fm_loc_value': {
			sheetObj.SetCellValue(row, 'fm_yard_value', "", 0);
			sheetObj.CellComboItem(row, 'fm_yard_value', { ComboText : '', ComboCode : '' });
			break;
		}
		case 'to_loc_value': {
			sheetObj.SetCellValue(row, 'to_yard_value', "", 0);
			sheetObj.CellComboItem(row, 'to_yard_value', { ComboText : '', ComboCode : '' });
			break;
		}
		case 'via_loc_value': {
			sheetObj.SetCellValue(row, 'via_yard_value', "", 0);
			sheetObj.CellComboItem(row, 'via_yard_value', { ComboText : '', ComboCode : '' });
			break;
		}
		case 'dor_loc_value': {
			sheetObj.SetCellValue(row, 'dor_yard_value', "", 0);
			sheetObj.CellComboItem(row, 'dor_yard_value', { ComboText : '', ComboCode : '' });
			break;
		}
	}
}

function checkCountry(value) {
	if (value == '' || value == undefined) {
		ComShowCodeMessage('TRS90115');
		return false;
	} else {
		return true;
	}
}

function setControlOfficeSetting(sheetObj, row) {
	var value = sheetObj.GetCellValue(row, 'ctrl_ofc_div_cd');
	var formObject = document.form;
	formObject.f_cmd.value = SEARCH03;
	var selectColumnName = '';
	if (value == 'F') {
		selectColumnName = 'fm_loc_value';
	} else if (value == 'T') {
		selectColumnName = 'to_loc_value';
	} else if (value == 'V') {
		selectColumnName = 'via_loc_value';
	} else if (value == 'D') {
		selectColumnName = 'dor_loc_value';
	}
	var locationValue = sheetObj.GetCellValue(row, selectColumnName);
	if (locationValue.length == 5) {
		var queryString = "col=ctrl_ofc_cd&row=" + row + "&searchStr=" + locationValue + "&" + TrsFrmQryString(formObject);
		sheetObj.GetSearchData("ESD_TRS_0079GS.do", queryString);
	} else {
		sheetObj.SetCellValue(row, 'ctrl_ofc_cd', '', 0);
	}
}

function sheet_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
	var formObject = document.form;
	doActionIBSheet(sheetObj, formObject, IBSEARCH);
}

/**
* General Node popup
*/
function openHireYardPopup(objName) {
    var formObject=document.form;
    var cmdt_cd_val="";   
    var rep_cmdt_cd_val="";   
    var cmdt_desc_val="";   
    var v6=""; //mode
    var classId=objName;
    var xx1=""; //CONTI
    var xx2=""; //SUB CONTI
    var xx3=""; //COUNTRY
    var xx4=""; //STATE
    var xx5=""; //CONTROL OFFIC
    var xx6=""; //LOC CODE
    var xx7=""; //LOC NAME
    var xx8="";
    var xx9="";
    if( objName == "getDorLoc" ) {
        v6="zone"
    } else {
        v6="yard";
    }
    var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&mode="+v6;
    ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 772, 510, objName, '1,0,1,1,1,1,1,1,1,1,1,1',true);    
}

/**
* The return value of From Node popup
*/
function getFromNode(rowArray) {
    var formObject=document.form;
    var colArray=rowArray[0];
    var node=colArray[3];
    var lvLoc=node.substring(0, 5);
    var lvYard=node.substring(5, 7);
    formObject.search_fm_loc.value=lvLoc;
    getYardCombo(search_fm_yard, sheetObjects[0], formObject, lvLoc);
    search_fm_yard.SetItemCheck(lvYard, true);
}

/**
* The return value of Via Node popup
*/
function getViaNode(rowArray) {
    var formObject=document.form;
    var colArray=rowArray[0];
    var node=colArray[3];
    var lvLoc=node.substring(0, 5);
    var lvYard=node.substring(5, 7);
    formObject.search_via_loc.value=lvLoc;
    getYardCombo(search_via_yard, sheetObjects[0], formObject, lvLoc);
    search_via_yard.SetItemCheck(lvYard, true); 
}

/**
* The return value of To Node popup
*/
function getToNode(rowArray) {
    var formObject=document.form;
    var colArray=rowArray[0];
    var node=colArray[3];
    var lvLoc=node.substring(0, 5);
    var lvYard=node.substring(5, 7);
    formObject.search_to_loc.value=lvLoc;
    getYardCombo(search_to_yard, sheetObjects[0], formObject, lvLoc);
    search_to_yard.SetItemCheck(lvYard, true);
}

/**
* The return value of Door Location popup
*/
function getDorLoc(rowArray) {
    var formObject=document.form;
    var colArray=rowArray[0];
    var node=colArray[3];
    var lvLoc=node.substring(0, 5);
    var lvYard=node.substring(5, 7);
    formObject.search_door_loc.value=lvLoc;
    getZoneCombo(search_door_yard, sheetObjects[0], formObject, lvLoc);
    search_door_yard.SetItemCheck(lvYard, true);
}

//control s/o office code return value.
function rtn_office_code(obj) {
    document.form.input_office.value=obj;
}

/**
 * Loading the list of external combo box
 **/
function getComboList(obj) {
	if(obj == undefined) //return;
		obj = ComGetEvent();
	
    var yard_obj=null;
    var formObj=document.form;
    obj.value=obj.value.toUpperCase();
    var locValue=obj.value;
    var yardZoneList;
    
    // set IBMultiCombo Object
    if(obj.name == 'search_fm_loc'){
        yard_obj=search_fm_yard;
    }else if(obj.name == 'search_via_loc'){
        yard_obj=search_via_yard;
    }else if(obj.name == 'search_to_loc'){
        yard_obj=search_to_yard;
    }else if(obj.name == 'search_door_loc'){
        yard_obj=search_door_yard;
    }
    
    if(obj.value.length == 2) { // check Country Code
    	formObj.f_cmd.value = SEARCH02;
		var queryString = "searchStr=" + obj.value + "&f_cmd=" + SEARCH02;
		var sXml = sheetObjects[0].GetSearchData("ESD_TRS_0079GS.do", queryString);
		var cntCd = ComGetEtcData(sXml, 'CNT_CD');
		if (!checkCountry(cntCd)) {
			obj.value = "";
			obj.focus();
		}
		yard_obj.RemoveAll();
		return false;
    } else if(obj.value == "" || obj.value.length != 5) { // skip invalid Input
		obj.value = "";
		yard_obj.RemoveAll();
        return false;
	}
    
    // set Yard Item to IBMultiCombo
    if(obj.name == 'search_door_loc') {
    	yardZoneList = getZoneCombo(yard_obj, sheetObjects[0], formObj, locValue);
    }else{
    	yardZoneList = getYardCombo(yard_obj, sheetObjects[0], formObj, locValue);
    }
}

/*
 * remove not used Cost Mode Code on Loading HTML
 */
function initCostMode() {
	var selObj = document.form.search_trs_cost_md_cd;
	selObj.options[4].remove();
	selObj.options[3].remove();
}

/*
 * reset Cost Mode Select Box by Cargo Type
 */
function resetCostMode(cgo_tp_cd) {
	var selObj = document.form.search_trs_cost_md_cd;
	var selObj2 = document.form.search_trs_md_cd;
	if(cgo_tp_cd == "F") {
		// enable/disable Cost Mode
		for(var i = 1; i < selObj.options.length; i++) {
			if(i < 3) {
				selObj.options[i].disabled = false; // enable CY, DOOR
			}else{
				selObj.options[i].disabled = true; // disable the others
			}
		}

		// enable/disable Trans Mode
		for(var i = 1; i < selObj2.options.length; i++) {
			selObj2.options[i].disabled = false;
		}
	} else if(cgo_tp_cd == "M") {
		// enable/disable Cost Mode
		for(var i = 1; i < selObj.options.length; i++) {
			if(i < 3) {
				selObj.options[i].disabled = true;
			}else{
				selObj.options[i].disabled = false;
			}
		}

		// enable/disable Trans Mode
		for(var i = 1; i < selObj2.options.length; i++) {
			if(i < 4) {
				selObj2.options[i].disabled = false;
			}else{
				selObj2.options[i].disabled = true;
			}
		}
	} else { // select ALL
		// enable/disable Cost Mode
		for(var i = 1; i < selObj.options.length; i++) {
			selObj.options[i].disabled = false;
		}

		// enable/disable Trans Mode
		for(var i = 1; i < selObj2.options.length; i++) {
			selObj2.options[i].disabled = false;
		}
	}
	selObj.options[0].selected = true;
	selObj2.options[0].selected = true;
}