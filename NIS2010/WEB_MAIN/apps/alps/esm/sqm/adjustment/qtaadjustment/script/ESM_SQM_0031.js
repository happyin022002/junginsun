﻿/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0031.js
*@FileTitle      : QTA Adjustment by VVD
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.03.25
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.05.30 SQM USER
* 1.0 Creation
* 2013.11.11 SQM 몇몇 화면 내 틀 고정 기능 추가
* 2013.12.17 2013년도 SAQ 데이터 조회시 생성 기준이 다른 부분을 해결하기 위해 f_crnt_qta_cd 추가
* 2013.12.27 SQM 데이터 조회시 현재날짜와 조건날짜 비교하여 다른 테이블에서 조회되도록 수정
* 2014.01.06 QTA Adjustment by VVD 화면내 신규 칼럼 추가 및 Creation 로직 수정
*                          - Copy Current BSA Portion 제거
*                          - Adjusting VVD Select 추가 : 변경사항이 없을 경우 혹은 COA의 BSA가 0일 경우만 선택가능(Load, REV를 입력할수 있도록 함)
*                          - BSA가 변경 될 경우 Need to be Updated 의 Load, REV의 값을 Currently Updated 의 L/F를 구해서 적용한다.
* 2014.01.16 IAS Sector Sales 판매시스템 개발
* 2014.03.25 QTA Adjustment by VVD 화면 검색조건 로직 수정
* 2015.01.22 Rev Month 기준으로 관련 화면의 period를 변경
* 2015.02.17 VVD Adjust 관련 두 화면 내 Trade Direction 추가 
* 2015.02.27 Adjust 화면 내 조회 로직 변경 (Week 기준 => Revenue Month 기준)
* 2015.05.15 Adjustment 화면 3개 Creation전 RHQ별 Portion 존재하고, 
									Office portion이 없는 List 조회.
* 2015.06.15 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
* 2015.07.22 [CSR 전환건] QTA Adjustment by VVD 화면 내 신규 기능 추가
* 2015.08.13 QTA Adjustment by VVD 화면내 BSA Flag 칼럼 추가
* 2015.08.10 Split24-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
* 2015.08.26 [CSR 전환건] QTA ADJUSTMENT BY VVD 및 QTA ADJUSTMENT BY VVD FOR IAS SECTOR 화면 개선
* 2015.09.09 QTA Adjustment by VVD, QTA Adjustment by VVD for IAS Sector 두 화면내 칼럼 수정
* 2015.12.09 VVD Adjustment, VVD Adjustment for IAS Sector에서 Currently Updated에서 BSA 매뉴얼로 수정가능하도록 로직 수정.
* 2016.01.14 VVD Adjustment의 Update Option 추가 CSR
* 2016.03.22 Adjusted 클릭시 Contract 컬럼을 Contract O/B와 Contract N/OB로 나눠서 보여주도록 로직 수정
* 2016.04.22 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
* 2016.06.17 SELCMI로 접속시 IAS Trade에 대해서 Creation 가능하도록 로직 수정 
* 2016.07.14 QTA Adjustment by VVD 팝업 메시지 호출 제거
* 2016.08.17 VVD Load, Rev 변경시, 모든 VVD 체크 가능하도록 설정
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_SQM_0031 : ESM_SQM_0031 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0031() {
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
//				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				
				if(ComGetObjValue(formObj.f_trd_cd) == "IAS"){
            		if(ComGetObjValue(formObj.f_bse_yr) < 2016){
            			ComShowCodeMessage('SQM00067');
            		}else if(ComGetObjValue(formObj.f_bse_yr) == 2016){
            			if(ComGetObjValue(formObj.f_bse_qtr_cd) == "1Q"){ 
            				ComShowCodeMessage('SQM00067');
            			}else if(ComGetObjValue(formObj.f_bse_qtr_cd) == "2Q"){
            				ComShowCodeMessage('SQM00067');
            			}else{
            				doActionIBSheet(sheetObj, formObj, IBSEARCH);
            			}
            		}else{
        				doActionIBSheet(sheetObj, formObj, IBSEARCH);
            		}
            	}else{
    				doActionIBSheet(sheetObj, formObj, IBSEARCH);
            	}
				
				break;
			case "btn_DownExcel":
				sheetObj.ColHidden("trd_cd") = false;
				sheetObj.ColHidden("revenue_quarter") = false;
				doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
				sheetObj.ColHidden("trd_cd") = true;
				sheetObj.ColHidden("revenue_quarter") = true;
				break;
			case "btn_Creation":
				doActionIBSheet(sheetObj, formObj, IBCREATE);
				break;
			case "btn_Adjusted":
				sheetObj.ColHidden("trd_cd") = true;  
				sheetObj.ColHidden("revenue_quarter") = true;
				doActionIBSheet(sheetObj, formObj, "ADJUSTED");
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

	doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);

	initControl();

	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}

	if ( login_ofc_cd != "SELCSG" && login_ofc_cd != "SELCMI" ) ComBtnDisable("btn_Creation");
	if ( login_ofc_cd != "SELCSG" && login_ofc_cd != "SELCMI" ) ComBtnDisable("btn_Save");
	setTradeCombo();
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

				var HeadTitle  = "Trade|Lane\nBound|Trade\nDirection|Sub\nTrade|Lane|Ver|IOC|Flg|STS|Currently Updated|Currently Updated|Currently Updated|Currently Updated|Currently Updated|Currently Updated|Currently Updated|Currently Updated|Currently Updated|Currently Updated|Need to be Updated|Need to be Updated|Need to be Updated|Need to be Updated|Need to be Updated|Need to be Updated|Need to be Updated|Need to be Updated|Need to be Updated|Update Option|Update Option|Update Option|Update Option|H/O Adjust|H/O Adjust|RHQ Adjust|RHQ Adjust|RHQ Adjust";
				var HeadTitle2 = "Trade|Lane\nBound|Trade\nDirection|Sub\nTrade|Lane|Ver|IOC|Flg|STS|Revenue\nQuarter|Month|Base\nYYYY-MM|sls_yr|Revenue\nYYYY-MM|Week|VVD|Supply|Load|G.REV|Month|Base\nYYYY-MM|mas_sls_yr|Revenue\nYYYY-MM|Week|VVD|Supply|Load|G.REV|Portion\nConnected|COPY VVD|Adjusting\nVVD Select|BSA Flag|Loading|Contract|Loading|OB\nContract|N.OB\nContract";
