/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0568.js
 *@FileTitle : C/A Report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.22
 *@LastModifier : 강동윤
 *@LastVersion : 1.0
 * 2009.09.22 강동윤
 * 1.0 Creation
 * 2012.03.26 변종건 [CHM-201216730] Split 07-RD 리포트 성능을 위한 개선 요청(PreparedStatement)
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
 * @class ESM_BKG_0568 : EBM_BKG_0568 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0568() {
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
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], document.form, INIT);
			break;

		case "btn_new":
			ComResetAll();
			
			//US AMS Main Menu : VVD 입력시
			ComClearManyObjects(document.form.vvd,"");
			ComClearManyObjects(document.form.pod_cd,"");
			
			break;

		case "btn_save":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;

		case "btn_excel":
			sheetObject.SpeedDown2Excel(-1);
			break;

		case "btn_CheckAll":
			checkAll("1");
			break;

		case "btn_UncheckAll":
			checkAll("0");
			break;

		case "btn_print":
			if (!validateForm(sheetObjects[0], document.form, IBSAVE))
				return;
			goPrint("1");
			break;

		case "btn_BLInquiry":
			pageLink("1");
			break;

		case "btn_CntrInquiry":
			pageLink("2");
			break;

		case "btn_UncheckAll2":
			alert(srcName);
			break;

		case "btn_DownExcel2":
			sheetObject1.SpeedDown2Excel(-1);
			break;

		case "btn_PrintPreview":
			alert(srcName);
			break;

		case "btn_print2":
			goPrint("2"); // 2010.04.22수정 >> 2010.04.23수정 원복
			break;

		case "btn_calendar":
			var cal = new ComCalendarFromTo();
			cal.select(formObject.from_date, formObject.to_date, 'yyyy-MM-dd');
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

	document.form.from_date.value = getCalculatedDate(0, 0, -7, "-");
	document.form.from_time.value = "00:00";
	document.form.to_date.value = getCalculatedDate(0, 0, 0, "-");
	document.form.to_time.value = "23:59";
	
	//US AMS Main Menu : VVD 입력시
	if (!ComIsNull(document.form.vvd)) {
		document.form.pk_tp[0].checked = false;
		document.form.pk_tp[1].checked = true;		
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	

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
	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObject); // - 포커스 나갈때
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', formObject); // - 포커스 들어갈때
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // - 키보드 입력할때

	axon_event.addListener('keydown', 'ComKeyEnter', 'form');// Enter key 처리
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
}

