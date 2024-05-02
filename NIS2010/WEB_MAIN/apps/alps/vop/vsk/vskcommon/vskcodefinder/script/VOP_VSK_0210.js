/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0210.js
 *@FileTitle : Country Code Help
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.03.03
 *@LastModifier : 유혁
 *@LastVersion : 1.0
 * 2009.05.12 유혁
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
 * @class VOP_VSK_0210 : VOP_VSK_0210 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0210() {
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
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {

	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObj = sheetObjects[0];

	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		var cal = new ComCalendar();
		
		// 0, 0 좌표로 조절
		cal.offsetX = -32; 
		cal.offsetY = -83;
		
		// 창가운데로 조절
		cal.offsetX = cal.offsetX + (document.body.offsetWidth - cal.width)/2;
		cal.offsetY = cal.offsetY + (document.body.offsetHeight - cal.height)/2;
		
		switch (srcName) {

		case "btn_ok":

			// if(window.returnValue){
			var sDate = formObj.src_day.value;
			var sTime = formObj.src_time.value;

			sDate = sDate.replace(/\-|\ /g, ""); // 날짜구분자,스페이스 없애기
			sTime = sTime.replace(/\:|\ /g, ""); // 시간구분자,스페이스 없애기

			var year = sDate.substr(0, 4);
			var month = sDate.substr(4, 2);
			var date = sDate.substr(6, 2);

			var destdate = month + '/' + date + year + sTime;
			window.returnValue = destdate;

			comPopupOK();
			break;

		case "btn_close":
			window.close();
			break;

		case "btn_cal":
			// cal.select(formObj.src_day, 'MM/ddyyyy');
			cal.select(formObj.src_day, 'yyyy-MM-dd');
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
	loadDate();
	initControl();
	document.form.src_day.blur();
	
}

function loadDate() {

	var formObj = document.form;
	var srcdate = formObj.srcdate.value;

	var dDate = new Date(getDateFromFormat(srcdate, 'MM/ddyyyyHHmm'));

	srcdate = srcdate.replace(/\/|\ /g, ""); // 날짜구분자,스페이스 없애기

	if (srcdate.length == 12) {

		var year = srcdate.substr(4, 4);
		var month = srcdate.substr(0, 2);
		var date = srcdate.substr(2, 2);
		var hours = srcdate.substr(8, 2);
		var minutes = srcdate.substr(10, 2);

		formObj.src_day.value = year + '-' + month + '-' + date;
		formObj.src_time.value = hours + ':' + minutes;
		formObj.oldday.value = formObj.src_day.value;
		formObj.oldtime.value = formObj.src_time.value;
	}
	
}

function initControl() {
	axon_event.addListenerFormat ('keypress', 'num_keypress', form);
	axon_event.addListenerFormat ('focus', 'obj_focus', form);
	axon_event.addListenerForm ('blur', 'obj_blur', form);
	axon_event.addListener  ('beforedeactivate', 'obj_beforedeactivate' , 'src_day', 'src_time');
	axon_event.addListener ('keyup', "VskKeyFocus", 'form');			//- 자동포커스 처리
}

/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력 처리한다. <br>
 **/
function num_keypress() {
	var name = event.srcElement.name;
	switch(name){
		case "src_day":
		case "src_time":
			ComKeyOnlyNumber(event.srcElement);
			break;
		default:
	}
}

function obj_focus() {
	// 마스크구분자 없애기
	switch(event.srcElement.name){
		case "src_day":
		case "src_time":
			ComClearSeparator(event.srcElement);
			break;
	}
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

function obj_blur() {
	//입력Validation 확인 및 마스킹 처리
	switch(event.srcElement.name){
		case "src_day":
		case "src_time":
			ComChkObjValid(event.srcElement);
			break;
	}
	
}

function obj_beforedeactivate(){
	var formObj = document.form;
	var obj = event.srcElement;
	switch(obj.name){
		case "src_day":
			if(!ComIsDate(obj.value, "ymd")){
				ComShowCodeMessage('VSK00003');
				obj.value = ComTrimAll(formObj.oldday," ", "-", ":");
				obj.select();
				return false;
			}else{
				formObj.oldday.value = obj.value;
			}
			break;
		case "src_time":
			if(!ComIsTime(obj.value, "hm")){
				ComShowCodeMessage('VSK00004');
				obj.value = ComTrimAll(formObj.oldtime," ", "-", ":");
				obj.select();
				return false;
			}else{
				formObj.oldtime.value = obj.value;
			}
			break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}

	return true;
}

/* 개발자 작업 끝 */