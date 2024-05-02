/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0014.js
*@FileTitle      : QTA Simulation by Head Office 
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.08
*@LastModifier   : JEONGMIN CHO
*@LastVersion    : 1.0
* 2013.05.08 JEONGMIN CHO
* 1.0 Creation
* 2013.11.11 박은주 [CHM-201327449] SQM 몇몇 화면 내 틀 고정 기능 추가
* 2014.01.16 박은주 [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2016.06.24 Planning IAS-IP Supply 에외처리
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends 
 * @class ESM_SQM_0014 : ESM_SQM_0014 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0014() {
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

var msg = "";


/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
	var sheetObject = sheetObjects[0];
	var formObj     = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
			case "f_bse_tp_cd":
				f_bse_tp_cd_OnChange();
				break;
			case "btn_Retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject, formObj, IBSAVE);
				break;

			case "btn_Confirm":
				doActionIBSheet(sheetObject, formObj, MULTI01);
				break;
			case "btn_Downexcel":
				doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
				break;
			case "btn_Loadexcel":
				doActionIBSheet(sheetObject,formObj,IBLOADEXCEL);
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
	axon_event.addListenerForm  ('click', 'obj_click',   formObj); 
	toggleButtons("INIT");
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
				
				var HeadTitle1 =  "STS|SEQ|Year|Quarter|Trade|Sub Trade|R.Lane|Lane\nBound|Trade\nBound|Trade\nDireciton|Week|VVD||||Supply|Unit REV / Cost (TEU)|Unit REV / Cost (TEU)|Unit REV / Cost (TEU)|Unit REV / Cost (TEU)|Unit REV / Cost (TEU)|Unit REV / Cost (TEU)|TTL Sales QTA|TTL Sales QTA|TTL Sales QTA|TTL Sales QTA|TTL Sales QTA|TTL Sales QTA";
				var HeadTitle2 =  "STS|SEQ|Year|Quarter|Trade|Sub Trade|R.Lane|Lane\nBound|Trade\nBound|Trade\nDireciton|Week|VVD||||Supply|L/F(%)|GRPB|CMCB(PA)|CMCB(RA)|CMPB(PA)|CMPB(RA)|Load|REV|CM cost(PA)|CM cost(RA)|CM(PA)|CM(RA)";

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1), 16, 0, true);
				
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, false, true, false, false);
				
				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				
				// 전체 높이 설정
				style.height = GetSheetHeight(18);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtStatus,		30,daCenter,	true,	"ibflag",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtSeq,			30,	daCenter,	true,	"seq",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,	daCenter,	true,	"bse_yr",		false,	"",	dfNone,		0,	false,	false);
				if(loadExcelVal=="Y")
					InitDataProperty(0,	cnt++,	dtHidden,	50,	daCenter,	true,	"bse_qtr_cd",	false,	"",	dfNone,		0,	false,	false);
				else
					InitDataProperty(0,	cnt++,	dtData,		50,	daCenter,	true,	"bse_qtr_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,	daCenter,	true,	"trd_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			70,	daCenter,	true,	"sub_trd_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,	daCenter,	true,	"rlane_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,	daCenter,	true,	"dir_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,	daCenter,	true,	"conv_dir_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,	daCenter,	 true,	"hul_bnd_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,	daCenter,	true,	"bse_wk",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	daCenter,	true,	"vvd",		    false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		80,	daCenter,	true,	"vsl_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		80,	daCenter,	true,	"skd_voy_no",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		80,	daCenter,	true,	"skd_dir_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,	daRight,	true,	"fnl_bsa_capa",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	daRight,	true,	"ldf_rto",		false,	"",	dfFloat,	2,	true,	true,	5);
				InitDataProperty(0,	cnt++,	dtData,			80,	daRight,	true,	"grs_rpb_rev",	false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtData,			80,	daRight,	true,	"pa_cm_uc_amt",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	daRight,	true,	"ra_cm_uc_amt",	false,	"",	dfInteger,	0,	false,	false);

//				InitDataProperty(0,	cnt++,	dtAutoSum,		110,daRight,	true,	"pa_cm_u_amt",	false,	"IF(|ldf_rto| == 0, 0, IF(|grs_rpb_rev|==0, 0, |grs_rpb_rev|-|pa_cm_uc_amt|))",	dfInteger,	0,	false,	false);
//				InitDataProperty(0,	cnt++,	dtAutoSum,		110,daRight,	true,	"ra_cm_u_amt",	false,	"IF(|ldf_rto| == 0, 0, IF(|grs_rpb_rev|==0, 0, |grs_rpb_rev|-|ra_cm_uc_amt|))",	dfInteger,	0,	false,	false);
//				InitDataProperty(0,	cnt++,	dtAutoSum,		110,daRight,	true,	"load",			false,	"|fnl_bsa_capa|*|ldf_rto|*0.01",dfInteger,	0,	false,	false);
//				InitDataProperty(0,	cnt++,	dtAutoSum,		110,daRight,	true,	"g_rev",		false,	"|grs_rpb_rev|*|load|",			dfInteger,	0,	false,	false);
//				InitDataProperty(0,	cnt++,	dtAutoSum,		110,daRight,	true,	"pa_cm_c",		false,	"|pa_cm_uc_amt|*|load|",		dfInteger,	0,	false,	false);
//				InitDataProperty(0,	cnt++,	dtAutoSum,		110,daRight,	true,	"ra_cm_c",		false,	"|ra_cm_uc_amt|*|load|",		dfInteger,	0,	false,	false);
//				InitDataProperty(0,	cnt++,	dtAutoSum,		110,daRight,	true,	"pa_cm",		false,	"IF(|ldf_rto| == 0, 0, IF(|grs_rpb_rev|==0, 0, |g_rev|-|pa_cm_c|))",			dfInteger,	0,	false,	false);
//				InitDataProperty(0,	cnt++,	dtAutoSum,		110,daRight,	true,	"ra_cm",		false,	"IF(|ldf_rto| == 0, 0, IF(|grs_rpb_rev|==0, 0, |g_rev|-|ra_cm_c|))",			dfInteger,	0,	false,	false);
//				
				InitDataProperty(0,	cnt++,	dtAutoSum,		110,daRight,	true,	"pa_cm_u_amt",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		110,daRight,	true,	"ra_cm_u_amt",	false,	"",	dfInteger,	0,	false,	false);				
				InitDataProperty(0,	cnt++,	dtAutoSum,		110,daRight,	true,	"lod_qty",		false,	"",	dfInteger,	0,	false,	false, 5);
				InitDataProperty(0,	cnt++,	dtAutoSum,		110,daRight,	true,	"g_rev",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		110,daRight,	true,	"pa_cm_c",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		110,daRight,	true,	"ra_cm_c",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		110,daRight,	true,	"pa_cm",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		110,daRight,	true,	"ra_cm",		false,	"",	dfInteger,	0,	false,	false);
				
				MinimumValue(0, "ldf_rto") = "0";
			}
			break;
	}
}
/**
 * f_click가 체크될때 direction콤보 change
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
	
 	if (bse_tp_cd == "Y") {
 		formObj.f_bse_qtr_cd.Enable = false;
 	} else {
 		formObj.f_bse_qtr_cd.Enable = true;
 	}
 	
	period_change();
	setTradeCombo();
	toggleButtons("INIT");
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
 
 /**
  * f_bse_tp_cd,f_bse_qtr_cd,f_bse_yr가 바뀌었을때 trade콤보 settting
  */
 function setTradeCombo() {
	 	var formObj = document.form;
	 	var trd_cd     = ComGetObjValue(formObj.f_trd_cd);
	    var bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
	    var bse_yr     = ComGetObjValue(formObj.f_bse_yr);
	    
	 	if(bse_qtr_cd !="" && bse_yr !=""){
	
		 	var param = "f_cmd=" + SEARCH02
		     + "&code_name=tradeControl"
		     + "&code_param= " 
		     + "&all_flag="
		     + "&" + FormQueryString(formObj);	// Trade
		
		 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
		 	ComXml2ComboItem(xmlStr, formObj.f_trd_cd, "code", "name");	
		 // 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
			var index = SearchIndex(formObj.f_trd_cd, trd_cd);
	 		formObj.f_trd_cd.Index = index;
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
			
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0014GS.do", FormQueryString(formObj));
			var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
			var arrXml = sXml.split("|$$|");
			
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 2)
				ComSetYearQta(arrXml[2]);
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], formObj.f_trd_dir, "code", "name");
			
			setTradeCombo();
			ComOpenWait(false);
			break;
		
		case IBSEARCH:          // 화면 조회 시
		
			if(ComGetObjValue(formObj.f_trd_cd) == ""){
				ComShowCodeMessage("SQM00013",'Trade');
		        return false;
			}
			formObj.f_cmd.value = SEARCH;
			searchParams = FormQueryString(formObj);
			ComOpenWait(true);
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0014GS.do",searchParams);	
			ComOpenWait(false);
			sheetObj.LoadSearchXml(rtnXml);
			
			if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
				sheetObj.ColHidden("bse_qtr_cd") = true;
			} else {
				sheetObj.ColHidden("bse_qtr_cd") = false;
			}
			
			var etcData = getEtcData(rtnXml);
			
			if(etcData["dataCnt"] == 1 ){ 
				toggleButtons("AllConfirm");
			}else {
				toggleButtons("SEARCH");
			}
			if (sheetObj.SearchRows == 0) {
				toggleButtons("INIT");
			}

			
			break;
			
		case IBSAVE:          // 화면 저장시
		
			if (!validateForm(sheetObj, formObj, sAction)) return false;

			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006");
		        return false;
		    } else if (ComShowConfirm (ComGetMsg("SQM00004")) != 1) {
				return false;
		    }
			
			ComOpenWait(true);
			
			ComSetSearchParams("f_cmd", MULTI);
	        
			sheetObj.DoSave("ESM_SQM_0014GS.do", searchParams, -1, false);
			
			ComOpenWait(false);
	
			var State = sheetObj.EtcData("TRANS_RESULT_KEY");
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('SQM00001','Data');
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
			
			break;
			
			
		case MULTI01:          // 화면 confirm시
		
			
			if (sheetObj.isDataModified == true) {
				ComShowCodeMessage("SQM00030",'confirm');
		        return false;
			}
		 	if (ComShowConfirm (ComGetMsg('SQM00012','Confirm')) != 1) {
				return false;
		    }
			
			ComOpenWait(true);
			
			ComSetSearchParams("f_cmd", MULTI01);

			sheetObj.DoSearch("ESM_SQM_0014GS.do", searchParams);
			
			ComOpenWait(false);
			var State = sheetObj.EtcData("TRANS_RESULT_KEY");
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('SQM00016','Data');
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
			break;
			
		case IBLOADEXCEL:		// 엑셀 업로드
			
			loadExcelRowCnt    = sheetObj.HeaderRows + sheetObj.TotalRows;
			loadExcelTotFlg    = true;		// 화면에 Total Row 존재 여부
			loadExcelVal = ComGetObjValue(formObj.f_bse_tp_cd[0]); //자식창 inisheet시에 bse_tp_cd히든 여부 설정
			if(ComGetObjValue(formObj.f_bse_tp_cd[0])=="Y")
				loadExcelExField   = "|bse_qtr_cd|dir_cd|hul_bnd_cd|vsl_cd|skd_voy_no|skd_dir_cd|ldf_rto|grs_rpb_rev|pa_cm_u_amt|ra_cm_u_amt|lod_qty|g_rev|pa_cm_c|ra_cm_c|pa_cm|ra_cm|";		// 비교 제외 필드
			else
				loadExcelExField   = "|dir_cd|hul_bnd_cd|vsl_cd|skd_voy_no|skd_dir_cd|ldf_rto|grs_rpb_rev|pa_cm_u_amt|ra_cm_u_amt|lod_qty|g_rev|pa_cm_c|ra_cm_c|pa_cm|ra_cm|";		// 비교 제외 필드
			loadExcelAplyField = "|ldf_rto|grs_rpb_rev|";		// 반영 필드

			
			var rtn = window.showModalDialog("ESM_SQM_1001.do?" + searchParams, window, "dialogHeight:620px;dialogWidth:1050px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");

			if(rtn == "S")
				doActionIBSheet(sheetObj, formObj, IBSAVE);
			
			break;
			
		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.MergeSheet = msNone;
			sheetObj.Down2Excel(-1, false, false, false);
			sheetObj.MergeSheet = msHeaderOnly;
			ComOpenWait(false);
			break;
			
    }
}


