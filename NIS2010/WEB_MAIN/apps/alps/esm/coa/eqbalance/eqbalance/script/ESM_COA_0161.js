/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESM_COA_161.js
*@FileTitle : ECC별 기여도 적용 위한 표준 단가 생성_MT 회송비 조회
*Open Issues :
*@LastModifyDate	: 2010.02.24
*@LastModifier 	: 이연각 
*   
*Change history : 
* 2008.09.03 전윤주 CSR No.N200808260006 EQ repo rule-set(Rlane setting을 From-To ECC setting으로)
* 2009.10.06 박수훈 0161화면 New FrameWork 적용
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.06.14 윤진영 CHM-200901719  UI표준처리 Check All check박스 추가
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
     * @class ESM_COA_0161 : ESM_COA_0161 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0161() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.setSheetObject 		= setSheetObject;
    	this.sheet1_OnChange        = sheet1_OnChange;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
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


             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

            	    case "btn_Retrieve":
        	            doActionIBSheet(sheetObject,formObject,IBSEARCH);

            	        break;

            	    case "btn_Close":
        	            window.close();
            	        break;


            	    case "btn_Save":
        	            doActionIBSheet(sheetObject,formObject,IBSAVE);
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
                case 1:      //sheet2 init
                    with (sheetObj) {
                        
                        SheetWidth = mainTable.clientWidth; //전체 너비 설정
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]                    
                        MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
                        Editable = true; //전체Edit 허용 여부 [선택, Default false]    
                        InitRowInfo(2, 1, 9, 100); //행정보설정[필수] [HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitColumnInfo(6, 0, 0, true); //컬럼정보설정[필수] [COLS,FROZENCOL,LEFTHEADCOLS=0,	FROZENMOVE=false]   
                        InitHeadMode(true, true, true, true, false,	false);  //해더에서 처리할 수 있는 각종 기능을 설정한다 ([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
                        var HeadTitle  = "|Sel.||RCC2|RCC|tree" ;
                        var HeadTitle1 = "|||RCC2|RCC|tree" ;
                        //해더행정보[필수][ROW,HEADTEXT,	ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0,  HeadTitle,  false);
                        InitHeadRow(1,  HeadTitle1, false);

                        //데이터속성    [ROW, COL,  	DATATYPE,   		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, 			CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, 	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, 	cnt++ , dtHiddenStatus,	30,    daCenter,  false,    "ibflag");
                        InitDataProperty(0, 	cnt++ , dtCheckBox,   	30,    daCenter,  false,    "del_repo_flg",   false,          "",       	dfNone,       0,      true,       true);
                        InitDataProperty(0, 	cnt++ , dtHidden,  	    30,    daCenter,  false,    "cost_yrmon",     false,          "",       	dfNone,       0,     false,       true);
                        InitDataProperty(0, 	cnt++ , dtHidden,       70,    daCenter,  false,    "rcc_cd",         false,          "",      		dfNone,       0,     false,       true);
                        InitDataProperty(0, 	cnt++ , dtData,       	70,    daCenter,  true,    "ecc_cd",         false,          "",      		dfNone,       0,     false,       true);
                        InitDataProperty(0,     cnt++ , dtHidden,       50,    daCenter,   true,    "slevel",         false,          "",           dfNone,       0,     false,       false);

                        InitTreeInfo("ecc_cd", "slevel", RgbColor(0,0,255), false);

                        CountPosition  = 0 ;
                        style.height = GetSheetHeight(12) ;
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
         * Level에 따른 체크 즉, 상위 레벨 체크 시 자동으로 하위 레벨 체크
         */
        function sheet1_OnChange (sheetObj, row , col, value ){
            if(sheetObj.CellValue(row,"slevel")==0) {
                row++;
                while(sheetObj.CellValue(row,"slevel")==1){
                    sheetObj.CellValue2(row,"del_repo_flg") = value;
                    row++;
                }
            }
        }
        
        /**
         * Sheet 관련 프로세스 처리
         */
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;

    		switch(sAction) {
    			case IBSEARCH:      //조회
    				if(!validateForm(sheetObj,formObj,sAction)) return false;
    				// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
    				formObj.f_cmd.value = SEARCH;
    				sheetObj.DoSearch4Post("ESM_COA_0161GS.do", coaFormQueryString(formObj));
    				ComOpenWait(false);
    				break;

    			case IBSAVE:        //저장
    				if(!validateForm(sheetObj,formObj,sAction))return false;
    				// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
    				formObj.f_cmd.value = MULTI;
    				sheetObj.DoAllSave("ESM_COA_0161GS.do", coaFormQueryString(formObj));
    				doActionIBSheet(sheetObj,formObj,IBSEARCH);
    				ComOpenWait(false);
    				break;

    			case IBCREATE:     // create
    			    if(!validateForm(sheetObj, formObj, sAction)) return false;
    			    // 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
    			    formObj.f_cmd.value = COMMAND01;
    			    sheetObj.DoSearch4Post("ESM_COA_0161GS.do", coaFormQueryString(formObj));
    			    ComOpenWait(false);
    			    break;

    			case IBDOWNEXCEL:        //엑셀 다운로드
    				var excelType = selectDownExcelMethod(sheetObj);
    				switch (excelType) {
    					case "AY":
    						sheetObj.Down2Excel(0, false, false, true);
    						break;
    					case "DY":
    						sheetObj.Down2Excel(-1, false, false, true);
    						break;
    					case "AN":
    						sheetObj.SpeedDown2Excel(0, false, false);
    						break;
    					case "DN":
    						sheetObj.SpeedDown2Excel(-1, false, false);
    						break;
    				}

    				break;
    		}
    	}


       /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
            	switch(sAction) {
            	case IBSAVE:
            		return ComShowConfirm(ComGetMsg('COA10070'))
            		break;
            	}
            	return true;
            }
        }
        
       
