/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_EQR_1021_01.js
 *@FileTitle : MTY COD Simulation 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.31
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.07.31 박광석
 * 1.0 Creation
 * ======================================================
 * 2011.06.13 나상보 [CHM-201111555-01] [EQR] R9 코드 생성에 따른 EQR 모듈 보완 작업 요청
 * 2012.10.30 문동선 [CHM-201220651-01] [EQR] EQR O5 Type Size 추가
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
 * @class EES_EQR_1021_01 : EES_EQR_1021_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_eqr_1021_01() {
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
var currentSheet = "";

var sheetObjects = new Array();
var sheetCnt = 0;
var keyId = "";
var findVvdMaxCount = 50;

var popupCnt = 0;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		// case "btn_mainretrieve":

		// searchVvd(document.form.searchvvd.value,document.form.searchvvd);
		// break;

		case "btn_s1retrieve":
			searchLane(sheetObjects[0], document.form.lane1.value, document.form.lane1);
			break;

		case "btn_s2retrieve":
			searchLane(sheetObjects[2], document.form.lane2.value, document.form.lane2);
			break;

		case "btn_s3retrieve":
			searchLane(sheetObjects[4], document.form.lane3.value, document.form.lane3);
			break;

		case "btn_s4retrieve":
			searchLane(sheetObjects[6], document.form.lane4.value, document.form.lane4);
			break;

		case "btn_s5retrieve":
			searchLane(sheetObjects[8], document.form.lane5.value, document.form.lane5);
			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			alert("지금은 사용하실 수가 없습니다 ");
		} else {
			alert(e);
		}
	}
}

/**
 * REMARK POPUP을 뛰운다.
 * @return
 */
function remarkPop() {
	var Row = sheetObjects[10].FindText("vvd", currentSheet.CellValue(currentSheet.SelectRow, "vvd"));

	ComOpenWindowCenter("/hanjin/EES_EQR_1054.do" + "?week=" + sheetObjects[10].CellValue(Row, "week") + "&lane=" + sheetObjects[10].CellValue(Row, "lane")
			+ "&vvd=" + sheetObjects[10].CellValue(Row, "vvd") + "&row=" + Row + "&weekdivision=" + sheetObjects[10].CellValue(Row, "weekdivision")
			+ "&remark=" + sheetObjects[10].CellValue(Row, "remark"), "EES_EQR_1054", 700, 420);

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

	var frmObj = document.form;
	axon_event.addListener('click', 'radio_click', 'tpsz', '');		// 옵션 컨테이너 사이즈 종류 설정에 CLICK 이벤트 처리.
	axon_event.addListenerForm('keypress', 'obj_keypress', frmObj);	// 화면의 FORM OBJECT에 KEYPRESS 이벤트를 설정.

	initControl();
}

/**
 * script 초기화
 * 
 * @return
 */
function initControl() {
/*
	ComBtnDisable("btn_s1add");
	ComBtnDisable("btn_s2add");
	ComBtnDisable("btn_s3add");
	ComBtnDisable("btn_s4add");
	ComBtnDisable("btn_s5add");

	ComBtnDisable("btn_s1del");
	ComBtnDisable("btn_s2del");
	ComBtnDisable("btn_s3del");
	ComBtnDisable("btn_s4del");
	ComBtnDisable("btn_s5del");
*/
	ComBtnDisable("btn_s1retrieve");
	ComBtnDisable("btn_s2retrieve");
	ComBtnDisable("btn_s3retrieve");
	ComBtnDisable("btn_s4retrieve");
	ComBtnDisable("btn_s5retrieve");

	parent.ComBtnDisable_frameLayer0("btn_remark");

	parent.ComBtnDisable_frameLayer0("btn_mainretrieve");

	this.scroll(324, 0);
}
 
function hideCursorBar(){
	sheetObjects[0].SelectRow = 0;
	sheetObjects[1].SelectRow = 0;
	sheetObjects[2].SelectRow = 0;
	sheetObjects[3].SelectRow = 0;
	sheetObjects[4].SelectRow = 0;
	sheetObjects[5].SelectRow = 0;
	sheetObjects[6].SelectRow = 0;
	sheetObjects[7].SelectRow = 0;
	sheetObjects[8].SelectRow = 0;
	sheetObjects[9].SelectRow = 0;
}

/**
 * searchLane
 * 
 * @param sheetObj
 * @param lane
 * @return
 */
function searchLane(sheetObj, lane, laneObj) {

	if (lane == "" || lane == null) {
		ComShowCodeMessage("EQR90196");
		laneObj.focus();

		return;
	}
	var flag = sheetObj.FindText(1, lane);
	if (flag == -1) {
		ComShowCodeMessage("EQR90197");
		laneObj.value = "";
		laneObj.focus();

		return;
	} else {
		// 해당 SHEET에서 같은  LANE에 FOCUS함.
		hideCursorBar();

		sheetObj.SelectCell(flag, 1, false);
	}
	laneObj.value = "";
}

/**
 * searchVvd
 * 
 * @param vvd
 * @return
 */
function searchVvd(vvd, vvdObj) {
	if (vvd == "" || vvd == null) {
		ComShowCodeMessage("EQR90198");
		vvdObj.focus();
		return;
	}

	var flag = sheetObjects[11].FindText(4, vvd);
	if (flag == -1) {
		ComShowCodeMessage("EQR90199");
		vvdObj.value = "";
		vvdObj.focus();
		return;
	} else {
		// 입력한 VVD 와 같은 VVD를 특정 SHEET에서 찾아 FOCUS를 주는 로직.
		var weekDivision = sheetObjects[11].CellValue(flag, 1);

		if (weekDivision == 1) {
			weekDivision = parseInt(weekDivision) - 1;
			this.scroll(0, 0);
		} else if (weekDivision == 2) {
			weekDivision = parseInt(weekDivision);
			this.scroll(0, 0);
		} else if (weekDivision == 3) {
			weekDivision = parseInt(weekDivision) + 1;
			this.scroll(324, 0);
		} else if (weekDivision == 4) {
			weekDivision = parseInt(weekDivision) + 2;
			this.scroll(900, 0);
		} else if (weekDivision == 5) {
			weekDivision = parseInt(weekDivision) + 3;
			this.scroll(900, 0);
		}
		hideCursorBar();
		var Row = sheetObjects[weekDivision].FindText(2, vvd);
		sheetObjects[weekDivision].focus();
		sheetObjects[weekDivision].SelectCell(Row, 2, false);

	}
	vvdObj.value = "";
}

/**
 * obj_keypress 키 입력시 대소문자 처리
 * 
 * @return
 */
function obj_keypress() {
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;

	switch (event.srcElement.name) {
	case "lane1":
		ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자만 입력허용
		if (keyValue == 13) {
			searchLane(sheetObjects[0], document.form.lane1.value, document.form.lane1);
		}
		break;
	case "lane2":
		ComKeyOnlyAlphabet('uppernum');
		if (keyValue == 13) {
			searchLane(sheetObjects[2], document.form.lane2.value, document.form.lane2);
		}
		break;
	case "lane3":
		ComKeyOnlyAlphabet('uppernum');
		if (keyValue == 13) {
			searchLane(sheetObjects[4], document.form.lane3.value, document.form.lane3);
		}
		break;
	case "lane4":
		ComKeyOnlyAlphabet('uppernum');
		if (keyValue == 13) {
			searchLane(sheetObjects[6], document.form.lane4.value, document.form.lane4);
		}
		break;
	case "lane5":
		ComKeyOnlyAlphabet('uppernum');
		if (keyValue == 13) {
			searchLane(sheetObjects[8], document.form.lane5.value, document.form.lane5);
		}
		break;
	}

}

/**
 * 컨테이너 사이즈 HEAD 가변
 * 
 * @return
 */
