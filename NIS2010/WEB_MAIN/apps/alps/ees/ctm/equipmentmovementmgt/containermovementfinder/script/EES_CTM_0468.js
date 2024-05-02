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
				cal.select(frmObj.cre_from_dt, frmObj.cre_to_dt, "yyyy-MM-dd");
			}
			break;
		case "btn_Calendar02" :
			if (frmObj.divflag[1].checked == true) {
				var cal = new ComCalendarFromTo();
				cal.select(frmObj.vgm_vrfy_from_dt, frmObj.vgm_vrfy_to_dt, "yyyy-MM-dd");
			}
			break;
		case "btn_retrieve" :
			sheetObj.RemoveAll();
			ComBtnEnable("btn_more");
			doActionIBSheet(sheetObj, frmObj, SEARCHLIST);
			break;
		case "btn_new" :
			ComResetAll();
			frmObj.cre_from_dt.value = frmObj.defaultFromDate.value;
			frmObj.cre_to_dt.value = frmObj.defaultToDate.value;
			frmObj.vgm_vrfy_from_dt.value = frmObj.defaultFromDate.value;
			frmObj.vgm_vrfy_to_dt.value = frmObj.defaultToDate.value;

			// RCC 조회.
			doActionIBSheet(sheetObjects[0], document.form, SEARCH01); 
			break;
		case "btn_downexcel" :
			ComOpenWait(true);
			sheetObj.Down2Excel(1, false, false, true, "", "", false, false, "", false, "");
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
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
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

	axon_event.addListener("keypress", "cntr_no_input", "cntrno_disp");
	axon_event.addListener("keyup", "cntr_no_input", "cntrno_disp");
	axon_event.addListener("change", "cntr_no_input", "cntrno_disp");
	axon_event.addListener("change", "rcc_cd_Change", "rcc_cd");
	axon_event.addListener("keyup", "yard_cd1_Keyup", "yard_cd1");
	axon_event.addListener("blur", "date_focusout", "cre_from_dt");
	axon_event.addListener("blur", "date_focusout", "cre_to_dt");
	axon_event.addListener("blur", "date_focusout", "vgm_vrfy_from_dt");
	axon_event.addListener("blur", "date_focusout", "vgm_vrfy_to_dt");
	axon_event.addListener("keypress", "bkg_no_input", "bkgNoDisp");
	axon_event.addListener("keyup", "bkg_no_input", "bkgNoDisp");
	axon_event.addListener("change", "bkg_no_input", "bkgNoDisp");

	classToggle();
	// RCC 조회.
	doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
}

function bkg_no_input(event) {
	document.form.bkg_no.value = document.form.bkgNoDisp.value;
	bkgCntrChange();
}

