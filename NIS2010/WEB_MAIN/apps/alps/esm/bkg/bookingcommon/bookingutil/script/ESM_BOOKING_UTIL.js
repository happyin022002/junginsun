/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ui_booking_util.js
 *@FileTitle : Booking Page
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.23
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.04.23 김영출
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
 * @class Booking Page : Booking Page 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ui_booking_util() {
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
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_0080pop":
			comBkgCallPop0080("setCallBack0800",formObject.cntr_tpsz_cd.value);
			break;
		case "btn_0082pop":
			comBkgCallPop0082("setCallBack0802",'0',formObject.yd_cd.value);
			break;	
		case "btn_0607pop":
			comBkgCallPop0607("setCallBack0607",formObject.hamo_tp_cd.value,formObject.hamo_trf_cd.value);
			break;	
		case "btn_0019pop":
			comBkgCallPop0019("setCallBack0019",formObject.vvd.value,formObject.pol_cd.value,formObject.pod_cd.value);
			break;	
		case "btn_0088pop":
			comBkgCallPop0088("setCallBack0088",formObject.yd_cd2.value);
			break;	
		case "btn_0696pop":
			comBkgCallPop0696("setCallBack0696",formObject.pck_no.value);
			break;	
		case "btn_0653pop":
			comBkgCallPop0653("setCallBack0653",formObject.cmdt_cd.value,formObject.rep_cmdt_cd.value);
			break;	
		case "btn_0727pop":
			var vvd_cd = formObject.vvd_cd_0727.value;
			var pol_cd = formObject.pol_cd_0727.value;
			var pod_cd = formObject.pod_cd_0727.value;
			
			comBkgCallPop0727("setCallBack0727",vvd_cd,pol_cd,pod_cd);
			break;	
		case "btn_0384pop":
			comBkgCallPop0384("setCallBack0384");
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
		//khlee-시작 환경 설정 함수 이름변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	//sheetObjects[0].DoSearch("./UI_BKG_0079_T1_DATA1.html");
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;

	switch (sheetNo) {
	case 1: //sheet1 init
		with (sheetObj) {
			
			// 높이 설정
			style.height = 82;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;
			
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 3, 100);
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(8, 0, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false)
			
			var HeadTitle = "|TP/SZ|Vol.|EQ Sub|EQ Sub|EQ Sub|S.O.C|F.H.";
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			 
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		"hdnStatus");
			InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	false,		"cntr_tpsz_cd",		false,		"",	dfNone,		0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,		50,		daRight,	false,		"op_cntr_qty",			false,		"",	dfNullFloat,	2,		true,		true);
			InitDataProperty(0, cnt++ , dtData,		25,		daCenter,	false,		"EQ",			false,		"",	dfNone,		0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,		50,		daRight,	false,		"Sub",			false,		"",	dfNullFloat,	2,		true,		true);
			InitDataProperty(0, cnt++ , dtData,		30,		daCenter,	false,		"Sub2",			false,		"",	dfNone,	0,		true,		true);
			
			InitDataProperty(0, cnt++ , dtData,		50,		daRight,	false,		"SOC",			false,		"",	dfNullFloat,	2,		true,		true);
			InitDataProperty(0, cnt++ , dtCheckBox,		20,		daCenter,	false,		"FH",			false,		"",	dfNone,		0,		true,		true);
			
			
			CountPosition = 0;
			
			sheetObj.DataInsert();
			sheetObj.DataInsert();
			sheetObj.DataInsert();
			sheetObj.CellText(1,"cntr_tpsz_cd") = "D5";
			sheetObj.CellText(2,"cntr_tpsz_cd") = "D4";
			sheetObj.CellText(3,"cntr_tpsz_cd") = "R5";
			
			sheetObj.CellText(1,"op_cntr_qty") = "1234";
			sheetObj.CellText(2,"op_cntr_qty") = "2";
			sheetObj.CellText(3,"op_cntr_qty") = "1";
		}
		break;
	}
}

/**
 * Container Type/Size입력부분.<br>
 * @param {arry} aryPopupData
 */
function setCallBack0800(aryPopupData) {
	var formObject = document.form;
	formObject.cntr_tpsz_cd.value = aryPopupData[0][2];
	formObject.cntr_tpsz_desc.value = aryPopupData[0][3];
}

/**
 * Yd cd입력부분.<br>
 * @param {arry} aryPopupData
 */
function setCallBack0802(aryPopupData) {
	var formObject = document.form;
	formObject.yd_cd.value = aryPopupData[0][2];
}


/**
 * HAMO_TRF_CD입력부분.<br>
 * @param {arry} aryPopupData
 */
function setCallBack0607(aryPopupData) {
	var formObject = document.form;
	formObject.hamo_trf_cd.value = aryPopupData[0][3];
}

/**
 * Vessel SKD & Code Inquiry부분.<br>
 * @param {arry} aryPopupData
 */
function setCallBack0019(aryPopupData) {
	var formObject = document.form;
	formObject.vvd.value = aryPopupData[0][3];
}

/**
 * Return CY Inquiry.<br>
 * @param {arry} aryPopupData
 */
function setCallBack0088(aryPopupData) {
	var formObject = document.form;
	formObject.yd_cd2.value = aryPopupData[0][2];
}
/**
 * Package Code 및 Description을 검색 및 조회 .<br>
 * @param {arry} aryPopupData
 */
function setCallBack0696(aryPopupData) {
	var formObject = document.form;
	formObject.pck_no.value = aryPopupData[0][3];
}
/**
 * Commodity Code를 입력하기 위해 Code를 검색  .<br>
 * @param {arry} aryPopupData
 */
function setCallBack0653(aryPopupData) {
	var formObject = document.form;
	formObject.cmdt_cd.value = aryPopupData[0][3];
	formObject.rep_cmdt_cd.value = aryPopupData[0][5];
	formObject.cmdt_nm.value = aryPopupData[0][4];
}

function setCallBack0727(aryPopupData) {
	var formObject = document.form;
	/*formObject.cmdt_cd.value = aryPopupData[0][3];
	formObject.rep_cmdt_cd.value = aryPopupData[0][5];
	formObject.cmdt_nm.value = aryPopupData[0][4];*/
}
function setCallBack0384(aryPopupData) {
	var formObject = document.form;
	formObject.tmplt_hdr_nm.value = aryPopupData[0][5];
	formObject.tmplt_ctnt.value = aryPopupData[0][6];
}

/*
function esm_bkg_0607pop(){
	var formObject = document.form;
	var param = FormQueryString(formObject);
	ComOpenWindow("/hanjin/ESM_BKG_0607.do?" + param, "myWin",
			"scroll:;dialogWidth:1080px; dialogHeight:530px", true)
	
}*/

/* 개발자 작업  끝 */