/*=========================================================
 
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0249.js
*@FileTitle  : Customer Code Entry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25

=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
  /**
     * @extends 
     * @class esm_bkg_0249 : business script for esm_bkg_0249
     */
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event  */
document.onclick=processButtonClick;
/**
 * Event handler processing by button name
 */
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, SEARCH);
			break;
		case "btn_new":
			sheetObject.RemoveAll();
			formObject.reset();
			doActionIBSheet(sheetObjects[0], document.form, INIT);
			break;
		case "btn_downexcel":
			ComOpenWait(true);
			if(sheetObject.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
				}else{
					sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
				}
			ComOpenWait(false);
			break;
		case "btn_calendar":
			var cal=new ComCalendarFromTo();
			cal.select(formObject.s_vps_eta_dt, formObject.e_vps_eta_dt, 'yyyy-MM-dd');
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
 * adding first-served functions after loading screen
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, INIT);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	sheetObjects[0].SetWaitImageVisible(0);
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
	case "sheet1": //sheet1 init
		with (sheetObj) {
	        if (location.hostname != "")
	        var HeadTitle1="|Lane|VVD|Operator|POL|ETB|ETL|POD|ETA|CRN|";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"crr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"vps_etb_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"crn_wrk_cmnc_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vps_port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"vps_eta_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cvy_ref_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	         
	        InitColumns(cols);
	
	        SetEditable(1);
//	        SetColProperty("vps_eta_dt", {Format:"####-##-####:##"} );
//	        SetColProperty("vps_etb_dt", {Format:"####-##-####:##"} );
//	        SetColProperty("crn_wrk_cmnc_dt", {Format:"####-##-####:##"} );
	        
	        SetColProperty("vps_eta_dt", {Format:"YmdHm"} );
	        SetColProperty("vps_etb_dt", {Format:"YmdHm"} );
	        SetColProperty("crn_wrk_cmnc_dt", {Format:"YmdHm"} );
//	        SetSheetHeight(420);
	        ComResizeSheet(sheetObj);
	        
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
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case INIT: //init
		if (sheetObj.id == "sheet1") {
			formObj.s_vps_eta_dt.value=ComGetNowInfo('ymd', '-');
			formObj.e_vps_eta_dt.value=ComGetDateAdd(null, 'd', 14, '-');
			formObj.vps_port_cd.focus();
			formObj.vps_port_cd.value='CA';
		}
		break;
	case SEARCH: //Retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("ESM_BKG_0249GS.do", FormQueryString(formObj) );
			ComOpenWait(false);
		}
		break;
	}
}
/**
 * handling process for input validation
 * @param sheetObj Sheet
 * @param formObj
 * @param sAction
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case SEARCH: 
		if (!ComChkValid(formObj))
			return false;
		if ((ComIsNull(formObj.vps_port_cd) || ComIsNull(formObj.s_vps_eta_dt) || ComIsNull(formObj.e_vps_eta_dt))
				&& (ComIsNull(formObj.vvd_cd)) && (ComIsNull(formObj.cvy_ref_no))) {
			ComShowCodeMessage('BKG00626', '(POD and ETA) or (VVD) or (CRN)');
			ComSetFocus(form.vps_port_cd)
			return false;
		}
		break;
	}
	return true;
}