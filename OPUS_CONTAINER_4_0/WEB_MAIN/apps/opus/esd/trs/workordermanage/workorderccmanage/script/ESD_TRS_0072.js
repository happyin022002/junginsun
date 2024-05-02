/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   :  ESD_TRS_0072.js
 *@FileTitle  : Transportation Report & Code
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/04/08
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	var formObj = document.form;
	/** **************************************************** */
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_retrieve1": {
				if (!validateForm(sheetObject1, formObj, IBSEARCH, srcName)) {
					return false;
				}
				doActionIBSheet(sheetObject1, formObj, IBSEARCH, srcName);
				break;
			}
			case "btn_retrieve2":
				if (!validateForm(sheetObject1, formObj, IBSEARCH, srcName))
					return;
				doActionIBSheet(sheetObject2, formObj, IBSEARCH, "FAX");
				doActionIBSheet(sheetObject3, formObj, IBSEARCH, "EMAIL");
				break;
			case "btn_reset": {
				resetForm(formObj);
				break;
			}
			case "btn_save": {
				var checkListFax = sheetObject2.FindCheckedRow('ibcheck');
				var checkListEml = sheetObject3.FindCheckedRow('ibcheck');
				var checkArrayFax = checkListFax.split('|');
				var checkArrayEml = checkListEml.split('|');
				if(sheetObject1.FindCheckedRow('ibcheck') == '') {
					return false;
				}
				if (checkArrayFax == '' && checkArrayEml == '') { // Fax, Email 중 선택된 row가 1개도 없을 경우
					ComShowCodeMessage('TRS90036');
				} else {
					if (sheetObject2.RowCount() > 0) {
						doActionIBSheet(sheetObject2, formObj, IBSAVE, "FAX");
					}
					if (sheetObject3.RowCount() > 0) {
						doActionIBSheet(sheetObject3, formObj, IBSAVE, "EMAIL");
					}
				}
				break;
			}
			case "btn_provider":
				com_OnPopupClick("service_provider");
				break;
			case "btn_control_office":
				com_OnPopupClick("control_office");
				break;
			case "btn_location":
				com_OnPopupClick("location");
				break;
			case "btn_fax_row_add": {
				if(sheetObject1.FindCheckedRow('ibcheck') == '') {
					ComShowCodeMessage('TRS90382');
					return false;
				}
				var row = sheetObject2.DataInsert(-1);
				sheetObject2.SetCellValue(row, 'trs_chk', '1', 0);
				sheetObject2.SetCellValue(row, 'trs_chk_org', '1', 0);
				break;
			}
			case "btn_eml_row_add": {
				if(sheetObject1.FindCheckedRow('ibcheck') == '') {
					ComShowCodeMessage('TRS90382');
					return false;
				}
				var row = sheetObject3.DataInsert(-1);
				sheetObject3.SetCellValue(row, 'trs_chk', '1', 0);
				sheetObject3.SetCellValue(row, 'trs_chk_org', '1', 0);
				break;
			}
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('TRS90384');
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * Set SheetObject
 * @param sheet_obj
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Loand Page
 */
