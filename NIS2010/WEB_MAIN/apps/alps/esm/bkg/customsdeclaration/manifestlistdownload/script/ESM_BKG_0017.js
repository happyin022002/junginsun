/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0017.js
 *@FileTitle : ESM_BKG-0017
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.04.21 김승민
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
 * @class ESM_BKG-0017 : ESM_BKG-0017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0017() {
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
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			// doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			// doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
			// doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
			break;

		case "btn_transmit":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
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

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}

	initControl();
	document.form.vvd_cd.focus();
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
	// axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate',
	// formObject); //- 포커스 나갈때
	// axon_event.addListenerFormat('beforeactivate', 'obj_activate',
	// formObject); //- 포커스 들어갈때
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // -
	// 키보드
	// 입력할때
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	ComBtnDisable("btn_transmit");

	if (document.form.vvd_cd.value != "")
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
	default:
		// 숫자만입력하기(정수,날짜,시간)
		ComKeyOnlyNumber(event.srcElement);
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
	case "t1sheet1": // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 260;
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
			InitRowInfo(1, 1, 2, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(9, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle1 = "|Seq.|CNTR No.|TP/SZ|Weight(MTN)|DESC|B/L No.|POL|POD";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false,
					"ibflag");
			InitDataProperty(0, cnt++, dtSeq, 40, daCenter, true, "seq");
			InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "cntr_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 85, daCenter, true,
					"cntr_tpsz_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 150, daRight, true, "value1",
					false, "", dfNullFloat, 3, false, false);
			InitDataProperty(0, cnt++, dtData, 290, daLeft, true, "value2",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "bl_no",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "pol_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "pod_cd",
					false, "", dfNone, 0, false, false);

		}
		break;

	case "t2sheet1": // t2sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 140;
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
			InitRowInfo(1, 1, 2, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(5, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle1 = "|Seq.|Total|Deck Loc|Type/Size";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false,
					"ibflag");
			InitDataProperty(0, cnt++, dtSeq, 40, daCenter, true, "seq");
			InitDataProperty(0, cnt++, dtData, 220, daRight, true,
					"x_mt_total", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 320, daCenter, true, "x_mt_loc",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 340, daCenter, true, "x_mt_ts",
					false, "", dfNone, 0, false, false);

		}
		break;

	case "t3sheet1": // t3sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 160;
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
			InitRowInfo(1, 1, 2, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(11, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle1 = "|Seq.|CNTR No.|TYPE/SIZE|UN No.|IMO Class|IMO COMP GRP|Flash Point|Weight(MTN)|POL|POD";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false,
					"ibflag");
			InitDataProperty(0, cnt++, dtSeq, 40, daCenter, true, "seq");
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "cntr_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, true,
					"cntr_tpsz_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true,
					"imdg_un_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 115, daCenter, true,
					"imdg_clss_cd", false, "", dfNullFloat, 1, false, false);

			InitDataProperty(0, cnt++, dtData, 150, daCenter, true,
					"imdg_co_grp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 115, daCenter, true,
					"flsh_pnt_cdo_temp", false, "", dfNullFloat, 1, false,
					false);
			InitDataProperty(0, cnt++, dtData, 145, daCenter, true, "value1",
					false, "", dfNullFloat, 3, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "pol_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "pod_cd",
					false, "", dfNone, 0, false, false);

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

		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.vsl_cd.value = formObj.vvd_cd.value.substring(0, 4);
			formObj.skd_voy_no.value = formObj.vvd_cd.value.substring(4, 8);
			formObj.skd_dir_cd.value = formObj.vvd_cd.value.substring(8);

			if (formObj.error_yn_temp(0).checked)
				formObj.error_yn.value = "";
			else
				formObj.error_yn.value = "ERROR";
			// alert(formObj.error_yn.value)

			var sXml = sheetObj.GetSearchXml("ESM_BKG_0017GS.do",
					FormQueryString(formObj));

			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0) {
				sheetObjects[0].LoadSearchXml(arrXml[0]);
			}
			if (arrXml.length > 1) {
				sheetObjects[1].LoadSearchXml(arrXml[1]);
			}
			if (arrXml.length > 2) {
				sheetObjects[2].LoadSearchXml(arrXml[2]);
			}

			state = sheetObj.EtcData("TRANS_RESULT_KEY");

			if (state == "S") {
				if (document.form.error_yn_temp(0).checked
						&& sheetObjects[0].RowCount > 1) {
					ComBtnEnable("btn_transmit");
				} else {
					ComBtnDisable("btn_transmit");
				}
			}

			// formObj.shp_id_no.value = sheetObj.EtcData("shp_id_no");
			ComEtcDataToForm(formObj, sheetObj);
			formObj.pnm_org_cd_temp.value = getCodeName(formObj,
					formObj.pnm_org_cd.value);
			formObj.pnm_dest_cd_temp.value = getCodeName(formObj,
					formObj.pnm_dest_cd.value);
			ComOpenWait(false);
		}

		break;

	case IBSAVE: // 저장
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.vsl_cd.value = formObj.vvd_cd.value.substring(0, 4);
			formObj.skd_voy_no.value = formObj.vvd_cd.value.substring(4, 8);
			formObj.skd_dir_cd.value = formObj.vvd_cd.value.substring(8);
			formObj.f_cmd.value = MULTI;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);

			var sParam = "";
			var sParamSheet2 = sheetObjects[0].GetSaveString();
			if (sParamSheet2 != "") {
				sParam += "&" + ComSetPrifix(sParamSheet2, "");
			}
			sParam += "&" + FormQueryString(formObj);
			// alert("sParam"+sParam);

			var sXml = sheetObj.GetSaveXml("ESM_BKG_0017GS.do", sParam);
			// sheetObj.DoAllSave("ESM_BKG_0723GS.do",
			// FormQueryString(formObj));
			var key = ComGetEtcData(sXml, "KEY");
			ComOpenWait(true);
			intervalId = setInterval(
					"doActionValidationResult(sheetObjects[0], '" + key + "');",
					3000);

			// sheetObj.DoSearch("ESM_BKG_0017GS.do", FormQueryString(formObj));

			// formObj.flatFile.value=sheetObj.EtcData("flatFile");
		}

		break;

	case IBINSERT: // 입력
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
	var sXml = sheetObj.GetSearchXml("ESM_BKG_0017GS.do?f_cmd=" + SEARCH03
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
		ComShowCodeMessage('BKG00204');
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		// ComShowMessage(ComResultMessage(sXml));
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
 * IBTab Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}

