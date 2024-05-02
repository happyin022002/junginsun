﻿﻿﻿﻿/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0229_03.js
 *@FileTitle : e-Booking & SI Process Detail(CONTAINER)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.10
 *@LastModifier : 전용진
 *@LastVersion : 1.0
 * 2009.06.10 전용진
 * 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2010.11.08 김영철 [CHM-201006978-01] CNTR 탭에서 ALPS에 입력된 CNTR은 삭제하고 동일 CNTR NO로 데이터를 추가 업로드 할 수 있도록 함
 2011.05.19 김진승 [CHM-201110850-01] (e-SI upload) Container Column logic	 
 2011.06.16 손은주 [CHM-201111531-01]	[ALPS] CNTR탭 Validation 추가 & C/M 매핑 수정 요청
 2012.10.30 이재위 [CHM-201220674] [ALPS BKG] Split 01-Container Loading List 화면상 Seal KindCode 추가 요청
 2012.12.14 1.63버전으로 되돌림
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
 * @class esm_bkg_0229_03 : esm_bkg_0229_03 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0229_03() {
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

var pkgPosition = 0;

var sealKndCdArr = new Array();
var sealPtyTpCdArr = new Array();
var seal_knd_cd_list = "";
var seal_pty_tp_cd_list = "";

var wgt_cd_list = "";
var wgt_nm_list = "";
var meas_cd_list = "";
var meas_nm_list = "";
var rcv_term_cd_list = 	"";
var de_term_cd_list =  "";

var t3Xml = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			case IBCLEAR:
				doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
				break;
	
			case "btn_cancelcopydata":
				parent.document.form.containerTabCancel.value = "Y";
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				isCopy = "false";
				top.isCopyAllRequested = false;
				break;
	
			case "btn_datacopytoalps":
				if (isCopy == "false") {
					dataCopy();
				}
				break;
	
			case "btn_upload":
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
	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
	initControl();
	
}

function initControl() {
	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // -
	// 키보드 입력할때
	axon_event.addListenerForm('blur', 'form1_blur', formObject);
	axon_event.addListenerForm  ('click', 'bkg0229_03_click', formObject); // - 클릭시
	//from 0079_04
//	axon_event.addListenerForm('focus', 'form1_focus', document.form);// 미사용
//    axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
    axon_event.addListenerForm('change', 'form1_change', document.form);

	applyShortcut();
}
/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

 /**
  * 콤보 초기설정값
  * 
  * @param {IBMultiCombo}
  *            comboObj comboObj
  */
 function initCombo(comboObj) {
 	comboObj.MultiSelect = false;
 	comboObj.UseCode = true;
 	comboObj.LineColor = "#ffffff";
 	comboObj.SetColAlign("left|left");
 	comboObj.MultiSeparator = "|";
 }
 /**
  * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
  * 
  * @param {IBMultiCombo}
  *            combo_obj IBMultiCombo Object
  */
 function setComboObject(combo_obj) {
 	comboObjects[comboCnt++] = combo_obj;
 }

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1":// alps cntr
		//with (sheetObj) { 
			// 높이 설정
		sheetObj.style.height = 0;
			// 전체 너비 설정
		sheetObj.SheetWidth = 390;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 15, 100);
			var HeadTitle1 = "left_seq|right_seq|ibflag|dp_seq|bkg_no|cntr_cfm_flg|cntr_no_old|cntr_no|cntr_tpsz_cd|seal1|seal2|pck_qty|pck_tp_cd|cntr_wgt|wgt_ut_cd|vgm_dtmn_dt|vgm_mzd_tp_cd|vgm_vrfy_dt|vgm_vrfy_sig_ctnt|vgm_wgt|vgm_wgt_ut_cd|meas_qty|meas_ut_cd|rcv|dlv|cntr_prt_flg|vol|as|cnmv_sts_cd|hngr|dg|bb|ak|rc|rd|soc|org_yd|rcv_dt|diff_rmk|po_no";
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
			var prefix = "sheet1_";

        	//데이터속성    [ROW, COL,  DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,            KEYFIELD,  CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			sheetObj.InitDataProperty(0, cnt++,  dtData, 	    10,    daCenter,   true,	  "left_seq",          false,     "",      dfNone,    		0,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtData, 	    10,    daCenter,   true,	  "right_seq",         false,     "",      dfNone,    		0,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtHiddenStatus, 20,    daCenter,   false,     "ibflag");
			sheetObj.InitDataProperty(0, cnt++,  dtData,         30,    daCenter,   false,     "cntr_dp_seq",       false,     "",      dfNone,    		0,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         80,    daCenter,   false,     "bkg_no",            false,     "",      dfNone,    		0,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         20,    daCenter,   false,     "cntr_cfm_flg",      false,     "",      dfNone,    		0,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         20,    daCenter,   false,     "cntr_no_old",       false,     "",      dfNone,    		0,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         90,    daCenter,   false,     "cntr_no",           false,     "",      dfNone,    		0,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         30,    daCenter,   false,     "cntr_tpsz_cd",      false,     "",      dfNone,    		0,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         50,    daCenter,   false,     "seal_no1",	       false,     "",      dfNone,    		0,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         50,    daCenter,   false,     "seal_no2",          false,     "",      dfNone,    		0,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         70,    daRight,    false,     "pck_qty",           false,     "",      dfNullInteger, 	0,        true,        true, 7);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         30,    daCenter,   false,     "pck_tp_cd",         false,     "",      dfNone,    		0,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         90,    daRight,    false,     "cntr_wgt",          false,     "",      dfFloat,   		3,        true,        true, 13);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         30,    daRight,    false,     "wgt_ut_cd",         false,     "",      dfNone,    		0,        true,        true);
			
			sheetObj.InitDataProperty(0, cnt++,  dtData,         90,    daRight,    false,     "vgm_dtmn_dt",          false,     "",      dfNone,   		0,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         90,    daRight,    false,     "vgm_mzd_tp_cd",          false,     "",      dfNone,   		0,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         90,    daRight,    false,     "vgm_vrfy_dt",          false,     "",      dfNone,   		0,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         90,    daRight,    false,     "vgm_vrfy_sig_ctnt",          false,     "",      dfNone,   		0,        true,        true);
			
			sheetObj.InitDataProperty(0, cnt++,  dtData,         90,    daRight,    false,     "vgm_wgt",          false,     "",      dfFloat,   		3,        true,        true, 13);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         30,    daRight,    false,     "vgm_wgt_ut_cd",         false,     "",      dfNone,    		0,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         70,    daRight,    false,     "meas_qty",          false,     "",      dfFloat,   		3,        true,        true, 9);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         30,    daRight,    false,     "meas_ut_cd",        false,     "",      dfNone,    		0,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtData,        	30,    daCenter,   false,     "rcv_term_cd",       false,     "",      dfNone,    		0,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtData,        	30,    daCenter,   false,     "de_term_cd",        false,     "",      dfNone,    		0,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         20,    daCenter,   false,     "cntr_prt_flg",      false,     "",      dfNone,    		0,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         30,    daRight,    false,     "cntr_vol_qty",      false,     "",      dfFloat,   		2,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtData,        	30,    daCenter,   false,     "adv_shtg_cd",       false,     "",      dfNone,    		0,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         30,    daCenter,   false,     "cnmv_sts_cd",       false,     "",      dfNone,    		0,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         30,    daCenter,   false,     "hngr_flg",          false,     "",      dfNone,    		0,        false,       false);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         30,    daCenter,   false,     "dcgo_flg",          false,     "",      dfNone,    		0,        false,       false);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         30,    daCenter,   false,     "bb_cgo_flg",        false,     "",      dfNone,    		0,        false,       false);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         30,    daCenter,   false,     "awk_cgo_flg",       false,     "",      dfNone,    		0,        false,       false);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         30,    daCenter,   false,     "rc_flg",            false,     "",      dfNone,    		0,        false,       false);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         30,    daCenter,   false,     "rd_cgo_flg",        false,     "",      dfNone,    		0,        false,       false);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         30,    daCenter,   false,     "soc_flg",           false,     "",      dfNone,    		0,        false,       false);
			sheetObj.InitDataProperty(0, cnt++,  dtData,         60,    daCenter,   false,     "org_yd_cd",         false,     "",      dfNone,    		0,        false,       false);
			sheetObj.InitDataProperty(0, cnt++,  dtData,        100,    daCenter,   false,     "cgo_rcv_dt",        false,     "",      dfUserFormat2,   0,        false,       false);
			sheetObj.InitDataProperty(0, cnt++,  dtData,        120,    daCenter,   false,     "diff_rmk",          false,     "",      dfNone,    		0,        true,        true);
			sheetObj.InitDataProperty(0, cnt++,  dtData, 	   100,    daCenter,   true,	  "po_no",			   false, 	  "", 	   dfNone, 			0, 		  true,        true);
//	        "cnmv_sts_cd|hngr|dg|bb|ak|rc|rd|soc|rcv_dt|diff_rmk|po_no";
			sheetObj.InitUserFormat2(0, "cgo_rcv_dt",   "####-##-## ##:##", "-|:");
			
			sheetObj.CountPosition = 0;	
	    //}
		break;

	case "sheet2": //alps seal
		//with (sheetObj) {
			// 높이 설정
		sheetObj.style.height = 0;
			// 전체 너비 설정
		sheetObj.SheetWidth = 350;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 15, 100);

			//var HeadTitle1 = "ibflag|sel|BKG NO|Container|Seal Seq|Seal No|Seal Name|Prn Flag";
			var HeadTitle1 = "||bkg no|cntr no|Seal Seq.|Seal No|knd_cd|pty_tp|pty_nm|Print";
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
			var prefix = "sheet2_";
			sheetObj.InitDataProperty(0, cnt++, dtStatus, 		30, 	daCenter,true,  "ibflag");
			sheetObj.InitDataProperty(0, cnt++, dtDummyCheck, 	0, 		daCenter,false, "sel");
			sheetObj.InitDataProperty(0, cnt++, dtData, 			80, 	daCenter,false, "bkg_no",			false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			140, 	daRight, false, "cntr_no",			false, "", dfNone, 2, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			140, 	daRight, false, "cntr_seal_seq", 	false, "", dfNone, 2, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			140, 	daRight, false, "cntr_seal_no", 	false, "", dfNone, 2, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData,         	40,  	daCenter,false, "seal_knd_cd",    	false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData,         	50,  	daCenter,false, "seal_pty_tp_cd", 	false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			140, 	daRight, false, "seal_pty_nm", 		false, "", dfNone, 2, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			140, 	daRight, false, "prn_flg",			false, "", dfNone, 2, true, true);
		//}
		break;
	}
}


// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	//sheetObj.ShowDebugMsg = 1;
	switch (sAction) {
	case IBSAVE:
		doCntrSaveCopy();
		var params = getSaveStringForUpload();
		var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0229_03GS.do", params);
		var rMsg = ComResultMessage(sXml);
		if (rMsg == '') {
			sheetObjects[0].LoadSaveXml("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
			sheetObjects[1].LoadSaveXml("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
		} else {
//			aler""t(rMsg.split('<||>').join('\n'));
			sheetObj.LoadSaveXml(sXml);
		}
		
		break;

	case IBCLEAR: // 조회		
		if (formObj.bkg_no2.value != null && formObj.bkg_no2.value != '') {
			var formObj2 = document.form2;
			var obj = null;
			var objNm = null;
			var obj2 = null;
			var objNm2 = null;
			
			var eleLen = formObj.elements.length;
			var eleLen2 = formObj2.elements.length;

			for ( var i = 0; i < eleLen; i++) {
				if (formObj.elements[i].name.indexOf("pck_qty") == 0)
					formObj.elements[i].value = ComAddComma(formObj.elements[i].value, "#,##0");
				if (formObj.elements[i].name.indexOf("cntr_wgt") == 0)
					formObj.elements[i].value = ComAddComma(formObj.elements[i].value, "#,###.000");
				if (formObj.elements[i].name.indexOf("vgm_wgt") == 0 && formObj.elements[i].name.indexOf("vgm_wgt_ut_cd") == -1 )
					formObj.elements[i].value = ComAddComma(formObj.elements[i].value, "#,###.000");
				if (formObj.elements[i].name.indexOf("meas_qty") == 0)
					formObj.elements[i].value = ComAddComma(formObj.elements[i].value, "#,###.000");	
			}
			for ( var j = 0; j < eleLen2; j++) {
				if (formObj2.elements[j].name.indexOf("pck_qty") == 0)
					formObj2.elements[j].value = ComAddComma(formObj2.elements[j].value, "#,##0");
				if (formObj2.elements[j].name.indexOf("cntr_wgt") == 0)
					formObj2.elements[j].value = ComAddComma(formObj2.elements[j].value, "#,###.000");
				if (formObj2.elements[j].name.indexOf("vgm_wgt") == 0 && formObj2.elements[j].name.indexOf("vgm_wgt_ut_cd") == -1 )
					formObj2.elements[j].value = ComAddComma(formObj2.elements[j].value, "#,###.000");
				if (formObj2.elements[j].name.indexOf("meas_qty") == 0)
					formObj2.elements[j].value = ComAddComma(formObj2.elements[j].value, "#,###.000");
			}

			// 같은 cntr no를 찾아서 색비교 처리
			var sameCntr = false;
			/*for ( var i = 0; i < eleLen2; i++) {
				if (formObj2.elements[i].type == "text" && (formObj2.elements[i].name).indexOf("__") > 0) {
					obj = (formObj2.elements[i].name).split("__");
					objNm = obj[0];
					if (objNm == "cntr_no") {
						obj2 = (formObj.elements[i].name).split("__");
						var sameCntrSeq = findSameCntr(formObj, formObj2.elements[i].value);
						if(sameCntrSeq > 0){
							sameCntr = false;
						} else {
							sameCntr = true;
						}			

						if (sameCntr) {
							compareCntr(obj2[1], obj[1]);
						}
					}
				}				
				
			}
			*/
			for ( var i = 0; i < eleLen2; i++) {
				if ((formObj2.elements[i].name).indexOf("__") > 0) {
					obj = (formObj2.elements[i].name).split("__");
					objNm = obj[0];
					// bkg쪽에 있는지 확인		
					if (objNm == "cntr_no") {
						for ( var j = 0; j < eleLen; j++) {
							if ((formObj.elements[j].name).indexOf("__") > 0) {
								obj2 = (formObj.elements[j].name).split("__");
								objNm2 = obj2[0];
								if (objNm2 == "cntr_no") {
									if (formObj2.elements[i].value == formObj.elements[j].value) {
										isInsert = "false";
										break;
									} else {
										isInsert = "true";
									}
								}

							}
						}
						if(isInsert=="false"){ 
							compareCntr(obj2[1], obj[1]);
						}
					}
				}
			}
			
		

			var sXml = formObj.sXml.value;
			var arrXml = sXml.split("|$$|");
			var arrXmlLen = arrXml.length;
			
			for ( var i = 0; i < arrXmlLen; i++) {
				sheetObjects[i].Redraw = false;
				if (i > 0) {
					sheetObjects[i].WaitImageVisible = false;
				}
				sheetObjects[i].RemoveAll();
				sheetObjects[i].LoadSearchXml(arrXml[i]);
				sheetObjects[i].Redraw = true;
			}
			
			var sheetRow = sheetObjects[0].Rows;
			
			for ( var i = 1; i < sheetRow; i++){
				if (sheetObjects[0].CellValue(i, "cntr_cfm_flg") == "Y"){
					sheetObjects[0].CellValue2(i, "cntr_cfm_flg") = "1";
				} else {
					sheetObjects[0].CellValue2(i, "cntr_cfm_flg") = "0";
				}
			}
					
			var leftSeq = 0;
			var rowStatus = "";
			for ( var i = 0; i < formObj.elements.length; i++) {
				if (formObj.elements[i].name.indexOf("pck_qty") == 0) {
					leftSeq++;
					rowStatus = sheetObjects[0].RowStatus(leftSeq);
					sheetObjects[0].CellValue2(leftSeq, "left_seq") = leftSeq;
					sheetObjects[0].RowStatus(leftSeq) = rowStatus;
				}
			}

			for ( var i = 0; i < eleLen; i++) {
				if (formObj.elements[i].name.indexOf("pck_qty") == 0) {
					formObj.elements[i].value = ComAddComma(formObj.elements[i].value, "#,##0");
				}
				if (formObj.elements[i].name.indexOf("meas_qty") == 0) {
					formObj.elements[i].value = makeComma(formObj.elements[i].value.replace(/,/g, ""));
				}
				if (formObj.elements[i].name.indexOf("cntr_wgt") == 0) {
					formObj.elements[i].value = makeComma(formObj.elements[i].value.replace(/,/g, ""));
				}
				if (formObj.elements[i].name.indexOf("vgm_wgt") == 0 
						&& formObj.elements[i].name.indexOf("vgm_wgt_ut_cd") == -1) {
					formObj.elements[i].value = makeComma(formObj.elements[i].value.replace(/,/g, ""));
				}
				
				if (formObj.elements[i].name.indexOf("rcv_term_cd") == 0) {
					if ( ComGetObjValue(parent.document.frames("t1frame").form.rcv_term_cd) == "M" ) {
						formObj.elements[i].disabled = false;
					} else {
						formObj.elements[i].disabled = true;
					}
				}
				if (formObj.elements[i].name.indexOf("de_term_cd") == 0) {
					if ( ComGetObjValue(parent.document.frames("t1frame").form.de_term_cd) == "M" ) {
						formObj.elements[i].disabled = false;
					} else {
						formObj.elements[i].disabled = true;
					}
				}
			}  
			for ( var i = 0; i < eleLen2; i++) {
				if (formObj2.elements[i].name.indexOf("pck_qty") == 0) {
					formObj2.elements[i].value = ComAddComma(formObj2.elements[i].value, "#,##0");
				}
				if (formObj2.elements[i].name.indexOf("meas_qty") == 0) {
					formObj2.elements[i].value = makeComma(formObj2.elements[i].value.replace(/,/g, ""));
				}
				if (formObj2.elements[i].name.indexOf("cntr_wgt") == 0) {
					formObj2.elements[i].value = makeComma(formObj2.elements[i].value.replace(/,/g, ""));
				}
				if (formObj2.elements[i].name.indexOf("vgm_wgt") == 0
						&& formObj2.elements[i].name.indexOf("vgm_wgt_ut_cd") == -1) {
					formObj2.elements[i].value = makeComma(formObj2.elements[i].value.replace(/,/g, ""));
				}
			}
			
		}
		if(parent.document.form.containerTabCancel.value=="Y"){
			ComBtnColor("btn_cancelcopydata", "blue");
			ComBtnColor("btn_datacopytoalps", "#737373");
			parent.document.form.containerTabCancel.value = "N";
		}
		if(top.document.form.tabload3.value == "COPY"){
			dataCopy();
		}
		top.document.form.tabload3.value = "LOAD";
		break;

	case IBSEARCH: // 조회
		formObj.f_cmd.value = SEARCH;
		formObj.method = "post";
		formObj.target = "_self";
		formObj.action = "/hanjin/ESM_BKG_0229_03.do";
		formObj.submit();

		parent.tabObjects[0].TabBackColor(2) = "#96c792";
		break;
		
	// 조회된 eSVC CNTR를 BKG 쪽으로 복사(화면 form)  
	case IBSEARCH_ASYNC02: // Data Copy
		// DHTML 테이블 생성
		var ins_tables = document.getElementById("INS_TABLES");
//		ins_tables.innerHTML = "";
		var insTableDiv = "";

		var maxSeq = 0;
		/*
		 * for ( var k = 0; k < formObj.elements.length; k++) { if
		 * ((formObj.elements[k].name).indexOf("cntr_seq__") == 0) { if
		 * (formObj.elements[k].value > maxSeq) maxSeq =
		 * formObj.elements[k].value; } }
		 */
		if (sheetObjects[0].RowCount > 0) {
			maxSeq = sheetObjects[0].RowCount;
		}

		// 컨테이너 비교
		var formObj2 = document.form2;
		var obj = null;
		var objNm = null;
		var obj2 = null;
		var objNm2 = null;
		
//		if ( document.form.fnl_cfm_flg.value == "Y") break;			

		var isInsert = "init";
		
		var eleLen = formObj.elements.length;
		var eleLen2 = formObj2.elements.length;
		
		if (maxSeq > 0) {
			for ( var i = 0; i < eleLen2; i++) {
				if ((formObj2.elements[i].name).indexOf("__") > 0) {
					obj = (formObj2.elements[i].name).split("__");
					objNm = obj[0];
					// bkg쪽에 있는지 확인		
					if (objNm == "cntr_no") {
						for ( var j = 0; j < eleLen; j++) {
							if ((formObj.elements[j].name).indexOf("__") > 0) {
								obj2 = (formObj.elements[j].name).split("__");
								objNm2 = obj2[0];
								if (objNm2 == "cntr_no") {
									if (formObj2.elements[i].value == formObj.elements[j].value) {
										isInsert = "false";
										break;
									} else {
										isInsert = "true";
									}
								}

							}
						}
						if (isInsert=="true") { // 새로 복사되는 cntr 정보
							maxSeq++;
							var insTableDiv = createTable(maxSeq);
							ins_tables.innerHTML += insTableDiv;
								createCntr(maxSeq, obj[1]);
						} else if(isInsert=="false"){ // 수정되는 cntr 정보
							updateCntr(obj2[1], obj[1]);
							compareCntr(obj2[1], obj[1]);
						}
					}
				}
			}
		} else {
			for ( var i = 0; i < eleLen2; i++) {
				if (formObj2.elements[i].type == "text" && (formObj2.elements[i].name).indexOf("__") > 0) {
					obj = (formObj2.elements[i].name).split("__");
					objNm = obj[0];
					if (objNm == "cntr_no") {
						maxSeq++;
						var insTableDiv = createTable(maxSeq);
						ins_tables.innerHTML += insTableDiv;
						createCntr(maxSeq, obj[1]);
					}
				}
			}
		}

		var seq = 1;
		
		for ( var i = 0; i < eleLen; i++) {
			if ( document.form.fnl_cfm_flg.value != "Y" ) {
				var objNm = (formObj.elements[i].name).split("__");
				if (objNm[0] == "cntr_seq") {
					formObj.elements[i].value = seq++;
				} else if (objNm[0] == "rcv_term_cd"){
					if ( ComGetObjValue(parent.document.frames("t1frame").form.rcv_term_cd) == "M" ) {
						formObj.elements[i].disabled = false;
					} else {
						formObj.elements[i].disabled = true;
						formObj.elements[i].value = ComGetObjValue(parent.frames("t1frame").document.form.rcv_term_cd);
					}
				} else if (objNm[0] == "de_term_cd"){
					if ( ComGetObjValue(parent.document.frames("t1frame").form.de_term_cd) == "M" ) {
						formObj.elements[i].disabled = false;
					} else {
						formObj.elements[i].disabled = true;
						formObj.elements[i].value = ComGetObjValue(parent.frames("t1frame").document.form.de_term_cd);
					}
				}
			} else {
				if (objNm[0] == "rcv_term_cd"){
					formObj.elements[i].disabled = false;
				} else if (objNm[0] == "de_term_cd"){
					formObj.elements[i].disabled = false;
				}
			}
		}
		
		parent.tabObjects[0].TabBackColor(2) = "#fff270";
		isCopy = "true";
		initControl();
		break;

	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSAVE:
			var cntrSheet = sheetObjects[0];
			var cntrCount = cntrSheet.RowCount + 1;
			for (ir = 1; ir < cntrCount; ir++) {
				if (cntrSheet.CellValue(ir, "ibflag") != 'D') {
					if (cntrSheet.CellValue(ir, "ibflag") == 'I') {
						if ( document.form.fnl_cfm_flg.value == "Y" ) {
							ComShowMessage(ComGetMsg("BKG02059",cntrSheet.CellValue(ir, "cntr_no")));
							return false;
						}
					}
	//				if (cntrSheet.CellValue(ir, "bkg_no") == '') {
	//					ComShowMessage(ComGetMsg("BKG00888", "bkg_no"));
	//					return false;
	//				}
					if (cntrSheet.CellValue(ir, "cntr_no") == '') {
						ComShowMessage(ComGetMsg("BKG00888", "cntr_no"));
	//					cntrSheet.SelectCell(ir, "cntr_no");
						ComSetFocus(eval("formObj.cntr_no__" + ir));
						return false;
					}
					//[CHM-201641324] DEL이 바레인일 때 measure값이 0이면 save block
					if(BkgParseInt(cntrSheet.CellValue(ir, "meas_qty")) <= 0
							&& "BH"==parent.frames("t1frame").document.form.bkg_del_cd.value.substring(0,2)){
						ComShowMessage(ComGetMsg("BKG95112"));
 						ComSetFocus(eval("formObj.meas_qty__" + ir));
						return false;
					}
					if(!ComIsEmpty(cntrSheet.CellValue(ir, "vgm_wgt"))){
						if(BkgParseFloat(cntrSheet.CellValue(ir, "vgm_wgt")) > 0 && ComIsEmpty(cntrSheet.CellValue(ir, "vgm_wgt_ut_cd"))){
							ComShowCodeMessage("BKG00104", " VGM Unit ");
							return false;
						}
						// VGM이 weight보다는 작으면 save block
						if (BkgParseFloat(cntrSheet.CellValue(ir, "vgm_wgt")) > 0){
							if(("R" == parent.document.frames("t1frame").form.bkg_cgo_tp_cd.value) || ( !ComIsEmpty(cntrSheet.CellValue(ir, "cntr_tpsz_cd")) 
																											&& ("T2" == cntrSheet.CellValue(ir, "cntr_tpsz_cd") 
																													|| "T4" == cntrSheet.CellValue(ir, "cntr_tpsz_cd") ))){
								if (BkgParseFloat(cntrSheet.CellValue(ir, "vgm_wgt")) < BkgParseFloat(cntrSheet.CellValue(ir, "cntr_wgt"))) {
									ComShowMessage(ComGetMsg("BKG95118"));
									return false;
								}
							} else {
								if (BkgParseFloat(cntrSheet.CellValue(ir, "vgm_wgt")) <= BkgParseFloat(cntrSheet.CellValue(ir, "cntr_wgt"))) {
									ComShowMessage(ComGetMsg("BKG95118"));
									return false;
								}
							}
						}
					}
					
					if(!ComIsEmpty(cntrSheet.CellValue(ir, "pck_qty"))){
						// pck qty && BB_FLAG
						if(BkgParseInt(cntrSheet.CellValue(ir, "pck_qty")) < 0){
							ComShowMessage(ComGetMsg("BKG00888", "pck_qty"));
	//						cntrSheet.SelectCell(ir, "pck_qty");
							ComSetFocus(eval("formObj.pck_qty__" + ir));
							return false;
						}else if(BkgParseInt(cntrSheet.CellValue(ir, "pck_qty")) == 0 && cntrSheet.CellValue(ir, "bb_cgo_flg") == 0){
							ComShowMessage(ComGetMsg("BKG00888", "pck_qty"));
	//						cntrSheet.SelectCell(ir, "pck_qty");
							ComSetFocus(eval("formObj.pck_qty__" + ir));
							return false;
						}
						// pck tpye
						if(ComIsEmpty(cntrSheet.CellValue(ir, "pck_tp_cd"))){
							ComShowMessage(ComGetMsg("BKG00888", "pck_tp_cd"));
	//						cntrSheet.SelectCell(ir, "pck_tp_cd");
							ComSetFocus(eval("formObj.pck_tp_cd__" + ir));
							return false;
						}						
					}
					
					// 2015.12.03 [CHM-201538980] POD USLAX/USLGB, USOAK, USSEA 인 경우 Weight LIMITATION을 확인하고 초과하면 경고메세지
					var podCd = parent.document.frames("t1frame").form.bkg_pod_cd.value;					 
					if(podCd=="USLAX"||podCd=="USLGB"){
						var maxWgt = 0;
						var tpSz = cntrSheet.CellValue(ir, "cntr_tpsz_cd");  
						if(tpSz.substring(1,2) == "2"){
							maxWgt = 44000;
						}
						if(cntrSheet.CellValue(ir, "wgt_ut_cd")=="KGS"){
							maxWgt = ComUnitConverter("LBSKGS", maxWgt);
						}
						if(maxWgt!=0 && BkgParseFloat(cntrSheet.CellValue(ir, "cntr_wgt")) > maxWgt){
							ComShowCodeMessage("BKG08350","20ft: 44,000LBS");
						}
					}else if(podCd=="USOAK"||podCd=="USSEA"){
						var maxWgt = 0;
						var tpSz = cntrSheet.CellValue(ir, "cntr_tpsz_cd");  
						if(tpSz.substring(1,2) == "2"){
							maxWgt = 47000;
						}else{
							maxWgt = 57000;
						}
						if(cntrSheet.CellValue(ir, "wgt_ut_cd")=="KGS"){
							maxWgt = ComUnitConverter("LBSKGS", maxWgt);
						}
						if(maxWgt!=0 && BkgParseFloat(cntrSheet.CellValue(ir, "cntr_wgt")) > maxWgt){
							ComShowCodeMessage("BKG08350","(20ft: 47,000LBS, 40,45ft:57,000LBS)");
						}
					}
				}	
			}

			// At Risk에 해당하는 장비이면 validation메시지 팝업(Reefer)
		   	// 조건: POD = US, POD= CA,  US Frob의 경우
		   	var params = "f_cmd="+SEARCH02;
		   	params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true), "sheet1_");
		   	var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0229_03GS.do", params);
		   	var arrXml = sXml.split("|$$|");
		   	var rskFlg = ComGetEtcData(arrXml[0],"rskFlg");
		   	if(rskFlg =="Y"){
		   		ComShowMessage(ComGetMsg("BKG08275"));
		   		formObj.rsk_flg.value = "Y";
		   	} else {
		   		formObj.rsk_flg.value = "N";
		   	}
		   	
		   	params = "f_cmd="+SEARCH03 + "&bkg_no=" + formObj.bkg_no.value;
		   	params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true), "sheet1_");
		   	sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0229_03GS.do", params);
		   	arrXml = sXml.split("|$$|");
		   	var cntrNo = ComGetEtcData(arrXml[0],"cntrNo");
		   	var vgmWgt = ComGetEtcData(arrXml[0],"vgmWgt");
		   	if( cntrNo != undefined && cntrNo != null && cntrNo != "" && cntrNo != "null"){
		   		if(confirm(ComGetMsg("BKG95119", cntrNo))){
			   		// continue
			   	} else {
			   		return false;
			   	}
		   		if(vgmWgt != 'null' && BkgParseFloat(vgmWgt) > 0){
		   			ComShowCodeMessage("BKG95118", cntrNo);
		   			return false;
		   		}
		   	}
		   	
		   	
			return chkCopyUnit();
			break;
	}
	return true;
}

