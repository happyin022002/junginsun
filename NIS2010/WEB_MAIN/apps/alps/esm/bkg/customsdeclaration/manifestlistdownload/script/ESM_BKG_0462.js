/*=========================================================
 *Copyright(c) 2017 Hi-Plus Card
 *@FileName : Esm_bkg_0462.js
 *@FileTitle : ESM_BKG-0462
 *Open Issues :
 *Change history :
 *	2011.04.06 김영철 [CHM-201109426-01] Sea-NACCS MFR 송신에러 ( WGT 정수자리수가 7자리 이상인지 체크함. )
 *	2017.08.08 하대성 2017 Renewal Version Transmit 반영
 *@LastModifyDate : 2017.08.08
 *@LastModifier : 하대성
 *@LastVersion : 1.0
 * 2009.04.21 김승민
 * 1.0 Creation
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
 * @class ESM_BKG-0462 : ESM_BKG-0462 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0462() {
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
			doActionIBSheet(sheetObject2, document.form, IBSEARCH);
			// doActionIBSheet(sheetObject2, document.form, IBSEARCH);
			// doActionIBSheet(sheetObject3, document.form, IBSEARCH);
			break;

		case "btn_datadl":
			doActionIBSheet(sheetObject2, document.form, COMMAND01);
			break;

		case "btn_print":
			doActionIBSheet(sheetObject4, document.form, COMMAND02);
			break;
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
initControl();
document.form.in_vvd_cd.focus();
// doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
// doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
// doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
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
axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // - 키보드
// 입력할때
axon_event.addListener('keydown', 'ComKeyEnter', 'form');
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
case "sheet1": // sheet1 init
	with (sheetObj) {
		// 높이 설정
		style.height = 85;
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
		InitRowInfo(1, 1, 3, 100);

		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(9, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, false, true, false, false)

		var HeadTitle1 = "|Seq.|POL|ETD|POD|ETA|BDR|BDR Time|Sub B/L Total";

		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);

		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
		// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
		// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
		// SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++, dtHiddenStatus, 50, daCenter, true, "ibflag");
		InitDataProperty(0, cnt++, dtSeq, 60, daCenter, true, "seq");
		InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "pol_cd", false,
				"", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 205, daCenter, true, "vps_etd_dt",
				false, "", dfUserFormat2, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "pod_cd", false,
				"", dfNone, 0, false, true);

		InitDataProperty(0, cnt++, dtData, 200, daCenter, true, "vps_eta_dt",
				false, "", dfUserFormat2, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "bdr_flg",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 125, daCenter, true, "bdr_time",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "bkg_count",
				false, "", dfNone, 0, false, true);

		InitUserFormat2(0, "vps_etd_dt", "####-##-## ##:##", "-|:");
		InitUserFormat2(0, "vps_eta_dt", "####-##-## ##:##", "-|:");

		CountPosition = 0;
	}
	break;

case "t1sheet1": // t1sheet1 init
	with (sheetObj) {
		// 높이 설정
		style.height = 265;
		// 전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		// Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "")
			InitHostInfo(location.hostname, location.port, page_path);

		// 전체Merge 종류 [선택, Default msNone]
		MergeSheet = msPrevColumnMerge + msHeaderOnly;
		// MergeSheet = msHeaderOnly;
		// 전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(2, 1, 3, 100);

		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(29, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(false, true, true, true, false, false)

		var HeadTitle1 = "|Seq.|Sel.|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|SHPR|SHPR|SHPR|CNEE|CNEE|CNEE|NTFY|NTFY|NTFY|M|D|BDR|C/A No.";
		var HeadTitle2 = "|Seq.|Sel.|B/L No.|BKG No.|AMR|I/F|L/T|POL|POD|Package|Package|Weight|Weight|Measure|Measure|N|A|P|N|A|P|N|A|P|M|D|BDR|C/A No.";

		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);
		InitHeadRow(1, HeadTitle2, true);

		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
		// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
		// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
		// SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++, dtHiddenStatus, 40, daCenter, true, "ibflag");
		InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "seq", false,
				"", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, true, "chk");
		InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "bl_no", false,
				"", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 140, daCenter, true, "bkg_no",
				false, "", dfNone, 0, false, true);

		InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "a_s", false,
				"", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "i_f", false,
				"", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "l_t", false,
				"", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "pol_cd", false,
				"", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "pod_cd", false,
				"", dfNone, 0, false, true);

		InitDataProperty(0, cnt++, dtData, 45, daRight, true, "pck_qty", false,
				"", dfNullInteger, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "pck_tp_cd",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 70, daRight, true, "act_wgt", false,
				"", dfNullFloat, 3, false, true);
		InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "wgt_ut_cd",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 55, daRight, true, "meas_qty",
				false, "", dfNullFloat, 3, false, true);

		InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "meas_ut_cd",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 21, daCenter, true, "cust_nm1",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 21, daCenter, true, "cust_addr1",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 21, daCenter, true, "cust_phn_no1",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 21, daCenter, true, "cust_nm2",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 21, daCenter, true, "cust_addr2",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 21, daCenter, true, "cust_phn_no2",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 21, daCenter, true, "cust_nm3",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 21, daCenter, true, "cust_addr3",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 21, daCenter, true, "cust_phn_no3",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "mk_desc",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "cmdt_desc",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "bdr_cng_flg",
				false, "", dfNone, 0, false, true);

		InitDataProperty(0, cnt++, dtData, 68, daCenter, true, "corr_no",
				false, "", dfNone, 0, false, true);

		CountPosition = 0;
	}
	break;

case "t2sheet1": // t2sheet1 init
	with (sheetObj) {
		// 높이 설정
		style.height = 265;
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
		InitRowInfo(2, 1, 3, 100);

		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(14, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(false, true, false, true, false, false)

		var HeadTitle1 = "|Seq.|B/L No.|Container|Container|Container|Container|Container|Container|Container|Container|Container|Container|cntr_knt";
		var HeadTitle2 = "|Seq.|B/L No.|No.|SEAL No1.|SEAL No2.|SEAL No3.|SEAL No4.|SEAL No5.|SEAL No6.|P|R|D|cntr_knt";

		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);
		InitHeadRow(1, HeadTitle2, true);

		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
		// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
		// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
		// SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++, dtHiddenStatus, 40, daCenter, true,
				"ibflag", false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "seq", false,
				"", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 230, daCenterTop, true, "bl_no",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cntr_no",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "cntr_seal_no",
				false, "", dfNone, 0, false, true);

		InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "cntr_seal_no2",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "cntr_seal_no3",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "cntr_seal_no4",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "cntr_seal_no5",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "cntr_seal_no6",
				false, "", dfNone, 0, false, true);

		InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "cntr_prt_flg",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "rcv_term_cd",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "de_term_cd",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "cntr_knt");

		CountPosition = 0;
	}
	break;
case "sheet2": // t1sheet1 init
	with (sheetObj) {
		// 높이 설정
		style.height = 265;
		// 전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		// Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "")
			InitHostInfo(location.hostname, location.port, page_path);

		// 전체Merge 종류 [선택, Default msNone]
		MergeSheet = msPrevColumnMerge + msHeaderOnly;
		// MergeSheet = msHeaderOnly;
		// 전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(1, 1, 3, 100);

		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(27, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(false, true, true, true, false, false)

		var HeadTitle1 = "Seq.|B/L No.|I/F|L/T|POL|POD|Package|Package|Weight|Weight|Measure|Measure|N|A|P|N|A|P|N|A|P|BDR|C/A No.|M|D|CNTR_NO|SEAL_NO";

		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);
		InitHeadRow(1, HeadTitle2, true);

		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
		// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
		// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
		// SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "seq", false,
				"", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "bl_no", false,
				"", dfNone, 0, false, true);

		InitDataProperty(0, cnt++, dtData, 23, daCenter, true, "i_f", false,
				"", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 23, daCenter, true, "l_t", false,
				"", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "pol_cd", false,
				"", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "pod_cd", false,
				"", dfNone, 0, false, true);

		InitDataProperty(0, cnt++, dtData, 45, daRight, true, "pck_qty", false,
				"", dfNullInteger, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "pck_tp_cd",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 70, daRight, true, "act_wgt", false,
				"", dfNullFloat, 3, false, true);
		InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "wgt_ut_cd",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 55, daRight, true, "meas_qty",
				false, "", dfNullFloat, 3, false, true);

		InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "meas_ut_cd",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 21, daCenter, true, "cust_nm1",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 21, daCenter, true, "cust_addr1",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 21, daCenter, true, "cust_phn_no1",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 21, daCenter, true, "cust_nm2",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 21, daCenter, true, "cust_addr2",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 21, daCenter, true, "cust_phn_no2",
				false, "", dfNone, 0, false, true);

		InitDataProperty(0, cnt++, dtData, 21, daCenter, true, "cust_nm3",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 21, daCenter, true, "cust_addr3",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 21, daCenter, true, "cust_phn_no3",
				false, "", dfNone, 0, false, true);

		InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "bdr_cng_flg",
				false, "", dfNone, 0, false, true);

		InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "corr_no",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "mk_desc",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "cmdt_desc",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "cntr_no",
				false, "", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "cntr_seal_no",
				false, "", dfNone, 0, false, true);

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
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0462GS.do",
					FormQueryString(formObj));
			// var sXml = sheetObj.GetSearchXml("ESM_BKG_0017GS.do",
			// FormQueryString(formObj));
	
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
	
			state = sheetObjects[0].EtcData("TRANS_RESULT_KEY");
	
			// alert(state);
			if (state == "S") {
				sheetObj.CheckAll("chk") = 0;
				var rowCnt = sheetObj.RowCount;
	
				// alert(rowCnt);
				if (rowCnt == 0) {
					ComBtnDisable("btn_print");
				} else {
					ComBtnEnable("btn_print");
				}
			}
			formObj.totalCount.value = sheetObjects[0].EtcData("total_count");
	
			//var wgtErrBkgNo = sheetObjects[0].EtcData("wgt_err_bkg_no");
			//if ( wgtErrBkgNo.length > 0 )
			//{
			//	ComShowCodeMessage('BKG95001', 'Weight digit is mismach. \n','(Booking No: '+wgtErrBkgNo+' )');
			//}
			// sheetObjects[1].RowMerge(11) = true;
	
			// alert(sheetObjects[1].RowCount);
			for ( var i = 2; i <= sheetObjects[1].RowCount + 1; i++) {
				if (sheetObjects[1].CellValue(i, "mk_desc") == "N") {
					sheetObjects[1].CellFont("FontColor", i, "mk_desc") = sheetObjects[1]
							.RgbColor(255, 0, 0);
				}
				if (sheetObjects[1].CellValue(i, "cmdt_desc") == "N") {
					sheetObjects[1].CellFont("FontColor", i, "cmdt_desc") = sheetObjects[1]
							.RgbColor(255, 0, 0);
				}
				if (sheetObjects[1].CellValue(i, "cust_nm1") == "N") {
					sheetObjects[1].CellFont("FontColor", i, "cust_nm1") = sheetObjects[1]
							.RgbColor(255, 0, 0);
				}
				if (sheetObjects[1].CellValue(i, "cust_addr1") == "N") {
					sheetObjects[1].CellFont("FontColor", i, "cust_addr1") = sheetObjects[1]
							.RgbColor(255, 0, 0);
				}
				if (sheetObjects[1].CellValue(i, "cust_phn_no1") == "N") {
					sheetObjects[1].CellFont("FontColor", i, "cust_phn_no1") = sheetObjects[1]
							.RgbColor(255, 0, 0);
				}
				if (sheetObjects[1].CellValue(i, "cust_nm2") == "N") {
					sheetObjects[1].CellFont("FontColor", i, "cust_nm2") = sheetObjects[1]
							.RgbColor(255, 0, 0);
				}
				if (sheetObjects[1].CellValue(i, "cust_addr2") == "N") {
					sheetObjects[1].CellFont("FontColor", i, "cust_addr2") = sheetObjects[1]
							.RgbColor(255, 0, 0);
				}
				if (sheetObjects[1].CellValue(i, "cust_phn_no2") == "N") {
					sheetObjects[1].CellFont("FontColor", i, "cust_phn_no2") = sheetObjects[1]
							.RgbColor(255, 0, 0);
				}
				if (sheetObjects[1].CellValue(i, "cust_nm3") == "N") {
					sheetObjects[1].CellFont("FontColor", i, "cust_nm3") = sheetObjects[1]
							.RgbColor(255, 0, 0);
				}
				if (sheetObjects[1].CellValue(i, "cust_addr3") == "N") {
					sheetObjects[1].CellFont("FontColor", i, "cust_addr3") = sheetObjects[1]
							.RgbColor(255, 0, 0);
				}
				if (sheetObjects[1].CellValue(i, "cust_phn_no3") == "N") {
					sheetObjects[1].CellFont("FontColor", i, "cust_phn_no3") = sheetObjects[1]
							.RgbColor(255, 0, 0);
				}
				if (sheetObjects[1].CellValue(i, "seq") == "") {
					sheetObjects[1].CellEditable(i, "chk") = false;
	
				}
			}
			ComOpenWait(false);
		}
	
		break;
	
	case COMMAND01: // 저장
		if (validateForm(sheetObj, formObj, sAction)) {
			// GetSaveXml
			formObj.f_cmd.value = MULTI;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			// var sXml = sheetObj.GetSearchXml("ESM_BKG_0462GS.do",
			// FormQueryString(formObj));
			sheetObj.DoSave("ESM_BKG_0462GS.do", FormQueryString(formObj));
			// var sXml = sheetObj.GetSearchXml("ESM_BKG_0462GS.do",
			// FormQueryString(formObj));
	
			state = sheetObj.EtcData("TRANS_RESULT_KEY");
			ComOpenWait(false);
			if (state == "S") {
				doActionIBSheet(sheetObj, document.form, IBSEARCH);
			}
		}
		break;
	
	case COMMAND02: // 저장
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWindowCenter("/hanjin/ESM_BKG_5015.do?pgmNo=ESM_BKG_5015",
					"5015", 1020, 680, false);
	
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
 * Tab 기본 설정 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
switch (tabNo) {
case 1:
	with (tabObj) {
		var cnt = 0;
		InsertTab(cnt++, "B/L List", -1);
		InsertTab(cnt++, "CNTR List", -1);

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
case IBSEARCH:

	if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
		ComShowCodeMessage('BKG00251');
		formObj.in_vvd_cd.focus();
		return false;
	}

	if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
		ComShowCodeMessage('BKG00252');
		formObj.in_pod_cd.focus();
		return false;
	}

	return true;
	break;
case COMMAND01:
	if (sheetObj.CheckedRows("chk") < 1) {
		ComShowCodeMessage("BKG00249");    // "No Selected Row"
		return false;
	}

	if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
		ComShowCodeMessage('BKG00251');
		formObj.in_vvd_cd.focus();
		return false;
	}

	if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
		ComShowCodeMessage('BKG00252');
		formObj.in_pod_cd.focus();
		return false;
	}

	var chkdRowArray = sheetObj.FindCheckedRow("chk").split("|");
	chkdRowArray.pop();    // Array에서 마지막 빈 값 삭제
	for (var k in chkdRowArray) {
		var sht3RowNum = sheetObjects[2].FindText("bl_no", sheetObj.CellValue(chkdRowArray[k], "bl_no"));
		if (sheetObjects[2].CellValue(sht3RowNum, "cntr_knt") > 100) {
			ComShowCodeMessage("BKG02220");    // "There is a B/L with more than 101 containers."
			tabObjects[0].SelectedIndex = 1;
			sheetObjects[2].SelectCell(sht3RowNum, "bl_no");
			return false;
		}
	}

	return true;
	break;
case COMMAND02:

	if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
		ComShowCodeMessage('BKG00251');
		formObj.in_vvd_cd.focus();
		return false;
	}

	if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
		ComShowCodeMessage('BKG00252');
		formObj.in_pod_cd.focus();
		return false;
	}

	return true;
	break;
}
}

/* 개발자 작업 끝 */

