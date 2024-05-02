/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0574.js
 *@FileTitle : Auto Filing NVOCC Transmission Status
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.05.25 김도완
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
 * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0574() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;

		case "btn_downexcel":
			doActionIBSheet(sheetObjects[0], formObject, IBDOWNEXCEL);
			break;

		case "btn_nvoccscac":
			ComOpenWindow2("ESM_BKG_0040.do?pgmNo=ESM_BKG_0040", "ESM_BKG_0040",
					"scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no,window.clientWidth,window.clientHeight");
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

	axon_event.addListenerForm('change', 'obj_Change', document.form);
	// input type에 format 옵션이 있는 경우를 캐치한다.
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

	document.form.vvd.focus();
	
	//US AMS Main Menu : VVD 입력시
	if (!ComIsNull(document.form.vvd))
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	var headerColorForNvocc = sheetObj.RgbColor(231, 231, 235);

	switch (sheetID) {
	case "sheet1": //sheet1 init
		with (sheetObj) {
			//높이 설정
			style.height = 442;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 2, 50);

			var HeadTitle1 = "|Seq.|ALPS Information|ALPS Information|ALPS Information|Customs Filing Information|Customs Filing Information|Customs Filing Information|Customs Filing Information|Customs Filing Information|Customs Filing Information|Customs Filing Information|Customs Filing Information|Customs Filing Information|";
			var HeadTitle2 = "|Seq.|M.B/L No.|SCAC|SCAC Name|SCAC|H.B/L No.|M.B/L No.|VSL Name|Voyage|AMS POD|POD|69|Receive Date|";

			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix = "sheet1_";
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, prefix + "ibflag");
			InitDataProperty(0, cnt++, dtSeq, 40, daCenter, true, "Seq", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 110, daCenter, true, prefix + "mbl", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, prefix + "hjs_scac", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 190, daLeft, true, prefix + "scac_nm", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, prefix + "scac", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, true, prefix + "hbl", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, true, prefix + "nvocc_cbl", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 130, daCenter, true, prefix + "nvocc_vsl_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, prefix + "nvocc_skd_voy_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, prefix + "cstms_pod_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, prefix + "nvocc_pod_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, prefix + "mf_rspn_rcv_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, prefix + "rcv_dt", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, prefix + "pod_err");

			// CellBackColor(0, 2) = headerColorForNvocc;
			// CellBackColor(0, 4) = headerColorForNvocc;
			// CellBackColor(0, 5) = headerColorForNvocc;
			// CellBackColor(0, 6) = headerColorForNvocc;
			// CellBackColor(0, 7) = headerColorForNvocc;
			// CellBackColor(0, 8) = headerColorForNvocc;
			// CellBackColor(0, 12) = headerColorForNvocc;
			// CellBackColor(0, 13) = headerColorForNvocc;
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, Row, Col) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;

	switch (sAction) {
	case IBSEARCH: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		if ("sheet1" == sheetObj.id)
			sheetObj.DoSearch("ESM_BKG_0574GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
		ComOpenWait(false);
		break;

	case SEARCH01: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		formObj.f_cmd.value = SEARCH01;
		if ("sheet1" == sheetObj.id) {
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0574GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
			formObj.ams_pod.value = ComGetEtcData(sXml, "ams_pod");
		}
		break;

	case IBDOWNEXCEL: //Down Excel
		ComOpenWait(true);
		sheetObj.SpeedDown2Excel(-1);
		ComOpenWait(false);
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		if (!ComChkRequired(formObj))
			return false;
		break;
	}
	return true;
}

/**
 * 폼 데이터 변경 시 이벤트 처리
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function obj_Change() {
	event.srcElement.value = event.srcElement.value.toUpperCase();
	if (event.srcElement.name == "pod") {
		var sheetObj = sheetObjects[0];

		doActionIBSheet(sheetObj, document.form, SEARCH01);
	} else {
		return;
	}
}

/**
 * 조회 후 이벤트
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {

	var formObj = document.form;
	var prefix = "sheet1_";
	if (ErrMsg == "") {
		var errColor = sheetObj.Red;

		for ( var i = 2; i < sheetObj.RowCount + 2; i++) {

			if (sheetObj.CellValue(i, prefix + "pod_err") == "1") {
				sheetObj.CellFontColor(i, prefix + "nvocc_pod_cd") = sheetObj.RgbColor(255, 0, 0);
				sheetObj.CellFontColor(i, prefix + "cstms_pod_cd") = sheetObj.RgbColor(255, 0, 0);
			}
		}

	}
}
/* 개발자 작업  끝 */