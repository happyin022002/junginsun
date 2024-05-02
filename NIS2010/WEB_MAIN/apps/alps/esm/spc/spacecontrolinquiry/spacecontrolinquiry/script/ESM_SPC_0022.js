/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0022.js
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
* 2008-04-11  서관영
* CSR:N200803195497 - Split 01-T/S allocation 관련 SPC 화면 수정
* 상단 Allocation T/S VOL 추가
* 하단  By Office TAB OCN/IPC/TS 구분 컬럼 추가
* 하단  Customer tab을 2개로 구분, By shipper & By contractor
* 2008-11-17 임옥영/서관영 CSR:N200811140005/N200811130019 
* - 단축키 추가(ESM_SPC_022, 024, 028, 056, 070)
* 2008-12-16 임옥영 CSR:N200812080003 Total TEU 컬럼 추가(TEU+ HC*2 + 45FT*2)
* 2008-12-26 임옥영 CSR:N200812230019 BKG의 TEU->Total TEU로 변경
*@LastModifyDate : 2009.10.06
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.10.06 한상훈
* 1.0 Creation
=========================================================
* History
* 2010.06.22 Lee Sang-Yong : 프로젝트 CHM-201004171  53ft(DW,DX) 추가
* 2011.05.19 최성민 [CHM-201110711-01] Inquiry by Trade 화면 보완
* - TAGLIB를 MULTICOMBO로 변경 작업
* - RHQ에 SHARC,SINRS를 1ROW로 추가
* - DEL radio box 추가
* 2011.07.05 [CHM-201111880-01] 김종준 control by HO 화면 보완 - IPC, TS 관련
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
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
     * @class ESM_SPC_0022 : ESM_SPC_0022 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0022() {
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
    var comboObjects = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 0;
    var save_lane;		//double click했을때 선택한 lane
    var save_bound;		//double click했을때 선택한 bound
    var save_vvd;		//double click했을때 선택한 vvd
    var save_ocn_ipc;   //double click했을때 선택한 ocn_ipc
    var save_trade;		//double click했을때 선택한 trade
    var save_subtrade	//double click했을때 선택한 subtrade
    
    var headWeek = "";	//Weekly CMB 4주차를 위한 Hearder
    
    var pop_yrwk;	//double click했을때 선택한 YRWK

    //var sheetResizeFull = true;
    var sheetResizeCount = 2;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         /*******************************************************/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         var sheetObject2 = sheetObjects[2];
         var sheetObject3 = sheetObjects[3];
         var sheetObject4 = sheetObjects[4];

         var formObject = document.form;

//        	try {
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
					
	            	//화면을 초기화
					SpcResetAll();
					
					SpcSearchOptionTrade("trade", true, true);
					SpcSearchOptionSubTrade("subtrade");
					SpcSearchOptionLane("lane",true,true); // 0207 SHKIM 
					break;

				case "btn_downexcel":
					if(beforetab==0){
    	            	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    	            }else if(beforetab==1){
    	            	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
    	            }else if(beforetab==2){
    	            	doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
    	            }else if(beforetab==3){
    	            	doActionIBSheet(sheetObject3,formObject,IBDOWNEXCEL);
    	             }else if(beforetab==4){
    	            	doActionIBSheet(sheetObject4,formObject,IBDOWNEXCEL);
    	            }
					break;
					
				case "btng_season_grp":
					yieldGrpPopup();
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

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;

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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
    }
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

    	headWeek = "WK1|WK2|WK3|WK4|WK1|WK2|WK3|WK4"; //weekly cmb 초기화
    	
        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i]);
        	if(i > 0){
            	tdisp = tabLayer[i-1].style.display;
            	tabLayer[i-1].style.display = "block";
        	}
            initSheet(sheetObjects[i],i+1);
        	if(i > 0){
				tabLayer[i-1].style.display = tdisp;
			}
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        var sheetResizeFull = true;
		document_onresize();
		
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        
        //////////////////////////////////////////////////////
		//콤보데이터를 초기화 세팅한다.
		//initCombo 호출보다 우선순위 호출되어야함.(디폴트 세팅값때문에)
       	initComboData();

	    //IBMultiCombo초기화
	    for(var k = 0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
        /////////////////////////////////////////////////////
        
	    var obj1 = eval(sheetObjects[1].document.form.weight1);
        var obj2 = eval(sheetObjects[1].document.form.type1);
        var obj3 = eval(sheetObjects[1].document.form.cmb1);
        changeTitle1('1', obj1);
        changeTitle2('1', obj2);
        changeTitle3('1', obj3);
        ComBtnDisable("btng_season_grp");
        
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
                    style.height = getSheetHeight(7);
                    //전체 너비 설정
                    SheetWidth = mainTable1.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                    FocusEditMode = default_edit_mode;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 3, 1, 5, 100);

                    var HeadTitle1 = "SEQ|Trade|Sub\nTrade|Lane|Bound|Week|VVD|OCN/\nIPC|BSA|Loadable|Load QTA|Load QTA|Forecast|Forecast|Forecast|Forecast|L/F\n(%)|L/F\n(%)|Alloc|Alloc|Alloc|Alloc|Booking|Booking|Booking|Booking|Booking VGM|Booking VGM|Booking VGM|Booking VGM";
                    var HeadTitle2 = "SEQ|Trade|Sub\nTrade|Lane|Bound|Week|VVD|OCN/\nIPC|BSA|Loadable|VOL|CMB|VOL|WGT|T/S|T/S|TEU\n(F'cast)|WGT\n(BKG)|VOL|WGT|T/S|T/S|Total|WGT|T/S|T/S|VOL|WGT|T/S|T/S";
                    var HeadTitle3 = "SEQ|Trade|Sub\nTrade|Lane|Bound|Week|VVD|OCN/\nIPC|BSA|Loadable|VOL|CMB|VOL|WGT|VOL|WGT|TEU\n(F'cast)|WGT\n(BKG)|VOL|WGT|VOL|WGT|Total|WGT|VOL|WGT|VOL|WGT|VOL|WGT";

                    var headCount = ComCountHeadTitle(HeadTitle3);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 10, 0, true);
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, false, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    InitHeadRow(2, HeadTitle3, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtDataSeq,   30,    daCenter,  true,     "",     false,          "",   dfNone,      0,     		true,       true);
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,     "TRADE",     false,          "",   dfNone,      0,     		true,       true);
                    InitDataProperty(0, cnt++ , dtData,      45,    daCenter,  true,     "SUBTRADE",     false,          "",   dfNone,      0,     		true,       true);
                    InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  true,     "LANE", false,          "",   dfNone,      0,     		true,       true);
                    InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  true,     "BOUND",false,          "",   dfNone,      0,     		true,       true);

                    InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  true,     "WEEK",     false,          "",   dfNone,      0,     		true,       true);
                    InitDataProperty(0, cnt++ , dtData,      90,    daCenter,  true,     "VVD",  false,          "",   dfNone,      0,     		true,       true);
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,  	 "OCN_IPC", false,          "",   dfNone,      0,     		true,       true);
                    InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "BSA",     false,          "",   dfInteger,   0,     		true,       true);
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  true,     "LOAD",     false,          "",   dfInteger,   0,     		true,       true);
                    
                    InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "QTA_VOL",     false,          "",   dfInteger,   0,     		true,       true);
                    InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "QTA_CMB",     false,          "",   dfInteger,   0,     		true,       true);
                    InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "FCAST_VOL",     false,          "",   dfInteger,   0,     		true,       true);
                    InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "FCAST_WGT",     false,          "",   dfInteger,     0,     		true,       true);
                    InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "FCAST_TC_WGT",     false,          "",   dfInteger,     0,     		true,       true);
                    InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "FCAST_TC_WGT",     false,          "",   dfInteger,     0,     		true,       true);
                    InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,      "LF",     false,          "|FCAST_VOL|/|BSA|*100",   dfFloat,   1,     		true,       true);
                    InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,      "WGT_LF",     false,          "",   dfFloat,   1,     		true,       true);
                    
                    InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "",     false,          "",   dfNullInteger,   0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "",     false,          "",   dfNullInteger,     0,     		true,       true);
                    InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "",     false,          "",   dfNullInteger,     0,     		true,       true);
                    InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "",     false,          "",   dfNullInteger,     0,     		true,       true);
                    InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "",     false,          "",   dfInteger,   0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "",     false,          "",   dfInteger,     0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "",     false,          "",   dfInteger,     0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "",     false,          "",   dfInteger,     0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "",     false,          "",   dfInteger,     0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "",     false,          "",   dfInteger,     0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "",     false,          "",   dfInteger,     0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "",     false,          "",   dfInteger,     0,     		true,       true);
                 //   InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  true,     "",     false,          "",   dfNone,      0,     		true,       true);
                    
                    RangeBackColor(1,10, 2,15) = RgbColor(203, 210, 248);//RgbColor(222, 251, 248);
                    RangeBackColor(1,17, 2,24) = RgbColor(203, 210, 248);//RgbColor(222, 251, 248);
                    
                    HeadRowHeight = 10;
                    CountPosition = 0;
               }
                break;
            case 2:     //By Office
                with (sheetObj) {
                    // 높이 설정
                    style.height = getSheetHeight(8);
                    //전체 너비 설정
                    SheetWidth = mainTable[0].clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                    FocusEditMode = default_edit_mode;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 3, 1, 5, 100);

                    var HeadTitle1 = "OCN\nIPC\nTS|Area/RHQ|Yield\nGroup|Load\nQuota|Guide|Local/IPI|Account|Account|OFC\nCMB\nTEU|OFC\nCMB\nWGT|" +
                            "Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|" +
                            "Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|" +
                    		"Allocation|Allocation|Allocation|Allocation|Allocation|Allocation|Allocation|Allocation|Allocation|" +
                    		"Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Booking VGM|Booking VGM|ctrl_flg|";
                    var HeadTitle2 = "OCN\nIPC\nTS|Area/RHQ|Yield\nGroup|Load\nQuota|Guide|Local/IPI|CODE|NAME|OFC\nCMB\nTEU|OFC\nCMB\nWGT|" + 
                            "TEU|TEU|TEU|TEU|WGT|WGT|WGT|WGT|" + 
                    		"Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Weight|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Weight|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Weight|Volume|Weight|ctrl_flg|";
                    var HeadTitle3 = "OCN\nIPC\nTS|Area/RHQ|Yield\nGroup|Load\nQuota|Guide|Local/IPI|CODE|NAME|OFC\nCMB\nTEU|OFC\nCMB\nWGT|" +
                            headWeek + "|" +
                            "Total TEU|TEU|D2|D4|HC|45'|53'|Reefer|RD|Weight|TEU|D2|D4|HC|45'|53'|Reefer|RD|Weight|Total TEU|D2|20'|D4|40'|HC|45'|53'|Reefer|RD|Weight|Volume|Weight|ctrl_flg|";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 8, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false) ;

					
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    InitHeadRow(2, HeadTitle3, false);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,      30,    daCenterTop,  true,  "",     		false,          "",   dfNone,      		0,     	true,       true);
                    InitDataProperty(0, cnt++ , dtData,      75,    daCenter,  true,     "",     		false,          "",   dfNone,      		0,     	true,       true);
                    InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  true,     "cust_ctrl_cd",false,          "",   dfNone,      		0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      55,    daRight,   true,     "qta",         false,          "",   dfNullInteger,  	0,      true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "smp",    		false,          "",   dfNullInteger,  	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      60,    daCenter , true,     "usa_bkg_mod_cd",false,        "",   dfNone,      		0,     	true,       true);	//Local/IPI
					InitDataProperty(0, cnt++ , dtHidden,      60,    daCenter , true,     "cust_acct",   false,          "",   dfNone,      		0,     	true,       true);	//Account
					InitDataProperty(0, cnt++ , dtHidden,      80,    daCenter , true,     "cust_lgl_eng_nm",false,       "",   dfNone,      		0,     	true,       true);	//Account Name
					
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "cmb",    		false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "cmb_wgt",		false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",		false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",		false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",		false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",    	false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk", 	false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk",	false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk",	false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk",  false,          "",   dfInteger,      	0,     	true,       true);
					
					//fcast_ttl_teu_qty
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "fcast_ttl_teu_qty",false,     "",   dfInteger,      	0,   	true,       true);
					InitDataProperty(0, cnt++ , dtData,      60,    daRight ,  true,     "vol_teu",    false,          	"",   dfInteger,      	0,    	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d2",     false,          	"",   dfInteger,      	0,     	true,       true);	//Forecase-D2
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d4",     false,          	"",   dfInteger,      	0,     	true,       true);	//Forecase-D4
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d5",     false,          	"",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d7",     false,          	"",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_53",     false,          	"",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "vol_rf",     false,          	"",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_rd",     false,          	"",   dfInteger,      	0,     	true,       true);	//Forecase-RD					
					InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "wgt_ttl",    false,          	"",   dfInteger,      	0,     	true,       true);
					
					InitDataProperty(0, cnt++ , dtData,      60,    daRight ,  true,     "vol_teu",    false,          	"",   dfNullInteger,    0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d2",     false,          	"",   dfNullInteger,    0,     	true,       true);	//Allocation-D2
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d4",     false,          	"",   dfNullInteger,    0,     	true,       true);	//Allocation-D4
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d5",     false,          	"",   dfNullInteger,    0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d7",     false,          	"",   dfNullInteger,    0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_53",     false,          	"",   dfNullInteger,    0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "vol_rf",     false,          	"",   dfNullInteger,    0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_rd",     false,          	"",   dfNullInteger,    0,     	true,       true);	//Allocation-RD					
					InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "wgt_ttl",    false,          	"",   dfNullInteger,    0,     	true,       true);
										
					InitDataProperty(0, cnt++ , dtData,      60,    daRight ,  true,     "vol_teu",    false,          	"",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d2",    false,           	"",   dfInteger,      	0,     	true,       true);	//Total Booking-D2	
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d2",     false,          	"",   dfInteger,      	0,     	true,       true);	//Total Booking-20 TEU
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d4",    false,           	"",   dfInteger,      	0,     	true,       true);	//Total Booking-D4				
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d4",     false,          	"",   dfInteger,      	0,     	true,       true);	//Total Booking-40 FEU					
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d5",     false,          	"",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d7",     false,          	"",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_53",     false,          	"",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "vol_rf",     false,          	"",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_rd",     false,          	"",   dfInteger,      	0,     	true,       true);	//Total Booking-RD					
					InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "wgt_ttl",    false,          	"",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "bkg_vol_vgm",    false,          	"",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "bkg_wgt_vgm",    false,          	"",   dfInteger,      	0,     	true,       true);

					InitDataProperty(0, cnt++ , dtHidden,     1,    daCenter,  true,     "ctrl_flg",    false,         	"",   dfNone,      	 	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,       1,    daCenter,  true,     "",     		false,         	"",   dfNone,      	 	0,     	true,       true);
					
                    RangeBackColor(1, 6, 2, 47) = RgbColor(203, 210, 248);
                    
                    HeadRowHeight = 10;
              }
                break;
             
              case 3:     //By POL/POD
                with (sheetObj) {
                    // 높이 설정
                    style.height = getSheetHeight(8);
                    //전체 너비 설정
                    SheetWidth = mainTable[1].clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                    FocusEditMode = default_edit_mode;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 3, 1, 5, 100);

                    var HeadTitle1 = "SEQ|Local/IPI|POL|Dest|RHQ|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|" +
                            "Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|" +
                    		"Allocation|Allocation|Allocation|Allocation|Allocation|Allocation|Allocation|Allocation|Allocation|" +
                    		"Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Booking VGM|Booking VGM|";
                    var HeadTitle2 = "SEQ|Local/IPI|POL|Dest|RHQ|TEU|TEU|TEU|TEU|WGT|WGT|WGT|WGT|" +
                    		"Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Weight|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Weight|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Weight|Volume|Weight|";
                    var HeadTitle3 = "SEQ|Local/IPI|POL|Dest|RHQ|" + headWeek + "|" +
                    		"Total TUE|TEU|D2|D4|HC|45'|53'|Reefer|RD|Weight|TEU|D2|D4|HC|45'|53'|Reefer|RD|Weight|Total TEU|D2|20'|D4|40'|HC|45'|53'|Reefer|RD|Weight|Volume|Weight||";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 5, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false) ;

					
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    InitHeadRow(2, HeadTitle3, false); 
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtDataSeq,   30,    daCenter,  true,     "",     		false,          "",   dfNone,      		0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      60,    daCenter ,  true,     "usa_bkg_mod_cd",false, 		"",   dfNone,      		0,     	true,       true);	//Local/IPI
                    InitDataProperty(0, cnt++ , dtData,      75,    daCenter,  true,     "",     false,          		"",   dfNone,      		0,     	true,       true);
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter ,  true,     "dest_loc_cd",false, 	 		"",   dfNone,      		0,     	true,       true);	//Dest
                    InitDataProperty(0, cnt++ , dtData,      55,    daCenter,  true,     "",     		false,          "",   dfNone,      		0,     	true,       true);
					
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",		false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",		false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",		false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",    	false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk", 	false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk",	false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk",	false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk",  false,          "",   dfInteger,     	0,     	true,       true);
					
					//fcast_ttl_teu_qty
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "fcast_ttl_teu_qty",false,     "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_teu",    	false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d2",     	false,          "",   dfInteger,      	0,     	true,       true);	//Forecase-D2
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d4",     	false,          "",   dfInteger,      	0,     	true,       true);	//Forecase-D4					
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d5",     	false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d7",     	false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_53",     	false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "vol_rf",     	false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_rd",     	false,          "",   dfInteger,      	0,     	true,       true);	//Forecase-RD						
					InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "wgt_ttl",     false,          "",   dfInteger,     	0,     	true,       true);

					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_teu",    	false,          "",   dfNullInteger,    0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d2",     	false,          "",   dfNullInteger,    0,     	true,       true);	//Allocation-D2
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d4",     	false,          "",   dfNullInteger,    0,     	true,       true);	//Allocation-D4					
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d5",     	false,          "",   dfNullInteger,    0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d7",     	false,          "",   dfNullInteger,    0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_53",     	false,          "",   dfNullInteger,    0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "vol_rf",     	false,          "",   dfNullInteger,    0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_rd",     	false,          "",   dfNullInteger,    0,     	true,       true);	//Allocation-RD						
					InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "wgt_ttl",     false,          "",   dfNullInteger,    0,     	true,       true);
					
					InitDataProperty(0, cnt++ , dtData,      60,    daRight ,  true,     "vol_teu",    	false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d2",    	false,          "",   dfInteger,      	0,     	true,       true);	//Total Booking-D2
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d2",     	false,          "",   dfInteger,      	0,     	true,       true);	//Total Booking-20 TEU
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d4",    	false,          "",   dfInteger,      	0,     	true,       true);	//Total Booking-D4					
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d4",     	false,          "",   dfInteger,     	0,     	true,       true);	//Total Booking-40 FEU				
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d5",     	false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d7",     	false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_53",     	false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "vol_rf",     	false,          "",   dfInteger,      	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_rd",     	false,          "",   dfInteger,      	0,     	true,       true);	//Total Booking-RD						
					InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "wgt_ttl",     false,          "",   dfInteger,     	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "bkg_vol_vgm",     false,          "",   dfInteger,     	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "bkg_wgt_vgm",     false,          "",   dfInteger,     	0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      1,    daCenter,  true,       "",     		false,          "",   dfNone,     		0,     	true,       true);
					
                    RangeBackColor(1, 5, 2, 42) = RgbColor(203, 210, 248);
					
                    HeadRowHeight = 10;
              }
                break;  
              
             case 4:     //By Customer
                with (sheetObj) {
                    // 높이 설정
                    style.height = getSheetHeight(8);
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

                    var HeadTitle1 = "SEQ|Customer\nCode|Customer\nName|Customer\nType|Yield\nGroup|Guide\nVol|"
                        + "Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|"
                        + "PORT|RHQ|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Total Booking|Total Booking|Total Booking|Total Booking|" 
                        + "Total Booking|Total Booking|Total Booking|Total Booking|Booking VGM|Booking VGM|";

                    var HeadTitle2 = "SEQ|Customer\nCode|Customer\nName|Customer\nType|Yield\nGroup|Guide\nVol|" 
                    	+ "TEU|TEU|TEU|TEU|WGT|WGT|WGT|WGT|"
                        + "PORT|RHQ|Vol|Vol|Vol|Vol|Vol|Vol|Weight\n(Ton)"
                        + "|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight\n(Ton)|Vol|Weight\n(Ton)|";

                    var HeadTitle3 = "SEQ|Customer\nCode|Customer\nName|Customer\nType|Yield\nGroup|Guide\nVol|"
                    	+ headWeek + "|"
                        + "PORT|RHQ|Total TEU|TEU|HC|45'|53'|Reefer|Weight\n(Ton)|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight\n(Ton)|Vol|Weight\n(Ton)|";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 6, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false) ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    InitHeadRow(2, HeadTitle3, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtDataSeq,   30,    daCenter,  true,     "seq",     false,          "",   dfNone,      0,     		true,       true);
                    InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  true,     "cust_cd",     false,          "",   dfNone,      0,     		true,       true);
                    InitDataProperty(0, cnt++ , dtData,      250,   daLeft,    true,     "cust_nm",     false,          "",   dfNone,      0,     		true,       true);
                    
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
                    
                    
                    
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,     "pol",     false,          "",   dfNone,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,     "rhq",     false,          "",   dfNone,      0,     		true,       true);
                    
                    //fcast_ttl_teu_qty
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "fcast_ttl_teu_qty",    false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_teu",    false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d5",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d7",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_53",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "vol_rf",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "wgt_ttl",     false,          "",   dfInteger,      0,     		true,       true);
					
					InitDataProperty(0, cnt++ , dtData,      60,    daRight ,  true,     "vol_teu",    false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d2",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d4",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d5",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d7",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_53",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "vol_rf",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "wgt_ttl",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "bkg_vol_vgm",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "bkg_wgt_vgm",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      1,    daCenter,  true,     "",     false,          "",   dfNone,      0,     		true,       true);
					
                    RangeBackColor(1,6, 2,13) = RgbColor(203, 210, 248);
                    RangeBackColor(1,16, 2,31) = RgbColor(203, 210, 248);
                    HeadRowHeight = 10;
                    CountPosition = 0;
              }
                break;  
                
             case 5:     //t5sheet1 init //By Shipper
                with (sheetObj) {
                    // 높이 설정
                    style.height = getSheetHeight(8);
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

                     var HeadTitle1 = "SEQ|Customer\nCode|Customer\nName|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|" 
                     + "PORT|RHQ|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Total Booking|Total Booking|Total Booking|Total Booking|" 
                     + "Total Booking|Total Booking|Total Booking|Total Booking|Booking VGM|Booking VGM|";

                    var HeadTitle2 = "SEQ|Customer\nCode|Customer\nName|TEU|TEU|TEU|TEU|WGT|WGT|WGT|WGT|" 
                     + "PORT|RHQ|Vol|Vol|Vol|Vol|Vol|Vol|Weight\n(Ton)"
                     + "|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight\n(Ton)|Vol|Weight\n(Ton)|";

                    var HeadTitle3 = "SEQ|Customer\nCode|Customer\nName|" + headWeek + "|PORT|RHQ|Total TEU|TEU|HC|45'|53'|Reefer|Weight\n(Ton)"
                     + "|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight\n(Ton)|Vol|Weight\n(Ton)|";
					
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 3, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false) ;

                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    InitHeadRow(2, HeadTitle3, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtDataSeq,   30,    daCenter,  true,     "seq",     false,          "",   dfNone,      0,     		true,       true);
                    InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  true,     "cust_cd",     false,          "",   dfNone,      0,     		true,       true);
                    InitDataProperty(0, cnt++ , dtData,      250,   daLeft,    true,     "cust_nm",     false,          "",   dfNone,      0,     		true,       true);
                    
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",		false,          "",   dfNullInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",		false,          "",   dfNullInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",		false,          "",   dfNullInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wk",    	false,          "",   dfNullInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk", 	false,          "",   dfNullInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk",	false,          "",   dfNullInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk",	false,          "",   dfNullInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "cmb_wgt_wk",  false,          "",   dfNullInteger,      0,     		true,       true);
					
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,     "pol",     false,          "",   dfNone,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,     "rhq",     false,          "",   dfNone,      0,     		true,       true);
					//fcast_ttl_teu_qty
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "fcast_ttl_teu_qty",    false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_teu",    false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d5",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d7",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_53",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "vol_rf",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "wgt_ttl",     false,          "",   dfInteger,      0,     		true,       true);
					
					InitDataProperty(0, cnt++ , dtData,      60,    daRight ,  true,     "vol_teu",    false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d2",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d4",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d5",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_d7",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daRight ,  true,     "vol_53",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      50,    daRight ,  true,     "vol_rf",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "wgt_ttl",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "bkg_vol_vgm",     false,          "",   dfInteger,      0,     		true,       true);
					InitDataProperty(0, cnt++ , dtData,      55,    daRight ,  true,     "bkg_wgt_vgm",     false,          "",   dfInteger,      0,     		true,       true);					
					InitDataProperty(0, cnt++ , dtData,      1,    daCenter,  true,     "",     false,          "",   dfNone,      0,     		true,       true);
					
                    RangeBackColor(1,5, 2,31) = RgbColor(203, 210, 248);
                    HeadRowHeight = 10;
                    CountPosition = 0;
              }
                break;     
        }
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
                    InsertTab( cnt++ , "By POL / POD" , -1 );
                    InsertTab( cnt++ , "By Customer" , -1 );
                    InsertTab( cnt++ , "By Shipper " , -1 );
                    
                } 
             break;

         }
    }

    /**
     * IBCOMBO를 초기화하는 function <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} comboObj 필수 IBMultiCombo Object
     * @param {int} comboNo 필수 IBMultiCombo의 순번
     * @return 없음
     * @author 최성민
     * @version 2011.05.17
     */ 
 	function initCombo(comboObj, comboNo) {
 		var formObj = document.form;
 		with(comboObj) {
			var strId = comboObj.id;
			
		    switch(strId) {		       
		        case "year1":
	         		DropHeight = 260;
	         		MaxLength = 4;
	            	ValidChar(2, 1);
	         		Code2 = formObj.t_year.value;
		            break; 
		            
		        case "year2":
	         		DropHeight = 260;
	         		MaxLength = 4;
	            	ValidChar(2, 1);
	         		Code2 = formObj.t_year.value;
		            break;   
		            
		        case "week1":
	         		DropHeight = 260;
	         		MaxLength = 2;
	            	ValidChar(2, 1);
	         		Code2 = formObj.t_week.value;
		            break;  
		            
		        case "week2":
	         		DropHeight = 260;
	         		MaxLength = 2;
	            	ValidChar(2, 1);
	         		Code2 = formObj.t_week.value;
		            break;

		        case "rhq_txt":
	            	InsertItem(0,"SHARC,SINRS"); 
	            	Code2 = formObj.t_ofc_cd.value;
	            	Enable = formObj.t_enable.value;
		            break; 
		            
		        case "trade":
	         		DropHeight = 260;
	            	SetTitle("Trade|Description");
	            	SetColWidth("50|200");     	
	            	InsertItem(0,"|ALL",'');
	            	MaxLength = 3;
	            	ValidChar(2, 0);
		            Index2 = 0;
		            break;   

		        case "subtrade":
            		DropHeight = 260;
	            	SetTitle("Trade|SubTrade|Description");
	            	SetColWidth("50|60|150");     	
	            	InsertItem(0,"||ALL",''); 
	            	MaxLength = 2;
	            	ValidChar(2, 0); 
		            Index2 = 0;		           
		            break;
		            
		        case "lane":
            		DropHeight = 260;
	            	SetTitle("Trade|SubTrade|Rev.Lane|Description");
	            	SetColWidth("50|60|60|250"); 
	            	MaxLength = 5;
	            	ValidChar(2, 1);	//영문대문자+숫자   	
	            	InsertItem(0,"|||ALL",'');
	            	Index2 = 0;
		            break; 
		            
		        case "bound":
            		DropHeight = 260;
	            	MaxLength = 1;
	            	ValidChar(2, 0);
	            	InsertItem(0,"","");
	            	Index2 = 0;
		            break; 
		            
		        case "onc_ipc":
            		DropHeight = 260;
	            	MaxLength = 1;
	            	ValidChar(2, 0);
	            	InsertItem(0,"","");
	            	Index2 = 0;
		            break; 
		            
		    }
 		}
 	}    	
 	
    //Sheet1관련 프로세스 처리
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
                	
				formObj.f_cmd.value = SEARCHLIST01;		
				/*sheetObjects[1].form.vvd1.value="";
				sheetObjects[2].form.vvd2.value="";
				sheetObjects[3].form.vvd3.value="";
				sheetObjects[4].form.vvd4.value="";*/		
				formObj.vvd1.value="";
				formObj.vvd2.value="";
				formObj.vvd3.value="";
				formObj.vvd4.value="";		
				
				var param = SpcFormString(formObj,'year1,week1,year2,week2,rhq_txt,only_vvd,trade,subtrade,lane,bound,onc_ipc,vvd1,rhq_gso1,weight1,vvd2,rhq_gso2,pol_pod2,weight2,vvd3,rhq_gso3,pol_pod3,weight3,vvd4,rhq_gso4,pol_pod4,weight4');
