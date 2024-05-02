/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : Esm_bkg_0458.js
 *@FileTitle : ESM_BKG-0458
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.03
 *@LastModifier : 김승민
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
 * @class ESM_BKG-0458 : ESM_BKG-0458 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0458() {
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
var totalCount = 0;

var state = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;

		case "btn_save":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;

		case "btn_add":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND01);

			break;

		case "btn_delete":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND02);

			break;

		case "btn_close":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND03);
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
// initSheetData(sheetObjects[0], document.form);
doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

}

// 시트 데이터 초기화
function initSheetData(sheetObj, formObj) {

//formObj.vvd_cd.value = "";
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
axon_event.addListenerForm('blur', 'obj_deactivate', formObject); // - 포커스 나갈때
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
	ComKeyOnlyAlphabet('uppernum');
	break;
case "uppernum2":
	// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	ComKeyAlphabetNChar('uppernum');
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
	ComKeyOnlyNumber('num', '.');
	break;
case "num3":
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
 **/
function obj_deactivate() {
//if (event.srcElement.getAttribute("required") != null) return;

// 입력Validation 확인하기
switch (event.srcElement.name) {

case "diff_rmk":
	ComKeyCopy(1);
	break;
case "bl_desc":
	ComKeyCopy(2);
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
		InitColumnInfo(5, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, true, true, false, false)

		var HeadTitle1 = "Flag|bl_seq|bl_seq2|diff_rmk|bl_desc";

		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);

		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
		// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,
		// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
		// FORMATFIX]
		InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "bl_seq");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "bl_seq2");
		InitDataProperty(0, cnt++, dtData, 200, daCenter, true, "diff_rmk");
		InitDataProperty(0, cnt++, dtData, 200, daCenter, true, "bl_desc");
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
sheetObj.ShowDebugMsg = false;
switch (sAction) {

case IBSAVE: // 조회

	if (validateForm(sheetObj, formObj, sAction)) {
		//IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
		// alert(sheetObj.RowCount);
		formObj.f_cmd.value = MULTI;
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		sheetObj.DoAllSave("ESM_BKG_0458GS.do", FormQueryString(formObj));

		state = sheetObj.EtcData("TRANS_RESULT_KEY");
		ComOpenWait(false);
		if (state == "S") {
			doActionIBSheet(sheetObj, document.form, IBSEARCH);
		}
		
	}
	break;

case IBSEARCH: // 조회
	if (validateForm(sheetObj, formObj, sAction)) {
		formObj.f_cmd.value = SEARCH;
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		sheetObj.DoSearch("ESM_BKG_0458GS.do", FormQueryString(formObj));
		ComEtcDataToForm(formObj, sheetObj);

		state = sheetObj.EtcData("TRANS_RESULT_KEY");

		if (state == "S") {
			document.form.select_bl_seq.options.length = "0";

			// alert(document.form.select_bl_seq.length);
			for ( var i = 1; i < sheetObj.RowCount + 1; i++) {
				ComAddComboItem(document.form.select_bl_seq, "0"
						+ sheetObj.CellValue(i, "bl_seq"), i)
				sheetObj.CellValue(i, "bl_seq2") = i;
				sheetObjects[0].RowStatus(i) = "R";
			}

			if (sheetObj.RowCount == 0) {
				ComAddComboItem(document.form.select_bl_seq, "01", 1)
				sheetObj.RemoveAll();
				sheetObj.DataInsert(-1);
				sheetObj.CellValue(i, "bl_seq") = 1;
				sheetObj.CellValue(i, "bl_seq2") = 1;
				sheetObjects[0].RowStatus(i) = "I";
				totalCount = 1;
				document.form.diff_rmk.value = "";
				document.form.bl_desc.value = "";
			} else {
				document.form.select_bl_seq(0).selected = true;
				totalCount = document.form
						.select_bl_seq(document.form.select_bl_seq.length - 1).value;

				document.form.diff_rmk.value = sheetObj
						.CellValue(1, "diff_rmk");
				document.form.bl_desc.value = sheetObj.CellValue(1, "bl_desc");
			}
		}
		ComOpenWait(false);

	}
	break;

case COMMAND01:
	//if (!sheetObjects[0].IsDataModified)
	// {
	// alert(sheetObjects[0].RowCount);
	sheetObjects[0].DataInsert(-1);
	// alert(sheetObjects[0].RowCount);
	totalCount++;
	var totalOption = 0;
	for ( var i = 1; i < sheetObj.RowCount + 1; i++) {
		if (sheetObjects[0].RowStatus(i) != "D") {
			totalOption++;
		}
	}

	if (totalCount > 9)
		ComAddComboItem(document.form.select_bl_seq, totalOption, totalOption)
	else
		ComAddComboItem(document.form.select_bl_seq, "0" + totalOption,
				totalOption)
		// alert(totalCount);
	var lastValue = 0;
	var lastValue2 = 0;
	if (totalCount != 1) {
		lastValue = sheetObjects[0].CellValue(totalCount - 1, "bl_seq") * 1 + 1 * 1
		lastValue2 = sheetObjects[0].CellValue(totalCount - 1, "bl_seq2") * 1 + 1 * 1
	} else {
		lastValue = 1;
	}

	sheetObjects[0].CellValue(totalCount, "bl_seq") = lastValue;
	sheetObjects[0].CellValue(totalCount, "bl_seq2") = lastValue2;
	formObj.diff_rmk.value = "";
	formObj.bl_desc.value = "";
	// sheetObjects[0].RowStatus(totalCount) = "I";
	formObj.select_bl_seq.options[formObj.select_bl_seq.options.length - 1].selected = true;
	// } else {
	// ComShowCodeMessage("BKG00178");
	// }
	break;

case COMMAND02:
	//if (!sheetObjects[0].IsDataModified)
	// {
	if (sheetObjects[0].RowStatus(formObj.select_bl_seq.selectedIndex + 1) == "R") {
		//alert("here2");
		sheetObjects[0].RowStatus(formObj.select_bl_seq.selectedIndex + 1) = "D";
		for ( var i = formObj.select_bl_seq.selectedIndex + 1; i < sheetObj.RowCount + 1; i++) {
			if (sheetObjects[0].RowStatus(i) != "D") {
				//sheetObjects[0].CellValue(i,"bl_seq") = sheetObjects[0].CellValue(i,"bl_seq")*1-1*1;
				sheetObjects[0].CellValue(i, "bl_seq2") = sheetObjects[0]
						.CellValue(i, "bl_seq2") * 1 - 1 * 1;
				sheetObjects[0].RowStatus(i) = "R";
			}
		}
		//sheetObjects[0].RowDelete(formObj.select_bl_seq.selectedIndex+1, false);
		// alert(sheetObj.RowCount);
		var totalOption = 0;
		for ( var i = 1; i < sheetObj.RowCount + 1; i++) {
			if (sheetObjects[0].RowStatus(i) != "D") {
				totalOption++;
			}
		}
		document.all.select_bl_seq.remove(totalOption);
		if (formObj.select_bl_seq.options.length != 0) {
			var firstIndex;
			for ( var i = 1; i < sheetObj.RowCount + 1; i++) {
				if (sheetObjects[0].RowStatus(i) != "D") {
					firstIndex = i;
					break;
				}
			}
			formObj.select_bl_seq.options[0].selected = true;
			formObj.diff_rmk.value = sheetObjects[0].CellValue(firstIndex,
					"diff_rmk");
			formObj.bl_desc.value = sheetObjects[0].CellValue(firstIndex,
					"bl_desc");
		} else {
			//formObj.bl_seq.options[0].selected = true;
			formObj.diff_rmk.value = "";
			formObj.bl_desc.value = "";
		}

		//totalCount--;					
		// sheetObjects[0].RowStatus(i) = "D";
		// formObj.f_cmd.value = MULTI01;
		// sheetObj.DoAllSave("ESM_BKG_0458GS.do", FormQueryString(formObj));

	} else {
		for ( var i = formObj.select_bl_seq.selectedIndex + 1; i < sheetObj.RowCount + 1; i++) {
			if (sheetObjects[0].RowStatus(i) != "D") {
				sheetObjects[0].CellValue(i, "bl_seq") = sheetObjects[0]
						.CellValue(i, "bl_seq") * 1 - 1 * 1;
				sheetObjects[0].CellValue(i, "bl_seq2") = sheetObjects[0]
						.CellValue(i, "bl_seq2") * 1 - 1 * 1;
			}
		}
		sheetObjects[0].RowDelete(formObj.select_bl_seq.selectedIndex + 1,
				false);
		// alert(sheetObj.RowCount);
		document.all.select_bl_seq.remove(sheetObj.RowCount);
		if (formObj.select_bl_seq.options.length != 0) {
			formObj.select_bl_seq.options[0].selected = true;
			formObj.diff_rmk.value = sheetObjects[0].CellValue(1, "diff_rmk");
			formObj.bl_desc.value = sheetObjects[0].CellValue(1, "bl_desc");
		} else {
			//formObj.bl_seq.options[0].selected = true;
			formObj.diff_rmk.value = "";
			formObj.bl_desc.value = "";
		}

		totalCount--;
	}
	//} else {
	//	ComShowCodeMessage("BKG00178");
	// }

	break;
case COMMAND03: // 입력
	var vIsCheck = true
	for ( var i = 1; i <= sheetObj.RowCount; i++) {
		if (sheetObj.RowStatus(i) == "I" || sheetObj.RowStatus(i) == "U"
				|| sheetObj.RowStatus(i) == "D") {
			vIsCheck = false;
			break;
		}
	}
	if (vIsCheck) {
		opener.retrieve();
		window.close();
		break;
	}

	if (!validateForm(sheetObj, formObj, sAction)) {
		opener.retrieve();
		window.close();
	} else {
		formObj.f_cmd.value = MULTI;
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		sheetObj.DoAllSave("ESM_BKG_0458GS.do", FormQueryString(formObj));
		ComOpenWait(false);
	}
	break;
}
}

