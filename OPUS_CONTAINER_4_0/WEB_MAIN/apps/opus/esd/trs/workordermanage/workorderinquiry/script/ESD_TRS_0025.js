/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0025.js
 *@FileTitle  :  W/O issued Inquiry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/29
=========================================================*/

var sheetObjects = new Array();
var sheetCnt = 0;
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;
			case "btn_reset":
				sheetObject.RemoveAll();
				sheetObjects[1].RemoveAll();
				formObject.reset();
				break;
			case "btn_minimize":
				if (document.all.MiniLayer.style.display != "none") {
					document.all.MiniLayer.style.display = "none";
				} else {
					document.all.MiniLayer.style.display = "";
				}
				ComResizeSheet(sheetObject);
				break;
			case 'btns_wo_no':
				rep_Multiful_inquiry(srcName);
				break;
			case "btng_provider":
				rep_OnPopupClick();
				break;
			case "btng_downexcel":
				doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
				break;
			case "btng_detailinquiry": {
				goSoInquiry(sheetObjects[1], formObject);
				break;
			}
			case "btng_wopreview": {
				goWoPreview(sheetObjects[1], formObject);
				break;
			}
			case 'btns_calendar':
				getCalendar();
				break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('COM12111');
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
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
}

/**
 * Sheet, the initial setting, the header definition initSheet
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
		case 1: {
			with (sheetObj) {
				var HeadTitle = "Seq.||S/N|W/O No.|Cost\nMode|Trans\nMode|S/P\nCode|S/P\nName|W/O TRSP. STS|W/O\nIssue\nStatus|W/O\nIssue\nStatus|Issue\ntype|";
				HeadTitle += "W/O\nIssue\nTime|W/O\nIssue\nOffice|W/O\nCreation\nUser ID|W/O\nCreation\nUser Name|";
				HeadTitle += "From|From|Via|Via|To|To|Door|Door|";
				HeadTitle += "Currency|Basic|Negotiated|Fuel|Additional |Total|Fax 1 Number|Fax 1 Status|Fax 2 Number|";
				HeadTitle += "Fax 2 Status|Fax 3 Number|Fax 3 Status|E-Mail 1 Add|E-Mail 1 Status|E-Mail 2 Add|E-Mail 2 Status";
				HeadTitle += "|E-Mail 3 Add|E-Mail 3 Status|EDI Result|EDI Receive Date";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 4, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [{ Text : HeadTitle, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [
							{ Type : "Seq",   	Hidden : 0, Width : 30, 	Align : "Center", ColMerge : 0, SaveName : "seq", 					KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 0 },
							{ Type : "Radio", 	Hidden : 0, Width : 30, 	Align : "Center", ColMerge : 0, SaveName : "wo_check", 				KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 30, 	Align : "Center", ColMerge : 0, SaveName : "wo_iss_knt", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 90, 	Align : "Center", ColMerge : 0, SaveName : "trsp_wo_ofc_cty_cd", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 70, 	Align : "Center", ColMerge : 0, SaveName : "trsp_cost_dtl_mod_nm", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 75, 	Align : "Center", ColMerge : 0, SaveName : "trsp_crr_mod_nm", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 100,	Align : "Center", ColMerge : 0, SaveName : "wo_vndr_seq", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 200,	Align : "left",   ColMerge : 0, SaveName : "vndr_nm", 				KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 100,	Align : "Center", ColMerge : 0, SaveName : "wo_trsp_sts_cd", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 1, Width : 100,	Align : "Center", ColMerge : 0, SaveName : "wo_iss_sts_cd", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 100,	Align : "Center", ColMerge : 0, SaveName : "wo_iss_sts_cd_nm", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 80, 	Align : "Center", ColMerge : 0, SaveName : "wo_iss_tp", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 130,	Align : "Center", ColMerge : 0, SaveName : "wo_iss_dt", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 90, 	Align : "Center", ColMerge : 0, SaveName : "cre_ofc_cd", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 80, 	Align : "Center", ColMerge : 0, SaveName : "upd_usr_id", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 150,	Align : "left",   ColMerge : 0, SaveName : "upd_usr_nm", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 80, 	Align : "Center", ColMerge : 0, SaveName : "fm_nod_cd", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 1, Width : 130, 	Align : "Center", ColMerge : 0, SaveName : "fm_nod_cd_nm", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 80, 	Align : "Center", ColMerge : 0, SaveName : "via_nod_cd", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 1, Width : 130, 	Align : "Center", ColMerge : 0, SaveName : "via_nod_cd_nm", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 80, 	Align : "Center", ColMerge : 0, SaveName : "to_nod_cd", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 1, Width : 130, 	Align : "Center", ColMerge : 0, SaveName : "to_nod_cd_nm", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 80, 	Align : "Center", ColMerge : 0, SaveName : "dor_nod_cd", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 130, 	Align : "Center", ColMerge : 0, SaveName : "dor_nod_cd_nm", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 80, 	Align : "Center", ColMerge : 0, SaveName : "curr_cd", 				KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Float",	Hidden : 0, Width : 100,	Align : "Right",  ColMerge : 0, SaveName : "bzc_amt", 				KeyField : 0, CalcLogic : "", Format : "NullFloat", PointCount : 2, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Float",	Hidden : 0, Width : 100,	Align : "Right",  ColMerge : 0, SaveName : "nego_amt", 				KeyField : 0, CalcLogic : "", Format : "NullFloat", PointCount : 2, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Float",	Hidden : 0, Width : 100,	Align : "Right",  ColMerge : 0, SaveName : "fuel_scg_amt", 			KeyField : 0, CalcLogic : "", Format : "NullFloat", PointCount : 2, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Float",	Hidden : 0, Width : 100,	Align : "Right",  ColMerge : 0, SaveName : "etc_add_amt", 			KeyField : 0, CalcLogic : "", Format : "NullFloat", PointCount : 2, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Float",	Hidden : 0, Width : 120,	Align : "Right",  ColMerge : 0, SaveName : "total", 				KeyField : 0, CalcLogic : "", Format : "NullFloat", PointCount : 2, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 100,	Align : "left",   ColMerge : 0, SaveName : "wo_n1st_fax_no", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 100,	Align : "Center", ColMerge : 0, SaveName : "fax1_sts_cd", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 100,	Align : "left",   ColMerge : 0, SaveName : "wo_n2nd_fax_no", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 100,	Align : "Center", ColMerge : 0, SaveName : "fax2_sts_cd", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 100,	Align : "left",   ColMerge : 0, SaveName : "wo_n3rd_fax_no", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 110,	Align : "Center", ColMerge : 0, SaveName : "fax3_sts_cd", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 100,	Align : "left",   ColMerge : 0, SaveName : "wo_n1st_eml", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 100,	Align : "Center", ColMerge : 0, SaveName : "eml1_sts_cd", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 100,	Align : "left",   ColMerge : 0, SaveName : "wo_n2nd_eml", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 110,	Align : "Center", ColMerge : 0, SaveName : "eml2_sts_cd", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 100,	Align : "left",   ColMerge : 0, SaveName : "wo_n3rd_eml", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 0, Width : 110,	Align : "Center", ColMerge : 0, SaveName : "eml3_sts_cd", 			KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 1, Width : 100,	Align : "Center", ColMerge : 0, SaveName : "edi_rcv_rslt_cd", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 1, Width : 130,	Align : "Center", ColMerge : 0, SaveName : "edi_rcv_rslt_dt", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 1, Width : 0, 		Align : "Center", ColMerge : 0, SaveName : "max_knt", 				KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 1, Width : 0,	 	Align : "Center", ColMerge : 0, SaveName : "trsp_cost_dtl_mod_cd", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 0 },
							{ Type : "Text", 	Hidden : 1, Width : 0, 		Align : "Center", ColMerge : 0, SaveName : "trsp_crr_mod_cd", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 0 }
				];
				InitColumns(cols);
				SetEditable(1);
				ComResizeSheet(sheetObj);
			}
			break;
		}
		case 2: {
			with (sheetObj) {
				var HeadTitle = "Seq.||S/N|W/O No.|Cost Mode|Trans Mode|Vendor|Vendor|W/O ISS STS|W/O ISS TP|W/O ISS Time|W/O ISS OFC|W/O ISS ID|User NM|Fax 1 Number|Fax 1 Status|Fax 2 Number|Fax 2 Status|Fax 3 Number|Fax 3 Status|E-Mail 1 Add|E-Mail 1 Status|E-Mail 2 Add|E-Mail 2 Status|E-Mail 3 Add|E-Mail 3 Status";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
				var headers = [
					{ Text : HeadTitle, Align : "Center" }
				];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "Status", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "ibflag" }, { Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "trsp_so_ofc_cty_cd" },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "trsp_so_seq" }, { Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "wo_cxl_flg" },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "dtn_use_flg" }, { Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "wo_bl_no_iss_flg" }
				];
				InitColumns(cols);
				SetEditable(0);
				SetVisible(0);
			}
			break;
		}
	}
}

// Sheet processing-related processes
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH: {
			var iWoNo = formObj.wo_no.value;
			if (ComIsNull(iWoNo)) {
				if (ComIsNull(formObj.fmdate) || ComIsNull(formObj.todate) || ComIsNull(formObj.wo_issue_office)) {
					ComShowMessage(ComGetMsg('TRS90372'));
					return false;
				}
			} 
			if(!TrsComValidFormat("WO", iWoNo, true)) { return false; }
			var fmdata = formObj.fmdate.value;
			var todate = formObj.todate.value;
			if (!ComIsNull(fmdata) && !ComIsNull(todate)) {
				replaceDateField(formObj);
				var days_between = ComGetDaysBetween(formObj.fmdate, formObj.todate);
				if (days_between < 0) {
					ComShowCodeMessage("TRS90118");
					formObject.from_date.focus();
					replaceHypenDateField(formObj, fmdata, todate);
					return false;
				}
				if (days_between > 30) {
					ComShowCodeMessage("TRS90424");
					replaceHypenDateField(formObj, fmdata, todate);
					return false;
				}
			}
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESD_TRS_0025GS.do", TrsFrmQryString(formObj));
			break;
		}
		case IBDOWNEXCEL: {
			if (validateForm(sheetObj, formObj, sAction)) {
				if (sheetObj.RowCount() < 1) {
					ComShowCodeMessage("COM132501");
				} else {
					sheetObj.Down2Excel({ DownCols : makeHiddenSkipCol_TRS(sheetObj), CheckBoxOnValue : 'Y', CheckBoxOffValue : 'N', SheetDesign : 1, Merge : 1 });
				}
			}
			break;
		}
	}
}
function replaceDateField(formObj) {
	formObj.fmdate.value = formObj.fmdate.value.split('-').join('');
	formObj.todate.value = formObj.todate.value.split('-').join('');
}
function replaceHypenDateField(formObj, fmdate, todate) {
	formObj.fmdate.value = fmdate;
	formObj.todate.value = todate;
}
/*
 * Viewed in preview
 */
