/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : VOP_FCM_0063.js
 *@FileTitle : Fuel Consumption Master Table Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.01.23
 *@LastModifier : 이병훈
 *@LastVersion : 1.0
 * 2015.01.23 이병훈
 * 1.0 Creation
 * 
 * History
 * 2015.01.23 이병훈 [CHM-201430612] Fuel Consumption Master table 개발
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
 * @class VOP_FCM_0063 : VOP_FCM_0063 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0063() {
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

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 **** */
	var sheetObject = sheetObjects[0];
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			
			case "btn_Retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
				
			case "btn_New":
				clearAll();
				break;
				
			case "btn_Down_Excel":
				sheetObject.Down2Excel(-1, false, false, true);
				break;
				
			case "btns_Calendar1" :		// From Date
				var cal = new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObj.fm_yrmon, 'yyyy-MM');
				break;
	
			case "btns_Calendar2" :		// To Date
				var cal = new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObj.to_yrmon, 'yyyy-MM');
				break;
				
			case "btn_lane_search":
				openLandCdInquiry(sheetObject);
				break;
				
			case "btn_vessel_search":
				openVslCdInquiry(sheetObject);
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
	var formObj = document.form;
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	initControl();
	formObj.fm_yrmon.value = ComGetNowInfo("ym");
	formObj.to_yrmon.value = ComGetNowInfo("ym");
	processCellHidden();
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다.
 */
function initControl() {
	var formObj = document.form;
	// Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm('click', 'obj_click', formObj);
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
	axon_event.addListenerForm("focus", "obj_activate", formObj);
	axon_event.addListenerForm("deactivate", "obj_deactivate", formObj);
}

/**
 * Click 이벤트 처리
 */
function obj_click() {
	var obj = event.srcElement.name;
	
	if (obj == "chk_sked" || obj == "chk_pf" || obj == "chk_total" || obj == "chk_eeoi") {
		processCellHidden();
	}
}

/**
 * Keypress 이벤트 처리
 */
function obj_keypress() {
	obj = event.srcElement;
	if (obj.dataformat == null) return;
	window.defaultStatus = obj.dataformat;

	switch (obj.dataformat) {
		case "ymd":
			ComKeyOnlyNumber(obj);
			break;
		case "uppernum":
			ComKeyOnlyAlphabet('uppernum');
			break;
	}
}

/**
 * Activate 이벤트 처리
 */
function obj_activate() {
	switch(event.srcElement.name){
		case "fm_yrmon":
		case "to_yrmon":
			ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기
			event.srcElement.select();
		break;
	}
}

/**
 * Deactivate 이벤트 처리
 */
