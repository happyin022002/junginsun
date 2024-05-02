/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BGK_0470.js
*@FileTitle  : ESM_BKG-0470
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// global variable
var sheetObjects=new Array();
var sheetCnt=0;
var state="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
function processButtonClick() {
	/** *** using extra sheet valuable if there are more 2 sheets **** */
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
			case "btn_save":
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break;
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				break;
			case "btn_transmit":
				doActionIBSheet(sheetObjects[0], formObject, COMMAND01);
				break;
			case "btn_calendar":
				var cal = new ComCalendar();
				cal.select(formObject.form1_eta_dt1, "yyyy-MM-dd");
				break;
		} // end switch

	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}
/**
* registering IBSheet Object as list
* adding process for list in case of needing batch processing with other items
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
	document.form.form1_in_vvd_cd.focus();
}

//sheet data Initialization
function initSheetData(sheetObj, formObj) {
	sheetObj.RemoveAll();
	//sheetObj.DataInsert(-1);
	IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
}

function initControl() {
	axon_event.addListener("keydown", "ComKeyEnter", "form");
	ComBtnDisable("btn_transmit");
	ComBtnDisable("btn_save");
}

 /**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 * @param sheetObj
 * @param sheetNo
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": // sheet1 init
		with(sheetObj){
			var HeadTitle = "|in_vvd_cd|in_pod_cd|eta_dt1|eta_dt2|arr_yd_id|lodg_wgt|cstms_mf_cd|in_pod_cd_split|mf_rmk|ib_cssm_voy_no";

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",   Hidden:1,  Width:0,    SaveName:"ibflag" },
						 {Type:"Text",     Hidden:0,  Width:80,   SaveName:"in_vvd_cd" },
						 {Type:"Text",     Hidden:0,  Width:80,   SaveName:"in_pod_cd" },
						 {Type:"Text",     Hidden:0,  Width:80,   SaveName:"eta_dt1" },
						 {Type:"Text",     Hidden:0,  Width:80,   SaveName:"eta_dt2" },
						 {Type:"Text",     Hidden:0,  Width:80,   SaveName:"arr_yd_id" },
						 {Type:"Text",     Hidden:0,  Width:80,   SaveName:"lodg_wgt" },
						 {Type:"Text",     Hidden:0,  Width:80,   SaveName:"cstms_mf_cd" },
						 {Type:"Text",     Hidden:0,  Width:80,   SaveName:"in_pod_cd_split" },
						 {Type:"Text",     Hidden:0,  Width:200,  SaveName:"mf_rmk" },
						 {Type:"Text",     Hidden:0,  Width:80,   SaveName:"ib_cssm_voy_no" },
						 {Type:"Text",     Hidden:0,  Width:80,   SaveName:"in_joint_flg" } ];

			InitColumns(cols);
			SetWaitImageVisible(0);
			SetEditable(1);
			SetSheetHeight(100);
			SetVisible(0);
		}
		break;
	}
}

/**
* handling sheet process
* @param sheetObj Sheet
* @param formObj
* @param sAction
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // Retrieve
		if (!validateForm(sheetObj, formObj, sAction)) return;
		ComOpenWait(true);
		sheetObj.SetWaitImageVisible(0);
		sheetObj.RemoveAll();
		sheetObj.DataInsert(-1);
		IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
		formObj.f_cmd.value = SEARCH;
		formObj.in_vvd_cd.value = formObj.form1_in_vvd_cd.value;
		formObj.in_pod_cd.value = formObj.form1_in_pod_cd.value;
		//formObj.in_pod_cd_split.value = formObj.in_pod_cd_split.value;
		ComResetAll();
		sheetObj.DoSearch("ESM_BKG_0470GS.do", FormQueryString(formObj), {Sync:2} );
		ComOpenWait(false);
		break;

	case IBSAVE: // Save
		if (!validateForm(sheetObj, formObj, sAction)) return;
		sheetObj.SetWaitImageVisible(0);
		IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
		formObj.f_cmd.value=MULTI;
		sheetObj.DoAllSave("ESM_BKG_0470GS.do", FormQueryString(formObj));
		break;

	case COMMAND01: // Transmit
		if (!validateForm(sheetObj, formObj, sAction)) return;
		formObj.f_cmd.value=MULTI01;
		sheetObj.SetWaitImageVisible(0);
		formObj.in_pod_cd_split.value=formObj.form1_in_pod_cd_split.value;
		sheetObj.DoSearch("ESM_BKG_0470GS.do", FormQueryString(formObj) );
		ComEtcDataToForm(formObj, sheetObj);
		break;
	}
}

/**
* handling process for input validation
* @param sheetObj
* @param formObj
* @param sAction
*/
function validateForm(sheetObj, formObj, sAction) {
	if (formObj.form1_in_vvd_cd.value == "" || formObj.form1_in_vvd_cd.value.length != 9) {
		ComShowCodeMessage('BKG00203');
		formObj.form1_in_vvd_cd.focus();
		return false;
	}
	if (formObj.form1_in_pod_cd.value == "" || formObj.form1_in_pod_cd.value.length != 5) {
		ComShowCodeMessage('BKG00203');
		formObj.form1_in_pod_cd.focus();
		return false;
	}
	return true;
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg){
	ComOpenWait(false);
	if (sheetObj.GetEtcData("TRANS_RESULT_KEY") == "S") {
		var formObj = document.form;
		if (sheetObj.RowCount() < 1) {
			initSheetData(sheetObj, formObj);
			formObj.form1_eta_dt1.value = "";
			formObj.form1_mf_rmk.value = "";
			formObj.form1_in_joint_flg.value = "";
			formObj.in_joint_flg.checked = false;
		} else {
			ComBtnEnable("btn_transmit");
			ComBtnEnable("btn_save");
			IBS_CopyRowToForm(sheetObj, formObj, 1, "form1_");
			if (formObj.form1_in_joint_flg.value == "J") {
				formObj.in_joint_flg.checked = true;
			} else {
				formObj.in_joint_flg.checked = false;
			}
		}
	}
}

function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
	if (sheetObj.GetEtcData("TRANS_RESULT_KEY") == "S") {
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
	}
}
