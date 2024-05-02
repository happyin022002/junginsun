/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_CIM_1011.js
 *@FileTitle : Turn Time by Movement
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.31
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.08.31 박광석
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
 * @class EES_CIM_1011 : EES_CIM_1011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_CIM_1011() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.sheet2_OnDblClick = sheet2_OnDblClick;
}

/* 개발자 작업 */

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var oldCntrTypeSize = "";
var sCntrTypeSize = "";
var enterSwitch = false;
var arrCntrTypeSize = "";
var tabIndex = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var shtCnt = 0;
	var sheet1 = sheetObjects[shtCnt++];
	var sheet2 = sheetObjects[shtCnt++];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			if (tabIndex == 0) {
				doActionIBSheet(sheet1, formObject, IBSEARCH);
				sheetObjects[0].SelectRow = 0;
			} else {
				doActionIBSheet2(sheet2, formObject, IBSEARCH);
				sheetObjects[1].SelectRow = 0;
			}
			break;
		case "btn_downexcel":
			if (tabIndex == 0) {
				sheet1.Down2Excel(-1);
			} else {
				sheet2.Down2Excel(-1);
			}

			break;

		case "btn_new":
			sheet1.RemoveAll();
			sheet2.RemoveAll();
			formObject.reset();
			document.getElementById("location").disabled = true;
			document.getElementById("location").className = "input2";
			document.getElementById("mvmtPair1").disabled = false;
			document.getElementById("mvmtPair1").value = "AL";
			document.getElementById("mvmtPair2").disabled = true;
			document.getElementById("mvmtPair2").value = "Z";
			ComSetFocus(formObject.froms);

			break;

		case "btn_loc_cd": // Location 조회 팝업
			var cnt_cd = "";
			var loc_cd = "";
			cnt_cd = formObject.inquiryLevel.value;
			loc_cd = formObject.location.value;
			if (formObject.inquiryLevel.value != 'AR' && formObject.inquiryLevel.value != 'AC') {
				// if (formObject.inquiryLevel.value == 'CC') { // Country
				// var param = "?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
				// ComOpenPopup("/hanjin/COM_ENS_0M1.do", 565, 630,
				// "popupFinish", "1,0,1,1,1,1,1,1", true);
				// } else {
				var loc_code = "";

				if (formObject.inquiryLevel.value == "RL" || formObject.inquiryLevel.value == "RE") {
					loc_code = "rcc_cd";
				} else if (formObject.inquiryLevel.value == "LE") {
					loc_code = "lcc_cd";
				} else if (formObject.inquiryLevel.value == "LS") {
					loc_code = "lcc_cd";
				} else if (formObject.inquiryLevel.value == "ES") {
					loc_code = "ecc_cd";
				} else if (formObject.inquiryLevel.value == "SS") {
					loc_code = "scc_cd";
				}
				var param = "?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 460, loc_code + ":location", "1,0,1,1,1,1,1,1", true);

				// }
			}
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

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	initControl();

}

/**
 * Tab 기본 설정 탭의 항목을 설정한다.
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
 * Tab 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {

	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	// --------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab = nItem;
	tabIndex = nItem;

}

/**
 * Tab 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnClick(tabObj, nItem) {
	beforetab = nItem;
	tabIndex = nItem;
	// if (isOpen) {
	if (nItem == 0) {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		sheetObjects[0].SelectRow = 0;
	} else if (nItem == 1) {
		doActionIBSheet2(sheetObjects[1], document.form, IBSEARCH);
		sheetObjects[1].SelectRow = 0;
	}
	// }

}

function sheet1_OnLoadFinish(sheetObj) {
	// sheetObj.WaitImageVisible = false;
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	// sheetObj.WaitImageVisible = true;
}

/**
 * 초기스크립트 구동
 * 
 * @return
 */
