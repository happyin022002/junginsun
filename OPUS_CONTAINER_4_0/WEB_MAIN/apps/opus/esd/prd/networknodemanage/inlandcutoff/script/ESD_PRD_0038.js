/* =========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName 	 : ESD_PRD_0036.js
 *@FileTitle  : CCT Management by Yard for Export Booking 
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/22 
=========================================================*/
// Common global variable
var sheetObjects = new Array();
var comboObjects=new Array();
var sheetCnt = 0;
var comboCnt = 0;

document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName)) {
			return false;
		}
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;
			case "btn_new": {
				formObject.reset();
				sheetObject.RemoveAll();
				comboObjects[0].SetSelectCode("AL");
				break;
			}
			case "btn_save": {
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
			}
			case "btng_rowadd": {
				doActionIBSheet(sheetObject, formObject, IBINSERT);
				break;
			}
			case "btng_rowcopy": {
				doActionIBSheet(sheetObject, formObject, IBCOPYROW);
				break;
			}
			case "btn_s_dt": {
				var cal = new ComCalendar();
				cal.select(formObject.eff_fm_dt, 'yyyy-MM-dd');
				break;
			}
			case "btn_lane_cd": {
				ComOpenPopup('/opuscntr/COM_ENS_081.do?vsl_slan_cd=', 850, 420, 'getLane', '1,0,1,1,1,1,1,1,1,1,1,1', true, false);
				break;
			}
			case "btn_org_yd": {
				var param = "?node_cd=&mode_only=Y&mode=yard";
				ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 850, 500, 'getYard1', '1,0,1,1,1,1,1,1,1,1,1,1', true, false);
				break;
			}
			case "btn_dest_yd": {
				var param = "?node_cd=&mode_only=Y&mode=yard";
				ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 850, 500, 'getYard2', '1,0,1,1,1,1,1,1,1,1,1,1', true, false);
				break;
			}
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111'));
		} else {
			ComShowMessage(e.message);
		}
	}
}

function getLane(rowArray) {
	var colArray = rowArray[0];
	document.form.lane_cd.value = colArray[3];
}
function getYard1(rowArray) {
	var colArray = rowArray[0];
	document.form.org_yd_cd.value = colArray[3];
}
function getYard2(rowArray) {
	var colArray = rowArray[0];
	document.form.dest_yd_cd.value = colArray[3];	
}

/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
function setComboObject(combo_obj){          
    comboObjects[comboCnt++]=combo_obj;
 }
/**
 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
 */
function loadPage() {
	var formObj = document.form;
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	setSpclCgoCntrTpCdCombo(comboObjects[0]);
}

function setSpclCgoCntrTpCdCombo(comObject) {
	 var codeArray = spcl_cgo_cntr_tp_cdCode.split("|");
	 var textArray = spcl_cgo_cntr_tp_cdText.split("|");
	 comObject.RemoveAll();
	 comObject.InsertItem(0, "", "");
	 comObject.InsertItem(1, "ALL", "AL");
	  for(var i = 0; i < codeArray.length; i++) {
		  comObject.InsertItem(i+2, textArray[i] , codeArray[i] );
	  }
	  comObject.SetSelectCode("");
}

/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */

