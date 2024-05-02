/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0161.js
 *@FileTitle : ESM_BKG_0161
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.10
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.07.10 김승민
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
 * @class ESM_BKG_0161 : ESM_BKG_0161 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0161() {
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

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_ok":
			var returnCode = "";
			if (formObj.select1.Code != "")
				returnCode = returnCode + formObj.select1.Code + ",";
			if (formObj.select2.Code != ""
					&& formObj.select1.Code == formObj.select2.Code ) {
				ComShowCodeMessage('BKG06018');
				return;
			}
			if (formObj.select2.Code != "")
				returnCode = returnCode + formObj.select2.Code + ",";
			if (formObj.select3.Code != ""
					&& (formObj.select1.Code == formObj.select3.Code ||
						formObj.select2.Code == formObj.select3.Code)	) {
				ComShowCodeMessage('BKG06018');
				return;
			}
			if (formObj.select3.Code != "")
				returnCode = returnCode + formObj.select3.Code + ",";
			if (formObj.select4.Code != ""
					&& (formObj.select1.Code == formObj.select4.Code ||
						formObj.select2.Code == formObj.select4.Code ||
						formObj.select3.Code == formObj.select4.Code)	) {
						
				ComShowCodeMessage('BKG06018');
				return;
			}
			if (formObj.select4.Code != "")
				returnCode = returnCode + formObj.select4.Code + ",";
			if (formObj.select5.Code != ""
					&& (formObj.select1.Code == formObj.select5.Code ||
						formObj.select2.Code == formObj.select5.Code ||
						formObj.select3.Code == formObj.select5.Code ||
						formObj.select4.Code == formObj.select5.Code)	) {
				ComShowCodeMessage('BKG06018');
				return;
			}
			if (formObj.select5.Code != "")
				returnCode = returnCode + formObj.select5.Code + ",";

			if (returnCode.length > 0)
				returnCode = returnCode.substring(0, returnCode.length - 1);

			window.close();
			opener.setOrderBy(returnCode);

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
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param sheet_obj IBSheet Object
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * IBComb Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param comb_obj IBComb Object
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	// IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}
	doActionIBSheet(sheetObjects[0], document.form, COMMAND01);

}

/**
 * 콤보 초기설정값
 * @param {IBMultiCombo} comboObj  comboObj
 */
function initCombo(comboObj) {
	comboObj.MultiSelect = false;
	comboObj.UseCode = true;
	comboObj.LineColor = "#ffffff";
	comboObj.SetColAlign("left|left");
	comboObj.MultiSeparator = ",";
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
			style.height = 97;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(0, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(2, 0, 1, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = "|";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 110, daCenter, false,
					"Priority", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 140, daLeft, false, "Select",
					false, "", dfNone, 0, true, true);

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
	case COMMAND01: // 입력
		formObj.f_cmd.value = INIT;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0161GS.do", FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		var codeGubun = formObj.codeGubun.value;
		if (codeGubun == "CD02298") {
			ComXml2ComboItem(arrXml[0], formObj.select1, "val", "name");
			ComXml2ComboItem(arrXml[0], formObj.select2, "val", "name");
			ComXml2ComboItem(arrXml[0], formObj.select3, "val", "name");
			ComXml2ComboItem(arrXml[0], formObj.select4, "val", "name");
			ComXml2ComboItem(arrXml[0], formObj.select5, "val", "name");
		} else if (codeGubun == "CD02196") {
			ComXml2ComboItem(arrXml[1], formObj.select1, "name", "desc");
			ComXml2ComboItem(arrXml[1], formObj.select2, "name", "desc");
			ComXml2ComboItem(arrXml[1], formObj.select3, "name", "desc");
			ComXml2ComboItem(arrXml[1], formObj.select4, "name", "desc");
			ComXml2ComboItem(arrXml[1], formObj.select5, "name", "desc");
		} else if (codeGubun == "CD02347") {
			ComXml2ComboItem(arrXml[2], formObj.select1, "val", "desc");
			ComXml2ComboItem(arrXml[2], formObj.select2, "val", "desc");
			ComXml2ComboItem(arrXml[2], formObj.select3, "val", "desc");
			ComXml2ComboItem(arrXml[2], formObj.select4, "val", "desc");
			ComXml2ComboItem(arrXml[2], formObj.select5, "val", "desc");
		} else if (codeGubun == "CD02377") {
			ComXml2ComboItem(arrXml[3], formObj.select1, "val", "name");
			ComXml2ComboItem(arrXml[3], formObj.select2, "val", "name");
			ComXml2ComboItem(arrXml[3], formObj.select3, "val", "name");
			ComXml2ComboItem(arrXml[3], formObj.select4, "val", "name");
			ComXml2ComboItem(arrXml[3], formObj.select5, "val", "name");
		}
		break;
	}
}
/* 개발자 작업 끝 */