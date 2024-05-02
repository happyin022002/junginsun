/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0144.js
*@FileTitle : Shipper Table
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 이중환
*@LastVersion : 1.1
* 2009.09.08 송호진
* 1.0 Creation
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.14 이중환 FormQueryString -> coaFormQueryString 변경
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
     * @class ESM_COA_0144 : ESM_COA_0144 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0144() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.setSheetObject 		= setSheetObject;
    	this.sendValue              = sendValue;
    	this.sheet1_OnDblClick      = sheet1_OnDblClick;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    
 // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

        /**
         *  버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
         */
        function processButtonClick(){
            var sheetObject = sheetObjects[0];
            var formObject = document.form;
            var srcName = window.event.srcElement.getAttribute("name");
        
            try {
                switch(srcName) {

                    case "btn_retrieve":
                        doActionIBSheet(sheetObject, formObject, IBSEARCH);
                        break;
                    
                    case "btn_confirm":
                        sendValue();
                        window.close();
                        break;
                    
                    case "btn_close":
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
            var sheetObject = sheetObjects[0];
            var formObject = document.form;
        
            for(i=0;i<sheetObjects.length;i++){
                //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
                //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            
            if(formObject.f_cust_cnt_cd.value != ""){
                doActionIBSheet(sheetObject,formObject,IBSEARCH);  // 데이타를 보기위해 바로 호출 (추후 삭제)
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
                        SheetWidth = mainTable1.clientWidth;                //전체 너비 설정
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                        MergeSheet = msHeaderOnly;                          //전체Merge 종류 [선택, Default msNone]
                        Editable = false;                                    //전체Edit 허용 여부 [선택, Default false]
                        InitRowInfo( 1, 1, 9, 100);                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitColumnInfo(7, 0, 0, true);                      //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitHeadMode(true, true, false, true, false,false); // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        var HeadTitle = "code|seq|name|modi_cust_cd|modi_cust_seq|rvis_cntr_cust_tp_cd|ofc_cd" ;
                        InitHeadRow(0, HeadTitle, false);                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        
                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++, dtData,      50,    daCenter,  true,     "cust_cnt_cd",            false,  "",   dfNone,   0,   false,  false);
                        InitDataProperty(0, cnt++, dtData,      70,    daCenter,  true,     "cust_seq",               false,  "",   dfNone,   0,   false,  false);
                        InitDataProperty(0, cnt++, dtData,      300,   daLeft,    true,     "cust_lgl_eng_nm",        false,  "",   dfNone,   0,   false,  false);
                        InitDataProperty(0, cnt++, dtHidden,      50,    daCenter,  true,     "modi_cust_cd",           false,  "",   dfNone,   0,   false,  false);
                        InitDataProperty(0, cnt++, dtHidden,      70,    daCenter,  true,     "modi_cust_seq",          false,  "",   dfNone,   0,   false,  false);
                        InitDataProperty(0, cnt++, dtHidden,      80,    daCenter,  true,     "rvis_cntr_cust_tp_cd",   false,  "",   dfNone,   0,   false,  false);
                        InitDataProperty(0, cnt++, dtHidden,      80,    daCenter,  true,     "ofc_cd",                 false,  "",   dfNone,   0,   false,  false);
                        
//                        SelectionMode = smSelectionList;
//                        MultiSelection = true;
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
        
        function sendValue(){
            var sheetObj = sheetObjects[0];
            var row = sheetObj.SelectRow;
            
            opener.document.form.txtShipper.value = sheetObj.CellValue(row, "cust_cnt_cd") + sheetObj.CellValue(row, "cust_seq");
        }
                        
        /**
         *  sheet1에서 선택된 정보를 sheet2에 추가한다.
         */
        function sheet1_OnDblClick(sheetObj , row, col , value) {
            sendValue();
            window.close();

        }
        
        /**
         * Sheet관련 프로세스 처리
         */ 
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            
            switch(sAction) {
                case IBSEARCH:      //조회
                    if(!validateForm(sheetObj,formObj,IBSEARCH)) return false;
                    // 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
                    formObj.f_cmd.value = SEARCHLIST01;
        		    //20100414 이중환, FormQueryString -> coaFormQueryString 변경
                    sheetObj.DoSearch4Post("ESM_COA_0144GS.do", coaFormQueryString(formObj));
                    ComOpenWait(false);
                    break;
            }
        }

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
                if(f_cust_cnt_cd.value == ""){
                    // [COM12114] : Country 를(을) 확인하세요.
                    ComShowMessage(ComGetMsg('COM12114','Country'));
                    f_cust_cnt_cd.focus();
                    return false;
                }
                
                if(f_cust_seq.value != "" && !ComIsNumber(f_cust_seq)){
                    // [COM12114] : Country 를(을) 확인하세요.
                    ComShowMessage(ComGetMsg('COM12178'));
                    f_cust_seq.focus();
                    return false;
                }
                
            }
            
            return true;
        }

