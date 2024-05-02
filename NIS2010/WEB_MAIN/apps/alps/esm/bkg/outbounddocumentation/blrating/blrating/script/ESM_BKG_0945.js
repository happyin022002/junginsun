/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0945.js
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.18
 *@LastModifier : 이진서
 *@LastVersion : 1.0
 * 2009.06.18 이진서
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
 * @class esm_bkg_0945 : esm_bkg_0945 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0945() {
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
var sheetObjects = new Array();
var sheetCnt = 0;
var URL_ESM_BKG = 'ESM_BKG_0945GS.do';
var prefix1 = "sheet1_";
var prefix2 = "sheet2_";
var prefix3 = "sheet3_";
var prefix4 = "sheet4_";
var prefix5 = "sheet5_";
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	
	/*	if (document.form.bkg_no.value == '') {
	 ComShowCodeMessage("BKG00463");// 조회를 위한 BKG no가 없습니다.
	 self.close();
	 }*/

	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[4], document.form, IBSEARCH);
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
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

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	case "sheet1": // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 82;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			var HeadTitle1 = "|CURR|Exchange Rate|Exchange Rate|POL|VVD|ETD";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 10, 100);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "Status");

			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "curr_cd", false, "", dfNone, 0, 0,false, true);
			InitDataProperty(0, cnt++, dtData, 90, daRight,  true, "inv_xch_rt", false, "", dfNone, 0, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "l_curr_cd", false, "", dfNone, 0,0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "vps_port_cd", false, "", dfNone, 0,0, false, true);
			
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vsl", false, "", dfNone, 0,0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vps_etd_dt", false, "", dfNone, 0,0, false, true);
			CountPosition = 0;

		}
		break;
	case "sheet2": // sheet2 init
		with (sheetObj) {
			// 높이 설정
			style.height = 82;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			var HeadTitle1 = "|CURR|Exchange Rate|Exchange Rate|POD|VVD|ETD";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 10, 100);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "Status");

			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "curr_cd", false, "", dfNone, 0, 0,false, true);
			InitDataProperty(0, cnt++, dtData, 90, daRight,  true, "inv_xch_rt", false, "", dfNone, 0, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "l_curr_cd", false, "", dfNone, 0,0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "vps_port_cd", false, "", dfNone, 0,0, false, true);
			
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vsl", false, "", dfNone, 0,0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vps_etd_dt", false, "", dfNone, 0,0, false, true);
			CountPosition = 0;

		}
		break;
	case "sheet3": // sheet2 init
		with (sheetObj) {
			// 높이 설정
			style.height = 82;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			var HeadTitle1 = "|CURR|Exchange Rate|Exchange Rate|POL|VVD|ETD";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 10, 100);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "Status");

			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "curr_cd", false, "", dfNone, 0, 0,false, true);
			InitDataProperty(0, cnt++, dtData, 90, daRight,  true, "inv_xch_rt", false, "", dfNullFloat, 2, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "l_curr_cd", false, "", dfNone, 0,0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "vps_port_cd", false, "", dfNone, 0,0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vsl", false, "", dfNone, 0,0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vps_etd_dt", false, "", dfNone, 0,0, false, true);
			CountPosition = 0;

		}
		break;
	case "sheet4": // sheet2 init
		with (sheetObj) {
			// 높이 설정
			style.height = 82;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			var HeadTitle1 = "|CURR|Exchange Rate|Exchange Rate|POD|VVD|ETD";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 10, 100);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "Status");

			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "curr_cd", false, "", dfNone, 0, 0,false, true);
			InitDataProperty(0, cnt++, dtData, 90, daRight,  true, "inv_xch_rt", false, "", dfNullFloat, 2, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "l_curr_cd", false, "", dfNone, 0,0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "vps_port_cd", false, "", dfNone, 0,0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vsl", false, "", dfNone, 0,0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vps_etd_dt", false, "", dfNone, 0,0, false, true);

			CountPosition = 0;

		}
		break;
	case "sheet5": //sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 225;
			//전체 너비 설정

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(8, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle = "";

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,  "type");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,  "bkg_no");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,  "curr_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,  "l_curr_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,  "inv_xch_rt");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,  "vps_port_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,  "vsl");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,  "vps_etd_dt");

			CountPosition = 0;

		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var aryPrefix = new Array("");

	switch (sAction) {

	case IBSEARCH: //조회
		if (validateForm(sheetObj, formObj, sAction))
			//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.	
			ComSetObjValue(formObj.f_cmd, SEARCH);

		// 2.조회조건으로 조회실행
		sheetObj.DoSearch(URL_ESM_BKG, FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));

		break;

	}
}

/**
 * Sheet 조회완료 후 이벤트 발생
 */
function sheet5_OnSearchEnd(sheetObj, ErrMsg) {

	var formObj = document.form;
	var sheetObjTarget ;
	var cnt = sheetObj.TotalRows;
	if (cnt == 0)
		return;
	try {
		for (i = 1; i <= cnt; i++) {
			var type = sheetObj.CellValue(i, "type");
			if('p_' == type){
				sheetObjTarget = sheetObjects[0];
			}else if('c_' == type){
				sheetObjTarget = sheetObjects[1];
			}else if('tp_' == type){
				sheetObjTarget = sheetObjects[2];
			}else if('cp_' == type){
				sheetObjTarget = sheetObjects[3];
			}
			
			var nRow = sheetObjTarget.DataInsert(0);

			sheetObjTarget.CellValue(nRow, "curr_cd")		= sheetObj.CellValue(i, "curr_cd");
			sheetObjTarget.CellValue(nRow, "inv_xch_rt")	= sheetObj.CellValue(i, "inv_xch_rt");
			sheetObjTarget.CellValue(nRow, "l_curr_cd")		= sheetObj.CellValue(i, "l_curr_cd");
			sheetObjTarget.CellValue(nRow, "vps_port_cd")	= sheetObj.CellValue(i, "vps_port_cd");
			sheetObjTarget.CellValue(nRow, "vsl")			= sheetObj.CellValue(i, "vsl");
			sheetObjTarget.CellValue(nRow, "vps_etd_dt")	= sheetObj.CellValue(i, "vps_etd_dt");

			//IBS_CopyRowToForm(sheetObj, formObj, i, type);
			eval(type).style.display = '';
		}
	} catch (ex) {
		bkg_error_alert('sheet1_OnSearchEnd', ex);
		return false;
	}
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

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}
/**
 * bkg_error_alert 에러메세지 
 */
function bkg_error_alert(msg, ex) {
	alert('[ ' + msg + ' ] = [ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
}
/* 개발자 작업  끝 */