/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0057.js
*@FileTitle      : SKD Adjustment by VVD
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.04.04
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.23 SQM USER
* 1.0 Creation
* 2014.01.02 이혜민 [CHM-201328060-01] SQM 데이터 조회시 현재날짜와 조건날짜 비교하여 다른 테이블에서 조회되도록 수정
* 2014.04.04 이혜민 [CHM-201429614-01] KPI Management => SKD Adjustment by VVD 화면 검색조건 로직 수정
* 2015.01.22 김용습 [CHM-201533807] Rev Month 기준으로 관련 화면의 period를 변경
* 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
* 2015.08.10 김용습 [CHM-201536994] Split24-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
* 2015.11.09 김용습 [CHM-201538494] [CSR 전환건] SKD Adjustment by VVD 화면 보완 (Trade Direction, Adjusting VVD Select, BSA Flag 칼럼 추가)
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends 
 * @class ESM_SQM_0507 : ESM_SQM_0507 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0507() {
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
				sheetObj.ColHidden("dir_cd") = true;
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;
			case "btn_DownExcel":
				sheetObj.ColHidden("dir_cd") = false;
				doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
				sheetObj.ColHidden("dir_cd") = true;
				break;
			case "btn_Creation":
				doActionIBSheet(sheetObj, formObj, IBCREATE);
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

function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm("click",		"obj_click",	formObj);
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

	if ( !(login_ofc_cd == "SELCSG" || login_ofc_cd == "SELCMR") ) ComBtnDisable("btn_Creation");
	
	loadingMode = false;
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
				
				var HeadTitle  =  "Trade|Lane\nBound|Trade\nDirection|Sub\nTrade|Lane|IOC|Flg|STS|Currently Updated|Currently Updated|Currently Updated|Currently Updated|Need to be Updated|Need to be Updated|Need to be Updated|Need to be Updated|Update Option|Update Option|Update Option";
				var HeadTitle2 =  "Trade|Lane\nBound|Trade\nDirection|Sub\nTrade|Lane|IOC|Flg|STS|Month|Week|VVD|Supply|Month|Week|VVD|Supply|Copy VVD|Adjusting\nVVD Select|BSA Flag";
								
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle) + 1, 0, 0, true);
				
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, false, true, false, false);
				
				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle,	true);
				InitHeadRow(1, HeadTitle2,	false);
				
				// 전체 높이 설정
				style.height = GetSheetHeight(20);
				
				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtData,			60,	daCenter,	true,	"trd_cd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			55,	daCenter,	true,	"dir_cd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0, cnt++,  dtData,         60,	daCenter,   true,   "hul_bnd_cd",   	false,  "", dfNone,     	0,  false,  false);
				InitDataProperty(0,	cnt++,	dtData,			60,	daCenter,	true,	"sub_trd_cd",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			70,	daCenter,	true,	"rlane_cd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		40,	daCenter,	true,	"ioc_cd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		40,	daCenter,	true,	"flag",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,	daCenter,	true,	"ibflag",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,	daCenter,	false,	"bse_mon",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,	daCenter,	true,	"bse_wk",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			85,	daCenter,	true,	"vvd",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			70,	daRight,	true,	"fnl_bsa_capa",		false,	"",	dfNullInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,	daCenter,	true,	"mas_bse_mon",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,	daCenter,	true,	"mas_bse_wk",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			85,	daCenter,	true,	"mas_vvd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			70,	daRight,	true,	"mas_fnl_bsa_capa",	false,	"",	dfNullInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCombo,		90,	daCenter,	true,	"copy_vvd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCheckBox,		80,	daCenter,	false,	"adj_vvd",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++,	dtData,			65,	daCenter,	false,	"bsa_zr_flg",		false,	"",	dfNone,			0,	false,	false);
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
			
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0507GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 2)
				ComSetYearQta(arrXml[2]);
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], formObj.f_trd_cd, "code", "name");
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], formObj.f_dir_cd, "code", "name");
			if (arrXml.length >5 ){
				// Currently Quarter 정보를 추출한다.
				var arrData = ComSqmGetXmlValue(arrXml[5]);
				var arrCode = arrData.split("-");
				formObj.f_crnt_bse_yr.value = arrCode[0];
				formObj.f_crnt_qta_cd.value = arrCode[1];
			}
			if (arrXml.length > 6)
				ComXml2ComboItem(arrXml[6], formObj.f_hul_bnd_cd, "code", "name");
			ComOpenWait(false);
			break;
		
		case IBSEARCH:          // 화면 조회 시
			ComOpenWait(true);
			
			formObj.f_cmd.value = SEARCH;
			
			formObj.f_fm_wk.value = qtaWeekArr[ComGetObjValue(formObj.f_bse_qtr_cd)][0].substring(3,5);
			formObj.f_to_wk.value = qtaWeekArr[ComGetObjValue(formObj.f_bse_qtr_cd)][1].substring(3,5);
			
			searchParams = FormQueryString(formObj);
			
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0507GS2.do", searchParams);
			
			sheetObj.LoadSearchXml(rtnXml);
			
			ComOpenWait(false);
			break;
			
		case IBCREATE:          // 생성
			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006");
				return false;
			}
			
			if (ComShowConfirm (ComGetMsg("SQM00009")) != 1) {
				return false;
		    }
			
			if (!validateForm(sheetObj, formObj, sAction)) return;
			
			ComOpenWait(true);
			
			ComSetSearchParams("f_cmd", MULTI);
			
			sheetObj.DoSave("ESM_SQM_0507GS.do", searchParams, -1, false);
			
			ComOpenWait(false);
			
			var State = sheetObj.EtcData("TRANS_RESULT_KEY");
			
			if ( State == "S" ) {
				ComShowMessage(ComResultMessage(sXml));
				ComShowCodeMessage("SQM00010", "Data");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			} else if ( State != "S" ){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}
			
			break;
			
		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.Down2Excel(-1, false, false, true);
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
	var formObj    = document.form;
	var bse_yr     = ComGetObjValue(formObj.f_bse_yr);
	var bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
	var trd_cd     = "";
	var sub_trd_cd = "";
	var dir_cd     = "";
	var rlane_cd   = "";
	var param      = "";
	var sXml       = "";
	
	var iRows   = sheetObj.FindStatusRow("I");
	var iRowArr = iRows.split(";");
	
	for ( var i=0; i < iRowArr.length-1; i++ ) {
		if (    trd_cd     == sheetObj.CellValue(iRowArr[i], "trd_cd")
			 && sub_trd_cd == sheetObj.CellValue(iRowArr[i], "sub_trd_cd")
			 && dir_cd     == sheetObj.CellValue(iRowArr[i], "dir_cd")
			 && rlane_cd   == sheetObj.CellValue(iRowArr[i], "rlane_cd")
			 && sXml != "" ) {
			ComSqmSetIBCombo(sheetObj, sXml, "copy_vvd", true, 0, (iRowArr[i]));
		} else {
			trd_cd     = sheetObj.CellValue(iRowArr[i], "trd_cd");
			sub_trd_cd = sheetObj.CellValue(iRowArr[i], "sub_trd_cd");
			dir_cd     = sheetObj.CellValue(iRowArr[i], "dir_cd");
			rlane_cd   = sheetObj.CellValue(iRowArr[i], "rlane_cd");
			
			param = bse_yr + "|" + bse_qtr_cd + "|" + trd_cd + "|" + sub_trd_cd + "|" + dir_cd + "|" + rlane_cd;
			
			sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=spclVvd&code_param=" + param + "&all_flag=");
			
			ComSqmSetIBCombo(sheetObj, sXml, "copy_vvd", true, 0, (iRowArr[i]));
		}
	}
}

