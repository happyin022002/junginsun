/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_cim_1051.js
 *@FileTitle : MTY CNTR PFMC by Movement
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.02
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.06.02 박광석
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.09.02 남궁진호 [CHM-201005671-01]
 *   - 두개의 MVMT STS를 조회하는 경우 이전 이후 MVMT EVENT DATE 를  모두 보여주도록 수정함
 *     EVENTDATE -> PRE-EVENT_DATE,POST_EVENT_DATE추가
 * 2011.03.16 남궁진호 [CHM-201109288-01]Location Code 숫자입력가능하게수정
 *                    ComKeyOnlyAlphabet('upper') ->ComKeyOnlyAlphabet('uppernum')
 * Ticket No :CHM-201109997-01
 * 개발자 : 나상보
 * Title  : [CIM] Movement Performance by CY 기능 보완
 * Description : 1.tab2sheet(Detail) column 3개 추가
 * 				 2.tab1sheet(Summury) 선택시에만 Location combo에 RCC 선택 가능하도록 추가 
 * 2011.04.21 남궁진호 [CHM-201110306-01] 조회 옵션 변경
 * Period가 Date(YYYY-MM-DD)일 경우 Summary, Detail open
   Period가 (Month)YYYY-MM일 경우 Summary, Trend open
   Period가 (Week)YYYY-WW일 경우 Summary, Trend open 
 * 2011.06.01 신자영 [CHM-201111319-01] [CIM] Movement Performance by CY의 Detail탭 조건 보완 요청
 * 2011.08.19 김민수 [CHM-201112858-01] [CIM] Repo.Result 화면 내의 Movement Performance by CY 탭 추가   
 * 2011.11.21 신자영 [CHM-201114577-01] MVMT BY CY 기능 보완
 * 2013.06.11 이영두 [CHM-201324997] Daily Trend 탭의 TP/SZ 조건 OT 일 경우 O5 항목 추가
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
 * @class ees_cim_1051 : ees_cim_1051 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cim_1051() {
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

var comboObjects = new Array();
var comboCnt = 0;

var oldCntrTypeSize = "";
var sCntrTypeSize = "";
var tabIndex = 0;
var sPeriod = "";
var prePeriod = "";
var isOpen = true;
var enterSwitch = false;
var tot_lstm_cd ="";

var tpszList = new Array (	 	
	 	new Array("D2","D4","D5","D7"),
	 	new Array("O2","S2","O4","S4","O5"),
		new Array("F2","A2","F4","A4","F5"),	
		new Array("R2","R5","R9")
	)		

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var shtCnt = 0;
	var t1sheet1 = sheetObjects[shtCnt++];
	var t2sheet1 = sheetObjects[shtCnt++];
	var t3sheet1 = sheetObjects[shtCnt++];
	var t4sheet1 = sheetObjects[shtCnt++];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_Retrieve":
			if (tabIndex == 0) {
				t2sheet1.RemoveAll();
				t3sheet1.RemoveAll();
				doActionIBSheet(t1sheet1, formObject, IBSEARCH);
				sheetObjects[0].SelectRow = 0;
			} else if (tabIndex == 1) {
				t1sheet1.RemoveAll();
				t3sheet1.RemoveAll();
				// btn_t2EachCNTR 버튼 Disable
				ComBtnDisable("btn_t2EachCNTR");
				// btn_t2EachBKG 버튼 Disable
				ComBtnDisable("btn_t2EachBKG");
				doActionIBSheet2(t2sheet1, formObject, IBSEARCH);
				sheetObjects[1].SelectRow = 0;
			} else if (tabIndex == 2) {
				t1sheet1.RemoveAll();
				t2sheet1.RemoveAll();
				doActionIBSheet3(t3sheet1, formObject, IBSEARCH);
				sheetObjects[2].SelectRow = 0;
			}else {
				t1sheet1.RemoveAll();
				t2sheet1.RemoveAll();
				t3sheet1.RemoveAll();
				
				//dtlTpsz 값 세팅
				var arrTpszList;	
				//타입사이즈 리스트를 가져온다. 
				if(formObject.radioTpsz[0].checked){	
					arrTpszList = tpszList[0];
				} else if(formObject.radioTpsz[1].checked){
					arrTpszList = tpszList[1];
				} else if(formObject.radioTpsz[2].checked){
					arrTpszList = tpszList[2];
				} else {	
					arrTpszList = tpszList[3];	
				}		
										
				var tpszListStr = "";
				for(var i = 0; i < arrTpszList.length;i++){ 
					tpszListStr += arrTpszList[i] + ",";		
				}	
				tpszListStr = CimDelLastDelim(tpszListStr);			
				formObject.dtlTpsz.value = tpszListStr;
				//dtlTpsz 값 세팅
				
				doActionIBSheet4(t4sheet1, formObject, IBSEARCH);
				sheetObjects[3].SelectRow = 0;
				// 환경 설정 함수 추가
				ComEndConfigSheet(sheetObjects[3]);
			}
			break;

		case "btn_New":
			t1sheet1.RemoveAll();
			t2sheet1.RemoveAll();
			t3sheet1.RemoveAll();
			t4sheet1.RemoveAll();
			formObject.reset();
			tabObjects[0].TabEnable(1) = true;
			tabObjects[0].TabEnable(2) = false;
//			tabObjects[0].TabEnable(0) = true;
			document.getElementById("froms").setAttribute("dataformat", "ymd");
			document.getElementById("tos").setAttribute("dataformat", "ymd");
			document.getElementById("froms").setAttribute("maxLength", 8);
			document.getElementById("tos").setAttribute("maxLength", 8);
			document.getElementById("btns_calendarto").style.display = "";
			document.getElementById("bound").value = "";
			document.getElementById("bound").disabled = true;
			document.getElementById("bound").className = "input2";
			comboObjects[0].Code = "";
			comboObjects[3].Code = "";
			/* 2014.05.12 by Chang Young Kim ( AA Young Du Lee ) Init 항목 추가 (S) */
			document.getElementById("inquiryLevel").value = "S";
			comboObjects[2].Code = "T";
			/* 2014.05.12 by Chang Young Kim ( AA Young Du Lee ) Init 항목 추가 (E) */
			
			ComSetFocus(formObject.froms);
			break;

		case "btn_DownExcel":
			if (tabIndex == 0) {
				t1sheet1.Down2Excel(-1);
			} else if (tabIndex == 1) {
				t2sheet1.Down2Excel(-1);
			} else if (tabIndex == 2) {
				t3sheet1.Down2Excel(-1);
			} else {
				t4sheet1.Down2Excel(-1);
			}
			break;

		case "btns_calendarfm":
			var cal = new ComCalendar();
			cal.setDisplayType('date');
			cal.select(formObject.froms, 'yyyy-MM-dd');
			break;
		case "btns_calendarto":
			var cal = new ComCalendarFromTo();
			cal.setEndFunction("nextFocusOut");
			cal.select(formObject.froms, formObject.tos, 'yyyy-MM-dd');
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
				} else if (formObject.inquiryLevel.value == 'Y') { //YARD
					var param = "?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
					ComOpenPopup("/hanjin/COM_ENS_061.do", 755, 650, "popupFinish2", "1,0,1,1,1,1,1,1", true);
				} else {
					var loc_code = "";

					if (formObject.inquiryLevel.value == "R") {
						loc_code = "rcc_cd";
					} else if (formObject.inquiryLevel.value == "L") {
						loc_code = "lcc_cd";
					} else if (formObject.inquiryLevel.value == "E") {
						loc_code = "ecc_cd";
					} else if (formObject.inquiryLevel.value == "S") {
						loc_code = "scc_cd";
					}

					var param = "?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
					ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 460, loc_code + ":location", "1,0,1,1,1,1,1,1", true);
				}
			}
			break;
		case "btn_t2EachCNTR":
			// 버튼이 활성화 되어있을때만 기능
			if (ComIsBtnEnable(srcName)) {
				var sUrl = "/hanjin/EES_CTM_0408.do?" + "p_cntrno=" + t2sheet1.Cellvalue(t2sheet1.SelectRow, "cntrno").substring(0, 10)
						+ "&check_digit=" + t2sheet1.Cellvalue(t2sheet1.SelectRow, "cntrno").substring(10, 11) + "&ctnr_tpsz_cd="
						+ t2sheet1.Cellvalue(t2sheet1.SelectRow, "tpsz") + "&cnmv_evnt_dt="
						+ t2sheet1.Cellvalue(t2sheet1.SelectRow, "pre_eventdate").substring(0, 8);
				
				ComOpenPopupWithTarget(sUrl, 1020, 682, "", "0,0", true, "yes");
			}
			break;

		case "btn_t2EachBKG":
			// 버튼이 활성화 되어있을때만 기능
			if (ComIsBtnEnable(srcName)) {
/*
				var sUrl = "/hanjin/EES_CTM_0409.do?" + "bkg_no=" + t2sheet1.Cellvalue(t2sheet1.SelectRow, "bkgno").substring(0, 11)
				+ "&bkg_no_split=" + t2sheet1.Cellvalue(t2sheet1.SelectRow, "bkgno").substring(11, 13);
*/				
				var sUrl = "/hanjin/EES_CTM_0409.do?" + "bkg_no=" + t2sheet1.Cellvalue(t2sheet1.SelectRow, "bkgno");
				
				
				ComOpenPopupWithTarget(sUrl, 1020, 682, "", "0,1", true, "yes");
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

function nextFocusOut() {
	document.form.inquiryLevel.focus();
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
	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	//IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
	initControl();
	for (i = 0; i < sheetObjects.length; i++) {

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);

	}
	init_inquiryLevel();
	document.form.inquiryLevel.value = "S";

}

