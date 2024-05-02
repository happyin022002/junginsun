/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0014.js
*@FileTitle : US domestic cost/credit 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.17
*@LastModifier : 김보배
*@LastVersion : 1.0 
* 2012.10.17 김보배
* 1.0 Creation
=========================================================
* History
* 2012.11.19 송호진 [CHM-201221090-01] [MAS] US DOMESTIC 반영 - Tab 및 저장용 공통 Sheet 추가
* 2012.11.20 송호진 [CHM-201221090-01] [MAS] US DOMESTIC 반영 - CNTR_SZ_CD -> CNTR_TPSZ_CD 컬럼명 변경에 따른 Sheet 상의 컬럼명 Text 변경 ( Size -> Type Size )
* 2012.11.21 송호진 [CHM-201221090-01] [MAS] US DOMESTIC 반영 - TRP, EQ off-hire Tab 특정 컬럼의 Sum 값 로직 변경, LoadSearchXml Wait Image 표시 관련 수정 
* 2012.11.26 송호진 [CHM-201221090-01] [MAS] US DOMESTIC 반영 - Create 작업 전 기존 데이터 존재 체크 부분 추가 관련 수정  , Creation Date, User ID, Currency 표시 부분 추가
* 2013.05.09 서미진 [선처리 CSR] User office 가 SELCDA, SELCDO, SELCOL 인 경우에만 Create, Save 버튼 보이도록 변경 
* 2013.05.10 최성민 [CHM-201324573-01] [MAS] Domestic Saving Credit 화면 버튼 추가 
* 2013.05.31 김수정 [CHM-201324859] MAS Domestic Saving Credit 보완
* 2013.06.24 성미영 [CHM-201325332] [MAS] 본사 조직 변경 관련 MAS 변경 사항
* 2014.04.16 박다은 [CHM-201429852] [MAS] SELCOT, SELCON 조직 변경(추가) 관련 MAS 관련 작업 요청
* 2015.08.31 손진환 [CHM-201536958] Split15-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
=========================================================*/

