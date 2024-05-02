/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0079.js
*@FileTitle  : Freight & Charge_S/C Note
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class esm_bkg_0270 : esm_bkg_0270 
 */
/* developer's work*/
// global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var prefix1="sheet1_";
var prefix2="sheet2_";
// Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	if (document.form.bkg_no.value == '' || document.form.svc_scp_cd.value == '' || document.form.application_date.value == '') {
		ComShowMessage("[sc_no],[svc_scp_cd],[application_date]은/는 필수입력 항목 입니다.");
		ComClosePopup(); 
	}
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
	var sheetID=sheetObj.id;
	switch (sheetNo) {
	case 1:
	    with(sheetObj){
			var HeadTitle1="|Type|Seq|Title|Content|Effective Date|Effective Date";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"type",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix1+"title",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:540,  Align:"Left",    ColMerge:1,   SaveName:prefix1+"content",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"effect_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"expire_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
   
			InitColumns(cols);
			SetSheetHeight(122);
			SetEditable(1);
        }
		break;
	case 2:
	    with(sheetObj){
			var HeadTitle1="|Type|Seq|Title|Content|Effective Date|Effective Date";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"type",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix2+"title",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:540,  Align:"Left",    ColMerge:1,   SaveName:prefix2+"content",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"effect_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"expire_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
   
			InitColumns(cols);
			SetSheetHeight(122);
			SetEditable(1);
        }
		break;
	}
}
// handling of Sheet 
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	var aryPrefix=new Array("sheet1_", "sheet2_");
	var prefix=sheetObj.id + "_";
	switch (sAction) {
	case IBSEARCH: //search
		//1.setting to selected value or before searching, inputting parameter
		ComSetObjValue(formObj.f_cmd, SEARCH);
		// 2.searching with searching conditrion
		var sXml=sheetObj.GetSearchData("ESM_BKG_0270GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		// 3.handling result after searching
		var arrXml=sXml.split("|$$|");
		//1. searching OFT Note. 2. searching Surcharg Note. 
		for ( var inx=0; inx < arrXml.length; inx++) {
			sheetObjects[inx].LoadSearchData(arrXml[inx],{Sync:1} );
		}
//		var arbitrary_note = ComGetEtcData(arrXml[0], "arbitrary_note");
//		ComSetObjValue(formObj.arbitrary_note, arbitrary_note);
		var idx=1;
		//1. showing OFT Note. 2. showing Surcharg Note
//		for ( var inx = 0; inx < arrXml.length; inx++) {
//			if (sheetObjects[inx].TotalRows > 0) {
//				eval('DIV_sheet' + idx++).style.display = '';
//			}
//		}
		//3. showing Arbitrary Note
//		if (arbitrary_note.length > 0) {
//			eval('DIV_sheet3').style.display = '';
//		}
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		//             if (!isNumber(formObj.iPage)) {
		//                 return false;
		//             }
	}
	return true;
}
// Event handler processing by button name */
function processButtonClick() {
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Close":
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
 * in case of clicking Sheet, showing Content all
 */
function sheet1_OnClick(sheetObj,row,col,value){
	//when you click the desc cell, showing MemoPad
	if(sheetObj.ColSaveName(col) == prefix1 + "content"){
//		ComShowMemoPad(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax)	
		ComShowMemoPad(sheetObj,null,null,true,sheetObj.GetColWidth(col),null,1000);
	}
}
 /**
  * in case of clicking Sheet, showing Content all
  */
 function sheet2_OnClick(sheetObj,row,col,value){
 	//when you click the desc cell, showing MemoPad
 	if(sheetObj.ColSaveName(col) == prefix2 + "content"){
// 		ComShowMemoPad(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax)	
 		ComShowMemoPad(sheetObj,null,null,true,sheetObj.GetColWidth(col),null,1000);
 	}
 }
/* the end of developer's work */