/**
 * 폼에 있는 값을 시트로 카피
 * @param gubun gubun
 */
function ComKeyCopy(gubun) {
var formObject = document.form;
if (gubun == "1")
	sheetObjects[0].CellValue(formObject.select_bl_seq.value, "diff_rmk") = formObject.diff_rmk.value;
if (gubun == "2")
	sheetObjects[0].CellValue(formObject.select_bl_seq.value, "bl_desc") = formObject.bl_desc.value;
}

/**
 * select box에 시퀀스 일시변경
 * @param obj object
 */
function changeSeq(obj) {
var formObject = document.form;
for ( var i = 1; i < sheetObjects[0].RowCount + 1; i++) {
	if (obj.selectedIndex + 1 == sheetObjects[0].CellValue(i + 1, "bl_seq2")) {
		formObject.diff_rmk.value = sheetObjects[0]
				.CellValue(i + 1, "diff_rmk");
		formObject.bl_desc.value = sheetObjects[0].CellValue(i + 1, "bl_desc");
	}
}
//formObject.diff_rmk.value = sheetObjects[0].CellValue(obj.selectedIndex+1,"diff_rmk");
// formObject.bl_desc.value =
// sheetObjects[0].CellValue(obj.selectedIndex+1,"bl_desc");
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function validateForm(sheetObj, formObj, sAction) {
switch (sAction) {
case IBSEARCH:
	return true;
	break;
case IBSAVE:
	return true;
	break;
case COMMAND03:
	//하나 이상 체크되었는지 확인
	var vIsCheck = true;
	for ( var i = 1; i <= sheetObj.RowCount; i++) {
		if (sheetObj.RowStatus(i) == "I" || sheetObj.RowStatus(i) == "U"
				|| sheetObj.RowStatus(i) == "D") {
			vIsCheck = false;
			break;
		}
	}
	if (!vIsCheck) {
		//ComShowCodeMessage('BKG00265','');
		if (!confirm("Do you want to save your change(s)?")) {
			return false;
		}
	}
	return true;
	break;
}
}
/* 개발자 작업 끝 */