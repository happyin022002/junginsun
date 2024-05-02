/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_cim_1016.js
 *@FileTitle : Turn Time by Location
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.12
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.05.12 박광석
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
 * @class ees_cim_1016 : ees_cim_1016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cim_1016() {
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
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;
var tot_cntr_tpsz_cd = "";
var sPeriod = ""
var tabIndex = 0;
var isOpen = true;
var sSaveName = "";
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
			} else {
				t1sheet1.RemoveAll();
				doActionIBSheet2(t2sheet1, formObject, IBSEARCH);
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
			formObject.reset();
			document.getElementById("location").disabled = true;
			document.getElementById("location").className = "input2";
			document.getElementById("enRoute").disabled = true;
			document.getElementById("enRoute").value = "";
			document.getElementById("tscntr").disabled = false;
			document.getElementById("tscntr").value = "E";
			ComSetFocus(formObject.froms);

			break;

		case "btn_loc_cd": //Location 조회 팝업
			var cnt_cd = "";
			var loc_cd = "";
			cnt_cd = formObject.inquiryLevel.value;
			loc_cd = formObject.location.value;
			if (formObject.inquiryLevel.value != 'AR' && formObject.inquiryLevel.value != 'AC') {
				if (formObject.inquiryLevel.value == 'CC') { //Country
					var param = "?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
					ComOpenPopup("/hanjin/COM_ENS_0M1.do", 565, 650, "popupFinish", "1,0,1,1,1,1,1,1", true);
				} else {
					var loc_code = "";

					if (formObject.inquiryLevel.value == "RC") {
						loc_code = "rcc_cd";
					} else if (formObject.inquiryLevel.value == "RL" || formObject.inquiryLevel.value == "RE") {
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
					ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 440, loc_code + ":location", "1,0,1,1,1,1,1,1", true);
				}
			}
			break;

		case "btn_Close":
			window.close();
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
function loadPage(gubun) {
	var formObject = document.form;
	/////////////////////////////////////////////////////////
	if("Y"==formObject.pop_yn.value){
		//팝업버튼영역 보이기
		document.all.popLayer.style.display = "";
	}
	/////////////////////////////////////////////////////////
	
	for (i = 0; i < sheetObjects.length; i++) {

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);

	}

	//     sheetObjects[sheetObjects.length-1].Visible = true;
	initControl();
	//IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	if (gubun != "") {
		tabObjects[0].SelectedIndex = 1;
		enterSwitch = true;
	} else {
		isOpen = true;
	}
}

function t1sheet1_OnLoadFinish(sheetObj) {
	//	sheetObj.WaitImageVisible = false;
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	//	sheetObj.WaitImageVisible = true;
	if (document.form.tpszs.value != "") {

		comboObjects[0].Code = document.form.tpszs.value;

	}

}

/**
 * 초기스크립트 구동
 * @return
 */
