/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_SPC_0102.js
 *@FileTitle : Daily Forecast Input
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.27
 *@LastModifier : 최윤성
 *@LastVersion : 1.0
 * 2009.08.27 최윤성
 * 1.0 Creation
 * 2010.07.08 CHOI.Y.S - [프로젝트] Ticket ID : CHM-201004171
 * - [프로젝트] 53FT 관련 필드 추가
 * 2011.06.24 KIM.J.J - [프로젝트] Ticket ID : CHM-201110708-01
 * trade,subtrade,lane 변경시 체크 로직 수정
 * 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
 * 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
 * 2013.06.13 진마리아 SELCDO 팀코드 변경 (SELCTY)
 * 2013.07.16 진마리아 MNLBA->MNLSC 하드코딩 변경
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
 * @class ESM_SPC_0999 : ESM_SPC_0999 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SPC_0999() {
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
var comObjects = new Array();
var sheetCnt = 0;
var comboCnt = 0;
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
// sheetResizeFull = true;
// type check
var type_check;
// retrive check
var check_retrive = false;
var tab_retrives = null;
var searchParams = "";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

var init_year = '';
var init_week = '';
var init_duration = '';
var init_salesOffice = '';
var init_subOffice = '';
var init_salesRep = '';




/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[beforetab], formObject, IBSEARCH);
			break;

		case "btn_new":
			if (checkModifiedSheet(sheetObjects)) {
				if (ComShowConfirm(getMsg("SPC90001")) != 1) {
					return;
				}
			}

			// 공통함수사용: 화면을 초기화
			resetAll();
			searchSalesRep = new Array();
			ComBtnDisable("btng_addAccount2");

			formObject.year.value = init_year;
			formObject.week.value = init_week;
			formObject.duration.value = init_duration;
			document.getElementById("salesOffice").Code2 = init_salesOffice;
			document.getElementById("subOffice").Code2 = init_subOffice;
			document.getElementById("salesRep").Code2 = init_salesRep;
			subOffice_OnChange(document.getElementById("subOffice"), init_subOffice, init_subOffice );
			SpcSearchOptionWeek("week",false,document.form.year.value);
			
			SpcSearchOptionTrade("trade", true, true);
			SpcSearchOptionSubTrade("subtrade", true, false);
			SpcSearchOptionLane("lane", true, true);// 0207 SHKIM 
			break;

		case "btn_save":
			// Data변화없이 Save버튼을 클릭한 경우 doActionIBSheet2로 처리한다.
			if (sheetObjects[beforetab].isDataModified == false)
				doActionIBSheet2(sheetObjects[beforetab], formObject, IBSAVE);
			else
				doActionIBSheet(sheetObjects[beforetab], formObject, IBSAVE);
			break;

		case "btn_confirm":
			confirmData(sheetObjects[beforetab], formObject);
			break;

		case "btn_downexcel":
			doActionIBSheet(sheetObjects[beforetab], formObject, IBDOWNEXCEL);
			break;

		case "btng_addAccount2":
			accountAddDelete();
			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("COM12111");
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setComboObject(combo_obj) {
	comObjects[comboCnt++] = combo_obj;
}

/**
 * IBTab Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}

/**
 * tab1_OnChange
 */
function tab1_OnChange(tabObj, nItem) {
	var formObj = document.form;

	var objs = document.all.item("tabLayer");
	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	// --------------- 여기가 중요--------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab = nItem;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	SpcSearchOptionYear("year");
	SpcSearchOptionWeek("week");
	SpcSearchOptionDuration("duration", 5, 4);
	SpcSearchOptionTrade("trade", true, true);
	SpcSearchOptionSubTrade("subtrade", true, false);
	SpcSearchOptionLane("lane", true, true);
	SpcSearchOptionBound("bound", false, true, false, true);

	tab_retrives = new Array(sheetObjects.length);
	var tdisp = "block";
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		tdisp = tabLayer[i].style.display;
		tabLayer[i].style.display = "block";
		initSheet(sheetObjects[i], i + 1);
		tabLayer[i].style.display = tdisp;
		ComEndConfigSheet(sheetObjects[i]);
		initDataSelection(i);
	}

	var sheetResizeFull = true;
	document_onresize();

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}

	beforetab = 1;

	var formObject = document.form;
	var comObj = document.getElementById("salesOffice");
	if (comObj.GetCount() <= 1) {
		comObj.Index = 0;
		var comObj1 = document.getElementById("subOffice");
		if (comObj.Code != comObj1.Code) {
			comObj1.Enable = false;
		}
	}

	ComBtnDisable("btng_addAccount2");
	showDataSelectionItem("divDs2CFM", true);

	var value = "";
	var include = "";

	if (ofc_cd == "SELCTY" || ofc_cd == "SELCDO" || ofc_cd == "SINRS") {
		value = "SELHO";
	} else if (ofc_cd == "SHARCS" || ofc_cd == "SHARCC" || ofc_cd == "SHARCO") {
		value = "SHARC";
	} else if (ofc_cd == "HAMRUS" || ofc_cd == "HAMRUC" || ofc_cd == "HAMRUO") {
		value = "HAMRU";
	} else if (ofc_cd == "NYCRAS" || ofc_cd == "NYCRAC" || ofc_cd == "NYCRAO") {
		value = "NYCRA";
	} else if (ofc_cd == "SINRSS" || ofc_cd == "SINRSO" || ofc_cd == "SINRSC") {
		value = "SHARC";
	} else if (ofc_cd == "JKTSC" || ofc_cd == "JKTBA") {
		value = "JKTBA";
	} else if (ofc_cd == "MNLSC" || ofc_cd == "MNLBA") {
		value = "MNLSC";
	} else if (ofc_cd == "PHXSA" || ofc_cd == "LGBSC") {
		value = "LGBSC";
	} else if (ofc_cd == "PKGSA" || ofc_cd == "PKGSC") {
		value = "PKGSC";
	} else if (ofc_cd == "SELSA" || ofc_cd == "SELSC") {
		value = "SELSC";
	} else if (ofc_cd == "SLCSC" || ofc_cd == "SEASC") {
		value = "SEASC";
	} else if ("HO|HQ|AQ|BB|BS|BA".indexOf(ofc_tp_cd) < 0) {
		value = ofc_cd;
	}

	var rtn = getCodeList("ChildOffice", "ofc_cd=" + value + "&level=4");
	initData_salesOffice(rtn[0].split("|"), rtn[1].split("|"));

	// 탭관련 설정
	if (document.getElementById("salesOffice").Enable == false)
		document.getElementById("salesOffice").tabIndex = 1;
	if (document.getElementById("subOffice").Enable == false)
		document.getElementById("subOffice").tabIndex = 1;
	if (document.getElementById("salesRep").Enable == false)
		document.getElementById("salesRep").tabIndex = 1;

	// if(isDevMode){
	// formObject.week.value = "08";
	// formObject.duration.value = 1;
	// formObject.vvd.value = "HNBN0028E";//"HJTN0006W";
	// document.getElementById("trade").Code = "TPS";
	// document.getElementById("subTrade").Code = "PS";
	// document.getElementById("lane").Code = "PSXTP";
	// document.getElementById("salesOffice").Code = "SELSC";
	// document.getElementById("subOffice").Code = "";
	// document.getElementById("salesRep").Code = "KR016";
	// document.all.id_chk_ocn.checked = true;
	// document.all.ds2OTH.checked = false;
	// document.all.ds2HC.checked = false;
	// document.all.ds245.checked = false;
	// document.all.ds253.checked = false;
	// document.all.ds2RF.checked = false;
	// document.all.ds2WT.checked = false;
	// document.all.ds2BKG.checked = false;
	// document.all.ds2WT.checked = false;
	// document.all.ds2INF.checked = true;
	// changeDataSelection(document.getElementsByName("chkDs2INF")[0]);
	// showDataSelectionItem("divDs2CFM", true);
	// showDataSelectionItem("divDs2INF", true);
	// }

	// 테스트용
	// if(hostname == "localhost"){
	// formObject.year.value = "2008";
	// formObject.week.value = "45";
	// formObject.duration.value = 1;
	// document.getElementById("trade").Code = "TPS";
	// document.getElementById("lane").Code = "PSXTP";
	// document.all.id_chk_ts.checked = true;
	// document.getElementById("salesOffice").Code = "SELSC";
	// formObject.vvd.value = "HJBH0021W";
	// doActionIBSheet(sheetObjects[beforetab], formObject, IBSEARCH);
	// }

	formObject.duration.value = 1;	
	comObjects[0].Code = 'TPS';
	comObjects[1].Code = 'PS';
	comObjects[2].Code = 'PSXTP';
	comObjects[3].Code = 'SELSC';
	comObjects[5].Code = 'KR016';
		
	// 포커싱
	formObject.year.focus();

	init_year = formObject.year.value; // 년 초기화용
	init_week = formObject.week.value; // 주차 초기화용
	init_duration = formObject.duration.value; // duration 초기화용
	init_salesOffice = document.getElementById("salesOffice").Code;
	init_subOffice = document.getElementById("subOffice").Code;
	init_salesRep = document.getElementById("salesRep").Code;

}

/**
 * id에 해당하는 Object를 show option에 따라 Display
 */
function showDataSelectionItem(id, show) {
	var objs = document.all[id];

	for ( var i = 0; i < objs.length; i++) {
		objs[i].style.display = show ? "" : "none";
	}
}