function goWoPreview(sheetObj, formObj) {
	var sheetObj0 = sheetObjects[0];
	var chkRows = sheetObj0.FindCheckedRow("wo_check");
	var arrRow = chkRows.split("|");
	var knt_wo_no = '';
	if (chkRows.length < 1) {
		var errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return;
	}
	var totalCnt = 0;
	for (idx = 0; idx < arrRow.length; idx++) {
		var chkMax = sheetObj0.GetCellValue(arrRow[idx], "seq");
		if (sheetObj0.GetCellValue(chkMax, 'max_knt') != sheetObj0.GetCellValue(chkMax, 'wo_iss_knt')) {
			ComShowMessage("Seq " + chkMax + " is not lastest Work Order Data!!");
			return false;
		}
		if(sheetObj0.GetCellValue(chkMax, 'wo_iss_sts_cd') == 'N') {
			ComShowMessage(ComGetMsg("TRS90321"));
			return false;
		}
		knt_wo_no = sheetObj0.GetCellValue(chkMax, 'trsp_wo_ofc_cty_cd');
		totalCnt++;
	}
	if(totalCnt > 1) {
		ComShowMessage(ComGetMsg("COM12177"));
		return false;
	}
	ComOpenWindow("ESD_TRS_0024_POP.screen?wo_no_a=" + knt_wo_no, 'P_PREVIEW', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogWidth:1060px;dialogHeight:800px', true);
}

/*
 * Viewed from so inquiry
 */
function goSoInquiry(sheetObj, formObj) {
	var sheetObj0 = sheetObjects[0];
	var chkRows = sheetObj0.FindCheckedRow("wo_check");
	var arrRow = "";
	if (chkRows.length > 0) {
		arrRow = chkRows.split("|");
	}
	var knt_wo_no = "";
	var total_knt_wo_no = '';
	if (chkRows.length < 1) {
		var errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return;
	}
	for (idx = 0; idx < arrRow.length; idx++) {
		var chkMax = sheetObj0.GetCellValue(arrRow[idx], "seq");
		if (sheetObj0.GetCellValue(chkMax, "max_knt") != sheetObj0.GetCellValue(chkMax, "wo_iss_knt")) {
			ComShowMessage("Seq " + chkMax + " is not lastest Work Order Data!!");
			return;
		}
		knt_wo_no = sheetObj0.GetCellValue(chkMax, "trsp_wo_ofc_cty_cd");
		total_knt_wo_no = total_knt_wo_no + "," + knt_wo_no;
	}

	formObj.f_cmd.value = SEARCH01;
	formObj.wo_no_a.value = total_knt_wo_no;
	formObj.btn_go.value = "DETAIL";
	sheetObjects[1].DoSearch("ESD_TRS_0025GS.do", TrsFrmQryString(formObj));
}
/**
 * Pomipryeokgape screen validation process for handling
 */
function validateForm(sheetObj, formObj, sAction) {
	return true;
}
/**
 * Pop-up call rep_commodity
 */
function rep_Multiful_inquiry(btn_obj) {
	var formObject = document.form;
	var cmdt_cd_val = "";
	var rep_cmdt_cd_val = "";
	var cmdt_desc_val = "";
	var classId = "getTRS_ENS_906";
	var xx1 = btn_obj; 
	var xx2 = "";
	var xx3 = "";
	var xx4 = "";
	var xx5 = "";
	var xx6 = "";
	var xx7 = "";
	var xx8 = "";
	var xx9 = "";
	var returntitle = "";
	switch (btn_obj) {
		case "btns_wo_no": {
			returntitle = "Work Order No";
			break;
		}
	}
	var param = "?returnval=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9 + "&returntitle=" + returntitle;
	ComOpenPopup('ESD_TRS_0906.do' + param, 430, 410, "getTRS_ENS_906", "1,0", true);
}
/**
 * Location: In the single-selection pop-up hangyeongwoo.
 */
function getTRS_ENS_906(rowArray, x1) {
	var formObject = document.form;
	formObject.wo_no.value = rowArray;
}
function getCalendar() {
	var cal2 = new ComCalendarFromTo();
	cal2.displayType = "date";
	cal2.select(document.form.fmdate, document.form.todate, 'yyyy-MM-dd');
}
/**
 * Pop-up call rep_commodity
 */
function rep_OnPopupClick() {
	var formObject = document.form;
	var cmdt_cd_val = "";
	var rep_cmdt_cd_val = "";
	var cmdt_desc_val = "";
	var classId = "getCOM_ENS_rep";
	var xx1 = "";
	var xx2 = "";
	var xx3 = "";
	var xx4 = "";
	var xx5 = "";
	var xx6 = "";
	var xx7 = "";
	var xx8 = "";
	var xx9 = "";
	var param = "?conti_cd=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
	ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 700, 478, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * rep_commodity pop-up Call: hangyeongwoo single selection from a pop-up.
 */
function getCOM_ENS_rep(rowArray) {
	var formObj = document.form;
	for ( var i = 0; i < rowArray.length; i++) {
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[4];
		formObj.combo_svc_provider.value = colArray2;
		formObj.svc_provider.value = colArray3;
	}
}
/**
 * enter check
 */
function enterCheck(obj) {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	if (ComGetEvent("keycode") == 13) {
		switch (ComGetEvent("name")) {
			case 'combo_svc_provider':
				getTextVendorSeq(sheetObj, formObj, obj.value);
				break;
		}
	}
}
/**
 * Pop-up call ofc
 */
function ofc_OnPopupClick(val) {
	var formObject = document.form;
	var cmdt_cd_val = "";
	var rep_cmdt_cd_val = "";
	var cmdt_desc_val = "";
	var classId = "getCOM_ENS_so";
	var xx1 = val;
	var xx2 = "";
	var xx3 = "";
	var xx4 = "";
	var xx5 = "";
	var xx6 = "";
	var xx7 = "";
	var xx8 = "";
	var xx9 = "";
	var param = "?returnval=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
	ComOpenPopup('/opuscntr/COM_ENS_071.do' + param, 768, 487, 'getCOM_ENS_071', '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * Pop-up call office code: hangyeongwoo single selection from a pop-up.
 */
function getCOM_ENS_071(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var in_val_2 = colArray[3];
	formObject.wo_issue_office.value = in_val_2;
}
/**
 * Combo box-cost
 */
function bound_OnChange_2(obj) {
	var codeval = obj.value;
	var formObject = document.form;
	formObject.hid_costmode.value = codeval;
}
/**
 * Combo box-trans
 */
function bound_OnChange_3(obj) {
	var codeval = obj.value;
	var formObject = document.form;
	formObject.hid_transmode.value = codeval;
}

function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
	var formObj = document.form;
	var btn_go = formObj.btn_go.value;
	if (btn_go == "DETAIL") {
		if (sheetObj.RowCount() < 1) {
			var errMsg = ComGetMsg("TRS90321");
			ComShowMessage(errMsg);
			return;
		}

		var cnt = 0;
		var cty_cd = "";
		var seq_no = "";
		var cancel_check = "";
		var detain = "";
		var bno_iss = "";
		var sowonumber = "";
		for ( var i = 1; i < sheetObj.RowCount() + 1; i++) {
			if (cnt != 0) {
				cty_cd += ',';
				seq_no += ',';
				cancel_check += ',';
				detain += ',';
				bno_iss += ',';
				sowonumber += ',';
			}
			cty_cd += sheetObj.GetCellValue(i, 'trsp_so_ofc_cty_cd');
			seq_no += sheetObj.GetCellValue(i, 'trsp_so_seq');
			cancel_check += 'N';
			detain += sheetObj.GetCellValue(i, 'dtn_use_flg');
			bno_iss += sheetObj.GetCellValue(i, 'wo_bl_no_iss_flg');
			sowonumber += sheetObj.GetCellValue(i, 'trsp_so_ofc_cty_cd') + sheetObj.GetCellValue(i, 'trsp_so_seq');
			cnt++;
		}
		ComOpenWindow("about:blank", "P_DETAIL", "width=1270,height=670");

		document.woForm.pgmNo.value = 'ESD_TRS_0019';
		document.woForm.sysCommUiNavigation.value = 'Trans S/O > Service Order';
		document.woForm.sysCommUiTitle.value = 'Inquiry';
		document.woForm.issued.value = 'Y';
		document.woForm.trsp_so_ofc_cty_cd.value = cty_cd;
		document.woForm.trsp_so_seq.value = seq_no;
		document.woForm.wo_cancel_flag.value = cancel_check;
		document.woForm.detain.value = detain;
		document.woForm.bno_issue.value = bno_iss;
		document.woForm.sowonumber.value = sowonumber;
		document.woForm.p_pop_flg.value = 'Y';
		document.woForm.action = 'ESD_TRS_0019_POP.screen?parentPgmNo=ESD_TRS_M001';
		document.woForm.target = "P_DETAIL";
		document.woForm.submit();
	}
}

/**
 * 
 * @param obj
 */
function getDateBetween(obj, targetObj) {
	if (obj.value == "") {
		document.form.todate.value = "";
	} else {
		document.form.todate.value = ComGetDateAdd(obj.value, "D", 30);
	}
}

/**
 * 
 * @param sheet1
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @returns
 */
function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	if(mouseRow < 2) return;
	var formObj=document.form;
	var mouseRow = sheetObj.MouseRow();
	var mouseCol = sheetObj.MouseCol();
	var colSaveName = sheetObj.ColSaveName(mouseCol);
	switch(colSaveName) {
		case "fm_nod_cd":
		case "via_nod_cd":
		case "to_nod_cd":
		case "dor_nod_cd":
			if(ComIsNull(sheetObj.GetToolTipText(mouseRow, mouseCol))) {
				sheetObj.SetToolTipText(mouseRow, mouseCol, sheetObj.GetCellValue(mouseRow, colSaveName + "_nm"));
			}
			break;
	}	
}