//				sheetObj.DoSearch4Post("ESM_SPC_0022GS.do", FormQueryString(formObj));
				sheetObj.DoSearch4Post("ESM_SPC_0022GS.do","f_cmd="+ SEARCHLIST01 +"&"+ param);

				break;

           case IBDOWNEXCEL:        //엑셀 다운로드
              	sheetObj.SpeedDown2Excel(-1);
             	break;
        }
    }
 	
 	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj , nItem)
	{
//    		var objs = document.all.item("tabLayer");
//    		objs[0].style.display = "none";
//    		objs[1].style.display = "none";
//    		objs[2].style.display = "none";
//    		objs[3].style.display = "none";
//    		objs[nItem].style.display = "Inline";
       
       var objs = document.all.item("tabLayer");
		for(var i = 0 ; i < objs.length ; i++){
			objs[i].style.display = "none";
		}
		objs[nItem].style.display = "Inline";
		beforetab = nItem;
       
		if(save_vvd==null){
    		save_vvd = "";
    	}
		

		if(nItem==0){			
			beforetab = 1;
			//체크박스 선택시 필드보여주기
			var obj = eval(sheetObjects[1].form.type1);
			var obj1 = eval(sheetObjects[1].form.cmb1);
        	changeTitle2('1', obj);
        	changeTitle3('1', obj1);
		}
		else if(nItem==1){
			beforetab = 2;

			//체크박스 선택시 필드보여주기
			var obj = eval(sheetObjects[2].form.type2);
			var obj1 = eval(sheetObjects[2].form.cmb2);
        	changeTitle2('2', obj);
        	changeTitle3('2', obj1);
		}
		else if(nItem==2){
			beforetab = 3;

			//체크박스 선택시 필드보여주기
			var obj = eval(sheetObjects[3].form.type3);
			var obj1 = eval(sheetObjects[3].form.cmb3);
        	changeTitle2('3', obj);
        	changeTitle3('3', obj1);
		}
		else if(nItem==3){
			beforetab = 4;

			//체크박스 선택시 필드보여주기
			var obj = eval(sheetObjects[4].form.type4);
			var obj1 = eval(sheetObjects[4].form.cmb4);
        	changeTitle2('4', obj);
        	changeTitle3('4', obj1);
		}
	   
	}

 	/*
 	 * sheet1클릭시 탭화면 조회
 	 */
 	function sheet1_OnDblClick(sheetObj, row, col)
    {
    	var sheetObj = sheetObjects[0];
    	var sheetObj1 = sheetObjects[beforetab + 1];

    	var formObj = document.form;

		var year1 = 	comboID("year1").Code;
    	var week1 = 	comboID("week1").Code;
    	var year2 = 	comboID("year2").Code;
    	var week2 = 	comboID("week2").Code;
		var rhq_txt = 	comboID("rhq_txt").Code;
		
		var pol_pod ;		
		var rhq_gso;
		var ocn_ipc;
		var ctrlFlg;
		save_lane = sheetObj.CellValue(row, "LANE");
		save_bound = sheetObj.CellValue(row, "BOUND");
		save_vvd = sheetObj.CellValue(row, "VVD");
		save_trade = sheetObj.CellValue(row, "TRADE");
		save_subtrade = sheetObj.CellValue(row, "SUBTRADE");
		pop_yrwk = sheetObj.CellValue(row, "WEEK");

		//weekly cmb header 조회
		var weekXml = sheetObj.GetSearchXml("ESM_SPC_0042GS2.do?f_cmd="+SEARCH);
		headWeek = ComGetEtcData(weekXml, "headerWeek");
		
		sheetObjects[1].Enable = false;
		sheetObjects[1].ReDraw = false;
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
		sheetObjects[4].RemoveAll();
		initSheet(sheetObjects[1], 2);
		initSheet(sheetObjects[2], 3);
		initSheet(sheetObjects[3], 4);
		initSheet(sheetObjects[4], 5);
		
    		//tab1 조회		
		formObj.vvd1.value = save_vvd;
		rhq_gso = _getRadioValue(formObj.rhq_gso1);
		pol_pod = _getRadioValue(formObj.pol_pod1);
		ocn_ipc = sheetObj.CellValue(row, "OCN_IPC");
		if(ocn_ipc=="OCN"){
			ocn_ipc = "O";
		}else{
			ocn_ipc = "I";
		}
		save_ocn_ipc = ocn_ipc;
		
		var param1 = "f_cmd="+SEARCHLIST02+"&year1="+year1+"&week1="+week1+"&year2="+year2+"&week2="+week2+
		"&lane="+save_lane+"&bound="+save_bound+"&vvd="+save_vvd+"&rhq_txt="+rhq_txt+"&pol_pod="+pol_pod+
		"&rhq_gso="+rhq_gso+"&onc_ipc="+save_ocn_ipc+"&trade="+save_trade+"&subtrade="+save_subtrade;
		//sheetObjects[1].DoSearch4Post("ESM_SPC_0022GS.do", param1);
        var xml = sheetObjects[1].GetSearchXml("ESM_SPC_0022GS.do", param1);
        sheetObjects[1].LoadSearchXml4Sax(xml, false, -1, false);
        
		//fcast_ttl_teu_qty처리, FCAST의 경우 TEU는 감추고 Total TEU를 보여주도록 수정
		var col_idx = sheetObjects[1].SaveNameCol("fcast_ttl_teu_qty");
		var type_sts = document.form.type1.checked;
		if(!type_sts) {
		    sheetObjects[1].ColHidden(col_idx + 1) = true;
		    sheetObjects[1].ColWidth(col_idx) = 80;
		}
		
		if(sheetObjects[1].SearchRows > 0){
			ctrlFlg = sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, "ctrl_flg");
			if(ctrlFlg == "N"){
				sheetObjects[1].ColHidden("cust_ctrl_cd") = true;	//Yeld Group
				sheetObjects[1].ColHidden("smp") = true;			//Guide
				ComBtnDisable("btng_season_grp");
			}else{
				sheetObjects[1].ColHidden("cust_ctrl_cd") = false;	//Yeld Group
				sheetObjects[1].ColHidden("smp") = false;			//Guide
				ComBtnEnable("btng_season_grp");
			}
		}
		
		sheetObjects[1].ReDraw = true;
		sheetObjects[1].Enable = true;
		
		//tab2 조회		
		formObj.vvd2.value = save_vvd;
		rhq_gso = _getRadioValue(formObj.rhq_gso2);
		pol_pod = _getRadioValue(formObj.pol_pod2);
		ocn_ipc = sheetObj.CellValue(row, "OCN_IPC");
		if(ocn_ipc=="OCN"){
			ocn_ipc = "O";
		}else{
			ocn_ipc = "I";
		}
		save_ocn_ipc = ocn_ipc;

		var param2 = "f_cmd="+SEARCHLIST03+"&year1="+year1+"&week1="+week1+"&year2="+year2+"&week2="+week2+
		"&lane="+save_lane+"&bound="+save_bound+"&vvd="+save_vvd+"&rhq_txt="+rhq_txt+"&pol_pod="+pol_pod+
		"&rhq_gso="+rhq_gso+"&onc_ipc="+save_ocn_ipc+"&trade="+save_trade+"&subtrade="+save_subtrade;
		sheetObjects[2].DoSearch4Post("ESM_SPC_0022GS.do", param2);
		//fcast_ttl_teu_qty처리, FCAST의 경우 TEU는 감추고 Total TEU를 보여주도록 수정
		col_idx = sheetObjects[2].SaveNameCol("fcast_ttl_teu_qty");
		type_sts = document.form.type2.checked;
		if(!type_sts) {
		    sheetObjects[2].ColHidden(col_idx + 1) = true;
		    sheetObjects[2].ColWidth(col_idx) = 80;
		}
		
		//tab3 조회		
		formObj.vvd3.value = save_vvd;
		//formObj.vvd4.value = save_vvd;
        //save_vvd = sheetObj.CellValue(row, "VVD");
        rhq_gs = _getRadioValue(formObj.rhq_gso3);
       	pol_pod = _getRadioValue(formObj.pol_pod3);
		ocn_ipc = sheetObj.CellValue(row, "OCN_IPC");
		if(ocn_ipc=="OCN"){
			ocn_ipc = "O";
		}else{
			ocn_ipc = "I";
		}
		save_ocn_ipc = ocn_ipc;
		
		var param3 ="f_cmd="+SEARCHLIST05+"&year1="+year1+"&week1="+week1+"&year2="+year2+"&week2="+week2+
		"&lane="+save_lane+"&bound="+save_bound+"&vvd="+save_vvd+"&rhq_txt="+rhq_txt+"&pol_pod="+pol_pod+
		"&rhq_gso="+rhq_gso+"&onc_ipc="+save_ocn_ipc+"&trade="+save_trade+"&subtrade="+save_subtrade;
		sheetObjects[3].DoSearch4Post("ESM_SPC_0022GS.do", param3);
		