/**
 * Tab 기본 설정 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {

	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertTab(cnt++, "By Port", -1);
			InsertTab(cnt++, "By Account", -1);
		}
		break;
	}

	var objs = document.all.item("tabLayer");
	objs[1].style.display = "Inline";
	objs[0].style.display = "none";
	objs[0].style.zIndex = objs[1].style.zIndex - 1;

	var tabObj = document.getElementById("tabObj");
	tabObj.style.display = "none";
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init
		initSheet1(sheetObj);
		break;

	case 2: // sheet1 init
		initSheet2(sheetObj, document.form.year.value
				+ document.form.week.value + "|TTL", true);
		break;

	case 3: // sheet1 init
		initSheet3(sheetObj);
		break;
	}
}

/**
 * TabSheet1에서 조회후 타이틀 변경
 */
function initSheet1(sheetObj) {
	with (sheetObj) {
		// 높이 설정
		style.height = 100;
		// 전체 너비 설정
		SheetWidth = mainTable[beforetab].clientWidth;
	}
}

/**
 * TabSheet2에서 조회후 타이틀 변경
 */
var sheet2 = new Object();
function initSheet2(sheetObj, weeks, isInit) {
	if (isInit == undefined) {
		isInit = false;
	}

	with (sheetObj) {
		// 높이 설정
		// style.height = getSheetHeight(17);
		style.height = getSheetHeight(18);
		// 전체 너비 설정
		SheetWidth = mainTable[1].clientWidth;
		// Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "")
			InitHostInfo(location.hostname, location.port, page_path);
		// 전체Merge 종류 [선택, Default msNone]
		MergeSheet = msPrevColumnMerge;
		// 전체Edit 허용 여부 [선택, Default false]
		var comObj = document.getElementById("salesOffice");
		// RGN Office 검색조건 목록이 1개인 경우 RGN Office이거나 Sub Office
		// 상위 Office가 들어온 경우 RGN Office가 1개 이상이므로 조회만 가능하도록 변경
		Editable = true;//(comObj.GetCount() == 1) || isDevMode;
		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(4, 1, 9, 100);

		var HeadTitle1 = "Trade|Sub\nTrade|Lane|BD|OCN\nIPC\nTS|Office|Sub\nOffice|Sales Rep|Sales Rep|Week|Week|Week|Week|Week|";
		var HeadTitle2 = "Trade|Sub\nTrade|Lane|BD|OCN\nIPC\nTS|Office|Sub\nOffice|Code|Name|Account|Account|Account|Port|Port|";
		var HeadTitle3 = "Trade|Sub\nTrade|Lane|BD|OCN\nIPC\nTS|Office|Sub\nOffice|Code|Name|Type|Code|Name|POL|POD|";
		var HeadTitle4 = "||||||||||||||";
		var HeadTitleInfo = "TRD|STRD|Lane|BD|V| V |D|IOC|SREP|CUST|SEQ|POL|POD|OFC|CTP|CFM|CTRL|C_FLG|IB|";
		var HeadTail = "Tree|Flag|ILane|IRep|IPol";
		sheet2.masterColumnCount = HeadTitle1.split("|").length - 1;
		sheet2.forecastColumnCount = 7;// 5; //Total, TEU, hc, 45, 53, rf, wt
		sheet2.confirmColumnCount = 7;// 5;//TEU, hc, 45, 53, rf, wt
		sheet2.bookingColumnCount = 8;
		sheet2.infoColumnCount = HeadTitleInfo.split("|").length - 1;
		var weekArr = weeks.split("|");
		sheet2.weekCount = weekArr.length;
		sheet2.tailColumnCount = HeadTail.split("|").length + 1;
		sheet2.itemColumnCount = sheet2.forecastColumnCount
				+ sheet2.confirmColumnCount + sheet2.bookingColumnCount
				+ sheet2.infoColumnCount;
		sheet2.columnCount = sheet2.masterColumnCount + sheet2.itemColumnCount
				* sheet2.weekCount + sheet2.tailColumnCount;
		sheet2.conformColorDif = sheet2.bookingColumnCount
				+ sheet2.forecastColumnCount;

		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(sheet2.columnCount, sheet2.masterColumnCount, 0, false);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(false, true, true, true, false, false);

		for ( var i = 0; i < sheet2.weekCount; i++) {
			for ( var j = 0; j < sheet2.infoColumnCount; j++) {
				HeadTitle1 = HeadTitle1 + weekArr[i] + "|";
				HeadTitle2 = HeadTitle2 + "|";
				HeadTitle4 = HeadTitle4 + "|";
			}

			HeadTitle3 = HeadTitle3
					+ HeadTitleInfo
					+ "Total TEU|TEU|HC|45|53'|RF|WT|Total TEU|20|40|HC|45|53'|RF|WT|Total TEU|TEU|HC|45|53'|RF|WT|";
			for ( var k = 0; k < sheet2.forecastColumnCount; k++) {
				HeadTitle1 = HeadTitle1 + weekArr[i] + "|";
				HeadTitle2 = HeadTitle2 + "F'cast|";
				HeadTitle4 = HeadTitle4 + "|";
			}
			for ( var m = 0; m < sheet2.bookingColumnCount; m++) {
				HeadTitle1 = HeadTitle1 + weekArr[i] + "|";
				HeadTitle2 = HeadTitle2 + "BKG|";
				HeadTitle4 = HeadTitle4 + "|";
			}
			for ( var n = 0; n < sheet2.confirmColumnCount; n++) {
				HeadTitle1 = HeadTitle1 + weekArr[i] + "|";
				HeadTitle2 = HeadTitle2 + "Confirmed|";
				HeadTitle4 = HeadTitle4 + "|";
			}
		}

		HeadTitle3 = HeadTitle3 + HeadTail;
		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);
		InitHeadRow(1, HeadTitle2, true);
		InitHeadRow(2, HeadTitle3, true);
		InitHeadRow(3, HeadTitle4, true);

		var cnt = 0;
		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
		// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,
		// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
		// FORMATFIX]
		InitDataProperty(0, cnt++, dtData, 45, daCenterTop, true, "d_trd_cd",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 45, daCenterTop, true,
				"d_sub_trd_cd", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 50, daCenterTop, true, "d_rlane_cd",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 20, daCenterTop, true, "d_dir_cd",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true,
				"d_ioc_ts_cd", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 50, daCenterTop, true,
				"d_rgn_ofc_cd", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 50, daCenterTop, true,
				"d_sub_ofc_cd", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 50, daCenterTop, true,
				"d_srep_usr_id", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 100, daLeftTop, true,
				"d_srep_usr_nm", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true,
				"d_fcast_cust_tp_cd", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 50, daCenterTop, true, "d_cust_cd",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 100, daLeftTop, true, "d_cust_nm",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 60, daCenterTop, true, "d_pol_cd",
				false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "d_pod_cd",
				false, "", dfNone, 0, false, false);

		for ( var p = 0; p < sheet2.weekCount; p++) {
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "trd_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false,
					"sub_trd_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false,
					"rlane_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "dir_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "vsl_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false,
					"skd_voy_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false,
					"skd_dir_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false,
					"ioc_ts_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false,
					"srep_usr_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false,
					"cust_cnt_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false,
					"cust_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "pol_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "pod_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false,
					"fcast_ofc_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false,
					"fcast_cust_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "cfm_dt",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false,
					"ctrl_lvl_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false,
					"flag_col", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "ibflag",
					false, "", dfNone, 0, false, false);

			// 추가
			// |fcast_20ft_qty|+|fcast_40ft_qty*2|+|fcast_40ft_hc_qty*2|+|fcast_45ft_hc_qty*2|+|fcast_53ft_qty*2|
			InitDataProperty(0, cnt++, dtData, 60, daRight, false,
					"fcast_ttl_teu_qty", false, "", dfNullInteger, 0, false,
					false);
			MinimumValue(0, cnt - 1) = 0;
			InitDataProperty(0, cnt++, dtData, 40, daRight, false,
					"fcast_ttl_qty", false, "", dfNullInteger, 0, false, false);
			MinimumValue(0, cnt - 1) = 0;
			InitDataProperty(0, cnt++, dtData, 40, daRight, false,
					"fcast_40ft_hc_qty", false, "", dfNullInteger, 0, false,
					false);
			MinimumValue(0, cnt - 1) = 0;
			InitDataProperty(0, cnt++, dtData, 40, daRight, false,
					"fcast_45ft_hc_qty", false, "", dfNullInteger, 0, false,
					false);
			MinimumValue(0, cnt - 1) = 0;
			InitDataProperty(0, cnt++, dtData, 40, daRight, false,
					"fcast_53ft_qty", false, "", dfNullInteger, 0, false, false);
			MinimumValue(0, cnt - 1) = 0;
			InitDataProperty(0, cnt++, dtData, 40, daRight, false,
					"fcast_rf_qty", false, "", dfNullInteger, 0, false, false);
			MinimumValue(0, cnt - 1) = 0;
			InitDataProperty(0, cnt++, dtData, 40, daRight, false,
					"fcast_ttl_wgt", false, "", dfNullInteger, 0, false, false);
			MinimumValue(0, cnt - 1) = 0;
			InitDataProperty(0, cnt++, dtData, 60, daRight, false,
					"usd_bkg_ttl_qty", false, "", dfNullInteger, 0, false,
					false);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false,
					"usd_bkg_20ft_qty", false, "", dfNullInteger, 0, false,
					false);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false,
					"usd_bkg_40ft_qty", false, "", dfNullInteger, 0, false,
					false);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false,
					"usd_bkg_40ft_hc_qty", false, "", dfNullInteger, 0, false,
					false);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false,
					"usd_bkg_45ft_hc_qty", false, "", dfNullInteger, 0, false,
					false);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false,
					"usd_bkg_53ft_qty", false, "", dfNullInteger, 0, false,
					false);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false,
					"usd_bkg_rf_qty", false, "", dfNullInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false,
					"usd_bkg_ttl_wgt", false, "", dfNullInteger, 0, false,
					false);
			// 추가
			// |cfm_20ft_qty|+|cfm_40ft_qty*2|+|cfm_40ft_hc_qty*2|+|cfm_45ft_hc_qty*2|+|cfm_53ft_qty*2|
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false,
					"cfm_ttl_teu_qty", false, "", dfNullInteger, 0, false,
					false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, false,
					"cfm_ttl_qty", false, "", dfNullInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false,
					"cfm_40ft_hc_qty", false, "", dfNullInteger, 0, false,
					false);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false,
					"cfm_45ft_hc_qty", false, "", dfNullInteger, 0, false,
					false);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false,
					"cfm_53ft_qty", false, "", dfNullInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false,
					"cfm_rf_qty", false, "", dfNullInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false,
					"cfm_ttl_wgt", false, "", dfNullInteger, 0, false, false);
		}

		InitDataProperty(0, cnt++, isDevMode ? dtData : dtHidden, 50, daLeft,
				true, "treeLevel", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, isDevMode ? dtStatus : dtHiddenStatus, 50,
				daCenter, true, "editFlg", false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, isDevMode ? dtData : dtHidden, 40, daRight,
				true, "rowLane", false, "", dfNullInteger, 0, false, false);
		InitDataProperty(0, cnt++, isDevMode ? dtData : dtHidden, 40, daRight,
				true, "rowRep", false, "", dfNullInteger, 0, false, false);
		InitDataProperty(0, cnt++, isDevMode ? dtData : dtHidden, 40, daRight,
				true, "rowPol", false, "", dfNullInteger, 0, false, false);
		HeadRowHeight = 10;
		InitTreeInfo(sheet2.columnCount - sheet2.tailColumnCount, "sLevel",
				RgbColor(0, 0, 255), false);
		EditableColor = RgbColor(255, 255, 128); // Default:255,255,255, 흰색
													// Edit 가능 데이터 배경색
		UnEditableColor = RgbColor(255, 255, 255); // Default:239,235,239, 회색
													// Edit 불가능 데이터 배경색
		EditableColorDiff = false;
		var backColor = RgbColor(222, 251, 248);
		RangeBackColor(1, 7, 2, sheet2.columnCount - sheet2.tailColumnCount) = backColor;
		RangeBackColor(2, sheet2.masterColumnCount, 2, sheet2.columnCount
				- sheet2.tailColumnCount) = RgbColor(202, 251, 220);
		RangeBackColor(3, 0, 3, sheet2.columnCount - 1) = getColor(0);
		RowHidden(3) = isInit;
	}
}

