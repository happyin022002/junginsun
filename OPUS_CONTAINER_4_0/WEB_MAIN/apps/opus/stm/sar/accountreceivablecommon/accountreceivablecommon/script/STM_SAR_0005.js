/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName:   STM_SAR_0005.js
*@FileTitle  : Receipt Bank Account Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
/****************************************************************************************
     Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                  MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;				
 ***************************************************************************************/
/**
 * @extends 
 * @class Receipts : business script for STM_SAR_2001
 */
	var sheetObjects = new Array();
	var sheetCnt = 0;
	// Event handler processing by button click event */
	document.onclick = processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		var formObj = document.form;
		var sheetObject1 = sheetObjects[0];
     	try {
			var srcName = ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
				case "btn_OK":
					comPopupOK();
					break;
				case "btn_Close":
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
		sheetObjects[sheetCnt++] = sheet_obj;
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
		// axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		switch(sheetNo) {
			case 1:      // sheet1 init
			    with(sheetObj){
				      var HeadTitle1="|Bank Account Code|Currency|Open Office|Account Num|Account Seq|Mlt Flag|AR Office|Curr Point";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
				      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"bank_acct_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"opn_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"bank_acct_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bank_acct_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"mlt_curr_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ar_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dp_prcs_knt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				      InitColumns(cols);
				      SetEditable(1);
				      SetSheetHeight(280);
		            }
			    break;
				
		}
	}
	
	function sheet1_OnDblClick(sheetObj, Row, Col) {
		 comPopupOK();
	}
	
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
			case IBSEARCH: 
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true); 
				setTimeout( function () {
					formObj.f_cmd.value = SEARCH;
					var sXml = sheetObj.GetSearchData("STM_SAR_0005GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml);
					ComOpenWait(false);
			    } , 100);	
				break;
		}
	}
	