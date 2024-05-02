/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0617.js
 *@FileTitle : ESM_BKG_0617
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.10
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.07.10 김승민
 * 1.0 Creation
 * 1.1 2014.09.23 [CHM-201432081] CLL/CDL 화면의 "CLL for EDI" 팝업화면내 BS 칼럼 추가 요청
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
 * @class ESM_BKG_0617 : ESM_BKG_0617 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0617() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var state = "";

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

		case "btn_downExcel":
			doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
			break;

		case "btn_print":
			doActionIBSheet(sheetObjects[1], document.form, COMMAND02);
			break;

		case "btn_retrieve":
			doActionIBSheet(sheetObject, document.form, IBSEARCH);
			break;

		case "btn_new":
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			formObject.reset();
			break;

		case "btn_cllForEDI":
			doActionIBSheet(sheetObject, formObject, COMMAND01);
			break;

		case "btns_calendar": // 달력버튼
			// 조회전 일땐 사용못하게 ...
			var cal = new ComCalendarFromTo();
			cal.select(formObject.in_cr_indate_start,
					formObject.in_cr_indate_end, 'yyyy-MM-dd');
			break;

		case "btns_calendar2": // 달력버튼
			// 조회전 일땐 사용못하게 ...
			var cal = new ComCalendarFromTo();
			cal.select(formObject.in_cr_edate_start,
					formObject.in_cr_edate_end, 'yyyy-MM-dd');
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
	//alert();
	for (i = 0; i < sheetObjects.length; i++) {

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

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
	// 들어갈때
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // -
	// 키보드
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	ComBtnDisable("btn_downExcel");
	ComBtnDisable("btn_print");
	ComBtnDisable("btn_cllForEDI");

	document.form.in_cr_indate_start.focus();

	// alert(document.form.in_vvd_cd.value);
	// alert(document.form.in_pol_cd.value);
	if (document.form.in_vvd_cd.value != ""
			&& document.form.in_pol_cd.value != "") {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}

}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	//alert("test1");
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
	//alert("test2");
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
	//alert("test3");
	// 입력Validation 확인하기
	switch (event.srcElement.name) {

	case "in_cr_indate_start":
		ComClearSeparator(event.srcElement);
		break;
	case "in_cr_indate_end":
		ComClearSeparator(event.srcElement);
		break;

	case "in_cr_edate_start":
		ComClearSeparator(event.srcElement);
		break;
	case "in_cr_edate_end":
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
	case "sheet1": // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 370;
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
			InitRowInfo(1, 1, 5, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(27, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = "|Seq.|M|VVD|Carrier|CNTR|TP|Seal No.1|Seal No.2|CGO Status|Yard|POL|POD|F/POD|BS|Stowage|Gross Weight|CGO Type|IMO|DM|Trans|Loading Date|Customs\nDescription|Booking No.|Call Sign|Vessel Name|EDI Receiving Date";
			// var HeadTitle2 = "Seq|M|VVD|Carrier|CNTR|TP|Seal No.1|Seal
			// No.2|CGO Type|Yard|POL|POD|F/POD|Stowage|Gross Weight|CGO
			// Type|IMO|DM|Trans|Loading Date|Customs\nDescription|Booking
			// No.|Call Sign|Vessel Name|EDI Receiving Date";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, false);
			// InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,
					"ibflag");
			InitDataProperty(0, cnt++, dtSeq, 50, daCenter, true, "seq");
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "mtch_flg",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vvd_cd",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "crr_cd",
					false, "", dfNone, 0, true, true, 3);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cntr_no",
					false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, true,
					"cntr_tpsz_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true,
					"cntr_seal_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true,
					"cntr_seal_no2", false, "", dfNone, 0, true, true);
			InitDAtaProperty(0, cnt++, dtData, 70, daCenter, true,
					"cgo_sts_id", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true,
					"evnt_yd_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "pol_cd",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "pod_cd",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 55, daCenter, true,
					"n1st_pod_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true,
					"blck_stwg_cd", false, "", dfNone, 0, true, true); // 2014.09.23 [CHM-201432081]
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true,
					"stwg_cell_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daRight, true, "grs_wgt",
					false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "cgo_tp_cd",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true,
					"imdg_clss_id", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true,
					"eur_tml_dmg_id", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true,
					"trsp_mod_id", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, true,
					"cntr_ldis_dt", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"cstms_decl_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "bkg_no",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true,
					"call_sgn_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 200, daLeft, true, "vsl_nm",
					false, "", daCenter, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true,
					"edi_rpt_msg_rcv_dt", false, "", dfNone, 0, true, true);
		}
		break;

	case "sheet2": // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 175;
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
			InitRowInfo(1, 1, 5, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(18, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = "Seq.|M|VVD|CNTR|TP|Seal No.1|Seal No.2|Booking No.|CGO Status|POD|FPOD|BS|Stowage|Gross Weight|CGO Type|IMD|DM|Customs\nDescription";
			// var HeadTitle2 = "Seq|M|VVD|Carrier|CNTR|TP|Seal No.1|Seal
			// No.2|CGO Type|Yard|POL|POD|F/POD|Stowage|Gross Weight|CGO
			// Type|IMO|DM|Trans|Loading Date|Customs\nDescription|Booking
			// No.|Call Sign|Vessel Name|EDI Receiving Date";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, false);
			// InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtSeq, 50, daCenter, true, "seq");
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "mtch_flg",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vvd_cd",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "cntr_no",
					false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, true,
					"cntr_tpsz_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true,
					"cntr_seal_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true,
					"cntr_seal_no2", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "bkg_no",
					false, "", dfNone, 0, true, true);
			InitDAtaProperty(0, cnt++, dtData, 70, daCenter, true,
					"cgo_sts_id", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "pod_cd",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 55, daCenter, true,
					"n1st_pod_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true,
					"blck_stwg_cd", false, "", dfNone, 0, true, true); // 2014.09.23 [CHM-201432081]
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true,
					"stwg_cell_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daRight, true, "grs_wgt",
					false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "cgo_tp_cd",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true,
					"imdg_clss_id", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true,
					"eur_tml_dmg_id", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"cstms_decl_no", false, "", dfNone, 0, true, true);
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
		// if (validateForm(sheetObj, formObj, sAction))

		formObj.f_cmd.value = SEARCH;
		sheetObj.WaitImageVisible = false;	
		ComOpenWait(true);
		if (formObj.in_list_type_temp(0).checked)
			formObj.in_list_type.value = "L";
		else
			formObj.in_list_type.value = "D";

		if (formObj.in_check_gubun_temp1.checked)
			formObj.in_check_gubun.value = "1";
		else if (formObj.in_check_gubun_temp2.checked)
			formObj.in_check_gubun.value = "2";
		else if (formObj.in_check_gubun_temp3.checked)
			formObj.in_check_gubun.value = "3";
		else if (formObj.in_check_gubun_temp4.checked)
			formObj.in_check_gubun.value = "4";
		else
			formObj.in_check_gubun.value = "5";
		// alert();

		var sXml = sheetObj.GetSearchXml("ESM_BKG_0617GS.do",
				FormQueryString(formObj));

		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0) {
			sheetObjects[0].LoadSearchXml(arrXml[0]);
			sheetObjects[1].LoadSearchXml(arrXml[1]);
		}

		state = sheetObj.EtcData("TRANS_RESULT_KEY");

		if (state == "S") {
			if (sheetObj.RowCount > 1) {
				ComBtnEnable("btn_downExcel");
				ComBtnEnable("btn_print");
				if (formObj.in_list_type_temp(0).checked)
					ComBtnEnable("btn_cllForEDI");
			} else {
				ComBtnDisable("btn_downExcel");
				ComBtnDisable("btn_print");
				ComBtnDisable("btn_cllForEDI");
			}
		}
		//sheetObj.DoSearch("ESM_BKG_0617GS.do", FormQueryString(formObj));
		ComOpenWait(false);
		break;

	case COMMAND01: // 입력
		var inListType = "";
		if (formObj.in_list_type_temp(0).checked)
			inListType = "L";
		else
			inListType = "D";
		var inVvdCd = sheetObj.CellValue(sheetObj.SelectRow, "vvd_cd");
		var inPolCd = sheetObj.CellValue(sheetObj.SelectRow, "pol_cd");
		var inPodCd = sheetObj.CellValue(sheetObj.SelectRow, "pod_cd");

		var sUrl = "/hanjin/ESM_BKG_0155.do?inListType=" + inListType
				+ "&inVvdCd=" + inVvdCd + "&inPolCd=" + inPolCd + "&inPodCd="
				+ inPodCd;
		// var sUrl = "/hanjin/ESM_BKG_0456.do?bl_no="+selectedBlNumber;
		//location.href = sUrl;
		ComOpenWindowCenter(sUrl, "ESM_BKG_0155", 1020, 600, true);
		// ComOpenWindowCenter(sUrl, "ESM_BKG_0161", 400, 240, false);

		break;

	case IBDOWNEXCEL:
		var noRows = "";

		// alert(noRows);
		sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "",
				false, "", noRows);
		break;

	case COMMAND02: // 입력
		ComOpenWindowCenter("/hanjin/ESM_BKG_0805.do?pgmNo=ESM_BKG_0805",
				"805", 1020, 690, true);

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
	with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}

	return true;
}

