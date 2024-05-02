﻿/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0229_09.js
 *@FileTitle : e-Booking & SI Process Detail(AWKWARD)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.29
 *@LastModifier : 전용진
 *@LastVersion : 1.0
 * 2009.06.29 전용진
 * 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2010.11.08 김영철 [CHM-201006978-01] AK 화면의 Commodity 입력 포맷을 RF와 동일하게 수정하고 BKG 메인의 Commoidty 코드가 자동 I/F
 2012.11.05 김현화 [CHM-201220991] Split 02-O5 추가 관련 프로그램 수정- O4 와 동일하게 처리.  
=========================================================*/
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
 * @class esm_bkg_0229_09 : esm_bkg_0229_09 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0229_09() {
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

var comboObjects = new Array();
var comboCnt = 0;

var iterator = "|$$|";

var isCopy = "false";

var akPosition = 0;

var cntrTpsz_cd = "";
var cntrTpsz_id = "";

var wgt_cd = "";
var wgt_nm = "";

var prefix = "t9sheet1_";
var max_awk_cgo_seq = 0;

var div1sheet1 = null;
var div2sheet1 = null;
var awkCriteriaSheet = null;

var BKG_DIV_NAME = "_Bkg_div1_";
var BKG_FRAME_NAME = "_Bkg_iframe1_";
var BKG_DIV_NAME2 = "_Bkg_div2_";
var BKG_FRAME_NAME2 = "_Bkg_iframe2_";

var iframeW = 190;
var iframeH = 100;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	
	var sheetIdx = 0;
	div1sheet1 			= sheetObjects[sheetIdx++];
	div2sheet1 			= sheetObjects[sheetIdx++];
	var sheetObject = sheetObjects[sheetIdx++];
	awkCriteriaSheet = sheetObjects[sheetIdx++];
	
	//var sheetObject = sheetObjects[2];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case IBCLEAR:
			doActionIBSheet(sheetObjects[2], document.form, IBCLEAR);
			break;
		case "btn_cancelcopydata":
			parent.document.form.awkwardTabCancel.value = "Y";
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
			isCopy = "false";
			top.isCopyAllRequested = false;
			break;
		case "btn_datacopytoalps":
			doSaveCopy();
			if (isCopy == "false") {
				dataCopy();
			}
			copyCmdt();
			break;
		case "btn_upload":
			doActionIBSheet(sheetObjects[2], document.form, IBSAVE);
			break;
		case "btn_akRider":
			doSaveCopy();
			showAkRider();
			break;		
		case "btn_akRider2":			
			showAkRider2();
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
 * Sheet 기본 설정 및 초기화
 
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	
	var sheetLen = sheetObjects.length;
	for (i = 0; i < sheetLen; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	var sheetIdx = 0;
    div1sheet1 			= sheetObjects[sheetIdx++];
    div2sheet1 			= sheetObjects[sheetIdx++];
    sheetObject1 		= sheetObjects[sheetIdx++];

    divLayer_Config();
	doActionIBSheet(sheetObjects[2], document.form, IBCLEAR);
	initControl();
}

function initControl() {
	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject);
	axon_event.addListenerForm("change", "form_onChange", formObject);

	applyShortcut();
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
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1":
		//with (sheetObj) {
			// 높이 설정
		sheetObj.style.height = 0;
			// 전체 너비 설정
		sheetObj.SheetWidth = 390;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "ibflag|bkg_no|awk_cgo_seq|cntr_no|cntr_tpsz_cd|cmdt_cd|ttl_dim_len|ttl_dim_wdt|ttl_dim_hgt|grs_wgt|wgt_ut_cd|pck_qty|pck_tp_cd|net_wgt|stwg_rqst_desc|max_awk_cgo_seq|ovr_fwrd_len|ovr_bkwd_len|ovr_hgt|ovr_lf_len|ovr_rt_len|ovr_void_slt_qty|temp_ovr_void_qty|in_ga_flg";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			sheetObj.InitDataProperty(0, cnt++, dtStatus,30, daCenter, true, "ibflag");
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "bkg_no");
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "awk_cgo_seq");
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "cntr_no");
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "cntr_tpsz_cd");
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "cmdt_cd");
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "ttl_dim_len", 	false, "", dfNullFloat);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "ttl_dim_wdt", 	false, "", dfNullFloat);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "ttl_dim_hgt", 	false, "", dfNullFloat);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "grs_wgt", 		false, "", dfNullFloat);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "wgt_ut_cd");
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "pck_qty", 		false, "", dfNullFloat);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "pck_tp_cd");
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "net_wgt", 		false, "", dfNullFloat);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "stwg_rqst_desc");
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "max_awk_cgo_seq");
			sheetObj.InitDataProperty(0, cnt++, dtData,50, daCenter, true, "ovr_fwrd_len");
			sheetObj.InitDataProperty(0, cnt++, dtData,50, daCenter, true, "ovr_bkwd_len");
			sheetObj.InitDataProperty(0, cnt++, dtData,50, daCenter, true, "ovr_hgt");
			sheetObj.InitDataProperty(0, cnt++, dtData,50, daCenter, true, "ovr_lf_len");
			sheetObj.InitDataProperty(0, cnt++, dtData,50, daCenter, true, "ovr_rt_len");
			sheetObj.InitDataProperty(0, cnt++, dtData,50, daCenter, true, "ovr_void_slt_qty");
			sheetObj.InitDataProperty(0, cnt++, dtData,50, daCenter, true, "temp_ovr_void_qty");
			sheetObj.InitDataProperty(0, cnt++, dtData,50, daCenter, true, "in_ga_flg");
			sheetObj.CountPosition = 0;
		//}
		break;
	case "div1sheet1": //sheet1 init
		//with (sheetObj) {
			// 높이 설정
		sheetObj.style.height = 150;
			//전체 너비 설정
		sheetObj.SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false);
			//InitHeadMode(true, true, true, true, false,false)
			var HeadTitle = "|Sel.|File Name|File Size|Container No. / CGO Seq|Container No. / CGO Seq||||||";

			var headCount = ComCountHeadTitle(HeadTitle);
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(12, 0, 0, true);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			sheetObj.InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "del_chk", false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 150, daLeft, false, "file_nm", false, "", dfNone, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "file_size", false, "", dfNone, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 150, daCenter, false, "cargo_contain", false, "", dfNone, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtImage, 5, daCenter, true, "multiPopup", false, "", dfNone, 0, true, true);

			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "file_path");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "ridr_tp_cd");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "file_sav_id");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "img_seq");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cargo_cnt");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dcgo_seq");

			sheetObj.ImageList(0) = "img/alps/button/btns_multisearch.gif";
			sheetObj.ImageList(1) = "img/alps/button/btng_minus.gif";

			sheetObj.MultiSelection = false;
			sheetObj.SelectHighLight = true;
			sheetObj.SheetBackColor = sheetObj.RgbColor(248, 248, 248);
			sheetObj.SelectBackColor = sheetObj.RgbColor(236, 246, 247);
			sheetObj.CountPosition = 0;
			sheetObj.FocusEditMode = 0;
		//}
		break;
	case "div2sheet1": //sheet1 init
		//with (sheetObj) {
			// 높이 설정
		sheetObj.style.height = 150;
			//전체 너비 설정
		sheetObj.SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false);
			//InitHeadMode(true, true, true, true, false,false)
			var HeadTitle = "|Sel.|File Name|File Size|Container No. / CGO Seq|Container No. / CGO Seq||||||";

			var headCount = ComCountHeadTitle(HeadTitle);
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(12, 0, 0, true);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			sheetObj.InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "del_chk", false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 150, daLeft, false, "file_nm", false, "", dfNone, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "file_size", false, "", dfNone, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 150, daCenter, false, "cargo_contain", false, "", dfNone, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtImage, 5, daCenter, true, "multiPopup", false, "", dfNone, 0, true, true);

			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "file_path");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "ridr_tp_cd");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "file_sav_id");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "img_seq");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cargo_cnt");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dcgo_seq");

			sheetObj.ImageList(0) = "img/alps/button/btns_multisearch.gif";
			sheetObj.ImageList(1) = "img/alps/button/btng_minus.gif";

			sheetObj.MultiSelection = false;
			sheetObj.SelectHighLight = true;
			sheetObj.SheetBackColor = sheetObj.RgbColor(248, 248, 248);
			sheetObj.SelectBackColor = sheetObj.RgbColor(236, 246, 247);
			sheetObj.CountPosition = 0;
			sheetObj.FocusEditMode = 0;
		//}
		break;	
		
	//Awkward Cgo Criteria 값	
	case "awk_criteria": //awk_criteria init
			// 높이 설정
			sheetObj.style.height = 0;
			//전체 너비 설정
			sheetObj.SheetWidth = mainTable.clientWidth;
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				sheetObj.InitHostInfo(location.hostname, location.port, page_path);
			//전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;
			//전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 3, 100);
			var HeadTitle1 = "|EQ Type/Size|Length|Width|Height|Length|Width|Height|Tare Weight";
			var headCount = ComCountHeadTitle(HeadTitle1);
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(9, 0, 0, true);
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(false, true, false, true, false, false);
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle1, true);
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			sheetObj.InitDataProperty(0, cnt++, dtDummyCheck, 20, daCenter, false, "DelChk");
			sheetObj.InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "attr_ctnt1", false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt2", false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt3", false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt4", false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt5", false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt6", false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt7", false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt8", false, "", dfNone, 0, true, true);

			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = 1;
	switch (sAction) {
	case IBCLEAR: //조회
		if (formObj.bkg_no2.value != null && formObj.bkg_no2.value != '') {

			var formObj2 = document.form2;

			for ( var i = 0; i < formObj.elements.length; i++) {
				if (formObj.elements[i].name.indexOf("ttl_dim_len") == 0)
					formObj.elements[i].value = ComAddComma(formObj.elements[i].value, "#,###");
				if (formObj.elements[i].name.indexOf("ttl_dim_wdt") == 0)
					formObj.elements[i].value = ComAddComma(formObj.elements[i].value, "#,###");
				if (formObj.elements[i].name.indexOf("ttl_dim_hgt") == 0)
					formObj.elements[i].value = ComAddComma(formObj.elements[i].value, "#,###");
				if (formObj.elements[i].name.indexOf("grs_wgt") == 0)
					formObj.elements[i].value = makeComma(formObj.elements[i].value.replace(/,/g, ""));
				if (formObj.elements[i].name.indexOf("net_wgt") == 0)
					formObj.elements[i].value = makeComma(formObj.elements[i].value.replace(/,/g, ""));
				if (formObj.elements[i].name.indexOf("pck_qty") == 0)
					formObj.elements[i].value = ComAddComma(formObj.elements[i].value, "#,###");
			}
			for ( var j = 0; j < formObj2.elements.length; j++) {
				if (formObj2.elements[j].name.indexOf("ttl_dim_len") == 0)
					formObj2.elements[j].value = ComAddComma(formObj2.elements[j].value, "#,###");
				if (formObj2.elements[j].name.indexOf("ttl_dim_wdt") == 0)
					formObj2.elements[j].value = ComAddComma(formObj2.elements[j].value, "#,###");
				if (formObj2.elements[j].name.indexOf("ttl_dim_hgt") == 0)
					formObj2.elements[j].value = ComAddComma(formObj2.elements[j].value, "#,###");
				if (formObj2.elements[j].name.indexOf("grs_wgt") == 0)
					formObj2.elements[j].value = makeComma(formObj2.elements[j].value.replace(/,/g, ""));
				if (formObj2.elements[j].name.indexOf("net_wgt") == 0)
					formObj2.elements[j].value = makeComma(formObj2.elements[j].value.replace(/,/g, ""));
				if (formObj2.elements[j].name.indexOf("pck_qty") == 0)
					formObj2.elements[j].value = ComAddComma(formObj2.elements[j].value, "#,###");;
			}
			var sXml = formObj.sXml.value;
			var arrXml = sXml.split("|$$|");
			/*for ( var i = 0; i < arrXml.length; i++) {
				sheetObjects[i].Redraw = false;
				if (i > 0) {
					sheetObjects[i].WaitImageVisible = false;
				}
				sheetObjects[i].LoadSearchXml(arrXml[i]);
				sheetObjects[i].Redraw = true;
			}*/
			
			sheetObjects[2].LoadSearchXml(arrXml[0]);
			
			parent.document.frames("t1frame").form.awk_cgo_flg.checked = 1;
			parent.document.frames("t1frame").form.awk_cgo_flg.value="Y";
		}
	
		for(var i=1;i<sheetObjects[2].Rows;i++){
			if(max_awk_cgo_seq<parseInt(sheetObjects[2].CellValue(i, "awk_cgo_seq"))){
				max_awk_cgo_seq = parseInt(sheetObjects[2].CellValue(i, "awk_cgo_seq"));
			}
		}
		
		sheetObjects[0].LoadSearchXml(arrXml[1]);
		sheetObjects[1].LoadSearchXml(arrXml[2]);
		sheetObjects[3].LoadSearchXml(arrXml[3]);
		
		/* 값이 있을 경우 버튼 색 변화 */
		getBtnObject("btn_akRider").style.color 		= (sheetObjects[0].TotalRows>0)     ?"blue":"#737373";
		getBtnObject("btn_akRider2").style.color 		= (sheetObjects[1].TotalRows>0)     ?"blue":"#737373";
					
		// 이미지 변경하기
		sheetObjects[0].CellImage(row, "multiPopup") = 1;
		if (sheetObjects[0].RowCount > 0) {
			for ( var row = 1; row <= sheetObjects[0].LastRow; row++) {				
				if (sheetObjects[0].CellValue(row, "cargo_cnt") > 1) {
					sheetObjects[0].CellImage(row, "multiPopup") = 0;
				} else {
					sheetObjects[0].CellImage(row, "multiPopup") = 1;
				}
			}
		} 
		if (sheetObjects[1].RowCount > 0) {
			for ( var row = 1; row <= sheetObjects[1].LastRow; row++) {					
				if (sheetObjects[1].CellValue(row, "cargo_cnt") > 1) {
					sheetObjects[1].CellImage(row, "multiPopup") = 0;
				} else {
					sheetObjects[1].CellImage(row, "multiPopup") = 1;
				}
			}
		}			
		
		if(parent.document.form.awkwardTabCancel.value=="Y"){
			ComBtnColor("btn_cancelcopydata", "blue");
			ComBtnColor("btn_datacopytoalps", "#737373");
			parent.document.form.awkwardTabCancel.value = "N";
		}
		if(top.document.form.tabload9.value == "COPY"){
			dataCopy();
		} else {
			compareItem();			
		}

		if(parent.frames("t1frame").document.form.doc_tp_cd.value == "S"){
			ComBtnDisable("btn_datacopytoalps");
		}
		
		top.document.form.tabload9.value = "LOAD";
		break;

	case IBSEARCH: //조회
		formObj.f_cmd.value = SEARCH;
		formObj.method = "post";
		formObj.target = "_self";
		formObj.action = "/hanjin/ESM_BKG_0229_09.do";
		formObj.submit();
		parent.tabObjects[0].TabBackColor(8) = "#96c792";
		break;

	case IBSEARCH_ASYNC02: //Data Copy
		// DHTML 테이블 생성
		var ins_tables = document.getElementById("INS_TABLES");
		ins_tables.innerHTML = "";
		var insTableDiv = "";

		var maxSeq = 0;
		for ( var k = 0; k < formObj.elements.length; k++) {
			if ((formObj.elements[k].name).indexOf("cntr_seq__") == 0) {
				var elValue = parseInt(formObj.elements[k].value);
				if (elValue > maxSeq)
					maxSeq = formObj.elements[k].value;
			}
		}

		// 컨테이너 비교
		var formObj2 = document.form2;
		var obj = null;
		var objNm = null;
		var objVal = null;
		var obj2 = null;
		var objNm2 = null;
		var objVal2 = null;

		var isInsert = "false";
		if (maxSeq > 0) {
			for ( var i = 0; i < formObj2.elements.length; i++) {
				if ((formObj2.elements[i].name).indexOf("__") > 0) {
					obj = (formObj2.elements[i].name).split("__");
					objNm = obj[0];
					objVal = formObj2.elements[i].value;
					if (objNm == "cntr_no") {
						for ( var j = 0; j < formObj.elements.length; j++) {
							if ((formObj.elements[j].name).indexOf("__") > 0) {
								obj2 = (formObj.elements[j].name).split("__");
								objNm2 = obj2[0];
								objVal2 = formObj.elements[j].value;
								if (objNm2 == "cntr_no") {								
									if(objVal2 !=" "){
										if (objVal == objVal2) {
											isInsert = "false";
											break;
										} else {
											isInsert = "true";
										}
									} else {
										isInsert = "true";
									}
								}
								
							}
						}
						if (isInsert == "true") {
							maxSeq++;
							var insTableDiv = createTable(maxSeq);
							ins_tables.innerHTML = ins_tables.innerHTML + insTableDiv;
							createCntr(maxSeq, obj[1]);
						} else if (isInsert == "false") {
							updateCntr(obj2[1], obj[1]);
						}
					}
				}
			}
		} else {
			for ( var i = 0; i < formObj2.elements.length; i++) {
				if ((formObj2.elements[i].name).indexOf("__") > 0) {
					obj = (formObj2.elements[i].name).split("__");
					objNm = obj[0];
					objVal = formObj2.elements[i].value;
					if (objNm == "cntr_no") {
						maxSeq++;
						var insTableDiv = createTable(maxSeq);
						ins_tables.innerHTML = ins_tables.innerHTML + insTableDiv;
						createCntr(maxSeq, obj[1]);
					}
				}
			}
		}
		
// ak rider copy
		
		if(div2sheet1.TotalRows>0){
			for(var i=1;i<div2sheet1.TotalRows + 1;i++){
				var isInsert = "true";
				for(var j=1;j<div1sheet1.TotalRows + 1;j++){
					if(div1sheet1.CellValue(j, "file_sav_id")==div2sheet1.CellValue(i, "file_sav_id")){						
						isInsert = "false"
						break;
					} else {
						isInsert = "true";
					}
				}

				if(isInsert=="true"){
					var newRow = div1sheet1.DataInsert(-1);
					div1sheet1.RowStatus(newRow) 					= "U";
                    div1sheet1.CellValue2(newRow, "file_nm"      )   = div2sheet1.CellValue(i, "file_nm"      );
                    div1sheet1.CellValue2(newRow, "file_size"    )   = div2sheet1.CellValue(i, "file_size"    );
                    div1sheet1.CellValue2(newRow, "cargo_contain")   = div2sheet1.CellValue(i, "cargo_contain");
                    div1sheet1.CellValue2(newRow, "file_path"    )   = div2sheet1.CellValue(i, "file_path"    );
                    div1sheet1.CellValue2(newRow, "ridr_tp_cd"   )   = div2sheet1.CellValue(i, "ridr_tp_cd"   );
                    div1sheet1.CellValue2(newRow, "file_sav_id"  )   = div2sheet1.CellValue(i, "file_sav_id"  );
                    div1sheet1.CellValue2(newRow, "img_seq"      )   = div2sheet1.CellValue(i, "img_seq"      );
                    div1sheet1.CellValue2(newRow, "cargo_cnt"    )   = div2sheet1.CellValue(i, "cargo_cnt"    );
                    div1sheet1.CellValue2(newRow, "dcgo_seq"     )   = div2sheet1.CellValue(i, "dcgo_seq"     );
                    div1sheet1.CellImage(newRow, "multiPopup") = 1;
				}
			}
		}


		parent.tabObjects[0].TabBackColor(8) = "#fff270";
		isCopy = "true";
		compareItem();
		initControl();
		break;
	//UPLOAD
	case IBSAVE:
		if (validateForUpload() == false) return;
		
		var params = getSaveStringForUpload();
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0229_09GS.do", params);
		
		if(ComBkgErrMessage(sheetObjects[2], sXml)) {
			sheetObj.LoadSaveXml(sXml);
			// 에러없으면 다시 조회
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
		}
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
 function validateForm(sheetObj, formObj, sAction) {
	for ( var i = 0; i < formObj.elements.length; i++) {
		if (formObj.elements[i].name.indexOf("cmdt_cd") == 0){
			if(haveOnlyNumber(formObj.elements[i].value)==false){
				ComShowCodeMessage("BKG00010");		
				ComSetFocus(formObj.elements[i]);
				return false;
			}
		}
	}
	
	// 2017.11.17 iylee SI이후, 매칭된 Akward Container Weight 와 Container Weight가 20% 이상 차이나는지 체크.
	if(parent.document.frames("t1frame").form.doc_tp_cd.value == "S"){
		
		var newCntrNo;
		var newCntrGrsWgt;
		var oldCntrGrsWgt;
		var findRow;
		var overWgtFlg;
		var overWgtCnt = 0;
		
		for(var i=1;i<sheetObj.Rows;i++){
			
			newCntrNo = sheetObj.CellValue(i, "cntr_no");
			newCntrGrsWgt = sheetObj.CellValue(i, "grs_wgt");
			findRow = parent.frames("t3frame").sheetObjects[0].FindText("cntr_no",newCntrNo,0,2);
			oldCntrGrsWgt = parent.frames("t3frame").sheetObjects[0].CellValue(findRow, "cntr_wgt");
			overWgtFlg = checkGrsWgtOver(newCntrNo, newCntrGrsWgt, oldCntrGrsWgt);
			
			if(overWgtFlg){
				sheetObj.CellFontColor(i, "cntr_no") = sheetObj.RgbColor(255,0,0);
				overWgtCnt++;
			} else {
				sheetObj.CellFontColor(i, "cntr_no") = sheetObj.RgbColor(0,0,0);
			}
			
		}
		
		if(overWgtCnt > 0){
			ComShowMessage(ComGetMsg("BKG95131"));
			return false;
		}
	}
	
	if (!ComChkValid(formObj))
		return false;
	return true;
}

/**
 * 전체 Upload 버튼 CLICK시 호출 됨
 * TAB에 상관 없이 동일 이름의 함수를 가짐
 * 내용은 TAB에 맞게 구현
 * Validate 실패 후 Focus 이동이 필요하면 (ex) Mandatory 항목 누락 후 Mandatory 필드에 Focus 이동
 * Focus 이동까지 한 후 return false
 */
function validateForUpload() {
	return validateForm(sheetObjects[2], document.form, IBSAVE);
}

/**
 * 전체 Upload 버튼 CLICK시 호출 됨
 * TAB에 상관 없이 동일 이름의 함수를 가짐
 * 내용은 TAB에 맞게 구현
 * 각 화면에서 Upload 버튼이 눌렸을 때 SC에 parameter 로 던지는 QueryString을 만들어 return
 */
function getSaveStringForUpload() {
	// form 데이타를 sheet로 copy
	doSaveCopy();

	// 2012.02.16 현재 계산하고 있지 않은 over dimension을 계산.
	// sheet상 row로 count
	for(var i=1; i<= sheetObjects[2].RowCount; i++){
		overDimensionSettingLength(sheetObjects[2].CellValue(i, "ttl_dim_len"), i, 2, 3);
		overDimensionSettingWidth(sheetObjects[2].CellValue(i, "ttl_dim_wdt"), i, 2, 3);
		overDimensionSettingHeight(sheetObjects[2].CellValue(i, "ttl_dim_hgt"), i, 2, 3);
	}
	
	
	var formObj = document.form;
	var params = FormQueryString(formObj);
	
	if (sheetObjects[2].RowCount>=1) {
		params = params+ "&" + "f_cmd=" + MULTI + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true), prefix);
		//alert(ComSetPrifix(sheetObjects[2].GetSaveString(true), prefix));
	}
	
	params = params + "&"+ComSetPrifix(sheetObjects[0].GetSaveString(true), "ak_rider_");
	return (params);
}

 /**
  * e-Booking Upload Copy 팝업에서 [OK]버튼 클릭시
  */