//				var HeadTitle2 = "Trade|Lane\nBound|Sub\nTrade|Lane|Ver|IOC|Flg|STS|Month|Week|VVD|Supply|Load|G.REV|Month|Week|VVD|Supply|Load|G.REV|Portion\nConnected|COPY VVD|Copy Current\nBSA Portion|Adjusting\nVVD Select";

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle) + 1,5, 0, true);

				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, true, true, false, false);

				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle,	true);
				InitHeadRow(1, HeadTitle2,	false);

				// 전체 높이 설정
				style.height = GetSheetHeight(21);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtData,			50,		daCenter,	true,	"trd_cd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			45,		daCenter,	true,	"dir_cd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0, cnt++,  dtData,         60,		daCenter,   true,   "hul_bnd_cd",   	false,  "", dfNone,     	0,  false,  false);
				InitDataProperty(0,	cnt++,	dtData,			50,		daCenter,	true,	"sub_trd_cd",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	true,	"rlane_cd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		80,		daCenter,	true,	"qta_rlse_ver_no",	false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		30,		daCenter,	true,	"ioc_cd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		30,		daCenter,	true,	"flag",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,		daCenter,	true,	"ibflag",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			70,		daCenter,	false,	"revenue_quarter",	false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		70,		daCenter,	false,	"bse_mon",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		70,		daCenter,	false,	"bse_yrmon",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		50,		daCenter,	false,	"sls_yr",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			70,		daCenter,	false,	"sls_yrmon",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			40,		daCenter,	false,	"bse_wk",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			75,		daCenter,	false,	"vvd",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,		daCenter,	false,	"fnl_bsa_capa",		false,	"",	dfNullInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,		daRight,	false,	"lod_qty",			false,	"",	dfNullInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,		daRight,	false,	"grs_rev",			false,	"",	dfNullInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		70,		daCenter,	false,	"mas_bse_mon",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		70,		daCenter,	false,	"mas_bse_yrmon",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		50,		daCenter,	false,	"mas_cost_yr",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			70,		daCenter,	false,	"mas_cost_yrmon",	false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			40,		daCenter,	false,	"mas_bse_wk",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			75,		daCenter,	false,	"mas_vvd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	false,	"mas_fnl_bsa_capa",	false,	"",	dfNullInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,		daRight,	false,	"mas_lod_qty",		true,	"",	dfNullInteger,	0,	false,	false,	5);
				InitDataProperty(0,	cnt++,	dtData,			60,		daRight,	false,	"mas_grs_rev",		true,	"",	dfNullInteger,	0,	false,	false,	12);
				InitDataProperty(0,	cnt++,	dtData,			80,		daCenter,	false,	"potn_lnk",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCombo,		80,		daCenter,	false,	"copy_vvd",			false,	"",	dfNone,			0,	false,	false);
//				InitDataProperty(0,	cnt++,	dtCheckBox,		80,		daCenter,	false,	"spl_potn",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCheckBox,		85,		daCenter,	false,	"adj_chk",			false,	"",	dfNone,			0,	false,	false, -1, false, true, "", true);
				InitDataProperty(0,	cnt++,	dtData,			65,		daCenter,	false,	"bsa_zr_flg",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			65,		daCenter,	false,	"comparison_with_ho_loading",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			65,		daCenter,	false,	"comparison_with_ho_contract",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			65,		daCenter,	false,	"comparison_with_rhq_loading",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			65,		daCenter,	false,	"comparison_with_rhq_contract_outbound",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			65,		daCenter,	false,	"comparison_with_rhq_contract_nonoutbound",			false,	"",	dfNone,			0,	false,	false);
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

			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0031GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");

			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 2)
				ComSetYearQta(arrXml[2]);
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], formObj.f_dir_cd, "code", "name");
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], formObj.f_portion_link, "code", "name");
			if (arrXml.length > 5)
				ComXml2ComboItem(arrXml[5], formObj.f_hul_bnd_cd, "code", "name");
			formObj.f_crnt_bse_yr.value = formObj.f_bse_yr.Code;
			formObj.f_crnt_qta_cd.value = formObj.f_bse_qtr_cd.Code;
			ComOpenWait(false);
			break;

		case IBSEARCH:          // 화면 조회 시
			ComOpenWait(true);

			formObj.f_cmd.value = SEARCH;

			formObj.f_fm_wk.value = qtaWeekArr[ComGetObjValue(formObj.f_bse_qtr_cd)][0].substring(3,5);
			formObj.f_to_wk.value = qtaWeekArr[ComGetObjValue(formObj.f_bse_qtr_cd)][1].substring(3,5);

			searchParams = FormQueryString(formObj);

			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0031GS2.do", searchParams);
			
			sheetObj.ColHidden("comparison_with_ho_loading") = true;
			sheetObj.ColHidden("comparison_with_ho_contract") = true;
			sheetObj.ColHidden("comparison_with_rhq_loading") = true;
			sheetObj.ColHidden("comparison_with_rhq_contract_outbound") = true;
			sheetObj.ColHidden("comparison_with_rhq_contract_nonoutbound") = true;

			sheetObj.LoadSearchXml(rtnXml);
			
			var trade_code = document.getElementById("trade_code");
			trade_code.innerHTML = sheetObj.CellValue(2,0);
			
			var quarter = document.getElementById("quarter");
			quarter.innerHTML = sheetObj.CellValue(2,9);
			
			ComOpenWait(false);
			break;
			
		case "ADJUSTED":           
			ComOpenWait(true);

			formObj.f_cmd.value = SEARCH;

			formObj.f_fm_wk.value = qtaWeekArr[ComGetObjValue(formObj.f_bse_qtr_cd)][0].substring(3,5);
			formObj.f_to_wk.value = qtaWeekArr[ComGetObjValue(formObj.f_bse_qtr_cd)][1].substring(3,5);

			searchParams = FormQueryString(formObj);

			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0031GS2.do", searchParams);
			
			sheetObj.ColHidden("comparison_with_ho_loading") = false;
			sheetObj.ColHidden("comparison_with_ho_contract") = false;
			sheetObj.ColHidden("comparison_with_rhq_loading") = false;
			sheetObj.ColHidden("comparison_with_rhq_contract_outbound") = false;
			sheetObj.ColHidden("comparison_with_rhq_contract_nonoutbound") = false;

			sheetObj.LoadSearchXml(rtnXml);
			
			var trade_code = document.getElementById("trade_code");
			trade_code.innerHTML = sheetObj.CellValue(2,0);
			
			var quarter = document.getElementById("quarter");
			quarter.innerHTML = sheetObj.CellValue(2,9);
			
			comparisonWithHo();
			comparisonWithRhq();
			
			ComOpenWait(false);
			break;

		case IBCREATE:          // 생성
			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006"); //"There is no data to save.";
				return false;
			}			
			//RHQ Portion은 존재하나 해당 RHQ 산하 Office에 Portion이 0일 경우 alert.
			if (!validateForm(sheetObj, formObj, sAction)) return;
			
			if (ComShowConfirm (ComGetMsg("SQM00009")) != 1) { //"Do you want to create data?"
				return false;
		    }

			var saveStr = sheetObj.GetSaveString(false, true, "ibflag");
			
			if ( saveStr == "" ) {
				return;
			}

			ComOpenWait(true);

			ComSetSearchParams("f_cmd", MULTI);

			var sXml = sheetObj.GetSaveXml("ESM_SQM_0031GS.do", searchParams + "&" + saveStr);

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
			
		case IBSAVE:          // Supply 저장시
			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006"); //"There is no data to save.";
				return false;
			}			
			
			for(i=0; i<sheetObj.LastRow+1; i++){
				if(sheetObj.CellValue(i,"ibflag") == 'U' && sheetObj.CellBackColor(i,"fnl_bsa_capa") == sheetObj.RgbColor(255, 255, 255)){ //mas_lod_qty, mas_grs_rev가 null이면 saveStr 생성시 밸리데이션에 걸려서 임의로 0을 넣어줌
					sheetObj.CellValue(i,"mas_lod_qty") = 0;
					sheetObj.CellValue(i,"mas_grs_rev") = 0;
				}
			}

			var saveStr = sheetObj.GetSaveString(false, true, "ibflag");
			
			if ( saveStr == "" ) {
				return;
			}

			ComOpenWait(true);

			ComSetSearchParams("f_cmd", MULTI01);

			var sXml = sheetObj.GetSaveXml("ESM_SQM_0031GS.do", searchParams + "&" + saveStr);
			
			for(i=0; i<sheetObj.LastRow+1; i++){
				if(sheetObj.CellValue(i,"ibflag") == 'U' && sheetObj.CellBackColor(i,"fnl_bsa_capa") == sheetObj.RgbColor(255, 255, 255) && sheetObj.CellValue(i,"mas_lod_qty") == '0' && sheetObj.CellValue(i,"mas_grs_rev") == '0'){ //saveStr 생성시 밸리데이션에 걸려서 임의로 0을 넣어준 0을 다시 null로 변경
					sheetObj.CellValue(i,"mas_lod_qty") = '';
					sheetObj.CellValue(i,"mas_grs_rev") = '';
				}
			}

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
			
		case IBSEARCH_ASYNC01:
			ComSetSearchParams("f_cmd", SEARCH01);
			var sXml = sheetObj.GetSearchXml("ESM_SQM_0031GS.do",searchParams);
			return sXml;
			break;		
			
		case COMMAND02:           
			
			formObj.f_cmd.value = COMMAND02;

			formObj.f_fm_wk.value = qtaWeekArr[ComGetObjValue(formObj.f_bse_qtr_cd)][0].substring(3,5);
			formObj.f_to_wk.value = qtaWeekArr[ComGetObjValue(formObj.f_bse_qtr_cd)][1].substring(3,5);

			searchParams = FormQueryString(formObj);
			
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0031GS.do", searchParams);
			
			var arrXml = rtnXml.split("COMPARISON_WITH_");
			
			var c  = 2;
			
			for(a=1; a<arrXml.length; a++){ // arrXml[0]은 버릴 데이터이기 때문에 a를 1부터 시작
				
				if(arrXml[a].indexOf("HO_LOADING_DIFFERENT") > -1){
					
					var factors = arrXml[a].split("!");
					var tradeCode = factors[1];
					var subTradeCode = factors[2];
					var revenueLaneCode = factors[3];
					var directionCode = factors[4];
					var weekNumber = factors[5].replace(/\D/g,'');
					
					for(b=c; b<sheetObj.LastRow*2; b++){
						if( sheetObj.CellValue(b, "trd_cd") == tradeCode &&
							sheetObj.CellValue(b, "sub_trd_cd") == subTradeCode &&
							sheetObj.CellValue(b, "rlane_cd") == revenueLaneCode &&
							sheetObj.CellValue(b, "dir_cd") == directionCode &&
							sheetObj.CellValue(b, "bse_wk") == weekNumber ){
								var originalFlag = sheetObj.CellValue(b, "ibflag");
								sheetObj.CellValue2(b, "comparison_with_ho_loading") = "X";
								sheetObj.CellValue2(b, "ibflag") = originalFlag;
								findVvdFromOtherQuarter(b, "comparison_with_ho_loading");
								if(sheetObj.CellValue(b+1, "bse_wk") == weekNumber){
									for(d=b+1; d<sheetObj.LastRow*2; d++){
										if(sheetObj.CellValue(d, "bse_wk") == weekNumber){
											var originalFlag = sheetObj.CellValue(d, "ibflag");
											sheetObj.CellValue2(d, "comparison_with_ho_loading") = "X";
											sheetObj.CellValue2(d, "ibflag") = originalFlag;
											findVvdFromOtherQuarter(d, "comparison_with_ho_loading");
										}else{
											break;
										}
									}
								}
								c = b;
								break;
						}
					}
					
				}else if(arrXml[a].indexOf("HO_CONTRACT_DIFFERENT") > -1){
					
					var factors = arrXml[a].split("!");
					var tradeCode = factors[1];
					var subTradeCode = factors[2];
					var revenueLaneCode = factors[3];
					var directionCode = factors[4];
					var weekNumber = factors[5].replace(/\D/g,'');
					
					for(b=c; b<sheetObj.LastRow*2; b++){
						if( sheetObj.CellValue(b, "trd_cd") == tradeCode &&
							sheetObj.CellValue(b, "sub_trd_cd") == subTradeCode &&
							sheetObj.CellValue(b, "rlane_cd") == revenueLaneCode &&
							sheetObj.CellValue(b, "dir_cd") == directionCode &&
							sheetObj.CellValue(b, "bse_wk") == weekNumber ){
								var originalFlag = sheetObj.CellValue(b, "ibflag");
								sheetObj.CellValue2(b, "comparison_with_ho_contract") = "X";
								sheetObj.CellValue2(b, "ibflag") = originalFlag;
								findVvdFromOtherQuarter(b, "comparison_with_ho_contract");
								if(sheetObj.CellValue(b+1, "bse_wk") == weekNumber){
									for(d=b+1; d<sheetObj.LastRow*2; d++){
										if(sheetObj.CellValue(d, "bse_wk") == weekNumber){
											var originalFlag = sheetObj.CellValue(d, "ibflag");
											sheetObj.CellValue2(d, "comparison_with_ho_contract") = "X";
											sheetObj.CellValue2(d, "ibflag") = originalFlag;
											findVvdFromOtherQuarter(d, "comparison_with_ho_contract");
										}else{
											break;
										}
									}
								}
								c = b;
								break;
						}
					}
					
				}
				
			}
			break;
			
		case COMMAND03:           
			
			formObj.f_cmd.value = COMMAND03;

			formObj.f_fm_wk.value = qtaWeekArr[ComGetObjValue(formObj.f_bse_qtr_cd)][0].substring(3,5);
			formObj.f_to_wk.value = qtaWeekArr[ComGetObjValue(formObj.f_bse_qtr_cd)][1].substring(3,5);

			searchParams = FormQueryString(formObj);
			
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0031GS.do", searchParams);
			
			var arrXml = rtnXml.split("COMPARISON_WITH_");
			
			var c  = 2;
			
			for(a=1; a<arrXml.length; a++){ // arrXml[0]은 버릴 데이터이기 때문에 a를 1부터 시작
				if(arrXml[a].indexOf("RHQ_LOADING_DIFFERENT") > -1){
					var factors = arrXml[a].split("!");
					var tradeCode = factors[1];
					var subTradeCode = factors[2];
					var revenueLaneCode = factors[3];
					var directionCode = factors[4];
					var weekNumber = factors[5].replace(/\D/g,'');
					
					for(b=c; b<sheetObj.LastRow*2; b++){
						if( sheetObj.CellValue(b, "trd_cd") == tradeCode &&
							sheetObj.CellValue(b, "sub_trd_cd") == subTradeCode &&
							sheetObj.CellValue(b, "rlane_cd") == revenueLaneCode &&
							sheetObj.CellValue(b, "dir_cd") == directionCode &&
							sheetObj.CellValue(b, "bse_wk") == weekNumber ){
								var originalFlag = sheetObj.CellValue(b, "ibflag");
								sheetObj.CellValue2(b, "comparison_with_rhq_loading") = "X";
								sheetObj.CellValue2(b, "ibflag") = originalFlag;
								findVvdFromOtherQuarter(b, "comparison_with_rhq_loading");
								if(sheetObj.CellValue(b+1, "bse_wk") == weekNumber){
									for(d=b+1; d<sheetObj.LastRow*2; d++){
										if(sheetObj.CellValue(d, "bse_wk") == weekNumber){
											var originalFlag = sheetObj.CellValue(d, "ibflag");
											sheetObj.CellValue2(d, "comparison_with_rhq_loading") = "X";
											sheetObj.CellValue2(d, "ibflag") = originalFlag;
											findVvdFromOtherQuarter(d, "comparison_with_rhq_loading");
										}else{
											break;
										}
									}
								}
								c = b;
								break;
						}
					}
					
				}else if(arrXml[a].indexOf("RHQ_OUT_CONTRACT_DIFFERENT") > -1){
					var factors = arrXml[a].split("!");
					var tradeCode = factors[1];
					var subTradeCode = factors[2];
					var revenueLaneCode = factors[3];
					var directionCode = factors[4];
					var weekNumber = factors[5].replace(/\D/g,'');
					
					for(b=c; b<sheetObj.LastRow*2; b++){
						if( sheetObj.CellValue(b, "trd_cd") == tradeCode &&
							sheetObj.CellValue(b, "sub_trd_cd") == subTradeCode &&
							sheetObj.CellValue(b, "rlane_cd") == revenueLaneCode &&
							sheetObj.CellValue(b, "dir_cd") == directionCode &&
							sheetObj.CellValue(b, "bse_wk") == weekNumber ){
								var originalFlag = sheetObj.CellValue(b, "ibflag");
								sheetObj.CellValue2(b, "comparison_with_rhq_contract_outbound") = "X";
								sheetObj.CellValue2(b, "ibflag") = originalFlag;
								findVvdFromOtherQuarter(b, "comparison_with_rhq_contract_outbound");
								if(sheetObj.CellValue(b+1, "bse_wk") == weekNumber){
									for(d=b+1; d<sheetObj.LastRow*2; d++){
										if(sheetObj.CellValue(d, "bse_wk") == weekNumber){
											var originalFlag = sheetObj.CellValue(d, "ibflag");
											sheetObj.CellValue2(d, "comparison_with_rhq_contract_outbound") = "X";
											sheetObj.CellValue2(d, "ibflag") = originalFlag;
											findVvdFromOtherQuarter(d, "comparison_with_rhq_contract_outbound");
										}else{
											break;
										}
									}
								}
								c = b;
								break;
						}
					}
				}else if(arrXml[a].indexOf("RHQ_NONOUT_CONTRACT_DIFFERENT") > -1){
					var factors = arrXml[a].split("!");
					var tradeCode = factors[1];
					var subTradeCode = factors[2];
					var revenueLaneCode = factors[3];
					var directionCode = factors[4];
					var weekNumber = factors[5].replace(/\D/g,'');
					
					for(b=c; b<sheetObj.LastRow*2; b++){
						if( sheetObj.CellValue(b, "trd_cd") == tradeCode &&
							sheetObj.CellValue(b, "sub_trd_cd") == subTradeCode &&
							sheetObj.CellValue(b, "rlane_cd") == revenueLaneCode &&
							sheetObj.CellValue(b, "dir_cd") == directionCode &&
							sheetObj.CellValue(b, "bse_wk") == weekNumber ){
								var originalFlag = sheetObj.CellValue(b, "ibflag");
								sheetObj.CellValue2(b, "comparison_with_rhq_contract_nonoutbound") = "X";
								sheetObj.CellValue2(b, "ibflag") = originalFlag;
								findVvdFromOtherQuarter(b, "comparison_with_rhq_contract_nonoutbound");
								if(sheetObj.CellValue(b+1, "bse_wk") == weekNumber){
									for(d=b+1; d<sheetObj.LastRow*2; d++){
										if(sheetObj.CellValue(d, "bse_wk") == weekNumber){
											var originalFlag = sheetObj.CellValue(d, "ibflag");
											sheetObj.CellValue2(d, "comparison_with_rhq_contract_nonoutbound") = "X";
											sheetObj.CellValue2(d, "ibflag") = originalFlag;
											findVvdFromOtherQuarter(d, "comparison_with_rhq_contract_nonoutbound");
										}else{
											break;
										}
									}
								}
								c = b;
								break;
						}
					}
				}
			}
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
	var formObj    = document.form;
	var bse_yr     = ComGetObjValue(formObj.f_bse_yr);
	var bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
	var trd_cd     = "";
	var sub_trd_cd = "";
	var dir_cd     = "";
	var rlane_cd   = "";
	var param      = "";
	var sXml       = "";
	
