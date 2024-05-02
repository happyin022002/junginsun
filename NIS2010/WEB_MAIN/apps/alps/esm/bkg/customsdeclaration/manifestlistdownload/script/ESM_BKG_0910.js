/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0910.js
*@FileTitle : Korea Manifest Main Menu
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.03 박상훈
* 1.0 Creation 
=========================================================*/

/**
 * JSDOC 생성을 위한 함수 정의
 */
function esm_bkg_0910()
{
	this.processButtonClick		= processButtonClick;
	this.openNewWin				= openNewWin;
	this.loadPage				= loadPage;
}

//공통전역변수

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 * @return
 */
function processButtonClick(){

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
		case "btn_mrnCreate":
			openNewWin("ESM_BKG_0371");
			break;
		case "btn_mrnInquiry":
			openNewWin("ESM_BKG_0358");
			break;
		case "btn_manifestGen":
			openNewWin("ESM_BKG_0337");
			break;
		case "btn_whAssign":
			openNewWin("ESM_BKG_0333");
			break;
		case "btn_printIfm":
			openNewWin("ESM_BKG_0341");
			break;
		case "btn_printDisch":
			openNewWin("ESM_BKG_0340");
			break;
		case "btn_downLoad":
			openNewWin("ESM_BKG_0329");
			break;
		case "btn_amendTrans":
			openNewWin("ESM_BKG_0030");
			break;
		case "btn_transHist":
			openNewWin("ESM_BKG_0502");
			break;
		case "btn_recvHist":
			openNewWin("ESM_BKG_0917");
			break;
		case "btn_transCargo":
			openNewWin("ESM_BKG_0212");
			break;
		case "btn_transVessel":
			openNewWin("ESM_BKG_0344");
			break;
		case "btn_downloadHist":
			openNewWin("ESM_BKG_0215");
			break;
		case "btn_cargoPrint":
			openNewWin("ESM_BKG_0418");
			break;
		case "btn_genCargoManifest":
			openNewWin("ESM_BKG_0274");
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * 메뉴를 OPEN 
 * @param pgmNo
 * @return
 */
function openNewWin(pgmNo) {
	var Url = "/hanjin/alpsMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^hanjin^";
	Url = Url + pgmNo +".do&pgmNo="+pgmNo;
	var iWidth  = 1040;
	var iHeight = 700;
	var leftPos = (screen.width - iWidth)/2;
	if (leftPos < 0) leftPos = 0;
	var topPos = (screen.height-iHeight)/2;
	if (topPos < 0) topPos =0;
	
	window.open(Url, pgmNo+"Win", "width="+iWidth+", height="+iHeight+", resizable=yes, top="+topPos+", left="+leftPos);
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
}
