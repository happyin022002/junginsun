/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESD_TRS_0957.js
 *@FileTitle : Service Order Creation - Chassis or Genset
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/09/15
=========================================================*/
/**
 * @fileoverview Defining scripts
 * @author author_name
 */
/**
 * @extends Bkg
 * @class ESD_TRS_0957 :
 */
function ESD_TRS_0957() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.setTabObject = setTabObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.initTab = initTab;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

var sheetObjects = new Array();
var verifyFlag = false;
var sheetCnt = 0;
document.onclick = processButtonClick;

/**
 * Register IBSheet Object with array call from comSheetObject(id)
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
	initControl();
}

/**
 * 
 */
function initControl() {
}

function processButtonClick() {
	/** *** Adding additional sheet variables to use more than one sheet per a tab **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btng_fileimport":
				sheetObject.LoadExcel({ Mode : "HeaderMatch", WorkSheetNo : "1", WorkSheetName : "", Append : false });
				break;
			case "btng_delete": {
				var checkList = sheetObject.FindCheckedRow('ibcheck');
				var checkArray = checkList.split('|');
				for ( var i = checkArray.length - 1; i >= 0; i--) {
					sheetObject.RowDelete(checkArray[i], false);
				}
				break;
			}
			case "btng_verify": {
				if (sheetObject.RowCount() < 1) {
					return;
				}
				getVerifyEqNo(sheetObject, formObject);
				break;
			}
			case "btng_apply":
				var checkList = sheetObject.FindCheckedRow('ibcheck');
				if (checkList == '') {
					ComShowCodeMessage('COM12176');
					return false;
				}
				ComOpenWait(true);
				sheetObject.DoSearch("ESD_TRS_0969.screen", TrsFrmQryString(formObject), { Sync : 2, Append : true });
				if (!verifyFlag) {
					ComShowCodeMessage('TRS90055');
					ComOpenWait(false);
					return;
				}
				importInvoiceFile(sheetObject);
				ComOpenWait(false);
				ComClosePopup();
				break;
			case "btn_close":
				ComClosePopup();
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e.message);
		}
	}
}


/**
 * Define the initial values and headers of sheets
 * 
 * 
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
		case 1: {
			with (sheetObj) {
				var HeadTitle = "|Seq.| |Verify Result|EQ No|EQ TP/SZ|S/O No|W/O No|Reference No|Invoice Total Amount|trsp_wo_ofc_cty_cd|trsp_wo_seq|trsp_so_ofc_cty_cd|trsp_so_seq|nis_check|cntr_sub_flg";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 1, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [{ Text : HeadTitle, Align : "Center" } ];
				InitHeaders(headers, info);
				 var cols = [ 
			                 {Type:"Status",    Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_cmb_seq" },
			                 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibcheck",                  KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0, Width:210,  Align:"Left",    ColMerge:1,   SaveName:"inv_rmk",                  KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",                    KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",               KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prnt_trsp_so_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"prnt_trsp_so_seq",         KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"ref_inv_no",               KeyField:0,   CalcLogic:"",   Format:"",       	  PointCount:0,   UpdateEdit:0,   InsertEdit:0 },			                 
			                 {Type:"Float",     Hidden:0, Width:130,  Align:"Right",   ColMerge:1,   SaveName:"inv_bzc_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",      PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1, Width:100,  Align:"right",   ColMerge:1,   SaveName:"trsp_wo_ofc_cty_cd",       KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_wo_seq",              KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd",       KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_so_seq",              KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"CheckBox",  Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"nis_check" },
			                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_sub_flg" } ];
			    InitColumns(cols);
				SetEditable(1);
				ComResizeSheet(sheetObj);
			}
			break;
		}
	}
}


function get_only_num(obj) {
	var str = escape(obj);
	var returnNum = '';
	for (i = 0; i < str.length; i++) {
		if (str.charCodeAt(i) >= 48 && str.charCodeAt(i) <= 57) {
			returnNum += str.charAt(i);
		}
	}
	return returnNum;
}

function sheet1_OnChange(sheetObj, row, col, value) {
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(col);
	switch (colName) {
		case 'trsp_so_ofc_cty_cd_seq':
			if (value != '') {
				sheetObj.SetCellValue(i, 'trsp_so_ofc_cty_cd', value.substring(0, 3), 0);
				sheetObj.SetCellValue(i, 'trsp_so_seq', value.substring(3), 0);
			}
			break;
		case 'trsp_wo_ofc_cty_cd_seq':
			if (value != '') {
				sheetObj.SetCellValue(i, 'trsp_wo_ofc_cty_cd', value.substring(0, 3), 0);
				sheetObj.SetCellValue(i, 'trsp_wo_seq', value.substring(3), 0);
			}
			break;
	}
}

function getVerifyEqNo(sheetObj, formObj){
	var checkList=sheetObj.FindCheckedRow('ibcheck');
	var checkArray=checkList.split('|');
	if(checkList == '') return;
	ComOpenWait(true);
 	sheetObj.DoSearch("ESD_TRS_0969.screen", '', {Sync:2,Append:true} );
	var opener_queryStr=getOpenerData();
	ComOpenWait(false);
	formObj.f_cmd.value=SEARCH14;		
    var queryStr = sheetObj.GetSaveString(0, 1, "ibcheck");
    var rtnData = sheetObj.GetSaveData("ESD_TRS_0033_01GS.do", queryStr+'&'+TrsFrmQryString(formObj)+'&'+opener_queryStr, "ibcheck", false, true);
    sheetObj.LoadSaveData(rtnData);
}

/**
 * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj = document.form;
	if (errMsg != null && errMsg != '') {
	} else {
		if (formObj.f_cmd.value == SEARCH14) {
			verifyFlag = true;
		}
	}
}

function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
	if (isExceedMaxRow(msg)) {
		return;
	}
	sheetObjects[0].CheckAll('ibcheck', 1, 1);
	for ( var i = 1; i < sheetObjects[0].RowCount() + 1; i++) {
		sheetObjects[0].SetCellValue(i, 'inv_rmk', '', 0);
	}
	for ( var a = sheetObjects[0].RowCount(); a > 0; a--) {
		if (sheetObjects[0].GetCellValue(a, 'eq_no') == '' && sheetObjects[0].GetCellValue(a, 'prnt_trsp_so_ofc_cty_cd') == '' && sheetObjects[0].GetCellValue(a, 'prnt_trsp_so_seq') == '') {
			sheetObjects[0].RowDelete(a, false);
		}
	}
	ComOpenWait(false);
}

function getOpenerData(){
	var sheetObj_audit=opener.sheetObjects[0];
	var sheetObj_confirm=opener.sheetObjects[1];
	var prefix='opener_';
	var queryStr='';
	for(var i=2; i< sheetObj_audit.RowCount()+2; i++){
		queryStr += '&'+prefix+'trsp_so_ofc_cty_cd='	+sheetObj_audit.GetCellValue(i, 'trsp_so_ofc_cty_cd');
		queryStr += '&'+prefix+'trsp_so_seq='			+sheetObj_audit.GetCellValue(i, 'trsp_so_seq');
		queryStr += '&'+prefix+'trsp_wo_ofc_cty_cd='	+sheetObj_audit.GetCellValue(i, 'trsp_wo_ofc_cty_cd');
		queryStr += '&'+prefix+'trsp_wo_seq='			+sheetObj_audit.GetCellValue(i, 'trsp_wo_seq');
		queryStr += '&'+prefix+'eq_no='					+sheetObj_audit.GetCellValue(i, 'eq_no');
		queryStr += '&'+prefix+'trsp_so_cmb_seq='		+i;
		queryStr += '&'+prefix+'ibflag=R'
	}
	for(var i=2; i< sheetObj_confirm.RowCount()+2; i++){
		queryStr += '&'+prefix+'trsp_so_ofc_cty_cd='	+sheetObj_confirm.GetCellValue(i, 'trsp_so_ofc_cty_cd');
		queryStr += '&'+prefix+'trsp_so_seq='			+sheetObj_confirm.GetCellValue(i, 'trsp_so_seq');
		queryStr += '&'+prefix+'trsp_wo_ofc_cty_cd='	+sheetObj_confirm.GetCellValue(i, 'trsp_wo_ofc_cty_cd');
		queryStr += '&'+prefix+'trsp_wo_seq='			+sheetObj_confirm.GetCellValue(i, 'trsp_wo_seq');
		queryStr += '&'+prefix+'eq_no='					+sheetObj_confirm.GetCellValue(i, 'eq_no');
		queryStr += '&'+prefix+'trsp_so_cmb_seq='		+i;
		queryStr += '&'+prefix+'ibflag=R'
	}
	return queryStr;
}

/**
 * Importing EQ_NO
 */
function importInvoiceFile(sheetObject) {
	var formObj = document.form;
	
	var sheetObj_main = window.opener.sheetObjects[0];
	var main_checkArray = sheetObj_main.FindCheckedRow('chk1').split('|');
	var checkArray = sheetObject.FindCheckedRow('ibcheck').split('|');
	
	var emptyEqArray = new Array();
	var cnt = 0;
	for ( var k = 0; k < main_checkArray.length; k++) {
		if (sheetObj_main.GetCellValue(main_checkArray[k], 'eq_no') == '') {
			emptyEqArray[cnt++] = main_checkArray[k];
		}
	}
	for ( var k = 0; k < emptyEqArray.length; k++) {
		var opener_eq_tpsz_cd = sheetObj_main.GetCellValue(emptyEqArray[k], 'eq_tpsz_cd');
		var opener_trsp_wo_seq = sheetObj_main.GetCellValue(emptyEqArray[k], 'trsp_wo_seq');
		var opener_eq_no = sheetObj_main.GetCellValue(emptyEqArray[k], 'eq_no');
		for ( var m = 0; m < checkArray.length; m++) {
			if (checkArray[m] != -1  && opener_eq_tpsz_cd == sheetObject.GetCellValue(checkArray[m], 'eq_tpsz_cd') && opener_trsp_wo_seq == sheetObject.GetCellValue(checkArray[m], 'trsp_wo_seq')) {
				sheetObj_main.SetCellValue(emptyEqArray[k], 'eq_no', sheetObject.GetCellValue(checkArray[m], 'eq_no'), 0);
				sheetObj_main.SetCellValue(emptyEqArray[k], 'chk1', '1', 0);
				checkArray[m] = -1;
				break;
			}
		}
	}
	formObj.f_cmd.value = SEARCH15;
	window.opener.form.f_cmd.value = SEARCH15;
	sheetObj_main.DoSearch("ESD_TRS_0033GS.do", FormQueryString(formObj), {Sync:2, Append:true} );
}