function radio_click() {
	var formObject = parent.document.form;
	var val = "";

	// 라디오 박스 형태의 현재 값을 알아 오기위한 로직.
	for ( var i = 0; i < formObject.tpsz.length; i++) {
		if (formObject.tpsz[i].checked) {
			val = formObject.tpsz[i].value;
		}
	}
	// 옵션별 컨테이너 사이즈 컬럼 조정 로직.
	if (val == "D") { // 옵션 DRY를 선택했을시 D2,D4,D5,D7 만을 보여준다.
		// 상단 그리드
		//for ( var i = 9; i < 22; i++) {
		for ( var i = 9; i < 23; i++) {	// SPCL HIDDEN
			sheetObjects[0].ColHidden(i) = true;
			sheetObjects[2].ColHidden(i) = true;
			sheetObjects[4].ColHidden(i) = true;
			sheetObjects[6].ColHidden(i) = true;
			sheetObjects[8].ColHidden(i) = true;
		}
		for ( var i = 5; i < 9; i++) {  // DRY SHOW
			sheetObjects[0].ColHidden(i) = false;
			sheetObjects[2].ColHidden(i) = false;
			sheetObjects[4].ColHidden(i) = false;
			sheetObjects[6].ColHidden(i) = false;
			sheetObjects[8].ColHidden(i) = false;
		}

		// 하단 그리드
		//for ( var i = 6; i < 19; i++) {
		for ( var i = 6; i < 20; i++) {	 // SPCL HIDDEN
			sheetObjects[1].ColHidden(i) = true;
			sheetObjects[3].ColHidden(i) = true;
			sheetObjects[5].ColHidden(i) = true;
			sheetObjects[7].ColHidden(i) = true;
			sheetObjects[9].ColHidden(i) = true;
		}
		for ( var i = 2; i < 6; i++) {  // DRY SHOW
			sheetObjects[1].ColHidden(i) = false;
			sheetObjects[3].ColHidden(i) = false;
			sheetObjects[5].ColHidden(i) = false;
			sheetObjects[7].ColHidden(i) = false;
			sheetObjects[9].ColHidden(i) = false;
		}

	} else if (val == "S") { // 옵션 SPECIAL를 선택했을시 R2,R5,O2,S2,O4,S4,F2,A2,F4,A4,F5 만을 보여준다.
		// 상단 그리드
		for ( var i = 5; i < 9; i++) { // DRY
			sheetObjects[0].ColHidden(i) = true;
			sheetObjects[2].ColHidden(i) = true;
			sheetObjects[4].ColHidden(i) = true;
			sheetObjects[6].ColHidden(i) = true;
			sheetObjects[8].ColHidden(i) = true;
		}
		//for ( var i = 9; i < 22; i++) { // SPCL
		for ( var i = 9; i < 23; i++) { // SPCL	
			sheetObjects[0].ColHidden(i) = false;
			sheetObjects[2].ColHidden(i) = false;
			sheetObjects[4].ColHidden(i) = false;
			sheetObjects[6].ColHidden(i) = false;
			sheetObjects[8].ColHidden(i) = false;
		}

		// 하단 그리드
		for ( var i = 2; i < 6; i++) { // DRY HIDDEN
			sheetObjects[1].ColHidden(i) = true;
			sheetObjects[3].ColHidden(i) = true;
			sheetObjects[5].ColHidden(i) = true;
			sheetObjects[7].ColHidden(i) = true;
			sheetObjects[9].ColHidden(i) = true;
		}
		//for ( var i = 6; i < 20; i++) { // SPCL HIDDEN
		for ( var i = 6; i < 21; i++) { // SPCL HIDDEN
			sheetObjects[1].ColHidden(i) = false;
			sheetObjects[3].ColHidden(i) = false;
			sheetObjects[5].ColHidden(i) = false;
			sheetObjects[7].ColHidden(i) = false;
			sheetObjects[9].ColHidden(i) = false;
		}
	} else { // 옵션 ALL을 선택하면 모든 컨테이너 사이즈를 보여줌.
		//for ( var i = 1; i < 22; i++) {	
		for ( var i = 1; i < 23; i++) {
			sheetObjects[0].ColHidden(i) = false;
			sheetObjects[1].ColHidden(i) = false;
			sheetObjects[2].ColHidden(i) = false;
			sheetObjects[3].ColHidden(i) = false;
			sheetObjects[4].ColHidden(i) = false;
			sheetObjects[5].ColHidden(i) = false;
			sheetObjects[6].ColHidden(i) = false;
			sheetObjects[7].ColHidden(i) = false;
			sheetObjects[8].ColHidden(i) = false;
			sheetObjects[9].ColHidden(i) = false;
		}
	}

}
/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo, HeadTitle) {

	var cnt = 0;
	var sheetId = sheetObj.id;

	switch (sheetId) {
	case "sheet1": // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 302;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone , msPrevColumnMerge +
			// msHeaderOnly]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			EditableColorDiff = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(29, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, true, true, false, false)

			// var HeadTitle1 = "2008-39 (Lane basis, 1st Asian port's
			// ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39 (Lane
			// basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)||||";
			var HeadTitle1 = "V|LANE|VVD|POD|ETB|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5|||||";

			if (HeadTitle != "" && HeadTitle != null) {
				HeadTitle1 = HeadTitle;
			}
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 15, daCenter, true, "div", false, "", dfNone, true, false);
			InitDataProperty(0, cnt++, dtData, 32, daCenter, true, "lane", false, "", dfNone, true, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vvd", false, "", dfNone, true, false);

			InitDataProperty(0, cnt++, dtCombo, 43, daCenter, false, "pod", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 34, daCenter, true, "etb", false, "", dfDateYmd, true, false);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "d2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "d4", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "d5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "d7", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "r2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "r5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "r9", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "o2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "s2", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "o4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "s4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "o5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "f2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "a2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "f4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "a4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "f5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "a5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "keyid");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "etbweekdivision");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "remarkflag");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "remark");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "firstetb");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "weekdivision");
			
			InitComboNoMatchText(true);

			InitViewFormat(0, "etb", "mm-dd");
			radio_click();
			FrozenCols = 5;
			CountPosition = 0;
			// FitColWidth("20|32|65|43|34|25|25|25|25|25|25|25|25|25|25|25|25|25|25|25|0|0|0|0");

		}
		break;

	case "sheet2": // sheet2 init
		with (sheetObj) {

			// 높이 설정
			style.height = 302;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			EditableColorDiff = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(29, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, true, true, false, false)

			// var HeadTitle1 = "2008-39 (Lane basis, 1st Asian port's
			// ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39 (Lane
			// basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)||||";
			var HeadTitle1 = "V|LANE|VVD|POD|ETB|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5|||||";

			if (HeadTitle != "" && HeadTitle != null) {
				HeadTitle1 = HeadTitle;
			}
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 15, daCenter, true, "div", false, "", dfNone, true, false);
			InitDataProperty(0, cnt++, dtData, 32, daCenter, true, "lane", false, "", dfNone, true, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vvd", false, "", dfNone, true, false);

			InitDataProperty(0, cnt++, dtCombo, 43, daCenter, false, "pod", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 34, daCenter, true, "etb", false, "", dfDateYmd, true, false);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "d2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "d4", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "d5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "d7", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "r2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "r5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "r9", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "o2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "s2", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "o4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "s4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "o5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "f2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "a2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "f4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "a4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "f5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "a5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "keyid");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "etbweekdivision");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "remarkflag");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "remark");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "firstetb");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "weekdivision");
			
			InitComboNoMatchText(true);

			InitViewFormat(0, "etb", "mm-dd");
			radio_click();
			FrozenCols = 5;
			CountPosition = 0;

		}
		break;

	case "sheet3": // sheet3 init
		with (sheetObj) {

			// 높이 설정
			style.height = 302;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			EditableColorDiff = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(29, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, true, true, false, false)

			// var HeadTitle1 = "2008-39 (Lane basis, 1st Asian port's
			// ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39 (Lane
			// basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)||||";
			var HeadTitle1 = "V|LANE|VVD|POD|ETB|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5|||||";

			if (HeadTitle != "" && HeadTitle != null) {
				HeadTitle1 = HeadTitle;
			}
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 15, daCenter, true, "div", false, "", dfNone, true, false);
			InitDataProperty(0, cnt++, dtData, 32, daCenter, true, "lane", false, "", dfNone, true, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vvd", false, "", dfNone, true, false);

			InitDataProperty(0, cnt++, dtCombo, 43, daCenter, false, "pod", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 34, daCenter, true, "etb", false, "", dfDateYmd, true, false);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "d2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "d4", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "d5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "d7", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "r2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "r5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "r9", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "o2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "s2", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "o4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "s4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "o5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "f2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "a2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "f4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "a4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "f5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "a5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "keyid");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "etbweekdivision");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "remarkflag");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "remark");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "firstetb");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "weekdivision");

			InitComboNoMatchText(true);

			InitViewFormat(0, "etb", "mm-dd");
			radio_click();
			FrozenCols = 5;
			CountPosition = 0;

		}
		break;
	case "sheet4": // sheet4 init
		with (sheetObj) {

			// 높이 설정
			style.height = 302;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			EditableColorDiff = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(29, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, true, true, false, false)

			// var HeadTitle1 = "2008-39 (Lane basis, 1st Asian port's
			// ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39 (Lane
			// basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)||||";
			var HeadTitle1 = "V|LANE|VVD|POD|ETB|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5|||||";

			if (HeadTitle != "" && HeadTitle != null) {
				HeadTitle1 = HeadTitle;
			}
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 15, daCenter, true, "div", false, "", dfNone, true, false);
			InitDataProperty(0, cnt++, dtData, 32, daCenter, true, "lane", false, "", dfNone, true, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vvd", false, "", dfNone, true, false);

			InitDataProperty(0, cnt++, dtCombo, 43, daCenter, false, "pod", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 34, daCenter, true, "etb", false, "", dfDateYmd, true, false);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "d2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "d4", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "d5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "d7", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "r2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "r5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "r9", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "o2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "s2", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "o4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "s4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "o5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "f2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "a2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "f4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "a4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "f5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "a5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "keyid");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "etbweekdivision");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "remarkflag");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "remark");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "firstetb");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "weekdivision");
			
			InitComboNoMatchText(true);

			InitViewFormat(0, "etb", "mm-dd");
			radio_click();
			FrozenCols = 5;
			CountPosition = 0;

		}
		break;
	case "sheet5": // sheet5 init
		with (sheetObj) {

			// 높이 설정
			style.height = 302;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			EditableColorDiff = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(29, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, true, true, false, false)

			// var HeadTitle1 = "2008-39 (Lane basis, 1st Asian port's
			// ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39 (Lane
			// basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)|2008-39
			// (Lane basis, 1st Asian port's ETB)|2008-39 (Lane basis, 1st Asian
			// port's ETB)|2008-39 (Lane basis, 1st Asian port's ETB)||||";
			var HeadTitle1 = "V|LANE|VVD|POD|ETB|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5|||||";

			if (HeadTitle != "" && HeadTitle != null) {
				HeadTitle1 = HeadTitle;
			}
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 15, daCenter, true, "div", false, "", dfNone, true, false);
			InitDataProperty(0, cnt++, dtData, 32, daCenter, true, "lane", false, "", dfNone, true, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vvd", false, "", dfNone, true, false);

			InitDataProperty(0, cnt++, dtCombo, 43, daCenter, false, "pod", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 34, daCenter, true, "etb", false, "", dfDateYmd, true, false);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "d2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "d4", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "d5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "d7", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "r2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "r5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "r9", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "o2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "s2", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "o4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "s4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "o5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "f2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "a2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "f4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "a4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "f5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "a5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "keyid");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "etbweekdivision");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "remarkflag");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "remark");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "firstetb");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "weekdivision");
			// InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,
			// "clptindseq");

			InitComboNoMatchText(true);

			InitViewFormat(0, "etb", "mm-dd");
			radio_click();
			FrozenCols = 5;
			CountPosition = 0;

		}
		break;
	 /*********************************************** 상단 그리드  끝*************************************************************************************/

	case "sheet6": // sheet6 init
		with (sheetObj) {

			// 높이 설정
			style.height = 262;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(20, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, true, true, false, false)

			// var HeadTitle1 = "|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)";
			var HeadTitle1 = "|MTY Dishcarge Vol|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5";

			if (HeadTitle != "" && HeadTitle != null) {
				HeadTitle1 = HeadTitle;
			}
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, false, "Status");
			InitDataProperty(0, cnt++, dtData, 145, daCenter, false, "pod", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "d2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "d4", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "d5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "d7", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "r2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "r5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "r9", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "o2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "s2", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "o4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "s4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "o5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "f2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "a2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "f4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "a4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "f5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "a5", false, "", dfInteger, true, true);

			radio_click();
			FrozenCols = 2;

			CountPosition = 0;

		}
		break;

	case "sheet7": // sheet7 init
		with (sheetObj) {

			// 높이 설정
			style.height = 262;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(20, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, true, true, false, false)

			// var HeadTitle1 = "|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)";
			var HeadTitle1 = "|MTY Dishcarge Vol|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5";

			if (HeadTitle != "" && HeadTitle != null) {
				HeadTitle1 = HeadTitle;
			}
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, false, "Status");
			InitDataProperty(0, cnt++, dtData, 145, daCenter, false, "pod", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "d2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "d4", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "d5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "d7", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "r2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "r5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "r9", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "o2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "s2", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "o4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "s4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "o5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "f2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "a2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "f4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "a4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "f5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "a5", false, "", dfInteger, true, true);

			radio_click();
			FrozenCols = 2;
			CountPosition = 0;

		}
		break;

	case "sheet8": // sheet8 init
		with (sheetObj) {

			// 높이 설정
			style.height = 262;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(20, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, true, true, false, false)

			// var HeadTitle1 = "|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)";
			var HeadTitle1 = "|MTY Dishcarge Vol|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5";

			if (HeadTitle != "" && HeadTitle != null) {
				HeadTitle1 = HeadTitle;
			}
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, false, "Status");
			InitDataProperty(0, cnt++, dtData, 145, daCenter, false, "pod", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "d2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "d4", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "d5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "d7", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "r2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "r5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "r9", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "o2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "s2", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "o4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "s4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "o5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "f2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "a2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "f4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "a4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "f5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "a5", false, "", dfInteger, true, true);

			radio_click();
			FrozenCols = 2;
			CountPosition = 0;

		}
		break;
	case "sheet9": // sheet9 init
		with (sheetObj) {

			// 높이 설정
			style.height = 262;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(20, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, true, true, false, false)

			// var HeadTitle1 = "|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)";
			var HeadTitle1 = "|MTY Dishcarge Vol|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5";

			if (HeadTitle != "" && HeadTitle != null) {
				HeadTitle1 = HeadTitle;
			}
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, false, "Status");
			InitDataProperty(0, cnt++, dtData, 145, daCenter, false, "pod", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "d2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "d4", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "d5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "d7", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "r2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "r5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "r9", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "o2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "s2", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "o4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "s4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "o5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "f2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "a2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "f4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "a4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "f5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "a5", false, "", dfInteger, true, true);

			radio_click();
			FrozenCols = 2;
			CountPosition = 0;

		}
		break;
	case "sheet10": // sheet10 init
		with (sheetObj) {

			// 높이 설정
			style.height = 262;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(20, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, true, true, false, false)

			// var HeadTitle1 = "|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)|2008-39 (Port
			// basis)|2008-39 (Port basis)|2008-39 (Port basis)";
			var HeadTitle1 = "|MTY Dishcarge Vol|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5";

			if (HeadTitle != "" && HeadTitle != null) {
				HeadTitle1 = HeadTitle;
			}
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, false, "Status");
			InitDataProperty(0, cnt++, dtData, 145, daCenter, false, "pod", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "d2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "d4", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "d5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "d7", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "r2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "r5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "r9", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "o2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "s2", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "o4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "s4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "o5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "f2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "a2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "f4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "a4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "f5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, false, "a5", false, "", dfInteger, true, true);

			radio_click();
			FrozenCols = 2;
			CountPosition = 0;

		}
		break;
	case "vvdTotal": // vvdTotal init
		with (sheetObj) {

			// 높이 설정
			style.height = 182;
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
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(11, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle1 = "1|2|3|4|5|6|7|8|9|10|11";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "weekdivision", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtData, 35, daCenter, true, "week", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "div", false, "", dfNone, true, true);

			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "vvd", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "lane", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "remarkflag", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, true, "status");
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "pod", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtData, 20, daLeft, true, "remark", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "mnlinpflg", false, "", dfNone, true, true);
			CountPosition = 0;

		}
		break;
	case "portTotal": // portTotal init
		with (sheetObj) {

			// 높이 설정
			style.height = 182;
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
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(35, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle1 = "1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "keyid");
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "weekdivision", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtData, 35, daCenter, true, "week", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "div", false, "", dfNone, true, true);

			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "vvd", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "lane", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "remarkflag", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "pod", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "idflag", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "etb", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "etbweek", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "etbweekdivision", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "d2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "d4", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "d5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "d7", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "r2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "r5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "r9", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "o2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "s2", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "o4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "s4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "o5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "f2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "a2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "f4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "a4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "f5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "a5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, true, "status");
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 20, daCenter, true, "hiddencheck");
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "yardcode", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "clptindseq", false, "", dfNone, true, true);
			CountPosition = 0;

		}
		break;
	
		/*********************************************** 하단 그리드 끝*************************************************************************************/

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: // 조회

		if (validateForm(sheetObj, formObj, sAction)) {
			this.scroll(324, 0);
			formObj.f_cmd.value = SEARCH01;
			formObj.week.value = parent.document.form.week.value.replace(/\/|\-|\./g, "");
			formObj.trade.value = parent.document.form.trade.value;
			initControl();

			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);

			var sXml = sheetObj.GetSearchXml("EES_EQR_1021_01GS.do", FormQueryString(formObj));

			var arrXml = sXml.split("|$$|");
			// SHEET 의 HEAD 정보를 붙여 가지고 온다.
			var week = ComGetEtcData(arrXml[0], "sHead");

			week = week.split(",");
			var week1 = week[0];
			var week2 = week[1];
			var week3 = week[2];
			var week4 = week[3];
			var week5 = week[4];

			// SHEET 1 ~ 12 까지의 해드 명을 만든후 SHEET를 다시 그린다..----------------------------------------------------------------
			var HeadTitle1 = "V|LANE|WK" + week1.substring(4, 6) + " VVD|POD|ETB|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5||||";

			var HeadTitle2 = "V|LANE|WK" + week2.substring(4, 6) + " VVD|POD|ETB|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5||||";

			var HeadTitle3 = "V|LANE|WK" + week3.substring(4, 6) + " VVD|POD|ETB|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5||||";

			/*
			 * var HeadTitle4 = week + " (Lane basis, 1st Asian port's ETB)|" +
			 * week + " (Lane basis, 1st Asian port's ETB)|" + week + " (Lane
			 * basis, 1st Asian port's ETB)|" + week + " (Lane basis, 1st Asian
			 * port's ETB)|" + week + " (Lane basis, 1st Asian port's ETB)|" +
			 * week + " (Lane basis, 1st Asian port's ETB)|" + week + " (Lane
			 * basis, 1st Asian port's ETB)|" + week + " (Lane basis, 1st Asian
			 * port's ETB)|" + week + " (Lane basis, 1st Asian port's ETB)|" +
			 * week + " (Lane basis, 1st Asian port's ETB)|" + week + " (Lane
			 * basis, 1st Asian port's ETB)|" + week + " (Lane basis, 1st Asian
			 * port's ETB)|" + week + " (Lane basis, 1st Asian port's ETB)|" +
			 * week + " (Lane basis, 1st Asian port's ETB)|" + week + " (Lane
			 * basis, 1st Asian port's ETB)|" + week + " (Lane basis, 1st Asian
			 * port's ETB)|" + week + " (Lane basis, 1st Asian port's ETB)|" +
			 * week + " (Lane basis, 1st Asian port's ETB)|" + week + " (Lane
			 * basis, 1st Asian port's ETB)|" + week + " (Lane basis, 1st Asian
			 * port's ETB)|";
			 * 
			 * week = week5.substring(0, 4) + "-" + week5.substring(4, 6);
			 */
			var HeadTitle4 = "V|LANE|WK" + week4.substring(4, 6) + " VVD|POD|ETB|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5||||";

			var HeadTitle5 = "V|LANE|WK" + week5.substring(4, 6) + " VVD|POD|ETB|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5||||";

			/*
			 * week = week1.substring(0, 4) + "-" + week1.substring(4, 6);
			 * 
			 * var HeadTitle6 = "|" + week + " (Port basis)|" + week + " (Port
			 * basis)|" + week + " (Port basis)|" + week + " (Port basis)|" +
			 * week + " (Port basis)|" + week + " (Port basis)|" + week + "
			 * (Port basis)|" + week + " (Port basis)|" + week + " (Port
			 * basis)|" + week + " (Port basis)|" + week + " (Port basis)|" +
			 * week + " (Port basis)|" + week + " (Port basis)|" + week + "
			 * (Port basis)|" + week + " (Port basis)|" + week + " (Port
			 * basis)";
			 */
			var HeadTitle6 = "|WK" + week1.substring(4, 6) +"("+ week1.substring(6) +")|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5";

			var HeadTitle7 = "|WK" + week2.substring(4, 6) +"("+ week2.substring(6) +")|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5";

			var HeadTitle8 = "|WK" + week3.substring(4, 6) +"("+ week3.substring(6) +")|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5";

			var HeadTitle9 = "|WK" + week4.substring(4, 6) +"("+ week4.substring(6) +")|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5";

			var HeadTitle10 = "|WK" + week5.substring(4, 6) +"("+ week5.substring(6) +")|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5";

			sheetObjects[0].Redraw = false;
			sheetObjects[0].RemoveAll();
			sheetObjects[0].Reset();
			sheetObjects[1].Redraw = false;
			sheetObjects[1].RemoveAll();
			sheetObjects[1].Reset();
			sheetObjects[2].Redraw = false;
			sheetObjects[2].RemoveAll();
			sheetObjects[2].Reset();
			sheetObjects[3].Redraw = false;
			sheetObjects[3].RemoveAll();
			sheetObjects[3].Reset();
			sheetObjects[4].Redraw = false;
			sheetObjects[4].RemoveAll();
			sheetObjects[4].Reset();
			sheetObjects[5].Redraw = false;
			sheetObjects[5].RemoveAll();
			sheetObjects[5].Reset();
			sheetObjects[6].Redraw = false;
			sheetObjects[6].RemoveAll();
			sheetObjects[6].Reset();
			sheetObjects[7].Redraw = false;
			sheetObjects[7].RemoveAll();
			sheetObjects[7].Reset();
			sheetObjects[8].Redraw = false;
			sheetObjects[8].RemoveAll();
			sheetObjects[8].Reset();
			sheetObjects[9].Redraw = false;
			sheetObjects[9].RemoveAll();
			sheetObjects[9].Reset();
			initSheet(sheetObjects[0], '', HeadTitle1);
			initSheet(sheetObjects[2], '', HeadTitle2);
			initSheet(sheetObjects[4], '', HeadTitle3);
			initSheet(sheetObjects[6], '', HeadTitle4);
			initSheet(sheetObjects[8], '', HeadTitle5);

			initSheet(sheetObjects[1], '', HeadTitle6);
			initSheet(sheetObjects[3], '', HeadTitle7);
			initSheet(sheetObjects[5], '', HeadTitle8);
			initSheet(sheetObjects[7], '', HeadTitle9);
			initSheet(sheetObjects[9], '', HeadTitle10);
			sheetObjects[0].Redraw = true;
			sheetObjects[1].Redraw = true;
			sheetObjects[2].Redraw = true;
			sheetObjects[3].Redraw = true;
			sheetObjects[4].Redraw = true;
			sheetObjects[5].Redraw = true;
			sheetObjects[6].Redraw = true;
			sheetObjects[7].Redraw = true;
			sheetObjects[8].Redraw = true;
			sheetObjects[9].Redraw = true;
			//------------------------------------------------------------------------------------------------------------------------------

			// SHEET 1 ~ 12 까지 데이타를 로드한다.
			if (arrXml.length > 0)
				sheetObjects[0].LoadSearchXml(arrXml[0]);
			if (arrXml.length > 1)
				sheetObjects[2].LoadSearchXml(arrXml[1]);
			if (arrXml.length > 2)
				sheetObjects[4].LoadSearchXml(arrXml[2]);
			if (arrXml.length > 3)
				sheetObjects[6].LoadSearchXml(arrXml[3]);
			if (arrXml.length > 4)
				sheetObjects[8].LoadSearchXml(arrXml[4]);

			if (arrXml.length > 5)
				sheetObjects[1].LoadSearchXml(arrXml[5]);
			if (arrXml.length > 6)
				sheetObjects[3].LoadSearchXml(arrXml[6]);
			if (arrXml.length > 7)
				sheetObjects[5].LoadSearchXml(arrXml[7]);
			if (arrXml.length > 8)
				sheetObjects[7].LoadSearchXml(arrXml[8]);
			if (arrXml.length > 9)
				sheetObjects[9].LoadSearchXml(arrXml[9]);
			if (arrXml.length > 10)
				sheetObjects[10].LoadSearchXml(arrXml[10]);
			if (arrXml.length > 11)
				sheetObjects[11].LoadSearchXml(arrXml[11]);
			
			sheetObj.WaitImageVisible = true;
			ComOpenWait(false);
			
		} else {
			ComSetFocus(parent.document.form.week);
			return;
		}
		break;

	case IBSAVE: // 저장
		if (validateForm(sheetObj, formObj, sAction))
			formObj.f_cmd.value = MULTI;
		var sParam1 = sheetObjects[10].GetSaveString(false, true, "status");

		if (sParam1 == "") { // 변경된 값이 없으면...
			ComShowCodeMessage("EQR90225");
			return;
		}

		

		 
		if (!ComShowCodeConfirm("EQR90192")) return;
		
		/*
		 * vvd_port_master sheet Delete 로직 <== Hidden 컨테이너 값이 모두 0이면 삭제처리하고 저장함.
		 */
		var deleteChecks = false;

		for ( var i = 1; i < sheetObjects[11].RowCount + 1; i++) {
			deleteChecks = false;
			// 숨긴 sheet 에서 etb 가 없고 입력 상태이면 
			if (sheetObjects[11].CellValue(i, "status") == "I" && (sheetObjects[11].CellValue(i, "etb") == "" || sheetObjects[11].CellValue(i, "etb") == "SKIP")) {

				//for ( var j = 12; j < 28; j++) {
				for ( var j = 12; j < 29; j++) {	
					if (sheetObjects[11].CellValue(i, j) != 0) {
						deleteChecks = true;
					}

				}
				if (deleteChecks == false) { // 컨테이너 값이 모두 0이면 삭제처리하고 저장함.
					sheetObjects[11].CellValue(i, "status") = "D";
				}

			}

		}
		/*
		  var Row = ""; 
		  for ( var i = 1 ; i < sheetObjects[11].RowCount + 1 ;  i++ ) { 
			  if(sheetObjects[11].CellValue(i,"status") == "I" &&  sheetObjects[11].CellValue(i,"etb") == ""){
		  
				  var sheet = eval("document.form.sheet"+sheetObjects[11].CellValue(i,"weekdivision"));
				  Row = sheet.FindText(3,sheetObjects[11].CellValue(i,"pod"));
				  if(sheet.CellValue(Row,"etb") == "" && sheetObjects[11].CellValue(i, "status") != 'D'){
					  ComShowCodeMessage("EQR90213",'ETB'); 
					  var weekDivision = sheetObjects[11].CellValue(i,"weekdivision"); 
					  if(weekDivision == 1){
						  this.scroll(0,0); 
					  } 
					  else if(weekDivision == 2){ 
						  this.scroll(0,0); 
					  }
					  else if(weekDivision == 3){ 
						  this.scroll(324,0); 
					  } 
					  else if(weekDivision == 4){ 
						  this.scroll(900,0); 
					  } else if(weekDivision == 5){ 
						  this.scroll(900,0); 
					  } 
					  sheet.focus(); 
					  sheet.SelectCell(Row, 3, false);
		  
					  break; 
				  } 
			  } 
		  }
		  
		  if(Row != ""){ //etb 항목에 대한 필수 입력누락 Row
			  return false; 
		  }		
*/
		var sParam2 = sheetObjects[11].GetSaveString(false);

		sParam1 = ComSetPrifix(sParam1, "sub");
		sParam = sParam1 + "&" + sParam2 + "&" + FormQueryString(formObj);
		
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);

		var sXml = sheetObj.GetSaveXml("EES_EQR_1021_01GS.do", sParam);
		sheetObjects[10].LoadSaveXml(sXml, false, "status");

		doActionIBSheet(sheetObjects[4], formObj, IBSEARCH);
		break;

	case IBINSERT: // 입력
		var row = sheetObj.DataInsert();
		// 나중에 비교하기 위해 키값을 만든다.(이미 조회되는 데이타는 서버측에서 만들어 온다.)
		keyId = sheetObjects[10].RowCount + sheetObjects[11].RowCount + 1; 
		if (sheetObj.SelectRow > 1) {
			sheetObj.CellValue2(sheetObj.SelectRow, 0) = sheetObj.CellValue(sheetObj.SelectRow - 1, 0);
			sheetObj.CellValue2(sheetObj.SelectRow, 1) = sheetObj.CellValue(sheetObj.SelectRow - 1, 1);
			sheetObj.CellValue2(sheetObj.SelectRow, 2) = sheetObj.CellValue(sheetObj.SelectRow - 1, 2);
			sheetObj.CellValue2(sheetObj.SelectRow, 21) = keyId;
		} else {
			sheetObj.CellValue2(sheetObj.SelectRow, 0) = sheetObj.CellValue(sheetObj.SelectRow, 0);
			sheetObj.CellValue2(sheetObj.SelectRow, 1) = sheetObj.CellValue(sheetObj.SelectRow, 1);
			sheetObj.CellValue2(sheetObj.SelectRow, 2) = sheetObj.CellValue(sheetObj.SelectRow, 2);
			sheetObj.CellValue2(sheetObj.SelectRow, 21) = keyId;

		}

		break;

	case IBDELETE: // 삭제
		if (!ComShowCodeConfirm("EQR90193"))
			return;
		var deleteCheck = false;
		var deleteNum = 0;
		var num = sheetObj.CellValue(sheetObj.SelectRow, 21);
		// port_summary sheet Delete 로직
		if (num != "") { // 삭제할 SUMMARY SHEET 선택 로직.
			if (num == "1") {
				num = "1";
			} else if (num == "2") {
				num = "3";
			} else if (num == "3") {
				num = "5";
			} else if (num == "4") {
				num = "7";
			} else if (num == "5") {
				num = "9";
			}
			for ( var i = 1; i < sheetObjects[num].RowCount + 1; i++) {
				if (sheetObj.CellText(sheetObj.SelectRow, 3) == sheetObjects[num].CellValue(i, 1)) {
					//for ( var j = 2; j < 18; j++) { //  컨테이너 위치
					for ( var j = 2; j < 19; j++) { //  컨테이너 위치		
						// 삭제한 ROW의 데이터를 SUMMARY POD SHEET 에서도 값을 지워 준다.
						sheetObjects[num].CellValue(i, j) = sheetObjects[num].CellValue(i, j) - sheetObj.CellValue(sheetObj.SelectRow, j + 3);
						if (sheetObjects[num].CellValue(i, j) != 0) {
							deleteCheck = true;
						}

					}
					deleteNum = i;
					break;
				}
			}
			if (deleteCheck == false) { // 컨테이너값이 모두 0이면 자동 삭제 처리.
				sheetObjects[num].RowDelete(deleteNum, false);
			}
		}

		// vvd_port_master sheet Delete 로직 <== Hidden
		deleteCheck = false;
		for ( var i = 1; i < sheetObjects[11].RowCount + 1; i++) {
			if (sheetObjects[11].CellValue(i, 0) == sheetObj.CellValue(sheetObj.SelectRow, 21)) {

				//for ( var j = 12; j < 28; j++) {
				for ( var j = 12; j < 29; j++) {		
					sheetObjects[11].CellValue2(i, j) = sheetObjects[11].CellValue(i, j) - sheetObj.CellValue(sheetObj.SelectRow, j - 7);
					if (sheetObjects[11].CellValue(i, j) != 0) {
						deleteCheck = true;
					}

				}
				// sheetObjects[11].CellValue(i, "status") = "I";
				// ComDebug(sheetObjects[11].CellValue(i, "status"));
				deleteNum = i;
				deleteDetail(sheetObj, sheetObj.SelectRow); // 삭제 상세 로직으로...
			}

		}
		if (deleteCheck == false) {
			sheetObjects[11].CellValue(deleteNum, "status") = "I";
			// sheetObjects[11].RowDelete(deleteNum, false);
		}
		sheetObj.RowDelete(sheetObj.SelectRow, false);

		sheetObj.HideSubSum();
		sheetObj.ShowSubSum("2", "5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21", true, false, false, -1, "0=;2=Total");

		break;

	}
}

