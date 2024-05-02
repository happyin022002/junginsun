/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_cim_1049.js
 *@FileTitle : Load Factor by Trade
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.11
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.06.11 박광석
 * 1.0 Creation
 * ======================================================
 * 2010.10.18 최윤성 [CHM-201006559-01] sheet1_OnSearchEnd() 오류 수정
 * 2011.10.26 신자영 [CHM-201113916-01] [CIM] Load factor by cy의 sub-trade 검색 기능 추가
 * 2011.11.01 신자영 [CHM-201114141-01] [CIM] L/F by trade & M/B by vessel 기능에 EM1 & EM2 Lane 추가
 * 2012.05.14 신자영 [CHM-201217818-01] L/F by Trade & Match-back by Vessel 모듈 검색 가능 기간 확장
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
 * @class ees_cim_1049 : ees_cim_1049 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cim_1049() {
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
var IBSEARCH02 = 30;
var enterSwitch = false;
//2011.10.26 신자영 [CHM-201113916-01] Sub Trade관련 combo생성
var comboObjects = new Array();
var comboCnt = 0;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];
	var comboObjects1 = comboObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			sheetObjects[0].SelectRow = 0;
			break;

		case "btn_New":
			sheetObject1.RemoveAll();
			comboObjects1.RemoveAll();
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
			formObject.reset();

			ComSetFocus(formObject.fromdate);
			break;

		case "btns_calendarfm":

			var cal = new ComCalendarFromTo();
			cal.select(formObject.fromdate, formObject.todate, 'yyyy-MM-dd');

			break;
		case "btns_calendarto":

			var cal = new ComCalendarFromTo();
			cal.setEndFunction("nextFocusOut");
			cal.select(formObject.fromdate, formObject.todate, 'yyyy-MM-dd');

			break;
		case "btn_lane": //lane 조회 팝업
			var param = "?lane_cd=" + formObject.lane.value;
			ComOpenPopup("/hanjin/COM_ENS_081.do", 755, 450, "popupFinish", "1,0,1,1,1,1,1,1", true);
			break;
		case "btn_vvd": //vvd 조회 팝업
			var param = "?vvd_cd=" + formObject.vvd.value;
			ComOpenPopup("/hanjin/COM_ENS_0B2.do", 755, 450, "popupFinish", "1,0,1,1,1,1,1,1", true);
			break;
		case "btn_Rdr":
			// 버튼이 활성화 되어있을때만 기능
			if (ComIsBtnEnable(srcName)) {
				var sUrl = "/hanjin/VOP_OPF_0045.do?" + "vsl_cd=" + sheetObject1.Cellvalue(sheetObject1.SelectRow, "vvd").substring(0, 4) + "&voy_no="
						+ sheetObject1.Cellvalue(sheetObject1.SelectRow, "vvd").substring(4, 8) + "&dir_cd="
						+ sheetObject1.Cellvalue(sheetObject1.SelectRow, "vvd").substring(8, 9) + "&region="
						+ sheetObject1.Cellvalue(sheetObject1.SelectRow, "fromregion");
				//ComOpenPopup(sUrl, 1024, 670, "", "0,0", false);
				
				ComOpenPopupWithTarget(sUrl, 1024, 670, "", "0,0", true, "yes");

			}
			break;

		case "btn_LRange":
			// 버튼이 활성화 되어있을때만 기능
			if (ComIsBtnEnable(srcName)) {
				var sUrl = "/hanjin/VOP_VSK_0012.do";
				ComOpenPopupWithTarget(sUrl, 1020, 710, "", "0,0", true, "yes");

			}
			break;
		case "btn_DownExcel":
			sheetObject1.Down2Excel(-1);
			break;

		case "btn_Print":
			if (sheetObject1.rowcount == 0) {
				errMsg = 'No data found.';
				ComShowMessage(msgs["CIM29030"]);
				return;
			}
			formObject.f_cmd.value = IBSEARCH02;
			ComOpenPopupWithTarget('/hanjin/EES_CIM_1949.do', 775, 700, "", "0,1,1,1,1,1,1", true);
			break;

		} // end switch

	} catch (e) {
		if (e == "[object Error]") {
			alert("지금은 사용하실 수가 없습니다 ");
		} else {
			alert(e);
		}
	}
}

