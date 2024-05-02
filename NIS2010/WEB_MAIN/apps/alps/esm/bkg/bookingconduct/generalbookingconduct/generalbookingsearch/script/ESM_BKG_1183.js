/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_1182.js
 *@FileTitle : Booking Attachment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.02.05 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.02.05 
 * 1.0 Creation
 *----------------------------------------------------------
 * History
 * 2015.02.05 [CHM-201432844] 제안제도 : BKG Creation 화면에 Attachment 기능 추가
 *            (ESM_BKG_0369 그대로 옮겨 옴)
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
 * @class esm_bkg_1182 : esm_bkg_1182 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1183() {
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
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	try {
/*		if (document.form.bkg_no.value == '') {
			alert('[경고] 필수값이 없습니다.\n 테스트 데이터[KORZB035223]로 대체합니다.');
			document.form.bkg_no.value = 'BREY8050031';
		}*/

		if (document.form.bkg_no.value == '') {
			ComShowCodeMessage("BKG00463");// 조회를 위한 BKG no가 없습니다.
			self.close();
		}

		for (i = 0; i < sheetObjects.length; i++) {

			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);

			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

	} catch (ex) {
		bkg_error_alert(ex);
		return false;
	}
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
			style.height = 182;
			// 전체 너비 설정
//			SheetWidth = mainTable.clientWidth;
			style.width = 710;
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
			InitColumnInfo(5, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "|Seq|Type|Total Amount (USD)|Remark";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 280, daLeft, false, "cost_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 280, daRight, false, "amt", false, "", dfNullFloat , 2, false, false);
			InitDataProperty(0, cnt++, dtHidden, 210, daCenter, false, "rmk", false, "", dfNone, 0, false, false);

			ColIndent("amt") = 150;
			MultiSelection = false;
			SelectHighLight = true;
			SheetBackColor = RgbColor(248, 248, 248);
			SelectBackColor = RgbColor(236, 246, 247);
			CountPosition = 0;
		}
		break;
	}
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
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
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
/**
 * Sheet관련 프로세스 처리 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {String} 	formObj   
 * @param {String} 	sAction   
 * @return {없음}
 **/
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var sParam = FormQueryString(formObj);
	sheetObj.DoSearch("ESM_BKG_1183GS.do", sParam);
//	switch (sAction) {
//	
//	case IBSEARCH: //조회
//		if (!validateForm(sheetObj, formObj, sAction))
//			return;
//
//		// 1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
//		ComSetObjValue(formObj.f_cmd, SEARCH);
//		// 2.조회조건으로 조회실행
//		var sXml = sheetObj.GetSearchXml(URL_ESM_BKG, FormQueryString(formObj) + "&" + ComGetPrefixParam('sheet1_'));
//		// 3.조회후 결과처리
//		sheetObj.LoadSearchXml(sXml);
//		// 4.값 존재시 처리
//		break;
//	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
//		// 저장시 유효성검사 
//		if (sAction == IBSAVE) {
//			var c_row = sheetObj.LastRow;
//			if (c_row == 0) {
//				ComShowCodeMessage("BKG00358");// Please select data to save.
//				return;
//			}
//			for ( var row = 1; row <= c_row; row++) {
//				var v_file_nm = sheetObj.CellValue(row, prefix + "file_nm");
//				if (v_file_nm == '') {
//					ComShowMessage(row + "행의 [File Name]은 필수값입니다. ");
//					selectFile(sheetObj, sheetObj.RowCount, '', true);
//					return false;
//				}
//			}
//
//			// 검색시 유효성검사
//		} else if (sAction == IBSEARCH) {
//
//		}
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
 * Debug alert 
 */
function bkg_error_alert(ex) {
	alert('[ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
}
 /**
 * fnExceptionMessage 
 */
// function fnExceptionMessage(rXml){
// 	var rMsg = ComGetEtcData(rXml,"Exception")
// 	var rmsg = rMsg.split("<||>");
// 	if(rmsg[3] != undefined && rmsg[3].length > 0) {
// 		ComShowMessage(rmsg[3]);
// 	}else{
// 		sheetObjects[0].LoadSaveXml(rXml);
// 	}
// }
/* 개발자 작업  끝 */