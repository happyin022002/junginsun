/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1023.js
 *@FileTitle : Vessel Stowage Plan Transmit
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.13  
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.08.13  김도완
 * 1.0 Creation
 * -------------------------------------------------------
 * History
 * 2011.10.13 김봉균 [CHM-201112452-01] 미세관 RECEIVE 데이터 중 CUSRES 반영 요청
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
 * @class ESM_BKG-1023 : ESM_BKG-1023 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1023() {
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
var intervalId = "";

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

		case "btn_Retrieve":
			doActionIBSheet(sheetObject, document.form, IBSEARCH);
			break;

		case "btn_New":
			sheetObject.RemoveAll();
			
			//US AMS Main Menu : VVD 입력시
			ComClearManyObjects(document.form.vvd,"");
			ComClearManyObjects(document.form.pol,"");
			ComClearManyObjects(document.form.pod,"");
			
			formObject.reset();
			break;

		case "btn_DownExcel":
			doActionIBSheet(sheetObject, document.form, IBDOWNEXCEL);
			break;

		case "btn_Transmit":
			doActionIBSheet(sheetObjects[0], document.form, MULTI);
			break;

		case "btn_AmsReport":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
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
	initControl();
	checkFromSearch(); //2011.06.20 add 김봉균
	
	//US AMS Main Menu : VVD 입력시
	/*if (!ComIsNull(document.form.vvd))
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);*/
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
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
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	
	//CA 인경우
	var customs = formObject.customs.value;
	if ( customs == "CA") {
		ComSetDisplay("td_AmsReport",false);
		ComSetDisplay("excludeca",false);
		ComSetDisplay("excludeca_text",false);
		
	}
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
			style.height = 370;
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

			var HeadTitle1 = "|Sel.|Seq.|Container No.|Container\nOperator|L.POL|POL|POD|TP/SZ|Cargo Type|Stow\nPosition|IMO Class"
					+ "|UN No.|Sent Time|Customs Result|Original\nPOD|vsl_eng_nm|vsl_voy|crr_cd|tmp1|tmp2|search_vvd_cd|excludeca";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,
			// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, false, "chk", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, false, "seq");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cntr_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "opr_cd", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "l_pol", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "pol", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "pod", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "sztp", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "fe", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "sti_pos", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "imdg", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "unno", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false, "sent_time", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cust_result", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "o_pod", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "vsl_eng_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "vsl_voy", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "crr_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "tmp1", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "tmp2", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "search_vvd_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "excludeca", false, "", dfNone, 0, false, false);

			WaitImageVisible = false;

		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회

		if (!validateForm(sheetObj, formObj, sAction))
			return;
		formObj.f_cmd.value = SEARCH;

		ComOpenWait(true);
		var sXml = sheetObj.GetSearchXml("ESM_BKG_1023GS.do", FormQueryString(formObj));
		sheetObj.LoadSearchXml(sXml);
		ComOpenWait(false);

		break;

	case MULTI: //Transmit
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		formObj.f_cmd.value = MULTI;

		ComOpenWait(true, true);

		var sParam = ComGetSaveString(sheetObj) + "&" + FormQueryString(formObj);
		var sXml = sheetObj.GetSaveXml("ESM_BKG_1023GS.do", sParam);
		var key = ComGetEtcData(sXml, "KEY");
		intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
		break;
	case IBDOWNEXCEL:
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		sheetObjects[0].SpeedDown2Excel(-1);
		break;

	case IBSEARCH_ASYNC01: //Go to AMS Report
		if (!validateForm(sheetObj, formObj, sAction)) {
			return;
		}	
		var param = "?pgmNo=ESM_BKG_0041&eventFrom=fromBapLieScreen&vvd=" + formObj.vvd.value + "&lastPol=" + formObj.lastpol.value;
		ComOpenWindowCenter("ESM_BKG_0041.do" + param, "ESM_BKG_0041", 1024, 660, true);
		break;		
	}
}

/**
 * BackEndJob 실행결과조회.
 */
function doActionValidationResult(sheetObj, sKey) {
	var sXml = sheetObj.GetSearchXml("ESM_BKG_1023GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
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

	case IBSEARCH_ASYNC01: //Go to AMS Report
		if (formObj.vvd.value == "" || formObj.vvd.value.length != 9) {
			ComShowCodeMessage("BKG00445", "VVD"); // "Please input {?msg1}."
			return false;
		}
		if (formObj.lastpol.value == "") {
			ComShowCodeMessage("BKG00445", "Last Foreign POL"); // "Please input {?msg1}."
			return false;
		}
		break;
		
	}
	return true;
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var sml = 0;
	var cos = 0;
	var kkl = 0;
	var yml = 0;
	var other = 0;
	var sheetMaxRow = 0;
	var form = document.form;

	with (sheetObj) {
		sheetMaxRow = RowCount;
		if (sheetMaxRow > 0) {
			document.form.vsl_eng_nm.value = CellValue(1, "vsl_eng_nm");
			document.form.vsl_voy.value = CellValue(1, "vsl_voy");
			document.form.crr_cd.value = CellValue(1, "crr_cd");
			var opr_cd = "";

			for ( var i = 1; i <= sheetMaxRow; i++) {
				opr_cd = CellValue(i, "opr_cd");
				if (opr_cd == "SML")
					sml++;
				else if (opr_cd == "COS")
					cos++;
				else if (opr_cd == "KKL")
					kkl++;
				else if (opr_cd == "YML")
					yml++;
				else
					other++;

				if (CellValue(i, "pod") != CellValue(i, "o_pod")) {
					RowBackColor(i) = RgbColor(255, 255, 0);
				} else if (CellValue(i, "tmp1") != CellValue(i, "tmp2")) { // del_cd 비교
					RowBackColor(i) = RgbColor(255, 255, 0);
				}
			}

			form.sml.value = ComAddComma(sml);
			form.cos.value = ComAddComma(cos);
			form.kkl.value = ComAddComma(kkl);
			form.yml.value = ComAddComma(yml);
			form.other.value = ComAddComma(other);
			form.tot.value = ComAddComma(sheetMaxRow);
		} else {
			form.vsl_eng_nm.value = "";
			form.vsl_voy.value = "";
			form.crr_cd.value = "";

			form.sml.value = "";
			form.cos.value = "";
			form.kkl.value = "";
			form.yml.value = "";
			form.other.value = "";
			form.tot.value = "";
		}
	}
}

/**
 * ESM_BKG_1122의 Go to BAPLIE버튼 클릭 이벤트 대응 2011.06.20 add
 * 버튼 클릭시 vvd와 last foreign pol을 인자로 받아 조회 처리
 */
function checkFromSearch() {
	var reqParam = window.location.search.substr(1); 
	var fCmd = reqParam.split("&")[0].split("=")[1];
	if (SEARCH10 == fCmd) {
		formObj = document.form;
		formObj.vvd.value = reqParam.split("&")[1].split("=")[1];
		formObj.lastpol.value = reqParam.split("&")[2].split("=")[1];
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}