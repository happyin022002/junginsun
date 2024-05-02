/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0001.js
*@FileTitle      : Basic Data Relation Setting
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.03
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.03 SQM USER
* 1.0 Creation
* 2014.01.16 IAS Sector Sales 판매시스템 개발
* 2015.12.07 Baisc Data Relation Setting IAS Trade 추가 로직 수정
* 2016.04.08 컬럼의 Lane Bound 헤더를 Trade Bound로 변경 (DB컬럼에 Trade Bound가 매핑되므로)
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_SQM_0001 : ESM_SQM_0001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0001() {
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
			case "btn_Save":
				doActionIBSheet(sheetObj, formObj, IBSAVE);
				break;
			case "btn_PreQTACopy":
				doActionIBSheet(sheetObj, formObj, "IBCOPY");
				break;
			case "btn_DownExcel":
				doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
				break;
			case "btn_RowAdd":
				doActionIBSheet(sheetObj, formObj, IBINSERT);
				break;
		}
	} catch(e) {
		if ( e == "[object Error]") {
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

function initSheet(sheetObj, sheetNo) {
	var cnt = 0;

	switch(sheetNo) {
		case 1:		//sheet1 init
			with (sheetObj) {
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				// Host 정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				var bse_tp_cd = ComGetObjValue(document.form.f_bse_tp_cd[0]);

				var HeadTitle = "DEL|STS|SEQ|Year|Quarter|Office View|Trade|Trade Bound|R.Lane|RHQ|HO teams|N.OB/OB";

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle) + 1, 0, 0, true);

				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, true, true, false, false);

				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, false);

				// 전체 높이 설정
				style.height = GetSheetHeight(18);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtDelCheck,		45,		daCenter,	true,	"",				false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtStatus,		30,		daCenter,	true,	"ibflag",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtSeq,			40,		daCenter,	true,	"seq",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,		daCenter,	true,	"bse_yr",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	true,	"bse_qtr_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtComboEdit,	90,		daCenter,	true,	"ofc_vw_cd",	true,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtComboEdit,	60,		daCenter,	true,	"trd_cd",		true,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtComboEdit,	100,	daCenter,	true,	"conv_dir_cd",	true,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtComboEdit,	70,		daCenter,	true,	"rlane_cd",		true,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtComboEdit,	60,		daCenter,	true,	"rhq_cd",		true,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,		daCenter,	true,	"team_cd",		true,	"",	dfNone,	0,	false,	false,	6);
				InitDataProperty(0,	cnt++,	dtComboEdit,	80,		daCenter,	true,	"ob_div_cd",	true,	"",	dfNone,	0,	false,	false);

				InitDataValid(0, "team_cd", vtEngUpOnly);
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

			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0001GS.do", FormQueryString(formObj));
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
				ComXml2ComboItem(arrXml[4], formObj.f_trd_cd, "code", "name");
			if (arrXml.length > 5)
				ComXml2ComboItem(arrXml[5], formObj.f_dir_cd, "code", "name");
			if (arrXml.length > 6)
				ComXml2ComboItem(arrXml[6], formObj.f_ho_team_cd, "code", "name");
			if (arrXml.length > 7)
				ComXml2ComboItem(arrXml[7], formObj.f_rhq_cd, "code", "name");
			if (arrXml.length > 8)
				ComXml2ComboItem(arrXml[8], formObj.f_ob_div_cd, "code", "name");

			// Row Add 세팅
			if (arrXml.length > 3)
				ComSqmSetIBCombo(sheetObj, arrXml[3], "ofc_vw_cd");
			if (arrXml.length > 9)
				ComSqmSetIBCombo(sheetObj, arrXml[9].replace("<TR><![CDATA[☜☞☜☞All☜☞All☜☞]]></TR>", ""), "trd_cd", true); // mdm trade 조회 쿼리 태운 후 All만 제거함
			if (arrXml.length > 10)
				ComSqmSetIBCombo(sheetObj, arrXml[10], "conv_dir_cd", true);
			if (arrXml.length > 11)
				ComSqmSetIBCombo(sheetObj, arrXml[11], "rhq_cd", true);
			if (arrXml.length > 12)
				ComSqmSetIBCombo(sheetObj, arrXml[12], "ob_div_cd", true);

			ComOpenWait(false);
			break;

		case IBSEARCH:          // 화면 조회
			ComOpenWait(true);

			formObj.f_cmd.value = SEARCH;

			toggleButtons("INIT");

			searchParams = FormQueryString(formObj);

			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0001GS.do", searchParams);

			sheetObj.LoadSearchXml(rtnXml);

			if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
				sheetObj.ColHidden("bse_qtr_cd") = true;
			} else {
				sheetObj.ColHidden("bse_qtr_cd") = false;
			}

			var etcData = getEtcData(rtnXml);

			if (etcData["dataCnt"] == 0) {
				toggleButtons("COPY");
			} else {
				toggleButtons("SEARCH");
			}

			ComOpenWait(false);
			break;

		case IBSAVE:			// 저장
			if (!validateForm(sheetObj, formObj, sAction)) {
				return false;
			}

			var saveStr = sheetObj.GetSaveString(false, true, "ibflag");

			if ( saveStr == "" ) {
				return;
			}

			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006");
		        return false;
		    } else if (ComShowConfirm (ComGetMsg("SQM00004")) != 1) {
				return false;
		    }

			ComSetSearchParams("f_cmd", MULTI);

			ComOpenWait(true);

			var sXml = sheetObj.GetSaveXml("ESM_SQM_0001GS.do", searchParams + "&" + saveStr);

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

		case "IBCOPY":			// 최근 이전 분기의 데이터를 복사
			if (!validateForm(sheetObj, formObj, sAction)) {
				return false;
			}

			if (ComShowConfirm (ComGetMsg("SQM00005")) != 1) {
				return false;
		    }

			ComOpenWait(true);

			ComSetSearchParams("f_cmd", MULTI01);

			var sXml = sheetObj.GetSaveXml("ESM_SQM_0001GS.do", searchParams);

			ComOpenWait(false);

			var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);

			if ( State == "S" ) {
				ComShowCodeMessage("SQM00003", "Data");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			} else if ( State != "S" ) {
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}
			break;

		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.Down2Excel(-1, false, false, true);
			ComOpenWait(false);
			break;

		case IBINSERT:          // Row Add
			var row = sheetObj.DataInsert();

			sheetObj.CellEditable(row, "trd_cd")      = true;
			sheetObj.CellEditable(row, "rlane_cd")    = true;
			sheetObj.CellEditable(row, "conv_dir_cd") = true;
			sheetObj.CellEditable(row, "rhq_cd")      = true;
			sheetObj.CellEditable(row, "team_cd")     = true;
			sheetObj.CellEditable(row, "ob_div_cd")   = true;

			sheetObj.CellValue2(row, "bse_yr")    = ComGetObjValue(formObj.f_bse_yr);
			if (ComGetObjValue(formObj.f_bse_tp_cd[0]) == "Q") sheetObj.CellValue2(row, "bse_qtr_cd") = ComGetObjValue(formObj.f_bse_qtr_cd);
			sheetObj.CellValue2(row, "ofc_vw_cd") = ComGetObjValue(formObj.f_ofc_vw_cd);
			break;
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
		case "conv_dir_cd":
		case "rlane_cd":
		case "rhq_cd":
		case "ob_div_cd":
			var text = getSheetComboCode(sheetObj, row, col);
			sheetObj.CellValue2(row, col) = text;
			break;

		case "trd_cd":
			var text = getSheetComboCode(sheetObj, row, col);
    		sheetObj.CellValue2(row, col) = text;

			if (text != "") {
				var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=rLane&code_param=" + text + "&all_flag=All");

				ComSqmSetIBCombo(sheetObj, sXml, "rlane_cd", true, 0, row);
			} else {
				sheetObj.CellComboItem(row, "rlane_cd", "", "");
			}
			break;
	}
}

