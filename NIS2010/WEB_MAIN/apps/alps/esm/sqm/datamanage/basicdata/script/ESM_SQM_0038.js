/*=========================================================
*Copyright(c) 2383 CyberLogitec
*@FileName       : ESM_SQM_0038.js
*@FileTitle      : Lane Master
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.03
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.03 SQM USER
* 1.0 Creation
* 2014.01.10 박은주 [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2014.05.07 이혜민 [CHM-201430049] IAS Sector sales - Planning 메뉴의 report 검색 조건 위치 변경 요청
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND38=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends 
 * @class ESM_SQM_0038 : ESM_SQM_0038 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0038() {
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
			case "btn_Retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject, formObj, IBSAVE);
				break;
			case "btn_RowAdd":
				doActionIBSheet(sheetObject, formObj, IBINSERT);
				break;
			case "btn_Downexcel":
				sheetObject.SpeedDown2Excel(-1);   
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
				
				var HeadTitle =  "DEL|STS|SEQ|Trade|Sub Trade|R.Lane|Active Lane Bound|IAS Sector|Active";
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle)+1, 0, 0, true);
				
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, true, true, false, false);
				
				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, false);
				
				// 전체 높이 설정
				style.height = GetSheetHeight(20);
				
				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtDelCheck,		30, 	daCenter,	true,	"",			    false,	"",	dfNone,	0,	true,	true,	-1,	false,	true,	"",	false);
				InitDataProperty(0,	cnt++,	dtStatus,		30,		daCenter,	true,	"ibflag",	    false,	"",	dfNone,	0,	false,	false);	
				InitDataProperty(0,	cnt++,	dtSeq,			30,  	daCenter,	true,	"seq",		    false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtComboEdit,    100,	daCenter,	true,	"trd_cd",	    true,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtComboEdit,	100,	daCenter,	true,	"sub_trd_cd",   true,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtComboEdit,	100,	daCenter,	true,	"rlane_cd",	    true,	"",	dfNone,	0,	false,	false);	
				InitDataProperty(0,	cnt++,	dtComboEdit,	130,	daCenter,	true,	"lane_dir_cd",	false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtCheckBox,	100,	daCenter,	true,	"ias_sctr_flg",  false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtCheckBox,	100,	daCenter,	true,	"sqm_act_flg",  false,	"",	dfNone,	0,	true,	true);
			}
			break;
	}
}

/**
 * 멀티콤보 항목을 설정한다.
 */
