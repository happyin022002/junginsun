/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0109.js
**@FileTitle : Forecast Input(Contract)
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.06.13 진마리아 SELCDO 팀코드 변경 (SELCTY)
* 2013.07.16 진마리아 MNLBA->MNLSC 하드코딩 변경
* 2013.09.25 진마리아 VVD만으로 조회 가능하게 수정 및 저장시 사용할 flag 값 수정(update시 insert타면서 에러나고 있었음)
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
* 2015.02.23 [CHM-201533936] Split13-사용자 표준환경 관련 - 버튼 공백대신 &nbsp;추가, combobox 처리
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
 * @class ESM_SPC_0109 : ESM_SPC_0109 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SPC_0109() {
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
var comObjects   = new Array();
var sheetCnt     = 0;
var comboCnt     = 0;
// sheetResizeFull = true;
// type check
var type_check;
// retrive check
var check_retrive = false;
var searchParams  = "";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

var init_year        = '';
var init_week        = '';
var init_duration    = '';
var init_ctrtOffice  = '';
var init_salesRep    = '';

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];
	
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;

		case "btn_new":			

			// 공통함수사용: 화면을 초기화
			sheetObject.RemoveAll();
			// resetAll();
			searchSalesRep = new Array();
			ComBtnDisable("btng_addAccount2");
			ComBtnDisable("btng_addOfc");
			ComBtnDisable("btng_dlyfcast");
			formObject.year.value     = init_year;	
			formObject.week.value     = init_week;
			formObject.duration.value = init_duration;
			document.getElementById("ctrtOffice").Code2 = init_ctrtOffice;
			document.getElementById("salesRep").Code2   = init_salesRep;			
			SpcSearchOptionWeek("week", false, document.form.year.value);	
			SpcSearchOptionTrade("trade", true, true);
 			SpcSearchOptionSubTrade("subtrade1");  			
 			SpcSearchOptionLane("rlane1", true, true);
 			
 			formObject.bound.selectedIndex = 0;
 			formObject.ioc[0].checked      = true;
 			formObject.vvd.value           = "";
 			
			break;

		case "btn_save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;
			
		case "btn_downexcel":
			doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
			break;

		case "btng_addAccount2":
			accountAddDelete();
			break;
			
		case "btng_addOfc":
			laneOfficeAddDel();
			break;
			
		case "btng_dlyfcast":
			callDailyForecast();
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
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
var tmpOfc = "";
function loadPage() {
	
	//[CHM-201533936] Split13-사용자 표준환경 관련 combo를 diabled 하여 로딩후 다시 enable 
	document.getElementById("trade").Enable = false;
	document.getElementById("subtrade1").Enable = false;
	
	SpcSearchOptionYear("year");
	SpcSearchOptionWeek("week");
	SpcSearchOptionDuration("duration", 5, 4);
	SpcSearchOptionTrade("trade", true, true);
	SpcSearchOptionSubTrade("subtrade1", true, false);
	SpcSearchOptionBound("bound", false, true, false, true);
	
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
		initDataSelection(i);
	}

	var sheetResizeFull = true;
	document_onresize();

	var formObject = document.form;
	var comObj = document.getElementById("ctrtOffice");

	ComBtnDisable("btng_addAccount2");
	ComBtnDisable("btng_addOfc");
	ComBtnDisable("btng_dlyfcast");
	
	var value   = "";
//	var include = "";
//
	if (ofc_cd == "SELCTY" || ofc_cd == "SELCDO" || ofc_cd == "SINRS") {
		tmpOfc = "";
	} else if (ofc_cd == "SHARCS" || ofc_cd == "SHARCC" || ofc_cd == "SHARCO") {
		tmpOfc = "";
	} else if (ofc_cd == "HAMRUS" || ofc_cd == "HAMRUC" || ofc_cd == "HAMRUO") {
		tmpOfc = "";
	} else if (ofc_cd == "NYCRAS" || ofc_cd == "NYCRAC" || ofc_cd == "NYCRAO") {
		tmpOfc = "";
	} else if (ofc_cd == "SINRSS" || ofc_cd == "SINRSO" || ofc_cd == "SINRSC") {
		tmpOfc = "";
	} else if (ofc_cd == "JKTSC" || ofc_cd == "JKTBA") {
		tmpOfc = "JKTBA";
	} else if (ofc_cd == "MNLSC" || ofc_cd == "MNLBA") {
		tmpOfc = "MNLSC";
	} else if (ofc_cd == "PHXSA" || ofc_cd == "LGBSC") {
		tmpOfc = "LGBSC";
	} else if (ofc_cd == "PKGSA" || ofc_cd == "PKGSC") {
		tmpOfc = "PKGSC";
	} else if (ofc_cd == "SELSA" || ofc_cd == "SELSC") {
		tmpOfc = "SELSC";
	} else if (ofc_cd == "SLCSC" || ofc_cd == "SEASC") {
		tmpOfc = "SEASC";
	} else if ("HO|HQ|AQ|BB|BS|BA".indexOf(ofc_tp_cd) > 0) {
		tmpOfc = ofc_cd;
	}
	
	var rtn = getCodeList("CtrtOffice", "ofc_cd="    + tmpOfc 
						              + "&level=4"
									  + "&year="     + document.form.year.value
								      + "&week="     + document.form.week.value
								      + "&duration=" + document.form.duration.value);
	initData_ctrtOffice(rtn[0].split("|"), rtn[1].split("|"));
	
	var rtn = getCodeList("Account", "");
	initData_acctList(rtn[0].split("|"), rtn[1].split("|"));
	
	// 포커싱
	formObject.year.focus();

	init_year        = formObject.year.value; // 년 초기화용
	init_week        = formObject.week.value; // 주차 초기화용	
	init_duration    = formObject.duration.value; // duration 초기화용
	init_ctrtOffice  = document.getElementById("ctrtOffice").Code;
	init_salesRep    = document.getElementById("salesRep").Code;
	
	// Test 용... 
//	formObject.year.value = "2013";
//	formObject.week.value = "30";
//	formObject.duration.value = 1;
//	comObjects[0].Code = 'AES';
//	comObjects[1].Code = 'NE';
//	comObjects[2].Code = 'CAXTP';
//	comObjects[3].Code = 'SHASC';
//	comObjects[3].Code = 'MSPSO';
//	comObjects[4].Code = 'CN367';
//	comObjects[5].Code = 'CN101130';
//	comObjects[3].Enable = true;
//	formObject.vvd.value = "HJAR0005W";
	
	//[CHM-201533936] Split13-사용자 표준환경 관련 combo를 diabled 하여 로딩후 다시 enable 
	document.getElementById("trade").Enable = true;
	document.getElementById("subtrade1").Enable = true;
}

/**
 * id에 해당하는 Object를 show option에 따라 Display
 */
function showDataSelectionItem(id, show) {
	var objs = document.all[id];
	if(objs != null){
		for ( var i = 0; i < objs.length; i++) {
			objs[i].style.display = show ? "" : "none";
		}
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init		
		initSheet1(sheetObj, document.form.year.value
				+ document.form.week.value + "|TTL", true);
		break;
	}
}

/**
 * sheet1에서 조회후 타이틀 변경
 */
