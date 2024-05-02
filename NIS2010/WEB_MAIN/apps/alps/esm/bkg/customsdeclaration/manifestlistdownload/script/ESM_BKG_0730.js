/*=========================================================
 *Copyright(c) 2017 Hi-Plus Card
 *@FileName : Esm_bkg_0730.js
 *@FileTitle : ESM_BKG-0730
 *Open Issues :
 *Change history : 
 *	2017.08.08 하대성 2017 Renewal Version Transmit 반영
 *@LastModifyDate : 2017.08.08
 *@LastModifier : 하대성
 *@LastVersion : 1.0
 * 2009.05.26 김승민
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
 * @class ESM_BKG-0730 : ESM_BKG-0730 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0730() {
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
var sheetObjects = new Array();
var sheetCnt = 0;

var state = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;

		case "btn_save":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND01);
			break;

		case "btn_customer":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND04);
			break;

		case "btn_cntr":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND05);
			break;

		case "btn_marks":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND06);
			break;

		case "btn_trans":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND02);
			break;
			
		case "btn_trans_new_naccs":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND12);
			break;			

		case "btn_add":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND03);
			break;

		case "btn_delete":
			// alert("delete");
			doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
			break;

		case "btns_calendar": // 달력버튼
			// 조회전 일땐 사용못하게 ...
			var cal = new ComCalendar();
			cal.select(formObject.in_vps_eta_dt, 'yyyy-MM-dd');
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

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	document.form.in_vvd_cd.focus();
	// doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
	// ** Date 구분자 **/
	DATE_SEPARATOR = "-";

	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerForm('blur', 'obj_deactivate', formObject); // - 포커스
																		// 나갈때
	axon_event.addListenerFormat('focus', 'obj_activate', formObject); // - 포커스
																		// 들어갈때
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // -
																			// 키보드
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	ComBtnDisable("btn_trans");
	ComBtnDisable("btn_trans_new_naccs");
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
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 */
function obj_keypress() {
	switch (event.srcElement.dataformat) {
	case "uppernum":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "upper":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('upper');
		break;		
	default:
		// 숫자만입력하기(정수,날짜,시간)
		ComKeyOnlyNumber(event.srcElement);
	}
}

/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 */
function obj_activate() {
	// 입력Validation 확인하기
	switch (event.srcElement.name) {

	case "in_vps_eta_dt":
		ComClearSeparator(event.srcElement);
		break;
	default:
		break;
	// return;
	// ComAddSeparator(event.srcElement);
	// ComChkObjValid(event.srcElement);
	}
}