/**
 * 전체 Upload 버튼 CLICK시 호출 됨 TAB에 상관 없이 동일 이름의 함수를 가짐 내용은 TAB에 맞게 구현 Validate 실패
 * 후 Focus 이동이 필요하면 (ex) Mandatory 항목 누락 후 Mandatory 필드에 Focus 이동 Focus 이동까지 한 후
 * return false
 */
function validateForUpload() {
	doCntrSaveCopy();
	return validateForm(sheetObjects[0], document.form, IBSAVE);
}

/**
 * 전체 Upload 버튼 CLICK시 호출 됨
 * TAB에 상관 없이 동일 이름의 함수를 가짐
 * 내용은 TAB에 맞게 구현
 * 각 화면에서 Upload 버튼이 눌렸을 때 SC에 parameter 로 던지는 QueryString을 만들어 return
 */
function getSaveStringForUpload() {
	var formObj = document.form;

	// 중복전송을 막기 위해 form상의 response data를 지운다
	var sXml = formObj.sXml.value;
	formObj.sXml.value = "";
	
	doCntrSaveCopy();
	
	formObj.f_cmd.value = MULTI;
	var params = FormQueryString(formObj);
	params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true), "sheet1_");
	params = params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true), "sheet2_");
	
	formObj.sXml.value = sXml;
	return (params);
}
 
function dataCopy() {
	ComBtnColor("btn_cancelcopydata", "#737373");
	ComBtnColor("btn_datacopytoalps", "blue");	
 	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
}