//2014.05.09 EsmSqm0031ViewAdapter.java 에서 처리함
//	var iRows   = sheetObj.FindStatusRow("I");
//	var iRowArr = iRows.split(";");
//
//	for ( var i=0; i < iRowArr.length-1; i++ ) {
//		if (    trd_cd     == sheetObj.CellValue(iRowArr[i], "trd_cd")
//			 && sub_trd_cd == sheetObj.CellValue(iRowArr[i], "sub_trd_cd")
//			 && dir_cd     == sheetObj.CellValue(iRowArr[i], "dir_cd")
//			 && rlane_cd   == sheetObj.CellValue(iRowArr[i], "rlane_cd")
//			 && sXml != "" ) {
//			ComSqmSetIBCombo(sheetObj, sXml, "copy_vvd", true, 0, (iRowArr[i]));
//		} else {
//			trd_cd     = sheetObj.CellValue(iRowArr[i], "trd_cd");
//			sub_trd_cd = sheetObj.CellValue(iRowArr[i], "sub_trd_cd");
//			dir_cd     = sheetObj.CellValue(iRowArr[i], "dir_cd");
//			rlane_cd   = sheetObj.CellValue(iRowArr[i], "rlane_cd");
//
//			param = bse_yr + "|" + bse_qtr_cd + "|" + trd_cd + "|" + sub_trd_cd + "|" + dir_cd + "|" + rlane_cd + "|" + formObj.f_qta_tgt_cd.value;
//
//			sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=vvd&code_param=" + param + "&all_flag=");
//
//			ComSqmSetIBCombo(sheetObj, sXml, "copy_vvd", true, 0, (iRowArr[i]));
//		}
//	}
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
		case "mas_lod_qty":
		case "mas_grs_rev":
			var c_lod_qty = sheetObj.CellValue(row, "mas_lod_qty");
			var c_grs_rev = sheetObj.CellValue(row, "mas_grs_rev");
			var c_fnl_bsa_capa   = sheetObj.CellValue(row, "mas_fnl_bsa_capa");
			var s_flag    = sheetObj.CellSearchValue(row, "flag");
			var s_lod_qty = sheetObj.CellSearchValue(row, "mas_lod_qty");
			var s_grs_rev = sheetObj.CellSearchValue(row, "mas_grs_rev");

			var lod_qty   = sheetObj.CellValue(row, "lod_qty");
			var grs_rev   = sheetObj.CellValue(row, "grs_rev");

			// WEEK, MON 가 변경되었을 경우
			if ( s_flag == "W" || s_flag == "M" ) {
				if ( c_lod_qty == s_lod_qty && c_grs_rev == s_grs_rev ) {
					sheetObj.CellValue2(row, "flag")   = sheetObj.CellSearchValue(row, "flag");
					sheetObj.CellValue2(row, "ibflag") = "U";
				} else {
					sheetObj.CellValue2(row, "flag")   = "C";
				}
			// Sales YRMON 이 변경되었을 경우(SQM_CFM_TGT_VVD_ADJ insert 제외. 히스토리를 남기지 않음.)
			} else if ( s_flag == "Y" ) {
				if ( c_lod_qty == s_lod_qty && c_grs_rev == s_grs_rev ) {
					sheetObj.CellValue2(row, "flag")   = sheetObj.CellSearchValue(row, "flag");
					sheetObj.CellValue2(row, "ibflag") = "U";
				} else {
					sheetObj.CellValue2(row, "flag")   = "C2";
				}
			// BSA 가 변경되었을 경우
			} else if ( s_flag == "B" ){
				if (c_fnl_bsa_capa != "0" ) {
					if ( c_lod_qty == lod_qty && c_grs_rev == grs_rev ) {
						sheetObj.CellValue2(row, "flag")   = "R";
					} else {
						sheetObj.CellValue2(row, "flag")   = s_flag ;
					}
				}
			} else {
				if (sheetObj.CellValue(row, "adj_chk") == 1 ) {
					if ( lod_qty == c_lod_qty && grs_rev == c_grs_rev) {
						sheetObj.CellValue2(row, "flag")   = "R";
						sheetObj.CellValue2(row, "ibflag") = "R";
					} else {
						sheetObj.CellValue2(row, "flag")   = "C";
						sheetObj.CellValue2(row, "ibflag") = "U";
					}
				}
			}
			break;

		case "copy_vvd":
			// Copy VVD 가 선택 가능하다는건 Data 가 I 일 경우
			if ( sheetObj.CellValue(row, "mas_fnl_bsa_capa") == "0") {
				sheetObj.CellValue(row, "mas_lod_qty")    = 0;
				sheetObj.CellValue(row, "mas_grs_rev")    = 0;
//				sheetObj.CellValue(row, "spl_potn")       = false;
			} else {
				if ( ComTrim(value) == "" ) {
					sheetObj.CellEditable(row, "mas_lod_qty") = true;
					sheetObj.CellEditable(row, "mas_grs_rev") = true;
//					sheetObj.CellEditable(row, "spl_potn")    = false;
					sheetObj.CellValue(row, "mas_lod_qty")    = "";
					sheetObj.CellValue(row, "mas_grs_rev")    = "";
//					sheetObj.CellValue(row, "spl_potn")       = false;
				} else {
					sheetObj.CellValue(row, "mas_lod_qty")    = 0;
					sheetObj.CellValue(row, "mas_grs_rev")    = 0;
					sheetObj.CellEditable(row, "mas_lod_qty") = false;
					sheetObj.CellEditable(row, "mas_grs_rev") = false;
//					sheetObj.CellEditable(row, "spl_potn")    = true;
				}
			}
			break;