function loadPage() {
	for (var i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
}


/**
 * Init Sheet
 * @param sheetObj
 * @param sheetNo
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1: {  
		    with(sheetObj){
			      var HeadTitle1="|Service Provider|Service Provider|Control Office|Location|Creation Office|Creation User Name|Creation Date" ;
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [   {Type:"Radio",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibcheck",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
					             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"vndr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100},
					             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:"ctrl_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
					             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:"loc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
					             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
					             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
					             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 } 
			             ];
			       
			      InitColumns(cols);
			      SetSheetHeight(200);
			      SetEditable(1);
		    }
		    break;
		}
		case 2: {     //FAX SHEET OBJECT
		    with(sheetObj) {
			      var HeadTitle1="||TRS|MDA|Fax No" ;
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ 	 {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibcheck",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 , HeaderCheck:1},
					             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trs_chk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20, HeaderCheck:0 },
					             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mdm_chk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20, HeaderCheck:0 },
					             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"wo_fax_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
					             {Type:"CheckBox",  Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trs_chk_org",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20, HeaderCheck:0 },
					             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
					             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"wo_cc_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 } 
					           ];
			       
			      InitColumns(cols);
			      ComResizeSheet(sheetObj);
			      SetEditable(1);
		    }
		    break;
		}

		case 3: {      //EMAIL SHEET OBJECT
		    with(sheetObj) {
		      var HeadTitle1="||TRS|MDA|E-Mail Address" ;
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ 	 {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibcheck",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 , HeaderCheck:1 },
				             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trs_chk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 , HeaderCheck:0 },
				             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mdm_chk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 , HeaderCheck:0 },
				             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"wo_eml",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
				             {Type:"CheckBox",  Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trs_chk_org",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20, HeaderCheck:0 },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"wo_cc_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 } ];
		       
		      InitColumns(cols);
		      SetEditable(1);
		      ComResizeSheet(sheetObj);
		    }
			break;
		}
	}
}

/**
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @param srcName
 * @returns {Boolean}
 */
function doActionIBSheet(sheetObj, formObj, sAction, srcName) {
	switch (sAction) {
		case IBSEARCH:
			switch (srcName) {
				case "btn_retrieve1": {
					sheetObj.RemoveEtcData();
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("ESD_TRS_0072GS.do", TrsFrmQryString(formObj));
					sheetObjects[1].RemoveAll();
					sheetObjects[2].RemoveAll();
					break;
				}
				case "FAX": {
					formObj.SELECTED_VNDR_SEQ.value = sheetObjects[0].GetCellValue(sheetObjects[0].FindCheckedRow('ibcheck').split('|'), "vndr_seq");
					formObj.SELECTED_CTRL_OFC_CD.value = sheetObjects[0].GetCellValue(sheetObjects[0].FindCheckedRow('ibcheck').split('|'), "ctrl_ofc_cd");
					formObj.SELECTED_LOC_CD.value = sheetObjects[0].GetCellValue(sheetObjects[0].FindCheckedRow('ibcheck').split('|'), "loc_cd");
					formObj.f_cmd.value = SEARCH01;
					sheetObj.DoSearch("ESD_TRS_0072GS.do", TrsFrmQryString(formObj));
					break;
				}
				case "EMAIL": {
					formObj.SELECTED_VNDR_SEQ.value = sheetObjects[0].GetCellValue(sheetObjects[0].FindCheckedRow('ibcheck').split('|'), "vndr_seq");
					formObj.SELECTED_CTRL_OFC_CD.value = sheetObjects[0].GetCellValue(sheetObjects[0].FindCheckedRow('ibcheck').split('|'), "ctrl_ofc_cd");
					formObj.SELECTED_LOC_CD.value = sheetObjects[0].GetCellValue(sheetObjects[0].FindCheckedRow('ibcheck').split('|'), "loc_cd");
					formObj.f_cmd.value = SEARCH02;
					sheetObj.DoSearch("ESD_TRS_0072GS.do", TrsFrmQryString(formObj));
					break;
				}
			}
			break;
		case IBSAVE:
			if (sheetObj.RowCount() < 1) {
				ComShowCodeMessage('TRS90387', srcName);
				return false;
			}
			if ( sheetObj.FindCheckedRow('ibcheck') == '') {
				return false;
			}
			if (!validateForm(sheetObj, formObj, IBSAVE, srcName)) {
				return false;
			}
			if (confirm('Are you sure to proceed for ' + srcName + ' ?')) {
				sheetObj.RemoveEtcData();
				formObj.f_cmd.value = MULTI;
				formObj.FAX_EMAIL_INDICATOR.value = srcName;
				/** ** FAX, EMAIL *** */
				// 2015.07.14 CHAN WOO PARK
				var checkListTrs = sheetObj.FindCheckedRow('trs_chk_org');
				var checkArrayTrs = checkListTrs.split('|');
				if (checkArrayTrs == '') {
					sheetObj.DoSave("ESD_TRS_0072GS.do", TrsFrmQryString(formObj), "ibcheck", false);
				} else {
					sheetObj.DoSave("ESD_TRS_0072GS.do", TrsFrmQryString(formObj), "trs_chk_org", false);
				}
			}
			break;
	}
}

/**
 * 
 * @param sheetObj
 * @param errMsg
 */
function sheet2_OnSaveEnd(sheetObj, errMsg) {
	var formObj = document.form;
	if (errMsg != null && errMsg != '') {
		ComShowMessage(errMsg);
	} else {
		if (formObj.f_cmd.value == MULTI) {
			ComShowCodeMessage('COM12116', 'Fax Save');
		}
	}
}

/**
 * 
 * @param sheetObj
 * @param errMsg
 */
function sheet3_OnSaveEnd(sheetObj, errMsg) {
	var formObj = document.form;
	if (errMsg != null && errMsg != '') {
		ComShowMessage(errMsg);
	} else {
		if (formObj.f_cmd.value == MULTI) {
			ComShowCodeMessage('COM12116', 'Email Save');
		}
	}
}

/**
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @param srcName
 * @returns {Boolean}
 */
function validateForm(sheetObj, formObj, sAction, srcName) {
	switch (sAction) {
		case IBSEARCH:
			switch (srcName) {
				case "btn_retrieve1":
					if (formObj.combo_svc_provider.value == "" && formObj.control_office_cd.value == "" && formObj.location_cd.value == "") {
						ComShowCodeMessage('TRS90378');
						return false;
					}
					break;
				case "btn_retrieve2":
					var checkList = sheetObj.FindCheckedRow('ibcheck');
					if (checkList == '') {
						ComShowCodeMessage('TRS90382');
						return false;
					}
					break;
			}
			break;
		case IBSAVE:
			var checkList = sheetObj.FindCheckedRow('trs_chk_org');
			if (checkList == '') { // not selected anything for TRS
				return true;
			} else { // checked more than one for TRS
				var checkArray = checkList.split('|');
				var checkArrayLength = checkArray.length;
				if (checkArrayLength > 3) {  // valid max size is 3
					ComShowCodeMessage('TRS90379', srcName);
					return false;
				}
	
				var col = "";
				if (srcName == "FAX") { // Fax case
					col = sheetObj.SaveNameCol('wo_fax_no');
				} else { // Email case
					col = sheetObj.SaveNameCol('wo_eml');
				}
				
				for ( var i = 0; i < checkArrayLength; i++) {
					if (sheetObj.GetCellValue(checkArray[i], col) == '') {
						ComShowCodeMessage('TRS90381');
						return false;
					}
				}
				
				var checkResult = true;
				for ( var i = 0; i < checkArrayLength; i++) { // looping checked rows
					checkResult = checkSheetEmailValue(sheetObj, checkArray[i], 'wo_eml', sheetObj.GetCellValue(checkArray[i], 'wo_eml')); // check email format & alert
					if(!checkResult) { // wrong email format
						return false; // escape for looping
					}
				}
			}
			break;
	}
	return true;
}


/**
 * Calling rep_commodity pop-up
 */
function com_OnPopupClick(param) {
	var cmdt_cd_val = "";
	var rep_cmdt_cd_val = "";
	var cmdt_desc_val = "";
	var classId = "";
	var xx1 = ""; // CONTI
	var xx2 = ""; // SUB CONTI
	var xx3 = ""; // COUNTRY
	var xx4 = ""; // STATE
	var xx5 = ""; // CONTROL OFFIC
	var xx6 = ""; // LOC CODE
	var xx7 = ""; // LOC NAME
	var xx8 = "";
	var xx9 = "";
	if (param == "service_provider") {
		var param = "?conti_cd=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
		ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 700, 540, "setServiceProvider", '1,0,1,1,1,1,1,1,1,1,1,1', true);
	} else if (param == "control_office") {
		var param = "?returnval=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
		ComOpenPopup('/opuscntr/COM_ENS_071.do' + param, 768, 500, "setControlOffice", '1,0,1,1,1,1,1,1,1,1,1,1', true);
	} else if (param == "location") {
		var param = "?conti_cd=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
		ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 772, 480, "setLocation", '1,0,1,1,1,1,1,1,1,1,1,1', true);
	}
}
/**
 * Service Provider popup
 */
