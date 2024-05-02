﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : ESM_SQM_0219.js
*@FileTitle      : QTA Adjustment by VVD for IAS Sector
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.03.25
*@LastModifier   : 
*@LastVersion    : 1.0
* 2014.01.23 SQM USER
* 1.0 Creation
* 2014.03.25 QTA Adjustment by VVD 화면 검색조건 로직 수정
* 2015.01.22 Rev Month 기준으로 관련 화면의 period를 변경
* 2015.02.17 VVD Adjust 관련 두 화면 내 Trade Direction 추가 
* 2015.02.27 Adjust 화면 내 조회 로직 변경 (Week 기준 => Revenue Month 기준)
* 2015.06.15 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
* 2015.08.10 Split24-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
* 2015.08.26 QTA ADJUSTMENT BY VVD 및 QTA ADJUSTMENT BY VVD FOR IAS SECTOR 화면 개선
* 2015.09.09 QTA Adjustment by VVD, QTA Adjustment by VVD for IAS Sector 두 화면내 칼럼 수정
* 2015.10.29 QTA Adjustment by VVD for IAS Sector 화면 보완 (Adjusting VVD Select, BSA Flag 칼럼 추가)
* 2015.12.09 VVD Adjustment, VVD Adjustment for IAS Sector에서 Currently Updated에서 BSA 매뉴얼로 수정가능하도록 로직 수정.
* 2015.12.09 VVD Adjustment, VVD Adjustment for IAS Sector에서 Currently Updated에서 BSA 매뉴얼로 수정가능하도록 로직 수정.
* 2016.03.15 Currently Updated 화면과 Need to be Updated 화면에 P/F Group을 추가해서 Currently Updated로 update 시 QTA Edit에 반영될 수 있도록 로직 수정
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_SQM_0219 : ESM_SQM_0219 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0219() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.doActionIBSheet 		= doActionIBSheet;
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
			case "btn_Retrieve":
				sheetObj.ColHidden("trd_cd") = true;
				sheetObj.ColHidden("revenue_quarter") = true;
				sheetObj.ColHidden("sub_trd_cd") = true;
				sheetObj.ColHidden("dir_cd") = true;
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;
			case "btn_DownExcel":
				sheetObj.ColHidden("trd_cd") = false;
				sheetObj.ColHidden("revenue_quarter") = false;
				sheetObj.ColHidden("sub_trd_cd") = false;
				sheetObj.ColHidden("dir_cd") = false;
				doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
				sheetObj.ColHidden("trd_cd") = true;
				sheetObj.ColHidden("revenue_quarter") = true;
				sheetObj.ColHidden("sub_trd_cd") = true;
				sheetObj.ColHidden("dir_cd") = true;
				break;
			case "btn_Creation":
				doActionIBSheet(sheetObj, formObj, IBCREATE);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObj, formObj, IBSAVE);
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
	
	initControl();

	doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);

	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}

	if ( login_ofc_cd != "SELCSG" ) ComBtnDisable("btn_Creation");
	if ( login_ofc_cd != "SELCSG" ) ComBtnDisable("btn_Save");

	loadingMode = false;
}

function initControl() {
	var formObj = document.form;

	axon_event.addListenerForm("click",		"obj_click",	formObj);
}

