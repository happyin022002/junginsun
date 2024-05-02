/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0011.js
*@FileTitle      : Basic CMCB (CM Cost Per Box)
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.03
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.03 SQM USER
* 1.0 Creation
* 2014.01.16 박은주 [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
* 2015.10.19 김용습 [CHM-201538305] Basic CMCB (CM Cost Per Box) / Basic CMCB for IAS Sector 화면 내 신규 칼럼 추가
* 2016.08.11 Basic CMCB (CM Cost Per Box) 화면 Add Creation 버튼 추가
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_SQM_0011 : ESM_SQM_0011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0011() {
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
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
			case "btn_Creation":
				doActionIBSheet(sheetObj,formObj,IBCREATE);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObj,formObj,IBSAVE);
				break;
			case "btn_DownExcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
				break;
			case "btn_LoadExcel":
				doActionIBSheet(sheetObj,formObj,IBLOADEXCEL);
				break;
			case "btn_NewLaneCostIF":
				doActionIBSheet(sheetObj,formObj,"NewLaneCostIF");
				break;
			case "btn_MasUcPfmc":
				doActionIBSheet(sheetObj,formObj,"MasUcPfmc");
				break;
            case "btn_AddCreation":
                doActionIBSheet(sheetObj,formObj,"AddCreation");
                break;	
            case "btn_CMCB_ExclEQ":
                doActionIBSheet(sheetObj,formObj,"CMCB_ExclEQ");
                break;
            case "btn_CMCB_InclEQ":
                doActionIBSheet(sheetObj,formObj,"CMCB_InclEQ");
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
	setTradeCombo();
	loadingMode = false;
}

