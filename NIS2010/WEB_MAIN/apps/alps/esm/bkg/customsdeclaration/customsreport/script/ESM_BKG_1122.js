/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : ESM_BKG_1122.js
 *@FileTitle : US AMS : BAPLIE Monitoring Report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.06.20
 *@LastModifier : 김봉균
 *@LastVersion : 1.0
 * 2011.06.20 김봉균
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview US AMS : BAPLIE Monitoring Report 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends
 * @class US AMS : BAPLIE Monitoring Report 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_1122() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* 개발자 작업 	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_calendar":
			var cal = new ComCalendarFromTo();
			cal.select(formObject.due_from_dt, formObject.due_to_dt, 'yyyy-MM-dd');
			break;

		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;

		case "btn_new":
			doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
			break;

		case "btn_downExcel":
			doActionIBSheet(sheetObjects[0], formObject, IBDOWNEXCEL);
			break;

		case "btn_baplie":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC01);
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
		//시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		//시트 초기설정값, 헤더 정의
		initSheet(sheetObjects[i], i + 1);
		//마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	document.form.lane.focus(); 
	initControl();
}

function initControl() {
	var formObject = document.form;
	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("blur", "obj_deactivate", formObject);
	axon_event.addListenerForm("click", "obj_click", formObject);
	axon_event.addListenerFormat("keypress", "obj_KeyPress", formObject);
	axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
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

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=1000]
			InitRowInfo(1, 1, 4, 10);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(14, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);
			ShowSortArrow = true;

			var HeadTitle1 = "|Seq.|LANE|VVD|RHQ|Last F.POL|CNTR Count|Customs Result|Send Sts|MI Sts|Sent time|Receiving date|ATD at Last F.POL|Due Date";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,
			// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 20, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, false, "Seq");
			InitDataProperty(0, cnt++, dtData, 35, daCenter, true, "lane", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 75, daCenter, false, "vvd", false, "", dfDateYmd, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rhq", false, "", dfTimeHms, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "l_pol", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "cntr_cnt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cstms_rslt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 55, daCenter, false, "snd_sts", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "mi_sts", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 105, daCenter, false, "snd_dt", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 105, daCenter, false, "rcv_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 105, daCenter, false, "atd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 105, daCenter, false, "due", false, "", dfNone, 0, true, true);

			CountFormat = "[SELECTDATAROW / TOTALROWS]";
		}
		break;
	}
}

/**
 * VVD입력란의 포커스가 나갈 때(Last Foreign Port 가 SML인가를 조회한다)
 */
function obj_deactivate() {
	//ComChkObjValid(event.srcElement);
	var srcName = window.event.srcElement.getAttribute("name");
	if (srcName == "vvd") {
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		if (formObj.vvd.value.length == '9') {
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_1122GS.do", FormQueryString(formObj));
			var crrCd = ComGetEtcData(sXml, "CRRCD");
			var lPol = ComGetEtcData(sXml, "LPOL");
			if ("SML" != crrCd) {
				ComShowMessage(msgs['BKG08191']); //"This is not a SML operating vessel. Please check again."
				return false;
			} else {
				ComSetObjValue(formObj.l_pol, lPol);
			}	
		}
	}
}

/**
 * 체크박스 클릭 시 처리
 */
function obj_click() {
	var formObject = document.form;
	var srcObj = window.event.srcElement;
	var srcName = srcObj.getAttribute("name");
	var srcVal = srcObj.checked;
	if (srcName == "gubun") {
		alterRequiredChk(srcVal);
	}
}

/**
 * 체크박스 상태에 따라 버튼 처리
 */
function alterRequiredChk(checked) {
	var formObject = document.form;
	if (checked) {
		formObject.vvd.className = "input"
		formObject.due_from_dt.disabled = false;
		formObject.due_to_dt.disabled = false;
		formObject.due_from_tm.disabled = false;
		formObject.due_to_tm.disabled = false;
		ComSetObjValue(formObject.due_from_dt, ComGetNowInfo());
		ComSetObjValue(formObject.due_to_dt, ComGetNowInfo());
	} else {
		formObject.vvd.className = "input1"
		formObject.due_from_dt.disabled = true;
		formObject.due_to_dt.disabled = true;
		formObject.due_from_tm.disabled = true;
		formObject.due_to_tm.disabled = true;
		ComSetObjValue(formObject.due_from_dt, '');
		ComSetObjValue(formObject.due_to_dt, '');
	}
}