var sheet1 = new Object();
function initSheet1(sheetObj, weeks, isInit) {
	if (isInit == undefined) {
		isInit = true;
	}
	
	with (sheetObj) {
		// 높이 설정
		// style.height = getSheetHeight(17);
		style.height = getSheetHeight(18);
		// 전체 너비 설정
		SheetWidth = mainTable.clientWidth;
		// Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		// 전체Merge 종류 [선택, Default msNone]
		MergeSheet = msPrevColumnMerge;
		// 전체Edit 허용 여부 [선택, Default false]
		var comObj = document.getElementById("ctrtOffice");
		// RGN Office 검색조건 목록이 1개인 경우 RGN Office이거나 Sub Office
		// 상위 Office가 들어온 경우 RGN Office가 1개 이상이므로 조회만 가능하도록 변경
		// KAMer 는 입력가능하게 하기 위해 Login 사용자가 S.REP 인 경우에도 EDIT 가능하도록 변경
		Editable = (comObj.GetCount() == 1 || strSrep_cd.length > 0);// || isDevMode;
		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(3, 1, 9, 100);
		
		// 대량의 데이터 조회시 - Paging 처리
		// 조회된 마지막 Row에서 Scroll 되면 이후 데이터 뿌려줌. (서버는 한번만 호출)
		// cf.) OnScrollNext : One Page Rows 만큼 조회 (서버 호출)
		//ScrollTrack = false;	// MassOfSearch에서 ScrollTrack = true는 불가
		//MassOfSearch = 1;

		var HeadTitle1 = "Sales Rep|Sales Rep|Week|Week|Week|Week|Week|Week|Week|Week|Week|Week|Week|Week|Week|";
		var HeadTitle2 = "Code|Name|Account|Account|Account|Account|Account|Account|Account|Account||||||";
		var HeadTitle3 = "Code|Name|Type|Code|Name|SC NO|RFA#|Yield Group|L.RHQ|L.OFC|Lane|Guide|Fcast Seq|POL|POD|";
		
		var HeadTitleInfo = "TRD|STRD|Lane|V| V |D|IOC|SREP|C.OFC|CUST|SEQ|L.OFC|POL|POD|FCAST SEQ|SC.NO|FLG|RFA#|C.LVL|IB|";
		var HeadTail      = "Tree|Flag|ICust|SC_FLG";
		sheet1.masterColumnCount = HeadTitle1.split("|").length - 1;
		sheet1.forecastColumnCount = 11;//VVD, Total,Total TEU, 20, 40, hc, 45, 53, rf, wt, remark	
		sheet1.bookingColumnCount  = 8;
		sheet1.infoColumnCount     = HeadTitleInfo.split("|").length - 1;
		
		var weekArr = weeks.split("|");
		sheet1.weekCount = weekArr.length;
		sheet1.tailColumnCount = HeadTail.split("|").length + 1;
		sheet1.itemColumnCount = sheet1.forecastColumnCount + sheet1.bookingColumnCount + sheet1.infoColumnCount;
		
		sheet1.columnCount = sheet1.masterColumnCount + sheet1.itemColumnCount * sheet1.weekCount + sheet1.tailColumnCount;
		
		sheet1.conformColorDif = sheet1.bookingColumnCount + sheet1.forecastColumnCount;

		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(sheet1.columnCount, sheet1.masterColumnCount, 0, false);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(false, true, true, true, false, false);
		
		var teuType = document.form.ds2OTH.checked?"20|40|":"TEU|FEU|";
		
		for ( var i = 0; i < sheet1.weekCount; i++) {
			for ( var j = 0; j < sheet1.infoColumnCount; j++) {
				HeadTitle1 = HeadTitle1 + weekArr[i] + "|";
				HeadTitle2 = HeadTitle2 + "|";
			}

			if(document.form.chkDs2FEU.checked){
				HeadTitle3 = HeadTitle3
				+ HeadTitleInfo
				+ "VVD|Total FEU|TTL FEU|"
				+ teuType
				+ "HC|45|53'|RF|WT|Remark|Total FEU|"
				+ teuType
				+ "HC|45|53'|RF|WT|";
			}else{
				HeadTitle3 = HeadTitle3
						+ HeadTitleInfo
						+ "VVD|Total TEU|TTL TEU|"
						+ teuType
						+ "HC|45|53'|RF|WT|Remark|Total TEU|"
						+ teuType
						+ "HC|45|53'|RF|WT|";
			}
			
			for ( var k = 0; k < sheet1.forecastColumnCount; k++) {
				HeadTitle1 = HeadTitle1 + weekArr[i] + "|";
				HeadTitle2 = HeadTitle2 + "F'cast|";
			}
			for ( var m = 0; m < sheet1.bookingColumnCount; m++) {
				HeadTitle1 = HeadTitle1 + weekArr[i] + "|";
				HeadTitle2 = HeadTitle2 + "Loading F'cast|";
			}
		}
		
		HeadTitle3 = HeadTitle3 + HeadTail;
		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);
		InitHeadRow(1, HeadTitle2, true);
		InitHeadRow(2, HeadTitle3, true);

		var cnt = 0;
		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,
		// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		
		InitDataProperty(0, cnt++, dtData  , 50 , daCenterTop, true, "d_srep_usr_id"     , false, "", dfNone, 0, false, false);		
		InitDataProperty(0, cnt++, dtData  , 100, daLeftTop  , true, "d_srep_usr_nm"     , false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtCombo , 40 , daCenterTop, true, "d_cust_tp_cd"      , false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData  , 50 , daCenterTop, true, "d_cust_cd"         , false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData  , 100, daLeftTop  , true, "d_cust_nm"         , false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData  , 60 , daCenterTop, true, "d_sc_no"           , false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData  , 80 , daCenterTop, true, "d_rfa_no"          , false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData  , 70 , daCenterTop, true, "d_cust_ctrl_cd"    , false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtHidden, 60 , daCenterTop, true, "d_rhq_cd"          , false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData  , 60 , daCenterTop, true, "d_rgn_ofc_cd"      , false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData  , 60 , daCenterTop, true, "d_lane"            , false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData  , 40 , daCenterTop, true, "d_cust_gid_vol"    , false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtHidden, 30 , daCenter   , true, "d_fcast_seq"       , false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtHidden, 60 , daCenterTop, true, "d_pol_cd"          , false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtHidden, 60 , daCenter   , true, "d_pod_cd"          , false, "", dfNone, 0, false, false);
		
		var calcuLogic1 = "";
		var calcuLogic2 = "";
		for ( var p = 1; p < sheet1.weekCount + 1; p++) {
			
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "trd_cd"          , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "sub_trd_cd"      , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "rlane_cd"        , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "vsl_cd"          , false, "", dfNone, 0, false, false);			                                                                            
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "skd_voy_no"      , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "skd_dir_cd"      , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "ioc_ts_cd"       , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "srep_usr_id"     , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "ctrt_ofc_cd"     , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "cust_cnt_cd"     , false, "", dfNone, 0, false, false);			                                                                            
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "cust_seq"        , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "sls_rgn_ofc_cd"  , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "pol_cd"          , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "pod_cd"          , false, "", dfNone, 0, false, false);			                                                                              
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "fcast_seq"       , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "sc_no"           , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "sc_flg"          , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "rfa_no"          , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "cust_ctrl_cd"    , false, "", dfNone, 0, false, false);	
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "ibflag"          , false, "", dfNone, 0, false, false);
			
			// 추가
			// |fcast_20ft_qty|+|fcast_40ft_qty*2|+|fcast_40ft_hc_qty*2|+|fcast_45ft_hc_qty*2|+|fcast_53ft_qty*2|		
			if(document.form.chkDs2FEU.checked){
				calcuLogic1 = "|fcast_20ft_qty_"+p+"|/2+|fcast_40ft_qty_"+p+"|"+"+|fcast_40ft_hc_qty_"+p+"|"+"+|fcast_45ft_hc_qty_"+p+"|"+"+|fcast_53ft_qty_"+p+"|";
				calcuLogic2 = "|fcast_20ft_qty_"+p+"|/2+|fcast_40ft_qty_"+p+"|";
			}else{
				calcuLogic1 = "|fcast_20ft_qty_"+p+"|+|fcast_40ft_qty_"+p+"|*2"+"+|fcast_40ft_hc_qty_"+p+"|*2"+"+|fcast_45ft_hc_qty_"+p+"|*2"+"+|fcast_53ft_qty_"+p+"|*2";
				calcuLogic2 = "|fcast_20ft_qty_"+p+"|+|fcast_40ft_qty_"+p+"|*2";
			}
			
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "vvd_"+p              , false, ""         , dfNone       , 0, false, false);
			if(document.form.chkDs2FEU.checked){
				InitDataProperty(0, cnt++, dtData, 60, daRight , false, "fcast_ttl_teu_qty_"+p, false, calcuLogic1, dfNullFloat, 1, false, false);
				MinimumValue(0, cnt - 1) = 0;                                                    
				InitDataProperty(0, cnt++, dtHidden, 60, daRight , false, "fcast_ttl_qty_"+p    , false, calcuLogic2, dfNullFloat, 1, false, false);
				MinimumValue(0, cnt - 1) = 0;			                                 
				InitDataProperty(0, cnt++, dtData, 40, daRight , false, "fcast_20ft_qty_"+p   , false, ""         , dfNullFloat, 1, false, false);		
				MinimumValue(0, cnt - 1) = 0;                                                                      
				InitDataProperty(0, cnt++, dtData, 40, daRight , false, "fcast_40ft_qty_"+p   , false, ""         , dfNullFloat, 1, false, false);	
				MinimumValue(0, cnt - 1) = 0;                                                                      
			} else {
				InitDataProperty(0, cnt++, dtData, 60, daRight , false, "fcast_ttl_teu_qty_"+p, false, calcuLogic1, dfNullInteger, 0, false, false);
				MinimumValue(0, cnt - 1) = 0;                                                    
				InitDataProperty(0, cnt++, dtHidden, 60, daRight , false, "fcast_ttl_qty_"+p    , false, calcuLogic2, dfNullInteger, 0, false, false);
				MinimumValue(0, cnt - 1) = 0;			                                 
				InitDataProperty(0, cnt++, dtData, 40, daRight , false, "fcast_20ft_qty_"+p   , false, ""         , dfNullInteger, 0, false, false);		
				MinimumValue(0, cnt - 1) = 0;
				InitDataProperty(0, cnt++, dtData, 40, daRight , false, "fcast_40ft_qty_"+p   , false, ""         , dfNullInteger, 0, false, false);
				MinimumValue(0, cnt - 1) = 0;                                                                      
			}
			InitDataProperty(0, cnt++, dtData, 40, daRight , false, "fcast_40ft_hc_qty_"+p, false, ""         , dfNullInteger, 0, false, false);
			MinimumValue(0, cnt - 1) = 0;                                                                      
			InitDataProperty(0, cnt++, dtData, 40, daRight , false, "fcast_45ft_hc_qty_"+p, false, ""         , dfNullInteger, 0, false, false);
			MinimumValue(0, cnt - 1) = 0;                                                                      
			InitDataProperty(0, cnt++, dtData, 40, daRight , false, "fcast_53ft_qty_"+p   , false, ""         , dfNullInteger, 0, false, false);
			MinimumValue(0, cnt - 1) = 0;                                                                      
			InitDataProperty(0, cnt++, dtData, 40, daRight , false, "fcast_rf_qty_"+p     , false, ""         , dfNullInteger, 0, false, false);
			MinimumValue(0, cnt - 1) = 0;                                                                      
			InitDataProperty(0, cnt++, dtData, 40, daRight , false, "fcast_ttl_wgt_"+p    , false, ""         , dfNullInteger, 0, false, false);
			MinimumValue(0, cnt - 1) = 0;   
			InitDataProperty(0, cnt++, dtData, 60, daRight , false, "fcast_rmk_"+p        , false, ""         , dfNone       , 0, false, false);                                                                   
			
			// L.OFC Forecast 물량
			if(document.form.chkDs2FEU.checked){
				InitDataProperty(0, cnt++, dtData, 60, daRight , false, "lfcast_ttl_qty_"+p      , false, ""         , dfNullFloat, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daRight , false, "lfcast_20ft_qty_"+p     , false, ""         , dfNullFloat, 1, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daRight , false, "lfcast_40ft_qty_"+p     , false, ""         , dfNullFloat, 1, false, false);
			}else{
				InitDataProperty(0, cnt++, dtData, 60, daRight , false, "lfcast_ttl_qty_"+p      , false, ""         , dfNullInteger, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daRight , false, "lfcast_20ft_qty_"+p     , false, ""         , dfNullInteger, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daRight , false, "lfcast_40ft_qty_"+p     , false, ""         , dfNullInteger, 0, false, false);
			}
			InitDataProperty(0, cnt++, dtData, 40, daRight , false, "lfcast_40ft_hc_qty_"+p  , false, ""         , dfNullInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daRight , false, "lfcast_45ft_hc_qty_"+p  , false, ""         , dfNullInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daRight , false, "lfcast_53ft_qty_"+p     , false, ""         , dfNullInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daRight , false, "lfcast_rf_qty_"+p       , false, ""         , dfNullInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daRight , false, "lfcast_ttl_wgt_"+p      , false, ""         , dfNullInteger, 0, false, false);
		}
		
		InitDataProperty(0, cnt++, isDevMode ? dtData   : dtHidden      , 50, daLeft,	true, "treeLevel", false, "", dfNone       , 0, false, false);
		InitDataProperty(0, cnt++, isDevMode ? dtStatus : dtHiddenStatus, 50, daCenter, true, "editFlg"  , false, "", dfNone       , 0, false, false);
		InitDataProperty(0, cnt++, isDevMode ? dtData   : dtHidden      , 40, daRight,	true, "rowCust"  , false, "", dfNullInteger, 0, false, false);
		InitDataProperty(0, cnt++, dtHidden  , 80 , daCenterTop, true, "d_sc_flg"          , false, "", dfNone, 0, false, false);
		HeadRowHeight = 10;
		
		InitTreeInfo(sheet1.columnCount - sheet1.tailColumnCount, "sLevel",	RgbColor(0, 0, 255), false);
		InitDataCombo(0, "d_cust_tp_cd", "BCO|NVO", "B|N");
		
		EditableColorDiff = false;
		var backColor = RgbColor(222, 251, 248);
		
		RangeBackColor(1, 15, 1, sheet1.columnCount - sheet1.tailColumnCount) = backColor;
		RangeBackColor(2, 9, 2, sheet1.columnCount - sheet1.tailColumnCount) = backColor;		
		RangeBackColor(2, sheet1.masterColumnCount, 2, sheet1.columnCount - sheet1.tailColumnCount) = RgbColor(202, 251, 220);
		RangeBackColor(3, 0, 3, sheet1.columnCount - 1) = getColor(0);
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
	
	if (sheetNo == 0) {
		changeDataSelection(document.getElementsByName("chkDs2Account")[0]);
		changeDataSelection(document.getElementsByName("chkDs2LFcast")[0]);
	}
}

