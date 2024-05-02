/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0202.js
*@FileTitle      : POL-POD Management for IAS Sector
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.07
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.07 SQM USER
* 1.0 Creation
* History
* 2014.06.20 이혜민 [CHM-201430168] IAS Sector Sales - Main, Sector 구분자 추가를 위한 화면 변경
* 2014.07.16 이혜민 [CHM-201430933] Sector Sales에 POL-POD 생성 후 POL-POD Management 비활성화 로직 수정 요청
* 2014.08.01 이혜민 [CHM-201431325] POL-POD Management에서 Main/Sector 구분 체크 Pair Active 여부와 상관없이 활성화 
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends 
 * @class ESM_SQM_0202 : ESM_SQM_0202 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0202() {
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
				var sUrl = "ESM_SQM_0203.do?"+searchParams;
				var rtn = ComOpenWindowCenter(sUrl, "ESM_SQM_0203", 890, 400, true);
				//팝업 닫힌 후 재조회
				if(rtn == "OK") doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
			case "btn_Downexcel":
				doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
				break;
			case "btn_Loadexcel":
				doActionIBSheet(sheetObject, formObj, IBLOADEXCEL);
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
				MergeSheet = msAll;  //msNone; //msHeaderOnly //msPrevColumnMerge;
				
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);
				
				var HeadTitle1 =  "STS|SEQ|Trade|Sub Trade|IAS Region|R.Lane|Lane Bound|POL|POD|Active|sctr_ofc_cre_flg|Main";

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);
				
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, true, true, false, false);
				
				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
														
				// 전체 높이 설정
				style.height = GetSheetHeight(18);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtStatus,	30,	  	daCenter,	 false,	"ibflag",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtSeq,		70,	  	daCenter,  	 false,	"seq",				false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		80,	  	daCenter,	 true,	"trd_cd",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		80,  	daCenter,	 true,	"sub_trd_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		120,  	daCenter,	 false,	"ias_rgn_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,  	daCenter,	 false,	"rlane_cd",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		90,   	daCenter,	 false,	"dir_cd",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		110,  	daCenter,	 false,	"pol_cd",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		110,  	daCenter,	 false,	"pod_cd",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCheckBox,	80,  	daCenter,	 false,	"sqm_act_flg",		false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtHidden,	80,  	daCenter,	 false,	"sctr_ofc_cre_flg",	false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtCheckBox,	80,  	daCenter,	 false,	"sqm_mn_sctr_flg",	false,	"",	dfNone,	0,	false,	false);

			}
			break;
			
		case 2:		//sheet2 init
			with (sheetObj) {
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll;  //msNone; //msHeaderOnly //msPrevColumnMerge;
				
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);
				
				var HeadTitle1 =  "STS|SEQ|Trade|Sub Trade|IAS Region|R.Lane|Lane Bound|P/F SKD Group|POL|POL(Seq)|POD|POD(Seq)|Active|Main";

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);
				
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, false, true, false, false);
				
				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
														
				// 전체 높이 설정
				style.height = GetSheetHeight(15);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,	daCenter,	 false,	"ibflag",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtSeq,		50,	  	daCenter,  	 false,	"seq",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,	  	daCenter,	 true,	"trd_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		70,	  	daCenter,	 true,	"sub_trd_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,  	daCenter,	 false,	"ias_rgn_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		80,   	daCenter,	 false,	"rlane_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		90,   	daCenter,	 false,	"dir_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,  	daCenter,	 false,	"pf_grp_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		80,  	daCenter,	 false,	"pol_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		70,   	daCenter,	 false,	"pol_call_seq",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		80,   	daCenter,	 false,	"pod_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		70,   	daCenter,	 false,	"pod_call_seq",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCheckBox,	60,   	daCenter,	 false,	"sqm_act_flg",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCheckBox,	50,  	daCenter,	 false,	"sqm_mn_sctr_flg",	false,	"",	dfNone,	0,	false,	false);


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
		case "f_pf_grp_cd":
			with (comboObj) {
				SetTitle("R/Lane|Group"); 
				SetColAlign("center|center");
				SetColWidth("100|100");

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
			
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0202GS.do", FormQueryString(formObj));
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
			ComOpenWait(false);
			break;
		
			
		case IBSEARCH:          // 화면 조회 시
			//Tab1 조회 View Adapter가 달라서 서버를 2번 탐.
			formObj.f_cmd.value = SEARCH;
			searchParams = FormQueryString(formObj);
			ComOpenWait(true);
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0202GS2.do",searchParams);
			sheetObj.LoadSearchXml(rtnXml);
			var etcData = getEtcData(rtnXml);
			//Tab2 조회
			ComSetSearchParams("f_cmd", SEARCH01);
			var rtnXml1 = sheetObj.GetSearchXml("ESM_SQM_0202GS.do",searchParams);
			sheetObj1.LoadSearchXml(rtnXml1);
			
			formObj.dataCnt.value = etcData["dataCnt"];
			if (formObj.dataCnt.value == 0) {
				toggleButtons("SEARCH01");
			} else {
				toggleButtons("SEARCH02");
				//Main Flag가 All이거나 N 일때 Main Flag가 하나도 체크 안된 Lane/Bound 조회
				if(ComGetSearchParams("f_sqm_mn_sctr_flg") != "Y"){
					doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
				}
			}
			ComOpenWait(false);
			
			break;
			
		case SEARCH03:          // 화면 조회 후 Main flag가 하나도 체크되어 있지 않은 Lane, Bound 조회
			ComSetSearchParams("f_cmd", SEARCH03);
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("ESM_SQM_0202GS.do",searchParams);
			var nMainList = ComGetEtcData(sXml, "nMainList");
			if(nMainList != null && nMainList != ""){
				ComShowCodeMessage("SQM00049", nMainList.substr(1));
			}
			ComOpenWait(false);
			
			break;	
			
		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.MergeSheet = msNone;
			sheetObj.Down2Excel(-1, false, false, true);
			sheetObj.MergeSheet = msAll;
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
			sheetObj.DoSave("ESM_SQM_0202GS.do", searchParams, -1, false);
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
			if (ComShowConfirm (ComGetMsg("SQM00009")) != 1) {
				return false;
		    }
			
			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI01);
			var sXml = sheetObj.GetSaveXml("ESM_SQM_0202GS.do", searchParams);
			
			var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
			if (backendJobKey != null && backendJobKey.length > 0) {
				ComSetObjValue(formObj.backendjob_key, backendJobKey);
				sheetObj.RequestTimeOut = 3600; //초 - 1시간
				backEndJobTimer = setInterval(getBackEndJobStatus, 5000);	//밀리초  - 10초
			}
			break;
			
		case IBLOADEXCEL:		// 엑셀 업로드
			var dataCnt = formObj.dataCnt.value;
			ComOpenWait(true);
			if(dataCnt != "0"){
				loadExcelRowCnt    = sheetObj.HeaderRows + sheetObj.TotalRows;
				loadExcelTotFlg    = false;		// 화면에 Total Row 존재 여부
				loadExcelExField   = "|sqm_act_flg|sqm_mn_sctr_flg|sctr_ofc_cre_flg|";		// 비교 제외 필드
				loadExcelAplyField = "|sqm_act_flg|sqm_mn_sctr_flg|";		// 반영 필드
				loadExcelsectorFlg = "Y";
				
				var rtn = window.showModalDialog("ESM_SQM_1001.do?" + searchParams, window, "dialogHeight:620px;dialogWidth:1050px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");
				if(rtn == "S")
					ComShowCodeMessage("SQM00036");
			}
			ComOpenWait(false);
		break;	
  }
}

