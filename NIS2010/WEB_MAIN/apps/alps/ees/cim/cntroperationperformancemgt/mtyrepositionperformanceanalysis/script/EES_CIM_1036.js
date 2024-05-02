/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_cim_1036.js
 *@FileTitle : Repo Result for Domestic
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.29
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.05.29 박광석
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
 * @class ees_cim_1036 : ees_cim_1036 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cim_1036() {
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

var oldCntrTypeSize = "";
var sCntrTypeSize = "";
var enterSwitch = false;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var shtCnt = 0;
	var sheet1 = sheetObjects[shtCnt++];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {

		case "btn_Retrieve":

			doActionIBSheet(sheet1, formObject, IBSEARCH);
			sheetObjects[0].SelectRow = 0;
			break;

		case "btn_downexcel":
			sheet1.Down2Excel(-1);
			break;

		case "btn_location1": //location1 조회 팝업
			var check = "";
			for ( var i = 0; i < formObject.inquirywise.length; i++) {
				if (formObject.inquirywise[i].checked) {
					check = formObject.inquirywise[i].value;
				}
			}
			if (check == "L") {
				ComOpenPopup('/hanjin/COM_ENS_051.do', 750, 620, "getLocationInfo1", '1,0,1,1,1,1,1,1', true);
			}
			break;
		case "btn_location2": //location2 조회 팝업
			var check = "";
			for ( var i = 0; i < formObject.inquirywise.length; i++) {
				if (formObject.inquirywise[i].checked) {
					check = formObject.inquirywise[i].value;
				}
			}
			if (check == "L") {
				ComOpenPopup('/hanjin/COM_ENS_051.do', 750, 620, "getLocationInfo2", '1,0,1,1,1,1,1,1', true);
			}
			break;
		case "btn_new":
			sheet1.RemoveAll();
			formObject.reset();
			initForm();
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
 * Location Port Code Inquiry부분.<br>
 * @param {arry} aryPopupData
 */
function getLocationInfo1(aryPopupData) {
	var formObject = document.form;
	var location = aryPopupData[0][3];
	formObject.loccode1.value = location;
}

/**
 * Location Port Code Inquiry부분.<br>
 * @param {arry} aryPopupData
 */
function getLocationInfo2(aryPopupData) {
	var formObject = document.form;
	var location = aryPopupData[0][3];
	formObject.loccode2.value = location;
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
	initControl();
	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}

}

function sheet1_OnLoadFinish(sheetObj) {
	//sheetObj.WaitImageVisible = false;
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	//sheetObj.WaitImageVisible = true;
}

/**
 * 초기스크립트 구동
 * @return
 */
function initControl() {
	axon_event.addListener('click', 'reverse_cntr_tpsz_cd_check', 'chk_cntr_tpsz_cd', ''); //TP/SZ 체크박스 체크 이벤트 처리
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); //- form OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerForm('click', 'obj_tpsz_click', form);
	axon_event.addListenerFormat('keyup', 'form_keyup', form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('blur', 'obj_locLevelBlur', form);

	document.form.loccode1.disabled = true;
	document.form.loccode2.disabled = true;
	document.getElementById("loccode1").className = "input2";
	document.getElementById("loccode2").className = "input2";
	ComSetFocus(document.form.froms);
}

/**
 * form 초기화한다-->NEW 버튼 클릭시
 * @return
 */
function initForm() {
	document.getElementById("rcc").className = "input2";
	document.form.loccode1.value = "";
	document.form.loccode2.value = "";
	document.form.loccode1.disabled = true;
	document.form.loccode2.disabled = true;
	document.getElementById("loccode1").className = "input2";
	document.getElementById("loccode2").className = "input2";
	sheetObjects[0].CellValue2(0, 0) = "To LCC";
	sheetObjects[0].CellValue2(0, 1) = "Fm LCC";

	document.form.rdtype.disabled = true;
	document.form.rdtype.value = "I";
}

/**
 * obj_locLevelBlur()
 * @return
 */
function obj_locLevelBlur() {

	switch (event.srcElement.name) {

	case "loccode1":
		if (event.srcElement.value != "") {
			document.getElementById("location").value = document.getElementById("loccode1").value;
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02, "loccode1");
		}

		break;
	case "loccode2":
		if (event.srcElement.value != "") {
			document.getElementById("location").value = document.getElementById("loccode2").value;
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02, "loccode2");
		}
		break;

	}
}

/**
 * obj_keypress()
 * @return
 */
