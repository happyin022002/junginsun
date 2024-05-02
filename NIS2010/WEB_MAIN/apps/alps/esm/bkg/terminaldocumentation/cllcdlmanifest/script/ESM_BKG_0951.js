/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0951.js
 *@FileTitle : Load Summary by POD
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.28
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.07.28 김승민
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2012.09.21 김보배 [CHM-201220211] [BKG] Load Summary by POD 상 Special Stowage Type 추가
 * 2012.12.24 김보배 [CHM-201222011] [BKG] Load Summary by POD에 Special Stowage "MUPG" 추가 요청
 * 2012.12.24 김보배 [CHM-201222024] [BKG] Stowage code "MUPG" CLL  반영 요청
 * 2012.12.28 김보배 [CHM-201222025] [BKG] [Special Stowage Request Code] 간소화 및 HIDE CBF 미 반영 개정건
 * 2014.07.28 이한나 [CHM-201431212] Stowage : UDMX 추가에 따른 CLL 반영 요청
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
 * @class ESM_BKG_0951 : ESM_BKG_0951 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0951() {
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
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var state = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	var sheetObject4 = sheetObjects[3];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;

		case "btn_new":
			document.form.reset();
			sheetObject1.RemoveAll();
			sheetObject2.RemoveAll();
			sheetObject3.RemoveAll();
			// sheetObject4.RemoveAll();
			formObject.in_vvd_cd.focus();
			break;

		case "btn_Summary":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND04);
			break;

		case "btn_Special_CGO":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND05);
			break;
			
		case "btn_print":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND01);
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

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}

	//for (i = 0; i < sheetObjects.length; i++) {
	//	doActionIBSheet(sheetObjects[i], document.form, IBSEARCH);
	// }
	document.form.in_vvd_cd.focus();
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
	ComBtnDisable("btn_Summary");
	ComBtnDisable("btn_Special_CGO");
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
	var sheetid = sheetObj.id;
	switch (sheetid) {

	case "sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 122;
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
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "|POD|MLB|Local|Local|Local|Local|T/S|T/S|T/S|T/S|Empty|Empty|Empty|Empty|Total|Total|Total|Total|Weight (KGS)";
			var HeadTitle2 = "|POD|MLB|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|Weight (KGS)";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true); 

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 40, daCenter, true,
					"ibflag");

			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "pod_cd",
					false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "gubun_cd2",
					false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "lo_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "lo_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "lo_40h",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "lo_45",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "ts_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "ts_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "ts_40h",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "ts_45",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "mt_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "mt_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "mt_40h",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "mt_45",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "to_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "to_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "to_40h",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "to_45",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 60, daRight, true, "wgt_mt",
					false, "", dfFloat, 3, false, false);

			DataRowMerge(0) = true;
			CountPosition = 0;
			MessageText("Sum") = "Total";

		}
		break;

	case "sheet2":
		with (sheetObj) {
			// 높이 설정
			style.height = 162;
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
			InitRowInfo(3, 1, 3, 100);

			var HeadTitle1 = "|POD|MLB|Local|Local|Local|Local|Local|Local|Local|Local|Local|Local|Local|Local|Local|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|Total|Total|Total|Total|Total|Total|Total|Total|Total|Total|Total|Total|Total";
			var HeadTitle2 = "|POD|MLB|DG|DG|DG|RF|RF|RF|FR|FR|FR|OT|OT|OT|OT|DG|DG|DG|RF|RF|RF|FR|FR|FR|OT|OT|OT|OT|DG|DG|DG|RF|RF|RF|FR|FR|FR|OT|OT|OT|OT";
			var HeadTitle3 = "|POD|MLB|20|40|40H|20|40|40H|20|40|40H|20|40|40H|45|20|40|40H|20|40|40H|20|40|40H|20|40|40H|45|20|40|40H|20|40|40H|20|40|40H|20|40|40H|45";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			InitHeadRow(2, HeadTitle3, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 40, daCenter, true,
					"Status");

			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "pod_cd2",
					false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "gubun_cd",
					false, "", dfNone, 0, false, false);
			
			
			InitDataProperty(0, cnt++, dtAutoSum, 35, daRight, true, "d_lo_20",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daRight, true, "d_lo_40",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daRight, true,
					"d_lo_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"r_lo_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"r_lo_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"r_lo_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"f_lo_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"f_lo_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"f_lo_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"o_lo_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"o_lo_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"o_lo_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"o_lo_45", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"d_ts_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"d_ts_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"d_ts_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"r_ts_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"r_ts_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"r_ts_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"f_ts_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"f_ts_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"f_ts_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"o_ts_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"o_ts_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"o_ts_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"o_ts_45", false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"d_lo_ts_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"d_lo_ts_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"d_lo_ts_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"r_lo_ts_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"r_lo_ts_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"r_lo_ts_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"f_lo_ts_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"f_lo_ts_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"f_lo_ts_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"o_lo_ts_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"o_lo_ts_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"o_lo_ts_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 35, daCenter, true,
					"o_lo_ts_45", false, "", dfNone, 0, false, false);

			DataRowMerge(0) = true;
			CountPosition = 0;
			MessageText("Sum") = "Total";

		}
		break;

	case "sheet3": //sheet1 init
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

			var HeadTitle1 = "POD|MLB|AB|AB|AB|AB|" +
					"AF|AF|AF|AF|" +
					"AL|AL|AL|AL|" +
					"BC|BC|BC|BC|" +
					"MUPG|MUPG|MUPG|MUPG|" +
					"OD|OD|OD|OD|" +
					"OBSS|OBSS|OBSS|OBSS|" +
					"OBSG|OBSG|OBSG|OBSG|" +
					"ODAB|ODAB|ODAB|ODAB";
			var HeadTitle2 = "POD|MLB|20|40|40H|45|" +
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
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true,
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

			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "obsg_20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "obsg_40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "obsg_40h", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum, 45, daRight, true, "obsg_45", false, "", dfNone, 0, false, false);
			

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
	case "sheet4": //sheet1 init
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
		InitDataProperty(0, cnt++, dtData, 40, daCenter, true,
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
	case "sheet5": //sheet1 init
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
		InitColumnInfo(38, 2, 0, true); //34, 2, 0, true); // 2014.07.25 CSR

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
		InitDataProperty(0, cnt++, dtData, 40, daCenter, true,
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

		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH;
			sheetObj.WaitImageVisible = false;	
			ComOpenWait(true);
			
			var sParam = "";
			sParam += "&" + FormQueryString(formObj)
					+ "&" + "pgmNo=ESM_BKG_0951";
			
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0951GS.do", sParam);
			
//			var sXml = sheetObj.GetSearchXml("ESM_BKG_0951GS.do",
//					FormQueryString(formObj));
			
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0) {
				sheetObjects[0].LoadSearchXml(arrXml[0]);
			} else {
				sheetObjects[0].RemoveAll();
			}
			if (arrXml.length > 1) {
				sheetObjects[1].LoadSearchXml(arrXml[1]);
			} else {
				sheetObjects[1].RemoveAll();
			}
			if (arrXml.length > 2) {
				sheetObjects[2].LoadSearchXml(arrXml[2]);
			} else {
				sheetObjects[2].RemoveAll();
			}
			if (arrXml.length > 3) {
				sheetObjects[3].LoadSearchXml(arrXml[3]);
			} else {
				sheetObjects[3].RemoveAll();
			}
			if (arrXml.length > 4) {
				sheetObjects[4].LoadSearchXml(arrXml[4]);
			} else {
				sheetObjects[4].RemoveAll();
			}
			//formObj.shp_id_no.value = sheetObj.EtcData("shp_id_no");
			ComEtcDataToForm(formObj, sheetObj);

			state = sheetObj.EtcData("TRANS_RESULT_KEY");

			if (state == "S") {
				if (sheetObj.RowCount != 0) {
					if (document.form.in_vvd_cd.value != "") {
						//alert();
						ComBtnEnable("btn_print");
						ComBtnEnable("btn_Summary");
						ComBtnEnable("btn_Special_CGO");
						
					}
				} else {
					ComBtnDisable("btn_print");
					ComBtnDisable("btn_Summary");
					ComBtnDisable("btn_Special_CGO");
				}
			}
			ComOpenWait(false);
		}

		break;

	case COMMAND01: // 저장
		if (validateForm(sheetObj, formObj, sAction)) {
			var inVvdCd = formObj.in_vvd_cd.value;
			var inPolCd = formObj.in_pol_cd.value;
			var inPolYdCd = formObj.in_pol_yd_cd.value;
			var inBkgOfcCd = formObj.in_bkg_ofc_cd.value;
			var setText1 = formObj.setText1.value;
			var setText2 = formObj.setText2.value;
			var remark2 = formObj.remark.value;
			var remark = ComReplaceStr(remark2, "\r\n", "`");
			var vvdCd = formObj.vvd_cd.value;
			var unLocCd = formObj.un_loc_cd.value;
			var vpsEtdDt = formObj.vps_etd_dt.value;

			// var sUrl = "/hanjin/ESM_BKG_5011.do?inVvdCd=" + inVvdCd
			// + "&inPolCd=" + inPolCd + "&inPolYdCd=" + inPolYdCd
			// + "&inBkgOfcCd=" + inBkgOfcCd + "&setText1=" + setText1
			// + "&setText2=" + setText2 + "&remark=" + remark
			// + "&vvdCd=" + vvdCd + "&unLocCd=" + unLocCd
			// + "&vpsEtdDt=" + vpsEtdDt;
			// var sUrl = "/hanjin/ESM_BKG_0456.do?bl_no="+selectedBlNumber;
			// ComOpenWindowCenter(sUrl, "ESM_BKG_0458", 1024, 768, false);
			ComOpenWindowCenter("/hanjin/ESM_BKG_5011.do?pgmNo=ESM_BKG_5011",
					"ESM_BKG_5011", 1024, 600, false);

		}
		break;
		
	case COMMAND04: // Summary pop-up
		
		if(!validateForm(sheetObj, formObj, sAction))
			return;
		var sUrl = "/hanjin/ESM_BKG_0932.do?pgmNo=ESM_BKG_0951"
		+ "&inVvdCd=" + formObj.in_vvd_cd.value 
		+ "&inPolCcd=" + formObj.in_pol_cd.value 
		+ "&inPolYdCd=" + formObj.in_pol_yd_cd.value 
		+ "&inCllType=CLL";
		//		alert(sUrl);
		ComOpenWindow(sUrl, "ESM_BKG_0932",
				"width=1024,height=600,scrollbars=yes,resizable=yes", false);
		// location.href=sUrl;
		// ComOpenWindowCenter(sUrl, "ESM_BKG_0931", 1024, 600, false);

		break;


	case COMMAND05: // Special CGO pop-up

		if(!validateForm(sheetObj, formObj, sAction))
			return;
		var sUrl = "/hanjin/ESM_BKG_0933.do?pgmNo=ESM_BKG_0951"
		+ "&inVvdCd=" + formObj.in_vvd_cd.value 
		+ "&inPolCcd=" + formObj.in_pol_cd.value 
		+ "&inPolYdCd=" + formObj.in_pol_yd_cd.value
		+ "&inCllType=CLL";
