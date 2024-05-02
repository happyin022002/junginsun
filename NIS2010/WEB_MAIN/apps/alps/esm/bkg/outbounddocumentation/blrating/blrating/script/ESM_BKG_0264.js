/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0264.js
 *@FileTitle : Freight & Charge_BKG Q'TY Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.26
 *@LastModifier : 이진서
 *@LastVersion : 1.0
 * 2009.06.26 이진서
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
 * @class esm_bkg_0264 : esm_bkg_0264 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0264() {
	this.processButtonClick = tprocessButtonClick;
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
var URL_ESM_BKG = 'ESM_BKG_0264GS.do';
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	if (document.form.bkg_no.value == '') {
		ComShowCodeMessage("BKG00463");// 조회를 위한 BKG no가 없습니다.
		self.close();
	}
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: //sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 100;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 15, 100);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(14, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = " |TP/SZ|Q'ty|DR|RF|AK|BB|DG|IMO|EQ SUB TP|EQ SUB Q'ty|C'HGR|C'HGR|M'HGR";
			var HeadTitle2 = " |TP/SZ|Q'ty|DR|RF|AK|BB|DG|IMO|EQ SUB TP|EQ SUB Q'ty|S|D|M'HGR";

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "cntr_tpsz_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 55, daRight, true, "op_cntr_qty", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 55, daRight, true, "dr_qty", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 55, daRight, true, "rc_qty", false, "", dfNullFloat, 2, true, true);

			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "awk_cgo_qty", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "bb_cgo_qty", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "dcgo_qty", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 55, daRight, true, "imdg_clss_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "eq_subst_cntr_tpsz_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 75, daRight, true, "eq_subst_cgo_qty", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daRight, false, "crr_hngr_sgl_bar_qty", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daRight, false, "crr_hngr_dbl_bar_qty", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 65, daRight, true, "mer_hngr_qty", false, "", dfNullFloat, 2, true, true);

			MultiSelection = false;
			SelectHighLight = true;
		}
		break;

	}
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_close":
			window.close();
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

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회
		ComSetObjValue(formObj.f_cmd, SEARCH);
		sheetObj.DoSearch4Post(URL_ESM_BKG, '', FormQueryString(formObj), false);

		break;
	}
}
/**
 * Sheet 조회완료 후 이벤트 발생
 */
function sheet0_OnSearchEnd(sheetObj, ErrMsg) {

	var formObj = document.form;
	var c_row = sheetObj.LastRow;

	for ( var row = 2; row <= c_row; row++) {
		sheetObj.CellValue(row, "imdg_clss_cd") = ComGetObjValue(formObj.imdg_clss_cd);
		sheetObj.CellValue(row, "eq_subst_cntr_tpsz_cd") = ComGetObjValue(formObj.eq_subst_cntr_tpsz_cd);
		sheetObj.CellValue(row, "eq_subst_cgo_qty") = ComGetObjValue(formObj.eq_subst_cgo_qty);
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
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		//             if (!isNumber(formObj.iPage)) {
		//                 return false;
		//             }
	}

	return true;
}
/* 개발자 작업  끝 */