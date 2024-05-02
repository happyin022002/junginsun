/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0226.js
*@FileTitle      : Quarterly Current QTA Report for IAS Sector
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.23
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.23 SQM USER
* 1.0 Creation
* History
* 2014.06.20 이혜민 [CHM-201430168] IAS Sector Sales - Main, Sector 구분자 추가를 위한 화면 변경
* 2015.01.16 이혜민 [CHM-201533644] Raw data Export 보완
* 2015.01.22 김용습 [CHM-201533807] Rev Month 기준으로 관련 화면의 period를 변경
* 2015.08.06 김용습 [CHM-201537260] [CSR 전환 건] SQM내 Report에 과거 CM 체계 기준 판매목표 데이터 조회 기능 생성 (15년 2Q 이전 데이터 Freeze) 
* 2015.09.17 김용습 [CHM-201538072] [CSR 전환건] Report 선택 옵션 중 Week 선택 시 Validation 삭제 요청
* 2015.11.30 김용습 [선반영] Retrieve를 하지 않아도 Raw Data Export가 활성화되게 해달라는 유저 요청 반영
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_SQM_0226 : ESM_SQM_0226 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0226() {
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
			case "btn_Retrieve":
				if(formObj.rdoOp_cd[0].checked){
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				}else if(formObj.rdoOp_cd[1].checked){
					doActionIBSheet(sheetObjects[1], formObj, "IBSEARCH02");
				}
				break;
			case "btn_DownExcel":
				if(formObj.rdoOp_cd[0].checked){
					doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
				}else if(formObj.rdoOp_cd[1].checked){
					doActionIBSheet(sheetObjects[1], formObj, IBDOWNEXCEL);
				}
				break;
			case "btn_RawDataDownExcel":
				if(formObj.rdoOp_cd[0].checked){
					doActionIBSheet(sheetObj, formObj, "RawDataDownExcel");
				}else if(formObj.rdoOp_cd[1].checked){
					doActionIBSheet(sheetObjects[1], formObj, "RawDataDownExcelPreviousVersion");
				}
				break;
			case "rdoOp_cd":
				if (formObj.rdoOp_cd[0].checked) {  
					document.getElementById("tabLayer1").style.display= "inline";
					document.getElementById("tabLayer2").style.display= "none";
				} else if (formObj.rdoOp_cd[1].checked) {  
					document.getElementById("tabLayer1").style.display= "none";
					document.getElementById("tabLayer2").style.display= "inline";
				}
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

	initControl();

	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}

	ComBtnDisable("btn_DownExcel");
//    ComBtnDisable("btn_RawDataDownExcel");
	
	loadingMode = false;
}