function t1sheet1_OnLoadFinish(sheetObj) {
	//	sheetObj.WaitImageVisible = false;
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	//	sheetObj.WaitImageVisible = true;
}

function initControl() {
	document.getElementById("bound").value = "";
	document.getElementById("bound").disabled = true;
	document.getElementById("bound").className = "input2";
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');	
	axon_event.addListener('click', 'reverse_cntr_tpsz_cd_check', 'chk_cntr_tpsz_cd', ''); //TP/SZ 체크박스 체크 이벤트 처리
	axon_event.addListenerForm('click', 'obj_click', document.form);
	axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
	axon_event.addListenerForm('change', 'obj_change', document.form);
	axon_event.addListenerForm('focus', 'obj_activate', document.form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerForm('blur', 'obj_deactivate', document.form); //- form OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerFormat('keyup', 'form_keyup', document.form);
	tabObjects[0].TabEnable(2) = false;
	prePeriod = "D";
	// btn_t2EachCNTR 버튼 Disable
	ComBtnDisable("btn_t2EachCNTR");
	// btn_t2EachBKG 버튼 Disable
	ComBtnDisable("btn_t2EachBKG");
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

function day_OnCheckClick(comboObj, index, code) {
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

/**
 * Location by loc_cd 팝업에서 선택한 값 Setting.
 */
function popupFinish(aryPopupData, row, col, sheetIdx) {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	formObject.location.value = aryPopupData[0][3]
}

/**
 * Location by yard_cd 팝업에서 선택한 값 Setting.
 */
function popupFinish2(aryPopupData, row, col, sheetIdx) {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	formObject.location.value = aryPopupData[0][3]
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
		if (retMonth >= 3) {
			if (event.srcElement.name == "tos") {
				ComShowCodeMessage("CIM29025");
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

		if (week > 12) {
			if (event.srcElement.name == "tos") {
				ComShowCodeMessage("CIM29025");
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
var imsi = 0;
//Axon 이벤트 처리2. 이벤트처리함수
function obj_deactivate() {

	var f = document.getElementById("froms");
	var t = document.getElementById("tos");
	sVal1 = f.value.replace(/\/|\-|\./g, "");
	sVal2 = t.value.replace(/\/|\-|\./g, "");

	switch (event.srcElement.name) {
	case "location":
		if (document.form.location.value != "") {
			if (imsi == 0) {
				var status = doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
				if (!status) {
					imsi = 0;
				}
			}
		}
		break;
	case "froms":
		if (ComChkObjValid(event.srcElement, false)) {

			if (f.getAttribute("dataformat") == "ym") {
				if (sVal1 != "" && sVal2 != "") {
					var day = lastDay(sVal2.substring(0, 4), sVal2.substring(4, 6));
					var flag = ComChkPeriod(sVal1 + "01", sVal2 + day);
					if (flag < 1) {
						//	ComShowCodeMessage("CIM29004");
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

			} else if (f.getAttribute("dataformat") == "ymd") {
				if (sVal1 != "" && sVal2 != "") {
					var flag = ComChkPeriod(sVal1, sVal2);
					if (flag < 1) {

						ComShowCodeMessage("CIM29004");
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

				switch (event.srcElement.name) {
				case "froms":
					if (f.value != "" && t.value == "") {
						t.value = ComGetDateAdd(f.value, "D", 6, "");
						document.form.inquiryLevel.focus();
					}
					break;
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
			} else if (f.getAttribute("dataformat") == "ymd") {

				if (sVal1.length > 0 && !ComIsDate(sVal1) && event.srcElement.name == 'froms') {
					event.srcElement.value = "";
					ComShowCodeMessage("CIM21004", "YYYYMMDD");
					event.srcElement.focus();
					event.srcElement.select();
					enterSwitch = false;
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
			} else if (t.getAttribute("dataformat") == "ymd") {
				if (sVal1 != "" && sVal2 != "") {
					var flag = ComChkPeriod(sVal1, sVal2);
					if (flag < 1) {
						if (event.srcElement.name == "tos") {
							ComShowCodeMessage("CIM29004");
							enterSwitch = false;
							event.srcElement.value = "";
							t.focus();
							t.select();
							return false;
						}
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

				switch (event.srcElement.name) {
				case "froms":
					if (f.value != "" && t.value == "") {
						t.value = ComGetDateAdd(f.value, "D", 6, "");

					}
					break;
				}
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
			} else if (t.getAttribute("dataformat") == "ymd") {

				if (sVal2.length > 0 && !ComIsDate(sVal2)) {
					enterSwitch = false;
					event.srcElement.value = "";
					ComShowCodeMessage("CIM21004", "YYYYMMDD");
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

function reverse_cntr_tpsz_cd_check() {
	var formObject = document.form;
	if (formObject.chk_cntr_tpsz_cd.checked) {
		comboObjects[0].Code = tot_cntr_tpsz_cd.replaceStr("|", ",");
	} else {
		comboObjects[0].Code = "";
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
	document.form.froms.value = y + m + "01";
	document.form.to.value = ComGetDateAdd(document.form.froms.value, "D", 6, "");
	document.form.tos.value = ComGetDateAdd(document.form.froms.value, "D", 6, "");

}

function obj_click() {
	formObj = document.form;
			
	obj = event.srcElement;
	if (obj.name == "radioTpsz") { // TP/SZ 종류에 따라
							
		sheetObjects[3].Reset();
								
		initSheet(sheetObjects[3],3);	
		sheetObjects[3].Redraw = true;
		// 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[3]);
		
		//dtlTpsz 값 세팅
		var arrTpszList;	
		//타입사이즈 리스트를 가져온다. 
		if(formObj.radioTpsz[0].checked){	
			arrTpszList = tpszList[0];
		} else if(formObj.radioTpsz[1].checked){
			arrTpszList = tpszList[1];
		} else if(formObj.radioTpsz[2].checked){
			arrTpszList = tpszList[2];
		} else {	
			arrTpszList = tpszList[3];	
		}		
								
		var tpszListStr = "";
		for(var i = 0; i < arrTpszList.length;i++){ 
			tpszListStr += arrTpszList[i] + ",";		
		}	
		tpszListStr = CimDelLastDelim(tpszListStr);			
		formObj.dtlTpsz.value = tpszListStr;
		//dtlTpsz 값 세팅
	}	
}	

function obj_keypress() {
	switch (event.srcElement.name) {
	case "location":
		if (document.form.inquiryLevel.value == "Y") {
			ComKeyOnlyAlphabet('uppernum');	// 알파벳 대문자,숫자만 입력허용
		} else {
			ComKeyOnlyAlphabet('uppernum');	// 알파벳 대문자,숫자만 입력허용
		}
		break;
	case "froms":
		// 숫자만 + "-"만 입력허용
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "tos":
		// 숫자만 + "-"만 입력허용
		ComKeyOnlyNumber(event.srcElement);
		break;
	/* 2014.04.25 by Chang Young Kim ( AA Young Du Lee ) 조회 조건 추가 (S) */
	case "vvd_nm":
		ComKeyOnlyAlphabet('uppernum');	// 알파벳 대문자,숫자만 입력허용
		break;
	}
	/* 2014.04.25 by Chang Young Kim ( AA Young Du Lee ) 조회 조건 추가 (E) */

}

/** 콤보 change 이벤트 처리
 * 
 * @return
 */
function obj_change() {

	obj = event.srcElement;
	if (obj.name == "inquiryLevel") {
		if (obj.value == "Y") {
			document.getElementById("location").setAttribute("maxLength", 7);
			document.getElementById("location").focus();
		} else {
			document.getElementById("location").setAttribute("maxLength", 5);
			document.getElementById("location").focus();
		}
	} else if (obj.name == "period") {
		if (obj.value == "M") {
			if (prePeriod == "D"){
//			tabObjects[0].TabEnable(0) = true; 
			tabObjects[0].TabEnable(1) = false;
			tabObjects[0].TabEnable(2) = true;
			}
			document.getElementById("froms").setAttribute("dataformat", "ym");
			document.getElementById("tos").setAttribute("dataformat", "ym");
			document.getElementById("froms").setAttribute("maxLength", 6);
			document.getElementById("tos").setAttribute("maxLength", 6);
			document.getElementById("btns_calendarto").style.display = "none";
			document.form.froms.value = "";
			document.form.tos.value = "";
			document.form.from.value = "";
			document.form.to.value = "";
//			document.form.gubun.value = "S";
			var preinquiryLevel = document.form.inquiryLevel.value;
			init_inquiryLevel();
			document.form.inquiryLevel.value = preinquiryLevel;

			isOpen = false;

		} else if (obj.value == "W") {
			if (prePeriod == "D"){
//			tabObjects[0].TabEnable(0) = true;  
			tabObjects[0].TabEnable(1) = false;
			tabObjects[0].TabEnable(2) = true;
			}
			document.getElementById("froms").setAttribute("dataformat", "yw");
			document.getElementById("tos").setAttribute("dataformat", "yw");
			document.getElementById("froms").setAttribute("maxLength", 6);
			document.getElementById("tos").setAttribute("maxLength", 6);
			document.getElementById("btns_calendarto").style.display = "none";

			document.form.froms.value = "";
			document.form.tos.value = "";
			document.form.from.value = "";
			document.form.to.value = "";
//			document.form.gubun.value = "S";
			var preinquiryLevel = document.form.inquiryLevel.value;
			init_inquiryLevel();
			document.form.inquiryLevel.value = preinquiryLevel;
			isOpen = false;
			
		} else {
//			tabObjects[0].TabEnable(0) = true;  
			tabObjects[0].TabEnable(1) = true;
			tabObjects[0].TabEnable(2) = false;
			document.getElementById("froms").setAttribute("dataformat", "ymd");
			document.getElementById("tos").setAttribute("dataformat", "ymd");
			document.getElementById("froms").setAttribute("maxLength", 8);
			document.getElementById("tos").setAttribute("maxLength", 8);
			document.getElementById("btns_calendarto").style.display = "";
			document.form.froms.value = "";
			document.form.tos.value = "";
			document.form.from.value = "";
			document.form.to.value = "";
//			document.form.gubun.value = "S";
			var preinquiryLevel = document.form.inquiryLevel.value;
			init_inquiryLevel();
			document.form.inquiryLevel.value = preinquiryLevel;
		}
		prePeriod = obj.value;
		document.form.froms.focus();
	} else if (obj.name == "mtymvmt") {
		if (obj.value == "VD" || obj.value == "VL" || obj.value == "TS" || obj.value == "ENF" || obj.value == "TNF") {
			document.getElementById("bound").disabled = false;
			document.getElementById("bound").value = "";
			document.getElementById("bound").className = "input";
		}  else {
			document.getElementById("bound").value = "";
			document.getElementById("bound").disabled = true;
			document.getElementById("bound").className = "input2";
		}
		// 2011.06.01 신자영 [CHM-201111319-01] Detail만 열어서 볼 경우 제어가 가능하도록 movement change event에 콤보 초기화 추가
		// obj.value == "VLMTMT-VL"
		if(document.form.gubun.value == "D"){
			init_inquiryLevel();	
		}
	}
}

function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
	case "tpsz":
		with (comboObj) {
			DropHeight = 320;
			MultiSelect = true;
			MultiSeparator = ",";
			Style = 1;
		}
		break;
	case "lstmcd":
		with (comboObj) {
			DropHeight = 320;
			MultiSelect = true;
			MultiSeparator = ",";
			Style = 1;
		}
		break;	
	case "day":
		with (comboObj) {
			DropHeight = 320;
			MultiSelect = true;
			MultiSeparator = ",";
			Style = 1;
		}
		break;
	/* 2014.04.25 by Chang Young Kim ( AA Young Du Lee ) 조회 조건 추가 (S) */
	case "vvd_tp":
		with (comboObj) {
			InsertItem(0, "T.VVD", "T");
			InsertItem(1, "F.VVD", "O");
			Style = 1;
			Code = "T";
		}
		break;
	/* 2014.04.25 by Chang Young Kim ( AA Young Du Lee ) 조회 조건 추가 (E) */

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

	switch (sheetID) {

	case "t1sheet1":
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
			Editable = false;
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 1, 100);

			var HeadTitle1 = "MVMT|Total";

			//컬럼 가변 처리를 위한 기준 데이터를 배열로 만든다.
			oldCntrTypeSize = sCntrTypeSize;
			var arrCntrTypeSize = oldCntrTypeSize.split(",");

			//컬럼 가변에 따라 해더타이틀 가변 처리
			for ( var i = 0; i < arrCntrTypeSize.length; i++) {
				if (sCntrTypeSize != "") {
					HeadTitle1 += "|" + arrCntrTypeSize[i];
				}
			}

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			CountPosition = 0;
			FrozenCols = 2;
			var rowCnt = 0;

			var MTYIO = 80;
			var MTYMVMT = 80;
			var Division = 60;
			var Total = 60;

			var sCount = "";
			var x = 1;
			for ( var j = 0; j < 1; j++) {
				cnt = 0;
				x = 1;
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(j, cnt++, dtData, MTYMVMT, daCenter, true, "division", false, "", dfNone);
				if (document.form.mtymvmt.value == "VL" || document.form.mtymvmt.value == "VD" || document.form.mtymvmt.value == 'MT') {
					InitDataProperty(j, cnt++, dtAutoSum, Total, daRight, false, "total", false, "", dfNullInteger);
				} else {
					InitDataProperty(j, cnt++, dtData, Total, daRight, false, "total", false, "", dfNullInteger);
				}

				for ( var i = 0; i < arrCntrTypeSize.length; i++) {
					if (arrCntrTypeSize.length > 1) {
						if (x < 10) {
							sCount = "count0" + x;
						} else {
							sCount = "count" + x;
						}
						if (document.form.mtymvmt.value == "VL" || document.form.mtymvmt.value == "VD" || document.form.mtymvmt.value == 'MT') {
							InitDataProperty(j, cnt++, dtAutoSum, 50, daRight, false, sCount, false, "", dfNullInteger);
						} else {
							InitDataProperty(j, cnt++, dtData, 50, daRight, false, sCount, false, "", dfNullInteger);
						}
						x++;
					}
				}
			}

		}
		break;

	case "t2sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 382;
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

			var HeadTitle1 = "|Seq.|C|CNTR No.|TP/SZ|MVMT|Yard|Former MVMT\nEvent DT|Latter MVMT\nEvent DT|A|Lane|T.VVD|F.VVD|Per VVD|Post VVD|BKG No.|SC/RFA/TAA No.|SHPR|CNEE|SP CODE|SP NAME|POR|POL|POD|DEL|DM|DP|IM|HR|HBQ|R|D|Lease Term";

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			CountPosition = 0;
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "Status");
			InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, true, "Seq");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "company", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cntrno", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "tpsz", false, "", dfNone);

			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "mvmt", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "yard", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "pre_eventdate", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "post_eventdate", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "autoflag", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "lane", false, "", dfNone);

			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "tvvd", false, "", dfNone);
			/* 2014.04.25 by Chang Young Kim ( AA Young Du Lee ) 조회 조건 추가 (S) */
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "fvvd", false, "", dfNone);
			
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "pre_vvd_cd", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "pst_vvd_cd", false, "", dfNone);

			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "bkgno", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "sc_rfa_no_taa", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 285, daLeft, true, "shpr", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 285, daLeft, true, "cnee", false, "", dfNone);
			
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vndr_seq", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "vndr_abbr_nm", false, "", dfNone);
			
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "por", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "pol", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "pod", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "del", false, "", dfNone);

			InitDataProperty(0, cnt++, dtCheckBox, 25, daCenter, true, "damage", false, "", dfNone);
			InitDataProperty(0, cnt++, dtCheckBox, 25, daCenter, true, "disposal", false, "", dfNone);
			InitDataProperty(0, cnt++, dtCheckBox, 25, daCenter, true, "imdtexit", false, "", dfNone);
			InitDataProperty(0, cnt++, dtCheckBox, 25, daCenter, true, "hngrrack", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData    , 30, daRight , true, "hngrbarknt", false,	"",	dfNone);
			//2011.11.21 신자영 [CHM-201114577-01] MVMT BY CY 기능 보완 (booking receive, delivery term code 추가)
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "rcvterm", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "determ", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "lstm_cd", false, "", dfNone);

//			InitUserFormat2(0, "eventdate", "####-##-## ##:##", "-|:");
//			InitUserFormat2(0, "eventdate2", "####-##-## ##:##", "-|:");

		}
		break;
	case "t3sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 300;
			//전체 너비 설정
			//SheetWidth = 600;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			if (document.form.mtymvmt.value != 'MT' && document.form.mtymvmt.value != 'VL' && document.form.mtymvmt.value != 'VD') {

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 20, 100);

				if (HeadTitle == null || HeadTitle == "") {
					HeadTitle = "TP/SZ|MVMT|Total";
					InitColumnInfo(3, 0, 0, true);
				}

				var headCnt = HeadTitle.split("|").length;
				SheetWidth = headCnt * 80;
				if (SheetWidth > 975) {
					SheetWidth = 975;
				}

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCnt, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				CountPosition = 0;
				FrozenCols = 3;
				var rowCnt = 0;

				var MTYIO = 80;
				var MTYMVMT = 80;
				var Division = 80;
				var Total = 80;
				var cnt = 0;

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(rowCnt, cnt++, dtData, MTYIO, daCenter, true, "inout", false, "", dfNone);
				InitDataProperty(rowCnt, cnt++, dtData, MTYMVMT, daCenter, true, "division", false, "", dfNone);

				if (document.form.mtymvmt.value == 'MT' || document.form.mtymvmt.value == 'VL' || document.form.mtymvmt.value == 'VD') {
					InitDataProperty(rowCnt, cnt++, dtAutoSum, Total, daRight, false, "total", false, "", dfNullInteger);
				} else {
					InitDataProperty(rowCnt, cnt++, dtAutoSum, Total, daRight, false, "total", false, "", dfNullInteger);
				}

				var x = 1;
				for ( var i = 1; i <= headCnt - 3; i++) {
					if (x < 10) {
						sCount = "count0" + x;
					} else {
						sCount = "count" + x;
					}

					if (document.form.mtymvmt.value == 'MT' || document.form.mtymvmt.value == 'VL' || document.form.mtymvmt.value == 'VD') {
						InitDataProperty(rowCnt, cnt++, dtAutoSum, 80, daRight, false, sCount, false, "", dfNullInteger);
					} else {
						InitDataProperty(rowCnt, cnt++, dtAutoSum, 80, daRight, false, sCount, false, "", dfNullInteger);
					}

					x++;
				}
			} else {
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				if (document.form.mtymvmt.value == 'MT') {            
					InitRowInfo(1, 5, 20, 100);
				}
				else{
					InitRowInfo(1, 3, 20, 100);
				}

				if (HeadTitle == null || HeadTitle == "") {
					HeadTitle = "TP/SZ|MVMT|Total";
					InitColumnInfo(3, 0, 0, true);
				}

				var headCnt = HeadTitle.split("|").length;
				SheetWidth = headCnt * 80;
				if (SheetWidth > 975) {
					SheetWidth = 975;
				}

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCnt, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				CountPosition = 0;
				FrozenCols = 3;
				var rowCnt = 0;

				var MTYIO = 80;
				var MTYMVMT = 80;
				var Division = 80;
				var Total = 80;
				var cnt = 0;

				rowCnt = 0;
				cnt = 0;
				InitDataProperty(rowCnt, cnt++, dtData, MTYIO, daCenterTop, true, "inout", false, "", dfNone);
				InitDataProperty(rowCnt, cnt++, dtData, MTYMVMT, daCenter, true, "division", false, "", dfNone);

				InitDataProperty(rowCnt, cnt++, dtAutoSum, Total, daRight, false, "total", false, "", dfNullInteger);

				var x = 1;
				for ( var i = 1; i <= headCnt - 3; i++) {
					if (x < 10) {
						sCount = "count0" + x;
					} else {
						sCount = "count" + x;
					}

					InitDataProperty(rowCnt, cnt++, dtAutoSum, 80, daRight, false, sCount, false, "", dfNullInteger);

					x++;
				}

				rowCnt = 1;
				cnt = 0;
				InitDataProperty(rowCnt, cnt++, dtData, MTYIO, daCenterTop, true, "inout", false, "", dfNone);
				InitDataProperty(rowCnt, cnt++, dtData, MTYMVMT, daCenter, true, "division", false, "", dfNone);

				InitDataProperty(rowCnt, cnt++, dtAutoSum, Total, daRight, false, "total", false, "", dfNullInteger);

				var x = 1;
				for ( var i = 1; i <= headCnt - 3; i++) {
					if (x < 10) {
						sCount = "count0" + x;
					} else {
						sCount = "count" + x;
					}

					InitDataProperty(rowCnt, cnt++, dtAutoSum, 80, daRight, false, sCount, false, "", dfNullInteger);

					x++;
				}

				rowCnt = 2;
				cnt = 0;
				InitDataProperty(rowCnt, cnt++, dtData, MTYIO, daCenterTop, true, "inout", false, "", dfNone);
				InitDataProperty(rowCnt, cnt++, dtData, MTYMVMT, daCenter, true, "division", false, "", dfNone);

				InitDataProperty(rowCnt, cnt++, dtAutoSum, Total, daRight, false, "total", false, "", dfNullInteger);

				var x = 1;
				for ( var i = 1; i <= headCnt - 3; i++) {
					if (x < 10) {
						sCount = "count0" + x;
					} else {
						sCount = "count" + x;
					}

					InitDataProperty(rowCnt, cnt++, dtAutoSum, 80, daRight, false, sCount, false, "", dfNullInteger);

					x++;
				}
				if (document.form.mtymvmt.value == 'MT') {
					rowCnt = 3;
					cnt = 0;
					InitDataProperty(rowCnt, cnt++, dtData, MTYIO, daCenterTop, true, "inout", false, "", dfNone);
					InitDataProperty(rowCnt, cnt++, dtData, MTYMVMT, daCenter, true, "division", false, "", dfNone);
	
					InitDataProperty(rowCnt, cnt++, dtAutoSum, Total, daRight, false, "total", false, "", dfNullInteger);
	
					var x = 1;
					for ( var i = 1; i <= headCnt - 3; i++) {
						if (x < 10) {
							sCount = "count0" + x;
						} else {
							sCount = "count" + x;
						}
	
						InitDataProperty(rowCnt, cnt++, dtAutoSum, 80, daRight, false, sCount, false, "", dfNullInteger);
	
						x++;
					}
	
					rowCnt = 4;
					cnt = 0;
					InitDataProperty(rowCnt, cnt++, dtData, MTYIO, daCenterTop, true, "inout", false, "", dfNone);
					InitDataProperty(rowCnt, cnt++, dtData, MTYMVMT, daCenter, true, "division", false, "", dfNone);
	
					InitDataProperty(rowCnt, cnt++, dtAutoSum, Total, daRight, false, "total", false, "", dfNullInteger);
	
					var x = 1;
					for ( var i = 1; i <= headCnt - 3; i++) {
						if (x < 10) {
							sCount = "count0" + x;
						} else {
							sCount = "count" + x;
						}
	
						InitDataProperty(rowCnt, cnt++, dtAutoSum, 80, daRight, false, sCount, false, "", dfNullInteger);
	
						x++;
					}
				}

			}

			CountPosition = 0;
			//	ExtendLastCol = false;
		}
		break;
	case "t4sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 382;
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
			InitRowInfo(2, 1, 10, 100);
			
			var formObj = document.form;

			var arrTpszList;	
			//타입사이즈 리스트를 가져온다. 
			if(formObj.radioTpsz[0].checked){
				arrTpszList = tpszList[0];
			} else if(formObj.radioTpsz[1].checked){
				arrTpszList = tpszList[1];
			} else if(formObj.radioTpsz[2].checked){
				arrTpszList = tpszList[2];
			} else {	
				arrTpszList = tpszList[3];	
			}	
			
			var HeadTitle1 = "WEEK|TOTAL";
			var HeadTitle2 = "WEEK|TOTAL";

			for ( var i = 0; i < arrTpszList.length; i++) {
				for ( var j = 0; j < 8; j++){
					HeadTitle1 += "|" + arrTpszList[i];
				}
				HeadTitle2 += "|Sun|Mon|Tue|Wed|Thu|Fri|Sat|S.TTL";
			}		
			
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			FrozenCols = 2;
			CountPosition = 0;
			var Wk = 60;
			var Total = 60;
			var WkDay = 50;
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(rowCnt, cnt++, dtData, Wk, daCenterTop, true, "wk", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtData, Total, daRight, true, "total", false, "", dfNullInteger);
			
			var arrCombo = comboObjects[1].Code.split(",");
			var bSun = false;	
			var bMon = false;	
			var bTue = false;
			var bWed = false;
			var bThu = false;
			var bFri = false;
			var bSat = false;
			var bAll = true;
			
			if(comboObjects[1].Code != "") {
				bAll = false;
				for ( var j = 0; j < arrCombo.length; j++) {
					
					if(arrCombo[j] == "SUN") {
						bSun = true;
					} 
					if(arrCombo[j] == "MON") {
						bMon = true;
					}
					if(arrCombo[j] == "TUE") {
						bTue = true;
					}
					if(arrCombo[j] == "WED") {
						bWed = true;
					}
					if(arrCombo[j] == "THU") {
						bThu = true;
					}
					if(arrCombo[j] == "FRI") {
						bFri = true;
					}
					if(arrCombo[j] == "SAT") {
						bSat = true;
					}
				}
			} 
			
			if(formObj.radioTpsz[0].checked) {
				for ( var i = 1; i < 5; i++) {
					
					var sSum1 = "";
					var sSum2 = "";
					var sSum3 = "";
					var sSum4 = "";
					var sSum5 = "";
					var sSum6 = "";
					var sSum7 = "";					

					if(bSun) {
						sSum1 = "sun0" + i;
					}
					if(bMon) {
						sSum2 = "mon0" + i;
					}
					if(bTue) {
						sSum3 = "tue0" + i;
					}
					if(bWed) {
						sSum4 = "wed0" + i;
					}
					if(bThu) {
						sSum5 = "thu0" + i;
					}
					if(bFri) {
						sSum6 = "fri0" + i;
					}
					if(bSat) {
						sSum7 = "sat0" + i;
					}
					if(bAll) {
						sSum1 = "sun0" + i;
						sSum2 = "mon0" + i;
						sSum3 = "tue0" + i;
						sSum4 = "wed0" + i;
						sSum5 = "thu0" + i;
						sSum6 = "fri0" + i;
						sSum7 = "sat0" + i;
					}
					
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum1, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum2, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum3, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum4, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum5, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum6, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum7, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, "count0" + i, false, "", dfNullInteger);
					
				}
				
			} else if(formObj.radioTpsz[1].checked) {   // 수정해야 할 라인
				for ( var i = 8; i < 13; i++){
					if (i < 10) {
						k = "0" + i;
					} else {
						k = "" + i;
					}
					
					var sSum1 = "";
					var sSum2 = "";
					var sSum3 = "";
					var sSum4 = "";
					var sSum5 = "";
					var sSum6 = "";
					var sSum7 = "";					

					if(bSun) {
						sSum1 = "sun" + k;
					}
					if(bMon) {
						sSum2 = "mon" + k;
					}
					if(bTue) {
						sSum3 = "tue" + k;
					}
					if(bWed) {
						sSum4 = "wed" + k;
					}
					if(bThu) {
						sSum5 = "thu" + k;
					}
					if(bFri) {
						sSum6 = "fri" + k;
					}
					if(bSat) {
						sSum7 = "sat" + k;
					}
					if(bAll) {
						sSum1 = "sun" + k;
						sSum2 = "mon" + k;
						sSum3 = "tue" + k;
						sSum4 = "wed" + k;
						sSum5 = "thu" + k;
						sSum6 = "fri" + k;
						sSum7 = "sat" + k;
					}
					
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum1, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum2, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum3, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum4, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum5, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum6, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum7, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, "count" + k, false, "", dfNullInteger);
					
				}
			} else if(formObj.radioTpsz[2].checked) {
				for ( var i = 12; i < 17; i++){
					
					var sSum1 = "";
					var sSum2 = "";
					var sSum3 = "";
					var sSum4 = "";
					var sSum5 = "";
					var sSum6 = "";
					var sSum7 = "";					

					if(bSun) {
						sSum1 = "sun" + i;
					}
					if(bMon) {
						sSum2 = "mon" + i;
					}
					if(bTue) {
						sSum3 = "tue" + i;
					}
					if(bWed) {
						sSum4 = "wed" + i;
					}
					if(bThu) {
						sSum5 = "thu" + i;
					}
					if(bFri) {
						sSum6 = "fri" + i;
					}
					if(bSat) {
						sSum7 = "sat" + i;
					}
					if(bAll) {
						sSum1 = "sun" + i;
						sSum2 = "mon" + i;
						sSum3 = "tue" + i;
						sSum4 = "wed" + i;
						sSum5 = "thu" + i;
						sSum6 = "fri" + i;
						sSum7 = "sat" + i;
					}
					
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum1, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum2, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum3, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum4, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum5, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum6, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum7, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, "count" + i, false, "", dfNullInteger);
					
				}
			} else {	
				for ( var i = 5; i < 8; i++) {
					
					var sSum1 = "";
					var sSum2 = "";
					var sSum3 = "";
					var sSum4 = "";
					var sSum5 = "";
					var sSum6 = "";
					var sSum7 = "";					

					if(bSun) {
						sSum1 = "sun0" + i;
					}
					if(bMon) {
						sSum2 = "mon0" + i;
					}
					if(bTue) {
						sSum3 = "tue0" + i;
					}
					if(bWed) {
						sSum4 = "wed0" + i;
					}
					if(bThu) {
						sSum5 = "thu0" + i;
					}
					if(bFri) {
						sSum6 = "fri0" + i;
					}
					if(bSat) {
						sSum7 = "sat0" + i;
					}
					if(bAll) {
						sSum1 = "sun0" + i;
						sSum2 = "mon0" + i;
						sSum3 = "tue0" + i;
						sSum4 = "wed0" + i;
						sSum5 = "thu0" + i;
						sSum6 = "fri0" + i;
						sSum7 = "sat0" + i;
					}
					
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum1, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum2, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum3, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum4, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum5, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum6, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, sSum7, false, "", dfNullInteger);
					InitDataProperty(rowCnt, cnt++, dtData, WkDay, daRight, false, "count0" + i, false, "", dfNullInteger);
					
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
			sheetObj.Reset();
			initSheet(sheetObj);

			formObj.f_cmd.value = COMMAND01;
			sheetObj.WaitImageVisible = false;
			sheetObj.Redraw = false;
//			prompt("1", FormQueryString(formObj)); return;
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("EES_CIM_1051GS.do", FormQueryString(formObj));
			var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
			
			if (backendJobKey.length > 0) {
				ComSetObjValue(formObj.backendjob_key, backendJobKey);
				sheetObj.RequestTimeOut = 10000;
				timer1 = setInterval(getBackEndJobStatus, 1000);
			}
		} else {
			return;
		}
		break;
	case IBSEARCH_ASYNC01: //open 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH03;

			var sXml = formObj.sXml.value;

			//	sheetObj.LoadSearchXml(sXml);
			var sTpsz = ComGetEtcData(sXml, "cntr_tpsz_cd");
			tot_cntr_tpsz_cd = sTpsz;
			if (sTpsz != undefined) {
				var arrTpsz = sTpsz.split("|");

				MakeCmbObj(formObj.tpsz, arrTpsz);
			}

			sCntrTypeSize = ComGetEtcData(sXml, "cntrTypeSize");
			
			//Lease Term
            var sLeaseTermNm = ComGetEtcData(sXml,"lease_term_nm");
            var sLeaseTermCd = ComGetEtcData(sXml,"lease_term_cd");
               
            var arrLeaseTermNm = sLeaseTermNm.split("|");
            var arrLeaseTermCd = sLeaseTermCd.split("|");
            tot_lstm_cd = arrLeaseTermCd;
               
            with (form.lstmcd) {
           	 MultiSelect = true;
                MultiSeparator = ",";
                DropHeight = 320;
           	 InsertItem(0 , 'ALL','');
           	 for ( var i=1; i<=arrLeaseTermCd.length; i++) {
   	        	 InsertItem(i, arrLeaseTermCd[i-1], arrLeaseTermNm[i-1]);
           	 }
            }     

			//서버에서 가져온 "가변컬럼정보"만 읽어오기
			if ((oldCntrTypeSize != sCntrTypeSize) && (sheetObj.id == "t1sheet1")) {
				oldCntrTypeSize = sCntrTypeSize;
				sheetObj.Reset();
				initSheet(sheetObj);
				document.form.froms.focus();
			}
			
			var dayList = ComGetEtcData(sXml, "dayList");
			tot_dayList = dayList;
			if (dayList != undefined) {
				var arrDayList = dayList.split(",");

				MakeCmbObj(formObj.day, arrDayList);
			}

		}
		break;

	case IBSEARCH_ASYNC03: //location focusOut
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH02;
			imsi++;
			if (formObj.location.value == "") {
				return true;
			}
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_1001GS.do", FormQueryString(formObj));
			var sCheck = ComGetEtcData(sXml, "check");
			if (sCheck != "OK") {
				var inquiryLevel = document.getElementById("inquiryLevel").value;
				if (document.form.location.value != "") {
					if (inquiryLevel == "L") {
						formObj.location.value = "";
						ComShowCodeMessage("CIM29018");
						ComSetFocus(document.form.location);
						sheetObj.WaitImageVisible = true;

						return false;

					} else if (inquiryLevel == "E") {
						formObj.location.value = "";
						ComShowCodeMessage("CIM29019");
						ComSetFocus(document.form.location);
						sheetObj.WaitImageVisible = true;
						return false;
					} else if (inquiryLevel == "S") {
						formObj.location.value = "";
						ComShowCodeMessage("CIM29020");
						sheetObj.WaitImageVisible = true;
						ComSetFocus(document.form.location);
						return false;
					} else if (inquiryLevel == "Y") {
						formObj.location.value = "";
						ComShowCodeMessage("CIM29021");
						sheetObj.WaitImageVisible = true;
						ComSetFocus(document.form.location);
						return false;
					} else if (inquiryLevel == "R") {
						formObj.location.value = "";
						ComShowCodeMessage("CIM29008");
						sheetObj.WaitImageVisible = true;
						ComSetFocus(document.form.location);
						return false;
					}
				} else {
					return true;
				}
				
			}
			ComSetFocus(document.form.soc);
		} else {
			return;
		}
		sheetObj.WaitImageVisible = true;
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet2(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회

		isOpen = true;
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = COMMAND04;
			sheetObj.WaitImageVisible = false;
			sheetObj.Redraw = false;
			ComOpenWait(true);

			var sXml = sheetObj.GetSearchXml("EES_CIM_1051GS.do", FormQueryString(formObj));
			var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");

			if (backendJobKey.length > 0) {
				ComSetObjValue(formObj.backendjob_key, backendJobKey);
				sheetObj.RequestTimeOut = 10000;
				timer1 = setInterval(getBackEndJobStatus, 1000);
			}
		} else {
			return;
		}
		break;
	}
}

function doActionIBSheet3(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회

		isOpen = true;
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = COMMAND05;
			sheetObj.WaitImageVisible = false;
			sheetObj.Reset();
			initSheet(sheetObj);
			//			sheetObj.Redraw = false;
			ComOpenWait(true);
			formObj.gubun.value = "T";
			var sXml = sheetObj.GetSearchXml("EES_CIM_1051GS.do", FormQueryString(formObj));
			var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");

			if (backendJobKey.length > 0) {
				ComSetObjValue(formObj.backendjob_key, backendJobKey);
				ComSetObjValue(formObj.gubun, "T");
				sheetObj.RequestTimeOut = 10000;
				timer1 = setInterval(getBackEndJobStatus, 3000);
			}

		} else {
			return;
		}
		break;
	}
}