function dataCopy() {
	doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC02);
	ComBtnColor("btn_cancelcopydata", "#737373");
	ComBtnColor("btn_datacopytoalps", "blue");
	// 2017.09.29 iylee 컨테이너의 Commodity가 NULL인 경우 Booking Main 화면의 Commodity로 Copy
	copyCmdt();
}

function doSaveCopy(){
	var formObj = document.form;
	var sheetObj = sheetObjects[2];
	var maxSeq = 0;

	for ( var k = 0; k < formObj.elements.length; k++) {
		if ((formObj.elements[k].name).indexOf("cntr_seq__") == 0) {
			var elValue = parseInt(formObj.elements[k].value);
			if (elValue > maxSeq)
			//if (formObj.elements[k].value > maxSeq)
				maxSeq = formObj.elements[k].value;
		}
	}
	// [Data Copy to ALPS]에 의해 생긴 New 
	for (var i = sheetObj.RowCount; i<maxSeq; i++) {
		sheetObj.DataInsert(-1);
	}
	var obj		= null;
	var objNm	= null;
	var objSeq	= null;
	var objVal	= null;
	var cntrNo	= null;
	var ibflag	= null;
		
	//현재 화면의 ALPS Data를 sheet에 넣는다.
	for(var i=0; i<formObj.elements.length; i++) {
		if ((formObj.elements[i].name).indexOf("__") > 0) {
			obj = (formObj.elements[i].name).split("__");
			objNm = obj[0];
			objSeq = obj[1]; // sheet상 row
			
			objVal = formObj.elements[i].value;
			if (sheetObjects[2].CellValue(objSeq,"bkg_no") == "") {
				sheetObjects[2].CellValue2(objSeq,"bkg_no") = formObj.bkg_no.value;
			}
			if ( objNm == "awk_cgo_seq" )	sheetObjects[2].CellValue2(objSeq, "awk_cgo_seq")	= objVal;
			if ( objNm == "cntr_no" )		sheetObjects[2].CellValue2(objSeq, "cntr_no") 		= ComTrimAll(objVal);
			if ( objNm == "cntr_tpsz_cd" )	sheetObjects[2].CellValue2(objSeq, "cntr_tpsz_cd")	= objVal;
			if ( objNm == "cmdt_cd" )   	sheetObjects[2].CellValue2(objSeq, "cmdt_cd")		= objVal;
			if ( objNm == "ttl_dim_len" )	sheetObjects[2].CellValue2(objSeq, "ttl_dim_len")	= objVal;
			if ( objNm == "ttl_dim_wdt" )	sheetObjects[2].CellValue2(objSeq, "ttl_dim_wdt")	= objVal;
			if ( objNm == "ttl_dim_hgt" )	sheetObjects[2].CellValue2(objSeq, "ttl_dim_hgt")	= objVal;
			if ( objNm == "grs_wgt" ) 		sheetObjects[2].CellValue2(objSeq, "grs_wgt") 		= objVal;
			if ( objNm == "wgt_ut_cd" ) 	sheetObjects[2].CellValue2(objSeq, "wgt_ut_cd") 	= objVal;
			if ( objNm == "pck_qty" ) 		sheetObjects[2].CellValue2(objSeq, "pck_qty") 		= objVal;
			if ( objNm == "pck_tp_cd" ) 	sheetObjects[2].CellValue2(objSeq, "pck_tp_cd")		= objVal;
			if ( objNm == "net_wgt" ) 		sheetObjects[2].CellValue2(objSeq, "net_wgt")		= objVal;
			if ( objNm == "stwg_rqst_desc" )sheetObjects[2].CellValue2(objSeq, "stwg_rqst_desc")= objVal;
		}
	}
}

