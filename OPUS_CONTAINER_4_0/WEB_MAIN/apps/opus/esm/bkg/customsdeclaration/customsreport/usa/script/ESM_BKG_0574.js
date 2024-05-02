/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0574.js
*@FileTitle  : Auto Filing NVOCC Transmission Status
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class Customer Code Entry : business script for Customer Code Entry
 */
function ESM_BKG_0574() {
	this.processButtonClick=processButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.doActionIBSheet=doActionIBSheet;
	this.validateForm=validateForm;
}
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		case "btn_DownExcel":
			doActionIBSheet(sheetObjects[0], formObject, IBDOWNEXCEL);
			break;
		case "btn_nvoccscac":
//			ComOpenWindow2("ESM_BKG_0040_Q.do?pgmNo=ESM_BKG_0040", "ESM_BKG_0040","scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no,window.clientWidth,window.clientHeight");
			
			ComOpenWindowCenter("ESM_BKG_0040_Q_POP.do?pgmNo=ESM_BKG_0040&mainPage=false", "ESM_BKG_0040", 1000, 600, false);			
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
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
//	axon_event.addListenerForm('change', 'obj_Change', document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
	document.form.vvd.focus();
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	var headerColorForNvocc="#E7E7EB";
	switch (sheetID) {
	case "sheet1": //sheet1 init
		with (sheetObj) {
		   
		   if (location.hostname != "")
		   var HeadTitle1="|Seq.|OPUS Information|OPUS Information|OPUS Information|Customs Filing Information|Customs Filing Information|Customs Filing Information|Customs Filing Information|Customs Filing Information|Customs Filing Information|Customs Filing Information|Customs Filing Information|Customs Filing Information|";
		   var HeadTitle2="|Seq.|M.B/L No.|SCAC|SCAC Name|SCAC|H.B/L No.|M.B/L No.|VSL Name|Voyage|AMS POD|POD|69|Receive Date|";
		   var headCount=ComCountHeadTitle(HeadTitle1);
		   var prefix="sheet1_";

		   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		   var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		   var headers = [ { Text:HeadTitle1, Align:"Center"},
		                 { Text:HeadTitle2, Align:"Center"} ];
		   InitHeaders(headers, info);

		   var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"mbl",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"com_scac",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:190,  Align:"Left",    ColMerge:1,   SaveName:prefix+"scac_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"scac",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"hbl",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"nvocc_cbl",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"nvocc_vsl_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"nvocc_skd_voy_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cstms_pod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"nvocc_pod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mf_rspn_rcv_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"rcv_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_err" } ];
		    
		   InitColumns(cols);

		   SetEditable(0);
//		   SetSheetHeight(442);
		   ComResizeSheet(sheetObj);
		   SetRangeBackColor(1,1,1,13,"#555555");
		}
		break;
	}
}

function call_ams_pod() {
	var sheetObj=sheetObjects[0];
	doActionIBSheet(sheetObj, document.form, SEARCH01);
}

// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction, Row, Col) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.SetWaitImageVisible(0);
	switch (sAction) {
	case IBSEARCH: 
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		ComOpenWait(true);
		formObj.f_cmd.value=SEARCH;
		if ("sheet1" == sheetObj.id)
			sheetObj.DoSearch("ESM_BKG_0574GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
		ComOpenWait(false);
		break;
	case SEARCH01: 
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		formObj.f_cmd.value=SEARCH01;
		if ("sheet1" == sheetObj.id) {
			var sXml=sheetObj.GetSearchData("ESM_BKG_0574GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
			formObj.ams_pod.value=ComGetEtcData(sXml, "ams_pod");
		}
		break;
	case IBDOWNEXCEL: //Down Excel
		ComOpenWait(true);
		if(sheetObj.RowCount() < 1){//no data
			ComShowCodeMessage("COM132501");
		}else{
			 sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
		}
		ComOpenWait(false);
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		if (!ComChkRequired(formObj))
			return false;
		break;
	}
	return true;
}
/**
 * handling change form data
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
/*function obj_Change() {
	var objSender = ComGetEvent();
	objSender.valule = ComGetEvent("value"); // used data format in input tag
	if (ComGetEvent('name') == "pod"){
		var sheetObj=sheetObjects[0];
		doActionIBSheet(sheetObj, document.form, SEARCH01);
	} else {
		return;
	}
}
*/
/**
 * handling after retrieving sheet1
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj=document.form;
	var prefix="sheet1_";
	if (ErrMsg == "") {
		var errColor=sheetObj.Red;
		for ( var i=2; i < sheetObj.RowCount()+ 2; i++) {
			if (sheetObj.GetCellValue(i, prefix + "pod_err") == "1") {
				sheetObj.SetCellFontColor(i, prefix + "nvocc_pod_cd","#FF0000");
				sheetObj.SetCellFontColor(i, prefix + "cstms_pod_cd","#FF0000");
			}
		}
	}
}
