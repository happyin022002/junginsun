/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0033.js
*@FileTitle      : Portion Adjustment by RHQ
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.03.25
*@LastModifier   :  
*@LastVersion    : 1.0
* 2013.05.08  
* 1.0 Creation
* 2013.10.21 Figure Inquiry  조회 팝업 추가
* 2013.11.11  SQM 몇몇 화면 내 틀 고정 기능 추가
* 2014.01.02 VVD 체크로직 수정
* 2014.01.16 IAS Sector Sales 판매시스템 개발
* 2014.01.27 Group Add 시 Group Number 세팅하는 로직변경(동시에 두 group을 추가시 문제가 되고 있어 수정)
* 2014.03.25 선조치             QTA Adjustment by VVD 화면 검색조건 로직 수정
* 2014.08.16 Portion Adjustment 화면의 Office 신규 row add 버튼 생성
* 2014.09.25 Portion Adjustment 화면의 From, TO VVD 입력 시 Portion Connected <> 'I' 인 VVD alert.
* 2015.01.22 Rev Month 기준으로 관련 화면의 period를 변경
* 2015.02.27 Adjust 화면 내 조회 로직 변경 (Week 기준 => Revenue Month 기준)
* 2015.04.15 Portion Adjustment 화면내  Group row add시 10개 group 이상일때 error 수정
* 2015.05.15 Adjustment 화면 3개 Creation전 RHQ별 Portion 존재하고, 
									Office portion이 없는 List 조회.
* 2015.08.18 Sales YYYY-WK를 Revenue YYYY-WK로 변경
* 2015.10.06 Portion Adjustment by RHQ, Head Office 화면 내 해당 분기 값만 입력 가능토록 Validation 설정
* 2016.03.15 From Week / To Week 수정 시, RHQ가 두 개 이상이면 Validation 걸리는 로직 수정 요청 CSR
* 2016.04.25 Save 버튼만 누르면 Creation까지 가능하도록 로직 수정 / Creation 버튼은 삭제
* 2016.04.22 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
* 2016.06.24 Contract View IAS Office Portion 입력 화면 개발건 로직 개요
=========================================================*/

