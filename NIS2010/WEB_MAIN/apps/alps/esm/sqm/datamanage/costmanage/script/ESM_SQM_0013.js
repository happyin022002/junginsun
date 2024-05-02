/*=========================================================
*Copyright(c) 2133 CyberLogitec
*@FileName       : ESM_SQM_0013.js
*@FileTitle      : Basic CMCB_MAS UC PFMC Retrieve
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.03
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.03 SQM USER
* 1.0 Creation
* 2014.01.16 박은주 [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND13=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_SQM_0013 : ESM_SQM_0013 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0013() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
	var sheetObj = sheetObjects[0];
	var formObj  = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "f_bse_tp_cd":
				f_bse_tp_cd_OnChange();
				break;
			case "btn_Retrieve":
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;
			case "btn_Downexcel":
				doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
				break;
			case "btn_close":
				window.close();
				break;
		}
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg("COM12111", "", ""));
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object 를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * IBSheet Object 를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

function loadPage(){
	var formObj = document.form;
	loadingMode = true;

	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);

	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}

	ComSetObjValue(document.form.f_bse_tp_cd, p_bse_tp_cd);
	ComSetObjValue(document.form.f_bse_yr, p_bse_yr);
	ComSetObjValue(document.form.f_bse_qtr_cd, p_bse_qtr_cd);
	ComSetObjValue(document.form.f_ofc_vw_cd, p_ofc_vw_cd);
	ComSetObjValue(document.form.f_rhq_cd, p_rhq_cd);
	ComSetObjValue(document.form.f_rgn_ofc_cd, p_rgn_ofc_cd);
	ComSetObjValue(document.form.f_trd_cd, p_trd_cd);
	ComSetObjValue(document.form.f_rlane_cd, p_rlane_cd);
	ComSetObjValue(document.form.f_dir_cd, p_dir_cd);

	f_bse_tp_cd_OnChange();

	if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
		sheetObjects[0].ColHidden("bse_qtr_cd") = true;
	} else {
		sheetObjects[0].ColHidden("bse_qtr_cd") = false;
	}
	
	setTradeCombo();
	loadingMode = false;
}

function initSheet(sheetObj,sheetNo) {
	var cnt = 0;

	switch(sheetNo) {
		case 1:		//sheet1 init
			with (sheetObj) {
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;  //msNone; //msHeaderOnly //msPrevColumnMerge;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 14, 100);

				var HeadTitle1 =  "SEQ|Year|Quarter|Office View|Trade|R.Lane|Lane\nBound|RHQ|Office|MAS CM cost UC|MAS CM cost UC|MAS CM cost UC|SQM vs MAS|SQM vs MAS|SQM vs MAS";
				var HeadTitle2 =  "SEQ|Year|Quarter|Office View|Trade|R.Lane|Lane\nBound|RHQ|Office|CMCB(PA)|CMCB(RA)|PA-RA|CMCB(PA)|CMCB(RA)|PA-RA";

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1) + 1, 0, 0, true);

				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(false, false, false, true, false, false);

				//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				// 전체 높이 설정
				style.height = GetSheetHeight(15) ;

				//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtSeq,		30,	daCenter,	true,	"seq",				false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		50,	daCenter,	true,	"bse_yr",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,	daCenter,	true,	"bse_qtr_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCombo,	80,	daCenter,	true,	"ofc_vw_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		50,	daCenter,	true,	"trd_cd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,	daCenter,	true,	"rlane_cd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		50,	daCenter,	true,	"dir_cd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,	daCenter,	true,	"rhq_cd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,	daCenter,	true,	"rgn_ofc_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		90,	daRight,	true,	"mas_pa_cm_uc_amt",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		90,	daRight,	true,	"mas_ra_cm_uc_amt",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		90,	daRight,	true,	"mas_diff",			false,	"|mas_pa_cm_uc_amt|-|mas_ra_cm_uc_amt|",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		90,	daRight,	true,	"pa_cm_uc_amt",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		90,	daRight,	true,	"ra_cm_uc_amt",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		90,	daRight,	true,	"diff",				false,	"|pa_cm_uc_amt|-|ra_cm_uc_amt|",			dfInteger,	0,	false,	false);

			}
			break;
	}
}

/**
 * 멀티콤보 항목을 설정한다.
 */
