/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0112.js
*@FileTitle : VVD Status
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이연각
*@LastVersion : 1.0
* 2009.09.08 박수훈
* 1.0 Creation
=========================================================
* History
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.14 이행지 FormQueryString =>masFormQueryString 변경
*/
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
     * @class ESM_MAS_0112 : ESM_MAS_0112 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0112() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.setSheetObject 		= setSheetObject;
    	this.sheet1_OnDblClick      = sheet1_OnDblClick;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setRetrieveAction 		= setRetrieveAction;
    }
    
 // 공통전역변수


    var sheetObjects = new Array();
    var sheetCnt = 0;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    	function processButtonClick(){
    		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    		var sheetObject = sheetObjects[0];
    	
    	var formObject = document.form;
    		
    		try {
    			var srcName = window.event.srcElement.getAttribute("name");
    		
    			switch(srcName) {
    				case "btn_Retrieve":
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;
    				
    				case "btn_Save":
    					doActionIBSheet(sheetObject,formObject,IBSAVE);
    					break;
    					
    				case "btn_Close":
    					window.close();
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
    				
    					SheetWidth = mainTable.clientWidth;				    //전체 너비 설정
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); 	 //Host정보 설정[필수][HostIp, Port, PagePath]
    					MergeSheet = msHeaderOnly; 	 	 	 	 	        //전체Merge 종류 [선택, Default msNone]
    					Editable = true; 	 	 	 	 	 			    //전체Edit 허용 여부 [선택, Default false]
    					InitRowInfo( 1, 1, 9, 100); 	 	 	 	 	 	//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100] 
    					InitColumnInfo(15, 0, 0, true); 	 	 	 	 	 	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false] 
    					InitHeadMode(true, true, false, true, false,false);	// 해더에서 처리할 수 있는 각종 기능을 설정한다  ;
    					var HeadTitle = "|RSLT_CD|STATUS|Year/Month|Week|AR CNFM.|DELT.|VVD|TRADE|REV. LANE|IOC|PORT|||";
    					InitHeadRow(0, HeadTitle, true); 	 	 	 	 	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					
            			//데이터속성	    [ROW, COL  , DATATYPE  , WIDTH, DATAALIGN, COLMERGE, SAVENAME               , KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]					
            			InitDataProperty(0  , cnt++, dtStatus  ,    30, daCenter , false   , "ibflag"               , false   , ""        ,	dfNone   ,	0         , false     ,	false );								        			
            			InitDataProperty(0  , cnt++, dtHidden  ,    90, daCenter , false   , "rslt_cd"              , false   , ""        ,	dfNone   ,	0         , false    );
            			InitDataProperty(0  , cnt++, dtData    ,    90, daCenter , false   , "rslt"                 , false   , ""        ,	dfNone   ,	0         , false    );
            			InitDataProperty(0  , cnt++, dtData    ,    70, daCenter , false   , "cost_yrmon"           , false   , ""        ,	dfNone   ,	0         , true     );        			
            			InitDataProperty(0  , cnt++, dtData    ,    50, daCenter , false   , "cost_wk"              , false   , ""        ,	dfNone   ,	0         , false    );        			        			
            			InitDataProperty(0  , cnt++, dtData    ,    60, daCenter , false   , "mon_tgt_flg"          , false   , ""        ,	dfNone   ,	0         , false    );        			
            			InitDataProperty(0  , cnt++, dtData    ,    40, daCenter , false   , "delt_flg"             , false   , ""        ,	dfNone   ,	0         , false    );        			        			
            			InitDataProperty(0  , cnt++, dtData    ,    90, daCenter , false   , "vvd"                  , false   , ""        ,	dfNone   ,	0         , false    );
            			InitDataProperty(0  , cnt++, dtData    ,    50, daCenter , false   , "trd_cd"               , false   , ""        ,	dfNone   ,	0         , false    );
            			InitDataProperty(0  , cnt++, dtData    ,    90, daCenter , false   , "rlane_cd"             , false   , ""        ,	dfNone   ,	0         , false    );
            			InitDataProperty(0  , cnt++, dtData    ,    50, daCenter , false   , "ioc_cd"               , false   , ""        ,	dfNone   ,	0         , false    );
            			InitDataProperty(0  , cnt++, dtData    ,    50, daCenter , false   , "lst_lodg_port_cd"     , false   , ""        ,	dfNone   ,	0         , false    );        			
            			InitDataProperty(0  , cnt++, dtHidden  ,    40, daCenter , false   , "vsl_cd"               , false   , ""        ,	dfNone   ,	0         , false    );        			
            			InitDataProperty(0  , cnt++, dtHidden  ,    40, daCenter , false   , "skd_voy_no"           , false   , ""        ,	dfNone   ,	0         , false    );        			        			
            			InitDataProperty(0  , cnt++, dtHidden  ,    40, daCenter , false   , "dir_cd"               , false   , ""        ,	dfNone   ,	0         , false    );        			        			
    					
    					CountPosition  = 2 ;
    					style.height = GetSheetHeight(15) ;				
    				}
    				break;
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
    	* 쉬트를 더블 클릭 했을 경우 팝업창을 띄워 준다.
    	*/
        function sheet1_OnDblClick(sheetObj , row, col){
            var vvd  = "";
            var classId = "COM_ENS_0B1";
            var param = "";
            if(sheetObj.ColSaveName(col) == "vvd"){ // VVV를 더블클릭했을 경우
              vvd = sheetObj.CellValue(row, "vvd");
              param = '?vvd_cd='+vvd+'&classId='+classId;
              ComOpenPopup("/hanjin/COM_ENS_0B1.do"+param, 630, 430, "", "0,0,1,1,1,1,1,1,1,1", true);
            }
        }
        
        /**
    	* Sheet관련 프로세스 처리
    	*/
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;

    		switch(sAction) {
    			case IBSEARCH:      //조회
    				// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
    				formObj.f_cmd.value = SEARCH;
    				sheetObj.DoSearch4Post("ESM_MAS_0112GS.do", masFormQueryString(formObj));
    				ComOpenWait(false);
    				break;
    			case IBSAVE:        //저장
    				// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
    				formObj.f_cmd.value = MULTI;
    				sheetObj.DoAllSave("ESM_MAS_0112GS.do", masFormQueryString(formObj));
    				ComOpenWait(false);
    				// 결과 Retrieve
    				setRetrieveAction()	
    				break;				
    		}
    	}
    	
    	/**
    	* 화면 로딩시 바로 Retrieve
    	*/
        function setRetrieveAction(){       
        	sheetObject = sheetObjects[0];
        	formObject = document.form;    	
        	doActionIBSheet(sheetObject,formObject,IBSEARCH);
        }	
        