function nextFocusOut() {
	document.form.trade.focus();
}

/**
 * lane code 팝업에서 선택한 값 Setting.
 */
function popupFinish(aryPopupData, row, col, sheetIdx) {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	formObject.lane.value = aryPopupData[0][3]
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

	for (i = 0; i < sheetObjects.length; i++) {

		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);

		ComEndConfigSheet(sheetObjects[i]);
	}
	//IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
	}
	comboObjects[0].RemoveAll();
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
	initControl();

}
function initCombo(comboObj, comboNo) {

		switch (comboObj.id) {
		case "subtrade":
			with (comboObj) {
				comboObj.RemoveAll();
				SetColAlign("center|center|left");
				SetColWidth("50|60|240");
				SetTitle("Trade|SubTrade|Description");
				MultiSelect = false;
				UseAutoComplete = true;
				DropHeight = 200;
				ValidChar(2, 0);
				MaxLength = 3;
				comboObj.Enable = true;
			}
			break;
		}
		
}


/*
 * 변경 - OnFocus의 경우 시점차로 잔상 현상이 보여 trade변경시에 미리 subtrade List조회되도록 함
function subtrade_OnFocus(comboObj) {
	//if (comboObjects[0].GetCount() <= 0) {
		//comboObj.Enable = false;
		//initCombo(comboObjects[0],1);
		comboObj.RemoveAll();
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
		if (comboObjects[0].GetCount() > 0) {
			comboObj.Enable = true;
			comboObjects[0].focus();
			document.form.trade.value = 'AL';   
		}

	//}

}
*/

function tradeChange(cel){
	//initCombo(comboObjects[0],1);
	comboObjects[0].RemoveAll();
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
	if (comboObjects[0].GetCount() > 0) {
		comboObjects[0].Enable = true;
		comboObjects[0].focus(); 
	}	
}