//            var param = "f_cmd="+SEARCHLIST04+paramCond;
//            var datas = sheetObjects[beforetab + 1].GetSearchXml("ESM_SPC_0022GS.do", param);
//          	var xmls = datas.split("[+]");
//    		for(var i = 0 ; i < xmls.length ; i++){
//    			//alert(xmls[i]);
//    			sheetObjects[i+3].LoadSearchXml(xmls[i]);
//    		}

		//fcast_ttl_teu_qty처리, FCAST의 경우 TEU는 감추고 Total TEU를 보여주도록 수정
		col_idx = sheetObjects[3].SaveNameCol("fcast_ttl_teu_qty");
		type_sts = document.form.type3.checked;
		if(!type_sts) {
		    sheetObjects[3].ColHidden(col_idx + 1) = true;
		    sheetObjects[3].ColWidth(col_idx) = 80;
		}
		
		if(ctrlFlg == "N"){
			sheetObjects[3].ColHidden("cust_ctrl_cd") = true;
			sheetObjects[3].ColHidden("smp") = true;
			ComBtnDisable("btng_season_grp");
		}else{
			sheetObjects[3].ColHidden("cust_ctrl_cd") = false;
			sheetObjects[3].ColHidden("smp") = false;
			ComBtnEnable("btng_season_grp");
		}

		
       //tab4 조회		
		formObj.vvd4.value = save_vvd;
		//formObj.vvd4.value = save_vvd;
        //save_vvd = sheetObj.CellValue(row, "VVD");
        rhq_gs = _getRadioValue(formObj.rhq_gso4);
       	pol_pod = _getRadioValue(formObj.pol_pod4);
		ocn_ipc = sheetObj.CellValue(row, "OCN_IPC");
		if(ocn_ipc=="OCN"){
			ocn_ipc = "O";
		}else{
			ocn_ipc = "I";
		}
		save_ocn_ipc = ocn_ipc;
		
		var param4 ="f_cmd="+SEARCHLIST04+"&year1="+year1+"&week1="+week1+"&year2="+year2+"&week2="+week2+
		"&lane="+save_lane+"&bound="+save_bound+"&vvd="+save_vvd+"&rhq_txt="+rhq_txt+"&pol_pod="+pol_pod+
		"&rhq_gso="+rhq_gso+"&onc_ipc="+save_ocn_ipc+"&trade="+save_trade+"&subtrade="+save_subtrade;
		sheetObjects[4].DoSearch4Post("ESM_SPC_0022GS.do", param4);
		
		//fcast_ttl_teu_qty처리, FCAST의 경우 TEU는 감추고 Total TEU를 보여주도록 수정
		col_idx = sheetObjects[4].SaveNameCol("fcast_ttl_teu_qty");
		type_sts = document.form.type4.checked;
		if(!type_sts) {
		    sheetObjects[4].ColHidden(col_idx + 1) = true;
		    sheetObjects[4].ColWidth(col_idx) = 80;
		}
		
    }
    
    /*
     * sheet1조회후 tab sheet clear
     */
    function sheet1_OnSearchEnd(sheetObj , ErrMsg){
        var sheetObject1 = sheetObjects[1];
        var sheetObject2 = sheetObjects[2];
        var sheetObject3 = sheetObjects[3];
        var sheetObject4 = sheetObjects[4];
     
        if(ErrMsg== ""){	   
            sheetObject1.RemoveAll(); 
            sheetObject2.RemoveAll(); 
            sheetObject3.RemoveAll();
            sheetObject4.RemoveAll();
           
      	}
    }

    
    /*
     * RHQ/POL title
     */
    function changeTitle_Colum(form_name)
    {   
    	
       	var rhq_gso;
    	var pol_pod;
    	var sheetObj1 = sheetObjects[beforetab];
		var formObj = document.form;
		var year1 = 	comboID("year1").Code;
    	var week1 = 	comboID("week1").Code;
    	var year2 = 	comboID("year2").Code;
    	var week2 = 	comboID("week2").Code;
		var rhq_txt = 	comboID("rhq_txt").Code;
		var vvd;
		var ocn_ipc = save_ocn_ipc;
		
    	if(form_name=="1"){
    		rhq_gso = _getRadioValue(formObj.rhq_gso1);
    		pol_pod = _getRadioValue(formObj.pol_pod1);
			vvd = formObj.vvd1.value;
			
			if(rhq_gso=="RHQ"){
				sheetObj1.CellText(0,1)="Area/RHQ";
				sheetObj1.CellText(1,1)="Area/RHQ";
				sheetObj1.CellText(2,1)="Area/RHQ";				
			}else{
				sheetObj1.CellText(0,1)="Office";
				sheetObj1.CellText(1,1)="Office";
				sheetObj1.CellText(2,1)="Office";
			}
			if(vvd==""){
				ComShowMessage(getMsg("SPC90199", "VVD"));
				formObj.vvd1.focus();
				return;
			}else{
				var param = "f_cmd="+SEARCHLIST02+"&year1="+year1+"&week1="+week1+"&year2="+year2+"&week2="+week2+
				"&lane="+save_lane+"&bound="+save_bound+"&vvd="+save_vvd+"&rhq_txt="+rhq_txt+"&pol_pod="+pol_pod+
				"&rhq_gso="+rhq_gso+"&onc_ipc="+save_ocn_ipc+"&trade="+save_trade+"&subtrade="+save_subtrade;
				sheetObj1.DoSearch4Post("ESM_SPC_0022GS.do", param);
			}
    	}else if(form_name=="2"){
    		rhq_gso = _getRadioValue(formObj.rhq_gso2);
    		pol_pod = _getRadioValue(formObj.pol_pod2);
    		vvd = formObj.vvd2.value;
			if(rhq_gso=="RHQ"){
				if(pol_pod=="POL"){
					sheetObj1.CellText(0,2)="POL";
					sheetObj1.CellText(1,2)="POL";
					sheetObj1.CellText(2,2)="POL";
					sheetObj1.CellText(0,4)="RHQ";
					sheetObj1.CellText(1,4)="RHQ";
					sheetObj1.CellText(2,4)="RHQ";
				} else if(pol_pod=="POD") {
					sheetObj1.CellText(0,2)="POD";
					sheetObj1.CellText(1,2)="POD";
					sheetObj1.CellText(2,2)="POD";
					sheetObj1.CellText(0,4)="RHQ";
					sheetObj1.CellText(1,4)="RHQ";
					sheetObj1.CellText(2,4)="RHQ";
				} else {
					sheetObj1.CellText(0,2)="DEL";
					sheetObj1.CellText(1,2)="DEL";
					sheetObj1.CellText(2,2)="DEL";
					sheetObj1.CellText(0,4)="RHQ";
					sheetObj1.CellText(1,4)="RHQ";
					sheetObj1.CellText(2,4)="RHQ";
				}
			}else{
				if(pol_pod=="POL"){
					sheetObj1.CellText(0,2)="POL";
					sheetObj1.CellText(1,2)="POL";
					sheetObj1.CellText(2,2)="POL";
					sheetObj1.CellText(0,4)="Office";
					sheetObj1.CellText(1,4)="Office";
					sheetObj1.CellText(2,4)="Office";
				} else if(pol_pod=="POD") {
					sheetObj1.CellText(0,2)="POD";
					sheetObj1.CellText(1,2)="POD";
					sheetObj1.CellText(2,2)="POD";
					sheetObj1.CellText(0,4)="Office";
					sheetObj1.CellText(1,4)="Office";
					sheetObj1.CellText(2,4)="Office";
				} else {
					sheetObj1.CellText(0,2)="DEL";
					sheetObj1.CellText(1,2)="DEL";
					sheetObj1.CellText(2,2)="DEL";
					sheetObj1.CellText(0,4)="Office";
					sheetObj1.CellText(1,4)="Office";
					sheetObj1.CellText(2,4)="Office";
				}
			}
			if(vvd==""){
				ComShowMessage(getMsg("SPC90199", "VVD"));
				formObj.vvd2.focus();
				return;
			}else{
				var param = "f_cmd="+SEARCHLIST03+"&year1="+year1+"&week1="+week1+"&year2="+year2+"&week2="+week2+
				"&lane="+save_lane+"&bound="+save_bound+"&vvd="+save_vvd+"&rhq_txt="+rhq_txt+"&pol_pod="+pol_pod+
				"&rhq_gso="+rhq_gso+"&onc_ipc="+save_ocn_ipc+"&trade="+save_trade+"&subtrade="+save_subtrade;
				sheetObj1.DoSearch4Post("ESM_SPC_0022GS.do", param);
			}
    	}
    	else if(form_name=="3"){
    		rhq_gso = _getRadioValue(formObj.rhq_gso3);
    		pol_pod = _getRadioValue(formObj.pol_pod3);
    		vvd = formObj.vvd3.value;
			if(rhq_gso=="RHQ"){
				if(pol_pod=="POL"){
					sheetObj1.CellText(0,14)="POL";
					sheetObj1.CellText(1,14)="POL";
					sheetObj1.CellText(2,14)="POL";
					sheetObj1.CellText(0,15)="RHQ";
					sheetObj1.CellText(1,15)="RHQ";
					sheetObj1.CellText(2,15)="RHQ";
				} else if(pol_pod=="POD") {
					sheetObj1.CellText(0,14)="POD";
					sheetObj1.CellText(1,14)="POD";
					sheetObj1.CellText(2,14)="POD";
					sheetObj1.CellText(0,15)="RHQ";
					sheetObj1.CellText(1,15)="RHQ";
					sheetObj1.CellText(2,15)="RHQ";
				} else {
					sheetObj1.CellText(0,14)="DEL";
					sheetObj1.CellText(1,14)="DEL";
					sheetObj1.CellText(2,14)="DEL";
					sheetObj1.CellText(0,15)="RHQ";
					sheetObj1.CellText(1,15)="RHQ";
					sheetObj1.CellText(2,15)="RHQ";
				}
			}else{
				if(pol_pod=="POL"){
					sheetObj1.CellText(0,14)="POL";
					sheetObj1.CellText(1,14)="POL";
					sheetObj1.CellText(2,14)="POL";
					sheetObj1.CellText(0,15)="Office";
					sheetObj1.CellText(1,15)="Office";
					sheetObj1.CellText(2,15)="Office";
				} else if(pol_pod=="POD") {
					sheetObj1.CellText(0,14)="POD";
					sheetObj1.CellText(1,14)="POD";
					sheetObj1.CellText(2,14)="POD";
					sheetObj1.CellText(0,15)="Office";
					sheetObj1.CellText(1,15)="Office";
					sheetObj1.CellText(2,15)="Office";
				} else {
					sheetObj1.CellText(0,14)="DEL";
					sheetObj1.CellText(1,14)="DEL";
					sheetObj1.CellText(2,14)="DEL";
					sheetObj1.CellText(0,15)="Office";
					sheetObj1.CellText(1,15)="Office";
					sheetObj1.CellText(2,15)="Office";
				}
			}
			if(vvd==""){
				ComShowMessage(getMsg("SPC90199", "VVD"));
				formObj.vvd3.focus();
				return;
			}else{
				var param = "f_cmd="+SEARCHLIST05+"&year1="+year1+"&week1="+week1+"&year2="+year2+"&week2="+week2+
				"&lane="+save_lane+"&bound="+save_bound+"&vvd="+save_vvd+"&rhq_txt="+rhq_txt+"&pol_pod="+pol_pod+
				"&rhq_gso="+rhq_gso+"&onc_ipc="+save_ocn_ipc+"&trade="+save_trade+"&subtrade="+save_subtrade;
				sheetObj1.DoSearch4Post("ESM_SPC_0022GS.do", param);
			}
    	}
    	else if(form_name=="4"){
    		rhq_gso = _getRadioValue(formObj.rhq_gso4);
    		pol_pod = _getRadioValue(formObj.pol_pod4);
    		vvd = formObj.vvd4.value;
            if(rhq_gso=="RHQ"){
				if(pol_pod=="POL"){
					sheetObj1.CellText(0,11)="POL";
					sheetObj1.CellText(1,11)="POL";
					sheetObj1.CellText(2,11)="POL";
					sheetObj1.CellText(0,12)="RHQ";
					sheetObj1.CellText(1,12)="RHQ";
					sheetObj1.CellText(2,12)="RHQ";
				} else if(pol_pod=="POD") {
					sheetObj1.CellText(0,11)="POD";
					sheetObj1.CellText(1,11)="POD";
					sheetObj1.CellText(2,11)="POD";
					sheetObj1.CellText(0,12)="RHQ";
					sheetObj1.CellText(1,12)="RHQ";
					sheetObj1.CellText(2,12)="RHQ";
				} else {
					sheetObj1.CellText(0,11)="DEL";
					sheetObj1.CellText(1,11)="DEL";
					sheetObj1.CellText(2,11)="DEL";
					sheetObj1.CellText(0,12)="RHQ";
					sheetObj1.CellText(1,12)="RHQ";
					sheetObj1.CellText(2,12)="RHQ";
				}
			}else{
				if(pol_pod=="POL"){
					sheetObj1.CellText(0,11)="POL";
					sheetObj1.CellText(1,11)="POL";
					sheetObj1.CellText(2,11)="POL";
					sheetObj1.CellText(0,12)="Office";
					sheetObj1.CellText(1,12)="Office";
					sheetObj1.CellText(2,12)="Office";
				} else if(pol_pod=="POD") {
					sheetObj1.CellText(0,11)="POD";
					sheetObj1.CellText(1,11)="POD";
					sheetObj1.CellText(2,11)="POD";
					sheetObj1.CellText(0,12)="Office";
					sheetObj1.CellText(1,12)="Office";
					sheetObj1.CellText(2,12)="Office";
				}else {
					sheetObj1.CellText(0,11)="DEL";
					sheetObj1.CellText(1,11)="DEL";
					sheetObj1.CellText(2,11)="DEL";
					sheetObj1.CellText(0,12)="Office";
					sheetObj1.CellText(1,12)="Office";
					sheetObj1.CellText(2,12)="Office";
				}
			}
			if(vvd==""){
				ComShowMessage(getMsg("SPC90199", "VVD"));
				formObj.vvd4.focus();
				return;
			}else{
				var param = "f_cmd="+SEARCHLIST04+"&year1="+year1+"&week1="+week1+"&year2="+year2+"&week2="+week2+
				"&lane="+save_lane+"&bound="+save_bound+"&vvd="+save_vvd+"&rhq_txt="+rhq_txt+"&pol_pod="+pol_pod+
				"&rhq_gso="+rhq_gso+"&onc_ipc="+save_ocn_ipc+"&trade="+save_trade+"&subtrade="+save_subtrade;
				sheetObj1.DoSearch4Post("ESM_SPC_0022GS.do", param);
			}
    	}
    }	
    
