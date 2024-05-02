/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_1211.js
 *@FileTitle : Report Template
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.10.18
 *@LastModifier : 박은정
 *@LastVersion : 1.0
 * 2013.10.18 박은정
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
 * @extends
 * @class esm_bkg_0104 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1211() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */
/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

/** ********************* EDTITABLE MULIT COMBO START ******************* */
var comboCnt = 0;
var comboObjects = new Array();
/** ********************* EDTITABLE MULIT COMBO END ******************* */

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	// 멀티콤보를 위해 곧 바로 조회하면 IBSheet 제대로 그려지지 않아 화면이 깨지는데 이것을 방지 하기 위해 딜레이를 0.1 초를
	// 준다

}

function initControl() {
	var formObject = document.form;

	axon_event.addListenerFormat('keypress', 'bkg_keypress', formObject); // -
																			// 키보드
																			// 입력할때
	axon_event.addListenerForm('blur', 'bkg_blur', formObject); // - 포커스 나갈때
	axon_event.addListenerFormat('focus', 'bkg_focus', formObject); // - 포커스
																	// 들어갈때
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('change', 'bkg_change', formObject);
}

/*
 * 조회 후 Type이 Common, Shared이면 Editable = false;
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		if (sheetObj.CellValue(3, "bkg_ofc_cd") == "") {
			sheetObj.RemoveAll();
			ComShowMessage("The BKG OFC \'" + document.form.bkg_ofc.value
					+ "\' doesn't exist");
			document.form.bkg_ofc.value = "";
			return false;
		}
	}
}

function sheet1_OnChange(sheetObj, row, col) {

	// chkOnSearchEnd(sheetObj,row);
	var rows = sheetObj.Rows;

	switch (sheetObj.ColSaveName(col)) {
		case "green_to":
			sheetObj.CellValue(row, "yellow_fr") = sheetObj.CellValue(row, col);
			break;
		case "yellow_fr":
			sheetObj.CellValue(row, "green_to") = sheetObj.CellValue(row, col);
			break;
		case "yellow_to":
			sheetObj.CellValue(row, "red_fr") = sheetObj.CellValue(row, col);
			break;
		case "red_fr":
			sheetObj.CellValue(row, "yellow_to") = sheetObj.CellValue(row, col);
			break;
	}
}

/** ********************* KEY EVENT END ******************* */

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1 = sheetObjects[0];

	var comboObject1 = comboObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	// try {

	var srcName = window.event.srcElement.getAttribute("name");

	switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;
	
		case "btn_save":
	
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			// saveValidFlag = true; //밸리데이트 초기화
			// doActionIBSheet(sheetObject1,formObject,IBSAVE);
			break;
		case "btn_default":
		    doActionIBSheet(sheetObject1, formObject, "Default");
		    break;

	} // end switch
	// }catch(e) {
	// if( e == "[object Error]") {
	// ComShowMessage(OBJECT_ERROR);
	// } else {
	// ComShowMessage(e);
	// }
	// }

}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, Row, Col, PageNo) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

		case IBSEARCH: // 조회
			if (!validateForm(sheetObj, formObj, sAction))
				return;
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.DoSearch("ESM_BKG_1211GS.do",
					FormQueryString(formObj));
	
			break;
	
		case IBSAVE: // 저장
			var searchOfc = sheetObj.CellValue(3, "bkg_ofc_cd");
			formObj.f_cmd.value = MULTI;
			if (!validateForm(sheetObj, formObj, sAction)) return;
			var result = sheetObj.DoAllSave("ESM_BKG_1211GS.do", FormQueryString(formObj));
			// window.returnValue = true;
			break;
		case "Default":
		    if (!validateForm(sheetObj, formObj, sAction)) return;
		    formObj.f_cmd.value = MULTI01;
		    var result = sheetObj.DoAllSave("ESM_BKG_1211GS.do", FormQueryString(formObj));
		    break;
	}
}