//		case "spl_potn":
//			if ( sheetObj.CellValue(row, "ibflag") != "I" ) {
//				if ( value == 1 ) {
//					sheetObj.CellValue(row, "coa_lod_qty")    = 0;
//					sheetObj.CellValue(row, "coa_grs_rev")    = 0;
//					sheetObj.CellEditable(row, "coa_lod_qty") = false;
//					sheetObj.CellEditable(row, "coa_grs_rev") = false;
//				} else {
//					sheetObj.CellValue(row, "coa_lod_qty")    = sheetObj.CellSearchValue(row, "coa_lod_qty");
//					sheetObj.CellValue(row, "coa_grs_rev")    = sheetObj.CellSearchValue(row, "coa_grs_rev");
//					sheetObj.CellEditable(row, "coa_lod_qty") = true;
//					sheetObj.CellEditable(row, "coa_grs_rev") = true;
//				}
//			}
//			break;

		case "adj_chk": //Adjustment VVD Select 가 변경되면
			//sheetObj.Redraw = false;
			var s_flag   = sheetObj.CellSearchValue(row, "flag");

			if ( value == 1 ) { //선택되면 BSA = 0 인것을제외하고 Current 정보를 옮겨준다
				if ( s_flag == "R" ){
					sheetObj.CellValue(row, "mas_cost_yrmon")    = sheetObj.CellSearchValue(row, "sls_yrmon");
					sheetObj.CellValue(row, "mas_bse_yrmon")    = sheetObj.CellSearchValue(row, "bse_yrmon");
					sheetObj.CellValue(row, "mas_bse_mon")      = sheetObj.CellSearchValue(row, "bse_mon");
					sheetObj.CellValue(row, "mas_bse_wk")       = sheetObj.CellSearchValue(row, "bse_wk");
					sheetObj.CellValue(row, "mas_vvd")          = sheetObj.CellSearchValue(row, "vvd");
					sheetObj.CellValue(row, "mas_fnl_bsa_capa") = sheetObj.CellSearchValue(row, "fnl_bsa_capa");
					sheetObj.CellValue(row, "mas_lod_qty")      = sheetObj.CellSearchValue(row, "lod_qty");
					sheetObj.CellValue(row, "mas_grs_rev")      = sheetObj.CellSearchValue(row, "grs_rev");
				}
				sheetObj.CellEditable(row, "mas_lod_qty") = true;
				sheetObj.CellEditable(row, "mas_grs_rev") = true;
			} else {
				if ( s_flag == "R" ){
					sheetObj.CellValue(row, "mas_cost_yrmon")	= "";
					sheetObj.CellValue(row, "mas_bse_yrmon")	= "";
					sheetObj.CellValue(row, "mas_bse_mon")      = "";
					sheetObj.CellValue(row, "mas_bse_wk")       = "";
					sheetObj.CellValue(row, "mas_vvd")          = "";
					sheetObj.CellValue(row, "mas_fnl_bsa_capa") = "";
					sheetObj.CellValue(row, "mas_lod_qty")      = "";
					sheetObj.CellValue(row, "mas_grs_rev")      = "";
				}
				sheetObj.CellEditable(row, "mas_lod_qty") = false;
				sheetObj.CellEditable(row, "mas_grs_rev") = false;
				sheetObj.CellValue2(row, "flag")   = s_flag;
				sheetObj.CellValue2(row, "ibflag") = "R";
			}

			//sheetObj.Redraw = true;
			break;
	}
}

