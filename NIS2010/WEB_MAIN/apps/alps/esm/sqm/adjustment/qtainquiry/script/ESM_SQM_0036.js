/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0036.js
*@FileTitle      : QTA Inquiry_Yearly Current QTA Report
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.08
*@LastModifier   : JEONGMIN CHO
*@LastVersion    : 1.0
* 2013.05.08 JEONGMIN CHO
* 1.0 Creation
* 2013.11.11 박은주 [CHM-201327449] SQM 몇몇 화면 내 틀 고정 기능 추가
* 2014.01.02 박은주 [CHM-201328060] Decimal G.RPB 클릭 후 Down Excel 시 G.RPB 항목 다운 안되는것 처리
* 2014.01.09 박은주 [CHM-201428372] SELBB, TYOBB 조직 LEVEL 변경 건
* 2014.01.16 박은주 [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2014.11.21 이혜민 [CHM-201432662] 2015년 연간판매목표 수립 안정화_Current Report 조회 조건변경
* 2015.02.17 이혜민 RHQ, Office 위치 변경
* 2015.04.17 이혜민 [CHM-201535052] 조회시 G.Decimal 데이터 정상적으로 조회되도록 수정  
* 2015.07.21 김용습 [CHM-201537066] 조회된 데이터가 quarterly 수립 데이터인지, yearly 수립 데이터인지 알 수 있도록 QTR CD 컬럼 추가
* 2015.08.06 김용습 [CHM-201537260] [CSR 전환 건] SQM내 Report에 과거 CM 체계 기준 판매목표 데이터 조회 기능 생성 (15년 2Q 이전 데이터 Freeze) 
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
 * @class ESM_SQM_0036 : ESM_SQM_0036 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0036() {
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

				var HeadTitle1 =  "SEQ|Year|Y/Q|Office View|Trade|Sub Trade|Lane|Lane\nBound|Trade\nDirection|Month|Week|VVD|Supply|RHQ|Office|Load|L/F|G.REV|G.RPB|G.RPB|CM Cost(PA)|CM Cost(RA)|CMCB(PA)|CMCB(RA)|CM(PA)|CM(RA)|CMPB(PA)|CMPB(RA)";

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1), 15, 0, true);

				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, false, true, false, false);

				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				// 전체 높이 설정
				style.height = GetSheetHeight(18);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtSeq,		30,		daCenter,	true,	"seq",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"bse_yr",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		40,		daCenter,	true,	"bse_qtr_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		70,		daCenter,	true,	"ofc_vw_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"trd_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		70,		daCenter,	true,	"sub_trd_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"rlane_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		50,		daCenter,	true,	"dir_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"hul_bnd_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"bse_mon",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"bse_wk",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	true,	"vvd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	60,		daRight,	true,	"fnl_bsa_capa",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"rhq_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"rgn_ofc_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"lod_qty",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		80,		daRight,	true,	"ldf_rto",		false,	"|lod_qty|/|fnl_bsa_capa|*100",	dfFloat,	2,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"g_rev",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"grpb",			false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		250,	daRight,	true,	"grpb_decimal",	false,	"",	dfFloat,	13,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"pa_cm_c",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"ra_cm_c",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"pa_cmcb",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"ra_cmcb",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"pa_cm",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"ra_cm",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"pa_cmpb",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"ra_cmpb",		false,	"",	dfInteger,	0,	false,	false);

				RangeBackColor(0, 15, 0, 19) = RgbColor(203,210,248);
				RangeBackColor(0, 24, 0, 27) = RgbColor(203,210,248);
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

				var HeadTitle1 =  "SEQ|Year|Y/Q|Office View|Trade|Sub Trade|Lane|Lane\nBound|Trade\nDirection|Month|Week|VVD|Supply|RHQ|Office|Load|L/F|G.REV|G.RPB|G.RPB|CM Cost(PA)|CM Cost(RA)|CMCB(PA)|CMCB(RA)|CM(PA)|CM(RA)|CMPB(PA)|CMPB(RA)";

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1), 15, 0, true);

				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, false, true, false, false);

				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				// 전체 높이 설정
				style.height = GetSheetHeight(18);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtSeq,		30,		daCenter,	true,	"seq",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"bse_yr",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,	40,		daCenter,	true,	"bse_qtr_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		70,		daCenter,	true,	"ofc_vw_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"trd_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		70,		daCenter,	true,	"sub_trd_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"rlane_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		50,		daCenter,	true,	"dir_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"hul_bnd_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"bse_mon",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"bse_wk",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	true,	"vvd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	60,		daRight,	true,	"fnl_bsa_capa",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"rhq_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"rgn_ofc_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"lod_qty",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		80,		daRight,	true,	"ldf_rto",		false,	"|lod_qty|/|fnl_bsa_capa|*100",	dfFloat,	2,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"g_rev",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"grpb",			false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		250,	daRight,	true,	"grpb_decimal",	false,	"",	dfFloat,	13,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"pa_cm_c",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"ra_cm_c",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"pa_cmcb",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"ra_cmcb",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"pa_cm",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"ra_cm",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"pa_cmpb",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"ra_cmpb",		false,	"",	dfInteger,	0,	false,	false);

				RangeBackColor(0, 15, 0, 19) = RgbColor(203,210,248);
				RangeBackColor(0, 24, 0, 27) = RgbColor(203,210,248);
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
			with (comboObj) {
				DropHeight = 300;
				Index      = 1;
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

			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0036GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");

			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComSetYear(arrXml[1]);
			if (arrXml.length > 2)
				ComXml2ComboItem(arrXml[2], formObj.f_ofc_lvl, "code", "name");
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], formObj.f_rhq_cd, "code", "name");
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], formObj.f_ofc_vw_cd, "code", "name");
			if (arrXml.length > 5)
				ComXml2ComboItem(arrXml[5], formObj.f_trd_cd, "code", "name");
			if (arrXml.length > 6)
				ComXml2ComboItem(arrXml[6], formObj.f_dir_cd, "code", "name");
			if (arrXml.length > 7)
				ComXml2ComboItem(arrXml[7], formObj.f_trd_dir, "code", "name");

			ComOpenWait(false);
			break;

		case IBSEARCH:          // 화면 조회 시
			if (!validateForm(sheetObj, formObj, sAction)) return;

			ComOpenWait(true);

			formObj.f_cmd.value = SEARCH;

			sheetObj.DoSearch("ESM_SQM_0036GS.do", FormQueryString(formObj));

			ComOpenWait(false);
			break;
			
		case "IBSEARCH02":          // 화면 조회 시
			if (!validateForm(sheetObj, formObj, sAction)) return;

