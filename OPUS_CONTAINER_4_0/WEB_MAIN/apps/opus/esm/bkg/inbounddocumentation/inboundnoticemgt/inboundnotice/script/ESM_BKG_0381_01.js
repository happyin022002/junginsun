/*=========================================================
 *Copyright(c) 2016 CyberLogitec. All Rights Reserved.
 *@FileName : esm_bkg_0381_01.js
 *@FileTitle : ESM_BKG-0381_01
*@author     : CLT
*@version    : 1.0
*@since      :
=========================================================*/

// Event handler processing by button click event  */
document.onclick = processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** using extra sheet valuable if there are more 2 sheets *****/
	/** **************************************************** */
	var formObj = document.form;
	var opener = window.dialogArguments;
	if (!opener) opener = parent;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_send":
				if (formObj.method[0].checked) {    // B/L
					opener.mailMethod = formObj.method[0].value;    // opener의 전역변수에 value setting
				} else if (formObj.method[1].checked) {    // MAIL
					opener.mailMethod = formObj.method[1].value;    // opener의 전역변수에 value setting
				}
				opener.mailPopClose = "Y";
				ComClosePopup();
			break;

			case "btn_close":
				opener.mailMethod = "";
				opener.mailPopClose = "Y";
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
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
*/
function loadPage() {
}
