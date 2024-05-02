/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0508.js
*@FileTitle      : Current KPI Report
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.25
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.25 이혜민
* 1.0 Creation
* 2013.11.11 박은주 [CHM-201327449] SQM 몇몇 화면 내 틀 고정 기능 추가
* 2014.01.09 박은주 [CHM-201428372] SELBB, TYOBB 조직 LEVEL 변경 건
* 2014.01.16 박은주 [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2014.11.07 이혜민 [CHM-201432524] Current KPI Report 화면 내 Trade Direction 조건 추가
* 2015.01.22 김용습 [CHM-201533807] Rev Month 기준으로 관련 화면의 period를 변경
* 2015.08.06 김용습 [CHM-201537260] [CSR 전환 건] SQM내 Report에 과거 CM 체계 기준 판매목표 데이터 조회 기능 생성 (15년 2Q 이전 데이터 Freeze) 
* 2015.09.17 김용습 [CHM-201538072] [CSR 전환건] Report 선택 옵션 중 Week 선택 시 Validation 삭제 요청
* 2015.11.20 김용습 [CHM-201538493] [CSR 전환건] Current KPI Report 화면 보완 (조회 조건 Week → Month 변경, Raw Data Export 버튼 추가)
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_SQM_0508 : ESM_SQM_0508 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0508() {
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

var qtaWeekArr0508 = new Array();
qtaWeekArr0508["1Q"] = new Array("00","13");
qtaWeekArr0508["2Q"] = new Array("14","26");
qtaWeekArr0508["3Q"] = new Array("27","39");
qtaWeekArr0508["4Q"] = new Array("40","53");
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
	var sheetObj = sheetObjects[0];
	var formObj  = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "f_bse_tp_cd":
				f_bse_tp_cd_0508_OnChange();
				break;

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
				
			case "rdoOp_cd":
				if (formObj.rdoOp_cd[0].checked) {  
					document.getElementById("tabLayer1").style.display= "inline";
					document.getElementById("tabLayer2").style.display= "none";
				} else if (formObj.rdoOp_cd[1].checked) {  
					document.getElementById("tabLayer1").style.display= "none";
					document.getElementById("tabLayer2").style.display= "inline";
				}
				break;
			case "btn_RawDataDownExcel":
				doActionIBSheet(sheetObj, formObj, "RawDataDownExcel");
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
	loadingMode = false;

	sheetObjects[0].ColHidden("rhq_cd") = true;
	sheetObjects[0].ColHidden("rgn_ofc_cd") = true;
	sheetObjects[0].ColHidden("bse_wk") = true;
	sheetObjects[0].ColHidden("vvd") = true;
	sheetObjects[0].ColHidden("grpb_decimal") = true;

}

function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm('change', 'obj_change', formObj);
	axon_event.addListenerForm('click',    'obj_click',  formObj);
	axon_event.addListenerForm('keypress', 'obj_keypress', formObj);
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

				var HeadTitle1 =  "STS|SEQ|Year|RHQ|Office|Trade|Sub\nTrade|Lane|Lane\nBound|Trade\nBound|Trade\nDirection|Month|Week|VVD|Supply|Load|G.RPB|G.RPB|G.REV|CM Cost(PA)|CM Cost(RA)|CMCB(PA)|CMCB(RA)|CM(PA)|CM(RA)|CMPB(PA)|CMPB(RA)";

				var headCount = ComCountHeadTitle(HeadTitle1);
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 14, 0, true);

				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, false, true, false, false);

				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				// 전체 높이 설정
				style.height = GetSheetHeight(17);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtStatus,		30,		daCenter,	true,	"ibflag",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtSeq,			40,		daCenter,	true,	"seq",					false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,		daCenter,	true,	"bse_yr",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	true,	"rhq_cd",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	true,	"rgn_ofc_cd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			55,		daCenter,	true,	"trd_cd",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,		daCenter,	true,	"sub_trd_cd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			65,		daCenter,	true,	"rlane_cd",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	true,	"dir_cd",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	true,	"conv_dir_cd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	true,	"hul_bnd_cd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,		daCenter,	true,	"bse_mon",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,		daCenter,	true,	"bse_wk",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			90,		daCenter,	true,	"vvd",					false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		70,		daRight,	true,	"fnl_bsa_capa",			false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		85,		daRight,	true,	"lod_qty",				false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			85,		daRight,	true,	"grpb",					false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			250,	daRight,	true,	"grpb_decimal",			false,	"",	dfNumber,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		85,		daRight,	true,	"grev",					false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		85,		daRight,	true,	"pa_cm_cost",			false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		85,		daRight,	true,	"ra_cm_cost",			false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			85,		daRight,	true,	"pa_cmcb",				false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			85,		daRight,	true,	"ra_cmcb",				false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		85,		daRight,	true,	"pa_cm",				false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		85,		daRight,	true,	"ra_cm",				false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			85,		daRight,	true,	"pa_cmpb",				false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			85,		daRight,	true,	"ra_cmpb",				false,	"",	dfInteger,		0,	false,	false);
				//CountPosition = 0;
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

				var HeadTitle1 =  "STS|SEQ|Year|RHQ|Office|Trade|Sub\nTrade|Lane|Lane\nBound|Trade\nBound|Trade\nDirection|Month|Week|VVD|Supply|Load|G.RPB|G.RPB|G.REV|CM Cost(PA)|CM Cost(RA)|CMCB(PA)|CMCB(RA)|CM(PA)|CM(RA)|CMPB(PA)|CMPB(RA)";

				var headCount = ComCountHeadTitle(HeadTitle1);
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 14, 0, true);

				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, false, true, false, false);

				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				// 전체 높이 설정
				style.height = GetSheetHeight(17);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtStatus,		30,		daCenter,	true,	"ibflag",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtSeq,			40,		daCenter,	true,	"seq",					false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,		daCenter,	true,	"bse_yr",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	true,	"rhq_cd",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	true,	"rgn_ofc_cd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			55,		daCenter,	true,	"trd_cd",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,		daCenter,	true,	"sub_trd_cd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			65,		daCenter,	true,	"rlane_cd",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	true,	"dir_cd",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	true,	"conv_dir_cd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	true,	"hul_bnd_cd",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,		daCenter,	true,	"bse_mon",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,		daCenter,	true,	"bse_wk",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			90,		daCenter,	true,	"vvd",					false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		70,		daRight,	true,	"fnl_bsa_capa",			false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		85,		daRight,	true,	"lod_qty",				false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			85,		daRight,	true,	"grpb",					false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			250,	daRight,	true,	"grpb_decimal",			false,	"",	dfNumber,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		85,		daRight,	true,	"grev",					false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		85,		daRight,	true,	"pa_cm_cost",			false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		85,		daRight,	true,	"ra_cm_cost",			false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			85,		daRight,	true,	"pa_cmcb",				false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			85,		daRight,	true,	"ra_cmcb",				false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		85,		daRight,	true,	"pa_cm",				false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		85,		daRight,	true,	"ra_cm",				false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			85,		daRight,	true,	"pa_cmpb",				false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			85,		daRight,	true,	"ra_cmpb",				false,	"",	dfInteger,		0,	false,	false);
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
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0508GS.do", FormQueryString(formObj));
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
				ComXml2ComboItem(arrXml[6], formObj.f_ofc_lvl, "code", "name");
			if (arrXml.length > 7)
				ComXml2ComboItem(arrXml[7], formObj.f_hul_bnd_cd, "code", "name");
			ComOpenWait(false);
			break;

		case IBSEARCH:          // 화면 조회 시
			sheetObj.WaitImageVisible = false;
			if (!validateForm(sheetObj, formObj, sAction)) return;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("ESM_SQM_0508GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchXml(sXml);

			//By Week  체크시
        	if(formObj.f_chk_week.checked){
        		sheetObj.ColHidden("bse_wk") = false;
        	}else{
        		sheetObj.ColHidden("bse_wk") = true;
        	}
        	//By VVD 체크시
        	if(formObj.f_chk_vvd.checked){
        		sheetObj.ColHidden("vvd") = false;
        	}else{
        		sheetObj.ColHidden("vvd") = true;
        	}
			//by Decimal RPB 체크시
			if(formObj.f_chk_decimal.checked){
				sheetObj.ColHidden("grpb_decimal") = false;
				sheetObj.ColHidden("grpb") = true;
			}else if(!formObj.f_chk_decimal.checked){
				sheetObj.ColHidden("grpb_decimal") = true;
				sheetObj.ColHidden("grpb") = false;
			}
			//Office Level
			if (ComGetObjValue(formObj.f_ofc_lvl) == "01") {//Head Office일때
				sheetObj.ColHidden("rhq_cd") = true;
				sheetObj.ColHidden("rgn_ofc_cd") = true;
			} else if (ComGetObjValue(formObj.f_ofc_lvl) == "02"){//RHQ일때
				sheetObj.ColHidden("rhq_cd") = false;
				sheetObj.ColHidden("rgn_ofc_cd") = true;
			}else{//Office일때
				sheetObj.ColHidden("rhq_cd") = false;
				sheetObj.ColHidden("rgn_ofc_cd") = false;
			}

			ComOpenWait(false);
			break;
			
		case "IBSEARCH02":          // 화면 조회 시
			sheetObj.WaitImageVisible = false;
			if (!validateForm(sheetObj, formObj, sAction)) return;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH02;
			var sXml = sheetObj.GetSearchXml("ESM_SQM_0508GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchXml(sXml);

			//By Week  체크시
        	if(formObj.f_chk_week.checked){
        		sheetObj.ColHidden("bse_wk") = false;
        	}else{
        		sheetObj.ColHidden("bse_wk") = true;
        	}
        	//By VVD 체크시
        	if(formObj.f_chk_vvd.checked){
        		sheetObj.ColHidden("vvd") = false;
        	}else{
        		sheetObj.ColHidden("vvd") = true;
        	}
			//by Decimal RPB 체크시
			if(formObj.f_chk_decimal.checked){
				sheetObj.ColHidden("grpb_decimal") = false;
				sheetObj.ColHidden("grpb") = true;
			}else if(!formObj.f_chk_decimal.checked){
				sheetObj.ColHidden("grpb_decimal") = true;
				sheetObj.ColHidden("grpb") = false;
			}
			//Office Level
			if (ComGetObjValue(formObj.f_ofc_lvl) == "01") {//Head Office일때
				sheetObj.ColHidden("rhq_cd") = true;
				sheetObj.ColHidden("rgn_ofc_cd") = true;
			} else if (ComGetObjValue(formObj.f_ofc_lvl) == "02"){//RHQ일때
				sheetObj.ColHidden("rhq_cd") = false;
				sheetObj.ColHidden("rgn_ofc_cd") = true;
			}else{//Office일때
				sheetObj.ColHidden("rhq_cd") = false;
				sheetObj.ColHidden("rgn_ofc_cd") = false;
			}

			ComOpenWait(false);
			break;

		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.Down2Excel(-1, false, false, true);
			ComOpenWait(false);
			break;
			
		case "RawDataDownExcel":		// Raw Data 엑셀 다운로드
			ComOpenWait(true);
			
            if(ComGetObjValue(formObj.f_bse_tp_cd) == 'Q'){
            	var param = "f_cmd="         + COMMAND01
		          + "&f_bse_tp_cd="  + ComGetObjValue(formObj.f_bse_tp_cd)
		          + "&f_bse_yr="     + ComGetObjValue(formObj.f_bse_yr)
		          + "&f_bse_qtr_cd=" + ComGetObjValue(formObj.f_bse_qtr_cd)
		          + "&f_spcl_tgt_cd=" + ComGetObjValue(formObj.f_spcl_tgt_cd)
		          + "&f_trd_cd=All"
		          + "&f_rlane_cd=All"
		          + "&f_rhq_cd=All"
		          + "&f_rgn_ofc_cd=All"
		          + "&f_chk_week=W"
		          + "&f_chk_vvd=V"
		          + "&f_ofc_lvl=03"
				  + "&f_excel=Y";
            }else if(ComGetObjValue(formObj.f_bse_tp_cd) == 'Y'){
            	var param = "f_cmd="         + COMMAND01
		          + "&f_bse_tp_cd="  + ComGetObjValue(formObj.f_bse_tp_cd)
		          + "&f_bse_yr="     + ComGetObjValue(formObj.f_bse_yr)
		          + "&f_bse_qtr_cd=" + ComGetObjValue(formObj.f_bse_qtr_cd)
		          + "&f_spcl_tgt_cd=" + ComGetObjValue(formObj.f_spcl_tgt_cd)
		          + "&f_year_tp_cd=" + ComGetObjValue(formObj.f_year_tp_cd)
		          + "&f_trd_cd=All"
		          + "&f_rlane_cd=All"
		          + "&f_rhq_cd=All"
		          + "&f_rgn_ofc_cd=All"
		          + "&f_chk_week=W"
		          + "&f_chk_vvd=V"
		          + "&f_ofc_lvl=03"
				  + "&f_excel=Y";
            }

			document.location.href = "ESM_SQM_0508DL.do?" + param;

			ComOpenWait(false);
			break;

    }
}

