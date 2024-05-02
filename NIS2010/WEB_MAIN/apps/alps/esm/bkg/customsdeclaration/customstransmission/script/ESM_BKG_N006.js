/*=========================================================
 *Copyright(c) 2017 SMLines
 *@FileName : ESM_BKG_N006.js
 *@FileTitle : Canada Export: Receiving History
 *Open Issues :
 *Change history :
 *@LastVersion : 1.0
 * 
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
function ESM_BKG_N006() {
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

/* 개발자 작업	*/

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
			doActionIBSheet(sheetObject, formObject, SEARCH);
			break;
		case "btn_new":
			doActionIBSheet(sheetObject, formObject, INIT);
			break;
		case "btn_downexcel":
			sheetObject.SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
			break;
		case "btn_viewReceiveFile":
			if (validateForm(sheetObject, formObject, COMMAND01)) {
				var row = sheetObject.SelectRow;
				var cnt_cd = sheetObject.CellValue(row, "cnt_cd");
				var io_bnd_cd = sheetObject.CellValue(row, "io_bnd_cd");
				var dtl_rcv_dt = sheetObject.CellValue(row, "dtl_rcv_dt");
				var rcv_seq = sheetObject.CellValue(row, "rcv_seq");
				ComOpenWindowCenter("/hanjin/ESM_BKG_0434.do" + "?pgmNo=ESM_BKG_0434&cnt_cd=" + cnt_cd + "&io_bnd_cd=" + io_bnd_cd + "&rcv_dt=" + dtl_rcv_dt
						+ "&rcv_seq=" + rcv_seq, "0434", 500, 380, true);
			}
			break;
		case "btn_viewMsg":
			if (validateForm(sheetObject, formObject, COMMAND01)) {
				sheet1_OnDblClick(sheetObject, sheetObject.SelectRow, 0);
			}
			break;
		case "btn_calendar":
			var cal = new ComCalendarFromTo();
			cal.select(formObject.s_rcv_dt, formObject.e_rcv_dt, 'yyyy-MM-dd');
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
 * @param sAction 작업처리코드
 */
function loadPage(sAction) {

	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
		sheetObjects[i].WaitImageVisible = false;
	}
	if (SEARCH == sAction) {
		doActionIBSheet(sheetObjects[0], document.form, SEARCH);
	} else {
		doActionIBSheet(sheetObjects[0], document.form, INIT);
	}
	document.form.vvd_cd.focus();
	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
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
			style.height = 380;
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
			InitRowInfo(2, 1, 4, 100);

			var HeadTitle1 = "|Seq.|MSG|Receive Date|RCV SEQ|VVD|POL|POD|B/L No|Status|Status|Reason|||||||||";
			var HeadTitle2 = "|Seq.|MSG|Receive Date|RCV SEQ|VVD|POL|POD|B/L No|Ack.|Result|Reason";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "hdnStatus");
			InitDataProperty(0, cnt++, dtDataSeq, 50, daCenter,true, "SEQ");
			InitDataProperty(0, cnt++, dtData, 70, daCenter,   true, "rcv_msg_tp_id",          false, "", dfNone, 0, true, true); 
			InitDataProperty(0, cnt++, dtData, 150, daCenter,  true, "rcv_dt",                 false, "", dfNone, 0, true, true); 
