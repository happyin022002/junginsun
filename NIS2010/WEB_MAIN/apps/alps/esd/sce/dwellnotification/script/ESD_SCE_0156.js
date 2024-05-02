/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : ESD_SCE_0152.js
 *@FileTitle : Dwell/Delay Notification Sending Status Detail
 *Open Issues :
 *@LastModifyDate : 2011.07.25
 *@LastModifier : 이수진
 *@LastVersion : 1.0
 * 2011.07.25 이수진
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 =========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author SM LINE
 */

/**
 * @extends
 * @class ESD_SCE_0152 : ESD_SCE_0152 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */


function ESD_SCE_0152() {
	this.processButtonClick = tprocessButtonClick;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* 개발자 작업 */
//공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;
var rdObjects = new Array();
var rdCnt = 0;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {		
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

function initControl() {
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
 
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

 
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다e
 */
function loadPage() {
	rdInit(rdObjects[0]);
	rdOpen(rdObjects[0], document.form);
	
}
 

 function rdInit(rdObj){
		rdObj.AutoAdjust = true;
//		rdObj.HideToolbar();
		rdObj.SetSaveDialogEx("", "", "pdf", "pdf");
//		rdObj.DisableToolbar(13);
		rdObj.DisableToolbar(14);
		rdObj.DisableToolbar(16);
		rdObj.DisableToolbar(17);
		rdObj.HideStatusbar();
		rdObj.ViewShowMode(2);
		rdObj.setbackgroundcolor(255,255,255);
		rdObj.SetPageLineColor(255,255,255);
	}

 function rdOpen(rdObj, formObj){

		var rdParam = '/rp ';
		var queryStr= '[' + formObj.eml_snd_dt_param.value + '][' + formObj.cust_cd_param.value +'][' + formObj.dwll_tp_param.value +']' ;
		var strPath   =  "apps/alps/esd/sce/dwellnotification/report/ESD_SCE_0152.mrd";
		rdObj.FileOpen(RD_path+strPath, RDServer+rdParam+queryStr+"/rfonttype60");
	}