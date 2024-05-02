/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_cim_1007.js
 *@FileTitle : Turn Time by Lane  VVD
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.05.04 박광석
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
 * @class ees_cim_1007 : ees_cim_1007 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cim_1007() {
	this.processButtonClick = processButtonClick;
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
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var oldCntrTypeSize = "";
var sCntrTypeSize = "";
var oldCntrTypeSize2 = "";
var tabIndex = 0;
var isOpen = true;
var enterSwitch = false;

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var shtCnt = 0;
	var t1sheet1 = sheetObjects[shtCnt++];
	var t2sheet1 = sheetObjects[shtCnt++];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			if (tabIndex == 0) {
				doActionIBSheet(t1sheet1, formObject, IBSEARCH);
				sheetObjects[0].SelectRow = 0;
			} else {
				doActionIBSheet2(t2sheet1, formObject, IBSEARCH);
				sheetObjects[1].SelectRow = 0;
			}
			break;

		case "btn_downExcel":
			if (tabIndex == 0) {
				t1sheet1.Down2Excel(-1);
			} else {
				t2sheet1.Down2Excel(-1);
			}
			break;

		case "btn_new":
			t1sheet1.RemoveAll();
			t2sheet1.RemoveAll();
			comboObjects[1].RemoveAll();
			comboObjects[2].RemoveAll();
			formObject.reset();
			comboObjects[0].Code = "";
			comboObjects[1].Code = "";
			comboObjects[2].Code = "";
			comboObjects[1].Enable = false;
			comboObjects[2].Enable = false;
			formObject.rdtype.disabled = true;
			formObject.rdtype.value = "I";
			ComSetFocus(formObject.froms);
			break;

		case "btn_print":
			alert("btn_print");
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
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * IBMultiCombo Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj) {

	comboObjects[comboCnt++] = combo_obj;

}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);

	}
	axon_event.addListenerForm('click', 'obj_tpsz_click', form);
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerFormat('focus', 'obj_activate', document.form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerForm('blur', 'obj_deactivate', document.form); //- form OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerFormat('keyup', 'form_keyup', form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListener('focus', 'polnextfocus', 'polnext');
	axon_event.addListener('focus', 'lanenextfocus', 'lanenext');
	axon_event.addListener('focus', 'prepolnextfocus', 'prepolnext');

	//IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	isOpen = true;

}

function t1sheet1_OnLoadFinish(sheetObj) {
	//	sheetObj.WaitImageVisible = false;
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	//doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
	comboObjects[1].DisabledBackColor = "#FFFFFF";
	comboObjects[1].Enable = false;
	comboObjects[2].DisabledBackColor = "#FFFFFF";
	comboObjects[2].Enable = false;

	//	sheetObj.WaitImageVisible = true;
}

function form_keyup() {
	var obj = null;
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	if (keyValue != 13) {
		ComKeyEnter('lengthnextfocus');
	} else {
		obj_deactivate();
	}
}