function initControl() {

	document.form.fromdate.focus();
	axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
	axon_event.addListenerFormat('focus', 'obj_activate', document.form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerForm('blur', 'obj_deactivate', document.form); //- form OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerFormat('keyup', 'form_keyup', document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	// btn_Rdr 버튼 Disable
	ComBtnDisable("btn_Rdr");
	// btn_LRange 버튼 Disable
	ComBtnDisable("btn_LRange");
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
		with (sheetObj) {
			// 높이 설정
			style.height = 400;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "Seq|Com|Region|Trade|Lane|VVD|Last\nPort|ATD|Week|Full (Box)|Full (Box)|Full (Box)|Full (Box)|Full (Box)|MTY (Box)|MTY (Box)|MTY (Box)|MTY (Box)|MTY (Box)|Box\nTotal|TEU\nTotal|Dead\nSlot(T)|Weight\nTotal|Released|Released|BSA|BSA|Unused|Unused|Load Factor|Load Factor|Load Factor|Data\nSource";
			var HeadTitle2 = "Seq|Com|Region|Trade|Lane|VVD|Last\nPort|ATD|Week|20'|40'|H/C|45'|Total|20'|40'|H/C|45'|Total|Box\nTotal|TEU\nTotal|Dead\nSlot(T)|Weight\nTotal|TEU|Weight|Space|Weight|Space|Weight|Full(%)|EQ(%)|WGT(%)|Data\nSource";

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//			var fullLf = "IF(|bsaspace| == 0,0,( |full20qty| +  2 * ( |full40qty| + |fullhcqty| + |full45qty| ) + |deadslot|  ) / ( |bsaspace| + |releasedteu| ))";
			//			var EQLf = "IF(|bsaspace| == 0,0,  (|Teu_Total| + |deadslot| ) / ( |bsaspace| + |releasedteu| ))";
			//			var WGTLf = "IF(|bsaweight| = 0, 0, |weighttotal| / ( |bsaweight| + |releasedweight| ))";
			/*
			 var unusedSpace = "|bsaspace| - ( |Teu_Total| + |deadslot| ) + |releasedteu|";
			 var unusedWeight = "( |bsaweight| - |weighttotal| ) + |releasedweight|";
			 var fullTotal = "|full20qty| + |full40qty|+ |fullhcqty|+ |full45qty|";
			 var mtyTotal = "|mty20qty| + |mty40qty|+ |mtyhcqty|+ |mty45qty|";
			 var cBoxTotal = "|fulltotal| + |mtytotal|";
			 var cTEUTotal = "( |full20qty| + ( 2 * ( |full40qty| + |fullhcqty| + |full45qty| ) ) ) + ( |mty20qty| + ( 2 * ( |mty40qty| + |mtyhcqty| + |mty45qty| ) ) )";
			 */
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			//    				InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,		true,		"hdnStatus");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "colsorts", false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "company", false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "fromregion", false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "trade", false, "", dfNone, 0);

			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "lane", false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "vvd", false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "port", false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "atd", false, "", dfDateYmd, 0);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "atd_week", false, "", dfNone, 0);

			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "full20qty", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "full40qty", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "fullhcqty", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "full45qty", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "fulltotal", false, "", dfNullInteger, 0);

			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "mty20qty", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "mty40qty", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "mtyhcqty", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "mty45qty", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "mtytotal", false, "", dfNullInteger, 0);

			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "boxtotal", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "teutotal", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "deadslot", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "weighttotal", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "releasedteu", false, "", dfNullInteger, 0);

			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "releasedweight", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "bsaspace", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "bsaweight", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "unusedspace", false, "", dfNullInteger, 0);
			InitDataProperty(0, cnt++, dtAutoSum, 50, daRight, true, "unusedweight", false, "", dfNullInteger, 0);

			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "lffull", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "lfeq", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "lfwgt", false, "", dfNone, 1);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "datasource", false, "", dfNone, 0);
			//			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "colsorts",
			//					false, "", dfNone, 0);

			CountPosition = 0;
			FrozenCols = 9;

		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회
		if (validateForm(sheetObj, formObj, sAction)) {

			if (sheetObj.id == "sheet1") {
				formObj.f_cmd.value = COMMAND01;
				sheetObj.WaitImageVisible = false;
				sheetObj.Redraw = false;
				ComOpenWait(true);

				var sXml = sheetObj.GetSearchXml("EES_CIM_1049GS.do", FormQueryString(formObj));
				var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");

				if (backendJobKey.length > 0) {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.RequestTimeOut = 10000;
					timer1 = setInterval(getBackEndJobStatus, 1000);
				}
			}

		} else {
			return;
		}
		break;
	case IBSEARCH_ASYNC01: //lane focusOut
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH01;

			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_1049GS.do", FormQueryString(formObj));
			var sCheck = ComGetEtcData(sXml, "check");
			if (sCheck != "OK") {
				ComShowCodeMessage("CIM29012");
				document.form.lane.value = "";
				sheetObj.WaitImageVisible = true;
				ComSetFocus(document.form.lane);
				return false;
			}
			sheetObj.WaitImageVisible = true;
			ComSetFocus(document.form.vvd);
		} else {
			return;
		}

		break;
	case IBSEARCH_ASYNC02: //vvd focusOut
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH03;

			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_1033GS.do", FormQueryString(formObj));
			var sCheck = ComGetEtcData(sXml, "check");
			if (sCheck != "OK") {
				ComShowCodeMessage("CIM29023");
				document.form.vvd.value = "";
				sheetObj.WaitImageVisible = true;
				ComSetFocus(document.form.vvd);
				return false;
			}
			sheetObj.WaitImageVisible = true;
		} else {
			return;
		}

		break;
	//2011.10.26 신자영 [CHM-201113916-01] Sub Trade 조회 로직 추가
	case IBSEARCH_ASYNC04: //trade별 조회
	//break;
		formObj.f_cmd.value = SEARCH02;
		sheetObj.WaitImageVisible = false;
		//document.form.trade.value = "";
		var sXml = sheetObj.GetSearchXml("EES_CIM_1049GS.do", FormQueryString(formObj));
		var sLane = ComGetEtcData(sXml, "sLane");
		
		if (sLane == "noData") {
			comboObjects[0].focus();
			return false;
		}
		if (sLane != undefined) {
			var arrLane = sLane.split(",");
			MakeComboObject3(formObj.subtrade,arrLane);
			sheetObj.WaitImageVisible = true;
		break;
		}
	}
}

