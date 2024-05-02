/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_TOT_0011.js
 *@FileTitle : TOT
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.09
 *@LastModifier : 장창수
 *@LastVersion : 1.0
 * 2009.06.09 장창수
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
 * @class fns_tot_011 : fns_tot_011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function fns_tot_0011() {
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

/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var closing_yn = "N";;
var comboObjects = new Array();
var comboCnt = 0;
var saveYn = "N";
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn1_Retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;
		case "btn1_Detail":
			openPopup();

			break;
		case "btn1_New":
			setDate();
			formObject.trd_cd.value = "";
			formObject.total_txt_amt.value = "";

			sheetObjects[0].RemoveAll();
			comboObjects[0].index = -1;
			ComBtnDisable("btn1_Save");
			break;

		case "btn1_Save":
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
			formObject.total_txt_amt.value = "";
			setCfmCheck();

			setCloseYn();
			if (formObject.trd_cd.Code == "ALL") {
				ComBtnDisable("btn1_Save");
			}
			break;

		case "btns_next":

			if (formObject.stl_yrmon.value == null
					|| formObject.stl_yrmon.value == "") {
				ComShowCodeMessage('TOT00003');
				return;
			}
			formObject.stl_yrmon.value = ComGetDateAdd(
					formObject.stl_yrmon.value + "-01", "M", 1).substring(0, 7);
			document.form.total_txt_amt.value = "";
			setCfmCheck();
			setCloseYn();
			if (formObject.trd_cd.Code == "ALL") {
				ComBtnDisable("btn1_Save");
			}
			break;
		case "btn1_Down_Excel":

			sheetObject1.SpeedDown2Excel(-1);

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
 * Summary Preview 버튼 클릭시 팝업호출
 */
function openPopup() {
	//alert("openPopup START  : " + sheetObjects[0].SelectRow);
	if (sheetObjects[0].SelectRow == -1) {
		ComShowCodeMessage('TOT00035');
		return;
	}
	var formObject = document.form;

	var stl_yrmon = formObject.stl_yrmon.value;
	var trd_cd = formObject.trd_cd.Code;
	var vsl_cd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,
			"sheet1_vsl_cd");

	var param = "?stl_yrmon=" + stl_yrmon + "&trd_cd=" + trd_cd + "&vsl_cd="
			+ vsl_cd + "&modify_yn=Y";

	ComOpenPopup('/hanjin/FNS_TOT_0012.do' + param, 950, 400,
			'setCntInfoInSheet', "1,0,1,1,1,1,1", false);

}

function setCntInfoInSheet() {
	//alert("ddd");
	var sheetObject1 = sheetObjects[0];
	var formObject = document.form;

	doActionIBSheet(sheetObject1, formObject, IBSEARCH);
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage(bsaTrdList, stlClzFlg) {

	//IBSheet 초기화하기
	for (i = 0; i < sheetObjects.length; i++) {

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);

		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	initCombo(comboObjects[0], 1, bsaTrdList);
	initControl();
	closing_yn = stlClzFlg;

	ComBtnDisable("btn1_Save");

	var formObject = document.form;
	if (formObject.fromPg.value == "Y") {

		formObject.trd_cd.Code = formObject.pgTrdCd.value;
		formObject.stl_yrmon.value = formObject.pgStlYrmon.value;

		setCfmCheck();
		doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);

		var prefix = "sheet1_"
		for ( var inx = 1; inx <= sheetObjects[0].LastRow; inx++) {
			if (formObject.pgVslCd.value == sheetObjects[0].CellValue(inx,
					prefix + "vsl_cd")) {
				sheetObjects[0].SelectCell(inx, prefix + "vsl_cd", true);

			}

		}

	}

}