/**
 * Tab 기본 설정 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertTab(cnt++, "General Cargo Info", -1);
			InsertTab(cnt++, "Empty Container Info", -1);
			InsertTab(cnt++, "Hazardous Cargo Info", -1);
		}
		break;

	}
}

/**
 * Tab 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {
	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	// --------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab = nItem;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if (formObj.vvd_cd.value == "") {
			ComShowCodeMessage('BKG00115');
			formObj.vvd_cd.focus();
			return false;
		}
		if (formObj.vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00115');
			formObj.vvd_cd.focus();
			return false;
		}
		return true;
		break;
	case IBSAVE: // 조회
		if (formObj.error_yn_temp(0).checked) {
			ComBtnEnable("btn_transmit");
		} else {
			ComBtnDisable("btn_transmit");
			return false;
		}
		if (formObj.vvd_cd.value == "") {
			ComShowCodeMessage('BKG00115');
			formObj.vvd_cd.focus();
			return false;
		}
		if (formObj.vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00115');
			formObj.vvd_cd.focus();
			return false;
		}
		if (formObj.vst_no.value == "") {
			ComShowCodeMessage('BKG00116');
			formObj.vvd_cd.focus();
			return false;
		}
		if (formObj.mvmt_seq.value.length == "") {
			ComShowCodeMessage('BKG00117');
			formObj.vvd_cd.focus();
			return false;
		}
		if (formObj.pnm_vsl_opr_cd.value == "") {
			ComShowCodeMessage('BKG00118');
			formObj.vvd_cd.focus();
			return false;
		}
		if (formObj.pnm_org_cd.value.length == "") {
			ComShowCodeMessage('BKG00119');
			formObj.vvd_cd.focus();
			return false;
		}
		if (formObj.pnm_dest_cd.value == "") {
			ComShowCodeMessage('BKG00120');
			formObj.vvd_cd.focus();
			return false;
		}
		if (formObj.slan_cd.value.length == ""
				|| formObj.vps_eta_dt.value.length == ""
				|| formObj.pod_cd.value.length == ""
				|| formObj.pol_cd.value.length == "") {
			ComShowCodeMessage('BKG00115');
			formObj.vvd_cd.focus();
			return false;
		}
		return true;
		break;
	}
}

/**
 * 코드에 대한 해당 Name을 세팅한다
 * @param formObj formObj
 * @param Value Value
 */
function getCodeName(formObj, value) {
	var codeName = "";
	switch (value) {
	case "00":
		codeName = "[" + value + "]UNKNOWN";
		break;
	case "A0":
		codeName = "[" + value + "]AROUND THE WORLD";
		break;
	case "A1":
		codeName = "[" + value + "]EAST COAST OF THE UNITED STATES";
		break;
	case "A2":
		codeName = "[" + value + "]EAST COAST OF CANADA";
		break;
	case "A3":
		codeName = "[" + value + "]EAST COAST OF CENTRAL AMERICA";
		break;
	case "A4":
		codeName = "[" + value + "]EAST COAST OF SOUTH AMERICA";
		break;
	case "A5":
		codeName = "[" + value + "]CRISTOBAL, REPUBLIC OF PANAMA";
		break;
	case "A6":
		codeName = "[" + value + "]WEST INDIES";
		break;
	case "A7":
		codeName = "[" + value + "]EUROPE";
		break;
	case "A8":
		codeName = "[" + value + "]AFRICA";
		break;
	case "A9":
		codeName = "[" + value + "]ASIA AND THE MIDDLE EAST";
		break;
	case "P0":
		codeName = "[" + value + "]AROUTE THE WORLD";
		break;
	case "P1":
		codeName = "[" + value + "]WEST COAST OF THE UNITED STATES";
		break;
	case "P2":
		codeName = "[" + value + "]WEST COAST OF CANADA";
		break;
	case "P3":
		codeName = "[" + value + "]WEST COAST OF CENTRAL AMERICA";
		break;
	case "P4":
		codeName = "[" + value + "]WEST COAST OF SOUTH AMERICA";
		break;
	case "P5":
		codeName = "[" + value + "]CRISTOBAL, REPUBLIC OF PANAMA";
		break;
	case "P6":
		codeName = "[" + value + "]HAWAII";
		break;
	case "P7":
		codeName = "[" + value + "]OCEANIA";
		break;
	case "P8":
		codeName = "[" + value + "]ANTARTICA";
		break;
	case "P9":
		codeName = "[" + value + "]ASIA";
		break;
	}

	return codeName;
}

/**
 * 구분값에 따른 전송버트 처리
 * @param gubun gubun
 */
function checkTransmit(gubun) {
	if (gubun == "1")
		ComBtnEnable("btn_transmit");
	else
		ComBtnDisable("btn_transmit");
}

/* 개발자 작업 끝 */