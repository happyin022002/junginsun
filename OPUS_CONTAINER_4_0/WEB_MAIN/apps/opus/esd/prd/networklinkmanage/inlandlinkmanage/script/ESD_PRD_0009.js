/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESD_PRD_0009.js
 *@FileTitle : TEST
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0 
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;
var validateData = "";
var retValidate = 0;
var comData1 = "";
var isDoor;

document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var formObject = document.form;
	var dispaly;
	var classId;
	var param;
	var chkStr;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_retrieve":
				if (!checkInput())
					return false;
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;
			case "btn_new":
				sheetObject.RemoveAll();
				formObject.reset();
				break;
			case "btn_save":
				if (delFlagCheck(sheetObject)) {
					if (!confirm(ComGetMsg('PRD90044'))) {
						break;
					}
				}
				if (!checkMandatory())
					return;
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
			case "btn_update":
				doActionIBSheet(sheetObject, formObject, MODIFY01);
				break;
			case "btn_downexcel":
				if (sheetObject.RowCount() < 1) {// no data
					ComShowCodeMessage("COM132501");
				} else {
					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
				}
				break;
			case "btn_loadexcel":
				doActionIBSheet(sheetObject, formObject, IBLOADEXCEL);
				break;
			case "btng_rowadd":
				doActionIBSheet(sheetObject, formObject, IBINSERT);
				break;
			case "btng_rowcopy":
				doActionIBSheet(sheetObject, formObject, IBCOPYROW);
				break;
			case "btn_org_loc":
				selectNode(formObject, 'ORG');
				break;
			case "btn_dest_loc":
				selectNode(formObject, 'DEST');
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(ComGetMsg('PRD90054'));
		} else {
			ComShowMessage(e);
		}
	}
}
var portInd = '';
function selectNode(frm, org_dest) {
	var param = '?loc_port_ind=1';
	portInd = org_dest;
	if (portInd == 'ORG') {
		param = param + '&node_cd=' + frm.i_org_cd.value;
	}
	if (portInd == 'DEST') {
		param = param + '&node_cd=' + frm.i_dest_cd.value;
	}
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 810, 550, 'getNodeCd', "1,0,1,1,1,1,1,1,1,1,1,1", true);
}
function getNodeCd(rowArray) {
	var colArray = rowArray[0];
	if (portInd == 'ORG') {
		document.all.i_org_cd.value = colArray[3];
	}
	if (portInd == 'DEST') {
		document.all.i_dest_cd.value = colArray[3];
	}
}
function delFlagCheck(sheetObj) {
	var sRow = sheetObj.FindStatusRow("D");
	var arRow = sRow.split(";");
	if (arRow.length > 1) {
		return true;
	} else {
		return false;
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
	axon_event.addListener('keypress', 'PrdComKeyEnter', 'i_org_cd', 'i_dest_cd', 'i_agmt_no');
	axon_event.addListenerForm('change', 'form_onChange', form);
	ComSetUIItem(sheetObjects[0], document.form, 'PRD', 'ESD_PRD_0009');
	itemControl(sheetObjects[0], document.form, '');
}

function form_onChange(evt, el) {
	var formObj = document.form;
	var xml = "";
	var srcName;
	var srcValue;
	if (el) {
		srcName = el.getAttribute("name");
		srcValue = el.getAttribute("value");
	} else {
		srcName = ComGetEvent("name");
		srcValue = ComGetEvent("value");
	}
	if (srcName == "i_org_cd") {
		if (eval('document.form.' + srcName + '.value').length == 5) {
			inputChkUpper(ComGetEvent(), 0, 'SEARCH02');
		} else if (eval('document.form.' + srcName + '.value').length == 7) {
			inputChkUpper(ComGetEvent(), 0, 'SEARCH04');
		}
	} else if (srcName == "i_dest_cd") {
		if (eval('document.form.' + srcName + '.value').length == 5) {
			inputChkUpper(ComGetEvent(), 0, 'SEARCH02');
		} else if (eval('document.form.' + srcName + '.value').length == 7) {
			inputChkUpper(ComGetEvent(), 0, 'SEARCH04');
		}
	}
}

/**
 * handling tab event
 * 
 * @return
 */
function prdComKeyDown() {
	var keyObj = ComGetEvent("keycode");
	if (keyObj == 9) {
		var srcName = ComGetEvent("name");
		if (eval('document.form.' + srcName + '.value').length == 5) {
			inputChkUpper(ComGetEvent(), keyObj, 'SEARCH02');
		} else if (eval('document.form.' + srcName + '.value').length == 7) {
			inputChkUpper(ComGetEvent(), keyObj, 'SEARCH04');
		}
	}
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:   
            with(sheetObj){
        	      var HeadTitle="Del.|CHK|STS|SEQ|From Node|From Node|To Node|To Node|Mode|S/P Name|S/P Name|Agmt No|Reference No|T/T\n(DD.HH)|Distance|UOM||||||||||UPDATE RESULT|MSG|fc" ;

        	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

        	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
        	      InitHeaders(headers, info);
        	      var cols = [ 
	        	             {Type:"DelCheck",  Hidden:0, 	Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	        	             {Type:"CheckBox",  Hidden:0, 	Width:30,   Align:"Center",  ColMerge:0,   SaveName:"agmt_chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	        	             {Type:"Status",    Hidden:0, 	Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Seq",       Hidden:0, 	Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"PopupEdit", Hidden:0, 	Width:60,   Align:"Center",  ColMerge:0,   SaveName:"org_loc",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
	        	             {Type:"Text",      Hidden:0,  	Width:30,   Align:"Center",  ColMerge:0,   SaveName:"org_type",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
	        	             {Type:"PopupEdit", Hidden:0, 	Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dest_loc",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
	        	             {Type:"Text",      Hidden:0,  	Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dest_type",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
	        	             {Type:"Combo",     Hidden:0, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"trsp_mod_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	        	             {Type:"PopupEdit", Hidden:0, 	Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	        	             {Type:"Text",      Hidden:0,  	Width:170,  Align:"Left",    ColMerge:0,   SaveName:"vndr_name",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  	Width:70,   Align:"Center",  ColMerge:0,   SaveName:"agmt_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
	        	             {Type:"Text",      Hidden:0,  	Width:90,   Align:"Center",  ColMerge:0,   SaveName:"refe_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"fmt_tztm_hrs",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:0,  	Width:60,   Align:"Center",  ColMerge:0,   SaveName:"lnk_dist",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Combo",     Hidden:0, 	Width:35,   Align:"Center",  ColMerge:0,   SaveName:"dist_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:1, 	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rail_crr_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:1, 	Width:30,   Align:"Center",  ColMerge:0,   SaveName:"lnk_org_nod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:1, 	Width:30,   Align:"Center",  ColMerge:0,   SaveName:"lnk_dest_nod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:1, 	Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tztm_hrs",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:1, 	Width:30,   Align:"Center",  ColMerge:0,   SaveName:"us_rail",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:1, 	Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vndr_cnt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:1, 	Width:30,   Align:"Center",  ColMerge:0,   SaveName:"org_is_door",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:1, 	Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dest_is_door",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:1, 	Width:30,   Align:"Center",  ColMerge:0,   SaveName:"unmatch",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:1, 	Width:120,  Align:"Center",  ColMerge:0,   SaveName:"result",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"sResult",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:1,  	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fc",          		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } 
        	             ];
        	      InitColumns(cols);
        	      SetEditable(1);
        	      SetColProperty(0, "fmt_tztm_hrs", 	{AcceptKeys:"N", Format:"##.##"} );
        	      SetColProperty(0 ,"trsp_mod_cd", 		{ComboText:trsp_mod_cdText, ComboCode:trsp_mod_cdCode} );
        	      SetColProperty(0 ,"dist_ut_cd", 		{ComboText:dist_ut_cdCode, ComboCode:dist_ut_cdCode} );
        	      SetColProperty(0 ,"rail_crr_tp_cd", 	{ComboText:rail_crr_tp_cdText, ComboCode:rail_crr_tp_cdCode} );
        	      SetColProperty(0 ,"org_loc" , 		{AcceptKeys:"E|N" , InputCaseSensitive:1});
        	      SetColProperty(0 ,"dest_loc" , 		{AcceptKeys:"E|N" , InputCaseSensitive:1});
        	      SetColProperty(0 ,"org_type" , 		{AcceptKeys:"E|N" , InputCaseSensitive:1});
        	      SetColProperty(0 ,"dest_type" , 		{AcceptKeys:"E|N" , InputCaseSensitive:1});
        	      SetColProperty(0 ,"vndr_seq" , 		{AcceptKeys:"E|N" , InputCaseSensitive:1});
        	      SetColProperty(0 ,"agmt_no" , 		{AcceptKeys:"E|N" , InputCaseSensitive:1});
        	      ComResizeSheet(sheetObj);
        	}
            break;
    }
}
// handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	var uid;
	var sXml;
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH:
			if (validateForm(sheetObj, formObj, sAction)) {
				if (!checkMandatory())
					return;
				formObj.f_cmd.value = SEARCHLIST;
				ComOpenWait(true);
				setTimeout(function() {
					sheetObj.DoSearch("ESD_PRD_0009GS.do", PrdFQString(formObj), { Sync : 2 });
					ComOpenWait(false);
				}, 100);
			}
			break;
		case IBSAVE:
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value = MULTI;
				setNodCd(sheetObj);
				if (calcuTztmHrs(sheetObj) == false) {
					return false;
				}
				sheetObj.DoSave("ESD_PRD_0009GS.do", PrdFQString(formObj));
			}
			break;
		case MODIFY01: // only agmt update
			if (!sheetObj.IsDataModified())
				return;
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value = MODIFY01;
				if (calcuTztmHrs(sheetObj) == false) {
					return false;
				}
				var SaveStr = sheetObj.GetSaveString();
				var rtnData = sheetObj.GetSaveData("ESD_PRD_0009UPGS.do", PrdFQString(formObj) + "&" + SaveStr);
				sheetObj.LoadSaveData(rtnData);
				ComSetResultData(sheetObj, rtnData);
				fncErrMsg(rtnData);
			}
			break;
		case IBINSERT:
			if (validateForm(sheetObj, formObj, sAction)) {
				sheetObj.DataInsert();
			}
			break;
		case IBCOPYROW:
			var copyRow = sheetObj.DataCopy();
			if(sheetObj.GetCellValue(copyRow, "trsp_mod_cd") == 'RD') {
				sheetObj.SetCellEditable(copyRow, "agmt_no", 1);
			} else {
				sheetObj.SetCellEditable(copyRow, "agmt_no", 0);
			}
			break;
		case IBDOWNEXCEL:
			sheetObj.Down2Excel({ DownCols : makeHiddenSkipCol(sheetObj), SheetDesign : 1, Merge : 1 });
			break;
		case IBLOADEXCEL:
			if (sheetObj.LoadExcel({ Mode : "HeaderSkip" })) {
				setHiddenData(sheetObj);
			}
			break;
		case SEARCH02:
			formObj.f_cmd.value = SEARCH02;
			uid = "ESD_PRD_0009";
			sXml = sheetObj.GetSearchData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetEtcData(sXml, "rowCount");
			break;
		// node check
		case SEARCH04:
			formObj.f_cmd.value = SEARCH04;
			uid = "ESD_PRD_0009";
			sXml = sheetObj.GetSearchData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetEtcData(sXml, "rowCount");
			isDoor = ComGetEtcData(sXml, "isDoor");
			break;
		// vender check
		case SEARCH08:
			formObj.f_cmd.value = SEARCH08;
			uid = "ESD_PRD_0009";
			sXml = sheetObjects[0].GetSearchData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetEtcData(sXml, "rowCount");
			comData1 = ComGetEtcData(sXml, "comData1");
			comData2 = ComGetEtcData(sXml, "comData2");
			if (retValidate < 1) {
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "vndr_name", comData2, 0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "vndr_seq", "", 0);
				sheetObj.SelectCell(sheetObj.GetSelectRow(), "vndr_seq");
			}
			break;
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
	if (isExceedMaxRow(msg))
		return;
}

/**
 * 
 * @param sheetObj
 * @returns {Boolean}
 */
function setHiddenData(sheetObj) {
	setNodCd(sheetObj);
	if (calcuTztmHrs(sheetObj) == false) {
		return false;
	}
	;
}
function pseudoCdCheck(sheetObj) {
	var pseudoCd = sheetObj.GetEtcData("pseudoCd");
	var blankCd = sheetObj.GetEtcData("blankCd");
	var invalidVendorCd = sheetObj.GetEtcData("invalidVendorCd");
	var msg = "";
	if (pseudoCd != undefined && pseudoCd.length > 0) {
		msg = ComGetMsg('PRD90045', pseudoCd);
	}
	if (blankCd != undefined && blankCd.length > 0) {
		msg = msg + ComGetMsg('PRD90046', blankCd);
	}
	if (invalidVendorCd != undefined && invalidVendorCd.length > 0) {
		msg = msg + ComGetMsg('PRD90047', invalidVendorCd);
	}
	if (msg.length > 0) {
		ComShowMessage(msg);
	}
}
function fncErrMsg(rtnData) {
	var validUpdateRoute = ComGetEtcData(rtnData, "validUpdateRoute");
	var validAgmtNoRoute = ComGetEtcData(rtnData, "validAgmtNoRoute");
	var msg = "";
	if (validUpdateRoute != undefined && validUpdateRoute.length > 0) {
		msg = ComGetMsg('PRD90068', validUpdateRoute);
	}
	if (validAgmtNoRoute != undefined && validAgmtNoRoute.length > 0) {
		msg = msg + ComGetMsg('PRD90068', validAgmtNoRoute);
	}
	if (msg.length > 0) {
		ComShowMessage(msg);
	}
}
/*
 * checking Mandatory
 */
function checkMandatory() {
	var formObj = document.form;
	var retValue = true;
	var orgCd = formObj.i_org_cd.value;
	var destCd = formObj.i_dest_cd.value;
	var agmtNo = formObj.i_agmt_no.value;
	if (agmtNo.length > 0) {
		if (agmtNo.length < 4) {
			retValue = false;
			ComShowMessage('Agreement No invalid.');
		}
		if (!ComIsAlphabet(agmtNo.substr(0, 3))) {
			retValue = false;
			ComShowMessage('Agreement No invalid.');
		}
	}
	return retValue;
}
/**
 * changing to time format of sheet data - calling comPopupInSheet() : passing Parameters - row, col
 */
function calcuTztmHrs(sheetObj) {
	var fmtTime = 0;
	for (i = 1; i <= sheetObj.RowCount(); i++) {
		if (sheetObj.GetRowStatus(i) == "I" || sheetObj.GetRowStatus(i) == "U") {
			fmtTime = sheetObj.GetCellValue(i, "fmt_tztm_hrs").replace(" ", "");
			if (fmtTime.length != 4) {
				ComShowMessage(ComGetMsg("PRD90014"));
				sheetObj.SetCellValue(i, "fmt_tztm_hrs", "", 0);
				sheetObj.SelectCell(i, "fmt_tztm_hrs", true);
				return false;
			}
			sheetObj.SetCellValue(i, "tztm_hrs", (eval(fmtTime.substring(0, 2) * 24) + eval(fmtTime.substring(2))), 0);
		}
	}
	return true;
}
/**
 * calling Biz common popup from sheet - calling comPopupInSheet() : passing Parameters - row, col
 */
function sheet1_OnPopupClick(sheetObj, row, col) {
	var loc_cd_val;
	var dispaly;
	var classId;
	var param;
	var chkStr;
	if (sheetObj.ColSaveName(col) == "org_loc" || sheetObj.ColSaveName(col) == "dest_loc") {
		loc_cd_val = sheetObj.GetCellValue(row, col);
		dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // Radio PopUp
		classId = "COM_ENS_061";
		param = '?loc_cd=' + loc_cd_val + '&classId=' + classId;
		chkStr = dispaly.substring(0, 3)
		// Radio PopUp
		if (chkStr == "1,0") {
			ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 810, 550, 'getNode', dispaly, true, false, row, col);
		} else {
			ComShowMessage(ComGetMst('PRD90063'));
			return;
		}
	}
	if (sheetObj.ColSaveName(col) == "vndr_seq") {
		loc_cd_val = sheetObj.GetCellValue(row, col);
		display = "1,0,1,1,1,1,1,1,1,1,1,1"; // Radio PopUp
		classId = "COM_ENS_0C1";
		param = '?pts_vndr_cd=' + loc_cd_val + '&classId=' + classId + '&func=getVendor&display=' + display + '&row=' + row + '&col=' + col;
		chkStr = display.substring(0, 3);
		// Radio PopUp
		if (chkStr == "1,0") {
			myWin = ComOpenWindowCenter('/opuscntr/COM_ENS_0C1.do' + param, 'pop', 700, 560, true);
		} else {
			ComShowMessage(ComGetMsg('PRD90063'));
			return;
		}
	}
}
/**
 * Location : in case of selecting radio button
 */
function getNode(rowArray, row, col) {
	var sheetObj = sheetObjects[0];
	var colArray = rowArray[0];
	if (sheetObj.ColSaveName(col) == "org_loc") {
		sheetObj.SetCellValue(row, "org_type", colArray[3].substring(5), 0);
		sheetObj.SetCellValue(row, "org_loc", colArray[3].substring(0, 5), 0);
	} else if (sheetObj.ColSaveName(col) == "dest_loc") {
		sheetObj.SetCellValue(row, "dest_type", colArray[3].substring(5), 0);
		sheetObj.SetCellValue(row, "dest_loc", colArray[3].substring(0, 5), 0);
	}
}
function getVendor(rowArray, row, col) {
	var sheetObj = sheetObjects[0];
	var colArray = rowArray[0];
	sheetObj.SetCellValue(row, "vndr_seq", colArray[2], 0);
	sheetObj.SetCellValue(row, "vndr_name", colArray[4], 0);
}
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var ColSaveName  = sheetObj.ColSaveName(Col);
	if (ColSaveName == "fmt_tztm_hrs") {
		var fmtTime = sheetObj.GetCellValue(Row, "fmt_tztm_hrs").replace(" ", "");
		if (fmtTime.length != 4) {
			// 'Please enter 4 digits all (DD.HH).'
			ComShowMessage(ComGetMsg("PRD90014"));
			sheetObj.SetCellValue(Row, "fmt_tztm_hrs", "", 0);
			sheetObj.SelectCell(Row, "fmt_tztm_hrs", true);
			return false;
		}
		if (fmtTime.substring(2) >= 24) {
			ComShowMessage(ComGetMsg("PRD90015")); // 'Hours must be under 24 (HH < 24).'
			sheetObj.SetCellValue(Row, "fmt_tztm_hrs", '', 0);
			sheetObj.SelectCell(Row, "fmt_tztm_hrs");
			return false;
		}
		sheetObj.SetCellValue(Row, "tztm_hrs", (eval(fmtTime.substring(0, 2) * 24) + eval(fmtTime.substring(2))), 0);
	} else if (ColSaveName == "vndr_seq") {
		if (sheetObj.GetCellValue(Row, "vndr_seq").length > 0) {
			// validateData - nod cd
			validateData = sheetObj.GetCellValue(Row, "vndr_seq");
			doActionIBSheet(sheetObjects[0], document.form, SEARCH08);
			// if row count is lesser than 1
			if (retValidate < 1) {
				ComShowMessage(ComGetMsg("PRD90130"));
				sheetObj.SetCellValue(Row, "vndr_name", comData2, 0);
				sheetObj.SelectCell(Row, "vndr_seq");
			} else {
				sheetObj.SetCellValue(Row, "vndr_name", comData2, 0);
			}
		}
	} else if (ColSaveName == "trsp_mod_cd") {
		if (Value == "RD") {
			sheetObj.SetCellEditable(Row, "agmt_no", 1);
		} else {
			sheetObj.SetCellEditable(Row, "agmt_no", 0);
		}
	} else if (ColSaveName == "agmt_no") {
		if (Value == "") {
			sheetObj.SetCellValue(Row, "refe_no", "", 0);
			return;
		}
		var cty_cd = Value.substring(0, 3);
		var agmt_cd = Value.substring(3);
		var vndr_seq = sheetObj.GetCellValue(Row, "vndr_seq");
		var queryString = "f_cmd=" + SEARCH01 + "&cty_cd=" + cty_cd + "&agmt_seq=" + agmt_cd + "&row=" + Row + "&col=" + Col;
		var sXml = sheetObj.GetSearchData("ESD_PRD_0005_AGMT_NO_GS.do", queryString);
		var rowCount = ComGetEtcData(sXml, 'rowCount');
		var trs_vndr_seq = ComGetEtcData(sXml, 'trs_vndr_seq');
		if (rowCount == 0) {
			sheetObj.SetCellValue(Row, "refe_no", "", 0);
			sheetObj.SetCellValue(Row, "agmt_no", "", 0);
		} else {
			sheetObj.DoRowSearch(Row, "ESD_PRD_0005_AGMT_NO_GS.do", queryString, { Sync : 2 });
			if (trs_vndr_seq != vndr_seq) {
				ComShowMessage(ComGetMsg('PRD90070'))
				sheetObj.SetCellBackColor(Row, "vndr_seq", "#FFA040");
				sheetObj.SetCellBackColor(Row, "agmt_no", "#FFA040");
			} else {
				sheetObj.SetCellBackColor(Row, "vndr_seq", "#FFFFFF");
				sheetObj.SetCellBackColor(Row, "agmt_no", "#FFFFFF");
			}
		}
	} else if (ColSaveName == "lnk_org_nod_cd" || ColSaveName == "lnk_dest_nod_cd") {
		if (sheetObj.GetCellValue(Row, "lnk_org_nod_cd").length == 7 && sheetObj.GetCellValue(Row, "lnk_dest_nod_cd").length == 7) {
			var org = sheetObj.GetCellValue(Row, "lnk_org_nod_cd").substring(0, 2);
			var des = sheetObj.GetCellValue(Row, "lnk_dest_nod_cd").substring(0, 2);
			var trsp = sheetObj.GetCellValue(Row, "trsp_mod_cd");
			if ((org == "US" || org == "CA") && (des == "US" || des == "CA") && trsp == "RD") {
				sheetObj.SetCellEditable(Row, "rail_crr_tp_cd", 1);
			} else {
				if (!ComIsEmpty(sheetObj.GetCellValue(Row, "agmt_no"))) {
					sheetObj.SetCellValue(Row, "agmt_no", "", 0);
					sheetObj.SetCellValue(Row, "refe_no", "", 0);
					ComShowMessage(ComGetMsg('PRD90049'));
				}
			}
		} else {
			// possible to input AGMT NO in case of RAIL and the Americas
			if (!ComIsEmpty(sheetObj.GetCellValue(Row, "agmt_no"))) {
				sheetObj.SetCellValue(Row, "agmt_no", "", 0);
				sheetObj.SetCellValue(Row, "refe_no", "", 0);
				ComShowMessage(ComGetMsg('PRD90049'));
			}
		}
	}
	/*
	 * checking FROM,TO,MODE when adding row
	 */

	if (sheetObj.GetRowStatus(Row) == "I") {
		if (ColSaveName != "org_loc" && ColSaveName != "org_type" && ColSaveName != "dest_loc" && ColSaveName != "dest_type" && ColSaveName != "trsp_mod_cd") {
			return;
		}
		sheetObj.SetCellValue(Row, "lnk_org_nod_cd", sheetObj.GetCellValue(Row, "org_loc") + sheetObj.GetCellValue(Row, "org_type"), 0);
		sheetObj.SetCellValue(Row, "lnk_dest_nod_cd", sheetObj.GetCellValue(Row, "dest_loc") + sheetObj.GetCellValue(Row, "dest_type"), 0);
		if (ColSaveName == "org_loc" || ColSaveName == "org_type") {
			if (sheetObj.GetCellValue(Row, "lnk_org_nod_cd").length == 7) {
				validateData = sheetObj.GetCellValue(Row, "lnk_org_nod_cd");
				doActionIBSheet(sheetObjects[0], document.form, SEARCH04);
				sheetObj.SetCellValue(Row, "org_is_door", isDoor, 0);
				if (retValidate < 1) {
					sheetObj.SetCellValue(Row, "org_loc", "", 0);
					sheetObj.SetCellValue(Row, "org_type", "", 0);
					sheetObj.SelectCell(Row, "org_loc");
				}
			}
		}
		if (ColSaveName == "dest_loc" || ColSaveName == "dest_type") {
			if (sheetObj.GetCellValue(Row, "lnk_dest_nod_cd").length == 7) {
				validateData = sheetObj.GetCellValue(Row, "lnk_dest_nod_cd");
				doActionIBSheet(sheetObjects[0], document.form, SEARCH04);
				sheetObj.SetCellValue(Row, "dest_is_door", isDoor, 0);
				if (retValidate < 1) {
					sheetObj.SetCellValue(Row, "dest_loc", "", 0);
					sheetObj.SetCellValue(Row, "dest_type", "", 0);
					sheetObj.SelectCell(Row, "dest_loc");
				}
			}
		}
		if (sheetObj.GetCellValue(Row, "org_is_door") == 'true' || sheetObj.GetCellValue(Row, "dest_is_door") == 'true') {
			var org = sheetObj.GetCellValue(Row, "lnk_org_nod_cd").substring(0, 2);
			var des = sheetObj.GetCellValue(Row, "lnk_dest_nod_cd").substring(0, 2);
			if((org == "US" || org == "CA") && (des == "US" || des == "CA")) {
				sheetObj.SetCellValue(Row, "trsp_mod_cd", "TD", 0);
				sheetObj.SetCellEditable(Row, "trsp_mod_cd", 0);
			} else {
				sheetObj.SetCellEditable(Row, "trsp_mod_cd", 1);
			}
		} else {
			sheetObj.SetCellEditable(Row, "trsp_mod_cd", 1);
		}
		
		if (sheetObj.GetCellValue(Row, "lnk_org_nod_cd") == sheetObj.GetCellValue(Row, "lnk_dest_nod_cd")) {
			ComShowMessage(ComGetMsg('PRD90067'));
			sheetObj.SetCellValue(Row, "dest_loc", "", 0);
			sheetObj.SetCellValue(Row, "dest_type", "", 0);
			sheetObj.SelectCell(Row, "dest_loc");
			return false;
		}
		// checking the Americas
		if (sheetObj.GetCellValue(Row, "lnk_org_nod_cd").length == 7 && sheetObj.GetCellValue(Row, "lnk_dest_nod_cd").length == 7) {
			var org = sheetObj.GetCellValue(Row, "lnk_org_nod_cd").substring(0, 2);
			var des = sheetObj.GetCellValue(Row, "lnk_dest_nod_cd").substring(0, 2);
			var trsp = sheetObj.GetCellValue(Row, "trsp_mod_cd");
			if ((org == "US" || org == "CA") && (des == "US" || des == "CA") && trsp == "RD") {
				sheetObj.SetCellEditable(Row, "rail_crr_tp_cd", 1);
			}
		}
	} 
}

