/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0501.js
*@FileTitle      : KPI Input by Head Office
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.08
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.08 이혜민
* 1.0 Creation
* 2014.01.16 박은주 [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2015.11.19 김용습 [CHM-201538497] [CSR 전환건] KPI Input by Head Office 화면 보완 (Trade Direction 칼럼 추가)
* 2015.11.27 김용습 [CHM-201538497] [CSR 전환건] KPI Input by Head Office 화면 보완 (Row Add 기능 보완)
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_SQM_0501 : ESM_SQM_0501 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0501() {
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
				f_bse_tp_cd_0501_OnChange();
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

			case "btn_DownExcel":
				doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
				break;

			case "btn_LoadExcel":
				doActionIBSheet(sheetObj, formObj, IBLOADEXCEL);
				break;

			case "btn_RowAdd":
				var selectRow = sheetObj.SelectRow;
				var Row = sheetObj.DataInsert();
				//선택된 row 값 복사
				sheetObj.CellValue2(Row, "bse_yr") 				= sheetObj.CellValue(selectRow, "bse_yr");
				sheetObj.CellValue2(Row, "rhq_cd") 				= sheetObj.CellValue(selectRow, "rhq_cd");
				sheetObj.CellValue2(Row, "trd_cd") 				= sheetObj.CellValue(selectRow, "trd_cd");
				sheetObj.CellValue2(Row, "sub_trd_cd") 			= sheetObj.CellValue(selectRow, "sub_trd_cd");
				sheetObj.CellValue2(Row, "dir_cd") 				= sheetObj.CellValue(selectRow, "dir_cd");
				sheetObj.CellValue2(Row, "conv_dir_cd") 		= sheetObj.CellValue(selectRow, "conv_dir_cd");
				sheetObj.CellValue2(Row, "hul_bnd_cd") 			= sheetObj.CellValue(selectRow, "hul_bnd_cd");
				sheetObj.CellValue2(Row, "bse_qtr_cd") 			= sheetObj.CellValue(selectRow, "bse_qtr_cd");
				sheetObj.CellValue2(Row, "gid_lod_qty") 		= sheetObj.CellValue(selectRow, "gid_lod_qty");
				sheetObj.CellValue2(Row, "gid_grs_rpb_rev") 	= sheetObj.CellValue(selectRow, "gid_grs_rpb_rev");
				sheetObj.CellValue2(Row, "gid_grs_rpb_rev_ttl") = sheetObj.CellValue(selectRow, "gid_grs_rpb_rev_ttl");
				sheetObj.CellValue2(Row, "lod_qty") 			= sheetObj.CellValue(selectRow, "lod_qty");
				sheetObj.CellValue2(Row, "grs_rpb_rev") 		= sheetObj.CellValue(selectRow, "grs_rpb_rev");
				sheetObj.CellValue2(Row, "grs_rpb_rev_ttl") 	= sheetObj.CellValue(selectRow, "grs_rpb_rev_ttl");
				//Lane 코드 값 조회
				var sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
				
				sheetObj.InitCellProperty(sheetObj.SelectRow , "dir_cd", dtCombo);
				var laneBound = "E|W|S|N";
				sheetObj.CellComboItem(sheetObj.SelectRow, "dir_cd", " |"+laneBound, " |"+laneBound);
				
				sheetObj.InitCellProperty(sheetObj.SelectRow , "conv_dir_cd", dtCombo);
				var convDirCd = "E|W|S|N";
				sheetObj.CellComboItem(sheetObj.SelectRow, "conv_dir_cd", " |"+convDirCd, " |"+convDirCd);
				
				sheetObj.InitCellProperty(sheetObj.SelectRow , "hul_bnd_cd", dtCombo);
				var hulBoundCode = "H/H|B/H";
				sheetObj.CellComboItem(sheetObj.SelectRow, "hul_bnd_cd", " |"+hulBoundCode, " |"+hulBoundCode);
				
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

function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm("click",		"obj_click",	formObj);
}

function obj_click() {
	
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	with(formObj) {
		switch(srcName) {

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
	toggleButtons();
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
				InitRowInfo(2, 1, 9, 100);

				var HeadTitle1 =  "STS|SEQ|Year|RHQ|Trade|Sub\nTrade|Lane|Lane\nBound|Trade\nBound|Trade\nDirection|Quarter|Initial|Initial|Initial|Revised|Revised|Revised";
				var HeadTitle2 =  "STS|SEQ|Year|RHQ|Trade|Sub\nTrade|Lane|Lane\nBound|Trade\nBound|Trade\nDirection|Quarter|Load|G.RPB|G.REV|Load|G.RPB|G.REV";

				var headCount = ComCountHeadTitle(HeadTitle1);
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, false, true, false, false);

				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				// 전체 높이 설정
				style.height = GetSheetHeight(17);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtStatus,			30,		daCenter,	true,	"ibflag",						false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtSeq,				40,		daCenter,	true,	"seq",							false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,				55,		daCenter,	true,	"bse_yr",						true,		"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,				65,		daCenter,	true,	"rhq_cd",						true,		"",	dfNone,			0,	false,	true);
				InitDataProperty(0,	cnt++,	dtData,				60,		daCenter,	true,	"trd_cd",						true,		"",	dfNone,			0,	false,	true);
				InitDataProperty(0,	cnt++,	dtData,				60,		daCenter,	true,	"sub_trd_cd",					true,		"",	dfNone,			0,	false,	true);
				InitDataProperty(0,	cnt++,	dtData,				60,		daCenter,	true,	"rlane_cd",						true,		"",	dfNone,			0,	false,	true);
				InitDataProperty(0,	cnt++,	dtData,				70,		daCenter,	true,	"dir_cd",						true,		"",	dfNone,			0,	false,	true);
				InitDataProperty(0,	cnt++,	dtData,				70,		daCenter,	true,	"conv_dir_cd",					true,		"",	dfNone,			0,	false,	true);
				InitDataProperty(0, cnt++,  dtData,     	    70,		daCenter,   true,   "hul_bnd_cd",   				true,  "", dfNone,     	0,  false,  true);
				InitDataProperty(0,	cnt++,	dtData,				70,		daCenter,	true,	"bse_qtr_cd",					true,		"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,			75,		daRight,	true,	"gid_lod_qty",					false,	"",	dfInteger,		0,	false,	false, 5);
				InitDataProperty(0,	cnt++,	dtData,				75,		daRight,	true,	"gid_grs_rpb_rev",				false,	"",	dfInteger,		0,	false,	false, 5);
				InitDataProperty(0,	cnt++,	dtAutoSum,			100,	daRight,	true,	"gid_grs_rpb_rev_ttl",			false,	"|gid_lod_qty|*|gid_grs_rpb_rev|",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,			75,		daRight,	true,	"lod_qty",						false,	"",	dfInteger,		0,	true,	true, 5);
				InitDataProperty(0,	cnt++,	dtData,				75,		daRight,	true,	"grs_rpb_rev",					false,	"",	dfInteger,		0,	true,	true, 5);
				InitDataProperty(0,	cnt++,	dtAutoSum,			90,		daRight,	true,	"grs_rpb_rev_ttl",				false,	"|lod_qty|*|grs_rpb_rev|",	dfInteger,		0,	false,	false);

				MinimumValue(0, "grs_rpb_rev") = "0";
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

			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0501GS.do", FormQueryString(formObj));
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
				ComXml2ComboItem(arrXml[6], formObj.f_hul_bnd_cd, "code", "name");

			ComOpenWait(false);
			break;

		case IBSEARCH:          // 화면 조회 시
			ComOpenWait(true);

			formObj.f_cmd.value = SEARCH;

			toggleButtons();
			searchParams = FormQueryString(formObj);
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0501GS.do", searchParams);

			sheetObj.LoadSearchXml(rtnXml);

			var etcData = getEtcData(rtnXml);
			var bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
			var bse_qtr_cd = formObj.f_bse_qtr_cd.Text;
			if(etcData["dataCnt"] == 0){
				if(bse_tp_cd == "Q" &&  bse_qtr_cd == "1Q"){
					toggleButtons(); //Creation만 활성화
				}else{
					toggleButtons("CREATE"); //Creation만 활성화
				}
			}else{
				if ( sheetObj.SearchRows == 0 ) {
					toggleButtons("SEARCH01"); // Creation, Row Add만 비활성화
				}else{
					toggleButtons("SEARCH"); //Creation만 비활성화
				}
			}
			ComOpenWait(false);
			sheetObj.SumText(0, "ibflag") = "";

			sheetObj.SumText(0, "bse_yr") = "TOTAL";
			break;

		case IBSAVE:		// 저장
			if (!validateForm(sheetObj, formObj, sAction)) return;

			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006");
		        return false;
		    } else if (ComShowConfirm (ComGetMsg("SQM00004")) != 1) {
				return false;
		    }
			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI);
			sheetObj.DoSave("ESM_SQM_0501GS.do", searchParams, -1, false);
			ComOpenWait(false);
			var State = sheetObj.EtcData("TRANS_RESULT_KEY");
			if (State == "S") {
				ComShowCodeMessage("COM130102", "Data");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
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

			var sXml = sheetObj.GetSaveXml("ESM_SQM_0501GS.do", searchParams);

			ComOpenWait(false);

			var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				//toggleButtons();
				ComShowCodeMessage('SQM00010', 'Data');
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
			break;

		case SEARCH01:		
			var sheetRhqCd = sheetObj.CellValue(sheetObj.SelectRow, "rhq_cd");
			var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=rhq&code_param=" + sheetRhqCd + "&all_flag=");
			var rhq = ComXml2ComboString(sXml, "code", "name");
			sheetObj.InitCellProperty(sheetObj.SelectRow , "rhq_cd", dtCombo);
			sheetObj.CellComboItem(sheetObj.SelectRow, "rhq_cd", " |"+rhq[0], " |"+rhq[1]);
			
			var sheetTrdCd = sheetObj.CellValue(sheetObj.SelectRow, "trd_cd");
			var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=mdmTrade&code_param=" + sheetRhqCd + "&all_flag=");
			var trd = ComXml2ComboString(sXml, "code", "name");
			sheetObj.InitCellProperty(sheetObj.SelectRow , "trd_cd", dtCombo);
			sheetObj.CellComboItem(sheetObj.SelectRow, "trd_cd", " |"+trd[0], " |"+trd[1]);
			
			break;

		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.MergeSheet = msNone;
			sheetObj.Down2Excel(-1, false, false, true);
			sheetObj.MergeSheet = msHeaderOnly;
			ComOpenWait(false);
			break;

		case IBLOADEXCEL:		// 엑셀 업로드
			loadExcelRowCnt    = sheetObj.HeaderRows + sheetObj.TotalRows;
			loadExcelTotFlg    = true;		// 화면에 Total Row 존재 여부
			loadExcelExField   = "|lod_qty|grs_rpb_rev|grs_rpb_rev_ttl|";		// 비교 제외 필드
			loadExcelAplyField = "|lod_qty|grs_rpb_rev|";		// 반영 필드

			var rtn = window.showModalDialog("ESM_SQM_1001.do?" + searchParams, window, "dialogHeight:610px;dialogWidth:1050px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");
			break;
    }
}

 /**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction){
	switch(sAction) {
		case IBSAVE:  // 화면 저장시에
		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.RowCount ; i++){
				if(sheetObj.CellValue(i,"rlane_cd") == ""){
					ComShowCodeMessage("SQM00013", "Lane");
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
	     + "&code_name=rLane"
	     + "&code_param="+ value
	     + "&all_flag=All"
	     + "&" + FormQueryString(formObj);	// Trade
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
* f_bse_tp_cd 바뀌었을때 qtr_cd, week 변경
*/
function f_bse_tp_cd_0501_OnChange() {
	var formObj    = document.form;
	var bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
	var div_qtr    = document.getElementById("div_qtr");
	var div_period = document.getElementById("div_period");
	var f_bse_qtr_cd_idx = formObj.f_bse_qtr_cd.Index;
	if (bse_tp_cd == "Y") {
		formObj.f_bse_qtr_cd.InsertItem(0, 'All', 'All');
		formObj.f_bse_qtr_cd.Index = 0;
		formObj.f_bse_qtr_cd.BackColor = "white";
	}else{
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
* 화면의 모든 버튼들의 Enable/Disable 을 처리
*/
function toggleButtons(step) {
	ComBtnDisable("btn_Save");
	ComBtnDisable("btn_DownExcel");
	ComBtnDisable("btn_LoadExcel");
	ComBtnDisable("btn_Creation");
	ComBtnDisable("btn_RowAdd");

	switch (step) {
		case "SEARCH":
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_DownExcel");
			ComBtnEnable("btn_LoadExcel");
			ComBtnEnable("btn_RowAdd");
			break;

		case "SEARCH01":
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_DownExcel");
			ComBtnEnable("btn_LoadExcel");
			break;

		case "CREATE":
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
			break;

		case "grs_rpb_rev":
			if(sheetObj.CellValue(row,colName) == ""){
				sheetObj.CellBackColor(row,colName) = sheetObj.RgbColor(255, 0, 0);
				msg = "G.RPB is mandatory item.\n"
					+"==================================================================================\n";
				return false;
			}

			if(sheetObj.CellValue(row,colName) < 0){
				sheetObj.CellBackColor(row,colName) = sheetObj.RgbColor(255, 0, 0);
				msg = "You can't input minus figure in G.RPB column.\n"
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
	}
	return true;
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
		case "trd_cd":
			sheetObj.CellValue2(row, "sub_trd_cd") 				= "";
			sheetObj.CellValue2(row, "rlane_cd") 				= "";
			var trdCd = sheetObj.CellValue(row, "trd_cd");
			var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=subTrade&code_param=" + trdCd + "&all_flag=");
			var subTrdCd = ComXml2ComboString(sXml, "code", "name");
			sheetObj.InitCellProperty(sheetObj.SelectRow , "sub_trd_cd", dtCombo);
			sheetObj.CellComboItem(sheetObj.SelectRow, "sub_trd_cd", " |"+subTrdCd[0], " |"+subTrdCd[1]);
			break;

		case "sub_trd_cd":
			sheetObj.CellValue2(row, "rlane_cd") 				= "";
			var trdCd = sheetObj.CellValue(row, "trd_cd");
			var subTrdCd = sheetObj.CellValue(row, "sub_trd_cd");
			var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=rLane&code_param=" + trdCd +"|"+ subTrdCd + "&all_flag=");
			var rlane = ComXml2ComboString(sXml, "code", "name");
			sheetObj.InitCellProperty(sheetObj.SelectRow , "rlane_cd", dtCombo);
			sheetObj.CellComboItem(sheetObj.SelectRow, "rlane_cd", " |"+rlane[0], " |"+rlane[1]);
			break;
			
	}
}
/* 개발자 작업  끝 */