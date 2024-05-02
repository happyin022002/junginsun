/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0056.js
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
* 2008-11-17 임옥영/서관영 CSR:N200811140005/N200811130019 
* - 단축키 추가(ESM_SPC_022, 024, 028, 056, 070)
* 2008-12-26 임옥영 CSR:N200812230019 BKG의 TEU->Total TEU로 변경
* 2009-04-23 서관영/최윤성 CSR:N200904130110, N200904150051
* 2010-06-22 Lee Sang-Yong : 프로젝트 CHM-201004171  53ft(DW,DX) 추가
* - FCST Data 조회 추가 
*@LastModifyDate : 2009.10.13
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.10.13 한상훈
* 1.0 Creation
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2013.02.06 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진 - Type/Size 별 Hidden 기능 추가
* 2013.11.14 진마리아 ALPS ERROR LOG 조치 - 날짜 형식 체크가 change에서 일어나서, 알맞지 않더라도 지워주지 않아 그대로 조회하며 에러발생
* 2014.07.30 차상영 [CHM-201431081] SPC Allocation Control Option 추가 보완
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
     * @class ESM_SPC_0056 : ESM_SPC_0056 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0056() {
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
             var sheetObject = sheetObjects[0];
             var sheetObject1 = sheetObjects[1];

             /*******************************************************/
             var formObject = document.form;

//        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

            	    case "btn_retrieve":
        	            	doActionIBSheet(sheetObject,formObject,IBSEARCH);
            	        break;

            	    case "btn_downexcel":
            	        doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
            	        break;
            	        
    				case "btn_popup_port": 
    					var port  = formObject.port.value;
            	        spcPopup("Port", "port="+port, 770, 470, "callbackPopupPortCd", "1,0,1,1,1,1,1,1");
    					break;
    					
                    case "btn_new":
                        doActionIBSheet(sheetObject,formObject,IBCLEAR);
                        
						SpcSearchOptionTrade("trade", true, true, '', true);
						SpcSearchOptionSubTrade("subtrade", true, true);
						SpcSearchOptionLane("lane"); // 0207 SHKIM    
                        break;					      	        
            	    case "btns_calendar1":
            	        // 달력 팝업
            	        var cal = new ComCalendar();
               		    //cal.select(formObject.sDate, 'sDate', 'yyyy-MM-dd');
            	        cal.select(formObject.sDate, 'yyyy-MM-dd');
            	        break;
            	    case "btns_calendar2":
            	        // 달력 팝업
            	        var cal = new ComCalendar();
               		    //cal.select(formObject.eDate, 'eDate', 'yyyy-MM-dd');
            	        cal.select(formObject.eDate, 'yyyy-MM-dd');
            	        break;

                } // end switch
