﻿/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0229_05.js
 *@FileTitle : e-Booking & SI Process Detail(C/M)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.17
 *@LastModifier : 전용진
 *@LastVersion : 1.0
 * 2009.06.17 전용진
 * 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2011.01.04 김영철 [CHM-201007416-01] E-BKG & SI CM Tab 수정 요청 (구주 24HR Rule 관련)
 2011.01.11 김영철 [] E-BKG & SI CM Tab Validation 부분 수정
 2011.10.30  정선용 [CHM-201114136-01]	(HJL) e-Booking & SI Upload Problem
 2011.11.24  정선용 [CHM-201114136-01]	(HJL) e-Booking & SI Upload Problem AS
 2013.01.10 변종건 [CHM-201322261-01] Marble 운송사고 예방을 위한 Booking-Special Stowage (MUPG) 자동지정 프로그래밍 요청
 2013.02.25 김현화 [CHM-201222205] multi ncm code c/a mode 수정 
 2013.06.03 류대영 [CHM-201324869] Split 01-CNTR Weight minimum check 로직 추가 요청
=========================================================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author SM LINE
 */

/**
 * @extends
 * @class esm_bkg_0229_05 : esm_bkg_0229_05 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0229_05() {
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

var comboObjects = new Array();
var comboCnt = 0;

var iterator = "|$$|";

var isCopy = "false";

var selRow = 0;
var selCol = 0;

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
		case "btn_cancelcopydata":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
			isCopy = "false";
			top.isCopyAllRequested = false;
			ComBtnColor("btn_cancelcopydata", "blue");
			ComBtnColor("btn_datacopytoalps", "#737373");
			ComBtnColor("btn_copyfromcntr", "#737373");
			break;

		case "btn_datacopytoalps":
			if (isCopy == "false") {
				dataCopy();
			}
			break;

		case "btn_upload":
			//cntr tab이 안열려 있으면 바로 종료
			if (!parent.frames("t3frame").document.form) break;
			
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;
		
		case "btn_copyfromcntr":
			cntrDataCopy();
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

function initControl() {
	applyShortcut();
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	
	var sheetLen = sheetObjects.length;
	
	for (i = 0; i < sheetLen; i++) {
		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
		// IBMultiCombo
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	initControl();
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1":
		//with (sheetObj) {
			// 높이 설정
		sheetObj.style.height = 502;
			// 전체 너비 설정
		sheetObj.SheetWidth = 300;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msAll;
//			DataRowMerge(0) = false;
//			DataRowMerge(1) = false;
//			DataRowMerge(2) = true;
//			DataRowMerge(3) = true;
//			DataRowMerge(4) = true;
			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(5, 5, 15, 100);

			var HeadTitle1 = "| |Container No.||Package|Package||Weight|Weight||Measure|Measure|SI_NO";
			var HeadTitle2 = "| |1||HTS Code|HTS Code||HS Code|HS Code||NCM Code|NCM Code|XTER_RQST_SEQ";
			var HeadTitle3 = "| |Description(Total Container : 0)|Description(Total Container : 0)|Description(Total Container : 0)|Description(Total Container : 0)|Description(Total Container : 0)|Description(Total Container : 0)|P/O No.|WPM|CNTR TP/SZ";
			var HeadTitle4 = "| |Description Detail(s)|Description Detail(s)|Description Detail(s)|Description Detail(s)|Description Detail(s)|Description Detail(s)|Description Detail(s)|Description Detail(s)|DG Seq|DG Seq|";
			var HeadTitle5 = "| |Mark & NOS|Mark & NOS|Mark & NOS|Mark & NOS|Mark & NOS|Mark & NOS|Mark & NOS|Mark & NOS|Manifest File No|Manifest File No|";
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(14, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle1, true);
			sheetObj.InitHeadRow(1, HeadTitle2, true);
			sheetObj.InitHeadRow(2, HeadTitle3, true);
			sheetObj.InitHeadRow(3, HeadTitle4, true);
			sheetObj.InitHeadRow(4, HeadTitle5, true);

			sheetObjects[0].DataAutoTrim = false;

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			var prefix = "sheet1_";
			sheetObj.InitDataProperty(0, cnt++, dtHiddenStatus,  10, daCenter, true,  "ibflag");
			sheetObj.InitDataProperty(0, cnt++, dtData, 			20, daCenter, true,  "cntr_seq",			false, "", dfNone, 		0, true, true, 10, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			80, daLeft,   false, "cntr_no",				false, "", dfNone, 		0, true, true, 14, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 		 	 1, daRight,  false, "cntr_no_old",			false, "", dfNone,	 	0, false,false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			80, daRight,  false, "pck_qty",				false, "", dfInteger, 	0, true, true, 12, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			30, daCenter, false, "pck_tp_cd", 			false, "", dfNone, 		0, true, true, 5,  false, false);
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		 1, daRight,  false, "sep2",				false, "", dfNone,	 	0, false,false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			80, daRight,  false, "cntr_mf_wgt", 		false, "", dfFloat, 	3, true, true, 18, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtCombo, 		40, daCenter, false, "wgt_ut_cd",			false, "", dfNone, 		0, true, true, 5,  false, false);
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		 1, daRight,  false, "sep3",				false, "", dfNone,	 	0, false,false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			80, daRight,  false, "meas_qty",			false, "", dfFloat, 	3, true, true, 12, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtCombo, 		40, daCenter, false, "meas_ut_cd", 			false, "", dfNone, 		0, true, true, 5,  false, false);
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		40, daCenter, false, "si_no", 				false, "", dfNone, 		0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		40, daCenter, false, "empty00", 		    false, "", dfNone, 		0, false, false);
			sheetObj.InitDataValid(0, "pck_tp_cd", 	vtEngUpOnly);
//			InitDataValid(0, "wgt_ut_cd", 	vtEngUpOnly);
//			InitDataValid(0, "meas_ut_cd", 	vtEngUpOnly);
			
			sheetObj.InitDataCombo(0, "wgt_ut_cd", " |KGS|LBS", " |KGS|LBS");
			sheetObj.InitDataCombo(0, "meas_ut_cd", " |CBM|CBF", " |CBM|CBF");
			
			cnt = 0;

			sheetObj.InitDataProperty(1, cnt++, dtHiddenStatus, 	10, daCenter, true,  "tmp");
			sheetObj.InitDataProperty(1, cnt++, dtData, 			20, daCenter, true,  "cntr_seq",			false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(1, cnt++, dtData, 			80, daLeft,   false, "cntr_mf_seq", 		false, "", dfNone, 		0, false,false);
			sheetObj.InitDataProperty(1, cnt++, dtHidden, 		 1, daRight,  false, "sep1",				false, "", dfNone, 		0, false,false);
			sheetObj.InitDataProperty(1, cnt++, dtPopupEdit, 	80, daCenter, false, "hamo_trf_cd", 		false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(1, cnt++, dtData, 			30, daCenter, false, "hamo_trf_cd1",		false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(1, cnt++, dtHidden, 		 1, daRight,  false, "sep2",				false, "", dfNone, 		0, false,false);
			sheetObj.InitDataProperty(1, cnt++, dtPopupEdit, 	80, daCenter, false, "cmdt_hs_cd",			false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(1, cnt++, dtData, 			40, daCenter, false, "cmdt_hs_cd1",			false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(1, cnt++, dtHidden, 		 1, daRight,  false, "sep3",				false, "", dfNone, 		0, false,false);
			sheetObj.InitDataProperty(1, cnt++, dtPopupEdit ,    80, daCenter, false, "ncm_no", 		     	false, "", dfNone, 	    0, true, true);
			sheetObj.InitDataProperty(1, cnt++, dtData,          40, daCenter,  false, "ncm_no1",				false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(1, cnt++, dtHidden, 		40, daCenter, false, "xter_rqst_seq", 		false, "", dfNone, 		0, false, false);
			sheetObj.InitDataProperty(1, cnt++, dtHidden, 		40, daCenter, false, "ncm_multi_no", 		false, "", dfNone, 		0, false, false);
			sheetObj.InitDataValid(1, "hamo_trf_cd", vtEngUpOther, "0123456789./-#");
			sheetObj.InitDataValid(1, "cmdt_hs_cd",  vtEngUpOther, "0123456789./-#");
			sheetObj.InitDataValid(1, "ncm_no", 		vtEngUpOther, "0123456789./-#");
			
			cnt = 0;
			sheetObj.InitDataProperty(2, cnt++, dtHiddenStatus, 	10, daCenter, true,  "tmp");
			sheetObj.InitDataProperty(2, cnt++, dtData, 			20, daCenter, true,  "cntr_seq",		 	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(2, cnt++, dtData, 			80, daLeft,   false, "cntr_mf_gds_desc", 	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(2, cnt++, dtHidden, 		 1, daRight,  false, "cntr_mf_gds_desc1", 	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(2, cnt++, dtData, 			80, daLeft,   false, "cntr_mf_gds_desc1", 	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(2, cnt++, dtData, 			30, daLeft,   false, "cntr_mf_gds_desc1", 	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(2, cnt++, dtHidden, 		 1, daRight,  false, "cntr_mf_gds_desc1", 	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(2, cnt++, dtData, 			80, daLeft,   false, "cntr_mf_gds_desc1", 	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(2, cnt++, dtData, 			40, daLeft,   false, "cntr_mf_gds_desc1", 	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(2, cnt++, dtHidden, 		 1, daRight,  false, "cntr_mf_gds_desc1", 	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(2, cnt++, dtData, 			80, daLeft,   false, "po_no",             	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(2, cnt++, dtCombo, 			40, daLeft,   false, "wpm_trt_cd",            	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(2, cnt++, dtHidden, 		40, daCenter, false, "cntr_tpsz_cd", 		false, "", dfNone, 		0, false, false);
			sheetObj.InitDataProperty(2, cnt++, dtHidden, 		40, daCenter, false, "empty02", 		    false, "", dfNone, 		0, false, false);
			sheetObj.InitDataValid(1, "po_no", 		vtEngUpOther, "0123456789`~!@#$%^&*()_+-=][\{}|,.<>/?");
//			InitDataValid(2, "cntr_mf_gds_desc", vtEngUpOnly);

			cnt = 0;
			sheetObj.InitDataProperty(3, cnt++, dtHiddenStatus, 	10, daCenter, true,  "tmp");
			sheetObj.InitDataProperty(3, cnt++, dtData, 			20, daCenter, true,  "cntr_seq",   		 	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(3, cnt++, dtData, 			80, daLeft,   false, "cntr_mf_dtl_desc", 	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(3, cnt++, dtHidden, 		 1, daRight,  false, "cntr_mf_dtl_desc1", 	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(3, cnt++, dtData, 			80, daLeft,   false, "cntr_mf_dtl_desc1", 	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(3, cnt++, dtData, 			30, daLeft,   false, "cntr_mf_dtl_desc1", 	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(3, cnt++, dtHidden, 		 1, daRight,  false, "cntr_mf_dtl_desc1", 	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(3, cnt++, dtData, 			80, daLeft,   false, "cntr_mf_dtl_desc1", 	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(3, cnt++, dtData, 			40, daLeft,   false, "cntr_mf_dtl_desc1", 	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(3, cnt++, dtHidden, 		 1, daRight,  false, "cntr_mf_dtl_desc1", 	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(3, cnt++, dtCombo, 		80, daLeft,   false, "dcgo_seq",          	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(3, cnt++, dtCombo, 		40, daLeft,   false, "dcgo_seq1",         	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(3, cnt++, dtHidden, 		40, daCenter, false, "empty2", 		false, "", dfNone, 		0, false, false);
			sheetObj.InitDataProperty(3, cnt++, dtHidden, 		40, daCenter, false, "empty03", 		    false, "", dfNone, 		0, false, false);
//			InitDataValid(3, "cntr_mf_dtl_desc", vtEngUpOnly);
//			InitDataCombo(3,	"dcgo_seq",	"Active|Deleted", "A|D");

			cnt = 0;
			sheetObj.InitDataProperty(4, cnt++, dtHiddenStatus, 	10, daCenter, true,  "tmp");
			sheetObj.InitDataProperty(4, cnt++, dtData, 			20, daCenter, true,  "cntr_seq",		  	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(4, cnt++, dtData, 			80, daLeft,   false, "cntr_mf_mk_desc",   	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(4, cnt++, dtHidden, 		 1, daRight,  false, "cntr_mf_mk_desc1",  	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(4, cnt++, dtData, 			80, daLeft,   false, "cntr_mf_mk_desc1",  	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(4, cnt++, dtData, 			30, daLeft,   false, "cntr_mf_mk_desc1",  	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(4, cnt++, dtHidden, 		 1, daRight,  false, "cntr_mf_mk_desc1",  	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(4, cnt++, dtData, 			80, daLeft,   false, "cntr_mf_mk_desc1",  	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(4, cnt++, dtData, 			40, daLeft,   false, "cntr_mf_mk_desc1",  	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(4, cnt++, dtHidden, 		 1, daRight,  false, "cntr_mf_mk_desc1",  	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(4, cnt++, dtData, 			80, daLeft,   false, "cntr_mf_no",        	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(4, cnt++, dtData, 			40, daLeft,   false, "cntr_mf_no1",       	false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(4, cnt++, dtHidden, 		40, daCenter, false, "empty3", 		false, "", dfNone, 		0, false, false);
			sheetObj.InitDataProperty(4, cnt++, dtHidden, 		40, daCenter, false, "empty04", 		    false, "", dfNone, 		0, false, false);
//			InitDataValid(4, "cntr_mf_mk_desc", vtEngUpOnly);

			sheetObj.PopupImage = "img/btns_search.gif";
			sheetObj.ShowButtonImage = 2;
			sheetObj.CountPosition = 0;
			
			sheetObj.ImageList(0) = "/hanjin/img/button/btns_multisearch.gif";
			sheetObj.PopupButtonImage(1,10) =  0;
		
			
		//}
		break;

	case "sheet2":
		//with (sheetObj) {
			// 높이 설정
		sheetObj.style.height = 502;
			// 전체 너비 설정
		sheetObj.SheetWidth = 300;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msAll;

			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(5, 5, 15, 100);

			var HeadTitle1 = "| |Container No.||Package|Package||Weight|Weight||Measure|Measure|SI_NO";
			var HeadTitle2 = "| |1||HTS Code|HTS Code||HS Code|HS Code||NCM Code|NCM Code|XTER_RQST_SEQ";
			var HeadTitle3 = "| |Description(Total Container : 0)|Description(Total Container : 0)|Description(Total Container : 0)|Description(Total Container : 0)|Description(Total Container : 0)|Description(Total Container : 0)|Description(Total Container : 0)|Description(Total Container : 0)|P/O No.|P/O No.|CNTR TP/SZ";
			var HeadTitle4 = "| |Description Detail(s)|Description Detail(s)|Description Detail(s)|Description Detail(s)|Description Detail(s)|Description Detail(s)|Description Detail(s)|Description Detail(s)|DG Seq|DG Seq|";
			var HeadTitle5 = "| |Mark & NOS|Mark & NOS|Mark & NOS|Mark & NOS|Mark & NOS|Mark & NOS|Mark & NOS|Mark & NOS|Manifest File No|Manifest File No|";

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(14, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle1, true);
			sheetObj.InitHeadRow(1, HeadTitle2, true);
			sheetObj.InitHeadRow(2, HeadTitle3, true);
			sheetObj.InitHeadRow(3, HeadTitle4, true);
			sheetObj.InitHeadRow(4, HeadTitle5, true);

			sheetObjects[1].DataAutoTrim = false;

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			var prefix = "sheet2_";
			sheetObj.InitDataProperty(0, cnt++, dtHiddenStatus, 	10, daCenter, true,	 "ibflag");
			sheetObj.InitDataProperty(0, cnt++, dtData, 			20, daCenter, true,  "cntr_seq",			false, "", dfNone, 		0, false, true, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			80, daLeft,   false, "cntr_no",				false, "", dfNone, 		0, false, true, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		 1, daRight,  false, "sep1",				false, "", dfNone,	 	0, false,false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			80, daCenter, false, "pck_qty",				false, "", dfInteger, 	0, false, true, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			30, daCenter, false, "pck_tp_cd", 			false, "", dfNone, 		0, false, true, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		 1, daRight,  false, "sep2",				false, "", dfNone,	 	0, false,false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			80, daCenter, false, "cntr_mf_wgt", 		false, "", dfFloat, 	3, false, true, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			40, daCenter, false, "wgt_ut_cd", 			false, "", dfNone, 		0, false, true, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		 1, daRight,  false, "sep3",				false, "", dfNone,	 	0, false,false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			80, daCenter, false, "meas_qty",			false, "", dfFloat, 	3, false, true, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			40, daCenter, false, "meas_ut_cd", 			false, "", dfNone, 		0, false, true, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		40, daCenter, false, "si_no", 				false, "", dfNone, 		0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		40, daCenter, false, "empty00", 		    false, "", dfNone, 		0, false, false);
			cnt = 0;

			sheetObj.InitDataProperty(1, cnt++, dtHiddenStatus, 	30, daCenter, true,  "");
			sheetObj.InitDataProperty(1, cnt++, dtData, 			20, daCenter, true,  "cntr_seq",			false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(1, cnt++, dtData, 			80, daLeft,   false, "cntr_mf_seq", 		false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(1, cnt++, dtHidden, 		 1, daRight,  false, "sep1",				false, "", dfNone, 		0, false,false);
			sheetObj.InitDataProperty(1, cnt++, dtData, 			80, daCenter, false, "hamo_trf_cd", 		false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(1, cnt++, dtData, 			40, daCenter, false, "hamo_trf_cd", 		false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(1, cnt++, dtHidden, 		 1, daRight,  false, "sep2",				false, "", dfNone, 		0, false,false);
			sheetObj.InitDataProperty(1, cnt++, dtData, 			80, daCenter, false, "cmdt_hs_cd",			false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(1, cnt++, dtData, 			40, daCenter, false, "cmdt_hs_cd",			false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(1, cnt++, dtHidden, 		 1, daRight,  false, "sep3",				false, "", dfNone, 		0, false,false);
			sheetObj.InitDataProperty(1, cnt++, dtPopupEdit, 		80, daCenter, false, "ncm_no",				false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(1, cnt++, dtData, 			40, daCenter, false, "ncm_no",				false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(1, cnt++, dtHidden, 		40, daCenter, false, "xter_rqst_seq", 		false, "", dfNone, 		0, false, false);
			sheetObj.InitDataProperty(1, cnt++, dtHidden, 		40, daCenter, false, "ncm_multi_no", 	    false, "", dfNone, 		0, false, false);

			cnt = 0;
			sheetObj.InitDataProperty(2, cnt++, dtHiddenStatus, 	30, daCenter, true,  "");
			sheetObj.InitDataProperty(2, cnt++, dtData,			20, daCenter, true,  "cntr_seq",		 	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(2, cnt++, dtData,			80, daLeft,   false, "cntr_mf_gds_desc", 	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(2, cnt++, dtHidden, 		 1, daRight,  false, "cntr_mf_gds_desc", 	false, "", dfNone, 		0, true,  true);
			sheetObj.InitDataProperty(2, cnt++, dtData, 			80, daLeft,   false, "cntr_mf_gds_desc", 	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(2, cnt++, dtData, 			40, daLeft,   false, "cntr_mf_gds_desc", 	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(2, cnt++, dtHidden, 		 1, daRight,  false, "cntr_mf_gds_desc", 	false, "", dfNone, 		0, true,  true);
			sheetObj.InitDataProperty(2, cnt++, dtData, 			80, daLeft,   false, "cntr_mf_gds_desc", 	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(2, cnt++, dtData, 			40, daLeft,   false, "cntr_mf_gds_desc", 	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(2, cnt++, dtHidden, 		 1, daRight,  false, "cntr_mf_gds_desc", 	false, "", dfNone, 		0, true,  true);
			sheetObj.InitDataProperty(2, cnt++, dtData, 			80, daLeft,   false, "po_no",            	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(2, cnt++, dtData, 			40, daLeft,   false, "wpm_trt_cd",            	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(2, cnt++, dtHidden, 		40, daCenter, false, "cntr_tpsz_cd", 		false, "", dfNone, 		0, false, false);
			sheetObj.InitDataProperty(2, cnt++, dtHidden, 		40, daCenter, false, "empty02", 		    false, "", dfNone, 		0, false, false);

			cnt = 0;
			sheetObj.InitDataProperty(3, cnt++, dtHiddenStatus, 	30, daCenter, true,  "");
			sheetObj.InitDataProperty(3, cnt++, dtData, 			20, daCenter, true,  "cntr_seq",		 	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(3, cnt++, dtData, 			80, daLeft,   false, "cntr_mf_dtl_desc", 	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(3, cnt++, dtHidden, 		 1, daRight,  false, "cntr_mf_dtl_desc", 	false, "", dfNone, 		0, true,  true);
			sheetObj.InitDataProperty(3, cnt++, dtData, 			80, daLeft,   false, "cntr_mf_dtl_desc", 	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(3, cnt++, dtData, 			40, daLeft,   false, "cntr_mf_dtl_desc", 	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(3, cnt++, dtHidden, 		 1, daRight,  false, "cntr_mf_dtl_desc", 	false, "", dfNone, 		0, true,  true);
			sheetObj.InitDataProperty(3, cnt++, dtData, 			80, daLeft,   false, "cntr_mf_dtl_desc", 	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(3, cnt++, dtData, 			40, daLeft,   false, "cntr_mf_dtl_desc", 	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(3, cnt++, dtHidden, 		 1, daRight,  false, "cntr_mf_dtl_desc", 	false, "", dfNone, 		0, true,  true);
			sheetObj.InitDataProperty(3, cnt++, dtData, 			80, daLeft,   false, "dcgo_seq",         	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(3, cnt++, dtData, 			40, daLeft,   false, "dcgo_seq",         	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(3, cnt++, dtHidden, 		40, daCenter, false, "empty2", 		false, "", dfNone, 		0, false, false);
			sheetObj.InitDataProperty(3, cnt++, dtHidden, 		40, daCenter, false, "empty03", 		    false, "", dfNone, 		0, false, false);

			cnt = 0;
			sheetObj.InitDataProperty(4, cnt++, dtHiddenStatus, 	30, daCenter, true,  "");
			sheetObj.InitDataProperty(4, cnt++, dtData, 			20, daCenter, true,  "cntr_seq",		 	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(4, cnt++, dtData, 			80, daLeft,   false, "cntr_mf_mk_desc",  	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(4, cnt++, dtHidden, 		 1, daRight,  false, "cntr_mf_mk_desc",	 	false, "", dfNone, 		0, true,  true);
			sheetObj.InitDataProperty(4, cnt++, dtData, 			80, daLeft,   false, "cntr_mf_mk_desc",  	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(4, cnt++, dtData, 			40, daLeft,   false, "cntr_mf_mk_desc",  	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(4, cnt++, dtHidden, 		 1, daRight,  false, "cntr_mf_mk_desc",	 	false, "", dfNone, 		0, true,  true);
			sheetObj.InitDataProperty(4, cnt++, dtData, 			80, daLeft,   false, "cntr_mf_mk_desc",  	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(4, cnt++, dtData, 			40, daLeft,   false, "cntr_mf_mk_desc",  	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(4, cnt++, dtHidden, 		 1, daRight,  false, "cntr_mf_mk_desc",	 	false, "", dfNone, 		0, true,  true);
			sheetObj.InitDataProperty(4, cnt++, dtData, 			80, daLeft,   false, "cntr_mf_no",       	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(4, cnt++, dtData, 			40, daLeft,   false, "cntr_mf_no",       	false, "", dfNone, 		0, false, true);
			sheetObj.InitDataProperty(4, cnt++, dtHidden, 		40, daCenter, false, "empty3", 		false, "", dfNone, 		0, false, false);
			sheetObj.InitDataProperty(4, cnt++, dtHidden, 		40, daCenter, false, "empty04", 		    false, "", dfNone, 		0, false, false);

			sheetObj.ShowButtonImage = 2;
			sheetObj.CountPosition = 0;
			
			sheetObj.ImageList(0) = "/hanjin/img/button/btns_multisearch.gif";
			sheetObj.PopupButtonImage(1,10) =  0;
		
			
		//}
		break;
		
	case "sheet3":
		//with (sheetObj) {
			// 높이 설정
		sheetObj.style.height = 0;
			//전체 너비 설정
		sheetObj.SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 3, 100);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(3, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(false, true, false, true, false, false);

			var HeadTitle = "cntr_no|dcgo_seq|diff_rmk";

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle, true);

            //데이터속성    [ROW, COL,  DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,           KEYFIELD,  CALCULOGIC,  DATAFORMAT,  POINTCOUNT,  UPDATEEDIT,  INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,     "cntr_no",          false,     "",          dfNone,   0,           true,        true);
            sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,   false,     "dcgo_seq",        false,     "",          dfNone,      0,           true,        true);
            sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,     "diff_rmk",      false,     "",          dfNone,     0,           true,        true);
            
            sheetObj.CountPosition = 0;

            sheetObj.AutoRowHeight = false;
		//}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = 1;
	switch (sAction) {
	case IBSAVE:
		
		if (!validateForUpload()) return false;
		
		var params = getSaveStringForUpload();
		return false;
		var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0229_05GS.do", params, false);
		var rMsg = ComResultMessage(sXml);
		if (rMsg == '') {
		} else {
//			a""lert(rMsg.split('<||>').join('\n'));
		}
		break;

	case IBSEARCH_ASYNC01: // 조회
		parent.tabObjects[0].TabBackColor(4) = "#96c792";
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		formObj.br_wgt_chk_flg.value = "N";
		break;
	case IBSEARCH: // 조회
		var sXml = formObj.sXml.value;
		var arrXml = sXml.split("|$$|");
		var headTitle3 = "";
		var rowKnt = 0;
		var colKnt = 0;
		var wpmXml  = arrXml[3];
//		alert(wpmXml);
		var arrData = ComBkgXml2ComboString(wpmXml, "val", "multidesc");		
		arrData[1] ="\t |"+ arrData[1].replace("|A","|N/A");
		arrData[1] = arrData[1].replace(/\\t/gi, "\t");
	    arrData[0] =" |"+ arrData[0];
	    sheetObjects[0].InitDataCombo(2,"wpm_trt_cd", arrData[1], arrData[0]);
//		for ( var i = 0; i < arrXml.length; i++) {
		for ( var i = 0; i < 2; i++) {
			sheetObjects[i].Redraw = false;
			if (i > 0) {
				sheetObjects[i].WaitImageVisible = false;
			}
			sheetObjects[i].LoadSearchXml(arrXml[i]);
			rowKnt = 0;
			colKnt = 0;
			rowKnt = (sheetObjects[i].RowCount - sheetObjects[i].HeaderRows) / sheetObjects[i].DataRows + 1; 
			colKnt = sheetObjects[i].LastCol + 1;
			
			
			headTitle3 = "| ";
			for (var j = 0; j < colKnt-3; j++) {
				if (j > 2) {
					headTitle3 = headTitle3 + "|Description(Total Container : " + rowKnt + ")";
				}
			}
			headTitle3 = headTitle3 + "|P/O No." + "|WPM";
			sheetObjects[i].InitHeadRow(2, headTitle3, true);			
			sheetObjects[i].Redraw = true;
		}
		
		// DG Seq 값을 선택가능하도록 함. ( 2010.12.21 - DG Seq 추가함 )
		sheetObjects[2].LoadSearchXml(arrXml[2]);
//		if(sheetObjects[2].TotalRows  > 0){							 
//			var arrData = ComBkgXml2ComboString(arrXml[2], "dcgo_seq", "diff_rmk");
//		     arrData[1] ="|"+ arrData[1];
//		     arrData[0] =" |"+ arrData[0];
//		     sheetObjects[0].InitDataCombo(3,"dcgo_seq", arrData[1], arrData[0]);
//		     sheetObjects[0].InitDataCombo(3,"dcgo_seq1", arrData[1], arrData[0]);
//		}
		
		var cntr_no = sheetObjects[0].CellValue(5, 'cntr_no');
		var cntrSheet = sheetObjects[2];
		var dcgoList = '';
		var dcgovalue = '';
		dcgoList = dcgoList + " |";
		dcgovalue = dcgovalue + " |";
		for(var i=cntrSheet.HeaderRows;i<=cntrSheet.Rows;i++){
			if( cntr_no == cntrSheet.CellValue(i, "cntr_no") ){
//					//'Seq'||DG_CNTR_SEQ||'-'||'Un No: '||IMDG_UN_NO||',Dcgo Seq : '||DCGO_SEQ|| ',Class : '||IMDG_CLSS_CD DIFF_RMK
				dcgoList = dcgoList + cntrSheet.CellValue(i, "diff_rmk")+"|";
				dcgovalue = dcgovalue + cntrSheet.CellValue(i, "dcgo_seq") + "|";
			}
		}
//		sheetObj.InitDataCombo(3,	"dcgo_seq",	"Active"+Row+"|Deleted"+Row, "A"+Row+"|D"+Row);
		sheetObj.InitDataCombo(3,	"dcgo_seq",	dcgoList, dcgovalue);
		sheetObj.InitDataCombo(3,	"dcgo_seq1",	dcgoList, dcgovalue);
		
		for ( var i = 0; i < 2; i++) {
			sheetObjects[i].Redraw = false;
			if (i > 0) {
				sheetObjects[i].WaitImageVisible = false;
			}
			sheetObjects[i].LoadSearchXml(arrXml[i]);
			rowKnt = 0;
			colKnt = 0;
			rowKnt = (sheetObjects[i].RowCount - sheetObjects[i].HeaderRows) / sheetObjects[i].DataRows + 1; 
			colKnt = sheetObjects[i].LastCol + 1;
			headTitle3 = "| ";
			for (var j = 0; j < colKnt-3; j++) {
				if (j > 2) {
					headTitle3 = headTitle3 + "|Description(Total Container : " + rowKnt + ")";
				}				
				
			}
			headTitle3 = headTitle3 + "|P/O No." + "|WPM";
			sheetObjects[i].InitHeadRow(2, headTitle3, true);
			sheetObjects[i].Redraw = true;
		}
		
	    
		
		if (sheetObjects[0].TotalRows > 0) {
			formObj.cm_nis.value = "Y";
		} else {
			formObj.cm_nis.value = "N";
		}		
		
		if (sheetObjects[1].TotalRows > 0) {
			formObj.cm_esvc.value = "Y";
			for ( var k = 9; k < sheetObjects[1].Rows; k=k+5) {
				for ( var l = 2; l < 10; l++) {
					sheetObjects[1].CellValue2(k, l) = sheetObjects[1].CellValue(k, 2);
				}
			}
		} else {
			formObj.cm_esvc.value = "N";
		}
		if(top.document.form.tabload5.value == "COPY"){
			dataCopy();
		}
		top.document.form.tabload5.value = "LOAD";
		break;

	case IBSEARCH_ASYNC02: // Data Copy
		parent.tabObjects[0].TabBackColor(4) = "#fff270";
		var cntrNo = "";
		var cntr_mf_seq = 0;
		var foundRow = 0;
		var foundFlg = "N";
		var fromRow = 0;
		var toRow = 0;
		var l = 0;

		var rightSelectRow = sheetObjects[0].SelectRow;
		var leftSelectRow  = sheetObjects[1].SelectRow;
		for ( var i = 5; i < sheetObjects[1].RowCount + 5; i++) {
			if (i % 5 == 0) {
				cntrNo = sheetObjects[1].CellValue(i, "cntr_no");
				fromRow = i;
			} else if (i % 5 == 1) {
//				cntr_mf_seq = sheetObjects[1].CellValue(i, "cntr_mf_seq");
				if (sheetObjects[1].CellValue(i-1, "cntr_no") == sheetObjects[1].CellValue(i - 6, "cntr_no")) {
					cntr_mf_seq = cntr_mf_seq + 1;
				} else {
					cntr_mf_seq = 1;
				}
			} else if (i % 5 == 4) {
				foundFlg = "N";
				foundRow = sheetObjects[0].FindText("cntr_no", cntrNo);
				if (foundRow != 0) {
					while (foundRow != -1) {
						if (BkgParseFloat(sheetObjects[0].CellValue(foundRow + 1, "cntr_mf_seq")) == cntr_mf_seq) {
							toRow = foundRow;
							foundFlg = "Y";
							break;
						} else {
							toRow = foundRow + 4;
						}
						foundRow = sheetObjects[0].FindText("cntr_no", cntrNo, foundRow + 1);
					}
				} else {
					toRow = sheetObjects[0].RowCount + 4;
				}
			
				if (foundFlg == "Y") {
					for ( var k = 0; k < 5; k++) {
						if ( k == 3 ) {
							if (ComTrim(sheetObjects[0].CellValue(k + toRow -1, 2)) != null && ComTrim(sheetObjects[0].CellValue(k + toRow -1, 2)).length > 0 ) {
								for ( l = 1; l < 10; l++) {
									sheetObjects[0].CellValue2(k + toRow, l) = sheetObjects[1].CellValue(k + fromRow, l);
								}
							} else {
								for ( l = 1; l < 10; l++) { 
									sheetObjects[0].CellValue2(k + toRow -1, l) = sheetObjects[1].CellValue(k + fromRow, l);
								}
							}
							for ( l = 10; l < 13; l++) {
								if (ComTrim(sheetObjects[1].CellValue(k + fromRow, l)) != null && ComTrim(sheetObjects[1].CellValue(k + fromRow, l)).length > 0 ) {
									sheetObjects[0].CellValue2(k + toRow, l) = ComTrim(sheetObjects[1].CellValue(k + fromRow, l));
								}
							}
						} else {
							if ( k == 4 ) {
								for ( l = 1; l < 13; l++) {
									if ( l < 10 ) {
										sheetObjects[0].CellValue2(k + toRow, l) = sheetObjects[1].CellValue(k + fromRow, l);
									} else {
										if ( sheetObjects[1].CellValue(k + fromRow, l) != null && ComTrim(sheetObjects[1].CellValue(k + fromRow, l)).length > 0 )
											sheetObjects[0].CellValue2(k + toRow, l) = sheetObjects[1].CellValue(k + fromRow, l);
									}
								}
								
							} else {
								// 2017-12-27 이소연과장님 요청으로 Description에 값 체크 로직 제거
//								if ( k == 2 ){
									// Description에 값이 없는 경우에만 Copy 되도록 함. ( 2010.06.08 ) - SR로 접수함. - SRM-201005946
//									if (ComTrim(sheetObjects[0].CellValue(k + toRow, 2)) == null && ComTrim(sheetObjects[0].CellValue(k + toRow, 2)).length == 0 ) {
//										for ( l = 1; l < 10; l++) {
//											sheetObjects[0].CellValue2(k + toRow, l) = sheetObjects[1].CellValue(k + fromRow, l);
//										}
//									}
//									if (ComTrim(sheetObjects[1].CellValue(k + fromRow, 10)) != null && ComTrim(sheetObjects[1].CellValue(k + fromRow, 10)).length > 0 ) {
//										for ( l = 10; l < 14; l++) {
//											sheetObjects[0].CellValue2(k + toRow, l) = sheetObjects[1].CellValue(k + fromRow, l);
//										}
//									}
//									if (ComTrim(sheetObjects[1].CellValue(k + toRow, 11)) != null && ComTrim(sheetObjects[1].CellValue(k + toRow, 11)).length > 0 ) {
//										sheetObjects[0].CellValue2(k + toRow, 11) = sheetObjects[1].CellValue(k + fromRow, 11);
//									}
//								} else {
									for ( l = 1; l < 14; l++) {
										if ( k == 0 && l == 8 && sheetObjects[1].CellValue(k + fromRow, l) != 'KGS' && sheetObjects[1].CellValue(k + fromRow, l) != 'LBS'){
											sheetObjects[0].CellValue2(k + toRow, l) = " ";
										} else if ( k == 0 && l == 11 && sheetObjects[1].CellValue(k + fromRow, l) != 'CBM' && sheetObjects[1].CellValue(k + fromRow, l) != 'CBF' ){
											sheetObjects[0].CellValue2(k + toRow, l) = " ";
										} else {
											sheetObjects[0].CellValue2(k + toRow, l) = sheetObjects[1].CellValue(k + fromRow, l);
										}
									}
//								}
							}
						}
					}
				} else {
					toRow = sheetObjects[0].DataInsert(toRow);
					for( var k = 0; k < 5; k++) {
						sheetObjects[0].RowMerge(k + toRow) = true;
						if ( k == 3 ) {
							if (ComTrim(sheetObjects[0].CellValue(k + toRow -1, 2)) != null && ComTrim(sheetObjects[0].CellValue(k + toRow -1, 2)).length > 0 ) {
								for ( l = 1; l < 10; l++) { 
									sheetObjects[0].CellValue2(k + toRow, l) = sheetObjects[1].CellValue(k + fromRow, l);
								}
							} else {
								for ( l = 1; l < 10; l++) { 
									sheetObjects[0].CellValue2(k + toRow, l) = sheetObjects[1].CellValue(k + fromRow, l);
									sheetObjects[0].CellValue2(k + toRow -1, l) = sheetObjects[1].CellValue(k + fromRow, l);
								}
							}
							for ( l = 10; l < 14; l++) {
								if (ComTrim(sheetObjects[1].CellValue(k + fromRow, l)) != null && ComTrim(sheetObjects[1].CellValue(k + fromRow, l)).length > 0 ) {
									sheetObjects[0].CellValue2(k + toRow, l) = ComTrim(sheetObjects[1].CellValue(k + fromRow, l));
								}
							}
								
						} else {
							for ( l = 1; l < 14; l++) {
								if ( k == 0 && l == 8 && sheetObjects[1].CellValue(k + fromRow, l) != 'KGS' && sheetObjects[1].CellValue(k + fromRow, l) != 'LBS'){
									sheetObjects[0].CellValue2(k + toRow, l) = " ";
								} else if ( k == 0 && l == 11 && sheetObjects[1].CellValue(k + fromRow, l) != 'CBM' && sheetObjects[1].CellValue(k + fromRow, l) != 'CBF' ){
									sheetObjects[0].CellValue2(k + toRow, l) = " ";
								} else {
									sheetObjects[0].CellValue2(k + toRow, l) = sheetObjects[1].CellValue(k + fromRow, l);
								}
							}
						}
					}
				}
			}
		}
		//sheetObjects[0].RemoveAll(); 
//		for ( var i = 5; i < sheetObjects[1].RowCount + 5; i++) {
//			if (i % 5 == 0) {
//				cntrNo = sheetObjects[1].CellValue(i, "cntr_no");
//				fromRow = i;
//			} else if (i % 5 == 4) {
//				toRow = sheetObjects[0].DataInsert(toRow);					
//				for( var k = 0; k < 5; k++) {
//					sheetObjects[0].RowMerge(k + toRow) = true;
//					for ( var l = 1; l < 12; l++) {
//						sheetObjects[0].CellValue2(k + toRow, l) = sheetObjects[1].CellValue(k + fromRow, l);
//					}
//				}
//			}
//		}
		for ( var i = 5; i < sheetObjects[0].RowCount + 5; i = i + 5) {
			if (sheetObjects[0].CellValue(i, "cntr_no") == sheetObjects[0].CellValue(i - 5, "cntr_no")) {
				sheetObjects[0].CellValue(i+1, "cntr_mf_seq") = BkgParseFloat(sheetObjects[0].CellValue(i+1 - 5, "cntr_mf_seq")) + 1;
			} else {
				sheetObjects[0].CellValue(i+1, "cntr_mf_seq") = 1;
			}
		}
		sheetObjects[0].SelectCell(rightSelectRow,1);
		sheetObjects[1].SelectCell(leftSelectRow, 1);
		isCopy = "true";
		break;

	case IBSEARCH_ASYNC03: // CNTR Data Copy
		parent.tabObjects[0].TabBackColor(4) = "#fff270";
		var cntrNo = "";
		var cntr_mf_seq = 0;
		var foundRow = 0;
		var foundFlg = "N";
		var fromRow = 0;
		var toRow = 0;
		var ibflag = "";

		parent.frames("t3frame").doCntrSaveCopy();
		var cstmsDesc = "";
		if (parent.frames("t4frame").document.form){
			cstmsDesc = parent.frames("t4frame").document.form.cstms_desc.value;
		}
		var rightSelectRow = sheetObjects[0].SelectRow;
		var leftSelectRow  = parent.frames("t3frame").sheetObjects[0].SelectRow;
		for ( var i = 1; i < parent.frames("t3frame").sheetObjects[0].RowCount + 1; i++) {
			cntrNo = parent.frames("t3frame").sheetObjects[0].CellValue(i, "cntr_no");
			ibflag = parent.frames("t3frame").sheetObjects[0].CellValue(i, "ibflag");
			if ( ibflag != 'D' ){
				fromRow = i;
				cntr_mf_seq = 1;
				foundFlg = "N";
				foundRow = sheetObjects[0].FindText("cntr_no", cntrNo);
				if (foundRow != 0) {
					while (foundRow != -1) {
						if (BkgParseFloat(sheetObjects[0].CellValue(foundRow + 1, "cntr_mf_seq")) == cntr_mf_seq) {
							toRow = foundRow;
							foundFlg = "Y";
							break;
						} else {
							toRow = foundRow + 4;
						}
						foundRow = sheetObjects[0].FindText("cntr_no", cntrNo, foundRow + 1);
					}
				} else {
					toRow = sheetObjects[0].RowCount;
				}			
				if (foundFlg == "Y") {
					for ( var k = 0; k < 5; k++) {
						if ( k == 0 ) {
	//							sheetObjects[0].CellValue2(k + toRow, 0) = "U";
	//							sheetObjects[0].CellValue2(k + toRow, 1) = "";
	//							sheetObjects[0].CellValue2(k + toRow, 2) = parent.frames("t3frame").sheetObjects[0].CellValue(i, "cntr_no");
	//							sheetObjects[0].CellValue2(k + toRow, 3) = "1";
								sheetObjects[0].CellValue2(k + toRow, 4) = parent.frames("t3frame").sheetObjects[0].CellValue(i, "pck_qty");
								sheetObjects[0].CellValue2(k + toRow, 5) = parent.frames("t3frame").sheetObjects[0].CellValue(i, "pck_tp_cd");
	//							sheetObjects[0].CellValue2(k + toRow, 6) = "";
								sheetObjects[0].CellValue2(k + toRow, 7) = parent.frames("t3frame").sheetObjects[0].CellValue(i, "cntr_wgt");
								sheetObjects[0].CellValue2(k + toRow, 8) = parent.frames("t3frame").sheetObjects[0].CellValue(i, "wgt_ut_cd");
	//							sheetObjects[0].CellValue2(k + toRow, 9) = "";
								sheetObjects[0].CellValue2(k + toRow, 10) = parent.frames("t3frame").sheetObjects[0].CellValue(i, "meas_qty");
								sheetObjects[0].CellValue2(k + toRow, 11) = parent.frames("t3frame").sheetObjects[0].CellValue(i, "meas_ut_cd");
						} else if (k==2){
							for(var colIdx=2;colIdx<10;colIdx++){
								sheetObjects[0].CellValue2(k + toRow, colIdx) = cstmsDesc;
							}
						}
						
					}
				} else {
					toRow = sheetObjects[0].DataInsert(toRow);
					var cntrSeq = toRow/5;
					for( var k = 0; k < 5; k++) {
						sheetObjects[0].RowMerge(k + toRow) = true;
						if ( k == 0 ) {
	//						sheetObjects[0].CellValue2(k + toRow, 0) = "I";
							sheetObjects[0].CellValue2(k + toRow, 1) = cntrSeq;
							sheetObjects[0].CellValue2(k + toRow, 2) = parent.frames("t3frame").sheetObjects[0].CellValue(i, "cntr_no");
	//						sheetObjects[0].CellValue2(k + toRow, 3) = "1";
							sheetObjects[0].CellValue2(k + toRow, 4) = parent.frames("t3frame").sheetObjects[0].CellValue(i, "pck_qty");
							sheetObjects[0].CellValue2(k + toRow, 5) = parent.frames("t3frame").sheetObjects[0].CellValue(i, "pck_tp_cd");
	//						sheetObjects[0].CellValue2(k + toRow, 6) = "1";
							sheetObjects[0].CellValue2(k + toRow, 7) = parent.frames("t3frame").sheetObjects[0].CellValue(i, "cntr_wgt");
							sheetObjects[0].CellValue2(k + toRow, 8) = parent.frames("t3frame").sheetObjects[0].CellValue(i, "wgt_ut_cd");
	//						sheetObjects[0].CellValue2(k + toRow, 9) = "1";
							sheetObjects[0].CellValue2(k + toRow, 10) = parent.frames("t3frame").sheetObjects[0].CellValue(i, "meas_qty");
							sheetObjects[0].CellValue2(k + toRow, 11) = parent.frames("t3frame").sheetObjects[0].CellValue(i, "meas_ut_cd");
						} else if (k==2){
							sheetObjects[0].CellValue2(k + toRow, 1) = cntrSeq;
							for(var colIdx=2;colIdx<10;colIdx++){
								if( cstmsDesc!= '') {
									sheetObjects[0].CellValue2(k + toRow, colIdx) = cstmsDesc;
								} else {
									sheetObjects[0].CellValue2(k + toRow, colIdx) = "  ";
									
								}
							}						
							for(var colIdx=10;colIdx<12;colIdx++){
								sheetObjects[0].CellValue2(k + toRow, colIdx) = " ";
							}
						} else {
							for ( var l = 1; l < 12; l++) {
								if ( l == 1 ) {
									sheetObjects[0].CellValue2(k + toRow, l) = cntrSeq;
								} else if ( k == 1 ) {
								} else {
									if(k==3){
										sheetObjects[0].InitCellProperty(k + toRow, "dcgo_seq", dtData );
										sheetObjects[0].InitCellProperty(k + toRow, "dcgo_seq1", dtData);	
									}
									if( l> 1 && l < 10) {
										sheetObjects[0].CellValue2(k + toRow, l) = " ";
									} else if (l>= 10 ) {
										sheetObjects[0].CellValue2(k + toRow, l) = "  ";
										
									}
								}
							}
						}
					}
				}
			}
		}

		for ( var i = 5; i < sheetObjects[0].RowCount + 5; i = i + 5) {
			if (sheetObjects[0].CellValue(i, "cntr_no") == sheetObjects[0].CellValue(i - 5, "cntr_no")) {
				sheetObjects[0].CellValue(i+1, "cntr_mf_seq") = BkgParseFloat(sheetObjects[0].CellValue(i+1 - 5, "cntr_mf_seq")) + 1;
			} else {
				sheetObjects[0].CellValue(i+1, "cntr_mf_seq") = 1;
			}
		}
		sheetObjects[0].SelectCell(rightSelectRow,1);
		sheetObjects[1].SelectCell(leftSelectRow, 1);
		isCopy = "true";
		break;
	
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	var porCd = parent.frames("t1frame").document.form.bkg_por_cd.value;
	var polCd = parent.frames("t1frame").document.form.bkg_pol_cd.value;
	var podCd = parent.frames("t1frame").document.form.bkg_pod_cd.value;
	var delCd = parent.frames("t1frame").document.form.bkg_del_cd.value;
	
//	var rcnt = sheetObj.RowCount;
	for(var ix=5;ix<sheetObj.RowCount+5;ix++){		
		if(ix%5==0){ //1 row
			if(sheetObj.CellValue(ix, 4) == ''||sheetObj.CellValue(ix, 4) == null||sheetObj.CellValue(ix, 4) == 0) { //pck_qty
				ComShowMessage(ComGetMsg("BKG00504"));
				return false;
			}
			if(sheetObj.CellValue(ix, 5) == ''||sheetObj.CellValue(ix, 5) == null) { //pck_tp_cd
				ComShowMessage(ComGetMsg("BKG00505"));
				return false;
			}
			if((sheetObj.CellValue(ix, 8) == ''||sheetObj.CellValue(ix, 8) == null) && (sheetObj.CellValue(ix, 7) != '0'||sheetObj.CellValue(ix, 7) != ''||sheetObj.CellValue(ix, 7) != null)) { //wgt_ut_cd
				ComShowMessage(ComGetMsg("BKG00767", "Weight unit"));
				return false;
			}
			if((sheetObj.CellValue(ix, 11) == ''||sheetObj.CellValue(ix, 11) == null) && (sheetObj.CellValue(ix, 10) != '0'||sheetObj.CellValue(ix, 10) != ''||sheetObj.CellValue(ix, 10) != null)) { //meas_ut_cd
				ComShowMessage(ComGetMsg("BKG00767", "Measure unit"));
				return false;
			}
			//[CHM-201641324] DEL이 바레인일 때 measure값이 0이면 save block			
			if((BkgParseFloat(sheetObj.CellValue(ix, 10)) <= 0 || sheetObj.CellValue(ix, 10) == ''||sheetObj.CellValue(ix, 10) == null) && "BH"==delCd.substring(0,2)){
				ComShowMessage(ComGetMsg("BKG95112"));
				return false;
			}
			var bkgPorCd = parent.frames("t1frame").document.form.bkg_por_cd.value;
			var bkgPolCd = parent.frames("t1frame").document.form.bkg_pol_cd.value;
			if(bkgPorCd.substring(0, 2) == "BR" || bkgPolCd.substring(0, 2) == "BR"){
				// Split 01-CNTR Weight minimum check 로직 추가 요청
				if(sheetObj.CellValue(ix, 7) != '' && sheetObj.CellValue(ix, 7) < 1000) { //weight경우                                             
					/* 최초 한번 CNTR WGT에 대한 오류 확인 시 창이 Active 된 상태에서는				}
	                                     재 저장시 Weight에 대한 Validation 체크 로직을 Skip 함 */
					if( formObj.br_wgt_chk_flg.value == 'N') {   // 창 오픈 후 최초 Save 시만...                                                       
						formObj.br_wgt_chk_flg.value = "Y";
						ComShowMessage(ComGetMsg("BKG08265")); 
						return false;
					}
				}
			}
			
		} else if(ix%5==1){ //2 row
//			if(formObj.hts_flg.value == 'Y' && sheetObj.CellValue(ix, "hamo_trf_cd") == ''){
//				ComShowMessage(ComGetMsg("BKG00334", 'HTS'));
//				return false;
//			}
			if((ComTrim(sheetObj.CellValue(ix, 4)) != '' && ComTrim(sheetObj.CellValue(ix, 4)) != null) 
				&& ComTrim(sheetObj.CellValue(ix, 4)).length < 6) {//hamo_trf_cd
				ComShowMessage(ComGetMsg("BKG00334", 'HTS'));
				return false;
			}
		
			// POD or DEL이 SY(Syria) 일때 C/M의 HS Code가 Null이면 'BKG08226'  
			if (ComTrim(sheetObj.CellValue(ix, 'cmdt_hs_cd1')) == '' || ComTrim(sheetObj.CellValue(ix, 'cmdt_hs_cd1')) == null) {
				var pod_cnt = (podCd == '') ? '' : podCd.substring(0, 2);
				var del_cnt = (delCd == '') ? '' : delCd.substring(0, 2);				
				if (pod_cnt == 'SY' || del_cnt =='SY') {
					ComShowMessage(ComGetMsg("BKG08226"));
					return false;
				}
				// 국가코드가 'JP'인 경우 HS code 값 validation 체크
				if (pod_cnt == 'JP' && parent.frames("t1frame").document.form.doc_tp_cd.value == "S") {
					ComShowMessage(ComGetMsg("BKG08287"));
					return false;
				}
				
				if (pod_cnt == 'TR' && parent.frames("t1frame").document.form.doc_tp_cd.value == "S") {
					ComShowMessage(ComGetMsg("BKG08322"));					
					return false;
				}
			}
		
			if(ComTrim(sheetObj.CellValue(ix, 10)) == ''||ComTrim(sheetObj.CellValue(ix, 10))==null) {//ncm_no	
				var por_cnty = (porCd == '') ? '' : porCd.substring(0, 2);
				var pol_cnty = (polCd == '') ? '' : polCd.substring(0, 2);
				var pod_cnty = (podCd == '') ? '' : podCd.substring(0, 2);
				var del_cnty = (delCd == '') ? '' : delCd.substring(0, 2);
				if(por_cnty == 'BR' || pol_cnty == 'BR' || pod_cnty == 'BR' || del_cnty == 'BR'){
					ComShowMessage(ComGetMsg("BKG00334", 'NCM'));
					return false;
				}
			} else {
				var param = "f_cmd=" + SEARCH01 + "&ncm_no=" + sheetObj.CellValue(ix, 10);
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_07GS.do", param);
				
				var cmdt_desc = ComGetEtcData(sXml, "cmdt_desc");
				if( cmdt_desc == "" ){
					ComShowCodeMessage("BKG06060", sheetObj.CellValue(ix, 10));	//Invalid NCM Code(?msg1)	    			
					return false;
				}
			}
		} else if(ix%5==2){ //3 row
			if(sheetObj.CellValue(ix, 3).trim() == '') {
				ComShowMessage(ComGetMsg("BKG01042"));
				return false;
			}
			if(ComTrim(sheetObj.CellValue(ix, "cntr_mf_gds_desc")) != '') {				
	           var cgoDesc = sheetObj.CellValue(ix, "cntr_mf_gds_desc");
	           var cnt = 0;
	           for (var inx = 0; inx < cgoDesc.length; inx++) {
	             if ( ComIsAlphabet(cgoDesc.charAt(inx))) cnt++;
	             if ( cnt == 3 ) break;
	           }                              
	           if ( cnt < 3 ) {		            
	        	   ComShowCodeMessage('BKG95108'); //At least, 3 alphabet characters should be included in description column. please check it again.
	        	   return false;
	           }
			}
		}
	} // end of FOR

	return true;
}

 /**
  * 전체 Upload 버튼 CLICK시 호출 됨 TAB에 상관 없이 동일 이름의 함수를 가짐 내용은 TAB에 맞게 구현 Validate 실패
  * 후 Focus 이동이 필요하면 (ex) Mandatory 항목 누락 후 Mandatory 필드에 Focus 이동 Focus 이동까지 한 후
  * return false
  */