/**
 * OnSaveEnd 이벤트 발생시 호출되는 function <br>
 * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {ibsheet}
 *            sheetObj 필수 IBSheet Object
 * @param {string}
 *            ErrMsg 필수 서버에서 넘어온 메세지
 * @return 없음
 * @version 2009.05.17
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	var formObject = document.form;
	if (ErrMsg == "") {
		doActionIBSheet(sheetObj, formObject, IBSEARCH);
		ComBkgSaveCompleted();
	}
}

/*
 * Report Name 중복 체크
 */
function isRptNameDup(rowIdx, p_rpt_nm) {
	with (sheetObjects[0]) {
		var rpt_nm;
		for ( var i = HeaderRows; i < Rows; i++) {

			if (rowIdx == i)
				continue;
			if (CellValue(i, "ibflag") == 'D')
				continue;

			rpt_nm = CellValue(i, "rpt_nm");
			if (rpt_nm == p_rpt_nm) {
				return true;
			}
		}
	}

	return false;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH:
			if (formObj.bkg_ofc.value == "") {
				ComShowMessage("Please input BKG OFC");
				formObj.bkg_ofc.focus();
				return false;
			}
			break;
		case IBSAVE:
	
			with (sheetObj) {
				for ( var i = HeaderRows; i < Rows; i++) {
					if(CellValue(i, "yellow_fr") == '' && CellValue(i, "yellow_to") == ''){
					    continue;
					} else if (
					        CellValue(i, "yellow_fr") == '' || CellValue(i, "yellow_to") == '' ||
					        Number(CellValue(i, "yellow_fr")) > Number(CellValue(i, "yellow_to"))) {
						ComShowMessage("The TO value of GREEN must be the same or smaller than the TO value of YELLOW");
						sheetObj.SelectCell(i, "green_to");
						return false;
					}
				}// end for
			} // end with(sheetObject[0])
	
			break;
		case 'Default':
		    if(confirm(msgs['BKG08280'])){
		        return true;
		    }else{
		        return false;
		    }
		    break;
	}
	return true;
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetObj.id) {

	case "sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 270;

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
			InitRowInfo(2, 1, 10, 50);

			var HeadTitle1 = "ibflag |SEQ |BKG OFC|IRR type| ITEM |Today's Average of\nall offices| Green | Green | Yellow | Yellow | Red | Red ";
			var HeadTitle2 = "ibflag |SEQ |BKG OFC|IRR type| ITEM |Today's Average of\nall offices| FM(%) | TO(%) | FM(%) | TO(%) | FM(%) | TO(%)";

			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			// ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize],
			// [RowMove],[Head3D])
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			// InitDataProperty(0, cnt++ , dtSeq, 35, daCenter, false, "Seq");
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,
					"ibflag");

			InitDataProperty(0, cnt++, dtSeq, 80, daCenter, true, "seq");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,	"bkg_ofc_cd", false, "", dfNone, 0, false, true, 50);
			InitDataProperty(0, cnt++, dtHidden, 140, daLeft, true, "dbd_irr_tp_cd", false, "", dfNone, 0, false, true, 50);
			InitDataProperty(0, cnt++, dtData, 150, daLeft, true, "rpt_itm_nm", false, "", dfNone, 0, false, true, 50);
			InitDataProperty(0, cnt++, dtData, 140, daCenter, true, "today_avg", false, "", dfNone, 0, false, true, 50);
            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "green_fr", false, "", dfNullFloat, 1, false, true, 3);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "green_to", false, "", dfNullFloat, 1, true, true, 3);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "yellow_fr", false, "", dfNullFloat, 1, true, true, 3);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "yellow_to", false, "", dfNullFloat, 1, true, true, 3);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "red_fr", false, "", dfNullFloat, 1, true, true, 3);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "red_to",false, "", dfNullFloat, 1, false, true, 3);

			// if(form.p_bkg_rpt_knd_cd.value="B")
			// ColHidden("item_option") = true;

			CountPosition = 0;// [1/3] 페이지 위치
		}

		break;
	}
}

 
function ChangeSize(iWidth)
{ 
    sheetObjects[0].SheetWidth = iWidth-10;
    sheetObjects[0].FitColWidth();
}
 
/* 개발자 작업 끝 */