/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCH=3;
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
	 * @class ESM_MAS_0014 : ESM_MAS_0014 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_MAS_0014() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.setComboObject 		= setComboObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initCombo 				= initCombo;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.validateForm 			= validateForm;
	}
    
	/* 공통전역변수 */
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab1 = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
    var comboObjects = new Array();
    var comboCnt = 0;
  
    //전역변수
    var intervalId = "";
    var loadingMode = false;
    var triggerEvent = false;
    
    var RED_COLOR = 0;
    var BLK_COLOR = 0;
    
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	         var sheetObject1 = sheetObjects[0];
        /*******************************************************/
	 		var formObject = document.form;

			try {
				var srcName = window.event.srcElement.getAttribute("name");
				switch(srcName) {

				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0], formObject, SEARCH01);
					break;
					
				case "btn_month_copy":		//팝업창(Month Copy)
		     	       var display = "0,1";
		     	       ComOpenPopup("ESM_MAS_0173.do?classId=ESM_MAS_0014", 250, 160, "AverageUcCopy", display, true, false);
		     	    break;	
		     	    
           		case "btn_create":
           			doActionIBSheet(sheetObjects[0], formObject, COMMAND01);
           			break;
           			
				case "btn_save":
					if ( !sheetObjects[3].IsDataModified ) {
						ComShowMessage(ComGetMsg("COM130503"));
						return;
					}
					doActionIBSheet(sheetObjects[3], formObject, MULTI01);
					break; 
				
				case "btn_downExcel":
					doActionIBSheet(sheetObjects[tabObjects[0].SelectedIndex], formObject, IBDOWNEXCEL);
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
     * 콤보 Object를 comboObjects 배열에 등록
     * @param combo_obj
     * @return
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++] = combo_obj; 
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */                    
    function loadPage() {
    	var formObj = document.form;
		// SELCDA, SELCTY, SELCOL 가 아니면 Create, Save 버튼 숨김
    	// [CHM-201429852] [MAS] SELCOT, SELCON 조직 변경(추가) 관련 MAS 관련 작업 요청
		if( formObj.v_ofc_cd.value != "SELCSG" && formObj.v_ofc_cd.value != "SELCTY"
			 && formObj.v_ofc_cd.value != "SELOPA" && formObj.v_ofc_cd.value != "SELOPB" && formObj.v_ofc_cd.value != "SELAPM"
			 && formObj.v_ofc_cd.value != "SELCON" ){
			ComSetDisplay("btn_create",false);
			ComSetDisplay("btn_save",false);
			ComSetDisplay("btn_month_copy",false);
		}
    	
        // 텝 처리
        //---------------------------------------------
    		for(k=0;k<tabObjects.length;k++){
  	  		initTab(tabObjects[k],k+1);
  		  }
    		
        // 멀티콤보 처리
		for(i=0;i<sheetObjects.length;i++){
	        //시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			
			initSheet(sheetObjects[i],i+1);
	        //마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		loadingMode = true;
		
		//화면에서 필요한 이벤트
    	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListenerFormat('focus', 'obj_activate', document.form); // - 포커스 들어갈때
    	axon_event.addListenerForm('change', 'obj_change',  document.form); //- change    	
	    
    	// 화면 로딩시 콤보데이터 조회
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    	RED_COLOR = sheetObjects[0].RgbColor ( 255,0,0 );
    	BLK_COLOR = sheetObjects[0].RgbColor ( 0,0,0 );

    	// 멀티콤보 처리
		for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
		loadingMode = false;		
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
                     InsertTab( cnt++, "   Domestic(HRP)  " , -1 );
                     InsertTab( cnt++, "   Domestic(TRP)  " , -1 );
                     InsertTab( cnt++, "   EQ off-hire    " , -1 );
                 }
              break;
         }
     }

   /**
     * 콤보 설정
     */
    function initCombo (comboObj, comboNo) {
    	with (comboObj) {
	    	DropHeight = 500;
	    	switch(comboObj.id) {
	    	
	    	case "f_ecc_cd":
	    		InsertItem(0,  "All", " ");
	    		ValidChar(2, 0);
	    		MaxLength = 5;
	    		Text = "All";    
	    		break;

	    	case "f_cntr_tpsz_cd":
	    		InsertItem(0,  "All", " ");
	    	    ValidChar(2, 1);
	    	    MaxLength = 2;
	    	    Text = "All";    
	    	    break;
	        }
	    	Index = 0;
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
					style.height = 380;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					//MergeSheet = msPrevColumnMerge + msHeaderOnly; -- msAll
					MergeSheet = msPrevColumnMerge + msHeaderOnly;//msPrevColumnMerge;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);
					
					var HeadTitle1 = "||Month|ECC|Rail Hub|Type\nSize|a. Domestic Revenue" +
									 "|a. Domestic Revenue|a. Domestic Revenue|a. Domestic Revenue|a. Domestic Revenue|a. Domestic Revenue|a. Domestic Revenue" +
									 "|b. Domestic Rail Payout|b. Domestic Rail Payout|b. Domestic Rail Payout|c. Domestic Cost (b-a)|c. Domestic Cost (b-a)|d. Simulated Empty Repo|d. Simulated Empty Repo|d. Simulated Empty Repo" +
									 "|e. Domestic Savings (d-c)|e. Domestic Savings (d-c)|e. Domestic Savings (d-c)|e. Domestic Savings (d-c)";
			        var HeadTitle2 = "||Month|ECC|Rail Hub|Type\nSize|Volume" +
			        				 "|Railage|EQ Rental|Fuel Surcharge|Hazmat|Total|Unit Cost" +
			        				 "|Volume|Total|Unit Cost|Total|Unit Cost|Total|Initial Unit Cost|Unit Cost" +
			        				 "|Total|Full I/B\n Volume|Initial Credit Per Box|Credit Per Box";
			        var headCount = ComCountHeadTitle(HeadTitle1);
					
					headCount = ComCountHeadTitle(HeadTitle1);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 6, 0, false);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
					InitHeadMode(true, false, true, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					
			        //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++,  dtHiddenStatus,	  0,	daCenter,  false,	"ibflag");
					InitDataProperty(0, cnt++ , dtHidden,      	  0,	daCenter,	true,	"row_num");
					InitDataProperty(0, cnt++ , dtData,			 60,	daCenter,	true,	"cost_yrmon"			,false,"",dfNone,		0,  false,   false);
					InitDataProperty(0, cnt++ , dtData,			 70,	daCenter,	true,	"org_rail_loc_cd"		,false,"",dfNone,		0,  false,   false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"rail_hub"				,false,"",dfNone,		0,  false,   false);
					InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	true,	"cntr_tpsz_cd"			,false,"",dfNone,		0,  false,   false);				
					InitDataProperty(0, cnt++ , dtAutoSum,		 60,	daRight,	true,	"dmst_vol_qty"			,false,"",dfInteger,	0,  false,   false);
					
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"railg_amt"				,false,"",dfFloatOrg,	2,  false,   false);
					InitDataProperty(0, cnt++ , dtAutoSum,		 90,	daRight,	true,	"eq_rntl_scg_amt"		,false,"",dfFloatOrg,	2,  false,   false);
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"fuel_scg_amt"			,false,"",dfFloatOrg,	2,  false,   false);
					InitDataProperty(0, cnt++ , dtAutoSum,		 80,	daRight,	true,	"hzd_mtrl_scg_amt"		,false,"",dfFloatOrg,	2,  false,   false);
					InitDataProperty(0, cnt++ , dtAutoSum,		 90,	daRight,	true,	"dmst_ttl_frt_rev_amt"	,false,"",dfFloatOrg,	2,  false,   false);
					InitDataProperty(0, cnt++ , dtData,		     80,	daRight,    true,	"dom_rev_uc_amt"	    ,false,"",dfFloatOrg,	2,  false,   false);
					
					InitDataProperty(0, cnt++ , dtAutoSum,		 60,	daRight,	true,	"rail_so_vol_qty"		,false,"",dfInteger,	0,  false,   false);
					InitDataProperty(0, cnt++ , dtAutoSum,		 90,	daRight,	true,	"rail_agmt_amt"			,false,"",dfFloatOrg,	2,  false,   false);
					InitDataProperty(0, cnt++ , dtData,		     80,	daRight,    true,	"rail_uc_amt"	        ,false,"",dfFloatOrg,	2,  false,   false);
					InitDataProperty(0, cnt++ , dtAutoSum,	    100,	daRight,	true,	"usa_dmst_cost_amt"		,false,"",dfFloatOrg,	2,  false,   false);
					InitDataProperty(0, cnt++ , dtData,			 80,	daRight,	true,	"usa_dmst_uc_amt"		,false,"",dfFloatOrg,	2,  false,   false);
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"sim_mty_cost_amt"		,false,"",dfFloatOrg,	2,  false,   false);
					InitDataProperty(0, cnt++ , dtHidden,	    100,	daRight,	true,	"init_sim_mty_uc_amt"	,false,"",dfFloatOrg,	2,	false,   false);
					InitDataProperty(0, cnt++ , dtData,			 80,	daRight,	true,	"sim_mty_uc_amt"		,false,"",dfFloatOrg,	2,	 true,    true);
										
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"usa_dmst_sav_cost_amt"	,false,"",dfFloatOrg,	2,  false,   false);
					InitDataProperty(0, cnt++ , dtAutoSum,		 60,	daRight,	true,	"fcntr_ib_vol_qty"		,false,"",dfInteger,	0,  false,   false);
					InitDataProperty(0, cnt++ , dtHidden,	     70,	daRight,	true,	"init_usa_dmst_sav_ut_amt"	,false,"",dfFloatOrg,2,	false,   false);
					InitDataProperty(0, cnt++ , dtData,			 70,	daRight,	true,	"usa_dmst_sav_ut_amt"	,false,"",dfFloatOrg,	2,	 true,    true);
					
					WaitImageVisible = false;
	//				CountPosition = 0;
					SelectHighLight= true;
					// 문장이 길경우 ...으로 표시함
					Ellipsis = true;
					
					viewRevDetail();
	        	}
	        	break;
        	case 2:      //sheet2 init
    			with (sheetObj) {
	        	
		        	// 높이 설정
					style.height = 380;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					//MergeSheet = msPrevColumnMerge + msHeaderOnly; -- msAll
					MergeSheet = msPrevColumnMerge + msHeaderOnly;//msPrevColumnMerge;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);
					
					var HeadTitle1 = "||Month|ECC|Rail Hub|Type\nSize|TRP\nvolume" +
									 "|TRP Cost|TRP Cost" +
									 "|Simulated Empty Repo|Simulated Empty Repo|Simulated Empty Repo" +
									 "|TRP savings|TRP savings|TRP savings|TRP savings";
			        var HeadTitle2 = "||Month|ECC|Rail Hub|Type\nSize|TRP\nvolume" +
			        				 "|Cost Total|Cost per box" +
			        				 "|a. Total|b. Init Empty\nrepo unit cost|b. Empty\nrepo unit cost" +
			        				 "|Savings\ntotal|Full I/B Volume|b. Init credit per box|b. Credit per box";
			        var headCount = ComCountHeadTitle(HeadTitle1);
					
					headCount = ComCountHeadTitle(HeadTitle1);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 6, 0, false);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
					InitHeadMode(true, false, true, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					
			        //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++,  dtHiddenStatus,	  0,	daCenter,  false,	"ibflag");
					InitDataProperty(0, cnt++ , dtHidden,	   	  0,	daCenter,	true,	"row_num");
					InitDataProperty(0, cnt++ , dtData,			 60,	daCenter,	true,	"cost_yrmon"			,false,"",dfNone,		0,  false,   false);
					InitDataProperty(0, cnt++ , dtData,			 70,	daCenter,	true,	"org_rail_loc_cd"		,false,"",dfNone,		0,  false,   false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"rail_hub"				,false,"",dfNone,		0,  false,   false);
					InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	true,	"cntr_tpsz_cd"			,false,"",dfNone,		0,  false,   false);					
					InitDataProperty(0, cnt++ , dtAutoSum,		 60,	daRight,	true,	"trp_qty"				,false,"",dfInteger,	0,  false,   false);
					
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"trp_amt"				,false,"",dfFloatOrg,	2,  false,   false);
					InitDataProperty(0, cnt++ , dtData  ,		 90,	daRight,	true,	"trp_uc_amt"			,false,"",dfFloatOrg,	2,  false,   false);
					
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"trp_sim_mty_cost_amt"	,false,"",dfFloatOrg,	2,  false,   false);
					InitDataProperty(0, cnt++ , dtHidden,	    100,	daRight,	true,	"init_sim_mty_uc_amt"	,false,"",dfFloatOrg,	2,	false,   false);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"sim_mty_uc_amt"		,false,"",dfFloatOrg,	2,	 true,    true);
										
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"trp_sav_amt"			,false,"",dfFloatOrg,	2,  false,   false);
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"fcntr_ib_vol_qty"		,false,"",dfInteger,	0,  false,   false);
					InitDataProperty(0, cnt++ , dtHidden,	     70,	daRight,	true,	"trp_cr_uc_init_amt"	,false,"",dfFloatOrg,	2,	false,   false);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"trp_cr_uc_amt"			,false,"",dfFloatOrg,	2,	 true,    true);
					
					WaitImageVisible = false;
		//			CountPosition = 0;
					SelectHighLight= true;
					// 문장이 길경우 ...으로 표시함
					Ellipsis = true;
					
		    	}
		    	break;
        	case 3:      //sheet3 init
    			with (sheetObj) {
        	
		        	// 높이 설정
					style.height = 380;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					//MergeSheet = msPrevColumnMerge + msHeaderOnly; -- msAll
					MergeSheet = msPrevColumnMerge + msHeaderOnly;//msPrevColumnMerge;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);
					
					var HeadTitle1 = "||Month|ECC|Type\nSize" +
					 				 "|Off-hire|Off-hire|Off-hire|Off-hire" +
					 				 "|Total" +
					 				 "|Simulated Empty Repo|Simulated Empty Repo|Simulated Empty Repo" +
					 				 "|EQ Off-hire Savings|EQ Off-hire Savings|EQ Off-hire Savings|EQ Off-hire Savings" +
					 				 "|DRP Cost\n(Distributed\nper DRP Vol.)|Unit Cost\n(Divided by\nFull I/B Vol.) (B)|Revised Saving\n(A)-(B)| ";
					var HeadTitle2 = "||Month|ECC|Type\nSize" +
   				 					 "|EQ Off-hire|Sub lease out|Disposal|CN Domestic" +
					 				 "|Total" +
   				 					 "|Total|Init Unit cost|Unit Cost" +
   				 					 "|Total|Full I/B\nVolume|Init Unit cost|Unit Cost\n(A)"+
   				 					 "|DRP Cost\n(Distributed\nper DRP Vol.)|Unit Cost\n(Divided by\nFull I/B Vol.) (B)|Revised Saving\n(A)-(B)| ";
			        var headCount = ComCountHeadTitle(HeadTitle1);
					
					headCount = ComCountHeadTitle(HeadTitle1);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 5, 0, false);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
					InitHeadMode(true, false, true, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					
			        //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++,  dtHiddenStatus,	  0,	daCenter,  false,	"ibflag");
					InitDataProperty(0, cnt++ , dtHidden,	      0,	daCenter,	true,	"row_num");
					InitDataProperty(0, cnt++ , dtData,			 60,	daCenter,	true,	"cost_yrmon"				,false,"",dfNone,		0,  false,   false);
					InitDataProperty(0, cnt++ , dtData,			 70,	daCenter,	true,	"org_rail_loc_cd"			,false,"",dfNone,		0,  false,   false);
					InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	true,	"cntr_tpsz_cd"				,false,"",dfNone,		0,  false,   false);
					
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"eq_offh_qty"				,false,"",dfInteger,	0,  false,   false);
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"sub_lse_out_qty"			,false,"",dfInteger,	0,  false,   false);
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"disp_qty"					,false,"",dfInteger,	0,  false,   false);
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"cnd_dmst_qty"				,false,"",dfInteger,	0,  false,   false);
					
					InitDataProperty(0, cnt++ , dtAutoSum,		 60,	daRight,	true,	"offh_ttl_qty"				,false,"",dfInteger,	0,  false,   false);
					
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"offh_sim_mty_cost_amt"		,false,"",dfFloatOrg,	2,  false,   false);
					InitDataProperty(0, cnt++ , dtHidden,	    100,	daRight,	true,	"init_sim_mty_uc_amt"		,false,"",dfFloatOrg,	2,	false,   false);
					InitDataProperty(0, cnt++ , dtData,		 	 80,	daRight,	true,	"sim_mty_uc_amt"			,false,"",dfFloatOrg,	2,	 true,    true);
										
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"eq_offh_sav_amt"			,false,"",dfFloatOrg,	2,  false,   false);
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"fcntr_ib_vol_qty"			,false,"",dfInteger,	0,  false,   false);
					InitDataProperty(0, cnt++ , dtHidden,	     70,	daRight,	true,	"eq_offh_sav_uc_init_amt"	,false,"",dfFloatOrg,	2,	false,   false);
					InitDataProperty(0, cnt++ , dtData,			 80,	daRight,	true,	"eq_offh_sav_uc_amt"		,false,"",dfFloatOrg,	2,	 true,    true);
					InitDataProperty(0, cnt++ , dtAutoSum,		130,	daRight,	true,	"dmst_rail_inv_amt"  		,false,"",dfFloatOrg,	2,	false,   false);
					InitDataProperty(0, cnt++ , dtData,			130,	daRight,	true,	"eq_offh_uc_amt"     		,false,"",dfFloatOrg,	2,	false,   false);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"eq_offh_fnl_uc_amt"		,false,"",dfFloatOrg,	2,	 true,    true);
					InitDataProperty(0, cnt++ , dtHidden,		 80,	daRight,	true,	"eq_offh_fnl_uc_init_amt"   ,false,"",dfFloatOrg,	2,	false,   false);
					
					WaitImageVisible = false;
		//			CountPosition = 0;
					SelectHighLight= true;
					// 문장이 길경우 ...으로 표시함
					Ellipsis = true;
					
		    	}
	    		break;
        	case 4:      //sheet4 init
    		with (sheetObj) {
            	
            	// 높이 설정
				style.height = 0;
				//전체 너비 설정
				//SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				//MergeSheet = msPrevColumnMerge + msHeaderOnly; -- msAll
				MergeSheet = msPrevColumnMerge + msHeaderOnly;//msPrevColumnMerge;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, 100);
				
				var HeadTitle1 = "||Month|ECC|Rail Hub|Type\nSize|a. Domestic Revenue" +
								 "|a. Domestic Revenue|a. Domestic Revenue|a. Domestic Revenue|a. Domestic Revenue|a. Domestic Revenue|a. Domestic Revenue" +
								 "|b. Domestic Rail Payout|b. Domestic Rail Payout|b. Domestic Rail Payout|c. Domestic Cost (b-a)|c. Domestic Cost (b-a)|d. Simulated Empty Repo|d. Simulated Empty Repo|d. Simulated Empty Repo" +
								 "|e. Domestic Savings (d-c)|e. Domestic Savings (d-c)|e. Domestic Savings (d-c)|e. Domestic Savings (d-c)" +
								 "|TRP\nVolume" +
								 "|TRP Cost|TRP Cost" +
								 "|Simulated empty repo" +
								 "|TRP savings|TRP savings|TRP savings" +
				 				 "|Off-hire|Off-hire|Off-hire|Off-hire" +
				 				 "|Total" +
				 				 "|Simulated empty repo" +
				 				 "|EQ Off-hire Saving|EQ Off-hire Saving|EQ Off-hire Saving" +
				 				 "|DRP Cost\n(Distributed\nper DRP Vol.)|Unit Cost\n(Divided by\nFull I/B Vol.) (B)|Revised Saving\n(A)-(B)| " +
				 				 "|Creation|Creation";

		        var HeadTitle2 = "||Month|ECC|Rail Hub|Type\nSize|Volume" +
		        				 "|Railage|EQ Rental|Fuel Surcharge|Hazmat|Total|Unit Cost" +
		        				 "|Volume|Total|Unit Cost|Total|Unit Cost|Total|Initial Unit Cost|Unit Cost" +
		        				 "|Total|I/B\n Volume|Initial Credit Per Box|Credit Per Box" +
								 "|TRP\nVolume" +
		        				 "|Cost Total|Cost per box" +
		        				 "|a. Total" +
		        				 "|Savings\ntotal|b. Init credit per box|b. credit per box" +
				 				 "|EQ Off-hire|Sub lease out|Disposal|CN Domestic" +
					 			 "|Total" +
   				 				 "|Total" +
   				 				 "|Total|Init Unit cost|Unit cost" +
				 				 "|DRP Cost\n(Distributed\nper DRP Vol.)|Unit Cost\n(Divided by\nFull I/B Vol.) (B)|Revised Saving\n(A)-(B)| " +
   				 				 "|DateTime|UserId";

		        var headCount = ComCountHeadTitle(HeadTitle1);
				
				headCount = ComCountHeadTitle(HeadTitle1);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
				InitHeadMode(true, false, true, true, false,false);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				
		        //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++,  dtHiddenStatus,	  0,	daCenter,  false,	"ibflag");
				InitDataProperty(0, cnt++ , dtHidden,     	  0,	daCenter,	true,	"row_num");
				InitDataProperty(0, cnt++ , dtData,			 60,	daCenter,	true,	"cost_yrmon"			,false,"",dfNone,		0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,			 70,	daCenter,	true,	"org_rail_loc_cd"		,false,"",dfNone,		0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"rail_hub"				,false,"",dfNone,		0,  false,   false);
				InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	true,	"cntr_tpsz_cd"			,false,"",dfNone,		0,  false,   false);				
				InitDataProperty(0, cnt++ , dtAutoSum,		 60,	daRight,	true,	"dmst_vol_qty"			,false,"",dfInteger,	0,  false,   false);
				
				InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"railg_amt"				,false,"",dfFloatOrg,	2,  false,   false);
				InitDataProperty(0, cnt++ , dtAutoSum,		 90,	daRight,	true,	"eq_rntl_scg_amt"		,false,"",dfFloatOrg,	2,  false,   false);
				InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"fuel_scg_amt"			,false,"",dfFloatOrg,	2,  false,   false);
				InitDataProperty(0, cnt++ , dtAutoSum,		 80,	daRight,	true,	"hzd_mtrl_scg_amt"		,false,"",dfFloatOrg,	2,  false,   false);
				InitDataProperty(0, cnt++ , dtAutoSum,		 90,	daRight,	true,	"dmst_ttl_frt_rev_amt"	,false,"",dfFloatOrg,	2,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		     80,	daRight,    true,	"dom_rev_uc_amt"	    ,false,"",dfFloatOrg,	2,  false,   false);
				
				InitDataProperty(0, cnt++ , dtAutoSum,		 60,	daRight,	true,	"rail_so_vol_qty"		,false,"",dfInteger,	0,  false,   false);
				InitDataProperty(0, cnt++ , dtAutoSum,		 90,	daRight,	true,	"rail_agmt_amt"			,false,"",dfFloatOrg,	2,  false,   false);
				InitDataProperty(0, cnt++ , dtData,		     80,	daRight,    true,	"rail_uc_amt"	        ,false,"",dfFloatOrg,	2,  false,   false);
				InitDataProperty(0, cnt++ , dtAutoSum,	    100,	daRight,	true,	"usa_dmst_cost_amt"		,false,"",dfFloatOrg,	2,  false,   false);
				InitDataProperty(0, cnt++ , dtData,			 80,	daRight,	true,	"usa_dmst_uc_amt"		,false,"",dfFloatOrg,	2,  false,   false);
				InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"sim_mty_cost_amt"		,false,"",dfFloatOrg,	2,  false,   false);
				InitDataProperty(0, cnt++ , dtHidden,	    100,	daRight,	true,	"init_sim_mty_uc_amt"	,false,"",dfFloatOrg,	2,	false,   false);
				InitDataProperty(0, cnt++ , dtData,			 80,	daRight,	true,	"sim_mty_uc_amt"		,false,"",dfFloatOrg,	2,	 true,    true);
							
				InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"usa_dmst_sav_cost_amt"	,false,"",dfFloatOrg,	2,  false,   false);
				InitDataProperty(0, cnt++ , dtAutoSum,		 60,	daRight,	true,	"fcntr_ib_vol_qty"		,false,"",dfInteger,	0,  false,   false);
				InitDataProperty(0, cnt++ , dtHidden,	     70,	daRight,	true,	"init_usa_dmst_sav_ut_amt"	,false,"",dfFloatOrg,2,	false,   false);
				InitDataProperty(0, cnt++ , dtData,			 70,	daRight,	true,	"usa_dmst_sav_ut_amt"	,false,"",dfFloatOrg,	2,	 true,    true);
				
				InitDataProperty(0, cnt++ , dtAutoSum,		 60,	daRight,	true,	"trp_qty"				,false,"",dfInteger,	0,  false,   false);
				
				InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"trp_amt"				,false,"",dfFloatOrg,	2,  false,   false);
				InitDataProperty(0, cnt++ , dtAutoSum,		 90,	daRight,	true,	"trp_uc_amt"			,false,"",dfFloatOrg,	2,  false,   false);
				
				InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"trp_sim_mty_cost_amt"	,false,"",dfFloatOrg,	2,  false,   false);
				
				InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"trp_sav_amt"			,false,"",dfFloatOrg,	2,  false,   false);
				InitDataProperty(0, cnt++ , dtHidden,	     70,	daRight,	true,	"trp_cr_uc_init_amt"	,false,"",dfFloatOrg,	2,	false,   false);
				InitDataProperty(0, cnt++ , dtData,			 70,	daRight,	true,	"trp_cr_uc_amt"			,false,"",dfFloatOrg,	2,	 true,    true);			
				
				InitDataProperty(0, cnt++ , dtAutoSum,		 60,	daRight,	true,	"eq_offh_qty"				,false,"",dfInteger,	0,  false,   false);
				InitDataProperty(0, cnt++ , dtAutoSum,		 60,	daRight,	true,	"sub_lse_out_qty"			,false,"",dfInteger,	0,  false,   false);
				InitDataProperty(0, cnt++ , dtAutoSum,		 60,	daRight,	true,	"disp_qty"					,false,"",dfInteger,	0,  false,   false);
				InitDataProperty(0, cnt++ , dtAutoSum,		 60,	daRight,	true,	"cnd_dmst_qty"				,false,"",dfInteger,	0,  false,   false);
				
				InitDataProperty(0, cnt++ , dtAutoSum,		 60,	daRight,	true,	"offh_ttl_qty"				,false,"",dfInteger,	0,  false,   false);
				
				InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"offh_sim_mty_cost_amt"		,false,"",dfFloatOrg,	2,  false,   false);
								
				InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,	"eq_offh_sav_amt"			,false,"",dfFloatOrg,	2,  false,   false);
				InitDataProperty(0, cnt++ , dtHidden,	     70,	daRight,	true,	"eq_offh_sav_uc_init_amt"	,false,"",dfFloatOrg,	2,	false,   false);
				InitDataProperty(0, cnt++ , dtData,			 70,	daRight,	true,	"eq_offh_sav_uc_amt"		,false,"",dfFloatOrg,	2,	 true,    true);

				InitDataProperty(0, cnt++ , dtAutoSum,		130,	daRight,	true,	"dmst_rail_inv_amt"  		,false,"",dfFloatOrg,	2,	false,   false);
				InitDataProperty(0, cnt++ , dtData,			130,	daRight,	true,	"eq_offh_uc_amt"     		,false,"",dfFloatOrg,	2,	false,   false);
				InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"eq_offh_fnl_uc_amt"		,false,"",dfFloatOrg,	2,	 true,    true);
				InitDataProperty(0, cnt++ , dtHidden,		 80,	daRight,	true,	"eq_offh_fnl_uc_init_amt"   ,false,"",dfFloatOrg,	2,	false,   false);
				
				InitDataProperty(0, cnt++ , dtData,			 70,	daRight,	true,	"cre_dt"					,false,"",dfNone,		2,	false,   false);
				InitDataProperty(0, cnt++ , dtData,			 70,	daRight,	true,	"cre_usr_id"				,false,"",dfNone,		2,	false,   false);

				WaitImageVisible = false;					