function validateForUpload() {
 	return validateForm(sheetObjects[0], document.form, IBSAVE);
}

  /**
   * 전체 Upload 버튼 CLICK시 호출 됨 TAB에 상관 없이 동일 이름의 함수를 가짐 내용은 TAB에 맞게 구현 각 화면에서
   * Upload 버튼이 눌렸을 때 SC에 parameter 로 던지는 QueryString을 만들어 return
   */
function getSaveStringForUpload() {
  	var formObj = document.form;
  	formObj.f_cmd.value = MULTI;

  	//2013-01-07 [CHM-201322261-01] Marble 운송사고 예방을 위한 Booking-Special Stowage (MUPG) 자동지정 프로그래밍 요청 - Start
	var stwg_flg = false
	var cmdtCd = parent.frames("t1frame").document.form.cmdt_cd.value;
	if( cmdtCd == "251506" || cmdtCd == "251501" || cmdtCd == "250031" || cmdtCd == "251603" ){
		for( var idx = sheetObjects[0].HeaderRows; idx <= sheetObjects[0].LastRow; idx = idx + 5 ){
			if( sheetObjects[0].CellValue(idx + 2,"cntr_tpsz_cd") == "D2" ){
				if( sheetObjects[0].CellValue(idx,"cntr_wgt") != "" && sheetObjects[0].CellValue(idx,"pck_qty") != "" ){
					if( parseFloat(sheetObjects[0].CellValue(idx,"cntr_mf_wgt")) / parseFloat(sheetObjects[0].CellValue(idx,"pck_qty")) >= 5000 ){
						stwg_flg = true;
					}
				}
			}
		}
	}
	if( stwg_flg == true ){
		document.form.stwg_cd.value = "MUPG";
	} else{
		document.form.stwg_cd.value = "";
	}
	//2013-01-07 [CHM-201322261-01] Marble 운송사고 예방을 위한 Booking-Special Stowage (MUPG) 자동지정 프로그래밍 요청 - End
	
  	var params = "f_cmd=" + MULTI + "&sheet1_stwg_cd=" + formObj.stwg_cd.value;
  	
  	if (sheetObjects[0].RowCount>0) {
  		// IBSheet에 컬럼명 변경으로 하나에 값만 가도록 함.
  		params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true), "sheet1_");
  	} else {
  		params = "";
  	}
  	return (params);
}
  
