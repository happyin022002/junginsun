/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_TOT_0017.js
 *@FileTitle : TOT
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.30
 *@LastModifier : 장창수
 *@LastVersion : 1.0
 * 2009.06.30 장창수
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
 * @class fns_tot_017 : fns_tot_017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function fns_tot_0017() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.setComboObject = setComboObject;
}

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;
var closing_yn = "N";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];
	var sheetObject3 = sheetObjects[2];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;

		case "btn_new":
			setDate();
			setCloseYn();
			sheetObject1.RemoveAll();
			break;

		case "btn_downexcel":
			sheetObject1.SpeedDown2Excel(-1);
			break;

		case "btn_save":
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;
		case "btns_back":

			if (formObject.stl_yrmon.value == null
					|| formObject.stl_yrmon.value == "") {
				ComShowCodeMessage('TOT00003');
				return;
			}
			formObject.stl_yrmon.value = ComGetDateAdd(
					formObject.stl_yrmon.value + "-01", "M", -1)
					.substring(0, 7);
			setCloseYn();

			break;

		case "btns_next":

			if (formObject.stl_yrmon.value == null
					|| formObject.stl_yrmon.value == "") {
				ComShowCodeMessage('TOT00003');
				return;
			}
			formObject.stl_yrmon.value = ComGetDateAdd(
					formObject.stl_yrmon.value + "-01", "M", 1).substring(0, 7);
			setCloseYn();

			break;

		case "btn_detaildown":
			doActionIBSheet(sheetObject3, formObject, IBSEARCH_ASYNC01);
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
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {

	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObject = document.form;

	//Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate', form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListener('blur', 'stl_yrmon_onblur', 'stl_yrmon');//- customer code 입력 후 name 가져오기
	axon_event.addListenerFormat('keyup', 'form_keyup', formObject);

}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_deactivate() {
	ComChkObjValid(event.srcElement);
}

function obj_activate() {
	ComClearSeparator(event.srcElement);
}

function obj_keypress() {
	switch (event.srcElement.dataformat) {
	case "ym":
		//숫자+"."입력하기
		ComKeyOnlyNumber(event.srcElement, "-");
		break;
	case "engup":

		ComKeyOnlyAlphabet('upper');
		break;

	}
}

function form_keyup() {
	ComKeyEnter('lengthnextfocus');
}

/*
 * 조건 년도가 마감 되었는지 여부를  조회하여 저장버튼을 활성또는 비활성 한다.
 */

function setCloseYn() {

	var formObj = document.form;

	var stlYr = formObj.stl_yrmon.value;

	formObj.f_cmd.value = SEARCHLIST02;
	
	var sXml = sheetObjects[1].GetSearchXml("FNS_TOT_0017GS.do", FormQueryString(formObj));

	var closing_yn = ComGetEtcData(sXml, "stlClzFlg");
//  2012-09-10 CHM-201220130
//	var jbEndDt    = ComGetEtcData(sXml, "jbEndDt");
	
//	formObj.jb_end_dt.value = jbEndDt;
	if (closing_yn == "Y") {
		ComBtnDisable("btn_save");
	} else {
		ComBtnEnable("btn_save");
	}
	sheetObjects[0].RemoveAll();

}

function setDate() {
	var today = new Date();
	var y = today.getFullYear().toString();
	var m = today.getMonth();

	if (m < 10) {
		m = "0" + m;
	}

	document.form.stl_yrmon.value = y + "-" + m;
}

