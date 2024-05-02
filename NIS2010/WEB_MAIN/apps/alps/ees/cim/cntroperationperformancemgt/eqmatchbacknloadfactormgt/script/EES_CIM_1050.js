/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_cim_1050.js
 *@FileTitle : Match-back by Vessel
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.01
 *@LastModifier : 문중철
 *@LastVersion : 1.0
 * 2009.07.01 문중철
 * 1.0 Creation
 * -------------------------------------------------------------------
 * History
 * 2010.09.15 이병훈 [CHM-201005967-01] Match-Back by Vessel의 신규 Trade 및 노선 추가
 * 2012.05.14 신자영 [CHM-201217818-01] L/F by Trade & Match-back by Vessel 모듈 검색 가능 기간 확장                                                           조회완료후 결과건수가 없을때 에러뜨는 문제 수정
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
 * @class ees_cim_1050 : ees_cim_1050 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cim_1050() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업   */

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var comboObjects = new Array();
var comboCnt = 0;

var sheetObjects = new Array();
var sheetCnt = 0;

var IBSEARCH02 = 30;

var enterSwitch = false;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			sheetObjects[0].SelectRow = 0;
			break;

		case "btn_new":
			sheetObject1.RemoveAll();
			formObject.reset();
			comboObjects[0].Code2 = "";
			comboObjects[1].RemoveAll();
			comboObjects[2].RemoveAll();
			comboObjects[2].Enable = false;
			ComSetFocus(formObject.fromdate);
			break;

		case "btn_downexcel":
			sheetObject1.Down2Excel(-1, false, false, true);
			break;

		case "btns_calendarfm":

			var cal = new ComCalendarFromTo();
			cal.select(formObject.fromdate, formObject.todate, 'yyyy-MM-dd');

			break;
		case "btns_calendarto":

			var cal = new ComCalendarFromTo();
			cal.setEndFunction("nextFocusOut");
			cal.select(formObject.fromdate, formObject.todate, 'yyyy-MM-dd');

			break;

		case "btn_lane": //lane 조회 팝업
			var param = "?lane_cd=" + formObject.lane.value;
			ComOpenPopup("/hanjin/COM_ENS_081.do", 755, 450, "popupFinish", "1,0,1,1,1,1,1,1", true);
			break;
		case "btn_vvd": //vvd 조회 팝업
			var param = "?vvd_cd=" + formObject.vvd.value;
			ComOpenPopup("/hanjin/COM_ENS_0B2.do", 755, 450, "popupFinish", "1,0,1,1,1,1,1,1", true);
			break;

		case "btn_Print":
			if (sheetObjects[0].rowcount == 0) {
				errMsg = 'No data found.';
				ComShowMessage(msgs["CIM29030"]);
				return;
			}
			formObject.f_cmd.value = IBSEARCH02;
			ComOpenPopupWithTarget('/hanjin/EES_CIM_1950.do', 775, 750, "", "0,1,1,1,1,1,1", true);
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
	document.form.trade.focus();
}

/**
 * lane code 팝업에서 선택한 값 Setting.
 */
function popupFinish(aryPopupData, row, col, sheetIdx) {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	formObject.lane.value = aryPopupData[0][3]
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

		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);

		ComEndConfigSheet(sheetObjects[i]);
	}

	//IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}

	initControl();
	comboObjects[1].DisabledBackColor = "#FFFFFF";
	//comboObjects[1].Enable = false;
	comboObjects[2].DisabledBackColor = "#FFFFFF";
	comboObjects[2].Enable = false;

	document.form.fromdate.focus();
}

