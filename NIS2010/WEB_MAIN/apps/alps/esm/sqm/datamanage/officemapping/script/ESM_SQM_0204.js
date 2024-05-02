/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0204.js
*@FileTitle      : Sector-Office Relation Setting for IAS Sector
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.08
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.08 SQM USER
* 1.0 Creation
* History
* 2014.05.07 이혜민 [CHM-201430049] IAS Sector sales - Planning 메뉴의 report 검색 조건 위치 변경 요청
* 2014.06.20 이혜민 [CHM-201430168] IAS Sector Sales - Main, Sector 구분자 추가를 위한 화면 변경
* 2014.08.25 이혜민 [CHM-201431601] 팝업 오픈시 부모창 조회조건을 자동세팅하도록 수정
* 2014.09.23 이혜민 [CHM-201431753] Sector-Office Relation Setting 화면 내 Raw Data Export 버튼 생성건 
* 2015.05.12 김용습 [CHM-201535562] [SQM] Sector-Office Relation Setting for IAS Sector - 타임아웃 방지를 위해 데이터를 반으로 나누어 생성되게 함
* 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
* 2015.10.29 김용습 [CHM-201537712] [CSR 전환건] "Sector-Office Relation Setting for IAS Sector 화면 내 Creation"의 로직 변경
* 2015.12.02 김용습 [CHM-201539212] 연간/분기동안 확정 Data에 한번 들어간 Sector Pair는 active 해제할 수 없도록 로직 수정
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends 
 * @class ESM_SQM_0204 : ESM_SQM_0204 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0204() {
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

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var tabLoad = new Array();
tabLoad[0]= 0;
tabLoad[1]= 0;

var rowCnt = 0;
var loadExcelsectorFlg = "";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
	var sheetObject = sheetObjects[0];
	var formObj     = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
			case "f_bse_tp_cd":
				f_bse_tp_cd_OnChange();
				break;	
			case "btn_Retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject, formObj, IBSAVE);
				break;
			case "btn_Creation":
				doActionIBSheet(sheetObject, formObj, MULTI01);
				break;
			case "btn_AddCreation":
				var sUrl = "ESM_SQM_0205.do?"+searchParams;
				var rtn = ComOpenWindowCenter(sUrl, "ESM_SQM_0205", 890, 400, true);
				//팝업 닫힌 후 재조회
				if(rtn == "OK") doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
			case "btn_PairAdd":
				var sUrl = "ESM_SQM_0206.do?"+searchParams;
				var rtn = ComOpenWindowCenter(sUrl, "ESM_SQM_0206", 890, 400, true);
				//팝업 닫힌 후 재조회
				if(rtn == "OK") doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;	
			case "btn_Downexcel":
				doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
				break;
			case "btn_Loadexcel":
				doActionIBSheet(sheetObject, formObj, IBLOADEXCEL);
				break;
			case "btn_RawDataDownExcel":
				doActionIBSheet(sheetObject, formObj, "RawDataDownExcel");
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

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj){
	tabObjects[tabCnt++] = tab_obj;
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
	for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
	}
	
	doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
	
	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}
	toggleButtons("INIT");
	//팝업으로 열렸을때 부모창 조건 세팅
    if(formObj.popMode.value == "Y"){
    	ComSetObjValue(formObj.f_bse_yr, formObj.p_bse_yr.value);
    	ComSetObjValue(formObj.f_bse_qtr_cd, formObj.p_bse_qtr_cd.value);
    	ComSetObjValue(formObj.f_ofc_vw_cd, formObj.p_ofc_vw_cd.value);
		ComSetObjValue(formObj.f_sub_trd_cd, formObj.p_sub_trd_cd.value);
		ComSetObjValue(formObj.f_ias_rgn_cd, formObj.p_ias_rgn_cd.value);
		ComSetObjValue(formObj.f_dir_cd, formObj.p_dir_cd.value);
		ComSetObjValue(formObj.f_rlane_cd, formObj.p_rlane_cd.value);
	}
	loadingMode = false;
}


