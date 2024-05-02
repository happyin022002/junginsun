/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0401.js
 *@FileTitle : Customer Code Entry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.16
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.16 김민정
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0401() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.sheet1_OnClick = sheet1_OnClick;
}

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

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
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, SEARCH);
			break;
		case "btn_New":
			formObject.reset();
			sheetObject.RemoveAll();
			formObject.attr_ctnt1.focus();
			break;
		case "btn_Save":
			doActionIBSheet(sheetObjects[0], document.form, MODIFY);
			break;
		case "btn_Delete":
			doActionIBSheet(sheetObjects[0], document.form, REMOVE);
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComFuncErrMsg(e);
		} else {
			ComFuncErrMsg(e);
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
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListenerForm("KeyDown", "obj_KeyDown", document.form);
	document.form.attr_ctnt1.focus();
	doActionIBSheet(sheetObjects[0], document.form, SEARCH);
}

/**
 * 시트 초기설정값, 헤더 정의
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
			style.height = 200;

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
			InitRowInfo(1, 1, 4, 100);

			var HeadTitle1 = "flag|id|seq|ctnt1|ctnt2";
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
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "hrd_cdg_id", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "hrd_cdg_id_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt1", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt2", false, "", dfNone, 0, true, true);
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
	case SEARCH: //Retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0401GS.do", FormQueryString(formObj));
			if (ComBkgErrMessage(sheetObj, sXml)) {
				sheetObj.LoadSearchXml(sXml);
				IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
				formObj.frm_attr_ctnt2.focus();
			} else {
				formObj.attr_ctnt1.value = "";
				formObj.frm_attr_ctnt2.value = "";
				formObj.attr_ctnt1.focus();
			}
			ComOpenWait(false);
		}
		break;
	case MODIFY: //Save
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = MODIFY;
			IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
			if (sheetObj.CellValue(1, "hrd_cdg_id_seq") == "") {
				//등록
				sheetObj.CellValue2(1, "ibflag") = "I";
			} else {
				//수정
				if (!sheetObj.IsDataModified) {
					//변경된 내역이 없을경우
					ComShowCodeMessage('BKG00743');
					return;
				}
				sheetObj.RowStatus(1) = "U";
			}
			if (ComShowCodeConfirm("BKG00350")) {
				ComOpenWait(true);
				sheetObj.CellValue2(1, "attr_ctnt1") = formObj.attr_ctnt1.value;
				var param = ComGetSaveString(sheetObj) + "&f_cmd=" + MODIFY;
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0401GS.do", param);
				sheetObj.loadSaveXml(sXml);
				if (ComBkgErrMessage(sheetObj, sXml)) {
					doActionIBSheet(sheetObj, formObj, SEARCH)
				}
				ComOpenWait(false);
			}
		}
		break;
	case REMOVE: //Save
		if (validateForm(sheetObj, formObj, sAction)) {
			if (ComShowCodeConfirm("BKG00592")) {
				ComOpenWait(true);
				sheetObj.RowStatus(1) = "U";
				sheetObj.CellValue2(1, "attr_ctnt1") = formObj.attr_ctnt1.value;
				sheetObj.CellValue2(1, "attr_ctnt2") = "";
				var param = ComGetSaveString(sheetObj) + "&f_cmd=" + REMOVE;
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0401GS.do", param);
				sheetObj.loadSaveXml(sXml);
				formObj.reset();
				ComOpenWait(false);
			}
		}
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case SEARCH:
		if (!ComChkValid(formObj))
			return false;
		break;
	case MODIFY:
	case REMOVE:
		if (sheetObj.RowCount != 1) {
			ComShowCodeMessage('BKG00395');
			return false;
		}
		break;
	}
	return true;
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	if (srcName == "attr_ctnt1") {
		if (event.keyCode == 13) {
			ComKeyEnter();
		}
	} else if (srcName == "frm_attr_ctnt2") {
		fncTextCnt(5, 55, document.form.frm_attr_ctnt2)
	}
}

/**
 * 텍스트박스 글자수 제한 
 */
function obj_KeyDown() {
	var srcName = window.event.srcElement.getAttribute("name");
	if (srcName == "frm_attr_ctnt2") {
		fncTextCnt(5, 55, document.form.frm_attr_ctnt2)
	}
}

/**
 * 텍스트박스 글자수 제한
 * @param maxRow 최대행
 * @param maxCol 최대열
 * @param colObj 오브젝트
 */
function fncTextCnt(maxRow, maxCol, colObj) {
	var formObj = document.form;
	var arrRows = colObj.value.split("\n");
	var sEventValue = window.event.srcElement.getAttribute("value");
	var sStart = arrRows.length - 1;

	for ( var i = sStart; i < arrRows.length; i++) {
		var sCol = arrRows[i];
		for ( var j = 0; j < sCol.length; j++) {
			if (j == maxCol - 1) {
				colObj.value = colObj.value + "\n";
				sStart++;
			}
		}
	}
	if (sStart == maxRow && arrRows.length == maxRow) {
		var sCol = arrRows[maxRow - 1];
		if (sCol.length > maxCol) {
			colObj.value = sEventValue.substring(0, sEventValue.length - 1)
		}
	}

	if (arrRows.length > maxRow) {
		var txt = '';
		for ( var i = 0; i < maxRow; i++) {
			if (i == (maxRow - 1)) {
				txt += arrRows[i].substring(0, arrRows[i].length - 1);
			} else {
				txt += arrRows[i];
			}
		}
		colObj.value = txt;
	}
}