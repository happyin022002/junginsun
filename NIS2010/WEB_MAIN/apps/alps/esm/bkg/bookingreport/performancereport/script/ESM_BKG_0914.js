/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0914.js
 *@FileTitle : Port Closing Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.17
 *@LastModifier : 김기종
 *@LastVersion : 1.0
 * 2009.08.17 김기종
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
 * @class ESM_BKG_0914 : ESM_BKG_0914 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0914() {
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
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var combo1 = null;
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	var sheetObject4 = sheetObjects[3];
	/** **************************************************** */
	var formObject = document.form;
	var bkg_no = "";
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_BookingDetail":
			if (CheckGrid(sheetObject3, "")) {
				bkg_no = sheetObject3.CellValue(getCheckedRow(sheetObject3, "check"), "bkg_no");
				comBkgCallPopBkgDetail(bkg_no);
				break;
			}
			break;

		case "btn_Charge":
			if (CheckGrid(sheetObject3, "")) {
				bkg_no = sheetObject3.CellValue(getCheckedRow(sheetObject3, "check"), "bkg_no");
				comBkgCallPopBkgCharge(bkg_no);
				break;
			}
			break;
		case "btn_Office":
			comBkgCallPopBkgOffice();
			break;
		case "btn_Retrieve":
			ComSetObjValue(formObject.down_tp_t, "");
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;

		case "btn_New":
			formObject.reset();
			sheetObject1.RemoveAll();
			sheetObject2.RemoveAll();
			sheetObject3.RemoveAll();
			sheetObject4.RemoveAll();
			break;

		case "btn_DownExcel":

			if (formObject.down_tp_o.checked == true) {
				sheetObject1.SpeedDown2Excel(-1);
			}
			if (formObject.down_tp_b.checked == true) {
				sheetObject3.SpeedDown2Excel(-1, true);
			}
			if (formObject.down_tp_t.checked == true) {
				ComSetObjValue(formObject.down_tp_t, "TOT");
				formObject.down_tp_t.value = "TOT";

				ComOpenWait(true); // 대기이미지 표시
				doActionIBSheet(sheetObject4, formObject, IBROWSEARCH);
				ComOpenWait(false); // 대기이미지 숨김
				sheetObject4.SpeedDown2Excel(-1, true);
			}

			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("COM12111");
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

function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);

}
 
