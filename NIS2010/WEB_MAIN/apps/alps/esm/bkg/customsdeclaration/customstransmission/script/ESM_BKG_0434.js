/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0434.js
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
function esm_bkg_0434() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.sheet1_OnClick = sheet1_OnClick;
	this.sheet1_OnMouseMove = sheet1_OnMouseMove;
}

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var docObjects = new Array();
var rdObjects = new Array();
var rdCnt = 0;

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
		case "btn_Excel":
			sheetObject.SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
			break;
		case "btn_Print":
			rdLoad();
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
	doActionIBSheet(sheetObjects[0], document.form, INIT);
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
			style.height = 222;
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
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "Seq.|msg_desc";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtDataSeq, 50, daCenter, false, "Seq");
			InitDataProperty(0, cnt++, dtData, 400, daLeft, false, "msg_desc", false, "", dfNone, 0, true, true);
			CountPosition = 0;
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
	case INIT: //init
		if (sheetObj.id == "sheet1") {
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESM_BKG_0434GS.do", FormQueryString(formObj));
		}
		break;
	}
}

/**
 * Report Open
 */
function rdLoad() {
	var sXml = "";
	var opener_sheet = window.dialogArguments.sheetObjects[0];
	var row = opener_sheet.SelectRow;
	var sheet_obj1 = document.sheet1;
	
	sXml = "<?xml version='1.0' ?><SHEET>";
	sXml += RD_GetDataSearchXml(sheet_obj1, 1);
	sXml += "<ETC>";
	sXml += "<MSG_TYPE>" + opener_sheet.CellValue(row, "rcv_msg_tp_id") + "</MSG_TYPE>"
	sXml += "<VVD>" + opener_sheet.CellValue(row, "vvd_cd") + "</VVD>"
	sXml += "<POL>" + opener_sheet.CellValue(row, "pol_cd") + "</POL>"
	sXml += "<POD>" + opener_sheet.CellValue(row, "pod_cd") + "</POD>"
	sXml += "<BLNO>" + opener_sheet.CellValue(row, "bl_no") + "</BLNO>"
	sXml += "<RCV_SEQ>" + opener_sheet.CellValue(row, "rcv_seq") + "</RCV_SEQ>"
	sXml += "<RCV_DATE>" + opener_sheet.CellValue(row, "rcv_dt") + "</RCV_DATE>"
	sXml += "<RCV_TIME>" + opener_sheet.CellValue(row, "rcv_hm") + "</RCV_TIME>"
	sXml += "</ETC>";
	sXml += "</SHEET>";

	rdObjects[0].AutoAdjust = true;
	rdObjects[0].HideToolbar();
	rdObjects[0].HideStatusbar();
	rdObjects[0].ViewShowMode(0);

	rdObjects[0].setbackgroundcolor(128, 128, 128);
	rdObjects[0].SetPageLineColor(128, 128, 128);

	rdObjects[0].SetRData(sXml);
	rdObjects[0].FileOpen(RD_path + 'apps/alps/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_0875.mrd', RDServer);
	rdObjects[0].PrintDialog();
}