function initCombo(comboObj, comboNo) {

	switch (comboObj.id) {

	case "trade":
		with (comboObj) {
			SetColAlign("center|left");
			SetColWidth("50|170");
			SetTitle("Trade|Description");
			MultiSelect = false;
			UseAutoComplete = true;
			DropHeight = 200;
			ValidChar(2, 0);
			MaxLength = 3;
		}
		comboObjects[0].InsertItem(0, "|ALL", ""); // AL
		comboObjects[0].InsertItem(1, "M|FROM AMERICA", "IMS"); // MM
		comboObjects[0].InsertItem(2, "E|FROM EUROPE", "IES"); // EE
		comboObjects[0].InsertItem(3, "TPS|TRANS AMERICA SERVICE", "TPS"); // TP
		comboObjects[0].InsertItem(4, "AES|ASIA-EUROPE SERVICE", "AES"); // TE
		comboObjects[0].InsertItem(5, "TAS|TRANS ATLANTIC SERVICE", "TAS"); // TA
		comboObjects[0].InsertItem(6, "EMS|EMERGING MARKET SERVICE", "EMS"); // TA
		comboObjects[0].Code2 = "";
		break;

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
		//                comboObj.InsertItem( 0 , "|ALL" , "" );
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
	cmbObj.RemoveAll();
	for ( var i = 0; i < arrStr.length; i++) {
		cmbObj.InsertItem(i, arrStr[i], arrStr[i]);
	}
}

function MakeComboObject2(cmbObj, arrStr) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "|ALL", "");
	for ( var i = 0; i < arrStr.length; i++) {
		cmbObj.InsertItem(i + 1, arrStr[i], arrStr[i].substring(0, 3));
	}
}

function MakeComboObject3(cmbObj, arrStr) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "|ALL", "");
	for ( var i = 0; i < arrStr.length; i++) {
		var arrVal = arrStr[i].split("|");
		cmbObj.InsertItem(i + 1, arrVal[0] + "|" + arrVal[1], arrVal[0]);
	}
}

/**
 * 
 * @return
 */
function pol_OnFocus() {

	comboObjects[2].Enable = true;

}

/**
 * 
 * @return
 */
