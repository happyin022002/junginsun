/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_PRD_0082.js
 *@FileTitle  : Product Catalog - Constraints
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/04/08
=========================================================*/
/* Common global variable */

var sheetObjects = new Array();
var sheetCnt = 0;

document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject1 = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName))
			return false;
		switch (srcName) {
			case "btn_close":
				ComClosePopup();
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
		doActionIBSheet(sheetObjects[i], document.form, IBSEARCH);
	}
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
            with(sheetObj){
                var HeadTitle1="SVC|Link / Location|Point of Port|Item|CNTR Type|Commodity Code|Remark|Office|By";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_use_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"rout",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"port_pnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"item",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
                             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                InitColumns(cols);
                SetEditable(0);
                SetCountPosition(0);
                SetWaitImageVisible(0);
                ComResizeSheet(sheetObj);
            }
            break;
    }
}
// handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH:
			if (validateForm(sheetObj, formObj, sAction))
				formObj.f_cmd.value = SEARCHLIST;
			if (sheetObj.id == "sheet1") {
				var sParam = "pctl_no=" + formObj.pctl_no.value + "&pop_mode=1&display=1,0,1,1,1&func=&" + PrdFQString(formObj);
				sheetObj.DoSearch("ESD_PRD_0082GS.do", sParam, { Sync : 2 });
			}
			break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
	}
	return true;
}
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var chkPnt = 0;
	for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
		if (sheetObj.GetCellValue(i, 'svc_use_flg') == 'N') {
			sheetObj.SetRowFontColor(i, "#FF0000");
		}
		if (sheetObj.GetCellValue(i, 'port_pnt_cd') != '') {
			if (sheetObj.GetCellValue(i, 'port_pnt_cd').length > 0) {
				chkPnt++;
			}
		}
	}
	if (chkPnt == 0) {
		sheetObj.SetColHidden(2, 1);
	}
}
