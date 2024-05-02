/**
 * Copyright(c) 2013 CyberLogitec
 * @FileName : ees_ctm_0465.js
 * @FileTitle : Multi Container Inquiry
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2013.12.09
 * @LastModifier : 문동선
 * @LastVersion : 1.0
 *  2013.12.09 문동선 (EES_CTM_0408 화면 Copy 로 생성)
 *  2016.06.07 김상현 [CHM-201641849] CTM: VGM Report 기능 추가
 *   - VGM Report 화면으로 사용할 수 있도록 보완.
 */

/**
 * @class ees_ctm_0465 : ees_ctm_0465 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_ctm_0465() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject     = setSheetObject;
	this.loadPage           = loadPage;
	this.initSheet          = initSheet;
	this.doActionIBSheet    = doActionIBSheet;
	this.validateForm       = validateForm;
}

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {
	var sheetObj = sheetObjects[0];
	var frmObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
		case "btn_Calendar01" :
			if (frmObj.divflag[0].checked == true) {
				var cal = new ComCalendarFromTo();
				cal.select(frmObj.event_from_dt, frmObj.event_to_dt, "yyyy-MM-dd");
			}
			break;
		case "btn_Calendar02" :
			if (frmObj.divflag[1].checked == true) {
				var cal = new ComCalendarFromTo();
				cal.select(frmObj.cre_from_dt, frmObj.cre_to_dt, "yyyy-MM-dd");
			}
			break;
		case "btn_Calendar03" :
			if (frmObj.divflag[2].checked == true) {
				var cal = new ComCalendarFromTo();
				cal.select(frmObj.from_dt, frmObj.to_dt, "yyyy-MM-dd");
			}
			break;
		case "btn_more" :
			document.form.pagerows.value = Number(document.form.pagerows.value) + 1;
			doActionIBSheet(sheetObj, frmObj, SEARCHLIST);
			break;
		case "btn_retrieve" :
			sheetObj.RemoveAll();
			document.form.pagerows.value = "1";
			ComBtnEnable("btn_more");
			doActionIBSheet(sheetObj, frmObj, SEARCHLIST);
			break;
		case "btn_new" :
			ComResetAll();
			frmObj.from_dt.value = frmObj.fromDt.value;
			frmObj.to_dt.value = frmObj.toDt.value;
			frmObj.event_from_dt.value = frmObj.eventFromDt.value;
			frmObj.event_to_dt.value = frmObj.eventToDt.value;
			frmObj.cre_from_dt.value = frmObj.eventFromDt.value;
			frmObj.cre_to_dt.value = frmObj.eventToDt.value;
			// btn_eachbkg 버튼 Disable
			ComBtnDisable("btn_eachbkg");
			ComBtnDisable("btn_more");

			classToggle();

			// RCC 조회.
			doActionIBSheet(sheetObjects[0], document.form, SEARCH01); 
			break;
		case "btn_eachbkg" :
			// function sheet1_OnDblClick 호출
			sheet1_OnDblClick(sheetObj, sheetObj.SelectRow);
			break;
		case "btn_downexcel" :
			ComOpenWait(true);
			sheetObj.Down2Excel(1, false, false, true, "", "", false, false, "", false, "");
			ComOpenWait(false);
			break;
		case "btn_close" :
			window.close();
			break;
		case "btn_more2" :
			document.form.pagerows.value = Number(document.form.pagerows.value) + 1;
			doActionIBSheet(sheetObjects[1], frmObj, SEARCHLIST01);
			break;
		case "btn_retrieve2" :
			sheetObjects[1].RemoveAll();
			document.form.pagerows.value = "1";
			ComBtnEnable("btn_more2");
			doActionIBSheet(sheetObjects[1], document.form, SEARCHLIST01);
			break;
		case "btn_new2" :
			ComResetAll();
			frmObj.from_dt.value = frmObj.fromDt.value;
			frmObj.to_dt.value = frmObj.toDt.value;
			frmObj.event_from_dt.value = frmObj.eventFromDt.value;
			frmObj.event_to_dt.value = frmObj.eventToDt.value;
			frmObj.cre_from_dt.value = frmObj.eventFromDt.value;
			frmObj.cre_to_dt.value = frmObj.eventToDt.value;

			classToggle();

			// RCC 조회.
			doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
			break;
		case "btn_downexcel2" :
			ComOpenWait(true);
			sheetObjects[0].Down2Excel(1, false, false, true, "", "", false, false, "", false, "");
			ComOpenWait(false);
			break;
		}
	} catch(e) {
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
 * IBMultiCombo Object를 배열로 등록
 * param : combo_obj ==> 콤보오브젝트
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj) {
    comboObjects[comboCnt++] = combo_obj;
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tabObj) {
	tabObjects[tabCnt++] = tabObj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
    for (var k=0; k<tabObjects.length; k++){
        initTab(tabObjects[k], k+1);
    }

	for (i=0; i<sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]); // khlee-시작 환경 설정 함수 이름 변경
		initSheet(sheetObjects[i], i+1);
		ComEndConfigSheet(sheetObjects[i]); // khlee-마지막 환경 설정 함수 추가
	}

	for (var i=0; i<comboObjects.length; i++) {
		initCombo(comboObjects[i], comboObjects[i].id);
	}

    // CTM-COMMON (& 예외처리)
    setEventProcess("cntrno_disp");

	axon_event.addListener("keypress", "obj_keypress", "cntrno_disp"); // OnKeyPress 이벤트 (공통function)
	axon_event.addListener("keyup", "obj_onkeyup", "cntrno_disp");     // OnKeyUp 이벤트 (자체function)
	axon_event.addListener("change", "rcc_cd_Change", "rcc_cd");
	axon_event.addListener("keyup", "yard_cd1_Keyup", "yard_cd1");
	axon_event.addListener("blur", "date_focusout", "event_from_dt");
	axon_event.addListener("blur", "date_focusout", "event_to_dt");
	axon_event.addListener("blur", "date_focusout", "cre_from_dt");
	axon_event.addListener("blur", "date_focusout", "cre_to_dt");
	axon_event.addListener("blur", "date_focusout", "from_dt");
	axon_event.addListener("blur", "date_focusout", "to_dt");

	// btn_eachbkg 버튼 Disable
	ComBtnDisable("btn_eachbkg");
	ComBtnDisable("btn_more");
	ComBtnDisable("btn_more2");
	classToggle();

	// RCC 조회.
	doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
}

function classToggle() {
	var formObj = document.form;

	formObj.event_from_dt.className = "input1"; ComEnableObject(formObj.event_from_dt, false); 
	formObj.event_to_dt.className = "input1"; ComEnableObject(formObj.event_to_dt, false);
	formObj.cre_from_dt.className = "input1"; ComEnableObject(formObj.cre_from_dt, false);
	formObj.cre_to_dt.className = "input1"; ComEnableObject(formObj.cre_to_dt, false);
	formObj.cntrno_disp.className = "input1"; ComEnableObject(formObj.cntrno_disp, false);
	formObj.check_digit.className = "input1"; ComEnableObject(formObj.check_digit, false);
	formObj.from_dt.className = "input1"; ComEnableObject(formObj.from_dt, false);
	formObj.to_dt.className = "input1"; ComEnableObject(formObj.to_dt, false);

	formObj.tpsz.Text = "ALL";
	formObj.statusCombo.Code = "OC,VL";

	if (formObj.divflag[0].checked == true) {
		formObj.vgm_wgt_qty.value = "Y";

		ComEnableObject(formObj.event_from_dt, true);
		formObj.event_from_dt.className = "input1";
		ComEnableObject(formObj.event_to_dt, true);
		formObj.event_to_dt.className = "input1";
		formObj.cntr_no.value = "";
		formObj.p_cntrno.value = "";
		formObj.cntrno_disp.value = "";
		formObj.check_digit.value = "";
	} else if (formObj.divflag[1].checked == true) {
		formObj.vgm_wgt_qty.value = "Y";

		ComEnableObject(formObj.cre_from_dt, true);
		formObj.cre_from_dt.className = "input1";
		ComEnableObject(formObj.cre_to_dt, true);
		formObj.cre_to_dt.className = "input1";
		formObj.cntr_no.value = "";
		formObj.p_cntrno.value = "";
		formObj.cntrno_disp.value = "";
		formObj.check_digit.value = "";
	} else if (formObj.divflag[2].checked == true) {
		formObj.statusCombo.Text = "ALL";
		formObj.vgm_wgt_qty.value = "";

		ComEnableObject(formObj.cntrno_disp, true);
		formObj.cntrno_disp.className = "input1";
		ComEnableObject(formObj.check_digit, true);
		formObj.check_digit.className = "input1";
		ComEnableObject(formObj.from_dt, true);
		formObj.from_dt.className = "input1";
		ComEnableObject(formObj.to_dt, true);
		formObj.to_dt.className = "input1";
	}
}

/**
 * RCC 변경 Event 처리.
 */