function compareItem() {
	var obj = null;
	var objNm = null;
	var objVal = null;
	var obj2 = null;
	var objNm2 = null;
	var objVal2 = null;
	var formObj  = document.form;
	var formObj2 = document.form2;
	var sameCntr = "false";
	for ( var i = 0; i < formObj2.elements.length; i++) {
		if ((formObj2.elements[i].name).indexOf("__") > 0) {
			obj = (formObj2.elements[i].name).split("__");
			objNm = obj[0];
			objVal = formObj2.elements[i].value;
			if (objNm == "cntr_no") {
				for ( var j = 0; j < formObj.elements.length; j++) {
					if ((formObj.elements[j].name).indexOf("__") > 0) {
						obj2 = (formObj.elements[j].name).split("__");
						objNm2 = obj2[0];
						objVal2 = formObj.elements[j].value;

						if (objNm2 == "cntr_no") {
							if (objVal == objVal2) {
								sameCntr = "true";
								break;
							} else {
								sameCntr = "false";
							}
						}
					}
				}
				if (sameCntr == "true") {
					compareCntr(obj2[1], obj[1]);
				}
			}
		}
	}	
}


function setCntrDiffCheckColor(bkgValue, eBkgValue, eBkgItemNm){
	var formObj = document.form;
	var formObj2 = document.form2;
	var tmp = eval(eBkgItemNm);
	if (bkgValue != eBkgValue) {
		tmp.style.color = "blue"
	} else {
		tmp.style.color = "#606060";
	}	
}

