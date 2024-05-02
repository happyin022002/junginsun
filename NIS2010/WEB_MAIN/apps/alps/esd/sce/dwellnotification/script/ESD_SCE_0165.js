/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_SCE_0154.js
*@FileTitle : SCE
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.07
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2011.07.07 채창호
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
     * @author SM LINE
     */

    /**
     * @extends 
     * @class ESD_SCE_0165 : ESD_SCE_0165 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_SCE_0165() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.obj_keypress           = obj_keypress;
    }
    
   	/* 개발자 작업	*/
    var sheetObjects = new Array();
    var sheetCnt = 0;

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
                 } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
    				ComShowMessage(ComGetMsg('COM12111')) ;
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
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {
             var cnt = 0; 
           	 switch(sheetNo) {
             case 1:      //IBSheet1 init
                	 with (sheetObj) {
     	                // 높이 설정
     	                style.height = 250;
     	                //전체 너비 설정
     	                SheetWidth = mainTable.clientWidth;
     	
     	                //Host정보 설정[필수][HostIp, Port, PagePath]
     	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
     	
     	                //전체Merge 종류 [선택, Default msNone]
     	                MergeSheet = msHeaderOnly;
     	
     	               //전체Edit 허용 여부 [선택, Default false]
     	                Editable = true;
     	
     	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
     	                InitRowInfo( 1, 1, 10, 50);
     	
     	                var HeadTitle  = "|SEQ|CNTR No|BKG No|Send Date";
     	                var headCount = ComCountHeadTitle(HeadTitle);
     	                
     	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
     	                InitColumnInfo(headCount, 0, 0, true);
     	
     	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
     	                InitHeadMode(true, true, false, true, false,false);
     	
     	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
     					InitHeadRow(0, HeadTitle, true);
     	
     	                //데이터속성    [   ROW, COL,   DATATYPE,      WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
     	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,   daCenter, true, "ibflag");
     	                InitDataProperty(0, cnt++ , dtSeq,	    60,   daCenter, true, "seq"      ,   false, "", dfNone, 	  0, true, true , -1,false,true,"",true);
     	                InitDataProperty(0, cnt++ , dtData,     	170,  daCenter, true, "cntr_no",   false , "", dfNone, 	  0, false, false);
     	                InitDataProperty(0, cnt++ , dtData,     	170,  daCenter, true, "bkg_no",   false , "", dfNone, 	  0, false, false);
     	                InitDataProperty(0, cnt++ , dtData,     	170,  daCenter, true, "eml_snd_dt",   false , "", dfNone, 	  0, false, false);
     	               
     	               
     	            }
     	            break;  
                
            }
        }

   	 function initControl() {
		 axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
         axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
         axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);               
         axon_event.addListenerFormat('mousemove', 'obj_onmousemove', document.form);        
         axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
         axon_event.addListenerForm	('focusin',			'form_focusin',			document.form); //- 클릭시
 	     axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	 }
        
          //  ===================================================================================
    //  Axson Event Handler
    //  ===================================================================================
    /** 
     * Object 의 Keypress 이벤트핸들러 <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     */ 
    function obj_keypress(){
        var obj = event.srcElement;
        if(obj.dataformat == null) return;
        window.defaultStatus = obj.dataformat;
        switch(obj.dataformat){
            case "ymd": //날짜 입력하기
                ComKeyOnlyNumber(obj,"-"); 
                break;
            case "int": //숫자만 입력
            case "number": //숫자만 입력
                ComKeyOnlyNumber(obj);
                break;
            case "engup":
                ComKeyOnlyAlphabet('upper');
                break;
            case "uppernum":
                ComKeyOnlyAlphabet('uppernum');
                break;
            default:
                //ComKeyOnlyNumber(obj);
                break;
        }
    }
    
        /**
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {
            for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet(sheetObjects[i]);

                initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            var sheetObject = sheetObjects[0];               
            var formObject = document.form;
            initControl();
            doActionIBSheet(sheetObject,formObject,IBSEARCH);
         }

    	// Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {
            	case IBSEARCH:      //조회
        			formObj.f_cmd.value = SEARCH;
        	      	sheetObj.DoSearch4Post("ESD_SCE_0165GS.do", SceFrmQryString(formObj));
        	    break;
            }
        }
        
    	/**
    	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	 */
    	function validateForm(sheetObj,formObj,sAction){
    		 
  		  switch(sAction) {
  		  
    		  }   
    	}

    	 	/**
     	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     	 */
     	function validateFormRowDelete(sheetObj,formObj,sAction){
     			
                    
     	}

        /**
         * 컬럼 입력된값을 확인하여 조회를 해온다.
         * 
         */  
         function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        	 var formObject = document.form;
        		 }
         
	/* 개발자 작업  끝 */