//        	}catch(e) {
//        		if( e == "[object Error]") {
//        			ComShowCodeMessage("COM12111");
//        		} else {
//        			ComShowMessage(e);
//        		}
//        	}
        }
        function getOffice(rowArray){
            var colArray = rowArray[0];	
        	
        	document.all.office.value = colArray[3];
            
        }
        function getPOL(rowArray){
            var colArray = rowArray[0];	
        	
        	document.all.pol.value = colArray[3];
            
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
        	SpcSearchOptionTrade("trade", true, true, '', true);
        	SpcSearchOptionSubTrade("subtrade", true, true);
        	SpcSearchOptionLane("lane");
        	SpcSearchOptionBound("bound",false,true,false,true);
        	SpcSearchOptionOcnipc("ioc",true);

            document.body.style.visibility = "hidden";
            //document.getElementById("mainTable2").style.display= "inline";
            for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            
            var sheetResizeFull = true;
    		document_onresize();
    		
            //document.getElementById("mainTable2").style.display= "none";
            document.body.style.visibility = "visible";
            
    		var formObject = document.form;
    		setInitDate();
    		/* test using s
    		if(isDevMode)
    		{
    			 formObject.org.value = "";
    			 formObject.sDate.value = "20070527";
    			 formObject.eDate.value = "20070610";
    			 formObject.port.value = "CNHKG";
    			 comObjects[0].Code = "TPS";			 
    		}
    		test using e */		
        }

        function setInitDate() {
    		var formObject = document.form;
    		var cDate = new Date();
    		formObject.sDate.value = cDate.getYear()+"-"+((cDate.getMonth()+1)<10?"0":"")+(cDate.getMonth()+1)+"-"+((cDate.getDate())<10?"0":"")+cDate.getDate();
    		cDate = new Date(cDate.getYear(), cDate.getMonth(), cDate.getDate() + 13);
    		formObject.eDate.value = cDate.getYear()+"-"+((cDate.getMonth()+1)<10?"0":"")+(cDate.getMonth()+1)+"-"+((cDate.getDate())<10?"0":"")+cDate.getDate();
    		
    		formObject.sDate.focus();
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
                        //style.height = 295 ;
                    	style.height = getSheetHeight(19) ;
                    	
                        //전체 너비 설정
                        SheetWidth = mainTable1.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        //MergeSheet = msPrevColumnMerge;
                        MergeSheet = msPrevColumnMerge;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = false;
                        FocusEditMode = default_edit_mode;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(3, 1, 10, 100);
    					//headerCols = 6;
                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(85, 0 , 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(false, false, false, true, false,false) ;

                        var HeadTitle1 = "ETB|Rep.\nTrade|Rep.\nSubTrd|Trade|Sub\nTrade|Lane|Week|VVD|OCN\nIPC|RHQ|Area|Office|SUB\nOffice|Local/IPI|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Allocation|Allocation|Allocation|Allocation|Allocation|Allocation|Allocation|Allocation|Allocation|Alloc DIFF (with bkg)|Alloc DIFF (with bkg)|Alloc DIFF (with bkg)|Alloc DIFF (with bkg)|Alloc DIFF (with bkg)|Alloc DIFF (with bkg)|Alloc DIFF (with bkg)|Alloc DIFF (with bkg)|Alloc DIFF (with bkg)|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking VGM|Booking VGM|By Discharging Vessel|By Discharging Vessel|By Discharging Vessel|By Discharging Vessel|By Discharging Vessel|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking VGM|Booking VGM|treeLvl";
                        var HeadTitle2 = "ETB|Rep.\nTrade|Rep.\nSubTrd|Trade|Sub\nTrade|Lane|Week|VVD|OCN\nIPC|RHQ|Area|Office|SUB\nOffice|Local/IPI|POD| |Dest|TEU|D2|D4|HC|45|53'|RF|RD|WT|TEU|D2|D4|HC|45|53'|RF|RD|WT|TEU|D2|D4|HC|45|53'|RF|RD|WT|Total|Total|Total|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|VGM|VGM|Rep.|Sub|Lane|VVD|ETB|Total|Total|Total|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|VGM|VGM|treeLvl";
                        var HeadTitle3 = "ETB|Rep.\nTrade|Rep.\nSubTrd|Trade|Sub\nTrade|Lane|Week|VVD|OCN\nIPC|RHQ|Area|Office|SUB\nOffice|Local/IPI|POD| |Dest|TEU|D2|D4|HC|45|53'|RF|RD|WT|TEU|D2|D4|HC|45|53'|RF|RD|WT|TEU|D2|D4|HC|45|53'|RF|RD|WT|Total TEU|TEU|FEU|D2|20'|D4|40'|HC|45|53'|RF20|RF40|RD20|RD40|WT|TEU|WT|Trade| Trade ||||Total TEU|TEU|FEU|D2|20'|D4|40'|HC|45|53'|RF20|RF40|RD20|RD40|WT|TEU|WT|treeLvl";


                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);
                        InitHeadRow(2, HeadTitle3, true);

                        //데이터속성          [ROW, COL,   DATATYPE,    WIDTH, DATAALIGN,  COLMERGE, SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                        InitDataProperty(0, cnt++ , dtDataSeq,       50,    daCenter,   false,    "SEQ",                 false,    "",         dfNone,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      60,    daCenterTop,   true,    "etb_dt",                 false,    "",         dfNone,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      45,    daCenterTop,   true,    "rep_trd_cd",                 false,    "",         dfNone,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      50,    daCenterTop,   true,    "rep_sub_trd_cd",                 false,    "",         dfNone,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      45,    daCenterTop,   true,    "trd_cd",                 false,    "",         dfNone,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      45,    daCenterTop,   true,    "sub_trd_cd",                 false,    "",         dfNone,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      45,    daCenterTop,   true,    "lane",                 false,    "",         dfNone,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      45,    daCenterTop,   true,    "week",                 false,    "",         dfNone,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      70,    daCenterTop,   true,    "vvd",                 false,    "",         dfNone,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      30,    daCenterTop,   true,    "ioc",                 false,    "",         dfNone,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      50,    daCenterTop,   true,    "rhq",                 false,    "",         dfNone,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,    50,    daCenterTop,   true,    "aq",                 false,    "",         dfNone,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      50,    daCenterTop,   true,    "rgn_ofc",                 false,    "",         dfNone,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      50,    daCenterTop,   true,    "ofc",                 false,    "",         dfNone,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      60,    daCenterTop,   true,    "usa_bkg_mod_cd",                 false,    "",         dfNone,   0,          false,       false); //Local/IPI(US MOD)                        
                        InitDataProperty(0, cnt++ , dtData,      50,    daCenterTop,   true,    "pod",                 false,    "",         dfNone,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,    50,    daCenter,   true,    "",                 false,    "",         dfNone,   0,          false,       false);                        
                        InitDataProperty(0, cnt++ , dtData,      60,    daCenter,   true,    "dest_loc_cd",                 false,    "",         dfNone,   0,          false,       false); //Dest
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "fcast_teu",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "fcast_d2",                 false,    "",         dfNullInteger,   0,          false,       false); //Forecast -  D2
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "fcast_d4",                 false,    "",         dfNullInteger,   0,          false,       false); //Forecast -  D4
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "fcast_hc",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "fcast_45",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "fcast_53",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "fcast_rf",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "fcast_rd",                 false,    "",         dfNullInteger,   0,          false,       false); //Forecast - RD                        
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight,   true,    "fcast_wgt",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "aloc_teu",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "aloc_d2",                 false,    "",         dfNullInteger,   0,          false,       false); //Allocation - D2
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "aloc_d4",                 false,    "",         dfNullInteger,   0,          false,       false); //Allocation - D4                                               
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "aloc_hc",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "aloc_45",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "aloc_53",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "aloc_rf",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "aloc_rd",                 false,    "",         dfNullInteger,   0,          false,       false); //Allocation - RD
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight,   true,    "aloc_wgt",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "diff_teu",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "diff_d2",                 false,    "",         dfNullInteger,   0,          false,       false); //Alloc Diff - D2
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "diff_d4",                 false,    "",         dfNullInteger,   0,          false,       false); //Alloc Diff -  D4                                                                       
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "diff_hc",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "diff_45",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "diff_53",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "diff_rf",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "diff_rd",                 false,    "",         dfNullInteger,   0,          false,       false); //Alloc Diff - RD
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight,   true,    "diff_wgt",                 false,    "",         dfNullFloat,   1,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      60,    daRight,   true,    "bkg_teu",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "bkg_t20",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "bkg_t40",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "bkg_d2",                 false,    "",         dfNullInteger,   0,          false,       false); //Booking - D2                        
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "bkg_20",                 false,    "",         dfNullInteger,   0,          false,       false); //Booking - 20(TEU)
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "bkg_d4",                 false,    "",         dfNullInteger,   0,          false,       false); //Booking - D4   
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "bkg_40",                 false,    "",         dfNullInteger,   0,          false,       false); //Booking - 40(FEU)                                                                                           
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "bkg_hc",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "bkg_45",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "bkg_53",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "bkg_r20",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "bkg_r40",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "bkg_rd20",                 false,    "",         dfNullInteger,   0,          false,       false); //Booking - RD20
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "bkg_rd40",                 false,    "",         dfNullInteger,   0,          false,       false); //Booking - RD40
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight,   true,    "bkg_wgt",                 false,    "",         dfNullFloat,   1,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight,   true,    "bkg_vol_vgm",                 false,    "",         dfNullFloat,   1,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight,   true,    "bkg_wgt_vgm",                 false,    "",         dfNullFloat,   1,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daCenter,   true,    "dis_trd",                 false,    "",         dfNone,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      45,    daCenter,   true,    "dis_sub_trd",                 false,    "",         dfNone,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      45,    daCenter,   true,    "dis_lane",                 false,    "",         dfNone,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      70,    daCenter,   true,    "dis_vvd",                 false,    "",         dfNone,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      60,    daCenter,   true,    "dis_etb_dt",                 false,    "",         dfNone,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      60,    daRight,   true,    "dis_teu",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "dis_t20",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "dis_t40",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "dis_d2",                 false,    "",         dfNullInteger,   0,          false,       false); //Booking - D2                        
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "dis_20",                 false,    "",         dfNullInteger,   0,          false,       false); //Booking - 20(TEU)
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "dis_d4",                 false,    "",         dfNullInteger,   0,          false,       false); //Booking - D4      
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "dis_40",                 false,    "",         dfNullInteger,   0,          false,       false); //Booking - 40(FEU)
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "dis_hc",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "dis_45",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "dis_53",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "dis_r20",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "dis_r40",                 false,    "",         dfNullInteger,   0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "dis_rd20",                 false,    "",         dfNullInteger,   0,          false,       false); //Booking - RD20
                        InitDataProperty(0, cnt++ , dtData,      40,    daRight,   true,    "dis_rd40",                 false,    "",         dfNullInteger,   0,          false,       false); //Booking - RD40
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight,   true,    "dis_wgt",                 false,    "",         dfNullFloat,   1,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight,   true,    "dis_vol_vgm",                 false,    "",         dfNullFloat,   1,          false,       false);
                        InitDataProperty(0, cnt++ , dtData,      50,    daRight,   true,    "dis_wgt_vgm",                 false,    "",         dfNullFloat,   1,          false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,    50,    daRight,   true,    "tree_lvl",                 false,    "",         dfNone,   0,          false,       false);

                        HeadRowHeight  = 10;
                        var backColor = RgbColor(222, 251, 248);
                        RangeBackColor(1, 13, 2, 49) = backColor;
                        backColor = RgbColor(222, 251, 248);
                        RangeBackColor(2, 13, 2, 49) = backColor;
                        
                        InitTreeInfo(83, "tree_lvl");
                   }
                    break;
                case 2:      //sheet2 init
                    break;
            }
        }
    
        function initDataSelection() {
    		viewByTpSz(document.getElementsByName("chkDs2HC")[0]);
    		viewByTpSz(document.getElementsByName("chkDs245")[0]);
    		viewByTpSz(document.getElementsByName("chkDs253")[0]);
    		viewByTpSz(document.getElementsByName("chkDs2RF")[0]);
    		viewByTpSz(document.getElementsByName("chkDs2WT")[0]);
    		
    		viewByTpSz(document.getElementsByName("chkDs2Suboffice")[0]); //20130523 추가 smk
    		
    		//2014.07.31 csy SPC Allocation Control Option 추가 보완 적용
    		viewByTpSz(document.getElementsByName("chkDs2D2")[0]); 
    		viewByTpSz(document.getElementsByName("chkDs2D4")[0]); 
    		viewByTpSz(document.getElementsByName("chkDs2RD")[0]); 
        }
        
	    function viewByTpSz(tobj){
	    	var obj = null;
	    	if (tobj == undefined || tobj == null) {
	    		tobj = null;
	    		obj = event.srcElement;
	    	} else {
	    		obj = tobj;
	    	}
	    	
	    	var sheetObj = sheetObjects[0];
	    	var sts = !obj.checked;
	    	
	    	switch (obj.name) {
	    	
	    	case "chkDs2HC":
	    		sheetObj.ColHidden("fcast_hc") = sts;
	    		sheetObj.ColHidden("aloc_hc")  = sts;
	    		sheetObj.ColHidden("diff_hc")  = sts;
	    		sheetObj.ColHidden("bkg_hc")   = sts;
	    		sheetObj.ColHidden("dis_hc")   = sts;
	    		break;
	    	
	    	case "chkDs245":
	    		sheetObj.ColHidden("fcast_45") = sts;
	    		sheetObj.ColHidden("aloc_45")  = sts;
	    		sheetObj.ColHidden("diff_45")  = sts;
	    		sheetObj.ColHidden("bkg_45")   = sts;
	    		sheetObj.ColHidden("dis_45")   = sts;
	    		break;
	    	
	    	case "chkDs253":
	    		sheetObj.ColHidden("fcast_53") = sts;
	    		sheetObj.ColHidden("aloc_53")  = sts;
	    		sheetObj.ColHidden("diff_53")  = sts;
	    		sheetObj.ColHidden("bkg_53")   = sts;
	    		sheetObj.ColHidden("dis_53")   = sts;
	    		break;
	    	
	    	case "chkDs2RF":
	    		sheetObj.ColHidden("fcast_rf") = sts;
	    		sheetObj.ColHidden("aloc_rf")  = sts;
	    		sheetObj.ColHidden("diff_rf")  = sts;
	    		sheetObj.ColHidden("bkg_53")   = sts;
	    		sheetObj.ColHidden("bkg_r20")  = sts;
	    		sheetObj.ColHidden("bkg_r40")  = sts;
	    		sheetObj.ColHidden("dis_r20")  = sts;
	    		sheetObj.ColHidden("dis_r40")  = sts;
	    		break;
	    	
	    	case "chkDs2WT":
	    		sheetObj.ColHidden("fcast_wgt") = sts;
	    		sheetObj.ColHidden("aloc_wgt")  = sts;
	    		sheetObj.ColHidden("diff_wgt")  = sts;
	    		sheetObj.ColHidden("bkg_wgt")   = sts;
	    		sheetObj.ColHidden("bkg_wgt_vgm")   = sts;
	    		sheetObj.ColHidden("dis_wgt")   = sts;
	    		sheetObj.ColHidden("dis_wgt_vgm")   = sts;
	    		break;
	    		
	    	case "chkDs2Suboffice":
	    		sheetObj.ColHidden("ofc") = sts;
	    		if(!sts){
	    			sheetObj.ShowTreeLevel(-1,2);
	    		}else{
	    			sheetObj.ShowTreeLevel(0,1);
	    		}
	    		break;	    		
	    		
	    	case "chkDs2D2" :
	    		sheetObj.ColHidden("fcast_d2") = sts;
	    		sheetObj.ColHidden("aloc_d2") = sts;
	    		sheetObj.ColHidden("diff_d2") = sts;
	    		sheetObj.ColHidden("bkg_d2") = sts;
	    		sheetObj.ColHidden("dis_d2") = sts;
	    		
	    		break;
	    		
	    	case "chkDs2D4" :
	    		sheetObj.ColHidden("fcast_d4") = sts;
	    		sheetObj.ColHidden("aloc_d4") = sts;
	    		sheetObj.ColHidden("diff_d4") = sts;
	    		sheetObj.ColHidden("bkg_d4") = sts;
	    		sheetObj.ColHidden("dis_d4") = sts;
	    		
	    		break;
	    		
	    	case "chkDs2RD" :
	    		sheetObj.ColHidden("fcast_rd") = sts;
	    		sheetObj.ColHidden("aloc_rd") = sts;
	    		sheetObj.ColHidden("diff_rd") = sts;
	    		sheetObj.ColHidden("bkg_rd20") = sts;
	    		sheetObj.ColHidden("bkg_rd40") = sts;
	    		sheetObj.ColHidden("dis_rd20") = sts;
	    		sheetObj.ColHidden("dis_rd40") = sts;
	    		
	    		break;
	    			    	
	    	}
	    }
	    
        function sheet1_OnSaveEnd(sheetObj, ErrMsg){
            log("sheet1_OnSaveEnd " + ErrMsg);
            if (ErrMsg == ""){
            }
            else{
            }
        }
        function sheet1_OnChange(sheetObj, row, col, val){
            cellChange(sheetObj, row, col, val, 7);
        }
        
        function sheet1_OnClick(sheetObj, row, col){
        	switch(sheetObj.ColSaveName(col)){
        	case "RHQCD":
        	case "OFFICECD":
        		if(sheetObj.CellValue(row, col) == "+"){
        			sheetObj.RowExpanded(row) = !sheetObj.RowExpanded(row);
        		}
        		break;
        	}
        }    
        
        function cellChange(sheetObj, row, col, val, tcol){
            var flg = (val==sheetObj.CellValue(row, col+12))?"R":"U";
            var flg_col = col+24;
            var pstat = sheetObj.CellValue(row, flg_col);
            sheetObj.CellValue2(row, flg_col) = flg;
        }
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            sheetObj.Redraw = false;
           
            switch(sAction) {

               case IBSEARCH:      //조회
    				if(!validateForm(sheetObj,formObj,sAction)){
            			sheetObj.Redraw = true;
    					return false;
    				}
//                	formObj.f_cmd.value = SEARCHLIST;
                	
                	var  param =  "sDate=" + formObj.sDate.value;
                	param = param + "&eDate=" + formObj.eDate.value;
                	param = param + "&port=" + formObj.port.value;
                	param = param + "&vvd=" + formObj.vvd.value;
                	param = param + "&org=" + formObj.org.value;
                	param = param + "&trade=" + comObjects[0].Code;
                	param = param + "&subtrade=" + comObjects[1].Code;
                	param = param + "&lane=" + comObjects[2].Code;
                	param = param + "&bound=" + formObj.bound.value;
                	param = param + "&ioc=" + formObj.ioc.value;
//                	param = param + "&chktyp=" + formObj.chkTYP.value;
//                           	
//              	var rtn =  sheetObj.DoSearch4Post("ESM_SPC_0056GS.do", FormQueryString(formObj));
             	
//                	var rtn =  sheetObj.DoSearch4Post("ESM_SPC_0056GS.do","f_cmd=" + (SEARCHLIST)+"&"+param);
                	
                	var rtn =  sheetObj.GetSearchXml("ESM_SPC_0056GS.do","f_cmd=" + (SEARCHLIST)+"&"+param);
                    
                	var etcData = getEtcData(rtn);
                	
                	sheetObj.LoadSearchXml(rtn);
                	
                	var ctrlopt = etcData["ctrlopt"].split("|");
                	
            		ctrlopt[1] == "true" ? formObj.chkDs2HC.checked = true : formObj.chkDs2HC.checked = false;
            		ctrlopt[2] == "true" ? formObj.chkDs245.checked = true : formObj.chkDs245.checked = false;
            		ctrlopt[3] == "true" ? formObj.chkDs253.checked = true : formObj.chkDs253.checked = false;
            		ctrlopt[4] == "true" ? formObj.chkDs2RF.checked = true : formObj.chkDs2RF.checked = false;
            		ctrlopt[5] == "true" ? formObj.chkDs2WT.checked = true : formObj.chkDs2WT.checked = false;
            		
            		//2014.07.31 csy SPC Allocation Control Option 추가 보완 적용
            		ctrlopt[6] == "true" ? formObj.chkDs2D2.checked = true : formObj.chkDs2D2.checked = false;
            		ctrlopt[7] == "true" ? formObj.chkDs2D4.checked = true : formObj.chkDs2D4.checked = false;
            		ctrlopt[8] == "true" ? formObj.chkDs2RD.checked = true : formObj.chkDs2RD.checked = false;
           		
                	initDataSelection();
                    break;
               case IBDOWNEXCEL:        //엑셀 다운로드
                  	sheetObj.Down2Excel(-1, false, false, true);
                  	break;             
              case IBCLEAR:        //초기화 
    				resetAll();
    				setInitDate();
                  	break;               
            }
            sheetObj.Redraw = true;
        }
    /* 조회된 데이터의 수정 가능여부 체크 */
        function setEditable(sheetObj){
            var rows = sheetObj.RowCount;
            var scol = 6;
            if(sheetObj.id == "sheet2"){
                scol = scol + 2;
            }
            var val = "";
            for(var i = 0 ; i < rows ; i++){
                for(var m = 0 ; m < 12 ; m++){
                    val = sheetObj.CellValue(i+2, m + scol + 12);
                    if(val==""){
                        sheetObj.CellEditable(i+2, m + scol) = false;
                    }
                    else{
                        sheetObj.CellEditable(i+2, m + scol) = true;
                    }
                }
            }
        }

       /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
    		with(formObj){
        		switch(sAction) {
        			case IBSEARCH:      //조회

    			        if(formObj.port.value == ""){
    			            ComShowMessage(getMsg("SPC90114", "Port"));
    			            formObj.port.focus();
    			            return false;
    			        }
    			        if(formObj.port.value.length < 5){
    			        	ComShowCodeMessage("COM12174", "Port", 5);
    			            formObj.port.focus();
    			            return false;
    			        }
    			        if( formObj.vvd.value == "" ){    			
        			        if(formObj.sDate.value == ""){
        			            ComShowMessage(getMsg("SPC90114", "Start Date"));
        			            formObj.sDate.focus();
        			            return false;
        			        }
        			        if(formObj.eDate.value == ""){
        			            ComShowMessage(getMsg("SPC90114", "End Date"));
        			            formObj.eDate.focus();
        			            return false;
        			        }
        					// 
        					var fDt = document.form.sDate.value.split("-").join("");
        					var tDt = document.form.eDate.value.split("-").join("");
        					
        					if ( SpcGetDateIntervals(fDt, tDt, "D") > 90 ) {
        						ComShowCodeMessage("COM12114", "Limit 3 Month");
        						formObj.eDate.focus();
        						return false;
        					}
        					
        			        if(comObjects[0].Code == ""){
        			            ComShowMessage(getMsg("SPC90114", "Trade"));
        			            comObjects[0].focus();
        			            return false;
        			        }
    			        }else if (formObj.vvd.value.length < 9){
    			        	ComShowCodeMessage("COM12174", "VVD", "9");
    			            formObj.vvd.focus();
    			            return false;
    			        }
    			            


        				break;
        			case IBDOWNEXCEL:        //엑셀 다운로드
        				break;
        		}
    		}
    		return true;
        }
        
        function callbackPopupPortCd(rowArray){
            var colArray = rowArray[0];	
            var val = colArray[3];
        	document.all.port.value = val;
        }     

    function trade_OnChange(comObj,value,text ){
//    	if(text == '|ALL'){	optionAllReset("trade",value,"true");   return;} // 0207 SHKIM
//    	if(value == "") return;
    	//sub_trade의 초기화
    	comObjects[1].Index2 = 0;     
    	//lane의 초기화
    	comObjects[2].Index2 = 0;        
    	SpcSearchOptionSubTrade("subtrade",true,true,"","",value);			// 0207 SHKIM
		SpcSearchOptionLane("lane",true,false,'',value,'',true);	// 0207 SHKIM
    }   

    function subtrade_OnChange(comObj,value,text ){
//    	if(text == '||ALL'){   
//    		// 사용안함. 직접 optionAllReset("subtrade",document.form.trade.Code,"true"); 
//    		SpcSearchOptionSubTrade("subtrade",true,true,"","",document.form.trade.Code);			// 0207 SHKIM   			
//	    	SpcSearchOptionLane("lane",true,false,'',document.form.trade.Code,'',true);	// 0207 SHKIM   
//    		return; 
//    	} // 0207 SHKIM    	
    	SpcSearchOptionLane("lane",true,false,'',document.form.trade.Code,value,true);	// 0207 SHKIM
    	if(value == "") return;
     	var arrTrade = text.split("|");
    	if(arrTrade.length > 1) {
    		comObjects[0].Code2 = arrTrade[0];
    	} else {
    		comObjects[0].Code2 = comObj.GetText(value,0);  
    	}     	    
	    //lane value change
	    comObjects[2].Index2 = 0;         
    } 

    function lane_OnChange(comObj,value,text ){
    	if(value == "" ) return;
    	var repTrade = comObj.GetText(value,0);  
    	var subTrade = comObj.GetText(value,1);
    	comObjects[0].Code2 = repTrade;
    	comObjects[1].Code2 = subTrade;
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
     
     function checkDate_0056(){
    	 if(!ComIsDate(event.srcElement)){
    		 ComShowCodeMessage("COM12179");
    		 event.srcElement.value="";
    	 }
     }
     
	/* 개발자 작업  끝 */