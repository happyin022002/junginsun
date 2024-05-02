/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0035.js
*@FileTitle      : Allocation = QTA Setting
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.08
*@LastModifier   : JEONGMIN CHO
*@LastVersion    : 1.0
* 2013.05.08 JEONGMIN CHO
* 1.0 Creation
* 2014.01.16 박은주 [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2014.12.26 이혜민 [CHM-201433310] SPC에서 I/F시 최초 Load를 사후에도 조회할수 있도록 ORG_LOD_QTY 컬럼 추가, 확정데이터 Load를 조회할 수 있도록 CFM_LOD_QTY 컬럼 추가. 
* 2015.02.04 김용습 [CHM-201534143] Alloc = QTA 화면 내 특정 항차의 특정 office 선택시, 동 항차 내 모든 office 동시 선택 기능 보완
* 2015.02.12 김용습 [CHM-201534142] Alloc = QTA 화면 내 Trade Direction 기능 추가
* 2015.02.23 이혜민 [CHM-201534159] Alloc = QTA 화면 내 Alloc Delete 기능 추가
* 2015.08.10 김용습 [CHM-201537496] [CSR 전환건] Allocation = QTA Adjustment 내 신규 버튼 추가 
* 2015.08.10 김용습 [CHM-201537494] [CSR 전환건] Allocation = QTA Adjustment 화면 내 버튼 제한설정
* 2015.08.10 김용습 [CHM-201536994] Split24-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
* 2015.08.26 김용습 [CHM-201537723] [CSR 전환건] Allocation = QTA Adjustment 화면 내 신규 칼럼 추가
* 2015.10.01 김용습 [CHM-201537934] [CSR 전환건] Allocation = QTA의 "SPC Alloc Apply" 로직 수정
* 2016.07.15 CHM-201642546 Allocation = QTA Adjustment 화면 Office Add 버튼 추가
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends 
 * @class ESM_SQM_0035 : ESM_SQM_0035 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0035() {
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

var saveflg = "Y";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
	var sheetObject = sheetObjects[0];
	var formObj     = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
		
			case "btn_Retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject, formObj, IBSAVE);
				break;
			case "btn_Downexcel":
				doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
				break;
			case "btn_Apply":
				doActionIBSheet(sheetObject,formObj,MULTI01);
				break;
			case "btn_Delete":
				doActionIBSheet(sheetObject,formObj,MULTI02);
				break;
			case "btn_Activate":
				doActionIBSheet(sheetObject,formObj,MULTI03);
				break;
			case "btng_planned_l/f_inquiry":
				window.open("/hanjin/ESM_SQM_0014.do","Window","width=1100, height=600,status=yes,scrollbars=yes, resizable=yes,menubar=no");
				break;
			case "btn_office_add":
				doActionIBSheet(sheetObject, formObj, IBINSERT);
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
	
	comboObjects[5].InsertItem(0, 'All', 'All');
	comboObjects[5].InsertItem(1, 'Y', 'Y');
	comboObjects[5].InsertItem(2, 'N', 'N');
	
	comboObjects[6].InsertItem(0, 'All', 'All');
	comboObjects[6].InsertItem(1, 'Y', 'Y');
	comboObjects[6].InsertItem(2, 'N', 'N');
	comboObjects[6].InsertItem(3, 'X', 'X');
	
	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}
	initControl();
	toggleButtons("INIT");
	loadingMode = false;
}