/*  사용되고 있지 않음 
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
    */
    
    /*
     * View by Type선택시 타이틀 보이기/숨기기
     */
    function changeTitle2(form_name, obj){    	
    	var sheetObj;
    	var sts, weight; 
    	var obj1 = eval(sheetObjects[1].form.weight1);
    	sheetObj = sheetObjects[form_name * 1];
    	sts = obj.checked;
		sheetObj.Redraw = false;
		var beforeCol = "";
    	for (i=0; i<=sheetObj.LastCol; i++) {
    		var colName = sheetObj.ColSaveName(i);
    		switch(colName.substring(4)){
    			case "teu":
    			case "ttl"://Weight
    				sheetObj.ColWidth(i) = sts?60:80;
    				break;
    			case "d2":
    			case "d4":
    			case "d5":
    			case "d7":
    			case "53":
    			case "rd":
    			case "rf":
    				sheetObj.ColHidden(i) = !sts;
    				break;
    		}
    		
    		//fcast_ttl_teu_qty처리, FCAST의 경우 TEU는 감추고 Total TEU를 보여주도록 수정
    		if(beforeCol == 'fcast_ttl_teu_qty' && colName == 'vol_teu') {
    		    if(sts) {
    		        sheetObj.ColHidden(i) = false;
    		        sheetObj.ColWidth(i) = 60;
    		        sheetObj.ColWidth(i-1) = 60;
    		    }
    		    else {
    		        sheetObj.ColHidden(i) = true;
    		        sheetObj.ColWidth(i-1) = 80;
    		    }
    		}    		
    		beforeCol = colName;
      	}
      	sheetObj.Redraw = true;
    }
    
    /*
     * View by Weight
     */
    function changeTitle1(form_name, obj){    	
    	var sheetObj;
    	var sts, weight; 
    	sheetObj = sheetObjects[form_name * 1];
    	sts = obj.checked;
    	var cmbObjNm = "document.form.cmb" + form_name ;
   	 	var cmbObj = eval(cmbObjNm);
   	 	
		sheetObj.Redraw = false;
    	for (i=0; i<=sheetObj.LastCol; i++) {
    		var colName = sheetObj.ColSaveName(i);
    		switch(colName){
    			case "wgt_ttl":
    				sheetObj.ColHidden(i) = !sts;
    				break;
    			case "bkg_wgt_vgm":
    				sheetObj.ColHidden(i) = !sts;
    				break;	
    			case "cmb_wgt_wk":
    				if(cmbObj.checked){
    					sheetObj.ColHidden(i) = !sts;
    				}
    				break;
    		}
      	}
    	
      	sheetObj.Redraw = true;
    }
     
     /*
      * View by Weekly CMB
      */
     function changeTitle3(form_name, obj){    	
    	 var sheetObj;
    	 var sts, weight; 
    	 sheetObj = sheetObjects[form_name * 1];
    	 var weightObjNm = "sheetObjects[1].form.weight" + form_name ;
    	 var weightObj = eval(weightObjNm);
    	 sts = obj.checked;
    	 sheetObj.Redraw = false;
    	 for (i=0; i<=sheetObj.LastCol; i++) {
    		 var colName = sheetObj.ColSaveName(i);
    		 switch(colName){
    		 case "cmb_wk":
    			 sheetObj.ColHidden(i) = !sts;
    			 break;
    			 
    		 case "cmb_wgt_wk":
    			 if(weightObj.checked){
    				 sheetObj.ColHidden(i) = !sts;
    			 }
    			 break;
    			 
    		 }
    	 }
    	 
    	 sheetObj.Redraw = true;
     }
       
        
    /*
     * login한 ofc_cd값이 'SELHO'가 아닌경우 ofc_cd값으로 setting
     */    
    /*  사용되고 있지 않음.
    function rhq_txt1_OnLoadFinish(){
    	var formObj = document.form;
    	if(formObj.ofc_cd.value!="SELHO"){
    		comboID("rhq_txt").Enable = false;  
    		comboID("rhq_txt").Text2 = formObj.ofc_cd.value;
    		comboID("rhq_txt").Code2 = formObj.ofc_cd.value;   		
    	}
    } 
     */  
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			var ovvd = formObj.only_vvd.value;
			var rhq = comboID("rhq_txt").Code;
			var wk = calcPeriod(comboID("year1").Code,comboID("week1").Code, comboID("year2").Code, comboID("week2").Code);
            
            if(ovvd!="" && ovvd.length<9){
            	ComShowMessage(getMsg("SPC90116","VVD")); 
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
            if(rhq==""){
            	ComShowMessage(getMsg("SPC90115","RHQ")); 
                //formObj.rhq_txt.focus();
                //포커스 안잡히므로 강제로 year1에 두었다가 옮김
                formObj.year1.focus();
                comboID("rhq_txt").focus();
                return false;
            }
		}

        return true;
    }
     
     /*
      * 선택된 하나의 Radio Object Value를 반환
      * @param     oRadio : object Radio
      * @return    String
      */
     function _getRadioValue(oRadio) {
         if (oRadio == null) return "";

         if (oRadio.length != null)
         {
             for(i=0; i<oRadio.length; i++)
             {
                 if (oRadio[i].checked) return oRadio[i].value;
             } // end for
         } else  {
             if (oRadio.checked) return oRadio.value;
         } // end if
         return "";
     }
     

	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 최성민
	 * @version 2011.05.23
	 */
	function trade_OnChange(comboObj, code, text) {		
//		if(text == '|ALL'){	optionAllReset("trade",code);   return;} // 0207 SHKIM
		if (code != null && code != "") {  			
			comboID('subtrade').Code2 = "";
			comboID('lane').Code2 = "";
		}
		SpcSearchOptionSubTrade("subtrade",true,false,"","",code);			// 0207 SHKIM
		SpcSearchOptionLane("lane",true,true,'',code,'',true);	// 0207 SHKIM
	}
		
	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 최성민
	 * @version 2011.05.23
	 */
	function subtrade_OnChange(comboObj, value, text) {
//		if(text == '||ALL'){   optionAllReset("subtrade",document.form.trade.Code); return;    	} // 0207 SHKIM	    	 
		SpcSearchOptionLane("lane",true,true,'',document.form.trade.Code,value,true);	// 0207 SHKIM
		if(value == "") return;
    	var arrTrade = text.split("|");
    	if(arrTrade.length > 1) {
    		comboObjects[5].Code2 = arrTrade[0];
    		comboObjects[7].Code2 = '';
    	} else {
    		comboObjects[5].Code2 = comboObj.GetText(value,0);  
    		comboObjects[7].Code2 = '';
    	}
	}
		

   
	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 최성민
	 * @version 2011.05.23
	 */
	function lane_OnChange(comboObj, value, text) {
		// 해당사항없음.if(text == '||ALL'){	optionAllReset("lane");  } // 0207 SHKIM
    	var arrLane = text.split("|");
    	if(arrLane.length > 1) {
    		comboObjects[5].Code2 = arrLane[0];
    		comboObjects[6].Code2 = arrLane[1];
    	} else {
    		comboObjects[5].Code2 = comboObj.GetText(value,0);  
    		comboObjects[6].Code2 = comboObj.GetText(value,1);  
    	}	
	}
	
	
   	/**
   	 * 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *    
   	 * </pre>
   	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2011.05.23
   	 */   	