function doActionIBSheet4(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회

		isOpen = true;
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = COMMAND06;
			sheetObj.WaitImageVisible = false;
			sheetObj.Reset();
			initSheet(sheetObj);
			//			sheetObj.Redraw = false;
			ComOpenWait(true);
			formObj.gubun.value = "DT";
			var sXml = sheetObj.GetSearchXml("EES_CIM_1051GS.do", FormQueryString(formObj));
			var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");

			if (backendJobKey.length > 0) {
				ComSetObjValue(formObj.backendjob_key, backendJobKey);
				ComSetObjValue(formObj.gubun, "DT");
				sheetObj.RequestTimeOut = 10000;
				timer1 = setInterval(getBackEndJobStatus, 1000);
			}

		} else {
			return;
		}
		break;
	}
}
/**
 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
 */
function getBackEndJobStatus() {
	var formObj = document.form;
	var sheetObj = "";
	var obj = document.form.gubun;
	if (obj.value == "S") {
		sheetObj = sheetObjects[0];
	} else if (obj.value == "D") {
		sheetObj = sheetObjects[1];
	} else if (obj.value == "T") {
		sheetObj = sheetObjects[2];
	} else if (obj.value == "DT") {
		sheetObj = sheetObjects[3];
	}

	formObj.f_cmd.value = COMMAND02;
	var sXml = sheetObj.GetSearchXml("EES_CIM_1051GS.do", FormQueryString(formObj));
	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
//	alert("jobState : " + jobState);
	if (jobState == "3") {
		getBackEndJobLoadFile();
		clearInterval(timer1);
	} else if (jobState == "4") {
		ComShowCodeMessage("CIM29042");
		ComOpenWait(false);
		sheetObj.WaitImageVisible = true;
		clearInterval(timer1);
	} else if (jobState == "5") {
		ComShowCodeMessage("CIM29043");
		clearInterval(timer1);
	}
}

