/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1037.js
 *@FileTitle : Rail AMS History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.01  
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.09.01  김도완
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
 * @class ESM_BKG-1037 : ESM_BKG-1037 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1037() {
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
var comboCnt = 0;
var comboObjects = new Array();

var sheetObjects = new Array();
var sheetCnt = 0;
var intervalId = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
// ComComboObject생성자 메소드에서 호출됨
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 * @param comboObj
 * @param comboId
 * @return
 */
function initCombo(comboObj, comboId) {
	var formObject = document.form
	comboObj.DropHeight = 135;
	initComboEditable(comboObj);
}

/**
 * initComboEditable
 * @param combo
 * @return
 */
function initComboEditable(combo) {
	with (combo) {
		MultiSelect = false;
		UseEdit = false;
		UseAutoComplete = true; // 편집시 자동 코드 검색
	}
}

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Print":
			doActionIBSheet(sheetObject, document.form, SEARCH11);
			break;

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
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	//MultiCombo초기화 
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], comboObjects[k].id);
	}

	initControl();

	// 멀티콤보를 위해 곧 바로 조회하면 IBSheet 제대로 그려지지 않아 화면이 깨지는데 이것을 방지 하기 위해 딜레이를 0.1 초를 준다
	setTimeout( function() {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}, 100);

}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 */
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";

	var formObject = document.form;

	// Combo변경시 조회 실행.
	axon_event.addListenerForm('change', 'chkChange2', formObject);

}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * @param sheetObj
 * @param sheetNo
 * @return
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1": //sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 400;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 4, 1000);

			var HeadTitle1 = "Seq.|C|Code|Container No.|Rail AMS File No.|Q'ty|Entry Type & Number|Entry Type & Number|Receive Date/Time|Customs|VVD|Remark|Batch|||";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, false, "seq");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "c", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "code", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cntr_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "rail_ams_file_no", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 60, daRight, false, "qty", false, "", dfNumber, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "entry_type", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "entry_number", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "rcv_dt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "customs", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "nvocc_vvd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "remark", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "batch", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "code_desc", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "c_desc", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");

		}
		break;

	}
}

/**
 * Sheet관련 프로세스 처리
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회

		if (!validateForm(sheetObj, formObj, sAction))
			return;

		formObj.f_cmd.value = SEARCH;

		var sXml = sheetObj.GetSearchXml("ESM_BKG_1037GS.do", FormQueryString(formObj));

		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0) {
			sheetObjects[0].LoadSearchXml(arrXml[0]);
		}
		if (arrXml.length > 1) {
			ComXml2ComboItem(arrXml[1], formObj.bl_no, "bl_no", "bl_no");
//			formObj.bl_no.Index = 0;
			if (formObj.p_bl_no.value != "") {
				formObj.bl_no.Code = formObj.p_bl_no.value;
			} else {
				formObj.bl_no.Index = 0;
			}
		}

		formObj.f.value = sheetObj.EtcData("f");
		formObj.o.value = sheetObj.EtcData("o");
		formObj.c.value = sheetObj.EtcData("c");
		formObj.c.title = sheetObj.EtcData("c_desc");
		formObj.vsl_nm.value = sheetObj.EtcData("vsl_nm");
		formObj.pol.value = sheetObj.EtcData("pol");
		formObj.pod.value = sheetObj.EtcData("pod");
		formObj.eta.value = sheetObj.EtcData("eta");
		formObj.del.value = sheetObj.EtcData("del");
		formObj.hub.value = sheetObj.EtcData("hub");
		formObj.r.value = sheetObj.EtcData("r");
		formObj.d.value = sheetObj.EtcData("d");
		formObj.qty.value = ComAddComma(sheetObj.EtcData("qty"));
		formObj.qty_tp.value = sheetObj.EtcData("qty_tp");
		formObj.wgt.value = ComAddComma(sheetObj.EtcData("wgt"));
		formObj.wgt_up.value = sheetObj.EtcData("wgt_up");

		break;

	case SEARCH11: //Print
		if (sheetObj.RowCount == 0) {
			ComShowCodeMessage("BKG00889");
			return;
		}
		ComOpenWindowCenter("/hanjin/ESM_BKG_5024.do", "5024", 1024, 720, false);
		break;

	}
}

/**
 * BackEndJob 실행결과조회.
 * @param sheetObj
 * @param sKey
 * @return
 */
function doActionValidationResult(sheetObj, sKey) {
	var sXml = sheetObj.GetSearchXml("ESM_BKG_1037GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");

	// 에러가 발생했을 경우 대기사항을 종료한다.
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		// 성공메시지 보여주고
		ComShowCodeMessage('BKG00101');
		// sheet1, sheet2 다시 조회
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		return;
	} else if (sJbStsFlg == "FAIL") {
		//에러
		clearInterval(intervalId);
		ComOpenWait(false);
		// 에러메시지 보여주고
		ComShowMessage(ComResultMessage(sXml));
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		if (!ComChkRequired(formObj))
			return false;
		break;
	case MULTI:

		if (sheetObjects[0].RowCount == 0) {

			ComShowCodeMessage("BKG00889"); // No data found
			return false;
		}

		if (!sheetObj.IsDataModified) {
			ComShowCodeMessage("BKG00249"); // No Selected Row
			return false;
		}
		break;
	case IBDOWNEXCEL:
		if (sheetObjects[0].RowCount == 0) {
			ComShowCodeMessage("BKG00889"); // No data found
			return false;
		}
		break;
	}
	return true;
}

/**
 * sheet1 조회 후
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		for ( var i = 1; i <= LastRow; i++) {
			ToolTipText(i, "code") = CellValue(i, "code_desc");
			ToolTipText(i, "c") = CellValue(i, "c_desc");
		}
	}
}

/**
 * MultiCombo에 입력된 값이 추가된 값인지 확인하여 처리한다.
 * 입력값을 upper로 변경하여 재등록 한다.
 * @param comboObj
 * @return
 */
function bl_no_OnChange(comboObj) {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