function t1sheet2_OnClick(sheetObj, row, col) {
	switch (sheetObj.ColSaveName(col)) {
	case "d_pol_cd":
	case "d_pod_cd":
		var mark = sheetObj.CellValue(row, col);
		if (mark == "+" || mark == "-") {
			toggleExpand(sheetObj, row, col);
		}
		break;
	}
}

function toggleExpand(sheetObj, row, col) {
	var mark = sheetObj.CellValue(row, col);
	if (sheetObj.RowExpanded(row)) {
		sheetObj.RowExpanded(row) = false;
		ChangeValue2(sheetObj, row, col, "+");
	} else {
		sheetObj.RowExpanded(row) = true;
		ChangeValue2(sheetObj, row, col, "-");
	}
}

function initDataSelection(sheetNo) {
	if (sheetNo == 1) {
		changeDataSelection(document.getElementsByName("chkDs2LaneInfo")[0]);
		changeDataSelection(document.getElementsByName("chkDs2Office")[0]);
		changeDataSelection(document.getElementsByName("chkDs2Account")[0]);
		changeDataSelection(document.getElementsByName("chkDs2POD")[0]);
		// 수행시(chkDs2BKG) 내부적으로 changeDataSelectionTpSzAll를 호출함(OTH, HC, 45, 53,
		// RF, WT 재호출)
		changeDataSelection(document.getElementsByName("chkDs2BKG")[0]);
		// 수행시(chkDs2CFM) 내부적으로 changeDataSelectionTpSzAll를 호출함(OTH, HC, 45, 53,
		// RF, WT 재호출)
		changeDataSelection(document.getElementsByName("chkDs2CFM")[0]);
		changeDataSelection(document.getElementsByName("chkDs2INF")[0]);
		changeDataSelection(document.getElementsByName("chkDs2OTH")[0]);
		changeDataSelection(document.getElementsByName("chkDs2HC")[0]);
		changeDataSelection(document.getElementsByName("chkDs245")[0]);
		changeDataSelection(document.getElementsByName("chkDs253")[0]);
		changeDataSelection(document.getElementsByName("chkDs2RF")[0]);
		changeDataSelection(document.getElementsByName("chkDs2WT")[0]);
	}
}

function accountAddDelete() {
	var sheetObj = sheetObjects[beforetab];
	var row = sheetObj.SelectRow;
	var srep_id = ComTrim(sheetObj.CellValue(row, "d_srep_usr_id"));
	if (srep_id == "") {
		ComShowCodeMessage("COM12113", "Sales Rep");
		return;
	}
	var param = "srep_id=" + srep_id;
	param = param + "&srep_nm=" + sheetObj.CellValue(row, "d_srep_usr_nm");
	param = param + "&rlane_cd=" + sheetObj.CellValue(row, "d_rlane_cd");
	param = param + "&trd_cd=" + sheetObj.CellValue(row, "d_trd_cd");
	param = param + "&sub_trd_cd=" + sheetObj.CellValue(row, "d_sub_trd_cd");
	param = param + "&bound=" + sheetObj.CellValue(row, "d_dir_cd");
	param = param + "&rgn_ofc_cd=" + sheetObj.CellValue(row, "d_rgn_ofc_cd");
	param = param + "&sub_ofc_cd=" + sheetObj.CellValue(row, "d_sub_ofc_cd");
	param = param + "&ioc_cd=" + sheetObj.CellValue(row, "d_ioc_ts_cd");
	param = param + "&acc_tp=" + sheetObj.CellValue(row, "d_fcast_cust_tp_cd");
	var rtn = window
			.showModalDialog(
					"ESM_SPC_0103.do?" + param,
					null,
					"dialogHeight:450px;dialogWidth:500px;center:yes;resizable:no;scroll:no;status:no;unadorned:yes;");
	if (rtn == "OK") {
		var formObject = document.form;
		doActionIBSheet(sheetObjects[beforetab], formObject, IBSEARCH);
	}
}

