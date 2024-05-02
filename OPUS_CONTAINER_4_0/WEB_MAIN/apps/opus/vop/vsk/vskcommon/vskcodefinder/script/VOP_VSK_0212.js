/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : VOP_VSK_0212.js
*@FileTitle : P/F Type Selection Help 
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return;  
		switch (srcName) {
		case "btn_ok":
			var cnt=sheetObject1.RowCount();
			if (cnt > 0) {
				var pfSvcTpCd=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_pf_svc_tp_cd");
				ComPopUpReturnValue(pfSvcTpCd);
			}
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
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: // sheet1 init
	    with(sheetObj){
	      var HeadTitle="|Sequence|P/F Type||";
	      var prefix="sheet1_";
	
	      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Seq",       Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rownum",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pf_svc_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"slan_stnd_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_slan_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_slan_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
	      InitColumns(cols);
	      SetEditable(0);
	      SetSheetHeight(300);
		}
	    break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // Retrieve
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		formObj.f_cmd.value=COMMAND18;
		sheetObj.DoSearch("VOP_VSK_0212GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
		ComOpenWait(false);
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}
	return true;
}
/**
 * Return to Parent Screen
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {

	//window.returnValue=sheetObj.GetCellValue(Row, "sheet1_pf_svc_tp_cd");
	//alert( "1");
	ComPopUpReturnValue(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_pf_svc_tp_cd"));
	//alert("2" );
	
	//comPopupOK();
}
function sheet1_OnSearchEnd(sheetObj) {
	var dataRows=sheetObj.RowCount();
	for ( var i=sheetObj.HeaderRows(); i < dataRows + sheetObj.HeaderRows(); i++) {
		if ("Y" == sheetObj.GetCellValue(i, "sheet1_slan_stnd_flg")) {
			sheetObj.SetRowBackColor(i,"#FFFF80");
		}
	}
}
