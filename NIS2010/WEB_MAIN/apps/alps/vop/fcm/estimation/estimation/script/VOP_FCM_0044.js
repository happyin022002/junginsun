/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : VOP_FCM_0044.js
 *@FileTitle : ROB End Month Report List (Pup-Up)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.10.04
 *@LastModifier : 유혁
 *@LastVersion : 1.0
 * 2011.10.04 유혁
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
 * @class VOP_FCM_0044 : VOP_FCM_0044 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0044() {
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
var ipageNo = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_New":
			sheetObject.RemoveAll();
			formObject.reset();
			break;

		case "btn_Close":
			self.close();
			break;

		case "btn_OK":
			comPopupOK();
			break;

		case "btn_Save":
			doSave();
			break;
			
//		case "btn2_Down_Excel":
//			sheetObject.Down2Excel(false, false, true, false, "", "", false, false, "", false, "0|1");
//			break;
			
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
	initControl();

	doActionIBSheet(sheetObjects[0], document.form, SEARCH);
}

function initControl() {
	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var prefix = "";
	sheetObj.prefix = prefix;

	switch (sheetNo) {
	case 1: // IBSheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 220;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			var HeadTitle = "|No.|Vessel\nCode|Voyage\nNo|Dir\nCD|Lane|FO|DO|HFO|LSFO|MDO|LSDO";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 9, 5000);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, false);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 40, daCenter, false, prefix + "ibflag", false, "", dfNone, 0, true, false);
			InitDataProperty(0, cnt++, dtSeq, 30, daCenter, false, prefix + "Seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, prefix + "vsl_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, prefix + "skd_voy_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, prefix + "skd_dir_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, prefix + "vsl_slan_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, prefix + "ttl_foil_rmn_wgt", false, "", dfNullFloat, 1, true, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, prefix + "ttl_doil_rmn_wgt", false, "", dfNullFloat, 1, true, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, prefix + "foil_rmn_wgt", false, "", dfNullFloat, 1, true, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, prefix + "low_sulp_foil_rmn_wgt", false, "", dfNullFloat, 1, true, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, prefix + "doil_rmn_wgt", false, "", dfNullFloat, 1, true, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, prefix + "low_sulp_doil_rmn_wgt", false, "", dfNullFloat, 1, true, false);
			// CountFormat = "[SELECTDATAROW / TOTALROWS]";

			RowHeight(0) = 35;
			WaitImageVisible = false;

		}
		break;

	}
}

function sheet1_OnScrollNext(sheet, CondParam, PageNo, OnePageRows) {
	// TODO:sheet에 해당하는 객체와 폼 오브젝트를 doActionIBSheet 함수에 보내 주어야합니다.
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true,
			PageNo);
}

function sheet1_OnSearchEnd(sheetObj){
	var start = sheetObj.HeaderRows;
	var end = start + sheetObj.SearchRows;
	for(var i=start; i<end; i++){
		getTtlWgt(sheetObj, i);
	}
}

function getTtlWgt(sheetObj, Row){
	var prefix = sheetObj.prefix;
	var tmp = "";
	var oil = 0;
	var lsoil = 0;
	
	tmp = sheetObj.CellValue(Row, prefix+"foil_rmn_wgt");
	if(tmp){
		oil = Number(tmp);
	}
	tmp = sheetObj.CellValue(Row, prefix+"low_sulp_foil_rmn_wgt");
	if(tmp){
		lsoil = Number(tmp);
	}
	sheetObj.CellValue2(Row, prefix+"ttl_foil_rmn_wgt") = oil + lsoil;
	
	oil = 0;
	lsoil = 0;
	
	tmp = sheetObj.CellValue(Row, prefix+"doil_rmn_wgt");
	if(tmp){
		oil = Number(tmp);
	}
	tmp = sheetObj.CellValue(Row, prefix+"low_sulp_doil_rmn_wgt");
	if(tmp){
		lsoil = Number(tmp);
	}
	sheetObj.CellValue2(Row, prefix+"ttl_doil_rmn_wgt") = oil + lsoil;
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {

	case SEARCH: // 조회
		var formObject = document.form;

		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			sheetObj.Redraw = false;
			formObj.f_cmd.value = SEARCH;
			var rXml = sheetObj.GetSearchXml("VOP_FCM_0044GS.do",
					FormQueryString(formObj));
			sheetObj.LoadSearchXml(rXml);
			sheetObj.Redraw = true;
			ComOpenWait(false);
		}
		break;
	case MULTI: // 페이징 조회

		ComOpenWait(true);
		formObj.f_cmd.value = MULTI;
		sheetObj.DoSave("VOP_FCM_0044GS.do", FormQueryString(formObj), -1, false);
		ComOpenWait(false);
		
		// sheetObj.DoSearch4Post("COM_ENS_0B2GS.do", selectVal, "iPage=" +
		// PageNo, true);
		break;

	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case SEARCH:
		var revYrmon = formObj.rev_yrmon.value;
		revYrmon = revYrmon.replace("-", "");

		if (revYrmon != "" && ComChkLen(revYrmon, 6) == 2) {
			return true;
		} else {
			ComShowCodeMessage("COM12114", "Revenue Month");
			return false;
		}
		break;
	}

	return true;
}

function doSave(){
	doActionIBSheet(sheetObjects[0], document.form, MULTI);
}
