/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_BKG_0428.js
 *@FileTitle  : US AMS: Receive History
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/07/01
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class US AMS: Receive History : US AMS: Receive History business script for
 */
// Common global variable
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
var end_no = 0;
// Event handler processing by button click event */
document.onclick = processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
		case "btn_view":
			doActionIBSheet(sheetObject, formObject, IBROWSEARCH);
			break;
		case "btn_calendar":
			if (formObject.fromd.disabled)
				return;
			var cal = new ComCalendarFromTo();
			cal.select(formObject.fromd, formObject.tod, 'yyyy-MM-dd');
			break;
        case "btn_Downexcel":
            if(sheetObject.RowCount() < 1){//no data
                ComShowCodeMessage("COM132501");
            }else{
                sheetObject.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
            }
            break;
        case "btn_new":
            formObject.reset();
            sheetObject.RemoveAll();
            comboObjects[0].SetSelectCode('AL');
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
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}
/**
 * Initialize the Combo Object
 */
function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
	case "rcv_msg_tp_id":
		var i = 0;
		with (comboObj) {
			SetColBackColor(0, "#CCFFFD");
			SetDropHeight(200);
			SetMultiSelect(0);
			SetMaxSelect(1);
		}
		break;
	}
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
	for (i = 0; i < comboObjects.length; i++) {
		initCombo(comboObjects[i], i + 1);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
	document.form.vvd.focus();
	axon_event.addListenerForm("click", "obj_click", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {
		     var HeadTitle="Seq.|MSG|Code|Receive Date|Receive Seq.|VVD|POL|V.POD|Customs|TTL B/L|Accept|Reject|B/L No.|Batch No.|SCAC|Reason|cnt_cd|io_bnd_cd|rjct_flg";
		     var headCount=ComCountHeadTitle(HeadTitle);
		
		     SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, FrozenCol:0, DataRowMerge:1 } );
		
		     var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		     var headers = [ { Text:HeadTitle, Align:"Center"} ];
		     InitHeaders(headers, info);
		
		     var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
		         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcv_msg_tp_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dspo_cd",		 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		         {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"rcv_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		         {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rcv_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		         {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		         {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vpod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		         {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		         {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"tot_cnt",        KeyField:0,   CalcLogic:"",   Format:"NullInteger",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		         {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"suc_cnt",        KeyField:0,   CalcLogic:"",   Format:"NullInteger",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		         {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"err_cnt",        KeyField:0,   CalcLogic:"",   Format:"NullInteger",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cstms_bat_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"scac_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		         {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"reason",         MultiLineText:1, KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rjct_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	
		    InitColumns(cols);

			SetEditable(0);
			SetCountFormat("[SELECTDATAROW / TOTALROWS]");
			ComResizeSheet(sheetObj);
		}
		break;
	} // switch end
}

/**
 * handling process for Sheet
 */
function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
	// sheetObj.ShowDebugMsg = false;
	sheetObj.SetWaitImageVisible(0);
	switch (sAction) {
	case IBCREATE: // Searching the Combo data
		formObj.f_cmd.value = INIT;
		var sXml = sheetObj.GetSearchData("ESM_BKG_0428GS.do", FormQueryString(formObj));
		ComXml2ComboItem(sXml, rcv_msg_tp_id, "val", "name|desc");
		rcv_msg_tp_id.SetDropHeight(200);
		rcv_msg_tp_id.SetSelectCode('AL');
		formObj.fromd.value = ComGetEtcData(sXml, "date");
		formObj.tod.value = ComGetEtcData(sXml, "date");
		break;
	case IBSEARCH: // retrieve
		if (!validateForm(sheetObj, formObj, sAction))
			return false;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		var vvd = formObj.vvd.value.trim();
		formObj.vsl_cd.value = vvd.substring(0, 4);
		formObj.skd_voy_no.value = vvd.substring(4, 8);
		formObj.skd_dir_cd.value = vvd.substring(8, 9);
		var bl_nos = formObj.bl_nos.value.trim();
		// formObj.bl_no.value = bl_nos.substring(0,10);
		formObj.bl_no.value = formObj.bl_nos.value;
		sheetObj.DoSearch("ESM_BKG_0428GS.do", FormQueryString(formObj));
		end_no = 0;
		ComOpenWait(false);
		break;
	case IBSEARCHAPPEND: // paging
		if (!validateForm(sheetObj, formObj, IBSEARCH))
			return false;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("ESM_BKG_0428GS.do", FormQueryString(formObj) + "&" + "page_no=" + PageNo + "&end_no=" + end_no, {Append : true});
		ComOpenWait(false);
		break;
	case IBROWSEARCH:
		if (sheetObj.RowCount() == 0)
			return false;
		var cnt_cd = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cnt_cd");
		var io_bnd_cd = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "io_bnd_cd");
		var rcv_date = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "rcv_dt").replace('-', '').replace('-', '').replace(' ', '').replace(':', '').replace(':', '');
		var rcv_seq = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "rcv_seq");
		var bl_no = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bl_no");
		var params = "cnt_cd=" + cnt_cd + "&io_bnd_cd=" + io_bnd_cd + "&rcv_date=" + rcv_date + "&rcv_seq=" + rcv_seq + "&blNo=" + bl_no ;
		ComOpenWindowCenter("ESM_BKG_0429.do?" + params, "ESM_BKG_0429", 600, 520, false);
		break;
	}// switch end
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // retrieve
		if (formObj.gubun.checked) {
			if (!ComChkRequired(formObj))
				return false;
			var days = ComGetDaysBetween(formObj.fromd.value, formObj.tod.value);
			if (days >= 15) {
				ComShowCodeMessage('BKG50468'); // Can't Input Date Over 15 days!"
				formObj.fromd.focus();
				return false;
			}
		} else {
			if (formObj.vvd.value == '' && formObj.bl_nos.value == '') {
				ComShowMessage("'VVD' or 'B/L No.'" + Msg_Required);
				return false;
			}
		}
		if (formObj.bl_nos.value != '') {
			if (!ComChkObjValid(formObj.bl_nos))
				return false;
		} else if (formObj.pol_cd.value != '') {
			if (!ComChkObjValid(formObj.pol_cd))
				return false;
		} else if (formObj.pod_cd.value != '') {
			if (!ComChkObjValid(formObj.pod_cd))
				return false;
		} else if (formObj.cstms_bat_no.value != '') {
			var obj = formObj.cstms_bat_no;
			if (obj.value.length < obj.getAttribute("maxlength")) {
				var msg = "'" + obj.getAttribute("caption") + "' 값을 " + obj.getAttribute("maxlength") + " 길이만큼  모두 입력하세요";
				ComShowMessage(msg);
				return false;
			}
		}
		return true;
		break;
	}
}