function initSheet(sheetObj,sheetNo) {
	var cnt = 0;

	switch(sheetNo) {
		case 1:		//sheet1 init
			with (sheetObj) {
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge + msHeaderOnly;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 9, 100);

				var HeadTitle  = "Trade|Sub\nTrade|IAS\nRegion|R.Lane|Lane\nBound|Trade\nDirection|Ver|IOC|Flg|STS|Currently Updated|Currently Updated|Currently Updated|Currently Updated|Currently Updated|Currently Updated|Currently Updated|Currently Updated|Currently Updated|Currently Updated|Currently Updated|Currently Updated" +
						"|Need to be Updated|Need to be Updated|Need to be Updated|Need to be Updated|Need to be Updated|Need to be Updated|Need to be Updated|Need to be Updated|Need to be Updated|Update Option|Update Option|Update Option|Update Option";
				var HeadTitle2 = "Trade|Sub\nTrade|IAS\nRegion|R.Lane|Lane\nBound|Trade\nDirection|Ver|IOC|Flg|STS|Revenue\nQuarter|Month|Base\nYYYY-MM|sls_yr" +
						"|Revenue\nYYYY-MM|Week|VVD|P/F SKD\nGroup|P/F SKD\nVer.|Supply|Load|G.REV|Month|Base\nYYYY-MM|mas_sls_yr|Revuene\nYYYY-MM|Week|VVD|P/F SKD\nGroup|P/F SKD\nVer.|Supply|COPY VVD|QTA=0|Adjusting\nVVD Select|BSA Flag";
//				var HeadTitle2 = "Trade|Lane\nBound|Sub\nTrade|Lane|Ver|IOC|Flg|STS|Month|Week|VVD|Supply|Load|G.REV|Month|Week|VVD|Supply|Load|G.REV|Portion\nConnected|COPY VVD|Copy Current\nBSA Portion|Adjusting\nVVD Select";

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle) + 1,6, 0, true);

				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, false, true, false, false);

				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle,	true);
				InitHeadRow(1, HeadTitle2,	false);

				// 전체 높이 설정
				style.height = GetSheetHeight(21);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtData,			40,		daCenter,	true,	"trd_cd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,		daCenter,	true,	"sub_trd_cd",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			65,		daCenter,	true,	"ias_rgn_cd",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			55,		daCenter,	true,	"rlane_cd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,		daCenter,	true,	"dir_cd",			false,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0, cnt++,  dtData,         60,		daCenter,   true,   "hul_bnd_cd",   	false,  "", dfNone,     	0,  false,  false);
				InitDataProperty(0,	cnt++,	dtHidden,		80,		daCenter,	true,	"qta_rlse_ver_no",	false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		30,		daCenter,	true,	"ioc_cd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		30,		daCenter,	true,	"flag",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,		daCenter,	true,	"ibflag",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			70,		daCenter,	false,	"revenue_quarter",	false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		70,		daCenter,	false,	"bse_mon",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		70,		daCenter,	false,	"bse_yrmon",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		50,		daCenter,	false,	"sls_yr",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			70,		daCenter,	false,	"sls_yrmon",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,		daCenter,	false,	"bse_wk",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			75,		daCenter,	false,	"vvd",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	false,	"pf_grp_cd",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		60,		daCenter,	false,	"pf_svc_tp_cd",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,		daCenter,	false,	"fnl_bsa_capa",		false,	"",	dfNullInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,		daRight,	false,	"lod_qty",			false,	"",	dfNullInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,		daRight,	false,	"grs_rev",			false,	"",	dfNullInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		70,		daCenter,	false,	"mas_bse_mon",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		70,		daCenter,	false,	"mas_bse_yrmon",	false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		50,		daCenter,	false,	"mas_cost_yr",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			70,		daCenter,	false,	"mas_cost_yrmon",	false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,		daCenter,	false,	"mas_bse_wk",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			75,		daCenter,	false,	"mas_vvd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	false,	"mas_pf_grp_cd",	false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		60,		daCenter,	false,	"mas_pf_svc_tp_cd",	false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	false,	"mas_fnl_bsa_capa",	false,	"",	dfNullInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCombo,		70,		daCenter,	false,	"copy_vvd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCheckBox,		70,		daCenter,	false,	"f_click",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCheckBox,		80,		daCenter,	false,	"adj_vvd",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++,	dtData,			65,		daCenter,	false,	"bsa_zr_flg",		false,	"",	dfNone,			0,	false,	false);
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

			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0219GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");

			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 2)
				ComSetYearQta(arrXml[2]);
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], formObj.f_sub_trd_cd, "code", "name");
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], formObj.f_ias_rgn_cd, "code", "name");
			if (arrXml.length > 5)
				ComXml2ComboItem(arrXml[5], formObj.f_dir_cd, "code", "name");
			if (arrXml.length > 6)
				ComXml2ComboItem(arrXml[6], formObj.f_hul_bnd_cd, "code", "name");
				
			formObj.f_crnt_bse_yr.value = formObj.f_bse_yr.Code;
			formObj.f_crnt_qta_cd.value = formObj.f_bse_qtr_cd.Code;
			ComOpenWait(false);
			break;

		case IBSEARCH:          // 화면 조회 시
			ComOpenWait(true);

			formObj.f_cmd.value = SEARCH01;

			formObj.f_fm_wk.value = qtaWeekArr[ComGetObjValue(formObj.f_bse_qtr_cd)][0].substring(3,5);
			formObj.f_to_wk.value = qtaWeekArr[ComGetObjValue(formObj.f_bse_qtr_cd)][1].substring(3,5);

			searchParams = FormQueryString(formObj);

			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0219GS2.do", searchParams);

			sheetObj.LoadSearchXml(rtnXml);
			
			var quarter = document.getElementById("quarter");
			quarter.innerHTML = sheetObj.CellValue(2,10);

			ComOpenWait(false);
			break;

		case IBCREATE:          // 생성
			
			if (!validateForm(sheetObj, formObj, sAction)) return;
			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006"); //"There is no data to save.";
				return false;
			}

			if (ComShowConfirm (ComGetMsg("SQM00009")) != 1) { //"Do you want to create data?"
				return false;
		    }

			var saveStr = sheetObj.GetSaveString(false, true, "ibflag");

			if ( saveStr == "" ) {
				return;
			}

			ComOpenWait(true);

			ComSetSearchParams("f_cmd", MULTI01);
			
			var sXml = sheetObj.GetSaveXml("ESM_SQM_0219GS.do", searchParams + "&" + saveStr);

			ComOpenWait(false);

			var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);

			if ( State == "S" ) {
				ComShowCodeMessage("SQM00010", "Data");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			} else if ( State != "S" ){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}

			break;
			
		case IBSAVE:          // save supply
			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006"); //"There is no data to save.";
				return false;
			}

			var saveStr = sheetObj.GetSaveString(false, true, "ibflag");

			if ( saveStr == "" ) {
				return;
			}

			ComOpenWait(true);

			ComSetSearchParams("f_cmd", MULTI02);
			
			var sXml = sheetObj.GetSaveXml("ESM_SQM_0219GS.do", searchParams + "&" + saveStr);

			ComOpenWait(false);

			var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);

			if ( State == "S" ) {
				ComShowCodeMessage("SQM00001", "Data");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			} else if ( State != "S" ){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}

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
 * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 *
 * @param sheetObj
 * @param ErrMsg
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg){

}