function initCombo(comboObj, comboId) {
	switch(comboObj.id) {
		case "f_bse_yr":
		case "f_bse_qtr_cd":
			with (comboObj) {
				DropHeight = 300;
			}
			break;
		case "f_ofc_vw_cd":
			with (comboObj) {
				DropHeight = 300;
				Index      = 1;
			}
			break;
		default:
			with (comboObj) {
				DropHeight = 300;
				Index      = 0;
			}
			break;
	}
}

/**
 * Sheet 관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBCLEAR:          // 화면 접속 시
			sheetObj.WaitImageVisible = false;

			ComOpenWait(true);

			formObj.f_cmd.value = INIT;

			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0013GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");

			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 2)
				ComSetYearQta(arrXml[2]);
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], formObj.f_ofc_vw_cd, "code", "name");
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], formObj.f_rhq_cd, "code", "name");
			if (arrXml.length > 5)
				ComXml2ComboItem(arrXml[5], formObj.f_dir_cd, "code", "name");

			ComOpenWait(false);
			break;

		case IBSEARCH:          // 화면 조회
			if (!validateForm(sheetObj, formObj, sAction)) {
				return false;
			}

			ComOpenWait(true);

			formObj.f_cmd.value = SEARCH;

			searchParams = FormQueryString(formObj);

			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0013GS.do", searchParams);

			sheetObj.LoadSearchXml(rtnXml);

			if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
				sheetObj.ColHidden("bse_qtr_cd") = true;
			} else {
				sheetObj.ColHidden("bse_qtr_cd") = false;
			}

			ComOpenWait(false);

			break;

		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.MergeSheet = msNone;
			sheetObj.Down2Excel(-1, false, false, true);
			sheetObj.MergeSheet = msHeaderOnly;
			ComOpenWait(false);
			break;

    }
}

/**
 *  f_year, f_week, f_duration 바뀌었을때 period 의 week 기간변경
 */
function period_OnChange() {
	var formObj = document.form;
	var year    = ComGetObjValue(formObj.f_bse_yr);
	var week    = ComGetObjValue(formObj.f_week);
	var dur     = ComGetObjValue(formObj.f_duration);

	if ( week.length == 1 ) {
		week = "0" + week;
		formObj.f_week.value = week;
	}

	if ( year != "" && !ComIsNumber(year) ) {
		ComShowMessage(ComGetMsg('SQM00008', 'Year', 'YYYY'));
		formObj.f_year.value = "";
		formObj.f_year.focus();
		return false;
	}

	if ( week != "" && !ComIsNumber(week) ) {
		ComShowMessage(ComGetMsg('SQM00008', 'week', 'WW'));
		formObj.f_week.value = "";
		formObj.f_week.focus();
		return false;
	}

	if ( dur != "" && !ComIsNumber(dur) ) {
		ComShowMessage(ComGetMsg('SQM00007', 'Duration'));
		formObj.f_duration.value = "";
		formObj.f_duration.focus();
		return false;
	}

	if ( dur != "" && dur * 1 > 13 ) {
		ComShowMessage(ComGetMsg('SQM00032', '13'));
		formObj.f_duration.value = "";
		formObj.f_duration.focus();
		return false;
	}

	var param = year + week + "|" + dur;

	createCodeSheetObject();

	if ( year != "" && week != "" && dur != "" ) {
		var sXml   = codeSheet.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=cPeriod&code_param=" + param);
		var arrXml = sXml.split("|$$|");
		var arrData = ComXml2ComboString(arrXml, "code", "name");

		var arrWk = arrData[0].split("~");
		formObj.f_fm_wk.value = arrWk[0];
		formObj.f_to_wk.value = arrWk[1];

		document.getElementById("div_period2").innerHTML = "(" + arrData[1] + ")";
	} else {
		document.getElementById("div_period2").innerHTML = "&nbsp;";
	}
}

function f_bse_yr_OnBlur(obj, value, text) {
	period_OnChange();
}

/**
 *  선택된 Trade 에 해당하는 R/Lane 정보 가져와서 ComboBox 셋팅
 */
function f_trd_cd_OnChange(obj, value, text) {
	setLaneCombo();
}

/**
 *  선택된 RHQ 에 해당하는 Office 정보 가져와서 ComboBox 셋팅
 */
