﻿/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0229_10.js
 *@FileTitle : e-Booking & SI Process Detail(HBL 1)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.15
 *@LastModifier : 전용진
 *@LastVersion : 1.0
 * 2009.06.15 전용진
 * 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2011.02.08 김영철 [CHM-201007612-01] eBooking HBL 화면에서 SEQ 값을 MAX로 가지고 오도록 로직 수정함.
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
 * @class esm_bkg_0229_10 : esm_bkg_0229_10 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0229_10() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject 	= setSheetObject;
	this.loadPage 			= loadPage;
	this.initSheet 			= initSheet;
	this.initControl 		= initControl;
	this.doActionIBSheet 	= doActionIBSheet;
	this.validateForm 		= validateForm;
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

var sheet1ColCount = 0;
var sheet2ColCount = 0;
var sheet3ColCount = 0;

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
			top.isCopyAllRequested = false;
			ComBtnColor("btn_cancelcopydata", "blue");
			ComBtnColor("btn_datacopytoalps", "#737373");	
			break;

		case "btn_datacopytoalps":
			if (isCopy == "false") {
				dataCopy();
			}
			break;
		case "btn_package":
			comBkgCallPop0696("callbackPckTp", formObject.pck_tp_cd.value);
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
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	initControl();
}

function initControl() {
 	var formObject = document.form;
 	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
 	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject);
	axon_event.addListenerForm  ("change", "form_onChange", formObject);
 	axon_event.addListenerForm('blur', 'form1_blur', formObject);

	applyShortcut();
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

			var HeadTitle1 = "ibflag|xter_si_no|xter_si_seq|hbl_no|hbl_seq|shpr_nm|shpr_addr|cnee_nm|cnee_addr|noti_nm|noti_addr|hbl_wgt|wgt_ut_cd|pck_qty|pck_tp_cd|cmdt_meas_qty|cmdt_meas_ut_cd|bl_mk_desc|bl_gds_desc|bkg_no";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(false, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle1, true);
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			var prefix = "sheet1_";
			sheetObj.InitDataProperty(0, cnt++, dtStatus,100, daLeft, true, "ibflag");
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "xter_si_no", 		false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "xter_si_seq", 		false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "hbl_no", 			false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "hbl_seq", 			false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "shpr_nm", 			false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "shpr_addr", 		false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "cnee_nm", 			false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "cnee_addr", 		false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "noti_nm", 			false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "noti_addr", 		false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "hbl_wgt", 			false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "wgt_ut_cd", 		false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "pck_qty", 			false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "pck_tp_cd", 		false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "cmdt_meas_qty", 	false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "cmdt_meas_ut_cd", 	false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "bl_mk_desc", 		false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "bl_gds_desc", 		false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, false,"bkg_no");

			sheet1ColCount = cnt;
			sheetObj.CountPosition = 0;
		//}
		break;

	case "sheet2":
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

			var HeadTitle1 = "ibflag|xter_si_no|xter_si_seq|hbl_no|hbl_seq|shpr_nm|shpr_addr|cnee_nm|cnee_addr|noti_nm|noti_addr|hbl_wgt|wgt_ut_cd|pck_qty|pck_tp_cd|cmdt_meas_qty|cmdt_meas_ut_cd|bl_mk_desc|bl_gds_desc|bkg_no";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(false, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			var prefix = "sheet2_";
			sheetObj.InitDataProperty(0, cnt++, dtStatus,100, daLeft, true, "ibflag");
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "xter_si_no",		false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "xter_si_seq", 		false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "hbl_no", 			false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "hbl_seq", 			false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "shpr_nm", 			false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "shpr_addr", 		false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "cnee_nm", 			false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "cnee_addr", 		false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "noti_nm", 			false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "noti_addr", 		false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "hbl_wgt", 			false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "wgt_ut_cd", 		false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "pck_qty", 			false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "pck_tp_cd", 		false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "cmdt_meas_qty", 	false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "cmdt_meas_ut_cd", 	false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "bl_mk_desc", 		false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, true, "bl_gds_desc", 		false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	100, daLeft, false,"bkg_no");
			sheetObj.CountPosition = 0;

			sheet2ColCount = cnt;
		//}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = 1;
	switch (sAction) {
	case IBSEARCH_ASYNC01: // 조회
		parent.tabObjects[0].TabBackColor(10) = "#96c792";
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);		
		break;

	case IBSEARCH: // 조회
		if (formObj.bkg_no.value != null && formObj.bkg_no.value != '') {
			var sXml = formObj.sXml.value;
			var arrXml = sXml.split("|$$|");
			
			// wgt_ut_cd
			if (arrXml.length > 0) ComBkgXml2ComboItem(arrXml[0], comboObjects[0], "val", "name");		
			// meas_ut_cd
			if (arrXml.length > 1) ComBkgXml2ComboItem(arrXml[1], comboObjects[1], "val", "name");
			for ( var i = 0; i < arrXml.length - 2; i++) {
				sheetObjects[i].Redraw = false;
				if (i > 0) {
					sheetObjects[i].WaitImageVisible = false;
				}
				sheetObjects[i].LoadSearchXml(arrXml[i + 2]);
				sheetObjects[i].Redraw = true;
			}
		}
		comboObjects[0].Code2 = sheetObjects[0].CellValue(1, "wgt_ut_cd");
		comboObjects[1].Code2 = sheetObjects[0].CellValue(1, "cmdt_meas_ut_cd");

		formObj.alps_seq.selectedIndex = 0;
		formObj.alps_seq.length = 0;
		formObj.xter_seq.length = 0;
		document.all.alps_seq_tot.innerHTML = "";
		document.all.xter_seq_tot.innerHTML = "";
		document.all.alps_seq_tot.innerHTML = sheetObjects[0].RowCount;
		document.all.xter_seq_tot.innerHTML = sheetObjects[1].RowCount;

		if (sheetObjects[0].RowCount > 0){
			formObj.hbl1_nis.value = "Y";
		}else{
			formObj.hbl1_nis.value = "N";
		}
		if (sheetObjects[1].RowCount > 0){
			formObj.hbl1_esvc.value = "Y";
		}else{
			formObj.hbl1_esvc.value = "N";
		}

		var obj = document.getElementById("alps_seq");
		for ( var i = 0; i < sheetObjects[0].RowCount; i++) {
			opt = document.createElement("option");
			opt.value = i + 1;
			opt.text = i + 1;
			obj.add(opt);
		}
		var obj2 = document.getElementById("xter_seq");
		for ( var j = 0; j < sheetObjects[1].RowCount; j++) {
			opt2 = document.createElement("option");
			opt2.value = j + 1;
			opt2.text = j + 1;
			obj2.add(opt2);
		}

		if (sheetObjects[0].RowCount > 0) {
			var prefix = "sheet1_";
			formObj.xter_si_no1.value 		= sheetObjects[0].CellValue(1, "xter_si_no");
			formObj.hbl_no.value 			= sheetObjects[0].CellValue(1, "hbl_no");
			formObj.shpr_nm.value 			= sheetObjects[0].CellValue(1, "shpr_nm");
			formObj.shpr_addr.value 		= sheetObjects[0].CellValue(1, "shpr_addr");
			formObj.cnee_nm.value 			= sheetObjects[0].CellValue(1, "cnee_nm");
			formObj.cnee_addr.value 		= sheetObjects[0].CellValue(1, "cnee_addr");
			formObj.noti_nm.value 			= sheetObjects[0].CellValue(1, "noti_nm");
			formObj.noti_addr.value 		= sheetObjects[0].CellValue(1, "noti_addr");
			formObj.hbl_wgt.value 			= ComAddComma3(sheetObjects[0].CellValue(1, "hbl_wgt"), "#,###.000");
			formObj.wgt_ut_cd.value 		= sheetObjects[0].CellValue(1, "wgt_ut_cd");
			formObj.pck_qty.value 			= sheetObjects[0].CellValue(1, "pck_qty");
			formObj.pck_tp_cd.value 		= sheetObjects[0].CellValue(1, "pck_tp_cd");
			formObj.cmdt_meas_qty.value 	= ComAddComma3(sheetObjects[0].CellValue(1, "cmdt_meas_qty"), "#,###.000");
			formObj.cmdt_meas_ut_cd.value 	= sheetObjects[0].CellValue(1, "cmdt_meas_ut_cd");
			formObj.bl_mk_desc.value 		= sheetObjects[0].CellValue(1, "bl_mk_desc");
			formObj.bl_gds_desc.value 		= sheetObjects[0].CellValue(1, "bl_gds_desc");
		} else {
			formObj.xter_si_no1.value 		= '';
			formObj.hbl_no.value 			= '';
			formObj.shpr_nm.value 			= '';
			formObj.shpr_addr.value 		= '';
			formObj.cnee_nm.value 			= '';
			formObj.cnee_addr.value 		= '';
			formObj.noti_nm.value 			= '';
			formObj.noti_addr.value 		= '';
			formObj.hbl_wgt.value 			= '';
			formObj.wgt_ut_cd.value 		= '';
			formObj.pck_qty.value 			= '';
			formObj.pck_tp_cd.value 		= '';
			formObj.cmdt_meas_qty.value 	= '';
			formObj.cmdt_meas_ut_cd.value 	= '';
			formObj.bl_mk_desc.value 		= '';
			formObj.bl_gds_desc.value 		= '';
		}
		if (sheetObjects[1].RowCount > 0) {
			var prefix = "sheet2_";
			sheetObjects[1].CellValue2(1, "hbl_wgt") 		= ComAddComma3(sheetObjects[1].CellValue(1, "hbl_wgt"), "#,###.000");
			sheetObjects[1].CellValue2(1, "cmdt_meas_qty") 	= ComAddComma3(sheetObjects[1].CellValue(1, "cmdt_meas_qty"), "#,###.000");
			formObj.xter_si_no2.value 		= sheetObjects[1].CellValue(1, "xter_si_no");
			formObj.hbl_no2.value 			= sheetObjects[1].CellValue(1, "hbl_no");
			formObj.shpr_nm2.value 			= sheetObjects[1].CellValue(1, "shpr_nm");
			formObj.shpr_addr2.value 		= sheetObjects[1].CellValue(1, "shpr_addr");
			formObj.cnee_nm2.value 			= sheetObjects[1].CellValue(1, "cnee_nm");
			formObj.cnee_addr2.value 		= sheetObjects[1].CellValue(1, "cnee_addr");
			formObj.noti_nm2.value 			= sheetObjects[1].CellValue(1, "noti_nm");
			formObj.noti_addr2.value 		= sheetObjects[1].CellValue(1, "noti_addr");
			formObj.hbl_wgt2.value 			= sheetObjects[1].CellValue(1, "hbl_wgt");
			formObj.wgt_ut_cd2.value 		= sheetObjects[1].CellValue(1, "wgt_ut_cd");
			formObj.pck_qty2.value 			= sheetObjects[1].CellValue(1, "pck_qty");
			formObj.pck_tp_cd2.value 		= sheetObjects[1].CellValue(1, "pck_tp_cd");
			formObj.cmdt_meas_qty2.value 	= sheetObjects[1].CellValue(1, "cmdt_meas_qty");
			formObj.cmdt_meas_ut_cd2.value 	= sheetObjects[1].CellValue(1, "cmdt_meas_ut_cd");
			formObj.bl_mk_desc2.value 		= sheetObjects[1].CellValue(1, "bl_mk_desc");
			formObj.bl_gds_desc2.value 		= sheetObjects[1].CellValue(1, "bl_gds_desc");

		}
		isCopy = "false";
		if(top.document.form.tabload10.value == "COPY"){
			dataCopy();
		}

		if (parent.frames("t1frame").document.form) {
			parent.frames("t1frame").document.form.hbl_knt2.value = sheetObjects[1].Rows - 1;
		}
		top.document.form.tabload10.value = "LOAD";
		compareItem();
		break;

	case IBSEARCH_ASYNC02: // Data Copy
		//null로 update하지 않는다.
		parent.tabObjects[0].TabBackColor(10) = "#fff270";

		var sheet1HblSeq = 0;
		var sheet2HblSeq = 0;
		var newRow = 0;

		for ( var i = 1; i < sheetObjects[1].Rows; i++) {
			sheet1HblSeq = 0;
			sheet2HblSeq = 0;
			for ( var j = 1; j < sheetObjects[0].Rows; j++) {
				if ( sheetObjects[0].RowCount > 0 ) {
					if ( sheetObjects[0].CellValue(i, "hbl_no") == sheetObjects[1].CellValue(j, "hbl_no") ) {
						sheet2HblSeq = i;
						sheet1HblSeq = j;
					}
				}
			}
			if(sheet1HblSeq == 0 && sheet1HblSeq == 0){
				newRow = sheetObjects[0].DataInsert(-1);
				for ( var j = 0; j < sheet1ColCount; j++) {
					if (sheetObjects[1].ColSaveName(j) == "ibflag") {
						continue;
					}
					var hblMaxSeq = 0;
					
					if (sheetObjects[1].ColSaveName(j) == "hbl_seq") {
						for( var k = 1; k < sheetObjects[0].RowCount; k++){
							if( k == 0 ){
								hblMaxSeq = eval(sheetObjects[0].CellValue(k, j));
							} else if ( eval(hblMaxSeq) < eval(sheetObjects[0].CellValue(k, j))){
								hblMaxSeq = sheetObjects[0].CellValue(k, j);
							}							
						}
						sheetObjects[0].CellValue2(newRow, j) = eval(hblMaxSeq)+1;
					} else if(!ComIsNull(sheetObjects[1].CellValue(i, j))){
						sheetObjects[0].CellValue2(newRow, j) = sheetObjects[1].CellValue(i, j);
					}
				}
			} else {
				for ( var j = 0; j < sheet1ColCount; j++) {
					if (sheetObjects[1].ColSaveName(j) == "ibflag") {
						if (sheetObjects[0].CellValue(sheet1HblSeq, j) == 'I') {
							continue;
						} else {
							sheetObjects[0].RowStatus(sheet1HblSeq) = 'U';
						}
					}
					if(!ComIsNull(sheetObjects[1].CellValue(sheet2HblSeq, j))){
						sheetObjects[0].CellValue(sheet1HblSeq, j) = sheetObjects[1].CellValue(sheet2HblSeq, j);
					}
				}
			}
				
		}

		if (sheetObjects[0].RowCount > 0) {
			sheet1HblSeq.selectedIndex = 0;
			sheet1HblSeq.length = 0;
			var oldSeq = document.all.alps_seq_tot.innerHTML;
			document.all.alps_seq_tot.innerHTML = sheetObjects[0].RowCount;
			if (sheetObjects[0].RowCount > 0){
				formObj.hbl1_nis.value = "Y";
			}else{
				formObj.hbl1_nis.value = "N";
			}
			
//			if ( oldSeq == 0 ){
//				oldSeq = 1;
//			}
			
			var obj = document.getElementById("alps_seq");
			for ( var i = parseInt(oldSeq); i < sheetObjects[0].RowCount; i++) {
				opt = document.createElement("option");
				opt.value = i + 1;
				opt.text = i + 1;
				obj.add(opt);
			}
			change_seq("sheet1", obj);
		}
		isCopy = "true";
		compareItem()
		break;

	case IBSAVE: // Upload		
		doHBLSaveCopy();

		if(validateForm(sheetObj, formObj, sAction)==false){
			return false;
		}
		var params = getSaveStringForUpload();
		var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0229_10GS.do", params);
		
		if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") != "S") {
			sheetObj.LoadSaveXml(sXml);
		}
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		//mandatory validation 없음
	}

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
//	alert("validateForUplaod in ESM_BKG_0229_10.js");
	return true;
}

