
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0982.js
*@FileTitle : ESM_BKG_0982
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.03 경종윤
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
	 * @author
	 */

	/**
	 * @extends
	 * @class ESM_BKG_0982 : ESM_BKG_0982 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_BKG_0982() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}


// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
			// var sheetObject1 = sheetObjects[0];
		 /*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_close":
					ComClosePopup();
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
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {

	}