/**
 * 삭제 상세 로직(hidden sheet 삭제 로직)
 * 
 * @param sheetObj
 * @param Row
 * @return
 */
function deleteDetail(sheetObj, Row) {
	// var check = false;
	// vvd master sheet 컨트롤
	// 숨겨놓은 sheetObjects[10],sheetObjects[11] SHEET에 상태를 바꾼다.
	for ( var i = 1; i < sheetObjects[10].RowCount + 1; i++) {
		if (sheetObjects[10].CellValue(i, 3) == sheetObj.CellValue(Row, 2)) { // VVD가 같으면...
			sheetObjects[10].CellValue2(i, 6) = "I"; // 입력,수정 발생
			break;
		}
	}

	// vvd_port_master sheet 컨트롤
	// check = false;
	for ( var i = 1; i < sheetObjects[11].RowCount + 1; i++) {

		if (sheetObjects[11].CellValue(i, 4) == sheetObj.CellValue(Row, 2)) { // VVD가 같으면...
			sheetObjects[11].CellValue2(i, 28) = "I";

		}
	}
}

/**
 * sheet1_OnClick클릭 이벤트 처리
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnClick(sheetObj, Row, Col) {
	currentSheet = sheetObj;
	// VVD 와 PORT 가 존재하면... 
	if (ComGetLenByByte(sheetObj.CellValue(Row, 2)) > 0 && ComGetLenByByte(sheetObj.CellText(Row, 3)) > 0) {
		parent.ComBtnEnable_frameLayer0("btn_remark");
	} else {
		parent.ComBtnDisable_frameLayer0("btn_remark");
	}
	// POD 컬럼을 클릭시에 발생(POD,ETB IS NULL)
	if (Col == 3 && sheetObj.CellValue(Row, 4) == "" && sheetObj.CellText(Row, 3) == "" && sheetObj.CellValue(Row, 0) != "") {
		document.form.vvd.value = sheetObj.CellValue(Row, 2);

		if (sheetObj.GetComboInfo(Row, Col, "Text") == "") {
			document.form.f_cmd.value = SEARCH02;
			var sXml = sheetObj.GetSearchXml("EES_EQR_1021_01GS.do", FormQueryString(document.form));
			var cols = ComXml2ComboString(sXml, "pod", "etb");

			sheetObj.CellComboItem(Row, "pod", "| |" + cols[0], "| |" + cols[1]);
		}
	} else {
		// 기존 조회된 데이타는 POD 수정 불가
		if (sheetObj.CellValue(Row, 4) != "") {
			sheetObj.CellEditable(Row, 3) = false;
		}
	}
}


var OrgValue = "";
/*
function sheet1_OnBeforeEdit(sheetObj, Row, Col) {
	OrgValue = sheetObj.CellValue(Row, Col);
} 
*/

/**
 * sheet1에서 컨테이너 타입에 따른 수를 입력시 EDIT 전에 데이타를 변수에 담아둔다.
 */
function sheet1_OnKeyDown(sheetObj,Row, Col, KeyCode, Shift) {
	OrgValue = sheetObj.CellValue(Row, Col);
	
}
/**
 * sheet2에서 컨테이너 타입에 따른 수를 입력시 EDIT 전에 데이타를 변수에 담아둔다.
 */
function sheet2_OnKeyDown(sheetObj,Row, Col, KeyCode, Shift) {
	OrgValue = sheetObj.CellValue(Row, Col);
}
/**
 * sheet3에서 컨테이너 타입에 따른 수를 입력시 EDIT 전에 데이타를 변수에 담아둔다.
 */
function sheet3_OnKeyDown(sheetObj,Row, Col, KeyCode, Shift) {
	OrgValue = sheetObj.CellValue(Row, Col);
}
/**
 * sheet4에서 컨테이너 타입에 따른 수를 입력시 EDIT 전에 데이타를 변수에 담아둔다.
 */
function sheet4_OnKeyDown(sheetObj,Row, Col, KeyCode, Shift) {
	OrgValue = sheetObj.CellValue(Row, Col);
}
/**
 * sheet5에서 컨테이너 타입에 따른 수를 입력시 EDIT 전에 데이타를 변수에 담아둔다.
 */
function sheet5_OnKeyDown(sheetObj,Row, Col, KeyCode, Shift) {
	OrgValue = sheetObj.CellValue(Row, Col);
}

