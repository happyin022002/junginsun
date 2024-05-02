/*
=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : EES_MST_0035.js
 *@FileTitle  : Container Check Digit and Container Checking Inquiry 
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/04
=========================================================
 */
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @fileoverview 
 * @author 
 */
/**
 * @extends
 * @class ees_mst_0035 : business script for ees_mst_0035
 */
function ees_mst_0035() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}


// common static variable
var sheetObjects = new Array();
var sheetCnt = 0;
var aa = false;
// Event handler processing by button click event */
document.onclick = processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName))
			return false;
		switch (srcName) {
		case "btn_retrieve":
			formObject.cntr_no.value = "";
			for ( var i = 1; i <= sheetObject1.RowCount(); i++) {
				if (formObject.cntr_no.value == "") {
					formObject.cntr_no.value = sheetObject1.GetCellValue(i, 0);
				} else {
					formObject.cntr_no.value = formObject.cntr_no.value + ","
							+ sheetObject1.GetCellValue(i, 0);
				}
			}
			if (sheetObject1.RowCount() > 0) {
				doActionIBSheet(sheetObject1, document.form, IBSEARCH);
			} else {
				ComShowCodeMessage("MST00001", "Row");
				return;
			}
			break;
		case "btn_new":
			sheetObject1.RemoveAll();
			// Inserting Ten Rows as Default
			for ( var j = 0; j < 10; j++) {
				sheetObject1.DataInsert();
			}
			sheetObject1.SelectCell(1, 0);
			break;
		case "btn_loadexcel":
			// var aa = sheetObject1.LoadExcel({
			// Mode:"NoHeader",WorkSheetNo:"1",WorkSheetName:"",Append:false});
			sheetObject1.RemoveAll();
			var aa = sheetObject1.LoadExcel({
				Mode : "HeaderMatch",
				WorkSheetNo : "1",
				WorkSheetName : "",
				Append : false
			});

			break;
		case "btn_downexcel":
			if (sheetObject1.RowCount() < 1) {// no data
				ComShowCodeMessage("COM132501");
			} else {
				// sheetObject1.Down2Excel();
				sheetObject1.Down2Excel({
					DownCols : makeHiddenSkipCol(sheetObject1),
					SheetDesign : 1,
					Merge : 1,
					KeyFieldMark : 0
				});
			}
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}