function compareCntr(leftSeq, rightSeq) {
	if(leftSeq==0||rightSeq==0) return;
	var formObj = document.form;
	var formObj2 = document.form2;
	setCntrDiffCheckColor(eval("formObj.cntr_tpsz_cd__" 	+ leftSeq).value, eval("formObj2.cntr_tpsz_cd__" 	+ rightSeq).value, ("formObj2.cntr_tpsz_cd__" 	+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.cmdt_cd__" 			+ leftSeq).value, eval("formObj2.cmdt_cd__" 		+ rightSeq).value, ("formObj2.cmdt_cd__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.ttl_dim_len__"		+ leftSeq).value, eval("formObj2.ttl_dim_len__" 	+ rightSeq).value, ("formObj2.ttl_dim_len__" 	+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.ttl_dim_wdt__" 		+ leftSeq).value, eval("formObj2.ttl_dim_wdt__" 	+ rightSeq).value, ("formObj2.ttl_dim_wdt__" 	+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.ttl_dim_hgt__" 		+ leftSeq).value, eval("formObj2.ttl_dim_hgt__" 	+ rightSeq).value, ("formObj2.ttl_dim_hgt__" 	+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.grs_wgt__" 			+ leftSeq).value, eval("formObj2.grs_wgt__" 		+ rightSeq).value, ("formObj2.grs_wgt__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.wgt_ut_cd__" 		+ leftSeq).value, eval("formObj2.wgt_ut_cd1__" 		+ rightSeq).value, ("formObj2.wgt_ut_cd1__" 	+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.pck_qty__"			+ leftSeq).value, eval("formObj2.pck_qty__" 		+ rightSeq).value, ("formObj2.pck_qty__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.pck_tp_cd__" 		+ leftSeq).value, eval("formObj2.pck_tp_cd__" 		+ rightSeq).value, ("formObj2.pck_tp_cd__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.net_wgt__" 			+ leftSeq).value, eval("formObj2.net_wgt__" 		+ rightSeq).value, ("formObj2.net_wgt__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.wgt_ut_cd2__" 		+ leftSeq).value, eval("formObj2.wgt_ut_cd2__" 		+ rightSeq).value, ("formObj2.wgt_ut_cd2__" 	+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.stwg_rqst_desc__" 	+ leftSeq).value, eval("formObj2.stwg_rqst_desc__" 	+ rightSeq).value, ("formObj2.stwg_rqst_desc__" + rightSeq));
		
//	var tmp = null;
//	tmp = eval("formObj2.cntr_tpsz_cd__" + rightSeq);
//	if (eval("formObj.cntr_tpsz_cd__" + leftSeq).value != eval("formObj2.cntr_tpsz_cd__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.cmdt_cd__" + rightSeq);
//	if (eval("formObj.cmdt_cd__" + leftSeq).value != eval("formObj2.cmdt_cd__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.ttl_dim_len__" + rightSeq);
//	if (eval("formObj.ttl_dim_len__" + leftSeq).value != eval("formObj2.ttl_dim_len__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.ttl_dim_wdt__" + rightSeq);
//	if (eval("formObj.ttl_dim_wdt__" + leftSeq).value != eval("formObj2.ttl_dim_wdt__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.ttl_dim_hgt__" + rightSeq);
//	if (eval("formObj.ttl_dim_hgt__" + leftSeq).value != eval("formObj2.ttl_dim_hgt__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.grs_wgt__" + rightSeq);
//	if (eval("formObj.grs_wgt__" + leftSeq).value != eval("formObj2.grs_wgt__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.wgt_ut_cd1__" + rightSeq);
//	if (eval("formObj.wgt_ut_cd__" + leftSeq).value != eval("formObj2.wgt_ut_cd1__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.pck_qty__" + rightSeq);
//	if (eval("formObj.pck_qty__" + leftSeq).value != eval("formObj2.pck_qty__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.pck_tp_cd__" + rightSeq);
//	if (eval("formObj.pck_tp_cd__" + leftSeq).value != eval("formObj2.pck_tp_cd__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.net_wgt__" + rightSeq);
//	if (eval("formObj.net_wgt__" + leftSeq).value != eval("formObj2.net_wgt__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.wgt_ut_cd2__" + rightSeq);
//	if (eval("formObj.wgt_ut_cd2__" + leftSeq).value != eval("formObj2.wgt_ut_cd2__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.stwg_rqst_desc__" + rightSeq);
//	if (eval("formObj.stwg_rqst_desc__" + leftSeq).value != eval("formObj2.stwg_rqst_desc__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
}

// 수정시 자리수 맞춤
function form_onChange(){
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcValue = window.event.srcElement.getAttribute("value");
	var obj = document.getElementById(srcName);

	if (srcName.indexOf("ttl_dim_len") == 0) 	obj.value = ComAddComma(srcValue, "#,###");
	if (srcName.indexOf("ttl_dim_wdt") == 0) 	obj.value = ComAddComma(srcValue, "#,###");
	if (srcName.indexOf("ttl_dim_hgt") == 0) 	obj.value = ComAddComma(srcValue, "#,###");
	if (srcName.indexOf("grs_wgt") == 0) 		obj.value = makeComma(srcValue.replace(/,/g, ""));
	if (srcName.indexOf("net_wgt") == 0) 		obj.value = makeComma(srcValue.replace(/,/g, ""));
	if (srcName.indexOf("pck_qty") == 0) 		obj.value = ComAddComma(srcValue, "#,##0");
	
	if (srcName.indexOf("cmdt_cd") == 0){
		if(!ComIsNull(srcValue)){
			obj.value = ComLpad(srcValue,6,"0");
			validatePrecaution(formObj,srcName,ComLpad(srcValue,6,"0"));
		}else{
			
			var obj2 = srcName.split("__");
			//ComSetObjValue(eval("formObj.cmdt_desc__"+srcName.substr(srcName.length-1,1)),"");
			ComSetObjValue(eval("formObj.cmdt_desc__"+obj2[1]),"");
		}
 	}

	compareItem();
}

function createTable(seq) {
	var insTableDiv = "";
	insTableDiv = insTableDiv + "<div id='table_" + seq + "'>\n";
	insTableDiv = insTableDiv + "</div>\n";
	return insTableDiv;
}