function initSheet(sheetObj, sheetNo) {
	switch (sheetNo) {
		case 1: {
			with (sheetObj) {
				var HeadTitle = "SEQ|STS|Del|Lane\nCode|Cargo\nNature|Gate in/out at the Port by|Cut Off|Cut Off|Priority|Origin Yard|DEST Yard|Avaliability|Avaliability|Avaliability|Frequency\n(Daily/ Weekly)|Weekly\nInterval|Departure Day Pattern|Departure Day Pattern|Departure Day Pattern|Departure Day Pattern|Departure Day Pattern|Departure Day Pattern|Departure Day Pattern|Effective Date|Expiry Date";
				var HeadTitle1 = "SEQ|STS|Del|Lane\nCode|Cargo\nNature|Gate in/out at the Port by|Day|Time|Priority|Origin Yard|DEST Yard|Week|Day|Time|Frequency\n(Daily/ Weekly)|Weekly\nInterval|SUN|MON|TUE|WED|THU|FRI|SAT|Effective Date|Expiry Date";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
				var headers = [{ Text : HeadTitle, Align : "Center" }, { Text : HeadTitle1, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "Seq", 		Hidden : 0, Width : 30, 	Align : "Center", 	ColMerge : 1, SaveName : "", 							KeyField : 0, CalcLogic : "", Format : "", 		PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Status", 		Hidden : 0, Width : 30, 	Align : "Center", 	ColMerge : 1, SaveName : "ibflag", 						KeyField : 0, CalcLogic : "", Format : "", 		PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "DelCheck", 	Hidden : 0, Width : 30, 	Align : "Center", 	ColMerge : 1, SaveName : "del_flag", 					KeyField : 0, CalcLogic : "", Format : "", 		PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "PopupEdit", 	Hidden : 0, Width : 60,  	Align : "Center", 	ColMerge : 1, SaveName : "lane_cd", 					KeyField : 1, CalcLogic : "", Format : "", 		PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 3 },
						{ Type : "Combo", 		Hidden : 0, Width : 150,  	Align : "Center", 	ColMerge : 1, SaveName : "spcl_cgo_cntr_tp_cd", 		KeyField : 1, CalcLogic : "", Format : "", 		PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Combo", 		Hidden : 0, Width : 130, 	Align : "Center", 	ColMerge : 1, SaveName : "inlnd_cct_tp_cd", 			KeyField : 0, CalcLogic : "", Format : "", 		PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Combo", 		Hidden : 0, Width : 50,  	Align : "Center", 	ColMerge : 1, SaveName : "cct_dy_cd", 					KeyField : 0, CalcLogic : "", Format : "", 		PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", 		Hidden : 0, Width : 50,  	Align : "Center", 	ColMerge : 1, SaveName : "cgo_clz_hrmnt", 				KeyField : 0, CalcLogic : "", Format : "Hm", 	PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", 		Hidden : 0, Width : 80,  	Align : "Center", 	ColMerge : 1, SaveName : "prio_seq", 					KeyField : 1, CalcLogic : "", Format : "", 		PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 3 },
						{ Type : "PopupEdit", 	Hidden : 0, Width : 90,  	Align : "Center", 	ColMerge : 1, SaveName : "org_yd_cd", 					KeyField : 1, CalcLogic : "", Format : "", 		PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 7 },
						{ Type : "PopupEdit", 	Hidden : 0, Width : 90,  	Align : "Center", 	ColMerge : 1, SaveName : "dest_yd_cd", 					KeyField : 1, CalcLogic : "", Format : "", 		PointCount : 0, UpdateEdit : 0, InsertEdit : 1, EditLen : 7 },
						{ Type : "Text", 		Hidden : 0, Width : 50,  	Align : "Center", 	ColMerge : 1, SaveName : "aval_wk_no", 					KeyField : 0, CalcLogic : "", Format : "", 		PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 1 },
						{ Type : "Combo", 		Hidden : 0, Width : 50,  	Align : "Center", 	ColMerge : 1, SaveName : "aval_dy_cd", 					KeyField : 0, CalcLogic : "", Format : "", 		PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", 		Hidden : 0, Width : 50,  	Align : "Center", 	ColMerge : 1, SaveName : "aval_hrmnt", 					KeyField : 0, CalcLogic : "", Format : "Hm", 	PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Combo", 		Hidden : 0, Width : 100,  	Align : "Center", 	ColMerge : 1, SaveName : "inlnd_trsp_freq_cd", 			KeyField : 0, CalcLogic : "", Format : "", 		PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Text", 		Hidden : 0, Width : 60, 	Align : "Center", 	ColMerge : 1, SaveName : "inlnd_trsp_wk_itval_no", 		KeyField : 0, CalcLogic : "", Format : "", 		PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 1 },
						{ Type : "CheckBox", 	Hidden : 0, Width : 40, 	Align : "Left", 	ColMerge : 1, SaveName : "sun_st_flg", 					KeyField : 0, CalcLogic : "", Format : "", 		PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "CheckBox", 	Hidden : 0, Width : 40, 	Align : "Left", 	ColMerge : 1, SaveName : "mon_st_flg", 					KeyField : 0, CalcLogic : "", Format : "", 		PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "CheckBox", 	Hidden : 0, Width : 40, 	Align : "Left", 	ColMerge : 1, SaveName : "tue_st_flg", 					KeyField : 0, CalcLogic : "", Format : "", 		PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "CheckBox", 	Hidden : 0, Width : 40, 	Align : "Left", 	ColMerge : 1, SaveName : "wed_st_flg", 					KeyField : 0, CalcLogic : "", Format : "", 		PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "CheckBox", 	Hidden : 0, Width : 40, 	Align : "Left", 	ColMerge : 1, SaveName : "thu_st_flg", 					KeyField : 0, CalcLogic : "", Format : "", 		PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "CheckBox", 	Hidden : 0, Width : 40, 	Align : "Left", 	ColMerge : 1, SaveName : "fri_st_flg", 					KeyField : 0, CalcLogic : "", Format : "", 		PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "CheckBox", 	Hidden : 0, Width : 40, 	Align : "Left", 	ColMerge : 1, SaveName : "sat_st_flg", 					KeyField : 0, CalcLogic : "", Format : "", 		PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
						{ Type : "Date", 		Hidden : 0, Width : 100,  	Align : "Center", 	ColMerge : 1, SaveName : "eff_fm_dt", 					KeyField : 1, CalcLogic : "", Format : "Ymd", 	PointCount : 0, UpdateEdit : 0, InsertEdit : 1 },
						{ Type : "Date", 		Hidden : 0, Width : 100,  	Align : "Center", 	ColMerge : 1, SaveName : "eff_to_dt", 					KeyField : 1, CalcLogic : "", Format : "Ymd", 	PointCount : 0, UpdateEdit : 0, InsertEdit : 1 }
				];
				InitColumns(cols);
				SetColProperty(0, "spcl_cgo_cntr_tp_cd", 	{ ComboText : "ALL|" + spcl_cgo_cntr_tp_cdText, ComboCode : "AL|" + spcl_cgo_cntr_tp_cdCode });
				SetColProperty(0, "inlnd_cct_tp_cd",     	{ ComboText : inlnd_cct_tp_cdText, ComboCode : inlnd_cct_tp_cdCode });
				SetColProperty(0, "cct_dy_cd",     		 	{ ComboText : cct_dy_cdText, ComboCode : cct_dy_cdCode });
				SetColProperty(0, "aval_dy_cd",     	 	{ ComboText : cct_dy_cdText, ComboCode : cct_dy_cdCode });
				SetColProperty(0, "lane_cd", 			 	{ AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "prio_seq", 			 	{ AcceptKeys : "[AL]|N", InputCaseSensitive : 1 });
				SetColProperty(0, "org_yd_cd", 			 	{ AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "dest_yd_cd", 		 	{ AcceptKeys : "E|N", InputCaseSensitive : 1 });
				SetColProperty(0, "inlnd_trsp_freq_cd",  	{ ComboText : "Weekly|Daily", ComboCode : "W|D"});
				SetColProperty(0, "aval_wk_no", 		 	{ AcceptKeys : "N"});
				SetColProperty(0, "inlnd_trsp_wk_itval_no", { AcceptKeys : "N"});
				SetEditable(1);
				SetVisible(true);
				ComResizeSheet(sheetObj);
			}
			break;
		}
	}
}

// handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction, param) {
	var rsltFlg = true;
	switch (sAction) {
		case IBSEARCH: {
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESD_PRD_0038GS.do", PrdFQString(formObj));
			break;
		}
		case IBSAVE: {
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESD_PRD_0038GS.do", { Param : "f_cmd="+MULTI, Quest : 0 });
			break;
		}
		case COMMAND01: {
			formObj.f_cmd.value = COMMAND01;
			var valid = ComSearchEtcData(sheetObj, "ESD_PRD_0038GS.do?" + param,"f_cmd="+COMMAND01, 'valid');
			if(valid == "1") {
				rsltFlg = false;
			}
			break;
		}
		case IBINSERT: {
			var ro = sheetObj.DataInsert();
			sheetObj.SetCellValue(ro, "inlnd_trsp_freq_cd", "W", 0);
			sheetObj.SetCellValue(ro, "eff_fm_dt", "19700101", 0);
			sheetObj.SetCellValue(ro, "eff_to_dt", "29991231", 0);
			sheetObj.SetCellValue(ro, "prio_seq", "ALL", 0);
			break;
		}
		case IBCOPYROW: {
			var ro = sheetObj.DataCopy();
			sheetObj.SetCellValue(ro, "eff_fm_dt", "19700101", 0);
			sheetObj.SetCellValue(ro, "eff_to_dt", "29991231", 0);
			sheetObj.SetCellValue(ro, "prio_seq", "ALL", 0);
			break;
		}
	}
	return rsltFlg;
}

/**
 * OnPopupClick 
 * @param sheetObj
 * @param Row
 * @param Col
 */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
	var param;
	switch(sheetObj.ColSaveName(Col)) {
		case "org_yd_cd":
		case "dest_yd_cd":
			param = '?node_cd=' + sheetObj.GetCellValue(Row, Col)+ "&mode_only=Y&mode=yard";
			ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 850, 500, 'getYardGrid', '1,0,1,1,1,1,1,1,1,1,1,1', true, false, Row, Col);
			break;
		case "lane_cd" :
			param = '?vsl_slan_cd=' + sheetObj.GetCellValue(Row, Col);
			ComOpenPopup('/opuscntr/COM_ENS_081.do' + param, 850, 420, 'getLaneGrid', '1,0,1,1,1,1,1,1,1,1,1,1', true, false, Row, Col);
			break;
	}
}

/**
 * OnRowSearchEnd
 * @param sheetObj
 * @param Row
 */
function sheet1_OnRowSearchEnd (sheetObj, Row) { 
	if(sheetObj.GetCellValue(Row, 'inlnd_trsp_freq_cd') == 'D') {
		sheetObj.SetCellEditable(Row, 'inlnd_trsp_wk_itval_no', false);
	}
}


/**
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 */
function sheet1_OnChange(sheetObj, Row, Col, Value, OldValue) {
	var colName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	if(colName == "inlnd_trsp_freq_cd") {
		if(Value == 'D') {
			sheetObj.SetCellValue(Row, "inlnd_trsp_wk_itval_no", "", 0);
			sheetObj.SetCellEditable(Row, 'inlnd_trsp_wk_itval_no', false);
			sheetObj.SetCellValue(Row, "sun_st_flg", "1", 0);
			sheetObj.SetCellValue(Row, "mon_st_flg", "1", 0);
			sheetObj.SetCellValue(Row, "tue_st_flg", "1", 0);
			sheetObj.SetCellValue(Row, "wed_st_flg", "1", 0);
			sheetObj.SetCellValue(Row, "thu_st_flg", "1", 0);
			sheetObj.SetCellValue(Row, "fri_st_flg", "1", 0);
			sheetObj.SetCellValue(Row, "sat_st_flg", "1", 0);
		} else {
			sheetObj.SetCellEditable(Row, 'inlnd_trsp_wk_itval_no', true);
			sheetObj.SetCellValue(Row, "inlnd_trsp_wk_itval_no", "1", 0);
		}
		return true;
	} else if(colName == "org_yd_cd" || colName == "dest_yd_cd" || colName == "lane_cd" ||  colName == "eff_fm_dt" || colName == "eff_to_dt" || colName == "spcl_cgo_cntr_tp_cd") {
		var sOrgYdCd = sheetObj.GetCellValue(Row, "org_yd_cd");
		var sDestYdCd = sheetObj.GetCellValue(Row, "dest_yd_cd");
		var sSpclCgoCntrTpCd = sheetObj.GetCellValue(Row, "spcl_cgo_cntr_tp_cd");
		var sLaneCd = sheetObj.GetCellValue(Row, "lane_cd");
		var sEffFmDt = sheetObj.GetCellValue(Row, "eff_fm_dt");
		var sEffToDt = sheetObj.GetCellValue(Row, "eff_to_dt");
		if(colName == "org_yd_cd" || colName == "dest_yd_cd") {
			formObj.f_cmd.value = SEARCH04;
			var sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=ESD_PRD_0038" + "&check_data=" + Value + "&" + PrdFQString(formObj));
			if (ComGetEtcData(sXml, "rowCount") < 1) {
				sheetObj.SetCellValue(Row, Col, "", 0);
			}
		}
		if(colName == "lane_cd") {
			if(Value != 'ALL') {
				formObj.f_cmd.value = SEARCH07;
				var sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=ESD_PRD_0038&check_data=" + Value + "&" + PrdFQString(formObj));
				if(ComGetStrEtcData(sXml, "rowCount") < 1) {
					sheetObj.SetCellValue(Row, Col, "", 0);
				}
			}
		}
		if(!ComIsNull(sLaneCd) && !ComIsNull(sOrgYdCd) && !ComIsNull(sDestYdCd) && !ComIsNull(sEffFmDt) && !ComIsNull(sEffToDt) && !ComIsNull(sSpclCgoCntrTpCd)) {
			var param = "lane_cd=" + sLaneCd + "&org_yd_cd=" + sOrgYdCd + "&dest_yd_cd=" + sDestYdCd + "&spcl_cgo_cntr_tp_cd=" + sSpclCgoCntrTpCd  + "&eff_fm_dt=" + sEffFmDt + "&eff_to_dt=" + sEffToDt; 
			var rslt = doActionIBSheet(sheetObj, formObj, COMMAND01,  param)
			if(!rslt) {
				ComShowCodeMessage('PRD00089');
				sheetObj.SetCellValue(Row, "eff_fm_dt", "", 0);
				sheetObj.SetCellValue(Row, "eff_to_dt", "", 0);
				return false;
			}
		}
		return true;
	} else if(colName == "inlnd_cct_tp_cd") {
		if(Value == "ETD" || Value == "PAV") {
			sheetObj.SetCellValue(Row, "inlnd_cct_tp_cd", OldValue, 0);
			return false;
		}
		return true;
	}else if(colName == "prio_seq"){
		if(Value == "ALL"){
			return true
		}else if(parseInt(Value) > 0 && parseInt(Value) < 100 ){
			return true
		}else{
			ComShowCodeMessage('COM12138', "'ALL'", "any number (1-99)");
			return false
		}
			
	}
}

/**
 * 
 * @param sheetObj
 * @param Code
 * @param Msg
 * @param StCode
 * @param StMsg
 */
function sheet1_OnSaveEnd(sheetObj, errCode, errMsg) {
	var formObj = document.form;
	if (errCode >= 0) {
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
		ComShowCodeMessage('COM132601');
	} 
}

/**
 * 
 * @param rowArray
 * @param Row
 * @param Col
 */
function getYardGrid(rowArray, Row, Col) {
	var sheetObj = sheetObjects[0];
	var colArray = rowArray[0];
	sheetObj.SetCellValue(Row, Col, colArray[3], 0);
}

/**
 * 
 * @param rowArray
 * @param Row
 * @param Col
 */
function getLaneGrid(rowArray, Row, Col) {
	var sheetObj = sheetObjects[0];
	var colArray = rowArray[0];
	if (sheetObj.ColSaveName(Col) == "lane_cd") {
		sheetObj.SetCellValue(Row, "lane_cd", colArray[3], 0);
	}
}

/**
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 */
function sheet1_OnValidation(sheetObj, Row, Col, Value) {
	if(sheetObj.GetCellValue(Row, 'ibflag') != 'D') {
		switch(sheetObj.ColSaveName(Col)) {
			case "cgo_clz_hrmnt" :  {
				if(ComIsNull(Value)) {
					ComShowCodeMessage('COM130201', "Cut Off Time");
					sheetObj.ValidateFail(1);
					sheetObj.SelectCell(Row, Col);
				}
				break;
			}
			case "aval_hrmnt" :  {
				if(ComIsNull(Value)) {
					ComShowCodeMessage('COM130201', "Avaliability Time");
					sheetObj.ValidateFail(1);
					sheetObj.SelectCell(Row, Col);
				}
				break;
			}
			case "inlnd_trsp_freq_cd" :  {
				if(Value == 'W') {
					if(ComIsNull(sheetObj.GetCellValue(Row, 'inlnd_trsp_wk_itval_no'))) {
						ComShowCodeMessage('COM130201', "Weekly Interval");
						sheetObj.ValidateFail(1);
						sheetObj.SelectCell(Row, Col);
					}
				}
				break;
			}
			case "cct_dy_cd" :  {
				if(sheetObj.GetCellValue(Row, 'sun_st_flg') == 1 && Value == 'SUN') {
					break;
				}
				if(sheetObj.GetCellValue(Row, 'mon_st_flg') == 1 && Value == 'MON') {
					break;	
				}
				if(sheetObj.GetCellValue(Row, 'tue_st_flg') == 1 && Value == 'TUE') {
					break;	
				}
				if(sheetObj.GetCellValue(Row, 'wed_st_flg') == 1 && Value == 'WED') {
					break;	
				}
				if(sheetObj.GetCellValue(Row, 'thu_st_flg') == 1 && Value == 'THU') {
					break;
				}
				if(sheetObj.GetCellValue(Row, 'fri_st_flg') == 1 && Value == 'FRI') {
					break;
				}
				if(sheetObj.GetCellValue(Row, 'sat_st_flg') == 1 && Value == 'SAT') {
					break;
				}
				ComShowCodeMessage('PRD00090');
				sheetObj.ValidateFail(1);
				sheetObj.SelectCell(Row, Col);
				break;
			}
		}
	}
}