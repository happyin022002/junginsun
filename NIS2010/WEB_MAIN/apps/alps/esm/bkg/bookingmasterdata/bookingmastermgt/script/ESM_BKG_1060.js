/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1060.js
 *@FileTitle : Manual Booking Number Create
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.18
 *@LastModifier : 민동진
 *@LastVersion : 1.0
 * 2009.09.18 민동진
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
 * @class ESM_BKG_1060 : ESM_BKG_1060 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_1060() {
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
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_retrieve":
			//정민정 과장님 요청 Retrieve 시 Number of BKG(s), Agent Code 은 공백으로 표시 
			ComSetObjValue(formObject.no_of_bkg, '');
			ComSetObjValue(formObject.act_chn_agn_cd, '');
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;

		case "btn_new":
			doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
			break;

		case "btn_create":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;

		case "btn_down_excel":
			doActionIBSheet(sheetObjects[0], document.form, IBDOWNEXCEL);
			break;
		case "btn_calendar":
			var cal = new ComCalendarFromTo();
			cal.select(formObject.fm_cre_dt, formObject.to_cre_dt, 'yyyy-MM-dd');
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	if (curPgmNo == "ESM_BKG_1060-Q") {
		ComBtnDisable("btn_create");
	}
}

function sheet1_OnLoadFinish(sheetObj) {
 	doActionIBSheet(sheetObj, document.form, IBCLEAR);
	axon_event.addListenerForm("focus", "obj_Focus", document.form);
	axon_event.addListenerForm("keyup", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("keypress", "obj_KeyPress", document.form)
	axon_event.addListener("keydown", "ComKeyEnter", "form");
	doActionIBSheet(sheetObj, document.form, IBCLEAR);
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1": // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 400;
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
			InitColumnInfo(8, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle1 = "Seq.|Booking Number|Agent|Office|User ID|Creation Date|BKG Creation Date|Use";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtSeq, 40, daCenter, false, "seq");
			InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "bkg_no",	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true,	"chn_agn_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,	"cre_ofc_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,	"cre_usr_id", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 150, daCenter, true,	"cre_dt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, true,	"bkg_cre_dt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "bkg_no_use_flg", false, "", dfNone, 0, false, false);

		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case IBCLEAR: // 화면 초기화
		if (sheetObj.id == "sheet1") {
			if (sheetObj.RowCount > 0) {
				sheetObj.RemoveAll();
			}
			formObj.reset();
			formObj.cre_ofc_cd.value = formObj.ofc_cd.value;
			formObj.cre_usr_id.value = formObj.usr_id.value;
			formObj.fm_cre_dt.value = ComGetDateAdd(null, "m", -1, "-");
			formObj.to_cre_dt.value = ComGetNowInfo("ymd", "-");
			formObj.cre_ofc_cd.focus();
		}
		break;
	case IBSEARCH: // 조회
		if (validateForm(sheetObj, formObj, sAction))
			if (sheetObj.id == "sheet1") {
				formObj.f_cmd.value = SEARCH;
				sheetObj
						.DoSearch("ESM_BKG_1060GS.do", FormQueryString(formObj));
			}

		break;

	case IBSAVE: // 저장
		if (validateForm(sheetObj, formObj, sAction))
			if (sheetObj.id == "sheet1") {
				formObj.f_cmd.value = MULTI;
				var sXml = sheetObj.GetSaveXml("ESM_BKG_1060GS.do", FormQueryString(formObj));
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					if (sheetObj.RowCount > 0) {
						sheetObj.RemoveAll();
					}
					sheetObj.LoadSaveXml(sXml, true);
					//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				} else {
					sheetObj.LoadSaveXml(sXml, true);
					ComSetFocus(formObj.cre_ofc_cd);
				}
			}

		break;

	case IBDOWNEXCEL: // Down Excel
		if (sheetObj.id == "sheet1") {
			sheetObj.SpeedDown2Excel(-1);
		}
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (sAction == IBSEARCH) {
			if (ComChkLen(formObj.cre_ofc_cd, 4) == 1) {
				ComShowCodeMessage("BKG00626", "B.Office");
				ComSetFocus(formObj.cre_ofc_cd);
				return false;
			}
			if (ComChkLen(formObj.fm_cre_dt, 10) != 2) {
				ComShowCodeMessage("BKG00626", "Creation Date(From)");
				ComSetFocus(formObj.fm_cre_dt);
				return false;
			}
			if (ComChkLen(formObj.to_cre_dt, 10) != 2) {
				ComShowCodeMessage("BKG00626", "Creation Date(To)");
				ComSetFocus(formObj.to_cre_dt);
				return false;
			}
		}
		else if (sAction == IBSAVE) {
			if (formObj.no_of_bkg.value < 1) {
				ComShowCodeMessage("BKG08063", "Number of BKG");
				ComSetFocus(formObj.no_of_bkg);
				return false;			
			}
			if (ComChkLen(formObj.act_chn_agn_cd, 2) != 2) {
				ComShowCodeMessage("BKG08063", "Agent Code");
				ComSetFocus(formObj.act_chn_agn_cd);
				return false;			
			}
		}
	}

	return true;
}

/**
 * 화면 폼 입력 필드에 Focus가 오면 값을 전체 선택 해줌 수정 편의를 위해
 */
function obj_Focus() {
	if (window.event.srcElement.getAttribute("type") == "text") {
		window.event.srcElement.select();
	}
}

/**
 * 화면 폼 입력 필드에 MaxLength 만큼 값이 들어오면, 자동으로 다음 필드로 Focus 이동 TAB 이나 BACK TAB은 막음
 */
function obj_KeyUp() {
	if (window.event.keyCode == 9 || window.event.keyCode == 16) {
		return false;
	}
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if ((srcName == "cre_ofc_cd" || srcName == "chn_agn_cd"
			|| srcName == "cre_usr_id" || srcName == "fm_cre_dt"
			|| srcName == "to_cre_dt" || srcName == "no_of_bkg" || srcName == "act_chn_agn_cd")
			&& ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}
/* 개발자 작업 끝 */