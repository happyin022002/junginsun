/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0979.jsp
*@FileTitle  : PSA Container Booking I/F - Exception Message
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
/**
 * Function definition for creating JSDOC
 */
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;
// Event Handler definition for Button Click event */
document.onclick=processButtonClick;
//Event Handler for branch processing by judging button name.
function processButtonClick(){
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btn_Close":
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
 * Registering IBSheet Object in to Array
 * Afterwards, when other items need to be batch processed,it can add to the process that stores in to array
 * The array is defined at upper part of source
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* Sheet basic setting & initializing
* 
* onLoad Event HandlerImplementation of body tag
* After loading screen in the browser, add function in pre-processing
*/
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	sheet1_OnLoadFinish(sheetObj);
}
/**
 * After completion of Sheet1 loading, handling inquiry automatically.
 * 
 * @param sheetObj
 * @return
 */
function sheet1_OnLoadFinish(sheetObj) {
	// axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
}
/**
 * Definition for sheet initial setting value, header
 * param : sheetObj ==> sheet object, 
 * sheetNo ==> If the serial number ID tag attached to the sheet are many,
 * adding 'Case' clause as a number of sheets, configures initial module.
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
	case "sheet1":
	    with(sheetObj){
		      var HeadTitle1="|Booking No|SEQ";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bkg_seq" } ];
		      InitColumns(cols);
		      SetEditable(0);
		      SetVisible(false);
            }
		break;
	}
}
//Handling process about Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	case IBSEARCH:      
		formObj.f_cmd.value=SEARCH;
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
 		sheetObj.DoSearch("ESM_BKG_0979GS.do", FormQueryString(formObj) );
 		if (sheetObj.GetEtcData("status_log") != undefined)
 			formObj.status_log.value=sheetObj.GetEtcData("status_log");
		ComOpenWait(false);
		break;
	}
}
