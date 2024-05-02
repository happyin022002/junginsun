/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0884.js
*@FileTitle  : PSA Import Status I/F Print
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/19
=========================================================*/
/**
 * JSDOC 생성을 위한 함수 정의
 */
function esm_bkg_0884() {
	this.processButtonClick = processButtonClick;
	this.loadPage=loadPage;
	this.rdOpen=rdOpen;
	this.RD_GetSelectedDataSearchXml=RD_GetSelectedDataSearchXml;
}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러  정의 */

document.onclick=processButtonClick;
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btn_Close":
			ComClosePopup();
			break;
		case "btn_Print":
			viewer.print({isServerSide:true});
			break;
		} // end switch
	} catch(e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}


/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	rdOpen();
}


/**
 * print화면 오픈
 * print할수 있는 화면 오픈
 */
function rdOpen(){
	var sXml = "";
	var opener_obj = opener;
	var form = opener_obj.document.form;
	var opener_sheet_obj1 = opener_obj.sheet1;
	sXml="<?xml version='1.0' ?><SHEET>";
	sXml += RD_GetDataSearchXml(opener_sheet_obj1, 1);
	sXml += "<ETC>" ;
	sXml += "<VVD>"+form.vvd.value+"</VVD>" ;
	sXml += "<POD>"+form.pod_cd.value+"</POD>";
	sXml += "</ETC>";
	sXml += "</SHEET>";
	viewer.setRData(sXml);
//	RD_path = "http://localhost:9001/opuscntr/"; // TEST용
	if (titlePrefix != "") {
		var urlPath = RD_path;
		if (titlePrefix == "PSA") {
			urlPath += "apps/opus/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_0884.mrd";
		} else {
			urlPath += "apps/opus/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_0884_2.mrd";
		}
		viewer.openFile(urlPath, RDServer, {timeout:1800});
	}
}
