/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_cim_1025.js
 *@FileTitle : Domestic Match-Back (M/B %)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.05
 *@LastModifier : 문중철
 *@LastVersion : 1.0
 * 2009.06.05 문중철
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
 * @class ees_cim_1025 : ees_cim_1025 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cim_1025() {
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
var oldCntrTypeSize2 = "";
var sCntrTypeSize = "";
var tabFlag = 0;
var isOpen = true;

var comboObjects = new Array();
var comboCnt = 0;

var isSearch = 0;

var tabIndex = 0;

// XTC 날짜입력이벤트 컨트롤 
var enterSwitch = false;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function lastDay(y, m) {
	var d, d2, s = "";
	d = new Date();
	d2 = new Date(y, m, "");
	s = d2.getDate();
	return (s);
}

function setDateToday() {
	var today = new Date();
	var y = today.getFullYear().toString();
	var m = (today.getMonth() + 1).toString();
	if (m.length == 1) {
		m = 0 + m;
	}
	var ym = y + '-' + m;
	//		document.form.froms.value = ym;    	
	//		document.form.tos.value = ym;    	
	var day = lastDay(y, m);
	document.form.from.value = y + m + "01";
	document.form.to.value = y + m + day;
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[beforetab];
	var shtCnt = 0;
	var t1sheet1 = sheetObjects[shtCnt++];
	var t2sheet1 = sheetObjects[shtCnt++];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {

		case "btn_Retrieve":
			isOpen = true;
			isSearch = 1;
			if (beforetab == 0)
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
			else if (beforetab == 1)
				doActionIBSheet2(sheetObject, formObject, IBSEARCH);
			break;

		case "btn_downexcel":
			if (beforetab == 0) {
				t1sheet1.Down2Excel(-1, false, false, true, "",
						"/apps/alps/ees/cim/cntroperationperformancemgt/eqmatchbacknloadfactormgt/script/EES_CIM_1025_XLS.xml", true, false, "", false,
						"", "", true);
			} else if (beforetab == 1) {
				t2sheet1.Down2Excel(-1, false, false, true, "",
						"/apps/alps/ees/cim/cntroperationperformancemgt/eqmatchbacknloadfactormgt/script/EES_CIM_1025_XLS.xml", true, false, "", false,
						"", "", true);
			}
			break;

		case "btn_new":
			t1sheet1.RemoveAll();
			t2sheet1.RemoveAll();
			formObject.reset();
			document.form.location.disabled = true;
			document.getElementById("froms").focus();
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
			cnt_cd = formObject.locationBy.value;
			loc_cd = formObject.location.value;
			if (formObject.locationBy.value != 'RL' && formObject.locationBy.value != 'RC' && formObject.locationBy.value != 'RE') {
				var loc_code = "";

				if (formObject.locationBy.value == "RC") {
					loc_code = "rcc_cd";
				} else if (formObject.locationBy.value == "RL") {
					loc_code = "rcc_cd";
				} else if (formObject.locationBy.value == "LE") {
					loc_code = "lcc_cd";
				} else if (formObject.locationBy.value == "LS") {
					loc_code = "lcc_cd";
				} else if (formObject.locationBy.value == "ES") {
					loc_code = "ecc_cd";
				} else if (formObject.locationBy.value == "SS") {
					loc_code = "scc_cd";
				}
				var param = "?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 460, loc_code + ":location", "1,0,1,1,1,1,1,1", true);
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
	setDateToday();
	//alert("loadPage()");
	for (i = 0; i < sheetObjects.length; i++) {

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		//alert("initSheet("+sheetObjects[i]+")");
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	axon_event.addListener('blur', 'obj_blur', 'location');
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); //- form OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerFormat('keyup', 'form_keyup', form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	//alert("axon_event.addListener");
	//IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
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

	case "t1sheet1": //t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 400;
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

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			//InitColumnInfo(27, 0, 0, true);

			//컬럼 가변 처리를 위한 기준 데이터를 배열로 만든다.
			oldCntrTypeSize = sCntrTypeSize;
			var arrTpSz = oldCntrTypeSize.split(",");

			if (HeadTitle == null || HeadTitle == "") {
				HeadTitle = "LCC|Total";
				for ( var i = 0; i < arrTpSz.length; i++) {
					HeadTitle += "|" + arrTpSz[i];
				}
				var headCount = ComCountHeadTitle(HeadTitle);
				InitColumnInfo(headCount, 0, 0, true);
			}
			var headCnt = HeadTitle.split("|").length;
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCnt, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			sheetObj.FrozenCols = 2;

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			//  InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,		false,		"ibflag");
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "loc_cd", false, "", dfNone);
			InitDataProperty(0, cnt++, dtAutoSum, 60, daRight, false, "total", false, "", dfNone, 1);

			for ( var i = 0; i < arrTpSz.length; i++) {
				arEtcData = "_" + i;
				InitDataProperty(0, cnt++, dtAutoSum, 60, daRight, false, "qty" + arEtcData, false, "", dfNone, 1);
			}

			RequestTimeOut = 300;

			CountPosition = 0;

		}
		break;

	case "t2sheet1": //t2sheet1 init

		with (sheetObj) {

			// 높이 설정
			style.height = 400;
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
			InitRowInfo(1, 4, 3, 100);

			//컬럼 가변 처리를 위한 기준 데이터를 배열로 만든다.
			oldCntrTypeSize2 = sCntrTypeSize;
			var arrTpSz = oldCntrTypeSize2.split(",");

			if (HeadTitle == null || HeadTitle == "") {
				HeadTitle = "LCC|Division|Total";
				for ( var i = 0; i < arrTpSz.length; i++) {
					HeadTitle += "|" + arrTpSz[i];
				}
				var headCount = ComCountHeadTitle(HeadTitle);
				InitColumnInfo(headCount, 0, 0, true);
			}
			var headCnt = HeadTitle.split("|").length;

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCnt, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			sheetObj.FrozenCols = 3;

			var RowCnt = 0;

			for ( var RowCnt = 0; RowCnt < 4; RowCnt++) {
				cnt = 0;
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				//InitDataProperty(RowCnt, cnt++ , dtHiddenStatus,	30,	daCenter,		false,		"ibflag");
				if (RowCnt == 3) {
					InitDataProperty(RowCnt, cnt++, dtData, 80, daCenterTop, true, "loc_cd", false, "", dfNone);
					InitDataProperty(RowCnt, cnt++, dtData, 60, daCenter, true, "division", false, "", dfNone);
					InitDataProperty(RowCnt, cnt++, dtData, 60, daRight, false, "total", false, "", dfNone, 1);
					for ( var i = 0; i < arrTpSz.length; i++) {
						arEtcData = "_" + i;
						InitDataProperty(RowCnt, cnt++, dtData, 60, daRight, false, "qty" + arEtcData, false, "", dfNone, 1);
					}
				} else {
					InitDataProperty(RowCnt, cnt++, dtData, 80, daCenterTop, true, "loc_cd", false, "", dfNone);
					InitDataProperty(RowCnt, cnt++, dtData, 60, daCenter, true, "division", false, "", dfNone);
					InitDataProperty(RowCnt, cnt++, dtAutoSum, 60, daRight, false, "total", false, "", dfNullInteger, 1);
					for ( var i = 0; i < arrTpSz.length; i++) {
						arEtcData = "_" + i;
						InitDataProperty(RowCnt, cnt++, dtAutoSum, 60, daRight, false, "qty" + arEtcData, false, "", dfNullInteger, 1);
					}
				}
			}
			CountPosition = 0;
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	//alert("sAction : [" + sAction + "]");        
	switch (sAction) {

	case IBSEARCH: //조회
		isOpen = true;
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH;

			if (formObj.location.value == "" && formObj.locationBy.value != "AR" && formObj.locationBy.value != "AC" && formObj.locationBy.value != "AP") {
				ComShowCodeMessage("CIM21001", "Location ");
				ComSetFocus(location);
				return false;
			}
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);

			var sXml = sheetObj.GetSearchXml("EES_CIM_1025GS.do", FormQueryString(formObj));

			sheetObj.LoadSearchXml(sXml);
			sheetObj.WaitImageVisible = true;
			ComOpenWait(false);
		}
		break;

	case IBSEARCH_ASYNC01: //open 조회
		var sXml = "";
		if (sheetObj.id == "t1sheet1") {
			sXml = formObj.sXml.value;
		}
		sCntrTypeSize = ComGetEtcData(sXml, "cntrTypeSize");

		//서버에서 가져온 "가변컬럼정보"만 읽어오기
		oldCntrTypeSize = sCntrTypeSize;
		sheetObj.Reset();
		initSheet(sheetObj);
		initSheet(sheetObjects[1]);
		break;

	case IBSEARCH_ASYNC02: //location focusOut
		formObj.f_cmd.value = SEARCH02;
		document.form.inquiryLevel.value = document.getElementById("locationBy").value.substring(0, 1);
		if (formObj.location.value == "") {
			return true;
		}
		if (formObj.inquiryLevel.value == "") {
			return false;
		}
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("EES_CIM_1001GS.do", FormQueryString(formObj));
		var sCheck = ComGetEtcData(sXml, "check");
		if (sCheck != "OK") {
			var xLocationBy = document.getElementById("locationBy").value.substring(0, 1);
			if (document.form.location.value != "") {
				if (xLocationBy == "R") {
					ComShowCodeMessage("CIM29031");
					document.form.location.value = "";
					sheetObj.WaitImageVisible = true;
					ComSetFocus(document.form.location);
					return false;
				} else if (xLocationBy == "L") {
					ComShowCodeMessage("CIM29032");
					document.form.location.value = "";
					sheetObj.WaitImageVisible = true;
					ComSetFocus(document.form.location);
					return false;
				} else if (xLocationBy == "E") {
					ComShowCodeMessage("CIM29033");
					document.form.location.value = "";
					sheetObj.WaitImageVisible = true;
					ComSetFocus(document.form.location);
					return false;
				} else if (xLocationBy == "Y") {
					ComShowCodeMessage("CIM29036");
					document.form.location.value = "";
					sheetObj.WaitImageVisible = true;
					ComSetFocus(document.form.location);
					return false;
				} else if (xLocationBy == "P") {
					ComShowCodeMessage("CIM29035");
					document.form.location.value = "";
					sheetObj.WaitImageVisible = true;
					ComSetFocus(document.form.location);
					return false;
				} else if (xLocationBy == "S") {
					ComShowCodeMessage("CIM29034");
					document.form.location.value = "";
					sheetObj.WaitImageVisible = true;
					ComSetFocus(document.form.location);
					return false;
				}
			} else {
				return true;
			}
		}
		document.form.tpsz[0].focus();
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

			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("EES_CIM_10252GS.do", FormQueryString(formObj));

			sheetObj.LoadSearchXml(sXml);
			sheetObj.WaitImageVisible = true;
			ComOpenWait(false);
		}
		break;
	}
}