/**
 * gubun값에 따른 세팅 초기화
 * @param gubun gubun
 */
function setSearchGubun(gubun) {
	var formObj = document.form;
	if (gubun == "1") {
		if (formObj.in_check_gubun_temp1.checked) {
			formObj.in_check_gubun_temp2.checked = false;
			formObj.in_check_gubun_temp3.checked = false;
			formObj.in_check_gubun_temp4.checked = false;
		}
	}
	if (gubun == "2") {
		if (formObj.in_check_gubun_temp2.checked) {
			formObj.in_check_gubun_temp1.checked = false;
			formObj.in_check_gubun_temp3.checked = false;
			formObj.in_check_gubun_temp4.checked = false;
		}
	}
	if (gubun == "3") {
		if (formObj.in_check_gubun_temp3.checked) {
			formObj.in_check_gubun_temp1.checked = false;
			formObj.in_check_gubun_temp2.checked = false;
			formObj.in_check_gubun_temp4.checked = false;
		}
	}
	if (gubun == "4") {
		if (formObj.in_check_gubun_temp4.checked) {
			formObj.in_check_gubun_temp1.checked = false;
			formObj.in_check_gubun_temp2.checked = false;
			formObj.in_check_gubun_temp3.checked = false;
		}
	}
}

/**
 * gubun값에 따른 날짜필드 세팅
 * @param obj obj
 * @param gubun gubun
 */
function setListTeye(obj, gubun) {
	var formObj = document.form;
	var obj = document.getElementById(obj);
	var obj2 = document.getElementById("loadingDate");
	var obj3 = document.getElementById("dischargingDate");

	if (gubun == "L") {
		obj.style.display = "block";
		obj2.style.display = "block";
		obj3.style.display = "none";
	} else if (gubun == "D") {
		obj.style.display = "none";
		obj2.style.display = "none";
		obj3.style.display = "block";
	}
}
/* 개발자 작업 끝 */