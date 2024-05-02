/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_TRS_0041.js
 *@FileTitle : Pool Chassis reposition cost 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/

/**------------------From here the common JavaScript function is defined.     ------------------*/
/** Common global variable */
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;
var apflag = false;
var sflag = 'I';
var confirm_flag = false;
var isNew = true;
var poolNameComboListLoadFinished = false;
/** Event handler processing by button click event */
document.onclick = processButtonClick;
/**
 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initChssPoolCombo(chss_pool_cd);
	getChssPoolList();
	ComEnableObject(document.form.chss_pool_nm, false);
	ComEnableObject(document.form.paymt_sp, false);
	ComEnableObject(document.form.paymt_sp_nm, false);
	ComEnableObject(document.form.inv_bzc_amt, false);
	ComEnableObject(document.form.inv_vat_amt, false);
	ComEnableObject(document.form.inv_ttl_amt, false);
	ComEnableObject(document.form.ofc_cd, false);
	ComEnableObject(document.form.usr_id, false);
	var sheetObject = sheetObjects[0];

    if(document.form.mode_param.value != '') { // Called by Pop-up from Inquiry(ESD_TRS_0030)
		isNew = false;
    	document.form.inv_no.value = document.form.inv_no_param.value;
    	document.form.paymt_sp.value = document.form.inv_vndr_seq_param.value;
    	document.form.paymt_sp_cd.value = document.form.inv_vndr_seq_param.value;
    	document.form.paymt_sp_nm.value = document.form.inv_vndr_nm_param.value;
		setTimeout( 
				function () {
	                if(poolNameComboListLoadFinished) {
	                    ComOpenWait(false);
	    				doActionIBSheet(sheetObjects[0], document.form, 'RETRIEVE');
	                }
				}, 300);
    } else {
    	isNew = true;
    	sheetObject.DataInsert();
    	sheetObject.DataInsert();
    	sheetObject.DataInsert();
    	sheetObject.DataInsert();
    	sheetObject.DataInsert();
    }
}

/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
		case 1: {
			with (sheetObj) {
				var HeadTitle = "Del.|STS|Sel.|Quantity|Invoice Amount|Tax Amount|Handling Period|Handling Period";
				var HeadTitle1 = "Del.|STS|Sel.|Quantity|Invoice Amount|Tax Amount|From Date|To Date";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 0, HeaderCheck : 1, ColResize : 1 };
				var headers = [{ Text : HeadTitle, Align : "Center" }, { Text : HeadTitle1, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [ 
				            	{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				            	{Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				            	{Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sel",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				            	{Type:"Int",       Hidden:0,  Width:180,  Align:"Right",   ColMerge:1,   SaveName:"trsp_pool_chss_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
				            	{Type:"Float",     Hidden:0,  Width:200,  Align:"Right",   ColMerge:1,   SaveName:"trsp_pool_chss_inv_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
				            	{Type:"Float",     Hidden:0,  Width:180,  Align:"Right",   ColMerge:1,   SaveName:"trsp_pool_chss_tax_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
				            	{Type:"Date",      Hidden:0,  Width:185,  Align:"Center",  ColMerge:1,   SaveName:"hndl_prd_fm_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				            	{Type:"Date",      Hidden:0,  Width:185,  Align:"Center",  ColMerge:1,   SaveName:"hndl_prd_to_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				            	{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sub_inv_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } 
			               ];
				InitColumns(cols);
				SetEditable(1);
				SetHeaderRowHeight(20);
				SetHeaderRowHeight(21);
				ComResizeSheet(sheetObj);
			}
			break;
		}
	}
}
// Event handler processing by button name */
function processButtonClick() {
	/** ***Case more than two additional sheets tab sheet is used to specify a variable **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObj = document.form;
	var comboObj = chss_pool_cd;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_minimize": {
				if(document.all.showMin.style.display != "none") {
			        document.all.showMin.style.display="none";                
			    } else {
			        document.all.showMin.style.display="";                
			    }
				ComResizeSheet(sheetObjects[0]);
				break;
			}

			case "btns_calendar1": {
				var cal = new ComCalendar();
				cal.select(formObj.inv_rcv_dt, 'yyyy-MM-dd');
				break;
			}
			case "btns_calendar2": {
				var cal = new ComCalendar();
				cal.select(formObj.inv_iss_dt, 'yyyy-MM-dd');
				break;
			}
			case "btn_new": {
				sheetObject.RemoveAll();
				sheetObject.SetColProperty(0, 4, { PointCount : 2 });
				sheetObject.SetColProperty(0, 5, { PointCount : 2 });
				// 기본 5줄 표시
				sheetObject.DataInsert();
				sheetObject.DataInsert();
				sheetObject.DataInsert();
				sheetObject.DataInsert();
				sheetObject.DataInsert();
				formObj.reset();
				chss_pool_cd.SetSelectCode("");
				chss_pool_cd.SetSelectText("");
				chss_pool_cd.SetEnable(1);
				formObj.inv_no.disabled = false;
				// formObj.pool_chss_cost_yrmon.value = currentYearMonth;
				sflag = 'I';
				apflag = false;
				inv_flag = 0;
				formObj.rgst_no.value = '';
				formObj.insflag.value = 'true';
				formObj.trsp_inv_aud_sts_cd.value = '';
				isNew = true;
				confirm_flag = false;
				break;
			}
			// 'Retrieve' Button Click
			case "btn_retrieve": {
				if (ComIsNull(formObj.pool_chss_cost_yrmon) || ComIsNull(formObj.pool_chss_cost_yrmon.value)) {
					ComShowCodeMessage("COM12114", "COST MONTH");
					formObj.pool_chss_cost_yrmon.focus();
					return false;
				}
				if (ComIsNull(formObj.chss_pool_nm) || ComIsNull(formObj.chss_pool_nm.value)) {
					ComShowCodeMessage("COM12114", "Pool Name");
					return false;
				}
				if (ComIsNull(formObj.paymt_sp_cd) || ComIsNull(formObj.paymt_sp_cd.value)) {
					ComShowCodeMessage("COM12114", "Payment Service Provider");
					return false;
				}
				if (ComIsNull(formObj.inv_no) || ComIsNull(formObj.inv_no.value)) {
					ComShowCodeMessage("COM12114", "Invoice No");
					formObj.inv_no.focus();
					return false;
				}
				doActionIBSheet(sheetObject, formObj, 'RETRIEVE');
				isNew = false;
				break;
			}
			// 'Row Add' Button Click
			case "btng_rowadd": {
				if(document.getElementsByName(srcName)[0].disabled) return;
				if (formObj.trsp_inv_aud_sts_cd.value == 'CF')
					confirm_flag = true;
				else
					confirm_flag = false;
				if (!isNew && apflag) {
					ComShowMessage(ComGetMsg("TRS90380"));
					return false;
				}
				if (confirm_flag) {
					ComShowMessage(ComGetMsg("TRS90002"));
					return false;
				}
				doActionIBSheet(sheetObject, formObj, IBINSERT);
				break;
			}
			// 'Save' Button Click
			case "btng_save":
				if(document.getElementsByName(srcName)[0].disabled) return;
				var sheetTotal = 0.00;
				if (formObj.trsp_inv_aud_sts_cd.value == 'CF')
					confirm_flag = true;
				else
					confirm_flag = false;
				if (confirm_flag) {
					ComShowMessage(ComGetMsg("TRS90059"));
					return;
				}
				if (checkInputSave(formObj)) {
					if (rowDelete(sheetObject)) {
						setSheetTotalAmt('cell');
						if (ComShowConfirm(ComGetMsg("COM12147", "Invoice"))) {
							doActionIBSheet(sheetObject, formObj, IBSEARCH);
							if (isNew && sflag == 'I') {
								doActionIBSheet(sheetObject, formObj, IBSAVE);
								isNew = false;
							} else if (sflag == 'U' && !confirm_flag && !isNew) {
								doActionIBSheet(sheetObject, formObj, 'UPDATE');
							} else if (sflag == 'U' && !apflag) {
								ComShowMessage(ComGetMsg("COM12115", "Invoice No(Pool Name)"));
								return;
							}
						}
					}
				}
				break;
			// 'Invoice Confirm' Button Click
			case "btng_invconfirm":
				if(document.getElementsByName(srcName)[0].disabled) return;
				var sheetTotal = 0.00;
				var sheetTotal2 = 0.00;
				if (formObj.trsp_inv_aud_sts_cd.value == 'CF') {
					confirm_flag = true;
				} else {
					confirm_flag = false;
				}
				if (confirm_flag) {
					ComShowMessage(ComGetMsg("TRS90002"));
					return false;
				}
				if (checkInputConfirm(formObj)) {
					if (checkInputData(sheetObject)) {
						sel = sheetObject.FindCheckedRow('sel')
						if (sel != "") {
							arrRow = sel.split("|");
							for (var idx = 0; idx < arrRow.length - 1; idx++) {
								sheetTotal = Number(sheetTotal) + Number(sheetObject.GetCellValue(arrRow[idx], "trsp_pool_chss_inv_amt"));
								sheetTotal = sheetTotal.toFixed(2);
								sheetTotal2 = Number(sheetTotal2) + Number(sheetObject.GetCellValue(arrRow[idx], "trsp_pool_chss_tax_amt"));
								sheetTotal2 = sheetTotal2.toFixed(2);
							}
						}
						if (rowDelete(sheetObject)) {
							setSheetTotalAmt('check'); // a recalculation of the amount of cells in check
							doActionIBSheet(sheetObject, formObj, IBSEARCH);
							if (isNew && sflag == 'I' && !confirm_flag) {
								doActionIBSheet(sheetObject, formObj, 'INV_CONFIRM_INSERT');
								isNew = false;
							} else if (!isNew && !confirm_flag && sflag == 'U') {
								doActionIBSheet(sheetObject, formObj, 'INV_CONFIRM_UPDATE');
							} else if (sflag == 'U' && !apflag) { // Newest
								ComShowMessage(ComGetMsg("COM12115", "Invoice No(Pool Name)"));
								return;
							}
						}
					}
				}
				break;
			// 'Invoice Confirm Cancel' Button Click
			case "btng_invconfrimcancel":
				if(document.getElementsByName(srcName)[0].disabled) return;
				if (formObj.trsp_inv_aud_sts_cd.value == 'CF')
					confirm_flag = true;
				else
					confirm_flag = false;
				if (sflag == 'U' && confirm_flag) {
					doActionIBSheet(sheetObject, formObj, 'INV_CONFIRM_CANCEL');
				} else {
					ComShowMessage(ComGetMsg("TRS90041"));
					return false;
				}
				break;
			// 'Invoice Delete Button Click
			case "btng_invoicedelete":
				if(document.getElementsByName(srcName)[0].disabled) return;
				if (formObj.trsp_inv_aud_sts_cd.value == 'CF')
					confirm_flag = true;
				else
					confirm_flag = false;
				if (!isNew && apflag) {
					ComShowMessage(ComGetMsg("TRS90383"));
					return false;
				}
				if (!isNew && sflag == 'U') {
					if (ComShowConfirm(ComGetMsg("COM12165", "Invoice No"))) {
						doActionIBSheet(sheetObject, formObj, 'INV_DELETE');
					}
				} else {
					ComShowMessage(ComGetMsg("TRS90390"));
					return false;
				}
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(ComGetMsg("TRS90392"));
		} else {
			ComShowMessage(e);
		}
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBINSERT:
			var row = sheetObj.DataInsert();
			break;
		case IBROWSEARCH:
			formObj.f_cmd.value = SEARCH10;
			sheetObj.RemoveEtcData();
			ComEtcDataToForm(formObj, sheetObj);
			var sxml = sheetObj.GetSearchData("ESD_TRS_0041GS.do", TrsFrmQryString(formObj));
			formObj.paymt_sp.value = ComGetEtcData(sxml, "paymt_sp");
			formObj.paymt_sp_cd.value = ComGetEtcData(sxml, "paymt_sp_cd");
			formObj.paymt_sp_nm.value = ComGetEtcData(sxml, "paymt_sp_nm");
			var flag = sheetObj.GetEtcData("flag");
			break;

		case IBSEARCH:
			formObj.f_cmd.value = SEARCH03;
			var sXml = sheetObj.GetSearchData("ESD_TRS_0041GS.do", TrsFrmQryString(formObj));
			var inv_flag = ComGetEtcData(sXml, "inv_flag");
			sheetObj.RemoveEtcData();
			if (parseInt(inv_flag) > 0) {
				apflag = false;
				sflag = 'U';
			} else {
				apflag = true;
				sflag = 'I';
			}
			break;
		case 'RETRIEVE':
			if (ComIsNull(formObj.inv_no)) {
				return false;
			}
			formObj.f_cmd.value = SEARCH01;
			sheetObj.DoSearch("ESD_TRS_0041GS.do", TrsFrmQryString(formObj));

			break;
		case IBSAVE:
			formObj.f_cmd.value = MULTI01;
			receive_dt = formObj.inv_rcv_dt.value.replace(/\/|\-|\./g, "");
			issue_dt = formObj.inv_iss_dt.value.replace(/\/|\-|\./g, "");
			formObj.inv_rcv_dt.value = receive_dt;
			formObj.inv_iss_dt.value = issue_dt;
			formObj.inv_bzc_amt.value = ComTrimAll(formObj.inv_bzc_amt.value, ",");
			formObj.inv_vat_amt.value = ComTrimAll(formObj.inv_vat_amt.value, ",");
			formObj.inv_ttl_amt.value = ComTrimAll(formObj.inv_ttl_amt.value, ",");
			sheetObj.DoSave("ESD_TRS_0041GS.do", TrsFrmQryString(formObj), 'trsp_pool_chss_qty', false);
			chss_pool_cd.SetEnable(0);
			formObj.inv_no.disabled = true;
			break;
		case 'UPDATE':
			formObj.f_cmd.value = MULTI02;
			receive_dt = formObj.inv_rcv_dt.value.replace(/\/|\-|\./g, "");
			issue_dt = formObj.inv_iss_dt.value.replace(/\/|\-|\./g, "");
			formObj.inv_rcv_dt.value = receive_dt;
			formObj.inv_iss_dt.value = issue_dt;
			formObj.inv_bzc_amt.value = ComTrimAll(formObj.inv_bzc_amt.value, ",");
			formObj.inv_vat_amt.value = ComTrimAll(formObj.inv_vat_amt.value, ",");
			formObj.inv_ttl_amt.value = ComTrimAll(formObj.inv_ttl_amt.value, ",");
			sheetObj.DoSave("ESD_TRS_0041GS.do", TrsFrmQryString(formObj), 'trsp_pool_chss_qty', false);
			break;
		case 'INV_CONFIRM_INSERT':
			formObj.f_cmd.value = MULTI03;
			receive_dt = formObj.inv_rcv_dt.value.replace(/\/|\-|\./g, "");
			issue_dt = formObj.inv_iss_dt.value.replace(/\/|\-|\./g, "");
			formObj.inv_rcv_dt.value = receive_dt;
			formObj.inv_iss_dt.value = issue_dt;
			formObj.inv_bzc_amt.value = ComTrimAll(formObj.inv_bzc_amt.value, ",");
			formObj.inv_vat_amt.value = ComTrimAll(formObj.inv_vat_amt.value, ",");
			formObj.inv_ttl_amt.value = ComTrimAll(formObj.inv_ttl_amt.value, ",");
			sheetObj.DoSave("ESD_TRS_0041GS.do", TrsFrmQryString(formObj), 'sel', false);
			chss_pool_cd.SetEnable(0);
			formObj.inv_no.disabled = true;
			formObj.trsp_inv_aud_sts_cd.value = 'CF';
			if (formObj.trsp_inv_aud_sts_cd.value == 'CF') {
				ComShowMessage(ComGetMsg("TRS90002"));
			}
			break;
		case 'INV_CONFIRM_UPDATE':
			formObj.f_cmd.value = MULTI04;
			receive_dt = formObj.inv_rcv_dt.value.replace(/\/|\-|\./g, "");
			issue_dt = formObj.inv_iss_dt.value.replace(/\/|\-|\./g, "");
			formObj.inv_rcv_dt.value = receive_dt;
			formObj.inv_iss_dt.value = issue_dt;
			formObj.inv_bzc_amt.value = ComTrimAll(formObj.inv_bzc_amt.value, ",");
			formObj.inv_vat_amt.value = ComTrimAll(formObj.inv_vat_amt.value, ",");
			formObj.inv_ttl_amt.value = ComTrimAll(formObj.inv_ttl_amt.value, ",");
			sheetObj.DoSave("ESD_TRS_0041GS.do", TrsFrmQryString(formObj), 'sel', false);
			formObj.trsp_inv_aud_sts_cd.value = 'CF';
			if (formObj.trsp_inv_aud_sts_cd.value == 'CF') {
				ComShowMessage(ComGetMsg("TRS90002"));
			}
			break;
		case 'INV_CONFIRM_CANCEL':
			formObj.f_cmd.value = MODIFY02;
			sheetObj.DoAllSave("ESD_TRS_0041GS.do", TrsFrmQryString(formObj), false);
			formObj.trsp_inv_aud_sts_cd.value = 'SV';
			break;
		case 'INV_DELETE':
			formObj.f_cmd.value = REMOVE01;
			sheetObj.DoAllSave("ESD_TRS_0041GS.do", TrsFrmQryString(formObj), false);
			formObj.reset();
			sheetObj.RemoveAll();
			chss_pool_cd.SetSelectCode("");
			chss_pool_cd.SetSelectText("");
			chss_pool_cd.SetEnable(1);
			formObj.inv_no.disabled = false;
			sflag = 'I';
			apflag = false;
			inv_flag = 0;
			isNew = true;
			confirm_flag = false;
			formObj.rgst_no.value = '';
			break;
	}
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

function searchPaymentSP(combo) {
	if (!ComIsEmpty(document.form.editflag))
		return;
	var formObj = document.form;
	formObj.hidden_chss_pool_cd.value = combo.GetText(combo.GetSelectIndex(), 1);
	if (combo.GetSelectText() != "") {
		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH);
	} else {
		document.form.paymt_sp.value = "";
		document.form.paymt_sp_cd.value = "";
		document.form.paymt_sp_nm.value = "";
	}
}
function checkInputSave(formObj) {
	if (ComIsNull(formObj.pool_chss_cost_yrmon) || ComIsNull(formObj.pool_chss_cost_yrmon.value)) {
		ComShowCodeMessage("COM12114", "Cost Month");
		formObj.pool_chss_cost_yrmon.focus();
		return false;
	}
	if (ComIsNull(formObj.chss_pool_nm) || ComIsNull(formObj.chss_pool_nm.value)) {
		ComShowCodeMessage("COM12114", "Pool Name");
		return false;
	}
	if (ComIsNull(formObj.paymt_sp_cd) || ComIsNull(formObj.paymt_sp_cd.value)) {
		ComShowCodeMessage("COM12114", "Payment S/P");
		return false;
	}
	if (ComIsNull(formObj.inv_no) || ComIsNull(formObj.inv_no.value)) {
		ComShowCodeMessage("COM12114", "Invoice No");
		formObj.inv_no.focus();
		return false;
	}
	return true;
}
function checkInputConfirm(formObj) {
	if (ComIsNull(formObj.pool_chss_cost_yrmon) || ComIsNull(formObj.pool_chss_cost_yrmon.value)) {
		ComShowCodeMessage("COM12114", "Cost Month");
		formObj.pool_chss_cost_yrmon.focus();
		return false;
	}
	if (ComIsNull(formObj.chss_pool_nm) || ComIsNull(formObj.chss_pool_nm.value)) {
		ComShowCodeMessage("COM12114", "Pool Name");
		return false;
	}
	if (ComIsNull(formObj.paymt_sp_cd) || ComIsNull(formObj.paymt_sp_cd.value)) {
		ComShowCodeMessage("COM12114", "Payment S/P");
		return false;
	}
	if (ComIsNull(formObj.inv_no) || ComIsNull(formObj.inv_no.value)) {
		ComShowCodeMessage("COM12114", "Invoice No");
		formObj.inv_no.focus();
		return false;
	}
	if (ComIsNull(formObj.inv_rcv_dt) || ComIsNull(formObj.inv_rcv_dt.value)) {
		ComShowCodeMessage("COM12114", "Receive Date");
		formObj.inv_rcv_dt.focus();
		return false;
	}
	if (ComIsNull(formObj.inv_iss_dt) || ComIsNull(formObj.inv_iss_dt.value)) {
		ComShowCodeMessage("COM12114", "Issue Date");
		formObj.inv_iss_dt.focus();
		return false;
	}
	if (ComIsNull(formObj.inv_curr_cd) || ComIsNull(formObj.inv_curr_cd.value)) {
		ComShowCodeMessage("COM12114", "Currency");
		formObj.inv_curr_cd.focus();
		return false;
	}
	if (ComIsNull(formObj.inv_bzc_amt) || ComIsNull(formObj.inv_bzc_amt.value)) {
		ComShowCodeMessage("COM12114", "Invoice Amount");
		formObj.inv_bzc_amt.focus();
		return false;
	}
	if (ComIsNull(formObj.inv_vat_amt) || ComIsNull(formObj.inv_vat_amt.value)) {
		ComShowCodeMessage("COM12114", "Tax Amount");
		formObj.inv_vat_amt.focus();
		return false;
	}
	return true;
}
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	var formObj = document.form;
	if (ErrMsg != "")
		return;
	apflag = false;
	sflag = 'U';
	document.form.insflag.value = "false"; // As input to modify the state transition
}
function checkInputData(sheetObj) {
	var flag = true;
	var dtflag = true;
	var vflag = true;
	if (sheetObj.CheckedRows('sel') == "0") {
		ComShowMessage(ComGetMsg("TRS90215"));
		return false;
	}
	var chkrows = sheetObj.FindCheckedRow("sel");
	var arrRow = chkrows.split("|");
	for (idx = 0; idx < arrRow.length - 1; idx++) {
		row = arrRow[idx];
		sheetObj.SetRowBackColor(row, "#FFFFFF");
		if (isNaN(sheetObj.GetCellValue(row, "trsp_pool_chss_qty")) || parseInt(sheetObj.GetCellValue(row, "trsp_pool_chss_qty")) == 0) {
			sheetObj.SetCellBackColor(row, "trsp_pool_chss_qty", "#FF0000");
			flag = false;
		}
		if (isNaN(sheetObj.GetCellValue(row, "trsp_pool_chss_inv_amt")) || sheetObj.GetCellValue(row, "trsp_pool_chss_inv_amt") == 0) {
			sheetObj.SetCellBackColor(row, "trsp_pool_chss_inv_amt", "#FF0000");
			flag = false;
		}
		if (sheetObj.GetCellValue(row, "hndl_prd_fm_dt").replace(/-/gi, "").length != 8) {
			sheetObj.SetCellBackColor(row, "hndl_prd_fm_dt", "#FF0000");
			flag = false;
			dtflag = false;
		}
		if (sheetObj.GetCellValue(row, "hndl_prd_to_dt").replace(/-/gi, "").length != 8) {
			sheetObj.SetCellBackColor(row, "hndl_prd_to_dt", "#FF0000");
			flag = false;
			dtflag = false;
		}
		if (dtflag) {
			if (parseInt(sheetObj.GetCellValue(row, "hndl_prd_fm_dt").replace(/-/gi, "")) > parseInt(sheetObj.GetCellValue(row, "hndl_prd_to_dt").replace(/-/gi, ""))) {
				sheetObj.SetCellBackColor(row, "hndl_prd_fm_dt", "#FF0000");
				sheetObj.SetCellBackColor(row, "hndl_prd_to_dt", "#FF0000");
				flag = false;
			}
		}
		if (!flag) {
			vflag = false;
		}
		flag = true;
		dtflag = true;
	}
	var findRow = 1;
	return vflag;
}
function rowDelete(sheetObj) {
	var tCnt = 0;
	var rowCnt = sheetObj.RowCount();
	for ( var i = sheetObj.RowCount() + 1; i > 1; i--) {
		if (isNaN(sheetObj.GetCellValue(i, "trsp_pool_chss_qty")) || sheetObj.GetCellValue(i, "trsp_pool_chss_qty") == 0) {
			tCnt = tCnt + 1;
		}
	}
	if (tCnt == rowCnt) {
		ComShowCodeMessage("TRS90036");
		return false;
	} else {
		for ( var i = sheetObj.RowCount() + 1; i > 1; i--) {
			if (isNaN(sheetObj.GetCellValue(i, "trsp_pool_chss_qty")) || sheetObj.GetCellValue(i, "trsp_pool_chss_qty") == 0) {
				sheetObj.RowDelete(i, false);
			}
		}
		return true;
	}
}

function chss_pool_cd_OnChange(combo, OldIndex, OldText, OldCode, NewIndex, Text, Index_Code) {
	if (document.form.chss_pool_nm.value == Text)
		return;
	document.form.hidden_chss_pool_cd.value = combo.GetText(Index_Code, 0);
	document.form.chss_pool_nm.value = combo.GetText(Index_Code, 1);
	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH);
}

function checkDateFormat(dt) {
	var date_regexp = "^(\\d{4}-\\d{2}-\\d{2})$";
	if (!checkFormat(dt, date_regexp)) {
		return false;
	}
	return true;
}

function checkFormat(object, regexp) {
	if (object == null || object == "") {
		return false;
	} else {
		re = new RegExp(regexp, "gi"); // 'gi' for case-insensitive global match.
		if (!re.test(object)) {
			return false;
		}
	}
	return true;
}
function isMon(obj, isChkFmt) {
	// Only currency -> Number + Allow two decimal digits
	if (!ComIsNumber(obj, '-.,')) {
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
				// obj.value = src;
				obj.value = chkAmtFmt(src);
			}
		}
	}
}
function chkAmtFmtObj(obj) {
	if (obj == undefined || obj.value == null || ComTrim(obj.value) == '') {
		return false;
	}
	obj.value = chkAmtFmt(obj.value);
}
function chkAmtFmt(src) {
	if (src == undefined || src == null || ComTrim(src) == '') {
		return "";
	}
	var src = deleteComma(src);
	if (document.form.inv_curr_cd.value == "KRW" || document.form.inv_curr_cd.value == "JPY" || document.form.inv_curr_cd.value == "TWD") {
		if (src.indexOf('.') != -1) {
			src.value = "";
			ComShowCodeMessage("COM12136", "KRW ,JPY", "TWD");
			return "";
		}
	} else {
		if (src.indexOf('.') == -1) {
			src = ComAddComma(src) + '.00'
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
				src = ComAddComma(temp[0]) + '.' + temp[1];
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
				src = ComAddComma(temp[0]) + '.' + tmp_str;
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
	// remove comma
	var src = String(src);
	if (src == null || ComTrim(src) == '') {
		return '';
	}
	return src.replace(/,/gi, '');
}
function addComma(src) {
	// putting a comma every three digits
	var src = String(src);
	if (src == null || ComTrim(src) == '') {
		return '';
	}
	var re = /(-?\d+)(\d{3})/;
	while (re.test(src)) {
		src = src.replace(re, "$1,$2");
	}
	return src;
}
function getStrLen(src) {
	// Wanted English on the length of str
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
		sheetObjects[0].SetColProperty(0, 4, { PointCount : 0 });
		sheetObjects[0].SetColProperty(0, 5, { PointCount : 0 });

		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		var total_invoice_amt = 0;
		var total_tax_amt = 0;
		formObj.inv_bzc_amt.value = 0;
		formObj.inv_vat_amt.value = 0;
		for ( var i = sheetObj.RowCount() + 1; i > 1; i--) {
			total_invoice_amt += parseInt(sheetObj.GetCellValue(i, 'trsp_pool_chss_inv_amt'));
			total_tax_amt += parseInt(sheetObj.GetCellValue(i, 'trsp_pool_chss_tax_amt'));
		}
		formObj.inv_bzc_amt.value = chkAmtPos(total_invoice_amt);
		formObj.inv_vat_amt.value = chkAmtPos(total_tax_amt);
		document.form.inv_bzc_amt.value = parseInt(document.form.inv_bzc_amt.value);
		document.form.inv_vat_amt.value = parseInt(document.form.inv_vat_amt.value);
	} else {
		sheetObjects[0].SetColProperty(0, 4, { PointCount : 2 });
		sheetObjects[0].SetColProperty(0, 5, { PointCount : 2 });
	}
	sumAmt();
}

/**
 * Get a list of external combo box. Rail Road
 */
function getChssPoolComboList(combo, code, text, option) {
	var chssPoolCdList = code;
	var chssPoolNmList = text;
	var chssPoolCdArray = new Array();
	var chssPoolNmArray = new Array();
	chssPoolCdArray = chssPoolCdList.split("|");
	chssPoolNmArray = chssPoolNmList.split("|");
	combo.RemoveAll();
	for ( var i = 0; i < chssPoolCdArray.length; i++) {
		combo.InsertItem(i, chssPoolCdArray[i] + '|' + chssPoolNmArray[i], chssPoolCdArray[i]);
	}
	combo.InsertItem(0, option, option);
}

function initChssPoolCombo(comboObj) {
	comboObj.SetDropHeight("200");
	comboObj.SetColAlign(0, "left");
	comboObj.SetColAlign(1, "left");
	comboObj.SetColWidth(0, "60");
	comboObj.SetColWidth(1, "300");
}

function chkYearMonth(obj) {
	if (obj == undefined || obj.value == null || ComTrim(obj.value) == '') {
		return;
	}
	obj.value = obj.value.replace('-', '');
	if (!ComIsNumber(obj)) {
		obj.value = '';
		obj.focus();
		return;
	}
	if (obj.value.length != 6) {
		obj.value = '';
		obj.focus();
		return false;
	}
	if (!ComIsDate(obj, "ym")) {
		errMsg = ComGetMsg("COM12180");
		ComShowMessage(errMsg);
		obj.value = '';
		obj.focus();
		return;
	}
}
function isYearMonth(obj) {
	obj.value = obj.value.replace('-', '');
	if (!ComIsNumber(obj)) {
		obj.value = '';
		obj.focus();
		return;
	}
	if (obj.value.length != 6) {
		obj.focus();
		return;
	}
	if (!ComIsDate(obj, "ym") || !ComIsNumber(obj)) {
		obj.value = '';
		obj.focus();
		return;
	}
}
/**
 * sheet cell value change events that occur
 */
function sheet1_OnChange(sheetObj, row, col, value) {
	var formObj = document.form;
	var colName = sheetObj.ColSaveName(col);
	switch (colName) {
		case 'trsp_pool_chss_inv_amt':
		case 'trsp_pool_chss_tax_amt':
			setSheetTotalAmt('cell');
			break;
		// 2015.06.16 CHAN WOO PARK
		// IBSheet from/to date validation 로직 추가
		case 'hndl_prd_fm_dt':
		case 'hndl_prd_to_dt':
			var fmDate = sheetObj.GetCellValue(row, 'hndl_prd_fm_dt');
			var toDate = sheetObj.GetCellValue(row, 'hndl_prd_to_dt');
			var dateDiff = ComGetDaysBetween(fmDate, toDate);
			if (dateDiff < 0 && toDate != null && toDate != '') {
				sheetObj.SetCellValue(row, 'hndl_prd_to_dt', '');
				ComShowCodeMessage('TRS90413', 'To Date', 'From Date');
			}
			break;
	}
}
function setSheetTotalAmt(flag) {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	var total_invoice_amt = 0.00;
	var total_tax_amt = 0.00;
	formObj.inv_bzc_amt.value = 0.00;
	formObj.inv_vat_amt.value = 0.00;
	// Checked cells at the click of a button conform to recalculate
	if (flag == 'check') {
		var checkList = sheetObj.FindCheckedRow('sel');
		var checkArray = checkList.split('|');
		for ( var i = 0; i < checkArray.length; i++) {
			total_invoice_amt += Number(sheetObj.GetCellValue(checkArray[i], 'trsp_pool_chss_inv_amt'));
			total_tax_amt += Number(sheetObj.GetCellValue(checkArray[i], 'trsp_pool_chss_tax_amt'));
		}
		// Automatic calculation of the cell input
	} else {
		for ( var i = sheetObj.RowCount() + 1; i > 1; i--) {
			total_invoice_amt += Number(sheetObj.GetCellValue(i, 'trsp_pool_chss_inv_amt'));
			total_tax_amt += Number(sheetObj.GetCellValue(i, 'trsp_pool_chss_tax_amt'));
		}
	}
	formObj.inv_bzc_amt.value = chkAmtPos(total_invoice_amt);
	formObj.inv_vat_amt.value = chkAmtPos(total_tax_amt);
	checkCurr(formObj.inv_curr_cd.value);
	// sumAmt();
}

function sumAmt() {
	var inv_amt = 0;
	var tax_amt = 0;
	if (document.form.inv_bzc_amt.value != "") {
		inv_amt = deleteComma(document.form.inv_bzc_amt.value);
	}
	if (document.form.inv_vat_amt.value != "") {
		tax_amt = deleteComma(document.form.inv_vat_amt.value);
	}
	document.form.inv_ttl_amt.value = parseFloat(inv_amt) + parseFloat(tax_amt);
	var curr_value = document.form.inv_curr_cd.value;
	if (!(curr_value == "KRW" || curr_value == "JPY" || curr_value == "TWD")) {
		document.form.inv_ttl_amt.value = ComAddComma(document.form.inv_ttl_amt.value);
	}
	chkAmtFmtObj(document.form.inv_ttl_amt);
}

function getChssPoolList() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	formObj.f_cmd.value = SEARCH11;
	var query = TrsFrmQryString(formObj);
	sheetObj.RemoveEtcData();
	var sXml = sheetObj.GetSearchData("ESD_TRS_0041GS.do", query);
	var chss_pool_cd1 = ComGetEtcData(sXml, "chss_pool_cd");
	var chss_pool_nm1 = ComGetEtcData(sXml, "chss_pool_nm");
	var comboObj = chss_pool_cd;
	comboObj.RemoveAll();
	var chssPoolCdArray = chss_pool_cd1.split('|');
	var chssPoolNmArray = chss_pool_nm1.split('|');
	var k = 0;
	while (k < chssPoolCdArray.length - 1) {
		comboObj.InsertItem(k++, chssPoolCdArray[k] + '|' + chssPoolNmArray[k], chssPoolNmArray[k]);
	}
	poolNameComboListLoadFinished = true;
}

function sheet1_OnSearchEnd(sheetObj, code, message) {
	var formObj = document.form;
	ComEtcDataToForm(formObj, sheetObj);
	inv_flag = sheetObj.GetEtcData("inv_flag");
	if (parseInt(inv_flag) > 0) {
		apflag = false;
		sflag = 'U';
	} else {
		apflag = true;
		Sflag = 'I';
		ComShowCodeMessage("TRS90390");
	}
	
	var chss_pool_cd1 = sheetObj.GetEtcData("chss_pool_cd");
	chss_pool_cd.SetSelectText(chss_pool_cd1, false);
	
	chss_pool_cd.SetEnable(0);
	formObj.inv_no.disabled = true;
	checkCurr(formObj.inv_curr_cd.value);
}