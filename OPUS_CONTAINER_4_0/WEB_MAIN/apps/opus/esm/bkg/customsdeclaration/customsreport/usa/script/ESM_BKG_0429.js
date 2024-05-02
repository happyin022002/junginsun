/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0429.js
*@FileTitle  : US AMS: Receive File
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/26
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class Generate Arrival Manifest by Container : Generate Arrival Manifest by Container
 */
function ESM_BKG_0429() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.doActionIBSheet=doActionIBSheet;
	this.validateForm=validateForm;
}
/* developer's work*/
 // global variable
 var sheetObjects=new Array();
 var sheetCnt=0;
// var rdObjects=new Array();
// var rdCnt=0;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
 function processButtonClick(){
	  /***** using extra sheet valuable if there are more 2 sheets *****/
	  var sheetObject=sheetObjects[0];
	  var sheetObject1=sheetObjects[1];
//      var rdObject=rdObjects[0];
	  /*******************************************************/
	  var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
			case "btn_print":
				if (sheetObject.RowCount()== 0) {
					ComShowCodeMessage("BKG00394");
					return;
				} else {
					rdOpen();
					//ComOpenWindow2("ESM_BKG_0882.do", "print", "width=755,height=460");
				}
				break;
			case "btn_close":
				ComClosePopup();
				break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
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
  */
 function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
 }
 /**
  * initializing sheet
  * implementing onLoad event handler in body tag
  * adding first-served functions after loading screen.
  */
 function loadPage() {
	 for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	 }
//     setTimeout( function () {
//    	 initRdConfig(rdObjects[0]);
//     }, 2000);

	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 }
/**
 * setting Rd
 */
//function initRdConfig(rdObject){
//	var Rdviewer=rdObject;
//	Rdviewer.AutoAdjust=true;
//	Rdviewer.ViewShowMode(0);
//	Rdviewer.IsShowDlg=0;
//	Rdviewer.SetBackgroundColor(128,128,128);
//	Rdviewer.SetPageLineColor(128,128,128);
//	Rdviewer.ApplyLicense("0.0.0.0");
////	Rdviewer.style.height = 0;
//}
 /**
  * setting sheet initial values and header
  * param : sheetObj, sheetNo
  * adding case as numbers of counting sheets
  */
 function initSheet(sheetObj,sheetNo) {
	 var cnt=0;
	 var sheetId=sheetObj.id;
	 switch(sheetId) {
		 case "sheet1":
				with(sheetObj){
				   var HeadTitle1="||";
				   var headCount=ComCountHeadTitle(HeadTitle1);

				   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

				   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				   var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				   InitHeaders(headers, info);

				   var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibFlag" },
						  {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq_no" },
						  {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"msg_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];

				   InitColumns(cols);

				   SetEditable(1);
				   SetCountPosition(0);
				   SetRowHidden(0, 1);
//		           SetSheetHeight(402);
				   ComResizeSheet(sheetObj);
				 }
		break;
	 }
 }
 /**
  * handling of Sheet
  */
 function doActionIBSheet(sheetObj,formObj,sAction) {
	 //sheetObj.ShowDebugMsg = false;
	 sheetObj.SetWaitImageVisible(0);
	 switch(sAction) {
		case IBSEARCH:
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("ESM_BKG_0429GS.do", FormQueryString(formObj) );
			ComOpenWait(false);
			break;
		case IBDOWNEXCEL:	// EXCEL DOWNLOAD
			if (sheetObj.RowCount()== 0) {
				ComShowCodeMessage("BKG00109");
				return;
			} else {
				ComOpenWait(true);

				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1, DownHeader:false, Xml:sheetObj.GetSearchData("/opuscntr/apps/opus/esm/bkg/customsdeclaration/customsreport/script/ESM_BKG_0429.xml") });
				ComOpenWait(false);
			}
			break;
	 } //switch end
 }
/**
 * opening and printing RD
 */
function rdOpen(){
	var formObject=document.form;
	var msgTpId=formObject.rcv_msg_tp_id.value;
	var vvd=formObject.vvd.value;
	var polCd=formObject.pol_cd.value;
	var podCd=formObject.pod_cd.value;
	var blNo=formObject.bl_no.value;
	var batchNo=formObject.batch_no.value;
	var rcvDt=formObject.rcv_dt.value;
	var cntCd=formObject.cnt_cd.value;
	var ioBndCd=formObject.io_bnd_cd.value;
	var rcvDate=formObject.rcv_date.value;
	var rcvSeq=formObject.rcv_seq.value;
	var param="/rp [" + msgTpId + "][" + vvd + "][" + polCd +"][" + podCd +"][" + blNo + "][" + batchNo + "][" + rcvSeq + "][" + rcvDt +
				"][" + cntCd + "][" + ioBndCd + "][" + rcvDate + "][" + rcvSeq + "]";
	var sXml="<?xml version='1.0' ?><SHEET>";
	sXml += RD_GetDataSearchXml(sheetObjects[0], 1);
	sXml += "</SHEET>";
//	var RD_path = "http://localhost:9002/opuscntr/";
	var rdParam = param+" /rdata ["+sXml+"] /riprnmargin /rwait";
	var strPath = RD_path+"apps/opus/esm/bkg/customsdeclaration/customsreport/usa/report/ESM_BKG_0874.mrd";
//	viewer.openFile(strPath, RDServer+rdParam, {timeout:1800});
//	viewer.print({isServerSide:true});
	directReportDownload([{mrdPath:strPath, mrdParam:RDServer+rdParam}]);
}
/* the end of developer's work */

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var blNo = document.form.bl_no.value;
	if (blNo != "") {
		for (i = 0; i <= sheetObj.RowCount(); i++) {
			if (sheetObj.GetCellValue(i, "msg_desc").indexOf("W01" + blNo) > -1) {
					sheetObj.SetRowBackColor(i, "#FFA0F0");
			}
		}
	}
}