function MakeComboObject3(cmbObj, arrStr) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "|ALL", "");
	for ( var i = 0; i < arrStr.length; i++) {
		var arrVal = arrStr[i].split("|");
		cmbObj.InsertItem(i + 1, arrVal[0] + "|" + arrVal[1] + "|" + arrVal[2], arrVal[1]);
		//cmbObj.InsertItem(i, item, arrData[colListIdx[0]]);
	}
}

/**
 * Object maxlength 후 이동 스크립트
 * @return
 */
function form_keyup() {
	var obj = null;
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	if (keyValue != 13) {
		ComKeyEnter('lengthnextfocus');
	} else {
		obj_deactivate();
	}

}

function chkToDateWeekBlur() {
	var period = document.form.period.value;
	var toDate = document.form.todate.value;
	var frDate = document.form.fromdate.value;

	var toYearDate = toDate.substring(0, 4);
	var frYearDate = frDate.substring(0, 4);
	var toMonthDate = toDate.substring(5, 7);
	var frMonthDate = frDate.substring(5, 7);
	var frDayDate = "";
	var toDayDate = "";

	if (frDate.length > 7) {
		frDayDate = frDate.substring(8, 10);
		toDayDate = toDate.substring(8, 10);
	} else {
		frDayDate = "01";
		toDayDate = lastDay(toYearDate, toMonthDate);
	}

	var frDateFull = new Date(frYearDate, frMonthDate - 1, frDayDate);
	var toDateFull = new Date(toYearDate, toMonthDate - 1, toDayDate);
	var getDiffTime = toDateFull.getTime() - frDateFull.getTime();
	var retDate = Math.floor(getDiffTime / (1000 * 60 * 60 * 24));
	var retMonth = ((parseInt(toYearDate) - parseInt(frYearDate)) * 12 + parseInt(toMonthDate, 10) - parseInt(frMonthDate, 10));
	var retWeek = Math.floor((toDateFull - frDateFull) / (1000 * 60 * 60 * 24 * 7));
	var week = "";
	var fromTo = 52;

	if (period == "M") {
		if (retMonth >= 12) {
			if (event.srcElement.name == "todate") {
				return false;
			}
		}
	} else if (period == "W") {
		if (frYearDate == toYearDate) {
			week = eval(toMonthDate) - eval(frMonthDate) + 1;
		} else {
			betwMonth = fromTo - eval(frMonthDate) + eval(toMonthDate) + 1;
			if ((eval(toYearDate) - eval(frYearDate)) == 1) { //1년 차이일때
				week = betwMonth;
			} else {
				week = (eval(toYearDate) - eval(frYearDate) - 1) * fromTo + betwMonth;
			}
		}

		if (week > 12) {
			ComShowCodeMessage("CIM29025");
			document.getElementById("fromdate").value = "";
			document.getElementById("todate").value = "";
			ComSetFocus(document.getElementById("fromdate"));
			return;
		}
	}
	return true;
}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_deactivate() {
	var f = document.getElementById("fromdate");
	var t = document.getElementById("todate");
	sVal1 = f.value.replace(/\/|\-|\./g, "");
	sVal2 = t.value.replace(/\/|\-|\./g, "");

	switch (event.srcElement.name) {
	case "trade":
		comboObjects[0].Text = "";
		break;
	case "vvd":
		if (event.srcElement.value != "") {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
		}

		break;
	case "lane":
		if (event.srcElement.value != "") {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
		}

		break;
	case "fromdate":
		if (ComChkObjValid(event.srcElement, false)) {

			if (f.getAttribute("dataformat") == "ymd") {

				if (sVal1 != "" && sVal2 != "") {
					var flag = ComChkPeriod(sVal1, sVal2);
					if (flag < 1) {
						if (event.srcElement.name == "todate") {
							event.srcElement.value = "";
							ComShowCodeMessage("CIM29004");
							enterSwitch = false;
							t.focus();
							t.select();
							return false;
						} else {
							t.value = "";
							enterSwitch = false;
							t.focus();
							t.select();
							return false;
						}
					} else {
						if (chkToDateWeekBlur() == false) {
							event.srcElement.value = "";
							enterSwitch = false;
							t.focus();
							t.select();
							return false;
						}
					}
					enterSwitch = true;
				}

			}

		} else {
			if (f.getAttribute("dataformat") == "ymd") {

				if (sVal1.length > 0 && !ComIsDate(sVal1) && event.srcElement.name == 'fromdate') {

					enterSwitch = false;
					event.srcElement.value = "";
					ComShowCodeMessage("CIM21004", "YYYYMMDD");
					event.srcElement.focus();
					event.srcElement.select();
					return false;
				}
			}
		}

		break;
	case "todate":
		if (ComChkObjValid(event.srcElement, false)) {

			if (t.getAttribute("dataformat") == "ymd") {

				if (sVal1 != "" && sVal2 != "") {
					var flag = ComChkPeriod(sVal1, sVal2);
					if (flag < 1) {
						if (event.srcElement.name == "todate") {
							event.srcElement.value = "";
							ComShowCodeMessage("CIM29004");
							enterSwitch = false;
							t.focus();
							t.select();
							return false;
						} else {
							t.value = "";
							enterSwitch = false;
							t.focus();
							t.select();
							return false;
						}
					} else {
						if (chkToDateWeekBlur() == false) {
							event.srcElement.value = "";
							ComShowCodeMessage("CIM29026");
							enterSwitch = false;
							t.focus();
							t.select();
							return false;
						}
					}
					enterSwitch = true;
				}

			}

		} else {
			if (t.getAttribute("dataformat") == "ymd") {

				if (sVal2.length > 0 && !ComIsDate(sVal2) && event.srcElement.name == 'todate') {
					enterSwitch = false;

					document.getElementById("todate").value = "";
					ComShowCodeMessage("CIM21004", "YYYYMMDD");

					t.focus();
					t.select();
					return false;
				}
			}

		}

		break;

	}

	return true;
}

