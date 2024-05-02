/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0250.js
 *@FileTitle : Port SKD Information(Pop-Up)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.02.16
 *@LastModifier : 유혁
 *@LastVersion : 1.0
 * 2009.06.17 유혁
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
 * @class VOP_VSK_0250 : VOP_VSK_0250 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0250() {
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
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Close":
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

function loadPage() {
	var formObj = document.form;

	for (i = 0; i < sheetObjects.length; i++) {

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	formObj.vsl_cd.readOnly = true;
	formObj.skd_voy_no.readOnly = true;
	formObj.skd_dir_cd.readOnly = true;
	formObj.vps_port_cd.readOnly = true;
	formObj.clpt_ind_seq.readOnly = true;
	formObj.skd_ind.readOnly = true;
	formObj.pf_eta_dt.readOnly = true;
	formObj.pf_etb_dt.readOnly = true;
	formObj.pf_etd_dt.readOnly = true;
	formObj.vps_eta_dt.readOnly = true;
	formObj.vps_etb_dt.readOnly = true;
	formObj.vps_etd_dt.readOnly = true;
	formObj.cng_ind.readOnly = true;
	formObj.vps_rmk.readOnly = true;
	formObj.vsl_eng_nm.readOnly = true;

	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 0;
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

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			// InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable],
			// [UserResize], [RowMove],[Head3D])
			InitHeadMode(false, false, false, false, false, false);

			// var HeadTitle = "|Seq|VVD";
			var HeadTitle = "|vsl_eng_nm|skd_ind|cng_ind|pf_eta_dt|pf_etb_dt|pf_etd_dt|vps_eta_dt|vps_etb_dt|vps_etd_dt|vps_rmk|clpt_ind_seq";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
			InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	false,	"vsl_eng_nm",	false,	"",		dfNone,				0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	false,	"skd_ind",		false,	"",		dfNone,				0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	false,	"cng_ind",		false,	"",		dfNone,				0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	false,	"pf_eta_dt",		false,	"",		dfNone,				0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	false,	"pf_etb_dt",		false,	"",		dfNone,				0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	false,	"pf_etd_dt",		false,	"",		dfNone,				0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	false,	"vps_eta_dt",	false,	"",		dfNone,				0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	false,	"vps_etb_dt",	false,	"",		dfNone,				0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	false,	"vps_etd_dt",	false,	"",		dfNone,				0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	false,	"vps_rmk",		false,	"",		dfNone,				0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,				60,	daCenter,	false,	"clpt_ind_seq",	false,	"",		dfNone,				0,			true,		true);
			CountPosition = 0;
		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch (sAction) {
		case IBSEARCH: // 조회
			if (validateForm(sheetObj, formObj, sAction)) {
				if (sheetObj.id == "sheet1") {
					ComOpenWait(true);
					formObj.f_cmd.value = SEARCH;
					var sParam = FormQueryString(formObj);
					sheetObj.DoSearch("VOP_VSK_0250GS.do", sParam);
					ComOpenWait(false);
	
					var i = 1;
					formObj.vsl_eng_nm.value = sheetObj.CellValue(1, i++);
					formObj.skd_ind.value = sheetObj.CellValue(1, i++);
					formObj.cng_ind.value = sheetObj.CellValue(1, i++);
					formObj.pf_eta_dt.value = sheetObj.CellValue(1, i++);
					formObj.pf_etb_dt.value = sheetObj.CellValue(1, i++);
					formObj.pf_etd_dt.value = sheetObj.CellValue(1, i++);
					formObj.vps_eta_dt.value = sheetObj.CellValue(1, i++);
					formObj.vps_etb_dt.value = sheetObj.CellValue(1, i++);
					formObj.vps_etd_dt.value = sheetObj.CellValue(1, i++);
					formObj.vps_rmk.value = sheetObj.CellValue(1, i++);
					formObj.clpt_ind_seq.value = sheetObj.CellValue(1, i++);
				}
			}
			break;
		default:
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage))
		// {
		// return false;
		// }
	}
	return true;
}

/* 개발자 작업 끝 */