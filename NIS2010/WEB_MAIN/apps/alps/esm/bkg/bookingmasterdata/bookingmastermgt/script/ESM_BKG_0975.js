/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0975.js
 *@FileTitle : Charge_Charge code inquiry
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
 * @class esm_bkg_0975 : esm_bkg_0975 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0975() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.sheet1_OnScrollNext = sheet1_OnScrollNext;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var URL_ESM_BKG = 'ESM_BKG_0975GS.do';
var prefix = "sheet1_";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	axon_event.addListenerFormat('keydown', 'obj_keydown', formObject);
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// popup 호출시 select 버튼 비활성화 
	
	//팝업에서 호출시 return 한다.
	if(ComGetObjValue(document.form.isPop) == 'Y') {
		eval('DIV_btn_Select').style.display = 'none';
	}

	initControl();
	initFocus();
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
			style.height = 420;
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
			InitRowInfo(1, 1, 20, 100);

			var HeadTitle1 = "|Code|Description";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]

			InitDataProperty(0, cnt++, dtRadioCheck, 30, daCenter, false, "radio", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "chg_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "chg_nm", false, "", dfNone, 0, false, true);

			MultiSelection = false;
			SelectHighLight = true;
			SheetBackColor = RgbColor(248, 248, 248);
			SelectBackColor = RgbColor(236, 246, 247);
			CountPosition = 0;
			FocusEditMode = 0;
		}
		break;
	}
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
		case "btn_Select":
			var selrow = sheetObject.SelectRow;
			if (selrow > 0) {
				comPopupOK();
			}			
			break;
		case "btn_Close":
			self.close();
			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
			bkg_error_ComShowMessage(e);
		} else {
			ComShowMessage(e);
		}
	}
}
/**
* 그리드에서 더블클릭했을 때의 처리 : 선택한 값을 부모창으로 리턴하고, 팝업창을 닫는다.
*/
function sheet1_OnDblClick(sheetObj, row, col, value) {
	//팝업에서 호출시 return 한다.
	if(ComGetObjValue(document.form.isPop) == 'Y') return;
	
	var selrow = sheetObj.SelectRow;
	if (selrow > 0) {
		comPopupOK();
	}
}
/**
 * getSelectedRow
 * 선택한 row의 값을 넘겨준다. 
 */
function getCheckedRows(colName) {
	
	//팝업에서 호출시 return 한다.
	if(ComGetObjValue(document.form.isPop) == 'Y') return;
		
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	var checkRows = sheetObj.CheckedRows('radio');
	if (checkRows == 0)
		return null;
	var rArray = null; //행데이터를 담고 있는 배열
	var cArray = null; //열데이터를 담고 있는 배열

	try {

		var rows = sheetObj.Rows;
		var idx = 0;
		rArray = new Array(checkRows);

		for ( var i = 0; i < rows; i++) {
			if (sheetObj.CellValue(i, 'radio') == 1) {
				cArray = sheetObj.CellValue(i, colName);
				rArray[idx++] = cArray;
			}
		}
	} catch (e) {
		bkg_error_ComShowMessage(e);
	}
	return rArray;
}

/**
 * sheet1_OnScrollNext
 * 다음 스크롤 처리 
 */
function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, CondParam, PageNo);
}

/**
 * Sheet1의 OnSearchEnd 이벤트 처리
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {

}
/**
 * initFocus 초기 포커스 처리 
 */
function initFocus() {
	var formObj = document.form;
	formObj.chg_cd.focus();
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
	sheetObj.ShowDebugMsg = false;
	var aryPrefix = new Array("sheet1_");

	switch (sAction) {

	case IBSEARCH: //조회
		
		//파라메터로 CHG_CD 가 넘어올경우 받아서 조회 할수 있도록 함  2010.01.13
//		if(ComGetObjValue(formObj.chgcd) !=''){
//			formObj.chg_cd.value = formObj.chgcd.value;
//		}
		
		// 1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
		ComSetObjValue(formObj.f_cmd, SEARCH);
		ComSetObjValue(formObj.ipage, '1');
		// 2.조회조건으로 조회실행
		sheetObj.DoSearch4Post(URL_ESM_BKG, '', FormQueryString(formObj), false);
		// 3.조회후 결과처리

		break;

	case IBSEARCHAPPEND:
		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.	
		ComSetObjValue(formObj.ipage, PageNo);
		// 2.조회조건으로 조회실행
		sheetObj.DoSearch4Post(URL_ESM_BKG, '', FormQueryString(formObj), true);
		break;
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
 * 화면 폼입력값에 대한 엔터 이벤트 처리
 */
function obj_keydown() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	if (event.keyCode == 13)
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
}
 /**
  * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
  **/
 function obj_keypress() {

 	switch (event.srcElement.dataformat) {
 	case "int":
 		//숫자만입력하기
 		ComKeyOnlyNumber(event.srcElement);
 		break;
 	case "float":
 		//숫자+"."입력하기
 		ComKeyOnlyNumber(event.srcElement, ".");
 		break;
 	case "eng":
 		//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
 		ComKeyOnlyAlphabet();
 		break;
 	case "engdn":
 		//영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
 		ComKeyOnlyAlphabet('lower');
 		break;
 	case "engup":
 		//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
 		ComKeyOnlyAlphabet('upper');
 		break;
 	case "uppernum":
 		//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
 		ComKeyOnlyAlphabet('uppernum');
 		break;
 	default:
 		//숫자만입력하기(정수,날짜,시간)
 		ComKeyOnlyNumber(event.srcElement);
 	}
 }
/**
 * Debug alert 
 */
function bkg_error_alert(ex) {
	alert('[ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
}
/* 개발자 작업  끝 */