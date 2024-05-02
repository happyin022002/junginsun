/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0003.js
 *@FileTitle  : CY & Door S/O Creation Detail Input
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/08/05
=========================================================*/

var localopener = window.parent;
if (!localopener)
	localopener = window.opener;

var sheetObjectP = localopener.t1sheet1;
var sheetObjects = new Array();
var sheetCnt = 0;
var lvFromNode = "";
var lvViaNode = "";
var lvToNode = "";
var lvDoorLoc = "";
/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// html컨트롤 이벤트초기화
	initControl();
}
/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	axon_event.addListenerFormat('blur', 'obj_blur', form);
	axon_event.addListenerFormat('focus', 'obj_focus', form);
	axon_event.addListener('change', 'customer_change', 'cus_cust_nm');
}
/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 */
function obj_blur() {
	return ComChkObjValid(ComGetEvent());
}
/**
 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
 */
function obj_focus() {
	ComClearSeparator(ComGetEvent());
}
/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
 */
function obj_keypress() {
	ComKeyOnlyNumber(ComGetEvent());
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
	        var HeadTitle="STS";
	        SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataGetRowMerge:1 } );
	        var info={ Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers=[ { Text:HeadTitle, Align:"Center"} ];
	        InitHeaders(headers, info);
	        var cols=[ {Type:"Status",    Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
	        InitColumns(cols);
	        SetEditable(0);//전체Edit허용여부[선택,Defaultfalse]
	        SetVisible(false);
			}
		break;
	}
}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		// form 이름에 주의하시기 바랍니다.
		switch (srcName) {
			case "btn_apply":
				if (fnChkForm(formObject)) {
					doApplyAction(sheetObjectP, formObject);
				}
				break;
			case "btns_frmnode": // FromNode Popup창
				openHireYardPopup('getFromNode');
				break;
			case "btns_vianode": // ViaNode Popup창
				openHireYardPopup('getViaNode');
				break;
			case "btns_tonode": // ToNode Popup창
				openHireYardPopup('getToNode');
				break;
			case "btns_actualcust": { // Actual Customer창
				popActualCustomer(sheetObject, formObject);
				break;
			}
			case "btns_dorloc": {
				// DoorLocation Popup창
				openHireYardPopup('getDorLoc');
				break;
			}
			case "btn_close":
				ComClosePopup();
				break;
		} // end switch
	} catch (e) {
		if (e = "[object Error]") {
			ComShowCodeMessage("TRS90108");
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * 
 * @param theForm
 * @returns {Boolean}
 */
function fnChkForm(theForm) {
	if (!doengnumcheck(theForm.act_cust_cd.value)) {
		theForm.act_cust_cd.focus();
		return false;
	}
	return true;
}
/**
 * 
 * @param sheetObj
 * @param formObj
 */
function doApplyAction(sheetObj, formObj) {
	var lvDocValue = "";
	var lvDocText = "";
	var lvDocChoi = "";
	var lvCrrValue = "";
	var lvCrrText = "";
	var lvCrrChoi = "";
	var fromRow = 0;
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	var lv_cost_mode_cd = formObj.trsp_cost_dtl_mod_cd.value;
	if (lv_cost_mode_cd == "DOOR") {
		for ( var i = 0; i < formObj.dor_svc_tp_cd.length; i++) {
			lvDocValue = formObj.dor_svc_tp_cd.options[i].value + "|" + lvDocValue;
			lvDocText = formObj.dor_svc_tp_cd.options[i].text + "|" + lvDocText;
			lvDocChoi = formObj.dor_svc_tp_cd.value;
		}
	}
	for ( var i = 0; i < formObj.trsp_crr_mod_cd.length; i++) {
		lvCrrValue = formObj.trsp_crr_mod_cd.options[i].value + "|" + lvCrrValue;
		lvCrrText = formObj.trsp_crr_mod_cd.options[i].text + "|" + lvCrrText;
		lvCrrChoi = formObj.trsp_crr_mod_cd.value;
	}
	for ( var i = 0; i < arrRow.length; i++) {
		fromRow = arrRow[i];
		if (sheetObj.GetCellValue(fromRow, "chk1") == "1") {
			if (formObj.act_cust_cd.value != '') {
				sheetObj.SetCellValue(fromRow, "act_cust_cd", formObj.act_cust_cd.value, 0);
			}
			if (formObj.act_cust_cnt_cd.value != '') {
				sheetObj.SetCellValue(fromRow, "act_cust_cnt_cd", formObj.act_cust_cnt_cd.value, 0);
			}
			if (formObj.act_cust_seq.value != '') {
				sheetObj.SetCellValue(fromRow, "act_cust_seq", formObj.act_cust_seq.value, 0);
			}
			if (formObj.act_cust_addr_seq.value != '') {
				sheetObj.SetCellValue(fromRow, "act_cust_addr_seq", formObj.act_cust_addr_seq.value, 0);
			}
			if (formObj.factory_nm.value != '') {
				sheetObj.SetCellValue(fromRow, "fctry_nm", formObj.factory_nm.value, 0);
			}
			if (formObj.factory_zip_code.value != '') {
				sheetObj.SetCellValue(fromRow, "dor_pst_cd", formObj.factory_zip_code.value, 0);
			}
			if (formObj.factory_addr.value != '') {
				sheetObj.SetCellValue(fromRow, "dor_de_addr", formObj.factory_addr.value, 0);
			}
			if (formObj.factory_tel_no.value != '') {
				sheetObj.SetCellValue(fromRow, "cntc_pson_phn_no", formObj.factory_tel_no.value, 0);
			}
			if (formObj.factory_fax_no.value != '') {
				sheetObj.SetCellValue(fromRow, "cntc_pson_fax_no", formObj.factory_fax_no.value, 0);
			}
			if (formObj.pic_nm.value != '') {
				sheetObj.SetCellValue(fromRow, "cntc_pson_nm", formObj.pic_nm.value, 0);
			}
			if (doSepRemove(formObj.fm_nod_cd.value, " ") != "") {
				sheetObj.SetCellValue(fromRow, "fm_nod_cd", formObj.fm_nod_cd.value, 0);
				sheetObj.CellComboItem(fromRow, "fm_nod_yard", { ComboText : lvFromNode, ComboCode : lvFromNode });
				sheetObj.SetCellValue(fromRow, "fm_nod_yard", fm_nod_yard.GetSelectCode(), 0);
			}
			if (lvCrrChoi.indexOf("D") < 0) {
				if (doSepRemove(formObj.via_nod_cd.value, " ") != "") {
					sheetObj.SetCellValue(fromRow, "via_nod_cd", formObj.via_nod_cd.value, 0);
					sheetObj.CellComboItem(fromRow, "via_nod_yard", { ComboText : lvViaNode, ComboCode : lvViaNode });
					sheetObj.SetCellValue(fromRow, "via_nod_yard", via_nod_yard.GetSelectCode(), 0);
				}
				sheetObj.SetCellEditable(fromRow, "via_nod_cd", 1);
				sheetObj.SetCellEditable(fromRow, "via_nod_yard", 1);
			} else {
				sheetObj.SetCellValue(fromRow, "via_nod_cd", formObj.via_nod_cd.value, 0);
				sheetObj.CellComboItem(fromRow, "via_nod_yard", { ComboText : "", ComboCode : "" });
				sheetObj.SetCellValue(fromRow, "via_nod_yard", "", 0);
				sheetObj.SetCellEditable(fromRow, "via_nod_cd", 0);
				sheetObj.SetCellEditable(fromRow, "via_nod_yard", 0);
			}
			if (doSepRemove(formObj.to_nod_cd.value, " ") != "") {
				sheetObj.SetCellValue(fromRow, "to_nod_cd", formObj.to_nod_cd.value, 0);
				sheetObj.CellComboItem(fromRow, "to_nod_yard", { ComboText : lvToNode, ComboCode : lvToNode });
				sheetObj.SetCellValue(fromRow, "to_nod_yard", to_nod_yard.GetSelectCode(), 0);
			}
			if (doSepRemove(formObj.dor_nod_cd.value, " ") != "") {
				sheetObj.SetCellValue(fromRow, "dor_nod_cd", formObj.dor_nod_cd.value, 0);
				sheetObj.CellComboItem(fromRow, "dor_nod_yard", { ComboText : lvDoorLoc, ComboCode : lvDoorLoc });
				sheetObj.SetCellValue(fromRow, "dor_nod_yard", dor_nod_yard.GetSelectCode(), 0);
			}
			if (doSepRemove(lvCrrChoi, " ") != "") {
				sheetObj.CellComboItem(fromRow, "trsp_crr_mod_cd", { ComboText : lvCrrText, ComboCode : lvCrrValue });
				sheetObj.SetCellValue(fromRow, "trsp_crr_mod_cd", lvCrrChoi);
			}
			if (formObj.trsp_cost_dtl_mod_cd.value == "DOOR") {
				sheetObj.CellComboItem(fromRow, "dor_svc_tp_cd", { ComboText : lvDocText, ComboCode : lvDocValue });
				sheetObj.SetCellValue(fromRow, "dor_svc_tp_cd", lvDocChoi);
			}
			if (doSepRemove(formObj.remark.value, " ") != "") {
				sheetObj.SetCellValue(fromRow, "spcl_instr_rmk", formObj.remark.value);
			}
		}
	}
	ComClosePopup();
}
/**
 * ACTUAL CUSTOMER POPUP
 */
function popActualCustomer(sheetObject, formObject) {
	var url = 'ESD_TRS_0914.screen?act_loc=&zone_cd=&conti_cd=' + document.form.CONTI_CD.value;
	ComOpenPopup(url, 800, 565, "ESD_TRS_0914", '0,0', false);
}

/**
 * 
 * @param winObj
 * @param row
 * @param act_cust_cd
 * @param act_cust_cnt_cd
 * @param act_cust_seq
 * @param act_cust_addr_seq
 * @param act_cust_nm
 * @param factory_nm
 * @param factory_zip_code
 * @param factory_addr
 * @param factory_tel_no
 * @param factory_fax_no
 * @param pic_nm
 */
function applyAtualCustomer(winObj, row, act_cust_cd, act_cust_cnt_cd, act_cust_seq, act_cust_addr_seq, act_cust_nm, factory_nm, factory_zip_code, factory_addr, factory_tel_no, factory_fax_no, pic_nm) {
	var formObj = document.form;
	formObj.act_cust_cd.value = act_cust_cd;
	formObj.factory_nm.value = factory_nm;
	formObj.act_cust_cnt_cd.value = act_cust_cnt_cd;
	formObj.act_cust_seq.value = act_cust_seq;
	formObj.act_cust_addr_seq.value = act_cust_addr_seq;
	formObj.factory_nm.value = factory_nm;
	formObj.factory_zip_code.value = factory_zip_code;
	formObj.factory_addr.value = factory_addr;
	formObj.factory_tel_no.value = factory_tel_no;
	formObj.factory_fax_no.value = factory_fax_no;
	formObj.pic_nm.value = pic_nm;
}
/**
 * 
 */
function getParamInfo() {
	var formObj = document.form;
	var lvFromNode = localopener.HGet("FN");
	var lvViaNode = localopener.HGet("VN");
	var lvToNode = localopener.HGet("TN");
	var lvDoorLoc = localopener.HGet("DR");
	var lvTransMode = localopener.HGet("TM");
	var lv_conti_cd = localopener.HGet("CONTI_CD");
	formObj.CONTI_CD.value = lv_conti_cd;
	formObj.trsp_cost_dtl_mod_cd.value = localopener.HGet("CM");
	var lv_cost_mode_cd = formObj.trsp_cost_dtl_mod_cd.value;
	if (lv_cost_mode_cd == 'CY') {
		formObj.btns_dorloc.style.visibility = "hidden";
		formObj.btns_actualcust.style.visibility = "hidden";
		formObj.dor_nod_cd.style.visibility = "hidden";
		formObj.factory_nm.style.visibility = "hidden";
		formObj.act_cust_cd.style.visibility = "hidden";
		formObj.org_dor_svc_tp_cd.style.visibility = "hidden";
	}
	if (lvFromNode.length > 5) {
		var doc = localopener.HGet("FN").split("|");
		document.form.old_fm_nod_cd.value = doc[0];
		document.form.old_fm_nod_yard.value = doc[1];
	}
	if (lvViaNode.length > 5) {
		var doc = localopener.HGet("VN").split("|");
		document.form.old_via_nod_cd.value = doc[0];
		document.form.old_via_nod_yard.value = doc[1];
	}
	if (lvToNode.length > 5) {
		var doc = localopener.HGet("TN").split("|");
		document.form.old_to_nod_cd.value = doc[0];
		document.form.old_to_nod_yard.value = doc[1];
	}
	if (lvDoorLoc.length > 5) {
		var doc = localopener.HGet("DR").split("|");
		document.form.old_dor_nod_cd.value = doc[0];
		document.form.old_dor_nod_yard.value = doc[1];
	}
	document.form.trsp_crr_mod_cd.value = lvTransMode;
}
/*
 * 외부 콤보박스의 리스트 가져오기 (ESD_TRS_0002.js에도 존재).
 */
function getComboList(obj, comObj, sep) { // object, 값을 받는부분, 'Node종류
	comObj = eval(comObj.id);
	var formObj = document.form;
	var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
	obj.value = lvobj;
	if (lvobj == "") {
		obj.value = "";
		comObj.RemoveAll();
		return false;
	} else if (lvobj.length != 5) {
		errMsg = ComGetMsg("TRS90074");
		ComShowMessage(errMsg);
		obj.value = "";
		comObj.RemoveAll();
		return false;
	}
	if (!doengnumcheck(lvobj)) {
		obj.value = "";
		obj.focus();
		comObj.RemoveAll();
		return false;
	}
	if (sep == 'F') {
		lvFromNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		if (lvFromNode == "") {
			ComShowCodeMessage('COM12161', lvobj);
			obj.value = "";
			comObj.RemoveAll();
		}
	} else if (sep == 'V') {
		lvViaNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		if (lvViaNode == "") {
			ComShowCodeMessage('COM12161', lvobj);
			obj.value = "";
			comObj.RemoveAll();
		}
	} else if (sep == 'T') {
		lvToNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		if (lvToNode == "") {
			ComShowCodeMessage('COM12161', lvobj);
			obj.value = "";
			comObj.RemoveAll();
		}
	} else if (sep == 'D') {
		lvDoorLoc = getZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
		if (lvDoorLoc == "") {
			ComShowCodeMessage('COM12161', lvobj);
			obj.value = "";
			comObj.RemoveAll();
		}
	}
}
/**
 * 공통 Node popup
 */
function openHireYardPopup(objName) {
	var formObject = document.form;
	var cmdt_cd_val = ""; // 향후 사용가능 예정변수
	var rep_cmdt_cd_val = ""; // 향후 사용가능 예정변수
	var cmdt_desc_val = ""; // 향후 사용가능 예정변수
	var classId = objName;
	var xx1 = ""; // CONTI
	var xx2 = ""; // SUB CONTI
	var xx3 = ""; // COUNTRY
	var xx4 = ""; // STATE
	var xx5 = ""; // CONTROL OFFIC
	var xx6 = ""; // LOC CODE
	var xx7 = ""; // LOC NAME
	var xx8 = "";
	var xx9 = "";
	var mode = "";
	if (objName == "getDorLoc") {
		mode = "zone"
	} else {
		mode = "yard";
	}
	var param = "?conti_cd=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9 + "&mode=" + mode;
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * popSearchPiCommCodeGrid 프로세스 처리
 */
function popSearchPiCommCodeGrid(classID, midCD, cdName, sheetName, sRow, colCode, colName) {
	var myUrl = getPopupURL(POPUP_PI_COMM);
	var myOption = getPopupOption(POPUP_PI_COMM);
	var url;
	if (myWin != null) {
		ComClosePopup();
	}
	url = myUrl + "?class_id=" + classID + "&mid_cd=" + midCD + "&cdName=" + cdName + "&sheetName=" + sheetName + "&sRow=" + sRow + "&colCode=" + colCode + "&colName=" + colName;
	myWin = window.open(url, "piCommCodePop", myOption);
	myWin.focus();
}
/**
 * From Node 팝업에 대한 리턴값
 */
function getFromNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.fm_nod_cd.value = lvLoc;
	getYardCombo(fm_nod_yard, sheetObjects[0], formObject, lvLoc);
	fm_nod_yard.SetSelectCode(lvYard);
}
/**
 * Via Node 팝업에 대한 리턴값`
 */
function getViaNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.via_nod_cd.value = lvLoc;
	getYardCombo(via_nod_yard, sheetObjects[0], formObject, lvLoc);
	via_nod_yard.SetSelectCode(lvYard);
}
/**
 * To Node 팝업에 대한 리턴값
 */
function getToNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.to_nod_cd.value = lvLoc;
	getYardCombo(to_nod_yard, sheetObjects[0], formObject, lvLoc);
	to_nod_yard.SetSelectCode(lvYard);
}
/**
 * Door Location 팝업에 대한 리턴값
 */
function getDorLoc(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);

	formObject.dor_nod_cd.value = lvLoc;
	getZoneCombo(dor_nod_yard, sheetObjects[0], formObject, lvLoc);
	dor_nod_yard.SetSelectCode(lvYard);
}
