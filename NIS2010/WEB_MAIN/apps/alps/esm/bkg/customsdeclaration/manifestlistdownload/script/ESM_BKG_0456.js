/*=========================================================
 *Copyright(c) 2017 Hi-Plus Card
 *@FileName : Esm_bkg_0456.js
 *@FileTitle : ESM_BKG-0456
 *Open Issues :
 *Change history :
 *	2017.09.07 하대성 2017 Renewal Version Transmit 반영
 *@LastModifyDate : 2017.09.07
 *@LastModifier : 하대성
 *@LastVersion : 1.0
 * 2009.06.03 김승민
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
 * @class ESM_BKG-0456 : ESM_BKG-0456 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */

function esm_bkg_0456() {
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

var state = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_save":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;

		case "btn_close":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND04);
			break;
		case "btn_cust":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND01);
			break;
		case "btn_cust2":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND02);
			break;
		case "btn_cust3":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND03);
			break;

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

sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
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

initSheetData(sheetObjects[0], document.form);

doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

}

// 시트 데이터 초기화
function initSheetData(sheetObj, formObj) {

// formObj.vvd_cd.value = "";
// formObj.pod_cd.value = "";

sheetObj.RemoveAll();
sheetObj.DataInsert(-1);

IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
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
DATE_SEPARATOR = "-";

var formObject = document.form;
// Axon 이벤트 처리1. 이벤트catch(개발자변경)
axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // - 키보드
axon_event.addListenerForm('blur', 'obj_deactivate', formObject); // - 포커스
// 나갈때
axon_event.addListener('keydown', 'ComKeyEnter', 'form');
axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
var formObject = document.form;
var srcName = window.event.srcElement.getAttribute("name");
var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
var srcValue = window.event.srcElement.getAttribute("value");
if (ComChkLen(srcValue, srcMaxLength) == "2") {
	ComSetNextFocus();
}
}

/**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 */
function obj_keypress() {
switch (event.srcElement.dataformat) {
case "uppernum":
	// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	ComKeyAlphabetNChar('uppernum');
	break;
case "uppernum2":
	// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	ComKeyOnlyAlphabet('uppernum');
	break;
case "upper":
	// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	ComKeyOnlyAlphabet('upper');
	break;
case "num":
	// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	ComKeyOnlyNumber('num', '-');
	break;
case "num2":
	// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	ComKeyOnlyNumber('num', '');
	break;
default:
	// 숫자만입력하기(정수,날짜,시간)
	ComKeyOnlyNumber(event.srcElement);
}
}