//function sheet1_OnLoadFinish(sheetObj) {
//	setTimeout(function () { doActionIBSheet(sheetObjects[0], document.form, IBCLEAR); },1000);
//}
 
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
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerForm('blur', 'obj_deactivate', formObject); // - 포커스 나갈때
	axon_event.addListenerFormat('focus', 'obj_activate', formObject); // - 포커스 들어갈때
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); // - 키보드 입력할때
	axon_event.addListenerForm('beforedeactivate', 'getStaffList', formObject); // - 포커스 나갈때
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

	combo1 = comboObjects[0];
	comboCnt = comboObjects.length;

	// IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}

	ComSetObjValue(formObject.fr_dt, ComGetNowInfo());
	ComSetObjValue(formObject.to_dt, ComGetNowInfo());
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	if (sheetObj.id == "sheet1") {
		with (sheetObj) {
			// 높이 설정
			style.height = 280;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;// msPrevColumnMerge; //msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 5, 100);

			var HeadTitle = " |No.|RHQ|GSO|B.OFC|TTL|BKG\nFirm|BKG\nWaiting|CNEE\nInput|Charged|None\nCharged|CNTR\nConfirmed|CNTR\nNon-Confirmed";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,
			// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtSeq, 30, daCenter, false, "no");
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rhq_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "bkg_ofc_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "b_ofc", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, false, "ttl", false, "", dfNullInteger, 0, false);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, false, "firm_ttl", false, "", dfNullInteger, 0, false);
			InitDataProperty(0, cnt++, dtAutoSum, 60, daRight, false, "wait_ttl", false, "", dfNullInteger, 0, false);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, false, "cnee_ttl", false, "", dfNullInteger, 0, false);
			InitDataProperty(0, cnt++, dtAutoSum, 60, daRight, false, "rfirm_ttl", false, "", dfNullInteger, 0, false);
			InitDataProperty(0, cnt++, dtAutoSum, 60, daRight, false, "null_ttl", false, "", dfNullInteger, 0, false);
			InitDataProperty(0, cnt++, dtAutoSum, 80, daRight, false, "cntr_cfm", false, "", dfNullInteger, 0, false);
			InitDataProperty(0, cnt++, dtAutoSum, 80, daRight, false, "cntr_noncfm", false, "", dfNullInteger, 0, false);
			FocusEditMode = -1;
			MultiSelection = false;

		}

	} else if (sheetObj.id == "sheet2") {
		with (sheetObj) {
			// 높이 설정
			style.height = 62;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 5, 100);

			var HeadTitle = "B/L Type|B/L TTL|CNEE Code|NTFY Code";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			// InitHeadMode(true, true, false, true, false,false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,
			// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 110, daCenter, false, "bl_type");
			InitDataProperty(0, cnt++, dtData, 110, daRight, false, "bl_ttl", false, "", dfNullInteger);
			InitDataProperty(0, cnt++, dtData, 110, daRight, false, "cnee_ttl", false, "", dfNullInteger);
			InitDataProperty(0, cnt++, dtData, 110, daRight, false, "ntfy_ttl", false, "", dfNullInteger);

			CountPosition = 0;
			FocusEditMode = -1;
		}

	} else if (sheetObj.id == "sheet3" || sheetObj.id == "sheet4") {
		with (sheetObj) {
			// 높이 설정

			style.height = 280;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 5, 100);

			var HeadTitle = " |No.|Booking No.|B/L No.|BKG STS|Rating\nSTS|PCT|VVD|Lane|REV|ATD|ETD|CNEE CD|CNEE\nName|NTFY CD|NTFY\nName|SHPR CD|SHPR Name|POL|S/R|Bkg Ofc|Bkg Staff|B/L\nType|S/C|RFA|CNTR Confirm";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,
			// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtRadioCheck, 30, daCenter, false, "check");
			InitDataProperty(0, cnt++, dtSeq, 30, daCenter, false, "no");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bkg_no", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bl_no", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "bkg_sts_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "bkg_rt_sts_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "bkg_pct_dt", false, "", dfDateYmd, 0, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "vvd_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "slan_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "rev_status", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, false, "atd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, false, "etd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "cnee_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 110, daLeft, false, "cnee_nm", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "ntfy_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 110, daLeft, false, "ntfy_nm", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "shpr_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 110, daLeft, false, "shpr_nm", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "pol_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "si_flg", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "bkg_ofc_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "bkg_stf", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "bl_type", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "sc_no", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "rfa_no", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "cntr_cfm", false, "", dfNone, 0, false);

		}
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	
		case IBCLEAR: // 화면 로딩시 코드 조회
			formObj.f_cmd.value = INIT;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0914GS.do", FormQueryString(formObj));
	
			var arrXml = sXml.split("|$$|");
			sheetObjects[2].RemoveAll();
	
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], formObj.elements["slan_cd"], "vsl_slan_cd", "vsl_slan_cd|vsl_slan_nm");
				formObj.slan_cd.InsertItem(0,"All","All");
	            formObj.slan_cd.Index =0 ;
			if (arrXml.length > 2)
				ComXml2ComboItem(arrXml[2], formObj.bkg_rt_sts_cd, "val", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.bkg_sts_cd, "val", "name");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.rhq_cd, "val", "desc");
	
			ComSetObjValue(formObj.bkg_rt_sts_cd, "A");
			ComSetObjValue(formObj.bkg_sts_cd, " ");
			// ComSetObjValue(formObj.rhq_cd," ");
			formObj.rhq_cd.index = 0;
	
			formObj.rhq_cd.Code = ComGetEtcData(arrXml[0], "USER_RHQ");
			
			// ComSetObjValue(formObj.bkg_cust_tp_cd,"S");
			// formObj.region_cd.InsertItem(0, '', '');
			break;
			
		case IBSEARCH: //조회	
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value = SEARCH;
	
				sheetObjects[1].WaitImageVisible = false;
				ComOpenWait(true); // 대기이미지 표시
	
				var sXml = sheetObjects[1].GetSearchXml("ESM_BKG_0914GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
	
				sheetObjects[2].RemoveAll();
				sheetObjects[1].RemoveAll();
				sheetObjects[0].RemoveAll();
				
				ComSetObjValue(formObj.bk_tot_cnt, "");
				ComSetObjValue(formObj.bk_charge_cnt, "");
				ComSetObjValue(formObj.bk_non_charge_cnt, "");
				ComSetObjValue(formObj.bk_percent, "");
	
				ComSetObjValue(formObj.rt_tot_cnt, "");
				ComSetObjValue(formObj.rt_charge_cnt, "");
				ComSetObjValue(formObj.rt_non_charge_cnt, "");
				ComSetObjValue(formObj.rt_percent, "");
				
				ComSetObjValue(formObj.cntr_tot_cnt, "");
				ComSetObjValue(formObj.cntr_cfm_cnt, "");
				ComSetObjValue(formObj.cntr_noncfm_cnt, "");
				ComSetObjValue(formObj.cntr_percent, "");					
				/*
				 * if (arrXml.length > 2) sheetObjects[2].LoadSearchXml(arrXml[2]);
				 */
				if (arrXml.length > 1)
					sheetObjects[1].LoadSearchXml(arrXml[1]);
				if (arrXml.length > 0)
					sheetObjects[0].LoadSearchXml(arrXml[0]);
				ComOpenWait(false); // 대기이미지 숨김
			}
			break;

		case IBROWSEARCH: //조회
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value = SEARCH01;
	
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0914GS.do", FormQueryString(formObj));
				sheetObj.RemoveAll();
	
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					sheetObj.LoadSearchXml(arrXml[0]);
			}
			break;

		case "btn_New":
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
			ComResetAll();
			break;
		case IBDOWNEXCEL: // 다운로드
			sheetObj.SpeedDown2Excel(-1);
			break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		switch (sAction) {
		case IBSEARCH: // 조회시 확인
			if (!ComChkValid(formObj))
				return false;

			if (!ComIsNull(formObj.fr_dt) && !ComIsNull(formObj.to_dt)
					&& ComGetDaysBetween(formObj.fr_dt.value, formObj.to_dt.value) > 31) {

				ComShowCodeMessage("BKG50469");// Can't Input Date Over 31 days!
				formObj.fr_dt.focus();
				return false;
			}

			break;
		}
	}
	return true;
}

