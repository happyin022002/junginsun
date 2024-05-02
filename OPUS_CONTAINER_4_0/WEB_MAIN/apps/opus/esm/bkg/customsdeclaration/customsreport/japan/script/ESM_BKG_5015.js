/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_5015.js
*@FileTitle  : Manifest Data Download_Print Preview
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/18
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/* 개발자 작업	*/

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = ComGetEvent("name");

		switch (srcName) {
			case "btn_print":
				viewer.print({isServerSide:true});
				break;

			case "btn_close":
				ComClosePopup();
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

/*
 *Rd 설정
 */


/*
 * RD 오픈  및 미리보기
 */
function rdOpen() {
	var sXml = "";
	var opener_obj = opener;
	var form1 = opener_obj.document.form;
	// alert();
	var opener_sheet_obj1 = opener_obj.sheet1;
	var opener_sheet_obj2 = opener_obj.sheet2;

	sXml = "<?xml version='1.0' ?><SHEET>";
	sXml += RD_GetDataSearchXml(opener_sheet_obj2, 1);
	sXml += "<ETC>";
	sXml += "<VVD>" + opener_sheet_obj1.GetCellValue(1, "con_vvd") + "</VVD>";
	sXml += "<POD>" + form1.in_pod_cd.value + "</POD>";
	sXml += "</ETC>";
	sXml += "</SHEET>";

	//viewer.HideToolBar();
	viewer.setRData(sXml);
//	RD_path = "http://localhost:9001/opuscntr/"; // TEST용
	viewer.openFile(RD_path+"apps/opus/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_5015.mrd", RDServer, {timeout:1800});
}