function initControl() {

	document.getElementById("location").className = "input2";
	axon_event.addListener('click', 'reverse_cntr_tpsz_cd_check', 'chk_cntr_tpsz_cd', ''); //TP/SZ 체크박스 체크 이벤트 처리
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); //- form OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListener('blur', 'obj_blur', 'location');
	axon_event.addListenerFormat('keyup', 'form_keyup', form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

function tpsz_OnCheckClick(comboObj, index, code) {
	if (index == 0) {
		var bChk = comboObj.CheckIndex(index);
		if (bChk) {
			for ( var i = 1; i < comboObj.GetCount(); i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
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

/**
 * Location by loc_cd 팝업에서 선택한 값 Setting.
 */
function popupFinish(aryPopupData, row, col, sheetIdx) {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	formObject.location.value = aryPopupData[0][3]
}

function obj_blur() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
}

/**
 * tpsz_cd 체크박스 컨트롤
 * @return
 */
function reverse_cntr_tpsz_cd_check() {
	var formObject = document.form;
	if (formObject.chk_cntr_tpsz_cd.checked) {
		comboObjects[0].Code = tot_cntr_tpsz_cd.replaceStr("|", ",");
	} else {
		comboObjects[0].Code = "";
	}
}

/**
 * 기간 체크
 * @return
 */
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
 * 마지막 날짜 구하기
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
 * FOCUS IN
 */
function obj_activate() {
	ComClearSeparator(event.srcElement);
	ComSetFocus(event.srcElement);
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

/**
 * 키입력 이벤트 처리
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

/**
 * CHANGE 이벤트 처리
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
			document.form.location.focus();
		}
		if (obj.value == "CC") {
			document.getElementById("location").setAttribute("maxLength", 2);
		} else {
			document.getElementById("location").setAttribute("maxLength", 5);
		}
		if (obj.value == "RL") {
			document.getElementById("enRoute").disabled = false;
			document.getElementById("enRoute").value = "E";
		} else {
			document.getElementById("enRoute").value = "";
			document.getElementById("enRoute").disabled = true;
		}

		if (obj.value == "AR") {
			document.getElementById("tscntr").disabled = false;
			document.getElementById("tscntr").value = "E";
		} else {
			document.getElementById("tscntr").value = "";
			document.getElementById("tscntr").disabled = true;
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
function initSheet(sheetObj, sheetNo, HeadTitle) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	//sSaveName = "";
	switch (sheetID) {

	case "t1sheet1": //t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 300;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 19, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			if (HeadTitle == null || HeadTitle == "") {
				HeadTitle = "RCC|TP/SZ|Total";
				InitColumnInfo(3, 0, 0, true);
			}

			var headCnt = HeadTitle.split("|").length;

			SheetWidth = headCnt * 70 + 30;
			if (SheetWidth > 975) {
				SheetWidth = 975;
			}

			InitColumnInfo(headCnt, 0, 0, true);
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			sheetObj.FrozenCols = 3;
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 70, daCenterTop, true, "loccode", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "tpsz", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daRight, true, "total", false, "", dfNullFloat, 1);

			CountPosition = 0;

			for ( var i = 1; i <= headCnt - 3; i++) {
				if (i < 10) {
					InitDataProperty(0, cnt++, dtAutoSum, 70, daRight, true, "count0" + (i), false, "", dfNullFloat, 0, true, true);
				} else {
					InitDataProperty(0, cnt++, dtAutoSum, 70, daRight, true, "count" + (i), false, "", dfNullFloat, 0, true, true);
				}
			}
			ExtendLastCol = false;
		}
		break;

	case "t2sheet1": //t2sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 300;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 3, 19, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			if (HeadTitle == null || HeadTitle == "") {
				HeadTitle = "RCC|TP/SZ|Division|Total";
				InitColumnInfo(4, 0, 0, true);
			}

			var headCnt = HeadTitle.split("|").length;
			SheetWidth = headCnt * 80;
			if (SheetWidth > 975) {
				SheetWidth = 975;
			}

			InitColumnInfo(headCnt, 0, 0, true);
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			sheetObj.FrozenCols = 4;
			var rowCnt = 0;

			var RCC = 70;
			var TPSZ = 80;
			var Division = 70;
			var Total = 80;

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(rowCnt, cnt++, dtData, RCC, daCenterTop, true, "loccode", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtData, TPSZ, daCenterTop, true, "tpsz", false, "", dfNone, 1);
			InitDataProperty(rowCnt, cnt++, dtData, Division, daCenter, true, "division", false, "", dfNone, 1);
			InitDataProperty(rowCnt, cnt++, dtAutoSum, Total, daRight, false, "total", false, "", dfNullInteger, 1);

			CountPosition = 0;

			for ( var i = 1; i <= headCnt - 4; i++) {
				if (i < 10) {
					InitDataProperty(rowCnt, cnt++, dtAutoSum, 80, daRight, true, "count0" + (i), false, "", dfNullInteger, 0, true, true);

				} else {
					InitDataProperty(rowCnt, cnt++, dtAutoSum, 80, daRight, true, "count" + (i), false, "", dfNullInteger, 0, true, true);

				}
			}

			rowCnt++;
			cnt = 0;

			InitDataProperty(rowCnt, cnt++, dtData, RCC, daCenter, true, "d2RCC", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtData, TPSZ, daCenter, true, "tpsz2", false, "", dfNone, 1);
			InitDataProperty(rowCnt, cnt++, dtData, Division, daCenter, false, "division2", false, "", dfNone, 1);
			InitDataProperty(rowCnt, cnt++, dtAutoSum, Total, daRight, false, "total", false, "", dfNullFloat, 1);

			for ( var i = 1; i <= headCnt - 4; i++) {
				if (i < 10) {
					InitDataProperty(rowCnt, cnt++, dtAutoSum, 80, daRight, true, "count0" + (i), false, "", dfNullFloat, 0, true, true);
				} else {
					InitDataProperty(rowCnt, cnt++, dtAutoSum, 80, daRight, true, "count" + (i), false, "", dfNullFloat, 0, true, true);

				}
			}

			rowCnt++;
			cnt = 0;

			InitDataProperty(rowCnt, cnt++, dtData, RCC, daCenter, true, "d3RCC", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtData, TPSZ, daCenter, true, "tpsz3", false, "", dfNone, 1);
			InitDataProperty(rowCnt, cnt++, dtData, Division, daCenter, false, "division3", false, "", dfNone, 1);
			InitDataProperty(rowCnt, cnt++, dtAutoSum, Total, daRight, false, "total", false, "", dfNullFloat, 1);

			for ( var i = 1; i <= headCnt - 4; i++) {
				if (i < 10) {
					InitDataProperty(rowCnt, cnt++, dtAutoSum, 80, daRight, true, "count0" + (i), false, "", dfNullFloat, 0, true, true);

				} else {
					InitDataProperty(rowCnt, cnt++, dtAutoSum, 80, daRight, true, "count" + (i), false, "", dfNullFloat, 0, true, true);

				}
			}
			ExtendLastCol = false;
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

			var sXml = sheetObj.GetSearchXml("EES_CIM_1016GS.do", FormQueryString(formObj));
			sPeriod = ComGetEtcData(sXml, "head");
			//서버에서 가져온 "가변컬럼정보"만 읽어오기

			var str_loc_nm = "";

			var f = document.form.inquiryLevel;

			if (f.value == "AR") {
				str_loc_nm = "RCC";
			} else if (f.value == "RL") {
				str_loc_nm = "LCC";
			} else if (f.value == "LE" || f.value == "RE") {
				str_loc_nm = "ECC";
			} else if (f.value == "LS" || f.value == "ES" || f.value == "SS") {
				str_loc_nm = "SCC";
			} else if (f.value == "RC" || f.value == "AC" || f.value == "CC") {
				str_loc_nm = "Country";
			}

			var HeadTitle = str_loc_nm + "|TP/SZ|Total|" + sPeriod;
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

	case IBSEARCH_ASYNC01: //open 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH03;
			//	var sXml = sheetObj.GetSearchXml("EES_CIM_1016GS.do",FormQueryString(formObj));

			//	sheetObj.LoadSearchXml(sXml);
			var sXml = formObj.sXml.value;
			var sTpsz = ComGetEtcData(sXml, "cntr_tpsz_cd");
			tot_cntr_tpsz_cd = sTpsz;

			if (sTpsz != undefined) {
				var arrTpsz = sTpsz.split("|");

				MakeComboObject(formObj.tpsz, arrTpsz);
			}
			ComSetFocus(formObj.froms);
		}
		break;

	case IBSEARCH_ASYNC02: //location focusOut
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
			ComSetFocus(document.form.flowpattern);
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

			var sXml = sheetObj.GetSearchXml("EES_CIM_10162GS.do", FormQueryString(formObj));
			sPeriod = ComGetEtcData(sXml, "head");
			//서버에서 가져온 "가변컬럼정보"만 읽어오기

			var str_loc_nm = "";

			var f = document.form.inquiryLevel;

			if (f.value == "AR") {
				str_loc_nm = "RCC";
			} else if (f.value == "RL") {
				str_loc_nm = "LCC";
			} else if (f.value == "LE" || f.value == "RE") {
				str_loc_nm = "ECC";
			} else if (f.value == "LS" || f.value == "ES" || f.value == "SS") {
				str_loc_nm = "SCC";
			} else if (f.value == "RC" || f.value == "AC" || f.value == "CC") {
				str_loc_nm = "Country";
			}

			var HeadTitle = str_loc_nm + "|TP/SZ|Division|Total|" + sPeriod;
			//		sheetObj.Redraw = false;
			//		sheetObj.RemoveAll();
			sheetObj.Reset();
			initSheet(sheetObj, 1, HeadTitle);
			//		sheetObj.Redraw = true;
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
 * 콤보박스 초기화
 * @param comboObj
 * @param comboNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
	case "tpsz":
		var i = 0;
		with (comboObj) {
			//BackColor = "#CCFFFF";
			DropHeight = 320;
			MultiSelect = true;
			MultiSeparator = ",";
			Style = 1;
		}
		break;

	}
}

/**
 * 콤보박스 만드는 메소드
 * @param cmbObj
 * @param arrStr
 * @return
 */
function MakeComboObject(cmbObj, arrStr) {
	cmbObj.InsertItem(0, 'ALL', '');
	for ( var i = 1; i <= arrStr.length; i++) {
		cmbObj.InsertItem(i, arrStr[i - 1], arrStr[i - 1]);
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
			InsertTab(cnt++, "   Detail   ", -1);
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
		} else if (nItem == 1) {
			doActionIBSheet2(sheetObjects[1], document.form, IBSEARCH);
		}
	}

}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (sAction != IBSEARCH_ASYNC01 && sAction != IBSEARCH_ASYNC02) {
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
			if (inquiryLevel.value != "AR" && inquiryLevel.value != "AC") {
				if (location.value == "") {
					ComShowCodeMessage("CIM21001", "Location By");
					ComSetFocus(location);
					return false;
				}
			}
		}
	}

	return true;
}

/**
 * Sheet1 조회후 발생 이벤트
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
	/*
		for ( var x = 0; x < sheetObj.LastRow; x++) {
			if (CellValue(x, 1) == "Average") {
				RowBackColor(x) = RgbColor(201, 213, 235);
			}
		}
*/
		SumText(0, 0) = "";
		SumText(0, 1) = "TTL.Average";
		CellAlign(LastRow, "tpsz") = daCenter;
		var arrTime = sPeriod.split("|");
		for ( var i = 2; i < arrTime.length + 3; i++) {
			if (CellValue(RowCount, i) > 0.0) {
				SumText(0, i) = CellValue(RowCount, i);
			}
		}
		if (RowCount > 0) {
			RowHidden(RowCount) = true;
		}
	}

}