function accountAddDelete() {
	var sheetObj = sheetObjects[0];
	var row      = sheetObj.SelectRow;
	var srep_id  = ComTrim(sheetObj.CellValue(row, "d_srep_usr_id"));
	if (srep_id == "") {
		ComShowCodeMessage("COM12113", "Sales Rep");
		return;
	}
	var param  = "srep_id="     + srep_id;
		param += "&srep_nm="    + sheetObj.CellValue(row, "d_srep_usr_nm"     );
		param += "&rgn_ofc_cd=" + sheetObj.CellValue(row, "d_rgn_ofc_cd"      );
	
	var rtn = window
			.showModalDialog(
					"ESM_SPC_0106.do?" + param,
					null,
					"dialogHeight:580px;dialogWidth:1050px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");
	
	if (rtn == "OK") {
		var formObject = document.form;
		doActionIBSheet(sheetObj, formObject, IBSEARCH);
	}
}

function changeDataSelection(tobj, internal) {
	var formObj = document.form;
	
	if (internal == undefined || internal == null) {
		internal == false;
	}

	var sheetObj = sheetObjects[0];
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

	case "chkDs2Account":
//		sheetObj.ShowTreeLevel(sts ? 3 : 2, 0);
		sheetObj.ColHidden("d_cust_tp_cd")   = !sts;
		sheetObj.ColHidden("d_cust_ctrl_cd") = !sts;
		sheetObj.ColHidden("d_cust_cd")      = !sts;
		sheetObj.ColHidden("d_cust_nm")      = !sts;
		sheetObj.ColHidden("d_sc_no")        = !sts;
		sheetObj.ColHidden("d_rfa_no")       = !sts;

//		if (!sts) {
//			document.all.ds2POD.checked = false;
//			changeDataSelection(document.all.ds2POD, true);
//		}
		break;

//	case "chkDs2POD":
//		if (!internal) {
//			if (!document.all.ds2Account.checked) {
//				document.all.ds2Account.checked = true;
//				changeDataSelection(document.all.ds2Account);
//			}
//			
//			sheetObj.ShowTreeLevel(sts ? 4 : 3, 0);
//		}
//
//		sheetObj.ColHidden("d_pod_cd") = !sts;
//		
//		
//		ChangeValues2(sheetObj, "d_pod_cd", "+", "d_pod_cd", "-");
//		
//		break;
	
	case "chkDs2TEU":
		var feu = formObj.chkDs2FEU;
		var oth = formObj.chkDs2OTH;
		
		if(!feu.checked && !oth.checked) {
			obj.checked = true;
		} else {
			feu.checked = false;
			oth.checked = false;
			formObj.view_type.value = "TEU";
			
			if(searchParams != "") doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
		break;
		
	case "chkDs2FEU":
		var teu = formObj.chkDs2TEU;
		var oth = formObj.chkDs2OTH;
		
		if(!teu.checked && !oth.checked) {
			obj.checked = true;
		} else {
			teu.checked = false;
			oth.checked = false;
			formObj.view_type.value = "FEU";
			
			if(searchParams != "") doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
		break;
	
	case "chkDs2OTH":
		var teu = formObj.chkDs2TEU;
		var feu = formObj.chkDs2FEU;
		
		if(!teu.checked && !feu.checked) {
			obj.checked = true;
		} else {
			teu.checked = false;
			feu.checked = false;
			formObj.view_type.value = "BOTH";
			
			if(searchParams != "") doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
		break;
	
	case "chkDs2HC":
	case "chkDs245":
	case "chkDs253":
	case "chkDs2RF":
	case "chkDs2WT":
	case "chkDs2RMK":
	case "chkDs2LFcast":
		hiddenTypeSize(sheetObj);
		break;
	}

}

function hiddenTypeSize(sheetObj) {
	var stsTeu = document.getElementsByName("chkDs2TEU")[0].checked;
	var stsFeu = document.getElementsByName("chkDs2FEU")[0].checked;
	var stsOth = document.getElementsByName("chkDs2OTH")[0].checked;
	var stsHC  = document.getElementsByName("chkDs2HC")[0].checked;
	var sts45  = document.getElementsByName("chkDs245")[0].checked;
	var sts53  = document.getElementsByName("chkDs253")[0].checked;
	var stsRf  = document.getElementsByName("chkDs2RF")[0].checked;
	var stsWt  = document.getElementsByName("chkDs2WT")[0].checked;
	var stsRmk = document.getElementsByName("chkDs2RMK")[0].checked;
	var stsLf  = document.getElementsByName("chkDs2LFcast")[0].checked;
	
	for ( var i = 1; i < sheet1.weekCount + 1; i++) {
		sheetObj.ColHidden("fcast_ttl_teu_qty_"  + i) = !(stsOth||stsHC||sts45||sts53||stsRf);
		sheetObj.ColHidden("fcast_20ft_qty_"     + i) = !(stsTeu||stsOth);
		sheetObj.ColHidden("fcast_40ft_qty_"     + i) = !(stsFeu||stsOth);
		sheetObj.ColHidden("fcast_40ft_hc_qty_"  + i) = !stsHC;
		sheetObj.ColHidden("fcast_45ft_hc_qty_"  + i) = !sts45;
		sheetObj.ColHidden("fcast_53ft_qty_"     + i) = !sts53;
		sheetObj.ColHidden("fcast_rf_qty_"       + i) = !stsRf;
		sheetObj.ColHidden("fcast_ttl_wgt_"      + i) = !stsWt;
		sheetObj.ColHidden("fcast_rmk_"          + i) = !stsRmk;
		
		sheetObj.ColHidden("lfcast_ttl_qty_"     + i) = !(stsLf && (stsOth||stsHC||sts45||sts53||stsRf));
		sheetObj.ColHidden("lfcast_20ft_qty_"    + i) = !(stsLf && (stsTeu||stsOth));
		sheetObj.ColHidden("lfcast_40ft_qty_"    + i) = !(stsLf && (stsFeu||stsOth));
		sheetObj.ColHidden("lfcast_40ft_hc_qty_" + i) = !(stsLf && stsHC);
		sheetObj.ColHidden("lfcast_45ft_hc_qty_" + i) = !(stsLf && sts45);
		sheetObj.ColHidden("lfcast_53ft_qty_"    + i) = !(stsLf && sts53);
		sheetObj.ColHidden("lfcast_rf_qty_"      + i) = !(stsLf && stsRf);
		sheetObj.ColHidden("lfcast_ttl_wgt_"     + i) = !(stsLf && stsWt);
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
	log("row : " + row);
	log("col1 : " + col1);
	log("col2 : " + col2);
	log("val : " + val);
	if (col1 != null) {
		var old_color = sheetObj.CellFontColor(row, col1);
		ChangeValue2(sheetObj, row, col1, val + sheetObj.CellValue(row, col1) * 1);
		sheetObj.CellFontColor(row, col1) = old_color;
	}

	if (col2 != null) {
		var old_color = sheetObj.CellFontColor(row, col2);
		ChangeValue2(sheetObj, row, col2, val + sheetObj.CellValue(row, col2) * 1);
		sheetObj.CellFontColor(row, col2) = old_color;
	}
}

function AddValue(sheetObj, row, col, val) {
	ChangeValue(sheetObj, row, col, val + sheetObj.CellValue(row, col) * 1);
}

var trCnt = 0;

var searchSalesRep = new Array();
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, quite) {
	if (quite == undefined)
		quite = false;
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
	case IBSEARCH: // 조회
		var sheetObj = sheetObjects[0];
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}

		var param = "year="          + formObj.year.value;
		param = param + "&week="     + formObj.week.value;
		param = param + "&duration=" + formObj.duration.value;
		param = param + "&trade="    + comObjects[0].Code;
		param = param + "&subtrade=" + comObjects[1].Code;
		param = param + "&lane="     + comObjects[2].Code;
		param = param + "&bound="    + formObj.bound.value;
		param = param
				+ "&ioc="
				+ (formObj.id_chk_ocn.checked ? formObj.id_chk_ocn.value
						: (formObj.id_chk_ipc.checked ? formObj.id_chk_ipc.value
								: formObj.id_chk_ts.value));
		param = param + "&ofc_cd=" + comObjects[3].Code;
		param = param + "&salesRep="  + comObjects[4].Code;
		param = param + "&acct_cd="   + comObjects[5].Code;
		param = param + "&vvd="       + formObj.vvd.value;
		param = param + "&view_type=" + formObj.view_type.value;
		
		searchParams = param;
		var rtn = sheetObj.GetSearchXml("ESM_SPC_0109GS.do", "f_cmd=" + (SEARCHLIST01) + "&" + param);
		
		var etcData = getEtcData(rtn);
		if (etcData["status"] == undefined || etcData["status"] != "OK"
				|| etcData["week"] == undefined) {
			ComShowMessage("Error occurred. Try again");
			return;
		}
		sheetObj.Reset();
		
		initSheet1(sheetObj, etcData["week"].substring(1));
		sheetObj.LoadSearchXml(rtn);
		
		initDataSelection(0);
		if(comObjects[0].Code == "TPS") {
			sheetObj.ColHidden("d_sc_no") = false;
			sheetObj.ColHidden("d_rfa_no") = true;
		} else if(comObjects[0].Code == "AES") {
			sheetObj.ColHidden("d_sc_no") = true;
			sheetObj.ColHidden("d_rfa_no") = false;
		} else {
			sheetObj.ColHidden("d_sc_no") = true;
			sheetObj.ColHidden("d_rfa_no") = true;
		}
		
		//Control Option 및 화면의 Data Selection과 상관없이 Total TEU 가 TEU와 값이 다르면, Total TEU를 보여주도록 수정
		//rf, wt 값이 존재하면- 무조건 열어줘
		for ( var j = 0; j < sheet1.weekCount; j++) {
			var cnt1=0;
			var cnt2=0;
			var cnt3=0;
			for( var rnum = sheetObj.HeaderRows; rnum < sheetObj.HeaderRows + sheetObj.RowCount; rnum++){
				if(sheetObj.CellValue(rnum, "vvd_"+j) == "TTL"){
					if(Number(sheetObj.CellValue(rnum, "fcast_ttl_teu_qty_"+j)) != Number(sheetObj.CellValue(rnum, "fcast_ttl_qty_"+j))){
						cnt1++;
					}
					if(Number(sheetObj.CellValue(rnum, "fcast_rf_qty_"+j)) > 0){
						cnt2++;
					}
					if(Number(sheetObj.CellValue(rnum, "fcast_ttl_wgt_"+j)) > 0){
						cnt3++;
					}
				}
			}
			
			if(cnt1>0){
				sheetObj.ColHidden("fcast_ttl_teu_qty_" + j) = false;
			}
			if(cnt2>0){
				sheetObj.ColHidden("fcast_rf_qty_" + j) = false;
			}
			if(cnt3>0){
				sheetObj.ColHidden("fcast_ttl_wgt_" + j) = false;
			}
		}
		
		ComBtnEnable("btng_addAccount2");
		ComBtnEnable("btng_addOfc");
		ComBtnEnable("btng_dlyfcast");
		break;

	case IBSAVE: // 저장
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		
		var uList = sheetObj.FindStatusRow("U");
		var uArr  = uList.split(";");
		var sheetInfo = sheet1;
		
//		for ( var i = 0; i < uArr.length - 1; i++) {
//			var row  = uArr[i] * 1;
//			var mCnt = sheet1.masterColumnCount;
//			var vvd  = "";
//			
//			for ( var p = 0; p < sheet1.weekCount; p++) {
//				vvd = sheetObj.CellValue(row, mCnt + (p * sheet1.itemColumnCount) + 18);				
//				
//				// VVD 값이 존재하면 입력한 Office 정보를 입력
//				if(vvd != "" && vvd != "TTL"){
//					if(sheetObj.CellValue(row, mCnt + (p * sheet1.itemColumnCount) + 17) == "I"){
//						sheetObj.CellValue2(row, mCnt + (p * sheet1.itemColumnCount) + 17) = "I";
//					}else{
//						sheetObj.CellValue2(row, mCnt + (p * sheet1.itemColumnCount) + 17) = "U";
//					}
//				}
//			}
//		}
		
		var param = "f_cmd=" + MULTI01
		          + "&week_count=" + sheetInfo.weekCount
		          + "&view_type="  + formObj.view_type.value;
		
		var rtn = doSaveSheet(sheetObj, "ESM_SPC_0109GS.do", param, null, !quite);
		
		if (rtn == "OK") {
			for ( var i = 0; i < uArr.length -1 ; i++) {
				var row  = uArr[i] * 1;
				var mCnt = sheet1.masterColumnCount;
				var vvd  = "";
				
				for ( var p = 0; p < sheet1.weekCount; p++) {
					vvd = sheetObj.CellValue(row, mCnt + (p * sheet1.itemColumnCount) + 18);

					if(vvd != "" && vvd != "TTL"){
						if(sheetObj.CellValue(row, mCnt + (p * sheet1.itemColumnCount) + 17) != "R"){
							sheetObj.CellValue2(row, mCnt + (p * sheet1.itemColumnCount) + 17) = "R";
						}
					}
				}
				sheetObj.RowStatus(row) = "R";
			}
		}
		
		break;

	case IBDOWNEXCEL: // 엑셀 다운로드
		sheetObj.Down2Excel(-1, false, false, true);
		break;
	}
}