//			ComOpenWait(true);

			formObj.f_cmd.value = SEARCH02;

			sheetObj.DoSearch("ESM_SQM_0036GS.do", FormQueryString(formObj));

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

			var param = "f_cmd="         + COMMAND01
			          + "&f_bse_tp_cd="  + ComGetObjValue(formObj.f_bse_tp_cd)
			          + "&f_year_tp_cd=" + ComGetObjValue(formObj.f_year_tp_cd)
			          + "&f_bse_yr="     + ComGetObjValue(formObj.f_bse_yr)
			          + "&f_ofc_vw_cd="  + ComGetObjValue(formObj.f_ofc_vw_cd)
			          + "&f_ofc_lvl=03"
			          + "&f_chk_week=W"
			          + "&f_chk_vvd=V";
			
			document.location.href = "ESM_SQM_0036DL.do?" + param;
			
			ComOpenWait(false);
			break;
			
		case "RawDataDownExcelPreviousVersion":		// Raw Data 엑셀 다운로드
			ComOpenWait(true);

			var param = "f_cmd="         + COMMAND02
			          + "&f_bse_tp_cd="  + ComGetObjValue(formObj.f_bse_tp_cd)
			          + "&f_year_tp_cd=" + ComGetObjValue(formObj.f_year_tp_cd)
			          + "&f_bse_yr="     + ComGetObjValue(formObj.f_bse_yr)
			          + "&f_ofc_vw_cd="  + ComGetObjValue(formObj.f_ofc_vw_cd)
			          + "&f_ofc_lvl=03"
			          + "&f_chk_week=W"
			          + "&f_chk_vvd=V";
			
			document.location.href = "ESM_SQM_0036DL.do?" + param;
			
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
	var chk_decimal = formObj.f_chk_decimal.checked;

	if ( ofc_lvl == "01" ) {
		sheetObj.ColHidden("rhq_cd")     = true;
		sheetObj.ColHidden("rgn_ofc_cd") = true;
		sheetObj.ColHidden("ldf_rto")    = false;

		var num = (sheetObj.SumValue(0, "lod_qty") / sheetObj.SumValue(0, "fnl_bsa_capa") * 100).toFixed(2);

		sheetObj.SumText(0, "ldf_rto") = num;
	} else if ( ofc_lvl == "02" ) {
		sheetObj.ColHidden("rhq_cd")     = false;
		sheetObj.ColHidden("rgn_ofc_cd") = true;
		sheetObj.ColHidden("ldf_rto")    = true;

		sheetObj.SumText(0, "fnl_bsa_capa") = "";
	} else if ( ofc_lvl == "03" ) {
		sheetObj.ColHidden("rhq_cd")     = false;
		sheetObj.ColHidden("rgn_ofc_cd") = false;
		sheetObj.ColHidden("ldf_rto")    = true;

		sheetObj.SumText(0, "fnl_bsa_capa") = "";
	}

	sheetObj.SumText(0, "grpb")         = ComAddComma((sheetObj.SumValue(0, "g_rev")   / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "grpb_decimal") = ComAddComma((sheetObj.SumValue(0, "g_rev")   / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "pa_cmcb")      = ComAddComma((sheetObj.SumValue(0, "pa_cm_c") / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "ra_cmcb")      = ComAddComma((sheetObj.SumValue(0, "ra_cm_c") / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "pa_cmpb")      = ComAddComma((sheetObj.SumValue(0, "pa_cm")   / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "ra_cmpb")      = ComAddComma((sheetObj.SumValue(0, "ra_cm")   / sheetObj.SumValue(0, "lod_qty")).toFixed(0));

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

	if ( chk_decimal ) {
		sheetObjects[0].ColHidden("grpb")         = true;
		sheetObjects[0].ColHidden("grpb_decimal") = false;
	} else {
		sheetObjects[0].ColHidden("grpb")         = false;
		sheetObjects[0].ColHidden("grpb_decimal") = true;
	}

	sheetObj.SumText(0, "seq")    = "";
	sheetObj.SumText(0, "trd_cd") = "TOTAL";
	
	if(sheetObj.RowCount > 0){
		ComBtnEnable("btn_DownExcel");
		ComBtnEnable("btn_RawDataDownExcel");
	}else{
		ComBtnDisable("btn_DownExcel");
//		ComBtnDisable("btn_RawDataDownExcel");
	}
	
	if(ComGetObjValue(formObj.f_year_tp_cd) == "C"){
		sheetObj.ColHidden("bse_qtr_cd")     = false;
	}else{
		sheetObj.ColHidden("bse_qtr_cd")     = true;
	}
}

function sheet2_OnSearchEnd(sheetObj, ErrMsg){
	var formObj     = document.form;
	var ofc_lvl     = ComGetObjValue(formObj.f_ofc_lvl);
	var chk_week    = formObj.f_chk_week.checked;
	var chk_vvd     = formObj.f_chk_vvd.checked;
	var chk_decimal = formObj.f_chk_decimal.checked;

	if ( ofc_lvl == "01" ) {
		sheetObj.ColHidden("rhq_cd")     = true;
		sheetObj.ColHidden("rgn_ofc_cd") = true;
		sheetObj.ColHidden("ldf_rto")    = false;

		var num = (sheetObj.SumValue(0, "lod_qty") / sheetObj.SumValue(0, "fnl_bsa_capa") * 100).toFixed(2);

		sheetObj.SumText(0, "ldf_rto") = num;
	} else if ( ofc_lvl == "02" ) {
		sheetObj.ColHidden("rhq_cd")     = false;
		sheetObj.ColHidden("rgn_ofc_cd") = true;
		sheetObj.ColHidden("ldf_rto")    = true;

		sheetObj.SumText(0, "fnl_bsa_capa") = "";
	} else if ( ofc_lvl == "03" ) {
		sheetObj.ColHidden("rhq_cd")     = false;
		sheetObj.ColHidden("rgn_ofc_cd") = false;
		sheetObj.ColHidden("ldf_rto")    = true;

		sheetObj.SumText(0, "fnl_bsa_capa") = "";
	}

	sheetObj.SumText(0, "grpb")         = ComAddComma((sheetObj.SumValue(0, "g_rev")   / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "grpb_decimal") = ComAddComma((sheetObj.SumValue(0, "g_rev")   / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "pa_cmcb")      = ComAddComma((sheetObj.SumValue(0, "pa_cm_c") / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "ra_cmcb")      = ComAddComma((sheetObj.SumValue(0, "ra_cm_c") / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "pa_cmpb")      = ComAddComma((sheetObj.SumValue(0, "pa_cm")   / sheetObj.SumValue(0, "lod_qty")).toFixed(0));
	sheetObj.SumText(0, "ra_cmpb")      = ComAddComma((sheetObj.SumValue(0, "ra_cm")   / sheetObj.SumValue(0, "lod_qty")).toFixed(0));

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

	if ( chk_decimal ) {
		sheetObjects[1].ColHidden("grpb")         = true;
		sheetObjects[1].ColHidden("grpb_decimal") = false;
	} else {
		sheetObjects[1].ColHidden("grpb")         = false;
		sheetObjects[1].ColHidden("grpb_decimal") = true;
	}

	sheetObj.SumText(0, "seq")    = "";
	sheetObj.SumText(0, "trd_cd") = "TOTAL";
	
	if(sheetObj.RowCount > 0){
		ComBtnEnable("btn_DownExcel");
		ComBtnEnable("btn_RawDataDownExcel");
	}else{
		ComBtnDisable("btn_DownExcel");
//		ComBtnDisable("btn_RawDataDownExcel");
	}
	
	if(ComGetObjValue(formObj.f_year_tp_cd) == "C"){
		sheetObj.ColHidden("bse_qtr_cd")     = false;
	}else{
		sheetObj.ColHidden("bse_qtr_cd")     = true;
	}
}

/**
 * 화면 오픈시 Year 세팅
 */
function ComSetYear(xml) {
	var formObj = document.form;
	var arrData = ComSqmGetXmlValue(xml);
	var arrCode = arrData.split("-");
	formObj.f_bse_yr.Code = arrCode[0];
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
 	office_change();
 	rlane_change();
 }

/**
 * f_ofc_vw_cd 바뀌었을때 office 콤보 셋팅
 */
function f_ofc_vw_cd_OnChange(obj, value, text) {
	var formObj = document.form;
	office_change();
	rlane_change();
}

/**
 * f_rhq_cd 바뀌었을때 office 콤보 셋팅
 */
function f_rhq_cd_OnChange(obj, value, text) {
	office_change();
}

/**
 * f_trd_cd 바뀌었을때 rlane 콤보 셋팅
 */
function f_trd_cd_OnChange(obj, value, text) {
	rlane_change();
}

///**
// * f_bse_yr, f_ofc_vw_cd, f_rhq_cd가 바뀌었을때 office 콤보 setting
// */
//function office_change() {
//	var formObj   = document.form;
//	var bse_yr    = ComGetObjValue(formObj.f_bse_yr);
//	var ofc_vw_cd = ComGetObjValue(formObj.f_ofc_vw_cd);
//	var rhq_cd    = ComGetObjValue(formObj.f_rhq_cd);
//
//	if ( bse_yr != "" && ofc_vw_cd != "" && rhq_cd != "" ) {
//		var param = "f_cmd=" + SEARCH02
//		          + "&code_name=activeOfc"
//		          + "&code_param= "
//		          + "&all_flag=All"
//		          + "&" + FormQueryString(formObj);
//
//		var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
//		var arrXml = xmlStr.split("|$$|");
//
//		if ( arrXml.length > 0 )
//			ComXml2ComboItem(arrXml[0], formObj.f_rgn_ofc_cd, "code", "name");
//
//		formObj.f_rgn_ofc_cd.Index = 0;
//	}
//}
/**
 * onChange event
 * f_rhq_cd 바뀌었을때  f_rgn_ofc_cd 콤보조회
 */
function office_change() {
	var formObj = document.form;
	var rhq_cd    = ComGetObjValue(formObj.f_rhq_cd);	
	
	if (rhq_cd != "All") {
	 	var param = "f_cmd=" + SEARCH01
	     + "&code_name=office"
	     + "&code_param=" + rhq_cd
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
 * f_bse_yr, f_ofc_vw_cd, f_trd_cd가 바뀌었을때 rlane 콤보 setting
 */
function rlane_change() {
	var formObj   = document.form;
	var sheetObj  = sheetObjects[0];
	var param     = "";

	var bse_tp_cd = ComGetObjValue(formObj.f_bse_tp_cd);
	var bse_yr    = ComGetObjValue(formObj.f_bse_yr);
	var ofc_vw_cd = ComGetObjValue(formObj.f_ofc_vw_cd);
	var trd_cd    = ComGetObjValue(formObj.f_trd_cd);
	var rlane_cd    = ComGetObjValue(formObj.f_rlane_cd);

	if ( bse_yr != "" && ofc_vw_cd != "" && trd_cd != "" ) {
		param =       bse_tp_cd
	          + "|" + bse_yr
	          + "|" + "00"
	          + "|" + trd_cd;

		var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=adjLane&code_param=" + param + "&all_flag=All");
		ComXml2ComboItem(sXml, formObj.f_rlane_cd, "code", "name");
		
		// 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
		var rlane_index = SearchIndex(formObj.f_rlane_cd, rlane_cd);
		formObj.f_rlane_cd.Index = rlane_index;

	} else {
		formObj.f_rlane_cd.RemoveAll();
		formObj.f_rlane_cd.InsertItem(0, "All", "All");
		formObj.f_rlane_cd.Index = 0;
	}
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	var formObject   = document.form;
	var srcName      = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue     = window.event.srcElement.getAttribute("value");

	if ( ComChkLen(srcValue, srcMaxLength) == "2" ) {
		ComSetNextFocus();
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

			case "f_gubun":
				if ( f_gubun.checked ) {
					div_dir.innerHTML         = "Trade Dir.";
					div_trd_dir.style.display = "inline";
		      		div_dir_cd.style.display  = "none";
				} else {
					div_dir.innerHTML         = "Lane Bound";
					div_trd_dir.style.display = "none";
					div_dir_cd.style.display  = "inline";
				}
				break;
		}
	}
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj, formObj, sAction){
 	switch(sAction) {
 		case IBSEARCH:  // 화면 조회시
 			var period_fm = "";
 			var period_to = "";

 			if ( formObj.f_chk_week.checked || formObj.f_chk_vvd.checked ) {
 				if ( formObj.chk_week.checked ) {
 					period_fm = ComGetObjValue(formObj.f_fm_wk);
 					period_to = ComGetObjValue(formObj.f_to_wk);

 					if ( period_fm == "" || period_to == "" || period_to - period_fm > 12 ) {
 						ComShowCodeMessage('SQM00035');
 						return false;
 					}
 				} else {
 					period_fm = ComGetObjValue(formObj.f_fm_mon);
 					period_to = ComGetObjValue(formObj.f_to_mon);

 					if ( period_fm == "" || period_to == "" || period_to - period_fm > 2 ) {
 						ComShowCodeMessage('SQM00035');
 						return false;
 					}
 				}
 			}

 			break;
 			
 		case "IBSEARCH02":  // 화면 조회시
 			var period_fm = "";
 			var period_to = "";

 			if ( formObj.f_chk_week.checked || formObj.f_chk_vvd.checked ) {
 				if ( formObj.chk_week.checked ) {
 					period_fm = ComGetObjValue(formObj.f_fm_wk);
 					period_to = ComGetObjValue(formObj.f_to_wk);

 					if ( period_fm == "" || period_to == "" || period_to - period_fm > 12 ) {
 						ComShowCodeMessage('SQM00035');
 						return false;
 					}
 				} else {
 					period_fm = ComGetObjValue(formObj.f_fm_mon);
 					period_to = ComGetObjValue(formObj.f_to_mon);

 					if ( period_fm == "" || period_to == "" || period_to - period_fm > 2 ) {
 						ComShowCodeMessage('SQM00035');
 						return false;
 					}
 				}
 			}

 			break;
 	}
 	return true;
}
/* 개발자 작업  끝 */