/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_cim_1001.js
 *@FileTitle : Turn Time by PORT
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.05.04 박광석
 * 1.0 Creation
 * ======================================================
 * 2011.03.16 남궁진호 [CHM-201109288-01]Location Code 숫자입력가능하게수정
 *                    ComKeyOnlyAlphabet('upper') ->ComKeyOnlyAlphabet('uppernum')
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
 * @class ees_cim_1001 : ees_cim_1001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
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
var isOpen = false;
var enterSwitch = false;

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
				t2sheet1.RemoveAll();
				doActionIBSheet(t1sheet1, formObject, IBSEARCH);
				sheetObjects[0].SelectRow = 0;

			} else {
				t1sheet1.RemoveAll();
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
			formObject.rdtype.disabled = true;
			formObject.rdtype.value = "I";
			document.getElementById("location").className = "input2";
			document.getElementById("location").value = "";
			document.getElementById("location").disabled = true;
			formObject.reset();
			ComSetFocus(formObject.froms);
			break;
		case "btns_calendarfm":
			var cal = new ComCalendar();
			cal.setDisplayType('month');
			cal.select(formObject.froms, 'yyyy-MM');
			break;
		case "btns_calendarto":
			var cal = new ComCalendar();
			cal.setDisplayType('month');
			cal.select(formObject.tos, 'yyyy-MM');
			break;

		case "btn_loc_cd": //Location 조회 팝업
			var cnt_cd = "";
			var loc_cd = "";
			cnt_cd = formObject.inquiryLevel.value;
			loc_cd = formObject.location.value;
			if (formObject.inquiryLevel.value != 'A') {
				if (formObject.inquiryLevel.value == 'C') { //Country
					var param = "?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
					ComOpenPopup("/hanjin/COM_ENS_0M1.do", 565, 650, "popupFinish", "1,0,1,1,1,1,1,1", true);
				} else {
					var loc_code = "";

					if (formObject.inquiryLevel.value == "R") {
						loc_code = "rcc_cd";
					} else if (formObject.inquiryLevel.value == "P") {
						loc_code = "loc_cd";
					}
					var param = "?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
					ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 460, loc_code + ":location", "1,0,1,1,1,1,1,1", true);
				}
			}
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
 * Location by loc_cd 팝업에서 선택한 값 Setting.
 */