function setNodCd(sheetObj) {
	for (i = 1; i <= sheetObj.RowCount(); i++) {
		if (sheetObj.GetRowStatus(i) == "I") {
			sheetObj.SetCellValue(i, "lnk_org_nod_cd", sheetObj.GetCellValue(i, "org_loc") + sheetObj.GetCellValue(i, "org_type"), 0);
			sheetObj.SetCellValue(i, "lnk_dest_nod_cd", sheetObj.GetCellValue(i, "dest_loc") + sheetObj.GetCellValue(i, "dest_type"), 0);
		}
	}
}
function getOrgLoc(rowArray) {
	var colArray = rowArray[0];
	document.all.i_org_cd.value = colArray[3];
}
function getDestLoc(rowArray) {
	var colArray = rowArray[0];
	document.all.i_dest_cd.value = colArray[3];
}

// validation of Location code
function validateLocation(loc, num) {
	if (num == 1) {
		document.form.i_org_cd.value = loc.toUpperCase();
	}
	if (num == 2) {
		document.form.i_dest_cd.value = loc.toUpperCase();
	}
	validateData = loc.toUpperCase();
	doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
	if (retValidate < 1) { // if row count is lesser than 1
		if (num == 1) {
			// document.form.i_org_cd.value = "";
			document.form.i_org_cd.focus();
		} else {
			document.form.i_dest_cd.focus();
		}
		if (num == 2) {
		}
	} else {
		if (num == 1) {
			document.form.i_dest_cd.focus();
		}
	}
	return false;
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	return true;
}