/**
 * 전체 Upload 버튼 CLICK시 호출 됨
 * TAB에 상관 없이 동일 이름의 함수를 가짐
 * 내용은 TAB에 맞게 구현
 * 각 화면에서 Upload 버튼이 눌렸을 때 SC에 parameter 로 던지는 QueryString을 만들어 return
 */
function getSaveStringForUpload() {
	if(sheetObjects[0].Rows<=1) return "";	
		
	var formObj = document.form;
	var params = "";

	doHBLSaveCopy();
	/* Unmask: 문자형이 숫자형으로 바뀔 수 있도록, 콤마 등에 Separator를 제거 함 */
	for(var i=1;i<sheetObjects[0].Rows;i++){
		sheetObjects[0].CellValue2(i, "pck_qty") = ComTrimAll(sheetObjects[0].CellValue(i, "pck_qty"), ",");
		sheetObjects[0].CellValue2(i, "hbl_wgt") = ComTrimAll(sheetObjects[0].CellValue(i, "hbl_wgt"), ",");
		sheetObjects[0].CellValue2(i, "cmdt_meas_qty") = ComTrimAll(sheetObjects[0].CellValue(i, "cmdt_meas_qty"), ",");
	}

 	var sXml = formObj.sXml.value;
	formObj.sXml.value = null;
	
	formObj.f_cmd.value = MULTI;
	params = FormQueryString(formObj);
	formObj.sXml.value = sXml;
	// AMS Filer US, CA 둘중에 하나라도 '1'인 경우에만 저장하도록 함. ( 이정희 차장님 요청 - 2010.05.27 - YC KIM )
  	if (sheetObjects[0].RowCount > 0 && ( ComGetObjValue(parent.frames("t1frame").document.form.usa_cstms_file_cd) == '1' || ComGetObjValue(parent.frames("t1frame").document.form.cnd_cstms_file_cd) == '1' )) {
//	if (sheetObjects[0].RowCount > 0 ){
  		params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true), "sheet1_");	
  	} else {
  		params = "";
  	}		
	return params;
}
 