function rcc_cd_Change(event) {
	doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
}

/**
 * Yard 정보 변경
 */
function yard_cd1_Keyup(event) {
	var eventElement = event.srcElement;
	eventElement.value = eventElement.value.toUpperCase();

	if (eventElement.value.length < 5) {
		document.form.yard_cd2.RemoveAll();
		return;
	}
	doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	with (tabObj) {
		var cnt = 0;
		InsertTab(cnt++, " MVMT Processed ", -1);
		InsertTab(cnt++, " MVMT Error ", -1);
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;

	switch(sheetNo) {
	case 1 : // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 442;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(47, 9, 0, true);

			// 헤더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle = "Container No.|TP/SZ|CYC|C|STS|A/F|Origin YD|Return YD|Event Date|VVD Code|Booking No.|Booking No.|B/L No.|VGM\nWGT QTY|VGM\nWGT CD|VGM\nMETHOD|VGM\nVERIDT|VGM\nSIGNATURE|VGM\nREF NO|VGM\nWPA|VGM\nVOR|F/M|I/O|MSG|TP|DM|HR|HB|D|E|R|SP|S/P|S/P|Mode|Chassis No.|M.G Set|Seal No.|Waybill|Pick Up No.|Update Date (L)|Creation Date (L)|Update Date (S)|Creation Date (S)|Office|User Name|Remark(S)";

			// 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 헤더 툴팁
			var sTipAF = "";
			sTipAF += "[ Auto Flag ]\n";
			sTipAF += "A : Missing status automatically created by system.\n";
			sTipAF += "C : (International) \"TS, IC, MT\" Status automatically created after \"VD\"\n";
			sTipAF += "      (USA domestic) \"CM\" Status automatically created after \"CD\"\n";
			sTipAF += "N : Once automatically created status (\"A\") modified by manual,\n";
			sTipAF += "      \"A\" changed to \"N\"\n";
			sTipAF += "M : Added status.\n";
			sTipAF += "U : Status updated due to next status.\n";
			sTipAF += "E : Status created by Master/Lease.\n";
			sTipAF += "S : Once automatically created status (\"A\") modified by late EDI,\n";
			sTipAF += "      \"A\" changed to \"S\"\n";
			sTipAF += "B : Status updated by manual due to error.\n";
			sTipAF += "G : Once created without VGM, missing VGM is retroactively inserted by later EDI message.";

			var sTipIO = "Bound indicator"; //
			var sTipTP = "[ Cargo type ] \nF: Full, P: Reposition, R: Revenue";
			var sTipDM = "Damage, Y";
			var sTipHR = "Hanger Rack, Y";
			var sTipHB = "Hanger Bar";
			var sTipD  = "Disposal Candidate, Y";
			var sTipE  = "Immediate Exit, Y";
			var sTipR  = "Re-furbishing, Y";
			var sTipSP = "Special, Y";

			// 자동 트림하여 조회및 저장
			DataAutoTrim = true;

			// 데이터속성     [ROW, COL,    DATATYPE,  WIDTH,  DATAALIGN,   COLMERGE, SAVENAME,                  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    false,    "cntr_no",	               false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    40,     daCenter,    false,    "cntr_tpsz_cd",            false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "cnmv_cyc_no",             false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    40,     daCenter,    true,     "cnmv_co_cd",              false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "mvmt_sts_cd",             false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "mvmt_cre_tp_cd",          false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    sTipAF);
			InitDataProperty(0, cnt++,    dtData,    70,     daCenter,    false,    "org_yd_cd",               false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    70,     daCenter,    false,    "dest_yd_cd",              false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    100,    daCenter,    false,    "cnmv_evnt_dt",            false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    70,     daCenter,    false,    "vvd_cd",                  false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    20,     daCenter,    false,    "bkg_knt",                 false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    false,    "bkg_no",                  false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    false,    "bl_no",                   false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    false,    "vgm_wgt_qty",             false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    "VERIFIED GROSS MASS WEIGHT QUANTITY");
			InitDataProperty(0, cnt++,    dtHidden,  90,     daCenter,    false,    "vgm_wgt_ut_cd",           false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    "VGM WEIGHT CODE(KGM:Kilograms, LBR:Pounds)");
			InitDataProperty(0, cnt++,    dtHidden,  90,     daCenter,    false,    "vgm_mzd_tp_cd",           false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    "VGM METHOD(METHOD 1 or METHOD 2)");
			InitDataProperty(0, cnt++,    dtHidden,  90,     daCenter,    false,    "vgm_vrfy_dt",             false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    "VGM VERIFICATION DATE");
			InitDataProperty(0, cnt++,    dtHidden,  90,     daCenter,    false,    "vgm_sig_ctnt",            false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    "VGM_SIGNING PERSON");
			InitDataProperty(0, cnt++,    dtHidden,  90,     daCenter,    false,    "vgm_ref_no",              false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    "VGM_REFERENCE NO");
			InitDataProperty(0, cnt++,    dtHidden,  90,     daCenter,    false,    "vgm_wgt_pty_ctnt",        false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    "TE(Transport Equipment) WEIGHING PARTY(Terminal)");
			InitDataProperty(0, cnt++,    dtHidden,  90,     daCenter,    false,    "vgm_vrfy_ord_ctnt",       false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    "RESPONSE TO TE GROSS MASS VERIFICATION ORDER");
			InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "fcntr_flg",               false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "ob_cntr_flg",             false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    sTipIO);
			InitDataProperty(0, cnt++,    dtData,    35,     daCenter,    false,    "mvmt_edi_msg_tp_id",      false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "bkg_cgo_tp_cd",           false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    sTipTP);
			InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "cntr_dmg_flg",            false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    sTipDM);
			InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "cntr_hngr_rck_cd",        false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    sTipHR);
			InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "cntr_hngr_bar_atch_knt",  false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    sTipHB);
			InitDataProperty(0, cnt++,    dtData,    20,     daCenter,    false,    "cntr_disp_flg",           false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    sTipD);
			InitDataProperty(0, cnt++,    dtData,    20,     daCenter,    false,    "imdt_ext_flg",            false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    sTipE);
			InitDataProperty(0, cnt++,    dtData,    20,     daCenter,    false,    "cntr_rfub_flg",           false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    sTipR);
			InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "spcl_cgo_flg",            false,    "",    dfNone,    0,    true,    true,    -1,    false,    true,    sTipSP);
			InitDataProperty(0, cnt++,    dtData,    40,     daCenter,    false,    "vndr_seq",                false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    80,     daCenter,    false,    "vndr_abbr_nm",            false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    40,     daCenter,    false,    "mvmt_trsp_mod_cd",        false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    80,     daCenter,    false,    "chss_no",                 false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    80,     daCenter,    false,    "mgst_no",                 false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    80,     daCenter,    false,    "cntr_seal_no",            false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    false,    "wbl_no",                  false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    false,    "pkup_no",                 false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    110,    daCenter,    false,    "upd_locl_dt",             false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    110,    daCenter,    false,    "cre_locl_dt",             false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    110,    daCenter,    false,    "upd_dt",                  false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    110,    daCenter,    false,    "cre_dt",                  false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    60,     daCenter,    false,    "ofc_cd",                  false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    70,     daLeft,      false,    "usr_nm",                  false,    "",    dfNone,    0,    true,    true);
			InitDataProperty(0, cnt++,    dtData,    150,    daLeft,      false,    "cnmv_rmk",                false,    "",    dfNone,    0,    true,    true);

			ToolTipOption = "balloon:true; width:420; backcolor:#ffffff; forecolor:#14358B; icon:0;";
			CountPosition = 2;
		}
		break;
	case 2 : // sheet2 init
		with (sheetObj) {
			// 높이 설정
			style.height = 442;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 헤더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle = "Container No.|T/S|ORG YD|Event Date|Receiving Date|Booking No.|EDI Booking|B/L No.|VVD Code|Call sign/Lloyd|Seal No.|VGM\nWGT QTY|VGM\nWGT CD|VGM\nMETHOD|VGM\nVERIDT|VGM\nSIGNATURE|VGM\nREF NO|VGM\nWPA|VGM\nVOR|Chassis No.|M.G Set|S/P|Mode|LCC|RTN YD|POL|POD|STS|I/O|F/M|E/I|Retry|Result error message|Remark(s)";

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(ComCountHeadTitle(HeadTitle), 4, 0, true);

			// 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 자동 트림하여 조회및 저장
			DataAutoTrim = true;

			// 데이터속성     [ROW, COL,    DATATYPE,  WIDTH,  DATAALIGN,   COLMERGE, SAVENAME,                  KEYFIELD, CALCULOGIC, DATAFORMAT,    POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0,   cnt++,  dtData,    100,    daCenter,    false,    "cntr_no",                 true,     "",         dfNone,        0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    30,     daCenter,    false,    "cntr_tpsz_cd",            false,    "",         dfNone,        0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    70,     daCenter,    false,    "evnt_yd_cd",              false,    "",         dfNone,        0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    100,    daCenter,    false,    "evnt_dt",                 false,    "",         dfUserFormat2, 0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    100,    daCenter,    false,    "cre_locl_dt",             false,    "",         dfUserFormat2, 0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    90,     daCenter,    false,    "bkg_no",                  false,    "",         dfNone,        0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    90,     daCenter,    false,    "edi_bkg_no",              false,    "",         dfNone,        0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    90,     daCenter,    false,    "bl_no",                   false,    "",         dfNone,        0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    90,     daCenter,    false,    "vvd_cd",                  false,    "",         dfNone,        0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    90,     daCenter,    false,    "call_sgn_lloyd",          false,    "",         dfNone,        0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    70,     daCenter,    false,    "cntr_seal_no",            false,    "",         dfNone,        0,          false,      false);
			InitDataProperty(0,   cnt++,  dtData,    90,     daCenter,    false,    "vgm_wgt_qty",             false,    "",         dfNone,        0,          false,      false,    -1,    false,    true,    "VERIFIED GROSS MASS WEIGHT QUANTITY");
			InitDataProperty(0,   cnt++,  dtHidden,  90,     daCenter,    false,    "vgm_wgt_ut_cd",           false,    "",         dfNone,        0,          false,      false,    -1,    false,    true,    "VGM WEIGHT CODE(KGM:Kilograms, LBR:Pounds)");
			InitDataProperty(0,   cnt++,  dtHidden,  90,     daCenter,    false,    "vgm_mzd_tp_cd",           false,    "",         dfNone,        0,          false,      false,    -1,    false,    true,    "VGM METHOD(METHOD 1 or METHOD 2)");
			InitDataProperty(0,   cnt++,  dtHidden,  90,     daCenter,    false,    "vgm_vrfy_dt",             false,    "",         dfNone,        0,          false,      false,    -1,    false,    true,    "VGM VERIFICATION DATE");
			InitDataProperty(0,   cnt++,  dtHidden,  90,     daCenter,    false,    "vgm_sig_ctnt",            false,    "",         dfNone,        0,          false,      false,    -1,    false,    true,    "VGM_SIGNING PERSON");
			InitDataProperty(0,   cnt++,  dtHidden,  90,     daCenter,    false,    "vgm_ref_no",              false,    "",         dfNone,        0,          false,      false,    -1,    false,    true,    "VGM_REFERENCE NO");
			InitDataProperty(0,   cnt++,  dtHidden,  90,     daCenter,    false,    "vgm_wgt_pty_ctnt",        false,    "",         dfNone,        0,          false,      false,    -1,    false,    true,    "TE(Transport Equipment) WEIGHING PARTY(Terminal)");
			InitDataProperty(0,   cnt++,  dtHidden,  90,     daCenter,    false,    "vgm_vrfy_ord_ctnt",       false,    "",         dfNone,        0,          false,      false,    -1,    false,    true,    "RESPONSE TO TE GROSS MASS VERIFICATION ORDER");
            InitDataProperty(0,   cnt++,  dtData,    80,     daCenter,    false,    "chss_no",                 false,    "",         dfNone,        0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    80,     daCenter,    false,    "mgst_no",                 false,    "",         dfNone,        0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    50,     daCenter,    false,    "vndr_seq",                false,    "",         dfNone,        0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    40,     daCenter,    false,    "mvmt_trsp_mod_cd",        false,    "",         dfNone,        0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    50,     daCenter,    false,    "lcc_cd",                  false,    "",         dfNone,        0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    60,     daCenter,    false,    "dest_yd_cd",              false,    "",         dfNone,        0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    50,     daCenter,    false,    "pol_cd",                  false,    "",         dfNone,        0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    50,     daCenter,    false,    "pod_cd",                  false,    "",         dfNone,        0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    30,     daCenter,    false,    "edi_mvmt_sts_cd",         false,    "",         dfNone,        0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    30,     daCenter,    false,    "edi_gate_io_cd",          false,    "",         dfNone,        0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    30,     daCenter,    false,    "cntr_full_sts_cd",        false,    "",         dfNone,        0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    30,     daCenter,    false,    "mvmt_edi_sght_cd",        false,    "",         dfNone,        0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    40,     daCenter,    false,    "rty_knt",                 false,    "",         dfNone,        0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    350,    daLeft,      false,    "mvmt_edi_rmk",            false,    "",         dfNone,        0,          false,      false);
            InitDataProperty(0,   cnt++,  dtData,    300,    daLeft,      false,    "cnmv_rmk",                false,    "",         dfNone,        0,          false,      false);

            InitUserFormat2(0, "evnt_dt", "####-##-## ##:##", "-|:");
            InitUserFormat2(0, "cre_locl_dt", "####-##-## ##:##", "-|:");

            // 영문자 또는 숫자만 입력
            InitDataValid(0, "cntr_no", vtEngUpOther, "1234567890");
            InitDataValid(0, "bkg_no", vtEngUpOther, "1234567890");
            InitDataValid(0, "vvd_cd", vtEngUpOther, "1234567890");
            InitDataValid(0, "edi_mvmt_sts_cd", vtEngUpOther, "1234567890");
            InitDataValid(0, "cntr_full_sts_cd", vtEngUpOther, "1234567890");

            CountPosition = 2;
            RequestTimeOut = 36000;
            SelectHighLight = false;

		}
		break;
	}
}