/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 */
function obj_deactivate() {
// if (event.srcElement.getAttribute("required") != null) return;
// alert( sheetObjects[0].RowCount);
var formObject = document.form;
// 입력Validation 확인하기
switch (event.srcElement.name) {
case "form1_cust_cnt_cd":
	sheetObjects[0].CellValue(1, "cust_cnt_cd") = formObject.form1_cust_cnt_cd.value;
	break;
case "form1_cust_seq":
	sheetObjects[0].CellValue(1, "cust_seq") = formObject.form1_cust_seq.value;
	break;
case "form1_cust_nm":
	sheetObjects[0].CellValue(1, "cust_nm") = formObject.form1_cust_nm.value;
	break;
case "form1_cust_addr":
	sheetObjects[0].CellValue(1, "cust_addr") = formObject.form1_cust_addr.value;
	break;
case "form1_phn_no":
	sheetObjects[0].CellValue(1, "phn_no") = formObject.form1_phn_no.value;
	// alert(sheetObjects[0].RowStatus(1));
	break;
case "form1_phn_no":
	sheetObjects[0].CellValue(1, "fax_no") = formObject.form1_phn_no.value;
	break;
case "form1_cust_cnt_cd2":
	sheetObjects[0].CellValue(1, "cust_cnt_cd2") = formObject.form1_cust_cnt_cd2.value;
	break;
case "form1_cust_seq2":
	sheetObjects[0].CellValue(1, "cust_seq2") = formObject.form1_cust_seq2.value;
	break;
case "form1_cust_nm2":
	sheetObjects[0].CellValue(1, "cust_nm2") = formObject.form1_cust_nm2.value;
	break;
case "form1_cust_addr2":
	sheetObjects[0].CellValue(1, "cust_addr2") = formObject.form1_cust_addr2.value;
	break;
case "form1_phn_no2":
	sheetObjects[0].CellValue(1, "phn_no2") = formObject.form1_phn_no2.value;
	break;
case "form1_fax_no2":
	sheetObjects[0].CellValue(1, "fax_no2") = formObject.form1_fax_no2.value;
	break;
case "form1_cust_cnt_cd3":
	sheetObjects[0].CellValue(1, "cust_cnt_cd3") = formObject.form1_cust_cnt_cd3.value;
	break;
case "form1_cust_seq3":
	sheetObjects[0].CellValue(1, "cust_seq3") = formObject.form1_cust_seq3.value;
	break;
case "form1_cust_nm3":
	sheetObjects[0].CellValue(1, "cust_nm3") = formObject.form1_cust_nm3.value;
	break;
case "form1_cust_addr3":
	sheetObjects[0].CellValue(1, "cust_addr3") = formObject.form1_cust_addr3.value;
	break;
case "form1_phn_no3":
	sheetObjects[0].CellValue(1, "phn_no3") = formObject.form1_phn_no3.value;
	break;
case "form1_fax_no3":
	sheetObjects[0].CellValue(1, "fax_no3") = formObject.form1_fax_no3.value;
	break;
default:
	break;
// ComAddSeparator(event.srcElement);
// ComChkObjValid(event.srcElement);
}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * @param sheetObj 시트오브젝트
 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
 */
function initSheet(sheetObj, sheetNo) {

var cnt = 0;
var sheetID = sheetObj.id;

switch (sheetID) {
case "sheet1": // sheet1 init
	with (sheetObj) {
		// 높이 설정
		style.height = 225;
		// 전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		// Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "")
			InitHostInfo(location.hostname, location.port, page_path);

		// 전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;

		// 전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(1, 1, 3, 100);

		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(22, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, true, true, false, false)

		var HeadTitle1 = "Flag|bl_no|vvd_cd|pod_cd|cust_cnt_cd|cust_seq|cust_nm|cust_addr|phn_no|fax_no|cust_cnt_cd2|cust_seq2|cust_nm2|cust_addr2|phn_no2|fax_no2|cust_cnt_cd3|cust_seq3|cust_nm3|cust_addr3|phn_no3|fax_no3";

		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);

		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
		// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,
		// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
		// FORMATFIX]
		InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "bl_number");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "vvd_cd");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "pod_cd");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cust_cnt_cd");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cust_seq");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cust_nm");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cust_addr");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "phn_no");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "fax_no");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cust_cnt_cd2");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cust_seq2");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cust_nm2");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cust_addr2");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "phn_no2");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "fax_no2");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cust_cnt_cd3");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cust_seq3");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cust_nm3");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cust_addr3");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "phn_no3");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "fax_no3");
	}
	break;

}
}