///**
// * Sheet1 값 변경시
// *
// * @param sheetObj
// * @param row
// * @param col
// * @param value
// */
//function sheet1_OnChange(sheetObj, row, col, value){
//	var formObj = document.form;
//	var sName   = sheetObj.ColSaveName(col);
//
//	switch(sName){
//		case "sqm_act_flg":
//			if(value == "1"){
//				sheetObjects[0].CellEditable(row, "sqm_mn_sctr_flg") = true;
//			}else{
//				sheetObjects[0].CellEditable(row, "sqm_mn_sctr_flg") = false;
//			}
//			
//		break;
//	}
//}

/**
* onChange event
* f_sub_trd_cd 바뀌었을때  f_lane_cd 콤보조회
*/	
function f_sub_trd_cd_OnChange(obj, value, text) {
 	var formObj = document.form;
 	if(formObj.f_sub_trd_cd.Text == "All" && formObj.f_ias_rgn_cd.Code == "All"){
 		formObj.f_rlane_cd.RemoveAll();
 	}else{
	 	var param = "f_cmd=" + SEARCH01
	     + "&code_name=rLane"
	     + "&code_param=IAS|"+formObj.f_sub_trd_cd.Code+"|"+formObj.f_ias_rgn_cd.Code
	     + "&all_flag=";
	
	 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, formObj.f_rlane_cd, "code", "name");		
	 	formObj.f_rlane_cd.MultiSelect = true;
 	}
 }

