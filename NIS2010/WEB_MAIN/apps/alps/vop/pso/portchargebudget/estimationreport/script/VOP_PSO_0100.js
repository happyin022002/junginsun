/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VOP_PSO_0100.js
*@FileTitle : VOP_PSO_0100
*Open Issues :
*Change history :
*2013-03-18 - S.K.Y

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
     * @class VOP_PSO_0100 : VOP_PSO_0100 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_PSO_0100() {
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
    var beforetab = 1;
    //sheetResizeFull = true;
    //type check
    var type_check;
    //retrive check
    var check_retrive = false;
    var tab_retrives = null;
    var searchParams = "";
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;



    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject = sheetObjects[0];
             var sheetObject1 = sheetObjects[1];
            /*******************************************************/
             var formObject = document.form;

       	//try {
        		var srcName = window.event.srcElement.getAttribute("name");
                   	
                     
                switch(srcName) {
                
                case "btns_calendar_s":
                	var cal = new ComCalendar();
                	cal.setDisplayType('month');
    	            cal.select(form.rev_yrmon, "yyyy-MM");
                	break;
                    
                case "btn_retrieve":
        	          doActionIBSheet(sheetObjects[beforetab],formObject,IBSEARCH);
        	            break;
        	     
        	            
    				case "btn_new":
    					
    					break;
    			
            	    case "btn_downexcel":
       	            	doActionIBSheet(sheetObjects[beforetab],formObject,IBDOWNEXCEL);
       	            	break;
     
    			} // end switch
        	
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
         * tab1_OnChange 
         * 
         */
        function tab1_OnChange(tabObj , nItem) {
        	var objs = document.all.item("tabLayer");
        	for(var i = 0 ; i < objs.length ; i++) {
        		objs[i].style.display = "none";
        	}
        	objs[nItem].style.display = "Inline";
        	beforetab = nItem;
        }
        
    	/**
    	 * 입력한 Office값 체크
  
        /**
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {
        	
        	
        	for(k=0;k<tabObjects.length;k++){
        		initTab(tabObjects[k],k+1);
        	}
        	
        	for (i = 0; i < sheetObjects.length; i++) {
        		ComConfigSheet(sheetObjects[i]);
        		initSheet(sheetObjects[i], i + 1);
        		ComEndConfigSheet(sheetObjects[i]);
        	}        	
        	
        	document.form.rev_yrmon.focus();
        	
        	 initControl();
        	
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
                        InsertTab( cnt++ , "By Revenue VVD" , -1 );
                        InsertTab( cnt++ , "By Processing VVD" , -1 );

                    }
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
        	
        	switch(sheetNo) {
        		case 1:      //sheet1 init
        			with (sheetObj) {
        				// 높이 설정
        				style.height = getSheetHeight(19);
//        				style.height = 100;
        				// 전체 너비 설정
        				SheetWidth = mainTable.clientWidth;
        				// Host정보 설정[필수][HostIp, Port, PagePath]
        				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
        				// 전체Merge 종류 [선택, Default msNone]
        				MergeSheet = msPrevColumnMerge;
        				// 전체Edit 허용 여부 [선택, Default false]
        				Editable = false;
//        				FocusEditMode = default_edit_mode;
        				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        				InitRowInfo( 1, 1, 8, 100);
        				// 해더에서 처리할 수 있는 각종 기능을 설정한다
        	       				
        				InitHeadMode(true, true, false, true, false,false)
        				var HeadTitle1 = "Rev.YRMON|LANE|VVD|TYPE|PORT|CANAL|Total PORT|";
        				
        				var headCount = ComCountHeadTitle(HeadTitle1);
        				 
//        				컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        				InitColumnInfo(headCount, 0, 0, true);
        				
        				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
        				InitHeadRow(0, HeadTitle1, true);
        				
        				// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
        				InitDataProperty(0, cnt++ , dtData  ,  90,   daCenter,  true ,     "rev_yrmon"      ,     false,         "",   dfNone    ,      0,     true,       true,          30, 	false, 		false);
        				InitDataProperty(0, cnt++ , dtData  ,  60,   daCenter,  true ,     "rlane_cd"       ,     false,         "",   dfNone    ,      0,     true,       true,          30, 	false, 		false);
        				InitDataProperty(0, cnt++ , dtData  ,  90,   daCenter,  true ,     "vvd"            ,     false,         "",   dfNone    ,      0,     true,       true,          30, 	false, 		false);
        				InitDataProperty(0, cnt++ , dtData  ,  60,   daCenter,  true ,     "estm_vvd_tp_cd" ,     false,         "",   dfNone    ,      0,     true,       true,          30, 	false, 		false);
        				InitDataProperty(0, cnt++ , dtAutoSumEx  ,  90,   daRight ,  true ,     "port_amt"       ,     false,         "",   dfFloat   ,      2,     true,       true,          30, 	false, 		dfNullFloat,	2);
        				InitDataProperty(0, cnt++ , dtAutoSumEx  ,  90,   daRight ,  true ,     "canal_amt"      ,     false,         "",   dfFloat   ,      2,     true,       true,          30, 	false, 		dfNullFloat,	2);
        			    InitDataProperty(0, cnt++ , dtAutoSumEx  ,  90,   daRight ,  true ,     "total_amt"      ,     false,         "",   dfFloat   ,      2,     true,       true,          30,   false, 		dfNullFloat,	2);
        				InitDataProperty(0, cnt++ , dtData  ,   1,   daLeft  ,  false,     ""               ,     false,         "",   dfNone    ,      0,     true,       true,          30, 	false, 		false);
        				HeadRowHeight = 20 ;
        				
        				CountPosition = 0;
        			}
        			break;
        		
        		case 2:      //sheet1 init
        			with (sheetObj) {
        				// 높이 설정
        			
        				style.height = getSheetHeight(19);
        				// 전체 너비 설정
        				SheetWidth = mainTable.clientWidth;
        				// Host정보 설정[필수][HostIp, Port, PagePath]
        				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
        				// 전체Merge 종류 [선택, Default msNone]
        				MergeSheet = msPrevColumnMerge;
        				// 전체Edit 허용 여부 [선택, Default false]
        				Editable = false;
//        				FocusEditMode = default_edit_mode;
        				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        				InitRowInfo( 1, 1, 8, 100);
        				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        				
        				InitHeadMode(true, true, false, true, false,false)
        				var HeadTitle1 = "Rev.YRMON|LANE|VVD|TYPE|PORT|CANAL|Total PORT|";
        				
        				var headCount = ComCountHeadTitle(HeadTitle1);
        				 
//        				컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        				InitColumnInfo(headCount, 0, 0, true);
        				
        				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
        				InitHeadRow(0, HeadTitle1, true);
        				
        				
        				// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
        				InitDataProperty(0, cnt++ , dtData  ,  90,   daCenter,  true ,     "rev_yrmon"      ,     false,         "",   dfNone    ,      0,     true,       true,          30, 	false, 		false);
        				InitDataProperty(0, cnt++ , dtData  ,  60,   daCenter,  true ,     "rlane_cd"       ,     false,         "",   dfNone    ,      0,     true,       true,          30, 	false, 		false);
        				InitDataProperty(0, cnt++ , dtData  ,  90,   daCenter,  true ,     "vvd"            ,     false,         "",   dfNone    ,      0,     true,       true,          30, 	false, 		false);
        				InitDataProperty(0, cnt++ , dtData  ,  60,   daCenter,  true ,     "estm_vvd_tp_cd" ,     false,         "",   dfNone    ,      0,     true,       true,          30, 	false, 		false);
        				InitDataProperty(0, cnt++ , dtAutoSumEx  ,  90,   daRight ,  true ,     "port_amt"       ,     false,         "",   dfFloat   ,      2,     true,       true,          30, 	false, 		dfNullFloat,	2);
        				InitDataProperty(0, cnt++ , dtAutoSumEx  ,  90,   daRight ,  true ,     "canal_amt"      ,     false,         "",   dfFloat   ,      2,     true,       true,          30, 	false, 		dfNullFloat,	2);
        			    InitDataProperty(0, cnt++ , dtAutoSumEx  ,  90,   daRight ,  true ,     "total_amt"      ,     false,         "",   dfFloat   ,      2,     true,       true,          30,   false, 		dfNullFloat,	2);
        				InitDataProperty(0, cnt++ , dtData  ,   1,   daLeft  ,  false,     ""               ,     false,         "",   dfNone    ,      0,     true,       true,          30, 	false, 		false);
        				HeadRowHeight = 20 ;
        				
        			   CountPosition = 0;
        			}
        			break;
        	}
        }
    	
    	   	

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;		
    		
            switch(sAction) {
    			
               case IBSEARCH:      //조회
            		var sheetObj  = sheetObjects[0];
        			var sheetObj1 = sheetObjects[1];
        
       	  		    formObj.f_cmd.value = SEARCH;
       	  	
        			
        			if(beforetab == 0)
        				formObj.estm_vvd_tp_cd.value = "1";
        			else if(beforetab == 1){
        				formObj.estm_vvd_tp_cd.value = "2";
        			}
        			
        			var sParam = FormQueryString(formObj);
        			
           			var sXml = sheetObjects[beforetab].GetSearchXml("VOP_PSO_0100GS.do", sParam);
        			
        			var arrXml = sXml.split("|$$|");
        			
       				if(beforetab == 0)
        				sheetObjects[0].LoadSearchXml(arrXml[0]);
        			else if(beforetab == 1){
        				sheetObjects[1].LoadSearchXml(arrXml[0]);
        			}
       				
       	        	
    			break;
    	
               case IBDOWNEXCEL:        //엑셀 다운로드              
               
            	   
            	   if (sheetObjects[0].RowCount <= 0  || sheetObjects[1].RowCount <= 0) {
					alert( "There is no related data!");
						return;
            	   }		
  				sheetObjects[0].Down2Excel(-1,false,true,false,"","",false,false,"대상항차");
  				sheetObjects[1].Down2Excel(-1,true,true,false,"","",false,false,"진행항차");
                  break;
            }
        }
    	
        /**
         * Tab 클릭시 이벤트 관련
         * 선택한 탭의 요소가 활성화 된다.
         */
        function tab1_OnChange(tabObj , nItem) {
        	var objs = document.all.item("tabLayer");
        	for(var i = 0 ; i < objs.length ; i++) {
        		objs[i].style.display = "none";
        	}
        	objs[nItem].style.display = "Inline";
        	beforetab = nItem;
        }  	
    	
         	
       	
    	/* 개발자 작업  끝 */