function chkToDateWeekBlur() {
	var period = document.form.period.value;
	var toDate = document.form.tos.value;
	var frDate = document.form.froms.value;

	var toYearDate = toDate.substring(0, 4);
	var frYearDate = frDate.substring(0, 4);
	var toMonthDate = toDate.substring(5, 7);
	var frMonthDate = frDate.substring(5, 7);
	var frDayDate = "";
	var toDayDate = "";

	if (frDate.length > 7) {
		frDayDate = frDate.substring(8, 10);
		toDayDate = toDate.substring(8, 10);

	} else {
		frDayDate = "01";
		toDayDate = lastDay(toYearDate, toMonthDate);
	}

	var frDateFull = new Date(frYearDate, frMonthDate - 1, frDayDate);
	var toDateFull = new Date(toYearDate, toMonthDate - 1, toDayDate);
	var getDiffTime = toDateFull.getTime() - frDateFull.getTime();
	var retDate = Math.floor(getDiffTime / (1000 * 60 * 60 * 24));
	var retMonth = ((parseInt(toYearDate) - parseInt(frYearDate)) * 12 + parseInt(toMonthDate, 10) - parseInt(frMonthDate, 10));
	var retWeek = Math.floor((toDateFull - frDateFull) / (1000 * 60 * 60 * 24 * 7));
	var week = "";
	var fromTo = 52;
	if (period == "M") {
		if (retMonth >= 12) {

			if (event.srcElement.name == "tos") {
				ComShowCodeMessage("CIM21031");
				ComSetFocus(document.getElementById("tos"));
			}
			return false;
		}
	} else if (period == "W") {
		if (frYearDate == toYearDate) {
			week = eval(toMonthDate) - eval(frMonthDate) + 1;
		} else {
			betwMonth = fromTo - eval(frMonthDate) + eval(toMonthDate) + 1;
			if ((eval(toYearDate) - eval(frYearDate)) == 1) { //1년 차이일때
				week = betwMonth;
			} else {
				week = (eval(toYearDate) - eval(frYearDate) - 1) * fromTo + betwMonth;
			}
		}

		if (week > 26) {

			if (event.srcElement.name == "tos") {
				ComShowCodeMessage("CIM21031");
				ComSetFocus(document.getElementById("tos"));
			}
			return false;
		}
	} else if (period == "D") {
		if (retDate >= 31) {

			if (event.srcElement.name == "tos") {

				ComShowCodeMessage("CIM29029");
				ComSetFocus(document.getElementById("tos"));
			}
			return false;
		}
	}
}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_deactivate() {

	var f = document.getElementById("froms");
	var t = document.getElementById("tos");
	sVal1 = f.value.replace(/\/|\-|\./g, "");
	sVal2 = t.value.replace(/\/|\-|\./g, "");

	switch (event.srcElement.name) {
	case "froms":
		if (ComChkObjValid(event.srcElement, false)) {

			if (f.getAttribute("dataformat") == "ym") {
				if (sVal1 != "" && sVal2 != "") {
					var day = lastDay(sVal2.substring(0, 4), sVal2.substring(4, 6));
					var flag = ComChkPeriod(sVal1 + "01", sVal2 + day);

					if (flag < 1) {
						//ComShowCodeMessage("CIM29004");
						enterSwitch = false;
						t.value = "";
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch = false;
							t.value = "";
							t.focus();
							t.select();
							return false;
						}
					}
					document.getElementById("from").value = sVal1 + "01";
					document.getElementById("to").value = sVal2 + day;
				}

			} else { // 주별로 조회
				if (sVal1 != "" && sVal2 != "") {
					if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
						ComShowCodeMessage("CIM29003");
						enterSwitch = false;
						t.value = "";
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch = false;
							t.value = "";
							t.focus();
							t.select();
							return false;
						}
					}
					document.getElementById("from").value = sVal1;
					document.getElementById("to").value = sVal2;
				}
			}

		} else {
			if (f.getAttribute("dataformat") == "ym") {
				if (sVal1.length > 0 && !ComIsMonth(sVal1.substring(4, 6)) && event.srcElement.name == 'froms') {

					event.srcElement.value = "";
					ComShowCodeMessage("CIM21004", "YYYYMM");
					enterSwitch = false;
					event.srcElement.focus();
					event.srcElement.select();
					return false;
				}
			} else { // 주별로 조회

				if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6)) && event.srcElement.name == 'froms') {
					event.srcElement.value = "";
					ComShowCodeMessage("CIM21004", "YYYYWW");
					event.srcElement.focus();
					event.srcElement.select();
					enterSwitch = false;

					return false;
				}
			}
		}

		break;
	case "tos":
		if (ComChkObjValid(event.srcElement, false)) {

			if (t.getAttribute("dataformat") == "ym") {

				var day = lastDay(sVal2.substring(0, 4), sVal2.substring(4, 6));

				if (sVal1 != "" && sVal2 != "") {
					var flag = ComChkPeriod(sVal1 + "01", sVal2 + day);
					if (flag < 1) {
						if (event.srcElement.name == "tos") {
							ComShowCodeMessage("CIM29004");
						}
						enterSwitch = false;
						event.srcElement.value = "";
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch = false;
							event.srcElement.value = "";
							t.focus();
							t.select();
							return false;
						}
					}
				}

				document.getElementById("from").value = sVal1 + "01";
				document.getElementById("to").value = sVal2 + day;
			} else { // 주별로 조회
				if (sVal1 != "" && sVal2 != "") {
					if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
						if (event.srcElement.name == "tos") {
							ComShowCodeMessage("CIM29003");
						}
						enterSwitch = false;
						event.srcElement.value = "";
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch = false;
							event.srcElement.value = "";
							t.focus();
							t.select();
							return false;
						}
					}
				}
				document.getElementById("from").value = sVal1;
				document.getElementById("to").value = sVal2;
			}
			enterSwitch = true;
		} else {
			if (t.getAttribute("dataformat") == "ym") {
				if (sVal2.length > 0 && !ComIsMonth(sVal2.substring(4, 6))) {
					enterSwitch = false;
					event.srcElement.value = "";
					ComShowCodeMessage("CIM21004", "YYYYMM");
					t.focus();
					t.select();
					return false;
				}
			} else { // 주별로 조회

				if (sVal2.length > 0 && !ComIsWeek(sVal2.substring(4, 6))) {
					enterSwitch = false;
					event.srcElement.value = "";
					ComShowCodeMessage("CIM21004", "YYYYWW");
					t.focus();
					t.select();
					return false;
				}
			}
		}

		break;
	}
	return true;
}

