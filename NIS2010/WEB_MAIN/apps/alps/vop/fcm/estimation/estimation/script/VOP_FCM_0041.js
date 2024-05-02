/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : VOP_FCM_0041.js
 *@FileTitle : Monthly Estimation Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.04
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.10.04 유혁
 * 1.0 Creation
 * 
 * History
 * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
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
 * @class VOP_FCM_0041 : VOP_FCM_0041 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0041() {
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
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObj = getSheet("sheet2");

	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			sheetObj = getSheet("sheet3");
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			sheetControl(sheetObj.id);
			buttonControl(sheetObj.id);
			break;
			
		case "btn_Load":
			doActionIBSheet(sheetObj, formObj, SEARCH01);
			sheetControl(sheetObj.id);
			buttonControl(sheetObj.id);
			break;
			
		case "btn_New":
			doActionIBSheet(sheetObj, formObj, IBCLEAR);
			buttonControl(sheetObj.id);
			break;
			
		case "btn_Save":
			doActionIBSheet(sheetObj, formObj, IBSAVE);
			break;

		case "btn_ROBEMList":
			var exeYrmon = document.form.exe_yrmon.value;
			if(exeYrmon){
				exeYrmon = exeYrmon.replace("-", "");
				var sUrl = "VOP_FCM_0044.do?rev_yrmon=" + exeYrmon; // TODO exe_yrmon? rev_yrmon?
				var rVal = ComOpenPopupWithTarget(sUrl, 896, 410, "", "0,0", true);
			}
			break;
		case "btns_calendarfm":
			var cal = new ComCalendar();
			cal.setDisplayType("month");
			cal.select(formObj.exe_yrmon, 'yyyy-MM');
			break;	
		case "btn_Creation":
			doActionIBSheet(sheetObj, formObj, SEARCH02);
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
	document.form.exe_yrmon.value = ComGetDateAdd(null, "M", -1).substr(0,7);
	document.form.exe_yrmon.focus();
	buttonControl();
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
	axon_event.addListenerForm("deactivate", "obj_deactivate", formObj);
	axon_event.addListenerForm("keyup", "obj_keyup", formObj);
	axon_event.addListener("keypress", "obj_keypress", "exe_yrmon");

}

function obj_keyup() {
	if(event.keyCode==13){
		document.getElementById("btn_Retrieve").fireEvent("onclick");
	}
}

function obj_activate() {
	var srcName = event.srcElement.name;
	switch(srcName){
	case "exe_yrmon":
		ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기
		event.srcElement.select();
		break;
	}
}

function obj_deactivate() {
	var formObj = document.form;
	var srcName = event.srcElement.name;
	switch(srcName){
	case "exe_yrmon":
		formObj.exe_yrmon.value = ComGetMaskedValue(formObj.exe_yrmon.value, "ym");
		break;
	}
}

