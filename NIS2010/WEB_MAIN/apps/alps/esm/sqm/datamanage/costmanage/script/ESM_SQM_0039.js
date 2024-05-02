/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0039.js
*@FileTitle      : New Office Creation
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.08
*@LastModifier   : JEONGMIN CHO
*@LastVersion    : 1.0
* 2013.05.08 JEONGMIN CHO
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends 
 * @class ESM_SQM_0039 : ESM_SQM_0039 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0039() {
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
	var formObject  = document.form;
	var opener_form;
	var opener_sheet_obj1;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
		case "f_bse_tp_cd":
			f_bse_tp_cd_OnChange();
			break;
		case "btn_Creation":
			doActionIBSheet(sheetObject, formObject, COMMAND01);
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
	var formObject  = document.form;
	loadingMode = true;

	doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}
	
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	loadingMode = false;
}

function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	
	switch(sheetNo) {
		case 1:		//sheet1 init
			with (sheetObj) {
				style.height = GetSheetHeight(10) ;
				
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll; 
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);
				
				var HeadTitle1 =  "|bse_tp_cd|bse_yr|bse_qtr_cd";

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);
				
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, false, true, false, false);
				
				//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				
				//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtSeq,		30,	daCenter,	true,	"seq",		  false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		90,	daCenter,	true,	"bse_tp_cd",  false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		90,	daCenter,	true,	"bse_yr",  false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		90,	daCenter,	false,	"bse_qtr_cd", false,	"",	dfNone,	0,	false,	false);				
				


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
		
	case IBCLEAR:          //조회
		sheetObj.WaitImageVisible = false;		
		formObj.f_cmd.value = INIT;
		
		var sXml   = sheetObj.GetSearchXml("ESM_SQM_0039GS.do", FormQueryString(formObj));
		var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
		var arrXml = sXml.split("|$$|");

		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.f_bse_yr, "code", "name");
		if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], formObj.f_bse_qtr_cd, "code", "name");
		if (arrXml.length > 2)
			ComSetYearQta(arrXml[2]);

		break;
		
	case COMMAND01:          //  Creation
	
		
		if (ComShowConfirm (ComGetMsg("SQM00009")) != 1) {
			return false;
		}
		ComOpenWait(true);
		formObj.f_cmd.value = COMMAND01;
		opener_sheet = opener.document.sheet1;
		var sParam 	= opener_sheet.GetSaveString(false, true, "sel");
		var sXml = sheetObjects[0].GetSaveXml("ESM_SQM_0039GS.do",FormQueryString(formObj) + "&" +sParam);
		var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
		
		ComOpenWait(false);
		if(State != "S"){
			ComShowMessage(ComResultMessage(sXml));
			return false;
		}else if(State == "S"){
			ComShowCodeMessage('SQM00010','Data');
			window.close();
		}
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
	
	period_change();
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