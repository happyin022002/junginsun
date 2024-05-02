/*=========================================================
 *Copyright(c) 2016 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0077.js
 *@FileTitle  : Exception Ack Rail Road
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/28
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;
var rail_road_codeCode, rail_road_codeText;

document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName)) {
			return false;
		}
		switch (srcName) {
			case "btn_retrieve": {
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;
			}
			case "btn_new": {
				sel_railroad.SetSelectIndex(0);
				sheetObject.RemoveAll();
				break;
			}
			case "btn_save": {
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
			}
			case "btng_rowadd": {
				doActionIBSheet(sheetObject, formObject, IBINSERT);
				break;
			}
			case "btng_delete": {
				doActionIBSheet(sheetObject, formObject, IBDELETE);
				break;
			}
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
 * 
 * @param sheet_obj
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * 
 */
function loadPage() {
	for ( var i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initRailRoad();
}

/**
 * Init Rail Road
 */
function initRailRoad() {
 	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	getRailVendorComboList(sel_railroad , rail_road_codeCode , rail_road_codeText , 'ALL');
	initVendorCombo(sel_railroad); 
	sel_railroad.SetSelectIndex(0);
	
}

/**
 * 
 * @param sheetObj
 * @param sheetNo
 */
function initSheet(sheetObj, sheetNo) {
	switch (sheetNo) {
		case 1: {
			with (sheetObj) {
				var HeadTitle = "|S|Del||Rail Road|Rail Road|Creation User|Creation Date|Update User|Update Date";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 0 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [{ Text : HeadTitle, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [
				            { Type : "DummyCheck", 	Hidden : 0, Width : 30,  Align : "Center", ColMerge : 0, SaveName : "ibcheck" }, 
							{ Type : "Status", 		Hidden : 1, Width : 30,  Align : "Center", ColMerge : 0, SaveName : "ibflag" },
							{ Type : "DelCheck", 	Hidden : 0, Width : 50,  Align : "Center", ColMerge : 0, SaveName : "delt_flg", 				KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
							{ Type : "Text", 		Hidden : 1, Width : 50,  Align : "Center", ColMerge : 0, SaveName : "expt_ack_rail_vndr_seq", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 		Hidden : 0, Width : 200, Align : "Left",   ColMerge : 0, SaveName : "vndr_lgl_eng_nm", 			KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 		Hidden : 0, Width : 80,  Align : "Center", ColMerge : 0, SaveName : "vndr_seq", 				KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 		Hidden : 0, Width : 100, Align : "Center", ColMerge : 0, SaveName : "cre_usr_id", 				KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Date", 		Hidden : 0, Width : 120, Align : "Center", ColMerge : 0, SaveName : "cre_dt", 					KeyField : 0, CalcLogic : "", Format : "YmdHms", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 		Hidden : 0, Width : 100, Align : "Center", ColMerge : 0, SaveName : "upd_usr_id", 				KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Date", 		Hidden : 0, Width : 120, Align : "Center", ColMerge : 0, SaveName : "upd_dt", 					KeyField : 0, CalcLogic : "", Format : "YmdHms", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }
					];
				InitColumns(cols);
				ComResizeSheet(sheetObj);
				SetEditable(1);
			}
			break;
		}
	}
}

/**
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @returns {Boolean}
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH: {
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESD_TRS_0077GS.do", TrsFrmQryString(formObj));
			break;
		}
		case IBSAVE: {
			if(ComShowCodeConfirm("COM130101")) {
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESD_TRS_0077GS.do", { Param : TrsFrmQryString(formObj), Quest:0 });
			}
			break;
		}
		case IBINSERT: {
			var insertRow = sheetObj.DataInsert();
			sheetObj.InitCellProperty(insertRow, 'vndr_lgl_eng_nm', {Type: "Combo", Align: "Left", Edit: 1, ComboText : rail_road_codeText, ComboCode : rail_road_codeCode, ShowCol: 0});
			break;
		}
		case IBDELETE: {
			var checkRows = sheetObj.FindCheckedRow("ibcheck");
			if(checkRows == '') {
				return false;
			}
			var array = checkRows.split("|")
			for(var i = array.length -1 ; i >= 0; i--) {
				sheetObj.SetCellValue(array[i], "ibflag", "D", 0);
			}
			break;
		}
		case IBSEARCH_ASYNC01:
			var param = 'f_cmd='+SEARCH +'&cntr_vndr_svc_cd=RAIL&vndr_cost_cd=TR&vndr_cnt_cd=US,CA';
 	    	var sXml=sheetObj.GetSearchData("ESD_TRS_0999GS.do", param);
	    	rail_road_codeCode=ComGetEtcData(sXml, "rail_vndr_code");
	    	rail_road_codeText=ComGetEtcData(sXml, "rail_vndr_desc");
	    	break;		
	}
}

/**
 * [Event] Save End.
 * @param sheetObj
 * @param Code
 * @param Msg
 */
function sheet1_OnSaveEnd(sheetObj, Code, Msg) {
	if(Code >= 0 ) {
		ComShowCodeMessage("COM132601")
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
	} 
}

function sheet1_OnChange(sheetObj, Row, Col, Value) {
	if(sheetObj.ColSaveName(Col) == "vndr_lgl_eng_nm") {
		sheetObj.SetCellValue(Row, 'vndr_seq', Value);
	}
}

/**
 * 
 * @param combo
 */
function sel_railroad_OnBlur(combo) {
	var finded = combo.FindItem(combo.GetSelectCode(), 0);
	if(finded  >= 0) {
		if (document.form.rail_road_name.value == combo.GetText(finded, 1)) {
			return false;
		}
		document.form.rail_road_name.value = combo.GetText(combo.GetSelectCode(), 1);
	}
}

/**
 * Rail Road combo
 */
function sel_railroad_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	if (document.form.rail_road_name.value == newText) {
		return false;	
	}
	document.form.rail_road_name.value = comboObj.GetText(newCode, 1);
}