/**
 * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function obj_keypress() {
	var obj = event.srcElement;
	switch (obj.name) {
	case "exe_yrmon":
		ComKeyOnlyNumber(obj);
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
	var prefix = "";
	sheetObj.prefix = prefix;

	switch (sheetObj.id) {
	case "sheet1": // request sheet
		with (sheetObj) {
			
			// 높이 설정
			style.height = 0;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
			
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);
	
			var HeadTitle = "req|res";
			var headCount = ComCountHeadTitle(HeadTitle);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle);
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,		500,	daLeftTop,	true,	"req");
			InitDataProperty(0, cnt++ , dtData,		0,		daLeftTop,	true,	"res");
			WaitImageVisible = false;
			
			DataInsert(-1);
			CountPosition = 0;
		}
		break;

	case "sheet2": // sheet2
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 0;
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
			InitRowInfo(3, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, true, false, false, false)

//			var HeadTitle = "|Sel.|SEQ|Rev.\nMonth|Rev.\nLane|Vsl\nCD|Voy\nNo.|Dir\nCD|Rev.\nDir\nCD|Item|VVD\nType|Crr\nCD|TC\nOUT|Error\n(Y/N)|Design\nCapacity|Trend\nLine Type|Start|Start|End|End|FO|FO|FO|DO|DO|DO|Creation\nID|Creation\nDate";
//			var HeadTitle2 = "||SEQ|Rev.\nMonth|Rev.\nLane|Vsl\nCD|Voy\nNo.|Dir\nCD|Rev.\nDir\nCD|Item|VVD\nType|Crr\nCD|TC\nOUT|Error\n(Y/N)|Design\nCapacity|Trend\nLine Type|Port|Date|Port|Date|Voyage\nEnd|Month\nEnd|Estimation|Voyage\nEnd|Month\nEnd|Estimation|Creation\nID|Creation\nDate";
			
			var HeadTitle = "||SEQ|Estm\nSeq|exe_yrmon|Rev.\nMonth|Rev.\nLane|Vsl\nCD|Voy\nNo.|Dir\nCD|Rev.\nDir\nCD|Item|VVD\nType|Pre\nVVD\nType|Crr\nCD|TC\nOUT|Error\n(Y/N)|Item\nError|Design\nCapacity|Trend Line Seq.|Trend Line No.|Start|Start|Start|Start|End|End|End|End";
			HeadTitle += "|Beginning\nOn-Hand|Prev. VVD\nOn-Hand|PO RCV|BOD|BOR|Sea Days|Sea Days|Port Days|Port Days";
			HeadTitle += "|Voyage End|Voyage End|Month End|Month End|Estimation\nCSM";
			
			var HeadTitle2 = "||SEQ|Estm\nSeq|exe_yrmon|Rev.\nMonth|Rev.\nLane|Vsl\nCD|Voy\nNo.|Dir\nCD|Rev.\nDir\nCD|Item|VVD\nType|Pre\nVVD\nType|Crr\nCD|TC\nOUT|Error\n(Y/N)|Item\nError|Design\nCapacity|Trend Line Seq.|Trend Line No.|ALPS|ALPS|ERP|ERP|ALPS|ALPS|ERP|ERP";
			HeadTitle2 += "|Beginning\nOn-Hand|Prev. VVD\nOn-Hand|PO RCV|BOD|BOR|VOY|EST|VOY|EST"; 
			HeadTitle2 += "|RMN|CSM|RMN|CSM|Estimation\nCSM";
			
			var HeadTitle3 = "||SEQ|Estm\nSeq|exe_yrmon|Rev.\nMonth|Rev.\nLane|Vsl\nCD|Voy\nNo.|Dir\nCD|Rev.\nDir\nCD|Item|VVD\nType|Pre\nVVD\nType|Crr\nCD|TC\nOUT|Error\n(Y/N)|Item\nError|Design\nCapacity|Trend Line Seq.|Trend Line No.|Port|Date|Port|Date|Port|Date|Port|Date";
			HeadTitle3 += "|Beginning\nOn-Hand|Prev. VVD\nOn-Hand|PO RCV|BOD|BOR|VOY|EST|VOY|EST"; 
			HeadTitle3 += "|RMN|CSM|RMN|CSM|Estimation\nCSM";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
//			sheetObj.FrozenCols = 4;

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle2, true);
			InitHeadRow(2, HeadTitle3, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtStatus,	35,		daCenter,	true,	prefix+"ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		20,		daCenter,	true,	prefix+"Sel");
			InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,	true,	prefix+"seq",				false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	prefix+"estm_seq",			false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"exe_yrmon",			false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"rev_yrmon",			false,	"",		dfDateYm,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"rlane_cd",			false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"vsl_cd",			false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"skd_voy_no",		false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix+"skd_dir_cd",		false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix+"rev_dir_cd",		false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"csm_oil_tp_cd",		false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"estm_vvd_tp_cd",	false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"pre_estm_vvd_tp_cd",false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"crr_cd",			false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"to_flg",			false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"err_flg",			false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"itm_err",			false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix+"cntr_dzn_capa",		false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,		60, 	daCenter,   true,   prefix+"trnd_line_seq",		false,  "",     dfNone,	        0,          false,      false);
			InitDataProperty(0, cnt++ , dtPopup,		130,	daCenter,	true,	prefix+"trnd_line_no",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	prefix+"act_st_port_cd",	false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix+"act_st_dt",			false,	"",		dfDateYmd,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	prefix+"tmp_st_port_cd",	false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix+"tmp_st_dt",			false,	"",		dfDateYmd,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	prefix+"act_end_port_cd",	false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix+"act_end_dt",		false,	"",		dfDateYmd,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	prefix+"tmp_end_port_cd",	false,	"",		dfNone,			0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix+"tmp_end_dt",		false,	"",		dfDateYmd,		0,			false,		true);
			
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"mon_bgn_invt_wgt",	false,	"",		dfNullFloat,	-1,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"pre_vvd_invt_wgt",	false,	"",		dfNullFloat,	-1,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"po_rcv_wgt",		false,	"",		dfNullFloat,	-1,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"bod_wgt",			false,	"",		dfNullFloat,	-1,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"bor_wgt",			false,	"",		dfNullFloat,	-1,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"voy_sea_dys",		false,	"",		dfNullFloat,	-1,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"estm_sea_dys",		false,	"",		dfNullFloat,	-1,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"voy_port_dys",		false,	"",		dfNullFloat,	-1,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"estm_port_dys",		false,	"",		dfNullFloat,	-1,			false,		true);
			
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"voy_end_rmn_wgt",	false,	"",		dfNullFloat,	-1,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"voy_end_csm_wgt",	false,	"",		dfNullFloat,	-1,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"mon_end_rmn_wgt",	false,	"",		dfNullFloat,	-1,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"mon_end_csm_wgt",	false,	"",		dfNullFloat,	-1,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"estm_mon_csm_wgt",	false,	"",		dfNullFloat,	-1,			false,		true);
			
			CountPosition = 2;
			
			InitViewFormat(0, prefix+"rev_yrmon", "yyyy-mm");
//			InitDataCombo(0, prefix+"to_flg", "Y|N", "Y|N");
//			InitUserFormat(0, prefix+"act_st_dt", "####-##-##", "-");
//			InitUserFormat(0, prefix+"tmp_st_dt", "####-##-##", "-");
//			InitUserFormat(0, prefix+"act_end_dt", "####-##-##", "- ");
//			InitUserFormat(0, prefix+"tmp_end_dt", "####-##-##", "-");
			
			WaitImageVisible = false;
			SelectBackColor = RgbColor(255,255,192);
			SelectFontColor = RgbColor(255,255,192);
			
			RowHeight(0) = 20;
			RowHeight(1) = 20;
			RowHeight(2) = 20;
			SetMergeCell(0, 1, 3, 1);
		}
		break;
		
	case "sheet3": // sheet3
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
			InitHeadMode(false, false, true, false, false, false)

//			var HeadTitle = "|Sel.|SEQ|Rev.\nMonth|Rev.\nLane|Vsl\nCD|Voy\nNo.|Dir\nCD|Rev.\nDir\nCD|Item|VVD\nType|Crr\nCD|TC\nOUT|Error\n(Y/N)|Design\nCapacity|Trend\nLine Type|Start|Start|End|End|FO|FO|FO|DO|DO|DO|Creation\nID|Creation\nDate";
//			var HeadTitle2 = "||SEQ|Rev.\nMonth|Rev.\nLane|Vsl\nCD|Voy\nNo.|Dir\nCD|Rev.\nDir\nCD|Item|VVD\nType|Crr\nCD|TC\nOUT|Error\n(Y/N)|Design\nCapacity|Trend\nLine Type|Port|Date|Port|Date|Voyage\nEnd|Month\nEnd|Estimation|Voyage\nEnd|Month\nEnd|Estimation|Creation\nID|Creation\nDate";
			
			var HeadTitle = "|SEQ|Estm\nSeq|Rev.\nMonth|Rev.\nLane|Vsl\nCD|Voy\nNo.|Dir\nCD|Rev.\nDir\nCD|Item|VVD\nType|Pre\nVVD\nType|Crr\nCD|TC\nOUT|Error\n(Y/N)|Item\nError|Design\nCapacity|Trend Line Seq.|Trend Line No.|Start|Start|Start|Start|End|End|End|End";
			HeadTitle += "|Beginning\nOn-Hand|Prev. VVD\nOn-Hand|PO RCV|BOD|BOR|Sea Days|Sea Days|Port Days|Port Days";
			HeadTitle += "|Voyage End|Voyage End|Month End|Month End|Estimation\nConsumption|Creation\nID|Creation\nDate";
			
			var HeadTitle2 = "|SEQ|Estm\nSeq|Rev.\nMonth|Rev.\nLane|Vsl\nCD|Voy\nNo.|Dir\nCD|Rev.\nDir\nCD|Item|VVD\nType|Pre\nVVD\nType|Crr\nCD|TC\nOUT|Error\n(Y/N)|Item\nError|Design\nCapacity|Trend Line Seq.|Trend Line No.|ALPS|ALPS|ERP|ERP|ALPS|ALPS|ERP|ERP";
			HeadTitle2 += "|Beginning\nOn-Hand|Prev. VVD\nOn-Hand|PO RCV|BOD|BOR|VOY|EST|VOY|EST"; 
			HeadTitle2 += "|RMN|CSM|RMN|CSM|Estimate\nCSM|Creation\nID|Creation\nDate";
			
			var HeadTitle3 = "|SEQ|Estm\nSeq|Rev.\nMonth|Rev.\nLane|Vsl\nCD|Voy\nNo.|Dir\nCD|Rev.\nDir\nCD|Item|VVD\nType|Pre\nVVD\nType|Crr\nCD|TC\nOUT|Error\n(Y/N)|Item\nError|Design\nCapacity|Trend Line Seq.|Trend Line No.|Port|Date|Port|Date|Port|Date|Port|Date";
			HeadTitle3 += "|Beginning\nOn-Hand|Prev. VVD\nOn-Hand|PO RCV|BOD|BOR|VOY|EST|VOY|EST"; 
			HeadTitle3 += "|RMN|CSM|RMN|CSM|Estimate\nCSM|Creation\nID|Creation\nDate";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
//			sheetObj.FrozenCols = 4;

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle2, true);
			InitHeadRow(2, HeadTitle3, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	35,		daCenter,	true,	prefix+"ibflag");
			InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,	true,	prefix+"seq",				false,	"",		dfNone,			0);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	prefix+"estm_seq",			false,	"",		dfNone,			0);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"rev_yrmon",			false,	"",		dfDateYm,		0);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"rlane_cd",			false,	"",		dfNone,			0);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"vsl_cd",			false,	"",		dfNone,			0);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"skd_voy_no",		false,	"",		dfNone,			0);
			InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix+"skd_dir_cd",		false,	"",		dfNone,			0);
			InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix+"rev_dir_cd",		false,	"",		dfNone,			0);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"csm_oil_tp_cd",		false,	"",		dfNone,			0);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"estm_vvd_tp_cd",	false,	"",		dfNone,			0);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"pre_estm_vvd_tp_cd",false,	"",		dfNone,			0);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"crr_cd",			false,	"",		dfNone,			0);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"to_flg",			false,	"",		dfNone,			0);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"err_flg",			false,	"",		dfNone,			0);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"itm_err",			false,	"",		dfNone,			0);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix+"cntr_dzn_capa",		false,	"",		dfNone,			0);
			InitDataProperty(0, cnt++ , dtHidden,		60, 	daCenter,   true,   prefix+"trnd_line_seq",		false,  "",     dfNone,	        0);
			InitDataProperty(0, cnt++ , dtPopup,		130,	daCenter,	true,	prefix+"trnd_line_no",		false,	"",		dfNone,			0);
			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	prefix+"act_st_port_cd",	false,	"",		dfNone,			0);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix+"act_st_dt",			false,	"",		dfDateYmd,		0);
			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	prefix+"tmp_st_port_cd",	false,	"",		dfNone,			0);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix+"tmp_st_dt",			false,	"",		dfDateYmd,		0);
			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	prefix+"act_end_port_cd",	false,	"",		dfNone,			0);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix+"act_end_dt",		false,	"",		dfDateYmd,		0);
			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	prefix+"tmp_end_port_cd",	false,	"",		dfNone,			0);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix+"tmp_end_dt",		false,	"",		dfDateYmd,		0);
			
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"mon_bgn_invt_wgt",	false,	"",		dfNullFloat,	-1);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"pre_vvd_invt_wgt",	false,	"",		dfNullFloat,	-1);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"po_rcv_wgt",		false,	"",		dfNullFloat,	-1);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"bod_wgt",			false,	"",		dfNullFloat,	-1);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"bor_wgt",			false,	"",		dfNullFloat,	-1);
			InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"voy_sea_dys",		false,	"",		dfNullFloat,	-1);
			InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"estm_sea_dys",		false,	"",		dfNullFloat,	-1);
			InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"voy_port_dys",		false,	"",		dfNullFloat,	-1);
			InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"estm_port_dys",		false,	"",		dfNullFloat,	-1);
			
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"voy_end_rmn_wgt",	false,	"",		dfNullFloat,	-1);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"voy_end_csm_wgt",	false,	"",		dfNullFloat,	-1);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"mon_end_rmn_wgt",	false,	"",		dfNullFloat,	-1);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"mon_end_csm_wgt",	false,	"",		dfNullFloat,	-1);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"estm_mon_csm_wgt",	false,	"",		dfNullFloat,	-1);
			
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix+"cre_usr_id",		false,	"",		dfNone,			0);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix+"cre_dt",			false,	"",		dfDateYmd,		0);
			
			CountPosition = 2;
			
			InitViewFormat(0, prefix+"rev_yrmon", "yyyy-mm");
//			InitDataCombo(0, prefix+"to_flg", "Y|N", "Y|N");
//			InitUserFormat(0, prefix+"act_st_dt", "####-##-##", "-");
//			InitUserFormat(0, prefix+"tmp_st_dt", "####-##-##", "-");
//			InitUserFormat(0, prefix+"act_end_dt", "####-##-##", "- ");
//			InitUserFormat(0, prefix+"tmp_end_dt", "####-##-##", "-");
			
			WaitImageVisible = false;
			
			RowHeight(0) = 20;
			RowHeight(1) = 20;
			RowHeight(2) = 20;
			SetMergeCell(0, 1, 3, 1);
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var tgtSheetObj = null;
	switch (sAction) {
		case IBSEARCH: // Retrieve
			if (validateForm(sheetObj, formObj, sAction)) {
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				var sParam = FormQueryString(formObj);
				var url = "VOP_FCM_0041GS.do";
				var req = getSheet("sheet1");
				var rXml = reqSearch(req, url, sParam);
				
				sheetObj.Redraw = false;
				sheetObj.LoadSearchXml(rXml);
				sheetObj.Redraw = true;
				ComOpenWait(false);
			}else{
				document.form.exe_yrmon.focus();
			}
			break;

		case SEARCH01: // Load
			if (validateForm(sheetObj, formObj, sAction)) {
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH01;
				var sParam = FormQueryString(formObj);
				var url = "VOP_FCM_0041GS.do";
				var req = getSheet("sheet1");
				var rXml = reqSearch(req, url, sParam);
				
				sheetObj.Redraw = false;
				sheetObj.LoadSearchXml(rXml);
				sheetObj.Redraw = true;
				ComOpenWait(false);
			}else{
				document.form.exe_yrmon.focus();
			}
			break;
			
		case SEARCH02:
			ComOpenWait(true);
			if(ComShowConfirm("Do you want to proceed?")){
				var sParam = sheetObj.GetSaveString(true);
				sParam += "&f_cmd=" + SEARCH02;
				var rXml = sheetObj.GetSearchXml("VOP_FCM_0041GS.do", sParam);
				sheetObj.LoadSearchXml(rXml);
			}
			ComOpenWait(false)
			break;
			
		case SEARCH03: // Change actual end date
			if (validateForm(sheetObj, formObj, sAction)) {
				var rslt = null;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH03;
				var sParam = FormQueryString(formObj);
				var url = "VOP_FCM_0041GS.do";
				var req = getSheet("sheet1");
				var rXml = reqSearch(req, url, sParam);
				
				var arr = ComFcmXml2Array(rXml, "foil_rmn_wgt|doil_rmn_wgt");
				if(arr && arr.length==1){
					rslt = arr[0];
				}
				ComOpenWait(false);
				return rslt;
			}
			break;
			
		case IBSAVE:
			ComOpenWait(true);
			if(ComShowConfirm("Do you want to save?")){
				var sParam = sheetObj.GetSaveString(true) + "&f_cmd=" + MODIFY;
				var rXml = sheetObj.GetSaveXml("VOP_FCM_0041GS.do", sParam);
				sheetObj.LoadSaveXml(rXml);
			}
			ComOpenWait(false)
			break;
			
		case IBCLEAR:
			sheetObj.Redraw = false;
			sheetObj.RemoveAll();
			sheetObj.Redraw = true;
			formObj.reset();
			document.form.exe_yrmon.focus();
			break;
	}
}

function getSaveString(sheetObj){
	var start = sheetObj.HeaderRows;
	var end = start + sheetObj.SearchRows;
	var prefix = sheetObj.prefix;
	var sParam = "";
	for(var Row=start; Row<end; Row++){
		if(Row!=end-1){
			sParam += "&";
		}
		sParam += "estm_seq=" + sheetObj.CellValue(Row, prefix+"estm_seq");
		sParam += "&voy_end_rmn_wgt=" + sheetObj.CellValue(Row, prefix+"voy_end_rmn_wgt");
		sParam += "&voy_end_csm_wgt=" + sheetObj.CellValue(Row, prefix+"voy_end_csm_wgt");
		sParam += "&mon_end_rmn_wgt=" + sheetObj.CellValue(Row, prefix+"mon_end_rmn_wgt");
		sParam += "&mon_end_csm_wgt=" + sheetObj.CellValue(Row, prefix+"mon_end_csm_wgt");
		sParam += "&estm_mon_csm_wgt=" + sheetObj.CellValue(Row, prefix+"estm_mon_csm_wgt");
	}
	return sParam;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch(sAction){
		case IBSEARCH:
		case SEARCH01:
			if(ComIsDate(formObj.exe_yrmon.value, "ym")){
				return true;
			}else{
//				msgs['COM130403'] = 'Mandatory field is missing. Please enter {?msg1}.';
				ComShowCodeMessage("COM130403", "'Base Month'");
				return false;
			}
			break;
		case SEARCH03:
			return true;
			break;
		default:
			return true;
	}
}

function sheet2_OnPopupClick(sheetObj, Row, Col){
	var saveName = sheetObj.ColSaveName(Col);
	switch(saveName){
		case sheetObj.prefix+"trnd_line_no":
			if("HFO"==sheetObj.CellValue(Row, sheetObj.prefix+"csm_oil_tp_cd")){
				var sUrl = "VOP_FCM_0014.do";
				var rVal = ComOpenPopup(sUrl, 1015, 650, "setTrndLineInfo", "0,0", true, false, Row, Col, 1);
			}
			break;
	}
}

function setTrndLineInfo(aryPopupData, row, col, sheetIdx){
	var sheetObj = sheetObjects[sheetIdx];
	var Row = Number(row);
	var Col = Number(col);
	
	sheetObj.CellValue2(Row, "trnd_line_seq") = aryPopupData[0][0]; //trnd_line_seq
	sheetObj.CellValue2(Row, "trnd_line_no")   = aryPopupData[0][14]; //trnd_line_no
//	sheetObj.CellValue2(Row, Col+1) = aryPopupData[0][8]; //x2 계수
//	sheetObj.CellValue2(Row, Col+2) = aryPopupData[0][9]; //x계수
//	sheetObj.CellValue2(Row, Col+3) = aryPopupData[0][10]; //상수
}

function sheet2_OnSearchEnd(sheetObj){
	manageAllRow(sheetObj);
}

function sheet3_OnSearchEnd(sheetObj){
	manageAllRow(sheetObj);
}

function manageAllRow(sheetObj){
	var stRow = 0;
	var endRow = 0;
	
	if(sheetObj.SearchRows>0){
		stRow = sheetObj.HeaderRows;
		endRow = stRow + sheetObj.SearchRows;
	}
	
	sheetObj.Redraw = false;
	
	for(var Row=stRow; Row<endRow; Row++){
		if(sheetObj.id == "sheet2"){
			checkTCOut(sheetObj, Row);
			trendLinePopupControl(sheetObj, Row);
			checkPort(sheetObj, Row);
		}
		checkBoxControl(sheetObj, Row);
		sheetObj.RowStatus(Row) = "R";
	}
	
	sheetObj.Redraw = true;
}

function checkBoxControl(sheetObj, Row){
	if("RV"==sheetObj.CellValue(Row, "estm_vvd_tp_cd") &&
			"RV"==sheetObj.CellValue(Row, "pre_estm_vvd_tp_cd")){
		sheetObj.RowEditable(Row) = false;
		sheetObj.RowFontColor(Row) = sheetObj.RgbColor(170, 170, 170);
	}			
}

function checkTCOut(sheetObj, Row){
	var prefix = sheetObj.prefix;
	var errFlg = "N";
	
	if(!sheetObj.RowEditable(Row)){
		return;
	}
	
	if("SML"!=sheetObj.CellValue(Row, prefix+"crr_cd")){
		errFlg = "Y";
	}
	
	if("Y"==sheetObj.CellValue(Row, prefix+"to_flg")){
		errFlg = "Y";
	}
	
	sheetObj.CellValue2(Row, prefix+"err_flg") = errFlg;
	
	if("Y"==errFlg){
		sheetObj.CellBackColor(Row, prefix+"err_flg") = sheetObj.RgbColor(255, 0, 0);
	}
}

function trendLinePopupControl(sheetObj, Row){
	var prefix = sheetObj.prefix;
	if("MDO"==sheetObj.CellValue(Row, prefix+"csm_oil_tp_cd")){
		sheetObj.CellEditable(Row, prefix+"trnd_line_no") = false;
	}
}

function checkPort(sheetObj, Row){
	
	if(sheetObj.CellValue(Row, "csm_oil_tp_cd")=="MDO"){
		sheetObj.CellEditable(Row, "act_end_dt") = false;
		return;
	}
	
	// compare start
	var actStartPort = sheetObj.CellValue(Row, "act_st_port_cd");
	var actStartDate = sheetObj.CellValue(Row, "act_st_dt");
	var tmpStartPort = sheetObj.CellValue(Row, "tmp_st_port_cd");
	var tmpStartDate = sheetObj.CellValue(Row, "tmp_st_dt");
	var diffColor = sheetObj.RgbColor(255, 128, 128);
	
	if(actStartPort && tmpStartPort && actStartPort!=tmpStartPort){
		sheetObj.CellBackColor(Row, "act_st_port_cd") = diffColor; 
		sheetObj.CellBackColor(Row, "tmp_st_port_cd") = diffColor;
	}
	
	if(actStartDate && tmpStartDate && actStartDate!=tmpStartDate){
		sheetObj.CellBackColor(Row, "act_st_dt") = diffColor; 
		sheetObj.CellBackColor(Row, "tmp_st_dt") = diffColor;
	}
	
	// compare end
	diffColor = sheetObj.RgbColor(128, 255, 128);
	var actEndPort = sheetObj.CellValue(Row, "act_end_port_cd");
	var actEndDate = sheetObj.CellValue(Row, "act_end_dt");
	var tmpEndPort = sheetObj.CellValue(Row, "tmp_end_port_cd");
	var tmpEndDate = sheetObj.CellValue(Row, "tmp_end_dt");
	
	if(actEndPort && tmpEndPort && actEndPort!=tmpEndPort){
		sheetObj.CellBackColor(Row, "act_end_port_cd") = diffColor; 
		sheetObj.CellBackColor(Row, "tmp_end_port_cd") = diffColor;
	}
	
	if(actEndDate && tmpEndDate && actEndDate!=tmpEndDate){
		sheetObj.CellBackColor(Row, "act_end_dt") = diffColor; 
		sheetObj.CellBackColor(Row, "tmp_end_dt") = diffColor;
	}else if(actEndDate && tmpEndDate && actEndDate==tmpEndDate){
		sheetObj.CellBackColor(Row, "act_end_dt") = 0; // edit color 
		sheetObj.CellBackColor(Row, "tmp_end_dt") = sheetObj.CellBackColor(Row, "rev_yrmon"); // unedit color
	}
}

function sheet2_OnChange(sheetObj, Row, Col, Value){
	var prefix = sheetObj.prefix;
	var saveName = sheetObj.ColSaveName(Col);
	if(saveName==prefix+"act_end_dt"){
		sheetObj.CellValue2(Row+1, "act_end_dt") = Value; // HFO -> MDO copy
		changeEndDate(sheetObj, Row, Col);
		checkPort(sheetObj, Row);
	}
}

function changeEndDate(sheetObj, Row, Col){
	if(isEndDate(sheetObj.CellValue(Row, Col))){
		var revYrmon = sheetObj.CellValue(Row, "rev_yrmon");
		var actEndDate = sheetObj.CellValue(Row, "act_end_dt").substring(0, 6);
		if(revYrmon > actEndDate){
			return;
		}
		var rmnWgt = getMonthEndRemain(sheetObj, Row);
		sheetObj.CellValue2(Row, "mon_end_rmn_wgt") = rmnWgt[0];						
		sheetObj.CellValue2(Row+1, "mon_end_rmn_wgt") = rmnWgt[1];
	}
}

function getMonthEndRemain(sheetObj, Row){
	var formObj = document.form;
	formObj.rev_yrmon.value = sheetObj.CellValue(Row, "rev_yrmon");
	formObj.vsl_cd.value = sheetObj.CellValue(Row, "vsl_cd");
	formObj.skd_voy_no.value = sheetObj.CellValue(Row, "skd_voy_no");
	formObj.skd_dir_cd.value = sheetObj.CellValue(Row, "skd_dir_cd");
	formObj.rev_dir_cd.value = sheetObj.CellValue(Row, "rev_dir_cd");
	return doActionIBSheet(sheetObj, formObj, SEARCH03);
}

function getSheet(id){
	return getSheetById(sheetObjects, id);
}

function sheetControl(id){
	for(var i=0; i<sheetObjects.length; i++){
		if(sheetObjects[i].id == id){
			sheetObjects[i].style.height = 440;
		}else{
			sheetObjects[i].style.height = 0;
		}
	}
}

function buttonControl(id){
	if(id=="sheet2"){
		ComBtnEnable("btn_Creation");
		ComBtnEnable("btn_Save");
		ComBtnEnable("btn_ROBEMList");
	}else{
		ComBtnDisable("btn_Creation");
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_ROBEMList");
	}
}

/* 개발자 작업 끝 */