/**
 * Combo 초기화.
 */
function initCombo(comboObj, comboId) {
	var frmObj = document.form;

	with (comboObj) {
		UseCode = true;
		switch (comboId) {
		case "tpsz" :
			MultiSelect = true;
			DropHeight = 160;
			// coCtm.js의 code_get호출
			var rtnValues = code_get("CNTR_TPSZ_CD", "'N'", "DELT_FLG", "MDM_CNTR_TP_SZ");
			// cntr_tpsz_cd IBMulticombo생성 (CoCtm.js)
			parseMultiCombo(comboObj, "^#^" + rtnValues, "ALL^#^" + rtnValues);
			Text = "ALL";
			break;
		case "statusCombo" :
			MultiSelect = true;
			DropHeight = 160;
			var cnt = 0;
			InsertItem(cnt++, "OP", "OP");
			InsertItem(cnt++, "EN", "EN");
			InsertItem(cnt++, "TN", "TN");
			InsertItem(cnt++, "OC", "OC");
			InsertItem(cnt++, "VL", "VL");
			InsertItem(cnt++, "VD", "VD");
			InsertItem(cnt++, "IC", "IC");
			InsertItem(cnt++, "ID", "ID");
			InsertItem(cnt++, "TS", "TS");
			InsertItem(cnt++, "MT", "MT");
			InsertItem(cnt++, "ER", "ER");
			InsertItem(cnt++, "CP", "CP");
			InsertItem(cnt++, "CT", "CT");
			InsertItem(cnt++, "CE", "CE");
			InsertItem(cnt++, "CO", "CO");
			InsertItem(cnt++, "CI", "CI");
			InsertItem(cnt++, "CD", "CD");
			InsertItem(cnt++, "CM", "CM");
			InsertItem(cnt++, "ZZ", "ZZ");
			InsertItem(cnt++, "ALL", "");
			Text = "OC,VL";
			document.form.mvmt_sts_cd.value = "OC,VL";
			break;
		case "lcc_cd" :
			MultiSelect = true;
			break;
        }
    }
}

