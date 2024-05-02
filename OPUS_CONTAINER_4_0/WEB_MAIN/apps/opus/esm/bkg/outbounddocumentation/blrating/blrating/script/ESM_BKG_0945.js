/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0945.js
*@FileTitle  : Exchange Rate
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
/****************************************************************************************
  Event Code: 	[Initializing]INIT=0; [Insert]ADD=1; [Retrieve]SEARCH=2; [List retrieve]SEARCHLIST=3;
				[Modify]MODIFY=4; [Remove]REMOVE=5; [List remove]REMOVELIST=6 [Multi process]MULTI=7
				[Constant]  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class esm_bkg_0945 : Defining logic script for esm_bkg_0945 screen
 */
/* Global Variables */
var sheetObjects=new Array();
var sheetCnt=0;
var prefix1="sheet1_";
var prefix2="sheet2_";
var prefix3="sheet3_";
var prefix4="sheet4_";
var prefix5="sheet5_";
/* Event handler defined process to button click event */
document.onclick=processButtonClick;
/**
 * Initializing sheet
 * To implement onLoad event of body tag
 * Add functionality to after loading screen.
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		//Setting startup environment. Change the name of the function
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//Setting final environment.
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[4], document.form, IBSEARCH);
}
/* Event handler is branch processing by name of button */
function processButtonClick() {
	/***** Assignment sheet in case of over 2 by tab****/
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
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
 * Initializing sheet. Defining header
 * param : sheetObj ==> sheet object, sheetNo ==> sheet No.
 * Composition a initial module in case of multi sheet
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": // sheet1 init
	    with(sheetObj){
			var HeadTitle1="|CURR|Exchange Rate|Exchange Rate|POL|VVD|ETD";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"Status" },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },			     		
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"inv_xch_rt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"l_curr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vps_port_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"vsl",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:98,   Align:"Center",  ColMerge:1,   SaveName:"vps_etd_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
   
			
				 
			InitColumns(cols);
			SetSheetHeight(122);
			SetEditable(1);
			SetCountPosition(0);
    	}
		break;
	case "sheet2": // sheet2 init
	    with(sheetObj){
			var HeadTitle1="|CURR|Exchange Rate|Exchange Rate|POD|VVD|ETD";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"Status" },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"inv_xch_rt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"l_curr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vps_port_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"vsl",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:98,   Align:"Center",  ColMerge:1,   SaveName:"vps_etd_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
   
			InitColumns(cols);
			SetSheetHeight(122);
			SetEditable(1);
			SetCountPosition(0);
        }
		break;
	case "sheet3": // sheet2 init
	    with(sheetObj){
			var HeadTitle1="|CURR|Exchange Rate|Exchange Rate|POL|VVD|ETD";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"Status" },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"inv_xch_rt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"l_curr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vps_port_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"vsl",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:98,   Align:"Center",  ColMerge:1,   SaveName:"vps_etd_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
   
			InitColumns(cols);
			SetSheetHeight(122);
			SetEditable(1);
			SetCountPosition(0);
        }
		break;
	case "sheet4": // sheet2 init
	    with(sheetObj){
			var HeadTitle1="|CURR|Exchange Rate|Exchange Rate|POD|VVD|ETD";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"Status" },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"inv_xch_rt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"l_curr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vps_port_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"vsl",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:98,   Align:"Center",  ColMerge:1,   SaveName:"vps_etd_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
   
			InitColumns(cols);
			SetSheetHeight(122);
			SetEditable(1);
			SetCountPosition(0);
        }
		break;
	case "sheet5": //sheet1 init
	    with(sheetObj){
			var HeadTitle="";

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"type" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_no" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"curr_cd" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"l_curr_cd" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"inv_xch_rt" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"vps_port_cd" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"vsl" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"vps_etd_dt" } ];
   
			InitColumns(cols);
			SetSheetHeight(225);
			SetEditable(1);
			SetCountPosition(0);
        }
		break;
	}
}
/* Processing Sheet */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	var aryPrefix=new Array("");
	switch (sAction) {
	case IBSEARCH: //retrieve
		if (validateForm(sheetObj, formObj, sAction))
			//1.inputting parameter or setting selected value before retrieve	
			ComSetObjValue(formObj.f_cmd, SEARCH);
		// 2.retrieving by retrieve condition
		sheetObj.DoSearch("ESM_BKG_0945GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix) );
		break;
	}
}
/**
	 * Processing function in case of error to result of retrieve
	 * Defined by DataSheetObject.prototype.event_OnSearchEnd
	 */
function sheet5_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj=document.form;
	var sheetObjTarget ;
	var cnt=sheetObj.GetTotalRows();
	if (cnt == 0)
		return;
	try {
		
		
		for (i=1; i <= cnt; i++) {
			var type=sheetObj.GetCellValue(i, "type");
			if('p_' == type){
				sheetObjTarget=sheetObjects[0];
			}else if('c_' == type){
				sheetObjTarget=sheetObjects[1];
			}else if('tp_' == type){
				sheetObjTarget=sheetObjects[2];
			}else if('cp_' == type){
				sheetObjTarget=sheetObjects[3];
			}
			 var nRow=sheetObjTarget.DataInsert(0);			
			
			sheetObjTarget.SetCellValue(nRow, "curr_cd",sheetObj.GetCellValue(i, "curr_cd"));			
			sheetObjTarget.SetCellValue(nRow, "inv_xch_rt",sheetObj.GetCellValue(i, "inv_xch_rt"));
			sheetObjTarget.SetCellValue(nRow, "l_curr_cd",sheetObj.GetCellValue(i, "l_curr_cd"));
			sheetObjTarget.SetCellValue(nRow, "vps_port_cd",sheetObj.GetCellValue(i, "vps_port_cd"));
			sheetObjTarget.SetCellValue(nRow, "vsl",sheetObj.GetCellValue(i, "vsl"));
			sheetObjTarget.SetCellValue(nRow, "vps_etd_dt",sheetObj.GetCellValue(i, "vps_etd_dt"));
						
			//IBS_CopyRowToForm(sheetObj, formObj, i, type);
			eval(type).style.display='';
		}
		
		
	} catch (ex) {
		bkg_error_alert('sheet1_OnSearchEnd', ex);
		return false;
	}
}
/**
	 * Checking validation of input value
	 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		//             if (!isNumber(formObj.iPage)) {
		//                 return false;
		//             }
	}
	return true;
}
/**
	 * Register as an IBSheet Object array
	 * This is called from comSheetObject(id)
	 * Process can add in case of future necessity to process other items
	 * Array defined at the top of the source
	 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * bkg_error_alert error message
 */
function bkg_error_alert(msg, ex) {
	alert('[ ' + msg + ' ]=[ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
}