function cntr_no_input(event) {
	if (document.form.cntrno_disp.value.length > 10) {
		document.form.check_digit.value = document.form.cntrno_disp.value.substr(10, 1);
		document.form.cntrno_disp.value = document.form.cntrno_disp.value.substr(0, 10);
	}

	if (document.form.cntrno_disp.value != "") {
		document.form.cntr_no.value = document.form.cntrno_disp.value + document.form.check_digit.value;
	} else {
		document.form.cntr_no.value = "";
		document.form.check_digit.value = "";
	}
	bkgCntrChange();
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
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;

	switch(sheetNo) {
	case 1 : //sheet1 init
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
			InitRowInfo(2, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(16, 3, 0, true);

			// 헤더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle01 = "Seq.|Container No.|Booking No.|VGM |VGM |VGM |VGM |VGM |VGM |VGM |VGM |Received|Received|Received|Received|Received";
			var HeadTitle02 = "Seq.|Container No.|Booking No.|VGM|Unit|Signature|Method|Verified Date|Reference No.|VGM WPA|VGM VOR|Seq.|Yard|S/P ID|Date(L)|Via";

			// 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle01, true);
			InitHeadRow(1, HeadTitle02, true);

			// 자동 트림하여 조회및 저장
			DataAutoTrim = true;

			// 데이터속성     [ROW, COL,    DATATYPE,  WIDTH,  DATAALIGN,   COLMERGE, SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++,    dtDataSeq, 30,     daCenter,    true,     "seq",	         false,    "",         dfNone,     0,          true,       true);
			InitDataProperty(0, cnt++,    dtData,    80,     daCenter,    true,     "cntr_no",       false,    "",         dfNone,     0,          true,       true);
			InitDataProperty(0, cnt++,    dtData,    80,     daCenter,    true,     "bkg_no",        false,    "",         dfNone,     0,          true,       true);
			InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    false,    "vgm_wgt_qty",   false,    "",         dfNone,     0,          true,       true,    -1,    false,    true,    "VERIFIED GROSS MASS WEIGHT QUANTITY");
			InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    false,    "vrfd_wgt_cd",   false,    "",         dfNone,     0,          true,       true,    -1,    false,    true,    "VGM WEIGHT CODE(KGM:Kilograms, LBR:Pounds)");
			InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    false,    "pty_nm",        false,    "",         dfNone,     0,          true,       true,    -1,    false,    true,    "VGM_SIGNING PERSON");
			InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    false,    "vgm_mzd_tp_cd", false,    "",         dfNone,     0,          true,       true,    -1,    false,    true,    "VGM METHOD(METHOD 1 or METHOD 2)");
			InitDataProperty(0, cnt++,    dtData,    100,    daCenter,    false,    "vgm_vrfy_dt",   false,    "",         dfNone,     0,          true,       true,    -1,    false,    true,    "VGM VERIFICATION DATE");
			InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    false,    "ref_no",        false,    "",         dfNone,     0,          true,       true,    -1,    false,    true,    "VGM_REFERENCE NO");
			InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    false,    "pty_func_cd",   false,    "",         dfNone,     0,          true,       true,    -1,    false,    true,    "TE(Transport Equipment) WEIGHING PARTY(Terminal)");
			InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    false,    "pty_pson_nm",   false,    "",         dfNone,     0,          true,       true,    -1,    false,    true,    "RESPONSE TO TE GROSS MASS VERIFICATION ORDER");
			InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "vgm_seq",       false,    "",         dfNone,     0,          true,       true);
			InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    false,    "pol_yd_cd",     false,    "",         dfNone,     0,          true,       true);
			InitDataProperty(0, cnt++,    dtData,    90,     daCenter,    false,    "smt_nm",        false,    "",         dfNone,     0,          true,       true);
			InitDataProperty(0, cnt++,    dtData,    100,    daCenter,    false,    "cre_locl_dt",   false,    "",         dfNone,     0,          true,       true);
			InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "via",           false,    "",         dfNone,     0,          true,       true);

			ToolTipOption = "balloon:true; width:420; backcolor:#ffffff; forecolor:#14358B; icon:0;";
			CountPosition = 2;
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
		rtn = rtn + "ALL^";
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

		frmObj.f_cmd.value = SEARCHLIST;

		if (frmObj.divflag[0].checked == true) {
			frmObj.p_date1.value = frmObj.cre_from_dt.value.replace(/(-)/gi, "");
			frmObj.p_date2.value = frmObj.cre_to_dt.value.replace(/(-)/gi, "");
		} else if (frmObj.divflag[1].checked == true) {
			frmObj.p_date1.value = frmObj.vgm_vrfy_from_dt.value.replace(/(-)/gi, "");
			frmObj.p_date2.value = frmObj.vgm_vrfy_to_dt.value.replace(/(-)/gi, "");
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

		if (frmObj.yard_cd1.value != "") {
			if (frmObj.yard_cd2.Code === "ALL") {
				frmObj.org_yd_cd.value = frmObj.yard_cd1.value;
			} else {
				frmObj.org_yd_cd.value = frmObj.yard_cd1.value + frmObj.yard_cd2.Code;
			}
		}

		var xml = sheetObj.GetSearchXml("EES_CTM_0468GS.do", FormQueryString(frmObj));
		var rtnValue = xml.split("|$$|");
		if (ComGetTotalRows(rtnValue[0]) == 0 || ComGetTotalRows(rtnValue[0]) < 500) {
			ComBtnDisable("btn_more");
		}
		sheetObjects[0].LoadSearchXml(rtnValue[0], true);
		sheet1_OnClick(sheetObj, sheetObj.SelectRow, "bkg_no"); // SHEET에 조회된 데이터가 있으면 버튼 활성화를 위해 호출
		break;
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
 * Sheet1의 OnSearchEnd 이벤트 처리
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	ComOpenWait(false);
	sheetObjects[0].WaitImageVisible = true;
}

/**
 * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event.
 */