/**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 **/
function obj_keypress() {
	switch (event.srcElement.dataformat) {
	case "int":
		//숫자만입력하기
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "float":
		//숫자+"."입력하기
		ComKeyOnlyNumber(event.srcElement, ".");
		break;
	case "eng":
		//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
		ComKeyOnlyAlphabet();
		break;
	case "engdn":
		//영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
		ComKeyOnlyAlphabet('lower');
		break;
	case "engup":
		//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('upper');
		break;
	case "engupnum":
		//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('uppernum');
		break;
	default:
		//숫자만입력하기(정수,날짜,시간)
		ComKeyOnlyNumber(event.srcElement);
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

	case "sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 200;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "CHK|Seq.|B/L No.|Filer|BKG No.|ETA Date|C/A No.|C/A Date|C/A OFC|Reason|Reason|KIND|KIND|KIND|KIND|KIND|KIND|KIND|KIND|KIND|KIND|KIND|Remark(s)|vvd|pll_cd|pod_cd|bl_tp_cd|chk_tp|ibflag";
			var HeadTitle2 = "CHK|Seq.|B/L No.|Filer|BKG No.|ETA Date|C/A No.|C/A Date|C/A OFC|Code|Name|A|B|C|D|E|F|G|H|I|J|K|Remark(s)|vvd|pll_cd|pod_cd|bl_tp_cd|chk_tp|ibflag";
			var headCount = ComCountHeadTitle(HeadTitle1);
			//alert(headCount);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, false);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,
			// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "Chk");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "Seq", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bl_no", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "NV", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bkg_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, false, "vps_eta_dt", false, "", dfNone, 0, false, true);
			
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "corr_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, false, "corr_dt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "CAOFC", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "Reason1", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 130, daLeft, false, "Reason2", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "KIND_A", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "KIND_B", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "KIND_C", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "KIND_D", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "KIND_E", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "KIND_F", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "KIND_G", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "KIND_H", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "KIND_I", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "KIND_J", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "KIND_K", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "bkg_corr_rmk", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "vvd");
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "pol_cd");
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "pod_cd");
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "bl_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "chk_tp");
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");

			CountPosition = 0;

			SetMergeCell(0, 0, 2, 1);
			SetMergeCell(0, 1, 2, 1);
			SetMergeCell(0, 2, 2, 1);
			SetMergeCell(0, 3, 2, 1);
			SetMergeCell(0, 4, 2, 1);
			SetMergeCell(0, 5, 2, 1);
			SetMergeCell(0, 6, 2, 1);
			SetMergeCell(0, 7, 2, 1);
			SetMergeCell(0, 21, 2, 1);

		}
		break;

	case "sheet2":
		with (sheetObj) {

			// 높이 설정
			style.height = 180;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(4, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle1 = "|Correction Items|New|Old";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,
			// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtData, 320, daCenter, true, "his_cate_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 330, daCenter, true, "crnt_ctnt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 330, daCenter, true, "pre_ctnt", false, "", dfNone, 0, false, false);

		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case INIT: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		formObj.from_dt.value = formObj.from_date.value + " " + formObj.from_time.value;
		formObj.to_dt.value = formObj.to_date.value + " " + formObj.to_time.value;

		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);

		formObj.f_cmd.value = SEARCH;

		sheetObj.DoSearch("ESM_BKG_0568GS.do", FormQueryString(formObj));

		if (sheetObj.SearchRows > 0) {

			formObj.bl_no2.value = sheetObj.CellValue(3, "bl_no");
			formObj.bkg_no.value = sheetObj.CellValue(3, "bkg_no");				
			formObj.corr_no.value = sheetObj.CellValue(3, "corr_no");
			formObj.vvd2.value = sheetObj.CellValue(3, "vvd");
			formObj.pol.value = sheetObj.CellValue(3, "pol_cd");
			formObj.pod.value = sheetObj.CellValue(3, "pod_cd");

			doActionIBSheet(sheetObjects[1], document.form, COMMAND01);
		}

		break;

	case IBSAVE: // Save

		var chkFlg = false;

		var SaveStr = sheetObj.GetSaveString(false);

		if (SaveStr != "")
			chkFlg = true;

		if (chkFlg) {

			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);

			formObj.f_cmd.value = MULTI;

			var sParam = ComGetSaveString(sheetObj) + "&" + FormQueryString(formObj);

			var searchXml = sheetObj.GetSaveXml("ESM_BKG_0568GS.do", sParam);

			if (ComGetEtcData(searchXml, "success_yn") == "Y") {

				ComShowCodeMessage('COM130102', 'Data');
			}
		}

		var chkFlg2 = false;

		if (formObj.cnt_cd.value == 'CA' || formObj.cnt_cd.value == 'US') {

			for ( var i = 2; i <= sheetObj.LastRow; i++) {

				if (sheetObj.CellValue(i, "Chk") == '1') {

					chkFlg2 = true;

					sheetObj.RowStatus(i) = "I";
				}
			}

			if (chkFlg2) {

				if (ComShowCodeConfirm("BKG08100")) {//Do you want to trans to Customs

					doActionIBSheet(sheetObjects[0], formObj, COMMAND02);
				}
			}
		}

		if (!chkFlg && !chkFlg2) {

			ComShowCodeMessage("BKG00743");// There is no updated data to save.
		}

		break;

	case COMMAND01: //조회

		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);

		formObj.f_cmd.value = SEARCH01;

		sheetObj.DoSearch("ESM_BKG_0568GS.do", FormQueryString(formObj));

		break;

	case COMMAND02: //

		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);

		formObj.f_cmd.value = COMMAND02;

		var sParam = ComGetSaveString(sheetObj) + "&" + FormQueryString(formObj);

		var searchXml = sheetObj.GetSaveXml("ESM_BKG_0568GS.do", sParam);

		if (ComGetEtcData(searchXml, "success_yn") == "Y") {

			ComShowCodeMessage('COM130102', 'trans to Customs');

			doActionIBSheet(sheetObjects[0], document.form, INIT);
		} else {

			ComShowCodeMessage("BKG00571");// Please clear error data and try again.
		}

		break;
	}

	ComOpenWait(false);
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {

	if (formObj.pk_tp[0].checked == true) {

		if (formObj.from_date.value == '' || formObj.to_date.value == '' || formObj.from_time.value == ''
				|| formObj.to_time.value == '') {

			ComShowCodeMessage("BKG00499");// Period are mandatory items.
			formObj.from_date.focus();
			return false;
		}

		if ((formObj.cnt_cd.value == "US" || formObj.cnt_cd.value == "CA") && formObj.pod_cd.value == '') {

			ComShowCodeMessage("BKG00137");// POL/POD is not available
			formObj.pod_cd.focus();
			return false;
		}
	}

	if (formObj.pk_tp[1].checked == true && (formObj.vvd.value == '' || formObj.pod_cd.value == '')) {

		if (formObj.vvd.value == '') {

			ComShowCodeMessage("BKG00007");// VVD is not available !
			formObj.vvd.focus();
			return false;
		}

		if ((formObj.cnt_cd.value == "US" || formObj.cnt_cd.value == "CA") && formObj.pod_cd.value == '') {

			ComShowCodeMessage("BKG00137");// POL/POD is not available
			formObj.pod_cd.focus();
			return false;
		}
	}

	if (formObj.pk_tp[2].checked == true && formObj.bl_no.value == '') {

		ComShowCodeMessage("BKG00609");// Please, Check BL No !
		formObj.bl_no.focus();
		return false;
	}

	if (formObj.from_dt.value == '' && formObj.to_dt.value != '') {

		ComShowCodeMessage("BKG00499");// Period are mandatory items.
		formObj.from_dt.focus();
		return false;
	}

	if (formObj.from_dt.value != '' && formObj.to_dt.value == '') {

		ComShowCodeMessage("BKG00499");// Period are mandatory items.
		formObj.to_dt.focus();
		return false;
	}

	if (formObj.pk_tp[2].checked == false) {
		if (formObj.cnt_cd.value == 'KR' && formObj.pod_cd.value == '') {
			ComShowCodeMessage("BKG00210");// POL/POD is not available
			formObj.pod_cd.focus();
			return false;
		}
	}

	return true;
}