var initSheetFn = function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	
	switch(sheetNo) {
		case 1:		//sheet1 init
			with (sheetObj) {
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;  //msNone; //msHeaderOnly //msPrevColumnMerge;
				
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);
				
				var HeadTitle1 =  "STS|SEQ|Year|Quarter|Office View|Trade|Sub Trade|IAS Region|R.Lane|Lane Bound|RHQ|Office|POL|POD|Active|Main";

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);
				
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, true, true, false, false);
				
				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
														
				// 전체 높이 설정
				style.height = GetSheetHeight(17);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtStatus,	30,	  daCenter,	 true,	"ibflag",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtSeq,		40,	  daCenter,  true,	"seq",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		40,	  daCenter,	 true,	"bse_yr",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,	  daCenter,	 true,	"bse_qtr_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		70,	  daCenter,	 true,	"ofc_vw_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		55,	  daCenter,	 true,	"trd_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		70,	  daCenter,	 true,	"sub_trd_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		90,   daCenter,	 true,	"ias_rgn_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,   daCenter,	 true,	"rlane_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		80,   daCenter,	 true,	"dir_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,   daCenter,	 true,	"rhq_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,   daCenter,	 true,	"rgn_ofc_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,	  daCenter,	 true,	"pol_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,	  daCenter,	 true,	"pod_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCheckBox,	70,   daCenter,	 true,	"sqm_act_flg",	false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtCheckBox,	30,  daCenter,	 false,	"sqm_mn_sctr_flg",	false,	"",	dfNone,	0,	false,	false);

			}
			break;
			
		case 2:		//sheet2 init
			with (sheetObj) {
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;  //msNone; //msHeaderOnly //msPrevColumnMerge;
				
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);
				
				var HeadTitle1 =  "STS|SEQ|Year|Quarter|Office View|Trade|Sub Trade|IAS Region|R.Lane|Lane Bound|P/F SKD\nGroup|RHQ|Office|POL|POD|Active|Main";

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);
				
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, false, true, false, false);
				
				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
														
				// 전체 높이 설정
				style.height = GetSheetHeight(15);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,	  daCenter,	 true,	"ibflag",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtSeq,		40,	  daCenter,  true,	"seq",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		40,	  daCenter,	 true,	"bse_yr",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,	  daCenter,	 true,	"bse_qtr_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		70,	  daCenter,	 true,	"ofc_vw_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		55,	  daCenter,	 true,	"trd_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		70,	  daCenter,	 true,	"sub_trd_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		85,  daCenter,	 true,	"ias_rgn_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		65,   daCenter,	 true,	"rlane_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		70,   daCenter,	 true,	"dir_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		65,   daCenter,	 true,	"pf_grp_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,   daCenter,	 true,	"rhq_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,   daCenter,	 true,	"rgn_ofc_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,	  daCenter,	 true,	"pol_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,	  daCenter,	 true,	"pod_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCheckBox,	65,  daCenter,	 true,	"sqm_act_flg",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCheckBox,	50,  daCenter,	 false,	"sqm_mn_sctr_flg",	false,	"",	dfNone,	0,	false,	false);


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
		
		case "f_pf_grp_cd":
			with (comboObj) {
				SetTitle("R/Lane|Group"); 
				SetColAlign("center|center");
				SetColWidth("100|100");

			}
			break;		
		case "f_rlane_cd":
			with (comboObj) {
				DropHeight = 300;
				InsertItem(0, '', '');
				Index = 0;
			}	
		default:
			with (comboObj) {
				DropHeight = 300;
				Index      = 0;
			}
			break;
	}
}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj , tabNo) {
	switch(tabNo) {
		case 1:
			with (tabObj) {
				var cnt  = 0 ;
				InsertTab( cnt++ , "Pair Active Edit" , -1 );
				InsertTab( cnt++ , "Pair by P/F SKD Group" , -1 );
			}
			break;
	}
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj , nItem) {
	var objs = document.all.item("tabLayer");
	var formObj = document.form;

	objs[nItem].style.display = "inline";
	objs[beforetab].style.display = "none";

	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	//------------------------------------------------------//
	// 두번째 tab 일 때 loadExcel 버튼 비활성화
	if(formObj.dataCnt.value > 0 ){
		if(nItem == "1"){
			ComBtnDisable("btn_Loadexcel");
		}else{
		    ComBtnEnable("btn_Loadexcel");
		}
	}
	beforetab= nItem;
}