/**
 * registering IBsheet Object as list adding process for list in case of needing
 * batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}


/**
 * initializing sheet implementing onLoad event handler in body tag adding
 * first-served functions after loading screen.
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	// Inserting Ten Rows as Default
	for ( var j = 0; j < 10; j++) {
		sheetObjects[0].DataInsert();
	}

	sheetObjects[0].SelectCell(1, 0);
}


/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case
 * as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
	var info = {
		AcceptKeys : "E|N|",
		InputCaseSensitive : 1
	};
	switch (sheetID) {
	case "sheet1": // sheet1 init
		with (sheetObj) {
			var HeadTitle = "CNTR No.|Check Digit|RGST CNTR No.|Full CNTR No.|TP/SZ|Term|Movement|Yard|MVMT Date|Status|AMGT No.|Lessor|User|F/M|DMG|HRT|HBT|HBQ|DP|IM|LS|UC|PF|";
			SetConfig({
				SearchMode : 2,
				MergeSheet : 5,
				Page : 20,
				DataRowMerge : 1
			});
			var info = {
				Sort : 1,
				ColMove : 1,
				HeaderCheck : 0,
				ColResize : 1
			};
			var headers = [ {
				Text : HeadTitle,
				Align : "Center"
			} ];
			InitHeaders(headers, info);
			var cols = [ {
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cntr_no",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 10
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 0,
				SaveName : "chk_dgt",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "rgst_cntr_no",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 11
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "full_cntr_no",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 11
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 75,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cntr_tpsz_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 0,
				SaveName : "lstm_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 75,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cnmv_sts_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 0,
				SaveName : "crnt_yd_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cnmv_date",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 75,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cntr_sts_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 80,
				Align : "Center",
				ColMerge : 0,
				SaveName : "agmt_no",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 150,
				Align : "Left",
				ColMerge : 0,
				SaveName : "vndr_abbr_nm",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 75,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cntr_use_co_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 40,
				Align : "Center",
				ColMerge : 0,
				SaveName : "full_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 40,
				Align : "Center",
				ColMerge : 0,
				SaveName : "dmg_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 40,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cntr_hngr_rck_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 40,
				Align : "Center",
				ColMerge : 0,
				SaveName : "mnr_hngr_bar_tp_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 40,
				Align : "Center",
				ColMerge : 0,
				SaveName : "cntr_hngr_bar_atch_knt",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 40,
				Align : "Center",
				ColMerge : 0,
				SaveName : "disp_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 40,
				Align : "Center",
				ColMerge : 0,
				SaveName : "imdt_ext_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 40,
				Align : "Center",
				ColMerge : 0,
				SaveName : "ls_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 40,
				Align : "Center",
				ColMerge : 0,
				SaveName : "uc_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 2
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 40,
				Align : "Center",
				ColMerge : 0,
				SaveName : "plst_flr_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 2
			} ];
			InitColumns(cols);
			SetEditable(1);
			SetColProperty(0, "cntr_no", {
				AcceptKeys : "E|N",
				InputCaseSensitive : 1
			});
			// SetSheetHeight(460);
			resizeSheet();
		}
		break;
	}
}


// handling process for sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // retrieve
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		var xml = "";
		xml = sheetObj.GetSearchData("EES_MST_0035GS.do", 
				FormQueryString(formObj));
		sheetObj.LoadSearchData(xml, {
			Sync : 0
		});
		ComOpenWait(false);
		break;
	}
}


/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	return true;
}


function sheet1_OnKeyUp(SheetObj, Row, Col, KeyCode, Shift) {
	var sName = SheetObj.ColSaveName(Col);
	if (sName == "cntr_no") {

		var celltxt = SheetObj.GetEditText().toUpperCase();
		var celltxt1 = SheetObj.GetCellValue(Row, 0).toUpperCase();
		if (celltxt == "" && celltxt1 != "") {
			celltxt = celltxt1;
		}
		if (celltxt.length == 10 || KeyCode == 13) {
			SheetObj.SetCellValue(Row, 0, celltxt, 0);
			var formObject = document.form;
			formObject.cntr_no.value = "";
			for ( var i = 1; i <= SheetObj.RowCount(); i++) {
				if (formObject.cntr_no.value == "") {
					formObject.cntr_no.value = SheetObj.GetCellValue(i, 0);
				} else {
					formObject.cntr_no.value = formObject.cntr_no.value + ","
							+ SheetObj.GetCellValue(i, 0);
				}
			}
			if (SheetObj.RowCount() > 0) {
				doActionIBSheet(SheetObj, formObject, IBSEARCH);
			} else {
				ComShowCodeMessage("MST00001", "Row");
				return;
			}
		}
	}
}


function resizeSheet() {
	ComResizeSheet(sheetObjects[0]);
}


function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
	if (isExceedMaxRow(msg))
		return;
	if (result) {
		var formObject = document.form;
		var sheetObject1 = sheetObj;
		formObject.cntr_no.value = "";
		for ( var i = 1; i <= sheetObject1.RowCount(); i++) {
			if (formObject.cntr_no.value == "") {
				formObject.cntr_no.value = sheetObject1.GetCellValue(i,
						"cntr_no");
			} else {
				formObject.cntr_no.value = formObject.cntr_no.value + ","
						+ sheetObject1.GetCellValue(i, "cntr_no");
			}
		}
		if (sheetObject1.RowCount() > 0) {
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
		} else {
			return;
		}
	}
}