/**
* f_bse_yr가 바뀌었을때 week,month콤보 변경
*/
function f_bse_yr_OnChange(obj, value, text) {
	var formObj = document.form;
	doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
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
        case "engup":
            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
            ComKeyOnlyAlphabet('upper');
            break;
        default:
            //숫자만입력하기(정수,날짜,시간)
            ComKeyOnlyNumber(event.srcElement);
    }
}
 
 function initControl(){	 
		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
		axon_event.addListenerFormat('keypress', 'obj_keypress', document.form); //- 키보드 입력할때
		axon_event.addListenerForm("click",     "obj_click",    document.form);
}     

 /**
  * 조회조건 입력할 때 처리
  */
 function obj_KeyUp() {
      var formObject = document.form;
      var srcName = window.event.srcElement.getAttribute("name");
      var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
      var srcValue = window.event.srcElement.getAttribute("value");
      if (ComChkLen(srcValue, srcMaxLength) == "2") {
      	ComSetNextFocus();
      }
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
				MergeSheet = msAll;  //msNone; //msHeaderOnly //msPrevColumnMerge;
				
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 10, 100);
				
				var HeadTitle1 =  "STS|SEQ|Year|Trade|Lane\nBound|Trade\nDirection|Sub\nTrade|R.Lane|VVD||||Month|Week|Supply|RHQ|Office|Planned\nLoad|Original\nLoad|Applied\nLoad|Applied|Active|SEL|DEL|D-1 Date|Pair Check|Quarter";

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);
				
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(false, true, true, true, false, false);
				
				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				
				// 전체 높이 설정
				style.height = GetSheetHeight(19);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtStatus,		30,	  daCenter,	 false,	"ibflag",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		30,	  daCenter,  true,	"seq",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			45,	  daCenter,	 false,	"bse_yr",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			45,	  daCenter,	 false,	"trd_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			45,	  daCenter,	 false,	"dir_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0, cnt++,  dtData,     	60,   daCenter,  false, "hul_bnd_cd",   false,  "", dfNone, 0,  false,  false);
				InitDataProperty(0,	cnt++,	dtData,			45,	  daCenter,	 false,	"sub_trd_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			55,	  daCenter,	 false,	"rlane_cd",		false,	"",	dfNone,	0,	false,	false);				
				InitDataProperty(0,	cnt++,	dtData,			75,   daCenter,	 true,	"vvd",		    false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		40,   daCenter,	 false,	"vsl_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		40,	  daCenter,	 false,	"skd_voy_no",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		40,   daCenter,	 false,	"skd_dir_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			45,	  daCenter,	 false,	"bse_mon",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			45,   daCenter,  false,	"bse_wk",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			55,   daCenter,	 false,	"fnl_bsa_capa",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,   daCenter,	 false,	"rhq_cd",		true,	"",	dfNone,	0,	false,	false, 5);
				InitDataProperty(0,	cnt++,	dtData,			60,	  daCenter,	 false,	"rgn_ofc_cd",	true,	"",	dfNone,	0,	false,	false, 5);
				InitDataProperty(0,	cnt++,	dtData,			60,	  daRight,	 false,	"cfm_lod_qty",	false,	"",	dfInteger,0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,	  daRight,	 false,	"org_lod_qty",	false,	"",	dfInteger,0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,	  daRight,	 false,	"lod_qty",		false,	"",	dfInteger,0,	true,	true, 10);
				InitDataProperty(0,	cnt++,	dtData,			50,	  daCenter,	 false,	"aply_flg",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,	  daCenter,	 false,	"sqm_act_flg",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCheckBox,		40,	  daCenter,	 false,	"sel",			false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtCheckBox,		40,	  daCenter,	 false,	"del",			false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtData,			100,  daCenter,	 false,	"d_minus_one_date",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			45,	  daCenter,	 false,	"pair_check",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		45,	  daCenter,	 false,	"quarter",		false,	"",	dfNone,	0,	false,	false);

				//영문과 숫자 입력하기
				InitDataValid(0, "rhq_cd",  	vtEngUpOnly);
				InitDataValid(0, "rgn_ofc_cd", 	vtEngUpOnly);
				
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
			
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0035GS.do", FormQueryString(formObj));
			var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
			var arrXml = sXml.split("|$$|");
			
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_trd_cd, "code", "name");
			if (arrXml.length > 2)
				ComXml2ComboItem(arrXml[2], formObj.f_rhq_cd, "code", "name");
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], formObj.f_dir_cd, "code", "name");
			if (arrXml.length > 4)
				ComSetYear(arrXml[4]);
			if (arrXml.length > 5)
				ComXml2ComboItem(arrXml[5], formObj.f_hul_bnd_cd, "code", "name");
			
			ComOpenWait(false);
			break;
			
		case SEARCH01:          // Month,Week콤보셋팅
		
			formObj.f_cmd.value = SEARCH01;
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0035GS.do", FormQueryString(formObj));
			var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
			var arrXml = sXml.split("|$$|");
			
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_to_mon, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_to_wk, "code", "name");
				
			comboObjects[1].Index = 0;
			comboObjects[2].Index = 0;
			break;
			
		case IBSEARCH:          // 화면 조회 시
			sheetObj.WaitImageVisible = false;			
			ComOpenWait(true);
	
			formObj.f_cmd.value = SEARCH;
			searchParams = FormQueryString(formObj);
			sheetObj.DoSearch("ESM_SQM_0035GS.do", searchParams);
			
			toggleButtons("SEARCH");
			saveflg = "Y";
			ComOpenWait(false);
			break;
			
		case IBSAVE:          // 화면 저장시

			if (!validateForm(sheetObj,document.form,sAction)) {
				return false;
			}
						
			if (ComShowConfirm (ComGetMsg("SQM00004")) != 1) {
				return false;
			}
			
			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI);
			var sParam 	= sheetObj.GetSaveString(false, true, "ibflag");
			var sXml = sheetObjects[0].GetSaveXml("ESM_SQM_0035GS.do", searchParams + "&" +sParam);
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('SQM00001','Data');
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
			
			break;

			
		case MULTI01:		// SPC Alloc apply
			if (sheetObj.CheckedRows("sel") == 0) {
				ComShowCodeMessage("COM12113", "rows to apply");
				return false;
			}

			if(saveflg == "N"){
				ComShowCodeMessage("SQM00030","SPC Alloc Apply");
				return false;
			}
			if (ComShowConfirm (ComGetMsg('SQM00012','apply')) != 1) {
				return false;
		    }

			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI01);
			var sParam 	= sheetObj.GetSaveString(false, true, "sel");
			var sXml = sheetObjects[0].GetSaveXml("ESM_SQM_0035GS.do", searchParams + "&" +sParam);
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('SQM00001','Data');
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}

			break;
			
		case MULTI02:		// SPC Alloc delete
			if (sheetObj.CheckedRows("del") == 0) {
				ComShowCodeMessage("COM12113", "rows to delete");
				return false;
			}

			if(saveflg == "N"){
				ComShowCodeMessage("SQM00030","SPC Alloc Delete");
				return false;
			}
			if (ComShowConfirm (ComGetMsg('SQM00012','delete')) != 1) {
				return false;
		    }

			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI02);
			var sParam 	= sheetObj.GetSaveString(false, true, "del");
			var sXml = sheetObjects[0].GetSaveXml("ESM_SQM_0035GS.do", searchParams + "&" +sParam);
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				ComOpenWait(false);
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('SQM00001','Data');
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}

			break;	
			
		case MULTI03:		// Activate
			if (sheetObj.CheckedRows("sel") == 0) {
				ComShowCodeMessage("COM12113", "rows to activate");
				return false;
			}

			if(saveflg == "N"){
				ComShowCodeMessage("SQM00030","activation");
				return false;
			}
			
			for(i=0; i<sheetObj.LastRow; i++){
				if(sheetObj.CellValue(i, "sel") == true){
					if(sheetObj.CellValue(i, "aply_flg") == "Y"){
						ComShowCodeMessage('SQM00054');
						return false;
					}
				}
			}
			
			for(i=0; i<sheetObj.LastRow; i++){
				if(sheetObj.CellValue(i, "sel") == true){
					if(sheetObj.CellValue(i, "sqm_act_flg") == "Y"){
						ComShowCodeMessage('SQM00056');
						return false;
					}
				}
			}
			
			if (ComShowConfirm (ComGetMsg('SQM00012','activate selected data')) != 1) {
				return false;
		    }

			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI03);
			var sParam 	= sheetObj.GetSaveString(false, true, "sel");
			
			var sXml = sheetObjects[0].GetSaveXml("ESM_SQM_0035GS.do", searchParams + "&" +sParam);
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('SQM00001','Data');
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}

			break;
		
		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.Down2Excel(-1, false, false, true);
			ComOpenWait(false);
			break;
			
		case IBINSERT:          // Row Add 시

			if (!validateForm(sheetObj,document.form,sAction)) {
				return false;
			}
				
			var row = sheetObj.DataCopy();
			sheetObj.CellValue2(row,"lod_qty") = "0";
			sheetObj.CellValue2(row,"rhq_cd") = "";
			sheetObj.CellValue2(row,"rgn_ofc_cd") = "";
			sheetObj.CellValue2(row,"cfm_lod_qty") = "0";
			sheetObj.CellValue2(row,"org_lod_qty") = "0";
			sheetObj.CellValue2(row,"aply_flg") = "N";	
									
			sheetObj.CellEditable(row, "rhq_cd")   = true;
			sheetObj.CellEditable(row, "rgn_ofc_cd") = true;

			//sheetObj.CellEditable(row, "sel")   = false;
			//sheetObj.CellEditable(row, "del")   = false;
			
			///////////////////////
			// RHQ COMBO 
			sheetObj.InitCellProperty ( row, 15, dtCombo, daCenter, "rhq_cd", "", dfNone );
			sheetObj.InitCellProperty ( row, 16, dtCombo, daCenter, "rgn_ofc_cd", "", dfNone );
		
			setLaneRhqIBCombo(sheetObj, row);
				
			sheetObj.SelectCell(row, "rhq_cd");
			////////////////////////
			break;

    }
}