/**
 * BackEndJob의 결과가 완료되면 Excel파일로 내려받음
 */
function getBackEndJobLoadFile() {
	var formObj = document.form;
	var sheetObj = "";
	var obj = document.form.gubun;
	if (obj.value == "S") {
		sheetObj = sheetObjects[0];
	} else if (obj.value == "D") {
		sheetObj = sheetObjects[1];
	} else if (obj.value == "T") {
		sheetObj = sheetObjects[2];
	} else if (obj.value == "DT") {
		sheetObj = sheetObjects[3];
	}
	
	formObj.f_cmd.value = COMMAND03;
	var sXml = "";
	if (obj.value == "T") {
		sXml = sheetObj.GetSearchXml("EES_CIM_10512GS.do", FormQueryString(form));
		var sPeriod = ComGetEtcData(sXml, "head");
//		prompt("1", sXml);
		var HeadTitle = "TP/SZ|MVMT|Total|" + sPeriod;
		sheetObj.Redraw = false;
//		sheetObj.RemoveAll();
		sheetObj.Reset();
		initSheet(sheetObj, 1, HeadTitle);
		sheetObj.Redraw = true;
	} else {
		sXml = sheetObj.GetSearchXml("EES_CIM_1051GS.do", FormQueryString(form));
//		prompt("1", sXml);

	}
	sheetObj.LoadSearchXml(sXml);
	sheetObj.SelectRow = 0;
	sheetObj.WaitImageVisible = true;
	ComOpenWait(false);
}

