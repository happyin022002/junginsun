/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0504.js
*@FileTitle      : KPI Creation & Edit
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.15
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.15 이혜민
* 1.0 Creation
* 2013.11.11 박은주 [CHM-201327449] SQM 몇몇 화면 내 틀 고정 기능 추가
* 2014.01.09 박은주 [CHM-201428372] SELBB, TYOBB 조직 LEVEL 변경 건
* 2015.01.22 김용습 [CHM-201533807] Rev Month 기준으로 관련 화면의 period를 변경
* 2015.11.10 김성욱 [CHM-201538496] [CSR 전환건] KPI Creation & Edit 화면 보완 (Trade Direction 칼럼 추가)
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_SQM_0504 : ESM_SQM_0504 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0504() {
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
				f_bse_tp_cd_0504_OnChange();
				break;

			case "btn_Retrieve":
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;

			case "btn_Save":
				doActionIBSheet(sheetObj, formObj, IBSAVE);
				break;

			case "btn_Creation":
				doActionIBSheet(sheetObj, formObj, MULTI01);
				break;

			case "btn_1qTransfer":
				doActionIBSheet(sheetObj, formObj, MULTI02);
				break;

			case "btn_DownExcel":
				doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
				break;

			case "btn_LoadExcel":
				doActionIBSheet(sheetObj, formObj, IBLOADEXCEL);
				break;

			case "btn_NewLaneAdd":
				ComSetSearchParams("f_cmd", "");
				var rtn = window.showModalDialog("ESM_SQM_0505.do?" + searchParams + "&div_period=" + document.getElementById("div_period").innerHTML, window, "dialogHeight:440px;dialogWidth:550px;center:yes;resizable:no;scroll:no;status:no;unadorned:yes;");
				// IAS Office Add 후 그리드를 다시 조회한다.
				if(rtn == "S")
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;

			case "btn_OfficeAdd":
				ComSetSearchParams("f_cmd", "");
				var rtn = window.showModalDialog("ESM_SQM_0506.do?" + searchParams + "&div_period=" + document.getElementById("div_period").innerHTML, window, "dialogHeight:500px;dialogWidth:780px;center:yes;resizable:no;scroll:no;status:no;unadorned:yes;");
				// IAS Office Add 후 그리드를 다시 조회한다.
				if(rtn == "S")
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
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
	toggleButtons();
	
	//SET Check box Click Event
	axon_event.addListenerForm  ('click', 'obj_click',   document.form);
	
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

				var HeadTitle1 =  "STS|SEQ|Year|Quarter|Trade|Sub Trade|Lane|Lane\nBound|Trade\nBound|Trade\nDirection|vsl_cd|skd_voy_no|skd_dir_cd|VVD|Month|Week|Supply|RHQ|Office|Load|G.RPB|G.REV|CM(PA)|CMCB(PA)|CM(RA)|CMCB(RA)";
				
				var headCount = ComCountHeadTitle(HeadTitle1);
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 2, 0, true);

				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, false, true, false, false);

				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				// 전체 높이 설정
				style.height = GetSheetHeight(17);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtStatus,			30,		daCenter,	true,	"ibflag",					false,	"",		dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtSeq,				40,		daCenter,	true,	"seq",						false,	"",		dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,				60,		daCenter,	true,	"bse_yr",					true,		"",		dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,				65,		daCenter,	true,	"bse_qtr_cd",				true,		"",		dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,				60,		daCenter,	true,	"trd_cd",					true,		"",		dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,				80,		daCenter,	true,	"sub_trd_cd",				true,		"",		dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,				70,		daCenter,	true,	"rlane_cd",				true,		"",		dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,				70,		daCenter,	true,	"dir_cd",					true,		"",		dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,				70,		daCenter,	true,	"conv_dir_cd",			true,		"",		dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,				70,		daCenter,	true,	"hul_bnd_cd",			true,		"",		dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,			90,		daCenter,	true,	"vsl_cd",					false,	"",		dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,			90,		daCenter,	true,	"skd_voy_no",			false,	"",		dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,			90,		daCenter,	true,	"skd_dir_cd",				false,	"",		dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,				90,		daCenter,	true,	"vvd",						true,		"",		dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,				60,		daCenter,	true,	"bse_mon",				true,		"",		dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,				60,		daCenter,	true,	"bse_wk",					true,		"",		dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,				70,		daCenter,	true,	"fnl_bsa_capa",			true,		"",		dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,				70,		daCenter,	true,	"rhq_cd",					true,		"",		dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,				65,		daCenter,	true,	"rgn_ofc_cd",				true,		"",		dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		85,		daRight,	true,	"lod_qty",					false,	"",		dfInteger,		0,	true,		false, 5);
				InitDataProperty(0,	cnt++,	dtData,				85,		daRight,	true,	"grs_rpb_rev",			false,	"",		dfInteger,		0,	true,		false, 5);
				InitDataProperty(0,	cnt++,	dtAutoSum,		85,		daRight,	true,	"grs_rpb_rev_ttl",		false,	"|lod_qty|*|grs_rpb_rev|",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		85,		daRight,	true,	"pa_cm_amt",			false,	"|grs_rpb_rev_ttl|-(|lod_qty|*|pa_cm_uc_amt|)",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,				85,		daRight,	true,	"pa_cm_uc_amt",		false,	"",		dfInteger,		0,	true,		false, 5);
				InitDataProperty(0,	cnt++,	dtAutoSum,		85,		daRight,	true,	"ra_cm_amt",			false,	"|grs_rpb_rev_ttl|-(|lod_qty|*|ra_cm_uc_amt|)",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,				85,		daRight,	true,	"ra_cm_uc_amt",		false,	"",		dfInteger,		0,	true,		false, 5);

				//CountPosition = 0;
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
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0504GS.do", FormQueryString(formObj));
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
				ComXml2ComboItem(arrXml[4], formObj.f_conv_dir_cd, "code", "name");
			if (arrXml.length > 5)
				ComXml2ComboItem(arrXml[5], formObj.f_rhq_cd, "code", "name");
			if (arrXml.length > 6)
                ComXml2ComboItem(arrXml[6], formObj.f_trd_dir, "code", "name");
			ComOpenWait(false);
			break;

		case IBSEARCH:          // 화면 조회 시
			ComOpenWait(true);

			formObj.f_cmd.value = SEARCH;

			toggleButtons();
			searchParams = FormQueryString(formObj);
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0504GS.do", searchParams);

			sheetObj.LoadSearchXml(rtnXml);

			var etcData = getEtcData(rtnXml);

			if(etcData["dataCnt"] == 0){
				toggleButtons("CREATE"); //creation만 활성화
			}else{
				toggleButtons("SEARCH"); //creation만 비활성화
				var bse_tp_cd =  ComGetObjValue(formObj.f_bse_tp_cd[0]);
				if(bse_tp_cd == "Y"){
					check1QTransferData();
				}
			}
			ComOpenWait(false);
			sheetObj.SumText(0, "ibflag") = "";
			sheetObj.SumText(0, "bse_yr") = "TOTAL";
			break;

		case SEARCH01:		//Creation 후나 이미 Yearly 데이터가 있을경우 1Q 데이터가 있는지 없는지 확인
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("ESM_SQM_0504GS.do", sParam);
			ComOpenWait(false);
			return sXml;
			break;

		case IBSAVE:		// 저장
			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006");
		        return false;
		    } else if (ComShowConfirm (ComGetMsg("SQM00004")) != 1) {
				return false;
		    }
			ComOpenWait(true);

			ComSetSearchParams("f_cmd", MULTI);
			sheetObj.DoSave("ESM_SQM_0504GS.do", searchParams, -1, false);
			ComOpenWait(false);

			var State = sheetObj.EtcData("TRANS_RESULT_KEY");

			if (State == "S") {
				ComShowCodeMessage("COM130102", "Data");
				//doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}else{
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}
			break;

		case MULTI01:          // 화면 creation시
			if (ComShowConfirm (ComGetMsg("SQM00009")) != 1) {
				return false;
		    }

			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI01);
			var sXml = sheetObj.GetSaveXml("ESM_SQM_0504GS.do", searchParams);
			ComOpenWait(false);

			var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);

			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('SQM00010', 'Data');
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
			break;

		case MULTI02:          // 1Q Transfer
			if (ComShowConfirm (ComGetMsg("SQM00012",'transfer 1Q data')) != 1) {
				return false;
		    }

			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI02);
			var sXml = sheetObj.GetSaveXml("ESM_SQM_0504GS.do", searchParams);
			ComOpenWait(false);

			var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);

			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('SQM00010', 'Data');
				ComBtnDisable("btn_1qTransfer");
			}
			break;

		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.Down2Excel(-1, false, false, true);
			ComOpenWait(false);
			break;

		case IBLOADEXCEL:		// 엑셀 업로드
			loadExcelRowCnt    = sheetObj.HeaderRows + sheetObj.TotalRows;
			loadExcelTotFlg    = true;		// 화면에 Total Row 존재 여부
			loadExcelExField   = "|lod_qty|grs_rpb_rev|grs_rpb_rev_ttl|pa_cm_amt|pa_cm_uc_amt|ra_cm_amt|ra_cm_uc_amt|vsl_cd|skd_voy_no|skd_dir_cd|";		// 비교 제외 필드
			loadExcelAplyField = "|lod_qty|grs_rpb_rev|pa_cm_uc_amt|ra_cm_uc_amt|";		// 반영 필드

			var rtn = window.showModalDialog("ESM_SQM_1001.do?" + searchParams, window, "dialogHeight:600px;dialogWidth:1050px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");
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
 * f_bse_yr, f_bse_qtr_cd, f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
 */
