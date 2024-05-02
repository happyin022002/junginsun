/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_vsk_0218.js
*@FileTitle  : Remark(s) (Pop-Up)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/16
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class VOP_VSK_0218 : business script for VOP_VSK_0218
 */
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	//var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return;  
		switch (srcName) {
		case "btn_ok":
			//if (validateForm(sheetObject1, formObj, IBSAVE)) {
			if (validateForm(formObj)) {
				var val=formObj.remarks.value;
//				window.returnValue=val.trim();
//				comPopupOK();
				
				ComPopUpReturnValue(val.trim());
			}
			//}
			break;
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
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function loadPage() {
	 	
	if (document.form.remarks.readOnly) {
		ComBtnDisable("btn_ok");
	}
	document.form.remarks.focus();
}
/**
 * handling process for input validation
 */
function validateForm(formObj) {
	with (formObj) {
		if (formObj.remarks.value.length > 3000) {
			 ComShowCodeMessage( "VSK01019", "[Remark(s)]" );    
			 remarks.value="";
			 remarks.focus();
			 return false;
		 }
	}
	return true;
}
