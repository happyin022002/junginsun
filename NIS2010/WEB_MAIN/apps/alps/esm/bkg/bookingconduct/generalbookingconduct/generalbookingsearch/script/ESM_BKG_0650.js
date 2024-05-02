/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0650.js
*@FileTitle : Transhipment Route and VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.04.30 김병규
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
     * @class esm_bkg_0650 : esm_bkg_0650 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0650() {
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
    var tabCnt = 0 ;
    var beforetab = 1; 

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject = sheetObjects[0];
             var sheetObject1 = sheetObjects[1];

             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {
                    case "btn_Close":
    					window.close();
                        break;
                } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowCodeMessage("COM12111");
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
    		
       }

     	 function sheet1_OnLoadFinish(sheetObj) {   
    		 sheetObj.WaitImageVisible = false;   
    		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    		 sheetObj.WaitImageVisible = true;   
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
                        style.height = 140;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msAll;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 1, 1, 3, 100);

                        var HeadTitle = "|Seq.|POL|POL|POD|POD|VVD|Lane|POL ETD|POL ETD|POD ETD|POD ETD";
                        
                        var headCount = ComCountHeadTitle(HeadTitle);
                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(false, true, false, true, false,false);                
                        
                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,	 25,	  daCenter,		true,		  "ibflag");
                        InitDataProperty(0, cnt++ , dtData,    			 55,     daCenter,  	false,     "vsl_cd_seq",   false,          "",      dfNone,      	  	0,     	false,		false);
                        InitDataProperty(0, cnt++ , dtData,  		   	 65,     daCenter,    false,     "pol_cd",    		false,          "",      dfNone,      		0,     false,		false);
                        InitDataProperty(0, cnt++ , dtData,  		   	 44,     daCenter,    false,     "pol_yd_cd",    	false,          "",      dfNone,      		0,     false,		false);                        
                        InitDataProperty(0, cnt++ , dtData,    			 65,     daCenter,  	false,     "pod_cd",   		false,          "",      dfNone,      	  	0,     	false,		false);
                        InitDataProperty(0, cnt++ , dtData,    			 45,     daCenter,  	false,     "pod_yd_cd",   	false,          "",      dfNone,      	  	0,     	false,		false);                        
                        InitDataProperty(0, cnt++ , dtPopup,    	  	115,    daCenter,    false,     "vvd",   			false,          "",      dfNone,      	  	0,     	true,			false);
                        InitDataProperty(0, cnt++ , dtData,  		  	 50,     daCenter,  	false,     "slan_cd",    	false,          "",      dfNone,      		0,     false,		false);                                                                                                                                                                   
                        InitDataProperty(0, cnt++ , dtData,    			 70,    daCenter,  	false,     "etd",   			false,          "",      dfNone,   			0,     false,		false);
                        InitDataProperty(0, cnt++ , dtData,    			 40,    daCenter,  	false,     "etd_time",		false,          "",      dfNone,   			0,     false,		false);
                        InitDataProperty(0, cnt++ , dtData,    			 70,    daCenter,  	false,     "eta",   			false,          "",      dfNone,   			0,     false,		false);
                        InitDataProperty(0, cnt++ , dtData,    			 40,    daCenter,  	false,     "eta_time",		false,          "",      dfNone,   			0,     false,		false);
                        
                        //CountPosition = 0;						
                        ShowButtonImage = 2;
                   }
                    break;

            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {

              case IBSEARCH:      //조회
            	  formObj.f_cmd.value = SEARCH;		
    			  sheetObj.DoSearch("ESM_BKG_0650GS.do", FormQueryString(formObj));
              break;
            }
        }
        // 조회완료 후 데이터가 없는 Row는 지운다.
    	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    	{
    		for ( i = sheetObj.Rows-1 ; i > 0 ; i-- ){
    			if(sheetObj.CellValue(i, "vsl_cd_seq") == ""){    				
    				sheetObj.RowDelete(i,false);
    			}
    		}    		
    	}

        // VVD Popup 호출
    	function sheet1_OnPopupClick( sheetObj, Row, Col )
    	{
    		comBkgCallPop0019(	"",
    										sheetObj.CellValue(Row, "vvd"),
    										sheetObj.CellValue(Row, "pol_cd"),
    										sheetObj.CellValue(Row, "pod_cd"));
    	}
	/* 개발자 작업  끝 */