function changeDataSelection(tobj, internal) {
	if (internal == undefined || internal == null) {
		internal == false;
	}

	var sheetObj = sheetObjects[beforetab];
	var obj = null;
	if (tobj == undefined || tobj == null) {
		tobj = null;
		obj = event.srcElement;
	} else {
		obj = tobj;
	}

	var sts = obj.checked;

	/*
	 * 1-,0:20/40 1:HC 2:45 3:53 4:RF 5:WG
	 */
	switch (obj.name) {
	case "chkDs2LaneInfo":
		sheetObj.ColHidden("d_trd_cd") = !sts;
		sheetObj.ColHidden("d_sub_trd_cd") = !sts;
		sheetObj.ColHidden("d_dir_cd") = !sts;
		sheetObj.ColHidden("d_ioc_ts_cd") = !sts;
		break;

	case "chkDs2Office":
		sheetObj.ColHidden("d_rgn_ofc_cd") = !sts;
		sheetObj.ColHidden("d_sub_ofc_cd") = !sts;
		break;

	case "chkDs2Account":
		sheetObj.ShowTreeLevel(sts ? 3 : 2, 0);
		sheetObj.ColHidden("d_fcast_cust_tp_cd") = !sts;
		sheetObj.ColHidden("d_cust_cd") = !sts;
		sheetObj.ColHidden("d_cust_nm") = !sts;
		sheetObj.ColHidden("d_pol_cd") = !sts;

		if (!sts) {
			document.all.ds2POD.checked = false;
			changeDataSelection(document.all.ds2POD, true);
		}
		break;

	case "chkDs2POD":
		if (!internal) {
			if (!document.all.ds2Account.checked) {
				document.all.ds2Account.checked = true;
				changeDataSelection(document.all.ds2Account);
			}
			sheetObj.ShowTreeLevel(sts ? 4 : 3, 0);
		}

		sheetObj.ColHidden("d_pod_cd") = !sts;
		if (sts) {
			ChangeValues2(sheetObj, "d_pod_cd", "+", "d_pod_cd", "-");
		}
		ChangeValues2(sheetObj, "d_pol_cd", "+", "d_pol_cd", "-");
		break;

	case "chkDs2OTH":
		/*
		 * 20/40 F'cast = TotalTEU(), TEU(O), HC(), 45(), 53(), RF(), WT() BKG =
		 * TEU(O), 20(O), 40(O), HC(), 45(), 53(), RF(), WT() Confirmed= TEU(O),
		 * HC(), 45(), 53(), RF(), WT()
		 */
		hiddenTypeSize(sheetObj, sheet2, -1, sts);
		hiddenTypeSize(sheetObj, sheet2, 0, sts);
		break;

	case "chkDs2HC":
		/*
		 * HC F'cast = TotalTEU(O), TEU(O), HC(O), 45(), 53(), RF(), WT() BKG =
		 * TEU(O), 20(), 40(), HC(O), 45(), 53(), RF(), WT() Confirmed= TEU(O),
		 * HC(O), 45(), 53(), RF(), WT()
		 */
		hiddenTypeSize(sheetObj, sheet2, 1, sts);
		break;

	case "chkDs245":
		/*
		 * 45 F'cast = TotalTEU(O), TEU(O), HC(), 45(O), 53(), RF(), WT() BKG =
		 * TEU(O), 20(), 40(), HC(), 45(O), 53(), RF(), WT() Confirmed= TEU(O),
		 * HC(), 45(O), 53(), RF(), WT()
		 */
		hiddenTypeSize(sheetObj, sheet2, 2, sts);
		break;

	case "chkDs253":
		/*
		 * 53 F'cast = TotalTEU(O), TEU(O), HC(), 45(), 53(O), RF(), WT() BKG =
		 * TEU(O), 20(), 40(), HC(), 45(), 53(O), RF(), WT() Confirmed= TEU(O),
		 * HC(), 45(), 53(O), RF(), WT()
		 */
		hiddenTypeSize(sheetObj, sheet2, 3, sts);
		break;

	case "chkDs2RF":
		/*
		 * RF F'cast = TotalTEU(), TEU(O), HC(), 45(O), 53(), RF(O), WT() BKG =
		 * TEU(O), 20(), 40(), HC(), 45(), 53(), RF(O), WT() Confirmed= TEU(O),
		 * HC(), 45(), 53(), RF(O), WT()
		 */
		hiddenTypeSize(sheetObj, sheet2, 4, sts);
		break;

	case "chkDs2WT":
		/*
		 * WT F'cast = TotalTEU(), TEU(O), HC(), 45(O), 53(), RF(), WT(O) BKG =
		 * TEU(O), 20(), 40(), HC(), 45(), 53(), RF(), WT(O) Confirmed= TEU(O),
		 * HC(), 45(), 53(), RF(), WT(O)
		 */
		hiddenTypeSize(sheetObj, sheet2, 5, sts);
		break;

	case "chkDs2BKG":
		for ( var i = 0; i < sheet2.weekCount; i++) {
			var sCol = sheet2.masterColumnCount + sheet2.itemColumnCount * i
					+ sheet2.infoColumnCount + sheet2.forecastColumnCount;
			for ( var c = 0; c < sheet2.bookingColumnCount; c++) {
				sheetObj.ColHidden(sCol + c) = !sts;
			}
		}

		if (tobj == undefined || tobj == null || sts) {
			changeDataSelectionTpSzAll(2);
		}
		break;

	case "chkDs2CFM":
		for ( var i = 0; i < sheet2.weekCount; i++) {
			var sCol = sheet2.masterColumnCount + sheet2.itemColumnCount * i
					+ sheet2.itemColumnCount - sheet2.confirmColumnCount;
			for ( var c = 0; c < sheet2.confirmColumnCount; c++) {
				sheetObj.ColHidden(sCol + c) = !sts;
			}
		}

		if (tobj == undefined || tobj == null || sts) {
			changeDataSelectionTpSzAll(2);
		}
		break;

	case "chkDs2INF":
		for ( var i = 0; i < sheet2.weekCount; i++) {
			var sCol = sheet2.masterColumnCount + sheet2.itemColumnCount * i
					+ sheet2.infoColumnCount;
			sheetObj.ColHidden(sCol - 1) = !sts;
			sheetObj.ColHidden(sCol - 2) = !sts;
			sheetObj.ColHidden(sCol - 4) = !sts;
			sheetObj.ColHidden(sCol - 13) = !sts;
			sheetObj.ColHidden(sCol - 14) = !sts;
			sheetObj.ColHidden(sCol - 15) = !sts;
		}
		break;
	}
}

function changeDataSelectionTpSzAll(idx) {
	changeDataSelection(document.getElementsByName("chkDs" + idx + "OTH")[0]);
	changeDataSelection(document.getElementsByName("chkDs" + idx + "HC")[0]);
	changeDataSelection(document.getElementsByName("chkDs" + idx + "45")[0]);
	changeDataSelection(document.getElementsByName("chkDs" + idx + "53")[0]);
	changeDataSelection(document.getElementsByName("chkDs" + idx + "RF")[0]);
	changeDataSelection(document.getElementsByName("chkDs" + idx + "WT")[0]);
}

function hiddenTypeSize(sheetObj, info, tpIdx, sts) {
	var bkgSts = document.getElementsByName("chkDs2BKG")[0].checked;
	var cfmSts = document.getElementsByName("chkDs2CFM")[0].checked;
	var stsHC = document.getElementsByName("chkDs2HC")[0].checked;
	var sts45 = document.getElementsByName("chkDs245")[0].checked;
	var sts53 = document.getElementsByName("chkDs253")[0].checked;

	/*
	 * 0:20/40 1:HC 2:45 3:53 3:RF 4:WG
	 */
	for ( var i = 0; i < info.weekCount; i++) {
		var sCol = 0;
		// F'cast물량 Hidden=========================================
		// HC(1), 45(2), 53(3)일때 Total TEU처리 추가
		sCol = info.masterColumnCount + info.itemColumnCount * i
				+ info.infoColumnCount;// 전체 컬럼 갯수
		if (stsHC || sts45 || sts53)
			sheetObj.ColHidden(sCol) = false;// Total TEU 활성화
		else
			sheetObj.ColHidden(sCol) = true;// Total TEU 비활성화

		sheetObj.ColHidden(sCol + 1) = false;// TEU 활성화(항상)
		if (tpIdx > 0)
			sheetObj.ColHidden(sCol + 1 + tpIdx) = !sts;// HC, 45, 53, RF, WT
		// ==========================================================

		// BKG물량 Hidden=============================================
		sCol = sCol + info.bookingColumnCount;
		if (bkgSts)
			sheetObj.ColHidden(sCol + 1 + tpIdx) = !sts;
		// ==========================================================

		// Confirmed물량 Hidden=======================================
		sCol = sCol + info.confirmColumnCount;
		sheetObj.ColHidden(sCol) = true;// Total TEU무조건 숨기기
		if (tpIdx > 0 && cfmSts)
			sheetObj.ColHidden(sCol + 1 + tpIdx) = !sts;
		// ==========================================================
	}
}

// Status를 바꾸지 않고 컬럼의 값이 val인 컬럼의 값을 sVal로 변경한다.
function ChangeValues2(sheetObj, col, val, sCol, sVal) {
	with (sheetObj) {
		var frow = -1;

		while ((frow = FindText(col, val, frow + 1)) >= 0) {
			var status = sheetObj.RowStatus(frow);
			CellValue2(frow, sCol) = sVal;
			sheetObj.RowStatus(frow) = status;
		}
	}
}

// CellValue2로 데이터 값을 변경한다.
function ChangeValue2(sheetObj, row, col, val) {
	with (sheetObj) {
		var status = RowStatus(row);
		CellValue2(row, col) = val;
		RowStatus(row) = status;
	}
}

// CellValue로 데이터 값을 변경한다.
function ChangeValue(sheetObj, row, col, val) {
	with (sheetObj) {
		var status = RowStatus(row);
		CellValue(row, col) = val;
		RowStatus(row) = status;
	}
}

function AddValue2(sheetObj, row, col1, col2, val) {
	// var totalTeuCol = 0;
	// var totalTeuValue = 0;
	
	if (col1 != null) {
		var old_color = sheetObj.CellFontColor(row, col1);
		ChangeValue2(sheetObj, row, col1, val + sheetObj.CellValue(row, col1)
				* 1);
		sheetObj.CellFontColor(row, col1) = old_color;
		compareConfirmValue(sheetObj, row, col1);
	}

	if (col2 != null) {
		var old_color = sheetObj.CellFontColor(row, col2);
		ChangeValue2(sheetObj, row, col2, val + sheetObj.CellValue(row, col2)
				* 1);
		sheetObj.CellFontColor(row, col2) = old_color;
		compareConfirmValue(sheetObj, row, col2);
	}
}

function compareConfirmValue(sheetObj, row, col) {
	var val1 = sheetObj.CellValue(row, col) * 1;
	var val2 = sheetObj.CellValue(row, col + sheet2.conformColorDif) * 1;

	if (sheetObj.CellFontColor(row, col) == 255) {
		return;
	}

	sheetObj.CellFontColor(row, col) = (val1 == val2) ? sheetObj.RgbColor(0, 0,
			255) : sheetObj.DataFontColor;
}

function AddValue(sheetObj, row, col, val) {
	ChangeValue(sheetObj, row, col, val + sheetObj.CellValue(row, col) * 1);
}

