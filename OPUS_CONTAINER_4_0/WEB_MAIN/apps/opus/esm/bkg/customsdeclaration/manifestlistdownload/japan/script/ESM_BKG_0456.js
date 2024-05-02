/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0456.js
*@FileTitle  : ESM_BKG-0456
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_BKG-0456 : business script for ESM_BKG-0456
 */

/* developer job	*/
//common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var state="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
function processButtonClick() {
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
			case "btn_Save":
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
			break;
			case "btn_close":
				doActionIBSheet(sheetObjects[0], formObject, COMMAND04);
			break;
			case "btn_cust":
				doActionIBSheet(sheetObjects[0], formObject, COMMAND01);
			break;
			case "btn_cust2":
				doActionIBSheet(sheetObjects[0], formObject, COMMAND02);
			break;
			case "btn_cust3":
				doActionIBSheet(sheetObjects[0], formObject, COMMAND03);
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
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param sheet_obj IBSheet Object
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}


/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
*/
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	initSheetData(sheetObjects[0], document.form);
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}


// reset sheet data
function initSheetData(sheetObj, formObj) {
// formObj.vvd_cd.value = "";
// formObj.pod_cd.value = "";
	sheetObj.RemoveAll();
	sheetObj.DataInsert(-1);
	IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
}


/**
 * Dynamically load HTML Control event in page. <br>
 * Initialize IBSheet Object by calling this function from {@link #loadPage} function.
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects list in turn
 **/
function initControl() {
	axon_event.addListenerForm("change", "frmObj_OnChange", document.form);
}


/**
 * check Validation onblur event<br>
 */
function frmObj_OnChange() {
	if (ComGetEvent("name").substring(0, 6) == "form1_") {
		var sheetObj = sheetObjects[0];
		sheetObj.SetCellValue(sheetObj.HeaderRows(), ComGetEvent("name").replace("form1_", ""), ComGetEvent("value"), 0);
	}
}


/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetObj.id) {
		case "sheet1": // sheet1 init
			with (sheetObj) {
				var HeadTitle1="Flag|bl_no|vvd_cd|pod_cd|cust_cnt_cd|cust_seq|cust_nm|cust_addr|phn_no|fax_no|cust_cnt_cd2|cust_seq2|cust_nm2|cust_addr2|phn_no2|fax_no2|cust_cnt_cd3|cust_seq3|cust_nm3|cust_addr3|phn_no3|fax_no3||";
				SetConfig({SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1});
				var info = {Sort:1, ColMove:1, HeaderCheck:1, ColResize:1};
				var headers = [{Text:HeadTitle1, Align:"Center"}];
				InitHeaders(headers, info);
				var cols = [{Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bl_number" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_addr" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"phn_no" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fax_no" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd2" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq2" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm2" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_addr2" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"phn_no2" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fax_no2" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd3" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq3" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm3" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_addr3" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"phn_no3" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fax_no3" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"form1_cust_nm" },
							{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"form1_cust_addr"}];
				InitColumns(cols);
				SetEditable(1);
				SetSheetHeight(225);
				SetVisible(0);
			}
		break;
	}
}


//handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH: // retrievening
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value=SEARCH;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				sheetObj.DoSearch("ESM_BKG_0456GS.do", FormQueryString(formObj),{Sync:2}  );

				if (sheetObj.RowCount()== 1) {
					IBS_CopyRowToForm(sheetObj, formObj, 1, "form1_");
				} else if (sheetObj.RowCount()== 0) {
					initSheetData(sheetObj, formObj);
				}
				ComOpenWait(false);
			}
		break;

		case IBSAVE: // saving
			if (validateForm(sheetObj, formObj, sAction)) {
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
				formObj.f_cmd.value=MULTI;
				sheetObj.DoAllSave("ESM_BKG_0456GS.do", {Param:FormQueryString(formObj),Col:"sel",Quest:"false",UrlEncode:"true", Sync:1} );
				state=sheetObj.GetEtcData("TRANS_RESULT_KEY");

			}
		break;

		case COMMAND01: // Shipper
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value=SEARCH01;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.cust_type.value="S";

				sXml=sheetObj.GetSearchData("ESM_BKG_0457GS.do", FormQueryString(formObj)); // *****
				formObj.form1_cust_nm.value = ComGetEtcData(sXml, "form1_cust_nm");
				formObj.form1_cust_addr.value = ComGetEtcData(sXml, "form1_cust_addr");
				ComOpenWait(false);
			}
			break;
		case COMMAND02: // Consignee
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value=SEARCH02;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.cust_type.value="C";

				sXml=sheetObj.GetSearchData("ESM_BKG_0457GS.do", FormQueryString(formObj));
				formObj.form1_cust_nm2.value = ComGetEtcData(sXml, "form1_cust_nm2");
				formObj.form1_cust_addr2.value = ComGetEtcData(sXml, "form1_cust_addr2");

				ComOpenWait(false);
			}
			break;

		case COMMAND03: // Notify
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value=SEARCH03;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.cust_type.value="N";

				sXml=sheetObj.GetSearchData("ESM_BKG_0457GS.do", FormQueryString(formObj));
				formObj.form1_cust_nm3.value = ComGetEtcData(sXml, "form1_cust_nm3");
				formObj.form1_cust_addr3.value = ComGetEtcData(sXml, "form1_cust_addr3");
				ComOpenWait(false);
			}
		break;

		case COMMAND04: // Close
			var opener = window.dialogArguments;
			if (!opener) opener = parent;
			if (sheetObj.GetRowStatus(1) == "U") {
				if (ComShowCodeConfirm("BKG00350")) {
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
					formObj.f_cmd.value=MULTI;
					sheetObj.DoAllSave("ESM_BKG_0456GS.do", FormQueryString(formObj));
					ComOpenWait(false);
				} else {
					opener.retrieve();
					ComClosePopup();
				}
			} else {
				opener.retrieve();
				ComClosePopup();
			}
		break;
	}
}


function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	ComOpenWait(false);
	if (state == "S") doActionIBSheet(sheetObj, document.form, IBSEARCH);
}


/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSAVE:
		return true;
		break;
	case IBSEARCH:
		return true;
		break;
	case COMMAND01:
		if (formObj.form1_cust_cnt_cd.value == ""
				|| formObj.form1_cust_seq.value == "") {
			// ComShowCodeMessage('BKG00266');
			formObj.form1_cust_cnt_cd.focus();
			return false;
		}
		return true;
		break;
	case COMMAND02:
		if (formObj.form1_cust_cnt_cd2.value == ""
				|| formObj.form1_cust_seq2.value == "") {
			// ComShowCodeMessage('BKG00266');
			formObj.form1_cust_cnt_cd2.focus();
			return false;
		}
		return true;
		break;
	case COMMAND03:
		if (formObj.form1_cust_cnt_cd3.value == ""
				|| formObj.form1_cust_seq3.value == "") {
			// ComShowCodeMessage('BKG00266');
			formObj.form1_cust_cnt_cd3.focus();
			return false;
		}
		return true;
		break;
	}
}