/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, frmObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
	case SEARCH01 : // RCC list 조회.
		frmObj.f_cmd.value = SEARCH01;
		rtn = sheetObj.GetSearchXml("EES_CTM_0418GS.do", FormQueryString(frmObj));
		if (rtn == "") return;
		rtn = ComGetEtcData(rtn, "rtn");
		rtnList = rtn.split("^");
		frmObj.rcc_cd.RemoveAll();

    	var idxSelect = "";
		for (i=0; i<=rtnList.length; i++) {
			if (rtnList[i]) {
				rtnValue = rtnList[i].split("|");
				frmObj.rcc_cd.InsertItem(i, rtnValue[0], rtnValue[0]);
				if (rtnValue[1] == '1') idxSelect = rtnValue[0];
			}
		}
		frmObj.rcc_cd.Text(idxSelect);
		break;
	case SEARCH02 : // LCC list 조회
		frmObj.f_cmd.value = SEARCH02;
		rtn = sheetObj.GetSearchXml("EES_CTM_0418GS.do", FormQueryString(frmObj));
		if (rtn == '') return;
		rtn = ComGetEtcData(rtn, "rtn");
		rtn = "ALL^" + rtn;
		rtnList = rtn.split("^");
		frmObj.p_lcc_cd.RemoveAll();
		frmObj.p_lcc_cd.MultiSelect = true;

		for (i=0; i<=rtnList.length; i++) {
			if (rtnList[i]) {
				frmObj.p_lcc_cd.InsertItem(i, rtnList[i], rtnList[i]);
			}
		}
		frmObj.p_lcc_cd.Code = "ALL";
		break;
	case SEARCH03 : // Yard code list 조회
		if (frmObj.yard_cd1.value.length > 4) {
			xml = sheetObj.GetSearchXml("CTMCommonGS.do", "f_cmd=" + SEARCH11 + "&p_yard1=" + frmObj.yard_cd1.value);
			rtnValue = ComGetEtcData(xml, "rtnValue");
			rtnValue = "ALL|ALL|ALL^" + rtnValue;
			parseYardMultiCombo(rtnValue, document.getElementById("yard_cd2"));
			frmObj.yard_cd2.Code = "ALL";
		}
		break;
	case SEARCHLIST : // 조회
		if (!validateForm(sheetObj, frmObj, sAction)) break;

		sheetObjects[0].WaitImageVisible = false;
		ComOpenWait(true);

		frmObj.f_cmd.value = SEARCH;

		if (frmObj.divflag[0].checked == true) {
			frmObj.p_date1.value = frmObj.event_from_dt.value.replace(/(-)/gi, "");
			frmObj.p_date2.value = frmObj.event_to_dt.value.replace(/(-)/gi, "");
		} else if (frmObj.divflag[1].checked == true) {
			frmObj.p_date1.value = frmObj.cre_from_dt.value.replace(/(-)/gi, "");
			frmObj.p_date2.value = frmObj.cre_to_dt.value.replace(/(-)/gi, "");
		} else if (frmObj.divflag[2].checked == true) {
			frmObj.p_date1.value = frmObj.from_dt.value.replace(/(-)/gi, "");
			frmObj.p_date2.value = frmObj.to_dt.value.replace(/(-)/gi, "");
		}

		if (frmObj.p_lcc_cd.Code != "") {
			var tempCds = frmObj.p_lcc_cd.Code.split(",");
			var lccCds = new Array();
			for (var i=0; i<tempCds.length; i++) {
				if (tempCds[i] != "ALL") {
					lccCds.push(tempCds[i]);
				}
			}
			if (lccCds.length > 0) {
				frmObj.lcc_cd.value = lccCds.join(",")
			} else {
				frmObj.lcc_cd.value = "";
			}
		} else {
			frmObj.lcc_cd.value = "";
		}

		if (frmObj.tpsz.Code != "") {
			var tempCds = frmObj.tpsz.Code.split(",");
			var tpSzCds = new Array();
			for (var i=0; i<tempCds.length; i++) {
				if (tempCds[i] != "ALL") {
					tpSzCds.push(tempCds[i]);
				}
			}
			if (tpSzCds.length > 0) {
				frmObj.cntr_tpsz_cd.value = tpSzCds.join(",")
			} else {
				frmObj.cntr_tpsz_cd.value = "";
			}
		} else {
			frmObj.cntr_tpsz_cd.value = "";
		}

		if (frmObj.statusCombo.Code != "") {
			var tempCds = frmObj.statusCombo.Code.split(",");
			var statusCds = new Array();
			for (var i=0; i<tempCds.length; i++) {
				if (tempCds[i] != "ALL") {
					statusCds.push(tempCds[i]);
				}
			}
			if (statusCds.length > 0) {
				frmObj.mvmt_sts_cd.value = statusCds.join(",")
			} else {
				frmObj.mvmt_sts_cd.value = "";
			}
		} else {
			frmObj.mvmt_sts_cd.value = "";
		}

		if (frmObj.yard_cd1.value != "") {
			if (frmObj.yard_cd2.Code === "ALL") {
				frmObj.org_yd_cd.value = frmObj.yard_cd1.value;
			} else {
				frmObj.org_yd_cd.value = frmObj.yard_cd1.value + frmObj.yard_cd2.Code;
			}
		}

		var xml = sheetObj.GetSearchXml("EES_CTM_0465GS.do", FormQueryString(frmObj));
		var rtnValue = xml.split("|$$|");
		if (ComGetTotalRows(rtnValue[0]) == 0 || ComGetTotalRows(rtnValue[0]) < 1000) {
			ComBtnDisable("btn_more");
		}
		sheetObjects[0].LoadSearchXml(rtnValue[0], true);
