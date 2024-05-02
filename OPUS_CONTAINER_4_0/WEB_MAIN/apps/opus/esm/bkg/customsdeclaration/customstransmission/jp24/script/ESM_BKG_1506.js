/* =========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1506.js
*@FileTitle  : View Send Flat File
*@author     : CLT
*@version    : 1.0
*@since      : 2014/00/07
 ========================================================= */
/****************************************************************************************
  Event classify code: [initialization]INIT = 0; [input]ADD = 1; [Retrieve]SEARCH = 2; [List Retrieve]SEARCHLIST = 3;
					[modify]MODIFY = 4; [remove]REMOVE = 5; [list remove]REMOVELIST = 6 [multiprocessing]MULTI = 7
					character constant  COMMAND01 = 11; ~ COMMAND20 = 30;
 ***************************************************************************************/

//Common global variable
var sheetObjects = new Array();
var sheetCnt = 0;
//Event handler processing by button click event */
document.onclick = processButtonClick;

	//Event handler processing by button name */
	function processButtonClick(){
		var shtObj = sheetObjects[0];
		var frmObj = document.form;
		try {
			var srcName = ComGetEvent("name");
			switch(srcName) {
				case "btn_close":
					ComClosePopup();
					break;
			} // end switch
		} catch(e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}


	/**
	 * registering IBSheet Object as list
	 *  adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 * @param sheet_obj IBSheet Object
	 */
	function setSheetObject(shtObj) {
		sheetObjects[sheetCnt++] = shtObj;
	}


	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		for (var i = 0; i<sheetObjects.length; i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
	}

	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 * @param sheetObj
	 * @param sheetNo
	 */
	function initSheet(shtObj, shtNo) {
		with (shtObj) {
			switch (shtObj.id) {
				case "sheet1":    // Dummy Sheet
					var HeadTitle = "|Line|Send file";

					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );

					var info = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							  {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
							  {Type:"Text",     Hidden:0,  Width:500,  Align:"Left",    ColMerge:0,   SaveName:"flat_file" } ];

					InitColumns(cols);

					SetEditable(0);
					SetWaitImageVisible(0);
					SetSheetHeight(260);
				break;
			}
		}
	}

	/**
	* handling sheet process
	* @param sheetObj Sheet
	* @param formObj
	* @param sAction
	*/
	function doActionIBSheet(shtObj,frmObj,sAction) {
		switch(sAction) {
			case IBSEARCH:    //search
				if (!ComChkValid(frmObj)) return;

				frmObj.f_cmd.value = SEARCH;
				shtObj.DoSearch("ESM_BKG_1506GS.do", FormQueryString(frmObj));
			break;
		}
	}

	/**
	 * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
	 * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
	 */
	function sheet1_OnLoad(shtObj) {
		doActionIBSheet(shtObj, document.form, IBSEARCH);
	}
