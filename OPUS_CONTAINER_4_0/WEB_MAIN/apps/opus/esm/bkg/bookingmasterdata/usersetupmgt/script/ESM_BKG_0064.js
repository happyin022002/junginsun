/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : esm_bkg_0064.js
 *@FileTitle : General Cargo Manifest Print Setup
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/29
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

document.onclick = processButtonClick;

var strPrintList = "";
var defaultPrint = "";
var rdParam      = "";
var rdPath       = "";

function loadPage() {
	document.form.print_form[0].selected = true;
}
//
function processButtonClick() {
	/** **************************************************** */
	var formObj = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
		case "btn_Print":
			setParameter();
			directReportDownload([{mrdPath:RD_path+rdPath, mrdParam:RDServer+rdParam}]);
			break;
		case "btn_preview":
			setParameter();
			goPrintPop();
			break;
		case "btn_Close":
			ComClosePopup();
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

function setParameter() {
	var sheetObj = opener.sheetObjects[0];
	var arrRow = ComFindText(sheetObj, "check", 1);

	var formObj = document.form;
	var printForm = formObj.print_form.value;

	// RD Parameter setting
	rdParam = "/rv mode_type[" + formObj.mode_type.value + "] ";
	rdParam += " print_form[" + printForm + "] ";
	rdParam += " vvd_cd[" + formObj.vvd_cd.value + "] ";
	rdParam += " pol_cd[" + formObj.pol_cd.value + "] ";
	rdParam += " pod_cd[" + formObj.pod_cd.value + "] ";
	rdParam += " cargo_type[" + formObj.cargo_type.value + "] ";

	if (formObj.mode_type.value == "I") {
		rdParam += "pol_pod_cd[" + formObj.pod_cd.value + "] ";
	} else {
		rdParam += "pol_pod_cd[" + formObj.pol_cd.value + "] ";
	}

	var usBkgNo = "";
	for (var i=0; i<arrRow.length; i++) {
		usBkgNo += "'" + sheetObj.GetCellValue(arrRow[i], "bkg_no") + "',";
	}
	usBkgNo = usBkgNo.substring(0, usBkgNo.length - 1);

	var hbl_flag = 1;
	if (!formObj.hbl_flag.checked) hbl_flag = 0;

	rdParam += " hbl_flag[" + hbl_flag + "] ";
	rdParam += " bkg_nos[" + usBkgNo + "] ";

	// RD PATH setting
	if (printForm == "GEN" || printForm == "FRT") {    // General / General - FRT
		if (getRadioValue2(formObj.paper_type) == '4') {
			rdPath = "apps/opus/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0747_01.mrd";    // Letter
		} else {
			rdPath = "apps/opus/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0747.mrd";    // A4
		}
	} else if (printForm == "GEN(POR)" || printForm == "GEN_FRT(POR)") {    // General(POR) / GEN(POR) - FRT
		if (getRadioValue2(formObj.paper_type) == '4') {
			rdPath = "apps/opus/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0748_01.mrd";    // Letter
		} else {
			rdPath = "apps/opus/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0748.mrd";    // A4
		}
	} else {
		if (getRadioValue2(formObj.paper_type) == '4') {    // US / US - FRT
			rdPath = "apps/opus/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0826_01.mrd";    // Letter
		} else {
			rdPath = "apps/opus/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0826.mrd";    // A4
		}
	}
}

function goPrintPop() {
	var formObj = document.form;
	formObj.com_mrdPath.value = rdPath;
	formObj.com_mrdArguments.value = rdParam + "/riprnmargin /rwait /rappendpageinit [1]";
	formObj.com_mrdTitle.value = "General Cargo Manifest";
	formObj.com_mrdDisableToolbar.value = "";
	formObj.com_mrdBodyTitle.value = "<span style=&quot;color:red&quot;>General Cargo Manifest</span>";
	ComOpenRDPopup();
}