var searchSalesRep = new Array();
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, quite) {
	if (quite == undefined)
		quite = false;
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
	case IBSEARCH: // 조회
		var sheetObj = sheetObjects[beforetab];
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}

		var param = "year=" + formObj.year.value;
		param = param + "&week=" + formObj.week.value;
		param = param + "&duration=" + formObj.duration.value;
		param = param + "&trade=" + comObjects[0].Code;
		param = param + "&subtrade=" + comObjects[1].Code;
		param = param + "&lane=" + comObjects[2].Code;
		param = param + "&bound=" + formObj.bound.value;
		param = param
				+ "&ioc="
				+ (formObj.id_chk_ocn.checked ? formObj.id_chk_ocn.value
						: (formObj.id_chk_ipc.checked ? formObj.id_chk_ipc.value
								: formObj.id_chk_ts.value));
		param = param + "&salesOffice=" + comObjects[3].Code;
		param = param + "&subOffice=" + comObjects[4].Code;
		param = param + "&salesRep=" + comObjects[5].Code;
		param = param + "&vvd=" + formObj.vvd.value;

		// var rtn = sheetObj.GetSearchXml("ESM_SPC_0999GS.do",
		// "f_cmd="+(SEARCHLIST01 + beforetab)+"&"+FormQueryString(formObj));
		var rtn = sheetObj.GetSearchXml("ESM_SPC_0999GS.do", "f_cmd="
				+ (SEARCHLIST01 + beforetab) + "&" + param);
		var etcData = getEtcData(rtn);
		if (etcData["status"] == undefined || etcData["status"] != "OK"
				|| etcData["week"] == undefined) {
			ComShowMessage("Error occurred. Try again");
			return;
		}

		sheetObj.Reset();
		if (beforetab == 1) {
			initSheet2(sheetObj, etcData["week"].substring(1));
			sheetObj.LoadSearchXml(rtn);
			t1sheet2_OnScroll(sheetObj, 0, 0, sheetObj.HeaderRows, 0, true);
			initData2(sheetObj);
			initDataSelection(1);
			ComBtnEnable("btng_addAccount2");
			var comObj = document.getElementById("trade");
			var trd_cd = comObj.Code;
			// if(trd_cd.substring(0, 1) == "I"){
			// document.all.ds2POD.checked = "";
			// }
			// showDataSelectionItem("divDs2POD", trd_cd.substring(0, 1) ==
			// "I");
		}

		searchSalesRep[beforetab] = document.getElementById("salesRep").Code;

		// Data변경없이 Save처리를 위해 조회시 폼값이 세팅되도록 추가
		formObj.vvdList.value = etcData["vvd"].replace('|TTL', '');
		formObj.salesRepCodeList.value = etcData["salesRepCodeList"];

		// VVD별 Control Option에 따라 컬럼 세팅해주기 위해 추가===============================
		// sheet에 대한 조회가 끝나면 VVD별로 Control Option에 따라 Column을 Hidden한다.
		// 컬럼을 돌면서, 해당 CELL이 Editable한 경우 해당 컬럼을 보이게한다.
		var isEditCol;
		var cn;
		for ( var c = sheet2.masterColumnCount; c < sheet2.columnCount; c++) {
			isEditCol = false;// 새로운 컬럼일때 초기화
			cn = sheetObj.ColSaveName(c);
			for ( var r = 0; r < sheetObj.Rows; r++) {
				if (sheetObj.CellBackColor(r, c) == sheetObj.RgbColor(255, 255,
						128)) {
					isEditCol = true;
					break;
				}
			}

			if (isEditCol
					&& (cn == 'fcast_ttl_qty' || cn == 'fcast_40ft_hc_qty'
							|| cn == 'fcast_45ft_hc_qty'
							|| cn == 'fcast_53ft_qty' || cn == 'fcast_rf_qty' || cn == 'fcast_ttl_wgt')) {
				sheetObj.ColHidden(c) = false;
				/* 전체적으로 컬럼을 컨트롤하려면 주석풀기, 해당 VVD만 하려면 주석처리 */
				switch (sheetObj.ColSaveName(c)) {
				// case "fcast_40ft_hc_qty":
				// sheetObj.colHidden(c) = false;
				// //document.form.chkDs2HC.checked = true;
				// //changeDataSelection(document.getElementsByName("chkDs2HC")[0]);
				// break;
				//    							
				// case "fcast_45ft_hc_qty":
				// //document.form.chkDs245.checked = true;
				// //changeDataSelection(document.getElementsByName("chkDs245")[0]);
				// break;
				//    							
				// case "fcast_53ft_qty":
				// //document.form.chkDs253.checked = true;
				// //changeDataSelection(document.getElementsByName("chkDs253")[0]);
				// break;
				//    							
				// case "fcast_rf_qty":
				// //document.form.chkDs2RF.checked = true;
				// //changeDataSelection(document.getElementsByName("chkDs2RF")[0]);
				// break;
				case "fcast_ttl_wgt":
					document.form.chkDs2WT.checked = true;
					changeDataSelection(document.getElementsByName("chkDs2WT")[0]);
					break;
				}
			}
		}
		// ===============================================================================
		break;

	case IBSAVE: // 저장
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}

		var uList = sheetObj.FindStatusRow("U");
		var uArr = uList.split(";");
		var sheetInfo;
		if (beforetab == 0) {
			sheetInfo = sheet1;
		} else if (beforetab == 1) {
			sheetInfo = sheet2;
		}

		for ( var i = 0; i < uArr.length; i++) {
			var row = uArr[i] * 1;
			var lvl = sheetObj.CellValue(row, "treeLevel") * 1;
			if (lvl != 4) {
				continue;
			}

			var rowRep = sheetObj.CellValue(row, "rowRep") * 1;
			var rowPol = sheetObj.CellValue(row, "rowPol") * 1;
			for ( var c = 0; c < sheetInfo.weekCount; c++) {
				var col = sheetInfo.masterColumnCount
						+ sheetInfo.itemColumnCount * c
						+ sheetInfo.infoColumnCount - 1;
				break;
				if (sheetObj.CellValue(row, col) == "U"
						|| sheetObj.CellValue(row, col) == "I") {
					sheetObj.CellValue2(rowRep, col) = "I";
					sheetObj.CellValue2(rowPol, col) = "I";
				}
			}
		}

		uList = sheetObj.FindStatusRow("U");
		uArr = uList.split(";");
		// var rtn = doSaveSheet(sheetObj, "ESM_SPC_0999GS.do",
		// "f_cmd="+(MULTI01 + beforetab)+"&"+FormQueryString(formObj), null,
		// !quite);
		var rtn = doSaveSheet(sheetObj, "ESM_SPC_0999GS.do", "f_cmd="
				+ (MULTI01 + beforetab), null, !quite);
		if (rtn == "OK") {
			for ( var i = 0; i < uArr.length; i++) {
				var row = uArr[i] * 1;
				var lvl = sheetObj.CellValue(row, "treeLevel") * 1;
				for ( var c = 0; c < sheetInfo.weekCount; c++) {
					var col = sheetInfo.masterColumnCount
							+ sheetInfo.itemColumnCount * c
							+ sheetInfo.infoColumnCount - 1;

					if (sheetObj.CellValue(row, col) == "U"
							|| sheetObj.CellValue(row, col) == "I") {
						if (sheetObj.CellValue(row, col - 3) == "C") {
							sheetObj.CellValue2(row, col - 3) = "";
						}
						if (lvl == 4) {
							sheetObj.CellValue2(row, col) = "R";
						} else {
							sheetObj.CellValue2(row, col) = "";
						}
						sheetObj.RowStatus(row) = "R";
					}
				}
			}
		}
		break;

	case IBDOWNEXCEL: // 엑셀 다운로드
		sheetObj.Down2Excel(-1, false, false, true);
		break;
	}
}

// Sheet관련 프로세스 처리, Data변경없이 Save한 경우
function doActionIBSheet2(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
	case IBSAVE: // Data변화없이 SAVE
		if (!validateForm(sheetObj, formObj, IBSEARCH)) { // IBSEARCH와 동일한
															// 조건으로 입력폼값 제한
			return false;
		}

		if (formObj.salesRepCodeList.value != '') { // isEditable한 salesRep이 있는
													// 경우
			// Data변화 없이도 저장 할 것인지
			if (ComShowConfirm('There is no data to changed\nPlease click "Yes" if you\'d like to continue') == 0)
				return false;

			var param = "salesRepCodeList=" + formObj.salesRepCodeList.value;
			param = param + "&vvdList=" + formObj.vvdList.value;
			param = param
					+ "&ioc="
					+ (formObj.id_chk_ocn.checked ? formObj.id_chk_ocn.value
							: (formObj.id_chk_ipc.checked ? formObj.id_chk_ipc.value
									: formObj.id_chk_ts.value));

			// sheetObj.DoAllSave("ESM_SPC_0999GS.do", "f_cmd=" + MULTI03 + "&"
			// + FormQueryString(formObj));
			sheetObj.DoAllSave("ESM_SPC_0999GS.do", "f_cmd=" + MULTI03 + "&"
					+ param);
			// DoAllSave의 return값 true/false
		} else { // isEditable한 salesRep이 없는 경우
			ComShowMessage("There is no data to save");
		}
		break;
	}
}

/*
 * 저장후 호출
 */
function t1sheet2_OnSaveEnd(sheetObj, errMsg) {
	if (sheetObj.EtcData("status") == "OK") {
		ComShowMessage("saved successfully.");
	} else if (sheetObj.EtcData("status") != "OK") {
		ComShowMessage(errMsg);
	}
}

function initData2(sheetObj) {
	// ChangeValues2(sheetObj, "treeLevel", "2", "d_pol_cd", "-");
	// ChangeValues2(sheetObj, "treeLevel", "3", "d_pod_cd", "-");
}

function t1sheet2_OnScroll(sheetObj, oldTopRow, oldLeftCol, newTopRow,
		newLeftCol, isInit) {
	if (isInit == undefined) {
		isInit = false;
	}

	var baseCol = sheet2.masterColumnCount + sheet2.itemColumnCount
			* (sheet2.weekCount - 1);
	sheetObj.RowHidden(3) = (sheetObj.CellValue(newTopRow, baseCol + 4) == "");
	if ((sheetObj.CellValue(newTopRow, baseCol + 4) == "")) {
		return;
	}

	for ( var i = 0; i < sheet2.weekCount; i++) {
		var baseCol = sheet2.masterColumnCount + sheet2.itemColumnCount * i;
		var vvd = sheetObj.CellValue(newTopRow, baseCol + 4)
				+ sheetObj.CellValue(newTopRow, baseCol + 5)
				+ sheetObj.CellValue(newTopRow, baseCol + 6);
		if (vvd == "") {
			vvd = " ";
		}

		if (sheetObj.CellValue(3, baseCol + sheet2.infoColumnCount) == vvd) {
			continue;
		}

		for ( var c = sheet2.infoColumnCount; c < sheet2.itemColumnCount; c++) {
			sheetObj.CellValue2(3, baseCol + c) = vvd;
		}
	}
}