/**
* onChange event
* f_ias_rgn_cd 바뀌었을때  f_lane_cd 콤보조회
*/	
function f_ias_rgn_cd_OnChange(obj, value, text) {
 	var formObj = document.form;
 	if(formObj.f_sub_trd_cd.Text == "All" && formObj.f_ias_rgn_cd.Code == "All"){
 		formObj.f_rlane_cd.RemoveAll();
 	}else{
	 	var param = "f_cmd=" + SEARCH01
	     + "&code_name=rLane"
	     + "&code_param=IAS|"+formObj.f_sub_trd_cd.Code+"|"+formObj.f_ias_rgn_cd.Code
	     + "&all_flag=";
	
	 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, formObj.f_rlane_cd, "code", "name");		
		formObj.f_rlane_cd.MultiSelect = true;
 	}
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
* onBlur event
* f_rlane_cd 바뀌었을때  f_pf_grp_cd 콤보조회
*/	
function f_rlane_cd_OnBlur(obj, value, text) {
 	var formObj = document.form;
 	var rlaneCd = formObj.f_rlane_cd.Code;
 	rlaneCd = rlaneCd.replace(/,/gi,"-");
 	var param = "f_cmd=" + SEARCH01
     + "&code_name=pfGroupPair"
     + "&code_param="+rlaneCd
     + "&all_flag=";

 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
 	ComXml2ComboItem(xmlStr, formObj.f_pf_grp_cd, "code", "name");
 	formObj.f_pf_grp_cd.InsertItem(0, "All", "");
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
	       ComBtnDisable("btn_Downexcel");
	       ComBtnDisable("btn_Loadexcel");
	       break;
	   case "SEARCH01": //조회 후 Cnt가 0 일때 
	       ComBtnEnable("btn_Retrieve");
	       ComBtnDisable("btn_Save");
	       ComBtnEnable("btn_Creation");
	       ComBtnDisable("btn_AddCreation");
	       ComBtnDisable("btn_Downexcel");
	       ComBtnDisable("btn_Loadexcel");
	       break;
	   case "SEARCH02": //조회 후 Cnt가 0이 아닐때 
	       ComBtnEnable("btn_Retrieve");
	       ComBtnEnable("btn_Save");
	       ComBtnDisable("btn_Creation");
	       ComBtnEnable("btn_AddCreation");
	       ComBtnEnable("btn_Downexcel");
	       ComBtnEnable("btn_Loadexcel");
	       break;     
     
   }
}

/**
* BackEndJob 관련 Status='3' 이 될때까지 확인한다.<br>
*/     
function getBackEndJobStatus() {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	ComOpenWait(true);
	
	var sXml     = sheetObj.GetSearchXml("ESM_SQM_0202GS.do", "f_cmd=" + SEARCH02 + "&backendjob_key=" + formObj.backendjob_key.value);
	
	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
	var errMsg   = ComGetEtcData(sXml, "jb_usr_err_msg");
	if (jobState == "3") {
		ComShowCodeMessage("SQM00010", "Data");
		clearInterval(backEndJobTimer);
		ComOpenWait(false);
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
	} else if (jobState == "4") {
		ComShowCodeMessage("SQM00038", errMsg);
		ComOpenWait(false);
		clearInterval(backEndJobTimer);
	} else if (jobState == "5") {
		ComShowCodeMessage("SQM00039");
		ComOpenWait(false);
		clearInterval(backEndJobTimer);
	}
}
/* 개발자 작업  끝 */