/**
 * OnChange 이벤트 발생시 호출되는 function <br>
 * L/F, GRPB, Load 입력시 호출되며 값이 변경될때 계산된다. <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
 * @return 없음
 */  
function sheet1_OnChange(sheetObj, Row, Col, Value) {
 	var colName = sheetObj.ColSaveName(Col);

	var subTrdCd	= sheetObj.CellValue(Row, "sub_trd_cd");
	var ldfRto 		= sheetObj.CellValue(Row, "ldf_rto");
	var grsRpbRev 	= sheetObj.CellValue(Row, "grs_rpb_rev");
	var paCmUcAmt 	= sheetObj.CellValue(Row, "pa_cm_uc_amt");
	var raCmUcAmt 	= sheetObj.CellValue(Row, "ra_cm_uc_amt");
	var fnlBsaCapa 	= sheetObj.CellValue(Row, "fnl_bsa_capa");
	var lodQty 		= "0";
	var gRev 		= "0";
	var paCmC		= "0";
	var raCmC		= "0";
	
	switch(colName) {
		case "lod_qty":
 		case "ldf_rto":
 		case "grs_rpb_rev": 			
 			if(ldfRto == 0) {
 				sheetObj.CellValue2(Row,"pa_cm_u_amt") = 0;
 				sheetObj.CellValue2(Row,"ra_cm_u_amt") = 0;
 			} else {
 				if(grsRpbRev == 0) {
 	 				sheetObj.CellValue2(Row,"pa_cm_u_amt") = 0;
 	 				sheetObj.CellValue2(Row,"ra_cm_u_amt") = 0;
 				} else {
 					sheetObj.CellValue2(Row,"pa_cm_u_amt") = grsRpbRev - paCmUcAmt;
 					sheetObj.CellValue2(Row,"ra_cm_u_amt") = grsRpbRev - raCmUcAmt;
 				}
 			}
 			
 			if(subTrdCd == "IP") {
 	 			lodQty = sheetObj.CellValue(Row, "lod_qty");
 			} else {
 	 			sheetObj.CellValue2(Row, "lod_qty") = fnlBsaCapa * ldfRto * 0.01;
 	 			lodQty = fnlBsaCapa * ldfRto * 0.01;
 			}
 			
 			sheetObj.CellValue2(Row,"g_rev")   = grsRpbRev * lodQty;
 			gRev = grsRpbRev * lodQty;
 			
 			sheetObj.CellValue2(Row,"pa_cm_c") = paCmUcAmt * lodQty;
 			paCmC = paCmUcAmt * lodQty;
 			
 			sheetObj.CellValue2(Row,"ra_cm_c") = raCmUcAmt * lodQty;
 			raCmC = raCmUcAmt * lodQty;
 			
 			if(ldfRto == 0) {
 				sheetObj.CellValue2(Row,"pa_cm") = 0;
 				sheetObj.CellValue2(Row,"ra_cm") = 0;
 			} else {
 				if(grsRpbRev == 0) {
 	 				sheetObj.CellValue2(Row,"pa_cm") = 0;
 	 				sheetObj.CellValue2(Row,"ra_cm") = 0;
 				} else {
 					sheetObj.CellValue2(Row,"pa_cm") = gRev - paCmC;
 					sheetObj.CellValue2(Row,"ra_cm") = gRev - raCmC;
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
	 for(var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
		 if(sheetObj.CellValue(i, "sub_trd_cd") == "IP") {
			 sheetObj.CellEditable(i,"lod_qty") = true;
		 }
	 }

	sheetObj.SumText(0, "ibflag") = "";
    sheetObj.SumText(0, "bse_yr") = "TOTAL";

	//단가 total값 set
	if(sheetObj.SumValue(0, "lod_qty")!=0){
		sheetObj.SumText(0, "pa_cm_uc_amt") = AddComma(Math.round(sheetObj.SumValue(0, "pa_cm_c")/sheetObj.SumValue(0, "lod_qty")));
		sheetObj.SumText(0, "ra_cm_uc_amt") = AddComma(Math.round(sheetObj.SumValue(0, "ra_cm_c")/sheetObj.SumValue(0, "lod_qty")));
		sheetObj.SumText(0, "pa_cm_u_amt") = AddComma(Math.round(sheetObj.SumValue(0, "pa_cm")/sheetObj.SumValue(0, "lod_qty")));
		sheetObj.SumText(0, "ra_cm_u_amt") = AddComma(Math.round(sheetObj.SumValue(0, "ra_cm")/sheetObj.SumValue(0, "lod_qty")));

	}else{
		sheetObj.SumText(0, "pa_cm_uc_amt") = 0;
		sheetObj.SumText(0, "ra_cm_uc_amt") = 0;
		sheetObj.SumText(0, "pa_cm_u_amt") = 0;
		sheetObj.SumText(0, "ra_cm_u_amt") = 0;
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
 * onChange event
 * f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
 */	
 function f_trd_cd_OnChange(obj, value, text) {
	 setLaneCombo();
}
 
 /**
  *   f_bse_yr, f_bse_qtr_cd, f_trd_cd 바뀌었을때  f_lane_cd, f_dir_cd 콤보조회
  */
 function setLaneCombo(){
	 	var formObj = document.form;
	 	var trd_cd  = ComGetObjValue(formObj.f_trd_cd);	// trade code
	    var rlane_cd     = ComGetObjValue(formObj.f_rlane_cd);
	    var dir_cd     = ComGetObjValue(formObj.f_dir_cd);
	    
		if (trd_cd != "All" && trd_cd != "") {	
		 	var param = "f_cmd=" + SEARCH02
		     + "&code_name=rLaneControl,BoundControl"
		     + "&code_param=null,null" 
		     + "&all_flag=All,All"
		     + "&" + FormQueryString(formObj);	// Trade
		
		 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
			var arrXml = xmlStr.split("|$$|");
			if (arrXml.length > 0) ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "name");		
			if (arrXml.length > 1)ComXml2ComboItem(arrXml[1], formObj.f_dir_cd, "code", "name");
			// 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
			var rlane_index = SearchIndex(formObj.f_rlane_cd, rlane_cd);
			var dir_index = SearchIndex(formObj.f_dir_cd, dir_cd);
			
			formObj.f_rlane_cd.Index = rlane_index; 	
			formObj.f_dir_cd.Index = dir_index; 		
		} else {
			formObj.f_rlane_cd.RemoveAll();
			formObj.f_rlane_cd.InsertItem(0, "All", "All");
			
			formObj.f_dir_cd.RemoveAll();
			formObj.f_dir_cd.InsertItem(0, "All", "All");
		}
 }
 
 /**
  * 화면의 모든 버튼들의 Enable/Disable 을 처리
  */
 function toggleButtons(step) {
 	switch (step) {
 		case "INIT":
 			ComBtnDisable("btn_Save");
 			ComBtnDisable("btn_Confirm");
 			ComBtnDisable("btn_Downexcel");
 			ComBtnDisable("btn_Loadexcel");
 			break;

 		case "SEARCH":
 			ComBtnEnable("btn_Save");
 			ComBtnEnable("btn_Downexcel");
 			ComBtnEnable("btn_Loadexcel");
 			ComBtnEnable("btn_Confirm");
 			break;
 			
 		case "AllConfirm":
 			ComBtnDisable("btn_Save");
 			ComBtnDisable("btn_Confirm");
 			ComBtnEnable("btn_Downexcel");
 			ComBtnDisable("btn_Loadexcel");
 			break;
 			

 	}
 }  
   
  /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj, formObj, sAction){
 	
 	switch(sAction) {

 		case IBSAVE:  // save시 
 			var upRow = sheetObj.FindStatusRow("U");
 			var uRow = upRow.split(";");
 			var sMsg = "";
 			for(var i=0;i<uRow.length-1;i++){ 			
 				if(eval(sheetObj.CellValue(uRow[i],"ldf_rto")) != 0 && eval(sheetObj.CellValue(uRow[i],"grs_rpb_rev")) == 0 ){
 					sMsg = sMsg + "\n" + sheetObj.CellValue(uRow[i],"trd_cd") 
 							+ "-" + sheetObj.CellValue(uRow[i],"rlane_cd")
 							+"-" + sheetObj.CellValue(uRow[i],"conv_dir_cd")
 							+"-" + sheetObj.CellValue(uRow[i],"bse_wk");

 				}
 			}
 			if(sMsg!=""){
				ComShowCodeMessage("SQM00037","Trade-Rlane-Bound-Week",sMsg);
				return false;	
 			}

 			break;
 	}

 	return true;
 }
/* 개발자 작업  끝 */