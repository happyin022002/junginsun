/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0070.js
*@FileTitle : Estimate Report - Account
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.08 함대성
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
     * @class FNS_JOO_0070 : FNS_JOO_0070 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_JOO_0070() {
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
    var tabObjects = new Array();
    var tabCnt = 0;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;

    //New button click시에 IBCombo들의 change이벤트를 타지 못하도록 하기 위함
    var gNew = false;
    var gCurRow = 0;
    var prefix = "";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];

    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var cal = new ComCalendar();
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch (srcName) {
			case "btns_back":
		    	sheetObjects[0].RemoveAll();
				if (formObject.exe_yrmon.value!=""){
					formObject.exe_yrmon.value = ComGetDateAdd(formObject.exe_yrmon.value+"-01","M",-1).substring(0,7);
				}
				break;
	
			case "btns_next":
				sheetObjects[0].RemoveAll();
				if (formObject.exe_yrmon.value!=""){
					formObject.exe_yrmon.value = ComGetDateAdd(formObject.exe_yrmon.value+"-01","M", 1).substring(0,7);
				}
				break;
  
    		case "btn_retrieve":
    			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
    			break;
    			
			case "btns_calendar1": //달력버튼
				cal.setDisplayType('date');
	         	cal.select(formObject.from_dt, 'yyyy-MM-dd');
	        break;
	        
			case "btns_calendar2": //달력버튼
				cal.setDisplayType('date');
	     		cal.select(formObject.to_dt, 'yyyy-MM-dd');
	     	break;
    			
    		case "btn_new":
    			sheetObject1.RemoveAll();
    			formObject.jo_crr_cd   .index = -1;
    			setDate();
    		break;

    		case "btn_save":
    			doActionIBSheet(sheetObject1, formObject, IBSAVE);
    		break;

    		case "btn_downExcel":
    		    var url = ComJooGetPgmTitle(sheetObject1, "center", 10);
    		     
    		 	sheetObject1.SpeedDown2Excel(-1, false,false, "", url);

    		break;
    		} // end switch
    	} catch (e) {
    		if (e == "[object Error]") {
    			ComShowCodeMessage('JOO00001');
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    
  	function setDate(){
  		var today=new Date();
  		var y = today.getFullYear().toString();
  		var m = today.getMonth()+1;
  		var d = today.getDate();

  		if(m<10){
  			m = "0"+m;
  		}
  		
  		document.form.from_dt.value = y+"-"+m+"-"+d;
  		document.form.to_dt.value = y+"-"+m+"-"+d;
 	}

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj) {
    	sheetObjects[sheetCnt++] = sheet_obj;
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage(crrCombo) {

     	for (i = 0; i < sheetObjects.length; i++) {

     		//khlee-시작 환경 설정 함수 이름 변경
     		ComConfigSheet(sheetObjects[i]);

     		initSheet(sheetObjects[i], i + 1);
     		//khlee-마지막 환경 설정 함수 추가
     		ComEndConfigSheet(sheetObjects[i]);
     	}

     	//combo 초기화
     	for(var k=0;k<comboObjects.length;k++){
     	    initCombo(comboObjects[k], k+1, crrCombo);
     	}

     	initControl();
     	
     } 
 
     /**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects 배열에서 순번
      **/
     function initControl() {
     	//** Date 구분자 **/
     	DATE_SEPARATOR = "-";
     	var formObject = document.form;
 
        //Axon 이벤트 처리1. 이벤트catch
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); 			 
    	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    	axon_event.addListenerForm('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
 
     }

      //Axon 이벤트 처리2. 이벤트처리함수
      function obj_deactivate(){
          ComChkObjValid(event.srcElement);
      }
      
      function obj_activate(){
          ComClearSeparator(event.srcElement);
      }
     	 
      function from_dt_keypress(){
        	ComKeyOnlyNumber(this, '');
      }
      
      function to_dt_keypress(){
      	ComKeyOnlyNumber(this, '');
    }
      
  
  	// 업무 자바스크립트 OnKeyPress 이벤트 처리
  	function obj_keypress() {
 
  		switch(event.srcElement.dataformat){
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
  	           //영문 대문자만 입력하기
  	           ComKeyOnlyAlphabet('upper');
                
  	           break;
  	       case "int":
  	           //숫자만입력하기(정수,날짜,시간)
  	           ComKeyOnlyNumber(event.srcElement);
  	           break;
  	       case "uppernum":
  	           //영문 대문자+숫자
  	           ComKeyOnlyAlphabet('uppernum'); 
  	           break;
  	       case "tel":
  		        // 숫자+"-"입력하기
  		        ComKeyOnlyNumber(event.srcElement, "-"); 
  		        break;
  	       case "ymd":
  	    	    
  	    	    //ComKeyOnlyNumber(event.srcElement, "-"); 
  	       case "hm":
  	    	    ComKeyOnlyNumber(event.srcElement);
  	    	    break;
  		}
  	} 

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {

    	var cnt = 0;

    	switch (sheetNo) {
    	case 1: //t1sheet1 init
    		with (sheetObj) {  
    			
            // 높이 설정
            style.height = 430;
           
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = false;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "Letter No.|User ID|Carrier|Send Office|Letter Status|Save Date|";
            var headCount = ComCountHeadTitle(HeadTitle1);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false)

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);

            //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,		DATAALIGN,		COLMERGE,		SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//            InitDataProperty(0, cnt++ , dtHiddenStatus,		0,			daCenter,		true,			"Status");
				InitDataProperty(0, cnt++ , dtData,			130,		daCenter,		true,			prefix+"jo_ltr_no",			false,          "",      dfNone,      0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,			130,		daCenter,		true,			prefix+"cre_usr_id",			false,          "",      dfNone,      0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,			130,		daCenter,		true,			prefix+"jo_crr_cd",			false,          "",      dfNone,      0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,			130,		daCenter,		true,			prefix+"ofc_cd",			false,          "",      dfNone,      0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,			130,		daCenter,		true,			prefix+"jo_ltr_tp_cd",			false,          "",      dfNone,      0,     true,       true);

				InitDataProperty(0, cnt++ , dtData,			130,		daCenter,		true,			prefix+"cre_dt",			false,          "",      dfNone,      0,     true,       true);
				InitDataProperty(0, cnt++ , dtHidden,       130,        daCenter,       true,           prefix+"jo_ltr_seq",            false,          "",      dfNone,      0,     true,       true);
				 
			
			CountPosition = 0;
            DataLinkMouse("jo_ltr_no") = true;
            DataLinkMouse("cre_usr_id") = true;
            
   		} 
    		break;

    	}
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch (sAction) { 
    	
    	case IBSEARCH: //조회
    		if (validateForm(sheetObj, formObj, sAction)){
    			
    			formObj.f_cmd.value = SEARCH;
 
    			var sXml = sheetObj.GetSearchXml("FNS_JOO_0070GS.do", FormQueryString(formObj) );
    			
    			var arrXml = sXml.split("|$$|");
    			sheetObj.LoadSearchXml(arrXml[0]);
                sheetObj.ColFontUnderline("jo_ltr_no") = true;
                sheetObj.ColFontUnderline("cre_usr_id") = true;    
    		}
    		break; 
    		 		
    	}
    }

    /**
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
  // combo object 초기화
     function initCombo(comboObj, comboNo, crrCombo) {
         var formObject = document.form

         switch(comboNo) {  
         	case 1: 
                with (comboObj) { 
     				MultiSelect = false; 
     				UseAutoComplete = true;	
     				SetColAlign("left|left");        
     				SetColWidth("0|30");
      				DropHeight = 160;
      		    }
                 var comboItems = crrCombo.split("|");
                 addComboItem(comboObj, comboItems);           	
      			break; 
      			
         	case 2: 
                 with (comboObj) { 
      				MultiSelect = false; 
      				UseAutoComplete = true;	
      				SetColAlign("left|left");        
      				SetColWidth("0|30");
       				DropHeight = 160;
       		    }
       			break; 

         	case 3: 
                 with (comboObj) { 
      				MultiSelect = false; 
      				UseAutoComplete = true;	
      				SetColAlign("left|left");        
      				SetColWidth("0|30");
       				DropHeight = 160;
       		    }
       			break; 
         } 
     }

    // 조회조건필드인 Lane SVC Type 데이터 조회
    function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH: //TRADE
 
    														
    	        break;
        }
    }
 
    function jo_crr_cd_OnChange(idx_cd, text){
    	sheetObjects[0].RemoveAll();
    }
       
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction) {
    	with (formObj) {
    		switch(sAction){
    			case IBSEARCH:
    				var fr = from_dt.value;
    				var to = to_dt.value;
    				
    				if (fr ==""){
    					ComShowCodeMessage();
    					from_dt.focus();
    					return false;
    				}
    				if (ComGetDaysBetween(fr+"-01", to+"-01") < 0){
    					ComShowCodeMessage("JOO00078");
    					to_dt.focus();
    					return false;
    				}
    				break;
    				
        		case IBSAVE:   //저장
                break;
    			if (cnt==0){
    				ComShowMessage("There is no data to save");
    				return false;
    			}
    			break;
    		}
    	}

    	return true;
    } 
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
        if ( sheetObj.ColSaveName(Col) == "jo_ltr_no" ){
            var jo_ltr_seq = sheetObj.CellValue(Row, "jo_ltr_seq");
            var jo_ltr_tp_cd = sheetObj.CellValue(Row, "jo_ltr_tp_cd");
            if ( jo_ltr_tp_cd == "MCS" ){
                location.href = "/hanjin/FNS_JOO_0060.do?pgmNo=FNS_JOO_0060&jo_ltr_seq="+jo_ltr_seq;
            }else if ( jo_ltr_tp_cd == "Invoice" ){
                location.href = "/hanjin/FNS_JOO_0062.do?pgmNo=FNS_JOO_0062&jo_ltr_seq="+jo_ltr_seq;
            }
        }else if ( sheetObj.ColSaveName(Col) == "cre_usr_id" ){
            ComUserPopup(Value);
        }
    }
    

	/* 개발자 작업  끝 */