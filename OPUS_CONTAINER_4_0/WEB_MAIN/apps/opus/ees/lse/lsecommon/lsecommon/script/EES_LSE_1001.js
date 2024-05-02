/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_1001.js
*@FileTitle  : Lease Rental Charge & Account Mapping
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
/**
 * @extends
 * @class EES_LSE_1001 : business script for EES_LSE_1001
 */

var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;
		case "btn_save":
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;
		case "btn_add":
			doActionIBSheet(sheetObject1, formObject, IBINSERT);
			break;
		case "btn_del":
			doActionIBSheet(sheetObject1, formObject, REMOVE);
			break;
		case "btn_loadexcel" :
			sheetObject1.RemoveAll();
			sheetObject1.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",Append:false});
		break;
		case "btn_downexcel":
			if(sheetObject1.RowCount() < 1){//no data
        	     ComShowCodeMessage("COM132501");
    	    } else{
    	    	sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
    	    }
		break;	
		} // end switch
		tRoleApply();
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * initializing sheet<br>
 * implementing onLoad event handler in body tag<br>
 * adding first-served functions after loading screen.<br>
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	var sheetObject1=sheetObjects[0];
	var formObject=document.form;
	doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC01);
	doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC02);
	doActionIBSheet(sheetObject1, formObject, IBSEARCH);
	tRoleApply();
	
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
	}
	return true;
}

function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
		if (isExceedMaxRow(msg))return;
}


function tRoleApply() {
	var formObj=document.form;
	
	// ComBtnDisable("btn_save");
	// ComBtnDisable("btn_del");
	// ComBtnDisable("btn_add");
}
/**
 * registering IBSheet Object as list<br>
 * adding process for list in case of needing batch processing with other items
 * <br>
 * defining list on the top of source<br>
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * setting sheet initial values and header <br>
 * param : sheetObj, sheetNo <br>
 * adding case as numbers of counting sheets<br>
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1:
	    with(sheetObj){
		      if (location.hostname != "")
		      var HeadTitle="|Sel|Charge Type code|Lease Term Code|Account Code|Cost Code|Cost Code Full Name";
		      var headCount=ComCountHeadTitle(HeadTitle);
		      (headCount, 0, 0, true);
		      var prefix="sheet1_";
		
		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				             {Type:"CheckBox",  Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
				             {Type:"ComboEdit", Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"lse_rcv_chg_tp_cd", KeyField:1,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3, InputCaseSensitive:1 },
				             {Type:"ComboEdit", Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"lstm_cd",           KeyField:1,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, InputCaseSensitive:1 },
				             {Type:"Text",      Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"acct_cd",           KeyField:0,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
				             {Type:"Text",     	Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"cost_cd",           KeyField:0,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
				             {Type:"Text",      Hidden:0, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"lgs_cost_full_nm",  KeyField:0,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 } ];
				       
		      InitColumns(cols);		
		      SetColProperty(0 , prefix+"acct_cd" , {AcceptKeys:"N"});
		      SetColProperty(0 , prefix+"cost_cd" , {AcceptKeys:"E", InputCaseSensitive:1});
		      SetEditable(1);
		      //SetSheetHeight(362);
		      ComResizeSheet(sheetObj);
            }
		break;
	}
}
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	var prefix="sheet1_";
	var form=document.form;
	var sheetObject1=sheetObjects[0];
	switch (sAction) {
	case IBSEARCH:
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		formObj.f_cmd.value=SEARCH;
		sheetObj.DoSearch("EES_LSE_1001GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
		ComOpenWait(false);
		break;
	case IBSEARCH_ASYNC01:	//Serching Charge Type Code
		formObj.f_cmd.value=SEARCH01;
		var sXml=sheetObj.GetSearchData("EES_LSE_1001GS.do", FormQueryString(formObj));		
		var rcvChgTpCd=ComXml2ComboString(sXml, "lse_rcv_chg_tp_cd", "lse_rcv_chg_tp_cd");
		sheetObj.SetColProperty(0, prefix+"lse_rcv_chg_tp_cd", {ComboText:"|"+rcvChgTpCd[0], ComboCode:"|"+rcvChgTpCd[0]} );
		break;
	case IBSEARCH_ASYNC02:	//Serching Lease Term Code
		formObj.f_cmd.value=SEARCH02;
		var sXml=sheetObj.GetSearchData("EES_LSE_1001GS.do", FormQueryString(formObj));
		var termCd=ComXml2ComboString(sXml, "lstm_cd", "lstm_cd");
		sheetObj.SetColProperty(0, prefix+"lstm_cd", {ComboText:"|"+termCd[0], ComboCode:"|"+termCd[0]} );
		break;
	case IBSAVE:
		if (!validateForm(sheetObject1, formObj, sAction)) {
			return false;
		}
		sheetObj.SetWaitImageVisible(0);
		formObj.f_cmd.value=MULTI;
		if (sheetObj.DoSave("EES_LSE_1001GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"))) {
			ComOpenWait(true);
			ComShowCodeMessage("COM130102", 'Lease Rental Charge & Account Mapping');
			doActionIBSheet(sheetObj, document.form, IBSEARCH);
		}
		ComOpenWait(false);
		sheetObj.SetWaitImageVisible(1);		
		break;
	case IBINSERT:
		sheetObj.DataInsert();
		break;
	case REMOVE:
		ComRowHideDelete(sheetObject1, prefix + "del_chk");
		break;
	}
}
/**
 * duplicate check
 */
function sheet1_OnChange(sheetObj, Row, Col) {
	var sheetObj=sheetObjects[0];
	var prefix="sheet1_";
	var in1=sheetObj.SaveNameCol(prefix + "lse_rcv_chg_tp_cd");
	var in2=sheetObj.SaveNameCol(prefix + "lstm_cd");
	if (Row > 0) {
		if (Col == in1 || Col == in2) {
			var v1=sheetObj.GetCellValue(Row, in1);
			var v2=sheetObj.GetCellValue(Row, in2);
			if (v1 != '' && v2 != '') {
				for (i=1; i <= sheetObj.RowCount(); i++) {
					if (i == Row)
						continue;
					else {
						var s1=sheetObj.GetCellValue(i, in1);
						var s2=sheetObj.GetCellValue(i, in2);
						if (v1 == s1 && v2 == s2) {
							ComShowCodeMessage('COM12115', 'Lease Rental Charge & Account Mapping');
							sheetObj.SetCellValue(Row, Col,'',0);
							sheetObj.SelectCell(Row, Col, true);
							break;
						}
					}
				}
			}
		}
	}
}
function sheet1_OnLoadFinish(sheetObj) {
	sheetObj.SetWaitImageVisible(0);
	for (i=0; i < sheetObjects.length; i++) {
		doActionIBSheet(sheetObjects[i], document.form, IBSEARCH);
	}
	doActionIBSheet(sheetObj, document.form, IBCLEAR);
	sheetObj.SetWaitImageVisible(1);
}
