/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0083.js
 *@FileTitle  :  US D/O Input
 *@author     : CLT
 *@version    : 1.0 
 *@since      : 2014/06/05
 =========================================================*/

function ESD_TRS_0083() {
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
var sheetCnt = 0;
var Mincount = 0;
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];

	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;
			case "btn_reset":
				formObject.reset();
				sheetObject.RemoveAll();
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
				break;
			case "btn_socreation":
				if (sheetObject2.RowCount() > 0) {
					ComShowCodeMessage('TRS90386', 'S/O has already been created');
				} else {
					doActionIBSheet2(sheetObject1, formObject, IBSAVE);
				}
				break;
			case "btn_apply":
				for ( var i = 2; i < sheetObject1.RowCount() + 2; i++) {
					sheetObject1.SetCellValue(i, 'fctry_nm', formObject.cust_nm.value);
					sheetObject1.SetCellValue(i, 'act_cust_n1st_addr', formObject.address.value);
					sheetObject1.SetCellValue(i, 'act_cust_zip_cd', formObject.zip_code.value);
					sheetObject1.SetCellValue(i, 'cntc_pson_nm', formObject.pic.value);
					sheetObject1.SetCellValue(i, 'cntc_pson_phn_no', formObject.tel.value);
					sheetObject1.SetCellValue(i, 'cntc_pson_fax_no', formObject.fax.value);
					sheetObject1.SetCellValue(i, 'do_rmk', formObject.remark.value);
				}
				break;
			case "btns_multibillno":
				openMultipleinquiry('BLN', 'B/L No');
				break;
			case "btns_multibookingno":
				openMultipleinquiry('BKG', 'BKG No');
				break;
			case "btns_consignee":
				var lvdor_node = formObject.dor_loc_cd.value + formObject.zone_cd.value;
				var lv_act_cust_cd = formObject.cust_cnt_cd.value + formObject.cust_seq.value;
				var lv_fctry_nm = "";
				var url = 'ESD_TRS_0914.screen?act_loc=' + lvdor_node + "&act_cust_cd=" + lv_act_cust_cd + "&fctry_nm=" + lv_fctry_nm;
				ComOpenPopup(url, 800, 600, 'consignee', '0,0', true);
				break;
			case "btn_minimize":
				if (document.all.MiniLayer.style.display != "none") {
					document.all.MiniLayer.style.display = "none";
				} else {
					document.all.MiniLayer.style.display = "";
				}
				ComResizeSheet(sheetObject);
				break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("TRS90384");
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
}

