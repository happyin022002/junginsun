/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0111.js
 *@FileTitle : Budget P/F Type Selection Help 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.02.22
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.02.10 진마리아
 * 1.0 Creation
 * 
 * History
 * 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
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
 * @class VOP_VSK_0111 : VOP_VSK_0111 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0111() {
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

		case "btn_ok":
			var cnt = sheetObject1.RowCount;
			if (cnt > 0) {
				var pfSvcTpCd = sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_pf_svc_tp_cd");
				window.returnValue = pfSvcTpCd;
				comPopupOK();
			}

			break;

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

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);

		ComEndConfigSheet(sheetObjects[i]);

	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 240;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(6, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "|Sequence|P/F Type||";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			var prefix = "sheet1_";
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	prefix+"ibflag",				false,	"",     dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtSeq,				100,	daCenter,	false,	prefix+"rownum",			false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	false,	prefix+"pf_svc_tp_cd",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	false,	prefix+"slan_stnd_flg",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	false,	prefix+"vsl_slan_cd",			false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	false,	prefix+"vsl_slan_nm",		false,	"",		dfNone,			0,			true,		true);

		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: // 조회
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		formObj.f_cmd.value = COMMAND18;
		sheetObj.DoSearch("VOP_VSK_0111GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
		ComOpenWait(false);
		break;

	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
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
 * 부모창에 선택값 리턴
 */

function sheet1_OnDblClick(sheetObj, Row, Col) {
	window.returnValue = sheetObj.CellValue(Row, "sheet1_pf_svc_tp_cd");
	comPopupOK();
}

function sheet1_OnSearchEnd(sheetObj) {
	for ( var i = 0; i < sheetObj.Rows; i++) {
		if ("Y" == sheetObj.CellValue(i, 3)) {
			sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 255, 128);
		}
	}
}

/* 개발자 작업 끝 */