function setServiceProvider(rowArray) {
	formObj = document.form;
	formObj.combo_svc_provider.value = rowArray[0][2];
	formObj.svc_provider.value = rowArray[0][4];
}
/**
 * Control Office popup
 */
function setControlOffice(rowArray) {
	formObj = document.form;
	formObj.control_office_cd.value = rowArray[0][3];
}
/**
 * Location popup
 */
function setLocation(rowArray) {
	formObj = document.form;
	formObj.location_cd.value = rowArray[0][3];
}
/**
 * Resetting the searching option
 */
function resetForm(formObj) {
	formObj.combo_svc_provider.value = "";
	formObj.svc_provider.value = "";
	formObj.control_office_cd.value = "";
	formObj.location_cd.value = ""
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
}

/**
 * 
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet1_OnChange(sheetObj, row, col, value) {
	var formObj = document.form;
	var colName = sheetObj.ColSaveName(col);
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	switch (colName) {
		case 'ibcheck':
			doActionIBSheet(sheetObject2, formObj, IBSEARCH, "FAX");
			doActionIBSheet(sheetObject3, formObj, IBSEARCH, "EMAIL");
			break;
	}
}
/**
 * enter check
 */
function enterCheck(obj) {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	if (event.keyCode == 13) {
		switch (ComGetEvent("name")) {
			case 'combo_svc_provider': {
				getTextVendorSeq(sheetObj, formObj, obj.value);
				break;
			}
		}
	}
}