function lastDay(y, m) {
	var d, d2, s = "";
	d = new Date();
	d2 = new Date(y, m, "");
	s = d2.getDate();
	return (s);
}

function obj_activate() {
	ComClearSeparator(event.srcElement);
	ComSetFocus(event.srcElement);
}

function obj_keypress() {
	switch (event.srcElement.name) {
	case "lane":
		//ComKeyOnlyAlphabet('upper');// 알파벳 대문자만 입력허용
		ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
		break;
	case "vvd":
		ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
		break;
	case "fromdate":
		// 숫자만 + "-"만 입력허용
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "todate":
		// 숫자만 + "-"만 입력허용
		ComKeyOnlyNumber(event.srcElement);
		break;
	}

}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (sAction == IBSEARCH) {
			if (fromdate.value == "") {
				ComShowCodeMessage("CIM21001", "Period");
				ComSetFocus(fromdate);
				return false;
			} else if (todate.value == "") {
				ComShowCodeMessage("CIM21001", "Period");
				ComSetFocus(todate);
				return false;
			} else if (fromdate.value.length < 8) {
				return false;
			} else if (todate.value.length < 8) {

				return false;
			}
			if (!enterSwitch) {
				return false;
			}
		}
	}

	return true;
}

/**
 * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
 * @param {sheetObj} String : 해당 IBSheet셀 명
 * @param {Row} Long : 해당 셀의 Row Index
 * @param {Col} Long : 해당 셀의 Column Index
 * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 * @param {CellX} Long : 해당셀의 X좌표
 * @param {CellY} Long : 해당셀의 Y좌표
 * @param {CellW} Long : 해당셀의 가로 넓이값
 * @param {CellH} Long : 해당셀의 세로 높이값
 */
