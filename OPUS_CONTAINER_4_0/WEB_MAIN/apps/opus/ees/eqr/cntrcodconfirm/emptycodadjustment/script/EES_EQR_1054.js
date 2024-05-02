/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_EQR_1054.js
 *@FileTitle : Remark by VVD
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.14
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/

var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
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
			alert(e);
		} else {
			alert(e);
		}
	}
}
function saveConfirm(gubun) {
	if (gubun == 'I') {
		top.opener.form.vvdTotal.SetCellValue(document.form.row.value, "remark",document.form.remark.value);
	} else {
		top.opener.form.vvdTotal.SetCellValue(document.form.row.value, "remark","");
	}
	var sheet=eval("top.opener.form.sheet" + document.form.weekdivision.value);
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
 * IBSheet Object
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Load sheet body  
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
}
/**
 * Setting sheet default value 
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: // t1sheet1 init
	    with(sheetObj){
			
		      var HeadTitle="|Sel.|WK|Lane|VVD|Remark (within 100 bytes)";

		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

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
		      SetColProperty("WK", {ComboText:"40|41|42", ComboCode:"40|41|42"} );
				SetColProperty("Lane", {ComboText:"PSX|FEX|AEX", ComboCode:"PSX|FEX|AEX"} );
				SetColProperty("VVD", {ComboText:"HNBN0051W|HJRM0098E|PNSE0010E|PKSE0013E", ComboCode:"HNBN0051W|HJRM0098E|PNSE0010E|PKSE0013E"} );
			        SetSheetHeight(300);
		      SetEditable(1);
		 }
		break;
	}
}
// Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: 
		if (validateForm(sheetObj, formObj, sAction)){
			//sheetObj.SetWaitImageVisible(0);
			formObj.f_cmd.value=SEARCH;
			formObj.action="EES_EQR_1054.do";
			formObj.submit();
		}
		break;
	case IBSAVE: 
		if (validateForm(sheetObj, formObj, sAction)) {
			//sheetObj.SetWaitImageVisible(0);
			formObj.f_cmd.value=MULTI;
			if (!ComShowCodeConfirm("EQR90192"))
				return;
			formObj.mathod="post";
			formObj.action="EES_EQR_1054.do";
			formObj.submit();
			saveConfirm('I');
		} else {
			return;
		}
		break;
	case IBDELETE: 
		if (validateForm(sheetObj, formObj, sAction)) {
			//sheetObj.SetWaitImageVisible(0);
			formObj.f_cmd.value=MULTI01;
			if (!ComShowCodeConfirm("EQR90193"))
				return;
			formObj.mathod="post";
			formObj.action="EES_EQR_1054.do";
			formObj.submit();
		} else {
			return;
		}
		break;
	}
}
/**
 * validate input value
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