//   	function lane_OnBlur(comboObj) {
//   		
//   		var tCode = comboObj.FindIndex(comboObj.Code, 2);
//   		
//   		if (tCode != null && tCode != "") { 
//			comboID('trade').Code2 = comboObj.GetText(tCode, 0);
//			comboID('subtrade').Code2 = comboObj.GetText(tCode, 1);
//   		}
//   	}
   	

	/**
	 * 화면 로딩시 콤보 데이터를 초기화 하는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @return 없음
	 * @author 최성민
	 * @version 2011.04.08
	 */
	function initComboData() {
		getSpcTextToCombo(arrYearComboCd, arrYearComboNm, comboID('year1'));
		getSpcTextToCombo(arrYearComboCd, arrYearComboNm, comboID('year2'));
			
		getSpcTextToCombo(arrWeekComboCd, arrWeekComboNm, comboID('week1'));
		getSpcTextToCombo(arrWeekComboCd, arrWeekComboNm, comboID('week2'));
		getSpcTextToCombo(arrRHQComboCd, arrRHQComboCd, comboID('rhq_txt'));
		getSpcTextToCombo(arrTradeComboCd, arrTradeComboNm, comboID('trade'));
		
		//subtrade, Rlane 인경우는 쿼리에 '|'문자가 포함되어 있기 때문에 Row구분자를 바꿈(디폴트는 '|'문자임)
		getSpcTextToCombo(arrSubTradeComboCd, arrSubTradeComboNm, comboID('subtrade'),"@");
		getSpcTextToCombo(arrRLaneComboCd, arrRLaneComboNm, comboID('lane'),"@");	

		getSpcTextToCombo(arrBoundComboCd, arrBoundComboCd, comboID('bound'));
		getSpcTextToCombo(arrOcnIpcComboCd, arrOcnIpcComboCd, comboID('onc_ipc'));		
	}
	   	
   	/**
   	 * Combo Object의 ID 값을 가져오는 function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @param {string} id combo id 값
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2011.04.08
   	 */
	function comboID(id) {
		return document.getElementById(id);
	}
	
	/**
     * document 안에 있는 모든 Object의 값을 초기화한다. <br>
     * Form.reset()하고, IBSheet.RemoveAll()처리한다. IBMultiCombo의 경우 id="myCombo"이면 "initComboValue_myCombo()" 라는 <br>
     * 자바스크립트 함수가 정의되어 있다면 해당 함수를 호출하고, 해당 함수가 없다면 아무것도도 선택되지 않도록 IBMultiCombo.Code2="-1";로 설정한다. <br>
     * @return 없음
     * @see #ComClearManyObjects
     */
    function SpcResetAll(){

        try {    
        	var formObj = document.form;
        	
        	formObj.only_vvd.value = "";
        	formObj.vvd1.value = "";
        	formObj.vvd2.value = "";
        	formObj.vvd3.value = "";
        	formObj.vvd4.value = "";
        	ComBtnDisable("btng_season_grp");
        	
            var objs = document.getElementsByTagName("OBJECT");
            for(var i = 0 ; i < objs.length ; i++){
                var sObjId = objs[i].classid;
                switch(sObjId){
                    case CLSID_IBSHEET: //IBSheet
                        objs[i].RemoveAll();
                        break;
                   
                    case CLSID_IBMCOMBO: //IBMultiCombo 경우
                        var id = objs[i].id;
                        var funcName = "initComboValue_" + id;
                        if (ComFuncCheck(funcName)) {
                            ComFunc();
                        } else {
                            objs[i].Code2="-1";
                        }
                        break;
                        
                }
            }
            
            comboID('year1').Code2 = formObj.t_year.value;
            comboID('year2').Code2 = formObj.t_year.value;
            comboID('week1').Code2 = formObj.t_week.value;
            comboID('week2').Code2 = formObj.t_week.value;
            comboID('rhq_txt').Code2 = formObj.t_ofc_cd.value;
            
        } catch(err) { ComFuncErrMsg(err.message); }
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
