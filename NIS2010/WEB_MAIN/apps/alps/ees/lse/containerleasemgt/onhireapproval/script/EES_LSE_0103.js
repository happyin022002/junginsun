/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_LSE_0103.js
*@FileTitle : Requst List 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.29
*@LastModifier : 채창호
* 2013.07.29 채창호
* 1.0 Creation
* Change history  -------------------------------------------------------------------
     * No.   Ver.    Modifier         modifier date    explanation
     * 2013.08.13 채창호 [CHM-201325598]Split 02-EQR T/F 관련 LEGACY 연계 방안 및 일정
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
     * @class EES_LSE_0103 : EES_LSE_0103 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_LSE_0103() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
 
    // 공통전역변수
    var DoSearch_Sheet1 = false;
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var IBSEARCH01  = 30;
    var mainPage;
   

    // 버튼클릭이트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
            /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
            var sheetObject  = sheetObjects[0];
            var formObject = document.form;
            

        	try {
        		 var srcName = window.event.srcElement.getAttribute("name");
                 if(!ComIsBtnEnable(srcName) ) return;
                switch(srcName) {
                    
                    case "btn_select":
                    	comPopupOK();
                    break;

                    case "btn_downexcel":
                    break;
                        
                    case "btn_new":
                    break;
                    case "btn_print":
                    break;

                  } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			//("지금은 사용하실 수가 없습니다 ");
        			//ComShowMessage(OBJECT_ERROR);
        			ComShowMessage(ComGetMsg("EQR90004"));
        		} else {
        			//(e);
        			//ComShowMessage(e);
        			ComShowMessage(e);
        		}
        	}
        }

        /*
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
        function loadPage(mainpage) {
       	    mainPage = mainpage; 
            var formObject = document.form;
            var sheetObject  = sheetObjects[0];
            doActionIBSheet(sheetObject,formObject,IBSEARCH01);
            for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i]);
           initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        }


        /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;
            var title = "";
            var HeadTitle  = "Sel|SEQ|Req No|Date|LCC|Term|TOTAL|" + tpszname +"|Remark|titlelist|totallist|order year";
            var tpsztitle  = tpszname.split('|');
            switch(sheetNo) {
                case 1:      //t1sheet1 init
                  with (sheetObj) {
                    //세로높이설정
                    style.height= GetSheetHeight(12) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 1, 100);
                    var headCount = ComCountHeadTitle(HeadTitle);
                   //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                  	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                  	InitHeadMode(true, true, false, true, false,false)

                 //   var HeadTitle = "Sel|VVD|POL|POD|TOTAL|" //+title;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                	InitDataProperty(0, cnt++ , dtRadioCheck,  40,    daCenter,false,  "checkbox",    false,       "",      dfNone,        0,  true,     true);
                    InitDataProperty(0, cnt++ , dtSeq,       30,  daCenter,  false,   "seq",     false,       "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      180,  daCenter,  false,   "reqno",     false,       "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      90,  daCenter,  false,   "cre_dt",     false,       "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      75,  daCenter,  false,   "lcc",     false,       "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      75,  daCenter,  false,   "term",     false,       "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtAutoSum,   60,  daCenter,  false,   "total",   false,       "",       dfNone,    0,     false,       false);
                    for (var i=0 ; i< tpsztitle.length ; i++ ){
                    InitDataProperty(0, cnt++ , dtData,     45,  daCenter,  false,   "qty"+tpsztitle[i].toLowerCase(),     false,       "",       dfNone,    0,     false,       false);
                    }
                    InitDataProperty(0, cnt++ , dtData,     80,  daCenter,  false,   "remark",     false,       "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,     80,  daCenter,  false,   "titlelist",     false,       "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,     80,  daCenter,  false,   "totallist",     false,       "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,     80,  daCenter,  false,   "ord_yr",     false,       "",       dfNone,    0,     false,       false);
                    HeadRowHeight= 20;
                }

                break;
            }
        }



        // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {
                 case IBSEARCH:      //조회
                    formObj.f_cmd.value = SEARCHLIST;
                    formObj.titlelist.value  = tpszname;
                    sheetObj.DoSearch4Post("EES_LSE_0103GS.do", FormQueryString(formObj));
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