function obj_deactivate() {
	var formObj = document.form;
	var obj = event.srcElement;

	switch (obj.name) {
		case "fm_yrmon":	//Month
			if (formObj.fm_yrmon.value!="") {
				formObj.fm_yrmon.value = ComGetMaskedValue(formObj.fm_yrmon.value, "ym");
			}
			ComChkObjValid(event.srcElement);
			
			if (formObj.fm_yrmon.value!="" && formObj.to_yrmon.value!="") {
				var fmYrmon = ComReplaceStr(formObj.fm_yrmon.value,"-","");
				var toYrmon = ComReplaceStr(formObj.to_yrmon.value,"-","");
				if (Number(fmYrmon)>Number(toYrmon)) {
					ComShowMessage("Please Check Period.");
					formObj.fm_yrmon.value="";
					formObj.fm_yrmon.focus();
				}
			}
		break;
		
		case "to_yrmon":	//Month
			if (formObj.to_yrmon.value!="") {
				formObj.to_yrmon.value = ComGetMaskedValue(formObj.to_yrmon.value, "ym");
			}
			ComChkObjValid(event.srcElement);
			
			if (formObj.fm_yrmon.value!="" && formObj.to_yrmon.value!="") {
				var fmYrmon = ComReplaceStr(formObj.fm_yrmon.value,"-","");
				var toYrmon = ComReplaceStr(formObj.to_yrmon.value,"-","");
				if (Number(fmYrmon)>Number(toYrmon)) {
					ComShowMessage("Please Check Period.");
					formObj.to_yrmon.value="";
					formObj.to_yrmon.focus();
				}
			}
		break;
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	
	case 1:
		with (sheetObj) {
			
			// 높이 설정
			style.height = 430;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") {
				InitHostInfo(location.hostname, location.port, page_path);
			}
			
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, false, false, true, false, false);
			
			var HeadTitle1 = "REV. Month Fuel Consumption Data|REV. Month Fuel Consumption Data|REV. Month Fuel Consumption Data|REV. Month Fuel Consumption Data|REV. Month Fuel Consumption Data|REV. Month Fuel Consumption Data|REV. Month Fuel Consumption Data|REV. Month Fuel Consumption Data|REV. Month Fuel Consumption Data|REV. Month Fuel Consumption Data|REV. Month Fuel Consumption Data|REV. Month Fuel Consumption Data|REV. Month Fuel Consumption Data"
					+ "|SKED|SKED|SKED|SKED|SKED|SKED|SKED"
					+ "|P/F SKED|P/F SKED|P/F SKED|P/F SKED|P/F SKED|P/F SKED|P/F SKED|P/F SKED|P/F SKED|P/F SKED"
					+ "|CONSUMPTION|CONSUMPTION|CONSUMPTION"
					+ "|Total Summary - Departure Report|Total Summary - Departure Report|Total Summary - Departure Report|Total Summary - Departure Report|Total Summary - Departure Report|Total Summary - Departure Report|Total Summary - Departure Report|Total Summary - Departure Report|Total Summary - Departure Report"
					+ "|BSA|D.Capa|O/C|구분|EEOI|EEOI";
			var HeadTitle2 = "Year|Rev\nMonth|VESSEL|VOY\nNO.|DIR|Trade|LANE|FO FOC\nQ'ty|FO FOC\nUnit price|FO Amnt\n(USD)|DO FOC\nQ'ty|DO FOC\nUnit price|DO Amnt\n(USD)"
					+ "|Start\nPort|ZD|Start Port\nETA|End\nPort|ZD|End Port\nETA|Voyage\nTime"
					+ "|P/F\nTYPE|TTL\nDISTANCE|SPD\n(P/F)|Sea\nTIME|Buffer\nTIME|C.Speed\n(BUFF)|MANU\nIN|MANU\nOUT|PORT\nTIME|TTL\nTime"
					+ "|FO+DO|SEA|PORT"
					+ "|OBS\nMiles|Miles Eng|Miles In|Miles Out|Miles|Sail time|Port FO|Port DO|AVER.\nSpeed"
					+ "|BSA|D.Capa|O/C|구분|(BSA)|(D.DAPA)";
			
			var headCount = ComCountHeadTitle(HeadTitle1);
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			
			//데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,		60,		daCenter,		false,		"rev_year",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		60,		daCenter,		false,		"rev_month",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		60,		daCenter,		false,		"rev_vessel",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		60,		daCenter,		false,		"rev_voyno",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		40,		daCenter,		false,		"rev_dir",				false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,		false,		"rev_trade",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,		false,		"rev_lane",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		95,		daRight,		false,		"rev_fo_qty",			false,	"",	dfNullFloat,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		95,		daRight,		false,		"rev_fo_price",		false,	"",	dfNullInteger,	0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		95,		daRight,		false,		"rev_fo_amnt",		false,	"",	dfNullInteger,	0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		95,		daRight,		false,		"rev_do_qty",			false,	"",	dfNullFloat,		1,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		95,		daRight,		false,		"rev_do_price",		false,	"",	dfNullInteger,	0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		95,		daRight,		false,		"rev_do_amnt",		false,	"",	dfNullInteger,	0,	false,	false);
			
			// SKED
			InitDataProperty(0, cnt++ , dtData,		60,		daCenter,		false,		"sked_start_port",	false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		30,		daCenter,		false,		"sked_start_zd",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		110,	daCenter,		false,		"sked_start_eta",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		60,		daCenter,		false,		"sked_end_port",	false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		30,		daCenter,		false,		"sked_end_zd",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		110,	daCenter,		false,		"sked_end_eta",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		50,		daRight,		false,		"sked_voyage",		false,	"",	dfNullFloat,		1,	false,	false);
			
			// P/F SKED
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,		false,		"pf_type",				false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		70,		daCenter,		false,		"pf_distance",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,		false,		"pf_spd",				false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,		false,		"pf_sea_time",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,		false,		"pf_buffer_time",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		55,		daCenter,		false,		"pf_cspeed",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,		false,		"pf_manu_in",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,		false,		"pf_manu_out",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,		false,		"pf_port_time",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,		false,		"pf_ttl_time",			false,	"",	dfNone,			0,	false,	false);
			
			// Consumption
			InitDataProperty(0, cnt++ , dtData,		50,		daRight,		false,		"con_fo_do",			false,	"",	dfNullInteger,	0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		50,		daRight,		false,		"con_sea",			false,	"",	dfNullInteger,	0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		50,		daRight,		false,		"con_port",			false,	"",	dfNone,			0,	false,	false);
			
			// Total
			InitDataProperty(0, cnt++ , dtData,		60,		daRight,		false,		"total_obs_mile",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		60,		daRight,		false,		"total_miles_eng",	false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		60,		daRight,		false,		"total_miles_in",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		60,		daRight,		false,		"total_miles_out",	false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		60,		daRight,		false,		"total_miles",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		60,		daRight,		false,		"total_sail_time",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		60,		daRight,		false,		"total_port_fo",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		60,		daRight,		false,		"total_port_do",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		60,		daCenter,		false,		"total_aver_spd",		false,	"",	dfNone,			0,	false,	false);
			
			// EEOI
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,		true,		"eeoi_bsa",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,		true,		"eeoi_dcapa",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,		true,		"eeoi_oc",				false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		100,	daCenter,		true,		"eeoi_gubun",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,		false,		"eeoi_cal_bsa",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,		50,		daCenter,		false,		"eeoi_cal_dcapa",	false,	"",	dfNone,			0,	false,	false);
		}
		
	break;
	}
}