/**
 * sheet1_OnChange 이벤트 발생시
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {

	with (sheetObj) {
		var formObj = document.form;
		if (Col == 3) { // POD 컬럼
			var arrcode = Value.split("&&");

			var rCnt01 = RowCount + 1;
			// 자기자신을 제외하고 비교 하기위해 for문을 2번 사용함
			for ( var i = 1; i < Row; i++) {
				if (CellText(i, Col) == arrcode[3] && CellText(i, "vvd") == CellText(Row, "vvd")) { // 동일한
					// POD코드가
					// 존재하면
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					CellValue2(Row, Col + 1) = "";
					return false;
				}
			}
			for ( var i = Row + 1; i < rCnt01; i++) {
				if (CellText(i, Col) == arrcode[3] && CellText(i, "vvd") == CellText(Row, "vvd")) { // 동일한
					// POD코드가
					// 존재하면
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					CellValue2(Row, Col + 1) = "";
					return false;
				}
			}

			CellValue2(Row, 4) = arrcode[0]; // ETB
			//CellValue2(Row, 23) = arrcode[2]; // etbweekdivision
			CellValue2(Row, 24) = arrcode[2]; // etbweekdivision

		} else {
			if (Col > 4) { // 컨테이너 사이즈 컬럼 부터
				CellFontColor(Row, Col) = RgbColor(0, 0, 255);
				CellFont("FontBold", Row, Col) = true;

				var check = false;
				// vvd master sheet 컨트롤
				for ( var i = 1; i < sheetObjects[10].RowCount + 1; i++) {
					if (sheetObjects[10].CellValue(i, 3) == CellValue(Row, 2)) {
						sheetObjects[10].CellValue2(i, 6) = "I"; // 입력,수정 발생
						// STATUS
						check = true;
						break;
					}
				} 

				// vvd_port_master sheet 컨트롤
				check = false;
				var vvdRow1 = sheetObjects[11].FindText(0, CellValue(Row, 22));

				if (vvdRow1 == -1) {
					check = false;
				} else {
					sheetObjects[11].CellValue2(vvdRow1, Col + 7) = Value;

					check = true;
				}

				// 해당 VVD 관련된 POD를 찾아서 입력 상태로 STATUS 변경 로직.
				var vvdRowStart = sheetObjects[11].FindText(4, CellValue(Row, 2));
				var vvdRowEnd = "";
				if (vvdRowStart == -1) {
					vvdRowStart = 1;
				} else {
					if ((sheetObjects[11].RowCount - vvdRowStart) > findVvdMaxCount) { // 같은 VVD가 50개 이하라고 생각하고 만듬. 
						vvdRowEnd = vvdRowStart + findVvdMaxCount;
					} else {
						vvdRowEnd = sheetObjects[11].RowCount + 1;
					}
				}

				for ( var i = vvdRowStart; i < vvdRowEnd; i++) {

					if (sheetObjects[11].CellValue(i, 4) == CellValue(Row, 2)) {
						//sheetObjects[11].CellValue2(i, 29) = "I";
						sheetObjects[11].CellValue2(i, 30) = "I";
					}
				}

				// vvd_port_master --> AddRow
				if (check == false) { // POD가 존재 하지 않으면 새로 생성한다.
					var row = sheetObjects[11].DataInsert();

					sheetObjects[11].CellValue2(row, 0) = keyId;
					sheetObjects[11].CellValue2(row, 3) = CellValue(Row, 0);
					sheetObjects[11].CellValue2(row, 4) = CellValue(Row, 2);
					sheetObjects[11].CellValue2(row, 5) = CellValue(Row, 1);
					sheetObjects[11].CellValue2(row, 6) = CellValue(Row, 22);
					sheetObjects[11].CellValue2(row, 7) = CellText(Row, 3);
					sheetObjects[11].CellValue2(row, 9) = CellValue(Row, 4);

					sheetObjects[11].CellValue2(row, 29) = "I";
					//for ( var i = 5; i < 22; i++) {
					for ( var i = 5; i < 23; i++) {	
						sheetObjects[11].CellValue2(row, i + 7) = Value;
						break;
					}

				}
				// 소계 다시 계산
				// HideSubSum();
				ShowSubSum("2", "5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22", true, false, false, -1, "0=;2=Total");

				// 1~5주차 SUMMARY POD SHEET에 값들을 변경 한다.
				if (CellValue(Row, 23) == '1') { // 기준 Week의 -2주전 Sheet 값 변경
					check = false;
					for ( var i = 1; i < sheetObjects[1].RowCount + 1; i++) {
						if (sheetObjects[1].CellValue(i, 1) == CellText(Row, 3)) {
							// 컨테이너 값 입력시 변경
							sheetObjects[1].CellValue2(i, Col - 3) = parseInt(sheetObjects[1].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[1].DataInsert();
						sheetObjects[1].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[1].CellValue2(row, Col - 3) = Value;
					}

				//} else if (CellValue(Row, 23) == '2') { // 기준 Week의 -1주전 Sheet 값
				} else if (CellValue(Row, 24) == '2') { // 기준 Week의 -1주전 Sheet 값	
					// 변경
					check = false;
					for ( var i = 1; i < sheetObjects[3].RowCount + 1; i++) {
						if (sheetObjects[3].CellValue(i, 1) == CellText(Row, 3)) {

							sheetObjects[3].CellValue2(i, Col - 3) = parseInt(sheetObjects[3].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[3].DataInsert();
						sheetObjects[3].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[3].CellValue2(row, Col - 3) = Value;
					}
				//} else if (CellValue(Row, 23) == '3') { // 기준 Week의 Sheet 값 변경
				} else if (CellValue(Row, 24) == '3') { // 기준 Week의 Sheet 값 변경		
					check = false;
					for ( var i = 1; i < sheetObjects[5].RowCount + 1; i++) {
						if (sheetObjects[5].CellValue(i, 1) == CellText(Row, 3)) {

							sheetObjects[5].CellValue2(i, Col - 3) = parseInt(sheetObjects[5].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[5].DataInsert();
						sheetObjects[5].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[5].CellValue2(row, Col - 3) = Value;
					}
				//} else if (CellValue(Row, 23) == '4') { // 기준 Week의 +1주전 Sheet 값
				} else if (CellValue(Row, 24) == '4') { // 기준 Week의 +1주전 Sheet 값		
					// 변경
					check = false;
					for ( var i = 1; i < sheetObjects[7].RowCount + 1; i++) {
						if (sheetObjects[7].CellValue(i, 1) == CellText(Row, 3)) {

							sheetObjects[7].CellValue2(i, Col - 3) = parseInt(sheetObjects[7].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[7].DataInsert();
						sheetObjects[7].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[7].CellValue2(row, Col - 3) = Value;
					}
				//} else if (CellValue(Row, 23) == '5') { // 기준 Week의 +2주전 Sheet 값
				} else if (CellValue(Row, 24) == '5') { // 기준 Week의 +2주전 Sheet 값					
					// 변경
					check = false;
					for ( var i = 1; i < sheetObjects[9].RowCount + 1; i++) {
						if (sheetObjects[9].CellValue(i, 1) == CellText(Row, 3)) {

							sheetObjects[9].CellValue2(i, Col - 3) = parseInt(sheetObjects[9].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[9].DataInsert();
						sheetObjects[9].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[9].CellValue2(row, Col - 3) = Value;
					}
				}
				/*
				 * var sCheck = false; var rowIds = 0; for( var i = 2 ; i <
				 * RowCount + 2 ; i++ ) { if(CellText(i,3) == 'ZZOPT' &&
				 * CellValue(Row,2) == CellValue(i,2)){ //
				 * ComDebug(CellSearchValue(Row,Col)+" "+Value+" "+Row+"
				 * "+CellValue(Row,Col)+" "+EditValue+" "+Col);
				 * 
				 * ComDebug(OrgValue); if(CellValue(i,Col) > 0){ if(Value -
				 * OrgValue > 0){ CellValue2(i,Col) = CellValue(i,Col) -
				 * Math.abs(Value - OrgValue); } } rowIds = i; for ( var j = 5 ;
				 * j < 20 ; j++ ) { if(CellValue(i,j) != 0){ sCheck = true;
				 * break; } }
				 * 
				 * break; } }
				 * 
				 * if(sCheck == false){ RowDelete(rowIds,false); }
				 */

			}
		}

	}
}

/**
 * sheet2_OnClick클릭 이벤트 처리
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet2_OnClick(sheetObj, Row, Col) {
	currentSheet = sheetObj;
	if (ComGetLenByByte(sheetObj.CellValue(Row, 2)) > 0 && ComGetLenByByte(sheetObj.CellText(Row, 3)) > 0) {
		parent.ComBtnEnable_frameLayer0("btn_remark");
	} else {
		parent.ComBtnDisable_frameLayer0("btn_remark");
	}

	if (Col == 3 && sheetObj.CellValue(Row, 4) == "" && sheetObj.CellText(Row, 3) == "" && sheetObj.CellValue(Row, 0) != "") {
		// if(sheetObj.RowCount > 0){
		document.form.vvd.value = sheetObj.CellValue(Row, 2);
		if (sheetObj.GetComboInfo(Row, Col, "Text") == "") {
			document.form.f_cmd.value = SEARCH02;
			var sXml = sheetObj.GetSearchXml("EES_EQR_1021_01GS.do", FormQueryString(document.form));
			var cols = ComXml2ComboString(sXml, "pod", "etb");

			sheetObj.CellComboItem(Row, "pod", "| |" + cols[0], "| |" + cols[1]);
		}
		// }
	} else {
		// 기존 조회된 데이타는 POD 수정 불가
		if (sheetObj.CellValue(Row, 4) != "") {
			sheetObj.CellEditable(Row, 3) = false;
		}
	}
}

/**
 * sheet2_OnChange 이벤트 발생시
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet2_OnChange(sheetObj, Row, Col, Value) {

	with (sheetObj) {
		var formObj = document.form;
		if (Col == 3) { // POD 컬럼
			var arrcode = Value.split("&&");

			var rCnt01 = RowCount + 1;
			// 자기자신을 제외하고 비교 하기위해 for문을 2번 사용함
			for ( var i = 1; i < Row; i++) {
				if (CellText(i, Col) == arrcode[3] && CellText(i, "vvd") == CellText(Row, "vvd")) { // 동일한
					// POD코드가
					// 존재하면
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					CellValue2(Row, Col + 1) = "";
					return false;
				}
			}
			for ( var i = Row + 1; i < rCnt01; i++) {
				if (CellText(i, Col) == arrcode[3] && CellText(i, "vvd") == CellText(Row, "vvd")) { // 동일한
					// POD코드가
					// 존재하면
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					CellValue2(Row, Col + 1) = "";
					return false;
				}
			}

			CellValue2(Row, 4) = arrcode[0]; // ETB
			//CellValue2(Row, 23) = arrcode[2]; // etbweekdivision
			CellValue2(Row, 24) = arrcode[2]; // etbweekdivision	

		} else {
			if (Col > 4) { // 컨테이너 사이즈 컬럼 부터
				CellFontColor(Row, Col) = RgbColor(0, 0, 255);
				CellFont("FontBold", Row, Col) = true;

				var check = false;
				// vvd master sheet 컨트롤
				for ( var i = 1; i < sheetObjects[10].RowCount + 1; i++) {
					if (sheetObjects[10].CellValue(i, 3) == CellValue(Row, 2)) {
						sheetObjects[10].CellValue2(i, 6) = "I"; // 입력,수정 발생
						// STATUS
						check = true;
						break;
					}
				} 

				// vvd_port_master sheet 컨트롤
				check = false;
				//var vvdRow1 = sheetObjects[11].FindText(0, CellValue(Row, 22));
				var vvdRow1 = sheetObjects[11].FindText(0, CellValue(Row, 23));

				if (vvdRow1 == -1) {
					check = false;
				} else {
					sheetObjects[11].CellValue2(vvdRow1, Col + 7) = Value;

					check = true;
				}

				// 해당 VVD 관련된 POD를 찾아서 입력 상태로 STATUS 변경 로직.
				var vvdRowStart = sheetObjects[11].FindText(4, CellValue(Row, 2));
				var vvdRowEnd = "";
				if (vvdRowStart == -1) {
					vvdRowStart = 1;
				} else {
					if ((sheetObjects[11].RowCount - vvdRowStart) > findVvdMaxCount) { // 같은 VVD가 50개 이하라고 생각하고 만듬. 
						vvdRowEnd = vvdRowStart + findVvdMaxCount;
					} else {
						vvdRowEnd = sheetObjects[11].RowCount + 1;
					}
				}

				for ( var i = vvdRowStart; i < vvdRowEnd; i++) {

					if (sheetObjects[11].CellValue(i, 4) == CellValue(Row, 2)) {
						//sheetObjects[11].CellValue2(i, 29) = "I";
						sheetObjects[11].CellValue2(i, 30) = "I";	
					}
				}

				// vvd_port_master --> AddRow
				if (check == false) { // POD가 존재 하지 않으면 새로 생성한다.
					var row = sheetObjects[11].DataInsert();

					sheetObjects[11].CellValue2(row, 0) = keyId;
					sheetObjects[11].CellValue2(row, 3) = CellValue(Row, 0);
					sheetObjects[11].CellValue2(row, 4) = CellValue(Row, 2);
					sheetObjects[11].CellValue2(row, 5) = CellValue(Row, 1);
					sheetObjects[11].CellValue2(row, 6) = CellValue(Row, 22);
					sheetObjects[11].CellValue2(row, 7) = CellText(Row, 3);
					sheetObjects[11].CellValue2(row, 9) = CellValue(Row, 4);

					//sheetObjects[11].CellValue2(row, 29) = "I";
					sheetObjects[11].CellValue2(row, 30) = "I";	
					for ( var i = 5; i < 22; i++) {
						sheetObjects[11].CellValue2(row, i + 7) = Value;
						break;
					}

				}
				// 소계 다시 계산
				// HideSubSum();
				ShowSubSum("2", "5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22", true, false, false, -1, "0=;2=Total");

				// 1~5주차 SUMMARY POD SHEET에 값들을 변경 한다.
				//if (CellValue(Row, 23) == '1') { // 기준 Week의 -2주전 Sheet 값 변경
				if (CellValue(Row, 24) == '1') { // 기준 Week의 -2주전 Sheet 값 변경	
					check = false;
					for ( var i = 1; i < sheetObjects[1].RowCount + 1; i++) {
						if (sheetObjects[1].CellValue(i, 1) == CellText(Row, 3)) {
							// 컨테이너 값 입력시 변경
							sheetObjects[1].CellValue2(i, Col - 3) = parseInt(sheetObjects[1].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[1].DataInsert();
						sheetObjects[1].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[1].CellValue2(row, Col - 3) = Value;
					}

				//} else if (CellValue(Row, 23) == '2') { // 기준 Week의 -1주전 Sheet 값
				} else if (CellValue(Row, 24) == '2') { // 기준 Week의 -1주전 Sheet 값		
					// 변경
					check = false;
					for ( var i = 1; i < sheetObjects[3].RowCount + 1; i++) {
						if (sheetObjects[3].CellValue(i, 1) == CellText(Row, 3)) {

							sheetObjects[3].CellValue2(i, Col - 3) = parseInt(sheetObjects[3].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[3].DataInsert();
						sheetObjects[3].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[3].CellValue2(row, Col - 3) = Value;
					}
				//} else if (CellValue(Row, 23) == '3') { // 기준 Week의 Sheet 값 변경
				} else if (CellValue(Row, 24) == '3') { // 기준 Week의 Sheet 값 변경					
					check = false;
					for ( var i = 1; i < sheetObjects[5].RowCount + 1; i++) {
						if (sheetObjects[5].CellValue(i, 1) == CellText(Row, 3)) {

							sheetObjects[5].CellValue2(i, Col - 3) = parseInt(sheetObjects[5].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[5].DataInsert();
						sheetObjects[5].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[5].CellValue2(row, Col - 3) = Value;
					}
				//} else if (CellValue(Row, 23) == '4') { // 기준 Week의 +1주전 Sheet 값
				} else if (CellValue(Row, 24) == '4') { // 기준 Week의 +1주전 Sheet 값					
					// 변경
					check = false;
					for ( var i = 1; i < sheetObjects[7].RowCount + 1; i++) {
						if (sheetObjects[7].CellValue(i, 1) == CellText(Row, 3)) {

							sheetObjects[7].CellValue2(i, Col - 3) = parseInt(sheetObjects[7].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[7].DataInsert();
						sheetObjects[7].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[7].CellValue2(row, Col - 3) = Value;
					}
				//} else if (CellValue(Row, 23) == '5') { // 기준 Week의 +2주전 Sheet 값
				} else if (CellValue(Row, 24) == '5') { // 기준 Week의 +2주전 Sheet 값					
					// 변경
					check = false;
					for ( var i = 1; i < sheetObjects[9].RowCount + 1; i++) {
						if (sheetObjects[9].CellValue(i, 1) == CellText(Row, 3)) {

							sheetObjects[9].CellValue2(i, Col - 3) = parseInt(sheetObjects[9].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[9].DataInsert();
						sheetObjects[9].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[9].CellValue2(row, Col - 3) = Value;
					}
				}
				/*
				 * var sCheck = false; var rowIds = 0; for( var i = 2 ; i <
				 * RowCount + 2 ; i++ ) { if(CellText(i,3) == 'ZZOPT' &&
				 * CellValue(Row,2) == CellValue(i,2)){ //
				 * ComDebug(CellSearchValue(Row,Col)+" "+Value+" "+Row+"
				 * "+CellValue(Row,Col)+" "+EditValue+" "+Col);
				 * 
				 * ComDebug(OrgValue); if(CellValue(i,Col) > 0){ if(Value -
				 * OrgValue > 0){ CellValue2(i,Col) = CellValue(i,Col) -
				 * Math.abs(Value - OrgValue); } } rowIds = i; for ( var j = 5 ;
				 * j < 20 ; j++ ) { if(CellValue(i,j) != 0){ sCheck = true;
				 * break; } }
				 * 
				 * break; } }
				 * 
				 * if(sCheck == false){ RowDelete(rowIds,false); }
				 */

			}
		}

	}
}

