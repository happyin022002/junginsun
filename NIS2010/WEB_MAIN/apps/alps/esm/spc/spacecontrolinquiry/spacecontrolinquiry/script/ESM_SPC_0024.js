/*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0024.js
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
* 2008-11-17 임옥영/서관영 CSR:N200811140005/N200811130019 
* - 단축키 추가(ESM_SPC_022, 024, 028, 056, 070)
*@LastModifyDate : 2009.08.19
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.19 한상훈
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
     * @class ESM_SPC_0024 : ESM_SPC_0024 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0024() {
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
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    //sheetResizeFull = true;
    //type check
    var type_check;
    //retrive check
    var check_retrive = false;
    var tab_retrives = null;
    var searchParams = "";
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* TabSheet2 Month 타이틀명*/
    var monthTitles = new Array("Jan.", "Feb.", "Mar.", "Apr.", "May.", "Jun.", "July.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec.");

    var init_year = ''; 
    var init_month = ''; 

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject = sheetObjects[0];
             var sheetObject1 = sheetObjects[1];
             var sheetObject2 = sheetObjects[2];
             /*******************************************************/
             var formObject = document.form;

        	//try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

            	    case "btn_retrieve":
        	            for(var i = 0 ; i < tab_retrives.length ; i++){
    				        tab_retrives[i] = false;
    				    }
       	            	doActionIBSheet(sheetObjects[beforetab],formObject,IBSEARCH);
        	            break;
        	            
    				case "btn_new":
    					if(checkModifiedSheet(sheetObject)) {
    						if(ComShowConfirm (getMsg("SPC90001")) != 1) {
    							return;
    						}
    					}
    	            	//공통함수사용: 화면을 초기화
    					resetAll(); 
    					for(var i = 0 ; i < tab_retrives.length ; i++){
    				        tab_retrives[i] = false;
    				    }
    				    check_retrive = false;

    					formObject.year.value = init_year;
    		    		formObject.month.value = init_month;
    		    		SpcSearchOptionWeek("week",true,document.form.year.value);
    		    		
						SpcSearchOptionTrade("trade");
         				SpcSearchOptionLane("lane",true,true);
    					break;
    					
            	    case "btn_downexcel":
       	            	doActionIBSheet(sheetObjects[beforetab],formObject,IBDOWNEXCEL);
            	        break;

    			} // end switch
        	//}catch(e) {
        	//	if( e == "[object Error]") {
        	//		ComShowCodeMessage("COM12111");
        	//	} else {
        	//		ComShowMessage(e);
        	//	}
        	//}
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
         * IBTab Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setTabObject(tab_obj){
            tabObjects[tabCnt++] = tab_obj;
        }
        
        
        /**
         * tab1_OnChange 
         * 
         */
        function tab1_OnChange(tabObj , nItem)
        {
    	    var formObj = document.form;
    	   
            var objs = document.all.item("tabLayer");
        	objs[nItem].style.display = "Inline";
        	objs[beforetab].style.display = "none";

        	//--------------- 여기가 중요--------------------------//
        	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
        	//------------------------------------------------------//
        	beforetab= nItem;
    		if(!check_retrive) return;
            if(beforetab==0){
            	//searchSummary(sheetObjects[beforetab], formObj, (SEARCHLIST01 + beforetab));
            	searchSummary(sheetObjects[beforetab], formObj, (SEARCHLIST01));
            }else if(beforetab==1){
            	//searchByTrade(sheetObjects[beforetab], formObj, (SEARCHLIST02 + beforetab));
            	searchByTrade(sheetObjects[beforetab], formObj, (SEARCHLIST02));
            }else if(beforetab==2){
            	//searchByOffice(sheetObjects[beforetab], formObj, (SEARCHLIST03 + beforetab));
            	searchByOffice(sheetObjects[beforetab], formObj, (SEARCHLIST03));
            }else if(beforetab==3){
            	//searchByLane(sheetObjects[beforetab], formObj, (SEARCHLIST04 + beforetab));
            	searchByLane(sheetObjects[beforetab], formObj, (SEARCHLIST04));
            }else if(beforetab==4){
            	//searchBySubOffice(sheetObjects[beforetab], formObj, (SEARCHLIST05 + beforetab));
            	searchBySubOffice(sheetObjects[beforetab], formObj, (SEARCHLIST05));
            }        
        }
        
    	/*
    	 * 입력한 Office값 체크
    	 */
    	 function checkValue() {
        	var formObj = document.form;
        	var value = formObj.sales_office.value;
        	value = ComTrim(value);
        	
        	if(value.length>0){
    			if(value.length<5){
    				ComShowMessage(getMsg("SPC90116", "Office"));
    				formObj.sales_office.focus();
    				return;
    			}else{
    				var rtn = getCodeList("Office", "ofc_cd="+value);
    		    	if(rtn[0] == ""){    		
    		    		ComShowMessage(getMsg("SPC90106", value));
    		    		formObj.sales_office.focus();
    		    		return;
    		    	}	
    			}
        	}
        }
    	
        /**
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {
        	SpcSearchOptionYear("year");
        	SpcSearchOptionMonth("month", true);
         	SpcSearchOptionWeek("week", true);
         	SpcSearchOptionBound("bound",false,true,false,true);
         	SpcSearchOptionTrade("trade");
         	SpcSearchOptionLane("lane",true,true);
         	
            tab_retrives = new Array(sheetObjects.length);
            for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet(sheetObjects[i]);

                initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            
            var sheetResizeFull = true;
    		document_onresize();
    		

    		for(k=0;k<tabObjects.length;k++){
                initTab(tabObjects[k],k+1);
            }
            var formObject = document.form;
        	formObject.year.focus();
        	
        	init_year = formObject.year.value;	//년 초기화용
    		init_month = formObject.month.value;	//주차 초기화용
        	
        }
        
        
        /**
         * Tab 기본 설정
         * 탭의 항목을 설정한다.
         */
        function initTab(tabObj , tabNo) {

             switch(tabNo) {
                 case 1:
                    with (tabObj) {
                        var cnt  = 0 ;
                        InsertTab( cnt++ , "Summary" , -1 );
                        InsertTab( cnt++ , "By Trade" , -1 );
                        InsertTab( cnt++ , "By Office/Lane" , -1 );
                        InsertTab( cnt++ , "By Lane/Office" , -1 );
                        InsertTab( cnt++ , "By SUB-Office" , -1 );
                    }
                 break;

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
    				initSheet1(sheetObj, "AES|TAS|TPS|TTL");
                    break;
                case 2:      //sheet1 init
    				initSheet2(sheetObj, "JAN|FEB|MAR|Total");
                    break;
                case 3:      //sheet1 init
    				initSheet3(sheetObj);
                    break;
                case 4:      //sheet1 init
    				initSheet4(sheetObj);
                    break;
                case 5:      //sheet1 init
    				initSheet5(sheetObj);
                    break;
            }
        }
        
        /**
         * TabSheet1에서 조회후 타이틀 변경
         */
    	function initSheet1(sheetObj, strTrades){
    	       with (sheetObj) {
    	            // 높이 설정
    	            if(!check_retrive){
    	            	//style.height = 300 ;
    	            	style.height = getSheetHeight(18) ;
    	            }
    	            //전체 너비 설정
    	            SheetWidth = mainTable.clientWidth;
    				CountPosition = 0;
    				
    	            //Host정보 설정[필수][HostIp, Port, PagePath]
    	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    	
    	            //전체Merge 종류 [선택, Default msNone]
    	            MergeSheet = msPrevColumnMerge;
    	
    	          //전체Edit 허용 여부 [선택, Default false]
    	            Editable = false;
    	
    	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    	            InitRowInfo( 2, 1, 9, 100);
    				
    				var trades = strTrades.split("|");
    	            var columnCount = 4 + (trades.length) * 3;
    	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    	            InitColumnInfo(columnCount, 2 , 0, true);
    	
    	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
    	            InitHeadMode(false, true, true, true, false,false) ;
    	
    	            var txtHead1 = "F'Cast|Diff/Shortfall|Ratio";
    	            var HeadTitle1 = "Trade|Trade";
    	            var HeadTitle2 = "Area|Office";
    	            for(var i = 0 ; i < trades.length ; i++){
                   		HeadTitle1 = HeadTitle1 + "|" + trades[i] + "|" + trades[i] + "|" + trades[i];
                   		HeadTitle2 = HeadTitle2 + "|" + txtHead1;
    	            }

    	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    	            InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
    				var cnt = 0;
    	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    	            InitDataProperty(0, cnt++ , dtData ,    50,    daCenter,   true,    "",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    50,    daCenter,   true,    "",     false,          "",       dfNone,       0,     true,       true);
    	

    	            for(var j = 0 ; j < trades.length ; j++){
    		            InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "Fcast",     false,          "",       dfInteger,       0,     true,       true);
    		            InitDataProperty(0, cnt++ , dtData ,    80,    daRight ,   false,    "NoSho",     false,          "",       dfInteger,       0,     true,       true);
    		            InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "Ratio",     false,          "",       dfNone,       2,     true,       true);
    	            }
    	            InitDataProperty(0, cnt++ , dtHidden ,    1,    daLeft,   true,    "lvl",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    1,    daCenter,   true,    "",     false,          "",       dfNone,       0,     true,       true);
    				
    				
    				InitTreeInfo(columnCount - 2, "sLevel", RgbColor(0,0,255), false);
    	            CellBackColor(1,0) = RgbColor(222, 251, 248);
    	            for(var k = 0 ; k <columnCount ; k ++)
    	            {
    	                CellBackColor(1,k) = CellBackColor(1,0);
    	            }
    	
    	       }
    	}
        
    	 /**
         * TabSheet2에서 조회후 타이틀 변경
         */
    	function initSheet2(sheetObj, strTrades){
    	       with (sheetObj) {
    	            // 높이 설정
    	            if(!check_retrive){
    	            	//style.height = 300 ;
    	            	style.height = getSheetHeight(18) ;
    	            }
    	            //전체 너비 설정
    	            SheetWidth = mainTable.clientWidth;
    				CountPosition = 0;
    				
    	            //Host정보 설정[필수][HostIp, Port, PagePath]
    	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    	
    	            //전체Merge 종류 [선택, Default msNone]
    	            MergeSheet = msPrevColumnMerge;
    	
    	          //전체Edit 허용 여부 [선택, Default false]
    	            Editable = false;
    	
    	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    	            InitRowInfo( 2, 1, 9, 100);
    				
    				var trades = strTrades.split("|");
    	            var columnCount = 5 + (trades.length) * 3;
    	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    	            InitColumnInfo(columnCount, 3 , 0, true);
    	
    	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
    	            InitHeadMode(false, true, true, true, false,false) ;
    	
    	            var txtHead1 = "F'Cast|Diff/Shortfall|Ratio";
    	            var HeadTitle1 = "Trade|Month|Month";
    	            var HeadTitle2 = "Trade|RHQ/Area|Office";
    	            for(var i = 0 ; i < trades.length ; i++){
                   		HeadTitle1 = HeadTitle1 + "|" + trades[i] + "|" + trades[i] + "|" + trades[i];
                   		HeadTitle2 = HeadTitle2 + "|" + txtHead1;
    	            }

    	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    	            InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
    				var cnt = 0;
    	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    	            InitDataProperty(0, cnt++ , dtData ,    50,    daCenter,   true,    "",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    60,    daCenter,   true,    "",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    50,    daCenter,   true,    "",     false,          "",       dfNone,       0,     true,       true);
    	

    	            for(var j = 0 ; j < trades.length ; j++){
    		            InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "Fcast",     false,          "",       dfInteger,       0,     true,       true);
    		            InitDataProperty(0, cnt++ , dtData ,    80,    daRight ,   false,    "NoSho",     false,          "",       dfInteger,       0,     true,       true);
    		            InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "Ratio",     false,          "",       dfNone,       2,     true,       true);
    	            }
    	            InitDataProperty(0, cnt++ , dtHidden ,    1,    daLeft,   true,    "lvl",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    1,    daCenter,   true,    "",     false,          "",       dfNone,       0,     true,       true);
    				
    				
    				InitTreeInfo(columnCount - 2, "sLevel", RgbColor(0,0,255), false);

    	            CellBackColor(1,0) = RgbColor(222, 251, 248);
    	            for(var k = 0 ; k <columnCount ; k ++)
    	            {
    	                CellBackColor(1,k) = CellBackColor(1,0);
    	            }
    	
    	       }
    	}
    	
    	/**
         * TabSheet3에서 조회후 타이틀 변경
         */
    	function initSheet3(sheetObj){
    	       with (sheetObj) {
    	            // 높이 설정
    	            //style.height = 300 ;
    	    	    style.height = getSheetHeight(18) ;
    	            //전체 너비 설정
    	            SheetWidth = mainTable.clientWidth;
    				CountPosition = 0;
    				
    	            //Host정보 설정[필수][HostIp, Port, PagePath]
    	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    	
    	            //전체Merge 종류 [선택, Default msNone]
    	            MergeSheet = msPrevColumnMerge;
    	
    	          //전체Edit 허용 여부 [선택, Default false]
    	            Editable = false;
    	
    	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    	            InitRowInfo( 1, 1, 9, 100);
    				
    	            var columnCount = 14;
    	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    	            InitColumnInfo(columnCount, 0 , 0, false);
    	
    	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
    	            InitHeadMode(false, true, true, true, false,false) ;

    	            var HeadTitle1 = "RHQ/Area|Office|Sub\nTrade|Lane|Week|VVD|Bound|F'cast|BKG|Alloc|Diff/Shortfall|Ratio";

    	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    	            InitHeadRow(0, HeadTitle1, true);
    				var cnt = 0;
    	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    	            InitDataProperty(0, cnt++ , dtData ,    80,    daCenterTop,   true,    "rhq",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    70,    daCenterTop,   true,    "office",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "strade",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "lane",     false,          "",       dfNone,       0,     true,       true);    	            
    	            InitDataProperty(0, cnt++ , dtData ,    50,    daCenter,   true,    "week",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    90,    daCenter,   true,    "vvd",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    50,    daCenter,   true,    "bound",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    80,    daRight ,   false,    "Fcast",     false,          "",       dfInteger,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    80,    daRight ,   false,    "BKG",     false,          "",       dfInteger,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    80,    daRight ,   false,    "Alloc",     false,          "",       dfInteger,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    80,    daRight ,   false,    "NoSho",     false,          "",       dfInteger,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    80,    daRight ,   false,    "Ratio",     false,          "",       dfNone,       2,     true,       true);
    	            InitDataProperty(0, cnt++ , dtHidden ,   1,    daLeft,   true,    "lvl",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    1,    daCenter,   true,    "",     false,          "",       dfNone,       0,     true,       true);
    				
    				
    				InitTreeInfo(columnCount - 2, "sLevel", RgbColor(0,0,255), false);
    	       }
    	}
    	
    	/**
         * TabSheet4에서 조회후 타이틀 변경
         */
    	function initSheet4(sheetObj){
    	       with (sheetObj) {
    	            // 높이 설정
    	            //style.height = 300 ;
    	            style.height = getSheetHeight(18) ;

    	            //전체 너비 설정
    	            SheetWidth = mainTable.clientWidth;
    				CountPosition = 0;
    				
    	            //Host정보 설정[필수][HostIp, Port, PagePath]
    	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    	
    	            //전체Merge 종류 [선택, Default msNone]
    	            MergeSheet = msPrevColumnMerge;
    	
    	          //전체Edit 허용 여부 [선택, Default false]
    	            Editable = false;
    	
    	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    	            InitRowInfo( 1, 1, 9, 100);
    				
    	            var columnCount = 15;
    	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    	            InitColumnInfo(columnCount, 0 , 0, false);
    	
    	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
    	            InitHeadMode(false, true, true, true, false,false) ;

    	            var HeadTitle1 = "Trade|Sub\nTrade|Lane|Week|VVD|Bound|RHQ/Area|Office|F'cast|BKG|Alloc|Diff/Shortfall|Ratio";

    	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    	            InitHeadRow(0, HeadTitle1, true);
    				var cnt = 0;
    	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    	            InitDataProperty(0, cnt++ , dtData ,    80,    daCenterTop,   true,    "trade",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "strade",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "lane",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "week",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    90,    daCenterTop,   true,    "vvd",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    50,    daCenterTop,   true,    "bound",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "area",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    60,    daCenter,   true,    "office",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    80,    daRight ,   false,    "Fcast",     false,          "",       dfInteger,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    80,    daRight ,   false,    "BKG",     false,          "",       dfInteger,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    80,    daRight ,   false,    "Alloc",     false,          "",       dfInteger,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    80,    daRight ,   false,    "NoSho",     false,          "",       dfInteger,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "Ratio",     false,          "",       dfNone,       2,     true,       true);
    	            InitDataProperty(0, cnt++ , dtHidden ,   1,    daLeft,   true,    "lvl",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    1,    daCenter,   true,    "",     false,          "",       dfNone,       0,     true,       true);
    				
    				
    				InitTreeInfo(columnCount - 2, "sLevel", RgbColor(0,0,255), false);
    	       }
    	}
    	
    	/**
         * TabSheet5에서 조회후 타이틀 변경
         */
    	function initSheet5(sheetObj){
    	       with (sheetObj) {
    	            // 높이 설정
    	            //style.height = 300 ;
    	            style.height = getSheetHeight(18) ;

    	            //전체 너비 설정
    	            SheetWidth = mainTable.clientWidth;
    				CountPosition = 0;
    				
    	            //Host정보 설정[필수][HostIp, Port, PagePath]
    	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    	
    	            //전체Merge 종류 [선택, Default msNone]
    	            MergeSheet = msPrevColumnMerge;
    	
    	          //전체Edit 허용 여부 [선택, Default false]
    	            Editable = false;
    	
    	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    	            InitRowInfo( 1, 1, 9, 100);
    				
    	            var columnCount = 15;
    	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    	            InitColumnInfo(columnCount, 0 , 0, false);
    	
    	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
    	            InitHeadMode(false, true, true, true, false,false) ;

    	            var HeadTitle1 = "Trade|Sub\nTrade|Lane|Week|VVD|Bound|RGN-Office|Sub-Office|F'cast|BKG|Alloc|Diff/Shortfall|Ratio";

    	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    	            InitHeadRow(0, HeadTitle1, true);
    				var cnt = 0;
    	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    	            InitDataProperty(0, cnt++ , dtData ,    80,    daCenterTop,   true,    "trade",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "strade",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "lane",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "week",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    90,    daCenterTop,   true,    "vvd",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    50,    daCenterTop,   true,    "bound",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    80,    daCenterTop,   true,    "rgn",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    80,    daCenter,   true,    "office",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    80,    daRight ,   false,    "Fcast",     false,          "",       dfInteger,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    80,    daRight ,   false,    "BKG",     false,          "",       dfInteger,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    80,    daRight ,   false,    "Alloc",     false,          "",       dfInteger,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    80,    daRight ,   false,    "NoSho",     false,          "",       dfInteger,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   false,    "Ratio",     false,          "",       dfNone,       2,     true,       true);
    	            InitDataProperty(0, cnt++ , dtHidden ,   1,    daLeft,   true,    "lvl",     false,          "",       dfNone,       0,     true,       true);
    	            InitDataProperty(0, cnt++ , dtData ,    1,    daCenter,   true,    "",     false,          "",       dfNone,       0,     true,       true);
    				
    				
    				InitTreeInfo(columnCount - 2, "sLevel", RgbColor(0,0,255), false);
    	       }
    	}
    	
    	function dataSelectionByTradeByOffice(){
    		var sheetObj = sheetObjects[beforetab];
    		var obj = event.srcElement;
    		var state = !obj.checked;
    		var frow = 0;
    		while((frow = sheetObj.FindText("lvl", "2", frow + 1)) >= 0){
    			sheetObj.RowHidden(frow) = state;
    		}
    	}
    	
    	function t1sheet3_OnClick(sheetObj, row, col){
        	switch(sheetObj.ColSaveName(col)){
        	case "office":
        	case "lane":
        	case "week":
    			var mark = sheetObj.CellValue(row, col);
    			if(mark == "+" || mark == "-"){
    				toggleExpand(sheetObj, row, col);
    			}
    			break;
    		}
       	}
       	
    	function t1sheet4_OnClick(sheetObj, row, col){
        	switch(sheetObj.ColSaveName(col)){
        	case "lane":
        	case "week":
        	case "area":
        	case "office":
    			var mark = sheetObj.CellValue(row, col);
    			if(mark == "+" || mark == "-"){
    				toggleExpand(sheetObj, row, col);
    			}
    			break;
    		}
       	}
       	
    	function t1sheet5_OnClick(sheetObj, row, col){
        	switch(sheetObj.ColSaveName(col)){
        	case "lane":
        	case "week":
        	case "rgn":
        	case "office":
    			var mark = sheetObj.CellValue(row, col);
    			if(mark == "+" || mark == "-"){
    				toggleExpand(sheetObj, row, col);
    			}
    			break;
    		}
       	}
       	
       	function toggleExpand(sheetObj, row, col){
    		var mark = sheetObj.CellValue(row, col);
    		if(sheetObj.RowExpanded(row)){
    			sheetObj.RowExpanded(row) = false;
    			sheetObj.CellValue2(row, col) = "+";
    		}
    		else{
    			sheetObj.RowExpanded(row) = true;
    			sheetObj.CellValue2(row, col) = "-";
    		}
       	}
    	
    	function changePeriod(){
    		var obj = event.srcElement;
    		if(obj.selectedIndex == 0) return;
    		switch(obj.name){
    		case "month":
    			obj.form.week.selectedIndex = 0;
    			break;
    		case "week":
    			obj.form.month.selectedIndex = 0;
    			break;
    		}
    	}
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;		
    		
            switch(sAction) {
    			
               case IBSEARCH:      //조회
                    var sheetObj = sheetObjects[beforetab];
    				
    				if(!validateForm(sheetObj,formObj,sAction)){
                        return false;
                    }  

    				searchParams = SpcFormString(formObj,'type,year,month,week,rhq,office,trade,bound,lane,vvd,ofcChek');
    		    				
    				check_retrive = true;
    				for(var i = 0 ; i < tab_retrives.length ; i++){
    					tab_retrives[i] = false;
    				}
    				for(var j = 0 ; j < sheetObjects.length ; j++){
    					sheetObjects[j].RemoveAll();
    				}
                    if(beforetab==0){
                    	//searchSummary(sheetObj, formObj, (SEARCHLIST01 + beforetab));
                    	searchSummary(sheetObj, formObj, (SEARCHLIST01));
                    }else if(beforetab==1){
                    	//searchByTrade(sheetObj, formObj, (SEARCHLIST02 + beforetab));
                    	searchByTrade(sheetObj, formObj, (SEARCHLIST02));
                    }else if(beforetab==2){
                    	//searchByOffice(sheetObj, formObj, (SEARCHLIST03 + beforetab));
                    	searchByOffice(sheetObj, formObj, (SEARCHLIST03));
                    }else if(beforetab==3){
                    	//searchByLane(sheetObj, formObj, (SEARCHLIST04 + beforetab));
                    	searchByLane(sheetObj, formObj, (SEARCHLIST04));
                    }else if(beforetab==4){
                    	//searchBySubOffice(sheetObj, formObj, (SEARCHLIST05 + beforetab));
                    	searchBySubOffice(sheetObj, formObj, (SEARCHLIST05));
                    }

    				break;

               case IBDOWNEXCEL:        //엑셀 다운로드             
                  sheetObj.Down2Excel(0, false, false, true);
                  break;
            }
        }
    	
    	function searchSummary(sheetObj, formObj, command){
    		if(tab_retrives[beforetab]) return;
    		var rtn = sheetObj.GetSearchXml("ESM_SPC_0024GS.do", "f_cmd="+command+"&"+searchParams);
    		//var rtn = sheetObjects[0].GetSearchXml("ESM_SPC_0024GS.do", FormQueryString(formObj));
    		tab_retrives[beforetab] = true;
    		var title = getEtcDataFromXml(rtn, "title");
    		var week = getEtcDataFromXml(rtn, "week");
            sheetObj.Reset(); 
        	initSheet1(sheetObj, title);
        	sheetObj.LoadSearchXml(rtn);
        	sheet1_wk.innerText = week;
    	}

    	function searchByTrade(sheetObj, formObj, command){
    		if(tab_retrives[beforetab]) return;
    		var rtn = sheetObj.GetSearchXml("ESM_SPC_0024GS2.do", "f_cmd="+command+"&"+searchParams);
            //var rtn = sheetObjects[1].GetSearchXml("ESM_SPC_0024GS.do", FormQueryString(formObj));
    		tab_retrives[beforetab] = true;
    		var title = getEtcDataFromXml(rtn, "title");
            sheetObj.Reset(); 
        	initSheet2(sheetObj, title);
        	sheetObj.LoadSearchXml(rtn);
    	}

    	function searchByOffice(sheetObj, formObj, command){
    		if(tab_retrives[beforetab]) return;
    		var rtn = sheetObj.DoSearch4Post("ESM_SPC_0024GS3.do", "f_cmd="+command+"&"+searchParams);
    		//var rtn = sheetObjects[2].GetSearchXml("ESM_SPC_0024GS.do", FormQueryString(formObj));
    		tab_retrives[beforetab] = true;
    	}

    	function searchByLane(sheetObj, formObj, command){
    		if(tab_retrives[beforetab]) return;
    		var rtn = sheetObj.DoSearch4Post("ESM_SPC_0024GS4.do", "f_cmd="+command+"&"+searchParams);
    		//var rtn = sheetObjects[3].GetSearchXml("ESM_SPC_0024GS.do", FormQueryString(formObj));
    		tab_retrives[beforetab] = true;
    	}

    	function searchBySubOffice(sheetObj, formObj, command){
    		if(tab_retrives[beforetab]) return;
    		var rtn = sheetObj.DoSearch4Post("ESM_SPC_0024GS5.do", "f_cmd="+command+"&"+searchParams);
    		//var rtn = sheetObjects[4].GetSearchXml("ESM_SPC_0024GS.do", FormQueryString(formObj));
    		tab_retrives[beforetab] = true;
    	}

    	function getEtcDataFromXml(xml, str){
    		var pos = xml.indexOf("ETC KEY=\""+str+"\"");
    		if(pos < 0) return "";
    		pos = xml.indexOf(">", pos + 1);
    		if(pos < 0) return "";
    		var epos = xml.indexOf("</ETC>", pos + 1);
    		var rtn = "";
    		if(epos < 0){
    			rtn = xml.substring(pos + 1);
    		}
    		else{
    			rtn = xml.substring(pos + 1, epos);
    		}
    		log("rtn : " + rtn);
    		return rtn;
    	}
      	
      	
      	/*
    	 * trade변경시
    	 */
    	function trade_OnChange(comObj,value,text ){
    	    //lane value change
    	    comObjects[1].Index2 = 0;     
    	    SpcSearchOptionLane("lane",true,true,'',value,'',true);	// 0207 SHKIM
      	} 
        	
        
        /*
    	 * lane변경시
    	 */
       	function lane_OnChange(comObj,value,text ){
	    	if(value == "" ) return;
	    	
	    	var arrLane = text.split("|");
	    	if(arrLane.length > 1) {
	    		comObjects[0].Code2 = arrLane[0];
	    	} else {
	    		comObjects[0].Code2 = comObj.GetText(value,0);  
	    	}
       	}  
        
         
        
       /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
    		var month = formObj.month.value;
    		var week = formObj.week.value;
//    		var rhq = comObjects[0].Code;
    		var rhq = formObj.rhq.value;
    		var vvd = formObj.vvd.value;
    		if(vvd == "" && month == "" && week == ""){
    			ComShowCodeMessage("COM12139", "Month", "Week");
    			formObj.month.focus();
    			return false;
    		}
    		if(rhq == ""){
    			ComShowMessage(getMsg("SPC90114", "RHQ"));
    			formObj.rhq.focus();
    			return false;
    		}
    		if(vvd != "" && vvd.length < 9){
    			ComShowCodeMessage("COM12174", "VVD", "9");
    			formObj.vvd.focus();
    			return false;
    		}
            return true;
        }

        
        function initDataValue_trade(){
        	var sheetObj = document.getElementById("trade");
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
        function checkWeek(){
        	SpcSearchOptionWeek("week",true,document.form.year.value);
        	
        }        
	/* 개발자 작업  끝 */