function initControl() {
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

/**
 * Define the initial values and headers of sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
	case 1: 
		with (sheetObj) {
			var HeadTitle = "cust_cnt_cd|cust_seq|cust_nm|dor_loc_cd|zone_cd";
			SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 1 });

			var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
			var headers = [
				{ Text : HeadTitle, Align : "Center" }
			];
			InitHeaders(headers, info);
			var cols = [
					{ Type : "Text", Hidden : 0, Width : 90, Align : "Center", ColMerge : 0, SaveName : "cust_cnt_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 0 },
					{ Type : "Text", Hidden : 0, Width : 90, Align : "Center", ColMerge : 0, SaveName : "cust_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 0 },
					{ Type : "Text", Hidden : 0, Width : 90, Align : "Center", ColMerge : 0, SaveName : "cust_nm", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 0 },
					{ Type : "Text", Hidden : 0, Width : 90, Align : "Center", ColMerge : 0, SaveName : "dor_loc_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 0 },
					{ Type : "Text", Hidden : 0, Width : 90, Align : "Center", ColMerge : 0, SaveName : "zone_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 0 }
			];
			InitColumns(cols);
			SetEditable(1);
			SetVisible(false);
		}
		break;
	case 2:
		with (sheetObj) {
			var HeadTitle0 = "CNTR No.|TP/SZ | BKG No. |B/L No.|Door Information|Door Information|Door Information|Door Information|Door Information|Door Information|Door Information|Door Information|PO\n#|BKG\nSPE|FULL\nPICK\nUP CY|MTY\nRTN CY|CMDT";
			var HeadTitle1 = "CNTR No.|TP/SZ | BKG No. |B/L No.|Interface\nCode|Factory\nName|Address|Zip\nCode|PIC|TEL|FAX|Remark\n(Special Instruction)|PO\n#|BKG\nSPE|FULL\nPICK\nUP CY|MTY\nRTN CY|CMDT";

			SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 1 });
			var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
			var headers = [
					{ Text : HeadTitle0, Align : "Center" }, { Text : HeadTitle1, Align : "Center" }
			];
			InitHeaders(headers, info);
			var cols = [
					{ Type : "Text",  Hidden : 0, Width : 90,  Align : "Center", ColMerge : 1, SaveName : "eq_no", 				KeyField : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text",  Hidden : 0, Width : 50,  Align : "Center", ColMerge : 1, SaveName : "cntr_tpsz_cd", 		KeyField : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text",  Hidden : 0, Width : 90,  Align : "Center", ColMerge : 1, SaveName : "bkg_no", 			KeyField : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text",  Hidden : 0, Width : 90,  Align : "Center", ColMerge : 1, SaveName : "bl_no", 				KeyField : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text",  Hidden : 1, Width : 80,  Align : "Center", ColMerge : 1, SaveName : "if_sys_knd_cd", 		KeyField : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text",  Hidden : 0, Width : 150, Align : "Left",   ColMerge : 1, SaveName : "fctry_nm", 			KeyField : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text",  Hidden : 0, Width : 150, Align : "Left",   ColMerge : 1, SaveName : "act_cust_n1st_addr", KeyField : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text",  Hidden : 0, Width : 50,  Align : "Left",   ColMerge : 1, SaveName : "act_cust_zip_cd", 	KeyField : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 10 },
					{ Type : "Text",  Hidden : 0, Width : 40,  Align : "Left",   ColMerge : 1, SaveName : "cntc_pson_nm", 		KeyField : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text",  Hidden : 0, Width : 40,  Align : "Left",   ColMerge : 1, SaveName : "cntc_pson_phn_no", 	KeyField : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text",  Hidden : 0, Width : 40,  Align : "Left",   ColMerge : 1, SaveName : "cntc_pson_fax_no", 	KeyField : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text",  Hidden : 0, Width : 120, Align : "Left",   ColMerge : 1, SaveName : "do_rmk", 			KeyField : 0, UpdateEdit : 0, InsertEdit : 0 }, 
					{ Type : "Text",  Hidden : 0, Width : 80,  Align : "Left",   ColMerge : 1, SaveName : "po_no", 				KeyField : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text",  Hidden : 0, Width : 80,  Align : "Left",   ColMerge : 1, SaveName : "bkg_spe", 			KeyField : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text",  Hidden : 0, Width : 80,  Align : "Left",   ColMerge : 1, SaveName : "full_pickup_cy", 	KeyField : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text",  Hidden : 0, Width : 80,  Align : "Left",   ColMerge : 1, SaveName : "mty_rtn_cy", 		KeyField : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text",  Hidden : 0, Width : 80,  Align : "Left",   ColMerge : 1, SaveName : "cmdt", 				KeyField : 0, UpdateEdit : 0, InsertEdit : 0 }, 
					{ Type : "Status",Hidden : 1, Width : 30,  Align : "Center", ColMerge : 0, SaveName : "ibflag" }
			];
			InitColumns(cols);
			SetEditable(1);
			resizeSheet(sheetObj);
		}
		break;
	case 3:
		with (sheetObj) {
			var HeadTitle0 = "trsp_so_seq";
			SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 1 });
			var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
			var headers = [ { Text : HeadTitle0, Align : "Center" } ];
			InitHeaders(headers, info);
			var cols = [ { Type : "Text", Hidden : 0, Width : 90, Align : "Center", ColMerge : 1, SaveName : "trsp_so_seq", KeyField : 0, UpdateEdit : 1, InsertEdit : 0 }];
			InitColumns(cols);
			SetEditable(1);
			SetVisible(false);
		}
		break;
	}
}

function resizeSheet(sheetObject) {
	ComResizeSheet(sheetObject);
}

var beforesheet = 0;
function ChangSheet(nItem) {
	var objs = document.all.item("tabLayer");
	objs[nItem].style.display = "Inline";
	objs[beforesheet].style.display = "none";

	objs[beforesheet].style.zIndex = objs[nItem].style.zIndex - 1;
	beforesheet = nItem;
}

function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH:
			formObj.f_cmd.value = SEARCH;
			sheet1_Clear();
			sheetObj.DoSearch("ESD_TRS_0083_01GS.do", TrsFrmQryString(formObj), { Sync : 2 });
			sheetObj.SetExtendLastCol(true);
			break;
		case IBSAVE:
			break;
		case IBINSERT:
			sheetObj.DataInsert();
			break;
	}
}

function doActionIBSheet2(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH:
			formObj.f_cmd.value = SEARCH01;
			sheetObj.DoSearch("ESD_TRS_0083_01GS.do", TrsFrmQryString(formObj), { Sync : 2 });
			sheetObj.SetExtendLastCol(true);
			break;
		case IBSAVE:
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESD_TRS_0083_01GS.do", TrsFrmQryString(formObj));
			break;
	}
}

function doActionIBSheet3(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH:
			formObj.f_cmd.value = SEARCH02;
			sheetObj.DoSearch("ESD_TRS_0083_01GS.do", TrsFrmQryString(formObj));
			sheetObj.SetExtendLastCol(true);
			break;
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	var formObject = document.form;
	if (sheetObj.RowCount() > 0) {
		var preRowLoc = sheetObj.GetCellValue(1, 'dor_loc_cd');
		var curRowLoc = "";
		var errMessage = "";
		var naCd = preRowLoc.substr(0, 2);
		if (!(naCd == 'US' || naCd == 'CA')) {
			ComShowCodeMessage('TRS90386', 'System only accepts US and CA I/B Door');
			return;
		}

		if (sheetObj.RowCount() > 1) {
			for ( var i = 1; i <= sheetObj.RowCount(); i++) {
				curRowLoc = sheetObj.GetCellValue(i, 'dor_loc_cd');
				if (curRowLoc != preRowLoc) {
					ComShowCodeMessage('TRS90386', 'Multiple DEL are not allowed');
					return;
				}
				preRowLoc = curRowLoc;
			}
		}
		document.form.cust_cnt_cd.value = sheetObj.GetCellValue(1, 'cust_cnt_cd');
		document.form.cust_seq.value = sheetObj.GetCellValue(1, 'cust_seq');
		document.form.cust_nm.value = sheetObj.GetCellValue(1, 'cust_nm');
		document.form.dor_loc_cd.value = sheetObj.GetCellValue(1, 'dor_loc_cd');
		document.form.zone_cd.value = sheetObj.GetCellValue(1, 'zone_cd');
	} else {
		sheet1_Clear();
	}
	doActionIBSheet2(sheetObject1, formObject, IBSEARCH);
	doActionIBSheet3(sheetObject2, formObject, IBSEARCH);
}

function sheet1_Clear() {
	document.form.cust_cnt_cd.value = "";
	document.form.cust_seq.value = "";
	document.form.cust_nm.value = "";
	document.form.dor_loc_cd.value = "";
	document.form.zone_cd.value = "";

	document.form.address.value = "";
	document.form.zip_code.value = "";
	document.form.pic.value = "";
	document.form.tel.value = "";
	document.form.fax.value = "";
	document.form.remark.value = "";

	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	sheetObject1.RemoveAll();
	sheetObject2.RemoveAll();
}

/**
 */
function sheet2_OnSaveEnd(sheetObj, errMsg) {
	if (errMsg.length > 0) {
		ComShowMessage(errMsg);
	}
}

function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
	var sheetObject2 = sheetObjects[2];
	if (sheetObject2.RowCount() > 0) {
		ComShowCodeMessage('TRS90386', 'S/O has already been created');
	}
}