//				CountPosition = 0;
				SelectHighLight= true;
				// 문장이 길경우 ...으로 표시함
				Ellipsis = true;
				
        	}
        	break;
        }
    }
    
    /**
     * Sheet관련 프로세스 처리<br>
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {

    	sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {

        	case IBSEARCH:	// ECC, LCC, RCC 콤보박스 조회
        		
        		//sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0014GS.do", masFormQueryString(formObj));
				
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_ecc_cd, "code", "code");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_cntr_tpsz_cd, "code", "code");
				
				ComOpenWait(false);
				break;
			
				
			case SEARCH01: // 화면 조회

				if(!validateForm(sheetObj,formObj,sAction)) return false;

				//for ( var i = 0; i < sheetObjects.length; i++) sheetObjects[i].WaitImageVisible = false;
  				ComOpenWait(true);

				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0014GS.do", masFormQueryString(formObj));
								
  				sheetObjects[0].Redraw = false;
  				sheetObjects[1].Redraw = false;
  				sheetObjects[2].Redraw = false;
  				sheetObjects[3].Redraw = false;
  				
				for ( var i = 0; i < sheetObjects.length; i++) sheetObjects[i].LoadSearchXml(sXml);
  				
  				sheetObjects[3].Redraw = true;
  				sheetObjects[2].Redraw = true;
  				sheetObjects[1].Redraw = true;
  				sheetObjects[0].Redraw = true;
  				
  				ComOpenWait(false);
  				break;

  				
			case IBDOWNEXCEL: // 엑셀파일 다운
				if (!validateForm(sheetObj,formObj,sAction)) return;
				ComOpenWait(true);
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "sel", "");
				ComOpenWait(false);
				break;

				
			case MULTI01: // 수정한 cost 저장

				if( !ComShowConfirm(ComGetMsg("COM130101"))) {
	            	return false;
	            }

				//sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				
				formObj.f_cmd.value = MULTI01;
				if ( sheetObj.DoSave("ESM_MAS_0014GS.do", masFormQueryString(formObj), -1, false) ) {
					ComShowMessage(ComGetMsg("MAS10006"));
				}
				ComOpenWait(false);
				break;
				
				
			case COMMAND01 : // 데이터 create
				
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				
				if( formObj.mas_ut_cost_cre_sts_cnt.value == 0 && !ComShowConfirm(ComGetMsg("MAS10020"))) {
	            	return false;
	            }

				var sParam = "";  
            	formObj.f_cmd.value = COMMAND01;
				sParam += "&" + masFormQueryString(formObj);
				//sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
 				var sXml = sheetObj.GetSaveXml("ESM_MAS_0014GS.do", sParam)
				var key = ComGetEtcData(sXml, "KEY");
				intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
				
				
            	break;
            
            	
			case SEARCH02 : // CREATE 하기 전 MAS_MTY_ECC_UT_COST & MAS_UT_COST_CRE_STS 테이블 데이터 유무 확인
				
				if(!validateForm(sheetObj,formObj,sAction))return;
				
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0014GS.do", masFormQueryString(formObj));
	    		var mtyEccUtCostCnt = ComGetEtcData(sXml, "mas_mty_ecc_ut_cost_cnt");
	    		var utCostCreStsCnt = ComGetEtcData(sXml, "mas_ut_cost_cre_sts_cnt");

				formObj.mas_mty_ecc_ut_cost_cnt.value = mtyEccUtCostCnt;
				formObj.mas_ut_cost_cre_sts_cnt.value = utCostCreStsCnt;
				break;
        }
        
    }
    
    /**
     * BackEndJob 실행결과조회<br>
     * 
     * @param sheetObj
     * @param sKey
     */
    function doActionValidationResult(sheetObj, sKey) {
    	var sXml = sheetObj.GetSearchXml("ESM_MAS_0014GS.do?f_cmd=" + COMMAND02 + "&key=" + sKey);
    	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");

    	//ComShowMessage("doActionValidationResult "+sJbStsFlg);
    	
    	if (sJbStsFlg == "SUCCESS") {
    		//sheetObj.WaitImageVisible = true;
    		// 성공메시지 보여주고
    		clearInterval(intervalId);
    		setPeriod(document.form.f_cost_yrmon);
			
    		doActionIBSheet(sheetObj, document.form, SEARCH01);
    		ComShowMessage(ComGetMsg("MAS00004","Data"));
    		
    		ComOpenWait(false);
    	} else if (sJbStsFlg == "FAIL") {
    		//에러
    		ComOpenWait(false);
    		//sheetObj.WaitImageVisible = true;
    		// 에러메시지 보여주고
    		ComShowMessage(ComGetMsg("MAS00001"));
    		clearInterval(intervalId);
    	}
    }

    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	
	    switch(sAction) {
	    
	    	case SEARCH01: { // Retrieve
	    		//기본포멧체크
				if (!ComChkValid(formObj)) return false;
				
				if(formObj.f_cost_yrmon.value == "") {
		  			ComShowCodeMessage('MAS10002', 'YYYY-MM');
		  			ComSetFocus(formObj.f_cost_yrmon);
		  			return false;	
		  		}
		  		
		  		if(!ComIsDate(formObj.f_cost_yrmon , "ym")){
		  			ComShowCodeMessage('COM12180');
		  			ComSetFocus(formObj.f_cost_yrmon);
		  			return false;	
		  		} else {
		  			return true;
		  		}	
				break;
	    	}
	
	    	case COMMAND01: {
	    		
	    		if(formObj.f_cost_yrmon.value == "") {
	    			ComShowCodeMessage('MAS10002', 'YYYY-MM');
	    			ComSetFocus(formObj.f_cost_yrmon);
	    			return false;	
	    		}
	    		
	    		if(!ComIsDate(formObj.f_cre_start_dt , "ym")){
	    			ComShowCodeMessage('COM12180');
	    			ComSetFocus(formObj.f_cre_start_dt);
	    			return false;	
	    		}
	    		
	    		if(!ComIsDate(formObj.f_cre_end_dt , "ym")){
	    			ComShowCodeMessage('COM12180');
	    			ComSetFocus(formObj.f_cre_end_dt);
	    			return false;	
	    		} 
	    		
	    		if(formObj.f_cre_start_dt.value == "" || formObj.f_cre_end_dt.value == "") {
		  			ComShowCodeMessage('MAS10015', 'Period');
		  			ComSetFocus(formObj.f_cre_start_dt);
		  			return false;	
		  		}
	    		
	    		if (formObj.f_cre_start_dt.value > formObj.f_cre_end_dt.value) {
	    			// [MAS10011] = Month의 From는(은) To보다 적거나 같아야 합니다.
	    			ComShowMessage(ComGetMsg("MAS10011","Month","From","To"));
	    			ComSetFocus(formObj.f_cre_start_dt);   			
	    			return false;
	    		}
/*
	    		if(ComParseInt(formObj.f_cre_end_dt.value.replace(eval("/-/gi"), ""))
	    				-ComParseInt(formObj.f_cre_start_dt.value.replace(eval("/-/gi"), "")) > 7){
                    ComShowMessage(ComGetMsg("MAS10003", "Creation month", "6 months"));
                    ComSetFocus(formObj.f_cre_start_dt);
                    return false;
	    		}
*/	    		
	    		if(ComGetUnMaskedValue(formObj.f_cre_start_dt.value, "ym")+"01" < ComGetDateAdd(formObj.f_cre_end_dt.value + "01", "M", -5,"")){
                    ComShowMessage(ComGetMsg("MAS10003", "Creation month", "6 months"));
                    ComSetFocus(formObj.f_cre_start_dt);
                    return false;
	    		}
	    		
	    		doActionIBSheet(sheetObj, document.form, SEARCH02);

	    		if(formObj.mas_mty_ecc_ut_cost_cnt.value == 0) {
		  			ComShowCodeMessage('MAS10015', 'MT repo simulated cost');
		  			return false;	
		  		}
	    		
	    		if(formObj.mas_ut_cost_cre_sts_cnt.value > 0) {
					if(!ComShowConfirm("Do you want to re-create empty repo credit table? Once confirmed, the current data will be removed")) {
		            	return false;
		            }
		  		}
	    		
	    		break;
			}
	    	
	    	case SEARCH02: {
	    		
	    		if(formObj.f_cost_yrmon.value == "") {
		  			ComShowCodeMessage('MAS10002', 'YYYY-MM');
		  			ComSetFocus(formObj.f_cost_yrmon);
		  			return false;	
		  		}
	    		break;
			}
	    }
        return true;
    }  	
  	
  	/**
     * Rev Detail 컬럼 view 여부
     */
  	function viewRevDetail(){
  		var sheetObj = sheetObjects[0];
  		var formObj = document.form;

  		if(formObj.f_dom_rev_det.checked){
  			sheetObj.ColHidden("railg_amt")			= false;
  			sheetObj.ColHidden("eq_rntl_scg_amt")	= false;
  			sheetObj.ColHidden("fuel_scg_amt")		= false;
  			sheetObj.ColHidden("hzd_mtrl_scg_amt")	= false;
  		} else {
  			sheetObj.ColHidden("railg_amt")			= true;
  			sheetObj.ColHidden("eq_rntl_scg_amt")	= true;
  			sheetObj.ColHidden("fuel_scg_amt")		= true;
  			sheetObj.ColHidden("hzd_mtrl_scg_amt")	= true;
  		}
  	}
  	
  	
 	/**
 	 * Tab 클릭시 이벤트 관련
 	 * 선택한 탭의 요소가 활성화 된다.
 	 */
 		function tab1_OnChange(tabObj , nItem){
 			var objs = document.all.item("tabLayer");
 			var formObj = document.form;

 			objs[nItem].style.display = "inline";
 			objs[beforetab1].style.display = "none";
 			//--------------- 요기가 중요 --------------------------//
 			var pre_idx =  objs[nItem].style.zIndex;
 			pre_idx--;
 			objs[beforetab1].style.zIndex = pre_idx ;
 			//------------------------------------------------------//

 			beforetab1= nItem;
 			var drdTable = document.getElementById("drd_table");
 			if ( nItem != 0 ) {
 				drdTable.style.display = "none";
 			} else {
 				drdTable.style.display = "inline";
 			}
 		}

   	/**
   	 * 현재 Tab Sheet 의 변경사항을 다른 Tab Sheet 및 통합 sheet ( 저장용 ) 에 적용 한다.
   	 * 
   	 * @param sheetObj 시트오브젝트
   	 * @param idx 변경된 Sheet 의 sheetObjects 상의 Index 
   	 * @param row Long 해당 셀의 Row Index 
   	 * @param col Long 해당 셀의 Column Index 
   	 * @param val 변경된 값, Format이 적용되지 않은 저장 시 사용되는  
   	 * 
   	 */
 	 function shareModified(sheetObj, idx, row, col, sValue ){
 		 var rowNum = sheetObj.CellValue ( row, "row_num" );
 		 var colName = sheetObj.ColSaveName ( col );
 		 var destSheetArray = new Array();
 		 var j = 0;
 		 var destRow = 0;
 		 var destCol = 0;
 		 
 		 sheetObj.CellValue2 ( row, "ibflag" ) = "R";
 		 
 		 for ( var i = 0; i < sheetObjects.length; i++ ) {
 			 if ( i != idx ) {
 				 destSheetArray[j] = sheetObjects[i];
 				 j++;
 			 }
 		 }
 		 for ( i = 0; i < destSheetArray.length; i++ ) {
 			 destRow = destSheetArray[i].FindText ( "row_num", rowNum );
 			 destCol = destSheetArray[i].SaveNameCol ( colName );
 			// CellValue 에 Assign 하여 OnChange Event 가 기동될 때 
 			// sharedModified 가 다시 실행되어 무한 루프에 빠지지 않도록 하기 위해서
 			// 2012.11.19 송호진
 			 triggerEvent = true; 
 			 if ( destCol != -1 ) {
 				 destSheetArray[i].CellValue ( destRow, destCol ) = sValue;
 			 }
 			 triggerEvent = false;
 			 if ( i != destSheetArray.length - 1 )destSheetArray[i].CellValue2 ( destRow, "ibflag" ) = "R";
 			 else destSheetArray[i].CellValue2 ( destRow, "ibflag" ) = "U";
 		 }
 	 }
  	/**
  	 * sheet1 Empty repo unit cost 변경시 영향있는 셀의 값 변경
  	 * 
  	 * @param sheetObj 시트오브젝트
  	 * @param row Long 해당 셀의 Row Index 
  	 * @param col Long 해당 셀의 Column Index 
  	 * @param val 변경된 값, Format이 적용되지 않은 저장 시 사용되는  
  	 * 
  	 */
  	function sheet1_OnChange(sheetObj, row, col, sValue) {
  		
  		var colSaveName = sheetObj.ColSaveName(col);
  		switch(colSaveName) {	    	
  		
  		case "sim_mty_uc_amt":
  			
  			sheetObj.CellValue2(row, "sim_mty_cost_amt") 
  			= sValue * sheetObj.CellValue(row, "rail_so_vol_qty");
  			
  			sheetObj.CellValue2(row, "usa_dmst_sav_cost_amt") 
  			= sheetObj.CellValue(row, "sim_mty_cost_amt") - sheetObj.CellValue(row, "usa_dmst_cost_amt");
  			
  			sheetObj.CellValue2(row, "usa_dmst_sav_ut_amt") 
  			= sheetObj.CellValue(row, "usa_dmst_sav_cost_amt") / sheetObj.CellValue(row, "fcntr_ib_vol_qty");
  			
  			if ( sValue != sheetObj.CellValue(row, "init_sim_mty_uc_amt") ) sheetObj.CellFontColor(row,"sim_mty_uc_amt") = RED_COLOR;
  			else sheetObj.CellFontColor(row,"sim_mty_uc_amt" ) = BLK_COLOR;
  			
  			sheetObj.SumValue(0, "sim_mty_uc_amt")
  				= sheetObj.SumValue(0, "sim_mty_cost_amt") / sheetObj.SumValue(0, "rail_so_vol_qty");

  			sheetObj.SumValue(0, "usa_dmst_sav_ut_amt")
  				= sheetObj.SumValue(0, "usa_dmst_sav_cost_amt") / sheetObj.SumValue(0, "fcntr_ib_vol_qty");
  			
  			break;
  		} // end switch
  		
		if ( sheetObj.CellValue(row, "usa_dmst_sav_ut_amt") != sheetObj.CellValue(row, "init_usa_dmst_sav_ut_amt")) sheetObj.CellFontColor(row,"usa_dmst_sav_ut_amt")  = RED_COLOR;
		else sheetObj.CellFontColor(row,"usa_dmst_sav_ut_amt" ) = BLK_COLOR;
  		
  		if ( !triggerEvent) shareModified ( sheetObj, 0, row, col, sValue );
  		
  	}//method end
  	
  	
  	
  	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
  		with (sheetObj) {
 			CellFontColor(LastRow ,"sim_mty_uc_amt") 		= CellFontColor(HeaderRows ,"sim_mty_uc_amt");
 			CellFontColor(LastRow ,"usa_dmst_sav_ut_amt") 	= CellFontColor(HeaderRows ,"usa_dmst_sav_ut_amt");
  
  			for(var i= HeaderRows; i<= LastRow; i++) { 
  				
  				if (CellValue(i, "sim_mty_uc_amt") != CellValue(i, "init_sim_mty_uc_amt")) {
  					CellFontColor(i,"sim_mty_uc_amt") = RgbColor(255, 0, 0);
  				}  			
  				
  				if (CellValue(i, "usa_dmst_sav_ut_amt") != CellValue(i, "init_usa_dmst_sav_ut_amt")) {
  					CellFontColor(i,"usa_dmst_sav_ut_amt") = RgbColor(255, 0, 0);
  				}  				
  			}
  			
  			if ( sheetObj.SumValue(0, "rail_so_vol_qty") != 0 ) {
	  			sheetObj.SumValue(0, "usa_dmst_uc_amt")
	  				= eval(sheetObj.SumValue(0, "usa_dmst_cost_amt") + "/" + sheetObj.SumValue(0, "rail_so_vol_qty")).toFixed(2) ;
	  			sheetObj.SumValue(0, "sim_mty_uc_amt")
	  				= eval(sheetObj.SumValue(0, "sim_mty_cost_amt") + "/" + sheetObj.SumValue(0, "rail_so_vol_qty")).toFixed(2) ;
	  			sheetObj.SumValue(0, "rail_uc_amt")
  					= eval(sheetObj.SumValue(0, "rail_agmt_amt") + "/" + sheetObj.SumValue(0, "rail_so_vol_qty")).toFixed(2) ;
  			} else {
	  			sheetObj.SumValue(0, "usa_dmst_uc_amt") = 0.0;
	  			sheetObj.SumValue(0, "sim_mty_uc_amt") = 0.0;
	  			sheetObj.SumValue(0, "rail_uc_amt") = 0.0;
  				
  			}
  			if ( sheetObj.SumValue(0, "fcntr_ib_vol_qty") != 0 ) {
  				sheetObj.SumValue(0, "usa_dmst_sav_ut_amt")
  					= eval(sheetObj.SumValue(0, "usa_dmst_sav_cost_amt") + "/" + sheetObj.SumValue(0, "fcntr_ib_vol_qty")).toFixed(2) ;
  			} else {
  				sheetObj.SumValue(0, "usa_dmst_sav_ut_amt") = 0.0;  				
  			}
  			if ( sheetObj.SumValue(0, "dmst_vol_qty") != 0 ) {
  				sheetObj.SumValue(0, "dom_rev_uc_amt")
  					= eval(sheetObj.SumValue(0, "dmst_ttl_frt_rev_amt") + "/" + sheetObj.SumValue(0, "dmst_vol_qty")).toFixed(2) ;
  			} else {
  				sheetObj.SumValue(0, "dom_rev_uc_amt") = 0.0;
  				
  			}
  			
  			
  	    }//end with
  	}

  	
  	
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
		
  		var state = sheetObj.EtcData("TRANS_RESULT_KEY");
		
		if (state == "S") {
			ComShowMessage(ComGetMsg("MAS00004","Data"));
			doActionIBSheet(sheetObj, document.form, SEARCH01);
		} else {
			ComShowMessage(ComResultMessage(sXml));
		}
		
	}
  	
  	
  	/**
 	 * sheet2 Empty repo unit cost 변경시 영향있는 셀의 값 변경
 	 * 
 	 * @param sheetObj 시트오브젝트
 	 * @param row Long 해당 셀의 Row Index 
 	 * @param col Long 해당 셀의 Column Index 
 	 * @param val 변경된 값, Format이 적용되지 않은 저장 시 사용되는  
 	 * 
 	 */
 	function sheet2_OnChange(sheetObj,row, col, sValue) {
 		
 		var colSaveName = sheetObj.ColSaveName(col);
 		switch(colSaveName) {	    	
 		
 		case "sim_mty_uc_amt":
 			
 			sheetObj.CellValue2(row, "trp_sim_mty_cost_amt") 
 			= sValue * sheetObj.CellValue(row, "trp_qty");
 			
 			sheetObj.CellValue2(row, "trp_sav_amt") 
 			= sheetObj.CellValue(row, "trp_sim_mty_cost_amt") - sheetObj.CellValue(row, "trp_amt");
 			
 			sheetObj.CellValue2(row, "trp_cr_uc_amt") 
 			= sheetObj.CellValue(row, "trp_sav_amt") / sheetObj.CellValue(row, "fcntr_ib_vol_qty");
 			
  			if ( sValue != sheetObj.CellValue(row, "init_sim_mty_uc_amt") )	sheetObj.CellFontColor(row,"sim_mty_uc_amt") = RED_COLOR;
  			else sheetObj.CellFontColor(row,"sim_mty_uc_amt" ) = BLK_COLOR;
  			

  			sheetObj.SumValue(0, "sim_mty_uc_amt")
  				= sheetObj.SumValue(0, "trp_sim_mty_cost_amt") / sheetObj.SumValue(0, "trp_qty");

  			sheetObj.SumValue(0, "trp_cr_uc_amt")
  				= sheetObj.SumValue(0, "trp_sav_amt") / sheetObj.SumValue(0, "fcntr_ib_vol_qty");
  			
  			break;

 		} // end switch
 		
		if ( sheetObj.CellValue(row, "trp_cr_uc_amt") != sheetObj.CellValue(row, "trp_cr_uc_init_amt")) sheetObj.CellFontColor(row,"trp_cr_uc_amt")  = RED_COLOR;
		else sheetObj.CellFontColor(row,"trp_cr_uc_amt" ) = BLK_COLOR;
  		
  		if ( !triggerEvent) shareModified ( sheetObj, 1, row, col, sValue );
		
 	}//method end
 	
 	
 	
 	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
 		with (sheetObj) {
 			CellFontColor(LastRow ,"sim_mty_uc_amt") 	= CellFontColor(HeaderRows ,"sim_mty_uc_amt");
 			CellFontColor(LastRow ,"trp_cr_uc_amt") 	= CellFontColor(HeaderRows ,"trp_cr_uc_amt");
 
 			for(var i= HeaderRows; i<= LastRow; i++) { 
 				
 				if (CellValue(i, "sim_mty_uc_amt") != CellValue(i, "init_sim_mty_uc_amt")) {
 					CellFontColor(i,"sim_mty_uc_amt") = RgbColor(255, 0, 0);
 				}  			
 				
 				if (CellValue(i, "trp_cr_uc_amt") != CellValue(i, "trp_cr_uc_init_amt")) {
 					CellFontColor(i,"trp_cr_uc_amt") = RgbColor(255, 0, 0);
 				}
 			} 
						
  			if ( SumValue(0, "trp_qty") != 0 ) {
	  			SumValue(0, "sim_mty_uc_amt")
	  				= eval(SumValue(0, "trp_sim_mty_cost_amt") + "/" + SumValue(0, "trp_qty")).toFixed(2) ;
  			} else {
	  			SumValue(0, "sim_mty_uc_amt") = 0.0;
  			}
  			if ( SumValue(0, "fcntr_ib_vol_qty") != 0 ) {
  				SumValue(0, "trp_cr_uc_amt")
  					= eval(SumValue(0, "trp_sav_amt") + "/" + SumValue(0, "fcntr_ib_vol_qty")).toFixed(2) ;
  			} else {
  				SumValue(0, "trp_cr_uc_amt") = 0.0;  				
  			}
  			if ( SumValue(0, "trp_qty") != 0 ) {
  				SumValue(0, "trp_uc_amt")
  				= eval(SumValue(0, "trp_amt") + "/" + SumValue(0, "trp_qty")).toFixed(2) ;
  			} else {
  				SumValue(0, "trp_uc_amt") = 0.0;  				
  			}
 	    }//end with
 	}

 	
 	
 	function sheet2_OnSaveEnd(sheetObj,errMsg){
		
 		var state = sheetObj.EtcData("TRANS_RESULT_KEY");
		
		if (state == "S") {
			ComShowMessage(ComGetMsg("MAS00004","Data"));
			doActionIBSheet(sheetObj, document.form, SEARCH01);
		} else {
			ComShowMessage(ComResultMessage(sXml));
		}
		
	}
 	
  	
  	/**
 	 * sheet3 Empty repo unit cost 변경시 영향있는 셀의 값 변경
 	 * 
 	 * @param sheetObj 시트오브젝트
 	 * @param row Long 해당 셀의 Row Index 
 	 * @param col Long 해당 셀의 Column Index 
 	 * @param val 변경된 값, Format이 적용되지 않은 저장 시 사용되는  
 	 * 
 	 */
 	function sheet3_OnChange(sheetObj, row, col, sValue) {
 		
 		var colSaveName = sheetObj.ColSaveName(col);
 		switch(colSaveName) {	    	
 		
 		case "sim_mty_uc_amt":
 			
 			sheetObj.CellValue2(row, "offh_sim_mty_cost_amt") 
 			= sValue * sheetObj.CellValue(row, "offh_ttl_qty");
 			
 			sheetObj.CellValue2(row, "eq_offh_sav_amt") 
 			= sheetObj.CellValue(row, "offh_sim_mty_cost_amt");
 			
 			sheetObj.CellValue2(row, "eq_offh_sav_uc_amt") 
 			= sheetObj.CellValue(row, "eq_offh_sav_amt") / sheetObj.CellValue(row, "fcntr_ib_vol_qty");
 			
  			if ( sValue != sheetObj.CellValue(row, "init_sim_mty_uc_amt") )	sheetObj.CellFontColor(row,"sim_mty_uc_amt") = RED_COLOR;
  			else sheetObj.CellFontColor(row,"sim_mty_uc_amt" ) = BLK_COLOR;
  			
  			sheetObj.CellValue2(row, "eq_offh_fnl_uc_amt") = sheetObj.CellValue(row, "eq_offh_sav_uc_amt") - sheetObj.CellValue(row, "eq_offh_uc_amt");
  			
  			if ( sheetObj.CellValue(row, "eq_offh_fnl_uc_amt") != sheetObj.CellValue(row, "eq_offh_fnl_uc_init_amt") )	sheetObj.CellFontColor(row,"eq_offh_fnl_uc_amt") = RED_COLOR;
 			else sheetObj.CellFontColor(row,"eq_offh_fnl_uc_amt" ) = BLK_COLOR;
  			

  			sheetObj.SumValue(0, "sim_mty_uc_amt")
  				= sheetObj.SumValue(0, "offh_sim_mty_cost_amt") / sheetObj.SumValue(0, "offh_ttl_qty");

  			sheetObj.SumValue(0, "eq_offh_sav_uc_amt")
  				= sheetObj.SumValue(0, "eq_offh_sav_amt") / sheetObj.SumValue(0, "fcntr_ib_vol_qty");
  			
  			sheetObj.SumValue(0, "eq_offh_fnl_uc_amt")
  			    = sheetObj.SumValue(0, "eq_offh_sav_uc_amt") - sheetObj.SumValue(0, "eq_offh_uc_amt");
  			  			
  			break;
  			
 		case "eq_offh_sav_uc_amt":
 			
 			sheetObj.CellValue2(row, "eq_offh_fnl_uc_amt") = sValue - sheetObj.CellValue(row, "eq_offh_uc_amt");
 			
 			if ( sheetObj.CellValue(row, "eq_offh_fnl_uc_amt") != sheetObj.CellValue(row, "eq_offh_fnl_uc_init_amt") )	sheetObj.CellFontColor(row,"eq_offh_fnl_uc_amt") = RED_COLOR;
 			else sheetObj.CellFontColor(row,"eq_offh_fnl_uc_amt" ) = BLK_COLOR;
 			
 			break;

 		} // end switch
 		
		if ( sheetObj.CellValue(row, "eq_offh_sav_uc_amt") != sheetObj.CellValue(row, "eq_offh_sav_uc_init_amt")) sheetObj.CellFontColor(row,"eq_offh_sav_uc_amt")  = RED_COLOR;
		else sheetObj.CellFontColor(row,"eq_offh_sav_uc_amt" ) = BLK_COLOR;
		
		if ( sheetObj.CellValue(row, "eq_offh_fnl_uc_amt") != sheetObj.CellValue(row, "eq_offh_fnl_uc_init_amt")) sheetObj.CellFontColor(row,"eq_offh_fnl_uc_amt")  = RED_COLOR;
		else sheetObj.CellFontColor(row,"eq_offh_fnl_uc_amt" ) = BLK_COLOR;
  		
  		if ( !triggerEvent) shareModified ( sheetObj, 2, row, col, sValue );
		
 	}//method end
 	
 	
 	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
 		with (sheetObj) {
 			CellFontColor(LastRow ,"sim_mty_uc_amt") 		= CellFontColor(HeaderRows ,"sim_mty_uc_amt");
 			CellFontColor(LastRow ,"eq_offh_sav_uc_amt") 	= CellFontColor(HeaderRows ,"eq_offh_sav_uc_amt");

 			for(var i= HeaderRows; i<= LastRow; i++) { 
 				
 				if (CellValue(i, "sim_mty_uc_amt") != CellValue(i, "init_sim_mty_uc_amt")) {
 					CellFontColor(i,"sim_mty_uc_amt") = RgbColor(255, 0, 0);
 				}  			
 				
 				if (CellValue(i, "eq_offh_sav_uc_amt") != CellValue(i, "eq_offh_sav_uc_init_amt")) {
 					CellFontColor(i,"eq_offh_sav_uc_amt") = RgbColor(255, 0, 0);
 				}
 				
 				if (CellValue(i, "eq_offh_fnl_uc_amt") != CellValue(i, "eq_offh_fnl_uc_init_amt")) {
 					CellFontColor(i,"eq_offh_fnl_uc_amt") = RgbColor(255, 0, 0);
 				}
			} 	
 					
  			if ( SumValue(0, "offh_ttl_qty") != 0 ) {
	  			SumValue(0, "sim_mty_uc_amt")
	  				= eval(SumValue(0, "offh_sim_mty_cost_amt") + "/" + SumValue(0, "offh_ttl_qty")).toFixed(2) ;
  			} else {
	  			SumValue(0, "sim_mty_uc_amt") = 0.0;
  			}
  			if ( SumValue(0, "fcntr_ib_vol_qty") != 0 ) {
  				SumValue(0, "eq_offh_sav_uc_amt")
  					= eval(SumValue(0, "eq_offh_sav_amt") + "/" + SumValue(0, "fcntr_ib_vol_qty")).toFixed(2) ;
  			} else {
  				SumValue(0, "eq_offh_sav_uc_amt") = 0.0;  				
  			}
  			
  			if( SumValue(0, "fcntr_ib_vol_qty") != 0 ) {
  				SumValue(0, "eq_offh_uc_amt")
  				    = eval(SumValue(0, "dmst_rail_inv_amt") + "/" + SumValue(0, "fcntr_ib_vol_qty")).toFixed(2) ;
  			} else {
  				SumValue(0, "eq_offh_uc_amt") = 0.0;  				
  			}
  			
  			SumValue(0, "eq_offh_fnl_uc_amt")
			    = eval(SumValue(0, "eq_offh_sav_uc_amt") + "-" + SumValue(0, "eq_offh_uc_amt")).toFixed(2) ;
 	    }//end with
 	}

 	
 	
 	function sheet3_OnSaveEnd(sheetObj,errMsg){
		
 		var state = sheetObj.EtcData("TRANS_RESULT_KEY");
		
		if (state == "S") {
			ComShowMessage(ComGetMsg("MAS00004","Data"));
			doActionIBSheet(sheetObj, document.form, SEARCH01);
		} else {
			ComShowMessage(ComResultMessage(sXml));
		}
		
	}
 	
 	
  	/**
 	 * sheet4 Empty repo unit cost 변경시 영향있는 셀의 값 변경
 	 * 
 	 * @param sheetObj 시트오브젝트
 	 * @param row Long 해당 셀의 Row Index 
 	 * @param col Long 해당 셀의 Column Index 
 	 * @param val 변경된 값, Format이 적용되지 않은 저장 시 사용되는  
 	 * 
 	 */
 	function sheet4_OnChange(sheetObj, row, col, sValue) {
 		
 		var colSaveName = sheetObj.ColSaveName(col);
 		switch(colSaveName) {	    	
 		
 		case "sim_mty_uc_amt":
 			
 			sheetObj.CellValue2(row, "sim_mty_cost_amt") 
  			= sValue * sheetObj.CellValue(row, "rail_so_vol_qty");
  			
 			sheetObj.CellValue2(row, "usa_dmst_sav_cost_amt") 
  			= sheetObj.CellValue(row, "sim_mty_cost_amt") - sheetObj.CellValue(row, "usa_dmst_cost_amt");
  			
 			sheetObj.CellValue2(row, "usa_dmst_sav_ut_amt") 
  			= sheetObj.CellValue(row, "usa_dmst_sav_cost_amt") / sheetObj.CellValue(row, "fcntr_ib_vol_qty");
 			
 			sheetObj.CellValue2(row, "trp_sim_mty_cost_amt") 
 			= sValue * sheetObj.CellValue(row, "trp_qty");
 			
 			sheetObj.CellValue2(row, "trp_sav_amt") 
 			= sheetObj.CellValue(row, "trp_sim_mty_cost_amt") - sheetObj.CellValue(row, "trp_amt");
 			
 			sheetObj.CellValue2(row, "trp_cr_uc_amt") 
 			= sheetObj.CellValue(row, "trp_sav_amt") / sheetObj.CellValue(row, "fcntr_ib_vol_qty");
  			
 			sheetObj.CellValue2(row, "offh_sim_mty_cost_amt") 
 			= sValue * sheetObj.CellValue(row, "offh_ttl_qty");
 			
 			sheetObj.CellValue2(row, "eq_offh_sav_amt") 
 			= sheetObj.CellValue(row, "offh_sim_mty_cost_amt");
 			
 			sheetObj.CellValue2(row, "eq_offh_sav_uc_amt") 
 			= sheetObj.CellValue(row, "eq_offh_sav_amt") / sheetObj.CellValue(row, "fcntr_ib_vol_qty");
 			
 			sheetObj.CellValue2(row, "eq_offh_fnl_uc_amt") 
 			= sheetObj.CellValue(row, "eq_offh_sav_uc_amt") - sheetObj.CellValue(row, "eq_offh_uc_amt");
 			break;
 			
 		case "eq_offh_sav_uc_amt":
 			sheetObj.CellValue2(row, "eq_offh_fnl_uc_amt") 
 			= sheetObj.CellValue(row, "eq_offh_sav_uc_amt") - sheetObj.CellValue(row, "eq_offh_uc_amt");
 			
 			break;

 		} // end switch
		
 	}//method end
 	
 	function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
 		var formObj = document.form;
 		with (sheetObj) {
 			if ( sheetObj.TotalRows > 0 ) {
	 			formObj.f_cre_dt.value =  CellValue ( HeaderRows, "cre_dt");
	 			formObj.f_cre_usr_id.value = CellValue ( HeaderRows, "cre_usr_id");
	 			formObj.f_currency.value = "USD";
 			}
 	    }//end with
 	}
  	
 	function setPeriod(obj){
  		
  		var formObj = document.form;
  		var sheetObj = sheetObjects[0];

  		if(obj == null){
            return;
        }
  		
  		if(obj.value == ""){
            if(obj.name == "f_cost_yrmon" ){
                formObj.f_cost_yrmon.value = "";
            } 
            document.getElementById("div_period").innerHTML = "<div id='div_period'></div>";
            return false;
        } else {
            if(!ComIsDate(formObj.f_cost_yrmon , "ym")){
            	document.getElementById("div_period").innerHTML = "<div id='div_period'></div>";
            	return false;	
            }
        }
  		
  		formObj.f_cmd.value = SEARCH03;
		var sXml = sheetObj.GetSearchXml("ESM_MAS_0014GS.do", masFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");

		if (0<arrXml.length) {
			document.getElementById("div_period").innerHTML = "( "+ComGetEtcData(arrXml[0], "period") +" )";
		}
		
		if (ComGetEtcData(arrXml[0], "period") == ""){
			document.getElementById("div_period").innerHTML = "( YYYY-MM ~ YYYY-MM )";
		}
	}
 
  	
    /* 개발자 작업  끝 */
