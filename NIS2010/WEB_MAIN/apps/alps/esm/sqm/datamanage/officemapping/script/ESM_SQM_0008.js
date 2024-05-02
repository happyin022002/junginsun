/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0008.js
*@FileTitle      : Lane-Office Relation Setting
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.20
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.20 SQM USER
* 1.0 Creation
* 2014.01.16 박은주 [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2014.08.25 이혜민 [CHM-201431601] 팝업 오픈시 부모창 조회조건을 자동세팅하도록 수정
* 2015.08.10 김용습 [CHM-201536994] Split24-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
* 2016.01.13 [CHM-201539389] Lane Office Inactive 불가하도록 비활성화 로직 변경
* 2016.07.04 SQM 화면 버튼 추가 요청
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_SQM_0008 : ESM_SQM_0008 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0008() {
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

var buttonAction = ""; //Loading View Check Copy 버튼 활성화 처리

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
			case "btn_Create":
				doActionIBSheet(sheetObj, formObj, IBCREATE);
				break;
			case "btn_DownExcel":
				doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
				break;
			case "btn_NewLaneAdd":
				doActionIBSheet(sheetObj, formObj, "NewLaneAdd");
				break;
			case "btn_LoadViewCheckCopy":
				doActionIBSheet(sheetObj, formObj, "LoadViewCheckCopy");
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

	toggleButtons("INIT");
	//팝업으로 열렸을때 부모창 조건 세팅
    if(formObj.popMode.value == "Y"){
    	ComSetObjValue(formObj.f_bse_yr, formObj.p_bse_yr.value);
    	ComSetObjValue(formObj.f_bse_qtr_cd, formObj.p_bse_qtr_cd.value);
    	ComSetObjValue(formObj.f_ofc_vw_cd, formObj.p_ofc_vw_cd.value);
    	ComSetObjValue(formObj.f_trd_cd, "IAS");
		ComSetObjValue(formObj.f_sub_trd_cd, formObj.p_sub_trd_cd.value);
		ComSetObjValue(formObj.f_dir_cd, formObj.p_dir_cd.value);
		ComSetObjValue(formObj.f_rlane_cd, formObj.p_rlane_cd.value);
	}
	loadingMode = false;
}

function initSheet(sheetObj,sheetNo) {
	var cnt = 0;

	switch(sheetNo) {
		case 1:		// sheet1 init
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

				var HeadTitle = "STS|SEQ|Year|Quarter|Office View|Trade|Sub Trade|R.Lane|Lane Bound|RHQ|Office|Active|Add Flg|Modi Flg";

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle) + 1, 0, 0, true);

				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, false, true, false, false);

				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, false);

				// 전체 높이 설정
				style.height = GetSheetHeight(18);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtStatus,		30,	daCenter,	true,	"ibflag",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtSeq,			30,	daCenter,	true,	"seq",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			40,	daCenter,	true,	"bse_yr",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			55,	daCenter,	true,	"bse_qtr_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCombo,		80,	daCenter,	true,	"ofc_vw_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,	daCenter,	true,	"trd_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			75,	daCenter,	true,	"sub_trd_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,	daCenter,	true,	"rlane_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			90,	daCenter,	true,	"dir_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,	daCenter,	true,	"rhq_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,	daCenter,	true,	"rgn_ofc_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCheckBox,		60,	daCenter,	true,	"sqm_act_flg",	false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		80,	daCenter,	true,	"add_flg",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		80,	daCenter,	true,	"modi_flg",		false,	"",	dfNone,	0,	false,	false);

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

			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0008GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");

			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 2)
				ComSetYearQta(arrXml[2]);
			if (arrXml.length > 3){
				ComXml2ComboItem(arrXml[3], formObj.f_ofc_vw_cd, "code", "name");
				ComSqmSetIBCombo(sheetObj, arrXml[3], "ofc_vw_cd");
			}
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], formObj.f_trd_cd, "code", "name");
			if (arrXml.length > 5)
				ComXml2ComboItem(arrXml[5], formObj.f_sub_trd_cd, "code", "name");
			if (arrXml.length > 6)
				ComXml2ComboItem(arrXml[6], formObj.f_dir_cd, "code", "name");
			if (arrXml.length > 7)
				ComXml2ComboItem(arrXml[7], formObj.f_rhq_cd, "code", "name");

			ComOpenWait(false);
			break;

		case IBSEARCH:          // 화면 조회 시
			ComOpenWait(true);

			formObj.f_cmd.value = SEARCH;

			toggleButtons("INIT");

			searchParams = FormQueryString(formObj);

			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0008GS.do", searchParams);

			sheetObj.LoadSearchXml(rtnXml);

			if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
				sheetObj.ColHidden("bse_qtr_cd") = true;
			} else {
				sheetObj.ColHidden("bse_qtr_cd") = false;
			}

			var etcData = getEtcData(rtnXml);

			if (etcData["dataCnt"] == 0) {
				toggleButtons("CREATE");
			} else {
				toggleButtons("SEARCH");
			}
			
			if (etcData["CFM_FLG"] == 0) {				
				if(document.getElementById("f_trd_cd").Code != "All" && document.getElementById("f_trd_cd").Code != "") {
					ComBtnEnable("btn_LoadViewCheckCopy");
				} else {
					ComBtnDisable("btn_LoadViewCheckCopy");
				}
			} else {
				ComBtnDisable("btn_LoadViewCheckCopy");
			}

			ComOpenWait(false);
			break;
			
		case "LoadViewCheckCopy":          // 화면 조회 시
			ComOpenWait(true);

			if (ComShowConfirm ("Do you want to check?") != 1) {
				ComOpenWait(false);
				return false;
		    } 
			
			buttonAction = "LoadViewCheckCopy";
 
			formObj.f_cmd.value = SEARCH03;

			searchParams = FormQueryString(formObj);
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0008GS.do", searchParams);
			sheetObj.LoadSearchXml(rtnXml);

			if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
				sheetObj.ColHidden("bse_qtr_cd") = true;
			} else {
				sheetObj.ColHidden("bse_qtr_cd") = false;
			}

			ComOpenWait(false);
			break;


		case IBSAVE:			// 저장
			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006");
		        return false;
		    } else if (ComShowConfirm (ComGetMsg("SQM00004")) != 1) {
				return false;
		    }

			ComOpenWait(true);

			ComSetSearchParams("f_cmd", MULTI);

			sheetObj.DoSave("ESM_SQM_0008GS.do", searchParams, -1, false);

			ComOpenWait(false);

			var State = sheetObj.EtcData("TRANS_RESULT_KEY");

			if (State == "S") {
				ComShowCodeMessage("SQM00001", "Data");
			}
			break;

		case IBCREATE:          // Data 생성
			if (ComShowConfirm (ComGetMsg("SQM00009")) != 1) {
				return false;
		    }

			ComOpenWait(true);

			ComSetSearchParams("f_cmd", MULTI01);

			var sXml = sheetObj.GetSaveXml("ESM_SQM_0008GS.do", searchParams);

			ComOpenWait(false);

			var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);

			if (State == "S") {
				ComShowCodeMessage("SQM00001", "Data");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			} else if (State != "S") {
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}
			break;

		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.Down2Excel(-1, false, false, true);
			ComOpenWait(false);
			break;

		case "NewLaneAdd":
			ComSetSearchParams("f_cmd", "");

			var text = ComGetObjText(document.form.f_ofc_vw_cd);

			var rtn = window.showModalDialog("ESM_SQM_0009.do?" + searchParams + "&f_text=" + text, window, "dialogHeight:475px;dialogWidth:700px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");

			break;
    }
}