function setCopyFlag(flag){
	isCopy = flag;
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

function setSealNoDiffCheckColor(bkgValue, eBkgValue, eBkgItemNm){
	var formObj = document.form;
	var formObj2 = document.form2;
	var tmp = eval(eBkgItemNm);
	if(eBkgValue!=''){
		if (bkgValue != eBkgValue) {
			tmp.options[0].style.color = "blue"
		} else {
			tmp.options[0].style.color = "#606060";
		}
	}
}

//색 비교 처리
function compareCntr(leftSeq, rightSeq) {
	if(leftSeq==0||rightSeq==0) return;
	var formObj = document.form;
	var formObj2 = document.form2;
	setCntrDiffCheckColor(eval("formObj.cntr_no__" + leftSeq).value, eval("formObj2.cntr_no__" + rightSeq).value, ("formObj2.cntr_no__" + rightSeq));
	setCntrDiffCheckColor(eval("formObj.cntr_tpsz_cd__" + leftSeq).value, eval("formObj2.cntr_tpsz_cd__" + rightSeq).value, ("formObj2.cntr_tpsz_cd__" + rightSeq));
	setCntrDiffCheckColor(eval("formObj.pck_qty__" + leftSeq).value, eval("formObj2.pck_qty__" + rightSeq).value, ("formObj2.pck_qty__" + rightSeq));
	setCntrDiffCheckColor(eval("formObj.pck_tp_cd__" + leftSeq).value, eval("formObj2.pck_tp_cd__" + rightSeq).value, ("formObj2.pck_tp_cd__" + rightSeq));
	setCntrDiffCheckColor(eval("formObj.cntr_wgt__" + leftSeq).value, eval("formObj2.cntr_wgt__" + rightSeq).value, ("formObj2.cntr_wgt__" + rightSeq));
	setCntrDiffCheckColor(eval("formObj.vgm_wgt__" + leftSeq).value, eval("formObj2.vgm_wgt__" + rightSeq).value, ("formObj2.vgm_wgt__" + rightSeq));	
	setCntrDiffCheckColor(eval("formObj.seal_knd_cd__" + leftSeq).value, eval("formObj2.seal_knd_cd__" + rightSeq).value, ("formObj2.seal_knd_cd__" + rightSeq));
	setCntrDiffCheckColor(eval("formObj.seal_pty_tp_cd__" + leftSeq).value, eval("formObj2.seal_pty_tp_cd__" + rightSeq).value, ("formObj2.seal_pty_tp_cd__" + rightSeq));
	setCntrDiffCheckColor(eval("formObj.wgt_cd__" + leftSeq).value, eval("formObj2.wgt_cd__" + rightSeq).value, ("formObj2.wgt_cd__" + rightSeq));
	setCntrDiffCheckColor(eval("formObj.vgm_wgt_ut_cd__" + leftSeq).value, eval("formObj2.vgm_wgt_ut_cd__" + rightSeq).value, ("formObj2.vgm_wgt_ut_cd__" + rightSeq));	
	setCntrDiffCheckColor(eval("formObj.meas_qty__" + leftSeq).value, eval("formObj2.meas_qty__" + rightSeq).value, ("formObj2.meas_qty__" + rightSeq));
	setCntrDiffCheckColor(eval("formObj.meas_cd__" + leftSeq).value, eval("formObj2.meas_cd__" + rightSeq).value, ("formObj2.meas_cd__" + rightSeq));
	setCntrDiffCheckColor(eval("formObj.po_no__" + leftSeq).value, eval("formObj2.po_no__" + rightSeq).value, ("formObj2.po_no__" + rightSeq));
	
	setSealNoDiffCheckColor(eval("formObj.cntr_seal_no__" + leftSeq).value, eval("formObj2.cntr_seal_no__" + rightSeq).value, ("formObj2.cntr_seal_no__" + rightSeq));
	
	setCntrDiffCheckColor(eval("formObj.vgm_dtmn_dt__" + leftSeq).value, eval("formObj2.vgm_dtmn_dt__" + rightSeq).value, ("formObj2.vgm_dtmn_dt__" + rightSeq));
	setCntrDiffCheckColor(eval("formObj.vgm_mzd_tp_cd__" + leftSeq).value, eval("formObj2.vgm_mzd_tp_cd__" + rightSeq).value, ("formObj2.vgm_mzd_tp_cd__" + rightSeq));
	setCntrDiffCheckColor(eval("formObj.vgm_vrfy_dt__" + leftSeq).value, eval("formObj2.vgm_vrfy_dt__" + rightSeq).value, ("formObj2.vgm_vrfy_dt__" + rightSeq));
	setCntrDiffCheckColor(eval("formObj.vgm_vrfy_sig_ctnt__" + leftSeq).value, eval("formObj2.vgm_vrfy_sig_ctnt__" + rightSeq).value, ("formObj2.vgm_vrfy_sig_ctnt__" + rightSeq));
	
//	if (eval("formObj.cntr_no__" + leftSeq).value != eval("formObj2.cntr_no__" + leftSeq).value) {
//		var tmp = eval("formObj2.cntr_no__" + rightSeq);
//		tmp.style.color = "blue";
//	} else {
//		var tmp = eval("formObj2.cntr_no__" + rightSeq);
//		tmp.style.color = "blue";		
//	}
//	if (eval("formObj.cntr_tpsz_cd__" + leftSeq).value != eval("formObj2.cntr_tpsz_cd__" + rightSeq).value) {
//		var tmp = eval("formObj2.cntr_tpsz_cd__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.pck_qty__" + leftSeq).value != eval("formObj2.pck_qty__" + rightSeq).value) {
//		var tmp = eval("formObj2.pck_qty__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.pck_tp_cd__" + leftSeq).value != eval("formObj2.pck_tp_cd__" + rightSeq).value) {
//		var tmp = eval("formObj2.pck_tp_cd__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.cntr_wgt__" + leftSeq).value != eval("formObj2.cntr_wgt__" + rightSeq).value) {
//		var tmp = eval("formObj2.cntr_wgt__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.wgt_cd__" + leftSeq).value != eval("formObj2.wgt_cd__" + rightSeq).value) {
//		var tmp = eval("formObj2.wgt_cd__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.meas_qty__" + leftSeq).value != eval("formObj2.meas_qty__" + rightSeq).value) {
//		var tmp = eval("formObj2.meas_qty__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.meas_cd__" + leftSeq).value != eval("formObj2.meas_cd__" + rightSeq).value) {
//		var tmp = eval("formObj2.meas_cd__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.po_no__" + leftSeq).value != eval("formObj2.po_no__" + rightSeq).value) {
//		var tmp = eval("formObj2.po_no__" + rightSeq);
//		tmp.style.color = "blue";
//	}
}

//Container 리스트를 저장용 sheet로 Copy
function doCntrSaveCopy() {
	var formObj = document.form;
	var obj = null;
	var objNm = null;
	var objSeq = null;
	var objVal = null;
	var objCode = null;
	var cntrNo = null;
	var ibflag = null;
	var sealSeq = 0;
	var i = 0;
	var seal_cunt_flg = "N";
	var cntr_no = new Array();
	var cntr_seal_no = new Array();
	var seal_knd_cd = new Array();
	var seal_pty_tp_cd = new Array();
	var seal_pty_nm = new Array();
	var prn_flg = new Array();
	var cntrSheetRows = sheetObjects[0].Rows;
    var sealSheetRows = sheetObjects[1].Rows;
    for( i = 0; i <sealSheetRows; i++ ){
    	cntr_no[i] = sheetObjects[1].CellValue(i, "cntr_no");
    	cntr_seal_no[i] = sheetObjects[1].CellValue(i, "cntr_seal_no");
    	seal_knd_cd[i] = sheetObjects[1].CellValue(i, "seal_knd_cd");
    	seal_pty_tp_cd[i] = sheetObjects[1].CellValue(i, "seal_pty_tp_cd");
    	seal_pty_nm[i] = sheetObjects[1].CellValue(i, "seal_pty_nm");
    	prn_flg[i] = sheetObjects[1].CellValue(i, "prn_flg");
    } 
	sheetObjects[1].RemoveAll();
	
	var eleLen = formObj.elements.length;
	
	for ( i = 0; i < eleLen; i++) {
		if ((formObj.elements[i].name).indexOf("__") > 0) {
			obj = (formObj.elements[i].name).split("__");
			objNm = obj[0];
			objSeq = obj[1];
			objVal = formObj.elements[i].value;
			if(objSeq>cntrSheetRows){
				sheetObjects[0].DataInsert(-1);
			}
			if (objNm == "ibflag") {
				ibflag = objVal;
				if (sheetObjects[0].CellValue(objSeq, "ibflag") != "D") {
					sheetObjects[0].RowStatus(objSeq) = objVal;
				}
			}
			sheetObjects[0].CellValue(objSeq, "sel") = "N";
			
			// 화면에서 수정하지 않은 값
//			sheetObjects[0].CellValue(objSeq, "cntr_cfm_flg") = "Y";
			sheetObjects[0].CellValue(objSeq, "bkg_no") = formObj.bkg_no.value;
			if (objNm == "cntr_no") {
				cntrNo = objVal;
				sheetObjects[0].CellValue(objSeq, "cntr_no") = objVal;
				sheetObjects[0].CellValue(objSeq, "cntr_no_old") = objVal;
			}
			
			if (objNm == "cntr_tpsz_cd")	sheetObjects[0].CellValue(objSeq, "cntr_tpsz_cd") = objVal;
			if (objNm == "po_no")       	sheetObjects[0].CellValue(objSeq, "po_no")        = objVal;
			if (objNm == "pck_qty") 		sheetObjects[0].CellValue(objSeq, "pck_qty") 	  = (objVal).replaceStr(",");
			if (objNm == "pck_tp_cd") 		sheetObjects[0].CellValue(objSeq, "pck_tp_cd") 	  =  objVal;
			if (objNm == "cntr_wgt") 		sheetObjects[0].CellValue(objSeq, "cntr_wgt") 	  = (objVal).replaceStr(",");
			if (objNm == "wgt_cd") 			sheetObjects[0].CellValue(objSeq, "wgt_ut_cd") 	  =  objVal;
			if (objNm == "vgm_wgt") 		sheetObjects[0].CellValue(objSeq, "vgm_wgt") 	  = (objVal).replaceStr(",");
			if (objNm == "vgm_wgt_ut_cd") 			sheetObjects[0].CellValue(objSeq, "vgm_wgt_ut_cd") 	  =  objVal;
			if (objNm == "meas_qty") 		sheetObjects[0].CellValue(objSeq, "meas_qty") 	  = (objVal) .replaceStr(",");
			if (objNm == "meas_cd") 		sheetObjects[0].CellValue(objSeq, "meas_ut_cd")	  =  objVal;
			if (objNm == "rcv_term_cd") 	sheetObjects[0].CellValue(objSeq, "rcv_term_cd")  =  objVal;
			if (objNm == "de_term_cd") 		sheetObjects[0].CellValue(objSeq, "de_term_cd")	  =  objVal;
			
			if (objNm == "vgm_dtmn_dt") 		sheetObjects[0].CellValue(objSeq, "vgm_dtmn_dt")	  =  objVal;
			if (objNm == "vgm_mzd_tp_cd") 		sheetObjects[0].CellValue(objSeq, "vgm_mzd_tp_cd")	  =  objVal;
			if (objNm == "vgm_vrfy_dt") 		sheetObjects[0].CellValue(objSeq, "vgm_vrfy_dt")	  =  objVal;
			if (objNm == "vgm_vrfy_sig_ctnt") 		sheetObjects[0].CellValue(objSeq, "vgm_vrfy_sig_ctnt")	  =  objVal;
			
			if (objNm == "cntr_prt_flg") {
//				sheetObjects[0].CellValue(objSeq, "cntr_prt_flg") = (formObj.elements[i].checked)?"Y":"N";
				sheetObjects[0].CellValue(objSeq, "cntr_prt_flg") = (formObj.elements[i].checked)?"1":"0";
			}
			
			if (objNm == "cntr_seal_no") {
				seal_cunt_flg = "N";
				
				var eleILen = formObj.elements[i].length;
				
				for ( var j = 0; j < eleILen; j++) {
					sheetObjects[1].DataInsert(-1);
					sealSeq++;
					if (j == 0) sheetObjects[0].CellValue(objSeq, "seal_no1") = formObj.elements[i].options[j].value;
					if (j == 1) sheetObjects[0].CellValue(objSeq, "seal_no2") = formObj.elements[i].options[j].value;

//					sheetObjects[1].RowStatus(sealSeq) = ibflag;
					sheetObjects[1].CellValue(sealSeq, "bkg_no") = formObj.bkg_no.value;
					sheetObjects[1].CellValue(sealSeq, "cntr_no") = cntrNo;
					sheetObjects[1].CellValue(sealSeq, "cntr_seal_seq") = j + 1;
					sheetObjects[1].CellValue(sealSeq, "cntr_seal_no") = formObj.elements[i].options[j].value;
					for( var k = 0; k <sealSheetRows; k++ ){
						if ( cntrNo == cntr_no[k] && sheetObjects[1].CellValue(sealSeq, "cntr_seal_no") == cntr_seal_no[k] ){
							if(objSeq>sealKndCdArr.length){
								sheetObjects[1].CellValue(sealSeq, "seal_knd_cd") = seal_knd_cd[k];
							} else {
								sheetObjects[1].CellValue(sealSeq, "seal_knd_cd") = sealKndCdArr[objSeq][j];
							}	
							if(objSeq>sealPtyTpCdArr.length){
								sheetObjects[1].CellValue(sealSeq, "seal_pty_tp_cd") = seal_pty_tp_cd[k];
							} else {
								sheetObjects[1].CellValue(sealSeq, "seal_pty_tp_cd") = sealPtyTpCdArr[objSeq][j];
							}	
							sheetObjects[1].CellValue(sealSeq, "seal_pty_nm") = seal_pty_nm[k];
							sheetObjects[1].CellValue(sealSeq, "prn_flg") = prn_flg[k];
							seal_cunt_flg = "Y";
						}
				    }
					if ( seal_cunt_flg != "Y" ) {
						sheetObjects[1].RowStatus(sealSeq) = "I";
					} else {
						sheetObjects[1].RowStatus(sealSeq) = ibflag;
					}						
				}
			}
		}
	}
	
	var cntrCnt = 0;
	for ( var i = 1; i < sheetObjects[0].Rows; i++){
		cntrCnt = 0;
		if (sheetObjects[0].CellValue(i, "ibflag") == "D"){
			for ( var j = 1; j < sheetObjects[0].Rows; j++){
				if (sheetObjects[0].CellValue(i, "cntr_no") == sheetObjects[0].CellValue(j, "cntr_no")){
					cntrCnt++;
				}
			}
		}
		if ( cntrCnt > 1 ){
			sheetObjects[0].RowStatus(i) =  "";
			for ( var j = 1; j < sheetObjects[0].Rows; j++){
				if (sheetObjects[0].CellValue(j, "ibflag") == "I"){
					sheetObjects[0].RowStatus(j) =  "U";
				}
			}
		}
	}	
}

//Container 리스트(저장용 sheet)에 새로운 목록 추가
function doAddCntrCopy(leftSeq, rightSeq) {
	var formObj = document.form;
	var formObj2 = document.form2;
	var Row = sheetObjects[0].DataInsert(-1);
	sheetObjects[0].CellValue(Row, "left_seq") 		= leftSeq;
	sheetObjects[0].CellValue(Row, "right_seq") 	= rightSeq;
	sheetObjects[0].RowStatus(Row)					= "I";
	sheetObjects[0].CellValue(Row, "sel") 			= "N";
	sheetObjects[0].CellValue(Row, "cntr_cfm_flg") 	= "Y";
	sheetObjects[0].CellValue(Row, "bkg_no") 		= formObj.bkg_no.value;
	sheetObjects[0].CellValue(Row, "cntr_no") 		= eval("formObj2.cntr_no__"		+ rightSeq).value;
	sheetObjects[0].CellValue(Row, "cntr_no_old") 	= eval("formObj2.cntr_no__"		+ rightSeq).value;
	sheetObjects[0].CellValue(Row, "cntr_tpsz_cd") 	= eval("formObj2.cntr_tpsz_cd__"+ rightSeq).value;
	sheetObjects[0].CellValue(Row, "seal_no1") 		= eval("formObj2.cntr_seal_no__"+ rightSeq).value;
	sheetObjects[0].CellValue(Row, "pck_qty") 		=(eval("formObj2.pck_qty__"		+ rightSeq).value).replaceStr(",");
	sheetObjects[0].CellValue(Row, "pck_tp_cd") 	= eval("formObj2.pck_tp_cd__"	+ rightSeq).value;
	sheetObjects[0].CellValue(Row, "cntr_wgt") 		=(eval("formObj2.cntr_wgt__"	+ rightSeq).value).replaceStr(",");
	sheetObjects[0].CellValue(Row, "vgm_wgt") 		=(eval("formObj2.vgm_wgt__"	+ rightSeq).value).replaceStr(",");
	sheetObjects[0].CellValue(Row, "wgt_ut_cd") 	= eval("formObj2.wgt_cd__"		+ rightSeq).value;
	sheetObjects[0].CellValue(Row, "vgm_wgt_ut_cd") 	= eval("formObj2.vgm_wgt_ut_cd__"		+ rightSeq).value;
	
	sheetObjects[0].CellValue(Row, "vgm_dtmn_dt") 	= eval("formObj2.vgm_dtmn_dt__"		+ rightSeq).value;
	sheetObjects[0].CellValue(Row, "vgm_mzd_tp_cd") 	= eval("formObj2.vgm_mzd_tp_cd__"		+ rightSeq).value;
	sheetObjects[0].CellValue(Row, "vgm_vrfy_dt") 	= eval("formObj2.vgm_vrfy_dt__"		+ rightSeq).value;
	sheetObjects[0].CellValue(Row, "vgm_vrfy_sig_ctnt") 	= eval("formObj2.vgm_vrfy_sig_ctnt__"		+ rightSeq).value;
	
	sheetObjects[0].CellValue(Row, "meas_qty") 		=(eval("formObj2.meas_qty__"	+ rightSeq).value).replaceStr(",");
	sheetObjects[0].CellValue(Row, "meas_ut_cd") 	= eval("formObj2.meas_cd__"		+ rightSeq).value;
	sheetObjects[0].CellValue(Row, "po_no") 		= eval("formObj2.po_no__"		+ rightSeq).value;
	sheetObjects[0].CellValue(Row, "rcv_term_cd") 	= eval("formObj2.rcv_term_cd__"	+ rightSeq).value;
	sheetObjects[0].CellValue(Row, "de_term_cd") 	= eval("formObj2.de_term_cd__"	+ rightSeq).value;
	sheetObjects[0].CellValue(Row, "cntr_dp_seq") 	= leftSeq; // 2011.05.17 Kim Jin-Seung Added
}

//저장용 sheet에서 삭제된 cntr 표시
function doDeleteCntrAppend(seq) {
	var formObj = document.form;
	var foundRow = sheetObjects[0].FindText("left_seq", seq);
	sheetObjects[0].RowStatus(foundRow) = "D";
}

// 화면상에 cntr 추가
function createTable(seq) {
	var insTableDiv = "";
	insTableDiv += "<div id='table_" + seq + "'>\n";
	insTableDiv += "</div>\n";
	return insTableDiv;
}

//eSVC쪽 cntr을 bkg쪽으로 복사(add)
function createCntr(leftSeq, rightSeq) {
	var formObj2 = document.form2;
	var tabSeq = "table_" + leftSeq;
	var dyntbl1 = document.getElementById(tabSeq);
	dyntbl1.innerHTML = "";
	var oCell1 = "";
	var oCell2 = "";
	var seal_knd_cdArr = seal_knd_cd_list.split("|");
	var seal_pty_tp_cdArr = seal_pty_tp_cd_list.split("|");
	var wgt_cdArr = wgt_cd_list.split("|");
	var wgt_nmArr = wgt_nm_list.split("|");
	var meas_cdArr = meas_cd_list.split("|");
	var meas_nmArr = meas_nm_list.split("|");
	var rcv_term_cdArr = rcv_term_cd_list.split("|");
	var de_term_cdArr = de_term_cd_list.split("|");
	
	oCell1 += "<table id=\"table" + leftSeq
			+ "\" class=\"search\" border=\"0\"><tr class=\"h23\">\n";
	oCell1 += "<input type=\"hidden\" name=\"ibflag__" + leftSeq
			+ "\" value=\"I\">\n";
	oCell1 += "<td width=\"30\" rowspan=\"6\" valign=\"top\"><input type=\"text\" name=\"cntr_seq__" + leftSeq
			+ "\" style=\"width:25;text-align:center;\" class=\"input\" value=\"" + leftSeq 
			+ "\" readOnly></td>\n";
	oCell1 += "<td width=\"62\">CNTR No.</td>\n";
	oCell1 += "<input type=\"hidden\" name=\"cntr_no_hidden__" + leftSeq
			+ "\" value=\"" + eval("formObj2.cntr_no__" + rightSeq).value + rightSeq
			+ "\" readOnly></td>\n";
	oCell1 += "<td width=\"130\"><input type=\"text\" name=\"cntr_no__" + leftSeq
			+ "\" style=\"width:90;\" maxlength=\"14\" dataformat=\"engup\" class=\"input\" value=\"" + eval("formObj2.cntr_no__" + rightSeq).value
			+ "\" onChange=\"javascript:changeCntrTpszCd(this);\">&nbsp;<input type=\"text\" name=\"cntr_tpsz_cd__" + leftSeq
			+ "\" style=\"width:25;\" maxlength=\"4\" dataformat=\"engup\" class=\"input\" value=\"";
	if (eval("formObj2.cntr_tpsz_cd__" + rightSeq).value.length == 2) {
		oCell1 += eval("formObj2.cntr_tpsz_cd__" + rightSeq).value;
	}
	oCell1 += "\" readOnly></td>\n";
	oCell1 += "<td width=\"53\">&nbsp;</td>\n";
	oCell1 += "<td width=\"128\">&nbsp;</td>\n";
	oCell1 += "<td width=\"\">P&nbsp;<input type=\"checkbox\" value=\"\" class=\"trans\" name=\"cntr_prt_flg__" + leftSeq + "\" ></td></tr>\n";

	oCell1 += "<tr class=\"h23\"><td>Seal No.</td>\n";
	oCell1 += "<td>&nbsp;<select name=\"cntr_seal_no__" + leftSeq
	+ "\" style=\"width:117;\" onChange=\"changeBkgSealNo(this.name, this.selectedIndex)\">&nbsp;\n";

	sealKndCdArr[leftSeq] = new Array();
	sealPtyTpCdArr[leftSeq] = new Array();
	
	for ( var i = 0; i < eval("formObj2.cntr_seal_no__" + rightSeq).length; i++) {
		oCell1 += "<option value=\""
			+ eval("formObj2.cntr_seal_no__" + rightSeq).options[i].value + "\">"
			+ eval("formObj2.cntr_seal_no__" + rightSeq).options[i].text  + "</option>\n";
		sealKndCdArr[leftSeq][i] = eval("formObj2.seal_knd_cd__" + rightSeq).options[i].value;
		sealPtyTpCdArr[leftSeq][i] = eval("formObj2.seal_pty_tp_cd__" + rightSeq).options[i].value;
	}
	
	oCell1 += "</select></td>\n";
	oCell1 += "<td>KIND/CODE</td>\n";
	oCell1 += "<td colspan=\"2\">\n";
	oCell1 += "<select name=\"seal_knd_cd__" + leftSeq
			+ "\" style=\"width:51;\" class=\"input\" onChange=\"changeBkgSealKndCd(this.name)\">\n";
		for ( var j = 0; j < seal_knd_cdArr.length; j++) {
			//if (seal_knd_cdArr[j] == '') continue;
			if (seal_knd_cdArr[j] == eval("formObj2.seal_knd_cd__" + rightSeq).value) {
				oCell1 += "<option value=\"" + seal_knd_cdArr[j] + "\" selected>" + seal_knd_cdArr[j] + "</option>\n";
			} else {
				oCell1 += "<option value=\"" + seal_knd_cdArr[j] + "\">" + seal_knd_cdArr[j] + "</option>\n";
			}
		}
	oCell1 += "</select>\n";
	oCell1 += "<select name=\"seal_pty_tp_cd__" + leftSeq
			+ "\" style=\"width:51;\" class=\"input\" onChange=\"changeBkgSealPtyTpCd(this.name)\">\n";
		for ( var j = 0; j < seal_pty_tp_cdArr.length; j++) {
			//if (seal_pty_tp_cdArr[j] == '') continue;
			if (seal_pty_tp_cdArr[j] == eval("formObj2.seal_pty_tp_cd__" + rightSeq).value) {
				oCell1 += "<option value=\"" + seal_pty_tp_cdArr[j] + "\" selected>" + seal_pty_tp_cdArr[j] + "</option>\n";
			} else {
				oCell1 += "<option value=\"" + seal_pty_tp_cdArr[j] + "\">" + seal_pty_tp_cdArr[j] + "</option>\n";
			}
		}
	oCell1 += "</select>\n";	
	oCell1 += "</td>\n";
	oCell1 += "</tr>\n";
	
	oCell1 += "<tr class=\"h23\"><td>Package</td>\n";
	oCell1 += "<td><input type=\"text\" name=\"pck_qty__" + leftSeq
			+ "\" style=\"width:65;\" maxlength=\"12\" dataformat=\"int\" class=\"input\" value=\"" + eval("formObj2.pck_qty__" + rightSeq).value
			+ "\">&nbsp;<input type=\"text\" name=\"pck_tp_cd__" + leftSeq
			+ "\" style=\"width:27;\" dataformat=\"engup\" class=\"input\" value=\"" + eval("formObj2.pck_tp_cd__" + rightSeq).value
			+ "\">&nbsp;<a href=\"javascript:comBkgCallPop0696_position('setCallBack0696', document.form.pck_tp_cd__" + leftSeq + ".value, '" + leftSeq
			+ "');\"><img class=\"cursor\" src=\"img/btns_search.gif\" width=\"19\" height=\"20\" border=\"0\" align=\"absmiddle\"></td>\n";
	oCell1 += "<td>Weight</td>\n";
	oCell1 += "<td>&nbsp;<input type=\"text\" name=\"cntr_wgt__" + leftSeq
			+ "\" style=\"width:60;\" maxlength=\"18\" dataformat=\"float\" pointcount=\"3\" class=\"input\" value=\"" + eval("formObj2.cntr_wgt__" + rightSeq).value + "\">\n";
	oCell1 += "<select name=\"wgt_cd__" + leftSeq
			+ "\" style=\"width:60;\" class=\"input\">\n";
	for ( var i = 0; i < wgt_cdArr.length; i++) {
		if (wgt_cdArr[i] == '' && wgt_nmArr[i] == '')
			continue;
		if (wgt_cdArr[i] == eval("formObj2.wgt_cd__" + rightSeq).value) {
			oCell1 += "<option value=\"" + wgt_cdArr[i] + "\" selected>"
					+ wgt_nmArr[i] + "</option>\n";
		} else {
			oCell1 += "<option value=\"" + wgt_cdArr[i] + "\">" + wgt_nmArr[i]
					+ "</option>\n";
		}
	}
	oCell1 += "</select>\n";
	oCell1 += "<td valign=\"bottom\" rowspan=\"1\">\n";
	oCell1 += "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"button\">\n";
	oCell1 += "<tr><td class=\"btn2_left\"></td>\n";
	oCell1 += "<a href=\"javascript:btn_deleteTable('table" + leftSeq + "','" + leftSeq
			+ "');\"><td class=\"btn2\" name=\"btn_delete\">Delete</td></a>\n";
	oCell1 += "<td class=\"btn2_right\"></td>\n";
	oCell1 += "</tr></table></td></tr>\n";
	/* added 
	 * 
	 */
	oCell1 += "<tr class=\"h23 vgm_b_div\">\n";
	oCell1 += "<td>VGM</td>\n";
	oCell1 += "<td>&nbsp;<input type=\"text\" name=\"vgm_wgt__" + leftSeq
			+ "\" style=\"width:60;text-align:right\" maxlength=\"18\" dataformat=\"float\" pointcount=\"3\" class=\"input\" value=\"" + eval("formObj2.vgm_wgt__" + rightSeq).value + "\">\n";
	oCell1 += "<select name=\"vgm_wgt_ut_cd__" + leftSeq
			+ "\" style=\"width:60;\" class=\"input\">\n";
	for ( var i = 0; i < wgt_cdArr.length; i++) {
		if (wgt_cdArr[i] == '' && wgt_nmArr[i] == '')
			continue;
		var leftUtCd = wgt_cdArr[i];
		//console.log("11 : "+eval("formObj2.vgm_wgt_ut_cd__" + rightSeq).value.substring(0, 2));
		if (leftUtCd.length > 2 && eval("formObj2.vgm_wgt_ut_cd__" + rightSeq).value != '' 
								&& eval("formObj2.vgm_wgt_ut_cd__" + rightSeq).value.length > 2 && (leftUtCd.substring(0, 2) == eval("formObj2.vgm_wgt_ut_cd__" + rightSeq).value.substring(0, 2))) {
			oCell1 += "<option value=\"" + wgt_cdArr[i] + "\" selected>"
					+ wgt_nmArr[i] + "</option>\n";
		} else {
			oCell1 += "<option value=\"" + wgt_cdArr[i] + "\">" + wgt_nmArr[i]
					+ "</option>\n";
		}
	}
	oCell1 += "</select>\n";
	oCell1 += "<td class=\"vgm_div\" style=\"display:none;\">Signature</td>\n";
	oCell1 += "<td colspan=\"2\" class=\"vgm_div\" style=\"display:none;\"><input type=\"text\" style='width:110' maxlength=\"100\" dataformat=\"eng\" class=\"input\" value=\"" + eval("formObj2.vgm_vrfy_sig_ctnt__" + rightSeq).value + "\" readonly>\n</td>"; //
	
	oCell1 += "<tr class=\"h23 vgm_div\" style=\"display:none;\">\n";
	oCell1 += "<td>Verf. Date</td>\n";
	oCell1 += "<td>&nbsp;<input type=\"text\" name=\"vgm_vrfy_dt__" + leftSeq
			+ "\" style=\"width:70;\" maxlength=\"\" dataformat=\"\" class=\"input\" value=\"" + eval("formObj2.vgm_vrfy_dt__" + rightSeq).value + "\">\n";	
	oCell1 += "<td><input type=\"hidden\" name=\"vgm_dtmn_dt__" + leftSeq
			+ "\" style=\"width:70;\" maxlength=\"\" dataformat=\"\" class=\"input\" value=\"" + eval("formObj2.vgm_dtmn_dt__" + rightSeq).value + "\">\n&nbsp;Method</td>\n";
	oCell1 += "<td colspan=\"2\">";
	//oCell1 += "<input type=\"text\" style='width:110' maxlength=\"100\" dataformat=\"eng\" class=\"input\" value=\"" + eval("formObj2.vgm_mzd_tp_cd__" + rightSeq).value + "\" readonly>\n</td>"; //
	var _mtdValue = eval("formObj2.vgm_mzd_tp_cd__" + rightSeq).value;
	oCell1 += "<select name=\"vgm_mzd_tp_cd__" + leftSeq +"\" class=\"input2\" style=\"width:110;\" >";
	oCell1 += "<option value=\"\"></option>";
	oCell1 += "<option value=\"SM1\" " + ("SM1"==_mtdValue ? "selected" : "") +">Method 1 : Weighting of a packed container.</option>";
	oCell1 += "<option value=\"SM2\" " + ("SM2"==_mtdValue ? "selected" : "") +">Method 2 : Calculating VGM (Cargo weight + packing material + container tare weight</option>";
	oCell1 += "</select>";
	oCell1 += "</td></tr>\n";
	/*
	 * added end
	 */
	oCell1 += "<tr class=\"h23\"><td>Measure</td>\n";
	oCell1 += "<td><input type=\"text\" name=\"meas_qty__" + leftSeq
			+ "\" style=\"width:65;\" maxlength=\"12\" dataformat=\"float\" pointcount=\"3\" class=\"input\" value=\"" + eval("formObj2.meas_qty__" + rightSeq).value + "\">\n";
	oCell2 += "<select name=\"meas_cd__" + leftSeq
			+ "\" style=\"width:51;\" class=\"input\">\n";
	for ( var j = 0; j < meas_cdArr.length; j++) {
		if (meas_cdArr[j] == '' && meas_nmArr[j] == '')
			continue;
		if (meas_cdArr[j] == eval("formObj2.meas_cd__" + rightSeq).value) {
			oCell2 += "<option value=\"" + meas_cdArr[j] + "\" selected>" + meas_nmArr[j] + "</option>\n";
		} else {
			oCell2 += "<option value=\"" + meas_cdArr[j] + "\">" + meas_nmArr[j] + "</option>\n";
		}
	}
	oCell2 += "</select>\n";
	oCell2 += "</td>\n";
	oCell2 += "<td>RD Term</td>\n";
	oCell2 += "<td>\n";
	oCell2 += "<select name=\"rcv_term_cd__" + leftSeq
			+ "\" style=\"width:51;\" class=\"input\">\n";
		for ( var j = 0; j < rcv_term_cdArr.length; j++) {
			if (rcv_term_cdArr[j] == '') continue;
			if (rcv_term_cdArr[j] == ComGetObjValue(parent.document.frames("t1frame").form.rcv_term_cd)) {
				oCell2 += "<option value=\"" + rcv_term_cdArr[j] + "\" selected>" + rcv_term_cdArr[j] + "</option>\n";
			} else {
				oCell2 += "<option value=\"" + rcv_term_cdArr[j] + "\">" + rcv_term_cdArr[j] + "</option>\n";
			}
		}
	oCell2 += "</select>\n";
	oCell2 += "<select name=\"de_term_cd__" + leftSeq
			+ "\" style=\"width:51;\" class=\"input\">\n";
		for ( var j = 0; j < de_term_cdArr.length; j++) {
			if (de_term_cdArr[j] == '') continue;
			if (de_term_cdArr[j] == ComGetObjValue(parent.document.frames("t1frame").form.de_term_cd)) {
				oCell2 += "<option value=\"" + de_term_cdArr[j] + "\" selected>" + de_term_cdArr[j] + "</option>\n";
			} else {
				oCell2 += "<option value=\"" + de_term_cdArr[j] + "\">" + de_term_cdArr[j] + "</option>\n";
			}
		}
	oCell2 += "</select>\n";	
	oCell2 += "</td>\n";
	oCell2 += "</tr>\n";
//	oCell1 += "<td>P/O No.</td>\n";
	oCell2 += "<tr><td>&nbsp;<input type=\"hidden\" name=\"po_no__" + leftSeq
			+ "\" style=\"width:117;\" maxlength=\"20\" dataformat=\"engup\" class=\"input\" value=\"" + eval("formObj2.po_no__" + rightSeq).value + "\"></td></tr>\n";
	oCell2 += "<tr class=\"height_10\"><td colspan=\"8\"></td></tr>\n";
	oCell2 += "</table>\n";
	dyntbl1.innerHTML = oCell1+oCell2;
	
	// 저장용 Sheet에 새로운 컨테이너 추가
	doAddCntrCopy(leftSeq, rightSeq);
}

//eSVC쪽 cntr을 bkg쪽으로 복사(update)
function updateCntr(leftSeq, rightSeq) {
	var formObj = document.form;
	var formObj2 = document.form2;
	
	if ( document.form.fnl_cfm_flg.value != "Y" ) {
		if (eval("formObj2.cntr_no__" + rightSeq).value != null && eval("formObj2.cntr_no__" + rightSeq).value != '')
			eval("formObj.cntr_no__" + leftSeq).value = eval("formObj2.cntr_no__"+ rightSeq).value;
	
		if (eval("formObj2.cntr_tpsz_cd__" + rightSeq).value != null && eval("formObj2.cntr_tpsz_cd__" + rightSeq).value != '')
			eval("formObj.cntr_tpsz_cd__" + leftSeq).value = eval("formObj2.cntr_tpsz_cd__"+ rightSeq).value;
		
		if (eval("formObj2.prt_flg__" + rightSeq).value != null && eval("formObj2.prt_flg__" + rightSeq).value != '')
			eval("formObj.cntr_prt_flg__" + leftSeq).value = eval("formObj2.prt_flg__"+ rightSeq).value;
		
		if(eval("formObj.cntr_prt_flg__" + leftSeq).value=="Y"){
			eval("formObj.cntr_prt_flg__" + leftSeq).checked = true;
		} else {
			eval("formObj.cntr_prt_flg__" + leftSeq).checked = false;
		}
	}

	if (eval("formObj2.pck_qty__" + rightSeq).value != null && eval("formObj2.pck_qty__" + rightSeq).value != '')
		eval("formObj.pck_qty__" + leftSeq).value = eval("formObj2.pck_qty__"+ rightSeq).value;

	if (eval("formObj2.pck_tp_cd__" + rightSeq).value != null && eval("formObj2.pck_tp_cd__" + rightSeq).value != '')
		eval("formObj.pck_tp_cd__" + leftSeq).value = eval("formObj2.pck_tp_cd__"+ rightSeq).value;

	if (eval("formObj2.cntr_wgt__" + rightSeq).value != null && eval("formObj2.cntr_wgt__" + rightSeq).value != '')
		eval("formObj.cntr_wgt__" + leftSeq).value = eval("formObj2.cntr_wgt__"+ rightSeq).value;
	
	if (eval("formObj2.vgm_wgt__" + rightSeq).value != null && eval("formObj2.vgm_wgt__" + rightSeq).value != '')
		eval("formObj.vgm_wgt__" + leftSeq).value = eval("formObj2.vgm_wgt__"+ rightSeq).value;
	
	if (eval("formObj2.meas_qty__" + rightSeq).value != null && eval("formObj2.meas_qty__" + rightSeq).value != '')
		eval("formObj.meas_qty__" + leftSeq).value = eval("formObj2.meas_qty__"+ rightSeq).value;

	if (eval("formObj2.po_no__" + rightSeq).value != null && eval("formObj2.po_no__" + rightSeq).value != '')
		eval("formObj.po_no__" + leftSeq).value = eval("formObj2.po_no__"+ rightSeq).value;
	
	if (eval("formObj2.vgm_dtmn_dt__" + rightSeq).value != null && eval("formObj2.vgm_dtmn_dt__" + rightSeq).value != '')
		eval("formObj.vgm_dtmn_dt__" + leftSeq).value = eval("formObj2.vgm_dtmn_dt__"+ rightSeq).value;
	
	if (eval("formObj2.vgm_mzd_tp_cd__" + rightSeq).value != null && eval("formObj2.vgm_mzd_tp_cd__" + rightSeq).value != '')
		eval("formObj.vgm_mzd_tp_cd__" + leftSeq).value = eval("formObj2.vgm_mzd_tp_cd__"+ rightSeq).value;
	
	if (eval("formObj2.vgm_vrfy_dt__" + rightSeq).value != null && eval("formObj2.vgm_vrfy_dt__" + rightSeq).value != '')
		eval("formObj.vgm_vrfy_dt__" + leftSeq).value = eval("formObj2.vgm_vrfy_dt__"+ rightSeq).value;
	
	if (eval("formObj2.vgm_vrfy_sig_ctnt__" + rightSeq).value != null && eval("formObj2.vgm_vrfy_sig_ctnt__" + rightSeq).value != '')
		eval("formObj.vgm_vrfy_sig_ctnt__" + leftSeq).value = eval("formObj2.vgm_vrfy_sig_ctnt__"+ rightSeq).value;

	

	var sealNoObj = document.getElementById(eval("formObj.cntr_seal_no__"+ leftSeq).name);

	for ( var i = 0; i < eval("formObj2.cntr_seal_no__" + rightSeq).length; i++) {
		if (eval("formObj2.cntr_seal_no__" + rightSeq).value != null && eval("formObj2.cntr_seal_no__" + rightSeq).value != '') {
			sealNoObj.length = 0;	
		}
	}

	if ( sealNoObj.length == 0 ) {
		for ( var i = 0; i < eval("formObj2.cntr_seal_no__" + rightSeq).length; i++) {
			if (eval("formObj2.cntr_seal_no__" + rightSeq).value != null && eval("formObj2.cntr_seal_no__" + rightSeq).value != '') {
				var opt = document.createElement("option");
				opt.value = eval("formObj2.cntr_seal_no__" + rightSeq).options[i].value;
				opt.text  = eval("formObj2.cntr_seal_no__" + rightSeq).options[i].text;
				sealNoObj.add(opt);
				
				sealKndCdArr[leftSeq][i] = eval("formObj2.seal_knd_cd__" + rightSeq).options[i].value;
				sealPtyTpCdArr[leftSeq][i] = eval("formObj2.seal_pty_tp_cd__" + rightSeq).options[i].value;
			}
		}
	}
	
	if (eval("formObj2.seal_knd_cd__" + rightSeq).value != null && eval("formObj2.seal_knd_cd__" + rightSeq).value != '') {
		for ( var j = 0; j < eval("formObj.seal_knd_cd__" + leftSeq).length; j++) {
			if (eval("formObj.seal_knd_cd__" + leftSeq)[j].value == eval("formObj2.seal_knd_cd__" + rightSeq)[0].value) {
				eval("formObj.seal_knd_cd__" + leftSeq).selectedIndex = j;
				break;
			}
		}
	}
	if (eval("formObj2.seal_pty_tp_cd__" + rightSeq).value != null && eval("formObj2.seal_pty_tp_cd__" + rightSeq).value != '') {
		for ( var j = 0; j < eval("formObj.seal_pty_tp_cd__" + leftSeq).length; j++) {
			if (eval("formObj.seal_pty_tp_cd__" + leftSeq)[j].value == eval("formObj2.seal_pty_tp_cd__" + rightSeq)[0].value) {
				eval("formObj.seal_pty_tp_cd__" + leftSeq).selectedIndex = j;
				break;
			}
		}
	}

	if (eval("formObj2.wgt_cd__" + rightSeq).value != null && eval("formObj2.wgt_cd__" + rightSeq).value != '') {
		for ( var j = 0; j < eval("formObj.wgt_cd__" + leftSeq).length; j++) {
			if (eval("formObj.wgt_cd__" + leftSeq)[j].value == eval("formObj2.wgt_cd__" + rightSeq).value) {
				eval("formObj.wgt_cd__" + leftSeq).selectedIndex = j;
				break;
			}
		}
	}
	
	if (eval("formObj2.vgm_wgt_ut_cd__" + rightSeq).value != null && eval("formObj2.vgm_wgt_ut_cd__" + rightSeq).value != '') {
		for ( var j = 0; j < eval("formObj.vgm_wgt_ut_cd__" + leftSeq).length; j++) {
			var leftUtCd = eval("formObj.vgm_wgt_ut_cd__" + leftSeq)[j].value;
			//console.log(eval("formObj2.vgm_wgt_ut_cd__" + rightSeq).value.substring(0, 2));
			if (leftUtCd.length > 2 && (leftUtCd.substring(0, 2) == eval("formObj2.vgm_wgt_ut_cd__" + rightSeq).value.substring(0, 2))) {
				eval("formObj.vgm_wgt_ut_cd__" + leftSeq).selectedIndex = j;
				break;
			}
		}
	}

	if (eval("formObj2.meas_cd__" + rightSeq).value != null && eval("formObj2.meas_cd__" + rightSeq).value != '') {
		for ( var k = 0; k < eval("formObj.meas_cd__" + leftSeq).length; k++) {
			if (eval("formObj.meas_cd__" + leftSeq)[k].value == eval("formObj2.meas_cd__" + rightSeq).value) {
				eval("formObj.meas_cd__" + leftSeq).selectedIndex = k;
				break;
			}
		}
	}
}

//formObject에서 cntrNo를 찾아서 해당 seq를 return한다
function findSameCntr(formObj, cntrNo){
	var formObj1 = document.form;
	var formObj2 = document.form2;
	
	var obj = null;
	
	var eleLen = formObj.elements.length;
	
	for ( var j = 0; j < eleLen; j++) {
		if (formObj.elements[j].type == "text" && (formObj.elements[j].name).indexOf("__") > 0) {
			obj = (formObj.elements[j].name).split("__");
			if (obj[0] == "cntr_no") {
				if (cntrNo == eval(((formObj == formObj1)?"document.form.cntr_no__":"document.form2.cntr_no__") + obj[1]).value) {
					break;
				}
			}
		}
	}
	if(obj!=null&&obj[1]>0){
		return obj[1];
	} else {
		return 0;
	}
}

// BKG쪽 cntr 삭제
function btn_deleteTable(tableId, tableSeq) {
	var formObj = document.form;
	var seq = 1;
	doDeleteCntrAppend(tableSeq);
	var tbody = document.getElementById(tableId).getElementsByTagName("TBODY")[0];
	var rowCount = tbody.rows.length;
	while (rowCount > 0) {
		tbody.deleteRow(rowCount - 1);
		rowCount--;
	}
	
	var eleLen = formObj.elements.length;
	
	for ( var i = 0; i < eleLen; i++) {
		var objNm = (formObj.elements[i].name).split("__");
		if (objNm[0] == "cntr_seq") {
			formObj.elements[i].value = seq++;
		}
	}
}

function deleteAllTable() {
	var formObj = document.form;
	
	var eleLen = formObj.elements.length;
	
	for ( var i = 0; i < eleLen; i++) {
		if ((formObj.elements[i].name).indexOf("table") == 0) {
			btn_deleteTable(formObj.elements[i].value);
		}
	}
}

function changeXterSealNo(srcName, idx) {	
	var formObj         = document.form2;
	var seq 			= (srcName).split("__")[1];    
	var sealPtyTpCd = eval("formObj.seal_pty_tp_cd__" + seq);
	var sealKndCd = eval("formObj.seal_knd_cd__" + seq);
	sealPtyTpCd.options[idx].selected = true;
	sealKndCd.options[idx].selected = true;
}

function changeBkgSealKndCd(srcName) {	
	var formObj         = document.form;
	var seq 			= (srcName).split("__")[1];    
	var sealKndCd 		= eval("formObj.seal_knd_cd__" + seq);
	var sealNo 			= eval("formObj.cntr_seal_no__" + seq);
	var idx				= sealNo.selectedIndex;
	sealKndCdArr[seq][idx] = sealKndCd.value;
}

function changeBkgSealPtyTpCd(srcName) {	
	var formObj         = document.form;
	var seq 			= (srcName).split("__")[1];    
	var sealPtyTpCd 	= eval("formObj.seal_pty_tp_cd__" + seq);
	var sealNo 			= eval("formObj.cntr_seal_no__" + seq);
	var idx				= sealNo.selectedIndex;
	sealPtyTpCdArr[seq][idx] = sealPtyTpCd.value;
}

function changeBkgSealNo(srcName, idx) {	
	var formObj         = document.form;
	var seq 			= (srcName).split("__")[1];    
	var sealKndCd = eval("formObj.seal_knd_cd__" + seq);
	var sealPtyTpCd = eval("formObj.seal_pty_tp_cd__" + seq);
	for(var j=0;j<sealKndCd.length;j++){
		if(sealKndCdArr[seq][idx]==undefined){
			sealKndCd.options[0].selected = true;
		} else if(sealKndCd.options[j].value == sealKndCdArr[seq][idx]){
			sealKndCd.options[j].selected = true;
		} 
	}
	for(var j=0;j<sealPtyTpCd.length;j++){
		if(sealPtyTpCdArr[seq][idx]==undefined){
			sealPtyTpCd.options[0].selected = true;
		} else if(sealPtyTpCd.options[j].value == sealPtyTpCdArr[seq][idx]){
			sealPtyTpCd.options[j].selected = true;
		} 
	}
}

function changeCntrTpszCd(obj) {	
	var formObj         = document.form;
	var sheetObj 		= sheetObjects[0];
	var srcName 		= obj.name;
    var seq 			= (obj.name).split("__")[1];    
	var cntr_no 		= obj.value;
	
	if(cntr_no == "") return false;
	
	// 숫자이고 7자리일경우 [BKG00172] 메세지를 표시하고 Yes를 선택하면 HJCU를 앞에 붙여줌
	if(!isNaN(cntr_no) && cntr_no.length==7){
		if(confirm(ComGetMsg("BKG00172"))){
			cntr_no = "HJCU" + cntr_no;
			obj.value = cntr_no;
			sheetObj.CellValue2(seq, "cntr_no") = cntr_no;
		}
	}
	
	// 첫자리가 K이고 8자리이면 K를 KSCU로 변경
//	if(cntr_no.charAt(0) == 'K' && cntr_no.length==8){
//		//if(confirm(ComGetMsg("BKG00172"))){
//			cntr_no = "KSCU" + cntr_no.substring(1);
//			sheetObj.CellValue2(row, "cntr_no") = cntr_no;
//		//}
//	}
	// 중복되는 CNTR No.를 넣은 경우 메시지 [BKG00965] 표시후 입력한 Data 삭제후 focus
	for(ir=sheetObj.HeaderRows;ir<=sheetObj.RowCount;ir++){
		var tmpNo = sheetObj.CellValue(ir, "cntr_no");
		var tmpDelSt = sheetObj.RowStatus(ir);
		if(ir==seq) continue;
		if(cntr_no == tmpNo && tmpDelSt != "D"){
			ComShowMessage(ComGetMsg("BKG00965", cntr_no));
			obj.value = "";
			sheetObj.CellValue2(seq, "cntr_no") = "";
			ComSetFocus(srcName);
			return false;
		}
	}

	formObj.f_cmd.value = SEARCH01;
	var param = "f_cmd=" + formObj.f_cmd.value + "&cntr_no=" + cntr_no;	

	var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0229_03GS.do", param);
	var cntrTpszCd = ComGetEtcData(sXml, "cntr_tpsz_cd");
	if (cntrTpszCd == "null" || cntrTpszCd == "") {
		// 별도 msg 없음(신은영 차장님 요청)
//		ComShowMessage(msgs['BKG00155']);
		return;
	}

//	if(sheetObj.CellValue(seq, "cntr_no") == '' || sheetObj.CellValue(seq, "cntr_tpsz_cd") == ''){
//		ComShowMessage(ComGetMsg("BKG00173", cntr_no));
//		sheetObj.CellValue2(row, "cntr_no") = '';
//		ComSetFocus(srcName);
//		return false;
//	}
	var cntrTpszCdObj = eval("formObj.cntr_tpsz_cd__" + seq);
	cntrTpszCdObj.value = cntrTpszCd;

	var cntr_no = ComGetEtcData(sXml, "cntr_no");
	var cntrNo = eval("formObj.cntr_no__" + seq);
	cntrNo.value = cntr_no;
}

function form1_change(){
	var formObj         = document.form;
    var srcName 		= event.srcElement.getAttribute("name");
	var srcValue 		= event.srcElement.getAttribute("value");
	var sheetObj 		= sheetObjects[0];
	var obj 			= (srcName).split("__");
	var col_save_name 	= obj[0];
    var row 			= obj[1];
    
    var bkg_no        	= formObj.bkg_no.value;
    var cntr_no 		= sheetObj.CellValue(row, "cntr_no");

	// 2018.05.25 iylee Form Change 일때 소문자 -> 대문자로 바꾸어줌.
	ComSetUpperChange(srcName, srcValue);

    switch(col_save_name){
    
		case "cntr_no":
			/* Container No 수정 */
			if(cntr_no == '') {
				return false;
			}			
			
			//changeCntrTpszCd()에서 처리
//			// cntr tpsz 가져오기 및 각종 데이터 설정. 잘못된 Container No를 넣으면 메세지 표시[BKG00173]
//			var cntrXml = sheetObj.GetSearchXml("ESM_BKG_0079_04GS.do", "f_cmd="+SEARCH01+"&bkg_no="+bkg_no+"&cntr_no=" + cntr_no);
//			// XML Parsing
//			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
//			xmlDoc.async="false";
//			xmlDoc.loadXML(cntrXml);
//			
//			var dataNode = xmlDoc.documentElement.getElementsByTagName("ETC-DATA").item(0);
//			var dataChildNodes = dataNode.childNodes;
//	
//			if(dataChildNodes.length > 0){
//				var hasCntr = false;
//				for (ic=0; ic<dataChildNodes.length; ic++) {
//					var xName = dataChildNodes.item(ic).getAttribute("KEY");
//					if(xName == "cntr_no") {
//						hasCntr = true;
//						break;
//					}
//				}
//				
//				if(hasCntr){
//					for (ic=0; ic<dataChildNodes.length; ic++) {
//						var xName = dataChildNodes.item(ic).getAttribute("KEY");
//						if(xName == "ibflag") continue;
//						sheetObj.CellValue2(row, xName) = dataChildNodes.item(ic).text
//					}
//					cntr_no = sheetObj.CellValue(row, "cntr_no");
//				}else{
//					ComSetFocus(srcName);
//				}
//			}								
//			// 존재하지 않은 Type Code를 사용하는지 체크.
//			var cTp = sheetObj.CellValue(row, "cntr_tpsz_cd");
//			if((cTp == 'D4' || cTp == 'D5') && document.form.flex_hgt_flg.value == 'Y'){
//				// ignore it!
//			}else{
//				var qTpArr = ComFindText(sheetObjects[0], "cntr_tpsz_cd", cTp);
//				if(qTpArr.length == 0){
//					ComShowMessage(ComGetMsg("BKG00062", cTp));
//					return false;
//				}else if(sheetObjects[0].CellValue(qTpArr[0], "op_cntr_qty") == '' || sheetObjects[0].CellValue(qTpArr[0], "op_cntr_qty") == 0){
//					ComShowMessage(ComGetMsg("BKG00062", cTp));
//					return false;
//				}
//			}
			
			break;
		case "meas_qty":/* Measure */
			if(sheetObj.CellValue(row, "meas_qty") >= 1000){
				ComShowMessage(ComGetMsg("BKG00174"));
				sheetObj.CellValue2(row, "meas_qty") = 0;
				sheetObj.SelectCell(row, "meas_qty");
				return false;
			}
			document.getElementById(srcName).value = makeComma(srcValue.replace(/,/g, ""));
			break;
		case "cntr_wgt":
			document.getElementById(srcName).value = makeComma(srcValue.replace(/,/g, ""));
			break;
		case "vgm_wgt":/* Weight */
			document.getElementById(srcName).value = makeComma(srcValue.replace(/,/g, ""));
			break;
		case "pck_qty":/* pck_qty */
//			document.getElementById(srcName).value = makeComma(srcValue.replace(/,/g, ""));
			document.getElementById(srcName).value = ComAddComma(srcValue, "#,##0");
			break;
			
    }
	isCopy = "false";
    compareCntr(row, findSameCntr(document.form2, cntr_no));
}


function getElementsByClassName(classname, node)  {
    if(!node) node = document.getElementsByTagName("body")[0];
    var a = [];
    var re = new RegExp('\\b' + classname + '\\b');
    var els = node.getElementsByTagName("*");
    for(var i=0,j=els.length; i<j; i++)
        if(re.test(els[i].className))a.push(els[i]);
    return a;
}
/**
 * Click 일때
 */
function bkg0229_03_click() {
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	if (srcName == "showVgmChk") {
		var _sts = "none";
		var _bc = "";
		if (formObj.showVgmChk.checked) {
			_sts = "block";
			_bc = "#aaa9ad";
		} else {
			_sts = "none";
		}
		var elements = new Array();
		elements = getElementsByClassName('vgm_div');
		for(i in elements ){
		     elements[i].style.display = _sts;
		     elements[i].style.backgroundColor = _bc;
		}
		elements = getElementsByClassName('vgm_b_div');
		for(i in elements ){
		     elements[i].style.backgroundColor = _bc;
		}
		
		
	}
}

function obj_keypress() {
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	switch (event.srcElement.dataformat) {
	case "int":
		// 숫자만입력하기
		// ComAddSeparator(event.srcElement, "int");
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "float":
		// 숫자+"."입력하기
		ComKeyOnlyNumber(event.srcElement, ".");
		break;
	case "eng":
		// 영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
		ComKeyOnlyAlphabet();
		break;
	case "engdn":
		// 영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
		ComKeyOnlyAlphabet('lower');
		break;
	case "engup":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "uppernum":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "etc": // 모든 문자 가능하지만 영문은 대문자로
		if (keyValue >= 97 && keyValue <= 122) {// 소문자
			event.keyCode = keyValue + 65 - 97;
		}
		break;
	default:
		// 숫자만입력하기(정수,날짜,시간)
		ComKeyOnlyNumber(event.srcElement);
	}
}

function form1_blur() {
	ComChkObjValid(event.srcElement);
}

//function loadComboData1(cd, nm) {
// 	wgt_cd = cd;
// 	wgt_nm = nm;
//}
//
//function loadComboData2(cd, nm) {
// 	meas_cd = cd;
// 	meas_nm = nm;
//}

function comBkgCallPop0696_position(funcNm, val, pos) {
 	pkgPosition = pos;
 	//comBkgCallPop0696(funcNm, val);
 	comBkgCallModal0696(funcNm, val);
}

function setCallBack0696(aryPopupData) {
 	var formObj = document.form;
 	eval("formObj.pck_tp_cd__" + pkgPosition).value = aryPopupData[0][3];
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

//저장용 sheet로 Copy된 Container Unit 정보가 모두 같은지 체크
function chkCopyUnit(){
	// 저장용 sheet로 Copy된 Container Unit 정보가 모두 같은지 체크

	var wgtUtCdChk = true;
	var measUtCdChk = true;

	var wgtUtCd = null;
	var measUtCd = null;

	if( sheetObjects[0].Rows > 1 ){
		for ( var i = 1; i < sheetObjects[0].Rows; i++){
			if( wgtUtCd == null && measUtCd == null && sheetObjects[0].RowStatus(i) != "D" ){
				wgtUtCd = sheetObjects[0].CellValue(i, "wgt_ut_cd");
				measUtCd = sheetObjects[0].CellValue(i, "meas_ut_cd");
				continue;
			}
			
			if( sheetObjects[0].RowStatus(i) != "D" ){
		
				
				if (wgtUtCd != sheetObjects[0].CellValue(i, "wgt_ut_cd")){
					wgtUtCdChk = false;
				}
				if (measUtCd != sheetObjects[0].CellValue(i, "meas_ut_cd")){
					measUtCdChk = false;
				}	
			}
		}	
	}

	if( !(wgtUtCdChk && measUtCdChk) ){
		ComShowMessage(ComGetMsg("BKG02084"));
		return false;
	}
	return true;
}