/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0965.js
 *@FileTitle  : Stop Off Cargo Order 
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/04/08
=========================================================*/

document.onclick = processButtonClick;
var openOpener = opener;
if (!openOpener)
	openOpener = parent;

function processButtonClick() {
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_Close":
				ComClosePopup();
				break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("COM12111");
		} else {
			ComShowMessage(e.message);
		}
	}
}

function loadPage() {
	initControl();
}
function initControl() {
	var o = openOpener.GetStopOffInfo(currow);
	var formObject = document.form;
	formObject.stop_off_loc_cd.value = o.stop_off_loc_cd;
	formObject.stop_off_cntc_phn_no.value = o.stop_off_cntc_phn_no;
	formObject.stop_off_cntc_pson_nm.value = o.stop_off_cntc_pson_nm;
	formObject.stop_off_diff_rmk.value = o.stop_off_diff_rmk;
}