function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
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
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, frmObj, sAction) {
	with (sheetObj) {
		if (sAction == SEARCHLIST) {
			if (frmObj.bkg_no.value.trim() === "" && frmObj.cntr_no.value.trim() === "") {
				if (frmObj.divflag[0].checked == true) {
					if (frmObj.cre_from_dt.value == "" || frmObj.cre_to_dt.value == "") {
						ComShowCodeMessage("COM130403", "Received Date");
						return false;
					} else if (ComGetDaysBetween(frmObj.cre_from_dt.value, frmObj.cre_to_dt.value) > 31) {
						ComShowMessage("Please check period. The maximum period is 31 days");
						return false;
					}
				} else if (frmObj.divflag[1].checked == true) {
					if (frmObj.vgm_vrfy_from_dt.value == "" || frmObj.vgm_vrfy_to_dt.value == "") {
						ComShowCodeMessage("COM130403", "Verified Date");
						return false;
					} else if (ComGetDaysBetween(frmObj.vgm_vrfy_from_dt.value, frmObj.vgm_vrfy_to_dt.value) > 31) {
						ComShowMessage("Please check period. The maximum period is 31 days");
						return false;
					}
				}
			} else {
				if (frmObj.divflag[0].checked == true) {
					if (frmObj.cre_from_dt.value == "" || frmObj.cre_to_dt.value == "") {
						ComShowCodeMessage("COM130403", "Received Date");
						return false;
					} else if (ComGetDaysBetween(frmObj.cre_from_dt.value, frmObj.cre_to_dt.value) > (31 * 6)) {
						ComShowMessage("Please check period. The maximum period is 6 months");
						return false;
					}
				} else if (frmObj.divflag[1].checked == true) {
					if (frmObj.vgm_vrfy_from_dt.value == "" || frmObj.vgm_vrfy_to_dt.value == "") {
						ComShowCodeMessage("COM130403", "Verified Date");
						return false;
					} else if (ComGetDaysBetween(frmObj.vgm_vrfy_from_dt.value, frmObj.vgm_vrfy_to_dt.value) > (31 * 6)) {
						ComShowMessage("Please check period. The maximum period is 6 months");
						return false;
					}
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
			bkgCntrChange();

			if (formObj.cntr_no.value.length > 12) {
				formObj.cntrno_disp.disabled = true;
			} else {
				formObj.cntrno_disp.disabled = false;
			}
			return;
			break;
		case "m_bkg_no" :
			var flag = ComReplaceStr(srcName, "m_", "");
			var orgval = formObj.bkg_no.value;

			var returntitle = "BKG No.";
			var param = "?returnval=" + flag + "&returntitle=" + returntitle+ "&orgval=" + orgval;
			ComOpenPopup("EES_CTM_0469.do" + param, 400, 380, "getBKG_Multi", "1,0,1,1,1,1,1,1,1,1,1,1", true);
			formObj.bkgNoDisp.value = formObj.bkg_no.value.split(",")[0];
			bkgCntrChange();
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
 * 멀티입력 팝업 페이지가 닫힌 후, 호출되는 Opener 함수
 *  - 해당 필드에 멀티 입력값을 설정해준다.
 */
function getBKG_Multi(rArray, return_val) {
	var targObj = eval("document.form." + return_val);
	var retStr = rArray.toString().toUpperCase();
   	ComSetObjValue(targObj, retStr);
}    

/**
 * VGM 항목 보이기/숨기기
 */
function showVgm() {
	if (document.form.show_vgm.checked == true) {
		sheetObjects[0].ColHidden("vrfd_wgt_cd") = false;
		sheetObjects[0].ColHidden("pty_nm") = false;
		sheetObjects[0].ColHidden("vgm_mzd_tp_cd") = false;
		sheetObjects[0].ColHidden("vgm_vrfy_dt") = false;
		sheetObjects[0].ColHidden("ref_no") = false;
		sheetObjects[0].ColHidden("pty_func_cd") = false;
		sheetObjects[0].ColHidden("pty_pson_nm") = false;
	} else {
		sheetObjects[0].ColHidden("vrfd_wgt_cd") = true;
		sheetObjects[0].ColHidden("pty_nm") = true;
		sheetObjects[0].ColHidden("vgm_mzd_tp_cd") = true;
		sheetObjects[0].ColHidden("vgm_vrfy_dt") = true;
		sheetObjects[0].ColHidden("ref_no") = true;
		sheetObjects[0].ColHidden("pty_func_cd") = true;
		sheetObjects[0].ColHidden("pty_pson_nm") = true;
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

/**
 * Toggle 처리
 */
function classToggle() {
	var formObj = document.form;

	formObj.cre_from_dt.className = "input1"; ComEnableObject(formObj.cre_from_dt, false);
	formObj.cre_to_dt.className = "input1"; ComEnableObject(formObj.cre_to_dt, false);
	formObj.vgm_vrfy_from_dt.className = "input1"; ComEnableObject(formObj.vgm_vrfy_from_dt, false);
	formObj.vgm_vrfy_to_dt.className = "input1"; ComEnableObject(formObj.vgm_vrfy_to_dt, false);

	if (formObj.divflag[0].checked == true) {
		ComEnableObject(formObj.cre_from_dt, true);
		formObj.cre_from_dt.className = "input1";
		ComEnableObject(formObj.cre_to_dt, true);
		formObj.cre_to_dt.className = "input1";
	} else if (formObj.divflag[1].checked == true) {
		ComEnableObject(formObj.vgm_vrfy_from_dt, true);
		formObj.vgm_vrfy_from_dt.className = "input1";
		ComEnableObject(formObj.vgm_vrfy_to_dt, true);
		formObj.vgm_vrfy_to_dt.className = "input1";
	}
}

/**
 * Default 날짜 처리
 */
function bkgCntrChange() {
	var formObj = document.form;

	if (formObj.bkg_no.value.trim() === "" && formObj.cntr_no.value.trim() === "") {
		formObj.cre_from_dt.value = formObj.defaultFromDate.value;
		formObj.cre_to_dt.value = formObj.defaultToDate.value;
		formObj.vgm_vrfy_from_dt.value = formObj.defaultFromDate.value;
		formObj.vgm_vrfy_to_dt.value = formObj.defaultToDate.value;
	} else {
		formObj.cre_from_dt.value = formObj.defaultLongFromDate.value;
		formObj.cre_to_dt.value = formObj.defaultLongToDate.value;
		formObj.vgm_vrfy_from_dt.value = formObj.defaultLongFromDate.value;
		formObj.vgm_vrfy_to_dt.value = formObj.defaultLongToDate.value;
	}
}
