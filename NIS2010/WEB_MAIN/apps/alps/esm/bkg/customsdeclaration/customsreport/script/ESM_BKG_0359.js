/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0359.js
 *@FileTitle : Transmission Status Cross Check
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.30  
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.07.30 김도완
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
 * @class ESM_BKG-0359 : ESM_BKG-0359 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0359() {
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
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, document.form, IBSEARCH);
			break;

		case "btn_BL_Inquiry":
			doActionIBSheet(sheetObject1, document.form, SEARCH13);
			break;

		case "btn_Downexcel":
			doActionIBSheet(sheetObject1, document.form, IBDOWNEXCEL);
			break;
		case "btn_Print1":
			if (sheetObject1.RowCount == 0) {
				ComShowCodeMessage("BKG00889");
				return;
			}
			ComOpenWindowCenter("/hanjin/ESM_BKG_0869.do?pgmNo=ESM_BKG_0869", "0869", 1024, 690, false);
			break;
		case "btn_Print2":
			if (sheetObject2.RowCount == 0) {
				ComShowCodeMessage("BKG00889");
				return;
			}
			ComOpenWindowCenter("/hanjin/ESM_BKG_5009.do?pgmNo=ESM_BKG_5009", "5009", 1024, 690, false);
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
	for ( var k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}

	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);

		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);

	}

	initControl();
	document.form.vvd.focus();
	
	//US AMS Main Menu : VVD 입력시
	if (!ComIsNull(document.form.vvd))
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			
	clientTimeSet();	
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
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";

	var formObject = document.form;
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); // - 키보드 입력할때
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListener('click', 'chkClick', 'form');
	axon_event.addListenerForm('change', 'chkChange2', formObject);
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetObj.id) {
	case "sheet1": //sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 322;
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
			InitRowInfo(2, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = "Seq.|Manifest File No.|M/H|Filer|M.B/L No.|B.POL|T.POL|T.POD|T.VVD|STS|VSL EDI|B/L EDI|B/L EDI|B/L EDI|Current Stage/Update|Current Stage/Update|B.OFC|CNTR No|MF STS|User Action|";
			var HeadTitle2 = "Seq.|Manifest File No.|M/H|Filer|M.B/L No.|B.POL|T.POL|T.POD|T.VVD|STS|VSL EDI|Sent|VVD|Sent Time(EST)| | |B.OFC|CNTR No|MF STS|User Action|";
			var headCount = ComCountHeadTitle(HeadTitle2);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,
			// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

			InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "seq");
			InitDataProperty(0, cnt++, dtData, 105, daCenterTop, true, "ams_file_no", false, "", dfNone, 0, false, false, -1,
					false);
			InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "m_f", false, "", dfNone, 0, false, false, -1, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "filer", false, "", dfNone, 0, false, false, -1, false);

			InitDataProperty(0, cnt++, dtData, 109, daCenterTop, true, "mbl_no", false, "", dfNone, 0, false, false, -1, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenterTop, true, "o_pol", false, "", dfNone, 0, false, false, -1, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenterTop, true, "t_pol", false, "", dfNone, 0, false, false, -1, false);
			InitDataProperty(0, cnt++, dtData, 55, daCenterTop, true, "t_pod", false, "", dfNone, 0, false, false, -1, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenterTop, true, "t_vvd", false, "", dfNone, 0, false, false, -1, false);

			InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "sts", false, "", dfNone, 0, false, false, -1, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenterTop, true, "v_mi", false, "", dfNone, 0, false, false, -1, false);
			InitDataProperty(0, cnt++, dtData, 35, daCenterTop, true, "mi", false, "", dfNone, 0, false, false, -1, false);
			InitDataProperty(0, cnt++, dtData, 85, daCenterTop, true, "vvd", false, "", dfNone, 0, false, false, -1, false);
			InitDataProperty(0, cnt++, dtData, 120, daCenterTop, true, "sent_time", false, "", dfNone, 0, false, false, -1, false);

			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "curr_stage", false, "", dfNone, 0, false, false, -1, false);
			InitDataProperty(0, cnt++, dtData, 140, daCenterTop, true, "update_dt", false, "", dfNone, 0, false, false, -1, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenterTop, true, "b_ofc", false, "", dfNone, 0, false, false, -1, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenterTop, true, "cntr_no", false, "", dfNone, 0, false, false, -1, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "mf_sts", false, "", dfNone, 0, false, false, -1, false);

			InitDataProperty(0, cnt++, dtData, 60, daCenterTop, true, "user_action", false, "", dfNone, 0, false, false, -1,
					false);
			InitDataProperty(0, cnt++, dtHiddenStatus, 130, daCenterTop, false, "ibflag");

			CountPosition = 0;
		}
		break;

	case "sheet2": //sheet2 init
		with (sheetObj) {

			// 높이 설정
			style.height = 360;
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
			InitRowInfo(2, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = "AMS Filing Status|AMS Filing Status|AMS Filing Status|AMS Filing Status|AMS Filing Status|AMS Filing Status|AMS Filing Status|AMS Filing Status|AMS Filing Status|AMS Filing Status|AMS Filing Status|AMS Filing Status|Current Booking Status|Current Booking Status|Current Booking Status|Current Booking Status|User Action|";
			var HeadTitle2 = "Seq.|Manifest File No.|M/H|Filer|M.B/L No.|T.VVD|B.POL|T.POL|T.POD|C.STS|Current Stage/Update|Current Stage/Update|STS|T.VVD|T.POL|Filer|User Action|";
			var headCount = ComCountHeadTitle(HeadTitle2);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,
			// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			cnt = 0;
			var prefix = "";
			InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, true, prefix + "Seq");
			InitDataProperty(0, cnt++, dtData, 105, daCenter, true, prefix + "ams_file_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, prefix + "m_f", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, prefix + "filer", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 109, daCenter, true, prefix + "mbl_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, prefix + "t_vvd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, prefix + "o_pol", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, prefix + "t_pol", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 55, daCenter, true, prefix + "t_pod", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, prefix + "mf_sts", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, prefix + "curr_stage", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 140, daCenter, true, prefix + "update_dt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, prefix + "sts", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, prefix + "t_vvd2", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, prefix + "t_pol2", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, prefix + "filer2", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, prefix + "user_action", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHiddenStatus, 130, daCenterTop, false, prefix + "ibflag");

		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;

	switch (sAction) {

	case IBSEARCH: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0359GS.do", FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");

		if (arrXml.length > 0)
			sheetObjects[0].LoadSearchXml(arrXml[0]);
		if (arrXml.length > 1) {
			sheetObjects[1].LoadSearchXml(arrXml[1]);

		}
		clientTimeSet();
		ComOpenWait(false);
		break;

	case SEARCH02: //ETA 조회.

		if (!validateForm(sheetObj, formObj, sAction))
			return;

		ComOpenWait(true);
		formObj.f_cmd.value = INIT;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0359GS.do", FormQueryString(formObj));
		var eta = ComGetEtcData(sXml, "eta");
		formObj.eta.value = eta;
		clientTimeSet();
		ComOpenWait(false);
		ComSetFocus(formObj.pod);
		break;

	case IBINSERT: // 입력

		break;

	case IBDOWNEXCEL: // 엑셀다운로드

		if (!validateForm(sheetObj, formObj, sAction))
			return;
		ComOpenWait(true);
		if (sheetObjects[0].RowCount > 0) {
			sheetObjects[0].SpeedDown2Excel(-1);
		}
		if (sheetObjects[1].RowCount > 0) {
			sheetObjects[1].SpeedDown2Excel(-1);
		}
		clientTimeSet();
		ComOpenWait(false);
		break;

	case SEARCH13: //btn_BL_Inquiry
		var selTab = document.tab1.SelectedIndex;
		var sheetObject2 = sheetObjects[selTab];

		if (sheetObject2.SelectRow == -1) {
			ComShowMessage(ComGetMsg("BKG01002"));
			return;
		}
		var bl_no = sheetObject2.CellValue(sheetObject2.SelectRow, "ams_file_no");
		var param = "bl_no=" + bl_no;

		ComOpenWindowCenter("ESM_BKG_0034.do?pgmNo=ESM_BKG_0034-01&" + param, "ESM_BKG_0034", 1024, 660, true);
		break;

	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		if (!ComChkRequired(formObj))
			return false;
		break;
	case IBDOWNEXCEL:

		if (sheetObjects[0].RowCount == 0 && sheetObjects[1].RowCount == 0) {

			ComShowCodeMessage("BKG00889"); // No data found
			return false;
		}
		break;
	}
	return true;
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	with (tabObj) {
		var cnt = 0;
		InsertTab(cnt++, "Manifest Status", -1);
		InsertTab(cnt++, "B/L to be deleted", -1);
	}
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {
	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	beforetab = nItem;
}

