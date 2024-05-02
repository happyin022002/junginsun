/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0007.js
*@FileTitle      : RHQ-Office Mapping
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.08
*@LastModifier   : JEONGMIN CHO
*@LastVersion    : 1.0
* 2013.05.08 JEONGMIN CHO
* 1.0 Creation
* 2014.06.24 이혜민 [CHM-201430703] SQM 신규 Office 등록 로직 변경
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends 
 * @class ESM_SQM_0007 : ESM_SQM_0007 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0007() {
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
	var formObject  = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;
			case "btn_Creation":
				if (!validateForm(sheetObject, formObject, srcName)) {
					return false;
				}
	        	ComOpenPopup("/hanjin/ESM_SQM_0039.do?", 350, 200,'','0,1,1,1,1,1,1,1');
				break;
			case "btn_Downexcel":
				sheetObject.SpeedDown2Excel(-1);   
				break;
			case "btn_RowAdd":
				doActionIBSheet(sheetObject,formObject,IBINSERT);
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
	var formObject  = document.form;
	loadingMode = true;
		
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}

	toggleButtons("INIT");
	loadingMode = false;
}

function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	
	switch(sheetNo) {
		case 1:		//sheet1 init
			with (sheetObj) {
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;  //msNone; //msHeaderOnly //msPrevColumnMerge;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);
				
				var HeadTitle1 =  "SEL|DEL|STS|Seq|RHQ|Office|ADD_FLG";
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1)+1, 0, 0, true);
				
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, false, true, false, false);
				
				//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				
				// 전체 높이 설정
				style.height = GetSheetHeight(20);
				
				//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtCheckBox,		30,	daCenter,	true,	"sel",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtDelCheck,		30,	daCenter,	true,	"",				false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtStatus,		30,	daCenter,	true,	"ibflag",		false,	"",	dfNone,	0,	false,	false);	
				InitDataProperty(0,	cnt++,	dtSeq,			30,	daCenter,	true,	"seq",		    false,	"",	dfNone,	0,	false,	false);	
				InitDataProperty(0,	cnt++,	dtComboEdit,	80,	daCenter,	true,	"rhq_cd",		true,	"",	dfNone,	0,	false,	false,	5);
				InitDataProperty(0,	cnt++,	dtData,			80,	daCenter,	true,	"rgn_ofc_cd",	true,	"",	dfNone,	0,	false,	false,	5);
				InitDataProperty(0,	cnt++,	dtHidden,		30,	daCenter,	true,	"add_flg",		false,	"",	dfNone,	0,	false,	false);
		

                InitDataValid(0,"rhq_cd",vtEngUpOnly );
                InitDataValid(0,"rgn_ofc_cd",vtEngUpOnly );
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
		Index = 0;
	}
}

/**
 * Sheet 관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	
	switch(sAction) {
		case IBCLEAR:          //화면 오픈시 콤보 setting
			sheetObj.WaitImageVisible = false;
			formObj.f_cmd.value = INIT;
			
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0007GS.do", FormQueryString(formObj));
			var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
			var arrXml = sXml.split("|$$|");

			if (arrXml.length > 0){
				ComXml2ComboItem(arrXml[0], formObj.f_rhq_cd, "code", "name");
				comboObjects[0].InsertItem(0, 'All', 'All');
				ComSqmSetIBCombo(sheetObj, arrXml[0], "rhq_cd", true);
			}

			break;
			
		case IBINSERT:          // Row Add 시
			var row = sheetObj.DataInsert();			
			sheetObj.CellEditable(row, "rhq_cd") = true;
			sheetObj.CellEditable(row, "rgn_ofc_cd") = true;
			if(comboObjects[0].Code != 'All'){
				sheetObj.CellValue(row,"rhq_cd") = comboObjects[0].Code;
			}
//			sheetObj.InitDataCombo(0, "rgn_ofc_cd", " ", " ");
			break;
			
		case IBSEARCH:          //화면 조회시
			sheetObj.WaitImageVisible = false;			
			ComOpenWait(true);

			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESM_SQM_0007GS.do", FormQueryString(formObj));
			ComOpenWait(false);
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
			
			formObj.f_cmd.value = MULTI;
			var sParam 	= sheetObj.GetSaveString(false, true, "ibflag");
			var sXml = sheetObjects[0].GetSaveXml("ESM_SQM_0007GS.do",FormQueryString(formObj) + "&" +sParam);
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
			

    }
}
 
 
   
    /**
    * 추가된 office일 경우 creation check 활성화
    * @param sheetObj
    * @param ErrMsg
    */
 function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj = document.form;

	for(var i=1;i<sheetObj.Rows;i++){
		if(sheetObj.CellValue(i,"add_flg") == "Y"){   // 추가된 office일 경우 creation check 활성화
			sheetObj.CellEditable(i,"sel") = true;	

		}
	}
	//creation할 row가 있을 시에 버튼 컨트롤

	if(sheetObj.FindText("add_flg","Y", 0) == "-1")
		toggleButtons("SEARCH");
	else
		toggleButtons("Creation");


  }
    
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction){
    	
    	switch(sAction) {
    		
    		case "btn_Creation":  // Creation

	  			if (sheetObjects[0].CheckedRows("sel") < 1) {
	  				ComShowCodeMessage("COM12113", "one row");
	  				return false;
	  			}
        		break;
    		
    	}
    	return true;
    }
    
//  /**
//   * sheet1_onChange event
//   * trd_cd 바뀌었을때 lane_cd 콤보조회
//   */  
//  function sheet1_OnChange(sheetObj, row, col, value){
//	   sheetObj.WaitImageVisible = false;
//    		with(sheetObj){
//    			switch(ColSaveName(col)){
//                	case "rhq_cd":
//                		
//            			var text = getSheetComboCode(sheetObj, row, col);
//                		sheetObj.CellValue2(row, col) = text;
//                		
//            			if(value != ""){				
//	                    	 var param = "f_cmd=" + SEARCH01
//	                   	     + "&code_name=office"
//	                   	     + "&code_param=" + value
//	                   	     + "&all_flag=";	// Trade
//	                   	 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
//	                   		ComSqmSetIBCombo(sheetObj, xmlStr, "rgn_ofc_cd", true);		
//            			}             				
//            			sheetObj.CellComboItem(row, "rgn_ofc_cd", "", "");
//
//                		break;  
//            		case "rgn_ofc_cd":
//            			var text = getSheetComboCode(sheetObj, row, col);
//            			sheetObj.CellValue2(row, col) = text;
//            			break;
//    			}
//    		}
//    	}      
 
    
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
	       ComBtnDisable("btn_RowAdd");
	       break;
	   case "SEARCH":
		   ComBtnEnable("btn_Save");
	       ComBtnDisable("btn_Creation");
		   ComBtnEnable("btn_Downexcel");
		   ComBtnEnable("btn_RowAdd");
	       break;
	   case "Creation":
		   ComBtnEnable("btn_Save");
		   ComBtnEnable("btn_Creation");
		   ComBtnEnable("btn_Downexcel");
		   ComBtnEnable("btn_RowAdd");
	       break;

     
   }
}
/* 개발자 작업  끝 */