function dataCopy() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	ComBtnColor("btn_cancelcopydata", "#737373");
	ComBtnColor("btn_copyfromcntr", "#737373");
	ComBtnColor("btn_datacopytoalps", "blue");	
	check_ncmMulti(sheetObjects[0]);
}

function cntrDataCopy() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
	ComBtnColor("btn_copyfromcntr", "blue");
	ComBtnColor("btn_cancelcopydata", "#737373");
	ComBtnColor("btn_datacopytoalps", "#737373");
}

function compareItem() {
	var formObj = document.form;
//	setDiffCheckColor(formObj.mk_desc.value,   formObj.mk_desc2.value,   "mk_desc2");
//	
//	setDiffCheckColor(formObj.pck_qty.value,   formObj.pck_qty2.value,   "pck_qty2");
//	setDiffCheckColor(formObj.pck_tp_cd.value, formObj.pck_tp_cd2.value, "pck_tp_cd2");
//	setDiffCheckColor(formObj.act_wgt.value,   formObj.act_wgt2.value,   "act_wgt2");
//	setDiffCheckColor(formObj.wgt_ut_cd.value, formObj.wgt_ut_cd2.value, "wgt_ut_cd2");
//	setDiffCheckColor(formObj.meas_qty.value,  formObj.meas_qty2.value,  "meas_qty2");
//	setDiffCheckColor(formObj.meas_ut_cd.value,  formObj.meas_ut_cd2.value,  "meas_ut_cd2");
//
//	setDiffCheckColor(formObj.dg_cmdt_desc.value, formObj.dg_cmdt_desc2.value, "dg_cmdt_desc2");
}
/**
 * 데이터 한건 추가
 */