function dataCopy() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	ComBtnColor("btn_cancelcopydata", "#737373");
	ComBtnColor("btn_datacopytoalps", "blue");	
}

//색 비교 처리
function compareItem() {
	var formObj = document.form;
	setDiffCheckColor(formObj.xter_si_no1.value,    formObj.xter_si_no2.value, 		'xter_si_no2');
	setDiffCheckColor(formObj.hbl_no.value,     	formObj.hbl_no2.value, 			'hbl_no2');
	setDiffCheckColor(formObj.shpr_nm.value,     	formObj.shpr_nm2.value, 		'shpr_nm2');
	setDiffCheckColor(formObj.shpr_addr.value,     	formObj.shpr_addr2.value, 		'shpr_addr2');
	setDiffCheckColor(formObj.cnee_nm.value,     	formObj.cnee_nm2.value, 		'cnee_nm2');
	setDiffCheckColor(formObj.cnee_addr.value,     	formObj.cnee_addr2.value, 		'cnee_addr2');
	setDiffCheckColor(formObj.noti_nm.value,     	formObj.noti_nm2.value, 		'noti_nm2');
	setDiffCheckColor(formObj.noti_addr.value,     	formObj.noti_addr2.value, 		'noti_addr2');
	setDiffCheckColor(formObj.hbl_wgt.value,     	formObj.hbl_wgt2.value, 		'hbl_wgt2');
	setDiffCheckColor(formObj.wgt_ut_cd.value,     	formObj.wgt_ut_cd2.value, 		'wgt_ut_cd2');
	setDiffCheckColor(formObj.pck_qty.value,     	formObj.pck_qty2.value, 		'pck_qty2');
	setDiffCheckColor(formObj.pck_tp_cd.value,     	formObj.pck_tp_cd2.value, 		'pck_tp_cd2');
	setDiffCheckColor(formObj.cmdt_meas_qty.value,  formObj.cmdt_meas_qty2.value, 	'cmdt_meas_qty2');
	setDiffCheckColor(formObj.cmdt_meas_ut_cd.value,formObj.cmdt_meas_ut_cd2.value, 'cmdt_meas_ut_cd2');
	setDiffCheckColor(formObj.bl_mk_desc.value,     formObj.bl_mk_desc2.value, 		'bl_mk_desc2');
	setDiffCheckColor(formObj.bl_gds_desc.value,    formObj.bl_gds_desc2.value, 	'bl_gds_desc2');
}

