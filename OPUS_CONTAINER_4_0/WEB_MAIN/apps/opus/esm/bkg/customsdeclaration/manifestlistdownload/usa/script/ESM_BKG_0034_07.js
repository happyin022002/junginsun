/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0034_07.jsp
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
	 * @class ESM_BKG_0034_07 : ESM_BKG_0034_07 business script.
	 */
	function ESM_BKG_0034_07() {
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
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * initializing sheet implementing onLoad event handler in body tag
	 */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	parent.loadTabPage(6);
	}
	/**
	 * setting sheet initial values and header param : sheetObj, sheetNo
	 * number adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch(sheetNo) {
		case 1:
			with (sheetObj) {
		        var HeadTitle="Seq.|AMS File No.|Filer|F/O/C|Piece Count|Piece Count|IT No.|HUB|DEL|CNTR No.|TY/SZ|Consignee";
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        InitHeaders(headers, info);
		        var cols = [ {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"Seq",               Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cstms_file_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"foc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pck_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ams_pck_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ibd_trsp_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"hub_loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"cnee",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
		         
		        InitColumns(cols);
		        SetSheetHeight(280);
		        SetEditable(0);
		        SetColProperty("cstms_file_tp_cd", {Format:"00"} );
				}
			break;
		}
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
 					sheetObj.DoSearch("ESM_BKG_0034_07GS.do", FormQueryString(formObj) );
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
	 * when tab click, retrieve
	 */
	function tabLoadSheet(strBlNo) {
		//alert("tabLoadSheet: 7");
		var formObject=document.form;
		if (formObject.bl_no.value != strBlNo) {
			formObject.bl_no.value=strBlNo;
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
		}
	}
	/**
	 * tab data Initialization
	 */
	function tabClearSheet() {
		document.form.bl_no.value="";
		sheetObjects[0].RemoveAll();
	}
	/**
	 * tab active handling
	 */
	var enableFlag=true;
	function tabEnableSheet(flag) {
		var formObject=document.form;
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
	}
	/* Developer Work End */