/*
 * 저장후 호출
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {
	if (sheetObj.EtcData("status") == "OK") {
		ComShowMessage("saved successfully.");
	} else if (sheetObj.EtcData("status") != "OK") {
		ComShowMessage(errMsg);
	}
}

var selectedCell_OldValue    = 0;
function sheet1_OnSelectCell(sheetObj, orow, ocol, row, col) {
	selectedCell_OldValue = sheetObj.CellValue(row, col) * 1;
}

function sheet1_OnChange(sheetObj, row, col, value) {
	var orgValue = 0;
	
	with (sheetObj) {
		
		var level = CellValue(row, "treeLevel") * 1;
		// =====================================
		
		if(col > 11) {
			var colName = sheetObj.ColSaveName(col).substring(0,(sheetObj.ColSaveName(col).length)-2);
		} else {
			var colName = sheetObj.ColSaveName(col);
		}
		
		if( colName != 'fcast_ttl_teu_qty' && colName != 'fcast_ttl_qty'){
			orgValue = selectedCell_OldValue;
		}
		
		var difValue = value * 1 - orgValue;
			
		// =====================================
		if(colName == 'fcast_rmk' || colName == "rgn_ofc_cd"){
			// Remark 는 합계를 구할 필요가 없기 때문에 Status 만 변경
			setChangedStatus(sheetObj, row, col);
		} else {
			
			if(colName == "fcast_40ft_qty" && !checkUnitValue(sheetObj, row, col)) {
				SelectCell(row, col);
				return false;
			}
			
			switch (level) {
				case 2:
					var colIdx = (col - sheet1.masterColumnCount) % sheet1.itemColumnCount;
					var ttlCol = sheet1.masterColumnCount + sheet1.itemColumnCount * (sheet1.weekCount - 1) + colIdx;
					
					var frow = row;
					
					var cust_cd = CellValue(frow, "d_cust_cd");
					var pol_cd  = CellValue(frow, "d_pol_cd");
					
					var isAsigned = false;
					frow = frow + 1;
					
					while (  pol_cd == CellValue(frow, "d_pol_cd")  
						  && cust_cd  == CellValue(frow, "d_cust_cd") ) {
						
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
	
				case 3:			
					var colIdx  = (col - sheet1.masterColumnCount) % sheet1.itemColumnCount;
					var ttlCol  = sheet1.masterColumnCount + sheet1.itemColumnCount * (sheet1.weekCount - 1) + colIdx;
					var rowCust = CellValue(row, "rowCust")  * 1;
					
					// 1.현재 행의 TTL 값 변경 - 현재 행의 Total TEU, TEU, 행 끝에 TTL 관련 컬럼
					AddValue2(sheetObj, row, null, ttlCol, difValue);
					// 2.현재 행의 Lane TTL 값 변경
					AddValue2(sheetObj, rowCust, col, null, difValue);
					// 3.현재 행의 Lane Total TTL 값 변경 - 현재 행의 Lane Total 의 Total TEU, TEU, 행 끝에 TTL 관련 컬럼
					AddValue2(sheetObj, rowCust, null, ttlCol, difValue);
					setChangedStatus(sheetObj, row, col);
					break;
			}
		}
	}

	if( colName != 'fcast_ttl_teu_qty' && colName != 'fcast_ttl_qty'){
		selectedCell_OldValue = value;
	}
}

function setChangedStatus(sheetObj, row, col) {
	with (sheetObj) {
		var valueChk = true;
		var colIdx   = (col - sheet1.masterColumnCount) % sheet1.itemColumnCount;

		// ======================
		// 수정 여부 Flag 설정 시작
		// VVD Index 계산
		var itemIdx = (col - sheet1.masterColumnCount - colIdx) / sheet1.itemColumnCount;
		// 해당 VVD의 flag column 계산
		var flagCol = sheet1.masterColumnCount + itemIdx
				* sheet1.itemColumnCount + sheet1.infoColumnCount - 1;
		log("setChangedStatus flagCol : " + flagCol);
		
		var searchFlag  = CellSearchValue(row, flagCol);
		
		if(    CellValue(row, flagCol +  4) != CellSearchValue(row, flagCol +  4)		// fcast_20ft_qty
			|| CellValue(row, flagCol +  5) != CellSearchValue(row, flagCol +  5)		// fcast_40ft_qty
			|| CellValue(row, flagCol +  6) != CellSearchValue(row, flagCol +  6)		// fcast_40ft_hc_qty
			|| CellValue(row, flagCol +  7) != CellSearchValue(row, flagCol +  7)		// fcast_45ft_hc_qty
			|| CellValue(row, flagCol +  8) != CellSearchValue(row, flagCol +  8)		// fcast_53ft_qty
			|| CellValue(row, flagCol +  9) != CellSearchValue(row, flagCol +  9)		// fcast_rf_qty
			|| CellValue(row, flagCol + 10) != CellSearchValue(row, flagCol + 10)		// fcast_ttl_wgt
			|| CellValue(row, flagCol + 11) != CellSearchValue(row, flagCol + 11)		// fcast_rmk
			) {
			valueChk = false;
		}
		
		CellValue2(row, flagCol) = ( valueChk ) ? searchFlag == "" ? "" : "R" : (searchFlag == "" ? "I" : "U");
	
		var curRowEdited = false;
		for ( var i = 0; i < sheet1.weekCount; i++) {
			var colValue = CellValue(row, sheet1.masterColumnCount
					+ sheet1.itemColumnCount * i + sheet1.infoColumnCount - 1);
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

function checkUnitValue(sheetObj, row, col){
	var formObj = document.form;
	var unit    = formObj.chkDs2FEU.checked;
	
	var val = Number(sheetObj.CellValue(row, col));
	var checkVal = val*2 + "";
	if(unit){
		var rtn = ComIsNumber(checkVal);
		if(rtn == false){
			ComShowMessage("In case of FEU unit, you can only enter decimal point as 0.0 or 0.5");
			return rtn;
		}
	}
	return true;
}

function sheet1_OnClick(sheetObj, Row, Col, Value){
	var colName = sheetObj.ColSaveName(Col);
	//remark 셀을 클릭했을때 MemoPad를 표시
	if (colName.substring(0, colName.length-2) == "fcast_rmk") {
		// 	ComShowMemoPad(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax)
		if(sheetObj.CellBackColor(Row, Col) == sheetObj.RgbColor(255, 255,128)) {
			
			// Contract F'cast 입력가능한 사용자에게만 Remark 편집 가능하게 함.
			if(sheetObj.Editable)
				ShowMemoPad(sheetObj);
			else
				ShowMemoPad(sheetObj, Row, Col, true);
		}
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

	laneChange = true; // lane 변경
	
	var arrLane = text.split("|");
	if(arrLane.length > 1) {
		comObjects[0].Code2 = arrLane[0];
		comObjects[1].Code2 = arrLane[1];
	} else {
		comObjects[0].Code2 = comObj.GetText(value,0);  
		comObjects[1].Code2 = comObj.GetText(value,1);  
	}	

	trade_OnChange2(comObjects[0], comObjects[0].Text, text);
	laneChange = false; // lane 변경 초기화

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

	if (!laneChange) { // lane 변경없을시(trade 변경시)
		comObjects[1].Code2 = '';
		comObjects[2].Code2 = '';
	}
}

/**
 * Trade 변경시
 *  - 선택된 Trade에 해당하는 Sub Trade 및 Rev. Lane 정보 가져와서 Combo Box 셋팅
 */
