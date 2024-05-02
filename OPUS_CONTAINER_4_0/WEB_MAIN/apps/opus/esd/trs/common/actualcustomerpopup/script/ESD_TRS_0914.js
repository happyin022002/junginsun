/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0914.js
 *@FileTitle  : Other SO(Detail Input Pop up)
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/07/21
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;
document.onclick = processButtonClick;
var winOpenObj = opener;
if(!winOpenObj) winOpenObj = parent;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName))
			return false;
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;
			case "btn_close":
				ComClosePopup();
				break;
			case "btn_ok":
				applyActualCustomer();
				break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * Register IBSheet Object with array
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * Setting sheets and initialization Implementing the onLoad event handler of body tag Adding the preceding function after loading page
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	if (ComTrim(document.form.dor_nod_cd.value) != '') {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	} else if (ComTrim(document.form.act_cust_cd.value) != '') {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	document.form.INIT_FLAG.value = 'N';
	initControl();
}

function initControl() {
}

/**
 * Define the initial values and headers of sheets
 * 
 * 
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with(sheetObj){
				var HeadTitle="Sts|SEQ|Customer Code|Customer Name" ;
				SetConfig( { SearchMode:2, MergeSheet:5, Page:100, FrozenCol:0, DataGetRowMerge:1 } );
				var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers=[ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols=[ {Type:"Status",    Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ac_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"act_cust_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"trsp_act_cust_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"act_cust_cnt_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"act_cust_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }  ];
				InitColumns(cols);
				SetSheetHeight(ComGetSheetHeight(sheetObj, 6));
				SetEditable(0);
			}
			break;
		case 2:      //sheet2 init
			with(sheetObj){
				var lv_conti_cd=document.form.CONTI_CD.value;
				var HeadTitle="";
				if(lv_conti_cd == 'E') {
					HeadTitle="Sts||Factory Name|Contact\nPIC Name|Address|Zip Code|Tel No.|Fax No.|Remark" ;
				}else{
					HeadTitle="Sts||Act Customer\nName|Contact\nPIC Name|Address|Zip Code|Tel No.|Fax No.|Remark" ;
				}
				SetConfig( { SearchMode:2, MergeSheet:5, Page:100, FrozenCol:0, DataGetRowMerge:1 } );
				var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers=[ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols=[ {Type:"Status",    Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Radio",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fctry_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntc_pson_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"fctry_addr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"act_cust_pst_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntc_pson_phn_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntc_pson_fax_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntc_pson_req_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"act_cust_addr_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }  ];
				InitColumns(cols);
				ComResizeSheet(sheetObj);
				SetEditable(1);
			}
			break;
	}
}

function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	var lv_conti_cd = formObj.CONTI_CD.value;
	var lv_door_node_cd = formObj.dor_nod_cd.value;
	switch (sAction) {
		case IBSEARCH: // Retrieve
			if (!validateForm(sheetObj, formObj, sAction, lv_conti_cd))
				return;
			/* DOOR NODE LENGTH CHECK */
			if ((lv_door_node_cd == null || lv_door_node_cd == '') || (lv_door_node_cd.length != 2 && lv_door_node_cd.length != 5 && lv_door_node_cd.length != 7)) {
				ComShowCodeMessage('TRS90122');
				return;
			}
			formObj.f_cmd.value = SEARCH07;
			sheetObj.DoSearch("ESD_TRS_0914GS.do", TrsFrmQryString(formObj));
			break;
	}
}

function doActionIBSheet2(sheetObj, formObj, sAction, row) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH:
			formObj.ACT_CUST_CNT_CD.value = sheetObjects[0].GetCellValue(row, 'act_cust_cnt_cd');
			formObj.ACT_CUST_SEQ.value = sheetObjects[0].GetCellValue(row, 'act_cust_seq');
			formObj.USA_TRSP_ACT_CUST_NO.value = sheetObjects[0].GetCellValue(row, 'trsp_act_cust_no'); // 미주+아주 ACTUAL CUSTOMER : 2007-11-23
			formObj.f_cmd.value = SEARCH08;
			sheetObj.DoSearch("ESD_TRS_0914GS.do", TrsFrmQryString(formObj));
			break;
	}
}
/**
 * 
 * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj = document.form;
	if (errMsg != null && errMsg != '') {
		ComShowMessage(errMsg);
	} else {
		if (formObj.f_cmd.value == SEARCH07 && sheetObj.RowCount() > 0) {
			doActionIBSheet2(sheetObjects[1], formObj, IBSEARCH, 1);
		} else if (formObj.f_cmd.value == SEARCH07 && sheetObj.RowCount() == 0) {
			sheetObjects[1].RemoveAll();
		}
	}
}
function sheet1_OnDblClick(sheetObj, row, col) {
	doActionIBSheet2(sheetObjects[1], document.form, IBSEARCH, row);
}

/**
 * 
 * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js
 */
function sheet2_OnSearchEnd(sheetObj, errMsg) {
	var formObj = document.form;
	if (errMsg != null && errMsg != '') {
		ComShowMessage(errMsg);
	} else {
		if (formObj.f_cmd.value == SEARCH08 && sheetObj.RowCount() > 0) {
			sheetObj.SetCellValue(1, 'ibcheck', 1);
		}
	}
}