/**
 * 그달의 마지막일자
 * @param y
 * @param m
 * @return
 */
function lastDay(y, m) {
	var d, d2, s = "";
	d = new Date();
	d2 = new Date(y, m, "");
	s = d2.getDate();
	return (s);
}

function obj_activate() {
	ComClearSeparator(event.srcElement);
	ComSetFocus(event.srcElement);
}

function obj_tpsz_click() {
	obj = event.srcElement;
	if (obj.name == "tpsz") { // TP/SZ 종류에 따라

		if (obj.value != "R") {
			document.form.rdtype.disabled = true;
			document.form.rdtype.value = "I";
		} else {
			document.form.rdtype.disabled = false;
		}
	}
}

function setDate() {
	var today = new Date();
	var y = today.getFullYear().toString();
	var m = (today.getMonth() + 1).toString();
	if (m.length == 1) {
		m = 0 + m;
	}
	var ym = y + '-' + m;
	document.form.froms.value = ym;
	document.form.tos.value = ym;
	var day = lastDay(y, m);
	document.form.from.value = y + m + "01";
	document.form.to.value = y + m + day;
}
var flag = false;

/**
 * 
 * @return
 */
function pol_OnFocus() {
	comboObjects[1].Enable = true;

	comboObjects[2].Enable = true;

}

function polnextfocus() {
	comboObjects[1].focus();
}

function lanenextfocus() {
	comboObjects[2].focus();
}

function prepolnextfocus() {
	comboObjects[0].focus();
}

/**
 * 
 * @param KeyCode
 * @param Shift
 * @return
 */
function pol_OnBlur(KeyCode, Shift) {
	flag = false;

	if (comboObjects[0].Text.length > 0) {
		comboObjects[0].UseCode = false;
		comboObjects[0].Text = comboObjects[0].Text.toUpperCase();

		for ( var i = 0; i < comboObjects[0].GetCount(); i++) {

			if (comboObjects[0].Text == comboObjects[0].GetText(i, 0)) {

				flag = true;
				comboObjects[0].UseCode = true;
				//pols_OnChange();
				break;
			}
		}
		if (flag == false) {
			ComShowCodeMessage("CIM29011");
			comboObjects[0].Text = "";
			comboObjects[2].RemoveAll();
			comboObjects[0].focus();

			return false;
		} else {
			comboObjects[1].RemoveAll();
			comboObjects[2].RemoveAll();
			comboObjects[2].Enable = true;
		}

	} else {
		comboObjects[1].RemoveAll();
		comboObjects[2].RemoveAll();
	}

}

/**
 * lane code 입력값 체크
 * @param KeyCode
 * @param Shift
 * @return
 */
function lane_OnBlur(KeyCode, Shift) {
	flag = false;
	if (comboObjects[1].Text.length > 0) {
		comboObjects[1].UseCode = false;
		comboObjects[1].Text = comboObjects[1].Text.toUpperCase();

		for ( var i = 0; i < comboObjects[1].GetCount(); i++) {

			if (comboObjects[1].Text == comboObjects[1].GetText(i, 0)) {

				flag = true;
				comboObjects[1].UseCode = true;
				break;
			}
		}
		if (flag == false) {
			ComShowCodeMessage("CIM29012");
			comboObjects[1].Text = "";
			comboObjects[2].RemoveAll();
			comboObjects[1].focus();

			return true;
		} else {
			comboObjects[2].RemoveAll();
			comboObjects[2].Enable = true;
		}

	} else {
		comboObjects[2].RemoveAll();
	}
}