//		sheetObjects[0].SelectCell(sheetObjects[0].LastRow, 0); // 조회데이터의 마지막 row가 선택되어있게 한다.
		sheet1_OnClick(sheetObj, sheetObj.SelectRow, "bkg_no"); // SHEET에 조회된 데이터가 있으면 버튼 활성화를 위해 호출
		break;
	case SEARCHLIST01 : // 조회
		if (!validateForm(sheetObj, frmObj, sAction)) break;

		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);

		frmObj.f_cmd.value = SEARCHLIST01;

		if (frmObj.divflag[0].checked == true) {
			frmObj.p_date1.value = frmObj.event_from_dt.value.replace(/(-)/gi, "");
			frmObj.p_date2.value = frmObj.event_to_dt.value.replace(/(-)/gi, "");
		} else if (frmObj.divflag[1].checked == true) {
			frmObj.p_date1.value = frmObj.cre_from_dt.value.replace(/(-)/gi, "");
			frmObj.p_date2.value = frmObj.cre_to_dt.value.replace(/(-)/gi, "");
		} else if (frmObj.divflag[2].checked == true) {
			frmObj.p_date1.value = frmObj.from_dt.value.replace(/(-)/gi, "");
			frmObj.p_date2.value = frmObj.to_dt.value.replace(/(-)/gi, "");
		}

		if (frmObj.p_lcc_cd.Code != "") {
			var tempCds = frmObj.p_lcc_cd.Code.split(",");
			var lccCds = new Array();
			for (var i=0; i<tempCds.length; i++) {
				if (tempCds[i] != "ALL") {
					lccCds.push(tempCds[i]);
				}
			}
			if (lccCds.length > 0) {
				frmObj.lcc_cd.value = lccCds.join(",")
			} else {
				frmObj.lcc_cd.value = "";
			}
		} else {
			frmObj.lcc_cd.value = "";
		}

		if (frmObj.tpsz.Code != "") {
			var tempCds = frmObj.tpsz.Code.split(",");
			var tpSzCds = new Array();
			for (var i=0; i<tempCds.length; i++) {
				if (tempCds[i] != "ALL") {
					tpSzCds.push(tempCds[i]);
				}
			}
			if (tpSzCds.length > 0) {
				frmObj.cntr_tpsz_cd.value = tpSzCds.join(",")
			} else {
				frmObj.cntr_tpsz_cd.value = "";
			}
		} else {
			frmObj.cntr_tpsz_cd.value = "";
		}

		if (frmObj.statusCombo.Code != "") {
			var tempCds = frmObj.statusCombo.Code.split(",");
			var statusCds = new Array();
			for (var i=0; i<tempCds.length; i++) {
				if (tempCds[i] != "ALL") {
					statusCds.push(tempCds[i]);
				}
			}
			if (statusCds.length > 0) {
				frmObj.mvmt_sts_cd.value = statusCds.join(",")
			} else {
				frmObj.mvmt_sts_cd.value = "";
			}
		} else {
			frmObj.mvmt_sts_cd.value = "";
		}

		if (frmObj.yard_cd1.value != "") {
			if (frmObj.yard_cd2.Code === "ALL") {
				frmObj.org_yd_cd.value = frmObj.yard_cd1.value;
			} else {
				frmObj.org_yd_cd.value = frmObj.yard_cd1.value + frmObj.yard_cd2.Code;
			}
		}

		var xml = sheetObj.GetSearchXml("EES_CTM_0465GS.do", FormQueryString(frmObj));
		var rtnValue = xml.split("|$$|");
		if (ComGetTotalRows(rtnValue[0]) == 0 || ComGetTotalRows(rtnValue[0]) < 1000) {
			ComBtnDisable("btn_more2");
		}
		sheetObj.LoadSearchXml(rtnValue[0], true);
