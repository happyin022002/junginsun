/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0302.js
*@FileTitle  : ESM_BKG_0302
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/24
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Added code to make a good JSDoc ------------------*/
   /**
	 * @fileoverview JavaScript File is commonly using. calendar functions have is defined.
	 * @author
	 */
	/**
	 * @extends
	 * @class ESM_BKG_0302 : business script for ESM_BKG_0302
	 */
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		 /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
			 var sheetObject1=sheetObjects[0];
		 /*******************************************************/
		 var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
		   switch(srcName) {
				case "btn_download":
					doActionIBSheet(sheetObject1,formObject,MULTI);
					break;
				case "btn_close":
					ComClosePopup();
					break;
			} // end switch
		}catch(e) {
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
			// Preferences change the name of the function to start
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			// The final configuration functions added
			ComEndConfigSheet(sheetObjects[i]);
		}
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:      //sheet1 init
				with(sheetObj){
					var HeadTitle="flatFile";
					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
					var info = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					var cols = [ {Type:"Text", Hidden:0,  Width:100,  Align:"Left", SaveName:"flat_file" } ];
					InitColumns(cols);
					SetEditable(1);
					SetSheetHeight(220);
					SetWaitImageVisible(0);
					SetVisible(0);
				}
			break;
		}
	}
	// Sheet handling process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case MULTI:
				if (!validateForm(sheetObj, formObj, sAction)) return false;
				sheetObj.RemoveAll()
				formObj.f_cmd.value = MULTI;
				ComOpenWait(true);
				var sXml = sheetObj.GetSearchData("ESM_BKG_0302GS.do", FormQueryString(formObj));
				if (sXml.indexOf("<MESSAGE>") > -1) {
					showErrorMsg(sXml);
				} else {
					sheetObj.DataInsert(1);
					sheetObj.SetCellText(1, "flat_file", ComGetStrEtcData(sXml, "flatFile"));
					sheetObj.Down2Text({ ColDelim:"", FileName:formObj.vvd_cd.value+"txt", DownHeader:false});
				}
				ComOpenWait(false);
			break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case MULTI: {
				//Check the default format
				if (!ComChkValid(formObj)) return false;
				break;
			}
		}
		return true;
	}