/**
 * f_bse_yr가 바뀌었을때 Lane 재조회
 */
function f_bse_yr_OnChange(obj, value, text) {
	period_change_based_on_rev_month();
	setTradeCombo();
}

/**
 * f_bse_qtr_cd 바뀌었을때 Lane 재조회
 */
function f_bse_qtr_cd_OnChange(obj, value, text) {
	period_change_based_on_rev_month();
	setTradeCombo();
}

/**
 * f_trd_cd 바뀌었을때 f_lane_cd 콤보조회
 */
function f_trd_cd_OnChange(obj, value, text) {
	setLaneCombo();
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
	     + "&all_flag=";	// Trade

		var sXml = sheetObj.GetSearchXml("CommonGS.do",param);		
		ComXml2ComboItem(sXml, formObj.f_trd_cd, "code", "name");
		// 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
		var rlane_index = SearchIndex(formObj.f_trd_cd, trd_cd);
		formObj.f_trd_cd.Index = rlane_index;
		
		if(login_ofc_cd == "SELCMI"){ // 로그인 오피스가 SELCMI일때는 Trade콤보에 IAS만 보여줌
			var splitXml = sXml.split("☜☞☜☞");
			var tradeCodes = new Array();
			for(i=1,j=0; i<splitXml.length; i++,j++){
				tradeCodes[j] = splitXml[i].substring(0,3);
				if(tradeCodes[j] != 'IAS'){
					formObj.f_trd_cd.DeleteItem(tradeCodes[j]);
				}
			}
		}
}