//HBL 리스트를 저장용 sheet로 Copy
function doHBLSaveCopy() {	
	var formObj = document.form;
	
	var seq=ComGetObjValue(formObj.alps_seq);
	if (seq != '' ) {
		sheetObjects[0].CellValue(seq, "xter_si_no") 		= formObj.xter_si_no1.value;		
		sheetObjects[0].CellValue(seq, "hbl_no") 			= formObj.hbl_no.value;
		sheetObjects[0].CellValue(seq, "shpr_nm") 			= formObj.shpr_nm.value;
		sheetObjects[0].CellValue(seq, "shpr_addr") 		= formObj.shpr_addr.value;
		sheetObjects[0].CellValue(seq, "cnee_nm") 			= formObj.cnee_nm.value;
		sheetObjects[0].CellValue(seq, "cnee_addr") 		= formObj.cnee_addr.value;
		sheetObjects[0].CellValue(seq, "noti_nm") 			= formObj.noti_nm.value;
		sheetObjects[0].CellValue(seq, "noti_addr") 		= formObj.noti_addr.value;
		sheetObjects[0].CellValue(seq, "hbl_wgt") 			= formObj.hbl_wgt.value;
		sheetObjects[0].CellValue(seq, "wgt_ut_cd") 		= formObj.wgt_ut_cd.value;
		sheetObjects[0].CellValue(seq, "pck_qty") 			= formObj.pck_qty.value;
		sheetObjects[0].CellValue(seq, "pck_tp_cd") 		= formObj.pck_tp_cd.value;
		sheetObjects[0].CellValue(seq, "cmdt_meas_qty") 	= formObj.cmdt_meas_qty.value;
		sheetObjects[0].CellValue(seq, "cmdt_meas_ut_cd") 	= formObj.cmdt_meas_ut_cd.value;
		sheetObjects[0].CellValue(seq, "bl_mk_desc") 		= formObj.bl_mk_desc.value;
		sheetObjects[0].CellValue(seq, "bl_gds_desc") 		= formObj.bl_gds_desc.value;
	}	
}