//		sheetObjects[0].SelectCell(sheetObjects[0].LastRow, 0); // 조회데이터의 마지막 row가 선택되어있게 한다.
		sheet1_OnClick(sheetObj, sheetObj.SelectRow, "bkg_no"); // SHEET에 조회된 데이터가 있으면 버튼 활성화를 위해 호출
		break;
	}
}

/**
 * Combo tpsz event 처리
 */
function tpsz_OnCheckClick(comboObj, index, code) {
	if (index === 0) {
		if (comboObj.CheckIndex(index) === true) {
			for (var i=0; i<comboObj.GetCount(); i++) {
				comboObj.CheckIndex(i) = false;
			}
			comboObj.Text("ALL");
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
}

/**
 * Combo lcc event 처리
 */
function p_lcc_cd_OnCheckClick(comboObj, index, code) {
	if (index === 0) {
		if (comboObj.CheckIndex(index) === true) {
			for (var i=0; i<comboObj.GetCount(); i++) {
				comboObj.CheckIndex(i) = false;
			}
			comboObj.Text("ALL");
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
}

/**
 * Combo statusCombo event 처리
 */
function statusCombo_OnCheckClick(comboObj, index, code) {
	if (index === (comboObj.GetCount() - 1)) {
		if (comboObj.CheckIndex(index) === true) {
			for (var i=0; i<comboObj.GetCount(); i++) {
				comboObj.CheckIndex(i) = false;
			}
			comboObj.Text("ALL");
		}
	} else {
		comboObj.CheckIndex(comboObj.GetCount() - 1) = false;
	}
}

/**
 * Sheet1의 OnSearchEnd 이벤트 처리
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	// 2016.07.06 김상현 [CHM-201642464] Multi container Inquiry 기능에서 VN지역 highlight 기능 제거
	//  - 베트남 highlight 기능 제거
/*
	// 베트남 건은 노란색으로 표시함 (org_yd_cd 앞 두글자가 "VN")
	if (sheetObj.RowCount > 0) {
		for (var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++) {
			if (sheetObj.CellValue(i, "org_yd_cd").substr(0, 2) == "VN") {
				sheetObj.RowBackColor(i) = sheetObj.WebColor2SysColor("#FFFFA0"); // 노란색
			}
		}
	}
*/

	ComOpenWait(false);
	sheetObjects[0].WaitImageVisible = true;
}

function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	ComOpenWait(false);
	sheetObj.WaitImageVisible = true;
}

/**
 * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event.
 */
function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// 클릭한 row의 "bkg_no"컬럼 값이 있으면
		if (ComGetLenByByte(Cellvalue(Row, "bkg_no")) > 0) {
			// btn_eachbkg 버튼 Enable
			ComBtnEnable("btn_eachbkg");
		} else {
			// btn_eachbkg 버튼 Disable
			ComBtnDisable("btn_eachbkg");
		}
	}
}