function createCntr(leftSeq, rightSeq) {
	var formObj2 = document.form2;
	var tabSeq = "table_" + leftSeq;
	var dyntbl1 = document.getElementById(tabSeq);
	dyntbl1.innerHTML = "";
	var oCell1 = "";
	var wgt_cdArr = wgt_cd.split("|");
	var wgt_nmArr = wgt_nm.split("|");

	max_awk_cgo_seq++;
	
	oCell1 = oCell1 + "<table id=\"table" + leftSeq
			+ "\" class=\"search\" border=\"0\">\n";
	oCell1 = oCell1 + "<input type=\"hidden\" name=\"awk_cgo_seq__" + leftSeq + 
			"\" value='" + max_awk_cgo_seq + "'>\n";
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td width=\"30\" valign=\"top\"><input type=\"text\" name=\"cntr_seq__" + leftSeq
			+ "\" style=\"width:25;text-align:center;\" class=\"input\" value=\"" + leftSeq + "\" readOnly></td>\n";
	oCell1 = oCell1 + "		<td width=\"90\">CNTR No.</td>\n";
	oCell1 = oCell1 + "		<td width=\"180\">\n";
	oCell1 = oCell1 + "		  <select name=\"cntr_no__" + leftSeq
			+ "\" style=\"width:105;\" class=\"input\" onChange=\"changeCntrNo(this,'" + leftSeq + "')\">\n";
	var cntrTpsz_cdArr = cntrTpsz_cd.split("|");
	var cntrTpsz_idArr = cntrTpsz_id.split("|");
	for ( var j = 0; j < cntrTpsz_cdArr.length; j++) {
		if (cntrTpsz_cdArr[j] == '' && cntrTpsz_idArr[j] == '')
			continue;
		if (cntrTpsz_cdArr[j] == eval("formObj2.cntr_no__" + rightSeq).value) {
			oCell1 = oCell1 + "<option value=\"" + cntrTpsz_cdArr[j] + "\" id=\""
					+ cntrTpsz_idArr[j] + "\" selected>" + cntrTpsz_cdArr[j]
					+ "</option>\n";
		} else {
			oCell1 = oCell1 + "<option value=\"" + cntrTpsz_cdArr[j] + "\" id=\""
					+ cntrTpsz_idArr[j] + "\">" + cntrTpsz_cdArr[j]
					+ "</option>\n";
		}
	}
	oCell1 = oCell1 + "		  </select>&nbsp;<input type=\"text\" name=\"cntr_tpsz_cd__" + leftSeq
			+ "\" style=\"width:35;\" maxlength=\"4\" dataformat=\"eng\" class=\"input\" value=\""
			+ eval("formObj2.cntr_tpsz_cd__" + rightSeq).value + "\"></td>\n";
	oCell1 = oCell1 + "		<td width=\"50\">Status</td>\n";
	oCell1 = oCell1 + "		<td width=\"\"><input type=\"text\" name=\"status__" + leftSeq
			+ "\" style=\"width:80;color:blue\" class=\"input2\" value=\"New\" readOnly></td>\n";
	oCell1 = oCell1 + "	</tr>\n";
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td width=\"30\" valign=\"top\"></td>\n";
	oCell1 = oCell1 + "		<td width=\"80\">Commodity</td>\n";
	oCell1 = oCell1 + "		<td colspan=\"4\"><input type=\"text\" required caption=\"Commodity\" name=\"cmdt_cd__" + leftSeq
			+ "\" style=\"width:90;\" maxlength=\"8\" dataformat=\"etc\" class=\"input\" value=\""
			+ eval("formObj2.cmdt_cd__" + rightSeq).value + "\">"
			+ "&nbsp;<a href=\"javascript:comBkgCallPop0653_position('setCallBack0653', document.form.cmdt_cd__" + leftSeq + ".value, '" + leftSeq
			+ "');\"><img class=\"cursor\" src=\"img/btns_search.gif\" width=\"19\" height=\"20\" border=\"0\" align=\"absmiddle\"></a>";
	oCell1 = oCell1 + "		  <input type=\"text\" name=\"cmdt_desc__" + leftSeq
	+ "\" style=\"width:190;\" maxlength=\"4000\" dataformat=\"engup\" class=\"input2\" value=\"" + eval("formObj2.cmdt_desc__" + rightSeq).value + "\" readonly=\"readonly\"></td>\n";
	oCell1 = oCell1 + "	</tr>\n";
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td width=\"30\" valign=\"top\"></td>\n";
	oCell1 = oCell1 + "		<td width=\"50\">Length</td>\n";
	oCell1 = oCell1 + "		<td width=\"\" class=\"stm\"><input type=\"text\" name=\"ttl_dim_len__" + leftSeq
			+ "\" style=\"width:80;text-align:right\" maxlength=\"7\" dataformat=\"float\" class=\"input\" value=\""
			+ eval("formObj2.ttl_dim_len__" + rightSeq).value
			+ "\">&nbsp;CM</td>\n";
	oCell1 = oCell1 + "		<td width=\"80\">Width</td>\n";
	oCell1 = oCell1 + "		<td width=\"180\" class=\"stm\"><input type=\"text\" name=\"ttl_dim_wdt__" + leftSeq
			+ "\" style=\"width:110;text-align:right\" maxlength=\"7\" dataformat=\"float\" class=\"input\" value=\""
			+ eval("formObj2.ttl_dim_wdt__" + rightSeq).value
			+ "\">&nbsp;CM</td>\n";
	oCell1 = oCell1 + "	</tr>\n";
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td width=\"30\" valign=\"top\">&nbsp;</td>\n";
	oCell1 = oCell1 + "		<td width=\"50\">Height</td>\n";
	oCell1 = oCell1 + "		<td width=\"\" class=\"stm\"><input type=\"text\" name=\"ttl_dim_hgt__" + leftSeq
			+ "\" style=\"width:80;text-align:right\" maxlength=\"7\" dataformat=\"float\" class=\"input\" value=\""
			+ eval("formObj2.ttl_dim_hgt__" + rightSeq).value
			+ "\">&nbsp;CM</td>\n";
	oCell1 = oCell1 + "		<td width=\"50\">Package</td>\n";
	oCell1 = oCell1 + "		<td width=\"170\"><input type=\"text\" name=\"pck_qty__" + leftSeq
			+ "\" style=\"width:65;text-align:right\" maxlength=\"12\" dataformat=\"float\" class=\"input\" value=\""
			+ eval("formObj2.pck_qty__" + rightSeq).value
			+ "\">&nbsp;<input type=\"text\" dataformat=\"eng\" maxlength=\"2\" required caption=\"Package Type Code\" name=\"pck_tp_cd__" + leftSeq
			+ "\" style=\"width:35;\" class=\"input\" value=\""
			+ eval("formObj2.pck_tp_cd__" + rightSeq).value
			+ "\">&nbsp;<a href=\"javascript:comBkgCallPop0696_position('setCallBack0696', document.form.pck_tp_cd__" + leftSeq
			+ ".value, '" + leftSeq
			+ "');\"><img class=\"cursor\" src=\"img/btns_search.gif\" width=\"19\" height=\"20\" border=\"0\" align=\"absmiddle\"></a></td>\n";
	oCell1 = oCell1 + "	</tr>\n";
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td width=\"30\" valign=\"top\">&nbsp;</td>\n";
	oCell1 = oCell1 + "		<td width=\"85\">Gross WGT</td>\n";
	oCell1 = oCell1 + "		<td width=\"150\"><input type=\"text\" name=\"grs_wgt__" + leftSeq
			+ "\" style=\"width:90;text-align:right\" maxlength=\"12\" dataformat=\"float\" class=\"input\" value=\""
			+ eval("formObj2.grs_wgt__" + rightSeq).value + "\">&nbsp;\n";
	oCell1 = oCell1 + "<select name=\"wgt_ut_cd__" + leftSeq
			+ "\" style=\"width:47;\" class=\"input\">\n";
	for ( var i = 0; i < wgt_cdArr.length; i++) {
		if (wgt_cdArr[i] == '' && wgt_nmArr[i] == '')
			continue;
		if (wgt_cdArr[i] == eval("formObj2.wgt_ut_cd1__" + rightSeq).value) {
			oCell1 = oCell1 + "<option value=\"" + wgt_cdArr[i] + "\" selected>"
					+ wgt_nmArr[i] + "</option>\n";
		} else {
			oCell1 = oCell1 + "<option value=\"" + wgt_cdArr[i] + "\">" + wgt_nmArr[i]
					+ "</option>\n";
		}
	}
	oCell1 = oCell1 + "		</td>\n";
	oCell1 = oCell1 + "		<td width=\"80\">Net WGT</td>\n";
	oCell1 = oCell1 + "		<td width=\"\" colspan=\"3\"><input type=\"text\" name=\"net_wgt__"
			+ leftSeq
			+ "\" style=\"width:90;text-align:right\" maxlength=\"12\" dataformat=\"float\" class=\"input\" value=\""
			+ eval("formObj2.net_wgt__" + rightSeq).value + "\">&nbsp;\n";
	oCell1 = oCell1 + "<select name=\"wgt_ut_cd2__" + leftSeq
			+ "\" style=\"width:47;\" class=\"input\">\n";
	for ( var j = 0; j < wgt_cdArr.length; j++) {
		if (wgt_cdArr[j] == '' && wgt_nmArr[j] == '')
			continue;
		if (wgt_cdArr[j] == eval("formObj2.wgt_ut_cd2__" + rightSeq).value) {
			oCell1 = oCell1 + "<option value=\"" + wgt_cdArr[j] + "\" selected>"
					+ wgt_nmArr[j] + "</option>\n";
		} else {
			oCell1 = oCell1 + "<option value=\"" + wgt_cdArr[j] + "\">" + wgt_nmArr[j]
					+ "</option>\n";
		}
	}
	oCell1 = oCell1 + "		</td>\n";
	oCell1 = oCell1 + "	</tr>\n";
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td width=\"30\" valign=\"top\">&nbsp;</td>\n";
	oCell1 = oCell1 + "		<td width=\"80\">Remark(s)</td>\n";
	oCell1 = oCell1 + "		<td colspan=\"2\"><textarea dataformat=\"etc\" name=\"stwg_rqst_desc__" + leftSeq
			+ "\" style=\"width:98%;height:40;\">"
			+ eval("formObj2.stwg_rqst_desc__" + rightSeq).value
			+ "</textarea></td>\n";
	oCell1 = oCell1 + "		<td width=\"85\">\n";
	oCell1 = oCell1 + "		  <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"button\">\n";
	oCell1 = oCell1 + "				<tr><td class=\"btn2_left\"></td>\n";
	oCell1 = oCell1 + "				<a href=\"javascript:btn_delete('table" + leftSeq
			+ "', '" + leftSeq + "');\"><td class=\"btn2\" name=\"btn_delete" + leftSeq
			+ "\">Delete</td></a>\n";
	oCell1 = oCell1 + "				<td class=\"btn2_right\"></td>\n";
	oCell1 = oCell1 + "				</tr>\n";
	oCell1 = oCell1 + "		  </table>\n";
	oCell1 = oCell1 + "		</td>\n";
	oCell1 = oCell1 + "	</tr>\n";
	oCell1 = oCell1 + "	<tr class=\"height_10\"><td colspan=\"8\"></td></tr>\n";
	oCell1 = oCell1 + "</table>\n";

	dyntbl1.innerHTML = oCell1;
}