function form_onChange(){
	var srcName = window.event.srcElement.getAttribute("name");
	var formObj = document.form;
	switch (srcName) {
		
	}
	isCopy = "false";
	compareItem();
}

function form1_blur() {
	ComChkObjValid(event.srcElement);
}

//form에서 sheet로 넣는다.
function click_seq(obj) {
	var formObj = document.form;
	var prefix = "sheet3_";
	if (sheetObjects[0].RowCount > 0) {
		sheetObjects[0].CellValue(obj.value, "xter_si_no") 		= formObj.xter_si_no1.value;
		sheetObjects[0].CellValue(obj.value, "hbl_no") 			= formObj.hbl_no.value;
		sheetObjects[0].CellValue(obj.value, "shpr_nm") 		= formObj.shpr_nm.value;
		sheetObjects[0].CellValue(obj.value, "shpr_addr") 		= formObj.shpr_addr.value;
		sheetObjects[0].CellValue(obj.value, "cnee_nm") 		= formObj.cnee_nm.value;
		sheetObjects[0].CellValue(obj.value, "cnee_addr") 		= formObj.cnee_addr.value;
		sheetObjects[0].CellValue(obj.value, "noti_nm") 		= formObj.noti_nm.value;
		sheetObjects[0].CellValue(obj.value, "noti_addr") 		= formObj.noti_addr.value;
		sheetObjects[0].CellValue(obj.value, "hbl_wgt") 		= formObj.hbl_wgt.value;
		sheetObjects[0].CellValue(obj.value, "wgt_ut_cd") 		= formObj.wgt_ut_cd.value;
		sheetObjects[0].CellValue(obj.value, "pck_qty") 		= formObj.pck_qty.value;
		sheetObjects[0].CellValue(obj.value, "pck_tp_cd") 		= formObj.pck_tp_cd.value;
		sheetObjects[0].CellValue(obj.value, "cmdt_meas_qty") 	= formObj.cmdt_meas_qty.value;
		sheetObjects[0].CellValue(obj.value, "cmdt_meas_ut_cd") = formObj.cmdt_meas_ut_cd.value;
		sheetObjects[0].CellValue(obj.value, "bl_mk_desc") 		= formObj.bl_mk_desc.value;
		sheetObjects[0].CellValue(obj.value, "bl_gds_desc") 	= formObj.bl_gds_desc.value;
	}
}

