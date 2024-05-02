/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0210.js
*@FileTitle      : Basic CMCB for IAS Sector
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.03
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.03 SQM USER
* 1.0 Creation
* 2014.01.16 박은주 [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
* 2015.09.14 김용습 [CHM-201537774] Basic CMCB (CM Cost Per Box)와 Basic CMCB for IAS Sector 두 화면 내 신규 칼럼 추가 (sector lane-office에서 active된 사항을 보여주는 컬럼 추가)
* 2015.10.19 김용습 [CHM-201538305] Basic CMCB (CM Cost Per Box) / Basic CMCB for IAS Sector 화면 내 신규 칼럼 추가
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_SQM_0210 : ESM_SQM_0210 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0210() {
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
var loadExcelsectorFlg = "";

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
				if(formObj.f_chk_rpb_cmpb.checked == false){
					sheetObj.ColHidden("initial_rpb") = true;  
					sheetObj.ColHidden("initial_cmpb_ra") = true;  
					sheetObj.ColHidden("current_rpb") = true;  
					sheetObj.ColHidden("current_cmpb_ra") = true;  
				}else{
//					if (ComShowConfirm (ComGetMsg("SQM00057")) != 1) {
//						return false;
//				    }
					sheetObj.ColHidden("initial_rpb") = false;  
					sheetObj.ColHidden("initial_cmpb_ra") = false;  
					sheetObj.ColHidden("current_rpb") = false;  
					sheetObj.ColHidden("current_cmpb_ra") = false; 
				}
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
	
	initControl();
}


function initControl() {
	var formObj = document.form;
	
	axon_event.addListenerForm("click",		"obj_click",	formObj);
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

				var HeadTitle1 =  "STS|SEQ|Year|Quarter|Trade|Sub Trade|IAS Region|R.Lane|Lane\nBound|POL|POD|Initial CM cost UC|Initial CM cost UC|Initial CM cost UC|Initial CM cost UC|Initial CM cost UC|Revised CM Cost UC|Revised CM Cost UC|Revised CM Cost UC|Revised CM Cost UC|Revised CM Cost UC|Active";
				var HeadTitle2 =  "STS|SEQ|Year|Quarter|Trade|Sub Trade|IAS Region|R.Lane|Lane\nBound|POL|POD|CMCB(PA)|CMCB(RA)|PA-RA|RPB|CMPB(RA)|CMCB(PA)|CMCB(RA)|PA-RA|RPB|CMPB(RA)|Active";

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

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
				InitDataProperty(0,	cnt++,	dtData,		50,	daCenter,	true,	"trd_cd",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		70,	daCenter,	true,	"sub_trd_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		80,	daCenter,	true,	"ias_rgn_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,	daCenter,	true,	"rlane_cd",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		50,	daCenter,	true,	"dir_cd",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,	daCenter,	true,	"pol_cd",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,	daCenter,	true,	"pod_cd",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	90,	daRight,	true,	"gid_pa_cm_uc_amt",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	90,	daRight,	true,	"gid_ra_cm_uc_amt",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	90,	daRight,	true,	"gui_diff",			false,	"|gid_pa_cm_uc_amt|-|gid_ra_cm_uc_amt|",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	90,	daRight,	true,	"initial_rpb",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	90,	daRight,	true,	"initial_cmpb_ra",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	90,	daRight,	true,	"pa_cm_uc_amt",		false,	"",	dfInteger,	0,	true,	true, 13);
				InitDataProperty(0,	cnt++,	dtAutoSum,	90,	daRight,	true,	"ra_cm_uc_amt",		false,	"",	dfInteger,	0,	true,	true, 13);
				InitDataProperty(0,	cnt++,	dtAutoSum,	90,	daRight,	true,	"diff",				false,	"|pa_cm_uc_amt|-|ra_cm_uc_amt|",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	90,	daRight,	true,	"current_rpb",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	90,	daRight,	true,	"current_cmpb_ra",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		90,	daCenter,	true,	"sqm_act_flg",		false,	"",	dfNone,	0,	false,	false);
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
		case "f_rlane_cd":
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

			ComOpenWait(true);

			formObj.f_cmd.value = INIT;

			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0210GS.do", FormQueryString(formObj));
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
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			toggleButtons("INIT");
			searchParams = FormQueryString(formObj);
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0210GS.do", searchParams);
			sheetObj.LoadSearchXml(rtnXml);
			var etcData = getEtcData(rtnXml);
			if (etcData["dataCnt"] == 0) {
				toggleButtons("CREATE");
			} else {
				toggleButtons("SEARCH");
			}
			setEditColor(sheetObj);
			ComOpenWait(false);
			
		 	sheetObj.SumText(0, "ibflag") = "";
		 	sheetObj.SumText(0, "bse_yr") = "TOTAL";
			break;

		case IBCREATE:          // Data 생성
			
			if (ComShowConfirm (ComGetMsg("SQM00009")) != 1) {
				return false;
		    }
			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI01);
			var sXml = sheetObj.GetSaveXml("ESM_SQM_0210GS.do", searchParams);
			
			var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
			if (backendJobKey != null && backendJobKey.length > 0) {
				ComSetObjValue(formObj.backendjob_key, backendJobKey);
				sheetObj.RequestTimeOut = 3600; //초 - 1시간
				backEndJobTimer = setInterval(getBackEndJobStatus, 5000);	//밀리초  - 10초
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
			sheetObj.DoSave("ESM_SQM_0210GS.do", searchParams, -1, false);
			ComOpenWait(false);
			var State = sheetObj.EtcData("TRANS_RESULT_KEY");

			if (State == "S") {
				ComShowCodeMessage("SQM00001", "Data");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
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
			loadExcelTotFlg = true;		// 화면에 Total Row 존재 여부
			if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
				loadExcelExField = "|bse_qtr_cd|pa_cm_uc_amt|ra_cm_uc_amt|diff|";		// 비교 제외 필드
			} else {
				loadExcelExField = "|pa_cm_uc_amt|ra_cm_uc_amt|diff|";		// 비교 제외 필드
			}
			loadExcelAplyField = "|pa_cm_uc_amt|ra_cm_uc_amt|";				// 반영 필드
			loadExcelsectorFlg = "C"; //sector flag에 따라 메세지 달라짐

			var rtn = window.showModalDialog("ESM_SQM_1001.do?" + searchParams, window, "dialogHeight:610px;dialogWidth:850px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");

			if(rtn == "S")
				ComShowCodeMessage("SQM00036");
			break;

		case "NewLaneCostIF":          // 신규노선에 대한 Cost 정보 I/F
			ComSetSearchParams("f_cmd", "");

			var rtn = window.showModalDialog("ESM_SQM_0211.do?" + searchParams, window, "dialogHeight:420px;dialogWidth:575px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");

			if (rtn == "OK") {
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
			break;

		case "MasUcPfmc":          // MAS의 PFMC 기반의 단가 조회기능
			ComSetSearchParams("f_cmd", "");
			
			window.showModalDialog("ESM_SQM_0212.do?" + searchParams, window, "dialogHeight:535px;dialogWidth:1110px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");
			break;
    }
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
	 	var param = "f_cmd=" + SEARCH01
	    + "&code_name=rLane"
	    + "&code_param=IAS|"+sub_trd_cd+"|"+ias_rgn_cd
	    + "&all_flag=";
	
	 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, formObj.f_rlane_cd, "code", "name");
	 	formObj.f_rlane_cd.MultiSelect = true;
 	} else {
		formObj.f_rlane_cd.RemoveAll();
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

function sheet1_OnSearchEnd(sheetObj) {
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
 * f_rlane_cd 바뀌었을때 POL, POD 변경
 */
function f_rlane_cd_OnChange(obj, value, text) {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	var rlane_cd = ComGetObjValue(formObj.f_rlane_cd);
 	
 	if ( rlane_cd != ""  && rlane_cd != "All" ) {
 		var code_name  = new Array("polCdSectorMulti", "podCdSectorMulti");
 		var code_param = new Array(value, value);
 		var all_flag   = new Array("All", "All");

 		var param = "f_cmd="		+ SEARCH02
 		          + "&code_name="	+ code_name
 		          + "&code_param="	+ code_param
 		          + "&all_flag="	+ all_flag
 		          + "&" + FormQueryString(formObj);	
 		var sXml   = sheetObj.GetSearchXml("CommonGS.do", param);
 		var arrXml = sXml.split("|$$|");

 		if (arrXml.length > 0) {
 			ComXml2ComboItem(arrXml[0], formObj.f_pol_cd, "code", "name");
 			formObj.f_pol_cd.Index = 0;
 		}
 		if (arrXml.length > 1) {
 			ComXml2ComboItem(arrXml[1], formObj.f_pod_cd, "code", "name");
 			formObj.f_pod_cd.Index = 0;
 		}
 	}else{
 		formObj.f_pol_cd.RemoveAll();
 		formObj.f_pod_cd.RemoveAll();
 	}
}

/**
* BackEndJob 관련 Status='3' 이 될때까지 확인한다.<br>
*/     
function getBackEndJobStatus() {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	ComOpenWait(true);
	
	var sXml     = sheetObj.GetSearchXml("ESM_SQM_0210GS.do", "f_cmd=" + SEARCH01 + "&backendjob_key=" + formObj.backendjob_key.value);
	
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

function obj_click() {
	
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	with(formObj) {
		switch(srcName) {

			case "f_chk_rpb_cmpb":
				if ( f_chk_rpb_cmpb.checked ) {
					ComShowCodeMessage("SQM00057");
				} 
				break;
		}
	}
}
/* 개발자 작업  끝 */