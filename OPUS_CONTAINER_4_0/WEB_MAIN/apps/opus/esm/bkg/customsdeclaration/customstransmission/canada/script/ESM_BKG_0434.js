/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0434.js
*@FileTitle  : Customer Code Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/24
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// Common global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var docObjects=new Array();
// Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * Event handler processing by button name
 */
function processButtonClick() {
	/* */
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Excel":
			if(sheetObject.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1, DownHeader:false });
			}
			break;
		case "btn_Print":
			rdLoad();
			break;
		case "btn_Close":
			ComClosePopup();
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComFuncErrMsg(e);
		} else {
			ComFuncErrMsg(e);
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
	doActionIBSheet(sheetObjects[0], document.form, INIT);
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 * @param sheetObj obj
 * @param sheetNo obj
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": //sheet1 init
		with (sheetObj) {
			var HeadTitle1="Seq.|msg_desc";
			var headCount=ComCountHeadTitle(HeadTitle1);

//	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];

			InitHeaders(headers, info);

			var cols = [
						 {Type:"Seq",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
						 {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:0,   SaveName:"msg_desc",  KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];

			InitColumns(cols);

			SetEditable(1);
			SetRowHidden(0, 1);
//	        SetSheetHeight(222);
			ComResizeSheet(sheetObj);
		}
		break;
	}
}
/**
 * handling process for Sheet
 * @param sheetObj Sheet
 * @param formObj form
 * @param sAction
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case INIT: //init
		if (sheetObj.id == "sheet1") {
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("ESM_BKG_0434GS.do", FormQueryString(formObj) );
		}
		break;
	}
}
/**
 * Report Open
 */
function rdLoad() {
	var sXml="";
//	var opener_sheet=window.dialogArguments.sheetObjects[0];
//	var row=opener_sheet.GetSelectRow();
//	var sheet_obj1=document.sheet1;

	var opener=window.dialogArguments;
	if (!opener)  opener=window.opener;  //이 코드 추가할것
	if (!opener) opener=parent; //이 코드 추가할것

//	var opener_sheet=opener.sheetObjects[0];
//	var row=opener_sheet.GetSelectRow();

	sXml="<?xml version='1.0' ?><SHEET>";
	sXml += RD_GetDataSearchXml(sheetObjects[0], 1);
	sXml += "<ETC>";

//	sXml += "<MSG_TYPE>" + opener_sheet.GetCellValue(row, "rcv_msg_tp_id") + "</MSG_TYPE>"
//	sXml += "<VVD>" + opener_sheet.GetCellValue(row, "vvd_cd") + "</VVD>"
//	sXml += "<POL>" + opener_sheet.GetCellValue(row, "pol_cd") + "</POL>"
//	sXml += "<POD>" + opener_sheet.GetCellValue(row, "pod_cd") + "</POD>"
//	sXml += "<BLNO>" + opener_sheet.GetCellValue(row, "bl_no") + "</BLNO>"
//	sXml += "<RCV_SEQ>" + opener_sheet.GetCellValue(row, "rcv_seq") + "</RCV_SEQ>"
//	sXml += "<RCV_DATE>" + opener_sheet.GetCellValue(row, "rcv_dt") + "</RCV_DATE>"

	sXml += "<MSG_TYPE>" + form.rcv_msg_tp_id.value + "</MSG_TYPE>"
	sXml += "<VVD>" + form.vvd_cd.value + "</VVD>"
	sXml += "<POL>" + form.pol_cd.value + "</POL>"
	sXml += "<POD>" + form.pod_cd.value + "</POD>"
	sXml += "<BLNO>" + form.bl_no.value + "</BLNO>"
	sXml += "<RCV_SEQ>" + form.rcv_seq.value + "</RCV_SEQ>"
	sXml += "<RCV_DATE>" + form.rcv_dt.value + "</RCV_DATE>"
	sXml += "<RCV_TIME>" + "" + "</RCV_TIME>"
	sXml += "</ETC>";
	sXml += "</SHEET>";

//	viewer.openFile(RD_path+"apps/opus/esm/bkg/customsdeclaration/customsreport/canada/report/ESM_BKG_0875.mrd", RDServer+" /rdata ["+sXml+"]", {timeout:1800});
//	viewer.print({isServerSide:true});
	directReportDownload([{mrdPath:RD_path+"apps/opus/esm/bkg/customsdeclaration/customsreport/canada/report/ESM_BKG_0875.mrd", mrdParam:RDServer+" /rdata ["+sXml+"]"}]);

}
