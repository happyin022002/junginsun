/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0601.js
*@FileTitle      : KPI Upload
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.30
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.30 이혜민
* 1.0 Creation
* 2015.04.15 김용습 [CHM-201535206] KPI Management "Week" 조건 추가
* 2015.04.27 김용습 [CHM-201535626] (SQM) TPS 자리수 Validation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends 
 * @class ESM_SQM_0601 : ESM_SQM_0601 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0601() {
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
				f_bse_tp_cd_0601_OnChange();
				break;
				
			case "btn_Retrieve":
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;
				
			case "btn_Save":
				doActionIBSheet(sheetObj, formObj, IBSAVE);
				break;
				
			case "btn_1qTransfer":
				doActionIBSheet(sheetObj, formObj, MULTI01);
				break;		
				
			case "btn_DownExcel":
				doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
				break;
				
			case "btn_LoadExcel":
				doActionIBSheet(sheetObj, formObj, IBLOADEXCEL);
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
	toggleButtons();
	loadingMode = false;
}

function initControl() {
	var formObj = document.form;
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
				
				var HeadTitle1 =  "STS|SEQ|Year|Quarter|Week|Trade Bound|Account Group|G.Customer Code|G.Customer Name|Load|CMPB(RA)|CM(RA)";
				
				var headCount = ComCountHeadTitle(HeadTitle1);
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, false, true, false, false);
				
				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				
				// 전체 높이 설정
				style.height = GetSheetHeight(18);
				
				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtStatus,		30,		daCenter,	true,	"ibflag",					false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtSeq,			30,		daCenter,	true,	"seq",						false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			40,		daCenter,	true,	"bse_yr",					false,		"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,		daCenter,	true,	"bse_qtr_cd",				false,		"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,		daCenter,	true,	"bse_wk",				false,		"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			100,		daCenter,	true,	"trd_bnd_cd",					false,		"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			110,		daCenter,	true,	"acct_tgt_cd",			false,		"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			130,		daCenter,	true,	"cust_grp_id",			false,		"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			150,		daLeft,		true,	"cust_grp_nm",			false,		"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	85,		daRight,	true,	"lod_qty",					false,	"",	dfInteger,	0,	true,		true, 5);
				InitDataProperty(0,	cnt++,	dtData,			85,		daRight,	true,	"ra_cmpb_amt",			false,	"",	dfInteger,	0,	true,		true, 5);
				InitDataProperty(0,	cnt++,	dtAutoSum,	95,		daRight,	true,	"ra_cm_uc_amt",		false,	"|lod_qty|*|ra_cmpb_amt|",	dfInteger,		0,	false,	false);

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
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0601GS.do", FormQueryString(formObj));
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
				ComXml2ComboItem(arrXml[5], formObj.f_acct_tgt_cd, "code", "name");
			
			ComOpenWait(false);
			break;
		
		case IBSEARCH:          // 화면 조회 시
			if (!validateForm(sheetObj, formObj, sAction)) return;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			searchParams = FormQueryString(formObj);
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0601GS.do", searchParams);
			sheetObj.LoadSearchXml(rtnXml);
			var bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
			
			if (bse_tp_cd == "Y") { //Yearly 선택
				sheetObj.ColHidden("bse_qtr_cd") = true;
			}else{  //Quarterly 선택
				sheetObj.ColHidden("bse_qtr_cd") = false;
			}
			
			var etcData = getEtcData(rtnXml);
			formObj.dataCnt.value = etcData["dataCnt"];
			toggleButtons("LOAD");
			if(etcData["dataCnt"] != 0){
				toggleButtons("SAVE"); //save 활성화
				if(bse_tp_cd == "Y"){
					check1QTransferData();
				}	
			}
			ComOpenWait(false);
			sheetObj.SumText(0, "ibflag") = "";
			sheetObj.SumText(0, "bse_yr") = "TOTAL";
			break;
		
		case SEARCH01:		//저장, 조회 후 1Q 데이터가 있는지 없는지 확인
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("ESM_SQM_0601GS.do", sParam);
			ComOpenWait(false);
			return sXml;
			break;	
			
		case SEARCH02:          // Week 콤보셋팅
            formObj.f_cmd.value = SEARCH02;
            
            var sXml   = sheetObj.GetSearchXml("ESM_SQM_0601GS.do", FormQueryString(formObj));
            var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
            var arrXml = sXml.split("|$$|");

            if (arrXml.length > 0)
                ComXml2ComboItem(arrXml[0], formObj.f_to_wk, "code", "name");

            comboObjects[4].Index = 0;
            break;
			
		case IBSAVE:		// 저장
			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006");
		        return false;
		    } else {
		    	if (!validateForm(sheetObj, formObj, sAction)){ 
		    		return false;
		    	}
		    	if(ComShowConfirm (ComGetMsg("SQM00004")) != 1){
		    		return false;
		    	}
		    }
			ComOpenWait(true);
			
			ComSetSearchParams("f_cmd", MULTI);
			sheetObj.DoSave("ESM_SQM_0601GS.do", searchParams, -1, false);
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
			
		case MULTI01:          // 1Q Transfer
			if (ComShowConfirm (ComGetMsg("SQM00012",'transfer 1Q data')) != 1) {
				return false;
		    }
			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI01);
			var sXml = sheetObj.GetSaveXml("ESM_SQM_0601GS.do", searchParams);
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
			var dataCnt = formObj.dataCnt.value;
			ComOpenWait(true);
			if(dataCnt == "0"){
				sheetObj.RemoveAll();
				sheetObj.LoadExcel(-1, 1, "", -1, -1, "");
			}else{
				loadExcelRowCnt    = sheetObj.HeaderRows + sheetObj.TotalRows;
				loadExcelTotFlg    = true;		// 화면에 Total Row 존재 여부
				var bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
				if (bse_tp_cd == "Y") { //Yearly 선택
					loadExcelExField   = "|lod_qty|ra_cmpb_amt|ra_cm_uc_amt|bse_qtr_cd|";		// 비교 제외 필드
				}else{  //Quarterly 선택
					loadExcelExField   = "|lod_qty|ra_cmpb_amt|ra_cm_uc_amt|";		// 비교 제외 필드
				}
				loadExcelAplyField = "|lod_qty|ra_cmpb_amt|";		// 반영 필드
				
				var rtn = window.showModalDialog("ESM_SQM_1001.do?" + searchParams, window, "dialogHeight:620px;dialogWidth:1050px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");
				
			}
			toggleButtons("SAVE");
			sheetObj.SumText(0, "ibflag") = "";
			sheetObj.SumText(0, "bse_yr") = "TOTAL";
			ComOpenWait(false);
			break;
    }
}

 /**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction){
	var qta = ComGetObjValue(formObj.f_bse_qtr_cd); //Quarter
	var bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd);
	
  	switch(sAction) {
  		case IBSAVE:  // 화면 저장시에
			if(bse_tp_cd == "Q"){
				if(qta == "1Q"){
					var Row1 = sheetObj.FindText("bse_qtr_cd", "2", sheetObj.HeaderRows, 0);
					var Row2 = sheetObj.FindText("bse_qtr_cd", "3", sheetObj.HeaderRows, 0);
					var Row3 = sheetObj.FindText("bse_qtr_cd", "4", sheetObj.HeaderRows, 0);
					if(Row1 != "-1" || Row2 != "-1" || Row3 != "-1"){
						ComShowCodeMessage('SQM00040' , '1Q'); //There is data which is not {?msg1} data on the sheet.
						return false;
					}
				}else if(qta == "2Q"){
					var Row1 = sheetObj.FindText("bse_qtr_cd", "1", sheetObj.HeaderRows, 0);
					var Row2 = sheetObj.FindText("bse_qtr_cd", "3", sheetObj.HeaderRows, 0);
					var Row3 = sheetObj.FindText("bse_qtr_cd", "4", sheetObj.HeaderRows, 0);
					if(Row1 != "-1" || Row2 != "-1" || Row3 != "-1"){
						ComShowCodeMessage('SQM00040' , '2Q'); //There is data which is not {?msg1} data on the sheet.
						return false;
					}
				}else if(qta == "3Q"){
					var Row1 = sheetObj.FindText("bse_qtr_cd", "1", sheetObj.HeaderRows, 0);
					var Row2 = sheetObj.FindText("bse_qtr_cd", "2", sheetObj.HeaderRows, 0);
					var Row3 = sheetObj.FindText("bse_qtr_cd", "4", sheetObj.HeaderRows, 0);
					if(Row1 != "-1" || Row2 != "-1" || Row3 != "-1"){
						ComShowCodeMessage('SQM00040' , '3Q'); //There is data which is not {?msg1} data on the sheet.
						return false;
					}
				}else if(qta == "4Q"){
					var Row1 = sheetObj.FindText("bse_qtr_cd", "1", sheetObj.HeaderRows, 0);
					var Row2 = sheetObj.FindText("bse_qtr_cd", "2", sheetObj.HeaderRows, 0);
					var Row3 = sheetObj.FindText("bse_qtr_cd", "3", sheetObj.HeaderRows, 0);
					if(Row1 != "-1" || Row2 != "-1" || Row3 != "-1"){
						ComShowCodeMessage('SQM00040' , '4Q'); //There is data which is not {?msg1} data on the sheet.
						return false;
					}
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
		var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=subTrade&code_param=" + value + "&all_flag=All");
		
		ComXml2ComboItem(sXml, formObj.f_sub_trd_cd, "code", "name");
		formObj.f_sub_trd_cd.Index = 0;
	} else {
		formObj.f_sub_trd_cd.RemoveAll();
		formObj.f_sub_trd_cd.InsertItem(0, "All", "All");
		formObj.f_sub_trd_cd.Index = 0;
	}
}

 
/**
 *  선택된 Account Group 에 해당하는 Group Customer 정보 가져와서 Combo Box 셋팅
 */
