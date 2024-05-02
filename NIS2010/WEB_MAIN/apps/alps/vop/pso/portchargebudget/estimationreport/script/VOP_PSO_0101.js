/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0101.js
*@FileTitle : Monthly Estimation Comparison
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.02
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2009.07.07 김진일
* 1.0 Creation
* 2013.07.23 SKY   CHM-201325675 [VOP-PSO] 추정 Report 보완 요청 (0 값제외)
* 2013.09.03 SKY   CHM-201326398 Monthly Estimation Comparision 검색 조건(Scenario CD) 추가
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
     * @class vop_pso_0101 : vop_pso_0101 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_pso_0101() {
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
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;

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
        	
	            case "btns_calendar_s":
	            	var cal = new ComCalendar();
	            	cal.setDisplayType('month');
		            cal.select(form.rev_yrmon, "yyyy-MM");
	            	break;
	            	
	            case "btns_calendarsn":
					var cal = new ComCalendar();
					cal.setDisplayType('year');
					cal.select(form.scn_dt, 'yyyy');
					break;	 	
	
	            case "btn_Retrieve":
	            	sheetObjects[2].RemoveAll();
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
					
	            case "btn_raw1":        		
	            	formObject.raw_flg.value = "TM"
					doActionIBSheet(sheetObjects[0],formObject,SEARCH01);
					break;
					
	            case "btn_raw2":
	            	if(ComGetObjValue(formObject.chk_rdo) == "B"){
	            		doActionIBSheet(sheetObjects[0],formObject,SEARCH02);
	            	}else{
	                	formObject.raw_flg.value = ComGetObjValue(formObject.chk_rdo);
	    				doActionIBSheet(sheetObjects[0],formObject,SEARCH01);
	            	}
	
					break;
	            case "btn_New":
	            	//조회조건 Clear 
		        	sheetObjects[0].RemoveAll();
		        	sheetObjects[1].RemoveAll();
		        	sheetObjects[2].RemoveAll();
		        	setToday(document.form.rev_yrmon, "ym");
		        	obj_click();
	            	break;
	
					
				case "btn_down_excel":
					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
	
					break;
					
				default : break;
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
  
        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
       	for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
         document.form.scn_cd.Code = "BP";

		initControl();

    }
    

	/*
	 * Form의 필드 초기화 및 이벤트 초기화 
	 *  
	 */
	function initControl(){
		axon_event.addListener ('keydown', 'obj_keydown', 'form');
    	axon_event.addListenerFormat('keypress',  'obj_keypress', 	form);
     	axon_event.addListenerForm('keyup', 'obj_keyup', form); //Focus이동관련
        axon_event.addListenerForm  ('click','obj_click', form); 
    	setToday(document.form.rev_yrmon, "ym");//올해 설정
     	document.form.rev_yrmon.focus();
	}
	 


    /**
     * keypress처리 함수
     * @return
     */
    function obj_keypress(){
  	    obj = event.srcElement;
  	    var srcName = event.srcElement.getAttribute("name");
  	    var srcValue = event.srcElement.getAttribute("value");
  	    if(obj.dataformat == null) return;
  	    window.defaultStatus = obj.dataformat;
  	
  	    switch(obj.dataformat) {
  	        case "ymd":
  	        case "ym":
		  	  if (srcValue.length == 4) {
  		  		  document.form.elements[srcName].value = srcValue.substring(0,4) + "-";
  		  	  }
  	            ComKeyOnlyNumber(obj);
  	            break;
  	        case "hms":
  	        case "hm":
  	        case "jumin":
  	        case "saupja":
  	            ComKeyOnlyNumber(obj);
  	            break;
  	        case "int":
  	            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
  	            else ComKeyOnlyNumber(obj);
  	            break;
  	        case "float":
  	            ComKeyOnlyNumber(obj, "-.");
  	            break;
  	        case "eng":
  	            ComKeyOnlyAlphabet(); break;
  	        case "engup":
  	            if(obj.name=="txtEngUp2") ComKeyOnlyAlphabet('uppernum')
  	            else if(obj.name==="vndr_lgl_eng_nm") toUpper();//소문자만 대문자로.
  	            else ComKeyOnlyAlphabet('upper');
  	            break;
  	        case "engdn":
  	            if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
  	            else ComKeyOnlyAlphabet('lower');
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
     	  var sheetid = sheetObj.id;
           switch(sheetid) {

     				case "sheet1": // This Month summary
     					with (sheetObj) {
     							// 높이 설정
     							style.height = 445;
     							//전체 너비 설정
     							SheetWidth = mainTable.clientWidth;

     							//Host정보 설정[필수][HostIp, Port, PagePath]
     							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

     							//전체Merge 종류 [선택, Default msNone]
     							MergeSheet = msHeaderOnly;

     							//전체Edit 허용 여부 [선택, Default false]
     							Editable = false;
     							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
     							InitRowInfo(2, 1, 3, 100);
     							var HeadTitle1 = "This Month|This Month|This Month|This Month|This Month|This Month|This Month|This Month";
     							var HeadTitle2 = "Rev Lane|VVD Cnt|Port Cnt|ACT Port Cnt|Port|VVD Cnt|Canal|Port Charge";
     							var headCount = ComCountHeadTitle(HeadTitle1);

     							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
     							InitColumnInfo(headCount, 0, 0, true);

     							// 해더에서 처리할 수 있는 각종 기능을 설정한다
     							InitHeadMode(true, true, false, true, false,false);

     							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
     							InitHeadRow(0, HeadTitle1, true);
     							InitHeadRow(1, HeadTitle2, true);

     							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
     							InitDataProperty(0,	cnt++, dtData,		80,	  daCenter,   true,	     "rlane_cd",	   false,	   "", dfNone,			  0,	 false,	     false);
     							InitDataProperty(0, cnt++, dtAutoSum,   65,   daRight,    true,      "sum_cnt1",       false,      "", dfNullInteger,         0,     false,      false);    							
     							InitDataProperty(0, cnt++, dtAutoSum,   65,   daRight,    true,      "sum_cnt_port",   false,      "", dfNullInteger,         0,     false,      false);
     							InitDataProperty(0, cnt++, dtAutoSum,   90,   daRight,    true,      "sum_act_port",   false,      "", dfNullFloat,           1,     false,      false);
     							InitDataProperty(0, cnt++, dtAutoSum,   100,  daRight,    true,      "sum_amt1",       false,      "", dfNullFloat,           2,     false,      false);
     							InitDataProperty(0, cnt++, dtAutoSum,   65,   daRight,    true,      "sum_cnt2",       false,      "", dfNullInteger,         0,     false,      false);
     							InitDataProperty(0, cnt++, dtAutoSum,  100,   daRight,    true,      "sum_amt2",       false,      "", dfNullFloat,           2,     false,      false);
     							InitDataProperty(0, cnt++, dtAutoSum,  100,   daRight,    true,      "total_sum_amt",  false,      "", dfNullFloat,           2,     false,      false);
 						
     							CountPosition = 0;
     						}
     						break;
     						
     				case "sheet2": //Retrieve : Budget,Previous Month,Previous Year summary
     					with (sheetObj) {
 							// 높이 설정
 							style.height = 445;
 							//전체 너비 설정
 							SheetWidth = mainTable.clientWidth;

 							//Host정보 설정[필수][HostIp, Port, PagePath]
 							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 							//전체Merge 종류 [선택, Default msNone]
 							MergeSheet = msHeaderOnly;

 							//전체Edit 허용 여부 [선택, Default false]
 							Editable = false;

 							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 							InitRowInfo(2, 1, 3, 100);
 							var HeadTitle1 = "Budget|Budget|Budget|Budget|Budget|Budget|Budget|Budget";
 							var HeadTitle2 = "Rev Lane|VVD Cnt|Port Cnt|ACT Port Cnt|Port|VVD Cnt|Canal|Port Charge";
 							var headCount = ComCountHeadTitle(HeadTitle1);

 							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 							InitColumnInfo(headCount, 0, 0, true);

 							// 해더에서 처리할 수 있는 각종 기능을 설정한다
 							InitHeadMode(true, true, false, true, false,false);

 							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 							InitHeadRow(0, HeadTitle1, true);
 							InitHeadRow(1, HeadTitle2, true);

 							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 							InitDataProperty(0,	cnt++, dtData,		80,	  daCenter,   true,	     "rlane_cd",	   false,	   "", dfNone,			  0,	 false,	     false);
 							InitDataProperty(0, cnt++, dtAutoSum,   65,   daRight,    true,      "sum_cnt1",       false,      "", dfNullInteger,         0,     false,      false);    							
 							InitDataProperty(0, cnt++, dtAutoSum,   65,   daRight,    true,      "sum_cnt_port",   false,      "", dfNullInteger,         0,     false,      false);
 							InitDataProperty(0, cnt++, dtAutoSum,   90,   daRight,    true,      "sum_act_port",   false,      "", dfNullFloat,           1,     false,      false);
 							InitDataProperty(0, cnt++, dtAutoSum,   100,  daRight,    true,      "sum_amt1",       false,      "", dfNullFloat,           2,     false,      false);
 							InitDataProperty(0, cnt++, dtAutoSum,   65,   daRight,    true,      "sum_cnt2",       false,      "", dfNullInteger,         0,     false,      false);
 							InitDataProperty(0, cnt++, dtAutoSum,  100,   daRight,    true,      "sum_amt2",       false,      "", dfNullFloat,           2,     false,      false);
 							InitDataProperty(0, cnt++, dtAutoSum,  100,   daRight,    true,      "total_sum_amt",  false,      "", dfNullFloat,           2,     false,      false);

 							CountPosition = 0;

 						}
 						break;
     						
     						
     				case "sheet3": //Difference
     					with (sheetObj) {
 							// 높이 설정
 							style.height = 445;
 							//전체 너비 설정
 							SheetWidth = mainTable.clientWidth;

 							//Host정보 설정[필수][HostIp, Port, PagePath]
 							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 							//전체Merge 종류 [선택, Default msNone]
 							MergeSheet = msHeaderOnly;

 							//전체Edit 허용 여부 [선택, Default false]
 							Editable = false;

 							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 							InitRowInfo(2, 1, 3, 100);
 							var HeadTitle1 = "Difference|Difference|Difference|Difference|Difference|Difference|Difference|Difference";
 							var HeadTitle2 = "Rev Lane|VVD Cnt|Port Cnt|ACT Port Cnt|Port|VVD Cnt|Canal|Port Charge";
 							var headCount = ComCountHeadTitle(HeadTitle1);

 							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 							InitColumnInfo(headCount, 0, 0, true);

 							// 해더에서 처리할 수 있는 각종 기능을 설정한다
 							InitHeadMode(true, true, false, true, false,false);

 							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 							InitHeadRow(0, HeadTitle1, true);
 							InitHeadRow(1, HeadTitle2, true);

 							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 							InitDataProperty(0,	cnt++, dtData,		80,	  daCenter,   true,	     "rlane_cd",	    false, 	    "", dfNone,			       0,	  false,	  false);
 							InitDataProperty(0, cnt++, dtAutoSum,   65,   daRight,    true,      "sum_cnt1",        false,      "", dfNullInteger,         0,     false,      false);    							
 							InitDataProperty(0, cnt++, dtAutoSum,   65,   daRight,    true,      "sum_cnt_port",    false,      "", dfNullInteger,         0,     false,      false);
 							InitDataProperty(0, cnt++, dtAutoSum,   90,   daRight,    true,      "sum_act_port",    false,      "", dfNullFloat,           1,     false,      false);
 							InitDataProperty(0, cnt++, dtAutoSum,   100,  daRight,    true,      "sum_amt1",        false,      "", dfNullFloat,           2,     false,      false);
 							InitDataProperty(0, cnt++, dtAutoSum,   65,   daRight,    true,      "sum_cnt2",        false,      "", dfNullInteger,         0,     false,      false);
 							InitDataProperty(0, cnt++, dtAutoSum,   100,  daRight,    true,      "sum_amt2",        false,      "", dfNullFloat,           2,     false,      false);
 							InitDataProperty(0, cnt++, dtAutoSum,   100,  daRight,    true,      "total_sum_amt",   false,      "", dfNullFloat,           2,     false,      false);
 							
 							CountPosition = 0;

 						}
 						break;
 						
     				case "sheet4": // Raw data : 추정결산 VVD별 집계 
 					with (sheetObj) {
 						// 높이 설정
 						style.height = 0;
 						//전체 너비 설정
 						SheetWidth = mainTable.clientWidth;

 						//Host정보 설정[필수][HostIp, Port, PagePath]
 						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 						//전체Merge 종류 [선택, Default msNone]
 						MergeSheet = msHeaderOnly;

 						//전체Edit 허용 여부 [선택, Default false]
 						Editable = false;

 						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 						InitRowInfo(1, 1, 3, 100);
 						var HeadTitle1 = "REV_YRMON|RLANE_CD|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|ESTM_AMT|ACT_AMT|ACCL_AMT|ESTM_PORT_AMT|ESTM_CANAL_AMT|" 
 							+ "ACT_PORT_AMT|ACT_CANAL_AMT|ACCL_PORT_AMT|ACCL_CANAL_AMT|Design Capa";

 						var headCount = ComCountHeadTitle(HeadTitle1);

 						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 						InitColumnInfo(headCount, 0, 0, true);

 						// 해더에서 처리할 수 있는 각종 기능을 설정한다
 						InitHeadMode(true, true, false, true, false,false);

 						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 						InitHeadRow(0, HeadTitle1, true);


 						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 						InitDataProperty(0,	cnt++, dtData,	80,	daCenter,	true,	   "rev_yrmon",		   false,	   "", dfDateYm,	 0,	    false,	    false);
 						InitDataProperty(0, cnt++, dtData,  65, daRight,    true,      "rlane_cd",         false,      "", dfNone,       0,     false,      false);
 						InitDataProperty(0, cnt++, dtData,  65, daRight,    true,      "vsl_cd",           false,      "", dfNone,       0,     false,      false);
 						
 						InitDataProperty(0, cnt++, dtData,  65, daRight,    true,      "skd_voy_no",       false,      "", dfNone,       0,     false,      false);
 						InitDataProperty(0, cnt++, dtData,  90, daRight,    true,      "skd_dir_cd",       false,      "", dfNone,       0,     false,      false);		
 						InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "estm_amt",         false,      "", dfFloat,      2,      false,      false);
 						InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "act_amt",          false,      "", dfFloat,      2,      false,      false);
 						InitDataProperty(0, cnt++, dtData,  65, daRight,    true,      "accl_amt",         false,      "", dfFloat,      2,      false,      false);
 						InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "estm_port_amt",    false,      "", dfFloat,      2,      false,      false);
 						InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "estm_canal_amt",   false,      "", dfFloat,      2,      false,      false);
 						
 						InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "act_port_amt",     false,      "", dfFloat,      2,      false,      false);
 						InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "act_canal_amt",    false,      "", dfFloat,      2,      false,      false);
 						InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "accl_port_amt",    false,      "", dfFloat,      2,      false,      false);
 						InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "accl_canal_amt",   false,      "", dfFloat,      2,      false,      false);
 						InitDataProperty(0, cnt++, dtData,  80, daRight,    true,      "cntr_dzn_capa",    false,      "", dfNullInteger,2,      false,      false);

 						CountPosition = 0;
 					}
 					break;
     				case "sheet5": // Raw data : 추정결산 YD별 집계
 					with (sheetObj) {
 						// 높이 설정
 						style.height = 0;
 						//전체 너비 설정
 						SheetWidth = mainTable.clientWidth;

 						//Host정보 설정[필수][HostIp, Port, PagePath]
 						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 						//전체Merge 종류 [선택, Default msNone]
 						MergeSheet = msHeaderOnly;

 						//전체Edit 허용 여부 [선택, Default false]
 						Editable = false;

 						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 						InitRowInfo(1, 1, 3, 100);
 						var HeadTitle1 = "REV_YRMON|RLANE_CD|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|LOC_CD|ESTM_AMT|ACT_AMT|ACCL_AMT|ESTM_PORT_AMT|ESTM_CANAL_AMT|" 
 							+ "ACT_PORT_AMT|ACT_CANAL_AMT|ACCL_PORT_AMT|ACCL_CANAL_AMT|Design Capa";

 						var headCount = ComCountHeadTitle(HeadTitle1);

 						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 						InitColumnInfo(headCount, 0, 0, true);

 						// 해더에서 처리할 수 있는 각종 기능을 설정한다
 						InitHeadMode(true, true, false, true, false,false);

 						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 						InitHeadRow(0, HeadTitle1, true);


 						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 						InitDataProperty(0,	cnt++, dtData,	80,	daCenter,	true,	   "rev_yrmon",		   false,	   "", dfDateYm,	 0,	    false,	    false);
 						InitDataProperty(0, cnt++, dtData,  65, daRight,    true,      "rlane_cd",         false,      "", dfNone,       0,     false,      false);
 						InitDataProperty(0, cnt++, dtData,  65, daRight,    true,      "vsl_cd",           false,      "", dfNone,       0,     false,      false);
 						
 						InitDataProperty(0, cnt++, dtData,  65, daRight,    true,      "skd_voy_no",       false,      "", dfNone,       0,     false,      false);
 						InitDataProperty(0, cnt++, dtData,  90, daRight,    true,      "skd_dir_cd",       false,      "", dfNone,       0,     false,      false);
 						InitDataProperty(0, cnt++, dtData,  90, daRight,    true,      "loc_cd",           false,      "", dfNone,       0,     false,      false);
 						InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "estm_amt",         false,      "", dfFloat,      2,      false,      false);
 						InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "act_amt",          false,      "", dfFloat,      2,      false,      false);
 						InitDataProperty(0, cnt++, dtData,  65, daRight,    true,      "accl_amt",         false,      "", dfFloat,      2,      false,      false);
 						InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "estm_port_amt",    false,      "", dfFloat,      2,      false,      false);
 						InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "estm_canal_amt",   false,      "", dfFloat,      2,      false,      false);
 						
 						InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "act_port_amt",     false,      "", dfFloat,      2,      false,      false);
 						InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "act_canal_amt",    false,      "", dfFloat,      2,      false,      false);
 						InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "accl_port_amt",    false,      "", dfFloat,      2,      false,      false);
 						InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "accl_canal_amt",   false,      "", dfFloat,      2,      false,      false);
 						InitDataProperty(0, cnt++, dtData,  80,  daRight,   true,      "cntr_dzn_capa",    false,      "", dfNullInteger,2,      false,      false);

 						CountPosition = 0;
 					}
 					break;
     				case "sheet6": // Raw data : 추정결산 ACCT별 집계
 					with (sheetObj) {
 							// 높이 설정
 							style.height = 0;
 							//전체 너비 설정
 							SheetWidth = mainTable.clientWidth;

 							//Host정보 설정[필수][HostIp, Port, PagePath]
 							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 							//전체Merge 종류 [선택, Default msNone]
 							MergeSheet = msHeaderOnly;

 							//전체Edit 허용 여부 [선택, Default false]
 							Editable = false;

 							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 							InitRowInfo(1, 1, 3, 100);
 							var HeadTitle1 = "REV_YRMON|RLANE_CD|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|LOC_CD|ACCT_CD|ESTM_AMT|ACT_AMT|ACCL_AMT|ESTM_PORT_AMT|ESTM_CANAL_AMT|" 
 								+ "ACT_PORT_AMT|ACT_CANAL_AMT|ACCL_PORT_AMT|ACCL_CANAL_AMT|Design Capa";

 							var headCount = ComCountHeadTitle(HeadTitle1);

 							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 							InitColumnInfo(headCount, 0, 0, true);

 							// 해더에서 처리할 수 있는 각종 기능을 설정한다
 							InitHeadMode(true, true, false, true, false,false);

 							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 							InitHeadRow(0, HeadTitle1, true);


 							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 							InitDataProperty(0,	cnt++, dtData,	80,	daCenter,	true,	   "rev_yrmon",		   false,	   "", dfDateYm,	 0,	    false,	    false);
 							InitDataProperty(0, cnt++, dtData,  65, daRight,    true,      "rlane_cd",         false,      "", dfNone,       0,     false,      false);
 							InitDataProperty(0, cnt++, dtData,  65, daRight,    true,      "vsl_cd",           false,      "", dfNone,       0,     false,      false);
 							
 							InitDataProperty(0, cnt++, dtData,  65, daRight,    true,      "skd_voy_no",       false,      "", dfNone,       0,     false,      false);
 							InitDataProperty(0, cnt++, dtData,  90, daRight,    true,      "skd_dir_cd",       false,      "", dfNone,       0,     false,      false);
 							InitDataProperty(0, cnt++, dtData,  90, daRight,    true,      "loc_cd",           false,      "", dfNone,       0,     false,      false);
 							InitDataProperty(0, cnt++, dtData,  90, daRight,    true,      "acct_cd",           false,      "", dfNone,       0,     false,      false);
 							InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "estm_amt",         false,      "", dfFloat,      2,      false,      false);
 							InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "act_amt",          false,      "", dfFloat,      2,      false,      false);
 							InitDataProperty(0, cnt++, dtData,  65, daRight,    true,      "accl_amt",         false,      "", dfFloat,      2,      false,      false);
 							InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "estm_port_amt",    false,      "", dfFloat,      2,      false,      false);
 							InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "estm_canal_amt",   false,      "", dfFloat,      2,      false,      false);
 							
 							InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "act_port_amt",     false,      "", dfFloat,      2,      false,      false);
 							InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "act_canal_amt",    false,      "", dfFloat,      2,      false,      false);
 							InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "accl_port_amt",    false,      "", dfFloat,      2,      false,      false);
 							InitDataProperty(0, cnt++, dtData,  100, daRight,   true,      "accl_canal_amt",   false,      "", dfFloat,      2,      false,      false);
 							InitDataProperty(0, cnt++, dtData,  80,  daRight,   true,      "cntr_dzn_capa",    false,      "", dfNullInteger,2,      false,      false);

 							CountPosition = 0;
 						}
 						break;
 						
     				case "sheet7": // Raw data for budget : 추정결산 VBP별 집계	
     				case "sheet8": // Raw data for budget : 추정결산 VVD별 집계
 					with (sheetObj) {
 						// 높이 설정
 						style.height = 0;
 						//전체 너비 설정
 						SheetWidth = mainTable.clientWidth;

 						//Host정보 설정[필수][HostIp, Port, PagePath]
 						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 						//전체Merge 종류 [선택, Default msNone]
 						MergeSheet = msHeaderOnly;

 						//전체Edit 허용 여부 [선택, Default false]
 						Editable = false;

 						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 						InitRowInfo(1, 1, 3, 100);

 						var HeadTitle1 = "RLANE_CD|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|PORT_CHARGE|CANAL_FEE|Design Capa";

 						var headCount = ComCountHeadTitle(HeadTitle1);

 						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 						InitColumnInfo(headCount, 0, 0, true);

 						// 해더에서 처리할 수 있는 각종 기능을 설정한다
 						InitHeadMode(true, true, false, true, false,false);

 						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 						InitHeadRow(0, HeadTitle1, true);


 						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]				
 						InitDataProperty(0, cnt++, dtData,  65, daRight,    true,     "rlane_cd",         false,      "", dfNone,       0,     false,      false);
 						InitDataProperty(0, cnt++, dtData,  65, daRight,    true,     "vsl_cd",           false,      "", dfNone,       0,     false,      false);
 						InitDataProperty(0, cnt++, dtData,  65, daRight,    true,     "skd_voy_no",       false,      "", dfNone,       0,     false,      false);
 						InitDataProperty(0, cnt++, dtData,  90, daRight,    true,     "skd_dir_cd",       false,      "", dfNone,       0,     false,      false);
 						InitDataProperty(0, cnt++, dtData,  100, daRight,   true,     "port_charge",      false,      "", dfFloat,      2,     false,      false);
 						InitDataProperty(0, cnt++, dtData,  100, daRight,   true,     "canal_fee",        false,      "", dfFloat,      2,     false,      false);
 						InitDataProperty(0, cnt++, dtData,  80,  daRight,   true,     "cntr_dzn_capa",    false,      "", dfNullInteger,2,     false,      false);

 						CountPosition = 0;
 					}
 				
     				break;	
     				
     				
     				case "sheet9": // Raw data for budget : 추정결산 YD별 집계
     				with (sheetObj) {
 						// 높이 설정
 						style.height = 0;
 						//전체 너비 설정
 						SheetWidth = mainTable.clientWidth;

 						//Host정보 설정[필수][HostIp, Port, PagePath]
 						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 						//전체Merge 종류 [선택, Default msNone]
 						MergeSheet = msHeaderOnly;

 						//전체Edit 허용 여부 [선택, Default false]
 						Editable = false;

 						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 						InitRowInfo(1, 1, 3, 100);

 						var HeadTitle1 = "RLANE_CD|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|YD_CD|PORT_CHARGE|CANAL_FEE|Design Capa";

 						var headCount = ComCountHeadTitle(HeadTitle1);

 						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 						InitColumnInfo(headCount, 0, 0, true);

 						// 해더에서 처리할 수 있는 각종 기능을 설정한다
 						InitHeadMode(true, true, false, true, false,false);

 						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 						InitHeadRow(0, HeadTitle1, true);


 						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]				
 						InitDataProperty(0, cnt++, dtData,  65,  daRight,    true,     "rlane_cd",         false,      "", dfNone,       0,     false,      false);
 						InitDataProperty(0, cnt++, dtData,  65,  daRight,    true,     "vsl_cd",           false,      "", dfNone,       0,     false,      false);
 						InitDataProperty(0, cnt++, dtData,  65,  daRight,    true,     "skd_voy_no",       false,      "", dfNone,       0,     false,      false);
 						InitDataProperty(0, cnt++, dtData,  90,  daRight,    true,     "skd_dir_cd",       false,      "", dfNone,       0,     false,      false);
 						InitDataProperty(0, cnt++, dtData,  90,  daRight,    true,     "yd_cd",            false,      "", dfNone,       0,     false,      false);
 						InitDataProperty(0, cnt++, dtData,  100, daRight,    true,     "port_charge",      false,      "", dfFloat,      2,     false,      false);
 						InitDataProperty(0, cnt++, dtData,  100, daRight,    true,     "canal_fee",        false,      "", dfFloat,      2,     false,      false);
 						InitDataProperty(0, cnt++, dtData,  80,  daRight,    true,     "cntr_dzn_capa",    false,      "", dfNullInteger,2,     false,      false);

 						CountPosition = 0;
 					}
 				
     				break;	
     				case "sheet10": // Raw data for budget : 추정결산 ACCT별 집계
 					with (sheetObj) {
 							// 높이 설정
 							style.height = 0;
 							//전체 너비 설정
 							SheetWidth = mainTable.clientWidth;

 							//Host정보 설정[필수][HostIp, Port, PagePath]
 							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 							//전체Merge 종류 [선택, Default msNone]
 							MergeSheet = msHeaderOnly;

 							//전체Edit 허용 여부 [선택, Default false]
 							Editable = false;

 							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 							InitRowInfo(1, 1, 3, 100);

 							var HeadTitle1 = "RLANE_CD|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|YD_CD|ACCT_CD|LGS_COST_CD|PORT_CHARGE|CANAL_FEE|Design Capa";

 							var headCount = ComCountHeadTitle(HeadTitle1);

 							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 							InitColumnInfo(headCount, 0, 0, true);

 							// 해더에서 처리할 수 있는 각종 기능을 설정한다
 							InitHeadMode(true, true, false, true, false,false);

 							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 							InitHeadRow(0, HeadTitle1, true);


 							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]				
 							InitDataProperty(0, cnt++, dtData,  65, daRight,    true,     "rlane_cd",         false,      "", dfNone,       0,     false,      false);
 							InitDataProperty(0, cnt++, dtData,  65, daRight,    true,     "vsl_cd",           false,      "", dfNone,       0,     false,      false);
 							InitDataProperty(0, cnt++, dtData,  65, daRight,    true,     "skd_voy_no",       false,      "", dfNone,       0,     false,      false);
 							InitDataProperty(0, cnt++, dtData,  90, daRight,    true,     "skd_dir_cd",       false,      "", dfNone,       0,     false,      false);
 							InitDataProperty(0, cnt++, dtData,  90, daRight,    true,     "yd_cd",            false,      "", dfNone,       0,     false,      false);
 							InitDataProperty(0, cnt++, dtData,  90, daRight,    true,     "acct_cd",          false,      "", dfNone,       0,     false,      false);
 							InitDataProperty(0, cnt++, dtData,  90, daRight,    true,     "lgs_cost_cd",      false,      "", dfNone,       0,     false,      false);
 							InitDataProperty(0, cnt++, dtData,  100, daRight,   true,     "port_charge",      false,      "", dfFloat,      2,     false,      false);
 							InitDataProperty(0, cnt++, dtData,  100, daRight,   true,     "canal_fee",        false,      "", dfFloat,      2,     false,      false);
 							InitDataProperty(0, cnt++, dtData,  80,  daRight,   true,     "cntr_dzn_capa",    false,      "", dfNullInteger,2,     false,      false);

 							CountPosition = 0;
 						}
     				
 					break;	

 						
     			case "sheet11": // 엑셀다운용 sheet1	
 				case "sheet12": //엑셀다운용 sheet2
 				case "sheet13": //엑셀다운용 sheet3
 				case "sheet14": //엑셀다운용 sheet1
 				case "sheet15": //엑셀다운용 sheet2
 				case "sheet16": //엑셀다운용 sheet3
 				case "sheet17": //엑셀다운용 sheet1
 				case "sheet18": //엑셀다운용 sheet2
 				case "sheet19": //엑셀다운용 sheet3

 				
 					with (sheetObj) {
 						// 높이 설정
 						style.height = 0;
 						//전체 너비 설정
 						SheetWidth = mainTable.clientWidth;

 						//Host정보 설정[필수][HostIp, Port, PagePath]
 						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 						//전체Merge 종류 [선택, Default msNone]
 						MergeSheet = msHeaderOnly;

 						//전체Edit 허용 여부 [선택, Default false]
 						Editable = false;

 						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 						InitRowInfo(2, 1, 3, 100);
 						if(sheetid == "sheet11" || sheetid == "sheet14" || sheetid == "sheet17"){
 							var HeadTitle1 = "This Month|This Month|This Month|This Month|This Month|This Month|This Month|This Month";
 						}else if(sheetid == "sheet12"){
 							var HeadTitle1 = "Budget|Budget|Budget|Budget|Budget|Budget|Budget|Budget";
 						}else if(sheetid == "sheet15"){
 							var HeadTitle1 = "Previous Month|Previous Month|Previous Month|Previous Month|Previous Month|Previous Month|Previous Month|Previous Month"; 
 						}else if(sheetid == "sheet18"){
 							var HeadTitle1 = "Previous Year|Previous Year|Previous Year|Previous Year|Previous Year|Previous Year|Previous Year|Previous Year";
 						}else{
 							var HeadTitle1 = "Difference|Difference|Difference|Difference|Difference|Difference|Difference|Difference";
 						}
 						var HeadTitle2 = "Rev Lane|VVD Cnt|Port Cnt|ACT Port Cnt|Port|VVD Cnt|Canal|Port Charge";
 						var headCount = ComCountHeadTitle(HeadTitle1);

 						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 						InitColumnInfo(headCount, 0, 0, true);

 						// 해더에서 처리할 수 있는 각종 기능을 설정한다
 						InitHeadMode(true, true, false, true, false,false);

 						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 						InitHeadRow(0, HeadTitle1, true);
 						InitHeadRow(1, HeadTitle2, true);

 						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 						InitDataProperty(0,	cnt++, dtData,		65,	  daCenter,   true,	     "rlane_cd",	   false,	   "", dfNone,                0,	 false,	     false);
 						InitDataProperty(0, cnt++, dtAutoSum,   65,   daRight,    true,      "sum_cnt1",       false,      "", dfNullInteger,         0,     false,      false);    							
 						InitDataProperty(0, cnt++, dtAutoSum,   65,   daRight,    true,      "sum_cnt_port",   false,      "", dfNullInteger,         0,     false,      false);
 						InitDataProperty(0, cnt++, dtAutoSum,   90,   daRight,    true,      "sum_act_port",   false,      "", dfNullFloat,           1,     false,      false);
 						InitDataProperty(0, cnt++, dtAutoSum,   100,  daRight,    true,      "sum_amt1",       false,      "", dfNullFloat,           2,     false,      false);
 						InitDataProperty(0, cnt++, dtAutoSum,   65,   daRight,    true,      "sum_cnt2",       false,      "", dfNullInteger,         0,     false,      false);
 						InitDataProperty(0, cnt++, dtAutoSum,  100,   daRight,    true,      "sum_amt2",       false,      "", dfNullFloat,           2,     false,      false);
 						InitDataProperty(0, cnt++, dtAutoSum,  100,   daRight,    true,      "total_sum_amt",  false,      "", dfNullFloat,           2,     false,      false);

 						CountPosition = 0;

 					}
 					break;
 						

             }
     }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible=false;
        switch (sAction) {
			case IBSEARCH: //조회
				if (validateForm(sheetObj, formObj, sAction)) {
						
					sheetObj.WaitImageVisible = false;
					formObj.f_cmd.value = SEARCH;
					ComOpenWait(true);
	                var sXml = sheetObj.GetSearchXml("VOP_PSO_0101GS.do", FormQueryString(formObj));
	                ComOpenWait(false);
					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 2) 
						sheetObjects[0].LoadSearchXml(arrXml[0]); 
					if (arrXml.length > 1) 
						sheetObjects[1].LoadSearchXml(arrXml[1]); 
					if (arrXml.length > 0) 
						sheetObjects[2].LoadSearchXml(arrXml[2]); 

					sortBlank(sheetObjects[0],sheetObjects[2]);
					sortBlank(sheetObjects[1],sheetObjects[2]);
//			 		sortByVvdCnt(sheetObjects[0]);
//			 		sortByVvdCnt(sheetObjects[1]);

				}

				break;
				
			case SEARCH01: //raw data retrieve
					formObj.f_cmd.value = SEARCH01;
					ComOpenWait(true);
	                var sXml = sheetObj.GetSearchXml("VOP_PSO_0101GS.do",FormQueryString(formObj));
	                
	                
					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 2) 
						sheetObjects[3].LoadSearchXml(arrXml[0]); 
					if (arrXml.length > 1) 
						sheetObjects[4].LoadSearchXml(arrXml[1]); 
					if (arrXml.length > 0) 
						sheetObjects[5].LoadSearchXml(arrXml[2]); 
					
					
					if (validateForm(sheetObj, formObj, sAction)){
						sheetObjects[3].SpeedDown2Excel(-1,false,false,"","",false,false,"VVD별");
						sheetObjects[4].SpeedDown2Excel(-1, true, true,"","",false,false,"YD별");
						sheetObjects[5].SpeedDown2Excel(-1, true, true,"","",false,false,"ACCOUNT별");
					}
					
					ComOpenWait(false);
					break;
			
			case SEARCH02: //raw data for budget retrieve
				formObj.f_cmd.value = SEARCH02;
				ComOpenWait(true);
	            var sXml = sheetObj.GetSearchXml("VOP_PSO_0101GS.do",FormQueryString(formObj));

				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 3) 
					sheetObjects[6].LoadSearchXml(arrXml[0]); 
				if (arrXml.length > 2) 
					sheetObjects[7].LoadSearchXml(arrXml[1]); 
				if (arrXml.length > 1) 
					sheetObjects[8].LoadSearchXml(arrXml[2]); 
				if (arrXml.length > 0) 
					sheetObjects[9].LoadSearchXml(arrXml[3]); 
				
				

				sheetObjects[6].SpeedDown2Excel(-1, false,false,"","",false,false,"VVD(VBP용)");
				sheetObjects[7].SpeedDown2Excel(-1, true, true,"","",false,false,"VVD별");
				sheetObjects[8].SpeedDown2Excel(-1, true, true,"","",false,false,"YD별");
				sheetObjects[9].SpeedDown2Excel(-1, true, true,"","",false,false,"ACCT별");


				
				ComOpenWait(false);
				break;
				
			case IBDOWNEXCEL: //전체엑셀다운
				ComOpenWait(true);

				var param = "f_cmd="+SEARCH + "&rev_yrmon=" + formObj.rev_yrmon.value + "&chk_rdo=B" + "&scn_cd="  +  formObj.scn_cd.Code;
		
	            var sXmlA = sheetObj.GetSearchXml("VOP_PSO_0101GS.do",param);	
	            
	            
			     
				var arrXml = sXmlA.split("|$$|");
	
				if (arrXml.length > 2) 
					sheetObjects[10].LoadSearchXml(arrXml[0]); 
				if (arrXml.length > 1) 
					sheetObjects[11].LoadSearchXml(arrXml[1]); 
				if (arrXml.length > 0) 
					sheetObjects[12].LoadSearchXml(arrXml[2]); 
				
		

				param = "f_cmd="+SEARCH + "&rev_yrmon=" + formObj.rev_yrmon.value + "&chk_rdo=PM";
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0101GS.do",param);
				

				
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 2) 
					sheetObjects[13].LoadSearchXml(arrXml[0]);
				if (arrXml.length > 1) 

					sheetObjects[14].LoadSearchXml(arrXml[1]);				
				if (arrXml.length > 0) 
					sheetObjects[15].LoadSearchXml(arrXml[2]); 

				param = "f_cmd="+SEARCH + "&rev_yrmon=" + formObj.rev_yrmon.value + "&chk_rdo=PY";
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0101GS.do",param);
			
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 2)
					sheetObjects[16].LoadSearchXml(arrXml[0]); 
				if (arrXml.length > 1)

					sheetObjects[17].LoadSearchXml(arrXml[1]); 
				if (arrXml.length > 0) 
					sheetObjects[18].LoadSearchXml(arrXml[2]); 
				
				sheetObjects[12].ColumnSort("sum_cnt1", "ASC");
				sheetObjects[15].ColumnSort("sum_cnt1", "ASC");
				sheetObjects[18].ColumnSort("sum_cnt1", "ASC");
				
		

				sortByVvdCnt(sheetObjects[10],sheetObjects[12]);
				sortByVvdCnt(sheetObjects[11],sheetObjects[12]);
				sortByVvdCnt(sheetObjects[13],sheetObjects[15]);
				sortByVvdCnt(sheetObjects[14],sheetObjects[15]);
				sortByVvdCnt(sheetObjects[16],sheetObjects[18]);
				sortByVvdCnt(sheetObjects[17],sheetObjects[18]);
				
				setExcelFile();
				ComOpenWait(false);
				break;

		}
    }
    
    
    /**
     * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
     * @param combo_obj
     * @return
     */
    function setComboObject(combo_obj){

    	comboObjects[comboCnt++] = combo_obj;

    }    
    
    /**
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
        function initCombo(comboObj, comboNo) {
            var formObj = document.form;
            switch(comboObj.id) {
            	case "scn_cd":
            		with (comboObj) { 
        				MultiSelect = false;
        				DropHeight = 320;
        				InsertItem(0, 'BP','BP');
        				InsertItem(1, 'PR','PR');
        				InsertItem(2, 'Q1','Q1');
        				InsertItem(3, 'Q2','Q2');
        				InsertItem(4, 'Q3','Q3');
        				InsertItem(5, 'Q4','Q4');
        				UseAutoComplete = true;
        				ValidChar(2, 0);
        				MaxLength = 2;
        			}
        			break;
             }
        }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	var scn_dt = formObj.scn_dt;
		var scn_cd = formObj.scn_cd;
		
		with (formObj) {
			if (ComIsNull(scn_dt) || ComChkLen(scn_dt, 4) == 1 )  {
				return false;
			}
		}
        return true;
        
   	  switch (sAction) {   	 
	    case IBSEARCH: //조회
	
			 if(formObj.rev_yrmon.value === "" || formObj.rev_yrmon.value === "undefined"){
				 ComShowCodeMessage("PSO00003", "[Revenue Month]");
				 formObj.rev_yrmon.focus();
				 return false;
			 }
		  	
			break;
		
		    case SEARCH01: //raw data retrieve
			 if(sheetObjects[3].RowCount == 0 || sheetObjects[4].RowCount == 0 || sheetObjects[5].RowCount == 0){
				 ComShowCodeMessage("PSO09013");
				 return false;
			 }
		    
		    break;
   	  }
		return true;
    }
     
     function obj_click() {
    	var formObj = document.form;  
 		var sheetObj = sheetObjects[1];
 		with(formObj) { 
 			switch(event.srcElement.name){
 	            case "chk_rdo":// 라디오 버튼 클릭시 sheetObjects[1] 상단의 이름변경 및 Excel sheet name setting
 	            	if (event.srcElement.value == "PM") {	            		
 	            		var HeadTitle1 = "Previous Month|Previous Month|Previous Month|Previous Month|Previous Month|Previous Month|Previous Month|Previous Month|Previous Month";

 	            	} else if (event.srcElement.value == "PY") {
 	            		
            			var HeadTitle1 = "Previous Year|Previous Year|Previous Year|Previous Year|Previous Year|Previous Year|Previous Year|Previous Year|Previous Year";

 	            	}  else if (event.srcElement.value == "B") {
 	            		
            			var HeadTitle1 = "Budget|Budget|Budget|Budget|Budget|Budget|Budget|Budget";	 	

 	            	} 

	            	sheetObjects[1].InitHeadRow(0, HeadTitle1, true);
	         		sheetObjects[1].RemoveAll();
	         		sheetObjects[2].RemoveAll();
	 	            break;
	 	            
	 	            
 	           case "btn_New":
 	        	  formObj.chk_rdo[0].checked = true;
 	        	  var HeadTitle1 = "Budget|Budget|Budget|Budget|Budget|Budget|Budget|Budget";	 
 	        	  sheetObjects[1].InitHeadRow(0, HeadTitle1, true);
 	        	  break;
 			}
 		}
     }
     

 	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {

 		for (var i=2; i < sheetObj.Rows; i++){
 			for (var j=1; j < 8; j++){
 	 			if(sheetObj.CellValue(i,j).substring(0,1) == "-"){
 	 				sheetObj.CellFontColor(i,j) = sheetObj.RgbColor(255,0,0); 
 	 			}else {
 	 				sheetObj.CellFontColor(i,j) = sheetObj.RgbColor(0,0,0); 
 	 			}
 			}
 		}

	}
 	function sheet3_OnSort(Col, SortArrow)  {
 		sortByVvdCnt(sheetObjects[0],sheetObjects[2]);
 		sortByVvdCnt(sheetObjects[1],sheetObjects[2]);

 	}
 	
 	function sortByVvdCnt(sheetObj,sheetObj3){
 		var sheetRow = sheetObj.Rows;
 		for(var i=2;i<sheetObj3.Rows-1;i++){
			
	
			  var nRow = sheetObj.DataInsert(-1);
		
		    for(var k=2;k<sheetRow-1;k++){
	 			if(sheetObj.CellValue(k,"rlane_cd")==sheetObj3.CellValue(i,"rlane_cd")){
//	 				if(sheetObj.RowHidden(k)){
//	 					sheetObj.RowHidden(nRow) = true;
//	 				}else{
	 			       sheetObj.CellValue(nRow,"rlane_cd") = sheetObj3.CellValue(i,"rlane_cd");
		 				sheetObj.CellValue(nRow,"sum_cnt1") = sheetObj.CellValue(k,"sum_cnt1");
		 				sheetObj.CellValue(nRow,"sum_cnt_port") = sheetObj.CellValue(k,"sum_cnt_port");
		 				sheetObj.CellValue(nRow,"sum_act_port") = sheetObj.CellValue(k,"sum_act_port");
		 				sheetObj.CellValue(nRow,"sum_amt1") = sheetObj.CellValue(k,"sum_amt1");
		 				sheetObj.CellValue(nRow,"sum_cnt2") = sheetObj.CellValue(k,"sum_cnt2");
		 				sheetObj.CellValue(nRow,"sum_amt2") = sheetObj.CellValue(k,"sum_amt2");
		 				sheetObj.CellValue(nRow,"sum_amt2") = sheetObj.CellValue(k,"sum_amt2");
		 				sheetObj.CellValue(nRow,"total_sum_amt") = sheetObj.CellValue(k,"total_sum_amt");
//	 				}
	 				break;
	 			}

	 				
	 				
 			}
		
 	}

		while(sheetRow>3){
			sheetObj.RowDelete(2, false);
			sheetRow--;
		}		
 	}
 	
 	function sortBlank(sheetObj,sheetObj3){
		var sheetRow = sheetObj.Rows;

		for(var i=2;i<sheetObj3.Rows-1;i++){
			
 			if(sheetObj.CellValue(i,"rlane_cd")!=sheetObj3.CellValue(i,"rlane_cd")){
				sheetObj.SelectRow = i-1;
				var nRow = sheetObj.DataInsert();
//				sheetObj.CellValue(nRow,"rlane_cd") = "";
//					sheetObj.RowHidden(nRow) = true;
	 			
			}
			
		}
	
	}
 	
 	function setExcelFile(){
		
 		sheetObjects[10].Down2Excel(0,false,true,false,"","",false,false,"Budget(Rolling) Plan대비");
 		sheetObjects[11].Down2Excel(0,true,false,false,"","",false,false,"");
 		sheetObjects[12].Down2Excel(0,true,false,false,"","",false,false,"");
 		sheetObjects[13].Down2Excel(0,true,true,false,"","",false,false,"전월대비");
 		sheetObjects[14].Down2Excel(0,true,false,false,"","",false,false,"");
 		sheetObjects[15].Down2Excel(0,true,false,false,"","",false,false,"");
 		sheetObjects[16].Down2Excel(0,true,true,false,"","",false,false,"전년동월대비");
 		sheetObjects[17].Down2Excel(0,true,false,false,"","",false,false,"");
 		sheetObjects[18].Down2Excel(0,true,false,false,"","",false,false,"")
	

		
	
	}
 
	/* 개발자 작업  끝 */