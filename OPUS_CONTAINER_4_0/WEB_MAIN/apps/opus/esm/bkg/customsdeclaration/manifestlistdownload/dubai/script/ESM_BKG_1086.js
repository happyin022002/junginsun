/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1086.js
*@FileTitle  : US Wharfage Exception Keyword
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// Common global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * Event handler processing by button name
 */
function processButtonClick() {
	/* */
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_RowAdd":
			sheetObject.DataInsert(-1);
			sheetObject.SetCellValue(sheetObject.LastRow(), "cnt_cd","AE",0);
			sheetObject.SetCellValue(sheetObject.LastRow(), "cstms_div_id","DUBAI_PCK_CD",0);
			break;
		case "btn_RowDelete":
			if (sheetObject.RowCount()> 0) {
				var delCnt=0;
				for ( var i=1; i < sheetObject.RowCount()+ 1; i++) {
						if (sheetObject.GetCellValue(i, "chk") == "1") {
						if (sheetObject.GetCellValue(i, "delt_flg") != "") {
							sheetObject.SetCellValue(i, "ibflag","D",0);
							sheetObject.SetRowHidden(i,1);
						} else {
							sheetObject.RowDelete(i, false);
							i--;
						}
						delCnt++;
					}
				}
				if (delCnt == 0) {
					ComShowCodeMessage('BKG00714');
					return;
				}
			}
			break;
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, SEARCH);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject, formObject, MULTI);
			break;
		case "btn_Close":
			ComClosePopup(); 
			break;
		case "btn_Select":
			if (sheetObject.RowCount()== 0) {
				ComShowCodeMessage("BKG00889");
				return;
			}
			sheet1_OnDblClick(sheetObject, sheetObject.GetSelectRow(), 2);
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
	sheetObjects[0].SetWaitImageVisible(0);
	//axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	doActionIBSheet(sheetObjects[0], document.form, SEARCH);
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
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": //sheet1 init
	    with(sheetObj){
	      var HeadTitle1="|Sel.|Dubai PKG TP|Description|Opus PKG TP||||";
	      var headCount=ComCountHeadTitle(HeadTitle1);
	
	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"attr_ctnt1",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3, AcceptKeys:"E" , InputCaseSensitive:1 },
	             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"attr_ctnt2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000, AcceptKeys:"E|[\" \"]" , InputCaseSensitive:1},
	             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"attr_ctnt3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E" , InputCaseSensitive:1},
	             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"delt_flg" },
	             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd" },
	             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"cstms_div_id" },
	             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"cstms_div_id_seq" } ];
	       
	      InitColumns(cols);
	
	      SetEditable(1);
	      SetCountPosition(0);
	      SetSheetHeight(242);
		}
	    break;
	}
}
/**
 * handling process for Sheet
 * @param sheetObj Sheet
 * @param formObj 
 * @param sAction 
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	formObj.f_cmd.value=sAction;
	switch (sAction) {
	case SEARCH: //Retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true,true);
			sheetObj.DoSearch("ESM_BKG_1086GS.do", FormQueryString(formObj) );
			ComOpenWait(false);
		}
		break;
	case MULTI: //Save
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true,true);
//parameter changed[check again]CLT 			
			var sXml=sheetObj.GetSaveData("ESM_BKG_1086GS.do", sheetObj.GetSaveString() + "&f_cmd=" + MULTI);
			if (ComBkgErrMessage(sheetObj, sXml)) {
				sheetObj.LoadSaveData(sXml);
				sheetObj.CheckAll("chk",0);
				doActionIBSheet(sheetObj, formObj, SEARCH)
			}
			ComOpenWait(false);
		}
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
	case SEARCH: //retrieve
		// 
		if (!ComChkValid(formObj))
			return false;
		break;
	case MULTI:
		if (sheetObj.GetSaveString() == "") {
//			ComShowCodeMessage("BKG95005");
			return false;
		}
		break;
	}
	return true;
}
/**
 * 
 * @param sheet
 * @param Row
 * @param Col
 * @param CellX
 * @param CellY
 * @param CellW
 * @param CellH
 * @return
 */
function sheet1_OnDblClick(sheetOjb, Row, Col) {
	if (Col == 2) {
		
		window.returnValue=sheetOjb.GetCellValue(Row, "attr_ctnt1");
		if(parent) {
			var _func_name = parent.document.form.calllback.value;
			eval('parent.'+_func_name+'("'+window.returnValue+'")');							
		}  		
		ComClosePopup(); 
	}
}
