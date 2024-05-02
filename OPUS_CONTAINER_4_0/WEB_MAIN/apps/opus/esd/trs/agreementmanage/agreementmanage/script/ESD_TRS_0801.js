/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0801.jsp
 *@FileTitle  : TRS AGMT EQ TP RULE Manage
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/26  
=========================================================*/
/***********************************************************************************************************************************************************************************************************************************************************************************************************
 * Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3; [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7 character constant COMMAND01=11; ~ COMMAND20=30;
 **********************************************************************************************************************************************************************************************************************************************************************************************************/

var sheetObjects = new Array();
var sheetCnt = 0;
document.onclick = processButtonClick;
function processButtonClick() {
	/** *** using extra sheet valuable if there are more 2 sheets **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				break;
			case "btn_RowAdd":
				addRow(formObject);
				break;
			case "btn_RowDel":
				deleteRow();
				break;
			case "btn_save":
				doActionIBSheet(sheetObjects[0], document.form, MULTI);
				break;
			case "btn_exceldown":
				doActionIBSheet(sheetObjects[0], document.form, "btn_exceldown", "", "");
				break;
			case "btn_excelup":
				sheetObject.RemoveAll();
				sheetObject.RenderSheet(0);
				sheetObject.LoadExcel({ Mode : "HeaderMatch" });
				sheetObject.RenderSheet(1);
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage(OBJECT_ERROR);
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
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('change', 'obj_change', document.form); // change
	axon_event.addListenerForm('click', 'obj_click', document.form); // click
}

function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    switch (sheetNo) {
    case 1: 
        with(sheetObj){
            
              var HeadTitle  = "STS|Check|RULE SEQ|RULE Type Code|STEP KNT|COST MOD Code|CGO Type Code|EQ KND Code|EQ Type Code|TRSP AGMT EQ SZ Code|TRSP AGMT Type Code|TRSP MOD Code|" ;
              	  HeadTitle += "SCG COND Code|FM LOC COND Code|VIA LOC COND Code|TO LOC COND Code|DOR LOC COND Code|RCV COND Code|DE COND Code|RAIL SVC Type Code|RT COND Code|CURR COND Code|RND TRP RT COND Code|";
              	  HeadTitle += "CHSS NO COND Code|TO DIST COND Code|FX PER DIST COND Code|DIST UT COND Code|OVWT UT COND Code|OVWT STND COND Code|Updation User|Update Date|Creation User|Creation Date";
              var headCount=ComCountHeadTitle(HeadTitle);
              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1} );
              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);
              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center", ColMerge:1,   SaveName:"ibflag" },
                         {Type:"CheckBox",  Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"check" },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_rule_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
                         {Type:"Combo",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_rule_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_step_knt",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_cost_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_cgo_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_eq_knd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_eq_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_eq_sz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_mod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"scg_cond_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fm_loc_cond_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"via_loc_cond_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"to_loc_cond_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dor_loc_cond_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rcv_cond_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"de_cond_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rail_svc_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rt_cond_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"curr_cond_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rnd_trp_rt_cond_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chss_no_cond_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"to_dist_cond_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fx_per_dist_cond_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dist_ut_cond_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ovwt_ut_cond_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ovwt_stnd_cond_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
              InitColumns(cols);
              SetColProperty(0, "trsp_agmt_rule_tp_cd", {ComboText:cb_trspAgmtRuleTpCdText, ComboCode:cb_trspAgmtRuleTpCdCode} );
              SetColProperty(0, "trsp_agmt_step_knt", {AcceptKeys:"N"});
              SetColProperty(0, "trsp_agmt_cgo_tp_cd", {ComboText:"F|M", ComboCode:"F|M"} );
             
              SetEditable(1);
              SetWaitImageVisible(0);
              SetAutoRowHeight(0);
              SetDataRowHeight(22);
              resizeSheet(sheetObj);
        }
        break;
    }
}

function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH:
			ComOpenWait(true);
			if (validateForm(sheetObj, formObj, sAction) != true) {
				ComOpenWait(false);
				break;
			}
			formObj.f_cmd.value = SEARCH;
			var sParam = FormQueryString(formObj);
			sheetObj.DoSearch("ESD_TRS_0801GS.do", sParam, { Sync : 1 });
			ComOpenWait(false);
			break;
		case SEARCH01:
			formObj.f_cmd.value = SEARCH01;
			var sParam = FormQueryString(formObj);
			var arrXml = sheetObj.GetSearchData("ESD_TRS_0801GS.do", sParam);
			if (arrXml.length > 0) {
				var valResult = ComGetTotalRows(arrXml);
				if (valResult == 1)
					return 'S';
				else
					return 'F';
			}
			break;
		case MULTI: // Save
			ComOpenWait(true, true);
			if (validateForm(sheetObj, formObj, sAction) != true) {
				ComShowCodeMessage('BKG00167');
				ComOpenWait(false, false);
				break;
			}
			formObj.f_cmd.value = MULTI;
			var sParam = sheetObj.GetSaveString(false, true, "ibflag");
			var sXml = sheetObjects[0].GetSaveData("ESD_TRS_0801GS.do", "f_cmd=" + MULTI + "&" + sParam);
			var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			if (State != "S") {
				ComShowMessage(ComResultMessage(sXml));
				ComOpenWait(false, false);
				return false;
			}
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			ComOpenWait(false, false);
			break;
		case "btn_exceldown":
			if (sheetObj.RowCount() < 1) {// no data
				ComShowCodeMessage("COM132501");
			} else {
				sheetObj.Down2Excel({ DownCols : makeHiddenSkipCol_TRS(sheetObj), SheetDesign : 1, Merge : 1 });
			}
			break;
	}
}
function validateForm(sheetObj, formObj, sAction) {
	var sheet1RowCnt = sheetObj.RowCount();
	switch (sAction) {
		case MULTI: {
			var Msg = "";
			if (!ComChkValid(formObj))
				return false;
			for ( var i = 1; i <= sheet1RowCnt; i++) {
				if (sheetObj.GetCellValue(i, "trsp_agmt_step_knt") == "") {
					Msg = "STEP KNT Code";
					ComShowCodeMessage('COM130403', Msg);
					return false;
				}
			}
			break;
		}
	}
	return true;
}
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = ComGetEvent("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
}
function addRow(formObj) {
	with (sheetObjects[0]) {
		var nowRow = GetSelectRow();
		nowRow = DataInsert(-1);
		return true;
	}
}
/**
 * row delete
 */
function deleteRow() {
	with (sheetObjects[0]) {
		var sRowStr = FindCheckedRow("check");
		var arr = sRowStr.split("|");
		for ( var i = 0; i < arr.length; i++) {
			SetRowStatus(arr[i], "D");
			SetRowHidden(arr[i], "1");
		}
	}
}
function obj_KeyPress() {
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	var srcName = ComGetEvent("name");
	var srcValue = event.srcElement.getAttribute("value");
	switch (event.srcElement.dataformat) {
		case "engup":
			ComKeyOnlyAlphabet('upper');
			break;
	}
}
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	var ColSaveName = sheetObj.ColSaveName(Col);
	if (sheetObj.GetCellValue(Row, Col) == null || sheetObj.GetCellValue(Row, Col) == "") {
		return;
	}
	if (ColSaveName == "trsp_agmt_eq_knd_cd" || ColSaveName == "trsp_agmt_eq_tp_cd" || ColSaveName == "trsp_agmt_cost_mod_cd" || ColSaveName == "trsp_agmt_rule_tp_cd") {
		if (ColSaveName == "trsp_agmt_eq_knd_cd") {
			formObj.frm_intg_cd_id.value = "CD01132";
			formObj.frm_intg_cd_val_ctnt.value = sheetObj.GetCellValue(Row, Col);
		} else if (ColSaveName == "trsp_agmt_eq_tp_cd") {
			formObj.frm_intg_cd_id.value = "CD00278";
			formObj.frm_intg_cd_val_ctnt.value = sheetObj.GetCellValue(Row, Col);
		} else if (ColSaveName == "trsp_agmt_cost_mod_cd") {
			formObj.frm_intg_cd_id.value = "CD02177";
			formObj.frm_intg_cd_val_ctnt.value = sheetObj.GetCellValue(Row, Col);
		} else if (ColSaveName == "trsp_agmt_rule_tp_cd") {
			formObj.frm_intg_cd_id.value = "CD02178";
			formObj.frm_intg_cd_val_ctnt.value = sheetObj.GetCellValue(Row, Col);
		}
		var result = doActionIBSheet(sheetObj, formObj, SEARCH01);
		if (result == 'F') {
			ComShowCodeMessage('COM130402', "[" + sheetObj.GetCellValue(Row, Col) + "] ");
			formObj.frm_intg_cd_id.value = "";
			formObj.frm_intg_cd_val_ctnt.value = "";
			sheetObj.SetCellValue(Row, Col, "");
		}
	}
}
/* Developer Work End */

function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
	if (isExceedMaxRow(msg))
		return;
}