/**
 * 화면의 모든 버튼들의 Enable/Disable 을 처리
 */
function toggleButtons(step) {
	var formObj = document.form;
	switch (step) {
		case "INIT":
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Create");
			ComBtnDisable("btn_DownExcel");
			ComBtnDisable("btn_NewLaneAdd");
			ComBtnDisable("btn_LoadViewCheckCopy");
			break;

		case "CREATE":
			if(formObj.strOfc_cd.value == "SELCSG"){
				ComBtnEnable("btn_Create");
			}
			ComBtnEnable("btn_NewLaneAdd");
			break;

		case "SEARCH":
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_DownExcel");
			ComBtnEnable("btn_NewLaneAdd");
			break;
	}
}

/**
 *  선택된 Trade 에 해당하는 Sub Trade, R/Lane 정보 가져와서 ComboBox 셋팅
 */
function f_trd_cd_OnChange(obj, value, text) {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];

	if (value != "All") {
		var code_name  = new Array("subTrade", "rLane");
		var code_param = new Array(value, value);
		var all_flag   = new Array("All", "All");

		var param = "f_cmd="		+ SEARCH01
		          + "&code_name="	+ code_name
		          + "&code_param="	+ code_param
		          + "&all_flag="	+ all_flag;

		var sXml   = sheetObj.GetSearchXml("CommonGS.do", param);
		var arrXml = sXml.split("|$$|");

		if (arrXml.length > 0) {
			ComXml2ComboItem(arrXml[0], formObj.f_sub_trd_cd, "code", "name");
			formObj.f_sub_trd_cd.Index = 0;
		}
		if (arrXml.length > 1) {
			ComXml2ComboItem(arrXml[1], formObj.f_rlane_cd, "code", "name");
			formObj.f_rlane_cd.Index = 0;
		}

	} else {
		var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=subTrade&code_param=" + value + "&all_flag=All");

		ComXml2ComboItem(sXml, formObj.f_sub_trd_cd, "code", "name");
		formObj.f_sub_trd_cd.Index = 0;

		formObj.f_rlane_cd.RemoveAll();
		formObj.f_rlane_cd.InsertItem(0, "All", "All");
		formObj.f_rlane_cd.Index = 0;
		
	}
}

