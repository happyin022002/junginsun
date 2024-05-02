/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   :  ESD_TRS_0040.js
 *@FileTitle  : Invoice Audit for Vol. Refund/DC
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/04/08
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;
var apflag = false;
var fileflag = false;
document.onclick = processButtonClick;
function processButtonClick() {
	/** ***Add 2 or more case taepdang sheet by sheet, using a variable assignment **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	var comboObj = paymt_sp_combo;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
		case "btn_apply":
			if (chkComfirm())
				return false;
			if (checkInput(formObject))
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
		case "btn_reset":
			comboObj.RemoveAll();
			sheetObject.RemoveAll();
			formObject.reset();
			ComEnableObject(document.form.inv_no, true);
			ComEnableObject(document.form.inv_curr_cd, true);
			document.form.combo_svc_provider.Enable = true;
			document.form.combo_svc_provider.Text = "";
			formObject.insflag.value = "true";
			fileflag = false;
			apflag = false;
			break;
		case "btn_minimize":
			Mincount = (Mincount + 1) % 2;
			Minimize(Mincount);
			break;
		case "btns_calendar1":
			var cal = new ComCalendar();
			cal.select(formObject.inv_rcv_dt, 'yyyy-MM-dd');
			break;
		case "btns_calendar2":
			var cal = new ComCalendar();
			cal.select(formObject.inv_iss_dt, 'yyyy-MM-dd');
			break;
		case "btng_invoicefileimport":
			if(document.getElementsByName(srcName)[0].disabled) return;
			if (!apflag) {
				errMsg = ComGetMsg("TRS90080");
				ComShowMessage(errMsg);
				return false;
			}
			if (fileflag) {
				errMsg = ComGetMsg("TRS90008");
				ComShowMessage(errMsg);
				return false;
			}
			if (chkComfirm())
				return false;
			ComOpenWindow('ESD_TRS_0045.do', window, "scroll:no;status:no;help:no;dialogWidth:950px;dialogHeight:480px", true);

			break;
		case "btng_rowadd":
			if(document.getElementsByName(srcName)[0].disabled) return;
			if (!apflag) {
				errMsg = ComGetMsg("TRS90080");
				ComShowMessage(errMsg);
				return false;
			}
			if (chkComfirm())
				return false;
			doActionIBSheet(sheetObject, formObject, IBINSERT);
			break;
		case "btng_delete":
			if(document.getElementsByName(srcName)[0].disabled) return;
			if (!apflag) {
				errMsg = ComGetMsg("TRS90080");
				ComShowMessage(errMsg);
				return false;
			}
			if (chkComfirm())
				return false;
			var chkrow = sheetObject.FindCheckedRow("sel");
			var arrRow = chkrow.split("|");
			for (idx = arrRow.length; idx >= 0; idx--) {
				sheetObject.RowDelete(arrRow[idx], false);
			}
			break;
		case "btng_confirm":
			if(document.getElementsByName(srcName)[0].disabled) return;
			if (!apflag) {
				errMsg = ComGetMsg("TRS90080");
				ComShowMessage(errMsg);
				return false;
			}
			if (chkComfirm())
				return false;
			var sheetTotal = 0.00;
			sel = sheetObject.FindCheckedRow('sel');
			sheetTotal = getInvoiceTotAmt(sheetObject, sel);
			var totAmtChkFlg = parseFloat(ComTrimAll(formObject.inv_bzc_amt.value, ",")) == sheetTotal;
			if (checkInputData(sheetObject, totAmtChkFlg)) {
				if (totAmtChkFlg) {
					doActionIBSheet(sheetObject, formObject, IBSAVE);
				} else {
					errMsg = ComGetMsg("TRS90006");
					ComShowMessage(errMsg);
					return;
				}
			}
			break;
		case "btng_provider":
			rep_OnPopupClick();
			break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			errMsg = ComGetMsg("TRS90392");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e.message);
		}
	}
}

function getInvoiceTotAmt(sheetObject, sel) {
	var sheetTotal = 0.00;
	if (sel != "") {
		var arrRow = sel.split("|");
		for ( var idx = 0; idx < arrRow.length; idx++) {
			sheetTotal = Number(sheetTotal) + Number(sheetObject.GetCellValue(arrRow[idx], "trsp_rfnd_inv_amt"));
			sheetTotal = sheetTotal.toFixed(2);
		}
	}
	return sheetTotal;
}

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
	ComEnableObject(document.form.inv_ttl_amt, false);
	ComEnableObject(document.form.paymt_sp_cd, false);
	ComEnableObject(paymt_sp_combo, false);
	ComEnableObject(document.form.svc_provider, false);
    if(document.form.mode_param.value != '') {
        initMode();
    }
}

function initMode() {
    var sheetObj = sheetObjects[0];
    var formObj = document.form;
    formObj.f_cmd.value = SEARCH04;
    formObj.inv_no.value = formObj.inv_no_param.value;
//    formObj.combo_svc_provider.value = formObj.inv_vndr_seq_param.value;

    var comboObj = paymt_sp_combo;
    comboObj.InsertItem(-1, formObj.inv_vndr_seq_param.value, formObj.inv_vndr_nm_param.value);
    formObj.paymt_sp_cd.value = formObj.inv_vndr_seq_param.value;
    formObj.paymt_sp_nm.value = formObj.inv_vndr_nm_param.value;
    comboObj.SetSelectIndex(comboObj.GetItemCount()-1, false);
    
    //sheetObj.DoSearch("ESD_TRS_0040GS.do", TrsFrmQryString(formObj), {Sync:2} );
	var sXml = sheetObj.GetSearchData("ESD_TRS_0040GS.do", TrsFrmQryString(formObj));

	sheetObj.LoadSearchData(sXml, {Append:1 , Sync:1} );
	ComEtcDataToForm(document.form, sheetObj);
    sheetObj.RemoveEtcData();
	//var inv_flag = ComGetEtcData(sXml, 'inv_flag');
    
//    if(document.form.mode_param.value == 'search'){
//        setDisabled('SEARCH_MODE');
//    } else if(document.form.mode_param.value == 'modify'){
//        setDisabled('APPLY');
//        getOfcCd();
//    }
    formObj.btng_invoicefileimport.onclick = false;
    formObj.btng_rowadd.onclick = false;
    formObj.btng_delete.onclick = false;
    formObj.btng_confirm.onclick = false;
}

/**
 * Setting Invoice Header information to form object.
 */
function bindForm(sheetObj, formObj) {
    formObj.combo_svc_provider.value = sheetObj.GetCellValue(1, 'wo_vndr_seq');
    formObj.svc_provider.value = sheetObj.GetCellValue(1, 'wo_vndr_nm');
    formObj.paymt_sp_cd.value = sheetObj.GetCellValue(1, 'inv_vndr_seq');
    formObj.paymt_sp_nm.value = sheetObj.GetCellValue(1, 'inv_vndr_nm');
    var comboObj = paymt_sp_combo;
    comboObj.InsertItem(-1, sheetObj.GetCellValue(1, 'inv_vndr_seq'), sheetObj.GetCellValue(1, 'inv_vndr_nm'));
    comboObj.SetSelectIndex(comboObj.GetItemCount()-1, false);
//    formObj.apply_currency.value = sheetObj.GetCellValue(1, 'inv_curr_cd');
    formObj.inv_no.value = sheetObj.GetCellValue(1, 'inv_no');
    formObj.inv_iss_dt.value = sheetObj.GetCellValue(1, 'inv_iss_dt');
    formObj.inv_rcv_dt.value = sheetObj.GetCellValue(1, 'inv_rcv_dt');
    formObj.inv_bzc_amt.value = sheetObj.GetCellValue(1, 'inv_bzc_amt');
    formObj.inv_vat_amt.value = sheetObj.GetCellValue(1, 'inv_vat_amt');
    formObj.inv_whld_tax_amt.value = sheetObj.GetCellValue(1, 'inv_whld_tax_amt');
    formObj.inv_ttl_amt.value = sheetObj.GetCellValue(1, 'inv_ttl_amt');
}

/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
	case 1:
		with (sheetObj) {
			var HeadTitle = "Del.|STS|Sel.|Cost Mode|Trans Mode|EQ\nType/Size|Quantity|Unit Cost|Invoice Amount|Adjustment|Handling Period|Handling Period||Verify";
			var HeadTitle1 = "Del.|STS|Sel.|Cost Mode|Trans Mode|EQ\nType/Size|Quantity|Unit Cost|Invoice Amount|Adjustment|From Date|To Date||Verify";

			SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 1 });

			var info = { Sort : 1, ColMove : 0, HeaderCheck : 1, ColResize : 1 };
			var headers = [
					{ Text : HeadTitle, Align : "Center" }, { Text : HeadTitle1, Align : "Center" }
			];
			InitHeaders(headers, info);

			var cols = [
			              { Type:"Text",     Hidden:1, Width:30,  Align:"Center", ColMerge:1, SaveName:"del",                  KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:1, InsertEdit:1 },
			              { Type:"Status",   Hidden:1, Width:30,  Align:"Center", ColMerge:1, SaveName:"ibflag",               KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:1 },
			              { Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"sel",                  KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:1, InsertEdit:1 },
						  { Type:"Combo",    Hidden:0, Width:120, Align:"Left",   ColMerge:1, SaveName:"trsp_cost_dtl_mod_cd", KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:1, InsertEdit:1 },
						  { Type:"Combo",    Hidden:0, Width:100, Align:"Center", ColMerge:1, SaveName:"trsp_crr_mod_cd",      KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:1, InsertEdit:1 } ];

			if(document.form.mode_param.value != '') {
				cols.push({ Type:"Text",     Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_tpsz_cd",           KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 });
			}else{
				cols.push({ Type:"Combo",    Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"eq_tpsz_cd",           KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:1, InsertEdit:1 });
			}
				cols.push({ Type:"Float",    Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"trsp_rfnd_qty",        KeyField:0, CalcLogic:"", Format:"Float", PointCount:2, UpdateEdit:1, InsertEdit:1 });
				cols.push({ Type:"Float",    Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"trsp_rfnd_uc_rt",      KeyField:0, CalcLogic:"", Format:"Float", PointCount:2, UpdateEdit:1, InsertEdit:1 });
				cols.push({ Type:"Float",    Hidden:0, Width:100, Align:"Right",  ColMerge:1, SaveName:"trsp_rfnd_inv_amt",    KeyField:0, CalcLogic:"|trsp_rfnd_qty|*|trsp_rfnd_uc_rt|+|inv_nego_amt|", Format:"Float", PointCount:2, UpdateEdit:0, InsertEdit:0 });
				cols.push({ Type:"Float",    Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"inv_nego_amt",         KeyField:0, CalcLogic:"", Format:"Float", PointCount:2, UpdateEdit:1, InsertEdit:1 });
				cols.push({ Type:"Date",     Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"hndl_prd_fm_dt",       KeyField:0, CalcLogic:"", Format:"Ymd", PointCount:0, UpdateEdit:1, InsertEdit:1 });
				cols.push({ Type:"Date",     Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"hndl_prd_to_dt",       KeyField:0, CalcLogic:"", Format:"Ymd", PointCount:0, UpdateEdit:1, InsertEdit:1 });
				cols.push({ Type:"Text",     Hidden:1, Width:70,  Align:"Center", ColMerge:1, SaveName:"sub_inv_seq",          KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:1, InsertEdit:1 });
				cols.push({ Type:"Text",     Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"result",               KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 });

			InitColumns(cols);
			SetEditable(1);
			SetHeaderRowHeight(20);
			SetHeaderRowHeight(21);
			ComResizeSheet(sheetObj);
			SetColProperty('trsp_cost_dtl_mod_cd', { ComboText : trsp_cost_dtl_mod_cdText, ComboCode : trsp_cost_dtl_mod_cdCode });
			SetColProperty('trsp_crr_mod_cd', { ComboText : trsp_crr_mod_cdText, ComboCode : trsp_crr_mod_cdCode });
		}
		break;
	case 2:
		with (sheetObj) {
			var HeadTitle = "STS|Vendor|Vendor|Payment Vendor|Payment Vendor|INV No.|Issue Date|Receive Date|Basic Amt|VAT Amt|TAX Amt|TOTAL Amt";
			SetConfig({ SearchMode : 0, DataRowMerge : 0 });

			var info = { Sort : 1, ColMove : 0, ColResize : 1, HeaderCheck : 1 };
			var headers = [
				{ Text : HeadTitle, Align : "Center" }
			];
			InitHeaders(headers, info);

			var cols = [
				{ Type:"Status", Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:"ibflag",           KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
				{ Type:"Text",   Hidden:0, Width:50, Align:"Center", ColMerge:1, SaveName:"wo_vndr_seq",      KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
				{ Type:"Text",   Hidden:0, Width:50, Align:"Center", ColMerge:1, SaveName:"wo_vndr_nm",       KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
				{ Type:"Text",   Hidden:0, Width:50, Align:"Center", ColMerge:1, SaveName:"paymt_vndr_seq",   KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
				{ Type:"Text",   Hidden:0, Width:50, Align:"Center", ColMerge:1, SaveName:"paymt_vndr_nm",    KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
				{ Type:"Text",   Hidden:0, Width:50, Align:"Center", ColMerge:1, SaveName:"inv_no",           KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
				{ Type:"Text",   Hidden:0, Width:50, Align:"Center", ColMerge:1, SaveName:"inv_iss_dt",       KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
				{ Type:"Text",   Hidden:0, Width:50, Align:"Center", ColMerge:1, SaveName:"inv_rcv_dt",       KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
				{ Type:"Text",   Hidden:0, Width:50, Align:"Center", ColMerge:1, SaveName:"inv_bzc_amt",      KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
				{ Type:"Text",   Hidden:0, Width:50, Align:"Center", ColMerge:1, SaveName:"inv_vat_amt",      KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
				{ Type:"Text",   Hidden:0, Width:50, Align:"Center", ColMerge:1, SaveName:"inv_whld_tax_amt", KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
				{ Type:"Text",   Hidden:0, Width:50, Align:"Center", ColMerge:1, SaveName:"inv_ttl_amt",      KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 }
			];
			InitColumns(cols);
			SetVisible(false);
		}
		break;
	}
}

function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBROWSEARCH:
		formObj.f_cmd.value = SEARCH01;
		var xml = sheetObj.GetSearchData("ESD_TRS_0040GS.do", TrsFrmQryString(formObj));
		ComEtcDataToForm(document.form, sheetObj);
		sheetObj.RemoveEtcData();
		break;
	case IBSEARCH:
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchData("ESD_TRS_0040GS.do", TrsFrmQryString(formObj));
		var inv_flag = ComGetEtcData(sXml, 'inv_flag');
		if (parseInt(inv_flag) > 0) {
			errMsg = ComGetMsg("TRS90126");
			ComShowMessage(errMsg);
			formObj.inv_no.value = "";
			formObj.inv_no.focus();
		} else {
			ComEnableObject(document.form.inv_no, false);
			ComEnableObject(document.form.inv_curr_cd, false);
			apflag = true;
		}
		break;
	case IBSAVE:
		formObj.f_cmd.value = MULTI;
		sheetObj.DoSave("ESD_TRS_0040GS.do", TrsFrmQryString(formObj), "sel", false);
		break;
	case IBINSERT:
		var row = sheetObj.DataInsert();
		break;
	case IBCOPYROW:
		sheetObj.DataCopy();
		break;
	case IBDOWNEXCEL:
		if (sheetObj.RowCount() == 0) {
			ComShowCodeMessage("COM132501");
			return;
		} else {
			sheetObj.Down2Excel({ DownCols : makeHiddenSkipCol_TRS(sheetObj), SheetDesign : 1, Merge : 1 });
		}
		break;
	case IBLOADEXCEL:
		if (sheetObj.RowCount() == 0) {
			ComShowCodeMessage("COM132501");
			return;
		} else {
			sheetObj.LoadExcel();
		}
		break;
	}
}

function doActionIBSheet2(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH:
		formObj.f_cmd.value = SEARCHLIST;
		sheetObj.DoSearch("ESD_TRS_0040GS.do", TrsFrmQryString(formObj));
		break;
	}
}

function checkInput(fromObj) {
	if (ComIsNull(fromObj.combo_svc_provider) || ComIsNull(fromObj.combo_svc_provider.value)) {
		ComShowMessage(ComGetMsg("TRS90124"));
		return false;
	}
	if (ComIsNull(fromObj.svc_provider) || ComIsNull(fromObj.svc_provider.value)) {
		ComShowMessage(ComGetMsg("TRS90124"));
		return false;
	}
	if (ComIsNull(fromObj.paymt_sp_cd) || ComIsNull(fromObj.paymt_sp_cd.value)) {
		ComShowMessage(ComGetMsg("TRS90124"));
		return false;
	}
	if (ComIsNull(fromObj.inv_no) || ComIsNull(fromObj.inv_no.value)) {
		ComShowMessage(ComGetMsg("TRS90124"));
		return false;
	}
	if (ComIsNull(fromObj.inv_rcv_dt) || ComIsNull(fromObj.inv_rcv_dt.value)) {
		ComShowMessage(ComGetMsg("TRS90124"));
		return false;
	}
	if (ComIsNull(fromObj.inv_iss_dt) || ComIsNull(fromObj.inv_iss_dt.value)) {
		ComShowMessage(ComGetMsg("TRS90124"));
		return false;
	}
	if (ComIsNull(fromObj.inv_curr_cd) || ComIsNull(fromObj.inv_curr_cd.value) || (fromObj.inv_curr_cd.value == 'ALL')) {
		ComShowMessage(ComGetMsg("TRS90124"));
		return false;
	}
	if (ComIsNull(fromObj.inv_bzc_amt) || ComIsNull(fromObj.inv_bzc_amt.value)) {
		ComShowMessage(ComGetMsg("TRS90124"));
		return false;
	} else {
		if (parseFloat(fromObj.inv_bzc_amt.value) > 0) {
			ComShowMessage(ComGetMsg("COM130201", "negative number"));
			return false;
		}
	}
	if (ComIsNull(fromObj.inv_vat_amt) || ComIsNull(fromObj.inv_vat_amt.value)) {
		ComShowMessage(ComGetMsg("TRS90124"));
		return false;
	} else {
		if (parseFloat(fromObj.inv_vat_amt.value) > 0) {
			ComShowMessage(ComGetMsg("COM130201", "negative number"));
			return false;
		}
	}
	if (ComIsNull(fromObj.inv_whld_tax_amt) || ComIsNull(fromObj.inv_whld_tax_amt.value)) {
		ComShowMessage(ComGetMsg("TRS90124"));
		return false;
	} else {
		if (parseFloat(fromObj.inv_whld_tax_amt.value) > 0) {
			ComShowMessage(ComGetMsg("COM130201", "negative number"));
			return false;
		}
	}

	return true;
}

function chkComfirm() {
	var insflag = document.form.insflag.value;
	if (insflag == "false") {
		errMsg = ComGetMsg("TRS90002");
		ComShowMessage(errMsg);
		return true;
	}
	return false;
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
	var xx1 = ""; // CONTI
	var xx2 = ""; // SUB CONTI
	var xx3 = ""; // COUNTRY
	var xx4 = ""; // STATE
	var xx5 = ""; // CONTROL OFFIC
	var xx6 = ""; // LOC CODE
	var xx7 = ""; // LOC NAME
	var xx8 = "";
	var xx9 = "";
	var param = "?conti_cd=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
	ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 653, 481, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}

function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if (ErrMsg != "")
		return;
	errMsg = ComGetMsg("TRS90002");
	ComShowMessage(errMsg);
	document.form.insflag.value = "false";
}

function sheet1_OnChange(sheetObj, row, col, value) {
	var colSaveNm = sheetObj.ColSaveName(col);
	if (colSaveNm == "trsp_cost_dtl_mod_cd") {
		if (value.charAt(0) == "G") {
			var info = { "ComboCode" : gn_tpszCode, "ComboText" : gn_tpszCode };
			sheetObj.CellComboItem(row, "eq_tpsz_cd", info);
			sheetObj.SetCellValue(row, "eq_tpsz_cd", "", 0);
		} else if (value.charAt(0) == "H") {
			var info = { "ComboCode" : ch_tpszCode, "ComboText" : ch_tpszCode };
			sheetObj.CellComboItem(row, "eq_tpsz_cd", info);
			sheetObj.SetCellValue(row, "eq_tpsz_cd", "", 0);
		} else {
			var info = { "ComboCode" : eq_tpszCode, "ComboText" : eq_tpszCode };
			sheetObj.CellComboItem(row, "eq_tpsz_cd", info);
			sheetObj.SetCellValue(row, "eq_tpsz_cd", "", 0);
		}
	} else if (colSaveNm == "trsp_rfnd_uc_rt") {
		if (parseFloat(value) > 0) {
			sheetObj.SetCellValue(row, colSaveNm, "0.00", 0);
		}
	} else if (colSaveNm == "trsp_rfnd_qty") {
		if (parseFloat(value) < 0) {
			sheetObj.SetCellValue(row, colSaveNm, "0.00", 0);
		}
	}
	return false;
}

function sheet2_OnSearchEnd(sheetObj, errMsg) {
    var formObj = document.form;
    if( errMsg != null && errMsg != 0 && errMsg != -1) {
        ComShowMessage(errMsg);
        formObj.f_cmd.value = '';
    }else{
        if( formObj.f_cmd.value == SEARCH04) {
            if(sheetObj.RowCount() == 0) {
                ComShowCodeMessage('TRS90132');
                return;
            } else {
                bindForm(sheetObj, formObj);
            }
            
            var invDtlXml = sheetObj.GetEtcData("invDtl");
            if( invDtlXml == undefined || ComTrim(invDtlXml) == '') {
                return;
            }
            invDtlXml = '<?xml version="1.0"  ?>' + invDtlXml;
            invDtlXml = invDtlXml.replace(new RegExp("<TD>", "gi"), '<TD><![CDATA[');
            invDtlXml = invDtlXml.replace(new RegExp("</TD>", "gi"), ']]></TD>');
            sheetObjects[0].LoadSearchData(invDtlXml, {Append:1 , Sync:1} );
            sheetObj.RemoveEtcData();
        }
    }
}

function checkInputData(sheetObj, totAmtChkFlg) {
	var eq_comboCode = "";
	var cost_comboCode = sheetObj.GetComboInfo(0, "trsp_cost_dtl_mod_cd", "Code");
	var crr_comboCode = sheetObj.GetComboInfo(0, "trsp_crr_mod_cd", "Code");
	var flag = true;
	var dtflag = true;
	var vflag = true;
	if (sheetObj.CheckedRows('sel') == 0 || sheetObj.CheckedRows('sel') == null) {
		ComShowCodeMessage('TRS90215');
		return false;
	}
	var chkrows = sheetObj.FindCheckedRow("sel");
	var arrRow = chkrows.split("|");
	for (idx = 0; idx < arrRow.length; idx++) {
		row = arrRow[idx];
		sheetObj.SetRowBackColor(row, "#FFFFFF");
		if (cost_comboCode.indexOf(sheetObj.GetCellValue(row, "trsp_cost_dtl_mod_cd")) == 0) {
			sheetObj.SetCellBackColor(row, "trsp_cost_dtl_mod_cd", "#FF0000");
			sheetObj.SetCellBackColor(row, "eq_tpsz_cd", "#FF0000");
			flag = false;
		} else {
			sheetObj.SetCellBackColor(row, "trsp_cost_dtl_mod_cd", "#FFFFFF");
			sheetObj.SetCellBackColor(row, "eq_tpsz_cd", "#FFFFFF");
		}
		if (parseInt(crr_comboCode.indexOf(sheetObj.GetCellValue(row, "trsp_crr_mod_cd"))) == 0) {
			sheetObj.SetCellBackColor(row, "trsp_crr_mod_cd", "#FF0000");
			flag = false;
		} else {
			sheetObj.SetCellBackColor(row, "trsp_crr_mod_cd", "#FFFFFF");
		}
		eq_comboCode = " |" + sheetObj.GetComboInfo(row, "eq_tpsz_cd", "Code");
		if (parseInt(eq_comboCode.indexOf(sheetObj.GetCellText(row, "eq_tpsz_cd"))) == 0) {
			sheetObj.SetCellBackColor(row, "eq_tpsz_cd", "#FF0000");
			flag = false;
		} else {
			sheetObj.SetCellBackColor(row, "eq_tpsz_cd", "#FFFFFF");
		}
		if (isNaN(sheetObj.GetCellValue(row, "trsp_rfnd_qty")) || sheetObj.GetCellValue(row, "trsp_rfnd_qty") == "") {
			sheetObj.SetCellBackColor(row, "trsp_rfnd_qty", "#FF0000");
			flag = false;
		} else {
			sheetObj.SetCellBackColor(row, "trsp_rfnd_qty", "#FFFFFF");
		}
		if (isNaN(sheetObj.GetCellValue(row, "trsp_rfnd_uc_rt")) || sheetObj.GetCellValue(row, "trsp_rfnd_uc_rt") == "") {
			sheetObj.SetCellBackColor(row, "trsp_rfnd_uc_rt", "#FF0000");
			flag = false;
		} else {
			sheetObj.SetCellBackColor(row, "trsp_rfnd_uc_rt", "#FFFFFF");
		}
		if (sheetObj.GetCellValue(row, "hndl_prd_fm_dt").replace(/-/gi, "").length != 8) {
			sheetObj.SetCellBackColor(row, "hndl_prd_fm_dt", "#FF0000");
			flag = false;
			dtflag = false;
		} else {
			sheetObj.SetCellBackColor(row, "hndl_prd_fm_dt", "#FFFFFF");
		}
		if (sheetObj.GetCellValue(row, "hndl_prd_to_dt").replace(/-/gi, "").length != 8) {
			sheetObj.SetCellBackColor(row, "hndl_prd_to_dt", "#FF0000");
			flag = false;
			dtflag = false;
		} else {
			sheetObj.SetCellBackColor(row, "hndl_prd_to_dt", "#FFFFFF");
		}
		if (dtflag) {
			if (parseInt(sheetObj.GetCellValue(row, "hndl_prd_fm_dt").replace(/-/gi, "")) > parseInt(sheetObj.GetCellValue(row, "hndl_prd_to_dt").replace(/-/gi, ""))) {
				sheetObj.SetCellBackColor(row, "hndl_prd_fm_dt", "#FF0000");
				sheetObj.SetCellBackColor(row, "hndl_prd_to_dt", "#FF0000");
				flag = false;
			} else {
				sheetObj.SetCellBackColor(row, "hndl_prd_fm_dt", "#FFFFFF");
				sheetObj.SetCellBackColor(row, "hndl_prd_to_dt", "#FFFFFF");
			}
		}
		if (totAmtChkFlg) {
			if (flag) {
				sheetObj.SetCellValue(row, "result", "Good", 0);
			} else {
				sheetObj.SetCellValue(row, "result", "Incorrect", 0);
				vflag = false;
			}
		} else {
			sheetObj.SetCellValue(row, "result", ComGetMsg("TRS90006"), 0);
			vflag = false;
		}

		flag = true;
		dtflag = true;
	}
	var irow;
	var jrow;
	var dupflag = false;
	var selrows = sheetObj.FindCheckedRow("sel");
	var chkRow = selrows.split("|");
	var dupRow = chkRow;
	for (i = 0; i < chkRow.length - 1; i++) {
		dupflag = false;
		if (dupRow[i] == 0)
			continue;
		irow = chkRow[i];
		for (j = i + 1; j < chkRow.length - 1; j++) {
			jrow = chkRow[j];
			if (sheetObj.GetCellValue(irow, "trsp_cost_dtl_mod_cd") == sheetObj.GetCellValue(jrow, "trsp_cost_dtl_mod_cd")) {
				if (sheetObj.GetCellValue(irow, "trsp_crr_mod_cd") == sheetObj.GetCellValue(jrow, "trsp_crr_mod_cd")) {
					if (sheetObj.GetCellValue(irow, "eq_tpsz_cd") == sheetObj.GetCellValue(jrow, "eq_tpsz_cd")) {
						sheetObj.SetRowBackColor(irow, "#EEFFE2");
						sheetObj.SetRowBackColor(jrow, "#EEFFE2");
						sheetObj.SetCellValue(irow, "result", "Dup", 0);
						sheetObj.SetCellValue(jrow, "result", "Dup", 0);
						dupflag = true;
						vflag = false;
					}
				}
			}
			if (dupflag)
				dupRow[j] = 0;
		}
	}
	return vflag;
}

/**
 * Get a list of external combo box
 */
function getVendorComboList() {
	var formObj = document.form;
	var vendorNo = formObj.combo_svc_provider.GetSelectText();
	getVendorCombo(document.combo_svc_provider, sheetObjects[0], formObj, vendorNo);
}

function wo_vndr_seq_OnKeyDown(combo, keycode, shift) {
	if (keycode == 13) {
		searchVendorName(combo);
	}
}

function searchVendorName(combo) {
	var formObject = document.form;
	formObject.f_cmd.value = SEARCH11;
	formObject.hid_provider.value = combo.GetSelectText()
	document.form.svc_provider.value = combo.GetText(combo.GetSelectText(), 1);
}

/**
 * When selecting service provider combo of events that change the value of a textfield
 */
function wo_vndr_seq_OnChange(combo, Index_Code, Text) {
	var formObj = document.form;
	document.form.svc_provider.value = combo.GetText(Index_Code, 1);
	formObj.hid_svc_provider.value = (formObj.combo_svc_provider.GetSelectCode()).toUpperCase();
}

function wo_vndr_seq_OnBlur(combo) {
	if (document.form.svc_provider.value == "")
		return;
	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH);
}

/**
 * Click on event-related MInimize
 */
function Minimize(nItem) {
	var objs = document.all.item("showMin");
	if (nItem == "1") {
		objs.style.display = "none";
	} else {
		objs.style.display = "inline";
	}
	ComResizeSheet(sheet1);
}

function checkDateFormat(dt) {
	var date_regexp = "^(\\d{4}-\\d{2}-\\d{2})$";
	if (!checkFormat(dt, date_regexp)) {
		return false;
	}
	return true;
}

function BlurDate(obj) {
	if (obj.value == "") {
		return;
	}
	if (!ComIsDate(obj)) {
		errMsg = ComGetMsg("COM12179");
		ComShowMessage(errMsg);
		obj.focus();
		return;
	} else {
		rsdate = addBar(obj.value);
		obj.value = rsdate;
	}
}

// Date format yyyy-mm-dd
function addBar(dt) {
	var dat = "";
	if (dt.length == 8) {
		dat = dt.substr(0, 4) + '-' + dt.substr(4, 2) + '-' + dt.substr(6, 2);
	}
	return dat;
}

function fun_Focus_del(obj) {
	date = obj.value.replace(/\/|\-|\./g, "");
	obj.value = date;
}

function checkFormat(object, regexp) {
	if (object == null || object == "") {
		return false;
	} else {
		re = new RegExp(regexp, "gi");
		if (!re.test(object)) {
			return false;
		}
	}
	return true;
}

function sumAmt() {
	var bac_amt = 0;
	var vat_amt = 0;
	var wht_amt = 0;
	if (document.form.inv_bzc_amt.value != "") {
		bac_amt = ComReplaceStr(document.form.inv_bzc_amt.value, '.', '');
	} else {
		document.form.inv_bzc_amt.value = '0.00';
	}
	if (document.form.inv_vat_amt.value != "") {
		vat_amt = ComReplaceStr(document.form.inv_vat_amt.value, '.', '');
	} else {
		document.form.inv_vat_amt.value = '0.00';
	}
	if (document.form.inv_whld_tax_amt.value != "") {
		wht_amt = ComReplaceStr(document.form.inv_whld_tax_amt.value, '.', '');
	} else {
		document.form.inv_whld_tax_amt.value = '0.00';
	}
	document.form.inv_ttl_amt.value = parseFloat(bac_amt) + parseFloat(vat_amt) + parseFloat(wht_amt);
	var curr_value = document.form.inv_curr_cd.value;
	if (!(curr_value == "KRW" || curr_value == "JPY" || curr_value == "TWD")) {
		document.form.inv_ttl_amt.value = addComma1(document.form.inv_ttl_amt.value);
	}
	chkAmtFmtObj(document.form.inv_ttl_amt);
}

function isMon(obj, isChkFmt) {
	if (!ComIsNumber(obj.value, '-.,')) {
		obj.value = '';
	}
	if (isChkFmt != undefined && isChkFmt != null && isChkFmt == 'Y') {
		var src = deleteComma(obj.value);
		if (src.indexOf('.') != -1) {
			if (src.length - 1 > src.indexOf('.') + 2) {
				src = src.substring(0, src.indexOf('.') + 3);
				obj.value = src;
			}
			if (src.indexOf('.') != src.lastIndexOf('.')) {
				src = src.substring(0, src.lastIndexOf('.'));
				obj.value = chkAmtFmt(src);
			}
		}
	}
}

function chkAmtFmtObj(obj) {
	if (obj.value == null || obj.value.trim() == '') {
		return false;
	}
	if (parseFloat(ComTrim(obj.value)) > 0) {
		obj.value = "0.00";
		return false;
	}
	obj.value = chkAmtFmt(obj.value);
}

function chkAmtFmt(src) {
	if (src == undefined || src == null || ComTrim(src) == '') {
		return "";
	}
	if (document.form.inv_curr_cd.value == "KRW" || document.form.inv_curr_cd.value == "JPY" || document.form.inv_curr_cd.value == "TWD") {
		if (src.indexOf('.') != -1) {
			src.value = "";
			ComShowMessage(ComGetMsg("COM12136", "KRW, JPY, TWD"));
			return "";
		}
	} else {
		if (src.indexOf('.') == -1) {
			src = src + '.00';
		} else {
			var temp = src.split(".");
			if (temp.length == 2) {
				if (temp[1] == null || ComTrim(temp[1]) == '') {
					temp[1] = '00';
				}
				if (temp[1].length == 1) {
					temp[1] += '0';
				} else if (temp[1].length == 2) {
				} else if (temp[1].length > 2) {
					temp[1] = temp[1].substring(0, 2);
				}
				src = temp[0] + '.' + temp[1];
			} else if (temp.length > 2) {
				// Second. From. To delete it and recalculate
				var tmp_str = '';
				for ( var i = 1; i < temp.length; i++) {
					tmp_str += ComTrim(new String(temp[i]));
				}
				if (tmp_str == null || ComTrim(tmp_str) == '') {
					tmp_str = '00';
				}
				if (tmp_str.length == 1) {
					tmp_str += '0';
				} else if (tmp_str.length == 2) {
				} else if (tmp_str.length > 2) {
					tmp_str = tmp_str.substring(0, 2);
				}
				src = temp[0] + '.' + tmp_str;
			} else {
				return false;
			}
		}
	}
	return src;
}

function chkInput(obj) {
	if (obj.maxLength < getStrLen(obj.value)) {
		obj.value = '';
		obj.focus();
		return false;
	}
}

function deleteComma(src) {
	if (src == null || ComTrim(src) == '') {
		return '';
	}
	return ComReplaceStr(src, '.', '');
}

function addComma1(src) {
	// putting a comma every three digits
	var src = String(src);
	if (src == null || ComTrim(src) == '') {
		return '';
	}
	var re = /(-?\d+)(\d{2})/;
	if (re.test(src)) {
		src = src.replace(re, "$1.$2");
	}
	return src;
}

function getStrLen(src) {
	// Wanted Hangul and English on the length of str
	src = new String(src);
	var byteLength = 0;
	for ( var inx = 0; inx < src.length; inx++) {
		var oneChar = escape(src.charAt(inx));
		if (oneChar.length == 1) {
			byteLength++;
		} else if (oneChar.indexOf("%u") != -1) {
			byteLength += 2;
		} else if (oneChar.indexOf("%") != -1) {
			byteLength += oneChar.length / 3;
		}
	}
	return byteLength;
}

function checkCurr(curr_value) {
	if (curr_value == "KRW" || curr_value == "JPY" || curr_value == "TWD") {
		sheetObjects[0].SetColProperty(0, 6, { Type : "Int", Hidden : 0, Width : 70, Align : "Right", ColMerge : 1, SaveName : "trsp_rfnd_qty", KeyField : 0, CalcLogic : "", Format : "Int", PointCount : 2, UpdateEdit : 1, InsertEdit : 1 });
		sheetObjects[0].SetColProperty(0, 7, { Type : "Int", Hidden : 0, Width : 70, Align : "Right", ColMerge : 1, SaveName : "trsp_rfnd_uc_rt", KeyField : 0, CalcLogic : "", Format : "Int", PointCount : 2, UpdateEdit : 1, InsertEdit : 1 });
		sheetObjects[0].SetColProperty(0, 8, { Type : "Int", Hidden : 0, Width : 100, Align : "Right", ColMerge : 1, SaveName : "trsp_rfnd_inv_amt", KeyField : 0, CalcLogic : "|trsp_rfnd_qty|*|trsp_rfnd_uc_rt|+|inv_nego_amt|", Format : "Int", PointCount : 2, UpdateEdit : 1, InsertEdit : 0 });
		sheetObjects[0].SetColProperty(0, 9, { Type : "Int", Hidden : 0, Width : 70, Align : "Right", ColMerge : 1, SaveName : "inv_nego_amt", KeyField : 0, CalcLogic : "", Format : "Int", PointCount : 2, UpdateEdit : 1, InsertEdit : 1 });
		document.form.inv_bzc_amt.value = parseInt(document.form.inv_bzc_amt.value);
		document.form.inv_vat_amt.value = parseInt(document.form.inv_vat_amt.value);
		document.form.inv_whld_tax_amt.value = parseInt(document.form.inv_whld_tax_amt.value);
		document.form.inv_ttl_amt.value = parseInt(document.form.inv_ttl_amt.value);
	} else {
		sheetObjects[0].SetColProperty(0, 6, { Type : "Float", Hidden : 0, Width : 70, Align : "Right", ColMerge : 1, SaveName : "trsp_rfnd_qty", KeyField : 0, CalcLogic : "", Format : "Float", PointCount : 2, UpdateEdit : 1, InsertEdit : 1 });
		sheetObjects[0].SetColProperty(0, 7, { Type : "Float", Hidden : 0, Width : 70, Align : "Right", ColMerge : 1, SaveName : "trsp_rfnd_uc_rt", KeyField : 0, CalcLogic : "", Format : "Float", PointCount : 2, UpdateEdit : 1, InsertEdit : 1 });
		sheetObjects[0].SetColProperty(0, 8, { Type : "Float", Hidden : 0, Width : 100, Align : "Right", ColMerge : 1, SaveName : "trsp_rfnd_inv_amt", KeyField : 0, CalcLogic : "|trsp_rfnd_qty|*|trsp_rfnd_uc_rt|+|inv_nego_amt|", Format : "Float", PointCount : 2, UpdateEdit : 1, InsertEdit : 0 });
		sheetObjects[0].SetColProperty(0, 9, { Type : "Int", Hidden : 0, Width : 70, Align : "Right", ColMerge : 1, SaveName : "inv_nego_amt", KeyField : 0, CalcLogic : "", Format : "Int", PointCount : 2, UpdateEdit : 1, InsertEdit : 1 });
	}
	sumAmt();
}

String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}

function getSaveString(params) {
	var saveString = null;
	if (params == null) {
		saveString = "";
	} else {
		saveString = params.join("&");
	}
	return saveString;
}

/**
 * WO Vendor Inquiry
 */
function getVendorSeq() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	var vndr_seq = formObj.combo_svc_provider.value;
	
	// 2016.03.31 CHAN WOO PARK
	// W/O S/P number validation 로직 추가
	var temp = get_only_num(vndr_seq);
    if(temp != vndr_seq) {
    	formObj.combo_svc_provider.value = "";
    	return;
    }
	
	formObj.f_cmd.value = SEARCH03;
	formObj.TRSP_SO_VNDR_NO.value = temp;
	sheetObj.RemoveEtcData();

	var sXml = sheetObj.GetSearchData("ESD_TRS_0040GS.do", TrsFrmQryString(formObj), { sync : 1 });
	var vendorNoList = ComGetEtcData(sXml, 'vndr_no');
	var vendorNmList = ComGetEtcData(sXml, 'vndr_nm_eng');
	var comboObj = paymt_sp_combo;
	if (vendorNoList == undefined || vendorNoList == '') {
		formObj.combo_svc_provider.value = '';
		formObj.svc_provider.value = '';
		formObj.paymt_sp_cd.value = '';
		formObj.paymt_sp_nm.value = '';
		comboObj.RemoveAll();
		return false;
	}
	formObj.combo_svc_provider.value = lpad(vendorNoList, 6, '0');
	formObj.svc_provider.value = vendorNmList;
	searchPaymentSP(sheetObjects[0], formObj, vendorNoList);
}

/** ** Find PAYMENT SP for WO SP. *** */
function searchPaymentSP(sheetObj, formObj, wo_sp_value) {
	formObj.f_cmd.value = SEARCH02;
	var query = TrsFrmQryString(formObj);
	sheetObj.RemoveEtcData();
	var sXml = sheetObj.GetSearchData('ESD_TRS_0033GS.do', query);
	var prnt_vndr_seq = ComGetEtcData(sXml, 'prnt_vndr_seq');
	var prnt_vndr_nm = ComGetEtcData(sXml, 'prnt_vndr_nm');

	var comboObj = paymt_sp_combo;
	comboObj.RemoveAll();
	comboObj.InsertItem(-1, formObj.combo_svc_provider.value, formObj.svc_provider.value);
	if (prnt_vndr_seq == null || prnt_vndr_seq == '') {
		ComShowMessage(ComGetMsg('TRS90065'));
	} else if (lpad(prnt_vndr_seq, 6, '0') != lpad(wo_sp_value, 6, '0')) {
		comboObj.InsertItem(-1, lpad(prnt_vndr_seq, 6, '0'), prnt_vndr_nm);
	}
	comboObj.SetSelectIndex(0, false);
	formObj.paymt_sp_cd.value = comboObj.GetSelectText();
	formObj.paymt_sp_nm.value = comboObj.GetSelectCode();
}

// Change the value which occurs when payment vendor defined evnet
function paymt_sp_combo_OnChange(comboObj, index_code, text) {
	var formObj = document.form;
	formObj.paymt_sp_cd.value = comboObj.GetSelectText();
	formObj.paymt_sp_nm.value = comboObj.GetSelectCode();
}

// rep_commodity pop-up Call: hangyeongwoo single selection from a pop-up.
function getCOM_ENS_rep(rowArray) {
	var formObj = document.form;
	for ( var i = 0; i < rowArray.length; i++) {
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[4];
		formObj.combo_svc_provider.value = colArray2;
		formObj.svc_provider.value = colArray3;
	}
	searchPaymentSP(sheetObjects[0], formObj, formObj.combo_svc_provider.value);
}