//		 alert(sUrl);

		 ComOpenWindow(sUrl, "ESM_BKG_0933",
				"width=1024,height=600,scrollbars=yes", false);
		// location.href=sUrl;
		// ComOpenWindowCenter(sUrl, "ESM_BKG_0931", 1024, 600, false);

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
 * Tab 기본 설정 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {

			var cnt = 0;
			InsertTab(cnt++, "Container Info", -1);
			InsertTab(cnt++, "Customer Info", -1);
			InsertTab(cnt++, "Export No", -1);

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
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00251');
			formObj.in_vvd_cd.focus();
			return false;
		}

		if (formObj.in_pol_cd.value == ""
				|| formObj.in_pol_cd.value.length != 5) {
			ComShowCodeConfirm('BKG01101', 'POL');
			formObj.in_pol_cd.focus();
			return false;
		}
		return true;
		break;

	case COMMAND01: // 조회
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00251');
			formObj.in_vvd_cd.focus();
			return false;
		}

		if (formObj.in_pol_cd.value == ""
				|| formObj.in_pol_cd.value.length != 5) {
			ComShowCodeConfirm('BKG01101', 'POL');
			formObj.in_pol_cd.focus();
			return false;
		}
		return true;
		break;
		
case COMMAND04: // Summary pop-up
	if(formObj.in_vvd_cd.value == ""
			|| formObj.in_vvd_cd.value.length != 9){
		ComShowCodeMessage('BKG00710');
		formObj.in_vvd_cd.focus();
		return false;
	}

	if(formObj.in_pol_cd.value == ""
			|| formObj.in_pol_cd.value.length != 5){
		ComShowCodeMessage('BKG00711');
		formObj.in_pol_cd.focus();
		return false;
	}
	return true;
	break;

case COMMAND05: // Special CGO pop-up
	if(formObj.in_vvd_cd.value == ""
			|| formObj.in_vvd_cd.value.length != 9){
		ComShowCodeMessage('BKG00710');
		formObj.in_vvd_cd.focus();
		return false;
	}

	if(formObj.in_pol_cd.value == ""
			|| formObj.in_pol_cd.value.length != 5){
		ComShowCodeMessage('BKG00711');
		formObj.in_pol_cd.focus();
		return false;
	}
	return true;
	break;
		
	}
	
}

/**
 * Enter 이벤트
 * @return
 */
function obj_ComKeyEnter() {

	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	// alert(srcName);
	if (srcName != "remark") {
		ComKeyEnter();
	}
}

/* 개발자 작업 끝 */