/** 
 * IBCombo Object를 배열로 등록
 * param : combo_obj ==> 콤보오브젝트
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
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
	}
}

function form_keyup() {
	ComKeyEnter('lengthnextfocus');
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */
function initCombo(comboObj, comboNo, bsaTrdList) {
	var formObject = document.form

	switch (comboNo) {
	case 1:
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left|left");
			SetColWidth("0|30");

			DropHeight = 160;
		}
		//alert(bsaTrdList);

		var comboItemsValue = bsaTrdList.split("|");
		var comboItemsText = bsaTrdList.split("|");

		//alert("길이 : "+comboItemsValue.length);
		for ( var i = 0; i <= comboItemsValue.length; i++) {

			if (i == 0) {
				// addComboItem(comboObj, 0, "ALL", " "); 
				comboObj.InsertItem(i, "" + "|" + "", "ALL");
			} else {
				// alert("가기전 : "+comboItemsValue[i-1]);
				comboObj.InsertItem(i, comboItemsText[i - 1] + "|"
						+ comboItemsText[i - 1], comboItemsValue[i - 1]);
				//addComboItem(comboObj, i, comboItemsValue[i-1], comboItemsText[i-1]); 
			}
		}
		//2010.05.18 권상준 수석 요청 XXX 삭제
		//comboObj.InsertItem(comboItemsValue.length + 1, "XXX|XXX", "XXX");
		comboObj.index = 0;
		break;

	}
}

/**
 * 콤보필드에 데이터를 추가해준다.
 */
function addComboItem(comboObj, i, comboItemsValue, comboItemsText) {

	//alert("addComboItem ::::: "+i+"번째  "+comboItemsValue+"        "+comboItemsText);

	comboObj.InsertItem(i, comboItemsText + "|" + comboItemsText,
			comboItemsValue);

}

//trd_cd 변경시 조회 
function trd_cd_OnChange(idx_cd, text) {

	//alert("trd_cd_OnChange : "+text);

	var formObject = document.form;

	setCfmCheck();

	formObject.total_txt_amt.value = "";
	sheetObjects[0].RemoveAll();

}

//stl_yr 변경시 조회 
function stl_yrmon_onblur() {

	//alert("stl_yrmon_onblur");

	var formObject = document.form;

	formObject.total_txt_amt.value = "";

	setCfmCheck();

	if (formObject.stl_yrmon.value == null || formObject.stl_yrmon.value == "") {

		ComShowCodeMessage('TOT00003');
		ComSetFocus(formObject.stl_yrmon);

		return false;
	}

	setCloseYn();

	if (formObject.trd_cd.Code == "ALL") {
		ComBtnDisable("btn1_Save");
	}
}

/** 조건 년도가 마감 되었는지 여부를  조회하여 저장버튼을 활성또는 비활성 한다.
 */