function updateCntr(leftSeq, rightSeq) {
	var formObj = document.form;
	var formObj2 = document.form2;

	if (eval("formObj.status__" + leftSeq).value == "Approved" 
		|| eval("formObj.status__" + leftSeq).value == "Rejected"
		|| eval("formObj.status__" + leftSeq).value == "Requested")
		return;

	if (eval("formObj2.cntr_tpsz_cd__" + rightSeq).value != null && eval("formObj2.cntr_tpsz_cd__" + rightSeq).value != '')
		eval("formObj.cntr_tpsz_cd__" + leftSeq).value  = eval("formObj2.cntr_tpsz_cd__" + rightSeq).value;
	
	if (eval("formObj2.cmdt_cd__" + rightSeq).value != null && eval("formObj2.cmdt_cd__" + rightSeq).value != '')
		eval("formObj.cmdt_cd__" + leftSeq).value  = eval("formObj2.cmdt_cd__" + rightSeq).value;

	if (eval("formObj2.cmdt_nm__" + rightSeq).value != null && eval("formObj2.cmdt_nm__" + rightSeq).value != '')
		eval("formObj.cmdt_nm__" + leftSeq).value  = eval("formObj2.cmdt_nm__" + rightSeq).value;
	
	if (eval("formObj2.ttl_dim_len__" + rightSeq).value != null && eval("formObj2.ttl_dim_len__" + rightSeq).value != '')
		eval("formObj.ttl_dim_len__" + leftSeq).value  = eval("formObj2.ttl_dim_len__" + rightSeq).value;
	
	if (eval("formObj2.ttl_dim_wdt__" + rightSeq).value != null && eval("formObj2.ttl_dim_wdt__" + rightSeq).value != '')
		eval("formObj.ttl_dim_wdt__" + leftSeq).value  = eval("formObj2.ttl_dim_wdt__" + rightSeq).value;
	
	if (eval("formObj2.ttl_dim_hgt__" + rightSeq).value != null && eval("formObj2.ttl_dim_hgt__" + rightSeq).value != '')
		eval("formObj.ttl_dim_hgt__" + leftSeq).value  = eval("formObj2.ttl_dim_hgt__" + rightSeq).value;
	
	if (eval("formObj2.grs_wgt__" + rightSeq).value != null && eval("formObj2.grs_wgt__" + rightSeq).value != '')
		eval("formObj.grs_wgt__" + leftSeq).value  = eval("formObj2.grs_wgt__" + rightSeq).value;
	
	if (eval("formObj2.pck_qty__" + rightSeq).value != null && eval("formObj2.pck_qty__" + rightSeq).value != '')
		eval("formObj.pck_qty__" + leftSeq).value  = eval("formObj2.pck_qty__" + rightSeq).value;
	
	if (eval("formObj2.net_wgt__" + rightSeq).value != null && eval("formObj2.net_wgt__" + rightSeq).value != '')
		eval("formObj.net_wgt__" + leftSeq).value  = eval("formObj2.net_wgt__" + rightSeq).value;
	
	if (eval("formObj2.wgt_ut_cd1__" + rightSeq).value != null && eval("formObj2.wgt_ut_cd1__" + rightSeq).value != '') {
		for ( var i = 0; i < eval("formObj.wgt_ut_cd__" + leftSeq).length; i++) {
			if (eval("formObj.wgt_ut_cd__" + leftSeq)[i].value == eval("formObj2.wgt_ut_cd1__" + rightSeq).value) {
				eval("formObj.wgt_ut_cd__" + leftSeq).selectedIndex = i;
				break;
			}
		}
	}

	if (eval("formObj2.wgt_ut_cd2__" + rightSeq).value != null
			&& eval("formObj2.wgt_ut_cd2__" + rightSeq).value != '') {
		for ( var j = 0; j < eval("formObj.wgt_ut_cd2__" + leftSeq).length; j++) {
			if (eval("formObj.wgt_ut_cd2__" + leftSeq)[j].value == eval("formObj2.wgt_ut_cd2__" + rightSeq).value) {
				eval("formObj.wgt_ut_cd2__" + leftSeq).selectedIndex = j;
				break;
			}
		}
	}
}

function deleteAllTable() {
	var formObj = document.form;
	for ( var i = 0; i < formObj.elements.length; i++) {
		if ((formObj.elements[i].name).indexOf("table") == 0) {
			btn_deleteTable(formObj.elements[i].value);
		}
	}
}

function btn_deleteTable(tableId) {
	var formObj = document.form;
	var seq = 1;

	var tbody = document.getElementById(tableId).getElementsByTagName("TBODY")[0];
	var rowCount = tbody.rows.length;
	while (rowCount > 0) {
		tbody.deleteRow(rowCount - 1);
		rowCount--;
	}

	for ( var i = 0; i < formObj.elements.length; i++) {
		var objNm = (formObj.elements[i].name).split("__");
		if (objNm[0] == "cntr_seq") {
			formObj.elements[i].value = seq++;
		}
	}
}

function btn_delete(tableId, seq) {
	var formObj = document.form;
	doSaveCopy();
	for (var i=1; i<sheetObjects[2].RowCount+1; i++) {
		if (sheetObjects[2].CellValue(i, "awk_cgo_seq") == eval("formObj.awk_cgo_seq__" + seq).value) {
			sheetObjects[2].RowStatus(i) = "D";
			break;
		}
	}
	btn_deleteTable(tableId);
}

function changeCntrNo(obj, seq) {
	if (seq != null) {
		var obj_id = obj.options[obj.selectedIndex].id;
		eval("document.form.cntr_tpsz_cd__" + seq).value = obj_id;
	}
}

function loadComboData(cd, nm) {
 	wgt_cd = cd;
 	wgt_nm = nm;
}

function loadCntrTpsz(cd, id) {
	cntrTpsz_cd = cd;
	cntrTpsz_id = id;
}

function makeComma2(obj) {
	var val = makeComma(obj.value);
	obj.value = val;
}

function makeComma(srcValue) {
	var arrVal = srcValue.split(".");

	if (arrVal.length > 1) {
		srcValue = makeCommaRun(arrVal[0]) + "." + ComRpad(arrVal[1], 3, "0");
	} else {
		srcValue = makeCommaRun(arrVal[0]) + ".000";
	}
	return srcValue;
}
	
function makeCommaRun(srcValue) {
	srcValue = srcValue.replace(/\D/g, "");
	if (srcValue.length > 9) {
		srcValue = srcValue.substring(0, 9);
	}
	l = srcValue.length - 3;
	while (l > 0) {
		srcValue = srcValue.substr(0, l) + "," + srcValue.substr(l);
		l -= 3;
	}
	return srcValue;
}

function comBkgCallPop0696_position(funcNm, val, pos) {
	pkgPosition = pos;
	comBkgCallPop0696(funcNm, val);
}

function setCallBack0696(aryPopupData) {
	var formObj = document.form;
	eval("formObj.pck_tp_cd__" + pkgPosition).value = aryPopupData[0][3];
}

function comBkgCallPop0653_position(funcNm, val, pos) {
	cmdtPosition = pos;
	comBkgCallPop0653(funcNm, val, '');
}

function setCallBack0653(aryPopupData) {
	var formObj = document.form;
	eval("formObj.cmdt_cd__" + cmdtPosition).value = aryPopupData[0][3];
	eval("formObj.cmdt_desc__" + cmdtPosition).value = aryPopupData[0][4];
}

/**
 * cmdt_cd 입력시 precaution 정보 조회
 */       
function validatePrecaution(formObj,srcName,srcValue){
	formObj.f_cmd.value = SEARCHLIST11;
	var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0079_01GS.do", "f_cmd="+SEARCHLIST11 + "&cmdt_cd="+srcValue);
	if (sXml != "") {		
		var obj2 = srcName.split("__");
		
		ComSetObjValue(eval("formObj.cmdt_desc__"+obj2[1]),ComGetEtcData(sXml,"cmdt_nm"));
	}
}

function showAkRider() {
	if (document.all.akRider.style.visibility == 'hidden')
		document.all.akRider.style.visibility = 'visible';
	else {
		hiddenSelectForm();
		document.all.akRider.style.visibility = 'hidden';	
	}		
}

function showAkRider2() {
	if (document.all.akRider2.style.visibility == 'hidden')
		document.all.akRider2.style.visibility = 'visible';
	else {
		hiddenSelectForm2();
		document.all.akRider2.style.visibility = 'hidden';	
	}		
}