/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch (sAction) {
	case IBSEARCH: // 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
	        
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("VOP_FCM_0063GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchXml(sXml);
			ComOpenWait(false);
		}
		
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {

	switch(sAction){
		case IBSEARCH:
			var fmYrmon = formObj.fm_yrmon.value;
			var toYrmon = formObj.to_yrmon.value;
			
			if (ComChkLen(fmYrmon, 7) != 2) {
				ComShowMessage("Please check, Month");
				formObj.fm_yrmon.focus();
				return false;
			}
			
			if (ComChkLen(toYrmon, 7) != 2) {
				ComShowMessage("Please check, Month");
				formObj.to_yrmon.focus();
				return false;
			}
		break;
	}
	return true;
}

/**
 * New 버튼 처리
 */
function clearAll() {
	sheetObjects[0].Redraw = false;
	sheetObjects[0].RemoveAll();
	sheetObjects[0].Redraw = true;
	
	var formObj = document.form;
	
	formObj.fm_yrmon.value = ComGetNowInfo("ym");
	formObj.to_yrmon.value = ComGetNowInfo("ym");
	formObj.vsl_slan_cd.value = "";
	formObj.vsl_cd.value = "";
	
	formObj.chk_sked.checked = false;
	formObj.chk_pf.checked = false;
	formObj.chk_total.checked = false;
	formObj.chk_eeoi.checked = false;
	processCellHidden();
}

/**
 * Sheet의 Cell Hidden 여부를 처리
 */
function processCellHidden() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	// SKED 체크여부
	if (formObj.chk_sked.checked) {
		sheetObj.ColHidden("sked_start_port") = false;
		sheetObj.ColHidden("sked_start_zd") = false;
		sheetObj.ColHidden("sked_start_eta") = false;
		sheetObj.ColHidden("sked_end_port") = false;
		sheetObj.ColHidden("sked_end_zd") = false;
		sheetObj.ColHidden("sked_end_eta") = false;
		sheetObj.ColHidden("sked_voyage") = false;
	} else {
		sheetObj.ColHidden("sked_start_port") = true;
		sheetObj.ColHidden("sked_start_zd") = true;
		sheetObj.ColHidden("sked_start_eta") = true;
		sheetObj.ColHidden("sked_end_port") = true;
		sheetObj.ColHidden("sked_end_zd") = true;
		sheetObj.ColHidden("sked_end_eta") = true;
		sheetObj.ColHidden("sked_voyage") = true;
	}
	
	// P/F SKED 체크여부
	if (formObj.chk_pf.checked) {
		sheetObj.ColHidden("pf_type") = false;
		sheetObj.ColHidden("pf_distance") = false;
		sheetObj.ColHidden("pf_spd") = false;
		sheetObj.ColHidden("pf_sea_time") = false;
		sheetObj.ColHidden("pf_buffer_time") = false;
		sheetObj.ColHidden("pf_cspeed") = false;
		sheetObj.ColHidden("pf_manu_in") = false;
		sheetObj.ColHidden("pf_manu_out") = false;
		sheetObj.ColHidden("pf_port_time") = false;
		sheetObj.ColHidden("pf_ttl_time") = false;
	} else {
		sheetObj.ColHidden("pf_type") = true;
		sheetObj.ColHidden("pf_distance") = true;
		sheetObj.ColHidden("pf_spd") = true;
		sheetObj.ColHidden("pf_sea_time") = true;
		sheetObj.ColHidden("pf_buffer_time") = true;
		sheetObj.ColHidden("pf_cspeed") = true;
		sheetObj.ColHidden("pf_manu_in") = true;
		sheetObj.ColHidden("pf_manu_out") = true;
		sheetObj.ColHidden("pf_port_time") = true;
		sheetObj.ColHidden("pf_ttl_time") = true;
	}
	
	// Total Summary - Departure report 체크여부
	if (formObj.chk_total.checked) {
		sheetObj.ColHidden("con_fo_do") = false;
		sheetObj.ColHidden("con_sea") = false;
		sheetObj.ColHidden("con_port") = false;
		sheetObj.ColHidden("total_obs_mile") = false;
		sheetObj.ColHidden("total_miles_eng") = false;
		sheetObj.ColHidden("total_miles_in") = false;
		sheetObj.ColHidden("total_miles_out") = false;
		sheetObj.ColHidden("total_miles") = false;
		sheetObj.ColHidden("total_sail_time") = false;
		sheetObj.ColHidden("total_port_fo") = false;
		sheetObj.ColHidden("total_port_do") = false;
		sheetObj.ColHidden("total_aver_spd") = false;
	} else {
		sheetObj.ColHidden("con_fo_do") = true;
		sheetObj.ColHidden("con_sea") = true;
		sheetObj.ColHidden("con_port") = true;
		sheetObj.ColHidden("total_obs_mile") = true;
		sheetObj.ColHidden("total_miles_eng") = true;
		sheetObj.ColHidden("total_miles_in") = true;
		sheetObj.ColHidden("total_miles_out") = true;
		sheetObj.ColHidden("total_miles") = true;
		sheetObj.ColHidden("total_sail_time") = true;
		sheetObj.ColHidden("total_port_fo") = true;
		sheetObj.ColHidden("total_port_do") = true;
		sheetObj.ColHidden("total_aver_spd") = true;
	}
	
	// EEOI 체크여부
	if (formObj.chk_eeoi.checked) {
		sheetObj.ColHidden("eeoi_bsa") = false;
		sheetObj.ColHidden("eeoi_dcapa") = false;
		sheetObj.ColHidden("eeoi_oc") = false;
		sheetObj.ColHidden("eeoi_gubun") = false;
		sheetObj.ColHidden("eeoi_cal_bsa") = false;
		sheetObj.ColHidden("eeoi_cal_dcapa") = false;
	} else {
		sheetObj.ColHidden("eeoi_bsa") = true;
		sheetObj.ColHidden("eeoi_dcapa") = true;
		sheetObj.ColHidden("eeoi_oc") = true;
		sheetObj.ColHidden("eeoi_gubun") = true;
		sheetObj.ColHidden("eeoi_cal_bsa") = true;
		sheetObj.ColHidden("eeoi_cal_dcapa") = true;
	}
}

/**
 * Lane Code Inquiry 팝업을 오픈한다
 */
function openLandCdInquiry(sheetObj) {
	var targetObjList = "sheet1_vsl_slan_cd:vsl_slan_cd";
	var v_display = "0,0";
	var laneCd = document.form.vsl_slan_cd.value;
	ComOpenPopupWithTarget('VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 420, 470, targetObjList, v_display, true);
}

/**
 * Vessel Code Inquiry 팝업을 오픈한다
 */
function openVslCdInquiry(sheetObj) {
	var sUrl = "VOP_VSK_0219.do?vsl_cd="+document.form.vsl_cd.value+"&inc_del_vsl_pop=Y";
	ComOpenPopup(sUrl, 460, 500, "getVslCdData", "0,0", true);
}

/**
 * Vessel Code Inquiry 팝업 후 처리
 */
function getVslCdData(obj) {
	if (obj) {
		var rtnDatas = obj[0];
		if (rtnDatas) {
			if (rtnDatas.length > 0) {
				document.form.vsl_cd.value = rtnDatas[1];
			}
		}
	}
}

/* 개발자 작업 끝 */