/**
 *  선택된 Sub Trade 에 해당하는 R/Lane 정보 가져와서 ComboBox 셋팅
 */
function f_sub_trd_cd_OnChange(obj, value, text) {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];

	if (value != "All") {
		var param = "f_cmd="		   + SEARCH01
		          + "&code_name=rLane"
		          + "&code_param="     + ComGetObjValue(formObj.f_trd_cd) + "|" + value
		          + "&all_flag=All";

		var sXml   = sheetObj.GetSearchXml("CommonGS.do", param);
		var arrXml = sXml.split("|$$|");

		if (arrXml.length > 0) {
			ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "name");
			formObj.f_rlane_cd.Index = 0;
		}
	} else {
		formObj.f_rlane_cd.RemoveAll();
		formObj.f_rlane_cd.InsertItem(0, "All", "All");
		formObj.f_rlane_cd.Index = 0;
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
 *  Office View : Contract 선택시에만 버튼 보이기
 */
function f_ofc_vw_cd_OnChange(obj, value, text) {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	
	if(value == "C") {
		ComShowObject(td_LoadViewCheckCopy, true); 
	} else {
		ComShowObject(td_LoadViewCheckCopy, false); 
	}
}

/**
 *  Pop-up 창에서 선택한 New Lane Data 를 시트에 추가
 */
function newLaneAdd(rtnArr) {
	var sheetObj = sheetObjects[0];
	var row = sheetObj.DataInsert(-1);

	sheetObj.CellValue2(row, "bse_yr")      = ComGetSearchParams("f_bse_yr");
	sheetObj.CellValue2(row, "bse_qtr_cd")  = ComGetSearchParams("f_bse_qtr_cd");
	sheetObj.CellValue2(row, "ofc_vw_cd")   = ComGetSearchParams("f_ofc_vw_cd");
	sheetObj.CellValue2(row, "trd_cd")      = rtnArr[0];
	sheetObj.CellValue2(row, "sub_trd_cd")  = rtnArr[1];
	sheetObj.CellValue2(row, "dir_cd")      = rtnArr[2];
	sheetObj.CellValue2(row, "rlane_cd")    = rtnArr[3];
	sheetObj.CellValue2(row, "rhq_cd")      = rtnArr[4];
	sheetObj.CellValue2(row, "rgn_ofc_cd")  = rtnArr[5];
	sheetObj.CellValue2(row, "sqm_act_flg") = rtnArr[6];
	sheetObj.CellValue2(row, "add_flg")     = rtnArr[7];
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

function sheet1_OnChange(sheetObj, row, col){
	switch(sheetObj.ColSaveName(col)){
		case "sqm_act_flg":
			if (sheetObj.CellValue(row,"sqm_act_flg") == false) {  // 체크가 되어 있던 것이 체크가 풀렸을 경우
				
				var param = "f_cmd="         + SEARCH02
		          + "&bse_yr="  + sheetObj.CellValue(row,"bse_yr")
		          + "&bse_qtr_cd="     + sheetObj.CellValue(row,"bse_qtr_cd")
		          + "&ofc_vw_cd=" + sheetObj.CellValue(row,"ofc_vw_cd")
		          + "&rlane_cd="  + sheetObj.CellValue(row,"rlane_cd")
		          + "&dir_cd="  + sheetObj.CellValue(row,"dir_cd")
		          + "&rhq_cd="  + sheetObj.CellValue(row,"rhq_cd")
		          + "&rgn_ofc_cd="  + sheetObj.CellValue(row,"rgn_ofc_cd")
		          + "&trd_cd=" + sheetObj.CellValue(row,"trd_cd")
		          + "&sub_trd_cd=" + sheetObj.CellValue(row,"sub_trd_cd");
				
				var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0008GS.do",param);
				var arrXml = rtnXml.split("|$$|");
				var etcData = getEtcData(arrXml[0]);
				
				if(etcData["dataCnt"] != 0 || etcData["dataCnt"] == ""){
					ComShowCodeMessage('SQM00062');
					sheetObj.CellValue(row,"sqm_act_flg") = true;
				}
				
			} 
			break;
	}
}



/**
 *조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 * @param sheetObj
 * @param ErrMsg
 */
 function sheet1_OnSearchEnd(sheetObj, ErrMsg){

	 if(buttonAction == "LoadViewCheckCopy") {
		 for(var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
			 if(sheetObj.CellValue(i, "modi_flg") == "Y") {
				 sheetObj.RowStatus(i) = "U";
			 }
		 }
	 }
	 
	 buttonAction = "";		 
}
 
 
/* 개발자 작업  끝 */