/**
 * sheet3_OnClick클릭 이벤트 처리
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet3_OnClick(sheetObj, Row, Col) {
	currentSheet = sheetObj;
	if (ComGetLenByByte(sheetObj.CellValue(Row, 2)) > 0 && ComGetLenByByte(sheetObj.CellText(Row, 3)) > 0) {
		parent.ComBtnEnable_frameLayer0("btn_remark");
	} else {
		parent.ComBtnDisable_frameLayer0("btn_remark");
	}

	if (Col == 3 && sheetObj.CellValue(Row, 4) == "" && sheetObj.CellText(Row, 3) == "" && sheetObj.CellValue(Row, 0) != "") {
		// if(sheetObj.RowCount <= 1){
		document.form.vvd.value = sheetObj.CellValue(Row, 2);

		if (sheetObj.GetComboInfo(Row, Col, "Text") == "") {
			document.form.f_cmd.value = SEARCH02;
			var sXml = sheetObj.GetSearchXml("EES_EQR_1021_01GS.do", FormQueryString(document.form));
			var cols = ComXml2ComboString(sXml, "pod", "etb");

			sheetObj.CellComboItem(Row, "pod", "| |" + cols[0], "| |" + cols[1]);
		}
		// }
	} else {
		// 기존 조회된 데이타는 POD 수정 불가
		if (sheetObj.CellValue(Row, 4) != "") {
			sheetObj.CellEditable(Row, 3) = false;
		}
	}
}

/**
 * sheet3_OnChange 이벤트 발생시
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet3_OnChange(sheetObj, Row, Col, Value) {

	with (sheetObj) {
		var formObj = document.form;
		if (Col == 3) { // POD 컬럼
			var arrcode = Value.split("&&");

			var rCnt01 = RowCount + 1;
			// 자기자신을 제외하고 비교 하기위해 for문을 2번 사용함
			for ( var i = 1; i < Row; i++) {
				if (CellText(i, Col) == arrcode[3] && CellText(i, "vvd") == CellText(Row, "vvd")) { // 동일한
					// POD코드가
					// 존재하면
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					CellValue2(Row, Col + 1) = "";
					return false;
				}
			}
			for ( var i = Row + 1; i < rCnt01; i++) {
				if (CellText(i, Col) == arrcode[3] && CellText(i, "vvd") == CellText(Row, "vvd")) { // 동일한
					// POD코드가
					// 존재하면
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					CellValue2(Row, Col + 1) = "";
					return false;
				}
			}

			CellValue2(Row, 4) = arrcode[0]; // ETB
			//CellValue2(Row, 23) = arrcode[2]; // etbweekdivision
			CellValue2(Row, 24) = arrcode[2]; // etbweekdivision	

		} else {
			if (Col > 4) { // 컨테이너 사이즈 컬럼 부터
				CellFontColor(Row, Col) = RgbColor(0, 0, 255);
				CellFont("FontBold", Row, Col) = true;

				var check = false;
				// vvd master sheet 컨트롤
				for ( var i = 1; i < sheetObjects[10].RowCount + 1; i++) {
					if (sheetObjects[10].CellValue(i, 3) == CellValue(Row, 2)) {
						sheetObjects[10].CellValue2(i, 6) = "I"; // 입력,수정 발생
						// STATUS
						check = true;
						break;
					}
				} 

				// vvd_port_master sheet 컨트롤
				check = false;
				//var vvdRow1 = sheetObjects[11].FindText(0, CellValue(Row, 22));
				var vvdRow1 = sheetObjects[11].FindText(0, CellValue(Row, 23));

				if (vvdRow1 == -1) {
					check = false;
				} else {
					sheetObjects[11].CellValue2(vvdRow1, Col + 7) = Value;

					check = true;
				}

				// 해당 VVD 관련된 POD를 찾아서 입력 상태로 STATUS 변경 로직.
				var vvdRowStart = sheetObjects[11].FindText(4, CellValue(Row, 2));
				var vvdRowEnd = "";
				if (vvdRowStart == -1) {
					vvdRowStart = 1;
				} else {
					if ((sheetObjects[11].RowCount - vvdRowStart) > findVvdMaxCount) { // 같은 VVD가 50개 이하라고 생각하고 만듬. 
						vvdRowEnd = vvdRowStart + findVvdMaxCount;
					} else {
						vvdRowEnd = sheetObjects[11].RowCount + 1;
					}
				}

				for ( var i = vvdRowStart; i < vvdRowEnd; i++) {

					if (sheetObjects[11].CellValue(i, 4) == CellValue(Row, 2)) {
						//sheetObjects[11].CellValue2(i, 29) = "I";
						sheetObjects[11].CellValue2(i, 30) = "I";
					}
				}

				// vvd_port_master --> AddRow
				if (check == false) { // POD가 존재 하지 않으면 새로 생성한다.
					var row = sheetObjects[11].DataInsert();

					sheetObjects[11].CellValue2(row, 0) = keyId;
					sheetObjects[11].CellValue2(row, 3) = CellValue(Row, 0);
					sheetObjects[11].CellValue2(row, 4) = CellValue(Row, 2);
					sheetObjects[11].CellValue2(row, 5) = CellValue(Row, 1);
					//sheetObjects[11].CellValue2(row, 6) = CellValue(Row, 22);
					sheetObjects[11].CellValue2(row, 6) = CellValue(Row, 23);
					sheetObjects[11].CellValue2(row, 7) = CellText(Row, 3);
					sheetObjects[11].CellValue2(row, 9) = CellValue(Row, 4);

					sheetObjects[11].CellValue2(row, 29) = "I";
					//for ( var i = 5; i < 22; i++) {
					for ( var i = 5; i < 23; i++) {		
						sheetObjects[11].CellValue2(row, i + 7) = Value;
						break;
					}

				}
				// 소계 다시 계산
				// HideSubSum();
				ShowSubSum("2", "5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22", true, false, false, -1, "0=;2=Total");

				// 1~5주차 SUMMARY POD SHEET에 값들을 변경 한다.
				//if (CellValue(Row, 23) == '1') { // 기준 Week의 -2주전 Sheet 값 변경
				if (CellValue(Row, 24) == '1') { // 기준 Week의 -2주전 Sheet 값 변경	
					check = false;
					for ( var i = 1; i < sheetObjects[1].RowCount + 1; i++) {
						if (sheetObjects[1].CellValue(i, 1) == CellText(Row, 3)) {
							// 컨테이너 값 입력시 변경
							sheetObjects[1].CellValue2(i, Col - 3) = parseInt(sheetObjects[1].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[1].DataInsert();
						sheetObjects[1].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[1].CellValue2(row, Col - 3) = Value;
					}

				//} else if (CellValue(Row, 23) == '2') { // 기준 Week의 -1주전 Sheet 값
				} else if (CellValue(Row, 24) == '2') { // 기준 Week의 -1주전 Sheet 값		
					// 변경
					check = false;
					for ( var i = 1; i < sheetObjects[3].RowCount + 1; i++) {
						if (sheetObjects[3].CellValue(i, 1) == CellText(Row, 3)) {

							sheetObjects[3].CellValue2(i, Col - 3) = parseInt(sheetObjects[3].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[3].DataInsert();
						sheetObjects[3].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[3].CellValue2(row, Col - 3) = Value;
					}
				//} else if (CellValue(Row, 23) == '3') { // 기준 Week의 Sheet 값 변경
				} else if (CellValue(Row, 24) == '3') { // 기준 Week의 Sheet 값 변경					
					check = false;
					for ( var i = 1; i < sheetObjects[5].RowCount + 1; i++) {
						if (sheetObjects[5].CellValue(i, 1) == CellText(Row, 3)) {

							sheetObjects[5].CellValue2(i, Col - 3) = parseInt(sheetObjects[5].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[5].DataInsert();
						sheetObjects[5].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[5].CellValue2(row, Col - 3) = Value;
					}
				//} else if (CellValue(Row, 23) == '4') { // 기준 Week의 +1주전 Sheet 값
				} else if (CellValue(Row, 24) == '4') { // 기준 Week의 +1주전 Sheet 값					
					// 변경
					check = false;
					for ( var i = 1; i < sheetObjects[7].RowCount + 1; i++) {
						if (sheetObjects[7].CellValue(i, 1) == CellText(Row, 3)) {

							sheetObjects[7].CellValue2(i, Col - 3) = parseInt(sheetObjects[7].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[7].DataInsert();
						sheetObjects[7].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[7].CellValue2(row, Col - 3) = Value;
					}
				//} else if (CellValue(Row, 23) == '5') { // 기준 Week의 +2주전 Sheet 값
				} else if (CellValue(Row, 24) == '5') { // 기준 Week의 +2주전 Sheet 값					
					// 변경
					check = false;
					for ( var i = 1; i < sheetObjects[9].RowCount + 1; i++) {
						if (sheetObjects[9].CellValue(i, 1) == CellText(Row, 3)) {

							sheetObjects[9].CellValue2(i, Col - 3) = parseInt(sheetObjects[9].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[9].DataInsert();
						sheetObjects[9].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[9].CellValue2(row, Col - 3) = Value;
					}
				}
				/*
				 * var sCheck = false; var rowIds = 0; for( var i = 2 ; i <
				 * RowCount + 2 ; i++ ) { if(CellText(i,3) == 'ZZOPT' &&
				 * CellValue(Row,2) == CellValue(i,2)){ //
				 * ComDebug(CellSearchValue(Row,Col)+" "+Value+" "+Row+"
				 * "+CellValue(Row,Col)+" "+EditValue+" "+Col);
				 * 
				 * ComDebug(OrgValue); if(CellValue(i,Col) > 0){ if(Value -
				 * OrgValue > 0){ CellValue2(i,Col) = CellValue(i,Col) -
				 * Math.abs(Value - OrgValue); } } rowIds = i; for ( var j = 5 ;
				 * j < 20 ; j++ ) { if(CellValue(i,j) != 0){ sCheck = true;
				 * break; } }
				 * 
				 * break; } }
				 * 
				 * if(sCheck == false){ RowDelete(rowIds,false); }
				 */

			}
		}

	}
}

