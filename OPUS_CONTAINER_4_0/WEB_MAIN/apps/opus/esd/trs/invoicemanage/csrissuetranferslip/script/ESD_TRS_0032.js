/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0032.js
 *@FileTitle  : TRS invoice CSR Creation - Detail
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/29
=========================================================*/
/** Common global variable */
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;
var comboObjects = new Array();
var fromObj = new Array();
var rdObj = new Array();
var parmObj = new Array();
var comboCnt = 0;
var findCheckRow = "";
var checkRows = "";
/** Event handler processing by button click event */
document.onclick = processButtonClick;
/** Event handler processing by button name */
function processButtonClick() {
	/** ***Case more than two additional sheets tab sheet is used to specify a variable **** */
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	/** **************************************************** */
	var formObject = document.form;
	if (formObject.total_amt.value >= 0) {
		formObject.csr_tp_cd.value = "S"
	} else {
		formObject.csr_tp_cd.value = "C"
	}
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;
			case "btn_new":
				sheetObject.RemoveAll();
				formObject.reset();
				break;
			case "btns_calendar1":
				var cal = new ComCalendar();
				cal.select(formObject.sdate, 'sdate', 'yyyy-MM-dd');
				break;
			case "btns_calendar2":
				var cal = new ComCalendar();
				cal.select(formObject.pm_due_dt, 'pm_due_dt', 'yyyy-MM-dd');
				break;
			case "btng_preview":
				/** * ACCT_CD IS NULL OR LGS_COST_CD IS NULL DATA CHECK ** */
				if (!isNullAcctCdLgsCostCd(sheetObject))
					return false;
				if (sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined) {
					ComShowMessage(ComGetMsg("TRS90036"));
					return false;
				}
				/** ASA NO. Select check whether */
				if (formObject.asanogb.value == "ASA" && (formObject.asa_no.value == null || formObject.asa_no.value == "")) {
					ComShowMessage(ComGetMsg("TRS90385", "ASA No."));
					return false;
				}
				if (formObject.evi_gb.value == "3") {
					formObject.evi_tax_code.value = "";
				}
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
				doActionIBSheet1(sheetObject2, formObject, IBSEARCH);
				document.form.csr_no.value = "";
				break;
			case "btns_search":
				var v_apro_step = document.form.apro_step.value;
				var ofc_cd = document.form.cost_ofc_cd.value;
				var param = "?mode=set&ofc_cd=" + ofc_cd + "&sub_sys_cd=TRS&apro_step=" + encodeURIComponent(v_apro_step) + "&target_obj_nm=apro_step&classId=COM_ENS_0T1";
				ComOpenPopup('/opuscntr/COM_ENS_0T1.do' + param, 835, 550, '', 'none', true);
				break;
			case "btng_print":
				fromObj[0] = formObject;
				rdObj[0] = sheetObjects[0];
				// Sent to the settings for RD
				parmObj[0] = "1";
				parmObj[1] = "";
				parmObj[2] = "N";
				parmObj[3] = RD_path + "apps/opus/esd/trs/invoicemanage/csrissuetranferslip/report/ESD_TRS_0032Print.mrd"; // RD screen
				parmObj[4] = rdObj;
				parmObj[5] = fromObj;

				rdObjModal(RdReport, parmObj, 900, 500);
				break;
			case "btng_approvalrequest":
				/** * ACCT_CD IS NULL OR LGS_COST_CD IS NULL DATA CHECK ** */
				if (!isNullAcctCdLgsCostCd(sheetObject))
					return false;
				if (sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined) {
					ComShowMessage(ComGetMsg("TRS90036"));
					return false;
				}
				/** ASA NO. Select check whether */
				if (formObject.asanogb.value == "ASA" && (formObject.asa_no.value == null || formObject.asa_no.value == "")) {
					ComShowMessage(ComGetMsg("TRS90385", "ASA No."));
					return false;
				}
				/** Hold Invoice check whether */
				var chkrow = sheetObject.FindCheckedRow("chk");
				var arrRow = chkrow.split("|");
				var inv_no = "";
				var inv_vndr_seq = "";
				for (idx = arrRow.length; idx >= 0; idx--) {
					inv_no += sheetObject.GetCellValue(arrRow[idx], 'inv_no') + "|";
					inv_vndr_seq += sheetObject.GetCellValue(arrRow[idx], 'inv_vndr_seq') + "|";
				}
				formObject.f_cmd.value = SEARCH02;
				formObject.r_inv_no.value = inv_no;
				formObject.r_inv_vndr_seq.value = inv_vndr_seq;
				var sXml = sheetObject.GetSearchData("ESD_TRS_0032GS.do", TrsFrmQryString(formObject));
				var holdInvNo = ComGetEtcData(sXml, 'holdInvNo');
				if (holdInvNo != "N") {
					ComShowMessage(ComGetMsg("TRS90454", holdInvNo));
					return false;
				}
				
				// 2016.03.03 CHAN WOO PARK
				// AP Office 확인 로직 추가
				formObject.f_cmd.value = SEARCH03;
				var sXml = sheetObject.GetSearchData("ESD_TRS_0032GS.do", TrsFrmQryString(formObject));
				var apOfcCd = ComGetEtcData(sXml, 'apOfcCd');
				if (apOfcCd == "N") {
					ComShowMessage(ComGetMsg("TRS90487", formObject.cost_ofc_cd.value));
					return false;
				}
				
				if (!confirm(ComGetMsg("TRS90423"))) {
					return false;
				}
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
			case "btng_downexcel1":
				if (sheetObject.RowCount() < 1) {
					ComShowCodeMessage("COM132501");
				} else {
					sheetObject.Down2Excel({ DownCols : makeHiddenSkipCol_TRS(sheetObject), SheetDesign : 1, Merge : 1 });
				}
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			errMsg = ComGetMsg("TRS90392");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e.message);
		}
	}
}
function resetTax() {
	document.form.tax_naid_flg.value = "";
	document.form.finance_flg.value = "";
	document.form.fa_flg.value = "";
	document.form.tax_type.value = "";
	document.form.tax_nsl_flg.value = "";
	document.form.type.value = "";
	document.form.evi_inv_dt.value = "";
	document.form.evi_comp_no.value = "";
	document.form.evi_total_net_amt.value = "";
	document.form.evi_tax_no2.value = "";
	document.form.evi_total_tax_amt.value = "";
	document.form.evi_ctnt1.value = "";
	document.form.evi_ctnt2.value = "";
	document.form.evi_ctnt3.value = "";
	document.form.evi_ctnt4.value = "";
	document.form.evi_ctnt5.value = "";
	document.form.evi_ctnt6.value = "";
	document.form.evi_ctnt7.value = "";
	document.form.evi_ctnt8.value = "";
	document.form.evi_ctnt9.value = "";
	document.form.evi_ctnt10.value = "";
	document.form.evi_ctnt11.value = "";
	document.form.evi_ctnt12.value = "";
	document.form.evi_tax_no.value = "";
	document.form.evi_tax_code.value = "";
	document.form.eviInputFlg.value = "";
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
	if (ComIsNumber(document.form.gen_pay_term_cd)) {
		document.form.gen_pay_term_view.value = document.form.gen_pay_term_cd.value;
	} else {
		document.form.gen_pay_term_view.value = "KR H/O Payment_60";
	}
	if (document.form.asanogb.value == "ASA") {
		document.getElementById("srLayer").style.display = "inline";
		document.getElementById("btLayer").style.display = "inline";
	} else if (document.form.asanogb.value == "A/P") {
		document.getElementById("srLayer").style.display = "none";
		document.getElementById("btLayer").style.display = "inline";
	}
	for (p = 0; p < comboObjects.length; p++) {
		initCombo(comboObjects[p], p + 1, '');
	}
	ComEnableObject(document.form.cost_ofc_cd, false);
	ComEnableObject(document.form.cfm_dt, false);
	ComEnableObject(document.form.vndr_seq, false);
	ComEnableObject(document.form.vndr_seq_name, false);
	ComEnableObject(document.form.cnt_inv, false);
	ComEnableObject(document.form.curr_cd, false);
	ComEnableObject(document.form.total_amt, false);
	ComEnableObject(document.form.csr_no, false);
	ComEnableObject(document.form.max_iss_dt, false);
	ComEnableObject(document.form.max_rcv_dt, false);
	ComEnableObject(document.form.gen_pay_term_view, false);
	ComEnableObject(document.form.apro_step, false);
	ComEnableObject(document.form.payment_due_dt, false);
	ComEnableObject(document.form.payment_due_dt_view, false);
	document.form.reset();
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
		case 1: // sheet1 init
			with (sheetObj) {
				var HeadTitle = "Seq.||Invoice No|Net Amount|Tax Amount|W.H.T Amount|Total Amount|Issue Date|Receive Date|Confirm Date|Tax Invoice\n(Korea only)";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 1, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [{ Text : HeadTitle, Align : "Center" }];
				InitHeaders(headers, info);

				var cols = [
						{ Type : "Seq", Hidden : 0, Width : 30, Align : "Center", ColMerge : 0, SaveName : "", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 0, Width : 30, Align : "Center", ColMerge : 0, SaveName : "chk", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 100, Align : "Left", ColMerge : 0, SaveName : "inv_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Float", Hidden : 0, Width : 100, Align : "Right", ColMerge : 0, SaveName : "inv_bzc_amt", KeyField : 0, CalcLogic : "", Format : "Float", PointCount : 2, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Float", Hidden : 0, Width : 100, Align : "Right", ColMerge : 0, SaveName : "inv_vat_amt", KeyField : 0, CalcLogic : "", Format : "Float", PointCount : 2, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Float", Hidden : 0, Width : 100, Align : "Right", ColMerge : 0, SaveName : "inv_whld_tax_amt", KeyField : 0, CalcLogic : "", Format : "Float", PointCount : 2, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Float", Hidden : 0, Width : 100, Align : "Right", ColMerge : 0, SaveName : "inv_ttl_amt", KeyField : 0, CalcLogic : "", Format : "Float", PointCount : 2, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Date", Hidden : 0, Width : 110, Align : "Center", ColMerge : 0, SaveName : "inv_iss_dt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Date", Hidden : 0, Width : 110, Align : "Center", ColMerge : 0, SaveName : "inv_rcv_dt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Date", Hidden : 0, Width : 110, Align : "Center", ColMerge : 0, SaveName : "inv_cfm_dt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "CheckBox", Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "taxcheck", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Text", Hidden : 1, Width : 1, Align : "Right", ColMerge : 0, SaveName : "inv_vndr_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Status", Hidden : 1, Width : 1, Align : "Right", ColMerge : 0, SaveName : "ibflag", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 1, Align : "Right", ColMerge : 0, SaveName : "acct_cd_empty_cnt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 1, Align : "Right", ColMerge : 0, SaveName : "wo_vndr_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }
				];

				InitColumns(cols);
				SetEditable(1);
				SetSheetHeight(200);
			}
			break;
		case 2: // sheet1 init
			with (sheetObj) {
				var HeadTitle = "pre_csr_no|pre_office|pre_prpd_dy|pre_pay_to|pre_csr_type|pre_desc|pre_pay_group|pre_evi_tp|pre_due_date|pre_asa_no|pre_inv_dt|pre_curr_cd|pre_amt|pre_pay_curr_cd|pre_pay_amt|apro_step|pre_title|chk_mail";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 1, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
				var headers = [{ Text : HeadTitle, Align : "Center" }];
				InitHeaders(headers, info);

				var cols = [
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Left", ColMerge : 0, SaveName : "pre_csr_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "pre_office", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "pre_prpd_dy", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "pre_pay_to", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "pre_csr_type", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "pre_desc", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "pre_pay_group", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "pre_evi_tp", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "pre_due_date", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "pre_asa_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "pre_inv_dt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "pre_curr_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Float", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "pre_amt", KeyField : 0, CalcLogic : "", Format : "NullFloat", PointCount : 2, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "pre_pay_curr_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Float", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "pre_pay_amt", KeyField : 0, CalcLogic : "", Format : "NullFloat", PointCount : 2, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "apro_step", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "pre_title", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "chk_mail", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "chk_mail1", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "chk_mail2", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "chk_mail3", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "chk_mail4", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "chk_mail5", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "chk_mail6", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 70, Align : "Right", ColMerge : 0, SaveName : "chk_mail7", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }
				];

				InitColumns(cols);

				SetEditable(1);
				SetSheetHeight(200);
			}
			break;
		case 3: // sheet1 init
			with (sheetObj) {
				var HeadTitle = "char of account|account name|gl date|city|inv no|desc|debit|credit|total amt";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 1, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
				var headers = [{ Text : HeadTitle, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "pre_chart_of_account", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "pre_account_name", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Left", ColMerge : 0, SaveName : "pre_gl_date", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Right", ColMerge : 0, SaveName : "pre_city", KeyField : 0, CalcLogic : "", Format : "", PointCount : 2, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Right", ColMerge : 0, SaveName : "pre_inv_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 2, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Right", ColMerge : 0, SaveName : "pre_desc", KeyField : 0, CalcLogic : "", Format : "", PointCount : 2, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Float", Hidden : 0, Width : 80, Align : "Right", ColMerge : 0, SaveName : "pre_debit", KeyField : 0, CalcLogic : "", Format : "NullFloat", PointCount : 2, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Float", Hidden : 0, Width : 80, Align : "Right", ColMerge : 0, SaveName : "pre_credit", KeyField : 0, CalcLogic : "", Format : "NullFloat", PointCount : 2, UpdateEdit : 0, InsertEdit : 0 }
				];

				InitColumns(cols);
				SetEditable(1);
				SetSheetHeight(200);
			}

			break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH: // retrieve
			formObj.f_cmd.value = SEARCHLIST;
			sheetObj.DoSearch("ESD_TRS_0032GS.do", TrsFrmQryString(formObj));
			break;
		case IBSAVE:
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESD_TRS_0032GS.do", TrsFrmQryString(formObj), "chk", false);
			break;
		case IBCOPYROW: // row copy
			sheetObj.DataCopy();
			break
	}
}
// handling sheet process
function doActionIBSheet1(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH: // retrieve
			formObj.f_cmd.value = SEARCH01;
			var param = sheetObjects[0].GetSaveString(false, false);
			sheetObj.DoSearch("ESD_TRS_0032PreView.do", param + '&' + TrsFrmQryString(formObj), "", true);
			break;
	}
}
function sheet1_OnChange(sheetObj, row, col, value) {
	var chkRow = sheetObj.FindCheckedRow("chk");
	var arrRow = chkRow.split("|");
	var chkRowCount = 0;
	var maxIss = 0;
	var maxRcv = 0;
	var total_amt = 0;
	var vat_amt = 0;
	var selectRow = 0;
	document.form.csr_no.value = "";
	if(chkRow == "") {
		document.form.wo_vndr_seq.value = "";
		document.form.max_iss_dt.value = "";
		document.form.max_rcv_dt.value = "";
		document.form.total_amt.value = "";
		document.form.cnt_inv.value = "";
		document.form.payment_due_dt_view.value = "";
		document.form.gen_pay_term_view.value = "";
		return;
	}
	for (idx = 0; idx < arrRow.length; idx++) {
		if (maxIss < sheetObj.GetCellValue(arrRow[idx], "inv_iss_dt")) {
			maxIss = sheetObj.GetCellValue(arrRow[idx], "inv_iss_dt");
			selectRow = arrRow[idx];
		}
		if (maxRcv < sheetObj.GetCellValue(arrRow[idx], "inv_rcv_dt")) {
			maxRcv = sheetObj.GetCellValue(arrRow[idx], "inv_rcv_dt");
		}
		total_amt = parseFloat(sheetObj.GetCellValue(arrRow[idx], "inv_ttl_amt") * 100) + parseFloat(total_amt) * 100;
		vat_amt = parseFloat(sheetObj.GetCellValue(arrRow[idx], "inv_vat_amt") * 100) + parseFloat(vat_amt) * 100;
		total_amt = total_amt / 100;
		vat_amt = vat_amt / 100;
		chkRowCount++;
	}
	document.form.wo_vndr_seq.value = sheetObj.GetCellValue(selectRow, "wo_vndr_seq");
	if (maxIss == "0") {
		maxIss = "";
	}
	if (maxRcv == "0") {
		maxRcv = "";
	}
	if (chkRowCount == 0) {
		chkRowCount = "";
	}
	document.form.max_iss_dt.value = maxIss;
	document.form.max_rcv_dt.value = maxRcv;
	document.form.total_amt.value = chkAmtPos(total_amt, 2);
	ComChkObjValid(document.form.max_iss_dt);
	ComChkObjValid(document.form.max_rcv_dt);
	document.form.cnt_inv.value = chkRowCount;
	var payDueDt = document.form.max_iss_dt.value;
	var genPayTerm = getPaymentTermDate(document.form.gen_pay_term_cd.value);
	if (maxIss != "") {
		document.form.payment_due_dt_view.value = ComGetDateAdd(payDueDt, "D", genPayTerm, "");
		document.form.gen_pay_term_view.value = document.form.gen_pay_term_cd.value;
	} else {
		document.form.payment_due_dt_view.value = "";
		document.form.gen_pay_term_view.value = "";
	}
}
function sheet1_OnSaveEnd(sheetObj, code, ErrMsg) {
	if (ErrMsg != "") {
		return false;
	}
		
	var csr_no = sheetObj.GetEtcData("csrNo");
	document.form.csr_no.value = csr_no;
	sheetObj.RemoveEtcData();
	var chkRow = sheetObj.FindCheckedRow("chk");
	var arrRow = chkRow.split("|");
	for (idx = 0; idx < arrRow.length; idx++) {
		sheetObj.SetCellEditable(arrRow[idx], "chk", 0);
		sheetObj.SetCellValue(arrRow[idx], "chk", 0, 0);
	}
	ComShowMessage(ComGetMsg("TRS90046"));
	if (myWin != null) {
		if (!myWin.closed) {
			sheetObjects[1].SetCellValue(1, "pre_csr_no", csr_no);
			myWin = null;
			myWin = ComOpenPopup('/opuscntr/ESD_TRS_0036.do', 800, 700, '', '1,0,1,1,1,1,1,1');
		}
	}
}
function isNum(obj) {
	// Only number
	if (!ComIsNumber(obj)) {
		obj.value = '';
	}
}
function isNum1(obj) {
	// Only number
	if (!isNumDash(obj)) {
		obj.value = '';
	}
}

