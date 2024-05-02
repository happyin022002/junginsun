/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0044.js
 *@FileTitle : Vessel Code Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.02
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2009.04.27 서창열
 * 1.0 Creation
 * 
 * History
 * 2010.08.19 진마리아 CHM-201005418-01 Vessel Name에 특수키 입력 가능하도록
 * 2012.04.02 진마리아 CHM-201217105-01 Local Vessel name 칼럼 추가 요청건
 * 2012.04.12 진마리아 CHM-201217105-01 MDM Vessel Delete 여부를 조회조건 및 결과에 추가 및 paging처리
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
 * @class VOP_VSK_0044 : VOP_VSK_0044 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0044() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
}

/* 개발자 작업 */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			formObject.page_no.value = "1";
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;

		case "btn_popup_crr_cd":
			var sUrl = "/hanjin/VOP_VSK_0252.do?code_type=CD0XXXX";
			var rVal = ComOpenPopupWithTarget(sUrl, 550, 406, "", "0,0", true);
			if (rVal) {
				formObject.crr_cd.value = rVal;
			}
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);

		ComEndConfigSheet(sheetObjects[i]);
	}

	document.form.vsl_cd.focus();
	initControl();
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet} sheetObj IBSheet Object
 * @param {int} sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	var formObj = document.form;

	// Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm("focus", "obj_activate", formObj);
	axon_event.addListener('keypress', 'eng_keypress', 'vsl_cd', 'vsl_eng_nm', 'crr_cd', 'call_sgn_no', 'lloyd_no'); // 영문 대문자만 입력하기
	axon_event.addListener('keyup', 'obj_keyup', 'vsl_cd', 'crr_cd');
	axon_event.addListenerForm('keypress', 'enter_keypress', formObj); // Enter키 처리
	axon_event.addListenerForm('keyup', "VskKeyFocus", formObj); // - 자동포커스처리

}

function obj_activate() {
	if (event.srcElement.options) {
		event.srcElement.focus();
	} else {
		event.srcElement.select();
	}
}

