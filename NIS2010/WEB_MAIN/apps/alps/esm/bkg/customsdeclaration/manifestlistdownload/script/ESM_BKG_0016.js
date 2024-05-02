/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0016.js
 *@FileTitle : Customer Code Entry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.16
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.16 김민정
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0016() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.sheet1_OnClick = sheet1_OnClick;
}

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, SEARCH);
			break;

		case "btn_save":
			doActionIBSheet(sheetObject, formObject, MULTI);
			break;

		case "s_btn_calendar":
			var cal = new ComCalendar();
			cal.select(formObject.s_vps_eta_dt, 'yyyy-MM-dd');
			break;

		case "e_btn_calendar":
			var cal = new ComCalendar();
			cal.select(formObject.e_vps_eta_dt, 'yyyy-MM-dd');
			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComFuncErrMsg(e);
		} else {
			ComFuncErrMsg(e);
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
	doActionIBSheet(sheetObjects[0], document.form, INIT);
	document.form.frm_vsl_cd.focus();
	// 화면에서 필요한 이벤트
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	if (document.form.office.value == "Origin") {
		ComBtnDisable("btn_save");
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
			style.height = 100;
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

			var HeadTitle1 = "|Vessel Code|Lloyd No.|Country|Name|Registry Port|Registry Official No.|Registry Date|Gross Weight|Net Weight|Dead Weight|Crew|Call Sign|L.O.A.|Safety Construction|Safety Radio|Safety Equipment|Loadline|Derat|Carrier Code";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, false, "ibflag");

			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "vsl_cd", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "lloyd_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "vsl_rgst_cnt_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "vsl_eng_nm", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "rgst_port_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "rgst_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "rgst_dt", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "grs_rgst_tong_wgt", false, "", dfFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "net_rgst_tong_wgt", false, "", dfFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "dwt_wgt", false, "", dfFloat, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "crw_knt", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "call_sgn_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "loa_len", false, "", dfFloat, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "vsl_sft_cstru_certi_exp_dt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "vsl_sft_rdo_certi_exp_dt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "vsl_sft_eq_certi_exp_dt", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "vsl_lod_line_certi_exp_dt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "vsl_derat_certi_exp_dt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "crr_cd", false, "", dfNone, 0, false, false);
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

	case SEARCH: //Retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESM_BKG_0016GS.do", FormQueryString(formObj));
			if (sheetObj.RowCount > 0) {
				IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
				formObj.frm_grs_rgst_tong_wgt.value = ComAddComma2(formObj.frm_grs_rgst_tong_wgt, "#,###.00");
				formObj.frm_net_rgst_tong_wgt.value = ComAddComma2(formObj.frm_net_rgst_tong_wgt, "#,###.00");
				formObj.frm_dwt_wgt.value = ComAddComma2(formObj.frm_dwt_wgt, "#,###.00");
				formObj.frm_crw_knt.value = ComAddComma2(formObj.frm_crw_knt, "#,###");
				formObj.frm_loa_len.value = ComAddComma2(formObj.frm_loa_len, "#,###.00");
			} else {
				for ( var i = 0; i < formObj.getElementsByTagName("input").length; i++) {
					if (formObj.getElementsByTagName("input")[i].name != "frm_vsl_cd") {
						formObj.getElementsByTagName("input")[i].value = "";
					}
				}
			}
			ComOpenWait(false);
		}
		break;

	case MULTI: //Save
		if (sheetObj.RowCount > 0) {
			if (validateForm(sheetObj, formObj, sAction)) {
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
				sheetObj.DoSave("ESM_BKG_0016GS.do", FormQueryString(formObj));
				ComOpenWait(false);
			}
		} else {
			ComShowCodeMessage('BKG000012');
			return;
		}
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
	case SEARCH:
		//기본포멧체크
		if (!ComChkObjValid(formObj.frm_vsl_cd))
			return false;
		break;
	case MULTI:
		//기본포멧체크
		if (!ComChkValid(formObj))
			return false;
		break;
	}
	return true;
}