var initSheetFn = function initSheet(sheetObj,sheetNo) {
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
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 14, 100);

				var HeadTitle1 =  "STS|SEQ|Year|Quarter|Office View|Trade|R.Lane|Lane\nBound|RHQ|Office|Initial CM cost UC|Initial CM cost UC|Initial CM cost UC|Initial CM cost UC|Initial CM cost UC|Initial CM cost UC|Revised CM Cost UC|Revised CM Cost UC|Revised CM Cost UC|Revised CM Cost UC|Revised CM Cost UC";
				var HeadTitle2 =  "STS|SEQ|Year|Quarter|Office View|Trade|R.Lane|Lane\nBound|RHQ|Office|CMCB-Excl. EQ|CMCB-Incl. EQ|CMCB(RA)|PA-RA|RPB|CMPB(RA)|CMCB(PA)|CMCB(RA)|PA-RA|RPB|CMPB(RA)";

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1) + 1, 0, 0, true);

				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, false, true, false, false);

				//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				// 전체 높이 설정
				style.height = GetSheetHeight(17) ;

				//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtStatus,	30,	daCenter,	true,	"ibflag",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtSeq,		30,	daCenter,	true,	"seq",				false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		50,	daCenter,	true,	"bse_yr",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,	daCenter,	true,	"bse_qtr_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCombo,	80,	daCenter,	true,	"ofc_vw_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		50,	daCenter,	true,	"trd_cd",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,	daCenter,	true,	"rlane_cd",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		50,	daCenter,	true,	"dir_cd",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,	daCenter,	true,	"rhq_cd",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,	daCenter,	true,	"rgn_ofc_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0, cnt++,  dtData,     90, daRight,    true,   "gid_pa_cm_xcld_eq_uc_amt", false,  "", dfInteger,  0,  false,  false);
				InitDataProperty(0,	cnt++,	dtData,		90,	daRight,	true,	"gid_pa_cm_uc_amt",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		90,	daRight,	true,	"gid_ra_cm_uc_amt",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		90,	daRight,	true,	"gui_diff",			false,	"|gid_pa_cm_uc_amt|-|gid_ra_cm_uc_amt|",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		90,	daRight,	true,	"initial_rpb",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		90,	daRight,	true,	"initial_cmpb_ra",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		90,	daRight,	true,	"pa_cm_uc_amt",		false,	"",	dfInteger,	0,	true,	true, 13);
				InitDataProperty(0,	cnt++,	dtData,		90,	daRight,	true,	"ra_cm_uc_amt",		false,	"",	dfInteger,	0,	true,	true, 13);
				InitDataProperty(0,	cnt++,	dtData,		90,	daRight,	true,	"diff",				false,	"|pa_cm_uc_amt|-|ra_cm_uc_amt|",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		90,	daRight,	true,	"current_rpb",		false,	"",	dfInteger,	0,	false,	false, 13);
				InitDataProperty(0,	cnt++,	dtData,		90,	daRight,	true,	"current_cmpb_ra",	false,	"",	dfInteger,	0,	false,	false, 13);

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
		case IBCLEAR:          //조회
			sheetObj.WaitImageVisible = false;

			ComOpenWait(true);

			formObj.f_cmd.value = INIT;

			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0011GS.do", FormQueryString(formObj));
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
				ComXml2ComboItem(arrXml[4], formObj.f_dir_cd, "code", "name");
			if (arrXml.length > 5)
				ComXml2ComboItem(arrXml[5], formObj.f_rhq_cd, "code", "name");

			ComOpenWait(false);
			break;

		case IBSEARCH:          // 화면 조회 시
			ComOpenWait(true);

			formObj.f_cmd.value = SEARCH;

			toggleButtons("INIT");

			searchParams = FormQueryString(formObj);

			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0011GS.do", searchParams);

			sheetObj.LoadSearchXml(rtnXml);

			var etcData = getEtcData(rtnXml);

			if (etcData["dataCnt"] == 0) {
				toggleButtons("CREATE");
			} else {
				toggleButtons("SEARCH");
			}

			setEditColor(sheetObj);

			ComOpenWait(false);
			break;

		case IBCREATE:          // Data 생성
			if (ComShowConfirm (ComGetMsg("SQM00009")) != 1) {
				return false;
		    }

			ComOpenWait(true);

			ComSetSearchParams("f_cmd", MULTI01);

			var sXml = sheetObj.GetSaveXml("ESM_SQM_0011GS.do", searchParams);

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

		case IBSAVE:			// 저장
			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006");
		        return false;
		    } else if (ComShowConfirm (ComGetMsg("SQM00004")) != 1) {
				return false;
		    }

			ComOpenWait(true);

			ComSetSearchParams("f_cmd", MULTI);

			sheetObj.DoSave("ESM_SQM_0011GS.do", searchParams, -1, false);

			ComOpenWait(false);

			var State = sheetObj.EtcData("TRANS_RESULT_KEY");

			if (State == "S") {
				ComShowCodeMessage("SQM00001", "Data");
			}
			break;

		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.MergeSheet = msNone;
			sheetObj.Down2Excel(-1, false, false, true);
			sheetObj.MergeSheet = msHeaderOnly;
			ComOpenWait(false);
			break;

		case IBLOADEXCEL:		// 엑셀 업로드
			loadExcelRowCnt = sheetObj.HeaderRows + sheetObj.TotalRows;
			loadExcelTotFlg = false;		// 화면에 Total Row 존재 여부
			if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
				loadExcelExField = "|bse_qtr_cd|pa_cm_uc_amt|ra_cm_uc_amt|diff|";		// 비교 제외 필드
			} else {
				loadExcelExField = "|pa_cm_uc_amt|ra_cm_uc_amt|diff|";		// 비교 제외 필드
			}
			loadExcelAplyField = "|pa_cm_uc_amt|ra_cm_uc_amt|";				// 반영 필드

			var rtn = window.showModalDialog("ESM_SQM_1001.do?" + searchParams, window, "dialogHeight:610px;dialogWidth:850px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");

			if(rtn == "S")
				ComShowCodeMessage("SQM00036");
			break;

		case "NewLaneCostIF":          // 신규노선에 대한 Cost 정보 I/F
			ComSetSearchParams("f_cmd", "");

			var rtn = window.showModalDialog("ESM_SQM_0012.do?" + searchParams, window, "dialogHeight:420px;dialogWidth:575px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");

			if (rtn == "OK") {
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
			break;

		case "MasUcPfmc":          // MAS의 PFMC 기반의 단가 조회기능
			ComSetSearchParams("f_cmd", "");
			
			window.showModalDialog("ESM_SQM_0013.do?" + searchParams, window, "dialogHeight:535px;dialogWidth:1110px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");
			break;
		

        case "AddCreation":          // AddCreation Popup
			formObj.f_cmd.value = INIT;
        	var rtn = window.showModalDialog("ESM_SQM_0111.do?" + FormQueryString(formObj), null, "dialogHeight:235px;dialogWidth:900px;center:yes;resizable:no;scroll:no;status:no;unadorned:yes;");
        	if(rtn == "OK") doActionIBSheet(sheetObj, formObj, IBSEARCH);
        	break; 
        	
        case "CMCB_ExclEQ":
            for(var i = sheetObj.HeaderRows; i <= sheetObj.RowCount + 1; i++) {
                sheetObj.CellValue(i, "pa_cm_uc_amt") = sheetObj.CellValue(i, "gid_pa_cm_xcld_eq_uc_amt");
            }
            break;
            
        case "CMCB_InclEQ":
            for(var i = sheetObj.HeaderRows; i <= sheetObj.RowCount + 1; i++) {
                sheetObj.CellValue(i, "pa_cm_uc_amt") = sheetObj.CellValue(i, "gid_pa_cm_uc_amt");
            }
            break; 
    }
}

