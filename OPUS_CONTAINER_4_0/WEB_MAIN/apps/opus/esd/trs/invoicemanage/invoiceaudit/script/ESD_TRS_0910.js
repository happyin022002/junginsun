/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESD_TRS_0910.js
 *@FileTitle : Currency Change Popup
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/09/15
=========================================================*/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author OPUS
 */
/**
 * @extends Bkg
 * @class ESD_TRS_0910 : Booking
 */
function ESD_TRS_0910() {
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
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_ok":
				if (formObject.ex_rate.value == '') {
					ComShowCodeMessage('TRS90214');
					break;
				}
				var cal_logic = formObject.woamount[0].checked ? formObject.woamount[0].value : formObject.woamount[1].value;
				opener.setCurrencyChange(formObject.sel_invoicemode.value, formObject.ex_rate.value, cal_logic);
				ComClosePopup();
				break;
			case "btn_close":
				ComClosePopup();
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
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var formObject = document.form;
	formObject.sel_invoicemode.value = formObject.hid_invoicemode.value;
	formObject.sel_invoicemode.disabled = true;
}

function fun_addcomma() {
	var formObject = document.form;
	str = formObject.ex_rate.value;
	num = "";
	for ( var i = 0; i < str.length; i++) {
		if (str.charAt(i) != ",") {
			num = num + str.charAt(i);
		} else {
			break;
		}
	}
	formObject.ex_rate.value = num + str.substring(i, i + 3);
}
function del_comma(str) {
	num = "";
	for ( var i = 0; i < str.length; i++) {
		if (str.charAt(i) != ",") {
			num = num + str.charAt(i);
		}
	}
	return num;
}
/**
 * SOcheck.
 */
function fn_check(obj, val) {
	var formObject = document.form;
	var inputStr = obj.value;
	var value = obj.value;
	var charval = "Y";
	var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
	var numExRate = Number(inputStr);
	lvobj = obj.value;
	if (lvobj != "") {
		for ( var i = 0; i < inputStr.length; i++) {
			var oneChar = inputStr.charAt(i);
			if (oneChar != "" && numExRate > 0) {
				if ((oneChar >= "0" && oneChar <= "9") || (oneChar == ",") || (oneChar == ".")) {
				} else {
					charval = "N";
					break;
				}
			} else {
				charval = "N";
				break;
			}
		}
		if (charval == "Y") {
			formObject.ex_rate.value = chkAmtPos(formObject.ex_rate.value, 4); // Exchange Rate
			fn_checknum();
		} else {
			var errMessage = ComGetMsg('COM12122', val, '', '');
			ComShowMessage(errMessage);
			obj.value = "";
			obj.focus();
		}
	}
}
/**
 * 라디오버튼을 누를시 period
 */
function change_amount() {
	fn_checknum();
}
/**
 * 콤보박스 -bound
 */
function invoice_OnChang(obj) {
	var codeval = obj.value;
	var formObject = document.form;
	formObject.hid_invoicemode.value = codeval;
	fn_checknum();
}
function fn_checknum() {
	var formObject = document.form;
	var x1 = formObject.ex_rate.value;
	var x2 = formObject.wo_totamount.value;
	if ((x1 == "" && x2 == "") || (x1 == "" || x2 == "")) {
		formObject.invoice_amount.value = "";
	} else {
		if (formObject.woamount[0].checked) {
			var tot_gum = x2 * x1;
		} else {
			if (x1 == "0") {
				var tot_gum = 0;
			} else {
				var tot_gum = x2 / x1;
			}
		}
		formObject.invoice_amount.value = chkAmtPos(tot_gum, 4);
	}
}
/**
 * enter check
 */
function enterCheck(obj) {
	var formObj = document.form;
	if (event.keyCode == 13) {
		switch (ComGetEvent("name")) {
			case 'ex_rate':
				fn_checknum();
				break;
		}
	}
}
