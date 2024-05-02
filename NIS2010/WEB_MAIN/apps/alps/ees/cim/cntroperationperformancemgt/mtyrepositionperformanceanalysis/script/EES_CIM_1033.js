/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_cim_1033.js
 *@FileTitle : Repo Result by Port
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.26
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.05.26 박광석
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
 * @class ees_cim_1033 : ees_cim_1033 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cim_1033() {
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
var oldCntrTypeSize2 = "";
var tabIndex = 0;
var isOpen = false;

var comboObjects = new Array();
var comboCnt = 0;
var flag = false;
var enterSwitch = false;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var shtCnt = 0;
	var sheet1 = sheetObjects[shtCnt++];
	//  var t2sheet1 = sheetObjects[shtCnt++];

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

		case "btn_vvd": //vvd 조회 팝업
			var check = "";
			for ( var i = 0; i < formObject.option.length; i++) {
				if (formObject.option[i].checked) {
					check = formObject.option[i].value;
				}
			}
			if (check == "V") {
				ComOpenPopup('/hanjin/COM_ENS_0B2.do', 750, 620, "getVvdInfo", '1,0,1,1,1,1,1,1', true);
			}
			break;

		case "btn_new":
			sheet1.RemoveAll();

			formObject.reset();
			initForm();
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
	initControl();
	//IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}

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
	axon_event.addListenerForm('focus', 'obj_activate', form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerForm('blur', 'obj_deactivate', form); //- form OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerForm('click', 'obj_tpsz_click', form);
	axon_event.addListenerFormat('keyup', 'form_keyup', form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	//    	axon_event.addListenerForm('blur', 'obj_vvdBlur', form);
	axon_event.addListener('focus', 'portnextfocus', 'portnext');
	axon_event.addListener('focus', 'rccnextfocus', 'rccnext');

	document.getElementById("vvd01").className = "input2";
	document.getElementById("vvd02").className = "input2";
	document.getElementById("vvd03").className = "input2";
	document.getElementById("vvd04").className = "input2";

	ComBtnDisable("btn_vvd"); // 버튼 disabled

}

/**
 * form 초기화한다-->NEW 버튼 클릭시
 * @return
 */
function initForm() {
	document.form.vvd01.value = "";
	document.form.vvd02.value = "";
	document.form.vvd03.value = "";
	document.form.vvd04.value = "";
	document.form.vvd01.disabled = true;
	document.form.vvd02.disabled = true;
	document.form.vvd03.disabled = true;
	document.form.vvd04.disabled = true;
	document.getElementById("vvd01").className = "input2";
	document.getElementById("vvd02").className = "input2";
	document.getElementById("vvd03").className = "input2";
	document.getElementById("vvd04").className = "input2";
	document.getElementById("froms").className = "input1";
	document.getElementById("tos").className = "input1";
	document.getElementById("period").className = "input1";
	document.form.period.disabled = false;
	document.form.froms.disabled = false;
	document.form.tos.disabled = false;
	comboObjects[0].Enable = true;

	comboObjects[1].Enable = true;
	comboObjects[2].Enable = true;
	comboObjects[3].Enable = false;
	comboObjects[4].Enable = false;
	comboObjects[3].Code = "";
	comboObjects[4].Code = "";

	document.form.rdtype.disabled = true;
	document.form.rdtype.value = "I";

	document.form.through.disabled = true;
	document.form.through.value = "I";

	var ft = document.getElementById("ft");
	var ld = document.getElementById("ld");
	var fmrcc = document.getElementById("fmrcc");
	var torcc = document.getElementById("torcc");
	var pol = document.getElementById("pol");
	var pod = document.getElementById("pod");

	ft.innerText = "TO/From";
	ld.innerText = "POD/POL";
	torcc.innerText = "TO RCC";
	fmrcc.innerText = "FM RCC";
	pod.innerText = "POD";
	pol.innerText = "POL";
	sheetObjects[0].CellValue2(0, 0) = "POD";
	sheetObjects[0].CellValue2(0, 1) = "POL";

	comboObjects[0].Code = "";
	comboObjects[1].Code = "";
	comboObjects[2].Code = "";
	comboObjects[3].Code = "";
	comboObjects[4].Code = "";

	ComBtnDisable("btn_vvd"); // 버튼 disabled

	document.getElementById("froms").focus();
}

/**
 * Vessel SKD & Code Inquiry부분.<br>
 * @param {arry} aryPopupData
 */
function getVvdInfo(aryPopupData) {
	var formObject = document.form;
	var vvd = aryPopupData[0][7];
	if (formObject.vvd01.value == '') {
		formObject.vvd01.value = vvd;
	} else if (formObject.vvd02.value == '') {
		formObject.vvd02.value = vvd;
	} else if (formObject.vvd03.value == '') {
		formObject.vvd03.value = vvd;
	} else if (formObject.vvd04.value == '') {
		formObject.vvd04.value = vvd;
	}
}

/**
 * obj_keypress 키 입력시 대소문자 처리
 * @return
 */
function obj_keypress() {
	switch (event.srcElement.name) {
	case "vvd01":
		ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자만 입력허용
		break;
	case "vvd02":
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "vvd03":
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "vvd04":
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "rcc01":
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
	} else if (obj.name == "tscntr") {
		if (obj.value != "T") {
			document.form.through.disabled = true;
			document.form.through.value = "I";
		} else {
			document.form.through.disabled = false;
		}

	} else if (obj.name == "inquirywise") {
		if (obj.value != "R") {
			comboObjects[1].Enable = false;
			comboObjects[2].Enable = false;
			comboObjects[3].Enable = true;
			comboObjects[4].Enable = true;
			comboObjects[1].Code = "";
			comboObjects[2].Code = "";

		} else {
			comboObjects[1].Enable = true;
			comboObjects[2].Enable = true;
			comboObjects[3].Enable = false;
			comboObjects[4].Enable = false;
			comboObjects[3].Code = "";
			comboObjects[4].Code = "";
		}

	} else if (obj.name == "option") {

		if (obj.value != "P") {
			document.form.period.disabled = true;
			document.form.froms.value = "";
			document.form.tos.value = "";
			document.form.froms.disabled = true;
			document.form.tos.disabled = true;
			comboObjects[0].Enable = false;
			comboObjects[0].Code = "";
			document.form.vvd01.disabled = false;
			document.form.vvd02.disabled = false;
			document.form.vvd03.disabled = false;
			document.form.vvd04.disabled = false;
			document.getElementById("vvd01").className = "input1";
			document.getElementById("vvd02").className = "input";
			document.getElementById("vvd03").className = "input";
			document.getElementById("vvd04").className = "input";
			document.getElementById("froms").className = "input2";
			document.getElementById("tos").className = "input2";
			document.getElementById("period").className = "input2";
			ComBtnEnable("btn_vvd");
			document.getElementById("vvd01").focus();
		} else {

			document.form.vvd01.value = "";
			document.form.vvd02.value = "";
			document.form.vvd03.value = "";
			document.form.vvd04.value = "";
			document.form.vvd01.disabled = true;
			document.form.vvd02.disabled = true;
			document.form.vvd03.disabled = true;
			document.form.vvd04.disabled = true;
			document.getElementById("vvd01").className = "input2";
			document.getElementById("vvd02").className = "input2";
			document.getElementById("vvd03").className = "input2";
			document.getElementById("vvd04").className = "input2";
			document.getElementById("froms").className = "input1";
			document.getElementById("tos").className = "input1";
			document.getElementById("period").className = "input1";
			document.form.period.disabled = false;
			document.form.froms.disabled = false;
			document.form.tos.disabled = false;
			comboObjects[0].Enable = true;
			ComBtnDisable("btn_vvd");
			document.getElementById("froms").focus();
		}
	} else if (obj.name == "directionwise") {
		var ft = document.getElementById("ft");
		var ld = document.getElementById("ld");
		var fmrcc = document.getElementById("fmrcc");
		var torcc = document.getElementById("torcc");
		var pol = document.getElementById("pol");
		var pod = document.getElementById("pod");

		if (obj.value != "F") {
			ft.innerText = "TO/From";
			ld.innerText = "POD/POL";
			torcc.innerText = "TO RCC";
			fmrcc.innerText = "FM RCC";
			pod.innerText = "POD";
			pol.innerText = "POL";
			sheetObjects[0].CellValue2(0, 0) = "POD";
			sheetObjects[0].CellValue2(0, 1) = "POL";
		} else {
			ft.innerText = "From/TO";
			ld.innerText = "POL/POD";
			torcc.innerText = "FM RCC";
			fmrcc.innerText = "TO RCC";
			pod.innerText = "POL";
			pol.innerText = "POD";
			sheetObjects[0].CellValue2(0, 0) = "POL";
			sheetObjects[0].CellValue2(0, 1) = "POD";
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
	case "vvd01":
		if (event.srcElement.value != "") {
			document.getElementById("vvd").value = document.getElementById("vvd01").value;
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
		}

		break;
	case "vvd02":
		if (event.srcElement.value != "") {
			document.getElementById("vvd").value = document.getElementById("vvd02").value;
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
		}
		break;
	case "vvd03":
		if (event.srcElement.value != "") {
			document.getElementById("vvd").value = document.getElementById("vvd03").value;
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
		}
		break;
	case "vvd04":
		if (event.srcElement.value != "") {
			document.getElementById("vvd").value = document.getElementById("vvd04").value;
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
		}
		break;
	}
	return true;
}

/*
 function obj_vvdBlur(){
 switch (event.srcElement.name) {
 case "vvd01":
 if(event.srcElement.value != ""){
 document.getElementById("vvd").value = document.getElementById("vvd01").value;
 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
 }

 break;
 case "vvd02":
 if(event.srcElement.value != ""){
 document.getElementById("vvd").value = document.getElementById("vvd02").value;
 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
 }
 break;
 case "vvd03":
 if(event.srcElement.value != ""){
 document.getElementById("vvd").value = document.getElementById("vvd03").value;
 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
 }
 break;
 case "vvd04":
 if(event.srcElement.value != ""){
 document.getElementById("vvd").value = document.getElementById("vvd04").value;
 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
 }
 break;
 }	
 }
 */

/**
 * lane code 입력값 체크
 * @param KeyCode
 * @param Shift
 * @return
 */
function lane_OnBlur(KeyCode, Shift) {
	flag = false;

	if (comboObjects[0].Text.length > 0) {
		comboObjects[0].UseCode = false;
		comboObjects[0].Text = comboObjects[0].Text.toUpperCase();

		for ( var i = 0; i < comboObjects[0].GetCount(); i++) {

			if (comboObjects[0].Text == comboObjects[0].GetText(i, 0)) {

				flag = true;
				comboObjects[0].UseCode = true;
				break;
			}
		}

		if (flag == false) {
			ComShowCodeMessage("CIM29012");
			comboObjects[0].Text = "";
			comboObjects[0].focus();

			return false;
		}
		flag = false;
		//	document.form.directionwise.focus();
	}
}

function portnextfocus() {
	comboObjects[4].focus();
}

function rccnextfocus() {
	comboObjects[2].focus();
}

/**
 * RCC1 code 입력값 체크
 * @param KeyCode
 * @param Shift
 * @return
 */
function rcc01_OnBlur(KeyCode, Shift) {
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
			ComShowCodeMessage("CIM29008");
			comboObjects[1].Text = "";
			comboObjects[1].focus();
			return false;
		}

		flag = false;
		//comboObjects[2].focus();
	}
}

/**
 * RCC2 code 입력값 체크
 * @param KeyCode
 * @param Shift
 * @return
 */
function rcc02_OnBlur(KeyCode, Shift) {
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
			ComShowCodeMessage("CIM29008");
			comboObjects[2].Text = "";
			comboObjects[2].focus();

			return false;
		} else {
			document.form.cargotype.focus();
		}
		flag = false;
		//document.form.cargotype.focus();
	} else {
		document.form.cargotype.focus();
	}
}

