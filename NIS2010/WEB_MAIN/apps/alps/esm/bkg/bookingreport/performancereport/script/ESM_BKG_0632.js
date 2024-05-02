/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0632.js
*@FileTitle : Sales Performance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.09.01 강동윤
* 1.0 Creation
* 2010.12.21 변종건 [CHM-201007715-01] [BKG] Sales Performance Report 컨테이너 타입사이즈 추가
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
     * @class ESM_BKG_0632 : ESM_BKG_0632 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0632() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.setComboObject 		= setComboObject;
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var combo1 = null;
    var comboCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    

        /**
         * IBSheet Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setSheetObject(sheet_obj){
        	sheetObjects[sheetCnt++] = sheet_obj;
        }
         
        function setComboObject(combo_obj){
        	comboObjects[comboCnt++] = combo_obj;
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
            
            //MultiCombo초기화 
	 	    for(var k=0;k<comboObjects.length;k++){
	 	    	initCombo(comboObjects[k],comboObjects[k].id);
	 	    }
            
            initControl();
            
            doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
            
            document.form.vvd_sig.focus();
        }
      
     /**
      * 콤보 초기설정값
      * @param {IBMultiCombo} comboObj  comboObj
      */
      function initCombo(comboObj, comboId) {
    	  comboObj.MultiSelect = false;
    	  comboObj.UseCode = true;
    	  //comboObj.LineColor = "#ffffff";
    	  //comboObj.SetColAlign("left|left");
    	  comboObj.MultiSeparator = ",";
    	  comboObj.DropHeight = 170;      	
    	  
    	  if (comboId == "vvd"){
    		  
    		  comboObj.MultiSelect = true;
        	  comboObj.UseEdit = true;
        	  comboObj.BackColor = "#CCFFFD";
    	  }else if (comboId == "grp_by"){
    		  
    		  comboObj.MultiSelect = true;
    	  }
    	  
    	  UseAutoComplete = true; // 편집시 자동 코드 검색
      }  
    
           
      /**
      * 조회조건 입력할 때 처리
      */
     function obj_KeyUp() {
	     var formObject = document.form;
	     var srcName = window.event.srcElement.getAttribute("name");
	     var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	     var srcValue = window.event.srcElement.getAttribute("value");
	     if (ComChkLen(srcValue, srcMaxLength) == "2") {
	     	ComSetNextFocus();
	     }
     }
          /**
       * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
       * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
       * 
       * @param {ibsheet}
       *            sheetObj IBSheet Object
       * @param {int}
       *            sheetNo sheetObjects 배열에서 순번
       */
      function initControl() {
      	var formObject = document.form;
      	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
          axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
          axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
          axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- 키보드 입력할때
          
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
          axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
      }
      
     /**
	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
	 **/
     function obj_keypress(){
		switch(event.srcElement.dataformat){
	    	case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engupnum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}


      /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;
    				var sheetID = sheetObj.id;
    				
            switch(sheetID) {
    				case "sheet1":      //sheet1 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 312;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msPrevColumnMerge;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = false;

                        InitRowInfo( 2, 1, 3, 100);
                        
                        var HeadTitle1 = "VVD|BKG\nPOD|Loading Volume|Loading Volume|Loading Volume|Void Slot|Void Slot|Gross\nRevenue|Revenue Class|Revenue Class|Revenue Class|Non-Rev\n(Others)|Revenue Per Box|Revenue Per Box";
                        var HeadTitle2 = "VVD|BKG\nPOD|TEU|FEU|TTL(TEU)|20'|40'|Gross\nRevenue|Net|Non Net|MISC|Non-Rev\n(Others)|20'|40'";
                        
                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        var headCount = ComCountHeadTitle(HeadTitle1);
												InitColumnInfo(headCount, 0, 0, true);
												
                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(false, false, true, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        //InitDataProperty(0, cnt++ , dtHiddenStatus,	 40,    daCenter,  true,   "HidStatus");
                        //InitDataProperty(0, cnt++ , dtSeq,      	 30,    daCenter,  true,   "Seq");
                        InitDataProperty(0, cnt++ , dtData,		   	 90,    daCenter,  true,   "vvd",    	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,        70,    daCenter,  true,   "bkg_pod", 	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,     	 75,    daRight,   true,   "teu",    	 false,          "",      dfNone,  			0,     false,       true);
                                                                  	                                                                     
                        InitDataProperty(0, cnt++ , dtData,     	 80,    daRight,   true,   "feu",    	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,     	 85,    daRight,   true,   "ttl",    	 false,          "",      dfNone,  			0,     false,       true);
                        
                        InitDataProperty(0, cnt++ , dtData,     	 75,    daRight,   false,   "void_teu",    	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,     	 80,    daRight,   false,   "void_feu",    	 false,          "",      dfNone,  			0,     false,       true);
                        
                        InitDataProperty(0, cnt++ , dtData,        80,    daRight,   true,   "gross",  	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,        80,    daRight,   true,   "net",    	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,        80,    daRight,   true,   "non_net", 	 false,          "",      dfNone,   		0,     false,       true);
                                                                  	                                                                            		
                        InitDataProperty(0, cnt++ , dtData,        80,    daRight,   true,   "misc",   	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,        80,    daRight,   true,   "non_rev", 	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,        100,   daRight,   true,   "teu_gross",  false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,        100,   daRight,   true,   "feu_gross",  false,          "",      dfNone,   		0,     false,       true); 
                        

    					CountPosition = 0;
    					
    					SetMergeCell(0, 7, 2, 1);  
    					SetMergeCell(0, 11, 2, 1);
                   }
                    break;

    				case "sheet2":      //sheet2 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height =310;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msPrevColumnMerge;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 3, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(19, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        var HeadTitle1 = "VVD|Lane|Origin|POD|Load Volume|Load Volume|Void Slot|Load\nTEU TTL|Gross\nRevenue|RPB(Teu)|RPB(Teu)|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class";
                        var HeadTitle2 = "VVD|Lane|Origin|POD|20'|40'|TEU|Load\nTEU TTL|Gross\nRevenue|Plus Void|EQ|OFT|BAF|CAF|OTH|DTH|DOC|TAC|Other";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        //InitDataProperty(0, cnt++ , dtHiddenStatus,	 40,    daCenter,  true,   "HidStatus");
                        //InitDataProperty(0, cnt++ , dtSeq,      		 20,    daCenter,  true,   "Seq");
                        InitDataProperty(0, cnt++ , dtData,		   		 85,    daCenter,  true,   "VVD",      	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 65,    daCenter,  true,   "Lane",     	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 55,    daCenter,  true,   "Origin",   	 false,          "",      dfNone,  			0,     false,       true);
                                                                  	                                                                             			
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "POD",      	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "20",       	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "40",       	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "TEU",      	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 90,    daRight,  true,   "TEUTTL",   	 false,          "",      dfNone,   		0,     false,       true);
                                                                  	                   
                        InitDataProperty(0, cnt++ , dtData,       	 90,    daRight,  true,   "Gross",    	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "PlusVoid", 	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "EQ",       	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "OFT",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "BAF",      	 false,          "",      dfNone,   		0,     false,       true); 
                                                                                       
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "CAF",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "OTH",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "DTH",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "DOC",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "TAC",      	 false,          "",      dfNone,   		0,     false,       true); 
                                                                                                         
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "Other",    	 false,          "",      dfNone,   		0,     false,       true);                                                                                                                                             

    					CountPosition = 0;
    					
    					SetMergeCell(0, 7, 2, 1);
    					SetMergeCell(0, 8, 2, 1);
    									
                   }
                    break; 
                     
                      
    				case "sheet3":      //sheet3 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 310;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msPrevColumnMerge;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 3, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(21, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        var HeadTitle1 = "VVD|Lane|Origin|POD|Load Volume|Load Volume|Void Slot|Void Slot|Load\nTEU TTL|Gross\nRevenue|RPB(Teu)|RPB(Teu)|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class";
                        var HeadTitle2 = "VVD|Lane|Origin|POD|20'|40'|20'|40'|Load\nTEU TTL|Gross\nRevenue|Plus Void|EQ|D2|D4|D5|R2|R4|RD2|RD4|S2|S4";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        //InitDataProperty(0, cnt++ , dtHiddenStatus,	 40,    daCenter,  true,   "HidStatus");
                        //InitDataProperty(0, cnt++ , dtSeq,      		 20,    daCenter,  true,   "Seq");
                        InitDataProperty(0, cnt++ , dtData,		   		 90,    daCenter,  true,   "VVD",      	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "Lane",     	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "Origin",   	 false,          "",      dfNone,  			0,     false,       true);
                                                                  	                                                                             			
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "POD",      	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Load20",   	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Load40",   	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Void20",   	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Void40",   	 false,          "",      dfNone,   		0,     false,       true);
                        
                        InitDataProperty(0, cnt++ , dtData,       	 90,    daRight,  true,   "TEUTTL",   	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 90,    daRight,  true,   "Gross",    	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "PlusVoid", 	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "EQ",       	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "D2",      	 false,          "",      dfNone,   		0,     false,       true); 
                                                                      
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "D4",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "D5",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "R2",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "R4",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "RD2",      	 false,          "",      dfNone,   		0,     false,       true); 
                                                                      
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "RD4",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "S2",    	 	 false,          "",      dfNone,   		0,     false,       true);                                                                                                                                             
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "S4",    	 	 false,          "",      dfNone,   		0,     false,       true);

    					CountPosition = 0;
    					
    					SetMergeCell(0, 8, 2, 1);
    					SetMergeCell(0, 9, 2, 1);

                   }
                    break;                   
                     
                      
    				case "sheet4":      //sheet4 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 310;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msPrevColumnMerge;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 3, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(25, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        var HeadTitle1 = "VVD|Lane|Origin|POD|Sales Office|Sales Office|Sales Office|Sales Office|Sales Office|Load Volume|Load Volume|Void Slot|Void Slot|Load\nTEU TTL|Gross\nRevenue|RPB(Teu)|RPB(Teu)|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class";
                        var HeadTitle2 = "VVD|Lane|Origin|POD|R/HQ|R/OFC|R/OFC|OFC|OFC|20'|40'|20'|40'|Load\nTEU TTL|Gross\nRevenue|Plus Void|EQ|OFT|BAF|CAF|OTH|DTH|DOC|TAC|Other";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        //InitDataProperty(0, cnt++ , dtHiddenStatus,	 40,    daCenter,  true,   "HidStatus");
                        //InitDataProperty(0, cnt++ , dtSeq,      		 15,    daCenter,  true,   "Seq");
                        InitDataProperty(0, cnt++ , dtData,		   		 90,    daCenter,  true,   "VVD",      	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "Lane",     	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "Origin",   	 false,          "",      dfNone,  			0,     false,       true);
                                                                  	                                                                             			
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "POD",      	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "RHQ",      	 false,          "",      dfNone,  			0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 30,    daCenter,  true,   "ROFC1",    	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "ROFC2",    	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 30,    daCenter,  true,   "OFC1",     	 false,          "",      dfNone,  			0,     false,       true);

                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "OFC2",    	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Load20",   	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Load40",   	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Void20",   	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Void40",   	 false,          "",      dfNone,   		0,     false,       true);

                        InitDataProperty(0, cnt++ , dtData,       	 90,    daRight,  true,   "TEUTTL",   	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 90,    daRight,  true,   "Gross",    	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "PlusVoid", 	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "EQ",       	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "OFT",      	 false,          "",      dfNone,   		0,     false,       true); 
                                                                      
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "BAF",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "CAF",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "OTH",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "DTH",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "DOC",      	 false,          "",      dfNone,   		0,     false,       true); 
                                                                      
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "TAC",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "Other",    	 false,          "",      dfNone,   		0,     false,       true);                                                                                                                                             

    					CountPosition = 0;
    					
    					SetMergeCell(0, 13, 2, 1);
    					SetMergeCell(0, 14, 2, 1);

                   }
                    break;     
                    
                    
    				case "sheet5":      //sheet5 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 310;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msPrevColumnMerge;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 3, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(22, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        var HeadTitle1 = "VVD|Lane|Origin|POD|Rep Commodity|Rep Commodity|Load Volume|Load Volume|Void Slot|Void Slot|Load\nTEU TTL|Gross\nRevenue|RPB(Teu)|RPB(Teu)|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class";
                        var HeadTitle2 = "VVD|Lane|Origin|POD|Code|Name|20'|40'|20'|40'|Load\nTEU TTL|Gross\nRevenue|Plus Void|EQ|OFT|BAF|CAF|OTH|DTH|DOC|TAC|Other";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        //InitDataProperty(0, cnt++ , dtHiddenStatus,	 40,    daCenter,  true,   "HidStatus");
                        //InitDataProperty(0, cnt++ , dtSeq,      		 15,    daCenter,  true,   "Seq");
                        InitDataProperty(0, cnt++ , dtData,		   		 70,    daCenter,  true,   "VVD",      	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "Lane",     	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "Origin",   	 false,          "",      dfNone,  			0,     false,       true);
                                                                  	                                                                             			
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "POD",      	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "Code",     	 false,          "",      dfNone,  			0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 200,   daLeft,  true,   "Name",    	 false,          "",      dfNone,  			0,     false,       true);

                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Load20",   	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Load40",   	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Void20",   	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Void40",   	 false,          "",      dfNone,   		0,     false,       true);

                        InitDataProperty(0, cnt++ , dtData,       	 90,    daRight,  true,   "TEUTTL",   	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 90,    daRight,  true,   "Gross",    	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "PlusVoid", 	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "EQ",       	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "OFT",      	 false,          "",      dfNone,   		0,     false,       true); 
                                                                      
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "BAF",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "CAF",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "OTH",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "DTH",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "DOC",      	 false,          "",      dfNone,   		0,     false,       true); 
                                                                      
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "TAC",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "Other",    	 false,          "",      dfNone,   		0,     false,       true);                                                                                                                                             


    					CountPosition = 0;
    					
    					SetMergeCell(0, 10, 2, 1);
    					SetMergeCell(0, 11, 2, 1);

                   }
                    break;     
                    
                    
    				case "sheet6":      //sheet6 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 310;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msPrevColumnMerge;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 3, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(22, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        var HeadTitle1 = "VVD|Lane|Origin|POD|Customer(Shipper)|Customer(Shipper)|Load Volume|Load Volume|Void Slot|Void Slot|Load\nTEU TTL|Gross\nRevenue|RPB(Teu)|RPB(Teu)|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class";
                        var HeadTitle2 = "VVD|Lane|Origin|POD|Code|Name|20'|40'|20'|40'|Load\nTEU TTL|Gross\nRevenue|Plus Void|EQ|OFT|BAF|CAF|OTH|DTH|DOC|TAC|Other";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        //InitDataProperty(0, cnt++ , dtHiddenStatus,	 40,    daCenter,  true,   "HidStatus");
                        //InitDataProperty(0, cnt++ , dtSeq,      		 15,    daCenter,  true,   "Seq");
                        InitDataProperty(0, cnt++ , dtData,		   		 70,    daCenter,  true,   "VVD",      	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "Lane",     	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "Origin",   	 false,          "",      dfNone,  			0,     false,       true);
                                                                  	                                                                             			
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "POD",      	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "Code",     	 false,          "",      dfNone,  			0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 200,   daLeft,  true,   "Name",    	 false,          "",      dfNone,  			0,     false,       true);

                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Load20",   	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Load40",   	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Void20",   	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Void40",   	 false,          "",      dfNone,   		0,     false,       true);

                        InitDataProperty(0, cnt++ , dtData,       	 90,    daRight,  true,   "TEUTTL",   	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 90,    daRight,  true,   "Gross",    	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "PlusVoid", 	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "EQ",       	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "OFT",      	 false,          "",      dfNone,   		0,     false,       true); 
                                                                      
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "BAF",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "CAF",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "OTH",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "DTH",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "DOC",      	 false,          "",      dfNone,   		0,     false,       true); 
                                                                      
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "TAC",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "Other",    	 false,          "",      dfNone,   		0,     false,       true);                                                                                                                                             


    					CountPosition = 0;
    					
    					SetMergeCell(0, 10, 2, 1);
    					SetMergeCell(0, 11, 2, 1);

                   }
                    break;  
                    
                    
    				case "sheet7":      //sheet7 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 310;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msPrevColumnMerge;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 3, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(22, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        var HeadTitle1 = "VVD|Lane|Origin|POD|Customer(Group)|Customer(Group)|Load Volume|Load Volume|Void Slot|Void Slot|Load\nTEU TTL|Gross\nRevenue|RPB(Teu)|RPB(Teu)|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class";
                        var HeadTitle2 = "VVD|Lane|Origin|POD|Code|Name|20'|40'|20'|40'|Load\nTEU TTL|Gross\nRevenue|Plus Void|EQ|OFT|BAF|CAF|OTH|DTH|DOC|TAC|Other";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        //InitDataProperty(0, cnt++ , dtHiddenStatus,	 40,    daCenter,  true,   "HidStatus");
                        //InitDataProperty(0, cnt++ , dtSeq,      		 15,    daCenter,  true,   "Seq");
                        InitDataProperty(0, cnt++ , dtData,		   		 70,    daCenter,  true,   "VVD",      	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "Lane",     	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "Origin",   	 false,          "",      dfNone,  			0,     false,       true);
                                                                  	                                                                             			
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "POD",      	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 100,    daCenter,  true,   "Code",     	 false,          "",      dfNone,  			0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 200,   daLeft,  true,   "Name",    	 false,          "",      dfNone,  			0,     false,       true);

                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Load20",   	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Load40",   	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Void20",   	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Void40",   	 false,          "",      dfNone,   		0,     false,       true);

                        InitDataProperty(0, cnt++ , dtData,       	 90,    daRight,  true,   "TEUTTL",   	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 90,    daRight,  true,   "Gross",    	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "PlusVoid", 	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "EQ",       	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "OFT",      	 false,          "",      dfNone,   		0,     false,       true); 
                                                                      
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "BAF",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "CAF",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "OTH",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "DTH",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "DOC",      	 false,          "",      dfNone,   		0,     false,       true); 
                                                                      
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "TAC",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "Other",    	 false,          "",      dfNone,   		0,     false,       true);                                                                                                                                             


    					CountPosition = 0;
    					
    					SetMergeCell(0, 10, 2, 1);
    					SetMergeCell(0, 11, 2, 1);

                   }
                    break;  
                     
                      
    				case "sheet8":      //sheet8 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 310;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msPrevColumnMerge;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 3, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(22, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        var HeadTitle1 = "VVD|Lane|Origin|POD|Sales Rep|Sales Rep|Load Volume|Load Volume|Void Slot|Void Slot|Load\nTEU TTL|Gross\nRevenue|RPB(Teu)|RPB(Teu)|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class";
                        var HeadTitle2 = "VVD|Lane|Origin|POD|Code|Name|20'|40'|20'|40'|Load\nTEU TTL|Gross\nRevenue|Plus Void|EQ|OFT|BAF|CAF|OTH|DTH|DOC|TAC|Other";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        //InitDataProperty(0, cnt++ , dtHiddenStatus,	 40,    daCenter,  true,   "HidStatus");
                        //InitDataProperty(0, cnt++ , dtSeq,      		 15,    daCenter,  true,   "Seq");
                        InitDataProperty(0, cnt++ , dtData,		   		 70,    daCenter,  true,   "VVD",      	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "Lane",     	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "Origin",   	 false,          "",      dfNone,  			0,     false,       true);
                                                                  	                                                                             			
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "POD",      	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "Code",     	 false,          "",      dfNone,  			0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 150,    daLeft,  true,   "Name",    	 false,          "",      dfNone,  			0,     false,       true);

                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Load20",   	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Load40",   	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Void20",   	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Void40",   	 false,          "",      dfNone,   		0,     false,       true);

                        InitDataProperty(0, cnt++ , dtData,       	 90,    daRight,  true,   "TEUTTL",   	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 90,    daRight,  true,   "Gross",    	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "PlusVoid", 	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "EQ",       	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "OFT",      	 false,          "",      dfNone,   		0,     false,       true); 
                                                                      
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "BAF",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "CAF",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "OTH",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "DTH",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "DOC",      	 false,          "",      dfNone,   		0,     false,       true); 
                                                                      
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "TAC",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "Other",    	 false,          "",      dfNone,   		0,     false,       true);                                                                                                                                             


    					CountPosition = 0;
    					
    					SetMergeCell(0, 10, 2, 1);
    					SetMergeCell(0, 11, 2, 1);

                   }
                    break;                   
                    
                    
    			case "sheet9":      //sheet9 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 310;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msPrevColumnMerge;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 3, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(25, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        var HeadTitle1 = "VVD|Lane|Origin|POD|Inbound Office|Inbound Office|Inbound Office|Inbound Office|Inbound Office|Load Volume|Load Volume|Void Slot|Void Slot|Load\nTEU TTL|Gross\nRevenue|RPB(Teu)|RPB(Teu)|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class|Revenue Class";
                        var HeadTitle2 = "VVD|Lane|Origin|POD|R/HQ|R/OFC|R/OFC|OFC|OFC|20'|40'|20'|40'|Load\nTEU TTL|Gross\nRevenue|Plus Void|EQ|OFT|BAF|CAF|OTH|DTH|DOC|TAC|Other";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        //InitDataProperty(0, cnt++ , dtHiddenStatus,	 40,    daCenter,  true,   "HidStatus");
                        //InitDataProperty(0, cnt++ , dtSeq,      		 15,    daCenter,  true,   "Seq");
                        InitDataProperty(0, cnt++ , dtData,		   		 70,    daCenter,  true,   "VVD",      	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "Lane",     	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "Origin",   	 false,          "",      dfNone,  			0,     false,       true);
                                                                  	                                                                             			
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "POD",      	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "RHQ",      	 false,          "",      dfNone,  			0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "ROFC1",    	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "ROFC2",    	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "OFC1",     	 false,          "",      dfNone,  			0,     false,       true);

                        InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  true,   "OFC2",    	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Load20",   	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Load40",   	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Void20",   	 false,          "",      dfNone,  			0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 60,    daRight,  true,   "Void40",   	 false,          "",      dfNone,   		0,     false,       true);

                        InitDataProperty(0, cnt++ , dtData,       	 90,    daRight,  true,   "TEUTTL",   	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 90,    daRight,  true,   "Gross",    	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "PlusVoid", 	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "EQ",       	 false,          "",      dfNone,   		0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "OFT",      	 false,          "",      dfNone,   		0,     false,       true); 
                                                                      
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "BAF",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "CAF",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "OTH",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "DTH",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "DOC",      	 false,          "",      dfNone,   		0,     false,       true); 
                                                                      
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "TAC",      	 false,          "",      dfNone,   		0,     false,       true); 
                        InitDataProperty(0, cnt++ , dtData,       	 80,    daRight,  true,   "Other",    	 false,          "",      dfNone,   		0,     false,       true);                                                                                                                                             

    					CountPosition = 0;
    					
    					SetMergeCell(0, 13, 2, 1);
    					SetMergeCell(0, 14, 2, 1);

                   }
                    break; 

    			case "sheet10":      //sheet9 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 330;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msPrevColumnMerge + msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 3, 100);

                        var HeadTitle1 = "||Booking No.|B/L No.|Lane|T/VVD|POR|POL|POD|DEL|I/O|TEU TTL|TEU TTL|REV TTL|RPB|Shipper|Shipper|S/REP|S/OFC|CGO";
    					HeadTitle1 += "|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type|EQ Type";
    					HeadTitle1 += "|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type|Revenue E/Q Type";
                        HeadTitle1 += "|Charge Type|Charge Type|Charge Type|Charge Type|Charge Type|Charge Type|Charge Type|Charge Type";
    					HeadTitle1 += "|TOS|1st VVD|On Board|Week|Rep Commodith|Rep Commodith|IB CNT|IB OFC|SVC Mode|SVC Mode";
    					HeadTitle1 += "|Consignee or Notify|Consignee or Notify|Forwarder|Forwarder|OB RHQ|OB GSO|C/OFC|REP|RFA No.|S/C No.|BKG OFC|IB WK POD|IB WK";

    					var HeadTitle2 = "||Booking No.|B/L No.|Lane|T/VVD|POR|POL|POD|DEL|I/O|BKG|CNTR|(USD)|(TEU)|NAME|CD|S/REP|S/OFC|CGO";
    					HeadTitle2 += "|D2|D4|D5|D7|R2|R4|R5|RD2|RD4|F2|F4|O2|O4|P2|P4|T2|T4|Q2|Q4";
    					//HeadTitle2 += "|Rev D2|Rev D4|Rev R2|Rev R4|Rev RD2|Rev RD4|Rev RD2|Rev RD4|Rev F2|Rev F4|Rev 2|Rev 4|Rev P2|Rev P4|Rev T2|Rev T4|Rev Q2|Rev Q4";
    					HeadTitle2 += "|Rev D2|Rev D4|Rev D5|Rev D7|Rev R2|Rev R4|Rev R5|Rev RD2|Rev RD4|Rev F2|Rev F4|Rev O2|Rev O4|Rev P2|Rev P4|Rev T2|Rev T4|Rev Q2|Rev Q4";
    					HeadTitle2 += "|OFT|BAF|CAF|OTH|DTH|DOC|TAC|Others";
    					HeadTitle2 += "|TOS|1st VVD|On Board|Week|Code|Description|IB CNT|IB OFC|Origin|Dest.";
    					HeadTitle2 += "|Code|Name|Code|Name|OB RHQ|OB GSO|C/OFC|REP|RFA No.|S/C No.|BKG OFC|IB WK POD|IB WK";
    					
    					var headCount = ComCountHeadTitle(HeadTitle1);
    					
    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);

                        //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,		SAVENAME,	KEYFIELD,	CALCULOGIC,	DATAFORMAT,		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,	40,     daCenter,   true,   	"HidStatus");
    					InitDataProperty(0, cnt++ , dtSeq,      	30,		daCenter,	true,		"");
    					
                        InitDataProperty(0, cnt++ , dtData,		   	90,		daCenter,	true,		"bkg_no",      		false,          "",     dfNone,   		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	90,		daCenter,	true,		"bl_no",     		false,          "",     dfNone,   		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	40,		daCenter,	true,		"slan_cd",   		false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	100,	daCenter,	true,		"vvd",      		false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daCenter,	true,		"por_cd",      		false,          "",     dfNone,  		0,			false,       true);
                        
                        InitDataProperty(0, cnt++ , dtData,       	60,		daCenter,	true,		"pol_cd",    		false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daCenter,	true,		"pod_cd",    		false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daCenter,	true,		"del_cd",     		false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	40,		daCenter,	true,		"io",    			false,          "",     dfNone,  		0,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,		   	60,		daRight,	true,		"teu_ttl",      	false,          "",     dfFloat,   		2,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,		   	60,		daRight,	true,		"cntr_ttl",      	false,          "",     dfFloat,   		2,			false,       true);
    					
                        InitDataProperty(0, cnt++ , dtData,		   	80,		daRight,	true,		"tot_sum",      	false,          "",     dfFloat,   		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	80,		daRight,	true,		"rpb",     			false,          "",     dfFloat,   		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	120,	daLeft,		true,		"cust_nm",   		false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daCenter,	true,		"cust_cnt_cd",      false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daCenter,	true,		"ob_srep_cd",      	false,          "",     dfNone,  		0,			false,       true);
                        
                        InitDataProperty(0, cnt++ , dtData,       	60,		daCenter,	true,		"ob_sls_ofc_cd",    false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daCenter,	true,		"bkg_cgo_tp_cd",    false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"d2",     			false,          "",     dfFloat,  		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"d4",    			false,          "",     dfFloat,  		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"d5",    			false,          "",     dfFloat,  		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"d7",    			false,          "",     dfFloat,  		2,			false,       true);
                        
    					InitDataProperty(0, cnt++ , dtData,		   	60,		daRight,	true,		"r2",      			false,          "",     dfFloat,   		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,		   	60,		daRight,	true,		"r4",      			false,          "",     dfFloat,   		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,		   	60,		daRight,	true,		"r5",      			false,          "",     dfFloat,   		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"rd2",     			false,          "",     dfFloat,   		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"rd4",   			false,          "",     dfFloat,  		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"f2",      			false,          "",     dfFloat,  		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"f4",      			false,          "",     dfFloat,  		2,			false,       true);
                        
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"o2",    			false,          "",     dfFloat,  		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"o4",    			false,          "",     dfFloat,  		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"p2",     			false,          "",     dfFloat,  		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"p4",    			false,          "",     dfFloat,  		2,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,		   	60,		daRight,	true,		"t2",      			false,          "",     dfFloat,   		2,			false,       true);
    					
                        InitDataProperty(0, cnt++ , dtData,		   	60,		daRight,	true,		"t4",      			false,          "",     dfFloat,   		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"q2",     			false,          "",     dfFloat,   		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"q4",   			false,          "",     dfFloat,  		2,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"rev_d2",      		false,          "",     dfFloat,  		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"rev_d4",      		false,          "",     dfFloat,  		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"rev_d5",      		false,          "",     dfFloat,  		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"rev_d7",      		false,          "",     dfFloat,  		2,			false,       true);
                        
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"rev_r2",    		false,          "",     dfFloat,  		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"rev_r4",    		false,          "",     dfFloat,  		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"rev_r5",    		false,          "",     dfFloat,  		2,			false,       true);
                        
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"rev_rd2",    		false,          "",     dfFloat,  		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"rev_rd4",    		false,          "",     dfFloat,  		2,			false,       true);
                        
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"rev_f2",     		false,          "",     dfFloat,  		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"rev_f4",    		false,          "",     dfFloat,  		2,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,		   	60,		daRight,	true,		"rev_o2",      		false,          "",     dfFloat,   		2,			false,       true);
    					
                        InitDataProperty(0, cnt++ , dtData,		   	60,		daRight,	true,		"rev_o4",      		false,          "",     dfFloat,   		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"rev_p2",     		false,          "",     dfFloat,   		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"rev_p4",   		false,          "",     dfFloat,  		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"rev_t2",      		false,          "",     dfFloat,  		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"rev_t4",      		false,          "",     dfFloat,  		2,			false,       true);
                        
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"rev_q2",    		false,          "",     dfFloat,  		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"rev_q4",    		false,          "",     dfFloat,  		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"oft",     			false,          "",     dfFloat,  		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"baf",    			false,          "",     dfFloat,  		2,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,		   	60,		daRight,	true,		"caf",      		false,          "",     dfFloat,   		2,			false,       true);
    					
                        InitDataProperty(0, cnt++ , dtData,		   	60,		daRight,	true,		"oth",      		false,          "",     dfFloat,   		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"dth",     			false,          "",     dfFloat,   		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"doc",   			false,          "",     dfFloat,  		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"tac",      		false,          "",     dfFloat,  		2,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daRight,	true,		"r_other",      	false,          "",     dfFloat,  		2,			false,       true);
                       
                        InitDataProperty(0, cnt++ , dtData,       	60,		daCenter,	true,		"frt_term_cd",    	false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	90,		daCenter,	true,		"first_vvd",    	false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	90,		daCenter,	true,		"bl_obrd_dt",     	false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	50,		daCenter,	true,		"bl_obrd_wk",    	false,          "",     dfNone,  		0,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,		   	50,		daCenter,	true,		"rep_cmdt_cd",      false,          "",     dfNone,   		0,			false,       true);
    					
                        InitDataProperty(0, cnt++ , dtData,		   	120,	daLeft,		true,		"rep_cmdt_nm",      false,          "",     dfNone,   		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daCenter,	true,		"ibs_ofc_nt",     	false,          "",     dfNone,   		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daCenter,	true,		"ib_sls_ofc_cd",   	false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daCenter,	true,		"org_svc",      	false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daCenter,	true,		"dst_svc",      	false,          "",     dfNone,  		0,			false,       true);
                        
                        InitDataProperty(0, cnt++ , dtData,       	50,		daCenter,	true,		"cnnf_cd",    		false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	120,	daLeft,		true,		"cnnf_nm",    		false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	50,		daCenter,	true,		"forwarder_cd",    	false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	120,	daLeft,		true,		"forwarder_nm",    	false,          "",     dfNone,  		0,			false,       true);                        
                        InitDataProperty(0, cnt++ , dtData,       	50,		daCenter,	true,		"rhq",     			false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	50,		daCenter,	true,		"gso",    			false,          "",     dfNone,  		0,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,		   	50,		daCenter,	true,		"ctrt_ofc_cd",      false,          "",     dfNone,   		0,			false,       true);
    					
    					InitDataProperty(0, cnt++ , dtData,		   	60,		daCenter,	true,		"ctrt_srep_cd",     false,          "",     dfNone,   		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,		   	60,		daCenter,	true,		"rfa_no",      		false,          "",     dfNone,   		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daCenter,	true,		"sc_no",     		false,          "",     dfNone,   		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	60,		daCenter,	true,		"bkg_ofc_cd",   	false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	70,		daCenter,	true,		"ib_wk_pod_cd",     false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	30,		daCenter,	true,		"ib_wk",      		false,          "",     dfNone,  		0,			false,       true);
                        
                       /* InitDataProperty(0, cnt++ , dtData,       	0,		daCenter,	true,		"",    		false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	0,		daCenter,	true,		"",    		false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	0,		daCenter,	true,		"",     	false,          "",     dfNone,  		0,			false,       true);
                        InitDataProperty(0, cnt++ , dtData,       	0,		daCenter,	true,		"",    		false,          "",     dfNone,  		0,			false,       true);
*/

    					//CountPosition = 0;

                   }
                    break;
                                                                                        
            }
        }
      
      // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
         function processButtonClick(){
              /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
     	         var sheetObject1 = sheetObjects[0];
     	         var sheetObject2 = sheetObjects[1];
     	         var sheetObject3 = sheetObjects[2];
     	         var sheetObject4 = sheetObjects[3]; 
     	         var sheetObject5 = sheetObjects[4];
     	         var sheetObject6 = sheetObjects[5];
     	         var sheetObject7 = sheetObjects[6];
     	         var sheetObject8 = sheetObjects[7];	         	         
     	         var sheetObject9 = sheetObjects[8];
     			 var sheetObject10 = sheetObjects[9];
              /*******************************************************/
              var formObject = document.form;

         	try {
         		var srcName = window.event.srcElement.getAttribute("name");

                 switch(srcName) {

     		    	case "btn_Retrieve":
     		    		
     		    		/*1.General*/
     		    		if (ComGetObjValue(formObject.rep_knd) == "G"){
     		    			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     		    		/*2.By Route	*/
     		    		}else if (ComGetObjValue(formObject.rep_knd) == "R"){
     		    			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
     		    		/*3.By E/Q Type	*/
     		    		}else if (ComGetObjValue(formObject.rep_knd) == "E"){
     		    			doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);
     		    		/*4.By Sales Office	*/
     		    		}else if (ComGetObjValue(formObject.rep_knd) == "O"){
     		    			doActionIBSheet(sheetObjects[3],document.form,IBSEARCH);
     		    		/*5.By Rep Commodity*/	
     		    		}else if (ComGetObjValue(formObject.rep_knd) == "C"){
     		    			doActionIBSheet(sheetObjects[4],document.form,IBSEARCH);
     		    		/*6.By Shipper Code*/	
     		    		}else if (ComGetObjValue(formObject.rep_knd) == "M"){
     		    			doActionIBSheet(sheetObjects[5],document.form,IBSEARCH);
     		    		/*7.By Group Code	*/
     		    		}else if (ComGetObjValue(formObject.rep_knd) == "P"){
     		    			doActionIBSheet(sheetObjects[6],document.form,IBSEARCH);
     		    		/*8.By Sales Rep	*/
     		    		}else if (ComGetObjValue(formObject.rep_knd) == "S"){
     		    			doActionIBSheet(sheetObjects[7],document.form,IBSEARCH);
     		    		/*9.By I/B Control Office	*/
     		    		}else if (ComGetObjValue(formObject.rep_knd) == "I"){
     		    			doActionIBSheet(sheetObjects[8],document.form,IBSEARCH);
     		    		/*10.Data Download	*/
     		    		}else if (ComGetObjValue(formObject.rep_knd) == "D"){
     		    			doActionIBSheet(sheetObjects[9],document.form,IBSEARCH);
     		    		}
     		    		
     		        break;
     		        
     		    	case "btn_new":    		    		
     		    		ComResetAll();
     		    		comboObjects[6].index2 = 0;
     		    		var objs = document.all.item("reportKind");
     		    		
     		    		for (var i = 0 ; i < 9 ; i++){
     		    			if (i == 0){
     		    				objs[i].style.display = "Inline";
     		    			}else{
     		    				objs[i].style.display = "none";
     		    			}
     		    		}
     		    	break;
     		    	
     		    	case "btn_excel":
     		    		/*1.General*/
     		    		if (ComGetObjValue(formObject.rep_knd) == "G"){
     		    			sheetObjects[0].SpeedDown2Excel(-1);
     		    		/*2.By Route	*/
     		    		}else if (ComGetObjValue(formObject.rep_knd) == "R"){
     		    			sheetObjects[1].SpeedDown2Excel(-1);
     		    		/*3.By E/Q Type	*/
     		    		}else if (ComGetObjValue(formObject.rep_knd) == "E"){
     		    			sheetObjects[2].SpeedDown2Excel(-1);
     		    		/*4.By Sales Office	*/
     		    		}else if (ComGetObjValue(formObject.rep_knd) == "O"){
     		    			sheetObjects[3].SpeedDown2Excel(-1);
     		    		/*5.By Rep Commodity*/	
     		    		}else if (ComGetObjValue(formObject.rep_knd) == "C"){
     		    			sheetObjects[4].SpeedDown2Excel(-1);
     		    		/*6.By Shipper Code*/	
     		    		}else if (ComGetObjValue(formObject.rep_knd) == "M"){
     		    			sheetObjects[5].SpeedDown2Excel(-1);
     		    		/*7.By Group Code	*/
     		    		}else if (ComGetObjValue(formObject.rep_knd) == "P"){
     		    			sheetObjects[6].SpeedDown2Excel(-1);
     		    		/*8.By Sales Rep	*/
     		    		}else if (ComGetObjValue(formObject.rep_knd) == "S"){
     		    			sheetObjects[7].SpeedDown2Excel(-1);
     		    		/*9.By I/B Control Office	*/
     		    		}else if (ComGetObjValue(formObject.rep_knd) == "I"){
     		    			sheetObjects[8].SpeedDown2Excel(-1);
     		    		/*10.Data Download	*/
     		    		}else if (ComGetObjValue(formObject.rep_knd) == "D"){
     		    			sheetObjects[9].SpeedDown2Excel(-1);
     		    		}
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
         
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {

    						case IBSEARCH:      //조회
    							if(!validateForm(sheetObj,formObj,sAction)) return;
	    						
	    						sheetObj.WaitImageVisible = false;
 								ComOpenWait(true);
	    						
	    						formObj.f_cmd.value = SEARCH;   
	    						sheetObj.DoSearch("ESM_BKG_0632GS.do",FormQueryString(formObj));
	    						
	    						ComOpenWait(false);	
    																																																								
    						break;
    						
    						case COMMAND01:      // INIT
 						
		 						formObj.f_cmd.value = INIT;   
			   	        	    
	 							var searchXml = sheetObj.GetSearchXml("ESM_BKG_0632GS.do", FormQueryString(formObj));
	 							
	 							var sXml = searchXml.split("|$$|");
	 							/*
	 							comboObjects[0].InsertItem(0, "HNPH0073E",          "HNPH0073E");
	 							comboObjects[0].InsertItem(1, "HNBN0027E",          "HNBN0027E");
	 							comboObjects[0].InsertItem(1, "HNPH0063E",          "HNPH0063E");
	 							comboObjects[0].InsertItem(1, "KMAB0033W",          "KMAB0033W");
	 							comboObjects[0].InsertItem(1, "AEAF0049E",          "AEAF0049E");
	 							comboObjects[0].InsertItem(1, "HNLS0034W",          "HNLS0034W");
	 							*/
	 							//Booking Cargo Type Code
	 							ComBkgXml2ComboItem(sXml[0], formObj.bkg_cgo_tp_cd, "val", "desc");
	 							
	 							comboObjects[1].index2 = 0;
	 							
	 							//Sales Performance Report Kind Code
	 							//ComBkgXml2ComboItem(sXml[1], formObj.rep_knd, "val", "name");
	 							ComXml2ComboItem(sXml[1], formObj.rep_knd, "val", "desc");
	 							
	 							comboObjects[6].index2 = 0;
	 							
	 							//Sales Performance Group By Code
	 							//ComBkgXml2ComboItem(sXml[2], formObj.grp_by, "val", "name");
	 							ComXml2ComboItem(sXml[2], formObj.grp_by, "desc", "desc");
	 							//Service Mode Code >>> Origin
	 							ComBkgXml2ComboItem(sXml[3], formObj.org_svc_mod_cd, "val", "desc");
	 							//Service Mode Code >>> Dest
	 							ComBkgXml2ComboItem(sXml[3], formObj.dest_inlnd_svc_mod_cd, "val", "desc");
	 							//Service Route >>> Origin
	 							ComBkgXml2ComboItem(sXml[4], formObj.org_rout_cd, "val", "desc");
	 							//Service Route >>> Dest
	 							ComBkgXml2ComboItem(sXml[4], formObj.dest_rout_cd, "val", "desc");
	 							
	 							comboObjects[2].DeleteItem("XX"); 
	 							comboObjects[2].DeleteItem("YY"); 
	 							comboObjects[3].DeleteItem("XX");
	 							comboObjects[3].DeleteItem("YY");
	 							
	 						break;

            }
        }


        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	
        	if (formObj.vvd.Text == ''){
        		
        		ComShowCodeMessage("BKG00007");//VVD is not available !    		  
	      	   	formObj.vvd.focus();    		  
	      	   	return false;
        	}        	
        	
            return true;
        }
         

    	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    	{
    		with(sheetObj)
    		{
    			SumText(0, "Seq") = "";
    			SumText(0, "BKGPOD") = "G/Total";
    		}
    	}
    	
    	/**
		 * Report Kind OnChange Event
    	 */
    	function rep_knd_OnChange(comboObj,value,text){
    		var objs = document.all.item("reportKind");
    		var repKnd = "none|none|none|none|none|none|none|none|none|none".split("|");
    		//value = "D";
    		if (value == "G"){    			
    			repKnd[0] = "Inline";
    		}else if (value == "R"){
    			repKnd[1] = "Inline";
    		}else if (value == "E"){
    			repKnd[2] = "Inline";
    		}else if (value == "O"){
    			repKnd[3] = "Inline";
    		}else if (value == "C"){
    			repKnd[4] = "Inline";
    		}else if (value == "M"){
    			repKnd[5] = "Inline";
    		}else if (value == "P"){
    			repKnd[6] = "Inline";
    		}else if (value == "S"){
    			repKnd[7] = "Inline";
    		}else if (value == "I"){
    			repKnd[8] = "Inline";
    		}else if (value == "D"){
    			repKnd[9] = "Inline";
    		}
    		for (var i = 0 ; i < repKnd.length ; i++){
    			objs[i].style.display = repKnd[i];
    		}
    	}
		 
		 /**
		 * VVD Name Upper Event
    	 */
    	 function searchLane(vvd) {
    		 
			 var formObj  = document.form;
			 var sheetObj = sheetObjects[0];
			 
			 if (vvd.value == ""){
				 
				 formObj.slan_cd.value = "";
				 formObj.vvd_idx.value = "";				 
				 return;
			 }else if (vvd.value.length != 9){
				 
				 ComShowCodeMessage("BKG00145");//Please! Check your VVD.	
				 vvd.focus();
				 return;
			 }			 			
			 
			 formObj.f_cmd.value = SEARCH01;   
			 
			 var searchXml = sheetObj.GetSearchXml("ESM_BKG_0632GS.do" , FormQueryString(formObj));
			 
			 if (ComGetEtcData(searchXml,"lane") == "none"){
				 
				 ComShowCodeMessage("BKG00163");//VVD is NOT Registered
				 vvd.focus();
				 return;
			 }
			 
			 formObj.slan_cd.value = ComGetEtcData(searchXml,"lane");
			 formObj.vvd_idx.value = "1";
			 
			 var comboObj = comboObjects[0];
			 
			 comboObj.InsertItem(-1, vvd.value, vvd.value); 
			 comboObj.Index2 = comboObj.GetCount()-1;

			 fromObj.vvd.focus();			 
		 }
		 
		 /**
		  * VVD Combo Change Event
	      */
		 function vvd_OnChange(comboObj,value,text){
			 
			 var formObj  = document.form;
			 
			 var comIdx = text.split(",");

			 if (comIdx.length > 1){

				 formObj.vvd_sig.value = "";
				 formObj.slan_cd.value = "";
				 formObj.vvd_idx.value = comIdx.length;
			 }
		 }
		 
		 /**
	       * VVD Selection Inquiry Popup Open
	      */ 
	      function getVvds(){
	    	  
	    	  var param = ""
	    	  var pWin = ComOpenWindow("/hanjin/ESM_BKG_0753.do" + param,"open0753", "statebar=no,width=920,height=395,left=200,top=0");
	      }
	      
	      function clearVvds(){
	    	  document.form.vvd.RemoveAll();
		  }
	       
	      /**
		   * VVD Selection Inquiry Popup Value Import
		   */
	      function setVvds(vvds){
	    	  
			  var formObj = document.form;
	    	  var comboObj = comboObjects[0];
	    	  
	    	  ComClearCombo(formObj.rpt_nm);	    	  
	    	  
	    	  var arVvds = vvds.split(",");
	    	  
	    	  for (var i = 0 ; i < arVvds.length ; i++){
	    		  
	    		  comboObj.InsertItem(-1, arVvds[i], arVvds[i]);
	    	  }
	    	  
	    	  comboObj.Text2 = vvds;
	    	  
	    	  formObj.vvd_sig.value = "";
			  formObj.slan_cd.value = "";
			  formObj.vvd_idx.value = arVvds.length;
	      }
		   		 
    
	/* 개발자 작업  끝 */