function lane_OnFocus(comboObj) {

	comboObjects[2].Enable = true;

	if (comboObjects[1].GetCount() <= 0) {
		comboObj.Enable = false;
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
		if (comboObjects[1].GetCount() > 0) {
			comboObj.Enable = true;
			comboObjects[1].focus();
		}

	}
}

function vvd_OnFocus(comboObj) {

	var f = document.form;
	flag = false;
	if (f.froms.value == "") {
		if (f.period.value == "M") {
			ComShowCodeMessage("CIM21001", "Period");
		} else {
			ComShowCodeMessage("CIM21001", "Period");
		}
		ComSetFocus(f.froms);
		return false;
	} else if (f.tos.value == "") {
		if (f.period.value == "M") {
			ComShowCodeMessage("CIM21001", "Period");
		} else {
			ComShowCodeMessage("CIM21001", "Period");

		}
		ComSetFocus(f.tos);
		return false;
	} else if (comboObjects[0].Text == "") {
		ComShowCodeMessage("CIM29027");
		document.form.prepolnext.focus();
		return false;
	}
	/*
	else if (comboObjects[1].Text == "") {
		ComShowCodeMessage("CIM21001", "LANE CODE는");
		return false;
	}
	 */
	if (comboObjects[2].GetCount() <= 0) {
		comboObj.Enable = false;
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
		if (comboObjects[2].GetCount() > 0) {
			comboObj.Enable = true;
			comboObjects[2].focus();
		}

	}
}

/**
 * vvd code 입력값 체크
 * @param KeyCode
 * @param Shift
 * @return HNDT0087E
 */
function vvd_OnBlur(KeyCode, Shift) {
	flag = false;
	if (comboObjects[2].Text.length > 0) {
		comboObjects[2].UseCode = false;
		comboObjects[2].Text = comboObjects[2].Text.toUpperCase();

		for ( var i = 0; i < comboObjects[2].GetCount(); i++) {

			if (comboObjects[2].Text == comboObjects[2].GetText(i, 0)) {

				flag = true;
				comboObjects[2].UseCode = true;
				break;
			}
		}
		if (flag == false) {
			ComShowCodeMessage("CIM29023");
			comboObjects[2].Text = "";
			comboObjects[2].focus();

			return true;
		}
		//document.form.flowpattern.focus();
	}

}

function obj_change() {

	obj = event.srcElement;
	if (obj.name == "period") {
		if (obj.value == "M") {
			document.getElementById("froms").setAttribute("dataformat", "ym");
			document.getElementById("tos").setAttribute("dataformat", "ym");
			document.form.froms.value = "";
			document.form.tos.value = "";
			document.form.from.value = "";
			document.form.to.value = "";
		} else {
			document.getElementById("froms").setAttribute("dataformat", "yw");
			document.getElementById("tos").setAttribute("dataformat", "yw");
			document.form.froms.value = "";
			document.form.tos.value = "";
			document.form.from.value = "";
			document.form.to.value = "";
		}
		document.form.froms.focus();
		comboObjects[2].RemoveAll(); // VVD삭제
	}
}