function f_acct_tgt_cd_OnChange(obj, value, text){
	var formObj  = document.form;
 	var sheetObj = sheetObjects[0];
 	
 	if (value != "All") {
 		var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=groupCustomer&code_param=" + value + "&all_flag=All");
 		ComXml2ComboItem(sXml, formObj.f_cust_grp_id, "code", "code|name");
 		formObj.f_cust_grp_id.Index = 0;
 	} else {
 		formObj.f_cust_grp_id.RemoveAll();
 		formObj.f_cust_grp_id.InsertItem(0, "All", "All");
 		formObj.f_cust_grp_id.Index = 0;
 	}
}
 
/**
* f_bse_tp_cd 바뀌었을때 qtr_cd, week 변경
*/
function f_bse_tp_cd_0601_OnChange() {
	var formObj    = document.form;
	var sheetObj = sheetObjects[0];
	var bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
	
	if (bse_tp_cd == "Y") { //Yearly 선택
//		sheetObj.ColHidden("bse_qtr_cd") = true;
		document.getElementById("div_1QTransfer").style.display = "inline";
		document.getElementById("div_qtr").style.display = "none";
		formObj.f_bse_qtr_cd.style.display = "none";
		document.getElementById("div_period").style.display = "none";
	}else{  //Quarterly 선택
//		sheetObj.ColHidden("bse_qtr_cd") = false;
		document.getElementById("div_1QTransfer").style.display = "none";
		document.getElementById("div_qtr").style.display = "inline";
		formObj.f_bse_qtr_cd.style.display = "inline";
		document.getElementById("div_period").style.display = "inline";
		formObj.f_bse_qtr_cd.BackColor = "#CCFFFD"; //필수입력 input1 색으로 변환
	}
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
* 화면의 모든 버튼들의 Enable/Disable 을 처리
*/
function toggleButtons(step) {
	ComBtnDisable("btn_Save"); 
	ComBtnDisable("btn_1qTransfer");
	ComBtnDisable("btn_LoadExcel");
	
	switch (step) {
		case "SAVE": //save 활성화
			ComBtnEnable("btn_LoadExcel");
			ComBtnEnable("btn_Save");
			break;
			
		case "LOAD": //load excel 활성화
			ComBtnEnable("btn_LoadExcel");
			break;		
	}
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
 * f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
 */
function f_bse_qtr_cd_OnChange(obj, value, text) {
	period_change();
	
    var formObj = document.form;
    doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
}

var validatesheetFn = function validatesheet(sheetObj,row,colName) {
	switch(colName) { 
		case "lod_qty":
			if(sheetObj.CellValue(row,colName) > 99999){
				sheetObj.CellBackColor(row,colName) = sheetObj.RgbColor(255, 0, 0);
				msg = "You can't input Load more than 100,000$/TEU.\n"
					+"==================================================================================\n";
				return false;              
			}
			break;
			
		case "ra_cmpb_amt":
			if(sheetObj.CellValue(row,colName) > 99999){
				sheetObj.CellBackColor(row,colName) = sheetObj.RgbColor(255, 0, 0);
				msg = "You can't input CMPB(RA) more than 100,000$/TEU.\n"
					+"==================================================================================\n";
				return false;              
			}
			break;
	}
	return true;
}

var setColHiddenFn = function setColHidden(sheetObj) {
	var formObj    = document.form;
	var bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
	if (bse_tp_cd == "Y") { //Yearly 선택
		sheetObj.ColHidden("bse_qtr_cd") = true;
	}else{  //Quarterly 선택
		sheetObj.ColHidden("bse_qtr_cd") = false;
	}
}

/* 개발자 작업  끝 */