/**
 * Sheet2 changeSum 이벤트 처리.
 * @param sheetObj
 * @param Row
 * @return
 */
function t2sheet1_OnChangeSum(sheetObj, Row) {
	with (sheetObj) {
		SumText(0, "loccode") = "TTL.Average";
		SumText(1, "loccode") = "TTL.Average";
		SumText(2, "loccode") = "TTL.Average";
		SumText(0, "tpsz") = "TTL.Average";
		SumText(1, "tpsz") = "TTL.Average";
		SumText(2, "tpsz") = "TTL.Average";

		SumText(0, "division") = "CNTR";
		SumText(1, "division") = "Days";
		SumText(2, "division") = "T/Time";
		CellAlign(LastRow - 2, "loccode") = daCenterTop;
		CellAlign(LastRow - 1, "loccode") = daCenterTop;
		CellAlign(LastRow, "loccode") = daCenterTop;
		CellAlign(LastRow - 2, "tpsz") = daCenterTop;
		CellAlign(LastRow - 1, "tpsz") = daCenterTop;
		CellAlign(LastRow, "tpsz") = daCenterTop;
		CellAlign(LastRow - 2, "division") = daCenter;
		CellAlign(LastRow - 1, "division") = daCenter;
		CellAlign(LastRow, "division") = daCenter;
		SetMergeCell((LastRow - 2), 0, 3, 2);
	}

}

/**
 * Sheet2 조회후 발생 이벤트
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {

		var arrTime = sPeriod.split("|");
		for ( var i = 3; i < arrTime.length + 4; i++) {
			SumText(0, i) = CellText(RowCount - 2, i);
			SumText(1, i) = CellText(RowCount - 1, i);
		}

		if (RowCount > 0) {
			RowHidden(RowCount - 2) = true;
			RowHidden(RowCount - 1) = true;
			RowHidden(RowCount) = true;
		}

		SumText(2, 3) = Math.round(SumValue(1, 3) / SumValue(0, 3) * 10) / 10;
		var arrTime = sPeriod.split("|");
		for ( var i = 4; i < arrTime.length + 4; i++) {
			if (SumValue(0, i) > 0) {
				SumText(2, i) = Math.round(SumValue(1, i) / SumValue(0, i) * 10) / 10;
			}
		}
		/*
		for ( var x = 0; x < sheetObj.LastRow; x++) {
			if (sheetObj.CellText(x, 1) == "Average") {
				RowBackColor(x) = RgbColor(201, 213, 235);
			}
		}
*/
	}

}

/* 개발자 작업  끝 */