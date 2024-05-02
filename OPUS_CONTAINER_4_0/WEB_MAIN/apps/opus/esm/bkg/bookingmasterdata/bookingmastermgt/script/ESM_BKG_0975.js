/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0975.js
*@FileTitle  : Charge_Charge code inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// global variable
var sheetObjects=new Array();
var sheetCnt=0;
var prefix="sheet1_";
// Event handler processing by button click event */
document.onclick=processButtonClick;
function initControl() {
	var formObject=document.form;
//	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); 
//	axon_event.addListenerFormat('keydown', 'obj_keydown', formObject);
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
	if(ComGetObjValue(document.form.isPop) == 'Y') {
		eval('DIV_btn_Select').style.display='none';
	}
	initControl();
	initFocus();
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
	case 1: //sheet1 init
		with (sheetObj) {
	        var HeadTitle1="|Code|Description";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"radio",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"chg_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"chg_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"tax_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }];
	         
	        InitColumns(cols);
	
	        SetEditable(1);
	        SetCountPosition(0);
	        //no support[check again]CLT 			MultiSelection=false;
	        //no support[implemented common]CLT 			SelectHighLight=true;
	        //no support[implemented common]CLT 			SheetBackColor="#F8F8F8";
	        //no support[implemented common]CLT 			SelectBackColor="#ECF6F7";
	        SetFocusEditMode(0);
	        SetSheetHeight(420);
		}
		break;
	}
}
// Event handler processing by button name */
function processButtonClick() {
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
		case "btn_Select":
			var selrow=sheetObject.GetSelectRow();
			if (selrow > 0) {
				comPopupOK();
			}			
			break;
		case "btn_Close":
			ComClosePopup(); 
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
			bkg_error_ComShowMessage(e.message);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
* Dbl Click Event Handling
*/
function sheet1_OnDblClick(sheetObj, row, col, value) {
	if(ComGetObjValue(document.form.isPop) == 'Y') return;
	var selrow=sheetObj.GetSelectRow();
	if (selrow > 0) {
		comPopupOK();
	}
}

var iPageNo = 1;
function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
    doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
}
/**
 * Sheet1의 OnSearchEnd event handling
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
}
/**
 * initFocus handling 
 */
function initFocus() {
	var formObj=document.form;
	formObj.chg_cd.focus();
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
	sheetObj.ShowDebugMsg(false);
	var aryPrefix=new Array("sheet1_");
	switch (sAction) {
	case IBSEARCH: //Retrieve
		ComSetObjValue(formObj.f_cmd, SEARCH);
		ComSetObjValue(formObj.ipage, '1');
		sheetObj.DoSearch("ESM_BKG_0975GS.do", ''+"&"+ FormQueryString(formObj),{Append:false} );
		break;
	case IBSEARCHAPPEND:
		ComSetObjValue(formObj.ipage, PageNo);
		sheetObj.DoSearch("ESM_BKG_0975GS.do", ''+"&"+ FormQueryString(formObj),{Append:true} );
		break;
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
 * Debug alert 
 */
function bkg_error_alert(ex) {
	alert('[ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
}
/* Developer Work End */