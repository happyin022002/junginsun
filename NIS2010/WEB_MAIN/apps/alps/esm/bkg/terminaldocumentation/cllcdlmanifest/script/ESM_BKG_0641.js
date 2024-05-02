/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0641.js
 *@FileTitle : ESM_BKG_0641
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.10
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.07.10 김승민
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
 * @class ESM_BKG_0641 : ESM_BKG_0641 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0641() {
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

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;

		case "btn_downExcel":
			doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
			break;

		// case "btn_print":
		// doActionIBSheet(sheetObject, formObject, COMMAND01);
		// break;

		case "btns_calendar": // 달력버튼
			// 조회전 일땐 사용못하게 ...
			var cal = new ComCalendarFromTo();
			cal.select(formObject.in_edi_rpt_msg_rcv_dt_start,
					formObject.in_edi_rpt_msg_rcv_dt_end, 'yyyy-MM-dd');
			break;

		case "btns_calendar2": // 달력버튼
			// 조회전 일땐 사용못하게 ...
			var cal = new ComCalendarFromTo();
			cal.select(formObject.in_cntr_ldis_dt_start,
					formObject.in_cntr_ldis_dt_end, 'yyyy-MM-dd');
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

		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);

		ComEndConfigSheet(sheetObjects[i]);

	}
	initControl()
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
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // -
	// 키보드
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	// 키보드
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	formObject.in_edi_rpt_msg_rcv_dt_start.focus();
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
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which
			: event.charCode;
	var srcName = event.srcElement.getAttribute("name");
	var srcValue = event.srcElement.getAttribute("value");
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
	case "ymd":
		// alert(srcValue.length);
		ComKeyOnlyNumber(event.srcElement);
		if (srcValue.length == 4) {
			document.form.elements[srcName].value = srcValue.substring(0, 4)
					+ "-"
		}
		if (srcValue.length == 7) {
			document.form.elements[srcName].value = srcValue.substring(0, 7)
					+ "-"
		}
		break;
	default:
		// 숫자만입력하기(정수,날짜,시간)
		ComKeyOnlyNumber(event.srcElement);
	}
}

/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 */
function obj_activate() {
	// 입력Validation 확인하기
	switch (event.srcElement.name) {

	case "in_edi_rpt_msg_rcv_dt_start":
		ComClearSeparator(event.srcElement);
		break;
	case "in_edi_rpt_msg_rcv_dt_end":
		ComClearSeparator(event.srcElement);
		break;

	case "in_cntr_ldis_dt_start":
		ComClearSeparator(event.srcElement);
		break;
	case "in_cntr_ldis_dt_end":
		ComClearSeparator(event.srcElement);
		break;
	default:
		break;
	// return;
	// ComAddSeparator(event.srcElement);
	// ComChkObjValid(event.srcElement);
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

	case "sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 302;
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

			// var HeadTitle = "|Seq|VVD|Carrier|Container No|TS|Seal
			// No1|BKG|Cargo Status|Yard|POL|POD|Stowage|Gross Weight|Tare|Cargo
			// Type|IMO|Storage|Dm|Discharging Date|Storage|Call Sign|Vessel
			// Name|MSG In Date";
			var HeadTitle = "|Seq|VVD|Carrier|Container No|TS|Seal No1|BKG|Cargo Status|Yard|POL|POD|Stowage|Gross Weight|Tare|Cargo Type|IMO|Dm|Discharging Date|Call Sign|Vessel Name|MSG In Date";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 60, daCenter, true,
					"ibflag");
			InitDataProperty(0, cnt++, dtSeq, 30, daCenter, true, "seq");
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false,
					"tml_vvd_id", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "crr_cd",
					false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "cntr_no",
					false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 50, daCenter, false,
					"cntr_tpsz_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false,
					"cntr_seal_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "bkg_no",
					false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false,
					"cgo_sts_id", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false,
					"evnt_yd_cd", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "pol_cd",
					false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "pod_cd",
					false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false,
					"stwg_cell_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 90, daRight, false, "grs_wgt",
					false, "", dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false,
					"cntr_tare_wgt", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 80, daCenter, false,
					"cgo_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false,
					"imdg_clss_id", false, "", dfNone, 0, false, true);
			// InitDataProperty(0, cnt++, dtData, 60, daCenter, false,
			// "sto_area_cd",
			// false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false,
					"eur_tml_dmg_id", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, false,
					"cntr_ldis_dt", false, "", dfNone, 0, false, true);

			// InitDataProperty(0, cnt++, dtData, 70, daCenter, false,
			// "sto_yd_cd",
			// false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false,
					"call_sgn_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 180, daLeft, false, "vsl_nm",
					false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, false,
					"edi_rpt_msg_rcv_dt", false, "", dfNone, 0, false, true);

			// InitUserFormat2(0, "DischargingDate", "####-##-## ##:##", "-|:");
			// InitUserFormat2(0, "MSGInDate", "####-##-## ##:##", "-|:");
			// InitDataCombo(0, "Dm", "0|1|2|3", "0|1|2|3");
			CountPosition = 2;

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
			//alert();	
			formObj.f_cmd.value = SEARCH;
			sheetObj.WaitImageVisible = false;	
			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_0641GS.do", FormQueryString(formObj));
			ComOpenWait(false);
		}
		break;

	case IBDOWNEXCEL:
		sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "",
				false, "del_chk");
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
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if (formObj.in_edi_rpt_msg_rcv_dt_start.value == ""
				|| formObj.in_edi_rpt_msg_rcv_dt_start.value.length != 10) {
			ComShowCodeMessage('BKG00341');
			formObj.in_edi_rpt_msg_rcv_dt_start.focus();
			return false;
		}

		if (formObj.in_edi_rpt_msg_rcv_dt_end.value == ""
				|| formObj.in_edi_rpt_msg_rcv_dt_end.value.length != 10) {
			ComShowCodeMessage('BKG00341');
			formObj.in_edi_rpt_msg_rcv_dt_end.focus();
			return false;
		}

		var iDays = ComGetDaysBetween(
				formObj.in_edi_rpt_msg_rcv_dt_start.value,
				formObj.in_edi_rpt_msg_rcv_dt_end.value);
		if (iDays > 7) {
			ComShowCodeMessage('BKG00626', 'Peorid is more than a week!');
			formObj.in_edi_rpt_msg_rcv_dt_end.focus();
			return false;
		}

		return true;
		break;
	}
}

/* 개발자 작업 끝 */