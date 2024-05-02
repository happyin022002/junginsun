/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : Esm_bkg_0018.js
 *@FileTitle : ESM_BKG-0018
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 김승민
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
 * @class ESM_BKG-0018 : ESM_BKG-0018 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0018() {
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
			formObject.vps_eta_start_dt.focus();
			break;

		case "btn_save":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;

		case "btns_calendar": // 달력버튼
			// 조회전 일땐 사용못하게 ...
			var cal = new ComCalendarFromTo();
			cal.select(formObject.vps_eta_start_dt, formObject.vps_eta_end_dt,
					'yyyy-MM-dd');
			break;

		case "btn_transmit": // GO TO TRANSMIT
			doActionIBSheet(sheetObjects[0], document.form, SEARCHLIST01);
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
	initControl();
	document.form.vps_eta_start_dt.focus();
	// doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
	// axon_event.addListenerForm ('blur', 'obj_deactivate', formObject); //-
	// 포커스 나갈때
	// axon_event.addListenerFormat('focus', 'obj_activate', formObject); //-
	// 포커스 들어갈때
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // -
	// 키보드
	// 입력할때
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
}

/**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 */
function obj_keypress() {
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
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 */
function obj_activate() {
	// 입력Validation 확인하기
	switch (event.srcElement.name) {

	case "vps_eta_start_dt":
		ComClearSeparator(event.srcElement);
		break;
	case "vps_eta_end_dt":
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
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 */
function obj_deactivate() {
	// if (event.srcElement.getAttribute("required") != null) return;

	// 입력Validation 확인하기
	switch (event.srcElement.name) {

	case "vps_eta_start_dt":
		ComAddSeparator(event.srcElement);
		break;
	case "vps_eta_end_dt":
		ComAddSeparator(event.srcElement);
		break;
	default:
		break;
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
	case "sheet1": // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 300;
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
			InitColumnInfo(16, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			var HeadTitle1 = "|VSLCD|VVD|Lane|ETA|Prior Port|Next Port|Transmission Status|Transmission Status|Transmission Status|SHIP ID No.|Visit No.|MVMT Seq.|VSL Operater|Origin|Destination";
			var HeadTitle2 = "|VSLCD|VVD|Lane|ETA|Prior Port|Next Port|Time|Seq.|User ID|SHIP ID No.|Visit No.|MVMT Seq.|VSL Operater|Origin|Destination";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false,
					"ibflag");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false,
					"vsl_cd_temp");
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "vvd_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "slan_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"vps_eta_dt", false, "", dfNone, 0, false, false, 12);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "pol_cd",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "pod_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 95, daCenter, true,
					"edi_snd_dt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true,
					"edi_snd_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true,
					"edi_snd_usr_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"shp_id_no", false, "", dfNone, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vst_no",
					true, "", dfNone, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtData, 95, daRight, true, "mvmt_seq",
					true, "", dfNone, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtCombo, 100, daLeft, true,
					"pnm_vsl_opr_cd", true, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtCombo, 110, daLeft, true,
					"pnm_org_cd", true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 110, daLeft, true,
					"pnm_dest_cd", true, "", dfNone, 0, true, true);

			InitDataValid(0, "shp_id_no", vtNumericOnly);
			InitDataValid(0, "vst_no", vtNumericOnly);
			InitDataValid(0, "mvmt_seq", vtNumericOnly);

			InitDataCombo(
					0,
					"pnm_vsl_opr_cd",
					" \t |SMLINE\tSMLINE|YANGMI\tYANG MING|COSCOC\tCOSCO|KKLINE\tK LINE AMERICA|EGL\tEvergreen",
					"  |SMLINE|YANGMI|COSCOC|KKLINE|EGL", "", "", 1);
			InitDataCombo(
					0,
					"pnm_org_cd",
					" \t |00\t[00] UNKNOWN|A0\t[A0] AROUND THE WORLD|A1\t[A1] EAST COAST OF THE UNITED STATES|A2\t[A2] EAST COAST OF CANADA|A3\t[A3] CRISTOBAL, REPUBLIC OF PANAMA|A5\t[A5] CRISTOBAL, REPUBLIC OF PANAMA|A6\t[A6] WEST INDIES|A7\t[A7] EUROPE|A8\t[A8] AFRICA|A9\t[A9] ASIA AND THE MIDDLE EAST|P0\t[P0] AROUTE THE WORLD|P1\t[P1] WEST COAST OF THE UNITED STATES|P2\t[P2] WEST COAST OF CANADA|P3\t[P3] WEST COAST OF CENTRAL AMERICA|P4\t[P4] WEST COAST OF SOUTH AMERICA|P5\t[P5] CRISTOBAL, REPUBLIC OF PANAMA|P6\t[P6] HAWALL|P7\t[P7] OCEANIA|P8\t[P8] ANTARTICA|P9\t[P9] ASIA",
					"  |00|A0|A1|A2|A3|A5|A6|A7|A8|A9|P0|P1|P2|P3|P4|P5|P6|P7|P8|P9",
					"", "", 1);
			InitDataCombo(
					0,
					"pnm_dest_cd",
					" \t |00\t[00] UNKNOWN|A0\t[A0] AROUND THE WORLD|A1\t[A1] EAST COAST OF THE UNITED STATES|A2\t[A2] EAST COAST OF CANADA|A3\t[A3] CRISTOBAL, REPUBLIC OF PANAMA|A5\t[A5] CRISTOBAL, REPUBLIC OF PANAMA|A6\t[A6] WEST INDIES|A7\t[A7] EUROPE|A8\t[A8] AFRICA|A9\t[A9] ASIA AND THE MIDDLE EAST|P0\t[P0] AROUTE THE WORLD|P1\t[P1] WEST COAST OF THE UNITED STATES|P2\t[P2] WEST COAST OF CANADA|P3\t[P3] WEST COAST OF CENTRAL AMERICA|P4\t[P4] WEST COAST OF SOUTH AMERICA|P5\t[P5] CRISTOBAL, REPUBLIC OF PANAMA|P6\t[P6] HAWALL|P7\t[P7] OCEANIA|P8\t[P8] ANTARTICA|P9\t[P9] ASIA",
					"  |00|A0|A1|A2|A3|A5|A6|A7|A8|A9|P0|P1|P2|P3|P4|P5|P6|P7|P8|P9",
					"", "", 1);

			// InitUserFormat2(0, "vps_eta_dt", "####-##-## ##", "-|:" );

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

		if (sheetObj.id == "sheet1") {
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value = SEARCH;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.vsl_cd.value = formObj.vvdCd.value.substring(0, 4);
				formObj.skd_voy_no.value = formObj.vvdCd.value.substring(4, 8);
				formObj.skd_dir_cd.value = formObj.vvdCd.value.substring(8);
				// removeSeparator
				sheetObj.DoSearch("ESM_BKG_0018GS.do", FormQueryString(formObj));
				ComOpenWait(false);
			}
			formObj.vps_eta_start_dt.focus();
			// state = "";
			// for(var i=1; i <= sheetObj.RowCount; i++) {
			// sheetObj.CellFont("FontBold",i,"mvmt_seq") = false;
			// }
		}

		break;

	case IBSAVE: // 저장
		if (sheetObjects[0].IsDataModified) {
			formObj.f_cmd.value = MULTI;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			// alert(state);
			var result = sheetObj.DoSave("ESM_BKG_0018GS.do",
					FormQueryString(formObj));
			ComOpenWait(false);
			if (result == true) {
				state = sheetObj.EtcData("TRANS_RESULT_KEY");
				if (state == "S")
					doActionIBSheet(sheetObj, document.form, IBSEARCH);
				else
					ComShowCodeMessage('BKG00167');
			}
		} else {
			ComShowCodeMessage("BKG00743");
			return false;
		}
		break;

	case SEARCHLIST01: // GO TO TRANSMIT 화면 OPEN
		// Walert();
		var sUrl = "/hanjin/ESM_BKG_0017.do?pgmNo=ESM_BKG_0017&vvdCd="
				+ sheetObj.CellValue(sheetObj.SelectRow, "vvd_cd");
		// var sUrl = "/hanjin/ESM_BKG_0456.do?bl_no="+selectedBlNumber;
		ComOpenWindowCenter(sUrl, "ESM_BKG_0017", 1024, 530, false);
		break;

	case IBINSERT: // 입력
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
		if (!ComChkValid(formObj)) {
			// alert("test");
			formObj.vps_eta_start_dt.focus();
			return false;
		}

		if (formObj.vvdCd.value == ""
				&& (formObj.vps_eta_start_dt.value == "" || formObj.vps_eta_end_dt.value == "")) {

			ComShowCodeMessage('BKG00111');
			formObj.vps_eta_start_dt.focus();
			return false;
		}
		if (formObj.vvdCd.value != "" && formObj.vvdCd.value.length != 9) {
			ComShowCodeMessage('BKG00111');

			formObj.vps_eta_start_dt.focus();
			formObj.vvdCd.value = "";
			return false;
		}

		return true;
		break;
	case IBSAVE: // 조회

		return true;
		break;

	}
}

/**
 * Sheet 입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj Sheet
 * @param Row Row
 * @param Col Col
 * @param Value Value
 */
function sheet1_OnValidation(sheetObj, Row, Col, Value) {
	// alert(Col+":"+Value);
	switch (Col) {
	case 11:
		if (Value == "") {
			ComShowCodeMessage('BKG00116');
			sheetObj.ValidateFail = true;
			sheetObj.SelectCell(Row, Col);
			return false;
		}
		if (Value.length != 6) {
			ComShowCodeMessage('BKG00995');
			// alert("6자리여야 합니다");
			sheetObj.ValidateFail = true;
			sheetObj.SelectCell(Row, Col);
			return false;
		}
		break;
	case 12:
		if (Value == "") {
			ComShowCodeMessage('BKG00117');
			sheetObj.ValidateFail = true;
			sheetObj.SelectCell(Row, Col);
			return false;
		}

		break;
	}
}

/* 개발자 작업 끝 */