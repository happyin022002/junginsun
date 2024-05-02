/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_1135.js
*@FileTitle : ESM_BKG_1135
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/22
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// 공통전역변수
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var state="";
//Event handler processing by button click event  */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
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
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	DATE_SEPARATOR="-";
	var formObject=document.form;
	axon_event.addListenerForm('blur', 'obj_deactivate', formObject); // - focus
	axon_event.addListenerFormat('focus', 'obj_activate', formObject); // - focus
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
  * setting sheet initial values and header
  * param : sheetObj, sheetNo
  * adding case as numbers of counting sheets
  */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetId=sheetObj.id;
	switch (sheetId) {
	case "sheet1": // sheet1 init
	    with(sheetObj){

			var HeadTitle1=" |Sel.|Lane|HRD_CDG_ID|HRD_CDG_ID_SEQ";
			var headCount=ComCountHeadTitle(HeadTitle1);
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"attr_ctnt1",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hrd_cdg_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hrd_cdg_id_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 } ];
       
			InitColumns(cols);

			SetColProperty(0 ,"attr_ctnt1" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
      
			SetEditable(1);
			SetSheetHeight(290);
      	}
		break;
	}
}

/*handling sheet process
 * 
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBINSERT: // row insert
		sheetObj.DataInsert(-1);
		break;
	case IBDELETE: //row delete
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
	case IBSEARCH: // search
		formObj.f_cmd.value=SEARCH;
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
 		sheetObj.DoSearch("ESM_BKG_1135GS.do", FormQueryString(formObj) );
		ComOpenWait(false);
		break;
	case COMMAND01: // save
		//alert("test");
		formObj.f_cmd.value=MULTI;
		sheetObj.SetWaitImageVisible(0);
		sheetObj.DoSave("ESM_BKG_1135GS.do", FormQueryString(formObj));
		break;
	}
}

function sheet1_OnSaveEnd(Code, Msg, StCode, StMsg) { 
	ComOpenWait(false);
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	
}

/**
* handling process for input validation
*/
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBDELETE: // row delete
		var vIsCheck=false;
		var vIsCheck=false;
		for ( var i=0; i <= sheetObjects[0].RowCount(); i++) {
			if (sheetObjects[0].GetCellValue(i, "del_chk") == 1) {
				vIsCheck=true;
				break;
			}
		}
		//alert(vIsCheck);
		if (!vIsCheck) {
			ComShowCodeMessage('BKG00249', '');
			return false;
		}
		return true;
		break;
	}
}