function obj_blur() {
	isOpen = true;
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
}

function obj_activate() {
	ComClearSeparator(event.srcElement);
	ComSetFocus(event.srcElement);
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

function form_keyup() {
	var obj = null;
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	if (keyValue != 13) {
		ComKeyEnter('lengthnextfocus');
	} else {
		if (obj_deactivate()) {
			if (tabIndex == 0) {
				isOpen = true;
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			} else {
				isOpen = true;
				doActionIBSheet2(sheetObjects[1], document.form, IBSEARCH);
			}
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
		document.getElementById("froms").focus();
	} else if (obj.name == "locationBy") {
		if (obj.value == "RL" || obj.value == "RC" || obj.value == "RE") {
			document.getElementById("location").disabled = true;
			document.getElementById("location").value = "USNYC";
		} else {
			document.getElementById("location").disabled = false;
			if(document.getElementById("location").value == 'USNYC'){
				document.getElementById("location").value = "";
			}
			document.getElementById("location").focus();
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
			InsertTab(cnt++, "M/Back(%)", -1);
			InsertTab(cnt++, "M/B Detail", -1);
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

	var sheetObject = sheetObjects[beforetab];

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
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (sAction != IBSEARCH_ASYNC01) {
			if (period.value == "M") {
				if (froms.value == "") {
					ComShowCodeMessage("CIM21001", "Period ");
					ComSetFocus(froms);
					return false;
				} else if (tos.value == "") {
					ComShowCodeMessage("CIM21001", "Period ");
					ComSetFocus(tos);
					return false;
				}
			} else if (period.value == "W") {
				if (froms.value == "") {
					ComShowCodeMessage("CIM21001", "Period ");
					ComSetFocus(froms);
					return false;
				} else if (tos.value == "") {
					ComShowCodeMessage("CIM21001", "Period ");
					ComSetFocus(tos);
					return false;
				}
			}

			if (location.value == "" && sAction != IBSEARCH_ASYNC02) {
				if (locationBy.value == 'LE' || locationBy.value == 'LS' || locationBy.value == 'ES' || locationBy.value == 'SS') {
					ComShowCodeMessage("CIM21001", "Location by");
					ComSetFocus(location);
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

		}
	} // end of with
	return true;
}

function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		var str_loc_nm = "";
		var f = document.form.locationBy;

		if (f.value == "RL") {
			str_loc_nm = "LCC";
		} else if (f.value == "RC") {
			str_loc_nm = "Country";
		} else if (f.value == "RE") {
			str_loc_nm = "ECC";
		} else if (f.value == "LE") {
			str_loc_nm = "ECC";
		} else if (f.value == "LS") {
			str_loc_nm = "SCC";
		} else if (f.value == "ES") {
			str_loc_nm = "SCC";
		} else if (f.value == "SS") {
			str_loc_nm = "SCC";
		}

		CellValue2(0, 0) = str_loc_nm;
		var arrTime = sCntrTypeSize.split(",");
		for ( var i = 1; i < arrTime.length + 2; i++) {
			CellFontColor(LastRow, i) = RgbColor(0, 0, 0);
			if (ComIsNull(CellValue(RowCount, i))) {
				SumText(0, i) = "";
			} else if (CellValue(RowCount, i) == 0.0) {
				SumText(0, i) = 0;
			} else {
				if ((CellValue(RowCount, i)).indexOf("-") != -1) {
					CellFontColor(LastRow, i) = RgbColor(220, 0, 0);
				}
				SumText(0, i) = CellValue(RowCount, i);
			}
		}
		if (RowCount > 0) {
			RowHidden(RowCount) = true;
		}

		SumText(0, 0) = "G.Total";
		CellAlign(0, 1) = daCenter;
		SelectRow = 0;

		SelectHighLight = false;
	}
}

function t1sheet1_OnClick(sheetObj, Row, Col, Value) {
	sheetObj.SelectHighLight = true;
}

function t2sheet1_OnClick(sheetObj, Row, Col, Value) {
	sheetObj.SelectHighLight = true;
}

function t2sheet1_OnChangeSum2(sheetObj, LastRow2) {
	for ( var i = 2; i < sheetObjects[1].LastCol; i++) {
		if (sheetObjects[1].SumValue(sheetObjects[1].LastRow - 1, i) < 0)
			sheetObjects[1].CellFontColor(sheetObjects[1].LastRow - 1, i) = sheetObjects[1].RgbColor(220, 0, 0);
	}
}

function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		var str_loc_nm = "";
		var f = document.form.locationBy;

		if (f.value == "RL") {
			str_loc_nm = "LCC";
		} else if (f.value == "RC") {
			str_loc_nm = "Country";
		} else if (f.value == "RE") {
			str_loc_nm = "ECC";
		} else if (f.value == "LE") {
			str_loc_nm = "ECC";
		} else if (f.value == "LS") {
			str_loc_nm = "SCC";
		} else if (f.value == "ES") {
			str_loc_nm = "SCC";
		} else if (f.value == "SS") {
			str_loc_nm = "SCC";
		}

		CellValue2(0, 0) = str_loc_nm;

		var row = LastRow;
		SumText(0, "loc_cd") = "G.Total";
		SumText(1, "loc_cd") = "G.Total";
		SumText(2, "loc_cd") = "G.Total";
		SumText(3, "loc_cd") = "G.Total";
		SumText(0, "division") = "I/B";
		SumText(1, "division") = "O/B";
		SumText(2, "division") = "Balance";
		SumText(3, "division") = "M/B (%)";

		//CellAlign(0, 2) = daCenter;
		/*
		 for ( var x = 0; x < sheetObj.LastRow; x++) {
		 if (sheetObj.CellValue(x, 1) == "M/B(%)") {
		 RowBackColor(x) = RgbColor(201, 213, 235);
		 }
		 }
		 */
		var arrTime = sCntrTypeSize.split(",");
		for ( var i = 2; i < arrTime.length + 4; i++) {
			CellFontColor(LastRow - 1, i) = RgbColor(0, 0, 0);
			CellFontColor(LastRow, i) = RgbColor(0, 0, 0);

			if (SumValue(0, i) >= SumValue(1, i)) {
				if (SumValue(0, i) > 0) {
					var tVal01 = Math.round(SumValue(1, i) / SumValue(0, i) * 100);
					SumText(3, i) = tVal01 + "%";
					if (tVal01 < 0) {
						CellFontColor(LastRow - 1, i) = RgbColor(220, 0, 0);
						CellFontColor(LastRow, i) = RgbColor(220, 0, 0);
					}
				} else {
					if (SumValue(2, i) < 0) {
						CellFontColor(LastRow - 1, i) = RgbColor(220, 0, 0);
					}
					SumText(3, i) = '0%';
				}
			} else if (SumValue(1, i) > 0) {
				var tVal02 = Math.round((SumValue(0, i) / SumValue(1, i) * (-1)) * 100);
				if (SumValue(2, i) < 0) {
					CellFontColor(LastRow - 1, i) = RgbColor(220, 0, 0);
				}
				SumText(3, i) = tVal02 + "%";
				if (tVal02 < 0) {

					CellFontColor(LastRow - 1, i) = RgbColor(220, 0, 0);
					CellFontColor(LastRow, i) = RgbColor(220, 0, 0);
				}
			} else {
				SumText(3, i) = '0%';
			}
		}

		//var arrTime = sCntrTypeSize.split(",");
		for ( var i = 3; i < arrTime.length + 4; i++) {
			if (CellValue(LastRow - 4, i) == "") {
				SumText(0, i) = "";
				SumText(1, i) = "";
				SumText(2, i) = "";
				SumText(3, i) = "";
			}
		}

		SelectHighLight = false;

		CellAlign(LastRow - 3, "loc_cd") = daCenterTop;
		CellAlign(LastRow - 2, "loc_cd") = daCenterTop;
		CellAlign(LastRow - 1, "loc_cd") = daCenterTop;
		CellAlign(LastRow, "loc_cd") = daCenterTop;
		CellAlign(LastRow - 3, "division") = daCenter;
		CellAlign(LastRow - 2, "division") = daCenter;
		CellAlign(LastRow - 1, "division") = daCenter;
		CellAlign(LastRow, "division") = daCenter;
		SetMergeCell((sheetObj.LastRow - 3), 0, 4, 1);

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
			isOpen = true;
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		} else if (nItem == 1) {
			isOpen = true;
			doActionIBSheet2(sheetObjects[1], document.form, IBSEARCH);
		}
	}

}

function t1sheet1_OnLoadFinish(sheetObj) {
	//sheetObj.WaitImageVisible = false;
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	document.form.froms.focus();
	//sheetObj.WaitImageVisible = true;
}