/**
 * 마우스 다운 이벤트
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
var current_Row = 0;
var current_Equal = false;
function div1sheet1_OnMouseDown(Button, Shift, X, Y) {
	var sheetObj = sheetObjects[0];
	var Bkg_div = document.getElementById(BKG_DIV_NAME);
	var Bkg_iframe = document.getElementById(BKG_FRAME_NAME);

	var m_row = sheetObjects[0].MouseRow;
	var m_col = sheetObjects[0].MouseCol;

	try {
		//4번째 컬럼에서만 팝업창 열림 
		if (m_row > 0 && m_col == 5) {
			if (Bkg_div.style.visibility == "hidden") {
				//초기 마우스 클릭 ROW 위치 
				if (m_row == current_Row) {
					current_Equal = true;
				} else {
					current_Row = m_row;
				}
				//layer 왼쪽 좌표 
				var gleft = sheetObj.ColLeft(m_col) - 130;
				//layer 위쪽 좌표 
				var gtop = 60 + sheetObj.RowTop(m_row) + sheetObj.RowHeight(m_row);
				//select box 리스트 다시 렌더링 초기화 
				iframe01.document.getElementById('ContainerList').innerHTML = alpsCheckBoxString;
				//보여주기 
				showSelectForm(gtop, gleft);
			} else {
				//감추기 
				hiddenSelectForm();
			}
		} else if (m_row > 0 && m_col == 2) {
			// 파일 다운로드 처리 
		} else {
			//그 이외의 컬럼이 눌리면  팝업 닫기
			hiddenSelectForm();
		}
	} catch (ex) {
		bkg_error_alert('sheet1_OnMouseDown', ex);
		return false;
	}
}

function div2sheet1_OnMouseDown(Button, Shift, X, Y) {
	var sheetObj = sheetObjects[1];
	var Bkg_div = document.getElementById(BKG_DIV_NAME2);
	var Bkg_iframe = document.getElementById(BKG_FRAME_NAME2);

	var m_row = sheetObjects[1].MouseRow;
	var m_col = sheetObjects[1].MouseCol;

	try {
		//4번째 컬럼에서만 팝업창 열림 
		if (m_row > 0 && m_col == 5) {
			if (Bkg_div.style.visibility == "hidden") {
				//초기 마우스 클릭 ROW 위치 
				if (m_row == current_Row) {
					current_Equal = true;
				} else {
					current_Row = m_row;
				}
				//layer 왼쪽 좌표 
				var gleft = sheetObj.ColLeft(m_col) - 200;
				//layer 위쪽 좌표 
				var gtop = 60 + sheetObj.RowTop(m_row) + sheetObj.RowHeight(m_row);
				//select box 리스트 다시 렌더링 초기화 
				iframe02.document.getElementById('ContainerList').innerHTML = xterCheckBoxString;
				//보여주기 
				showSelectForm2(gtop, gleft);

			} else {
				//감추기 
				hiddenSelectForm2();
			}
		} else if (m_row > 0 && m_col == 2) {
			// 파일 다운로드 처리 
		} else {
			//그 이외의 컬럼이 눌리면  팝업 닫기
			hiddenSelectForm2();
		}
	} catch (ex) {
		bkg_error_alert('sheet1_OnMouseDown', ex);
		return false;
	}
}

/**
 * alps
 * 숨기기 multiSelectFrame   이벤트 발생
 * @param void
 */
function hiddenSelectForm() {
	var formObj = document.form;
	var Bkg_div = document.getElementById(BKG_DIV_NAME);
	var Bkg_iframe = document.getElementById(BKG_FRAME_NAME);
//	if ('B' == ComGetObjValue(formObj.ridr_tp_cd))
//		return;
	try {
		if (Bkg_div.style.visibility == "visible") {
			Bkg_iframe.style.visibility = "hidden";
			Bkg_div.style.visibility = "hidden";

			// 값 셋팅하기 
			setMultiSelectCheck();

			if (count_checked > 1) {
				sheetObjects[0].CellImage(current_Row, "multiPopup") = 0;
			} else {
				sheetObjects[0].CellImage(current_Row, "multiPopup") = 1;
			}
		}
	} catch (ex) {
		bkg_error_alert('hiddenSelectForm', ex);
		return false;
	}
}
 
/**
 * e-svc
 * 숨기기 multiSelectFrame   이벤트 발생
 * @param void
 */
function hiddenSelectForm2() {
	var formObj = document.form;
	var Bkg_div = document.getElementById(BKG_DIV_NAME2);
	var Bkg_iframe = document.getElementById(BKG_FRAME_NAME2);
//	if ('B' == ComGetObjValue(formObj.ridr_tp_cd2))
//		return;
	try {
		if (Bkg_div.style.visibility == "visible") {
			Bkg_iframe.style.visibility = "hidden";
			Bkg_div.style.visibility = "hidden";

			// 값 셋팅하기 
			setMultiSelectCheck2();

			if (count_checked2 > 1) {
				sheetObjects[1].CellImage(current_Row, "multiPopup") = 0;
			} else {
				sheetObjects[1].CellImage(current_Row, "multiPopup") = 1;
			}
		}
	} catch (ex) {
		bkg_error_alert('hiddenSelectForm2', ex);
		return false;
	}
}
 
/**
 * alps
 * setMultiSelectCheck  이벤트 발생
 * 값에 따라서 value값을 구한다. 
 */
var count_checked = 0;
function setMultiSelectCheck() {
	try {
		var t_ck = iframe01.document.getElementsByName('t_check');
		var t_nm = iframe01.document.getElementsByName('t_name');
		if (t_nm.length == 0)
			return;
		var r_value = '';
		var r_text = '';
		var _flag = false;
		count_checked = 0;// initial 
		for (i = 0; i < t_ck.length; i++) {
			if (t_ck[i].checked) {
				if (!_flag)
					r_text = t_nm[i].value;
				if (_flag)
					r_value += ',';
				r_value += t_ck[i].value;
				_flag = true;
				count_checked++;
			}
		}

		sheetObjects[0].CellValue2(current_Row, "dcgo_seq") = r_value;
		sheetObjects[0].CellValue2(current_Row, "cargo_contain") = r_text;
	} catch (ex) {
		bkg_error_alert('setMultiSelectCheck', ex);
		return false;
	}
}

/**
 * e-svc
 * setMultiSelectCheck  이벤트 발생
 * 값에 따라서 value값을 구한다. 
 */
var count_checked2 = 0;
function setMultiSelectCheck2() {
	try {
		var t_ck = iframe02.document.getElementsByName('t_check2');
		var t_nm = iframe02.document.getElementsByName('t_name2');
		if (t_nm.length == 0)
			return;
		var r_value = '';
		var r_text = '';
		var _flag = false;
		count_checked2 = 0;// initial 
		for (i = 0; i < t_ck.length; i++) {
			if (t_ck[i].checked) {
				if (!_flag)
					r_text = t_nm[i].value;
				if (_flag)
					r_value += ',';
				r_value += t_ck[i].value;
				_flag = true;
				count_checked2++;
			}
		}

		sheetObjects[1].CellValue2(current_Row, "dcgo_seq") = r_value;
		sheetObjects[1].CellValue2(current_Row, "cargo_contain") = r_text;
	} catch (ex) {
		bkg_error_alert('setMultiSelectCheck2', ex);
		return false;
	}
}

/**
 * 멀티 SELECT 이벤트 DIV Layer창 생성 
 * 
 */
function divLayer_Config() {
	var iframeHTML = 'apps/alps/esm/bkg/bookingconduct/specialcargobookingconduct/specialcargorider/jsp/ESM_BKG_0207.HTML';

	//alsp
	var _divWait = document.createElement("<div id='" + BKG_DIV_NAME + "'  name='div01'  style='position:absolute; cursor:wait; left:0px; top:0px; width:100%; height:100%; z-index:999; visibility:hidden;'/>");
	document.body.insertBefore(_divWait);

	var _frameWait = document.createElement("<IFRAME id='" + BKG_FRAME_NAME + "' name='iframe01' src='" + iframeHTML + "' frameborder=0 marginHeight=0 marginWidth=0 width=" + iframeW + " height=" + iframeH + " style='position:absolute;' />");
	_divWait.appendChild(_frameWait);
	//e-svc
	var _divWait2 = document.createElement("<div id='" + BKG_DIV_NAME2 + "'  name='div02'  style='position:absolute; cursor:wait; left:550px; top:0px; width:190px; height:100%; z-index:999; visibility:hidden;'/>");
	document.body.insertBefore(_divWait2);
	
	var _frameWait2 = document.createElement("<IFRAME id='" + BKG_FRAME_NAME2 + "' name='iframe02' src='" + iframeHTML + "' frameborder=0 marginHeight=0 marginWidth=0 width=" + iframeW + " height=" + iframeH + " style='position:absolute;' />");
	_divWait2.appendChild(_frameWait2);
}
 
/**
 * 보이기 multiSelectFrame  이벤트 발생
 * @param topPos    상단 좌표 
 * @param leftPos    왼쪽 좌표 
 */