/**
 * Trade에 따른 RLane 정보를 보여줌
 * @returns
 */
function setLaneCombo() {
 	var formObj = document.form;
 	var trd_cd    = ComGetObjValue(formObj.f_trd_cd);
 	var rlane_cd  = ComGetObjValue(formObj.f_rlane_cd);
 	
	if (trd_cd != "All" && trd_cd != "" ) {	
	 	var param = "f_cmd=" + SEARCH02
	     + "&code_name=rLaneOfc"
	     + "&code_param= " 
	     + "&all_flag=All"
	     + "&" + FormQueryString(formObj);	// Trade

	 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, formObj.f_rlane_cd, "code", "name");
	 	
	 // 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
	 	var rlane_index = SearchIndex(formObj.f_rlane_cd, rlane_cd);
		formObj.f_rlane_cd.Index = rlane_index;
	} else {
		formObj.f_rlane_cd.RemoveAll();
		formObj.f_rlane_cd.InsertItem(0, "All", "All");
		formObj.f_rlane_cd.Index = 0;
	}
	
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
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction){
	switch(sAction) {
		case IBCREATE:  // Creation
			//Creation 전 RHQ에는 Portion을 부여했으나 
			//해당 RHQ 산하의 Office에게 Portion을 부여하지 않은 RHQ List를 조회후 List가 없을경우 Freezing.
			/* [2016.07.14] QTA Adjustment by VVD 팝업 메시지 호출 제거
			var arrXml = doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
			var OfcZeroPortion = ComGetEtcData(arrXml, "OfcZeroPortion");
			if(OfcZeroPortion != null && OfcZeroPortion != ""){
				ComShowCodeMessage("SQM00052", OfcZeroPortion.substr(1));
				return false;
			}
			*/
			break;
	}
	return true;
}

