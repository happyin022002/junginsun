/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_6002.jsp
*@FileTitle  : Remark by VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// common static variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_save":
			doActionIBSheet('', formObject, IBSAVE);
			break;
		case "btn_delete":
			doActionIBSheet('', formObject, IBDELETE);
			saveConfirm('D');
			break;
		case "btn_close":
			ComClosePopup(); 
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("EQR90004");
		} else {
			alert(e);
		}
	}
}
function saveConfirm(gubun) {
	var opener = window.dialogArguments;
	if (!opener) opener = parent;
	
	if (gubun == 'I') {
		
		window.opener.vvdTotal.SetCellValue(document.form.row.value, "remark",document.form.remark.value);
		//opener.document.form.vvdTotal.SetCellValue(document.form.row.value, "remark",document.form.remark.value);
	} else {
		window.opener.vvdTotal.SetCellValue(document.form.row.value, "remark","");
		//opener.document.form.vvdTotal.SetCellValue(document.form.row.value, "remark","");
	}
	// top.opener.form.vvdTotal.CellValue(document.form.row.value, "status") =
	// "R";
	// for ( var i = 1; i < top.opener.form.portTotal.RowCount + 1; i++) {
	// if (top.opener.form.portTotal.CellValue(i, 4) == document.form.vvd.value)
	// {
	// top.opener.form.portTotal.CellValue2(i, 27) = "I";
	//
	// }
	// }
	var sheet=eval("window.opener.sheet" + document.form.weekdivision.value);
	for ( var i=1; i < sheet.RowCount()+ 1; i++) {
if (document.form.vvd.value == sheet.GetCellValue(i, 2)) {
			if (gubun == 'I') {
 				sheet.SetCellFont("FontBold", i, 0,1);
 				sheet.SetCellFont("FontUnderline", i, 0,1);
			} else {
 				sheet.SetCellFont("FontBold", i, 0,0);
 				sheet.SetCellFont("FontUnderline", i, 0,0);
			}
		}
	}
  ComClosePopup(); 
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag 
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}
/**
 * setting sheet initial values and header param : sheetObj ==> sheet object, sheetNo ==> sheet number
 *  adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: // t1sheet1 init
		with(sheetObj){	      
	      if (location.hostname != "")
	      (6, 0, 0, true);
	      var HeadTitle="|Sel.|WK|Lane|VVD|Remark (within 100 bytes)";
	
	      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"Status" },
	             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Sel",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	             {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"WK",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	             {Type:"Combo",     Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"Lane",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	             {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"VVD",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"Remark",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 } ];
	       
	      InitColumns(cols);
	
	      SetEditable(1);
	      SetColProperty("WK", {ComboText:"40|41|42", ComboCode:"40|41|42"} );
	      SetColProperty("Lane", {ComboText:"PSX|FEX|AEX", ComboCode:"PSX|FEX|AEX"} );
	      SetColProperty("VVD", {ComboText:"HNBN0051W|HJRM0098E|PNSE0010E|PKSE0013E", ComboCode:"HNBN0051W|HJRM0098E|PNSE0010E|PKSE0013E"} );
	      SetSheetHeight(300);
		}
		break;
	}
}
// handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	// sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case IBSEARCH: // retrieve
		if (validateForm(sheetObj, formObj, sAction)){
			//sheetObj.SetWaitImageVisible(0);
//			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			formObj.action="EES_EQR_6002.do";
			formObj.submit();
//			sheetObj.WaitImageVisible = true;
//			ComOpenWait(false);
		}
		break;
	case IBSAVE: // saving
		if (validateForm(sheetObj, formObj, sAction)) {
			//sheetObj.SetWaitImageVisible(0);
//			ComOpenWait(true);
			formObj.f_cmd.value=MULTI;
			if (!ComShowCodeConfirm("EQR90192"))
				return;
			formObj.mathod="post";
			formObj.action="EES_EQR_6002.do";
			formObj.submit();
			saveConfirm('I');
//			sheetObj.WaitImageVisible = true;
//			ComOpenWait(false);
		} else {
			return;
		}
		break;
	case IBDELETE: // removing
		if (validateForm(sheetObj, formObj, sAction)) {
			//sheetObj.SetWaitImageVisible(0);
//			ComOpenWait(true);
			formObj.f_cmd.value=MULTI01;
			if (!ComShowCodeConfirm("EQR90193"))
				return;
			formObj.mathod="post";
			formObj.action="EES_EQR_6002.do";
			formObj.submit();
//			sheetObj.WaitImageVisible = true;
//			ComOpenWait(false);
		} else {
			return;
		}
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (sAction == IBSAVE) {
			if (remark.value == "") {
				ComShowCodeMessage("EQR90227");
				ComSetFocus(remark);
				return false;
			}
			if (ComChkLenByByte(remark, 1000) == 0) {
				ComShowCodeMessage("EQR90200");
				ComSetFocus(remark);
				return false;
			}
		}
	}
	return true;
}
