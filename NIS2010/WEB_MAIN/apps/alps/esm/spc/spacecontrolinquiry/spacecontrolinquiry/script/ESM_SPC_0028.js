/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0028.js
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
* 2008-11-17 임옥영/서관영 CSR:N200811140005/N200811130019 
* - 단축키 추가(ESM_SPC_022, 024, 028, 056, 070)
* 2008-12-17 임옥영 CSR:N200812080003 Total TEU 컬럼 추가(TEU+ HC*2 + 45FT*2)
* 2008-12-26 임옥영 CSR:N200812230019 BKG의 TEU->Total TEU로 변경
*@LastModifyDate : 2009.10.12
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.10.12 한상훈
* 1.0 Creation
* 2010. 02. 24 CHOI.Y.S.
* - eval 사용 하는 부분 수정
* 2010.06.22 Lee Sang-Yong : 프로젝트 CHM-201004171  53ft(DW,DX) 추가
* 2011.07.05 [CHM-201111880-01] 김종준 control by HO 화면 보완 - IPC, TS 관련
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
* 2014.07.31 차상영 [CHM-201431081] SPC Allocation Control Option 추가 보완
* 2015.02.24 김성욱, ComboBox 잔상 문제 처리 -> 콤보 잔상 문제로 콤보에 포커스 들어올때 포커스 이동 후 원복
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
     * @class ESM_SPC_0028 : ESM_SPC_0028 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0028() {
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
    var beforetab = 0;
    var save_lane;		//double click했을때 선택한 lane
    var save_bound;		//double click했을때 선택한 bound
    var save_vvd;		//double click했을때 선택한 vvd
    var save_trade;		//double click했을때 선택한 trade
    var save_subtrade	//double click했을때 선택한 subtrade
    var headWeek = "";	//Weekly CMB 4주차를 위한 Hearder
    
    var pop_yrwk;	//double click했을때 선택한 YRWK
    
    //var sheetResizeFull = true;
    var sheetResizeCount = 2;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    var init_year1 = ''; 
    var init_week1 = ''; 
    var init_year2 = ''; 
    var init_week2 = ''; 
    
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             /*******************************************************/
             var sheetObject = sheetObjects[0];
             var sheetObject1 = sheetObjects[1];
             var sheetObject2 = sheetObjects[2];

             var formObject = document.form;

        	//try {
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
						SpcSearchOptionSubTrade("subtrade", true, false);
						SpcSearchOptionLane("lane",true,true); // 0207 SHKIM
			        	ComBtnDisable("btng_season_grp");
    					break;
    					
    				case "btn_downexcel":					
        	            doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
        	            break;

    				case "btng_season_grp":
    					yieldGrpPopup();
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
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {
        	headWeek = "WK1|WK2|WK3|WK4|WK1|WK2|WK3|WK4"; //weekly cmb 초기화

        	SpcSearchOptionYear("year1");
        	SpcSearchOptionWeek("week1");
        	SpcSearchOptionYear("year2");
        	SpcSearchOptionWeek("week2");
        	SpcSearchOptionTrade("trade", true, true);
        	SpcSearchOptionSubTrade("subtrade", true, false);
        	SpcSearchOptionLane("lane",true,true);
        	SpcSearchOptionBound("bound",false,true,false);
        	
    		var tdisp = false;
            for(i=0;i<sheetObjects.length;i++){
                // khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i]);
            	if(i > 0){
                	tdisp = tabLayer[i-1].style.display;
                	tabLayer[i-1].style.display = "block";
            	}
                initSheet(sheetObjects[i],i+1);
            	if(i > 0){
    				tabLayer[i-1].style.display = tdisp;
    			}
                // khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            var sheetResizeFull = true;
    		document_onresize();

            for(k=0;k<tabObjects.length;k++){
                initTab(tabObjects[k],k+1);
            }
            
            if(isDevMode){
            	var formObj = document.form;
            	formObj.only_vvd.value = 'KADB0035W';
            	formObj.sales_office.value = 'TYOSC';
            	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
            }

    		init_year1 = document.form.year1.value;	//년 초기화용
    		init_week1 = document.form.week1.value;	//주차 초기화용
    		init_year2 = document.form.year2.value;	//년 초기화용
    		init_week2 = document.form.week2.value;	//주차 초기화용
    		ComBtnDisable("btng_season_grp");
        }

		/* 콤보 잔상 문제로 콤보에 포커스 들어올때 포커스 이동 후 원복 = 시작 */
        function trade_OnFocus(combj, value, text){
            document.getElementById("year1").focus();
            document.getElementById("trade").focus(); 
        }
        function subtrade_OnFocus(combj, value, text){
            document.getElementById("year1").focus();
            document.getElementById("subtrade").focus(); 
        }
        function lane_OnFocus(combj, value, text){
            document.getElementById("year1").focus();
            document.getElementById("lane").focus(); 
        }
		/* 콤보 잔상 문제로 콤보에 포커스 들어올때 포커스 이동 후 원복 = 끝 */        

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
                        style.height = getSheetHeight(7);
                        //전체 너비 설정
                        SheetWidth = mainTable[0].clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = false;
                        FocusEditMode = default_edit_mode;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 3, 1, 5, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(27, 7, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)
                        var HeadTitle0 = "SEQ|Trade|Sub\nTrade|Lane|Bound|Week|VVD|Load QTA|Load QTA|Forecast|" +
                        		"Forecast|Forecast|Forecast|Alloc|Alloc|Alloc|Alloc|Booking|Booking|Booking|Booking|Booking VGM|Booking VGM|Booking VGM|Booking VGM|RATIO| ";
                        var HeadTitle1 = "SEQ|Trade|Sub\nTrade|Lane|Bound|Week|VVD|VOL|CMB|VOL|WGT|T/S|T/S|VOL|WT|T/S|T/S|" +
                        		"Total|WGT|T/S|T/S|VOL|WGT|T/S|T/S|RATIO| ";
                        var HeadTitle2 = "SEQ|Trade|Sub\nTrade|Lane|Bound|Week|VVD|VOL|CMB|VOL|WGT|VOL|WGT|VOL|WT|VOL|WGT|" +
                				"Total|WGT|VOL|WGT|VOL|WGT|VOL|WGT|RATIO| ";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle0, true);
                        InitHeadRow(1, HeadTitle1, true);
                        InitHeadRow(2, HeadTitle2, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtDataSeq,   30,    daCenter,  true,     "",     false,          "",   dfNone,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,     "TRADE",     false,          "",   dfNone,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  true,     "SUBTRADE",     false,          "",   dfNone,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  true,     "LANE", false,          "",   dfNone,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  true,     "BOUND",false,          "",   dfNone,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,     "WEEK",     false,          "",   dfNone,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,     "VVD",  false,          "",   dfNone,      0,     true,       true);
                        
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "",     false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "",     false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "",     false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "",     false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "",     false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "",     false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "",     false,          "",   dfInteger,        0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      60,    daRight,   true,     "",     false,          "",   dfNullInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  true,     "",     false,          "",   dfNullInteger,        0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  true,     "",     false,          "",   dfNullInteger,        0,     true,       true);
                        
    					InitDataProperty(0, cnt++ , dtData,      60,    daRight ,  true,     "",     false,          "",   dfInteger,      0,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "",     false,          "",   dfInteger,        0,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "",     false,          "",   dfInteger,        0,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "",     false,          "",   dfInteger,        0,     true,       true);

    					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "",     false,          "",   dfInteger,        0,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "",     false,          "",   dfInteger,        0,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "",     false,          "",   dfInteger,        0,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "",     false,          "",   dfInteger,        0,     true,       true);
    					
    					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "",     false,          "",   dfNullFloat,        2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "",     false,          "",   dfNone,        0,     true,       true);
    					RangeBackColor(1,7, 1,15) = RgbColor(222, 251, 248);
                        HeadRowHeight = 10;
                        CountPosition = 0;
                   }
                   break;
                case 2:     //t1sheet1 init
                	with (sheetObj) {
                        // 높이 설정
                        style.height = 175;
                        //전체 너비 설정
                        SheetWidth = mainTable[1].clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msPrevColumnMerge + msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = false;
                        FocusEditMode = default_edit_mode;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 3, 1, 5, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(79, 9, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)
    					
                        var HeadTitle1 = "OCN\nIPC\nTS|OFC|Yield\nGroup|Local IPI|Account/CMDT|Account/CMDT|POL|POD|Dest|Load\nQuota|Guide|OFC LVL|TREE|ctrl_flg|OFC\nCMB\nTEU|OFC\nCMB\nWGT|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|" + 
                                "Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|" +
                        		"Allocation|Allocation|Allocation|Allocation|Allocation|Allocation|Allocation|Allocation|Allocation|" +
                        		"Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|" +
                        		"Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|" +
                        		"Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Booking VGM|Booking VGM";
                        var HeadTitle2 = "OCN\nIPC\nTS|OFC|Yield\nGroup|Local IPI|CODE|NAME|POL|POD|Dest|Load\nQuota|Guide|OFC LVL|TREE|ctrl_flg|OFC\nCMB\nTEU|OFC\nCMB\nWGT|TEU|TEU|TEU|TEU|WGT|WGT|WGT|WGT|" + 
                                "Vol|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight|" +
                        		"Vol|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight|Vol|Vol|" +
                        		"Vol|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight|Vol|Weight";
                        		
                        var HeadTitle3 = "OCN\nIPC\nTS|OFC|Yield\nGroup|Local IPI|CODE|NAME|POL|POD|Dest|Load\nQuota|Guide|OFC LVL|TREE|ctrl_flg|OFC\nCMB\nTEU|OFC\nCMB\nWGT|" + headWeek +"|Total TEU|TEU|D2|D4|HC|45'|53'|Reefer|RD|Weight|TEU|D2|D4|HC|45'|53'|" +
                        		"Reefer|RD|Weight|Total TEU|D2|TEU|D4|FEU|HC|45'|53'|Reefer|RD|Weight|Total TEU|D2|TEU|D4|FEU|HC|45'|53'|Reefer|RD|Weight|" +
                        		"Total TEU|D2|20'|D4|40'|HC|45'|53'|Reefer|RD|Weight|Vol|Weight";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);
                        InitHeadRow(2, HeadTitle3, false);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtData,   30,    daCenterTop,  true,     "",     false,          "",   dfNone,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      60,    daCenterTop,  true,     "",     false,          "",   dfNone,      0,     true,       true);
                       
                        InitDataProperty(0, cnt++ , dtData,      50,    daCenterTop,  true,     "cust_ctrl_cd",     false,          "",   dfNone,      0,     		true,       true);
                        
                        InitDataProperty(0, cnt++ , dtData,      60,    daCenterTop,  true,     "us_mod",     false,          "",   dfNone,      0,     true,       true); //Local IPI(US MOD)
                        InitDataProperty(0, cnt++ , dtData,      60,    daCenterTop,  true,     "acct",     false,          "",   dfNone,      0,     true,       true); //Account
                        InitDataProperty(0, cnt++ , dtData,      60,    daLeftTop,    true,     "acct_nm",     false,          "",   dfNone,      0,     true,       true); //Account Name
                        
                        InitDataProperty(0, cnt++ , dtData,      60,    daCenterTop,  true,  "pol",     false,          "",   dfNone,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,     "pod",     false,          "",   dfNone,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,     "dest",    false,          "",   dfNone,      0,     true,       true); //Dest
                        
                        InitDataProperty(0, cnt++ , dtData,      60,    daRight,   true,     "qta",     false,          "",   dfNullInteger,   0,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "smp",    		false,          "",   dfNullInteger,      0,     		true,       true);
    					InitDataProperty(0, cnt++ , dtHidden,    60,    daCenter,  true,     "ofc_lvl",     false,          "",   dfNone,      0,     true,       true);
    					InitDataProperty(0, cnt++ , dtHidden,    60,    daCenter,  true,     "tree",     false,          "",   dfNone,      0,     true,       true);
    					InitDataProperty(0, cnt++ , dtHidden,    60,    daCenter,  true,     "ctrl_flg",     false,          "",   dfNone,      0,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "cmb",    		false,          "",   dfInteger,      0,     		true,       true);
    					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "cmb_wgt",		false,          "",   dfInteger,      0,     		true,       true);
    					//Weekly CMB
    					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",		false,          "",   dfInteger,      0,     		true,       true);
    					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",		false,          "",   dfInteger,      0,     		true,       true);
    					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",		false,          "",   dfInteger,      0,     		true,       true);
    					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",    	false,          "",   dfInteger,      0,     		true,       true);
    					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk", 	false,          "",   dfInteger,      0,     		true,       true);
    					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk",	false,          "",   dfInteger,      0,     		true,       true);
    					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk",	false,          "",   dfInteger,      0,     		true,       true);
    					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk",  false,          "",   dfInteger,      0,     		true,       true);   					
                        //Forecast
                        InitDataProperty(0, cnt++ , dtData,      60,    daRight ,  true,     "fcast_ttl_teu_qty",     false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "proj_teu",     false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "proj_d2",     false,          "",   dfInteger,      0,     true,       true); //D2
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "proj_d4",     false,          "",   dfInteger,      0,     true,       true); //D4
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "proj_d5",     false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "proj_d7",     false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "proj_53",     false,          "",   dfInteger,      0,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "proj_rf", false,          "",   dfInteger,      0,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "proj_rd", false,          "",   dfInteger,      0,     true,       true); //RD
    					InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "proj_wt",     false,          "",   dfInteger,        0,     true,       true);
    					//Allocation
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "alloc_teu",    false,          "",   dfNullInteger,      0,     		true,       true);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "alloc_d2",     false,          "",   dfNullInteger,      0,     		true,       true); //D2
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "alloc_d4",     false,          "",   dfNullInteger,      0,     		true,       true); //D4
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "alloc_d5",     false,          "",   dfNullInteger,      0,     		true,       true);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "alloc_d7",     false,          "",   dfNullInteger,      0,     		true,       true);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "alloc_53",     false,          "",   dfNullInteger,      0,     		true,       true);
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "alloc_rf", 	false,          "",   dfNullInteger,      0,     		true,       true);
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "alloc_rd", 	false,          "",   dfNullInteger,      0,     		true,       true); //RD
                        InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "alloc_wt",     false,          "",   dfNullInteger,        0,     		true,       true);
    					//Firm
    					InitDataProperty(0, cnt++ , dtHidden,      60,    daRight ,  true,     "firm_teu",    false,          "",   dfInteger,      0,     		true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "firm_d2",     false,          "",   dfInteger,      0,     		true,       true); //D2
    					InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "firm_20",     false,          "",   dfInteger,      0,     		true,       true); //20(TEU)
                        InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "firm_d4",     false,          "",   dfInteger,      0,     		true,       true); //D4
    					InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "firm_40",     false,          "",   dfInteger,      0,     		true,       true); //40(FEU)
                        InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "firm_d5",     false,          "",   dfInteger,      0,     		true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "firm_d7",     false,          "",   dfInteger,      0,     		true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "firm_53",     false,          "",   dfInteger,      0,     		true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      50,    daRight ,  true,     "firm_rf", 	false,          "",   dfInteger,      0,     		true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      50,    daRight ,  true,     "firm_rd", 	false,          "",   dfInteger,      0,     		true,       true); //RD
                        InitDataProperty(0, cnt++ , dtHidden,      55,    daRight ,  true,     "firm_wt",     false,          "",   dfInteger,        0,     		true,       true);
    					//Waiting
    					InitDataProperty(0, cnt++ , dtHidden,      60,    daRight ,  true,     "book_teu",    false,          "",   dfInteger,      0,     		true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "book_d2",     false,          "",   dfInteger,      0,     		true,       true); //D2
    					InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "book_20",     false,          "",   dfInteger,      0,     		true,       true); //20(TEU)
                        InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "book_d4",     false,          "",   dfInteger,      0,     		true,       true); //D4
    					InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "book_40",     false,          "",   dfInteger,      0,     		true,       true); //40(FEU)
                        InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "book_d5",     false,          "",   dfInteger,      0,     		true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "book_d7",     false,          "",   dfInteger,      0,     		true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "book_53",     false,          "",   dfInteger,      0,     		true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      50,    daRight ,  true,     "book_rf", 	false,          "",   dfInteger,      0,     		true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      50,    daRight ,  true,     "book_rd", 	false,          "",   dfInteger,      0,     		true,       true); //RD
                        InitDataProperty(0, cnt++ , dtHidden,      55,    daRight ,  true,     "book_wt",     false,          "",   dfInteger,        0,     		true,       true);
    					//Total Booking
    					InitDataProperty(0, cnt++ , dtData,      60,    daRight ,  true,     "totl_teu",     false,         "|firm_teu|+|book_teu|", dfInteger,      0,     		true,       true);
    					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "totl_d2",     false,        	"|firm_d2|+|book_d2|",   dfInteger,      0,     		true,       true); //D2
    					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "totl_20",     false,          "|firm_20|+|book_20|",   dfInteger,      0,     		true,       true); //20(TEU)
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "totl_d4",     false,        	"|firm_d4|+|book_d4|",   dfInteger,      0,     		true,       true); //D4
    					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "totl_40",     false,          "|firm_40|+|book_40|",   dfInteger,      0,     		true,       true); //40(FEU)                   
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "totl_d5",     false,          "|firm_d5|+|book_d5|",   dfInteger,      0,     		true,       true);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "totl_d7",     false,          "|firm_d7|+|book_d7|",   dfInteger,      0,     		true,       true);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "totl_53",     false,          "|firm_53|+|book_53|",   dfInteger,      0,     		true,       true);                        
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "totl_rf",     false,          "|firm_rf|+|book_rf|",   dfInteger,      0,     		true,       true);
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "totl_rd", 	false,          "|firm_rd|+|book_rd|",   dfInteger,      0,     true,       true); //RD
                        InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "totl_wt",     false,          "|firm_wt|+|book_wt|",   dfInteger,        0,     		true,       true);
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "bkg_vol_vgm",     false,          "",   dfInteger,        0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "bkg_wgt_vgm",     false,          "",   dfInteger,        0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      01,    daRight ,  true,     "",     false,          "",   dfNone,        0,     		true,       true);
    					
                        RangeBackColor(1, 4, 2, 74) = RgbColor(203, 210, 248);
                        InitTreeInfo(12, "tree");
                        HeadRowHeight = 10;
                        CountPosition = 0;
                  }
                   break;

                case 3:      //t2sheet2 init - by Contractor(Customer)
	            	with (sheetObj) {
	                    // 높이 설정
	                    style.height = getSheetHeight(9);
	                    //전체 너비 설정
	                    SheetWidth = mainTable[2].clientWidth;
	
	                    //Host정보 설정[필수][HostIp, Port, PagePath]
	                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                    //전체Merge 종류 [선택, Default msNone]
	                    MergeSheet = msHeaderOnly;
	
	                  //전체Edit 허용 여부 [선택, Default false]
	                    Editable = false;
	                    FocusEditMode = default_edit_mode;
	
	                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                    InitRowInfo( 3, 1, 5, 100);
	
	                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                    InitColumnInfo(51, 5, 0, true);
	
	                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                    InitHeadMode(true, true, false, true, false,false) ;
	
	
	                    var HeadTitle0 = "SEQ|Customer\nCode|Customer\nName|Customer\nType|Yield\nGroup|Guide\nVol|"
	                     + "Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|"
	                     + "PORT|OFC|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|" 
	                     + "Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|" 
	                     + "Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|" 
	                     + "Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Booking VGM|Booking VGM" 
	
	                    var HeadTitle1 = "SEQ|Customer\nCode|Customer\nName|Customer\nType|Yield\nGroup|Guide\nVol|"
	                     + "TEU|TEU|TEU|TEU|WGT|WGT|WGT|WGT|"
	                     + "PORT|OFC|Vol|Vol|Vol|Vol|Vol|" 
	                     + "Vol|Weight\n(Ton)"
	                     + "|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight\n(Ton)"
	                     + "|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight\n(Ton)"
	                     + "|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight\n(Ton)|Vol|Weight\n(Ton)";
	
	                    var HeadTitle2 = "SEQ|Customer\nCode|Customer\nName|Customer\nType|Yield\nGroup|Guide\nVol|"
	                     + headWeek + "|"
	                     + "PORT|OFC|Total TEU|TEU|HC|45'|53'|Reefer|Weight\n(Ton)"
	                     + "|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight\n(Ton)"
	                     + "|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight\n(Ton)"
	                     + "|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight\n(Ton)|Vol|Weight\n(Ton)";
	
	                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                    InitHeadRow(0, HeadTitle0, true);
	                    InitHeadRow(1, HeadTitle1, true);
	                    InitHeadRow(2, HeadTitle2, false);
	
	                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                    InitDataProperty(0, cnt++ , dtData,   30,   daCenter,   true,    "",     false,          "",       dfInteger,       0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,   70,    daCenter,  true,     "",     false,          "",   	dfNone,      0,      true,       true);
	                    InitDataProperty(0, cnt++ , dtData,   110,   daLeft,    true,     "",     false,          "",   	dfNone,      0,      true,       true);
	                    
	                    InitDataProperty(0, cnt++ , dtData,      65,    daCenter,  true,     "rvis_cntr_cust_tp_cd",     false,          "",   dfNone,      0,     		true,       true);
	                    InitDataProperty(0, cnt++ , dtData,      65,    daCenter,  true,     "cust_ctrl_cd",     false,          "",   dfNone,      0,     		true,       true);
						InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "smp",    		false,          "",   dfNullInteger,      0,     		true,       true);
						InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",		false,          "",   dfNullInteger,      0,     		true,       true);
						InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",		false,          "",   dfNullInteger,      0,     		true,       true);
						InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",		false,          "",   dfNullInteger,      0,     		true,       true);
						InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",    	false,          "",   dfNullInteger,      0,     		true,       true);
						InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk", 	false,          "",   dfNullInteger,      0,     		true,       true);
						InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk",	false,          "",   dfNullInteger,      0,     		true,       true);
						InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk",	false,          "",   dfNullInteger,      0,     		true,       true);
						InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk",  false,          "",   dfNullInteger,      0,     		true,       true);
	                    
	                    InitDataProperty(0, cnt++ , dtData,   60,    daCenter,   true,    "",     false,          "",       dfNone,       0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,   60,    daCenter,   true,    "",     false,          "",       dfNone,       0,     true,       true);
	
	                    //fcast_ttl_teu_qty
	                    InitDataProperty(0, cnt++ , dtData,      60,    daRight ,  true,     "fcast_ttl_teu_qty",     false,          "",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "proj_teu",    false,          "",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "proj_d5",     false,          "",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "proj_d7",     false,          "",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "proj_53",     false,          "",   dfInteger,      0,     true,       true);
						InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "proj_rf", false,          "",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "proj_wt",     false,          "",   dfInteger,        0,     true,       true);
						
						InitDataProperty(0, cnt++ , dtHidden,      60,    daRight ,  true,     "firm_teu",    false,          "",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "firm_d2",     false,          "",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "firm_d4",     false,          "",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "firm_d5",     false,          "",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "firm_d7",     false,          "",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "firm_53",     false,          "",   dfInteger,      0,     true,       true);
						InitDataProperty(0, cnt++ , dtHidden,      50,    daRight ,  true,     "firm_rf", false,          "",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtHidden,      55,    daRight ,  true,     "firm_wt",     false,          "",   dfInteger,        0,     true,       true);
						
	                    InitDataProperty(0, cnt++ , dtHidden,      60,    daRight ,  true,     "book_teu",    false,          "",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "book_d2",     false,          "",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "book_d4",     false,          "",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "book_d5",     false,          "",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "book_d7",     false,          "",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "book_53",     false,          "",   dfInteger,      0,     true,       true);
						InitDataProperty(0, cnt++ , dtHidden,      50,    daRight ,  true,     "book_rf", false,          "",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtHidden,      55,    daRight ,  true,     "book_wt",     false,          "",   dfInteger,        0,     true,       true);
						
						InitDataProperty(0, cnt++ , dtData,      60,    daRight ,  true,     "totl_teu",     false,          "|firm_teu|+|book_teu|",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "totl_d2",     false,          "|firm_d2|+|book_d2|",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "totl_d4",     false,          "|firm_d4|+|book_d4|",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "totl_d5",     false,          "|firm_d5|+|book_d5|",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "totl_d7",     false,          "|firm_d7|+|book_d7|",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "totl_53",     false,          "|firm_53|+|book_53|",   dfInteger,      0,     true,       true);
						InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "totl_rf",     false,          "|firm_rf|+|book_rf|",   dfInteger,      0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "totl_wt",     false,          "|firm_wt|+|book_wt|",   dfInteger,        0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "bkg_vol_vgm",     false,          "",   dfInteger,        0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "bkg_wgt_vgm",     false,          "",   dfInteger,        0,     true,       true);
	                    InitDataProperty(0, cnt++ , dtHidden,    55,    daRight ,  true,     "flg",     false,          "",   dfNone,        0,     true,       true);
						
	                    RangeBackColor(1,6, 2,49) = RgbColor(203, 210, 248);
	                    HeadRowHeight =10;
	                    CountPosition = 0;
	               }
                break;
                   
                case 4:      //t2sheet2 init - by Shipper
                	with (sheetObj) {
                        // 높이 설정
                        style.height = getSheetHeight(9);
                        //전체 너비 설정
                        SheetWidth = mainTable[2].clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                      //전체Edit 허용 여부 [선택, Default false]
                        Editable = false;
                        FocusEditMode = default_edit_mode;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 3, 1, 5, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(51, 5, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false) ;


                        var HeadTitle0 = "SEQ|Customer\nCode|Customer\nName|Customer\nType|Yield\nGroup|Guide\nVol|"
	                     + "Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|"
	                     + "PORT|OFC|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|" 
                         + "Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|" 
                         + "Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|" 
                         + "Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Booking VGM|Booking VGM" 

                        var HeadTitle1 = "SEQ|Customer\nCode|Customer\nName|Customer\nType|Yield\nGroup|Guide\nVol|"
	                     + "TEU|TEU|TEU|TEU|WGT|WGT|WGT|WGT|"
	                     + "PORT|OFC|Vol|Vol|Vol|Vol|Vol|" 
                         + "Vol|Weight\n(Ton)"
                         + "|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight\n(Ton)"
                         + "|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight\n(Ton)"
                         + "|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight\n(Ton)|Vol|Weight\n(Ton)";

                        var HeadTitle2 = "SEQ|Customer\nCode|Customer\nName|Customer\nType|Yield\nGroup|Guide\nVol|"
	                     + headWeek + "|"
	                     + "PORT|OFC|Total TEU|TEU|HC|45'|53'|Reefer|Weight\n(Ton)"
                         + "|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight\n(Ton)"
                         + "|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight\n(Ton)"
                         + "|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight\n(Ton)|Vol|Weight\n(Ton)";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle0, true);
                        InitHeadRow(1, HeadTitle1, true);
                        InitHeadRow(2, HeadTitle2, false);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtData,   30,   daCenter,   true,    "",     false,          "",       dfInteger,       0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,   70,    daCenter,  true,     "",     false,          "",   	dfNone,      0,      true,       true);
                        InitDataProperty(0, cnt++ , dtData,   110,   daLeft,    true,     "",     false,          "",   	dfNone,      0,      true,       true);

	                    InitDataProperty(0, cnt++ , dtData,      65,    daCenter,  true,     "rvis_cntr_cust_tp_cd",     false,          "",   dfNone,      0,     		true,       true);
	                    InitDataProperty(0, cnt++ , dtData,      65,    daCenter,  true,     "cust_ctrl_cd",     false,          "",   dfNone,      0,     		true,       true);
						InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "smp",    		false,          "",   dfNullInteger,      0,     		true,       true);
						InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",		false,          "",   dfNullInteger,      0,     		true,       true);
						InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",		false,          "",   dfNullInteger,      0,     		true,       true);
						InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",		false,          "",   dfNullInteger,      0,     		true,       true);
						InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",    	false,          "",   dfNullInteger,      0,     		true,       true);
						InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk", 	false,          "",   dfNullInteger,      0,     		true,       true);
						InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk",	false,          "",   dfNullInteger,      0,     		true,       true);
						InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk",	false,          "",   dfNullInteger,      0,     		true,       true);
						InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk",  false,          "",   dfNullInteger,      0,     		true,       true);
	                    
                        InitDataProperty(0, cnt++ , dtData,   60,    daCenter,   true,    "",     false,          "",       dfNone,       0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,   60,    daCenter,   true,    "",     false,          "",       dfNone,       0,     true,       true);
                        
                        //fcast_ttl_teu_qty
                        InitDataProperty(0, cnt++ , dtData,      60,    daRight ,  true,     "fcast_ttl_teu_qty",     false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "proj_teu",    false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "proj_d5",     false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "proj_d7",     false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "proj_53",     false,          "",   dfInteger,      0,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "proj_rf", false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "proj_wt",     false,          "",   dfInteger,        0,     true,       true);
    					
    					InitDataProperty(0, cnt++ , dtHidden,      60,    daRight ,  true,     "firm_teu",    false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "firm_d2",     false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "firm_d4",     false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "firm_d5",     false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "firm_d7",     false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "firm_53",     false,          "",   dfInteger,      0,     true,       true);
    					InitDataProperty(0, cnt++ , dtHidden,      50,    daRight ,  true,     "firm_rf", false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      55,    daRight ,  true,     "firm_wt",     false,          "",   dfInteger,        0,     true,       true);
    					
                        InitDataProperty(0, cnt++ , dtHidden,      60,    daRight ,  true,     "book_teu",    false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "book_d2",     false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "book_d4",     false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "book_d5",     false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "book_d7",     false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      40,    daRight ,  true,     "book_53",     false,          "",   dfInteger,      0,     true,       true);
    					InitDataProperty(0, cnt++ , dtHidden,      50,    daRight ,  true,     "book_rf", false,          "",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,      55,    daRight ,  true,     "book_wt",     false,          "",   dfInteger,        0,     true,       true);
    					
    					InitDataProperty(0, cnt++ , dtData,      60,    daRight ,  true,     "totl_teu",     false,          "|firm_teu|+|book_teu|",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "totl_d2",     false,          "|firm_d2|+|book_d2|",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "totl_d4",     false,          "|firm_d4|+|book_d4|",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "totl_d5",     false,          "|firm_d5|+|book_d5|",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "totl_d7",     false,          "|firm_d7|+|book_d7|",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "totl_53",     false,          "|firm_53|+|book_53|",   dfInteger,      0,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "totl_rf",     false,          "|firm_rf|+|book_rf|",   dfInteger,      0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "totl_wt",     false,          "|firm_wt|+|book_wt|",   dfInteger,        0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "bkg_vol_vgm",     false,          "",   dfInteger,        0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "bkg_wgt_vgm",     false,          "",   dfInteger,        0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    55,    daRight ,  true,     "flg",     false,          "",   dfNone,        0,     true,       true);
    					
                        RangeBackColor(1,6, 2,49) = RgbColor(203, 210, 248);
                        HeadRowHeight =10;
                        CountPosition = 0;
                   }
                    break;
                    
            }
        }

      // Sheet1관련 프로세스 처리
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
                    	