function comparisonWithHo(){
	doActionIBSheet(sheetObjects[0], document.form, COMMAND02);
}

function comparisonWithRhq(){
	doActionIBSheet(sheetObjects[0], document.form, COMMAND03);
}

function findVvdFromOtherQuarter(row, column){
	var revenueQuarter = sheetObjects[0].CellValue(row, "revenue_quarter");
	var year = revenueQuarter.substring(0,4);
	var quarter = revenueQuarter.substring(4,6);
	var trade = sheetObjects[0].CellValue(row, "trd_cd");
	var revenueLane = sheetObjects[0].CellValue(row, "rlane_cd");
	var vvd = sheetObjects[0].CellValue(row, "vvd");
	var vslCd = vvd.substr(0,4);
	var skdVoyNo = vvd.substr(4,4);
	var skdDirCd = vvd.substr(8);
	
	var param = "f_cmd=" + SEARCH03
//    + "&f_bse_yr=" + year
    + "&f_bse_qtr_cd=" + quarter
    + "&f_trd_cd=" + trade
    + "&f_rlane_cd=" + revenueLane
    + "&f_vsl_cd=" + vslCd
    + "&f_skd_voy_no=" + skdVoyNo
    + "&f_skd_dir_cd=" + skdDirCd;
	
	var rtnXml = sheetObjects[0].GetSearchXml("ESM_SQM_0031GS.do",param);
	
	var flag = rtnXml.indexOf("TOTAL='0'"); // 결과값이 0이 아닐때 -> 해당 vvd가 다른 분기에 존재할 때
	
	if(flag == '-1'){ // 해당 vvd가 다른 분기에서 넘어왔으며, 새로 넘어오게 된 분기의 portion adjustment에 넘어온 vvd의 week가 세팅이 되어 있지 않을 때
//		sheetObjects[0].CellBackColor(row, column) = sheetObjects[0].RgbColor(192, 0, 0);
		searchPortionAdjustmentSetting(row, column, year, quarter, trade, revenueLane, skdDirCd); // Portion Adjustment 화면에 세팅된 데이터가 있는지 확인
	}
}