function setLaneCombo() {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	
	var bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd);
	var bse_yr     = ComGetObjValue(formObj.f_bse_yr);
	var bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
	var trd_cd     = ComGetObjValue(formObj.f_trd_cd);
	
	if (trd_cd != "All") {
		var param = "f_cmd=" + SEARCH01
	     + "&code_name=spclAdjLane"
	     + "&code_param=" +bse_tp_cd
	      + "|" + bse_yr
	      + "|" + bse_qtr_cd
	      + "|" + trd_cd
	     + "&all_flag=All" ;	// Trade

		var sXml = sheetObj.GetSearchXml("CommonGS.do", param);

		ComXml2ComboItem(sXml, formObj.f_rlane_cd, "code", "name");
		formObj.f_rlane_cd.Index = 0;
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
* f_bse_tp_cd 바뀌었을때 qtr_cd, week 변경
*/
function f_bse_tp_cd_0504_OnChange() {
	var formObj    = document.form;
	var bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
	var div_qtr    = document.getElementById("div_qtr");
	var div_period = document.getElementById("div_period");
	var f_bse_qtr_cd_idx = formObj.f_bse_qtr_cd.Index;

	if (bse_tp_cd == "Y") { //Yearly 선택
		document.getElementById("div_1QTransfer").style.display = "inline";
		formObj.f_bse_qtr_cd.InsertItem(0, 'All', 'All');
		formObj.f_bse_qtr_cd.Index = 0;
		formObj.f_bse_qtr_cd.BackColor = "white";

	}else{  //Quarterly 선택
		document.getElementById("div_1QTransfer").style.display = "none";
		formObj.f_bse_qtr_cd.DeleteItem("All");
		if(f_bse_qtr_cd_idx == 0){
			formObj.f_bse_qtr_cd.Index = 0;
		}else{
			formObj.f_bse_qtr_cd.Index = f_bse_qtr_cd_idx-1;
		}
		formObj.f_bse_qtr_cd.BackColor = "#CCFFFD"; //필수입력 input1 색으로 변환
	}
	setMonth();
	setLaneCombo();
}

/**
* f_bse_qtr_cd 바뀌었을때 Month 변경
*/
function setMonth(){
	var formObj  = document.form;
	var bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
	if(bse_qtr_cd == "All"){
		formObj.f_bse_mon.RemoveAll();
		formObj.f_bse_mon.InsertItem(0, 'All', 'All');
		formObj.f_bse_mon.InsertItem(1, '01', '01');
		formObj.f_bse_mon.InsertItem(2, '02', '02');
		formObj.f_bse_mon.InsertItem(3, '03', '03');
		formObj.f_bse_mon.InsertItem(4, '04', '04');
		formObj.f_bse_mon.InsertItem(5, '05', '05');
		formObj.f_bse_mon.InsertItem(6, '06', '06');
		formObj.f_bse_mon.InsertItem(7, '07', '07');
		formObj.f_bse_mon.InsertItem(8, '08', '08');
		formObj.f_bse_mon.InsertItem(9, '09', '09');
		formObj.f_bse_mon.InsertItem(10, '10', '10');
		formObj.f_bse_mon.InsertItem(11, '11', '11');
		formObj.f_bse_mon.InsertItem(12, '12', '12');
		formObj.f_bse_mon.Index = 0;
	}else if(bse_qtr_cd == "1Q"){
		formObj.f_bse_mon.RemoveAll();
		formObj.f_bse_mon.InsertItem(0, 'All', 'All');
		formObj.f_bse_mon.InsertItem(1, '01', '01');
		formObj.f_bse_mon.InsertItem(2, '02', '02');
		formObj.f_bse_mon.InsertItem(3, '03', '03');
		formObj.f_bse_mon.Index = 0;
	}else if(bse_qtr_cd == "2Q"){
		formObj.f_bse_mon.RemoveAll();
		formObj.f_bse_mon.InsertItem(0, 'All', 'All');
		formObj.f_bse_mon.InsertItem(1, '04', '04');
		formObj.f_bse_mon.InsertItem(2, '05', '05');
		formObj.f_bse_mon.InsertItem(3, '06', '06');
		formObj.f_bse_mon.Index = 0;
	}else if(bse_qtr_cd == "3Q"){
		formObj.f_bse_mon.RemoveAll();
		formObj.f_bse_mon.InsertItem(0, 'All', 'All');
		formObj.f_bse_mon.InsertItem(1, '07', '07');
		formObj.f_bse_mon.InsertItem(2, '08', '08');
		formObj.f_bse_mon.InsertItem(3, '09', '09');
		formObj.f_bse_mon.Index = 0;
	}else if(bse_qtr_cd == "4Q"){
		formObj.f_bse_mon.RemoveAll();
		formObj.f_bse_mon.InsertItem(0, 'All', 'All');
		formObj.f_bse_mon.InsertItem(1, '10', '10');
		formObj.f_bse_mon.InsertItem(2, '11', '11');
		formObj.f_bse_mon.InsertItem(3, '12', '12');
		formObj.f_bse_mon.Index = 0;
	}
//	period_change_based_on_rev_month();
	period_change();
}

/**
* 화면의 모든 버튼들의 Enable/Disable 을 처리
*/
function toggleButtons(step) {
	// retrieve만 활성화
	ComBtnDisable("btn_Save");
	ComBtnDisable("btn_DownExcel");
	ComBtnDisable("btn_LoadExcel");
	ComBtnDisable("btn_Creation");
	ComBtnDisable("btn_NewLaneAdd");
	ComBtnDisable("btn_OfficeAdd");
	ComBtnDisable("btn_1qTransfer");

	switch (step) {
		case "SEARCH": //creation만 비활성화
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_DownExcel");
			ComBtnEnable("btn_LoadExcel");
			ComBtnEnable("btn_NewLaneAdd");
			ComBtnEnable("btn_OfficeAdd");
			break;

		case "CREATE": //creation만 활성화
			ComBtnEnable("btn_Creation");
			break;
	}
}

var validatesheetFn = function validatesheet(sheetObj,row,colName) {
	switch(colName) {
		case "lod_qty":
			if(sheetObj.CellValue(row,colName) == ""){
				sheetObj.CellBackColor(row,colName) = sheetObj.RgbColor(255, 0, 0);
				msg = "Load is mandatory item.\n"
					+"==================================================================================\n";
				return false;
			}
			if(sheetObj.CellValue(row,colName) > 99999){
				sheetObj.CellBackColor(row,colName) = sheetObj.RgbColor(255, 0, 0);
				msg = "You can't input Load more than 100,000$/TEU.\n"
					+"==================================================================================\n";
				return false;
			}
			break;

		case "grs_rpb_rev":
			if(sheetObj.CellValue(row,colName) == ""){
				sheetObj.CellBackColor(row,colName) = sheetObj.RgbColor(255, 0, 0);
				msg = "G.RPB is mandatory item.\n"
					+"==================================================================================\n";
				return false;
			}
			if(sheetObj.CellValue(row,colName) > 99999){
				sheetObj.CellBackColor(row,colName) = sheetObj.RgbColor(255, 0, 0);
				msg = "You can't input G.RPB more than 100,000$/TEU.\n"
					+"==================================================================================\n";
				return false;
			}
			break;
		case "pa_cm_uc_amt":
			if(sheetObj.CellValue(row,colName) == ""){
				sheetObj.CellBackColor(row,colName) = sheetObj.RgbColor(255, 0, 0);
				msg = "CMCB(PA) is mandatory item.\n"
					+"==================================================================================\n";
				return false;
			}
			if(sheetObj.CellValue(row,colName) > 99999){
				sheetObj.CellBackColor(row,colName) = sheetObj.RgbColor(255, 0, 0);
				msg = "You can't input CMCB(PA) more than 100,000$/TEU.\n"
					+"==================================================================================\n";
				return false;
			}
			break;

		case "ra_cm_uc_amt":
			if(sheetObj.CellValue(row,colName) == ""){
				sheetObj.CellBackColor(row,colName) = sheetObj.RgbColor(255, 0, 0);
				msg = "CMCB(RA) is mandatory item.\n"
					+"==================================================================================\n";
				return false;
			}
			if(sheetObj.CellValue(row,colName) > 99999){
				sheetObj.CellBackColor(row,colName) = sheetObj.RgbColor(255, 0, 0);
				msg = "You can't input CMCB(RA) more than 100,000$/TEU.\n"
					+"==================================================================================\n";
				return false;
			}
			break;
	}
	return true;
}

/**
* Creation 후나 이미 Yearly 데이터가 있을경우 1Q 데이터가 있는지 없는지 확인
*/
function check1QTransferData(){
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	var sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
	var check1QData = ComGetEtcData(sXml,"dataCnt");
	if(check1QData == "0"){
		ComBtnEnable("btn_1qTransfer");
	}
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
	setMonth();
	setLaneCombo();
}

/**
 * f_gubun가 체크될때 direction콤보 change
 */
function obj_click() {
   var formObj = document.form;

   if(formObj.f_gubun.checked){
           trd_dir.style.display = "inline";
           dir_cd.style.display = "none";
           document.all("div_dir").innerHTML = "Trade Dir.";
   }else{
           trd_dir.style.display = "none";
           dir_cd.style.display = "inline";
           document.all("div_dir").innerHTML = "Trade Bound";
   }
}
/* 개발자 작업  끝 */