var selectedCell_OldValue = 0;
function t1sheet2_OnSelectCell(sheetObj, orow, ocol, row, col) {
	selectedCell_OldValue = sheetObj.CellValue(row, col) * 1;
}

function t1sheet1_OnChange(sheetObj, row, col, value) {

}

function t1sheet2_OnChange(sheetObj, row, col, value) {
	with (sheetObj) {
		var level = CellValue(row, "treeLevel") * 1;
		var orgValue = selectedCell_OldValue;
		var difValue = value * 1 - orgValue;

		// =====================================
		var colName = sheetObj.ColSaveName(col);
		var difTeuValue = difValue;
		if (colName == 'fcast_40ft_hc_qty' || colName == 'fcast_45ft_hc_qty'
				|| colName == 'fcast_53ft_qty')
			difTeuValue = difValue * 2;
		// =====================================

		if (CellEditable(row, col) && CellFontColor(row, col) == 255) {
			ComShowMessage("Please check if port is skipped or account is not registered for forecast input.");
		}

		switch (level) {
		case 3:
			var colIdx = (col - sheet2.masterColumnCount) % sheet2.itemColumnCount;
			var ttlCol = sheet2.masterColumnCount + sheet2.itemColumnCount * (sheet2.weekCount - 1) + colIdx;
			compareConfirmValue(sheetObj, row, col);
			var frow = row;
			var pol_cd  = CellValue(frow, "d_pol_cd");
			var cust_cd = CellValue(frow, "d_cust_cd");
			var isAsigned = false;
			frow = frow + 1;

			while (    pol_cd  == CellValue(frow, "d_pol_cd")
					&& cust_cd == CellValue(frow, "d_cust_cd") ) {
				selectedCell_OldValue = CellValue(frow, col);
				if (selectedCell_OldValue != "") {
					var old_color = CellFontColor(frow, col);

					if (isAsigned) {
						CellValue(frow, col) = 0;
					} else {
						CellValue(frow, col) = value;
						isAsigned = true;
					}
					CellFontColor(frow, col) = old_color;
				}
				frow = frow + 1;
			}

			setChangedStatus(sheetObj, row, col);
			// RowStatus(row) = "R";
			break;

		case 4:
			var colIdx  = (col - sheet2.masterColumnCount) % sheet2.itemColumnCount;
			var ttlCol  = sheet2.masterColumnCount + sheet2.itemColumnCount * (sheet2.weekCount - 1) + colIdx;
			var rowLane = CellValue(row, "rowLane") * 1;
			var rowRep  = CellValue(row, "rowRep") * 1;
			var rowPol  = CellValue(row, "rowPol") * 1;
			compareConfirmValue(sheetObj, row, col);
			// 1.현재 행의 TTL 값 변경
			AddValue2(sheetObj, row, null, ttlCol, difValue);
			// 2.현재 행의 POL에 대한 값 변경
			if (rowPol != SelectRow || colName.substr(0,3) == "cfm") {
				AddValue2(sheetObj, rowPol, col, null, difValue);
				compareConfirmValue(sheetObj, rowPol, col);
				setChangedStatus(sheetObj, rowPol, col);
			}
			AddValue2(sheetObj, rowPol, null, ttlCol, difValue);

			// 3.현재 행의 Sales Rep에 대한 값 변경
			AddValue2(sheetObj, rowRep, col, ttlCol, difValue);
			compareConfirmValue(sheetObj, rowRep, col);
			setChangedStatus(sheetObj, rowRep, col);
			// 4.현재 행의 RLane에 대한 값 변경
			AddValue2(sheetObj, rowLane
					+ 1
					+ ((ComTrim(CellValue(rowLane + 1, "d_pol_cd")) == "") ? 1
							: 0), col, ttlCol, difValue);
			// 5.현재 행의 RLane의 POL에 대한 값 변경
			var frow = FindText("d_pol_cd", CellValue(row, "d_pol_cd"), rowLane);
			AddValue2(sheetObj, frow, col, ttlCol, difValue);
			// 6.현재 행의 RLane의 POD에 대한 값 변경
			frow = FindText("d_pod_cd", CellValue(row, "d_pod_cd"), frow);
			AddValue2(sheetObj, frow, col, ttlCol, difValue);
			setChangedStatus(sheetObj, row, col);
			break;
		}
	}

	selectedCell_OldValue = value;

	// ==================================================================================================
	// Total TEU추가에 따라 데이터 변경 row, col, value
	var totalTeuCol = 0;
	var totalTeuValue = 0;
	var ttlTotalTeuCol = 0;
	var ttlTotalTeuValue = 0;

	for ( var k = sheetObj.HeaderRows; k < sheetObj.Rows; k++) {
		switch (sheetObj.ColSaveName(col)) {
		case "fcast_ttl_qty":
			totalTeuCol = col - 1;
			// TEU + HC*2 + 45*2 + 53*2
			totalTeuValue = parseInt(sheetObj.CellValue(k, col))
					+ parseInt(sheetObj.CellValue(k, col + 1)) * 2
					+ parseInt(sheetObj.CellValue(k, col + 2)) * 2
					+ parseInt(sheetObj.CellValue(k, col + 3)) * 2;
			ttlTotalTeuCol = ttlCol - 1;
			ttlTotalTeuValue = parseInt(sheetObj.CellValue(k, ttlCol))
					+ parseInt(sheetObj.CellValue(k, ttlCol + 1)) * 2
					+ parseInt(sheetObj.CellValue(k, ttlCol + 2)) * 2
					+ parseInt(sheetObj.CellValue(k, ttlCol + 3)) * 2;
			break;

		case "fcast_40ft_hc_qty":
			totalTeuCol = col - 2;
			// TEU + HC*2 + 45*2 + 53*2
			totalTeuValue = parseInt(sheetObj.CellValue(k, col - 1))
					+ parseInt(sheetObj.CellValue(k, col)) * 2
					+ parseInt(sheetObj.CellValue(k, col + 1)) * 2
					+ parseInt(sheetObj.CellValue(k, col + 2)) * 2;
			ttlTotalTeuCol = ttlCol - 2;
			ttlTotalTeuValue = parseInt(sheetObj.CellValue(k, ttlCol - 1))
					+ parseInt(sheetObj.CellValue(k, ttlCol)) * 2
					+ parseInt(sheetObj.CellValue(k, col + 1)) * 2
					+ parseInt(sheetObj.CellValue(k, col + 2)) * 2;
			break;

		case "fcast_45ft_hc_qty":
			totalTeuCol = col - 3;
			// TEU + HC*2 + 45*2 + 53*2
			totalTeuValue = parseInt(sheetObj.CellValue(k, col - 2))
					+ parseInt(sheetObj.CellValue(k, col - 1)) * 2
					+ parseInt(sheetObj.CellValue(k, col)) * 2
					+ parseInt(sheetObj.CellValue(k, col + 1)) * 2;
			ttlTotalTeuCol = ttlCol - 3;
			ttlTotalTeuValue = parseInt(sheetObj.CellValue(k, ttlCol - 2))
					+ parseInt(sheetObj.CellValue(k, ttlCol - 1)) * 2
					+ parseInt(sheetObj.CellValue(k, ttlCol)) * 2
					+ parseInt(sheetObj.CellValue(k, ttlCol + 1)) * 2;
			break;

		case "fcast_53ft_qty":
			totalTeuCol = col - 4;
			// TEU + HC*2 + 45*2 + 53*2
			totalTeuValue = parseInt(sheetObj.CellValue(k, col - 3))
					+ parseInt(sheetObj.CellValue(k, col - 2)) * 2
					+ parseInt(sheetObj.CellValue(k, col - 1)) * 2
					+ parseInt(sheetObj.CellValue(k, col)) * 2;
			ttlTotalTeuCol = ttlCol - 4;
			ttlTotalTeuValue = parseInt(sheetObj.CellValue(k, ttlCol - 3))
					+ parseInt(sheetObj.CellValue(k, ttlCol - 2)) * 2
					+ parseInt(sheetObj.CellValue(k, ttlCol - 1)) * 2
					+ parseInt(sheetObj.CellValue(k, ttlCol - 0)) * 2;
			break;

		default:
			totalTeuCol = 0;
			totalTeuValue = 0;
			ttlTotalTeuCol = 0;
			ttlTotalTeuValue = 0;
			break;
		}

		// 1.해당 VVD의 Total TEU변경
		if (totalTeuCol > 0 && totalTeuValue > 0)
			ChangeValue2(sheetObj, k, totalTeuCol, totalTeuValue);
		// 2.TTL의 Total TEU변경
		if (ttlTotalTeuCol > 0 && ttlTotalTeuValue > 0)
			ChangeValue2(sheetObj, k, ttlTotalTeuCol, ttlTotalTeuValue);
	}
	// ==================================================================================================
}