function searchPortionAdjustmentSetting(row, column, year, quarter, trade, revenueLane, skdDirCd){
	
	var officeLevel = "";
	var officeView = "";
	var qtaStepCd = "";
	
	if(column.indexOf("ho") != -1){
		officeLevel = "HO";
		qtaStepCd = "02";
	}else if(column.indexOf("rhq") != -1){
		officeLevel = "RHQ";
		qtaStepCd = "03";
	}
	
	if(column.indexOf("loading") > -1){
		officeView = "L";
	}else if(column.indexOf("contract") > -1){
		officeView = "C";
		if(column.indexOf("_outbound") != -1){ //문자 앞에 _빼면 nonoutbound가 들어와도 그 안에 outbound를 포함하고 있으므로 의도치 않은 결과가 발생할 수 있음
			officeLevel = "RHQ_C";
			qtaStepCd = "05";
		}else if(column.indexOf("_nonoutbound") != -1){
			officeLevel = "RHQ_C";
			qtaStepCd = "04"; //N.OB가 STEP 04임!!
		}
	}
	
	var param = "f_cmd=" + SEARCH // 다른화면(0032)으로 보냄
  + "&f_bse_yr=" + year
  + "&f_bse_qtr_cd=" + quarter
  + "&f_rlane_cd=" + revenueLane
  + "&f_trd_cd=" + trade
  + "&lane_bound=" + skdDirCd
  + "&f_bse_tp_cd=Q" 
  + "&f_gubun=" + officeLevel
  + "&f_ofc_vw_cd=" + officeView
  + "&f_qta_step_cd=" + qtaStepCd
  ;
	
	var rtnXml = sheetObjects[0].GetSearchXml("ESM_SQM_0032GS.do",param); //다른화면(0032)쪽으로 보냄
	
	var flag = rtnXml.indexOf("TOTAL='0'"); // 결과값이 0이 아닐때 ->  
	
	if(flag == '-1'){ //  
		sheetObjects[0].CellBackColor(row, column) = sheetObjects[0].RgbColor(192, 0, 0);
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