/**
 *조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 * @param sheetObj
 * @param ErrMsg
 */
 function sheet1_OnSearchEnd(sheetObj, ErrMsg){

	sheetObj.SumText(0, "ibflag") = "";
	sheetObj.SumText(0, "bse_yr") = "TOTAL";

	if(comboObjects[5].Code == "01"){
		if(sheetObj.SumValue(0, "fnl_bsa_capa")!=0)
			var num = (sheetObj.SumValue(0, "lod_qty")/sheetObj.SumValue(0, "fnl_bsa_capa")*100).toFixed(2);
		else
			var num = 0.00;
		sheetObj.SumText(0, "ldf_rto") = num;
	}else{
		sheetObj.SumText(0, "fnl_bsa_capa") = "";
	}

	//단가 total값 set
	if(sheetObj.SumValue(0, "lod_qty")!="0"){
		//G.RPB Total = G.REV Total / Load Total
		sheetObj.SumText(0, "grpb")    = AddComma(Math.round(sheetObj.SumValue(0, "grev")/sheetObj.SumValue(0, "lod_qty")));
		sheetObj.SumText(0, "grpb_decimal") = AddComma(sheetObj.SumValue(0, "grev")/sheetObj.SumValue(0, "lod_qty"));
		//CMCB Total = CM Cost Total / Load Total
		sheetObj.SumText(0, "pa_cmcb") = AddComma(Math.round(sheetObj.SumValue(0, "pa_cm_cost")/sheetObj.SumValue(0, "lod_qty")));
		sheetObj.SumText(0, "ra_cmcb") = AddComma(Math.round(sheetObj.SumValue(0, "ra_cm_cost")/sheetObj.SumValue(0, "lod_qty")));
		//CMPB Total = CM Total / Load Total
		sheetObj.SumText(0, "pa_cmpb") = AddComma(Math.round(sheetObj.SumValue(0, "pa_cm")/sheetObj.SumValue(0, "lod_qty")));
		sheetObj.SumText(0, "ra_cmpb") = AddComma(Math.round(sheetObj.SumValue(0, "ra_cm")/sheetObj.SumValue(0, "lod_qty")));

	}else{
		sheetObj.SumText(0, "grpb")    = 0;
		sheetObj.SumText(0, "grpb_decimal") = 0;
		sheetObj.SumText(0, "pa_cmcb") = 0;
		sheetObj.SumText(0, "ra_cmcb") = 0;
		sheetObj.SumText(0, "pa_cmpb") = 0;
		sheetObj.SumText(0, "ra_cmpb") = 0;
	}

}
 
