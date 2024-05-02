/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName :ESM_BKG_1042.js
 *@FileTitle : US Wharfage Exception Keyword
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.31
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.16 김민정
 * 1.0 Creation
=========================================================*/
/*******************************************************************************
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 * [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7 기타 여분의 문자상수
 * COMMAND01=11; ~ COMMAND20=30;
 ******************************************************************************/

/**
 * 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_1042() {
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
var beforetab = 1;

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
		case "btn_Save":
			doActionIBSheet(sheetObject, formObject, MULTI);
			break;
		case "btn_Close":
			window.close();
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
	sheetObjects[0].WaitImageVisible = false;
	doActionIBSheet(sheetObjects[0], document.form, SEARCH);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListenerForm('Change', 'obj_Change', document.form);
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
			style.height = 120;
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
			InitRowInfo(1, 1, 10, 100);

			var HeadTitle1 = " |ibflag|0-7M (20FT.)|7-9M (24FT.)|9-13M (40FT.)|OVR 13M (45FT.)|CONT|TEUS|AUTOS|||||||";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 1, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, false, true, false, false)

			Rows = 5;

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 120, daLeft, true, "", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHiddenStatus, 50, daLeft, true, "ibflag");
			InitDataProperty(0, cnt++, dtData, 90, daRight, true, "ft20", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daRight, true, "", false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daRight, false, "ft40", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "ft45", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "cont", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "teus", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daRight, false, "", false, "", dfNullFloat, 2, false, false);

			InitDataProperty(0, cnt++, dtHidden, 0, daRight, false, "eff_dt");
			InitDataProperty(0, cnt++, dtHidden, 0, daRight, false, "port");
			InitDataProperty(0, cnt++, dtHidden, 0, daRight, false, "bound");
			InitDataProperty(0, cnt++, dtHidden, 0, daRight, false, "usa_whf_trsp_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daRight, false, "full_mty_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daRight, false, "usa_whf_expt_flg");
			InitDataProperty(0, cnt++, dtHidden, 0, daRight, false, "whf_dc_rt");
			HeadFontBold = true;
			InitHeadColumn(0, "LOCAL Full CNTR|LOCAL Empty CNTR|IPI Full CNTR|IPI Empty CNTR", daCenter);
			CountPosition = 0;
			ScrollBar = 0;
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
	formObj.f_cmd.value = sAction;

	switch (sAction) {
	case SEARCH: //Retrieve
		ComOpenWait(true,true);
		sheetObj.DoSearch("ESM_BKG_1042GS.do", FormQueryString(formObj));
		formObj.whf_dc_rt.value = sheetObj.CellValue(1, "whf_dc_rt");
		sheet1_OnChange(sheetObj, 1, 1, "");
		ComOpenWait(false);
		break;
	case MULTI: //Save
		ComOpenWait(true,true);
		for ( var i = 1; i < sheetObj.RowCount + 1; i++) {
			sheetObj.CellValue2(i, "whf_dc_rt") = formObj.whf_dc_rt.value;
		}
		sheetObj.DoSave("ESM_BKG_1042GS.do", FormQueryString(formObj), -1, false);
		ComOpenWait(false);
		break;
	}
}

/**
 * 시트1 키보드 누를때
 * @param sheetObj 시트오브젝트
 * @param Row Row Index
 * @param Col Col Index
 * @param KeyCode KeyCode
 * @param Shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 */
function sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift) {
	if (sheetObj.ColSaveName(Col) == "ft20") {
		if (sheetObj.CellValue(Row, "cont") != "" || sheetObj.CellValue(Row, "teus") != "") {
			sheetObj.CellEditable(Row, Col) = false;
		} else {
			sheetObj.CellEditable(Row, Col) = true;
		}
	}
	if (sheetObj.ColSaveName(Col) == "ft40") {
		if (sheetObj.CellValue(Row, "cont") != "" || sheetObj.CellValue(Row, "teus") != "") {
			sheetObj.CellEditable(Row, Col) = false;
		} else {
			sheetObj.CellEditable(Row, Col) = true;
		}
	}
	if (sheetObj.ColSaveName(Col) == "ft45") {
		if (sheetObj.CellValue(Row, "cont") != "" || sheetObj.CellValue(Row, "teus") != "") {
			sheetObj.CellEditable(Row, Col) = false;
		} else {
			sheetObj.CellEditable(Row, Col) = true;
		}
	}
	if (sheetObj.ColSaveName(Col) == "cont") {
		if (sheetObj.CellValue(Row, "teus") != "" || sheetObj.CellValue(Row, "ft20") != ""
				|| sheetObj.CellValue(Row, "ft40") != "" || sheetObj.CellValue(Row, "ft45") != "") {
			sheetObj.CellEditable(Row, Col) = false;
		} else {
			sheetObj.CellEditable(Row, Col) = true;
		}
	}
	if (sheetObj.ColSaveName(Col) == "teus") {
		if (sheetObj.CellValue(Row, "cont") != "" || sheetObj.CellValue(Row, "ft20") != ""
				|| sheetObj.CellValue(Row, "ft40") != "" || sheetObj.CellValue(Row, "ft45") != "") {
			sheetObj.CellEditable(Row, Col) = false;
		} else {
			sheetObj.CellEditable(Row, Col) = true;
		}
	}
}

/**
 * 값이 변경될때
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	with (sheetObj) {
		for (var i=1; i<RowCount + 1; i++)
		{
			if (CellValue(i, "ft20") != "" || CellValue(i, "ft40") != "" || CellValue(i, "ft45") != "") {
				CellEditable(i, "cont") = false;
				CellEditable(i, "teus") = false;
			}
			if (CellValue(i, "cont") != "") {
				CellEditable(i, "ft20") = false;
				CellEditable(i, "ft40") = false;
				CellEditable(i, "ft45") = false;
				CellEditable(i, "teus") = false;
			}
			if (CellValue(i, "teus") != "") {
				CellEditable(i, "ft20") = false;
				CellEditable(i, "ft40") = false;
				CellEditable(i, "ft45") = false;
				CellEditable(i, "cont") = false;
			}
			if (CellValue(i, "ft20") == "" && CellValue(i, "ft40") == "" && CellValue(i, "ft45") == ""
				&& CellValue(i, "cont") == "" && CellValue(i, "teus") == "") {
				CellEditable(i, "ft20") = true;
				CellEditable(i, "ft40") = true;
				CellEditable(i, "ft45") = true;
				CellEditable(i, "cont") = true;
				CellEditable(i, "teus") = true;
			}
		}
	}
}

/**
 * 더블클릭 시
 * @param sheetObj
 * @param Row
 * @param Col
 * @param CellX
 * @param CellY
 * @param CellW
 * @param CellH
 * @return
 */
function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
	sheet1_OnKeyDown(sheetObj, Row, Col, 0, 0);
}

/**
 * Bound 변경시 발생
 */
function obj_Change() {
	if (window.event.srcElement.getAttribute("name") == "bound") {
		doActionIBSheet(sheetObjects[0], document.form, SEARCH);
	}
}