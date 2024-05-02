/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : COM_COM_0440.js
*@FileTitle  : CENTER POPUP 
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
 * @class COM_COM_0440 : business script for COM_COM_0440
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
			//if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
				case "btn_OK":
            		comPopupOK();
            		break;
				case "btn_Close":
					self.close(); 
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
		//** Date Separator **/
		//DATE_SEPARATOR="-";
		var formObj=document.form;
        axon_event.addListenerFormat('keypress', 'keypressFormat', formObj);
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
		//axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    , formObj); 	//- handling code when OnBeforeDeactivate(blur) event
//		axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   , formObj);            //- handling code when OnBeforeActivate event in case of existing dataformat property
//	    axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj); 	//- handling code when onkeypress event in case of existing dataformat property
//	    axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);
	}
	//handling Axon event 2
/*	function obj_blur(){
	    ComChkObjValid(ComGetEvent());
		var src=ComGetEvent("name")
	}*/
//	function obj_focus(){
//	    ComClearSeparator(ComGetEvent());
//	}
//	function obj_keypress(){
//		var src=ComGetEvent("name")
//	    switch(ComGetEvent("dataformat")){
//			case "engup":
//				if(ComGetEvent("name")=="f_center"){
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
/*	function obj_onclick(){
		var src=ComGetEvent("name")
	}*/
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
        		style.height = 260;
        		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;
   	         	InitRowInfo( 1, 1, 5, 100);	         
   	         	InitColumnInfo(3, 0, 0, true);
   	         	
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
   	         InitHeadMode(false, true, true, false, false, false);
                
        		var HeadTitle1="|Center|Description";
        		InitHeadRow(0, HeadTitle1, true);
	              
	     		 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	              InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,  false,    "ibflag");
	              //InitDataProperty(0, cnt++ , dtCheckBox,       20,    daCenter,  false,      "radio", 				false,          "",         dfNone,      0,     true,        true);
	              //InitDataProperty(0, cnt++ , dtSeq,    		30,    daCenter,  false,      "seq", 				false,          "",         dfNone,      0,     true,        true);
	              InitDataProperty(0, cnt++ , dtData,       100,    daCenter,  false,      "ctr_erp_no", 				false,          "",         dfNone,      0,     false,        false);
	              InitDataProperty(0, cnt++ , dtData,       160,    daCenter,  false,      "ctr_desc", 				false,          "",         dfNone,      0,     false,        false);
	              CountFormat = "[SELECTDATAROW / TOTALROWS]"; 
		}
		    break;
		}
	}
	function doActionIBSheet(sheetObj, formObj, sAction) {
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		switch (sAction) {		
			case IBSEARCH: //retrieve
				formObj.f_cmd.value=SEARCH;			
				var sXml=sheetObj.GetSearchXml("COM_COM_0440GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|"); 
				if (arrXml.length > 0) {
					sheetObjects[0].LoadSearchXml(arrXml[0]);
				}
				break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		//sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH: //retrieve
				break;
		}
		return true;
	}
/*	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		for (var i=sheetObj.HeaderRows; i<= sheetObj.LastRow; i++){
			}
	}
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var sName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
	}*/
	/**
	 * Returning to Parent Screen
	 */
	function sheet1_OnDblClick(sheetObj, row, col, value) {
		var selrow = sheetObj.SelectRow;
		if (selrow > 0) {
		 comPopupOK();
		}
	}
/*	function sheet1_OnClick(sheetObj, Row, Col){
		window.returnValue=sheetObj.CellValue(sheetObj.SelectRow, 'ctr_erp_no');
	}
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}*/
