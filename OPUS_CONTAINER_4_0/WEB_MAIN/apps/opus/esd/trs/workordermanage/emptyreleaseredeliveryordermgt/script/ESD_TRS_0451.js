/**
 * Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 * 
 * @FileName : ESD_TRS_0451.js
 * @FileTitle : Release/Re-delivery Order
 * @author : CLT
 * @version : 1.0
 * @since : 2014/08/29
 */

var popopener = opener;
if (!popopener) {
	popopener = parent;
}

popopener.childObject = this;
	
var opnfrmObj = popopener.document.form;
var opnSheetObj0 = popopener.sheetObjects[0];
var opnSheetObj1 = popopener.sheetObjects[1];
var opnSheetObj0Arr = opnSheetObj0.FindCheckedRow("Sel").split("|");
document.onclick = processButtonClick;

function processButtonClick() {
	var frmObj = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_close": {
				ComClosePopup();
				break;
			}
			case "btn_confirm": {
				if (ComShowCodeConfirm("TRS90420")) {
					ComOpenWait(true);
					opnfrmObj.issue_flag.value = frmObj.issue_flag.value;
					if (frmObj.issue_type[0].checked) {
						if(ComIsEmpty(document.form.eml.value)) {
							ComShowCodeMessage("COM130201", "E-Mail Address");
							ComOpenWait(false);
							return false;
						}
						opnfrmObj.issue_type.value = frmObj.issue_type[0].value;
						for ( var i = 1; i < opnSheetObj1.RowCount() + 1; i++) {
							opnSheetObj1.SetCellValue(i, "email", document.form.eml.value);
						}
						for ( var j = 0; j < opnSheetObj0Arr.length; j++) {
							opnSheetObj0.SetCellValue(opnSheetObj0Arr[j], "email", document.form.eml.value);
						}
						opnfrmObj.receiver_eml.value = opnSheetObj0.GetCellValue(opnSheetObj0.FindCheckedRow("Sel").split("|")[0], "email");
					} else  if (frmObj.issue_type[1].checked) {
						if(ComIsEmpty(document.form.fax.value)) {
							ComShowCodeMessage("COM130201", "Fax Number");
							ComOpenWait(false);
							return false;
						}
						opnfrmObj.issue_type.value = frmObj.issue_type[1].value;
						for ( var i = 1; i < opnSheetObj1.RowCount() + 1; i++) {
							opnSheetObj1.SetCellValue(i, "fax_no", document.form.fax.value);
						}
						for ( var j = 0; j < opnSheetObj0Arr.length; j++) {
							opnSheetObj0.SetCellValue(opnSheetObj0Arr[j], "fax_no", document.form.fax.value);
						}
						opnfrmObj.receiver_fax.value = opnSheetObj0.GetCellValue(opnSheetObj0.FindCheckedRow("Sel").split("|")[0], "fax_no");
					} else  if (frmObj.issue_type[2].checked) {
						opnfrmObj.issue_type.value = frmObj.issue_type[2].value;
					}
					var issueFlagText = frmObj.issue_flag[frmObj.issue_flag.selectedIndex].text;
					var receiver_eml = document.form.eml.value;
					var receiver_fax = document.form.fax.value;
					opnfrmObj.tmpl_param.value = "/rp [" + issueFlagText + "] /rfn [" + RDServerIP + "/ESD_TRS_0451_RD.do]";
					popopener.doActionIBSheet(opnSheetObj1, opnfrmObj, MULTI02);
					ComOpenWait(false);
				}
				break;
			}
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
		ComOpenWait(false);
	}
}

/**
 * 
 */