/**
 * Sheet관련 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
//alert();
sheetObj.ShowDebugMsg = false;
switch (sAction) {

case IBSAVE: // 조회
	if (validateForm(sheetObj, formObj, sAction)) {
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
		// alert(sheetObj.RowCount);
		formObj.f_cmd.value = MULTI;
		sheetObj.DoAllSave("ESM_BKG_0456GS.do", FormQueryString(formObj));

		state = sheetObj.EtcData("TRANS_RESULT_KEY");
		ComOpenWait(false);
		if (state == "S") {
			doActionIBSheet(sheetObj, document.form, IBSEARCH);
		}

	}
	break;

case IBSEARCH: // 조회
	if (validateForm(sheetObj, formObj, sAction)) {
		//alert();
		formObj.f_cmd.value = SEARCH;
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		// alert(sheetObj.cellValue(1,"bl_no"));
		// alert(sheetObj.cellValue(1,"vvd_cd"));
		// alert(sheetObj.cellValue(1,"pod_cd"));
		sheetObj.DoSearch("ESM_BKG_0456GS.do", FormQueryString(formObj));

		if (sheetObj.RowCount == 1) {
			IBS_CopyRowToForm(sheetObj, formObj, 1, "form1_");
		} else if (sheetObj.RowCount == 0) {
			initSheetData(sheetObj, formObj);
		}
		ComOpenWait(false);
	}
	break;
case COMMAND01: // 저장
	if (validateForm(sheetObj, formObj, sAction)) {
		formObj.f_cmd.value = SEARCH01;
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		formObj.cust_type.value = "S";
		// alert(sheetObj.cellValue(1,"bl_no"));
		// alert(sheetObj.cellValue(1,"vvd_cd"));
		// alert(sheetObj.cellValue(1,"pod_cd"));
		sheetObj.DoSearch("ESM_BKG_0457GS.do", FormQueryString(formObj));
		ComEtcDataToForm(formObj, sheetObj);
		ComOpenWait(false);
	}
	// var sUrl =
	// "/hanjin/ESM_BKG_0456.do?vvd_cd="+formObj.in_vvd_cd.value+"&pod_cd="+formObj.in_pod_cd.value;
	// ComOpenWindowCenter(sUrl, "ESM_BKG_0990", 423, 172, true);
	// ComOpenWindowCenter(sUrl, "ESM_BKG_0990", 1024, 768, true);

	break;

case COMMAND02: // 저장

	if (validateForm(sheetObj, formObj, sAction)) {
		formObj.f_cmd.value = SEARCH02;
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		formObj.cust_type.value = "C";
		// alert(sheetObj.cellValue(1,"bl_no"));
		// alert(sheetObj.cellValue(1,"vvd_cd"));
		// alert(sheetObj.cellValue(1,"pod_cd"));
		sheetObj.DoSearch("ESM_BKG_0457GS.do", FormQueryString(formObj));
		ComEtcDataToForm(formObj, sheetObj);
		ComOpenWait(false);
	}
	// var sUrl =
	// "/hanjin/ESM_BKG_0456.do?vvd_cd="+formObj.in_vvd_cd.value+"&pod_cd="+formObj.in_pod_cd.value;
	// ComOpenWindowCenter(sUrl, "ESM_BKG_0990", 423, 172, true);
	// ComOpenWindowCenter(sUrl, "ESM_BKG_0990", 1024, 768, true);

	break;

case COMMAND03: // 저장

	if (validateForm(sheetObj, formObj, sAction)) {
		formObj.f_cmd.value = SEARCH03;
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		formObj.cust_type.value = "N";
		// alert(sheetObj.cellValue(1,"bl_no"));
		// alert(sheetObj.cellValue(1,"vvd_cd"));
		// alert(sheetObj.cellValue(1,"pod_cd"));
		sheetObj.DoSearch("ESM_BKG_0457GS.do", FormQueryString(formObj));
		ComEtcDataToForm(formObj, sheetObj);
		ComOpenWait(false);		
	}
	// var sUrl =
	// "/hanjin/ESM_BKG_0456.do?vvd_cd="+formObj.in_vvd_cd.value+"&pod_cd="+formObj.in_pod_cd.value;
	// ComOpenWindowCenter(sUrl, "ESM_BKG_0990", 423, 172, true);
	// ComOpenWindowCenter(sUrl, "ESM_BKG_0990", 1024, 768, true);

	break;
case COMMAND04: // 입력
	// alert(sheetObj.RowStatus(1));
	if (sheetObj.RowStatus(1) == "U") {
		if (ComShowCodeConfirm("BKG00350")) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value = MULTI;
				sheetObj.DoAllSave("ESM_BKG_0456GS.do", FormQueryString(formObj));
			}
			ComOpenWait(false);
		} else {
			opener.retrieve();
			window.close();
		}
	} else {
		opener.retrieve();
		window.close();
	}
	break;
}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function validateForm(sheetObj, formObj, sAction) {
switch (sAction) {
case IBSAVE:
case COMMAND04:	
	if (formObj.form1_cust_cnt_cd.value.length != 2) {
		ComShowCodeMessage('BKG01101', formObj.form1_cust_cnt_cd.getAttribute("caption"));
		formObj.form1_cust_cnt_cd.focus();
		return false;
	} else if (formObj.form1_phn_no.value == "") {
		ComShowCodeMessage('BKG01101', formObj.form1_phn_no.getAttribute("caption"));
		formObj.form1_phn_no.focus();
		return false;
	} else if (isNaN(ComTrimAll(formObj.form1_phn_no.value," ","-",".")) ) {
		ComShowCodeMessage('BKG06012', formObj.form1_phn_no.getAttribute("caption"));
		formObj.form1_phn_no.value = "";
		formObj.form1_phn_no.focus();
		return false;
	} else if (formObj.form1_cust_nm.value == "") {
		ComShowCodeMessage('BKG01101', formObj.form1_cust_nm.getAttribute("caption"));
		formObj.form1_cust_nm.focus();
		return false;
	} else if (formObj.form1_cust_addr.value == "") {
		ComShowCodeMessage('BKG01101', formObj.form1_cust_addr.getAttribute("caption"));
		formObj.form1_cust_addr.focus();
		return false;
	} else if (formObj.form1_cust_cnt_cd2.value.length != 2 && formObj.form1_cust_nm2.value.toUpperCase().replace(/ /g,'').indexOf('TOORDER') < 0) {
		ComShowCodeMessage('BKG01101', formObj.form1_cust_cnt_cd2.getAttribute("caption"));
		formObj.form1_cust_cnt_cd2.focus();
		return false;
	} else if (formObj.form1_phn_no2.value == "" && formObj.form1_cust_nm2.value.toUpperCase().replace(/ /g,'').indexOf('TOORDER') < 0) {
		ComShowCodeMessage('BKG01101', formObj.form1_phn_no2.getAttribute("caption"));
		formObj.form1_phn_no2.focus();
		return false;
	} else if (isNaN(ComTrimAll(formObj.form1_phn_no2.value," ","-",".")) && formObj.form1_cust_nm2.value.toUpperCase().replace(/ /g,'').indexOf('TOORDER') < 0) {
		ComShowCodeMessage('BKG06012', formObj.form1_phn_no2.getAttribute("caption"));
		formObj.form1_phn_no2.value = "";
		formObj.form1_phn_no2.focus();
		return false;
	} else if (formObj.form1_cust_nm2.value == "") {
		ComShowCodeMessage('BKG01101', formObj.form1_cust_nm2.getAttribute("caption"));
		formObj.form1_cust_nm2.focus();
		return false;
	} else if (formObj.form1_cust_addr2.value == "" && formObj.form1_cust_nm2.value.toUpperCase().replace(/ /g,'').indexOf('TOORDER') < 0) {
		ComShowCodeMessage('BKG01101', formObj.form1_cust_addr2.getAttribute("caption"));
		formObj.form1_cust_addr2.focus();
		return false;
	} else if (formObj.form1_cust_cnt_cd3.value.length != 2) {
		ComShowCodeMessage('BKG01101', formObj.form1_cust_cnt_cd3.getAttribute("caption"));
		formObj.form1_cust_cnt_cd3.focus();
		return false;
	} else if (formObj.form1_phn_no3.value == "") {
		ComShowCodeMessage('BKG01101', formObj.form1_phn_no3.getAttribute("caption"));
		formObj.form1_phn_no3.focus();
		return false;
	} else if (isNaN(ComTrimAll(formObj.form1_phn_no3.value," ","-",".")) ) {
		ComShowCodeMessage('BKG06012', formObj.form1_phn_no3.getAttribute("caption"));
		formObj.form1_phn_no3.value = "";
		formObj.form1_phn_no3.focus();
		return false;
	} else if (formObj.form1_cust_nm3.value == "") {
		ComShowCodeMessage('BKG01101', formObj.form1_cust_nm3.getAttribute("caption"));
		formObj.form1_cust_nm3.focus();
		return false;
	} else if (formObj.form1_cust_addr3.value == "") {
		ComShowCodeMessage('BKG01101', formObj.form1_cust_addr3.getAttribute("caption"));
		formObj.form1_cust_addr3.focus();
		return false;
	}
	
	return true;
	break;
case IBSEARCH:
	return true;
	break;
case COMMAND01:
	if (formObj.form1_cust_cnt_cd.value == ""
			|| formObj.form1_cust_seq.value == "") {
		// ComShowCodeMessage('BKG00266');
		formObj.form1_cust_cnt_cd.focus();
		return false;
	}

	return true;
	break;

case COMMAND02:
	if (formObj.form1_cust_cnt_cd2.value == ""
			|| formObj.form1_cust_seq2.value == "") {
		// ComShowCodeMessage('BKG00266');
		formObj.form1_cust_cnt_cd2.focus();
		return false;
	}

	return true;
	break;

case COMMAND03:
	if (formObj.form1_cust_cnt_cd3.value == ""
			|| formObj.form1_cust_seq3.value == "") {
		// ComShowCodeMessage('BKG00266');
		formObj.form1_cust_cnt_cd3.focus();
		return false;
	}

	return true;
	break;
}
}
/* 개발자 작업 끝 */