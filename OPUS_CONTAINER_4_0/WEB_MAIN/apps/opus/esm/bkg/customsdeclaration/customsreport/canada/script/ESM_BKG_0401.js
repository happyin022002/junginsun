/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0401.js
*@FileTitle  : Customer Code Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

var tabObjects=new Array();
var tabCnt=0;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * Event handler processing by button name
 */
function processButtonClick() {
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, SEARCH);
			break;
		case "btn_New":
			formObject.reset();
			sheetObject.RemoveAll();
			formObject.attr_ctnt1.focus();
			break;
		case "btn_Save":
			doActionIBSheet(sheetObjects[0], document.form, MODIFY);
			break;
		case "btn_Delete":
			doActionIBSheet(sheetObjects[0], document.form, REMOVE);
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComFuncErrMsg(e);
		} else {
			ComFuncErrMsg(e);
		}
	}
}
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param sheet_obj IBSheet Object
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
//	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
//	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
//  axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListener("keydown","ComKeyEnter", "attr_ctnt1");
	
	document.form.attr_ctnt1.focus();
	doActionIBSheet(sheetObjects[0], document.form, SEARCH);
}
 /**
  * setting sheet initial values and header
  * @param sheetObj
  * @param sheetNo
  * @return
  */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": //sheet1 init
		with(sheetObj){
			var HeadTitle1="flag|id|seq|ctnt1|ctnt2";
			var headCount=ComCountHeadTitle(HeadTitle1);
	
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
	
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"hrd_cdg_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"hrd_cdg_id_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
			InitColumns(cols);
	
			SetEditable(1);
			SetSheetHeight(200);
        }
		break;
	}
}
/**
* handling sheet process <br>
* 
* @param sheetObj
* @param formObj
* @param sAction 
* @return 
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case SEARCH: //Retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			var sXml=sheetObj.GetSearchData("ESM_BKG_0401GS.do", FormQueryString(formObj));
			if (ComBkgErrMessage(sheetObj, sXml)) {
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
				formObj.frm_attr_ctnt2.focus();
			} else {
				formObj.attr_ctnt1.value="";
				formObj.frm_attr_ctnt2.value="";
				formObj.attr_ctnt1.focus();
			}
			ComOpenWait(false);
		}
		break;
	case MODIFY: //Save
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=MODIFY;
			IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
			if (sheetObj.GetCellValue(1, "hrd_cdg_id_seq") == "") {
				sheetObj.SetCellValue(1, "ibflag","I",0);
			} else {
				if (!sheetObj.IsDataModified()) {
					ComShowCodeMessage('BKG00743');
					return;
				}
				sheetObj.SetRowStatus(1,"U");
			}
			if (ComShowCodeConfirm("BKG00350")) {
				ComOpenWait(true);
				sheetObj.SetCellValue(1, "attr_ctnt1",formObj.attr_ctnt1.value,0);
				var param=ComGetSaveString(sheetObj) + "&f_cmd=" + MODIFY;
				var sXml=sheetObj.GetSaveData("ESM_BKG_0401GS.do", param);
				sheetObj.LoadSaveData(sXml);
				if (ComBkgErrMessage(sheetObj, sXml)) {
					doActionIBSheet(sheetObj, formObj, SEARCH)
				}
				ComOpenWait(false);
			}
		}
		break;
	case REMOVE: //Save
		if (validateForm(sheetObj, formObj, sAction)) {
			if (ComShowCodeConfirm("BKG00592")) {
				ComOpenWait(true);
				sheetObj.SetRowStatus(1,"U");
				sheetObj.SetCellValue(1, "attr_ctnt1",formObj.attr_ctnt1.value,0);
				sheetObj.SetCellValue(1, "attr_ctnt2","",0);
				var param=ComGetSaveString(sheetObj) + "&f_cmd=" + REMOVE;
				var sXml=sheetObj.GetSaveData("ESM_BKG_0401GS.do", param);
				sheetObj.LoadSaveData(sXml);
				formObj.reset();
				ComOpenWait(false);
			}
		}
		break;
	}
}
/**
* handling process for input validation <br>
* @param sheetObj
* @param formObj
* @param sAction
* @return boolean
*/
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case SEARCH:
		if (!ComChkValid(formObj))
			return false;
		break;
	case MODIFY:
	case REMOVE:
		if (sheetObj.RowCount()!= 1) {
			ComShowCodeMessage('BKG00395');
			return false;
		}
		break;
	}
	return true;
}
/**
 * process when input retrieve keyword
 */
function obj_KeyUp() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	if (srcName == "attr_ctnt1") {
		/*if (event.keyCode == 13) {
			ComKeyEnter();
		}*/
	} else if (srcName == "frm_attr_ctnt2") {
		fncTextCnt(5, 55, document.form.frm_attr_ctnt2)
	}
}
/**
 * limit character of text box
 */
function obj_KeyDown() {
	var srcName=ComGetEvent("name");
	if (srcName == "frm_attr_ctnt2") {
		fncTextCnt(5, 55, document.form.frm_attr_ctnt2)
	}
}
/**
 * limit character of text box
 * @param maxRow
 * @param maxCol
 * @param colObj
 */
function fncTextCnt(maxRow, maxCol, colObj) {
	var formObj=document.form;
	var arrRows=colObj.value.split("\n");
	var sEventValue=window.event.srcElement.getAttribute("value");
	var sStart=arrRows.length - 1;
	for ( var i=sStart; i < arrRows.length; i++) {
		var sCol=arrRows[i];
		for ( var j=0; j < sCol.length; j++) {
			if (j == maxCol - 1) {
				colObj.value=colObj.value + "\n";
				sStart++;
			}
		}
	}
	if (sStart == maxRow && arrRows.length == maxRow) {
		var sCol=arrRows[maxRow - 1];
		if (sCol.length > maxCol) {
			colObj.value=sEventValue.substring(0, sEventValue.length - 1)
		}
	}
	if (arrRows.length > maxRow) {
		var txt='';
		for ( var i=0; i < maxRow; i++) {
			if (i == (maxRow - 1)) {
				txt += arrRows[i].substring(0, arrRows[i].length - 1);
			} else {
				txt += arrRows[i];
			}
		}
		colObj.value=txt;
	}
}
