/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : Esm_bkg_0472.js
 *@FileTitle : ESM_BKG-0472
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_BKG-0472 : business script for ESM_BKG-0472
 */
// Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
function processButtonClick() {
	/* */
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_close":
			ComClosePopup();
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
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}


/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": //sheet1 init
		with(sheetObj){
			var HeadTitle1="|Receive file|Receive file";
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",   Hidden:1,  Width:40,   Align:"Center",   ColMerge:0,   SaveName:"ibflag" },
						 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",   ColMerge:0,   SaveName:"rcv_seq" },
						 {Type:"Text",     Hidden:0,  Width:60,   Align:"Left",     ColMerge:0,   SaveName:"edi_rcv_msg_ctnt" } ];

			InitColumns(cols);

			SetEditable(0);
			SetSheetHeight(225);
			SetCountPosition(4);
			SetCountFormat("[SELECTDATAROW / TOTALROWS]");

		}
		break;
	}
}


/**
 * handling process for Sheet
 * @param sheetObj Sheet
 * @param formObj
 * @param sAction
 * @param CondParam CondParam
 * @param PageNo PageNo
 */
function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: //
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			// alert(sheetObj.cellValue(1,"bl_no"));
			// alert(sheetObj.cellValue(1,"vvd_cd"));
			// alert(sheetObj.cellValue(1,"pod_cd"));
			sheetObj.DoSearch("ESM_BKG_0472GS.do", FormQueryString(formObj) );
			ComOpenWait(false);
		}
		break;
	case IBSEARCHAPPEND: //
		if (!validateForm(sheetObj, formObj, IBSEARCH))
			return false;
		formObj.f_cmd.value=SEARCH;
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		if (PageNo >= 1) {
			sheetObj.DoSearch("ESM_BKG_0472GS.do", CondParam , "iPage=" + PageNo, true);
		} else {
			sheetObj.DoSearch("ESM_BKG_0472GS.do", FormQueryString(formObj ),"iPage=1", false);
		}
		ComOpenWait(false);
		break;
	}
}


/**
 * @param sheetObj Sheet
 * @param CondParam CondParam
 * @param PageNo PageNo
 * @param OnePageRows OnePageRows
 */
//method change[check again]CLT
function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
	//alert("test");
	//doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
}


/**
 * handling process for input validation
 * @param sheetObj Sheet
 * @param formObj
 * @param sAction
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		return true;
		break;
	}
}