/**
 * Lane Office Relation Setting 화면 RHQ 목록 <br>
 * Year, Quarter, Trade, RLane 별 RHQ 목록
 */
function setLaneRhqIBCombo(sheetObj, row) {
	var cYear 		= sheetObj.CellValue(row, "bse_yr");
	var cQuarter 	= sheetObj.CellValue(row, "quarter");
	var cTrade 		= sheetObj.CellValue(row, "trd_cd");
	var cRlane 		= sheetObj.CellValue(row, "rlane_cd");
		
	var code  = cYear + "|" + cQuarter + "|" + cTrade + "|" + cRlane;
	var param = "f_cmd=" + SEARCH01
	    + "&code_name=LaneRHQ"
	    + "&code_param=" + code;

	var xmlStr = sheetObj.GetSearchXml("CommonGS.do", param);
	var arrXml = xmlStr.split("|$$|");
		
	if (arrXml.length > 0){
		ComSqmSetIBCombo(sheetObj, arrXml[0], "rhq_cd", true, 0, row);
	}
}

/**
 * Lane Office Relation Setting 화면 Office 목록 <br>
 * Year, Quarter, Trade, RLane, RHQ 별 Office 목록
 */
function setLaneOfficeIBCombo(sheetObj, row) {
	var cYear 		= sheetObj.CellValue(row, "bse_yr");
	var cQuarter 	= sheetObj.CellValue(row, "quarter");
	var cTrade 		= sheetObj.CellValue(row, "trd_cd");
	var cRlane 		= sheetObj.CellValue(row, "rlane_cd");
	var cRhq 		= sheetObj.CellValue(row, "rhq_cd");
		
	if(cRhq == "") {
		return false;
	}
	
	var code  = cYear + "|" + cQuarter + "|" + cTrade + "|" + cRlane + "|" + cRhq;
	var param = "f_cmd=" + SEARCH01
	    + "&code_name=LaneOffice"
	    + "&code_param=" + code;

	var xmlStr = sheetObj.GetSearchXml("CommonGS.do", param);
	var arrXml = xmlStr.split("|$$|");
		
	if (arrXml.length > 0){
		ComSqmSetIBCombo(sheetObj, arrXml[0], "rgn_ofc_cd", true, 0, row);
	}
}

 /**
 * 화면 오픈시 Year 세팅
 */
