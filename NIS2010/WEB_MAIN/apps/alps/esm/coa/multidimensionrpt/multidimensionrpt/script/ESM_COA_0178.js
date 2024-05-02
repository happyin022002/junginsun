/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_COA_0178.js
*@FileTitle : IAS 협의체별 Scop 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.20
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.08.20 김기종
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
     * @class ESM_COA_0178 : ESM_COA_0178 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0178() {
    	this.processButtonClick		= processButtonClick;
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

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

        /**
         *  버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
         */
        function processButtonClick(){
            var sheetObject = sheetObjects[0];
            var sheetObject1 = sheetObjects[1];
            var formObject = document.form;
            
            try {
                var srcName = window.event.srcElement.getAttribute("name");
                switch(srcName) {
                    case "btn_retrieve":
                        doActionIBSheet(sheetObject,formObject,IBSEARCH);
                        break;
                    
                    case "btn_save":
                        doActionIBSheet(sheetObject,formObject,IBSAVE);
                        break;
                    
                    case "btn_add":
                        doActionIBSheet(sheetObject,formObject,IBINSERT);
                        break;
                    
                    case "btn_close":
                        window.close();
                        break;
                    case "btn_DownExcel":
                    	sheetObject.SpeedDown2Excel(-1);
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
            	ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
                //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }

        /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt = 0;
            with (sheetObj) {
            	// 높이 설정
                style.height = 300;
                style.height = GetSheetHeight(15);                   //전체 너비 설정
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                MergeSheet = msHeaderOnly;                                  //전체Merge 종류 [선택, Default msNone]
                Editable = true;                                            //전체Edit 허용 여부 [선택, Default false]
                InitRowInfo( 1, 1, 9, 100);                                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitColumnInfo(8, 0 , 0, true);                             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitHeadMode(false, false, false, true, false,false) ;      //해더에서 처리할 수 있는 각종 기능을 설정한다

                var HeadTitle0 = "|DEL|SUB|BKG POL|PKG POD|REMARK|USER ID|UPDATE DT";
     
                InitHeadRow(0, HeadTitle0, true);                            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                
                //데이터속성[         ROW,     COL,    DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,       KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,    FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX]
                InitDataProperty(     0,       cnt++,  dtHiddenStatus,   30,      daCenter,   false,     "ibflag",         false,      "",        dfNone,       0,         false,      false);
                InitDataProperty(     0,       cnt++,  dtDelCheck, 30,      daCenter,   false,     "delflag",        false,      "",        dfNone,       0,         true,       true);
                InitDataProperty(     0,       cnt++,  dtData,     60,     daCenter,   false,     "ias_sub_cd",     true,       "",        dfEngUpKey,   0,         false,      true,       4,     true);
                InitDataProperty(     0,       cnt++,  dtData,     80,     daCenter,   false,     "pol_cnt_cd",     true,       "",        dfEngUpKey,   0,         true,       true,       2);
                InitDataProperty(     0,       cnt++,  dtData,     80,     daCenter,   false,     "pod_cnt_cd",     true,       "",        dfEngUpKey,   0,         true,       true,       2);
                InitDataProperty(     0,       cnt++,  dtData,    200,     daLeft,     false,     "cd_rmk",         false,       "",        dfNone,		 0,         true,       true,       500);
                InitDataProperty(     0,       cnt++,  dtData,     80,     daCenter,   false,     "upd_usr_id",     false,       "",        dfNone,   0,         false,       false);
                InitDataProperty(     0,       cnt++,  dtData,     80,     daCenter,   false,     "upd_dt",     	false,       "",        dfNone,   0,         false,       false);
                //CountPosition  = 0 ;
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
                    sheetObj.DoSearch4Post("ESM_COA_0178GS.do", coaFormQueryString(formObj));
                    
                    ComOpenWait(false);
                    break;
                
                case IBSAVE:        //저장
                
	                var rowM = sheetObjects[0].ColValueDup("ias_sub_cd|pol_cnt_cd|pod_cnt_cd");
					if (rowM >= 0) {
						 var msg = ComGetMsg("COM131301");
						 msg += "\n----------------------------------";
						 msg += "\nSUB CODE: " + sheetObjects[0].CellValue(rowM, "ias_sub_cd");
						 msg += "\nBKG POL : " + sheetObjects[0].CellValue(rowM, "pol_cnt_cd");
						 msg += "\nPKG POD : " + sheetObjects[0].CellValue(rowM, "pod_cnt_cd");
						 msg += "\n----------------------------------";
						 alert(msg);
						 return false;
				    }	 
                	// 업무처리중 버튼사용 금지 처리
    				sheetObj.WaitImageVisible = false;
    				ComOpenWait(true);
                    formObj.f_cmd.value = MULTI;
                    sheetObj.DoSave("ESM_COA_0178GS.do", FormQueryString(formObj));
					
                    ComOpenWait(false);
                    break;
    		   
                case IBINSERT:      //입력
                    sheetObj.DataInsert(-1);
                    break;
    			
            }
         }
	/* 개발자 작업  끝 */