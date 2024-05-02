/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0961.js
*@FileTitle  : Freight & Charge Booking Customer Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event  */
	document.onclick=processButtonClick;
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		if (document.form.bkg_no.value == '') {
			ComShowCodeMessage("BKG00463");
			ComClosePopup(); 
		}
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
	* @param sheetObj sheet Object
	* @param sheetNo 
	*/
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetId=sheetObj.id;
		switch (sheetId) {
		case "sheet1":
		    with(sheetObj){
			      var HeadTitle1="Type|Code|Code|Name";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"bkg_cust_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"cust_cnt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"cust_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			      InitColumns(cols);
			      SetEditable(0);
			      SetSheetHeight(220);
	            }
			break;
		}
	}
	function processButtonClick() {
		/***** using extra sheet valuable if there are more 2 sheets *****/
		var sheetObject=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_Close":
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
	 * Sheet process handling
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
		case IBSEARCH:
			ComSetObjValue(formObj.f_cmd, SEARCH);
			sheetObj.DoSearch("ESM_BKG_0961GS.do", ''+"&"+ FormQueryString(formObj),{Append:false} );
			break;
		}
	}
	/**
	 * Sheet1 double click event handling
	 * @param sheetObj
	 * @param row
	 * @param col
	 * @return
	 */
	function sheet1_OnDblClick(sheetObj, row, col) {
		if (col != 1) {
			var obj=new Object();
			obj.cust_cnt_cd=sheetObj.GetCellValue(row, "cust_cnt_cd");
			obj.cust_seq=sheetObj.GetCellValue(row, "cust_seq");
			window.returnValue=obj;
			ComClosePopup(); 
		}
	}
	/**
	 * handling process for input validation
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
		}
		return true;
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
	 * Debug alert
	 * @param ex
	 * @return
	 */
	function bkg_error_alert(ex) {
		alert('[ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
	}