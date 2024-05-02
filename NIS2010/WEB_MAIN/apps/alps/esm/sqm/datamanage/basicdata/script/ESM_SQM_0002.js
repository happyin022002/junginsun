/*=========================================================
*Copyright(c) 2023 CyberLogitec
*@FileName       : ESM_SQM_0002.js
*@FileTitle      : Lane Direction Change
*Open Issues     :
*Change history  :
*@LastModifyDate : 2023.05.03
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2023.05.03 SQM USER
* 1.0 Creation
* 2014.01.16 박은주 [CHM-201328244] IAS Sector Sales 판매시스템 개발
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND02=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends 
 * @class ESM_SQM_0002 : ESM_SQM_0002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0002() {
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
			case "btn_Save":
				doActionIBSheet(sheetObject, formObj, IBSAVE);
				break;
			case "btn_Copy":
				doActionIBSheet(sheetObject, formObj,IBSEARCH_ASYNC01);
				break;
			case "btn_Downexcel":
				sheetObject.SpeedDown2Excel(-1);   
				break;
			case "btn_RowAdd":
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
	toggleButtons("INIT");
	doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
	
	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}
	
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
				MergeSheet = msHeaderOnly;
				
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);
				
				var HeadTitle =  "DEL|STS|SEQ|Trade|R.Lane|Lane Bound|Trade Bound|bse_tp_cd|bse_yr|bse_qtr_cd";
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle)+1, 0, 0, true);
				
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, false, true, false, false);
				
				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, false);
				
				// 전체 높이 설정
				style.height = GetSheetHeight(18);
				
				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtDelCheck,		30,	daCenter,	true,	"",				false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtStatus,		30,	daCenter,	true,	"ibflag",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtSeq,			30,	daCenter,	true,	"seq",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtComboEdit,	80,	daCenter,	true,	"trd_cd",		true,	"",	dfNone,	0,	false,	false,	3);
				InitDataProperty(0,	cnt++,	dtComboEdit,	80,	daCenter,	true,	"rlane_cd",		true,	"",	dfNone,	0,	false,	false,	5);
				InitDataProperty(0,	cnt++,	dtComboEdit,	100,daCenter,	true,	"dir_cd",		true,	"",	dfNone,	0,	false,	false,	1);
				InitDataProperty(0,	cnt++,	dtComboEdit,	100,daCenter,	true,	"conv_dir_cd",	true,	"",	dfNone,	0,	false,	false,	1);
				InitDataProperty(0,	cnt++,	dtHidden,      	80,	daCenter,	true,	"bse_tp_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,      	80,	daCenter,	true,	"bse_yr",	    false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,      	80,	daCenter,	true,	"bse_qtr_cd",	false,	"",	dfNone,	0,	false,	false);

				
                InitDataValid(0,"trd_cd",vtEngUpOnly );
                InitDataValid(0,"rlane_cd",vtEngUpOnly );
                InitDataValid(0,"dir_cd",vtEngUpOnly );
                InitDataValid(0,"conv_dir_cd",vtEngUpOnly );
				
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
			
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0002GS.do", FormQueryString(formObj));
			var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
			var arrXml = sXml.split("|$$|");
			
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 2)
				ComSetYearQta(arrXml[2]);
			if (arrXml.length > 3){
				ComXml2ComboItem(arrXml[3], formObj.f_trd_cd, "code", "name");
				comboObjects[2].InsertItem(0, 'All', 'All');
				ComSqmSetIBCombo(sheetObj, arrXml[3], "trd_cd", true);
			}
			if (arrXml.length > 4){
				ComXml2ComboItem(arrXml[4], formObj.f_dir_cd, "code", "name");
				comboObjects[4].InsertItem(0, 'All', 'All');
				ComSqmSetIBCombo(sheetObj, arrXml[4], "dir_cd", true);
				ComSqmSetIBCombo(sheetObj, arrXml[4], "conv_dir_cd", true);
			}

			ComOpenWait(false);
			break;
		
		case IBSEARCH:          // 화면 조회 시
			
			formObj.f_cmd.value = SEARCH;
			searchParams = FormQueryString(formObj);
			ComOpenWait(true);
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0002GS.do",searchParams);	
			ComOpenWait(false);
			sheetObj.LoadSearchXml(rtnXml);
			var etcData = getEtcData(rtnXml);
			if (etcData["dataCnt"] == 0) {
				toggleButtons("COPY");
			} else {
				toggleButtons("SEARCH");
			}
			break;
			
			
		case IBSAVE:          // 화면 저장시
		
			var saveStr = sheetObj.GetSaveString(false, true, "ibflag");
			
			if ( saveStr == "" ) {
				return;
			}
			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006");
		        return false;
		    } else if (ComShowConfirm (ComGetMsg("SQM00004")) != 1) {
				return false;
		    }
			
			ComOpenWait(true);
			
			ComSetSearchParams("f_cmd", MULTI);
            
			sheetObj.DoSave("ESM_SQM_0002GS.do", searchParams, -1, false);
			
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
			
		case IBINSERT:          // Row Add 시
			var row = sheetObj.DataInsert();
			sheetObj.CellEditable(row, "trd_cd")   = true;
			sheetObj.CellEditable(row, "rlane_cd") = true;
			sheetObj.CellEditable(row, "dir_cd")   = true;
			sheetObj.CellEditable(row, "conv_dir_cd")   = true;

			break;
			
		case IBSEARCH_ASYNC01:          // 최근 이전 분기의 데이터를 복사
		
			if (ComShowConfirm (ComGetMsg("SQM00005")) != 1) {
				return false;
		    }
			
			ComOpenWait(true);
			
			ComSetSearchParams("f_cmd", MULTI01);

			var sXml = sheetObjects[0].GetSaveXml("ESM_SQM_0002GS.do", searchParams);
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('SQM00003','Data');
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
			
			break;

		
    }
}



 /**
  * onChange event
  * f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
  */	
 function f_trd_cd_OnChange(obj, value, text) {
 	var formObj = document.form;
 	var trdcd  = comboObjects[2].Code;	// trade code
	if (value != "All") {	
	 	var param = "f_cmd=" + SEARCH01
	     + "&code_name=rLane"
	     + "&code_param=" + trdcd
	     + "&all_flag=All";	// Trade
	
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
   * sheet1_onChange event
   * trd_cd 바뀌었을때 lane_cd 콤보조회
   */  
  function sheet1_OnChange(sheetObj, row, col, value){
	   sheetObj.WaitImageVisible = false;
    		with(sheetObj){
    			switch(ColSaveName(col)){
                	case "trd_cd":
                		
            			var text = getSheetComboCode(sheetObj, row, col);
                		sheetObj.CellValue2(row, col) = text;
                		
            			if(text != " "){	
	                    	 var param = "f_cmd=" + SEARCH01
	                   	     + "&code_name=rLane"
	                   	     + "&code_param=" + sheetObj.CellValue(row, "trd_cd")
	                   	     + "&all_flag=";	// Trade
	                   	 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
	                   		ComSqmSetIBCombo(sheetObj, xmlStr, "rlane_cd", true);	
	                   		sheetObj.CellComboItem(row, "rlane_cd", "", "");
            			} else {		
            				sheetObj.CellComboItem(row, "rlane_cd", "", "");
            			}

                		break;  
            		case "rlane_cd":
            		case "dir_cd":
            		case "conv_dir_cd":
            			var text = getSheetComboCode(sheetObj, row, col);
            			sheetObj.CellValue2(row, col) = text;
            			break;
    			}
    		}
    	}
    
	/**
	 * 화면의 모든 버튼들의 Enable/Disable을 처리
	 */
   function toggleButtons(step) {
       switch (step) {
       case "INIT":
           ComBtnEnable("btn_Retrieve");
           ComBtnDisable("btn_Save");
           ComBtnDisable("btn_Copy");
           ComBtnDisable("btn_Downexcel");
           ComBtnDisable("btn_RowAdd");
           break;
       case "SEARCH":
    	   ComBtnEnable("btn_Retrieve");
    	   ComBtnEnable("btn_Save");
    	   ComBtnDisable("btn_Copy");
    	   ComBtnEnable("btn_Downexcel");
    	   ComBtnEnable("btn_RowAdd");
           break;
       case "COPY":
    	   ComBtnEnable("btn_Retrieve");
    	   ComBtnDisable("btn_Save");
    	   ComBtnEnable("btn_Copy");
    	   ComBtnDisable("btn_Downexcel");
    	   ComBtnDisable("btn_RowAdd");
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
   	
   	period_change();
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
/* 개발자 작업  끝 */