/**
 * sheet4_OnClick클릭 이벤트 처리
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet4_OnClick(sheetObj, Row, Col) {
	currentSheet = sheetObj;
	if (ComGetLenByByte(sheetObj.CellValue(Row, 2)) > 0 && ComGetLenByByte(sheetObj.CellText(Row, 3)) > 0) {
		parent.ComBtnEnable_frameLayer0("btn_remark");
	} else {
		parent.ComBtnDisable_frameLayer0("btn_remark");
	}

	if (Col == 3 && sheetObj.CellValue(Row, 4) == "" && sheetObj.CellText(Row, 3) == "" && sheetObj.CellValue(Row, 0) != "") {
		// if(sheetObj.RowCount <= 1){
		document.form.vvd.value = sheetObj.CellValue(Row, 2);
		if (sheetObj.GetComboInfo(Row, Col, "Text") == "") {
			document.form.f_cmd.value = SEARCH02;
			var sXml = sheetObj.GetSearchXml("EES_EQR_1021_01GS.do", FormQueryString(document.form));
			var cols = ComXml2ComboString(sXml, "pod", "etb");

			sheetObj.CellComboItem(Row, "pod", "| |" + cols[0], "| |" + cols[1]);
		}
		// }
	} else {
		// 기존 조회된 데이타는 POD 수정 불가
		if (sheetObj.CellValue(Row, 4) != "") {
			sheetObj.CellEditable(Row, 3) = false;
		}
	}
}

/**
 * sheet4_OnChange 이벤트 발생시
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet4_OnChange(sheetObj, Row, Col, Value) {

	with (sheetObj) {
		var formObj = document.form;
		if (Col == 3) { // POD 컬럼
			var arrcode = Value.split("&&");

			var rCnt01 = RowCount + 1;
			// 자기자신을 제외하고 비교 하기위해 for문을 2번 사용함
			for ( var i = 1; i < Row; i++) {
				if (CellText(i, Col) == arrcode[3] && CellText(i, "vvd") == CellText(Row, "vvd")) { // 동일한
					// POD코드가
					// 존재하면
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					CellValue2(Row, Col + 1) = "";
					return false;
				}
			}
			for ( var i = Row + 1; i < rCnt01; i++) {
				if (CellText(i, Col) == arrcode[3] && CellText(i, "vvd") == CellText(Row, "vvd")) { // 동일한
					// POD코드가
					// 존재하면
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					CellValue2(Row, Col + 1) = "";
					return false;
				}
			}

			CellValue2(Row, 4) = arrcode[0]; // ETB
			//CellValue2(Row, 23) = arrcode[2]; // etbweekdivision
			CellValue2(Row, 24) = arrcode[2]; // etbweekdivision	

		} else {
			if (Col > 4) { // 컨테이너 사이즈 컬럼 부터
				CellFontColor(Row, Col) = RgbColor(0, 0, 255);
				CellFont("FontBold", Row, Col) = true;

				var check = false;
				// vvd master sheet 컨트롤
				for ( var i = 1; i < sheetObjects[10].RowCount + 1; i++) {
					if (sheetObjects[10].CellValue(i, 3) == CellValue(Row, 2)) {
						sheetObjects[10].CellValue2(i, 6) = "I"; // 입력,수정 발생
						// STATUS
						check = true;
						break;
					}
				} 

				// vvd_port_master sheet 컨트롤
				check = false;
				//var vvdRow1 = sheetObjects[11].FindText(0, CellValue(Row, 22));
				var vvdRow1 = sheetObjects[11].FindText(0, CellValue(Row, 23));

				if (vvdRow1 == -1) {
					check = false;
				} else {
					sheetObjects[11].CellValue2(vvdRow1, Col + 7) = Value;

					check = true;
				}

				// 해당 VVD 관련된 POD를 찾아서 입력 상태로 STATUS 변경 로직.
				var vvdRowStart = sheetObjects[11].FindText(4, CellValue(Row, 2));
				var vvdRowEnd = "";
				if (vvdRowStart == -1) {
					vvdRowStart = 1;
				} else {
					if ((sheetObjects[11].RowCount - vvdRowStart) > findVvdMaxCount) { // 같은 VVD가 50개 이하라고 생각하고 만듬. 
						vvdRowEnd = vvdRowStart + findVvdMaxCount;
					} else {
						vvdRowEnd = sheetObjects[11].RowCount + 1;
					}
				}

				for ( var i = vvdRowStart; i < vvdRowEnd; i++) {

					if (sheetObjects[11].CellValue(i, 4) == CellValue(Row, 2)) {
						//sheetObjects[11].CellValue2(i, 29) = "I";
						sheetObjects[11].CellValue2(i, 30) = "I";
					}
				}

				// vvd_port_master --> AddRow
				if (check == false) { // POD가 존재 하지 않으면 새로 생성한다.
					var row = sheetObjects[11].DataInsert();

					sheetObjects[11].CellValue2(row, 0) = keyId;
					sheetObjects[11].CellValue2(row, 3) = CellValue(Row, 0);
					sheetObjects[11].CellValue2(row, 4) = CellValue(Row, 2);
					sheetObjects[11].CellValue2(row, 5) = CellValue(Row, 1);
					//sheetObjects[11].CellValue2(row, 6) = CellValue(Row, 22);
					sheetObjects[11].CellValue2(row, 6) = CellValue(Row, 23);
					sheetObjects[11].CellValue2(row, 7) = CellText(Row, 3);
					sheetObjects[11].CellValue2(row, 9) = CellValue(Row, 4);

					//sheetObjects[11].CellValue2(row, 29) = "I";
					sheetObjects[11].CellValue2(row, 30) = "I";
					for ( var i = 5; i < 22; i++) {
						sheetObjects[11].CellValue2(row, i + 7) = Value;
						break;
					}

				}
				// 소계 다시 계산
				// HideSubSum();
				ShowSubSum("2", "5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22", true, false, false, -1, "0=;2=Total");

				// 1~5주차 SUMMARY POD SHEET에 값들을 변경 한다.
				//if (CellValue(Row, 23) == '1') { // 기준 Week의 -2주전 Sheet 값 변경
				if (CellValue(Row, 24) == '1') { // 기준 Week의 -2주전 Sheet 값 변경	
					check = false;
					for ( var i = 1; i < sheetObjects[1].RowCount + 1; i++) {
						if (sheetObjects[1].CellValue(i, 1) == CellText(Row, 3)) {
							// 컨테이너 값 입력시 변경
							sheetObjects[1].CellValue2(i, Col - 3) = parseInt(sheetObjects[1].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[1].DataInsert();
						sheetObjects[1].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[1].CellValue2(row, Col - 3) = Value;
					}

				//} else if (CellValue(Row, 23) == '2') { // 기준 Week의 -1주전 Sheet 값
				} else if (CellValue(Row, 24) == '2') { // 기준 Week의 -1주전 Sheet 값					
					// 변경
					check = false;
					for ( var i = 1; i < sheetObjects[3].RowCount + 1; i++) {
						if (sheetObjects[3].CellValue(i, 1) == CellText(Row, 3)) {

							sheetObjects[3].CellValue2(i, Col - 3) = parseInt(sheetObjects[3].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[3].DataInsert();
						sheetObjects[3].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[3].CellValue2(row, Col - 3) = Value;
					}
				//} else if (CellValue(Row, 23) == '3') { // 기준 Week의 Sheet 값 변경
				} else if (CellValue(Row, 24) == '3') { // 기준 Week의 Sheet 값 변경					
					check = false;
					for ( var i = 1; i < sheetObjects[5].RowCount + 1; i++) {
						if (sheetObjects[5].CellValue(i, 1) == CellText(Row, 3)) {

							sheetObjects[5].CellValue2(i, Col - 3) = parseInt(sheetObjects[5].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[5].DataInsert();
						sheetObjects[5].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[5].CellValue2(row, Col - 3) = Value;
					}
				//} else if (CellValue(Row, 23) == '4') { // 기준 Week의 +1주전 Sheet 값
				} else if (CellValue(Row, 24) == '4') { // 기준 Week의 +1주전 Sheet 값					
					// 변경
					check = false;
					for ( var i = 1; i < sheetObjects[7].RowCount + 1; i++) {
						if (sheetObjects[7].CellValue(i, 1) == CellText(Row, 3)) {

							sheetObjects[7].CellValue2(i, Col - 3) = parseInt(sheetObjects[7].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[7].DataInsert();
						sheetObjects[7].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[7].CellValue2(row, Col - 3) = Value;
					}
				//} else if (CellValue(Row, 23) == '5') { // 기준 Week의 +2주전 Sheet 값
				} else if (CellValue(Row, 24) == '5') { // 기준 Week의 +2주전 Sheet 값					
					// 변경
					check = false;
					for ( var i = 1; i < sheetObjects[9].RowCount + 1; i++) {
						if (sheetObjects[9].CellValue(i, 1) == CellText(Row, 3)) {

							sheetObjects[9].CellValue2(i, Col - 3) = parseInt(sheetObjects[9].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[9].DataInsert();
						sheetObjects[9].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[9].CellValue2(row, Col - 3) = Value;
					}
				}
				/*
				 * var sCheck = false; var rowIds = 0; for( var i = 2 ; i <
				 * RowCount + 2 ; i++ ) { if(CellText(i,3) == 'ZZOPT' &&
				 * CellValue(Row,2) == CellValue(i,2)){ //
				 * ComDebug(CellSearchValue(Row,Col)+" "+Value+" "+Row+"
				 * "+CellValue(Row,Col)+" "+EditValue+" "+Col);
				 * 
				 * ComDebug(OrgValue); if(CellValue(i,Col) > 0){ if(Value -
				 * OrgValue > 0){ CellValue2(i,Col) = CellValue(i,Col) -
				 * Math.abs(Value - OrgValue); } } rowIds = i; for ( var j = 5 ;
				 * j < 20 ; j++ ) { if(CellValue(i,j) != 0){ sCheck = true;
				 * break; } }
				 * 
				 * break; } }
				 * 
				 * if(sCheck == false){ RowDelete(rowIds,false); }
				 */

			}
		}

	}
}

/**
 * sheet5_OnClick클릭 이벤트 처리
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet5_OnClick(sheetObj, Row, Col) {
	currentSheet = sheetObj;
	if (ComGetLenByByte(sheetObj.CellValue(Row, 2)) > 0 && ComGetLenByByte(sheetObj.CellText(Row, 3)) > 0) {
		parent.ComBtnEnable_frameLayer0("btn_remark");
	} else {
		parent.ComBtnDisable_frameLayer0("btn_remark");
	}

	if (Col == 3 && sheetObj.CellValue(Row, 4) == "" && sheetObj.CellText(Row, 3) == "" && sheetObj.CellValue(Row, 0) != "") {
		document.form.vvd.value = sheetObj.CellValue(Row, 2);
		if (sheetObj.GetComboInfo(Row, Col, "Text") == "") {
			document.form.f_cmd.value = SEARCH02;
			var sXml = sheetObj.GetSearchXml("EES_EQR_1021_01GS.do", FormQueryString(document.form));
			var cols = ComXml2ComboString(sXml, "pod", "etb");

			sheetObj.CellComboItem(Row, "pod", "| |" + cols[0], "| |" + cols[1]);
		}
	} else {
		// 기존 조회된 데이타는 POD 수정 불가
		if (sheetObj.CellValue(Row, 4) != "") {
			sheetObj.CellEditable(Row, 3) = false;
		}
	}
}

/**
 * sheet5_OnChange 이벤트 발생시
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet5_OnChange(sheetObj, Row, Col, Value) {

	with (sheetObj) {
		var formObj = document.form;
		if (Col == 3) { // POD 컬럼
			var arrcode = Value.split("&&");

			var rCnt01 = RowCount + 1;
			// 자기자신을 제외하고 비교 하기위해 for문을 2번 사용함
			for ( var i = 1; i < Row; i++) {
				if (CellText(i, Col) == arrcode[3] && CellText(i, "vvd") == CellText(Row, "vvd")) { // 동일한
					// POD코드가
					// 존재하면
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					CellValue2(Row, Col + 1) = "";
					return false;
				}
			}
			for ( var i = Row + 1; i < rCnt01; i++) {
				if (CellText(i, Col) == arrcode[3] && CellText(i, "vvd") == CellText(Row, "vvd")) { // 동일한
					// POD코드가
					// 존재하면
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					CellValue2(Row, Col + 1) = "";
					return false;
				}
			}

			CellValue2(Row, 4) = arrcode[0]; // ETB
			//CellValue2(Row, 23) = arrcode[2]; // etbweekdivision
			CellValue2(Row, 24) = arrcode[2]; // etbweekdivision			

		} else {
			if (Col > 4) { // 컨테이너 사이즈 컬럼 부터
				CellFontColor(Row, Col) = RgbColor(0, 0, 255);
				CellFont("FontBold", Row, Col) = true;

				var check = false;
				// vvd master sheet 컨트롤
				for ( var i = 1; i < sheetObjects[10].RowCount + 1; i++) {
					if (sheetObjects[10].CellValue(i, 3) == CellValue(Row, 2)) {
						sheetObjects[10].CellValue2(i, 6) = "I"; // 입력,수정 발생
						// STATUS
						check = true;
						break;
					}
				} 

				// vvd_port_master sheet 컨트롤
				check = false;
				//var vvdRow1 = sheetObjects[11].FindText(0, CellValue(Row, 22));
				var vvdRow1 = sheetObjects[11].FindText(0, CellValue(Row, 23));	

				if (vvdRow1 == -1) {
					check = false;
				} else {
					sheetObjects[11].CellValue2(vvdRow1, Col + 7) = Value;

					check = true;
				}

				// 해당 VVD 관련된 POD를 찾아서 입력 상태로 STATUS 변경 로직.
				var vvdRowStart = sheetObjects[11].FindText(4, CellValue(Row, 2));
				var vvdRowEnd = "";
				if (vvdRowStart == -1) {
					vvdRowStart = 1;
				} else {
					if ((sheetObjects[11].RowCount - vvdRowStart) > findVvdMaxCount) { // 같은 VVD가 50개 이하라고 생각하고 만듬. 
						vvdRowEnd = vvdRowStart + findVvdMaxCount;
					} else {
						vvdRowEnd = sheetObjects[11].RowCount + 1;
					}
				}

				for ( var i = vvdRowStart; i < vvdRowEnd; i++) {

					if (sheetObjects[11].CellValue(i, 4) == CellValue(Row, 2)) {
						//sheetObjects[11].CellValue2(i, 29) = "I";
						sheetObjects[11].CellValue2(i, 30) = "I";	
					}
				}

				// vvd_port_master --> AddRow
				if (check == false) { // POD가 존재 하지 않으면 새로 생성한다.
					var row = sheetObjects[11].DataInsert();

					sheetObjects[11].CellValue2(row, 0) = keyId;
					sheetObjects[11].CellValue2(row, 3) = CellValue(Row, 0);
					sheetObjects[11].CellValue2(row, 4) = CellValue(Row, 2);
					sheetObjects[11].CellValue2(row, 5) = CellValue(Row, 1);
					//sheetObjects[11].CellValue2(row, 6) = CellValue(Row, 22);
					sheetObjects[11].CellValue2(row, 6) = CellValue(Row, 23);
					sheetObjects[11].CellValue2(row, 7) = CellText(Row, 3);
					sheetObjects[11].CellValue2(row, 9) = CellValue(Row, 4);

					//sheetObjects[11].CellValue2(row, 29) = "I";
					sheetObjects[11].CellValue2(row, 30) = "I";
					for ( var i = 5; i < 22; i++) {
						sheetObjects[11].CellValue2(row, i + 7) = Value;
						break;
					}

				}
				// 소계 다시 계산
				// HideSubSum();
				ShowSubSum("2", "5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22", true, false, false, -1, "0=;2=Total");

				// 1~5주차 SUMMARY POD SHEET에 값들을 변경 한다.
				//if (CellValue(Row, 23) == '1') { // 기준 Week의 -2주전 Sheet 값 변경
				if (CellValue(Row, 24) == '1') { // 기준 Week의 -2주전 Sheet 값 변경					
					check = false;
					for ( var i = 1; i < sheetObjects[1].RowCount + 1; i++) {
						if (sheetObjects[1].CellValue(i, 1) == CellText(Row, 3)) {
							// 컨테이너 값 입력시 변경
							sheetObjects[1].CellValue2(i, Col - 3) = parseInt(sheetObjects[1].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[1].DataInsert();
						sheetObjects[1].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[1].CellValue2(row, Col - 3) = Value;
					}

				//} else if (CellValue(Row, 23) == '2') { // 기준 Week의 -1주전 Sheet 값
				} else if (CellValue(Row, 24) == '2') { // 기준 Week의 -1주전 Sheet 값					
					// 변경
					check = false;
					for ( var i = 1; i < sheetObjects[3].RowCount + 1; i++) {
						if (sheetObjects[3].CellValue(i, 1) == CellText(Row, 3)) {

							sheetObjects[3].CellValue2(i, Col - 3) = parseInt(sheetObjects[3].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[3].DataInsert();
						sheetObjects[3].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[3].CellValue2(row, Col - 3) = Value;
					}
				//} else if (CellValue(Row, 23) == '3') { // 기준 Week의 Sheet 값 변경
				} else if (CellValue(Row, 24) == '3') { // 기준 Week의 Sheet 값 변경					
					check = false;
					for ( var i = 1; i < sheetObjects[5].RowCount + 1; i++) {
						if (sheetObjects[5].CellValue(i, 1) == CellText(Row, 3)) {

							sheetObjects[5].CellValue2(i, Col - 3) = parseInt(sheetObjects[5].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[5].DataInsert();
						sheetObjects[5].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[5].CellValue2(row, Col - 3) = Value;
					}
				//} else if (CellValue(Row, 23) == '4') { // 기준 Week의 +1주전 Sheet 값
				} else if (CellValue(Row, 24) == '4') { // 기준 Week의 +1주전 Sheet 값					
					// 변경
					check = false;
					for ( var i = 1; i < sheetObjects[7].RowCount + 1; i++) {
						if (sheetObjects[7].CellValue(i, 1) == CellText(Row, 3)) {

							sheetObjects[7].CellValue2(i, Col - 3) = parseInt(sheetObjects[7].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[7].DataInsert();
						sheetObjects[7].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[7].CellValue2(row, Col - 3) = Value;
					}
				//} else if (CellValue(Row, 23) == '5') { // 기준 Week의 +2주전 Sheet 값
				} else if (CellValue(Row, 24) == '5') { // 기준 Week의 +2주전 Sheet 값					
					// 변경
					check = false;
					for ( var i = 1; i < sheetObjects[9].RowCount + 1; i++) {
						if (sheetObjects[9].CellValue(i, 1) == CellText(Row, 3)) {

							sheetObjects[9].CellValue2(i, Col - 3) = parseInt(sheetObjects[9].CellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value));
							check = true;
						}
					}

					if (check == false) { // 기존에 POD가 없으면 생성후 값 세팅
						var row = sheetObjects[9].DataInsert();
						sheetObjects[9].CellValue2(row, 1) = sheetObj.CellText(sheetObj.SelectRow, 3);
						sheetObjects[9].CellValue2(row, Col - 3) = Value;
					}
				}
				/*
				 * var sCheck = false; var rowIds = 0; for( var i = 2 ; i <
				 * RowCount + 2 ; i++ ) { if(CellText(i,3) == 'ZZOPT' &&
				 * CellValue(Row,2) == CellValue(i,2)){ //
				 * ComDebug(CellSearchValue(Row,Col)+" "+Value+" "+Row+"
				 * "+CellValue(Row,Col)+" "+EditValue+" "+Col);
				 * 
				 * ComDebug(OrgValue); if(CellValue(i,Col) > 0){ if(Value -
				 * OrgValue > 0){ CellValue2(i,Col) = CellValue(i,Col) -
				 * Math.abs(Value - OrgValue); } } rowIds = i; for ( var j = 5 ;
				 * j < 20 ; j++ ) { if(CellValue(i,j) != 0){ sCheck = true;
				 * break; } }
				 * 
				 * break; } }
				 * 
				 * if(sCheck == false){ RowDelete(rowIds,false); }
				 */

			}
		}

	}
}

