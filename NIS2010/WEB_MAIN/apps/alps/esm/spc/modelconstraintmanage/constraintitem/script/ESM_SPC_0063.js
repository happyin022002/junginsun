/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0063.js
*@FileTitle : Loadable Weight Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.09.10 이현주
* 1.0 Creation
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
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
     * @class ESM_SPC_0063 : ESM_SPC_0063 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0063() {
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

    var init_year1 = ''; 
    var init_week1 = ''; 
    var init_year2 = ''; 
    var init_week2 = ''; 
    
    //sheetResizeFull = true;
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    	function processButtonClick(){
    		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

    		 var sheetObject = sheetObjects[0];

    		 /*******************************************************/
    		 var formObject = document.form;

    		try {
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
    		    		
						SpcSearchOptionTrade("trade", true, true);
						SpcSearchOptionSubTrade("subtrade", true, true);
						SpcSearchOptionLane("lane"); // 0207 SHKIM   
    					break;

    				case "btn_downexcel":
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    					break;
    					
    				case "btn_popup_vvd":
    		   	        var vvd_cd = formObject.vvd.value;
    		   	        var param = 'vvd_cd='+vvd_cd;
      					spcPopup("VVD", param, 770, 470, "getVVD", "1,0,1,1,1,1,1,1" );
    	   	        	break;  	

    			} // end switch
    		}catch(e) {
        		if( e == "[object Error]") {
        			ComShowCodeMessage("COM12111");
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
    					style.height = GetSheetHeight(21) ;

    					//전체 너비 설정
    					SheetWidth = mainTable.clientWidth;

    					//Host정보 설정[필수][HostIp, Port, PagePath]
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    					//전체Merge 종류 [선택, Default msNone]
    					MergeSheet = msPrevColumnMerge;
    					
    				   //전체Edit 허용 여부 [선택, Default false]
    					Editable = false;
                        FocusEditMode = default_edit_mode; 
    					
    					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo( 1, 1, 9, 100);

    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(7, 0, 0, true);

    					// 해더에서 처리할 수 있는 각종 기능을 설정한다 ([SortEnable], [ColumnMove], [AllCheckEnable],  [UserResize], [RowMove],[Head3D]) 
    					InitHeadMode(true, false, false, true, false, false);

    					var HeadTitle = "Rep. Trade|Sub Trade|Lane|Year/Month|VVD|SHA Port Loadable Weight|Proforma ETD";
    					
    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);

    					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++, dtData,    80,   daCenter,  true,    "rep_trd_cd",         false,   "",    dfNone,           0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,    80,   daCenter,  true,    "rep_sub_trd_cd",     false,   "",    dfNone,           0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,    100,  daCenter,  true,    "rlane_cd",           false,   "",    dfNone,           0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,    120,  daCenter,  true,    "cost_yrmon",         false,   "",    dfNone,           0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,    120,  daCenter,  true,    "vvd",                false,   "",    dfNone,    	    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,    190,  daRight,   false,   "vsl_port_drft_wgt",  false,   "",    dfInteger,        0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,    120,  daCenter,  false,   "pf_etd_dt",          false,   "",    dfUserFormat2,    0,     true,       true, 		0,		false,		false);
    					    					   
    					InitUserFormat2(0, "pf_etd_dt", "####/##/## ##:##", "" );
    					HeadRowHeight = 20 ;

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
    				//var a = new Date();
    				
    				var param = "f_cmd=" + formObj.f_cmd.value;
    				param = param + "&year1="    + formObj.year1.value;
    				param = param + "&week1="    + formObj.week1.value;
    				param = param + "&year2="    + formObj.year2.value;
    				param = param + "&week2="    + formObj.week2.value;
    				param = param + "&trade="    + comObjects[0].Code;
    				param = param + "&subtrade=" + comObjects[1].Code;
    				param = param + "&lane="     + comObjects[2].Code;
    				param = param + "&bound="    + formObj.bound.value;
    				
    		      	//sheetObj.DoSearch4Post("ESM_SPC_0063GS.do", FormQueryString(formObj));
    		      	sheetObj.DoSearch4Post("ESM_SPC_0063GS.do", param);
    				//var b = new Date();
    		      	//var search_time = (b-a) / 1000 + "초";	
    		      	//log("search_time-->"+search_time);
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
    		if(text == '|ALL'){	optionAllReset("trade",value,"true");   return;} // 0207 SHKIM
    	    //sub_trade value change  
        	comObjects[1].Index2 = 0; 
        	//lane value change
        	comObjects[2].Index2 = 0;  
        	SpcSearchOptionSubTrade("subtrade",true,true,"",value);			// 0207 SHKIM
    		SpcSearchOptionLane("lane",true,false,'',value,'',true);	// 0207 SHKIM
    	}
    				
    	/*
    	 * sub_trade변경시
    	 */
    	function subtrade_OnChange(comObj,value,text ){
    		if(text == '||ALL'){   
    			//optionAllReset("subtrade",document.form.trade.Code,"true");
    			SpcSearchOptionSubTrade("subtrade",true,true,"","",document.form.trade.Code);			// 0207 SHKIM   			
		    	SpcSearchOptionLane("lane",true,false,'',document.form.trade.Code,'',true);	// 0207 SHKIM
    			return; 
    		} // 0207 SHKIM
    		if(value != "" ){  
    	      comObjects[0].Code2 = comObj.GetText(value,0);  
    	    }else{
    	   		comObjects[0].Code2 = "";
    	    }
    	    //lane value change
    	    comObjects[2].Index2 = 0;      
    	    SpcSearchOptionLane("lane",true,false,'',document.form.trade.Code,value,true);	// 0207 SHKIM
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
    	function validateForm(sheetObj,formObj,sAction){
    		
    		var in_year1 = 0;
    		var in_year2 = 0;
    		var in_month1 = 0;
    		var in_month2 = 0;
    		var months = 0;
    		var year1 = formObj.year1.value;

    		var year2 = formObj.year2.value;
    		var month1 = formObj.week1.value;
    		var month2 = formObj.week2.value;

    		in_year1 = parseInt(year1);			
    		in_year2 = parseInt(year2);
    		in_month1 = parseInt(month1); 
    		in_month2 = parseInt(month2);
    		months = (in_year2 - in_year1) * 12 + in_month2 - in_month1 + 1;        
    		
    		if(months>12){
    			ComShowMessage(getMsg("SPC90125"));
    			formObj.year1.focus();
    			return false;  
    		}else if(months<0)  {
    			ComShowMessage(getMsg("SPC90115","Period")); 
                formObj.year1.focus();
                return false;
    		}

    		return true;
    	}
    	
	/* 개발자 작업  끝 */