//수직스크롤바가 바닥에 닿았을 때 발생하는 이벤트 Catch
function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
	doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;

	switch (sAction) {

	case IBSEARCH: //조회
		if (!validateForm(sheetObj, formObj, sAction)){
			return false;
		}
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("ESM_BKG_1122GS.do", FormQueryString(formObj));
		ComOpenWait(false);
		for ( var i = 1; i < sheetObj.RowCount+1; i++) {
			var cstmsRslt = sheetObj.CellValue(i, "cstms_rslt");
			if (!ComIsNull(cstmsRslt)){
				var rejCnt = cstmsRslt.split(":")[2].trim();
				if (rejCnt > 0) { //Rej의 수가 0보다 클 경우 적색으로 표시
					sheetObj.CellFontColor(i, "cstms_rslt") =  sheetObj.RgbColor(255, 0, 0);
				}
			}
		}
		sheetObj.SelectCell(0,0,false);
		break;

	case IBSEARCHAPPEND: // 페이징 조회
		if (!validateForm(sheetObj, formObj, sAction)){
			return false;
		}
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("ESM_BKG_1122GS.do", CondParam, "page_no=" + PageNo, true);
		ComOpenWait(false);
		break;

	case IBSEARCH_ASYNC01: //Go to BAPLIE
		if (!validateForm(sheetObj, formObj, sAction)){
			return false;
		}
		var selectRow = sheetObj.SelectRow;
		var vvd = sheetObj.CellValue(selectRow, "vvd");
		var l_pol = sheetObj.CellValue(selectRow, "l_pol");
        var pageno = formObj.pageno.value;
		var params = "&vvd="+vvd+"&l_pol="+l_pol+"&pgmNo="+pageno;
		formObj.f_cmd.value = SEARCH10;
		ComOpenWindowCenter("/hanjin/ESM_BKG_1023.do?f_cmd="+SEARCH10+params, "ESM_BKG_1023", 1020, 605, false);
		break;
		
	case IBDOWNEXCEL:      //Excel down
		sheetObj.SpeedDown2Excel(1);
		break;		

	case IBCLEAR: //조회조건 초기화
		formObj.reset();
		sheetObj.RemoveAll();
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */ 
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: //조회 Retrieve
		if (formObj.gubun.checked) {
			if( formObj.due_from_dt.value == "" ){
				ComShowCodeMessage( "BKG00626", "ATD(ETD) date"  ); //"Mandatory field is missing. Please enter {?msg1}."
				formObj.due_from_dt.focus();
				return false;
			}
			if( formObj.due_to_dt.value == "" ){
				ComShowCodeMessage( "BKG00626", "ATD(ETD) date"  ); //"Mandatory field is missing. Please enter {?msg1}."
				formObj.due_to_dt.focus();
				return false;
			}
			if(ComGetDaysBetween(formObj.due_from_dt, formObj.due_to_dt) < 0) {
				ComShowMessage(msgs['BKG00818']); //"From Date couldn't be greater than ToDate."
				return false;
			}
			if(ComGetDaysBetween(formObj.due_from_dt, formObj.due_to_dt) >= 31) {
				ComShowMessage(msgs['BKG50469']); //"Can't Input Date Over 31 days!"
				return false;
			}
		} else {
			if(formObj.vvd.value == ""){
				ComShowCodeMessage( "BKG00626", "VVD"  ); //"Mandatory field is missing. Please enter {?msg1}."
				formObj.vvd.focus();
				return false;
			}	
		}	
		break;
		
	case IBSEARCH_ASYNC01: //Go to BAPLIE
		if (sheetObj.RowCount == 0) {
			ComShowMessage(msgs['BKG01093']); //"Please select row first."
			return false;
		}
		break;
	}
	return true;
}

/* 개발자 작업  끝 */