/**
* f_bse_yr가 바뀌었을때 period 의 year 변경
*/
function f_bse_yr_OnChange(obj, value, text) {
	period_change();
}

/**
* f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
*/
function f_bse_qtr_cd_OnChange(obj, value, text) {
	period_change();
}

/**
* Sheet 관련 프로세스 처리
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var sheetObj1 = sheetObjects[1];
	switch(sAction) {
		case IBCLEAR:          // 화면 접속 시
			sheetObj.WaitImageVisible = false;
			
			ComOpenWait(true);
			
			formObj.f_cmd.value = INIT;
			
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0204GS.do", FormQueryString(formObj));
			var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
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
				ComXml2ComboItem(arrXml[6], formObj.f_ofc_vw_cd, "code", "name");
			if (arrXml.length > 7)
				ComXml2ComboItem(arrXml[7], formObj.f_rhq_cd, "code", "name");
			ComOpenWait(false);
			break;
		
			
		case IBSEARCH:          // 화면 조회 시
			if (!validateForm(sheetObj, formObj, sAction))
				return;
			formObj.f_cmd.value = SEARCH;
			searchParams = FormQueryString(formObj);
			ComOpenWait(true);
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0204GS.do",searchParams);
			var arrXml = rtnXml.split("|$$|");
			sheetObj.LoadSearchXml(arrXml[0]);
			sheetObj1.LoadSearchXml(arrXml[1]);
			var etcData = getEtcData(arrXml[0]);
			formObj.dataCnt.value = etcData["dataCnt"];
			if (formObj.dataCnt.value == 0) {
				toggleButtons("SEARCH01");
			} else {
				toggleButtons("SEARCH02");
			}
			ComOpenWait(false);
			break;
			
		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.Down2Excel(-1, false, false, true);
			ComOpenWait(false);
			break;
			
		case IBSAVE:          // 화면 저장시
			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006");
		        return false;
		    }
			if (ComShowConfirm (ComGetMsg("SQM00004")) != 1) {
				return false;
		    }
			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI);
			sheetObj.DoSave("ESM_SQM_0204GS.do", searchParams, -1, false);
			ComOpenWait(false);
	
			var State = sheetObj.EtcData("TRANS_RESULT_KEY");
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('SQM00001','Data');
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
			break;
			
		case MULTI01:		// Creation시에
			if (!validateForm(sheetObj, formObj, sAction)) return;
			
			if (ComShowConfirm (ComGetMsg("SQM00058")) != 1) {
				return false;
		    }
			
			//배치 프로세스
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI01;
			createCodeSheetObject();
			var sXml = codeSheet.GetSearchXml("ESM_SQM_0204GS.do?", FormQueryString(formObj));
			
			ComShowCodeMessage("SQM00059");
			ComOpenWait(false);
			
			break;
		
		case IBSEARCH_ASYNC01:
			ComSetSearchParams("f_cmd", SEARCH02);
			var sXml = sheetObj.GetSearchXml("ESM_SQM_0204GS.do",searchParams);
			return sXml;
			break;
			
		case IBLOADEXCEL:		// 엑셀 업로드
			var dataCnt = formObj.dataCnt.value;
			ComOpenWait(true);
			if(dataCnt != "0"){
				loadExcelRowCnt    = sheetObj.HeaderRows + sheetObj.TotalRows;
				loadExcelTotFlg    = false;		// 화면에 Total Row 존재 여부
				loadExcelExField   = "|sqm_act_flg|";		// 비교 제외 필드
				loadExcelAplyField = "|sqm_act_flg|";		// 반영 필드
				loadExcelsectorFlg = "Y";
				
				var rtn = window.showModalDialog("ESM_SQM_1001.do?" + searchParams, window, "dialogHeight:620px;dialogWidth:1050px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");
				if(rtn == "S")
					ComShowCodeMessage("SQM00036");
			}
			ComOpenWait(false);
			break;
			
		case "RawDataDownExcel":		// Raw Data 엑셀 다운로드
			ComOpenWait(true);
           //Year, Quarter, Office view user 선택. office level은 항상 office. week, vvd, pol-pod pair check.
			var param = "f_cmd="         + COMMAND01
			          + "&f_bse_tp_cd="  + ComGetObjValue(formObj.f_bse_tp_cd)
			          + "&f_bse_yr="     + ComGetObjValue(formObj.f_bse_yr)
			          + "&f_bse_qtr_cd=" + ComGetObjValue(formObj.f_bse_qtr_cd)
			          + "&f_ofc_vw_cd="  + ComGetObjValue(formObj.f_ofc_vw_cd)
					  + "&f_gubun=Y";

			document.location.href = "ESM_SQM_0204DL.do?" + param;

			ComOpenWait(false);
			break;	
  }
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction){
	switch(sAction) {
		case MULTI01:  // Creation
			var arrXml = doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
			var nActList = ComGetEtcData(arrXml, "nActList");
			if(nActList != null && nActList != ""){
				ComShowCodeMessage("SQM00047", nActList.substr(1));
				return false;
			}
			break;
    	
		case IBSEARCH: 
			if(formObj.f_rlane_cd.Code == ""){
				ComShowCodeMessage('SQM00013','R/Lane');
				return false;
			}
			break;
	}
	return true;
}

/**
* onChange event
* f_sub_trd_cd 바뀌었을때  f_lane_cd 콤보조회
*/	
function f_sub_trd_cd_OnChange(obj, value, text) {
 	var formObj = document.form;
 	var param = "f_cmd=" + SEARCH01
    + "&code_name=rLane"
    + "&code_param=IAS|"+formObj.f_sub_trd_cd.Code+"|"+formObj.f_ias_rgn_cd.Code
    + "&all_flag=";

 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
 	ComXml2ComboItem(xmlStr, formObj.f_rlane_cd, "code", "name");
 	formObj.f_rlane_cd.Index = 0;
 }

