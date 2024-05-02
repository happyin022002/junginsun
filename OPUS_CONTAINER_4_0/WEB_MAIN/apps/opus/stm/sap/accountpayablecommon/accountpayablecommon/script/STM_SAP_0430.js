/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0430.js
*@FileTitle  : Region Popup 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
              MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
              OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class STM_SAP_0430 : business script for STM_SAP_0430
 */
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();        
	var comboCnt=0;
	var gCurRow=0;
	var prefix="sheet1_";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		/***** setting sheet object *****/
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
				case "btn_ok":
					if(sheetObject1.RowCount()== 0){
						ComClosePopup(); 
					}else{
						comPopupOK();
					}
					break;
				case "btn_close":
					ComClosePopup(); 
					break;	
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowCodeMessage('SAP00001');
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
	 * registering IBCombo Object as list
	 * param : combo_obj
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */ 
	function setComboObject(combo_obj) {  
	    comboObjects[comboCnt++]=combo_obj;  
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
	}
	/**
	 * loading HTML Control event <br>
	 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sequence number in sheetObjects array
	 **/
	function initControl() {
		DATE_SEPARATOR="-";
		var formObj=document.form;
		axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    , formObj);
	//	  axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   , formObj);
	//    axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj);
	//    axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);
	}
	//handling Axon event 2
	function obj_blur(){
	    ComChkObjValid(ComGetEvent());
		var src=ComGetEvent("name")
	}
//	function obj_focus(){
//	    ComClearSeparator(ComGetEvent());
//	}
//	function obj_keypress(){
//		var src=ComGetEvent("name")
//	    switch(ComGetEvent().dataformat){
//			case "engup":
//				if(ComGetEvent("name")=="lu_cd"){
//					if(event.keyCode!=32){ // null
//						ComKeyOnlyAlphabet('uppernum');
//					}
//				}else{
//					ComKeyOnlyAlphabet('uppernum');
//				}
//		    break;
//	    }
//	}
//	function form_keyup(){
//		ComKeyEnter('lengthnextfocus');
//	}
	function obj_onclick(){
		var src=ComGetEvent("name")
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;	
		switch (sheetNo) {
		case 1: //t1sheet1 init
		    with(sheetObj){
			      var HeadTitle1="|Region|Description";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"lu_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"lu_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetSheetHeight(220);
			      //resizeSheet();
	            }
		    break;
		}
	}
	//handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		switch (sAction) {		
			case IBSEARCH: //retrieve
				formObj.f_cmd.value=SEARCH;			
				var sXml=sheetObj.GetSearchData("STM_SAP_0430GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml,{Sync:0} );
				break;
			case COMMAND01:     // select 버튼 클릭시 처리
		        var selrow=sheetObj.GetSelectRow();
		        if ( selrow > 0 )
		        {
					 comPopupOK();      // lu_cd, lu_desc 호출자에게 매개변수값 전달.
		        }
			break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH: //retrieve
				break;
		}
		return true;
	}
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		for (var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++){
			}
	}
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var sName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
	}
	function sheet1_OnDblClick(sheetObj, Row, Col) {
		 comPopupOK();
	}
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}
	