/**
 * ibMultiCombo 값 채우기.
 * @param cmbObj
 * @param arrStr
 * @return
 */
function MakeCmbObj(cmbObj, arrStr) {
	cmbObj.InsertItem(0, 'ALL', '');
	for ( var i = 1; i <= arrStr.length; i++) {
		cmbObj.InsertItem(i, arrStr[i - 1], arrStr[i - 1]);
	}
}

/**
 * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
 * @param {sheetObj} String : 해당 IBSheet셀 명
 * @param {Row} Long : 해당 셀의 Row Index
 * @param {Col} Long : 해당 셀의 Column Index
 * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 * @param {CellX} Long : 해당셀의 X좌표
 * @param {CellY} Long : 해당셀의 Y좌표
 * @param {CellW} Long : 해당셀의 가로 넓이값
 * @param {CellH} Long : 해당셀의 세로 높이값
 */
function t2sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// 클릭한 row의 "cntrno"컬럼 값이 있으면
		if (ComGetLenByByte(Cellvalue(Row, "cntrno")) > 0) {
			// btn_t2EachCNTR 버튼 Enable
			ComBtnEnable("btn_t2EachCNTR");
		} else {
			// btn_t2EachCNTR 버튼 Disable
			ComBtnDisable("btn_t2EachCNTR");
		}
		// 클릭한 row의 "bkgno"컬럼 값이 있으면
		if (ComGetLenByByte(Cellvalue(Row, "bkgno")) > 0) {
			// btn_t2EachCNTR 버튼 Enable
			ComBtnEnable("btn_t2EachBKG");
		} else {
			// btn_t2EachCNTR 버튼 Disable
			ComBtnDisable("btn_t2EachBKG");
		}

	}
}

