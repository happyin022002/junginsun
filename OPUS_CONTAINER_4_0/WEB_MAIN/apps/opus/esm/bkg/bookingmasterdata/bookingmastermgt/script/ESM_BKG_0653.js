/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0653.js
*@FileTitle  : Package Table
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
           MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
           Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	// public variable
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Event handler processing by button click event */
	document.onclick = processButtonClick;
	
	// Event handler processing by button name */
	function processButtonClick() {
		/***** If sheets are more than 2 in one tab, use additional sheet variables *****/
		var sheetObject=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;
			case "btn_select":
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
		initControl();
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
	}
	/**
	 * load HTML Control event on the page <br>
	 * {@link #loadPage}call the function and init IBSheet Object <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {int}
	 *            sheetNo sheetObjects 
	 */
	function initControl() {
		var formObject=document.form;
		// Axon Event process1 Event catch(Develoer can change)
		//axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- in case of keyboard input
//		axon_event.addListenerForm('keydown', 'ComKeyEnter', formObject);
		axon_event.addListenerForm  ('keypress', 'obj_Change',formObject);
		if (formObject.cmdt_cd.value != ""){
			formObject.rdo_search_type[0].checked=true;
		}else if (formObject.rep_cmdt_cd.value != ""){
			formObject.rdo_search_type[1].checked=true;
		}else{
			formObject.rdo_search_type[0].checked=true;
		}
	}
	/**
	 * setting sheet initial values and header
	 * 
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
		case "sheet1": //sheet1 init
            with(sheetObj){
                var HeadTitle="|Sel.|No|Code|Description|Rep. Commodity|Rep. Commodity|REP_IMDG_LVL_CD";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [ {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"radio",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"check",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:440,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:80 },
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rep_cmdt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
                             {Type:"Text",      Hidden:0,  Width:55,   Align:"Left",    ColMerge:0,   SaveName:"rep_cmdt_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
                             {Type:"Text",      Hidden:1, Width:55,   Align:"Left",    ColMerge:0,   SaveName:"rep_imdg_lvl_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 } ];
                
                InitColumns(cols);
                SetWaitImageVisible(0);
                SetEditable(1);
//                SetSheetHeight(290);
                resizeSheet();
            }
            

			break;
		}
	}
	
	function resizeSheet(){
   	         ComResizeSheet(sheetObjects[0]);
   }
	//handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		switch (sAction) {
			case IBSEARCH:
				ComOpenWait(true);
				if (validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value=SEARCH;
 					sheetObj.DoSearch("ESM_BKG_0653GS.do", FormQueryString(formObj )+ "&" + ComGetPrefixParam(""));
				}
				break;
			case IBCLEAR:
//				ComOpenWait(true);
				if (validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value=SEARCH;
 					sheetObj.DoSearch("ESM_BKG_0653GS.do", FormQueryString(formObj )+ "&" + ComGetPrefixParam(""));
				}
				break;	
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
			if (cmdt_cd.value == "" && rep_cmdt_cd.value == "" && cmdt_nm.value == ""){
				switch (sAction) {
					case IBCLEAR:
						return false;
						break;
					case IBSEARCH:
						return true;
						break;
				}
			}
		}
		return true;
	}
	function obj_Change(){
		var formObj=document.form;    	
	    switch (ComGetEvent("name")) {
	    	case "cmdt_cd":
	    		formObj.rdo_search_type[0].checked=true;
					break;
	    	case "rep_cmdt_cd":
	    		formObj.rdo_search_type[1].checked=true;
					break;
	    	case "cmdt_nm":
	    		formObj.rdo_search_type[2].checked=true;
					break;		
				default:
					break;
	    }
	}
	
	function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
     	ComOpenWait(false);
    }