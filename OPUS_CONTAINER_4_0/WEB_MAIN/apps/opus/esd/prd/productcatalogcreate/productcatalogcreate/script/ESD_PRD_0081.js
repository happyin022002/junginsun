/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_PRD_0081.js
 *@FileTitle  : Product Catalog - Full Route
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/15
=========================================================*/
// Common global variable
var sheetObjects = new Array();
var sheetCnt = 0;
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject1 = sheetObjects[0];
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
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * registering IBSheet Object as list adding process for list in case of needing
 * batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * initializing sheet implementing onLoad event handler in body tag adding
 * first-served functions after loading screen.
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetObj.id) {
        case "sheet1": 
            with(sheetObj) {
	             var HeadTitle1="SVC(Y/N)|Point|Node/Link|Mode|Arrival|Departure|Transit|Carrier||||||";
	             var headCount=ComCountHeadTitle(HeadTitle1);
	             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	             InitHeaders(headers, info);
	             var cols = [ 
	                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnst",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"loc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"node_link",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"arr_time",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"dep_time",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"fmt_tz_dwll_tm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"org_nod_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"dest_nod_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"nod_nm_tool_tip",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"rout_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"nod_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"lnk_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	             InitColumns(cols);
	             ComResizeSheet(sheetObj);
            }
            break;
    }
}

function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		formObj.f_cmd.value = SEARCHLIST;
		sheetObj.DoSearch("ESD_PRD_0081GS.do?pctl_no="+ formObj.pctl_no.value + "&pop_mode=1&display=1,0,1,1,1&func=", PrdFQString(formObj), { Sync : 2 });
		break;
	}
}