/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 */
function obj_deactivate() {
	// if (event.srcElement.getAttribute("required") != null) return;

	// 입력Validation 확인하기
	switch (event.srcElement.name) {

	case "in_vps_eta_dt":
		ComAddSeparator(event.srcElement);
		break;
	default:
		break;
	// ComAddSeparator(event.srcElement);
	// ComChkObjValid(event.srcElement);
	}
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
	case "sheet1": // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 302;
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
			InitRowInfo(2, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(33, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			var HeadTitle1 = "Flag||Sel.|Seq.|B/L No.|POL|L/T|F/M|Next VVD|Next POD|B/L|B/L|B/L|B/L|B/L|B/L|B/L|SHPR|SHPR|SHPR|SHPR|CNEE|CNEE|CNEE|CNEE|NTFY|NTFY|NTFY|NTFY|B/L|B/L|Booking Container|Booking Container";
			var HeadTitle2 = "Flag||Sel.|Seq.|B/L No.|POL|L/T|F/M|Next VVD|Next POD|DEL|P|PU|W|WU|M|MU|NM|AD|PHN|VIA|NM|AD|PHN|VIA|NM|AD|PHN|VIA|M|DS|Number|S";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT,
			// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
			// FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,
					"ibflag");

			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,
					"bl_number2", false, "", dfNone, 0, false, true, false);
			InitDataProperty(0, cnt++, dtCheckBox, 40, daCenterTop, true,
					"del_chk");
			InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "seq");
			InitDataProperty(0, cnt++, dtData, 95, daCenterTop, true,
					"bl_number", false, "", dfNone, 0, false, true, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenterTop, true, "pol_cd",
					false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 35, daCenterTop, true,
					"locl_ts_flg", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 35, daCenterTop, true,
					"full_mty_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 75, daCenterTop, true,
					"pst_vsl_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 75, daCenterTop, true,
					"pst_rly_pod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenterTop, true,
					"bkg_del_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenterTop, true,
					"pck_qty", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 25, daCenterTop, true,
					"pck_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenterTop, true,
					"grs_wgt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenterTop, true,
					"wgt_ut_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenterTop, true,
					"meas_qty", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenterTop, true,
					"meas_ut_cd", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true,
					"cust_nm", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true,
					"cust_addr", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true,
					"phn_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true,
					"via", false, "", dfNone, 0, false, true);	
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true,
					"cust_nm2", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true,
					"cust_addr2", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true,
					"phn_no2", false, "", dfNone, 0, false, true);		
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true,
					"via2", false, "", dfNone, 0, false, true);	
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true,
					"cust_nm3", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true,
					"cust_addr3", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true,
					"phn_no3", false, "", dfNone, 0, false, true);	
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true,
					"via3", false, "", dfNone, 0, false, true);	
			InitDataProperty(0, cnt++, dtData, 20, daCenterTop, true,
					"diff_rmk", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenterTop, true,
					"bl_desc", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 85, daCenter, true, "cntr_no",
					false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, true,
					"cntr_seal_no", false, "", dfNone, 0, false, true);

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

	case IBSEARCH: // 조회
		formObj.f_cmd.value = SEARCH;
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		if (validateForm(sheetObj, formObj, sAction)) {
			// sheetObj.ColHidden(1) = false;

			
			sheetObj.DoSearch("ESM_BKG_0730GS.do", FormQueryString(formObj));
			//alert(sheetObjects[0].EtcData("in_call_sgn_no"));

			
			state = sheetObj.EtcData("TRANS_RESULT_KEY");

			if (state == "S") {
					formObj.in_call_sgn_no.value = sheetObjects[0].EtcData("in_call_sgn_no");
					formObj.in_vps_eta_dt.value = sheetObjects[0].EtcData("in_vps_eta_dt");
					formObj.in_cy_opr_cd.value = sheetObjects[0].EtcData("in_cy_opr_cd");
					formObj.in_pod_split_cd.value = sheetObjects[0].EtcData("in_pod_split_cd");
					formObj.in_voyage_no.value = sheetObjects[0].EtcData("in_voyage_no");
				if (document.form.in_err_gb[0].checked) {

					ComBtnEnable("btn_trans");
					ComBtnEnable("btn_trans_new_naccs");
				} else {
					ComBtnDisable("btn_trans");
					ComBtnDisable("btn_trans_new_naccs");
				}
				sheetObj.CheckAll("del_chk") = 0;
			}
		}

		for ( var i = 2; i <= sheetObjects[0].RowCount + 1; i++) {
			if (sheetObjects[0].CellValue(i, "pck_qty") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "pck_qty") = sheetObjects[0]
						.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "grs_wgt") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "grs_wgt") = sheetObjects[0]
						.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "meas_qty") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "meas_qty") = sheetObjects[0]
						.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "diff_rmk") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "diff_rmk") = sheetObjects[0]
						.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "bl_desc") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "bl_desc") = sheetObjects[0]
						.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "grs_wgt") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "cmdt_desc") = sheetObjects[0]
						.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "grs_wgt") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "cmdt_desc") = sheetObjects[0]
						.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "pck_tp_cd") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "pck_tp_cd") = sheetObjects[0]
						.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "wgt_ut_cd") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "wgt_ut_cd") = sheetObjects[0]
						.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "meas_ut_cd") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "meas_ut_cd") = sheetObjects[0]
						.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "cust_nm") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "cust_nm") = sheetObjects[0]
						.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "cust_addr") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "cust_addr") = sheetObjects[0]
						.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "phn_no") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "phn_no") = sheetObjects[0]
						.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "via") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "via") = sheetObjects[0]
				.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "cust_nm2") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "cust_nm2") = sheetObjects[0]
						.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "cust_addr2") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "cust_addr2") = sheetObjects[0]
						.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "phn_no2") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "phn_no2") = sheetObjects[0]
						.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "via2") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "via2") = sheetObjects[0]
				.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "cust_nm3") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "cust_nm3") = sheetObjects[0]
						.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "cust_addr3") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "cust_addr3") = sheetObjects[0]
						.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "phn_no3") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "phn_no3") = sheetObjects[0]
						.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "via3") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "via3") = sheetObjects[0]
				.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "cust_nm4") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "cust_nm4") = sheetObjects[0]
						.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "cust_addr4") == "N") {
				sheetObjects[0].CellFont("FontColor", i, "cust_addr4") = sheetObjects[0]
						.RgbColor(255, 0, 0);
			}
			if (sheetObjects[0].CellValue(i, "bl_number") == "") {
				sheetObjects[0].CellEditable(i, "del_chk") = false;
			}
			if (sheetObjects[0].CellValue(i, "pst_vsl_cd") == "-") {
				sheetObjects[0].CellValue(i, "pst_vsl_cd") = " ";
			}
			if (sheetObjects[0].CellValue(i, "pst_rly_pod_cd") == "-") {
				sheetObjects[0].CellValue(i, "pst_rly_pod_cd") = " ";
			}
		}
		ComOpenWait(false);

		break;

	case COMMAND01: // 저장
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = MULTI;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			sheetObj.DoAllSave("ESM_BKG_0730GS.do", FormQueryString(formObj));
			ComOpenWait(false);
		}
		break;

	case COMMAND02: // 저장
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = MULTI01;
			//alert(sheetObjects[0].RowCount);
			

			sheetObjects[0].WaitImageVisible = false;
			ComOpenWait(true,true);
			
			//alert(sheetObjects[0].CellValue(2,"bl_number"));
			//alert(sheetObjects[0].CellValue(sheetObjects[0].RowCount+1,"bl_number"));
			for ( var i=2 ; i<sheetObjects[0].RowCount+2 ; i++ )
			{
				//sheetObjects[0].CellValue(i,"ibflag") = "I";
				sheetObjects[0].RowStatus(i) = "I";
			}
			var sParam = "";					 
			var sParamSheet2 = sheetObjects[0].GetSaveString();
			if (sParamSheet2 != "") {
				sParam += "&" + ComSetPrifix(sParamSheet2, "");
			}					 
			sParam += "&" + FormQueryString(formObj);			
			//alert(sParam);
			var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0730GS.do", sParam);	
			//ComEtcDataToForm(formObj, sheetObj);
			var key = ComGetEtcData(sXml, "KEY");
			//alert(key);
			ComOpenWait(true);
			intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
			
			//sheetObj.DoAllSave("ESM_BKG_0730GS.do", FormQueryString(formObj));
			
			//state = sheetObj.EtcData("TRANS_RESULT_KEY");

			//if (state == "S") {
			//	doActionIBSheet(sheetObj, document.form, IBSEARCH);
			//}			
		}
		break;
	
	case COMMAND12: // 저장
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = MULTI02;
			//alert(sheetObjects[0].RowCount);
			

			sheetObjects[0].WaitImageVisible = false;
			ComOpenWait(true,true);
			
			//alert(sheetObjects[0].CellValue(2,"bl_number"));
			//alert(sheetObjects[0].CellValue(sheetObjects[0].RowCount+1,"bl_number"));
			for ( var i=2 ; i<sheetObjects[0].RowCount+2 ; i++ )
			{
				//sheetObjects[0].CellValue(i,"ibflag") = "I";
				sheetObjects[0].RowStatus(i) = "I";
			}
			var sParam = "";					 
			var sParamSheet2 = sheetObjects[0].GetSaveString();
			if (sParamSheet2 != "") {
				sParam += "&" + ComSetPrifix(sParamSheet2, "");
			}					 
			sParam += "&" + FormQueryString(formObj);			
			//alert(sParam);
			var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0730GS.do", sParam);	
			//ComEtcDataToForm(formObj, sheetObj);
			var key = ComGetEtcData(sXml, "KEY");
			//alert(key);
			ComOpenWait(true);
			intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
			
			//sheetObj.DoAllSave("ESM_BKG_0730GS.do", FormQueryString(formObj));
			
			//state = sheetObj.EtcData("TRANS_RESULT_KEY");

			//if (state == "S") {
			//	doActionIBSheet(sheetObj, document.form, IBSEARCH);
			//}			
		}
		break;

	case COMMAND03: // 저장
		if (validateForm(sheetObj, formObj, sAction)) {
			var sUrl = "/hanjin/ESM_BKG_0990.do?pgmNo=ESM_BKG_0990&vvd_cd="
					+ formObj.in_vvd_cd.value + "&pod_cd="
					+ formObj.in_pod_cd.value;
			ComOpenWindowCenter(sUrl, "ESM_BKG_0990", 416, 163, false);
			// ComOpenWindowCenter(sUrl, "ESM_BKG_0990", 1024, 768, true);
		}
		break;

	case COMMAND04: // 저장

		if (validateForm(sheetObj, formObj, sAction)) {
			var selectedBlNumber = "";
			for ( var i = 2; i <= sheetObjects[0].RowCount + 1; i++) {
				if (sheetObjects[0].CellValue(i, "del_chk") == 1) {
					selectedBlNumber = sheetObjects[0]
							.CellValue(i, "bl_number");
					break;
				}
			}
			var sUrl = "/hanjin/ESM_BKG_0456.do?pgmNo=ESM_BKG_0456&bl_no=" + selectedBlNumber
					+ "&vvd_cd=" + formObj.in_vvd_cd.value + "&pod_cd="
					+ formObj.in_pod_cd.value;
			// var sUrl = "/hanjin/ESM_BKG_0456.do?bl_no="+selectedBlNumber;
			ComOpenWindowCenter(sUrl, "ESM_BKG_0456", 717, 400, false);
			// ComOpenWindowCenter(sUrl, "ESM_BKG_0456", 1024, 768, true);
		}
		// var sUrl =
		// "/hanjin/ESM_BKG_0456.do?vvd_cd="+formObj.in_vvd_cd.value+"&pod_cd="+formObj.in_pod_cd.value;
		// ComOpenWindowCenter(sUrl, "ESM_BKG_0990", 423, 172, true);
		// ComOpenWindowCenter(sUrl, "ESM_BKG_0990", 1024, 768, true);

		break;

	case COMMAND05: // 저장

		if (validateForm(sheetObj, formObj, sAction)) {
			var selectedBlNumber = "";
			for ( var i = 2; i <= sheetObjects[0].RowCount + 1; i++) {
				if (sheetObjects[0].CellValue(i, "del_chk") == 1) {
					selectedBlNumber = sheetObjects[0]
							.CellValue(i, "bl_number");
					break;
				}
			}
			var sUrl = "/hanjin/ESM_BKG_0455.do?pgmNo=ESM_BKG_0455&bl_no=" + selectedBlNumber + "&callPgm=ESM_BKG_0730";
			// var sUrl = "/hanjin/ESM_BKG_0456.do?bl_no="+selectedBlNumber;
			ComOpenWindowCenter(sUrl, "ESM_BKG_0455", 1000, 341, false);
			// ComOpenWindowCenter(sUrl, "ESM_BKG_0456", 1024, 768, true);
		}
		// var sUrl =
		// "/hanjin/ESM_BKG_0456.do?vvd_cd="+formObj.in_vvd_cd.value+"&pod_cd="+formObj.in_pod_cd.value;
		// ComOpenWindowCenter(sUrl, "ESM_BKG_0990", 423, 172, true);
		// ComOpenWindowCenter(sUrl, "ESM_BKG_0990", 1024, 768, true);

		break;

	case COMMAND06: // 저장

		if (validateForm(sheetObj, formObj, sAction)) {
			var selectedBlNumber = "";
			for ( var i = 2; i <= sheetObjects[0].RowCount + 1; i++) {
				if (sheetObjects[0].CellValue(i, "del_chk") == 1) {
					selectedBlNumber = sheetObjects[0]
							.CellValue(i, "bl_number");
					break;
				}
			}
			var sUrl = "/hanjin/ESM_BKG_0458.do?pgmNo=ESM_BKG_0458&bl_no=" + selectedBlNumber + "&callPgm=ESM_BKG_0730";
			// var sUrl = "/hanjin/ESM_BKG_0456.do?bl_no="+selectedBlNumber;
			// ComOpenWindowCenter(sUrl, "ESM_BKG_0458", 1024, 768, false);
			ComOpenWindowCenter(sUrl, "ESM_BKG_0458", 800, 400, false);
		}
		// var sUrl =
		// "/hanjin/ESM_BKG_0456.do?vvd_cd="+formObj.in_vvd_cd.value+"&pod_cd="+formObj.in_pod_cd.value;
		// ComOpenWindowCenter(sUrl, "ESM_BKG_0990", 423, 172, true);
		// ComOpenWindowCenter(sUrl, "ESM_BKG_0990", 1024, 768, true);

		break;

	case IBDELETE: // 입력
		// alert("test1");
		if (validateForm(sheetObj, formObj, sAction)) {
			var delrows = sheetObj.FindCheckedRow("del_chk");
			// alert("test2");
			var arrRow = delrows.split("|");
			// alert("test3");
			for ( var i = 0; i < arrRow.length - 1; i++) {
				sheetObj.RowHidden(arrRow[i]) = true;
				sheetObj.RowStatus(arrRow[i]) = "D";
			}
		}
		// alert("test4");
		break;

	}
}