function trade_OnChange_t(combj, value, text){

	if (document.all.vvd.value != "")
		return;

	if (value.charAt() != "I") {
		document.all.id_chk_ocn.checked  = true;
		document.all.id_chk_ocn.disabled = true;
		document.all.id_chk_ipc.disabled = true;
		document.all.id_chk_ts.disabled  = true;
	} else {
		document.all.id_chk_ipc.checked  = true;
		document.all.id_chk_ocn.disabled = true;
		document.all.id_chk_ipc.disabled = false;
		document.all.id_chk_ts.disabled  = false;
	}

	if (!laneChange) { // lane 변경없을시(trade 변경시)
		comObjects[1].Code2 = '';
		comObjects[2].Code2 = '';
	}
	
	var formObj = document.form;
	// [S] 2012.01.19 SHKIM CHECK 가져오기 ..
	var trade = formObj.trade.Code;
	formObj.subtrade1.Code2 = "";	
	formObj.bound.value     = "";	
	if(trade != null && trade != ''){		
		SpcSearchOptionSubTrade("subtrade1",true,false, "", "", formObj.trade.Code);			// 0207 SHKIM			
		SpcSearchOptionLane("rlane1",true,true,'',formObj.trade.Code,'',true);	// 0207 SHKIM
		ctrtOffice_OnChange(comObjects[3], comObjects[3].Code, comObjects[3].Text);
	}	
	// [E] 2012.01.19 SHKIM CHECK 가져오기 ..
	RevenueLaneSetting(formObj.trade.Code);
	
	// Contract Office 가져오기
	var rtn = getCodeList("CtrtOffice", "ofc_cd="   + tmpOfc
									 + "&level=4"
									 + "&trade="    + value
									 + "&year="     + document.form.year.value
						             + "&week="     + document.form.week.value
						             + "&duration=" + document.form.duration.value);
	initData_ctrtOffice(rtn[0].split("|"), rtn[1].split("|"));
}


