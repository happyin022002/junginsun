/*=========================================================
 *Copyright(c) 2015 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0027.js
 *@FileTitle  : Basic for USA/CA Rail
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2015/08/21
=========================================================*/
/**
 * @fileoverview Defining scripts
 * @author author_name
 */
/**
 * @extends Trs
 * @class ESD_TRS_0027 : Basic rates of USA/CA Rail Vendors
 */
// General global variable
var sheetObjects = new Array();
var sheetCnt = 0;

var prefix = '';
document.onclick = processButtonClick;

function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_close":
				ComClosePopup();
				break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('TRS90384');
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * Register IBSheet Object with array
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Setting sheets and initialization Implementing the onLoad event handler of body tag Adding the preceding function after loading page
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	initControl();
}

/**
 * Loading the event of HTML Control <br>
 * {@link #loadPage} Initializing IBSheet Object <br>
 */
function initControl() {
}

function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
         case 1: 
             with(sheetObj) {
             var HeadTitle1="|Rail Company|Rail Company|AGMT No.|Rate|Rate";
             var HeadTitle2="|Rail Company|Rail Company|AGMT No.|Currency|Amount";
             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol: 4, ComboMaxHeight:200 } );
             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
             var headers = [ { Text:HeadTitle1, Align:"Center"},
                             { Text:HeadTitle2, Align:"Center"} ];
             InitHeaders(headers, info);
             var cols = [
                 {Type:"Status",   Hidden:1, Width:45,  Align:"Center", ColMerge:1, SaveName:"ibflag",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:0 },                                            
                 {Type:"Text",     Hidden:0, Width:80,  Align:"Left",   ColMerge:1, SaveName:"vndr_seq",               KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:6 },                                            
                 {Type:"Text",     Hidden:0, Width:300,  Align:"Left",   ColMerge:1, SaveName:"vndr_nm",                KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:6 },                                            
                 {Type:"Text",     Hidden:0, Width:100,  Align:"Left",   ColMerge:1, SaveName:"agmt_no",                KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:6 },
                 {Type:"Text",     Hidden:0, Width:100,  Align:"Center", ColMerge:1, SaveName:"curr_cd",                KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0},
                 {Type:"Float",    Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"trsp_rt",                KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:0, InsertEdit:0, EditLen:15 }
             ];
             InitColumns(cols);
             SetEditable(1);
             SetSheetHeight(180);
             SetRowHeight(30);
             SetCountPosition(0);
         }
         break;
    }
}

function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH:
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESD_TRS_0027GS.do", TrsFrmQryString(formObj));
			break;
	}
}

function sheet0_OnSearchEnd(sheetObj, code, errMsg) {
	if(code != 0) {
		return;
	}
}
