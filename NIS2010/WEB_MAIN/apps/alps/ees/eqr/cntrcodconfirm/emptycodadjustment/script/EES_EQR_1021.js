/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_EQR_1021.js
 *@FileTitle : MTY COD Simulation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.31
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.07.31 박광석
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
 * @class EES_EQR_1021 : EES_EQR_1021 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_eqr_1021() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */
// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	// var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			frameLayer0.doActionIBSheet(frameLayer0.sheetObjects[4], frameLayer0.document.form, IBSEARCH);
			frameLayer0.sheetObjects[0].SelectRow = 0;
			frameLayer0.sheetObjects[1].SelectRow = 0;
			frameLayer0.sheetObjects[2].SelectRow = 0;
			frameLayer0.sheetObjects[3].SelectRow = 0;
			frameLayer0.sheetObjects[4].SelectRow = 0;
			frameLayer0.sheetObjects[5].SelectRow = 0;
			frameLayer0.sheetObjects[6].SelectRow = 0;
			frameLayer0.sheetObjects[7].SelectRow = 0;
			frameLayer0.sheetObjects[8].SelectRow = 0;
			frameLayer0.sheetObjects[9].SelectRow = 0;
			break;

		case "btn_new":
			frameLayer0.initControl();
			frameLayer0.sheetObjects[0].RemoveAll();
			frameLayer0.sheetObjects[1].RemoveAll();
			frameLayer0.sheetObjects[2].RemoveAll();
			frameLayer0.sheetObjects[3].RemoveAll();
			frameLayer0.sheetObjects[4].RemoveAll();
			frameLayer0.sheetObjects[5].RemoveAll();
			frameLayer0.sheetObjects[6].RemoveAll();
			frameLayer0.sheetObjects[7].RemoveAll();
			frameLayer0.sheetObjects[8].RemoveAll();
			frameLayer0.sheetObjects[9].RemoveAll();
			frameLayer0.sheetObjects[10].RemoveAll();
			frameLayer0.sheetObjects[11].RemoveAll();
			formObject.trade.value = "";
			formObject.week.value = "";
			document.form.reset();
			frameLayer0.document.form.reset();
			frameLayer0.radio_click();
			ComSetFocus(formObject.week);
			break;

		case "btn_save":
			frameLayer0.doActionIBSheet(frameLayer0.sheetObjects[10], frameLayer0.document.form, IBSAVE);
			break;

		case "btn_downexcel":
			if (frameLayer0.sheetObjects[0].RowCount > 0)
				frameLayer0.sheetObjects[0].Down2Excel(-1, false, false);

			if (frameLayer0.sheetObjects[2].RowCount > 0)
				frameLayer0.sheetObjects[2].Down2Excel(-1, true, false);
			if (frameLayer0.sheetObjects[4].RowCount > 0)
				frameLayer0.sheetObjects[4].Down2Excel(-1, true, false);
			if (frameLayer0.sheetObjects[6].RowCount > 0)
				frameLayer0.sheetObjects[6].Down2Excel(-1, true, false);
			if (frameLayer0.sheetObjects[8].RowCount > 0)
				frameLayer0.sheetObjects[8].Down2Excel(-1, true, false);
			if (frameLayer0.sheetObjects[1].RowCount > 0)
				frameLayer0.sheetObjects[1].Down2Excel(-1, true, false);
			if (frameLayer0.sheetObjects[3].RowCount > 0)
				frameLayer0.sheetObjects[3].Down2Excel(-1, true, false);
			if (frameLayer0.sheetObjects[5].RowCount > 0)
				frameLayer0.sheetObjects[5].Down2Excel(-1, true, false);
			if (frameLayer0.sheetObjects[7].RowCount > 0)
				frameLayer0.sheetObjects[7].Down2Excel(-1, true, false);
			if (frameLayer0.sheetObjects[9].RowCount > 0)
				frameLayer0.sheetObjects[9].Down2Excel(-1, true, false);
			break;

		case "btn_mainretrieve":

			frameLayer0.searchVvd(document.form.searchvvd.value, document.form.searchvvd);
			break;

		case "btn_remark":
			frameLayer0.remarkPop();
			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			alert("지금은 사용하실 수가 없습니다 ");
		} else {
			alert(e);
		}
	}
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
 * 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	initControl();
}