/**
 * IBSeet내의 데이터 영역의 셀을 더블클릭했을 때 발생하는 Event<br>
 * @param {sheetObj} String : 해당 IBSheet셀 명
 * @param {Row} Long : 해당 셀의 Row Index
 * @param {Col} Long : 해당 셀의 Column Index
 * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 * @param {CellX} Long : 해당셀의 X좌표
 * @param {CellY} Long : 해당셀의 Y좌표
 * @param {CellW} Long : 해당셀의 가로 넓이값
 * @param {CellH} Long : 해당셀의 세로 높이값
 */
function t2sheet1_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// 더블클릭한 row의 "cntrno"컬럼 값이 있으면
		if (ComGetLenByByte(Cellvalue(Row, "cntrno")) > 0) {
			if (SelectCol == 3) {
				var sUrl = "/hanjin/EES_CTM_0408.do?" + "p_cntrno=" + Cellvalue(Row, "cntrno").substring(0, 10) + "&check_digit="
						+ Cellvalue(Row, "cntrno").substring(10, 11) + "&ctnr_tpsz_cd=" + Cellvalue(Row, "tpsz") + "&cnmv_evnt_dt="
						+ Cellvalue(Row, "pre_eventdate").substring(0, 8);
				
				ComOpenPopupWithTarget(sUrl, 1020, 682, "", "0,0", true, "yes");
			}
		}
		// 더블클릭한 row의 "bkgno"컬럼 값이 있으면
		if (ComGetLenByByte(Cellvalue(Row, "bkgno")) > 0) {
			if (SelectCol == 11) {
				var sUrl = "/hanjin/EES_CTM_0409.do?" + "bkg_no=" + Cellvalue(Row, "bkgno");
				
				ComOpenPopupWithTarget(sUrl, 1020, 682, "", "0,1", true, "yes");
		
			}
		}
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
			InsertTab(cnt++, "   Trend    ", -1);
			InsertTab(cnt++, "   Daily Trend    ", -1);
			//TabLayout = 2;
		}
		break;

	}
}

