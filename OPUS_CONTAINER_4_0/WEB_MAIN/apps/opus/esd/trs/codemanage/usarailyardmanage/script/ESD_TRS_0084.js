/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0084.js
 *@FileTitle  : UsaRailYardManage
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/08/18
=========================================================*/
/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc Code ------------------*/
/**
 * @fileoverview For example) Booking service for creating scripts to use on the screen is defined.
 * @author OPUS
 */
/**
 * @extends TRS
 * @class ESD_TRS_084
 */
/*------------------From here the common JavaScript function is defined.    ------------------*/
// Common global variable
var sheetObjects = new Array();
var sheetCnt = 0;
/* Click the button to define an event handler that receives and processes events */
document.onclick = processButtonClick;
/* Button to process certain filename, separated on a quarterly event handler to handle */
function processButtonClick() {
	/** *** Add 2 or more case taepdang sheet by sheet, using a variable assignment **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;
			case "btng_save":
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
			case "btn_reset":
				fn_reset();
				break;
			case "btn_close":
				ComClosePopup();
				break;
		} // end switch
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
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	var formObject = document.form;
	formObject.yard.focus();
}
/**
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
       case 1:
            with (sheetObj) {
               var HeadTitle="Sel|STS|Yard Code|Yard Name|Yard City|Yard State|Office State|Office Address|Office City|Office Zip";

               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
               var headers = [ { Text:HeadTitle, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sel" },
	                      {Type:"Status",    Hidden:0, Width:30,   Align:"Center",    ColMerge:1,   SaveName:"ibflag" },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
	                      {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"yd_nm",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"yd_loc_cty_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
	                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"yd_loc_ste_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"yd_ctrl_ofc_ste_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	                      {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"yd_ctrl_ofc_addr",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"yd_ctrl_ofc_cty_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"yd_ctrl_ofc_zip_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 } ];
               InitColumns(cols);
               SetColProperty(0, "yd_loc_cty_nm" ,{AcceptKeys:"E|[ ]",  InputCaseSensitive:true});
               SetColProperty(0, "yd_loc_ste_cd" ,{AcceptKeys:"E", InputCaseSensitive:true});
               SetColProperty(0, "yd_ctrl_ofc_ste_cd" ,{AcceptKeys:"E", InputCaseSensitive:true});
               SetEditable(1);
               SetSheetHeight(240);
           }
        break;
    }
}
/*
 * handling of Sheet
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH:
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESD_TRS_0084GS.do", TrsFrmQryString(formObj));
			break;
		case IBSAVE:
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESD_TRS_0084GS.do", TrsFrmQryString(formObj), "sel", false);
			break;
		case "btn_reset":
			fn_reset();
			break;
	}
}
/*
 * Get a list of external combo box (ESD_TRS_003.js also exists).
 */
function getComboList_val(obj, comObj, sep) { // object, taking the value portion, 'Node kind
	comObj = eval(comObj.id);
	var formObj = document.form;
	var formObject = document.form;
	var charval = "Y";
	var inputStr = obj.value;
	var lvFromNode = "";
	var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
	var yard_obj = null;
	obj.value = lvobj;
	if (lvobj == "") {
		obj.value = "";
		if (obj.name == 'yard')
			yard_obj = rail_yard;
		var locValue = obj.value;
		if (ComTrim(locValue) == '') {
			yard_obj.RemoveAll();
			return;
		}
	} else if (lvobj.length != 5) {
		ComShowCodeMessage("TRS90074");
		if (sep == "F") {
			formObject.yard.select();
			formObject.yard.focus();
			rail_yard.RemoveAll();
		} else {
		}
	} else {
		for ( var i = 0; i < inputStr.length; i++) {
			var oneChar = inputStr.charAt(i)
			if (oneChar != "") {
				if ((oneChar >= "a" && oneChar <= "z") || (oneChar >= "A" && oneChar <= "Z") || (oneChar >= "0" && oneChar <= "9")) {
				} else {
					charval = "N";
					break;
				}
			} else {
				charval = "N";
				break;
			}
		}
		if (charval == "Y") {
			if (sep == 'F') {
				lvFromNode = getYardZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
			} else {
			}
		} else {
			if (sep == 'F') {
				var errMessage = ComGetMsg('COM12130', 'YARD DATA', '', '');
				ComShowMessage(errMessage);
				obj.value = "";
				formObj.yard.focus();
				formObj.yard.select();
				rail_yard.RemoveAll();
			}
		}
	}
	comObj.focus();
}
/**
 * Focus Events
 */
function fun_Focus(obj) {
	var val = obj.value;
	obj.value = val;
	obj.select();
}
/**
 * When an error occurs, save the results to a common processing function
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {
	if (errMsg != "") 
		return;
}
/**
 * Reset Function
 */
function fn_reset() {
	var formObject = document.form;
	sheetObjects[0].RemoveAll();
	formObject.yard.value = "";
	rail_yard.RemoveAll(); // Delete data combo
}