function initControl() {
	var formObj = document.form;

	axon_event.addListenerForm("KeyUp",		"obj_KeyUp",	formObj);
	axon_event.addListenerForm("change",	"obj_change",	formObj);
	axon_event.addListenerForm("click",		"obj_click",	formObj);
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
				MergeSheet = msHeaderOnly;  //msNone; //msHeaderOnly //msPrevColumnMerge;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				var HeadTitle1 = "SEQ|Year|Quarter|Office View|Trade|Sub Trade|IAS Region|R.Lane|Lane\nBound|Trade\nDirection|Month|Week|VVD|Supply|RHQ|Office|POL|POD|Main/Sector|Load|G.RPB|G.REV|CM Cost(PA)|CM Cost(RA)|CMCB(PA)|CMCB(RA)|CM(PA)|CM(RA)|CMPB(PA)|CMPB(RA)";

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1), 1, 0, true);

				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, false, true, false, false);

				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				// 전체 높이 설정
				style.height = GetSheetHeight(17);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtSeq,		30,		daCenter,	true,	"seq",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"bse_yr",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		55,		daCenter,	true,	"bse_qtr_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		70,		daCenter,	true,	"ofc_vw_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"trd_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		70,		daCenter,	true,	"sub_trd_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	true,	"ias_rgn_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"rlane_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		50,		daCenter,	true,	"dir_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"hul_bnd_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"bse_mon",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"bse_wk",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	true,	"vvd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	60,		daRight,	true,	"tot_bsa_capa",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"rhq_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"rgn_ofc_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"pol_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"pod_cd",		false,	"",	dfNone,		0,	false,	false);
    			InitDataProperty(0,	cnt++,	dtData,		90, 	daCenter,	true,	"sqm_mn_sctr_flg",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"lod_qty",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"rev_rpb",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"grs_rev",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"pa_cm_cost",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"ra_cm_cost",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"pa_cmcb",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"ra_cmcb",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"pa_cm",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"ra_cm",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"pa_cmpb",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"ra_cmpb",		false,	"",	dfInteger,	0,	false,	false);

				RangeBackColor(0, 19, 0, 21) = RgbColor(203,210,248);
				RangeBackColor(0, 26, 0, 29) = RgbColor(203,210,248);
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

				var HeadTitle1 = "SEQ|Year|Quarter|Office View|Trade|Sub Trade|IAS Region|R.Lane|Lane\nBound|Trade\nDirection|Month|Week|VVD|Supply|RHQ|Office|POL|POD|Main/Sector|Load|G.RPB|G.REV|CM Cost(PA)|CM Cost(RA)|CMCB(PA)|CMCB(RA)|CM(PA)|CM(RA)|CMPB(PA)|CMPB(RA)";

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1), 1, 0, true);

				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, false, true, false, false);

				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				// 전체 높이 설정
				style.height = GetSheetHeight(17);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtSeq,		30,		daCenter,	true,	"seq",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"bse_yr",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		55,		daCenter,	true,	"bse_qtr_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		70,		daCenter,	true,	"ofc_vw_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"trd_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		70,		daCenter,	true,	"sub_trd_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	true,	"ias_rgn_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"rlane_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		50,		daCenter,	true,	"dir_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"hul_bnd_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"bse_mon",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"bse_wk",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	true,	"vvd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	60,		daRight,	true,	"tot_bsa_capa",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"rhq_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"rgn_ofc_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"pol_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"pod_cd",		false,	"",	dfNone,		0,	false,	false);
    			InitDataProperty(0,	cnt++,	dtData,		90, 	daCenter,	true,	"sqm_mn_sctr_flg",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"lod_qty",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"rev_rpb",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"grs_rev",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"pa_cm_cost",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"ra_cm_cost",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"pa_cmcb",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"ra_cmcb",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"pa_cm",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"ra_cm",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"pa_cmpb",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"ra_cmpb",		false,	"",	dfInteger,	0,	false,	false);

				RangeBackColor(0, 19, 0, 21) = RgbColor(203,210,248);
				RangeBackColor(0, 26, 0, 29) = RgbColor(203,210,248);
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

			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0226GS.do", FormQueryString(formObj));
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
				ComXml2ComboItem(arrXml[4], formObj.f_ofc_lvl, "code", "name");
			if (arrXml.length > 5)
				ComXml2ComboItem(arrXml[5], formObj.f_rhq_cd, "code", "name");
			if (arrXml.length > 6)
				ComXml2ComboItem(arrXml[6], formObj.f_sub_trd_cd, "code", "name");
			if (arrXml.length > 7)
				ComXml2ComboItem(arrXml[7], formObj.f_ias_rgn_cd, "code", "name");
			if (arrXml.length > 8)
				ComXml2ComboItem(arrXml[8], formObj.f_dir_cd, "code", "name");
			if (arrXml.length > 9)
				ComXml2ComboItem(arrXml[9], formObj.f_hul_bnd_cd, "code", "name");

			ComOpenWait(false);
			break;

		case IBSEARCH:          // 화면 조회 시
			if (!validateForm(sheetObj, formObj, sAction)) return;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			searchParams = FormQueryString(formObj);
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0226GS.do", searchParams);
			sheetObj.LoadSearchXml(rtnXml);
			ComOpenWait(false);
			break;
			
		case "IBSEARCH02":          // 화면 조회 시
			
			if (!validateForm(sheetObj, formObj, sAction)) return;
//			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH02;
			searchParams = FormQueryString(formObj);
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0226GS.do", searchParams);
			sheetObj.LoadSearchXml(rtnXml);
