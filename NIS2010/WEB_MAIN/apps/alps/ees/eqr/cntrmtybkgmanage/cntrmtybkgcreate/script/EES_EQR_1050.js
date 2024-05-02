/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_EQR_1050.js
*@FileTitle : Empty ROB Bkg VVD List
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.07
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2013.03.07 신용찬
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class EES_EQR_1050 : EES_EQR_1050 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_EQR_1050() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.closeWindow			= closeWindow;
    }
    
    var sheetObjects = new Array();
    var sheetCnt = 0;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             var sheetObject = sheetObjects[0];       
             var formObject = document.form;

            try {
                var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {
                
              	    case "btn_downexcel":

              	    	if(sheetObject.RowCount > 0) doActionIBSheet(sheetObject, formObject,IBDOWNEXCEL);
              	    	else                         ComShowCodeMessage("EQR90039");

            	        break;                        

                } // end switch
            }catch(e) {
                if( e == "[object Error]") {
                    ComShowCodeMessage("EQR90004");
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
            
                ComConfigSheet(sheetObjects[i]); //khlee-시작 환경 설정 함수 이름 변경
                initSheet(sheetObjects[i],i+1);            
                ComEndConfigSheet(sheetObjects[i]); //khlee-마지막 환경 설정 함수 추가
            }
                    
            var sheetObject = sheetObjects[0];               
            var formObject = document.form;  
            
            // 조회쿼리 가동
            doActionIBSheet(sheetObject,document.form,IBSEARCH);
    		   	  
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
                        style.height = 160;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = false;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 1, 1, 9, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(6, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, true, true, false,false)
                        
                        var HeadTitle0 = "DIV|VVD|POL Yard|ETD|POD Yard|ETB" ;

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle0, true);
                        //InitHeadRow(1, HeadTitle1, false);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "vsl_pre_pst_cd",  false,          "",       dfNone,       0,     false,       false );
                        InitDataProperty(0, cnt++ , dtData,       100,    daCenter,  true,    "vvd",   			false,          "",       dfNone,       0,     false,       false );
                        InitDataProperty(0, cnt++ , dtData,       100,    daCenter,  true,    "pol_yd_cd",       false,          "",       dfNone,       0,     false,       false );
                        InitDataProperty(0, cnt++ , dtData,       120,    daCenter,  true,    "etd",    			false,          "",       dfNone,       0,     false,       false );
                        InitDataProperty(0, cnt++ , dtData,       100,    daCenter,  true,    "pod_yd_cd",   	false,          "",       dfNone,       0,     false,       false );
                        InitDataProperty(0, cnt++ , dtData,       120,    daCenter,  true,    "etb", 			false,          "",       dfNone,       0,     false,       false );

                   }
                    break;
            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {

               case IBSEARCH:      //조회
           				sheetObj.WaitImageVisible  = true ;            	   
                        formObj.f_cmd.value = SEARCHLIST;
                        sheetObj.DoSearch4Post("EES_EQR_1050GS.do", eqrFormQryStr(formObj));
                        
                     	sheetObj.Visible = true;
                     	//sheetObj.ExtendLastCol = false;                    
                    break;
                    
               case IBDOWNEXCEL:
                   sheetObj.Down2Excel(-1, false, false, true);
                   break;                    

            }
        }  	
    	   	
    	/* 현재창 닫기
    	*/
    	function closeWindow() {
      		self.close();
    	}    	   	
        
