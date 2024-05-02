/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0932.js
 *@FileTitle : ESM_BKG_0932
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.10
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.07.10 김승민
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2012.12.24 김보배 [CHM-201222011] [BKG] Load Summary by POD에 Special Stowage "MUPG" 추가 요청
 * 2012.12.24 김보배 [CHM-201222024] [BKG] Stowage code "MUPG" CLL  반영 요청
 * 2012.12.28 김보배 [CHM-201222025] [BKG] [Special Stowage Request Code] 간소화 및 HIDE CBF 미 반영 개정건
 * 2014.07.28 이한나 [CHM-201431212] Stowage : UDMX 추가에 따른 CLL 반영 요청
 * 2014.08.25 이한나 [CHM-201431700] (KOR) CNTR Loading List (CLL) 메뉴의 팝업 화면 보완 요청
 * 2014.10.01 이한나[CHM-201432082] (KOR) CLL의 Speicial Cargo detail 화면의 BS Code 칼럼 추가 요청
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
 * @class ESM_BKG_0932 : ESM_BKG_0932 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0932() {
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

var state = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용함 **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_Summary":
			doActionIBSheet(sheetObject, formObject, COMMAND01);
			break;

		case "btn_Special_CGO":
			doActionIBSheet(sheetObject, formObject, COMMAND02);
			break;

		case "btn_Print":
			doActionIBSheet(sheetObject, formObject, COMMAND03);
			break;
			
		case "btn_Pdf_Print":
			doActionIBSheet(sheetObject, formObject, COMMAND04);
			break;

		case "btn_Save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
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

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	ComBtnDisable("btn_print");
	initControl();
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
	axon_event.addListenerForm('blur', 'obj_deactivate', formObject); // - 포커스
	// 나갈때
	axon_event.addListenerFormat('focus', 'obj_activate', formObject); // - 포커스
	// 들어갈때
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // -
	// 키보드
	axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');

	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);

	ComBtnDisable("btn_print");
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
	case "upper":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('upper');
		break;
	case "uppernum2":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyAlphabetNChar('uppernum');
		break;
	default:
		// 숫자만입력하기(정수,날짜,시간)
		ComKeyOnlyNumber(event.srcElement);
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
	case "sheet1": //sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 200;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 2, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(19, 2, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle1 = "POD|MLB|Local|Local|Local|Local|T/S|T/S|T/S|T/S|Empty|Empty|Empty|Empty|Total|Total|Total|Total|Weight(KGS)";
			var HeadTitle2 = "POD|MLB|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|Weight(KGS)";
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			// InitDataProperty(0, cnt++, dtHiddenStatus, 40, daCenter, true,
			// "ibflag");
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "gubun_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "gubun_cd2",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
					"local_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
					"local_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
					"local_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
					"local_45", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "ts_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "ts_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "ts_40h",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "ts_45",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "mty_20",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "mty_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "mty_40h",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "mty_45",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "sum_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "sum_40",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "sum_40h",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "sum_45",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "wgt_mt",
					false, "", dfNullInteger, 3, false, false);

			// DataRowMerge(0) = true;

			CountPosition = 0;
		}
		break;
	case "sheet2": //sheet2 init
		with (sheetObj) {

			// 높이 설정
			style.height = 220;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(3, 1, 2, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(38, 2, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle1 = "POD|MLB|Local|Local|Local|Local|Local|Local|Local|Local|Local|Local|Local|Local|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|Total|Total|Total|Total|Total|Total|Total|Total|Total|Total|Total|Total";
			var HeadTitle2 = "POD|MLB|DG|DG|DG|RF|RF|RF|FR|FR|FR|O/T|O/T|O/T|DG|DG|DG|RF|RF|RF|FR|FR|FR|O/T|O/T|O/T|DG|DG|DG|RF|RF|RF|FR|FR|FR|O/T|O/T|O/T";
			var HeadTitle3 = "POD|MLB|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H";
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			InitHeadRow(2, HeadTitle3, true);
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			// SAVESTATUS, FORMATFIX]
			// InitDataProperty(0, cnt++, dtHiddenStatus, 40, daCenter, true,
			// "ibflag");
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "gubun_cd2",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "gubun_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"local_dg_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"local_dg_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"local_dg_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"local_rf_20", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"local_rf_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"local_rf_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"local_fr_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"local_fr_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"local_fr_40h", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"local_ot_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"local_ot_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"local_ot_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"ts_dg_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"ts_dg_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"ts_dg_40h", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"ts_rf_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"ts_rf_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"ts_rf_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"ts_fr_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"ts_fr_40", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"ts_fr_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"ts_ot_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"ts_ot_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"ts_ot_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"sum_dg_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"sum_dg_40", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"sum_dg_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"sum_rf_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"sum_rf_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"sum_rf_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"sum_fr_20", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"sum_fr_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"sum_fr_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"sum_ot_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"sum_ot_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 30, daRight, true,
					"sum_ot_40h", false, "", dfNone, 0, false, false);

			CountPosition = 0;
		}
		break;
	case "sheet3": //sheet3 init
		with (sheetObj) {

			// 높이 설정
			style.height = 200;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 2, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(42, 2, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle1 = "POD|MLB|AB|AB|AB|AB|" +
				"AF|AF|AF|AF|" +
				"AL|AL|AL|AL|" +
				"BC|BC|BC|BC|" +
				"MUPG|MUPG|MUPG|MUPG|" +
				"OD|OD|OD|OD|" +
				"OBSS|OBSS|OBSS|OBSS|" +
				"OLBS|OLBS|OLBS|OLBS|" +
				"OLBL|OLBL|OLBL|OLBL|" +
				"ODAB|ODAB|ODAB|ODAB";
			var HeadTitle2 = "POD|MLB|20|40|40H|45|" +
				"20|40|40H|45|" +
				"20|40|40H|45|" +
				"20|40|40H|45|" +
				"20|40|40H|45|" +
				"20|40|40H|45|" +
				"20|40|40H|45|" +
				"20|40|40H|45|" +
				"20|40|40H|45|" +
				"20|40|40H|45";
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			// InitDataProperty(0, cnt++, dtHiddenStatus, 40, daCenter, true,
			// "ibflag");

			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "gubun_cd3",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true,
					"blck_stwg_cd", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "ab_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "ab_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "ab_40h",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "ab_45",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "af_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "af_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
					"af_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
					"af_45", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "al_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "al_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
					"al_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
					"al_45", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "bc_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "bc_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
					"bc_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
					"bc_45", false, "", dfNone, 0, false, false);


			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "mupg_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "mupg_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
					"mupg_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
					"mupg_45", false, "", dfNone, 0, false, false);


			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "od_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "od_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
					"od_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
					"od_45", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "obss_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "obss_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
					"obss_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
					"obss_45", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "olbs_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "olbs_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "olbs_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "olbs_45", false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "olbl_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "olbl_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "olbl_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "olbl_45", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "odab_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "odab_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
					"odab_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
					"odab_45", false, "", dfNone, 0, false, false);

			CountPosition = 0;
		}
		break;
	case "sheet4": //sheet4 init
	with (sheetObj) {

		// 높이 설정
		style.height = 200;
		// 전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		// Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "")
			InitHostInfo(location.hostname, location.port, page_path);

		// 전체Merge 종류 [선택, Default msNone]
		MergeSheet = msPrevColumnMerge + msHeaderOnly;

		// 전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(2, 1, 2, 100);

		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(38, 2, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, false, true, false, false);

		var HeadTitle1 = "POD|MLB|ODAL|ODAL|ODAL|ODAL|ODBC|ODBC|ODBC|ODBC|ODET|ODET|ODET|ODET|ODFT|ODFT|ODFT|ODFT|ODHD|ODHD|ODHD|ODHD|OP|OP|OP|OP|OT|OT|OT|OT|OTNO|OTNO|OTNO|OTNO|PC|PC|PC|PC";
		var HeadTitle2 = "POD|MLB|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45";
		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);
		InitHeadRow(1, HeadTitle2, true);
		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
		// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
		// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
		// SAVESTATUS, FORMATFIX]
		// InitDataProperty(0, cnt++, dtHiddenStatus, 40, daCenter, true,
		// "ibflag");

		InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "gubun_cd3",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true,
				"blck_stwg_cd", false, "", dfNone, 0, false, false);

		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "odal_20",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "odal_40",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"odal_40h", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"odal_45", false, "", dfNone, 0, false, false);
		

		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "odbc_20",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "odbc_40",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "odbc_40h",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "odbc_45",
				false, "", dfNone, 0, false, false);


		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "odet_20",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "odet_40",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"odet_40h", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"odet_45", false, "", dfNone, 0, false, false);

		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "odft_20",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "odft_40",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"odft_40h", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"odft_45", false, "", dfNone, 0, false, false);
		
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "odhd_20",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "odhd_40",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"odhd_40h", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"odhd_45", false, "", dfNone, 0, false, false);

		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "op_20",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "op_40",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"op_40h", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"op_45", false, "", dfNone, 0, false, false);

		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "ot_20",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "ot_40",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"ot_40h", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"ot_45", false, "", dfNone, 0, false, false);

		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "otno_20",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "otno_40",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "otno_40h",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "otno_45",
				false, "", dfNone, 0, false, false);

		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "pc_20",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "pc_40",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"pc_40h", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"pc_45", false, "", dfNone, 0, false, false);


		CountPosition = 0;
	}
	break;
	case "sheet5": //sheet5 init
	with (sheetObj) {

		// 높이 설정
		style.height = 200;
		// 전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		// Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "")
			InitHostInfo(location.hostname, location.port, page_path);

		// 전체Merge 종류 [선택, Default msNone]
		MergeSheet = msPrevColumnMerge + msHeaderOnly;

		// 전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(2, 1, 2, 100);

		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(38, 2, 0, true); //34, 2, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, false, true, false, false);

		var HeadTitle1 = "POD|MLB|PCOD|PCOD|PCOD|PCOD|TS|TS|TS|TS|OLBP|OLBP|OLBP|OLBP|UD|UD|UD|UD|UDAB|UDAB|UDAB|UDAB|UDMX|UDMX|UDMX|UDMX|UT|UT|UT|UT|UTAB|UTAB|UTAB|UTAB|UW|UW|UW|UW";
		var HeadTitle2 = "POD|MLB|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45";
		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);
		InitHeadRow(1, HeadTitle2, true);
		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
		// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
		// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
		// SAVESTATUS, FORMATFIX]
		// InitDataProperty(0, cnt++, dtHiddenStatus, 40, daCenter, true,
		// "ibflag");

		InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "gubun_cd3",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true,
				"blck_stwg_cd", false, "", dfNone, 0, false, false);

		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "pcod_20",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "pcod_40",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"pcod_40h", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"pcod_45", false, "", dfNone, 0, false, false);
		
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "ts_20",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "ts_40",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "ts_40h",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "ts_45",
				false, "", dfNone, 0, false, false);


		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "olbp_20",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "olbp_40",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"olbp_40h", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"olbp_45", false, "", dfNone, 0, false, false);


		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "ud_20",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "ud_40",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"ud_40h", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"ud_45", false, "", dfNone, 0, false, false);

		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "udab_20",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "udab_40",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "udab_40h",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "udab_45",
				false, "", dfNone, 0, false, false);

		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "udmx_20",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "udmx_40",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "udmx_40h",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "udmx_45",
				false, "", dfNone, 0, false, false);

		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "ut_20",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "ut_40",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"ut_40h", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"ut_45", false, "", dfNone, 0, false, false);

		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "utab_20",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "utab_40",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"utab_40h", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"utab_45", false, "", dfNone, 0, false, false);

		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "uw_20",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "uw_40",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"uw_40h", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true,
				"uw_45", false, "", dfNone, 0, false, false);


		CountPosition = 0;
	}
	break;

	case "sheet6": // sheet6 init
		with (sheetObj) {

			// 높이 설정
			style.height = 200;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(24, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle1 = "|Seq.|CGO TYPE|BKG No.|TS|POD|BLCK\nSTWG|MLB|CS1|Container No.|TP|CS2|WGT|CLASS|UNNO.|MP|SG|LQ|TEMP|VENT|REMARK(DG&AK)|VOID(FEU)|STOW|";
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "bkg_no2",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "seq",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "cgo_type", 
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenterTop, true, "bkg_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "ts",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "pod",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "bkg_bs",
					false, "", dfNone, 0, false, false); // 2014.10.01 CHM-201432082
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "blck_stwg_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cs", 
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "cntr_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "tp", 
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cs2",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daRight, true, "wgt", 
					false, "", dfNullFloatOrg, 1, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "class_cd",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "unno",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "mp", 
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "sg",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "lq",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "temp",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "vent",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "remark",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "vo_id",
					false, "", dfNullFloatOrg, 1, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "stow",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true,
					"mty_bkg_cd", false, "", dfNone, 0, false, false);

			CountPosition = 0;
		}
		break;
	case "sheet7": // sheet7 init
		with (sheetObj) {

			// 높이 설정
			style.height = 180;
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
			InitRowInfo(2, 1, 2, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(14, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle1 = "POD|BLCK\nSTWG|DG|DG|DG|RF|RF|RF|AK|AK|AK|BB|BB|BB";
			var HeadTitle2 = "POD|BLCK\nSTWG|20FT|40FT|40H|20FT|40FT|40H|20FT|40FT|40H|20FT|40FT|40H";
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtAutoSum, 135, daCenter, true,
					"pod_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 80, daCenter, true, "bkg_bs",
					false, "", dfNone, 0, false, false);  // 2014.10.01 CHM-201432082
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "dg_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "dg_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "dg_45",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "rf_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "rf_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "rf_45",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "ak_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "ak_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "ak_45",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "bb2",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "bb4",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "bb45",
					false, "", dfNone, 0, false, false);

			CountPosition = 0;
		}
		break;
		
	case "sheet8": // sheet8 init
		with (sheetObj) {
	
			// 높이 설정
			style.height = 200;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;
	
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(7, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle1 = "CGO TYPE|POD|BLCK\nSTWG|MLB|CNTR|TYPE|DETAIL";
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "e_cgo_type",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "e_pod",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "e_bkg_bs",
					false, "", dfNone, 0, false, false);   // 2014.10.01 CHM-201432082
			InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "e_mlb",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 120, daCenterTop, true, "e_cntr_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "e_tp",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "e_detail",
					false, "", dfNone, 0, false, false);
	
			CountPosition = 0;
		}
		break;
	
	case "sheet9": // sheet9 init
		with (sheetObj) {

			// 높이 설정
			style.height = 200;
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
			InitRowInfo(1, 1, 2, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(23, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle1 = "Seq.|CGO TYPE|BKG No.|TS|POD|BLCK\nSTWG|MLB|CS1|Container No.|TP|CS2|WGT|CLASS|UNNO.|MP|SG|LQ|TEMP|VENT|REMARK(DG&AK)|VOID|STOW|";
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "seq",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "cgo_type", 
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "bkg_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "ts",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "pod",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "bkg_bs",
					false, "", dfNone, 0, false, false); // 2014.10.01 CHM-201432082
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "blck_stwg_cd",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cs1",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cntr_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "tp", false,
					"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cs2",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daRight, true, "wgt", false,
					"", dfNullFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "class_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "unno",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "mp", 
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "sg",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "lq", 
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "temp",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "vent",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "remark",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "vo_id",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "stow",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true,
					"mty_bkg_cd", false, "", dfNone, 0, false, false);

			CountPosition = 0;
		}
		break;
		
	case "sheet10": // sheet10 init
		with (sheetObj) {
	
			// 높이 설정
			style.height = 200;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;
	
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(24, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle1 = "|Seq.|CGO TYPE|BKG No.|TS|POD|BLCK\nSTWG|MLB|CS1|Container No.|TP|CS2|WGT|CLASS|UNNO.|MP|SG|LQ|TEMP|VENT|REMARK(DG&AK)|VOID(FEU)|STOW|";
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "bkg_no2",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "seq",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "cgo_type", 
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenterTop, true, "bkg_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "ts",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "pod",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "bkg_bs",
					false, "", dfNone, 0, false, false); // 2014.10.01 CHM-201432082
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "blck_stwg_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cs", 
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "cntr_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "tp", 
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cs2",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daRight, true, "wgt", 
					false, "", dfNullFloatOrg, 1, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "class_cd",
					false, "", dfNone, 0, false, false);
	
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "unno",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "mp", 
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "sg",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "lq",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "temp",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "vent",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "remark",
					false, "", dfNone, 0, false, false);
	
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "vo_id",
					false, "", dfNullFloatOrg, 1, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "stow",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true,
					"mty_bkg_cd", false, "", dfNone, 0, false, false);
	
			CountPosition = 0;
		}
		break;
	case "sheet11": // sheet11 init
		with (sheetObj) {
	
			// 높이 설정
			style.height = 180;
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
			InitRowInfo(2, 1, 2, 100);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(14, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);
	
			var HeadTitle1 = "POD|BLCK\nSTWG|DG|DG|DG|RF|RF|RF|AK|AK|AK|BB|BB|BB";
			var HeadTitle2 = "POD|BLCK\nSTWG|20FT|40FT|40H|20FT|40FT|40H|20FT|40FT|40H|20FT|40FT|40H";
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtAutoSum, 135, daCenter, true,
					"pod_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 135, daCenter, true, "bkg_bs",
					false, "", dfNone, 0, false, false);  // 2014.10.01 CHM-201432082
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "dg_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "dg_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "dg_45",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "rf_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "rf_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "rf_45",
					false, "", dfNone, 0, false, false);
	
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "ak_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "ak_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "ak_45",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "bb2",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "bb4",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 70, daCenter, true, "bb45",
					false, "", dfNone, 0, false, false);
	
			CountPosition = 0;
		}
		break;
		
	case "sheet12": // sheet12 init
		with (sheetObj) {
	
			// 높이 설정
			style.height = 200;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;
	
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(7, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle1 = "CGO TYPE|POD|BLCK\nSTWG|MLB|CNTR|TYPE|DETAIL";
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "e_cgo_type",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "e_pod",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "e_bkg_bs",
					false, "", dfNone, 0, false, false);   // 2014.10.01 CHM-201432082
			InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "e_mlb",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 120, daCenterTop, true, "e_cntr_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "e_tp",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "e_detail",
					false, "", dfNone, 0, false, false);
	
			CountPosition = 0;
		}
		break;
	
	case "sheet13": // sheet13 init
		with (sheetObj) {
	
			// 높이 설정
			style.height = 200;
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
			InitRowInfo(1, 1, 2, 100);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(23, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle1 = "Seq.|CGO TYPE|BKG No.|TS|POD|BLCK\nSTWG|MLB|CS1|Container No.|TP|CS2|WGT|CLASS|UNNO.|MP|SG|LQ|TEMP|VENT|REMARK(DG&AK)|VOID|STOW|";
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "seq",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "cgo_type", 
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "bkg_no",
					false, "", dfNone, 0, false, false); 
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "ts",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "pod",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "bkg_bs",
					false, "", dfNone, 0, false, false);  // 2014.10.01 CHM-201432082
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "blck_stwg_cd",
					false, "", dfNone, 0, false, false);
	
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cs1",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cntr_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "tp", false,
					"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cs2",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daRight, true, "wgt", false,
					"", dfNullFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "class_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "unno",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "mp", 
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "sg",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "lq", 
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "temp",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "vent",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "remark",
					false, "", dfNone, 0, false, false);
	
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "vo_id",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "stow",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true,
					"mty_bkg_cd", false, "", dfNone, 0, false, false);
	
			CountPosition = 0;
		}
		break;
		
	case "sheet14":
		with (sheetObj) {

			// 높이 설정
			style.height = 302;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 13, 100);

			var HeadTitle1 = "Seq.|Container No.|TP|BKG No.|F/M|Seal No.|Weight|VGM|VGM|VGM Signature|VGM Method|R/D|TS|Special Cargo|Special Cargo|Stow|PC|POD|BLCK\nSTWG|MLB|A.POD|T/S VVD";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			// InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false,
			// "ibflag");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "seq",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "cntr_no",
					false, "", dfNone, 0, false, true, 11);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"cntr_tpsz_cd", false, "", dfNone, 0, false, true, 2);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "bkg_no",
					false, "", dfNone, 0, false, true, 11); 
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"mty_bkg_cd", false, "", dfNone, 0, false, true, 1);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "seal_no",
					false, "", dfNone, 0, false, true, 15);
			InitDataProperty(0, cnt++, dtData, 50, daRight, false, "bl_wgt",
					false, "", dfNullInteger, 0, false, true, 5);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "vgm_wgt", false, "", dfNullInteger, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daRight, false, "vgm_wgt_ut_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "vgm_vrfy_sig_ctnt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "vgm_mzd_tp_cd", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"rcv_term_cd", false, "", dfNone, 0, false, true, 2);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "ts_flg",
					false, "", dfNone, 0, false, true, 2);
			InitDataProperty(0, cnt++, dtData, 180, daCenter, false,
					"cll_rmk1", false, "", dfNone, 0, false, true, 100);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "cll_rmk2",
					false, "", dfNone, 0, false, true, 100);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "stwg_cd",
					false, "", dfNone, 0, false, true, 3);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"kr_tml_prct_id", false, "", dfNone, 0, false, true, 1);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "pod_cd",
					false, "", dfNone, 0, false, true, 5);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "bc_cd",
					false, "", dfNone, 0, false, true, 3); // Add. 2014.09.02 CHM-201431700
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false,
					"blck_stwg_cd", false, "", dfNone, 0, false, true, 3);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "a_pod_cd",
					false, "", dfNone, 0, false, true, 5);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false,
					"ts_vvd_cd", false, "", dfNone, 0, false, true, 9);

			CountPosition = 0;
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
	case IBSEARCH: // 조회

		formObj.f_cmd.value = SEARCH;
		sheetObj.WaitImageVisible = false;	
		sheetObjects[1].WaitImageVisible = false;	
		sheetObjects[2].WaitImageVisible = false;	
		ComOpenWait(true);
		var inByType = "";
		if (formObj.in_by_type_temp(0).checked)
			inByType = "P";
		//else if (formObj.in_by_type_temp(1).checked)
		//	inByType = "A";
		else if (formObj.in_by_type_temp(1).checked)
			inByType = "M";

		formObj.in_by_type.value = inByType;

		var sXml = sheetObj.GetSearchXml("ESM_BKG_0932GS.do",
				FormQueryString(formObj));

		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0) {
			sheetObjects[0].LoadSearchXml(arrXml[0]);
		}
		if (arrXml.length > 1) {
			sheetObjects[1].LoadSearchXml(arrXml[1]);
		}
		if (arrXml.length > 2) {
			sheetObjects[2].LoadSearchXml(arrXml[2]);
		}
		if (arrXml.length > 3) {
			sheetObjects[3].LoadSearchXml(arrXml[3]);
		}
		if (arrXml.length > 4) {
			sheetObjects[4].LoadSearchXml(arrXml[4]);
		}		
		ComEtcDataToForm(formObj, sheetObj);

		state = sheetObj.EtcData("TRANS_RESULT_KEY");

		if (state == "S") {
			if (document.form.vvd_cd_nm.value != "") {
				ComBtnEnable("btn_print");
			}
			//sheetObjects[0].SelectCell(10, "gubun_cd", false, ""); 
			if (sheetObjects[0].rowCount > 0) {
				//sheetObj.DataInsert(-1);
				var lo_20 = 0, lo_40 = 0, lo_40h = 0, lo_45 = 0;
				var ts_20 = 0, ts_40 = 0, ts_40h = 0, ts_45 = 0;
				var mt_20 = 0, mt_40 = 0, mt_40h = 0, mt_45 = 0;
				var sm_20 = 0, sm_40 = 0, sm_40h = 0, sm_45 = 0;
				var wgt = 0;

				for ( var i = 2; i < sheetObjects[0].rowCount + 2; i++) {
					lo_20 = lo_20 + sheetObjects[0].CellValue(i, "local_20")
							* 1;
					lo_40 = lo_40 + sheetObjects[0].CellValue(i, "local_40")
							* 1;
					lo_40h = lo_40h + sheetObjects[0].CellValue(i, "local_40h")
							* 1;
					lo_45 = lo_45 + sheetObjects[0].CellValue(i, "local_45")
							* 1;

					ts_20 = ts_20 + sheetObjects[0].CellValue(i, "ts_20") * 1;
					ts_40 = ts_40 + sheetObjects[0].CellValue(i, "ts_40") * 1;
					ts_40h = ts_40h + sheetObjects[0].CellValue(i, "ts_40h")
							* 1;
					ts_45 = ts_45 + sheetObjects[0].CellValue(i, "ts_45") * 1;

					mt_20 = mt_20 + sheetObjects[0].CellValue(i, "mty_20") * 1;
					mt_40 = mt_40 + sheetObjects[0].CellValue(i, "mty_40") * 1;
					mt_40h = mt_40h + sheetObjects[0].CellValue(i, "mty_40h")
							* 1;
					mt_45 = mt_45 + sheetObjects[0].CellValue(i, "mty_45") * 1;

					sm_20 = sm_20 + sheetObjects[0].CellValue(i, "sum_20") * 1;
					sm_40 = sm_40 + sheetObjects[0].CellValue(i, "sum_40") * 1;
					sm_40h = sm_40h + sheetObjects[0].CellValue(i, "sum_40h")
							* 1;
					sm_45 = sm_45 + sheetObjects[0].CellValue(i, "sum_45") * 1;
					wgt = wgt + sheetObjects[0].CellValue(i, "wgt_mt") * 1;
				}

				formObj.local_20.value = lo_20;
				formObj.local_40.value = lo_40 + lo_40h + lo_45;
				formObj.ts_20.value = ts_20;
				formObj.ts_40.value = ts_40 + ts_40h + ts_45;
				formObj.mt_20.value = mt_20;
				formObj.mt_40.value = mt_40 + mt_40h + mt_45;
				formObj.sm_20.value = sm_20;
				formObj.sm_40.value = sm_40 + sm_40h + sm_45;
				formObj.local.value = lo_20 + lo_40 + lo_40h + lo_45;
				formObj.ts.value = ts_20 + ts_40 + ts_40h + ts_45;
				formObj.mt.value = mt_20 + mt_40 + mt_40h + mt_45;
				formObj.sm.value = sm_20 + sm_40 + sm_40h + sm_45;
			}
			
			var status1 = false;
			//headline1, 2
			for ( var i =sheetObjects[0].HeaderRows ; i < sheetObjects[0].HeaderRows+sheetObjects[0].RowCount; i++) {
			//	alert ("gubun_cd2" + sheetObjects[0].CellValue(i, "gubun_cd2")+ " POD: " +sheetObjects[0].CellValue(i, "gubun_cd"));
				if (sheetObjects[0].CellValue(i, "gubun_cd2") != "") {
					status1 = true;
					break;
				}
			}
			//alert(status1);
			if (!status1) {
				sheetObjects[0].ColHidden("gubun_cd2") = true;
			} else {
				sheetObjects[0].ColHidden("gubun_cd2") = false;
				
				//Start. 2014.08.25 CHM-201431700 Hannah Lee
				if(formObj.in_by_type.value =="P"){
					var HeadTitle1 = "POD|BLCK\nSTWG|Local|Local|Local|Local|T/S|T/S|T/S|T/S|Empty|Empty|Empty|Empty|Total|Total|Total|Total|Weight(KGS)";
					var HeadTitle2 = "POD|BLCK\nSTWG|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|Weight(KGS)";
					
					sheetObjects[0].InitHeadRow(0, HeadTitle1, true);
					sheetObjects[0].InitHeadRow(1, HeadTitle2, true);
					
				}// End. 
				
			}

			var status2 = false;
	
			for ( var i =sheetObjects[1].HeaderRows ; i < sheetObjects[1].HeaderRows+sheetObjects[1].RowCount; i++) {
			//	alert ("gubun_cd" + sheetObjects[1].CellValue(i, "gubun_cd")+ " POD: " +sheetObjects[1].CellValue(i, "gubun_cd2"));
				
				if (sheetObjects[1].CellValue(i, "gubun_cd") != "") {
					status2 = true;
					break;
				}
			}
			//alert(status2);
			if (!status2) {
				sheetObjects[1].ColHidden("gubun_cd") = true;
			} else {
				sheetObjects[1].ColHidden("gubun_cd") = false;
				
				//Start. 2014.08.25 CHM-201431700 Hannah Lee
				if(formObj.in_by_type.value =="P"){
					var HeadTitle1 = "POD|BLCK\nSTWG|Local|Local|Local|Local|Local|Local|Local|Local|Local|Local|Local|Local|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|Total|Total|Total|Total|Total|Total|Total|Total|Total|Total|Total|Total";
					var HeadTitle2 = "POD|BLCK\nSTWG|DG|DG|DG|RF|RF|RF|FR|FR|FR|O/T|O/T|O/T|DG|DG|DG|RF|RF|RF|FR|FR|FR|O/T|O/T|O/T|DG|DG|DG|RF|RF|RF|FR|FR|FR|O/T|O/T|O/T";
					var HeadTitle3 = "POD|BLCK\nSTWG|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H";
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					sheetObjects[1].InitHeadRow(0, HeadTitle1, true);
					sheetObjects[1].InitHeadRow(1, HeadTitle2, true);
					sheetObjects[1].InitHeadRow(2, HeadTitle3, true);
				
				}// End. 	
			}

			var status3 = false;
		//	for ( var i = 2; i < sheetObjects[2].RowCount; i++) {
			for ( var i =sheetObjects[2].HeaderRows ; i < sheetObjects[2].HeaderRows+sheetObjects[2].RowCount; i++) {
				
				//alert ( " POD: " +sheetObjects[2].CellValue(i, "gubun_cd3") + " blck_stwg_cd: " +sheetObjects[2].CellValue(i, "blck_stwg_cd"));
				if (sheetObjects[2].CellValue(i, "blck_stwg_cd") != "") {
					status3 = true;
					break;
					
				}
			}
			if (!status3) {
				sheetObjects[2].ColHidden("blck_stwg_cd") = true;
			} else {
				sheetObjects[2].ColHidden("blck_stwg_cd") = false;
				
				//Start. 2014.08.25 CHM-201431700 Hannah Lee
				if(formObj.in_by_type.value =="P"){
					var HeadTitle1 = "POD|BLCK\nSTWG|AB|AB|AB|AB|" +
									"AF|AF|AF|AF|" +
									"AL|AL|AL|AL|" +
									"BC|BC|BC|BC|" +
									"MUPG|MUPG|MUPG|MUPG|" +
									"OD|OD|OD|OD|" +
									"OBSS|OBSS|OBSS|OBSS|" +
									"OLBS|OLBS|OLBS|OLBS|" +
									"OLBL|OLBL|OLBL|OLBL|" +									
									"ODAB|ODAB|ODAB|ODAB";
					var HeadTitle2 = "POD|BLCK\nSTWG|20|40|40H|45|" +
									"20|40|40H|45|" +
									"20|40|40H|45|" +
									"20|40|40H|45|" +
									"20|40|40H|45|" +
									"20|40|40H|45|" +
									"20|40|40H|45|" +
									"20|40|40H|45|" +
									"20|40|40H|45|" +									
									"20|40|40H|45";
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					sheetObjects[2].InitHeadRow(0, HeadTitle1, true);
					sheetObjects[2].InitHeadRow(1, HeadTitle2, true);
				}// End.
			}
			
			var status4 = false;
//			for ( var i = 2; i < sheetObjects[3].RowCount; i++) {
			for ( var i =sheetObjects[3].HeaderRows ; i < sheetObjects[3].HeaderRows+sheetObjects[3].RowCount; i++) {
				if (sheetObjects[3].CellValue(i, "blck_stwg_cd") != "") {
					status4 = true;
					break;
				}
			}
			if (!status4) {
				sheetObjects[3].ColHidden("blck_stwg_cd") = true;
			} else {
				sheetObjects[3].ColHidden("blck_stwg_cd") = false;
				
				//Start. 2014.08.25 CHM-201431700 Hannah Lee
				if(formObj.in_by_type.value =="P"){
					var HeadTitle1 = "POD|BLCK\nSTWG|ODAL|ODAL|ODAL|ODAL|ODBC|ODBC|ODBC|ODBC|ODET|ODET|ODET|ODET|ODFT|ODFT|ODFT|ODFT|ODHD|ODHD|ODHD|ODHD|OP|OP|OP|OP|OT|OT|OT|OT|OTNO|OTNO|OTNO|OTNO|PC|PC|PC|PC";
					var HeadTitle2 = "POD|BLCK\nSTWG|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45";
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					sheetObjects[3].InitHeadRow(0, HeadTitle1, true);
					sheetObjects[3].InitHeadRow(1, HeadTitle2, true);
				}// End.
			}
			
			var status5 = false;
			//for ( var i = 2; i < sheetObjects[4].RowCount; i++) {
			for ( var i =sheetObjects[4].HeaderRows ; i < sheetObjects[4].HeaderRows+sheetObjects[4].RowCount; i++) {
				if (sheetObjects[4].CellValue(i, "blck_stwg_cd") != "") {
					status5 = true;
					break;
				}
			}
			if (!status5) {
				sheetObjects[4].ColHidden("blck_stwg_cd") = true;
			} else {
				sheetObjects[4].ColHidden("blck_stwg_cd") = false;
				
				//Start. 2014.08.25 CHM-201431700 Hannah Lee
				if(formObj.in_by_type.value =="P"){
					var HeadTitle1 = "POD|BLCK\nSTWG|PCOD|PCOD|PCOD|PCOD|TS|TS|TS|TS|OLBP|OLBP|OLBP|OLBP|UD|UD|UD|UD|UDAB|UDAB|UDAB|UDAB|UDMX|UDMX|UDMX|UDMX|UT|UT|UT|UT|UTAB|UTAB|UTAB|UTAB|UW|UW|UW|UW";
					var HeadTitle2 = "POD|BLCK\nSTWG|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45";
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					sheetObjects[4].InitHeadRow(0, HeadTitle1, true);
					sheetObjects[4].InitHeadRow(1, HeadTitle2, true);
				}// End.
			}			
		}
		ComOpenWait(false);
		break;

	case COMMAND01: // 입력
		var sUrl = "/hanjin/ESM_BKG_0925.do?pgmNo=ESM_BKG_0925&vvd="
				+ formObj.in_vvd_cd.value + "&vps_etd_dt="
				+ formObj.vps_etd.value.substring(0, 10) + "&loc_cd="
				+ formObj.in_pol_cd.value + "&loc_yd_cd="
				+ formObj.in_pol_yd_cd.value + "&disc_load_cd=L";
		ComOpenWindowCenter(sUrl, "ESM_BKG_0925", 600, 400, false);
		break;

	case COMMAND02: // 입력
		var sUrl = "/hanjin/ESM_BKG_0933.do?inVvdCd=" + formObj.in_vvd_cd.value
				+ "&inPolCcd=" + formObj.in_pol_cd.value + "&inPolYdCd="
				+ formObj.in_pol_yd_cd.value + "&inCllType="
				+ formObj.in_cll_type.value + "&inBkgStsCd="
				+ formObj.in_bkg_sts_cd.value + "&inCntrCfmFlg="
				+ formObj.in_cntr_cfm_flg.value + "&inSortType="
				+ formObj.in_sort_type.value
		location.href = sUrl;
		break;

	case COMMAND03: // 입력
		ComOpenWindowCenter("/hanjin/ESM_BKG_5007.do?pgmNo=ESM_BKG_5007",
				"5007", 1020, 690, false);

		break;
		
	case COMMAND04:
		formObj.f_cmd.value = SEARCH01;
		sheetObj.WaitImageVisible = false;	
		sheetObjects[1].WaitImageVisible = false;	
		ComOpenWait(true);
		// LOCAL
		var inByType = "LOCAL";

		formObj.in_by_type.value = inByType;
		// alert();
		var sXml = sheetObjects[5].GetSearchXml("ESM_BKG_0932GS.do",
				FormQueryString(formObj));
		
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0) {
			sheetObjects[5].LoadSearchXml(arrXml[0]);
			sheetObjects[6].LoadSearchXml(arrXml[1]);
			sheetObjects[7].LoadSearchXml(arrXml[2]);
			sheetObjects[8].LoadSearchXml(arrXml[0]);
		}
			
		ComEtcDataToForm(formObj, sheetObjects[5]);

		state = sheetObjects[5].EtcData("TRANS_RESULT_KEY");

		if (state == "S") {
			var d2 = 0;
			var d4 = 0;
			var d5 = 0;
			var d7 = 0;
			var d8 = 0;
			var d9 = 0;
			var dw = 0;
			var dx = 0;
			var r2 = 0;
			var r4 = 0;
			var r5 = 0;
			var f2 = 0;
			var f4 = 0;
			var f5 = 0;
			var o2 = 0;
			var o4 = 0;
			var o5 = 0;
			var s2 = 0;
			var s4 = 0;
			var t2 = 0;
			var t4 = 0;
			var a2 = 0;
			var a4 = 0;
			var a5 = 0;
			var p2 = 0;
			var p4 = 0;
			var z2 = 0;
			var z4 = 0;
			var d3 = 0;
			var r9 = 0;
			var etc = 0;
			var totalTpSize = 0;
			var local = 0;
			var localFull = 0;
			var localEmpty = 0;
			var ts = 0;
			var tsFull = 0;
			var tsEmpty = 0;
			var wgt = 0;
			var cntrNo = "";
			for ( var i = 1; i <= sheetObjects[5].RowCount; i++) {
				if (sheetObjects[5].CellValue(i, "seq") == "") {
					sheetObjects[5].RowEditable(i) = false;
				}
				if (sheetObjects[5].CellValue(i, "tp") == "D2") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						d2 = d2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "D4") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						d4 = d4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "D5") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						d5 = d5 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "D7") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						d7 = d7 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "D8") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						d8 = d8 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "D9") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						d9 = d9 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "DW") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						dw = dw + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "DX") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						dx = dx + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "R2") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						r2 = r2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "R4") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						r4 = r4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "R5") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						r5 = r5 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "F2") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						f2 = f2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "F4") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						f4 = f4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "F5") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						f5 = f5 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "O2") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						o2 = o2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "O4") {
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						o4 = o4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "O5") {
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						o5 = o5 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "S2") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						s2 = s2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "S4") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						s4 = s4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "T2") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						t2 = t2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "T4") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						t4 = t4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "A2") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						a2 = a2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
					}
					wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "A4") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						a4 = a4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "A5") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						a5 = a5 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "P2") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						p2 = p2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "P4") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						p4 = p4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "Z2") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						z2 = z2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "Z4") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						z4 = z4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "D3") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						d3 = d3 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[5].CellValue(i, "tp") == "R9") {
					
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						r9 = r9 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
					}
					
				}
				else {
					if (sheetObjects[5].CellValue(i, "tp") != ""){
						if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
							etc = etc + 1;
							totalTpSize = totalTpSize + 1;
							cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
							wgt = wgt + sheetObjects[5].CellValue(i, "wgt") * 1;
						}
					}
				}

			}
			
			cntrNo = "";
			for ( var i = 1; i <= sheetObjects[5].RowCount; i++) {
				
				if (sheetObjects[5].CellValue(i, "ts") == "TS"
					|| sheetObjects[5].CellValue(i, "ts") == "TT") {
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						ts = ts + 1;
						if (sheetObjects[5].CellValue(i, "mty_bkg_cd") == "F")
							tsFull = tsFull + 1;
						else
							tsEmpty = tsEmpty + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
					}
				}
				if (sheetObjects[5].CellValue(i, "ts") == ""
						&& sheetObjects[5].CellValue(i, "seq") != "") {
					if (cntrNo != sheetObjects[5].CellValue(i, "cntr_no")) {
						local = local + 1;
						if (sheetObjects[5].CellValue(i, "mty_bkg_cd") == "F")
							localFull = localFull + 1;
						else
							localEmpty = localEmpty + 1;
						cntrNo = sheetObjects[5].CellValue(i, "cntr_no");
					}
				}				
			}
			//alert(wgt);
			formObj.local_d2.value = d2;
			formObj.local_d4.value = d4;
			formObj.local_d5.value = d5;
			formObj.local_d7.value = d7;
			formObj.local_d8.value = d8;
			formObj.local_d9.value = d9;
			formObj.local_dw.value = dw;
			formObj.local_dx.value = dx;
			formObj.local_r2.value = r2;
			formObj.local_r4.value = r4;
			formObj.local_r5.value = r5;
			formObj.local_f2.value = f2;
			formObj.local_f4.value = f4;
			formObj.local_f5.value = f5;
			formObj.local_o2.value = o2;
			formObj.local_o4.value = o4;
			formObj.local_o5.value = o5;
			formObj.local_s2.value = s2;
			formObj.local_s4.value = s4;
			formObj.local_t2.value = t2;
			formObj.local_t4.value = t4;
			formObj.local_a2.value = a2;
			formObj.local_a4.value = a4;
			formObj.local_a5.value = a5;
			formObj.local_p2.value = p2;
			formObj.local_p4.value = p4;
			formObj.local_z2.value = z2;
			formObj.local_z4.value = z4;
			formObj.local_d3.value = d3;
			formObj.local_r9.value = r9;
			formObj.local_etc.value = etc;
			formObj.local_totalTpSize.value = totalTpSize;
			formObj.local_local.value = local;
			formObj.local_localFull.value = localFull;
			formObj.local_localEmpty.value = localEmpty;
			formObj.local_ts.value = ts;
			formObj.local_tsFull.value = tsFull;
			formObj.local_tsEmpty.value = tsEmpty;
			formObj.local_wgt.value = wgt;

			formObj.local_wgt.value = ComGetMaskedValue(formObj.local_wgt.value, 'int');

			for ( var i = 1; i <= sheetObjects[5].RowCount; i++) {
				if (sheetObjects[5].CellValue(i, "tp") == "") {
					sheetObjects[5].RowBackColor(i) = sheetObjects[5].RgbColor(192, 192, 192);
				}
			}
		}
		
		// T/S
		formObj.f_cmd.value = SEARCH01;
		inByType = "TS";
		formObj.in_by_type.value = inByType;
		// alert();
		var sXml = sheetObjects[9].GetSearchXml("ESM_BKG_0932GS.do",
				FormQueryString(formObj));

		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0) {
			sheetObjects[9].LoadSearchXml(arrXml[0]);
			sheetObjects[10].LoadSearchXml(arrXml[1]);
			sheetObjects[11].LoadSearchXml(arrXml[2]);
			sheetObjects[12].LoadSearchXml(arrXml[0]);
		}
			
		ComEtcDataToForm(formObj, sheetObjects[9]);

		state = sheetObjects[9].EtcData("TRANS_RESULT_KEY");

		if (state == "S") {
			var d2 = 0;
			var d4 = 0;
			var d5 = 0;
			var d7 = 0;
			var d8 = 0;
			var d9 = 0;
			var dw = 0;
			var dx = 0;
			var r2 = 0;
			var r4 = 0;
			var r5 = 0;
			var f2 = 0;
			var f4 = 0;
			var f5 = 0;
			var o2 = 0;
			var o4 = 0;
			var o5 = 0;
			var s2 = 0;
			var s4 = 0;
			var t2 = 0;
			var t4 = 0;
			var a2 = 0;
			var a4 = 0;
			var a5 = 0;
			var p2 = 0;
			var p4 = 0;
			var z2 = 0;
			var z4 = 0;
			var d3 = 0;
			var r9 = 0;
			var etc = 0;
			var totalTpSize = 0;
			var local = 0;
			var localFull = 0;
			var localEmpty = 0;
			var ts = 0;
			var tsFull = 0;
			var tsEmpty = 0;
			var wgt = 0;
			var cntrNo = "";
			for ( var i = 1; i <= sheetObjects[9].RowCount; i++) {
				if (sheetObjects[9].CellValue(i, "seq") == "") {
					sheetObjects[9].RowEditable(i) = false;
				}
				if (sheetObjects[9].CellValue(i, "tp") == "D2") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						d2 = d2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "D4") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						d4 = d4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "D5") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						d5 = d5 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "D7") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						d7 = d7 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "D8") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						d8 = d8 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "D9") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						d9 = d9 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "DW") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						dw = dw + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "DX") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						dx = dx + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "R2") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						r2 = r2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "R4") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						r4 = r4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "R5") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						r5 = r5 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "F2") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						f2 = f2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "F4") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						f4 = f4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "F5") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						f5 = f5 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "O2") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						o2 = o2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "O4") {
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						o4 = o4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "O5") {
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						o5 = o5 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "S2") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						s2 = s2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "S4") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						s4 = s4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "T2") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						t2 = t2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "T4") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						t4 = t4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "A2") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						a2 = a2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
					}
					wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "A4") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						a4 = a4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "A5") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						a5 = a5 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "P2") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						p2 = p2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "P4") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						p4 = p4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "Z2") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						z2 = z2 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "Z4") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						z4 = z4 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "D3") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						d3 = d3 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else if (sheetObjects[9].CellValue(i, "tp") == "R9") {
					
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						r9 = r9 + 1;
						totalTpSize = totalTpSize + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
						wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
					}
					
				}
				else {
					if (sheetObjects[9].CellValue(i, "tp") != ""){
						if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
							etc = etc + 1;
							totalTpSize = totalTpSize + 1;
							cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
							wgt = wgt + sheetObjects[9].CellValue(i, "wgt") * 1;
						}
					}
				}

			}
			
			cntrNo = "";
			for ( var i = 1; i <= sheetObjects[9].RowCount; i++) {
				
				if (sheetObjects[9].CellValue(i, "ts") == "TS"
					|| sheetObjects[9].CellValue(i, "ts") == "TT") {
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						ts = ts + 1;
						if (sheetObjects[9].CellValue(i, "mty_bkg_cd") == "F")
							tsFull = tsFull + 1;
						else
							tsEmpty = tsEmpty + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
					}
				}
				if (sheetObjects[9].CellValue(i, "ts") == ""
						&& sheetObjects[9].CellValue(i, "seq") != "") {
					if (cntrNo != sheetObjects[9].CellValue(i, "cntr_no")) {
						local = local + 1;
						if (sheetObjects[9].CellValue(i, "mty_bkg_cd") == "F")
							localFull = localFull + 1;
						else
							localEmpty = localEmpty + 1;
						cntrNo = sheetObjects[9].CellValue(i, "cntr_no");
					}
				}				
			}
			//alert(wgt);
			formObj.ts_d2.value = d2;
			formObj.ts_d4.value = d4;
			formObj.ts_d5.value = d5;
			formObj.ts_d7.value = d7;
			formObj.ts_d8.value = d8;
			formObj.ts_d9.value = d9;
			formObj.ts_dw.value = dw;
			formObj.ts_dx.value = dx;
			formObj.ts_r2.value = r2;
			formObj.ts_r4.value = r4;
			formObj.ts_r5.value = r5;
			formObj.ts_f2.value = f2;
			formObj.ts_f4.value = f4;
			formObj.ts_f5.value = f5;
			formObj.ts_o2.value = o2;
			formObj.ts_o4.value = o4;
			formObj.ts_o5.value = o5;
			formObj.ts_s2.value = s2;
			formObj.ts_s4.value = s4;
			formObj.ts_t2.value = t2;
			formObj.ts_t4.value = t4;
			formObj.ts_a2.value = a2;
			formObj.ts_a4.value = a4;
			formObj.ts_a5.value = a5;
			formObj.ts_p2.value = p2;
			formObj.ts_p4.value = p4;
			formObj.ts_z2.value = z2;
			formObj.ts_z4.value = z4;
			formObj.ts_d3.value = d3;
			formObj.ts_r9.value = r9;
			formObj.ts_etc.value = etc;
			formObj.ts_totalTpSize.value = totalTpSize;
			formObj.ts_local.value = local;
			formObj.ts_localFull.value = localFull;
			formObj.ts_localEmpty.value = localEmpty;
			formObj.ts_ts.value = ts;
			formObj.ts_tsFull.value = tsFull;
			formObj.ts_tsEmpty.value = tsEmpty;
			formObj.ts_wgt.value = wgt;

			formObj.ts_wgt.value = ComGetMaskedValue(formObj.ts_wgt.value, 'int');

			for ( var i = 1; i <= sheetObjects[9].RowCount; i++) {
				if (sheetObjects[9].CellValue(i, "tp") == "") {
					sheetObjects[9].RowBackColor(i) = sheetObjects[9].RgbColor(192, 192, 192);
				}
			}
		}
		var inByType = "";
		if (formObj.in_by_type_temp(0).checked)
			inByType = "P";
		else if (formObj.in_by_type_temp(1).checked)
			inByType = "M";
		formObj.in_by_type.value = inByType;
		
		//Print_Preview
		formObj.f_cmd.value = SEARCH02;
		formObj.in_sort_type.value = "5";
		sheetObjects[13].DoSearch("ESM_BKG_0932GS.do", FormQueryString(formObj));
		ComEtcDataToForm(formObj, sheetObjects[13]);

		state = sheetObjects[13].EtcData("TRANS_RESULT_KEY");

		if (state == "S") {
			var d2 = 0;
			var d4 = 0;
			var d5 = 0;
			var d7 = 0;
			var d8 = 0;
			var d9 = 0;
			var dw = 0;
			var dx = 0;
			var r2 = 0;
			var r4 = 0;
			var r5 = 0;
			var f2 = 0;
			var f4 = 0;
			var f5 = 0;
			var o2 = 0;
			var o4 = 0;
			var o5 = 0;
			var s2 = 0;
			var s4 = 0;
			var t2 = 0;
			var t4 = 0;
			var a2 = 0;
			var a4 = 0;
			var a5 = 0;
			var p2 = 0;
			var p4 = 0;
			var z2 = 0;
			var z4 = 0;
			var d3 = 0;
			var r9 = 0;
			var etc = 0;
			var totalTpSize = 0;
			var local = 0;
			var localFull = 0;
			var localEmpty = 0;
			var ts = 0;
			var tsFull = 0;
			var tsEmpty = 0;
			var wgt = 0;
			for ( var i = 1; i <= sheetObjects[13].RowCount; i++) {
				if (sheetObjects[13].CellValue(i, "seq") == "") {
					sheetObjects[13].RowEditable(i) = false;
				}
				if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "D2") {
					d2 = d2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "D4") {
					d4 = d4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "D5") {
					d5 = d5 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "D7") {
					d7 = d7 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "D8") {
					d8 = d8 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "D9") {
					d9 = d9 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "DW") {
					dw = dw + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "DX") {
					dx = dx + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "R2") {
					r2 = r2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "R4") {
					r4 = r4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "R5") {
					r5 = r5 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "F2") {
					f2 = f2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "F4") {
					f4 = f4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "F5") {
					f5 = f5 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "O2") {
					o2 = o2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "O4") {
					o4 = o4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "O5") {
					o5 = o5 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "S2") {
					s2 = s2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "S4") {
					s4 = s4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "T2") {
					t2 = t2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "T4") {
					t4 = t4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "A2") {
					a2 = a2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "A4") {
					a4 = a4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "A5") {
					a5 = a5 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "P2") {
					p2 = p2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "P4") {
					p4 = p4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "Z2") {
					z2 = z2 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "Z4") {
					z4 = z4 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "D3"){
					d3 = d3 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "R9"){
					r9 = r9 + 1;
					totalTpSize = totalTpSize + 1;
					wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
				}
				else{ 
					if(sheetObjects[13].CellValue(i, "cntr_tpsz_cd") != ""){
						etc = etc + 1;
						totalTpSize = totalTpSize + 1;
						wgt = wgt + sheetObjects[13].CellValue(i, "bl_wgt") * 1;
					}
				
				}
				

				if (formObj.in_cll_type.value == "TS") {
					if (sheetObjects[13].CellValue(i, "seq") != "") {
						ts = ts + 1;
						if (sheetObjects[13].CellValue(i, "mty_bkg_cd") == "F")
							tsFull = tsFull + 1;
						else
							tsEmpty = tsEmpty + 1;
					}
				} else {
					if (sheetObjects[13].CellValue(i, "ts_flg") == "TS"
							|| sheetObjects[13].CellValue(i, "ts_flg") == "TT") {
						ts = ts + 1;
						if (sheetObjects[13].CellValue(i, "mty_bkg_cd") == "F")
							tsFull = tsFull + 1;
						else
							tsEmpty = tsEmpty + 1;
					}
					if (sheetObjects[13].CellValue(i, "ts_flg") == ""
							&& sheetObjects[13].CellValue(i, "seq") != "") {
						local = local + 1;
						if (sheetObjects[13].CellValue(i, "mty_bkg_cd") == "F")
							localFull = localFull + 1;
						else
							localEmpty = localEmpty + 1;
					}
				}
			}
			formObj.preview_d2.value = d2;
			formObj.preview_d4.value = d4;
			formObj.preview_d5.value = d5;
			formObj.preview_d7.value = d7;
			formObj.preview_d8.value = d8;
			formObj.preview_d9.value = d9;
			formObj.preview_dw.value = dw;
			formObj.preview_dx.value = dx;
			formObj.preview_r2.value = r2;
			formObj.preview_r4.value = r4;
			formObj.preview_r5.value = r5;
			formObj.preview_f2.value = f2;
			formObj.preview_f4.value = f4;
			formObj.preview_f5.value = f5;
			formObj.preview_o2.value = o2;
			formObj.preview_o4.value = o4;
			formObj.preview_o5.value = o5;
			formObj.preview_s2.value = s2;
			formObj.preview_s4.value = s4;
			formObj.preview_t2.value = t2;
			formObj.preview_t4.value = t4;
			formObj.preview_a2.value = a2;
			formObj.preview_a4.value = a4;
			formObj.preview_a5.value = a5;
			formObj.preview_p2.value = p2;
			formObj.preview_p4.value = p4;
			formObj.preview_z2.value = z2;
			formObj.preview_z4.value = z4;
			formObj.preview_d3.value = d3;
			formObj.preview_r9.value = r9;
			formObj.preview_etc.value = etc;
			formObj.preview_totalTpSize.value = totalTpSize;
			formObj.preview_local.value = local;
			formObj.preview_localFull.value = localFull;
			formObj.preview_localEmpty.value = localEmpty;
			formObj.preview_ts.value = ts;
			formObj.preview_tsFull.value = tsFull;
			formObj.preview_tsEmpty.value = tsEmpty;
			formObj.preview_wgt.value = wgt;

			formObj.preview_wgt.value = ComGetMaskedValue(formObj.preview_wgt.value, 'int');

			for ( var i = 1; i <= sheetObjects[13].RowCount; i++) {
				if (sheetObjects[13].CellValue(i, "cntr_tpsz_cd") == "") {
					sheetObjects[13].RowBackColor(i) = sheetObjects[13].RgbColor(192, 192, 192);
				}
			}
		}
		ComOpenWait(false);
		ComOpenWindowCenter("/hanjin/ESM_BKG_5007.do?pgmNo=ESM_BKG_5007&typecode=ALL",
				"5007", 1020, 690, false);

		break;

	case IBSAVE: // 입력
		formObj.f_cmd.value = MULTI;
		formObj.set_to.value = formObj.setText1.value;
		formObj.set_fm.value = formObj.setText2.value;
		sheetObj.DoAllSave("ESM_BKG_0932GS.do", FormQueryString(formObj));
		break;

	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회

		return true;
		break;
	case IBSAVE: // 조회

		return true;
		break;
	case COMMAND01: // 조회

		return true;
		break;
	case IBDELETE: // 조회

		return true;
		break;
	}
}

