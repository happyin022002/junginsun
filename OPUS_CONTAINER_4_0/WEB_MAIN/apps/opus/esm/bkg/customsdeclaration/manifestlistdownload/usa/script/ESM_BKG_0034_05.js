/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0034_05.jsp
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
	 * @class ESM_BKG_0034_05 : ESM_BKG_0034_05 business script.
	 */
	function ESM_BKG_0034_05() {
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
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items  defining list on the top of source
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
	 */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCHAPPEND);
    	parent.loadTabPage(4);
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
	        var HeadTitle="Seq.|Type|Item|Previous|Current|User Name|Office|Update Date|User ID";
	        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	        var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle, Align:"Center"} ];
	        InitHeaders(headers, info);
	        var cols = [ {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"Seq",           Wrap:1 },
	               {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"his_tp_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"his_itm_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	               {Type:"Text",      Hidden:0,  Width:240,  Align:"Left",    ColMerge:0,   SaveName:"pre_ctnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	               {Type:"Text",      Hidden:0,  Width:240,  Align:"Left",    ColMerge:0,   SaveName:"crnt_ctnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"usr_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
	        InitColumns(cols);
	        SetSheetHeight(280);
	        SetEditable(0);
	        SetColProperty("cre_dt", {Format:"####-##-####:##:##"} );
			}
			break;
		}
	}
	/**
	 * handling sheet process
	 */ 
	function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
		//sheetObj.ShowDebugMsg = false;
		sheetObj.SetWaitImageVisible(0);
		switch (sAction) {
			case IBSEARCH: // Retrieve
				if (validateForm(sheetObj,formObj,sAction)) {
//					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH01;
 					sheetObj.DoSearch("ESM_BKG_0034_05GS.do", FormQueryString(formObj) );
//					ComOpenWait(false);
				}
				break;
			case IBSEARCHAPPEND:  // pasing retrieve
				if (!validateForm(sheetObj,formObj,IBSEARCH)) return false;
//				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH01;
				if(PageNo >= 1){
 					sheetObj.DoSearch("ESM_BKG_0034_05GS.do", CondParam+"&"+ "page_no=" + PageNo,{Append:true} );
				}else{
 					sheetObj.DoSearch("ESM_BKG_0034_05GS.do", FormQueryString(formObj)+"&"+ "page_no=1",{Append:false} );
				}
//				ComOpenWait(false);
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
		var formObject=document.form;
		formObject.bl_no.value=strBlNo;
		doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
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