/**
 *  선택된 Trade 에 해당하는 R.Lane 정보 가져와서 Combo Box 셋팅
 */
function f_trd_cd_OnChange(obj, value, text){
	setLaneCombo();
}

/**
 *  선택된 RHQ 에 해당하는 Office 정보 가져와서 Combo Box 셋팅
 */
function f_rhq_cd_OnChange(obj, value, text){
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];

	if (value != "All") {
		var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=office&code_param=" + value + "&all_flag=All");

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
 * 화면의 모든 버튼들의 Enable/Disable 을 처리
 */
function toggleButtons(step) {
	switch (step) {
		case "INIT":
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Creation");
			ComBtnDisable("btn_DownExcel");
			ComBtnDisable("btn_LoadExcel");
			ComBtnDisable("btn_NewLaneCostIF");
			ComBtnDisable("btn_MasUcPfmc");
			ComBtnDisable("btn_AddCreation");
			ComBtnDisable("btn_CMCB_ExclEQ");
			ComBtnDisable("btn_CMCB_InclEQ");
			break;

		case "CREATE":
			ComBtnEnable("btn_Creation");
			break;

		case "SEARCH":
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_DownExcel");
			ComBtnEnable("btn_LoadExcel");
			ComBtnEnable("btn_NewLaneCostIF");
			ComBtnEnable("btn_MasUcPfmc");
			ComBtnEnable("btn_AddCreation");
			ComBtnEnable("btn_CMCB_ExclEQ");
            ComBtnEnable("btn_CMCB_InclEQ");
			break;
	}
}

/**
 * Sheet 의 Edit 가능한 곳의 색상을 지정한다.
 * Load Excel 과 같이 사용.
 */
var setEditColorFn = function setEditColor(sheetObj) {
//	sheetObj.RangeBackColor(sheetObj.HeaderRows, 13, sheetObj.lastRow, 14) = sheetObj.RgbColor(255, 255, 0);   // Yellow

	if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
		sheetObj.ColHidden("bse_qtr_cd") = true;
	} else {
		sheetObj.ColHidden("bse_qtr_cd") = false;
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