function obj_keypress() {

	switch (event.srcElement.name) {
	case "loccode1":
		ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자만 입력허용
		break;
	case "loccode2":
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "rcc":
		ComKeyOnlyAlphabet('uppernum');
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

function form_keyup() {
	var obj = null;
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	if (keyValue != 13) {
		ComKeyEnter('lengthnextfocus');
	} else {
		obj_deactivate();
	}
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
	} else if (obj.name == "inquirywise") {
		if (obj.value != "R") {
			document.form.loccode1.disabled = false;
			document.form.loccode2.disabled = false;
			//document.form.rcc.disabled = true;
			document.form.rcc.value = "";
			document.getElementById("rcc").className = "input2";
			document.getElementById("loccode1").className = "input1";
			document.getElementById("loccode2").className = "input";

			document.getElementById("loccode1").focus();

		} else {
			document.form.loccode1.value = "";
			document.form.loccode2.value = "";
			document.form.loccode1.disabled = true;
			document.form.loccode2.disabled = true;
			//document.form.rcc.disabled = false;
			document.getElementById("rcc").className = "input2";
			document.form.rcc.value = "USNYC";
			document.getElementById("loccode1").className = "input2";
			document.getElementById("loccode2").className = "input2";
			//document.getElementById("rcc").focus();
		}

	} else if (obj.name == "inquirylevel") {
		if (document.form.directionwise.value != "F") {
			if (obj.value == "L") {
				sheetObjects[0].CellValue2(0, 0) = "To LCC";
				sheetObjects[0].CellValue2(0, 1) = "Fm LCC";
			} else if (obj.value == "E") {
				sheetObjects[0].CellValue2(0, 0) = "To ECC";
				sheetObjects[0].CellValue2(0, 1) = "Fm ECC";
			} else if (obj.value == "S") {
				sheetObjects[0].CellValue2(0, 0) = "To SCC";
				sheetObjects[0].CellValue2(0, 1) = "Fm SCC";
			}
		} else {
			if (obj.value == "L") {
				sheetObjects[0].CellValue2(0, 0) = "Fm LCC";
				sheetObjects[0].CellValue2(0, 1) = "To LCC";
			} else if (obj.value == "E") {
				sheetObjects[0].CellValue2(0, 0) = "Fm ECC";
				sheetObjects[0].CellValue2(0, 1) = "To ECC";
			} else if (obj.value == "S") {
				sheetObjects[0].CellValue2(0, 0) = "Fm SCC";
				sheetObjects[0].CellValue2(0, 1) = "To SCC";
			}
		}

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
			document.getElementById("froms").focus();
		} else {
			document.getElementById("froms").setAttribute("dataformat", "yw");
			document.getElementById("tos").setAttribute("dataformat", "yw");

			document.form.froms.value = "";
			document.form.tos.value = "";
			document.form.from.value = "";
			document.form.to.value = "";
			document.getElementById("froms").focus();
		}
	} else if (obj.name == "directionwise") {
		var checkValue = "";
		for ( var i = 0; i < document.form.inquirylevel.length; i++) {
			if (document.form.inquirylevel[i].checked) {
				checkValue = document.form.inquirylevel[i].value;
			}
		}
		var ft = document.getElementById("ff");
		var ld = document.getElementById("tt");
		if (obj.value != "F") {
			ft.innerText = "From";
			ld.innerText = "To";
			if (checkValue == "L") {
				sheetObjects[0].CellValue2(0, 0) = "To LCC";
				sheetObjects[0].CellValue2(0, 1) = "Fm LCC";
			} else if (checkValue == "E") {
				sheetObjects[0].CellValue2(0, 0) = "To ECC";
				sheetObjects[0].CellValue2(0, 1) = "Fm ECC";
			} else if (checkValue == "S") {
				sheetObjects[0].CellValue2(0, 0) = "To SCC";
				sheetObjects[0].CellValue2(0, 1) = "Fm SCC";
			}
		} else {
			ft.innerText = "To";
			ld.innerText = "From";
			if (checkValue == "L") {
				sheetObjects[0].CellValue2(0, 0) = "Fm LCC";
				sheetObjects[0].CellValue2(0, 1) = "To LCC";
			} else if (checkValue == "E") {
				sheetObjects[0].CellValue2(0, 0) = "Fm ECC";
				sheetObjects[0].CellValue2(0, 1) = "To ECC";
			} else if (checkValue == "S") {
				sheetObjects[0].CellValue2(0, 0) = "Fm SCC";
				sheetObjects[0].CellValue2(0, 1) = "To SCC";
			}
		}

	}

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
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {

	case "sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 380;
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

			var HeadTitle = "To LCC|Fm LCC|Total";

			//컬럼 가변 처리를 위한 기준 데이터를 배열로 만든다.
			oldCntrTypeSize = sCntrTypeSize;
			var arrCntrTypeSize = oldCntrTypeSize.split(",");
			var arrHead = new Array();

			//컬럼 가변에 따라 해더타이틀 가변 처리
			for ( var i = 0; i < arrCntrTypeSize.length; i++) {
				if (sCntrTypeSize != "") {
					HeadTitle += "|" + arrCntrTypeSize[i];
				}
			}
			CountPosition = 0;
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(arrCntrTypeSize.length + 3, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			sheetObj.FrozenCols = 3;
			var rowCnt = 0;

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(rowCnt, cnt++, dtData, 100, daCenterTop, true, "loccode01", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtData, 100, daCenter, true, "loccode02", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtAutoSum, 60, daRight, true, "counttotal", false, "", dfNullInteger, 1);

			var sCount = "";
			var x = 1;
			for ( var i = 0; i < arrCntrTypeSize.length; i++) {
				if (arrCntrTypeSize.length > 1) {
					if (x < 10) {
						sCount = "count0" + x;
					} else {
						sCount = "count" + x;
					}
					InitDataProperty(rowCnt, cnt++, dtAutoSum, 50, daRight, true, sCount, false, "", dfNullInteger, 1);

					x++;
				}
			}

		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, gubun) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("EES_CIM_1034GS.do", FormQueryString(formObj));
			sheetObj.WaitImageVisible = true;
			ComOpenWait(false);
		} else {
			return;
		}

		break;

	case IBSEARCH_ASYNC01: //open 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH01;
			var sXml = formObj.sXml.value;
			//var sXml = sheetObj.GetSearchXml("EES_CIM_1001GS.do",	FormQueryString(formObj));

			sCntrTypeSize = ComGetEtcData(sXml, "cntrTypeSize");

			//서버에서 가져온 "가변컬럼정보"만 읽어오기
			if (oldCntrTypeSize != sCntrTypeSize) {
				oldCntrTypeSize = sCntrTypeSize;
				sheetObj.Reset();
				initSheet(sheetObj);
			}
			//	sheetObj.LoadSearchXml(sXml);
			ComSetFocus(document.form.froms);
		}
		break;
	case IBSEARCH_ASYNC02:
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH02;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_1001GS.do", FormQueryString(formObj));
			var sCheck = ComGetEtcData(sXml, "check");
			if (sCheck != "OK") {
				ComShowCodeMessage("CIM29024");
				if (gubun == "loccode1") {
					formObj.loccode1.value = "";
					ComSetFocus(formObj.loccode1);
				} else if (gubun == "loccode2") {
					formObj.loccode2.value = "";
					ComSetFocus(formObj.loccode2);
				}
				sheetObj.WaitImageVisible = true;
				return false;
			}
			if (gubun == "loccode1") {
				formObj.loccode2.value = "";
				ComSetFocus(formObj.loccode2);
			} else if (gubun == "loccode2") {
				//ComSetFocus(formObj.cargotype);
			}
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

}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction, gubun) {
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

			var check2 = "";
			for ( var i = 0; i < inquirywise.length; i++) {
				if (inquirywise[i].checked) {
					check2 = inquirywise[i].value;
				}
			}
			if (check2 == "R") {
				if (rcc.value == "") {
					ComShowCodeMessage("CIM29001");
					ComSetFocus(rcc);
					return false;
				}

			} else {
				if (loccode1.value == "" ) {
					ComShowCodeMessage("CIM29002");
					ComSetFocus(loccode1);
					return false;
				}
				
				if (loccode1.value.length < 5) {
					ComShowCodeMessage("CIM29024");
					ComSetFocus(loccode1);
					return false;
				}

			}
		}
	}
	return true;
}

