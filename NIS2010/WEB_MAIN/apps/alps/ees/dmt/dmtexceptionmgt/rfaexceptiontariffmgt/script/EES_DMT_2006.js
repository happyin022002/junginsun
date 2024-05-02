/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2006.js
*@FileTitle : DEM/DET Adjustment Request & Approval Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.08.03 이성훈
* 1.0 Creation
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
     * @class DEM/DET Adjustment Request & Approval Status 조회를 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;

	var comboObjects = new Array();
	var comboCnt = 0;	

	//Action 정의
	var IBSEARCH_TARIFF = 100;
	var IBSEARCH_CUST_NM = 105;	
	
	//업무전역변수
	var ROWMARK 	= "|";
	var FIELDMARK 	= "=";
	
	//S/C Exception Tariff 컬럼명
	var TO_CC 		= "to_cc";
	var SC_NO 		= "sc_no";
	var DAR_NO 		= "dar_no";
	var VER 		= "ver_no";
	var APVL_NO 	= "apvl_no";
	var RFA_NO 		= "rfa_no";
	var PROP_NO 	= "prop_no";
	var STATUS 		= "status";
	var TARIFF 		= "dmdt_trf_cd";
	var CVRG 		= "coverage";
	var REQ_OFC 	= "req_ofc_cd";
	var APRO_OFC 	= "apro_ofc_cd";
	var DATE 		= "upd_dt";
	var CUST_CD 	= "cust_cd";
	var CUST_NM 	= "cust_nm";	
	var BKG_NO 		= "bkg_no";
	var BL_NO 		= "bl_no";
	var CVRG_CNT 	= "cnt_cd";
	var CVRG_RGN	= "rgn_cd";
	var CVRG_LOC 	= "loc_cd";
			
	//날짜 정보를 가져오기 위한 처음(이전)과 마지막(현재) 일짜의 간격을 나타내는 변수
	var PERIOD_GAP = 7;	
	
	//IBSHEET 의 높이
	var IBSHEET_HEIGHT = 100;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2]; 
		var sheetObject4 = sheetObjects[3];
		var sheetObject5 = sheetObjects[4];
		var sheetObject6 = sheetObjects[5]; 
		/*******************************************************/
		var formObj = document.form;

    	try {
    		var srcObj = window.event.srcElement;
    		var srcName = srcObj.getAttribute("name");

    		switch(srcName) {

	         	case "btns_calendar": //달력 버튼
					var cal = new ComCalendarFromTo();
					cal.select(formObj.updDtFm, formObj.updDtTo, 'yyyy-MM-dd');
					break;            
	            
				case "btn_Retrieve":
					if (ComIsBtnEnable("btn_Retrieve")) 
						doActionRetrieve();					
					break;
				
				case "btn_New":
					if (ComIsBtnEnable("btn_New")) 
						doActionNew();						
					break;
				
				case "btn_Minimize":
					if (ComIsBtnEnable("btn_Minimize"))
						doActionMinimize();
					break;
				
				case "btn_Detail":
					if (ComIsBtnEnable("btn_Detail")) 
						doActionDetail();
					break;
					
				case "t1btn_SCdownexcel":
					doActionDownExcel(sheetObject1);
					break;
				
				case "t1btn_Beforedownexcel":
					doActionDownExcel(sheetObject2);
					break;
				
				case "t1btn_Afterdownexcel":
					doActionDownExcel(sheetObject3);
					break;																					

				case "t2btn_SCdownexcel":
					doActionDownExcel(sheetObject4);
					break;
				
				case "t2btn_Beforedownexcel":
					doActionDownExcel(sheetObject5);
					break;
				
				case "t2btn_Afterdownexcel":
					doActionDownExcel(sheetObject6);
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObj = document.form;
    	
        for (i = 0 ; i < sheetObjects.length ; i++) {
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        	//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
		}
         
        for (var k = 0 ; k < tabObjects.length ; k++) {
            initTab(tabObjects[k],k+1);
        }
        
	 	//IBMultiCombo초기화 
	    for (var k = 0 ; k < comboObjects.length ; k++) {
	        initCombo(comboObjects[k],k+1);
	    }
	 	
		//html컨트롤 이벤트초기화
		initControl();
		
		initViewControls();
    }

	// 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
	function t1sheet1_OnLoadFinish() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		//Tariff Type 정보를 조회해서 Tariff 콤보에 설정해 준다.
   		doActionIBCommon(sheetObj, formObj, IBSEARCH_TARIFF, SEARCH09);
	}
	
   	function initControl() {
		axon_event.addListenerForm('beforedeactivate',	'obj_deactivate',  	document.form, 'cond_type'); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',			'obj_focus',		document.form); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress',		'obj_keypress', 	document.form); //- 키보드 입력할때
		axon_event.addListener('click', 				'condType_click', 	'cond_type');
		axon_event.addListener('keydown', 				'ComKeyEnter', 		'form');
		axon_event.addListener('blur', 					'obj_blur', 		'custCd');
  	}
  	
   /**
    * 화면 Load 시점에 컨트롤들의 상태를 초기화하기 위한 함수
    */     
    function initViewControls() {
    	var formObj = document.form;
    	var cboTariff = comboObjects[0];
    	
	 	//Type 초기화(로그인 사용자의 OFFICE 에 따라 Type 을 선택해주고, 선택된 Type 에 따라 Tab Grid 를 보여주도록 한다.)
	 	initType();
	 	
	 	//Group by(기본값으로 설정 : S/C & DAR)
	 	ComSetObjValue(formObj.groupBy, "DAR");
	 	
	 	//Date 조회필드 설정
	 	initDateControls();
	 	
	 	//화면 로드시 보여주지 말아야 할 특정필드들을 숨긴다.(모든 Sent 탭에 TO/CC 필드)
	 	initColumn();

	 	//화면 로드시 기본값에 따라서 보여줄 필드들이 나타난다.
	 	showColumn();
	 	
    	//조회결과가 있다면 모두 Clear 해준다.
    	for (var sheetNo = 0 ; sheetNo < sheetObjects.length ; sheetNo++) {
    		sheetObjects[sheetNo].RemoveAll();
    	}	 	
    }
     
     /**
      * 로그인 사용자의 소속에 따라서 Type 의 기본을 정의
      */
     function initType() {
    	 var formObj = document.form;
    	 
    	 switch (ComTrim(ComGetObjValue(formObj.login_rhqofc_cd))) {
	    	 case "NYCRA" : 
	    		 	formObj.searchType[0].checked = true;	//SC
	    		 	formObj.searchType[1].checked = false;	//Before
	    		 	formObj.searchType[2].checked = true;	//After
	    		 break;

	    	 case "HAMRU" :
	    		 	formObj.searchType[0].checked = false;	//SC
	    		 	formObj.searchType[1].checked = true;	//Before
	    		 	formObj.searchType[2].checked = true;	//After
	    		 break;
	    		 
	    	 default :
	    		 	formObj.searchType[0].checked = true;	//SC
 		 			formObj.searchType[1].checked = true;	//Before
 		 			formObj.searchType[2].checked = true;	//After	 
    	 }
    	 
    	 //선택한 Type 에 따른 Tab Grid 를 숨기거나 보여주도록 한다.
    	 displayGridByType();
     }

  	/**
   	 * 조회 Date 필드 초기화
   	 */
   	function initDateControls() {
   		var formObj = document.form;
   		
   		//조회조건 부분적으로 활성화/비활성화  처리
   		formObj.cond_type[0].checked = true;
   		
   		doEnableCondObj("date");		
   	}      
      
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetid = sheetObj.id;

        switch(sheetid) {
            case "t1sheet1":
            case "t2sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = IBSHEET_HEIGHT;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 7, 100);

					var HeadTitle1 = "Seq.|To/CC|S/C No.|Ver.|Status|Tariff|Country|Region|Location|Request|APVL|Date|Proposal No.|Customer|Customer";
                   
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,		true,		"Seq");
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		TO_CC,    		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		SC_NO,    		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		VER,	     	false,	"",	dfNone,			0,	false);
                                                                          	
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,		true,		STATUS,  		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		TARIFF,  		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,		true,		CVRG_CNT,		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,		true,		CVRG_RGN,		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,		true,		CVRG_LOC,		false,	"",	dfNone,			0,	false);

					InitDataProperty(0, cnt++ , dtData,			75,		daCenter,		true,		REQ_OFC, 		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		APRO_OFC,		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			75,		daCenter,		true,		DATE,  			false,	"",	dfDateYmd,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		PROP_NO,		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		CUST_CD,		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			70,		daLeft,			true,		CUST_NM,		false,	"",	dfNone,			0,	false);

					// 좌측 틀고정 컬럼 설정
					FrozenCols = SaveNameCol(VER);
					
					CountPosition = 0;
				}
				break;

            case "t1sheet2":
            case "t2sheet2":
                with (sheetObj) {
                    // 높이 설정
                    style.height = IBSHEET_HEIGHT;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 7, 100);

					var HeadTitle1 = "Seq.|To/CC|DAR No.|Ver.|APVL No.|Status|Tariff|Country|Region|Location|Request|APVL|Date|RFA No.|Proposal No.|Customer|Customer";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,		true,		"Seq");
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		TO_CC,    		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			115,	daCenter,		true,		DAR_NO,    		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		true,		VER,      		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,		true,		APVL_NO,   		false,	"",	dfNone,			0,	false);

					InitDataProperty(0, cnt++ , dtData,			95,		daCenter,		true,		STATUS,   		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		TARIFF,   		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,		true,		CVRG_CNT,		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,		true,		CVRG_RGN,		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,		true,		CVRG_LOC,		false,	"",	dfNone,			0,	false);

					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		REQ_OFC,  		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		APRO_OFC, 		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		DATE,     		false,	"",	dfDateYmd,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		RFA_NO,    		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		PROP_NO, 		false,	"",	dfNone,			0,	false);

					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		CUST_CD,		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			180,	daLeft,			true,		CUST_NM,		false,	"",	dfNone,			0,	false);

					// 좌측 틀고정 컬럼 설정
					FrozenCols = SaveNameCol(STATUS);
					
					CountPosition = 0;
				}
				break;

            case "t1sheet3":
            case "t2sheet3":
                with (sheetObj) {
                    // 높이 설정
                    style.height = IBSHEET_HEIGHT;
                    
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 7, 100);

					var HeadTitle1 = "Seq.|To/CC|DAR No.|APVL No.|Status|Tariff|Coverage|BKG No.|B/L No.|Request|APVL|Final APVL|Date|S/C No.|RFA No.|Customer|Customer";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   	InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,		true,		"Seq");
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		TO_CC,    		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,		true,		DAR_NO,    		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,		true,		APVL_NO,   		false,	"",	dfNone,			0,	false);
                                                                        
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		true,		STATUS,   		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		TARIFF,   		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		CVRG, 			false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,		true,		BKG_NO,    		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		BL_NO,     		false,	"",	dfNone,			0,	false);
                                                                        
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		REQ_OFC,  		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		APRO_OFC, 		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		"final_ofc_cd",	false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		DATE,     		false,	"",	dfDateYmd,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		SC_NO,     		false,	"",	dfNone,			0,	false); 
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		RFA_NO,     	false,	"",	dfNone,			0,	false);
					
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		CUST_CD,		false,	"",	dfNone,			0,	false); 
					InitDataProperty(0, cnt++ , dtData,			250,	daLeft,			true,		CUST_NM,		false,	"",	dfNone,			0,	false);

					// 좌측 틀고정 컬럼 설정
					FrozenCols = SaveNameCol(STATUS);
					CountPosition = 0;
				}
				break;

        }
    }

    //포커스가 나갈 때
 	function obj_deactivate(){
 		//입력Validation 확인하기 + 마스크구분자 넣기
 		var obj = event.srcElement;
 		if(obj.name == 'svc_provdr' || obj.name == 'bkg_no' || obj.name == 'bl_no' || obj.name == 'cntr_no') {
    		 
 		} else if(obj.name == 'yd_cd' || obj.name == 'tmnl_cd') {
 			if(obj.value.length > 0 && obj.value.length < 5) {
 	 			ComShowCodeMessage('DMT00110', 'Location');
 	 			ComClearObject(obj);
    		 	}
 		} else {
 			ComChkObjValid(obj);
 		}
	}
    
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
   	 var obj = event.srcElement;
        ComClearSeparator(obj);
        
        //글자가 있는 경우 블럭으로 선택할수 있도록 한다.
        if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
    }    
 	
	//업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress() {
		var formObj = document.form;

		switch(event.srcElement.dataformat){
			case "engup":
				// 영문대+숫자 
				ComKeyOnlyAlphabet('uppernum', ',');
				break;
      		case "engup2":
		    	// 영문대+숫자+예외문자
		    	DmtComKeyOnlyAlphabet('uppernum', ',');
		        break;
      		case "int":
	 	        //숫자 만입력하기
	 	        ComKeyOnlyNumber(event.srcElement);
	 	        break;
      		default:
	         	// 숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
		}		
		//조회옵션으로 DAR 항목을 선택한 후 특정 필드에 데이터를 입력하면, 기타 다른 필드들에 입력된 값은 Clear 시킨다. 
		clearNoSelectDARFields();
	} 
	
	//업무 자바스크립트 OnBlur 이벤트 처리
	function obj_blur() {
		switch(event.srcElement.name){
			case "custCd":
				searchCustomerName();
				break;
		}
	}
	
 	/**
	 * Customer ID 입력 후 포커스 아웃시 Customer Name 을 조회한다.
	 */
	function searchCustomerName() {
		var formObj = document.form;
		 
		var custCd = ComTrim(ComGetObjValue(formObj.custCd));
		if (custCd.length > 2) {
			ComSetObjValue(formObj.cust_cnt_cd, custCd.substring(0, 2));
			ComSetObjValue(formObj.cust_seq, custCd.substring(2));		 
			 
			doActionIBCommon(sheetObjects[0], formObj, IBSEARCH_CUST_NM, SEARCH19);
		}
		else {
			ComClearObject(formObj.custNm);
		}
	}
	
    function condType_click() {
    	
    	doEnableCondObj(event.srcElement.value);
    }
	    
	function doEnableCondObj(condType) {
		var sheetObj 	= sheetObjects[0];
		var formObj 	= document.form;
		
		with (formObj) {
			switch(condType){
				case "date":
					//Date 조회조건 필드들 활성화
					ComEnableManyObjects(true, updDtFm, updDtTo, toCc, userOfficeOnly, userOnly);
					updDtFm.className = "input1";
					updDtTo.className = "input1";
					toCc.className = "input";
					userOfficeOnly.className = "trans";
					userOnly.className = "trans";

					var ofcCurrDate = DmtComOfficeCurrDate(sheetObj, formObj);
					ComSetObjValue(updDtFm, ComGetDateAdd(ofcCurrDate, "D", -7));
					ComSetObjValue(updDtTo, ofcCurrDate);

					//Office 를 기본값으로 설정해준다.
					setDefaultOffice();
					office.className = "input2";

					//Dar 조회조건 필드들 비활성화
					ComEnableManyObjects(false, sCNo, rFANo, proposalNo, darNo, approvalNo, bkgNo, blNo);
					ComClearManyObjects(sCNo, rFANo, proposalNo, darNo, approvalNo, bkgNo, blNo);
					break;
					
				case "dar":
					//Dar 조회조건 필드들 활성화
					ComEnableManyObjects(true, sCNo, rFANo, proposalNo, darNo, approvalNo, bkgNo, blNo);
					sCNo.className = "input";
					rFANo.className = "input";
					proposalNo.className = "input";
					darNo.className = "input";
					approvalNo.className = "input";
					bkgNo.className = "input";
					blNo.className = "input";
					
					//Date 조회조건 필드들 비활성화
					ComEnableManyObjects(false, updDtFm, updDtTo, toCc, userOfficeOnly, userOnly);
					ComClearManyObjects(updDtFm, updDtTo, office);
				    office.className = "input2";
					ComSetObjValue(toCc, "");
					userOfficeOnly.checked = false;
					userOnly.checked = false;
					
					//포커스설정
					ComSetFocus(sCNo);
					break;
			}
		}
	}
		
  	
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        //메소드내에서 전체적으로 사용하는 변수 정의
        var cboTariff = comboObjects[0];
        
        switch(sAction) {

        	case IBSEARCH:      //조회
              	if(!validateForm(sheetObj,formObj,sAction)) return;

				//1.조회조건 설정
				ComSetObjValue(formObj.f_cmd, 		SEARCH);
				ComSetObjValue(formObj.group_by, 	ComGetObjValue(formObj.groupBy));
				ComSetObjValue(formObj.dmdt_trf_cd, cboTariff.Text);
				ComSetObjValue(formObj.fm_dt, 		ComGetObjValue(formObj.updDtFm));
				ComSetObjValue(formObj.to_dt, 		ComGetObjValue(formObj.updDtTo));
				if (formObj.userOnly.checked) {
					ComSetObjValue(formObj.usr_id, ComGetObjValue(formObj.login_usr_id));
					ComSetObjValue(formObj.usr_ofc_cd, "");
					ComSetObjValue(formObj.usr_ofc_only, "N");
				}
				else if (formObj.userOfficeOnly.checked) {
					ComSetObjValue(formObj.usr_id, "");						
					ComSetObjValue(formObj.usr_ofc_cd, ComGetObjValue(formObj.login_ofc_cd));
					ComSetObjValue(formObj.usr_ofc_only, "Y");
				}
				else {
					ComSetObjValue(formObj.usr_id, "");
					ComSetObjValue(formObj.usr_ofc_cd, ComGetObjValue(formObj.ofc_cd));
					ComSetObjValue(formObj.usr_ofc_only, "N");
				}
				ComSetObjValue(formObj.to_cc, 		ComGetObjValue(formObj.toCc));
				ComSetObjValue(formObj.sc_no, 		ComGetObjValue(formObj.sCNo));
				ComSetObjValue(formObj.rfa_no, 		ComGetObjValue(formObj.rFANo));
				ComSetObjValue(formObj.prop_no, 	ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.dar_no, 		ComGetObjValue(formObj.darNo));
				ComSetObjValue(formObj.apvl_no, 	ComGetObjValue(formObj.approvalNo));
				ComSetObjValue(formObj.bkg_no, 		ComGetObjValue(formObj.bkgNo));
				ComSetObjValue(formObj.bl_no, 		ComGetObjValue(formObj.blNo));
				ComSetObjValue(formObj.cust_cd, 	ComTrim(ComGetObjValue(formObj.custCd)));
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				sheetObj.DoSearch("EES_DMT_2006GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************				
				break;
        }
    }

	/**
	 * 콤보필드를 초기화 시키기 위해서 해당 데이터를 조회후 조회된 데이터로 채운다.
	 */	
	function doActionIBCommon(sheetObj, formObj, sAction, sComboAction) {
	    sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		
	    switch(sAction) {
	    
	    	//Tariff Type 을 조회한다.
	    	case IBSEARCH_TARIFF:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, sComboAction);
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
				var comboObj = comboObjects[0];
				var comboItems = ComGetEtcData(sXml, "all_tariff_cd").split(ROWMARK);
				addComboItem(comboObj,comboItems);
				
				//4.Tariff 전체선택을 기본설정으로 한다.
				selectAllTariff();
				break;

				
			//Customer 프레임에 CUSTOMER ID 를 입력시 CUSTOMER NAME 을 조회한다.
        	case IBSEARCH_CUST_NM:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, sComboAction);
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
				var custNm = ComTrim(ComGetEtcData(sXml, "CUST_NM"));
				if (custNm == "") {
					ComShowCodeMessage("DMT06001");
					ComClearObject(formObj.custCd);
					ComClearObject(formObj.custNm);
					ComSetFocus(formObj.custCd);
					return;
				} else {
					//Customer Code 가 8자리로 입력되지 않았다면 8자리로 설정해준다.
					if (ComGetObjValue(formObj.custCd).length < 8)
						ComSetObjValue(formObj.custCd, fetchLeftPadding(ComGetObjValue(formObj.custCd)));
					
					ComSetObjValue(formObj.custNm, custNm);
				}
        		break;					
	    }
		sheetObj.WaitImageVisible = true;
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
                    InsertTab( cnt++ , "Received" , -1 );
                    InsertTab( cnt++ , "Sent" , -1 );
                }
             	break;
         }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem) {
        var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "block";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
    }

  	/** 
  	 * IBCombo Object를 배열로 등록
  	 * param : combo_obj ==> 콤보오브젝트
  	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  	 * 배열은 소스 상단에 정의
  	 */ 
  	function setComboObject(combo_obj) {  
  
  		comboObjects[comboCnt++] = combo_obj;  
  	}

  	/**
   	 * Combo 기본 설정 
   	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
   	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj = document.form

   	    switch(comboNo) {
   	    	//Tariff Type
   	    	case 1:
   	    		with(comboObj) {
   					MultiSelect = true; 
   					UseAutoComplete = true;	
   					SetColAlign("left|left");        
   					SetColWidth("55|330");
   					DropHeight = 160;
   	    		}
   	    		break;
   	     } 
   	}
   	
	/**
     * 콤보필드에 데이터를 추가해준다.
     */	
	function addComboItem(comboObj, comboItems) {
    	for (var i = 0 ; i < comboItems.length ; i++) {
    		var comboItem = comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);		
    	}   		
	}
	     
    /**
     * 콤보필드에 첫번째 항목을 선택해준다.
     */	
 	function setComboItem(comboObj,comboItems) {
 		var checkedItem = comboItems[0].split(FIELDMARK);
 		comboObj.Text = checkedItem[0];
 	}
 	
 	//Tariff Type 멀티콤보 클릭 이벤트
 	function combo1_OnCheckClick(comboObj, index, code) {
 		setMultiCombo(comboObj, index, code) ;
 	}
 	
    /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    */
   function validateForm(sheetObj,formObj,sAction){
       with(formObj){
    	   //Type 모두 미선택 후 Retrieve 시 에러처리.
    	   if (!searchType[0].checked && !searchType[1].checked && !searchType[2].checked) {
    		   ComShowCodeMessage("DMT02010");
       		   ComSetFocus(searchType[0]);
       		   return false;
       		}
       }
       return true;
   }
	  
    /**	 
	 * Tariff Type 을 전체 선택해준다.
	 */		
	function selectAllTariff() {
		var comboObj = comboObjects[0];
		for (var i = 0 ; i < comboObj.GetCount; i++) {
			comboObj.CheckIndex(i) = true; 
    	} 		
	}
    
	function openWinSearchCustomer(srcName) {
		var sheetObj = sheetObjects[0];
		
		doProcessPopup(sheetObj, srcName);
	}
	
    /**	 
	 * Received Tab 의 S/C Exception Tariff 조회된 항목중 하나를 더블클릭한 경우 팝업으로 CRUD 화면을 띄워준다.
	 */		 
	function t1sheet1_OnDblClick(sheetObj,Row,Col) {
		 var sheetObj = sheetObjects[0];
		 
		 doProcessPopup(sheetObj, 't1sheet1');
	}
	 
    /**	 
	 * Sent Tab 의 S/C Exception Tariff 조회된 항목중 하나를 더블클릭한 경우 팝업으로 CRUD 화면을 띄워준다.
	 */		 
	function t2sheet1_OnDblClick(sheetObj,Row,Col) {
		 var sheetObj = sheetObjects[3];
		 
		 doProcessPopup(sheetObj, 't2sheet1');
	}
		
    /**	 
	 * Received Tab 의 Before Booking DAR 조회된 항목중 하나를 더블클릭한 경우 팝업으로 CRUD 화면을 띄워준다.
	 */		 
	function t1sheet2_OnDblClick(sheetObj,Row,Col) {
		 var sheetObj = sheetObjects[1];
		 
		 doProcessPopup(sheetObj, 't1sheet2');
	}
	
    /**	 
	 * Sent Tab 의 Before Booking DAR 조회된 항목중 하나를 더블클릭한 경우 팝업으로 CRUD 화면을 띄워준다.
	 */		 
	function t2sheet2_OnDblClick(sheetObj,Row,Col) {
		 var sheetObj = sheetObjects[4];
		 
		 doProcessPopup(sheetObj, 't2sheet2');
	}
		
    /**	 
	 * Received Tab 의 After Booking DAR 조회된 항목중 하나를 더블클릭한 경우 팝업으로 CRUD 화면을 띄워준다.
	 */		 
	function t1sheet3_OnDblClick(sheetObj,Row,Col) {
		 var sheetObj = sheetObjects[2];
		 
		 doProcessPopup(sheetObj, 't1sheet3');
	}		
	 
    /**	 
	 * Sent Tab 의 After Booking DAR 조회된 항목중 하나를 더블클릭한 경우 팝업으로 CRUD 화면을 띄워준다.
	 */		 
	function t2sheet3_OnDblClick(sheetObj,Row,Col) {
		 var sheetObj = sheetObjects[5];
		 
		 doProcessPopup(sheetObj, 't2sheet3');
	}
		
 	/*
 	 * 각 공통팝업창 호출 함수 
 	 */
 	function doProcessPopup(sheetObj, srcName) {
 		var formObj	= document.form;
 		var sUrl	= '';
 		var sWidth	= '';
 		var sHeight	= '';
 		
  		switch(srcName) {
  			case "cust_cd":		// Customer Inquiry Popup
				ComOpenPopup('COM_ENS_041.do', 770, 470, "findCustomer", "1,0,1,1,1,1,1", true);
				break;
			
  			case "t1sheet1":
  			case "t2sheet1":
  				var propNo = sheetObj.CellValue(sheetObj.SelectRow, PROP_NO);
  				ComOpenPopup('EES_DMT_2001.do?prop_no=' + propNo + '&caller=2006', 1020, 710, "findCustomer", "1,0,1,1,1,1,1", true);
  				break;

  			case "t1sheet2":
  			case "t2sheet2":
  				var darNo = sheetObj.CellValue(sheetObj.SelectRow, DAR_NO);
  				ComOpenPopup('EES_DMT_2005P.do?dar_no=' + darNo + '&caller=2006&sheetId=' + srcName, 1020, 645, "findCustomer", "1,0,1,1,1,1,1", true);
  				break;

  			case "t1sheet3":
  			case "t2sheet3":
  				var darNo = sheetObj.CellValue(sheetObj.SelectRow, DAR_NO);
//  				ComOpenPopup('EES_DMT_2018.do?rqst_flg=N&dar_no=' + darNo + '&caller=2006&sheetId=' + srcName, 1020, 710, "findCustomer", "1,0,1,1,1,1,1", true);
  				ComOpenWindowCenter('/hanjin/EES_DMT_2018.do?rqst_flg=N&dar_no=' + darNo + '&caller=2006&sheetId=' + srcName, 'EES_DMT_2019.do', 1020, 710, true, 'Yes');
  				break;
  		}
 	}
 	 
 	/**
	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
	 */
	function findCustomer(aryPopupData) {
		var formObj = document.form;
		document.form.custCd.value = aryPopupData[0][3];
		document.form.custNm.value = aryPopupData[0][4];
	}

 	/**
 	 * S/C 및 DAR 의 Request & Approval Status 조회조건에 맞는 데이터 조회하는 동작을 정의하는 함수
 	 */ 	 
	function doActionRetrieve() {
 		var formObj = document.form;
 		var sheetSCObjRcvTab = sheetObjects[0];	//S/C Exception Grid Object in Received tab
 		var sheetSCObjSntTab = sheetObjects[3];	//S/C Exception Grid Object in Sent tab
 		
 		var sheetBBObjRcvTab = sheetObjects[1];	//Before Booking Grid Object in Received tab
 		var sheetBBObjSntTab = sheetObjects[4];	//Before Booking Grid Object in Sent tab
 		
 		var sheetABObjRcvTab = sheetObjects[2];	//After Booking Grid Object in Received tab
 		var sheetABObjSntTab = sheetObjects[5];	//After Booking Grid Object in Sent tab
 		
 		//Type 모두 미선택 후 Retrieve시 “Pls check the Type option!” Alert창 띄워줌
 		with(formObj) {
	 		if (searchType[0].checked == false && searchType[1].checked == false && searchType[2].checked == false) {
	 			ComShowCodeMessage("DMT02010");
	 			return;
	 		}
 		}
 		//================================================================================================================================
 		//1.조회구분으로 Date 선택시 조회우선순위는 User Only 항목, User Office Only 와  To/Cc 항목, Office 와  To/Cc 항목이다.
 		//  1-1.Office, To/Cc 필드에 값이 입력되었고, User Office Only 와 User Only 가 체크되었을 경우 User Only 조건으로만 조회가 이루어진다.
 		//      나머지 필드들은 무시된다.
 		//  1-2.User Only 선택시 CC 정보는 조회대상이 아니다.
 		//2.DAR 항목선택시 Received Tab 에만 결과를 보여준다.
 		//================================================================================================================================
 		
 		var sCNo 	= ComTrim(ComGetObjValue(formObj.sCNo));
 		var rFANo 	= ComTrim(ComGetObjValue(formObj.rFANo));
 		var propNo 	= ComTrim(ComGetObjValue(formObj.proposalNo));
 		var darNo 	= ComTrim(ComGetObjValue(formObj.darNo));
 		var apvlNo 	= ComTrim(ComGetObjValue(formObj.approvalNo));
 		var bkgNo 	= ComTrim(ComGetObjValue(formObj.bkgNo));
 		var blNo 	= ComTrim(ComGetObjValue(formObj.blNo));
 		
 		//1.DAR 를 선택했다면, S/C No., RFA No., Proposal No., DAR No., APVL No., BKG No., B/L No. 중 반드시 1 개의 항목만 입력되어야 한다.
 		if (formObj.cond_type[0].checked) {
 			var startDt	= ComTrim(ComGetObjValue(formObj.updDtFm));
 			var endDt	= ComTrim(ComGetObjValue(formObj.updDtTo))
 			
 			//필수입력항목 체크
 			if (startDt == "") {
 				ComShowCodeMessage("DMT00102", "'Update'");
 				ComSetFocus(formObj.updDtFm);
 				return false;
 			}
 			else if (endDt == "") {
 				ComShowCodeMessage("DMT00102", "'Update'");
 				ComSetFocus(formObj.updDtTo);
 				return false;
 			}
 			
			startDt = ComGetUnMaskedValue(startDt, 	'ymd');
     		endDt 	= ComGetUnMaskedValue(endDt, 	'ymd');
            limitDt = ComGetDateAdd(startDt, "M", 1);
            if (ComChkPeriod(endDt, limitDt) == 0) {
            	ComShowCodeMessage("DMT00162", "1 month");
            	return false;
            }
 		}
 		else if (formObj.cond_type[1].checked) {
			var inputFieldCount = 0;
			
			if (sCNo 	!= "") 	inputFieldCount++;
			if (rFANo 	!= "") 	inputFieldCount++;
			if (propNo 	!= "") 	inputFieldCount++;
			if (darNo 	!= "") 	inputFieldCount++;
			if (apvlNo 	!= "") 	inputFieldCount++;
			if (bkgNo 	!= "") 	inputFieldCount++;
			if (blNo 	!= "") 	inputFieldCount++;
	
			if (inputFieldCount == 0 || inputFieldCount > 1) {
			    ComShowCodeMessage("DMT00181");
			    ComSetFocus(formObj.sCNo);
			    return false;    			 
			}
			
			//DAR No.랑 APVL No. 뒷자리에 A나 B가 아니면 "Pls check DAR No." 또는 "Pls check APVL No." 라고 alert 띄우는 걸루 해주세요(2009-11-11(수))
			if (darNo != "") {
				var darType = darNo.substring(darNo.length - 1);
				if (darType != "A" && darType != "B") {
					ComShowCodeMessage("DMT00171", "DAR No.");
					ComSetFocus(formObj.darNo);
					return;
				}
			}
			else if (apvlNo != "") {
				var apvlType = apvlNo.substring(apvlNo.length - 1);
				if (apvlType != "A" && apvlType != "B") {
					ComShowCodeMessage("DMT00171", "APVL No.");
					ComSetFocus(formObj.approvalNo);
					return;
				}
			}
 		}
 		
 		//기존에 조회된 결과가 있다면 Clear 시켜준다. =======================================
 		sheetSCObjRcvTab.RemoveAll();
 		sheetSCObjSntTab.RemoveAll();
 		
 		sheetBBObjRcvTab.RemoveAll();
 		sheetBBObjSntTab.RemoveAll();
 		
 		sheetABObjRcvTab.RemoveAll();
 		sheetABObjSntTab.RemoveAll();

		//입력된 조회조건에 따른 필드정보를 보여주거나 감춘다. ===============================
 		showColumn();
 		
 		//S/C 조회모듈 실행 ==============================================================
 		if (formObj.searchType[0].checked) {
 			ComSetObjValue(formObj.type, "SC");
 			//Date 조회모듈 실행
 			if (formObj.cond_type[0].checked) {
 				ComSetObjValue(formObj.cond_tp, "DATE");
 				//Received Tab
 				ComSetObjValue(formObj.tab_tp, "RCV");
 				doActionIBSheet(sheetSCObjRcvTab,formObj,IBSEARCH);
 				
 				//Sent Tab
 				if (ComGetObjValue(formObj.toCc) == "" || ComGetObjValue(formObj.toCc) == "to") {
	 				ComSetObjValue(formObj.tab_tp, "SND");
	 				doActionIBSheet(sheetSCObjSntTab,formObj,IBSEARCH);
 				}
 				
 			}
 			//DAR 조회모듈 실행
 			else if (formObj.cond_type[1].checked) {
 				//S/C No. 나 Proposal No. 가 입력되었을 경우 실행한다.
 				if (sCNo != "" || propNo != "") {
	 				ComSetObjValue(formObj.cond_tp, "DAR");
	 				//Received Tab
	 				ComSetObjValue(formObj.tab_tp, "RCV");
	 				doActionIBSheet(sheetSCObjRcvTab,formObj,IBSEARCH);
 				}
 			}
 		}

 		//Before Booking Request 조회모듈 실행 ===========================================
 		if (formObj.searchType[1].checked) {
 			ComSetObjValue(formObj.type, "BB");
 			//Date 조회모듈 실행
 			if (formObj.cond_type[0].checked) {
 				ComSetObjValue(formObj.cond_tp, "DATE"); 				
 				//Received Tab
 				ComSetObjValue(formObj.tab_tp, "RCV");
 				doActionIBSheet(sheetBBObjRcvTab,formObj,IBSEARCH);

 				//Sent Tab
 				if (ComGetObjValue(formObj.toCc) == "" || ComGetObjValue(formObj.toCc) == "to") { 				
 					ComSetObjValue(formObj.tab_tp, "SND");
 					doActionIBSheet(sheetBBObjSntTab,formObj,IBSEARCH);
 				}
 			}
 			//DAR 조회모듈 실행
 			else {
 				//RFA No. 나 Proposal No., DAR No., APVL No. 가 입력되었을 경우 실행한다.
 				if (rFANo != "" || propNo != "" || darNo != "" || apvlNo != "") {
 					ComSetObjValue(formObj.cond_tp, "DAR");
					//Received Tab
					ComSetObjValue(formObj.tab_tp, "RCV");

					var isRetrieve = false;
 					//[9/8] DAR No. 뒷자리가 A이면 After BKG/ B이면 Before BKG 만 조회하면 됨.
 					if (darNo != "") {
 						if (darNo.substring(darNo.length - 1) == "B") {
 							isRetrieve = true;
 						}
 					}
 					//[9/8] APVL No. 뒷자리가 A이면 After BKG/ B이면 Before BKG 만 조회하면 됨.
 					else if (apvlNo != "") {
 						if (apvlNo.substring(apvlNo.length - 1) == "B") {
 							isRetrieve = true;
 						} 
 					}
 					else {
 						isRetrieve = true;
 					}
 					
 					//조회 가능한 조건이라면 조회를 수행한다.
 					if (isRetrieve) doActionIBSheet(sheetBBObjRcvTab,formObj,IBSEARCH);
 				}
 			}
 		}

 		//After Booking Request 조회모듈 실행 ============================================
 		if (formObj.searchType[2].checked) {
 			ComSetObjValue(formObj.type, "AB");
 			//Date 조회모듈 실행
 			if (formObj.cond_type[0].checked) {
 				ComSetObjValue(formObj.cond_tp, "DATE"); 				
 				//Received Tab
 				ComSetObjValue(formObj.tab_tp, "RCV");
 				doActionIBSheet(sheetABObjRcvTab,formObj,IBSEARCH);
 				
 				//Sent Tab
 				if (ComGetObjValue(formObj.toCc) == "" || ComGetObjValue(formObj.toCc) == "to") { 
 					ComSetObjValue(formObj.tab_tp, "SND");
 					doActionIBSheet(sheetABObjSntTab,formObj,IBSEARCH);
 				}
 			}
 			//DAR 조회모듈 실행
 			else {
 				//S/C No. 나 RFA No., DAR No., APVL No., BKG No., B/L No. 가 입력되었을 경우 실행한다.
 				if (sCNo != "" || rFANo != "" || darNo != "" || apvlNo != "" || bkgNo != "" || blNo != "") {
 					ComSetObjValue(formObj.cond_tp, "DAR");
					//Received Tab
					ComSetObjValue(formObj.tab_tp, "RCV");

					var isRetrieve = false;
 					//[9/8] DAR No. 뒷자리가 A이면 After BKG/ B이면 Before BKG 만 조회하면 됨.
 					if (darNo != "") {
 						if (darNo.substring(darNo.length - 1) == "A") {
 							isRetrieve = true;
 						}
 					}
 					//[9/8] APVL No. 뒷자리가 A이면 After BKG/ B이면 Before BKG 만 조회하면 됨.
 					else if (apvlNo != "") {
 						if (apvlNo.substring(apvlNo.length - 1) == "A") {
 							isRetrieve = true;
 						} 						
 					}
 					else {
 						isRetrieve = true;
 					}
 					
 					//조회 가능한 조건이라면 조회를 수행한다.
 					if (isRetrieve) doActionIBSheet(sheetABObjRcvTab,formObj,IBSEARCH); 					
 				}
 			}
 		}
	}
	
 	/**
	 * S/C 및 DAR 의 Request & Approval Status 조회조건을 초기화하는 동작을 정의하는 함수
	 */ 	 
	function doActionNew() {
		 
		 initViewControls();
	}
	
 	/**
	 * S/C 및 DAR 의 Request & Approval Status 조회조건 창을 안 보이도록 동작을 정의하는 함수
	 * 보여주는 IBSHEET 의 갯수에 따라서 Height 도 조절해 주는 함수(2009-11-05 (목))
	 */ 	 
	function doActionMinimize() {
		
		if (conditionLayer.style.display == 'block') {
			conditionLayer.style.display = 'none';
		}
		else {
			conditionLayer.style.display = 'block';
		}
		
		//조회조건 프레임이 감춰지거나 보여지는 만큼 IBSHEET 의 높이를 재설정해준다.
		displayGridByType();
	}
	
 	/**
	 * S/C 및 DAR 의 Request & Approval Status 해당 팝업화면을 통해서 상세보기 동작을 정의하는 함수
	 */ 	 
	function doActionDetail() {
		var formObj 	= document.form;
		var isOpenWin 	= false;
		
		var fromSheetNo = tabObjects[0].SelectedIndex * 3;
		var toSheetNo 	= (tabObjects[0].SelectedIndex + 1) * 3;
		
		for (var sheetNo = 0 ; sheetNo < sheetObjects.length ; sheetNo++) {
			if (sheetNo < fromSheetNo || sheetNo >= toSheetNo) continue;
			
			var sheetObj = sheetObjects[sheetNo];
			with(sheetObj) {
				if (RowCount > 0 && SelectRow >= HeaderRows) {
					switch(id) {
						case "t1sheet1":
							doProcessPopup(sheetObj, 't1sheet1');
							isOpenWin = true;
							break;
							
						case "t2sheet1":
							doProcessPopup(sheetObj, 't2sheet1');
							isOpenWin = true;
							break;
							
						case "t1sheet2":
							doProcessPopup(sheetObj, 't1sheet2');
							isOpenWin = true;
							break;
							
						case "t2sheet2":
							doProcessPopup(sheetObj, 't2sheet2');
							isOpenWin = true;
							break;
							
						case "t1sheet3":
							doProcessPopup(sheetObj, 't1sheet3');
							isOpenWin = true;
							break;
							
						case "t2sheet3":
							doProcessPopup(sheetObj, 't2sheet3');
							isOpenWin = true;
							break;
					}
					if (isOpenWin) break;
				}
			}
		}
	}
	 
 	/**
	 * 조회된 결과를 Excel 파일로 다운로드 받는 동작을 정의하는 함수
	 */ 	 
	function doActionDownExcel(sheetObj) {
		
		sheetObj.SpeedDown2Excel();
	}

 	/**
 	 * 화면이 로드될 때 보여주지 말아야할 필드를 감추도록 동작하는 함수
 	 */
	function initColumn() {
 		for (var i = 3 ; i < 6 ; i++) {
			sheetObjects[i].ColHidden(TO_CC) = true;
		} 
	}
		
 	/**
 	 * 조회조건의 선택 및 입력값에 따라서, 조회시 특정 필드를 보여주거나 감추도록 동작하는 함수
 	 */
	function showColumn() {
		var formObj = document.form;
		
		//1.Group By 선택값에 따라서
		if (ComTrim(ComGetObjValue(formObj.groupBy)) == "DAR") {
			for (var i = 0 ; i < sheetObjects.length ; i++) {
				sheetObjects[i].ColHidden(TARIFF) = true;
				
				//After Booking 일 경우
				if ((i + 1) % 3 == 0) {
					sheetObjects[i].ColHidden(CVRG) = true;
					sheetObjects[i].ColHidden(BKG_NO) = true;
					sheetObjects[i].ColHidden(BL_NO) = true;
				}
				//S/C, Before Booking 일 경우
				else {
					sheetObjects[i].ColHidden(CVRG_CNT) = true;
					sheetObjects[i].ColHidden(CVRG_RGN) = true;
					sheetObjects[i].ColHidden(CVRG_LOC) = true;					
				}
			}
		}
		else {
			for (var i = 0 ; i < sheetObjects.length ; i++) {
				sheetObjects[i].ColHidden(TARIFF) = false;
				
				//After Booking 일 경우
				if ((i + 1) % 3 == 0) {
					sheetObjects[i].ColHidden(CVRG) = false;
					sheetObjects[i].ColHidden(BKG_NO) = false;
					sheetObjects[i].ColHidden(BL_NO) = false;				
				}
				//S/C, Before Booking 일 경우
				else {
					sheetObjects[i].ColHidden(CVRG_CNT) = false;
					sheetObjects[i].ColHidden(CVRG_RGN) = false;
					sheetObjects[i].ColHidden(CVRG_LOC) = false;					
				}				
			}		
		}
		
		//2.Date or DAR 조회프레임 선택에 따라서
		if (formObj.cond_type[0].checked) {
			showToCcColumn(false);
		}
		else {
			showToCcColumn(true);
		} 
	}
 	 
  	/**
  	 * Sent 의 CC 컬럼은 보여주지 않는다.
  	 */ 	 
    function showToCcColumn(flag) {
		for (var i = 0 ; i < 3 ; i++) {
			sheetObjects[i].ColHidden(TO_CC) = flag;
		}    	
    }
 	 
 	/**
 	 * DAR 조회필드항목중 특정필드에 값이 입력되면 다른 필드들은 모두 Clear 시킨다.
 	 */
 	function clearNoSelectDARFields() {
 	    var formObj = document.form;
 	    
 		with(formObj) {
 			switch(event.srcElement.name) {
 				case "sCNo":
 					if (ComTrim(ComGetObjValue(rFANo)) != "") ComClearObject(rFANo);
 					if (ComTrim(ComGetObjValue(proposalNo)) != "") ComClearObject(proposalNo);
 					if (ComTrim(ComGetObjValue(darNo)) != "") ComClearObject(darNo);
 					if (ComTrim(ComGetObjValue(approvalNo)) != "") ComClearObject(approvalNo);
 					if (ComTrim(ComGetObjValue(bkgNo)) != "") ComClearObject(bkgNo);
 					if (ComTrim(ComGetObjValue(blNo)) != "") ComClearObject(blNo);
 					break;
 					
 				case "rFANo":
 					if (ComTrim(ComGetObjValue(sCNo)) != "") ComClearObject(sCNo);
 					if (ComTrim(ComGetObjValue(proposalNo)) != "") ComClearObject(proposalNo);
 					if (ComTrim(ComGetObjValue(darNo)) != "") ComClearObject(darNo);
 					if (ComTrim(ComGetObjValue(approvalNo)) != "") ComClearObject(approvalNo);
 					if (ComTrim(ComGetObjValue(bkgNo)) != "") ComClearObject(bkgNo);
 					if (ComTrim(ComGetObjValue(blNo)) != "") ComClearObject(blNo);					
 					break;
 		
 				case "proposalNo":
 					if (ComTrim(ComGetObjValue(sCNo)) != "") ComClearObject(sCNo);
 					if (ComTrim(ComGetObjValue(rFANo)) != "") ComClearObject(rFANo);
 					if (ComTrim(ComGetObjValue(darNo)) != "") ComClearObject(darNo);
 					if (ComTrim(ComGetObjValue(approvalNo)) != "") ComClearObject(approvalNo);
 					if (ComTrim(ComGetObjValue(bkgNo)) != "") ComClearObject(bkgNo);
 					if (ComTrim(ComGetObjValue(blNo)) != "") ComClearObject(blNo);					
 					break;
 					
 				case "darNo":
 					if (ComTrim(ComGetObjValue(sCNo)) != "") ComClearObject(sCNo);
 					if (ComTrim(ComGetObjValue(rFANo)) != "") ComClearObject(rFANo);
 					if (ComTrim(ComGetObjValue(proposalNo)) != "") ComClearObject(proposalNo);
 					if (ComTrim(ComGetObjValue(approvalNo)) != "") ComClearObject(approvalNo);
 					if (ComTrim(ComGetObjValue(bkgNo)) != "") ComClearObject(bkgNo);
 					if (ComTrim(ComGetObjValue(blNo)) != "") ComClearObject(blNo);					
 					break;
 					
 				case "approvalNo":
 					if (ComTrim(ComGetObjValue(sCNo)) != "") ComClearObject(sCNo);
 					if (ComTrim(ComGetObjValue(rFANo)) != "") ComClearObject(rFANo);
 					if (ComTrim(ComGetObjValue(proposalNo)) != "") ComClearObject(proposalNo);
 					if (ComTrim(ComGetObjValue(darNo)) != "") ComClearObject(darNo);
 					if (ComTrim(ComGetObjValue(bkgNo)) != "") ComClearObject(bkgNo);
 					if (ComTrim(ComGetObjValue(blNo)) != "") ComClearObject(blNo);					
 					break;
 					
 				case "bkgNo":
 					if (ComTrim(ComGetObjValue(sCNo)) != "") ComClearObject(sCNo);
 					if (ComTrim(ComGetObjValue(rFANo)) != "") ComClearObject(rFANo);
 					if (ComTrim(ComGetObjValue(proposalNo)) != "") ComClearObject(proposalNo);
 					if (ComTrim(ComGetObjValue(darNo)) != "") ComClearObject(darNo);
 					if (ComTrim(ComGetObjValue(approvalNo)) != "") ComClearObject(approvalNo);
 					if (ComTrim(ComGetObjValue(blNo)) != "") ComClearObject(blNo);					
 					break;
 					
 				case "blNo":
 					if (ComTrim(ComGetObjValue(sCNo)) != "") ComClearObject(sCNo);
 					if (ComTrim(ComGetObjValue(rFANo)) != "") ComClearObject(rFANo);
 					if (ComTrim(ComGetObjValue(proposalNo)) != "") ComClearObject(proposalNo);
 					if (ComTrim(ComGetObjValue(darNo)) != "") ComClearObject(darNo);
 					if (ComTrim(ComGetObjValue(approvalNo)) != "") ComClearObject(approvalNo);
 					if (ComTrim(ComGetObjValue(bkgNo)) != "") ComClearObject(bkgNo);						
 					break;				
 			}
 		}		
 	}
 	 
  	/**
  	 * Type 의 선택이나 선택해제에 따라 해당 Sheet 를 보여주거나 감추는 동작을 수행하는 함수
  	 */ 	 
 	function displayGridByType() {
 		var formObj = document.form;
		 var sheetRcvSCObj = sheetObjects[0];
		 var sheetRcvBBObj = sheetObjects[1];
		 var sheetRcvABObj = sheetObjects[2];
		 var sheetSntSCObj = sheetObjects[3];
		 var sheetSntBBObj = sheetObjects[4];
		 var sheetSntABObj = sheetObjects[5];
		 
 		var displayGridCount = 0;
 		with(formObj) {
	 		for (var typeNo = 0 ; typeNo < searchType.length ; typeNo++) {
	 			if (searchType[typeNo].checked) {
	 				displayGridCount++;
	 			}
	 		}
	 		
	 		//선택한 Type 의 갯수에 따라서 늘어날 IBSHEET 의 높이를 구한다.
	 		var addHeight = 0;
	 		switch(displayGridCount) {
		 		case 1:
		 			addHeight = 190;
			 		if (conditionLayer.style.display == 'none') {
			 			addHeight += 150;
			 		}
		 			break;
		 		case 2:
		 			addHeight = 40;
			 		if (conditionLayer.style.display == 'none') {
			 			addHeight += 40;
			 		}
		 		case 3:
			 		if (conditionLayer.style.display == 'none') {
			 			addHeight += 30;
			 		}				 		
		 			break;
	 		}
	 		
 	 		//S/C Exception Tariff
 	 		if (searchType[0].checked) {
 	 			receivedTabSCTariffLayer.style.display = 'block';
 	 			sentTabSCTariffLayer.style.display = 'block';
 	 			
 	 			sheetRcvSCObj.style.height = IBSHEET_HEIGHT + addHeight;
 	 			sheetSntSCObj.style.height = IBSHEET_HEIGHT + addHeight;
 	 		}
 	 		else {
 	 			receivedTabSCTariffLayer.style.display = 'none';
 	 			sentTabSCTariffLayer.style.display = 'none';
 	 		}
 	 		
 	 		//Before Booking DAR
 	 		if (searchType[1].checked) {
 	 			receivedTabBeforeBookingLayer.style.display = 'block';
 	 			sentTabBeforeBookingLayer.style.display = 'block';
 	 			
 	 			sheetRcvBBObj.style.height = IBSHEET_HEIGHT + addHeight;
 	 			sheetSntBBObj.style.height = IBSHEET_HEIGHT + addHeight; 	 			
 	 		}
 	 		else {
 	 			receivedTabBeforeBookingLayer.style.display = 'none';
 	 			sentTabBeforeBookingLayer.style.display = 'none';
 	 		}
 	 		
 	 		//After Booking DAR
 	 		if (searchType[2].checked) {
 	 			receivedTabAfterBookingLayer.style.display = 'block';
 	 			sentTabAfterBookingLayer.style.display = 'block';
 	 			
 	 			sheetRcvABObj.style.height = IBSHEET_HEIGHT + addHeight;
 	 			sheetSntABObj.style.height = IBSHEET_HEIGHT + addHeight;
 	 		}
 	 		else {
 	 			receivedTabAfterBookingLayer.style.display = 'none';
 	 			sentTabAfterBookingLayer.style.display = 'none';
 	 		} 	 			
 		}
 	}
   	
  	/**
  	 * Office 컬럼에 기본값을 설정해주는 함수
  	 */
  	function setDefaultOffice() {
  		var formObj = document.form;
  		var cboTariff = comboObjects[0];
  		 
	 	with(formObj) {
	 		//Tariff 조회필드 비활성화
	 		//cboTariff.Text = "";
	 		//cboTariff.Enable = false;
	 		
		 	//Office 조회필드 비활성화 및  값 자동설정
	 		ComEnableManyObjects(false, office);
	 		switch(login_ofc_cd.value) {
	 			case "SELHO"  :
	 			case "SELCON" :
	 			case "SELSKM" :
		 		case "SELSGM" :
		 		case "SELSTA" :
		 		case "SELSTE" :
		 		case "SELSTI" :
		 		case "SELCMA" :
		 		case "SELCMS" :
		 		case "SELCMU" :
		 		case "SELCMB" :
		 			ComSetObjValue(office, "SELHO");
		 			ComSetObjValue(usr_ofc_cd, "SELHO");
		 			ComSetObjValue(ofc_cd, "SELHO,SELCON,SELSKM,SELSGM,SELSTA,SELSTE,SELSTI,SELCMA,SELCMS,SELCMU,SELCMB");
		 			break;
		 		
		 		case "SELIB" :
		 		case "SELSC" :
		 		case "SELBE" :
		 		case "SELBK" :
		 			ComSetObjValue(office, "SELIB");
		 			ComSetObjValue(usr_ofc_cd, "SELIB");
		 			ComSetObjValue(ofc_cd, "SELIB,SELSC,SELBE,SELBK");
		 			break;
		 			
		 		case "NYCRA"  :
		 		case "NYCRAO" :
		 		case "NYCRAS" :
		 		case "NYCRAC" :
		 			ComSetObjValue(office, "NYCRA");
		 			ComSetObjValue(usr_ofc_cd, "NYCRA");
		 			ComSetObjValue(ofc_cd, "NYCRAO,NYCRAS,NYCRA,NYCRAC");	 			
		 			break;
		 			
		 		case "HAMRU"  :
		 		case "HAMRUO" :
		 		case "HAMRUS" :
		 		case "HAMRUC" :
		 			ComSetObjValue(office, "HAMRU");
		 			ComSetObjValue(usr_ofc_cd, "HAMRU");
		 			ComSetObjValue(ofc_cd, "HAMRUO,HAMRUS,HAMRU,HAMRUC");
		 			break;
		 			
		 		case "SHARC"  :
		 		case "SHARCO" :
		 		case "SHARCS" :
		 			ComSetObjValue(office, "SHARC");
		 			ComSetObjValue(usr_ofc_cd, "SHARC");
		 			ComSetObjValue(ofc_cd, "SHARCO,SHARCS,SHARC");
		 			break;		 			
		 		
		 		case "SINRS"  :
		 		case "SINRSO" :
		 		case "SINRSS" :
		 		case "SINRSC" :
		 			ComSetObjValue(office, "SINRS");
		 			ComSetObjValue(usr_ofc_cd, "SINRS");
		 			ComSetObjValue(ofc_cd, "SINRSO,SINRSS,SINRS,SINRSC");
		 			break;	
		 			
		 		default :
		 			ComSetObjValue(office, login_ofc_cd.value);
		 			ComSetObjValue(usr_ofc_cd, login_ofc_cd.value);
		 			ComSetObjValue(ofc_cd, login_ofc_cd.value);
	 		}
	 	}  		
  	}
  	
   /**
   	* User Only 컬럼 체크시 To/Cc 상태를 변경해 주는 함수
    */
  	function modifyToCc() {
  		var formObj = document.form;
  		
  		//User Only 선택시 To/CC는 "To" 또는 " All" 유지 및 비활성화
  		with(formObj) {
  			if (formObj.userOnly.checked) {
  				ComSetObjValue(toCc, "to");
  				
  				ComEnableManyObjects(false, toCc);
  				toCc.className = "input2";
  			}
  			else {
 				ComSetObjValue(toCc, "");
  				
  				ComEnableManyObjects(true, toCc);
  				toCc.className = "input";  				
  			}
  		}
  	}
   	
   /**
 	* Customer Code 를 8 자리에 맞춰서 반환시켜주는 함수 
 	*/	
    function fetchLeftPadding(custCd) {
    	var result = custCd;
    	
    	if (custCd != "" && custCd.length > 2) {
			var custCnt = custCd.substring(0,2);
			var custSeq = custCd.substring(2);
	
			switch(custSeq.length) {
				case 1: custSeq = "00000" + custSeq;
					break;
				case 2: custSeq = "0000" + custSeq;
					break;
				case 3: custSeq = "000" + custSeq;
					break;
				case 4: custSeq = "00" + custSeq;
					break;
				case 5: custSeq = "0" + custSeq;
					break;
			}
			result = custCnt + custSeq;
    	}
    	return result;
    }
 	
   /**
 	* Req Office 와 Approval Office 가 동일한지 체크해주는 함수
 	*/	 	
    function isSameOffice(reqOfc, apvlOfc) {

    	if (reqOfc == apvlOfc) return true;
    	
    	var office = new Array();    	
    	
    	office[0] = "SELHO,SELCON,SELSKM,SELSGM,SELSTA,SELSTE,SELSTI,SELCMA,SELCMS,SELCMU,SELCMB";
    	office[1] = "NYCRAO,NYCRAS,NYCRA,NYCRAC";
    	office[2] = "HAMRUO,HAMRUS,HAMRU,HAMRUC";
    	office[3] = "SHARCO,SHARCS,SHARC";
    	office[4] = "SINRSO,SINRSS,SINRS,SINRSC";
    	
    	for (var i = 0 ; i < office.length ; i++) {
    		
    		var array = office[i].split(",");
    		
    		var isSameOfc		= false;
    		var isSameReqOfc 	= false;
    		var isSameApvlOfc	= false;
    		
    		for (var j = 0 ; j < array.length ; j++) {
    			
    			if (!isSameReqOfc && reqOfc == array[j]) {
    				isSameReqOfc = true;
    			}
    			
    			if (!isSameApvlOfc && apvlOfc == array[j]) {
    				isSameApvlOfc = true;
    			}
    			
    			if (isSameReqOfc && isSameApvlOfc) {
    				isSameOfc = true;
    				break;
    			}
    		}
    		
    		if (isSameOfc) return true;
    	}
    	
    	return false;
    }
 	
    /**
    * 서버로부터 정상적으로 전달받지 못한 데이터를 처리해주는 함수 
    */
   function handleNullString(sVal) {
   	
        if (sVal == undefined || sVal == "null" || sVal.length == 0) return "";

        return ComTrim(sVal);
   } 	