/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_EQR_1055.js
 *@FileTitle : MTY Discharge Plan by VVD
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.14
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.08.14 박광석
 * 1.0 Creation
 * ------------------------------------------------------
 * history
 * 2012.10.31 문동선 [CHM-201220651-01] [EQR] EQR O5 Type Size 추가
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
 * @class EES_EQR_1055 : EES_EQR_1055 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_eqr_1055() {
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
	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_downExcel":
			sheetObject.Down2Excel(-1);
			break;
		case "btn_close":
			window.close();
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

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
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
	case 1: // t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 460;
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
			//InitColumnInfo(23, 0, 0, true);
			InitColumnInfo(24, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "Yard|Lane|VVD|ETB|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5|";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "yardcode", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "lane", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "vvd", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "etb", false, "", dfDateYmd, true, true);

			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, true, "d2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, true, "d4", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, true, "d5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, true, "d7", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, true, "r2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, true, "r5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, true, "r9", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, true, "o2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, true, "s2", false, "", dfInteger, true, true);

			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, true, "o4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, true, "s4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, true, "o5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, true, "f2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, true, "a2", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, true, "f4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, true, "a4", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, true, "f5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtAutoSum, 37, daCenter, true, "a5", false, "", dfInteger, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, true, "weekdivision", false, "", dfNone, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, true, "pod", false, "", dfNone, true, true);

//			ColHidden(21) = true;
//			ColHidden(22) = true;
			ColHidden(22) = true;
			ColHidden(23) = true;			
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
		var sXml = ComMakeSearchXml(top.opener.form.portTotal, false, "hiddencheck",
				"yardcode|lane|vvd|etb|d2|d4|d5|d7|r2|r5|r9|o2|s3|o4|s4|o5|f2|a2|f4|a4|f5|a5|weekdivision|pod");
		//alert("1 : "+top.opener.form.portTotal.RowCount + 1);
		for ( var i = 1; i < top.opener.form.portTotal.RowCount + 1; i++) {
//			if (top.opener.form.portTotal.CellValue(i, 31) == "1") {
//				top.opener.form.portTotal.CellValue2(i, 31) = "0";
//			}
			if (top.opener.form.portTotal.CellValue(i, 32) == "1") {
				top.opener.form.portTotal.CellValue2(i, 32) = "0";
			}			
		}

		sheetObj.LoadSearchXml(sXml, true);
		sheetObj.WaitImageVisible = true;
		ComOpenWait(false);

		break;
	}
}

/**
 * IBSeet내의 데이터 영역의 셀을 더블클릭했을 때 발생하는 Event<br>
 * 
 * @param {sheetObj} String : 해당 IBSheet셀 명
 * @param {Row} Long : 해당 셀의 Row Index
 * @param {Col} Long : 해당 셀의 Column Index
 * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 * @param {CellX} Long : 해당셀의 X좌표
 * @param {CellY} Long : 해당셀의 Y좌표
 * @param {CellW} Long : 해당셀의 가로 넓이값
 * @param {CellH} Long : 해당셀의 세로 높이값
 */
function sheet1_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
//		if (CellValue(Row, 21) == "1") {
//			top.opener.scroll(0, 0);
//		} else if (CellValue(Row, 21) == "2") {
//			top.opener.scroll(0, 0);
//		} else if (CellValue(Row, 21) == "3") {
//			top.opener.scroll(324, 0);
//		} else if (CellValue(Row, 21) == "4") {
//			top.opener.scroll(900, 0);
//		} else if (CellValue(Row, 21) == "5") {
//			top.opener.scroll(900, 0);
//		}
		
		if (CellValue(Row, 22) == "1") {
			top.opener.scroll(0, 0);
		} else if (CellValue(Row, 22) == "2") {
			top.opener.scroll(0, 0);
		} else if (CellValue(Row, 22) == "3") {
			top.opener.scroll(324, 0);
		} else if (CellValue(Row, 22) == "4") {
			top.opener.scroll(900, 0);
		} else if (CellValue(Row, 22) == "5") {
			top.opener.scroll(900, 0);
		}		
	}
//	var sheet = eval("top.opener.form.sheet" + sheetObj.CellValue(Row, 21));
//	var Rows = sheet.FindText(2, sheetObj.CellValue(Row, 2));
//	var podRow = sheet.FindText(3, sheetObj.CellValue(Row, 22), Rows);
//	if(sheet.CellValue(podRow,4) == ""){
//		podRow = sheet.FindText(3, sheetObj.CellValue(Row, 22), podRow+1);
//	}
	
	var sheet = eval("top.opener.form.sheet" + sheetObj.CellValue(Row, 22));
	var Rows = sheet.FindText(2, sheetObj.CellValue(Row, 2));
	var podRow = sheet.FindText(3, sheetObj.CellValue(Row, 23), Rows);
	if(sheet.CellValue(podRow,4) == ""){
		podRow = sheet.FindText(3, sheetObj.CellValue(Row, 23), podRow+1);
	}	
	
	
	top.opener.hideCursorBar();
	sheet.focus();
	sheet.SelectCell(podRow, 1, false);
}

/**
 * IBTab Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
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
		ColumnSort("etb");
		SetMergeCell(sheetObj.RowCount + 1, 0, 1, 3);

		// CellAlign(0,0) = daCenter;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
	}

	return true;
}

/* 개발자 작업 끝 */