function fnParentComfirmMsg() {
		opnSheetObj1.RemoveAll();
		var typeCd = opnSheetObj0.GetCellValue(opnSheetObj0.FindCheckedRow("Sel").split("|")[0], "type_cd");
		var trspCostDtlModCd = opnSheetObj0.GetCellValue(opnSheetObj0.FindCheckedRow("Sel").split("|")[0], "trsp_cost_dtl_mod_cd");
		var pageTitle = "";
		if (typeCd == "R") {
			if (opnfrmObj.type.value == "RLS") {
				pageTitle = "Empty Container Release Order";
			} else {
				pageTitle = "Empty Container Redelivery Order";
			}
		} else {
			if (trspCostDtlModCd == "DR") {
				if (opnfrmObj.type.value == "RLS") {
					pageTitle = "Empty Container Release Order";
				} else {
					pageTitle = "Empty Container Redelivery Order";
				}
			} else {
				if (opnfrmObj.type.value == "RLS") {
					pageTitle = "Full Container Release Order";
				} else {
					pageTitle = "Full Container Restitution Order";
				}
			} 
		}
		ComShowCodeMessage("TRS90440", pageTitle);
		popopener.doActionIBSheet(opnSheetObj0, opnfrmObj, IBSEARCH);
		ComClosePopup();
}

function loadPage() {
	axon_event.addListener("change", "rdOpen", "issue_flag");
	if (opnfrmObj.issued.value == "N") {
		document.form.issue_flag[3] = new Option("", "I", true, true);
		ComEnableObject(document.form.issue_flag, false);
	}
	var header = "";
	for ( var j = 0; j <= opnSheetObj0.LastCol(); j++) {
		header += (opnSheetObj0.ColSaveName(j) + "|");
	}
	var opnSheet0Xml = ComMakeSearchXml(opnSheetObj0, false, "Sel", header);
	opnSheetObj1.RemoveAll();
	opnSheetObj1.LoadSearchData(opnSheet0Xml, { Sync : 1 });
	opnSheetObj1.ColumnSort("bkg_no|bl_no|wo_no|tp|shpr|pd_date|mode_cd|vndr_lgl_eng_nm|spcl_inst|so_ofc_cty_cd|so_seq", "ASC", "", true);
	opnfrmObj.receiver_fax.value = opnSheetObj0.GetCellValue(opnSheetObj0.FindCheckedRow("Sel").split("|")[0], "fax_no");
	opnfrmObj.receiver_eml.value = opnSheetObj0.GetCellValue(opnSheetObj0.FindCheckedRow("Sel").split("|")[0], "email");
	document.form.eml.value = opnfrmObj.receiver_eml.value;
	document.form.fax.value = opnfrmObj.receiver_fax.value;
	
	var stkIssCd = opnSheetObj0.GetCellValue(opnSheetObj0.FindCheckedRow("Sel").split("|")[0], "stk_iss_cd");
	if( stkIssCd != 'D') {
		document.form.issue_type[2].disabled = true;
		document.form.issue_type[0].checked = true
		if(stkIssCd == 'F')  {
			document.form.issue_type[1].checked = true
		}
	} else {
		document.form.issue_type[2].disabled = false;
		document.form.issue_type[2].checked = true
	}
	
	var xml = opnSheetObj1.GetSearchData("ESD_TRS_0451_PRV.do", opnSheetObj1.GetSaveString({AllSave: true}) + "&" + FormQueryString(opnfrmObj));
	if (ComGetEtcData(xml, "RD") == "undefined") {
		LoadSearchData(xml, { Sync : 1 });
	} else {
		opnfrmObj.rd_content.value = ComGetEtcData(xml, "RD")
		rdOpen();
	}
}

/**
 * loadPage() / calling in OnChange event
 */
function rdOpen() {
	viewer.setRData(opnfrmObj.rd_content.value);
	var issueFlagText = document.form.issue_flag[document.form.issue_flag.selectedIndex].text;
	var rdParam =  "/rp [" + issueFlagText + "] ";
	viewer.openFile(RD_path + 'apps/opus/esd/trs/workordermanage/emptyreleaseredeliveryordermgt/report/ESD_TRS_0451.mrd', RDServer + rdParam + "/rfonttype60", {timeout:1800});	
}