/**
* onChange event
* f_ias_rgn_cd 바뀌었을때  f_lane_cd 콤보조회
*/	
function f_ias_rgn_cd_OnChange(obj, value, text) {
 	var formObj = document.form;
 	var param = "f_cmd=" + SEARCH01
    + "&code_name=rLane"
    + "&code_param=IAS|"+formObj.f_sub_trd_cd.Code+"|"+formObj.f_ias_rgn_cd.Code
    + "&all_flag=";

 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
 	ComXml2ComboItem(xmlStr, formObj.f_rlane_cd, "code", "name");
 	formObj.f_rlane_cd.Index = 0;
}

/**
 * f_rlane_cd 바뀌었을때 POL, POD 변경
 */
function f_rlane_cd_OnChange(obj, value, text) {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	//POL
	var param1 = "f_cmd=" + SEARCH02
    + "&code_name=polCdSectorOfc"
    + "&code_param= " 
    + "&all_flag=All"
    + "&" + FormQueryString(formObj);	// R/Lane

	var xmlStr1 = sheetObjects[0].GetSearchXml("CommonGS.do", param1);
	ComXml2ComboItem(xmlStr1, formObj.f_pol_cd, "code", "name");
	formObj.f_pol_cd.Index = 0;
	
	//POD
	var param2 = "f_cmd=" + SEARCH02
    + "&code_name=podCdSectorOfc"
    + "&code_param= " 
    + "&all_flag=All"
    + "&" + FormQueryString(formObj);	// R/Lane

	var xmlStr2 = sheetObjects[0].GetSearchXml("CommonGS.do", param2);
	ComXml2ComboItem(xmlStr2, formObj.f_pod_cd, "code", "name");
	formObj.f_pod_cd.Index = 0;
	
	//P/F Group 
 	var rlaneCd = formObj.f_rlane_cd.Code;
 	var param = "f_cmd=" + SEARCH01
     + "&code_name=pfGroupOfc"
     + "&code_param="+rlaneCd
     + "&all_flag=";

 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
 	ComXml2ComboItem(xmlStr, formObj.f_pf_grp_cd, "code", "name");
 	formObj.f_pf_grp_cd.InsertItem(0, "All", "");
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
}

