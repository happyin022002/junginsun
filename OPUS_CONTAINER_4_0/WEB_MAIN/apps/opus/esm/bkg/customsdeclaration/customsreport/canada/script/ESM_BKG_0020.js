/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0020.js
*@FileTitle  : Customer Code Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
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
		case "btn_Setup":
			doActionIBSheet(sheetObject, formObject, COMMAND01);
			break;
		case "btn_Close":
			ComClosePopup(); 
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
	doActionIBSheet(sheetObjects[0], document.form, INIT);
//	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
//	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
}
/**
 * setting sheet initial values and header
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": //sheet1 init
	    with(sheetObj){	      
	      var HeadTitle1="ibflag";
	      var headCount=ComCountHeadTitle(HeadTitle1);
	
	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
	       
	      InitColumns(cols);
	      SetVisible(0);
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
	case INIT:
		//AN Type Combo
		formObj.f_cmd.value=INIT;
		var sXml=sheetObj.GetSearchData("ESM_BKG_0020GS.do", FormQueryString(formObj));
		ComXml2ComboItem(sXml, cnd_an_tp_cd, "attr_ctnt1", "attr_ctnt2");
		break;
	case COMMAND01:
		if (validateForm(sheetObj, formObj, sAction)) {
			var vvd="";
			var eta="";
			var antype="";
			if (formObj.vvd_flg.checked) {
				vvd=formObj.vvd_cd.value;
			}
			if (formObj.eta_flg.checked) {
				eta=formObj.eta_dt.value;
			}
			if (formObj.antype_flg.checked) {
				antype=cnd_an_tp_cd.GetSelectCode();
			}
			
			var opener=window.dialogArguments;
			if (!opener) opener=parent; //이 코드 추가할것

			opener.setAnType(vvd, eta, antype);			
			ComClosePopup(); 
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
	case COMMAND01:
		if (!ComChkValid(formObj))
			return false;
		if (formObj.vvd_flg.checked) {
			if (ComIsNull(formObj.vvd_cd)) {
				ComShowCodeMessage('BKG00625');
				return false;
			}
		}
		if (formObj.eta_flg.checked) {
			if (ComIsNull(formObj.eta_dt)) {
				ComShowCodeMessage('BKG00625');
				return false;
			}
		}
		if (formObj.antype_flg.checked) {
			if (ComIsNull(cnd_an_tp_cd.GetSelectCode())) {
				ComShowCodeMessage('BKG00625');
				return false;
			}
		}
		break;
	}
	return true;
}
/**
 * when inputting search condition
 */
function obj_KeyUp() {
	var formObject=document.form;
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}