function trade_OnFocus() {
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
function trade_OnBlur(KeyCode, Shift) {
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
			ComShowCodeMessage("CIM29028");
			comboObjects[0].Text = "";
			comboObjects[1].RemoveAll();
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

	if (comboObjects[1].GetCount() <= 0) {
		comboObj.Enable = false;
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
		if (comboObjects[1].GetCount() > 0) {
			comboObj.Enable = true;
			comboObjects[1].focus();
		}

	}
}

/**
 * 
 * @param comboObj
 * @return
 */
function vvd_OnFocus(comboObj) {

	var f = document.form;
	flag = false;
	if (f.fromdate.value == "") {
		if (f.period.value == "M") {
			ComShowCodeMessage("CIM21001", "Period");
		} else {
			ComShowCodeMessage("CIM21001", "Period");
		}
		ComSetFocus(f.fromdate);
		return false;
	} else if (f.todate.value == "") {
		if (f.period.value == "M") {
			ComShowCodeMessage("CIM21001", "Period");
		} else {
			ComShowCodeMessage("CIM21001", "Period");

		}
		ComSetFocus(f.todate);
		return false;
	}
	if (comboObjects[2].GetCount() <= 0) {
		comboObj.Enable = false;
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC05);
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

/**
 * 초기 로드시 스크립트 등록 함수.
 * @return
 */
function initControl() {
	axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
	axon_event.addListener('click', 'colHiddenfunc', 'lfinfo');
	axon_event.addListenerForm('change', 'obj_change', document.form);
	axon_event.addListenerFormat('focus', 'obj_activate', document.form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerForm('blur', 'obj_deactivate', document.form); //- form OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerFormat('keyup', 'form_keyup', document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListener('focus', 'polnextfocus', 'polnext');
	axon_event.addListener('focus', 'lanenextfocus', 'lanenext');
	axon_event.addListener('focus', 'prepolnextfocus', 'prepolnext');
	colHiddenfunc();
	document.form.fromdate.focus();
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
			style.height = 425;
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
			InitRowInfo(2, 2, 3, 100);

			var HeadTitle1 = "Seq|Com|Trade|Lane|I/O|Region|VVD|Last Port|ATD|Week|Full (Box)|Full (Box)|Full (Box)|Full (Box)|Full (Box)|MTY (Box)|MTY (Box)|MTY (Box)|MTY (Box)|MTY (Box)|Box\nTotal|TEU\nTotal|TEU M/Back|TEU M/Back|EQ M/Back(Box)|EQ M/Back(Box)|EQ M/Back(Box)|EQ M/Back(Box)|EQ M/Back(Box)|Dead\nSlot(T)|Weight\nTotal|Released|Released|BSA|BSA|Unused|Unused|Load Factor|Load Factor|Load Factor|Data\nSource";
			var HeadTitle2 = "Seq|Com|Trade|Lane|I/O|Region|VVD|Last Port|ATD|Week|20'|40'|H/C|45'|Total|20'|40'|H/C|45'|Total|Box\nTotal|TEU\nTotal|Full|EQ|20'|40'|H/C|45'|Total|Dead\nSlot(T)|Weight\nTotal|TEU|Weight|Space|Weight|Space|Weight|Full(%)|EQ(%)|WGT(%)|Data\nSource";

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			sheetObj.FrozenCols = 7;

			var unusedSpace = "|bsaspace| - ( |teu_total| + |deadslot| ) + |releasedteu|";
			var unusedWeight = "( |bsaweight| - |weighttotal| ) + |releasedweight|";

			var cBoxTotal = "|full_total| + |mty_total|";
			var cTEUTotal = "( |full_20| + ( 2 * ( |full_40| + |full_hc| + |full_45| ) ) ) + ( |mty_20| + ( 2 * ( |mty_40| + |mty_hc| + |mty_45| ) ) )";

			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "seq", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "com", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 45, daCenterTop, true, "trade", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "lane", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "io", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "region", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "vvd", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "lastport", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "atd", false, "", dfDateYmd, 1);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "week", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "full_20", false, "", dfNullInteger, 1);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "full_40", false, "", dfNullInteger, 1);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "full_hc", false, "", dfNullInteger, 1);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "full_45", false, "", dfNullInteger, 1);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "full_total", false, "", dfNullInteger, 1);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "mty_20", false, "", dfNullInteger, 1);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "mty_40", false, "", dfNullInteger, 1);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "mty_hc", false, "", dfNullInteger, 1);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "mty_45", false, "", dfNullInteger, 1);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "mty_total", false, "", dfNullInteger, 1);
			InitDataProperty(0, cnt++, dtAutoSum, 60, daRight, true, "box_total", false, cBoxTotal, dfNullInteger, 1);
			InitDataProperty(0, cnt++, dtAutoSum, 60, daRight, true, "teu_total", false, cTEUTotal, dfNullInteger, 1);
			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "teu_full", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "teu_eq", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "eq_20", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "eq_40", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "eq_hc", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "eq_45", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "eq_total", false, "", dfNone, 1);

			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "deadslot", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "weighttotal", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "releasedteu", false, "", dfNullInteger, 0);

			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "releasedweight", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "bsaspace", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "bsaweight", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "U_Space", false, unusedSpace, dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "U_Weight", false, unusedWeight, dfNullInteger, 0);

			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "lffull", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "lfeq", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "lfwgt", false, "", dfNone, 1);

			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "datasource", false, "", dfNone, 1);

			cnt = 0;

			InitDataProperty(1, cnt++, dtData, 30, daCenterTop, true, "seq", false, "", dfNone, 1);
			InitDataProperty(1, cnt++, dtData, 40, daCenterTop, true, "com", false, "", dfNone, 1);
			InitDataProperty(1, cnt++, dtData, 45, daCenterTop, true, "trade", false, "", dfNone, 1);
			InitDataProperty(1, cnt++, dtData, 40, daCenterTop, true, "lane", false, "", dfNone, 1);
			InitDataProperty(1, cnt++, dtData, 30, daCenter, true, "io", false, "", dfNone, 1);
			InitDataProperty(1, cnt++, dtData, 45, daCenter, true, "region", false, "", dfNone, 1);
			InitDataProperty(1, cnt++, dtData, 75, daCenter, true, "vvd", false, "", dfNone, 1);
			InitDataProperty(1, cnt++, dtData, 60, daCenter, true, "lastport", false, "", dfNone, 1);
			InitDataProperty(1, cnt++, dtData, 60, daCenter, true, "atd", false, "", dfDateYmd, 1);
			InitDataProperty(1, cnt++, dtData, 50, daCenter, true, "week", false, "", dfNone, 1);
			InitDataProperty(1, cnt++, dtAutoSum, 50, daRight, true, "full_20", false, "", dfNullInteger, 1);
			InitDataProperty(1, cnt++, dtAutoSum, 50, daRight, true, "full_40", false, "", dfNullInteger, 1);
			InitDataProperty(1, cnt++, dtAutoSum, 50, daRight, true, "full_hc", false, "", dfNullInteger, 1);
			InitDataProperty(1, cnt++, dtAutoSum, 50, daRight, true, "full_45", false, "", dfNullInteger, 1);
			InitDataProperty(1, cnt++, dtAutoSum, 50, daRight, true, "full_total", false, "", dfNullInteger, 1);
			InitDataProperty(1, cnt++, dtAutoSum, 50, daRight, true, "mty_20", false, "", dfNullInteger, 1);
			InitDataProperty(1, cnt++, dtAutoSum, 50, daRight, true, "mty_40", false, "", dfNullInteger, 1);
			InitDataProperty(1, cnt++, dtAutoSum, 50, daRight, true, "mty_hc", false, "", dfNullInteger, 1);
			InitDataProperty(1, cnt++, dtAutoSum, 50, daRight, true, "mty_45", false, "", dfNullInteger, 1);
			InitDataProperty(1, cnt++, dtAutoSum, 50, daRight, true, "mty_total", false, "", dfNullInteger, 1);
			InitDataProperty(1, cnt++, dtAutoSum, 60, daRight, true, "box_total", false, cBoxTotal, dfNullInteger, 1);
			InitDataProperty(1, cnt++, dtAutoSum, 60, daRight, true, "teu_total", false, cTEUTotal, dfNullInteger, 1);
			InitDataProperty(1, cnt++, dtData, 50, daRight, true, "teu_full", false, "", dfNone, 1);
			InitDataProperty(1, cnt++, dtData, 50, daRight, true, "teu_eq", false, "", dfNone, 1);
			InitDataProperty(1, cnt++, dtData, 50, daRight, true, "eq_20", false, "", dfNone, 1);
			InitDataProperty(1, cnt++, dtData, 50, daRight, true, "eq_40", false, "", dfNone, 1);
			InitDataProperty(1, cnt++, dtData, 50, daRight, true, "eq_hc", false, "", dfNone, 1);
			InitDataProperty(1, cnt++, dtData, 50, daRight, true, "eq_45", false, "", dfNone, 1);
			InitDataProperty(1, cnt++, dtData, 50, daRight, true, "eq_total", false, "", dfNone, 1);

			InitDataProperty(1, cnt++, dtAutoSum, 50, daRight, true, "deadslot", false, "", dfNullInteger, 0);
			InitDataProperty(1, cnt++, dtAutoSum, 50, daRight, true, "weighttotal", false, "", dfNullInteger, 0);
			InitDataProperty(1, cnt++, dtAutoSum, 50, daRight, true, "releasedteu", false, "", dfNullInteger, 0);

			InitDataProperty(1, cnt++, dtAutoSum, 50, daRight, true, "releasedweight", false, "", dfNullInteger, 0);
			InitDataProperty(1, cnt++, dtAutoSum, 50, daRight, true, "bsaspace", false, "", dfNullInteger, 0);
			InitDataProperty(1, cnt++, dtAutoSum, 50, daRight, true, "bsaweight", false, "", dfNullInteger, 0);
			InitDataProperty(1, cnt++, dtAutoSum, 50, daRight, true, "U_Space", false, unusedSpace, dfNullInteger, 0);
			InitDataProperty(1, cnt++, dtAutoSum, 50, daRight, true, "U_Weight", false, unusedWeight, dfNullInteger, 0);

			InitDataProperty(1, cnt++, dtData, 50, daRight, true, "lffull", false, "", dfNone, 1);
			InitDataProperty(1, cnt++, dtData, 50, daRight, true, "lfeq", false, "", dfNone, 1);
			InitDataProperty(1, cnt++, dtData, 50, daRight, true, "lfwgt", false, "", dfNone, 1);

			InitDataProperty(1, cnt++, dtData, 60, daCenter, true, "datasource", false, "", dfNone, 1);

			CountPosition = 0;
		}
		break;
	}
}

