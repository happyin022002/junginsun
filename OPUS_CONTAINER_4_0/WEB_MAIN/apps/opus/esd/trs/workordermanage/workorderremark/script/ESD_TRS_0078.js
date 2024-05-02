/**
 * @fileoverview Defining scripts
 * @author author_name
 */

var sheetObjects = new Array();
var sheetCnt = 0;
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;
			case "btng_rowadd":
				doActionIBSheet(sheetObject, formObject, IBINSERT);
				break;
			case "btng_save":
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
			case 'btng_delete':
				doActionIBSheet(sheetObject, formObject, IBDELETE);
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e);
		}
	}
}
/**
 * Register IBSheet Object with array
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * Setting sheets and initialization Implementing the onLoad event handler of body tag Adding the preceding function after loading page
 */
function loadPage() {
	for ( var i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * Define the initial values and headers of sheets
 * 
 * 
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:
		    with(sheetObj) {
			      var HeadTitle="STS||Office|Cost Mode|Trans Mode|Bound|Remarks|Created Date|Creation Office|User ID" ;
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:2, DataRowMerge:0 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ 
			                   {Type:"Status",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                   {Type:"DummyCheck", Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck" },
			                   {Type:"Text",       Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"wo_instr_ofc_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Combo",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"trsp_cost_mod_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                   {Type:"Combo",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"trsp_crr_mod_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                   {Type:"Combo",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"trsp_bnd_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                   {Type:"Text",       Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"wo_instr_rmk",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                   {Type:"Date",       Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",       Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                   {Type:"Text",       Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } 
			                ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetColProperty('trsp_crr_mod_cd',  {ComboText:"|"+f_trsp_crr_mod_cdText, ComboCode:"|"+f_trsp_crr_mod_cdCode} );
				  SetColProperty('trsp_cost_mod_cd', {ComboText:"|"+f_trsp_cost_mod_cdText, ComboCode:"|"+f_trsp_cost_mod_cdCode} );
				  SetColProperty('trsp_bnd_cd',      {ComboText:"|"+f_trsp_bnd_cdText, ComboCode:"|"+f_trsp_bnd_cdCode} );
				  ComResizeSheet(sheetObj);
			}
			break;
	}
}
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH: 
			formObj.f_cmd.value = SEARCH02;
			sheetObj.DoSearch("ESD_TRS_0078GS.do", TrsFrmQryString(formObj));
			break;
		case IBSAVE:
			var checkList = sheetObj.FindCheckedRow('ibcheck');
			if (checkList == '') {
				ComShowCodeMessage('COM12176');
				return false;
			}
			var checkArray = checkList.split('|');
			sheetObj.RemoveEtcData();
			formObj.f_cmd.value = MULTI01;
			sheetObj.DoSave("ESD_TRS_0078GS.do", TrsFrmQryString(formObj), 'ibcheck', false);
			break;
		case IBINSERT:
			sheetObj.DataInsert(-1);
			var row = sheetObj.GetSelectRow();
			sheetObj.SetCellValue(row, 'wo_instr_ofc_cd', formObj.f_usr_ofc_cd.value, 0);
			sheetObj.SetCellValue(row, 'cre_ofc_cd', formObj.f_usr_ofc_cd.value, 0);
			sheetObj.SetCellValue(row, 'cre_usr_id', formObj.f_cre_usr_id.value, 0);
			sheetObj.SetCellValue(row, 'ibcheck', 1, 0);
			break;
		case IBDELETE:
			var checkList = sheetObj.FindCheckedRow('ibcheck');
			if (checkList == '') {
				ComShowCodeMessage('COM12176');
				return false;
			}
			var checkArray = checkList.split('|');
			for ( var k = checkArray.length - 1; k >= 0; k--) {
				if (sheetObj.GetRowStatus(checkArray[k]) == 'I') {
					sheetObj.RowDelete(checkArray[k], false);
				}
			}
			checkList = sheetObj.FindCheckedRow('ibcheck');
			var checkArray = checkList.split('|');
			if (checkList == '')
				return false;

			if (checkArray.length > 0) {
				for ( var d = 0; d < checkArray.length - 0; d++) {
					var delIdx = checkArray[d];
					sheetObj.SetCellValue(delIdx, 'ibflag', "D");
				}
			}
			var queryStr = sheetObj.GetSaveString(false, false, "ibcheck");
			formObj.f_cmd.value = REMOVE01;
			sheetObj.DoSave("ESD_TRS_0078GS.do", TrsFrmQryString(formObj), 'ibcheck', false);
			break;
	}
}

function sheet1_OnSaveEnd(sheetObj, errMsg) {
    var formObj=document.form;
    if( errMsg != null && errMsg != '' ) {
        ComShowMessage(errMsg);
    } else {
    	if(formObj.f_cmd.value == REMOVE01) {
        	var checkList =  sheetObj.FindCheckedRow('ibcheck');
        	var checkArray = checkList.split('|');
        	for ( var k = checkArray.length - 1; k >= 0; k--) {
        		sheetObj.RowDelete(checkArray[k], false);
			} 
        }
    	ComShowCodeMessage("COM132601");
    }
}

function sheet1_OnChange(sheetObj, row, col, value) {
	var formObj = document.form;
	var colName = sheetObj.ColSaveName(col);
	switch (colName) {
		case 'trsp_cost_mod_cd':
		case 'trsp_crr_mod_cd':
		case 'trsp_bnd_cd':
			if (sheetObj.ColValueDup('trsp_cost_mod_cd|trsp_crr_mod_cd|trsp_bnd_cd') != -1) {
				ComShowCodeMessage('COM12115', 'CostMode and TransMode and Bound');
				sheetObj.SetCellValue(row, colName, '', 0);
				return;
			}
			break;
	}
	sheetObj.SetCellValue(row, 'ibcheck', 1, 0);
}