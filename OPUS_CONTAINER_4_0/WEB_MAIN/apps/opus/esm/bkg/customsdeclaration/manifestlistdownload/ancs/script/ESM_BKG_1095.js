/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1095.jsp
*@FileTitle  : ANCS - Lane Add
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/01
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_BKG_1095 : business script for ESM_BKG_1095.
 */
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var state="";
// Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_Save":
			doActionIBSheet(sheetObject, formObject, COMMAND01);
			break;
		case "btn_Close":
			ComClosePopup(); 
			break;
		case "btn_RowAdd":
			doActionIBSheet(sheetObject, formObject, IBINSERT);
			break;
		case "btn_RowDelete":
			doActionIBSheet(sheetObject, formObject, IBDELETE);
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
 * @param sheet_obj IBSheet Object
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
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
 * registering initial event 
 */
function initControl() {
	//DATE_SEPARATOR="-";
	var formObject=document.form;
	//axon_event.addListenerForm('blur', 'obj_deactivate', formObject); // - focus in 
	//axon_event.addListenerFormat('focus', 'obj_activate', formObject); // - focus out 
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 * @param sheetObj
 * @param sheetNo 
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetId=sheetObj.id;
	switch (sheetId) {
	case "sheet1": // sheet1 init
	    with(sheetObj){
       
		      var HeadTitle1=" |Sel.|Lane|HRD_CDG_ID|HRD_CDG_ID_SEQ";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"attr_ctnt1",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3,	InputCaseSensitive:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hrd_cdg_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hrd_cdg_id_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 } ];
		       
		      InitColumns(cols);
		
		      SetEditable(1);
		      SetSheetHeight(288);
            }


		break;
	}
}
/**
 * handling sheet process
 * @param sheetObj Sheet
 * @param formObj
 * @param sAction
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBINSERT: 
	sheetObj.DataInsert(-1);
	break;
	case IBDELETE: 
	if (validateForm(sheetObj, formObj, sAction))
	{			
		var delrows=sheetObj.FindCheckedRow("del_chk");
		var arrRow=delrows.split("|");
		for ( var i=0; i < arrRow.length; i++) {
			sheetObj.SetRowHidden(arrRow[i],1);
			sheetObj.SetRowStatus(arrRow[i],"D");
		}	
	}	
	break;	
	case IBSEARCH: 
		formObj.f_cmd.value=SEARCH;
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
 		sheetObj.DoSearch("ESM_BKG_1095GS.do", FormQueryString(formObj) );
		ComOpenWait(false);
		break;
	case COMMAND01: 
		formObj.f_cmd.value=MULTI;
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		sheetObj.DoSave("ESM_BKG_1095GS.do", FormQueryString(formObj));
		ComOpenWait(false);
		break;
	}
}
/**
 * handling process for input validation
 * @param sheetObj Sheet
 * @param formObj
 * @param sAction
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBDELETE: 
		var vIsCheck=false;
		var vIsCheck=false;
		for ( var i=0; i <= sheetObjects[0].RowCount(); i++) {
			if (sheetObjects[0].GetCellValue(i, "del_chk") == 1) {
				vIsCheck=true;
				break;
			}
		}
		if (!vIsCheck) {
			ComShowCodeMessage('BKG00249', '');
			return false;
		}
		return true;
		
	break;
	}
}

//function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
//	var state = sheetObj.GetEtcData("TRANS_RESULT_KEY");
//	if (state == "S") {
//		doActionIBSheet(sheetObj, document.form, IBSEARCH);
//	}
//}