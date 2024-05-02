/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0088.js
*@FileTitle  : Return CY Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * HTML Control on the page  loaded dynamically  the event. <br>
 * {@ link # loadPage} function this function  call initializes the IBSheet Object. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects array  sequence number
 */
function initControl() {
	var formObject = document.form;
	// Axon Event Processing 1. Events catch (developers change)
	//axon_event.addListenerFormat('keypress',  'obj_KeyPress',    formObject); //- When typing the keyboard
	axon_event.addListenerForm ('keydown', 'ComKeyEnter', document.form);
}

// Common global variable
var sheetObjects = new Array();
var sheetCnt = 0;

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick() {
	/** ***  Tab ->two or more sheet : sheet  a variable assignment **** */
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		// ComDebug(srcName);
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
		case "btn_Select":
			comPopupOK();
			break;
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
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items  
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag 
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		// khlee- Preferences change the name of the function to start
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee- The final configuration functions added
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
 * setting sheet initial values and header 
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
    switch(sheetNo) {
        case 1:      //sheet1 init
            with(sheetObj){
                var HeadTitle1=" ||Yard|Name|Tel.|P.I.C";
                SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"radio",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"check",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"yd_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"phn_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"yd_pic_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                InitColumns(cols);
                SetEditable(1);
                SetSheetHeight(ComGetSheetHeight(sheetObj, 10))
        		}
            break;
	}
}
/**
 * Various functions related to IBSheet (views, stored, etc.)  handle. <br>
 * <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {form}
 *            formObj Form Object
 * @param {int}
 *            sAction Code(IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 
 *            CoObject.js)
 * @param {String}
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	// sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case IBSEARCH:
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH;
 			sheetObj.DoSearch("ESM_BKG_0088GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(""));
		}
		break;
	}
}
/**
 * handling process for input validation  <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {form}
 *            formObj  form Object
 * @param {ibsheet}
 *            sAction IBSheet Object
 * @param {String}
 *            value sheetObj input value
 * @return {boolean}
 * @see #ComChkValid
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
	}
	return true;
}