/**
 * onChange event
 * f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
 */	
function f_trd_cd_OnChange(obj, value, text) {
	setLaneCombo();
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

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj, formObj, sAction) {
	switch(sAction) {
		case IBCREATE:
			var iRows   = sheetObj.FindStatusRow("I");
			var iRowArr = iRows.split(";");
			
			for ( var i=0; i < iRowArr.length-1; i++ ) {
				if ( sheetObj.CellValue(iRowArr[i], "copy_vvd") == "" ) {
					ComShowCodeMessage("SQM00013", "VVD Copy");
					sheetObj.SelectCell(iRowArr[i], "copy_vvd");
					return false;
				}
			}
			break;
	}
	return true;
}

/**
 * f_bse_yr가 바뀌었을때 period 의 year 변경
 */
function f_bse_yr_OnChange(obj, value, text) {
	period_change();
//	period_change_based_on_rev_month();
	setLaneCombo();
}

/**
 * f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
 */
function f_bse_qtr_cd_OnChange(obj, value, text) {
	period_change();
//	period_change_based_on_rev_month();
	setLaneCombo();
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
	
	var bse_yr     = ComGetObjValue(formObj.f_bse_yr);
	var bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
	var trd_cd     = "";
	var sub_trd_cd = "";
	var dir_cd     = "";
	var rlane_cd   = "";
	var param      = "";
	var sXml       = "";

	switch(sName){
		case "adj_vvd": //Adjustment VVD Select 가 변경되면 COPY VVD 컬럼을 활성화 시킴
			if ( value == 1 ) { 
				if (sheetObj.CellValue(row, "mas_vvd") == ""){
					//Adjusting VVD select 박스 check하면 Copy VVD 컬럼의 콤보 세팅
					if (    trd_cd     == sheetObj.CellValue(row, "trd_cd")
							 && sub_trd_cd == sheetObj.CellValue(row, "sub_trd_cd")
							 && dir_cd     == sheetObj.CellValue(row, "dir_cd")
							 && rlane_cd   == sheetObj.CellValue(row, "rlane_cd")
							 && sXml != "" ) {
							ComSqmSetIBCombo(sheetObj, sXml, "copy_vvd", true, 0, (row));
						} else {
							trd_cd     = sheetObj.CellValue(row, "trd_cd");
							sub_trd_cd = sheetObj.CellValue(row, "sub_trd_cd");
							dir_cd     = sheetObj.CellValue(row, "dir_cd");
							rlane_cd   = sheetObj.CellValue(row, "rlane_cd");
							param = bse_yr + "|" + bse_qtr_cd + "|" + trd_cd + "|" + sub_trd_cd + "|" + dir_cd + "|" + rlane_cd;
							sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=spclVvd&code_param=" + param + "&all_flag=");
							ComSqmSetIBCombo(sheetObj, sXml, "copy_vvd", true, 0, (row));
						}
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
			if ( (sheetObj.CellValue(row, "copy_vvd") == sheetObj.CellValue(row, "vvd")) && sheetObj.CellValue(row, "vvd") != "" ) { 
				ComShowCodeMessage("SQM00061");
				sheetObj.CellValue(row, "copy_vvd") = "";
			} 
			break;
	}
}
/* 개발자 작업  끝 */