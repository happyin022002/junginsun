/**=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName 	 : ESD_TRS_0802.js
 *@FileTitle  : TRS STCC Manage
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/26
=========================================================**/

var sheetObjects = new Array();
var sheetCnt = 0;
document.onclick = processButtonClick;
function processButtonClick() {
	/** *** using extra sheet valuable if there are more 2 sheets **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				break;
			case "btn_RowAdd":
				addRow(formObject);
				break;
			case "btn_RowDel":
				deleteRow();
				break;
			case "btn_save":
				doActionIBSheet(sheetObjects[0], document.form, MULTI);
				break;
			case "btn_exceldown":
				if (sheetObject.RowCount() < 1) {
					ComShowCodeMessage("COM132501");
				} else {
					doActionIBSheet(sheetObjects[0], document.form, "btn_exceldown", "", "");
				}
				break;
			case "btn_excelup":
				sheetObject.RemoveAll();
				sheetObject.RenderSheet(0);
				sheetObject.LoadExcel({ Mode : "HeaderMatch" });
				sheetObject.RenderSheet(1);
				break;
		} 
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * registering IBSheet Object as list adding process for list <br> 
 * in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler <br>
 * in body tag adding first-served functions after loading screen.
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
		case 1:
			with (sheetObj) {
				var HeadTitle = "STS|Check|STCC|STCC SEQ|UN No.|UN No. SEQ|IMDG Class|Packing Group Code|Packing Group|Proper Shipping Name|Delete\nFlag|Update User|Update Date|Creation User|Creation Date";
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
				var headers = [{ Text : HeadTitle, Align : "Center" }];
				InitHeaders(headers, info);
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 0 });
				var cols = [
						{ Type : "Status", 		Hidden : 1, Width : 30,  Align : "Center", ColMerge : 0, SaveName : "ibflag" }, 
						{ Type : "CheckBox",	Hidden : 0, Width : 40,  Align : "Center", ColMerge : 0, SaveName : "check" },
						{ Type : "Text", 		Hidden : 0, Width : 100, Align : "Center", ColMerge : 0, SaveName : "stcc_cd", 			KeyField : 1, CalcLogic : "", Format : "",			PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 7 },
						{ Type : "Int", 		Hidden : 0, Width : 100, Align : "Right",  ColMerge : 0, SaveName : "stcc_seq", 		KeyField : 1, CalcLogic : "", Format : "####", 		PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 3 },
						{ Type : "Text", 		Hidden : 0, Width : 100, Align : "Center", ColMerge : 0, SaveName : "un_cmdt_cd", 		KeyField : 0, CalcLogic : "", Format : "", 			PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 4 },
						{ Type : "Int", 		Hidden : 0, Width : 100, Align : "Center", ColMerge : 0, SaveName : "imdg_un_no_seq", 	KeyField : 0, CalcLogic : "", Format : "####",		PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 4 },
						{ Type : "Text", 		Hidden : 0, Width : 170, Align : "Center", ColMerge : 0, SaveName : "hzd_mtrl_clss_cd", KeyField : 0, CalcLogic : "", Format : "", 			PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 4 },
						{ Type : "Text", 		Hidden : 0, Width : 150, Align : "Center", ColMerge : 0, SaveName : "pck_grp_cd", 		KeyField : 0, CalcLogic : "", Format : "", 			PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 1 },
						{ Type : "Text", 		Hidden : 0, Width : 150, Align : "Center", ColMerge : 0, SaveName : "pck_grp_val_cd", 	KeyField : 0, CalcLogic : "", Format : "", 			PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 4 },
						{ Type : "Text", 		Hidden : 0, Width : 450, Align : "Left",   ColMerge : 0, SaveName : "prp_shp_nm", 		KeyField : 0, CalcLogic : "", Format : "", 			PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 500 },
						{ Type : "Combo",		Hidden : 0, Width : 80,  Align : "Center", ColMerge : 0, SaveName : "delt_flg", 		KeyField : 0, CalcLogic : "", Format : "", 			PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 1 },
						{ Type : "Text", 		Hidden : 0, Width : 100, Align : "Center", ColMerge : 0, SaveName : "upd_usr_id", 		KeyField : 0, CalcLogic : "", Format : "", 			PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Date", 		Hidden : 0, Width : 100, Align : "Center", ColMerge : 0, SaveName : "upd_dt", 			KeyField : 0, CalcLogic : "", Format : "Ymd", 		PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", 		Hidden : 0, Width : 100, Align : "Center", ColMerge : 0, SaveName : "cre_usr_id", 		KeyField : 0, CalcLogic : "", Format : "", 			PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Date", 		Hidden : 0, Width : 100, Align : "Center", ColMerge : 0, SaveName : "cre_dt", 			KeyField : 0, CalcLogic : "", Format : "Ymd", 		PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }
				];
				InitColumns(cols);
				SetEditable(1);
				SetColProperty("delt_flg", { ComboText : "Y|N", ComboCode : "Y|N" });
				resizeSheet(sheetObj);
			}
			break;
	}
}
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH:
			ComOpenWait(true);
			if (validateForm(sheetObj, formObj, sAction) != true) {
				ComOpenWait(false);
				break;
			}
			formObj.f_cmd.value = SEARCH;
			var sParam = FormQueryString(formObj);
			sheetObj.DoSearch("ESD_TRS_0802GS.do", sParam);
			ComOpenWait(false);
			break;
		case SEARCH01:
			formObj.f_cmd.value = SEARCH01;
			var sParam = FormQueryString(formObj);
			var arrXml = sheetObj.GetSearchData("ESD_TRS_0801GS.do", sParam);
			if (arrXml.length > 0) {
				var valResult = ComGetTotalRows(arrXml);
				if (valResult == 1) {
					return 'S';
				} else {
					return 'F';
				}
			}
			break;
		case MULTI:
			ComOpenWait(true, true);
			if (validateForm(sheetObj, formObj, sAction) != true) {
				ComShowCodeMessage('BKG00167');
				ComOpenWait(false, false);
				break;
			}

			formObj.f_cmd.value = MULTI;
			var sParam = sheetObj.GetSaveString(false, true, "ibflag");
			var sXml = sheetObjects[0].GetSaveData("ESD_TRS_0802GS.do", "f_cmd=" + MULTI + "&" + sParam);
			var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			if (State != "S") {
				ComShowMessage(ComResultMessage(sXml));
				ComOpenWait(false, false);
				return false;
			}
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			ComOpenWait(false, false);
			break;
		case "btn_exceldown":
			sheetObj.Down2Excel({ HiddenColumn : 1 });
			break;
	}
}
function validateForm(sheetObj, formObj, sAction) {
	var sheet1RowCnt = sheetObj.RowCount();
	switch (sAction) {
		case MULTI: {
			if (!ComChkValid(formObj))
				return false;
			if (sheetObj.ColValueDup("stcc_cd|stcc_seq") > 0) {
				var Msg = "STCC Code and STCC Seq";
				ComShowCodeMessage('COM131302', Msg);
				return false;
			}
			break;
		}
	}
	return true;
}
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = ComGetEvent("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
}
function addRow(formObj) {
	with (sheetObjects[0]) {
		var nowRow = GetSelectRow();
		nowRow = DataInsert(-1);
		SetCellValue(nowRow, "delt_flg", "N", 0);
		return true;
	}
}
/**
 * row delete
 */
function deleteRow() {
	with (sheetObjects[0]) {
		var sRowStr = FindCheckedRow("check");
		var arr = sRowStr.split("|");
		for ( var i = 0; i < arr.length; i++) {
			SetRowStatus(arr[i], "D");
			SetRowHidden(arr[i], "1");
		}
	}
}
function obj_KeyPress() {
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	var srcName = ComGetEvent("name");
	var srcValue = event.srcElement.getAttribute("value");
	switch (event.srcElement.dataformat) {
		case "engup": {
			ComKeyOnlyAlphabet('upper');
			break;
		}
	}
}
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	if (sheetObj.GetCellValue(Row, Col) == null || sheetObj.GetCellValue(Row, Col) == "")
		return;
	if (sheetObj.ColSaveName(Col) == "pck_grp_val_cd") {
		if (sheetObj.ColSaveName(Col) == "pck_grp_val_cd") {
			formObj.frm_intg_cd_id.value = "CD02709";
			formObj.frm_intg_cd_val_ctnt.value = sheetObj.GetCellValue(Row, Col);
		}
		var result = doActionIBSheet(sheetObj, formObj, SEARCH01);
		if (result == 'F') {
			ComShowCodeMessage('COM130402', "[" + sheetObj.GetCellValue(Row, Col) + "] ");
			formObj.frm_intg_cd_id.value = "";
			formObj.frm_intg_cd_val_ctnt.value = "";
			sheetObj.SetCellValue(Row, Col, "");
		}
	}
}

function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
	if (isExceedMaxRow(msg)) {
		return;
	}
}