function showSelectForm(topPos, leftPos) {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var Bkg_div = document.getElementById(BKG_DIV_NAME);
	var Bkg_iframe = document.getElementById(BKG_FRAME_NAME);

//	if ('B' == ComGetObjValue(formObj.ridr_tp_cd))
//		return;

	try {

		if (current_Equal) {
			//포커스 강제설정 
			sheetObj.SelectCell(current_Row, "cargo_contain", false);
			current_Equal = false;
		}

		Bkg_iframe.style.left = leftPos;
		Bkg_iframe.style.top = topPos;

		if (current_Row < 0)
			current_Row = 1;
		// 눌렀을 경우  check 여부 셋팅하기 
		var _check = sheetObj.CellText(current_Row, "dcgo_seq");
		if (typeof _check != null || typeof _check != "undefined" || _check != "") {
			getMultiSelectCheck(_check);
		}

		Bkg_div.style.visibility = "visible";
		Bkg_iframe.style.visibility = "visible";

		Bkg_div.focus();
	} catch (ex) {
		bkg_error_alert('showSelectForm', ex);
		return false;
	}
}
 
/**
 * 보이기 multiSelectFrame  이벤트 발생
 * @param topPos    상단 좌표 
 * @param leftPos    왼쪽 좌표 
 */
function showSelectForm2(topPos, leftPos) {
	var formObj = document.form;
	var sheetObj = sheetObjects[1];
	var Bkg_div = document.getElementById(BKG_DIV_NAME2);
	var Bkg_iframe = document.getElementById(BKG_FRAME_NAME2);

//	if ('B' == ComGetObjValue(formObj.ridr_tp_cd))
//		return;

	try {
		if (current_Equal) {
			//포커스 강제설정 
			sheetObj.SelectCell(current_Row, "cargo_contain", false);
			current_Equal = false;
		}

		Bkg_iframe.style.left = leftPos;
		Bkg_iframe.style.top = topPos;

		if (current_Row < 0)
			current_Row = 1;
		// 눌렀을 경우  check 여부 셋팅하기 
		var _check = sheetObj.CellText(current_Row, "dcgo_seq");
		if (typeof _check != null || typeof _check != "undefined" || _check != "") {
			getMultiSelectCheck2(_check);
		}

		Bkg_div.style.visibility = "visible";
		Bkg_iframe.style.visibility = "visible";

		Bkg_div.focus();
	} catch (ex) {
		bkg_error_alert('showSelectForm', ex);
		return false;
	}
}

/**
 * getMultiSelectCheck  이벤트 발생
 * 값에 따라서 value값을 체크한다. 
 */
function getMultiSelectCheck(_check) {
	try {
		var t_nm = iframe01.document.getElementsByName('t_check');
		var arrRow = _check.split(",");
		for (idx = 0; idx < arrRow.length; idx++) {
			for (i = 0; i < t_nm.length; i++) {
				if (arrRow[idx] == t_nm[i].value) {
					t_nm[i].checked = true;
				}
			}
		}
	} catch (ex) {
		bkg_error_alert('getMultiSelectCheck', ex);
		return false;
	}
}
 
/**
 * getMultiSelectCheck  이벤트 발생
 * 값에 따라서 value값을 체크한다. 
 */
function getMultiSelectCheck2(_check) {
	try {
		var t_nm = iframe02.document.getElementsByName('t_check2');
		var arrRow = _check.split(",");
		for (idx = 0; idx < arrRow.length; idx++) {
			for (i = 0; i < t_nm.length; i++) {
				if (arrRow[idx] == t_nm[i].value) {
					t_nm[i].checked = true;
				}
			}
		}
	} catch (ex) {
		bkg_error_alert('getMultiSelectCheck2', ex);
		return false;
	}
}


/**
 * 파일 다운받기 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} Row     	sheetObj의 선택된 Row
 * @param {ibsheet} Col     	sheetObj의 선택된 Col
 * @param {String} 	Value     	파일명
 **/
function div1sheet1_OnClick(sheetObj, Row, Col, Value) {
	 if (Col != 2) return;
	 
	// 파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
//	if (sheetObj.CellText(Row, prefix + "file_nm") == "" || sheetObj.RowStatus(Row) == "I") {
//		selectFile(sheetObj, Row, Col);
//		return;
//	}
	
	// 파일이 존재시 다운로드 받는다.
	var key_id = sheetObj.CellValue(Row, "file_sav_id");
	var exist = fnSaveFileExist(key_id , sheetObj);
	// 서버에 파일존재유무확인
	if(eval(exist)){
		hiddenFrame.location.href = "/hanjin/FileDownload?key=" + key_id;
	}else{
		ComShowMessage(ComGetMsg("BKG08127"));
	}	
}

function div2sheet1_OnClick(sheetObj, Row, Col, Value) {
	 if (Col != 2) return;
	 
	// 파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
//	if (sheetObj.CellText(Row, prefix + "file_nm") == "" || sheetObj.RowStatus(Row) == "I") {
//		selectFile(sheetObj, Row, Col);
//		return;
//	}
	
	// 파일이 존재시 다운로드 받는다.
	var key_id = sheetObj.CellValue(Row, "file_sav_id");
	var exist = fnSaveFileExist(key_id , sheetObj);
	// 서버에 파일존재유무확인
	if(eval(exist)){
		hiddenFrame.location.href = "/hanjin/FileDownload?key=" + key_id;
	}else{
		ComShowMessage(ComGetMsg("BKG08127"));
	}	
}

/**
 * 파일존재유무판단  
 * file_id 번호로 file_path_url 확인후 파일존재확인 함수 
 * param :file_id
 * return :boolean
 */
function fnSaveFileExist(file_id,sheetObj) {
	var formObj = document.form;
	var param = "&f_cmd=" + COMMAND08 + "&input_text=" + file_id;
	var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
	var output_text = ComGetEtcData(sXml, "output_text");
	return output_text;
}
////Container 리스트를 저장용 sheet로 Copy
//function doCntrSaveCopy() {
//var formObj = document.form;
//var obj = null;
//var objNm = null;
//var objSeq = null;
//var objVal = null;
//var cntrNo = null;
//var ibflag = null;
//
//for ( var i = 0; i < formObj.elements.length; i++) {
//	if ((formObj.elements[i].name).indexOf("__") > 0) {
//		obj = (formObj.elements[i].name).split("__");
//		objNm = obj[0];
//		objSeq = obj[1];
//		objVal = formObj.elements[i].value;
//		if (objNm == "ibflag") {
//			ibflag = objVal;
//			if (sheetObjects[2].CellValue(objSeq, "ibflag") != "D") {
//				sheetObjects[2].CellValue(objSeq, "ibflag") = objVal;
//			}
//		}
//		sheetObjects[2].CellValue(objSeq, "bkg_no") = formObj.bkg_no.value;
//
//		if (objNm == "awk_cgo_seq")
//			sheetObjects[2].CellValue(objSeq, "awk_cgo_seq") = objVal;
//		if (objNm == "cntr_no")
//			sheetObjects[2].CellValue(objSeq, "cntr_no") = objVal;
//		if (objNm == "cntr_tpsz_cd")
//			sheetObjects[2].CellValue(objSeq, "cntr_tpsz_cd") = objVal;
//		if (objNm == "cmdt_cd")
//			sheetObjects[2].CellValue(objSeq, "cmdt_cd") = objVal;
//		if (objNm == "ttl_dim_len")
//			sheetObjects[2].CellValue(objSeq, "ttl_dim_len") = (objVal)
//					.replaceStr(",");
//		if (objNm == "ttl_dim_wdt")
//			sheetObjects[2].CellValue(objSeq, "ttl_dim_wdt") = (objVal)
//					.replaceStr(",");
//		if (objNm == "ttl_dim_hgt")
//			sheetObjects[2].CellValue(objSeq, "ttl_dim_hgt") = (objVal)
//					.replaceStr(",");
//		if (objNm == "grs_wgt")
//			sheetObjects[2].CellValue(objSeq, "grs_wgt") = (objVal)
//					.replaceStr(",");
//		if (objNm == "wgt_ut_cd")
//			sheetObjects[2].CellValue(objSeq, "wgt_ut_cd") = objVal;
//		if (objNm == "pck_qty")
//			sheetObjects[2].CellValue(objSeq, "pck_qty") = (objVal)
//					.replaceStr(",");
//		if (objNm == "pck_tp_cd")
//			sheetObjects[2].CellValue(objSeq, "pck_tp_cd") = objVal;
//		if (objNm == "net_wgt")
//			sheetObjects[2].CellValue(objSeq, "net_wgt") = (objVal)
//					.replaceStr(",");
//		if (objNm == "wgt_ut_cd2")
//			sheetObjects[2].CellValue(objSeq, "wgt_ut_cd2") = objVal;
//		if (objNm == "stwg_rqst_desc")
//			sheetObjects[2].CellValue(objSeq, "stwg_rqst_desc") = objVal;
//	}
//}
//}
/**
 * 각 Container 의 Commodity 정보가 공백이면 Booking Creation Tab의 Commodity 정보를 입력.
 */
function copyCmdt(){
	
	var formObj = document.form;
	
	for ( var i = 0; i < formObj.elements.length; i++) {
		if ((formObj.elements[i].name).indexOf("__") > 0) {
			obj = (formObj.elements[i].name).split("__");
			objNm = obj[0];
			objVal = formObj.elements[i].value;
			if (objNm == "cmdt_cd") {
				if(ComIsNull(objVal)){
					formObj.elements[i].value = ComGetObjValue(parent.document.frames("t1frame").form.cmdt_cd);
				}
			}
			if (objNm == "cmdt_desc") {
				if(ComIsNull(objVal)){
					formObj.elements[i].value = ComGetObjValue(parent.document.frames("t1frame").form.cmdt_desc);
				}
			}
		}
	}
}