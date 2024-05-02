/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_1193.js
*@FileTitle : ESM_BKG_1193
*@author     : CLT
*@version    : 1.0
*@since      : 2014/12/29
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
function processButtonClick() {
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_close":
			ComClosePopup();
			break;
		case "btn_view":
			sheet1_OnDblClick(sheetObjects[0], sheetObjects[0].GetSelectRow(), 1);
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
			var HeadTitle1="|Seq.|Type|VVD|Time|Status|Error Code|Error Msg.||Visit No";

			SetConfig( { SearchMode:2, MergeSheet:5, Page:100, FrozenCol:0, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",   Hidden:1,  Width:40,   Align:"Center",   ColMerge:1,   SaveName:"ibflag" },
						 {Type:"Seq",      Hidden:0,  Width:40,   Align:"Center",   ColMerge:1,   SaveName:"SEQ" },
						 {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",   ColMerge:1,   SaveName:"type",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",   ColMerge:1,   SaveName:"vvd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",     Hidden:0,  Width:130,  Align:"Center",   ColMerge:1,   SaveName:"rcv_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",   ColMerge:1,   SaveName:"cstms_ack_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",   ColMerge:1,   SaveName:"cstms_err_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",   ColMerge:1,   SaveName:"cstms_err_msg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",     Hidden:1,  Width:120,  Align:"Center",   ColMerge:1,   SaveName:"rcv_log_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",     Hidden:1,  Width:100,  Align:"Center",   ColMerge:1,   SaveName:"vst_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }
						 ];

			InitColumns(cols);

			SetEditable(1);
            SetSheetHeight(400);
            ComResizeSheet(sheetObjects[0]);
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
		formObj.f_cmd.value=SEARCH;
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		sheetObj.DoSearch("ESM_BKG_1193GS.do", FormQueryString(formObj) );
		ComOpenWait(false);
		break;
	}
}

function sheet1_OnDblClick(sheetObj, row, col) {
	var sUrl="/opuscntr/ESM_BKG_1194.do?pgmNo=ESM_BKG_1194&rcv_log_seq=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "rcv_log_seq")
	+ "&vst_no=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "vst_no")
	+ "&vvd_cd=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "vvd_cd")
	+ "&type="   + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "type");
	ComOpenWindowCenter(sUrl, "ESM_BKG_1194", 600, 600, false);
}