function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// 클릭한 row의 "lane"컬럼 값이 있으면
		if (ComGetLenByByte(Cellvalue(Row, "lane")) > 0) {
			// btn_Rdr 버튼 Enable
			ComBtnEnable("btn_Rdr");
		} else {
			// btn_Rdr 버튼 Disable
			ComBtnDisable("btn_Rdr");
		}
		// 클릭한 row의 "vvd"컬럼 값이 있으면
		if (ComGetLenByByte(Cellvalue(Row, "vvd")) > 0) {
			// btn_LRange 버튼 Enable
			ComBtnEnable("btn_LRange");
		} else {
			// btn_LRange 버튼 Disable
			ComBtnDisable("btn_LRange");
		}

	}
}

/**
 * IBSeet내의 데이터 영역의 셀을 더블클릭했을 때 발생하는 Event<br>
 * @param {sheetObj} String : 해당 IBSheet셀 명
 * @param {Row} Long : 해당 셀의 Row Index
 * @param {Col} Long : 해당 셀의 Column Index
 * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 * @param {CellX} Long : 해당셀의 X좌표
 * @param {CellY} Long : 해당셀의 Y좌표
 * @param {CellW} Long : 해당셀의 가로 넓이값
 * @param {CellH} Long : 해당셀의 세로 높이값
 */
function sheet1_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// 더블클릭한 row의 "vvd"컬럼 값이 있으면
		if (ComGetLenByByte(Cellvalue(Row, "vvd")) > 0) {
			if (SelectCol == 5) {
				var sUrl = "/hanjin/VOP_OPF_0045.do?" + "vsl_cd=" + Cellvalue(Row, "vvd").substring(0, 4) + "&voy_no=" + Cellvalue(Row, "vvd").substring(4, 8)
						+ "&dir_cd=" + Cellvalue(Row, "vvd").substring(8, 9) + "&region=" + Cellvalue(Row, "fromregion");
				//ComOpenPopup(sUrl, 1024, 650, "", "0,0", false);
				ComOpenPopupWithTarget(sUrl, 1024, 670, "", "0,0", true, "yes");

			}
		}

		// 더블클릭한 row의 "lane"컬럼 값이 있으면
		if (ComGetLenByByte(Cellvalue(Row, "lane")) > 0) {
			if (SelectCol == 4) {
				var sUrl = "/hanjin/VOP_VSK_0012.do";
				ComOpenPopupWithTarget(sUrl, 1020, 710, "", "0,0", true, "yes");
			}
		}
	}
}

/**
 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
 */
function getBackEndJobStatus() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];

	formObj.f_cmd.value = COMMAND02;
	var sXml = sheetObj.GetSearchXml("EES_CIM_1049GS.do", FormQueryString(formObj));
	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
	if (jobState == "3") {
		getBackEndJobLoadFile();
		clearInterval(timer1);
	} else if (jobState == "4") {
		ComShowCodeMessage("CIM29042");
		ComOpenWait(false);
		sheetObj.WaitImageVisible = true;
		clearInterval(timer1);
	} else if (jobState == "5") {
		ComShowCodeMessage("CIM29043");
		clearInterval(timer1);
	}
}

/**
 * BackEndJob의 결과가 완료되면 Excel파일로 내려받음
 */
