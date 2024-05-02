/*
 *=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0978.js
 *@FileTitle  : Transport Status Update
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/08/05
=========================================================
 */
/** Common global variable */
var sheetObjects = new Array();
var sheetCnt = 0;
var trsSubStsCd = "";
/** Event handler processing by button click event */
document.onclick = processButtonClick;
var winOpenObject = opener;
if (!winOpenObject) {
	winOpenObject = parent;
}

/** Event handler processing by button name */
function processButtonClick() {
	/**
	 * ***Case more than two additional sheets tab sheet is used to specify a variable ****
	 */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName)) {
			return false;
		}
		switch (srcName) {
			case "btn_history": {
				ComOpenPopup('/opuscntr/ESD_TRS_0983.do', 800, 400, "", "0,0", false);
				break;
			}
			case "btn_apply": {
				var checkTrsSubStsCdVal = "";
				var trsSubStsCd = document.getElementsByName("trs_sub_sts_cd");
				for ( var i = 0; i < trsSubStsCd.length; i++) {
					if (trsSubStsCd[i].checked == true) {
						checkTrsSubStsCdVal = trsSubStsCd[i].value;
						break;
					}
				}
				if (!ComIsEmpty(checkTrsSubStsCdVal)) {
					winOpenObject.document.form.trs_sub_sts_cd_n.value = checkTrsSubStsCdVal;
					winOpenObject.doActionIBSheet(winOpenObject.sheet, winOpenObject.document.form, IBSEARCH_ASYNC02);
				} else {
					ComShowCodeMessage("COM12189");
					return false;
				}
				ComClosePopup();
				break;
			}
			case "btn_close": {
				ComClosePopup();
				break;
			}
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
 */
function loadPage() {
	for ( var i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		ComEndConfigSheet(sheetObjects[i]);
	}
	var rdTrsSubStsCd = document.getElementsByName("trs_sub_sts_cd");
	for ( var i = 0; i < rdTrsSubStsCd.length; i++) {
		if (rdTrsSubStsCd[i].value == "DF") {
			if (trsSubStsCd != 'DF') {
				rdTrsSubStsCd[i].disabled = true;
			} else {
				rdTrsSubStsCd[i].disabled = false;
			}
		} else {
			if (trsSubStsCd != 'DF') {
				rdTrsSubStsCd[i].disabled = false;
			} else {
				rdTrsSubStsCd[i].disabled = true;
			}
		}
	}
}

/**
 * 
 * @returns
 */
function funcCheckedParam() {
	return winOpenObject.sheet.GetSaveString(false, true, 'ibcheck');
}