function initControl() {
	ComSetFocus(document.form.froms);
	document.getElementById("location").disabled = true;
	document.getElementById("location").className = "input2";
	document.getElementById("mvmtPair1").disabled = false;
	document.getElementById("mvmtPair1").value = "AL";
	document.getElementById("mvmtPair2").disabled = true;
	document.getElementById("mvmtPair2").value = "Z";

	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerForm('click', 'obj_click', form);
	axon_event.addListenerFormat('focus', 'obj_activate', form);
	axon_event.addListenerForm('blur', 'obj_deactivate', form);
	axon_event.addListener('blur', 'obj_blur', 'location');
	axon_event.addListenerFormat('keyup', 'form_keyup', form);
}

/**
 * 
 * @return
 */
function form_keyup() {
	var obj = null;
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	if (keyValue != 13) {
		ComKeyEnter('lengthnextfocus');
	} else {
		obj_deactivate();
	}
}

function obj_blur() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
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
 * 
 * @return
 */
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
		if (retMonth >= 3) {

			if (event.srcElement.name == "tos") {
				ComShowCodeMessage("CIM29044");
				ComSetFocus(document.getElementById("tos"));
			}
			return false;
		}
	} else if (period == "W") {
		if (frYearDate == toYearDate) {
			week = eval(toMonthDate) - eval(frMonthDate) + 1;
		} else {
			betwMonth = fromTo - eval(frMonthDate) + eval(toMonthDate) + 1;
			if ((eval(toYearDate) - eval(frYearDate)) == 1) { // 1년 차이일때
				week = betwMonth;
			} else {
				week = (eval(toYearDate) - eval(frYearDate) - 1) * fromTo + betwMonth;
			}
		}

		if (week > 13) {

			if (event.srcElement.name == "tos") {
				ComShowCodeMessage("CIM29044");
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

// Axon 이벤트 처리2. 이벤트처리함수
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
 * 달의 마지말 일을 구함
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

/**
 * focus in
 * @return
 */
function obj_activate() {
	ComClearSeparator(event.srcElement);
	ComSetFocus(event.srcElement);
}

/**
 * SELECT BOX change event
 * 
 * @return
 */
function obj_change() {

	obj = event.srcElement;
	if (obj.name == "inquiryLevel") {
		if (obj.value == "AR" || obj.value == "AC") {
			document.getElementById("location").disabled = true;
			document.getElementById("location").className = "input2";
			document.getElementById("location").value = "";
		} else {
		//	document.getElementById("location").value = "";
			document.getElementById("location").disabled = false;
			document.getElementById("location").className = "input";
			document.getElementById("location").focus();
		}
		if (obj.value == "CC") {
			document.getElementById("location").setAttribute("maxLength", 2);
		} else {
			document.getElementById("location").setAttribute("maxLength", 5);
		}
	} else if (obj.name == "period") {
		if (obj.value == "M") {
			document.getElementById("froms").setAttribute("dataformat", "ym");
			document.getElementById("tos").setAttribute("dataformat", "ym");

			document.form.froms.value = "";
			document.form.tos.value = "";
			document.form.from.value = "";
			document.form.to.value = "";
			ComSetFocus(document.form.froms);
		} else {
			document.getElementById("froms").setAttribute("dataformat", "yw");
			document.getElementById("tos").setAttribute("dataformat", "yw");

			document.form.froms.value = "";
			document.form.tos.value = "";
			document.form.from.value = "";
			document.form.to.value = "";
			ComSetFocus(document.form.froms);
		}
	}
}

/**
 * 클릭 이벤트 처리
 * 
 * @return
 */
function obj_click() {
	obj = event.srcElement;
	if (obj.name == "mvmtPairDivision") {

		if (obj.value == "1") {
			document.getElementById("mvmtPair1").disabled = false;
			document.getElementById("mvmtPair1").value = "AL";
			document.getElementById("mvmtPair2").disabled = true;
			document.getElementById("mvmtPair2").value = "Z";
		} else {
			document.getElementById("mvmtPair1").disabled = true;
			document.getElementById("mvmtPair1").value = "AL";
			document.getElementById("mvmtPair2").disabled = false;
			document.getElementById("mvmtPair2").value = "Z";
		}

	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo, HeadTitle) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {

	case "sheet1": // t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 400;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			if (HeadTitle == null || HeadTitle == "") {
				HeadTitle = "RCC|MVMT Pair|Total";
			}

			var headCnt = HeadTitle.split("|").length;
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCnt, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "pol", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "etc", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 40, daRight, true, "total", false, "", dfNullFloat, 1);
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
					InitDataProperty(0, cnt++, dtData, 40, daRight, true, sCount, false, "", dfNullFloat, 1);

					x++;
				}
			}

			FrozenCols = 3;
		}
		break;

	case "sheet2": // t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 400;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 3, 3, 100);

			if (HeadTitle == null || HeadTitle == "") {
				HeadTitle = "RCC|MVMT Pair|Division|Total";
			}

			var headCnt = HeadTitle.split("|").length;
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCnt, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			var rowCnt = 0;

			var POL = 80;
			var Division = 60;
			var Total = 70;
			cnt = 0;

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(rowCnt, cnt++, dtData, POL, daCenterTop, true, "pol", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtData, "80", daCenterTop, true, "etc", false, "", dfNone, 1, false, false, false, false, false);
			InitDataProperty(rowCnt, cnt++, dtData, Division, daCenter, true, "division", false, "", dfNone, 1, false, false, false, false, false);
			InitDataProperty(rowCnt, cnt++, dtData, Total, daRight, false, "total", false, "", dfNullInteger, 1);
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
					InitDataProperty(rowCnt, cnt++, dtData, 60, daRight, true, sCount, false, "", dfNullInteger, 1);
					x++;
				}
			}

			rowCnt++;
			cnt = 0;
			InitDataProperty(rowCnt, cnt++, dtData, POL, daCenterTop, true, "d2VVD", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtData, "80", daCenter, true, "d2Division", false, "", dfNone, 1);
			InitDataProperty(rowCnt, cnt++, dtData, Division, daCenter, true, "division", false, "", dfNone, 1, false, false, false, false, false);
			InitDataProperty(rowCnt, cnt++, dtData, Total, daRight, false, "total", false, "", dfNullFloat, 1);

			x = 1;
			for ( var i = 0; i < arrCntrTypeSize.length; i++) {
				if (arrCntrTypeSize.length > 1) {
					if (x < 10) {
						sCount = "count0" + x;
					} else {
						sCount = "count" + x;
					}
					InitDataProperty(rowCnt, cnt++, dtData, 60, daRight, true, sCount, false, "", dfNullFloat, 1);
					x++;
				}
			}

			rowCnt++;
			cnt = 0;

			InitDataProperty(rowCnt, cnt++, dtData, POL, daCenterTop, true, "d3VVD", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtData, "80", daCenter, true, "d3Division", false, "", dfNone, 1);
			InitDataProperty(rowCnt, cnt++, dtData, Division, daCenter, true, "division", false, "", dfNone, 1, false, false, false, false, false);
			InitDataProperty(rowCnt, cnt++, dtData, Total, daRight, false, "total", false, "", dfNullFloat, 1);

			x = 1;
			for ( var i = 0; i < arrCntrTypeSize.length; i++) {
				if (arrCntrTypeSize.length > 1) {
					if (x < 10) {
						sCount = "count0" + x;
					} else {
						sCount = "count" + x;
					}
					InitDataProperty(rowCnt, cnt++, dtData, 60, daRight, true, sCount, false, "", dfNullFloat, 1);
					x++;
				}
			}
		}
		sheetObj.FrozenCols = 4;

		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: // 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;

			var sXml = sheetObj.GetSearchXml("EES_CIM_1011GS.do", FormQueryString(formObj));

			var str_loc_nm = "";

			var f = document.form.inquiryLevel;

			var gubun = "";
			for ( var i = 0; i < document.form.mvmtPairDivision.length; i++) {
				if (document.form.mvmtPairDivision[i].checked) {
					gubun = document.form.mvmtPairDivision[i].value;
				}
			}

			if (f.value == "AR") {
				str_loc_nm = "RCC";
			} else if (f.value == "RL") {
				str_loc_nm = "LCC";
			} else if (f.value == "LE" || f.value == "RE") {
				str_loc_nm = "ECC";
			} else if (f.value == "LS" || f.value == "ES") {
				str_loc_nm = "SCC";
			} else if (f.value == "SS" && gubun == "1") {
				str_loc_nm = "SCC";
			} else if (f.value == "SS" && gubun == "2") {
				str_loc_nm = "Yard";
			} else if (f.value == "RC" || f.value == "AC" || f.value == "CC") {
				str_loc_nm = "Country";
			}

			var HeadTitle = str_loc_nm + "|MVMT Pair|Total" + sCntrTypeSize;

			sheetObj.Redraw = false;
			sheetObj.RemoveAll();
			sheetObj.Reset();
			initSheet(sheetObj, 1, HeadTitle);
			sheetObj.Redraw = true;
			sheetObj.LoadSearchXml(sXml);

			sheetObj.WaitImageVisible = true;
			ComOpenWait(false);
			
		} else {
			return;
		}

		break;

	case IBSEARCH_ASYNC01: // open 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH01;

			// var sXml = sheetObj.GetSearchXml("EES_CIM_1001GS.do",
			// FormQueryString(formObj));
			var sXml = formObj.sXml.value;
			sCntrTypeSize = ComGetEtcData(sXml, "cntrTypeSize");

			// 서버에서 가져온 "가변컬럼정보"만 읽어오기
			if (oldCntrTypeSize != sCntrTypeSize) {
				oldCntrTypeSize = sCntrTypeSize;

				arrCntrTypeSize = oldCntrTypeSize.split(",");
				sCntrTypeSize = "";
				// 컬럼 가변에 따라 해더타이틀 가변 처리
				for ( var i = 0; i < arrCntrTypeSize.length; i++) {

					sCntrTypeSize += "|" + arrCntrTypeSize[i];

				}
				var HeadTitle = "RCC|MVMT Pair|Total" + sCntrTypeSize;
				var HeadTitle1 = "RCC|MVMT Pair|Division|Total" + sCntrTypeSize;
				sheetObj.Reset();
				initSheet(sheetObj, 1, HeadTitle);
				initSheet(sheetObjects[1], 1, HeadTitle1);
			}
			// sheetObj.LoadSearchXml(sXml);
			ComSetFocus(document.form.froms);
		}
		break;

	case IBSEARCH_ASYNC02: // location focusOut
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH04;
			if (formObj.location.value == "") {
				return false;
			}
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_1016GS.do", FormQueryString(formObj));
			var sCheck = ComGetEtcData(sXml, "check");
			if (sCheck != "OK") {
				if (document.form.location.value != "") {
					ComShowCodeMessage("CIM29013");
					document.form.location.value = "";
					ComSetFocus(document.form.location);
					return false;

				} else {
					return true;
				}
			}
			sheetObj.WaitImageVisible = true;
		} else {
			return;
		}

		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet2(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: // 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;
			
			var sXml = sheetObj.GetSearchXml("EES_CIM_10112GS.do", FormQueryString(formObj));

			var str_loc_nm = "";

			var f = document.form.inquiryLevel;

			var gubun = "";
			for ( var i = 0; i < document.form.mvmtPairDivision.length; i++) {
				if (document.form.mvmtPairDivision[i].checked) {
					gubun = document.form.mvmtPairDivision[i].value;
				}
			}

			if (f.value == "AR") {
				str_loc_nm = "RCC";
			} else if (f.value == "RL") {
				str_loc_nm = "LCC";
			} else if (f.value == "LE" || f.value == "RE") {
				str_loc_nm = "ECC";
			} else if (f.value == "LS" || f.value == "ES") {
				str_loc_nm = "SCC";
			} else if (f.value == "SS" && gubun == "1") {
				str_loc_nm = "SCC";
			} else if (f.value == "SS" && gubun == "2") {
				str_loc_nm = "Yard";
			} else if (f.value == "RC" || f.value == "AC" || f.value == "CC") {
				str_loc_nm = "Country";
			}

			var HeadTitle = str_loc_nm + "|MVMT Pair|Division|Total" + sCntrTypeSize;

			sheetObj.Redraw = false;
			sheetObj.RemoveAll();
			sheetObj.Reset();
			initSheet(sheetObj, 1, HeadTitle);
			sheetObj.Redraw = true;
			sheetObj.LoadSearchXml(sXml);
			
			sheetObj.WaitImageVisible = true;
			ComOpenWait(false);

		} else {
			return;
		}

		break;
	}
}

