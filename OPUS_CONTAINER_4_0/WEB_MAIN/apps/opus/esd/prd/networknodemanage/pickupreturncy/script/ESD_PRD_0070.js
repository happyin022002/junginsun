/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName 	 : ESD_PRD_0070.js
 *@FileTitle  : Pick Up CY for Export Booking
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/02
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject1 = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName))
			return false;
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
			case "btn_new":
				formObject.reset();
				sheetObject1.RemoveAll();
				break;
			case "btn_save": {
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
				break;
			}
			case "btn_downexcel":
				if (sheetObject1.RowCount() < 1) {
					ComShowCodeMessage("COM132501");
				} else {
					doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
				}
				break;
			case "btn_loadexcel":
				doActionIBSheet(sheetObject1, formObject, IBLOADEXCEL);
				break;
			case "btng_rowadd":
				doActionIBSheet(sheetObject1, formObject, IBINSERT);
				break;
			case "btn_PorDel":
				selectPort(formObject, 'POL');
				break;
			case "btn_PolPod":
				selectPort(formObject, 'POD');
				break;
			case "btn_Lane":
				selectPort(formObject, 'LANE');
				break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111'));
		} else {
			ComShowMessage(e.message);
		}
	}
}
var portInd = '';
function selectPort(frm, pt) {
	portInd = pt;
	var param = '';
	if (pt == 'POL')
		param = '?loc_cd=' + frm.por_del_cd.value;
	if (pt == 'POD')
		param = '?loc_cd=' + frm.pol_pod_cd.value;
	if (pt == 'LANE')
		param = '?lane_cd=' + frm.vsl_slan_cd.value;
	if (pt == 'POL' || pt == 'POD') {
		ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 520, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	} else if (pt == 'LANE') {
		ComOpenPopup('/opuscntr/COM_ENS_081.do' + param, 800, 410, 'getLane', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	}
}
function getCOM_ENS_051(rArray) {
	var cArray = rArray[0];
	var frm = document.form;
	if (portInd == 'POL') {
		frm.por_del_cd.value = cArray[3];
	}
	if (portInd == 'POD') {
		frm.pol_pod_cd.value = cArray[3];
	}
}
function getLane(rowArray) {
	var colArray = rowArray[0];
	document.all.vsl_slan_cd.value = colArray[3];
	document.all.vsl_slan_cd.focus();
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
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
	axon_event.addListener('keypress', 'PrdComKeyEnter', 'por_del_cd', 'pol_pod_cd', 'vsl_slan_cd');
}
/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    switch (sheetObj.id) {
	    case "sheet1": {
	        with(sheetObj) {       
				     var HeadTitle1="NO.|STS|Del|POR/DEL|POL/POD(Port)|Lane|Bound|Cargo Type|Container|Container|Pick Up CY";
				     var HeadTitle2="NO.|STS|Del|POR/DEL|POL/POD(Port)|Lane|Bound|Cargo Type|Type|Size|Pick Up CY";
				     var headCount=ComCountHeadTitle(HeadTitle1);
				     (headCount, 0, 0, true);
				     SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				     var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				     var headers = [ { Text:HeadTitle1, Align:"Center"},  { Text:HeadTitle2, Align:"Center"}  ];
				     InitHeaders(headers, info);		
				     var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                  {Type:"Status",    Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                  {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                  {Type:"PopupEdit", Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"por_del_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
					              {Type:"PopupEdit", Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"pol_pod_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
					              {Type:"PopupEdit", Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"vsl_slan_cd", KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
					              {Type:"Combo",     Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"io_bnd_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					              {Type:"Combo",     Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_cd", KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					              {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					              {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_sz_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					              {Type:"PopupEdit", Hidden:0, Width:160,  Align:"Center",  ColMerge:1,   SaveName:"mty_pkup_rtn_yd_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 } ];
				      
				     InitColumns(cols);
				     SetEditable(1);
				     SetColProperty(0 ,"por_del_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
				     SetColProperty(0 ,"pol_pod_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
				     SetColProperty(0 ,"vsl_slan_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
				     SetColProperty(0, "io_bnd_cd", {ComboText:"Out|In", ComboCode:"O|I"} );
				     SetColProperty(0, "spcl_cgo_cd", {ComboText:"ALL|Dry|Reefer|DG", ComboCode:"AL|DR|RF|DG"} );
				     SetColProperty(0 ,"mty_pkup_rtn_yd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
				     SetColProperty(0 ,"cntr_tp_cd" , {ComboText:"AL|D|R|O|F|T|Q", ComboCode:"AL|D|R|O|F|T|Q"} );
				     SetColProperty(0 ,"cntr_sz_cd" , {ComboText:"AL|2|4|5|7|8|3", ComboCode:"AL|2|4|5|7|8|3"} );
				     SetHeaderRowHeight(20);
				     ComResizeSheet(sheetObj);
			     }
	        break;
	    }
    }
}

// handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH: {
			if (validateForm(sheetObj, formObj, sAction)) {
				if (sheetObj.id == "sheet1") {
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("ESD_PRD_0070GS.do", PrdFQString(formObj), { Sync : 2 });
				}
			}
			break;
		}
		case IBSAVE: {
			if (validateForm(sheetObj, formObj, sAction)) {
				if (!chkDupRow(sheetObj)) {
					return false;
				}
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESD_PRD_0070GS.do", {Param : "f_cmd=" + MULTI});
			}
			break;
		}
		case IBINSERT: {
			var Row = sheetObj.DataInsert();
			sheetObj.SetCellValue(Row, "vsl_slan_cd", "ALL", 0);
			sheetObj.SetCellValue(Row, "spcl_cgo_cd", "AL", 0);
			break;
		}
		case IBLOADEXCEL: {
			sheetObj.LoadExcel({Mode:"HeaderMatch", WorkSheetNo :1});
			break;
		}
		case IBDOWNEXCEL: {
			sheetObj.Down2Excel({ DownCols : makeHiddenSkipCol(sheetObj), SheetDesign : 1, Merge : 1 });
			break;
		}
	}
}

/**
 * 
 * @param sheetObj
 * @param errCode
 * @param errMsg
 */
function sheet1_OnSaveEnd(sheetObj, errCode, errMsg) {
	if (errCode >= 0) {
		if (document.form.f_cmd.value == MULTI) {
			document.form.f_cmd.value = "";
			doActionIBSheet(sheetObj, document.form, IBSEARCH);
		}
	}
}

/**
 * Sheet OnLoadExcel Event
 * 
 * @param sheetObj
 * @param result
 * @param code
 * @param msg
 */
function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
	if (isExceedMaxRow(msg)) {
		return;
	}
}

/**
 * sheet1 OnChange
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @returns {Boolean}
 */
function sheet1_OnChange(sheetObj, Row, Col, Value, OldValue, RaiseFlag) {
	var validation_flag = false;
	var colNm = sheetObj.ColSaveName(Col);
	if (colNm == 'por_del_cd' || colNm == 'pol_pod_cd') {
		if (Value.length < 5) {
			sheetObj.SetCellValue(Row, Col, "", 0);
			return false;
		}
	} else if (colNm == 'vsl_slan_cd') {
		if (Value.length < 3) {
			sheetObj.SetCellValue(Row, Col, "", 0);
			return false;
		}
	} else if (colNm == 'mty_pkup_rtn_yd_cd') {
		if (Value.length < 7) {
			sheetObj.SetCellValue(Row, Col, "", 0);
			return false;
		}
	}
	
	if(colNm == 'cntr_tp_cd') {
		if(Value == 'AL') {
			sheetObj.SetCellValue(Row, "cntr_sz_cd", "AL", 0);
			return false;
		} else {
			sheetObj.SetCellValue(Row, "cntr_sz_cd", "2", 0);
			return false;
		}
		return false;
	}
	if(colNm == 'cntr_sz_cd') {
		var cntrtp = sheetObj.GetCellValue(Row, "cntr_tp_cd");
		if(Value == 'AL') {
			sheetObj.SetCellValue(Row, "cntr_tp_cd", "AL", 0);
			return false;
		} else {
			if(cntrtp == 'AL') {
				sheetObj.SetCellValue(Row, Col, "AL", 0);
				return false;
			}
		}
		return false;
	}

	if ((colNm == "por_del_cd") && Value.length >= 5) {
		document.form.f_cmd.value = SEARCH02;
		validation_flag = true;
	} else if ((colNm == "pol_pod_cd") && Value.length >= 5) {
		document.form.f_cmd.value = SEARCH02;
		validation_flag = true;
	} else if ((colNm == "vsl_slan_cd") && Value.length >= 3) {
		if (sheetObj.GetCellValue(Row, Col) != "ALL") {
			document.form.f_cmd.value = SEARCH07;
			validation_flag = true;
		}
	} else if ((colNm == "mty_pkup_rtn_yd_cd") && Value.length >= 7) {
		document.form.f_cmd.value = SEARCH05;
		validation_flag = true;
	}
	if (validation_flag) {
		var sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=ESD_PRD_0070&check_data=" + Value + "&" + PrdFQString(document.form));
		var retCount = ComGetEtcData(sXml, "rowCount");
		if (retCount == "" || retCount < 1) {
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.ColSaveName(Col), "", 0);
			sheetObj.SelectCell(Row, Col);
		}
		return false;
	}
	if (sheetObj.ColSaveName(Col) == "delt_flg") {
		if (sheetObj.GetRowStatus(Row) == 'I') {
			sheetObj.RowDelete(Row, false);
		}
		return false;
	}
	return false;
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	if (!ComChkValid(formObj)) {
		return false;
	}
	return true;
}
function sheet1_OnPopupClick(sheetObj, row, col) {
	var param;
	var tml_cd;
	if (sheetObj.ColSaveName(col) == "por_del_cd") {
		param = '?loc_cd=' + sheetObj.GetCellValue(row, col);
		ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 550, 'getLocGrid', '1,0,1,1,1,1,1,1,1,1,1,1', true, false, row, col);
	} else if (sheetObj.ColSaveName(col) == "pol_pod_cd") {
		param = '?loc_cd=' + sheetObj.GetCellValue(row, col);
		ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 550, 'getLocGrid', '1,0,1,1,1,1,1,1,1,1,1,1', true, false, row, col);
	} else if (sheetObj.ColSaveName(col) == "vsl_slan_cd") {
		var lane_cd = ""
		if (sheetObj.GetCellValue(row, col) != "ALL") {
			lane_cd = sheetObj.GetCellValue(row, col);
		}
		param = '?&lane_cd=' + lane_cd;
		ComOpenPopup('/opuscntr/COM_ENS_081.do' + param, 770, 470, 'getPop2Grid', "1,0,1,1,1,1,1,1,1,1,1,1", true, true, row, col);
	} else if (sheetObj.ColSaveName(col) == "mty_pkup_rtn_yd_cd") {
		tml_cd = sheetObj.GetCellValue(row, col);
		param = '?&node_cd=' + tml_cd;
		ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 810, 550, 'getPop2Grid', "1,0,1,1,1,1,1,1,1,1,1,1", true, true, row, col);
	}
}
function getLocGrid(rowArray, row, col) {
	var sheetObj = sheetObjects[0];
	var colArray = rowArray[0];
	if (sheetObj.ColSaveName(col) == "por_del_cd") {
		sheetObj.SetCellValue(row, "por_del_cd", colArray[3], 0);
	} else if (sheetObj.ColSaveName(col) == "pol_pod_cd") {
		sheetObj.SetCellValue(row, "pol_pod_cd", colArray[3], 0);
	} else if (sheetObj.ColSaveName(col) == "mty_pkup_rtn_yd_cd") {
		sheetObj.SetCellValue(row, "mty_pkup_rtn_yd_cd", colArray[3], 0);
	}
}
function getPop2Grid(rowArray, row, col) {
	var sheetObj = sheetObjects[0];
	var colArray = rowArray[0];
	if (sheetObj.ColSaveName(col) == "vsl_slan_cd") {
		sheetObj.SetCellValue(row, "vsl_slan_cd", colArray[3], 0);
	} else if (sheetObj.ColSaveName(col) == "mty_pkup_rtn_yd_cd") {
		sheetObj.SetCellValue(row, "mty_pkup_rtn_yd_cd", colArray[3], 0);
	}
	sheet1_OnChange(sheetObj, row, col, colArray[3])
}

/**
 * 
 * @param sheetObj
 * @returns {Boolean}
 */
function chkDupRow(sheetObj) {
	var Rows = sheetObj.ColValueDupRows("por_del_cd|pol_pod_cd|vsl_slan_cd|spcl_cgo_cd|io_bnd_cd|cntr_tp_cd|cntr_sz_cd");
	var arr_rows = null;
	if (Rows != null && Rows.trim() != '') {
		arr_rows = Rows.split(',');
	}
	for ( var i = 0; arr_rows != null && i < arr_rows.length; i++) {
		sheetObj.SetRowFontColor(arr_rows[i], "#FF0000");
	}
	if (Rows != null && Rows.trim() != '') {
		ComShowMessage("PRD90072");
		return false;
	} else {
		return true;
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
	var ColName = sheetObj.ColSaveName(Col) ;
	if(ColName == 'cntr_tp_cd' || ColName == 'cntr_sz_cd') {
		var cntrTp = sheetObj.GetCellValue(Row, "cntr_tp_cd");
		var cntrSz = sheetObj.GetCellValue(Row, "cntr_sz_cd");
		if((cntrTp == 'AL' && cntrSz != 'AL')  || (cntrTp != 'AL' && cntrSz == 'AL')) {
			ComShowCodeMessage("PRD00087");
			sheetObj.ValidateFail(1);
			sheetObj.SetSelectRow(Row);
		}
	}
}