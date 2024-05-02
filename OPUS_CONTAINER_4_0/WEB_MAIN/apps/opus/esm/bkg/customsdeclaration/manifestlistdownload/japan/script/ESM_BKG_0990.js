/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : Esm_bkg_0990.js
 *@FileTitle : ESM_BKG-0990
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/13
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
           MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
           Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
/**
 * @fileoverview 
 * @author 
 */
/**
 * @extends
 * @class ESM_BKG-0990 : ESM_BKG-0990 - task script definition for screen
 */

// public variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
function processButtonClick() {
	/***** If sheets are more than 2 in one tab, use additional sheet variables *****/
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_save":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;
		case "btn_close":
			ComClosePopup(); 
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
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	sheetObjects[0].RemoveAll();
	sheetObjects[0].DataInsert(-1);
}
/**
 * setting sheet initial values and header
 * 
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
	      var HeadTitle1="Flag|bl_no|vvd_cd|pod_cd|stage";
	
	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	             {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"dummy_bl_no" },
	             {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"vvd_cd" },
	             {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"pod_cd" },
	             {Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"stage" } ];
	       
	      InitColumns(cols);
	      SetEditable(1);
	      SetSheetHeight(225);
            }

		break;
	}
}
/**
 * handling sheet process
 * @param sheetObj
 * @param formObj 
 * @param sAction 
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSAVE: // retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
			formObj.f_cmd.value=MULTI;
			sheetObj.DoSave("ESM_BKG_0990GS.do", FormQueryString(formObj));
			ComOpenWait(false);
		}
		break;
	case IBSEARCH: // retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			var sXml=sheetObj.GetSearchData("ESM_BKG_0990GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(sXml,{Sync:1});
			formObj.form1_dummy_bl_no.value = ComGetEtcData(sXml, "dummy_bl_no");
			ComOpenWait(false);
		}
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
	switch (sAction) {
	case IBSAVE:
		if (formObj.form1_dummy_bl_no.value == ""
				|| formObj.form1_dummy_bl_no.value.length != 12) {
			ComShowCodeMessage('BKG00266');
			//formObj.form1_dummy_bl_no.focus();
			return false;
		}
		return true;
		break;
	case IBSEARCH:
		return true;
		break;
	}
}
