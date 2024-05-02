/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : ESM_BKG_1014.js
 *@FileTitle : ESM_BKG_1014
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/13
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 
 */
/* 개발자 작업 */
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	//alert("test");
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Ok":
			//alert("test");
			if (formObj.start_index.value == ""
					|| formObj.start_index.value * 1 < 1) {
				ComShowCodeMessage('BKG06081');
				formObj.start_index.focus();
				return;
			}
			if (formObj.end_index.value == "") {
				ComShowCodeMessage('BKG06081');
				formObj.end_index.focus();
				return;
			}
			opener.setData(formObj.start_index.value, formObj.end_index.value,
					formObj.ts.value, formObj.pod.value, formObj.mlb.value,
					formObj.yd.value);
			ComClosePopup(); 
			break;
		case "btn_Close":
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
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param sheet_obj IBSheet Object
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	document.form.start_index.focus();
	// alert(document.form.inCllType.value);
	if (document.form.inCllType.value == "LOCAL"
			|| document.form.inCllType.value == "EMPTY"){
		document.form.ts.disabled=true;
	}
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
	// ** Date 구분자 **/
	DATE_SEPARATOR="-";
	var formObject=document.form;
	// 키보드
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}
/* 개발자 작업 끝 */