function ComSetYear(xml) {
	var formObj = document.form;
	var arrData = ComSqmGetXmlValue(xml);
	var arrCode = arrData.split("-");
	formObj.f_bse_yr.Code     = arrCode[0];
}

  /**
  * onChange event
  * f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
  */	
  function f_trd_cd_OnChange(obj, value, text) {
  	var formObj = document.form;
  	var trdcd  = comboObjects[8].Code;	// trade code
  	if(value != "All"){
  		var param = "f_cmd=" + SEARCH01
  	   + "&code_name=rLane"
  	   + "&code_param=" + trdcd
  	   + "&all_flag=All";	// Trade
  	
  		var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
  		ComXml2ComboItem(xmlStr, formObj.f_rlane_cd, "code", "name");

  	}else{
  		formObj.f_rlane_cd.RemoveAll();
  		formObj.f_rlane_cd.InsertItem(0, "All", "All");
  	}
		comboObjects[8].Index = 0;
  }


  /**
   * onChange event
   * f_rhq_cd 바뀌었을때  f_rgn_ofc_cd 콤보조회
   */	
  function f_rhq_cd_OnChange(obj, value, value) {

  	var formObj = document.form;
  	var rhqCd  = value;	// rhq code
  	if(value!="All"){
  		var param = "f_cmd=" + SEARCH01
  	    + "&code_name=office"
  	    + "&code_param=" + rhqCd
  	    + "&all_flag=All";	// Trade
  	
  		var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
  		ComXml2ComboItem(xmlStr, formObj.f_rgn_ofc_cd, "code", "name");

  	}else{
  		formObj.f_rgn_ofc_cd.RemoveAll();
  		formObj.f_rgn_ofc_cd.InsertItem(0, "All", "All");

  	}
		comboObjects[4].Index = 0;
  }
  
   /**
   * sheet1_onChange event
   * lod_qty 바뀌었을때 validation
   */  
  function sheet1_OnChange(sheetObj, row, col, value){
	   sheetObj.WaitImageVisible = false;
    		with(sheetObj){
    			switch(ColSaveName(col)){
            		case "lod_qty":
            			saveflg = "N";
            			break;
            			
            		case "rhq_cd":        			
            			setLaneOfficeIBCombo(sheetObj, row);
            			break;          			
           			
            			
            		//2015.02.04 YONGSEUP KIM [CHM-201534143] 
            		case "sel":     
            			if(sheetObj.CellValue(row,'aply_flg')+sheetObj.CellValue(row,'sqm_act_flg') != 'NN'){ // aply_flg, sqm_act_flg가 둘다 N일때는 선택한 sel 체크박스 한개만 체크되게 함(Activate를 위한 셀 선택을 위해)
	            			if(sheetObj.CellValue(row,'aply_flg')+sheetObj.CellValue(row,'sqm_act_flg') != 'NX'){
	            				var year_of_selected_row 			= sheetObj.CellValue(row,'bse_yr');	
		            			var trade_of_selected_row 			= sheetObj.CellValue(row,'trd_cd');	
		            			var lane_bound_of_selected_row 		= sheetObj.CellValue(row,'dir_cd');	
		            			var sub_trade_of_selected_row 		= sheetObj.CellValue(row,'sub_trd_cd');	
		            			var revenue_lane_of_selected_row 	= sheetObj.CellValue(row,'rlane_cd');	
		            			var vvd_of_selected_row 			= sheetObj.CellValue(row,'vvd');	
		            			var month_of_selected_row 			= sheetObj.CellValue(row,'bse_mon');	
		            			var week_of_selected_row 			= sheetObj.CellValue(row,'bse_wk');	
		            			var supply_of_selected_row 			= sheetObj.CellValue(row,'fnl_bsa_capa');	
		            			
		            			var start_of_merge 					= sheetObj.GetMergedStartCell(row,'vvd');
		            			var array_of_start_row_of_merge 	= start_of_merge.split(",");
		            			var start_row_of_merge 				= Number(array_of_start_row_of_merge[0]); // Number() should be used to change the type of 'array_of_start_row_of_merge[0]', which is string, into number. Otherwise, 'k=start_row_of_merge' in the for loop below will randomly malfunction. 
		            			           			
		            			var end_of_merge 					= sheetObj.GetMergedEndCell(row,'vvd');
		            			var array_of_end_row_of_merge 		= end_of_merge.split(",");
		            			var last_row_of_merge 				= Number(array_of_end_row_of_merge[0]); // Number() should be used to change the type of 'array_of_last_row_of_merge[0]', which is string, into number. Otherwise, 'k=start_row_of_merge' in the for loop below will randomly malfunction.
		            			
		            			for(k=start_row_of_merge; k<=last_row_of_merge; k++){	
		            				
		            					if( ( year_of_selected_row 			== sheetObj.CellValue(k,'bse_yr') ) 	&& 
		            						( trade_of_selected_row 		== sheetObj.CellValue(k,'trd_cd') ) 	&&
		            						( lane_bound_of_selected_row 	== sheetObj.CellValue(k,'dir_cd') ) 	&&
		            						( sub_trade_of_selected_row 	== sheetObj.CellValue(k,'sub_trd_cd') ) &&
		            						( revenue_lane_of_selected_row 	== sheetObj.CellValue(k,'rlane_cd') ) 	&&
		            						( vvd_of_selected_row 			== sheetObj.CellValue(k,'vvd') ) 		&&
		            						( month_of_selected_row 		== sheetObj.CellValue(k,'bse_mon') ) 	&&
		            						( week_of_selected_row 			== sheetObj.CellValue(k,'bse_wk') ) 	&&
		            						( supply_of_selected_row 		== sheetObj.CellValue(k,'fnl_bsa_capa') ) ){ // start of if clause
		            						
			            						if( sheetObj.CellValue(row, 'sel') == 1 ){
			            							sheetObj.CellValue2(k, 'sel') = "Y";
			            						}else if( sheetObj.CellValue(row, 'sel') == 0 ){
			            							sheetObj.CellValue2(k, 'sel') = "N";
			            						}            						
		            						
		            					} // end of if clause
		            			} // end of for loop
	            			}else if(sheetObj.CellValue(row,'pair_check') != 'VALID'){
	            				alert(sheetObj.CellValue(row,'pair_check'));
	            				sheetObj.CellValue2(row, 'sel') = "N";
	            			}
            			}else if(sheetObj.CellValue(row,'pair_check') != 'VALID'){
            				alert(sheetObj.CellValue(row,'pair_check'));
            				sheetObj.CellValue2(row, 'sel') = "N";
            			}
            	case "del":
            		if(sheetObj.CellValue(row,'aply_flg') == 'Y'){
            			sheetObj.CellValue2(row,'del') = "N";
            		}else{
             			var year_of_selected_row 			= sheetObj.CellValue(row,'bse_yr');	
            			var trade_of_selected_row 			= sheetObj.CellValue(row,'trd_cd');	
            			var lane_bound_of_selected_row 		= sheetObj.CellValue(row,'dir_cd');	
            			var sub_trade_of_selected_row 		= sheetObj.CellValue(row,'sub_trd_cd');	
            			var revenue_lane_of_selected_row 	= sheetObj.CellValue(row,'rlane_cd');	
            			var vvd_of_selected_row 			= sheetObj.CellValue(row,'vvd');	
            			var month_of_selected_row 			= sheetObj.CellValue(row,'bse_mon');	
            			var week_of_selected_row 			= sheetObj.CellValue(row,'bse_wk');	
            			var supply_of_selected_row 			= sheetObj.CellValue(row,'fnl_bsa_capa');	
            			
            			var start_of_merge 					= sheetObj.GetMergedStartCell(row,'vvd');
            			var array_of_start_row_of_merge 	= start_of_merge.split(",");
            			var start_row_of_merge 				= Number(array_of_start_row_of_merge[0]); // Number() should be used to change the type of 'array_of_start_row_of_merge[0]', which is string, into number. Otherwise, 'k=start_row_of_merge' in the for loop below will randomly malfunction. 
            			           			
            			var end_of_merge 					= sheetObj.GetMergedEndCell(row,'vvd');
            			var array_of_end_row_of_merge 		= end_of_merge.split(",");
            			var last_row_of_merge 				= Number(array_of_end_row_of_merge[0]); // Number() should be used to change the type of 'array_of_last_row_of_merge[0]', which is string, into number. Otherwise, 'k=start_row_of_merge' in the for loop below will randomly malfunction.
            			
            			for(k=start_row_of_merge; k<=last_row_of_merge; k++){	
            				
            					if( ( year_of_selected_row 			== sheetObj.CellValue(k,'bse_yr') ) 	&& 
            						( trade_of_selected_row 		== sheetObj.CellValue(k,'trd_cd') ) 	&&
            						( lane_bound_of_selected_row 	== sheetObj.CellValue(k,'dir_cd') ) 	&&
            						( sub_trade_of_selected_row 	== sheetObj.CellValue(k,'sub_trd_cd') ) &&
            						( revenue_lane_of_selected_row 	== sheetObj.CellValue(k,'rlane_cd') ) 	&&
            						( vvd_of_selected_row 			== sheetObj.CellValue(k,'vvd') ) 		&&
            						( month_of_selected_row 		== sheetObj.CellValue(k,'bse_mon') ) 	&&
            						( week_of_selected_row 			== sheetObj.CellValue(k,'bse_wk') ) 	&&
            						( supply_of_selected_row 		== sheetObj.CellValue(k,'fnl_bsa_capa') ) ){ // start of if clause
            						
	            						if( sheetObj.CellValue(row, 'del') == 1 ){
	            							sheetObj.CellValue2(k, 'del') = "Y";
	            						}else if( sheetObj.CellValue(row, 'del') == 0 ){
	            							sheetObj.CellValue2(k, 'del') = "N";
	            						}            						
            					}
            			}
            		}
    			} // end of switch
    		} // end of with
  } // end of function
   