//sheet에서 form으로 가져온다
function change_seq(sheet, obj) {
	var formObj = document.form;
	var prefix = "";
	var postfix = "";
	var rqstfix = ""
	var cn = 0;
	if (sheet == "sheet1") {
		prefix = "sheet1_";
		postfix = "";
		rqstfix = "1"
		cn = 0;
	} else {
		prefix = "sheet2_";
		postfix = "2";
		cn = 1;
	}

	eval("formObj.xter_si_no" 		+ postfix + rqstfix ).value = sheetObjects[cn].CellValue(obj.value, "xter_si_no");
	eval("formObj.hbl_no" 			+ postfix).value = sheetObjects[cn].CellValue(obj.value, "hbl_no");
	eval("formObj.shpr_nm" 			+ postfix).value = sheetObjects[cn].CellValue(obj.value, "shpr_nm");
	eval("formObj.shpr_addr" 		+ postfix).value = sheetObjects[cn].CellValue(obj.value, "shpr_addr");
	eval("formObj.cnee_nm" 			+ postfix).value = sheetObjects[cn].CellValue(obj.value, "cnee_nm");
	eval("formObj.cnee_addr" 		+ postfix).value = sheetObjects[cn].CellValue(obj.value, "cnee_addr");
	eval("formObj.noti_nm" 			+ postfix).value = sheetObjects[cn].CellValue(obj.value, "noti_nm");
	eval("formObj.noti_addr" 		+ postfix).value = sheetObjects[cn].CellValue(obj.value, "noti_addr");
	eval("formObj.hbl_wgt" 			+ postfix).value = ComAddComma3(sheetObjects[cn].CellValue(obj.value, "hbl_wgt"), "#,###.000");
	eval("formObj.wgt_ut_cd" 		+ postfix).value = sheetObjects[cn].CellValue(obj.value, "wgt_ut_cd");
	eval("formObj.pck_qty" 			+ postfix).value = sheetObjects[cn].CellValue(obj.value, "pck_qty");
	eval("formObj.pck_tp_cd" 		+ postfix).value = sheetObjects[cn].CellValue(obj.value, "pck_tp_cd");
	eval("formObj.cmdt_meas_qty" 	+ postfix).value = ComAddComma3(sheetObjects[cn].CellValue(obj.value, "cmdt_meas_qty"), "#,###.000");
	eval("formObj.cmdt_meas_ut_cd" 	+ postfix).value = sheetObjects[cn].CellValue(obj.value, "cmdt_meas_ut_cd");
	eval("formObj.bl_mk_desc" 		+ postfix).value = sheetObjects[cn].CellValue(obj.value, "bl_mk_desc");
	eval("formObj.bl_gds_desc" 		+ postfix).value = sheetObjects[cn].CellValue(obj.value, "bl_gds_desc");
	

	if (sheet == "sheet1") {
		comboObjects[0].Code2 = sheetObjects[cn].CellValue(obj.value, "wgt_ut_cd");
		comboObjects[1].Code2 = sheetObjects[cn].CellValue(obj.value, "cmdt_meas_ut_cd");
	}
}

function wgt_ut_cd_OnChange(comboObj, value, text) {
	var formObj = document.form;
	setDiffCheckColor(text, formObj.wgt_ut_cd2.value, ("wgt_ut_cd2"));
}

function cmdt_meas_ut_cd_OnChange(comboObj, value, text) {
	var formObj = document.form;
	setDiffCheckColor(text, formObj.cmdt_meas_ut_cd2.value, ("cmdt_meas_ut_cd2"));
}
function setCallBack0696(aryPopupData) {
	var formObj = document.form;
	formObj.pck_tp_cd.value = aryPopupData[0][3];
}

function callbackPckTp(returnVal){
	document.form.pck_tp_cd.value = returnVal[0][3];
//	document.form.pck_nm.value = returnVal[0][3];
}