/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   ESM_BKG_0616.jsp
 *@FileTitle  : Booking EDI Transmit to Terminal 
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
 OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

//global variable
var sheetObjects = new Array();
var sheetCnt = 0;

// Event handler processing by button click event  */
document.onclick = processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject1 = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName))
			return false;
		switch (srcName) {
		case "btn_Save":
			doActionIBSheet(sheetObject1, document.form, IBSAVE);
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
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
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
}
/**
 * init control
 */
function initControl() {
	var formObject = document.form;
	axon_event.addListenerForm("change", "form_onChange", formObject);
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 * @param sheetObj sheet Object
 * @param sheetNo 
 */
function initSheet(sheetObj, sheetNo) {
	switch (sheetObj.id) {
	case 'sheet1':
		with (sheetObj) {
			sheetObj.SetVisible(false);
			break;
		}
	}
}

/**
 * Sheet process handling
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSAVE: // IBSAVE
			if(!validateForm(sheetObj, formObj, sAction)) return;
			parent.WaitImage(true);
			setTimeout("saveDataComand();", 100);
		break;
	}
}

function saveDataComand(){
	var formObj = document.form;
	var ediRefCd = formObj.edi_ref_cd.value.split("|");
	var edi_ref_id = ediRefCd[0];
	var edi_ref_cd = ediRefCd[1];
	var vvd = formObj.vvd.value;
	var param = '&edi_ref_id=' + edi_ref_id + "&edi_ref_cd=" + edi_ref_cd + "&vvd=" + vvd;
	var sXml = sheetObjects[0].GetSearchData("ESM_BKG_0618GS.do?f_cmd=" + SEARCH01, param);
	parent.WaitImage(false);
	if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == 'S'){
		ComShowCodeMessage("BKG00693");
	}
	
	ComClosePopup();
}

/**
 * handling process for input validation
 * @param sheetObj sheet Object
 * @param formObj  form Object
 * @param sAction 
 */
function validateForm(sheetObj, formObj, sAction) {
	var result = false;
	with (formObj) {
		switch (sAction) {
			case IBSAVE:
				if (!ComChkValid(formObj))
					return false;
				
				return true;
			break;
		}
	}
	return result;
}

/**
 * 
 */
function form_onChange() {
	var srcName = ComGetEvent("name");
	var srcValue = ComGetEvent("value");
	var formObj = document.form;
	if (srcName == "edi_ref_cd") {
		var ediRefCd = formObj.edi_ref_cd.value.split("|");
		var edi_ref_cd = ediRefCd[1];
		var sXml = sheetObj.GetSearchData("ESM_BKG_0618GS.do?f_cmd=" + SEARCH, "edi_ref_cd=" + edi_ref_cd);
		var vvdList = ComGetEtcData(sXml, "vvd");
		formObj.vvd.innerHTML = "";
		var comboList;
		if(vvdList != ''){
			comboList = vvdList.split(",");
			for (var i = 0; i < comboList.length; i++) {
				if(comboList[i] != ''){
					formObj.vvd.innerHTML += '<option value="' + comboList[i] + '">' + comboList[i] + '</option>';
				}
			}
		}
	}
}