/**
 * sheet1_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		// 기존 조회된 데이타는 POD 수정 불가
		for ( var i = 1; i < RowCount + 1; i++) {
			if (CellValue(i, 4) != "" || CellText(i, 3) != '') { 	// POD && ETB 값이 NULL이 아니면
				CellEditable(i, 3) = false; 						// EDIT 금지
			}
			//if (CellValue(i, 23) == "Y") { // REMARK 가 등록되어 있으면
			if (CellValue(i, 24) == "Y") { // REMARK 가 등록되어 있으면				
				// CellFontColor(i,0) = RgbColor(0, 0, 255);
				CellFont("FontBold", i, 0) = true;			// 글자 굵게..
				CellFont("FontUnderline", i, 0) = true;		// 밑줄짝...
			}

		}
		ColumnSort("firstetb"); 
		ShowSubSum("2", "5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22", true, false, false, -1, "0=;2=Total");

		if (sheetObj.RowCount > 1) {
		//	ComBtnEnable("btn_s1add");
		//	ComBtnEnable("btn_s1del");
			ComBtnEnable("btn_s1retrieve");
		}
		if (sheetObjects[11].RowCount > 1) {
			parent.ComBtnEnable_frameLayer0("btn_mainretrieve"); // PARENT RemarkVVD  버튼 활성화.
		}

	}
}

/**
 * sheet2_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		// 기존 조회된 데이타는 POD 수정 불가
		for ( var i = 1; i < RowCount + 1; i++) {
			if (CellValue(i, 4) != "" || CellText(i, 3) != '') {
				CellEditable(i, 3) = false;
			}
			//if (CellValue(i, 23) == "Y") {
			if (CellValue(i, 24) == "Y") {
				// CellFontColor(i,0) = RgbColor(0, 0, 255);
				CellFont("FontBold", i, 0) = true;
				CellFont("FontUnderline", i, 0) = true;
			}
		}
		ColumnSort("firstetb");
		ShowSubSum("2", "5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22", true, false, false, -1, "0=;2=Total");

		if (sheetObj.RowCount > 1) {
		//	ComBtnEnable("btn_s2add");
		//	ComBtnEnable("btn_s2del");
			ComBtnEnable("btn_s2retrieve");
		}

	}
}

/**
 * sheet3_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {

		// 기존 조회된 데이타는 POD 수정 불가
		for ( var i = 1; i < RowCount + 1; i++) {
			if (CellValue(i, 4) != "" || CellText(i, 3) != '') {
				CellEditable(i, 3) = false;
			}
			//if (CellValue(i, 23) == "Y") {
			if (CellValue(i, 24) == "Y") {
				// CellFontColor(i,0) = RgbColor(0, 0, 255);
				CellFont("FontBold", i, 0) = true;
				CellFont("FontUnderline", i, 0) = true;
			}
		}
		ColumnSort("firstetb");
		ShowSubSum("2", "5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22", true, false, false, -1, "0=;2=Total");

		if (sheetObj.RowCount > 1) {
		//	ComBtnEnable("btn_s3add");
		//	ComBtnEnable("btn_s3del");
			ComBtnEnable("btn_s3retrieve");
		}

	}
}

/**
 * sheet4_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {

		// 기존 조회된 데이타는 POD 수정 불가
		for ( var i = 1; i < RowCount + 1; i++) {
			if (CellValue(i, 4) != "" || CellText(i, 3) != '') {
				CellEditable(i, 3) = false;
			}
			//if (CellValue(i, 23) == "Y") {
			if (CellValue(i, 24) == "Y") {	
				// CellFontColor(i,0) = RgbColor(0, 0, 255);
				CellFont("FontBold", i, 0) = true;
				CellFont("FontUnderline", i, 0) = true;
			}
		}

		ColumnSort("firstetb");
		ShowSubSum("2", "5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22", true, false, false, -1, "0=;2=Total");

		if (sheetObj.RowCount > 1) {
		//	ComBtnEnable("btn_s4add");
		//	ComBtnEnable("btn_s4del");
			ComBtnEnable("btn_s4retrieve");
		}

	}
}

/**
 * sheet5_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet5_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {

		// 기존 조회된 데이타는 POD 수정 불가
		for ( var i = 1; i < RowCount + 1; i++) {
			if (CellValue(i, 4) != "" || CellText(i, 3) != '') {
				CellEditable(i, 3) = false;
			}
			//if (CellValue(i, 23) == "Y") {
			if (CellValue(i, 24) == "Y") {				
				CellFont("FontBold", i, 0) = true;
				CellFont("FontUnderline", i, 0) = true;
			}
		}
		ColumnSort("firstetb");
		ShowSubSum("2", "5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22", true, false, false, -1, "0=;2=Total");

		if (sheetObj.RowCount > 1) {
		//	ComBtnEnable("btn_s5add");
		//	ComBtnEnable("btn_s5del");
			ComBtnEnable("btn_s5retrieve");
		}
	}
}

/**
 * sheet6_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet6_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColumnSort("pod");
	}
}

/**
 * sheet7_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet7_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColumnSort("pod");
	}
}

/**
 * sheet8_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet8_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColumnSort("pod");
	}
}

/**
 * sheet9_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet9_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColumnSort("pod");
	}
}

/**
 * sheet10_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet10_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColumnSort("pod");
	}
}

/**
 * IBSeet내의 데이터 영역의 셀을 더블클릭했을 때 발생하는 Event<br>
 * 
 * @param {sheetObj}
 *            String : 해당 IBSheet셀 명
 * @param {Row}
 *            Long : 해당 셀의 Row Index
 * @param {Col}
 *            Long : 해당 셀의 Column Index
 * @param {Value}
 *            String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 * @param {CellX}
 *            Long : 해당셀의 X좌표
 * @param {CellY}
 *            Long : 해당셀의 Y좌표
 * @param {CellW}
 *            Long : 해당셀의 가로 넓이값
 * @param {CellH}
 *            Long : 해당셀의 세로 높이값
 */
function sheet1_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// 더블클릭한 row의 "pod"컬럼 값이 있으면
		if (ComGetLenByByte(Cellvalue(Row, "etb")) > 0) {
			if (SelectCol <= 2) {
				var Row = sheetObjects[10].FindText("vvd", currentSheet.CellValue(currentSheet.SelectRow, "vvd"));

				ComOpenWindowCenter("/hanjin/EES_EQR_1054.do" + "?week=" + sheetObjects[10].CellValue(Row, "week") + "&lane="
						+ sheetObjects[10].CellValue(Row, "lane") + "&vvd=" + sheetObjects[10].CellValue(Row, "vvd") + "&row=" + Row + "&weekdivision="
						+ sheetObjects[10].CellValue(Row, "weekdivision") + "&remark=" + sheetObjects[10].CellValue(Row, "remark"), "EES_EQR_1054", 700, 420);
			}
		}
		
		// VVD 에 해당하는 POD를 클릭시에 SUMMARY POD SHEET의 같은 POD를 찾아가는 로직.(이하 sheet2~sheet5 까지 같은 로직)
		if (SelectCol == 3) {

			var weekDivision = CellValue(Row, "weekdivision");
			if (weekDivision == 1) {
				weekDivision = parseInt(weekDivision);
				this.scroll(0, 0);
			} else if (weekDivision == 2) {
				weekDivision = parseInt(weekDivision) + 1;
				this.scroll(0, 0);
			} else if (weekDivision == 3) {
				weekDivision = parseInt(weekDivision) + 2;
				this.scroll(324, 0);
			} else if (weekDivision == 4) {
				weekDivision = parseInt(weekDivision) + 3;
				this.scroll(900, 0);
			} else if (weekDivision == 5) {
				weekDivision = parseInt(weekDivision) + 4;
				this.scroll(900, 0);
			}
			else{
				SelectCell(Row, 3, false);
			}
			if(weekDivision != ""){
				hideCursorBar();
				var FindRow = sheetObjects[weekDivision].FindText(1, CellText(Row, 3));
				sheetObjects[weekDivision].focus();
				sheetObjects[weekDivision].SelectCell(FindRow, 1, false);
			}
		}
		//--------------------------------------------------------------------------------
	}
}

/**
 * IBSeet내의 데이터 영역의 셀을 더블클릭했을 때 발생하는 Event<br>
 * 
 * @param {sheetObj}
 *            String : 해당 IBSheet셀 명
 * @param {Row}
 *            Long : 해당 셀의 Row Index
 * @param {Col}
 *            Long : 해당 셀의 Column Index
 * @param {Value}
 *            String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 * @param {CellX}
 *            Long : 해당셀의 X좌표
 * @param {CellY}
 *            Long : 해당셀의 Y좌표
 * @param {CellW}
 *            Long : 해당셀의 가로 넓이값
 * @param {CellH}
 *            Long : 해당셀의 세로 높이값
 */
function sheet2_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// 더블클릭한 row의 "pod"컬럼 값이 있으면
		if (ComGetLenByByte(Cellvalue(Row, "etb")) > 0) {
			if (SelectCol <= 2) {
				var Row = sheetObjects[10].FindText("vvd", currentSheet.CellValue(currentSheet.SelectRow, "vvd"));

				ComOpenWindowCenter("/hanjin/EES_EQR_1054.do" + "?week=" + sheetObjects[10].CellValue(Row, "week") + "&lane="
						+ sheetObjects[10].CellValue(Row, "lane") + "&vvd=" + sheetObjects[10].CellValue(Row, "vvd") + "&row=" + Row + "&weekdivision="
						+ sheetObjects[10].CellValue(Row, "weekdivision") + "&remark=" + sheetObjects[10].CellValue(Row, "remark"), "EES_EQR_1054", 700, 420);
			}
		}
		
		if (SelectCol == 3) {

			var weekDivision = CellValue(Row,  "weekdivision");
			if (weekDivision == 1) {
				weekDivision = parseInt(weekDivision);
				this.scroll(0, 0);
			} else if (weekDivision == 2) {
				weekDivision = parseInt(weekDivision) + 1;
				this.scroll(0, 0);
			} else if (weekDivision == 3) {
				weekDivision = parseInt(weekDivision) + 2;
				this.scroll(324, 0);
			} else if (weekDivision == 4) {
				weekDivision = parseInt(weekDivision) + 3;
				this.scroll(900, 0);
			} else if (weekDivision == 5) {
				weekDivision = parseInt(weekDivision) + 4;
				this.scroll(900, 0);
			}
			else{
				SelectCell(Row, 3, false);
			}
			if(weekDivision != ""){
				hideCursorBar();
				var FindRow = sheetObjects[weekDivision].FindText(1, CellText(Row, 3));
				sheetObjects[weekDivision].focus();
				sheetObjects[weekDivision].SelectCell(FindRow, 1, false);
			}
		}		
	}
}

/**
 * IBSeet내의 데이터 영역의 셀을 더블클릭했을 때 발생하는 Event<br>
 * 
 * @param {sheetObj}
 *            String : 해당 IBSheet셀 명
 * @param {Row}
 *            Long : 해당 셀의 Row Index
 * @param {Col}
 *            Long : 해당 셀의 Column Index
 * @param {Value}
 *            String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 * @param {CellX}
 *            Long : 해당셀의 X좌표
 * @param {CellY}
 *            Long : 해당셀의 Y좌표
 * @param {CellW}
 *            Long : 해당셀의 가로 넓이값
 * @param {CellH}
 *            Long : 해당셀의 세로 높이값
 */
