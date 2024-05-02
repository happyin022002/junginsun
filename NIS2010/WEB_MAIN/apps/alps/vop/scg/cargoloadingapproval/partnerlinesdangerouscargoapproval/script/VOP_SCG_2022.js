/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VOP_SCG_2022.js
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
 *----------------------------------------------------------
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
 * @author 한진해운
 */

/**
 * @extends
 * @class VOP_SCG_2022 : VOP_SCG_2022 업무 스크립트를 정의한다.
 */
function VOP_SCG_2022() {
	this.processButtonClick = processButtonClick;
	this.loadPage = loadPage;
	this.initControl = initControl;
}

/* 개발자 작업	*/
//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	var formObj = document.form;
	
	//Remark 조회
    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    
	formObj.remark.readOnly  = "readOnly";

}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {

	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	
	switch (srcName) {
	
		case "btn_close":
			window.close();
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction ) {
	sheetObj.ShowDebugMsg = false;
    sheetObj.WaitImageVisible=false;

	switch(sAction) {

		case IBSEARCH:      //조회
			e_info = formObj.info.value;
			if (typeof(e_info) != "undefined") {
				remark = e_info.split("`").join("\r\n");
				ComSetObjValue(formObj.remark, remark);
			}
       	break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */


/* 개발자 작업  끝 */