function sheet1_OnDblClick(sheetObj, Row, Col, Value) {

	var formObj = document.form;

	formObj.bl_no2.value = sheetObj.CellValue(Row, "bl_no");
	formObj.bkg_no.value = sheetObj.CellValue(Row, "bkg_no");
	formObj.corr_no.value = sheetObj.CellValue(Row, "corr_no");
	formObj.vvd2.value = sheetObj.CellValue(Row, "vvd");
	formObj.pol.value = sheetObj.CellValue(Row, "pol_cd");
	formObj.pod.value = sheetObj.CellValue(Row, "pod_cd");

	doActionIBSheet(sheetObjects[1], document.form, COMMAND01);
}

/*
 function sheet2_OnSearchEnd(sheetObj, ErrMsg)
 {
 with(sheetObj)
 {
 for(var i = 1; i <= LastRow; i ++)
 {
 if ("Remark" == CellValue(i, "Items"))
 CellEditable(i, "New") = true;
 }
 }
 }

 /**
 * 날짜 계산 함수
 */
function getCalculatedDate(iYear, iMonth, iDay, seperator) {
	//현재 날짜 객체를 얻어옴
	var gdCurDate = new Date();

	// 현재 날짜에 날짜 계산
	gdCurDate.setYear(gdCurDate.getFullYear() + iYear);
	gdCurDate.setMonth(gdCurDate.getMonth() + iMonth);
	gdCurDate.setDate(gdCurDate.getDate() + iDay);

	// 실제 사용할 연,월,일 변수 받기
	var giYear = gdCurDate.getFullYear();
	var giMonth = gdCurDate.getMonth() + 1;
	var giDay = gdCurDate.getDate();

	// 월,일의 자릿수를 2자리로 맞춘다.
	giMonth = "0" + giMonth;
	giMonth = giMonth.substring(giMonth.length - 2, giMonth.length);
	giDay = "0" + giDay;
	giDay = giDay.substring(giDay.length - 2, giDay.length);
	// alert(giYear + seperator + giMonth + seperator + giDay);
	// display 형태 맞추기
	return giYear + seperator + giMonth + seperator + giDay;
}

// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		var redColor = RgbColor(255, 0, 0);
		var blueColor = RgbColor(0, 0, 255);

		for ( var i = 2; i <= LastRow; i++) {

			if ("Y" == CellValue(i, "KIND_A")) {
				CellFontColor(i, "KIND_A") = redColor;
			}

			if ("Y" == CellValue(i, "KIND_B")) {
				CellFontColor(i, "KIND_B") = redColor;
			}

			if ("Y" == CellValue(i, "KIND_C")) {
				CellFontColor(i, "KIND_C") = redColor;
			}

			if ("Y" == CellValue(i, "KIND_D")) {
				CellFontColor(i, "KIND_D") = redColor;
			}

			if ("Y" == CellValue(i, "KIND_E")) {
				CellFontColor(i, "KIND_E") = redColor;
			}

			if ("Y" == CellValue(i, "KIND_F")) {
				CellFontColor(i, "KIND_F") = redColor;
			}

			if ("Y" == CellValue(i, "KIND_G")) {
				CellFontColor(i, "KIND_G") = redColor;
			}

			if ("Y" == CellValue(i, "KIND_H")) {
				CellFontColor(i, "KIND_H") = redColor;
			}

			if ("Y" == CellValue(i, "KIND_I")) {
				CellFontColor(i, "KIND_I") = redColor;
			}

			if ("Y" == CellValue(i, "KIND_J")) {
				CellFontColor(i, "KIND_J") = redColor;
			}

			if ("Y" == CellValue(i, "KIND_K")) {
				CellFontColor(i, "KIND_K") = redColor;
			}
		}
	}

}

/**
 * CHECK BOX >>> CHECKALL,UNCHECKALL
 */
function checkAll(value) {
	var sheetObj = sheetObjects[0];

	for ( var i = 1; i <= sheetObj.LastRow; i++) {
		if (sheetObj.CellValue(i, "chk_tp") == "C") {
			sheetObj.CellValue2(i, 0) = value;
		}
	}
}

/**
 * Login Office 따른 Link 설정
 */
function pageLink(tp) {

	var formObj = document.form;

	if (formObj.bkg_no.value == '') {

		ComShowCodeMessage("BKG00280");// Duplicate Bkg No! Please try again.
		return;
	}

	var cntCd = formObj.cnt_cd.value;

	var param = '';

	if (cntCd == 'KR') {

		param = '?bl_no=' + formObj.bl_no2.value + '&vvd=' + formObj.vvd2.value + "&pol_cd=" + formObj.pol.value + "&pod_cd="
				+ formObj.pod.value + "&port_cd=" + formObj.pod_cd.value + "&io_bnd_cd=I&mode=EDIT&in_type=&cstms_decl_tp_cd=I";
	} else {

		param = '?bkg_no=' + formObj.bkg_no.value + '&bl_no=' + formObj.bl_no2.value + '&corr_no=' + formObj.corr_no.value;
	}

	if (tp == '1') {//B/L Inquiry

		if (cntCd == 'US') {
			ComOpenWindow("/hanjin/ESM_BKG_0034.do" + param + "&tab=1&pgmNo=ESM_BKG_0034-01", "PopupEsmBkg0034",
					"width=1100, height=650, scrollbars=yes", false);
		} else if (cntCd == 'CA') {
			ComOpenWindow("/hanjin/ESM_BKG_0029.do" + param + "&tab=1&pgmNo=ESM_BKG_0029", "PopupEsmBkg0029",
					"width=1100, height=650, scrollbars=yes", false);
		} else {
			ComOpenWindow("/hanjin/ESM_BKG_0570.do" + param + "&tab=1&pgmNo=ESM_BKG_0570", "PopupEsmBkg0570",
					"width=1100, height=650, scrollbars=yes", false);
		}
	} else {//CNTR Inquiry

		if (cntCd == 'US') {
			//    			   ComOpenWindow("/hanjin/ESM_BKG_0518.do" + param + "&tab=2&pgmNo=ESM_BKG_0518", "PopupEsmBkg0518", "width=1100, height=650, scrollbars=yes", false);
			ComOpenWindow("/hanjin/ESM_BKG_0037.do" + param + "&tab=2&pgmNo=ESM_BKG_0037", "PopupEsmBkg0037",
					"width=620, height=400, scrollbars=no", false);
		} else if (cntCd == 'CA') {
			ComOpenWindow("/hanjin/ESM_BKG_0037.do" + param + "&tab=2&pgmNo=ESM_BKG_0037", "PopupEsmBkg0037",
					"width=1100, height=650, scrollbars=yes", false);
		} else {
			ComOpenWindow("/hanjin/ESM_BKG_0570.do" + param + "&tab=3&pgmNo=ESM_BKG_0570", "PopupEsmBkg0570",
					"width=1100, height=650, scrollbars=yes", false);
		}
	}
}