/**
 * POD code 입력값 체크
 * @param KeyCode
 * @param Shift
 * @return
 */
function port01_OnBlur(KeyCode, Shift) {
	flag = false;
	if (comboObjects[3].Text.length > 0) {
		comboObjects[3].UseCode = false;
		comboObjects[3].Text = comboObjects[3].Text.toUpperCase();

		for ( var i = 0; i < comboObjects[3].GetCount(); i++) {

			if (comboObjects[3].Text == comboObjects[3].GetText(i, 0)) {

				flag = true;
				comboObjects[3].UseCode = true;
				break;
			}
		}
		if (flag == false) {
			ComShowCodeMessage("CIM29024");
			comboObjects[3].Text = "";
			comboObjects[3].focus();

			return false;
		}

		flag = false;
		//	comboObjects[4].focus();
	}

}

/**
 * POL code 입력값 체크
 * @param KeyCode
 * @param Shift
 * @return
 */
function port02_OnBlur(KeyCode, Shift) {
	flag = false;
	if (comboObjects[4].Text.length > 0) {
		comboObjects[4].UseCode = false;
		comboObjects[4].Text = comboObjects[4].Text.toUpperCase();

		for ( var i = 0; i < comboObjects[4].GetCount(); i++) {

			if (comboObjects[4].Text == comboObjects[4].GetText(i, 0)) {

				flag = true;
				comboObjects[4].UseCode = true;
				break;
			}
		}
		if (flag == false) {
			ComShowCodeMessage("CIM29024");
			comboObjects[4].Text = "";
			comboObjects[4].focus();

			return false;
		} else {
			document.form.cargotype.focus();
		}
		flag = false;
		//document.form.cargotype.focus();
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

function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
	case "lane":
		with (comboObj) {
			SetColAlign("center|left");
			SetColWidth("50|200");
			SetTitle("lane|Description");
			MultiSelect = false;
			UseAutoComplete = true;
			DropHeight = 200;
			ValidChar(2, 0);
			MaxLength = 3;
		}
		break;

	case "rcc01":
		var i = 0;
		with (comboObj) {
			BackColor = "#CCFFFF";
			MultiSelect = false;
			UseAutoComplete = true;
			//MaxSelect = 1;
			DropHeight = 200;
			ValidChar(2, 0);
			MaxLength = 5;
		}
		break;

	case "rcc02":
		var i = 0;
		with (comboObj) {
			//BackColor = "#CCFFFF";
			DropHeight = 200;
			MultiSelect = false;
			UseAutoComplete = true;
			ValidChar(2, 0);
			MaxLength = 5;
		}
		break;
	case "port01":
		var i = 0;
		with (comboObj) {
			BackColor = "#CCFFFF";
			DropHeight = 200;
			MultiSelect = false;
			UseAutoComplete = true;
			Enable = false;
			ValidChar(2, 0);
			MaxLength = 5;
		}
		break;

	case "port02":
		var i = 0;
		with (comboObj) {
			//BackColor = "#CCFFFF";
			DropHeight = 200;
			MultiSelect = false;
			UseAutoComplete = true;
			Enable = false;
			ValidChar(2, 0);
			MaxLength = 5;
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
		cmbObj.InsertItem(i, arrStr[i], arrStr[i].substring(0, 3));
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

	case "sheet1": //t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 350;
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
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "POD|POL|Total";

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
			InitHeadMode(true, true, false, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			sheetObj.FrozenCols = 3;
			var rowCnt = 0;

			var a = 00;
			var FM = 80;
			var TO = 60;
			var Total = 60;

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			//		InitDataProperty(rowCnt, cnt++ , dtHiddenStatus, a,    daCenter, true,     "Statsu");
			InitDataProperty(rowCnt, cnt++, dtData, FM, daCenterTop, true, "loccode01", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtData, TO, daCenter, true, "loccode02", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtAutoSum, Total, daRight, true, "counttotal", false, "", dfNullInteger, 1);

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
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회

		isOpen = true;
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;
			sheetObj.DoSearch4Post("EES_CIM_1033GS.do", FormQueryString(formObj));
			sheetObj.WaitImageVisible = true;
			ComOpenWait(false);
		} else {
			return;
		}

		break;

	case IBSEARCH_ASYNC01: //open 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			//formObj.f_cmd.value = SEARCH02;

			//var sXml = sheetObj.GetSearchXml("EES_CIM_1033GS.do",	FormQueryString(formObj));
			var sXml = formObj.sXml.value;
			var sRcc = ComGetEtcData(sXml, "sRcc");
			if (sRcc != undefined) {
				var arrRcc = sRcc.split("|");

				MakeComboObject(formObj.rcc01, arrRcc);
				MakeComboObject(formObj.rcc02, arrRcc);
			}

			var sPol = ComGetEtcData(sXml, "sPort");
			if (sPol != undefined) {
				var arrPol = sPol.split("|");

				MakeComboObject(formObj.port01, arrPol);
				MakeComboObject(formObj.port02, arrPol);
			}

			var sLane = ComGetEtcData(sXml, "sLane");

			if (sLane != undefined) {
				var arrLane = sLane.split(",");

				MakeComboObject2(formObj.lane, arrLane);
			}

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
	case IBSEARCH_ASYNC02: //location focusOut
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH03;

			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_1033GS.do", FormQueryString(formObj));
			var sCheck = ComGetEtcData(sXml, "check");
			if (sCheck != "OK") {
				ComShowCodeMessage("CIM29023");
				document.form.vvd01.value = "";
				sheetObj.WaitImageVisible = true;
				ComSetFocus(document.form.vvd01);
				return false;
			}
			formObj.directionwise.focus();
			sheetObj.WaitImageVisible = true;
		} else {
			return;
		}

		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (sAction == IBSEARCH) {
			var check = "";
			for ( var i = 0; i < option.length; i++) {
				if (option[i].checked) {
					check = option[i].value;
				}
			}
			if (check == "P") {
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

			} else {
				if (vvd01.value == "") {
					ComShowCodeMessage("CIM29006");
					ComSetFocus(vvd01);
					return false;
				}
			}
			var check2 = "";
			for ( var i = 0; i < inquirywise.length; i++) {
				if (inquirywise[i].checked) {
					check2 = inquirywise[i].value;
				}
			}

			if (check2 == "R") {
				if (comboObjects[1].Code == "") {
					ComShowCodeMessage("CIM29001");
					ComSetFocus(rcc01);
					return false;
				}

			} else {
				if (comboObjects[3].Code == "") {
					ComShowCodeMessage("CIM29007");
					ComSetFocus(port01);
					return false;
				}

			}
		}

	}

	return true;
}

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
		 //		if (CellValue(x, 1) == "") {
		 //			CellValue(x, 1) = 'Total';
		 //		}

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

		SumText(0, 0) = "G.Total";
		//	SumText(0, 1) = "G.Total";
		CellAlign(LastRow, 0) = daCenter;
		if (RowCount > 0) {
			SetMergeCell(LastRow, 0, 1, 2);
		}

	}

}

/* 개발자 작업  끝 */