function sheet2_OnSearchEnd(sheetObj, ErrMsg){

		sheetObj.SumText(0, "ibflag") = "";
		sheetObj.SumText(0, "bse_yr") = "TOTAL";

		if(comboObjects[5].Code == "01"){
			if(sheetObj.SumValue(0, "fnl_bsa_capa")!=0)
				var num = (sheetObj.SumValue(0, "lod_qty")/sheetObj.SumValue(0, "fnl_bsa_capa")*100).toFixed(2);
			else
				var num = 0.00;
			sheetObj.SumText(0, "ldf_rto") = num;
		}else{
			sheetObj.SumText(0, "fnl_bsa_capa") = "";
		}

		//단가 total값 set
		if(sheetObj.SumValue(0, "lod_qty")!="0"){
			//G.RPB Total = G.REV Total / Load Total
			sheetObj.SumText(0, "grpb")    = AddComma(Math.round(sheetObj.SumValue(0, "grev")/sheetObj.SumValue(0, "lod_qty")));
			sheetObj.SumText(0, "grpb_decimal") = AddComma(sheetObj.SumValue(0, "grev")/sheetObj.SumValue(0, "lod_qty"));
			//CMCB Total = CM Cost Total / Load Total
			sheetObj.SumText(0, "pa_cmcb") = AddComma(Math.round(sheetObj.SumValue(0, "pa_cm_cost")/sheetObj.SumValue(0, "lod_qty")));
			sheetObj.SumText(0, "ra_cmcb") = AddComma(Math.round(sheetObj.SumValue(0, "ra_cm_cost")/sheetObj.SumValue(0, "lod_qty")));
			//CMPB Total = CM Total / Load Total
			sheetObj.SumText(0, "pa_cmpb") = AddComma(Math.round(sheetObj.SumValue(0, "pa_cm")/sheetObj.SumValue(0, "lod_qty")));
			sheetObj.SumText(0, "ra_cmpb") = AddComma(Math.round(sheetObj.SumValue(0, "ra_cm")/sheetObj.SumValue(0, "lod_qty")));

		}else{
			sheetObj.SumText(0, "grpb")    = 0;
			sheetObj.SumText(0, "grpb_decimal") = 0;
			sheetObj.SumText(0, "pa_cmcb") = 0;
			sheetObj.SumText(0, "ra_cmcb") = 0;
			sheetObj.SumText(0, "pa_cmpb") = 0;
			sheetObj.SumText(0, "ra_cmpb") = 0;
		}

}

 /**
  * 천단위마다 콤마를 찍어주는 함수
  */
 function AddComma(number){
	 var str=new Array();
	 number=String(number);
	 for(var i=1;i<=number.length;i++){

	  if(i%3)
		  str[number.length-i]=number.charAt(number.length-i); //자리수가 아니면 숫자만삽입
	  else
		  str[number.length-i]=','+number.charAt(number.length-i); //자리수 이면 콤마까지 삽입
	 }
	 return str.join('').replace(/^,/,'');
}
/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj, formObj, sAction){
 	switch(sAction) {
 		case IBSEARCH:  // 화면 조회시에
 			var qta = ComGetObjValue(formObj.f_bse_qtr_cd); //Quarter
 			if(qta != "All"){
	 			if(formObj.f_fm_mon.value != "" && formObj.f_to_mon.value != ""){
	 				if(formObj.f_fm_mon.value < qtaMonArr[qta][0] || formObj.f_to_mon.value > qtaMonArr[qta][1]){
	 						ComShowCodeMessage('SQM00025',qta);
	 						//Duration doesn't include {?msg1}
	 						return false;
	 				}
	 			}else if((formObj.f_fm_mon.value != "" && formObj.f_to_mon.value == "") || (formObj.f_fm_mon.value == "" && formObj.f_to_mon.value != "")){
	 				ComShowCodeMessage('SQM00024','Month');
	 				return false;
	 			}

//	 			if(formObj.f_fm_wk.value != "" && formObj.f_to_wk.value != ""){
//	 				if(formObj.f_fm_wk.value < qtaWeekArr0508[qta][0] || formObj.f_to_wk.value > qtaWeekArr0508[qta][1]){
//	 						ComShowCodeMessage('SQM00025',qta);
//	 						//Duration doesn't include {?msg1}
//	 						return false;
//	 				}
//	 			}else // 3Q에 Week를 40주로 검색하거나 하는 경우에 validation이 걸려, 해제함(실제로 데이터는 저런 경우가 있으므로)
	 				if((formObj.f_fm_wk.value != "" && formObj.f_to_wk.value == "") || (formObj.f_fm_wk.value == "" && formObj.f_to_wk.value != "")){
	 				ComShowCodeMessage('SQM00024','Week');
	 				return false;
	 			}
 			}
     		break;
 	}
 	return true;
}