function setChangedStatus(sheetObj, row, col) {
	with (sheetObj) {
		var value = CellValue(row, col);
		var colIdx = (col - sheet2.masterColumnCount) % sheet2.itemColumnCount;

		// ======================
		// 수정 여부 Flag 설정 시작
		// VVD Index 계산
		var itemIdx = (col - sheet2.masterColumnCount - colIdx)
				/ sheet2.itemColumnCount;
		// 해당 VVD의 flag column 계산
		var flagCol = sheet2.masterColumnCount + itemIdx
				* sheet2.itemColumnCount + sheet2.infoColumnCount - 1;
		log("setChangedStatus flagCol : " + flagCol);
		var colFlag = CellValue(row, flagCol - 1);
		var colSearchFlag = CellSearchValue(row, flagCol - 1);
		var colArr = colFlag.split(",");
		var fieldIdx = colIdx - sheet2.infoColumnCount;

		if (fieldIdx > 10)
			fieldIdx = fieldIdx - 12;

		var confirmValue = CellSearchValue(row, col
				+ sheet2.forecastColumnCount + sheet2.bookingColumnCount) * 1;
		var searchValue = CellSearchValue(row, col) * 1;
		var curFlag = CellValue(row, flagCol);
		var searchFlag = CellSearchValue(row, flagCol);
		// log(makeMessageString("setChangedStatus 1 : ", flagCol, fieldIdx,
		// colArr));
		colArr[fieldIdx] = confirmValue == value ? "S" : "D";
		// log(makeMessageString("setChangedStatus 2 : ", flagCol, fieldIdx,
		// colArr));
		CellValue2(row, flagCol - 1) = colArr;
		CellValue2(row, flagCol - 3) = (colArr + "").indexOf("D") >= 0 ? "D"
				: "";
		CellValue2(row, flagCol) = (colSearchFlag == (colArr + "") && value == searchValue) ? searchFlag == "" ? ""
				: "R"
				: (searchFlag == "" ? "I" : "U");
		// log(makeMessageString("setChangedStatus 3 : ", colSearchFlag, colArr,
		// value, searchValue, searchFlag));

		var curRowEdited = false;
		for ( var i = 0; i < sheet2.weekCount; i++) {
			var colValue = CellValue(row, sheet2.masterColumnCount
					+ sheet2.itemColumnCount * i + sheet2.infoColumnCount - 1);
			if (colValue != "" && colValue != "R") {
				curRowEdited = true;
			}
		}

		if (!curRowEdited) {
			RowStatus(row) = "R";
		}
		// 수정 여부 Flag 설정 끝
		// ----------------------
	}
}

function vvdChanged() {
	var obj = event.srcElement;
	if (obj.value == "") {
		trade_OnChange(comObjects[0], comObjects[0].Code, comObjects[0].Text);
	} else {
		document.all.id_chk_ocn.checked = true;
		document.all.id_chk_ocn.disabled = false;
		document.all.id_chk_ipc.disabled = false;
		document.all.id_chk_ts.disabled = false;
	}
}

var laneChange = false; // lane 변경 구분값
function lane_OnChange(comObj, value, text) {
	if (value == "")
		return;
	if (document.all.vvd.value != "")
		return;

	// if(value.substring(0,3) == "IMU" && comObjects[0].Text == 'AES'){
	// document.all.id_chk_ocn.checked = true;
	// document.all.id_chk_ocn.disabled = false;
	// document.all.id_chk_ipc.disabled = true;
	// document.all.id_chk_ts.disabled = false;
	// } else {
//	alert(comObj.GetText(value,0)+"//"+comObj.GetText(value,1));
	laneChange = true; // lane 변경
//	var trade = comObj.GetText(value,0);
//	var subTrade = comObj.GetText(value,1);
//	comObjects[0].Code2 = trade;
//	comObjects[1].Code2 = subTrade;
	
	var arrLane = text.split("|");
	if(arrLane.length > 1) {
		comObjects[0].Code2 = arrLane[0];
		comObjects[1].Code2 = arrLane[1];
	} else {
		comObjects[0].Code2 = comObj.GetText(value,0);  
		comObjects[1].Code2 = comObj.GetText(value,1);  
	}	
	// alert(trade+"//"+subTrade);
	trade_OnChange2(comObjects[0], comObjects[0].Text, text);
	laneChange = false; // lane 변경 초기화
	// }

}
function trade_OnChange2(combj, value, text) {
	if (value == "")
		return;
	if (document.all.vvd.value != "")
		return;

	if (value.charAt() != "I") {
		document.all.id_chk_ocn.checked = true;
		document.all.id_chk_ocn.disabled = true;
		document.all.id_chk_ipc.disabled = true;
		document.all.id_chk_ts.disabled = true;
	} else {
		document.all.id_chk_ipc.checked = true;
		document.all.id_chk_ocn.disabled = true;
		document.all.id_chk_ipc.disabled = false;
		document.all.id_chk_ts.disabled = false;
	}

	// if(comObjects[2].Text.substring(0,3) == "IMU" && value == 'AES'){
	// document.all.id_chk_ocn.checked = true;
	// document.all.id_chk_ocn.disabled = false;
	// document.all.id_chk_ipc.disabled = true;
	// document.all.id_chk_ts.disabled = false;
	// }
	if (!laneChange) { // lane 변경없을시(trade 변경시)
		comObjects[1].Code2 = '';
		comObjects[2].Code2 = '';
	}
}
function trade_OnChange(combj, value, text) {
//	if(text == '|ALL'){	optionAllReset("trade",value);   return;} // 0207 SHKIM
//	if (value == "")
//		return;
	if (document.all.vvd.value != "")
		return;

	if (value.charAt() != "I") {
		document.all.id_chk_ocn.checked = true;
		document.all.id_chk_ocn.disabled = true;
		document.all.id_chk_ipc.disabled = true;
		document.all.id_chk_ts.disabled = true;
	} else {
		document.all.id_chk_ipc.checked = true;
		document.all.id_chk_ocn.disabled = true;
		document.all.id_chk_ipc.disabled = false;
		document.all.id_chk_ts.disabled = false;
	}

	// if(comObjects[2].Text.substring(0,3) == "IMU" && value == 'AES'){
	// document.all.id_chk_ocn.checked = true;
	// document.all.id_chk_ocn.disabled = false;
	// document.all.id_chk_ipc.disabled = true;
	// document.all.id_chk_ts.disabled = false;
	// }
	if (!laneChange) { // lane 변경없을시(trade 변경시)
		comObjects[1].Code2 = '';
		comObjects[2].Code2 = '';
	}
	SpcSearchOptionSubTrade("subtrade",true,false,"","",value);			// 0207 SHKIM
	SpcSearchOptionLane("lane",true,true,'',value,'',true);	// 0207 SHKIM
}

function subtrade_OnChange(combj, value, text) {
//	if(text == '||ALL'){   optionAllReset("subtrade",document.form.trade.Code); return; } // 0207 SHKIM
	combj.UseCode=true;
	SpcSearchOptionLane("lane",true,true,'',document.form.trade.Code,value,true);	// 0207 SHKIM	
	if (value == "")
		return;

	var arrSubtrade = text.split("|");
	if(arrSubtrade.length > 1) {
		comObjects[0].Code2 = arrSubtrade[0];
		comObjects[2].Code2 = '';
	} else {
		comObjects[0].Code2 = combj.GetText(value,0);  
		comObjects[2].Code2 = '';
	}
}

function salesOffice_OnChange(comObj, value, text) {
	if (value == "")
		return;
	var rtn = getCodeList("ChildTeamOffice", "ofc_cd=" + value
			+ "&level=5&include=1");
	initData_subOffice(rtn[0].split("|"), rtn[1].split("|"));

	if (document.getElementById("subOffice").Code == "") {
		var rtn = getCodeList("TeamSalesRep", "ofc_cd=" + value + "&level=4");
		initData_salesRep(rtn[0].split("|"), rtn[1].split("|"));
	}

	// 2010.05.10 subOffice Index = 0 값을 늦게 가져와서 재호출
	var subObj = document.getElementById("subOffice");
	subOffice_OnChange(subObj, subObj.Code, subObj.Text);
}

function subOffice_OnChange(comObj, value, text) {
	var rtn = "";
	if (value == "") {
		rtn = getCodeList("TeamSalesRep", "ofc_cd="
				+ document.getElementById("salesOffice").Code + "&level=4");
	} else {
		rtn = getCodeList("TeamSalesRep", "ofc_cd=" + value + "&level=5");
	}

	initData_salesRep(rtn[0].split("|"), rtn[1].split("|"));
}

function initDataValue_salesOffice() {
	var sheetObj = document.getElementById("salesOffice");
	with (sheetObj) {
		Index2 = 0;
	}
}

function initData_salesOffice(codes, names) {
	var sheetObj = document.getElementById("salesOffice");
	var cnt = 0;

	with (sheetObj) {
		RemoveAll();
		SetTitle("Office|Name");
		SetColWidth("60|250");
		SetColAlign("left|left");
		ShowCol = 0;
		MultiSelect = false;
		MaxSelect = 1;
		DropHeight = 190;

		if (codes == undefined || codes == null) {
			return;
		}

		if (codes.length > 2) {
			InsertItem(-1, "|ALL", "");
		}

		var selectCode = "";
		for ( var i = 0; i < codes.length - 1; i++) {
			var txt = names[i].split("~");
			if (txt[1] == "1") {
				selectCode = codes[i];
			}
			InsertItem(-1, codes[i] + "|" + txt[0], codes[i]);
		}

		if (selectCode != "") {
			Code = selectCode;
		} else {
			Index = 0;
		}
		Enable = (GetCount() > 1);
	}
}

function initData_subOffice(codes, names) {
	var sheetObj = document.getElementById("subOffice");
	var cnt = 0;

	with (sheetObj) {
		RemoveAll();
		SetTitle("Office|Name");
		SetColWidth("60|250");
		SetColAlign("left|left");
		ShowCol = 0;
		MultiSelect = false;
		MaxSelect = 1;
		DropHeight = 190;

		if (codes == undefined || codes == null) {
			return;
		}

		if (codes.length > 2) {
			InsertItem(-1, "|ALL", "");
		}

		var selectCode = "";
		for ( var i = 0; i < codes.length - 1; i++) {
			var txt = names[i].split("~");
			if (txt[1] == "1") {
				selectCode = codes[i];
			}
			InsertItem(-1, codes[i] + "|" + txt[0], codes[i]);
		}

		if (selectCode != "") {
			Code = selectCode;
		} else {
			Index = 0;
		}

		Enable = (GetCount() > 1);
		Enable = !(Index > 1);
	}
}