/**
 * IBTab Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;

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

			if (location.value == "") {
				if (inquiryLevel.value != "AR" && inquiryLevel.value != "AC") {
					ComShowCodeMessage("CIM21001", "Location by");
					ComSetFocus(location);
					return false;
				}
/*
				if (inquiryLevel.value == "RL") {
					ComShowCodeMessage("CIM29014");
					ComSetFocus(location);
					return false;
				} else if (inquiryLevel.value == "LE") {
					ComShowCodeMessage("CIM29015");
					ComSetFocus(location);
					return false;
				} else if (inquiryLevel.value == "LS" || inquiryLevel.value == "ES" || inquiryLevel.value == "SS") {
					ComShowCodeMessage("CIM29016");
					ComSetFocus(location);
					return false;
				}
*/				
			}

			if (froms.value.length < 6) {
				return false;
			} else if (tos.value.length < 6) {
				return false;
			}
			if (!enterSwitch) {
				return false;
			}

		}

	}

	return true;
}

/**
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
/*
	 with (sheetObj) {
		for ( var x = 0; x <= LastRow; x++) {
			if (CellValue(x, 0) == "") {
				CellValue(x, 0) = "Average";
				CellFont("FontBold", x, 0) = true;
			}
		}

	}
*/
}

/**
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
/*
	 with (sheetObj) {
		for ( var x = 0; x <= LastRow; x++) {
			if (CellValue(x, 0) == "") {
				CellValue(x, 0) = "Average";
				CellAlign(x, 0) = daCenterTop;
				CellFont("FontBold", x, 0) = true;
			}
		}
		WaitImageVisible = true;
	}
*/
}