/**
 * ?? Trunk VVD popup
 */
function openMultipleinquiry(obj, obj2) {
	var formObject = document.form;
	var cmdt_cd_val = "";
	var rep_cmdt_cd_val = "";
	var cmdt_desc_val = "";

	var xx1 = ""; // CONTI
	var xx2 = ""; // SUB CONTI
	var xx3 = ""; // COUNTRY
	var xx4 = ""; // STATE
	var xx5 = ""; // CONTROL OFFIC
	var xx6 = ""; // LOC CODE
	var xx7 = ""; // LOC NAME
	var xx8 = "";
	var xx9 = "";
	var classId = "getTRS_ENS_906";

	var param = "?returnval=" + obj + "&returntitle=" + obj2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9 + "&pgmNo=ESD_TRS_0083";
	ComOpenPopup('ESD_TRS_0906.do' + param, 400, 405, "getTRS_ENS_906", "1,0", true);
}

/**
 * Location :
 */
function getTRS_ENS_906(rowArray, obj) {
	var reObj = "";
	var formObject = document.form;
	for ( var i = 0; i < rowArray.length; i++) {
		var colArray = rowArray[i];
		if (i == rowArray.length - 1) {
			reObj = reObj + colArray;
		} else {
			reObj = reObj + colArray + ",";
		}
	}
	if (obj == "BKG") {
		formObject.booking_no.value = reObj;
	} else if (obj == "BLN") {
		formObject.bill_no.value = reObj;
	} else {
		ComShowCodeMessage('TRS90132');
	}
}

// Pop-Up? Return ? Actual Customer
/*
 * 0. TARGET ROW 1. ACTUAL CUSTOMER CODE 2. ACTUAL CUSTOMER NAME 3. FACTORY NAME 4. FACTORY ZIP CODE 5. FACTORY ADDRESS 6. FACTORY ADDRESS SEQ. 7. TEL NO 8. FAX NO 9. PIC NAME
 */
function applyAtualCustomer(winObj, selected_row, act_cust_cd, act_cust_cnt_cd, act_cust_seq, act_cust_addr_seq, act_cust_nm, factory_nm, factory_zip_code, factory_addr, factory_tel_no, factory_fax_no, pic_nm, iRemark) {
	var formObject = document.form;
	formObject.cust_cnt_cd.value = act_cust_cnt_cd;
	formObject.cust_seq.value = act_cust_seq;

	formObject.cust_nm.value = factory_nm;
	formObject.address.value = factory_addr;
	formObject.zip_code.value = factory_zip_code;
	formObject.pic.value = pic_nm;
	formObject.tel.value = factory_tel_no;
	formObject.fax.value = factory_fax_no;
	formObject.remark.value = iRemark;
}