/**
 * Validating inputted values of form
 */
function validateForm(sheetObj, formObj, sAction, sContiCd) {
	switch (sAction) {
		case IBSEARCH:
			if (sContiCd == 'E') {
			}
			if ((formObj.dor_nod_cd.value == null || ComTrim(formObj.dor_nod_cd.value) == '') && (formObj.act_cust_cd.value == null || ComTrim(formObj.act_cust_cd.value) == '') && (formObj.fctry_nm.value == null || ComTrim(formObj.fctry_nm.value) == '')) {
				ComShowCodeMessage('COM12114', 'retrieve condition');
				return false;
			}
			break;
	}
	return true;
}
/**
 * MInimize
 */
function Minimize(nItem) {
	var objs = document.all.item("showMin");
	if (nItem == "1") {
		objs.style.display = "none";
		sheetObjects[0].focus();
	} else {
		objs.style.display = "inline";
		sheetObjects[0].focus();
	}
}
/**
 * Location check
 */
function checkLoc(obj) {
	if (obj.value.length != 0 && obj.value.length != 2 && obj.value.length != 5 && obj.value.length != 7) {
		var lv_init_flag = document.form.INIT_FLAG.value;
		if (lv_init_flag != 'Y')
			ComShowCodeMessage('COM12114', 'Location');
		obj.focus;
		return false;
	}
	obj.value = obj.value.toUpperCase();
	return true;
}
/**
 * Customer check
 */
function checkCustCd(obj) {
	if (obj.value.length < 2) {
		var lv_init_flag = document.form.INIT_FLAG.value;
		if (lv_init_flag != 'Y')
			ComShowCodeMessage('COM12114', 'Customer Code');
		obj.focus;
		return false;
	}
	obj.value = obj.value.toUpperCase();
	return true;
}
/**
 * applyAtualCustomer function
 */
function applyActualCustomer() {
	var sheetObj = sheetObjects[0];
	var sheetObj1 = sheetObjects[1];
	var formObj = document.form;
	var addr = '';
	var addr_seq = '';
	var act_cust_pst_cd = '';
	var mst_selected_row = '';
	var vCntcPsonReqRmk = '';
	if (sheetObj.RowCount() < 1) {
		ComShowCodeMessage('COM12114', 'First Sheet');
		return false;
	}
	if (sheetObj1.RowCount() == 0) {
		ComShowCodeMessage('TRS90393'); // TES21905:No Data Found
		return false;
	}
	if (sheetObj1.RowCount() > 0) {
		var checkList = sheetObj1.FindCheckedRow('ibcheck');
		var checkArray = checkList.split('|');
		if (checkList == '') {
			ComShowCodeMessage('COM12176');
			return false;
		} else {
			mst_selected_row = sheetObj.GetSelectRow();
			act_cust_cd = sheetObj.GetCellValue(mst_selected_row, 'act_cust_cd'); /* act_cust_cnt_cd + act_cust_seq */
			act_cust_cnt_cd = sheetObj.GetCellValue(mst_selected_row, 'act_cust_cnt_cd');
			act_cust_seq = sheetObj.GetCellValue(mst_selected_row, 'act_cust_seq');
			act_cust_nm = sheetObj.GetCellValue(mst_selected_row, 'cust_lgl_eng_nm');
			factory_nm = sheetObj1.GetCellValue(checkArray, 'fctry_nm');
			factory_zip_code = sheetObj1.GetCellValue(checkArray, 'act_cust_pst_cd');
			factory_addr = sheetObj1.GetCellValue(checkArray, 'fctry_addr');
			act_cust_addr_seq = sheetObj1.GetCellValue(checkArray, 'act_cust_addr_seq');
			factory_tel_no = sheetObj1.GetCellValue(checkArray, 'cntc_pson_phn_no');
			factory_fax_no = sheetObj1.GetCellValue(checkArray, 'cntc_pson_fax_no');
			pic_nm = sheetObj1.GetCellValue(checkArray, 'cntc_pson_nm');
			vCntcPsonReqRmk = sheetObj1.GetCellValue(checkArray, 'cntc_pson_req_rmk');
		}
	}
	var sel_row = (sheetObj.GetSelectRow() < 1 ? 1 : sheetObj.GetSelectRow());
	var cust_cd = sheetObj.GetCellValue(sel_row, 'cust_cnt_cd');
	winOpenObj.applyAtualCustomer(winOpenObj, formObj.ROW.value, act_cust_cd, act_cust_cnt_cd, act_cust_seq, act_cust_addr_seq, act_cust_nm, factory_nm, factory_zip_code, factory_addr, factory_tel_no, factory_fax_no, pic_nm, vCntcPsonReqRmk);
	ComClosePopup();
}
/**
 * enter check
 */
function enterCheck(obj) {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	if (event.keyCode == 13) {
		switch (ComGetEvent("name")) {
			case 'dor_nod_cd':
			case 'act_cust_cd':
				value_upper(obj);
			case 'fctry_nm':
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;
		}
	}
}
