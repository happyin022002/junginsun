/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0040.js
*@FileTitle      : QTA Set-up by RHQ (Contract TTL retrieve only)
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.21
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.21 SQM USER
* 1.0 Creation
* 2014.01.16 박은주 [CHM-201328244] IAS Sector Sales 판매시스템 개발
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends 
 * @class ESM_SQM_0040 : ESM_SQM_0040 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0040() {
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
		case "btn_Downexcel":
			doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
			break;

		case "btn_Pop0041":
			if (sheetObject.isDataModified == true) {
				ComShowCodeMessage("SQM00030","Office Distribute Result");
		        return false;
		    }
			formObj.f_cmd.value = "";
        	ComOpenPopup("/hanjin/ESM_SQM_0041.do?"+FormQueryString(formObj) + "&div_period=" + document.getElementById("div_period").innerHTML, 910, 530, "", "0,0", true);
			break;
		case "btn_Pop0042":
			if (sheetObject.isDataModified == true) {
				ComShowCodeMessage("SQM00030","Office QTA Simulation");
		        return false;
		    }
			formObj.f_cmd.value = "";
        	ComOpenPopup("/hanjin/ESM_SQM_0042.do?"+FormQueryString(formObj) + "&div_period=" + document.getElementById("div_period").innerHTML, 910, 530, "", "0,0", true);
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
	loadingMode = false;
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
* f_ob_div_cd 바뀌었을때 trade변경
*/
function f_ob_div_cd_OnChange(obj, value, text) {
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
			MergeSheet = msHeaderOnly;  //msNone; //msHeaderOnly //msPrevColumnMerge;
			
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 9, 100);
			
			var HeadTitle1 =  "SEQ|Year|Quarter|N.OB\n/OB|Office\nView|Trade|Sub\nTrade|Lane|Lane\nBound|Trade\nBound|Trade\nDirection|RHQ|Office|Load (TEU) Portion Setting|Load (TEU) Portion Setting|G.REV Portion Setting|G.REV Portion Setting";
			var HeadTitle2 =  "SEQ|Year|Quarter|N.OB\n/OB|Office\nView|Trade|Sub\nTrade|Lane|Lane\nBound|Trade\nBound|Trade\nDirection|RHQ|Office|PFMC %|Target %|PFMC %|Target %";

														

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);
			
			// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
			InitHeadMode(false, true, false, true, false, false);
			
			// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			
			// 전체 높이 설정
			style.height = GetSheetHeight(18);

			// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
			InitDataProperty(0,	cnt++,	dtSeq,		30,	  daCenter,  true,	"seq",				false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		50,	  daCenter,	 true,	"bse_yr",			false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		50,	  daCenter,	 true,	"bse_qtr_cd",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		50,	  daCenter,	 true,	"ob_div_cd",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		68,	  daCenter,	 true,	"ofc_vw_cd",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		50,	  daCenter,	 true,	"trd_cd",			false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		45,	  daCenter,	 true,	"sub_trd_cd",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		60,	  daCenter,	 true,	"rlane_cd",			false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		50,	  daCenter,	 true,	"dir_cd",			false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		50,	  daCenter,	 true,	"conv_dir_cd",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		60,	  daCenter,	 true,	"hul_bnd_cd",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		60,	  daCenter,	 true,	"rhq_cd",			false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		60,	  daCenter,	 true,	"rgn_ofc_cd",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtAutoSum,	83,   daRight,	 true,	"gid_lod_potn_rto",	false,	"",	dfFloat,	2,	false,	false);
			InitDataProperty(0,	cnt++,	dtAutoSum,	83,   daRight,	 true,	"lod_potn_rto",		false,	"",	dfFloat,	2,	false,	false,	5);
			InitDataProperty(0,	cnt++,	dtAutoSum,	83,   daRight,  true,	"gid_rev_potn_rto",	false,	"",	dfFloat,	2,	false,	false);
			InitDataProperty(0,	cnt++,	dtAutoSum,	83,   daRight,	 true,	"rev_potn_rto",		false,	"",	dfFloat,	2,	false,	false,	5);
			

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
		
		var sXml   = sheetObj.GetSearchXml("ESM_SQM_0040GS.do", FormQueryString(formObj));
		var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
		var arrXml = sXml.split("|$$|");
		
		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.f_bse_yr, "code", "name");
		if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], formObj.f_bse_qtr_cd, "code", "name");
		if (arrXml.length > 2)
			ComSetYearQta(arrXml[2]);
		if (arrXml.length > 3)
			ComXml2ComboItem(arrXml[3], formObj.f_ob_div_cd, "code", "name");
		if (arrXml.length > 4)
			ComXml2ComboItem(arrXml[4], formObj.f_rgn_ofc_cd, "code", "name");
		if (arrXml.length > 5)
			ComXml2ComboItem(arrXml[5], formObj.f_trd_dir, "code", "name");

		setTradeCombo();
		
		ComOpenWait(false);
		break;
	
	case IBSEARCH:          // 화면 조회 시
	
		if(ComGetObjValue(formObj.f_trd_cd) == ""){
			ComShowCodeMessage("SQM00013",'Trade');
	        return false;
		}
		formObj.f_cmd.value = SEARCH;
		ComOpenWait(true);
		var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0040GS2.do",FormQueryString(formObj));	
		ComOpenWait(false);
		sheetObj.LoadSearchXml(rtnXml);
		if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
			sheetObj.ColHidden("bse_qtr_cd") = true;
		} else {
			sheetObj.ColHidden("bse_qtr_cd") = false;
		}
	 	sheetObj.SumText(0, "seq") = "";
	 	sheetObj.SumText(0, "bse_yr") = "TOTAL";	
		break;


	case IBDOWNEXCEL:		// 엑셀 다운로드
		ComOpenWait(true);
		sheetObj.MergeSheet = msNone;
		sheetObj.Down2Excel(-1, false, false, true);
		sheetObj.MergeSheet = msHeaderOnly;
		ComOpenWait(false);
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
 * onChange event
 * f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
 */	
 function f_trd_cd_OnChange(obj, value, text) {
	 setLaneCombo();
 }

/* 개발자 작업  끝 */