/**
 * 콤보 초기설정값
 * @param {IBMultiCombo} comboObj  comboObj
 */
function initCombo(comboObj) {
	comboObj.DropHeight = 150;

}
/**
 * from,to 기간 선택 달력 띄우기
 */
function callDatePop(val) {
	var cal = new ComCalendarFromTo();
	if (val == 'BKG_DATE') {
		cal.select(form.fr_dt, form.to_dt, 'yyyy-MM-dd');
	}

}
/*
BKG Staff 콤보리스트 조회-BKG Office 값 입력 후 포커스를 잃었을 때..
 */
function getStaffList() {
	var formObj = document.form;

	if (ComGetObjValue(formObj.bkg_ofc_cd) == "" || ComGetObjValue(formObj.bkg_ofc_cd).length < 5) {
		return;
	}

	switch (event.srcElement.name) {
	case "bkg_ofc_cd":
		formObj.f_cmd.value = COMMAND01;

		var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0620GS.do", FormQueryString(formObj));

		var arrXml = sXml.split("|$$|");

		if (arrXml.length > 0) {
			ComXml2ComboItem(arrXml[0], formObj.bkg_staff, "usr_id", "usr_id|usr_nm");
			formObj.bkg_staff.InsertItem(0, '', '');
		}
		formObj.bkg_staff.DropHeight = 150;
		break;
	}
}

function sheet1_OnClick(sheetObj, Row, Col, Value) {
	var formObj = document.form;

	if (sheetObj.RowCount("R") < Row)
		return;
	sheetObj.CountFormat = "[" + Row + " / " + sheetObj.RowCount("R") + "]";
	if (sheetObj.CellValue(Row, "b_ofc") != '' && sheetObj.CellValue(Row, "rhq_cd") != '') {
		formObj.down_tp_t.value = "";
		ComSetObjValue(formObj.sel_bkg_ofc_cd, sheetObj.CellValue(Row, "b_ofc"));
		doActionIBSheet(sheetObjects[2], formObj, IBROWSEARCH);
	}
}

