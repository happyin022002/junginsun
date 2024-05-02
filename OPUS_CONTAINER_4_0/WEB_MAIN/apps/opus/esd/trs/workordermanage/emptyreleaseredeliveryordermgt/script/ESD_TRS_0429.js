/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0429.js
 *@FileTitle  : Release/Re-delivery Order
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/04/08
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
var sheet2_errMsg = "";
var onShowErrMsg = false;

document.onclick = processButtonClick;
var childObject ;

function processButtonClick() {
	var sheetObj = sheetObjects[0];
	var frmObj = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_Calendar":
				var cal = new ComCalendarFromTo();
				cal.select(frmObj.p_date1, frmObj.p_date2, 'yyyy-MM-dd');
				break;
			case "btn_retrieve": {
				doActionIBSheet(sheetObj, frmObj, IBSEARCH);
				break;
			}
			case "btn_new": {
				ComResetAll();
				p_yard2.RemoveAll();
				break;
			}
			case "btn_downExcel":
				sheetObj.Down2Excel({ HiddenColumn : -1 });
				break;
			case "btn_settled": {
				ComOpenWait(true);
				doActionIBSheet(sheetObj, frmObj, IBSAVE);
				ComOpenWait(false);
				break;
			}
			case "btn_preview": {
				with (sheetObj) {
					if (CheckedRows("Sel") < 1) {
						ComShowCodeMessage("TRS90419");
						return;
					} else {
						var arr = FindCheckedRow("Sel").split("|");
						for ( var i = 0; i < arr.length; i++) {
							if (GetCellValue(arr[i], "empty_cy") == "") {
								ComShowCodeMessage("TRS90447");
								return;
							} else if (i > 0 && GetCellValue(arr[i], "empty_cy") != GetCellValue(arr[0], "empty_cy")) {
								ComShowCodeMessage("TRS90449");
								return;
							} else if (i > 0 && GetCellValue(arr[i], "wo_no") != GetCellValue(arr[0], "wo_no")) {
								ComShowCodeMessage("TRS90485");
								return;
							} else if (GetCellValue(arr[i], "pd_date") == "" || !ComIsDate(GetCellValue(arr[i], "pd_date"))) {
								ComShowCodeMessage("TRS90448");
								return;
							} else if (!GetColHidden("qty") && (GetCellValue(arr[i], "qty") == "" || GetCellValue(arr[i], "qty") < 1 || GetCellValue(arr[i], "qty") > GetCellValue(arr[i], "o_qty"))) {
								ComShowCodeMessage("TRS90446");
								return;
							}
						}
						ComOpenPopup("ESD_TRS_0451.do", 800, 700, "", "0,0", true);
					}
					break;
				}
			}
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}

function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	sheetObjects[0].SetColHidden("lstm_cd", 1);
	doActionIBSheet(sheetObjects[0], document.form, COMMAND05);
	document.form.p_date1.focus();
}