/**
 *  선택된 Trade 에 해당하는 R.Lane 정보 가져와서 Combo Box 셋팅
 */
function f_trd_cd_OnChange(obj, value, text){
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];

	if (value != "All") {
		var param = "f_cmd=" + SEARCH01
	     + "&code_name=spclAdjLane"
	     + "&code_param=" +ComGetObjValue(formObj.f_bse_tp_cd)
	      + "|" + ComGetObjValue(formObj.f_bse_yr)
	      + "|" + ComGetObjValue(formObj.f_bse_qtr_cd)
	      + "|" + value
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
function f_bse_tp_cd_0508_OnChange() {
	var formObj    = document.form;
	var bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
	var div_qtr    = document.getElementById("div_qtr");
	var div_period = document.getElementById("div_period");
	var f_bse_qtr_cd_idx = formObj.f_bse_qtr_cd.Index;
	if (bse_tp_cd == "Y") { //Yearly 선택
		formObj.f_year_tp_cd[0].checked = true;
		formObj.f_year_tp_cd[0].disabled = false;
		formObj.f_year_tp_cd[1].disabled = false;
		formObj.f_bse_qtr_cd.InsertItem(0, 'All', 'All');
		formObj.f_bse_qtr_cd.Index = 0;
		formObj.f_bse_qtr_cd.BackColor = "white";

	}else{  //Quarterly 선택
		formObj.f_year_tp_cd[0].checked = false;
		formObj.f_year_tp_cd[1].checked = false;
		formObj.f_year_tp_cd[0].disabled = true;
		formObj.f_year_tp_cd[1].disabled = true;
		formObj.f_bse_qtr_cd.DeleteItem("All");
		if(f_bse_qtr_cd_idx == 0){
			formObj.f_bse_qtr_cd.Index = 0;
		}else{
			formObj.f_bse_qtr_cd.Index = f_bse_qtr_cd_idx-1;
		}
		formObj.f_bse_qtr_cd.BackColor = "#CCFFFD"; //필수입력 input1 색으로 변환
	}
}

/**
* f_ofc_lvl 바뀌었을때 RHQ, Office combo를 컨트롤한다.
*
*/
function f_ofc_lvl_OnChange(obj, value, text) {
	var formObj    = document.form;
	var sheetObj = sheetObjects[0];
	var div_rhq    = document.getElementById("div_rhq");
	var div_ofc    = document.getElementById("div_ofc");

	if(value == "01"){//Head Office일때
		div_rhq.style.display = "none";
		div_ofc.style.display = "none";
		formObj.f_rhq_cd.style.display = "none";
		formObj.f_rgn_ofc_cd.style.display = "none";
		formObj.f_rhq_cd.Index = 0;
		formObj.f_rgn_ofc_cd.Index = 0;
	}else if(value == "02"){//RHQ일때
		div_rhq.style.display = "inline";
		div_ofc.style.display = "none";
		formObj.f_rhq_cd.style.display = "inline";
		formObj.f_rgn_ofc_cd.style.display = "none";
		formObj.f_rgn_ofc_cd.Index = 0;
	}else{//Office일때
		div_rhq.style.display = "inline";
		div_ofc.style.display = "inline";
		formObj.f_rhq_cd.style.display = "inline";
		formObj.f_rgn_ofc_cd.style.display = "inline";
	}
}

/**
 *  Month/Week의 유효성 체크
 */
function obj_change(){
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
    switch(srcName) {

        case "f_fm_wk":
        	if(formObj.f_fm_wk.value != ""){
        		//Week 형식 체크
            	var ret = ComIsWeek(formObj.f_fm_wk.value);
            	if(!ret){
					ComShowCodeMessage("COM12187", "WW");
            		formObj.f_fm_wk.value = "";
            	}else{
            		formObj.f_fm_wk.value = ComLpad(formObj.f_fm_wk.value, 2, '0');
            		if(formObj.f_to_wk.value != ""){
            			//To Week가 From Week 보다 큰지 체크
            			if (formObj.f_fm_wk.value > formObj.f_to_wk.value) {
            				ComShowCodeMessage("COM12133", "To week", "from week", "later");
            				formObj.f_to_wk.value = "";
            				formObj.f_to_wk.focus();
            			}
            		}
            	}
        	}
        	break;

        case "f_to_wk":
        	if(formObj.f_to_wk.value != ""){
        		//Week 형식 체크
            	var ret = ComIsWeek(formObj.f_to_wk.value);
            	if(!ret){
					ComShowCodeMessage("COM12187", "WW");
            		formObj.f_to_wk.value = "";
            	}else{
            		formObj.f_to_wk.value = ComLpad(formObj.f_to_wk.value, 2, '0');
            		if(formObj.f_fm_wk.value != ""){
            			//To Week가 From Week 보다 큰지 체크
            			if (formObj.f_fm_wk.value > formObj.f_to_wk.value) {
            				ComShowCodeMessage("COM12133", "To week", "from week", "later");
            				formObj.f_to_wk.value = "";
            				formObj.f_to_wk.focus();
            			}
            		}
            	}
        	}
        	break;

        case "f_fm_mon":
        	if(formObj.f_fm_mon.value != ""){
        		//Month 형식 체크
            	var ret = ComIsMonth(formObj.f_fm_mon.value);
            	if(!ret){
            		ComShowCodeMessage("COM12187", "MM");
            		formObj.f_fm_mon.value = "";
            	}else{
            		formObj.f_fm_mon.value = ComLpad(formObj.f_fm_mon.value, 2, '0');
            		if(formObj.f_to_mon.value != ""){
            			//To Month가 From Month 보다 큰지 체크
            			if (formObj.f_fm_mon.value > formObj.f_to_mon.value) {
            				ComShowCodeMessage("COM12133", "To month", "from month", "later");
            				formObj.f_to_mon.value = "";
            				formObj.f_to_mon.focus();
            			}
            		}
            	}
        	}
        	break;

        case "f_to_mon":
        	if(formObj.f_to_mon.value != ""){
        		//Month 형식 체크
            	var ret = ComIsMonth(formObj.f_to_mon.value);
            	if(!ret){
            		ComShowCodeMessage("COM12187", "MM");
            		formObj.f_to_mon.value = "";
            	}else{
            		formObj.f_to_mon.value = ComLpad(formObj.f_to_mon.value, 2, '0');
            		if(formObj.f_fm_mon.value != ""){
            			//To Month가 From Month 보다 큰지 체크
            			if (formObj.f_fm_mon.value > formObj.f_to_mon.value) {
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

/**
 *  Week 체크시 검색조건의 Month/Week를 변경시켜준다.
 */
function obj_click() {
	var formObj = document.form;
	with(formObj) {
		switch(event.srcElement.name){
            case "chk_week":
            	if(chk_week.checked){
            		f_fm_mon.value = "";
            		f_to_mon.value = "";
            		div_wk.style.display = "inline";
            		div_mon.style.display = "none";
            	}else{
            		f_fm_wk.value = "";
            		f_to_wk.value = "";
            		div_wk.style.display = "none";
            		div_mon.style.display = "inline";
            	}
            	break;
            	
			case "f_trd_dir":
				if ( f_trd_dir.checked ) {
					div_dir.innerHTML         = "Trade Dir.";
					div_trd_dir.style.display = "inline";
		      		div_dir_cd.style.display  = "none";
				} else {
					div_dir.innerHTML         = "Trade Bound";
					div_trd_dir.style.display = "none";
					div_dir_cd.style.display  = "inline";
				}
				break;	
		}
	}
}


/**
 * f_bse_yr가 바뀌었을때 period 의 year 변경
 */
function f_bse_yr_OnChange(obj, value, text) {
	period_change();
	period_change_based_on_rev_month();
}

/**
 * f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
 */
function f_bse_qtr_cd_OnChange(obj, value, text) {
	period_change();
	period_change_based_on_rev_month();
}
/* 개발자 작업  끝 */