function initCombo(comboObj, comboId) {

	with (comboObj) {
		DropHeight = 300;
		Index      = 0;
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
						
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0038GS.do", FormQueryString(formObj));
			var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
			var arrXml = sXml.split("|$$|");

			if (arrXml.length > 0){
				ComXml2ComboItem(arrXml[0], formObj.f_trd_cd, "code", "name");
				comboObjects[0].InsertItem(0, 'All', 'All');
				ComSqmSetIBCombo(sheetObj, arrXml[0], "trd_cd", true);
			}
			if (arrXml.length > 1){
				ComXml2ComboItem(arrXml[1], formObj.f_lane_dir_cd, "code", "name");
				comboObjects[3].InsertItem(0, 'All', 'All');
				ComSqmSetIBCombo(sheetObj, arrXml[1], "lane_dir_cd", true);
			}
			ComOpenWait(false);
			break;
		
		case IBSEARCH:          // 화면 조회 시
			sheetObj.WaitImageVisible = false;			
			ComOpenWait(true);
	
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESM_SQM_0038GS2.do", FormQueryString(formObj));
			ComOpenWait(false);
			break;
			
		case IBSAVE:          // 화면 저장 시 

			var saveStr = sheetObj.GetSaveString(false, true, "ibflag");
			if ( saveStr == "" ) {
				return;
			}
			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006"); //There is no data to save.
			    return false;
			} else if (ComShowConfirm (ComGetMsg("SQM00004")) != 1) { //Do you want to save?"
				return false;
			}
			ComOpenWait(true);
			
			formObj.f_cmd.value = MULTI;
			var sParam 	= sheetObj.GetSaveString(false, true, "ibflag");
			var sXml = sheetObjects[0].GetSaveXml("ESM_SQM_0038GS.do",FormQueryString(formObj) + "&" +sParam);
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			
			ComOpenWait(false);
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
			sheetObj.CellEditable(row, "sub_trd_cd") = true;
			sheetObj.CellEditable(row, "rlane_cd")   = true;
			break;
    }
}


 /**
  * onChange event
  * f_trd_cd 바뀌었을때  sub_trd_cd,f_lane_cd 콤보조회
  */	
 function f_trd_cd_OnChange(obj, value, text) {
 	var formObj = document.form;
 	var trdcd  = comboObjects[0].Code;	// trade code

	if (value != "All") {	
	 	var param = "f_cmd=" + SEARCH01
	     + "&code_name=subTrade,rLane"
	     + "&code_param=" + trdcd + "," + trdcd
	     + "&all_flag=All,All";	// Trade
	
	 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
		var arrXml = xmlStr.split("|$$|");
		
		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.f_sub_trd_cd, "code", "name");
		if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], formObj.f_rlane_cd, "code", "name");
	
	} else {
		formObj.f_rlane_cd.RemoveAll();
		formObj.f_rlane_cd.InsertItem(0, "All", "All");
		formObj.f_sub_trd_cd.RemoveAll();
		formObj.f_sub_trd_cd.InsertItem(0, "All", "All");
	}
	comboObjects[1].Index = 0;
	comboObjects[2].Index = 0;
 }
  
    /**
   * sheet1_onChange event
   */  
  function sheet1_OnChange(sheetObj, row, col, value){
	   sheetObj.WaitImageVisible = false;
    		with(sheetObj){
    			switch(ColSaveName(col)){
                	case "trd_cd":
            			var trdCd = getSheetComboCode(sheetObj, row, col);
            			if(trdCd != " "){
	            			var param = "f_cmd=" + SEARCH01
	           			     + "&code_name=subTrade"
	           			     + "&code_param=" + trdCd
	           			     + "&all_flag=";	// Trade
	           			
	           			 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
	           				var arrXml = xmlStr.split("|$$|");
	           				
	           				if (arrXml.length > 0)
	           					ComSqmSetIBCombo(sheetObj, arrXml[0], "sub_trd_cd", true);
	           				sheetObj.CellComboItem(row, "sub_trd_cd", "", "");
            			} else {
            				sheetObj.CellComboItem(row, "sub_trd_cd", " ", " ");
            			}

                		break;  
                	case "sub_trd_cd":
	            		var trdCd    = getSheetComboCode(sheetObj, row, "trd_cd");
	        			var subTrdCd = getSheetComboCode(sheetObj, row, "sub_trd_cd");
	        			if(trdCd != " " && subTrdCd != " "){	
	        			 	var param = "f_cmd=" + SEARCH01
	        			     + "&code_name=mdmRLane"
	        			     + "&code_param=" + trdCd + "|" + subTrdCd;
	        			     + "&all_flag=";	// Trade
	        			
	        			 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
	        				var arrXml = xmlStr.split("|$$|");
	        				var ttlRow =ComGetTotalRows(arrXml);
	        				if (ttlRow == "0"){
	        					sheetObj.CellComboItem(row, "rlane_cd", " ", " ");
	        				}else{
	        					if (arrXml.length > 0)
		        					ComSqmSetIBCombo(sheetObj, arrXml[0], "rlane_cd", true);
		        				sheetObj.CellComboItem(row, "rlane_cd", "", "");
	        				}
	        			} else {
	        				sheetObj.CellComboItem(row, "rlane_cd", " ", " ");
	        			}
	        			break;
            			
            		case "rlane_cd":
            			var text = getSheetComboCode(sheetObj, row, col);
            			sheetObj.CellValue2(row, col) = text;
            			break;
    			}
    		}
    	}

   
   /**
    * onChange event
    * f_sub_trd_cd 바뀌었을때  f_lane_cd 콤보조회
    */	 
    function f_sub_trd_cd_OnChange(obj, value, text) {
   		var formObj = document.form;
   		var code  = comboObjects[0].Code + "|" + comboObjects[1].Code;	// trd,subtrade code
   		if (value != "All") {	

   			var param = "f_cmd=" + SEARCH01
   		    + "&code_name=rLane"
   		    + "&code_param=" + code
   		    + "&all_flag=All";	// Trade
   	
   			var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
   			var arrXml = xmlStr.split("|$$|");
   			if (arrXml.length > 0)
   				ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "name");
   	
   			comboObjects[2].Index = 0;
   		}else{
   			
   			var trdcd  = comboObjects[0].Code
   			if(trdcd != "All"){
	   			var param = "f_cmd=" + SEARCH01
	   		    + "&code_name=rLane"
	   		    + "&code_param=" + trdcd
	   		    + "&all_flag=All";	// Trade
	   	
	   			var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
	   			var arrXml = xmlStr.split("|$$|");
	   			if (arrXml.length > 0)
	   				ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "name");
	   	
	   			comboObjects[2].Index = 0;
   			}
   		}
   	}
    

/* 개발자 작업  끝 */