function sheet3_OnSearchEnd(sheetObj, code, errMsg) {
	if (errMsg != "")
		return;
	var pre_title = "";
	var previewFlg = "";
	var pre_csr_no = sheetObj.GetEtcData("pre_csr_no");
	var pre_office = sheetObj.GetEtcData("pre_office");
	var pre_prpd_dy = sheetObj.GetEtcData("pre_prpd_dy");
	var pre_pay_to = sheetObj.GetEtcData("pre_pay_to");
	var pre_csr_type = sheetObj.GetEtcData("pre_csr_type");
	var pre_desc = sheetObj.GetEtcData("pre_desc");
	var pre_pay_group = sheetObj.GetEtcData("pre_pay_group");
	var pre_evi_tp = sheetObj.GetEtcData("pre_evi_tp");
	var pre_due_date = sheetObj.GetEtcData("pre_due_date");
	var pre_inv_dt = sheetObj.GetEtcData("pre_inv_dt");
	var pre_curr_cd = sheetObj.GetEtcData("pre_curr_cd");
	var pre_amt = sheetObj.GetEtcData("pre_amt");
	var chk_mail = sheetObj.GetEtcData("chk_mail");
	var chk_mail1 = sheetObj.GetEtcData("chk_mail1");
	var chk_mail2 = sheetObj.GetEtcData("chk_mail2");
	var chk_mail3 = sheetObj.GetEtcData("chk_mail3");
	var chk_mail4 = sheetObj.GetEtcData("chk_mail4");
	var chk_mail5 = sheetObj.GetEtcData("chk_mail5");
	var chk_mail6 = sheetObj.GetEtcData("chk_mail6");
	var chk_mail7 = sheetObj.GetEtcData("chk_mail7");
	var pre_evi_tp_count = "";
	sheetObj.RemoveEtcData();

	var sRow = sheetObjects[0].FindCheckedRow(1);
	var arrRow = sRow.split("|");
	pre_evi_tp_count = arrRow.length;
	if (pre_amt == 0 || pre_amt == "0" || pre_amt == "0.00") {
		pre_title = "TRANSFER SLIP";
	} else {
		pre_title = "CONSULTATION SLIP";
	}
	sheetObjects[1].RemoveAll();
	sheetObjects[1].DataInsert(-1);
	sheetObjects[1].SetCellValue(1, "pre_csr_no", pre_csr_no);
	sheetObjects[1].SetCellValue(1, "pre_office", document.form.cost_ofc_cd.value);
	sheetObjects[1].SetCellValue(1, "pre_prpd_dy", pre_prpd_dy);
	sheetObjects[1].SetCellValue(1, "pre_pay_to", pre_pay_to);
	sheetObjects[1].SetCellValue(1, "pre_csr_type", pre_csr_type);
	sheetObjects[1].SetCellValue(1, "pre_desc", pre_desc);
	sheetObjects[1].SetCellValue(1, "pre_pay_group", pre_pay_group);
	sheetObjects[1].SetCellValue(1, "pre_evi_tp", pre_evi_tp + "/" + pre_evi_tp_count);
	sheetObjects[1].SetCellValue(1, "pre_due_date", pre_due_date);
	sheetObjects[1].SetCellValue(1, "pre_asa_no", document.form.asa_no.value);
	sheetObjects[1].SetCellValue(1, "pre_inv_dt", pre_inv_dt);
	sheetObjects[1].SetCellValue(1, "pre_curr_cd", pre_curr_cd);
	sheetObjects[1].SetCellValue(1, "pre_amt", pre_amt);
	sheetObjects[1].SetCellValue(1, "pre_title", pre_title);
	sheetObjects[1].SetCellValue(1, "chk_mail", chk_mail);
	sheetObjects[1].SetCellValue(1, "chk_mail1", chk_mail1);
	sheetObjects[1].SetCellValue(1, "chk_mail2", chk_mail2);
	sheetObjects[1].SetCellValue(1, "chk_mail3", chk_mail3);
	sheetObjects[1].SetCellValue(1, "chk_mail4", chk_mail4);
	sheetObjects[1].SetCellValue(1, "chk_mail5", chk_mail5);
	sheetObjects[1].SetCellValue(1, "chk_mail6", chk_mail6);
	sheetObjects[1].SetCellValue(1, "chk_mail7", chk_mail7);
	if (pre_curr_cd == "KRW" || pre_curr_cd == "JPY") {
		previewFlg = "krjp";
	}
	myWin = ComOpenPopup('/opuscntr/ESD_TRS_0036.do?previewFlg=' + previewFlg, 800, 600, '', '1,0,1,1,1,1,1,1');
}
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	if (errMsg != "")
		return;
	var asaNoString = sheetObj.GetEtcData("asaNoString");
	var csrNo = sheetObj.GetEtcData("csrNo");
	var apOfcCd = sheetObj.GetEtcData("apOfcCd");
	document.form.csr_no.value = csrNo;
	document.form.ap_ofc_cd.value = apOfcCd;
	for (p = 0; p < comboObjects.length; p++) {
		initCombo(comboObjects[p], p + 1, asaNoString);
	}
}
function initCombo(comboObj, comboNo, asaNoString) {
	var cnt = 0;
	var asaNoArray = asaNoString.split("|");
	switch (comboNo) {
		case 1:
			comboObj.RemoveAll();
			with (comboObj) {
				SetColAlign(0, "left");
				SetColWidth(0, "130");
				InsertItem(cnt++, '', '');
				for (i = 0; i < asaNoArray.length; i++) {
					InsertItem(cnt++, asaNoArray[i], asaNoArray[i]);
				}
			}
			break;
	}
}
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}
function asa_no_1_OnChange(comObj, index, text) {
	document.form.asa_no.value = comObj.GetSelectCode();
}
function approvalrequest() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	if (sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	/** Hold Invoice check whether */
	var chkrow = sheetObject.FindCheckedRow("chk");
	var arrRow = chkrow.split("|");
	var inv_no = "";
	var inv_vndr_seq = "";
	for (idx = arrRow.length; idx >= 0; idx--) {
		inv_no += sheetObject.GetCellValue(arrRow[idx], 'inv_no') + "|";
		inv_vndr_seq += sheetObject.GetCellValue(arrRow[idx], 'inv_vndr_seq') + "|";
	}
	formObject.f_cmd.value = SEARCH02;
	formObject.r_inv_no.value = inv_no;
	formObject.r_inv_vndr_seq.value = inv_vndr_seq;
	var sXml = sheetObject.GetSearchData("ESD_TRS_0032GS.do", TrsFrmQryString(formObject));
	var holdInvNo = ComGetEtcData(sXml, 'holdInvNo');
	if (holdInvNo != "N") {
		ComShowMessage(ComGetMsg("TRS00410", holdInvNo));
		return false;
	}
	if (!confirm(ComGetMsg("TRS90423"))) {
		return false;
	}
	doActionIBSheet(sheetObject, formObject, IBSAVE);
}
function eviGbSelect(evi_gb) {
	if (evi_gb == 1) {
		document.form.evi_gb.value = document.form.evi_gb1.value;
	} else if (evi_gb == 2) {
		document.form.evi_gb.value = document.form.evi_gb2.value;
	}
}
/**
 * 
 * @param sheetObject
 * @returns {Boolean}
 */
function isNullAcctCdLgsCostCd(sheetObject) {
	var isNullTotalCnt = 0;
	var isNullCnt = 0;
	var checkedRow = 0;
	var checkList = sheetObject.FindCheckedRow('chk');
	var checkArray = checkList.split('|');
	var isNullTotalCnt = 0;
	for ( var k = 0; k < checkArray.length; k++) {
		if(Number(sheetObject.GetCellValue(checkArray[k], 'acct_cd_empty_cnt')) > 0 ) {
			ComShowMessage(ComGetMsg("TRS90398"));
			return false;
		}
	}
	return true;
}
function getPaymentTermDate(payTermCd) {
	var payTermDate = 0;
	if (payTermCd == 'IN') {
		payTermDate = 5;
	} else if (payTermCd == 'OUT') {
		payTermDate = 60;
	} else if (payTermCd == 'O60') {
		payTermDate = 0;
	} else if (payTermCd == 'O45') {
		payTermDate = 0;
	} else {
		payTermDate = payTermCd;
	}
	return parseInt(payTermDate);
}