/**
 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
 */
function getBackEndJobStatus() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];

	formObj.f_cmd.value = COMMAND02;
	var sXml = sheetObj.GetSearchXml("EES_CIM_1050GS.do", FormQueryString(formObj));
	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
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
	var sheetObj = sheetObjects[0];

	formObj.f_cmd.value = COMMAND03;
	var sXml = sheetObj.GetSearchXml("EES_CIM_1050GS.do", FormQueryString(form));

	sheetObj.LoadSearchXml(sXml);
	sheetObj.WaitImageVisible = true;
	ComOpenWait(false);
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회
		if (validateForm(sheetObj, formObj, sAction)) {
			if (sheetObj.id == "sheet1") {
				formObj.f_cmd.value = COMMAND01;
				sheetObj.WaitImageVisible = false;
				sheetObj.Redraw = false;
				ComOpenWait(true);

				var sXml = sheetObj.GetSearchXml("EES_CIM_1050GS.do", FormQueryString(formObj));
				var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");

				if (backendJobKey.length > 0) {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.RequestTimeOut = 10000;
					timer1 = setInterval(getBackEndJobStatus, 1000);
				}
			}
		} else {
			return;
		}

		break;

	case IBSEARCH_ASYNC01: //lane focusOut
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH01;

			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_1049GS.do", FormQueryString(formObj));
			var sCheck = ComGetEtcData(sXml, "check");
			if (sCheck != "OK") {
				ComShowCodeMessage("CIM29012");
				document.form.lane.value = "";
				sheetObj.WaitImageVisible = true;
				ComSetFocus(document.form.lane);
				return false;
			}
			sheetObj.WaitImageVisible = true;
		} else {
			return;
		}

		break;

	case IBSEARCH_ASYNC02: //vvd focusOut
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH03;

			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_1033GS.do", FormQueryString(formObj));
			var sCheck = ComGetEtcData(sXml, "check");
			if (sCheck != "OK") {
				ComShowCodeMessage("CIM29023");
				document.form.vvd.value = "";
				sheetObj.WaitImageVisible = true;
				ComSetFocus(document.form.vvd);
				return false;
			}
			sheetObj.WaitImageVisible = true;

		} else {
			return;
		}

		break;

	case IBSEARCH_ASYNC03: //open 조회
		formObj.f_cmd.value = SEARCH04;
		var sXml = sheetObj.GetSearchXml("EES_CIM_1014GS.do", FormQueryString(formObj));

		var sTrade = ComGetEtcData(sXml, "sTrade");
		if (sTrade != undefined) {
			var arrTrade = sTrade.split(",");

			MakeComboObject2(formObj.trade, arrTrade);
		}
		break;

	case IBSEARCH_ASYNC04: //trade별 조회
		formObj.f_cmd.value = SEARCH04;
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("EES_CIM_1050GS.do", FormQueryString(formObj));
		var sLane = ComGetEtcData(sXml, "sLane");
		if (sLane == "noData") {
			comboObjects[0].focus();
			return false;
		}
		if (sLane != undefined) {
			var arrLane = sLane.split(",");
			MakeComboObject3(formObj.lane, arrLane);
		}
		document.form.chgFocus01.focus();
		sheetObj.WaitImageVisible = true;
		break;

	case IBSEARCH_ASYNC05: //trade lane 별 조회
		formObj.f_cmd.value = SEARCH05;
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("EES_CIM_1050GS.do", FormQueryString(formObj));
		var sVvd = ComGetEtcData(sXml, "sVvd");
		if (sVvd == "noData") {
			comboObjects[0].focus();
			return false;
		}
		if (sVvd != undefined) {
			var arrVvd = sVvd.split(",");
			MakeComboObject(formObj.vvd, arrVvd);
		}
		document.form.chgFocus02.focus();
		sheetObj.WaitImageVisible = true;
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

