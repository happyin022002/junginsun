/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0208.js
 *@FileTitle  : Invoice Inquiry Correction Report
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/02
=========================================================*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author OPUS
 */
/**
 * @extends Bkg
 * @class ESD_TRS_0208 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0208() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.setTabObject = setTabObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initTab = initTab;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;
var comboObjects = new Array();
var comboCnt = 0;
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_close":
				ComClosePopup();
				break;
			case "btng_print":
				viewer.print({isServerSide:true});
				break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			errMsg = ComGetMsg("TRS90392");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e.message);
		}
	}
}

function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

function loadPage() {
	if (queryStr != '') {
		rdOpen(viewer, document.form);
		viewer.print({isServerSide:true});
	}
}

function rdOpen(formObject) {
	var rdParam = '/rp [' + queryStr + ']';
	viewer.openFile(RD_path + 'apps/opus/esd/trs/invoicemanage/invoiceinquirycorrection/report/ESD_TRS_0030.mrd', RDServer + rdParam, {timeout:1800});
}
