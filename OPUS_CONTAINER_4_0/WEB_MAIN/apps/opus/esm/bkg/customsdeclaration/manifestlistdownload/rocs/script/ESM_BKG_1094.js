/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1094.js
*@FileTitle  : ESM_BKG_1094
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_BKG-1094 : business script for ESM_BKG-1094
 */
// Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var state="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
function processButtonClick() {
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_save":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;
		case "btn_close":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
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
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	document.form.vsl_call_ref_no_new.focus();
}
/**
 */
function initControl() {
	DATE_SEPARATOR="-";
	var formObject=document.form;
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // -
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}
/**
 * when inputting search condition
 */
function obj_KeyUp() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}
/**
 */
function obj_keypress() {
	switch (event.srcElement.dataformat) {
	case "uppernum":
		// English capital + number
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "uppernum2":
		// English capital + number
		ComKeyAlphabetNChar('uppernum');
		break;
	case "upper":
		// English capital + number
		ComKeyOnlyAlphabet('upper');
		break;
	case "num":
		// English capital + number
		ComKeyOnlyNumber('num', '-');
		break;
	case "num2":
		// English capital + number
		ComKeyOnlyNumber('num', '.');
		break;
	case "num3":
		// English capital + number
		ComKeyOnlyNumber('num', '');
		break;
	default:
		// number only
		ComKeyOnlyNumber(event.srcElement);
	}
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
	case "sheet1": // sheet1 init
	    with(sheetObj){
       
      var HeadTitle1="||";

      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                   {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd" },
                   {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_call_ref_no_old" },
                   {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_call_ref_no_new" } ];
       
      InitColumns(cols);

      SetEditable(1);
      SetSheetHeight(100);
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
	switch (sAction) {
	case IBSAVE: // 
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			sheetObj.DataInsert(-1);
			sheetObj.SetCellValue(1,"vvd_cd",formObj.vvd_cd.value);
			sheetObj.SetCellValue(1,"vsl_call_ref_no_old",formObj.vsl_call_ref_no_old.value);
			sheetObj.SetCellValue(1,"vsl_call_ref_no_new",formObj.vsl_call_ref_no_new.value);
			// alert(sheetObj.RowCount);
			formObj.f_cmd.value=MULTI;
			sheetObj.DoAllSave("ESM_BKG_1094GS.do", FormQueryString(formObj));
	    	 if(sheetObj.GetEtcData("err_msg") == "BKG06142"){   
	    		 ComOpenWait(false);   	
                 return false;
             }
			state=sheetObj.GetEtcData("TRANS_RESULT_KEY");
			if (state == "S") {
				sheetObj.RemoveAll();
				formObj.vsl_call_ref_no_old.value=formObj.vsl_call_ref_no_new.value;
				formObj.vsl_call_ref_no_new.value="";
				window.dialogArguments.retrieve(formObj.vsl_call_ref_no_old.value);
			}
			ComOpenWait(false);
		}
		break;
	case COMMAND01: // 
		ComClosePopup(); 
	break;		
	}
}
/**
 *  calling from pop up for retrieve
 */
function retrieve() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
 * handling process for input validation
 * @param sheetObj Sheet
 * @param formObj 
 * @param sAction 
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSAVE:
		if (formObj.vsl_call_ref_no_new.value == "" || formObj.vsl_call_ref_no_new.value.length != 13) {
			ComShowCodeMessage('BKG00266');
			formObj.vsl_call_ref_no_new.focus();
			return false;
		}
		return true;
		break;
	}
}