function insertSheet(cntrNo, pos) {
	var lastRow = 5;
	// sheetObjects[0].DataInsert(-1);

	sheetObjects[0].Redraw = false;
	var sXml1 = IBS_GetDataSearchXml(sheetObjects[1]);
	sheetObjects[0].DataAutoTrim = false;
	sXml1 = ComReplaceStr(sXml1, "<TR", "<TR MERGE='TRUE'");

	sheetObjects[0].LoadSearchXml(sXml1, true);
	sheetObjects[0].Redraw = true;
}

/**
 * 데이터 한건 수정
 */
function updateSheet(cntrNo, lastRow, pos) {
	sheetObjects[0].CellValue(lastRow, "cntr_no") 		= sheetObjects[1].CellValue(pos, "cntr_no");
	sheetObjects[0].CellValue(lastRow, "pck_qty")		= sheetObjects[1].CellValue(pos, "pck_qty");
	sheetObjects[0].CellValue(lastRow, "pck_tp_cd") 	= sheetObjects[1].CellValue(pos, "pck_tp_cd");
	sheetObjects[0].CellValue(lastRow, "cntr_mf_wgt") 	= sheetObjects[1].CellValue(pos, "cntr_mf_wgt");
	sheetObjects[0].CellValue(lastRow, "wgt_ut_cd") 	= sheetObjects[1].CellValue(pos, "wgt_ut_cd");
	sheetObjects[0].CellValue(lastRow, "meas_qty") 		= sheetObjects[1].CellValue(pos, "meas_qty");
	sheetObjects[0].CellValue(lastRow, "meas_ut_cd") 	= sheetObjects[1].CellValue(pos, "meas_ut_cd");
	sheetObjects[0].CellValue(lastRow, "sep1") 	= "|";
	sheetObjects[0].CellValue(lastRow, "sep2") 	= "|";
	sheetObjects[0].CellValue(lastRow, "sep3") 	= "|";

	sheetObjects[0].CellValue(lastRow + 1, "cntr_mf_seq") 	= sheetObjects[1].CellValue(pos + 1, "cntr_mf_seq");
	sheetObjects[0].CellValue(lastRow + 1, "hamo_trf_cd") 	= sheetObjects[1].CellValue(pos + 1, "hamo_trf_cd");
//	sheetObjects[0].CellValue(lastRow + 1, "hamo_trf_cd") 	= sheetObjects[1].CellValue(pos + 1, "hamo_trf_cd");
	sheetObjects[0].CellValue(lastRow + 1, "ncm_no") 		= sheetObjects[1].CellValue(pos + 1, "ncm_no");
//	sheetObjects[0].CellValue(lastRow + 1, "ncm_no") 		= sheetObjects[1].CellValue(pos + 1, "ncm_no");
	sheetObjects[0].CellValue(lastRow + 1, "po_no") 		= sheetObjects[1].CellValue(pos + 1, "po_no");
//	sheetObjects[0].CellValue(lastRow + 1, "po_no") 		= sheetObjects[1].CellValue(pos + 1, "po_no");
	sheetObjects[0].CellValue(lastRow, "sep1") 	= "|";
	sheetObjects[0].CellValue(lastRow, "sep2") 	= "|";
	sheetObjects[0].CellValue(lastRow, "sep3") 	= "|";

	sheetObjects[0].CellValue(lastRow + 2, "cntr_mf_gds_desc") = sheetObjects[1].CellValue(pos + 2, "cntr_mf_gds_desc");
//	sheetObjects[0].CellValue(lastRow + 2, "cntr_mf_gds_desc") = sheetObjects[1].CellValue(pos + 2, "cntr_mf_gds_desc");
//	sheetObjects[0].CellValue(lastRow + 2, "cntr_mf_gds_desc") = sheetObjects[1].CellValue(pos + 2, "cntr_mf_gds_desc");
//	sheetObjects[0].CellValue(lastRow + 2, "cntr_mf_gds_desc") = sheetObjects[1].CellValue(pos + 2, "cntr_mf_gds_desc");
//	sheetObjects[0].CellValue(lastRow + 2, "cntr_mf_gds_desc") = sheetObjects[1].CellValue(pos + 2, "cntr_mf_gds_desc");
//	sheetObjects[0].CellValue(lastRow + 2, "cntr_mf_gds_desc") = sheetObjects[1].CellValue(pos + 2, "cntr_mf_gds_desc");
//	sheetObjects[0].CellValue(lastRow + 2, "cntr_mf_gds_desc") = sheetObjects[1].CellValue(pos + 2, "cntr_mf_gds_desc");

	sheetObjects[0].CellValue(lastRow + 3, "cntr_mf_dtl_desc") = sheetObjects[1].CellValue(pos + 3, "cntr_mf_dtl_desc");
//	sheetObjects[0].CellValue(lastRow + 3, "cntr_mf_dtl_desc") = sheetObjects[1].CellValue(pos + 3, "cntr_mf_dtl_desc");
//	sheetObjects[0].CellValue(lastRow + 3, "cntr_mf_dtl_desc") = sheetObjects[1].CellValue(pos + 3, "cntr_mf_dtl_desc");
//	sheetObjects[0].CellValue(lastRow + 3, "cntr_mf_dtl_desc") = sheetObjects[1].CellValue(pos + 3, "cntr_mf_dtl_desc");
//	sheetObjects[0].CellValue(lastRow + 3, "cntr_mf_dtl_desc") = sheetObjects[1].CellValue(pos + 3, "cntr_mf_dtl_desc");
//	sheetObjects[0].CellValue(lastRow + 3, "cntr_mf_dtl_desc") = sheetObjects[1].CellValue(pos + 3, "cntr_mf_dtl_desc");
//	sheetObjects[0].CellValue(lastRow + 3, "cntr_mf_dtl_desc") = sheetObjects[1].CellValue(pos + 3, "cntr_mf_dtl_desc");

	sheetObjects[0].CellValue(lastRow + 4, "cntr_mf_mk_desc") = sheetObjects[1].CellValue(pos + 4, "cntr_mf_mk_desc");
//	sheetObjects[0].CellValue(lastRow + 4, "cntr_mf_mk_desc") = sheetObjects[1].CellValue(pos + 4, "cntr_mf_mk_desc");
//	sheetObjects[0].CellValue(lastRow + 4, "cntr_mf_mk_desc") = sheetObjects[1].CellValue(pos + 4, "cntr_mf_mk_desc");
//	sheetObjects[0].CellValue(lastRow + 4, "cntr_mf_mk_desc") = sheetObjects[1].CellValue(pos + 4, "cntr_mf_mk_desc");
//	sheetObjects[0].CellValue(lastRow + 4, "cntr_mf_mk_desc") = sheetObjects[1].CellValue(pos + 4, "cntr_mf_mk_desc");
//	sheetObjects[0].CellValue(lastRow + 4, "cntr_mf_mk_desc") = sheetObjects[1].CellValue(pos + 4, "cntr_mf_mk_desc");
//	sheetObjects[0].CellValue(lastRow + 4, "cntr_mf_mk_desc") = sheetObjects[1].CellValue(pos + 4, "cntr_mf_mk_desc");
	sheetObjects[0].Redraw = true;
}