/**
 * IBSeet내의 데이터 영역의 셀을 더블클릭했을 때 발생하는 Event.
 */
function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// 더블클릭한 row의 "bkg_no"컬럼 값이 있으면
		if (ComGetLenByByte(Cellvalue(Row, "bkg_no")) > 0) {
			ComOpenPopup("/hanjin/EES_CTM_0409.do?" + "bkg_no=" + Cellvalue(Row, "bkg_no"), 1020, 682, "", "0,1");
		}
	}
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 * (***** 기본 Event (중요) *****)
 */
function tab1_OnChange(tabObj, nItem) {
	var objs = document.all.item("tabLayer");
	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	beforetab = nItem;

	if (nItem === 1) {
		document.getElementById("mvmt_inp_tp_cd").disabled = true;
	} else {
		document.getElementById("mvmt_inp_tp_cd").disabled = false;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, frmObj, sAction) {
	with (sheetObj) {
		if (sAction == SEARCHLIST) {
			if (frmObj.divflag[0].checked == true) {
				if (frmObj.event_from_dt.value == "" || frmObj.event_to_dt.value == "") {
					ComShowCodeMessage("COM130403", "Event Date");
					return false;
				} else if (ComGetDaysBetween(frmObj.event_from_dt.value, frmObj.event_to_dt.value) > 31) {
					ComShowMessage("Please check period. The maximum period is 31 days");
					return false;
				}
			} else if (frmObj.divflag[1].checked == true) {
				if (frmObj.cre_from_dt.value == "" || frmObj.cre_to_dt.value == "") {
					ComShowCodeMessage("COM130403", "Receive Date");
					return false;
				} else if (ComGetDaysBetween(frmObj.cre_from_dt.value, frmObj.cre_to_dt.value) > 31) {
					ComShowMessage("Please check period. The maximum period is 31 days");
					return false;
				}
			} else {
				if (frmObj.cntrno_disp.value == "" || frmObj.check_digit.value == "") {
					ComShowCodeMessage("COM130403", "Container No");
					return false;
				} else if (frmObj.from_dt.value == "" || frmObj.to_dt.value == "") {
					ComShowCodeMessage("COM130403", "Duration");
					return false;
				}
			}
		}
    }

    return true;
}

/**
 * HTML Object의 OnKeyUp이벤트 처리
 */
function obj_onkeyup(event) {
	srcValue = event.srcElement.value;    // CoCtm.js의 공통스크립트의 자동실행 방지용
	var frmObj = document.form;
	var sheetObj = sheetObjects[0];

	switch (event.srcElement.name) {
	case "cntrno_disp" :
		// cntrno_disp에 입력되는 값의 length에 따른 처리
		frmObj.cntrno_disp.value = frmObj.cntrno_disp.value.toUpperCase();
		var cntrnoDisp = frmObj.cntrno_disp;
		if (cntrnoDisp.value.length > 1) {
			frmObj.p_cntrno.value = cntrnoDisp.value;
			if (cntrnoDisp.value.length > 9) {
				// p_cntrno에 10글자가 채워지면 CTM공통함수의 cntr_search호출
				if (!cntr_search()) {
					cntrnoDisp.select();
					cntrnoDisp.focus();
				} else {
					// 정상적인 경우 CTM공통함수의 setFocusIndex호출(다음 Element에 Focus)
					setFocusIndex(event.srcElement, 1);
					frmObj.cntr_no.value =  frmObj.cntrno_disp.value + frmObj.check_digit.value ;
				}
			} else {
				frmObj.check_digit.value = "";
			}
		} else {
			frmObj.p_cntrno.value = "";
			frmObj.check_digit.value = "";
		}
		break;
    }
    onShowErrMsg = false; // CoCtm.js의 공통스크립트의 자동실행 방지용
}

/**
 * Popup 실행
 * @param srcName
 * @param arg
 */
function doProcessPopup(srcName, arg) {
	var sheetObj = sheetObjects[0];
	var formObj	= document.form;
	var sUrl	= '';
	var sWidth	= '';
	var sHeight	= '';

	if (formObj.divflag[2].checked == false) {
		return;
	}

	with(sheetObj) {
		switch(srcName) {
		case "m_cntr_no" : // CNTR No. 멀티입력 팝업 호출
			var flag = ComReplaceStr(srcName, "m_", "");
			var orgval = formObj.cntr_no.value;
			// 멀티입력 팝업 타이틀 세부 내용 지정
			var returntitle = '';
			if (flag == "cntr_no") returntitle = "CNTR No.";

			var param = "?returnval=" + flag + "&returntitle=" + returntitle+ "&orgval=" + orgval;
			ComOpenPopup("EES_CTM_0464.do" + param, 400, 380, "getCntr_Multi", "1,0,1,1,1,1,1,1,1,1,1,1", true);
			formObj.cntrno_disp.value = formObj.cntr_no.value.substring(0, 10);
			formObj.check_digit.value = formObj.cntr_no.value.substring(10, 11);

			if (formObj.cntr_no.value.length > 12) {
//				formObj.cntrno_disp.style.background = "#FFCCFF";
				formObj.cntrno_disp.disabled = true;
			} else {
//				formObj.cntrno_disp.style.background = "#CCFFFF"; 
				formObj.cntrno_disp.disabled = false;
			}
			return;
			break;
		}
	}

	var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
	ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
}

/**
 * 멀티입력 팝업 페이지가 닫힌 후, 호출되는 Opener 함수
 *  - 해당 필드에 멀티 입력값을 설정해준다.
 */
function getCntr_Multi(rArray, return_val) {
	var targObj = eval("document.form." + return_val);
	var retStr = rArray.toString().toUpperCase();
   	ComSetObjValue(targObj, retStr);
}    

/**
 * VGM 항목 보이기/숨기기
 */
function showVgm() {
	if (document.form.show_vgm.checked == true) {
		sheetObjects[0].ColHidden("vgm_mzd_tp_cd") = false;
		sheetObjects[0].ColHidden("vgm_wgt_ut_cd") = false;
		sheetObjects[0].ColHidden("vgm_vrfy_dt") = false;
		sheetObjects[0].ColHidden("vgm_sig_ctnt") = false;
		sheetObjects[0].ColHidden("vgm_ref_no") = false;
		sheetObjects[0].ColHidden("vgm_wgt_pty_ctnt") = false;
		sheetObjects[0].ColHidden("vgm_vrfy_ord_ctnt") = false;

		sheetObjects[1].ColHidden("vgm_mzd_tp_cd") = false;
		sheetObjects[1].ColHidden("vgm_wgt_ut_cd") = false;
		sheetObjects[1].ColHidden("vgm_vrfy_dt") = false;
		sheetObjects[1].ColHidden("vgm_sig_ctnt") = false;
		sheetObjects[1].ColHidden("vgm_ref_no") = false;
		sheetObjects[1].ColHidden("vgm_wgt_pty_ctnt") = false;
		sheetObjects[1].ColHidden("vgm_vrfy_ord_ctnt") = false;
	} else {
		sheetObjects[0].ColHidden("vgm_mzd_tp_cd") = true;
		sheetObjects[0].ColHidden("vgm_wgt_ut_cd") = true;
		sheetObjects[0].ColHidden("vgm_vrfy_dt") = true;
		sheetObjects[0].ColHidden("vgm_sig_ctnt") = true;
		sheetObjects[0].ColHidden("vgm_ref_no") = true;
		sheetObjects[0].ColHidden("vgm_wgt_pty_ctnt") = true;
		sheetObjects[0].ColHidden("vgm_vrfy_ord_ctnt") = true;

		sheetObjects[1].ColHidden("vgm_mzd_tp_cd") = true;
		sheetObjects[1].ColHidden("vgm_wgt_ut_cd") = true;
		sheetObjects[1].ColHidden("vgm_vrfy_dt") = true;
		sheetObjects[1].ColHidden("vgm_sig_ctnt") = true;
		sheetObjects[1].ColHidden("vgm_ref_no") = true;
		sheetObjects[1].ColHidden("vgm_wgt_pty_ctnt") = true;
		sheetObjects[1].ColHidden("vgm_vrfy_ord_ctnt") = true;
	}
}

/**
 * Date focus out 처리
 * @param event
 */
function date_focusout(event) {
	var dateStr = event.srcElement.value;
	event.srcElement.value = dateStr.substr(0, 4) + "-" + dateStr.substr(4, 2) + "-" + dateStr.substr(6, 2)
}