//			ComOpenWait(false);
			break;

		case IBDOWNEXCEL:		// 엑셀 다운로드
			if(formObj.rdoOp_cd[0].checked){
				ComOpenWait(true);
			}
			
			sheetObj.Down2Excel(-1, false, false, true);
			
			if(formObj.rdoOp_cd[0].checked){
				ComOpenWait(false);
			}
			break;

		case "RawDataDownExcel":		// Raw Data 엑셀 다운로드
			ComOpenWait(true);
           //Year, Quarter, Office view user 선택. office level은 항상 office. week, vvd, pol-pod pair check.
			var param = "f_cmd="         + COMMAND01
			          + "&f_bse_tp_cd="  + ComGetObjValue(formObj.f_bse_tp_cd)
			          + "&f_bse_yr="     + ComGetObjValue(formObj.f_bse_yr)
			          + "&f_bse_qtr_cd=" + ComGetObjValue(formObj.f_bse_qtr_cd)
			          + "&f_ofc_vw_cd="  + ComGetObjValue(formObj.f_ofc_vw_cd)
			          + "&f_ofc_lvl=03"
			          + "&f_chk_week=W"
			          + "&f_chk_vvd=V"
					  + "&f_chk_pair=Y";

			document.location.href = "ESM_SQM_0226DL.do?" + param;

			ComOpenWait(false);
			break;
			
		case "RawDataDownExcelPreviousVersion":		// Raw Data 엑셀 다운로드
			ComOpenWait(true);
           //Year, Quarter, Office view user 선택. office level은 항상 office. week, vvd, pol-pod pair check.
			var param = "f_cmd="         + COMMAND02
			          + "&f_bse_tp_cd="  + ComGetObjValue(formObj.f_bse_tp_cd)
			          + "&f_bse_yr="     + ComGetObjValue(formObj.f_bse_yr)
			          + "&f_bse_qtr_cd=" + ComGetObjValue(formObj.f_bse_qtr_cd)
			          + "&f_ofc_vw_cd="  + ComGetObjValue(formObj.f_ofc_vw_cd)
			          + "&f_ofc_lvl=03"
			          + "&f_chk_week=W"
			          + "&f_chk_vvd=V"
					  + "&f_chk_pair=Y";

			document.location.href = "ESM_SQM_0226DL.do?" + param;

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
	var formObj     = document.form;
	var ofc_lvl     = ComGetObjValue(formObj.f_ofc_lvl);
	var chk_week    = formObj.f_chk_week.checked;
	var chk_vvd     = formObj.f_chk_vvd.checked;
	var chk_pair    = formObj.f_chk_pair.checked;

	if ( ofc_lvl == "01" ) {
		sheetObj.ColHidden("rhq_cd")     = true;
		sheetObj.ColHidden("rgn_ofc_cd") = true;

	} else if ( ofc_lvl == "02" ) {
		sheetObj.ColHidden("rhq_cd")     = false;
		sheetObj.ColHidden("rgn_ofc_cd") = true;
		sheetObj.SumText(0, "fnl_bsa_capa") = "";

	} else if ( ofc_lvl == "03" ) {
		sheetObj.ColHidden("rhq_cd")     = false;
		sheetObj.ColHidden("rgn_ofc_cd") = false;
		sheetObj.SumText(0, "fnl_bsa_capa") = "";

	}

	if ( chk_week ) {
		sheetObj.ColHidden("bse_wk") = false;
	} else {
		sheetObj.ColHidden("bse_wk") = true;
	}

	if ( chk_vvd ) {
		sheetObj.ColHidden("vvd") = false;
	} else {
		sheetObj.ColHidden("vvd") = true;
	}
	
	if ( chk_pair ) {
		sheetObjects[0].ColHidden("pol_cd") = false;
		sheetObjects[0].ColHidden("pod_cd") = false;
		sheetObjects[0].ColHidden("sqm_mn_sctr_flg") = false;
	} else {
		sheetObjects[0].ColHidden("pol_cd") = true;
		sheetObjects[0].ColHidden("pod_cd") = true;
		sheetObjects[0].ColHidden("sqm_mn_sctr_flg") = true;
	}
	sheetObj.SumText(0, "rev_rpb")      = ComAddComma((sheetObj.SumValue(0, "grs_rev")   / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "pa_cmcb")      = ComAddComma((sheetObj.SumValue(0, "pa_cm_cost") / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "ra_cmcb")      = ComAddComma((sheetObj.SumValue(0, "ra_cm_cost") / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "pa_cmpb")      = ComAddComma((sheetObj.SumValue(0, "pa_cm")   / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "ra_cmpb")      = ComAddComma((sheetObj.SumValue(0, "ra_cm")   / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "seq")    = "";
	sheetObj.SumText(0, "trd_cd") = "TOTAL";
	
	if(sheetObj.RowCount > 0){
		ComBtnEnable("btn_DownExcel");
		ComBtnEnable("btn_RawDataDownExcel");
	}else{
		ComBtnDisable("btn_DownExcel");
//		ComBtnDisable("btn_RawDataDownExcel");
	}
}

function sheet2_OnSearchEnd(sheetObj, ErrMsg){
	var formObj     = document.form;
	var ofc_lvl     = ComGetObjValue(formObj.f_ofc_lvl);
	var chk_week    = formObj.f_chk_week.checked;
	var chk_vvd     = formObj.f_chk_vvd.checked;
	var chk_pair    = formObj.f_chk_pair.checked;

	if ( ofc_lvl == "01" ) {
		sheetObj.ColHidden("rhq_cd")     = true;
		sheetObj.ColHidden("rgn_ofc_cd") = true;

	} else if ( ofc_lvl == "02" ) {
		sheetObj.ColHidden("rhq_cd")     = false;
		sheetObj.ColHidden("rgn_ofc_cd") = true;
		sheetObj.SumText(0, "fnl_bsa_capa") = "";

	} else if ( ofc_lvl == "03" ) {
		sheetObj.ColHidden("rhq_cd")     = false;
		sheetObj.ColHidden("rgn_ofc_cd") = false;
		sheetObj.SumText(0, "fnl_bsa_capa") = "";

	}

	if ( chk_week ) {
		sheetObj.ColHidden("bse_wk") = false;
	} else {
		sheetObj.ColHidden("bse_wk") = true;
	}

	if ( chk_vvd ) {
		sheetObj.ColHidden("vvd") = false;
	} else {
		sheetObj.ColHidden("vvd") = true;
	}
	
	if ( chk_pair ) {
		sheetObjects[1].ColHidden("pol_cd") = false;
		sheetObjects[1].ColHidden("pod_cd") = false;
		sheetObjects[1].ColHidden("sqm_mn_sctr_flg") = false;
	} else {
		sheetObjects[1].ColHidden("pol_cd") = true;
		sheetObjects[1].ColHidden("pod_cd") = true;
		sheetObjects[1].ColHidden("sqm_mn_sctr_flg") = true;
	}
	sheetObj.SumText(0, "rev_rpb")      = ComAddComma((sheetObj.SumValue(0, "grs_rev")   / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "pa_cmcb")      = ComAddComma((sheetObj.SumValue(0, "pa_cm_cost") / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "ra_cmcb")      = ComAddComma((sheetObj.SumValue(0, "ra_cm_cost") / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "pa_cmpb")      = ComAddComma((sheetObj.SumValue(0, "pa_cm")   / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "ra_cmpb")      = ComAddComma((sheetObj.SumValue(0, "ra_cm")   / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "seq")    = "";
	sheetObj.SumText(0, "trd_cd") = "TOTAL";
	
	if(sheetObj.RowCount > 0){
		ComBtnEnable("btn_DownExcel");
		ComBtnEnable("btn_RawDataDownExcel");
	}else{
		ComBtnDisable("btn_DownExcel");
//		ComBtnDisable("btn_RawDataDownExcel");
	}
}

/**
 * f_ofc_lvl 바뀌었을때 event 처리
 */
 function f_ofc_lvl_OnChange(obj, value, text) {
	 var formObj = document.form;
	 var div_rhq = document.getElementById("div_rhq");
	 var div_ofc = document.getElementById("div_ofc");

	 if ( value == "01" ) {	//Head Office 일 때
		 div_rhq.style.display = "none";
		 div_ofc.style.display = "none";
		 formObj.f_rhq_cd.style.display     = "none";
		 formObj.f_rgn_ofc_cd.style.display = "none";
	 } else if ( value == "02" ) {	//RHQ 일 때
		 div_rhq.style.display = "inline";
		 div_ofc.style.display = "none";
		 formObj.f_rhq_cd.style.display     = "inline";
		 formObj.f_rgn_ofc_cd.style.display = "none";
	 } else {	// Office 일 때
		 div_rhq.style.display = "inline";
		 div_ofc.style.display = "inline";
		 formObj.f_rhq_cd.style.display     = "inline";
		 formObj.f_rgn_ofc_cd.style.display = "inline";
	 }
}

/**
* f_bse_yr가 바뀌었을때 office 콤보 셋팅
*/
function f_bse_yr_OnChange(obj, value, text) {
   var formObj = document.form;
	period_change_based_on_rev_month();
}

/**
 * f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
 */
function f_bse_qtr_cd_OnChange(obj, value, text) {
	period_change_based_on_rev_month();
}

/**
* f_ofc_vw_cd 바뀌었을때 office 콤보 셋팅
*/
function f_ofc_vw_cd_OnChange(obj, value, text) {
	var formObj = document.form;
}

/**
* f_rhq_cd 바뀌었을때 office 콤보 셋팅
*/
function f_rhq_cd_OnChange(obj, value, text) {
	var formObj = document.form;
	if (value != "All") {
	 	var param = "f_cmd=" + SEARCH01
	     + "&code_name=office"
	     + "&code_param=" + value
	     + "&all_flag=All";	// Trade

	 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, formObj.f_rgn_ofc_cd, "code", "name");

	} else {
		formObj.f_rgn_ofc_cd.RemoveAll();
		formObj.f_rgn_ofc_cd.InsertItem(0, "All", "All");
	}
	formObj.f_rgn_ofc_cd.Index = 0;
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
	    + "&code_param=IAS|"+formObj.f_sub_trd_cd.Code+"|"+formObj.f_ias_rgn_cd.Code
	    + "&all_flag=All";
	
	 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, formObj.f_rlane_cd, "code", "name");
	 	formObj.f_rlane_cd.Index = 0;
 	} else {
		formObj.f_rlane_cd.RemoveAll();
		formObj.f_rlane_cd.InsertItem(0, "All", "All");
		formObj.f_rlane_cd.Index = 0; 
 	}
}


/**
 * f_rlane_cd 바뀌었을때 POL, POD 변경
 */
function f_rlane_cd_OnChange(obj, value, text) {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];

	if(value != "" && value != "All") {
		var code_name  = new Array("polCdSector", "podCdSector");
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
	} else {
		formObj.f_pol_cd.RemoveAll();
		formObj.f_pol_cd.InsertItem(0, "All", "All");
		formObj.f_pol_cd.Index = 0;
		formObj.f_pod_cd.RemoveAll();
		formObj.f_pod_cd.InsertItem(0, "All", "All");
		formObj.f_pod_cd.Index = 0; 
 	}
}

 /**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 **/
 function obj_keypress(){
	switch(event.srcElement.dataformat){
    	case "int":
	        //숫자만입력하기
	        ComKeyOnlyNumber(event.srcElement);
	        break;
        default:
            //숫자만입력하기(정수,날짜,시간)
            ComKeyOnlyNumber(event.srcElement);
    }
}

function obj_change() {
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	switch(srcName) {
		case "f_fm_wk":
			if ( formObj.f_fm_wk.value != "" ) {
				// Week 형식 체크
				var ret = ComIsWeek(formObj.f_fm_wk.value);

				if ( !ret ) {
					ComShowCodeMessage("COM12187", "WW");
					formObj.f_fm_wk.value = "";
				} else {
					formObj.f_fm_wk.value = ComLpad(formObj.f_fm_wk.value, 2, '0');

					if ( formObj.f_to_wk.value != "" ) {
						// To Week 가 From Week 보다 큰지 체크
						if ( formObj.f_fm_wk.value > formObj.f_to_wk.value ) {
							ComShowCodeMessage("COM12133", "To week", "from week", "later");
							formObj.f_to_wk.value = "";
							formObj.f_to_wk.focus();
						}
					}
				}
			}
			break;

		case "f_to_wk":
			if ( formObj.f_to_wk.value != "" ) {
				// Week 형식 체크
				var ret = ComIsWeek(formObj.f_to_wk.value);

				if ( !ret ) {
					ComShowCodeMessage("COM12187", "WW");
					formObj.f_to_wk.value = "";
				} else {
					formObj.f_to_wk.value = ComLpad(formObj.f_to_wk.value, 2, '0');

					if ( formObj.f_fm_wk.value != "" ) {
						// To Week 가 From Week 보다 큰지 체크
						if ( formObj.f_fm_wk.value > formObj.f_to_wk.value ) {
							ComShowCodeMessage("COM12133", "To week", "from week", "later");
							formObj.f_to_wk.value = "";
							formObj.f_to_wk.focus();
						}
					}
				}
			}
			break;

		case "f_fm_mon":
			if ( formObj.f_fm_mon.value != "" ) {
				// Month 형식 체크
				var ret = ComIsMonth(formObj.f_fm_mon.value);

				if ( !ret ) {
					ComShowCodeMessage("COM12187", "MM");
					formObj.f_fm_mon.value = "";
					formObj.f_fm_mon.focus();
				} else {
					formObj.f_fm_mon.value = ComLpad(formObj.f_fm_mon.value, 2, '0');

					if ( formObj.f_to_mon.value != "" ) {
						// To Month 가 From Month 보다 큰지 체크
						if ( formObj.f_fm_mon.value > formObj.f_to_mon.value ) {
							ComShowCodeMessage("COM12133", "To month", "from month", "later");
							formObj.f_to_mon.value = "";
							formObj.f_to_mon.focus();
						}
					}
				}
			}
			break;

		case "f_to_mon":
			if ( formObj.f_to_mon.value != "" ) {
				// Month 형식 체크
				var ret = ComIsMonth(formObj.f_to_mon.value);

				if ( !ret ) {
					ComShowCodeMessage("COM12187", "MM");
					formObj.f_to_mon.value = "";
					formObj.f_to_mon.focus();
				} else {
					formObj.f_to_mon.value = ComLpad(formObj.f_to_mon.value, 2, '0');

					if(formObj.f_fm_mon.value != ""){
						// To Month 가 From Month 보다 큰지 체크
						if ( formObj.f_fm_mon.value > formObj.f_to_mon.value ) {
							ComShowCodeMessage("COM12133", "To month", "from month", "later");
							formObj.f_to_mon.value = "";
							formObj.f_to_mon.focus();
						}
					}
				}
			}
			break;
	} // end switch
}

function obj_click() {
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	with(formObj) {
		switch(srcName) {
			case "chk_week":
				if ( chk_week.checked ) {
					div_monwk.innerHTML   = "Week";
					f_fm_mon.value        = "";
            		f_to_mon.value        = "";
					div_wk.style.display  = "inline";
					div_mon.style.display = "none";
				} else {
					div_monwk.innerHTML   = "Month";
					f_fm_wk.value         = "";
            		f_to_wk.value         = "";
					div_wk.style.display  = "none";
					div_mon.style.display = "inline";
				}
				break;

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
				
			case "f_chk_pair":
		    	if(formObj.f_chk_pair.checked){
		    		div_main.style.display = "inline";
		    		div_main_sel.style.display = "inline";
		    	}else{
		    		div_main.style.display = "none";
		    		div_main_sel.style.display = "none";
		    	}
		    	break;
		}
	}
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj, formObj, sAction){
	var qta = ComGetObjValue(formObj.f_bse_qtr_cd); //Quarter
	var qtaWkArr = new Array();
	qtaWkArr["1Q"] = new Array("00","13");
	qtaWkArr["2Q"] = new Array("14","26");
	qtaWkArr["3Q"] = new Array("27","39");
	qtaWkArr["4Q"] = new Array("40","53");
	switch(sAction) {
		case IBSEARCH:  // 화면 조회시
			if(formObj.chk_week.checked){ //week 체크시
//				if(formObj.f_fm_wk.value != "" && formObj.f_to_wk.value != ""){
//		 			if(formObj.f_fm_wk.value < qtaWkArr[qta][0] || formObj.f_to_wk.value > qtaWkArr[qta][1]){
//		 					ComShowCodeMessage('SQM00025',qta); //Duration doesn't include {?msg1}
//		 					return false;
//		 			}
//		 		}else // 3Q에 Week를 40주로 검색하거나 하는 경우에 validation이 걸려, 해제함(실제로 데이터는 저런 경우가 있으므로)
		 			if((formObj.f_fm_wk.value == "" && formObj.f_to_wk.value != "") || (formObj.f_fm_wk.value != "" && formObj.f_to_wk.value == "")){
					ComShowCodeMessage('SQM00024','Week');
					return false;
				}
			}else{ //month
				if(formObj.f_fm_mon.value != "" && formObj.f_to_mon.value != ""){
		 			if(formObj.f_fm_mon.value < qtaMonArr[qta][0] || formObj.f_to_mon.value > qtaMonArr[qta][1]){
		 					ComShowCodeMessage('SQM00025',qta); //Duration doesn't include {?msg1}
		 					return false;
		 			}
		 		}else if((formObj.f_fm_mon.value == "" && formObj.f_to_mon.value != "") || (formObj.f_fm_mon.value != "" && formObj.f_to_mon.value == "")){
					ComShowCodeMessage('SQM00024','Month');
					return false;
				}
			}
			//pair check 시 필수 입력 체크
			if(formObj.f_chk_pair.checked){
				if(formObj.f_sub_trd_cd.Code == "" || formObj.f_sub_trd_cd.Code == "All"){
					ComShowCodeMessage('SQM00013','Sub Trade');
					return false;
				}
				if(formObj.f_rlane_cd.Code == "" || formObj.f_rlane_cd.Code == "All"){
					ComShowCodeMessage('SQM00013','R/Lane');
					return false;
				}
				if(formObj.f_trd_dir.checked){
					if(formObj.f_hul_bnd_cd.Code == "" || formObj.f_hul_bnd_cd.Code == "All"){
						ComShowCodeMessage('SQM00013','Trade Dir.');
						return false;
					}
				}else{
					if(formObj.f_dir_cd.Code == "" || formObj.f_dir_cd.Code == "All"){
						ComShowCodeMessage('SQM00013','Lane Bound');
						return false;
					}
				}
			}
			break;
			
		case "IBSEARCH02":  // 화면 조회시
			if(formObj.chk_week.checked){ //week 체크시
//				if(formObj.f_fm_wk.value != "" && formObj.f_to_wk.value != ""){
//		 			if(formObj.f_fm_wk.value < qtaWkArr[qta][0] || formObj.f_to_wk.value > qtaWkArr[qta][1]){
//		 					ComShowCodeMessage('SQM00025',qta); //Duration doesn't include {?msg1}
//		 					return false;
//		 			}
//		 		}else // 3Q에 Week를 40주로 검색하거나 하는 경우에 validation이 걸려, 해제함(실제로 데이터는 저런 경우가 있으므로)
		 			if((formObj.f_fm_wk.value == "" && formObj.f_to_wk.value != "") || (formObj.f_fm_wk.value != "" && formObj.f_to_wk.value == "")){
					ComShowCodeMessage('SQM00024','Week');
					return false;
				}
			}else{ //month
				if(formObj.f_fm_mon.value != "" && formObj.f_to_mon.value != ""){
		 			if(formObj.f_fm_mon.value < qtaMonArr[qta][0] || formObj.f_to_mon.value > qtaMonArr[qta][1]){
		 					ComShowCodeMessage('SQM00025',qta); //Duration doesn't include {?msg1}
		 					return false;
		 			}
		 		}else if((formObj.f_fm_mon.value == "" && formObj.f_to_mon.value != "") || (formObj.f_fm_mon.value != "" && formObj.f_to_mon.value == "")){
					ComShowCodeMessage('SQM00024','Month');
					return false;
				}
			}
			//pair check 시 필수 입력 체크
			if(formObj.f_chk_pair.checked){
				if(formObj.f_sub_trd_cd.Code == "" || formObj.f_sub_trd_cd.Code == "All"){
					ComShowCodeMessage('SQM00013','Sub Trade');
					return false;
				}
				if(formObj.f_rlane_cd.Code == "" || formObj.f_rlane_cd.Code == "All"){
					ComShowCodeMessage('SQM00013','R/Lane');
					return false;
				}
				if(formObj.f_trd_dir.checked){
					if(formObj.f_hul_bnd_cd.Code == "" || formObj.f_hul_bnd_cd.Code == "All"){
						ComShowCodeMessage('SQM00013','Trade Dir.');
						return false;
					}
				}else{
					if(formObj.f_dir_cd.Code == "" || formObj.f_dir_cd.Code == "All"){
						ComShowCodeMessage('SQM00013','Lane Bound');
						return false;
					}
				}
			}
			break;
	}
	return true;
}
/* 개발자 작업  끝 */