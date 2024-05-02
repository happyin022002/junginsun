/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0053.js
*@FileTitle : spaceallocationmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.09.22 한상훈
* 1.0 Creation
* 2010.06.22 Lee Sang-Yong : 프로젝트 CHM-201004171  53ft(DW,DX) 추가 
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
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
     * @class ESM_SPC_0053 : ESM_SPC_0053 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0053() {
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
    
    var init_year1 = ''; 
    var init_week1 = ''; 
    var init_year2 = ''; 
    var init_week2 = ''; 
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    	function processButtonClick(){
    		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

    		 var sheetObject = sheetObjects[0];

    		 /*******************************************************/
    		 var formObject = document.form;

//    		try {
    			var srcName = window.event.srcElement.getAttribute("name");

    			switch(srcName) {

    				case "btn_retrieve":
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;

    				case "btn_new":
    					if(checkModifiedSheet(sheetObject)) {
    						if(ComShowConfirm (getMsg("SPC90001")) != 1) {
    							return;
    						}
    					}
    	            	//공통함수사용: 화면을 초기화
    					resetAll();

    					formObject.year1.value = init_year1;
    		    		formObject.week1.value = init_week1;
    					formObject.year2.value = init_year2;
    		    		formObject.week2.value = init_week2;
    		    		SpcSearchOptionWeek("week1",false,document.form.year1.value);
    		    		SpcSearchOptionWeek("week2",false,document.form.year2.value);
    		    		
						SpcSearchOptionTrade("trade", true, true);
						SpcSearchOptionSubTrade("subtrade", true, true);
						SpcSearchOptionLane("lane"); // 0207 SHKIM    	
    					break;

    				case "btn_downexcel":
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    					break;
    					
    				case "btn_popup_vvd":
    					var param = "&vvd_cd=" + formObject.vvd.value;
      					spcPopup("VVD", param, 770, 470, "getVVD", "1,0,1,1,1,1,1,1" );
    	   	        	break;  	

    			} // end switch
//    		}catch(e) {
//        		if( e == "[object Error]") {
//        		    ComShowCodeMessage("COM12111");
//        		} else {
//        			ComShowMessage(e);
//        		}
//    		}
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
    	 * Sheet 기본 설정 및 초기화
    	 * body 태그의 onLoad 이벤트핸들러 구현
    	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    	 */
    	function loadPage() {
        	SpcSearchOptionYear("year1");
        	SpcSearchOptionWeek("week1");
        	SpcSearchOptionYear("year2");
        	SpcSearchOptionWeek("week2");
        	SpcSearchOptionTrade("trade", true, true);
        	SpcSearchOptionSubTrade("subtrade", true, true);
        	SpcSearchOptionLane("lane");
        	SpcSearchOptionBound("bound",false,true,false);

    		for(i=0;i<sheetObjects.length;i++){

    		//khlee-시작 환경 설정 함수 이름 변경
    			ComConfigSheet(sheetObjects[i]);

    			initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		
    		var sheetResizeFull = true;
    		document_onresize();

    		init_year1 = document.form.year1.value;	//년 초기화용
    		init_week1 = document.form.week1.value;	//주차 초기화용
    		init_year2 = document.form.year2.value;	//년 초기화용
    		init_week2 = document.form.week2.value;	//주차 초기화용
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
    					Editable = false;
                        FocusEditMode = default_edit_mode; 
                        ScrollTrack = false;                
                        MassOfSearch = -1;		//ibsheet버전 변경시 속성값변경
    					
    					
    					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo( 2, 1, 9, 100);

    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(34, 6, 0, true);

    					// 해더에서 처리할 수 있는 각종 기능을 설정한다 ([SortEnable], [ColumnMove], [AllCheckEnable],  [UserResize], [RowMove],[Head3D]) 
    					InitHeadMode(true, false, false, true, false, false);

    					var HeadTitle = "Rep. Trade|Sub Trade|Lane|Bound|Week|VVD|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Loadable|Loadable|Loadable|Loadable|Loadable|Loadable";
    					var HeadTitle1 = "Rep. Trade|Sub Trade|Lane|Bound|Week|VVD|Volume|D2|D4|HC|45'|53'|RF|RD|POL/POD|Weight|ECC|LOC|POD/DEL|USA MOD|ACCT|Yield Group|Volume|HC|45'|53'|Reefer|Weight|Volume|HC|45'|53'|Reefer|Weight";

    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);
    					InitHeadRow(1, HeadTitle1, true);

    					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "",        false,          "",       dfNone,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "",        false,          "",       dfNone,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,       70,    daCenter,  true,    "",        false,          "",       dfNone,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,       70,    daCenter,  true,    "",        false,          "",       dfNone,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,       70,    daCenter,  true,    "",        false,          "",       dfNone,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "",        false,          "",       dfNone,    0,     true,       true, 		0,		false,		false);

    					InitDataProperty(0, cnt++, dtHidden,   60,    daCenter,  false,    "",        false,          "",       dfNone,    0,     true,       true, 		0,		false,		false);
    					
    					InitDataProperty(0, cnt++, dtCheckBox,   50,    daCenter,  false,    "",        false,          "",       dfNone,    0,     true,       true, 		0,		false,		false); //D2
    					InitDataProperty(0, cnt++, dtCheckBox,   50,    daCenter,  false,    "",        false,          "",       dfNone,    0,     true,       true, 		0,		false,		false); //D4
    					InitDataProperty(0, cnt++, dtCheckBox,   50,    daCenter,  false,    "",        false,          "",       dfNone,    0,     true,       true, 		0,		false,		false); //HC    					
    					InitDataProperty(0, cnt++, dtCheckBox,   50,    daCenter,  false,    "",        false,          "",       dfNone,    0,     true,       true, 		0,		false,		false); //45'
    					InitDataProperty(0, cnt++, dtCheckBox,   50,    daCenter,  false,    "",        false,          "",       dfNone,    0,     true,       true, 		0,		false,		false); //53'
    					InitDataProperty(0, cnt++, dtCheckBox,   50,    daCenter,  false,    "",        false,          "",       dfNone,    0,     true,       true, 		0,		false,		false); //RF
    					InitDataProperty(0, cnt++, dtCheckBox,   50,    daCenter,  false,    "",        false,          "",       dfNone,    0,     true,       true, 		0,		false,		false); //RD
    					InitDataProperty(0, cnt++, dtData,   60,    daCenter,  false,    "",        false,          "",       dfNone,    0,     true,       true, 		0,		false,		false); //POL/POD
    					InitDataProperty(0, cnt++, dtCheckBox,   50,    daCenter,  false,    "",        false,          "",       dfNone,    0,     true,       true, 		0,		false,		false); //Weight
    					InitDataProperty(0, cnt++, dtCheckBox,   60,    daCenter,  false,    "",        false,          "",       dfNone,    0,     true,       true, 		0,		false,		false); //ECC
    					InitDataProperty(0, cnt++, dtCheckBox,   60,    daCenter,  false,    "",        false,          "",       dfNone,    0,     true,       true, 		0,		false,		false); //LOC
    					InitDataProperty(0, cnt++, dtCombo,   60,    daCenter,  false,    "",        false,          "",       dfNone,    0,     true,       true, 		0,		false,		false); //POD/DEL    					
    					InitDataProperty(0, cnt++, dtCheckBox,   60,    daCenter,  false,    "",        false,          "",       dfNone,    0,     true,       true, 		0,		false,		false); //USA MOD
    					InitDataProperty(0, cnt++, dtCheckBox,   60,    daCenter,  false,    "",        false,          "",       dfNone,    0,     true,       true, 		0,		false,		false); //ACCT
    					InitDataProperty(0, cnt++, dtCheckBox,   70,    daCenter,  false,    "",        false,          "",       dfNone,    0,     true,       true, 		0,		false,		false); //Yield Group

    					InitDataProperty(0, cnt++, dtData,       70,    daRight,  false,    "",        false,          "",       dfInteger,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,       70,    daRight,  false,    "",        false,          "",       dfInteger,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,       70,    daRight,  false,    "",        false,          "",       dfInteger,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,       70,    daRight,  false,    "",        false,          "",       dfInteger,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,       70,    daRight,  false,    "",        false,          "",       dfInteger,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,       70,    daRight,  false,    "",        false,          "",       dfInteger,    0,     true,       true, 		0,		false,		false);

    					InitDataProperty(0, cnt++, dtHidden,       70,    daRight,  false,    "",        false,          "",       dfInteger,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtHidden,       70,    daRight,  false,    "",        false,          "",       dfInteger,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtHidden,       70,    daRight,  false,    "",        false,          "",       dfInteger,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtHidden,       70,    daRight,  false,    "",        false,          "",       dfInteger,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtHidden,       70,    daRight,  false,    "",        false,          "",       dfInteger,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtHidden,       70,    daRight,  false,    "",        false,          "",       dfInteger,    0,     true,       true, 		0,		false,		false);

    					InitDataCombo (0, 18, " |POD|DEL", " |D|T");
    					
    					HeadRowHeight = 20 ;
    					HeadRowHeight = 21 ;
    					//셀사이 구분색상 설정
    					RangeBackColor(1,6, 1,21) = RgbColor(222, 251, 248);   // ENIS

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
    				
    				if(!validateForm(sheetObj,formObj,sAction)){
                        return false;
                    }  
                    	
    				formObj.f_cmd.value = SEARCHLIST;
    				
    				var param = SpcFormString(formObj,"f_cmd,year1,week1,year2,week2,trade,subtrade,lane,bound,vvd");
    				
    				//sheetObj.DoSearch4Post("ESM_SPC_0053GS.do", FormQueryString(formObj));
    				sheetObj.DoSearch4Post("ESM_SPC_0053GS.do", param);
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
//    		if(text == '|ALL'){	optionAllReset("trade",value,"true");   return;} // 0207 SHKIM
        	//sub_trade value change  
        	comObjects[1].Index2 = 0; 
        	//lane value change
        	comObjects[2].Index2 = 0;
        	SpcSearchOptionSubTrade("subtrade",true,true,"","",value);			// 0207 SHKIM
    		SpcSearchOptionLane("lane",true,false,'',value,'',true);	// 0207 SHKIM
    	}
    				
    	/*
    	 * sub_trade변경시
    	 */
    	function subtrade_OnChange(comObj,value,text ){
//    		if(text == '||ALL'){   
//    			// 사용안함. 직접 optionAllReset("subtrade",document.form.trade.Code,"true");    			
//    			SpcSearchOptionSubTrade("subtrade",true,true,"","",document.form.trade.Code);			// 0207 SHKIM   			
//    	    	SpcSearchOptionLane("lane",true,false,'',document.form.trade.Code,'',true);	// 0207 SHKIM   
//    			return;    	
//    		} // 0207 SHKIM 
    		SpcSearchOptionLane("lane",true,false,'',document.form.trade.Code,value,true);	// 0207 SHKIM
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
    	
    	/*
    	 * VVD 값 가져옴
    	 */
    	function getVVD(rowArray) {
    		var colArray = rowArray[0];
    		document.all.vvd.value = colArray[7];
    	}
    		
    	/*
    	 * 입력한 VVD값 체크
    	 */
    	 function checkValue() {
        	var formObj = document.form;
        	var value = formObj.vvd.value;
//        	value = trim(value);
//        	value = value.trimAll();
        	value = ComTrim(value);
        	
    		if(value.length>0){
    			if(value.length<9){
    				ComShowMessage(getMsg("SPC90116", "VVD"));
    				formObj.vvd.focus();
    				return;
    			}else{
    				var rtn = getCodeList("VVD", "vvd_cd="+value);
    		    	if(rtn[0] == ""){    		
    		    		ComShowMessage(getMsg("SPC90199", value));
    		    		formObj.vvd.focus();
    		    		return;
    		    	}	
    			}
    		}
        }	
    		
       /**
    	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	 */
    	function validateForm(sheetObj,formObj,sAction){
    		with(formObj){
    			var wk = calcPeriod(year1.value,week1.value,year2.value,week2.value);
    			
    			if( wk < 0 ){
                	ComShowMessage(getMsg("SPC90115","Period")); 
                    formObj.year1.focus();
                    return false;
                }
                var vvd_value = vvd.value;
                if(vvd_value.length>0 && vvd_value.length<9){
                	ComShowCodeMessage("COM12174", "VVD", "9"); 
                    formObj.vvd.focus();
                    return false;
                } 
                
    		}
    		return true;
    	}

    	
    	function initDataValue_trade(){
        	var sheetObj = document.getElementById("trade");
        	with(sheetObj){
        		Index2 = 0;
        	}
        }
        
        function initDataValue_subtrade(){
        	var sheetObj = document.getElementById("subtrade");
        	with(sheetObj){
        		Index2 = 0;
        	}
        }
        
        function initDataValue_lane(){
        	var sheetObj = document.getElementById("lane");
        	with(sheetObj){
        		Index2 = 0;
        	}
        }    	
        /**
         * Start Week 의 year 변경시
         * Start Week 의 year 변경시 주차 변경
         */
        function checkWeek1(){
        	SpcSearchOptionWeek("week1",false,document.form.year1.value);
        	
        }    	 
        function checkWeek2(){
        	SpcSearchOptionWeek("week2",false,document.form.year2.value);
        	
        }   
	/* 개발자 작업  끝 */