/**
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		Redraw = true;
		AutoSumBottom = false;
		SumText(0, 0) = "";
		CellAlign(1, "division") = daCenter;
		if (document.form.mtymvmt.value == "MT") {
			SumText(0, 0) = "MT";
		}
		else if(document.form.mtymvmt.value == "VL") {
			SumText(0, 0) = "VL(Full)";
		}
		else if(document.form.mtymvmt.value == "VD") {
			SumText(0, 0) = "VD(Full)";
		}
		
		SumBackColor = RgbColor(255, 255, 255);
		SumFontBold = false;

		if (document.form.mtymvmt.value == "MT" || document.form.mtymvmt.value == "VL" || document.form.mtymvmt.value == "VD") {
			var arrTime = sCntrTypeSize.split(",");
			for ( var i = 2; i < arrTime.length + 2; i++) {
				if (comboObjects[0].Code.indexOf(arrTime[i - 2]) == -1 && comboObjects[0].Code != "") {
					SumText(0, i) = "";
				}
			}
		}
	}
}

/**
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
	Redraw = true;
	}
}

/**
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		Redraw = true;
		//		AutoSumBottom = false;
		SumText(0, 0) = "Total";
		//SumText(0, 1) = CellValue(RowCount, "division");
		if (document.form.mtymvmt.value == "MT") {
			CellAlign(LastRow, "division") = daCenter;
			CellAlign(LastRow - 1, "division") = daCenter;
			CellAlign(LastRow - 2, "division") = daCenter;
			CellAlign(LastRow - 3, "division") = daCenter;
			CellAlign(LastRow - 4, "division") = daCenter;
			SumText(0, 1) = "MT";
			SumText(1, 1) = "MG";
			SumText(2, 1) = "MP";
			SumText(3, 1) = "MR";
			SumText(4, 1) = "VD-MT";

		}
		else if(document.form.mtymvmt.value == "VL"){
			CellAlign(LastRow, "division") = daCenter;
			CellAlign(LastRow - 1, "division") = daCenter;
			CellAlign(LastRow - 2, "division") = daCenter;
			SumText(0, 1) = "VL(Full)";
			SumText(1, 1) = "OC-VL";
			SumText(2, 1) = "TS-VL";
		}
		else if(document.form.mtymvmt.value == "VD"){
			CellAlign(LastRow, "division") = daCenter;
			CellAlign(LastRow - 1, "division") = daCenter;
			CellAlign(LastRow - 2, "division") = daCenter;
			SumText(0, 1) = "VD(Full)";
			SumText(1, 1) = "VD-IC";
			SumText(2, 1) = "VD-TS";
		}
		else {
			ColHidden(1) = true;
		}
		//CellAlign(1, "division") = daCenter;

		//		SumBackColor = RgbColor(255, 255, 255);
		//		SumFontBold = false;
		/*
		 if (document.form.mtymvmt.value == "") {
		 var arrTime = sPeriod.split("|");
		 for ( var i = 2; i < arrTime.length + 3; i++) {
		 if (CellValue(RowCount, 0) == "MTY Out") {
		 SumValue(0, i) = parseInt(SumValue(0, i))
		 - (parseInt(CellValue(RowCount, i)) + parseInt(CellValue(
		 RowCount + 1, i)));
		 }
		 }
		 }
		 */
	}
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 * 
 * @param {TabObject} tabObj
 * @param {integer} nItem
 *  case 0 => Summary
 *  case 1 => Detail
 *  case 2 => Trend
 *  case 3 => Daily Trend
 */