function obj_keypress() {
	switch (event.srcElement.name) {
	case "froms":
		// 숫자만 + "-"만 입력허용
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "tos":
		// 숫자만 + "-"만 입력허용
		ComKeyOnlyNumber(event.srcElement);
		break;
	}

}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {

	case "t1sheet1": //t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 390;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "VVD|Total";

			//컬럼 가변 처리를 위한 기준 데이터를 배열로 만든다.
			oldCntrTypeSize = sCntrTypeSize;
			var arrCntrTypeSize = oldCntrTypeSize.split(",");
			var arrHead = new Array();

			//컬럼 가변에 따라 해더타이틀 가변 처리
			for ( var i = 0; i < arrCntrTypeSize.length; i++) {
				// HeadTitle1 += arrHead.join("|" + arrCntrTypeSize[i]);
				if (sCntrTypeSize != "") {
					HeadTitle1 += "|" + arrCntrTypeSize[i];
				}
			}
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(42, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			sheetObj.FrozenCols = 2;
			for ( var i = arrCntrTypeSize.length + 2; i < 42; i++) {
				//컬럼 숨기기
				sheetObj.ColHidden(i) = true;
			}
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			//컬럼 가변에 따라 해더타이틀 가변 처리
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "vvd", false, "", dfNone);
			InitDataProperty(0, cnt++, dtAutoAvgEx, 40, daRight, true, "total", false, "", dfNullFloat, 1);
			CountPosition = 0;
			var sCount = "";
			var x = 1;
			for ( var i = 0; i < arrCntrTypeSize.length; i++) {
				if (arrCntrTypeSize.length > 1) {
					if (x < 10) {
						sCount = "count0" + x;
					} else {
						sCount = "count" + x;
					}
					InitDataProperty(0, cnt++, dtAutoAvgEx, 40, daRight, true, sCount, false, "", dfNullFloat, 1);
					x++;
				}
			}
		}
		break;

	case "t2sheet1": //t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 390;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 3, 3, 100);

			var colCount = 43;
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(colCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = "VVD|Division|Total";

			//컬럼 가변 처리를 위한 기준 데이터를 배열로 만든다.
			oldCntrTypeSize2 = sCntrTypeSize;
			var arrCntrTypeSize = oldCntrTypeSize2.split(",");
			var arrHead = new Array(5);

			//컬럼 가변에 따라 해더타이틀 가변 처리
			for ( var i = 0; i < arrCntrTypeSize.length; i++) {
				// HeadTitle1 += arrHead.join("|" + arrCntrTypeSize[i]);
				if (sCntrTypeSize != "") {
					HeadTitle1 += "|" + arrCntrTypeSize[i];
				}
			}
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			sheetObj.FrozenCols = 3;
			for ( var i = arrCntrTypeSize.length + 3; i < 43; i++) {
				//컬럼 숨기기
				sheetObj.ColHidden(i) = true;
			}

			var rowCnt = 0;

			var POL = 80;
			var Division = 60;
			var Total = 70;
			cnt = 0;

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(rowCnt, cnt++, dtData, POL, daCenterTop, true, "vvd", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtData, Division, daCenter, true, "etc", false, "", dfNone, 1, false, false, false, false, false);
			InitDataProperty(rowCnt, cnt++, dtAutoSum, Total, daRight, false, "total", false, "", dfNullInteger, 1);
			CountPosition = 0;
			var sCount = "";
			var sDays = "";
			var x = 1;
			for ( var i = 0; i < arrCntrTypeSize.length; i++) {
				if (arrCntrTypeSize.length > 1) {
					if (x < 10) {
						sCount = "count0" + x;
					} else {
						sCount = "count" + x;
					}
					InitDataProperty(rowCnt, cnt++, dtAutoSum, 60, daRight, true, sCount, false, "", dfNullInteger, 1);
					x++;
				}
			}

			rowCnt++;
			cnt = 0;
			InitDataProperty(rowCnt, cnt++, dtData, POL, daCenterTop, true, "d2VVD", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtData, Division, daCenter, true, "d2Division", false, "", dfNone, 1);
			InitDataProperty(rowCnt, cnt++, dtAutoSum, Total, daRight, false, "total", false, "", dfNullFloat, 1);

			x = 1;
			for ( var i = 0; i < arrCntrTypeSize.length; i++) {
				if (arrCntrTypeSize.length > 1) {
					if (x < 10) {
						sCount = "count0" + x;
					} else {
						sCount = "count" + x;
					}
					InitDataProperty(rowCnt, cnt++, dtAutoSum, 60, daRight, true, sCount, false, "", dfNullFloat, 1);
					x++;
				}
			}

			rowCnt++;
			cnt = 0;

			InitDataProperty(rowCnt, cnt++, dtData, POL, daCenterTop, true, "d3VVD", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtData, Division, daCenter, true, "d3Division", false, "", dfNone, 1);
			InitDataProperty(rowCnt, cnt++, dtAutoSum, Total, daRight, false, "total", false, "", dfNullFloat, 1);

			x = 1;
			for ( var i = 0; i < arrCntrTypeSize.length; i++) {
				if (arrCntrTypeSize.length > 1) {
					if (x < 10) {
						sCount = "count0" + x;
					} else {
						sCount = "count" + x;
					}
					InitDataProperty(rowCnt, cnt++, dtAutoSum, 60, daRight, true, sCount, false, "", dfNullFloat, 1);
					x++;
				}
			}
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회
		isOpen = true;
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;
			sheetObj.DoSearch4Post("EES_CIM_1007GS.do", FormQueryString(formObj));
			sheetObj.WaitImageVisible = true;
			ComOpenWait(false);
		} else {
			return;
		}

		break;

	case IBSEARCH_ASYNC01: //open 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			if (sheetObj.id == "t1sheet1") {
				formObj.f_cmd.value = SEARCH03;

				//		var sXml = sheetObj.GetSearchXml("EES_CIM_1007GS.do",FormQueryString(formObj));
				//			sheetObj.LoadSearchXml(sXml);
				var sXml = formObj.sXml.value;
				var sPol = ComGetEtcData(sXml, "sPort");
				if (sPol != undefined) {
					var arrPol = sPol.split("|");

					MakeComboObject(formObj.pol, arrPol);
				}

				var sLane = ComGetEtcData(sXml, "sLane");
				if (sLane != undefined) {
					var arrLane = sLane.split(",");

					MakeComboObject2(formObj.lane, arrLane);
				}

				sCntrTypeSize = ComGetEtcData(sXml, "cntrTypeSize");
			}
			//서버에서 가져온 "가변컬럼정보"만 읽어오기
			oldCntrTypeSize = sCntrTypeSize;
			sheetObj.Reset();
			initSheet(sheetObj);

			oldCntrTypeSize2 = sCntrTypeSize;
			sheetObjects[1].Reset();
			initSheet(sheetObjects[1]);

			ComSetFocus(formObj.froms);

		}
		break;

	case IBSEARCH_ASYNC02: //VVD COMBO 조회
		if (validateForm(sheetObj, formObj, sAction)) {

			formObj.f_cmd.value = SEARCH04;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_1007GS.do", FormQueryString(formObj));
			//sheetObj.LoadSearchXml(sXml);

			var sVvd = ComGetEtcData(sXml, "sVvd");
			if (sVvd != undefined) {
				var arrVvd = sVvd.split("|");
				MakeComboObject(formObj.vvd, arrVvd);
				comboObjects[2].Enable = true;
				var tid = setTimeout('lanenextfocus()', 500);

				document.form.lanenext.focus();

			}
			sheetObj.WaitImageVisible = true;

		} else {
			return;
		}
		break;

	case IBSEARCH_ASYNC03: //Lane COMBO 조회
		if (validateForm(sheetObj, formObj, sAction)) {

			formObj.f_cmd.value = SEARCH05;
			sheetObj.WaitImageVisible = false;

			document.getElementById("cursors").style.cursor = "wait";
			document.getElementById("btn_Retrieve").style.cursor = "wait";

			var sXml = sheetObj.GetSearchXml("EES_CIM_1007GS.do", FormQueryString(formObj));
			//sheetObj.LoadSearchXml(sXml);

			var sVvd = ComGetEtcData(sXml, "sLane");
			if (sVvd != undefined) {
				var arrVvd = sVvd.split(",");
				MakeComboObject2(formObj.lane, arrVvd);
				comboObjects[1].Enable = true;
				var tid = setTimeout('polnextfocus()', 500);

				document.form.polnext.focus();

			}
			document.getElementById("cursors").style.cursor = "";
			document.getElementById("btn_Retrieve").style.cursor = "";
			sheetObj.WaitImageVisible = true;

		} else {
			return;
		}
		break;
	}
}

