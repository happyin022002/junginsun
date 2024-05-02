/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0989.js
*@FileTitle  : Transmission History to Korea Customs Send File
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * business script for esm_bkg_0989
 */
// global variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btn_close":
		ComClosePopup();
			break;
		} // end switch
	} catch(e) {
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
* @param sheet_obj IBSheet Object
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
		initSheet(sheetObjects[i], i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}


/**
 * setting sheet initial values and header
 * @param sheetObj
 * @param sheetNo
 * @return
 */
function initSheet(sheetObj, sheetNo) {
	with (sheetObj) {
		switch (sheetObj.id) {
			case "sheet1":    // Dummy Sheet
				var HeadTitle = "|Send file";

				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );

				var info = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							 {Type:"Text",      Hidden:0,  Width:500,  Align:"Left",    ColMerge:0,   SaveName:"edi_snd_msg" } ];

				InitColumns(cols);

				SetEditable(0);
				SetWaitImageVisible(0);
				SetSheetHeight(100);
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
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESM_BKG_0989GS.do", FormQueryString(formObj), {Sync:1});
			ComOpenWait(false);
		break;
	}
}

/**
 * Post-processing
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if (sheetObj.SearchRows() < 1) {
		document.form.msgTxt.value = (" ( " + ComGetMsg("COM130401") + " )");
	} else {
		document.form.msgTxt.value = sheetObj.GetCellValue(sheetObj.HeaderRows(), "edi_snd_msg");
	}
}


