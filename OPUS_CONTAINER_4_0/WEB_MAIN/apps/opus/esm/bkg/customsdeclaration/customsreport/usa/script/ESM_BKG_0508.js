/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0508.js
*@FileTitle  : US AMS: Sent File
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

/* Developer Work	*/
 // global variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;

// Event handler processing by button name */
function processButtonClick(){
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
			case "btn_print":
				rdOpen();
				break;
			case "btn_close":
				ComClosePopup();
				break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
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
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": //sheet1 init
		with(sheetObj){
			var HeadTitle1="|";
			var headCount=ComCountHeadTitle(HeadTitle1);

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			{Type:"Text",      Hidden:0,  Width:500,  Align:"Left",    ColMerge:0,   SaveName:"log_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];

			InitColumns(cols);
		//	SetCountPosition(0);
			SetRowHidden(0, 1);
		//	SetSheetHeight(500);
			ComResizeSheet(sheetObj);
		}
	break;
	}
}

/**
 * handling sheet process
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.SetWaitImageVisible(0);
	switch(sAction) {
		case IBSEARCH:   //Retrieve
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("ESM_BKG_0508GS.do", FormQueryString(formObj) );
			ComOpenWait(false);
			break;
		case IBDOWNEXCEL:	// EXCEL DOWNLOAD
			if (sheetObj.RowCount()== 0) {
				ComShowCodeMessage("BKG00109");
				return;
			} else {
				ComOpenWait(true);
				if(ofmFlg == 'N'){
					//sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
					var xmlUrl="http://"+location.hostname +":"+ location.port + "/opuscntr/apps/opus/esm/bkg/customsdeclaration/customsreport/usa/script/ESM_BKG_0508.xml";
					sheetObj.Down2Excel({DownCols:makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1, DownHeader:false});
				}
				else{
					formObj.f_cmd.value=COMMAND01;
					formObj.target="download";
					formObj.action="ESM_BKG_0508_1GS.do";
					formObj.submit();
				}
				ComOpenWait(false);
			}
			break;
	}
}

/**
 * RD open and print
 */
function rdOpen(){
	var formObject=document.form;
	var msgTpId=formObject.trsm_msg_tp_id.value;
	var vvd=formObject.vvd.value;
	var polCd=formObject.pol_cd.value;
	var podCd=formObject.pod_cd.value;
	var ofcCd=formObject.ofc_cd.value;
	var usrId=formObject.usr_id.value;
	var sndDate=formObject.snd_date.value;
	var cntCd=formObject.cnt_cd.value;
	var ioBndCd=formObject.io_bnd_cd.value;
	var hisSeq=formObject.his_seq.value;
	var sndDt=formObject.snd_dt.value;
	var stwgSndId=formObject.stwg_snd_id.value;
	var param="/rp [" + msgTpId + "][" + vvd + "][" + polCd +"][" + podCd +"][" + ofcCd + "][" + usrId + "][" + sndDate +
				"][" + cntCd + "][" + ioBndCd + "][" + sndDt + "][" + hisSeq + "][" + stwgSndId + "]";
//	var RD_path = "http://localhost:9001/opuscntr/";
	var rdParam=param +  " /riprnmargin /rwait";
	var strPath=RD_path+"apps/opus/esm/bkg/customsdeclaration/customsreport/usa/report/ESM_BKG_0834.mrd";
//	viewer.openFile(strPath, RDServer+rdParam,{timeout:1800});
//	viewer.print({isServerSide:true});
	directReportDownload([{mrdPath:strPath, mrdParam:RDServer+rdParam}]);
}