//stl_yrmon 변경시 조회 
function stl_yrmon_onblur() {

	var formObject = document.form;

	if (formObject.stl_yrmon.value == null || formObject.stl_yrmon.value == "") {

		ComShowCodeMessage('TOT00003');
		ComSetFocus(formObject.stl_yrmon);

		return false;
	}

	setCloseYn();
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
function loadPage(stlClzFlg) {

	//IBSheet 초기화하기
	for (i = 0; i < sheetObjects.length; i++) {

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);

		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();

	closing_yn = stlClzFlg;

	if (closing_yn == "Y") {
		ComBtnDisable("btn_save");
	} else {
		ComBtnEnable("btn_save");
	}

}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // t1sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 430;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 10, 100);

			var HeadTitle1 = "|Seq.|Vessel Name|NRT|Load TEU|Actual TEU|USE(%)|Duration|Duration|Operation\n Ton/Month|Taxable Amount|||||||||";
			var HeadTitle2 = "|Seq.|Vessel Name|NRT|Load TEU|Actual TEU|USE(%)|POL_DATE|POD_DATE|Operation\n Ton/Month|Taxable Amount|||||||||";

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			var prefix = "sheet1_";

			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,
					prefix + "ibflag");
			InitDataProperty(0, cnt++, dtSeq, 40, daCenter, true, "Seq");
			InitDataProperty(0, cnt++, dtData, 115, daCenter, true, prefix
					+ "vsl_cd", false, "", dfNone, 0, false, false, 8);
			InitDataProperty(0, cnt++, dtAutoSum, 110, daRight, true, prefix
					+ "nrt_wgt", false, "", dfInteger, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtAutoSum, 90, daRight, true, prefix
					+ "bsa_capa", false, "", dfInteger, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtAutoSum, 95, daRight, true, prefix
					+ "act_bsa_capa", false, "", dfInteger, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtAutoSum, 75, daRight, true, prefix
					+ "usg_rt", false, "", dfNullFloat, 2, false, false, 2);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix
					+ "fm_vvd_stl_dt", false, "", dfDateYmd, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix
					+ "to_vvd_stl_dt", false, "", dfDateYmd, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtAutoSum, 130, daRight, true, prefix
					+ "nrt_tong_tax_amt", false, "", dfInteger, 0, false,
					false, 10);
			InitDataProperty(0, cnt++, dtAutoSum, 90, daRight, true, prefix
					+ "tong_tax_amt", false, "", dfInteger, 0, false, false, 15);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "stl_yrmon", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "tong_stl_bat_jb_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "ldb_capa_qty", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "per_ton_rev", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "tong_flet_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "voy_dys", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "vsl_dznd_capa", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "chtr_bsa_capa", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "vvd_exist_yn", false, "", dfNone, 0, false, false);

		}
		break;
	case 2: // t1sheet2 init
		with (sheetObj) {
			// 높이 설정
			style.height = 0;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 10, 100);

			var HeadTitle1 = "|Seq.|Vessel Name|NRT|Load TEU|Actual TEU|USE(%)|Duration|Duration|Operation\n Ton/Month|Taxable Amount|||||||||";
			var HeadTitle2 = "|Seq.|Vessel Name|NRT|Load TEU|Actual TEU|USE(%)|POL_DATE|POD_DATE|Operation\n Ton/Month|Taxable Amount|||||||||";

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			var prefix = "sheet2_";

			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,
					prefix + "ibflag");
			InitDataProperty(0, cnt++, dtSeq, 40, daCenter, true, "Seq");
			InitDataProperty(0, cnt++, dtData, 115, daCenter, true, prefix
					+ "vsl_cd", false, "", dfNone, 0, false, false, 8);
			InitDataProperty(0, cnt++, dtAutoSum, 110, daRight, true, prefix
					+ "nrt_wgt", false, "", dfInteger, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtAutoSum, 90, daRight, true, prefix
					+ "bsa_capa", false, "", dfInteger, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtAutoSum, 95, daRight, true, prefix
					+ "act_bsa_capa", false, "", dfInteger, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtAutoSum, 75, daRight, true, prefix
					+ "usg_rt", false, "", dfNullFloat, 2, false, false, 2);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix
					+ "fm_vvd_stl_dt", false, "", dfDateYmd, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix
					+ "to_vvd_stl_dt", false, "", dfDateYmd, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtAutoSum, 130, daRight, true, prefix
					+ "nrt_tong_tax_amt", false, "", dfInteger, 0, false,
					false, 10);
			InitDataProperty(0, cnt++, dtAutoSum, 90, daRight, true, prefix
					+ "tong_tax_amt", false, "", dfInteger, 0, false, false, 15);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "stl_yrmon", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "tong_stl_bat_jb_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "ldb_capa_qty", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "per_ton_rev", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "tong_flet_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "voy_dys", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "vsl_dznd_capa", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "chtr_bsa_capa", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "vvd_exist_yn", false, "", dfNone, 0, false, false);

		}
		break;

	case 3: // t1sheet3 init Detail Down
		with (sheetObj) {
			// 높이 설정
			style.height = 0;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 10, 100);

			var HeadTitle1 = "|Seq.|Vessel Name|Vessel Voyage Direction|NRT|Load TEU|Actual TEU|USE(%)|POL_DATE|POD_DATE|Operation\n Ton/Month|Taxable Amount|||||||||";

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			var prefix = "sheet2_";

			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,
					prefix + "ibflag");
			InitDataProperty(0, cnt++, dtSeq, 40, daCenter, true, "Seq");
			InitDataProperty(0, cnt++, dtData, 115, daCenter, true, prefix
					+ "vsl_cd", false, "", dfNone, 0, false, false, 8);
			InitDataProperty(0, cnt++, dtData, 115, daCenter, true, prefix
					+ "vvd_cd", false, "", dfNone, 0, false, false, 8);
			InitDataProperty(0, cnt++, dtAutoSum, 110, daRight, true, prefix
					+ "nrt_wgt", false, "", dfInteger, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtAutoSum, 90, daRight, true, prefix
					+ "bsa_capa", false, "", dfInteger, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtAutoSum, 95, daRight, true, prefix
					+ "act_bsa_capa", false, "", dfInteger, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtAutoSum, 75, daRight, true, prefix
					+ "usg_rt", false, "", dfNullFloat, 2, false, false, 2);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix
					+ "fm_vvd_stl_dt", false, "", dfDateYmd, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix
					+ "to_vvd_stl_dt", false, "", dfDateYmd, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtAutoSum, 130, daRight, true, prefix
					+ "nrt_tong_tax_amt", false, "", dfInteger, 0, false,
					false, 10);
			InitDataProperty(0, cnt++, dtAutoSum, 90, daRight, true, prefix
					+ "tong_tax_amt", false, "", dfInteger, 0, false, false, 15);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "stl_yrmon", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "tong_stl_bat_jb_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "ldb_capa_qty", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "per_ton_rev", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "tong_flet_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "voy_dys", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "vsl_dznd_capa", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "chtr_bsa_capa", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix
					+ "vvd_exist_yn", false, "", dfNone, 0, false, false);

		}
		break;
		
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var prefix = "sheet1_";
	switch (sAction) {
	case IBSEARCH: //조회
		if (validateForm(sheetObj, formObj, sAction)) {

			if (sheetObj.id == "sheet1") {
				formObj.f_cmd.value = SEARCH;
				//prefix 문자열 배열
				var prefix = "sheet1_";
				var sXml = sheetObj.GetSearchXml("FNS_TOT_0017GS.do",
						FormQueryString(formObj) + "&"
								+ ComGetPrefixParam(prefix));

				sheetObjects[0].LoadSearchXml(sXml);

				if (sheetObjects[0].LastRow > 2) {
					sheetObjects[0].CellValue2(2, 2) = "TOTAL : ";

					if (closing_yn == "Y") {
						ComBtnDisable("btn_save");
					} else {
						if (sheetObjects[0].CellValue(3, 19) == "Y") {
							ComBtnDisable("btn_save");
						} else {
							ComBtnEnable("btn_save");
						}
					}
				} else {
					ComBtnDisable("btn_save");

				}

			}

		}

		break;

	case IBSEARCH_ASYNC01: //Detail Down
		if (validateForm(sheetObj, formObj, sAction)) {
			

			if (sheetObj.id == "sheet3") {
				formObj.f_cmd.value = SEARCHLIST03;
				ComOpenWait(true);
				//prefix 문자열 배열
				var prefix = "sheet2_";
				var sXml = sheetObj.GetSearchXml("FNS_TOT_0017GS.do",FormQueryString(formObj) + "&"+ ComGetPrefixParam(prefix));

				sheetObjects[2].LoadSearchXml(sXml);
				if (sheetObjects[2].LastRow > 1) {
					sheetObjects[2].SpeedDown2Excel(-1);
				}
				ComOpenWait(false);
			}
		}

		break;
		
	case IBSAVE: //저장
		if (closing_yn == "N") {
			if (validateForm(sheetObj, formObj, sAction)) {

				for ( var inx = 3; inx <= sheetObj.LastRow; inx++) {
					//alert(sheetObj.CellValue(inx,prefix+"vsl_cd"));
					sheetObj.CellValue2(inx, prefix + "ibflag") = "I";
				}

				var SaveStr = ComGetSaveString(sheetObjects);
				if (SaveStr == "") {
					ComShowCodeMessage('TOT00011');
					return;
				}

				if (!ComShowCodeConfirm('TOT00004')) {
					return;
				}

				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;

				var aryPrefix = new Array("sheet1_"); //prefix 문자열 배열	
				var sXml = sheetObj.GetSaveXml("FNS_TOT_0017GS.do", SaveStr
						+ "&" + FormQueryString(formObj) + "&"
						+ ComGetPrefixParam(aryPrefix));
				sheetObj.LoadSaveXml(sXml);
				ComOpenWait(false);
			}
		}
		break;

	case IBINSERT: // 입력
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var formObject = document.form;
	var prefix = "sheet1_";

	switch (sAction) {

	case IBSEARCH: //조회
		if (formObject.stl_yrmon.value == null
				|| formObject.stl_yrmon.value == "") {
			ComShowCodeMessage('TOT00003');
			ComSetFocus(formObject.stl_yrmon);
			return false;
		}

		break;
	case IBSEARCH_ASYNC01: //Detail Down
		if (formObject.stl_yrmon.value == null
				|| formObject.stl_yrmon.value == "") {
			ComShowCodeMessage('TOT00003');
			ComSetFocus(formObject.stl_yrmon);
			return false;
		}

		break;
	case IBSAVE: //저장

		break;
	default:
		break;
	}
	return true;

}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		AutoSumBottom = false;
		SumText(0, "Seq") = "";
		SumText(0, "Name") = "Total : ";
	}
}