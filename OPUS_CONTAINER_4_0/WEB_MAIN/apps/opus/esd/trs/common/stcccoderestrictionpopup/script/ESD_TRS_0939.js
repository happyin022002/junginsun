/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0939.js
 *@FileTitle  : STCC Code Restriction(공통 Popup)
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/04/08
=========================================================*/
var ipageNo = 1;
var sheetObjects = new Array();
var comboObjects = new Array();
var sheetCnt = 0;
var selectVal;
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
		case "btn_retrieve": {
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
		}
		case "btn_new": {
			sheetObject.RemoveAll();
			formObject.reset();
			break;
		}
		case "btn_close": {
			ComClosePopup();
			break;
		}
		case "btn_ok": {
			comPopupOK();
			break;
		}
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}
/**
 * setSheetObject
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * registering IBCombo Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}
/**
 * loadPage
 */
function loadPage() {
	for ( var i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	for ( var i = 0; i < comboObjects.length; i++) {
		initCombo(comboObjects[i], i + 1);
	}

	initControl();
}

/**
 * initCombo
 * 
 * @param comboObj
 * @param comboNo
 */
function initCombo(comboObj, comboNo) {
	var cnt = 0;
	switch (comboNo) {
	case 1:
		comboObj.RemoveAll();
		with (comboObj) {
			var valueArray = comboStccRstrFlgCode.split("|");
			var textArray = comboStccRstrFlgText.split("|");
			for ( var i = 0; i < valueArray.length; i++) {
				InsertItem(cnt++, textArray[i], valueArray[i]);
			}
			SetSelectIndex("0", true);
		}
		break;
	}
}

/**
 * initControl
 */
function initControl() {
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');// Enter key
}

/**
 * Handling enter key
 */
function enter_keypress() {
	doActionIBSheet(sheetObject, formObject, IBSEARCH);
}

/**
 * initSheet
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1: 
        	with(sheetObj){
            	var HeadTitle="||Code|Description|Restricted" ;
            	SetConfig( { SearchMode:2, MergeSheet:5, Page:200, DataRowMerge:1 } );
            	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1, HeaderCheck:0 };
            	var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	InitHeaders(headers, info);
            	var cols = [ {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"radio",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"checkbox",  		 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"stcc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0, Width:400,  Align:"left",    ColMerge:1,   SaveName:"stcc_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"stcc_rstr_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }
            	           ]
            	InitColumns(cols);
            	SetSheetHeight(ComGetSheetHeight(sheetObj, 12));
            	SetCountFormat("[SELECTDATAROW / TOTALROWS]");
        	}
        	break;
    }
}

/**
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @param a
 * @param PageNo
 */
function doActionIBSheet(sheetObj, formObj, sAction, a, PageNo) {
	switch (sAction) {
	case IBSEARCH:
		formObj.f_cmd.value = SEARCH;
		selectVal = FormQueryString(formObj)
		iPageNo = 1;
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		sheetObj.DoSearch("ESD_TRS_0939GS.do", selectVal);
		break;
	case IBSEARCHAPPEND:
		formObj.f_cmd.value = SEARCH;
		ComOpenWait(true);
		sheetObj.DoSearch("ESD_TRS_0939GS.do", selectVal + "&iPage=" + iPageNo, { Append : true });
		break;
	}
}

function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
	if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) {
		return;
	}
	doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
	ComOpenWait(false);
}