/**
* BackEndJob 처리
* @param sheetObj Sheet
* @param sKey sKey
*/
function doActionValidationResult(sheetObj, sKey) {
	 sheetObjects[0].WaitImageVisble = false;
	 var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0730GS.do?f_cmd=" + SEARCH03
			+ "&key=" + sKey);
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
		//ComShowCodeMessage('BKG00204');
		ComShowMessage(ComResultMessage(sXml));
		// sheet1, sheet2 다시 조회
		state = sheetObj.EtcData("TRANS_RESULT_KEY");

		if (state == "S") {
			doActionIBSheet(sheetObj, document.form, IBSEARCH);
		}	
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
 * 팝업창에서 부모창 retrieve
 */
function retrieve() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}



/**
* Sheet에서 클랙했을시 체크박스 처리
* @param sheetObj Sheet
* @param row row
* @param col col
*/
function sheet1_OnClick(sheetObj, row, col) {

	var rowCnt = sheetObj.RowCount;
	var check = sheetObj.CellValue(row, "del_chk");
	var keyBlNo = sheetObj.CellValue(row, "bl_number");
	var colSaveName = sheetObj.ColSaveName(col);

	for (i = 2; i <= rowCnt + 2; i++) {

		if (colSaveName == "del_chk") {

			if (check == 0) {

				if (i == row)
					continue;

				if (keyBlNo == sheetObj.CellValue(i, "bl_number")) {
					sheetObj.CellValue(i, "del_chk") = 1;
				}

			} else if (check == 1) {

				if (i == row)
					continue;

				if (keyBlNo == sheetObj.CellValue(i, "bl_number")) {
					sheetObj.CellValue(i, "del_chk") = 0;
				}

			}
		}

	} // end for(i)

}

 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  * @param sheetObj Sheet
  * @param formObj form객체
  * @param sAction 작업처리코드
  */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00262');
			formObj.in_vvd_cd.focus();
			return false;
		}

		if (formObj.in_pod_cd.value == ""
				|| formObj.in_pod_cd.value.length != 5) {
			ComShowCodeMessage('BKG00262');
			formObj.in_pod_cd.focus();
			return false;
		}

		return true;
		break;
	case COMMAND01:
		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00262');
			formObj.in_vvd_cd.focus();
			return false;
		}

		if (formObj.in_pod_cd.value == ""
				|| formObj.in_pod_cd.value.length != 5) {
			ComShowCodeMessage('BKG00262');
			formObj.in_pod_cd.focus();
			return false;
		}

		return true;
		break;

	case COMMAND02:

		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00262');
			formObj.in_vvd_cd.focus();
			return false;
		}
	
		if (formObj.in_pod_cd.value == ""
				|| formObj.in_pod_cd.value.length != 5) {
			ComShowCodeMessage('BKG00262');
			formObj.in_pod_cd.focus();
			return false;
		}
		
		if (formObj.in_voyage_no.value == "" ) {
			ComShowCodeMessage('BKG02115');// "Please input Voyage number."
			formObj.in_voyage_no.focus();
			return false;
		}
		
		// 삭제하고 저장 안한게 있는지 체크한다
		var vIsCheck2 = false;
		for ( var i = 2; i <= sheetObj.RowCount + 1; i++) {
			if (sheetObj.RowStatus(i) == "D") {
				vIsCheck2 = true;
				break;
			}
		}
		if (vIsCheck2) {
			ComShowCodeMessage("BKG00178");
			return false;
		}

		if (!ComShowCodeConfirm("BKG00263", formObj.in_vvd_cd.value,
				formObj.in_pod_cd.value)) {
			return false;
		}
		return true;
		break;
		
	case COMMAND12:

		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00262');
			formObj.in_vvd_cd.focus();
			return false;
		}
	
		if (formObj.in_pod_cd.value == ""
				|| formObj.in_pod_cd.value.length != 5) {
			ComShowCodeMessage('BKG00262');
			formObj.in_pod_cd.focus();
			return false;
		}
		
		if (formObj.in_voyage_no.value == "" ) {
			ComShowCodeMessage('BKG02115');// "Please input Voyage number."
			formObj.in_voyage_no.focus();
			return false;
		}
		
		// 삭제하고 저장 안한게 있는지 체크한다
		var vIsCheck2 = false;
		for ( var i = 2; i <= sheetObj.RowCount + 1; i++) {
			if (sheetObj.RowStatus(i) == "D") {
				vIsCheck2 = true;
				break;
			}
		}
		if (vIsCheck2) {
			ComShowCodeMessage("BKG00178");
			return false;
		}

		if (!ComShowCodeConfirm("BKG00263", formObj.in_vvd_cd.value,
				formObj.in_pod_cd.value)) {
			return false;
		}
		return true;
		break;	

	case COMMAND03:
		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00262');
			formObj.in_vvd_cd.focus();
			return false;
		}

		if (formObj.in_pod_cd.value == ""
				|| formObj.in_pod_cd.value.length != 5) {
			ComShowCodeMessage('BKG00262');
			formObj.in_pod_cd.focus();
			return false;
		}
		return true;
		break;

	case COMMAND04:
		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00262');
			formObj.in_vvd_cd.focus();
			return false;
		}

		if (formObj.in_pod_cd.value == ""
				|| formObj.in_pod_cd.value.length != 5) {
			ComShowCodeMessage('BKG00262');
			formObj.in_pod_cd.focus();
			return false;
		}
		var blNumber = "";
		for ( var i = 2; i <= sheetObj.RowCount + 1; i++) {
			if (sheetObj.CellValue(i, "del_chk") == 1) {
				// alert(blNumber);
				if (blNumber == "") {
					blNumber = sheetObj.CellValue(i, "bl_number");
				} else {
					if (blNumber != sheetObj.CellValue(i, "bl_number")) {
						ComShowCodeMessage('BKG01002');
						return false;
					}
				}

			}
		}
		if (blNumber == "") {
			ComShowCodeMessage('BKG01002');
			return false;
		}

		return true;
		break;

	case COMMAND05:
		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00262');
			formObj.in_vvd_cd.focus();
			return false;
		}

		if (formObj.in_pod_cd.value == ""
				|| formObj.in_pod_cd.value.length != 5) {
			ComShowCodeMessage('BKG00262');
			formObj.in_pod_cd.focus();
			return false;
		}
		var blNumber = "";
		for ( var i = 2; i <= sheetObj.RowCount + 1; i++) {
			if (sheetObj.CellValue(i, "del_chk") == 1) {
				// alert(blNumber);
				if (blNumber == "") {
					blNumber = sheetObj.CellValue(i, "bl_number");
				} else {
					if (blNumber != sheetObj.CellValue(i, "bl_number")) {
						ComShowCodeMessage('BKG01002');
						return false;
					}
				}

			}
		}
		if (blNumber == "") {
			ComShowCodeMessage('BKG01002');
			return false;
		}

		return true;
		break;

	case COMMAND06:
		if (formObj.in_vvd_cd.value == ""
				|| formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00262');
			formObj.in_vvd_cd.focus();
			return false;
		}

		if (formObj.in_pod_cd.value == ""
				|| formObj.in_pod_cd.value.length != 5) {
			ComShowCodeMessage('BKG00262');
			formObj.in_pod_cd.focus();
			return false;
		}
		var blNumber = "";
		for ( var i = 2; i <= sheetObj.RowCount + 1; i++) {
			if (sheetObj.CellValue(i, "del_chk") == 1) {
				// alert(blNumber);
				if (blNumber == "") {
					blNumber = sheetObj.CellValue(i, "bl_number");
				} else {
					if (blNumber != sheetObj.CellValue(i, "bl_number")) {
						ComShowCodeMessage('BKG01002');
						return false;
					}
				}

			}
		}
		if (blNumber == "") {
			ComShowCodeMessage('BKG01002');
			return false;
		}

		return true;
		break;
	case IBDELETE: // 조회
		var vIsCheck = false;
		//alert(sheetObj.RowCount);
		for(var i=2; i <= sheetObj.RowCount+1; i++) {
			if (sheetObj.CellValue(i, "del_chk") == 1) {
				vIsCheck = true;
				break;
			}
		}
		if (!vIsCheck) {
			ComShowCodeMessage('BKG00249','');
			return false;
		}	
		
		if (!ComShowCodeConfirm("COM12188")) {
			return false;
		}		
		return true;
		break;			
	}
}
/* 개발자 작업 끝 */