/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0080.js
*@FileTitle  : Booking Creation 1_Container Type/Size
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	/* Developer Work	*/
	// global variable
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Event handler processing by button click event */
	document.onclick = processButtonClick;
	
	// Event handler processing by button name */
	function processButtonClick() {
		/***** using extra sheet valuable if there are more 2 sheets *****/
		var sheetObject=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {
			case "btn_confirm":
				comPopupOK();
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
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
		case 1: //sheet1 init
            with(sheetObj){
	            var HeadTitle1=" ||TP/SZ|Description";
	            
	            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	            
	            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            InitHeaders(headers, info);
	            
	            var cols = [ {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"radio",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                         {Type:"CheckBox",  Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"check",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                         {Type:"Text",      Hidden:0,  Width:48,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cntr_tpsz_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	             
	            InitColumns(cols);
	            
	            SetEditable(1);
	            SetSheetHeight(337);
            }
			break;
		}
	}
	/**
	 * handling sheet process. <br>
	 **/
	function doActionIBSheet(sheetObj, formObj, sAction, col) {
		//        sheetObj.ShowDebugMsg = true;
		switch (sAction) {
		case IBSEARCH: //Retrieve
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESM_BKG_0080GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(""));
			}
			break;
		}
	}
	
	function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) { 
		if (Col==0) return;
		sheetObj.SetCellValue(Row,"radio",1,0);
	}

	
	/**
	 * handling process for input validation. <br>
	 **/
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
		}
		return true;
	}
	/* Developer Work End */