function popupFinish(aryPopupData, row, col, sheetIdx) {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	formObject.location.value = aryPopupData[0][3]
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

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	axon_event.addListenerForm('click', 'obj_tpsz_click', form);
	axon_event.addListener('blur', 'obj_blur', 'location');
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerForm('focus', 'obj_activate', document.form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerForm('blur', 'obj_deactivate', document.form); //- form OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerFormat('keyup', 'form_keyup', form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	document.getElementById("location").className = "input2";

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	isOpen = true;
	document.form.froms.focus();
}

function t1sheet1_OnLoadFinish(sheetObj) {
	//	sheetObj.WaitImageVisible = false;
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
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

function obj_blur() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
}

function obj_keypress() {
	switch (event.srcElement.name) {
	case "location":
		ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자만 입력허용
		break;
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

function obj_change() {

	obj = event.srcElement;
	if (obj.name == "inquiryLevel") {
		if (obj.value == "A") {
			document.getElementById("location").disabled = true;
			document.getElementById("location").value = "";
			document.getElementById("location").className = "input2";
		} else {
			document.getElementById("location").disabled = false;
			document.getElementById("location").className = "input";
		//	document.getElementById("location").value = "";
			if (obj.value == "C") {
				document.getElementById("location").setAttribute("maxLength", 2);
			} else {
				document.getElementById("location").setAttribute("maxLength", 5);
			}
			document.getElementById("location").focus();
		}
	} else if (obj.name == "period") {
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

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "POL|Total";

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
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "pol", false, "", dfNone);
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
					InitDataProperty(0, cnt++, dtAutoAvgEx, 45, daRight, true, sCount, false, "", dfNullFloat, 1);
					x++;
				}
			}
			x = arrCntrTypeSize.length + 1;
			for ( var i = 0; i < 40 - arrCntrTypeSize.length; i++) {
				if (arrCntrTypeSize.length > 1) {
					if (x < 10) {
						sCount = "count0" + x;
					} else {
						sCount = "count" + x;
					}
					InitDataProperty(0, cnt++, dtHidden, 45, daRight, true, sCount, false, "", dfNullFloat, 1);
					x++;
				}
			}
		}
		break;

	case "t2sheet1": //t2sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 390;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 3, 3, 100);

			var colCount = 43;
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(colCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle1 = "POL|Division|Total";

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

			for ( var i = arrCntrTypeSize.length + 3; i < 43; i++) {
				//컬럼 숨기기
				sheetObj.ColHidden(i) = true;
			}

			var rowCnt = 0;

			var POL = 60;
			var Division = 60;
			var Total = 80;
			cnt = 0;
			sheetObj.FrozenCols = 3;
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(rowCnt, cnt++, dtData, POL, daCenterTop, true, "pol", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtData, Division, daCenter, true, "etc", false, "", dfNone, 1);
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
					InitDataProperty(rowCnt, cnt++, dtAutoSum, 80, daRight, true, sCount, false, "", dfNullInteger, 1);
					x++;
				}
			}
			x = arrCntrTypeSize.length + 1;
			for ( var i = 0; i < 40 - arrCntrTypeSize.length; i++) {
				if (arrCntrTypeSize.length > 1) {
					if (x < 10) {
						sCount = "count0" + x;
					} else {
						sCount = "count" + x;
					}
					InitDataProperty(rowCnt, cnt++, dtHidden, 80, daRight, true, sCount, false, "", dfNullInteger, 1);
					x++;
				}
			}
			rowCnt++;
			cnt = 0;
			InitDataProperty(rowCnt, cnt++, dtData, POL, daCenterTop, true, "d2POL", false, "", dfNone);
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
					InitDataProperty(rowCnt, cnt++, dtAutoSum, 80, daRight, true, sCount, false, "", dfNullFloat, 1);
					x++;
				}
			}
			x = arrCntrTypeSize.length + 1;
			for ( var i = 0; i < 40 - arrCntrTypeSize.length; i++) {
				if (arrCntrTypeSize.length > 1) {
					if (x < 10) {
						sCount = "count0" + x;
					} else {
						sCount = "count" + x;
					}
					InitDataProperty(rowCnt, cnt++, dtHidden, 80, daRight, true, sCount, false, "", dfNullFloat, 1);
					x++;
				}
			}
			rowCnt++;
			cnt = 0;

			InitDataProperty(rowCnt, cnt++, dtData, POL, daCenterTop, true, "d3POL", false, "", dfNone);
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
					InitDataProperty(rowCnt, cnt++, dtAutoSum, 80, daRight, true, sCount, false, "", dfNullFloat, 1);
					x++;
				}
			}
			x = arrCntrTypeSize.length + 1;
			for ( var i = 0; i < 40 - arrCntrTypeSize.length; i++) {
				if (arrCntrTypeSize.length > 1) {
					if (x < 10) {
						sCount = "count0" + x;
					} else {
						sCount = "count" + x;
					}
					InitDataProperty(rowCnt, cnt++, dtHidden, 80, daRight, true, sCount, false, "", dfNullFloat, 1);
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
			formObj.f_cmd.value = SEARCH03;
			sheetObj.DoSearch("EES_CIM_1001GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			sheetObj.WaitImageVisible = true;
		} else {
			return;
		}
		break;

	case IBSEARCH_ASYNC01: // OPEN 조회
		formObj.f_cmd.value = SEARCH01;

		if (sheetObj.id == "t1sheet1") {
			//var sXml = sheetObj.GetSearchXml("EES_CIM_1001GS.do",	FormQueryString(formObj));
			//	sheetObj.LoadSearchXml(sXml);
			var sXml = formObj.sXml.value;
			sCntrTypeSize = ComGetEtcData(sXml, "cntrTypeSize");
		}
		//서버에서 가져온 "가변컬럼정보"만 읽어오기
		//if ((oldCntrTypeSize != sCntrTypeSize) && (sheetObj.id == "t1sheet1")) {
		oldCntrTypeSize = sCntrTypeSize;
		sheetObj.Reset();
		initSheet(sheetObj);
		//}
		//if ((oldCntrTypeSize2 != sCntrTypeSize) && (sheetObj.id == "t2sheet1")) {
		oldCntrTypeSize2 = sCntrTypeSize;
		sheetObjects[1].Reset();
		initSheet(sheetObjects[1]);
		//}
		ComSetFocus(formObj.froms);

		break;

	case IBSEARCH_ASYNC02: //location focusOut
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH02;
			if (formObj.location.value == "") {
				return true;
			}
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_1001GS.do", FormQueryString(formObj));
			var sCheck = ComGetEtcData(sXml, "check");
			if (sCheck != "OK") {
				var inquiryLevel = document.getElementById("inquiryLevel").value;
				if (document.form.location.value != "") {
					if (inquiryLevel == "R") {

						ComShowCodeMessage("CIM29008");
						document.form.location.value = "";
						ComSetFocus(document.form.location);
						return false;

					} else if (inquiryLevel == "C") {
						ComShowCodeMessage("CIM29009");
						document.form.location.value = "";
						ComSetFocus(document.form.location);
						return false;
					} else if (inquiryLevel == "P") {
						ComShowCodeMessage("CIM29010");
						document.form.location.value = "";
						ComSetFocus(document.form.location);
						return false;
					}

				} else {
					return true;
				}
			}
			sheetObj.WaitImageVisible = true;
			ComSetFocus(document.form.portcom);
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
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("EES_CIM_10012GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			sheetObj.WaitImageVisible = true;
		} else {
			return;
		}

		break;
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
			if (inquiryLevel.value != "A") {
				if (location.value == "") {
					ComShowCodeMessage("CIM21001", "Location");
					ComSetFocus(location);
					return false;
				}
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
		CellAlign(LastRow - 2, "pol") = daCenterTop;
		CellAlign(LastRow - 1, "pol") = daCenterTop;
		CellAlign(LastRow, "pol") = daCenterTop;
		SetMergeCell((LastRow - 2), 0, 3, 1);
	}

}

function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		SumText(2, 2) = Math.round(SumValue(1, 2) / SumValue(0, 2) * 10) / 10;
		var arrTime = sCntrTypeSize.split(",");
		for ( var i = 3; i < arrTime.length + 3; i++) {
			if (SumValue(0, i) > 0) {
				SumText(2, i) = Math.round(SumValue(1, i) / SumValue(0, i) * 10) / 10;
			}
		}
/*
		for ( var x = 0; x < sheetObj.LastRow; x++) {
			if (sheetObj.CellValue(x, 1) == "T/Time") {
				RowBackColor(x) = RgbColor(201, 213, 235);
				ColBackColor(0) = RgbColor(0, 0, 0);
			}
		}
*/		
		var arrTime = sCntrTypeSize.split(",");
		for ( var i = 2; i < arrTime.length + 3; i++) {
			if (ComIsNull(CellValue(RowCount, i))) {
				SumText(0, i) = "";
				SumText(1, i) = "";
				SumText(2, i) = "";
			}
		}
		CellAlign(LastRow - 2, "etc") = daCenter;
		CellAlign(LastRow - 1, "etc") = daCenter;
		CellAlign(LastRow, "etc") = daCenter;

	}

}