function sheet3_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// 더블클릭한 row의 "pod"컬럼 값이 있으면
		if (ComGetLenByByte(Cellvalue(Row, "etb")) > 0) {
			if (SelectCol <= 2) {
				var Row = sheetObjects[10].FindText("vvd", currentSheet.CellValue(currentSheet.SelectRow, "vvd"));

				ComOpenWindowCenter("/hanjin/EES_EQR_1054.do" + "?week=" + sheetObjects[10].CellValue(Row, "week") + "&lane="
						+ sheetObjects[10].CellValue(Row, "lane") + "&vvd=" + sheetObjects[10].CellValue(Row, "vvd") + "&row=" + Row + "&weekdivision="
						+ sheetObjects[10].CellValue(Row, "weekdivision") + "&remark=" + sheetObjects[10].CellValue(Row, "remark"), "EES_EQR_1054", 700, 420);
			}
		}
		
		if (SelectCol == 3) {

			var weekDivision = CellValue(Row,  "weekdivision");
			if (weekDivision == 1) {
				weekDivision = parseInt(weekDivision);
				this.scroll(0, 0);
			} else if (weekDivision == 2) {
				weekDivision = parseInt(weekDivision) + 1;
				this.scroll(0, 0);
			} else if (weekDivision == 3) {
				weekDivision = parseInt(weekDivision) + 2;
				this.scroll(324, 0);
			} else if (weekDivision == 4) {
				weekDivision = parseInt(weekDivision) + 3;
				this.scroll(900, 0);
			} else if (weekDivision == 5) {
				weekDivision = parseInt(weekDivision) + 4;
				this.scroll(900, 0);
			}
			else{
				SelectCell(Row, 3, false);
			}
			if(weekDivision != ""){
				hideCursorBar();
				var FindRow = sheetObjects[weekDivision].FindText(1, CellText(Row, 3));
				sheetObjects[weekDivision].focus();
				sheetObjects[weekDivision].SelectCell(FindRow, 1, false);
			}
		}		
	}
}

/**
 * IBSeet내의 데이터 영역의 셀을 더블클릭했을 때 발생하는 Event<br>
 * 
 * @param {sheetObj}
 *            String : 해당 IBSheet셀 명
 * @param {Row}
 *            Long : 해당 셀의 Row Index
 * @param {Col}
 *            Long : 해당 셀의 Column Index
 * @param {Value}
 *            String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 * @param {CellX}
 *            Long : 해당셀의 X좌표
 * @param {CellY}
 *            Long : 해당셀의 Y좌표
 * @param {CellW}
 *            Long : 해당셀의 가로 넓이값
 * @param {CellH}
 *            Long : 해당셀의 세로 높이값
 */
function sheet4_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// 더블클릭한 row의 "pod"컬럼 값이 있으면
		if (ComGetLenByByte(Cellvalue(Row, "etb")) > 0) {
			if (SelectCol <= 2) {
				var Row = sheetObjects[10].FindText("vvd", currentSheet.CellValue(currentSheet.SelectRow, "vvd"));

				ComOpenWindowCenter("/hanjin/EES_EQR_1054.do" + "?week=" + sheetObjects[10].CellValue(Row, "week") + "&lane="
						+ sheetObjects[10].CellValue(Row, "lane") + "&vvd=" + sheetObjects[10].CellValue(Row, "vvd") + "&row=" + Row + "&weekdivision="
						+ sheetObjects[10].CellValue(Row, "weekdivision") + "&remark=" + sheetObjects[10].CellValue(Row, "remark"), "EES_EQR_1054", 700, 420);
			}
		}
		
		if (SelectCol == 3) {

			var weekDivision = CellValue(Row,  "weekdivision");
			if (weekDivision == 1) {
				weekDivision = parseInt(weekDivision);
				this.scroll(0, 0);
			} else if (weekDivision == 2) {
				weekDivision = parseInt(weekDivision) + 1;
				this.scroll(0, 0);
			} else if (weekDivision == 3) {
				weekDivision = parseInt(weekDivision) + 2;
				this.scroll(324, 0);
			} else if (weekDivision == 4) {
				weekDivision = parseInt(weekDivision) + 3;
				this.scroll(900, 0);
			} else if (weekDivision == 5) {
				weekDivision = parseInt(weekDivision) + 4;
				this.scroll(900, 0);
			}
			else{
				SelectCell(Row, 3, false);
			}
			if(weekDivision != ""){
				hideCursorBar();
				var FindRow = sheetObjects[weekDivision].FindText(1, CellText(Row, 3));
				sheetObjects[weekDivision].focus();
				sheetObjects[weekDivision].SelectCell(FindRow, 1, false);
			}
		}		
	}
}

/**
 * IBSeet내의 데이터 영역의 셀을 더블클릭했을 때 발생하는 Event<br>
 * 
 * @param {sheetObj}
 *            String : 해당 IBSheet셀 명
 * @param {Row}
 *            Long : 해당 셀의 Row Index
 * @param {Col}
 *            Long : 해당 셀의 Column Index
 * @param {Value}
 *            String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 * @param {CellX}
 *            Long : 해당셀의 X좌표
 * @param {CellY}
 *            Long : 해당셀의 Y좌표
 * @param {CellW}
 *            Long : 해당셀의 가로 넓이값
 * @param {CellH}
 *            Long : 해당셀의 세로 높이값
 */
function sheet5_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// 더블클릭한 row의 "pod"컬럼 값이 있으면
		if (ComGetLenByByte(Cellvalue(Row, "etb")) > 0) {
			if (SelectCol <= 2) {
				var Row = sheetObjects[10].FindText("vvd", currentSheet.CellValue(currentSheet.SelectRow, "vvd"));

				ComOpenWindowCenter("/hanjin/EES_EQR_1054.do" + "?week=" + sheetObjects[10].CellValue(Row, "week") + "&lane="
						+ sheetObjects[10].CellValue(Row, "lane") + "&vvd=" + sheetObjects[10].CellValue(Row, "vvd") + "&row=" + Row + "&weekdivision="
						+ sheetObjects[10].CellValue(Row, "weekdivision") + "&remark=" + sheetObjects[10].CellValue(Row, "remark"), "EES_EQR_1054", 700, 420);
			}
		}
		
		if (SelectCol == 3) {

			var weekDivision = CellValue(Row, "weekdivision");
			if (weekDivision == 1) {
				weekDivision = parseInt(weekDivision);
				this.scroll(0, 0);
			} else if (weekDivision == 2) {
				weekDivision = parseInt(weekDivision) + 1;
				this.scroll(0, 0);
			} else if (weekDivision == 3) {
				weekDivision = parseInt(weekDivision) + 2;
				this.scroll(324, 0);
			} else if (weekDivision == 4) {
				weekDivision = parseInt(weekDivision) + 3;
				this.scroll(900, 0);
			} else if (weekDivision == 5) {
				weekDivision = parseInt(weekDivision) + 4;
				this.scroll(900, 0);
			}
			else{
				SelectCell(Row, 3, false);
			}
			if(weekDivision != ""){
				hideCursorBar();
				var FindRow = sheetObjects[weekDivision].FindText(1, CellText(Row, 3));
				sheetObjects[weekDivision].focus();
				sheetObjects[weekDivision].SelectCell(FindRow, 1, false);
			}
		}		
	}
}

/**
 * IBSeet내의 데이터 영역의 셀을 더블클릭했을 때 발생하는 Event<br>
 * 
 * @param {sheetObj}
 *            String : 해당 IBSheet셀 명
 * @param {Row}
 *            Long : 해당 셀의 Row Index
 * @param {Col}
 *            Long : 해당 셀의 Column Index
 * @param {Value}
 *            String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 * @param {CellX}
 *            Long : 해당셀의 X좌표
 * @param {CellY}
 *            Long : 해당셀의 Y좌표
 * @param {CellW}
 *            Long : 해당셀의 가로 넓이값
 * @param {CellH}
 *            Long : 해당셀의 세로 높이값
 */
function sheet6_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// 더블클릭한 row의 "pod"컬럼 값이 있으면
		if (ComGetLenByByte(Cellvalue(Row, "pod")) > 0) {
			// if(SelectCol == 1){
			for ( var i = 1; i < sheetObjects[11].RowCount + 1; i++) {
				if (sheetObjects[11].CellValue(i, 7) == CellValue(Row, 1) && sheetObjects[11].CellValue(i, 11) != "" && sheetObjects[11].CellValue(i, 11) == 1) {
					//sheetObjects[11].CellValue2(i, 31) = "1";
					sheetObjects[11].CellValue2(i, 32) = "1";
				}
			}
			ComOpenWindowCenter("/hanjin/EES_EQR_1055.do", "EES_EQR_1055"+popupCnt, 880, 670);
			popupCnt++;
			// }
		}
	}
}

/**
 * IBSeet내의 데이터 영역의 셀을 더블클릭했을 때 발생하는 Event<br>
 * 
 * @param {sheetObj}
 *            String : 해당 IBSheet셀 명
 * @param {Row}
 *            Long : 해당 셀의 Row Index
 * @param {Col}
 *            Long : 해당 셀의 Column Index
 * @param {Value}
 *            String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 * @param {CellX}
 *            Long : 해당셀의 X좌표
 * @param {CellY}
 *            Long : 해당셀의 Y좌표
 * @param {CellW}
 *            Long : 해당셀의 가로 넓이값
 * @param {CellH}
 *            Long : 해당셀의 세로 높이값
 */
function sheet7_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// 더블클릭한 row의 "pod"컬럼 값이 있으면
		if (ComGetLenByByte(Cellvalue(Row, "pod")) > 0) {
			// if(SelectCol == 1){
			for ( var i = 1; i < sheetObjects[11].RowCount + 1; i++) {
				if (sheetObjects[11].CellValue(i, 7) == CellValue(Row, 1) && sheetObjects[11].CellValue(i, 11) != "" && sheetObjects[11].CellValue(i, 11) == 2) {
					//sheetObjects[11].CellValue2(i, 31) = "1";
					sheetObjects[11].CellValue2(i, 32) = "1";
				}
			}

			ComOpenWindowCenter("/hanjin/EES_EQR_1055.do", "EES_EQR_1055"+popupCnt, 880, 670);
			popupCnt++;
			// }
		}
	}
}

/**
 * IBSeet내의 데이터 영역의 셀을 더블클릭했을 때 발생하는 Event<br>
 * 
 * @param {sheetObj}
 *            String : 해당 IBSheet셀 명
 * @param {Row}
 *            Long : 해당 셀의 Row Index
 * @param {Col}
 *            Long : 해당 셀의 Column Index
 * @param {Value}
 *            String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 * @param {CellX}
 *            Long : 해당셀의 X좌표
 * @param {CellY}
 *            Long : 해당셀의 Y좌표
 * @param {CellW}
 *            Long : 해당셀의 가로 넓이값
 * @param {CellH}
 *            Long : 해당셀의 세로 높이값
 */
function sheet8_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// 더블클릭한 row의 "pod"컬럼 값이 있으면
		if (ComGetLenByByte(Cellvalue(Row, "pod")) > 0) {
			// if(SelectCol == 1){
			for ( var i = 1; i < sheetObjects[11].RowCount + 1; i++) {
				if (sheetObjects[11].CellValue(i, 7) == CellValue(Row, 1) && sheetObjects[11].CellValue(i, 11) != "" && sheetObjects[11].CellValue(i, 11) == 3) {

					//sheetObjects[11].CellValue2(i, 31) = "1";
					sheetObjects[11].CellValue2(i, 32) = "1";
				}
			}

			ComOpenWindowCenter("/hanjin/EES_EQR_1055.do", "EES_EQR_1055"+popupCnt, 880, 670);
			popupCnt++;
			// }
		}
	}
}

/**
 * IBSeet내의 데이터 영역의 셀을 더블클릭했을 때 발생하는 Event<br>
 * 
 * @param {sheetObj}
 *            String : 해당 IBSheet셀 명
 * @param {Row}
 *            Long : 해당 셀의 Row Index
 * @param {Col}
 *            Long : 해당 셀의 Column Index
 * @param {Value}
 *            String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 * @param {CellX}
 *            Long : 해당셀의 X좌표
 * @param {CellY}
 *            Long : 해당셀의 Y좌표
 * @param {CellW}
 *            Long : 해당셀의 가로 넓이값
 * @param {CellH}
 *            Long : 해당셀의 세로 높이값
 */
function sheet9_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// 더블클릭한 row의 "pod"컬럼 값이 있으면
		if (ComGetLenByByte(Cellvalue(Row, "pod")) > 0) {
			for ( var i = 1; i < sheetObjects[11].RowCount + 1; i++) {
				if (sheetObjects[11].CellValue(i, 7) == CellValue(Row, 1) && sheetObjects[11].CellValue(i, 11) != "" && sheetObjects[11].CellValue(i, 11) == 4) {
					//sheetObjects[11].CellValue2(i, 31) = "1";
					sheetObjects[11].CellValue2(i, 32) = "1";
				}
			}

			ComOpenWindowCenter("/hanjin/EES_EQR_1055.do", "EES_EQR_1055"+popupCnt, 880, 670);
			popupCnt++;
		}
	}
}

/**
 * IBSeet내의 데이터 영역의 셀을 더블클릭했을 때 발생하는 Event<br>
 * 
 * @param {sheetObj}
 *            String : 해당 IBSheet셀 명
 * @param {Row}
 *            Long : 해당 셀의 Row Index
 * @param {Col}
 *            Long : 해당 셀의 Column Index
 * @param {Value}
 *            String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 * @param {CellX}
 *            Long : 해당셀의 X좌표
 * @param {CellY}
 *            Long : 해당셀의 Y좌표
 * @param {CellW}
 *            Long : 해당셀의 가로 넓이값
 * @param {CellH}
 *            Long : 해당셀의 세로 높이값
 */
function sheet10_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// 더블클릭한 row의 "pod"컬럼 값이 있으면
		if (ComGetLenByByte(Cellvalue(Row, "pod")) > 0) {
			// if(SelectCol == 1){
			for ( var i = 1; i < sheetObjects[11].RowCount + 1; i++) {
				if (sheetObjects[11].CellValue(i, 7) == CellValue(Row, 1) && sheetObjects[11].CellValue(i, 11) != "" && sheetObjects[11].CellValue(i, 11) == 5) {
					//sheetObjects[11].CellValue2(i, 31) = "1";
					sheetObjects[11].CellValue2(i, 32) = "1";
				}
			}

			ComOpenWindowCenter("/hanjin/EES_EQR_1055.do", "EES_EQR_1055"+popupCnt, 880, 670);
			popupCnt++;
			// }
		}
	}
}

/**
 * vvdTotal_OnSearchEnd --> hidden sheet
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function vvdTotal_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		if (sheetObjects[10].RowCount > 0) {
			parent.ComBtnEnable_frameLayer0("btn_mainretrieve");
		}
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (sAction == IBSEARCH) {
			if (parent.document.form.week.value == "") {
				ComShowCodeMessage("EQR90195");
				return false;
			}

			var w = parent.document.form.week;
			// 주별로 조회
			sVal1 = w.value.replace(/\/|\-|\./g, "");

			if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6))) {
				// ComShowCodeMessage("EQR90211", "YYYYWW");
				ComSetFocus(w);
				// w.value = "";
				return false;
			}

		} else {
			// if(sheetObj)
		}
	}

	return true;
}

/* 개발자 작업 끝 */