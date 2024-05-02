/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : VOP_FCM_0032.js
 *@FileTitle : Standard of FOC(Pop-up)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.10.04
 *@LastModifier : 유혁
 *@LastVersion : 1.0
 * 2011.10.04 유혁
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
 * @class VOP_FCM_0032 : VOP_FCM_0032 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0032() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
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
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;

		case "btns_calendarfm":
			var cal = new ComCalendar();
			cal.setDisplayType('month');
			cal.select(formObject.fm_dt, 'yyyy-MM');
			break;	
		case "btns_calendarto":
			var cal = new ComCalendar();
			cal.setDisplayType('month');
			cal.select(formObject.to_dt, 'yyyy-MM');
			break;
		case "btn_downexcel":
			doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
			break;
        case "btn_OK":
            self.close();
	        break;			
        case "btn_Close":
            self.close();
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
	case 1: // t1sheet1 init [Departure Report]
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
			InitRowInfo(3, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

/*			var HeadTitle = "Lane|Design\nCapacity|Bound|VVD\nCount|Average FOC|Average FOC|Calculated FOC|Calculated FOC|Apply\nRatio|Apply FOC Q'Ty|Apply FOC Q'Ty";
			var HeadTitle2 = "Lane|Design\nCapacity|Bound|VVD\nCount|FO|DO|FO|DO|Apply\nRatio|FO|DO";*/
			var HeadTitle = "Lane|P/F SKD\nType|Vessel\nClass|Bound|VVD\nCount|Average FOC|Average FOC|Calculated FOC (FO)|Calculated FOC (FO)|Calculated FOC (FO)|Apply\nRatio|Apply FOC Q'Ty|Apply FOC Q'Ty|P/F SKD Type|P/F SKD Type|P/F SKD Type|P/F SKD Type|P/F SKD Type|P/F SKD Type|P/F SKD Type|P/F SKD Type";
			var HeadTitle2 = "Lane|P/F SKD\nType|Vessel\nClass|Bound|VVD\nCount|FO|DO|Sea\nSpeed|Buffer\nSpeed|Dff|Apply\nRatio|FO|DO|Dist.|Sea\nSpeed|Sea Time|Buffer\nSpeed|Buffer\nTime|Manv.|Manv.|PortTime";
			var HeadTitle3 = "Lane|P/F SKD\nType|Vessel\nClass|Bound|VVD\nCount|FO|DO|Sea\nSpeed|Buffer\nSpeed|Dff|Apply\nRatio|FO|DO|Dist.|Sea\nSpeed|Sea Time|Buffer\nSpeed|Buffer\nTime|In|Out|PortTime";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle2, true);
			InitHeadRow(2, HeadTitle3, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"",		false,	"",			dfNone,			0,			true,		true);
			
			CountPosition = 0;
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
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			var rXml = sheetObj.DoSearch("VOP_FCM_0032GS.do",
					FormQueryString(formObj));
			ComOpenWait(false);
		}
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
	case IBDOWNEXCEL:      
		sheetObj.SpeedDown2Excel(true);
		break;		
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	var vsl_cd = formObj.vsl_cd;
	var vsl_eng_nm = formObj.vsl_eng_nm;
	var crr_cd = formObj.crr_cd;

/*	with (formObj) {
		if (ComChkLen(vsl_cd, 2) == 1 && ComChkLen(vsl_eng_nm, 2) == 1
				&& ComChkLen(crr_cd, 2) == 1 && ComChkLen(call_sgn_no, 2) == 1
				&& ComChkLen(lloyd_no, 2) == 1) {
			ComShowCodeMessage('VSK00022', "2", "vessel code");
			return false;
		}
	}*/

	return true;
}

/* 개발자 작업 끝 */