function initDataValue_subOffice() {
	var sheetObj = document.getElementById("subOffice");
	with (sheetObj) {
		Index2 = 0;
	}
}

function initData_salesRep(codes, names) {
	var sheetObj = document.getElementById("salesRep");
	var cnt = 0;

	with (sheetObj) {
		RemoveAll();
		SetTitle("Code|Name|OFC|OFC NM");
		SetColWidth("60|150|60|100");
		SetColAlign("left|left|left|left");
		ShowCol = 0;
		MultiSelect = false;
		MaxSelect = 1;
		DropHeight = 190;

		if (codes == undefined || codes == null) {
			return;
		}

		if (codes.length > 2) {
			InsertItem(-1, "|ALL", "");
		}

		var selectCode = "";
		for ( var i = 0; i < codes.length - 1; i++) {
			var txt = names[i].split("~");
			if (txt[3] == "1") {
				selectCode = codes[i];
			}
			InsertItem(-1, codes[i] + "|" + names[i].replace(/~/g, "|"),
					codes[i]);
		}

		if (selectCode != "") {
			Code = selectCode;
		} else {
			Index = 0;
		}
	}
}

function initDataValue_salesRep() {
	var sheetObj = document.getElementById("salesRep");
	with (sheetObj) {
//		Code2 = sheetObj.Code;
	}
}

function confirmData(sheetObj, formObj) {
	if (document.all.ds2CfrmAll.checked) {
		if (ComShowConfirm("All forecast on the screen will be interfaced to SPC. Continue?") == 0) {
			return;
		}
	} else {
		if (searchSalesRep[beforetab] == ""
				&& (sheetObj.SelectRow < 3 || ComTrim(sheetObj.CellValue(
						sheetObj.SelectRow, "d_srep_usr_id")) == "")) {
			ComShowMessage("Please select a sales rep to be confirmed.");
			return;
		}
		var srow = sheetObj.SelectRow;
		if (searchSalesRep[beforetab] != "") {
			srow = sheetObj.Rows - 1;
		}
		var srep_cd = ComTrim(sheetObj.CellValue(srow, "d_srep_usr_id"));
		var srep_nm = "[" + ComTrim(sheetObj.CellValue(srow, "d_srep_usr_nm"))
				+ "]";
		if (ComShowConfirm("Forecast of the selected Sales Rep(" + srep_cd
				+ srep_nm + ") will be interfaced to SPC. Continue?") == 0) {
			return;
		}
	}
	if (document.all.ds2CfrmAll.checked) {
		confirmDataAll(sheetObj, formObj);
	} else {
		confirmDataSelectedSalesRep(sheetObj, formObj, srep_cd);
	}
	doActionIBSheet(sheetObj, formObj, IBSAVE, true);
}

function confirmRow(sheetObj, formObj, row) {
	if (sheetObj.CellValue(row, "treeLevel") * 1 < 4) {
		return;
	}

	log("comformDataEdited row : " + row);
	var sheetInfo = eval("sheet" + (beforetab + 1));
	var baseColumn = sheetInfo.masterColumnCount + sheetInfo.infoColumnCount;
	for ( var i = 0; i < sheetInfo.weekCount; i++) {
		var sCol = baseColumn + sheetInfo.itemColumnCount * i;
		if (sheetObj.CellValue(row, sCol - 4) == "D"
				|| sheetObj.CellValue(row, sCol - 1) == "U"
				|| sheetObj.CellValue(row, sCol - 1) == "I") {
			confirmItem(sheetObj, formObj, row, sCol, sheetInfo);
		}
	}
}

function confirmItem(sheetObj, formObj, row, baseColumn, sheetInfo) {
	var rowLane = sheetObj.CellValue(row, "rowLane") * 1;
	var rowRep = sheetObj.CellValue(row, "rowRep") * 1;
	var rowPol = sheetObj.CellValue(row, "rowPol") * 1;
	var rowLanePol = sheetObj.FindText("d_pol_cd", sheetObj.CellValue(row, "d_pol_cd"), rowLane);
	var rowLanePod = sheetObj.FindText("d_pod_cd", sheetObj.CellValue(row, "d_pod_cd"), rowLane);
	
	// Level 이 3이나 4인 경우에만(POL / POD) Forecast 값을 Confirm 값으로 Copy한다.
	var level = sheetObj.CellValue(row, "treeLevel") * 1;
	if(level != 4)
		return;
	
	for ( var c = baseColumn; c < baseColumn + sheetInfo.forecastColumnCount; c++) {
		log(row + " : " + (c + sheetInfo.conformColorDif) + " : "
				+ sheetObj.ColSaveName(c + sheetInfo.conformColorDif) + " : "
				+ c + " : " + sheetObj.ColSaveName(c))
		selectedCell_OldValue = sheetObj.CellValue(row, c + sheetInfo.conformColorDif);
		sheetObj.CellValue(row, c + sheetInfo.conformColorDif) = sheetObj.CellValue(row, c);
		compareConfirmValue(sheetObj, row, c);
		compareConfirmValue(sheetObj, rowPol, c);
		compareConfirmValue(sheetObj, rowRep, c);
		compareConfirmValue(
				sheetObj,
				rowLane
						+ 1
						+ ((ComTrim(sheetObj.CellValue(rowLane + 1, "d_pol_cd")) == "") ? 1
								: 0), c);
		compareConfirmValue(sheetObj, rowLanePol, c);
		compareConfirmValue(sheetObj, rowLanePod, c);
	}

	sheetObj.CellValue2(row, baseColumn - 4) = 'C';
	sheetObj.CellValue2(row, baseColumn - 2) = 'S,S,S,S,S';
	sheetObj.CellValue2(rowPol, baseColumn - 4) = 'C';
	sheetObj.CellValue2(rowPol, baseColumn - 2) = 'S,S,S,S,S';
	sheetObj.CellValue2(rowRep, baseColumn - 4) = 'C';
	sheetObj.CellValue2(rowRep, baseColumn - 2) = 'S,S,S,S,S';
}

function confirmDataSelectedSalesRep(sheetObj, formObj, srep_cd) {
	var row = 0;
	while ((row = sheetObj.FindText("d_srep_usr_id", srep_cd, row + 1)) > 0) {
		if (ComTrim(sheetObj.CellValue(row, "d_srep_usr_id")) == "") {
			continue;
		}
		confirmRow(sheetObj, formObj, row);
	}
}

function confirmDataEdited(sheetObj, formObj) {
	var rowsData = sheetObj.FindStatusRow("U");
	var rows = rowsData.split(";");
	var sheetInfo = eval("sheet" + (beforetab + 1));
	for ( var r = 0; r < rows.length - 1; r++) {
		var row = rows[r] * 1;
		confirmRow(sheetObj, formObj, row);
	}
}

function confirmDataAll(sheetObj, formObj) {
	confirmDataEdited(sheetObj, formObj);
	var sheetInfo = eval("sheet" + (beforetab + 1));
	var baseColumn = sheetInfo.masterColumnCount + sheetInfo.infoColumnCount;
	for ( var i = 0; i < sheetInfo.weekCount; i++) {
		var sCol = baseColumn + sheetInfo.itemColumnCount * i;
		var row = 0;
		while ((row = sheetObj.FindText(sCol - 4, "D", row + 1)) > 0) {
			confirmItem(sheetObj, formObj, row, sCol, sheetInfo);
		}
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회
		var sel_vvd = formObj.vvd.value;
		var sel_trade = comObjects[0].Code;
		if (sel_vvd == "" && sel_trade == "") {
			ComShowMessage(getMsg("SPC90114", "Trade"));
			formObj.vvd.focus();// 아래 바로 Focus안잡혀서 임시로 먼저 잡음
			comObjects[0].focus();
			return false;
		}

		// var subTrade = comObjects[1].Code;
		// if(vvd == "" && subTrade == ""){
		// ComShowMessage(getMsg("SPC90114", "Sub Trade"));
		// comObjects[1].focus();
		// return false;
		// }

		var sel_lane = comObjects[2].Code;
		if (sel_vvd == "" && sel_lane == "") {
			ComShowMessage(getMsg("SPC90114", "Lane"));
			comObjects[2].focus();
			return false;
		}

		var sel_ofc = comObjects[3].Code;
		if (sel_ofc == "") {
			ComShowMessage(getMsg("SPC90114", "Sales Office"));
			formObj.vvd.focus();// 아래 바로 Focus안잡혀서 임시로 먼저 잡음
			if (comObjects[3].Enable)
				comObjects[3].focus();
			// comObjects[3].focus();
			return false;
		}

		if (sel_vvd != "" && sel_vvd.length < 9) {
			ComShowCodeMessage("COM12174", "VVD", "9");
			formObj.vvd.focus();
			return false;
		}
		// return true;
		break;
	}
	return true;
}

function initDataValue_trade() {
	var sheetObj = document.getElementById("trade");
	with (sheetObj) {
		Index2 = 0;
	}
}

function initDataValue_subtrade() {
	var sheetObj = document.getElementById("subtrade");
	with (sheetObj) {
		Index2 = 0;
	}
}

function initDataValue_lane() {
	var sheetObj = document.getElementById("lane");
	with (sheetObj) {
		Index2 = 0;
	}
}

function initDataValue_subOffice() {
	var sheetObj = document.getElementById("subOffice");
	with (sheetObj) {
		Index2 = 0;
	}
}

/**
 * Start Week 의 year 변경시
 * Start Week 의 year 변경시 주차 변경
 */
function checkWeek(){
	SpcSearchOptionWeek("week",false,document.form.year.value);
	
}
/* 개발자 작업 끝 */