/**
 * 타입 설정
 */
function changeTP(tp) {

	var formObj = document.form;
	if (tp == '0') {

		formObj.pk_tp[0].checked = true;
	} else if (tp == '1') {

		formObj.pk_tp[1].checked = true;
	} else if (tp == '2') {

		formObj.pk_tp[2].checked = true;
	}
}

/**
 *  Remark MemoPad 
 */
function sheet1_OnClick(sheetObj, row, col, value) {

	//desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
	if (sheetObj.ColSaveName(col) == "bkg_corr_rmk" && sheetObj.CellValue(row, "chk_tp") == "C") {
		ComShowMemoPad(sheetObj, null, null, null, null, null, 1000);
	}
}

/**
 * RD(Report Designer) Print
 */
function goPrint(tp) {

	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	if (tp == "1") {

		var ca_from_dt = "";
		var ca_to_dt = "";
		var vvd = "";
		var pod = formObj.pod_cd.value;
		var pod_tp = "";
		var del = "";
		var bl_no = "";
		var where = "";
		var cnt_cd = formObj.cnt_cd.value;
		if (formObj.pk_tp[0].checked == true) {
			ca_from_dt = formObj.from_date.value + " " + formObj.from_time.value;
			ca_to_dt = formObj.to_date.value + " " + formObj.to_time.value;
		} else if (formObj.pk_tp[1].checked == true) {
			vvd = formObj.vvd.value;
			del = formObj.del_cd.value;
		} else if (formObj.pk_tp[2].checked == true) {
			bl_no = formObj.bl_no.value;
		}

		if (formObj.pod_tp.checked == true) {
			pod_tp = "VVD";
		} else {
			pod_tp = "BKG";
		}

		var rdPath = "apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_5031.mrd";

		formObj.com_mrdTitle.value = "C/A Report(I/B)";
		formObj.com_mrdBodyTitle.value = "C/A Report(I/B)";
		formObj.com_mrdPath.value = rdPath;
		formObj.com_mrdArguments.value = "/rv CA_FROM_DT[" + ca_from_dt + "] CA_TO_DT[" + ca_to_dt + "] VVD[" + vvd + "] POD_CD["
				+ pod + "] POD_TP[" + pod_tp + "] DEL_CD[" + del + "] BL_NO[" + bl_no + "] CNT_CD[" + cnt_cd + "] PK_TP["
				+ ComGetObjValue(formObj.pk_tp) + "]";
	} else {

		var bkg_no = "";
		var ca_no = "";

		if (sheetObj.CellValue(sheetObj.SelectRow, "bkg_no") == ""
				|| sheetObj.CellValue(sheetObj.SelectRow, "bkg_no").indexOf("VVD") > -1) {

			bkg_no = sheetObj.CellValue(3, "bkg_no");
			ca_no = sheetObj.CellValue(3, "corr_no");

			doActionIBSheet(sheetObjects[1], document.form, COMMAND01);
		} else {

			bkg_no = sheetObj.CellValue(sheetObj.SelectRow, "bkg_no")
			ca_no = sheetObj.CellValue(sheetObj.SelectRow, "corr_no");
		}

		var rdPath = "apps/alps/esm/bkg/bookingcorrection/bdrcorrection/report/ESM_BKG_0182.mrd";

		formObj.com_mrdTitle.value = "C/A Report(I/B)";
		formObj.com_mrdBodyTitle.value = "C/A Report(I/B)";
		formObj.com_mrdPath.value = rdPath;

//		formObj.com_mrdArguments.value = "/rp ['" + bkg_no + "'] ['" + ca_no + "'] /riprnmargin";
		formObj.com_mrdArguments.value = "/rv bkg_no['" + bkg_no + "'] ca_no['" + ca_no + "'] /riprnmargin";
	}
	ComOpenRDPopup();
}

/* 개발자 작업 끝 */