/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_SPC_0098.js
*@FileTitle : HeadHaul Bound Control
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.24
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.01.24 진마리아
* 1.0 Creation
* 2013.01.24 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.05.03 [CHM-201324211-01] sheet editable 막음
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class ESM_SPC_0098 : ESM_SPC_0098 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0098() {
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

 // 공통전역변수
    var sheetObjects = new Array();
    var comObjects = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;

    //sheetResizeFull = true;
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	
        /*******************************************************/
    	var formObject = document.form;
    	var sheetObject = sheetObjects[0];
    	
       	try {
       		var srcName = window.event.srcElement.getAttribute("name");
       		
       		switch(srcName) {

			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
				
			case "btn_save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;

			case "btn_new":
				if(checkModifiedSheet(sheetObject)) {
					if(ComShowConfirm (getMsg("SPC90001")) != 1) {
						return;
					}
				}

				SpcSearchOptionTrade("trade", true, true);
				SpcSearchOptionSubTrade("subtrade", true, true);
				SpcSearchOptionLane("lane");
				sheetObject.RemoveAll();
				
				break;

			case "btn_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
       		} // end switch
       	}catch(e) {
       		if( e == "[object Error]") {
       			ComShowMessage(OBJECT_ERROR);
       		} else {
       			ComShowMessage(e);
       		}
       	}
    }
    
    /**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){

	   sheetObjects[sheetCnt++] = sheet_obj;


	}
	
	/**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
		comObjects[comboCnt++] = combo_obj;
    }

    
    /**
     * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
     * 추가한다
     */
    function loadPage() {
    	var frm = document.form;
    	SpcSearchOptionTrade("trade", true, true);
    	SpcSearchOptionSubTrade("subtrade", true, true);
    	SpcSearchOptionLane("lane");
    	
    	for(i=0;i<sheetObjects.length;i++){

    		//khlee-시작 환경 설정 함수 이름 변경
    			ComConfigSheet(sheetObjects[i]);

    			initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);
    	}
    }

    /**
 	 * 시트 초기설정값, 헤더 정의
 	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 	 */
 	function initSheet(sheetObj,sheetNo) {

 		var cnt = 0;

 		switch(sheetNo) {
 			 case 1:      //sheet1 init
 				with (sheetObj) {
 					// 높이 설정
 					//style.height = 300 ;
 					style.height = GetSheetHeight(20) ;
 					//전체 너비 설정
 					SheetWidth = mainTable.clientWidth;

 					//Host정보 설정[필수][HostIp, Port, PagePath]
 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 					//전체Merge 종류 [선택, Default msNone]
 					MergeSheet = msPrevColumnMerge;
 					
 				    //전체Edit 허용 여부 [선택, Default false]
 					Editable = true;

 					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 					InitRowInfo( 2, 1, 9, 100);

 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 					InitColumnInfo(8, 6, 0, true);

 					// 해더에서 처리할 수 있는 각종 기능을 설정한다 ([SortEnable], [ColumnMove], [AllCheckEnable],  [UserResize], [RowMove],[Head3D]) 
 					InitHeadMode(true, false, false, true, false, false);

 					var HeadTitle = "Trade|Sub Trade|Lane|Lane|Lane|HeadHaul|";
 					var HeadTitle1 = "Trade|Sub Trade|Code|Name|Type|Bound|";

 					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 					InitHeadRow(0, HeadTitle, true);
 					InitHeadRow(1, HeadTitle1, true);

 					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++, dtData,         80,    daCenter,  true,    "trd_cd",        false,          "",       dfNone,    0,     false,       false);
 					InitDataProperty(0, cnt++, dtData,         80,    daCenter,  true,    "sub_trd_cd",    false,          "",       dfNone,    0,     false,       false);
 					InitDataProperty(0, cnt++, dtData,         70,    daCenter,  true,    "rlane_cd",      false,          "",       dfNone,    0,     false,       false);
 					InitDataProperty(0, cnt++, dtData,         300,   daLeft,    true,    "rlane_nm",      false,         "",       dfNone,    0,     false,       false);
 					InitDataProperty(0, cnt++, dtData,         70,    daCenter,  true,    "lane_tp",       false,         "",       dfNone,    0,     false,       false);
 					InitDataProperty(0, cnt++, dtCombo,        90,    daCenter,  true,    "dir_cd",        true,          "",       dfNone,    0,     true,       true);
 					InitDataProperty(0, cnt++, dtHiddenStatus, 70,    daCenter,  true,    "ibflag",        false,         "",       dfNone,    0,     false,       false);
 					InitDataProperty(0, cnt++, dtData,         70,    daCenter,  true,    "",              false,         "",       dfNone,    0,     false,       false);

 					HeadRowHeight = 20 ;
 					HeadRowHeight = 21 ;

 					InitDataCombo(0, "dir_cd", "|E|W|N|S", "|E|W|N|S");
 			   }
 				break;
 		}
 	}

   // Sheet관련 프로세스 처리
 	function doActionIBSheet(sheetObj,formObj,sAction) {
 		sheetObj.ShowDebugMsg = false;

 		switch(sAction) {

 		   case IBSEARCH:      //조회
 				if(checkModifiedSheet(sheetObj)){
 					//두개 이상의 Sheet를 동시에 체크해야 하여 하나라도 수정된 Sheet가 존재하는 경우를 체크하고자 하는경우 사용
 			        if(ComShowConfirm (getMsg("SPC90001")) != 1){
 			            return;
 			        }
 				}			
                 	
 				formObj.f_cmd.value = SEARCH;
 				var param = SpcFormString(formObj,"f_cmd,trade,subtrade,lane");
 				
 				sheetObj.DoSearch4Post("ESM_SPC_0098GS.do", param);
 				break;	
 				
 		   case IBSAVE:      //저장
 			  if (sheetObj.isDataModified == false){
				   ComShowMessage(getMsg("SPC90142"));
				   return false;
			   }
 			  
 			   if(!validateForm(sheetObj,formObj,sAction)){
 				   return false;
 			   }  
 			   
 			   var param = "f_cmd=" + MULTI;
 			   
 			   var rtn = doSaveSheet(sheetObj, "ESM_SPC_0098GS.do", param, null, false);
 			   
// 			   if(rtn == "OK")
// 				  doActionIBSheet(sheetObject,formObject,IBSEARCH);
 			   break;			

 		   case IBDOWNEXCEL:        //엑셀 다운로드
 				sheetObj.Down2Excel(-1, false, false, true);
 				break;

 		}
 	}	
   	
 	/*
 	 *  trade변경시
 	 */
 	function trade_OnChange(comObj,value,text){		
     	comObjects[1].Index2 = 0; 
     	//lane value change
     	comObjects[2].Index2 = 0;
     	SpcSearchOptionSubTrade("subtrade",true,true,"","",value);
 		SpcSearchOptionLane("lane",true,false,'',value,'',true);
 	}
 				
 	/*
 	 * sub_trade변경시
 	 */
 	function subtrade_OnChange(comObj,value,text ){
 		SpcSearchOptionLane("lane",true,false,'',document.form.trade.Code,value,true);
     	if(value == "" ) return;
	     	var arrTrade = text.split("|");
	    	if(arrTrade.length > 1) {
	    		comObjects[0].Code2 = arrTrade[0];
	    	} else {
	    		comObjects[0].Code2 = comObj.GetText(value,0);  
	    	}     	    
 	    //lane value change
 	    comObjects[2].Index2 = 0;        
   	} 
    
    /*
 	 * lane변경시
 	 */
	function lane_OnChange(comObj,value,text ){
		var repTrade = comObj.GetText(value,0);  
	    var subTrade = comObj.GetText(value,1);
	    if(value != "" ){  
		   	comObjects[0].Code2 = repTrade;		   	
		   	comObjects[1].Code2 = subTrade;
	 	}else{
	 		comObjects[0].Code2 = "";
			comObjects[1].Code2 = "";
	    }
    }
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSAVE:
			break;
		}
		return true;
	}
	
	/**
	 * 저장이 정상수행된 경우, 재조회한다.
	 * 
	 * @param sheetObj
	 * @param errMsg
	 */
	function sheet1_OnSaveEnd(sheetObj, errMsg){
		var formObj = document.form;
		
		if(errMsg == ""){
			ComShowMessage("Save Successfully.");
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
		}else{
			
		}
			
	}
	function enter(){
    	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    	if(keyValue != 13) return;
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }     
	/* 개발자 작업  끝 */