/**
 *  선택된 RHQ 에 해당하는 Office 정보 가져와서 ComboBox 셋팅
 */
function f_rhq_cd_OnChange(obj, value, text) {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	
	if (value != "All") {
		var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=officeForPlan&code_param=" + value + "&all_flag=All");
		var arrXml = sXml.split("|$$|");
	
		if (arrXml.length > 0) {
			ComXml2ComboItem(arrXml[0], formObj.f_rgn_ofc_cd, "code", "name");
			formObj.f_rgn_ofc_cd.Index = 0;
		}
	} else {
		formObj.f_rgn_ofc_cd.RemoveAll();
		formObj.f_rgn_ofc_cd.Index = 0;
	}
}

/**
 * 화면의 모든 버튼들의 Enable/Disable을 처리
 */
function toggleButtons(step) {
   switch (step) {
	   case "INIT":
	       ComBtnEnable("btn_Retrieve");
	       ComBtnDisable("btn_Save");
	       ComBtnDisable("btn_Creation");
	       ComBtnDisable("btn_AddCreation");
	       ComBtnDisable("btn_PairAdd");
	       ComBtnDisable("btn_Downexcel");
	       ComBtnDisable("btn_Loadexcel");
	       ComBtnDisable("btn_RawDataDownExcel");
	       break;
	   case "SEARCH01": // dataCnt 가 0일 때
	       ComBtnEnable("btn_Retrieve");
	       ComBtnDisable("btn_Save");
	       ComBtnEnable("btn_Creation");
	       ComBtnDisable("btn_AddCreation");
	       ComBtnDisable("btn_PairAdd");
	       ComBtnDisable("btn_Downexcel");
	       ComBtnDisable("btn_Loadexcel");
	       ComBtnDisable("btn_RawDataDownExcel");
	       break;
	   case "SEARCH02": // dataCnt 가 0이 아닐 때
	       ComBtnEnable("btn_Retrieve");
	       ComBtnEnable("btn_Save");
	       ComBtnDisable("btn_Creation");
	       ComBtnEnable("btn_AddCreation");
	       ComBtnEnable("btn_PairAdd");
	       ComBtnEnable("btn_Downexcel");
	       ComBtnEnable("btn_Loadexcel");
	       ComBtnEnable("btn_RawDataDownExcel");
	       break;
   }
}

function sheet1_OnChange(sheetObj, row, col){
	switch(sheetObj.ColSaveName(col)){
		case "sqm_act_flg":
			if (sheetObj.CellValue(row,"sqm_act_flg") == false) {  // 체크가 되어 있던 것이 체크가 풀렸을 경우
				
				var param = "f_cmd="         + SEARCH03
		          + "&bse_yr="  + sheetObj.CellValue(row,"bse_yr")
		          + "&bse_qtr_cd="     + sheetObj.CellValue(row,"bse_qtr_cd")
		          + "&ofc_vw_cd=" + sheetObj.CellValue(row,"ofc_vw_cd")
		          + "&rlane_cd="  + sheetObj.CellValue(row,"rlane_cd")
		          + "&dir_cd="  + sheetObj.CellValue(row,"dir_cd")
		          + "&rhq_cd="  + sheetObj.CellValue(row,"rhq_cd")
		          + "&rgn_ofc_cd="  + sheetObj.CellValue(row,"rgn_ofc_cd")
		          + "&pol_cd="  + sheetObj.CellValue(row,"pol_cd")
		          + "&pod_cd="  + sheetObj.CellValue(row,"pod_cd");
				
				var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0204GS.do",param);
				var arrXml = rtnXml.split("|$$|");
				var etcData = getEtcData(arrXml[0]);
				document.form.dataCnt.value = etcData["dataCnt"];
				
				if(document.form.dataCnt.value != 0){
					ComShowCodeMessage('SQM00062');
					sheetObj.CellValue(row,"sqm_act_flg") = true;
				}
				
			} 
			break;
	}
}

/* 개발자 작업  끝 *
 */