/**
 * gubun값에 따라 조회 방법 변경
 * @param gubun gubun
 */
function goBySearch(gubun) {

	if (gubun == "P" || gubun == "A" || gubun == "M") {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		ComBtnEnable("btn_print");
	} else {
		doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
		ComBtnDisable("btn_print");
	}

	if (gubun == "P") {
		document.all["1pod"].style.display = "inline";
		document.all["2pod"].style.display = "inline";
		document.all["3pod"].style.display = "inline";
		document.all["1apod"].style.display = "none";
		document.all["2apod"].style.display = "none";
		document.all["3apod"].style.display = "none";
		document.all["1mlb"].style.display = "none";
		document.all["2mlb"].style.display = "none";
		document.all["3mlb"].style.display = "none";
	}
	if (gubun == "A") {
		document.all["1pod"].style.display = "none";
		document.all["2pod"].style.display = "none";
		document.all["3pod"].style.display = "none";
		document.all["1apod"].style.display = "inline";
		document.all["2apod"].style.display = "inline";
		document.all["3apod"].style.display = "inline";
		document.all["1mlb"].style.display = "none";
		document.all["2mlb"].style.display = "none";
		document.all["3mlb"].style.display = "none";

	}
	if (gubun == "M") {
		document.all["1pod"].style.display = "none";
		document.all["2pod"].style.display = "none";
		document.all["3pod"].style.display = "none";
		document.all["1apod"].style.display = "none";
		document.all["2apod"].style.display = "none";
		document.all["3apod"].style.display = "none";
		document.all["1mlb"].style.display = "inline";
		document.all["2mlb"].style.display = "inline";
		document.all["3mlb"].style.display = "inline";
	}
}

/**
 * 팝업 띄우기(ESM_BKG_1056)
 */
function popSelect() {
	var sUrl = "/hanjin/ESM_BKG_1056.do?pgmNo=ESM_BKG_1056&typecode=ALL";
	ComOpenWindowCenter(sUrl, "ESM_BKG_1056", 598, 350, false);
}

/* 개발자 작업 끝 */