function obj_keyup() {
	var formObj = document.form;
	var obj = event.srcElement;
	var val = obj.value;

	switch (event.srcElement.name) {
	case "vsl_cd":
		
		if (val == "") {
			formObj.vsl_eng_nm.value = "";
			formObj.tmp_vsl_cd.value = "";
		}

		if (!obj || val == "" || ComChkLen(val, 4) != 2) {
			break;
		}
		if (formObj.tmp_vsl_cd.value != obj.value) {
			sheetObj = sheetObjects[0];
			//doActionIBSheet(sheetObj, formObj, SEARCH01);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
		break;

	case "crr_cd":
		if (val == "") {
			formObj.tmp_crr_cd.value = "";
		}

		if (!obj || val == "" || ComChkLen(val, 3) != 2) {
			break;
		}
		if (formObj.tmp_crr_cd.value != obj.value) {
			sheetObj = sheetObjects[0];
			doActionIBSheet(sheetObj, formObj, SEARCH02);
			obj.focus();
		}
		break;
	}
}

/**
 * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function eng_keypress() {
	var obj = event.srcElement;
	switch (obj.name) {
	case "vsl_eng_nm":
		
		// CHM-201005418-01
		// 특수키(-, <, >, ., /, ', (, ), &, #) 입력되도록 수정
		var availKeyCode = "";
		if (event.keyCode === 32 // 공백입력가능
				|| event.keyCode === 45 // - 입력가능
				|| event.keyCode === 60 // < 입력가능
				|| event.keyCode === 62 // > 입력가능
				|| event.keyCode === 46 // . 입력가능
				|| event.keyCode === 47 // / 입력가능
				|| event.keyCode === 39 // ' 입력가능
				|| event.keyCode === 40 // ( 입력가능
				|| event.keyCode === 41 // ) 입력가능
				|| event.keyCode === 38 // & 입력가능
				|| event.keyCode === 35 // # 입력가능
				) {
			availKeyCode = String(event.keyCode); 
		}
		ComKeyOnlyAlphabet('uppernum', availKeyCode);
		break;
	case "vsl_cd":
	case "call_sgn_no":
		ComKeyOnlyAlphabet("uppernum");
		break;
	case "lloyd_no":
		ComKeyOnlyAlphabet("uppernum", "46"); // 영대문자, 숫자, 마침표 입력가능
		break;
	default:
		ComKeyOnlyAlphabet('upper');
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 440;
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
			InitRowInfo(2, 1, 3, document.form.pagerows.value);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle1 = "|Delete\nFlag|Code|VSL Name|VSL Name|Carrier Code|Net Ton|Call Sign|IMO No.|Trunk/Feeder";
			var HeadTitle2 = "|Delete\nFlag|Code|ENG|China|Carrier Code|Net Ton|Call Sign|IMO No.|Trunk/Feeder";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,			daCenter,	true,	"ibflag",				false,	"",      	dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			45,			daCenter,	true,	"delt_flg",				false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,	"vsl_cd",				false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			200,		daLeft,		false,	"vsl_eng_nm",			false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		false,	"vsl_locl_nm",			false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,	"crr_cd",				false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			080,		daRight,	true,	"net_rgst_tong_wgt",	false,	"",			dfNumber,		0,			true,		true);
			
			InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,	"call_sgn_no",			false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,	"lloyd_no",				false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtCombo,		100,		daCenter,	true,	"fdr_div_cd",			false,	"",			dfNone,			0,			true,		true);

			InitDataCombo(0, "fdr_div_cd", "Trunk|Feeder", "T|O");
			
			ScrollBar = 2;
			
			CountFormat = "[SELECTDATAROW / TOTALROWS]";
		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch (sAction) {
	case IBSEARCH: // 조회
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		var rXml = sheetObj.GetSearchXml("VOP_VSK_0044GS.do",
				FormQueryString(formObj));
		
		if(formObj.page_no.value=="1"){
			sheetObj.LoadSearchXml(rXml, false);
		}else{						
			sheetObj.LoadSearchXml(rXml, true);
		}
		ComOpenWait(false);
		formObj.vsl_cd.focus();
		break;

	case SEARCH01:
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		var tmp = formObj.vsl_eng_nm.value;
		formObj.vsl_eng_nm.value = '';
		var rXml = sheetObj.GetSearchXml("VOP_VSK_0044GS.do",
				FormQueryString(formObj));
		ComOpenWait(false);
		var nm = ComGetEtcData(rXml, "vsl_eng_nm");
		if (nm != null) {
			formObj.vsl_eng_nm.value = nm;
			formObj.tmp_vsl_cd.value = formObj.vsl_cd.value;
			ComSetNextFocus();
		} else {
			ComShowCodeMessage('VSK00023', formObj.vsl_cd.value);
			formObj.vsl_eng_nm.value = tmp;
			formObj.vsl_cd.value = formObj.tmp_vsl_cd.value;
			formObj.vsl_cd.focus();
		}
		break;

	case SEARCH02:
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH02;
		var rXml = sheetObj.GetSearchXml("VOP_VSK_0044GS.do",
				FormQueryString(formObj));
		ComOpenWait(false);
		var nm = ComGetEtcData(rXml, "crr_full_nm");
		if (nm != null) {
			formObj.tmp_crr_cd.value = formObj.crr_cd.value;
			ComSetNextFocus();
		} else {
			ComShowCodeMessage('VSK00024', formObj.crr_cd.value);
			formObj.crr_cd.value = formObj.tmp_crr_cd.value;
			formObj.crr_cd.focus();
		}
		break;
	}
}

function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
	var formObj = document.form;
	formObj.page_no.value = PageNo;
	doActionIBSheet(sheetObj,formObj,IBSEARCH);
}

/**
 * 엔터키로 연결된 화면 대표 이벤트
 */
function enter_keypress() {
	VskKeyEnter();
}

/* 개발자 작업 끝 */