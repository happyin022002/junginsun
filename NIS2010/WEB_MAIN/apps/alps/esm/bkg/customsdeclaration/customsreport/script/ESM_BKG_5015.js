/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_5015.js
 *@FileTitle : ESM_BKG_5015.js
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.07
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.08.07 김승민
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends
 * @class esm_bkg_0881 : esm_bkg_0881 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_5015() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var rdObject = rdObjects[0];

	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_print":

			rdPrint(rdObject);

			break;

		case "btn_close":
			window.close();
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
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage(vvd, pol, etd) {
	rdOpen();
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {

	return true;
}

/*
 *Rd 설정
 */
function initRdConfig(rdObject) {

	var Rdviewer = rdObject;

	Rdviewer.AutoAdjust = true;
	Rdviewer.ViewShowMode(0);
	Rdviewer.setbackgroundcolor(128, 128, 128);
	Rdviewer.SetPageLineColor(128, 128, 128);
	// Rdviewer.style.height = 0;

}

/*
 * RD 오픈  및 미리보기
 */
function rdOpen() {
	var sXml = "";
	var opener_obj = opener;
	var form1 = opener_obj.document.form;
	// alert();
	var opener_sheet_obj1 = opener_obj.document.sheet2;

	sXml = "<?xml version='1.0' ?><SHEET>";
	sXml += RD_GetDataSearchXml(opener_sheet_obj1, 1);
	sXml += "\n<ETC>";
	sXml += "<VVD>" + form1.in_vvd_cd.value + "</VVD>";
	sXml += "<POD>" + form1.in_pod_cd.value + "</POD>";
	sXml += "</ETC>";
	sXml += "</SHEET>";

	// alert(sXml);

	// rdObjects[0].AutoAdjust = true;
	// rdObjects[0].HideToolbar();
	// rdObjects[0].HideStatusbar();
	// rdObjects[0].ViewShowMode(0);

	// rdObjects[0].setbackgroundcolor(128,128,128);
	// rdObjects[0].SetPageLineColor(128,128,128);

	rdObjects[0].SetRData(sXml);
	var urlPath = RD_path + 'apps/alps/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_5015.mrd';

	// urlPath =
	// "http://localhost:7001/hanjin/apps/alps/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_5015.mrd";

	rdObjects[0].FileOpen(urlPath, RDServer);

}

/**
 * RD 출력
 * @param rdObject
 * @return
 */
function rdPrint(rdObject) {
	var Rdviewer = rdObject;

	Rdviewer.PrintDialog();
	// Rdviewer.CMPrint();
}
