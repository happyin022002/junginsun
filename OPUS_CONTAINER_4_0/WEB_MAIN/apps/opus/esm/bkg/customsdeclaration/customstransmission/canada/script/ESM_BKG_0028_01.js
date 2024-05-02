/*=========================================================
 *Copyright(c) 2016 CyberLogitec. All Rights Reserved. 
 *@FileName : esm_bkg_0028_01.js
 *@FileTitle : ESM_BKG-0028_01
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
	var openerSheet = opener.sheetObjects[0];
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_apply":
				var vvdCd = formObj.vvd_cd.value;
				var podCd = formObj.pod_cd.value;
				var cstmsPortCd = formObj.cstms_port_cd.value;
				if (vvdCd != "" || podCd != "" || cstmsPortCd != "") {
					with (openerSheet) {
						var chkdRowArray = FindCheckedRow("chk").split("|");
						for (var k in chkdRowArray) {
							if (vvdCd != "") SetCellValue(chkdRowArray[k], "t_vvd_cd", vvdCd);
							if (podCd != "") SetCellValue(chkdRowArray[k], "bkg_pod_cd", podCd);
							if (cstmsPortCd != "") SetCellValue(chkdRowArray[k], "cstms_port_cd", cstmsPortCd);
						}
					}
				}
				ComClosePopup();
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
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
*/
function loadPage() {
}
