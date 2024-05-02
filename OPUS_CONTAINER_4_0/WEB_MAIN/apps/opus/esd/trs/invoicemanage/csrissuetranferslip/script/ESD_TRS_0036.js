/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0036.jsp
 *@FileTitle  : Transportation Invoice CSR Creation - Preview
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/07/15
=========================================================*/
/**
 * @class ESD_TRS_0036
 */
/*------------------ Defining general java script function   ------------------*/
// General global variable
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;
var comboObjects = new Array();
var comboCnt = 0;
document.onclick = processButtonClick;
/* Branch processing event handler with the name of button */
function processButtonClick() {
	/**
	 * *** Adding additional sheet variables to use more than one sheet per a
	 * tab ****
	 */
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
		case "btn_close":
			ComClosePopup();
			break;
		case "btng_print":
			viewer.print({isServerSide : true});
			break;
		case "btng_approvalrequest":
			if (opener.document.form.csr_no.value != "") {
				errMsg = ComGetMsg("TRS90046");
				ComShowMessage(errMsg);
				return false;
			}
			// if(!confirm('Are you sure to proceed for Approval Request?'))
			// return false;
			opener.approvalrequest();
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

/**
 * Register IBSheet Object with array
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Setting sheets and initialization Implementing the onLoad event handler of
 * body tag Adding the preceding function after loading page
 */
function loadPage() {
	rdOpen();
}

function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // Retrieve
		formObj.f_cmd.value = SEARCHLIST;
		sheetObj.DoSearch("ESD_TRS_0032GS.do", TrsFrmQryString(formObj));
		break;
	case IBSAVE: // Save
		formObj.f_cmd.value = MULTI;
		sheetObj.DoSave("ESD_TRS_0032GS.do", TrsFrmQryString(formObj));
		break;
	case IBCOPYROW:
		sheetObj.DataCopy();
		break
	}
}
function rdOpen() {
	var sXml = "";
	var i = 0;
	var j = 0;
	var opener_obj = opener;
	var opener_sheet_obj1 = opener_obj.sheet2;
	var opener_sheet_obj2 = opener_obj.sheet3;
	var fromObj = new Array();
	var rdObj = new Array();
	fromObj[0] = document.form; // for RD using
	rdObj[0] = opener_sheet_obj1;
	rdObj[1] = opener_sheet_obj2;
	sXml = "<?xml version='1.0' ?><SHEET>";
	sheetCnt = 1;
	for (i = 0; i < 2; i++) {
		sheetCnt = i + 1;
		if (rdObj[i].RowCount() == 0) {
			sXml += "<SHEET" + sheetCnt + "><DATA TOTAL='0'><TR>";
			for (j = 0; j <= rdObj[i].LastCol(); j++) {
				sXml += "<TD></TD>";
			}
			sXml += "</TR></DATA></SHEET" + sheetCnt + ">";
		} else {
			sXml += RD_GetDataSearchXml(rdObj[i], sheetCnt);
		}
	}
	sXml += "</SHEET>";
	if (rdObj[0].RowCount() == "0") // Error if there's no data to send to RD in
									// sheet
	{
		errMsg = ComGetMsg("TRS90001");
		ComShowMessage(errMsg);
		return;
	}
	viewer.zoom = 100;
	viewer.setRData(sXml);
	viewer.openFile(RD_path + 'apps/opus/esd/trs/invoicemanage/csrissuetranferslip/report/ESD_TRS_0036.mrd', RDServer, {timeout:1800});
	viewer.setDownloadFileName("ESD_TRS_0036");
}