//			InitDataProperty(0, cnt++, dtData, 70, daCenter,   true, "rcv_hm",                  false, "", dfNone, 0, true, true); 
			InitDataProperty(0, cnt++, dtData, 80, daCenter,   true, "rcv_seq",                false, "", dfNone, 0, true, true); 
			InitDataProperty(0, cnt++, dtData, 110, daCenter,  true, "vvd_cd",                 false, "", dfNone, 0, true, true); 
			InitDataProperty(0, cnt++, dtData, 70, daCenter,   true, "pol_cd",                 false, "", dfNone, 0, true, true); 
			InitDataProperty(0, cnt++, dtData, 70, daCenter,   true, "pod_cd",                 false, "", dfNone, 0, true, true); 
			InitDataProperty(0, cnt++, dtData, 110, daCenter,  true, "bl_no",                  false, "", dfNone, 0, true, true); 
			InitDataProperty(0, cnt++, dtData, 50, daCenter,   true, "cnd_ack_rcv_id",         false, "", dfNone, 0, true, true); 
			InitDataProperty(0, cnt++, dtData, 50, daCenter,   true, "cnd_ack_sub_cd",         false, "", dfNone, 0, true, true); 
			InitDataProperty(0, cnt++, dtData, 70, daCenter,   true, "cstms_rjct_msg",         false, "", dfNone, 0, true, true); 
			// HIDDEN									                                      
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "ack_desc",               false, "", dfNone, 0, true, true); 
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "result_desc",            false, "", dfNone, 0, true, true); 
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "cnd_ack_err_note_desc",  false, "", dfNone, 0, true, true); 
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "err_cd_desc",            false, "", dfNone, 0, true, true); 
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "err_tp_ctnt",            false, "", dfNone, 0, true, true); 
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "cnt_cd",                 false, "", dfNone, 0, true, true); 
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "io_bnd_cd",              false, "", dfNone, 0, true, true); 
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "dtl_rcv_dt",             false, "", dfNone, 0, true, true); 
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "rcv_seq",                false, "", dfNone, 0, true, true); 
			sheetObj.DataLinkMouse("cnd_ack_rcv_id") = true;
			sheetObj.DataLinkMouse("cnd_ack_sub_cd") = true;
			sheetObj.DataLinkMouse("cstms_rjct_msg") = true;
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
			formObj.reset();
			initSheet(sheetObj, 1)
			formObj.s_rcv_dt.value = ComGetDateAdd(null, 'd', -12, '-');
			formObj.e_rcv_dt.value = ComGetNowInfo('ymd', '-');
		}
		break;
	case SEARCH: //Retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESM_BKG_N006GS.do", FormQueryString(formObj));
			for ( var i = 2; i <= sheetObj.RowCount + 1; i++) {
				sheetObj.CellFontColor(i, "cnd_ack_rcv_id") = sheetObj.RgbColor(0, 0, 255);
				sheetObj.CellFontUnderline(i, "cnd_ack_rcv_id") = true;
				sheetObj.CellFontColor(i, "cnd_ack_sub_cd") = sheetObj.RgbColor(0, 0, 255);
				sheetObj.CellFontUnderline(i, "cnd_ack_sub_cd") = true;
				sheetObj.CellFontColor(i, "cstms_rjct_msg") = sheetObj.RgbColor(0, 0, 255);
				sheetObj.CellFontUnderline(i, "cstms_rjct_msg") = true;
				if (sheetObj.CellValue(i, "cnd_ack_sub_cd") == "37" || sheetObj.CellValue(i, "cnd_ack_sub_cd") == "21") {
					sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);
				} else if (sheetObj.CellValue(i, "cnd_ack_sub_cd") == "01") {
					sheetObj.RowFontColor(i) = sheetObj.RgbColor(0, 0, 255);
				}
			}
			ComOpenWait(false);
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
		//기본포멧체크
		if (!ComChkValid(formObj))
			return false;

		if (formObj.rcv_dt_flg.checked) {
			if (ComIsNull(formObj.s_rcv_dt) || ComIsNull(formObj.s_rcv_tm) ||
				ComIsNull(formObj.e_rcv_dt) || ComIsNull(formObj.s_rcv_tm)) {
				ComShowCodeMessage('BKG00626', 'Receive Date & Receive Time');
				return false;
			}
			if (formObj.s_rcv_dt.value + formObj.s_rcv_tm.value > formObj.e_rcv_dt.value + formObj.e_rcv_tm.value) {
				ComShowMessage('Receive Date is invalid');
				return false;
			}
			var diffDate = ComGetDaysBetween(formObj.s_rcv_dt, formObj.e_rcv_dt);
			var year = formObj.s_rcv_dt.value.substring(0, 4);
			var month = formObj.s_rcv_dt.value.substring(5, 7);
			var lastDay = ComGetLastDay(year, parseInt(month, 10));
			if (diffDate + 1 > lastDay) {
				ComShowCodeMessage('BKG01080');
				formObj.e_rcv_dt.select();
				return false;
			}
		}
		if (ComIsNull(formObj.bl_no) && ComIsNull(formObj.vvd_cd) && !formObj.rcv_dt_flg.checked) {
			ComShowCodeMessage('BKG00626', 'VVD or Receive Date');
			ComSetFocus(form.vvd_cd)
			return false;
		}
		break;

	case COMMAND01:
		if (sheetObj.RowCount <= 0) {
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
	 var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	 var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

/**
 * 마우스가 Sheet 위에서 움직일 때 발생하는 Event
 * @param sheetObj 시트오브젝트
 * @param Button 마우스버튼 방향
 * @param Shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 * @param X X 좌표
 * @param Y Y 좌표
 */
function sheet1_OnMouseMove(Button, Shift, X, Y) {
	var sheetObj = sheetObjects[0];
	var row = sheetObj.MouseRow;
	var col = sheetObj.MouseCol;
	if (row > 0) {
		if (sheetObj.ColSaveName(col) == "cnd_ack_rcv_id") {
			sheetObj.ToolTipText(row, col) = sheetObj.CellText(row, "ack_desc");
		} else if (sheetObj.ColSaveName(col) == "cnd_ack_sub_cd") {
			sheetObj.ToolTipText(row, col) = sheetObj.CellText(row, "result_desc");
		} else if (sheetObj.ColSaveName(col) == "cstms_rjct_msg") {
			sheetObj.ToolTipText(row, col) = sheetObj.CellText(row, "err_cd_desc");
		}
	}
}

/**
 * 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event
 * @param sheetObj 시트오브젝트
 * @param row row Index
 * @param col col Index
 */
function sheet1_OnDblClick(sheetObj, row, col) {
	var p1 = sheetObj.CellValue(row, "cnd_ack_rcv_id");
	var p2 = sheetObj.CellValue(row, "ack_desc");
	var p3 = sheetObj.CellValue(row, "cnd_ack_sub_cd");
	var p4 = sheetObj.CellValue(row, "result_desc");
	var p5 = sheetObj.CellValue(row, "cnd_ack_err_note_desc");
	var p6 = sheetObj.CellValue(row, "cstms_rjct_msg");
	var p7 = sheetObj.CellValue(row, "err_cd_desc");
	var p8 = sheetObj.CellValue(row, "err_tp_ctnt");
	var rcv_dt = sheetObj.CellValue(row, "dtl_rcv_dt");
	var rcv_seq = sheetObj.CellValue(row, "rcv_seq");

	var p9 = "";
	var p10 = "";
	var p11 = sheetObj.CellValue(row, "cnd_ack_sub_cd");	
	if ("BRC" == sheetObj.CellValue(row, "rcv_msg_tp_id") ) {
		if ( "R" == p1 ) {
			p9 = p3;
			p10 = p4;
		} else {	
			p9 = p1;
			p10 = p2;
		}
		p1 = "";
		p2 = "";
		p3 = "";
		p4 = "";
	}
	
		
	ComOpenWindowCenter("/hanjin/ESM_BKG_0433.do?pgmNo=ESM_BKG_0433&p1=" + p1 + "&p2=" + p2 + "&p3=" + p3 + "&p4=" + p4 + "&p5=" + p5 + "&p6=" + p6 + "&p7="
			+ p7 + "&p8=" + p8 + "&rcv_dt=" + rcv_dt + "&rcv_seq=" + rcv_seq + "&p9=" + p9 + "&p10=" + p10, "04331", 520, 450, true);
}