/**
 * initControl
 * 
 * @return
 */
function initControl() {
//	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListener('keypress', 'obj_keypress', 'form');
//	axon_event.addListenerFormat('keyup', 'form_keyup', document.form);
	axon_event.addListenerFormat('focus', 'obj_activate', document.form); // -OnBeforeActivate이벤트
	axon_event.addListenerForm('blur', 'obj_deactivate', document.form);  // -OnBeforeDeactivate이벤트
	axon_event.addListener('click', 'radio_click', 'tpsz', '');
	ComSetFocus(document.form.week);
}

function radio_click() {
	frameLayer0.radio_click();
}

function ComBtnEnable_frameLayer0(val) {
	ComBtnEnable(val);
}

function ComBtnDisable_frameLayer0(val) {
	ComBtnDisable(val);
}

// Axon 이벤트 처리2. 이벤트처리함수
function obj_deactivate() {
	var w = document.getElementById("week");
	if (ComChkObjValid(event.srcElement, false)) {
		// 주별로 조회
		sVal1 = w.value.replace(/\/|\-|\./g, "");

		frameLayer0.document.form.week.value = sVal1;
	} else {
		// 주별로 조회
		sVal1 = w.value.replace(/\/|\-|\./g, "");

		if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6))) {
			event.srcElement.value = "";
			ComShowCodeMessage("EQR90211", "YYYYWW");
			document.form.week.focus();
			return false;
		}
	}

	return true;
}

/**
 * 포커스 인...
 * 
 * @return
 */
function obj_activate() {
	ComClearSeparator(event.srcElement);
	ComSetFocus(event.srcElement);
}

/**
 * form_keyup
 * 
 * @return
 */
function form_keyup() {
	var obj = null;
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	if (keyValue != 13) {
	//	ComKeyEnter('lengthnextfocus');
	}
}

/**
 * obj_keypress 키 입력시 대소문자 처리
 * 
 * @return
 */
function obj_keypress() {
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;

	switch (event.srcElement.name) {
	case "week":
		// 숫자만 + "-"만 입력허용
		ComKeyOnlyNumber(event.srcElement);
		if (keyValue == 13){
			document.form.searchvvd.value = "";
			frameLayer0.doActionIBSheet(frameLayer0.sheetObjects[4], frameLayer0.document.form, IBSEARCH);
			frameLayer0.sheetObjects[0].SelectRow = 0;
			frameLayer0.sheetObjects[1].SelectRow = 0;
			frameLayer0.sheetObjects[2].SelectRow = 0;
			frameLayer0.sheetObjects[3].SelectRow = 0;
			frameLayer0.sheetObjects[4].SelectRow = 0;
			frameLayer0.sheetObjects[5].SelectRow = 0;
			frameLayer0.sheetObjects[6].SelectRow = 0;
			frameLayer0.sheetObjects[7].SelectRow = 0;
			frameLayer0.sheetObjects[8].SelectRow = 0;
			frameLayer0.sheetObjects[9].SelectRow = 0;			
		}
		break;
	case "searchvvd":
		ComKeyOnlyAlphabet('uppernum');
		if (keyValue == 13) {
			frameLayer0.searchVvd(document.form.searchvvd.value, document.form.searchvvd);
		}
		break;
	default:
		document.form.searchvvd.value = "";
		frameLayer0.doActionIBSheet(frameLayer0.sheetObjects[4], frameLayer0.document.form, IBSEARCH);
		frameLayer0.sheetObjects[0].SelectRow = 0;
		frameLayer0.sheetObjects[1].SelectRow = 0;
		frameLayer0.sheetObjects[2].SelectRow = 0;
		frameLayer0.sheetObjects[3].SelectRow = 0;
		frameLayer0.sheetObjects[4].SelectRow = 0;
		frameLayer0.sheetObjects[5].SelectRow = 0;
		frameLayer0.sheetObjects[6].SelectRow = 0;
		frameLayer0.sheetObjects[7].SelectRow = 0;
		frameLayer0.sheetObjects[8].SelectRow = 0;
		frameLayer0.sheetObjects[9].SelectRow = 0;		
		
	}

}
/* 개발자 작업 끝 */