/**
* control scroll event
*/
var iPageNo = 1;
function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
    doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
}

/**
 * handling event after retrieving
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	for (i = 1; i <= sheetObj.RowCount(); i++) {
		if (sheetObj.GetCellValue(i, "rjct_flg") == 'Y') {
			if (sheetObj.GetCellValue(i, "reason") != "") {
                sheetObj.SetRowFontColor(i, "#FF0000");
			}
			else
			{
                sheetObj.SetRowFontColor(i, "blue");
			}
		}
	}
}

/**
 * Click Event Catch
 */
function obj_click() {
	var formObject=document.form;
	var srcObj=window.event.srcElement;
	var srcName=srcObj.getAttribute("name");
	var srcVal=srcObj.checked;
	if (srcName == "gubun") {
		alterRequiredChk(srcVal);
	}
}
/**
 * Activating the Form control if checkbox checked
 */
function alterRequiredChk(checked) {
	var formObject = document.form;
	form.io_bnd_cd.value = "";
	if (checked) {
		formObject.fromd.disabled = false;
		formObject.tod.disabled = false;
		formObject.fromt.disabled = false;
		formObject.tot.disabled = false;
	} else {
		formObject.fromd.disabled = true;
		formObject.tod.disabled = true;
		formObject.fromt.disabled = true;
		formObject.tot.disabled = true;
		formObject.vvd.focus();
	}
}
/**
 * Mouse double click Event
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {
	doActionIBSheet(sheetObj, document.form, IBROWSEARCH);
}