/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends 
 * @class ESM_SQM_0033 : ESM_SQM_0033 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0033() {
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
var max = 0;
var params = "";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
	var sheetObject = sheetObjects[0];
	var formObj     = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
//			case "f_bse_tp_cd":
//				f_bse_tp_cd_OnChange();
//				break;	
			case "btn_Retrieve":
//				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				if(ComGetObjValue(formObj.f_trd_cd) == "IAS"){
            		if(ComGetObjValue(formObj.f_bse_yr) < 2016){
            			ComShowCodeMessage('SQM00067');
            		}else if(ComGetObjValue(formObj.f_bse_yr) == 2016){
            			if(ComGetObjValue(formObj.f_bse_qtr_cd) == "1Q"){ 
            				ComShowCodeMessage('SQM00067');
            			}else if(ComGetObjValue(formObj.f_bse_qtr_cd) == "2Q"){
            				ComShowCodeMessage('SQM00067');
            			}else{
            				doActionIBSheet(sheetObject, formObj, IBSEARCH);
            			}
            		}else{
        				doActionIBSheet(sheetObject, formObj, IBSEARCH);
            		}
            	}else{
    				doActionIBSheet(sheetObject, formObj, IBSEARCH);
            	}
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject, formObj, IBSAVE);
				break;
			case "btn_Creation":
				doActionIBSheet(sheetObject, formObj, MULTI01);
				break;
			case "btn_Downexcel":
				doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
				break;
			case "btn_RowGrpAdd":
				doActionIBSheet(sheetObject, formObj, MULTI02);
				break;
			case "btn_RowAdd":
				doActionIBSheet(sheetObject, formObj, "OfcRowAdd");
				break;	
			case "btn_FigureInquiry":
				doActionIBSheet(sheetObject, formObj, "FigureInquiry");
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
	axon_event.addListenerForm  ('click',    'obj_click',   formObj); 
	loadingMode = false;
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
			InitRowInfo(2, 1, 9, 100);
			
			var HeadTitle1 =  "STS|DEL|SEQ|Year|Quarter|N.OB/OB|Office View|Trade|Sub\nTrade|Lane|Lane\nBound|Trade\nBound|Trade\nDirection|RHQ|Office|Load (TEU)\nPortion Setting|G.REV\nPortion Setting||From|From|From||To|To|To|grp_no|";
			var HeadTitle2 =  "STS|DEL|SEQ|Year|Quarter|N.OB/OB|Office View|Trade|Sub\nTrade|Lane|Lane\nBound|Trade\nBound|Trade\nDirection|RHQ|Office|Load (TEU)\nPortion Setting|G.REV\nPortion Setting||Revenue\nYYYY-MM|Revenue\nYYYY-WK|VVD||Revenue\nYYYY-MM|Revenue\nYYYY-WK|VVD|grp_no|";

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 3, 0, true);
			
			// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
			InitHeadMode(true, false, false, true, false, false);
			
			// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
													
			// 전체 높이 설정
			style.height = GetSheetHeight(16);

			// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
			InitDataProperty(0,	cnt++,	dtStatus,	30,	  daCenter,	 true,	"ibflag",		false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtCheckBox, 45,   daCenter,	 true,	"delete",		false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtSeq,		30,	  daCenter,  true,	"seq",			false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		50,	  daCenter,	 true,	"bse_yr",		false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		60,	  daCenter,	 true,	"bse_qtr_cd",	false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		60,	  daCenter,	 true,	"ob_div_cd",	false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		70,	  daCenter,	 true,	"ofc_vw_cd",	false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		50,	  daCenter,	 true,	"trd_cd",		false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		50,	  daCenter,	 true,	"sub_trd_cd",	false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		55,	  daCenter,	 true,	"rlane_cd",		false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		60,	  daCenter,	 true,	"dir_cd",		false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		60,	  daCenter,	 true,	"conv_dir_cd",	false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		60,	  daCenter,	 true,	"hul_bnd_cd",	false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		60,	  daCenter,	 true,	"rhq_cd",		false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		60,	  daCenter,	 true,	"rgn_ofc_cd",	false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtAutoSum,	95,   daRight,	 true,	"lod_potn_rto",	false,	"",	dfFloat,2,	true,	true,	5);
			InitDataProperty(0,	cnt++,	dtAutoSum,	95,   daRight,	 true,	"rev_potn_rto",	false,	"",	dfFloat,2,	true,	true,	5);
			InitDataProperty(0,	cnt++,	dtHidden,	60,   daCenter,	 true,	"org_fm_yrwk",	false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		80,   daCenter,	 true,	"fm_cost_yrmon",false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		80,   daCenter,	 true,	"aply_fm_yrwk",	false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		75,   daCenter,	 true,	"fm_vvd_cd",	false,	"",	dfNone,	0,	true,	true,	9);
			InitDataProperty(0,	cnt++,	dtHidden,	60,   daCenter,	 true,	"org_to_yrwk",  false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		80,   daCenter,	 true,	"to_cost_yrmon",false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		80,   daCenter,	 true,	"aply_to_yrwk", false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		75,   daCenter,	 true,	"to_vvd_cd",	false,	"",	dfNone,	0,	true,	true,	9);
			InitDataProperty(0,	cnt++,	dtHidden,	80,   daCenter,	 true,	"grp_no", 		false,	"",	dfInteger,	0,	false,	false);

            InitDataValid(0,"fm_vvd_cd",vtEngUpOther,"1234567890");
            InitDataValid(0,"to_vvd_cd",vtEngUpOther,"1234567890");
            
			MinimumValue(0, "lod_potn_rto") = "0";
			MinimumValue(0, "rev_potn_rto") = "0";
			MaximumValue(0, "lod_potn_rto") = "100";
			MaximumValue(0, "rev_potn_rto") = "100";

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
		case "f_ob_div_cd":
			with (comboObj) {
				DropHeight = 300;
				Enable = false;
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
* f_bse_yr가 바뀌었을때 period 의 year 변경
*/
function f_bse_yr_OnChange(obj, value, text) {
	period_change_based_on_rev_month();
	setTradeCombo();
	setLaneCombo();
}

/**
* f_ofc_vw_cd 바뀌었을때 trade콤보조회
*/
function f_ofc_vw_cd_OnChange(obj, value, text) {
	setOBDivCombo();
	
	setTradeCombo();
	setLaneCombo();
	
}


/**
* Trade와 Office View 값에 따른 N.OB/OB 초기화 세팅
*/

function setOBDivCombo() {
    var trdCd   = document.getElementById("f_trd_cd");
    var ofcVwCd = document.getElementById("f_ofc_vw_cd");
	var obDivCd = document.getElementById("f_ob_div_cd");
	
	if(ofcVwCd.Code == "L") {
		obDivCd.Code2 = "O";
		obDivCd.Enable = false;
	} else {
		obDivCd.Code2 = "All";
		
		if(trdCd.Code == "IAS") {
			obDivCd.Enable = false;
		} else {
			obDivCd.Enable = true;
		}
	}
}


/**
* f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
*/
function f_bse_qtr_cd_OnChange(obj, value, text) {
	period_change_based_on_rev_month();
	setTradeCombo();
	setLaneCombo();
}

/**
* f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
*/
function f_ob_div_cd_OnChange(obj, value, text) {
	//setTradeCombo();
	//setLaneCombo();
}
/**
* f_bse_tp_cd,f_bse_qtr_cd,f_bse_yr가 바뀌었을때 trade콤보 settting
*/
function setTradeCombo() {
	 	var formObj = document.form;
	 	var trd_cd     = ComGetObjValue(formObj.f_trd_cd);
	 	
	 	if(formObj.f_bse_yr.Code!="" && formObj.f_bse_qtr_cd.Code!="" && formObj.f_ofc_vw_cd.Code!=""){
	
		 	var param = "f_cmd=" + SEARCH02
		     + "&code_name=tradeControl"
		     + "&code_param= " 
		     + "&all_flag=All"
		     + "&" + FormQueryString(formObj);	// Trade
		
		 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
		 	ComXml2ComboItem(xmlStr, formObj.f_trd_cd, "code", "name");
		 	var index = SearchIndex(formObj.f_trd_cd, trd_cd);
		 	formObj.f_trd_cd.Index = index;
	 	}
}


/**
* onChange event
* f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
*/	
function f_trd_cd_OnChange(obj, value, text) {
	setOBDivCombo();
	setLaneCombo();
}

/**
 *  f_bse_yr, f_bse_qtr_cd, f_ofc_vw_cd, f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
 */
function setLaneCombo() {
	 	var formObj = document.form;
	 	var trd_cd  = comboObjects[4].Code;	// trade code
	 	var rlane_cd  = formObj.f_rlane_cd.Code;	// rlane code
	 	
		if (trd_cd != "All") {	
		 	var param = "f_cmd=" + SEARCH02
		     + "&code_name=rLaneControl"
		     + "&code_param= "
		     + "&all_flag="
		     + "&" + FormQueryString(formObj);	// Trade
		
		 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
		 	ComXml2ComboItem(xmlStr, formObj.f_rlane_cd, "code", "name");
		 	
		    // 이전에 선택되어 있던 값과 같은 값이 있으면 동일하게 세팅해 준다.
			var index = SearchIndex(formObj.f_rlane_cd, rlane_cd);
			if(index != "0"){ //이전에 선택된 값이 있을때만 동일하게 세팅
				var arrIndex = index.split("|");
				for(var i=0; i<arrIndex.length; i++) {
					formObj.f_rlane_cd.CheckIndex(arrIndex[i]) = true;
				}
			}
		 	
		} else {
			formObj.f_rlane_cd.RemoveAll();
		}
		comboObjects[5].MultiSelect = true; 
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
			
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0033GS.do", FormQueryString(formObj));
			var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
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
				ComXml2ComboItem(arrXml[4], formObj.f_conv_dir_cd, "code", "name");
			if (arrXml.length > 5)
				ComXml2ComboItem(arrXml[5], formObj.f_ob_div_cd, "code", "name");
			if (arrXml.length > 6)
				ComXml2ComboItem(arrXml[6], formObj.f_trd_dir, "code", "name");
			setTradeCombo();
			ComOpenWait(false);
			break;
		
		case IBSEARCH:          // 화면 조회 시
			formObj.f_cmd.value = SEARCH;
			searchParams = FormQueryString(formObj);
			max = 0;
			ComOpenWait(true);
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0033GS.do",searchParams);	
			sheetObj.LoadSearchXml(rtnXml);
			ComOpenWait(false);
			
			if (sheetObj.RowCount > 0) {
				ComBtnEnable("btn_FigureInquiry");
			} else {
				ComBtnDisable("btn_FigureInquiry");
			}	
			break;
			
		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.MergeSheet = msNone;
			sheetObj.Down2Excel(-1, false, false, true);
			sheetObj.MergeSheet = msHeaderOnly;
			ComOpenWait(false);
			break;
			
		case IBSAVE:          // 화면 저장시

			if (!validateForm(sheetObj, formObj, sAction)) return;
			//ratio가 100%인지 check
			if (!checkRatioForRHQAdj(sheetObj)) return;
			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006");
		        return false;
		    }
	
			if (ComShowConfirm (ComGetMsg("SQM00004")) != 1) {
				return false;
		    }
			
			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI);
			sheetObj.DoSave("ESM_SQM_0033GS.do", searchParams, -1, false);
			//ComOpenWait(false);
	
			var State = sheetObj.EtcData("TRANS_RESULT_KEY");
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				//ComShowCodeMessage('SQM00001','Data');
				doActionIBSheet(sheetObjects[0], document.form, MULTI01);
				
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
			break;
			
		case MULTI01:		// Creation시에
			if (sheetObj.isDataModified == true) {
				ComOpenWait(false);
				ComShowCodeMessage("SQM00017");
		        return false;
		    }
			
			//RHQ Portion은 존재하나 해당 RHQ 산하 Office에 Portion이 0일 경우 alert.
			if (!validateForm(sheetObj, formObj, sAction)) {
				ComOpenWait(false);
				return false;
			}
			
			//if (ComShowConfirm (ComGetMsg("SQM00009")) != 1) {
			//	return false;
		    //}
			
			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI01);
			var sXml = sheetObj.GetSaveXml("ESM_SQM_0033GS.do", searchParams);
			ComOpenWait(false);
			
			var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			if (State == "S") {
				ComShowCodeMessage("SQM00010", "Data");
			} else if (State != "S") {
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}
			break;
			
		case MULTI02:		// row add시에 
			ComSetSearchParams("f_cmd", MULTI02);
			ComOpenWait(true);
			// 추가된 Row의 시작 위치를 확인한다.
			var rowCnt = sheetObj.HeaderRows+sheetObj.RowCount; 
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0033GS.do",searchParams);	
			sheetObj.LoadSearchXml(rtnXml,true);
			ComOpenWait(false);
			// Add한 Group No를 조정한다
			for(var i=rowCnt; i<sheetObj.Rows-1; i++){
				sheetObj.RowStatus(i) = "I";
				sheetObj.CellEditable(i, "delete") = true;
				sheetObj.CellValue(i,"grp_no") = Number(sheetObj.CellValue(i,"grp_no")) + Number(max);
			}
			break;
			
		case "FigureInquiry":
			// sheet에 변경사항이 있는지 확인
			if (sheetObj.isDataModified == true) {
				ComShowCodeMessage("SQM00017");
		        return false;
		    }			
			ComSetSearchParams("f_cmd", "");
			window.showModalDialog("ESM_SQM_0044.do?" + searchParams + "&div_period=" + document.getElementById("div_period_based_on_rev_month").innerHTML, window, "dialogHeight:510px;dialogWidth:900px;center:yes;resizable:no;scroll:no;status:no;unadorned:yes;");

			break;
		
		case "OfcRowAdd":  // Office Row Add 클릭시
			//선택한 Row 복사

			var selRow = sheetObj.SelectRow;
			var row = sheetObj.DataInsert();

			sheetObj.CellValue2(row, "bse_yr") 		 = sheetObj.CellValue(selRow, "bse_yr");
			sheetObj.CellValue2(row, "bse_qtr_cd") 	 = sheetObj.CellValue(selRow, "bse_qtr_cd");
			sheetObj.CellValue2(row, "ob_div_cd") 	 = sheetObj.CellValue(selRow, "ob_div_cd");
			sheetObj.CellValue2(row, "ofc_vw_cd")	 = sheetObj.CellValue(selRow, "ofc_vw_cd");
			sheetObj.CellValue2(row, "trd_cd") 		 = sheetObj.CellValue(selRow, "trd_cd");
			sheetObj.CellValue2(row, "sub_trd_cd") 	 = sheetObj.CellValue(selRow, "sub_trd_cd");
			sheetObj.CellValue2(row, "rlane_cd") 	 = sheetObj.CellValue(selRow, "rlane_cd");
			sheetObj.CellValue2(row, "dir_cd") 		 = sheetObj.CellValue(selRow, "dir_cd");
			sheetObj.CellValue2(row, "conv_dir_cd")  = sheetObj.CellValue(selRow, "conv_dir_cd");
			sheetObj.CellValue2(row, "hul_bnd_cd") 	 = sheetObj.CellValue(selRow, "hul_bnd_cd");
			sheetObj.CellValue2(row, "rhq_cd") 	     = sheetObj.CellValue(selRow, "rhq_cd");
			sheetObj.CellValue2(row, "org_fm_yrwk")  = sheetObj.CellValue(selRow, "org_fm_yrwk");
			sheetObj.CellValue2(row, "aply_fm_yrwk") = sheetObj.CellValue(selRow, "aply_fm_yrwk");
			sheetObj.CellValue2(row, "fm_vvd_cd") 	 = sheetObj.CellValue(selRow, "fm_vvd_cd");
			sheetObj.CellValue2(row, "org_to_yrwk")  = sheetObj.CellValue(selRow, "org_to_yrwk");
			sheetObj.CellValue2(row, "aply_to_yrwk") = sheetObj.CellValue(selRow, "aply_to_yrwk");
			sheetObj.CellValue2(row, "to_vvd_cd") 	 = sheetObj.CellValue(selRow, "to_vvd_cd");
			sheetObj.CellValue2(row, "grp_no") 		 = sheetObj.CellValue(selRow, "grp_no");

			sheetObj.CellEditable(row, "rgn_ofc_cd") = true;
			sheetObj.InitCellProperty(row , "rgn_ofc_cd", dtCombo);

			var selRow1      = sheetObj.SelectRow;
			var f_bse_yr     = sheetObj.CellValue(selRow1, "bse_yr");
			var f_bse_qtr_cd = sheetObj.CellValue(selRow1, "bse_qtr_cd");
			var f_ofc_vw_cd  = sheetObj.CellValue(selRow1, "ofc_vw_cd");
			var f_trd_cd     = sheetObj.CellValue(selRow1, "trd_cd");
			var f_rlane_cd   = sheetObj.CellValue(selRow1, "rlane_cd");
			var f_dir_cd     = sheetObj.CellValue(selRow1, "dir_cd");
			var f_rhq_cd     = sheetObj.CellValue(selRow1, "rhq_cd");
			var param        =   "&f_bse_yr="     +f_bse_yr  
				                +"&f_bse_qtr_cd=" +f_bse_qtr_cd
					            +"&f_ofc_vw_cd="  +f_ofc_vw_cd
					            +"&f_trd_cd="     +f_trd_cd
					            +"&f_rlane_cd="   +f_rlane_cd
					            +"&f_dir_cd="     +f_dir_cd
					            +"&f_rhq_cd="     +f_rhq_cd
 					            ;
			var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH02 + "&code_name=ofcByPortion&code_param=" + param + "&all_flag=");
			ComSqmSetIBCombo(sheetObj, sXml, "rgn_ofc_cd", true);

			break;	
			
		case IBSEARCH_ASYNC01:
			ComSetSearchParams("f_cmd", SEARCH01);
			var sXml = sheetObj.GetSearchXml("ESM_SQM_0031GS.do",searchParams);
			return sXml;
			break;	
			
    }
}


 /**
  * f_gubun가 체크될때 direction콤보 change
  */ 
 function obj_click() {
 	var formObj = document.form;        

 	if(formObj.f_click.checked){
    		trd_dir.style.display = "inline";
    		dir_cd.style.display = "none";
    		document.all("div_dir").innerHTML = "Trade Dir.";
 	}else{
    		trd_dir.style.display = "none";
    		dir_cd.style.display = "inline";
    		document.all("div_dir").innerHTML = "Trade Bound";
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
		case "fm_vvd_cd":
		case "to_vvd_cd":
			if(value.length == 9){
				
				//다른 그룹(trade-rlane-bound-RHQ-From Week-To Week) 끼리 같은 VVD 정보를 가질수 없음 
				for(var j=sheetObj.HeaderRows;j<sheetObj.Rows-1;j++){
					if(value == sheetObj.CellValue(j,col) && sheetObj.CellValue(row,"grp_no") != sheetObj.CellValue(j,"grp_no")){
						if(sheetObj.CellValue(row,"rhq_cd") == sheetObj.CellValue(j,"rhq_cd")){
		 					ComShowCodeMessage('SQM00023','VVD'); //VVD has been already inputted.
							sheetObj.CellValue(row,col) = "";
							sheetObj.CellValue(row,col-1) = "";
							return false;
						}
					}
				}
				
				// VVD의 주차를 조회한다(COA_MON_VVD로 부터 Why? 신규노선의 경의 SQM_CFM_TGT_VVD에 없기 때문)
				ComOpenWait(true);				
				params = searchParams;
				ComSetParams("f_trd_cd", sheetObj.CellValue(row,"trd_cd"));
				ComSetParams("f_rlane_cd", sheetObj.CellValue(row,"rlane_cd"));
				params = params + "&f_dir_cd="+ sheetObj.CellValue(row,"dir_cd");
				var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0032GS.do","f_cmd="+SEARCH01+"&vvd="+value+"&"+params);	// (참고)0032화면꺼 가져다 씀
				ComOpenWait(false);
				var etcData = getEtcData(rtnXml);
				
			////VVD입력시  target vvd의 cost year month 정보 입력
				if(etcData["cost_yrmon"] != 0){
					sheetObj.CellValue(row,col-2) = etcData["cost_yrmon"];
					costYearMonth = sheetObj.CellValue(row,col-2);
					month = costYearMonth.substr(4);
					
					if(month == "01" || month == "02" || month == "03"){
						if(sheetObj.CellValue(row, "bse_qtr_cd") != '1Q'){
							msg1 = sheetObj.CellValue(row,col);
							msg2 = sheetObj.CellValue(row,col-2);
							msg3 = sheetObj.CellValue(row, "bse_qtr_cd");
							ComShowCodeMessage('SQM00055',msg1,msg2,msg3);
							sheetObj.CellValue(row,col) = "";
							sheetObj.CellValue(row,col-1) = "";
							sheetObj.CellValue(row,col-2) = "";
							return false;
						}
					}else if(month == "04" || month == "05" || month == "06"){
						if(sheetObj.CellValue(row, "bse_qtr_cd") != '2Q'){
							msg1 = sheetObj.CellValue(row,col);
							msg2 = sheetObj.CellValue(row,col-2);
							msg3 = sheetObj.CellValue(row, "bse_qtr_cd");
							ComShowCodeMessage('SQM00055',msg1,msg2,msg3);
							sheetObj.CellValue(row,col) = "";
							sheetObj.CellValue(row,col-1) = "";
							sheetObj.CellValue(row,col-2) = "";
							return false;
						}
					}else if(month == "07" || month == "08" || month == "09"){
						if(sheetObj.CellValue(row, "bse_qtr_cd") != '3Q'){
							msg1 = sheetObj.CellValue(row,col);
							msg2 = sheetObj.CellValue(row,col-2);
							msg3 = sheetObj.CellValue(row, "bse_qtr_cd");
							ComShowCodeMessage('SQM00055',msg1,msg2,msg3);
							sheetObj.CellValue(row,col) = "";
							sheetObj.CellValue(row,col-1) = "";
							sheetObj.CellValue(row,col-2) = "";
							return false;
						}
					}else if(month == "10" || month == "11" || month == "12"){
						if(sheetObj.CellValue(row, "bse_qtr_cd") != '4Q'){
							msg1 = sheetObj.CellValue(row,col);
							msg2 = sheetObj.CellValue(row,col-2);
							msg3 = sheetObj.CellValue(row, "bse_qtr_cd");
							ComShowCodeMessage('SQM00055',msg1,msg2,msg3);
							sheetObj.CellValue(row,col) = "";
							sheetObj.CellValue(row,col-1) = "";
							sheetObj.CellValue(row,col-2) = "";
							return false;
						}
					}
				}
				
				//VVD입력시  target vvd의 주차정보 입력
				if(etcData["aply_wk"] != 0){
					sheetObj.CellValue(row,col-1) = etcData["aply_wk"];
				}else {
					var msg = sheetObj.CellValue(row,"trd_cd") + "-" 
							   + sheetObj.CellValue(row,"rlane_cd")+ "-" 
						       + sheetObj.CellValue(row,"dir_cd");
					ComShowCodeMessage('SQM00044',msg); //VVD code doesn't exist in {?msg1}
					sheetObj.CellValue(row,col) = "";
					sheetObj.CellValue(row,col-1) = "";
					sheetObj.CellValue(row,col-2) = "";
					return false;
				}
				
				if(sheetObj.RowCount>1){
					for(var j=sheetObj.HeaderRows;j<sheetObj.Rows-1;j++){
						if( sheetObj.CellValue(row,"rlane_cd") == sheetObj.CellValue(j,"rlane_cd")
					   && sheetObj.CellValue(row,"dir_cd")    == sheetObj.CellValue(j,"dir_cd")
					   && sheetObj.CellValue(row,"grp_no")   != sheetObj.CellValue(j,"grp_no")
						  ){
							if(sheetObj.CellValue(row,"rhq_cd") == sheetObj.CellValue(j,"rhq_cd")){
								//From, To중  VVD 입력시에 입력 VVD가 이미 입력된 기간에 포함된 VVD인지 체크
								if( etcData["aply_wk"]>=sheetObj.CellValue(j,"aply_fm_yrwk")
								 && etcData["aply_wk"]<=sheetObj.CellValue(j,"aply_to_yrwk")){
									ComShowCodeMessage('SQM00043');//"This Week is already included."
									sheetObj.CellValue(row,col) = "";
									sheetObj.CellValue(row,col-1) = "";
									sheetObj.CellValue(row,col-2) = "";
									return false;
								}
								
								//From, To VVD가 둘다 입력되었을때는 전체 기간을 포함하는 지도 체크
								if(sheetObj.CellValue(row,"fm_vvd_cd") != "" && sheetObj.CellValue(row,"to_vvd_cd") != "" ){
									if(	 sheetObj.CellValue(row,"aply_fm_yrwk")<=sheetObj.CellValue(j,"aply_fm_yrwk")
									 &&	 sheetObj.CellValue(row,"aply_to_yrwk")>=sheetObj.CellValue(j,"aply_to_yrwk")){
										ComShowCodeMessage('SQM00043');//"This Week is already included."
										sheetObj.CellValue(row,col) = "";
										sheetObj.CellValue(row,col-1) = "";
										sheetObj.CellValue(row,col-2) = "";
										return false;
									}
								
								}
							}
						}
					}
					
					// 동일 Group에 VVD와 주차 정보를 입력한다.
					for(var k=sheetObj.HeaderRows;k<sheetObj.Rows-1;k++){
						if( sheetObj.CellValue(row,"rlane_cd") == sheetObj.CellValue(k,"rlane_cd")
							&& sheetObj.CellValue(row,"dir_cd") == sheetObj.CellValue(k,"dir_cd")
							&& sheetObj.CellValue(row,"grp_no") == sheetObj.CellValue(k,"grp_no")
						   ){
							sheetObj.CellValue2(k,col) = value;
							sheetObj.CellValue2(k,col-1) = etcData["aply_wk"];
							sheetObj.CellValue2(k,col-2) = etcData["cost_yrmon"];
						}
					}
				}
			
				//해당 VVD가 Alloc 적용됐거나 QTA Edit에서 매뉴얼로 수정되었는지 확인
				if(sheetObj.CellValue(row,"fm_vvd_cd") != "" && sheetObj.CellValue(row,"to_vvd_cd") != "" ){
					var aply_fm_yrwk = sheetObj.CellValue(row,"aply_fm_yrwk");
					var aply_to_yrwk = sheetObj.CellValue(row,"aply_to_yrwk");
					var rtnXml1 = sheetObj.GetSearchXml("ESM_SQM_0032GS.do","f_cmd="+SEARCH02+"&f_fm_wk="+aply_fm_yrwk+"&f_to_wk="+aply_to_yrwk+"&"+params);	
					var vvdList = ComGetEtcData(rtnXml1, "vvdList");
					if(vvdList != "" && vvdList != null){
						vvdList = vvdList.substr(1);
						vvdList = vvdList.split("&");
						var vvd = "";
						var mList = ""; //sqm_cng_tp_cd = M 인 VVD List
						var aList = ""; //sqm_cng_tp_cd = A 인 VVD List 
						for(i=0;i<vvdList.length;i++){
							vvd = vvdList[i].split("|");
							if(vvd[0] == "M"){
								mList += ","+vvd[1];
							}else if(vvd[0] == "A"){
								aList += ","+vvd[1];
							}
						}
						if(mList != "") mList = mList.substr(1);
						if(aList != "") aList = aList.substr(1);
						ComShowCodeMessage('SQM00050',aList,mList);
					}	
				}
				
			}else if(value == ""){
				if(sheetObj.RowCount>1){
					//VVD를 삭제했을 경우 동일 Group의 모든 VVD를 삭제
					for(var k=sheetObj.HeaderRows;k<sheetObj.Rows-1;k++){
						if( sheetObj.CellValue(row,"rlane_cd") == sheetObj.CellValue(k,"rlane_cd")
							&& sheetObj.CellValue(row,"dir_cd") == sheetObj.CellValue(k,"dir_cd")
							&& sheetObj.CellValue(row,"grp_no") == sheetObj.CellValue(k,"grp_no")
						   ){
							sheetObj.CellValue2(k,col) = "";
							sheetObj.CellValue2(k,col-1) = "";
							sheetObj.CellValue2(k,col-2) = "";
						}
					}
				}
			}

			break;
		case "delete":
			for(i=0;i<sheetObj.LastRow+1;i++){
				if(sheetObj.CellValue(i, "ibflag") == 'I'){
					if(sheetObj.CellValue(i, "delete") == true){
						sheetObj.CellValue(i, "delete") = false
					}
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
  	var formObj = document.form;
  	var rlaneCd  = comboObjects[5].Code;
	if (rlaneCd != "") {	
		toggleButtons("SEARCH1");
	}else{
		toggleButtons("SEARCH2");
	}
 	sheetObj.SumText(0, "ibflag") = "";
 	sheetObj.SumText(0, "bse_yr") = "TOTAL";
 	
	//grp_no의 맥스값 찾기
	max = sheetObj.CellValue(sheetObj.HeaderRows,"grp_no");
	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
		if(max <= Number(sheetObj.CellValue(i,"grp_no"))){
			max = sheetObj.CellValue(i,"grp_no");
		}
	}
 }   
 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj, formObj, sAction){

 	switch(sAction) {
 		
 		case IBSAVE:  // 화면 저장시에

 			for(var i=sheetObj.HeaderRows;i<sheetObj.Rows-1;i++){
 				if(sheetObj.CellValue(i,"rgn_ofc_cd") == ""){
 					ComShowCodeMessage('SQM00024','Office');//Please Input Office.
 					return false;
 				}
 				
 				//from_week가 to_week 보다 느릴때
 				if(sheetObj.CellValue(i,"aply_fm_yrwk")>sheetObj.CellValue(i,"aply_to_yrwk")){
 					ComShowCodeMessage('SQM00022',sheetObj.CellValue(i,"seq")); 
 					//To week can't be earlier than From week.\nPlease check the row : {?msg1} SEQ.
 					return false;
 				}		
 			
 				if(sheetObj.CellValue(i,"fm_vvd_cd") == ""
 					|| sheetObj.CellValue(i,"to_vvd_cd") == ""){
 					ComShowCodeMessage('SQM00024','VVD');//Please Input VVD.
 					return false;
 				}
 				if(sheetObj.CellValue(i,"fm_vvd_cd").length!=9
 					||sheetObj.CellValue(i,"to_vvd_cd").length!=9){
 					ComShowCodeMessage('SQM00007','VVD(Seq:'+sheetObj.CellValue(i,"seq")+')');//VVD code is invaild
 					return false;
 				}
 				
 				
 			}

     		break;
     		
		case MULTI01:  // Creation
			//Creation 전 RHQ에는 Portion을 부여했으나 
			//해당 RHQ 산하의 Office에게 Portion을 부여하지 않은 RHQ List를 조회후 List가 없을경우 Creation.
			var arrXml = doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
			var OfcZeroPortion = ComGetEtcData(arrXml, "OfcZeroPortion");
			if(OfcZeroPortion != null && OfcZeroPortion != ""){
				ComShowCodeMessage("SQM00052", OfcZeroPortion.substr(1));
				return false;
			}
			break;
     		
 	}
 	return true;
 }
  
  
	/**
	 * 화면의 모든 버튼들의 Enable/Disable을 처리
	 */
function toggleButtons(step) {
 switch (step) {
	   case "INIT":
	       ComBtnEnable("btn_Retrieve");
	       ComBtnDisable("btn_Save");
	       ComBtnDisable("btn_Creation");
	       ComBtnDisable("btn_Downexcel");
	       ComBtnDisable("btn_RowGrpAdd");
	       ComBtnDisable("btn_RowAdd");
	       ComBtnDisable("btn_FigureInquiry");
	       break;
	   case "SEARCH1":
		   ComBtnEnable("btn_Save");
		   ComBtnEnable("btn_Downexcel");
	       ComBtnEnable("btn_Creation");
	       ComBtnEnable("btn_RowGrpAdd");
	       ComBtnEnable("btn_RowAdd");
	       break;
	   case "SEARCH2":
		   ComBtnDisable("btn_Creation");
		   ComBtnDisable("btn_RowGrpAdd");
		   ComBtnDisable("btn_RowAdd");
		   ComBtnEnable("btn_Save");
		   ComBtnEnable("btn_Downexcel");
	       break;

   
 }
}
	 
 /**
  * 특정이름의 값을 searchParams 에서 변경 가져온다.
  * 
  * @param {string} paramName	필수, 변경할 변수 명
  * @param {string} paramValue	필수, 변경할 변수 값
  */
 function ComSetParams(paramName, paramValue) {
 	try {
         var posName = params.indexOf(escape(paramName) + '=');
         if (posName != -1) {
         	var posValue = posName + (escape(paramName) + '=').length;
         	var endPos   = params.indexOf('&', posValue);
         	
         	if (endPos != -1)
         		params = unescape(params.substring(0, posValue)) + paramValue + unescape(params.substring(endPos));
             else
             	params = unescape(params.substring(0, posValue)) + paramValue;
         }
     } catch(err) { ComFuncErrMsg(err.message); }
 }
 
  /**
 * Sheet1 클릭 시
 *
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet1_OnClick(sheetObj, row, col){
	switch(sheetObj.ColSaveName(col)){
		case "delete":
			var rhqCode = sheetObj.CellValue(row, "rhq_cd");
			for(i=0;i<sheetObj.LastRow+1;i++){
				if(sheetObj.CellValue(i, "ibflag") == 'I'){
					if(sheetObj.CellValue(i, "rhq_cd") == rhqCode){
						sheetObj.RowDelete(i, false);
						i--;
					}
				}
			}
			break;
	}
}
/* 개발자 작업  끝 */