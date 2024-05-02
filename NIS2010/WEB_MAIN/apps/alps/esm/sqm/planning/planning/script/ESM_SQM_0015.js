/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0015.js
*@FileTitle      : RBC Lane QTA Setting
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.31
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.31 SQM USER
* 1.0 Creation
* 2013.11.11 박은주 [CHM-201327449] SQM 몇몇 화면 내 틀 고정 기능 추가
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends 
 * @class ESM_SQM_0015 : ESM_SQM_0015 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0015() {
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
			case "btn_DownExcel":
				doActionIBSheet(sheetObject, formObj,IBDOWNEXCEL);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject, formObj, IBSAVE);
				break;
			case "btn_Creation":

				doActionIBSheet(sheetObject, formObj, COMMAND01);
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
	toggleButtons("INIT");
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
				MergeSheet = msHeaderOnly;
				
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 9, 100);
				
				var HeadTitle  =  "Del|STS|SEQ|Year|Quarter|Office View|Trade|Sub Trade|R/Lane|Trade\nBound|RHQ|Office|RBC Lane Past PFMC (Per week)|RBC Lane Past PFMC (Per week)|RBC Lane Past PFMC (Per week)|RBC Lane Past PFMC (Per week)|Revised Weekly RBC Lane QTA|Revised Weekly RBC Lane QTA|Revised Weekly RBC Lane QTA|Revised Weekly RBC Lane QTA";
				var HeadTitle2 =  "Del|STS|SEQ|Year|Quarter|Office View|Trade|Sub Trade|R/Lane|Trade\nBound|RHQ|Office|Load|REV|CM(PA)|CM(RA)|Load|REV|CM(PA)|CM(RA)";

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle), 12, 0, true);
				
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, false, true, false, false);
				
				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle,	true);
				InitHeadRow(1, HeadTitle2,	true);
				
				// 전체 높이 설정
				style.height = GetSheetHeight(19);
				
				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtDelCheck,		40,	daCenter,	true,	"del",				false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtStatus,		30,	daCenter,	true,	"ibflag",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtSeq,			30,	daCenter,	true,	"seq",				false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			55,	daCenter,	true,	"bse_yr",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			55,	daCenter,	true,	"bse_qtr_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	daCenter,	true,	"ofc_vw_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,	daCenter,	true,	"trd_cd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			65,	daCenter,	true,	"sub_trd_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			65,	daCenter,	true,	"rlane_cd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			55,	daCenter,	true,	"dir_cd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			65,	daCenter,	true,	"rhq_cd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			65,	daCenter,	true,	"rgn_ofc_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		80,	daRight,	true,	"gid_lod_qty",		false,	"",	dfInteger,	0,	false,	false,	10);
				InitDataProperty(0,	cnt++,	dtAutoSum,		80,	daRight,	true,	"gid_grs_rev",		false,	"",	dfInteger,	0,	false,	false,	10);
				InitDataProperty(0,	cnt++,	dtAutoSum,		80,	daRight,	true,	"gid_pa_cm_amt",	false,	"",	dfInteger,	0,	false,	false,	10);
				InitDataProperty(0,	cnt++,	dtAutoSum,		80,	daRight,	true,	"gid_ra_cm_amt",	false,	"",	dfInteger,	0,	false,	false,	10);
				InitDataProperty(0,	cnt++,	dtAutoSum,		80,	daRight,	true,	"lod_qty",			true,	"",	dfInteger,	0,	true,	false,	10);
				InitDataProperty(0,	cnt++,	dtAutoSum,		80,	daRight,	true,	"grs_rev",			true,	"",	dfInteger,	0,	true,	false,	10);
				InitDataProperty(0,	cnt++,	dtAutoSum,		80,	daRight,	true,	"pa_cm_amt",		true,	"",	dfInteger,	0,	true,	false,	10);
				InitDataProperty(0,	cnt++,	dtAutoSum,		80,	daRight,	true,	"ra_cm_amt",		true,	"",	dfInteger,	0,	true,	false,	10);




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
  *  선택된 RHQ 에 해당하는 Office 정보 가져와서 ComboBox 셋팅
  */
 function f_rhq_cd_OnChange(obj, value, text) {
 	var formObj  = document.form;
 	var sheetObj = sheetObjects[0];
 	
 	if (value != "All") {
 		var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=office&code_param=" + value + "&all_flag=All");
 		var arrXml = sXml.split("|$$|");
 		
 		if (arrXml.length > 0) {
 			ComXml2ComboItem(arrXml[0], formObj.f_rgn_ofc_cd, "code", "name");
 			formObj.f_rgn_ofc_cd.Index = 0;
 		}
 		
 	} else {
 		formObj.f_rgn_ofc_cd.RemoveAll();
 		formObj.f_rgn_ofc_cd.InsertItem(0, "All", "All");
 		formObj.f_rgn_ofc_cd.Index = 0;
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
			
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0015GS.do", FormQueryString(formObj));
			var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
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
				ComXml2ComboItem(arrXml[5], formObj.f_rgn_ofc_cd, "code", "name");
			
			ComOpenWait(false);
			break;
		
		case IBSEARCH:          // 화면 조회
			ComOpenWait(true);
			
			formObj.f_cmd.value = SEARCH;
			
			searchParams = FormQueryString(formObj);			
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0015GS.do", searchParams);
			
			sheetObj.LoadSearchXml(rtnXml);
			
			var etcData = getEtcData(rtnXml);
			
			if (etcData["dataCnt"] == 0) {
				toggleButtons("COPY");
			} else {
				toggleButtons("SEARCH");
			}
			sheetObj.SumText(0, "ibflag") = "";
	        sheetObj.SumText(0, "bse_yr") = "Total";
			ComOpenWait(false);
			break;
	
	case IBSAVE:			// 저장
		if (!validateForm(sheetObj, formObj, sAction)) return false;
		
		if (sheetObj.isDataModified == false) {
			ComShowCodeMessage("SQM00006");
	        return false;
	    } else if (ComShowConfirm (ComGetMsg("SQM00004")) != 1) {
			return false;
	    }
		
		ComOpenWait(true);
		
		ComSetSearchParams("f_cmd", MULTI);
        
		sheetObj.DoSave("ESM_SQM_0015GS.do", searchParams, -1, false);
		
		ComOpenWait(false);
		
		var State = sheetObj.EtcData("TRANS_RESULT_KEY");
		
		if (State == "S") {
			ComShowCodeMessage('SQM00001','Data');
		}
		break;
		
	case COMMAND01:			// Creation

		if (ComShowConfirm (ComGetMsg("SQM00009")) != 1) {
			return false;
	    }
		
		ComOpenWait(true);
		
		ComSetSearchParams("f_cmd", MULTI01);

		var sXml = sheetObj.GetSaveXml("ESM_SQM_0015GS.do", searchParams);
		
		ComOpenWait(false);
		
		var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
		
		if (State == "S") {
			ComShowCodeMessage("SQM00010", "Data");
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		} else if (State != "S") {
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
	
	if (bse_tp_cd == "Y") {
		formObj.f_bse_qtr_cd.Enable = false;
		sheetObjects[0].ColHidden("bse_qtr_cd") = true;
	} else {
		formObj.f_bse_qtr_cd.Enable = true;
		sheetObjects[0].ColHidden("bse_qtr_cd") = false;
	}
	
	period_change();
	toggleButtons("INIT");
}
 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj, formObj, sAction){
 	
 	switch(sAction) {

 		case IBSAVE:  // save시 
 			var upRow = sheetObj.FindStatusRow("U");
 			var uRow = upRow.split(";");
 			var sMsg = "";
 			for(var i=0;i<uRow.length-1;i++){ 
 				if(sheetObj.CellValue(uRow[i],"lod_qty")!="0" && sheetObj.CellValue(uRow[i],"grs_rev")=="0"){
 					sMsg = sMsg + "\n" + sheetObj.CellValue(uRow[i],"rhq_cd") 
 							+ "-" + sheetObj.CellValue(uRow[i],"rgn_ofc_cd");

 				}
 			}
 			if(sMsg!=""){
				ComShowCodeMessage("SQM00042","RHQ-Office",sMsg);
				return false;	
 			}

 			break;
 	}

 	return true;
 }
 
/**
* 화면의 모든 버튼들의 Enable/Disable 을 처리
*/
function toggleButtons(step) {
	switch (step) {
		case "INIT":
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_DownExcel");
			ComBtnDisable("btn_Creation");
			break;
		
		case "COPY":
			// 조회한 Year, Quarter 에 해당하는 Data 의 Count 가 0 일 경우 
			ComBtnEnable("btn_Creation");
			break;
		
		case "SEARCH":
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_DownExcel");
			ComBtnDisable("btn_Creation");
			break;
	}
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
/* 개발자 작업  끝 */