function chkToDateWeekBlur() {
	var period = document.form.period.value;
	var toDate = document.form.todate.value;
	var frDate = document.form.fromdate.value;

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
			if (event.srcElement.name == "todate") {
				return false;
			}
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
			ComShowCodeMessage("CIM29025");
			document.getElementById("fromdate").value = "";
			document.getElementById("todate").value = "";
			ComSetFocus(document.getElementById("fromdate"));
			return;
		}
	}
	return true;
}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_deactivate() {
	var f = document.getElementById("fromdate");
	var t = document.getElementById("todate");
	sVal1 = f.value.replace(/\/|\-|\./g, "");
	sVal2 = t.value.replace(/\/|\-|\./g, "");

	switch (event.srcElement.name) {

	case "fromdate":
		if (ComChkObjValid(event.srcElement, false)) {

			if (f.getAttribute("dataformat") == "ymd") {

				if (sVal1 != "" && sVal2 != "") {
					var flag = ComChkPeriod(sVal1, sVal2);
					if (flag < 1) {
						if (event.srcElement.name == "todate") {
							event.srcElement.value = "";
							ComShowCodeMessage("CIM29004");
							enterSwitch = false;
							t.focus();
							t.select();
							return false;
						} else {
							t.value = "";
							enterSwitch = false;
							t.focus();
							t.select();
							return false;
						}
					} else {
						if (chkToDateWeekBlur() == false) {
							event.srcElement.value = "";
							enterSwitch = false;
							t.focus();
							t.select();
							return false;
						}
					}
					enterSwitch = true;
				}

			}

		} else {
			if (f.getAttribute("dataformat") == "ymd") {

				if (sVal1.length > 0 && !ComIsDate(sVal1) && event.srcElement.name == 'fromdate') {

					enterSwitch = false;
					event.srcElement.value = "";
					ComShowCodeMessage("CIM21004", "YYYYMMDD");
					event.srcElement.focus();
					event.srcElement.select();
					return false;
				}
			}
		}

		break;
	case "todate":
		if (ComChkObjValid(event.srcElement, false)) {

			if (t.getAttribute("dataformat") == "ymd") {

				if (sVal1 != "" && sVal2 != "") {
					var flag = ComChkPeriod(sVal1, sVal2);
					if (flag < 1) {
						if (event.srcElement.name == "todate") {
							event.srcElement.value = "";
							ComShowCodeMessage("CIM29004");
							enterSwitch = false;
							t.focus();
							t.select();
							return false;
						} else {
							t.value = "";
							enterSwitch = false;
							t.focus();
							t.select();
							return false;
						}
					} else {
						if (chkToDateWeekBlur() == false) {
							event.srcElement.value = "";
							ComShowCodeMessage("CIM29026");
							enterSwitch = false;
							t.focus();
							t.select();
							return false;
						}
					}
					enterSwitch = true;
				}

			}

		} else {
			if (t.getAttribute("dataformat") == "ymd") {

				if (sVal2.length > 0 && !ComIsDate(sVal2) && event.srcElement.name == 'todate') {
					enterSwitch = false;

					document.getElementById("todate").value = "";
					ComShowCodeMessage("CIM21004", "YYYYMMDD");

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
	switch (event.srcElement.name) {
	case "chgFocus01":
		comboObjects[1].focus();
		break;
	case "chgFocus02":
		comboObjects[2].focus();
		break;
	case "fromdate":
		ComClearSeparator(event.srcElement);
		ComSetFocus(event.srcElement);
		break;
	case "todate":
		ComClearSeparator(event.srcElement);
		ComSetFocus(event.srcElement);
		break;
	}
}

function obj_keypress() {
	switch (event.srcElement.name) {

	case "fromdate":
		// 숫자만 + "-"만 입력허용
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "todate":
		// 숫자만 + "-"만 입력허용
		ComKeyOnlyNumber(event.srcElement);
		break;
	}
	//  form_keyup();
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (sAction == IBSEARCH) {
			if (fromdate.value == "") {
				ComShowCodeMessage("CIM21001", "Period");
				ComSetFocus(fromdate);
				return false;
			} else if (todate.value == "") {
				ComShowCodeMessage("CIM21001", "Period");
				ComSetFocus(todate);
				return false;
			} else if (fromdate.value.length < 8) {
				return false;
			} else if (todate.value.length < 8) {

				return false;
			}
			if (!enterSwitch) {
				return false;
			}
		} else {
			return false;
		}
	}

	return true;
}

function colHiddenfunc() {
	var flag = "";
	for ( var i = 0; i < document.form.lfinfo.length; i++) {
		if (document.form.lfinfo[i].checked) {
			flag = document.form.lfinfo[i].value;
		}
	}
	document.form.rpt_lfinfo.value = flag;

	if (flag == "E") {
		for ( var x = 29; x < 40; x++) {
			sheetObjects[0].ColHidden(x) = true;
		}
	} else {
		for ( var x = 29; x < 40; x++) {
			sheetObjects[0].ColHidden(x) = false;
		}
	}
	return flag;
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		Redraw = true;
		var flag = colHiddenfunc();
		/*
		 for ( var x = 0; x < sheetObj.LastRow; x++) {
		 if (sheetObj.CellValue(x, 1) == "Total") {
		 RowBackColor(x) = RgbColor(201, 213, 235);
		 RowBackColor(x + 1) = RgbColor(201, 213, 235);
		 }
		 }
		 */
		if (RowCount > 0) {
			for ( var i = 10; i < 22; i++) {
				SumValue(0, i) = CellValue(RowCount - 0, i);
				SumValue(1, i) = CellValue(RowCount + 1, i);
			}
	
			for ( var i = 22; i < 29; i++) {
				SumText(0, i) = CellValue(RowCount, i);
				SumText(1, i) = CellValue(RowCount + 1, i);
			}
	
			for ( var i = 29; i < 37; i++) {
				SumValue(0, i) = CellValue(RowCount, i);
				SumValue(1, i) = CellValue(RowCount + 1, i);
			}
	
			for ( var i = 37; i < 40; i++) {
				SumText(0, i) = CellValue(RowCount, i);
				SumText(1, i) = CellValue(RowCount + 1, i);
			}

			//RowDelete(RowCount, false);
			//RowDelete(RowCount + 1, false);
			RowHidden(RowCount) = true;
			RowHidden(RowCount + 1) = true;
		}
		document.form.rpt_fromdate.value = document.form.fromdate.value;
		document.form.rpt_todate.value = document.form.todate.value;
		document.form.rpt_trade.value = comboObjects[0].Text;
		document.form.rpt_lane.value = comboObjects[1].Text;
		document.form.rpt_vvd.value = comboObjects[2].Text;
		var check = "";
		for ( var i = 0; i < document.form.company.length; i++) {
			if (document.form.company[i].checked) {
				check = document.form.company[i].value;
			}
		}
		document.form.rpt_company.value = check;

		SumText(0, "seq") = "";
		SumText(0, "com") = "G.Total";
		/*
		SumText(0, "trade") = "G.Total";
		SumText(0, "lane") = "G.Total";
		 */
		SumText(0, "io") = "Out";
		/*
		SumText(1, "seq") = "G.Total";
		SumText(1, "com") = "G.Total";          
		SumText(1, "trade") = "G.Total";
		SumText(1, "lane") = "G.Total";     
		 */
		SumText(1, "io") = "In";

		CellAlign(LastRow - 1, "seq") = daCenterTop;
		CellAlign(LastRow - 1, "com") = daCenterTop;
		CellAlign(LastRow - 1, "trade") = daCenterTop;
		CellAlign(LastRow - 1, "lane") = daCenterTop;
		CellAlign(LastRow - 1, "io") = daCenter;
		CellAlign(LastRow, "seq") = daCenterTop;
		CellAlign(LastRow, "com") = daCenterTop;
		CellAlign(LastRow, "trade") = daCenterTop;
		CellAlign(LastRow, "lane") = daCenterTop;
		CellAlign(LastRow, "io") = daCenter;
		if (RowCount > 0) {
			//	SetMergeCell( ( sheetObj.LastRow - 1 ) , 0 , 2 , 4 );    
		}
	}
}

/* 개발자 작업  끝 */