/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_SPC_0124.js
 *@FileTitle : Space Control Container Type/Size
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.07.29
 *@LastModifier :
 *@LastVersion : 1.0
 * 2015.07.29 김기종
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
var opener = window.dialogArguments;
/**
 * @extends
 * @class ESM_SPC_0124 : ESM_SPC_0124 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SPC_0124() {
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
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_confirm":
			selectOk();
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
 * IBSheet Object를 selectOk 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function selectOk() {
	var formObject = document.form;
	var sheetObject = sheetObjects[0];
	var locMultiStr = "";
	for ( var idx = 0 + parseInt(sheetObject.HeaderRows); idx <= sheetObject.LastRow; idx++) {
		if (sheetObject.CellValue(idx, "check") == "1") {
			locMultiStr = locMultiStr + sheetObject.CellValue(idx, "code") + ",";
		}
	}
	locMultiStr = locMultiStr.substr(0, locMultiStr.length - 1);

	if (formObject.tab_no.value == "0") {
		var org_sheet = opener.sheetObjects[0];
	} else if (formObject.tab_no.value == "1") {
		var org_sheet = opener.sheetObjects[1];
	} else if (formObject.tab_no.value == "2") {
		var org_sheet = opener.sheetObjects[2];
	} else if (formObject.tab_no.value == "3") {
		var org_sheet = opener.sheetObjects[3];
	} else if (formObject.tab_no.value == "4") {
		var org_sheet = opener.sheetObjects[4];
	}

	var org_row = formObject.org_row.value;
	//Opener Sheet 
	org_sheet.CellValue2(org_row, formObject.targetColume.value) = locMultiStr;
	if (formObject.tab_no.value == "0") {
		if (org_sheet.CellValue(org_row, "sls_rhq_cd") == 'SHARC') {
			rid = Number(org_row) + 1;
			org_sheet.CellValue2(rid, formObject.targetColume.value) = locMultiStr;
		} else if (org_sheet.CellValue(org_row, "sls_rhq_cd") == 'SINRS') {
			rid = Number(org_row) - 1;
			org_sheet.CellValue2(rid, formObject.targetColume.value) = locMultiStr;
		}
	}
	window.close();
}
/**
 * IBSheet Object를 initPage 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function initPage() {
	var formObject = document.form;
	var sheetObject = sheetObjects[0];
	var locArr = formObject.loc_multi_cd.value.split(",");
	for ( var i = 0; i < locArr.length; i++) {
		for ( var idx = 0 + parseInt(sheetObject.HeaderRows); idx <= sheetObject.LastRow; idx++) {
			if (sheetObject.CellValue(idx, "code") == locArr[i]) {
				sheetObject.CellValue2(idx, "check") = '1'; break;
			}
		}
	}
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	doActionIBSheet(sheetObject, formObject, IBSEARCH);
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
	case 1: //sheet1 init
		with (sheetObj) {

		// 높이 설정
		style.height = GetSheetHeight(14);
		//전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "")
			InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msNone;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(1, 1, 15, 100);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(4, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, true, true, false, false)

		var HeadTitle1 = " ||Code|Name";

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);

		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

		InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, false,	"check", false, "", dfNone, 0, true, true);
		InitDataProperty(0, cnt++, dtRadioCheck, 30, daCenter, false,"radio", false, "", dfNone, 0, true, true);
		InitDataProperty(0, cnt++, dtData, 48, daCenter, false,	"code", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 100, daLeft, false,"name", false, "", dfNone, 0, false, false);

		ColHidden("radio") = true;
		}
		break;
	}
}
/**
 * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
 * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {form}    formObj     Form Object
 * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
 * @param {String}  gubun     	처리할 gubun 값
 **/
function doActionIBSheet(sheetObj, formObj, sAction, col) {
	//        sheetObj.ShowDebugMsg = true;
	switch (sAction) {
	case IBSEARCH: //조회
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESM_SPC_0124GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(""));
		}
		break;
	}
}
/**
 * 조회 후에 이벤트 
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	initPage();
	
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {form} formObj     	화면 form Object
 * @param {ibsheet} sAction     IBSheet Object
 * @param {String}  value    	sheetObj의 입력값
 * @return {boolean} 정상 여부
 * @see #ComChkValid
 **/
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		//            if (!isNumber(formObj.iPage)) {
		//                return false;
		//            }
	}
	return true;
}
/* 개발자 작업  끝 */
