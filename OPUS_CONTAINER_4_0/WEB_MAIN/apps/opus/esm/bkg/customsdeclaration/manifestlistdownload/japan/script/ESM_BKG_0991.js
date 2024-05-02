/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : Esm_bkg_0991.js
 *@FileTitle : ESM_BKG-0991
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// global variable
var sheetObjects = new Array();
var sheetCnt = 0;
// Event handler processing by button click event  */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick() {
	/***** using extra sheet valuable if there are more 2 sheets *****/
	/** **************************************************** */
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	var opener = window.dialogArguments;
	if (!opener) opener = parent;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "CMF01Checked":
				formObj.in_msg_flag.value = ComGetEvent("value");
				$("input:radio[name='CMF03Checked']").removeAttr("checked");    // CMF03Checked 선택해제
			break;

			case "CMF03Checked":
				formObj.in_msg_flag.value = ComGetEvent("value");
				$("input:radio[name='CMF01Checked']").removeAttr("checked");    // CMF01Checked 선택해제
			break;

			case "btn1_Close":
				if (!opener.closed) {
					try {
						opener.retrieve();
					} catch (ex) {}
				}
				ComClosePopup();
			break;

			case "btn2_MFR":
				$("input:radio").removeAttr("checked");    // radio 전체 선택해제
				formObj.in_msg_tp.value = "MFR";
				formObj.in_msg_flag.value = "9";
				formObj.in_mfr_gubun.value = "N";
				doActionIBSheet(sheetObj, formObj, MULTI);
			break;

			case "btn2_CMF01":
				$("input:radio[name='CMF03Checked']").removeAttr("checked");    // CMF03Checked 선택해제
				if ($("input:radio[name='CMF01Checked']:checked").length < 1) {    // CMF01Checked 선택 카운트
					ComShowCodeMessage("BKG00676");
					return;
				}
				formObj.in_msg_tp.value = "CMF01";
				formObj.in_mfr_gubun.value="Y";
				doActionIBSheet(sheetObj, formObj, MULTI);
			break;

			case "btn2_CMF03":
				$("input:radio[name='CMF01Checked']").removeAttr("checked");    // CMF01Checked 선택해제
				if ($("input:radio[name='CMF03Checked']:checked").length < 1) {    // CMF03Checked 선택 카운트
					ComShowCodeMessage("BKG00676");
					return;
				}
				formObj.in_msg_tp.value = "CMF03";
				formObj.in_mfr_gubun.value="Y";
				doActionIBSheet(sheetObj, formObj, MULTI);
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
}

/**
 * setting sheet initial values and header param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, shtNo) {
	with (sheetObj) {
		switch (sheetObj.id) {
			case "sheet1":    // 트랜잭션을 위해 사용되는 Dummy Sheet
				var cnt = 0;
				var HeadTitle = "status";

				SetEditEnterBehavior("tab");
				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
				var info = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
				InitColumns(cols);

				SetEditable(1);
				SetWaitImageVisible(0);
				SetVisible(0);
				break;
		}
	}
}

/**
* Sheet process handling
* @param sheetObj
* @param formObj
* @param sAction
* @return
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
		case MULTI:
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			sheetObj.LoadSaveData(sheetObj.GetSaveData("ESM_BKG_0991GS.do", FormQueryString(formObj)), {Sync:1});
			ComOpenWait(false);
		break;
	}
}