function setCloseYn() {

	var formObj = document.form;

	var stlYr = formObj.stl_yrmon.value;

	formObj.f_cmd.value = SEARCHLIST02;
	var sXml = sheetObjects[1].GetSearchXml("FNS_TOT_0011GS.do", FormQueryString(formObj));

	var closing_yn = ComGetEtcData(sXml, "stlClzFlg");
//  2012-09-10 CHM-201220130
//	var jbEndDt    = ComGetEtcData(sXml, "jbEndDt");
	
//	formObj.jb_end_dt.value = jbEndDt;

	if (closing_yn == "Y") {

		ComBtnDisable("btn1_Save");

	} else {

		ComBtnEnable("btn1_Save");

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

function setCfmCheck() {

	var formObj = document.form;

	formObj.f_cmd.value = SEARCH01;
	var prefix = "sheet2_"; //prefix 문자열 배열

	var sXml = sheetObjects[1].GetSearchXml("FNS_TOT_0011GS.do",
			FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

	//sheetObjects[0].LoadSearchXml(sXml);

	if (ComGetEtcData(sXml, "c_nrt_yn") == "Y") {
		formObj.c_nrt_yn.checked = true;
		formObj.c_nrt_yn.disabled = true;
	} else {
		formObj.c_nrt_yn.checked = false;
		formObj.c_nrt_yn.disabled = false;
	}
	if (ComGetEtcData(sXml, "c_use_yn") == "Y") {
		formObj.c_use_yn.checked = true;
		formObj.c_use_yn.disabled = true;
	} else {
		formObj.c_use_yn.checked = false;
		formObj.c_use_yn.disabled = false;
	}
	if (ComGetEtcData(sXml, "c_day_yn") == "Y") {
		formObj.c_day_yn.checked = true;
		formObj.c_day_yn.disabled = true;
	} else {
		formObj.c_day_yn.checked = false;
		formObj.c_day_yn.disabled = false;
	}

	if (formObj.trd_cd.Code == "ALL") {

		ComBtnDisable("btn1_Save");

	} else {

		ComBtnEnable("btn1_Save");

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
			style.height = 400;

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

			var HeadTitle1 = "|Seq|Trade|LANE|DIV|Vessel|Vessel Name|FLAG|OPR|GRT|NRT|Rev Per\nTon|BUILT|TIME CHARTER|TIME CHARTER|TIME CHARTER|LOAD\nCAPA|SUPPLY\n(BSA)|ACTUAL|USE(%)|DURATION|DURATION|DURATION|Taxable Amount";
			var HeadTitle2 = "|Seq|Trade|LANE|DIV|Vessel|Vessel Name|FLAG|OPR|GRT|NRT|Rev Per\nTon|BUILT|DEL DT|REDEL DT|YEAR|LOAD\nCAPA|SUPPLY\n(BSA)|ACTUAL|USE(%)|START|FINISH|DAYS|Taxable Amount";

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 6, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			var prefix = "sheet1_"

			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,
					"Status");
			InitDataProperty(0, cnt++, dtSeq, 50, daCenter, true, "seq", false,
					"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, prefix
					+ "trd_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, prefix
					+ "slan_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, true, prefix
					+ "vsl_svc_tp_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, prefix
					+ "vsl_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 130, daLeft, true, prefix
					+ "vsl_eng_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, prefix
					+ "vsl_rgst_cnt_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, prefix
					+ "tong_flet_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, prefix
					+ "grs_rgst_tong_wgt", false, "", dfInteger, 0, false,
					false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, prefix
					+ "nrt_wgt", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daRight, true, prefix
					+ "per_ton_rev", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, prefix
					+ "vsl_de_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, prefix
					+ "ctrt_st_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, prefix
					+ "ctrt_end_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daRight, true, prefix
					+ "ctrt_year", false, "", dfFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, prefix
					+ "ldb_capa_qty", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, prefix
					+ "bsa_capa", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, prefix
					+ "act_bsa_capa", false, "", dfInteger, 0, false, false);
			// InitDataProperty(0, cnt++, dtData,			60,			daRight,	true,	prefix+"capa_diff",						false,		"",       dfInteger,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, prefix
					+ "usg_rt", false, "", dfFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, prefix
					+ "fm_vvd_stl_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, prefix
					+ "to_vvd_stl_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daRight, true, prefix
					+ "voy_dys", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daRight, true, prefix
					+ "tong_tax_amt", false, "", dfInteger, 0, false, false);

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

			var HeadTitle1 = "|LANE|Vessel|Vessel Name|FLAG|OPR|GRT|NRT|Rev Per\nTon|BULT|TIME CHARTER|TIME CHARTER|TIME CHARTER|LOAD\nCAPA|SUPPLY\n(BSA)|ACTUAL|CAPA\nDIFF|USE(%)|DURATION|DURATION|DURATION|Taxable Amount";
			var HeadTitle2 = "|LANE|Vessel|Vessel Name|FLAG|OPR|GRT|NRT|Rev Per\nTon|BULT|DEL DT|REDEL DT|YEAR|LOAD\nCAPA|SUPPLY\n(BSA)|ACTUAL|CAPA\nDIFF|USE(%)|START|FINISH|DAYS|Taxable Amount";

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			var prefix = "sheet2_"

			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,
					"Status");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, prefix
					+ "slan_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix
					+ "vsl_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 110, daLeft, true, prefix
					+ "vsl_eng_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, prefix
					+ "vsl_rgst_cnt_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, true, prefix
					+ "tong_flet_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, prefix
					+ "grs_rgst_tong_wgt", false, "", dfInteger, 0, false,
					false);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, prefix
					+ "nrt_wgt", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daRight, true, prefix
					+ "per_ton_rev", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix
					+ "vsl_de_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix
					+ "ctrt_st_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix
					+ "ctrt_end_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daRight, true, prefix
					+ "ctrt_year", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daRight, true, prefix
					+ "ldb_capa_qty", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daRight, true, prefix
					+ "bsa_capa", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daRight, true, prefix
					+ "act_bsa_capa", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daRight, true, prefix
					+ "capa_diff", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daRight, true, prefix
					+ "usg_rt", false, "", dfFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix
					+ "fm_vvd_stl_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix
					+ "to_vvd_stl_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daRight, true, prefix
					+ "voy_dys", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daRight, true, prefix
					+ "tong_tax_amt", false, "", dfInteger, 0, false, false);
		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
	case IBSEARCH: //조회
		if (validateForm(sheetObj, formObj, sAction)) {

			if (sheetObj.id == "sheet1") {
				formObj.f_cmd.value = SEARCH;
				var prefix = "sheet1_"; //prefix 문자열 배열

				var sXml = sheetObj.GetSearchXml("FNS_TOT_0011GS.do",
						FormQueryString(formObj) + "&"
								+ ComGetPrefixParam(prefix));

				sheetObjects[0].LoadSearchXml(sXml);
				formObj.total_txt_amt.value = ComRound(ComGetEtcData(sXml,
						"total_txAmt"), 0);
				ComChkObjValid(formObj.total_txt_amt);
				//	alert(11);
				for ( var i = 2; i < sheetObjects[0].RowCount + 2; i++) {
					//alert(ComParseInt(sheetObjects[0].CellValue(i,prefix+"voy_dys")));
					if (ComParseInt(sheetObjects[0].CellValue(i, prefix
							+ "voy_dys")) > 31) {
						sheetObjects[0].CellFontColor(i, prefix + "voy_dys") = sheetObjects[0]
								.RgbColor(255, 0, 0);

					}
					if (ComParseInt(sheetObjects[0].CellValue(i, prefix
							+ "ldb_capa_qty")) <= 0) {
						sheetObjects[0].CellFontColor(i, prefix
								+ "ldb_capa_qty") = sheetObjects[0].RgbColor(
								255, 0, 0);

					}

					if (ComParseInt(sheetObjects[0].CellValue(i, prefix
							+ "grs_rgst_tong_wgt")) < 0) {
						sheetObjects[0].CellFontColor(i, prefix
								+ "grs_rgst_tong_wgt") = sheetObjects[0]
								.RgbColor(255, 0, 0);

					}

					if (ComParseInt(sheetObjects[0].CellValue(i, prefix
							+ "nrt_wgt")) < 0) {
						sheetObjects[0].CellFontColor(i, prefix + "nrt_wgt") = sheetObjects[0]
								.RgbColor(255, 0, 0);

					}
					if (ComParseInt(sheetObjects[0].CellValue(i, prefix
							+ "per_ton_rev")) < 0) {
						sheetObjects[0]
								.CellFontColor(i, prefix + "per_ton_rev") = sheetObjects[0]
								.RgbColor(255, 0, 0);

					}
					if (ComParseInt(sheetObjects[0].CellValue(i, prefix
							+ "bsa_capa")) < 0) {
						sheetObjects[0].CellFontColor(i, prefix + "bsa_capa") = sheetObjects[0]
								.RgbColor(255, 0, 0);

					}
					if (ComParseInt(sheetObjects[0].CellValue(i, prefix
							+ "act_bsa_capa")) < 0) {
						sheetObjects[0].CellFontColor(i, prefix
								+ "act_bsa_capa") = sheetObjects[0].RgbColor(
								255, 0, 0);

					}
					if (ComParseInt(sheetObjects[0].CellValue(i, prefix
							+ "usg_rt")) < 0) {
						sheetObjects[0].CellFontColor(i, prefix + "usg_rt") = sheetObjects[0]
								.RgbColor(255, 0, 0);

					}
					if (ComParseInt(sheetObjects[0].CellValue(i, prefix
							+ "tong_tax_amt")) < 0) {

						sheetObjects[0].CellFontColor(i, prefix
								+ "tong_tax_amt") = sheetObjects[0].RgbColor(
								255, 0, 0);

					}

				}
			}

		}

		break;

	case IBSAVE: //저장
		if (closing_yn == "N") {
			if (validateForm(sheetObj, formObj, sAction)) {

				if (formObj.c_nrt_yn.disabled != true) {
					if (formObj.c_nrt_yn.checked == true) {
						formObj.nrt_yn.value = "Y";
						saveYn = "Y";
					}
				} else {
					formObj.nrt_yn.value = "N";

				}

				if (formObj.c_use_yn.disabled != true) {
					if (formObj.c_use_yn.checked == true) {
						formObj.use_yn.value = "Y";
						saveYn = "Y";
					}
				} else {
					formObj.use_yn.value = "N";

				}

				if (formObj.c_day_yn.disabled != true) {
					if (formObj.c_day_yn.checked == true) {
						formObj.day_yn.value = "Y";
						saveYn = "Y";
					}
				} else {
					formObj.day_yn.value = "N";

				}
				//alert("nrt_yn : "+formObj.nrt_yn.value +"    use_yn : "+formObj.use_yn.value +"    day_yn : "+formObj.day_yn.value);

				if (saveYn == "N") {
					ComShowCodeMessage('TOT00051');
					return;
				}

				if (!ComShowCodeConfirm('TOT00004')) {
					return;
				}
				var prefix = "sheet1_"; //prefix 문자열 배열

				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);

				formObj.f_cmd.value = MULTI;
				var SaveStr = ComGetSaveString(sheetObjects);

				sXml = sheetObj.GetSaveXml("FNS_TOT_0011GS.do", SaveStr + "&"
						+ FormQueryString(formObj) + "&"
						+ ComGetPrefixParam(prefix));
				sheetObj.LoadSaveXml(sXml);

				var batch_yn = ComGetEtcData(sXml, "batch_yn");
				if (batch_yn == "Y") {
					if (formObj.c_nrt_yn.checked == true) {
						formObj.c_nrt_yn.disabled = true;
						formObj.nrt_yn.value = "N";
					}
					if (formObj.c_use_yn.checked == true) {
						formObj.c_use_yn.disabled = true;
						formObj.use_yn.value = "N";
					}
					if (formObj.c_day_yn.checked == true) {
						formObj.c_day_yn.disabled = true;
						formObj.day_yn.value = "N";
					}
				}
				saveYn = "N";
				ComOpenWait(false);

			}
		}
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

		/*    if (formObject.trd_cd.Code ==null || formObject.trd_cd.Code ==""){
			    ComShowCodeMessage('TOT00006');
			    ComSetFocus(formObject.trd_cd);
			    return false;
		    }*/

		if (formObject.stl_yrmon.value == null
				|| formObject.stl_yrmon.value == "") {
			ComShowCodeMessage('TOT00003');
			ComSetFocus(formObject.stl_yrmon);
			return false;
		}

		break;
	case IBSAVE: //저장

		if (formObject.stl_yrmon.value == null
				|| formObject.stl_yrmon.value == "") {
			ComShowCodeMessage('TOT00003');
			ComSetFocus(formObject.stl_yrmon);
			return false;
		}

		break;
	default:
		break;
	}
	return true;

}

function sheet1_OnDblClick(sheetObj, Row, Col) {
	//alert("sheet1_OnDblClick row : " +Row+"   col : "+ Col);
	openPopup();

}

/* 개발자 작업  끝 */