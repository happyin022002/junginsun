/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESM_MAS_0140.js
*@FileTitle : Feeder Term
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 이연각
*@LastVersion : 1.0
* 2007-05-22 Lee Ho Ik
* 1.0 최초 생성
* 2009-08-03 전윤주 New Framework 적용
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.06.10 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 : 
*                  CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
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
     * @class ESM_MAS_0140 : ESM_MAS_0140 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0140() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setRetrieveAction      = setRetrieveAction;
    	
    }
    
 /* 개발자 작업	*/
 // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    /**
     * 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
     */
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
     */
    function processButtonClick(){
    	var sheetObject = sheetObjects[0];
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		switch(srcName) {
    			case "btng_RowAdd":
    				doActionIBSheet(sheetObject,formObject,IBINSERT);
    				break;	
    			case "btng_RowDel":
    				doActionIBSheet(sheetObject,formObject,IBDELETE);
    				break;							
    			case "btn_Reset":
    				doActionIBSheet(sheetObject,formObject,IBRESET);
                    loadPage();			
    				break;						    
    			case "btn_Retrieve":
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    				break;
    			case "btn_Save":
    				doActionIBSheet(sheetObject,formObject,IBSAVE);
    				break;					
    			case "btn_DownExcel":
    				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    				break;		
    			case "btn_LoadExcel":
    				doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
    				break;	    		
    			case "btn_Close":			
    				doActionIBSheet(sheetObject,formObject,-1);
    				break;	 									
    		} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage(OBJECT_ERROR);
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
     		ComConfigSheet (sheetObjects[i]);
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

      	if(sheetNo==1) {
      		with (sheetObj) {
      			SheetWidth = mainTable.clientWidth;//전체 너비 설정
      			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
      			MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
      			Editable = true;//전체Edit 허용 여부 [선택, Default false]
      			InitRowInfo( 2, 1, 1, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
      			InitColumnInfo(12, 3, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
      			InitHeadMode(true, true, true, true, true, true)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])

      			var HeadTitle  = "Sel.| |ACTIVITY\nGROUP CD|CALCULATION\nTERM CD|WATER\nTERM CD|WATER\nMODE FLAG|NODE\nSTEVEDORAGE RATIO|NODE\nTHROUGHPUT RATIO|NODE\nTERMINAL RATIO|NEXT NODE\nSTEVEDORAGE RATIO|NEXT NODE\nTHROUGHPUT RATIO|NEXT NODE\nTERMINAL RATIO" ;
      			var HeadTitle1 = "| |ACTIVITY\nGROUP CD|CALCULATION\nTERM CD|WATER\nTERM CD|WATER\nMODE FLAG|NODE\nSTEVEDORAGE RATIO|NODE\nTHROUGHPUT RATIO|NODE\nTERMINAL RATIO|NEXT NODE\nSTEVEDORAGE RATIO|NEXT NODE\nTHROUGHPUT RATIO|NEXT NODE\nTERMINAL RATIO" ;

      			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
      			InitHeadRow(0, HeadTitle,  true);	
      			InitHeadRow(1, HeadTitle1, true);	

      			//데이터속성	    [ROW, COL  , DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME               , KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
      			InitDataProperty(0  , cnt++, dtDelCheck, 50   , daCenter , false   , "dtDelCheck"         , false   , ""        ,	dfNone   ,	0        , true      ,	true  );								
      			InitDataProperty(0  , cnt++, dtStatus  , 30   , daCenter ,  true   , "ibflag"             , false   , ""        ,	dfNone   ,	0        , false     ,	false );								
      			InitDataProperty(0  , cnt++, dtData    , 100  , daCenter ,  true   , "cost_act_grp_cd"    , true    , ""        ,	dfNone   ,	0        , false     ,	true  );
                InitDataProperty(0  , cnt++, dtData    , 100  , daCenter ,  true   , "calc_term_cd"       , true    , ""        ,	dfNone   ,	0        , false     ,	true  );
                InitDataProperty(0  , cnt++, dtData    , 100  , daCenter ,  true   , "wtr_term_cd"        , true    , ""        ,	dfNone   ,	0        , false     ,	true  );
                InitDataProperty(0  , cnt++, dtData    , 100  , daCenter ,  true   , "wtr_mod_flg"        , true    , ""        ,	dfNone   ,	0        , false     ,	true  );                
                InitDataProperty(0  , cnt++, dtData    , 120  , daCenter ,  true   , "nod_stvg_rto"       , false   , ""        ,	dfNone   ,	0        , true      ,	true  );                                
                InitDataProperty(0  , cnt++, dtData    , 120  , daCenter ,  true   , "nod_thrp_rto"       , false   , ""        ,	dfNone   ,	0        , true      ,	true  );                                            
                InitDataProperty(0  , cnt++, dtData    , 120  , daCenter ,  true   , "nod_tml_rto"        , false   , ""        ,	dfNone   ,	0        , true      ,	true  );                                                        
                InitDataProperty(0  , cnt++, dtData    , 120  , daCenter ,  true   , "nxt_nod_stvg_rto"   , false   , ""        ,	dfNone   ,	0        , true      ,	true  );                                
                InitDataProperty(0  , cnt++, dtData    , 120  , daCenter ,  true   , "nxt_nod_thrp_rto"   , false   , ""        ,	dfNone   ,	0        , true      ,	true  );                                            
                InitDataProperty(0  , cnt++, dtData    , 120  , daCenter ,  true   , "nxt_nod_tml_rto"    , false   , ""        ,	dfNone   ,	0        , true      ,	true  );                                            

      			CountPosition	= 2 ;
      			style.height = GetSheetHeight(14) ;
      			HeadRowHeight = DataRowHeight;
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
     * Sheet관련 프로세스 처리
     */ 
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {
    		case IBINSERT:                  // 입력
    			sheetObj.DataInsert(-1);
    			break;	
    		case IBDELETE:                  // 삭제
    			formObj.f_cmd.value = MULTI;
    			sheetObj.RowDelete(sheetObj.SelectRow, false);
    			break;	   								
    		case IBRESET:                  // RESET
                sheetObj.reset();
    			break;		    
    		case IBSEARCH:		           //조회
    			// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
    			formObj.f_cmd.value = SEARCHLIST;
    			sheetObj.DoSearch4Post("ESM_MAS_0140GS.do", masFormQueryString(formObj));
    			ComOpenWait(false);
    			break;	
    		case IBSAVE:                  // 저장
    			// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
    			formObj.f_cmd.value = MULTI;
    			sheetObj.DoSave("ESM_MAS_0140GS.do", masFormQueryString(formObj), -1, true);
    			ComOpenWait(false);
    			break;					
           case IBDOWNEXCEL:            //엑셀 다운로드
    			//sheetObj.SpeedDown2Excel(-1, true, true);
    			var excelType = selectDownExcelMethod(sheetObj);
    			switch (excelType) {
    				case "AY":
    					sheetObj.Down2Excel(0, false, false, true, "", "", true);
    					break;
    				case "DY":
    					sheetObj.Down2Excel(-1, false, false, true, "", "", true);
    					break;
    				case "AN":
    					sheetObj.SpeedDown2Excel(0, false, false, "", "", true);
    					break;
    				case "DN":
    					sheetObj.SpeedDown2Excel(-1, false, false, "", "", true);
    					break;
    			}
    			break;	
    		case IBLOADEXCEL:                  // 엑셀로드
                sheetObj.LoadExcel(-1, 1, "", -1, -1, ""); 
    			break;	
    		case -1:                     // 창닫기 
    			window.close();
    			break;												
    	}	
    }

    /*화면이 로드 되면서 바로 retrieve 되도록 */
    function setRetrieveAction(){    	
    	sheetObject = sheetObjects[0];
    	formObject = document.form;
    	doActionIBSheet(sheetObject,formObject,IBSEARCH);
    }

	/* 개발자 작업  끝 */