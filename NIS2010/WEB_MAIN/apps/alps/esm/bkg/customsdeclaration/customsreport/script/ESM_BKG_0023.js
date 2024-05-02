/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0023.js
 *@FileTitle : Customer Code Entry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.16
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.16 김민정
 * 1.0 Creation
=========================================================*/
// 공통전역변수
var docObjects = new Array();
var sheetCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_Close":
			window.close();
			break;
		case "btn_Print":
			rdObjects[0].PrintDialog();
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComFuncErrMsg(e);
		} else {
			ComFuncErrMsg(e);
		}
	}
}

/**
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 * @param vvd VVD
 * @param pod POD
 * @param del DEL
 * @param bl BL No.
 */
function loadPage(vvd, pod, del, bl) {
	rdOpen(vvd, pod, del, bl);
}

/**
 * print화면 오픈
 * @param vvd VVD
 * @param pod POD
 * @param del DEL
 * @param bl BL No.
 */
function rdOpen(vvd, pod, del, bl) {
	var sXml = "";
	var opener_obj = opener;
	var form = opener_obj.document.form;
	var opener_sheet_obj1 = opener_obj.document.sheet1;

	sXml = "<?xml version='1.0' ?><SHEET>";
	sXml += RD_GetDataSearchXml(opener_sheet_obj1, 1);
	sXml += "<ETC>";
	sXml += "<VVD>" + form.vvd_cd.value + "</VVD>"
	sXml += "<POD>" + form.pod_cd.value + "</POD>"
	sXml += "<DEL>" + form.del_cd.value + "</DEL>"
	sXml += "<BLNO>" + form.sch_bl_no.value + "</BLNO>"
	sXml += "</ETC>";
	sXml += "</SHEET>";

	rdObjects[0].AutoAdjust = true;
	// rdObjects[0].HideToolbar();
	rdObjects[0].HideStatusbar();
	rdObjects[0].ViewShowMode(0);

	rdObjects[0].setbackgroundcolor(128, 128, 128);
	rdObjects[0].SetPageLineColor(128, 128, 128);

	rdObjects[0].SetRData(sXml);
	rdObjects[0].FileOpen(RD_path + 'apps/alps/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_0023.mrd', RDServer);
}