function subtrade1_OnChange_t(combj, value, text) {
	var formObj = document.form;		
	var trade   = formObj.trade.Code;
	var sub_trd = formObj.subtrade1.Code;
	var dir_cd  = formObj.bound.value;
	
	ComOpenWait(true);
	//reset_rlane_combo("rlane1",false);		
	if(trade == null && trade == ''){
		ComShowMessage(getMsg("SPC90117", "Trade"));
		ComOpenWait(false);
		return;
	}		
	
	// [E] 2012.01.19 SHKIM CHECK 가져오기 ..
	RevenueLaneSetting(formObj.trade.Code, formObj.subtrade1.Code); 		
	ComOpenWait(false);
}

function ctrtOffice_OnChange(comObj, value, text) {
	var rtn = getCodeList("CtrtSalesRep",   "ofc_cd="    + document.getElementById("ctrtOffice").Code
			                              + "&trade="    + document.form.trade.Code
			                              + "&year="     + document.form.year.value
			                              + "&week="     + document.form.week.value
			                              + "&duration=" + document.form.duration.value);
	
	initData_salesRep(rtn[0].split("|"), rtn[1].split("|"));
	
	// Index = 0 값을 늦게 가져와서 재호출
	var srepObj = document.getElementById("salesRep");
	salesRep_OnChange(srepObj, srepObj.Code, srepObj.Text);
}

function salesRep_OnChange(comObj, value, text) {
	if(value == -1)
		return;
	
	var rtn = getCodeList("Account",   "srep_cd="   + value
									 + "&ofcCd="    + document.form.ctrtOffice.Code
                                     + "&trade="    + document.form.trade.Code
			                         + "&year="     + document.form.year.value
			                         + "&week="     + document.form.week.value
			                         + "&duration=" + document.form.duration.value);
	
	initData_acctList(rtn[0].split("|"), rtn[1].split("|"));
}

function initDataValue_ctrtOffice() {
	var sheetObj = document.getElementById("ctrtOffice");
	with (sheetObj) {
		Index2 = 0;
	}
}