/**
 * change이벤트 발생시, VVD, POL 필드가 대상이 되었다면, ETA 조회실행.
 * 
 */
function chkChange2() {
	var srcName = event.srcElement.getAttribute("name");

	if (srcName == "vvd" || srcName == "pol") {

		if (document.form.vvd.value.length == 9 && document.form.pol.value.length == 5) {

			doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
		} else {
			form.eta.value = "";
			if (document.form.vvd.value.length != 9) {
				ComShowCodeMessage('BKG00007');
				return;
			}
			if (srcName == "pol" && document.form.pol.value.length != 5) {
				ComShowCodeMessage('BKG00288');
				return;
			}
			if (srcName == "vvd" && document.form.pol.value == "") {
				document.form.pol.focus();
			}
		}
	}
}

/**
 * sheet1 조회 후 처리
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var sentByMi = 0;
	var addedByAi = 0;
	var unManifest = 0;
	var ManifestTtl = 0;
	var targetTtl = 0;

	var mf_sts = "";
	var seq = "";
	var preSeq = "";
	with (sheetObj) {

		for ( var i = 2; i <= LastRow; i++) {
			if (CellValue(i, "t_vvd") != CellValue(i, "vvd"))
				CellFontColor(i, "vvd") = RgbColor(255, 0, 0); // 글자는 붉은색
			if (CellValue(i, "m_f") == "H") {
				CellFontColor(i, "ams_file_no") = RgbColor(0, 0, 255); // 글자는 파란색

			}
			mf_sts = CellValue(i, "mf_sts");
			seq = CellValue(i, "seq");
			if (seq != preSeq) {
				if (mf_sts == "Sent By MI") {
					sentByMi++;
					ManifestTtl++;

				} else if (mf_sts == "Added By AI") {
					addedByAi++;
					ManifestTtl++;

				} else if (mf_sts == "Un-Manifested") {
					unManifest++;

				}
				targetTtl++;
			}
			preSeq = seq;
		}

		document.form.manifestTotal.value = " Manifest TTL [" + ManifestTtl + "]";
		document.form.sentByMiCount.value = " Sent by MI [" + sentByMi + "]";
		document.form.addedByAiCount.value = " Added by AI [" + addedByAi + "]";
		document.form.targetTotal.value = " Target   TTL [" + CellValue(LastRow, "seq") + "]";
		document.form.unManifestCount.value = " Un-Manifest [" + unManifest + "]";
	}
}

/**
 * sheet2 조회 후 처리
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		for ( var i = 2; i <= LastRow; i++) {
			if (CellValue(i, "t_vvd") != CellValue(i, "t_vvd2"))
				CellFontColor(i, "t_vvd2") = RgbColor(255, 0, 0); // 글자는 붉은색
			if (CellValue(i, "t_pol") != CellValue(i, "t_pol2"))
				CellFontColor(i, "t_vvd2") = RgbColor(255, 0, 0); // 글자는 붉은색
			if (CellValue(i, "filer") != CellValue(i, "filer2"))
				CellFontColor(i, "filer2") = RgbColor(255, 0, 0); // 글자는 붉은색

			if (CellValue(i, "m_f") == "H") {
				CellFontColor(i, "ams_file_no") = RgbColor(0, 0, 255); // 글자는 파란색
			}
		}
	}
}

/**
 * 현재 시간 표시
 */
function clientTimeSet() {
	var d = new Date();
	var dStr = formatDate(d, 'yyyyMMdd HH');
	form.runtime.value = dStr + "h";
}
/* 개발자 작업 끝 */