function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
	comBkgIndicateLink(sheetObj, "bkg_no");
	var formObj = document.form;
	var bk_tot_cnt = 0;
	var bk_charge_cnt = 0;
	var bk_non_charge_cnt = 0;
	var bk_percent = 0;

	var rt_tot_cnt = 0;
	var rt_charge_cnt = 0;
	var rt_firm_cnt = 0;
	var rt_non_charge_cnt = 0;
	var rt_percent = 0;

	var cntr_cfm_cnt = 0;
	var cntr_noncfm_cnt = 0;
	var cntr_percent = 0;
	
	with (sheetObj) {

		ComSetObjValue(formObj.bk_tot_cnt, "0");
		ComSetObjValue(formObj.bk_charge_cnt, "0");
		ComSetObjValue(formObj.bk_non_charge_cnt, "0");
		ComSetObjValue(formObj.bk_percent, "0");

		ComSetObjValue(formObj.rt_tot_cnt, "0");
		ComSetObjValue(formObj.rt_charge_cnt, "0");
		ComSetObjValue(formObj.rt_non_charge_cnt, "0");
		ComSetObjValue(formObj.rt_percent, "0%");

		for ( var i = 1; i < Rows; i++) {
			if (CellValue(i, "bkg_sts_cd") == "F") {
				bk_charge_cnt++;
			}
			if (CellValue(i, "bkg_rt_sts_cd") == "F") {
				rt_firm_cnt++;
			}
			if (CellValue(i, "cntr_cfm") == "Y") {
				cntr_cfm_cnt++;
			}
		}

		rt_charge_cnt = rt_firm_cnt;

		bk_tot_cnt = RowCount;
		rt_tot_cnt = RowCount;
		bk_non_charge_cnt = bk_tot_cnt - bk_charge_cnt;

		rt_non_charge_cnt = rt_tot_cnt - rt_charge_cnt;
		
		cntr_noncfm_cnt = bk_tot_cnt - cntr_cfm_cnt;

		if (bk_non_charge_cnt != 0) {
			bk_percent = ComRound(bk_non_charge_cnt / bk_tot_cnt * 100) + "%";
		} else {
			bk_percent = bk_non_charge_cnt + "%";
		}
		if (rt_non_charge_cnt != 0) {
			rt_percent = ComRound(rt_non_charge_cnt / rt_tot_cnt * 100) + "%";
		} else {
			rt_percent = rt_non_charge_cnt + "%";
		}
		if (cntr_noncfm_cnt != 0) {
			cntr_percent = ComRound(cntr_noncfm_cnt / bk_tot_cnt * 100) + "%";
		} else {
			cntr_percent = cntr_noncfm_cnt + "%";
		}

	}

	ComSetObjValue(formObj.bk_tot_cnt, bk_tot_cnt);
	ComSetObjValue(formObj.bk_charge_cnt, bk_charge_cnt);
	ComSetObjValue(formObj.bk_non_charge_cnt, bk_non_charge_cnt);
	ComSetObjValue(formObj.bk_percent, bk_percent);

	ComSetObjValue(formObj.rt_tot_cnt, rt_tot_cnt);
	ComSetObjValue(formObj.rt_charge_cnt, rt_charge_cnt);
	ComSetObjValue(formObj.rt_non_charge_cnt, rt_non_charge_cnt);
	ComSetObjValue(formObj.rt_percent, rt_percent);
	
	ComSetObjValue(formObj.cntr_tot_cnt, bk_tot_cnt);
	ComSetObjValue(formObj.cntr_cfm_cnt, cntr_cfm_cnt);
	ComSetObjValue(formObj.cntr_noncfm_cnt, cntr_noncfm_cnt);
	ComSetObjValue(formObj.cntr_percent, cntr_percent);

	formObj.rt_non_charge_cnt.color = "red";

}
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var dataRowCnt = 0;
	with (sheetObj) {

		dataRowCnt = RowCount;
		MessageText("SubSum") = "";
		SumFontBold = true;
		ShowSubSum("rhq_cd", "5|6|7|8|9|10|11|12", 2, false, false, 1, "no=;rhq_cd=%s;bkg_ofc_cd=", "");
		SumText(0, "no") = "";

		for ( var iRow = dataRowCnt + 1; iRow < Rows - 1; iRow++) {
			CellFont("FontBold", iRow, "b_ofc") = true;
			CellValue(iRow, "b_ofc") = CellValue(iRow, "rhq_cd");
			CellAlign(iRow, "b_ofc") = daCenter;
			CellValue(iRow, "rhq_cd") = "";
		}

		CellValue(Rows - 1, "b_ofc") = "TOTAL";
		CellValue(Rows - 1, "no") = "";
		CellAlign(Rows - 1, "b_ofc") = daCenter;
		// TotalRows = "100";
		// CountFormat = "선택 SELECTDATAROW행 / 총 ROWCOUNT건";

	}
	//"no=%s;rhq_cd=%s;bkg_ofc_cd=%s;
	// "no"="";"rhq_cd"="";"bkg_ofc_cd"="";"b_ofc"="rhq_cd"
}
function CheckGrid(sheetObject, prefix) {
	var iCheckRow = sheetObject.FindCheckedRow(prefix + "check");
	if (iCheckRow == "") {
		ComShowCodeMessage('BKG00249');
		return false;
	}
	return true;
}

function getCheckedRow(sheetObj, colName) {
	var checkRow;
	for ( var iRow = 0; iRow < sheetObj.Rows; iRow++) {
		if (sheetObj.CellValue(iRow, "check") == 1) {
			return iRow;
		}
	}
}

function sheet3_OnDblClick(sheetObj,rowIdx,colIdx) {
	var colName = sheetObj.ColSaveName(colIdx);
	if (colName == "bkg_no"){
		comBkgCallBkgDetail(sheetObj.CellValue(rowIdx, colName));
	}
}
/* 개발자 작업  끝 */