/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	with (sheetObj) {
		var HeadTitle = "s||No.|stk_iss_cd|I.Office|BD|Mode|Type|POL|POD|Empty CY|S/P|P/D Date|Container No.|Slot Ref No.|Q'ty|O.Q'ty|TP|Term|CB|Empty Dest|Fax No.|E-mail Address|Office|User ID";
		HeadTitle += "|Issue Date|Fax Result|E-mail Result|Booking No.|B/L No.|VVD Code|W/O No.|Special Instruction|SHPR Name|CNEE Name|NTFY Name";
		HeadTitle += "|org_empty_cy|pd_date|tro_seq|bd|type_cd|so_ofc_cty_cd|so_seq|vndr_lgl_eng_nm|ref_id|trsp_cost_dtl_mod_cd";

		SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 12, DataRowMerge : 1 });
		var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
		var headers = [ { Text : HeadTitle, Align : "Center" }];
		InitHeaders(headers, info);
		var cols = [
				{ Type : "Status", Hidden : 1, Width : 0, Align : "Center", ColMerge : 0, SaveName : "ibflag", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0  },
				{ Type : "DummyCheck", Hidden : 0, Width : 30, Align : "Center", ColMerge : 0, SaveName : "Sel", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit :1  }, 
				{ Type : "Seq",  Hidden : 0, Width : 30,  Align : "Right", 	ColMerge : 0, SaveName : "Seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0  },
				{ Type : "Text", Hidden : 1, Width : 30,  Align : "Center", ColMerge : 0, SaveName : "stk_iss_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0  },
				{ Type : "Text", Hidden : 0, Width : 60,  Align : "Center", ColMerge : 0, SaveName : "i_office", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 0, Width : 60,  Align : "Center", ColMerge : 0, SaveName : "bd_disp", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 0, Width : 40,  Align : "Center", ColMerge : 0, SaveName : "mode_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 0, Width : 60,  Align : "Center", ColMerge : 0, SaveName : "type_disp", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 0, Width : 60,  Align : "Center", ColMerge : 0, SaveName : "pol", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 0, Width : 60,  Align : "Center", ColMerge : 0, SaveName : "pod", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 0, Width : 80,  Align : "Center", ColMerge : 0, SaveName : "empty_cy", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 7, AcceptKeys : "E|N", InputCaseSensitive : 1 },
				{ Type : "Text", Hidden : 0, Width : 60,  Align : "Center", ColMerge : 0, SaveName : "s_p", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 0, Width : 80,  Align : "Center", ColMerge : 0, SaveName : "pd_date_disp", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 10 },
				{ Type : "Text", Hidden : 0, Width : 90,  Align : "Center", ColMerge : 0, SaveName : "cntr_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 0, Width : 90,  Align : "Center", ColMerge : 0, SaveName : "cntr_slt_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 1, Width : 40,  Align : "Center", ColMerge : 0, SaveName : "qty", KeyField : 0, CalcLogic : "", Format : "Int", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 3 },
				{ Type : "Text", Hidden : 1, Width : 40,  Align : "Center", ColMerge : 0, SaveName : "o_qty", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 0, Width : 30,  Align : "Center", ColMerge : 0, SaveName : "tp", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 1, Width : 50,  Align : "Center", ColMerge : 0, SaveName : "lstm_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 1, Width : 30,  Align : "Center", ColMerge : 0, SaveName : "cb", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 0, SaveName : "empty_dest", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 0, Width : 100, Align : "Left", 	ColMerge : 0, SaveName : "fax_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 20 },
				{ Type : "Text", Hidden : 0, Width : 150, Align : "Left", 	ColMerge : 0, SaveName : "email", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 50 },
				{ Type : "Text", Hidden : 0, Width : 60,  Align : "Center", ColMerge : 0, SaveName : "office", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 0, Width : 60,  Align : "Center", ColMerge : 0, SaveName : "user_id", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 0, Width : 120, Align : "Center", ColMerge : 0, SaveName : "issue_dt", KeyField : 0, CalcLogic : "", Format : "YmdHm", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 0, Width : 150, Align : "Left", 	ColMerge : 0, SaveName : "fax_rst", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 0, Width : 150, Align : "Left", 	ColMerge : 0, SaveName : "eml_rst", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 0, SaveName : "bkg_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 0, SaveName : "bl_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 0, Width : 80,  Align : "Center", ColMerge : 0, SaveName : "vvd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 0, Width : 80,  Align : "Center", ColMerge : 0, SaveName : "wo_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 0, Width : 120, Align : "Left", 	ColMerge : 0, SaveName : "spcl_inst", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 490 },
				{ Type : "Text", Hidden : 0, Width : 100, Align : "Left", 	ColMerge : 0, SaveName : "shpr", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 0, Width : 100, Align : "Left", 	ColMerge : 0, SaveName : "cnee", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 0, Width : 100, Align : "Left", 	ColMerge : 0, SaveName : "ntfy", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
				{ Type : "Text", Hidden : 1, Width : 70,  Align : "Center", ColMerge : 0, SaveName : "org_empty_cy", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0  }, 
				{ Type : "Text", Hidden : 1, Width : 70,  Align : "Center", ColMerge : 0, SaveName : "pd_date", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0  },
				{ Type : "Text", Hidden : 1, Width : 50,  Align : "Center", ColMerge : 0, SaveName : "tro_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0  }, 
				{ Type : "Text", Hidden : 1, Width : 30,  Align : "Center", ColMerge : 0, SaveName : "bd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0  },
				{ Type : "Text", Hidden : 1, Width : 40,  Align : "Center", ColMerge : 0, SaveName : "type_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0  }, 
				{ Type : "Text", Hidden : 1, Width : 50,  Align : "Center", ColMerge : 0, SaveName : "so_ofc_cty_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0  },
				{ Type : "Text", Hidden : 1, Width : 50,  Align : "Center", ColMerge : 0, SaveName : "so_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0  }, 
				{ Type : "Text", Hidden : 1, Width : 50,  Align : "Center", ColMerge : 0, SaveName : "vndr_lgl_eng_nm", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0  },
				{ Type : "Text", Hidden : 1, Width : 50,  Align : "Center", ColMerge : 0, SaveName : "ref_id", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0  },
				{ Type : "Text", Hidden : 1, Width : 50,  Align : "Center", ColMerge : 0, SaveName : "trsp_cost_dtl_mod_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0  }
		];
		InitColumns(cols);
		SetDataAutoTrim(1);
		SetCountPosition(0);
		if (sheetNo == 1) {
			ComResizeSheet(sheetObj);
		} else {
			SetVisible(false);
		}

	}
}

// handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	var frmObj = document.form;
	try {
		switch (sAction) {
			case IBSEARCH: {
				if(formObj.p_date1.value == '' || formObj.p_date2.value == '') {
					ComShowCodeMessage("COM130403", "Date");
					return;
				}
				if(!TrsComValidFormat("WO", formObj.wo_no.value, true)) { return false; }
				ComOpenWait(true);
				frmObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESD_TRS_0429GS.do", FormQueryString(frmObj));
				break;
			}
			case IBSAVE: {
				if (ComShowCodeConfirm("COM130101")) {
					frmObj.f_cmd.value = MULTI;
					sheetObj.DoSave("ESD_TRS_0429GS.do", FormQueryString(frmObj), "Sel");
				}
				break;
			}
			case MULTI02: {
				sheet2_errMsg = "";
				if (frmObj.issue_type.value == "D") {
					var sRowStr = sheetObj.FindCheckedRow("Sel");
					var arr = sRowStr.split("|");
					var xml = sheetObj.GetSearchData("ESD_TRS_0429GS.do", "f_cmd=" + MULTI03 + "&empty_cy=" + sheetObj.GetCellValue(arr[0], "empty_cy") + "&trsp_cost_dtl_mod_cd=" + sheetObj.GetCellValue(arr[0], "trsp_cost_dtl_mod_cd"));
					var ediYardSetup = ComGetEtcData(xml, "edi_yard_setup");
					var yardCd = ComGetEtcData(xml, "yard_cd");
					if (ediYardSetup == "Y") {
						frmObj.f_cmd.value = MULTI02;
						sheetObj.DoSave("ESD_TRS_0429GS.do", FormQueryString(frmObj), "Sel", false);
					} else {
						ComShowCodeMessage("TRS90444", yardCd);
						sheet2_errMsg = "no EDI connection err";
					}
				} else {
					frmObj.f_cmd.value = MULTI02;
					sheetObj.DoSave("ESD_TRS_0429GS.do", {Param : FormQueryString(frmObj), Col:"Sel", Quest:false });
				}
				break;
			}
			case COMMAND05: {
				frmObj.sender_usr_cnt.value = ComSearchEtcData(sheetObj, "CTMCommonGS.do", "f_cmd=" + COMMAND05, "rtnValue");
				break;
			}
		}
	} catch(e) {
		ComOpenWait(false);
	}
}
/**
 * handling OnChange event in HTML Object
 */
function obj_onchange(event) {
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	var frmObj = document.form;
	var sheetObj = sheetObjects[0];
	switch (ComGetEvent("name")) {
		case "type":
			with (sheetObj) {
				if (frmObj.type.value == "RDV") { // in case of Re-Delivery
					SetCellText(0, "MTYDest", "Empty Org");
					SetColHidden("qty", 1);
					SetColHidden("q_qty", 1);
					SetColHidden("lstm_cd", 0);
				} else { // in case of Release
					SetCellText(0, "MTYDest", "Empty Dest");
					SetColHidden("qty", 0);
					SetColHidden("q_qty", 0);
					SetColHidden("lstm_cd", 1);
				}
			}
			break;
	}
}
/**
 * handling OnKeyUp event in HTML Object
 */
function obj_onkeyup(event) {
	srcValue = ComGetEvent("value");
	var frmObj = document.form;
	var sheetObj = sheetObjects[0];
	switch (ComGetEvent("name")) {
		case "yd_cd_disp":
			var ydCdDisp = frmObj.yd_cd_disp;
			var pYard2 = document.getElementById("p_yard2");
			if (ydCdDisp.value.length > 1) {
				frmObj.p_yard1.value = ydCdDisp.value.toUpperCase();
				if (ydCdDisp.value.length > 4) {
					if (!yard_search()) {
						ydCdDisp.select();
						ydCdDisp.focus();
					} else {
						frmObj.p_yard2.focus();
					}
				} else {
					pYard2.RemoveAll();
				}
			} else {
				frmObj.p_yard1.value = "";
				pYard2.RemoveAll();
			}
			break;
	}
	onShowErrMsg = false;
}

function yard_search() {
	formObj = document.form;
	p_yard = formObj.p_yard1.value;
	if (p_yard.length == 5) {
		if (onShowErrMsg) {
			onShowErrMsg = false;
			return false;
		}
		onShowErrMsg = true;
		var sheetObj = sheetObjects[0];
		formObj.f_cmd.value = SEARCH11;
		xml = sheetObj.GetSearchData("CTMCommonGS.do", FormQueryString(formObj));
		rtnValue = ComGetEtcData(xml, "rtnValue");
		svrChk = ComGetEtcData(xml, "svrChk");
		obj = p_yard2;
		if (obj == null || obj == 'null')
			return false;
		if (rtnValue == null) {
			obj.RemoveAll();
			sheetObj.LoadSearchData(xml, { Sync : 1 });
			return false;
		} else {
			parseYardMultiCombo(rtnValue, obj);
			return true;
		}
	} else
		return false;
}

function parseYardMultiCombo(YardCode, comboObj) {
	if (!YardCode)
		return;
	var YardList = YardCode.split("^");
	comboObj.RemoveAll();
	for (i = 0; i <= YardList.length; i++) {
		if (YardList[i]) {
			YardValue = YardList[i].split("|");
			comboObj.InsertItem(i, YardValue[0] + "|" + YardValue[1], YardValue[0]);
		}
	}
	comboObj.SetUseAutoComplete(1);
}
/**
 * handling OnSearchEnd event in Sheet1
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if (ErrMsg == "") {
		with (sheetObj) {
			if (RowCount() > 0) {
				for ( var i = 1; i < RowCount() + 1; i++) {
					if (document.form.issued.value == "Y") {
						SetCellEditable(i, "empty_cy", 0);
						SetCellEditable(i, "qty", 0);
					} else {
						if (GetCellValue(i, "type_cd") != "M") {
							SetCellEditable(i, "empty_cy", 0);
						}
					}
				}
			}
		}
	}
	sheetObjects[1].RemoveAll();
	ComOpenWait(false);
}
function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	if (sheetObj.ColSaveName(Col) != "Sel") {
		with (sheetObj) {
			var sRowStr = GetSelectionRows("/");
			var arr = sRowStr.split("/");
			if (arr.length > 1) {
				for (i = 0; i < arr.length; i++) {
					SetCellValue(arr[i], "Sel", "1", 0);
				}
			}
		}
	}
}
/**
 * handling OnChange event in Sheet
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var frmObj = document.form;
	with (sheetObj) {
		if (ColSaveName(Col) != "Sel") {
			SetCellValue(Row, "Sel", "1", 0);
		}
		switch (ColSaveName(Col)) {
			case "empty_cy":
				var xml = sheetObj.GetSearchData("ESD_TRS_0429GS.do", "f_cmd=" + SEARCH02 + "&empty_cy=" + GetCellValue(Row, Col));
				if (!ComGetEtcData(xml, "ydCd")) {
					LoadSearchData(xml, { Sync : 1 });
					SetCellValue(Row, Col, CellSearchValue(Row, Col), 0);
					SelectCell(Row, Col, true);
				} else {
					SetCellValue(Row, "fax_no", ComGetEtcData(xml, "faxNo"));
					SetCellValue(Row, "email", ComGetEtcData(xml, "ydEml"));
				}
				break;
			case "pd_date_disp":
				if (!ComIsDate(GetCellText(Row, Col))) {
					ComShowCodeMessage("TRS90445");
					SelectCell(Row, Col, true, GetCellValue(Row, "pd_date"));
				} else {
					SetCellValue(Row, "pd_date", GetCellText(Row, Col), 0);
				}
				break;
			case "qty":
				if (GetCellValue(Row, Col) == "" || GetCellValue(Row, Col) < 1 || GetCellValue(Row, Col) > GetCellValue(Row, "o_qty")) {
					ComShowCodeMessage("TRS90446");
					SelectCell(Row, Col, true, CellSearchValue(Row, Col));
				}
				break;
		}
	}
}
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if (ErrMsg == "") {
		ComShowCodeMessage("TRS90417", "Release/Redelivery Order");
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
	}
}
/**
 * 
 * @param sheetObj
 * @param Code
 * @returns
 */
function sheet2_OnSaveEnd(sheetObj, Code) {
	if(Code == 0) {
		childObject.fnParentComfirmMsg();
	}
}
/**
 * handling OnKeyDown event in p_yard2[combo1]
 */
function p_yard2_OnKeyDown(comboObj, KeyCode, Shift) {
	if (KeyCode == 13) {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}

/**
 * Manage "To Date" by "From Date"
 * 
 * @param obj
 */
function getDateBetween(obj) {
    if(obj.value == ""){
        document.form.p_date2.value="";
    }else{
        document.form.p_date2.value=ComGetDateAdd(obj.value, "D", 30);  
    }
}