function f_rhq_cd_OnChange(obj, value, text) {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];

	if ( value != "All" ) {
		var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=office&code_param=" + (value=="All"?"":value) + "&all_flag=All");

		ComXml2ComboItem(sXml, formObj.f_rgn_ofc_cd, "code", "name");
		formObj.f_rgn_ofc_cd.Index = 0;
	} else {
		formObj.f_rgn_ofc_cd.RemoveAll();
		formObj.f_rgn_ofc_cd.InsertItem(0, "All", "All");
		formObj.f_rgn_ofc_cd.Index = 0;
	}
}


/**
 * f_bse_yr, f_bse_qtr_cd  바뀌었을때 f_trd_cd 콤보조회
 */
function setTradeCombo() {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	var param    = "";

    var bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
    var bse_yr     = ComGetObjValue(formObj.f_bse_yr);
    var trd_cd     = ComGetObjValue(formObj.f_trd_cd);

 	param = "f_cmd=" + SEARCH01
     + "&code_name=trade"
     + "&code_param= " + bse_yr + "" + bse_qtr_cd
     + "&all_flag=All";	// Trade

	var sXml = sheetObj.GetSearchXml("CommonGS.do",param);
	ComXml2ComboItem(sXml, formObj.f_trd_cd, "code", "name");
	// 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
	var index = SearchIndex(formObj.f_trd_cd, trd_cd);
	formObj.f_trd_cd.Index = index;
}


/**
 * f_bse_yr, f_bse_qtr_cd, f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
 */
function setLaneCombo() {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	var param    = "";
	var trd_cd     = ComGetObjValue(formObj.f_trd_cd);
	var rlane_cd     = ComGetObjValue(formObj.f_rlane_cd);

	if (trd_cd != "All" && trd_cd != "" ) {
	 	param = "f_cmd=" + SEARCH01
	     + "&code_name=rLane"
	     + "&code_param= " + trd_cd
	     + "&all_flag=All";	// 		
	 	
	 	var sXml = sheetObj.GetSearchXml("CommonGS.do",param);
		ComXml2ComboItem(sXml, formObj.f_rlane_cd, "code", "name");
		
		// 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
		var index = SearchIndex(formObj.f_rlane_cd, rlane_cd);
		formObj.f_rlane_cd.Index = index;
	} else {
		formObj.f_rlane_cd.RemoveAll();
		formObj.f_rlane_cd.InsertItem(0, "All", "All");
		formObj.f_rlane_cd.Index = 0;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction){

	switch(sAction) {

		case IBSEARCH:
			var rhq_cd     = ComGetObjValue(formObj.f_rhq_cd);
			var rgn_ofc_cd = ComGetObjValue(formObj.f_rgn_ofc_cd);
			var week       = ComGetObjValue(formObj.f_week);
			var dur        = ComGetObjValue(formObj.f_duration);

			if ( rhq_cd == "All" ) {
				ComShowCodeMessage("SQM00013", "RHQ");
				formObj.f_rhq_cd.focus();
				return false;
			}

			if ( rgn_ofc_cd == "All" ) {
				ComShowCodeMessage("SQM00013", "Office");
				formObj.f_rgn_ofc_cd.focus();
				return false;
			}

			if ( week == "" ) {
				ComShowCodeMessage("SQM00013", "End Week");
				formObj.f_week.focus();
				return false;
			}

			if ( dur == "" ) {
				ComShowCodeMessage("SQM00013", "Duration");
				formObj.f_duration.focus();
				return false;
			}
    		break;
	}
	return true;
}


/**
 * f_bse_tp_cd 바뀌었을때 qtr_cd, week 변경
 */
function f_bse_tp_cd_OnChange() {
	var formObj    = document.form;
	var bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
	var div_qtr    = document.getElementById("div_qtr");
	var div_period = document.getElementById("div_period");

	if (bse_tp_cd == "Y") {
		div_qtr.style.display = "none";
		div_period.style.display = "none";
		formObj.f_bse_qtr_cd.style.display = "none";
	} else {
		div_qtr.style.display = "inline";
		div_period.style.display = "inline";
		formObj.f_bse_qtr_cd.style.display = "inline";
	}

	period_change();
	setTradeCombo();
}

/**
 * f_bse_yr가 바뀌었을때 period 의 year 변경
 */
function f_bse_yr_OnChange(obj, value, text) {
	period_change();
	setTradeCombo();
}

/**
 * f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
 */
function f_bse_qtr_cd_OnChange(obj, value, text) {
	period_change();
	setTradeCombo();
}
/* 개발자 작업  끝 */