function sheet1_OnChange(sheetObj, Row, Col, Value){
	var srcName = sheetObj.ColSaveName(Col);
	
	// 2018.05.25 iylee Form Change 일때 소문자 -> 대문자로 바꾸어줌.
	ComSetSheetUpperChange(sheetObj, Row, Col);
	
	if( Row%5==2 ){
		//cntr_mf_gds_desc, cntr_mf_dtl_desc 대문자로
		if ( Col != 10 && Col != 11 ) {
			sheetObj.CellValue2(Row, 2) = Value.toUpperCase();
			sheetObj.CellValue2(Row, 3) = Value.toUpperCase();
			sheetObj.CellValue2(Row, 4) = Value.toUpperCase();
			sheetObj.CellValue2(Row, 5) = Value.toUpperCase();
			sheetObj.CellValue2(Row, 6) = Value.toUpperCase();
			sheetObj.CellValue2(Row, 7) = Value.toUpperCase();
			sheetObj.CellValue2(Row, 8) = Value.toUpperCase();
			sheetObj.CellValue2(Row, 9) = Value.toUpperCase();
		} else {
			if(Col==10)sheetObj.CellValue2(Row,10) = Value.toUpperCase();
			if(Col==11)sheetObj.CellValue2(Row,11) = Value.toUpperCase();
		}
	} else if(Row%5==3){
		//cntr_mf_gds_desc, cntr_mf_dtl_desc 대문자로
		if ( Col != 10 && Col != 11 ) {
			sheetObj.CellValue2(Row, 2) = Value.toUpperCase();
			sheetObj.CellValue2(Row, 3) = Value.toUpperCase();
			sheetObj.CellValue2(Row, 4) = Value.toUpperCase();
			sheetObj.CellValue2(Row, 5) = Value.toUpperCase();
			sheetObj.CellValue2(Row, 6) = Value.toUpperCase();
			sheetObj.CellValue2(Row, 7) = Value.toUpperCase();
			sheetObj.CellValue2(Row, 8) = Value.toUpperCase();
			sheetObj.CellValue2(Row, 9) = Value.toUpperCase();
		} else {
			sheetObj.CellValue2(Row,10) = Value.toUpperCase();//DG Seq
			sheetObj.CellValue2(Row,11) = Value.toUpperCase();//DG Seq
		}
	} else if(Row%5==1){
		if(Col==4) sheetObj.CellValue2(Row, 5) = Value.toUpperCase();//hts
		if(Col==5) sheetObj.CellValue2(Row, 4) = Value.toUpperCase();//hts
		if(Col==7) sheetObj.CellValue2(Row, 8) = Value.toUpperCase();//hs
		if(Col==8) sheetObj.CellValue2(Row, 7) = Value.toUpperCase();//hs
		if(Col==10)sheetObj.CellValue2(Row,11) = Value.toUpperCase();//ncm
		if(Col==11)sheetObj.CellValue2(Row,10) = Value.toUpperCase();//ncm

	} else if(Row%5==4) {
		if(Col==10 || Col == 11 ) {
		//	 Manifest File No 대문자로 - 2010.05.10 - Manifest File No 추가함.
			sheetObj.CellValue2(Row, 10) = Value.toUpperCase();
			sheetObj.CellValue2(Row, 11) = Value.toUpperCase();
		} else {
		//   cntr_mf_mk_desc, 대문자로
			sheetObj.CellValue2(Row, 2) = Value.toUpperCase();
			sheetObj.CellValue2(Row, 3) = Value.toUpperCase();
			sheetObj.CellValue2(Row, 4) = Value.toUpperCase();
			sheetObj.CellValue2(Row, 5) = Value.toUpperCase();
			sheetObj.CellValue2(Row, 6) = Value.toUpperCase();
			sheetObj.CellValue2(Row, 7) = Value.toUpperCase();
			sheetObj.CellValue2(Row, 8) = Value.toUpperCase();
			sheetObj.CellValue2(Row, 9) = Value.toUpperCase();
		}
	} else if(Row%5==0) {
		if ( sheetObj.ColSaveName(Col) == "cntr_no" ) {
			if ( sheetObj.CellValue(Row, "cntr_no_old") != Value ){
				sheetObj.CellValue2(Row+3,10) = '';//dcgo_seq
				sheetObj.CellValue2(Row+3,11) = '';//dcgo_seq
				sheetObj.CellValue2(Row, "cntr_no_old") = Value;
			}
		}
	}				
	isCopy = "false";
}
/**
 * IBSheet Object에서 팝업을 클릭시
 */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
	var formObject = document.form;
	var param = "";
	
	if (sheetObj.ColSaveName(Col) == "pck_tp_cd"||sheetObj.ColSaveName(Col) == "pck_qty") {
		comBkgCallPop0607("setCallBack0607", "T", sheetObjects[0].CellValue(Row,"pck_qty"));
		selRow = Row;
		selCol = Col;
	} else if (sheetObj.ColSaveName(Col) == "meas_ut_cd"||sheetObj.ColSaveName(Col) == "meas_qty") {
//		var sUrl = "/hanjin/ESM_BKG_0745.do?ncm_no="+sheetObjects[0].CellValue(Row, "meas_qty"); 
//		var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0745", 1024, 550, true);
//		if (rtnVal != null) {
//			sheetObjects[0].CellValue2(Row, Col - 1) = rtnVal.cd;
//			sheetObjects[0].CellValue2(Row, Col) = rtnVal.cd;
//		}
//  multi 입력창에서 ESM_BKG_0745 호출되도로 변경함. 2013.02.22 
		
			var param = "";
			param = param + "?bl_no=" + document.form.bkg_no.value;
			param = param + "&cntr_no=" + sheetObj.CellValue(Row -1,"cntr_no");
			param = param + "&cntr_mf_seq=" + sheetObj.CellValue(Row,"cntr_no");
			param = param + "&ncm_multi_no=" + sheetObj.CellValue(Row,"empty00");
			param = param + "&org_sheet=" + "0";
			param = param + "&org_row=" + Row;
			param = param + "&org_ui_id=" + "ESM_BKG_0229_05";
			ComOpenPopup('/hanjin/ESM_BKG_1154.do' + param, 340,420,'', '1,0,1,1,1,1,1,1', true);
			
			check_ncmMulti(sheetObj);
		
	} else if (sheetObj.ColSaveName(Col) == "wgt_ut_cd"||sheetObj.ColSaveName(Col) == "cntr_mf_wgt") {
				comBkgCallPop0607("setCallBack0607", "H", sheetObjects[0].CellValue(Row,"cntr_mf_wgt"));
				selRow = Row;
				selCol = Col;
	}
}
 
 /**
  * 시트의 선택한 Row의 Container 에 해당하는 CM을 하단 그리드에 표시
  */ 
 function sheet1_OnClick(sheetObj, Row, Col){
	var srcName = sheetObj.ColSaveName(Col);
	var dcgoList = '';
	var dcgovalue = '';
	dcgoList = dcgoList + " |";
	dcgovalue = dcgovalue + " |";
	if(Row%5==3 && ( Col == 10 || Col == 11 )){
		var cntr_no = sheetObj.CellValue(eval(parseInt(Row/5)*5), 'cntr_no');
		if (parent.frames("t8frame").document.form) {
			var cntrSheet = parent.frames("t8frame").sheetObjects[0];
			for(var i=cntrSheet.HeaderRows;i<=cntrSheet.Rows;i++){
				if( cntr_no == cntrSheet.CellValue(i, "cntr_no") ){
//						//'Seq'||DG_CNTR_SEQ||'-'||'Un No: '||IMDG_UN_NO||',Dcgo Seq : '||DCGO_SEQ|| ',Class : '||IMDG_CLSS_CD DIFF_RMK
					dcgoList = dcgoList + "Seq : "+cntrSheet.CellValue(i, "dcgo_seq")+
							              ", Un No : "+cntrSheet.CellValue(i, "imdg_un_no")+
					                      ", Class : "+cntrSheet.CellValue(i, "imdg_clss_cd")+"|";
					dcgovalue = dcgovalue + cntrSheet.CellValue(i, "dcgo_seq") + "|";
				}
			}
		}
		sheetObj.InitCellProperty(Row, "dcgo_seq", dtNull );
		sheetObj.InitCellProperty(Row, "dcgo_seq1", dtNull);
		sheetObj.InitDataCombo(3,	"dcgo_seq",	dcgoList, dcgovalue);
		sheetObj.InitDataCombo(3,	"dcgo_seq1",	dcgoList, dcgovalue);
//	} else {
//		sheetObj.InitCellProperty(Row, "dcgo_seq", dtData );
//		sheetObj.InitCellProperty(Row, "dcgo_seq1", dtData);
	}
  // pop_up클릭기능이 잘 실행 되지 않아 Click 시에도 추가함. 
	  if ((Row % 5 == 1) &&( srcName == "meas_ut_cd"||srcName == "meas_qty")) {
				var param = "";
				param = param + "?bl_no=" + document.form.bkg_no.value;
				param = param + "&cntr_no=" + sheetObj.CellValue(Row -1,"cntr_no");
				param = param + "&cntr_mf_seq=" + sheetObj.CellValue(Row,"cntr_no");
				param = param + "&ncm_multi_no=" + sheetObj.CellValue(Row,"empty00");
				param = param + "&org_sheet=" + "0";
				param = param + "&org_row=" + Row;
				param = param + "&org_ui_id=" + "ESM_BKG_0229_05";
				ComOpenPopup('/hanjin/ESM_BKG_1154.do' + param, 340,420,'', '1,0,1,1,1,1,1,1', true);
			
		} 
}
 function sheet2_OnClick(sheetObj, Row, Col){
		var srcName = sheetObj.ColSaveName(Col);

		  if ((Row % 5 == 1) &&( srcName == "meas_ut_cd"||srcName == "meas_qty")) {
					var param = "";
					param = param + "?bl_no=" + document.form.bkg_no.value;
					param = param + "&cntr_no=" + sheetObj.CellValue(Row -1,"cntr_no");
					param = param + "&cntr_mf_seq=" + sheetObj.CellValue(Row,"cntr_no");
					param = param + "&ncm_multi_no=" + sheetObj.CellValue(Row,"empty00");
					param = param + "&org_sheet=" + "1";
					param = param + "&org_row=" + Row;
					param = param + "&org_ui_id=" + "ESM_BKG_0229_05_R";
					ComOpenPopup('/hanjin/ESM_BKG_1154.do' + param, 340,420,'', '1,0,1,1,1,1,1,1', true);
				
			} 
}
  