function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	var formObj = document.form;
	var fcmd = formObj.f_cmd.value;
	if (fcmd == MULTI) {
		pseudoCdCheck(sheetObj);
	}
}
/*
 * checking input condition for retrieve
 */
function checkInput() {
	var formObject = document.form;
	var i_org_cd = formObject.i_org_cd.value;
	var i_dest_cd = formObject.i_dest_cd.value;
	if (i_org_cd.length > 0) {
		if (!(i_org_cd.length == 5 || i_org_cd.length == 7)) {
			ComShowMessage(ComGetMsg('PRD90120', 'Origin', '5 or 7'));
			formObject.i_org_cd.select();
			formObject.i_org_cd.focus();
			return false;
		}
	} else {
		ComShowMessage(ComGetMsg('PRD90120', 'Origin', '5 or 7'));
		formObject.i_org_cd.select();
		formObject.i_org_cd.focus();
		return false;
	}
	if (i_dest_cd.length > 0) {
		if (!(i_dest_cd.length == 5 || i_dest_cd.length == 7)) {
			ComShowMessage(ComGetMsg('PRD90120', 'Destination', '5 or 7'));
			formObject.i_dest_cd.select();
			formObject.i_dest_cd.focus();
			return false;
		}
	} else {
		ComShowMessage(ComGetMsg('PRD90120', 'Destination', '5 or 7'));
		formObject.i_dest_cd.select();
		formObject.i_dest_cd.focus();
		return false;
	}
	return true;
}
var item_vndr = 'N';
function itemControl(sheetObj, formObj, sAction) {
	if (undefined != formObj.skip_flag_fun_itemControl && "Y" == formObj.skip_flag_fun_itemControl.value) {
		item_vndr = 'Y';
		return;
	}
}
