/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0034_06.jsp
*@FileTitle  : B/L Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
/****************************************************************************************
   Event distinction code: [Initialization]INIT=0; [Input]ADD=1; [Retrieve]SEARCH=2; [Retrieving List]SEARCHLIST=3;
					[Modification]MODIFY=4; [Delete]REMOVE=5; [Deleting list]REMOVELIST=6 [Multi-Processing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
	/**
	 * @fileoverview As a java script file that uses common on business, it has been defined about calendar-related functions.
	 * @author 
	 */
	/**
	 * @extends
	 * @class ESM_BKG_0034_06 : It defines business script that using screen for ESM_BKG_0034_06 creation.
	 */
	function ESM_BKG_0034_06() {
		this.setSheetObject=setSheetObject;
		this.loadPage=loadPage;
		this.initSheet=initSheet;
		this.doActionIBSheet=doActionIBSheet;
		this.validateForm=validateForm;
	}
	// Common global variables
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	 /**
	  * Registering IBSheet Object in to Array
	  * Afterwards, when other items need to be batch processed,it can add to the process that stores in to array
	  * The array is defined at upper part of source
	  */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
   /**
    * Sheet basic setting & initializing
    * onLoad Event HandlerImplementation of body tag
    * After loading screen in the browser, add function in pre-processing
    */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		// 페이지 로드 후 조회 되도록 해당 tab을 다시 호출하여 로드 
    	parent.loadTabPage(5);
	}
	/**
	 * Definition for sheet initial setting value, header
	 * param : sheetObj ==> sheet object, sheetNo ==> If the serial number ID tag attached to the sheet are many,
	 * adding 'Case' clause as a number of sheets, configures initial module.
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch(sheetNo) {
		case 1:
			with (sheetObj) {
		        var HeadTitle="Seq.|AMS File No.|Customs|Pieces Count|Pieces Count|IT No.|HUB|Consignee";
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		        var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        InitHeaders(headers, info);
		        var cols = [ {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"Seq",            Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cstms_clr_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pck_qty",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ams_pck_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ibd_trsp_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"hub_loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"cnee",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
		        InitColumns(cols);
		        SetSheetHeight(280);
		        SetEditable(0);
			}
			break;
		}
	}
	/**
	 * Handling process about Sheet
	 */ 
	function doActionIBSheet(sheetObj, formObj, sAction) {
		//sheetObj.ShowDebugMsg = false;
		switch (sAction) {
			case IBSEARCH: // 조회
				if (validateForm(sheetObj,formObj,sAction)) {
//					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH01;
 					sheetObj.DoSearch("ESM_BKG_0034_06GS.do", FormQueryString(formObj) );
//					ComOpenWait(false);
				}
				break;
		}
	}
	/**
	 * Handling validity verification process about screen form input value.
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // 조회
			if (formObj.bl_no.value == "") {
				return false;
			} else {
				return true;
			}
			break;
		}
	}
	/**
	 * searching when click tab
	 */
	function tabLoadSheet(strBlNo, strVvd) {
		var formObject=document.form;
		formObject.vvd.value=strVvd;
		if (formObject.bl_no.value != strBlNo) {
			formObject.bl_no.value=strBlNo;
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
		}
	}
	/**
	 * tab data initialization
	 */
	function tabClearSheet() {
		document.form.bl_no.value="";
		sheetObjects[0].RemoveAll();
	}
	/**
	 * tab activating processing
	 */
	var enableFlag=true;
	function tabEnableSheet(flag) {
		var formObject=document.form;
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
	}