/**
 * f_bse_yr가 바뀌었을때 Lane 재조회
 */
function f_bse_yr_OnChange(obj, value, text) {
	period_change_based_on_rev_month();
	setLaneCombo();
}

/**
 * f_bse_qtr_cd 바뀌었을때 Lane 재조회
 */
function f_bse_qtr_cd_OnChange(obj, value, text) {
	period_change_based_on_rev_month();
	setLaneCombo();
}


/**
* onChange event
* f_sub_trd_cd 바뀌었을때  f_lane_cd 콤보조회
*/	
function f_sub_trd_cd_OnChange(obj, value, text) {
	setLaneCombo();
 }

/**
* onChange event
* f_ias_rgn_cd 바뀌었을때  f_lane_cd 콤보조회
*/	
function f_ias_rgn_cd_OnChange(obj, value, text) {
	setLaneCombo();
}

/**
 *  f_sub_trd_cd, f_ias_rgn_cd 변경시 f_rlane_cd를 변경한다.
 */
function setLaneCombo(){
 	var formObj = document.form;
 	var sub_trd_cd = ComGetObjValue(formObj.f_sub_trd_cd);
 	var ias_rgn_cd = ComGetObjValue(formObj.f_ias_rgn_cd);
 	
 	if ( (sub_trd_cd != ""  && sub_trd_cd != "All" ) || (ias_rgn_cd != "" && ias_rgn_cd != "All")  ) {
        var param = "f_cmd=" + SEARCH02
        + "&code_name=rLaneControlSector"
        + "&code_param=null"
        + "&all_flag="
        + "&" + FormQueryString(formObj);
	
	 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, formObj.f_rlane_cd, "code", "name");
	 	formObj.f_rlane_cd.MultiSelect = true;
 	} else {
		formObj.f_rlane_cd.RemoveAll();
 	}
 	
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction){
	var formObj    = document.form;

	switch(sAction) {
		
		case IBCREATE:  // 화면 저장시에
			var iRows   = sheetObj.FindStatusRow("I");
			var iRowArr = iRows.split(";");

			for ( var i=0; i < iRowArr.length-1; i++ ) {
				if (sheetObj.CellValue(iRowArr[i], "copy_vvd") == ""){
					ComShowCodeMessage('SQM00024','Copy VVD');//Please Input VVD.
					return false;
				}
			}
    		break;
	}
	return true;
}

function obj_click() {
	
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	with(formObj) {
		switch(srcName) {

			case "f_trd_dir":
				if ( f_trd_dir.checked ) {
					div_dir.innerHTML         = "Trade Dir.";
					div_trd_dir.style.display = "inline";
		      		div_dir_cd.style.display  = "none";
				} else {
					div_dir.innerHTML         = "Lane Bound";
					div_trd_dir.style.display = "none";
					div_dir_cd.style.display  = "inline";
				}
				break;
		}
	}
}

/**
 * Sheet1 값 변경시
 *
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet1_OnChange(sheetObj, row, col, value){
	var formObj = document.form;
	var sName   = sheetObj.ColSaveName(col);

	switch(sName){
		case "adj_vvd": //Adjustment VVD Select 가 변경되면 COPY VVD 컬럼을 활성화 시킴
			if ( value == 1 ) { 
				if (sheetObj.CellValue(row, "mas_vvd") == ""){
					sheetObj.CellEditable(row, "copy_vvd") = true;
				}else{
					ComShowCodeMessage("SQM00060");
					sheetObj.CellValue(row, "adj_vvd") = false;
				}
			} else {
				sheetObj.CellEditable(row, "copy_vvd") = false;
				sheetObj.CellValue(row, "copy_vvd") = "";
			}
			break;
		case "copy_vvd": 
			if ( sheetObj.CellValue(row, "copy_vvd") == sheetObj.CellValue(row, "vvd") ) { 
				ComShowCodeMessage("SQM00061");
				sheetObj.CellValue(row, "copy_vvd") = "";
			} 
			break;
	}
}

 /**
 * Sheet1 클릭 시
 *
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet1_OnClick(sheetObj, row, col){
	switch(sheetObj.ColSaveName(col)){
		case "fnl_bsa_capa":
			sheetObj.CellEditable(row, "fnl_bsa_capa") = true;
			break;
	}
}
/* 개발자 작업  끝 */