function doActionIBSheet2(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	isOpen = true;
	switch (sAction) {

	case IBSEARCH: //조회

		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH02;
			sheetObj.DoSearch4Post("EES_CIM_10072GS.do", FormQueryString(formObj));
			sheetObj.WaitImageVisible = true;
			ComOpenWait(false);
		} else {
			return;
		}

		break;
	}
}

function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
	case "pol":
		var i = 0;
		with (comboObj) {
			BackColor = "#CCFFFF";
			DropHeight = 200;
			MultiSelect = false;
			UseAutoComplete = true;
			ValidChar(2, 0);
			MaxLength = 5;

		}
		break;

	case "lane":
		with (comboObj) {
			SetColAlign("center|left");
			SetColWidth("50|200");
			SetTitle("lane|Description");
			MultiSelect = false;
			//UseCode=false;
			UseAutoComplete = true;
			DropHeight = 200;
			ValidChar(2, 0);
			MaxLength = 3;
		}
		break;

	case "vvd":
		var i = 0;
		with (comboObj) {
			//BackColor = "#CCFFFF";
			DropHeight = 200;
			MultiSelect = false;
			UseAutoComplete = true;
			ValidChar(2, 1);
			MaxLength = 9;
		}
		break;
	}
}

function MakeComboObject(cmbObj, arrStr) {
	for ( var i = 0; i < arrStr.length; i++) {
		cmbObj.InsertItem(i, arrStr[i], arrStr[i]);
	}
}

