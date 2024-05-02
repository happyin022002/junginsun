/*=========================================================
 *Copyright(c) 2016 CyberLogitec. All Rights Reserved.
 *@FileName : esm_bkg_1501-01.js
 *@FileTitle : ESM_BKG-1501-01
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
		var opnrFormObj = opener.document.form;
		try {
			var srcName = ComGetEvent("name");
			switch (srcName) {
				case "btn_confirm":
					if (!ComChkValid(formObj)) return;
					opnrFormObj.corr_rsn_cd.value = formObj.corr_rsn_cd.value;
					opnrFormObj.corr_rsn.value = formObj.corr_rsn.value;
					if (opnrPgmDiv == "1501") {
						opener.doActionIBSheet(opener.sheetObjects[1], opnrFormObj, COMMAND01);
					} else if (opnrPgmDiv == "1502") {
						opener.doActionIBSheet(opener.sheetObjects[0], opnrFormObj, COMMAND01);
					}
					ComClosePopup();
				break;

				case "btn_cancel":
					opnrFormObj.corr_rsn_cd.value = "";
					opnrFormObj.corr_rsn.value = "";
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
		initControl();
	}


	/**
	 * setting form control  & event
	 */
	function initControl() {
		axon_event.addListenerForm("change", "frmObj_OnChange", document.form);
	}

	/**
	 * Form Element의 OnChange 이벤트
	 */
	function frmObj_OnChange() {
		var elementName = ComGetEvent("name");
		with (document.form) {
			switch (elementName) {
				case "corr_rsn_cd":
					if (ComGetEvent("value") == "5") {
						corr_rsn.readOnly = false;
						corr_rsn.className = "input1";
						corr_rsn.setAttribute("required", "");
					} else {
						corr_rsn.value == "";
						corr_rsn.removeAttribute("required");
						corr_rsn.className = "input2";
						corr_rsn.readOnly = true;
					}
				break;
			}
		}
	}