// Total 행의 0을 제거한다.
function removeZero(sheetObj) {
	with (sheetObj) {
		var sCol = 1;
		var eCol = LastCol;

		for (i = sCol; i <= eCol; i++) {
			if (0 == SumText(0, i)) {
				SumText(0, i) = "";
			}
		}
	}
}

// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		/*
		 ShowSubSum(
		 0,
		 "2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40",
		 -1, false, false, -1, "Status=%s;loccode01=;loccode02=Total");
		 */
		var arrTime = sCntrTypeSize.split(",");
		/*
		 for ( var x = 1; x < LastRow; x++) {
		 //	if (CellValue(x, 1) == "") {
		 //		CellValue(x, 1) = 'Total';
		 //	}

		 if (CellValue(x, 1) == "Total") {
		 RowBackColor(x) = RgbColor(201, 213, 235);
		 ColBackColor(0) = RgbColor(0, 0, 0);
		 }

		 }
		 */
		if (RowCount > 0) {
			RowHidden(RowCount) = true;
		}

		for ( var i = 2; i < arrTime.length + 3; i++) {
			//	if ( ComIsNull( CellValue(RowCount, i) ) ) {
			//		SumText(0, i) = "";
			//	}
			SumText(0, i) = CellText(RowCount, i);
		}

		SumText(0, 0) = "";
		SumText(0, 1) = "G.Total";
		CellAlign(LastRow, 1) = daCenter;

	}
}

/* 개발자 작업  끝 */