function getBackEndJobLoadFile() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];

	formObj.f_cmd.value = COMMAND03;
	var sXml = sheetObj.GetSearchXml("EES_CIM_1049GS.do", FormQueryString(form));

	sheetObj.LoadSearchXml(sXml);
	sheetObj.WaitImageVisible = true;
	ComOpenWait(false);
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		Redraw = true;

		if (RowCount > 0) {
			for ( var i = 9; i < 29; i++) {
				SumValue(0, i) = CellValue(RowCount + 1, i);
			}
	
			for ( var i = 29; i < 32; i++) {
				SumText(0, i) = CellValue(RowCount + 1, i);
			}

			RowHidden(RowCount + 1) = true;
		}

		//	ColumnSort("colsorts");
		//	ColumnSort("2");
		//	ColumnSort("1");
		/*
		 if (document.form.vvd.value == "") {
		 SubSumBackColor = RgbColor(201, 213, 235);
		 ShowSubSum(
		 "colsorts",
		 "9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31",
		 true,
		 false,
		 false,
		 -1,
		 "0=;1=Total;2=%s;3=%s;29=IF(|25|== 0,0,(|9|+2*(|10|+|11|+|12|)+|21|)/(|25|+|23|))"
		 + ";30=IF(|bsaspace| == 0,0,  (|Teu_Total| + |deadslot| ) / ( |bsaspace| + |releasedteu| ))"
		 + ";31=IF(|bsaweight| = 0, 0, |weighttotal| / ( |bsaweight| + |releasedweight| ))");
		 }

		
		 for ( var x = 2; x < sheetObj.LastRow; x++) {
		 if (sheetObj.CellValue(x, 1) == "Total") {

		 var slffull = parseFloat(CellValue(x, "lffull") * 100)
		 var slfeq = parseFloat(CellValue(x, "lfeq") * 100)
		 var slfwgt = parseFloat(CellValue(x, "lfwgt") * 100)

		 CellValue(x, "lffull") = Math.round(slffull * 100) / 100 + "%";
		 CellValue(x, "lfeq") = Math.round(slfeq * 100) / 100 + "%";
		 CellValue(x, "lfwgt") = Math.round(slfwgt * 100) / 100 + "%";
		 }
		 }

		 // TOTAL fullLf 계산 로직
		 if (SumValue(0, "bsaspace") == 0) {

		 SumText(0, "lffull") = "0.0%";
		 } else {

		 SumText(0, "lffull") = Math
		 .round((((parseFloat(SumValue(0, "full20qty"))
		 + 2
		 * (parseFloat(SumValue(0, "full40qty"))
		 + parseFloat(SumValue(0, "fullhcqty")) + parseFloat(SumValue(
		 0, "full45qty"))) + parseFloat(SumValue(0,
		 "deadslot"))) / (parseFloat(SumValue(0, "bsaspace")) + parseFloat(SumValue(
		 0, "releasedteu")))) * 100) * 10)
		 / 10 + "%";
		 }

		 // TOTAL LF_EQ 계산 로직
		 if (SumValue(0, "bsaspace") == 0) {
		 SumText(0, "lfeq") = "0.0%";
		 } else {
		 SumText(0, "lfeq") = Math
		 .round((((parseFloat(SumValue(0, "Teu_Total")) + parseFloat(SumValue(
		 0, "deadslot"))) / (parseFloat(SumValue(0,
		 "bsaspace")) + parseFloat(SumValue(0, "releasedteu")))) * 100) * 10)
		 / 10 + "%";
		 }

		 // TOTAL LF_WGT
		 if (SumValue(0, "bsaweight") == 0) {
		 SumText(0, "lfwgt") = "0.0%";
		 } else {
		 SumText(0, "lfwgt") = Math
		 .round(((parseFloat(SumValue(0, "weighttotal")) / (parseFloat(SumValue(
		 0, "bsaweight")) + parseFloat(SumValue(0,
		 "releasedweight")))) * 100) * 10)
		 / 10 + "%";
		 }

		 MessageText("Sum") = "";
		 */
		SumText(0, 0) = "G.Total";

		SumText(0, 1) = "G.Total";

		CellAlign(LastRow, 0) = daCenter;
		SetMergeCell(LastRow, 0, 1, 9);
	}

	document.form.prt_period.value = document.form.period.value;
	document.form.prt_fromdate.value = document.form.fromdate.value;
	document.form.prt_todate.value = document.form.todate.value;
	document.form.prt_trade.value = document.form.trade.value;
	document.form.prt_lane.value = document.form.lane.value;
	document.form.prt_vvd.value = document.form.vvd.value;
	var check = "";
	for ( var i = 0; i < document.form.company.length; i++) {
		if (document.form.company[i].checked) {
			check = document.form.company[i].value;
		}
	}
	document.form.prt_company.value = check;

}

/* 개발자 작업  끝 */