function setCallBack0607(aryPopupData) {
	var sheetObject = sheetObjects[0];
//	sheetObject.CellValue(selRow, selCol -1) = aryPopupData[0][3];
	sheetObject.CellValue(selRow, selCol) = aryPopupData[0][3];
}

///**
//* IBSheet에 특정 컬럼이 체크된 데이터행 또는 모든 데이터행을 조회XML로 구성하여 반환한다. <br>
//*/
//function ComMakeXml(cntrNo, pos) {
//	try {
//		var allXml = "";
//
//		allXml += " <TR MERGE='TRUE'>\n";
//		allXml += " <TD><![CDATA[" + String(sheetObjects[1].CellValue(pos, 0)) + "]]></TD>\n";
//		allXml += " <TD BGCOLOR='204, 204, 204'><![CDATA[" + String(sheetObjects[1].CellValue(pos, 1)) + "]]></TD>\n";
//		for (ic = 2; ic <= sheetObjects[1].LastCol; ic++) {
//			allXml += " <TD><![CDATA[" + String(sheetObjects[1].CellValue(pos, ic)) + "]]></TD>\n";
//		}
//		allXml += " </TR>\n";
//		allXml += " <TR MERGE='TRUE'>\n";
//		allXml += " <TD><![CDATA[" + String(sheetObjects[1].CellValue(pos + 1, 0)) + "]]></TD>\n";
//		allXml += " <TD BGCOLOR='204, 204, 204'><![CDATA[" + String(sheetObjects[1].CellValue(pos + 1, 1)) + "]]></TD>\n";
//		allXml += " <TD BGCOLOR='204, 204, 204'><![CDATA[" + String(sheetObjects[1].CellValue(pos + 1, 2)) + "]]></TD>\n";
//		for (ic = 3; ic <= sheetObjects[1].LastCol; ic++) {
//			allXml += " <TD><![CDATA[" + String(sheetObjects[1].CellValue(pos + 1, ic)) + "]]></TD>\n";
//		}
//		allXml += " </TR>\n";
//		allXml += " <TR MERGE='TRUE'>\n";
//		allXml += " <TD><![CDATA[" + String(sheetObjects[1].CellValue(pos + 2, 0)) + "]]></TD>\n";
//		allXml += " <TD BGCOLOR='204, 204, 204'><![CDATA[" + String(sheetObjects[1].CellValue(pos + 2, 1)) + "]]></TD>\n";
//		for (ic = 2; ic <= sheetObjects[1].LastCol; ic++) {
//			allXml += " <TD><![CDATA[" + String(sheetObjects[1].CellValue(pos + 2, ic)) + "]]></TD>\n";
//		}
//		allXml += " </TR>\n";
//		allXml += " <TR MERGE='TRUE'>\n";
//		allXml += " <TD><![CDATA[" + String(sheetObjects[1].CellValue(pos + 3, 0)) + "]]></TD>\n";
//		allXml += " <TD BGCOLOR='204, 204, 204'><![CDATA[" + String(sheetObjects[1].CellValue(pos + 3, 1)) + "]]></TD>\n";
//		for (ic = 2; ic <= sheetObjects[1].LastCol; ic++) {
//			allXml += " <TD><![CDATA[" + String(sheetObjects[1].CellValue(pos + 3, ic)) + "]]></TD>\n";
//		}
//		allXml += " </TR>\n";
//		allXml += " <TR MERGE='TRUE'>\n";
//		allXml += " <TD><![CDATA[" + String(sheetObjects[1].CellValue(pos + 4, 0)) + "]]></TD>\n";
//		allXml += " <TD BGCOLOR='204, 204, 204'><![CDATA[" + String(sheetObjects[1].CellValue(pos + 4, 1)) + "]]></TD>\n";
//		for (ic = 2; ic <= sheetObjects[1].LastCol; ic++) {
//			allXml += " <TD><![CDATA[" + String(sheetObjects[1].CellValue(pos + 4, ic)) + "]]></TD>\n";
//		}
//		allXml += " </TR>\n";
//
//		return allXml;
//	} catch (err) {
//		ComFuncErrMsg(err.message);
//	}
//}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	check_ncmMulti(sheetObj);
}

function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	check_ncmMulti(sheetObj);
}

function check_ncmMulti(sheetObj) {
	for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
		var ncmMulti = sheetObj.CellValue(i, "empty00");
		var ncm = sheetObj.CellValue(i, "meas_qty");
		if (i%5 == 1 && ncmMulti != ncm && ncmMulti !="" ){
			sheetObj.CellBackColor(i,"meas_qty") = sheetObj.RgbColor(252, 196, 245);
			
		}
		if (i%5 == 1 ){
			sheetObj.CellValue2(i,11) = sheetObj.CellValue(i,10);
			sheetObj.CellValue2(i,10) = sheetObj.CellValue(i,11);
		}
	}
}
