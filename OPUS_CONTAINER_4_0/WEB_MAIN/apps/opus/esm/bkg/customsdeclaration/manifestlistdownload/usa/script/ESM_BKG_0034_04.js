/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0034_04
*@FileTitle  : B/L Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/*------------------The following code is added to make a good JSDoc ------------------*/
	/**
	 * @fileoverview JavaScript is commonly used in business as a calendar-related functions have been defined.
	 */
	/**
	 * @extends
	 * @class ESM_BKG_0034_04 : ESM_BKG_0034_04 business script.
	 */
	function ESM_BKG_0034_04() {
		this.setSheetObject=setSheetObject;
		this.loadPage=loadPage;
		this.initSheet=initSheet;
		this.doActionIBSheet=doActionIBSheet;
		this.validateForm=validateForm;
	}
	/* Developer Work */
	// global variable
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		/***** using extra sheet valuable if there are more 2 sheets다 *****/
		var sheetObj=sheetObjects[0];
		/** ******************************************************************* */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {
			case "btn_railAMS":
				var selRow=sheetObj.GetSelectRow();
				var bl_no=parent.document.form.bl_no.value;
				var cntr_no=sheetObj.GetCellValue(selRow, "cntr_no");
				var vvd=parent.document.form.vvd.value;
				var param="cntr_no=" + cntr_no + "&vvd=" + vvd + "&bl_no=" + bl_no;
				ComOpenWindowCenter("/opuscntr/ESM_BKG_1037.do?pgmNo=ESM_BKG_1037&" + param, "ESM_BKG_1037", 1024, 610);
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
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen
	 */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	parent.loadTabPage(3);
	}
	/**
	 * setting sheet initial values and header param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch(sheetNo) {
		case 1:
			with (sheetObj) {
		        var HeadTitle="|Remarks|Container No.|Rail AMS File No.|P/MIB No.";
		        SetConfig( { SearchMode:2, Page:20, DataRowMerge:0 } );
		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        InitHeaders(headers, info);
	
		        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",           Wrap:1 },
		               {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:0,   SaveName:"diff_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rail_crr_ref_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"ibd_trsp_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
		        InitColumns(cols);
		        SetSheetHeight(250);
			}
			break;
		}
	}
	/**
	 * Search End Event Handling
	 */ 
	function t4sheet1_OnSearchEnd(sheetObj, ErrMsg)  {
		sheetObj.RemoveEtcData();
	}
	/**
	 * handling sheet process
	 */ 
	function doActionIBSheet(sheetObj, formObj, sAction) {
		//sheetObj.ShowDebugMsg = false;
		sheetObj.SetWaitImageVisible(0);
		switch (sAction) {
			case IBSEARCH: // Retrieve
				if (validateForm(sheetObj,formObj,sAction)) {
//					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH01;
					sheetObj.SetWaitImageVisible(0);
 					sheetObj.DoSearch("ESM_BKG_0034_04GS.do", FormQueryString(formObj) );
//					ComOpenWait(false);
				}
				break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // Retrieve
			if (formObj.bl_no.value == "") {
				return false;
			} else {
				return true;
			}
			break;
		}
	}
	/**
	 * Tab click Event Handling
	 */
	function tabLoadSheet(strBlNo, strDiffRmk) {
		if(document.form.diff_rmk.value == "" || document.form.diff_rmk.value == strDiffRmk){
			document.form.diff_rmk.value=strDiffRmk;
			document.form.bak_diff_rmk.value=strDiffRmk;
		}
		if (document.form.bl_no.value != strBlNo) {
			document.form.bl_no.value=strBlNo;
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	/**
	 * Tab data Initialization
	 */
	function tabClearSheet() {
		var frmChild=document.getElementsByTagName("textarea");
		for(var i=0; i<frmChild.length; i++){
    		frmChild[i].value="";
	    }
		sheetObjects[0].RemoveAll();
	}
	/**
	 * Tab Activation Handling
	 */
	var enableFlag=true;
	function tabEnableSheet(flag) {
		var formObject=document.form;
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
	}
	/**
	 * get Save String
	 */
	function getSaveString() {
		var newParam=ComSetPrifix(FormQueryString(document.form), "t4_");
		//var oldParam = ComSetPrifix(sheetObjects[0].GetSaveString(true), "t4_old_");
		return newParam;
	}
	/* Developer Work End */