function tab1_OnChange(tabObj, nItem) {
	
	var objs = document.all.item("tabLayer");
	
	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";
	
	var objs2 = document.all.item("comboLayer1");
	var objs3 = document.all.item("radioLayer");
	var objs4 = document.all.item("comboLayer2");
	var objs5 = document.all.item("comboName1");
	var objs6 = document.all.item("comboName2");
	var objs7 = document.all.item("comboName3");
	/* 2014.04.25 by Chang Young Kim ( AA Young Du Lee ) 조회 조건 추가 (S) */
	var objs8 = document.all.item("comboLayer1_1");
	/* 2014.04.25 by Chang Young Kim ( AA Young Du Lee ) 조회 조건 추가 (E) */
	
	if (nItem ==3){ // Daily Trend
		objs2.style.display = "none";
		objs3.style.display = "Inline";
		objs4.style.display = "Inline";
		objs5.style.display = "none";
		objs6.style.display = "Inline";
		objs7.style.display = "Inline";
		/* 2014.04.25 by Chang Young Kim ( AA Young Du Lee ) 조회 조건 추가 (S) */
		objs8.style.display = "none";
		/* 2014.04.25 by Chang Young Kim ( AA Young Du Lee ) 조회 조건 추가 (E) */
	} else {
		objs2.style.display = "Inline";
		objs3.style.display = "none";
		objs4.style.display = "none";
		objs5.style.display = "Inline";
		objs6.style.display = "none";
		objs7.style.display = "none";
		/* 2014.04.25 by Chang Young Kim ( AA Young Du Lee ) 조회 조건 추가 (S) */
		objs8.style.display = "Inline";
		/* 2014.04.25 by Chang Young Kim ( AA Young Du Lee ) 조회 조건 추가 (E) */
	}
	
	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	//------------------------------------------------------//
	beforetab = nItem;
	tabIndex = nItem;
	if (nItem == 0) {
		ComSetObjValue(document.form.gubun, "S");
		var preinquiryLevel = document.form.inquiryLevel.value;
		init_inquiryLevel();
		document.form.inquiryLevel.value = preinquiryLevel;
	} else if (nItem == 1) {
		ComSetObjValue(document.form.gubun, "D");
		var preinquiryLevel = document.form.inquiryLevel.value;
		init_inquiryLevel();
		document.form.inquiryLevel.value = preinquiryLevel;

	} else if (nItem == 2) {
		ComSetObjValue(document.form.gubun, "T");
		var preinquiryLevel = document.form.inquiryLevel.value;
		init_inquiryLevel();
		document.form.inquiryLevel.value = preinquiryLevel;
	}
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
			ComSetObjValue(document.form.gubun, "S");
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			//			sheetObjects[1].RemoveAll();
			//			sheetObjects[2].RemoveAll();
			var preinquiryLevel = document.form.inquiryLevel.value;
			init_inquiryLevel();
			sheetObjects[0].SelectRow = 0;
			document.form.inquiryLevel.value = preinquiryLevel;
		} else if (nItem == 1) {
			ComSetObjValue(document.form.gubun, "D");
			doActionIBSheet2(sheetObjects[1], document.form, IBSEARCH);
			var preinquiryLevel = document.form.inquiryLevel.value;
			init_inquiryLevel();
			document.form.inquiryLevel.value = preinquiryLevel;
			sheetObjects[1].SelectRow = 0;
		} else if (nItem == 2) {
			ComSetObjValue(document.form.gubun, "T");
			doActionIBSheet3(sheetObjects[2], document.form, IBSEARCH);
			var preinquiryLevel = document.form.inquiryLevel.value;
			init_inquiryLevel();
			document.form.inquiryLevel.value = preinquiryLevel;
		} 
	}

}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {

	with (formObj) {
		switch (sAction) {
		case IBSEARCH: //조회
			if (period.value == "M") {
				if (froms.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(froms);
					return false;
				}
				if (tos.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(tos);
					return false;
				}
				if (froms.value.length < 6) {
					return false;
				} else if (tos.value.length < 6) {
					return false;
				}

			} else if (period.value == "W") {
				if (froms.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(froms);
					return false;
				}
				if (tos.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(tos);
					return false;
				}
				if (froms.value.length < 6) {
					return false;
				} else if (tos.value.length < 6) {
					return false;
				}

			} else if (period.value == "D") {
				if (froms.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(froms);
					return false;
				}
				if (tos.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(tos);
					return false;
				}
				if (froms.value.length < 8) {
					return false;
				} else if (tos.value.length < 8) {
					return false;
				}

			}

			if (!enterSwitch) {
				return false;
			}

			if (location.value == "") {
				ComShowCodeMessage("CIM21001", "Location ");
				ComSetFocus(location);
				return false;
				
				/*
				if (inquiryLevel.value == "L") {
					ComShowCodeMessage("CIM29014");
					ComSetFocus(location);
					return false; 
				} else if (inquiryLevel.value == "E") {
					ComShowCodeMessage("CIM29015");
					ComSetFocus(location);
					return false;
				} else if (inquiryLevel.value == "S") {
					ComShowCodeMessage("CIM29016");
					ComSetFocus(location);
					return false;
				} else if (inquiryLevel.value == "Y") {
					ComShowCodeMessage("CIM29017");
					ComSetFocus(location);
					return false;
				}
				*/
			}
			break;
		}
	}

	return true;
}


function init_inquiryLevel(){
	// 2011.06.01 신자영 [CHM-201111319-01] 기존에는 RCC의 경우 detail이 열리지 않도록 막았으나 RCC를 선택하고 VL(MT)를 move조건으로 넣으면 조회 가능하도록 함
	if(document.form.gubun.value == "S" || document.form.gubun.value == "DT"){
		ComClearCombo(document.form.inquiryLevel);
		ComAddComboItem(document.form.inquiryLevel,"RCC","R");
		ComAddComboItem(document.form.inquiryLevel,"LCC","L");
		ComAddComboItem(document.form.inquiryLevel,"ECC","E");
		ComAddComboItem(document.form.inquiryLevel,"SCC","S");
		ComAddComboItem(document.form.inquiryLevel,"Yard","Y");
		if(document.form.inquiryLevel.value == "R"){
			document.form.location.value = "";
		}
	}else if((document.form.mtymvmt.value == "VLMTMT-VL")&&(document.form.gubun.value == "D")){
		var inquiryLevelName = document.form.inquiryLevel.value;
		
		ComClearCombo(document.form.inquiryLevel);
		ComAddComboItem(document.form.inquiryLevel,"RCC","R");
		ComAddComboItem(document.form.inquiryLevel,"LCC","L");
		ComAddComboItem(document.form.inquiryLevel,"ECC","E");
		ComAddComboItem(document.form.inquiryLevel,"SCC","S");
		ComAddComboItem(document.form.inquiryLevel,"Yard","Y");
		
		/* if(document.form.inquiryLevel.value == "R"){
			document.form.location.value = "";
		}*/
		
		document.form.inquiryLevel.value = inquiryLevelName;
	}else{
		if(document.form.inquiryLevel.value == "R"){
			document.form.location.value = "";
		}
		
		var inquiryLevelName = document.form.inquiryLevel.value;
		
		ComClearCombo(document.form.inquiryLevel);
		ComAddComboItem(document.form.inquiryLevel,"LCC","L");
		ComAddComboItem(document.form.inquiryLevel,"ECC","E");
		ComAddComboItem(document.form.inquiryLevel,"SCC","S");
		ComAddComboItem(document.form.inquiryLevel,"Yard","Y");
		
		document.form.inquiryLevel.value = inquiryLevelName;
	}
	
    /**
     * Lease Term  클릭 이벤트 등록
     */
    function lstmcd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk = comboObj.CheckIndex(index);
    		if(bChk){
    			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    				comboObj.CheckIndex(i) = false;
    			}
    		}
    	} else {
    		comboObj.CheckIndex(0) = false;
    	}
    } 
}

/* 개발자 작업  끝 */