function initData_ctrtOffice(codes, names) {
	var sheetObj = document.getElementById("ctrtOffice");
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

function initData_acctList(codes, names) {
	var sheetObj = document.getElementById("acct");
	var cnt = 0;
	
	with (sheetObj) {
		RemoveAll();
		SetTitle("Code|Name");
		SetColWidth("80|250");
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

function initData_salesRep(codes, names) {
	var sheetObj = document.getElementById("salesRep");
	var cnt = 0;

	with (sheetObj) {
		RemoveAll();
		SetTitle("Code|Name");
		SetColWidth("60|150");
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
			if (txt[3] == "1") {
				selectCode = codes[i];
			}
			InsertItem(-1, codes[i] + "|" + txt[0], codes[i]);
		}

		if (selectCode != "") {
			Code = selectCode;
		} else if(strSrep_cd != ""){
			Code = strSrep_cd;
		}else {
			Index = 0;
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
		
		if(sel_vvd == ""){
			var sel_subtrd = comObjects[1].Code;
			var sel_lane   = comObjects[2].Code;
			if (sel_subtrd == "" && sel_lane == "") {
				ComShowMessage(getMsg("SPC90143", "Sub Trade", "Lane"));
				comObjects[1].focus();
				return false;
			}
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
	
	case IBSAVE:
		var uList = sheetObj.FindStatusRow("I");
		var uArr  = uList.split(";");
		var sheetInfo = sheet1;
		
		for ( var i = 0; i < uArr.length - 1; i++) {
			var row = uArr[i] * 1;
			
			// Add 한 Row 일 경우 배경색 및 Value 존재 여부 체크
			if(sheetObj.CellValue(row, "d_rgn_ofc_cd") == "" && (sheetObj.CellBackColor(row, "d_rgn_ofc_cd") == sheetObj.RgbColor(255, 255, 128))) {
				ComShowMessage(getMsg("SPC90139", "Loding Office"));
				sheetObj.SelectCell(row, "d_rgn_ofc_cd");		// Focus 이동
				return false;
			}
		}
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

function initDataValue_subtrade1() {
	var sheetObj = document.getElementById("subtrade1");
	with (sheetObj) {
		Index2 = 0;
	}
}

function initDataValue_lane1() {
	var sheetObj = document.getElementById("lane1");
	with (sheetObj) {
		Index2 = 0;
	}
}

/**
 * Start Week 의 year 변경시
 * Start Week 의 year 변경시 주차 변경
 */
function checkWeek(){
	SpcSearchOptionWeek("week",false,document.form.year.value)
	
	var sel_trade = comObjects[0].Code;
	if(sel_trade != ""){
		var srepObj = document.getElementById("salesRep");
		salesRep_OnChange(srepObj, srepObj.Code, srepObj.Text);
	}
}

/**
 * Week 변경시 salesRep 재조회
 */
function weekOnchange(){
	var sel_trade = comObjects[0].Code;
	if(sel_trade != ""){
		var srepObj = document.getElementById("salesRep");
		salesRep_OnChange(srepObj, srepObj.Code, srepObj.Text);
	}
}

/**
 * Revenue Lane Setting
 * 	- 선택된 Trade / Sub Trade 에 해당하는 Rev. Lane 조회 후 Combo 셋팅
 */
function RevenueLaneSetting(trdCd, subTrdCd ) {	
	
	if(trdCd == undefined || trdCd == null){
 		trdCd = '';
 	}     		
 	if(subTrdCd == undefined || subTrdCd == null){
 		subTrdCd = '';
 	}    
	rlane_rtn_xml = SpcSearchRevLane("rlane1",true,"N",true,trdCd,subTrdCd); 		
	var rlane1_combo = document.getElementById("rlane1");		
	ComXml2ComboItem(rlane_rtn_xml, rlane1_combo, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm|flg");
	rlane1_combo.InsertItem(0, "||ALL|ALL|");
}

function laneOfficeAddDel() {
	var sheetObj = sheetObjects[0];
	var selRow   = sheetObj.SelectRow;
	
	// TPS인 경우에는 S/C No를 선택해야함.
	// TPS 외 Trade 경우에는 S/C No가 아닌 화주로 체크.
	if(    (comObjects[0].Code == "TPS" && ComTrim(sheetObj.CellValue(selRow, "d_sc_no")) != "")
		|| (comObjects[0].Code != "TPS" && sheetObj.CellValue(selRow, "d_cust_cd")    != "")) {
		var url = "ESM_SPC_0111.do?&" + searchParams
		        + "&cust_cnt_cd="     + sheetObj.CellValue(selRow, "d_cust_cd")
		        + "&cust_nm="         + sheetObj.CellValue(selRow, "d_cust_nm")
		        + "&fcast_seq="       + sheetObj.CellValue(selRow, "d_fcast_seq")
		        + "&sc_no="           + sheetObj.CellValue(selRow, "d_sc_no")
		        + "&rfa_no="          + sheetObj.CellValue(selRow, "d_rfa_no")
		        + "&sc_flg="          + sheetObj.CellValue(selRow, "d_sc_flg");
		var rtn = window.showModalDialog(url, window, "scroll:no;status:no;help:no;dialogWidth:560px;dialogHeight:520px");
		
		if (rtn == "OK") {
			var formObject = document.form;
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
		}
	} else {
		ComShowCodeMessage("COM12113", (comObjects[0].Code=="TPS"?"SC NO":"Account"));
	}
}

function sheet1_OnDblClick(sheetObj, row, col) {
	var colName = sheetObj.ColSaveName(col).substring(0,(sheetObj.ColSaveName(col).length)-2);
	var vvd = sheetObj.CellValue(row, col);
	
	if(colName == "vvd" && vvd != "" && vvd != "TTL") {
		var url   = "ESM_SPC_0071.do?&vvd=" + vvd;
		window.showModalDialog(url, window, "scroll:no;status:no;help:no;dialogWidth:"+700+"px;dialogHeight:"+450+"px")
	}
}

/**
 * 마우스가 이동될 때 이벤트 처리 
 * 
 * @param sheetObj
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
	var Row = sheetObj.MouseRow;
	var Col = sheetObj.MouseCol;
	
	var colNm = sheetObj.ColSaveName(Col);
	var wk    = colNm.substring(colNm.length-1);
	
	// VVD 항목에서만 마우스 포인터 손가락 모양으로 변경.
	var vvd = sheetObj.CellValue(sheetObj.MouseRow, sheetObj.MouseCol);
	var dir = vvd.substr(vvd.length-1);
	
	if(vvd.length == 9 && dir == ("E"||"W"||"N"||"S")){
		sheetObj.MousePointer = "Hand";
	}else{
		sheetObj.MousePointer = "Default";
	}
}

/**
 * IBSheet의 특정셀의 글자가 줄바꿈되어 한눈에 볼수 없을때 MemoPad를 이용하여 확인하거나 값을 변경할 때 사용한다. <br>
 * MemoPad는 TextArea와 버튼으로 구성되며, 값을 확인하고 MemoPad를 닫을때는 ESC키를 누르거나 Close 버튼을 누르거나 HTML 영역을 클릭한다. <br>
 * MemoPad가 표시될 위치의 셀은 반드시 편집불가능이어야 한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *    function sheet1_OnClick(sheetObj, Row, Col, Value) {
 *        //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
 *        if (sheetObj.ColSaveName(Col) == "desc") ComShowMemoPad(sheetObj);
 *    }
 *    function sheet2_OnClick(sheetObj, Row, Col, Value) {
 *        //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집불가능)
 *        if (sheetObj.ColSaveName(Col) == "desc") ComShowMemoPad(sheetObj, Row, Col, true);
 *    }
 * </pre>
 * @param {ibsheet} 	sheetObj    필수,IBSheet Object
 * @param {int} 		row    		선택,MemoPad를 표시할 셀의 행 Index, default=sheetObj.SelectRow
 * @param {int} 		col    		선택,MemoPad를 표시할 셀의 컬럼 Index, default=sheetObj.SelectCol
 * @param {bool} 		bReadOnly	선택,MemoPad에 표시된 값의 편집가능 여부, default=true
 * @param {int}    		iWidth		선택,MemoPad의 넓이, default=200
 * @param {int}    		iHeight		선택,MemoPad의 높이, default=200
 * @see #ComHideMemoPad
 * @return 없음<br>
 */
function ShowMemoPad(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax) {
	try{
		//함수의 인자 default 값 설정하기			
		if (row == undefined 		|| row == null) 		row=sheetObj.SelectRow;
		if (col == undefined 		|| col == null) 		col=sheetObj.SelectCol;
		if (bReadOnly == undefined  || bReadOnly == null) 	bReadOnly=false;
		if (iWidth == undefined 	|| iWidth == null) 		iWidth = 200; 
		if (iHeight == undefined 	|| iHeight == null) 	iHeight = 200; 
		if (iMax == undefined 	    || iMax == null) 	    iMax = 4000; 

		//메모를 위한 IBSheet 정보의 Validation 확인하기
		if (sheetObj.CellEditable(row,col)) {
			return ComShowMessage("[ComShowMemoPad] "+ sheetObj.id + "(" + row + "," + col + ") 셀은 편집불가능이어야 합니다.");
		}
		//메모를 위한 IBSheet 정보 받기
		if (!ComIsNumber(col)) col = sheetObj.SaveNameCol(col);
        memoSheet=sheetObj;
        memoRow=row;
        memoCol=col;

		//메모메드 만들기
		if (!memoPadInit(iMax)) return;
		
        //메모 DIV 표시할 위치 계산하기 (AnchorPosition_getPageOffsetLeft, AnchorPosition_getPageOffsetTop 함수는 ComCalendar.js 있는것을 사용함)
        var iLeft = AnchorPosition_getPageOffsetLeft(sheetObj) + sheetObj.ColLeft(col) + 2;
        var iTop  = AnchorPosition_getPageOffsetTop(sheetObj)  + sheetObj.RowTop(row)  + 2;
        if (sheetObj.CountPosition!= 0)  iTop += 16; //건수정보가 표시될 때 표시위치를 조금 내린다.

        //현재페이지가 iframe이나 frame 안에 있고, 그것의 scrolling이 불가능한 경우 표시 위치를 변경함
        if (top.document != document && window.frameElement.scrolling=="no") {
        	//높이초과
        	if (iTop + iHeight  > document.body.clientHeight) {
        		iBottom = iTop + sheetObj.RowHeight(row);
        		if (iBottom > document.body.clientHeight) iBottom = document.body.clientHeight;  
        		iTop = iBottom-iHeight;
        		if (iTop <0) iTop = 0
        	}
        	
        	//넓이초과
            if (iLeft + iWidth  > document.body.clientWidth)   {
            	iLeft = document.body.clientWidth - iWidth;    
            	if (iLeft<0) iLeft = 0;
            }
        }

        var _divMemo = document.getElementById(MEMO_DIV_NAME);
        var _frameDoc  = document.getElementById(MEMO_FRAME_NAME).contentWindow.document;

		_frameDoc.getElementById("btn_apply").style.display = (bReadOnly)?"none":"inline";
        _frameDoc.getElementById(MEMO_TEXT_NAME).style.backgroundColor = bReadOnly?"#E8E7EC":"";
        _frameDoc.getElementById(MEMO_TEXT_NAME).style.fontFamily  = sheetObj.SheetFontName;
        _frameDoc.getElementById(MEMO_TEXT_NAME).style.fontSize  = 11;
		_frameDoc.getElementById(MEMO_TEXT_NAME).style.height = iHeight-25;
        _frameDoc.getElementById(MEMO_TEXT_NAME).value = sheetObj.CellText(row,col);
        _frameDoc.getElementById(MEMO_TEXT_NAME).readOnly = bReadOnly;

		_divMemo.style.width = iWidth;
		_divMemo.style.height = iHeight;
        _divMemo.style.top = iTop;
        _divMemo.style.left = iLeft;
        _divMemo.style.visibility = "visible";
        _divMemo.focus();	
        
        ComSetFocus(_frameDoc.getElementById(MEMO_TEXT_NAME));
    } catch(err) { ComFuncErrMsg(err.message); }
}

/**
 * MemoPad를 위한 DIV안에 iFrame을 만들고, iFrame안에 Textarea와 버튼을 생성한다. <br>
 * 이 함수는 이파일(CoObject.js)에서만 사용하기 위한 목적으로 만들졌다. <br>
 */
function memoPadInit(iMax) {
	try {
        //메모용 Div가 없으면 생성한다.
        if (document.getElementById(MEMO_DIV_NAME) != null) return true;
		
		//메모용 Div 만들기	        
        var _divMemo=document.createElement("<div id='"+  MEMO_DIV_NAME +"' style='position:absolute; overflow:hidden; width:200px; height:200px; visibility:hidden'/>");
        document.body.insertBefore(_divMemo);

        //메모용 Div 안에 iFrame 만들기(Select태그나 Object태그 위쪽으로 나타나게 하기 위함)
        var _frameMemo = document.createElement("<IFRAME id='"+MEMO_FRAME_NAME+"' src='' frameborder=0 marginHeight=0 marginWidth=0 width=100% height=100% />");
        _divMemo.appendChild(_frameMemo);	        

        var _FrameDoc = _frameMemo.contentWindow.document;

		//iFrame안에 Div 태그 만들기(테두리 만들기,ESC키시 닫기처리 위함)
        var _FrameDiv=_FrameDoc.createElement("<div onkeydown='if(event.keyCode==27) parent.ComHideMemoPad(true);' style='border:1.2px solid #aaa; padding:1px; overflow:hidden; background-color:#E6EFF6; width:100%; height:100%;'/>");
        _FrameDoc.appendChild(_FrameDiv);
        
		//Div안에 Textarea 만들기
        var _area = _FrameDoc.createElement("<textarea id='" + MEMO_TEXT_NAME +"' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; color:#4f4f4f; height:175px; width:100%'/>");
        _FrameDiv.appendChild(_area);
        
        //Div 안에 center 태그 만들기(버튼을 가운데 놓기 위함)
        var _centerTag = _FrameDoc.createElement("<center>");
        _FrameDiv.appendChild(_centerTag);
		
		//Apply 버튼 만들기
        var _button1 = _FrameDoc.createElement("<span id='btn_apply' style='font-size:9pt;cursor:hand;width:40;height:18;padding:0,3,0,3;text-align:center;border:1 solid gray;background-color:#eaeaea' onclick='parent.setMemo(document.getElementById(\""+MEMO_TEXT_NAME+"\").value,"+iMax+");'/>");
        _button1.innerHTML = "Apply";
        _centerTag.appendChild(_button1);
        
		//Close 버튼 만들기
        var _button2 = _FrameDoc.createElement("<span id='btn_close' style='font-size:9pt;cursor:hand;width:40;height:18;padding:0,3,0,3;text-align:center;border:1 solid gray;background-color:#eaeaea' onclick='parent.ComHideMemoPad(true)'/>");
        _button2.innerHTML = "Close";
        _centerTag.appendChild(_button2);
        
        //메모용 iFrame 자동 닫기 처리
        if (document.onmouseup==null || document.onmouseup.toString().indexOf("ComHideMemoPad") < 0) {
	        //Axon에서 onmouseup을 쓰고 있으므로, 아래와 같은 방법으로 MemoPad 닫기 처리
	        window.popupMemoOldEventListener = document.onmouseup;
	        if (window.popupMemoOldEventListener != null) {
	        	//alert("CoObject \n" + window.popupMemoOldEventListener.toString());
	            //기존에 document.onmouseup에  정의된 함수가 있는 경우
	            document.onmouseup = new Function("window.popupMemoOldEventListener(); ComHideMemoPad();");
	        } else {
	            //기존에 document.onmouseup에  정의된 함수가 없는 경우
	            document.onmouseup = ComHideMemoPad;
	        }
	        
	        //ActiveX에 포커스가 갔을때 메모DiV 닫기
	        var objs = document.getElementsByTagName("OBJECT")
			window.popupMemoOldObjEventListener = new Array(objs.length);
	        for(var i = 0 ; i < objs.length ; i++){
		        window.popupMemoOldObjEventListener[i] = objs[i].onfocus;
		        if (window.popupMemoOldObjEventListener[i] != null) {
		            //기존에 document.onmouseup에  정의된 함수가 있는 경우
		            objs[i].onfocus = new Function("window.popupMemoOldObjEventListener["+i+"](); ComHideMemoPad();");
		        } else {
		            //기존에 document.onmouseup에  정의된 함수가 없는 경우
		            objs[i].onfocus = ComHideMemoPad;
		        }
	        }
        }
    } catch(err) { ComFuncErrMsg(err.message); return false;}
    return true;
}

function setMemo(sValue,iMax) {
	try {
		if(sValue.length > iMax){
			ComShowMessage("characters long");
//			document.getElementById(MEMO_FRAME_NAME).focus();
			return;
		}else{
			if (memoSheet == null) return;
			
			memoSheet.CellValue(memoRow, memoCol) = sValue;
			ComHideMemoPad(true);
		}
    } catch(err) { ComFuncErrMsg(err.message); }
}

// Daily Forecast Status - FCST&PFMC Status by ACCT 탭 링크
function callDailyForecast(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var selRow   = sheetObj.SelectRow;
	
	if(sheetObj.CellValue(selRow, "d_rgn_ofc_cd") == ""){
		ComShowCodeMessage("COM12113", "Load Office");
		return;
	}
	
	var cust_cd  = ComTrim(sheetObj.CellValue(selRow, "d_cust_cd"));
	cust_cd = cust_cd.substr(0,2) + ComLpad(cust_cd.substr(2), 6, "0");
	
	
	var param = "year="             + formObj.year.value;
	param = param + "&week="        + formObj.week.value;
	param = param + "&duration="    + formObj.duration.value;
	param = param + "&trade="       + formObj.trade.Code;
	param = param + "&sub_trade="   + formObj.subtrade1.Code;
	param = param + "&rlane_cd="    + formObj.rlane1.Code;
	param = param + "&rhq="         + sheetObj.CellValue(selRow, "d_rhq_cd");
	param = param + "&rgn_cd="      + sheetObj.CellValue(selRow, "d_rgn_ofc_cd")
	param = param + "&acct_cd="     + cust_cd;
	
	ComOpenWindow("ESM_SPC_0021.do?" + param, 'none',"height=650,width=1024,status=0,resizable=yes");
}



/**************** IE11지원을 위해 combobox 잔상 제거용 코드 추가 ****************/
/*
 * 기존의 onChange를 onChange_t로 변경하고, onChange에서는 timeout을 두어 onChange_t를 호출하도록 변경함
 */
function trade_OnFocus(combj, value, text){
    document.getElementById("year").focus();
    document.getElementById("trade").focus(); 
}

function subtrade1_OnFocus(combj, value, text){
    document.getElementById("year").focus();
    document.getElementById("subtrade1").focus(); 
}

function rlane1_OnFocus(combj, value, text){
    document.getElementById("year").focus();
    document.getElementById("rlane1").focus(); 
}

function trade_OnChange(combj, value, text){
	 var formObj = document.form;
	 setTimeout(function(){trade_OnChange_t(formObj,value)},10);
}

function subtrade1_OnChange(combj, value, text){
	 var formObj = document.form;
	 setTimeout(function(){subtrade1_OnChange_t(formObj,value)},10);
}
/* 개발자 작업 끝 */