/**
* 화면의 모든 버튼들의 Enable/Disable 을 처리
*/
  function toggleButtons(step) {
	var formObj = document.form;
   	switch (step) {
   		case "INIT":
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_Downexcel");
		ComBtnDisable("btn_Apply");
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_Activate");
		ComBtnDisable("btn_office_add");
		break;

	case "SEARCH":
		ComBtnEnable("btn_Downexcel");
		if(formObj.strOfc_cd.value == "SELCSG"){
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_Apply");
			ComBtnEnable("btn_Delete");
			ComBtnEnable("btn_Activate");
			ComBtnEnable("btn_office_add");
		}
   			break;
   	}
  }  
    
  /**
   * Trade Dir. 클릭시 콤보를 변경한다.
   */
  function obj_click() {
	    var formObj = document.form;
	    var srcName = window.event.srcElement.getAttribute("name");

	    with(formObj) {

	        switch(srcName) {

	            case "f_click":
	                if ( f_click.checked ) {
	                    div_trd_dir.style.display = "inline";
	                    div_dir_cd.style.display  = "none";
	                    document.all("div_dir").innerHTML = "Trade Dir.";
	                } else {
	                    div_trd_dir.style.display = "none";
	                    div_dir_cd.style.display  = "inline";
	                    document.all("div_dir").innerHTML = "Lane Bound";
	                }
	                break;
	        }
	    }
	}
  
  

 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
  * <br><b>Example :</b>
  * <pre>
  *     if (validateForm(sheetObj,document.form,IBSAVE)) {
  *         로직처리;
  *     }
  * </pre>
  * @param {ibsheet} sheetObj 필수 IBSheet Object
  * @param {form} formObj 필수 html form object
  * @param {int} sAction 필수 프로세스 플래그 상수
  * @returns bool <br>
  *          true  : 폼입력값이 유효할 경우<br>
  *          false : 폼입력값이 유효하지 않을 경우
  */
  function validateForm(sheetObj, formObj, sAction) {

	  switch (sAction) {
		
	  	case IBINSERT:
			if(sheetObj.TotalRows < 1) {
				ComShowCodeMessage("SQM00026");
				return false;
			}			
			
			break;
				
		case IBSAVE: 
			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006");
			    return false;
			} 

			//필수 체크
			if (sheetObj.IsDataModified && sheetObj.GetSaveString() == ""){
				return false;
			}

			//중복체크
			if (sheetObj.IsDataModified) {
				var dupRow = sheetObj.ColValueDup("bse_yr|bse_mon|bse_wk|trd_cd|rlane_cd|dir_cd|vsl_cd|skd_voy_no|skd_dir_cd|rgn_ofc_cd");
								
				if (dupRow > -1) {
		            ComShowCodeMessage("COM12115", "Office");
					sheetObj.SelectCell(dupRow, "rgn_ofc_cd");
		            return false;
				}
			}

			break;
		}

		return true;
	}

/* 개발자 작업  끝 */