/**
 *  선택된 Trade 에 해당하는 R.Lane 정보 가져와서 Combo Box 셋팅
 */
function f_trd_cd_OnChange(obj, value, text){
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	var rlane_cd     = ComGetObjValue(formObj.f_rlane_cd);

	if (value != "All") {
		var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=rLane&code_param=" + value + "&all_flag=All");
		ComXml2ComboItem(sXml, formObj.f_rlane_cd, "code", "name");
		formObj.f_rlane_cd.Index = 0;
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

		case IBSAVE:
			var sList   = sheetObj.FindStatusRow("I");
			var sArr    = sList.split(";");
			var team_cd = "";

			for (var i = 0; i < sArr.length - 1; i++) {
				team_cd = sheetObj.CellValue(sArr[i], "team_cd");

				if (team_cd.substr(0, 3) != 'SEL' || team_cd.length != 6) {
					ComShowMessage(ComGetMsg("SQM00002"));
					sheetObj.SelectCell(sArr[i], "team_cd");
					return false;
				}
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
			ComBtnDisable("btn_PreQTACopy");
			ComBtnDisable("btn_DownExcel");
			ComBtnDisable("btn_RowAdd");
			break;

		case "COPY":
			// 조회한 Year, Quarter 에 해당하는 Data 의 Count 가 0 일 경우
			ComBtnEnable("btn_PreQTACopy");
			break;

		case "SEARCH":
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_DownExcel");
			ComBtnEnable("btn_RowAdd");
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