/**
 * CSR No에 해당하는 CSR Head Information를 보여준다 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} row     	sheetObj의 선택된 Row
 * @param {ibsheet} col     	sheetObj의 선택된 Col
 * @param {int}     cellX     	X좌표값
 * @param {int} 	cellY     	Y좌표값
 * @param {int}     cellW     	Cell 넓이
 * @param {int}     cellW     	Cell 높이
 **/
function sheet2_OnDblClick(sheetObj, row, col, cellX, cellY, cellW, cellH) {
	var row;
	var param;
	
	rsheetObjects = sheetObj;
	
	//alert('row ' + row);
	
		if(row > 0) {

			var formObject = document.form;
        	
        	param = FormQueryString(formObject);

        	param += "&tpsztitle="+ sheetObj.CellValue(0,sheetObj.SelectCol);
        	param += "&loctitle="+ sheetObj.CellValue(0,0);
        	param += "&locvalue="+ sheetObj.CellValue(sheetObj.SelectRow,0);
        	param += "&convalue="+ sheetObj.CellValue(sheetObj.SelectRow,1);
        	
        	if(sheetObj.CellValue(sheetObj.SelectRow,sheetObj.SelectCol) > 0 && 
        			sheetObj.CellValue(sheetObj.SelectRow,2) == "CNTR" &&
        			sheetObj.CellValue(sheetObj.SelectRow,0) != "Average") {
        		ComOpenPopup("/hanjin/EES_CIM_1952.do?"+param, 600, 550, "", "1,0,1,1,1", false, false, null, null, null, "EES_CIM_1952");
            }
       }
}

/* 개발자 작업 끝 */