function MakeComboObject2(cmbObj, arrStr) {
	for ( var i = 0; i < arrStr.length; i++) {
		cmbObj.InsertItem(i, arrStr[i], arrStr[i].substring(0, 3).trim());
	}
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;

}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {

	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertTab(cnt++, "Summary", -1);
			InsertTab(cnt++, "  Detail  ", -1);
		}
		break;

	}
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {

	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	//------------------------------------------------------//
	beforetab = nItem;
	tabIndex = nItem;

}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnClick(tabObj, nItem) {
	beforetab = nItem;
	tabIndex = nItem;
	if (isOpen) {
		if (nItem == 0) {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			sheetObjects[0].SelectRow = 0;
		} else if (nItem == 1) {
			doActionIBSheet2(sheetObjects[1], document.form, IBSEARCH);
			sheetObjects[1].SelectRow = 0;
		}
	}

}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (sAction == IBSEARCH) {
			if (period.value == "M") {
				if (froms.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(froms);
					return false;
				} else if (tos.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(tos);
					return false;
				}

			} else if (period.value == "W") {
				if (froms.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(froms);
					return false;
				} else if (tos.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(tos);
					return false;
				}

			}

			if (froms.value.length < 6) {
				return false;
			} else if (tos.value.length < 6) {
				return false;
			}
			if (!enterSwitch) {
				return false;
			}

			if (comboObjects[0].Text == "") {
				ComShowCodeMessage("CIM29027");
				comboObjects[0].focus();
				return false;
			}
		}

	}

	return true;
}

function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {

		var arrTime = sCntrTypeSize.split(",");
		for ( var i = 1; i < arrTime.length + 2; i++) {
			if (ComIsNull(CellValue(RowCount, i))) {
				SumText(0, i) = "";
			} else {
				SumText(0, i) = CellText(RowCount, i);
			}
		}

		if (RowCount > 0) {
			RowHidden(RowCount) = true;
		}
	}

}

function t2sheet1_OnChangeSum(sheetObj, Row) {
	with (sheetObj) {
		SumText(0, 0) = "Total";
		SumText(1, 0) = "Total";
		SumText(2, 0) = "Total";
		SumText(0, "etc") = "CNTR";
		SumText(1, "etc") = "Days";
		SumText(2, "etc") = "T/Time";
		CellAlign(LastRow - 2, "vvd") = daCenterTop;
		CellAlign(LastRow - 1, "vvd") = daCenterTop;
		CellAlign(LastRow, "vvd") = daCenterTop;
		CellAlign(LastRow - 2, "etc") = daCenter;
		CellAlign(LastRow - 1, "etc") = daCenter;
		CellAlign(LastRow, "etc") = daCenter;
		SetMergeCell((LastRow - 2), 0, 3, 1);
	}

}

function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		SumText(2, 2) = Math.round(SumValue(1, 2) / SumValue(0, 2) * 10) / 10;
		var arrTime = sCntrTypeSize.split(",");
		for ( var i = 3; i < arrTime.length + 3; i++) {
			if (SumValue(0, i) > 0) {
				SumValue(2, i) = Math.round(SumValue(1, i) / SumValue(0, i) * 10) / 10;
			}
		}

		var arrTime = sCntrTypeSize.split(",");
		for ( var i = 2; i < arrTime.length + 3; i++) {
			if (ComIsNull(CellValue(RowCount, i))) {
				SumText(0, i) = "";
				SumText(1, i) = "";
				SumText(2, i) = "";
			}
		}

	}

}

/* 개발자 작업  끝 */