/**
 * 
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet2_OnChange(sheetObj, row, col, value) {
	var colName = sheetObj.ColSaveName(col);
	var formObj = document.form;
	switch (colName) {
		case 'trs_chk' : {
			sheetObj.SetCellValue(row, 'ibcheck', '1', 0);
			if (sheetObj.GetCellValue(row, colName) == "1") {
				sheetObj.SetCellValue(row, 'trs_chk_org', '1', 0);
			} else {
				sheetObj.SetCellValue(row, 'trs_chk_org', '0', 0);
			}
			break;
		}
		case 'wo_fax_no' : {
			sheetObj.SetCellValue(row, 'ibcheck', '1', 0);
			sheetObj.SetCellValue(row, 'trs_chk', '1', 0);
			sheetObj.SetCellValue(row, 'trs_chk_org', '1', 0);
			break;
		}
	}
}

/**
 * 
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet3_OnChange(sheetObj, row, col, value) {
	var colName = sheetObj.ColSaveName(col);
	var formObj = document.form;
	switch (colName) {
		case 'trs_chk' : 
			sheetObj.SetCellValue(row, 'ibcheck', '1', 0);
			if (sheetObj.GetCellValue(row, colName) == "1") {
				sheetObj.SetCellValue(row, 'trs_chk_org', '1', 0);
			} else {
				sheetObj.SetCellValue(row, 'trs_chk_org', '0', 0);
			}
			break;
		case 'wo_eml' :
			if(checkSheetEmailValue(sheetObj, row, col, value)) {
				sheetObj.SetCellValue(row, 'ibcheck', '1', 0);
				sheetObj.SetCellValue(row, 'trs_chk', '1', 0);
				sheetObj.SetCellValue(row, 'trs_chk_org', '1', 0);
			}
			break;
	}
}