//    				formObj.f_cmd.value = SEARCHLIST01;			
    				formObj.vvd[0].value="";
    				formObj.vvd[1].value="";
    				
    				var param = "year1=" + formObj.year1.value;
    				param = param + "&week1="        + formObj.week1.value;
    				param = param + "&year2="        + formObj.year2.value;
    				param = param + "&week2="        + formObj.week2.value;
    				param = param + "&only_vvd="     + formObj.only_vvd.value;
    				
    				param = param + "&sales_office=" + formObj.sales_office.value;
    				param = param + "&trade="       + comObjects[0].Code;
        			param = param + "&subtrade="    + comObjects[1].Code;
        			param = param + "&lane="        + comObjects[2].Code;
        			param = param + "&bound="        + formObj.bound.value;
        			
//    				sheetObj.DoSearch4Post("ESM_SPC_0028GS.do", FormQueryString(formObj));
    				sheetObj.DoSearch4Post("ESM_SPC_0028GS.do","f_cmd=" + (SEARCHLIST01)+"&"+param );
//    				alert(param);
    				break;

               case IBDOWNEXCEL:        //엑셀 다운로드
                  	sheetObj.Down2Excel(0);
                 	break;
            }
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
         * Tab 기본 설정
         * 탭의 항목을 설정한다.
         */
        function initTab(tabObj , tabNo) {

             switch(tabNo) {
                 case 1:
                    with (tabObj) {
                        var cnt  = 0 ;
                        InsertTab( cnt++ , "By Office" , -1 );
                        InsertTab( cnt++ , "By Contractor " , -1 );
                        InsertTab( cnt++ , "By Shipper " , -1 );
                    }
                 break;

             }
        }

        /**
         * Tab 클릭시 이벤트 관련
         * 선택한 탭의 요소가 활성화 된다.
         */
        function tab1_OnChange(tabObj , nItem)
        {
    		var objs = document.all.item("tabLayer");
    		for(var i = 0 ; i < objs.length ; i++){
    			objs[i].style.display = "none";
    		}
    		objs[nItem].style.display = "Inline";
    		beforetab = nItem;
        }	
        
        /*
     	 * sheet1클릭시 탭화면 조회
     	 */
     	function sheet1_OnDblClick(sheetObj, row, col)
        {
        	var sheetObj = sheetObjects[0];
        	var sheetObj1 = sheetObjects[beforetab+1];

        	//weekly cmb header 조회
//        	ComOpenWait(true);
    		var weekXml = sheetObj.GetSearchXml("ESM_SPC_0042GS2.do?f_cmd="+SEARCH);
    		headWeek = ComGetEtcData(weekXml, "headerWeek");
//    		ComOpenWait(false);
    		sheetObj1.Enable = false;
    		sheetObj1.ReDraw = false;
    		sheetObj1.RemoveAll();
    		initSheet(sheetObjects[1], 2);
    		initSheet(sheetObjects[2], 3);
    		initSheet(sheetObjects[3], 4);
    		sheetObj1.ReDraw = true;
    		sheetObj1.Enable = true;
    		
        	var formObj = document.form;
        	var year1 = formObj.year1.value;
        	var week1 = formObj.week1.value;
        	var year2 = formObj.year2.value;
        	var week2 = formObj.week2.value;
    		var sales_office = formObj.sales_office.value;
    		var pol_pod ;		        
    		var ctrlFlg;
    		var ofcLvl;
    		save_lane = sheetObj.CellValue(row, "LANE");
    		save_bound = sheetObj.CellValue(row, "BOUND");
    		save_vvd = sheetObj.CellValue(row, "VVD");
    		save_trade = sheetObj.CellValue(row, "TRADE");
    		save_subtrade = sheetObj.CellValue(row, "SUBTRADE");
    		pop_yrwk = sheetObj.CellValue(row, "WEEK");
    		for(var i = 0 ; i < formObj.vvd.length ; i++){
    			formObj.vvd[i].value = save_vvd;
    		}
    		var paramCond = "&year1="+year1+"&week1="+week1+"&year2="+year2+"&week2="+week2+"&sales_office="+sales_office+
    			"&lane="+save_lane+"&bound="+save_bound+"&vvd="+save_vvd+"&pol_pod=POL"+
    			"&trade="+save_trade+"&subtrade="+save_subtrade;
    		var param = "f_cmd="+SEARCHLIST02+paramCond;
    		ComOpenWait(true);
    		var datas = sheetObjects[beforetab+1].GetSearchXml("ESM_SPC_0028GS.do", param);
    		ComOpenWait(false);
    		var xmls = datas.split("[+]");
    		for(var j = 0 ; j < xmls.length ; j++){
    			sheetObjects[j+1].LoadSearchXml(xmls[j]);
    		}
    		
        }
        
        /*
         * sheet1조회후 tab sheet clear
         */
        function sheet1_OnSearchEnd(sheetObj , ErrMsg){
            if(ErrMsg== ""){	   
            	for(var i = 1 ; i < sheetObjects.length ; i++){ 
                	sheetObjects[i].RemoveAll(); 
                }
          	}
        }
         
        /*
         * sheet1조회후 tab sheet clear
         */
    	var ctrl_port = false;
    	var ctrl_d5 = false;
    	var ctrl_d7 = false;
    	var ctrl_53 = false;
    	var ctrl_rf = false;
    	var ctrl_wt = false;
    	var ctrl_d2 = false;
    	var ctrl_d4 = false;
    	var ctrl_rd = false;
    	var ctrl_acct = false;
    	var ctrl_usa = false;
    	
        function t1sheet1_OnSearchEnd(sheetObj , ErrMsg){
        	ctrl_port = sheetObj.EtcData("pol_pod");
        	ctrl_d5 = sheetObj.EtcData("hc40") == "Y";
        	ctrl_d7 = sheetObj.EtcData("hc45") == "Y";
        	ctrl_53 = sheetObj.EtcData("ft53") == "Y";
        	ctrl_rf = sheetObj.EtcData("reefer") == "Y";
        	ctrl_wt = sheetObj.EtcData("weight") == "Y";
        	ctrl_d2 = sheetObj.EtcData("ctrl_d2") == "Y";
        	ctrl_d4 = sheetObj.EtcData("ctrl_d4") == "Y";
        	ctrl_rd = sheetObj.EtcData("ctrl_rd") == "Y";
        	ctrl_acct = sheetObj.EtcData("ctrl_acct") == "Y";
        	ctrl_usa = sheetObj.EtcData("ctrl_usa") == "Y";
        	  	
        	var formObj = document.form;
        	formObj.chkPort.value = ctrl_port;
        	formObj.chkHC40.checked = ctrl_d5;
        	formObj.chkHC45.checked = ctrl_d7;
        	formObj.chk53FT.checked = ctrl_53;
        	formObj.chkRFR.checked = ctrl_rf;
        	formObj.chkWGT.checked = ctrl_wt;
        	formObj.chkPol.checked = ctrl_port=="L" || ctrl_port=="D" || ctrl_port=="T";
        	formObj.chkPod.checked = ctrl_port=="D" || ctrl_port=="T";
        	formObj.chkDest.checked = ctrl_port=="T";
//        	formObj.chkAcct.checked = ctrl_port=="L" || ctrl_port=="D" || ctrl_port=="T";
//        	formObj.chkLocalIpi.checked = (ctrl_port=="L" || ctrl_port=="D" || ctrl_port=="T") || formObj.chkAcct.checked;
        	formObj.chkTYP[0].checked = (ctrl_d5 || ctrl_d7 || ctrl_rf);
        	formObj.chkD2.checked = ctrl_d2;
        	formObj.chkAcct.checked = ctrl_acct;
        	formObj.chkLocalIpi.checked = ctrl_usa;	       	
        	        	
        	//성수기(ctrl_flg) 와 office level에 따른 smp guide 숨김처리
        	if(sheetObj.SearchRows > 0){
    			ctrlFlg = sheetObj.CellValue(sheetObj.HeaderRows, "ctrl_flg");
    			ofcLvl = sheetObj.CellValue(sheetObj.HeaderRows, "ofc_lvl");
    			
//            	changePort();
    			controlTrees();
            	changeTpSz(0);
            	changeWgt(0);
            	changeCMB(0);
            	
    			for(i=1;i<sheetObjects.length;i++){
    				if(ctrlFlg == "N"){ 
    					sheetObjects[i].ColHidden("cust_ctrl_cd") = true;
    					sheetObjects[i].ColHidden("smp") = true;
    				}else{
    					sheetObjects[i].ColHidden("cust_ctrl_cd") = false;
    					if(Number(ofcLvl) <= "4"){
    						sheetObjects[i].ColHidden("smp") = false;
    					}else{
    						sheetObjects[i].ColHidden("smp") = true;    					
    					}
    				}
    			}
    			if(ctrlFlg == "N"){
    				ComBtnDisable("btng_season_grp");
    			}else{
    				ComBtnEnable("btng_season_grp");
    			}
    			
    			//total line 색깔처리 
    			var size = sheetObj.LastCol;
    			var cnt=0;
    			if(ctrlFlg == "Y"){
    				for(var i = 0 ; i <= size ; i++){
    					var name = sheetObj.ColSaveName(i);
    					if(name=="cust_ctrl_cd") cnt++;
    					if(cnt>0){
    						sheetObj.CellBackColor(sheetObj.HeaderRows, i) = sheetObj.RgbColor(247,231,236);
    					}
    				}
    			}
    		}
        }
    	
        /*
         * t1sheet1조회후 tab sheet clear
         */
        function t1sheet2_OnSearchEnd(sheetObj , ErrMsg){
            changePolPod(1);
        	changeTpSz(1);
        	changeWgt(1);
        	changeCMB(1);
        }
        /*
         * t1sheet2조회후 tab sheet clear
         */
        function t1sheet3_OnSearchEnd(sheetObj , ErrMsg){
            changePolPod(2);
        	changeTpSz(2);
        	changeWgt(2);
        	changeCMB(2);
        }
        function controlTrees(){
        	var sheetObj = sheetObjects[1];
        	var formObj = document.form;
        	var sts2 = formObj.chkPol.checked;
        	if(!sts2) formObj.chkPod.checked = false;
        	var sts3 = formObj.chkPod.checked;
        	var sts4 = formObj.chkDest.checked;
        	
        	// 이 두개의 경우 완전 분리 별도로 로직 check 박스 연동 없이 함
        	// US mod : sts5  / Account : sts6
        	var sts5 = formObj.chkLocalIpi.checked;
        	var sts6 = formObj.chkAcct.checked;
        	if(sts4){
        		formObj.chkPod.checked = true;
        		formObj.chkPol.checked = true;
        		sts3 = formObj.chkPod.checked;
        		sts2 = formObj.chkPol.checked;
        	}
        	with(sheetObj){
        		if(ctrlFlg == "N"){
        			ShowTreeLevel(sts4?6:(sts3?5:(sts2?4:(sts6?3:(sts5?2:6)))));
        		} else{
        			// SMP의 경우 level이 1개 증가
        			ShowTreeLevel(sts4?7:(sts3?6:(sts2?5:(sts6?4:(sts5?2:7)))));
        		}
        		// 우선 다 연후 조절
        		if(ctrlFlg == "N") {
        			ShowTreeLevel(6, 2);
        		}else {
        			ShowTreeLevel(7, 2);
        		}

        		// 처음에 row를 모두 펼처둔 다음 하나씩 확인하여 닫음
        		// checkbox상태 sts2:POL sts3:POD sts4:DEST sts5:IPI sts6:Account
        		if(ctrlFlg == "N"){
        			if(!sts4)HideRow(sheetObj, "tree", 6);
        			if(!sts3)HideRow(sheetObj, "tree", 5);
        			if(!sts2)HideRow(sheetObj, "tree", 4);
        			if(!sts6)HideRow(sheetObj, "tree", 3);
        			if(!sts5)HideRow(sheetObj, "tree", 2);
        		}else{
        			if(!sts4)HideRow(sheetObj, "tree", 7);
        			if(!sts3)HideRow(sheetObj, "tree", 6);
        			if(!sts2)HideRow(sheetObj, "tree", 5);
        			if(!sts6)HideRow(sheetObj, "tree", 4);
        			if(!sts5)HideRow(sheetObj, "tree", 3);
        		}
//        		//DEST가 check되면 DEST별 sum 보여줌 (control by Main Office는 제외)
//        		if(uiname == 'ESM_SPC_0042' || uiname == 'ESM_SPC_0047'){
//        			if(!sts4)HideRow(sheetObj, "rowDest", "true");
//        			if(sts4)ShowRow(sheetObj, "rowDest", "true");
//        		}

        		ColHidden("pol") = !sts2&&!sts3;
        		ColHidden("pod") = !sts3;
        		ColHidden("dest") = !sts4||!sts3;
        		ColHidden("acct") = !sts6;
        		ColHidden("acct_nm") = !sts6;
        		ColHidden("us_mod") = !sts5;
        	}
        	return true;
        }    	
    	function changePort(){
    		var obj;
    		var formObj;
    		var objName;
    		if(event != null){
    			obj = event.srcElement;
    			formObj = obj.form;
    			objName = obj.name;
    		}
    		else{
    			formObj = document.form;
    			objName = "";
    		}
    		var sheetObj = sheetObjects[1];
    		switch(objName){
    			case "chkLocalIpi" : //Local IPI 클릭시	
    				if(!obj.checked){
//    					formObj.chkAcct.checked = false;
//    					formObj.chkPol.checked = false;
//    					formObj.chkPod.checked = false;
//    					formObj.chkDest.checked = false;
    				}
    				
    				if(ctrlFlg == "N") {
    					sheetObj.ShowTreeLevel(obj.checked?2:1, obj.checked?2:0);
    				}
    				else {
    					sheetObj.ShowTreeLevel(obj.checked?3:2, obj.checked?2:0);
    				}
    				
    				break;
    			case "chkAcct" : //Account 클릭시
    				if(obj.checked) {
    					formObj.chkLocalIpi.checked = true;
    				} else {
    					formObj.chkPol.checked = false;
    					formObj.chkPod.checked = false;
    					formObj.chkDest.checked = false;
    				}
    				
    				if(ctrlFlg == "N") {
    					sheetObj.ShowTreeLevel(obj.checked?3:2, obj.checked?2:0);
    				}
    				else {
    					sheetObj.ShowTreeLevel(obj.checked?4:3, obj.checked?2:0);
    				}
    				
    				break;    				
    			case "chkPol": //Pol 클릭시
	    			if (obj.checked) {
    					formObj.chkLocalIpi.checked = true;
    					formObj.chkAcct.checked = true;   
	    			} else {
    					formObj.chkPod.checked = false;
    					formObj.chkDest.checked = false;
    				}
	    			
	    			if(ctrlFlg == "N") {
	    				sheetObj.ShowTreeLevel(obj.checked?4:3, obj.checked?2:0);
	    			}
	    			else {
	    				sheetObj.ShowTreeLevel(obj.checked?5:4, obj.checked?2:0);
	    			}
	    			
    				break;    				
    			case "chkPod": //Pod 클릭시
    				if(obj.checked){
    					formObj.chkLocalIpi.checked = true;
    					formObj.chkAcct.checked = true;    					
    					formObj.chkPol.checked = true;
    				}
    				else {
    					formObj.chkDest.checked = false;
    				}
    				
    				if(ctrlFlg == "N") {
    					sheetObj.ShowTreeLevel(obj.checked?5:4, obj.checked?2:0);
    				}
    				else {
    					sheetObj.ShowTreeLevel(obj.checked?6:5, obj.checked?2:0);
    				}
    				
    				break;   
    			case "chkDest" : //Dest 클릭시
    				if(obj.checked){
    					formObj.chkLocalIpi.checked = true;
    					formObj.chkAcct.checked = true;
    					formObj.chkPol.checked = true;
    					formObj.chkPod.checked = true;
    				}
    				
    				if(ctrlFlg == "N") {
    					sheetObj.ShowTreeLevel(obj.checked?6:5, obj.checked?2:0);
    				} 
    				else {
    					sheetObj.ShowTreeLevel(obj.checked?7:6, obj.checked?2:0);
    				}
    				
    				break;
    				
    			default : // 초기 로딩시
    				
    				if(ctrlFlg == "N") {
    					if(formObj.chkDest.checked) { //Dest 상태에 따라 설정
    						sheetObj.ShowTreeLevel(6, 2);
    					} else {    						
    						if(formObj.chkPod.checked) { //Pod 상태에 따라 설정
    							sheetObj.ShowTreeLevel(5, 2);
    						}
    						else {
    							if(formObj.chkPol.checked) { //Pol 상태에 따라 설정
    								sheetObj.ShowTreeLevel(4, 2);
    							}
    							else {
    								if(formObj.chkAcct.checked) { //Account 상태에 따라 설정
    									sheetObj.ShowTreeLevel(3, 2);
    								}
    								else {
    									if(formObj.chkLocalIpi.checked) { //Local IPI 상태에 따라 설정
    										sheetObj.ShowTreeLevel(2, 2);
    									}
    									else {
    										sheetObj.ShowTreeLevel(1, 0);
    									}
    								}
    							}
    						}
    					}
    						
    				}
    				else {
    					if(formObj.chkDest.checked) { //Dest 상태에 따라 설정
    						sheetObj.ShowTreeLevel(7, 2);
    					}
    					else {   		
    						if(formObj.chkPod.checked) { //Pod 상태에 따라 설정
    							sheetObj.ShowTreeLevel(6, 2);
    						}
    						else {
    							if(formObj.chkPol.checked) { //Pol 상태에 따라 설정
    								sheetObj.ShowTreeLevel(5, 2);
    							}
    							else {
    								if(formObj.chkAcct.checked) { //Account 상태에 따라 설정
    									sheetObj.ShowTreeLevel(4, 2);
    								}
    								else {
    									if(formObj.chkLocalIpi.checked) { //Local IPI 상태에 따라 설정
    										sheetObj.ShowTreeLevel(3, 2);
    									}
    									else {
    										sheetObj.ShowTreeLevel(2, 0);
    									}
    								}
    							}
    						}
    					}
    				}

				
    				break;
    		}
    		
    		sheetObj.ColHidden("pol") = !formObj.chkPol.checked;
    		sheetObj.ColHidden("pod") = !formObj.chkPod.checked;
    		sheetObj.ColHidden("dest") = !formObj.chkDest.checked;
    		sheetObj.ColHidden("us_mod") = !formObj.chkLocalIpi.checked;
    		sheetObj.ColHidden("acct") = !formObj.chkAcct.checked;
    		sheetObj.ColHidden("acct_nm") = !formObj.chkAcct.checked;
    	}
    	function changePolPod(tab){
    		var atab = tab;
    		if(tab){
    			tab = tab - 1;
    		}
    		else{
    			tab = beforetab - 1;
    		}
            var formObj = document.form;
            var chkObj = tab==0?formObj.chkPolPodS:formObj.chkPolPodC;
            var selPort = chkObj[0].checked?"POL":"POD";
            var sheetObj = sheetObjects[tab + 2];
            var row = -1;            
            while((row = sheetObj.FindText("flg", selPort, row+1)) > 0){
                sheetObj.RowHidden(row) = false;
            }
            selPort = chkObj[0].checked?"POD":"POL";
            while((row = sheetObj.FindText("flg", selPort, row+1)) > 0){
                sheetObj.RowHidden(row) = true;
            }
        }
    	function selectChange(){ 
    		var obj = event.srcElement;
    		var objName = obj.name;
    		switch(objName){
    			case "chkTYP":
    				changeTpSz(beforetab);
    				break;
    			case "chkWT":
    				changeWgt(beforetab);
    				break;
    			case "chkCMB":
    				changeCMB(beforetab);
    				break;
    		}
    	}
    	function changeTpSz(tab){
    		var formObj = document.form;
    		var obj = formObj.chkTYP[tab];
    		var hidden = !obj.checked;
    		var sheetObj = sheetObjects[tab+1];
    		var size = sheetObj.LastCol;
    		for(var i = 0 ; i <= size ; i++){
    			var name = sheetObj.ColSaveName(i);
    			var names = name.split("_");
    			if(name == "") continue;
    			if(names[0] == "firm" || names[0] == "book") continue;
    			
    			switch(names[1]){
    				case "teu":
    				case "ttl"://Weight
	    				sheetObj.ColWidth(i) = hidden?80:60;
	    				break;
    				case "d2":
    				case "d4":
    				case "d5":
    				case "d7":
    				case "53":
    				case "rd":	
    				case "rf":
    					sheetObj.ColHidden(i) = hidden;
    					break;
    			}
    			
    			if(names.length == 1 || names[1] == "teu" || names[1] == "wt") continue; 
    			if(names[0] == "alloc"){
    				var checked = !eval("ctrl_" + names[1]);
    				sheetObj.ColHidden(i) = hidden || checked; 
    			}
    			
    			//fcast_ttl_teu_qty처리, FCAST의 경우 TEU는 감추고 Total TEU를 보여주도록 수정
    			if(name == 'fcast_ttl_teu_qty'){//Total TEU컬럼은 항상 보이도록
    			    sheetObj.ColHidden(i) = false;
    			    sheetObj.ColHidden(i+1) = hidden;
    			    //sheetObj.ColWidth(i) = !hidden?60:80;//Total TEU 컬럼 사이즈 조절
    			} 

    		}
    	}
    	function changeWgt(tab){
    		var formObj = document.form;
    		var obj = formObj.chkWT[tab];
    		var hidden = !obj.checked;
    		var sheetObj = sheetObjects[tab+1];
    		var cmbObj = formObj.chkCMB[tab];
    		var size = sheetObj.LastCol;

    		for(var i = 0 ; i <= size ; i++){
    			var name = sheetObj.ColSaveName(i);
    			
    			if(name == "") continue;
    			if(name == "bkg_wgt_vgm"){
    				sheetObj.ColHidden(i) = hidden;
    			}
    			if(name == "cmb_wgt_wk"){
    				if(cmbObj.checked){
    					sheetObj.ColHidden(i) = hidden;
    				}
    				continue;
    			}
    			var names = name.split("_");
    			if(names[1] != "wt") continue;
    			if(names[0] == "firm" || names[0] == "book") continue;
    			if(names[0] == "alloc"){
    				var checked = !eval("ctrl_" + names[1]);
    				sheetObj.ColHidden(i) = hidden || checked; 
    			}
    			
    			else{
    				sheetObj.ColHidden(i) = hidden;
    			}
    		}
    	}
    	function changeCMB(tab){
    		var formObj = document.form;
    		var sheetObj;
	       	var sts, weight; 
	       	var obj = formObj.chkCMB[tab];
    		var hidden = !obj.checked;
    		var sheetObj = sheetObjects[tab+1];
    		var wtObj = formObj.chkWT[tab];
	       	sts = obj.checked;
	       	for (i=0; i<=sheetObj.LastCol; i++) {
	       		var colName = sheetObj.ColSaveName(i);
	       		switch(colName){
	       		case "cmb_wk":
	       			sheetObj.ColHidden(i) = !sts;
	       			break;
	       			
	       		case "cmb_wgt_wk":
	       			if(wtObj.checked){
	       				sheetObj.ColHidden(i) = !sts;
	       			}
	       			break;
	       			
	       		}
	       	}
    	}
    	/*
    	 * 입력한 Office값 체크
    	 */
    	 function checkValue() {
        	var formObj = document.form;
        	var value = formObj.sales_office.value;
        	value = ComTrim(value);//value = trim(value);
        	
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
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            var ovvd = formObj.only_vvd.value;
            var wk = calcPeriod(formObj.year1.value,formObj.week1.value,formObj.year2.value,formObj.week2.value);
    		var office = formObj.sales_office.value;
    		
    		if(office==""){
    			ComShowMessage(getMsg("SPC90114", "Office"));
    			formObj.sales_office.focus();
    			return false; 
    		}
    			
    		if(ovvd!="" && ovvd.length<9){
    			ComShowCodeMessage("COM12174", "VVD", "9"); 
                formObj.only_vvd.focus();
                return false;
            }else if(ovvd==""){
    			if( wk < 0 ){
                	ComShowMessage(getMsg("SPC90115","Period")); 
                    formObj.year1.focus();
                    return false;
                }
	            if(wk > 13){
	            	ComShowCodeMessage("COM12114", "Limit 3 Month"); 
	            	formObj.year1.focus();
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

         function subtrade_OnChange(comObj,value,text ){
//        	if(text == '||ALL'){   optionAllReset("subtrade",document.form.trade.Code); return; } // 0207 SHKIM         	
        	 SpcSearchOptionLane("lane",true,true,'',document.form.trade.Code,value,true);	// 0207 SHKIM        	
         	if(value == "" ) return;
        	var arrTrade = text.split("|");
        	if(arrTrade.length > 1) {
        		comObjects[0].Code2 = arrTrade[0];
        		comObjects[2].Code2 = '';
        	} else {
        		comObjects[0].Code2 = comObj.GetText(value,0);  
        		comObjects[2].Code2 = '';
        	}
         }  
         function trade_OnChange(comObj,value,text ){
//        	if(text == '|ALL'){	optionAllReset("trade",value);   return;} // 0207 SHKIM
//         	if(value == "" ) return;
         	var repTrade = comObj.GetText(value,0);  
         	comObjects[1].Code2 = ""; //sub trade
         	comObjects[2].Code2 = ""; // lane
         	SpcSearchOptionSubTrade("subtrade",true,false,"","",value);			// 0207 SHKIM
    		SpcSearchOptionLane("lane",true,true,'',value,'',true);	// 0207 SHKIM
         } 
         function lane_OnChange(comObj,value,text ){
        	// 해당사항없음.if(text == '||ALL'){	optionAllReset("lane");  } // 0207 SHKIM
 	    	if(value == "" ) return;
 	    	var arrLane = text.split("|");
 	    	if(arrLane.length > 1) {
 	    		comObjects[0].Code2 = arrLane[0];
 	    		comObjects[1].Code2 = arrLane[1];
 	    	} else {
 	    		comObjects[0].Code2 = comObj.GetText(value,0);  
 	    		comObjects[1].Code2 = comObj.GetText(value,1);  
 	    	}	
 	    	
         }  
         
     /**
      * Yield Group 팝업 호출(ESM_SPC_0094)
      */
     function yieldGrpPopup() {
     	var formObj = document.form;
     	
     	if(pop_yrwk=="" || save_trade==""){
     		return;
     	}
     	var param = "yrwk="   + pop_yrwk;
     	param = param + "&trd_cd=" + save_trade;
     	
     	ComOpenWindow("ESM_SPC_0094.do?" + param, "Yield Group", "height=300,width=450,status=0");
     }
   
	/* 개발자 작업  끝 */
